package services.controls;

import gui.MainGUI;
import gui.panels.PanelCenterInner.PanelComment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import services.LoadDatabase;
import services.QueryModel;

public class CommentAction {

	private LoadDatabase loadDatabase;
	private QueryModel queryModel;

	private JTree treeMap;
	private JTable tableCenter;
	private JButton buttonUpdate;
	private JTextArea taComment;

	public CommentAction(MainGUI mainFrame, LoadDatabase loadDatabase,
			QueryModel queryModel) {
		this.loadDatabase = loadDatabase;
		this.queryModel = queryModel;

		treeMap = mainFrame.getPanelLeft().getTreeMap();
		tableCenter = mainFrame.getPanelCenter().getTableCenter();

		PanelComment panelComment = mainFrame.getPanelCenter()
				.getPanelComment();
		buttonUpdate = panelComment.getButtonUpdate();
		taComment = panelComment.getTaComment();
	}

	public void addCommentAction() {
		addTreeMapListener();
		addTableCenterListener();
		addButtonUpdateAction();
	}

	private void addTreeMapListener() {
		treeMap.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				buttonUpdate.setEnabled(false);
				taComment.setEditable(false);
				taComment.setText("");
			}
		});
	}

	private void addTableCenterListener() {
		tableCenter.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (!e.getValueIsAdjusting()) {
							if (tableCenter.getSelectedRow() > -1) {
								buttonUpdate.setEnabled(true);
								taComment.setEditable(true);

								String ReferenceID = tableCenter.getValueAt(
										tableCenter.getSelectedRow(), 0)
										.toString();

								ResultSet rsComment = loadDatabase.convertDatabaseToResultSet(queryModel
										.getQueryGetComment(ReferenceID));

								String Comment = null;
								try {
									if (rsComment.next()) {
										Comment = rsComment.getString(1);
									}
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								taComment.setText(Comment);
							}
						}
					}
				});
	}

	private void addButtonUpdateAction() {
		buttonUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String ReferenceID = tableCenter.getValueAt(
						tableCenter.getSelectedRow(), 0).toString();
				loadDatabase.updateDatabase(queryModel.getQueryUpdateComment(
						ReferenceID, taComment.getText()));
			}
		});
	}
}

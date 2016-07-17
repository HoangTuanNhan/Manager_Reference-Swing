package services.controls.toolbarAction;

import gui.MainGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import services.LoadDatabase;
import services.QueryModel;

public class ButtonAttachAction {

	private MainGUI mainFrame;
	private LoadDatabase loadDatabase;
	private QueryModel queryModel;

	private JTree treeMap;
	private JTable tableCenter;
	private JButton buttonAttachFile;

	public ButtonAttachAction(MainGUI mainFrame, LoadDatabase loadDatabase,
			QueryModel queryModel) {
		this.mainFrame = mainFrame;
		this.loadDatabase = loadDatabase;
		this.queryModel = queryModel;

		treeMap = mainFrame.getPanelLeft().getTreeMap();
		tableCenter = mainFrame.getPanelCenter().getTableCenter();
		buttonAttachFile = mainFrame.getToolBar().getButtonAttachFile();
	}

	public void addAction() {
		addTreeMapListener();
		addTableCenterListener();
		addButtonAttachAction();
	}

	private void addTreeMapListener() {
		treeMap.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				buttonAttachFile.setEnabled(false);
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
								buttonAttachFile.setEnabled(true);
							}
						}
					}
				});
	}

	private void addButtonAttachAction() {
		buttonAttachFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String path = getFilePath();
				if (path != null) {
					mainFrame.getPanelRight().getPanelAttachFileTab()
							.getController().openDocument(path);

					String ReferenceID = tableCenter.getValueAt(
							tableCenter.getSelectedRow(), 0).toString();

					loadDatabase.updateDatabase(queryModel
							.getQueryUpdateAttachPath(ReferenceID, path));
				}
			}
		});
	}

	private String getFilePath() {
		String filename = null;
		String dir = null;
		JFileChooser fileChooser = new JFileChooser();

		int rVal = fileChooser.showOpenDialog(null);
		if (rVal == JFileChooser.APPROVE_OPTION) {
			filename = fileChooser.getSelectedFile().getName();
			dir = fileChooser.getCurrentDirectory().toString();
			return dir + "\\" + filename;
		} else {
			return null;
		}
	}
}

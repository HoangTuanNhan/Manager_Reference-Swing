package gui.panels;

import gui.panels.PanelCenterInner.PanelComment;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelCenter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable tableCenter;
	private PanelComment panelComment;

	public PanelCenter() {
		LoadMain();
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(tableCenter), BorderLayout.CENTER);
		
		panelComment = new PanelComment();
		this.add(panelComment, BorderLayout.SOUTH);
	}

	private void LoadMain() {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		ArrayList<String> arrayColumns = new ArrayList<>();
		arrayColumns.add("ID");
		arrayColumns.add("Author");
		arrayColumns.add("Year");
		arrayColumns.add("Title");
		arrayColumns.add("Type");
		arrayColumns.add("PathAttach");
		arrayColumns.add("Pages");
		defaultTableModel.setColumnIdentifiers(arrayColumns.toArray());
		tableCenter = new JTable(defaultTableModel);
		tableCenter.setAutoResizeMode(0);
	}

	public JTable getTableCenter() {
		return tableCenter;
	}

	public PanelComment getPanelComment() {
		return panelComment;
	}
}

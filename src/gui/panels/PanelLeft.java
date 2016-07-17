package gui.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class PanelLeft extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTree treeMap;

	public PanelLeft() {
		treeMap = new JTree();
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(treeMap), BorderLayout.CENTER);
	}

	public JTree getTreeMap() {
		return treeMap;
	}
}

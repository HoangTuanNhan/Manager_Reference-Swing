package gui.panels.PanelRightInner;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelPreviewTab extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextArea taReferenceSelected;

	public PanelPreviewTab() {

		/**
		 * panel panelNoReferenceSelected hiển thị khi không có Reference nào
		 * được chọn
		 */
		JTextArea taNoReferenceSelected = new JTextArea("No Reference Selected!");
		taNoReferenceSelected.setEditable(false);
		JPanel panelNoReferenceSelected = new JPanel(new BorderLayout());
		panelNoReferenceSelected.add(taNoReferenceSelected, BorderLayout.CENTER);

		/**
		 * panel panelReferenceSelected hiển thị preview Reference được chọn
		 */
		taReferenceSelected = new JTextArea();
		taReferenceSelected.setEditable(false);
		taReferenceSelected.setAutoscrolls(true);
		taReferenceSelected.setLineWrap(true);
		JPanel panelReferenceSelected = new JPanel(new BorderLayout());
		panelReferenceSelected.add(taReferenceSelected, BorderLayout.CENTER);

		/**
		 * thêm 2 panel trên với CardLayout
		 */
		this.setLayout(new CardLayout());
		this.add("0", panelNoReferenceSelected);
		this.add("1", panelReferenceSelected);
	}

	public JTextArea getTaReferenceSelected() {
		return taReferenceSelected;
	}
}

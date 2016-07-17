package gui.panels.PanelRightInner;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class PanelAttachFileTab extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	SwingController controller;

	public PanelAttachFileTab() {

		/**
		 * panel panelNoReferenceSelected hiển thị khi không có Reference nào
		 * được chọn
		 */
		JTextArea taNoReferenceSelected = new JTextArea("No Reference Selected!");
		taNoReferenceSelected.setEditable(false);
		JPanel panelNoReferenceSelected = new JPanel(new BorderLayout());
		panelNoReferenceSelected.add(taNoReferenceSelected, BorderLayout.CENTER);

		/**
		 * panel panelReferenceSelected hiển thị file đính kèm của Reference
		 * được chọn
		 */
		controller = new SwingController();
		SwingViewBuilder factory = new SwingViewBuilder(controller);
		JPanel panelReferenceSelected = new JPanel(new BorderLayout());
		panelReferenceSelected.add(new JScrollPane(factory.buildViewerPanel()), BorderLayout.CENTER);

		/**
		 * thêm 2 panel trên với CardLayout
		 */
		this.setLayout(new CardLayout());
		this.add("0", panelNoReferenceSelected);
		this.add("1", panelReferenceSelected);
	}

	public SwingController getController() {
		return controller;
	}
}

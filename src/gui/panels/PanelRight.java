package gui.panels;

import gui.panels.PanelRightInner.PanelAttachFileTab;
import gui.panels.PanelRightInner.PanelPreviewTab;
import gui.panels.PanelRightInner.PanelReferenceDetailTab;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class PanelRight extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PanelReferenceDetailTab panelReferenceDetailTab;
	PanelPreviewTab panelPreviewTab;
	PanelAttachFileTab panelAttachFileTab;

	public PanelRight() {
		init();
	}

	private void init() {
		panelReferenceDetailTab = new PanelReferenceDetailTab();
		panelPreviewTab = new PanelPreviewTab();
		panelAttachFileTab = new PanelAttachFileTab();

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Reference", panelReferenceDetailTab);
		tabbedPane.addTab("Preview", panelPreviewTab);
		ImageIcon imageIcon = new ImageIcon("icon/icon_PDF.png");
		tabbedPane.addTab("Attach", imageIcon, panelAttachFileTab);

		this.setLayout(new BorderLayout());
		this.add(tabbedPane, BorderLayout.CENTER);
	}

	public PanelReferenceDetailTab getPanelReferenceDetailTab() {
		return panelReferenceDetailTab;
	}

	public PanelPreviewTab getPanelPreviewTab() {
		return panelPreviewTab;
	}

	public PanelAttachFileTab getPanelAttachFileTab() {
		return panelAttachFileTab;
	}
}

package gui.panels.PanelCenterInner;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelComment extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel labelTitle;
	private JButton buttonUpdate;
	private JTextArea taComment;

	public PanelComment() {
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		init();
	}

	private void init() {
		labelTitle = new JLabel("Comment");
		buttonUpdate = new JButton("Update");
		taComment = new JTextArea();
		taComment.setWrapStyleWord(true);
		taComment.setLineWrap(true);
		taComment.setRows(8);
		
		buttonUpdate.setEnabled(false);
		taComment.setEditable(false);
		
		JPanel panelTitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelTitle.add(labelTitle, FlowLayout.LEFT);
		panelTitle.add(buttonUpdate, FlowLayout.CENTER);

		JPanel panelComment = new JPanel(new BorderLayout());
		panelComment.add(new JScrollPane(taComment), BorderLayout.CENTER);

		this.add(panelTitle, BorderLayout.NORTH);
		this.add(panelComment, BorderLayout.CENTER);
	}

	public JButton getButtonUpdate() {
		return buttonUpdate;
	}

	public JTextArea getTaComment() {
		return taComment;
	}

}

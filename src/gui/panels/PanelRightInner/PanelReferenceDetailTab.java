package gui.panels.PanelRightInner;

import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelBookDetail;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelConferenceProceedingsDetail;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelJournalArticleDetail;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelReportDetail;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelThesisDetail;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelReferenceDetailTab extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JComboBox<String> comboBoxType;

	private PanelBookDetail panelBookDetail;
	private PanelReportDetail panelReportDetail;
	private PanelJournalArticleDetail panelJournalArticleDetail;
	private PanelConferenceProceedingsDetail panelConferenceProceedingsDetail;
	private PanelThesisDetail panelThesisDetail;
	private JPanel panelReferenceSelectedCenter;
	private JButton buttonSave;

	public PanelReferenceDetailTab() {

		/**
		 * panel panelNoReferenceSelected hiển thị khi không có Reference nào
		 * được chọn
		 */
		JTextArea taNoReferenceSelected = new JTextArea("No Reference Selected!");
		taNoReferenceSelected.setEditable(false);
		JPanel panelNoReferenceSelected = new JPanel(new BorderLayout());
		panelNoReferenceSelected.add(taNoReferenceSelected, BorderLayout.CENTER);

		/**
		 * panel panelReferenceSelected hiển thị chi tiết Reference được chọn
		 */

		// comboBoxType hiện thị các kiểu Reference
		JLabel label = new JLabel("Reference Type:");
		String listItem[] = { "Book", "Report", "Journal Article", "Conference Proceedings", "Thesis" };
		comboBoxType = new JComboBox<>(listItem);
		// button Save lưu thông tin chỉnh sửa hoặc tạo mới reference
		buttonSave = new JButton("Save");
		
		JPanel panelReferenceSelectedNorth = new JPanel(new FlowLayout());
		// thêm label vào panelReferenceSelectedNorth
		panelReferenceSelectedNorth.add(label);
		// thêm comboBoxType vào panelReferenceSelectedNorth
		panelReferenceSelectedNorth.add(comboBoxType);
		// thêm buttonSave vào panelReferenceSelectedNorth
		panelReferenceSelectedNorth.add(buttonSave);

		// panelReferenceSelectedCenter hiển thị tương ứng với kiểu Reference
		panelBookDetail = new PanelBookDetail();
		panelReportDetail = new PanelReportDetail();
		panelJournalArticleDetail = new PanelJournalArticleDetail();
		panelConferenceProceedingsDetail = new PanelConferenceProceedingsDetail();
		panelThesisDetail = new PanelThesisDetail();

		panelReferenceSelectedCenter = new JPanel(new CardLayout());
		panelReferenceSelectedCenter.add("Book", panelBookDetail);
		panelReferenceSelectedCenter.add("Report", panelReportDetail);
		panelReferenceSelectedCenter.add("Journal Article", panelJournalArticleDetail);
		panelReferenceSelectedCenter.add("Conference Proceedings", panelConferenceProceedingsDetail);
		panelReferenceSelectedCenter.add("Thesis", panelThesisDetail);

		JPanel panelReferenceSelected = new JPanel(new BorderLayout());
		panelReferenceSelected.add(panelReferenceSelectedNorth, BorderLayout.NORTH);
		panelReferenceSelected.add(new JScrollPane(panelReferenceSelectedCenter), BorderLayout.CENTER);

		this.setLayout(new CardLayout());
		this.add("0", panelNoReferenceSelected);
		this.add("1", panelReferenceSelected);
	}

	public PanelBookDetail getPanelBookDetail() {
		return panelBookDetail;
	}

	public PanelReportDetail getPanelReportDetail() {
		return panelReportDetail;
	}

	public PanelJournalArticleDetail getPanelJournalArticleDetail() {
		return panelJournalArticleDetail;
	}

	public PanelConferenceProceedingsDetail getPanelConferenceProceedingsDetail() {
		return panelConferenceProceedingsDetail;
	}

	public PanelThesisDetail getPanelThesisDetail() {
		return panelThesisDetail;
	}

	public JComboBox<String> getComboBoxType() {
		return comboBoxType;
	}

	public JPanel getPanelReferenceSelectedCenter() {
		return panelReferenceSelectedCenter;
	}

	public JButton getButtonSave() {
		return buttonSave;
	}

}

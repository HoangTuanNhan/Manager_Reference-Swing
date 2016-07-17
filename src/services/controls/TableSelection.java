package services.controls;

import gui.panels.PanelRight;
import gui.panels.PanelRightInner.PanelReferenceDetailTab;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelBookDetail;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelConferenceProceedingsDetail;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelJournalArticleDetail;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelReportDetail;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelThesisDetail;

import java.awt.CardLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import services.LoadDatabase;
import services.QueryModel;

/**
 * update panelRight from tableCenter Changed Selection
 */
public class TableSelection {

	JTable tableCenter;
	PanelRight panelRight;
	LoadDatabase loadDatabase;
	QueryModel queryModel;

	public TableSelection(JTable tableCenter, PanelRight panelRight,
			LoadDatabase loadDatabase, QueryModel queryModel) {
		this.tableCenter = tableCenter;
		this.panelRight = panelRight;
		this.loadDatabase = loadDatabase;
		this.queryModel = queryModel;
	}

	/**
	 * update performed
	 */
	public void update() {
		tableCenter.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (!e.getValueIsAdjusting()) {
							if (tableCenter.getSelectedRow() > -1) {
								updatePanelAttachFileTab(); // update
															// PanelAttachFileTab
								updatePanelPreviewTab(); // update update
															// PanelPreviewTab
								updatePanelReferenceDetailTab(); // update
																	// PanelPreviewTab
							}
						}
					}
				});
	}

	/**
	 * update PanelAttachFileTab from tableCenter Changed Selection
	 */
	private void updatePanelAttachFileTab() {
		CardLayout cardLayout = (CardLayout) panelRight.getPanelAttachFileTab()
				.getLayout();
		cardLayout.show(panelRight.getPanelAttachFileTab(), "1");

		String ReferenceID = tableCenter.getValueAt(
				tableCenter.getSelectedRow(), 0).toString();
		ResultSet rs = loadDatabase.convertDatabaseToResultSet(queryModel
				.getQueryPathOfReference(ReferenceID));
		String path = null;
		try {
			rs.next();
			path = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (path != null) {
			panelRight.getPanelAttachFileTab().getController()
					.openDocument(path);
		} else {
			panelRight.getPanelAttachFileTab().getController().closeDocument();
		}
	}

	/**
	 * update PanelPreviewTab from tableCenter Changed Selection
	 */
	private void updatePanelPreviewTab() {
		CardLayout cardLayout = (CardLayout) panelRight.getPanelPreviewTab()
				.getLayout();
		cardLayout.show(panelRight.getPanelPreviewTab(), "1");

		StringBuilder sbInfoPreviewer = new StringBuilder();
		for (int i = 0; i < tableCenter.getColumnCount(); i++) {
			switch (tableCenter.getColumnName(i)) {
			case "Author":
				sbInfoPreviewer.append(tableCenter.getValueAt(
						tableCenter.getSelectedRow(), i).toString());
				break;
			case "Year":
				if (tableCenter.getValueAt(tableCenter.getSelectedRow(), i) != null) {
					sbInfoPreviewer
							.append(" (")
							.append(tableCenter.getValueAt(
									tableCenter.getSelectedRow(), i).toString())
							.append("). ");
				}
				break;
			case "Title":
				sbInfoPreviewer
						.append(" \"")
						.append(tableCenter.getValueAt(
								tableCenter.getSelectedRow(), i).toString())
						.append(".\" ");
				break;
			default:
				break;
			}
		}
		panelRight.getPanelPreviewTab().getTaReferenceSelected()
				.setText(sbInfoPreviewer.toString());
	}

	/**
	 * update PanelReferenceDetailTab from tableCenter Changed Selection
	 */
	private void updatePanelReferenceDetailTab() {
		PanelReferenceDetailTab panel = panelRight.getPanelReferenceDetailTab();
		CardLayout cardLayout = (CardLayout) panel.getLayout();
		cardLayout.show(panel, "1");

		JComboBox<String> comboBoxType = panel.getComboBoxType();

		PanelBookDetail panelBookDetail = panel.getPanelBookDetail();
		PanelReportDetail panelReportDetail = panel.getPanelReportDetail();
		PanelJournalArticleDetail panelJournalArticleDetail = panel
				.getPanelJournalArticleDetail();
		PanelConferenceProceedingsDetail panelConferenceProceedingsDetail = panel
				.getPanelConferenceProceedingsDetail();
		PanelThesisDetail panelThesisDetail = panel.getPanelThesisDetail();

		String ReferenceID = tableCenter.getValueAt(
				tableCenter.getSelectedRow(), 0).toString();
		ResultSet rsID = loadDatabase.convertDatabaseToResultSet(queryModel
				.getQueryTypeOfReference(ReferenceID));

		String typeName = null;
		try {
			rsID.next();
			typeName = new String(rsID.getString(1));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		switch (typeName) {
		case "Book":
			comboBoxType.setSelectedItem("Book");
			ResultSet rsBook = loadDatabase
					.convertDatabaseToResultSet(queryModel
							.getQueryInfoReference(ReferenceID));

			try {
				rsBook.next();
				for (int i = 1; i <= rsBook.getMetaData().getColumnCount(); i++) {
					String field = rsBook.getMetaData().getColumnName(i);
					switch (field) {
					case "Author":
						panelBookDetail.getTaAuthor().setText(
								rsBook.getString(i));
						break;
					case "Year":
						panelBookDetail.getTaYear()
								.setText(rsBook.getString(i));
						break;
					case "Title":
						panelBookDetail.getTaTitle().setText(
								rsBook.getString(i));
						break;
					case "SeriesEditor":
						panelBookDetail.getTaSeriesEditor().setText(
								rsBook.getString(i));
						break;
					case "SeriesTitle":
						panelBookDetail.getTaSeriesTitle().setText(
								rsBook.getString(i));
						break;
					case "PlacePublished":
						panelBookDetail.getTaPlacePublished().setText(
								rsBook.getString(i));
						break;
					case "Publisher":
						panelBookDetail.getTaPublisher().setText(
								rsBook.getString(i));
						break;
					case "Volume":
						panelBookDetail.getTaVolume().setText(
								rsBook.getString(i));
						break;
					case "NumberOfVolumes":
						panelBookDetail.getTaNumberOfVolumes().setText(
								rsBook.getString(i));
						break;
					case "SeriesVolume":
						panelBookDetail.getTaSeriesVolume().setText(
								rsBook.getString(i));
						break;
					case "NumberOfPages":
						panelBookDetail.getTaNumberOfPages().setText(
								rsBook.getString(i));
						break;
					case "Pages":
						panelBookDetail.getTaPages().setText(
								rsBook.getString(i));
						break;
					case "Editor":
						panelBookDetail.getTaEditor().setText(
								rsBook.getString(i));
						break;
					case "Edition":
						panelBookDetail.getTaEdition().setText(
								rsBook.getString(i));
						break;
					case "Date":
						panelBookDetail.getTaDate()
								.setText(rsBook.getString(i));
						break;
					case "TypeOfWork":
						panelBookDetail.getTaTypeOfWork().setText(
								rsBook.getString(i));
						break;
					case "Translator":
						panelBookDetail.getTaTranslator().setText(
								rsBook.getString(i));
						break;
					case "ShortTitle":
						panelBookDetail.getTaShortTitle().setText(
								rsBook.getString(i));
						break;
					case "Abbreviation":
						panelBookDetail.getTaAbbreviation().setText(
								rsBook.getString(i));
						break;
					case "ISBN":
						panelBookDetail.getTaISBN()
								.setText(rsBook.getString(i));
						break;
					case "DOI":
						panelBookDetail.getTaDOI().setText(rsBook.getString(i));
						break;
					case "OriginalPublication":
						panelBookDetail.getTaOriginalPublication().setText(
								rsBook.getString(i));
						break;
					case "ReprintEdition":
						panelBookDetail.getTaReprintEdition().setText(
								rsBook.getString(i));
						break;
					case "TitlePrefix":
						panelBookDetail.getTaTitlePrefix().setText(
								rsBook.getString(i));
						break;
					case "Reviewer":
						panelBookDetail.getTaReviewer().setText(
								rsBook.getString(i));
						break;
					case "AccessionNumber":
						panelBookDetail.getTaAccessionNumber().setText(
								rsBook.getString(i));
						break;
					case "CallNumber":
						panelBookDetail.getTaCallNumber().setText(
								rsBook.getString(i));
						break;
					case "Label":
						panelBookDetail.getTaLabel().setText(
								rsBook.getString(i));
						break;
					case "Keywords":
						panelBookDetail.getTaKeywords().setText(
								rsBook.getString(i));
						break;
					case "Abstract":
						panelBookDetail.getTaAbstract().setText(
								rsBook.getString(i));
						break;
					case "ResearchNotes":
						panelBookDetail.getTaResearchNotes().setText(
								rsBook.getString(i));
						break;
					case "URL":
						panelBookDetail.getTaURL().setText(rsBook.getString(i));
						break;
					case "AuthorAddress":
						panelBookDetail.getTaAuthorAddress().setText(
								rsBook.getString(i));
						break;
					case "Figure":
						panelBookDetail.getTaFigure().setText(
								rsBook.getString(i));
						break;
					case "Caption":
						panelBookDetail.getTaCaption().setText(
								rsBook.getString(i));
						break;
					case "AccessDate":
						panelBookDetail.getTaAccessDate().setText(
								rsBook.getString(i));
						break;
					case "TranslatedAuthor":
						panelBookDetail.getTaTranslatedAuthor().setText(
								rsBook.getString(i));
						break;
					case "TranslatedTitle":
						panelBookDetail.getTaTranslatedTitle().setText(
								rsBook.getString(i));
						break;
					case "NameOfDatabase":
						panelBookDetail.getTaNameOfDatabase().setText(
								rsBook.getString(i));
						break;
					case "DatabaseProvider":
						panelBookDetail.getTaDatabaseProvider().setText(
								rsBook.getString(i));
						break;
					case "Language":
						panelBookDetail.getTaLanguage().setText(
								rsBook.getString(i));
						break;
					default:
						break;
					}
				}
				break;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		case "Report":
			comboBoxType.setSelectedItem("Report");
			ResultSet rsReport = loadDatabase
					.convertDatabaseToResultSet(queryModel
							.getQueryInfoReference(ReferenceID));

			try {
				rsReport.next();
				for (int i = 1; i <= rsReport.getMetaData().getColumnCount(); i++) {
					String field = rsReport.getMetaData().getColumnName(i);
					switch (field) {
					case "Author":
						panelReportDetail.getTaAuthor().setText(
								rsReport.getString(i));
						break;
					case "Year":
						panelReportDetail.getTaYear().setText(
								rsReport.getString(i));
						break;
					case "Title":
						panelReportDetail.getTaTitle().setText(
								rsReport.getString(i));
						break;
					case "SeriesEditor":
						panelReportDetail.getTaSeriesEditor().setText(
								rsReport.getString(i));
						break;
					case "SeriesTitle":
						panelReportDetail.getTaSeriesTitle().setText(
								rsReport.getString(i));
						break;
					case "PlacePublished":
						panelReportDetail.getTaPlacePublished().setText(
								rsReport.getString(i));
						break;
					case "Institution":
						panelReportDetail.getTaInstitution().setText(
								rsReport.getString(i));
						break;
					case "Volume":
						panelReportDetail.getTaVolume().setText(
								rsReport.getString(i));
						break;
					case "NumberOfVolumes":
						panelReportDetail.getTaNumberOfVolumes().setText(
								rsReport.getString(i));
						break;
					case "SeriesVolume":
						panelReportDetail.getTaSeriesVolume().setText(
								rsReport.getString(i));
						break;
					case "DocumentNumber":
						panelReportDetail.getTaDocumentNumber().setText(
								rsReport.getString(i));
						break;
					case "Pages":
						panelReportDetail.getTaPages().setText(
								rsReport.getString(i));
						break;
					case "Publisher":
						panelReportDetail.getTaPublisher().setText(
								rsReport.getString(i));
						break;
					case "Edition":
						panelReportDetail.getTaEdition().setText(
								rsReport.getString(i));
						break;
					case "Date":
						panelReportDetail.getTaDate().setText(
								rsReport.getString(i));
						break;
					case "Type":
						panelReportDetail.getTaType().setText(
								rsReport.getString(i));
						break;
					case "Department":
						panelReportDetail.getTaDepartment().setText(
								rsReport.getString(i));
						break;
					case "ShortTitle":
						panelReportDetail.getTaShortTitle().setText(
								rsReport.getString(i));
						break;
					case "AlternateTitle":
						panelReportDetail.getTaAlternateTitle().setText(
								rsReport.getString(i));
						break;
					case "ReportNumber":
						panelReportDetail.getTaReportNumber().setText(
								rsReport.getString(i));
						break;
					case "DOI":
						panelReportDetail.getTaDOI().setText(
								rsReport.getString(i));
						break;
					case "Contents":
						panelReportDetail.getTaContents().setText(
								rsReport.getString(i));
						break;
					case "Issue":
						panelReportDetail.getTaIssue().setText(
								rsReport.getString(i));
						break;
					case "AccessionNumber":
						panelReportDetail.getTaAccessionNumber().setText(
								rsReport.getString(i));
						break;
					case "CallNumber":
						panelReportDetail.getTaCallNumber().setText(
								rsReport.getString(i));
						break;
					case "Label":
						panelReportDetail.getTaLabel().setText(
								rsReport.getString(i));
						break;
					case "Keywords":
						panelReportDetail.getTaKeywords().setText(
								rsReport.getString(i));
						break;
					case "Abstract":
						panelReportDetail.getTaAbstract().setText(
								rsReport.getString(i));
						break;
					case "Notes":
						panelReportDetail.getTaNotes().setText(
								rsReport.getString(i));
						break;
					case "ResearchNotes":
						panelReportDetail.getTaResearchNotes().setText(
								rsReport.getString(i));
						break;
					case "URL":
						panelReportDetail.getTaURL().setText(
								rsReport.getString(i));
						break;
					case "AuthorAddress":
						panelReportDetail.getTaAuthorAddress().setText(
								rsReport.getString(i));
						break;
					case "Figure":
						panelReportDetail.getTaFigure().setText(
								rsReport.getString(i));
						break;
					case "Caption":
						panelReportDetail.getTaCaption().setText(
								rsReport.getString(i));
						break;
					case "AccessDate":
						panelReportDetail.getTaAccessDate().setText(
								rsReport.getString(i));
						break;
					case "TranslatedAuthor":
						panelReportDetail.getTaTranslatedAuthor().setText(
								rsReport.getString(i));
						break;
					case "TranslatedTitle":
						panelReportDetail.getTaTranslatedTitle().setText(
								rsReport.getString(i));
						break;
					case "NameOfDatabase":
						panelReportDetail.getTaNameOfDatabase().setText(
								rsReport.getString(i));
						break;
					case "DatabaseProvider":
						panelReportDetail.getTaDatabaseProvider().setText(
								rsReport.getString(i));
						break;
					case "Language":
						panelReportDetail.getTaLanguage().setText(
								rsReport.getString(i));
						break;
					default:
						break;
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case "Journal Article":
			comboBoxType.setSelectedItem("Journal Article");
			ResultSet rsJournalArticle = loadDatabase
					.convertDatabaseToResultSet(queryModel
							.getQueryInfoReference(ReferenceID));

			try {
				rsJournalArticle.next();
				for (int i = 1; i <= rsJournalArticle.getMetaData()
						.getColumnCount(); i++) {
					String field = rsJournalArticle.getMetaData()
							.getColumnName(i);
					switch (field) {
					case "Author":
						panelJournalArticleDetail.getTaAuthor().setText(
								rsJournalArticle.getString(i));
						break;
					case "Year":
						panelJournalArticleDetail.getTaYear().setText(
								rsJournalArticle.getString(i));
						break;
					case "Title":
						panelJournalArticleDetail.getTaTitle().setText(
								rsJournalArticle.getString(i));
						break;
					case "SecondaryAuthor":
						panelJournalArticleDetail.getTaSecondaryAuthor()
								.setText(rsJournalArticle.getString(i));
						break;
					case "Journal":
						panelJournalArticleDetail.getTaJournal().setText(
								rsJournalArticle.getString(i));
						break;
					case "PlacePublished":
						panelJournalArticleDetail.getTaPlacePublished()
								.setText(rsJournalArticle.getString(i));
						break;
					case "Publisher":
						panelJournalArticleDetail.getTaPublisher().setText(
								rsJournalArticle.getString(i));
						break;
					case "Volume":
						panelJournalArticleDetail.getTaVolume().setText(
								rsJournalArticle.getString(i));
						break;
					case "NumberOfVolumes":
						panelJournalArticleDetail.getTaNumberOfVolumes()
								.setText(rsJournalArticle.getString(i));
						break;
					case "Issue":
						panelJournalArticleDetail.getTaIssue().setText(
								rsJournalArticle.getString(i));
						break;
					case "Pages":
						panelJournalArticleDetail.getTaPages().setText(
								rsJournalArticle.getString(i));
						break;
					case "StartPage":
						panelJournalArticleDetail.getTaStartPage().setText(
								rsJournalArticle.getString(i));
						break;
					case "EpubDate":
						panelJournalArticleDetail.getTaEpubDate().setText(
								rsJournalArticle.getString(i));
						break;
					case "Date":
						panelJournalArticleDetail.getTaDate().setText(
								rsJournalArticle.getString(i));
						break;
					case "TypeOfArticle":
						panelJournalArticleDetail.getTaTypeOfArticle().setText(
								rsJournalArticle.getString(i));
						break;
					case "ShortTitle":
						panelJournalArticleDetail.getTaShortTitle().setText(
								rsJournalArticle.getString(i));
						break;
					case "AlternateJournal":
						panelJournalArticleDetail.getTaAlternateJournal()
								.setText(rsJournalArticle.getString(i));
						break;
					case "ISBN":
						panelJournalArticleDetail.getTaISBN().setText(
								rsJournalArticle.getString(i));
						break;
					case "DOI":
						panelJournalArticleDetail.getTaDOI().setText(
								rsJournalArticle.getString(i));
						break;
					case "OriginalPublication":
						panelJournalArticleDetail.getTaOriginalPublication()
								.setText(rsJournalArticle.getString(i));
						break;
					case "ReprintEdition":
						panelJournalArticleDetail.getTaReprintEdition()
								.setText(rsJournalArticle.getString(i));
						break;
					case "ReviewedItem":
						panelJournalArticleDetail.getTaReviewedItem().setText(
								rsJournalArticle.getString(i));
						break;
					case "LegalNote":
						panelJournalArticleDetail.getTaLegalNote().setText(
								rsJournalArticle.getString(i));
						break;
					case "PMCID":
						panelJournalArticleDetail.getTaPMCID().setText(
								rsJournalArticle.getString(i));
						break;
					case "NIHMSID":
						panelJournalArticleDetail.getTaNIHMSID().setText(
								rsJournalArticle.getString(i));
						break;
					case "ArticleNumber":
						panelJournalArticleDetail.getTaArticleNumber().setText(
								rsJournalArticle.getString(i));
						break;
					case "AccessionNumber":
						panelJournalArticleDetail.getTaAccessionNumber()
								.setText(rsJournalArticle.getString(i));
						break;
					case "CallNumber":
						panelJournalArticleDetail.getTaCallNumber().setText(
								rsJournalArticle.getString(i));
						break;
					case "Label":
						panelJournalArticleDetail.getTaLabel().setText(
								rsJournalArticle.getString(i));
						break;
					case "Keywords":
						panelJournalArticleDetail.getTaKeywords().setText(
								rsJournalArticle.getString(i));
						break;
					case "Abstract":
						panelJournalArticleDetail.getTaAbstract().setText(
								rsJournalArticle.getString(i));
						break;
					case "Notes":
						panelJournalArticleDetail.getTaNotes().setText(
								rsJournalArticle.getString(i));
						break;
					case "ResearchNotes":
						panelJournalArticleDetail.getTaResearchNotes().setText(
								rsJournalArticle.getString(i));
						break;
					case "URL":
						panelJournalArticleDetail.getTaURL().setText(
								rsJournalArticle.getString(i));
						break;
					case "AuthorAddress":
						panelJournalArticleDetail.getTaAuthorAddress().setText(
								rsJournalArticle.getString(i));
						break;
					case "Figure":
						panelJournalArticleDetail.getTaFigure().setText(
								rsJournalArticle.getString(i));
						break;
					case "Caption":
						panelJournalArticleDetail.getTaCaption().setText(
								rsJournalArticle.getString(i));
						break;
					case "AccessDate":
						panelJournalArticleDetail.getTaAccessDate().setText(
								rsJournalArticle.getString(i));
						break;
					case "TranslatedAuthor":
						panelJournalArticleDetail.getTaTranslatedAuthor()
								.setText(rsJournalArticle.getString(i));
						break;
					case "TranslatedTitle":
						panelJournalArticleDetail.getTaTranslatedTitle()
								.setText(rsJournalArticle.getString(i));
						break;
					case "NameOfDatabase":
						panelJournalArticleDetail.getTaNameOfDatabase()
								.setText(rsJournalArticle.getString(i));
						break;
					case "DatabaseProvider":
						panelJournalArticleDetail.getTaDatabaseProvider()
								.setText(rsJournalArticle.getString(i));
						break;
					case "Language":
						panelJournalArticleDetail.getTaLanguage().setText(
								rsJournalArticle.getString(i));
						break;
					default:
						break;
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Conference Proceedings":
			comboBoxType.setSelectedItem("Conference Proceedings");
			ResultSet rsConferenceProceedings = loadDatabase
					.convertDatabaseToResultSet(queryModel
							.getQueryInfoReference(ReferenceID));

			try {
				rsConferenceProceedings.next();
				for (int i = 1; i <= rsConferenceProceedings.getMetaData()
						.getColumnCount(); i++) {
					String field = rsConferenceProceedings.getMetaData()
							.getColumnName(i);
					switch (field) {
					case "Author":
						panelConferenceProceedingsDetail.getTaAuthor().setText(
								rsConferenceProceedings.getString(i));
						break;
					case "Year":
						panelConferenceProceedingsDetail
								.getTaYearOfConference().setText(
										rsConferenceProceedings.getString(i));
						break;
					case "Title":
						panelConferenceProceedingsDetail.getTaTitle().setText(
								rsConferenceProceedings.getString(i));
						break;
					case "Editor":
						panelConferenceProceedingsDetail.getTaEditor().setText(
								rsConferenceProceedings.getString(i));
						break;
					case "ConferenceName":
						panelConferenceProceedingsDetail.getTaConferenceName()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "ConferenceLocation":
						panelConferenceProceedingsDetail
								.getTaConferenceLocation().setText(
										rsConferenceProceedings.getString(i));
						break;
					case "Publisher":
						panelConferenceProceedingsDetail.getTaPublisher()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "Volume":
						panelConferenceProceedingsDetail.getTaVolume().setText(
								rsConferenceProceedings.getString(i));
						break;
					case "NumberOfVolumes":
						panelConferenceProceedingsDetail.getTaNumberOfVolumes()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "Issue":
						panelConferenceProceedingsDetail.getTaIssue().setText(
								rsConferenceProceedings.getString(i));
						break;
					case "Pages":
						panelConferenceProceedingsDetail.getTaPages().setText(
								rsConferenceProceedings.getString(i));
						break;
					case "SeriesEditor":
						panelConferenceProceedingsDetail.getTaSeriesEditor()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "SeriesTitle":
						panelConferenceProceedingsDetail.getTaSeriesTitle()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "Edition":
						panelConferenceProceedingsDetail.getTaEdition()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "Date":
						panelConferenceProceedingsDetail.getTaDate().setText(
								rsConferenceProceedings.getString(i));
						break;
					case "Sponsor":
						panelConferenceProceedingsDetail.getTaSponsor()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "ShortTitle":
						panelConferenceProceedingsDetail.getTaShortTitle()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "ISBN":
						panelConferenceProceedingsDetail.getTaISBN().setText(
								rsConferenceProceedings.getString(i));
						break;
					case "DOI":
						panelConferenceProceedingsDetail.getTaDOI().setText(
								rsConferenceProceedings.getString(i));
						break;
					case "Source":
						panelConferenceProceedingsDetail.getTaSource().setText(
								rsConferenceProceedings.getString(i));
						break;
					case "PlacePublished":
						panelConferenceProceedingsDetail.getTaPlacePublished()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "YearPublished":
						panelConferenceProceedingsDetail.getTaYearPublished()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "ProceedingsTitle":
						panelConferenceProceedingsDetail
								.getTaProceedingsTitle().setText(
										rsConferenceProceedings.getString(i));
						break;
					case "PackagingMethod":
						panelConferenceProceedingsDetail.getTaPackagingMethod()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "AccessionNumber":
						panelConferenceProceedingsDetail.getTaAccessionNumber()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "CallNumber":
						panelConferenceProceedingsDetail.getTaCallNumber()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "Label":
						panelConferenceProceedingsDetail.getTaLabel().setText(
								rsConferenceProceedings.getString(i));
						break;
					case "Keywords":
						panelConferenceProceedingsDetail.getTaKeywords()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "Abstract":
						panelConferenceProceedingsDetail.getTaAbstract()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "Notes":
						panelConferenceProceedingsDetail.getTaNotes().setText(
								rsConferenceProceedings.getString(i));
						break;
					case "ResearchNotes":
						panelConferenceProceedingsDetail.getTaResearchNotes()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "URL":
						panelConferenceProceedingsDetail.getTaURL().setText(
								rsConferenceProceedings.getString(i));
						break;
					case "AuthorAddress":
						panelConferenceProceedingsDetail.getTaAuthorAddress()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "Figure":
						panelConferenceProceedingsDetail.getTaFigure().setText(
								rsConferenceProceedings.getString(i));
						break;
					case "Caption":
						panelConferenceProceedingsDetail.getTaCaption()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "AccessDate":
						panelConferenceProceedingsDetail.getTaAccessDate()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "TranslatedAuthor":
						panelConferenceProceedingsDetail
								.getTaTranslatedAuthor().setText(
										rsConferenceProceedings.getString(i));
						break;
					case "TranslatedTitle":
						panelConferenceProceedingsDetail.getTaTranslatedTitle()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "NameOfDatabase":
						panelConferenceProceedingsDetail.getTaNameOfDatabase()
								.setText(rsConferenceProceedings.getString(i));
						break;
					case "DatabaseProvider":
						panelConferenceProceedingsDetail
								.getTaDatabaseProvider().setText(
										rsConferenceProceedings.getString(i));
						break;
					case "Language":
						panelConferenceProceedingsDetail.getTaLanguage()
								.setText(rsConferenceProceedings.getString(i));
						break;
					default:
						break;
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Thesis":
			comboBoxType.setSelectedItem("Thesis");
			ResultSet rsThesis = loadDatabase
					.convertDatabaseToResultSet(queryModel
							.getQueryInfoReference(ReferenceID));

			try {
				rsThesis.next();
				for (int i = 1; i <= rsThesis.getMetaData().getColumnCount(); i++) {
					String field = rsThesis.getMetaData().getColumnName(i);
					switch (field) {
					case "Author":
						panelThesisDetail.getTaAuthor().setText(
								rsThesis.getString(i));
						break;
					case "Year":
						panelThesisDetail.getTaYear().setText(
								rsThesis.getString(i));
						break;
					case "Title":
						panelThesisDetail.getTaTitle().setText(
								rsThesis.getString(i));
						break;
					case "SecondaryAuthor":
						panelThesisDetail.getTaSecondaryAuthor().setText(
								rsThesis.getString(i));
						break;
					case "AcademicDepartment":
						panelThesisDetail.getTaAcademicDepartment().setText(
								rsThesis.getString(i));
						break;
					case "PlacePublished":
						panelThesisDetail.getTaPlacePublished().setText(
								rsThesis.getString(i));
						break;
					case "University":
						panelThesisDetail.getTaUniversity().setText(
								rsThesis.getString(i));
						break;
					case "Degree":
						panelThesisDetail.getTaDegree().setText(
								rsThesis.getString(i));
						break;
					case "NumberOfVolumes":
						panelThesisDetail.getTaNumberOfVolumes().setText(
								rsThesis.getString(i));
						break;
					case "DocumentNumber":
						panelThesisDetail.getTaDocumentNumber().setText(
								rsThesis.getString(i));
						break;
					case "NumberOfPages":
						panelThesisDetail.getTaNumberOfPages().setText(
								rsThesis.getString(i));
						break;
					case "Advisor":
						panelThesisDetail.getTaAdvisor().setText(
								rsThesis.getString(i));
						break;
					case "Date":
						panelThesisDetail.getTaDate().setText(
								rsThesis.getString(i));
						break;
					case "ThesisType":
						panelThesisDetail.getTaThesisType().setText(
								rsThesis.getString(i));
						break;
					case "ShortTitle":
						panelThesisDetail.getTaShortTitle().setText(
								rsThesis.getString(i));
						break;
					case "ISBN":
						panelThesisDetail.getTaISBN().setText(
								rsThesis.getString(i));
						break;
					case "DOI":
						panelThesisDetail.getTaDOI().setText(
								rsThesis.getString(i));
						break;
					case "AccessionNumber":
						panelThesisDetail.getTaAccessionNumber().setText(
								rsThesis.getString(i));
						break;
					case "CallNumber":
						panelThesisDetail.getTaCallNumber().setText(
								rsThesis.getString(i));
						break;
					case "Label":
						panelThesisDetail.getTaLabel().setText(
								rsThesis.getString(i));
						break;
					case "Keywords":
						panelThesisDetail.getTaKeywords().setText(
								rsThesis.getString(i));
						break;
					case "Abstract":
						panelThesisDetail.getTaAbstract().setText(
								rsThesis.getString(i));
						break;
					case "Notes":
						panelThesisDetail.getTaNotes().setText(
								rsThesis.getString(i));
						break;
					case "ResearchNotes":
						panelThesisDetail.getTaResearchNotes().setText(
								rsThesis.getString(i));
						break;
					case "URL":
						panelThesisDetail.getTaURL().setText(
								rsThesis.getString(i));
						break;
					case "AuthorAddress":
						panelThesisDetail.getTaAuthorAddress().setText(
								rsThesis.getString(i));
						break;
					case "Figure":
						panelThesisDetail.getTaFigure().setText(
								rsThesis.getString(i));
						break;
					case "Caption":
						panelThesisDetail.getTaCaption().setText(
								rsThesis.getString(i));
						break;
					case "AccessDate":
						panelThesisDetail.getTaAccessDate().setText(
								rsThesis.getString(i));
						break;
					case "TranslatedAuthor":
						panelThesisDetail.getTaTranslatedAuthor().setText(
								rsThesis.getString(i));
						break;
					case "TranslatedTitle":
						panelThesisDetail.getTaTranslatedTitle().setText(
								rsThesis.getString(i));
						break;
					case "NameOfDatabase":
						panelThesisDetail.getTaNameOfDatabase().setText(
								rsThesis.getString(i));
						break;
					case "DatabaseProvider":
						panelThesisDetail.getTaDatabaseProvider().setText(
								rsThesis.getString(i));
						break;
					case "Language":
						panelThesisDetail.getTaLanguage().setText(
								rsThesis.getString(i));
						break;
					default:
						break;
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
}

package services.controls;

import gui.MainGUI;
import gui.panels.PanelCenter;
import gui.panels.PanelLeft;
import gui.panels.PanelRight;
import gui.panels.PanelRightInner.PanelReferenceDetailTab;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelBookDetail;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelConferenceProceedingsDetail;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelJournalArticleDetail;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelReportDetail;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelThesisDetail;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.TreePath;

import services.LoadDatabase;
import services.QueryModel;

public class ButtonFunctionAction {

	private JButton buttonSave;
	private LoadDatabase loadDatabase;
	private QueryModel queryModel;

	private JTree treeMap;
	private JTable tableCenter;

	private JComboBox<String> comboBoxType;
	private PanelBookDetail panelBookDetail;
	private PanelReportDetail panelReportDetail;
	private PanelJournalArticleDetail panelJournalArticleDetail;
	private PanelConferenceProceedingsDetail panelConferenceProceedingsDetail;
	private PanelThesisDetail panelThesisDetail;

	public ButtonFunctionAction(MainGUI mainFrame, LoadDatabase loadDatabase,
			QueryModel queryModel) {
		this.buttonSave = mainFrame.getPanelRight()
				.getPanelReferenceDetailTab().getButtonSave();
		this.loadDatabase = loadDatabase;
		this.queryModel = queryModel;
		
		PanelLeft panelLeft = mainFrame.getPanelLeft();
		treeMap = panelLeft.getTreeMap();

		PanelCenter panelCenter = mainFrame.getPanelCenter();
		tableCenter = panelCenter.getTableCenter();

		PanelRight panelRight = mainFrame.getPanelRight();
		PanelReferenceDetailTab panelReferenceDetailTab = panelRight
				.getPanelReferenceDetailTab();
		comboBoxType = panelReferenceDetailTab.getComboBoxType();
		panelBookDetail = panelReferenceDetailTab.getPanelBookDetail();
		panelReportDetail = panelReferenceDetailTab.getPanelReportDetail();
		panelJournalArticleDetail = panelReferenceDetailTab
				.getPanelJournalArticleDetail();
		panelConferenceProceedingsDetail = panelReferenceDetailTab
				.getPanelConferenceProceedingsDetail();
		panelThesisDetail = panelReferenceDetailTab.getPanelThesisDetail();
	}

	public void addButtonFunctionAction() {
		addButtonSaveAction();
	}

	private void addButtonSaveAction() {
		buttonSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!checkValidate()) {
					JOptionPane.showMessageDialog(null,
							"Author and Title must be NOT NULL !");
				} else {
					updateSave();
					updateTable();
				}
			}

			private boolean checkValidate() {
				String author = null;
				String title = null;
				String type = comboBoxType.getSelectedItem().toString();
				switch (type) {
				case "Book":
					author = panelBookDetail.getTaAuthor().getText();
					title = panelBookDetail.getTaTitle().getText();
					break;
				case "Report":
					author = panelReportDetail.getTaAuthor().getText();
					title = panelReportDetail.getTaTitle().getText();
					break;
				case "Journal Article":
					author = panelJournalArticleDetail.getTaAuthor().getText();
					title = panelJournalArticleDetail.getTaTitle().getText();
					break;
				case "Conference Proceedings":
					author = panelConferenceProceedingsDetail.getTaAuthor()
							.getText();
					title = panelConferenceProceedingsDetail.getTaTitle()
							.getText();
					break;
				case "Thesis":
					author = panelThesisDetail.getTaAuthor().getText();
					title = panelThesisDetail.getTaTitle().getText();
					break;
				}
				return !author.equals("") && !title.equals("");
			}

			private void updateSave() {
				String ReferenceID = tableCenter.getValueAt(
						tableCenter.getSelectedRow(), 0).toString();
				String typeName = comboBoxType.getSelectedItem().toString();
				switch (typeName) {
				case "Book":
					String Author = panelBookDetail.getTaAuthor().getText();
					String Year = panelBookDetail.getTaYear().getText();
					String Title = panelBookDetail.getTaTitle().getText();
					String SeriesEditor = panelBookDetail.getTaSeriesEditor()
							.getText();
					String SeriesTitle = panelBookDetail.getTaSeriesTitle()
							.getText();
					String PlacePublished = panelBookDetail
							.getTaPlacePublished().getText();
					String Publisher = panelBookDetail.getTaPublisher()
							.getText();
					String Volume = panelBookDetail.getTaVolume().getText();
					String NumberOfVolumes = panelBookDetail
							.getTaNumberOfVolumes().getText();
					String SeriesVolume = panelBookDetail.getTaSeriesVolume()
							.getText();
					String NumberOfPages = panelBookDetail.getTaNumberOfPages()
							.getText();
					String Pages = panelBookDetail.getTaPages().getText();
					String Editor = panelBookDetail.getTaEditor().getText();
					String Edition = panelBookDetail.getTaEdition().getText();
					String Date = panelBookDetail.getTaDate().getText();
					String TypeOfWork = panelBookDetail.getTaTypeOfWork()
							.getText();
					String Translator = panelBookDetail.getTaTranslator()
							.getText();
					String ShortTitle = panelBookDetail.getTaShortTitle()
							.getText();
					String Abbreviation = panelBookDetail.getTaAbbreviation()
							.getText();
					String ISBN = panelBookDetail.getTaISBN().getText();
					String DOI = panelBookDetail.getTaDOI().getText();
					String OriginalPublication = panelBookDetail
							.getTaOriginalPublication().getText();
					String ReprintEdition = panelBookDetail
							.getTaReprintEdition().getText();
					String TitlePrefix = panelBookDetail.getTaTitlePrefix()
							.getText();
					String Reviewer = panelBookDetail.getTaReviewer().getText();
					String AccessionNumber = panelBookDetail
							.getTaAccessionNumber().getText();
					String CallNumber = panelBookDetail.getTaCallNumber()
							.getText();
					String Label = panelBookDetail.getTaLabel().getText();
					String Keywords = panelBookDetail.getTaKeywords().getText();
					String Abstract = panelBookDetail.getTaAbstract().getText();
					String Notes = panelBookDetail.getTaNotes().getText();
					String ResearchNotes = panelBookDetail.getTaResearchNotes()
							.getText();
					String URL = panelBookDetail.getTaURL().getText();
					String AuthorAddress = panelBookDetail.getTaAuthorAddress()
							.getText();
					String Figure = panelBookDetail.getTaFigure().getText();
					String Caption = panelBookDetail.getTaCaption().getText();
					String AccessDate = panelBookDetail.getTaAccessDate()
							.getText();
					String TranslatedAuthor = panelBookDetail
							.getTaTranslatedAuthor().getText();
					String TranslatedTitle = panelBookDetail
							.getTaTranslatedTitle().getText();
					String NameOfDatabase = panelBookDetail
							.getTaNameOfDatabase().getText();
					String DatabaseProvider = panelBookDetail
							.getTaDatabaseProvider().getText();
					String Language = panelBookDetail.getTaLanguage().getText();

					loadDatabase.updateDatabase(queryModel.getQuerySaveBook(
							ReferenceID, Author, Year, Title, SeriesEditor,
							SeriesTitle, PlacePublished, Publisher, Volume,
							NumberOfVolumes, SeriesVolume, NumberOfPages,
							Pages, Editor, Edition, Date, TypeOfWork,
							Translator, ShortTitle, Abbreviation, ISBN, DOI,
							OriginalPublication, ReprintEdition, TitlePrefix,
							Reviewer, AccessionNumber, CallNumber, Label,
							Keywords, Abstract, Notes, ResearchNotes, URL,
							AuthorAddress, Figure, Caption, AccessDate,
							TranslatedAuthor, TranslatedTitle, NameOfDatabase,
							DatabaseProvider, Language));
					break;

				case "Report":
					Author = panelReportDetail.getTaAuthor().getText();
					Year = panelReportDetail.getTaYear().getText();
					Title = panelReportDetail.getTaTitle().getText();
					SeriesEditor = panelReportDetail.getTaSeriesEditor()
							.getText();
					SeriesTitle = panelReportDetail.getTaSeriesTitle()
							.getText();
					PlacePublished = panelReportDetail.getTaPlacePublished()
							.getText();
					String Institution = panelReportDetail.getTaInstitution()
							.getText();
					Volume = panelReportDetail.getTaVolume().getText();
					NumberOfVolumes = panelReportDetail.getTaNumberOfVolumes()
							.getText();
					SeriesVolume = panelReportDetail.getTaSeriesVolume()
							.getText();
					String DocumentNumber = panelReportDetail
							.getTaDocumentNumber().getText();
					Pages = panelReportDetail.getTaPages().getText();
					Publisher = panelReportDetail.getTaPublisher().getText();
					Edition = panelReportDetail.getTaEdition().getText();
					Date = panelReportDetail.getTaDate().getText();
					String Type = panelReportDetail.getTaType().getText();
					String Department = panelReportDetail.getTaDepartment()
							.getText();
					ShortTitle = panelReportDetail.getTaShortTitle().getText();
					String AlternateTitle = panelReportDetail
							.getTaAlternateTitle().getText();
					String ReportNumber = panelReportDetail.getTaReportNumber()
							.getText();
					DOI = panelReportDetail.getTaDOI().getText();
					String Contents = panelReportDetail.getTaContents()
							.getText();
					String Issue = panelReportDetail.getTaIssue().getText();
					AccessionNumber = panelReportDetail.getTaAccessionNumber()
							.getText();
					CallNumber = panelReportDetail.getTaCallNumber().getText();
					Label = panelReportDetail.getTaLabel().getText();
					Keywords = panelReportDetail.getTaKeywords().getText();
					Abstract = panelReportDetail.getTaAbstract().getText();
					Notes = panelReportDetail.getTaNotes().getText();
					ResearchNotes = panelReportDetail.getTaResearchNotes()
							.getText();
					URL = panelReportDetail.getTaURL().getText();
					AuthorAddress = panelReportDetail.getTaAuthorAddress()
							.getText();
					Figure = panelReportDetail.getTaFigure().getText();
					Caption = panelReportDetail.getTaCaption().getText();
					AccessDate = panelReportDetail.getTaAccessDate().getText();
					TranslatedAuthor = panelReportDetail
							.getTaTranslatedAuthor().getText();
					TranslatedTitle = panelReportDetail.getTaTranslatedTitle()
							.getText();
					NameOfDatabase = panelReportDetail.getTaNameOfDatabase()
							.getText();
					DatabaseProvider = panelReportDetail
							.getTaDatabaseProvider().getText();
					Language = panelReportDetail.getTaLanguage().getText();

					loadDatabase.updateDatabase(queryModel.getQuerySaveReport(
							ReferenceID, Author, Year, Title, SeriesEditor,
							SeriesTitle, PlacePublished, Institution, Volume,
							NumberOfVolumes, SeriesVolume, DocumentNumber,
							Pages, Publisher, Edition, Date, Type, Department,
							ShortTitle, AlternateTitle, ReportNumber, DOI,
							Contents, Issue, AccessionNumber, CallNumber,
							Label, Keywords, Abstract, Notes, ResearchNotes,
							URL, AuthorAddress, Figure, Caption, AccessDate,
							TranslatedAuthor, TranslatedTitle, NameOfDatabase,
							DatabaseProvider, Language));
					break;

				case "Journal Article":
					Author = panelJournalArticleDetail.getTaAuthor().getText();
					Year = panelJournalArticleDetail.getTaYear().getText();
					Title = panelJournalArticleDetail.getTaTitle().getText();
					String SecondaryAuthor = panelJournalArticleDetail
							.getTaSecondaryAuthor().getText();
					String Journal = panelJournalArticleDetail.getTaJournal()
							.getText();
					PlacePublished = panelJournalArticleDetail
							.getTaPlacePublished().getText();
					Publisher = panelJournalArticleDetail.getTaPublisher()
							.getText();
					Volume = panelJournalArticleDetail.getTaVolume().getText();
					NumberOfVolumes = panelJournalArticleDetail
							.getTaNumberOfVolumes().getText();
					Issue = panelJournalArticleDetail.getTaIssue().getText();
					Pages = panelJournalArticleDetail.getTaPages().getText();
					String StartPage = panelJournalArticleDetail
							.getTaStartPage().getText();
					String EpubDate = panelJournalArticleDetail.getTaEpubDate()
							.getText();
					Date = panelJournalArticleDetail.getTaDate().getText();
					String TypeOfArticle = panelJournalArticleDetail
							.getTaTypeOfArticle().getText();
					ShortTitle = panelJournalArticleDetail.getTaShortTitle()
							.getText();
					String AlternateJournal = panelJournalArticleDetail
							.getTaAlternateJournal().getText();
					ISBN = panelJournalArticleDetail.getTaISBN().getText();
					DOI = panelJournalArticleDetail.getTaDOI().getText();
					OriginalPublication = panelJournalArticleDetail
							.getTaOriginalPublication().getText();
					ReprintEdition = panelJournalArticleDetail
							.getTaReprintEdition().getText();
					String ReviewedItem = panelJournalArticleDetail
							.getTaReviewedItem().getText();
					String LegalNote = panelJournalArticleDetail
							.getTaLegalNote().getText();
					String PMCID = panelJournalArticleDetail.getTaPMCID()
							.getText();
					String NIHMSID = panelJournalArticleDetail.getTaNIHMSID()
							.getText();
					String ArticleNumber = panelJournalArticleDetail
							.getTaArticleNumber().getText();
					AccessionNumber = panelJournalArticleDetail
							.getTaAccessionNumber().getText();
					CallNumber = panelJournalArticleDetail.getTaCallNumber()
							.getText();
					Label = panelJournalArticleDetail.getTaLabel().getText();
					Keywords = panelJournalArticleDetail.getTaKeywords()
							.getText();
					Abstract = panelJournalArticleDetail.getTaAbstract()
							.getText();
					Notes = panelJournalArticleDetail.getTaNotes().getText();
					ResearchNotes = panelJournalArticleDetail
							.getTaResearchNotes().getText();
					URL = panelJournalArticleDetail.getTaURL().getText();
					AuthorAddress = panelJournalArticleDetail
							.getTaAuthorAddress().getText();
					Figure = panelJournalArticleDetail.getTaFigure().getText();
					Caption = panelJournalArticleDetail.getTaCaption()
							.getText();
					AccessDate = panelJournalArticleDetail.getTaAccessDate()
							.getText();
					TranslatedAuthor = panelJournalArticleDetail
							.getTaTranslatedAuthor().getText();
					TranslatedTitle = panelJournalArticleDetail
							.getTaTranslatedTitle().getText();
					NameOfDatabase = panelJournalArticleDetail
							.getTaNameOfDatabase().getText();
					DatabaseProvider = panelJournalArticleDetail
							.getTaDatabaseProvider().getText();
					Language = panelJournalArticleDetail.getTaLanguage()
							.getText();

					loadDatabase.updateDatabase(queryModel
							.getQuerySaveJournalArticle(ReferenceID, Author,
									Year, Title, SecondaryAuthor, Journal,
									PlacePublished, Publisher, Volume,
									NumberOfVolumes, Issue, Pages, StartPage,
									EpubDate, Date, TypeOfArticle, ShortTitle,
									AlternateJournal, ISBN, DOI,
									OriginalPublication, ReprintEdition,
									ReviewedItem, LegalNote, PMCID, NIHMSID,
									ArticleNumber, AccessionNumber, CallNumber,
									Label, Keywords, Abstract, Notes,
									ResearchNotes, URL, AuthorAddress, Figure,
									Caption, AccessDate, TranslatedAuthor,
									TranslatedTitle, NameOfDatabase,
									DatabaseProvider, Language));
					break;

				case "Conference Proceedings":
					Author = panelConferenceProceedingsDetail.getTaAuthor()
							.getText();
					String YearOfConference = panelConferenceProceedingsDetail
							.getTaYearOfConference().getText();
					Title = panelConferenceProceedingsDetail.getTaTitle()
							.getText();
					Editor = panelConferenceProceedingsDetail.getTaEditor()
							.getText();
					String ConferenceName = panelConferenceProceedingsDetail
							.getTaConferenceName().getText();
					String ConferenceLocation = panelConferenceProceedingsDetail
							.getTaConferenceLocation().getText();
					Publisher = panelConferenceProceedingsDetail
							.getTaPublisher().getText();
					Volume = panelConferenceProceedingsDetail.getTaVolume()
							.getText();
					NumberOfVolumes = panelConferenceProceedingsDetail
							.getTaNumberOfVolumes().getText();
					Issue = panelConferenceProceedingsDetail.getTaIssue()
							.getText();
					Pages = panelConferenceProceedingsDetail.getTaPages()
							.getText();
					SeriesEditor = panelConferenceProceedingsDetail
							.getTaSeriesEditor().getText();
					SeriesTitle = panelConferenceProceedingsDetail
							.getTaSeriesTitle().getText();
					Edition = panelConferenceProceedingsDetail.getTaEdition()
							.getText();
					Date = panelConferenceProceedingsDetail.getTaDate()
							.getText();
					String Sponsor = panelConferenceProceedingsDetail
							.getTaSponsor().getText();
					ISBN = panelConferenceProceedingsDetail.getTaISBN()
							.getText();
					DOI = panelConferenceProceedingsDetail.getTaDOI().getText();
					String Source = panelConferenceProceedingsDetail
							.getTaSource().getText();
					PlacePublished = panelConferenceProceedingsDetail
							.getTaPlacePublished().getText();
					String YearPublished = panelConferenceProceedingsDetail
							.getTaYearPublished().getText();
					String ProceedingsTitle = panelConferenceProceedingsDetail
							.getTaProceedingsTitle().getText();
					String PackagingMethod = panelConferenceProceedingsDetail
							.getTaPackagingMethod().getText();
					AccessionNumber = panelConferenceProceedingsDetail
							.getTaAccessionNumber().getText();
					CallNumber = panelConferenceProceedingsDetail
							.getTaCallNumber().getText();
					Label = panelConferenceProceedingsDetail.getTaLabel()
							.getText();
					Keywords = panelConferenceProceedingsDetail.getTaKeywords()
							.getText();
					Abstract = panelConferenceProceedingsDetail.getTaAbstract()
							.getText();
					Notes = panelConferenceProceedingsDetail.getTaNotes()
							.getText();
					ResearchNotes = panelConferenceProceedingsDetail
							.getTaResearchNotes().getText();
					URL = panelConferenceProceedingsDetail.getTaURL().getText();
					AuthorAddress = panelConferenceProceedingsDetail
							.getTaAuthorAddress().getText();
					Figure = panelConferenceProceedingsDetail.getTaFigure()
							.getText();
					Caption = panelConferenceProceedingsDetail.getTaCaption()
							.getText();
					AccessDate = panelConferenceProceedingsDetail
							.getTaAccessDate().getText();
					TranslatedAuthor = panelConferenceProceedingsDetail
							.getTaTranslatedAuthor().getText();
					TranslatedTitle = panelConferenceProceedingsDetail
							.getTaTranslatedTitle().getText();
					NameOfDatabase = panelConferenceProceedingsDetail
							.getTaNameOfDatabase().getText();
					DatabaseProvider = panelConferenceProceedingsDetail
							.getTaDatabaseProvider().getText();
					Language = panelConferenceProceedingsDetail.getTaLanguage()
							.getText();

					loadDatabase.updateDatabase(queryModel
							.getQuerySaveConferenceProceedings(ReferenceID,
									Author, YearOfConference, Title, Editor,
									ConferenceName, ConferenceLocation,
									Publisher, Volume, NumberOfVolumes, Issue,
									Pages, SeriesEditor, SeriesTitle, Edition,
									Date, Sponsor, ISBN, DOI, Source,
									PlacePublished, YearPublished,
									ProceedingsTitle, PackagingMethod,
									AccessionNumber, CallNumber, Label,
									Keywords, Abstract, Notes, ResearchNotes,
									URL, AuthorAddress, Figure, Caption,
									AccessDate, TranslatedAuthor,
									TranslatedTitle, NameOfDatabase,
									DatabaseProvider, Language));
					break;

				case "Thesis":
					Author = panelThesisDetail.getTaAuthor().getText();
					Year = panelThesisDetail.getTaYear().getText();
					Title = panelThesisDetail.getTaTitle().getText();
					SecondaryAuthor = panelThesisDetail.getTaSecondaryAuthor()
							.getText();
					String AcademicDepartment = panelThesisDetail
							.getTaAcademicDepartment().getText();
					PlacePublished = panelThesisDetail.getTaPlacePublished()
							.getText();
					String University = panelThesisDetail.getTaUniversity()
							.getText();
					String Degree = panelThesisDetail.getTaDegree().getText();
					NumberOfVolumes = panelThesisDetail.getTaNumberOfVolumes()
							.getText();
					DocumentNumber = panelThesisDetail.getTaDocumentNumber()
							.getText();
					NumberOfPages = panelThesisDetail.getTaNumberOfPages()
							.getText();
					String Advisor = panelThesisDetail.getTaAdvisor().getText();
					Date = panelThesisDetail.getTaDate().getText();
					String ThesisType = panelThesisDetail.getTaThesisType()
							.getText();
					ShortTitle = panelThesisDetail.getTaShortTitle().getText();
					ISBN = panelThesisDetail.getTaISBN().getText();
					DOI = panelThesisDetail.getTaDOI().getText();
					AccessionNumber = panelThesisDetail.getTaAccessionNumber()
							.getText();
					CallNumber = panelThesisDetail.getTaCallNumber().getText();
					Label = panelThesisDetail.getTaLabel().getText();
					Keywords = panelThesisDetail.getTaKeywords().getText();
					Abstract = panelThesisDetail.getTaAbstract().getText();
					Notes = panelThesisDetail.getTaNotes().getText();
					ResearchNotes = panelThesisDetail.getTaResearchNotes()
							.getText();
					URL = panelThesisDetail.getTaURL().getText();
					AuthorAddress = panelThesisDetail.getTaAuthorAddress()
							.getText();
					Figure = panelThesisDetail.getTaFigure().getText();
					Caption = panelThesisDetail.getTaCaption().getText();
					AccessDate = panelThesisDetail.getTaAccessDate().getText();
					TranslatedAuthor = panelThesisDetail
							.getTaTranslatedAuthor().getText();
					TranslatedTitle = panelThesisDetail.getTaTranslatedTitle()
							.getText();
					NameOfDatabase = panelThesisDetail.getTaNameOfDatabase()
							.getText();
					DatabaseProvider = panelThesisDetail
							.getTaDatabaseProvider().getText();
					Language = panelThesisDetail.getTaLanguage().getText();

					loadDatabase.updateDatabase(queryModel.getQuerySaveThesis(
							ReferenceID, Author, Year, Title, SecondaryAuthor,
							AcademicDepartment, PlacePublished, University,
							Degree, NumberOfVolumes, DocumentNumber,
							NumberOfPages, Advisor, Date, ThesisType,
							ShortTitle, ISBN, DOI, AccessionNumber, CallNumber,
							Label, Keywords, Abstract, Notes, ResearchNotes,
							URL, AuthorAddress, Figure, Caption, AccessDate,
							TranslatedAuthor, TranslatedTitle, NameOfDatabase,
							DatabaseProvider, Language));
					break;
				}
			}
		});
	}

	private void updateTable() {
		int rowIndex = tableCenter.getSelectedRow();
		TreePath treeSelectedPath = treeMap.getSelectionPath();
		treeMap.setSelectionRow(0);
		treeMap.setSelectionRow(1);
		treeMap.setSelectionPath(treeSelectedPath);
		tableCenter.setRowSelectionInterval(rowIndex, rowIndex);
	}
}

package gui.panesFunction;

import gui.MainGUI;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelBookDetail;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelConferenceProceedingsDetail;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelJournalArticleDetail;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelReportDetail;
import gui.panels.PanelRightInner.PanelReferenceDetailTabInner.PanelThesisDetail;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import services.LoadDatabase;
import services.QueryModel;
import services.controls.ComboxTypeSelection;

public class FrameNewReference extends JFrame {
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

	private MainGUI mainFrame;
	private JPanel panelNewReference;
	private LoadDatabase loadDatabase;
	private QueryModel queryModel;

	JButton buttonCreate;

	public FrameNewReference(MainGUI mainFrame, LoadDatabase loadDatabase,
			QueryModel queryModel) {
		this.mainFrame = mainFrame;
		this.loadDatabase = loadDatabase;
		this.queryModel = queryModel;
		panelNewReference = new JPanel();
		panelNewReference.setLayout(new BorderLayout());
		this.setBounds(300, 100, 600, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(panelNewReference, BorderLayout.CENTER);
		init();
	}

	private void init() {
		/**
		 * panel panelReferenceSelected hiển thị chi tiết Reference được chọn
		 */

		// comboBoxType hiện thị các kiểu Reference
		JLabel label = new JLabel("Reference Type:");
		String listItem[] = { "Book", "Report", "Journal Article",
				"Conference Proceedings", "Thesis" };
		comboBoxType = new JComboBox<String>(listItem);
		// button Create lưu thông tin tạo mới reference
		buttonCreate = new JButton("Create");
		// thêm action cho buttonCreate
		buttonCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!checkValidate()) {
					JOptionPane.showMessageDialog(null,
							"Author and Title must be NOT NULL !");
				} else {
					updateCreate();
					Exit();
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

			private void updateCreate() {
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

					loadDatabase.updateDatabase(queryModel.getQueryNewBook(
							Author, Year, Title, SeriesEditor, SeriesTitle,
							PlacePublished, Publisher, Volume, NumberOfVolumes,
							SeriesVolume, NumberOfPages, Pages, Editor,
							Edition, Date, TypeOfWork, Translator, ShortTitle,
							Abbreviation, ISBN, DOI, OriginalPublication,
							ReprintEdition, TitlePrefix, Reviewer,
							AccessionNumber, CallNumber, Label, Keywords,
							Abstract, Notes, ResearchNotes, URL, AuthorAddress,
							Figure, Caption, AccessDate, TranslatedAuthor,
							TranslatedTitle, NameOfDatabase, DatabaseProvider,
							Language));
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

					loadDatabase.updateDatabase(queryModel.getQueryNewReport(
							Author, Year, Title, SeriesEditor, SeriesTitle,
							PlacePublished, Institution, Volume,
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
							.getQueryNewJournalArticle(Author, Year, Title,
									SecondaryAuthor, Journal, PlacePublished,
									Publisher, Volume, NumberOfVolumes, Issue,
									Pages, StartPage, EpubDate, Date,
									TypeOfArticle, ShortTitle,
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
							.getQueryNewConferenceProceedings(Author,
									YearOfConference, Title, Editor,
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

					loadDatabase.updateDatabase(queryModel.getQueryNewThesis(
							Author, Year, Title, SecondaryAuthor,
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

		JPanel panelReferenceSelectedNorth = new JPanel(new FlowLayout());
		// thêm label vào panelReferenceSelectedNorth
		panelReferenceSelectedNorth.add(label);
		// thêm comboBoxType vào panelReferenceSelectedNorth
		panelReferenceSelectedNorth.add(comboBoxType);
		// thêm buttonCreate vào panelReferenceSelectedNorth
		panelReferenceSelectedNorth.add(buttonCreate);

		// panelReferenceSelectedCenter hiển thị tương ứng với kiểu Reference
		panelBookDetail = new PanelBookDetail();
		panelReportDetail = new PanelReportDetail();
		panelJournalArticleDetail = new PanelJournalArticleDetail();
		panelConferenceProceedingsDetail = new PanelConferenceProceedingsDetail();
		panelThesisDetail = new PanelThesisDetail();

		JPanel panelCenter = new JPanel();

		panelCenter = new JPanel(new CardLayout());
		panelCenter.add("Book", panelBookDetail);
		panelCenter.add("Report", panelReportDetail);
		panelCenter.add("Journal Article", panelJournalArticleDetail);
		panelCenter.add("Conference Proceedings",
				panelConferenceProceedingsDetail);
		panelCenter.add("Thesis", panelThesisDetail);

		new ComboxTypeSelection(comboBoxType, panelCenter).update();

		panelNewReference.add(panelReferenceSelectedNorth, BorderLayout.NORTH);
		panelNewReference
				.add(new JScrollPane(panelCenter), BorderLayout.CENTER);
	}

	private void Exit() {
		mainFrame.getPanelLeft().getTreeMap().setSelectionRow(1);
		mainFrame.getPanelLeft().getTreeMap().setSelectionRow(0);
		mainFrame.getPanelLeft().getTreeMap().setSelectionRow(1);
		mainFrame.getPanelLeft().getTreeMap().updateUI();
		
		mainFrame.setEnabled(true);
		this.dispose();
	}

	public JComboBox<String> getComboBoxType() {
		return comboBoxType;
	}

	public JButton getButtonCreate() {
		return buttonCreate;
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
}

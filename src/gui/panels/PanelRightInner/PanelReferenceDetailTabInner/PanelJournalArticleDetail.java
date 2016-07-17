package gui.panels.PanelRightInner.PanelReferenceDetailTabInner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelJournalArticleDetail extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextArea taAuthor = new JTextArea();
	JTextArea taYear = new JTextArea();
	JTextArea taTitle = new JTextArea();
	JTextArea taSecondaryAuthor = new JTextArea();
	JTextArea taJournal = new JTextArea();
	JTextArea taPlacePublished = new JTextArea();
	JTextArea taPublisher = new JTextArea();
	JTextArea taVolume = new JTextArea();
	JTextArea taNumberOfVolumes = new JTextArea();
	JTextArea taIssue = new JTextArea();
	JTextArea taPages = new JTextArea();
	JTextArea taStartPage = new JTextArea();
	JTextArea taEpubDate = new JTextArea();
	JTextArea taDate = new JTextArea();
	JTextArea taTypeOfArticle = new JTextArea();
	JTextArea taShortTitle = new JTextArea();
	JTextArea taAlternateJournal = new JTextArea();
	JTextArea taISBN = new JTextArea();
	JTextArea taDOI = new JTextArea();
	JTextArea taOriginalPublication = new JTextArea();
	JTextArea taReprintEdition = new JTextArea();
	JTextArea taReviewedItem = new JTextArea();
	JTextArea taLegalNote = new JTextArea();
	JTextArea taPMCID = new JTextArea();
	JTextArea taNIHMSID = new JTextArea();
	JTextArea taArticleNumber = new JTextArea();
	JTextArea taAccessionNumber = new JTextArea();
	JTextArea taCallNumber = new JTextArea();
	JTextArea taLabel = new JTextArea();
	JTextArea taKeywords = new JTextArea();
	JTextArea taAbstract = new JTextArea();
	JTextArea taNotes = new JTextArea();
	JTextArea taResearchNotes = new JTextArea();
	JTextArea taURL = new JTextArea();
	JTextArea taAuthorAddress = new JTextArea();
	JTextArea taFigure = new JTextArea();
	JTextArea taCaption = new JTextArea();
	JTextArea taAccessDate = new JTextArea();
	JTextArea taTranslatedAuthor = new JTextArea();
	JTextArea taTranslatedTitle = new JTextArea();
	JTextArea taNameOfDatabase = new JTextArea();
	JTextArea taDatabaseProvider = new JTextArea();
	JTextArea taLanguage = new JTextArea();

	public PanelJournalArticleDetail() {

		taAuthor.setBorder(BorderFactory.createTitledBorder("Author"));
		taYear.setBorder(BorderFactory.createTitledBorder("Year"));
		taTitle.setBorder(BorderFactory.createTitledBorder("Title"));
		taSecondaryAuthor.setBorder(BorderFactory.createTitledBorder("Secondary Author"));
		taJournal.setBorder(BorderFactory.createTitledBorder("Journal"));
		taPlacePublished.setBorder(BorderFactory.createTitledBorder("Place Published"));
		taPublisher.setBorder(BorderFactory.createTitledBorder("Publisher"));
		taVolume.setBorder(BorderFactory.createTitledBorder("Volume"));
		taNumberOfVolumes.setBorder(BorderFactory.createTitledBorder("Number of Volumes"));
		taIssue.setBorder(BorderFactory.createTitledBorder("Issue"));
		taPages.setBorder(BorderFactory.createTitledBorder("Pages"));
		taStartPage.setBorder(BorderFactory.createTitledBorder("Start Page"));
		taEpubDate.setBorder(BorderFactory.createTitledBorder("EpubDate"));
		taDate.setBorder(BorderFactory.createTitledBorder("Date"));
		taTypeOfArticle.setBorder(BorderFactory.createTitledBorder("Type of Article"));
		taShortTitle.setBorder(BorderFactory.createTitledBorder("Short Title"));
		taAlternateJournal.setBorder(BorderFactory.createTitledBorder("Alternate Journal"));
		taISBN.setBorder(BorderFactory.createTitledBorder("ISBN"));
		taDOI.setBorder(BorderFactory.createTitledBorder("DOI"));
		taOriginalPublication.setBorder(BorderFactory.createTitledBorder("Original Publication"));
		taReprintEdition.setBorder(BorderFactory.createTitledBorder("Reprint Edition"));
		taReviewedItem.setBorder(BorderFactory.createTitledBorder("Reviewed Item"));
		taLegalNote.setBorder(BorderFactory.createTitledBorder("Legal Note"));
		taPMCID.setBorder(BorderFactory.createTitledBorder("PMCID"));
		taNIHMSID.setBorder(BorderFactory.createTitledBorder("NIHMSID"));
		taArticleNumber.setBorder(BorderFactory.createTitledBorder("Article Number"));
		taAccessionNumber.setBorder(BorderFactory.createTitledBorder("Accession Number"));
		taCallNumber.setBorder(BorderFactory.createTitledBorder("Call Number"));
		taLabel.setBorder(BorderFactory.createTitledBorder("Label"));
		taKeywords.setBorder(BorderFactory.createTitledBorder("Keywords"));
		taAbstract.setBorder(BorderFactory.createTitledBorder("Abstract"));
		taNotes.setBorder(BorderFactory.createTitledBorder("Notes"));
		taResearchNotes.setBorder(BorderFactory.createTitledBorder("Research Notes"));
		taURL.setBorder(BorderFactory.createTitledBorder("URL"));
		taAuthorAddress.setBorder(BorderFactory.createTitledBorder("Author Address"));
		taFigure.setBorder(BorderFactory.createTitledBorder("Figure"));
		taCaption.setBorder(BorderFactory.createTitledBorder("Caption"));
		taAccessDate.setBorder(BorderFactory.createTitledBorder("AccessDate"));
		taTranslatedAuthor.setBorder(BorderFactory.createTitledBorder("Translated Author"));
		taTranslatedTitle.setBorder(BorderFactory.createTitledBorder("Translated Title"));
		taNameOfDatabase.setBorder(BorderFactory.createTitledBorder("Name of Database"));
		taDatabaseProvider.setBorder(BorderFactory.createTitledBorder("Database Provider"));
		taLanguage.setBorder(BorderFactory.createTitledBorder("Language"));

		this.setLayout(new BoxLayout(this, WIDTH));
		this.add(taAuthor);
		this.add(taYear);
		this.add(taTitle);
		this.add(taSecondaryAuthor);
		this.add(taJournal);
		this.add(taPlacePublished);
		this.add(taPublisher);
		this.add(taVolume);
		this.add(taNumberOfVolumes);
		this.add(taIssue);
		this.add(taPages);
		this.add(taStartPage);
		this.add(taEpubDate);
		this.add(taDate);
		this.add(taTypeOfArticle);
		this.add(taShortTitle);
		this.add(taAlternateJournal);
		this.add(taISBN);
		this.add(taDOI);
		this.add(taOriginalPublication);
		this.add(taReprintEdition);
		this.add(taReviewedItem);
		this.add(taLegalNote);
		this.add(taPMCID);
		this.add(taNIHMSID);
		this.add(taArticleNumber);
		this.add(taAccessionNumber);
		this.add(taCallNumber);
		this.add(taLabel);
		this.add(taKeywords);
		this.add(taAbstract);
		this.add(taNotes);
		this.add(taResearchNotes);
		this.add(taURL);
		this.add(taAuthorAddress);
		this.add(taFigure);
		this.add(taCaption);
		this.add(taAccessDate);
		this.add(taTranslatedAuthor);
		this.add(taTranslatedTitle);
		this.add(taNameOfDatabase);
		this.add(taDatabaseProvider);
		this.add(taLanguage);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JTextArea getTaAuthor() {
		return taAuthor;
	}

	public JTextArea getTaYear() {
		return taYear;
	}

	public JTextArea getTaTitle() {
		return taTitle;
	}

	public JTextArea getTaSecondaryAuthor() {
		return taSecondaryAuthor;
	}

	public JTextArea getTaJournal() {
		return taJournal;
	}

	public JTextArea getTaPlacePublished() {
		return taPlacePublished;
	}

	public JTextArea getTaPublisher() {
		return taPublisher;
	}

	public JTextArea getTaVolume() {
		return taVolume;
	}

	public JTextArea getTaNumberOfVolumes() {
		return taNumberOfVolumes;
	}

	public JTextArea getTaIssue() {
		return taIssue;
	}

	public JTextArea getTaPages() {
		return taPages;
	}

	public JTextArea getTaStartPage() {
		return taStartPage;
	}

	public JTextArea getTaEpubDate() {
		return taEpubDate;
	}

	public JTextArea getTaDate() {
		return taDate;
	}

	public JTextArea getTaTypeOfArticle() {
		return taTypeOfArticle;
	}

	public JTextArea getTaShortTitle() {
		return taShortTitle;
	}

	public JTextArea getTaAlternateJournal() {
		return taAlternateJournal;
	}

	public JTextArea getTaISBN() {
		return taISBN;
	}

	public JTextArea getTaDOI() {
		return taDOI;
	}

	public JTextArea getTaOriginalPublication() {
		return taOriginalPublication;
	}

	public JTextArea getTaReprintEdition() {
		return taReprintEdition;
	}

	public JTextArea getTaReviewedItem() {
		return taReviewedItem;
	}

	public JTextArea getTaLegalNote() {
		return taLegalNote;
	}

	public JTextArea getTaPMCID() {
		return taPMCID;
	}

	public JTextArea getTaNIHMSID() {
		return taNIHMSID;
	}

	public JTextArea getTaArticleNumber() {
		return taArticleNumber;
	}

	public JTextArea getTaAccessionNumber() {
		return taAccessionNumber;
	}

	public JTextArea getTaCallNumber() {
		return taCallNumber;
	}

	public JTextArea getTaLabel() {
		return taLabel;
	}

	public JTextArea getTaKeywords() {
		return taKeywords;
	}

	public JTextArea getTaAbstract() {
		return taAbstract;
	}

	public JTextArea getTaNotes() {
		return taNotes;
	}

	public JTextArea getTaResearchNotes() {
		return taResearchNotes;
	}

	public JTextArea getTaURL() {
		return taURL;
	}

	public JTextArea getTaAuthorAddress() {
		return taAuthorAddress;
	}

	public JTextArea getTaFigure() {
		return taFigure;
	}

	public JTextArea getTaCaption() {
		return taCaption;
	}

	public JTextArea getTaAccessDate() {
		return taAccessDate;
	}

	public JTextArea getTaTranslatedAuthor() {
		return taTranslatedAuthor;
	}

	public JTextArea getTaTranslatedTitle() {
		return taTranslatedTitle;
	}

	public JTextArea getTaNameOfDatabase() {
		return taNameOfDatabase;
	}

	public JTextArea getTaDatabaseProvider() {
		return taDatabaseProvider;
	}

	public JTextArea getTaLanguage() {
		return taLanguage;
	}
}

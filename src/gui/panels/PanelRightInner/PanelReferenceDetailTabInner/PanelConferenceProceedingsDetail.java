package gui.panels.PanelRightInner.PanelReferenceDetailTabInner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelConferenceProceedingsDetail extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextArea taAuthor = new JTextArea();
	JTextArea taYearOfConference = new JTextArea();
	JTextArea taTitle = new JTextArea();
	JTextArea taEditor = new JTextArea();
	JTextArea taConferenceName = new JTextArea();
	JTextArea taConferenceLocation = new JTextArea();
	JTextArea taPublisher = new JTextArea();
	JTextArea taVolume = new JTextArea();
	JTextArea taNumberOfVolumes = new JTextArea();
	JTextArea taIssue = new JTextArea();
	JTextArea taPages = new JTextArea();
	JTextArea taSeriesEditor = new JTextArea();
	JTextArea taSeriesTitle = new JTextArea();
	JTextArea taEdition = new JTextArea();
	JTextArea taDate = new JTextArea();
	JTextArea taSponsor = new JTextArea();
	JTextArea taShortTitle = new JTextArea();
	JTextArea taISBN = new JTextArea();
	JTextArea taDOI = new JTextArea();
	JTextArea taSource = new JTextArea();
	JTextArea taPlacePublished = new JTextArea();
	JTextArea taYearPublished = new JTextArea();
	JTextArea taProceedingsTitle = new JTextArea();
	JTextArea taPackagingMethod = new JTextArea();
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

	public PanelConferenceProceedingsDetail() {

		taAuthor.setBorder(BorderFactory.createTitledBorder("Author"));
		taYearOfConference.setBorder(BorderFactory.createTitledBorder("Year of Conference"));
		taTitle.setBorder(BorderFactory.createTitledBorder("Title"));
		taEditor.setBorder(BorderFactory.createTitledBorder("Editor"));
		taConferenceName.setBorder(BorderFactory.createTitledBorder("Conference Name"));
		taConferenceLocation.setBorder(BorderFactory.createTitledBorder("Conference Location"));
		taPublisher.setBorder(BorderFactory.createTitledBorder("Publisher"));
		taVolume.setBorder(BorderFactory.createTitledBorder("Volume"));
		taNumberOfVolumes.setBorder(BorderFactory.createTitledBorder("Number of Volumes"));
		taIssue.setBorder(BorderFactory.createTitledBorder("Issue"));
		taPages.setBorder(BorderFactory.createTitledBorder("Pages"));
		taSeriesEditor.setBorder(BorderFactory.createTitledBorder("Series Editor"));
		taSeriesTitle.setBorder(BorderFactory.createTitledBorder("Series Title"));
		taEdition.setBorder(BorderFactory.createTitledBorder("Edition"));
		taDate.setBorder(BorderFactory.createTitledBorder("Date"));
		taSponsor.setBorder(BorderFactory.createTitledBorder("Sponsor"));
		taShortTitle.setBorder(BorderFactory.createTitledBorder("Short Title"));
		taISBN.setBorder(BorderFactory.createTitledBorder("ISBN"));
		taDOI.setBorder(BorderFactory.createTitledBorder("DOI"));
		taSource.setBorder(BorderFactory.createTitledBorder("Source"));
		taPlacePublished.setBorder(BorderFactory.createTitledBorder("Place Published"));
		taYearPublished.setBorder(BorderFactory.createTitledBorder("Year Published"));
		taProceedingsTitle.setBorder(BorderFactory.createTitledBorder("Proceedings Title"));
		taPackagingMethod.setBorder(BorderFactory.createTitledBorder("Packaging Method"));
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
		this.add(taYearOfConference);
		this.add(taTitle);
		this.add(taEditor);
		this.add(taConferenceName);
		this.add(taConferenceLocation);
		this.add(taPublisher);
		this.add(taVolume);
		this.add(taNumberOfVolumes);
		this.add(taIssue);
		this.add(taPages);
		this.add(taSeriesEditor);
		this.add(taSeriesTitle);
		this.add(taEdition);
		this.add(taDate);
		this.add(taSponsor);
		this.add(taShortTitle);
		this.add(taISBN);
		this.add(taDOI);
		this.add(taSource);
		this.add(taPlacePublished);
		this.add(taYearPublished);
		this.add(taProceedingsTitle);
		this.add(taPackagingMethod);
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

	public JTextArea getTaYearOfConference() {
		return taYearOfConference;
	}

	public JTextArea getTaTitle() {
		return taTitle;
	}

	public JTextArea getTaEditor() {
		return taEditor;
	}

	public JTextArea getTaConferenceName() {
		return taConferenceName;
	}

	public JTextArea getTaConferenceLocation() {
		return taConferenceLocation;
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

	public JTextArea getTaSeriesEditor() {
		return taSeriesEditor;
	}

	public JTextArea getTaSeriesTitle() {
		return taSeriesTitle;
	}

	public JTextArea getTaEdition() {
		return taEdition;
	}

	public JTextArea getTaDate() {
		return taDate;
	}

	public JTextArea getTaSponsor() {
		return taSponsor;
	}

	public JTextArea getTaShortTitle() {
		return taShortTitle;
	}

	public JTextArea getTaISBN() {
		return taISBN;
	}

	public JTextArea getTaDOI() {
		return taDOI;
	}

	public JTextArea getTaSource() {
		return taSource;
	}

	public JTextArea getTaPlacePublished() {
		return taPlacePublished;
	}

	public JTextArea getTaYearPublished() {
		return taYearPublished;
	}

	public JTextArea getTaProceedingsTitle() {
		return taProceedingsTitle;
	}

	public JTextArea getTaPackagingMethod() {
		return taPackagingMethod;
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

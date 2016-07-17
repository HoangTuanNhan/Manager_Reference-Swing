package gui.panels.PanelRightInner.PanelReferenceDetailTabInner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelReportDetail extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextArea taAuthor = new JTextArea();
	JTextArea taYear = new JTextArea();
	JTextArea taTitle = new JTextArea();
	JTextArea taSeriesEditor = new JTextArea();
	JTextArea taSeriesTitle = new JTextArea();
	JTextArea taPlacePublished = new JTextArea();
	JTextArea taInstitution = new JTextArea();
	JTextArea taVolume = new JTextArea();
	JTextArea taNumberOfVolumes = new JTextArea();
	JTextArea taSeriesVolume = new JTextArea();
	JTextArea taDocumentNumber = new JTextArea();
	JTextArea taPages = new JTextArea();
	JTextArea taPublisher = new JTextArea();
	JTextArea taEdition = new JTextArea();
	JTextArea taDate = new JTextArea();
	JTextArea taType = new JTextArea();
	JTextArea taDepartment = new JTextArea();
	JTextArea taShortTitle = new JTextArea();
	JTextArea taAlternateTitle = new JTextArea();
	JTextArea taReportNumber = new JTextArea();
	JTextArea taDOI = new JTextArea();
	JTextArea taContents = new JTextArea();
	JTextArea taIssue = new JTextArea();
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

	public PanelReportDetail() {

		taAuthor.setBorder(BorderFactory.createTitledBorder("Author"));
		taYear.setBorder(BorderFactory.createTitledBorder("Year"));
		taTitle.setBorder(BorderFactory.createTitledBorder("Title"));
		taSeriesEditor.setBorder(BorderFactory.createTitledBorder("Series Editor"));
		taSeriesTitle.setBorder(BorderFactory.createTitledBorder("Series Title"));
		taPlacePublished.setBorder(BorderFactory.createTitledBorder("Place Published"));
		taInstitution.setBorder(BorderFactory.createTitledBorder("Institution"));
		taVolume.setBorder(BorderFactory.createTitledBorder("Volume"));
		taNumberOfVolumes.setBorder(BorderFactory.createTitledBorder("Number of Volumes"));
		taSeriesVolume.setBorder(BorderFactory.createTitledBorder("Series Volume"));
		taDocumentNumber.setBorder(BorderFactory.createTitledBorder("Document Number"));
		taPages.setBorder(BorderFactory.createTitledBorder("Pages"));
		taPublisher.setBorder(BorderFactory.createTitledBorder("Publisher"));
		taEdition.setBorder(BorderFactory.createTitledBorder("Edition"));
		taDate.setBorder(BorderFactory.createTitledBorder("Date"));
		taType.setBorder(BorderFactory.createTitledBorder("Type"));
		taDepartment.setBorder(BorderFactory.createTitledBorder("Department"));
		taShortTitle.setBorder(BorderFactory.createTitledBorder("Short Title"));
		taAlternateTitle.setBorder(BorderFactory.createTitledBorder("Alternate Title"));
		taReportNumber.setBorder(BorderFactory.createTitledBorder("Report Number"));
		taDOI.setBorder(BorderFactory.createTitledBorder("DOI"));
		taContents.setBorder(BorderFactory.createTitledBorder("Contents"));
		taIssue.setBorder(BorderFactory.createTitledBorder("Issue"));
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
		this.add(taSeriesEditor);
		this.add(taSeriesTitle);
		this.add(taPlacePublished);
		this.add(taInstitution);
		this.add(taVolume);
		this.add(taNumberOfVolumes);
		this.add(taSeriesVolume);
		this.add(taDocumentNumber);
		this.add(taPages);
		this.add(taPublisher);
		this.add(taEdition);
		this.add(taDate);
		this.add(taType);
		this.add(taDepartment);
		this.add(taShortTitle);
		this.add(taAlternateTitle);
		this.add(taReportNumber);
		this.add(taDOI);
		this.add(taContents);
		this.add(taIssue);
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

	public JTextArea getTaAuthor() {
		return taAuthor;
	}

	public JTextArea getTaYear() {
		return taYear;
	}

	public JTextArea getTaTitle() {
		return taTitle;
	}

	public JTextArea getTaSeriesEditor() {
		return taSeriesEditor;
	}

	public JTextArea getTaSeriesTitle() {
		return taSeriesTitle;
	}

	public JTextArea getTaPlacePublished() {
		return taPlacePublished;
	}

	public JTextArea getTaInstitution() {
		return taInstitution;
	}

	public JTextArea getTaVolume() {
		return taVolume;
	}

	public JTextArea getTaNumberOfVolumes() {
		return taNumberOfVolumes;
	}

	public JTextArea getTaSeriesVolume() {
		return taSeriesVolume;
	}

	public JTextArea getTaDocumentNumber() {
		return taDocumentNumber;
	}

	public JTextArea getTaPages() {
		return taPages;
	}

	public JTextArea getTaPublisher() {
		return taPublisher;
	}

	public JTextArea getTaEdition() {
		return taEdition;
	}

	public JTextArea getTaDate() {
		return taDate;
	}

	public JTextArea getTaType() {
		return taType;
	}

	public JTextArea getTaDepartment() {
		return taDepartment;
	}

	public JTextArea getTaShortTitle() {
		return taShortTitle;
	}

	public JTextArea getTaAlternateTitle() {
		return taAlternateTitle;
	}

	public JTextArea getTaReportNumber() {
		return taReportNumber;
	}

	public JTextArea getTaDOI() {
		return taDOI;
	}

	public JTextArea getTaContents() {
		return taContents;
	}

	public JTextArea getTaIssue() {
		return taIssue;
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

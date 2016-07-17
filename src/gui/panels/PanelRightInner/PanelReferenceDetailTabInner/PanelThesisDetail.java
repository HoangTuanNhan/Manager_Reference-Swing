package gui.panels.PanelRightInner.PanelReferenceDetailTabInner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelThesisDetail extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextArea taAuthor = new JTextArea();
	JTextArea taYear = new JTextArea();
	JTextArea taTitle = new JTextArea();
	JTextArea taSecondaryAuthor = new JTextArea();
	JTextArea taAcademicDepartment = new JTextArea();
	JTextArea taPlacePublished = new JTextArea();
	JTextArea taUniversity = new JTextArea();
	JTextArea taDegree = new JTextArea();
	JTextArea taNumberOfVolumes = new JTextArea();
	JTextArea taDocumentNumber = new JTextArea();
	JTextArea taNumberOfPages = new JTextArea();
	JTextArea taAdvisor = new JTextArea();
	JTextArea taDate = new JTextArea();
	JTextArea taThesisType = new JTextArea();
	JTextArea taShortTitle = new JTextArea();
	JTextArea taISBN = new JTextArea();
	JTextArea taDOI = new JTextArea();
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

	public PanelThesisDetail() {

		taAuthor.setBorder(BorderFactory.createTitledBorder("Author"));
		taYear.setBorder(BorderFactory.createTitledBorder("Year"));
		taTitle.setBorder(BorderFactory.createTitledBorder("Title"));
		taSecondaryAuthor.setBorder(BorderFactory.createTitledBorder("Secondary Author"));
		taAcademicDepartment.setBorder(BorderFactory.createTitledBorder("Academic Department"));
		taPlacePublished.setBorder(BorderFactory.createTitledBorder("Place Published"));
		taUniversity.setBorder(BorderFactory.createTitledBorder("University"));
		taDegree.setBorder(BorderFactory.createTitledBorder("Degree"));
		taNumberOfVolumes.setBorder(BorderFactory.createTitledBorder("Number of Volumes"));
		taDocumentNumber.setBorder(BorderFactory.createTitledBorder("Document Number"));
		taNumberOfPages.setBorder(BorderFactory.createTitledBorder("Number of Pages"));
		taAdvisor.setBorder(BorderFactory.createTitledBorder("Advisor"));
		taDate.setBorder(BorderFactory.createTitledBorder("Date"));
		taThesisType.setBorder(BorderFactory.createTitledBorder("Thesis Type"));
		taShortTitle.setBorder(BorderFactory.createTitledBorder("Short Title"));
		taISBN.setBorder(BorderFactory.createTitledBorder("ISBN"));
		taDOI.setBorder(BorderFactory.createTitledBorder("DOI"));
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
		this.add(taAcademicDepartment);
		this.add(taPlacePublished);
		this.add(taUniversity);
		this.add(taDegree);
		this.add(taNumberOfVolumes);
		this.add(taDocumentNumber);
		this.add(taNumberOfPages);
		this.add(taAdvisor);
		this.add(taDate);
		this.add(taThesisType);
		this.add(taShortTitle);
		this.add(taISBN);
		this.add(taDOI);
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

	public JTextArea getTaAcademicDepartment() {
		return taAcademicDepartment;
	}

	public JTextArea getTaPlacePublished() {
		return taPlacePublished;
	}

	public JTextArea getTaUniversity() {
		return taUniversity;
	}

	public JTextArea getTaDegree() {
		return taDegree;
	}

	public JTextArea getTaNumberOfVolumes() {
		return taNumberOfVolumes;
	}

	public JTextArea getTaDocumentNumber() {
		return taDocumentNumber;
	}

	public JTextArea getTaNumberOfPages() {
		return taNumberOfPages;
	}

	public JTextArea getTaAdvisor() {
		return taAdvisor;
	}

	public JTextArea getTaDate() {
		return taDate;
	}

	public JTextArea getTaThesisType() {
		return taThesisType;
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

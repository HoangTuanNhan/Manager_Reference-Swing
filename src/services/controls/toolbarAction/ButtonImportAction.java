package services.controls.toolbarAction;

import gui.MainGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import services.LoadDatabase;
import services.QueryModel;

public class ButtonImportAction {

	MainGUI mainFrame;
	private LoadDatabase loadDatabase;
	private QueryModel queryModel;

	private JButton buttonImportAction;

	public ButtonImportAction(MainGUI mainFrame, LoadDatabase loadDatabase,
			QueryModel queryModel) {
		this.mainFrame = mainFrame;
		this.loadDatabase = loadDatabase;
		this.queryModel = queryModel;

		this.buttonImportAction = mainFrame.getToolBar().getButtonImport();
	}

	public void addAction() {
		addButtonImportAction();
	}

	private void addButtonImportAction() {
		buttonImportAction.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> contentFile = getContentFile();
				
				if (contentFile == null) {
					return;
				}
				
				importContentIntoDatabase(contentFile);
				mainFrame.getPanelLeft().getTreeMap().setSelectionRow(0);
				mainFrame.getPanelLeft().getTreeMap().setSelectionRow(2);
				mainFrame.getPanelLeft().getTreeMap().setSelectionRow(1);
			}
		});
	}

	private ArrayList<String> getContentFile() {
		ArrayList<String> list = new ArrayList<String>();
		String filePath = getFilePath();
		
		if (filePath == null) {
			return null;
		}
		
		File file = new File(filePath);
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;

			while ((text = reader.readLine()) != null) {
				list.add(text);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}

		return list;

	}

	private String getFilePath() {
		String filename = null;
		String dir = null;
		JFileChooser fileChooser = new JFileChooser();

		int rVal = fileChooser.showOpenDialog(null);
		if (rVal == JFileChooser.APPROVE_OPTION) {
			filename = fileChooser.getSelectedFile().getName();
			dir = fileChooser.getCurrentDirectory().toString();
			return dir + "\\" + filename;
		} else {
			return null;
		}
	}

	private void importContentIntoDatabase(ArrayList<String> contentFile) {
		int index = 0;
		while (index < contentFile.size()) {
			String str = contentFile.get(index);
			if (str.contains("@book")) {
				index = importBook(index, contentFile);
			} else if (str.contains("@report")) {
				index = importReport(index, contentFile);
			} else if (str.contains("@journal")) {
				index = importJournal(index, contentFile);
			} else if (str.contains("@conference")) {
				index = importConference(index, contentFile);
			} else if (str.contains("@thesis")) {
				index = importThesis(index, contentFile);
			} else {
				index++;
			}
		}
	}

	private int importBook(int index, ArrayList<String> contentFile) {
		index ++;
		
		String Author = "", Year = "", Title = "", SeriesEditor = "", SeriesTitle = "",
		PlacePublished = "", Publisher = "", Volume = "", NumberOfVolumes = "",
		SeriesVolume = "", NumberOfPages = "", Pages = "", Editor = "",
		Edition = "", Date = "", TypeOfWork = "", Translator = "", ShortTitle = "",
		Abbreviation = "", ISBN = "", DOI = "", OriginalPublication = "",
		ReprintEdition = "", TitlePrefix = "", Reviewer = "",
		AccessionNumber = "", CallNumber = "", Label = "", Keywords = "",
		Abstract = "", Notes = "", ResearchNotes = "", URL = "", AuthorAddress = "",
		Figure = "", Caption = "", AccessDate = "", TranslatedAuthor = "",
		TranslatedTitle = "", NameOfDatabase = "", DatabaseProvider = "",
		Language = "";
		
		while (!contentFile.get(index).trim().equals("}") && index < contentFile.size()) {
			if (!contentFile.get(index).contains("=")) {
				index ++;
				continue;
			}
			String [] strArray = contentFile.get(index).split("=");
			
			strArray[0] = strArray[0].trim();
			
			strArray[1] = strArray[1].trim();
			if (strArray[1].charAt(strArray[1].length() - 1) == ',') {
				strArray[1] = strArray[1].substring(0, strArray[1].length()-1);
			}
			if (strArray[1].charAt(0) == '{') {
				strArray[1] = strArray[1].substring(1, strArray[1].length()-1);
			}
			
			switch(strArray[0]) {
			case "author":
				Author = strArray[1];
				break;
			case "year":
				Year = strArray[1];
				break;
			case "title": 
				Title = strArray[1];
				break;
			case "seriesEditor":
				SeriesEditor = strArray[1];
				break;
			case "SeriesTitle":
				SeriesTitle = strArray[1];
				break;
			case "placePublished":
				PlacePublished = strArray[1];
				break;
			case "publisher":
				Publisher = strArray[1];
				break;
			case "volume":
				Volume = strArray[1];
				break;
			case "series":
				NumberOfVolumes = strArray[1];
				break;
			case "seriesVolume":
				SeriesVolume = strArray[1];
				break;
			case "numberOfPages":
				NumberOfPages = strArray[1];
				break;
			case "pages":
				Pages = strArray[1];
				break;
			case "editor":
				Editor = strArray[1];
			break;
			case "edition":
				Edition = strArray[1];
			break;
			case "date":
				Date = strArray[1];
			break;
			case "typeOfWork":
				TypeOfWork = strArray[1];
			break;
			case "translator":
				Translator = strArray[1];
			break;
			case "shortTitle":
				ShortTitle = strArray[1];
			break;
			case "abbreviation":
				Abbreviation = strArray[1];
			break;
			case "ISBN":
				ISBN = strArray[1];
			break;
			case "DOI":
				DOI = strArray[1];
			break;
			case "organization":
				OriginalPublication = strArray[1];
			break;
			case "reprintEdition":
				ReprintEdition = strArray[1];
			break;
			case "titlePrefix":
				TitlePrefix = strArray[1];
			break;
			case "reviewer":
				Reviewer = strArray[1];
			break;
			case "accessionNumber":
				AccessionNumber = strArray[1];
			break;
			case "callNumber":
				CallNumber = strArray[1];
			break;
			case "label":
				Label = strArray[1];
			break;
			case "keywords":
				Keywords = strArray[1];
			break;
			case "Abstract":
				Abstract = strArray[1];
				break;
			case "notes":
				Notes = strArray[1];
				break;
			case "researchNotes":
				ResearchNotes = strArray[1];
				break;
			case "URL":
				URL = strArray[1];
				break;
			case "authorAddress":
				AuthorAddress = strArray[1];
				break;
			case "figure":
				Figure = strArray[1];
				break;
			case "caption":
				Caption = strArray[1];
				break;
			case "accessDate":
				AccessDate = strArray[1];
				break;
			case "translatedAuthor":
				TranslatedAuthor = strArray[1];
				break;
			case "translatedTitle":
				TranslatedTitle = strArray[1];
				break;
			case "nameOfDatabase":
				NameOfDatabase = strArray[1];
				break;
			case "databaseProvider":
				DatabaseProvider = strArray[1];
				break;
			case "language":
				Language = strArray[1];
				break;
			}
			
			index ++;
		}
		
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
		
		return index + 1;
	}

	private int importReport(int index, ArrayList<String> contentFile) {
		index ++;
		
		String Author = "", Year = "", Title = "", SeriesEditor = "", SeriesTitle = "",
		PlacePublished = "", Institution = "", Volume = "",
		NumberOfVolumes = "", SeriesVolume = "", DocumentNumber = "",
		Pages = "", Publisher = "", Edition = "", Date = "", Type = "", Department = "",
		ShortTitle = "", AlternateTitle = "", ReportNumber = "", DOI = "",
		Contents = "", Issue = "", AccessionNumber = "", CallNumber = "",
		Label = "", Keywords = "", Abstract = "", Notes = "", ResearchNotes = "",
		URL = "", AuthorAddress = "", Figure = "", Caption = "", AccessDate = "",
		TranslatedAuthor = "", TranslatedTitle = "", NameOfDatabase = "",
		DatabaseProvider = "", Language = "";
		
		while (!contentFile.get(index).trim().equals("}") && index < contentFile.size()) {
			if (!contentFile.get(index).contains("=")) {
				index ++;
				continue;
			}
			String [] strArray = contentFile.get(index).split("=");
			
			strArray[0] = strArray[0].trim();
			
			strArray[1] = strArray[1].trim();
			if (strArray[1].charAt(strArray[1].length() - 1) == ',') {
				strArray[1] = strArray[1].substring(0, strArray[1].length()-1);
			}
			if (strArray[1].charAt(0) == '{') {
				strArray[1] = strArray[1].substring(1, strArray[1].length()-1);
			}
			
			switch(strArray[0]) {
			case "author":
				Author = strArray[1];
				break;
			case "year":
				Year = strArray[1];
				break;
			case "title": 
				Title = strArray[1];
				break;
			case "seriesEditor":
				SeriesEditor = strArray[1];
				break;
			case "SeriesTitle":
				SeriesTitle = strArray[1];
				break;
			case "placePublished":
				PlacePublished = strArray[1];
				break;
			case "institution":
				Institution = strArray[1];
				break;
			case "volume":
				Volume = strArray[1];
				break;
			case "series":
				NumberOfVolumes = strArray[1];
				break;
			case "seriesVolume":
				SeriesVolume = strArray[1];
				break;
			case "documentNumber":
				DocumentNumber = strArray[1];
			break;
			case "pages":
				Pages = strArray[1];
				break;
			case "publisher":
				Publisher = strArray[1];
				break;
			case "edition":
				Edition = strArray[1];
			break;
			case "date":
				Date = strArray[1];
			break;
			case "type":
				Type = strArray[1];
			break;
			case "department":
				Department = strArray[1];
			break;
			case "shortTitle":
				ShortTitle = strArray[1];
			break;
			case "alternateTitle":
				AlternateTitle = strArray[1];
			break;
			case "reportNumber":
				ReportNumber = strArray[1];
			break;
			case "DOI":
				DOI = strArray[1];
			break;
			case "contents":
				Contents = strArray[1];
			break;
			case "issue":
				Issue = strArray[1];
			break;
			case "accessionNumber":
				AccessionNumber = strArray[1];
			break;
			case "callNumber":
				CallNumber = strArray[1];
			break;
			case "label":
				Label = strArray[1];
			break;
			case "keywords":
				Keywords = strArray[1];
			break;
			case "Abstract":
				Abstract = strArray[1];
				break;
			case "notes":
				Notes = strArray[1];
				break;
			case "researchNotes":
				ResearchNotes = strArray[1];
				break;
			case "URL":
				URL = strArray[1];
				break;
			case "authorAddress":
				AuthorAddress = strArray[1];
				break;
			case "figure":
				Figure = strArray[1];
				break;
			case "caption":
				Caption = strArray[1];
				break;
			case "accessDate":
				AccessDate = strArray[1];
				break;
			case "translatedAuthor":
				TranslatedAuthor = strArray[1];
				break;
			case "translatedTitle":
				TranslatedTitle = strArray[1];
				break;
			case "nameOfDatabase":
				NameOfDatabase = strArray[1];
				break;
			case "databaseProvider":
				DatabaseProvider = strArray[1];
				break;
			case "language":
				Language = strArray[1];
				break;
			}
			
			index ++;
		}
		
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
		
		return index + 1;
	}

	private int importJournal(int index, ArrayList<String> contentFile) {
		index ++;
		
		String Author = "", Year = "", Title = "",
		SecondaryAuthor = "", Journal = "", PlacePublished = "",
		Publisher = "", Volume = "", NumberOfVolumes = "", Issue = "",
		Pages = "", StartPage = "", EpubDate = "", Date = "",
		TypeOfArticle = "", ShortTitle = "",
		AlternateJournal = "", ISBN = "", DOI = "",
		OriginalPublication = "", ReprintEdition = "",
		ReviewedItem = "", LegalNote = "", PMCID = "", NIHMSID = "",
		ArticleNumber = "", AccessionNumber = "", CallNumber = "",
		Label = "", Keywords = "", Abstract = "", Notes = "",
		ResearchNotes = "", URL = "", AuthorAddress = "", Figure = "",
		Caption = "", AccessDate = "", TranslatedAuthor = "",
		TranslatedTitle = "", NameOfDatabase = "",
		DatabaseProvider = "", Language = "";
		
		while (!contentFile.get(index).trim().equals("}") && index < contentFile.size()) {
			if (!contentFile.get(index).contains("=")) {
				index ++;
				continue;
			}
			String [] strArray = contentFile.get(index).split("=");
			
			strArray[0] = strArray[0].trim();
			
			strArray[1] = strArray[1].trim();
			if (strArray[1].charAt(strArray[1].length() - 1) == ',') {
				strArray[1] = strArray[1].substring(0, strArray[1].length()-1);
			}
			if (strArray[1].charAt(0) == '{') {
				strArray[1] = strArray[1].substring(1, strArray[1].length()-1);
			}
			
			switch(strArray[0]) {
			case "author":
				Author = strArray[1];
				break;
			case "year":
				Year = strArray[1];
				break;
			case "title": 
				Title = strArray[1];
				break;
			case "secondaryAuthor":
				SecondaryAuthor = strArray[1];
				break;
			case "journal":
				Journal = strArray[1];
				break;
			case "placePublished":
				PlacePublished = strArray[1];
				break;
			case "publisher":
				Publisher = strArray[1];
				break;
			case "volume":
				Volume = strArray[1];
				break;
			case "series":
				NumberOfVolumes = strArray[1];
				break;
			case "issue":
				Issue = strArray[1];
				break;
			case "pages":
				Pages = strArray[1];
				break;
			case "startPage":
				StartPage = strArray[1];
			break;
			case "epubDate":
				EpubDate = strArray[1];
			break;
			case "date":
				Date = strArray[1];
			break;
			case "type":
				TypeOfArticle = strArray[1];
			break;
			case "shortTitle":
				ShortTitle = strArray[1];
			break;
			case "alternateJournal":
				AlternateJournal = strArray[1];
			break;
			case "ISBN":
				ISBN = strArray[1];
			break;
			case "DOI":
				DOI = strArray[1];
			break;
			case "organization":
				OriginalPublication = strArray[1];
			break;
			case "reprintEdition":
				ReprintEdition = strArray[1];
			break;
			case "reviewedItem":
				ReviewedItem = strArray[1];
			break;
			case "legalNote":
				LegalNote = strArray[1];
			break;
			case "PMCID":
				PMCID = strArray[1];
			break;
			case "NIHMSID":
				NIHMSID = strArray[1];
			break;
			case "articleNumber":
				ArticleNumber = strArray[1];
			break;
			case "accessionNumber":
				AccessionNumber = strArray[1];
			break;
			case "callNumber":
				CallNumber = strArray[1];
			break;
			case "label":
				Label = strArray[1];
			break;
			case "keywords":
				Keywords = strArray[1];
			break;
			case "Abstract":
				Abstract = strArray[1];
				break;
			case "notes":
				Notes = strArray[1];
				break;
			case "researchNotes":
				ResearchNotes = strArray[1];
				break;
			case "URL":
				URL = strArray[1];
				break;
			case "authorAddress":
				AuthorAddress = strArray[1];
				break;
			case "figure":
				Figure = strArray[1];
				break;
			case "caption":
				Caption = strArray[1];
				break;
			case "accessDate":
				AccessDate = strArray[1];
				break;
			case "translatedAuthor":
				TranslatedAuthor = strArray[1];
				break;
			case "translatedTitle":
				TranslatedTitle = strArray[1];
				break;
			case "nameOfDatabase":
				NameOfDatabase = strArray[1];
				break;
			case "databaseProvider":
				DatabaseProvider = strArray[1];
				break;
			case "language":
				Language = strArray[1];
				break;
			}
			
			index ++;
		}
		
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
		
		return index + 1;
	}

	private int importConference(int index, ArrayList<String> contentFile) {
		index ++;
		
		String Author = "",
		YearOfConference = "", Title = "", Editor = "",
		ConferenceName = "", ConferenceLocation = "",
		Publisher = "", Volume = "", NumberOfVolumes = "", Issue = "",
		Pages = "", SeriesEditor = "", SeriesTitle = "", Edition = "",
		Date = "", Sponsor = "", ISBN = "", DOI = "", Source = "",
		PlacePublished = "", YearPublished = "",
		ProceedingsTitle = "", PackagingMethod = "",
		AccessionNumber = "", CallNumber = "", Label = "",
		Keywords = "", Abstract = "", Notes = "", ResearchNotes = "",
		URL = "", AuthorAddress = "", Figure = "", Caption = "",
		AccessDate = "", TranslatedAuthor = "",
		TranslatedTitle = "", NameOfDatabase = "",
		DatabaseProvider = "", Language = "";
		
		while (!contentFile.get(index).trim().equals("}") && index < contentFile.size()) {
			if (!contentFile.get(index).contains("=")) {
				index ++;
				continue;
			}
			String [] strArray = contentFile.get(index).split("=");
			
			strArray[0] = strArray[0].trim();
			
			strArray[1] = strArray[1].trim();
			if (strArray[1].charAt(strArray[1].length() - 1) == ',') {
				strArray[1] = strArray[1].substring(0, strArray[1].length()-1);
			}
			if (strArray[1].charAt(0) == '{') {
				strArray[1] = strArray[1].substring(1, strArray[1].length()-1);
			}
			
			switch(strArray[0]) {
			case "author":
				Author = strArray[1];
				break;
			case "year":
				YearOfConference = strArray[1];
				break;
			case "title": 
				Title = strArray[1];
				break;
			case "editor":
				Editor = strArray[1];
			break;
			case "conferenceName":
				ConferenceName = strArray[1];
				break;
			case "conferenceLocation":
				ConferenceLocation = strArray[1];
				break;
			case "publisher":
				Publisher = strArray[1];
				break;
			case "volume":
				Volume = strArray[1];
				break;
			case "series":
				NumberOfVolumes = strArray[1];
				break;
			case "issue":
				Issue = strArray[1];
			break;
			case "pages":
				Pages = strArray[1];
				break;
			case "seriesEditor":
				SeriesEditor = strArray[1];
				break;
			case "SeriesTitle":
				SeriesTitle = strArray[1];
				break;
			case "edition":
				Edition = strArray[1];
			break;
			case "date":
				Date = strArray[1];
			break;
			case "sponsor":
				Sponsor = strArray[1];
			break;
			case "ISBN":
				ISBN = strArray[1];
			break;
			case "DOI":
				DOI = strArray[1];
			break;
			case "source":
				Source = strArray[1];
			break;
			case "placePublished":
				PlacePublished = strArray[1];
				break;
			case "yearPublished":
				YearPublished = strArray[1];
			break;
			case "proceedingsTitle":
				ProceedingsTitle = strArray[1];
			break;
			case "packagingMethod":
				PackagingMethod = strArray[1];
			break;
			case "accessionNumber":
				AccessionNumber = strArray[1];
			break;
			case "callNumber":
				CallNumber = strArray[1];
			break;
			case "label":
				Label = strArray[1];
			break;
			case "keywords":
				Keywords = strArray[1];
			break;
			case "Abstract":
				Abstract = strArray[1];
				break;
			case "notes":
				Notes = strArray[1];
				break;
			case "researchNotes":
				ResearchNotes = strArray[1];
				break;
			case "URL":
				URL = strArray[1];
				break;
			case "authorAddress":
				AuthorAddress = strArray[1];
				break;
			case "figure":
				Figure = strArray[1];
				break;
			case "caption":
				Caption = strArray[1];
				break;
			case "accessDate":
				AccessDate = strArray[1];
				break;
			case "translatedAuthor":
				TranslatedAuthor = strArray[1];
				break;
			case "translatedTitle":
				TranslatedTitle = strArray[1];
				break;
			case "nameOfDatabase":
				NameOfDatabase = strArray[1];
				break;
			case "databaseProvider":
				DatabaseProvider = strArray[1];
				break;
			case "language":
				Language = strArray[1];
				break;
			}
			
			index ++;
		}
		
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
		
		return index + 1;
	}

	private int importThesis(int index, ArrayList<String> contentFile) {
		index ++;
		
		String Author = "", Year = "", Title = "", SecondaryAuthor = "",
		AcademicDepartment = "", PlacePublished = "", University = "",
		Degree = "", NumberOfVolumes = "", DocumentNumber = "",
		NumberOfPages = "", Advisor = "", Date = "", ThesisType = "",
		ShortTitle = "", ISBN = "", DOI = "", AccessionNumber = "", CallNumber = "",
		Label = "", Keywords = "", Abstract = "", Notes = "", ResearchNotes = "",
		URL = "", AuthorAddress = "", Figure = "", Caption = "", AccessDate = "",
		TranslatedAuthor = "", TranslatedTitle = "", NameOfDatabase = "",
		DatabaseProvider = "", Language = "";
		
		while (!contentFile.get(index).trim().equals("}") && index < contentFile.size()) {
			if (!contentFile.get(index).contains("=")) {
				index ++;
				continue;
			}
			String [] strArray = contentFile.get(index).split("=");
			
			strArray[0] = strArray[0].trim();
			
			strArray[1] = strArray[1].trim();
			if (strArray[1].charAt(strArray[1].length() - 1) == ',') {
				strArray[1] = strArray[1].substring(0, strArray[1].length()-1);
			}
			if (strArray[1].charAt(0) == '{') {
				strArray[1] = strArray[1].substring(1, strArray[1].length()-1);
			}
			
			switch(strArray[0]) {
			case "author":
				Author = strArray[1];
				break;
			case "year":
				Year = strArray[1];
				break;
			case "title": 
				Title = strArray[1];
				break;
			case "secondaryAuthor":
				SecondaryAuthor = strArray[1];
				break;
			case "academicDepartment":
				AcademicDepartment = strArray[1];
				break;
			case "placePublished":
				PlacePublished = strArray[1];
				break;
			case "university":
				University = strArray[1];
				break;
			case "degree":
				Degree = strArray[1];
				break;
			case "series":
				NumberOfVolumes = strArray[1];
				break;
			case "documentNumber":
				DocumentNumber = strArray[1];
				break;
			case "numberOfPages":
				NumberOfPages = strArray[1];
				break;
			case "advisor":
				Advisor = strArray[1];
				break;
			case "date":
				Date = strArray[1];
			break;
			case "type":
				ThesisType = strArray[1];
			break;
			case "shortTitle":
				ShortTitle = strArray[1];
			break;
			case "ISBN":
				ISBN = strArray[1];
			break;
			case "DOI":
				DOI = strArray[1];
			break;
			case "accessionNumber":
				AccessionNumber = strArray[1];
			break;
			case "callNumber":
				CallNumber = strArray[1];
			break;
			case "label":
				Label = strArray[1];
			break;
			case "keywords":
				Keywords = strArray[1];
			break;
			case "Abstract":
				Abstract = strArray[1];
				break;
			case "notes":
				Notes = strArray[1];
				break;
			case "researchNotes":
				ResearchNotes = strArray[1];
				break;
			case "URL":
				URL = strArray[1];
				break;
			case "authorAddress":
				AuthorAddress = strArray[1];
				break;
			case "figure":
				Figure = strArray[1];
				break;
			case "caption":
				Caption = strArray[1];
				break;
			case "accessDate":
				AccessDate = strArray[1];
				break;
			case "translatedAuthor":
				TranslatedAuthor = strArray[1];
				break;
			case "translatedTitle":
				TranslatedTitle = strArray[1];
				break;
			case "nameOfDatabase":
				NameOfDatabase = strArray[1];
				break;
			case "databaseProvider":
				DatabaseProvider = strArray[1];
				break;
			case "language":
				Language = strArray[1];
				break;
			}
			
			index ++;
		}
		
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
		
		return index + 1;
	}
}

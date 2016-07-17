package services;

public class QueryModel {

	public QueryModel() {

	}
	
	public String getQueryAllReference() {
		return "SELECT Reference.ReferenceID, Author, Year, Title, TypeName, PathAttach,"
				+ " Pages, ShortTitle, DOI, AccessionNumber, CallNumber, Keywords, AuthorAddress"
				+ " FROM Reference, Types WHERE Reference.TypeID = Types.TypeID"
				+ " AND Trash = 0";
	}
	
	public String getQueryUnfiled() {
		return "SELECT Reference.ReferenceID, Author, Year, Title, TypeName, PathAttach,"
				+ " Pages, ShortTitle, DOI, AccessionNumber, CallNumber, Keywords, AuthorAddress"
				+ " FROM Reference, Types WHERE Reference.TypeID = Types.TypeID"
				+ " AND Reference.ReferenceID NOT IN (SELECT ReferenceID FROM Label)"
				+ " AND Trash = 0";
	}
	
	public String getQueryTrash() {
		return "SELECT Reference.ReferenceID, Author, Year, Title, TypeName, PathAttach,"
				+ " Pages, ShortTitle, DOI, AccessionNumber, CallNumber, Keywords, AuthorAddress"
				+ " FROM Reference, Types WHERE Reference.TypeID = Types.TypeID"
				+ " AND Trash = 1";
	}

	public String getQueryGroupSetName() {
		return "SELECT GroupSetName FROM GroupSet";
	}

	public String getQueryGroupName(String groupSetName) {
		return "SELECT GroupName FROM Groups, GroupSet"
				+ " WHERE Groups.GroupSetID = GroupSet.GroupSetID"
				+ " AND GroupSetName = N'" + groupSetName + "'";
	}

	public String getQueryDataFromGroupSet(String groupSetName) {
		return "SELECT DISTINCT Reference.ReferenceID, Author, Year, Title, TypeName, PathAttach,"
				+ " Pages, ShortTitle, DOI, AccessionNumber, CallNumber, Keywords, AuthorAddress"
				+ " FROM GroupSet, Groups, Types, Reference, Label"
				+ " WHERE GroupSet.GroupSetID = Groups.GroupSetID"
				+ " AND Types.TypeID = Reference.TypeID"
				+ " AND Label.GroupID = Groups.GroupID"
				+ " AND Label.ReferenceID = Reference.ReferenceID"
				+ " AND GroupSetName = N'" + groupSetName + "'";
	}

	public String getQueryDataFromGroup(String groupName, String groupSetName) {
		return "SELECT Reference.ReferenceID, Author, Year, Title, TypeName, PathAttach"
				+ " Pages, ShortTitle, DOI, AccessionNumber, CallNumber, Keywords, AuthorAddress"
				+ " FROM GroupSet, Groups, Types, Reference, Label"
				+ " WHERE GroupSet.GroupSetID = Groups.GroupSetID"
				+ " AND Types.TypeID = Reference.TypeID"
				+ " AND Label.GroupID = Groups.GroupID"
				+ " AND Label.ReferenceID = Reference.ReferenceID"
				+ " AND GroupName = N'" + groupName + "' "
				+ " AND GroupSetName = N'" + groupSetName + "'";
	}

	public String getQueryTypeName() {
		return "SELECT TypeName FROM Types";
	}

	public String getQueryTypeOfReference(String ReferenceID) {
		return "SELECT TypeName FROM Types, Reference"
				+ " WHERE Types.TypeID = Reference.TypeID"
				+ " AND ReferenceID = " + ReferenceID;
	}
	
	public String getQueryPathOfReference(String ReferenceID) {
		return "SELECT PathAttach FROM Reference WHERE ReferenceID = " + ReferenceID;
	}

	public String getQueryInfoReference(String ReferenceID) {
		return "SELECT * FROM Reference WHERE ReferenceID = " + ReferenceID;
	}
	
	public String getQueryCreateGroupSet(String groupSetName) {
		return "INSERT INTO GroupSet (GroupSetName) VALUES (N'" + groupSetName + "')";
	}
	
	public String getQueryRenameGroupSet(String oldName, String newName) {
		return "UPDATE GroupSet SET GroupSetName = N'" + newName + "'"
				+ " WHERE GroupSetName = N'" + oldName + "'";
	}
	
	public String getQueryDeleteGroupSet(String groupSetName) {
		return "DELETE FROM Label WHERE GroupID IN"
				+ " (SELECT Label.GroupID FROM Label, Groups, GroupSet"
				+ " WHERE Label.GroupID = Groups.GroupID"
				+ " AND Groups.GroupSetID = GroupSet.GroupSetID"
				+ " AND GroupSetName = N'" + groupSetName + "');"
				+ " DELETE FROM Groups WHERE GroupSetID IN"
				+ " (SELECT GroupSetID FROM GroupSet"
				+ " WHERE GroupSetName = N'" + groupSetName +"');"
				+ " DELETE FROM GroupSet WHERE GroupSetName = N'"
				+ groupSetName + "'";
	}
	
	public String getQueryGroupSetID(String groupSetName) {
		return "SELECT GroupSetID FROM GroupSet WHERE GroupSetName = N'" + groupSetName + "'";
	}
	
	public String getQueryGroupID(String groupName, String groupSetName) {
		return "SELECT GroupID FROM Groups, GroupSet"
				+ " WHERE Groups.GroupSetID = GroupSet.GroupSetID"
				+ " AND GroupSetName = N'" + groupSetName + "'"
				+ " AND GroupName = N'" + groupName + "'";
	}
	
	public String getQueryGroupID(String groupSetName) {
		return "SELECT GroupID FROM Groups, GroupSet"
				+ " WHERE Groups.GroupSetID = GroupSet.GroupSetID"
				+ " AND GroupSetName = N'" + groupSetName + "'";
	}
	
	public String getQueryCreateGroup(String groupName, String groupSetID) {
		return "INSERT INTO Groups (GroupName, GroupSetID) VALUES (N'"
				+ groupName + "', " + groupSetID + ")";
	}
	
	public String getQueryRenameGroup(String groupSetName, String oldName, String newName) {
		return "UPDATE Groups SET GroupName = N'" + newName + "'"
				+ " WHERE GroupName IN (SELECT GroupName FROM Groups, GroupSet"
				+ " WHERE Groups.GroupSetID = GroupSet.GroupSetID"
				+ " AND GroupSetName = N'" + groupSetName + "'"
				+ " AND GroupName = N'" + oldName + "')";
	}
	
	public String getQueryDeleteGroup(String groupSetName, String groupName) {
		return "DELETE FROM Label WHERE GroupID IN"
				+ " (SELECT Label.GroupID FROM Label, Groups, GroupSet"
				+ " WHERE Label.GroupID = Groups.GroupID"
				+ " AND Groups.GroupSetID = GroupSet.GroupSetID"
				+ " AND GroupSetName = N'" + groupSetName + "'"
				+ " AND GroupName = N'" + groupName + "');"
				+ " DELETE FROM Groups WHERE GroupSetID IN"
				+ " (SELECT GroupSetID FROM GroupSet"
				+ " WHERE GroupSetName = N'" + groupSetName +"'"
				+ " AND GroupName = N'" + groupName + "')";
	}
	
	public String getQueryEmptyTrash() {
		return "DELETE FROM Reference WHERE Trash = 1";
	}
	
	public String getQueryAllReferenceCount() {
		return "SELECT COUNT(*) FROM Reference WHERE Trash = 0";
	}
	
	public String getQueryUnfiledCount() {
		return "SELECT COUNT(*) FROM Reference"
				+ " WHERE ReferenceID NOT IN (SELECT ReferenceID FROM Label) AND Trash = 0";
	}
	
	public String getQueryTrashCount() {
		return "SELECT COUNT(*)  FROM Reference WHERE Trash = 1";
	}
	
	public String getQueryDataCountFromGroupSet(String groupSetName) {
		return "SELECT COUNT(DISTINCT Reference.ReferenceID)"
				+ " FROM GroupSet, Groups, Reference, Label"
				+ " WHERE GroupSet.GroupSetID = Groups.GroupSetID"
				+ " AND Label.GroupID = Groups.GroupID"
				+ " AND Label.ReferenceID = Reference.ReferenceID"
				+ " AND GroupSetName = N'" + groupSetName + "'";
	}

	public String getQueryDataCountFromGroup(String groupName, String groupSetName) {
		return "SELECT COUNT(DISTINCT Reference.ReferenceID)"
				+ " FROM GroupSet, Groups, Reference, Label"
				+ " WHERE GroupSet.GroupSetID = Groups.GroupSetID"
				+ " AND Label.GroupID = Groups.GroupID"
				+ " AND Label.ReferenceID = Reference.ReferenceID"
				+ " AND GroupName = N'" + groupName + "' "
				+ " AND GroupSetName = N'" + groupSetName + "'";
	}
	
	public String getQueryInsertToLabel(String groupID, String referenceID) {
		return "IF NOT EXISTS (SELECT * FROM Label"
				+ " WHERE GroupID = " + groupID
				+ " AND ReferenceID = " + referenceID + ")"
				+ " INSERT INTO Label (GroupID, ReferenceID)"
				+ " VALUES (" + groupID + ", " + referenceID +")";
	}
	
	public String getQueryRemoveReferenceFromGroup (String referenceID, String groupName, String groupSetName) {
		return "DELETE FROM Label WHERE GroupID IN"
				+ " (SELECT Label.GroupID FROM Label, Groups, GroupSet"
				+ " WHERE Label.GroupID = Groups.GroupID"
				+ " AND Groups.GroupSetID = GroupSet.GroupSetID"
				+ " AND GroupSetName = N'" + groupSetName + "'"
				+ " AND GroupName = N'" + groupName + "')"
				+ " AND ReferenceID = " + referenceID;
	}
	
	public String getQueryRemoveReferenceFromGroupSet (String referenceID, String groupSetName) {
		return "DELETE FROM Label WHERE GroupID IN"
				+ " (SELECT Label.GroupID FROM Label, Groups, GroupSet"
				+ " WHERE Label.GroupID = Groups.GroupID"
				+ " AND Groups.GroupSetID = GroupSet.GroupSetID"
				+ " AND GroupSetName = N'" + groupSetName + "')"
				+ " AND ReferenceID = " + referenceID;
	}
	
	public String getQueryMoveReferencesToTrash(String referenceID) {
		return "DELETE FROM Label WHERE referenceID = " + referenceID + ";"
				+ " UPDATE Reference SET Trash = 1 WHERE referenceID = " + referenceID;
	}
	
	public String getQueryRestoreToLibrary(String referenceID) {
		return "UPDATE Reference SET Trash = 0 WHERE referenceID = " + referenceID;
	}
	
	public String getQueryDeleteTrashReferences(String referenceID) {
		return "DELETE FROM Reference WHERE referenceID = " + referenceID;
	}
	
	public String getQueryNewBook(String Author, String Year, String Title, String SeriesEditor,
			String SeriesTitle, String PlacePublished, String Publisher, String Volume,
			String NumberOfVolumes, String SeriesVolume, String NumberOfPages, String Pages,
			String Editor, String Edition, String Date, String TypeOfWork, String Translator,
			String ShortTitle, String Abbreviation, String ISBN, String DOI, String OriginalPublication,
			String ReprintEdition, String TitlePrefix, String Reviewer, String AccessionNumber,
			String CallNumber, String Label, String Keywords, String Abstract, String Notes,
			String ResearchNotes, String URL, String AuthorAddress, String Figure, String Caption,
			String AccessDate, String TranslatedAuthor, String TranslatedTitle, String NameOfDatabase, String DatabaseProvider,
			String Language) {
		return "INSERT INTO Reference (Trash, TypeID, Author, Year, Title, "
				+ "SeriesEditor, SeriesTitle, PlacePublished, Publisher, Volume, "
				+ "NumberOfVolumes, SeriesVolume, NumberOfPages, Pages, Editor, "
				+ "Edition, Date, TypeOfWork, Translator, ShortTitle, Abbreviation, "
				+ "ISBN, DOI, OriginalPublication, ReprintEdition, TitlePrefix, "
				+ "Reviewer, AccessionNumber, CallNumber, Label, Keywords, Abstract, "
				+ "Notes, ResearchNotes, URL, AuthorAddress, Figure, Caption, "
				+ "AccessDate, TranslatedAuthor, TranslatedTitle, NameOfDatabase, "
				+ "DatabaseProvider, Language)"
				+ "VALUES (0, 1, N'" + Author + "', N'" + Year + "', N'" + Title + "', N'" + SeriesEditor
				+ "', N'" + SeriesTitle + "', N'" + PlacePublished + "', N'" + Publisher + "', N'" + Volume
				+ "', N'" + NumberOfVolumes + "', N'" + SeriesVolume + "', N'" + NumberOfPages + "', N'" + Pages
				+ "', N'" + Editor + "', N'" + Edition + "', N'" + Date + "', N'" + TypeOfWork + "', N'" + Translator
				+ "', N'" + ShortTitle + "', N'" + Abbreviation + "', N'" + ISBN + "', N'" + DOI + "', N'" + OriginalPublication
				+ "', N'" + ReprintEdition + "', N'" + TitlePrefix + "', N'" + Reviewer + "', N'" + AccessionNumber
				+ "', N'" + CallNumber + "', N'" + Label + "', N'" + Keywords + "', N'" + Abstract + "', N'" + Notes
				+ "', N'" + ResearchNotes + "', N'" + URL + "', N'" + AuthorAddress + "', N'" + Figure + "', N'" + Caption
				+ "', N'" + AccessDate + "', N'" + TranslatedAuthor + "', N'" + TranslatedTitle + "', N'" + NameOfDatabase
				+ "', N'" + DatabaseProvider + "', N'" + Language + "')";
	}
	
	public String getQueryNewReport(String Author, String Year, String Title, String SeriesEditor,
			String SeriesTitle, String PlacePublished, String Institution, String Volume,
			String NumberOfVolumes, String SeriesVolume, String DocumentNumber, String Pages,
			String Publisher, String Edition, String Date, String Type, String Department,
			String ShortTitle, String AlternateTitle, String ReportNumber, String DOI, String Contents,
			String Issue, String AccessionNumber, String CallNumber, String Label, String Keywords,
			String Abstract, String Notes, String ResearchNotes, String URL, String AuthorAddress,
			String Figure, String Caption, String AccessDate, String TranslatedAuthor,
			String TranslatedTitle, String NameOfDatabase, String DatabaseProvider, String Language) {
		return "INSERT INTO Reference (Trash, TypeID, Author, Year, Title, "
				+ "SeriesEditor, SeriesTitle, PlacePublished, Institution, Volume, "
				+ "NumberOfVolumes, SeriesVolume, DocumentNumber, Pages, Publisher, "
				+ "Edition, Date, Type, Department, ShortTitle, AlternateTitle, "
				+ "ReportNumber, DOI, Contents, Issue, AccessionNumber, "
				+ "CallNumber, Label, Keywords, Abstract, Notes, ResearchNotes, "
				+ "URL, AuthorAddress, Figure, Caption, AccessDate, TranslatedAuthor, "
				+ "TranslatedTitle, NameOfDatabase, DatabaseProvider, Language)"
				+ "VALUES (0, 2, N'" + Author + "', N'" + Year + "', N'" + Title + "', N'" + SeriesEditor
				+ "', N'" + SeriesTitle + "', N'" + PlacePublished + "', N'" + Institution + "', N'" + Volume
				+ "', N'" + NumberOfVolumes + "', N'" + SeriesVolume + "', N'" + DocumentNumber + "', N'" + Pages
				+ "', N'" + Publisher + "', N'" + Edition + "', N'" + Date + "', N'" + Type + "', N'" + Department
				+ "', N'" + ShortTitle + "', N'" + AlternateTitle + "', N'" + ReportNumber + "', N'" + DOI + "', N'" + Contents
				+ "', N'" + Issue + "', N'" + AccessionNumber + "', N'" + CallNumber + "', N'" + Label + "', N'" + Keywords
				+ "', N'" + Abstract + "', N'" + Notes + "', N'" + ResearchNotes + "', N'" + URL + "', N'" + AuthorAddress
				+ "', N'" + Figure + "', N'" + Caption + "', N'" + AccessDate + "', N'" + TranslatedAuthor
				+ "', N'" + TranslatedTitle + "', N'" + NameOfDatabase + "', N'" + DatabaseProvider + "', N'" + Language + "')";
	}
	
	public String getQueryNewJournalArticle(
			String Author, String Year, String Title, String SecondaryAuthor,
			String Journal, String PlacePublished, String Publisher, String Volume,
			String NumberOfVolumes, String Issue, String Pages, String StartPage,
			String EpubDate, String Date, String TypeOfArticle, String ShortTitle,
			String AlternateJournal, String ISBN, String DOI, String OriginalPublication,
			String ReprintEdition, String ReviewedItem, String LegalNote, String PMCID,
			String NIHMSID, String ArticleNumber, String AccessionNumber, String CallNumber,
			String Label, String Keywords, String Abstract, String Notes, String ResearchNotes,
			String URL, String AuthorAddress, String Figure, String Caption, String AccessDate,
			String TranslatedAuthor, String TranslatedTitle, String NameOfDatabase,
			String DatabaseProvider, String Language) {
		return "INSERT INTO Reference (Trash, TypeID, Author, Year, Title, "
				+ "SecondaryAuthor, Journal, PlacePublished, Publisher, Volume, "
				+ "NumberOfVolumes, Issue, Pages, StartPage, "
				+ "EpubDate, Date, TypeOfArticle, ShortTitle, "
				+ "AlternateJournal, ISBN, DOI, OriginalPublication, "
				+ "ReprintEdition, ReviewedItem, LegalNote, PMCID, "
				+ "NIHMSID, ArticleNumber, AccessionNumber, CallNumber, "
				+ "Label, Keywords, Abstract, Notes, ResearchNotes, "
				+ "URL, AuthorAddress, Figure, Caption, AccessDate, "
				+ "TranslatedAuthor, TranslatedTitle, NameOfDatabase, "
				+ "DatabaseProvider, Language)"
				+ "VALUES (0, 3, N'" + Author + "', N'" + Year + "', N'" + Title + "', N'" + SecondaryAuthor
				+ "', N'" + Journal + "', N'" + PlacePublished + "', N'" + Publisher + "', N'" + Volume
				+ "', N'" + NumberOfVolumes + "', N'" + Issue + "', N'" + Pages + "', N'" + StartPage
				+ "', N'" + EpubDate + "', N'" + Date + "', N'" + TypeOfArticle + "', N'" + ShortTitle
				+ "', N'" + AlternateJournal + "', N'" + ISBN + "', N'" + DOI + "', N'" + OriginalPublication
				+ "', N'" + ReprintEdition + "', N'" + ReviewedItem + "', N'" + LegalNote + "', N'" + PMCID
				+ "', N'" + NIHMSID + "', N'" + ArticleNumber + "', N'" + AccessionNumber + "', N'" + CallNumber
				+ "', N'" + Label + "', N'" + Keywords + "', N'" + Abstract + "', N'" + Notes + "', N'" + ResearchNotes
				+ "', N'" + URL + "', N'" + AuthorAddress + "', N'" + Figure + "', N'" + Caption + "', N'" + AccessDate
				+ "', N'" + TranslatedAuthor + "', N'" + TranslatedTitle + "', N'" + NameOfDatabase
				+ "', N'" + DatabaseProvider + "', N'" + Language + "')";
	}
	
	public String getQueryNewConferenceProceedings(
			String Author, String YearOfConference, String Title, String Editor, String ConferenceName,
			String ConferenceLocation, String Publisher, String Volume, String NumberOfVolumes,
			String Issue, String Pages, String SeriesEditor,String SeriesTitle, String Edition,
			String Date, String Sponsor, String ISBN, String DOI, String Source, String PlacePublished,
			String YearPublished, String ProceedingsTitle, String PackagingMethod, String AccessionNumber,
			String CallNumber, String Label, String Keywords, String Abstract, String Notes,
			String ResearchNotes, String URL, String AuthorAddress, String Figure, String Caption,
			String AccessDate, String TranslatedAuthor, String TranslatedTitle, String NameOfDatabase,
			String DatabaseProvider, String Language) {
		return "INSERT INTO Reference (Trash, TypeID, Author, Year, Title, "
				+ "Editor, ConferenceName, ConferenceLocation, Publisher, Volume, "
				+ "NumberOfVolumes, Issue, Pages, SeriesEditor, SeriesTitle, Edition, "
				+ "Date, Sponsor, ISBN, DOI, Source, PlacePublished, YearPublished, "
				+ "ProceedingsTitle, PackagingMethod, AccessionNumber, CallNumber, "
				+ "Label, Keywords, Abstract, Notes, ResearchNotes, URL, AuthorAddress, "
				+ "Figure, Caption, AccessDate, TranslatedAuthor, TranslatedTitle, "
				+ "NameOfDatabase, DatabaseProvider, Language)"
				+ "VALUES (0, 4, N'" + Author + "', N'" + YearOfConference + "', N'" + Title + "', N'" + Editor + "', N'" + ConferenceName
				+ "', N'" + ConferenceLocation + "', N'" + Publisher + "', N'" + Volume + "', N'" + NumberOfVolumes
				+ "', N'" + Issue + "', N'" + Pages + "', N'" + SeriesEditor + "', N'" + SeriesTitle + "', N'" + Edition
				+ "', N'" + Date + "', N'" + Sponsor + "', N'" + ISBN + "', N'" + DOI + "', N'" + Source + "', N'" + PlacePublished
				+ "', N'" + YearPublished + "', N'" + ProceedingsTitle + "', N'" + PackagingMethod + "', N'" + AccessionNumber
				+ "', N'" + CallNumber + "', N'" + Label + "', N'" + Keywords + "', N'" + Abstract + "', N'" + Notes
				+ "', N'" + ResearchNotes + "', N'" + URL + "', N'" + AuthorAddress + "', N'" + Figure + "', N'" + Caption
				+ "', N'" + AccessDate + "', N'" + TranslatedAuthor + "', N'" + TranslatedTitle + "', N'" + NameOfDatabase
				+ "', N'" + DatabaseProvider + "', N'" + Language + "')";
	}
	
	public String getQueryNewThesis(
			String Author, String Year, String Title, String SecondaryAuthor, String AcademicDepartment,
			String PlacePublished, String University, String Degree, String NumberOfVolumes,
			String DocumentNumber, String NumberOfPages, String Advisor, String Date, String ThesisType,
			String ShortTitle, String ISBN, String DOI, String AccessionNumber, String CallNumber,
			String Label, String Keywords, String Abstract, String Notes,
			String ResearchNotes, String URL, String AuthorAddress, String Figure, String Caption,
			String AccessDate, String TranslatedAuthor, String TranslatedTitle, String NameOfDatabase,
			String DatabaseProvider, String Language) {
		return "INSERT INTO Reference (Trash, TypeID, Author, Year, Title, "
				+ "SecondaryAuthor, AcademicDepartment, "
				+ "PlacePublished, University, Degree, NumberOfVolumes, "
				+ "DocumentNumber, NumberOfPages, Advisor, Date, ThesisType, "
				+ "ShortTitle, ISBN, DOI, AccessionNumber, CallNumber, "
				+ "Label, Keywords, Abstract, Notes, "
				+ "ResearchNotes, URL, AuthorAddress, Figure, Caption, "
				+ "AccessDate, TranslatedAuthor, TranslatedTitle, NameOfDatabase, "
				+ "DatabaseProvider, Language)"
				+ "VALUES (0, 5, N'" + Author+ "', N'" + Year+ "', N'" + Title+ "', N'" + SecondaryAuthor+ "', N'" + AcademicDepartment
				+ "', N'" + PlacePublished + "', N'" + University + "', N'" + Degree + "', N'" + NumberOfVolumes
				+ "', N'" + DocumentNumber + "', N'" +  NumberOfPages + "', N'" + Advisor + "', N'" + Date + "', N'" + ThesisType
				+ "', N'" + ShortTitle + "', N'" + ISBN + "', N'" + DOI + "', N'" + AccessionNumber + "', N'" + CallNumber
				+ "', N'" + Label + "', N'" + Keywords + "', N'" + Abstract + "', N'" + Notes
				+ "', N'" + ResearchNotes + "', N'" + URL + "', N'" + AuthorAddress + "', N'" + Figure + "', N'" + Caption
				+ "', N'" + AccessDate + "', N'" + TranslatedAuthor + "', N'" + TranslatedTitle + "', N'" + NameOfDatabase
				+ "', N'" + DatabaseProvider + "', N'" + Language + "')";
	}
	
	public String getQuerySaveBook(String ReferenceID,
			String Author, String Year, String Title, String SeriesEditor,
			String SeriesTitle, String PlacePublished, String Publisher, String Volume,
			String NumberOfVolumes, String SeriesVolume, String NumberOfPages, String Pages,
			String Editor, String Edition, String Date, String TypeOfWork, String Translator,
			String ShortTitle, String Abbreviation, String ISBN, String DOI, String OriginalPublication,
			String ReprintEdition, String TitlePrefix, String Reviewer, String AccessionNumber,
			String CallNumber, String Label, String Keywords, String Abstract, String Notes,
			String ResearchNotes, String URL, String AuthorAddress, String Figure, String Caption,
			String AccessDate, String TranslatedAuthor, String TranslatedTitle, String NameOfDatabase, String DatabaseProvider,
			String Language) {
		return "UPDATE Reference SET "
				+ "TypeID = 1, Author = N'" + Author + "', Year = N'" + Year + "', Title = N'" + Title
				+ "', SeriesEditor = N'" + SeriesEditor + "', SeriesTitle = N'" + SeriesTitle
				+ "', PlacePublished = N'" + PlacePublished + "', Publisher = N'" + Publisher
				+ "', Volume = N'" + Volume + "', NumberOfVolumes = N'" + NumberOfVolumes
				+ "', SeriesVolume = N'" + SeriesVolume + "', NumberOfPages = N'" + NumberOfPages
				+ "', Pages = N'" + Pages + "', Editor = N'" + Editor + "', Edition = N'" + Edition
				+ "', Date = N'" + Date + "', TypeOfWork = N'" + TypeOfWork + "', Translator = N'" + Translator
				+ "', ShortTitle = N'" + ShortTitle + "', Abbreviation = N'" + Abbreviation
				+ "', ISBN = N'" + ISBN + "', DOI = N'" + DOI + "', OriginalPublication = N'" + OriginalPublication
				+ "', ReprintEdition = N'" + ReprintEdition + "', TitlePrefix = N'" + TitlePrefix
				+ "', Reviewer = N'" + Reviewer + "', AccessionNumber = N'" + AccessionNumber
				+ "', CallNumber = N'" + CallNumber + "', Label = N'" + Label + "', Keywords = N'" + Keywords
				+ "', Abstract = N'" + Abstract + "', Notes = N'" + Notes + "', ResearchNotes = N'" + ResearchNotes
				+ "', URL = N'" + URL + "', AuthorAddress = N'" + AuthorAddress + "', Figure = N'" + Figure
				+ "', Caption = N'" + Caption + "', AccessDate = N'" + AccessDate
				+ "', TranslatedAuthor = N'" + TranslatedAuthor + "', TranslatedTitle = N'" + TranslatedTitle
				+ "', NameOfDatabase = N'" + NameOfDatabase + "', DatabaseProvider = N'" + DatabaseProvider
				+ "', Language = N'" + Language
				+ "' WHERE ReferenceID = " + ReferenceID;
	}
	
	public String getQuerySaveReport(String ReferenceID,
			String Author, String Year, String Title, String SeriesEditor,
			String SeriesTitle, String PlacePublished, String Institution, String Volume,
			String NumberOfVolumes, String SeriesVolume, String DocumentNumber, String Pages,
			String Publisher, String Edition, String Date, String Type, String Department,
			String ShortTitle, String AlternateTitle, String ReportNumber, String DOI, String Contents,
			String Issue, String AccessionNumber, String CallNumber, String Label, String Keywords,
			String Abstract, String Notes, String ResearchNotes, String URL, String AuthorAddress,
			String Figure, String Caption, String AccessDate, String TranslatedAuthor,
			String TranslatedTitle, String NameOfDatabase, String DatabaseProvider, String Language) {
		return "UPDATE Reference SET "
				+ "TypeID = 2, Author = N'" + Author + "', Year = N'" + Year + "', Title = N'" + Title
				+ "', SeriesEditor = N'" + SeriesEditor + "', SeriesTitle = N'" + SeriesTitle
				+ "', PlacePublished = N'" + PlacePublished + "', Institution = N'" + Institution
				+ "', Volume = N'" + Volume + "', NumberOfVolumes = N'" + NumberOfVolumes
				+ "', SeriesVolume = N'" + SeriesVolume + "', DocumentNumber = N'" + DocumentNumber
				+ "', Pages = N'" + Pages + "', Publisher = N'" + Publisher + "', Edition = N'" + Edition
				+ "', Date = N'" + Date + "', Type = N'" + Type + "', Department = N'" + Department
				+ "', ShortTitle = N'" + ShortTitle + "', AlternateTitle = N'" + AlternateTitle
				+ "', ReportNumber = N'" + ReportNumber + "', DOI = N'" + DOI + "', Contents = N'" + Contents
				+ "', Issue = N'" + Issue + "', AccessionNumber = N'" + AccessionNumber
				+ "', CallNumber = N'" + CallNumber + "', Label = N'" + Label + "', Keywords = N'" + Keywords
				+ "', Abstract = N'" + Abstract + "', Notes = N'" + Notes + "', ResearchNotes = N'" + ResearchNotes
				+ "', URL = N'" + URL + "', AuthorAddress = N'" + AuthorAddress + "', Figure = N'" + Figure
				+ "', Caption = N'" + Caption + "', AccessDate = N'" + AccessDate + "', TranslatedAuthor = N'" + TranslatedAuthor
				+ "', TranslatedTitle = N'" + TranslatedTitle + "', NameOfDatabase = N'" + NameOfDatabase
				+ "', DatabaseProvider = N'" + DatabaseProvider + "', Language = N'" + Language
				+ "' WHERE ReferenceID = " + ReferenceID;
	}
	
	public String getQuerySaveJournalArticle(String ReferenceID,
			String Author, String Year, String Title, String SecondaryAuthor,
			String Journal, String PlacePublished, String Publisher, String Volume,
			String NumberOfVolumes, String Issue, String Pages, String StartPage,
			String EpubDate, String Date, String TypeOfArticle, String ShortTitle,
			String AlternateJournal, String ISBN, String DOI, String OriginalPublication,
			String ReprintEdition, String ReviewedItem, String LegalNote, String PMCID,
			String NIHMSID, String ArticleNumber, String AccessionNumber, String CallNumber,
			String Label, String Keywords, String Abstract, String Notes, String ResearchNotes,
			String URL, String AuthorAddress, String Figure, String Caption, String AccessDate,
			String TranslatedAuthor, String TranslatedTitle, String NameOfDatabase,
			String DatabaseProvider, String Language) {
		return "UPDATE Reference SET "
				+ "TypeID = 3, Author = N'" + Author + "', Year = N'" + Year + "', Title = N'" + Title
				+ "', SecondaryAuthor = N'" + SecondaryAuthor + "', Journal = N'" + Journal
				+ "', PlacePublished = N'" + PlacePublished + "', Publisher = N'" + Publisher
				+ "', Volume = N'" + Volume + "', NumberOfVolumes = N'" + NumberOfVolumes
				+ "', Issue = N'" + Issue + "', Pages = N'" + Pages + "', StartPage = N'" + StartPage
				+ "', EpubDate = N'" + EpubDate + "', Date = N'" + Date
				+ "', TypeOfArticle = N'" + TypeOfArticle + "', ShortTitle = N'" + ShortTitle
				+ "', AlternateJournal = N'" + AlternateJournal + "', ISBN = N'" + ISBN
				+ "', DOI = N'" + DOI + "', OriginalPublication = N'" + OriginalPublication
				+ "', ReprintEdition = N'" + ReprintEdition + "', ReviewedItem = N'" + ReviewedItem
				+ "', LegalNote = N'" + LegalNote + "', PMCID = N'" + PMCID + "', NIHMSID = N'" + NIHMSID
				+ "', ArticleNumber = N'" + ArticleNumber + "', AccessionNumber = N'" + AccessionNumber
				+ "', CallNumber = N'" + CallNumber + "', Label = N'" + Label + "', Keywords = N'" + Keywords
				+ "', Abstract = N'" + Abstract + "', Notes = N'" + Notes + "', ResearchNotes = N'" + ResearchNotes
				+ "', URL = N'" + URL + "', AuthorAddress = N'" + AuthorAddress + "', Figure = N'" + Figure
				+ "', Caption = N'" + Caption + "', AccessDate = N'" + AccessDate
				+ "', TranslatedAuthor = N'" + TranslatedAuthor + "', TranslatedTitle = N'" + TranslatedTitle
				+ "', NameOfDatabase = N'" + NameOfDatabase + "', DatabaseProvider = N'" + DatabaseProvider
				+ "', Language = N'" + Language
				+ "' WHERE ReferenceID = " + ReferenceID;
	}
	
	public String getQuerySaveConferenceProceedings(String ReferenceID,
			String Author, String YearOfConference, String Title, String Editor, String ConferenceName,
			String ConferenceLocation, String Publisher, String Volume, String NumberOfVolumes,
			String Issue, String Pages, String SeriesEditor,String SeriesTitle, String Edition,
			String Date, String Sponsor, String ISBN, String DOI, String Source, String PlacePublished,
			String YearPublished, String ProceedingsTitle, String PackagingMethod, String AccessionNumber,
			String CallNumber, String Label, String Keywords, String Abstract, String Notes,
			String ResearchNotes, String URL, String AuthorAddress, String Figure, String Caption,
			String AccessDate, String TranslatedAuthor, String TranslatedTitle, String NameOfDatabase,
			String DatabaseProvider, String Language) {
		return "UPDATE Reference SET "
				+ "TypeID = 4, Author = N'" + Author + "', Year = N'" + YearOfConference + "', Title = N'" + Title
				+ "', Editor = N'" + Editor + "', ConferenceName = N'" + ConferenceName
				+ "', ConferenceLocation = N'" + ConferenceLocation + "', Publisher = N'" + Publisher
				+ "', Volume = N'" + Volume + "', NumberOfVolumes = N'" + NumberOfVolumes
				+ "', Issue = N'" + Issue + "', Pages = N'" + Pages + "', SeriesEditor = N'" + SeriesEditor
				+ "', SeriesTitle = N'" + SeriesTitle + "', Edition = N'" + Edition + "', Date = N'" + Date
				+ "', Sponsor = N'" + Sponsor + "', ISBN = N'" + ISBN + "', DOI = N'" + DOI
				+ "', Source = N'" + Source + "', PlacePublished = N'" + PlacePublished
				+ "', YearPublished = N'" + YearPublished + "', ProceedingsTitle = N'" + ProceedingsTitle
				+ "', PackagingMethod = N'" + PackagingMethod + "', AccessionNumber = N'" + AccessionNumber
				+ "', CallNumber = N'" + CallNumber + "', Label = N'" + Label + "', Keywords = N'" + Keywords
				+ "', Abstract = N'" + Abstract + "', Notes = N'" + Notes + "', ResearchNotes = N'" + ResearchNotes
				+ "', URL = N'" + URL + "', AuthorAddress = N'" + AuthorAddress + "', Figure = N'" + Figure
				+ "', Caption = N'" + Caption + "', AccessDate = N'" + AccessDate
				+ "', TranslatedAuthor = N'" + TranslatedAuthor + "', TranslatedTitle = N'" + TranslatedTitle
				+ "', NameOfDatabase = N'" + NameOfDatabase + "', DatabaseProvider = N'" + DatabaseProvider
				+ "', Language = N'" + Language
				+ "' WHERE ReferenceID = " + ReferenceID;
	}
	
	public String getQuerySaveThesis(String ReferenceID,
			String Author, String Year, String Title, String SecondaryAuthor, String AcademicDepartment,
			String PlacePublished, String University, String Degree, String NumberOfVolumes,
			String DocumentNumber,String NumberOfPages, String Advisor, String Date, String ThesisType,
			String ShortTitle, String ISBN, String DOI, String AccessionNumber, String CallNumber,
			String Label, String Keywords, String Abstract, String Notes,
			String ResearchNotes, String URL, String AuthorAddress, String Figure, String Caption,
			String AccessDate, String TranslatedAuthor, String TranslatedTitle, String NameOfDatabase,
			String DatabaseProvider, String Language) {
		return "UPDATE Reference SET "
				+ "TypeID = 5, Author = N'" + Author + "', Year = N'" + Year + "', Title = N'" + Title
				+ "SecondaryAuthor = N'" + SecondaryAuthor + "', AcademicDepartment = N'" + AcademicDepartment
				+ "', PlacePublished = N'" + PlacePublished + "', University = N'" + University
				+ "', Degree = N'" + Degree + "', NumberOfVolumes = N'" + NumberOfVolumes
				+ "', DocumentNumber = N'" + DocumentNumber + "', NumberOfPages = N'" + NumberOfPages
				+ "', Advisor = N'" + Advisor + "', Date = N'" + Date + "', ThesisType = N'" + ThesisType
				+ "', ShortTitle = N'" + ShortTitle + "', ISBN = N'" + ISBN + "', DOI = N'" + DOI
				+ "', AccessionNumber = N'" + AccessionNumber
				+ "', CallNumber = N'" + CallNumber + "', Label = N'" + Label + "', Keywords = N'" + Keywords
				+ "', Abstract = N'" + Abstract + "', Notes = N'" + Notes + "', ResearchNotes = N'" + ResearchNotes
				+ "', URL = N'" + URL + "', AuthorAddress = N'" + AuthorAddress + "', Figure = N'" + Figure
				+ "', Caption = N'" + Caption + "', AccessDate = N'" + AccessDate
				+ "', TranslatedAuthor = N'" + TranslatedAuthor + "', TranslatedTitle = N'" + TranslatedTitle
				+ "', NameOfDatabase = N'" + NameOfDatabase + "', DatabaseProvider = N'" + DatabaseProvider
				+ "', Language = N'" + Language
				+ "' WHERE ReferenceID = " + ReferenceID;
	}
	
	public String getQueryGetComment(String ReferenceID) {
		return "SELECT Comment FROM Reference WHERE ReferenceID = " + ReferenceID;
	}
	
	public String getQueryUpdateComment(String ReferenceID, String Comment) {
		return "UPDATE Reference SET "
				+ "Comment = N'" + Comment + "' "
				+ "WHERE ReferenceID = " + ReferenceID;
	}
	
	public String getQueryUpdateAttachPath(String ReferenceID, String path) {
		return "UPDATE Reference SET "
				+ "PathAttach = N'" + path + "' "
				+ "WHERE ReferenceID = " + ReferenceID;
	}
}

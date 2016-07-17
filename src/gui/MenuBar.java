package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class MenuBar implements ActionListener {

	private JMenuBar menuBar;
	private JMenuItem itemNew;
	private JMenuItem itemClose;
	private JMenuItem itemSave;
	private JMenuItem itemSaveAs;
	private JMenuItem itemSaveCopy;
	private JMenuItem itemRevert;
	private JMenuItem itemExport;
	private JMenuItem itemExit;
	private JMenuItem itemPrint;
	private JMenuItem itemPrintPreview;
	private JMenuItem itemCompressed;
	private JMenuItem itemOpenLibrary;
	private JMenuItem itemOtherLibrary;
	private JMenu menuImport;
	private JMenuItem itemImportFile;
	private JMenuItem itemSetup;

	private JMenuItem itemUndo;
	private JMenuItem itemClear;
	private JMenuItem itemCut;
	private JMenuItem itemCopy;
	private JMenuItem itemPaste;
	private JMenuItem itemFind;
	private JMenuItem itemCopyFormat;
	private JMenuItem itemPreferences;
	private JMenuItem itemPlainFont;

	private JMenuItem itemNewReference;
	private JMenuItem itemEditReference;
	private JMenuItem itemMoveToTrash;
	private JMenuItem itemGoto;
	private JMenu menuCopyTo;
	private JMenuItem itemCopyNewLibrary;
	private JMenuItem itemChooseLibrary;
	private JMenuItem itemCopyTo;
	private JMenuItem itemEmail;
	private JMenu menuFileAttachments;
	private JMenu menuPdfViewer;
	private JMenu menuFindFullText;
	private JMenuItem itemFindUdate;
	private JMenu menuUrl;
	private JMenu menuFigure;
	private JMenuItem itemNext;
	private JMenuItem itemPrevious;
	private JMenuItem itemShowAll;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem itemHideSelected;
	private JMenuItem itemRecord;
	private JMenuItem itemFindDuplicates;
	private JMenuItem itemRestore;
	private JMenuItem itemResolve;
	private JMenuItem itemEmptyTrash;

	public MenuBar() {
		init();
	}

	private void init() {

		menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);

		JMenu menuFile = new JMenu("File");
		MenuFile(menuFile);
		menuBar.add(menuFile);

		JMenu menuEdit = new JMenu("Edit");
		MenuEdit(menuEdit);
		menuBar.add(menuEdit);

		JMenu menuReference = new JMenu("References");
		MenuReference(menuReference);
		menuBar.add(menuReference);

		JMenu menuGroups = new JMenu("Groups");
		MenuGroup(menuGroups);
		menuBar.add(menuGroups);

		JMenu menuTools = new JMenu("Tools");
		MenuTools(menuTools);
		menuBar.add(menuTools);

		JMenu menuWindow = new JMenu("Window");
		MenuWindow(menuWindow);
		menuBar.add(menuWindow);

		JMenu menHelp = new JMenu("Help");
		MenuHelp(menHelp);
		menuBar.add(menHelp);
	}

	private void MenuFile(JMenu menu) {
		itemNew = new JMenuItem("New...");
		itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		menu.add(itemNew);

		JMenu menuOpen = new JMenu("Open");
		menu.add(menuOpen);

		itemOpenLibrary = new JMenuItem("Open Library");
		menuOpen.add(itemOpenLibrary);

		itemOtherLibrary = new JMenuItem("Other Library");
		menuOpen.add(itemOtherLibrary);

		itemClose = new JMenuItem("Close Library");
		itemClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
		menu.add(itemClose);

		JSeparator separator = new JSeparator();
		menu.add(separator);

		itemSave = new JMenuItem("Save");
		itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		menu.add(itemSave);

		itemSaveAs = new JMenuItem("Save As...");
		menu.add(itemSaveAs);

		itemSaveCopy = new JMenuItem("Save a Copy");
		menu.add(itemSaveCopy);

		itemRevert = new JMenuItem("Revert");
		menu.add(itemRevert);

		JSeparator separator_1 = new JSeparator();
		menu.add(separator_1);

		itemExport = new JMenuItem("Export");
		menu.add(itemExport);

		menuImport = new JMenu("Import");
		menu.add(menuImport);

		itemImportFile = new JMenuItem("File");
		menuImport.add(itemImportFile);

		JMenuItem itemImportFolde = new JMenuItem("Folder");
		menuImport.add(itemImportFolde);

		JSeparator separator_2 = new JSeparator();
		menu.add(separator_2);

		itemPrint = new JMenuItem("Print...");
		itemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		menu.add(itemPrint);

		itemPrintPreview = new JMenuItem("Print Preview");
		menu.add(itemPrintPreview);

		itemSetup = new JMenuItem("Print Setup");
		menu.add(itemSetup);

		itemCompressed = new JMenuItem("Compressed Library");
		menu.add(itemCompressed);

		JSeparator separator_3 = new JSeparator();
		menu.add(separator_3);

		itemExit = new JMenuItem("Exit");
		itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		menu.add(itemExit);
	}

	private void MenuEdit(JMenu menu) {
		// tạo các item lựa chọn và thêm chúng vào menu
		itemUndo = new JMenuItem("Undo");
		itemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		itemUndo.addActionListener(this);
		menu.add(itemUndo);
		itemUndo.setEnabled(false);
		menu.addSeparator();

		itemCut = new JMenuItem("Cut");
		itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		itemCut.addActionListener(this);
		menu.add(itemCut);

		itemCopy = new JMenuItem("Copy");
		itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		itemCopy.setEnabled(false);
		itemCopy.addActionListener(this);
		menu.add(itemCopy);

		itemPaste = new JMenuItem("Paste");
		itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		itemPaste.setEnabled(false);
		itemPaste.addActionListener(this);
		menu.add(itemPaste);

		itemClear = new JMenuItem("Clear");
		itemClear.setEnabled(false);
		itemClear.addActionListener(this);
		menu.add(itemClear);

		itemCopyFormat = new JMenuItem("Copy Formatted");
		itemCopyFormat.setEnabled(false);
		itemCopyFormat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		itemCopyFormat.addActionListener(this);
		menu.add(itemCopyFormat);

		itemFind = new JMenuItem("Find and Replace");
		itemFind.setEnabled(false);
		itemFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		itemFind.addActionListener(this);
		menu.add(itemFind);
		menu.addSeparator();

		JMenu menuFont = new JMenu("Font");
		itemPlainFont = new JMenuItem("Plain Font");
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK);

		itemPlainFont.setAccelerator(key);
		itemPaste.addActionListener(this);
		menuFont.add(itemPlainFont);
		menu.add(menuFont);

		itemPreferences = new JMenuItem("Preferences...");
		itemPreferences.addActionListener(this);
		menu.add(itemPreferences);

	}

	private void MenuWindow(JMenu menu) {

		JMenuItem itemCascade = new JMenuItem("Cascade");
		menu.add(itemCascade);

		JMenuItem itemTileVertically = new JMenuItem("Tile Vertically");
		menu.add(itemTileVertically);

		JMenuItem itemTileHorizontally = new JMenuItem("Tile Horizontally");
		menu.add(itemTileHorizontally);

		JMenuItem itemArrangeIcons = new JMenuItem("Arrange Icons");
		menu.add(itemArrangeIcons);

		JMenuItem itemCloseAll = new JMenuItem("Close All Libraries");
		itemCloseAll
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		menu.add(itemCloseAll);

		JSeparator separator_12 = new JSeparator();
		menu.add(separator_12);

		JMenuItem itemShowConnectionStatus = new JMenuItem("Show Connection Status");
		menu.add(itemShowConnectionStatus);

		JSeparator separator_13 = new JSeparator();
		menu.add(separator_13);

		JMenuItem itemLibraryCurrent = new JMenuItem("Library current");
		menu.add(itemLibraryCurrent);
	}

	private void MenuGroup(JMenu menu) {

		JMenuItem itemCreateGroup = new JMenuItem("Create Group");
		menu.add(itemCreateGroup);

		JMenuItem itemCreateSmartGroup = new JMenuItem("Create Smart Group");
		menu.add(itemCreateSmartGroup);

		JMenuItem itemCreateFromGroup = new JMenuItem("Create From Groups");
		menu.add(itemCreateFromGroup);

		JSeparator separator_9 = new JSeparator();
		menu.add(separator_9);

		JMenuItem itemRenameGroup = new JMenuItem("Rename Group");
		itemRenameGroup.setEnabled(false);
		menu.add(itemRenameGroup);

		JMenuItem itemEditGroup = new JMenuItem("Edit Group...");
		itemEditGroup.setEnabled(false);
		menu.add(itemEditGroup);

		JMenuItem itemDeleteGroup = new JMenuItem("Delete Group");
		itemDeleteGroup.setEnabled(false);
		menu.add(itemDeleteGroup);

		JMenu itemAddReferencesTo = new JMenu("Add References to");
		menu.add(itemAddReferencesTo);

		JMenuItem itemRemoveFromGroup = new JMenuItem("Remove References From Group");
		menu.add(itemRemoveFromGroup);

		JSeparator separator_10 = new JSeparator();
		menu.add(separator_10);

		JMenuItem itemCreateGroupSet = new JMenuItem("Create Group Set");
		menu.add(itemCreateGroupSet);

		JMenuItem itemDeleteGroupSet = new JMenuItem("Delete Group Set");
		itemDeleteGroupSet.setEnabled(false);
		menu.add(itemDeleteGroupSet);

		JMenuItem itemRenameGroupSet = new JMenuItem("Rename Group Set");
		itemRenameGroupSet.setEnabled(false);
		menu.add(itemRenameGroupSet);

		JSeparator separator_11 = new JSeparator();
		menu.add(separator_11);

		JMenuItem itemHideGroups = new JMenuItem("Hide Groups");
		menu.add(itemHideGroups);
	}

	private void MenuHelp(JMenu menu) {

		JMenuItem itemContents = new JMenuItem("Contents");
		menu.add(itemContents);

		JMenuItem itemSearchForHelp = new JMenuItem("Search for Help online");
		menu.add(itemSearchForHelp);

		JMenuItem mntmQuickReferenceCard = new JMenuItem("Quick Reference Card");
		menu.add(mntmQuickReferenceCard);

		JMenuItem mntmGettingStartedGuide = new JMenuItem("Getting Started Guide");
		menu.add(mntmGettingStartedGuide);

		JMenuItem itemWebSuport = new JMenuItem("Web Suport...");
		menu.add(itemWebSuport);

		JMenuItem itemWebStyleFinder = new JMenuItem("Web Style Finder...");
		menu.add(itemWebStyleFinder);
	}

	private void MenuTools(JMenu menu) {
		menu.setBackground(Color.WHITE);

		JMenuItem itemSearchLibrary = new JMenuItem("Search Library...");
		menu.add(itemSearchLibrary);

		JMenuItem itemSpellCheck = new JMenuItem("Spell Check");
		menu.add(itemSpellCheck);

		JMenu memuCiteWhiteYou = new JMenu("Cite White You Write [CWYW]");
		menu.add(memuCiteWhiteYou);

		JMenuItem mntmCiteWhiteYou = new JMenuItem("Online Search...");
		menu.add(mntmCiteWhiteYou);

		JMenu mnFormatPaper = new JMenu("Format Paper");
		menu.add(mnFormatPaper);

		JMenuItem itemFieldsActions = new JMenuItem("Chang/Move/Copy Fields...");
		menu.add(itemFieldsActions);
	}

	private void MenuReference(JMenu menu) {
		itemNewReference = new JMenuItem("New Referrence");
		menu.add(itemNewReference);

		itemEditReference = new JMenuItem("Edit Reference");
		itemEditReference.setEnabled(false);
		menu.add(itemEditReference);

		itemMoveToTrash = new JMenuItem("Move References to Trash");
		itemMoveToTrash.setEnabled(false);
		menu.add(itemMoveToTrash);

		itemGoto = new JMenuItem("Go To");
		menu.add(itemGoto);
		// /

		menuCopyTo = new JMenu("Copy Referen To");
		menu.add(menuCopyTo);

		itemCopyNewLibrary = new JMenuItem("New Library...");
		itemCopyNewLibrary.setEnabled(false);
		menuCopyTo.add(itemCopyNewLibrary);

		itemChooseLibrary = new JMenuItem("Choose Library...");
		itemChooseLibrary.setEnabled(false);
		menuCopyTo.add(itemChooseLibrary);

		itemCopyTo = new JMenuItem("Copy Reference To");
		menu.add(itemCopyTo);

		itemEmail = new JMenuItem("E-mail Reference");
		itemEmail.setEnabled(false);
		menu.add(itemEmail);

		JSeparator separator_4 = new JSeparator();
		menu.add(separator_4);

		menuFileAttachments = new JMenu("File Attachments");
		menu.add(menuFileAttachments);

		menuPdfViewer = new JMenu("PDF Viewer");
		menu.add(menuPdfViewer);

		menuFindFullText = new JMenu("Find Full Text");
		menu.add(menuFindFullText);

		itemFindUdate = new JMenuItem("Find Reference Update");
		itemFindUdate.setEnabled(false);
		menu.add(itemFindUdate);

		menuUrl = new JMenu("URL");
		menu.add(menuUrl);

		menuFigure = new JMenu("Figure");
		menu.add(menuFigure);

		JSeparator separator_5 = new JSeparator();
		menu.add(separator_5);

		itemNext = new JMenuItem("Next Referemce");
		itemNext.setEnabled(false);
		menu.add(itemNext);

		itemPrevious = new JMenuItem("Previous Reference");
		itemPrevious.setEnabled(false);
		menu.add(itemPrevious);

		itemShowAll = new JMenuItem("Show All References");
		itemShowAll.setEnabled(false);
		menu.add(itemShowAll);

		mntmNewMenuItem = new JMenuItem("Show Selected References");
		mntmNewMenuItem.setEnabled(false);
		menu.add(mntmNewMenuItem);

		itemHideSelected = new JMenuItem("Hide Selected References");
		itemHideSelected.setEnabled(false);
		menu.add(itemHideSelected);

		JSeparator separator_6 = new JSeparator();
		menu.add(separator_6);

		itemRecord = new JMenuItem("Record Summary...");
		itemRecord.setEnabled(false);
		menu.add(itemRecord);

		JSeparator separator_7 = new JSeparator();
		menu.add(separator_7);

		itemFindDuplicates = new JMenuItem("Find Duplicates");
		menu.add(itemFindDuplicates);

		JSeparator separator_8 = new JSeparator();
		menu.add(separator_8);

		itemRestore = new JMenuItem("Restore to Library");
		itemRestore.setEnabled(false);
		menu.add(itemRestore);

		itemResolve = new JMenuItem("Resolve Sync Conflicts...");
		itemResolve.setEnabled(false);
		menu.add(itemResolve);

		itemEmptyTrash = new JMenuItem("Empty Trash");
		menu.add(itemEmptyTrash);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public JMenuItem getItemNewReference() {
		return itemNewReference;
	}

	public JMenuItem getItemImportFile() {
		return itemImportFile;
	}
}

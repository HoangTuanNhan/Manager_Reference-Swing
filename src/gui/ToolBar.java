package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ToolBar {
	private JPanel panelTools;
	private JButton buttonLibraryMode;
	private JButton buttonSearchOnlineMode;
	private JButton buttonIntergrated;
	private JButton buttonCopyLibrary;
	private JButton buttonNewReferences;

	private JButton buttonOnlineSearch;
	private JButton buttonImport;
	private JButton buttonExport;

	private JButton buttonFind;
	private JButton buttonOpenLink;
	private JButton buttonOpenFile;
	private JButton buttonInsertCitation;
	private JButton buttonFormat;
	private JButton buttonGoToWordProcessor;
	private JButton buttonSync;
	private JButton buttonHelp;
	private JComboBox<String> comboBoxStyle;
	private JComboBox<String> comboBoxQuickSearch;
	
	private JButton buttonAttachFile;

	public ToolBar() {
		init();
	}

	private void init() {
		panelTools = new JPanel();
		panelTools.setLayout(new BoxLayout(panelTools, BoxLayout.X_AXIS));

		buttonLibraryMode = new JButton(new ImageIcon("icon/library.png"));
		buttonLibraryMode.setPreferredSize(new Dimension(32, 32));
		buttonLibraryMode.setLayout(new BorderLayout());
		buttonLibraryMode.setBackground(Color.WHITE);
		buttonLibraryMode.setBorderPainted(false);
		buttonLibraryMode.setToolTipText("Library");
		panelTools.add(buttonLibraryMode);

		buttonSearchOnlineMode = new JButton(new ImageIcon("icon/web.png"));
		buttonSearchOnlineMode.setPreferredSize(new Dimension(32, 32));
		buttonSearchOnlineMode.setLayout(new BorderLayout());
		buttonSearchOnlineMode.setBackground(Color.WHITE);
		buttonSearchOnlineMode.setBorderPainted(false);
		buttonSearchOnlineMode.setToolTipText("Search Online");
		panelTools.add(buttonSearchOnlineMode);

		buttonIntergrated = new JButton(new ImageIcon("icon/web_library.png"));
		buttonIntergrated.setPreferredSize(new Dimension(32, 32));
		buttonIntergrated.setLayout(new BorderLayout());
		buttonIntergrated.setBackground(Color.WHITE);
		buttonIntergrated.setBorderPainted(false);
		buttonIntergrated.setToolTipText("Intergrated");
		panelTools.add(buttonIntergrated);

		String str[] = { "IEEE", "Annotated" };
		comboBoxStyle = new JComboBox<String>(str);
		comboBoxStyle.setBackground(Color.WHITE);
		comboBoxStyle.setPreferredSize(new Dimension(120, 20));
		for (int i = 0; i < comboBoxStyle.getComponentCount(); i++) {
			if (comboBoxStyle.getComponent(i) instanceof JComponent) {
				((JComponent) comboBoxStyle.getComponent(i))
						.setBorder(new EmptyBorder(0, 0, 0, 0));
			}

			if (comboBoxStyle.getComponent(i) instanceof AbstractButton) {
				((AbstractButton) comboBoxStyle.getComponent(i))
						.setBorderPainted(false);
			}
		}
		comboBoxStyle.setBorder(new EmptyBorder(0, 0, 0, 0));
		comboBoxStyle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		JPanel panelComboBox = new JPanel();
		panelComboBox.setBackground(Color.WHITE);
		panelComboBox.add(comboBoxStyle);
		panelTools.add(panelComboBox);

		buttonCopyLibrary = new JButton(new ImageIcon("icon/copy.png"));
		buttonCopyLibrary.setPreferredSize(new Dimension(32, 32));
		buttonCopyLibrary.setLayout(new BorderLayout());
		buttonCopyLibrary.setBackground(Color.WHITE);
		buttonCopyLibrary.setBorderPainted(false);
		buttonCopyLibrary.setToolTipText("Copy Library");
		panelTools.add(buttonCopyLibrary);

		buttonNewReferences = new JButton(
				new ImageIcon("icon/newReference.png"));
		buttonNewReferences.setPreferredSize(new Dimension(32, 32));
		buttonNewReferences.setBackground(Color.WHITE);
		buttonNewReferences.setBorderPainted(false);
		buttonNewReferences.setToolTipText("New Reference");
		panelTools.add(buttonNewReferences);

		buttonOnlineSearch = new JButton(new ImageIcon("icon/onlinesearch.png"));
		buttonOnlineSearch.setPreferredSize(new Dimension(32, 32));
		buttonOnlineSearch.setLayout(new BorderLayout());
		buttonOnlineSearch.setBackground(Color.WHITE);
		buttonOnlineSearch.setBorderPainted(false);
		buttonOnlineSearch.setToolTipText("Online Search");
		panelTools.add(buttonOnlineSearch);

		buttonImport = new JButton(new ImageIcon("icon/import.png"));
		buttonImport.setPreferredSize(new Dimension(32, 32));
		buttonImport.setLayout(new BorderLayout());
		buttonImport.setBackground(Color.WHITE);
		buttonImport.setBorderPainted(false);
		buttonImport.setToolTipText("Import");
		panelTools.add(buttonImport);

		buttonExport = new JButton(new ImageIcon("icon/export.png"));
		buttonExport.setPreferredSize(new Dimension(32, 32));
		buttonExport.setLayout(new BorderLayout());
		buttonExport.setBackground(Color.WHITE);
		buttonExport.setBorderPainted(false);
		buttonExport.setToolTipText("Export");
		panelTools.add(buttonExport);

		buttonFind = new JButton(new ImageIcon("icon/findFull.png"));
		buttonFind.setPreferredSize(new Dimension(32, 32));
		buttonFind.setLayout(new BorderLayout());
		buttonFind.setBackground(Color.WHITE);
		buttonFind.setBorderPainted(false);
		buttonFind.setToolTipText("Find");
		panelTools.add(buttonFind);

		buttonOpenLink = new JButton(new ImageIcon("icon/openlink.png"));
		buttonOpenLink.setPreferredSize(new Dimension(32, 32));
		buttonOpenLink.setLayout(new BorderLayout());
		buttonOpenLink.setBackground(Color.WHITE);
		buttonOpenLink.setBorderPainted(false);
		buttonOpenLink.setToolTipText("Open Link");
		panelTools.add(buttonOpenLink);

		buttonOpenFile = new JButton(new ImageIcon("icon/openfile.png"));
		buttonOpenFile.setPreferredSize(new Dimension(32, 32));
		buttonOpenFile.setLayout(new BorderLayout());
		buttonOpenFile.setBackground(Color.WHITE);
		buttonOpenFile.setBorderPainted(false);
		buttonOpenFile.setToolTipText("Open File");
		panelTools.add(buttonOpenFile);

		buttonInsertCitation = new JButton(new ImageIcon("icon/insert.png"));
		buttonInsertCitation.setPreferredSize(new Dimension(32, 32));
		buttonInsertCitation.setLayout(new BorderLayout());
		buttonInsertCitation.setBackground(Color.WHITE);
		buttonInsertCitation.setBorderPainted(false);
		buttonInsertCitation.setToolTipText("Insert Citation");
		panelTools.add(buttonInsertCitation);

		buttonFormat = new JButton(new ImageIcon("icon/format.png"));
		buttonFormat.setPreferredSize(new Dimension(32, 32));
		buttonFormat.setLayout(new BorderLayout());
		buttonFormat.setBackground(Color.WHITE);
		buttonFormat.setBorderPainted(false);
		buttonFormat.setToolTipText("Format");
		panelTools.add(buttonFormat);

		buttonGoToWordProcessor = new JButton(new ImageIcon(
				"icon/goToWordProcessor.png"));
		buttonGoToWordProcessor.setPreferredSize(new Dimension(32, 32));
		buttonGoToWordProcessor.setLayout(new BorderLayout());
		buttonGoToWordProcessor.setBackground(Color.WHITE);
		buttonGoToWordProcessor.setBorderPainted(false);
		buttonGoToWordProcessor.setToolTipText("Go To Word Processor");
		panelTools.add(buttonGoToWordProcessor);

		buttonSync = new JButton(new ImageIcon("icon/sync.png"));
		buttonSync.setPreferredSize(new Dimension(32, 32));
		buttonSync.setLayout(new BorderLayout());
		buttonSync.setBackground(Color.WHITE);
		buttonSync.setBorderPainted(false);
		buttonSync.setToolTipText("Sync");
		panelTools.add(buttonSync);

		buttonHelp = new JButton(new ImageIcon("icon/help.png"));
		buttonHelp.setPreferredSize(new Dimension(32, 32));
		buttonHelp.setLayout(new BorderLayout());
		buttonHelp.setBackground(Color.WHITE);
		buttonHelp.setBorderPainted(false);
		buttonHelp.setToolTipText("Help");
		panelTools.add(buttonHelp);

		comboBoxQuickSearch = new JComboBox<String>();
		comboBoxQuickSearch.setEditable(true);
		comboBoxQuickSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		for (int i = 0; i < comboBoxQuickSearch.getComponentCount(); i++) {
			if (comboBoxQuickSearch.getComponent(i) instanceof JComponent) {
				((JComponent) comboBoxQuickSearch.getComponent(i))
						.setBorder(new EmptyBorder(0, 0, 0, 0));
			}

			if (comboBoxQuickSearch.getComponent(i) instanceof AbstractButton) {
				((AbstractButton) comboBoxQuickSearch.getComponent(i))
						.setBorderPainted(false);
			}
		}
		panelComboBox = new JPanel();
		panelComboBox.setBackground(Color.WHITE);
		panelComboBox.add(comboBoxQuickSearch);
		panelTools.add(panelComboBox);

		JButton btnQ = new JButton("Show Search Panel");
		btnQ.setHorizontalAlignment(SwingConstants.RIGHT);
		btnQ.setPreferredSize(new Dimension(160, 32));
		btnQ.setBackground(Color.WHITE);
		btnQ.setBorderPainted(false);
		panelTools.add(btnQ);
		
		buttonAttachFile = new JButton(new ImageIcon("icon/attach.png"));
		buttonAttachFile.setPreferredSize(new Dimension(32, 32));
		buttonAttachFile.setLayout(new BorderLayout());
		buttonAttachFile.setBackground(Color.WHITE);
		buttonAttachFile.setBorderPainted(false);
		buttonAttachFile.setToolTipText("Attach File");
		buttonAttachFile.setEnabled(false);
		panelTools.add(buttonAttachFile);
	}

	public JPanel getPanelTools() {
		return panelTools;
	}

	public JButton getButtonNewReferences() {
		return buttonNewReferences;
	}

	public JButton getButtonImport() {
		return buttonImport;
	}

	public JButton getButtonAttachFile() {
		return buttonAttachFile;
	}
}

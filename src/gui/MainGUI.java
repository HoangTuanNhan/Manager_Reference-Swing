package gui;

import gui.panels.PanelCenter;
import gui.panels.PanelLeft;
import gui.panels.PanelRight;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

import services.DatabaseConnection;
import services.LoadDatabase;
import services.QueryModel;
import services.controls.ButtonFunctionAction;
import services.controls.ComboxTypeSelection;
import services.controls.CommentAction;
import services.controls.LoadMap;
import services.controls.MapPopupMenu;
import services.controls.MapSelection;
import services.controls.MenuBarAction;
import services.controls.TablePopupMenu;
import services.controls.TableSelection;
import services.controls.toolbarAction.ButtonAttachAction;
import services.controls.toolbarAction.ButtonImportAction;
import services.controls.toolbarAction.ButtonNewReferenceAction;

public class MainGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private PanelLeft panelLeft;
	private PanelCenter panelCenter;
	private PanelRight panelRight;
	private Connection conn;
	private LoadDatabase loadDatabase;
	private QueryModel queryModel;
	private ToolBar toolBar;
	private MenuBar menuBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new MainGUI().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		conn = connectToDatabase("localhost", "1433", "ReferenceManager", "sa",
				"12");
		loadDatabase = new LoadDatabase(conn);
		queryModel = new QueryModel();
		init();
		controls();
	}

	private Connection connectToDatabase(String host, String port,
			String dbname, String user, String pwd) {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		databaseConnection.connectDatabase(host, port, dbname, user, pwd);
		return databaseConnection.getConn();
	}

	private void init() {
		this.setBackground(Color.WHITE);
		this.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH); // Maximize
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200, 100, 860, 480); // kích thước cửa sổ khi Restore
											// Down
		ImageIcon image = new ImageIcon("icon/endnote.png");
		this.setIconImage(image.getImage()); // set Icon
		this.setTitle("Reference Manager - SQNH"); // set Title
		menuBar = new MenuBar();
		this.setJMenuBar(menuBar.getMenuBar());// set MenuBar

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(contentPane); // set ContentPane

		AddPanelNorth(); // add thanh công cụ vào contentPane
		AddPanelMain(); // add giao diện chính vào contentPane
	}

	private void AddPanelNorth() {
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.WHITE);
		panelNorth.setLayout(new BorderLayout());

		// thêm thanh công cụ với các thành phần chức năng được định nghĩa
		// trong lớp ToolBar
		toolBar = new ToolBar();
		panelNorth.add(toolBar.getPanelTools(), BorderLayout.WEST);

		// add panelNorth vào contentPane
		contentPane.add(panelNorth, BorderLayout.NORTH);
	}

	private void AddPanelMain() {

		panelLeft = new PanelLeft();
		panelCenter = new PanelCenter();
		panelRight = new PanelRight();

		JSplitPane splitPaneInner = new JSplitPane();
		splitPaneInner.setLeftComponent(panelLeft);
		splitPaneInner.setRightComponent(panelCenter);
		splitPaneInner.setResizeWeight(0.2);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setLeftComponent(splitPaneInner);
		splitPane.setRightComponent(panelRight);
		splitPane.setResizeWeight(0.8);

		// add splitPane vào centenPane
		contentPane.add(splitPane, BorderLayout.CENTER);
	}

	private void controls() {
		new LoadMap(panelLeft.getTreeMap(), loadDatabase, queryModel).load();
		MapSelection mapSelection = new MapSelection(panelLeft.getTreeMap(),
				panelCenter.getTableCenter(), panelRight, loadDatabase,
				queryModel);
		mapSelection.updateTableCenter();
		mapSelection.updatePanelRight();
		new TableSelection(panelCenter.getTableCenter(), panelRight,
				loadDatabase, queryModel).update();
		new ComboxTypeSelection(panelRight.getPanelReferenceDetailTab()
				.getComboBoxType(), panelRight.getPanelReferenceDetailTab()
				.getPanelReferenceSelectedCenter()).update();
		new MapPopupMenu(panelLeft.getTreeMap(), loadDatabase, queryModel)
				.add();
		new TablePopupMenu(panelLeft.getTreeMap(),
				panelCenter.getTableCenter(), loadDatabase, queryModel).add();
		new MenuBarAction(this, menuBar, loadDatabase, queryModel)
				.addMenuBarAction();
		new ButtonNewReferenceAction(this, loadDatabase, queryModel)
				.addAction();
		new ButtonFunctionAction(this, loadDatabase, queryModel)
				.addButtonFunctionAction();
		new CommentAction(this, loadDatabase, queryModel).addCommentAction();
		new ButtonImportAction(this, loadDatabase, queryModel).addAction();
		new ButtonAttachAction(this, loadDatabase, queryModel).addAction();
	}

	public PanelLeft getPanelLeft() {
		return panelLeft;
	}

	public PanelCenter getPanelCenter() {
		return panelCenter;
	}

	public PanelRight getPanelRight() {
		return panelRight;
	}

	public ToolBar getToolBar() {
		return toolBar;
	}
}

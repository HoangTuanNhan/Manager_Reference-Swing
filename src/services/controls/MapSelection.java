package services.controls;

import gui.panels.PanelRight;

import java.awt.CardLayout;

import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import services.LoadDatabase;
import services.QueryModel;

/**
 * update displaying from treeMap selection
 */

public class MapSelection {

	JTree treeMap;
	JTable tableCenter;
	PanelRight panelRight;
	LoadDatabase loadDatabase;
	QueryModel queryModel;

	public MapSelection(JTree treeMap, JTable tableCenter,
			PanelRight panelRight, LoadDatabase loadDatabase,
			QueryModel queryModel) {
		this.treeMap = treeMap;
		this.tableCenter = tableCenter;
		this.panelRight = panelRight;
		this.loadDatabase = loadDatabase;
		this.queryModel = queryModel;
	}

	// update tableCenter from treeMap selection
	public void updateTableCenter() {

		treeMap.getSelectionModel().addTreeSelectionListener(
				new TreeSelectionListener() {
					@Override
					public void valueChanged(TreeSelectionEvent tse) {
						if (tse.isAddedPath()) {
							MapNumbered mapNumbered = new MapNumbered(treeMap,
									loadDatabase, queryModel);
							mapNumbered.removeNumbered();
							if (tse.getPath().getPathCount() == 2) {
								switch (treeMap.getRowForPath(tse.getPath())) {
								case 0: // All Reference
									tableCenter.setModel(loadDatabase
											.convertDatabaseToTableModel(queryModel
													.getQueryAllReference()));
									break;
								case 1: // Unfiled
									tableCenter.setModel(loadDatabase
											.convertDatabaseToTableModel(queryModel
													.getQueryUnfiled()));
									break;
								case 2: // Trash
									tableCenter.setModel(loadDatabase
											.convertDatabaseToTableModel(queryModel
													.getQueryTrash()));
									break;
								default: // >= 3
									updateDataTableWithGroupSet(tse.getPath()
											.getLastPathComponent().toString());
									break;
								}
							} else if (tse.getPath().getPathCount() == 3) {
								updateDataTableWithGroup(tse.getPath()
										.getLastPathComponent().toString(), tse
										.getPath().getPathComponent(1)
										.toString());
							}
							mapNumbered.addNumbered();
						}
					}
				});
	}

	// reset PanelRight when treeMap Changed Selection
	public void updatePanelRight() {
		resetPanelAttachFileTab();
		resetPanelPreviewTab();
		resetPanelReferenceDetailTab();
	}

	// reset PanelAttachFileTab when treeMap Changed Selection
	private void resetPanelAttachFileTab() {
		treeMap.getSelectionModel().addTreeSelectionListener(
				new TreeSelectionListener() {

					@Override
					public void valueChanged(TreeSelectionEvent e) {
						CardLayout cardLayout = (CardLayout) panelRight
								.getPanelAttachFileTab().getLayout();
						cardLayout.show(panelRight.getPanelAttachFileTab(), "0");
					}
				});
	}

	// reset PanelPreviewTab when treeMap Changed Selection
	private void resetPanelPreviewTab() {
		treeMap.getSelectionModel().addTreeSelectionListener(
				new TreeSelectionListener() {

					@Override
					public void valueChanged(TreeSelectionEvent e) {
						CardLayout cardLayout = (CardLayout) panelRight
								.getPanelPreviewTab().getLayout();
						cardLayout.show(panelRight.getPanelPreviewTab(), "0");
					}
				});
	}

	// reset PanelReferenceDetailTab when treeMap Changed Selection
	private void resetPanelReferenceDetailTab() {
		treeMap.getSelectionModel().addTreeSelectionListener(
				new TreeSelectionListener() {

					@Override
					public void valueChanged(TreeSelectionEvent e) {
						CardLayout cardLayout = (CardLayout) panelRight
								.getPanelReferenceDetailTab().getLayout();
						cardLayout.show(
								panelRight.getPanelReferenceDetailTab(), "0");
					}
				});
	}

	private void updateDataTableWithGroupSet(String groupSetName) {
		updateDataTable(queryModel.getQueryDataFromGroupSet(groupSetName));
	}

	private void updateDataTableWithGroup(String groupName, String groupSetName) {
		updateDataTable(queryModel.getQueryDataFromGroup(groupName,
				groupSetName));
	}

	private void updateDataTable(String query) {
		tableCenter.setModel(loadDatabase.convertDatabaseToTableModel(query));
	}
}

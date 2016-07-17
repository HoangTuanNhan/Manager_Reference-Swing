package services.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import services.LoadDatabase;
import services.QueryModel;

public class MenuItem {

	private JTree treeMap;
	private JTable tableCenter;
	private LoadDatabase loadDatabase;
	private QueryModel queryModel;
	MapNumbered mapNumbered;

	public MenuItem(JTree treeMap, LoadDatabase loadDatabase,
			QueryModel queryModel) {
		this.treeMap = treeMap;
		this.loadDatabase = loadDatabase;
		this.queryModel = queryModel;
		mapNumbered = new MapNumbered(treeMap, loadDatabase, queryModel);
	}

	public MenuItem(JTree treeMap, JTable tableCenter,
			LoadDatabase loadDatabase, QueryModel queryModel) {
		this.treeMap = treeMap;
		this.tableCenter = tableCenter;
		this.loadDatabase = loadDatabase;
		this.queryModel = queryModel;
		mapNumbered = new MapNumbered(treeMap, loadDatabase, queryModel);
	}

	/**
	 * MenuItem create Group Set
	 */
	public JMenuItem getMiCreateGroupSet() {
		JMenuItem miCreateGroupSet = new JMenuItem("Create Group Set");

		miCreateGroupSet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String groupSetName = JOptionPane
						.showInputDialog("New Group Set?");
				if (groupSetName != null) {
					mapNumbered.removeNumbered();

					DefaultTreeModel treeModel = (DefaultTreeModel) treeMap
							.getModel();
					DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel
							.getRoot();
					if (!groupSetName.equals("")) {
						treeModel.insertNodeInto(new DefaultMutableTreeNode(
								groupSetName), root, root.getChildCount());
						loadDatabase.updateDatabase(queryModel
								.getQueryCreateGroupSet(groupSetName));
					} else {
						treeModel.insertNodeInto(new DefaultMutableTreeNode(
								"New Group Set"), root, root.getChildCount());
						loadDatabase.updateDatabase(queryModel
								.getQueryCreateGroupSet("New Group Set"));
					}

					mapNumbered.addNumbered();
					treeMap.updateUI();
				}
			}
		});

		return miCreateGroupSet;
	}

	/**
	 * MenuItem rename Group Set
	 */
	public JMenuItem getMiRenameGroupSet(TreePath path) {
		JMenuItem miRenameGroupSet = new JMenuItem("Rename Group Set");

		miRenameGroupSet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mapNumbered.removeNumbered();
				String oldName = path.getLastPathComponent().toString();
				mapNumbered.addNumbered();
				String newName = JOptionPane.showInputDialog("New Name?",
						oldName);
				mapNumbered.removeNumbered();
				if (newName != null && !newName.equals("")) {
					((DefaultMutableTreeNode) path.getLastPathComponent())
							.setUserObject(newName);
					loadDatabase.updateDatabase(queryModel
							.getQueryRenameGroupSet(oldName, newName));
				}

				mapNumbered.addNumbered();
				treeMap.updateUI();
			}
		});

		return miRenameGroupSet;
	}

	/**
	 * MenuItem delete Group Set
	 */
	public JMenuItem getMiDeleteGroupSet(TreePath path) {
		JMenuItem miDeleteGroupSet = new JMenuItem("Delete Group Set");

		miDeleteGroupSet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mapNumbered.removeNumbered();
				String groupSetName = path.getLastPathComponent().toString();
				mapNumbered.addNumbered();
				if (JOptionPane.showConfirmDialog(null,
						"Do you want to DELETE group set '" + groupSetName
								+ "'?", null, JOptionPane.OK_CANCEL_OPTION) == 0) {
					mapNumbered.removeNumbered();
					loadDatabase.updateDatabase(queryModel
							.getQueryDeleteGroupSet(groupSetName));
					DefaultTreeModel model = (DefaultTreeModel) (treeMap
							.getModel());
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) (path
							.getLastPathComponent());
					model.removeNodeFromParent(node);

					mapNumbered.addNumbered();
				}
				treeMap.updateUI();
			}
		});

		return miDeleteGroupSet;
	}

	/**
	 * MenuItem create Group
	 */
	public JMenuItem getMiCreateGroup(TreePath path) {

		JMenuItem miCreateGroup = new JMenuItem("Create Group");

		miCreateGroup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String groupName = JOptionPane.showInputDialog("New Group?");
				if (groupName != null) {
					mapNumbered.removeNumbered();

					DefaultTreeModel treeModel = (DefaultTreeModel) treeMap
							.getModel();
					DefaultMutableTreeNode nodeGroupSet = (DefaultMutableTreeNode) path
							.getLastPathComponent();
					ResultSet rs = loadDatabase.convertDatabaseToResultSet(queryModel
							.getQueryGroupSetID(nodeGroupSet.toString()));
					String groupSetID = null;
					try {
						rs.next();
						groupSetID = rs.getString(1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (!groupName.equals("")) {
						treeModel.insertNodeInto(new DefaultMutableTreeNode(
								groupName), nodeGroupSet, nodeGroupSet
								.getChildCount());
						loadDatabase.updateDatabase(queryModel
								.getQueryCreateGroup(groupName, groupSetID));
					} else {
						treeModel.insertNodeInto(new DefaultMutableTreeNode(
								"New Group"), nodeGroupSet, nodeGroupSet
								.getChildCount());
						loadDatabase.updateDatabase(queryModel
								.getQueryCreateGroup("New Group", groupSetID));
					}

					mapNumbered.addNumbered();
					treeMap.updateUI();
				}
			}
		});

		return miCreateGroup;
	}

	/**
	 * MenuItem rename Group
	 */
	public JMenuItem getMiRenameGroup(TreePath path) {
		JMenuItem miRenameGroup = new JMenuItem("Rename Group");

		miRenameGroup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mapNumbered.removeNumbered();
				String oldName = path.getLastPathComponent().toString();
				mapNumbered.addNumbered();
				String newName = JOptionPane.showInputDialog("New Name?",
						oldName);
				mapNumbered.removeNumbered();
				if (newName != null && !newName.equals("")) {
					String groupSetName = path.getParentPath()
							.getLastPathComponent().toString();
					((DefaultMutableTreeNode) path.getLastPathComponent())
							.setUserObject(newName);
					loadDatabase.updateDatabase(queryModel.getQueryRenameGroup(
							groupSetName, oldName, newName));
				}
				mapNumbered.addNumbered();
				treeMap.updateUI();
			}
		});

		return miRenameGroup;
	}

	/**
	 * MenuItem delete Group
	 */
	public JMenuItem getMiDeleteGroup(TreePath path) {
		JMenuItem miDeleteGroup = new JMenuItem("Delete Group");

		miDeleteGroup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mapNumbered.removeNumbered();
				String groupName = path.getLastPathComponent().toString();
				mapNumbered.addNumbered();
				if (JOptionPane.showConfirmDialog(null,
						"Do you want to DELETE group '" + groupName + "'?",
						null, JOptionPane.OK_CANCEL_OPTION) == 0) {
					mapNumbered.removeNumbered();
					String groupSetName = path.getParentPath()
							.getLastPathComponent().toString();
					loadDatabase.updateDatabase(queryModel.getQueryDeleteGroup(
							groupSetName, groupName));
					DefaultTreeModel model = (DefaultTreeModel) (treeMap
							.getModel());
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) (path
							.getLastPathComponent());
					model.removeNodeFromParent(node);
					mapNumbered.addNumbered();
				}
				treeMap.updateUI();
			}
		});

		return miDeleteGroup;
	}

	/**
	 * MenuItem Empty Trash
	 */
	public JMenuItem getMiEmptyTrash() {
		JMenuItem miEmptyTrash = new JMenuItem("Empty Trash");

		miEmptyTrash.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				loadDatabase.updateDatabase(queryModel.getQueryEmptyTrash());
				treeMap.setSelectionRow(1);
				treeMap.setSelectionRow(2);

				treeMap.updateUI();
			}
		});

		return miEmptyTrash;
	}

	/**
	 * MenuItem Add References To A Group
	 */
	public JMenuItem getMiAddReferencesToGroup(String groupName,
			String groupSetName) {
		JMenuItem miAddReferencesToGroup = new JMenuItem("    " + groupName);

		miAddReferencesToGroup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResultSet rsGroupID = loadDatabase
						.convertDatabaseToResultSet(queryModel.getQueryGroupID(
								groupName, groupSetName));
				String groupID = null;
				try {
					rsGroupID.next();
					groupID = rsGroupID.getString(1);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				int[] selectedRows = tableCenter.getSelectedRows();
				String[] referenceID = new String[selectedRows.length];
				for (int i = 0; i < selectedRows.length; i++) {
					referenceID[i] = tableCenter.getValueAt(selectedRows[i], 0)
							.toString();
				}
				for (int i = 0; i < referenceID.length; i++) {
					loadDatabase.updateDatabase(queryModel
							.getQueryInsertToLabel(groupID, referenceID[i]));
				}
				mapNumbered.removeNumbered();
				mapNumbered.addNumbered();
				if (treeMap.getRowForPath(treeMap.getSelectionPath()) == 1) {
					treeMap.setSelectionRow(0);
					treeMap.setSelectionRow(1);
				}
				treeMap.updateUI();
			}
		});

		return miAddReferencesToGroup;
	}

	/**
	 * MenuItem Add References To A Group Set
	 */
	public JMenuItem getMiAddReferencesToGroupSet(String groupSetName) {
		JMenuItem miAddReferencesToGroup = new JMenuItem(groupSetName);

		miAddReferencesToGroup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResultSet rsGroupIDs = loadDatabase
						.convertDatabaseToResultSet(queryModel
								.getQueryGroupID(groupSetName));
				int[] selectedRows = tableCenter.getSelectedRows();
				String[] referenceID = new String[selectedRows.length];
				for (int i = 0; i < selectedRows.length; i++) {
					referenceID[i] = tableCenter.getValueAt(selectedRows[i], 0)
							.toString();
				}
				try {
					while (rsGroupIDs.next()) {
						for (int i = 0; i < referenceID.length; i++) {
							loadDatabase.updateDatabase(queryModel
									.getQueryInsertToLabel(
											rsGroupIDs.getString(1),
											referenceID[i]));
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mapNumbered.removeNumbered();
				mapNumbered.addNumbered();
				if (treeMap.getRowForPath(treeMap.getSelectionPath()) == 1) {
					treeMap.setSelectionRow(0);
					treeMap.setSelectionRow(1);
				}
				treeMap.updateUI();
			}
		});

		return miAddReferencesToGroup;
	}

	/**
	 * MenuItem Remove Refereces From A Group or A Group Set
	 */
	public JMenuItem getMiRemoveReferencesFromGroup() {
		JMenuItem miRemoveReferencesFromGroup = new JMenuItem(
				"Remove References From Group");

		miRemoveReferencesFromGroup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] selectedRows = tableCenter.getSelectedRows();
				String[] referenceID = new String[selectedRows.length];
				for (int i = 0; i < selectedRows.length; i++) {
					referenceID[i] = tableCenter.getValueAt(selectedRows[i], 0)
							.toString();
				}

				mapNumbered.removeNumbered();

				if (treeMap.getSelectionPath().getPathCount() == 3) {
					String groupName = treeMap.getSelectionPath()
							.getLastPathComponent().toString();
					String groupSetName = treeMap.getSelectionPath()
							.getParentPath().getLastPathComponent().toString();
					for (int i = 0; i < referenceID.length; i++) {
						loadDatabase.updateDatabase(queryModel
								.getQueryRemoveReferenceFromGroup(
										referenceID[i], groupName, groupSetName));
					}
				} else {
					String groupSetName = treeMap.getSelectionPath()
							.getLastPathComponent().toString();
					for (int i = 0; i < referenceID.length; i++) {
						loadDatabase.updateDatabase(queryModel
								.getQueryRemoveReferenceFromGroupSet(
										referenceID[i], groupSetName));
					}
				}

				mapNumbered.addNumbered();

				// update UI of treeMap and tableCenter
				TreePath selectedPath = treeMap.getSelectionPath();
				treeMap.removeSelectionPath(selectedPath);
				treeMap.setSelectionPath(selectedPath);
			}
		});

		return miRemoveReferencesFromGroup;
	}

	/**
	 * MenuItem Move Refereces to Trash
	 */
	public JMenuItem getMiMoveReferencesToTrash() {
		JMenuItem miMoveReferencesToTrash = new JMenuItem(
				"Move References to Trash");

		miMoveReferencesToTrash.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[] selectedRows = tableCenter.getSelectedRows();
				String[] referenceID = new String[selectedRows.length];
				for (int i = 0; i < selectedRows.length; i++) {
					referenceID[i] = tableCenter.getValueAt(selectedRows[i], 0)
							.toString();
				}
				for (int i = 0; i < referenceID.length; i++) {
					loadDatabase.updateDatabase(queryModel
							.getQueryMoveReferencesToTrash(referenceID[i]));
				}
				// update UI for treeMap and tableCenter
				TreePath selectedPath = treeMap.getSelectionPath();
				treeMap.removeSelectionPath(selectedPath);
				treeMap.setSelectionPath(selectedPath);
			}
		});

		return miMoveReferencesToTrash;
	}

	/**
	 * MenuItem Restore To Library
	 */
	public JMenuItem getMiRestoreToLibrary() {
		JMenuItem miRestoreToLibrary = new JMenuItem("Restore to Library");

		miRestoreToLibrary.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] selectedRows = tableCenter.getSelectedRows();
				String[] referenceID = new String[selectedRows.length];
				for (int i = 0; i < selectedRows.length; i++) {
					referenceID[i] = tableCenter.getValueAt(selectedRows[i], 0)
							.toString();
				}
				for (int i = 0; i < referenceID.length; i++) {
					loadDatabase.updateDatabase(queryModel
							.getQueryRestoreToLibrary(referenceID[i]));
				}
				// update UI for treeMap and tableCenter
				TreePath selectedPath = treeMap.getSelectionPath();
				treeMap.removeSelectionPath(selectedPath);
				treeMap.setSelectionPath(selectedPath);
			}
		});

		return miRestoreToLibrary;
	}

	/**
	 * MenuItem Delete Trash References
	 */
	public JMenuItem getMiDeleteTrashReferences() {
		JMenuItem miDeleteTrashReferences = new JMenuItem(
				"Delete Trash References");

		miDeleteTrashReferences.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] selectedRows = tableCenter.getSelectedRows();
				String[] referenceID = new String[selectedRows.length];
				for (int i = 0; i < referenceID.length; i++) {
					referenceID[i] = tableCenter.getValueAt(selectedRows[i], 0)
							.toString();
				}
				for (int i = 0; i < referenceID.length; i++) {
					loadDatabase.updateDatabase(queryModel
							.getQueryDeleteTrashReferences(referenceID[i]));
				}
				// update UI for treeMap and tableCenter
				TreePath selectedPath = treeMap.getSelectionPath();
				treeMap.removeSelectionPath(selectedPath);
				treeMap.setSelectionPath(selectedPath);
			}
		});

		return miDeleteTrashReferences;
	}
}

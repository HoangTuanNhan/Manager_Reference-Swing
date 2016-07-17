package services.controls;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import services.LoadDatabase;
import services.QueryModel;

/**
 * loading tree map from database
 */

public class LoadMap {

	JTree treeMap;
	LoadDatabase loadDatabase;
	QueryModel queryModel;

	public LoadMap(JTree treeMap, LoadDatabase loadDatabase, QueryModel queryModel) {
		this.treeMap = treeMap;
		this.loadDatabase = loadDatabase;
		this.queryModel = queryModel;
	}

	public void load() {
		// create the root node
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

		// add 3 node All References, Unfiled, Trash
		root.add(new DefaultMutableTreeNode("All References"));
		root.add(new DefaultMutableTreeNode("Unfiled"));
		root.add(new DefaultMutableTreeNode("Trash"));

		// add GroupSet, Group from DataBase to Map
		ResultSet rsGroupSet = loadDatabase.convertDatabaseToResultSet(queryModel.getQueryGroupSetName());
		try {
			while (rsGroupSet.next()) {
				String groupSetName = rsGroupSet.getString(1);
				DefaultMutableTreeNode groupSet = new DefaultMutableTreeNode(groupSetName);
				ResultSet rsGroup = loadDatabase.convertDatabaseToResultSet(queryModel.getQueryGroupName(groupSetName));
				while (rsGroup.next()) {
					DefaultMutableTreeNode group = new DefaultMutableTreeNode(rsGroup.getString(1));
					groupSet.add(group);
				}
				root.add(groupSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// create the tree by passing in the root node
		JTree treeMap = new JTree(root);
		this.treeMap.setModel(treeMap.getModel());
		
		// add treeMap Numbered
		new MapNumbered(treeMap, loadDatabase, queryModel).addNumbered();

		ImageIcon imageIcon = new ImageIcon("icon/icon_folder.png");
		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		renderer.setLeafIcon(imageIcon); // đặt Icon cho các node của treeMap
		this.treeMap.setCellRenderer(renderer);
		this.treeMap.setShowsRootHandles(true);
		this.treeMap.setRootVisible(false);
	}
}

package services.controls;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import services.LoadDatabase;
import services.QueryModel;

public class MapNumbered {

	JTree treeMap;
	LoadDatabase loadDatabase;
	QueryModel queryModel;

	public MapNumbered(JTree treeMap, LoadDatabase loadDatabase,
			QueryModel queryModel) {
		this.treeMap = treeMap;
		this.loadDatabase = loadDatabase;
		this.queryModel = queryModel;
	}

	/**
	 * đánh số tương ứng với số Reference vào cuối mỗi node của treeMap
	 */
	public void addNumbered() {
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeMap
				.getModel().getRoot();
		int nRootChild = root.getChildCount();
		for (int i = 0; i < nRootChild; i++) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) root
					.getChildAt(i);
			int nNode = node.getChildCount();
			for (int j = 0; j < nNode; j++) {
				DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node
						.getChildAt(j);
				childNode.setUserObject(addNumberGroup(childNode.toString(),
						node.toString()));
			}
			switch (i) {
			case 0: // node All References
				node.setUserObject(addNumberAllReference(node.toString()));
				break;
			case 1: // node Unfiled
				node.setUserObject(addNumberUnfiled(node.toString()));
				break;
			case 2: // node Trash
				node.setUserObject(addNumberTrash(node.toString()));
				break;
			default: // Groups Set nodes
				node.setUserObject(addNumberGroupSet(node.toString()));
				break;
			}
		}
	}

	/**
	 * xóa đánh số cuối mỗi node của treeMap
	 */
	public void removeNumbered() {
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeMap
				.getModel().getRoot();
		int nRootChild = root.getChildCount();
		for (int i = 0; i < nRootChild; i++) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) root
					.getChildAt(i);
			int nNode = node.getChildCount();
			for (int j = 0; j < nNode; j++) {
				DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node
						.getChildAt(j);
				childNode.setUserObject(removeNumbered(childNode.toString()));
			}
			node.setUserObject(removeNumbered(node.toString()));
		}
	}

	/*
	 * xóa đánh số sau mỗi chuỗi ví dụ "Quang Qilyt (8)" --> "Quang Qilyt"
	 */
	private String removeNumbered(String nodeName) {
		return nodeName.substring(0, nodeName.lastIndexOf(' '));
	}

	/*
	 * đánh số sau node All References ví dụ "All References" -->
	 * "All References (10)"
	 */
	private String addNumberAllReference(String nodeName) {
		return nodeName + " (" + getNumberAllReference() + ")";
	}

	/*
	 * đánh số sau node Unfiled ví dụ "Unfiled" --> "Unfiled (3)"
	 */
	private String addNumberUnfiled(String nodeName) {
		return nodeName + " (" + getNumberUnfiled() + ")";
	}

	/*
	 * đánh số sau node Trash ví dụ "Trash" --> "Trash (4)"
	 */
	private String addNumberTrash(String nodeName) {
		return nodeName + " (" + getNumberTrash() + ")";
	}

	/*
	 * đánh số sau mỗi Group node ví dụ "Novel" --> "Novel (6)"
	 */
	private String addNumberGroup(String groupName, String groupSetName) {
		return groupName + " (" + getNumberGroup(groupName, groupSetName) + ")";
	}

	/*
	 * đánh số sau mỗi Group Set node ví dụ "Quang Qilyt" --> "Quang Qilyt (6)"
	 */
	private String addNumberGroupSet(String groupSetName) {
		return groupSetName + " (" + getNumberGroupSet(groupSetName) + ")";
	}

	/*
	 * đếm số Reference thuộc node All References
	 */
	private String getNumberAllReference() {
		ResultSet rs = loadDatabase.convertDatabaseToResultSet(queryModel
				.getQueryAllReferenceCount());
		String str = null;
		try {
			rs.next();
			str = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	/*
	 * đếm số Reference thuộc node Unfiled
	 */
	private String getNumberUnfiled() {
		ResultSet rs = loadDatabase.convertDatabaseToResultSet(queryModel
				.getQueryUnfiledCount());
		String str = null;
		try {
			rs.next();
			str = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	/*
	 * đếm số Reference thuộc node Trash
	 */
	private String getNumberTrash() {
		ResultSet rs = loadDatabase.convertDatabaseToResultSet(queryModel
				.getQueryTrashCount());
		String str = null;
		try {
			rs.next();
			str = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	/*
	 * đếm số Reference thuộc node Group
	 */
	private String getNumberGroup(String groupName, String groupSetName) {
		ResultSet rs = loadDatabase.convertDatabaseToResultSet(queryModel
				.getQueryDataCountFromGroup(groupName, groupSetName));
		String str = null;
		try {
			rs.next();
			str = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	/*
	 * đếm số Reference thuộc node Group Set
	 */
	private String getNumberGroupSet(String groupSetName) {
		ResultSet rs = loadDatabase.convertDatabaseToResultSet(queryModel
				.getQueryDataCountFromGroupSet(groupSetName));
		String str = null;
		try {
			rs.next();
			str = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}

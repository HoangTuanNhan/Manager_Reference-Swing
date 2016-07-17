package services.controls;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JTree;

import services.LoadDatabase;
import services.QueryModel;

public class Menu {

	JTree treeMap;
	JTable tableCenter;
	LoadDatabase loadDatabase;
	QueryModel queryModel;
	MenuItem menuItem;

	public Menu(JTree treeMap, JTable tableCenter, LoadDatabase loadDatabase,
			QueryModel queryModel) {
		this.treeMap = treeMap;
		this.tableCenter = tableCenter;
		this.loadDatabase = loadDatabase;
		this.queryModel = queryModel;
		this.menuItem = new MenuItem(treeMap, tableCenter, loadDatabase,
				queryModel);
	}

	public JMenu getMenuAddReferencesTo() {
		JMenu menuAddReferencesTo = new JMenu("Add References To");

		// add GroupSet, Group from DataBase to Menu
		ResultSet rsGroupSet = loadDatabase
				.convertDatabaseToResultSet(queryModel.getQueryGroupSetName());
		try {
			while (rsGroupSet.next()) {
				String groupSetName = rsGroupSet.getString(1);
				menuAddReferencesTo.add(menuItem
						.getMiAddReferencesToGroupSet(groupSetName));

				ResultSet rsGroup = loadDatabase
						.convertDatabaseToResultSet(queryModel
								.getQueryGroupName(groupSetName));
				while (rsGroup.next()) {
					String groupName = rsGroup.getString(1);
					menuAddReferencesTo.add(menuItem.getMiAddReferencesToGroup(
							groupName, groupSetName));
				}
				menuAddReferencesTo.addSeparator();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menuAddReferencesTo;
	}
}

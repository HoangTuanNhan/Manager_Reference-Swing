package services.controls;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTree;

import services.LoadDatabase;
import services.QueryModel;

public class TablePopupMenu {

	JTree treeMap;
	JTable tableCenter;
	Menu menu;
	MenuItem menuItem;

	public TablePopupMenu(JTree treeMap, JTable tableCenter,
			LoadDatabase loadDatabase, QueryModel queryModel) {
		this.treeMap = treeMap;
		this.tableCenter = tableCenter;
		this.menu = new Menu(treeMap, tableCenter, loadDatabase, queryModel);
		this.menuItem = new MenuItem(treeMap, tableCenter, loadDatabase,
				queryModel);
	}

	public void add() {
		tableCenter.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					/*
					 * xác định các rows sẽ được chọn khi right-clicked lên
					 * tableCenter
					 */
					int currentRow = tableCenter.rowAtPoint(new Point(e.getX(),
							e.getY()));
					int[] selectedRows = tableCenter.getSelectedRows();
					boolean check = false; // xác định row mới right-clicked
											// thuộc các rows đã được chọn trước
											// đó không
					for (int i = 0; i < selectedRows.length; i++) {
						if (selectedRows[i] == currentRow) {
							check = true;
							break;
						}
					}
					if (!check) {
						tableCenter.setRowSelectionInterval(currentRow,
								currentRow);
					}

					switch (treeMap.getRowForPath(treeMap.getSelectionPath())) {
					case 0:
						tableCenter
								.setComponentPopupMenu(getPopupMenuAllReferences());
						break;
					case 1:
						tableCenter
								.setComponentPopupMenu(getPopupMenuUnfiled());
						break;
					case 2:
						tableCenter.setComponentPopupMenu(getPopupMenuTrash());
						break;
					default:
						tableCenter.setComponentPopupMenu(getPopupMenuGroup());
						break;
					}
				}
			}
		});
	}

	private JPopupMenu getPopupMenuAllReferences() {
		JPopupMenu popupMenuAllReferences = new JPopupMenu();

		popupMenuAllReferences.add(menu.getMenuAddReferencesTo());
		popupMenuAllReferences.addSeparator();

		popupMenuAllReferences.add(menuItem.getMiMoveReferencesToTrash());

		return popupMenuAllReferences;
	}

	private JPopupMenu getPopupMenuUnfiled() {
		JPopupMenu popupMenuUnfiled = new JPopupMenu();

		popupMenuUnfiled.add(menu.getMenuAddReferencesTo());
		popupMenuUnfiled.addSeparator();

		popupMenuUnfiled.add(menuItem.getMiMoveReferencesToTrash());

		return popupMenuUnfiled;
	}

	private JPopupMenu getPopupMenuTrash() {
		JPopupMenu popupMenuTrash = new JPopupMenu();

		popupMenuTrash.add(menuItem.getMiRestoreToLibrary());
		popupMenuTrash.addSeparator();
		popupMenuTrash.add(menuItem.getMiDeleteTrashReferences());

		return popupMenuTrash;
	}

	private JPopupMenu getPopupMenuGroup() {
		JPopupMenu popupMenuGroup = new JPopupMenu();

		popupMenuGroup.add(menu.getMenuAddReferencesTo());
		popupMenuGroup.addSeparator();

		popupMenuGroup.add(menuItem.getMiRemoveReferencesFromGroup());
		popupMenuGroup.addSeparator();

		popupMenuGroup.add(menuItem.getMiMoveReferencesToTrash());

		return popupMenuGroup;
	}
}

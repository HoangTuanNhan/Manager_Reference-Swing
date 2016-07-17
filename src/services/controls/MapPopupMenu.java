package services.controls;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.TreePath;

import services.LoadDatabase;
import services.QueryModel;

public class MapPopupMenu {

	JTree treeMap;
	MenuItem menuItem;

	public MapPopupMenu(JTree treeMap, LoadDatabase loadDatabase,
			QueryModel queryModel) {
		this.treeMap = treeMap;
		menuItem = new MenuItem(treeMap, loadDatabase, queryModel);
	}

	public void add() {
		treeMap.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					TreePath path = treeMap.getPathForLocation(e.getX(),
							e.getY());
					Rectangle pathBounds = treeMap.getUI().getPathBounds(
							treeMap, path);
					if (pathBounds != null) {
						treeMap.setSelectionPath(path);
						if (treeMap.getRowForPath(path) >= 3) {
							if (path.getPathCount() == 2) {
								getPopupMenuGroupSet(path).show(treeMap,
										e.getX(),
										pathBounds.y + pathBounds.height);
							} else if (path.getPathCount() == 3) {
								getPopupMenuGroup(path).show(treeMap, e.getX(),
										pathBounds.y + pathBounds.height);
							}
						} else if (treeMap.getRowForPath(path) == 2) {
							getPopupMenuTrash().show(treeMap, e.getX(),
									pathBounds.y + pathBounds.height);
						}
					} else {
						getPopupMenuOutSide().show(treeMap, e.getX(), e.getY());
					}
				}
			}
		});
	}

	/**
	 * popupMenu khi right-clicked vào Group Set
	 */
	private JPopupMenu getPopupMenuGroupSet(TreePath path) {

		JMenuItem miCreateGroupSet = menuItem.getMiCreateGroupSet();
		JMenuItem miCreateGroup = menuItem.getMiCreateGroup(path);
		JMenuItem miRenameGroupSet = menuItem.getMiRenameGroupSet(path);
		JMenuItem miDeleteGroupSet = menuItem.getMiDeleteGroupSet(path);

		JPopupMenu popupMenu = new JPopupMenu();

		popupMenu.add(miCreateGroupSet);
		popupMenu.addSeparator();

		popupMenu.add(miCreateGroup);
		popupMenu.addSeparator();

		popupMenu.add(miRenameGroupSet);
		popupMenu.add(miDeleteGroupSet);

		return popupMenu;
	}

	/**
	 * popupMenu khi right-clicked vào Group
	 */
	private JPopupMenu getPopupMenuGroup(TreePath path) {

		JMenuItem miCreateGroup = menuItem.getMiCreateGroup(path
				.getParentPath());
		JMenuItem miRenameGroup = menuItem.getMiRenameGroup(path);
		JMenuItem miDeleteGroup = menuItem.getMiDeleteGroup(path);

		JPopupMenu popupMenu = new JPopupMenu();

		popupMenu.add(miCreateGroup);
		popupMenu.addSeparator();

		popupMenu.add(miRenameGroup);
		popupMenu.add(miDeleteGroup);

		return popupMenu;
	}

	/**
	 * popupMenu khi right-clicked vào Trash
	 */
	private JPopupMenu getPopupMenuTrash() {

		JMenuItem miEmptyTrash = menuItem.getMiEmptyTrash();

		JPopupMenu popupMenu = new JPopupMenu();

		popupMenu.add(miEmptyTrash);

		return popupMenu;
	}

	/**
	 * popupMenu khi right-clicked ngoài node
	 */
	private JPopupMenu getPopupMenuOutSide() {

		JMenuItem miCreateGroupSet = menuItem.getMiCreateGroupSet();

		JPopupMenu popupMenu = new JPopupMenu();

		popupMenu.add(miCreateGroupSet);

		return popupMenu;
	}
}

package services.controls;

import gui.MainGUI;
import gui.MenuBar;
import gui.panesFunction.FrameNewReference;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JMenuItem;

import services.LoadDatabase;
import services.QueryModel;

public class MenuBarAction {

	private MainGUI mainFrame;
	private MenuBar menuBar;
	private LoadDatabase loadDatabase;
	private QueryModel queryModel;

	public MenuBarAction(MainGUI mainFrame, MenuBar menuBar,
			LoadDatabase loadDatabase, QueryModel queryModel) {
		this.mainFrame = mainFrame;
		this.menuBar = menuBar;
		this.loadDatabase = loadDatabase;
		this.queryModel = queryModel;
	}

	public void addMenuBarAction() {
		addMenuItemNewReferenceAction();
	}

	private void addMenuItemNewReferenceAction() {
		JMenuItem menuItemNewReference = menuBar.getItemNewReference();
		menuItemNewReference.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameNewReference frameNewReference = new FrameNewReference(
						mainFrame, loadDatabase, queryModel);
				frameNewReference.setVisible(true);
				mainFrame.setEnabled(false);
				frameNewReference.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						mainFrame.setEnabled(true);
					}
				});
			}
		});
	}
}

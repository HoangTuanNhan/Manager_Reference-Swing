package services.controls.toolbarAction;

import gui.MainGUI;
import gui.panesFunction.FrameNewReference;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

import services.LoadDatabase;
import services.QueryModel;

public class ButtonNewReferenceAction {

	MainGUI mainFrame;
	LoadDatabase loadDatabase;
	QueryModel queryModel;

	JButton buttonNewReferences;

	public ButtonNewReferenceAction(MainGUI mainFrame,
			LoadDatabase loadDatabase, QueryModel queryModel) {
		this.mainFrame = mainFrame;
		this.loadDatabase = loadDatabase;
		this.queryModel = queryModel;

		buttonNewReferences = mainFrame.getToolBar().getButtonNewReferences();
	}

	public void addAction() {
		buttonNewReferences.addActionListener(new ActionListener() {
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

package services.controls;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ComboxTypeSelection {

	JComboBox<String> comboBoxType;
	JPanel panelReferenceSelectedCenter;

	public ComboxTypeSelection(JComboBox<String> comboBoxType,
			JPanel panelReferenceSelectedCenter) {
		this.comboBoxType = comboBoxType;
		this.panelReferenceSelectedCenter = panelReferenceSelectedCenter;
	}

	public void update() {
		comboBoxType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panelReferenceSelectedCenter
						.getLayout();
				cardLayout.show(panelReferenceSelectedCenter, comboBoxType
						.getSelectedItem().toString());
			}
		});
	}
}

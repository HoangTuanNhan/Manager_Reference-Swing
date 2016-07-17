package services;

import gui.MainGUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

public class LoadDatabase {

	private Connection conn;

	public LoadDatabase(Connection conn) {
		this.conn = conn;
	}

	public DefaultTableModel convertDatabaseToTableModel(String query) {
		DefaultTableModel tableModel = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		try {
			Statement stt = conn.createStatement();
			ResultSet rs = stt.executeQuery(query);

			ResultSetMetaData metaData = rs.getMetaData();
			int numberColumns = metaData.getColumnCount();
			ArrayList<String> arrayColumns = new ArrayList<String>();
			for (int i = 1; i <= numberColumns; i++) {
				switch (metaData.getColumnName(i)) {
				case "ReferenceID":
					arrayColumns.add("ID");
					break;
				case "TypeName":
					arrayColumns.add("Type");
					break;
				case "PathAttach":
					arrayColumns.add("Path");
					break;
				case "ShortTitle":
					arrayColumns.add("Short Title");
					break;
				case "AccessionNumber":
					arrayColumns.add("Accession Number");
					break;
				case "CallNumber":
					arrayColumns.add("Call Number");
					break;
				case "AuthorAddress":
					arrayColumns.add("Author Address");
					break;
				default:
					arrayColumns.add(metaData.getColumnName(i));
					break;
				}
			}
			arrayColumns.add("");

			tableModel.setColumnIdentifiers(arrayColumns.toArray());

			ArrayList<String> arrayRows = new ArrayList<String>();
			while (rs.next()) {
				arrayRows.clear();
				for (int i = 1; i <= numberColumns; i++) {
					arrayRows.add(rs.getString(i));
				}
				tableModel.addRow(arrayRows.toArray());
			}

		} catch (SQLException ex) {
			Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		return tableModel;
	}

	public ResultSet convertDatabaseToResultSet(String query) {
		ResultSet rs = null;
		try {
			rs = conn.createStatement().executeQuery(query);
		} catch (SQLException ex) {
			Logger.getLogger(LoadDatabase.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return rs;
	}

	public void updateDatabase(String query) {
		try {
			conn.createStatement().executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
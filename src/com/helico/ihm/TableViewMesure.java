package com.helico.ihm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.helico.entities.Mesure;
import com.helico.entities.collection.Mesures;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewMesure {

	private TableView<Mesure> table = new TableView<Mesure>();
	
	public TableViewMesure( ) {	
		try {
			ObservableList<Mesure> liste = this.getMesures();
			
			TableColumn<Mesure, Float> t0Col = new TableColumn<Mesure, Float>("T0");
			//t0Col.setMinWidth(100);
			t0Col.setCellValueFactory(
	                new PropertyValueFactory<Mesure, Float>("t0"));
			
			TableColumn<Mesure, Float> ngCol = new TableColumn<Mesure, Float>("Ng");
			//t0Col.setMinWidth(100);
			ngCol.setCellValueFactory(
	                new PropertyValueFactory<Mesure, Float>("ng"));
			
			TableColumn<Mesure, Float> pwCol = new TableColumn<Mesure, Float>("PWSD");
			//t0Col.setMinWidth(100);
			pwCol.setCellValueFactory(
	                new PropertyValueFactory<Mesure, Float>("pw"));
			
	        table.setItems(liste);
	        table.getColumns().addAll(t0Col,ngCol,pwCol);
		    } catch(SQLException e) {
			e.printStackTrace();
		    }
	}
	
	public TableView<Mesure> getTable() {
		return this.table;
	}
	
	private ObservableList<Mesure> getMesures() throws SQLException {
		Mesure mesure = new Mesure(new Mesures());
		mesure.select(); // Pour récupérer la liste de toutes les mesures
		return mesure.getMesures().get(true);
	}
}

/**
 * 
 */
package com.helico.ihm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.helico.entities.Variante;
import com.helico.entities.collection.Variantes;

import javafx.scene.control.ComboBox;

/**
 * @author AELION
 *
 */
public class ComboVariante {

	private ComboBox<Variante> listeVariante = new ComboBox<Variante>();
	
	public ComboVariante() {
		try {
			ArrayList<Variante> liste = this.getVariantes();
			Iterator<Variante> it = liste.iterator();
			while(it.hasNext()) {
				this.listeVariante.getItems().add(it.next());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ComboBox<Variante> getCombo() {
		return this.listeVariante;
	}
	
	private ArrayList<Variante> getVariantes() throws SQLException {
		Variante variante = new Variante(new Variantes());
		variante.select(); // Pour récupérer la liste de toutes les variantes
		return variante.getVariantes().get();
	}
	
}

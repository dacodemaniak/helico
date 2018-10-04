/**
 * 
 */
package com.helico.ihm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.helico.entities.Variante;
import com.helico.entities.collection.Variantes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

/**
 * @author AELION
 *
 */
public class ComboVariante {

	private ComboBox<Variante> listeVariante = new ComboBox<Variante>();
	private int id; // Identifiant de la variante sélectionnée
	private ComboSeance cbSeance;
	
	public ComboVariante(ComboSeance cbSeance) {
		try {
			ArrayList<Variante> liste = this.getVariantes();
			Iterator<Variante> it = liste.iterator();
			while(it.hasNext()) {
				this.listeVariante.getItems().add(it.next());
			}
			this.listeVariante.setPromptText("Sélectionnez une variante");
			
			// Définition des handlers
			this._setEventHandlers();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ComboBox<Variante> getCombo() {
		return this.listeVariante;
	}
	
	/**
	 * Gestion des événements...
	 */
	private void _setEventHandlers() {
		ComboBox listeVariante = this.listeVariante;
		ComboVariante me = this; // Sauvegarder l'objet courant
        this.listeVariante.setOnAction(
        	new EventHandler<ActionEvent>()
        	{
        		@Override public void handle(ActionEvent e)
        		{
        			Variante variante = (Variante) listeVariante.getSelectionModel().selectedItemProperty().get();
        			ComboVariante.setId(variante.getId(), me);
        		}
        	}
        );

	}
	
	
	
	protected static void setId(int id, ComboVariante me) {
		// TODO Auto-generated method stub
		
		me.id = id;
		// Générer la Combo avec les séances
		System.out.println("Changement détecté : " + me.id);
		me.cbSeance.process();
		
	}

	private ArrayList<Variante> getVariantes() throws SQLException {
		Variante variante = new Variante(new Variantes());
		variante.select(); // Pour récupérer la liste de toutes les variantes
		return variante.getVariantes().get();
	}
	
}

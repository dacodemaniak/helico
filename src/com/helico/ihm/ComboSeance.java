/**
 * 
 */
package com.helico.ihm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.helico.entities.Seance;
import com.helico.entities.collection.Seances;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

/**
 * @author AELION
 *
 */
public class ComboSeance {

	private ComboBox<Seance> listeSeance = new ComboBox<Seance>();
	private int id; // Identifiant de la séance sélectionnée
	
	public ComboSeance() {
		this.listeSeance.setPromptText("Liste vide");
	}
	
	public void process() {
		try {
			ArrayList<Seance> liste = this.getSeances();
			Iterator<Seance> it = liste.iterator();
			while(it.hasNext()) {
				this.listeSeance.getItems().add(it.next());
			}
			
			
			// Définition des handlers
			this._setEventHandlers();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public ComboBox<Seance> getCombo() {
		return this.listeSeance;
	}
	
	/**
	 * Gestion des événements...
	 */
	private void _setEventHandlers() {
		ComboBox listeSeance = this.listeSeance;
		ComboSeance me = this; // Sauvegarder l'objet courant
        this.listeSeance.setOnAction(
        	new EventHandler<ActionEvent>()
        	{
        		@Override public void handle(ActionEvent e)
        		{
        			Seance seance = (Seance) listeSeance.getSelectionModel().selectedItemProperty().get();
        			ComboSeance.setId(seance.getId(), me);
        		}
        	}
        );

	}
	
	
	
	protected static void setId(int id, ComboSeance me) {
		// TODO Auto-generated method stub
		
		me.id = id;
		// Générer la Combo avec les séances
		System.out.println("Changement détecté : " + me.id);
	}

	private ArrayList<Seance> getSeances() throws SQLException {
		Seance seance = new Seance(new Seances());
		seance.select(this.id); // Pour récupérer la liste de toutes les séances pour cette variante
		return seance.getSeances().get();
	}
	
}

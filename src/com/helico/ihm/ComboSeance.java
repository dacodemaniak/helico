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
		this.listeSeance.setPromptText("Veuillez sélectionner un moteur avant");
		this.listeSeance.setLayoutX(50);
		this.listeSeance.setLayoutY(50);
	}
	
	public void process(int varianteId) {
		try {
			ArrayList<Seance> liste = this.getSeances(varianteId);
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
	 * Gestion des événements
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
		// Ici, filtrer le tableau des données
		System.out.println("Changement détecté : " + me.id);
	}

	private ArrayList<Seance> getSeances(int varianteId) throws SQLException {
		Seance seance = new Seance(new Seances());
		seance.select(varianteId); // Liste des séances pour cette variante
		return seance.getSeances().get();
	}
	
}

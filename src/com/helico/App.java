/**
 * 
 */
package com.helico;

import com.helico.ihm.ComboSeance;
import com.helico.ihm.ComboVariante;
import com.helico.entities.Seance;
import com.helico.entities.Variante;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author AELION
 *
 */
public class App extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Application.launch(App.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
	    Group racine = new Group();
	    Scene scene = new Scene(racine,800,600,Color.AZURE);

	    // Création du combo des séances
	    ComboSeance seances = new ComboSeance();
	    ComboBox<Seance> cbSeance = seances.getCombo();
	    
	    // Combo des variantes
	    ComboVariante variantes = new ComboVariante(seances);
	    ComboBox<Variante> cbVariante = variantes.getCombo();
	    
	    

	    
	    // Ajouter la bo�te combo � la sc�ne
	    racine.getChildren().add(cbVariante);
	    racine.getChildren().add(cbSeance);
	    
	    stage.setScene(scene);
	    
		stage.show();
	    
	}

}

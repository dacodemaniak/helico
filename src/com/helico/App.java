/**
 * 
 */
package com.helico;

import com.helico.ihm.ComboVariante;
import com.helico.entities.Variante;

import javafx.application.Application;
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
	    Button bouton = new Button();
	    bouton.setLayoutX(100);
	    bouton.setLayoutY(50);
	    bouton.setText("Variante");
	    
	    // Récupération du combo des variantes
	    ComboVariante variantes = new ComboVariante();
	    ComboBox<Variante> cbVariante = variantes.getCombo();
	    
	    // Ajouter la boîte combo à la scène
	    racine.getChildren().add(cbVariante);
	    racine.getChildren().add(bouton);
	    
	    stage.setScene(scene);
	    
		stage.show();
	    
	}

}

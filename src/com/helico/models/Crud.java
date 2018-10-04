/**
 * 
 */
package com.helico.models;

/**
 * @author AELION
 *
 */
public abstract class Crud {

	/**
	 * @return void
	 * Définit la méthode pour insérer des données
	 */
	abstract public void add();
	
	/**
	 * @return void
	 * Définit la méthode pour mettre à jour une donnée
	 */
	abstract public void update();
	
	/**
	 * @return void
	 * Définit la méthode pour supprimer des données
	 */
	abstract public void delete();
	
	abstract public void select();
}

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
	 * D�finit la m�thode pour ins�rer des donn�es
	 */
	abstract public void add();
	
	/**
	 * @return void
	 * D�finit la m�thode pour mettre � jour une donn�e
	 */
	abstract public void update();
	
	/**
	 * @return void
	 * D�finit la m�thode pour supprimer des donn�es
	 */
	abstract public void delete();
	
	abstract public void select();
}

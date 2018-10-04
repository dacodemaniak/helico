/**
 * 
 */
package com.helico.entities.collection;

import java.util.ArrayList;

import com.helico.entities.Variante;

/**
 * @author AELION
 *
 */
public class Variantes {
	private ArrayList<Variante> variantes = new ArrayList<Variante>();
	
	public void push(Variante variante) {
		this.variantes.add(variante);
	}
	
	public ArrayList<Variante> get() {
		return this.variantes;
	}
}

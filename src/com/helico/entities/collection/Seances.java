/**
 * 
 */
package com.helico.entities.collection;

import java.util.ArrayList;

import com.helico.entities.Seance;

/**
 * @author AELION
 *
 */
public class Seances {
	private ArrayList<Seance> seances = new ArrayList<Seance>();
	
	public void push(Seance seance) {
		this.seances.add(seance);
	}
	
	public ArrayList<Seance> get() {
		return this.seances;
	}
}

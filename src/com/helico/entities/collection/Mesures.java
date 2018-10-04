package com.helico.entities.collection;

import java.util.ArrayList;
import com.helico.entities.Mesure;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Mesures {

private ArrayList<Mesure> mesures = new ArrayList<Mesure>();
	
	public void push(Mesure mesure) {
		this.mesures.add(mesure);
	}
	
	public ArrayList<Mesure> get() {
		return this.mesures;
	}
	public ObservableList<Mesure> get(boolean booleanAsObservable) {
		return FXCollections.observableArrayList(this.mesures);
	}
}

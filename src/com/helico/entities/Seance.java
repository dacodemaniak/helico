package com.helico.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.helico.database.MysqlConnect;
import com.helico.entities.collection.Seances;
import com.helico.entities.collection.Variantes;
import com.helico.models.Crud;

public class Seance extends Crud implements com.helico.models.Seance {

	private Connection _cnx;
	
	private int id;
	
	private String date;
	private String code;
	private int variante_id;
	
	private Seances seances;
	
	public Seance(Seances seances) throws SQLException {
		// TODO Auto-generated constructor stub
		this._cnx = new MysqlConnect().getConnexion();
		this.seances = seances;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getVariante_id() {
		return variante_id;
	}
	public void setVariante_id(int variante_id) {
		this.variante_id = variante_id;
	}

	public Seances getSeances() {
		return this.seances;
	}
	@Override
	public void add() {
		// TODO Auto-generated method stub
          String sqlStatement = "INSERT INTO " + Seance.tableName + " (" + Seance._DATE + "," +  Seance._CODE + "," + Seance._VARIANTE_ID +") VALUES (?,?,?)";
		
		// Pr�paration de la requ�te
		try {
			PreparedStatement statement = this._cnx.prepareStatement(sqlStatement);
			statement.setString(1, this.date);
			statement.setString(2, this.code);
			statement.setInt(3, this.variante_id);
			
			// Ex�cuter la requ�te proprement dite
			statement.execute();
			
			// R�cup�re le dernier identifiant cr�� dans la table
			this.id = this._getLast();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
	}
	
	public void select(int varianteId) {
		String sqlStatement = "SELECT " + Seance._ID + "," + Seance._CODE + "," + Seance._DATE  + " FROM " + Seance.tableName + " WHERE " + Seance._VARIANTE_ID + " = ?";
		String ctrlSql = "SELECT " + Seance._ID + "," + Seance._CODE + "," + Seance._DATE  + " FROM " + Seance.tableName + " WHERE " + Seance._VARIANTE_ID + " = " + varianteId;
		// Préparation de la requête
		try {
			PreparedStatement statement = this._cnx.prepareStatement(sqlStatement);
			statement.setInt(1, varianteId);
			// Exécuter la requête proprement dit
			ResultSet results = statement.executeQuery();
			
			// Il reste à parcourir le résultat pour lire les données
			while(results.next()) {
				System.out.println(results.getInt(Seance._ID) + " | " + results.getString(Seance._DATE));
				Seance seance = new Seance(this.seances);
				seance.id = results.getInt(Seance._ID);
				seance.code = results.getString(Seance._CODE);
				seance.date = results.getString(Seance._DATE);
				this.seances.push(seance);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public String toString() {
		return this.code + " (" + this.date +")";
	}
	private int _getLast() {
		String sqlStatement = "SELECT " + Seance._ID  + " FROM " + Seance.tableName + " ORDER BY " + Seance._ID + " DESC LIMIT 0,1";
		
		// Préparation de la requête
		try {
			PreparedStatement statement = this._cnx.prepareStatement(sqlStatement);
			
			// Ex�cuter la requ�te proprement dite
			ResultSet results = statement.executeQuery();
			// Il reste � parcourir le r�sultat pour lire les donn�es
			results.next();
			return results.getInt(Seance._ID);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}			
	}

}

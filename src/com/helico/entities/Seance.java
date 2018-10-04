package com.helico.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.helico.database.MysqlConnect;
import com.helico.models.Crud;

public class Seance extends Crud implements com.helico.models.Seance {

	private Connection _cnx;
	
	private int id;
	
	private String date;
	private String code;
	private int variante_id;
	
	public Seance() throws SQLException {
		// TODO Auto-generated constructor stub
		this._cnx = new MysqlConnect().getConnexion();
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

	@Override
	public void add() {
		// TODO Auto-generated method stub
          String sqlStatement = "INSERT INTO " + Seance.tableName + " (" + Seance._DATE + "," +  Seance._CODE + "," + Seance._VARIANTE_ID +") VALUES (?,?,?)";
		
		// Préparation de la requête
		try {
			PreparedStatement statement = this._cnx.prepareStatement(sqlStatement);
			statement.setString(1, this.date);
			statement.setString(2, this.code);
			statement.setInt(3, this.variante_id);
			
			// Exécuter la requête proprement dite
			statement.execute();
			
			// Récupère le dernier identifiant créé dans la table
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
	
	private int _getLast() {
		String sqlStatement = "SELECT " + Seance._ID  + " FROM " + Seance.tableName + " ORDER BY " + Seance._ID + " DESC LIMIT 0,1";
		
		// Préparation de la requête
		try {
			PreparedStatement statement = this._cnx.prepareStatement(sqlStatement);
			
			// Exécuter la requête proprement dite
			ResultSet results = statement.executeQuery();
			// Il reste à parcourir le résultat pour lire les données
			results.next();
			return results.getInt(Seance._ID);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}			
	}

}

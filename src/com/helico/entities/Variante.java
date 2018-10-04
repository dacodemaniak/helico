/**
 * 
 */
package com.helico.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.helico.database.MysqlConnect;
import com.helico.entities.collection.Variantes;
import com.helico.models.Crud;
import com.helico.models.Model;

/**
 * @author AELION
 *
 */
public class Variante extends Crud implements com.helico.models.Variante {
	
	private Connection _cnx;
	
	private int id;
	private String serial;
	
	private Variantes variantes;
	
	public Variante( ) {}
	
	public Variante(Variantes variantes) throws SQLException {
		this._cnx = new MysqlConnect().getConnexion();
		this.variantes = variantes;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}
	
	public Variantes getVariantes() {
		return this.variantes;
	}

	@Override
	public void add() {
        String sqlStatement = "INSERT INTO " + Variante.tableName + " (" + Variante._SERIAL + ") VALUES (?)";
		
		// Préparation de la requête
		try {
			PreparedStatement statement = this._cnx.prepareStatement(sqlStatement);
			statement.setString(1, this.serial);
			
			// Exécuter la requête proprement dite
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void update() {}
	
	public void delete() {}
	
	public void select() {
		String sqlStatement = "SELECT " + Variante._ID + "," + Variante._SERIAL + "	FROM " + Variante.tableName;
		
		// Préparation de la requête
		try {
			PreparedStatement statement = this._cnx.prepareStatement(sqlStatement);
			// Exécuter la requête proprement dite
			ResultSet results = statement.executeQuery();
			int fetchSize = results.getFetchSize();
			// Il reste à parcourir le résultat pour lire les données
			while(results.next()) {
				System.out.println(results.getInt(Variante._ID) + " | " + results.getString(Variante._SERIAL));
				Variante variante = new Variante(this.variantes);
				variante.id = results.getInt(Variante._ID);
				variante.serial = results.getString(Variante._SERIAL);
				this.variantes.push(variante);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int selectBySerial(String serial) {
		String sqlStatement = "SELECT " + Variante._ID  + "	FROM " + Variante.tableName + " WHERE " + Variante._SERIAL + "= ?";
		
		// Préparation de la requête
		try {
			PreparedStatement statement = this._cnx.prepareStatement(sqlStatement);
			statement.setString(1, serial);
			// Exécuter la requête proprement dite
			ResultSet results = statement.executeQuery();
			// Il reste à parcourir le résultat pour lire les données
			results.next();
			return results.getInt(Variante._ID);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}		
	}

   public String toString() {
	   return this.serial;
	   }
	
	

}

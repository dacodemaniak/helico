package com.helico.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.helico.database.MysqlConnect;
import com.helico.models.Crud;


public class Mesure extends Crud implements com.helico.models.Mesure {

	private Connection _cnx;
	
	private int id;
	
	private float t0;
	private float ng;
	private float pw;
	private int seance_id;
	


	public Mesure() throws SQLException {
		// TODO Auto-generated constructor stub
		this._cnx = new MysqlConnect().getConnexion();
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getT0() {
		return t0;
	}

	public void setT0(float t0) {
		this.t0 = t0;
	}

	public float getNg() {
		return ng;
	}

	public void setNg(float ng) {
		this.ng = ng;
	}

	public float getPw() {
		return pw;
	}

	public void setPw(float pw) {
		this.pw = pw;
	}

	public int getSeance_id() {
		return seance_id;
	}


	public void setSeance_id(int seance_id) {
		this.seance_id = seance_id;
	}
	
	@Override
	public void add() {
		// TODO Auto-generated method stub
         String sqlStatement = "INSERT INTO " + Mesure.tableName + " (" + Mesure._T0 + "," +  Mesure._NG  + "," + Mesure._PW +  "," + Mesure._SEANCE_ID + ") VALUES (?,?,?,?)";
		
		// Préparation de la requête
		try {
			PreparedStatement statement = this._cnx.prepareStatement(sqlStatement);
			statement.setFloat(1, this.t0);
			statement.setFloat(2, this.ng);
			statement.setFloat(3, this.pw);
			statement.setFloat(4, this.seance_id);
			
			// Exécuter la requête proprement dite
			statement.execute();
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

}

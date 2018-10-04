package com.helico.database.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.helico.database.*;
public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		MysqlConnect cnx = new MysqlConnect();
		Connection mysql = cnx.getConnexion();
		
		if (mysql instanceof Connection) {
			System.out.print("Connexion au serveur mySQL okay");
		} else {
			System.out.print("Impossible de se connecter à la base de données");
		}
	}
}

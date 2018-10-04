/**
 * 
 */
package com.helico.database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Spécifique mySQL
 */
import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * @author AELION
 *
 */
public class MysqlConnect {
	public MysqlConnect() {}
	
	public Connection getConnexion() throws SQLException {
		return this.setDataSource().getConnection();
	}
	
	private MysqlDataSource setDataSource() throws SQLException {
		MysqlDataSource dataSource = new MysqlDataSource();
		
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/helico?useLegacyDatetimeCode=false&serverTimezone=Europe/Paris");
		dataSource.setUser("helico_dba");
		dataSource.setPassword("helico");
		dataSource.setServerName("127.0.0.1");
		dataSource.setPortNumber(3306);
		dataSource.setDatabaseName("helico");
		dataSource.setUseSSL(false);
		
		return dataSource;
	}
}

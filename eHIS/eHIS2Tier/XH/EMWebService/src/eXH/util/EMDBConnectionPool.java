package eXH.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EMDBConnectionPool {
	public static Connection getConnection() {

		Connection objConnection = null;
		try {
			//System.out.println("::: Inside EMDBConnectionPool getConnection :::");
			Context objInitialContext = new InitialContext();
			Context objServerContext = (Context) objInitialContext.lookup("java:/comp/env");
			DataSource objDataSource = (DataSource) objServerContext.lookup("jdbc/EMOracle");
			//System.out.println(objDataSource.toString());
			objConnection = objDataSource.getConnection();

		} catch (NamingException exObjNamingException) {
			System.out.println("Application Exception:Lookup Data Source:" + exObjNamingException.getMessage());
		} catch (SQLException exObjSQLException) {
			System.out.println("Application Exception:SQLException:" + exObjSQLException.getMessage());
		}
		return objConnection;
	}

}

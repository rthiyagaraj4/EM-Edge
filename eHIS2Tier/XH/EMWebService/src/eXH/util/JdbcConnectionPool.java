package eXH.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import eXH.util.DBConfiguration;
import java.sql.Connection;


public class JdbcConnectionPool {

	List<Connection> availableConnections = new ArrayList<Connection>();

	public JdbcConnectionPool()
	{
		initializeConnectionPool();
	}

	private void initializeConnectionPool()
	{
		while(!checkIfConnectionPoolIsFull())
		{
			availableConnections.add(createNewConnectionForPool());
		}
	}

	private synchronized boolean checkIfConnectionPoolIsFull()
	{
		final int MAX_POOL_SIZE = DBConfiguration.getInstance().DB_MAX_CONNECTIONS;

		if(availableConnections.size() < MAX_POOL_SIZE)
		{
			return false;
		}

		return true;
	}

	//Creating a connection
	private Connection createNewConnectionForPool()
	{
		DBConfiguration config = DBConfiguration.getInstance();
		try {
				Class.forName(config.DB_DRIVER);
				Connection connection = (Connection) DriverManager.getConnection(
						config.DB_URL, config.DB_USER_NAME, config.DB_PASSWORD);
				return connection;
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;

	}

	public synchronized Connection getConnectionFromPool()
	{
		Connection connection = null;
		if(availableConnections.size() > 0)
		{
			connection = (Connection) availableConnections.get(0);
			availableConnections.remove(0);
		}
		return connection;
	}

	public synchronized void returnConnectionToPool(Connection connection)
	{
		availableConnections.add(connection);
	}
}
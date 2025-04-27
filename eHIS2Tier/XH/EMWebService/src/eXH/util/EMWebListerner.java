package eXH.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class EMWebListerner implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("EMWebListerner.contextDestroyed:::::");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		String dbName = ConnectionManager.getDBDetails();
		//System.out.println("EMWebListerner.contextInitialized:::::");
		
	}

}

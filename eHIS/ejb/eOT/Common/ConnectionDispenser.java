/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.Common;

import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
public class ConnectionDispenser { 
 
	private static ThreadLocalConnection conn = new ThreadLocalConnection();
	
  private static class ThreadLocalConnection extends ThreadLocal {
	    public Object initialValue() {
      return ConnectionManager.getConnection();
    }
  }
  public static Connection getConnection() {
    return (Connection) conn.get();
  }

  public static void remove() {
	 Connection con = (Connection)conn.get();
	 try
	 {
			 if(con != null){
				//con.close();//Commented by Sanjay for connection dispenser issue on 5-Jul-11
				ConnectionManager.returnConnection(con);
				//added by Sanjay for connection dispenser issue on 5-Jul-11
			 }
	 }
	 catch (Exception ee)
	 {
		 ee.printStackTrace();
	 }

     conn.remove();
  }
}

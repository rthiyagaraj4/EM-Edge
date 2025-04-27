/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.HashMap;
import java.rmi.Naming;
import webbeans.eCommon.ConnectionManager;
import em.xh.remoteserver.*;

public class GatewayServiceBean
{ 
	public GatewayServiceBean()
	{
	}

	/**
	 * Returns list of all the configured gateway server machines which are enabled for the protocol link
	 */
	public static HashMap<String,String> getConfGatewayServers(String protocolLinkID)
	{
		HashMap<String,String> gatewayServerList = new HashMap<String,String>();
		Connection dbConn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String qry = "SELECT a.client_id,c.inbound_ip_address,c.client_name FROM xh_comm_client_application a,xh_comm_client c "
					+ " WHERE a.protocol_link = '" + protocolLinkID + "' AND a.in_use_yn = 'Y' AND a.client_id = c.client_id ORDER BY c.client_name";
		try
		{
			dbConn = ConnectionManager.getConnection();
			stmt = dbConn.createStatement();
			rs = stmt.executeQuery(qry);			

			while(rs.next())
			{
				//using ip address of gateway remote server, as using client id(machine host name) will not be recognized from linux machines
				gatewayServerList.put(rs.getString("inbound_ip_address"), rs.getString("client_name"));
			}
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(rs, stmt, dbConn);
		}
		return gatewayServerList;
	}

	public String updateCommProcess(int procID,String facilityID,String clientID,String appID,String commType,String protocolLinkID)
	{
		String flag = null;		
		CallableStatement ostmt = null;
		Connection dbConn = null;

		try
		{
			dbConn = ConnectionManager.getConnection();
			ostmt = dbConn.prepareCall("{ call xhcore.INSERT_COMM_PROCESS(?,?,?,?,?,?,?) }" );
			ostmt.setInt(1,procID);
			ostmt.setString(2,facilityID);
			ostmt.setString(3,clientID);
			ostmt.setString(4,appID);
			ostmt.setString(5,commType);
			ostmt.setString(6,protocolLinkID);
			ostmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			ostmt.execute();
			flag = ostmt.getString(7);
			System.out.println("(GatewayServiceBean:updateCommProcess) Flag "+flag);
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(null, ostmt, dbConn);
		}
		return flag;	
	}
}

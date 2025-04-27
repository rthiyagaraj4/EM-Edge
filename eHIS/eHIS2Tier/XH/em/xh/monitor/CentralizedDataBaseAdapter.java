package em.xh.monitor;

import java.util.Vector;
import java.util.HashMap;
import java.sql.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.regex.*;
import oracle.sql.*;
import oracle.jdbc.driver.*;

import HL7Engine.Common.*;
import em.xh.remoteserver.CentralizedRemote;

//Class to hanadle the databse operations 

public class CentralizedDataBaseAdapter 
{
	Connection connection;
    Statement statement;
    ResultSet resultSet;
    String[] columnNames = {};
    Vector rows = new Vector();
    Object resultarray[][] = null;
	ArrayList arrlistvar = null;

	static String inboundArray[][] = null;
	static String outboundArray[][] = null;
	static String dburl = null;
	static String usrname = null;
	static String password = null;	
	static String communicationType = null;
	static String dbConnectionExcetion = null;

	static boolean connectionflag = false;

	CentralizedWriteLog write = null;
	String filename = null;
	static String EMPTY_STRING = "";

	public CentralizedDataBaseAdapter(String dburl,String usrname,String password,CentralizedWriteLog write) 
	{
		try 
		{   
			this.dburl = dburl;
			this.usrname = usrname;
			this.password = password;
			this.write = write;
			this.filename = write.filename;

			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		//	Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@"+dburl,usrname,password);

			setMedUserRole();
			connectionflag=true;
		}
		catch(SQLException ex) 
		{
			connectionflag = false;
			write.fileOutput(filename," (CentralizedDataBaseAdapter:constructor) Exception :"+ex.toString()+"\n");

			dbConnectionExcetion = CommonUtil.getDBError(ex.getMessage());			
		}
     }	

	private void setMedUserRole()
	{	
		try
		{
			String strParamRole = "";
			String strProcedureName = "{call DBMS_SESSION.SET_ROLE(?)"+"}";
			Statement stmt = null; 
			String strQry = "SELECT APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) FROM SM_ORA_ROLE  Where ORA_ROLE_ID = 'MEDUSERS'";
			CallableStatement call = null;
			ResultSet rset = null;
			String strPasswd = "";
			try
			{
				stmt = connection.createStatement();
				rset = stmt.executeQuery(strQry);

				while (rset.next())
				{
					strPasswd = rset.getString(1);
				}
			}
			catch(Exception expSql)
			{
				write.fileOutput(filename," (CentralizedDataBaseAdapter:setMedUserRole) Exception: " + expSql.toString() + "\n");				
			}
			finally
			{
				try
				{
					if(rset != null) rset.close();
					if(stmt != null) stmt.close();
				}
				catch(Exception e){ }
			}
			if(strPasswd != null && !strPasswd.equals("")) 
			{				
				strParamRole = "MEDUSERS IDENTIFIED BY "+strPasswd;
			}
			else 
			{				
				strParamRole = "MEDUSERS";
			}
			call = connection.prepareCall(strProcedureName);
			call.setString(1,strParamRole);			
			call.execute();
			call.close();
		}
		catch(Exception expCal)
		{
			expCal.printStackTrace();
			write.fileOutput(filename," (CentralizedDataBaseAdapter:setMedUserRole xx) Exception :"+expCal.toString()+"\n");
		}
	}
   
/*	private void setMedUserRole()
	{	
		try
		{
			String strParamRole = "";
			String oraRoleQry = "";
			String strQry = "SELECT APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) FROM SM_ORA_ROLE Where ORA_ROLE_ID = 'MEDUSERS'";
			String strPasswd = "";

			Statement stmt = null;
			ResultSet rset = null;
			PreparedStatement pstmt = null;
			
			try
			{
				stmt = connection.createStatement();
				rset = stmt.executeQuery(strQry);

				while (rset.next())
				{
					strPasswd = rset.getString(1);
				}
			}
			catch(Exception expSql)
			{
				write.fileOutput(filename," (CentralizedDataBaseAdapter:setMedUserRole) Exception: " + expSql.toString() + "\n");				
			}
			finally
			{
				try
				{
					if(rset != null) rset.close();
					if(stmt != null) stmt.close();
				}
				catch(Exception e){ }
			}
			if(strPasswd != null && !strPasswd.equals("")) 
			{
				System.out.println("Password "+strPasswd);
				oraRoleQry = "Set Role MEDUSERS identified by "+strPasswd;
			}
			else 
			{
				System.out.println("Password1 "+strPasswd);
				oraRoleQry = "Set Role MEDUSERS";
			}
			pstmt = connection.prepareStatement(oraRoleQry);
			pstmt.execute();
			pstmt.close();
		}
		catch(Exception expCal)
		{
			expCal.printStackTrace();
			write.fileOutput(filename," (CentralizedDataBaseAdapter:setMedUserRole xx) Exception :"+expCal.toString()+"\n");
		}
	}
*/
	public String[][] getClientRecords()
	{
		String clientArray[][] = null;		
		try
		{
			String clientsql = "SELECT DISTINCT CLIENT_ID,CLIENT_NAME FROM XH_COMM_CLIENT WHERE IN_USE_YN='Y'";
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
			ResultSet clientresultset = statement.executeQuery(clientsql);
			clientresultset.last();
			clientArray = new String[clientresultset.getRow()+1][2];
			clientresultset.beforeFirst();
			clientArray[0][0] = "";
			clientArray[0][1] = "All";
			int row = 1;
			while(clientresultset.next())
			{
				clientArray[row][0] = clientresultset.getString(1);
				clientArray[row][1] = clientresultset.getString(2);
				row++;
			}
			if(clientresultset != null) clientresultset.close();								 
			if(statement != null) statement.close();
		}
		catch(SQLException exception)
		{
			System.out.println("Exception occured at [CentralizedDataBaseAdapter:getClientRecords] : "+exception.toString());
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getClientRecords) Exception :"+exception.toString()+"\n");
		}
		catch(Exception exceptionConnection)
		{	
			System.out.println("Exception occured at [CentralizedDataBaseAdapter:getClientRecords] : "+exceptionConnection.toString());
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getClientRecords) Exception :"+exceptionConnection.toString()+"\n");
		}
		return clientArray;	
	}

  public String[][] getApplicationRecords()
	{
		String applArray[][]=null;		
		try
		{
		    String applnsql="SELECT DISTINCT APPLICATION_ID,APPLICATION_NAME FROM XH_APPLICATION  WHERE IN_USE_YN='Y'";
			statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
			ResultSet applnrs=statement.executeQuery(applnsql);
			applnrs.last();
		    applArray=new String[applnrs.getRow()+1][2];
			applnrs.beforeFirst();
			applArray[0][0]="";
			applArray[0][1]="All";
			int row=1;
			while(applnrs.next())
            {
             applArray[row][0]=applnrs.getString(1);
			 applArray[row][1]=applnrs.getString(2);
			 row++;
			}
			if(applnrs!=null) applnrs.close();
		    if(statement!=null) statement.close();
		}
		catch(SQLException exception)
		{
			System.out.println("Exception occured at [CentralizedDataBaseAdapter:getApplicationRecords] : "+exception.toString());
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getApplicationRecords) Exception :"+exception.toString()+"\n");
		}
		catch(Exception exceptionConnection)
		{
			System.out.println("Exception occured at [CentralizedDataBaseAdapter:getApplicationRecords] : "+exceptionConnection.toString());
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getApplicationRecords) Exception :"+exceptionConnection.toString()+"\n");
	    }
		return 	applArray;	
	}	

	public String[][] getFacilityRecords()
	{
		String facilityArray[][] = null;		
		try
		{
			String facilitysql = "SELECT DISTINCT A.FACILITY_ID, s.facility_name FROM XH_PARAM_FOR_FACILITY a, sm_facility_param s  WHERE  a.facility_id  =  s.facility_id ";
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
			ResultSet facilityrs = statement.executeQuery(facilitysql);
			facilityrs.last();
			facilityArray = new String[facilityrs.getRow()+1][2];
			facilityrs.beforeFirst();
			int row = 1;
			facilityArray[0][0] = "";
			facilityArray[0][1] = "All";
			while(facilityrs.next())
			{
				facilityArray[row][0] = facilityrs.getString(1);
				facilityArray[row][1] = facilityrs.getString(2);
				row++;
			}
			if(facilityrs != null) facilityrs.close();
			if(statement != null) statement.close();
		}
		catch(SQLException exception)
		{
			System.out.println("Exception occured at [CentralizedDataBaseAdapter:getFacilityRecords] : "+exception.toString());
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getFacilityRecords) Exception :"+exception.toString()+"\n");
		}
		catch(Exception exceptionConnection)
		{
			System.out.println("Exception occured at [CentralizedDataBaseAdapter:getFacilityRecords] : "+exceptionConnection.toString());
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getFacilityRecords) Exception :"+exceptionConnection.toString()+"\n");
		}
		return 	facilityArray;	
	}	

	public Object[][] executeQuery(String sqlquery,String commtype) 
	{	  
		// arrlistvar=new ArrayList();
		ResultSet queryresult = null;
		Statement stmt = null;
		try
		{
			stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
			write.fileOutput(filename," (CentralizedDataBaseAdapter:executeQuery) Query :"+sqlquery+"\n");
			queryresult = stmt.executeQuery(sqlquery);

			queryresult.last();
			resultarray = new Object[queryresult.getRow()][14];

			if(commtype.equalsIgnoreCase("O")) outboundArray = new String[queryresult.getRow()][5];
			if(commtype.equalsIgnoreCase("I")) inboundArray = new String[queryresult.getRow()][5];

			queryresult.beforeFirst();
			int row = 0;

			while(queryresult.next())
			{ 		 													
				resultarray[row][0] = Boolean.FALSE; 
				resultarray[row][1] = Color.BLACK;		

				if(commtype.equalsIgnoreCase("O"))
				{ 
					outboundArray[row][0] = checkNull(queryresult.getString(1));											
					outboundArray[row][1] = checkNull(queryresult.getString(3));				
					outboundArray[row][2] = checkNull("XX");
					outboundArray[row][3] = "O";
					outboundArray[row][4] = checkNull(queryresult.getString(11));
					communicationType = "O";
				}				

				if(commtype.equalsIgnoreCase("I"))
				{ 
					inboundArray[row][0] = checkNull(queryresult.getString(1));				
					inboundArray[row][1] = checkNull(queryresult.getString(3));
					inboundArray[row][2] = checkNull("XX");
					inboundArray[row][3] = "I";
					inboundArray[row][4] = checkNull(queryresult.getString(11));
					communicationType = "I";
				}

				resultarray[row][3]  = checkNull(queryresult.getString(2)); // Client Name			
				resultarray[row][4]  = checkNull(queryresult.getString(4)); // Application Name
				resultarray[row][2]  = checkNull(queryresult.getString(5)); // Process ID
				resultarray[row][11] = checkNull(queryresult.getString(7)); // Start Date Time
				resultarray[row][12] = checkNull(queryresult.getString(8)); // Started By ID
				resultarray[row][13] = checkNull(queryresult.getString(9)); // Stop Date Time
				resultarray[row][6]  = checkNull(queryresult.getString(10)); // Retries
				resultarray[row][5]  = checkNull(queryresult.getString(11)); // Protocol Link

				String protocolType = checkNull(queryresult.getString(12)); // Protocol Type	
				
				if(protocolType.equalsIgnoreCase("T"))
				{  
					resultarray[row][10] = "TCP/IP"; 
				}
				else if(protocolType.equalsIgnoreCase("F"))
				{
					resultarray[row][10] = "File";
				}
				else if(protocolType.equalsIgnoreCase("R"))
				{
					resultarray[row][10] = "RS232";
				}
				else if(protocolType.equalsIgnoreCase("X"))
				{
					resultarray[row][10] = "Fax";
				}
				else if(protocolType.equalsIgnoreCase("M"))
				{
					resultarray[row][10] = "Mail";
				}
				else if(protocolType.equalsIgnoreCase("S"))
				{
					resultarray[row][10] = "SMS";
				}
				else if(protocolType.equalsIgnoreCase("D"))
				{
					resultarray[row][10] = "ODBC";
				}
				else if(protocolType.equalsIgnoreCase("OT"))
				{
					resultarray[row][10] = "ORACLE_TABLE";
				}
				else if(protocolType == null || protocolType.equals("") || protocolType.equals(" "))
				{
					resultarray[row][10] = " ";
				}
				else
				{
					resultarray[row][10] = " ";
				}

				resultarray[row][7] = checkNull(queryresult.getString(13)); // Last Comm Date Time
				resultarray[row][8] = checkNull(queryresult.getString(14)); // Last Msg ID
				resultarray[row][9] = checkNull(queryresult.getString(15)); // Total Messages
				row++;

				//System.out.println("subarrlistvar :"+subarrlistvar.size());
				//arrlistvar.add(subarrlistvar);
				//System.out.println("arrlistvar :"+arrlistvar.size());						
			}			
		} 
		catch (SQLException ex) 
		{
			write.fileOutput(filename," (CentralizedDataBaseAdapter:executeQuery) Exception :"+ex.toString()+"\n");
			System.err.println(ex);
			ex.printStackTrace(System.err); 
		} 
		catch (Exception ex) 
		{ 
			write.fileOutput(filename," (CentralizedDataBaseAdapter:executeQuery) Exception :"+ex.toString()+"\n");
			System.err.println(ex);
			ex.printStackTrace(System.err); 
		}
		finally
		{
			try
			{
				if(queryresult != null) queryresult.close();
				if(stmt != null) stmt.close();
			}
			catch (Exception exp){}			
		}

		return resultarray;
	}

	public Object[][] executeQueryWithRemoteStatus(String sqlquery,String commtype,String servicemode)
	{   		 			
		try 
		{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);		
			ResultSet queryresult = statement.executeQuery(sqlquery);
			queryresult.last();		

			resultarray = new Object[queryresult.getRow()][15];
			if(commtype.equalsIgnoreCase("O")) outboundArray = new String[queryresult.getRow()][5];
			if(commtype.equalsIgnoreCase("I")) inboundArray = new String[queryresult.getRow()][5];			

			queryresult.beforeFirst();
			int row = 0;			

			while(queryresult.next())
			{ 							
				String status = "";
					
			/*	
				String processid = checkNull(queryresult.getString(5));
				String clientid = checkNull(queryresult.getString(1));
				String applicationid = checkNull(queryresult.getString(3));			
				String facilityid = "XX";

				System.out.println("processid :   "+processid);
				System.out.println("clientid :   "+clientid);
				System.out.println("applicationid :   "+applicationid);
				System.out.println("facilityid :   "+facilityid); 				

				HashMap map = null;
				Boolean install = null;
				Boolean start = null;
				Boolean stop = null;
				String status = "";
				String ipaddress = "";

				if(commtype.equalsIgnoreCase("O"))
				{
					ipaddress = getIpAddress(applicationid,clientid,"O");				
				}
				if(commtype.equalsIgnoreCase("I"))
				{
					ipaddress = getIpAddress(applicationid,clientid,"I");			
				}

				remoteObject = (CentralizedRemote)remote.remoteObject(ipaddress);
				 
				if(remoteObject != null)
				{	
					write.fileOutput(filename," (CentralizedDataBaseAdapter:executeQueryWithRemoteStatus) Remote Object \n");
					resultarray[row][0] = Boolean.FALSE; 
					resultarray[row][1] = new Color(255, 175, 175);					
					status = checkNull(queryresult.getString(6));					  				
					
					if(servicemode.equalsIgnoreCase("With Service"))
					{
						map = remoteObject.chkServiceStatus(applicationid,facilityid,processid);
						if(map != null)
						{
							install = (Boolean)map.get("install");
							start = (Boolean)map.get("start");
							stop = (Boolean)map.get("stop");

							System.out.println("install :"+install);
							System.out.println("start :"+start);
							System.out.println("stop :"+stop);
						
							if((start.toString().equals("true")) && (status.equals("A"))) resultarray[row][1] = new Color(0, 255, 0);
							else if((start.toString().equals("true")) && (status.equals("W"))) resultarray[row][1] = new Color(255, 255, 0);
							else if((install.toString().equals("false")) && (status.equals("W"))) resultarray[row][1] = new Color(255, 255, 0);
							else if((stop.toString().equals("true")) && (status.equals("S"))) resultarray[row][1] = new Color(255, 0, 0);
							else if((stop.toString().equals("true")) && (status.equals("C"))) resultarray[row][1] = new Color(255, 0, 0);
							else if((install.toString().equals("true")) && (status.equals("C"))) resultarray[row][1] = new Color(0, 0, 255);
							else if((install.toString().equals("true")) && (status.equals("S"))) resultarray[row][1] = new Color(255, 0, 0);
						}
					}
					else if(servicemode.equalsIgnoreCase("Without Service"))
					{	
						write.fileOutput(filename," (CentralizedDataBaseAdapter:executeQueryWithRemoteStatus) status :"+status+"\n");
						if(status.equals("A")) resultarray[row][1] = new Color(0, 255, 0); //	Green
						if(status.equals("W")) resultarray[row][1] = new Color(255, 255, 0); // Yellow
						if(status.equals("S")) resultarray[row][1] = new Color(255, 0, 0); //	Red
						if(status.equals("C")) resultarray[row][1] = new Color(0, 0, 255); // Blue
					}					 
				}
				else 
				{		
					//System.out.println("else :");
					resultarray[row][0] = new Boolean(false); 
					resultarray[row][1] = new Color(0,0,0);
				}
			*/								

				if(commtype.equalsIgnoreCase("O"))
				{ 
					outboundArray[row][0] = checkNull(queryresult.getString(1));											
					outboundArray[row][1] = checkNull(queryresult.getString(3));				
					outboundArray[row][2] = checkNull("XX");
					outboundArray[row][3] = "O";
					outboundArray[row][4] = checkNull(queryresult.getString(11));
					communicationType = "O";
				}				
				else if(commtype.equalsIgnoreCase("I"))
				{ 
					inboundArray[row][0] = checkNull(queryresult.getString(1));				
					inboundArray[row][1] = checkNull(queryresult.getString(3));
					inboundArray[row][2] = checkNull("XX");
					inboundArray[row][3] = "I";
					inboundArray[row][4] = checkNull(queryresult.getString(11));
					communicationType = "I";										
				}

				status = checkNull(queryresult.getString(6));
				String commStatus = checkNull(queryresult.getString(16));
				
				resultarray[row][0] = Boolean.FALSE;				

				if("A".equals(status)) resultarray[row][1] = Color.GREEN;
				else if("W".equals(status)) resultarray[row][1] = Color.YELLOW;
				else if("S".equals(status)) resultarray[row][1] = Color.RED;
				else if("C".equals(status)) resultarray[row][1] = Color.BLUE;
				else if("P".equals(status)) resultarray[row][1] = new Color(000, 255, 255);
				else resultarray[row][1] = Color.pink;

				if("Y".equals(commStatus)) resultarray[row][2] = Color.GREEN;
				else if("N".equals(commStatus)) resultarray[row][2] = Color.RED;
				else resultarray[row][2] = Color.PINK;

				resultarray[row][4]  = checkNull(queryresult.getString(2));  // Client Name
				resultarray[row][5]  = checkNull(queryresult.getString(4));  // Application Name
				resultarray[row][3]  = checkNull(queryresult.getString(5));  // Process ID
				resultarray[row][12] = checkNull(queryresult.getString(7));  // Start Date Time
				resultarray[row][13] = checkNull(queryresult.getString(8));  // Started By ID
				resultarray[row][14] = checkNull(queryresult.getString(9));  // Stop Date Time
				resultarray[row][7]  = checkNull(queryresult.getString(10)); // Retries
				resultarray[row][6]  = checkNull(queryresult.getString(11)); // Protocol Link ID
				resultarray[row][11] = checkNull(queryresult.getString(12)); // Protocol Type
				resultarray[row][8]  = checkNull(queryresult.getString(13)); // Last Comm Date Time
				resultarray[row][9]  = checkNull(queryresult.getString(14)); // Last Msg ID
				resultarray[row][10] = checkNull(queryresult.getString(15)); // Total Messages				

				String protocolType = checkNull(queryresult.getString(12));						
				if(protocolType.equalsIgnoreCase("T"))
				{  
					resultarray[row][11] = "TCP/IP";
				}
				else if(protocolType.equalsIgnoreCase("F"))
				{
					resultarray[row][11] = "File";
				}
				else if(protocolType.equalsIgnoreCase("R"))
				{
					resultarray[row][11] = "RS232";
				}
				else if(protocolType.equalsIgnoreCase("X"))
				{
					resultarray[row][11] = "Fax";
				}
				else if(protocolType.equalsIgnoreCase("M"))
				{
					resultarray[row][11] = "Mail";
				}
				else if(protocolType.equalsIgnoreCase("S"))
				{
					resultarray[row][11] = "SMS";
				}
				else if(protocolType.equalsIgnoreCase("D"))
				{
					resultarray[row][11]= "ODBC";
				}
				else if(protocolType.equalsIgnoreCase("OT"))
				{
					resultarray[row][11] = "ORACLE_TABLE";
				}
				else if(protocolType == null || protocolType.equals("") || protocolType.equals(" "))
				{
					resultarray[row][11] = " ";
				}
				else
				{
					resultarray[row][11] = " ";
				}

				row++;
			}
			if(queryresult != null) queryresult.close();
		} 
		catch (SQLException ex) 
		{
			System.out.println(ex);
			ex.printStackTrace(); 
			write.fileOutput(filename," (CentralizedDataBaseAdapter:executeQueryWithRemoteStatus) Exception :"+ex.toString()+"\n");
		} 
		catch (Exception ex) 
		{ 
			System.out.println(ex);
			ex.printStackTrace();
			write.fileOutput(filename," (CentralizedDataBaseAdapter:executeQueryWithRemoteStatus) Exception :"+ex.toString()+"\n");
		}
		return resultarray;
	}	 

	public String getIpAddress(String appicationid, String clientid, String mode)
	{	
		String ipaddress = null;		
		try
		{	
			String rssql = null;
			if(mode.equalsIgnoreCase("O"))
			{
				// modified query to get the machine name instead of IPAddress
				//rssql="SELECT CLIENT_ID FROM XH_COMM_CLIENT A,XH_COMM_CLIENT_APPLICATION B WHERE B.APPLICATION_ID='"+appicationid+"' AND B.CLIENT_ID='"+clientid+"' AND A.CLIENT_ID=B.CLIENT_ID AND B.COMM_TYPE='O' AND B.IN_USE_YN='Y'";
				//temporary query has to be delete
				rssql = "SELECT client_id FROM xh_comm_client WHERE client_id = '" + clientid + "'";	
			}
			if(mode.equalsIgnoreCase("I"))
			{
				// rssql="SELECT INBOUND_IP_ADDRESS FROM XH_COMM_CLIENT A,XH_COMM_CLIENT_APPLICATION B WHERE B.APPLICATION_ID='"+appicationid+"' AND B.CLIENT_ID='"+clientid+"' AND A.CLIENT_ID=B.CLIENT_ID AND B.COMM_TYPE='I' AND B.IN_USE_YN='Y'";
				rssql = "SELECT client_id FROM xh_comm_client WHERE client_id = '" + clientid + "'";
			}			
			statement=connection.createStatement();
			ResultSet rs=statement.executeQuery(rssql);			
			while(rs.next())
			{
				ipaddress=rs.getString(1);
			}
			if(rs != null) rs.close();
			if(statement != null) statement.close();
		}
		catch(SQLException exceptionSQL)
		{
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getIpAddress) Exception :"+exceptionSQL.toString()+"\n");
		}
		catch(Exception exceptionConnection)
		{	
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getIpAddress) Exception :"+exceptionConnection.toString()+"\n");
		}
		return ipaddress;	
	}

	public String getPassword(String curuserid )
	{
		String usrpassword=null;		
		try
		{
		    String rssql = "select app_password.decrypt(APPL_USER_PASSWORD) from sm_appl_user where appl_user_ID = '"+curuserid+"'";
			statement = connection.createStatement();
	        ResultSet rs = statement.executeQuery(rssql);
			while(rs.next())
            {
              usrpassword = rs.getString(1);
			}
			if(rs != null) rs.close();
			if(statement != null) statement.close();
		}
		catch(SQLException exceptionSQL)
		{
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getPassword) Exception :"+exceptionSQL.toString()+"\n");
		}
		catch(Exception exceptionConnection)
		{	
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getPassword) Exception :"+exceptionConnection.toString()+"\n");
		}
		return 	usrpassword;	
	}

	public int getProcessId()
	{
		String procid = null;	
		int lprocid = 0;
		try
		{			
			String sql1 = "SELECT XH_PROCESS_ID_SEQ.NEXTVAL  FROM DUAL";
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql1);
			while(rs.next())
			{
				procid = rs.getString(1);
			}

			if(rs != null) rs.close();
			if(statement != null) statement.close();
			lprocid = Integer.parseInt(procid);
		}
		catch(Exception exceptionConnection)
		{	
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getProcessId) Exception :"+exceptionConnection.toString()+"\n");
		}
		return lprocid;	
	}

	public String getDbString()
	{
		String dbstring = null;		
		try
		{
			String rssql = "SELECT db_connect_string FROM xh_param";
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(rssql);

			while(rs.next())
			{
				dbstring=rs.getString(1);
			}

			if(rs != null) rs.close();
			if(statement != null) statement.close();
		}
		catch(SQLException exceptionSQL)
		{
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getDbString) Exception :"+exceptionSQL.toString()+"\n");
		}
		catch(Exception exceptionConnection)
		{	
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getDbString) Exception :"+exceptionConnection.toString()+"\n");
		}
		return dbstring;	
	}

	public String insertValues(int lprocid,String facility,String commclient,String applId,String commtype,String protocolLinkID)
	{
		String flag = null;		
		CallableStatement ostmt = null;
		try
		{
			ostmt = connection.prepareCall("{ call xhcore.INSERT_COMM_PROCESS(?,?,?,?,?,?,?) }" );
			ostmt.setInt(1,lprocid);
			ostmt.setString(2,facility);
			ostmt.setString(3,commclient);
			ostmt.setString(4,applId);
			ostmt.setString(5,commtype);
			ostmt.setString(6,protocolLinkID);
			ostmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			ostmt.execute();
			flag = ostmt.getString(7);
			if(ostmt != null) ostmt.close();
		}
		catch(SQLException exceptionSQL)
		{			
			write.fileOutput(filename," (CentralizedDataBaseAdapter:insertValues) Exception: "+exceptionSQL.toString()+"\n");
		}
		catch(Exception exceptionConnection)
		{
			write.fileOutput(filename," (CentralizedDataBaseAdapter:insertValues) Exception: "+exceptionConnection.toString()+"\n");
		}
		return flag;	
	}

	//****************************************************************************************************************/
	// reset process method	
	//****************************************************************************************************************/	
	public boolean reSetProcess(String appl,String commu_client,String facility,String commtype,String servicemode, String serviceName)
	{
		HashMap map = null;
		Boolean install = null;
		Boolean start = null;
		Boolean stop = null;
		CallableStatement  ostmt = null;
		String process_id = "";
		String sts="",message_text2 = "";
		String ipaddress = "";
		boolean reference = false;

		CentralizedRemote remoteObject = null;
		CentralizedRemoteOBjectClass object = new CentralizedRemoteOBjectClass();
		String flag = "";

		try
		{
			String sql = "SELECT MAX(PROCESS_ID) FROM XH_COMM_PROCESS WHERE APPLICATION_ID='"+appl+"' AND  CLIENT_ID='"+commu_client+"' AND FACILITY_ID='"+facility+"' AND PROCESS_TYPE ='"+commtype+"'";
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql); 
			while(rs.next())
			{
				process_id=rs.getString(1);
			}
			if(rs != null) rs.close();
			if(statement != null) statement.close();
			write.fileOutput(filename," (CentralizedDataBaseAdapter:reSetProcess) process_id : "+process_id+" \n");

			if(commtype.equalsIgnoreCase("O")) ipaddress = getIpAddress(appl,commu_client,"O");
			if(commtype.equalsIgnoreCase("I")) ipaddress = getIpAddress(appl,commu_client,"I");

			write.fileOutput(filename," (CentralizedDataBaseAdapter:reSetProcess) ipaddress : "+ipaddress+" \n");
			write.fileOutput(filename," (CentralizedDataBaseAdapter:reSetProcess) servicemode : "+servicemode+" \n");

			if(servicemode.equalsIgnoreCase("Without Service"))
			{
				write.fileOutput(filename," (CentralizedDataBaseAdapter:reSetProcess) inside Without Service servicemode \n");
				ostmt = connection.prepareCall("{ call xhcomm.reset_process(?,?,?) }" ); 
				ostmt.setString(1,process_id);
				ostmt.registerOutParameter(2,java.sql.Types.VARCHAR);
				ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
				ostmt.execute(); 
				sts = ostmt.getString(2);
				message_text2 = ostmt.getString(3);
				if(sts.equals("0"))
				{
					connection.commit();
					reference = true;
				} 
				else 
				{
					connection.rollback();
					reference = false;
				}
				if(ostmt != null) ostmt.close();
			}

			if(servicemode.equalsIgnoreCase("With Service"))
			{
				write.fileOutput(filename," (CentralizedDataBaseAdapter:reSetProcess) inside With Service servicemode \n");
				remoteObject = (CentralizedRemote)object.remoteObject(ipaddress);
				write.fileOutput(filename," (CentralizedDataBaseAdapter:reSetProcess) remoteObject : "+remoteObject+" \n");
				map = remoteObject.chkServiceStatus(serviceName);
				write.fileOutput(filename," (CentralizedDataBaseAdapter:reSetProcess) map : "+map+" \n");

				if(map != null)
				{
					install = (Boolean)map.get("install");
					start = (Boolean)map.get("start");
					stop = (Boolean)map.get("stop");
				}

				if(start.toString().equals("true"))
				{	
					flag = remoteObject.stopHl7Gateway(serviceName);
				}
			}

			if((stop.toString().equals("true"))||(flag!=null)||(install.toString().equals("true")))
			{
				ostmt = connection.prepareCall("{ call xhcomm.reset_process(?,?,?) }" ); 
				ostmt.setString(1,process_id);
				ostmt.registerOutParameter(2,java.sql.Types.VARCHAR);
				ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
				ostmt.execute(); 
				sts = ostmt.getString(2);
				message_text2 = ostmt.getString(3);
				if(sts.equals("0"))
				{
					connection.commit();
					reference=true;
				} 
				else 
				{
					connection.rollback();
					reference=false;
				}
				if(ostmt != null) ostmt.close();
			}

		}
		catch(SQLException exceptionSQL)
		{
			write.fileOutput(filename," (CentralizedDataBaseAdapter:executeQueryForProcess) Exception :"+exceptionSQL.toString()+"\n");
		}
		catch(Exception exceptionConnection)
		{	
			write.fileOutput(filename," (CentralizedDataBaseAdapter:executeQueryForProcess) Exception :"+exceptionConnection.toString()+"\n");
		}
		finally
		{
			if (map != null) map.clear();
		}
		return reference;		
	}

	//Method setStopProcess
	public boolean setStopProcess(String applicationid, String facilityid, String processid, String commtype, String servicemode)
	{		
	/*	HashMap map = null;

		Boolean install = null;
		Boolean start = null;
		Boolean stop = null;
	*/	boolean reference = false;

	//	String flag = null;
		String ipaddress = null;
		String clientid = null;		

		CentralizedRemote remoteObject = null;
	//	CentralizedRemoteOBjectClass object = new CentralizedRemoteOBjectClass();

		try
		{
			String rssql = "SELECT client_id FROM xh_comm_process WHERE process_id = " + processid;

			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(rssql);

			while(rs.next())
			{
				clientid = rs.getString(1);
			}

			if(rs != null) rs.close();
			if(statement != null) statement.close();

			write.fileOutput(filename," (CentralizedDataBaseAdapter:setStopProcess) clientid :"+clientid+" \n");

			if(commtype.equalsIgnoreCase("O")) ipaddress = getIpAddress(applicationid, clientid, "O");
			if(commtype.equalsIgnoreCase("I")) ipaddress = getIpAddress(applicationid, clientid, "I");

			write.fileOutput(filename," (CentralizedDataBaseAdapter:setStopProcess) ipaddress :"+ipaddress+" \n");
			write.fileOutput(filename," (CentralizedDataBaseAdapter:setStopProcess) servicemode :"+servicemode+" \n");

		/*	if(servicemode.equalsIgnoreCase("Without Service"))
			{
				String sql = "UPDATE  xh_comm_process SET PROCESS_STATUS ='C' WHERE PROCESS_ID="+processid+"";
				write.fileOutput(filename," (CentralizedDataBaseAdapter:setStopProcess) inside Without Service servicemode :\n");			   

				statement = connection.createStatement();
				statement.executeQuery(sql);
				connection.commit();
				reference = true;
				write.fileOutput(filename," (CentralizedDataBaseAdapter:setStopProcess) sucessfuly stopped in Without Service servicemode :\n");
				if(statement != null) statement.close();
			}

			else if(servicemode.equalsIgnoreCase("With Service"))
			{
				write.fileOutput(filename," (CentralizedDataBaseAdapter:setStopProcess) With Service\n");

				remoteObject = (CentralizedRemote)object.remoteObject(ipaddress);

				write.fileOutput(filename," (CentralizedDataBaseAdapter:setStopProcess) remoteObject:"+remoteObject+":\n");

				map = remoteObject.chkServiceStatus(applicationid,facilityid,processid);

				write.fileOutput(filename," (CentralizedDataBaseAdapter:setStopProcess) map:"+map+":\n");

				if(map != null)
				{
					install = (Boolean)map.get("install");
					start = (Boolean)map.get("start");
					stop = (Boolean)map.get("stop");
				}

				if(start.toString().equals("true"))
				{
					flag = remoteObject.stopHl7Gateway(serviceName);
					write.fileOutput(filename," (CentralizedDataBaseAdapter:setStopProcess)flag: "+flag+"\n");
				}
			}
		*/
			String sql = "UPDATE xh_comm_process SET process_status = 'C' WHERE process_id = " + processid + "";
			write.fileOutput(filename," (CentralizedDataBaseAdapter:setStopProcess) inside Without Service servicemode :\n");			   

			statement = connection.createStatement();
			statement.executeQuery(sql);
			connection.commit();
			reference = true;
			write.fileOutput(filename," (CentralizedDataBaseAdapter:setStopProcess) Process stop triggered... :\n");
			if(statement != null) statement.close();

		/*	String stopstr = "";
			String installstr = "";

			if(stop != null) stopstr = stop.toString();
			if(install != null) installstr=install.toString();

			if((stopstr.equals("true")) || (flag != null) || (installstr.equals("true")))
			{
				String sql = "UPDATE  xh_comm_process SET PROCESS_STATUS ='S' WHERE PROCESS_ID="+processid+"";
				statement = connection.createStatement();
				statement.executeQuery(sql);
				connection.commit();
				reference = true;
				write.fileOutput(filename," (CentralizedDataBaseAdapter:setStopProcess) sucessfuly stopped in With Service servicemode :\n");

				if(statement != null) statement.close();
			}
		*/
			remoteObject = null;
		}
		catch(SQLException exceptionSQL)
		{
			write.fileOutput(filename," (CentralizedDataBaseAdapter:setStopProcess) Exception :"+exceptionSQL.toString()+"\n");
		}
		catch(Exception exceptionConnection)
		{
			write.fileOutput(filename," (CentralizedDataBaseAdapter:setStopProcess) Exception :"+exceptionConnection.toString()+"\n");
		}
		return reference;			
	}
	//End of  setStopProcess

	//Method  executeQueryForProcess
	public Object[][] executeQueryForProcess(String query) 
	{
		ResultSet rs = null;
		try 
		{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_READ_ONLY);
			rs = statement.executeQuery(query);
			rs.last();
			resultarray = new Object[rs.getRow()][20];
			rs.beforeFirst();
			int row = 0;

			while(rs.next())
			{
				if(rs.getString(1) != null)
				{
					if((rs.getString(1).equalsIgnoreCase("Active"))) resultarray[row][0] = Color.GREEN;
					if((rs.getString(1).equalsIgnoreCase("Warming Up"))) resultarray[row][0] = Color.YELLOW;
					if((rs.getString(1).equalsIgnoreCase("Stopped"))) resultarray[row][0] = Color.RED;
					if((rs.getString(1).equalsIgnoreCase("About To Stop"))) resultarray[row][0] = Color.BLUE;
				}
				else  resultarray[row][0] = Color.PINK;

				resultarray[row][1]  = (rs.getString(1) == null)?EMPTY_STRING:rs.getString(1); // Status
				resultarray[row][2]  = (rs.getString(2) == null)?EMPTY_STRING:rs.getString(2); // Process ID
				resultarray[row][3]  = (rs.getString(3) == null)?EMPTY_STRING:rs.getString(3); // Comm Type
				resultarray[row][4]  = (rs.getString(5) == null)?EMPTY_STRING:rs.getString(5); // Application Name
				resultarray[row][5]  = (rs.getString(24) == null)?EMPTY_STRING:rs.getString(24); // Protocol Link Name
				resultarray[row][6]  = (rs.getString(9) == null)?EMPTY_STRING:rs.getString(9); // Client ID
				resultarray[row][7]  = (rs.getString(10) == null)?EMPTY_STRING:rs.getString(10); // Start Date Time
				resultarray[row][8]  = (rs.getString(11) == null)?EMPTY_STRING:rs.getString(11); // Stop Date Time
				resultarray[row][9]  = (rs.getString(12) == null)?EMPTY_STRING:rs.getString(12); // Retries
				resultarray[row][10] = (rs.getString(13) == null)?EMPTY_STRING:rs.getString(13); // Last Comm Date Time 
				resultarray[row][11] = (rs.getString(14) == null)?EMPTY_STRING:rs.getString(14); // Last Msg ID
				resultarray[row][12] = (rs.getString(15) == null)?EMPTY_STRING:rs.getString(15); // Tot Msgs
				resultarray[row][13] = (rs.getString(16) == null)?EMPTY_STRING:rs.getString(16); // Tot Queries
				resultarray[row][14] = (rs.getString(17) == null)?EMPTY_STRING:rs.getString(17); // Started By 
				resultarray[row][15] = (rs.getString(18) == null)?EMPTY_STRING:rs.getString(18); // Stopped By
				resultarray[row][16] = (rs.getString(19) == null)?EMPTY_STRING:rs.getString(19); // Added WS
				resultarray[row][17] = (rs.getString(20) == null)?EMPTY_STRING:rs.getString(20); // Mofidied WS
				resultarray[row][18] = (rs.getString(21) == null)?EMPTY_STRING:rs.getString(21); // Added Facility
				resultarray[row][19] = (rs.getString(22) == null)?EMPTY_STRING:rs.getString(22);	// Modified Facility

				row++;
			}
			if(rs != null) rs.close();
			if(statement != null) statement.close();
		} 
		catch (SQLException ex) 
		{
			write.fileOutput(filename," (CentralizedDataBaseAdapter:executeQueryForProcess) Exception :"+ex.toString()+"\n");
			ex.printStackTrace(System.err); 
		} 
		catch (Exception ex) 
		{ 
			write.fileOutput(filename," (CentralizedDataBaseAdapter:executeQueryForProcess) Exception :"+ex.toString()+"\n");
			ex.printStackTrace(System.err);
		}

		return resultarray;
	}
	

  public String checkNull(String chkstr)
  {
	  return (chkstr == null)?new String(""):chkstr;

  }	

    public void close() throws SQLException 
	{
        if(resultSet != null) resultSet.close();
        if(statement != null) statement.close();
        if(connection != null) connection.close();
    }

	protected void finalize() throws Throwable 
	{
		close();
		super.finalize();
	}

	public String getTime()
	{
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT stop_date_time FROM xh_comm_process WHERE process_id IN (SELECT MAX(process_id) FROM xh_comm_process)";
		String time = "";

		try
		{
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next())
			{
				time = rs.getString(1);
			}
		}
		catch (Exception exp)
		{
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getTime) "+exp.toString()+"\n");
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			catch (Exception exp) { }
		}
		
		return time;
	}

	/**
	 * Method checks whether DB connection still exists or not.
	 * If the connection does not exist, it will try to re-establish DB connection.
	 */
	public boolean checkDBConnection()
	{
		try 
		{  			
			if(connection != null)
			{
				// Database Connection exists.... do nothing.				
			}
			else
			{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				connection = DriverManager.getConnection("jdbc:oracle:thin:@"+dburl,usrname,password);
				
				write.fileOutput(filename," (CentralizedDataBaseAdapter:checkDBConnection): DB Connection re-established...\n");

				setMedUserRole();
				connectionflag=true;
			}
		}
		catch(SQLException ex) 
		{
			connectionflag=false;
			write.fileOutput(filename," (CentralizedDataBaseAdapter:checkDBConnection) Exception :"+ex.toString()+"\n");
		}
		return connectionflag;
	}

/*	// Method getOutputDirctory
	public String getOutputDirectory(String curuserid,String commclient)
	{
		String dirname = null;
		String errtxt  = null;
		CallableStatement ostmt = null;
		try
		{
			ostmt = connection.prepareCall("{ call appprint.get_report_output_directory(?,?,?,?) }" ); 
			ostmt.setString(1,curuserid);
			ostmt.setString(2,commclient);
			ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);

			ostmt.execute(); 
			dirname = ostmt.getString(3);
			errtxt  = ostmt.getString(4);
			if(ostmt != null) ostmt.close();
		}
		catch(SQLException exceptionSQL)
		{
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getOutputDirectory) Exception :"+exceptionSQL.toString()+"\n");
		}
		catch(Exception exceptionConnection)
		{
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getOutputDirectory) Exception :"+exceptionConnection.toString()+"\n");	
		}
		return dirname;	
	}
	//End of getOutputDirctory()
*/
	
	// Method returns output directoy folder where the gateway logs will be generated
	public String getOutputDirectory(String clientID,String applicationID,String facilityID,String protocolLinkID)
	{						
		Statement stmt = null;
		ResultSet rs = null;

		String dirName = null;
		String sqlQry = "SELECT report_output_directory FROM xh_comm_client_application WHERE "+
							" client_id = '"+clientID+"' AND application_id = '"+applicationID+"'"+
							" AND facility_id = '"+facilityID+"' AND protocol_link = '"+protocolLinkID+"'";

		try
		{			
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlQry);

			if(rs.next())
			{
				dirName = rs.getString("report_output_directory");				
			}													  
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getOutputDirectory)dirName :"+dirName+"\n");	
		}		
		catch(Exception exceptionConnection)
		{
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getOutputDirectory) Exception :"+exceptionConnection.toString()+"\n");	
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			catch (Exception exp) { }			
		}
		return dirName;	
	}

	static public boolean isSubstringExists(String str, String substr)
	{
		boolean status = false; 
		Pattern pattern = Pattern.compile(substr);
		Matcher matcher = pattern.matcher(str); 
		status = matcher.find();
		return status; 
	}

	// Method to get protocol link name for the protocol link id passed
	public Object getProtocolName(Object protocolLinkID)
	{	
		String protocolLinkName = null;
		try
		{			
			String sql1 = "SELECT protocol_link_name FROM xh_protocol_link WHERE protocol_link_id='"+String.valueOf(protocolLinkID)+"'";
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql1);

			while(rs.next())
			{
				protocolLinkName = rs.getString(1);
			}

			if(rs != null) rs.close();
			if(statement != null) statement.close();			
		}
		catch(Exception exceptionConnection)
		{	
			write.fileOutput(filename," (CentralizedDataBaseAdapter:getProtocolName)Exception :"+exceptionConnection.toString()+"\n");
		}
		return protocolLinkName;	
	}

	/**
	 * Method used to check whether gateway is running or not for the client & protocol link id passed as arguments.
	 */
	public boolean checkGatewayStatus(String processID)
	{
		Statement stmt = null;
		ResultSet rs = null;

		boolean isGatewayStarted = false;
		String query = "SELECT PROCESS_STATUS FROM XH_COMM_PROCESS WHERE PROCESS_ID = '" + processID + "'";
		try
		{
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);

			if(rs.next())
			{				
				String procStatus = rs.getString("PROCESS_STATUS");
				
				if("A".equals(procStatus) || "W".equals(procStatus)) isGatewayStarted = true;
			}
		}
		catch(Exception exp)
		{			
			write.fileOutput(filename," (CentralizedDataBaseAdapter:checkGatewayStatus) Exception: "+exp.toString()+"\n");
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			catch(Exception exp)
			{
				write.fileOutput(filename," (CentralizedDataBaseAdapter:checkGatewayStatus)fException: "+exp.toString()+"\n");
			}
		}
		return isGatewayStarted;
	}

	/**
	 * Method checks whether the database connection exists or not for the arguments passed.
	 * Method used for checking the gateway db connection before the starting the gateway at the specified server.
	 * Accessed from CentralizedMonitorApplication.
	 */
	public boolean checkGatewayDBConnection(String dbString,String dbUserID,String dbPassword)
	{
		boolean isDBConnExists = false;
		Connection gatewayDBConn = null;
		try 
		{   			
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			gatewayDBConn = DriverManager.getConnection("jdbc:oracle:thin:@"+dbString, dbUserID, dbPassword);
			
			isDBConnExists = true;
		}
		catch(SQLException ex) 
		{					
			write.fileOutput(filename," (CentralizedDataBaseAdapter:checkGatewayDBConnection)Exception :"+ex.toString()+"\n");
		}
		finally
		{
			try
			{
				if(gatewayDBConn != null && !gatewayDBConn.isClosed()) gatewayDBConn.close();
			}
			catch(Exception exp)
			{
				write.fileOutput(filename," (CentralizedDataBaseAdapter:checkGatewayDBConnection)fException :"+exp.toString()+"\n");
			}
		}
		return isDBConnExists;
	}	

}
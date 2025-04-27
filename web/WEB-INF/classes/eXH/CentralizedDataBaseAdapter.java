package eXH;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import webbeans.eCommon.ConnectionManager;

/**
 * Class to hanadle the databse operations
 * 
 */
public class CentralizedDataBaseAdapter {
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	String[] columnNames = {};
	Object[][] resultarray = null;
	static String inboundArray[][] = null;
	static String outboundArray[][] = null;
	static String dburl = null;
	static String usrname = null;
	static String password = null;
	static String communicationType = null;
	static String dbConnectionExcetion = null;
	static boolean connectionflag = false;
	String filename = null;
	static String EMPTY_STRING = "";

	public CentralizedDataBaseAdapter(String dburl, String usrname,
			String password) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection = ConnectionManager.getConnection();
			setMedUserRole();
			connectionflag = true;
		} catch (SQLException ex) {
			connectionflag = false;
		}
	}

	public CentralizedDataBaseAdapter() {
		setMedUserRole();
	}

	
	private void setMedUserRole() {
		Connection connection = null;
		Statement stmt = null;
		CallableStatement call = null;
		ResultSet rset = null;
		try {
			connection = ConnectionManager.getConnection();
			String strParamRole = "";
			String strProcedureName = "{call DBMS_SESSION.SET_ROLE(?)" + "}";
			String strQry = "SELECT APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) FROM SM_ORA_ROLE  Where ORA_ROLE_ID = 'MEDUSERS'";
			String strPasswd = "";
			try {
				stmt = connection.createStatement();
				rset = stmt.executeQuery(strQry);

				while (rset.next()) {
					strPasswd = rset.getString(1);
				}
			} catch (Exception expSql) {
			}
			if (strPasswd != null && !strPasswd.equals("")) {
				strParamRole = "MEDUSERS IDENTIFIED BY " + strPasswd;
			} else {
				strParamRole = "MEDUSERS";
			}
			call = connection.prepareCall(strProcedureName);
			call.setString(1, strParamRole);
			call.execute();
			call.close();
		} catch (Exception expCal) {
			expCal.printStackTrace();
		} finally {
			try {
				call.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			XHUtil.closeDBResources(rset, stmt, connection);
		}
	}

	public TreeMap<String, String> getClientRecords() {
		Connection connection = null;
		Statement statement = null;
		ResultSet clientresultset = null;
		TreeMap<String, String> clientGatewayServerMap = null;
		try {
			connection = ConnectionManager.getConnection();
			String clientsql = "SELECT DISTINCT CLIENT_ID,CLIENT_NAME FROM XH_COMM_CLIENT WHERE IN_USE_YN='Y'";
			statement = connection
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			clientresultset = statement.executeQuery(clientsql);
			clientresultset.last();
			clientGatewayServerMap = new TreeMap<String, String>();
			clientresultset.beforeFirst();
			clientGatewayServerMap.put("", "All");
			while (clientresultset.next()) {
				clientGatewayServerMap.put(clientresultset.getString(1),
						clientresultset.getString(2));
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} catch (Exception exceptionConnection) {
			exceptionConnection.printStackTrace();
		} finally {
			XHUtil.closeDBResources(clientresultset, statement, connection);
		}
		return clientGatewayServerMap;
	}

	public TreeMap<String, String> getApplicationRecords() {
		Connection connection = null;
		ResultSet applnrs = null;
		Statement statement = null;
		TreeMap<String, String> applnMap = null;
		try {
			connection = ConnectionManager.getConnection();
			String applnsql = "SELECT DISTINCT APPLICATION_ID,APPLICATION_NAME FROM XH_APPLICATION  WHERE IN_USE_YN='Y'";
			statement = connection
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			applnrs = statement.executeQuery(applnsql);
			applnrs.last();
			applnMap = new TreeMap<String, String>();
			applnrs.beforeFirst();
			applnMap.put("", "All");
			while (applnrs.next()) {
				applnMap.put(applnrs.getString(1), applnrs.getString(2));
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} catch (Exception exceptionConnection) {
			exceptionConnection.printStackTrace();
		} finally {
			XHUtil.closeDBResources(applnrs, statement, connection);
		}
		return applnMap;
	}

	public TreeMap<String, String> getFacilityRecords() {
		Connection connection = null;
		Statement statement = null;
		ResultSet facilityrs = null;
		TreeMap<String, String> facilityMap = null;
		try {
			connection = ConnectionManager.getConnection();
			String facilitysql = "SELECT DISTINCT A.FACILITY_ID, s.facility_name FROM XH_PARAM_FOR_FACILITY a, sm_facility_param s  WHERE  a.facility_id  =  s.facility_id ";
			statement = connection
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			facilityrs = statement.executeQuery(facilitysql);
			facilityrs.last();
			facilityMap = new TreeMap<String, String>();
			facilityrs.beforeFirst();
			facilityMap.put("", "All");
			while (facilityrs.next()) {
				facilityMap.put(facilityrs.getString(1),
						facilityrs.getString(2));
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} catch (Exception exceptionConnection) {
			exceptionConnection.printStackTrace();
		} finally {
			XHUtil.closeDBResources(facilityrs, statement, connection);
		}
		return facilityMap;
	}

	public Map<Integer, GatewayServiceBO> executeQuery(String sqlquery,
			String commtype) {
		Connection connection = null;
		ResultSet queryresult = null;
		Statement stmt = null;
		Map<Integer, GatewayServiceBO> tmpMap = null;
		GatewayServiceBO gatewayBO = null;
		try {
			connection = ConnectionManager.getConnection();
			stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			queryresult = stmt.executeQuery(sqlquery);

			queryresult.last();
			tmpMap = new HashMap<Integer, GatewayServiceBO>();

			if (commtype.equalsIgnoreCase("O"))
				outboundArray = new String[queryresult.getRow()][5];
			if (commtype.equalsIgnoreCase("I"))
				inboundArray = new String[queryresult.getRow()][5];

			queryresult.beforeFirst();
			int row = 0;
			while (queryresult.next()) {
				gatewayBO = new GatewayServiceBO();
				gatewayBO.setStatus("black_square.jpg");
				if (commtype.equalsIgnoreCase("O")) {
					outboundArray[row][0] = checkNull(queryresult.getString(1));
					outboundArray[row][1] = checkNull(queryresult.getString(3));
					outboundArray[row][2] = checkNull("XX");
					outboundArray[row][3] = "O";
					outboundArray[row][4] = checkNull(queryresult.getString(11));
					communicationType = "O";
					gatewayBO.setComType("O");
				}

				if (commtype.equalsIgnoreCase("I")) {
					inboundArray[row][0] = checkNull(queryresult.getString(1));
					inboundArray[row][1] = checkNull(queryresult.getString(3));
					inboundArray[row][2] = checkNull("XX");
					inboundArray[row][3] = "I";
					inboundArray[row][4] = checkNull(queryresult.getString(11));
					communicationType = "I";
					gatewayBO.setComType("I");
				}
				gatewayBO.setClientName(checkNull(queryresult.getString(2))); // Client
																				// Name
				gatewayBO
						.setApplicationName(checkNull(queryresult.getString(4))); // Application
																					// Name
				gatewayBO.setProcessID(checkNull(queryresult.getString(5))); // Process
																				// ID
				gatewayBO.setStartDateTime(checkNull(queryresult.getString(7))); // Start
																					// Date
																					// Time
				gatewayBO.setStartedBy(checkNull(queryresult.getString(8))); // Started
																				// By
																				// ID
				gatewayBO.setStopDateTime(checkNull(queryresult.getString(9))); // Stop
																				// Date
																				// Time
				gatewayBO.setNumOfRetries(checkNull(queryresult.getString(10))); // Retries

				String protocolLinkID = checkNull(queryresult.getString(11));
				gatewayBO.setProtocolLinkID(protocolLinkID); // Protocol Link
				gatewayBO.setProtocolLinkName(getProtocolName(protocolLinkID));
				String protocolType = checkNull(queryresult.getString(12)); // Protocol
																			// Type
				if (protocolType.equalsIgnoreCase("T")) {
					gatewayBO.setProtocolType("TCP/IP");
				} else if (protocolType.equalsIgnoreCase("F")) {
					gatewayBO.setProtocolType("File");
				} else if (protocolType.equalsIgnoreCase("R")) {
					gatewayBO.setProtocolType("RS232");
				} else if (protocolType.equalsIgnoreCase("X")) {
					gatewayBO.setProtocolType("Fax");
				} else if (protocolType.equalsIgnoreCase("M")) {
					gatewayBO.setProtocolType("Mail");
				} else if (protocolType.equalsIgnoreCase("S")) {
					gatewayBO.setProtocolType("SMS");
				} else if (protocolType.equalsIgnoreCase("D")) {
					gatewayBO.setProtocolType("ODBC");
				} else if (protocolType.equalsIgnoreCase("OT")) {
					gatewayBO.setProtocolType("ORACLE_TABLE");
				} else if (protocolType == null || protocolType.equals("")
						|| protocolType.equals(" ")) {
					gatewayBO.setProtocolType(" ");
				} else {
					gatewayBO.setProtocolType(" ");
				}

				gatewayBO.setLastCommDateTime(checkNull(queryresult
						.getString(13))); // Last Comm Date Time
				gatewayBO.setLastMsgId(checkNull(queryresult.getString(14))); // Last
																				// Msg
																				// ID
				gatewayBO.setTotalMsgs(checkNull(queryresult.getString(15))); // Total
																				// Messages

				gatewayBO.setStartedWSNo(checkNull(queryresult.getString(17))); // Total

				tmpMap.put(row, gatewayBO);
				row++;
			}
		} catch (SQLException ex) {
			System.err.println(ex);
			ex.printStackTrace(System.err);
		} catch (Exception ex) {
			System.err.println(ex);
			ex.printStackTrace(System.err);
		} finally {
			XHUtil.closeDBResources(queryresult, stmt, connection);
		}
		return tmpMap;
	}

	public Map<Integer, GatewayServiceBO> executeQueryWithRemoteStatus(
			String sqlquery, String commtype, String servicemode) {
		Connection connection = null;
		Statement statement = null;
		ResultSet queryresult = null;
		Map<Integer, GatewayServiceBO> tmpMap = null;
		GatewayServiceBO gatewayBO = null;
		try {
			connection = ConnectionManager.getConnection();
			statement = connection
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			System.out.println("APPsqlquery "+sqlquery);
			queryresult = statement.executeQuery(sqlquery);
			queryresult.last();
			tmpMap = new HashMap<Integer, GatewayServiceBO>();
			if (commtype.equalsIgnoreCase("O"))
				outboundArray = new String[queryresult.getRow()][5];
			if (commtype.equalsIgnoreCase("I"))
				inboundArray = new String[queryresult.getRow()][5];

			queryresult.beforeFirst();
			int row = 0;

			while (queryresult.next()) {
				gatewayBO = new GatewayServiceBO();
				String status = "";
				if (commtype.equalsIgnoreCase("O")) {
					outboundArray[row][0] = checkNull(queryresult.getString(1));
					outboundArray[row][1] = checkNull(queryresult.getString(3));
					outboundArray[row][2] = checkNull("XX");
					outboundArray[row][3] = "O";
					outboundArray[row][4] = checkNull(queryresult.getString(11));
					communicationType = "O";
					gatewayBO.setComType("O");
				} else if (commtype.equalsIgnoreCase("I")) {
					inboundArray[row][0] = checkNull(queryresult.getString(1));
					inboundArray[row][1] = checkNull(queryresult.getString(3));
					inboundArray[row][2] = checkNull("XX");
					inboundArray[row][3] = "I";
					inboundArray[row][4] = checkNull(queryresult.getString(11));
					communicationType = "I";
					gatewayBO.setComType("I");
				}
				status = checkNull(queryresult.getString(6));
				String commStatus = checkNull(queryresult.getString(16));

				if ("A".equals(status))
					gatewayBO.setStatus("/eXH/images/green_square.jpg");
				else if ("W".equals(status))
					gatewayBO.setStatus("/eXH/images/yello_square.jpg");
				else if ("S".equals(status))
					gatewayBO.setStatus("/eXH/images/red_square.jpg");
				else if ("C".equals(status))
					gatewayBO.setStatus("/eXH/images/blue_square.jpg");
				else if ("P".equals(status))
					gatewayBO.setStatus("/eXH/images/Cyan-square.gif");
				else
					gatewayBO.setStatus("/eXH/images/pink_square.jpg");

				if ("Y".equals(commStatus))
					gatewayBO.setCommStatus("/eXH/images/green_square.jpg");
				else if ("N".equals(commStatus))
					gatewayBO.setCommStatus("/eXH/images/red_square.jpg");
				else
					gatewayBO.setCommStatus("/eXH/images/pink_square.jpg");

				gatewayBO.setClientName((queryresult.getString(2)==null) ? EMPTY_STRING : queryresult.getString(2) ); // Client
																				// Name
				gatewayBO.setApplicationName((queryresult.getString(4)==null) ? EMPTY_STRING : queryresult.getString(4)); // Application
																					// Name
				gatewayBO.setProcessID((queryresult.getString(5)==null) ? EMPTY_STRING : queryresult.getString(5)); // Process
																				// ID
				gatewayBO.setStartDateTime((queryresult.getString(7)==null) ? EMPTY_STRING : queryresult.getString(7)); // Start
																					// Date
																					// Time
				gatewayBO.setStartedBy((queryresult.getString(8)==null) ? EMPTY_STRING : queryresult.getString(8)); // Started
																				// By
																				// ID
				gatewayBO.setStopDateTime((queryresult.getString(9)==null) ? EMPTY_STRING : queryresult.getString(9)); // Stop
																				// Date
																				// Time
				gatewayBO.setNumOfRetries((queryresult.getString(10)==null) ? EMPTY_STRING : queryresult.getString(10)); // Retries

				String protocolLinkID = (queryresult.getString(11)==null) ? EMPTY_STRING : queryresult.getString(11);
				gatewayBO.setProtocolLinkID((protocolLinkID==null) ? EMPTY_STRING : protocolLinkID); // Protocol Link
				gatewayBO.setProtocolLinkName((getProtocolName(protocolLinkID)==null) ? EMPTY_STRING : getProtocolName(protocolLinkID));

				gatewayBO.setLastCommDateTime((queryresult.getString(13)==null) ? EMPTY_STRING : queryresult.getString(13)); // Last Comm Date Time
				gatewayBO.setLastMsgId((queryresult.getString(14)==null) ? EMPTY_STRING : queryresult.getString(14)); // Last
																				// Msg
																				// ID
				gatewayBO.setTotalMsgs((queryresult.getString(15)==null) ? EMPTY_STRING : queryresult.getString(15)); // Total
																				// Messages

				gatewayBO.setStartedWSNo((queryresult.getString(17)==null) ? EMPTY_STRING : queryresult.getString(17)); // Total
				// Messages

				String protocolType = (queryresult.getString(12)==null) ? EMPTY_STRING : queryresult.getString(12);
				if (protocolType.equalsIgnoreCase("T")) {
					gatewayBO.setProtocolType("TCP/IP");
				} else if (protocolType.equalsIgnoreCase("F")) {
					gatewayBO.setProtocolType("File");
				} else if (protocolType.equalsIgnoreCase("R")) {
					gatewayBO.setProtocolType("RS232");
				} else if (protocolType.equalsIgnoreCase("X")) {
					gatewayBO.setProtocolType("Fax");
				} else if (protocolType.equalsIgnoreCase("M")) {
					gatewayBO.setProtocolType("Mail");
				} else if (protocolType.equalsIgnoreCase("S")) {
					gatewayBO.setProtocolType("SMS");
				} else if (protocolType.equalsIgnoreCase("D")) {
					gatewayBO.setProtocolType("ODBC");
				} else if (protocolType.equalsIgnoreCase("OT")) {
					gatewayBO.setProtocolType("ORACLE_TABLE");
				} else if (protocolType == null || protocolType.equals("")
						|| protocolType.equals(" ")) {
					gatewayBO.setProtocolType(" ");
				} else {
					gatewayBO.setProtocolType(" ");
				}
				tmpMap.put(row,gatewayBO);
				row++;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			XHUtil.closeDBResources(queryresult, statement, connection);
		}
		return tmpMap;
	}

	public String getIpAddress(String appicationid, String clientid, String mode) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		String ipaddress = null;
		try {
			connection = ConnectionManager.getConnection();
			String rssql = null;
			if (mode.equalsIgnoreCase("O")) {
				// modified query to get the machine name instead of IPAddress
				// rssql="SELECT CLIENT_ID FROM XH_COMM_CLIENT A,XH_COMM_CLIENT_APPLICATION B WHERE B.APPLICATION_ID='"+appicationid+"' AND B.CLIENT_ID='"+clientid+"' AND A.CLIENT_ID=B.CLIENT_ID AND B.COMM_TYPE='O' AND B.IN_USE_YN='Y'";
				// temporary query has to be delete
				rssql = "SELECT INBOUND_IP_ADDRESS FROM xh_comm_client WHERE client_id = '"
						+ clientid + "'";
			}
			if (mode.equalsIgnoreCase("I")) {
				// rssql="SELECT INBOUND_IP_ADDRESS FROM XH_COMM_CLIENT A,XH_COMM_CLIENT_APPLICATION B WHERE B.APPLICATION_ID='"+appicationid+"' AND B.CLIENT_ID='"+clientid+"' AND A.CLIENT_ID=B.CLIENT_ID AND B.COMM_TYPE='I' AND B.IN_USE_YN='Y'";
				rssql = "SELECT INBOUND_IP_ADDRESS FROM xh_comm_client WHERE client_id = '"
						+ clientid + "'";
			}
			statement = connection.createStatement();
			rs = statement.executeQuery(rssql);
			while (rs.next()) {
				ipaddress = rs.getString(1);
			}
		} catch (SQLException exceptionSQL) {
			exceptionSQL.printStackTrace();
		} catch (Exception exceptionConnection) {
			exceptionConnection.printStackTrace();
		} finally {
			XHUtil.closeDBResources(rs, statement, connection);
		}
		return ipaddress;
	}
	
	
	public String getRMIPort(String appicationid, String clientid, String mode) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		String rmiport = null;
		try {
			connection = ConnectionManager.getConnection();
			String rssql = null;
			if (mode.equalsIgnoreCase("O")) {
				// modified query to get the machine name instead of IPAddress
				// rssql="SELECT CLIENT_ID FROM XH_COMM_CLIENT A,XH_COMM_CLIENT_APPLICATION B WHERE B.APPLICATION_ID='"+appicationid+"' AND B.CLIENT_ID='"+clientid+"' AND A.CLIENT_ID=B.CLIENT_ID AND B.COMM_TYPE='O' AND B.IN_USE_YN='Y'";
				// temporary query has to be delete
				rssql = "SELECT INBOUND_PORT_NUMBER FROM xh_comm_client WHERE client_id = '"
						+ clientid + "'";
			}
			if (mode.equalsIgnoreCase("I")) {
				// rssql="SELECT INBOUND_IP_ADDRESS FROM XH_COMM_CLIENT A,XH_COMM_CLIENT_APPLICATION B WHERE B.APPLICATION_ID='"+appicationid+"' AND B.CLIENT_ID='"+clientid+"' AND A.CLIENT_ID=B.CLIENT_ID AND B.COMM_TYPE='I' AND B.IN_USE_YN='Y'";
				rssql = "SELECT INBOUND_PORT_NUMBER FROM xh_comm_client WHERE client_id = '"
						+ clientid + "'";
			}
			statement = connection.createStatement();
			rs = statement.executeQuery(rssql);
			while (rs.next()) {
				rmiport = rs.getString(1);
			}
		} catch (SQLException exceptionSQL) {
			exceptionSQL.printStackTrace();
		} catch (Exception exceptionConnection) {
			exceptionConnection.printStackTrace();
		} finally {
			XHUtil.closeDBResources(rs, statement, connection);
		}
		return rmiport;
	}

	public String getPassword(String curuserid) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		String usrpassword = null;
		try {
			connection = ConnectionManager.getConnection();
			String rssql = "select app_password.decrypt(APPL_USER_PASSWORD) from sm_appl_user where appl_user_ID = '"
					+ curuserid + "'";
			statement = connection.createStatement();
			rs = statement.executeQuery(rssql);
			while (rs.next()) {
				usrpassword = rs.getString(1);
			}
		} catch (SQLException exceptionSQL) {
		} catch (Exception exceptionConnection) {
		} finally {
			XHUtil.closeDBResources(rs, statement, connection);
		}
		return usrpassword;
	}

	public int getProcessId() {
		Connection connection = null;
		Statement statement = null;
		String procid = null;
		ResultSet rs = null;
		int lprocid = 0;
		try {
			connection = ConnectionManager.getConnection();
			String sql1 = "SELECT XH_PROCESS_ID_SEQ.NEXTVAL  FROM DUAL";
			statement = connection.createStatement();
			rs = statement.executeQuery(sql1);
			while (rs.next()) {
				procid = rs.getString(1);
			}

			lprocid = Integer.parseInt(procid);
		} catch (Exception exceptionConnection) {
			exceptionConnection.printStackTrace();
		} finally {
			XHUtil.closeDBResources(rs, statement, connection);
		}
		return lprocid;
	}

	public String getDbString() {
		Connection connection = null;
		Statement statement = null;
		String dbstring = null;
		ResultSet rs = null;
		try {
			connection = ConnectionManager.getConnection();
			String rssql = "SELECT db_connect_string FROM xh_param";
			statement = connection.createStatement();
			rs = statement.executeQuery(rssql);
			while (rs.next()) {
				dbstring = rs.getString(1);
			}

		} catch (SQLException exceptionSQL) {
			exceptionSQL.printStackTrace();
		} catch (Exception exceptionConnection) {
			exceptionConnection.printStackTrace();
		} finally {
			XHUtil.closeDBResources(rs, statement, connection);
		}
		return dbstring;
	}

	public String insertValues(int lprocid, String facility, String commclient,
			String applId, String commtype, String protocolLinkID) {
		Connection connection = null;
		String flag = null;
		CallableStatement ostmt = null;
		try {
			connection = ConnectionManager.getConnection();
			ostmt = connection
					.prepareCall("{ call xhcore.INSERT_COMM_PROCESS(?,?,?,?,?,?,?) }");
			ostmt.setInt(1, lprocid);
			ostmt.setString(2, facility);
			ostmt.setString(3, commclient);
			ostmt.setString(4, applId);
			ostmt.setString(5, commtype);
			ostmt.setString(6, protocolLinkID);
			ostmt.registerOutParameter(7, java.sql.Types.VARCHAR);
			ostmt.execute();
			flag = ostmt.getString(7);
		} catch (SQLException exceptionSQL) {
			exceptionSQL.printStackTrace();
		} catch (Exception exceptionConnection) {
			exceptionConnection.printStackTrace();
		} finally {
			XHUtil.closeDBResources(null, ostmt, connection);
		}

		return flag;
	}

	// ****************************************************************************************************************/
	// reset process method
	// ****************************************************************************************************************/
	@SuppressWarnings({ "rawtypes", "unused" })
	public boolean reSetProcess(String appl, String commu_client,
			String facility, String commtype, String servicemode,
			String serviceName) {
		Connection connection = null;
		connection = ConnectionManager.getConnection();
		HashMap map = null;
		Boolean install = null;
		Boolean start = null;
		Boolean stop = null;
		CallableStatement ostmt = null;
		String process_id = "";
		String sts = "";
		String message_text2 = null;
		String ipaddress = "";
		boolean reference = false;

		CentralizedRemote remoteObject = null;
		CentralizedRemoteOBjectClass object = new CentralizedRemoteOBjectClass();
		String flag = "";

		try {
			String sql = "SELECT MAX(PROCESS_ID) FROM XH_COMM_PROCESS WHERE APPLICATION_ID='"
					+ appl
					+ "' AND  CLIENT_ID='"
					+ commu_client
					+ "' AND FACILITY_ID='"
					+ facility
					+ "' AND PROCESS_TYPE ='" + commtype + "'";
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				process_id = rs.getString(1);
			}
			if (rs != null)
				rs.close();
			if (statement != null)
				statement.close();

			if (commtype.equalsIgnoreCase("O"))
				ipaddress = getIpAddress(appl, commu_client, "O");
			if (commtype.equalsIgnoreCase("I"))
				ipaddress = getIpAddress(appl, commu_client, "I");

			if (servicemode.equalsIgnoreCase("Without Service")) {
				ostmt = connection
						.prepareCall("{ call xhcomm.reset_process(?,?,?) }");
				ostmt.setString(1, process_id);
				ostmt.registerOutParameter(2, java.sql.Types.VARCHAR);
				ostmt.registerOutParameter(3, java.sql.Types.VARCHAR);
				ostmt.execute();
				sts = ostmt.getString(2);
				message_text2 = ostmt.getString(3);
				if (sts.equals("0")) {
					connection.commit();
					reference = true;
				} else {
					connection.rollback();
					reference = false;
				}
				if (ostmt != null)
					ostmt.close();
			}

			if (servicemode.equalsIgnoreCase("With Service")) {
				remoteObject = (CentralizedRemote) object.remoteObject(
						ipaddress, ""); // we should set rmi port number here
				map = remoteObject.chkServiceStatus(serviceName);
				if (map != null) {
					install = (Boolean) map.get("install");
					start = (Boolean) map.get("start");
					stop = (Boolean) map.get("stop");
				}

				if (start.toString().equals("true")) {
					flag = remoteObject.stopHl7Gateway(serviceName);
				}
			}

			if ((stop.toString().equals("true")) || (flag != null)
					|| (install.toString().equals("true"))) {
				ostmt = connection
						.prepareCall("{ call xhcomm.reset_process(?,?,?) }");
				ostmt.setString(1, process_id);
				ostmt.registerOutParameter(2, java.sql.Types.VARCHAR);
				ostmt.registerOutParameter(3, java.sql.Types.VARCHAR);
				ostmt.execute();
				sts = ostmt.getString(2);
				message_text2 = ostmt.getString(3);
				if (sts.equals("0")) {
					connection.commit();
					reference = true;
				} else {
					connection.rollback();
					reference = false;
				}
				if (ostmt != null)
					ostmt.close();
			}
		} catch (SQLException exceptionSQL) {
		} catch (Exception exceptionConnection) {
		} finally {
			if (map != null)
				map.clear();
		}
		return reference;
	}

	// Method setStopProcess
	@SuppressWarnings("unused")
	public boolean setStopProcess(String applicationid, String facilityid,
			String processid, String commtype, String servicemode) {
		Connection connection = null;
		ResultSet rs = null;
		Statement statement = null;
		boolean reference = false;
		String ipaddress = null;
		String clientid = null;
		try {
			connection = ConnectionManager.getConnection();
			String rssql = "SELECT client_id FROM xh_comm_process WHERE process_id = "
					+ processid;
			statement = connection.createStatement();
			rs = statement.executeQuery(rssql);
			while (rs.next()) {
				clientid = rs.getString(1);
			}
			if (commtype.equalsIgnoreCase("O"))
				ipaddress = getIpAddress(applicationid, clientid, "O");
			if (commtype.equalsIgnoreCase("I"))
				ipaddress = getIpAddress(applicationid, clientid, "I");

			String sql = "UPDATE xh_comm_process SET process_status = 'C' WHERE process_id = "
					+ processid + "";
			statement = connection.createStatement();
			statement.executeQuery(sql);
			connection.commit();
			reference = true;
			if (statement != null)
				statement.close();

		} catch (SQLException exceptionSQL) {
			exceptionSQL.printStackTrace();
		} catch (Exception exceptionConnection) {
			exceptionConnection.printStackTrace();
		} finally {
			XHUtil.closeDBResources(rs, statement, connection);
		}
		return reference;
	}

	// End of setStopProcess

	// Method executeQueryForProcess
	public List<GatewayServiceBO> executeQueryForProcess(String query) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		GatewayServiceBO gatewayBO = null;
		List<GatewayServiceBO> comProcessList = null;
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = statement.executeQuery(query);
			comProcessList = new ArrayList<GatewayServiceBO>();
			rs.last();
			rs.beforeFirst();
			while (rs.next()) {
				gatewayBO=new GatewayServiceBO();
				if (rs.getString(1) != null) {
					if ((rs.getString(1).equalsIgnoreCase("Active")))
					gatewayBO.setStatus("/eXH/images/green_square.jpg");
					if ((rs.getString(1).equalsIgnoreCase("Warming Up")))
					gatewayBO.setStatus("/eXH/images/yello_square.jpg");
					if ((rs.getString(1).equalsIgnoreCase("Stopped")))
					gatewayBO.setStatus("/eXH/images/red_square.jpg");
					if ((rs.getString(1).equalsIgnoreCase("About To Stop")))
					gatewayBO.setStatus("/eXH/images/blue_square.jpg");
				} else
				gatewayBO.setStatus("/eXH/images/pink_square.jpg");


				gatewayBO.setCommStatus((rs.getString(1) == null) ? EMPTY_STRING
						: rs.getString(1)); // Status
				gatewayBO.setProcessID((rs.getString(2) == null) ? EMPTY_STRING
						: rs.getString(2)); // Process ID
				gatewayBO.setComType((rs.getString(3) == null) ? EMPTY_STRING
						: rs.getString(3)); // Comm Type
				gatewayBO.setApplicationName((rs.getString(5) == null) ? EMPTY_STRING
						: rs.getString(5)); // Application Name
				gatewayBO.setProtocolLinkName((rs.getString(24) == null) ? EMPTY_STRING
						: rs.getString(24)); // Protocol Link Name
				gatewayBO.setClientName((rs.getString(9) == null) ? EMPTY_STRING
						: rs.getString(9)); // Client ID
				gatewayBO.setStartDateTime((rs.getString(10) == null) ? EMPTY_STRING
						: rs.getString(10)); // Start Date Time
				gatewayBO.setStopDateTime((rs.getString(11) == null) ? EMPTY_STRING
						: rs.getString(11)); // Stop Date Time
				gatewayBO.setNumOfRetries((rs.getString(12) == null) ? EMPTY_STRING
						: rs.getString(12)); // Retries
				gatewayBO.setLastCommDateTime((rs.getString(13) == null) ? EMPTY_STRING
						: rs.getString(13)); // Last Comm Date Time
				gatewayBO.setLastMsgId((rs.getString(14) == null) ? EMPTY_STRING
						: rs.getString(14)); // Last Msg ID
				gatewayBO.setTotalMsgs((rs.getString(15) == null) ? EMPTY_STRING
						: rs.getString(15)); // Tot Msgs
				gatewayBO.setTotalQueries((rs.getString(16) == null) ? EMPTY_STRING
						: rs.getString(16)); // Tot Queries
				gatewayBO.setStartedBy((rs.getString(17) == null) ? EMPTY_STRING
						: rs.getString(17)); // Started By
				gatewayBO.setStoppedBy((rs.getString(18) == null) ? EMPTY_STRING
						: rs.getString(18)); // Stopped By
				gatewayBO.setAddedWorkStation((rs.getString(19) == null) ? EMPTY_STRING
						: rs.getString(19)); // Added WS
				gatewayBO.setModifiedWorkStation((rs.getString(20) == null) ? EMPTY_STRING
						: rs.getString(20)); // Mofidied WS
				gatewayBO.setAddFacility((rs.getString(21) == null) ? EMPTY_STRING
						: rs.getString(21)); // Added Facility
				gatewayBO.setModifiedFacility((rs.getString(22) == null) ? EMPTY_STRING
						: rs.getString(22)); // Modified Facility
				
				comProcessList.add(gatewayBO);
			}
		} catch (SQLException ex) {
			ex.printStackTrace(System.err);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		} finally {
			XHUtil.closeDBResources(null, statement, connection);
		}
		return comProcessList;
	}

	public String checkNull(String chkstr) {
		return (chkstr == null) ? new String(" ") : chkstr;
	}

	public void close() throws SQLException {
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
	}

	protected void finalize() throws Throwable {
		close();
		super.finalize();
	}

	public String getTime() {
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT stop_date_time FROM xh_comm_process WHERE process_id IN (SELECT MAX(process_id) FROM xh_comm_process)";
		String time = "";
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				time = rs.getString(1);
			}
		} catch (Exception exp) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception exp) {
			}
		}
		return time;
	}

	/**
	 * Method checks whether DB connection still exists or not. If the
	 * connection does not exist, it will try to re-establish DB connection.
	 */
	public boolean checkDBConnection() {
		try {
			if (connection != null) {
				// Database Connection exists.... do nothing.
			} else {
				DriverManager
						.registerDriver(new oracle.jdbc.driver.OracleDriver());
				connection = DriverManager.getConnection("jdbc:oracle:thin:@"
						+ dburl, usrname, password);

				setMedUserRole();
				connectionflag = true;
			}
		} catch (SQLException ex) {
			connectionflag = false;
		}
		return connectionflag;
	}

	/*
	 * // Method getOutputDirctory public String getOutputDirectory(String
	 * curuserid,String commclient) { String dirname = null; String errtxt =
	 * null; CallableStatement ostmt = null; try { ostmt =
	 * connection.prepareCall
	 * ("{ call appprint.get_report_output_directory(?,?,?,?) }" );
	 * ostmt.setString(1,curuserid); ostmt.setString(2,commclient);
	 * ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
	 * ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
	 * 
	 * ostmt.execute(); dirname = ostmt.getString(3); errtxt =
	 * ostmt.getString(4); if(ostmt != null) ostmt.close(); } catch(SQLException
	 * exceptionSQL) { write.fileOutput(filename,
	 * " (CentralizedDataBaseAdapter:getOutputDirectory) Exception :"
	 * +exceptionSQL.toString()+"\n"); } catch(Exception exceptionConnection) {
	 * write.fileOutput(filename,
	 * " (CentralizedDataBaseAdapter:getOutputDirectory) Exception :"
	 * +exceptionConnection.toString()+"\n"); } return dirname; } //End of
	 * getOutputDirctory()
	 */

	// Method returns output directoy folder where the gateway logs will be
	// generated
	public String getOutputDirectory(String clientID, String applicationID,
			String facilityID, String protocolLinkID) {
		Statement stmt = null;
		ResultSet rs = null;
		Connection connection = null;
		String dirName = null;
		String sqlQry = "SELECT report_output_directory FROM xh_comm_client_application WHERE "
				+ " client_id = '"
				+ clientID
				+ "' AND application_id = '"
				+ applicationID
				+ "'"
				+ " AND facility_id = '"
				+ facilityID
				+ "' AND protocol_link = '" + protocolLinkID + "'";

		try {
			connection = ConnectionManager.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlQry);

			if (rs.next()) {
				dirName = rs.getString("report_output_directory");
			}
		} catch (Exception exceptionConnection) {
			exceptionConnection.printStackTrace();
		} finally {
			XHUtil.closeDBResources(rs, stmt, connection);
		}
		return dirName;
	}

	static public boolean isSubstringExists(String str, String substr) {
		boolean status = false;
		Pattern pattern = Pattern.compile(substr);
		Matcher matcher = pattern.matcher(str);
		status = matcher.find();
		return status;
	}

	// Method to get protocol link name for the protocol link id passed
	public String getProtocolName(String protocolLinkID) {
		Connection connection = null;
		Statement statement = null;
		String protocolLinkName = null;
		ResultSet rs = null;
		try {
			connection = ConnectionManager.getConnection();
			String sql1 = "SELECT protocol_link_name FROM xh_protocol_link WHERE protocol_link_id='"
					+ protocolLinkID + "'";
			statement = connection.createStatement();
			rs = statement.executeQuery(sql1);

			while (rs.next()) {
				protocolLinkName = rs.getString(1);
			}

		} catch (Exception exceptionConnection) {
			exceptionConnection.printStackTrace();
		} finally {
			XHUtil.closeDBResources(rs, statement, connection);
		}
		return protocolLinkName;
	}

	/**
	 * Method used to check whether gateway is running or not for the client &
	 * protocol link id passed as arguments.
	 */
	public boolean checkGatewayStatus(String processID) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		boolean isGatewayStarted = false;
		String query = "SELECT PROCESS_STATUS FROM XH_COMM_PROCESS WHERE PROCESS_ID = '"
				+ processID + "'";
		try {
			connection = ConnectionManager.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);

			if (rs.next()) {
				String procStatus = rs.getString("PROCESS_STATUS");

				if ("A".equals(procStatus) || "W".equals(procStatus))
					isGatewayStarted = true;
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			XHUtil.closeDBResources(rs, stmt, connection);
		}
		return isGatewayStarted;
	}

	/**
	 * Method checks whether the database connection exists or not for the
	 * arguments passed. Method used for checking the gateway db connection
	 * before the starting the gateway at the specified server. Accessed from
	 * CentralizedMonitorApplication.
	 */
	public boolean checkGatewayDBConnection(String dbString, String dbUserID,
			String dbPassword) {
		boolean isDBConnExists = false;
		Connection gatewayDBConn = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			gatewayDBConn = DriverManager.getConnection("jdbc:oracle:thin:@"
					+ dbString, dbUserID, dbPassword);

			isDBConnExists = true;
		} catch (SQLException ex) {
		} finally {
			try {
				if (gatewayDBConn != null && !gatewayDBConn.isClosed())
					gatewayDBConn.close();
			} catch (Exception exp) {
			}
		}
		return isDBConnExists;
	}

	public void closeDBConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (Exception exp) {
		}
	}
}
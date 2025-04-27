package eXH;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import webbeans.eCommon.ConnectionManager;
import em.xh.remoteserver.CentralizedRemote;

public class CentralizedMonitorApplication {
	String insql;
	String outsql;
	String commtypeArray[] = { "Outbound", "Inbound" };
	CentralizedMonitorParams monitorParams;
	String modeofinstall = "N";
	@SuppressWarnings("rawtypes")
	HashMap sqlhashMap;
	boolean isLoginSuccessfull;
	public static String SERVICENAME_SEPARATOR = "_";
	CentralizedDataBaseAdapter dataadapter = new CentralizedDataBaseAdapter();

	/**
	 * used to get values for gateway servers
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public TreeMap<String, String> getClientMap() throws SQLException,
			ClassNotFoundException {
		TreeMap<String, String> clientGatewayServerMap = null;
		try {
			clientGatewayServerMap = dataadapter.getClientRecords();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientGatewayServerMap;
	}

	/**
	 * used to get values for application values
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public TreeMap<String, String> getApplicationMap() throws SQLException,
			ClassNotFoundException {
		TreeMap<String, String> applnMap = null;
		try {
			applnMap = dataadapter.getApplicationRecords();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return applnMap;
	}

	/**
	 * used to get facility values
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public TreeMap<String, String> getFacilityMap() throws SQLException,
			ClassNotFoundException {
		TreeMap<String, String> facilityMap = null;
		try {
			facilityMap = dataadapter.getFacilityRecords();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return facilityMap;
	}

	/**
	 * used to prepare the sql query to get the all data data is displayed into
	 * the table
	 */
	public void fetch(String applicationid, String facilityid,
			String commclient, String commtype) {
		try {
			modeofinstall = "N";
			if (modeofinstall == null || "N".equalsIgnoreCase(modeofinstall))
				modeofinstall = "Without Service";
			else
				modeofinstall = "With Service";

			if (applicationid == null)
				applicationid = "";

			if (facilityid == null)
				facilityid = "";

			if (commclient == null)
				commclient = "";

			if (commtype == null)
				commtype = "";

			if (commtype != null && commtype.equalsIgnoreCase("Inbound"))
				commtype = "I";
			else if (commtype != null && commtype.equalsIgnoreCase("Outbound"))
				commtype = "O";

			sqlhashMap = constructSql(applicationid, facilityid, commclient,
					commtype);
			outsql = (String) sqlhashMap.get("outsql");
			insql = (String) sqlhashMap.get("insql");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * used to prepare the sql query to get the all data data is displayed into
	 * the table
	 */
	public void fetch(Map<String, String> paramMap) {
		String commtype = null;
		try {
			modeofinstall = "N";
			if (modeofinstall == null || "N".equalsIgnoreCase(modeofinstall))
				modeofinstall = "Without Service";
			else
				modeofinstall = "With Service";

			if (paramMap.get("processType") == null
					|| paramMap.get("processType") == "") {
				commtype = "";
			} else if (paramMap.get("processType") != null
					&& paramMap.get("processType").equalsIgnoreCase("Inbound"))
				commtype = "I";
			else if (paramMap.get("processType") != null
					&& paramMap.get("processType").equalsIgnoreCase("Outbound"))
				commtype = "O";

			sqlhashMap = constructSqlCommProcess(paramMap.get("clientID"),
					paramMap.get("applicationID"), commtype,
					paramMap.get("whereClause"));

			outsql = (String) sqlhashMap.get("outsql");
			insql = (String) sqlhashMap.get("insql");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * used to construct the sql queries for getting values of inbound and
	 * outbound arrays
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap constructSql(String applicationid, String facilityid,
			String commclient, String commtype) {
		HashMap queryMap = null;
		try {
			String outboundsql = "SELECT DISTINCT A.CLIENT_ID ,B.CLIENT_NAME,A.APPLICATION_ID ,D.APPLICATION_NAME,A.PROCESS_ID,A.PROCESS_STATUS,TO_CHAR(A.START_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') "
					+ " START_DATE_TIME,A.STARTED_BY_ID,TO_CHAR(A.STOP_DATE_TIME,'DD/MM/YYYY HH24:MI:SS')STOP_DATE_TIME, "
					+ " A.LAST_OUTBOUND_RETRIES,C.PROTOCOL_LINK,P.PROTOCOL_TYPE,TO_CHAR(A.LAST_COMM_DATE_TIME,'DD/MM/YYYY HH24:MI:SS')LAST_COMM_DATE_TIME,A.LAST_MESSAGE_ID,A.TOTAL_MESSAGES,A.COMM_STATUS,A.ADDED_AT_WS_NO"
					+ " FROM XH_COMM_PROCESS A,XH_COMM_CLIENT B,XH_COMM_CLIENT_APPLICATION C ,XH_APPLICATION D,XH_PROTOCOL P,XH_PROTOCOL_LINK PL"
					+ " WHERE A.CLIENT_ID=NVL('"
					+ commclient
					+ "',A.CLIENT_ID) AND A.PROCESS_TYPE='O' "
					+ " AND A.APPLICATION_ID=NVL('"
					+ applicationid
					+ "',A.APPLICATION_ID)"
					+ " AND A.CLIENT_ID=B.CLIENT_ID AND A.CLIENT_ID=C.CLIENT_ID "
					+ " AND b.OUTBOUND_YN = 'Y' AND c.IN_USE_YN = 'Y' AND b.IN_USE_YN = 'Y' "
					+ " AND A.APPLICATION_ID=D.APPLICATION_ID"
					+ " AND A.APPLICATION_ID = C.APPLICATION_ID AND A.PROTOCOL_LINK=C.PROTOCOL_LINK"
					+ " AND C.PROTOCOL_LINK=PL.PROTOCOL_LINK_ID AND PL.PROTOCOL_ID=P.PROTOCOL_ID"
					+ " AND (A.APPLICATION_ID,A.START_DATE_TIME)  IN (SELECT APPLICATION_ID , MAX(START_DATE_TIME) FROM XH_COMM_PROCESS "
					+ " WHERE CLIENT_ID=NVL('"
					+ commclient
					+ "',CLIENT_ID) AND PROTOCOL_LINK=A.PROTOCOL_LINK AND PROCESS_TYPE ='O' GROUP BY  APPLICATION_ID,CLIENT_ID)";
				/*	+ " UNION "
					+ " SELECT DISTINCT X.CLIENT_ID CLIENT_ID,Y.CLIENT_NAME CLIENT_NAME,X.APPLICATION_ID APPLICATION_ID,D.APPLICATION_NAME,NULL PROCESS_ID,NULL PROCESS_STATUS,TO_CHAR(NULL) START_DATE_TIME,"
					+ " X.MODIFIED_BY_ID MODIFIED_BY_ID,TO_CHAR(NULL)STOP_DATE_TIME,NULL LAST_OUTBOUND_RETRIES,X.PROTOCOL_LINK,NULL,NULL,NULL,NULL,'N' COMM_STATUS"
					+ " FROM XH_COMM_CLIENT_APPLICATION X,XH_COMM_CLIENT Y ,XH_APPLICATION D,SM_FACILITY_PARAM S"
					+ " WHERE X.IN_USE_YN='Y'AND Y.OUTBOUND_YN='Y' AND X.CLIENT_ID  = Y.CLIENT_ID AND X.CLIENT_ID=NVL('"
					+ commclient
					+ "',X.CLIENT_ID) "
					+ " AND Y.IN_USE_YN='Y' AND X.COMM_TYPE='O' AND X.APPLICATION_ID=NVL('"
					+ applicationid
					+ "',X.APPLICATION_ID)  "
					+ " AND X.APPLICATION_ID=D.APPLICATION_ID AND (X.APPLICATION_ID, NVL('"
					+ commclient
					+ "',X.CLIENT_ID),NVL(X.PROTOCOL_LINK,'~')) NOT IN (SELECT APPLICATION_ID, CLIENT_ID,NVL(PROTOCOL_LINK,'~') FROM XH_COMM_PROCESS WHERE PROCESS_TYPE='O')";
*/
			String inboundsql = "SELECT DISTINCT A.CLIENT_ID ,B.CLIENT_NAME,A.APPLICATION_ID ,D.APPLICATION_NAME,"
					+ " A.PROCESS_ID,A.PROCESS_STATUS,TO_CHAR(A.START_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') "
					+ " START_DATE_TIME,A.STARTED_BY_ID,TO_CHAR(A.STOP_DATE_TIME,'DD/MM/YYYY HH24:MI:SS')STOP_DATE_TIME,"
					+ " A.LAST_OUTBOUND_RETRIES,C.PROTOCOL_LINK,P.PROTOCOL_TYPE,TO_CHAR(A.LAST_COMM_DATE_TIME,'DD/MM/YYYY HH24:MI:SS')LAST_COMM_DATE_TIME,A.LAST_MESSAGE_ID,A.TOTAL_MESSAGES,A.COMM_STATUS,A.ADDED_AT_WS_NO"
					+ " FROM XH_COMM_PROCESS A,XH_COMM_CLIENT B,XH_COMM_CLIENT_APPLICATION C ,XH_APPLICATION D,XH_PROTOCOL P,XH_PROTOCOL_LINK PL"
					+ " WHERE A.CLIENT_ID=NVL('"
					+ commclient
					+ "',A.CLIENT_ID) AND A.PROCESS_TYPE='I' "
					+ " AND A.APPLICATION_ID=NVL('"
					+ applicationid
					+ "',A.APPLICATION_ID)"
					+ " AND A.CLIENT_ID=B.CLIENT_ID AND A.CLIENT_ID=C.CLIENT_ID "
					+ " AND b.INBOUND_YN = 'Y' AND c.IN_USE_YN = 'Y' AND b.IN_USE_YN = 'Y' "
					+ " AND A.APPLICATION_ID=D.APPLICATION_ID "
					+ " AND A.APPLICATION_ID = C.APPLICATION_ID AND A.PROTOCOL_LINK=C.PROTOCOL_LINK"
					+ " AND C.PROTOCOL_LINK = PL.PROTOCOL_LINK_ID AND PL.PROTOCOL_ID = P.PROTOCOL_ID"
					+ " AND (A.APPLICATION_ID, A.START_DATE_TIME)  IN (SELECT APPLICATION_ID , MAX(START_DATE_TIME) FROM XH_COMM_PROCESS "
					+ " WHERE CLIENT_ID=NVL('"
					+ commclient
					+ "',CLIENT_ID) AND PROTOCOL_LINK=A.PROTOCOL_LINK AND PROCESS_TYPE ='I' GROUP BY  APPLICATION_ID,CLIENT_ID) "
					+ " UNION "
					+ " SELECT DISTINCT X.CLIENT_ID CLIENT_ID,Y.CLIENT_NAME CLIENT_NAME,X.APPLICATION_ID APPLICATION_ID,D.APPLICATION_NAME,NULL PROCESS_ID,NULL PROCESS_STATUS,TO_CHAR(NULL) START_DATE_TIME,"
					+ " X.MODIFIED_BY_ID MODIFIED_BY_ID,TO_CHAR(NULL)STOP_DATE_TIME,NULL LAST_OUTBOUND_RETRIES,X.PROTOCOL_LINK,NULL,NULL,NULL,NULL,'N' COMM_STATUS,NULL"
					+ " FROM XH_COMM_CLIENT_APPLICATION X,XH_COMM_CLIENT Y ,XH_APPLICATION D"
					+ " WHERE X.IN_USE_YN='Y'AND Y.INBOUND_YN='Y' AND X.CLIENT_ID  = Y.CLIENT_ID AND X.CLIENT_ID=NVL('"
					+ commclient
					+ "',X.CLIENT_ID) "
					+ " AND Y.IN_USE_YN='Y' AND X.COMM_TYPE='I' AND X.APPLICATION_ID=NVL('"
					+ applicationid
					+ "',X.APPLICATION_ID) "
					+ " AND X.APPLICATION_ID=D.APPLICATION_ID AND (X.APPLICATION_ID,NVL('"
					+ commclient
					+ "',X.CLIENT_ID),NVL(X.PROTOCOL_LINK,'~')) NOT IN (SELECT APPLICATION_ID,CLIENT_ID,NVL(PROTOCOL_LINK,'~') FROM XH_COMM_PROCESS WHERE PROCESS_TYPE='I')";

			queryMap = new HashMap();

			if (commtype == "" || commtype == null) {
				queryMap.put("outsql", outboundsql);
				queryMap.put("insql", inboundsql);
			} else if (commtype.equals("O")) {
				queryMap.put("outsql", outboundsql);
				queryMap.put("insql", null);
			} else if (commtype.equals("I")) {
				queryMap.put("outsql", null);
				queryMap.put("insql", inboundsql);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return queryMap;
	}

	/**
	 * used to construct the sql queries for getting values of inbound and
	 * outbound arrays
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap constructSqlCommProcess(String commclient,
			String applicationid, String commtype, String whereClause) {
		HashMap queryMap = null;
		try {
			String outboundsql = "SELECT DISTINCT A.CLIENT_ID ,B.CLIENT_NAME,A.APPLICATION_ID ,D.APPLICATION_NAME,A.PROCESS_ID,A.PROCESS_STATUS,TO_CHAR(A.START_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') "
					+ " START_DATE_TIME,A.STARTED_BY_ID,TO_CHAR(A.STOP_DATE_TIME,'DD/MM/YYYY HH24:MI:SS')STOP_DATE_TIME, "
					+ " A.LAST_OUTBOUND_RETRIES,C.PROTOCOL_LINK,P.PROTOCOL_TYPE,TO_CHAR(A.LAST_COMM_DATE_TIME,'DD/MM/YYYY HH24:MI:SS')LAST_COMM_DATE_TIME,A.LAST_MESSAGE_ID,A.TOTAL_MESSAGES,A.COMM_STATUS,A.ADDED_AT_WS_NO"
					+ " FROM XH_COMM_PROCESS A,XH_COMM_CLIENT B,XH_COMM_CLIENT_APPLICATION C ,XH_APPLICATION D,XH_PROTOCOL P,XH_PROTOCOL_LINK PL"
					+ " WHERE A.CLIENT_ID=NVL('"
					+ commclient
					+ "',A.CLIENT_ID) AND A.PROCESS_TYPE='O' "
					+ " AND A.APPLICATION_ID=NVL('"
					+ applicationid
					+ "',A.APPLICATION_ID)"
					+ whereClause
					+ " AND A.CLIENT_ID=B.CLIENT_ID AND A.CLIENT_ID=C.CLIENT_ID "
					+ " AND b.OUTBOUND_YN = 'Y' AND c.IN_USE_YN = 'Y' AND b.IN_USE_YN = 'Y' "
					+ " AND A.APPLICATION_ID=D.APPLICATION_ID"
					+ " AND A.APPLICATION_ID = C.APPLICATION_ID AND A.PROTOCOL_LINK=C.PROTOCOL_LINK"
					+ " AND C.PROTOCOL_LINK=PL.PROTOCOL_LINK_ID AND PL.PROTOCOL_ID=P.PROTOCOL_ID"
					+ " AND (A.APPLICATION_ID,A.START_DATE_TIME)  IN (SELECT APPLICATION_ID , MAX(START_DATE_TIME) FROM XH_COMM_PROCESS "
					+ " WHERE CLIENT_ID=NVL('"
					+ commclient
					+ "',CLIENT_ID) AND PROTOCOL_LINK=A.PROTOCOL_LINK AND PROCESS_TYPE ='O' GROUP BY  APPLICATION_ID,CLIENT_ID)";
				/*	+ " UNION "
					+ " SELECT DISTINCT X.CLIENT_ID CLIENT_ID,Y.CLIENT_NAME CLIENT_NAME,X.APPLICATION_ID APPLICATION_ID,D.APPLICATION_NAME,NULL PROCESS_ID,NULL PROCESS_STATUS,TO_CHAR(NULL) START_DATE_TIME,"
					+ " X.MODIFIED_BY_ID MODIFIED_BY_ID,TO_CHAR(NULL)STOP_DATE_TIME,NULL LAST_OUTBOUND_RETRIES,X.PROTOCOL_LINK,NULL,NULL,NULL,NULL,'N' COMM_STATUS"
					+ " FROM XH_COMM_CLIENT_APPLICATION X,XH_COMM_CLIENT Y ,XH_APPLICATION D,SM_FACILITY_PARAM S"
					+ " WHERE X.IN_USE_YN='Y'AND Y.OUTBOUND_YN='Y' AND X.CLIENT_ID  = Y.CLIENT_ID AND X.CLIENT_ID=NVL('"
					+ commclient
					+ "',X.CLIENT_ID) "
					+ " AND Y.IN_USE_YN='Y' AND X.COMM_TYPE='O' AND X.APPLICATION_ID=NVL('"
					+ applicationid
					+ "',X.APPLICATION_ID)  "
					+ " AND X.APPLICATION_ID=D.APPLICATION_ID AND (X.APPLICATION_ID, NVL('"
					+ commclient
					+ "',X.CLIENT_ID),NVL(X.PROTOCOL_LINK,'~')) NOT IN (SELECT APPLICATION_ID, CLIENT_ID,NVL(PROTOCOL_LINK,'~') FROM XH_COMM_PROCESS WHERE PROCESS_TYPE='O')";
*/
			String inboundsql = "SELECT DISTINCT A.CLIENT_ID ,B.CLIENT_NAME,A.APPLICATION_ID ,D.APPLICATION_NAME,"
					+ " A.PROCESS_ID,A.PROCESS_STATUS,TO_CHAR(A.START_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') "
					+ " START_DATE_TIME,A.STARTED_BY_ID,TO_CHAR(A.STOP_DATE_TIME,'DD/MM/YYYY HH24:MI:SS')STOP_DATE_TIME,"
					+ " A.LAST_OUTBOUND_RETRIES,C.PROTOCOL_LINK,P.PROTOCOL_TYPE,TO_CHAR(A.LAST_COMM_DATE_TIME,'DD/MM/YYYY HH24:MI:SS')LAST_COMM_DATE_TIME,A.LAST_MESSAGE_ID,A.TOTAL_MESSAGES,A.COMM_STATUS,A.ADDED_AT_WS_NO"
					+ " FROM XH_COMM_PROCESS A,XH_COMM_CLIENT B,XH_COMM_CLIENT_APPLICATION C ,XH_APPLICATION D,XH_PROTOCOL P,XH_PROTOCOL_LINK PL"
					+ " WHERE A.CLIENT_ID=NVL('"
					+ commclient
					+ "',A.CLIENT_ID) AND A.PROCESS_TYPE='I' "
					+ " AND A.APPLICATION_ID=NVL('"
					+ applicationid
					+ "',A.APPLICATION_ID)"
					+ whereClause
					+ " AND A.CLIENT_ID=B.CLIENT_ID AND A.CLIENT_ID=C.CLIENT_ID "
					+ " AND b.INBOUND_YN = 'Y' AND c.IN_USE_YN = 'Y' AND b.IN_USE_YN = 'Y' "
					+ " AND A.APPLICATION_ID=D.APPLICATION_ID "
					+ " AND A.APPLICATION_ID = C.APPLICATION_ID AND A.PROTOCOL_LINK=C.PROTOCOL_LINK"
					+ " AND C.PROTOCOL_LINK = PL.PROTOCOL_LINK_ID AND PL.PROTOCOL_ID = P.PROTOCOL_ID"
					+ " AND (A.APPLICATION_ID, A.START_DATE_TIME)  IN (SELECT APPLICATION_ID , MAX(START_DATE_TIME) FROM XH_COMM_PROCESS "
					+ " WHERE CLIENT_ID=NVL('"
					+ commclient
					+ "',CLIENT_ID) AND PROTOCOL_LINK=A.PROTOCOL_LINK AND PROCESS_TYPE ='I' GROUP BY  APPLICATION_ID,CLIENT_ID) "
					+ " UNION "
					+ " SELECT DISTINCT X.CLIENT_ID CLIENT_ID,Y.CLIENT_NAME CLIENT_NAME,X.APPLICATION_ID APPLICATION_ID,D.APPLICATION_NAME,NULL PROCESS_ID,NULL PROCESS_STATUS,TO_CHAR(NULL) START_DATE_TIME,"
					+ " X.MODIFIED_BY_ID MODIFIED_BY_ID,TO_CHAR(NULL)STOP_DATE_TIME,NULL LAST_OUTBOUND_RETRIES,X.PROTOCOL_LINK,NULL,NULL,NULL,NULL,'N' COMM_STATUS,NULL"
					+ " FROM XH_COMM_CLIENT_APPLICATION X,XH_COMM_CLIENT Y ,XH_APPLICATION D"
					+ " WHERE X.IN_USE_YN='Y'AND Y.INBOUND_YN='Y' AND X.CLIENT_ID  = Y.CLIENT_ID AND X.CLIENT_ID=NVL('"
					+ commclient
					+ "',X.CLIENT_ID) "
					+ " AND Y.IN_USE_YN='Y' AND X.COMM_TYPE='I' AND X.APPLICATION_ID=NVL('"
					+ applicationid
					+ "',X.APPLICATION_ID) "
					+ " AND X.APPLICATION_ID=D.APPLICATION_ID AND (X.APPLICATION_ID,NVL('"
					+ commclient
					+ "',X.CLIENT_ID),NVL(X.PROTOCOL_LINK,'~')) NOT IN (SELECT APPLICATION_ID,CLIENT_ID,NVL(PROTOCOL_LINK,'~') FROM XH_COMM_PROCESS WHERE PROCESS_TYPE='I')";

			queryMap = new HashMap();

			queryMap = new HashMap();

			if (commtype == null || commtype == "") {
				queryMap.put("outsql", outboundsql);
				queryMap.put("insql", inboundsql);
			} else if (commtype.equals("O")) {
				queryMap.put("outsql", outboundsql);
				queryMap.put("insql", null);
			} else if (commtype.equals("I")) {
				queryMap.put("outsql", null);
				queryMap.put("insql", inboundsql);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return queryMap;
	}

	/**
	 * used to get bound values(inbound or outbound) of gateway servers
	 * 
	 * @param modeType
	 * @param arrayType
	 * @return
	 */
	public Map<Integer, GatewayServiceBO> getBoundMaps(String modeType,
			String arrayType) {
		Map<Integer, GatewayServiceBO> outboundMap = null;
		Map<Integer, GatewayServiceBO> inboundMap = null;
		try {
			if ("outboundarray".equalsIgnoreCase(arrayType)) {

				if ((modeType.equalsIgnoreCase("F")) && (outsql != null)) {
					outboundMap = dataadapter.executeQuery(outsql, "O");
				}
				if ((modeType.equalsIgnoreCase("R")) && (outsql != null)) {
					outboundMap = dataadapter.executeQueryWithRemoteStatus(
							outsql, "O", modeofinstall);
				}
				return outboundMap;
			} else if ("inboundarray".equalsIgnoreCase(arrayType)) {

				if ((modeType.equalsIgnoreCase("F")) && (insql != null)) {
					inboundMap = dataadapter.executeQuery(insql, "I");
				}
				if ((modeType.equalsIgnoreCase("R")) && (insql != null)) {
					inboundMap = dataadapter.executeQueryWithRemoteStatus(
							insql, "I", modeofinstall);
				}
				return inboundMap;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * used to start outbound operation of gateway servers
	 * 
	 * @param outboundMap
	 * @param outboundArray
	 * @param selectedValues
	 * @return
	 */
/*	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<String> startOutboundGateways(
			Map<Integer, GatewayServiceBO> outboundMap,
			String[][] outboundArray, int[] selectedValues, String locale) {
		boolean gatewayStarted = true;
		String returnMsg = null;
		List<String> resultArrayList = null;
		String[] params = null;
		exh.remoteserver.CentralizedRemote remoteObject = null;
		try {
			if (enabledForSelectedOperation(outboundMap, selectedValues)) {
				String servicemode = "With Service";

				CentralizedRemoteOBjectClass object = new CentralizedRemoteOBjectClass();

				// used to have params to start the outbound operation of
				// gatewayserver
				HashMap hashmap = null;
				resultArrayList = new ArrayList<String>();

				for (Map.Entry<Integer, GatewayServiceBO> boEntry : outboundMap
						.entrySet()) {
					if (checkSelection(boEntry.getKey(), selectedValues)) {

						setParams(outboundArray, boEntry.getValue(),
								boEntry.getKey());

						int procId = dataadapter.getProcessId();
						monitorParams.processID = String.valueOf(procId);

						String hl7userid = "NAREN";
						String hl7password = "naren";
						// dataadapter.connectionSetter(); // to set connection
						params = new String[6];

						String rmiPort = dataadapter.getRMIPort(
								monitorParams.applicationID,
								monitorParams.clientID, "I");

						boolean isGatewayStarted = checkGatewayStatus(
								monitorParams.clientID, rmiPort);

						boolean dbConnExists = true;
						dbConnExists = checkGatewayDBConnection();
						if (!isGatewayStarted) {

							params = getGatewayParams(
									monitorParams.applicationID,
									monitorParams.clientID,
									monitorParams.protocolLinkID, "O",
									monitorParams.facilityID, hl7userid);

							hashmap = new HashMap();
							hashmap.put("applnId", monitorParams.applicationID);
							hashmap.put("facilityId", monitorParams.facilityID);
							hashmap.put("client_id", monitorParams.clientID);
							hashmap.put("commtype", "O");
							hashmap.put("out_dir", params[2]);
							hashmap.put("procId", procId);
							hashmap.put("db_string", params[3]);
							hashmap.put("user_id", hl7userid);
							hashmap.put("pass_word", hl7password);
							hashmap.put("retryinterval", "9999");
							hashmap.put("servicemode", servicemode);
							hashmap.put("protocolLinkID",
									monitorParams.protocolLinkID);
							hashmap.put("serviceName", getServiceName());

							remoteObject = (exh.remoteserver.CentralizedRemote) object
									.remoteObject(monitorParams.clientID,
											rmiPort);

							if (remoteObject != null) {
								String status = remoteObject
										.startHl7Gateway(hashmap);

								if (XHUtil.isSubstringExists(status,
										"Gateway Started Successfully")) {
									returnMsg = XHUtil.getLocaleMessage(locale,
											"XH0108", "XH");
									returnMsg = returnMsg.replace("$",
											params[5]);
									resultArrayList.add(returnMsg);
								}
							} else {
								gatewayStarted = false;
								returnMsg = getGatewayErrorMsg("Start")
										+ "Unable to find Remote Service !!";
								resultArrayList.add(returnMsg);
							}
						} else if (!dbConnExists) {
							gatewayStarted = false;
							returnMsg = getGatewayErrorMsg("Start")
									+ "Database connection does not exist !!";
							resultArrayList.add(returnMsg);
						} else if (isGatewayStarted) {
							gatewayStarted = false;
							returnMsg = getGatewayErrorMsg("Running");
							resultArrayList.add(returnMsg);
						}
					}
				}
				if (gatewayStarted) {
					resultArrayList.add(returnMsg);
				}
				return resultArrayList;
			} else {
				returnMsg = "NO gateway is selected to start..!!!!";
				resultArrayList = new ArrayList<String>();
				resultArrayList.add(returnMsg);
				return resultArrayList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			resultArrayList = new ArrayList<String>();

			if (ex instanceof java.rmi.ConnectException) {
				returnMsg = XHUtil.getLocaleMessage(locale, "XH0110", "XH");
				returnMsg = returnMsg.replace("$", params[5]);
				resultArrayList.add(returnMsg);
			} else {
				returnMsg = XHUtil.getLocaleMessage(locale, "XH1000", "XH");
				resultArrayList.add(returnMsg);
			}
		}
		return resultArrayList;
	}
*/
	/**
	 * used to start recording of inbound gateway servers
	 * 
	 * @param inboundMap
	 * @param inbounArray
	 * @param selectedValues
	 * @return
	 */
/*	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<String> startInboundGateways(
			Map<Integer, GatewayServiceBO> inboundMap, String[][] inbounArray,
			int[] selectedValues, String locale) {
		boolean gatewayStarted = true;
		String returnMsg = null;
		String[] params = null;
		List<String> resultArrayList = null;
		exh.remoteserver.CentralizedRemote remoteObject = null;
		try {
			if (enabledForSelectedOperation(inboundMap, selectedValues)) {
				String servicemode = "With Service";

				CentralizedRemoteOBjectClass object = new CentralizedRemoteOBjectClass();
				HashMap hashmap = null;
				resultArrayList = new ArrayList<String>();

				for (Map.Entry<Integer, GatewayServiceBO> boEntry : inboundMap
						.entrySet()) {
					if (checkSelection(boEntry.getKey(), selectedValues)) {

						// setting current selected server params
						setParams(inbounArray, boEntry.getValue(),
								boEntry.getKey());

						int procId = dataadapter.getProcessId();
						monitorParams.processID = String.valueOf(procId);

						params = new String[6];

						String hl7userid = "NAREN";
						String hl7password = "naren";

						String ipAddress = dataadapter.getIpAddress(
								monitorParams.applicationID,
								monitorParams.clientID, "I");

						String rmiPort = dataadapter.getRMIPort(
								monitorParams.applicationID,
								monitorParams.clientID, "I");

						boolean isGatewayStarted = checkGatewayStatus(
								ipAddress, rmiPort);

						if (!isGatewayStarted) {

							params = getGatewayParams(
									monitorParams.applicationID,
									monitorParams.clientID,
									monitorParams.protocolLinkID, "I",
									monitorParams.facilityID, hl7userid);

							hashmap = new HashMap();
							hashmap.put("applnId", monitorParams.applicationID);
							hashmap.put("facilityId", monitorParams.facilityID);
							hashmap.put("client_id", monitorParams.clientID);
							hashmap.put("commtype", "I");
							hashmap.put("out_dir", params[2]);
							// hashmap.put("out_dir","c:\\em-interface\\logs");
							hashmap.put("procId", procId);
							hashmap.put("db_string", params[3]);
							// hashmap.put("db_string",
							// "130.78.62.59:1521:SRDV");

							hashmap.put("user_id", hl7userid);
							hashmap.put("pass_word", hl7password);
							hashmap.put("retryinterval", "9999");
							hashmap.put("servicemode", servicemode);
							hashmap.put("protocolLinkID",
									monitorParams.protocolLinkID);
							hashmap.put("serviceName", getServiceName());

							remoteObject = (exh.remoteserver.CentralizedRemote) object
									.remoteObject(ipAddress, rmiPort);

							if (remoteObject != null) {
								String status = remoteObject
										.startHl7Gateway(hashmap);

								if (XHUtil.isSubstringExists(status,
										"Gateway Started Successfully")) {
									returnMsg = XHUtil.getLocaleMessage(locale,
											"XH0108", "XH");
									returnMsg = returnMsg.replace("$",
											monitorParams.clientName);
									resultArrayList.add(returnMsg);
								}
							} else {
								gatewayStarted = false;
								returnMsg = getGatewayErrorMsg("Start")
										+ "Unable to find Remote Service !!";
								resultArrayList.add(returnMsg);
							}
						} else if (isGatewayStarted) {
							gatewayStarted = false;
							returnMsg = getGatewayErrorMsg("Running")
									+ "already running !!";
							resultArrayList.add(returnMsg);
						}
					}
				}
				if (gatewayStarted) {
					resultArrayList.add(returnMsg);
				}
				return resultArrayList;
			} else {
				returnMsg = "No gateway is selected to start..!!!";
				resultArrayList = new ArrayList<String>();
				resultArrayList.add(returnMsg);
				return resultArrayList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			resultArrayList = new ArrayList<String>();

			if (ex instanceof java.rmi.ConnectException) {
				returnMsg = XHUtil.getLocaleMessage(locale, "XH0110", "XH");
				returnMsg = returnMsg.replace("$", monitorParams.clientName);
				resultArrayList.add(returnMsg);
			} else {
				returnMsg = XHUtil.getLocaleMessage(locale, "XH1000", "XH");
				resultArrayList.add(returnMsg);
			}
		}
		return resultArrayList;
	}
*/
	/**
	 * used to stop recording of outbound gateway servers
	 * 
	 * @param selectedValues
	 * @return
	 */
/*	public List<String> stopOutboundGateways(
			Map<Integer, GatewayServiceBO> outboundMap,
			String[][] outbounArray, int[] selectedValues) {
		boolean isGatewaysStopped = true;
		String returnMsg = null;
		List<String> resultArrayList = null;
		try {
			if (enabledForSelectedOperation(outboundMap, selectedValues)) {
				String servicemode = "With Service";

				for (Map.Entry<Integer, GatewayServiceBO> boEntry : outboundMap
						.entrySet()) {
					if (checkSelection(boEntry.getKey(), selectedValues)) {

						setParams(outbounArray, boEntry.getValue(),
								boEntry.getKey());
						boolean stopstatus = false;
						resultArrayList = new ArrayList<String>();

						stopstatus = dataadapter.setStopProcess(
								monitorParams.applicationID,
								monitorParams.facilityID,
								monitorParams.processID, "O", servicemode);

						String rmiPort = dataadapter.getRMIPort(
								monitorParams.applicationID,
								monitorParams.clientID, "O");

						String ipAddress = dataadapter.getIpAddress(
								monitorParams.applicationID,
								monitorParams.clientID, "I");

						if (stopstatus) {
							uninstallServices(ipAddress, rmiPort);
						} else {
							isGatewaysStopped = false;
							returnMsg = getGatewayErrorMsg("Stop");
							resultArrayList.add(returnMsg);
						}
					}
				}
				if (isGatewaysStopped) {
					returnMsg = "Selected gateways stopped successfully...";
					resultArrayList.add(returnMsg);
				}
				return resultArrayList;
			} else {
				returnMsg = "No gateways selected to stop..!!!";
				resultArrayList = new ArrayList<String>();
				resultArrayList.add(returnMsg);
			}
		} catch (Exception ex) {
			returnMsg = "Error in stopping the outbound operation on the system!!!!";
			ex.printStackTrace();
		}
		return resultArrayList;
	}
*/
	/**
	 * used to stop recording of inbound gateways
	 * 
	 * @param selectedValues
	 * @return
	 */
/*	public List<String> stopInboundGateways(
			Map<Integer, GatewayServiceBO> inboundMap, String[][] inbounArray,
			int[] selectedValues) {
		boolean isGatewaysStopped = true;
		String returnMsg = null;
		List<String> resultArrayList = null;
		try {

			if (enabledForSelectedOperation(inboundMap, selectedValues)) {
				String servicemode = "With Service";

				resultArrayList = new ArrayList<String>();
				for (Map.Entry<Integer, GatewayServiceBO> boEntry : inboundMap
						.entrySet()) {
					if (checkSelection(boEntry.getKey(), selectedValues)) {

						boolean stopstatus = false;
						// String hl7userid = "NAREN";
						// String hl7password = "NAREN";

						setParams(inbounArray, boEntry.getValue(),
								boEntry.getKey());

						stopstatus = dataadapter.setStopProcess(
								monitorParams.applicationID,
								monitorParams.facilityID,
								monitorParams.processID, "I", servicemode);

						String rmiPort = dataadapter.getRMIPort(
								monitorParams.applicationID,
								monitorParams.clientID, "I");

						String ipAddress = dataadapter.getIpAddress(
								monitorParams.applicationID,
								monitorParams.clientID, "I");

						if (stopstatus) {
							uninstallServices(ipAddress, rmiPort);
						} else {
							isGatewaysStopped = false;
							returnMsg = getGatewayErrorMsg("Stop");
							resultArrayList.add(returnMsg);
						}
					}
				}
				if (isGatewaysStopped) {
					returnMsg = "Selected gateways stopped successfully...";
					resultArrayList.add(returnMsg);
				}
				return resultArrayList;
			} else {
				returnMsg = "No inbound gateways selected to stop..!!!";
				resultArrayList = new ArrayList<String>();
				resultArrayList.add(returnMsg);
				return resultArrayList;
			}
		} catch (Exception ex) {
			returnMsg = "Error in stopping the inbound operation on the system!!!!";
			ex.printStackTrace();
		}
		return resultArrayList;
	}
*/
	/**
	 * used to stop the bound operation on the system
	 * 
	 * @param applicationID
	 * @param processID
	 */
/*	private void uninstallServices(String ipAddress, String rmiPort) {
		try {
			em.xh.remoteserver.CentralizedRemote remoteObject = null;
			String serviceName = null;

			CentralizedRemoteOBjectClass remObjClass = new CentralizedRemoteOBjectClass();

			remoteObject = (CentralizedRemote) remObjClass.remoteObject(
					ipAddress, rmiPort);

			if (remoteObject != null) {
				serviceName = remoteObject.checkServiceExists(getServiceName());
				String unString1 = remoteObject.uninstallWindowsService(
						serviceName + "_monitor", true);
				String unString2 = remoteObject.uninstallWindowsService(
						serviceName, false);

			}
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
*/
	/**
	 * used to get gateway error msgs
	 * 
	 * @param actionType
	 * @return
	 */
	private String getGatewayErrorMsg(String actionType) {
		String errorMsg = null;

		if ("Start".equalsIgnoreCase(actionType)) {
			errorMsg = monitorParams.protocolLinkName + " gateway @ "
					+ monitorParams.clientName + " not started... ";
		} else if ("Running".equalsIgnoreCase(actionType)) {
			errorMsg = monitorParams.protocolLinkName + " gateway @ "
					+ monitorParams.clientName + " already running !!";
		} else {
			errorMsg = "Failed to stop " + monitorParams.protocolLinkName
					+ " gateway @ " + monitorParams.clientName;
		}
		return errorMsg;
	}

	/**
	 * used to set params of current selected gateway
	 * 
	 * @param boundArray
	 * @param bo
	 * @param rowKey
	 */
	public void setParams(String[][] boundArray, GatewayServiceBO bo, int rowKey) {

		if (monitorParams == null)
			monitorParams = new CentralizedMonitorParams();

		monitorParams.processID = bo.getProcessID();
		monitorParams.clientName = bo.getClientName();
		monitorParams.protocolLinkName = bo.getProtocolLinkID();
		monitorParams.comType = bo.getComType();
		monitorParams.applicationID = (String) boundArray[rowKey][1];
		monitorParams.facilityID = (String) boundArray[rowKey][2];
		monitorParams.protocolLinkID = (String) boundArray[rowKey][4];
		monitorParams.clientID = (String) boundArray[rowKey][0];

	}

	/**
	 * used to check status of gateway
	 * 
	 * @return
	 */
/*	private boolean checkGatewayStatus(String ipAddress, String rmiPort) {
		boolean isGatewayExists = false;
		try {
			exh.remoteserver.CentralizedRemote remoteObject = null;
			String serviceName = null;

			CentralizedRemoteOBjectClass remObjClass = new CentralizedRemoteOBjectClass();

			remoteObject = (CentralizedRemote) remObjClass.remoteObject(
					ipAddress, rmiPort);

			if (remoteObject != null) {
				serviceName = remoteObject.checkServiceExists(getServiceName());
			}

			if (serviceName != null) {
				isGatewayExists = true;
				boolean isServiceRunning = remoteObject
						.checkServiceStatus(serviceName);

				if (!isServiceRunning) {
					boolean isServiceStarted = remoteObject
							.startService(serviceName);
					isGatewayExists = isServiceStarted;
				} else {
					isGatewayExists = true;
				}
			} else {
				isGatewayExists = dataadapter
						.checkGatewayStatus(monitorParams.processID);
			}
			// remoteObject = null;
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return isGatewayExists;
	}
*/
	/**
	 * used to get service name from db
	 * 
	 * @return
	 */
	private String getServiceName() {
		String dbName = getDBName(dataadapter.getDbString());
		String lCommType = "OB";
		String serviceName = null;
		try {

			if ("I".equals(monitorParams.comType)
					|| "inbound".equalsIgnoreCase(monitorParams.comType)) {
				lCommType = "IB";
			}
			serviceName = "EM" + SERVICENAME_SEPARATOR
					+ monitorParams.applicationID + SERVICENAME_SEPARATOR
					+ monitorParams.protocolLinkID + SERVICENAME_SEPARATOR
					+ lCommType + SERVICENAME_SEPARATOR + dbName.toUpperCase()
					+ SERVICENAME_SEPARATOR + monitorParams.processID;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return serviceName;

	}

	/**
	 * Methods to get the database sid from the db connection string set in
	 * xh_param. Used to build the windows service name
	 * 
	 * @param strTnsName
	 * @return database sid
	 */
	public static String getDBName(String strTnsName) {
		String dbName = null;
		int dbNameIndex = strTnsName.lastIndexOf(":") + 1;

		if (dbNameIndex == 0) {
			int serviceNameStart = strTnsName.lastIndexOf("SERVICE_NAME=") + 13;
			int serviceNameEnd = strTnsName.indexOf(")", serviceNameStart);
			dbName = strTnsName.substring(serviceNameStart, serviceNameEnd);
		} else {
			dbName = strTnsName.substring(strTnsName.lastIndexOf(":") + 1);
		}
		return dbName;
	}

	/**
	 * Method checks whether atleast a server is selected or not
	 * 
	 * @param checkArray
	 * @return
	 */
	public boolean enabledForSelectedOperation(
			Map<Integer, GatewayServiceBO> serviceMap, int[] selectedValues) {
		boolean isEnabled = false;
		try {
			for (int i = 0; i < selectedValues.length; i++) {
				if (serviceMap.containsKey(selectedValues[i])) {
					isEnabled = true;
					break;
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return isEnabled;
	}

	/**
	 * Method returns java.util.Date in the specified string format
	 */
	public String getFormattedStringDate(String format, java.util.Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
	}

	/**
	 * used to check whether the servers are selected or not
	 * 
	 * @param key
	 * @param selectedValues
	 * @return
	 */
	public Boolean checkSelection(int key, int[] selectedValues) {
		boolean isChecked = false;
		try {
			for (int i = 0; i < selectedValues.length; i++) {
				if (selectedValues[i] == key) {
					isChecked = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isChecked;
	}

	/**
	 * used to check db connection of gateways exists or not
	 * 
	 * @return
	 */
	public Boolean checkGatewayDBConnection() {
		boolean isExist = false;
		Connection con = null;
		try {
			con = ConnectionManager.getConnection();
			isExist = true;
		} catch (Exception e) {
			e.printStackTrace();
			isExist = false;
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return isExist;
	}

	/**
	 * 
	 * 
	 * @param chkstr
	 * @return
	 */
	public String checkNull(Object chkstr) {
		return (chkstr == null) ? new String("") : chkstr.toString();
	}

	/**
	 * used to get params for start & stop bound operations
	 * 
	 * @param appID
	 * @param clientID
	 * @param protocolLinkID
	 * @param commType
	 * @param facilityID
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public String[] getGatewayParams(String appID, String clientID,
			String protocolLinkID, String commType, String facilityID,
			String userName) throws Exception {
		CallableStatement ostmt = null;
		Connection dbConn = null;
		String[] params = new String[6];
		try {
			dbConn = ConnectionManager.getConnection();
			ostmt = dbConn
					.prepareCall("{ call get_gateway_startup_params(?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			ostmt.setString(1, appID);
			ostmt.setString(2, protocolLinkID);
			ostmt.setString(3, getIPAddress(clientID));
			ostmt.setString(4, facilityID);
			ostmt.setString(5, commType);
			ostmt.setString(6, userName);
			ostmt.registerOutParameter(7, java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(8, java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(9, java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(10, java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(11, java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(12, java.sql.Types.VARCHAR);
			ostmt.registerOutParameter(13, java.sql.Types.VARCHAR);
			ostmt.execute();

			params[0] = ostmt.getString(7);
			params[1] = ostmt.getString(8);
			params[2] = ostmt.getString(9);
			params[3] = ostmt.getString(10);
			params[4] = ostmt.getString(11);
			params[5] = ostmt.getString(13);
			String error = ostmt.getString(12);

			if (error == null) {
				dbConn.commit();
			}
		} catch (Exception exp) {
			exp.printStackTrace(System.err);
		} finally {
			XHUtil.closeDBResources(null, ostmt, dbConn);
		}
		return params;
	}

	/**
	 * used to get IP address of clientID of gatewayserver
	 * 
	 * @param clientID
	 * @return IPaddress
	 */
	public String getIPAddress(String clientID) {
		String ipAddress = null;
		Statement statement = null;
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = ConnectionManager.getConnection();
			String rssql = "select INBOUND_IP_ADDRESS from XH_COMM_CLIENT WHERE CLIENT_ID = '"
					+ clientID + "'";
			statement = connection.createStatement();
			rs = statement.executeQuery(rssql);
			while (rs.next()) {
				ipAddress = rs.getString(1);
			}
		} catch (SQLException exceptionSQL) {
			exceptionSQL.printStackTrace();
		} catch (Exception exceptionConnection) {
			exceptionConnection.printStackTrace();
		} finally {
			XHUtil.closeDBResources(rs, statement, connection);
		}
		return ipAddress;
	}
}
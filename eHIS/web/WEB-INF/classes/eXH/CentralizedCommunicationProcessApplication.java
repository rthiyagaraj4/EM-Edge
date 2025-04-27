package eXH;

import java.util.List;

/**
 * used to get the details of single selected gateway server
 * 
 * @author prajan5
 * 
 */
class CentralizedCommunicationProcessApplication {
	String appln;
	String comm_client;
	String comm_type;
	String sql;
	String protocolLinkID;

	CentralizedCommunicationProcessApplication(int rowKey) {
		setParams(rowKey);
	}

	/**
	 * used to set the sql queries
	 */
	public void fetch() {
		try {
			if (comm_type.equals("O")) {
				sql = "SELECT DECODE (A.PROCESS_STATUS ,'A','Active','W','Warming Up','S','Stopped','C','About To Stop'),"
						+ " A.PROCESS_ID,'Outbound',A.APPLICATION_ID,C.APPLICATION_NAME,NULL,NUll,A.CLIENT_ID,B.CLIENT_NAME,A.START_DATE_TIME,A.STOP_DATE_TIME,"
						+ " A.LAST_OUTBOUND_RETRIES,A.LAST_COMM_DATE_TIME,A.LAST_MESSAGE_ID,"
						+ " A.TOTAL_MESSAGES,A.TOTAL_QUERIES,A.STARTED_BY_ID,A.STOPPED_BY_ID,A.ADDED_AT_WS_NO,A.MODIFIED_AT_WS_NO,"
						+ " A.ADDED_FACILITY_ID,A.MODIFIED_FACILITY_ID,A.PROTOCOL_LINK,D.PROTOCOL_LINK_NAME "
						+ " FROM XH_COMM_PROCESS A, XH_COMM_CLIENT B,XH_APPLICATION C,XH_PROTOCOL_LINK D  "
						+ " WHERE A.APPLICATION_ID=NVL('"
						+ appln
						+ "',A.APPLICATION_ID) AND A.APPLICATION_ID=C.APPLICATION_ID "
						+
						// " AND  A.FACILITY_ID=NVL('"+facility+"',A.FACILITY_ID) AND  A.FACILITY_ID=D.FACILITY_ID "+
						" AND A.PROTOCOL_LINK=NVL('"
						+ protocolLinkID
						+ "',A.CLIENT_ID) AND A.PROTOCOL_LINK=D.PROTOCOL_LINK_ID"
						+ " AND A.CLIENT_ID=NVL('"
						+ comm_client
						+ "',A.CLIENT_ID) AND A.CLIENT_ID=B.CLIENT_ID "
						+ " AND A.PROCESS_TYPE=NVL('"
						+ comm_type
						+ "',A.PROCESS_TYPE) "
						+ " ORDER BY A.START_DATE_TIME DESC ";
			}
			if (comm_type.equals("I")) {
				sql = "SELECT DECODE (A.PROCESS_STATUS ,'A','Active','W','Warming Up','S','Stopped','C','About To Stop'),"
						+ " A.PROCESS_ID,'Inbound',A.APPLICATION_ID,C.APPLICATION_NAME,NULL,NULL,A.CLIENT_ID,B.CLIENT_NAME,A.START_DATE_TIME,A.STOP_DATE_TIME,"
						+ " A.LAST_OUTBOUND_RETRIES,A.LAST_COMM_DATE_TIME,A.LAST_MESSAGE_ID,"
						+ " A.TOTAL_MESSAGES,A.TOTAL_QUERIES,A.STARTED_BY_ID,A.STOPPED_BY_ID,A.ADDED_AT_WS_NO,A.MODIFIED_AT_WS_NO,"
						+ " A.ADDED_FACILITY_ID,A.MODIFIED_FACILITY_ID,A.PROTOCOL_LINK,D.PROTOCOL_LINK_NAME "
						+ " FROM XH_COMM_PROCESS A, XH_COMM_CLIENT B,XH_APPLICATION C,XH_PROTOCOL_LINK D "
						+ " WHERE A.APPLICATION_ID=NVL('"
						+ appln
						+ "',A.APPLICATION_ID) AND A.APPLICATION_ID=C.APPLICATION_ID "
						+
						// " AND  A.FACILITY_ID=NVL('"+facility+"',A.FACILITY_ID)  "+
						" AND A.PROTOCOL_LINK=NVL('"
						+ protocolLinkID
						+ "',A.CLIENT_ID) AND A.PROTOCOL_LINK=D.PROTOCOL_LINK_ID"
						+ " AND A.CLIENT_ID=NVL('"
						+ comm_client
						+ "',A.CLIENT_ID) AND A.CLIENT_ID=B.CLIENT_ID "
						+ " AND A.PROCESS_TYPE=NVL('"
						+ comm_type
						+ "',A.PROCESS_TYPE) "
						+ " ORDER BY A.START_DATE_TIME DESC ";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * used to get the values of selected gateway server
	 * 
	 * @return
	 */
	public List<GatewayServiceBO> getCommProcessAppValues() {
		CentralizedDataBaseAdapter dataAdapter = null;
		List<GatewayServiceBO> comProcessList = null;
		try {
			dataAdapter = new CentralizedDataBaseAdapter();
			comProcessList = dataAdapter.executeQueryForProcess(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comProcessList;
	}

	/**
	 * used to set the params of selected gateway servers
	 * 
	 * @param rowKey
	 */
	public void setParams(int rowKey) {
		try {
			comm_type = CentralizedDataBaseAdapter.communicationType;
			String outbound[][] = (String[][]) CentralizedDataBaseAdapter.outboundArray;
			String inbound[][] = (String[][]) CentralizedDataBaseAdapter.inboundArray;
			if (comm_type.equalsIgnoreCase("O")) {
				appln = (String) outbound[rowKey][1];
				comm_client = (String) outbound[rowKey][0];
				protocolLinkID = (String) outbound[rowKey][4];
			} else {
				comm_type = (String) inbound[rowKey][3];
				appln = (String) inbound[rowKey][1];
				comm_client = (String) inbound[rowKey][0];
				protocolLinkID = (String) inbound[rowKey][4];
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

} // end of class openDialog
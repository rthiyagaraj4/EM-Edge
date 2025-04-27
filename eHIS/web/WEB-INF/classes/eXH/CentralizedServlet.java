package eXH;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CentralizedServlet
 */
public class CentralizedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CentralizedServlet() {
		super();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gatewayOperation = null;
		String pageType = null;
		try {
			gatewayOperation = request.getParameter("gatewayoperation");
			pageType = request.getParameter("frame");

			if ("header".equalsIgnoreCase(pageType)) {

				if (gatewayOperation == null) { // default starting option
					RequestDispatcher rd = request
							.getRequestDispatcher("/eXH/jsp/GatewayInterfaceHeader.jsp");
					rd.forward(headerType(request, null), response);
				} else if ("refresh".equalsIgnoreCase(gatewayOperation)) {

					RequestDispatcher rd = request
							.getRequestDispatcher("/eXH/jsp/GatewayInterfaceHeader.jsp");
					rd.forward(headerType(request, "refresh"), response);

				} else if ("start".equalsIgnoreCase(gatewayOperation)) {
					RequestDispatcher rd = request
							.getRequestDispatcher("/eXH/jsp/DisplayGatewayResult.jsp");
					rd.forward(headerType(request, "start"), response);

				} else if ("stop".equalsIgnoreCase(gatewayOperation)) {
					RequestDispatcher rd = request
							.getRequestDispatcher("/eXH/jsp/DisplayGatewayResult.jsp");
					rd.forward(headerType(request, "stop"), response);
				} else if ("retrivegateway".equalsIgnoreCase(gatewayOperation)) {
					RequestDispatcher rd = request
							.getRequestDispatcher("/eXH/jsp/Centralizedcommunicationprocess.jsp");
					rd.forward(headerType(request, "retrivegateway"), response);
				}
			} else if ("body".equalsIgnoreCase(pageType)) { // default starting
															// option
				// this params for values of dropdown boxes in jsp
				String isQueryOnlyForTable = request
						.getParameter("isQueryOnly");
				if ("true".equalsIgnoreCase(isQueryOnlyForTable)) {

					RequestDispatcher rd = request
							.getRequestDispatcher("/eXH/jsp/GatewayInterfaceMonitorTable.jsp");
					rd.forward(bodyType(request, "true"), response);

				} else {
					RequestDispatcher rd = request
							.getRequestDispatcher("/eXH/jsp/GatewayInterfaceMonitorTable.jsp");
					rd.forward(bodyType(request, null), response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * This method is used to convert string array into integer array
	 * 
	 * @param convertArray
	 * @return
	 */
	private int[] convertStringToInt(String[] convertArray) {
		if (convertArray != null) {
			int[] tmpArray = new int[convertArray.length];
			int i = 0;
			try {
				if (convertArray.length > 0) {
					for (String str : convertArray) {
						tmpArray[i] = Integer.parseInt(str);
						i++;
					}
					i = 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tmpArray;
		}
		return null;
	}

	/**
	 * This method is used to handle the operations of header frame in
	 * GatewayMonitorApplication
	 * 
	 * @param request
	 * @param requestType
	 * @return
	 */
	private HttpServletRequest headerType(HttpServletRequest request,
			String requestType) {
		String commtypeArray[] = { "Outbound", "Inbound" };
		TreeMap<String, String> clientMap = null;
		TreeMap<String, String> applicationMap = null;
		TreeMap<String, String> facililtyMap = null;
		String applicaitonID = null;
		String facilityID = null;
		String clientID = null;
		String communicationType = null;
		CentralizedMonitorApplication centralizedMonApp = null;
		String gatewayID = null;
		Map<Integer, GatewayServiceBO> boundMap = null;
		String inboundArray[][] = null;
		String outboundArray[][] = null;

		try {
			if (requestType == null) { // default starting option
				centralizedMonApp = new CentralizedMonitorApplication();
				clientMap = centralizedMonApp.getClientMap();
				applicationMap = centralizedMonApp.getApplicationMap();
				facililtyMap = centralizedMonApp.getFacilityMap();
				applicaitonID = applicationMap.firstKey();
				facilityID = facililtyMap.firstKey();
				clientID = clientMap.firstKey();

				communicationType = "Outbound";

				request.setAttribute("clientmap", clientMap);
				request.setAttribute("applicationmap", applicationMap);
				request.setAttribute("facilitymap", facililtyMap);
				request.setAttribute("comType", communicationType);
				request.setAttribute("serverclientid", clientID);
				request.setAttribute("application", applicaitonID);
				request.setAttribute("facility", facilityID);

			} else if ("refresh".equalsIgnoreCase(requestType)) {
				clientID = request.getParameter("serverclientid");
				applicaitonID = request.getParameter("application");
				facilityID = request.getParameter("facility");
				communicationType = request.getParameter("selectedcommunimode");

				centralizedMonApp = new CentralizedMonitorApplication();

				clientMap = centralizedMonApp.getClientMap();
				applicationMap = centralizedMonApp.getApplicationMap();
				facililtyMap = centralizedMonApp.getFacilityMap();

				request.setAttribute("clientmap", clientMap);
				request.setAttribute("applicationmap", applicationMap);
				request.setAttribute("facilitymap", facililtyMap);
				request.setAttribute("communicationarray", commtypeArray);
				request.setAttribute("comType", communicationType);
				request.setAttribute("serverclientid", clientID);
				request.setAttribute("application", applicaitonID);
				request.setAttribute("facility", facilityID);

			} 
			/*else if ("start".equalsIgnoreCase(requestType)) {
				clientID = request.getParameter("serverclientid");
				applicaitonID = request.getParameter("application");
				facilityID = request.getParameter("facility");

				communicationType = request.getParameter("selectedcommunimode");

				centralizedMonApp = new CentralizedMonitorApplication();

				centralizedMonApp.fetch(applicaitonID, facilityID, clientID,
						communicationType);

				String locale = null;
				HttpSession session = request.getSession(false);
				Properties p = (Properties) session.getAttribute("jdbc");
				locale = XHDBAdapter.checkNull(p.getProperty("LOCALE"));

				int[] selectedKeys = convertStringToInt(request
						.getParameterValues("gatewayservers"));
				List<String> resultArrayList = null;

				if (selectedKeys != null && selectedKeys.length > 0) {
					if (communicationType.equalsIgnoreCase("outbound")
							|| communicationType == null) {

						boundMap = centralizedMonApp.getBoundMaps("R",
								"outboundarray");

						outboundArray = CentralizedDataBaseAdapter.outboundArray;

						resultArrayList = centralizedMonApp
								.startOutboundGateways(boundMap, outboundArray,
										selectedKeys, locale);
					} else {

						boundMap = centralizedMonApp.getBoundMaps("R",
								"inboundarray");
						inboundArray = CentralizedDataBaseAdapter.inboundArray;
						resultArrayList = centralizedMonApp
								.startInboundGateways(boundMap, inboundArray,
										selectedKeys, locale);
					}
				}
				else {
					resultArrayList = new ArrayList<String>();
					resultArrayList.add("No selected gateways!!!!");
				}
				request.setAttribute("comType", communicationType);
				request.setAttribute("serverclientid", clientID);
				request.setAttribute("application", applicaitonID);
				request.setAttribute("facility", facilityID);
				request.setAttribute("resultArrayList", resultArrayList);

			} else if ("stop".equalsIgnoreCase(requestType)) {
				centralizedMonApp = new CentralizedMonitorApplication();
				int[] selectedKeys = convertStringToInt(request
						.getParameterValues("gatewayservers"));
				List<String> resultArrayList = null;
				clientID = request.getParameter("serverclientid");
				applicaitonID = request.getParameter("application");
				facilityID = request.getParameter("facility");
				communicationType = request.getParameter("selectedcommunimode");

				centralizedMonApp.fetch(applicaitonID, facilityID, clientID,
						communicationType);

				if (selectedKeys != null && selectedKeys.length > 0) {
					if (communicationType.equalsIgnoreCase("outbound")) {

						boundMap = centralizedMonApp.getBoundMaps("R",
								"outboundarray");

						outboundArray = CentralizedDataBaseAdapter.outboundArray;

						resultArrayList = centralizedMonApp
								.stopOutboundGateways(boundMap, outboundArray,
										selectedKeys);
					} else {
						boundMap = centralizedMonApp.getBoundMaps("R",
								"inboundarray");

						inboundArray = CentralizedDataBaseAdapter.inboundArray;

						resultArrayList = centralizedMonApp
								.stopInboundGateways(boundMap, inboundArray,
										selectedKeys);
					}
				} else {
					resultArrayList = new ArrayList<String>();
					resultArrayList.add("No selected Gateways!!!!");
				}
				request.setAttribute("comType", communicationType);
				request.setAttribute("serverclientid", clientID);
				request.setAttribute("application", applicaitonID);
				request.setAttribute("facility", facilityID);
				request.setAttribute("resultArrayList", resultArrayList);

			}*/ 
			else if ("retrivegateway".equalsIgnoreCase(requestType)) {
				// used to retive the details of particular gateway
				CentralizedCommApplication commProcess = null;
				gatewayID = request.getParameter("gatewayserverID");
				clientID = request.getParameter("serverclientid");
				applicaitonID = request.getParameter("application");
				facilityID = request.getParameter("facility");

				communicationType = request.getParameter("selectedcommunimode");

				centralizedMonApp = new CentralizedMonitorApplication();

				centralizedMonApp.fetch(applicaitonID, facilityID, clientID,
						communicationType);

				if (communicationType != null) {

					if (communicationType.equalsIgnoreCase("inbound")) {
						boundMap = centralizedMonApp.getBoundMaps("R",
								"inboundarray");
					} else {
						boundMap = centralizedMonApp.getBoundMaps("R",
								"outboundarray");
					}
				}
				Set<Map.Entry<Integer, GatewayServiceBO>> gatewaySet = boundMap
						.entrySet();
				List<GatewayServiceBO> comProcessList = null;
				for (Map.Entry<Integer, GatewayServiceBO> gatewayMap : gatewaySet) {
					if (gatewayMap.getKey() == Integer.parseInt(gatewayID)) {
						// here facility id and names will be thrown to the
						// communication process....
						commProcess = new CentralizedCommApplication(
								gatewayMap.getKey());
						commProcess.fetch();

						comProcessList = commProcess.getCommProcessAppValues();
						request.setAttribute("commprocesslist", comProcessList);
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return request;
	}

	/**
	 * This method is used to handle the operations of body frame in
	 * GatewayMonitorApplication
	 * 
	 * @param request
	 * @param isQueryOnlyForTable
	 * @return
	 */
	private HttpServletRequest bodyType(HttpServletRequest request,
			String isQueryOnlyForTable) {
		String commtypeArray[] = { "Outbound", "Inbound" };
		String applicaitonID = null;
		String facilityID = null;
		String clientID = null;
		String communicationType = null;
		CentralizedMonitorApplication centralizedMonApp = null;
		String processType = null;

		Map<Integer, GatewayServiceBO> boundMap = null;

		if ("true".equalsIgnoreCase(isQueryOnlyForTable)) {
			Map<String, String> paramMap = new HashMap<String, String>();

			String startDateTime = null;
			String stopDateTime = null;
			String processStatus = null;
			String startedByID = null;
			String stoppedByID = null;
			String addedWorkStation = null;
			String addedFacilityID = null;
			String modifiedWS = null;
			String modifiedFacilityID = null;
			String protocolLink = null;
			String commStatus = null;
			String startedWSNo=null;
			String isQueryOnlyManual=null;

			String whereClause = "";
			String queryString = request.getQueryString();

			isQueryOnlyManual= (request.getParameter("isQueryOnlyManual") != null) ? request
					.getParameter("isQueryOnlyManual") : "";

			applicaitonID = (request.getParameter("applicationID") != null) ? request
					.getParameter("applicationID") : "";

			processType = (request.getParameter("processType") != null) ? request
					.getParameter("processType") : "";

			clientID = (request.getParameter("clientID") != null) ? request
					.getParameter("clientID") : "";

			if (request.getParameter("facilityID") != null
					&& (!request.getParameter("facilityID").equalsIgnoreCase(
							"*")) && request.getParameter("facilityID") != "*") {

				facilityID = request.getParameter("facilityID");

				whereClause = whereClause + " AND A.FACILITY_ID=NVL('"
						+ facilityID + "',A.FACILITY_ID)";
			}

			if (request.getParameter("start_dateTime") != null
					&& (!request.getParameter("start_dateTime")
							.equalsIgnoreCase("*"))
					&& request.getParameter("start_dateTime") != "*") {

				startDateTime = request.getParameter("start_dateTime");

				whereClause = whereClause
						+ " AND A.START_DATE_TIME=TO_DATE(NVL('"
						+ startDateTime
						+ "',TO_CHAR(A.START_DATE_TIME,'DD/MM/YYYY HH24:MI:SS')),'DD/MM/YYYY HH24:MI:SS')";
			}
			if (request.getParameter("stop_dateTime") != null
					&& (!request.getParameter("stop_dateTime")
							.equalsIgnoreCase("*"))
					&& request.getParameter("stop_dateTime") != "*") {

				stopDateTime = request.getParameter("stop_dateTime");
				whereClause = whereClause
						+ " AND A.STOP_DATE_TIME=TO_DATE(NVL('"
						+ stopDateTime
						+ "',TO_CHAR(A.STOP_DATE_TIME,'DD/MM/YYYY HH24:MI:SS')),'DD/MM/YYYY HH24:MI:SS')";
			}
			if (request.getParameter("processStatus") != null
					&& (!request.getParameter("processStatus")
							.equalsIgnoreCase("*"))
					&& request.getParameter("processStatus") != "*") {

				processStatus = request.getParameter("processStatus");

				whereClause = whereClause + " AND A.PROCESS_STATUS=NVL('"
						+ processStatus + "',A.PROCESS_STATUS)";
			}
			if (request.getParameter("startedByID") != null
					&& (!request.getParameter("startedByID").equalsIgnoreCase(
							"*")) && request.getParameter("startedByID") != "*") {

				startedByID = request.getParameter("startedByID");

				whereClause = whereClause + " AND A.STARTED_BY_ID=NVL('"
						+ startedByID + "',A.STARTED_BY_ID)";
			}
			if (request.getParameter("stoppedByID") != null
					&& (!request.getParameter("stoppedByID").equalsIgnoreCase(
							"*")) && request.getParameter("stoppedByID") != "*") {

				stoppedByID = request.getParameter("stoppedByID");

				whereClause = whereClause + " AND A.STOPPED_BY_ID=NVL('"
						+ stoppedByID + "',A.STOPPED_BY_ID)";
			}
			if (request.getParameter("addedWorkStation") != null
					&& (!request.getParameter("addedWorkStation")
							.equalsIgnoreCase("*"))
					&& request.getParameter("addedWorkStation") != "*") {

				addedWorkStation = request.getParameter("addedWorkStation");

				whereClause = whereClause + " AND A.ADDED_AT_WS_NO=NVL('"
						+ addedWorkStation + "',A.ADDED_AT_WS_NO)";
			}
			if (request.getParameter("addedFacilityID") != null
					&& (!request.getParameter("addedFacilityID")
							.equalsIgnoreCase("*"))
					&& request.getParameter("addedFacilityID") != "*") {

				addedFacilityID = request.getParameter("addedFacilityID");

				whereClause = whereClause + " AND A.ADDED_FACILITY_ID=NVL('"
						+ addedFacilityID + "',A.ADDED_FACILITY_ID)";
			}
			if (request.getParameter("modifiedWorkstation") != null
					&& (!request.getParameter("modifiedWorkstation")
							.equalsIgnoreCase("*"))
					&& request.getParameter("modifiedWorkstation") != "*") {

				modifiedWS = request.getParameter("modifiedWorkstation");

				whereClause = whereClause + " AND A.MODIFIED_AT_WS_NO=NVL('"
						+ modifiedWS + "',A.MODIFIED_AT_WS_NO)";
			}
			if (request.getParameter("modifiedFacilityID") != null
					&& (!request.getParameter("modifiedFacilityID")
							.equalsIgnoreCase("*"))
					&& request.getParameter("modifiedFacilityID") != "*") {

				modifiedFacilityID = request.getParameter("modifiedFacilityID");

				whereClause = whereClause + " AND A.MODIFIED_FACILITY_ID=NVL('"
						+ modifiedFacilityID + "',A.MODIFIED_FACILITY_ID)";
			}
			if (request.getParameter("protocolLink") != null
					&& (!request.getParameter("protocolLink").equalsIgnoreCase(
							"*"))
					&& request.getParameter("protocolLink") != "*") {

				protocolLink = request.getParameter("protocolLink");

				whereClause = whereClause + " AND A.PROTOCOL_LINK=NVL('"
						+ protocolLink + "',A.PROTOCOL_LINK)";
			}
			if (request.getParameter("commStatus") != null
					&& (!request.getParameter("commStatus").equalsIgnoreCase(
							"*")) && request.getParameter("commStatus") != "*") {

				commStatus = request.getParameter("commStatus");

				whereClause = whereClause + " AND A.COMM_STATUS=NVL('"
						+ commStatus + "',A.COMM_STATUS)";
			}
			
			if (request.getParameter("startedWSNo") != null
					&& (!request.getParameter("startedWSNo").equalsIgnoreCase(
							"*")) && request.getParameter("startedWSNo") != "*") {

				startedWSNo = request.getParameter("startedWSNo");

				whereClause = whereClause + " AND A.ADDED_AT_WS_NO=NVL('"
						+ startedWSNo + "',A.ADDED_AT_WS_NO)";
			}
			
			
			paramMap.put("applicationID", applicaitonID);
			paramMap.put("processType", processType);
			paramMap.put("clientID", clientID);
			paramMap.put("whereClause", whereClause);

			centralizedMonApp = new CentralizedMonitorApplication();
			centralizedMonApp.fetch(paramMap);
System.out.println("processType "+paramMap.get("processType"));
			if (paramMap.get("processType") != null
					&& paramMap.get("processType") != "") {
				if (paramMap.get("processType").equalsIgnoreCase("inbound")) {
					boundMap = centralizedMonApp.getBoundMaps("R",
							"inboundarray");
				} else if (paramMap.get("processType").equalsIgnoreCase(
						"outbound")) {
					boundMap = centralizedMonApp.getBoundMaps("R",
							"outboundarray");
				}
			} else {
				Map<Integer, GatewayServiceBO> sampleBoundMap = null;

				boundMap = centralizedMonApp.getBoundMaps("R", "inboundarray");

				sampleBoundMap = centralizedMonApp.getBoundMaps("R",
						"outboundarray");

				for (Integer sampleKey : sampleBoundMap.keySet()) {
					Integer newKey = boundMap.size();
					boundMap.put(newKey, sampleBoundMap.get(sampleKey));
				}
			}

			request.setAttribute("boundmap", boundMap);
			request.setAttribute("queryString", queryString);

			request.setAttribute("facilityID", facilityID);
			request.setAttribute("startDateTime", startDateTime);
			request.setAttribute("stopDateTime", stopDateTime);
			request.setAttribute("processStatus", processStatus);
			request.setAttribute("startedByID", startedByID);
			request.setAttribute("stoppedByID", stoppedByID);
			request.setAttribute("addedWorkStation", addedWorkStation);
			request.setAttribute("addedFacilityID", addedFacilityID);
			request.setAttribute("modifiedWS", modifiedWS);
			request.setAttribute("modifiedFacilityID", modifiedFacilityID);
			request.setAttribute("protocolLink", protocolLink);
			request.setAttribute("commStatus", commStatus);
			request.setAttribute("applicationID", applicaitonID);
			request.setAttribute("processType", processType);
			request.setAttribute("clientID", clientID);
			request.setAttribute("startedWSNo", startedWSNo);

			request.setAttribute("isQueryOnlyForTable", "true");
			request.setAttribute("isQueryOnlyManual", isQueryOnlyManual);

		} else {
			clientID = request.getParameter("serverclientid");
			applicaitonID = request.getParameter("application");
			facilityID = request.getParameter("facility");

			communicationType = request.getParameter("selectedcommunimode");

			centralizedMonApp = new CentralizedMonitorApplication();

			centralizedMonApp.fetch(applicaitonID, facilityID, clientID,
					communicationType);

			if (communicationType != null) {

				if (communicationType.equalsIgnoreCase("inbound")) {
					boundMap = centralizedMonApp.getBoundMaps("R",
							"inboundarray");
				} else {
					boundMap = centralizedMonApp.getBoundMaps("R",
							"outboundarray");
				}
			}
			request.setAttribute("boundmap", boundMap);
			request.setAttribute("communicationarray", commtypeArray);
			request.setAttribute("comType", communicationType);
			request.setAttribute("serverclientid", clientID);
			request.setAttribute("application", applicaitonID);
			request.setAttribute("facility", facilityID);
			request.setAttribute("isQueryOnlyForTable", isQueryOnlyForTable);
		}
		return request;
	}
}
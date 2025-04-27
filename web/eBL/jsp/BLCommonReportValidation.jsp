
<%@page import="eBL.Common.BlRepository"%>
<%@ page   import="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %> 
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%


	Connection con = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt= null ;
	ResultSet rst = null;
	System.err.println("1");
	String locale = (String)session.getAttribute("LOCALE"); 
	String facility_id = (String)session.getAttribute("facility_id"); 
	String func_mode = request.getParameter("func_mode") == null ? "" :request.getParameter("func_mode") ;
	Properties p = (Properties) session.getValue("jdbc");

	try{
		con = ConnectionManager.getConnection();
		con.setAutoCommit(false);
		if("interimChargeValidation".equalsIgnoreCase(func_mode)){	
			String reportSql = "{ call   bl_reports.val_epi_for_inter_draft_rep (?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String patientId = request.getParameter("patientId");
			String episodeType = request.getParameter("episodeType");
			String episodeId = request.getParameter("episodeId");
			String detailRepYn = request.getParameter("detailRepYn");
			String wsNo = p.getProperty("client_ip_address");
			String userId = p.getProperty("login_user");

			cstmt = con.prepareCall(reportSql);
			cstmt.setString(1, facility_id);
			cstmt.setString(2, locale);
			cstmt.setString(3, patientId);
			cstmt.setString(4, episodeType);
			cstmt.setString(5, episodeId);
			cstmt.setString(6, detailRepYn);
			cstmt.setString(7, wsNo);
			cstmt.setString(8, userId);
			cstmt.registerOutParameter(9, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(12, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(13, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(14, java.sql.Types.VARCHAR);
			cstmt.execute();
			
			String recalcYn = cstmt.getString(9);
			String sessionId = cstmt.getString(10);
			String reportId = cstmt.getString(11);
			String reportDate = cstmt.getString(12);
			String errorCode = cstmt.getString(13);
			String errorMsg = cstmt.getString(14);
			
			//HashMap map = new HashMap();
			String returnValue= "";
			if(errorCode == null && errorMsg == null){
				returnValue = recalcYn+"::##"+sessionId+"::##"+reportId+"::##"+reportDate;
				/*map.put("recalcYn", recalcYn);
				map.put("sessionId", sessionId);
				map.put("reportId", reportId);
				map.put("reportDate", reportDate);
				map.put("errorCode", "");
				map.put("errorMsg", "");*/
			}
			else{
				returnValue = errorCode+"::##"+errorMsg;
				/*map.put("errorCode", errorCode);
				map.put("errorMsg", errorMsg);*/
			}
			out.println(returnValue); 
		}
		else{
			String reportId = request.getParameter("p_report_id");
			String param1 = request.getParameter("param1");
			String param2 = request.getParameter("param2");
			String param3 = request.getParameter("param3");
			String param4 = request.getParameter("param4");
			String param5 = request.getParameter("param5");
			String param6 = request.getParameter("param6");
			String param7 = request.getParameter("param7");
			String param8 = request.getParameter("param8");
			String param9 = request.getParameter("param9");
			String param10 = request.getParameter("param10");
			String param11 = request.getParameter("param11");
			String param12 = request.getParameter("param12");
			String param13 = request.getParameter("param13");
			String param14 = request.getParameter("param14");
			String param15 = request.getParameter("param15");
			String param16 = request.getParameter("param16");
			String param17 = request.getParameter("param17");
			String param18 = request.getParameter("param18");
			String param19 = request.getParameter("param19");
			String param20 = request.getParameter("param20");
			String param21 = request.getParameter("param21");
			String param22 = request.getParameter("param22");			
			String param23 = request.getParameter("param23");
			String param24 = request.getParameter("param24");
			String param25 = request.getParameter("param25");
			String param26 = request.getParameter("param26");
			String param27 = request.getParameter("param27");
			String param28 = request.getParameter("param28");
			String param29 = request.getParameter("param29");
			String param30 = request.getParameter("param30");
			
			int session_id = 0;
			String pgm_date = "";
			String insertSql = BlRepository.getBlKeyValue("INSERT_SY_PROG_PARAM");
			cstmt = con.prepareCall(insertSql);
			cstmt.setString(1, facility_id);
			cstmt.setString(2, reportId);
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			cstmt.setString(5, param1);
			cstmt.setString(6, param2);
			cstmt.setString(7, param3);
			cstmt.setString(8, param4);
			cstmt.setString(9, param5);
			cstmt.setString(10, param6);
			cstmt.setString(11, param7);
			cstmt.setString(12, param8);
			cstmt.setString(13, param9);
			cstmt.setString(14, param10);
			cstmt.setString(15, param11);
			cstmt.setString(16, param12);
			cstmt.setString(17, param13);
			cstmt.setString(18, param14);
			cstmt.setString(19, param15);
			cstmt.setString(20, param16);
			cstmt.setString(21, param17);
			cstmt.setString(22, param18);
			cstmt.setString(23, param19);
			cstmt.setString(24, param20);
			cstmt.setString(25, param21);
			cstmt.setString(26, param22);
			cstmt.setString(27, param23);
			cstmt.setString(28, param24);
			cstmt.setString(29, param25);
			cstmt.setString(30, param26);
			cstmt.setString(31, param27);
			cstmt.setString(32, param28);
			cstmt.setString(33, param29);
			cstmt.setString(34, param30);
			cstmt.execute();
			
			session_id = cstmt.getInt(3);
			pgm_date = cstmt.getString(4);
			
			System.err.println("session_id->"+session_id);
			System.err.println("pgm_date->"+pgm_date);
			cstmt = null;
			con.commit();
			out.println(session_id+":::"+pgm_date);
			
		}
			
	}catch(Exception e){
		System.err.println("Err Msg from BillingCommonValidation.jsp "+e);
		con.rollback();
	}
	finally{
			ConnectionManager.returnConnection(con,request);
	}
%>


	

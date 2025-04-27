<%
/*
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201027            74212       MOHE-CRF-0050.2          Ram kumar S
-----------------------------------------------------------------------------------
*/
%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page   import="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %> 
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt= null;
	ResultSet rst = null;
	String locale = (String)session.getAttribute("LOCALE"); 
	//Added for BL-RBU-GHL-CRF-0034-US001
	String facility_id = request.getParameter("facility_id");
	//String facility_id = (String)session.getAttribute("facility_id"); 
	if(facility_id == null || facility_id.equals("")){
		facility_id = (String)session.getAttribute("facility_id"); 
	}
	

	System.out.println("TotalBillsForPeriod facility_id= "+facility_id);
	String func_mode = request.getParameter("func_mode") == null ? "" :request.getParameter("func_mode");
	Properties p = (Properties) session.getValue("jdbc");

	try{
		con = ConnectionManager.getConnection();
		con.setAutoCommit(false);
		if(func_mode.equals("TotalBillsForPeriod") || func_mode.equals("PriceListServices")){
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
			cstmt = null;
			con.commit();
			out.println(session_id+":::"+pgm_date);			
		}			
	}catch(Exception e){
		//System.err.println("Err Msg from BillingCommonValidation.jsp "+e);
		e.printStackTrace();
		con.rollback();
	}
	finally{
			ConnectionManager.returnConnection(con,request);
	}
%>

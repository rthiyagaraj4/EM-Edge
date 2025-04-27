<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eOR.Common.*, eRS.*" contentType="text/html;charset=ISO-8859-1"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>

<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	String  shift_code=request.getParameter("shift_code");
	PreparedStatement pstmt = null;
	ResultSet rs_shift_select = null;
	Connection conn =null;
	try{
		
		conn = ConnectionManager.getConnection(request);

		String shift_indicator = "";
		String appl_for_working_days = "";
		String appl_for_nonworking_days = "";
		String appl_for_holidays = "";
		String shift_start_time = "";
		String shift_end_time = "";
		String shift_mnemonic="";

		String qry_shift_select = "select shift_code,shift_indicator,appl_for_working_days, appl_for_nonworking_days, appl_for_holidays,to_char(shift_start_time,'hh24:mi') shift_start_time, to_char(shift_end_time,'hh24:mi') shift_end_time, mnemonic_key shift_mnemonic from am_shift where shift_code = ?";
		pstmt = conn.prepareStatement(qry_shift_select);
		pstmt.setString(1,shift_code);
		rs_shift_select = pstmt.executeQuery();
		
		while(rs_shift_select.next())
		{
			shift_indicator = rs_shift_select.getString("shift_indicator");
			appl_for_working_days = rs_shift_select.getString("appl_for_working_days");
			appl_for_nonworking_days = rs_shift_select.getString("appl_for_nonworking_days");
			appl_for_holidays = rs_shift_select.getString("appl_for_holidays");
			shift_start_time = rs_shift_select.getString("shift_start_time");
			shift_end_time = rs_shift_select.getString("shift_end_time");
			shift_mnemonic = rs_shift_select.getString("shift_mnemonic");
		}

		if(pstmt != null)
			pstmt.close();
		if(rs_shift_select !=null)
			rs_shift_select.close();

		out.println( "showValues(\"" + shift_indicator + "\",\"" + appl_for_working_days + "\",\"" + appl_for_nonworking_days + "\",\"" + appl_for_holidays + "\",\"" + shift_start_time + "\",\"" + shift_end_time + "\",\"" + shift_mnemonic + "\") ; " ) ;			

	}
	catch(Exception e)
	{
		out.println(e.getMessage());
		e.printStackTrace();
	}
	finally
	{
		if(pstmt != null)
			pstmt.close();
		if(rs_shift_select !=null)
			rs_shift_select.close();
		ConnectionManager.returnConnection(conn,request);
	}
%>

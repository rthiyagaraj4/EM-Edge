<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<%
		//unused variable, commented on 09/06/05
		//String params = request.getQueryString() ;
%>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
	-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eBL/js/BLCashCounterLogout.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		Connection con = null;
	    con=ConnectionManager.getConnection(request);
	    Statement stmt=null;
		ResultSet rset=null ;

		String facilityid  = (String) session.getValue("facility_id");
		String flag="";
		String sql="";

		String hide_common_toolbar="N";

		String params = request.getQueryString() ;
//		System.out.println(params);

		String called_frm = request.getParameter("called_frm");
		if(called_frm == null) called_frm="";
		if(called_frm.equals("DISC_FUN"))
		{
			hide_common_toolbar = "Y";
		}
		else
		{
			hide_common_toolbar = "N";
		}

		try
		{		 
			stmt=con.createStatement();
			sql="select CASH_CTR_LOGOUT_REP_IND from bl_parameters where OPERATING_FACILITY_ID ='"+facilityid+"' " ;
			rset=stmt.executeQuery(sql);

			if(rset.next())
			{
				flag=rset.getString("CASH_CTR_LOGOUT_REP_IND");
				if(flag==null) flag="";
			}
		
			if(flag.equals("D") && called_frm.equals("DISC_FUN"))
	        {
				out.println("<script>alert(getMessage('BL7358','BL'));parent.window.close();</script>");
			}
			else if(flag.equals("D") && !called_frm.equals("DISC_FUN"))
			{
				out.println("<script>alert(getMessage('BL7358','BL'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
			else
			{
%>
<head>
<%
		if(called_frm.equals("DISC_FUN"))
		{
%>
		<title><fmt:message key="eBL.CASH_COUNTER_LOGOUT.label" bundle="${bl_labels}"/></title>	
<%
		}
%>
</head>
<%
		if(hide_common_toolbar.equals("Y"))
		{
%>
		<!--<frameset rows='0,*,50'>-->
		<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
		<iframe name='bl_cashier_logout' id='bl_cashier_logout' 	src="../../eBL/jsp/BLLogoutCashCounterMain.jsp?<%=params%>" frameborder=0 scrolling='auto' noresize style='height:17vh;width:100vw'></iframe> 
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:83vh;width:100vw'></iframe> 
<%
		}
		else
		{
%>
		<!--<frameset rows='42,*,50'>-->
			<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<%
		}
%>
<!--		<frame name='bl_cashier_logout' id='bl_cashier_logout' 	src='BLCashierPopupWindow.jsp' frameborder=0 scrolling='auto' noresize>-->
			<iframe name='bl_cashier_logout' id='bl_cashier_logout' 	src="../../eBL/jsp/BLLogoutCashCounterMain.jsp?<%=params%>" frameborder=0 scrolling='auto' noresize style='height:83vh;width:100vw'></iframe> 
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:9vh;width:100vw'></iframe> 
	<!--</frameset>-->
<%
			}
		}
		catch (Exception e) 
		{ 
			//out.println(e) ; 
			e.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
		}
%>
</html>


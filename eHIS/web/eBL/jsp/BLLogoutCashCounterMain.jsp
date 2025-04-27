<!DOCTYPE html>
<%@ page  import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

	<title><fmt:message key="eBL.CASH_COUNTER_LOGOUT.label" bundle="${bl_labels}"/></title>
	<!--
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
		//sarathkumar added code make as siteSpecific GDOH-CRF-0117 beginning...
				Connection conn = null;	
				Boolean ss=false;
				try
				{
					conn = ConnectionManager.getConnection();	
					ss = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","HIDE_AMT_DETAILS_CASHLOGOUT");
					System.out.println("sarath bllogoutcashcountermain.jsp SiteSpec"+ss);
				}catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Exception in site specific "+e);
				}
				finally{
					ConnectionManager.returnConnection(conn);
					System.out.println("Conection closed");
				}
				session.setAttribute( "ssv", ss );
		//sarathkumar added code make as siteSpecific GDOH-CRF-0117 beginning...
		
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<iframe SRC="BLLogoutCashCounter.jsp?<%=request.getQueryString()%>" name='top_frame' id='top_frame' frameborder=0 scrolling='no' noresize style='height:15vh;width:100vw'></iframe>
<!--<iframe SRC="BLLogoutSlmtHeader.jsp" frameborder=0 name='header_frame' id='header_frame' scrolling='no' noresize></iframe>-->
<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='header_frame' id='header_frame' scrolling='AUTO' noresize style='height:8vh;width:100vw'></iframe>

<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='detail_frame' id='detail_frame' scrolling='AUTO' noresize style='height:50vh;width:100vw'></iframe>
<iframe SRC="BLLogoutSettlements2.jsp?<%=request.getQueryString()%>" frameborder=0 name='report_frame' scrolling='no' noresize style='height:22vh;width:100vw'></iframe>
<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='dummy_frame' id='dummy_frame' scrolling='no' noresize style='height:0vh;width:100vw'></iframe>

</html>


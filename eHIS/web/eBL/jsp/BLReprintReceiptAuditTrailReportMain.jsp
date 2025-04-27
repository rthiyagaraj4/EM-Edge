<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	   Edit History              Name     			Description
--------------------------------------------------------------------------------------------------------------
17-OCTOBER-2018      100           	Gayathri Ramachandran          Created
---------------------------------------------------------------------------------------------------------------
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
	<script language='javascript' src='../../eBL/js/BLReprintReceiptAuditTrail.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
		request.setCharacterEncoding("UTF-8");
		String url = "../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString();
		String source = url + params;
		System.out.println("Gayathri ->BLReprintReceiptAuditTrailReportMain.jsp: " + source);
	%>
</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%= source%>' frameborder=0 scrolling='no' style='height:6vh;width:100vw'></iframe><iframe name="reprintreceiptaudittrail" id="reprintreceiptaudittrail" SRC="../../eBL/jsp/BLReprintReceiptAuditTrailReport.jsp" frameborder=0 noresize style="height:90vh;width:100vw"></iframe>
	<iframe name="dummyFrame" id="dummyFrame"  src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:0vh;width:100vw'></iframe>			
	<iframe name="messageFrame" id="messageFrame"  src='../../eCommon/jsp/error.jsp' frameborder=0 noresize style='height:4vh;width:100vw'></iframe>

<body>
</body>
</html>


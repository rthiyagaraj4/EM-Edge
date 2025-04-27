<!DOCTYPE html>
<!--
File Name		: PlaceMealOrderOPSubmit.jsp
File Description:  Toolbar Frame : This file is for Placing OP Meal Order.
CRF#			: Bru-HIMS-CRF-230
Author			: Abirami
Date			: Aug-2013
-->
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<html>
<head>
	<% 
	    //Added Against MMS Vulnerability Issue - Starts
        request= new XSSRequestWrapper(request);
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Content-Type-Options", "nosniff");
	    //Added Against MMS Vulnerability Issue - Ends
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
					.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
					.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
				
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>		
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>	
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<title>
		<fmt:message key="eOT.messageFrame.Label" bundle="${ot_labels}" />
	</title>
</head>
<body>
	<input type="hidden" name="locationCode" id="locationCode" value='<%=request.getParameter("locationCode")%>' />
	<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0">
		<TR >
			<TD>
				<INPUT type="button" name="submit" id="submit" value="<fmt:message key="Common.apply.label" bundle="${common_labels}" />" onClick='parent.placeMealOrderEMMain.apply()' class="Button">
				<INPUT type="button" name="submit" id="submit" value="<fmt:message key="Common.reset.label" bundle="${common_labels}" />" class="Button" onClick='parent.reset()'>
				<INPUT type="button" name="close" id="close" value="<fmt:message key="Common.close.label" bundle="${common_labels}" />" class="Button" onClick='parent.OPclose();'>
			</TD>
		</TR>
	</table>
</body>
</html>


<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*,java.sql.*,java.util.*,java.net.*,java.text.*,eMP.PatSearch.*,webbeans.eCommon.*, javax.naming.*,javax.ejb.*,java.rmi.*,javax.rmi.*" %>
<html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8"); %>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<link type="text/css" rel="stylesheet" href="../../eIP/html/IPAdvBedMgmtStyle.css"/>
		<!-- <script src='../../eIP/js/IPAdvBedMgmtTrns.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" style='margin:0px;'>
		<table cellspacing=1 cellpadding=0 border='0' width='100%' height='100%'>	
		<tr class="COMMONTOOLBARFUNCTION">
			<td align="left" class="COMMONTOOLBARFUNCTION">
				Bed Management<div style='float:right'><img src='../../eCommon/images/disabled.gif' alt='menu' ></img></div>
			</td>
		</tr>
		</table>
	</body>


</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*" %>
<% 
request.setCharacterEncoding("UTF-8");

String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src="../../eMR/js/CreatePatientFile.js"></script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<table  border='1' width='100%'>
   <tr width='10%'>
		<td  align='left' style='BACKGROUND-COLOR:lightblue;' width='2%'>&nbsp;</td>
		<td  align='left' class='oalabel' ><font size=1>
				&nbsp;Recorded&nbsp;
	
		<td  align='left' style='BACKGROUND-COLOR:white;' width='2%'>&nbsp;</td>
		<td  align='left' class='oalabel' ><font size=1>
		&nbsp;Finalized&nbsp;


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


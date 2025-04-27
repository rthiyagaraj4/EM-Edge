<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	dit History     Name      	Rev.Date	Rev.Name	Description
-------------------------------------------------------------------------------------------------------------------
11/04/2019	IN069244	Ramya Maddena	 25/01/2019	Ramesh Goli	   MMS-KH-CRF-0005.1
01/11/2023      Srinivasa N T                                   Ramesh Goli         AAKH-CRF-0165
-------------------------------------------------------------------------------------------------------------------
*/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.*,java.sql.*, eCA.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>

<%
request.setCharacterEncoding("UTF-8");
String totDiscCount = request.getParameter("totDiscCount")==null?"0":request.getParameter("totDiscCount");
String graphMode=request.getParameter("graphMode")==null?"":request.getParameter("graphMode");
String disableString="disabled";
if(!"0".equals(totDiscCount))
	disableString="";
%>
<html>
<head>
<script language='javascript' src='../js/VitalSign.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="VitalSignButtonForm" id="VitalSignButtonForm">
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
    <tr >
       <td align="right" valign="middle">
	<%if((graphMode).equals("G")) {%>
		<input type='button' class='button' name='Record' id='Record' id='Record' value='Acknowledge' <%=disableString%> onclick ='ackResultGraph()'/>
		<input type='button' class='button' name='Delete' id='Delete' id='Delete' value='Delete' <%=disableString%> onclick ='updateGraph()'/>
		<input type='button' class='button' name='Critical' id='Critical' id='Critical' value='Critical' <%=disableString%> onclick ='criticalGraph()'/>	
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<%}else if((graphMode).equals("T")){ %>
		<input type='button' class='button' name='Record' id='Record' id='Record' value='Acknowledge' <%=disableString%> onclick ='ackResult()'/>
		<input type='button' class='button' name='Delete' id='Delete' id='Delete' value='Delete' <%=disableString%> onclick ='update()'/>
		<input type='button' class='button' name='Critical' id='Critical' id='Critical' value='Critical' <%=disableString%> onclick ='critical()'/>	
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<%}else{ %>
		<input type='button' class='button' name='Record' id='Record' id='Record' value='Acknowledge' <%=disableString%> onclick ='ackResultDT()'/>
		<input type='button' class='button' name='Delete' id='Delete' id='Delete' value='Delete' <%=disableString%> onclick ='updateDT()'/>
		<input type='button' class='button' name='Critical' id='Critical' id='Critical' value='Critical' <%=disableString%> onclick ='criticalDT()'/>	
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<%} %>
	</td>
    </tr>	
</table>
</form>
</body>
</html>


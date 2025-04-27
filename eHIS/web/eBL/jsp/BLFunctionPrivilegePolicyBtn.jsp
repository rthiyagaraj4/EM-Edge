<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
%>
<%request.setCharacterEncoding("UTF-8");
String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

String mode = checkForNull(request.getParameter("mode"));

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/BLFunctionPrivilegePolicy.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
var dataArray = new Array();
</script>
</head>
<body>
	<table width='95%'>
		<tr>
			<td width='74%'>
				&nbsp;
			</td>
			<td align='right' width='6%'>
				<%if("modify".equals(mode)){ %>
				<input type='button' class="BUTTON" value='Lookup'  onClick='fnShowLookup();'>
				<%}else{ %>
				&nbsp;
				<%} %>
			</td>
			<td align='right' width='8%'>
				<input type='button' class='BUTTON' value='Add' onclick='AddRow()'></td>
			<td width='2%'>
				&nbsp;
			</td>
			<td align='left'  width='10%'>
				<input type='button' style="visibility: hidden;" class='BUTTON' value='Save'  id='btnSave' onclick='persistData()'></td>
		</tr>
</table>
</body>
</html>


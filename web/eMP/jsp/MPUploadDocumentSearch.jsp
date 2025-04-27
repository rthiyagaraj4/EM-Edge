<!DOCTYPE html>
<!--Created by Ashwini on 16-Dec-2019 for AAKH-CRF-0079.11-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html>

<head>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script> 
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script> 
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
    <Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<script language='javascript' src="../js/MPUploadDocument.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
request.setCharacterEncoding("UTF-8");

String function_id = checkForNull(request.getParameter("function_id"));
String patient_id = checkForNull(request.getParameter("patient_id"));
String encounter_id = checkForNull(request.getParameter("encounter_id"));
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

try
{
	conn = ConnectionManager.getConnection(request);
	
	stmt = conn.createStatement();
	String pat_length = "";

	rs=stmt.executeQuery("select patient_id_length from mp_param");
	if (rs!=null && rs.next())
		pat_length = checkForNull(rs.getString(1));

	if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();

	if(pat_length == null || pat_length.equals("null")) pat_length = "10";

%>
    
<body onSelect="codeArrestThruSelect()" OnMouseDown="CodeArrest()" onKeyDown="lockKey()" <%if(function_id.equals("UPLOAD_DOC")){%>onLoad="LoadEncResult();"<%}%>>

	<form name='UploadDocumentSearchForm' id='UploadDocumentSearchForm' method='post' target='messageFrame'>

		<table cellpadding='2' cellspacing='0' width='80%' align='center' border='0'> 
			<tr><td colspan='6'>&nbsp;</td></tr>
			<tr>
				<td width='15%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> </td>
				<td width='20%' class="fields"><input type=text  name='PatientId' id='PatientId' <%if(function_id.equals("UPLOAD_DOC")){%>value='<%=patient_id%>' readonly<%}%> onBlur="makeValidString(this);ChangeUpperCase(this);validatePatientId(this);clearResult(this);" onKeypress='return CheckForSpecChars(event);' align="center" size="" maxlength=<%=pat_length%>><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img></td>

				<td colspan='1'>&nbsp;</td>

				<td width='20%' class='button'><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='searchResult();'>&nbsp;</td>
			</tr>
			<tr><td colspan='6'>&nbsp;</td></tr>
		</table>

		<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>"/>
		<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>"/>

    </form>

</body>

<%
}catch(Exception e)
{
	out.print(e.toString());
}
finally   
{
	if(conn != null)
	ConnectionManager.returnConnection(conn,request);
}
%>

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

</html>


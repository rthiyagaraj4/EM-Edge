<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ page  import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Clob,webbeans.eCommon.ConnectionManager,java.util.ArrayList" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src='../../eBL/js/PkgAdhocDiscount.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
<!--Added by lakshmi starts here for patient id length -->
<%
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs=null;
String PatIDLen = "";

try{
  con = ConnectionManager.getConnection(request);
	 String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
	 pstmt=con.prepareStatement(sqlLen);
	 rs=pstmt.executeQuery();
	 while(rs.next() && rs!=null)
	{
     PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
}
 catch(Exception ee){  
	   ee.printStackTrace();
	   System.err.println("exception 2 in OperationProcedureHdr.jsp "+ee);
 }finally{
	if(rs!=null) rs.close();
	if(pstmt !=null) pstmt.close();
	   ConnectionManager.returnConnection(con, request);
}

%>
<!--Added by lakshmi ends here for patient id length -->
	
<form name='frmPkgPatIdHeader' id='frmPkgPatIdHeader' >
	<table border='0' cellpadding='1' cellspacing='1' align='center' width='100%'>
	<tr>		
		<td class="label" width="25%"><b><fmt:message key="Common.patientId.label"   bundle="${common_labels}"/></b>
		<INPUT TYPE="TEXT"  name="patientId" id="patientId" SIZE="10" maxlength='<%=PatIDLen%>' VALUE=''  onKeyPress='changeToUpper();' onBlur="callPackageDetails(this);" ><input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return getPatID()" tabindex='2'><img src='../../eCommon/images/mandatory.gif'></td>

		<td width="25%"  class='labels'>
		<input type='button' class='button' onclick='callAuth()' name="auth_btn" id="auth_btn"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorization.label","common_labels")%>" ><td>
	</tr>
</table>
<input type= 'hidden' name="auth_discount" id="auth_discount"  value="">
</form>
</body>
</html>
<%
%>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>


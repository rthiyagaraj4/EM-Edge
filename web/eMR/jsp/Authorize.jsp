<!DOCTYPE html>
<html>
<!--
	Developed by		   :		Chitra
	Developed on	 	   :	 	01/01/2001
	Modified by      		   :	Parimala
	Modified Date	       :										-->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eMR/js/CreatePatientFile.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
</head>
<title>
<fmt:message key="eMR.EnterEditSensitiveDiagnosis.label" bundle="${mr_labels}"/>
</title>
<body onKeyDown="lockKey()">

<%

    Connection con = ConnectionManager.getConnection(request);
	PreparedStatement stmt=null;
	ResultSet rset=null ;

	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String loginuser=p.getProperty( "login_user" ) ;
%>
<form name= 'f' >
<%
try{
	String sen_diag="";
	StringBuffer sql  =new StringBuffer();
	sql.append("Select app_password.decrypt(SEN_DIAG_PASSWORD) password from mr_user_access_rights where appl_user_id =?");
	stmt=con.prepareStatement(sql.toString());
	stmt.setString(1,loginuser);
	rset=stmt.executeQuery();
	if(rset!=null && rset.next())
		sen_diag = rset.getString(1);
%>
	<table align="center" width="80%" border=0 cellspacing=0 cellpadding=0>
			<tr><td colspan=2 >&nbsp</tr>
			<tr>
					<td width="50%" align="right" class="label"><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
					 <td width="50%" align="left" colspan="2">&nbsp;&nbsp;
					<input type="password"  name="screen_passwd" id="screen_passwd" size="8" maxlength="8" ></td>

			</tr>
				<tr><td colspan=2 >&nbsp</tr>
			<tr>
					 <td width="50%" class='button' >
					 <input type='button' name='ok' id='ok' onClick="chkpasswd();" value='   <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>   '  class='button'>
					 <td width="50%" class='button' >&nbsp;&nbsp;
					 <input type='button' name='cancel' id='cancel' onClick="closeAuthorization();" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>'  class='button'>
					 </td>
			</tr>
			</table>
<input type="hidden" name="sen_diag" id="sen_diag" value="<%=sen_diag%>" >
<%
if(stmt!=null) stmt.close();
if(rset!=null) rset.close();

 } //end try
catch(Exception e )
{
	//out.println("Exception "+e.toString());
	e.printStackTrace();
}
finally{
		ConnectionManager.returnConnection(con,request);
}
%>
</form>
</body>
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


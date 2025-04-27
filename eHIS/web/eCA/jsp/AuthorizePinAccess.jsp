<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="JavaScript" src="../../eOR/js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	Connection con =null;

	

	String loginuser=(String) session.getValue( "login_user" ) ;
	
	//String facilityId = (String)session.getValue("facility_id");
	String pword="";
		
%>
<head>
	<title>Authorize Pin Form</title>

</head>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onload='document.getElementById("screen_passwd").focus()'>
		<form name='Authorize_form' id='Authorize_form' >
			<div align='center'><br>
<%
		try
		{
		con=ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rset=null ;	
		String sql  = " SELECT  (APP_PASSWORD.DECRYPT(PIN_NO)) PASSWORD FROM SM_APPL_USER WHERE APPL_USER_ID =  ?";
	
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,loginuser);
		//pstmt.setString(2,facilityId);
		rset=pstmt.executeQuery();
		while(rset.next()) {
			pword = rset.getString("PASSWORD");
		}

%>
			<table align="center" width="90%" border=0 cellspacing=0 cellpadding=3>
			<tr>
					<td align="center"><fmt:message key="Common.PIN.label" bundle="${common_labels}"/><!-- </td> -->
					<!--  <td width="50%" align="left" colspan="2"> -->
					<input type="password"  name="screen_passwd" id="screen_passwd" size="18" maxlength="18" onkeypress = 'return disallowEnterKey()' autocomplete="off"></td><!--41670 autocomplete="off"-->

			</tr>
				<tr><td colspan=3 >&nbsp&nbsp&nbsp</td></tr> 
			<tr>
					 <td align='center'>&nbsp&nbsp&nbsp&nbsp
					 <input type='button' name='ok' id='ok' onClick="chkpasswd();" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' class='button'><input type='button' name='cancel' id='cancel' onClick="closeAuthorization();" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button'>
					 </td>
			</tr>
			</table>

			<input type="hidden" name="appl_user_passwd" id="appl_user_passwd" value='<%=pword%>'>
<%
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
}
catch (Exception e)
{
	//out.println("Exception in  AuthorizePinAccess.jsp:"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if (con != null) ConnectionManager.returnConnection(con,request);
}

%>
</div>
</form>
</body>
</html>


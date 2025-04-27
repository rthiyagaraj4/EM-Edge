<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Anuradha.P
*	Created On		:	24 March 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@ page  language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, ,java.net.*,java.util.*, eCP.*, eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script language='javascript' src='../../eCP/js/FrequencyForIntervention.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>	
<%
Connection conn=null;
Statement stmt=null;
ResultSet rset=null;

String freq_desc="";
String freq_code="";
try{

conn = ConnectionManager.getConnection(request);
stmt=conn.createStatement();
//String sql="select freq_code,freq_desc from am_frequency where eff_status='E'";
String sql="SELECT freq_code,freq_desc FROM am_frequency_lang_vw WHERE eff_status='E' and language_id ='"+locale+"'";
rset=stmt.executeQuery(sql);
%>
<body  onload='FocusFirstElement()' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name=form_add_mod>
<table border='0' cellpadding='0' cellspacing='0' align='center' width="90%">
<tr><td colspan="5">&nbsp;</td></tr>
<tr>
<td width="25%"   class="label"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td><select name="frequency" id="frequency">
<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
if(rset!=null)
{
	while(rset.next())
	{
        freq_code=rset.getString("freq_code");
        freq_desc=rset.getString("freq_desc");
%>
<option value="<%=freq_code%>"><%=freq_desc%></option>
<%
	}
}
%>
</select>
</td>
<td colspan="2" align="right"><input type=button class=button value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='searchDetails()'>&nbsp;&nbsp;&nbsp;</td>
</tr>
<tr><td colspan="5">&nbsp;</td></tr>
</table>	
<%}catch(Exception e){
	//out.print(e);//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
}finally{
	if(rset!=null)
		rset.close();
	if(stmt!=null)
		stmt.close();
	if(conn != null)
		ConnectionManager.returnConnection(conn,request);

}
%>
</form>
</body>
</html>






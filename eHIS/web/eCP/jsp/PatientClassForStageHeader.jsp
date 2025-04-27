<!DOCTYPE html>
<SCRIPT LANGUAGE="JavaScript">
<!--

//-->
</SCRIPT><%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.* " %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String locale=(String)session.getAttribute("LOCALE");
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language="JavaScript" src="../../eCommon/js/common.js"></script>
  <script language="javascript" src="../js/PatientClassForStage.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
      Connection conn 	      = null;
	  Statement stagestmt = null;
	  ResultSet stagers		  = null;
	  String stagesql="";
	  String stage_code="";
	  String stage_desc="";
%>
<body onMouseDown="CodeArrest()"  onload='FocusFirstElement()' onKeyDown="lockKey()" >
<form name="PatientClassForStage_Form" id="PatientClassForStage_Form">
<br>
<table border='0' cellpadding='0' cellspacing='0' align='center' width="87%">
<tr><td colspan="4">&nbsp</td></tr>
<tr>
<td align="right" class="label" width="15%">&nbsp;&nbsp;&nbsp&nbsp;&nbsp;Stage&nbsp;</td>
<td align="left" class="label" width="36%">&nbsp;&nbsp;
<select name="Stage_code" id="Stage_code" onchange='clearDetails();'>
<option value=" " selected> &nbsp&nbsp--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
<%
try
   {
     conn = ConnectionManager.getConnection(request);
	stagestmt=conn.createStatement();
    stagesql=" select stage_code ,long_desc from cp_stage_lang_vw where eff_status = 'E' AND language_id='"+locale+"' order by long_desc ";
	stagers=stagestmt.executeQuery(stagesql);
    if(stagers!=null)
    {
		while(stagers.next())
		{
     		stage_code=stagers.getString("stage_code");
			stage_desc=stagers.getString("long_desc");
%>
<option value="<%=stage_code%>"><%=stage_desc%></option>
<%
		}
	}
%>
</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
</td>
<td colspan="2" align="right"><input type=button class=button value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='searchDetails()'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td>
</tr>
<tr><td colspan="4">&nbsp</td></tr>
</table>	
 <%}catch(Exception e)
	{
		//out.println("Error is ---"+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
finally
  {
			if (stagers != null) stagers.close();
			if (stagestmt != null) stagestmt.close();
			ConnectionManager.returnConnection(conn,request);
  }
%>
</form>
</body>
</html>





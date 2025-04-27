<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:
*	Created By		:	Hema Malini B
*	Created On		:	30th Dec 2004
-->

<!--StageAddModify.jsp-->

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eCP.*,eCommon.XSSRequestWrapper" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, com.ehis.eslp.* ,java.net.*" contentType="text/html; charset=UTF-8" %>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
//This file is saved on 18/10/2005.
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCP/js/Stage.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
  String mode=request.getParameter("mode");
  String code=request.getParameter("stage_code");  

  Connection con=null;
 // Statement stmt=null;
  PreparedStatement pstmt	= null;
  ResultSet rs=null;

  String enable="";
  String readOnly="";
  String disable="";
  String select1="";
  String select2="";
  String select3="";
  String select4="";

	String long_desc  =  "";
	String short_desc  =  "";
	String stage_indicator = "";
	String eff_status = "";
	String query="";

%>

<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="FocusFirstElement()">
<form name="Stage_form" id="Stage_form" action="../../servlet/eCP.StageServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR>
 <table border="0" cellpadding="0" cellspacing="0" width="80%" align='center'>
<% 
if (mode.equals("1"))
{
  %>
  <tr>
  <td colspan="5">&nbsp;</td>
  </tr>

  <tr>
      <td  align="right" class="label" width="35%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td  align="left" >
      &nbsp;&nbsp;&nbsp;<input type="text" name="stage_code" id="stage_code" size="4" maxlength="4" onBlur='ChangeUpperCase(this);' onKeyPress="return CheckForSpecChars(event)"> &nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
      </td>
    </tr>

    <tr>
	  <td colspan="5">&nbsp;</td>
  </tr>

    <tr>
      <td  align="right" class="label" width="35%"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td  align="left" >&nbsp;&nbsp;&nbsp;<input type="text" name="long_desc" id="long_desc" size="30" maxlength="30" onBlur='makeValidString(this)' >&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>

     <tr>
	 <td colspan="5">&nbsp;</td>
  </tr>

    <tr>
      <td  align="right" class="label" width="35%"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td align="left" >&nbsp;&nbsp;&nbsp;<input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" onBlur='makeValidString(this)'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>

   <tr>
 <td colspan="5">&nbsp;</td>
  </tr>

  <tr>
  <td  align="right" class="label" width="35%"><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
  <td  align="left" class="label" >&nbsp&nbsp&nbsp<select name="stage_indicator" id="stage_indicator" >
    	  <option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
    	  <option value="01"><fmt:message key="eCP.PreAdmit.label" bundle="${cp_labels}"/></option>
	  	  <option value="02"><fmt:message key="eCP.PostAdmit.label" bundle="${cp_labels}"/></option>
	  	  <option value="03"><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/></option>
	  	  <option value="04"><fmt:message key="eCP.PostDischarge.label" bundle="${cp_labels}"/></option>
	  </select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
  
  </td>
  <tr>
 <td colspan="5">&nbsp;</td>
  </tr>

	<tr>
	<td  align="right" class="label" width="35%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    <td  align="left" >&nbsp;&nbsp;<input type="checkbox" name="eff_status" id="eff_status" value="E" checked>&nbsp;</td>
    </tr>

   <tr>
   <td colspan="5">&nbsp;</td>
  </tr>
  </table>

  <% }else if(mode.equals("2")){

  try
 {
	 con = ConnectionManager.getConnection(request);
	 //stmt=con.createStatement(); 
     code=request.getParameter("stage_code")==null? "":request.getParameter("stage_code");

	//query="select short_desc,long_desc,stage_indicator,eff_status from cp_stage where stage_code='"+code+"'";
	query="select short_desc,long_desc,stage_indicator,eff_status from cp_stage where stage_code=?";
			pstmt = con.prepareStatement( query);
			pstmt.setString(1,code);
	// rs=stmt.executeQuery(query);
	rs=pstmt.executeQuery();
	 rs.next();


	long_desc  = rs.getString("long_desc")==null ? "":rs.getString("long_desc");
	short_desc  = rs.getString("short_desc")==null ? "":rs.getString("short_desc");
	stage_indicator = rs.getString("stage_indicator")==null?"":rs.getString("stage_indicator");
	eff_status = rs.getString("eff_status")==null ? "D":rs.getString("eff_status");



if(stage_indicator.equals("01"))
	select1="selected";
else
	select1="";
if(stage_indicator.equals("02"))
	select2="selected";
else
	select2="";
if(stage_indicator.equals("03"))
	select3="selected";
else
	select3="";
if(stage_indicator.equals("04"))
	select4="selected";
else
	select4="";

if(eff_status.equals("E"))
{
	enable="checked";
	disable="";
    readOnly="";
}
else
{
	enable="";
	disable="disabled";
    readOnly="readonly";
}
   %>

  <table border="0" cellpadding="0" cellspacing="0" width="80%" align='center'>

  <tr>
  <td colspan="5">&nbsp;</td>
  </tr>

  <tr>
      <td  align="right" class="label" width="35%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td  align="left" >
      &nbsp;&nbsp;&nbsp;<input type="text" name="stage_code" id="stage_code" size="4" maxlength="4" onBlur="ChangeUpperCase(this);" onKeyPress="return CheckForSpecChars(event)" readonly value="<%=code%>"> &nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
      </td>
    </tr>

    <tr>
	  <td colspan="5">&nbsp;</td>
  </tr>
   
   <tr>
      <td  align="right" class="label" width="35%"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td  align="left" >&nbsp;&nbsp;&nbsp;<input type="text" name="long_desc" id="long_desc" size="30" maxlength="30" onBlur='makeValidString(this)' style='{ font-size: ;}' value="<%=long_desc%>" <%=readOnly%> >&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>

     <tr>
	 <td colspan="5">&nbsp;</td>
  </tr>

    <tr>
      <td  align="right" class="label" width="35%"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td align="left" >&nbsp;&nbsp;&nbsp;<input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" onBlur='makeValidString(this)' value="<%=short_desc%>" <%=readOnly%>>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>

   <tr>
 <td colspan="5">&nbsp;</td>
  </tr>

  <tr>
  <td  align="right" class="label" width="35%"><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
  <td  align="left" class="label"  >&nbsp<select name="stage_indicator" id="stage_indicator" <%=disable%> onChange="onChangeIndicator(this)" >
    	  <option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
    	  <option value="01" <%=select1%> ><fmt:message key="eCP.PreAdmit.label" bundle="${cp_labels}"/></option>
	  	  <option value="02" <%=select2%> ><fmt:message key="eCP.PostAdmit.label" bundle="${cp_labels}"/></option>
	  	  <option value="03" <%=select3%> ><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/></option>
	  	  <option value="04" <%=select4%> ><fmt:message key="eCP.PostDischarge.label" bundle="${cp_labels}"/></option>
	  </select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>  
  </td>
  <tr>
 <td colspan="5">&nbsp;</td>
  </tr>

	<tr>
	<td  align="right" class="label" width="35%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    <td  align="left" >&nbsp;&nbsp;<input type="checkbox" name="eff_status" id="eff_status" <%=enable%> value="<%=eff_status%>" onclick="oneffStatusCheck()">&nbsp;</td>
    </tr>

   <tr>
   <td colspan="5">&nbsp;</td>
  </tr>	 
	   
  </table>
	  <input type="hidden" name="stage_indicator1" id="stage_indicator1" value="<%=stage_indicator%>">
  
   <% 
   }catch(Exception e)
  {
	//out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();
  }
  finally {
  	  if (rs != null)   rs.close();
	  if (pstmt != null) pstmt.close();
	  ConnectionManager.returnConnection(con,request);
	}
  }
   %>

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
</form>

</body>
</html>


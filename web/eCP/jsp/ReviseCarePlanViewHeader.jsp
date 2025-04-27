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
*	Created By		:	Sandhya
*	Created On		:	21 Mar 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*,webbeans.eCommon.*,java.net.*,java.text.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
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
        <SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
		<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
		<SCRIPT language='javascript' src='../../eCommon/js/FieldFormatMethods.js' ></SCRIPT>
		<SCRIPT language="javascript" src="../js/ReviseCarePlan.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</HEAD>
<BODY onKeyDown = 'lockKey()'  OnMouseDown="CodeArrest()">
<FORM name="formReviseCareplanHeader" id="formReviseCareplanHeader">
<%
	String care_plan_id=request.getParameter("care_plan_id");
	String md_care_plan_id=request.getParameter("md_care_plan_id")==null ? "" :request.getParameter("md_care_plan_id");
	String cp_start_date=com.ehis.util.DateUtils.convertDate(request.getParameter("cp_start_date"),"DMYHM","en",locale);
	String cp_target_date=com.ehis.util.DateUtils.convertDate(request.getParameter("cp_target_date"),"DMYHM","en",locale);
	String cp_day_no=request.getParameter("cp_day_no");
	// Added by Kiran Kumar MS on 17  APril 2005
	String careManagerName = request.getParameter("careManagerName") == null ? "" :request.getParameter("careManagerName");
	int total = 0;
	PreparedStatement psSelect = null;
	Connection con = null;
	ResultSet rs = null;	
	try
	{
	 con = ConnectionManager.getConnection(request);
	 psSelect = con.prepareStatement("select count(*) from cp_pat_care_plan_revision where md_care_plan_id = ? and care_plan_id = ? ");
	 psSelect.setString(1,md_care_plan_id);
	 psSelect.setString(2,care_plan_id);	
	 rs = psSelect.executeQuery();
	 while(rs.next())
	{
		total = rs.getInt(1);
	}
	if(rs != null)rs.close();
	if(psSelect != null)psSelect.close();	
		
%>
<TABLE  border='0' cellpadding='0' cellspacing='0' align='center'  width='100%' >
<tr>
	<TD   colspan='2' class="label"><fmt:message key="eCP.CareManager.label" bundle="${cp_labels}"/></TD>
	<TD  class="label" colspan='2'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></TD>
	<TD  class="label" colspan='2'><fmt:message key="Common.days.label" bundle="${common_labels}"/>#</TD>
	<TD  class="label" colspan='2'><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></TD>
	<TD align="left"  class="label" colspan='0'><fmt:message key="eCP.NoofRevns.label" bundle="${cp_labels}"/></TD>
</tr>
<TR>
	<TD  class="label" colspan='2'><B><%=careManagerName%></B></TD>
	<TD  class="label" colspan='2'><B><%=cp_start_date%></B></TD>
	<TD   class="label" colspan='2'><B><%=cp_day_no%></B></TD>
	<TD   class="label" colspan='2'><B><%=cp_target_date%></B></TD>
	<TD   class="label" colspan='0'><B><%=total%></B></TD>
</TR>
<!-- <TR>
	<TD COLSPAN="10">&nbsp;</TD>
</TR> -->
</TABLE>
<TABLE border='0' cellpadding=0 cellspacing='0' align='center'  width='100%'> 
		<TH width="15%" align="left"><fmt:message key="Common.status.label" bundle="${common_labels}"/></TH>
		<TH width="3%">&nbsp;</TH>
		<TH align="left">&nbsp;&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></TH>
		<TH width="17%" align="left"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></TH>
		<TH width="18%" align="left"><fmt:message key="eCP.TargetDate.label" bundle="${cp_labels}"/></TH>
</TABLE>
</FORM>
<%
 }
catch(Exception ee)
{
	//out.println("Exception from ReviseCarePlanViewHeader.jsp :"+ee.toString());//COMMON-ICN-0181
          ee.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(rs!=null)
		rs.close();
	if(psSelect!=null)
		psSelect.close();
	if(con != null)ConnectionManager.returnConnection(con);
}
%>
</BODY>
</HTML>


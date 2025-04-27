<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- AssessmentBasedTerminologyCodeHeader.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sandhya
*	Created On		:	02 Feb 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*,eOR.Common.*" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, com.ehis.eslp.* ,java.net.*"%>


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
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
      	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
      	<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
		<SCRIPT language="javascript" src="../js/TermCodeLookup.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	 </HEAD>
<%

String libraryid=request.getParameter("libraryid");
String versionno=request.getParameter("versionno");
Connection connection				  =	null;
Statement stmt							  =	null;
ResultSet rs								  =	null;
String terminologySetQuery		  =	"Select term_Set_id,term_set_desc from mr_term_set where eff_status = 'E' order by term_set_desc ";
  try
			{
				connection = ConnectionManager.getConnection(request);
				stmt			=	connection.createStatement();

%>
<BODY   onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<FORM name="formTermCodeCriteria" id="formTermCodeCriteria">
		<TABLE border='0' cellspacing='0' cellpadding='0' align='center' width='99%'>
		<TR>
			<TD align="right" class="label"><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></TD>
			<TD align="left" colspan="3">&nbsp;&nbsp;
				<SELECT name="terminologySet" id="terminologySet" onchange="getLevels(this)">
					<OPTION value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</OPTION>
			<%
					rs=stmt.executeQuery(terminologySetQuery);
					while(rs!=null && rs.next()){
			%>
					<OPTION value="<%=(String)rs.getString(1)%>"><%=(String)rs.getString(2)%></OPTION>
			<%
				}
			%>
				</SELECT>
				<IMG src="../../eCommon/images/mandatory.gif"></IMG>
			</TD>
			</TR>
			<TR>
				<TD align="right" class="label"><fmt:message key="Common.type.label" bundle="${common_labels}"/></TD>
				<TD align="left" colspan="3">&nbsp;&nbsp;
					<SELECT name="type" id="type">
						<OPTION value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</OPTION>
					</SELECT>
				</TD>
		</TR>
		<TR>
			<TD align="right" class="label"><fmt:message key="eCP.ClassificationLevel.label" bundle="${cp_labels}"/></TD>
			<TD align="left" colspan="3">&nbsp;&nbsp;
				<SELECT name="classificationLevel" id="classificationLevel">
					<OPTION value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</OPTION>
				</SELECT>
		</TR>
		<TR>
			<TD align="right" class="label"><fmt:message key="Common.TerminologyCode.label" bundle="${common_labels}"/></TD>
			<TD align="left" colspan="3">&nbsp;&nbsp;
				<INPUT type="text" name="terminologyCode" id="terminologyCode"  size="30" maxlength="30">
		</TR>
		<TR>
			<TD align="right" class="label"><fmt:message key="Common.TerminologyCodeDescription.label" bundle="${common_labels}"/></TD>
			<TD align="left">&nbsp;&nbsp;
				<INPUT type="text" name="terminologydesc" id="terminologydesc"  size="50" maxlength="50"></TD>
				<TD align="right" class="label"><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></TD>
				<TD align="left">&nbsp;&nbsp;
					<select name="search_criteria" id="search_criteria">
						<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
						<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
						<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
					
					</select>
				</TD>
		</TR>

		<TR>
			<TD colspan="3" align="right">
					<input class='button' type=button name="search_button" id="search_button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchDetails()'>
			</TD>
			<TD  align="left">&nbsp;&nbsp;
					<input class='button' type=button name="reset_button" id="reset_button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetForm(this.form)" >
			</TD>
		</TR>
			
		 </TABLE>	
			 <input type="hidden" name="libraryid" id="libraryid" value="<%=libraryid%>">
			<input type="hidden" name="versionno" id="versionno" value="<%=versionno%>">
 </FORM>
</BODY>
			 <%
	  }catch(Exception e){
		  //out.println("Error is--->"+e);//common-icn-0181
		  e.printStackTrace();//COMMON-ICN-0181
	  }
	finally
	{
			if(rs != null){ rs.close(); }
			if(stmt != null){ stmt.close(); }
		  ConnectionManager.returnConnection(connection,request);
	}
%> 
		 </HTML>


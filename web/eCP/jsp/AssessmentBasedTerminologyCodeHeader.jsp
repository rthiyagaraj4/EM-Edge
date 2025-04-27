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
*	Created On		:	24 Jan 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.* " %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, com.ehis.eslp.* ,java.net.*,eOR.Common.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="TerminologyCode" class="webbeans.eCommon.RecordSet" scope="session"/> 

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
		 //This file is saved on 18/10/2005.
		 request.setCharacterEncoding("UTF-8");
		 String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
      	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
      	<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
	    <SCRIPT language='javascript' src='../../eCommon/js/CommonLookup.js'></SCRIPT>
		<SCRIPT language="JavaScript" src="../../eCP/js/AssessmentBasedTerminologyCode.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%
TerminologyCode.clearAll();
Connection connection				  =	null;
PreparedStatement pstmt							  =	null;
ResultSet rs								  =	null;
String assessmentCategoryQuery =	"select assess_catg_code, long_desc from cp_assess_catg_lang_vw where eff_status = 'E' and language_id='"+locale+"' order by long_desc";
String terminologySetQuery		  =	"Select term_Set_id,term_set_desc from mr_term_set where eff_status = 'E' order by term_set_desc ";
  try
			{
				connection = ConnectionManager.getConnection(request);
				pstmt			=	connection.prepareStatement(terminologySetQuery);

%>
<BODY   onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<FORM name="formAssessmentBasedTerminologyCode" id="formAssessmentBasedTerminologyCode">
		<TABLE border='0' cellspacing='6' cellpadding='0' align='center' width='102%'>
			<TR>
				<TD align="right" class="label"><fmt:message key="eCP.AssessmentCategory.label" bundle="${cp_labels}"/></TD>
				<TD align="left">&nbsp;&nbsp;
					<INPUT type="text" name="assessmentCategory" id="assessmentCategory" size="30" maxlength="30"><input class='button' type=button name="assessementCategoryButton" id="assessementCategoryButton" value="?" onclick="viewAssessmentCategory(assessmentCategory);" >
					<INPUT type="hidden" name="assessmentCategoryCode" id="assessmentCategoryCode" value="">
					<IMG src="../../eCommon/images/mandatory.gif"></IMG>
				</TD>
		</TR>
		<TR>
			<TD align="right" class="label"><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></TD>
			<TD align="left">&nbsp;&nbsp;
				<SELECT name="terminologySet" id="terminologySet" onchange="getLevels(this)">
					<OPTION value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</OPTION>
			<%
					rs=pstmt.executeQuery();
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
				<TD align="left">&nbsp;&nbsp;
					<SELECT name="type" id="type">
						<OPTION value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</OPTION>
					</SELECT>
				</TD>
		</TR>
			<TR>
			<TD align="right" class="label"><fmt:message key="eCP.ClassificationLevel.label" bundle="${cp_labels}"/></TD>
			<TD align="left">&nbsp;&nbsp;
				<SELECT name="classificationLevel" id="classificationLevel">
					<OPTION value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</OPTION>
				</SELECT>
				<IMG src="../../eCommon/images/mandatory.gif"></IMG>
			</TR>
			<TR>
			<TD></TD>
			<TD></TD>
				<TD><input class='button' type=button name="search_button" id="search_button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchDetails()'>
				</TD>
			</TR>
			
		 </TABLE>	
	<INPUT type="hidden" name="assessmentCategoryQuery" id="assessmentCategoryQuery" value="<%=assessmentCategoryQuery%>">
	<INPUT type="hidden" name="AchkAll" id="AchkAll" value="">
	<INPUT type="hidden" name="BchkAll" id="BchkAll" value="">
	<INPUT type="hidden" name="CchkAll" id="CchkAll" value="">
	<INPUT type="hidden" name="DchkAll" id="DchkAll" value="">
	<INPUT type="hidden" name="EchkAll" id="EchkAll" value="">
	<INPUT type="hidden" name="FchkAll" id="FchkAll" value="">
	 <INPUT type="hidden" name="GchkAll" id="GchkAll" value="">
	 <INPUT type="hidden" name="HchkAll" id="HchkAll" value="">
	 <INPUT type="hidden" name="IchkAll" id="IchkAll" value="">
	 <INPUT type="hidden" name="JchkAll" id="JchkAll" value="">
	 <INPUT type="hidden" name="KchkAll" id="KchkAll" value="">
	 <INPUT type="hidden" name="LchkAll" id="LchkAll" value="">
	 <INPUT type="hidden" name="MchkAll" id="MchkAll" value="">
	 <INPUT type="hidden" name="NchkAll" id="NchkAll" value="">
	<INPUT type="hidden" name="OchkAll" id="OchkAll" value="">
	 <INPUT type="hidden" name="PchkAll" id="PchkAll" value="">
	 <INPUT type="hidden" name="QchkAll" id="QchkAll" value="">
	 <INPUT type="hidden" name="RchkAll" id="RchkAll" value="">
	 <INPUT type="hidden" name="SchkAll" id="SchkAll" value="">
	 <INPUT type="hidden" name="TchkAll" id="TchkAll" value="">
	 <INPUT type="hidden" name="UchkAll" id="UchkAll" value="">
	 <INPUT type="hidden" name="VchkAll" id="VchkAll" value="">
	 <INPUT type="hidden" name="WchkAll" id="WchkAll" value="">
	 <INPUT type="hidden" name="XchkAll" id="XchkAll" value="">
	 <INPUT type="hidden" name="YchkAll" id="YchkAll" value="">
	 <INPUT type="hidden" name="ZchkAll" id="ZchkAll" value="">
	 <INPUT type="hidden" name="chkAll" id="chkAll" value="">
	 <input type="hidden" name="locale" id="locale" value="<%=locale%>">
	 <INPUT type="hidden" name="AssociatedchkAll" id="AssociatedchkAll" value="Y">


		 

	  </FORM>
	 </BODY>
			 <%
	  }catch(Exception e){
		  out.println("Error is--->"+e);
	  }
	finally
	{
			if(rs != null){ rs.close(); }
			if(pstmt != null){ pstmt.close(); }
		  ConnectionManager.returnConnection(connection,request);
	}
%> 
		 </HTML>


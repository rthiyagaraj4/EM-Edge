<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-----------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------------------------------------------------------------
02/08/2016    IN032686		Raja S											Build Library>The Associated term Code cannot be viewed and no 																				goals Can be linked to the term code
-----------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sandhya
*	Created On		:	02 Feb 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.net.* ,java.text.*,eOR.Common.*"%>

<jsp:useBean id="BuildLibraryTermCode" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="BuildLibrary" class="webbeans.eCommon.RecordSet" scope="session"/>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
		<%
		//This file is saved on 18/10/2005.
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

      	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
      	<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
		<SCRIPT language="javascript" src="../js/BuildLibrary.js"></SCRIPT> 
</HEAD>

<BODY onKeyDown = 'lockKey()' OnMouseDown="CodeArrest()">
<FORM name="TerminologycodeDetailForm" id="TerminologycodeDetailForm">
<%
	String versionno				=		request.getParameter("versionno");
	String libraryid				=		request.getParameter("libraryid");
	String tableName				=		"";
//	HashMap TermSetList				=		new HashMap();
	ArrayList TermCode				=		null;
	String termCode					=		"";
	String termDesc					=		"";
	String  tempTermSet				=		"";
	String termSet					=		"";
	String classValue				=		"";
	String ChkAttribute				=		"";
	String from						=		request.getParameter("from");
	String 	to						=		request.getParameter("to");
	int maxRecords					=		0;
	int start						=		0 ;
	int end							=		0 ;
	int tempCounter					=		1;
	String applicableStatus			=		"";
	
	if(from==null)
		start	 =	 0;
	else
		start	 =	Integer.parseInt(from);
		
	if(to==null)
		end	=12;
	else
		end	=	Integer.parseInt(to);
		
	//ArrayList sessionList				=		(ArrayList)BuildLibraryTermCode.getRecordSetHandle();
	/*if(sessionList.size()>0)
	{
		TermSetList=(HashMap)BuildLibraryTermCode.getObject(0);
	}*/
	
	ArrayList sessionList1				=		(ArrayList)BuildLibrary.getRecordSetHandle();
	if(sessionList1.size()>0)
	{
		TermCode=(ArrayList)BuildLibrary.getObject(0);
	}

	maxRecords				=	TermCode.size()/7;
	
%>
	<TABLE border="0" cellpadding="0" cellspacing="0" width="90%" align="center">
		<TR>
		<TD width="80%" class="white">&nbsp;</TD>
		<TD width="20%" class="white">&nbsp;</TD>
		<TD align="right">
<%
// IN032686 Start.
/*		if ( !(start <= 1) )
		out.println("<label onClick='navigation(document.TerminologycodeDetailForm,\"previous\")'  style='cursor:pointer;color:blue'><fmt:message key=\"Common.previous.label\" bundle=\"${common_labels}\"/></label>&nbsp;&nbsp;");
		
		if ( !( (start+12) > maxRecords ) )
		out.println("<td align='right'><label onClick='navigation(document.TerminologycodeDetailForm,\"next\")'  style='cursor:pointer;color:blue'><fmt:message key=\"Common.next.label\" bundle=\"${common_labels}\"/></label>");
*/ 
		if ( !(start <= 1) )
		{%>
		<label onClick='navigation(document.TerminologycodeDetailForm,"previous")'  style='cursor:pointer;color:blue'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;
		<%}
		
		if ( !( (start+12) >= maxRecords ) )
		{%>
		<td align='right'><label onClick='navigation(document.TerminologycodeDetailForm,"next")'  style='cursor:pointer;color:blue'><fmt:message key="Common.next.label" bundle="${common_labels}"/></label>
		<%}
//IN032686 Ends
	%>
	</TD></TR></TABLE>
	<%
		if(maxRecords>0){
	%>
		<TABLE border='1' cellspacing='0' cellpadding='0' align='center' width='102%'>
			<TH width="20%"><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></TH>
			<TH><fmt:message key="Common.TerminologyCode.label" bundle="${common_labels}"/></TH>
			<TH width="10%">&nbsp;</TH>
			<TH width="10%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></TH>
	<%
			for ( int i=0; i<TermCode.size(); i=i+7) {
				if( (start==0 && tempCounter<=end) || (tempCounter>start && tempCounter<=end)) {

					if((tempCounter%2) == 1)
						classValue = "QRYODD";
					else
						classValue =	"QRYEVEN";

					  termSet			=	(String)TermCode.get(i);
					  termCode			=	(String)TermCode.get(i+1);	
					  termDesc			=	(String)TermCode.get(i+5);	
					  applicableStatus	=	(String)TermCode.get(i+3);
					  tableName			=	(String)TermCode.get(i+6);

					   if(applicableStatus.equals("Y")){
						  ChkAttribute="checked";
					  }else{
						  ChkAttribute="";
					  }

		%>
		<TR>
	<%if(!termSet.equals(tempTermSet)) {
				tempTermSet	=	termSet;
	%>
					<TD align="left" class="<%=classValue%>"><%=termSet%></TD>
	<%}else{%>
					<TD class="<%=classValue%>">&nbsp;</TD>
	<%}%>
		<TD align="left" class="<%=classValue%>"><%=termDesc%></TD>
		<TD align="center" class="<%=classValue%>"><label  onclick ="ShowGoalDialog('<%=termSet%>','<%=termCode%>','<%=termDesc%>','<%=libraryid%>','<%=versionno%>','<%=tableName%>')"style='cursor:pointer;color:Blue;font:11'><fmt:message key="eCP.Goal.label" bundle="${cp_labels}"/></label></TD>
		<TD align="center" class="<%=classValue%>"><INPUT type="checkbox"  <%=ChkAttribute%>  name="Select" value="<%=termCode%>" onclick="updateValueTermCode(this,'<%=termSet%>')"></TD>
	</TR>
	<%
	 
			if(tempCounter>=end)
				break;
		
		}
		tempCounter++;
		tableName="";
		
	}
		}
	%>
	</TABLE>
	<input type="hidden" name="start" id="start"     value="<%=start%>">
	<input type="hidden" name="end" id="end"		  value="<%=end%>">
	<input type="hidden" name="libraryid" id="libraryid" value="<%=libraryid%>">
	<input type="hidden" name="versionno" id="versionno" value="<%=versionno%>">
	<input type="hidden" name="tableName" id="tableName" value="<%=tableName%>">

	</FORM>
	</BODY>
	

			


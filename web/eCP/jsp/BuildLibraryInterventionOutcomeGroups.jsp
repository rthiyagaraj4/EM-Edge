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
*	Created On		:	10 Feb 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%> 
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*,java.net.*,java.text.*, eOR.Common.*" %>

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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</HEAD>
<%
	
	String termSet			=	request.getParameter("termSet");
	String termCode			=	request.getParameter("termCode");
	String goalCode			=	request.getParameter("goalCode");
	String libraryid		=	request.getParameter("libraryid");
	String versionno		=	request.getParameter("versionno");
	String tableName		=	request.getParameter("tableName");
	String alphalink		=	request.getParameter("alphalink");
	String tempTermSet		=	"";
	String tempTermCode		=	"";
	ArrayList Goal			=	null;
	ArrayList TermCodeList	=	null;
	String maxGrpID1		=	"";
	int maxGrpID			=	0;
	ArrayList sessionList	=	(ArrayList)BuildLibrary.getRecordSetHandle();

	if(sessionList.size()>0)
	{
		TermCodeList		=	(ArrayList)BuildLibrary.getObject(0);
	}

	for(int i=0;i<TermCodeList.size();i=i+7){
			tempTermSet			=	(String)TermCodeList.get(i);
			tempTermCode		=	(String)TermCodeList.get(i+1);
			if(tempTermSet.equals(termSet) && tempTermCode.equals(termCode)){
				Goal			=	(ArrayList)TermCodeList.get(i+2);
				if(Goal.contains(goalCode)){
					int index	=	Goal.indexOf(goalCode);
					maxGrpID1	=	(String)Goal.get(index+6);

				}
			}
	}

if(maxGrpID1==null || maxGrpID1.equals("")){
	maxGrpID=1;
}
else{
	maxGrpID=Integer.parseInt(maxGrpID1);
	maxGrpID=maxGrpID+1;
}


%>
<Body>
<FORM name="formLibraryInterventionOutcomeGroup" id="formLibraryInterventionOutcomeGroup">
<BR>
<TABLE border='0' cellspacing='0' cellpadding='0' align='center' width='102%' id="Group_ID">
	<TR>
	<TD width="8%" class="label"><B><fmt:message key="Common.Group.label" bundle="${common_labels}"/></B>
	</TD>
	<TD>&nbsp;&nbsp;
<%if(maxGrpID != 1){
		for(int i=1;i<maxGrpID;i++){
%>
		<label style='cursor:pointer;color:Blue;font:11' onclick="LoadPages('1','<%=i%>')"><%=i%>&nbsp;&nbsp;</label>
	
<%		}
	}
%>
	</TD>
</TR>
</TABLE>
<INPUT type="hidden" name="libraryid" id="libraryid" value="<%=libraryid%>">
<INPUT type="hidden" name="versionno" id="versionno" value="<%=versionno%>">
<INPUT type="hidden" name="termSet" id="termSet" value="<%=termSet%>">
<INPUT type="hidden" name="termCode" id="termCode" value="<%=termCode%>">
<INPUT type="hidden" name="goalCode" id="goalCode" value="<%=goalCode%>">
<INPUT type="hidden" name="tableName" id="tableName" value="<%=tableName%>">        
<INPUT type="hidden" name="alphalink" id="alphalink" value="<%=alphalink%>">
<INPUT type="hidden" name="maxGrpID" id="maxGrpID" value="<%=maxGrpID%>">
<!-- <INPUT type="hidden" name="curGrpID" id="curGrpID"  value="1"> -->
</FORM>
</BODY>
<SCRIPT>LoadPages('0','0')</SCRIPT>
</HTML>


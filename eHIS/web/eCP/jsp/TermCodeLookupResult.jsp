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
*	Created On		:	02 Feb 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import ="java.sql.*,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*" %>
<jsp:useBean id="BuildLibraryTermCode" class="webbeans.eCommon.RecordSet" scope="session"/> 

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
<BODY onKeyDown = 'lockKey()';  OnMouseDown="CodeArrest()" >
<FORM name="TerminologycodeLookupDetailForm" id="TerminologycodeLookupDetailForm">
<%
	String alphalink								=		request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
	String termcode								=		request.getParameter("termcode")==null ? "":request.getParameter("termcode");
	String termdesc								=		request.getParameter("termdesc")==null ? "":request.getParameter("termdesc");
	String searchcriteria						=		request.getParameter("searchcriteria")==null ? "":request.getParameter("searchcriteria");
	String classificationLevel1				=		request.getParameter("classificationLevel");
	int classificationLevel						=		Integer.parseInt(classificationLevel1);
	String terminologySetId					=		request.getParameter("terminologySetId");
	String type										=		request.getParameter("type");
	String libraryid								=		request.getParameter("libraryid");
	String versionno								=		request.getParameter("versionno");
	alphalink										=		alphalink.trim();
	String setString								=		"%";
	String tableName							=		"";
	String classValue							=		"";
	String actual									=		"";
	String potential								=		"";
	String wellness								=		"";
	String sensitivity								=		"";
	String code									=		"";
	String desc									=		"";
	String chkAttribute							=		"";

	HashMap TabList					=		null;
	ArrayList TermcodeList			=		new ArrayList();
	ArrayList sessionList				=		(ArrayList)BuildLibraryTermCode.getRecordSetHandle();
	if(sessionList.size()>0)
	{
		TabList=(HashMap)BuildLibraryTermCode.getObject(0);
		if(TabList.containsKey(terminologySetId)){
			TermcodeList=(ArrayList)TabList.get(terminologySetId);
		}
	}
	
		
	if(type.equals("DX"))
		 tableName="MR_D_"+terminologySetId+"_VW";
	else if(type.equals("PR"))
		tableName="MR_P_"+terminologySetId+"_VW";

	
	if(termdesc.equals("")){
		setString="%";
	}else{
		if(searchcriteria.equals("S"))
			setString=termdesc+"%";
		else if(searchcriteria.equals("C"))
			setString="%"+termdesc+"%";
		else if(searchcriteria.equals("E"))
			setString="%"+termdesc;
	}
		
	Connection connection				    =		null;
	Statement stmt								=		null;
	ResultSet rs									=		null;
	int maxRecord								=		0;
	int start											=		0 ;
	int end											=		0 ;
	int i												=		1;
	String from			=	request.getParameter("from");
	String 	to				=	request.getParameter("to");
	if(from==null)
			start	 =	 0;
		else
			start	 =	Integer.parseInt(from);
		
		if(to==null)
			end	=8;
		else
			end	=	Integer.parseInt(to);

	String sqlData="SELECT	TERM_SET_ID, TERM_CODE, SHORT_DESC,ACTUAL_YN, POTENTIAL_YN, WELLNESS_YN, SENSITIVE_YN, 'I' DB_ACTION FROM "+tableName+" WHERE TERM_SET_ID = '"+terminologySetId+"' AND ('"+termcode+"' IS NULL OR TERM_CODE = '"+termcode+"') AND SELECT_YN = 'Y' AND (('"+alphalink+"' IS NOT NULL AND '"+alphalink+"' BETWEEN 'A' AND 'Z' AND UPPER(SHORT_DESC) LIKE UPPER('"+alphalink+"' || '"+setString+"')) OR ('"+alphalink+"' IS NOT NULL AND '"+alphalink+"' NOT BETWEEN 'A' AND 'Z'AND SUBSTR(SHORT_DESC,1,1) NOT BETWEEN 'A' AND 'Z' AND UPPER(SHORT_DESC) LIKE UPPER('"+alphalink+"' || '"+setString+"')) OR ('"+alphalink+"' IS NULL AND UPPER(SHORT_DESC) LIKE UPPER('"+alphalink+"'|| '"+setString+"'))) AND (TERM_SET_ID, TERM_CODE) NOT IN (SELECT TERM_SET_ID,TERM_CODE FROM CP_LIBRARY_TERM_CODE WHERE LIBRARY_ID = '"+libraryid+"' AND VERSION_NO = '"+versionno+"' AND TERM_SET_ID = '"+terminologySetId+"') ORDER BY 4";	
	try{
	connection = ConnectionManager.getConnection(request);
	stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs=stmt.executeQuery(sqlData);
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();
	if(maxRecord>0){
%>
	
<TABLE border="0" cellpadding="0" cellspacing="0" width="90%" align="center">
		<TR>
		<TD width="80%" class="white">&nbsp;</TD>
		<TD width="20%" class="white">&nbsp;</TD>
		<TD align="right">
<%
		if ( !(start <= 1) )
		out.println("<label onClick='navigation(document.TerminologycodeLookupDetailForm,\"previous\")'  style='cursor:pointer;color:blue'>Previous</label>&nbsp;&nbsp;");
		
		if ( !( (start+8) > maxRecord ) )
		out.println("<td align='right'><label onClick='navigation(document.TerminologycodeLookupDetailForm,\"next\")'  style='cursor:pointer;color:blue'>Next</label>");
	%>
	</TD></TR></TABLE>
<TABLE border='1' cellpadding='0' cellspacing='0' align='center'  width='100%' >
			<TH width="10%"><fmt:message key="Common.TerminologyCode.label" bundle="${common_labels}"/></TH>
			<TH WRAP width="35%" ><fmt:message key="Common.description.label" bundle="${common_labels}"/></TH>
			<TH  width="8%"><fmt:message key="Common.Actual.label" bundle="${common_labels}"/></TH>
			<TH  width="8%"><fmt:message key="Common.Potential.label" bundle="${common_labels}"/></TH>
			<TH  width="8%"><fmt:message key="Common.Wellness.label" bundle="${common_labels}"/></TH>
			<TH width="8%"><fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/></TH>
			<TH width="7%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></TH>
		<%
		if (start != 0){
	for(int j=1; j<=start; i++,j++){
		rs.next() ;
	}
}

while(rs.next() && i<=end){

		code=(String)rs.getString("TERM_CODE");
		desc=(String)rs.getString("SHORT_DESC");

			if((i%2) == 1)
				classValue = "QRYODD";
			else
				classValue ="QRYEVEN";

			actual=(String)rs.getString("ACTUAL_YN");
			potential=(String)rs.getString("POTENTIAL_YN");
			wellness=(String)rs.getString("WELLNESS_YN");
			sensitivity=(String)rs.getString("SENSITIVE_YN");
			if(TermcodeList.contains(code)){
				int index=TermcodeList.indexOf(code);
				String status=(String)TermcodeList.get(index+2);
				if(status.equals("Y"))
					chkAttribute="Checked";
			else
				chkAttribute="";
			}
			
			

			%>
		<TR>
				<TD class="<%=classValue%>" align="left"><%=code%>
					<INPUT type="hidden" name="desc<%=i%>" id="desc<%=i%>" value="<%=desc%>"</TD>
				<TD class="<%=classValue%>" align="left"><%=desc%></TD>
				<% if(actual.equals("Y")){%>
				<td class="<%=classValue%>" align="center"><img src='../../eCommon/images/enabled.gif' align='center'></img></td>
				<%}else{%>
				<td  class="<%=classValue%>" align="center"><img src='../../eCommon/images/RRnwd.gif' align='center'></img></td>
				<%}%>
					<% if(potential.equals("Y")){%>
				<td  class="<%=classValue%>" align="center"><img src='../../eCommon/images/enabled.gif' align='center'></img></td>
				<%}else{%>
				<td  class="<%=classValue%>" align="center"><img src='../../eCommon/images/RRnwd.gif' align='center'></img></td>
				<%}%>
					<% if(wellness.equals("Y")){%>
				<td  class="<%=classValue%>" align="center"><img src='../../eCommon/images/enabled.gif' align='center'></img></td>
				<%}else{%>
				<td  class="<%=classValue%>" align="center"><img src='../../eCommon/images/RRnwd.gif' align='center'></img></td>
				<%}%>
					<% if(sensitivity.equals("Y")){%>
				<td  class="<%=classValue%>" align="center"><img src='../../eCommon/images/enabled.gif' align='center'></img></td>
				<%}else{%>
				<td  class="<%=classValue%>" align="center"><img src='../../eCommon/images/RRnwd.gif' align='center'></img></td>
				<%}%>
				<TD class="<%=classValue%>" align="Center"><INPUT type="CheckBox" name="select<%=i%>" id="select<%=i%>" value="<%=code%>"  <%=chkAttribute%> onclick="updateCodeValue(this,'<%=i%>')"></TD>

		</TR>
<%
		i++;
		actual="";
		potential="";
		wellness="";
		sensitivity="";
		chkAttribute="";
	}
}else
{
%>
	 <SCRIPT>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common")); //resetForm(parent.TermcodeLookup_header.document.formTermCodeCriteria); </SCRIPT> 
<%
}
	}
catch(Exception e){
	
	System.err.println(e.toString());
		e.printStackTrace();
}finally
{
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	ConnectionManager.returnConnection(connection,request);
}
%>
</TABLE>
<BR>
<DIV align='right'>
<TABLE  cellpadding='0' cellspacing='0' >
	<TR>
		<TD >
			<INPUT type='button' name='close' id='close' value='Close' onClick='closewindow()' class='button'>
		</TD>
	</TR>
</TABLE>
</DIV>
<input type="hidden" name="start" id="start" value="<%=start%>">
<input type="hidden" name="end" id="end" value="<%=end%>">
<input type="hidden" name="alphalink" id="alphalink" value="<%=alphalink%>">
<input type="hidden" name="termcode" id="termcode" value="<%=termcode%>">
<input type="hidden" name="termdesc" id="termdesc" value="<%=termdesc%>">
<input type="hidden" name="searchcriteria" id="searchcriteria" value="<%=searchcriteria%>">
<input type="hidden" name="classificationLevel" id="classificationLevel" value="<%=classificationLevel%>">
<input type="hidden" name="terminologySetId" id="terminologySetId" value="<%=terminologySetId%>">
<input type="hidden" name="type" id="type" value="<%=type%>">
<input type="hidden" name="libraryid" id="libraryid" value="<%=libraryid%>">
<input type="hidden" name="versionno" id="versionno" value="<%=versionno%>">
<input type="hidden" name="tableName" id="tableName" value="<%=tableName%>">

</BODY>
</FORM>
</HTML>


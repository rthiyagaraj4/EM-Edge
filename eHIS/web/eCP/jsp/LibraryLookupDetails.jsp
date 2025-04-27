<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sandhya
*	Created On		:	02 Feb 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import ="java.sql.*,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
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
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<SCRIPT language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></SCRIPT>
<SCRIPT language="JavaScript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
<SCRIPT language="javascript" src="../../eCommon/js/common.js"></SCRIPT>
<SCRIPT language="javascript" src="../../eCP/js/LibraryLookup.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<FORM name="formLibraryDetails" id="formLibraryDetails">
<%
	Connection connection				    =		null;
	Statement stmt=null;
	ResultSet rs									=		null;
	String search_text			=		request.getParameter("search_text")==null ? "":request.getParameter("search_text");
	String search_by			=		request.getParameter("search_by")==null ? "":request.getParameter("search_by");
	String search_criteria		=		request.getParameter("search_criteria")==null ? "":request.getParameter("search_criteria");
	String status="";
	String code="";
	String versionno="";
	String setString1="%";
	String setString3="%";
	String setString4="%";
	String setString5="%";
	if(search_by.equals("C"))
		setString1=search_text+"%";
	else{
	if(search_criteria.equals("C"))
		setString3="%"+search_text+"%";
	else if(search_criteria.equals("S"))
		setString4=search_text+"%";
	else if(search_criteria.equals("E"))
		setString5="%"+search_text;
	}
	String sqlData1="SELECT library_id, a.short_desc description, version_no,DECODE (status, 'F', 'Final', 'D', 'Draft', 'I', 'Inactive') status,version_remarks,DECODE (library_basis,'T', 'Terminology Code','C', 'Case Type') library_basis,ADDED_BY_ID,to_char(ADDED_DATE,'mm/dd/yyyy')created_on  FROM cp_library_lang_vw a WHERE upper(library_id) LIKE upper('"+setString1+"')  AND upper(a.short_desc) LIKE DECODE ('"+search_criteria+"', 'C', upper('"+setString3+"'), 'S', upper('"+setString4+"'), 'E', upper('"+setString5+"')) AND a.status in ('D')  AND a.eff_status = 'E' and language_id='"+locale+"'";
		String from					="";
		String to						="";
		String bgcolor="";
		int start		=	0;
		int end			=	0;
		int maxRecord								=		0;
		int i				=	1;
		String classValue="";
		from			=	request.getParameter("from");
		to				=	request.getParameter("to");
		
		if(from==null)
			start	 =	 0;
		else
			start	 =	Integer.parseInt(from);
		
		if(to==null)
			end	=	14;
		else
			end	=	Integer.parseInt(to);

try{
	connection = ConnectionManager.getConnection(request);
//	pstmt					=		con.prepareStatement(sqlData);
	stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs=stmt.executeQuery(sqlData1);
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();
	if(maxRecord>0){
%>

<TABLE border="0" cellpadding="0" cellspacing="0" width="89%" align="center">
		<TR>
		<TD width="80%" class="white">&nbsp;</TD>
		
		<TD align="right" width="20%">
<%
		if ( !(start <= 1) )
		{
	%>
		<label onClick='navigation(document.formLibraryDetails,"previous")'  style='cursor:pointer;color:blue'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;
	<%	}
		if ( !( (start+14) >= maxRecord ) )
		{
	%>
		<label onClick='navigation(document.formLibraryDetails,"next")'  style='cursor:pointer;color:blue'><fmt:message key="Common.next.label" bundle="${common_labels}"/></label>
	<%
		}
	%>
	</TD></TR></TABLE>
	<TABLE border="1" cellpadding="0" cellspacing="0" width="99%" align="center">
			<TH><fmt:message key="eCP.LibraryID.label" bundle="${cp_labels}"/></TH>
			<TH width="35%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></TH>
			<TH><fmt:message key="eCP.Version.label" bundle="${cp_labels}"/></TH>
			<TH><fmt:message key="Common.status.label" bundle="${common_labels}"/></TH>
			<TH><fmt:message key="eCP.LibraryBasis.label" bundle="${cp_labels}"/></TH>
			<TH><fmt:message key="eCP.VersionDetails.label" bundle="${cp_labels}"/></TH>
			<!-- <TH>Created By</TH>
			<TH>Created On</TH> -->
			
	<%
		if (start != 0){
	for(int j=1; j<=start; i++,j++){
		rs.next() ;
	}
}

while(rs.next() && i<=end){
	 status=rs.getString("status");
	 code=rs.getString("library_id");
	 versionno=rs.getString("version_no");
	if(status.equals("Draft"))
		bgcolor="DRAFTQRY";
	else if(status.equals("Final"))
		bgcolor="FINALQRY";
	if((i%2) == 1)
				classValue = "QRYODD";
			else
				classValue ="QRYEVEN";
	%>
		<TR >
		<TD class="<%=classValue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><label name="code" onclick="retvalcode('<%=code%>','<%=versionno%>')"><%=code%></label></font></TD>
			<!-- <TD class="<%=classValue%>" ><%=rs.getString("library_id")%></TD> -->
			<TD class="<%=classValue%>" ><%=rs.getString("description")%></TD>
			<TD  class="<%=classValue%>" align="center"><%=versionno%></TD>
			<TD class="<%=bgcolor%>"><%=status%></TD>
			<TD class="<%=classValue%>"><%=rs.getString("library_basis")%></TD>
			<TD class="<%=classValue%>"><%=rs.getString("version_remarks")%></TD>
			<!-- <TD class="<%=classValue%>"><%=rs.getString("ADDED_BY_ID")%></TD>
			<TD class="<%=classValue%>"><%=rs.getString("created_on")%></TD> -->
			
		</TR>
<%
		i++;
	}
}else
{
%>
	<SCRIPT>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));resetForm(parent.LibraryLookup_header.document.formBuildLibraryHeader);</SCRIPT>
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
</TABLE>
<BR><BR>
<DIV align='right'>
<TABLE  cellpadding='0' cellspacing='0' >
	<TR>
		<TD >
			<INPUT type='button' name='close' id='close' value='Close' onClick='closeW()' class='button'>
		</TD>
	</TR>
</TABLE>
</DIV>
<input type="hidden" name="start" id="start" value="<%=start%>">
<input type="hidden" name="end" id="end" value="<%=end%>">
<input type="hidden" name="search_text" id="search_text" value="<%=search_text%>">
<input type="hidden" name="search_by" id="search_by" value="<%=search_by%>">
<input type="hidden" name="search_criteria" id="search_criteria" value="<%=search_criteria%>">
</FORM>
</BODY>
</HTML>


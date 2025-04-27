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
*	Created On		:	24 Jan 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@page language="java" import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,java.sql.*,webbeans.eCommon.*,java.util.HashMap,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

      	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
      	<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
	    <SCRIPT language='javascript' src='../../eCommon/js/CommonLookup.js'></SCRIPT>
		<SCRIPT language="JavaScript" src="../../eCP/js/AssessmentBasedTerminologyCode.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onKeyDown = 'lockKey()';  OnMouseDown="CodeArrest()">
<FORM name="assessmentBasedTerminologycodeDetailForm" id="assessmentBasedTerminologycodeDetailForm" action="../../servlet/eCP.AssessmentBasedTerminologyCodeServlet" target="messageFrame" method='post' >

<%

String alphalink								=		request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");

String classificationLevel1				=		request.getParameter("classificationLevel");
int classificationLevel						=		Integer.parseInt(classificationLevel1);
String assessmentCategoryCode		=		request.getParameter("assessmentCategoryCode");
String terminologySetId					=		request.getParameter("terminologySetId");
String type										=		request.getParameter("type");
String termCode="";
String dbaction="";
alphalink										=		alphalink.trim();
String from									=		request.getParameter("from") ;
String to										=		request.getParameter("to") ;
Connection connection				    =		null;
PreparedStatement pstmt								=		null;
ResultSet rs									=		null;
ArrayList TabList							=		null;

int flag											=		0;
int maxRecord								=		0;
int start											=		0 ;
int end											=		0 ;
int i												=		1;
String sqlData								=		"";
String disabled								=		"";
String checked								=		"";
String classValue							=		"";
String chkAttribute							=		"";
 if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
 if (to == null){ end = 5 ; }   else {  end = Integer.parseInt( to ) ; }
 

ArrayList sessionList			=  (ArrayList)TerminologyCode.getRecordSetHandle();
//out.println(sessionList);
if(sessionList.size()>0)
{
	TabList=(ArrayList)TerminologyCode.getObject(0);
}
try{
	connection = ConnectionManager.getConnection(request);
if(alphalink.equals("Associated")){
	//out.println("entering into associated");
	sqlData="Select a.term_set_id, a.term_code, b.short_desc, 'U' db_action from      CP_TRGD_TERM_CODE_AT_ASSMT a, mr_term_code b where a.ASSESS_CATG_CODE = ? and  b.term_set_id = a.term_set_id and b.term_code = a.term_code and (( ? = 'PR' and b.procedure_yn = 'Y' ) or ( ? = 'DX' and b.diagnosis_yn = 'Y' ))  and a.term_set_id = ? and b.code_level =? order by 3";
	
	pstmt=connection.prepareStatement(sqlData,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	pstmt.setString(1,assessmentCategoryCode);
	pstmt.setString(2,type);
	pstmt.setString(3,type);
	pstmt.setString(4,terminologySetId);
	pstmt.setInt(5,classificationLevel);
	rs=pstmt.executeQuery();	
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();
	}
else
{
	//out.println("entering into query in jsp");
	sqlData="select term_set_id, term_code, short_desc, 'I' db_action from mr_term_code where term_set_id = ? and code_level = ? and (( ? = 'PR' and procedure_yn = 'Y' ) or(? = 'DX' and diagnosis_yn = 'Y' )) and ((? is not null and upper(short_desc) like ?) or (? is null and substr(upper(short_desc),1,1) not between 'A' and 'Z')) and (term_set_id, term_code) not in (select term_set_id,term_code from CP_TRGD_TERM_CODE_AT_ASSMT where ASSESS_CATG_CODE = ?) union all select     a.term_set_id, a.term_code, b.short_desc, 'U' db_action from       CP_TRGD_TERM_CODE_AT_ASSMT a, mr_term_code b where a.ASSESS_CATG_CODE = ? and   b.term_set_id = a.term_set_id and b.term_code = a.term_code and (( ? = 'PR' and b.procedure_yn = 'Y' ) or ( ? = 'DX' and b.diagnosis_yn = 'Y' )) and ((? is not null and upper(b.short_desc) like ?) or ( ? is null and substr(upper(b.short_desc),1,1) not between 'A' and 'Z')) and b.code_level = ? order by 3";


	pstmt=connection.prepareStatement(sqlData,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		pstmt.setString(1,terminologySetId);
		pstmt.setInt(2,classificationLevel);
		pstmt.setString(3,type);
		pstmt.setString(4,type);
		pstmt.setString(5,alphalink);
		pstmt.setString(6,alphalink+"%");
		pstmt.setString(7,alphalink);
		pstmt.setString(8,assessmentCategoryCode);
		pstmt.setString(9,assessmentCategoryCode);
		pstmt.setString(10,type);
		pstmt.setString(11,type);
		pstmt.setString(12,alphalink);
		pstmt.setString(13,alphalink+"%");
		pstmt.setString(14,alphalink);
		pstmt.setInt(15,classificationLevel);
	rs=pstmt.executeQuery();
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();
	}
%>
<TABLE width='98%'>
	<TR>
	<TD align='right'  id='prevNext'  class='BODYCOLORFILLED'>
	<%
	    if ( !(start <= 1)) {
	%>
	    <a href='javascript:submitPrevNext(<%=(start-5)%>,<%=(end-5)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
	
	<%
	    }
	    if ( !((start+5) > maxRecord )){
	%>
	    <a href='javascript:submitPrevNext(<%=(start+5)%>,<%=(end+5)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
	<%
	    }
	%>
	</TD>
	</TR>
	</TABLE>
	<TABLE border='1' cellpadding='0' cellspacing='0' align='center'  width='102%' >
			<TH width="33%" ><fmt:message key="Common.TerminologyCode.label" bundle="${common_labels}"/></TH>
			<TH width="55%" WRAP ><fmt:message key="Common.description.label" bundle="${common_labels}"/></TH>
			<TH><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><BR><INPUT type="checkbox" name="<%=alphalink%>chkAll" id="<%=alphalink%>chkAll"  <%=checked%> onclick="selectAll(this);"></TH>
<%
	
if (start != 0){
	

	for(int j=1; j<=start; i++,j++){
		rs.next() ;
	}
}
while(rs.next() && i<=end){
	
	if((i%2) == 1)
				classValue = "QRYEVEN";
			else
				classValue ="QRYODD";
			termCode=rs.getString("term_code");
			dbaction=rs.getString("db_action");
			
			if(dbaction.equals("U")){
				if(alphalink.equals("Associated")){
						disabled="";
				}
				else
					disabled="Disabled";
			}
			if(TabList.contains(termCode))
				chkAttribute="checked";
			else
				chkAttribute="";
					

%>
	<TR>
		<TD class="<%=classValue%>" ><%=termCode%></TD>
		<TD class="<%=classValue%>"><%=rs.getString("short_desc")%></TD>
		<TD class="<%=classValue%>"align="center">
			<INPUT type="checkBox" name="<%=alphalink%>chk<%=i%>" id="<%=alphalink%>chk<%=i%>" value="<%=termCode%>" <%=chkAttribute%> <%=disabled%> onclick="updateValue(this);setchkAll(this);" >
		</TD>
	</TR>
<%
	i++;
disabled="";
}
if(TabList.size()>0)
		flag=1;
%>
</TABLE>
<INPUT type=hidden name=from value='<%=start%>'>
<INPUT type=hidden name=to value='<%=end%>'>
<INPUT type=hidden name='start' id='start' value='<%=start%>'>
<INPUT type=hidden name='end' id='end' value='<%=end%>'>
<INPUT type=hidden name='maxRecords' id='maxRecords' value='<%=maxRecord%>'>
<INPUT type=hidden name='alphaLink' id='alphaLink' value="<%=alphalink%>">
<INPUT type=hidden name='classificationLevel' id='classificationLevel' value="<%=classificationLevel1%>">
<INPUT type=hidden name='assessmentCategoryCode' id='assessmentCategoryCode' value="<%=assessmentCategoryCode%>">
<INPUT type=hidden name='terminologySetId' id='terminologySetId' value="<%=terminologySetId%>">
<INPUT type=hidden name='type' id='type' value="<%=type%>">
<INPUT type=hidden name='flag' id='flag' value="<%=flag%>">

<%	
	
}
catch(Exception e){
	
		e.printStackTrace();
		out.print(e);
}
finally
{
		if(rs != null){ rs.close(); }
		if(pstmt != null){ pstmt.close(); }
		ConnectionManager.returnConnection(connection,request);
}


%>
</BODY>
<SCRIPT>
	checkselectAll();
</SCRIPT>
</FORM>
</HTML>


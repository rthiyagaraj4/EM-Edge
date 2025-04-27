
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- AssessmentBasedTerminologyCodeHyperLinks.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sandhya
*	Created On		:	24 Jan 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*,eOR.Common.*" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, com.ehis.eslp.* ,java.net.*"%>
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
 <%
//out.println("entering into hyperlinks.jsp");
		Connection connection=null; 
		PreparedStatement pstmt=null;
		ResultSet rs=null;		
	try{
		
		ArrayList TabList		= null;
		ArrayList sessionList			=  (ArrayList)TerminologyCode.getRecordSetHandle();
		if(sessionList.size()>0)
		{
			TabList=(ArrayList)TerminologyCode.getObject(0);
		}else{
			TabList=new ArrayList();
		}

		String assessmentCategoryCode=request.getParameter("assessmentCategoryCode");
		String terminologySet=request.getParameter("terminologySetId");
		String type=request.getParameter("type");
		String classificationLevel1=request.getParameter("classificationLevel");
		int classificationLevel=Integer.parseInt(classificationLevel1);
		String sqlData="Select a.term_set_id, a.term_code, b.short_desc, 'U' db_action from      CP_TRGD_TERM_CODE_AT_ASSMT a, mr_term_code b where a.ASSESS_CATG_CODE = ? and  b.term_set_id = a.term_set_id and b.term_code = a.term_code and (( ? = 'PR' and b.procedure_yn = 'Y' ) or ( ? = 'DX' and b.diagnosis_yn = 'Y' )) and a.term_set_id = ? and b.code_level =? order by 3";
		connection = ConnectionManager.getConnection(request);
		pstmt=connection.prepareStatement(sqlData);
		pstmt.setString(1,assessmentCategoryCode);
		pstmt.setString(2,type);
		pstmt.setString(3,type);
		pstmt.setString(4,terminologySet);
		pstmt.setInt(5,classificationLevel);
		//out.println("assessmentCategoryCode--|" +assessmentCategoryCode+ "|----type---|" +type+ "|---type----|" +type+ "|--classificationLevel---|" +classificationLevel+ "|--");
		rs=pstmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				String code=rs.getString("term_code");
				TabList.add(code);
			}
		}
		TerminologyCode.putObject(TabList);
	
%>
<BODY>
<FORM name="form_hyperlinks" id="form_hyperlinks">
<TABLE  border='0' cellspacing='0' cellpadding='0' align='center' width='100%'>
	<TR>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=Associated&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u><fmt:message key="eCP.Associated.label" bundle="${cp_labels}"/></u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=A&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>A</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=B&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>B</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=C&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>C</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=D&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>D</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=E&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>E</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=F&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>F</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=G&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>G</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=H&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>H</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=I&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>I</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=J&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>J</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=K&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>K</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=L&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>L</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=M&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>M</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=N&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>N</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=O&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>O</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=P&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>P</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=Q&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>Q</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=R&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>R</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=S&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>S</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=T&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>T</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=U&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>U</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=V&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>V</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=W&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>W</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=X&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>X</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=Y&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>Y</u></a></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=Z&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u>Z</u></a></TD>
		<TD></TD>
		<TD><a href='../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=&assessmentCategoryCode=<%=assessmentCategoryCode%>&terminologySetId=<%=terminologySet%>&type=<%=type%>&classificationLevel=<%=classificationLevel%>' target="f_query_detail"><u><fmt:message key="Common.others.label" bundle="${common_labels}"/></u></a></TD>
	</TR>
</TABLE>
</FORM>
		<%}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			if(rs != null){ rs.close(); }
			if(pstmt != null){ pstmt.close(); }
		  ConnectionManager.returnConnection(connection,request);
		}%>
</BODY>
</HTML>


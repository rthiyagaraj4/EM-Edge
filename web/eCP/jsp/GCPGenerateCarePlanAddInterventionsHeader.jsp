<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%
<%-- 
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Subbulakshmy. K
*	Created On		:	06/05/2005
* --%>
<%@page import="java.sql.*, java.io.*,java.util.*,java.text.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="GCPGenerateBean"   scope="session"  class="eCP.GCPGeneratePlanBean"/>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="JavaScript" src="../../eCP/js/GCPGenerateCarePlan.js"></script>
    <script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
    <script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
//eCP.GCPGeneratePlanBean bean	= (eCP.GCPGeneratePlanBean)session.getAttribute("GCPGenerateBean");	
String goal_code = request.getParameter("goal_code")==null?"":request.getParameter("goal_code");
String library_id = request.getParameter("library_id")==null?"":request.getParameter("library_id");
String version_no = request.getParameter("version_no")==null?"":request.getParameter("version_no");
String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
String term_code = request.getParameter("term_code")==null?"":request.getParameter("term_code");
String target_date = request.getParameter("target_date")==null?"":request.getParameter("target_date");
String sel_lib_ids = request.getParameter("sel_lib_ids")==null?"":request.getParameter("sel_lib_ids");
//sel_lib_ids=sel_lib_ids.replace('~','\'');

String sql_group_id="select distinct group_id from cp_library_intervention a where a.library_id = ? and a.version_no = ? and a.term_set_id = ? and a.term_code = ? and a.goal_code = ?";
String group_id="";

Connection con = null;
PreparedStatement pstmt_groupid = null;
ResultSet rs_groupid = null;
try{
	con =ConnectionManager.getConnection(request);
	pstmt_groupid = con.prepareStatement(sql_group_id);

	pstmt_groupid.setString(1,library_id);
	pstmt_groupid.setString(2, version_no);
	pstmt_groupid.setString(3, term_set_id);
	pstmt_groupid.setString(4, term_code);
	pstmt_groupid.setString(5, goal_code);
	rs_groupid = pstmt_groupid.executeQuery();
	if(rs_groupid.next())
		group_id = rs_groupid.getString(1);

	if(pstmt_groupid !=null)
		pstmt_groupid.close();
	if(rs_groupid!=null)
		rs_groupid.close();
	//out.println("<script>alert('"+sel_lib_ids+"');</script>");
%>
	<body>
	<form name='GCPAddinterventionHeader' id='GCPAddinterventionHeader'>
	<table border=0 cellspacing='0' cellpadding='0' width='100%'><tr>
		<td class='label' width='15%' align='right'><fmt:message key="eCP.Interventions.label" bundle="${cp_labels}"/></td>
		<td>&nbsp;&nbsp;<input type='text' size=50 maxlength='60' name='intvn_desc' id='intvn_desc' onblur='selectIntvn("T",intvn_desc,"<%=sel_lib_ids%>","<%=term_set_id%>","<%=term_code%>");'><input class='button' type=button name="intvn_btn" id="intvn_btn" value="?"  onClick='selectIntvn("B",intvn_desc,"<%=sel_lib_ids%>","<%=term_set_id%>","<%=term_code%>");'>
	<input type='hidden' name='intvn_code' id='intvn_code' value=''>
		<input type='hidden' name='intvn_type' id='intvn_type' value=''>
		<input type='hidden' name='intvn_groupID' id='intvn_groupID' value='<%=group_id%>'>
		</td>
		</tr>
		<tr>
	<td colspan='2' align='right'><input class='button' type=button name="addIntvn_btn" id="addIntvn_btn" value="Add"  onClick='addIntvn("<%=library_id%>","<%=version_no%>","<%=term_set_id%>","<%=term_code%>","<%=goal_code%>","<%=target_date%>");'>&nbsp;<input class='button' type=button name="clearIntvn_btn" id="clearIntvn_btn" value="Clear"  onClick='clearIntvns("<%=library_id%>","<%=version_no%>","<%=term_set_id%>","<%=term_code%>","<%=goal_code%>","<%=target_date%>");'>&nbsp;<input class='button' type=button name="close_btn" id="close_btn" value="Close"  onClick='Close();'>
		</td>
		</tr>
		</table>
		<form>
	</body>
<%
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if(pstmt_groupid !=null)
			pstmt_groupid.close();
		if(rs_groupid!=null)
			rs_groupid.close();
		if(con != null) 
			ConnectionManager.returnConnection(con);
	}
%>
</html>


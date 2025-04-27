<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:
*	Created By		:	P.Anuradha
*	Created On		:	17 March 2005
-->

<%-- JSP Page specific attributes start --%>
<%@page language="java" import="java.util.*, java.sql.*,webbeans.eCommon.*, com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
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
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCP/js/ReviseCarePlan.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rset=null;



String facility_id=(String)session.getValue("facility_id");
String patient_id=request.getParameter("patient_id");
String encounter_id=request.getParameter("encounter_id");
String care_mgr_id=request.getParameter("care_manager_id");
String t_set_id=request.getParameter("term_set_id");
String t_code=request.getParameter("term_code");

String md_care_plan_id="";
String care_plan_id="";
String diag_desc="";
String care_manager_name="";
String last_revision_date="";
String revised_by="";
String care_plan_id_temp="";
String cp_start_date="";
String cp_target_date="";
String cp_day_no="";

int i=0;
int index=0;
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name="ReviseCarePlanActivePlansResult_Form" id="ReviseCarePlanActivePlansResult_Form" method="post">
<table cellpadding=0 cellspacing=0 border=0 width="100%" id='tableId' >
<tr>
<td width="10%" align="Center" class=CLASSHEADER><fmt:message key="eCP.PlanID.label" bundle="${cp_labels}"/>.</td>
<td width="15%" class=CLASSHEADER><fmt:message key="eCP.CareManager.label" bundle="${cp_labels}"/></td>
<td width="35%" class=CLASSHEADER><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
<td width="20%" class=CLASSHEADER><fmt:message key="eCP.LastRevision.label" bundle="${cp_labels}"/></td>
<td width="20%" class=CLASSHEADER><fmt:message key="Common.revisedby.label" bundle="${common_labels}"/></td>
</tr>
<%

String sql="select 	a.md_care_plan_id,a.care_plan_id,b.term_set_id,b.term_code,c.short_desc diag_desc,d.practitioner_name care_manager_name,to_char(a.last_revision_date_time,'dd/mm/yyyy hh24:mi') last_revision_date_time,e.practitioner_name revised_by_name,to_char(a.care_plan_start_date,'dd/mm/yyyy hh24:mi') cp_start_date,to_char(a.care_plan_target_date,'dd/mm/yyyy hh24:mi') cp_target_date,decode(sign(trunc(sysdate) - trunc(a.care_plan_start_date) ),0,1,1,(trunc(sysdate) - trunc(a.care_plan_start_date))+1) cp_day_no from cp_pat_care_plan a, cp_pat_care_plan_term_code b,mr_term_code c, am_practitioner d, am_practitioner e, cp_pat_md_care_plan f where	a.patient_id = ? and a.current_facility_id = ? and 	a.current_status = 'O' and (? is null or a.current_care_manager_id = ? ) and b.md_care_plan_id = a.md_care_plan_id and ( (? is null and ? is null) or ( exists (select 1 from cp_pat_care_plan_term_code  where md_care_plan_id = a.md_care_plan_id and care_plan_id = a.care_plan_id and (? is null or term_set_id = ?) and (? is null or term_code = ?) ) ) ) and f.md_care_plan_id = a.md_care_plan_id and f.status = 'A' and b.care_plan_id =a.care_plan_id and b.appl_yn = 'Y' and	c.term_set_id = b.term_set_id and c.term_code = b.term_code and	d.practitioner_id(+) = a.current_care_manager_id and e.practitioner_id(+) = a.last_revision_pract_id order by a.care_plan_id,b.term_code";
try{
	conn = ConnectionManager.getConnection(request);
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1,patient_id);
	pstmt.setString(2,facility_id);
	pstmt.setString(3,care_mgr_id);
	pstmt.setString(4,care_mgr_id);
	pstmt.setString(5,t_set_id);
	pstmt.setString(6,t_code);
	pstmt.setString(7,t_set_id);
	pstmt.setString(8,t_set_id);
	pstmt.setString(9,t_code);
	pstmt.setString(10,t_code);

	rset=pstmt.executeQuery();
	if(rset!=null)
	{
		while(rset.next())
		{
		care_plan_id=rset.getString("care_plan_id");
		md_care_plan_id=rset.getString("md_care_plan_id");
		diag_desc=rset.getString("diag_desc");
		care_manager_name=rset.getString("care_manager_name")==null?"&nbsp":rset.getString("care_manager_name");
	last_revision_date=rset.getString("last_revision_date_time")==null?"&nbsp":rset.getString("last_revision_date_time");
	revised_by=rset.getString("revised_by_name")==null?"&nbsp":rset.getString("revised_by_name"
	);
	cp_start_date=rset.getString("cp_start_date")==null?"&nbsp":rset.getString("cp_start_date"
	);
	cp_target_date=rset.getString("cp_target_date")==null?"&nbsp":rset.getString("cp_target_date");
	cp_day_no=rset.getString("cp_day_no")==null?"&nbsp":rset.getString("cp_day_no");

			//classValue = "QRYEVENNOBORDER" ;
	%>
	<tr  id='trRowId<%=i%>'>
	<%
		if(care_plan_id_temp.equals(care_plan_id)){
			care_plan_id_temp="&nbsp";
			care_manager_name="&nbsp";
			last_revision_date="&nbsp";
			revised_by="&nbsp";
	%>
			<td  align="Center"  class=LISTS>&nbsp;</td>
	<%
		}
		else{
			index++;

	%>
		<td  align="Center" class=LISTS><a href="javascript:RecordChanges('<%=i%>');"><%=index%></a></td>
	<%
		}
	%>
			<input type=hidden name="care_plan_id<%=i%>" id="care_plan_id<%=i%>" value="<%=care_plan_id%>">
			<input type=hidden name="md_care_plan_id<%=i%>" id="md_care_plan_id<%=i%>" value="<%=md_care_plan_id%>">
			<input type=hidden name="cp_start_date<%=i%>" id="cp_start_date<%=i%>" value="<%=cp_start_date%>">
			<input type=hidden name="cp_target_date<%=i%>" id="cp_target_date<%=i%>" value="<%=cp_target_date%>">
			<input type=hidden name="cp_day_no<%=i%>" id="cp_day_no<%=i%>" value="<%=cp_day_no%>">
			<td align="left" class=LISTS ><%=care_manager_name%></td>
			<td align="left" class=LISTS><%=diag_desc%></td>
			<td align="left" class=LISTS><%=last_revision_date%></td>
			<td align="left" class=LISTS><%=revised_by%></td>
	</tr>
	<%
		care_plan_id_temp=care_plan_id;
		i++;
		}
	}
	%>
	</table>
	<input type=hidden name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	<input type=hidden name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type=hidden name="care_mgr_id" id="care_mgr_id" value="<%=care_mgr_id%>">
<%}catch(Exception e){
		System.err.println(e.toString());
		e.printStackTrace();
}finally{
	  if (rset != null)   rset.close();
	  if (pstmt != null) pstmt.close();
	  ConnectionManager.returnConnection(conn,request);
}
%>
</form>
</body>
</html>


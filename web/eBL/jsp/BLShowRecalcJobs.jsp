<!DOCTYPE html>
<!--
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
----------------------------------------------------------------------------------------------
1			 V210517			 17598			Common-ICN-0034				Mohana Priya K
----------------------------------------------------------------------------------------------
-->
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eBL.BLShowRecalc"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Status</title>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String reqId = request.getParameter("reqId");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/BLShowRecalcJobs.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%!
	private String replaceForVisit(String input){
		if(input == null || "null".equals(input) || "0".equals(input)){
			input = "&nbsp;";
		}
		return input;
	}

	private String checkForNull(String input){
		if(input == null || "null".equals(input) ){
			input = "";
		}
		return input;
	}

	private String replaceEpisodeType(String input){
		if("O".equalsIgnoreCase(input)){
			input = "Out Patient";
		}
		else if("I".equalsIgnoreCase(input)){
			input = "In Patient";
		}
		else if("D".equalsIgnoreCase(input)){
			input = "Day Care";	
		}
		else if("E".equalsIgnoreCase(input)){
			input = "Emergency";	
		}
		else if("R".equalsIgnoreCase(input)){
			input = "External";	
		}
		return input;
	}

	private String replaceForStatus(String input){
		if("C".equalsIgnoreCase(input)){
			input = "Completed";
		}
		else if("I".equalsIgnoreCase(input)){
			input = "In progress";
		}
		else if("O".equalsIgnoreCase(input)){
			input = "Open";
		}
		else if("F".equalsIgnoreCase(input)){
			input = "Failed";
		}
		return input;
	}
%>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	BLShowRecalc job = null;

	List<BLShowRecalc> jobList = new ArrayList<BLShowRecalc>();
	String jobQuery = "Select req_id,patient_id,episode_type,episode_id,visit_id,to_char(submission_date,'dd/mm/yyyy') submission_date, "+
	" status, remarks from bl_background_process ";

	String userId = (String) session.getAttribute("login_user");
	System.err.println("User Id is->"+userId);
	String patientId = checkForNull(request.getParameter("patient_id"));
	String episodeType = checkForNull(request.getParameter("episode_type"));
	String episodeId = checkForNull(request.getParameter("episode_id"));
	String visitId = replaceForVisit(request.getParameter("visit_id"));
	String effFrom = checkForNull(request.getParameter("eff_from"));
	String effTo = checkForNull(request.getParameter("eff_to"));
	String userAuthentication = "Y";

	if("R".equals(episodeType) && "0".equals(episodeId)){
		episodeId = "";
	}

	if(!"Y".equals(userAuthentication)){
		jobQuery = jobQuery+ " where user_id = '"+userId+"' and patient_id = '"+patientId+"'";	
	}
	else{
		jobQuery = jobQuery+ " where patient_id = '"+patientId+"'";	
	}

	if(!"".equals(episodeType)){
		jobQuery = jobQuery+ " and episode_type = '"+episodeType+"' ";
	}
	if(!"".equals(episodeId)){
		jobQuery = jobQuery+ " and episode_id = '"+episodeId+"' ";
	}
	if(!"".equals(visitId)){
		jobQuery = jobQuery+ " and visit_id = '"+visitId+"' ";
	}

	if(!"".equals(effFrom) && !"".equals(effTo)){
		jobQuery = jobQuery+ " and trunc(submission_date) between to_date('"+effFrom+"','dd/mm/yyyy') and to_date('"+effTo+"','dd/mm/yyyy') ";
	}
	else if("".equals(effFrom) && !"".equals(effTo)){
		jobQuery = jobQuery+ " and trunc(submission_date) <=  to_date('"+effTo+"','dd/mm/yyyy') ";
	}
	else if(!"".equals(effFrom) && "".equals(effTo)){
		jobQuery = jobQuery+ " and trunc(submission_date) >=  to_date('"+effFrom+"','dd/mm/yyyy') ";
	}

	jobQuery = jobQuery + " order by req_id desc ";
	System.err.println("jobQuery -> "+jobQuery);
	try{
		con = ConnectionManager.getConnection();
		pstmt = con.prepareStatement(jobQuery);
		rst = pstmt.executeQuery();
		if(rst != null){
			while(rst.next()){
				job = new BLShowRecalc();
				job.setReqId(rst.getString("req_id"));
				job.setPatientId(rst.getString("patient_id"));		
				job.setEpisodeType(replaceEpisodeType(rst.getString("episode_type")));
				job.setEpisodeId(rst.getString("episode_id"));
				job.setVisitId(replaceForVisit(rst.getString("visit_id")));
				job.setSubmissionDate(rst.getString("submission_date"));
				job.setStatus(replaceForStatus(rst.getString("status")));
				job.setRemarks(rst.getString("remarks"));
				jobList.add(job);
			}
		}
	}
	catch(Exception e){
		System.err.println("The Exception is ->"+e);
		e.printStackTrace();
	}
	finally{
		if(con!=null)  ConnectionManager.returnConnection(con, request); //V210517
		if(pstmt != null){
			pstmt.close();
		}
		if(rst!= null){
			rst.close();
		}
	}
%>
</head>
<body>
	<table class='grid' border='1' width='90%' cellpadding='3'  cellspacing=0 align="center" id='showJobs'>
		<tr style="width: 100%">
			<td style="width: 7%;overflow: hidden;display: inline-block;" class='COLUMNHEADER' >S no</td>
			<td style="width: 10%;overflow: hidden;display: inline-block;" class='COLUMNHEADER' >Request Id</td>
			<td style="width: 10%;overflow: hidden;display: inline-block;" class='COLUMNHEADER' >Patient Id</td>
			<td style="width: 9%;overflow: hidden;display: inline-block;" class='COLUMNHEADER' >Episdoe Type</td>
			<td style="width: 10%;overflow: hidden;display: inline-block;" class='COLUMNHEADER' >Episode Id</td>
			<td style="width: 9%;overflow: hidden;display: inline-block;" class='COLUMNHEADER' >Visit Id</td>
			<td style="width: 10%;overflow: hidden;display: inline-block;" class='COLUMNHEADER' >Submission Date</td>
			<td style="width: 9%;overflow: hidden;display: inline-block;" class='COLUMNHEADER' >Status</td>
			<td style="width: 20%;overflow: hidden;display: inline-block;" class='COLUMNHEADER' >Remarks</td>
			<td style="width: 6%;overflow: hidden;display: inline-block;" class='COLUMNHEADER' >Re Run</td>
		</tr>  
	<%
		int sno = 0;
		for(BLShowRecalc jobStat: jobList){
			sno++;
	%>	
		<tr  style="width: 100%">
		<td style="width: 7%;overflow: hidden;display: inline-block;" class='field' ><%=sno %></td>
		<td style="width: 10%;overflow: hidden;display: inline-block;" class='field' ><%=jobStat.getReqId() %></td>
		<td style="width: 10%;overflow: hidden;display: inline-block;" class='field' ><%=jobStat.getPatientId() %></td>
		<td style="width: 9%;overflow: hidden;display: inline-block;" class='field' ><%=jobStat.getEpisodeType() %></td>
		<td style="width: 10%;overflow: hidden;display: inline-block;" class='field' ><%=jobStat.getEpisodeId() %></td>
		<td style="width: 9%;overflow: hidden;display: inline-block;" class='field' ><%=jobStat.getVisitId() %></td>
		<td style="width: 10%;overflow: hidden;display: inline-block;" class='field' ><%=jobStat.getSubmissionDate() %></td>
		<td style="width: 9%;overflow: hidden;display: inline-block;" class='field' ><%=jobStat.getStatus() %></td>
		<td style="width: 20%;overflow: hidden;display: inline-block;" class='field' ><%=jobStat.getRemarks() %></td>
		<td style="width: 6%;overflow: hidden;display: inline-block;" class='field' >
	<%if("Failed".equalsIgnoreCase(jobStat.getStatus())){ %>
		<a href="javascript:runJob('<%=jobStat.getReqId()%>')">Run Job</a>
	<%}
	else{ %>
		&nbsp;
	<%} %>
		</td>
			</tr>
	<%}	%>
	</table>
</body>
</html>


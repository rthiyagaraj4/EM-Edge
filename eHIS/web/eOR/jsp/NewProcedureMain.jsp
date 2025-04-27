<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<html>
<head>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
	<title>New Procedure </title>
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	<script src='../js/NewProcedure.js' language='javascript'></script>
	
</head>
<%
	String occur_srl_no="";
	String Patient_Id			= request.getParameter("patient_id");
	
	String Encounter_Id			= request.getParameter("encounter_id");

	String Practitioner_Id		= "";
	String relationship_id		= checkForNull(request.getParameter("relationship_id"));	
	String Locn_Code			= request.getParameter("location_code");
	String Locn_Type			= checkForNull(request.getParameter("location_type"));   
	if(Locn_Type.equals("")) Locn_Type="C";

	String function				= checkForNull(request.getParameter("Function"));  
	String context				= checkForNull(request.getParameter("Context"));  
	String logicalseqno			= checkForNull(request.getParameter("Logical_Seq"));  
	String patient_class		= checkForNull(request.getParameter("patient_class"));  
	String called_from_ip		= checkForNull(request.getParameter("IP_YN")); 
	String age					= checkForNull(request.getParameter("Age")); 
	String dob					= checkForNull(request.getParameter("Dob")); 
	String sex					= checkForNull(request.getParameter("Sex"));
	occur_srl_no				= checkForNull(request.getParameter("occur_srl_no"));
	String term_code			= checkForNull(request.getParameter("term_code"));
	String term_set_id			= checkForNull(request.getParameter("term_set_id"));
	String modal_yn				= checkForNull(request.getParameter("modal_yn"));
	Practitioner_Id				= checkForNull(request.getParameter("ip_practitioner_id")); 

	if(Practitioner_Id.equals("") || Practitioner_Id.equals("null")){
			Practitioner_Id		= (String)session.getValue("ca_practitioner_id");
	
}
%>
	<%
	if(modal_yn.equals("Y"))
	{
	%>
		<frameset id ='ProcMain' rows='7%,15%,3%,*,4%,7%,7%' >
	<%
	}
	else
	{
	%>
		<!-- <frameset id ='ProcMain' rows='17%,43%,3%,*,4%,0%,7%' > -->
		<frameset id ='ProcMain' rows='17%,53%,3%,*,0%,0%,4%,7%' >
	<%
	}

	%>
		
		<frame name='NewProcSearch' framespacing=0 border=0 src='../../eOR/jsp/NewProcedureSearch.jsp' scrolling='no' frameborder='no' noresize>
		
		<frame name='NewProcExisting' framespacing=0 border=0 src='../../eOR/jsp/NewProcedureQueryResult.jsp?Logical_Seq=<%=logicalseqno%>&Function=<%=function%>&Patient_Id=<%=Patient_Id%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&relationship_id=<%=relationship_id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&P_context=<%=context%>&patient_class=<%=patient_class%>&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>&term_code=<%=term_code%>&term_set_id=<%=term_set_id%>&modal_yn=<%=modal_yn%>' scrolling='auto'  frameborder='no' noresize>

		<frame name='NewProcLegend' framespacing=0 border=0 src='../../eOR/jsp/NewProcedureLegend.jsp' frameborder='no' scrolling='no' noresize>

		<frame name='NewProcedure' framespacing=0 border=0 src='../../eOR/jsp/NewProcedureAddModify.jsp?Logical_Seq=<%=logicalseqno%>&Function=<%=function%>&Patient_Id=<%=Patient_Id%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&relationship_id=<%=relationship_id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&P_context=<%=context%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>&occur_srl_no=<%=occur_srl_no%>&term_code=<%=term_code%>&term_set_id=<%=term_set_id%>&modal_yn=<%=modal_yn%>' frameborder='no' scrolling='auto' noresize>
		
		<!-- <frame name='NewMultiProcedure' framespacing=0 border=0 src='../../eOR/jsp/NewProcedureAddModifyMulti.jsp?Logical_Seq=<%=logicalseqno%>&Function=<%=function%>&Patient_Id=<%=Patient_Id%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&relationship_id=<%=relationship_id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&P_context=<%=context%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>&occur_srl_no=<%=occur_srl_no%>&term_code=<%=term_code%>&term_set_id=<%=term_set_id%>&modal_yn=<%=modal_yn%>' frameborder='no' scrolling='auto' noresize> -->
		<frame name='NewMultiProcedure' framespacing=0 border=0 src='../../eCommon/html/blank.html' frameborder='no' scrolling='auto' noresize>
		
		<frame name='NewMultiPractProcedure' framespacing=0 border=0 src='../../eOR/jsp/NewProcedureAddModifyPractMulti.jsp?Logical_Seq=<%=logicalseqno%>&Function=<%=function%>&Patient_Id=<%=Patient_Id%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&relationship_id=<%=relationship_id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&P_context=<%=context%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>&occur_srl_no=<%=occur_srl_no%>&term_code=<%=term_code%>&term_set_id=<%=term_set_id%>&modal_yn=<%=modal_yn%>' frameborder='no' scrolling='auto' noresize>

		<frame name='NewProcBtn' frameborder='no' framespacing=0 border=0 src='../../eOR/jsp/NewProcedureBtn.jsp?Logical_Seq=<%=logicalseqno%>&Function=<%=function%>&Patient_Id=<%=Patient_Id%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&relationship_id=<%=relationship_id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&P_context=<%=context%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>' scrolling='no' noresize>
		
				
		<frame name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='no' noresize border=0 scrolling='no'>
		
	</frameset>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>

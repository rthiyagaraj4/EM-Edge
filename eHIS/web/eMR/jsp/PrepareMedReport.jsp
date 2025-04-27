<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<html>
<head>
	<%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language ='javascript' src='../../eMR/js/PrepareMedReport.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>	
</head>

<%
	 request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;	
	String source = url + params ;
	String function_id=request.getParameter("function_id");

	//Added by Ashwini on 21-Feb-2018 for ML-MMOH-CRF-0701
	String sum_comp_id	= checkForNull(request.getParameter("sum_comp_id"));

	//Added by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331
	String nav_menu_id = checkForNull(request.getParameter("nav_menu_id"));

	String called_from=request.getParameter("called_from");
		if(called_from == null) called_from = "";
	if(called_from.equals("CA")) 
		function_id = "PREPARE_MEDICAL_REPORT";

	String patientid = request.getParameter("patient_id");
		if(patientid == null) patientid = "";

	String result_def_frm_ca = 	request.getParameter("result_def_frm_ca") == null?"":request.getParameter("result_def_frm_ca"); //ML-MMOH-CRF-0388 - IN057153
if(called_from.equals("CA")) 
{	
	%>
	<frameset rows='0%,50%,50%,0%'>
		<frame name='tool' id='tool' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize>
		<!-- <frame name='criteriaFrame' id='criteriaFrame' 	src='../jsp/ReportRequestQueryCriteria.jsp?call_function=<%=function_id%>&function_id=<%=function_id%>&called_from=<%=called_from%>&patientid=<%=patientid%>' frameborder=0 scrolling='no' noresize> --> <!--  commented for ML-MMOH-CRF-0388 - IN057153 -->
		<frame name='criteriaFrame' id='criteriaFrame' 	src='../jsp/ReportRequestQueryCriteria.jsp?call_function=<%=function_id%>&function_id=<%=function_id%>&called_from=<%=called_from%>&patientid=<%=patientid%>&result_def_frm_ca=<%=result_def_frm_ca%>&sum_comp_id=<%=sum_comp_id%>&nav_menu_id=<%=nav_menu_id%>' frameborder=0 scrolling='no' noresize> <!--  modified for ML-MMOH-CRF-0388 - IN057153 -->
		<frame name='resultFrame' id='resultFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize>
		<frame name='messageFrame' id='messageFrame'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize>
	</frameset>
<%	}
	else{	%>
	<frameset rows='8%,45%,*,8%'>
		<frame name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize>
		<frame name='f_query_add_mod' id='f_query_add_mod' 	src='../jsp/ReportRequestQueryCriteria.jsp?call_function=<%=function_id%>&called_from=<%=called_from%>&patientid=<%=patientid%>' frameborder=0 scrolling='no' noresize>
		<frame name='result' id='result' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize>
		<frame name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' noresize>
	</frameset>	
<%	}	%>

</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


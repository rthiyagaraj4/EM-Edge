<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%

	String step = request.getParameter("step");
	if (step.equals("1"))
	{
		out.println("<html><head><title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConcludeEpisode.label","op_labels")+"</title></head>");

		String Episode = request.getParameter("Episode");
		String Patient = request.getParameter("Patient");
        String Pat_Details  = request.getParameter("Pat_Details")==null?"":request.getParameter("Pat_Details");
		Pat_Details=java.net.URLDecoder.decode(Pat_Details,"UTF-8");
		String practname = request.getParameter("practname")==null?"":request.getParameter("practname");
		String clinic_desc = request.getParameter("clinic_desc")==null?"":request.getParameter("clinic_desc");
		String service_desc = request.getParameter("service_desc")==null?"":request.getParameter("service_desc");
		String startDtTm = request.getParameter("startDtTm")==null?"":request.getParameter("startDtTm");
		String endDtTm = request.getParameter("endDtTm")==null?"":request.getParameter("endDtTm");
		out.println("<iframe name='main' id='main'    src='../../eOP/jsp/ConcludeEpisodeMain.jsp?step=2&Patient="+Patient+"&Episode="+Episode+"&Pat_Details="+java.net.URLEncoder.encode(Pat_Details,"UTF-8")+"&practname="+practname+"&clinic_desc="+clinic_desc+"&service_desc="+service_desc+"&startDtTm="+startDtTm+"&endDtTm="+endDtTm+"' scrolling='no' noresize style='height:98vh;width:100vw;border-width:0px;'></iframe><iframe name='line' id='line' src='../../eCommon/html/blank.html' scrolling='no' noresize style='height:1vh;width:100vw'></iframe></html>");		
	}else
	{
%>

<html>
<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
			<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
    	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    	<script src='../../eCommon/js/common.js' language='javascript'></script>
    	<!-- <script src='../../eCommon/js/dchk.js' language='javascript'></script> -->
	    <script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eOP/js/ConcludeEpisode.js'></script> 
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<style>
textarea {
  resize: none;
}
</style>

<body onLoad='FocusFirstElement();' onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name="Conclude_episode_form" id="Conclude_episode_form" action="../../servlet/eOP.ConcludeEpisodeServlet" method="post" target="line">

<%
	String Episodeid = request.getParameter("Episode");
	String Patient = request.getParameter("Patient");
	String locale=(String)session.getAttribute("LOCALE");	
	//Statement stmt 	= null;
	//ResultSet rs 	= null;

//	String fac_id    	= (String) session.getValue( "facility_id" ) ;
//	String sql				="";
	String Pat_Details  = request.getParameter("Pat_Details")==null?"":request.getParameter("Pat_Details");	
	String practname = request.getParameter("practname")==null?"":request.getParameter("practname");
	String clinic_desc = request.getParameter("clinic_desc")==null?"":request.getParameter("clinic_desc");
	String service_desc = request.getParameter("service_desc")==null?"":request.getParameter("service_desc");
	String startDtTm = request.getParameter("startDtTm")==null?"":request.getParameter("startDtTm");
	String endDtTm = request.getParameter("endDtTm")==null?"":request.getParameter("endDtTm");
		Pat_Details=java.net.URLDecoder.decode(Pat_Details,"UTF-8");
	//String startdate = "";
	//String startDtTm="";
	//String endDtTm="";
	String startDtTm_display="";
	String endDtTm_display="";

	//Connection conn = null;

	try
	{
		//conn=ConnectionManager.getConnection(request);
		//stmt = conn.createStatement();
		//sql  = "Select get_patient_line(patient_id) patient_menu, practitioner_name, clinic_desc, service_desc, to_char(start_date_time,'dd/mm/yyyy hh24:mi') start_date, to_char(last_visit_date,'dd/mm/yyyy hh24:mi') end_date, to_char(SYSDATE,'DD/MM/YYYY HH24:MI') sydate from OP_EPISODE_FOR_SERVICE_VW where OPERATING_FACILITY_ID = '"+fac_id+"' and PATIENT_ID = '"+Patient+"' and EPISODE_ID = '"+Episodeid+"' ";

		//sql  = "SELECT get_patient_line(a.patient_id,'"+locale+"') patient_menu , am_get_desc.am_practitioner(e.PRACTITIONER_ID,'"+locale+"',1 ) practitioner_name , op_get_desc.op_clinic(A.OPERATING_FACILITY_ID,a.clinic_code,'"+locale+"',1) clinic_desc, am_get_desc.am_service(a.service_code,'"+locale+"',2) service_desc , TO_CHAR(start_date_time,'dd/mm/yyyy hh24:mi') start_date  , TO_CHAR(last_visit_date,'dd/mm/yyyy hh24:mi') end_date , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') sydate FROM OP_EPISODE_FOR_SERVICE A,OP_PATIENT_QUEUE E WHERE A.OPERATING_FACILITY_ID = '"+fac_id+"' AND a.PATIENT_ID = '"+Patient+"' AND a.EPISODE_ID = '"+Episodeid+"' AND A.EPISODE_STATUS = '01' AND A.OPERATING_FACILITY_ID = E.FACILITY_ID  AND A.LAST_ENCOUNTER_ID = E.ENCOUNTER_ID";
		
		//rs = stmt.executeQuery(sql);
		//rs.next();
		
		//Pat_Details = rs.getString("patient_menu");
	    Pat_Details = Pat_Details.substring(0,Pat_Details.length()-7);
		//startdate = rs.getString("start_date");
		//practname = rs.getString("PRACTITIONER_NAME");
		//if(practname == null || practname.equals("null")) practname = "&nbsp;";

		//startDtTm = rs.getString( "start_date" );
		//endDtTm = rs.getString("sydate");
		startDtTm_display=DateUtils.convertDate(startDtTm,"DMYHM","en",locale);
		endDtTm_display=DateUtils.convertDate(endDtTm,"DMYHM","en",locale);
		


%>
		<center><table border='0' cellpadding='0' cellspacing='0' width='100%'>
		<tr><td class='PATIENTLINECOLOR' width='75%' style='position:relative;' colspan='2'><%=Pat_Details%></td></tr>
        <tr><td class='PATIENTLINECOLOR' width='75%' style='position:relative;'><%=practname%> / <%=clinic_desc%> / <%=service_desc%></td>
		<td class='PATIENTLINECOLOR' width='25%' nowrap><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/>:<%=Episodeid%></td></tr>
        </table></center>
        <br><br>

		<table border='0' cellpadding='3'cellspacing='0' width='90%' align='center'>
			<tr><td width='30%' class='label'><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
			<td width ='60%' class='QUERYDATA'><%=startDtTm_display%></td>
			<td width='10%'>&nbsp;</td></tr>
			<tr>
			<td width='30%' class='label'><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td>
			<td width ='60%' class='fields'><input type='text' name='enddate' id='enddate' maxlength='16' size='16' value ='<%=endDtTm_display%>' onBlur="if(validDateObj(this,'DMYHM',localeName))validateDateTime(this,'<%=endDtTm%>');">
			<input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick="document.getElementById("enddate").focus();return showCalendar('enddate',null,'hh:mm')" ><img  src='../../eCommon/images/mandatory.gif'></img></td>
			<td width='10%'>&nbsp;</td>
			</tr>																													
			<tr>
			<td width='30%' class='label' valign=top><fmt:message key="Common.notes.label" bundle="${common_labels}"/></td>
			<td width='60%' class='fields' valign=top><textarea name='conclude_episode_notes' rows=3 cols=50 onblur='makeValidString(this);checkMaxSize(this);' onkeypress='checkMaxLimit(this,500)'></textarea><img align=center src='../../eCommon/images/mandatory.gif'></img></td>
			<td width='10%'>&nbsp;</td>	
			</tr>
			</table>
			<table border='0' cellpadding='3'cellspacing='0' width='90%' align='center'>	
			<tr>
			<td colspan='2' width='70%'>&nbsp;</td>
			<td class='fields' align='right'><input type='button' class='Button' name='record' id='record' onClick='Okay()' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>'><input type='button' class='Button' name='clear' id='clear' onClick='Clear_vals()' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'><input type='button' class='Button' name='cancel' id='cancel' onClick='Close_win()' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'></td></tr></table>


<%
		//if ( rs != null ) rs.close();
		//if ( stmt != null ) stmt.close();
	}catch ( Exception e ){ }
	finally
	{
		try{
			//if( rs != null) rs.close();
			//if(stmt != null) stmt.close();
		}catch(Exception e){}
		//if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
%>				
		<input type="hidden" name="start_date" id="start_date"  value ='<%=startDtTm%>' >
		<input type="hidden" name="patient_id" id="patient_id"  value ='<%=Patient%>' >
		<input type="hidden" name="episode_id" id="episode_id"  value ='<%=Episodeid%>' >
		<input type="hidden" name="end_date" id="end_date"  value ='' >
</form>
</body>
</html>
<%
}
%>


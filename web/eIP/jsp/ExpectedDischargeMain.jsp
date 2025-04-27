<!DOCTYPE html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
		request.setCharacterEncoding("UTF-8");
        String encounterid	= request.getParameter("encounterId");        
		String patientid	= request.getParameter("patientId");        
		String bl_install	= request.getParameter("bl_instal");
		String call_function	= request.getParameter("call_function");
		String function_id	= request.getParameter("function_id");
        String facility		= (String) session.getValue( "facility_id" );
		String frame_size	= "";

		/*if (bl_install.equals("Y"))
		{
			frame_size="6%,83%,0"; 
		}
		else
		{
			frame_size="6%,81%,0";
		}*/
%>
<%	if(call_function.equals("REC_EXP_PROC_DATE"))
	{	%>
		<title><fmt:message key="eIP.RecordProcedureSurgeryDate.label" bundle="${ip_labels}"/></title>
<%	}else if(call_function.equals("MODIFY_SERVICE_FOR_INPATIENT")){%>
		<title><fmt:message key="eIP.ChangeInpatientService.label" bundle="${ip_labels}"/></title>
<%	}else {%>
		<title><fmt:message key="eIP.ExpectedDischarge.label" bundle="${ip_labels}"/></title>
<%	}
		if (bl_install.equals("Y"))
		{%>
		<iframe name='PLINE' id='PLINE' SRC='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounterid%>&Facility_Id=<%=facility%>' noresize  frameborder=no scrolling='no' style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='addmodifyExpectedDischarge.jsp?function_id=<%=function_id%>&encounter_id=<%=encounterid%>&patient_id=<%=patientid%>&bl_instal=<%=bl_install%>&call_function=<%=call_function%>' frameborder=0 scrolling='no' style='height:70vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
		<%	}else{%>
		<iframe name='PLINE' id='PLINE' SRC='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounterid%>&Facility_Id=<%=facility%>' noresize  frameborder=no scrolling='no' style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='addmodifyExpectedDischarge.jsp?function_id=<%=function_id%>&encounter_id=<%=encounterid%>&patient_id=<%=patientid%>&bl_instal=<%=bl_install%>&call_function=<%=call_function%>' frameborder=0 scrolling='no' style='height:70vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>		
		<%}%>


</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


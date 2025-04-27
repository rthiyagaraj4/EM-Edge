<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../js/MedRecRequest.js' language='javascript'>
</script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String params = request.getQueryString() ;
	String call_function = request.getParameter("call_function")==null?"":request.getParameter("call_function");
	//out.println("<script>alert(\""+request.getQueryString()+"\");</script>");
	String patient_id = checkForNull(request.getParameter("PatientId"));
	%>
	<%if(call_function.equals("MEDICAL_REPORT_REQUEST")){%><!--modified for SCR 4551-->
	
	<!-- <frameset id="frmst_1"  rows='0%,0%,0%,*%,10%,0%,0%'> -->
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='' frameborder='0' scrolling='no' noresize style="height:0vh;width:98vw"></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='' noresize frameborder=0 style="height:0vh;width:98vw"></iframe>
	<iframe name="PatientLine_frame"  id="PatientLine_frame" src="../../eCommon/jsp/pline.jsp?Patient_ID=<%=patient_id%>&<%=request.getQueryString()%>" scrolling='no' noresize frameborder=0 style="height:22vh;width:98vw"></iframe>
	<iframe scrolling="auto" name='content'  id='content' src='../../eMR/jsp/MedRecRequestResult.jsp?call_function=<%=call_function%>&<%=params%>'  noresize frameborder=0 style="height:55vh;width:98vw"></iframe>
	<iframe scrolling="no" name='f_select'  id='f_select' src='../../eMR/jsp/MedRecRequestButton.jsp?<%=params%>'  noresize frameborder=0 style="height:10vh;width:98vw"></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style="height:0vh;width:98vw"></iframe>
	<iframe name='errFrame' id='errFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto'  style="height:0vh;width:98vw"></iframe>
	

	
	
	<%}%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='' frameborder='0' scrolling='no' noresize style="height:0vh;width:98vw"></iframe>
		
		<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='' noresize frameborder=0 style="height:0vh;width:98vw"></iframe>
<%if(call_function.equals("MEDICAL_REPORT_REQUEST")){%><!--modified for SCR 4551-->	
	
		<iframe name="PatientLine_frame" src="../../eCommon/jsp/pline.jsp?Patient_ID=<%=patient_id%>&<%=request.getQueryString()%>" scrolling='no' noresize frameborder=0 style="height:0vh;width:98vw">
<%}%>
		<iframe scrolling="auto" name='content' id='content' src='../../eMR/jsp/MedRecRequestResult.jsp?call_function=<%=call_function%>&<%=params%>'  noresize frameborder=0 style="height:10vh;width:98vw"></iframe>
		<iframe scrolling="no" name='f_select'  id='f_select' src='../../eMR/jsp/MedRecRequestButton.jsp?<%=params%>'  noresize frameborder=0 style="height:0vh;width:98vw" ></iframe>
		<iframe name='messageFrame'  id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style="height:0vh;width:98vw"></iframe>
		<iframe name='errFrame' id='errFrame'  src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style="height:0vh;width:98vw"></iframe>
	
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>

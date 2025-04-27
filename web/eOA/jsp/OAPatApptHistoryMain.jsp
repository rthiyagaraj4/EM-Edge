<!DOCTYPE html>
<%@page import="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Appointment.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.History.label" bundle="${common_labels}"/></title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eOA/js/Validate.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");	
		String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String s=request.getQueryString();		
		String locale=(String)session.getAttribute("LOCALE");
		String fac_id=(String) session.getValue( "facility_id" ) ;		
		if(!patient_id.equals("")){%><!-- when patient id exists-->			
			<iframe name='OAPatApptdetails' id='OAPatApptdetails' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>				
				<iframe name='OAPatApptSummary' id='OAPatApptSummary' src='OAPatApptSummary.jsp?<%=s%>' frameborder=0 scrolling='auto' noresize style='height:35vh;width:100vw'></iframe>
				<iframe name='OAPatApptHistory' id='OAPatApptHistory' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:55vh;width:100vw'></iframe>
				<iframe name='OAPatApptHistButtonFrame' id='OAPatApptHistButtonFrame' src='OAPatApptHistButtons.jsp?<%=s%>' frameborder=0 scrolling='auto' noresize style='height:10vh;width:100vw'></iframe>
			
		<%}else{%>
				<iframe name='OAPatApptdetails' id='OAPatApptdetails' src='OAPatApptDetails.jsp?<%=s%>' frameborder=0 scrolling='auto' noresize style='height:25vh;width:100vw'></iframe>					
					<iframe name='OAPatApptSummary' id='OAPatApptSummary' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:25vh;width:100vw'></iframe>
					<iframe name='OAPatApptHistory' id='OAPatApptHistory' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:40vh;width:100vw'></iframe>
					<iframe name='OAPatApptHistButtonFrame' id='OAPatApptHistButtonFrame' src='OAPatApptHistButtons.jsp?<%=s%>' frameborder=0 scrolling='auto' noresize style='height:10vh;width:100vw'></iframe>
				
		<%}%>
</html>


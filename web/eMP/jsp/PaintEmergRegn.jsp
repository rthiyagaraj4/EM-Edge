<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");
%>

<html>
    <head>
    <title><fmt:message key="eMP.EmerRegn.label" bundle="${mp_labels}"/></title>
    <script language='javascript' src='../../eMP/js/EmergRegn.js'></script>
	<Script language='javascript' src='../../eMP/js/PatientSearch.js'></Script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
            <!-- <frame name='patient_main' id='patient_main' src='../jsp/InsertEmergRegnHead.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no'>
            <frame name='patient_sub' id='patient_sub' src='../jsp/InsertEmergRegn.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='no'> --><!-- commented 8-3-2012 for the incident IN031010 -->
			<!-- Modified on 8-3-2012 for the incident IN031010 -->
			<iframe name="patient_main" id="patient_main" src='../../eMP/jsp/InsertEmergRegnHead.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' style='height:7vh;width:99vw'></iframe>
            <iframe name="patient_sub" id="patient_sub" src='../../eMP/jsp/InsertEmergRegn.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='yes' style='height:93vh;width:99vw'></iframe>


    </head>
</html>


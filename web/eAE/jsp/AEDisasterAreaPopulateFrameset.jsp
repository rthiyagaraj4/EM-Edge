<!DOCTYPE html>
<!--Created on 12/05/2004 for Disaster Patient Registration-->
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<title>
    <fmt:message key="eAE.DisasterPatientRegistration.label" bundle="${ae_labels}"/>
</title>
<Script language='javascript' src='../../eCommon/js/common.js'></Script>
<Script language='javascript' src='../../eAE/js/DisasterPatient.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='AEDisasterAreaPopulate.jsp?selection_mode=AssignTreatmentArea' frameborder=0  scrolling='auto' style='height:100vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>

</html>


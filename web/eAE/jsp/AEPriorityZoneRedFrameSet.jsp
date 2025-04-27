<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<TITLE><fmt:message key="eAE.Messagefrom.label" bundle="${ae_labels}"/>  </TITLE>	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eAE/js/AERegisterAttn.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>				
	<iframe name='searchCriteria' id='searchCriteria' src='../../eAE/jsp/AEPriorityZoneRed.jsp?' frameborder=0  scrolling='auto' style='height:100vh;width:100vw'></iframe>
</html>


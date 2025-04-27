<!DOCTYPE html>
<!--
File Name		: PlaceMealOrderOPResultFrame.jsp
File Description: Result Main Frame: This is to search all the Outpatients who 
						1) Books an appointment but yet to visit 
						2) Visit clinic with appointment
						3) Direct Visit without appointment
CRF#			: Bru-HIMS-CRF-230
Author			: Abirami
Date			: Aug-2013
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%	request.setCharacterEncoding("UTF-8");	 
%>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language="Javascript" src="../../eDS/js/json.js"></script>
<script>
var jsonOPMealOrderArr = new Array();
var globalForApptRecord = new Array();
var globalForEnctRecord = new Array();
var indexRecord = 0;

	
	
</script>

<iframe name='qa_query_result' id='qa_query_result' 		src="../../eDS/jsp/PlaceMealOrderOPResult.jsp?from=&to=" frameborder=0 noresize style='height:70vh;width:100vw'></iframe>
<iframe name='qa_query_result_tail' id='qa_query_result_tail' src="../../eDS/jsp/PlaceMealOrderOPResultTail.jsp" frameborder=0 noresize style='height:24vh;width:100vw'></iframe>
  


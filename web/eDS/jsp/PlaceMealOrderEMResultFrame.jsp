<!DOCTYPE html>
<!--
File Name		: PlaceMealOrderEMResultFrame.jsp
File Description: Result Main Frame: This is to search all the A&E patients (EM Patient Class) 
CRF#			: Bru-HIMS-CRF-412
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

<iframe name='qa_query_result' id='qa_query_result' 		src="../../eDS/jsp/PlaceMealOrderEMResult.jsp?from=&to=" frameborder=0 noresize style='height:70vh;width:100vw'></iframe>
<iframe name='qa_query_result_tail' id='qa_query_result_tail' src="../../eDS/jsp/PlaceMealOrderEMResultTail.jsp" frameborder=0 noresize style='height:26vh;width:100vw'></iframe>
  


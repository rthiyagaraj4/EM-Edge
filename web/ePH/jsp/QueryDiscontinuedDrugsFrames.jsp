<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%@page contentType="text/html;charset=UTF-8"%>
<html>                                
<head>                                
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
 	<script language="javascript" src="../js/QueryDiscontinuedDrugs.js"></script> 
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/DrugDetailsDisplay.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>                               

<%
	String source = "../../ePH/jsp/QueryDiscontinuedDrugsCriteria.jsp" ;
%>

<iframe name="f_query_criteria" id="f_query_criteria" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:13vh;width:99vw"></iframe><iframe name="f_query_result" id="f_query_result" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:87vh;width:99vw"></iframe>
</html>


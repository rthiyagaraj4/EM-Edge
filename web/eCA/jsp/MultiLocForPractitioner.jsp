<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History    	Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
18/08/2022	29035				Ramesh G											ML-MMOH-CRF-1763
--------------------------------------------------------------------------------------------------------------
*/  
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../js/MultiLocForPractitioner.js'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>	
	<iframe name='frameMutiLocForPractitionerCriteria' id='frameMutiLocForPractitionerCriteria' src='../../eCA/jsp/MultiLocForPractitionerCriteria.jsp' frameborder=0 noresize style='height:20%;width:100vw'></iframe>
		<iframe name='frameMultiLocForPractitionerResult' id='frameMultiLocForPractitionerResult' src='../../eCA/jsp/blank.jsp' frameborder=0 style='height:65vh;width:100vw'></iframe>
	
</html>


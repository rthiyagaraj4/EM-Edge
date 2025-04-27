<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
26/10/2017		IN061892	Prakash C	31/10/2017		Ramesh G		ML-MMOH-CRF-0544
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page  import="java.util.*,java.sql.*,webbeans.eCommon.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eOR.LabSpecimenNotRegister.label" bundle="${or_labels}"/></title>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language='javascript'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
	request.setCharacterEncoding("UTF-8");
	Properties p = (Properties)session.getValue("jdbc");
	%>
	<iframe name="viewframe" id="viewframe"src='../../eOR/jsp/SpecimenNotRegisteredSearchCriteria.jsp?' scrolling='no' frameborder=0 noresize style='height:20vh;width:100vw'></iframe>
		<iframe name="resultframe" id="resultframe" scrolling='no' frameborder=0 noresize style='height:75vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' scrolling='auto' frameborder=0 style='height:5vh;width:100vw'></iframe>		
	
</html>


<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title> <fmt:message key="eCA.ClinicalCalculator.label" bundle="${ca_labels}"/> </title>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCA/js/CACalculator.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name='calulatorFrame' id='calulatorFrame' src='../../eCA/jsp/CACalcultorSelect.jsp'  frameborder=0 scrolling='no' style='height:6vh;width:100vw'></iframe>
	<iframe name='formulaFrame' id='formulaFrame'   src='../../eCommon/html/blank.html'  frameborder=0 scrolling='no' style='height:77vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'   src='../../eCommon/jsp/error.jsp'  frameborder=0  style='height:9vh;width:100vw'></iframe>

</html>


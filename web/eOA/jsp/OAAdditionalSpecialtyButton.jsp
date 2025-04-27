<!DOCTYPE html>
<html>
<%@ page  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
</head>
	<body>
		<form>
		<div style="width : 100%;margin: 20px;">
			<div id="spltyDisp" style="position: absolute; top: 0; left: 0;width : 800px;display:none;font-size:12px" ><table width="100%" ><th width="100%"><b><fmt:message key="eOA.SpeacialitesSelected.label" bundle="${oa_labels}"/></b></th></table></div>
			<div id="spltyData" style="position: absolute; top: 20; left: 0;width : 700px;">
				<div style="position: absolute;left:0;width :150px;height: 20px;" id="divCode1"></div>
				<div style="position: absolute;left:150px;width :550px;height: 20px;" id="divDesc1"></div>
				<div style="position: absolute;left:0;width :150px;top: 20px;height: 20px;" id="divCode2"></div>
				<div style="position: absolute;left:150px;width :550px;top: 20px;height: 20px;" id="divDesc2"></div>
			<div>
			<div id='button' style="position: relative;left: 700px;width :75px;">
			<table width='100%'>
				<tr><td class='button'>
				<input type='button' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="parent.frames[0].close()"></td></tr>
				</table>
			<div>
		</div>
		</form>
	</body>
</html>


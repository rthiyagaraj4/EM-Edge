<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String document_id_value = request.getParameter("document_id_value") == null ? "" : request.getParameter("document_id_value");
%>
        <!-- <modifeid by Archana  @08-12-2008> -->
        
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language="javascript" src="../js/DocRefFmt.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name=DocRefFmtLst>
<div style="display: flex; justify-content: center;">
 <table class='grid' width="50%" align="center" >
		<tr>
			<th><fmt:message key="Common.Components.label" bundle="${common_labels}"/></th>
		</tr>
		<tr><td class='gridData'>
		<a class='gridLink' href='javascript:onClickOfDoc(getLabel("Common.encounterid.label","common"))'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;</td></tr>
		<tr><td class='gridData'>
		<a class='gridLink' href='javascript:onClickOfDoc(getLabel("Common.practitionerid.label","common"))'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;</td></tr>
		<tr><td class='gridData'>
		<a class='gridLink' href='javascript:onClickOfDoc(getLabel("eCA.AccessionNum.label","eCA"))'><fmt:message key="eCA.AccessionNum.label" bundle="${ca_labels}"/></a>&nbsp;&nbsp;</td></tr>
		<tr><td class='gridData'>
		<a class='gridLink' href='javascript:onClickOfDoc(getLabel("eCA.DateAndTime.label","eCA"))'><fmt:message key="eCA.DateAndTime.label" bundle="${ca_labels}"/></a></td></tr>
	</table>
	</div>
	<input type='hidden' name='hiddenRefFormat' id='hiddenRefFormat' value = '<%=document_id_value%>'>
</form>
<script>
	loadForNextFrame();
	setTimeout("dummy()",300);	
</script> 
</body>
</html>


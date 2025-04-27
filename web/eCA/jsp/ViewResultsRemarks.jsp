<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>

	<title><fmt:message key="eOR.ReviewRemarks.label" bundle="${or_labels}"/></title>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
 	<script language="JavaScript" src="../../eCA/js/ViewResult.js"></script>
 	<!--<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<fORM name="reviewRemarks" id="reviewRemarks">
<%
	

	String review_remarks 	= request.getParameter("review_remarks");
	if (review_remarks == null) review_remarks = "";
%>
<table cellpadding=3 cellspacing=0 border='0' width='100%' height='100%' align='center'>
<tr><td class='label'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
<td class=fields><TextArea rows='6' cols='36' name='review_remarks' value='' onBlur='chkRemarksLength()'><%=review_remarks%></TextArea></td></tr>
<TR>
<TD colspan="2" class='button' align="right"><Input class='button' type='button' name='ok' id='ok' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='closeRemarks()'></TD>
</TR>
<table>
</form>
</body>
</html>


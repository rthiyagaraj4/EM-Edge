<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
19/04/2016	IN059255			Karthi L							 			ML-MMOH-CRF-0329.1
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>

	<title>Review Result</title>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
 	<script language="JavaScript" src="../../eCA/js/CAChartSummaryLabNotify.js"></script>
<!--  	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
 	<script>
 	function chkRemarksLength() {
 		if (document.reviewResultsRemark.review_remarks.value.length > 2000) {
 	        alert(getMessage("REVIEW_REMARKS_MAX_LENGTH","OR"));
 	        return false;
 	    }
 	}
 	</script>
</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<fORM name="reviewResultsRemark" id="reviewResultsRemark">
<%
	
	//System.out.println("==========="+request.getParameter("review_remarks"));
	String review_remarks 	= request.getParameter("review_remarks");
	if (review_remarks == null) review_remarks = "";
%>
<table cellpadding=3 cellspacing=0 border='0' width='100%' height='100%' align='center'>
<tr><td class='label'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
<td class=fields><TextArea rows='6' cols='36' name='review_remarks' value='' onBlur="chkRemarksLength()"><%=review_remarks%></TextArea></td></tr>
<TR>

<TD colspan="2" class='button'>
<Input class='button' type='button' name='ok' id='ok' value='<fmt:message key="Common.Forward.label" bundle="${common_labels}"/>' onClick='callForwardReview()'>
<Input class='button' type='button' name='ok' id='ok' value='<fmt:message key="eOR.CompleteReview.label" bundle="${or_labels}"/>' onClick='completeReview()'>
</TD>
</TR>
<table>
</form>
</body>
</html>


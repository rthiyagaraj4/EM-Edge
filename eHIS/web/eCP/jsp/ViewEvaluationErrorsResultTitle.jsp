<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
		//This file is saved on 18/10/2005.
		request.setCharacterEncoding("UTF-8");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
</HEAD>
<BODY onKeyDown = 'lockKey()';  OnMouseDown="CodeArrest()">
<FORM name="formViewEvaluationErrorsTitle" id="formViewEvaluationErrorsTitle">
<SCRIPT language='javascript'>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<TABLE border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
			<TH width="25%" align ="left"><fmt:message key="eCP.CarePlanStartDate.label" bundle="${cp_labels}"/> </TH>
			<TH width="25%" align ="left"><fmt:message key="eCP.CarePlanTargetDate.label" bundle="${cp_labels}"/></TH>
			<TH width="25%" align ="left"><fmt:message key="eCP.CarePlanManager.label" bundle="${cp_labels}"/></TH>
		</TABLE>
	</FORM>
</BODY>
</HTML>


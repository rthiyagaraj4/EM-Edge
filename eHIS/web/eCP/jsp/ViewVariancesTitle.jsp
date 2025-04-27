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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onKeyDown = 'lockKey()';  OnMouseDown="CodeArrest()">
<FORM name="formViewVariancesTitle" id="formViewVariancesTitle">
	<TABLE border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
			<TH width="25%" align ="left"><fmt:message key="eCP.VarianceDate.label" bundle="${cp_labels}"/></TH>
			<TH width="25%" align ="left"><fmt:message key="eCP.ExpectedOutcome.label" bundle="${cp_labels}"/></TH>
			<TH width="25%" align ="left"><fmt:message key="eCP.VarianceCause.label" bundle="${cp_labels}"/></TH>
			<TH width="25%" align ="left"><fmt:message key="eCP.VarianceReason.label" bundle="${cp_labels}"/></TH>
		</TABLE>
	</FORM>
</BODY>
</HTML>


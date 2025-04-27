<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
	<HEAD>
		<TITLE></TITLE>
	 <%
		request.setCharacterEncoding("UTF-8");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String listSize = request.getParameter("listSize") == null ? "0" : request.getParameter("listSize");
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<!-- ****  Modified by kishor kumar n on 06/12/2008 for crf0387 applied new css grid. **** -->
	
	

	<script src='../../eCommon/js/common.js'></script>
	<script src='../../eCA/js/FlowSheet.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<style>
textarea {
  resize: none;
}
</style>
	<BODY class='CONTENT'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='frmQuickTextButtons' id='frmQuickTextButtons' method='post' action='../../servlet/eCA.FlowSheetEventQuickTextServlet' target='messageframe'>
			<%if(!listSize.equals("1")){%>
			<b><fmt:message key="eCA.CommonRemarks.label" bundle="${ca_labels}"/></b>
			<%}	 else if(listSize.equals("1")){%><b><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td><%}%>

			<table width='100%' id='dataTable' class='grid' align='center'>
			<TR><TD><TEXTAREA name='txtRemarks' cols=107 rows=4 onKeyPress='checkMaxLimit(this,4000)' onBlur="SPCheckMaxLen('Remarks',this,4000,'')"></TEXTAREA><img src='../../eCommon/images/mandatory.gif'></img></TD></TR>
			</TABLE>			
			<table  width='100%' id='dataTable' class='grid' align='center'>
			<TR><TD class='gridNumericData'><input type='button' name = "record" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' class='BUTTON' onClick='return fnRecord()'>&nbsp;<input type='button'  class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick='fnCancel()'>&nbsp;<input type='button'  class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='fnClear()'></TD></TR>
			</TABLE>
			<input type='hidden' name='txtHistRecTypes' id='txtHistRecTypes' value="">
			<input type='hidden' name='txtContrSysIds' id='txtContrSysIds' value="">
			<input type='hidden' name='txtAccessionNos' id='txtAccessionNos' value="">
			<input type='hidden' name='txtEventCodes' id='txtEventCodes' value="">
		</form>
	</body>
</html>


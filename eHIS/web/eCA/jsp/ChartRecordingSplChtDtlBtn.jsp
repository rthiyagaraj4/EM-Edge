<!DOCTYPE html>

<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
			<form name="F" id="F">
			    <table cellpadding=0 cellspacing=0 width="100%">
			    <tr>
			       <td align=right>				
						<input type='button' name='Apply' id='Apply' onclick="submitPatRecDtlForm()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.apply.label","common_labels")%>' class='button'>
						<input type='button' name='reset' id='reset' onclick="clearTextBoxValues()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>'  class='button'>
						<input type='button' name='close' id='close' onclick="window.close()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'  class='button'>
					</td>
				</tr>
			    </table>
		</form>
	</body>
</html>


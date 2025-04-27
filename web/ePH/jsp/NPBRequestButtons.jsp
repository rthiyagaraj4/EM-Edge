<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, ePH.* ,ePH.Common.*,eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>   
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
	String calledFrom = request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");
	String request_status = request.getParameter("request_status")==null?"":request.getParameter("request_status");
%>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="JavaScript" src="../js/NPBRequest.js"></script>
		<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<head>
	<body onKeyDown = 'lockKey()'>
		<form name="PreivewButton" id="PreivewButton" method="post" target="messageFrame">
			<table cellpadding='3' cellspacing='0' border='0'  >	
				<tr>
					<td class='label' style='TEXT-ALIGN:right;'>
<%
					if(calledFrom.equals("NPBList")){
%>
						<input type="button" class="BUTTON" name="close" id="close" value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>' onClick='RecordNPB();'>
<%
						if(!request_status.equals("J") && !request_status.equals("C")){
%>
							<input type="button" class="BUTTON" name="close" id="close" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick='loadNBPRequest("R","ExtReset");'>
<%
						}
					}
					else{
 %>
						<input type="button" class="BUTTON" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='closePreview();'>
						<input type="button" class="BUTTON" name="print" id="print" value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' onClick="printPreview()">
<%
					}
%>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>


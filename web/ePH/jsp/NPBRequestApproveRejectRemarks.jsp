<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8"); 
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../js/NPBRequestApproveReject.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
		<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
	</head>
<%
	String NPBRemarks = request.getParameter("NPBRemarks")==null?"":request.getParameter("NPBRemarks");
	String editOption = request.getParameter("editOption")==null?"":request.getParameter("editOption");
	if(editOption.equals("Y"))
		editOption = "";
	else
		editOption = "ReadOnly";
	if(NPBRemarks!=null && !NPBRemarks.equals(""))
		NPBRemarks=java.net.URLDecoder.decode(NPBRemarks,"UTF-8");
%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="NPBRemarksForm" id="NPBRemarksForm">
			<table  border=0 align="center" width='100%' cellpadding='0' cellspacing='0'>
				<tr> 
					<td  class="label">&nbsp
						<textarea cols="80" rows="10" name="NPBRemarks" onkeypress="return CheckRemMaxLen()"  onblur=" CheckRemMaxLen()" <%=editOption%> ><%=NPBRemarks%></textarea>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" class="BUTTON" name="close" id="close" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='storeNPBRemarks();'>
						<input type="button" class="BUTTON" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='parent.window.close();'>
					</td>

				</tr>
			</table>
		</form>
	</body>
</html>


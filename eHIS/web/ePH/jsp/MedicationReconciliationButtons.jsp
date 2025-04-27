<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../js/MedicationReconciliation.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
	 </head>
	 <%
		String called_from  = request.getParameter("called_from");
%>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
			<form name="frmPrescriptionPrevOrdersButton" id="frmPrescriptionPrevOrdersButton" >
				<table cellpadding=0 cellspacing=0 width="100%" height="100%" align="center" border="1">
					<tr>
						<td class='CANCELLED' width='2%'>&nbsp;</td>
						<td class='label' >&nbsp;&nbsp;
							<label style="font-size:9;font-weight:bold"><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></label>
						</td>
						<td class='DISCONTINUED' width='2%'>&nbsp;</td>
						<td class='label' >&nbsp;&nbsp;
							<label style="font-size:9;font-weight:bold"><fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></label>
						</td>
						<td>								
							&nbsp;&nbsp;&nbsp;<input type="button" id = "copybutton" class="button" value='<fmt:message key="Common.Copy.label"  bundle="${common_labels}"/>' onClick="copiedDrugs1('<%=called_from%>');"  >&nbsp;&nbsp;&nbsp;</input>
							<input type="button" class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="window.close()"  ></input>
						</td>
					</tr>
				</table>   
			</form>
		</body>
</html>


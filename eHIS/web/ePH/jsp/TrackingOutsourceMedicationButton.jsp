<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%> 
<html>
	<head>
<%
	try{
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String trackingAction = request.getParameter("trackingAction")==null?"":request.getParameter("trackingAction");
		String callFrom = request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
		String outsourceId = request.getParameter("outsourceId")==null?"":request.getParameter("outsourceId");
		/*String buttonLegend="";
		if(trackingAction.equals("S"))
			buttonLegend =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.SendToExternalFacility.label", "ph_labels");
		else if(trackingAction.equals("R"))
			buttonLegend =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ReceiveFromExternalFacility.label", "ph_labels");
		else if(trackingAction.equals("D"))
			buttonLegend =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Deliver.label", "ph_labels");*/
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<script language="JavaScript" src="../js/TrackingOutsourceMedication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	 </head>
	<body >
		<form name="TrackingOutsourceMedicationButton" id="TrackingOutsourceMedicationButton" >
			<table cellpadding=0 cellspacing=0 width="100%" height="100%" align="center" border="0">
				<tr>
<%
				//	if(callFrom.equals("RESULT")){
%>
						<!-- <td style='text-align:right;'>
							<input type="button" class="button" value='<%/*=buttonLegend*/%>' onclick="callOutsourceAction('<%/*=trackingAction*/%>')" name="btnOutsourceAction" >&nbsp;&nbsp;&nbsp;
						</td> -->
<%
					//}
					//else{
						if(!callFrom.equals("EDITRECEIVEDDTL")){
%>
							<td style='text-align:right'> <input type="button" class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="window.close()" name="btnclose" >&nbsp;&nbsp;&nbsp;</td></tr>
<%
						}
						else{
%>
							<td  style='text-align:right'> 
								<input type="button" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="storeReceivedDtls('<%=outsourceId%>')" name="btnclose" >
								&nbsp;
								<input type="button" class="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="window.close()" name="btnclose" >&nbsp;&nbsp;&nbsp;
							</td>
<%
						}
					//}
%>
				</tr>
			</table>
		</form>
	</body>
<%
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html>


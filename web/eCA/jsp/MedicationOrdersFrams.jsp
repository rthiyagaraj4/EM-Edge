<!DOCTYPE html>
 <%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------

05/08/2020  IN072762    chandrashekar                                   MO-CRF-20101.11
---------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eCA.*, eCA.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
 
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>                                
	<head>                                
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCA/js/MedicationOrders.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>                               
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String params=request.getQueryString();
	String source  ="";
	String eventGrp				= request.getParameter("item_type")==null?"D":request.getParameter("item_type");
	if(eventGrp.equals(""))
	      eventGrp= "D";
	if (eventGrp.equals("D"))
	    source ="../../eCA/jsp/MedicationOrdersResult.jsp?"+params;
	else if(eventGrp.equals("E"))
	    source ="../../eCA/jsp/MedicationOrdersExternalDrugResult.jsp?"+params;
	else if(eventGrp.equals("M"))
	    source ="../../eCA/jsp/MedicationOrdersMedicalItemResult.jsp?"+params;
%>

	<iframe name="f_tabs_frame" id="f_tabs_frame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/MedicationOrdersTabs.jsp?<%=params%>" style="height:8vh;width:99vw"></iframe>
	<iframe name="f_query_result" id="f_query_result" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:67vh;width:99vw"></iframe>
	<iframe name="f_status_frame" id="f_status_frame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/MedicationOrdersStatus.jsp?<%=params%>" style="height:15vh;width:99vw"></iframe>
</html>


<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
 
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>                                
	<head>                                
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>                               
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String tpn_val = request.getParameter("tpn_val");
	String params=request.getQueryString();
	String called_frm		=	request.getParameter("called_frm")==null?"":request.getParameter("called_frm");//Added for Bru-HIMS-CRF-081
	String source =  "";
	if(tpn_val.equals("N")){	
		source = "../../ePH/jsp/QueryPatientDrugProfileResult.jsp?"+params;
	}
	else if(tpn_val.equals("Y")){
		source = "../../ePH/jsp/QueryPatientDrugProfileTPNResult.jsp?"+params;
	}
	String source1 =  "../../ePH/jsp/QueryPatientDrugProfilePatientLine.jsp?"+params;
	String source2 =  "../../ePH/jsp/QueryPatientDrugProfileTabs.jsp?"+params;
	String rowsSize="18,17,*";
	if(called_frm.equals("Dispense")) //Added for Bru-HIMS-CRF-081 [IN:029947]
		rowsSize="0,17,*";
%>

	
		<iframe name="f_patientline" id="f_patientline" frameborder="0" scrolling="no" noresize src="<%= source1 %>" style="height:6vh;width:98vw"></iframe>
		<iframe name="f_query_result1" id="f_query_result1" frameborder="0" scrolling="no" noresize src="<%=source2%>" style="height:15vh;width:98vw"></iframe>
		<iframe name="f_query_result" id="f_query_result" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:70vh;width:98vw"></iframe>
	
</html>


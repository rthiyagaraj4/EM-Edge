<!DOCTYPE html>
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
		<script language="javascript" src="../../ePH/js/CapturePregnencyDetail.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>                               
<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
	String params=request.getQueryString();
	String source1 =  "../../ePH/jsp/CapturePregnencyDetailPatientDetails.jsp?"+params;
	String source2 =  "../../ePH/jsp/CapturePregnencyDetailsAddModify.jsp?"+params;
%>
	<iframe name="f_patientline" id="f_patientline" frameborder="0" scrolling="no" noresize src="<%= source1%>" style="height:25vh;width:100vw"></iframe><iframe name="f_query_result1" id="f_query_result1" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:75vh;width:100vw"></iframe>
</html>


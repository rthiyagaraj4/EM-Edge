<!DOCTYPE html>
	<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String patient_id=request.getParameter("Patient_Id");
			String radio_par=request.getParameter("radio_par");
			String called_from_ip = request.getParameter("called_from_ip")==null?"N":request.getParameter("called_from_ip");
			
	%>

<html>
		<iframe src="../../eCA/jsp/PatAlertHighRiskRadio.jsp?patient_id=<%=patient_id%>&called_from_ip=<%=called_from_ip%>" marginheight=0 marginwidth=0 name="PatAlertHighRiskRadio" frameborder="0" scrolling="no" style="height:25vh;width:100vw"></iframe>
		<iframe src="../../eCA/jsp/PatAlertQueryHighRiskDesc.jsp?patient_id=<%=patient_id%>&radio_par=<%=radio_par%>&called_from_ip=<%=called_from_ip%>" marginheight=0 marginwidth=0 name="PatAlertQueryHighRiskDesc" frameborder="0" style="height:67vh;width:100vw"></iframe>
</html>


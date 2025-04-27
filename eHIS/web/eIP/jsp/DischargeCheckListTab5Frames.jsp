<!DOCTYPE html>
<%@ page import ="java.sql.*,com.ehis.util.*, webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<%
    request.setCharacterEncoding("UTF-8");
	String patient_age = request.getParameter("patient_age")==null?"":request.getParameter("patient_age");
    String call_function= request.getParameter("call_function")==null?"":request.getParameter("call_function");
%>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
		<Script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe name='DischargeCheckListTab5_frame1' id='DischargeCheckListTab5_frame1'  src='../../eIP/jsp/DischargeCheckListTab7.jsp?call_function=<%=call_function%>' frameborder=0 scrolling='yes' style='height:50vh;width:100vw'></iframe>
	
	<iframe name='DischargeCheckListTab5_frame2' id='DischargeCheckListTab5_frame2' src='../../eIP/jsp/DischargeCheckListTab5.jsp?patient_age=<%=patient_age%>&call_function=<%=call_function%>' frameborder=0 noresize scrolling='no' style='height:50vh;width:100vw'></iframe>
</html>


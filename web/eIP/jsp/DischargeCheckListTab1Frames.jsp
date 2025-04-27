<!DOCTYPE html>
<%@ page import ="java.sql.*,com.ehis.util.*, webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<%
        request.setCharacterEncoding("UTF-8");
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String call_function= request.getParameter("call_function")==null?"":request.getParameter("call_function");
	%>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<Script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

        
	</head>
	<iframe name='DischargeCheckListTab1_frame1' id='DischargeCheckListTab1_frame1' src='../../eIP/jsp/DischargeCheckListTab1.jsp?patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&call_function=<%=call_function%>' frameborder=0 scrolling='auto' style='height:63vh;width:97vw'></iframe>

	<iframe name='DischargeCheckListTab1_frame2' id='DischargeCheckListTab1_frame2' src='../../eIP/jsp/DischargeCheckListTab1Appts.jsp?patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&call_function=<%=call_function%>' frameborder=0 noresize scrolling='auto' style='height:15vh;width:97vw'>
		<!-- Added by Ashwini on 31-Jan-2017 for ML-MMOH-CRF-0620 -->
	</iframe>
	<iframe name='DischargeCheckListTab1_frame3' id='DischargeCheckListTab1_frame3' src='../../eIP/jsp/DischargeCheckListTab1PlanAdmsn.jsp?patient_id=<%=patient_id%>' frameborder=0 noresize  style='height:22vh;width:97vw'></iframe> 
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:0;width:97vw'></iframe>
</html>


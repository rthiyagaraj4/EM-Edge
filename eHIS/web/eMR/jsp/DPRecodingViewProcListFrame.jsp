<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap" %>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<% 
try{ 
	request.setCharacterEncoding("UTF-8"); 
//	String facilityId		= (String)session.getValue("facility_id");
	String	Pat_id	=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");
	String	encounter_id	=	(request.getParameter("encounter_id")==null)	?	""	:	request.getParameter("encounter_id");
%>
	<html>
		<head>
			<title><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>&nbsp;&nbsp;<fmt:message key="Common.List.label" bundle="${common_labels}"/></title>
		</head>
		<form name ='DPRecodingViewClinicHist' method='post'>
			<iframe name="FlowSheet" id="FlowSheet" frameborder="no" scrolling="auto" noresize src='../../eCA/jsp/ProcedureList.jsp?modal_yn=Y&called_mod=&patient_id=<%=Pat_id%>&encounter_id=<%=encounter_id%>' name="criteria_f0"  scrolling="no" frameborder="0" noresize style='height:100vh;width:100vw'></iframe>
			
		</form>
	</html>
<%
}catch(Exception e){
	e.printStackTrace();
}finally{
}
%>


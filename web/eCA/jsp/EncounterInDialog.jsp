<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<title><fmt:message key="eCA.ClinicalEventHistory.label" bundle="${ca_labels}"/></title>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String from_date = request.getParameter("from_date")==null?"":request.getParameter("from_date");
		String to_date = request.getParameter("to_date")==null?"":request.getParameter("to_date");
		String facilityId = request.getParameter("facilityId")==null?"":request.getParameter("facilityId");
		String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
		String p_called_from		=	request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//IN035950
	String p_event_class		=	request.getParameter("p_event_class_widget")==null?"":request.getParameter("p_event_class_widget");//IN035950
	String title		=	request.getParameter("title");//IN035950
	String p_hist_type		=	request.getParameter("p_hist_type")==null?"":request.getParameter("p_hist_type");
		//String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&facilityId="+facilityId+"&enc_called_from="+called_from+"&default_yn=N";//IN035950
		String params = "encounter_id="+encounterid+"&patient_id="+patientid+"&from_date="+from_date+"&to_date="+to_date+"&facilityId="+facilityId+"&enc_called_from="+called_from+"&p_event_class_widget="+p_event_class+"&p_called_from_widget="+p_called_from+"&hist_type="+p_hist_type+"&default_yn=N";//IN035950
		//IN035950 Starts		
		if("CA_CLINICIAN_WIDGET".equals(p_called_from))
		{%>
		<title><%=title%></title>
		<%}
		else
		{%>
		<title><fmt:message key="eCA.ClinicalEventHistory.label" bundle="${ca_labels}"/></title>
		<%
		}
		//IN035950 Ends		
%>
        <!-- <iframe src="../../eCommon/html/blank.html" name="" id=""  scrolling="no" frameborder="0" noresize style="height:0vh;width:100vw"></iframe>
		<iframe src="../../eCommon/html/blank.html" name="" id=""  scrolling="no" frameborder="0" noresize style="height:0vh;width:100vw"></iframe>
		<iframe src="../../eCommon/html/blank.html" name="" id=""  scrolling="no" frameborder="0" noresize style="height:0vh;width:100vw"></iframe>
		<iframe src="../../eCommon/html/blank.html" name="" id=""  scrolling="no" frameborder="0" noresize style="height:0vh;width:100vw"></iframe> -->
		<iframe src="../../eCA/jsp/FlowSheet.jsp?event_called=CA&<%=params%>" name="criteria_f0" id="criteria_f0" scrolling="no" frameborder="0" noresize style="height:90vh;width:99vw"></iframe>
		<iframe src="../../eCommon/jsp/error.jsp" name="messageFrame" id="messageFrame"  scrolling="no" frameborder="0" noresize style="height:10vh;width:99vw"></iframe>

</html>


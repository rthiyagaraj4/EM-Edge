<!DOCTYPE html>

<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%
	String apptRefNo_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.apptno.label","common_labels")+",";
	String apptDate_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AppointmentDate.label","common_labels")+",";
	String patientID_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+",";
	String name_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels")+",";
	String theatre_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Theatre.label","common_labels")+",";
	String fromTime_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fromtime.label","common_labels")+",";
	String toTime_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.totime.label","common_labels")+",";
	String  speciality_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+",";
	String surgeon=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels")+",";
	StringBuffer sbr = new StringBuffer();
	String strLegends=sbr.append(apptRefNo_title).append(apptDate_title).append(patientID_title).append(name_title).append(theatre_title).append(fromTime_title).append(toTime_title).append(speciality_title).append(surgeon).toString();
	

	 //String strLegends=apptRefNo_title+","+apptDate_title+","+patientID_title+","+name_title+","+theatre_title+","+fromTime_title+","+toTime_title+","+speciality_title+","+surgeon;
	 String strSizes="5,10,10,20,10,5,5,15,15";
	 String source="../../eOT/jsp/HdrComDisplay.jsp?";
	 String param="legends="+strLegends+"&sizes="+strSizes;
	 source=source+param;
	 %>
	 <!-- <frame name='schedule_hdr' id='schedule_hdr'	src='<%=source%>'
	 frameborder=0 scrolling='no' noresize> -->
	
	<iframe name='schdule_dtl' id='schdule_dtl' 		src="../../eOT/jsp/CancelTransferDtl.jsp?<%=request.getQueryString()%>" scrolling='yes'  frameborder='0' style='height:90vh;width:98vw'></iframe>



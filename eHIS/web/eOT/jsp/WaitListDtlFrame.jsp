<!DOCTYPE html>
<%@page import = "eCommon.XSSRequestWrapper,eCommon.Common.*"  contentType="text/html; charset=UTF-8"%>                
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	// String strLegends="Patient ID,Name,Surgery Type,Procedure,Speciality,Surgeon,Pref.Date,Waitlist Date,Days";
	StringBuffer sbr = new StringBuffer();
	sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")).append(",");
	sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")).append(",");
	sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SurgeryType.label","common_labels")).append(",");
	sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Procedure(s).Label","ot_labels")).append(",");
	sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")).append(",");
	sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels")).append(",");
	sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreferredDate.label","common_labels")).append(",");
	sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.WaitlistDate.Label","ot_labels")).append(",");
	sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.WaitlistDays.Label","ot_labels")).append(",");
	String strLegends=sbr.toString();
	 sbr.setLength(0);
	 String strSizes="10,19,14,12,12,10,9,11,5";
	 String source="../../eOT/jsp/HdrComDisplay.jsp?";
	 String param="legends="+strLegends+"&sizes="+strSizes;
	 source=source+param;
%>
<%
	String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	
	<!-- <frame name='schedule_hdr' id='schedule_hdr'	src='<%=source%>' frameborder=0 scrolling='no' noresize>	 -->
	<iframe name='schdule_dtl' id='schdule_dtl' 	src="../../eOT/jsp/WaitListDtl.jsp?<%=request.getQueryString()%>" scrolling='auto' style="height:99vh;width:99vw;border-width:0px"></iframe>



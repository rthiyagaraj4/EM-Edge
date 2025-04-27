<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%	request.setCharacterEncoding("UTF-8");
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends
%>
<head>
<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>


<%
	System.err.println("PendingOrderDtlFrame.jsp==="); 
	String strLegends = "";
	String strSizes="";
	String source="";
	String customerId="";
	String bookingPriorityOrdersYN="";
	String scheduleURL="";
	String param="";

	try {
	 	//String strLegends="Patient ID,Name,Sex,Surgery Type,Procedure,Pref.Date,Speciality,Surgeon";
	 
		StringBuffer sbr = new StringBuffer();
		sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")).append(",");
		sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")).append(",");
		sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")).append(",");
		sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SurgeryType.label","common_labels")).append(",");
		sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Procedure(s).Label","ot_labels")).append(",");
		sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreferredDate.label","common_labels")).append(",");
		sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")).append(",");
		sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels"));
		strLegends=sbr.toString();
		System.err.println("PendingOrderDtlFrame.jsp,strLegends==="+strLegends);
		sbr.setLength(0);
		strSizes="10,18,4,15,10,10,15,15";	
		source="../../eOT/jsp/HdrComDisplay.jsp?"+request.getQueryString();
		System.err.println("PendingOrderDtlFrame.jsp,source==="+source);
		param="legends="+strLegends+"&sizes="+strSizes;
		// start KDAH-CRF-0283 [IN:050553]
		customerId = request.getParameter("customerId") == null ? "" : request.getParameter("customerId");
		bookingPriorityOrdersYN = request.getParameter("bookingPriorityOrdersYN") == null ? "" : request.getParameter("bookingPriorityOrdersYN");
		// end KDAH-CRF-0283 [IN:050553]
		scheduleURL = "../../eOT/jsp/PendingOrderDtl.jsp?"+request.getQueryString();
		source=source+param;
		System.err.println("PendingOrderDtlFrame.jsp scheduleURL==="+scheduleURL);
		System.err.println("PendingOrderDtlFrame.jsp request.getQueryString()==="+request.getQueryString());
		System.err.println("PendingOrderDtlFrame.jsp source==="+source);
 %>

<%
	// start KDAH-CRF-0283 [IN:050553] & CRF-186
	if(bookingPriorityOrdersYN != null && bookingPriorityOrdersYN.equals("Y"))
	{
%>
		<!-- <frameset rows='100%,*'> -->
<%
	}
	else
	{
%>
	<!-- <frameset> -->
<%
	}
%>
	<%-- <frame name='schdule_dtl' id='schdule_dtl' src="<%=scheduleURL%>" frameborder=0> --%>
	<iframe name="schdule_dtl" id="schdule_dtl"  scrolling="no" noresize src="<%=scheduleURL%>" style="height:90vh;width:99vw;border-left-width: 0px;border-bottom-width: 0px;border-right-width: 0px;border-top-width: 0px;"></iframe>
<%
	if(bookingPriorityOrdersYN != null && bookingPriorityOrdersYN.equals("Y"))
	{
%>
<!--		<frame name='result_dtl' id='result_dtl' src="../../eOT/jsp/pendingOrderTail.jsp?param="+<%=request.getQueryString()%> frameborder=0 >
<frame name='result_dtl' id='result_dtl' src="../../eOT/jsp/pendingOrderTail.jsp?bookingPriorityOrdersYN=Y&ammendBooking=Y" frameborder=0 >-->

<!-- <frame name='result_dtl' id='result_dtl' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' noresize>	 -->
<iframe name="result_dtl" id="result_dtl" src="../../eCommon/html/blank.html" scrolling="no" noresize style="height:0vh;width:99vw;display: none"></iframe>
<%
	} // end KDAH-CRF-0283 [IN:050553]
	else{
	%>
	<!--<frame name='result_dtl' id='result_dtl' src="../../eOT/jsp/pendingOrderTail.jsp?param="+<%=request.getQueryString()%> frameborder=0 >-->
	<!-- <frame name='result_dtl' id='result_dtl' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' noresize> -->
	<iframe name="result_dtl" id="result_dtl" src="../../eCommon/html/blank.html" scrolling="no" noresize style="height:0vh;width:99vw;display: none"></iframe>
	<%
	}
	}
	catch(Exception ee){
		ee.printStackTrace();
		//System.err.println("Exception in PendingOrderDtlFrame.jsp=="+ee);
	} // against for KDAH-SCF-0366
%>
<!-- </frameset> -->


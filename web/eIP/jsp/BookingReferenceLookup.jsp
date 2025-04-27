<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>' ></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
		
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String param				= checkForNull(request.getParameter("param"));
	String admission_for		= checkForNull(request.getParameter("admission_for"));
	String call_function		= checkForNull(request.getParameter("call_function"));
	String oper_stn_id			= checkForNull(request.getParameter("oper_stn_id"));
	String revise_booking_yn	= checkForNull(request.getParameter("revise_booking_yn"));
	String cancel_booking_yn	= checkForNull(request.getParameter("cancel_booking_yn"));
	String confirm_booking_yn	= checkForNull(request.getParameter("confirm_booking_yn"));
	String create_booking_yn	= checkForNull(request.getParameter("create_booking_yn"));
	String create_booking_with_conf_yn = checkForNull(request.getParameter("create_booking_with_conf_yn"));
	String ismult_bkg_yn_flag	= checkForNull(request.getParameter("ismult_bkg_yn"));
	String patient_id			= checkForNull(request.getParameter("patient_id"));
	String function_id			= request.getParameter("function_id");
	 if(function_id == null) function_id = "";
	String title				= request.getParameter("title");
	String bkg_grace_period		= checkForNull(request.getParameter("bkg_grace_period"));
	String capture_fin_dtls_yn		= checkForNull(request.getParameter("capture_fin_dtls_yn"));
	String bl_interfaced_yn		= checkForNull(request.getParameter("bl_interfaced_yn"));
	String noshow_bkng_period   = checkForNull(request.getParameter("noshow_bkng_period"));//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
	
	
	
if(call_function.equals("Booking_Admission"))
	{
%>	<title><fmt:message key="eIP.BookingRefList.label" bundle="${ip_labels}"/></title>	
<%}else if (call_function.equals("RCB")){%>
<title><fmt:message key="eIP.ViewOpenBookings.label" bundle="${ip_labels}"/></title>	
<%}else{%>
	<title><fmt:message key="eIP.BookingReferenceLookup.label" bundle="${ip_labels}"/></title>	
<%}
	if (call_function.equals("AT")) 
    {	%>
		<iframe name='criteria' id='criteria' src="../../eIP/jsp/BookingReferenceLookupCriteria.jsp?function_id=<%=function_id%>&param=<%=param%>&oper_stn_id=<%=oper_stn_id%>&revise_booking_yn=<%=revise_booking_yn%>&cancel_booking_yn=<%=cancel_booking_yn%>&confirm_booking_yn=<%=confirm_booking_yn%>&create_booking_yn=<%=create_booking_yn%>&create_booking_with_conf_yn=<%=create_booking_with_conf_yn%>&call_function=AT&admission_for=<%=admission_for%>&ismult_bkg_yn=<%=ismult_bkg_yn_flag%>&patient_id=<%=patient_id%>&bkg_grace_period=<%=bkg_grace_period%>&bl_interfaced_yn=<%=bl_interfaced_yn%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&noshow_bkng_period=<%=noshow_bkng_period%>" frameborder=0 scrolling='no' style='height:60vh;width:100vw'></iframe><!-- modified   for Bru-HIMS-CRF-153 [IN:030273] by Srinivas--> 
		<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto'  style='height:35vh;width:100vw'></iframe>
		<iframe name='message' id='message' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:8vh;width:100vw'></iframe>
		
<% 	}
	else if(call_function.equals("BookingReport")) 
    {	%>
		<iframe name='criteria' id='criteria' src="../../eIP/jsp/BookingReferenceLookupCriteria.jsp?function_id=<%=function_id%>&param=<%=param%>&oper_stn_id=<%=oper_stn_id%>&revise_booking_yn=<%=revise_booking_yn%>&cancel_booking_yn=<%=cancel_booking_yn%>&confirm_booking_yn=<%=confirm_booking_yn%>&create_booking_yn=<%=create_booking_yn%>&create_booking_with_conf_yn=<%=create_booking_with_conf_yn%>&call_function=BookingReport&admission_for=<%=admission_for%>&bkg_grace_period=<%=bkg_grace_period%>&bl_interfaced_yn=<%=bl_interfaced_yn%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>" frameborder=0 scrolling='no' style='height:55vh;width:100vw'></iframe>
		<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto'  style='height:35vh;width:100vw'></iframe>
		<iframe name='message' id='message' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:8vh;width:100vw'></iframe>
		
<%	} 
	else if(call_function.equals("Booking_Admission"))
	{	%>
		
		<iframe name='criteria' id='criteria' src="../../eIP/jsp/BookingReferenceLookupResult.jsp?function_id=<%=function_id%>&param=<%=param%>&oper_stn_id=<%=oper_stn_id%>&revise_booking_yn=<%=revise_booking_yn%>&cancel_booking_yn=<%=cancel_booking_yn%>&confirm_booking_yn=<%=confirm_booking_yn%>&create_booking_yn=<%=create_booking_yn%>&create_booking_with_conf_yn=<%=create_booking_with_conf_yn%>&call_function=Booking_Admission&booking_type=<%=admission_for%>&title=<%=title%>&patient_id=<%=patient_id%>&bkg_grace_period=<%=bkg_grace_period%>"  frameborder=0 scrolling='auto' style='height:55vh;width:100vw'></iframe>
		<iframe name='button' id='button' src='../../eIP/jsp/BookingReferenceLookupButton.jsp' frameborder=0 noresize scrolling='no' style='height:10vh;width:100vw'></iframe>	
	<%}/*Thursday, December 17, 2009 17368*/
	else if(call_function.equals("RCB"))
	{	%>
		
		<iframe name='criteria' id='criteria' src="../../eIP/jsp/BookingReferenceLookupResult.jsp?function_id=<%=function_id%>&param=<%=param%>&oper_stn_id=<%=oper_stn_id%>&revise_booking_yn=<%=revise_booking_yn%>&cancel_booking_yn=<%=cancel_booking_yn%>&confirm_booking_yn=<%=confirm_booking_yn%>&create_booking_yn=<%=create_booking_yn%>&create_booking_with_conf_yn=<%=create_booking_with_conf_yn%>&call_function=RCB&booking_type=<%=admission_for%>&title=<%=title%>&patient_id=<%=patient_id%>&ismult_bkg_yn=<%=ismult_bkg_yn_flag%>&bkg_grace_period=<%=bkg_grace_period%>"  frameborder=0 scrolling='auto' style='height:55vh;width:100vw'></iframe>	
<%	}else 
	{ %>
		<iframe name='criteria' id='criteria' src="../../eIP/jsp/BookingReferenceLookupCriteria.jsp?function_id=<%=function_id%>&param=<%=param%>&oper_stn_id=<%=oper_stn_id%>&revise_booking_yn=<%=revise_booking_yn%>&cancel_booking_yn=<%=cancel_booking_yn%>&confirm_booking_yn=<%=confirm_booking_yn%>&create_booking_yn=<%=create_booking_yn%>&create_booking_with_conf_yn=<%=create_booking_with_conf_yn%>&call_function=RCB&admission_for=<%=admission_for%>&bkg_grace_period=<%=bkg_grace_period%>&bl_interfaced_yn=<%=bl_interfaced_yn%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&noshow_bkng_period=<%=noshow_bkng_period%>"  frameborder=0 scrolling='no' style='height:66vh;width:100vw'></iframe>
		<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto'  style='height:33vh;width:100vw'><!-- modified   for Bru-HIMS-CRF-153 [IN:030273] by Srinivas--></iframe>

	<%}%>
</head>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


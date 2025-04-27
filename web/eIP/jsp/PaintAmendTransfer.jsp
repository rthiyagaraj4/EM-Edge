<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");  %>
<html>
<head>
<script language ='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	String function_id					= checkForNull(request.getParameter("function_id"));
	String fromfunction				= checkForNull(request.getParameter("fromFunction"));
	String patientid					= request.getParameter("patientId");
	String encounterid				= request.getParameter("encounterId");
	String bookingrefno				= request.getParameter("booking_ref_no");
	String facilityId					= (String)session.getValue("facility_id");

	// Added by Sridhar R on Mar 11 2005.. for passing parameters to respective calling page...
	String oper_stn_id				= checkForNull(request.getParameter("oper_stn_id"));
	String routinetfryn				= checkForNull(request.getParameter("routine_tfr_yn"),"N");
	String priority_applicable_yn	= checkForNull(request.getParameter("priority_applicable_yn"),"N");
	String change_bed_class_yn	= checkForNull(request.getParameter("change_bed_class_yn"),"N");
	String deactivate_pseudo_bed_yn	= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
	String bl_interfaced_yn			= checkForNull(request.getParameter("bl_interfaced_yn"),"N");
	String bed_block_period_max_type= checkForNull(request.getParameter("bed_block_period_max_type"));
	String bed_block_period_max_str	= checkForNull(request.getParameter("bed_block_period_max_int"));
	int bed_block_period_max_int	= 0;
	if(! bed_block_period_max_str.equals(""))
		bed_block_period_max_int	= Integer.parseInt(bed_block_period_max_str);


	if(function_id.equals("CancelRequest"))
		out.println("<title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ConfirmDetails.label","ip_labels")+" </title>");
	else if(function_id.equals("CONFIRM_TRANS_BOOKING"))
		out.println("<title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ConfirmRequestforTransfer.label","ip_labels")+" </title>");
	else
		out.println("<title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CancelRequestForTransfer.label","ip_labels")+" </title>");
%>
</head>
<%

	if(routinetfryn.equals("Y"))
	{	%>
		<iframe src="../../eCommon/jsp/pline.jsp?Facility_Id=<%=facilityId%>&EncounterId=<%=encounterid%>" name="PatientLine_frame" scrolling=NO noresize style="height:10vh;width:98vw"></iframe>
		
	<%	if(function_id.equals("CONFIRM_TRANS_BOOKING")) 
		{	%>
			<iframe src="ConfirmBookBedTransfer.jsp?encounter_id=<%=encounterid%>&patient_id=<%=patientid%>&booking_ref_no=<%=bookingrefno%>&fromFunction=<%=fromfunction%>&oper_stn_id=<%=oper_stn_id%>&routine_tfr_yn=<%=routinetfryn%>&priority_applicable_yn=<%=java.net.URLEncoder.encode(priority_applicable_yn)%>&change_bed_class_yn=<%=java.net.URLEncoder.encode(change_bed_class_yn)%>&deactivate_pseudo_bed_yn=<%=java.net.URLEncoder.encode(deactivate_pseudo_bed_yn)%>&bl_interfaced_yn=<%=java.net.URLEncoder.encode(bl_interfaced_yn)%>&bed_block_period_max_type=<%=java.net.URLEncoder.encode(bed_block_period_max_type)%>&bed_block_period_max_int=<%=bed_block_period_max_int%>" style="height:75vh;width:98vw" name="Transfer_frame" scrolling='no'></iframe> 


	<%	}
		else
		{	%>
			<iframe src="CancelBookBedTransfer.jsp?encounter_id=<%=encounterid%>&patient_id=<%=patientid%>&booking_ref_no=<%=bookingrefno%>&fromFunction=<%=fromfunction%>&oper_stn_id=<%=oper_stn_id%>&routine_tfr_yn=<%=routinetfryn%>&priority_applicable_yn=<%=java.net.URLEncoder.encode(priority_applicable_yn)%>&change_bed_class_yn=<%=java.net.URLEncoder.encode(change_bed_class_yn)%>&deactivate_pseudo_bed_yn=<%=java.net.URLEncoder.encode(deactivate_pseudo_bed_yn)%>&bl_interfaced_yn=<%=java.net.URLEncoder.encode(bl_interfaced_yn)%>&bed_block_period_max_type=<%=java.net.URLEncoder.encode(bed_block_period_max_type)%>&bed_block_period_max_int=<%=bed_block_period_max_int%>" name="Transfer_frame" scrolling='no' style="height:75vh;width:98vw"></iframe>
	<%	}	%>

			<iframe src="../../eCommon/jsp/error.jsp" name="Dummy_frame" id="Dummy_frame" scrolling='auto' noresize style='height:0vh;width:98vw'></iframe>
		
<%	}
	else
	{
		out.println("<script>alert(getMessage('CANNOT_PROCEED','IP'));</script>");
		out.println("<script>window.close()</script>");
	}
%>
</html>


<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>


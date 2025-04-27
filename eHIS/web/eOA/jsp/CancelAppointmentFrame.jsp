<!DOCTYPE html>
   <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
   
<% 
request.setCharacterEncoding("UTF-8");	
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
	String clinic_code="";
	String practitioner_id="";
	String locale=(String)session.getAttribute("LOCALE");
	String appt_day1=request.getParameter("appt_day1");
	String i_appt_date=request.getParameter("i_appt_date");
String day_show="";
if (appt_day1==null) appt_day1="";
if (!(appt_day1.equals("")))
{
		if(appt_day1.equals("Sunday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
		}else if(appt_day1.equals("Monday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
		}else if(appt_day1.equals("Tuesday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
		}else if(appt_day1.equals("Wednesday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
		}else if(appt_day1.equals("Thursday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
		}else if(appt_day1.equals("Friday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
		}else if(appt_day1.equals("Saturday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
		}
}

String i_appt_date_display=DateUtils.convertDate(i_appt_date,"DMY","en",locale);
	%>
	<html>
	<head><title><fmt:message key="eOA.CancelAppointmentfor.label" bundle="${oa_labels}"/><%=i_appt_date_display%> (<%=day_show%>)</title></head> 	<%
	clinic_code=request.getParameter("i_clinic_code");
	 practitioner_id=request.getParameter("i_practitioner_id");
	String apptrefno=request.getParameter("i_appt_ref_no");
	if(apptrefno == null || apptrefno.equals("")) apptrefno="";
	String i_from_time=request.getParameter("i_from_time");
	if(i_from_time == null) i_from_time="";
	String i_to_time=request.getParameter("i_to_time");
	if(i_to_time == null) i_to_time="";
	String overbookedyn=request.getParameter("over_booked");
	String Forced=request.getParameter("Forced");
	String locnType=request.getParameter("clinic_type");
	
    String  flag="";
    flag="cancel_appt";
	%>
	<!--Modified by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058 -->
	<iframe name='f_apptdetails' id='f_apptdetails' src='../../eOA/jsp/AddModifyAppointmentDetails.jsp?i_from_time=<%=i_from_time%>&i_to_time=<%=i_to_time%>&i_appt_ref_no=<%=apptrefno%>&i_clinic_code=<%=clinic_code%>&i_practitioner_id=<%=practitioner_id%>&i_appt_date=<%=i_appt_date%>&over_booked=<%=overbookedyn%>&flag=<%=flag%>&Forced=<%=Forced%>&clinic_type=<%=locnType%>'  frameborder='0' scrolling='auto' marginheight='2' marginwidth='0' style='height:95vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0'  noresize scrolling='no' marginheight='0' marginwidth='0' style='height:5vh;width:100vw'></iframe>
	</html>
	<%

%>



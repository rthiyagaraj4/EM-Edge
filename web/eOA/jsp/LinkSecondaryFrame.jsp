<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 <%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
   
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String appt_day1=request.getParameter("appt_day1");
	String i_appt_date=request.getParameter("i_appt_date");
	String locale = (String)session.getAttribute("LOCALE");
String day_show="";
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
		String apptdate_display=DateUtils.convertDate(i_appt_date,"DMY","en",locale);



	%>
	<html>
	<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<head><title><fmt:message key="eOA.SecondaryBookingForRecurring.label" bundle="${oa_labels}"/><%=apptdate_display%> (<%=day_show%>)</title></head><%
	String params = request.getQueryString() ;
	
	String apptrefno=request.getParameter("i_appt_ref_no");
	if(apptrefno == null || apptrefno.equals("")) apptrefno="";
	String i_from_time=request.getParameter("i_from_time");
	if(i_from_time == null) i_from_time="";
	String i_to_time=request.getParameter("i_to_time");
	if(i_to_time == null) i_to_time="";
	  
	%>
	
	<iframe name='linkframe' id='linkframe' src='../../eOA/jsp/LinkSecondaryDetails.jsp?<%=params%>' 	frameborder='0' scrolling='no' marginheight='2' marginwidth='0' style='height:93vh;width:100vw'></iframe>
	<iframe name='dummyFrame' id='dummyFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' marginheight='0' marginwidth='0' style='height:7vh;width:100vw'></iframe>
	</html>
	<%

%>



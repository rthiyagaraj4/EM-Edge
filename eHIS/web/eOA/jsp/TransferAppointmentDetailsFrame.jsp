<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
12/08/2011    IN027165       Chowminya   Incident No: IN027165 - <Future order linked orders reschedule - started date update issue> 										 
---------------------------------------------------------------------------------------------------------------
-->
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 <%@ page  contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper"%> 
<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String params = request.getQueryString() ;
String apptrefno=request.getParameter("i_appt_ref_no");
if(apptrefno == null || apptrefno.equals("")) apptrefno="";
String i_from_time=request.getParameter("i_from_time");
if(i_from_time == null) i_from_time="";
String i_to_time=request.getParameter("i_to_time");
if(i_to_time == null) i_to_time="";
String new_day=request.getParameter("new_day");
String i_appt_date=request.getParameter("i_appt_date");
if(new_day == null) new_day="";
String locale=(String)session.getAttribute("LOCALE");
String i_appt_date_display=DateUtils.convertDate(i_appt_date,"DMY","en",locale);


new_day=new_day.trim();
String new_day_show="";
if (!(new_day.equals(""))){
	if(new_day.equals("Sunday")){
			new_day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
	}else if(new_day.equals("Monday")){
		new_day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
	}else if(new_day.equals("Tuesday")){
			new_day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
	}else if(new_day.equals("Wednesday")){
		new_day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
	}else if(new_day.equals("Thursday")){
		new_day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
	}else if(new_day.equals("Friday")){
		new_day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
	}else if(new_day.equals("Saturday")){
		new_day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
	}

}
%> <!--below title modified aganist ML-MMOH-CRF-609 by Mano-->
<head><title><fmt:message key="eOA.RescheduleAppointmentfor.label" bundle="${oa_labels}"/><%=i_appt_date_display%> (<%=new_day_show%>)</title></head>
<iframe name='f_apptdetails' id='f_apptdetails' src="../../eOA/jsp/AddModifyAppointmentDetails.jsp?function_mode=transfer&flag=Trans&<%=params%> " frameborder='0' scrolling='auto' marginheight='0' marginwidth='0' style='height:96vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize  marginheight='0' marginwidth='0' style='height:0vh;width:100vw'></iframe>
</html>




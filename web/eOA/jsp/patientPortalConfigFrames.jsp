<!DOCTYPE html>


<html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<head>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<link rel='stylesheet' type='text/css' href='../../eOA/patientportal/jquery.timepicker.js'></link>
	<link rel='stylesheet' type='text/css' href='../../eOA/patientportal/jquery.timepicker.css'></link>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>

	<script src='../../eOA/js/patientPortalConfig.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
			var availableDaysArr				= {};
			var daysList						= [];
			var storedDaysArr					= {};
			var storedDaysArrwithDayNo			= {};
			var breakeTimingwithDayNo			= {};
			var breakeTimingwithDayNoInSec		= {};
			var misMatchedTimeTableList			= {};
			var daysShortName					= {'SUNDAY':'Sun','MONDAY':'Mon','TUESDAY':'Tues','WEDNESDAY':'Wed','THURSDAY':'Thur','FRIDAY':'Fri','SATURDAY':'Sat'};
	</script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:7vh;width:100vw'></iframe>		
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eOA/jsp/patientPortalConfig.jsp' frameborder='0' scrolling='no' style='height:84vh;width:100vw'> </iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='height:9vh;width:100vw'></iframe>
	
</html>


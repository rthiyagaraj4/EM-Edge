<!DOCTYPE html>
<%--
/**
  *	Author				:	Mr.ArunaGiri.S
  * Created Date		:	13th June 2002
  * Last Modified Date	:	13th June 2002
  *	Purpose				:	Displays the User Interface for AE Attendance.
  */
--%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  import="eCommon.XSSRequestWrapper"%>

<html>
<head>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script language='javascript' src='../../eAE/js/AEAttendance.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script> 
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	

</head>


<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>


<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
   <iframe name='f_attendanceCriteria' id='f_attendanceCriteria' src='../../eAE/jsp/AEQueryAttendance.jsp' frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe> 
  <iframe name='f_attendanceResult' id='f_attendanceResult' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:65vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>


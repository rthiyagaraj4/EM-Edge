<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	String function_mode=request.getParameter("function_mode");
	if(function_mode == null) function_mode="";
	String clinic_code=request.getParameter("clinic_code");
	if(clinic_code == null) clinic_code="";
	String practid= request.getParameter("practid");
	if(practid == null) practid="";
	String dayno=request.getParameter("dayno");
	if(dayno == null) dayno="";
	String timetabletype=request.getParameter("timetabletype");
	if(timetabletype == null) timetabletype="";
	String locnCode=request.getParameter("locnCode")==null?"":request.getParameter("locnCode");
	String resourceType = request.getParameter("rsType")==null?"":request.getParameter("rsType");
	String locnDesc=request.getParameter("locnDesc")==null?"":request.getParameter("locnDesc");
	String oper_stn_id=request.getParameter("oper_stn_id");
	
%>
 
<html>

<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
	 -->
	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eOA/js/TimeTable.js"> </script>
	<script language="javascript" src="../../eCommon/js/common.js"> 		</script>	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
	
	<% if(function_mode.equals("insert")) { %>

		<iframe name='TimeTableDetail' id='TimeTableDetail'    src="../../eOA/jsp/AddTimeTable.jsp?function_mode=insert&oper_stn_id=<%=oper_stn_id%>"  frameborder=0 noresize scrolling=no noresize style='height:100vh;width:100vw'></iframe>
		

	<% } else { %>

		<iframe name='TimeTableDetail' id='TimeTableDetail'    src="../../eOA/jsp/ModifyTimeTable.jsp?function_mode=modify&locnDesc=<%=locnDesc%>&locnCode=<%=locnCode%>&resourceType=<%=resourceType%>&clinic_code=<%=clinic_code%>&practid=<%=practid%>&dayno=<%=dayno%>&timetabletype=<%=timetabletype%>&oper_stn_id=<%=oper_stn_id%>"  frameborder=0 noresize scrolling=no style='height:100vh;width:100vw'></iframe>
		

	<% } %>
	
</html>


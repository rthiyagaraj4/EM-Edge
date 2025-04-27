<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "eCommon.XSSRequestWrapper"  %>
<%--
	FileName	: addmodifyFacilityDeptMain.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
	request.setCharacterEncoding("UTF-8");
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	String facilityId = request.getParameter("facilityId");
		if(facilityId == null)  facilityId="";
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<iframe name='queryFrame' id='queryFrame' 	src='../../eAM/jsp/addmodifyFacilityDept.jsp?facilityId=<%=facilityId%>'  scrolling='no' frameborder=0 style='height:30vh;width:98vw'></iframe>
	<iframe name='resultFrame' id='resultFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:68vh;width:98vw'></iframe>
</html>


<!DOCTYPE html>
<%--
	FileName	: SpecialtyForExternalReferralSourceMain.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<%
	request.setCharacterEncoding("UTF-8");	
	String facilityId = request.getParameter("facilityId");
		if(facilityId == null)  facilityId="";
%>

<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<iframe name='queryFrame' id='queryFrame' src='../../eAM/jsp/SpecialtyForExternalReferralSourceHeader.jsp?facilityId=<%=facilityId%>'  scrolling='no' frameborder=0 style='height:28vh;width:100vw'></iframe>
<iframe name='resultFrame' id='resultFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:70vh;width:100vw'></iframe>

</html>


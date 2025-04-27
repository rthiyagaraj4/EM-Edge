<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%	request.setCharacterEncoding("UTF-8");
	String desktopFlag = request.getParameter("desktopFlag") == null ? "" : request.getParameter("desktopFlag");
%>
<script>
	parent.parent.parent.parent.frames[1].expand();
	if('<%=desktopFlag%>' == 'Y'){
		top.location.reload();
		//parent.parent.parent.parent.frames[1].location.reload();
	}
</script> 


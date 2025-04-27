<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> New Document </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<script src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
	session.removeAttribute("dataList");
	session.removeAttribute("eventList");
	session.removeAttribute("dateList");
	session.removeAttribute("mapDates");
%>
</BODY>
<script>
	if(top.content!=null){
		top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}else{
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}
</script>
</HTML>



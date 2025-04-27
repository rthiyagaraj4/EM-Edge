<!DOCTYPE html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page import="eCommon.XSSRequestWrapper" %>
<HTML>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<HEAD>
<TITLE> New Document </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
</HEAD>
	<iframe src="../../eCA/jsp/ClinicalEventHistoryTabs.jsp?<%=request.getQueryString()%>" name="eventDetailsFrame"  id="eventDetailsFrame"  scrolling="no" frameborder="0" noresize style="height:10vh;width:99vw"></iframe>
		<iframe SRC="../../eCommon/html/blank.html" name='eventDateFrame' id='eventDateFrame' scrolling="yes" frameborder="0" noresize style="height:66vh;width:12vw"></iframe>
		<iframe SRC="../../eCommon/html/blank.html" name='eventNamesFrame' id='eventNamesFrame' scrolling="NO" frameborder="0" noresize style="height:66vh;width:25vw"></iframe>
		<iframe SRC="../../eCommon/html/blank.html" name='eventDataFrame'  id='eventDataFrame' scrolling="yes" frameborder="0" noresize style="height:66vh;width:58vw"></iframe>
		<iframe src="../../eCommon/html/blank.html" name="manageEmailFrame"  id='manageEmailFrame' frameborder="0" noresize style="height:66vh;width:0vw"></iframe> 
	<iframe src="../../eCommon/html/blank.html" name="ClinicalEventButtonFrame"  id='ClinicalEventButtonFrame' scrolling="no" frameborder="1" noresize style="height:6vh;width:99vw"></iframe> 
	<iframe SRC="../../eCommon/html/blank.html" name='controlsFrame' id='controlsFrame' FRAMESPACING=NO FRAMEBORDER="NO" scrolling="no" style="height:4vh;width:99vw"></iframe>
</HTML>

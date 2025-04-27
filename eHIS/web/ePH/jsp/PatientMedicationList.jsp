<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhRepPatFill.js"></SCRIPT>
<HEAD>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	//out.println("params"+params);
	String source = url + params ;
//out.println("source"+source);
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="<%=source%>" style="height:8vh;width:100vw"></iframe><iframe name="searchFrame" id="searchFrame" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="../../ePH/jsp/PhRepPatListCriteria.jsp?medicationlist_flag=Y" style="height:80vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="../../eCommon/jsp/error.jsp" style="height:12vh;width:100vw"></iframe>


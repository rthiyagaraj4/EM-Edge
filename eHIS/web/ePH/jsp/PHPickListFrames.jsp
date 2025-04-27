 <!DOCTYPE html>
 <!--File is Created by Himanshu saxena against GHL-CRF-0672.1 on 13-30-2024-->
<%@page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<!-- 	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
 -->	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhMessages.js"></SCRIPT>
 -->	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PresRemark.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PHPickList.js"></SCRIPT>

</HEAD>

<%


	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%= source %>" frameborder='0' style="height:8vh;width:100vw"></iframe><iframe name="f_picklist" id="f_picklist" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../ePH/jsp/PHPickList.jsp" frameborder='0' style="height:80vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" SRC="../../eCommon/jsp/error.jsp" FRAMEBORDER="0" NORESIZE SCROLLING="auto" frameborder='0' style="height:12vh;width:100vw"></iframe>
</HTML>


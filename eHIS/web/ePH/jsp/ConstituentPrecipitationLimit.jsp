<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");

	
%>

<html>
<head>
	
<!-- <SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhMessages.js"></SCRIPT>
 -->	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/ConstituentPrecipitationLimit.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	
	String mode			= request.getParameter("mode") ;

	
	if(mode==null)mode="1";


%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="ConstituentPrecipitationLimitFrames" id="ConstituentPrecipitationLimitFrames" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:83vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" SRC="../../eCommon/jsp/MstCodeError.jsp" FRAMEBORDER="0" NORESIZE SCROLLING="auto" style="height:9vh;width:100vw"></iframe>

</html>


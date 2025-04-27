<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<html>
<head>
	<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/ExternalProductLink.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String url = "../../ePH/jsp/ExternalProductLinkCriteria.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name="FrameCriteria" id="FrameCriteria" frameborder="0" scrolling="auto" noresize src=<%=source%> style="height:8vh;width:100vw"></iframe><iframe name="FrameActionheader" id="FrameActionheader" src="../../eCommon/html/blank.html" FRAMEBORDER="0" NORESIZE SCROLLING="no" style="height:3vh;width:100vw"></iframe><iframe name="FrameAction" id="FrameAction" src="../../eCommon/html/blank.html" FRAMEBORDER="0" NORESIZE SCROLLING="auto" style="height:89vh;width:100vw"></iframe>
</html>


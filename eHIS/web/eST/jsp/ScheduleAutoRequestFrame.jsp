<%@ page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");

		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language='javascript' src="../../eST/js/StCommon.js"></script>
		<script language='javascript' src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/ScheduleAutoRequest.js"></script>
		<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String url = "../../eST/jsp/ScheduleAutoRequestHeader.jsp?" ;
	String url1 = "../../eST/jsp/ScheduleAutoRequestTabs.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String source1 = url1 + params ;
	
%>
<iframe name='f_schdule_auto' id='f_schdule_auto'  frameborder="0" scrolling='no' noresize src="<%= source %>" style='height:25%;width:100vw'></iframe><iframe name="f_schdule_button" id="f_schdule_button"  frameborder="0" noresize scrolling="no" src="<%= source1 %>" style="height:18%;width:100vw"></iframe><iframe name="f_schdule_detail" id="f_schdule_detail" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style="height:100vh;width:100vw"></iframe>
</html>


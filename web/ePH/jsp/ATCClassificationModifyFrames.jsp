<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<% 
	request.setCharacterEncoding("UTF-8");
//added By Himanshu Start.
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
	
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>


	<script language="JavaScript" src="../js/ATCClassification.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<title><fmt:message key="ePH.ATCClassificationModify.label" bundle="${ph_labels}"/></title>
<%
	String url = "../../ePH/jsp/ATCClassificationModify.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='f_atcmodify' id='f_atcmodify'  frameborder=0 scrolling='auto' noresize src="<%= source %>" style='height:95vh;width:99vw'></iframe>
<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/MstCodeError.jsp" frameborder="0" noresize scrolling="no" style="height:0vh;width:100vw"></iframe>
</html>


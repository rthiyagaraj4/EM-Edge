<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%
    request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String function_id		=	request.getParameter("function_id") ;
	String mode = request.getParameter("mode");

	String locn_type = "";
	String code = "";

	if(mode != null){
		mode = mode;
	}
	if(mode.equals("2")){
		locn_type=	request.getParameter("locn_type") ;
		code=	request.getParameter("code") ;
	}

%>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/OrCommonFunction.js"></script>
	<!--<script language="javascript" src="../js/OrMessages.js"></script>-->
 	<script language="JavaScript" src="../js/PerformingLocation.js"></script>
	<script language="JavaScript"> function_id = "<%=function_id%>"</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String frameSize = "";
	String src1 = "";
	String src2 = "";

	if(mode.equals("1")){
		frameSize = "10%,*";
		src1 = "PerformingLocationAddModifyTop.jsp?function_id="+function_id+"&mode="+mode;
		src2 = "PerformingLocationAddModifyBottom.jsp?function_id="+function_id+"&mode="+mode;
	}else{
		frameSize = "0%,*%";
		src1 = "../../eCommon/html/blank.html";
		src2 = "PerformingLocationAddModifyBottom.jsp?function_id="+function_id+"&mode="+mode+"&locn_type="+locn_type+"&code="+code;
	}
%>
	<iframe name='performing_locn_top' id='performing_locn_top' src='<%=src1%>' frameborder=0 scrolling='no' style="height:5vh;width:100vw"></iframe>
    <iframe name='performing_locn_bottom' id='performing_locn_bottom' src='<%=src2%>' frameborder=0 scrolling='no' style="height:100vh;width:100vw" ></iframe>
	

</html>


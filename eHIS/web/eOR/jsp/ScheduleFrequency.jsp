<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--ScheduleFrequency.jsp -->
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<script language='javascript' src='../js/ScheduleFrquency.js'></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/OrCommon.js"></script>
<script language="JavaScript" src="../js/OrCommonFunction.js"></script>

<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>



<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<script>function_id = "<%=request.getParameter("function_id")%>";
</script>
<title><fmt:message key="eOR.ScheduleFrequency.label" bundle="${or_labels}"/></title>
</head>

<%
	String params		= request.getQueryString() ;
	String mode			= request.getParameter("mode")==null?"": request.getParameter("mode");
	//String p_called_from			= request.getParameter("p_called_from")==null?"": request.getParameter("p_called_from");
	//if(mode.equalsIgnoreCase("1")||((mode.equalsIgnoreCase("2")&&(!p_called_from.equalsIgnoreCase("view")))))
	String height1;
	String height2;
	String height3;
	if(mode.equalsIgnoreCase("1")) {
    height1 = "17vh";  
    height2 = "65vh";  
    height3 = "13vh";  
	} else {
    height1 = "0vh";   
    height2 = "87vh";  
    height3 = "13vh";  
	}
%>
			<iframe name="f_query_add_mod_hdr" src='../../eOR/jsp/FrequencyAddModifyUtilityHeader.jsp?<%=params%>' frameborder="0" scrolling="auto" noresize style="height:<%=height1%>;width:98vw"></iframe> 
			<iframe name="f_query_add_mod" src='../../eOR/jsp/FrequencyAddModifyUtility.jsp?<%=params%>' frameborder="0" scrolling="auto" noresize style="height:<%=height2%>;width:98vw"></iframe> 
			<iframe name="f_query_close" src='../../eOR/jsp/ScheduleFrequencyButtons.jsp?<%=params%>' frameborder="0" scrolling="no" noresize style="height:<%=height3%>;width:98vw"></iframe>
			
			<%-- <frame name='f_query_add_mod_hdr' src='../../eOR/jsp/FrequencyAddModifyUtilityHeader.jsp?<%=params%>' frameborder=0 scrolling='auto' noresize>
			<frame name='f_query_add_mod' src='../../eOR/jsp/FrequencyAddModifyUtility.jsp?<%=params%>' frameborder=0 scrolling='auto' noresize>
			<frame name='f_query_close'	src='../../eOR/jsp/ScheduleFrequencyButtons.jsp?<%=params%>' frameborder=0  scrolling='no' noresize>
		</frameset> --%>

</html>

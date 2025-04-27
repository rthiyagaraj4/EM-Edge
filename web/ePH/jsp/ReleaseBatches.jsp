<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%><!--Added for Bru-HIMS-CRF-416[IN045566]-->  
<html>                                
	<head>                                
		<title><fmt:message key="ePH.ReleaseBatch.label" bundle="${ph_labels}"/></title>    <!--Added for Bru-HIMS-CRF-416[IN045566]-->  
		
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	 	<script language="javascript" src="../../ePH/js/ReleaseBatches.js"></script>
		<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>                               
<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
	
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String fromPage = request.getParameter("frompage")==null?"":request.getParameter("frompage");
	String source = url + params ;
	String style1 = "";
	String style2 = "";
	String style3 = "";
	String style4 = "";
	String style5 = "";
	if( fromPage.trim().length()==0){// if condition and else block Added for Bru-HIMS-CRF-416[IN045566] -start 
		 style1 = "height:8vh;width:100vw";
		 style2 = "height:25vh;width:100vw";
		 style3 = "height:50vh;width:100vw";
		 style4 = "height:8vh;width:100vw";
		 style5 = "height:9vh;width:100vw";
%>
		<!-- <frameset rows="8%,15%,*,10%,9%"> -->
		
		<iframe name="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="<%= style1 %>"></iframe>
<%
	}
	else{
		style2 = "height:30vh;width:100vw";
		style3 = "height:53vh;width:100vw"; 
		style4 = "height:8vh;width:100vw";
		style5 = "height:9vh;width:100vw";

%>      

	<!-- <frameset rows="17%,*,10%,9%"> -->	
<%     
	}
%>
	
	<iframe name="f_query_criteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/ReleaseBatchesQueryCriteria.jsp?<%=params%>" style="<%= style2 %>"></iframe>  <!--Modified for Bru-HIMS-CRF-416[IN045566] -->
	<iframe name="f_query_result" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="<%= style3 %>"></iframe>
	<iframe name="f_batch_result" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="<%= style4 %>"></iframe>
	<iframe name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="<%= style5 %>"></iframe>
</html>

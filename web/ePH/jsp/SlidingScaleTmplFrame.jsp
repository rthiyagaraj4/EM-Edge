<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<%

	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
		String locale= (String)session.getAttribute("LOCALE");
       String sStyle=  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String )session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	  
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/messages.js"></script> 
		<script language='javascript' src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../ePH/js/SlidingScaleTmpl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String url = "../../ePH/jsp/SlidingScaleTmplDetails.jsp?" ;
	String url1 = "../../ePH/jsp/SlidingScaleTmplRange.jsp?";
	String url2= "../../ePH/jsp/SlidingScaleTmplRangeDetails.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String source1 = url1 + params ;
	String source2 = url2 + params ;
	
%>
<iframe name='f_sliding_scale_temp' id='f_sliding_scale_temp'  frameborder="0" scrolling='no' noresize src="<%= source %>" style='height:18vh;width:100vw'></iframe><iframe name="f_temp_range" id="f_temp_range"  frameborder="0" noresize scrolling="no" src="<%= source1 %>" style="height:28vh;width:100vw"></iframe><iframe name="f_temp_range_detail" id="f_temp_range_detail" src="<%= source2 %>" frameborder="0" noresize scrolling="auto" style="height:54vh;width:100vw"></iframe>

</html>


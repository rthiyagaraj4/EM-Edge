<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	try
	{
		String params = request.getQueryString();
//		System.out.println("params BLAdhocDiscDtlsEditFrame.jsp:"+params);
%>	
<title><fmt:message key="eBL.REC_ADHOC_DISC.label" bundle="${bl_labels}"/></title>

  <iframe name='disc_edit_frame' id='disc_edit_frame' SRC="../../eBL/jsp/BLAdhocDiscDtlsEdit.jsp?<%=params%>" frameborder=0 scrolling='no' noresize style='height:100vh;width:100vw'></iframe> 	
		<iframe SRC="../../eCommon/html/blank.html"	  name="validation_frame" id="validation_frame" frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>	

<%
	}
	catch(Exception ee)
	{
		out.println("from main :"+ee);
	}
%>
</HTML>


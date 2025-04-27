<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
-----------------------------------------------------------------------------------------
Date       		Edit History     	Name        Rev.Date   Rev.By		Description
-----------------------------------------------------------------------------------------
10/04/2014    	IN048562			Karthi	   		?			?		   	Short Description with special characters: while placing order click on order set
17/07/2018	  	IN064543		Kamalakannan	17/07/2018		Ramesh G		ML-MMOH-CRF-0776
------------------------------------------------------------------------------------------
-->
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String catalog_desc		= request.getParameter("catalog_desc");
	String Instrn_flag		= request.getParameter("Instrn_flag")==null?"":request.getParameter("Instrn_flag");//IN064543
	 // commented for IN048562 - Start
	/*if(catalog_desc==null) catalog_desc= "";
		catalog_desc = java.net.URLDecoder.decode(catalog_desc,"UTF-8");
	*/
	// commented for IN048562 - End
%>
<html>
<head>
	 <title>	
	 <%if("Y".equals(Instrn_flag)){%>
			<fmt:message key="eOR.Instruction.label" bundle="${or_labels}"/>-<%=catalog_desc%>
		<%}else{%>
			<%=catalog_desc%>
		<%}%>
	 </title>
	 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
</head>
	<!-- IN064543 Start -->
	<%if("Y".equals(Instrn_flag)){%>
		     <iframe name="PanelsFrame" id="PanelsFrame" src= "../../eOR/jsp/OrderEntryToolTipForInstructions.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="auto" style="height:21vh;width:100vw"></iframe>
				<iframe name="InstrnFrame" id="InstrnFrame" src="../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="auto" style="height:60vh;width:100vw"></iframe>
		    
		    <%}else{%><!-- IN064543 end -->
		    <iframe name="PanelsFrame" id="PanelsFrame" src= "../../eOR/jsp/OrderEntryToolTip.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="auto" style="height:21vh;width:100vw"></iframe>
		    
    <%}//IN064543%>
</html>


<!DOCTYPE html>
 <!-- Developed by    :Karabi Sarma
Module/Function : Drug Information Enquiry ( Transctions) 

-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	 <script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	 <script language="JavaScript" src="../../ePH/js/PhDrugInfo.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
String mode	= request.getParameter( "mode" ) ;

if(mode==null) mode="";
String function_id=request.getParameter("function_id") ;
if(function_id==null) function_id="";
String Enq_num=request.getParameter("Enq_num") ;
if(Enq_num==null) Enq_num="";
%>

	
	<iframe name="f_request1" id="f_request1" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PhDrugInfoReqDtls.jsp?function_id=<%=function_id%>&mode=<%=mode%>&Enq_num=<%=Enq_num%>" style="height:38vh;width:100vw"></iframe>
	 
	 <iframe name="f_request2" id="f_request2" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/PhDrugInfoReqCatgDtls.jsp?function_id=<%=function_id%>&mode=<%=mode%>&Enq_num=<%=Enq_num%>" style="height:62vh;width:100vw"></iframe>
	  <!-- <frame name="f_request3" id="f_request3" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PhDrugInfoReqDtlsFrame.jsp?function_id='<%=function_id%>'&mode='<%=mode%>'">	 -->  
	  

</html>


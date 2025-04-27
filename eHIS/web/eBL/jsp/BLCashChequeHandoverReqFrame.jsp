<!DOCTYPE html>
<%@page import="eBL.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%		String params = request.getQueryString();
		String bean_id = "" ;	    String bean_name="";		 
		 bean_id = "BLCashChequeHandOverBean" ;
		 bean_name = "eBL.BLCashChequeHandOverBean";
		 BLCashChequeHandOverBean bean			= (BLCashChequeHandOverBean)getBeanObject( bean_id, bean_name, request ) ; 
		 bean.clearBean();

%>
<HTML>
<HEAD>
</HEAD>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src='../../eBL/js/BLCashChequeHandover.js'></script>
		<!--<script language='javascript' src='../js/BLCashCounterLogout.js'></script>-->
		<iframe name='BLCashChequeHandoverCashCounterFrame' id='BLCashChequeHandoverCashCounterFrame' src='../../eBL/jsp/BLCashChequeHandoverCashCounterDtls.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style='height:12vh;width:100vw'></iframe>
			<iframe name='BLCashChequeHandoverCashChqCollFrame' id='BLCashChequeHandoverCashChqCollFrame' src='../../eBL/jsp/BLCashChequeHandoverCashChqCollectionDtls.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style='height:13vh;width:100vw'></iframe>
			<!--<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='BLCashChequeHandoverCashChqCollFrame' id='BLCashChequeHandoverCashChqCollFrame' scrolling='no' noresize></iframe>-->
			<!--	<iframe name='BLCashChequeHandoverCashChqCollDtlsFrame' id='BLCashChequeHandoverCashChqCollDtlsFrame' src='../../eBL/jsp/BLCashChequeHandoverReqDtlsFrame.jsp?<%=params%>' frameborder=0 scrolling='no' noresize></iframe>-->
			<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='BLCashChequeHandoverCashChqCollDtlsFrame' id='BLCashChequeHandoverCashChqCollDtlsFrame' scrolling='no' noresize style='height:66vh;width:100vw'></iframe>
			<!--	<iframe name='BLCashChequeHandoverTransDtlsFrame' id='BLCashChequeHandoverTransDtlsFrame' src='../../eBL/jsp/BLCashChequeHandoverTransDtls.jsp?<%=params%>' frameborder=0 scrolling='auto' noresize></iframe>-->
			<iframe name='BLCashChequeHandoverTransDtlsFrame' id='BLCashChequeHandoverTransDtlsFrame' SRC="../../eCommon/html/blank.html" frameborder=0 scrolling='auto' noresize style='height:20vh;width:100vw'></iframe>
		
	<%putObjectInBean(bean_id,bean,request);%>
</HTML>


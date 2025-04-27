<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
11/10/2017	  	IN064272	        prathyusha 											GHL-CRF-0466 [IN064272] 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"    import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
 <HTML>
 <HEAD>
<%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<%

	String url = "../../ePH/jsp/FormularySearchCriteriaForm.jsp" ;
	String params = request.getQueryString() ;
	String source = url +"?"+ params ;
//System.err.println("FormularySearchQueryFrame.jsp====ds===>");

%>
<iframe name="FormularyQuerySearchFrame" id="FormularyQuerySearchFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%=source%>" style="height:35vh;width:100vw"></iframe><iframe name="FormularyQueryResult" id="FormularyQueryResult" FRAMEBORDER="0" SCROLLING="yes" NORESIZE SRC="../../eCommon/html/blank.html" style="height:70vh;width:100vw"></iframe><iframe name="" id="" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:10vh;width:100vw"></iframe>

</HTML>


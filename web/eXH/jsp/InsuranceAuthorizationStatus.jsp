<!DOCTYPE html>
<%
/*
Added by Niveditha For MOHE-CRF-0026.3 
*/
%>

<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*, java.util.*,java.lang.*," contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>			
<head>
<title>Dispense Authorization and Bill Generation</title>

<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></SCRIPT>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

</head>
<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:6vh;width:100vw"></iframe>
<iframe name="InsuranceAuthorizationStatusCriteriaFrame" id="InsuranceAuthorizationStatusCriteriaFrame" frameborder="0" scrolling="no" noresize src="../../eXH/jsp/InsuranceAuthorizationStatusCriteria.jsp" style="height:17vh;width:100vw"></iframe>
<iframe name="InsuranceAuthorizationStatusResultFrame" id="InsuranceAuthorizationStatusResultFrame" FRAMEBORDER="0"  SRC="../../eCommon/html/blank.html" style="height:79vh;width:100vw"></iframe>
<iframe name='messageFrame' id='messageFrame'	src="../../eXH/jsp/NewProcedureMessage.jsp" frameborder=0 noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
</html>



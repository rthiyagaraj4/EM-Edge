<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	
06/02/2018		IN065642		Prathyusha P				 		GHL-CRF-0487 [IN:065642]

---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eOR.* ,eOR.Common.*, java.util.*,java.lang.*,eOR.* ,eOR.Common.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
request.setCharacterEncoding("UTF-8");

String cols = "";
String title = "";

%>
<head>
<title>
<%=title%>
</title>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></SCRIPT>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script></head>


<iframe name="teleRadiologyOrdersCriteriaFrame" id="teleRadiologyOrdersCriteriaFrame" frameborder="0" scrolling="no" noresize src="../../eOR/jsp/TeleRadiologyOrdersCriteria.jsp" style="height:22vh;width:100vw"></iframe>
		<iframe name="teleRadiologyOrdersResultFrame" id="teleRadiologyOrdersResultFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:86vh;width:100vw"></iframe>



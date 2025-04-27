<!DOCTYPE html>
<%/* 
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
21/11/2012		IN035914		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and more appealing. Keeping the display of information more clear and visible.   								 
15/03/2012 		IN038579		Nijitha		CRF-CA-CHL-CRF-0006/05-Redefine summary Component-> System is displaying error message 											  even after entering data for User Defined description.								 
-------------------------------------------------------------------------------------------------------------------------------------
*/%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<script src="../../eCommon/js/common.js" language="javascript"></script><!--IN038579-->
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="javascript" src="../js/CASummCompRedefine.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;

	
%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" src='<%=source%>' frameborder=0 scrolling="no" noresize style='height:8vh;width:100vw'></iframe>
	<iframe name="f_query_add_mod" id="f_query_add_mod" src='../../eCA/jsp/CASummCompRedefine.jsp'frameborder=0 scrolling="no" noresize style='height:82vh;width:100vw'></iframe>
	<iframe name="messageFrame" id="messageFrame" src="../../eCA/jsp/CAError.jsp" frameborder=0 scrolling="auto" noresize style="height:10vh;width:100vw"></iframe>

</html>


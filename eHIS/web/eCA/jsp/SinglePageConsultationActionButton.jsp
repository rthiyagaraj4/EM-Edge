<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
20/05/2014    IN037701		Ramesh G				      					SKR-CRF-0036 	
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
        <script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
        <script language="javascript" src="../../eCommon/js/common.js" ></script>
		<script src="../../eCA/js/SinglePageConsultation.js"
	language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<br>
	<form name="frmPrint" id="frmPrint">
		<p align="right">
			<input type="button" name="btnPrint" id="btnPrint" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>" onClick="funPrint1();"/>
			 <input type="button" name="btnPrintPreview" id="btnPrintPreview" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintPreview.label","common_labels")%>" onClick="fun();"/>
		</p>
		<input type='hidden' name='totalWidgetCount' id='totalWidgetCount' value=''/>
		<input type='hidden' name='totalVisits' id='totalVisits' value=''>
		<input type='hidden' name='req_encounter_id' id='req_encounter_id' value=''> 
		<input type='hidden' name='patient_id' id='patient_id' value=''>
		<input type='hidden' name='no_of_widgets' id='no_of_widgets' value=''>
		<input type='hidden' name='called_from' id='called_from' value=''>
		<input type='hidden' name='reloadWidgetCount' id='reloadWidgetCount' value='0'>
		<input type='hidden' name='authorize_diagnosis' id='authorize_diagnosis' value=''/>
		<input type='hidden' name='option_id' id='option_id' value=''>
	</form>

</body>
</head>
</html>


<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
22/03/2012    IN29559       DineshT      Record consent criteria in TaskList function
----------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History      Name        		Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------
01/09/2016	IN060107	Krishna Gowtham										 ML-MMOH-SCF-0390
---------------------------------------------------------------------------------------------------------------
--> 
<%-- Mandatory declarations start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
	<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
		<title><fmt:message key="eOR.Editor.label" bundle="${or_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
			<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="Javascript" src="../../eCommon/js/common.js"></script>
			<script language="Javascript" src="../../eOR/js/ConsentDetails.js"></script>
			<script language="Javascript" src="../../eOR/js/ConsentOrder.js"></script>
			<script language="Javascript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	 <form name ="editorButtonForm">
<%
	
	 String bean_id				= request.getParameter("bean_id");
	 String bean_name			= request.getParameter("bean_name");
 	 ConsentOrders bean			= (ConsentOrders)getBeanObject( bean_id, bean_name ,request) ;
  	 bean.setLanguageId(localeName);
	 String consent_form_id		= request.getParameter("consent_form_id");
 	 String index				= request.getParameter("index");
  	 HashMap consentDetail		= bean.getConsentDetail();
  	 String consent_details		= (String)consentDetail.get(index+consent_form_id);
	 if(consent_details==null || consent_details.equals("<ADDRESS>&nbsp;</ADDRESS>"))	consent_details ="";//Modified by Chowminya
	 String task_categ				= request.getParameter("task_categ");//Chowminya,IN29559
	 //IN060107 Start
	 int time_interval = 0;
	 time_interval = bean.getTimeInterval();
	 //IN060107 End
 %>
			<table border="0" cellpadding="3" cellspacing="0" width="100%" id='test'>
			<tr>
				<td class="label"><jsp:include page="EditorButton.jsp" ><jsp:param name="flush" value="true" />
								  <jsp:param name ="p_ok_button" value= "" /> 
								  </jsp:include>
				</td>
			 	<td class="label">
				<a class="gridLink" href="#" onClick="zoomWindow()">
					<img id="zoom" src="../../eOR/images/Maximize.gif" title='Zoom In'></img>
				</a>
  				</td>
			</tr>
			<tr>
				<td colspan="3" class='fields'><textarea rows="0" cols="25" name="RTEText" style="visibility:hidden"><%=consent_details%></textarea></td>
			</tr>
  			<!--<script>setTimeout("setZoomEditorTemplate()",200);</script>--><!-- commented for IN060107 -->
			<Script>setTimeout("setZoomEditorTemplate()",<%=time_interval%>);</script> <!-- [IN060107] -->
			<input type="hidden" name ="bean_id" value="<%=bean_id%>">
			<input type="hidden" name ="bean_name" value="<%=bean_name%>">
			<input type="hidden" name ="consent_form_id" value="<%=consent_form_id%>">
 			<input type="hidden" name ="index" value="<%=index%>">
			<input type="hidden" name ="task_categ" value="<%=task_categ%>"><!--Chowminya,IN29559-->
			<!-- <input type="hidden" name="localeName" id="localeName" value="<%=localeName%>"> -->
 			</table>
 	 </form>
   </body>
</html>


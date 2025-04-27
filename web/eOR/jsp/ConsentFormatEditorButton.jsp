<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
---------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------
23/03/2016	IN059763		Karthi L										Unable to view the Consent details after configured it.[ML-MMOH-SCF-0371]
---------------------------------------------------------------------------------------------------------
*/
%>
<%-- Mandatory declarations start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
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
			<script language="Javascript" src="../../eOR/js/ConsentFormat.js"></script>

			<script language="javascript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- for Number validations -->
 	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	 <form name ="editorButtonForm">
<%
	 
	 String bean_id = request.getParameter( "bean_id" ) ;
	 String bean_name = request.getParameter( "bean_name" ) ;
 	 ConsentFormat bean  = (ConsentFormat)getBeanObject( bean_id, bean_name ,request) ;
	 bean.setLanguageId(localeName);
	 int time_interval = 0;
	 time_interval = bean.getTimeInterval();
%>
		
			<table border="0" cellpadding="3" cellspacing="0" width="100%" id='test'>
			<tr>
				<td><jsp:include page="EditorButton.jsp" flush="true"/></td>
			</tr>
			<tr>
				<td colspan="3" class='fields'>
					<textarea rows="0" cols="25" name="RTEText" id="RTEText" style="visibility:hidden"><%=bean.getConsentValues()%></textarea>
				</td>
			</tr>
 			<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="mode" id="mode" value="<%=request.getParameter("mode")%>">
  			<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="consent_type" id="consent_type"
			value="<%=request.getParameter("consent_type")%>">
  			<input type="hidden" name="consent_form_id" id="consent_form_id" value="<%=request.getParameter("consent_form_id")%>">
			<input type="hidden" name="consent_form_label" id="consent_form_label" value="<%=request.getParameter("consent_form_label")%>">
			<input type="hidden" name="consent_format" id="consent_format" value="<%=request.getParameter("consent_format")%>">
			<input type="hidden" name="effective_status" id="effective_status" value="<%=request.getParameter("effective_status")%>">
			<input type="hidden" name="indexed" id="indexed" value="<%=request.getParameter("indexed")%>">
			<!--<input type="hidden" name="table_count" id="table_count" value="">--><!--will be set dynamically when table has been created-->
		<!--	<Script>setTimeout("setEditorTemplate()",200);</script> --> <!-- commented for ML-MMOH-SCF-0371 [IN059763] -->
			<Script>setTimeout("setEditorTemplate()",<%=time_interval%>);</script> <!-- ML-MMOH-SCF-0371 [IN059763] -->
 		</table>
<%
		// NO NEED FOR setting it for persistence
		//putObjectInBean(bean_id,bean,request);
%>
		</form>
	</body>
</html>


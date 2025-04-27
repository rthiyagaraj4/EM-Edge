<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*,java.util.*, eOR.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<%-- Mandatory declarations end --%>
<html>
<head>
<title><fmt:message key="eOR.PractForConsentHeader.label" bundle="${or_labels}"/></title>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="JavaScript" src="../../eOR/js/PractForConsent.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
  String group_by = request.getParameter("group_by");
  String label_desc ="", label_lookup ="", service_sql ="";
  String before_label_lookup = "";
  if(group_by == null || group_by.equals(""))
		group_by="";
  if(group_by.equals("P")){
		label_desc=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
		//label_desc = "Practitioner";
		label_lookup = "show_pract_lookup(pract_consent_desc,pract_consent_code);";
		before_label_lookup = "before_show_pract_lookup(this,pract_consent_code);";
		service_sql = OrRepositoryExt.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_PRAC_LOOKUP");
	}
  else if(group_by.equals("C")){
		label_desc=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ConsentForm.label","common_labels");
		//label_desc = "Consent Form";
		label_lookup = "show_consent_lookup(pract_consent_desc,pract_consent_code);";
		before_label_lookup = "before_show_consent_lookup(this,pract_consent_code);";
		service_sql = OrRepositoryExt.getOrKeyValue("SQL_OR_CATALOG_CONSENT_FORMAT_MULTI");
	}
%>

<%
	String bean_id = "practforconsentbean" ;
	String bean_name = "eOR.PractForConsentBean";
	String mode = "1";
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	PractForConsentBean bean = (PractForConsentBean)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clearDBRec();
	bean.setGroup_by(group_by);
%>

<body class='CONTENT' onLoad="document.formPractForConsentHdr.group_by.focus();" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='formPractForConsentHdr' id='formPractForConsentHdr'>
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
		<tr>
			<td class='label' width='15%'><fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
			<td class='fields' align='left'><select name='group_by' id='group_by' onChange='return selectPractOrConsent(this);'>
			<%if (group_by.equals("P")) {%>
			 	<option value="P" SELECTED><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
				<option value="C"><fmt:message key="Common.ConsentForm.label" bundle="${common_labels}"/></option>
			<%} else if(group_by.equals("C")) {%>
			
				<option value="P"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
				<option value="C" SELECTED><fmt:message key="Common.ConsentForm.label" bundle="${common_labels}"/></option>
	
			<%}%>
			</select><img src="../../eCommon/images/mandatory.gif"></img></td>

			<td class='label' width='15%'><%=label_desc%></td>
			
			<td class='fields'>
			<input type='text' name='pract_consent_desc' id='pract_consent_desc' value="" onBlur="<%=before_label_lookup%>"><input type='button' class="button" name="pract_consent_button" id="pract_consent_button" value="?" onClick="<%=label_lookup%>">
			<img src="../../eCommon/images/mandatory.gif" >
			</td>
		</tr>
		</table>
		<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<input type='hidden' name='pract_consent_code' id='pract_consent_code' value="">
	<input type="hidden" name="service_sql" id="service_sql" value="<%=service_sql%>">
	<input type="hidden" name="temp_service_desc" id="temp_service_desc" value="">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type='hidden' name='localeName' id='localeName' value="<%=localeName%>">
</form>
</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>


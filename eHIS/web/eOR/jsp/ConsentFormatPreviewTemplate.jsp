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
-----------------------------------------------------------------------
Date			Edit History	Name        Description
-----------------------------------------------------------------------
?				100         	?     		created	 
09/11/2012		IN030473		Ramesh G	Bru-HIMS-CRF-032 								 
-----------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %> 
<%-- JSP Page specific attributes end --%>   

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>  <!-- For the common Lookup -->
 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
 	<script language="JavaScript" src="../../eOR/js/ConsentFormat.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 </head>

<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<%
	
  	/* Mandatory checks start */
	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	String consentType=request.getParameter( "consent_type" ) ;  //IN030473
	String[] record = null;
	 

/* Mandatory checks end */
 	/* Initialize Function specific start */
 	ConsentFormat bean  = (ConsentFormat)getBeanObject( bean_id, bean_name ,request) ;
  	ArrayList templateValues		= null;
	ArrayList dynamicTemplateValues	= bean.getTemplateValues("V"); 
/* Initialize Function specific end */


	// getTemplateValues() , this method is there in the OrAdapter

%>


<form name="editor_preview" id="editor_preview" method="post" target="messageFrame">
<table cellpadding=3 cellspacing=0 border=1 width="100%" align=center>
<tr>
 	<th class='columnheader' width="25%"><fmt:message key="Common.patient.label" bundle="${common_labels}"/></td>
	<th class='columnheader' width="25%"><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></td>
	<!-- IN030473 Start. -->
	<!--<td class='columnheader' width="25%"><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></td>-->	
	<%
	if("I".equals(consentType)){
	%>
	<th class='columnheader' width="25%"><fmt:message key="eOR.Intervention.label" bundle="${or_labels}"/></td>
	<%
	}else{
	%>
	<th class='columnheader' width="25%"><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></td>
	<%
	}
	%>
	<!-- IN030473 End. -->
<%	if(dynamicTemplateValues!=null && dynamicTemplateValues.size()>0) {  		 %>
	<th class='columnheader' width="25%"><fmt:message key="Common.Variance.label" bundle="${common_labels}"/></td>
<%	} %>
 </tr>
<tr VALIGN="top">
<%	
	// For the Patient bring the details
	templateValues		= bean.getTemplateValues("P"); 
	if(templateValues!=null && templateValues.size()>0) {  	
%>

<td width="25%" class="label">
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>

<%		for( int i=0 ; i< templateValues.size(); i++ ) { 
			 record = (String[])templateValues.get(i); 
			// System.out.println("record[0]="+record[0]);
			 //System.out.println("record[1]="+record[1]);
%>
			<tr><td class="label"><a class="gridLink"  href="javascript:setPreviewTemplate('<%=record[1]%>')"><%=record[0]%></a></td></tr>
 
<%  } %>
<%  } %>
</table>
</td>
<%
	// For the Encounter bring the details
	templateValues		= bean.getTemplateValues("E"); 
	if(templateValues!=null && templateValues.size()>0) {  		 %>
<td width="25%"  class="label">
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>

 <%		for( int i=0 ; i< templateValues.size(); i++ ) { 
			 record = (String[])templateValues.get(i);  
%>
			<tr><td class="label"><A class="gridLink"  href="javascript:setPreviewTemplate('<%=record[1]%>')"><%=record[0]%></a></td></tr>
  
 <%  } %>
<%  } %>
</table>
</td>
<%
if("I".equals(consentType)){
	// For the Intervention bring the details
	templateValues		= bean.getTemplateValues("I"); 
	if(templateValues!=null && templateValues.size()>0) {  		 %>
<td width="25%" class="label">
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>

 <%		for( int i=0 ; i< templateValues.size(); i++ ) { 
			 record = (String[])templateValues.get(i);  
%>
			<tr><td class="label"><A class="gridLink" href="javascript:setPreviewTemplate('<%=record[1]%>')"><%=record[0]%></a></td></tr>
  
<%  } }
}else{
	// For the Orderable bring the details
	templateValues		= bean.getTemplateValues("O"); 
	if(templateValues!=null && templateValues.size()>0) {  		 %>
<td width="25%" class="label">
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>

 <%		for( int i=0 ; i< templateValues.size(); i++ ) { 
			 record = (String[])templateValues.get(i);  
%>
			<tr><td class="label"><A class="gridLink" href="javascript:setPreviewTemplate('<%=record[1]%>')"><%=record[0]%></a></td></tr>
  
<%  } }}%>

 </table>
 </td>
<%
	
	// For the Dynamic LookUp items.
	if(dynamicTemplateValues!=null && dynamicTemplateValues.size()>0) {  		 %>
<td width="25%"  class="label">
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>

 <%		for( int i=0 ; i< dynamicTemplateValues.size(); i++ ) { 
			 record = (String[])dynamicTemplateValues.get(i);  
%>
			<tr><td class="label"><A class='gridLink' href='javascript:showVarianceLookUp("<%=record[1]%>")'><%=record[0]%></a><input type="hidden" name="<%=record[1]%>" id="<%=record[1]%>" value="<%=record[4]%>"></td></tr>
  
<%  } %>
<%  } %>
 </table>
 </td>
</tr>
</table> 
<%
	// Nullifying the objects
	if(templateValues!=null) {
		templateValues.clear();	
		templateValues		= null;
	}
	if(dynamicTemplateValues!=null){
		dynamicTemplateValues.clear();
		dynamicTemplateValues = null;
	}
	// Persistence
	//putObjectInBean(bean_id,bean,request);
%>

</form>
</body>

</html>


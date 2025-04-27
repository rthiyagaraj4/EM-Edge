<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>   

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonCalendar.js"></script> <!-- To display the calendar --> 
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>  <!-- For the common Lookup -->
	<script language="Javascript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<%
  	/* Mandatory checks start */
	
 	String bean_id						= request.getParameter( "bean_id" ) ;
	String bean_name					= request.getParameter( "bean_name" ) ;

 	String[] record						= null;
/* Mandatory checks end */		
 	/* Initialize Function specific start */
 	OrAdapter bean					= (OrAdapter)getBeanObject( bean_id, bean_name ,request) ;
	bean.setLanguageId(localeName);

    /* Initialize Function specific end */
	// getTemplateValues() , this method is there in the OrAdapter
 	// For the General bring the details
	ArrayList templateValues		= bean.getTemplateValues("C"); 
%>
<form name="editor_template" id="editor_template" method="post" target="messageFrame">
	<table cellpadding=0 cellspacing=1 border=0 width="100%" height='100%' align=center>
	<tr>
		<td class='COLUMNHEADER'><fmt:message key="eOR.CommonLookUps.label" bundle="${or_labels}"/></td>
	</tr>
	<tr>
		<td>
		 <table cellpadding=0 cellspacing=1 border=0 width="100%" align=center class="grid">
	<%	
		if(templateValues!=null && templateValues.size()>0) {  		 
		for( int i=0 ; i< templateValues.size(); i++ ) { 
			 record = (String[])templateValues.get(i);  
	%>
	<td align=left class="gridData"><A class="gridLink"  href="javascript:showLookUp('<%=record[1]%>','<%=record[0]%>')"><%=record[0]%></a><input type="hidden" name="<%=record[1]%>" id="<%=record[1]%>" value="<%=record[4]%>"></td>
	

	<%
		
		if(i%3==2) out.println("</tr><tr>");	
		} %>
	<%  } %>
			<input type="hidden" name="practitioner_id" id="practitioner_id" value="">
			<input type="hidden" name="current_date_time" id="current_date_time" value="" id="current_date_time">
			<input type="hidden" name="currLocaleName" id="currLocaleName" value="<%=localeName%>">
			<!--Hidden currLocaleName was added by Dinesh T on 11/19/2010 for incident no 25051-->
			<input type="hidden" name="prac_sql" id="prac_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP_SQL2_ADMIN")%>">
		</table>
		</td>
  	</tr>
	</table>
</form>
</body>
</html>
<!-- No need to set it back for persistence -->


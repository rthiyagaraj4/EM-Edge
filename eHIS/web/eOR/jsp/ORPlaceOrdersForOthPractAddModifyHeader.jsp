<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--ORPlaceOrdersForOthPractAddModifyHeader.jsp -->
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="eOR.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%
	String function_id = request.getParameter( "function_id" ) ;

%>
<html>
<head>
<%
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ORPlaceOrdersForOthPract.js"></script>
	<script language="JavaScript"> function_id = "<%=function_id%>"</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head><body onload='FocusFirstElement()'  OnMouseDown="CodeArrest()" >

<%
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	String bean_id = "Or_PlaceOrdersForOthPractBean" ;
	String bean_name = "eOR.PlaceOrdersForOthPractBean";
	
	/* Initialize Function specific start */
	PlaceOrdersForOthPractBean bean = (PlaceOrdersForOthPractBean)getBeanObject( bean_id,bean_name ,request ) ;  
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.clearDBRec();
%>

<form name='place_order_pract_header' id='place_order_pract_header' target='messageFrame' >
<table cellpadding=0 cellspacing=0 border=0 width="100%" >
	<tr>
		<td width="20%"   class="label"></td>
		<td width="20%"   class="label"><fmt:message key="eOR.AllowedType.label" bundle="${or_labels}"/></td>
		<td>
			<SELECT name="allowed_type" id="allowed_type" onChange='loadPage(this)'>
				<option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<option value="P"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
				<option value="T"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></option>
				<option value="R"><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></option>
			</SELECT><img src="../../eCommon/images/mandatory.gif"></td></tr>
		</td>
	</tr>
	</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">

</form>
</body>
</html>
<%
putObjectInBean( bean_id, bean , request) ;  
%>


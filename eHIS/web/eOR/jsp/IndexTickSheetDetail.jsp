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
------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------
?           100            	?           	?				?					created
09/10/2014	IN050655		VijayakumarK	09/10/2014							iASSIST ID : 807002 Index Tick sheet by practitioner is a 
																				good functionality to provide personalised tick sheets to practitioners.
------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*, eOR.*, eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eOR/js/IndexTickSheet.js"></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script><!-- IN050655 -->
	<Script src='../../eCommon/js/CommonLookup.js' language ='JavaScript'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- IN050655 -->
	<STYLE TYPE="text/css">

	A:active { 
		COLOR: white; 
	}

	A:visited { 
		COLOR: white; 
	}
	A:link { 
		COLOR: white; 
	}
 
	</STYLE>

	<script>
	function lockKey() {
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	}
	</script>

</head>

<body onMouseDown='CodeArrest()'; onKeyDown='lockKey()'; >
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode				=	request.getParameter( "mode" ) ;
	String index_type		= request.getParameter( "index_type" ) ;
	String order_category	= request.getParameter( "order_category" ) ;
	String tick_sheet_id	= request.getParameter( "tick_sheet_id" ) ;

	String bean_id = "indexticksheet" ;
	String bean_name = "eOR.IndexTickSheet";
	//String readOnly = "" ;
	//String disabled = "" ;
	mode="1";	
	
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;
	
	/* Mandatory checks end */

	/* Initialize Function specific start */
	IndexTickSheet bean = (IndexTickSheet)getBeanObject( bean_id,  bean_name, request ) ;  
	/* Initialize Function specific end */
	
%>

<form name="formIndexTickShDetail" id="formIndexTickShDetail">
<table cellpadding=3 cellspacing=0 border ="0" width="100%" align="center" id="Tab">
<%if(index_type.equals("F")){%>
<tr>
	<td class="label" width='35%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	<td class='fields'><select name="facility_id" id="facility_id">
		<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option><%=bean.getComboOptionsFacId()%> 
	</select><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
	
</tr>
<tr>
	<td class="label"><fmt:message key="Common.SourceType.label" bundle="${common_labels}"/></td>
	<td class='fields'><select name="source_type" id="source_type" onChange="callSourceDtl(this);" >
		<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
		<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
		
	</select><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
</tr>
<tr id="rowSelAssTab" name="rowSelAssTab" style="visibility:hidden">
	<td colspan='2'>
		<table align='left' cellspacing='0' cellpadding='0' width="30%" border='1'>
			<tr>
				<td id="SelectTab" class="clicked" width="15%" height="20" align="center"><a href='javascript:dispLink("S")'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a></td>
				<td id="AssociateTab" class="normal" width="15%" height="20" align="center" ><a href='javascript:dispLink("A")'><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></a></td>
			</tr>
		</table>
	</td>
</tr> 
<!-- IN050655 starts -->
<tr id="tbsrch_row" style="visibility:hidden">
<td id="searchcriteriaTab" colspan='2'>
<jsp:include page="IndexTickSearchCriteria.jsp" flush="true"/>
</td>
</tr>
<!-- IN050655 ends-->
<tr id="rowLinkTab" name="rowLinkTab" style="visibility:hidden">
	<td colspan='2' align='left' id='linkId'>
		<jsp:include page="OrCommonAlphaLink.jsp" flush="true"/>
	</td>
</tr>
<%}else if((index_type.equals("S")) || (index_type.equals("P"))){%>
<tr>
	<td colspan='2'>
		<table align='left' cellspacing='0' cellpadding='0' width="30%" border='1'>
			<tr>
				<td id="SelectTab" class="clicked" width="15%" height="20" ><a href='javascript:dispLink("S")'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a></td>
				<td id="AssociateTab" class="normal" width="15%" height="20" ><a href='javascript:dispLink("A")' ><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></a></td>
			</tr>
		</table>
	</td>
</tr> 
<!-- IN050655 starts -->
<tr id="tbsrch_row" name="tbsrch_row">
<td id="searchcriteriaTab" name="searchcriteriaTab" colspan='2'>
<jsp:include page="IndexTickSearchCriteria.jsp" flush="true"/>
</td>
</tr>
<!-- IN050655 ends-->
<tr>
	<td colspan='2' align='left' id='linkId'>
		<jsp:include page="OrCommonAlphaLink.jsp" flush="true"/>
	</td>
</tr>
<input type="hidden" name="source_type" id="source_type" value=""><input type="hidden" name="facility_id" id="facility_id" value="">
<%}%>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="index_type" id="index_type" value="<%=index_type%>">
<input type="hidden" name="tabVal" id="tabVal" value="">
<input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
<input type="hidden" name="tick_sheet_id" id="tick_sheet_id" value="<%=tick_sheet_id%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>


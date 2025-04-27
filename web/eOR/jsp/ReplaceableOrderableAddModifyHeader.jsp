<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- ReplaceableOrderableAddModifyHeader.jsp -->

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

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
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eOR/js/ReplaceableOrderable.js"></script>

	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	 function lockKey()
	  {
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	  }
	</script>
</head>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" onload="FocusFirstElement()">

<%
	try{
	/* Mandatory checks start */
	
	String mode	   = request.getParameter("mode") ;
	String bean_id = "Or_Replaceable_Orderable" ;
	String bean_name = "eOR.ReplaceableOrderableBean";
	/* Mandatory checks end */
	ReplaceableOrderableBean bean = (ReplaceableOrderableBean)getBeanObject( bean_id,  bean_name, request ) ;
	
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ; 
	String catalog_desc=request.getParameter("catalog_desc");
	String order_catalog_code=request.getParameter("order_catalog_code");

	if (catalog_desc==null) catalog_desc="";
	if (order_catalog_code==null) order_catalog_code="";
//	out.println("order_catalog_code"+order_catalog_code);
	/* Initialize Function specific end */
%>

	<form name="ReplaceableOrderableHeader" id="ReplaceableOrderableHeader" method="post" >
	
	<table border="0" id="headerTab" cellpadding=3 cellspacing=0 width="100%" height='100%' align="center">
   	<tr>
	<td colspan="3"></td>
	</tr>
	
	<tr>
	<td class='label'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	<input type='hidden'  name='order_catalog_code' id='order_catalog_code' value='<%=order_catalog_code%>'>
	<input type='text'  name='catalog_desc' id='catalog_desc' value="<%=catalog_desc%>"  size=40 maxlength=40 onBlur='javascript:before_show_order_catalog_window(this,order_catalog_code);'><input type='button' name='search' id='search' class='button'   value='?' onClick='javascript:show_order_catalog_window(catalog_desc,order_catalog_code);'>
	<img src="../../eCommon/images/mandatory.gif" align=center>
	<input type="hidden" name="order_catalog_sql" id="order_catalog_sql" 	
	value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REPLACEABLE_ORDERABLE_CATALOG_SELECT")%>">

	<input type="hidden" name="temp_catalog_desc" id="temp_catalog_desc" value="">
	</td>
	</tr>

	<tr>
	<td colspan="3"></td>
	</tr>

	</table>

	   
	<input type="hidden" name="function_id" id="function_id" value="Replaceable_Orderable">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
 <%
		// putObjectInBean(bean_id,bean,request);

 
	}

	catch(Exception e){
	e.printStackTrace();
	System.err.print("exception in ReplaceableOrderableAddModifyHeader.jsp="+e);
	}
 %>

</form>
</body>
</html>





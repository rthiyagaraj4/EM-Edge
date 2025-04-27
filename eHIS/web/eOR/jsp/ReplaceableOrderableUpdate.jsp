<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ page import="eOR.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>

	<script language="javascript" src="../../eOR/js/ReplaceableOrderable.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 </head>
 <body onload='FocusFirstElement()' onMouseDown="CodeArrest()">
 <%
	
	/* Mandatory checks start */
	String mode	   = request.getParameter("mode") ;
	//String function_id = request.getParameter("function_id") ;
	String bean_id = "Or_Replaceable_Orderable" ;
	String bean_name = "eOR.ReplaceableOrderableBean";
	ReplaceableOrderableBean bean = (ReplaceableOrderableBean)getBeanObject( bean_id,  bean_name , request) ; 
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;   

	/* Initialize Function specific start */
   
    String order_catalog_code = "";
	String catalog_desc="";
	String order_catalog_code_repl = "";
	String order_catalog_code_repl_desc = "";



	order_catalog_code = request.getParameter("order_catalog_code").trim();
	order_catalog_code_repl = request.getParameter("order_catalog_code_repl").trim();
	catalog_desc= request.getParameter("catalog_desc").trim();
	order_catalog_code_repl_desc = request.getParameter("order_catalog_code_repl_desc").trim();


%>
<form name="ReplaceableOrderableUpdate" id="ReplaceableOrderableUpdate" target='messageFrame'  method="post">
	
	   <table cellpadding=3 cellspacing=0 width="100%" align="center">

		<tr>
			<td class="label" ></td>
			<td class="label"><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
			<td>
				<input type="text" name="catalog_desc" id="catalog_desc" readOnly value="<%=catalog_desc%>"  size="40" maxLength="30">
				<input type="hidden" name="order_catalog_code" id="order_catalog_code" value="<%=order_catalog_code%>">  

		    </td>
			<td class="label" colspan='2'></td>
		</tr>
        <tr><td colspan="5"></td></tr>
		<tr>
			<td class="label" ></td>
			<td class="label"><fmt:message key="eOR.ReplaceableOrderCatalog.label" bundle="${or_labels}"/></td>
			<td>
				<input type="text" name="order_catalog_code_repl_desc" id="order_catalog_code_repl_desc" readOnly    value="<%=order_catalog_code_repl_desc%>" size="40" maxLength="30"  onBlur="makeValidString( this );" >
		  <input type="hidden" name="order_catalog_code_repl" id="order_catalog_code_repl" value="<%=order_catalog_code_repl%>">

			</td>
			<td class="label" colspan='2'></td>

		</tr>
	   <tr><td colspan="5"></td></tr>
		
	  </table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_id" id="function_id" value="Replaceable_Orderable">
</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>


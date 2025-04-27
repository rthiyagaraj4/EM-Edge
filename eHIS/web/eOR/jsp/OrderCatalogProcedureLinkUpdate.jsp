<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

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
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>

	<script language="javascript" src="../../eOR/js/OrderCatalogProcedureLink.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



 </head>
 <body onload='FocusFirstElement()' onMouseDown="CodeArrest()">
 <%


	/* Mandatory checks start */
	
	String mode	   = request.getParameter("mode") ;
	String bean_id = "Or_Order_Catalog_Procedure_Link" ;
	String bean_name = "eOR.OrderCatalogProcedureLink";
	//out.println("mode="+mode+"asdfAS");
	OrderCatalogProcedureLink bean = (OrderCatalogProcedureLink)getBeanObject( bean_id,  bean_name , request) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setLanguageId(localeName);
	bean.setMode( mode ) ;   
	ArrayList term_set_beanVal=new ArrayList();
	/* Initialize Function specific start */

	String order_catalog_code="";
	String term_set_code = "";
	String order_catalog = "";
	String term_set_desc = "";
	String default_yn="N";
	String term_set="";


	order_catalog_code= request.getParameter("order_catalog_code").trim();
	term_set_code = request.getParameter("term_set_code").trim();

	String[] loadData=(String[])bean.loadData(term_set_code,order_catalog_code);
		
	order_catalog=(String)loadData[0];
	term_set_desc=(String)loadData[1];
	term_set=(String)loadData[2];
	default_yn=(String)loadData[3];
			
	loadData=null;

%>

<form name="OrderCatalogProcedureLinkUpdate" id="OrderCatalogProcedureLinkUpdate" target='messageFrame'  method="post">
	
	   <table cellpadding=3 cellspacing=0 width="100%" align="center">

		


		<tr>
			<td  class="label"><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
			<td class="fields" >
		    <input type="text" name="order_catalog" id="order_catalog"  value='<%=order_catalog%>' readOnly size="40" maxLength="40" >
			<input type="hidden" name="order_catalog_code" id="order_catalog_code" value="<%=order_catalog_code%>">

		   </td>

		</tr>

		


		<tr>
			<td  class="label"><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
			<td class="fields">
			<select name="term_set" id="term_set" readOnly disabled>
			<%
				term_set_beanVal=bean.populateTermSet();
				String[] record=null;
				for(int i=0;i<term_set_beanVal.size(); i++){
					record = (String [])term_set_beanVal.get(i);		
						if(record[0].equals(term_set))
					{%>	
						<option value="<%=record[0]%>" selected ><%=record[1]%></option>  
					<%}
						}term_set_beanVal=null;
					%>
			</select>			</td>
		</tr>
		


		<tr>
			<td class="label"><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
			<td class="fields" >
			<input type="text" name="term_set_desc" id="term_set_desc"    value="<%=term_set_desc%>"
				size="60" maxLength="60" readOnly >
				<input type="hidden" name="term_set_code" id="term_set_code" value="<%=term_set_code%>">
			</td>
		</tr>

		

		<tr>
			<td  class="label"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
			<td class="fields" >
				<input type="checkbox" name="default_yn" id="default_yn" value="<%=default_yn%>"  <%=eHISFormatter.ChkBoxChecked("y", default_yn)%> onClick="defaultYnValue(this);">
			</td>
		</tr>

		


	  </table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_id" id="function_id" value="Order_Catalog_Procedure_Link">
</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>


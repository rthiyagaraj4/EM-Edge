<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
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
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>

	<script language="javascript" src="../../eOR/js/OrderCatalogProcedureLink.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
//out.println(request.getParament("mode"));
//out.println(request.getParament("order_category"));
   
	int totalRecords=0;
	totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	String mode	   = request.getParameter("mode") ;
	String bean_id = "Or_Order_Catalog_Procedure_Link" ;
	String bean_name = "eOR.OrderCatalogProcedureLink";
	/* Mandatory checks end */
	
	/*	Initialize Function specific start */
	
	OrderCatalogProcedureLink bean = (OrderCatalogProcedureLink)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setLanguageId(localeName);
	bean.setMode( mode ) ; 
	ArrayList TermSet=new ArrayList();

%>
<form name='OrderCatalogProcedureLinkDetail' id='OrderCatalogProcedureLinkDetail' target='messageFrame' >
<p>
<table class='grid' width='100%'>

<tr>
<td class='COLUMNHEADER'><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER'><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER'><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
</tr>

<%

int i = 0;

//out.println("mode="+mode);
while(i < totalRecords){

	String  classValue = "";

	if ( i % 2 == 0 )
		  	classValue = "gridData" ;
		  else
		  	classValue = "gridData" ;
/*
String proc_coding_scheme						= "";
String proc_coding_scheme_desc					= "";
ArrayList proc_code_scheme = bean.getProc_code_scheme();
for (int j = 0; j < proc_code_scheme.size();j++) {
                	String [] record = (String [])proc_code_scheme.get(j);
                	proc_coding_scheme							= record[0];
                	proc_coding_scheme_desc						= record[1];
 }*/
		
				  
%>
	
<tr>
	<td class='<%=classValue%>'>
	<select name="term_set<%=i%>" id="term_set<%=i%>" onChange="javascript:populateTermSet(this,'<%=i%>');" >
	<option value="">--- <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")%>---</option>
	<%
	
	TermSet=bean.populateTermSet();
	String[] record=null;
	for(int k=0;k<TermSet.size(); k++){
		record = (String [])TermSet.get(k);
		

%>	
		<option value="<%=record[0]%>" ><%=record[1]%></option>  
<%//System.out.println("####desc="+record[1]+",code="+record[0]);
	}TermSet=null;
%>
	</select><%if(i==0){%><img src="../../eCommon/images/mandatory.gif"></img><%}%>

		</td>

	<td  class='<%=classValue%>'>
	<input type='hidden' name="term_set_code<%=i%>" id="term_set_code<%=i%>" value="">
	<input type=text  name="term_set_desc<%=i%>" id="term_set_desc<%=i%>" value="" onChange="javascript:show_term_set_desc_window(this,term_set_code<%=i%>,'<%=i%>');resetColorCode(this)" size=30 maxlength=30 ><Input name="term_set_button<%=i%>" id="term_set_button<%=i%>"  class='button' type='button' value='?' onClick="javascript:show_term_set_desc_window(term_set_desc<%=i%>,term_set_code<%=i%>,'<%=i%>');">
	<%if(i==0){%><img src="../../eCommon/images/mandatory.gif"></img><%}%>
	
	</td>	
	<td  class='<%=classValue%>'>
	<input type="checkbox" name="default_yn<%=i%>" id="default_yn<%=i%>" value="" onClick="defaultYnValue(this);"   ></td>
	
</tr>
<%
	i++;
}
%>
<table>
<input type='hidden' name="term_set_desc_sql" id="term_set_desc_sql" value="<%=OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_PROC_LINK_TERM_SET_LOOKUP")%>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="function_id" id="function_id" value="Order_Catalog_Procedure_Link">
<input type="hidden" name="mode" id="mode" value='<%=mode%>'>
<INPUT TYPE="hidden" name="totalRecords" id="totalRecords" value="<%=totalRecords%>">
<input type="hidden" name="order_catalog_code" id="order_catalog_code" value="">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">

</form>
</body>
</html>


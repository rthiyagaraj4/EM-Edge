<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- ReplaceableOrderableAddModifyDetail.jsp -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
 
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

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
<%-- Mandatory declarations end --%>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>

	<script language="javascript" src="../../eOR/js/ReplaceableOrderable.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
//out.println(request.getParameter("mode"));
//out.println(request.getParameter("order_category"));
	
	/* Mandatory checks start */
	
	String mode	   = request.getParameter("mode") ;
	String bean_id = "Or_Replaceable_Orderable";
	String bean_name = "eOR.ReplaceableOrderableBean";
	int totalRecords=0;
	totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	ReplaceableOrderableBean bean = (ReplaceableOrderableBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ; 
//	String order_catalog_code_repl=request.getParameter("order_catalog_code_repl");
	/*  Initialize Function specific end */

%>

<form name='ReplaceableOrderableDetail' id='ReplaceableOrderableDetail' target='messageFrame' style="padding-left:5px;" >
<p>


<table class='grid' width='100%'>

<tr>
<th class=columnheadercenter width='15%' align="left"><fmt:message key="eOR.ReplaceableOrderCatalog.label" bundle="${or_labels}"/></td>

</tr>

<%

int i = 0;

// out.println("mode="+mode);
while(i < totalRecords){

	String  classValue = "";

	if ( i % 2 == 0 )
		  	classValue = "gridData" ;
		  else
		  	classValue = "gridData" ;
				  
%>
	<tr>
<td class='<%=classValue%>' style="padding-left:8px;">
	<input type='hidden' name="order_catalog_code_repl<%=i%>" id="order_catalog_code_repl<%=i%>" value="">

	<input type=text name="order_catalog_code_repl_desc<%=i%>" id="order_catalog_code_repl_desc<%=i%>" value=""    size=30 maxlength=30 onblur='before_show_order_catalog_repl_window(this,order_catalog_code_repl<%=i%>,<%=i%>)'><Input name="button<%=i%>" id="button<%=i%>" class='button' type='button' value='?' size=1 onClick="javascript:show_order_catalog_repl_window(order_catalog_code_repl_desc<%=i%>,order_catalog_code_repl<%=i%>,<%=i%>);">

	<%if(i==0){%><img src="../../eCommon/images/mandatory.gif" align=center></img><%}%>
</td>	
	

</tr>
<%
	i++;
}
%>
</table>
<input type='hidden' name="order_catalog_repl_sql" id="order_catalog_repl_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REPLACEABLE_ORDERABLE_OTHER_CATALOG_SELECT")%>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="function_id" id="function_id" value="Replaceable_Orderable">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<INPUT TYPE="hidden" name="totalRecords" id="totalRecords" value="<%=totalRecords%>">
<input type="hidden" name="order_catalog_code" id="order_catalog_code" value="">
<input type="hidden" name="temp_order_catalog_code_repl_desc" id="temp_order_catalog_code_repl_desc" value="">

</form>
</body>
</html>

<%
	putObjectInBean(bean_id,bean,request);
%>


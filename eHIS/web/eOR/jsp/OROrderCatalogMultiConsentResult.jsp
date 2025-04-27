<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
-----------------------------------------------------------------------
Date       Edit History      Name        		Description
-----------------------------------------------------------------------
?             100            ?           		created
22/07/2013    IN041421      Chowminya G     special characters - record consent "Internal Server Error" is displayed
-----------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="eOR.* ,java.util.ArrayList,eOR.Common.*,java.net.URLEncoder " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
 	<script language="JavaScript" src="../js/OROrderCatalogMultiConsent.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%

	/* Mandatory checks start */
	//String mode	   = request.getParameter( "mode" ) ;
	String bean_id = "Or_OrderCatalogMultiConsent" ;
	String bean_name = "eOR.OrderCatalogMultiConsent";

/* Mandatory checks end */
	
	// Initialize Function specific start 
	OrderCatalogMultiConsent bean = (OrderCatalogMultiConsent)getBeanObject( bean_id,bean_name,request ) ;  
	bean.clear() ;
	ArrayList cataloguesData = new ArrayList();
	//cataloguesData = (ArrayList) session.getAttribute("CATALOGUES_DATA");
	cataloguesData = bean.getCatalogues_data();
	
	if(cataloguesData==null) cataloguesData = new ArrayList();

	String categoryDesc = "";
	String orderTypeDesc = "";
	String catalogDesc = "";
	String definitionExists = "";
	String catalogCode = "";
	String[] orMultiConsent = null;
	for(int i=0;i<cataloguesData.size();i++)
	{
		orMultiConsent = (String[]) cataloguesData.get(i);
		categoryDesc = orMultiConsent[0];
		orderTypeDesc =  orMultiConsent[1];
		break;
	}
%>
<form name='Order_Catalog_MultiConsent_Result' id='Order_Catalog_MultiConsent_Result'>
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<INPUT TYPE="hidden" name="category_desc" id="category_desc" value="<%=categoryDesc%>">
<INPUT TYPE="hidden" name="order_type_desc" id="order_type_desc" value="<%=orderTypeDesc%>">
<table class='grid' width="100%">
	<%for(int i=0;i<cataloguesData.size();i++)
	{
		orMultiConsent = (String[]) cataloguesData.get(i);
		catalogDesc = orMultiConsent[2];
		definitionExists = orMultiConsent[4];
		catalogCode = orMultiConsent[3];
		String  classValue = "";
		if ( i % 2 == 0 )
		{
			classValue = "gridData" ;
		}
		else
		{
			classValue = "gridData" ;
		}
	%>
		<tr>
			<td class='<%=classValue%>' width="50%"><a class='gridLink' href="#" onClick="loadAddEditDetails('<%=URLEncoder.encode(catalogDesc,"UTF-8")%>','<%=catalogCode%>','<%=categoryDesc%>','<%=orderTypeDesc%>');"> <%=catalogDesc%><a></td> <!--IN041421 -->
			<input type=hidden name="catalogCode" id="catalogCode" value="<%=catalogCode%>">
			<%
			if(!definitionExists.equals("")&& definitionExists.equalsIgnoreCase("Y"))
			{
			%>
			<td class='<%=classValue%>'><img src="../../eCommon/images/enabled.gif"></td>
			<%
			}
			else if(!definitionExists.equals("")&& definitionExists.equalsIgnoreCase("N"))
			{
			%>
			<td class='<%=classValue%>'><img src="../../eCommon/images/disabled.gif"></td>
			<%
			}
			%>
		</tr>
	<%
	}
	cataloguesData=null;
	%>
</table>
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>


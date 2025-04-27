<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, java.io.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>

 
<head><title><fmt:message key="eOR.PrimaryOrder Type.label" bundle="${or_labels}"/></title></head>
<%
	 			 request.setCharacterEncoding("UTF-8");
				 beanQueryObj.setLanguageId(localeName);

	String order_type					= beanQueryObj.checkForNull(request.getParameter("order_type"),""); 
	StringTokenizer st_order_type		= null;
	Properties properties				= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
	StringBuffer sb_combined_order_type	= new StringBuffer();
	String		combined_order_type		= "";	
		if(!order_type.equals("")) {
		st_order_type				= new StringTokenizer(order_type,"||");
		while(st_order_type.hasMoreTokens()){
			sb_combined_order_type.append( "'"+beanQueryObj.checkForNull(st_order_type.nextToken(),"")+"',") ;
 		}
 		combined_order_type =  sb_combined_order_type.toString(); 
		if(combined_order_type.length() > 0)
		{	//Remove the last comma
			combined_order_type	= combined_order_type.substring(0, combined_order_type.length()-1);
		}
	} // End of !order_type
%>		  
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<form name="primaryOrderTypeForm" id="primaryOrderTypeForm" >
	<table width="105%" border="0" cellspacing="0" cellpadding="3" align="center">
	

	
	<tr><td class="Label" colspan="2"></td></tr>
	<tr>
		<td class="Label" align="right"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></font></td>
		<td class="Label">
			<select name="order_type_code" id="order_type_code">
<%
				out.println(beanQueryObj.getPrimaryOrderType(properties, combined_order_type));
%>
			</select>
 		</td>
	</tr>
	
	

	</table>
	<table width="105%" border="0" cellspacing="0" cellpadding="3" align="center">
	<tr><td class="Label" colspan="3">&nbsp;</td></tr>
	<tr><td class="Label" colspan="3">&nbsp;</td></tr>
	<tr><td class="button"  colspan="3"  align="right"><input type="button" class="button" name="ok" id="ok" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onclick="closePrimary();"><input type="button" class="button" name="close" id="close" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="window.close()"></td>
	<tr><td class="Label" colspan="2"></td></tr>

	</table>
<%
	// Nullifying the Objects
 	st_order_type					= null;
	sb_combined_order_type.setLength(0);
	 
%>
	</form>
</body>
 


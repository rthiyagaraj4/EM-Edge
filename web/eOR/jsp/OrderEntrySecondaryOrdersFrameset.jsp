<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
 <jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>
<%
 
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to 	the bean to get the connection if using the query bean and not the functional bean 
	String start_date_time          = request.getParameter("start_date_time");
	String pri_order_catalog_code   = request.getParameter("pri_order_catalog_code");
	String priority                 = request.getParameter("priority");
	String patient_class            = request.getParameter("patient_class");
	String called_from            = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String order_id            = request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String sec_order_catalog_type   = "";
	 if(!called_from.equalsIgnoreCase("existing_order"))
	{
		String[] secondaryOrders = beanQueryObj.getSecondaryOrdersYN(properties,pri_order_catalog_code, patient_class); //Pass the catalog_code and patient_class
	
		if (secondaryOrders != null && secondaryOrders.length > 0)
			sec_order_catalog_type = secondaryOrders[1];
		else 
			sec_order_catalog_type = "O";	
	}

	String record[]					= null; 
	beanQueryObj.setLanguageId(localeName);
	
	start_date_time			=  beanQueryObj.checkForNull(start_date_time,"");
	pri_order_catalog_code	=  beanQueryObj.checkForNull(pri_order_catalog_code,"");
	priority				=  beanQueryObj.checkForNull(priority,"");
	patient_class			=  beanQueryObj.checkForNull(patient_class,"");
	called_from			=  beanQueryObj.checkForNull(called_from,"");
	order_id			=  beanQueryObj.checkForNull(order_id,"");

	sec_order_catalog_type	=  beanQueryObj.checkForNull(sec_order_catalog_type,"O");
	ArrayList SecondaryOrderDetails = new ArrayList();
	if(called_from.equalsIgnoreCase("existing_order"))
	{
		SecondaryOrderDetails = (ArrayList)beanQueryObj.getExistingSecondaryOrders(properties,order_id);
	}
	else
	{
		SecondaryOrderDetails = (ArrayList)beanQueryObj.getSecondaryOrders(properties, start_date_time, pri_order_catalog_code, priority, patient_class, sec_order_catalog_type);
	}
%>
<%
if(called_from.equalsIgnoreCase("existing_order"))
{
	for(int i=0;i < SecondaryOrderDetails.size();i++) 
	{
		record	= (String[])SecondaryOrderDetails.get(i);
		if(record[3]==null)record[3]="";
		if(record[3].equalsIgnoreCase("O"))
		{
			sec_order_catalog_type="O";
		}
		else if(record[3].equalsIgnoreCase("I"))
		{
			sec_order_catalog_type="I";
		}
	}
}
%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrderEntrySearch.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<title><fmt:message key="Common.secondary.label" bundle="${common_labels}"/>&nbsp;<% if(sec_order_catalog_type.equals("O")) out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Orders.label","common_labels")); else   out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intervention.label","common_labels"));%></title>
</head>
	<iframe name='OrderEntrySecondaryOrdersHeader' id='OrderEntrySecondaryOrdersHeader' src='OrderEntrySecondaryOrdersHeader.jsp?<%=request.getQueryString()%>&sec_catalog_type=<%=sec_order_catalog_type%>' frameborder='0' scrolling='auto' noresize  style='height:8vh;width:100vw'></iframe>
	<iframe name='OrderEntrySecondaryOrdersDetail' id='OrderEntrySecondaryOrdersDetail' src='OrderEntrySecondaryOrders.jsp?<%=request.getQueryString()%>' frameborder='0' scrolling='auto' noresize style='height:77vh;width:100vw' ></iframe>
			<iframe name='OrderEntrySecondaryOrdersButton' id='OrderEntrySecondaryOrdersButton' src='OrderEntrySecondaryOrdersButton.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='auto' noresize style='height:5vh;width:100vw'></iframe>

</html>


<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
 <jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>
<%
    request.setCharacterEncoding("UTF-8");
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to 	the bean to get the connection if using the query bean and not the functional bean 
	String start_date_time          = request.getParameter("start_date_time");
	String pri_order_catalog_code   = request.getParameter("pri_order_catalog_code");
	String priority                 = request.getParameter("priority");
	String patient_class            = request.getParameter("patient_class");
	String called_from            = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String order_id            = request.getParameter("order_id")==null?"":request.getParameter("order_id");
	
	// Added by  Sridhar Reddy V On 18/11/2008

	//String sec_order_catalog_type   = request.getParameter("sec_order_catalog_type");
	String sec_order_catalog_type   = "";
	 if(!called_from.equalsIgnoreCase("existing_order"))
	{
		String[] secondaryOrders = beanQueryObj.getSecondaryOrdersYN(properties,pri_order_catalog_code, patient_class); //Pass the catalog_code and patient_class
	
		if (secondaryOrders != null && secondaryOrders.length > 0)
			sec_order_catalog_type = secondaryOrders[1];
		else 
			sec_order_catalog_type = "O";	
	}
	
		
	//String bean_id				= request.getParameter("bean_id");
	//String bean_name				= request.getParameter("bean_name");
	String slClassValue				= "";
	String record[]					= null; 
	beanQueryObj.setLanguageId(localeName);
	//if(bean_id == null || bean_id.equals("null"))	bean_id = "";
	//if(bean_name == null || bean_name.equals("null"))	bean_name = "";
	start_date_time			=  beanQueryObj.checkForNull(start_date_time,"");
	pri_order_catalog_code	=  beanQueryObj.checkForNull(pri_order_catalog_code,"");
	priority				=  beanQueryObj.checkForNull(priority,"");
	patient_class			=  beanQueryObj.checkForNull(patient_class,"");
	called_from			=  beanQueryObj.checkForNull(called_from,"");
	order_id			=  beanQueryObj.checkForNull(order_id,"");
//	sec_order_catalog_type	=  beanQueryObj.checkForNull(sec_order_catalog_type,"O");
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
	</link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrderEntrySearch.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()" onscroll='moveFrame()'>
<FORM METHOD=POST ACTION="">
	<table cellpadding=3 cellspacing=0 border=1 width="100%" id="tableresult" class="grid">
	<%
		for(int i=0;i < SecondaryOrderDetails.size();i++) {

			 record	= (String[])SecondaryOrderDetails.get(i);
			/*if(i % 2 == 0){
				slClassValue = "QRYEVEN";
			}else{
				slClassValue = "QRYODD";
			}*/
			slClassValue="gridData";
	%>
	<%	//if ((beanQueryObj.checkForNull(record[2],"")).equals("Order")) {
		if(record[2]==null)record[2]="";
		if(record[1]==null)record[1]="";
		String label		= "";
				
		if(record[2].equals("O"))
		{
			label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Order.label","common_labels");
		}
		else if(record[2].equals("A"))
		{
			label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Appointment.label","common_labels");
			
		}
		else
		{
			label=record[2];
		}
	%>
	<tr><td class='<%=slClassValue%>'  nowrap><font size='1'><%=com.ehis.util.DateUtils.convertDate(record[0],"DMYHM","en",localeName)%></font></td>
	<td class='<%=slClassValue%>' nowrap> <font size='1'><%=record[1]%></font></td>
	<td class='<%=slClassValue%>' nowrap><font size='1'><%=label%></font></td>
	</tr>
	<%//}
	%>
<%		record = null;	// Nullifying the objects
	  }%>
<tr style='visibility:hidden'>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
	<%
	if(sec_order_catalog_type.equals("O"))
	{
	%>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
	<%
	}
	else
	{%>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.Intervention.label" bundle="${common_labels}"/></td>
	<%
	}
	%>
	<td class='columnheader' width='' nowrap><fmt:message key="eOR.OrderStage.label" bundle="${or_labels}"/></td>
	</tr>
	</table>
<%
		//Nullifying the Objects
		if(SecondaryOrderDetails!=null) {
			SecondaryOrderDetails.clear();
			SecondaryOrderDetails	= null;
		}
%>
<script>
if(parent.OrderEntrySecondaryOrdersHeader.document.getElementById("tableheader")==null)
{
	setTimeout("alignHeading();",300);
}
else 
	alignHeading();
</script>
</FORM>
</BODY>
</HTML>


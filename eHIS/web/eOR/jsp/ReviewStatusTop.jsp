<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="bean" scope="page" class="eOR.ExistingOrder"/>
<jsp:useBean id="bean1" scope="page" class="eOR.ReviewStatusBean"/>
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
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
 	<script language="JavaScript" src="../js/ReviewStatus.js"></script>
	<script language="JavaScript" src="../js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onload="onBodyLoad()" OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	
	/* Mandatory checks start */
	String mode	   = "2";//request.getParameter( "mode" ) ;
	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ExistingOrder" ;
	//String bean_name = "eOR.ExistingOrder";
	String bean_id1 = "Or_ReviewStatusBean" ;
	String bean_name1 = "eOR.ReviewStatusBean";
	bean.setLanguageId(localeName);
	Properties properties			= (Properties) session.getValue( "jdbc" );
	//String facility_id = (String)session.getAttribute("facility_id")==null?"":(String)session.getAttribute("facility_id");
	String location="";
	String patient_details="";
	
	String orderId = request.getParameter("orderId");
	String task_type=request.getParameter("task_type");
	
	String[] allValues = new String[39];
/* Mandatory checks end */

	/* Initialize Function specific start */
	//ReviewStatusBean bean = (ReviewStatusBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	/*ReviewStatusBean bean = (ReviewStatusBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;*/

	//ViewOrder view_bean = (ViewOrder)mh.getBeanObject( view_bean_id, request,  view_bean_name ) ;
	//ViewOrder view_bean = (ViewOrder)getBeanObject( view_bean_id,view_bean_name,request) ;
	// From the View Order get the clinical comments if it is there

	bean1.setLanguageId(localeName);
	bean1.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean1.clear() ;
	bean1.setMode( mode ) ;

	String max_action_seq_num	= "";
  
 	String ca_pract_name		= "";

	//System.out.println("orderId="+orderId);
	allValues		= bean.viewMainDetails(properties, orderId);
	if(allValues[2] == null  || allValues[2].equals("null") || allValues[2].equals("") )
	{
		allValues[2]="R";
	}
	
		 
	  if(allValues[2].compareTo("R")==0){
					allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
										
				}
					else if(allValues[2].compareTo("U")==0)
				{
					
					allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
									

				}
					else if(allValues[2].compareTo("S")==0)
				{
				
				allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
					
				}	

	String sex1="";
				
				if (allValues[3].equalsIgnoreCase("M"))
				  sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			  else if(allValues[3].equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

			if(allValues[36].equalsIgnoreCase("C"))
	{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}
	else if(allValues[36].equalsIgnoreCase("N"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	}else if(allValues[36].equalsIgnoreCase("R"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
	}

		max_action_seq_num	= allValues[29];
		patient_details=allValues[6]+","+sex1+"/"+allValues[34]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+allValues[35];

	//out.println("allValues="+allValues);
//	out.println("orderId="+orderId);
	ArrayList OrderStatus = new ArrayList();
	if(task_type.trim().equalsIgnoreCase("UpdateOrder"))
		OrderStatus = bean.getOrderStatus(properties);

	if(allValues!=null && orderId!=null) {
		//ca_pract_name		= bean.checkForNull(view_bean.getOrderPractitioner(orderId),"");
		ca_pract_name		= allValues[30];
	}
	if(ca_pract_name==null)	ca_pract_name = "";

	//out.println(OrderStatus);
/* Initialize Function specific end */

%>
<form name='review_order_status' id='review_order_status'>
<table cellpadding=5 cellspacing=5 border=0 width="100%" height='100%' align=center>
	<tr>
		<td  class='label'><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=orderId%></B></td>
		<td  class='label'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=allValues[0]%></B></td>
	</tr>
	<tr>
		<td  class='label'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=allValues[1]%></B></td>
		<td  class='label'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=allValues[2]%></B></td>
	</tr>
	<tr>
		<td  class='label'><fmt:message key="Common.patient.label" bundle="${common_labels}"/></td>
		<td class='data' ><B><%=patient_details%></B></td>
		<td  class='label'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=allValues[4]%></B></td>
	</tr>
	<tr>
		<td  class='label' nowrap><fmt:message key="Common.OrderDateTime.label" bundle="${common_labels}"/></td>
		<td class='data' nowrap><B><%=com.ehis.util.DateUtils.convertDate(allValues[12],"DMYHM","en",localeName)%></B></td>
		<td  class='label'><fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/></td>
		<td class='data' colspan=3><B><%=allValues[5]%></B></td>
	</tr>
	<tr>
		<td  class='label'><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=location%>/<%=allValues[38]%></B></td>
		<td  class='label'><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=allValues[7]%></B></td>
	</tr>
	<tr>
		<td  class='label'><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=allValues[8]%></B></td>
		<td  class='label'><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=allValues[9]%></B></td>
	</tr>
	<%
	if(allValues[10] == null) allValues[10] = "";
	//if(allValues[10] != null){
	%>
	<tr>
		<td  class='label'><fmt:message key="eOR.OrderFormat.label" bundle="${or_labels}"/></td>
		<td class='data'  colspan=2>  <a class="gridLink"  href="javascript:viewOrderFormat('<%=orderId%>')"><%=allValues[10]%></a> </td>
		<td  class='data'> 
    	<% if(!max_action_seq_num.equals("") && !max_action_seq_num.equals("0")){ %>
			<a class="gridLink" href="javascript:viewHeaderComments('<%=orderId%>')"><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></a>  
		<%} else { %><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/><% } %>
 		</td>
			<input type=hidden name='task_type' id='task_type' value='<%=task_type%>'>
	</tr>
	<% if(ca_pract_name!=null && !ca_pract_name.equals("")) { %>
	<tr>
		<td  class='label'><fmt:message key="eOR.OrderPlacedBy.label" bundle="${or_labels}"/></td>
		<td class='data' ><b><%=ca_pract_name%></b> </td>
		<td class='label'  colspan=2></td>
	</tr>
	<% } %>
	<%if(task_type.trim().equalsIgnoreCase("UpdateOrder")){%>
	<tr>
		<td  class='label'><fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/></td>
		<td class='data'>
			<select name='order_status' id='order_status' onchange='javascript:onOrderStatusChange(this)'>
			<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<%
			try{
			if(OrderStatus!=null)
			{
				for( int i=0; i<OrderStatus.size(); i++)
				{	String[] record = new String[3];
					record = (String[])OrderStatus.get(i);
					if(record[2].trim().equalsIgnoreCase(record[1].trim()))
					{%>
					<option value='<%=record[1]%>' selected><%=record[0]%></option>
					<%}else{%>
					<option value='<%=record[1]%>'><%=record[0]%></option>
			<%}}}
			}catch(Exception e){}
			%>
			</select><font size=1><a class="gridLink" id='id_remarkLink' href=# onclick='javascript:viewOrderStatusRemark(document.review_order_status.orderRemark.value)'></a></font>
		</td>
		<td  class='fields'><input type=hidden name='order_id' id='order_id' value='<%=orderId%>'>
			<input type='hidden' name='orderRemark' id='orderRemark' value=''>
			<input type=hidden name='mode' id='mode' value='<%=mode%>'>	<!-- data required for bean -->
			<input type=hidden name='function_id' id='function_id' value='<%=function_id%>'>	<!-- data required for bean -->
			<input type=hidden name='bean_id' id='bean_id' value='<%=bean_id1%>'>		<!-- data required for bean -->
			<input type=hidden name='bean_name' id='bean_name' value='<%=bean_name1%>'>		<!-- data required for bean -->
		</td>
		<td class='label'></td>
	</tr>
	<%}%>
</table>
</form>
<%
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(bean_id1,bean1,request);
		//putObjectInBean(view_bean_id,view_bean,request);
%>
</body>
</html>


<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
-----------------------------------------------------------------------
Date       		Edit History      Name        		Description
-----------------------------------------------------------------------
?             	100            		?           		created
13/08/2013	    IN042045		Chowminya G	        System should not allow to copy for the drugs for which Verbal Order Applicable is not selected	
-----------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
 <jsp:useBean id="bean" scope="page" class="eOR.OrderEntryQueryBean"/>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="CommonBean" class="eCommon.Common.CommonBean" scope="page" />
<%-- Mandatory declarations end --%>


<html>
	<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	</link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="eOR.ToolTip.label" bundle="${or_labels}"/></title>
	</head>
	<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
		<form name="placeOrderForm" id="placeOrderForm">
<%		
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String bean_id 					= request.getParameter("bean_id");
		String bean_name 				= request.getParameter("bean_name");

		bean.setLanguageId(localeName);
		/* Initialize Function specific start */
		//OrderEntryBean bean 			= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		//OrderEntryBean	 bean			= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		/* Initialize Function specific end */

		Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
		String facility_id				= (String)session.getValue("facility_id");
		
		String measure_id 				= bean.checkForNull(request.getParameter("measure_id"), "");
		String catalog_code 				= bean.checkForNull(request.getParameter("catalog_code"), "");//added on 7/10/2007 to get catalog_code by uma 
		String order_catalog_nature		= bean.checkForNull(request.getParameter("order_catalog_nature"), "");
		String contr_msr_panel_id		= bean.checkForNull(request.getParameter("contr_msr_panel_id"), "");
		String category					= bean.checkForNull(request.getParameter("category"), "");	
		String encounter_id				= bean.checkForNull(request.getParameter("encounter_id"), "");	
		String patient_class			= bean.checkForNull(request.getParameter("patient_class"), "");	
		String admission_date			= bean.checkForNull(request.getParameter("admission_date"), "");	
		String discharge_date_time		= bean.checkForNull(request.getParameter("discharge_date_time"), "");	
		String pract_type		        = bean.checkForNull(request.getParameter("pract_type"), "");	//IN042045		
		//ArrayList Panels				= bean.getPanelItems(properties, measure_id,order_catalog_nature,contr_msr_panel_id,category, facility_id);// catalog_code,catalog_nature,contr_msr_panel_id,order_category
		//ArrayList Panels				= bean.getPanelItems(properties, measure_id,order_catalog_nature,contr_msr_panel_id,category, facility_id,encounter_id,patient_class,admission_date,discharge_date_time);changed on 7/10/2007 to pass catalog_code by uma //IN042045
		ArrayList Panels				= bean.getPanelItems(properties, measure_id,order_catalog_nature,contr_msr_panel_id,category, facility_id,encounter_id,patient_class,admission_date,discharge_date_time,catalog_code,pract_type);// IN042045 included pract_type
		String classValue				= "";
		if(Panels!=null && Panels.size() == 0){  
		%><script>
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
				window.close();
			</script>
<%		}
%>	
		<table width="100%" border="1" cellspacing="0" cellpadding="0" class="grid">
<%
			if(Panels!=null && Panels.size() != 0)
			{  
				for(int k=0; k<Panels.size(); k++)
		   		{
		   			/*if ( k % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;*/
					classValue="gridData";
		   			String[] record = (String[])Panels.get(k);
%>					<tr>
						<td class="<%=classValue%>" nowrap><%=bean.checkForNull( record[1],"")%></td>
					<tr>
<%				}
			}	
			if(Panels!=null) {
				Panels.clear();  Panels = null;
			}
			
		
%>
		</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">

		</form>
	</body>
</html>

<%
	// set it back persistence , no need to set it
	//putObjectInBean(bean_id,bean,request);
%>


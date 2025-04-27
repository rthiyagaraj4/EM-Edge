<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        		Description
----------------------------------------------------------------------------------------------------------------------------
?            	100            		?           		created
01/12/2013		IN038787		Ramesh G			Bru-HIMS-CRF-358
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
----------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntryRapidPreview.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntryCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="tickSheetForm" id="tickSheetForm">
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 				= request.getParameter("bean_id");
	String bean_name 			= request.getParameter("bean_name");
	String disableOrderCategory = "";
	String disableOrderType		= "";
	String order_category		= "";
	String ordertype = "";
	String ordertypedesc = "";
	String privApplicability = "";
  	/* Initialize Function specific start */
	//OrderEntryBean bean 		= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);

	OrderEntryBean bean			= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	/* Initialize Function specific end */
	//Properties properties		= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean
	String ammend_called_from	= bean.checkForNull(request.getParameter("ammend_called_from"),"");
	if(bean.getOrderCategoryYn().equalsIgnoreCase("Y"))
				order_category 	= bean.checkForNull(bean.getOrderCategoryValue(),"");

 	String function_from		= bean.checkForNull(request.getParameter("function_from"),"");
	ExternalOrdersBean external_bean_obj= null; // For EXTERNAL_ORDER
	String existing_bean_id		= "";
	String existing_bean_name	= "";
	String ext_order_category	= ""; String ext_order_type_code = "";
	String order_dispaly_verticalYN	=	(String)bean.getOrderDisplayVerticalYN();  //IN038787
	bean.setSiteSpecific("ORDER_CATALOG_FAC_WISE");//IN068370,IN068373
	if(function_from.equals("EXTERNAL_ORDER")) { // Get the Bean Instance of External Orders
		existing_bean_id 		= "Or_ExternalOrders";
		existing_bean_name		= "eOR.ExternalOrdersBean";
		//external_bean_obj		= (ExternalOrdersBean)mh.getBeanObject( existing_bean_id, request,  existing_bean_name ) ;
		external_bean_obj		= (ExternalOrdersBean)getBeanObject(existing_bean_id, existing_bean_name, request ) ;
		// Bean instance is needed, if it is coming from the external orders, to default the order_category and the order_type_code
		external_bean_obj.setLanguageId(localeName);

		ext_order_category		= bean.checkForNull(external_bean_obj.getOrderCategory(),"");
		ext_order_type_code		= bean.checkForNull(external_bean_obj.getOrderType(),"");
		order_category			= bean.checkForNull(ext_order_category,"");
	} 
	String licence_key			= eOR.OR_license_rights.getKey(); // Get the Licence Key from the Class
	String[] record				= null;
	ArrayList TickSheets		= null;
%>
		<table border='0' cellpadding='3' cellspacing='0' width='100%'>
		<tr>
		     <td width='10%'   class='label' nowrap><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			 <td width='20%' class='fields'>
		   	 <select name='order_category' id='order_category'  onChange="allowNewOrders(this,'tickSheetForm');"><option value=''>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----
<%				ArrayList OrderCategory = bean.getOrderCategory("TICK_SHEETS");
			    for(int i=0; i<OrderCategory.size(); i++)
			    {
					record = (String[])OrderCategory.get(i);
					if(record[1].equalsIgnoreCase("Non Specific"))
					{
						record[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NonSpecific.label","or_labels");
					}
					if(ammend_called_from.equalsIgnoreCase("existing_order") || (function_from.equals("EXTERNAL_ORDER") && ext_order_category.equals(record[0])) || (bean.getOrderCategoryYn().equalsIgnoreCase("Y") && !bean.getOrderCategoryValue().equalsIgnoreCase("")))
						disableOrderCategory = "DISABLED";
					else if(bean.getOrderCategoryYn().equals("N") && bean.getOrderTypeCodeYn().equals("N"))
						disableOrderCategory = "";
					if( (bean.getOrderCategoryValue().equalsIgnoreCase(record[0]) && (ammend_called_from.equalsIgnoreCase("existing_order") || bean.getOrderCategoryYn().equals("Y") )) || (function_from.equals("EXTERNAL_ORDER") && ext_order_category.equals(record[0])) || (licence_key.equals("ORPV")) )
						out.println("<option value = '"+record[0]+"' selected> "+record[1]+" </option>");
					else
						out.println("<option value = '"+record[0]+"'> "+record[1]+" </option>");
					
			    }
%>
			</select>
		<%
				if(bean.getOrderCategoryYn().equals("Y"))
					out.println("<img src=\"../../eCommon/images/mandatory.gif\"></img>");
		%>
			</td>
		<%
		if(ammend_called_from.equalsIgnoreCase("existing_order") || (function_from.equals("EXTERNAL_ORDER") && ext_order_type_code.equals(record[0])) || (bean.getOrderCategoryYn().equals("Y") && bean.getOrderTypeCodeYn().equals("Y") && !bean.getOrderTypeValue().equals("")))
					 	disableOrderType = "DISABLED";
		else if(bean.getOrderCategoryYn().equals("N") && bean.getOrderTypeCodeYn().equals("N"))
						disableOrderType = "";

		if( (!(bean.checkForNull(bean.getOrderTypeValue(),"").equals("") )&& (ammend_called_from.equalsIgnoreCase("existing_order") || bean.checkForNull(bean.getOrderCategoryYn(),"").equals("Y"))))
		{
			ordertype=bean.getOrderTypeValue();
			ordertypedesc=bean.getOrderTypeDesc(ordertype);
		}else if(function_from.equals("EXTERNAL_ORDER") && !(bean.checkForNull(ext_order_type_code,"").equals("")))
		{
			ordertype=ext_order_type_code;
			ordertypedesc=bean.getOrderTypeDesc(ordertype);
		}else if(!(bean.checkForNull(bean.getAmendOrderType(),"").equals("")))
		{
			ordertype=bean.getAmendOrderType();
			ordertypedesc=bean.getOrderTypeDesc(ordertype);
		}
			%>
			<td width="10%"  class="label" nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
			<td  width="20%" class="fields" nowrap>
			<input type='hidden' name='order_type' id='order_type' value="<%=ordertype%>"><input type='text' width='16%' name='order_type_desc' id='order_type_desc' value="<%=ordertypedesc%>" onBlur="populateordertypeSearch(order_type_desc,order_type,'tickSheetForm');clearactivityvalues('tickSheetForm');storeValues('','tickSheetItemsForm');" onChange="" maxlength='' <%=disableOrderType%>><input type=button name="ordertypesearch" id="ordertypesearch" value='?'  class=button tabIndex="4" onClick="callordertypeSearch(order_type_desc,order_type,'tickSheetForm');storeValues('','tickSheetItemsForm');">
		   	<!--  <select name="order_type" id="order_type" onChange="popSections(this);storeValues('','tickSheetItemsForm');populateActivityType(this, 'tickSheetForm')"><option value=''> -->
<%
				/*ArrayList OrderType = bean.getOrderType(order_category);
			    for(int i=0; i<OrderType.size(); i++)
			    {
					record = (String[])OrderType.get(i);
					if(ammend_called_from.equalsIgnoreCase("existing_order") || (function_from.equals("EXTERNAL_ORDER") && ext_order_type_code.equals(record[0])) || (bean.getOrderCategoryYn().equals("Y") && bean.getOrderTypeCodeYn().equals("Y") && !bean.getOrderTypeValue().equals("")))
					 	disableOrderType = "DISABLED";
					else if(bean.getOrderCategoryYn().equals("N") && bean.getOrderTypeCodeYn().equals("N"))
						disableOrderType = "";
					if( (bean.getOrderTypeValue().equals(record[0]) && (ammend_called_from.equalsIgnoreCase("existing_order") ||  bean.getOrderCategoryYn().equals("Y"))) || (function_from.equals("EXTERNAL_ORDER") && ext_order_type_code.equals(record[0]))  || bean.getAmendOrderType().equalsIgnoreCase(record[0]))
						out.println("<option value = \""+record[0]+"\" selected> "+record[1]+"");
					else
						out.println("<option value = \""+record[0]+"\"> "+record[1]+"");
					record = null;	// Nullifying the objects
			    }*/
%>
			</select>
			<img src="../../eCommon/images/mandatory.gif" id="order_type_mand" style="visibility:hidden"></img>
			</td>
			
		 </tr>
		 <tr>

		   <td width="10%" class="label" ><fmt:message key="eOR.ActivityType.label" bundle="${or_labels}"/></td>
			<td class="fields" width="20%" ><input type='hidden' name='activity_type' id='activity_type' value=""><input type='text' width='16%' name='activity_type_desc' id='activity_type_desc' value="" onBlur="populateActivitySearch(activity_type_desc,activity_type,'tickSheetForm');storeValues('','tickSheetItemsForm');"  maxlength='' ><input type=button name=search value='?'  class=button tabIndex="4" onClick="callActivitySearch(activity_type_desc,activity_type,'tickSheetForm');storeValues('','tickSheetItemsForm');">

			<!-- <select name="activity_type" id="activity_type" onChange="popSections(this);storeValues('','tickSheetItemsForm');"> -->
<%
				/*ArrayList ActivityType = beanQueryObj.getActivityType(properties, order_category, bean.getOrderTypeValue()); // first parameter OrderCategory is passed as '' to populate all and if category is set, and next parameter is the order_type_code it will be passed
				 for(int i=0; i<ActivityType.size(); i++)
				 {
					record = (String[])ActivityType.get(i);
					out.println("<option value = \""+record[0]+"\"> "+record[1]+"");
					record = null;		//nullifying the objects
				 }*/
%>			
			</select>
			</td>

		     <td width="10%"   class="label" nowrap><fmt:message key="eOR.TickSheet.label" bundle="${or_labels}"/></td>
			 <td  width="20%" class="fields">
		   	 <!-- IN038787 Start.-->
			 <!--<select name="tick_sheet_id" id="tick_sheet_id"  onChange="popTickSheetValues(this);storeValues('','tickSheetItemsForm')" onload="popTickSheetValues(this)"> -->
			 <select name="tick_sheet_id" id="tick_sheet_id"  onChange="popTickSheetValues(this);tickSheetOnChanges();" onload="popTickSheetValues(this)">
			 <!-- IN038787 End. -->
<%
				if(bean.getOrderCategoryYn().equals("N")) // If order category for presel_order_category_yn is "N"
				{
		   			TickSheets = bean.getTickSheet(order_category); // First time order_category will be null
					if(TickSheets.size()==0)
					{
					%>
						<option value=''>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<%
					}
			    	for(int i=0; i<TickSheets.size(); i++)
			    	{
						record = (String[])TickSheets.get(i);
						out.println("<option value = \""+record[0]+"\"> "+record[1]+"");
						//out.println("<script>alert('record[0]="+record[0]+"');</script>");
						//out.println("<script>alert('record[1]="+record[2]+"');</script>");
						record = null;		//nullifying the objects
			    	}
			    }
				else
				{
				%>
					<option value=''>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
<%				}
%>
			</select>
			
			</td>
			</tr>
			<tr>
			<%
			privApplicability = bean.getPrivilegeApplicability();
			if(privApplicability.equalsIgnoreCase("Y"))
			{
			%>
				<td class="label" colspan='2'></td>
				<td class="label" nowrap><fmt:message key="eOR.LimitToMyApplicableCatalogs.label" bundle="${or_labels}"/><input type="checkbox" name="ApplicableCatalogs" id="ApplicableCatalogs" checked value="Y" onclick="SetApplicability(this);"></td>
			<%
			}
			else
			{
			%>
				<td class="label" colspan='3'></td>
				<input type="hidden" name="ApplicableCatalogs" id="ApplicableCatalogs" value="">
			<%
			}
			%>
			<%	if (!function_from.equals("AMEND_ORDER") && !function_from.equals("MULTI_PATIENT_ORDERS")) { %>
			<td colspan="" class="button" style='text-align:right'>
			<input type="button" class="button" name="search" id="search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="popTickSheetValues(document.getElementById("tick_sheet_id"));" TITLE="Search"><input type="button" class="button" name="preview" id="preview" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Preview.label","common_labels")%>" onClick="rapidPreview()" TITLE="Preview">
			</td>
<%		} else {	%>	
			<td class="button" style='text-align:right'><input type="button" class="button" name="search" id="search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="popTickSheetValues(document.getElementById("tick_sheet_id"));" TITLE="Search"></td>	
<%		} %>
		  </tr>
		</table>
		<%if(!imgUrl.equals("")){ %>
		<img src='<%=imgUrl%>' width='100%' height='15'/> 
		<%}%>
			<input type="hidden" name="order_category_yn" id="order_category_yn" value="<%=bean.getOrderCategoryYn()%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="ammend_called_from" id="ammend_called_from" value="<%=ammend_called_from%>">
			<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>">
			<input type="hidden" name="order_type_yn" id="order_type_yn" value="<%=bean.getOrderTypeCodeYn()%>">
			<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
			<input type="hidden" name="activity_sql" id="activity_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT_LOOKUP")%>">
			<input type="hidden" name="order_type_sql" id="order_type_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_TYPE_LOOKUP")%>">
			<input type="hidden" name="order_dispaly_verticalYN" id="order_dispaly_verticalYN" value="<%=order_dispaly_verticalYN%>"> <!--  IN038787 -->
		 	<%
				if(disableOrderCategory.equalsIgnoreCase("DISABLED"))
					out.println("<script>disableOrderCategory('tickSheetForm')</script>");
				if(disableOrderType.equalsIgnoreCase("DISABLED"))
					out.println("<script>disableOrderType('tickSheetForm')</script>");
					out.println("<script>OrderTypedisable('tickSheetForm')</script>");
			%>
			<script>populateTickSheetId(document.tickSheetForm.order_category)</script>
			<%
			if(!bean.getOrderCategoryYn().equals("Y"))
			{
				%>
			<script>popTickSheetValues(document.getElementById("tick_sheet_id"));//added by Channaveer B on 02/07/2010
				//storeValues('','tickSheetItemsForm');   //Line commented for IN038787
			</script>
			<%}%>
<%	
			// Nullifying the objects
			record				= null;		
			if(OrderCategory	!= null) {
				OrderCategory.clear();	OrderCategory = null;
			}
			//if(OrderType	!= null) {
				//OrderType.clear();	OrderType = null;
		   //}
			//if(ActivityType	!= null) {
				//ActivityType.clear();	ActivityType = null;
			//}
			record = null;	// Nullifying the objects
			if(TickSheets	!= null) {
				TickSheets.clear();	TickSheets = null;
			}
%>
 		</form>
	</body>
</html>

<%
	// no need to set it back persistence( no set methods used)
	//putObjectInBean(bean_id,bean,request);
	//	if(function_from.equals("EXTERNAL_ORDER")) { // Get the Bean Instance of External Orders
	//	putObjectInBean(existing_bean_id,external_bean_obj,request);
	//}
%>


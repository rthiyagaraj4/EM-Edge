<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
----------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        		Description
----------------------------------------------------------------------------------------------------------------------------
?            	100            		?           		created
2/25/2013		IN038185		Dinesh T			Search for catalogs on pressing the enter key of the catalog search textbox
13/06/2013		IN038776		Ramesh G			This is a child cr for  MMS-QH-CRF- 0042 to cover the Billing related changes
25/10/2013		IN044542		Chowminya			Unable to place order �New for External Patient encounter type due to script debug error
01/12/2013		IN038787		Ramesh G			Bru-HIMS-CRF-358
20/12/2013		IN045694		Nijitha S           Alpha - CA>Select an Outpatient/AE patient>Chart Summary>Orders>Unable to place an Order in Place Order screen 
19/01/2015		IN003240 EMR	Ramesh G			CRF-BL-MMS_QH_CRF_0196/08-Day Care - Screening Policy
17/10/2018		IN066709		Prakash C	ML-MMOH-CRF-1101
----------------------------------------------------------------------------------------------------------------------------
 
-->
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>
<%
  	//String encounter_id			= request.getParameter("encounter_id");
	try
	{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085		

//out.println("<script>alert('additional"+request.getQueryString()+"');</script>");
	String ordertype="";
	String ordertypedesc="";
	String bean_id 				= request.getParameter("bean_id");
	String bean_name 			= request.getParameter("bean_name");


	beanQueryObj.setLanguageId(localeName);

	String disableOrderCategory	= "";
	String disableOrderType		= "";
	String privApplicability         = "";
	//Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
	/* Mandatory checks end */
	/* Initialize Function specific start */
		//OrderEntryBean bean 	= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		 OrderEntryBean	 bean = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		 bean.setLanguageId(localeName);

	/* Initialize Function specific end */
	String activity_type 		= bean.checkForNull(request.getParameter("activity_type_code"),"");
	String activity_type_desc 	= bean.checkForNull(request.getParameter("activity_type_desc"),"");
	String ammend_called_from	= bean.checkForNull(request.getParameter("ammend_called_from"),"");
	String pre_sel_order_type_yn= "";
	String function_from		= bean.checkForNull(request.getParameter("function_from"),"");
	String called_from		= bean.checkForNull(request.getParameter("called_from"),"");
	//String ohorder_category="";
//called_from="OH";
	/*if(called_from.equalsIgnoreCase("OH")){
		ohorder_category="OH";
	}*/
 	String order_category		= bean.checkForNull(bean.getOrderCategoryValue(),"");
    if(!order_category.equals("") &&  bean.checkForNull(bean.getOrderCategoryYn(),"N").equals("Y"))
	{  // Get the pre_sel_order_type_yn value
		pre_sel_order_type_yn 	= bean.getPreOrderType(order_category) ;
	}
	ExternalOrdersBean external_bean_obj= null; // For EXTERNAL_ORDER
	String existing_bean_id		= "";
	String existing_bean_name	= "";
	String ext_order_category	= ""; String ext_order_type_code = "";
	if(function_from.equals("EXTERNAL_ORDER")) { // Get the Bean Instance of External Orders
		existing_bean_id 		= "Or_ExternalOrders";
		existing_bean_name		= "eOR.ExternalOrdersBean";
		//external_bean_obj		= (ExternalOrdersBean)mh.getBeanObject( existing_bean_id, request,  existing_bean_name ) ;
		external_bean_obj		= (ExternalOrdersBean)getBeanObject( existing_bean_id, existing_bean_name, request ) ;

		external_bean_obj.setLanguageId(localeName);
		// Bean instance is needed, if it is coming from the external orders, to default the order_category and the order_type_code
		ext_order_category		= bean.checkForNull(external_bean_obj.getOrderCategory(),"");
		ext_order_type_code		= bean.checkForNull(external_bean_obj.getOrderType(),"");
		called_from		= bean.checkForNull(external_bean_obj.getCalledFrom(),"");
		
	} 
	if( bean.checkForNull(bean.getOrderCategoryYn(),"N").equalsIgnoreCase("Y"))     // Get the category value if the presel catefory is 'Y'
		order_category 			= bean.checkForNull(bean.getOrderCategoryValue(),"");
	else
		order_category			= "";
	if(function_from.equals("EXTERNAL_ORDER")) {
		order_category			= ext_order_category;
	}
 	String licence_key			= eOR.OR_license_rights.getKey(); // Get the Licence Key from the Class
	String[] record				= null;	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	//[IN038776] Start 
	String patient_id = (String) bean.checkForNull(request.getParameter("patient_id"),"");
	String encounter_id	=	(String) bean.checkForNull(request.getParameter("encounter_id"),"");
	String facility_id	= 	(String) bean.checkForNull((String) session.getValue( "facility_id" ),"");
	String ca_patient_class	= 	(String) bean.checkForNull((String) session.getValue( "ca_patient_class" ),"");
	String ca_patient_visit_id	="";
	int visitLength = 4;//IN045694
	if("OP".equals(ca_patient_class)||"EM".equals(ca_patient_class)){
		//IN045694 Starts
		//ca_patient_visit_id = (Integer.parseInt((String)encounter_id.substring(8,encounter_id.length())))+"";
		//encounter_id		= (String)encounter_id.substring(0, 8);
		if(!encounter_id.equals("")){//IN066709
			ca_patient_visit_id = (Integer.parseInt((String)encounter_id.substring(encounter_id.length()-visitLength)))+"";
			encounter_id		= (String)encounter_id.substring(0,encounter_id.length()-visitLength);
		}//IN066709	
		//IN045694 Ends
	}
	//condition to handle XT pat class IN044542 - Start
	if("null".equals(encounter_id))
		encounter_id = "";
	//IN044542 - End	
	if("IP".equals(ca_patient_class)){
		ca_patient_class="I";
	}else if("OP".equals(ca_patient_class)){
		ca_patient_class="O";
	}else if("EM".equals(ca_patient_class)){
		ca_patient_class = "E";
	}
	//IN003240 [EMR Realease] Start. 
	else if("DC".equals(ca_patient_class)){
		ca_patient_class = "D";
	}
	//IN003240 [EMR Realease] End.
	else{
		ca_patient_class = "R";
	} //Added else condition to handle XT pat class IN044542
	String patChartCalledFrm	= 	(String) bean.checkForNull((String)session.getValue(patient_id+"patChartCalledFrm"),"");	
	
	//[IN038776] End.
	String order_dispaly_verticalYN	=	(String)bean.getOrderDisplayVerticalYN();  //IN038787
%>
<html>
<head><title><fmt:message key="eOR.OrderEntryCriteriaHeader.label" bundle="${or_labels}"/></title>
 
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry1.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryRapidPreview.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



 	
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="addlSearchCriteriaForm" id="addlSearchCriteriaForm" onKeyPress="lockEnterKey()">
		<table cellpadding="3" cellspacing="0" border="0" width="100%" align="center">
		
		<tr>
			<td class="label"  nowrap><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<td class="fields">
			<select name="order_category" id="order_category" onChange="allowNewOrders(this,'addlSearchCriteriaForm');">
				<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
				ArrayList OrderCategory = bean.getOrderCategory("ALL_ORDER");
				 for(int i=0; i<OrderCategory.size(); i++)
				 {
 					record = (String[])OrderCategory.get(i);
 					if(ammend_called_from.equalsIgnoreCase("existing_order") || (function_from.equals("EXTERNAL_ORDER") && ext_order_category.equals(record[0])) || (bean.getOrderCategoryYn().equalsIgnoreCase("Y") && !bean.getOrderCategoryValue().equalsIgnoreCase("")))
 						disableOrderCategory = "DISABLED";
 					else if(bean.getOrderCategoryYn().equals("N") && bean.getOrderTypeCodeYn().equals("N") && !disableOrderCategory.equals("DISABLED"))
						disableOrderCategory = "";

					if( (bean.getOrderCategoryValue().equals(record[0]) && (ammend_called_from.equalsIgnoreCase("existing_order")  || bean.getOrderCategoryYn().equals("Y") )) || (function_from.equals("EXTERNAL_ORDER") && ext_order_category.equals(record[0])) || (licence_key.equals("ORPV")) ) // or for Alrabha Version(Pharmacy Version)
						out.println("<option value = \""+record[0]+"\" selected> "+record[1]+"");
					else
						out.println("<option value = \""+record[0]+"\"> "+record[1]+"");

				}
				
%>			</select>
<%
				if(bean.getOrderCategoryYn().equals("Y"))
					out.println("<img src=\"../../eCommon/images/mandatory.gif\"></img>");
				//[IN038776] Start	
				if(!function_from.equals("EXTERNAL_ORDER") && !function_from.equals("MO") &&  !function_from.equals("AMEND_ORDER") && !function_from.equals("MULTI_PATIENT_ORDERS") && !patChartCalledFrm.equals("OP")) { 
					
					String screeningServicesYN = bean.getScreeningServicesYN(facility_id,patient_id,ca_patient_class,encounter_id,ca_patient_visit_id); //"Y";					
					if("Y".equals(screeningServicesYN)){
					%>
					&nbsp; &nbsp;&nbsp;&nbsp; <A href="#" onClick="showScreeningServices();"><U>Screening Services</U></A> <!-- lable -->
				
					<%
					}
				}
				//[IN038776] End.
%>
			</td>
<%			
if(ammend_called_from.equalsIgnoreCase("existing_order") || 	(function_from.equals("EXTERNAL_ORDER") && ext_order_type_code.equals(record[0])) ||  (bean.getOrderCategoryYn().equals("Y") && bean.getOrderTypeCodeYn().equals("Y") && !bean.getOrderTypeValue().equals("")))
		disableOrderType = "DISABLED";
else if(bean.getOrderCategoryYn().equals("N") && bean.getOrderTypeCodeYn().equals("N") && !disableOrderType.equals("DISABLED"))
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
			<td class="label"  nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
			<td class="fields"  nowrap><input type='hidden' name='order_type' id='order_type' value="<%=ordertype%>"><input type='text' width='16%' name='order_type_desc' id='order_type_desc' value="<%=ordertypedesc%>" onBlur="getOrderTypeCode(this);clearactivityvalues('addlSearchCriteriaForm');"  maxlength='' ><input type=button name="ordertypesearch" id="ordertypesearch" value='?'  class=button tabIndex="4" onClick="callordertypeSearch(order_type_desc,order_type,'addlSearchCriteriaForm');">
			&nbsp;<img src="../../eCommon/images/mandatory.gif" id="order_type_mand" style="visibility:hidden"></img></td>
		
			
		<!--	<td class="label" id="order_type_id" ></td>-->
			<!--</td>-->
		</tr>
		<tr>
		<td class='label'><fmt:message key="eOR.ActivityType.label" bundle="${or_labels}"/></td>
		<td class='fields'><input type='hidden' name='activity_type' id='activity_type' value="<%=activity_type%>"><input type='text' width='16%' name='activity_type_desc' id='activity_type_desc' value="<%=activity_type_desc%>" onBlur="populateActivitySearch(activity_type_desc,activity_type,'addlSearchCriteriaForm');"  maxlength='' ><input type=button name=search value='?'  class=button tabIndex="4" onClick="callActivitySearch(activity_type_desc,activity_type,'addlSearchCriteriaForm');"></td>
		</td>
		<td class="label"  nowrap><fmt:message key="Common.RestrictbyService.label" bundle="${common_labels}"/></td>
			<td class="fields"   NOWRAP><input type="checkbox" name="restrict_by" id="restrict_by" value="N" onClick="changeCheckBoxValue(this)">
			
			</td></tr>
			<tr>
			<td class="label"  nowrap><fmt:message key="eOR.CatalogSearch.label" bundle="${or_labels}"/></td>
			<!-- <td  class="fields" id="order_text"  nowrap><input type="text" name="orderable_text" id="orderable_text" value = "" size="15" maxlength="40" onKeyPress="populateValues()"> IN038185-->
			<td  class="fields" id="order_text"  nowrap><input type="text" name="orderable_text" id="orderable_text" value = "" size="15" maxlength="40" onKeydown="populateValues()"><!--IN038185-->
			<%
				if(!bean.getOrderCategoryYn().equals("Y") && bean.getOrderCategoryValue().equals("") && !disableOrderCategory.equalsIgnoreCase("disabled"))
				{
					out.println("<img src=\"../../eCommon/images/mandatory.gif\" ></img>");
				}
			%>
				<select name="criteria" id="criteria"><option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option><option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option></select></td>
			<td class="label">
            <fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></td>
			<td class="fields" > <select name="order_catalog_nature" id="order_catalog_nature">
				<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value="A"><fmt:message key="Common.Individual.label" bundle="${common_labels}"/></option>
<% 				if(licence_key.equals("ORFV")) { %>
					<option value="P"><fmt:message key="Common.Panel.label" bundle="${common_labels}"/></option>
<%				} %>
				<option value="S"><fmt:message key="eOR.OrderSet.label" bundle="${or_labels}"/></option>
			</select></td>




 		</tr>
		<!--</table>
		<table border="0" cellspacing="0" cellpadding="3" align="right" width="10%">-->
		<tr>
<% if(!ammend_called_from.equals("existing_order")) { %>
			<!--<td>
				<input type="button" class="button" name="rapid_orders" id="rapid_orders" value=" Rapid Orders " disabled onClick="rapidOrders()">
			</td>-->
<%	}
			privApplicability = bean.getPrivilegeApplicability();
			if(privApplicability.equalsIgnoreCase("Y"))
			{
			%>
				<td class="label" colspan="2"></td> 
				<td class="label" style="align:right"><fmt:message key="eOR.LimitToMyApplicableCatalogs.label" bundle="${or_labels}"/><input type="checkbox" name="ApplicableCatalogs" id="ApplicableCatalogs" checked value="Y" onclick="SetApplicability(this);"></td>
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
			<td class='button' colspan='1'style="text-align:right;">
				<input type="button" class="button" name="search" id="search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="additionalSearch()" TITLE="Search"><input type="button" class="button" name="clear" id="clear"value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" onClick="clearAdditionalSearch()" TITLE="Clear"><%	if (!function_from.equals("AMEND_ORDER") && !function_from.equals("MULTI_PATIENT_ORDERS")) { %><input type="button" class="button" name="peview" id="peview"value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Preview.label","common_labels")%> " onClick="rapidPreview('<%=function_from%>')" TITLE="Preview">
			</td>
<%		} %>
 		</tr>
		</table>
		<%if(!imgUrl.equals("")){ %>
		<img src='<%=imgUrl%>' width='100%' height='15'/> 
		<%}%>
		<input type="hidden" name="order_category_yn" id="order_category_yn" value="<%=bean.getOrderCategoryYn()%>">
		<input type="hidden" name="order_type_yn" id="order_type_yn" value="<%=bean.getOrderTypeCodeYn()%>">
		<input type="hidden" name="order_category_value" id="order_category_value" value="<%=bean.getOrderCategoryValue()%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="ammend_called_from" id="ammend_called_from" value="<%=ammend_called_from%>">
		<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>">
		<input type="hidden" name="query_string" id="query_string" value="<%=request.getQueryString()%>">
        <input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
		<input type="hidden" name="activity_sql" id="activity_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT_LOOKUP")%>">
		<input type="hidden" name="order_type_sql" id="order_type_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_TYPE_LOOKUP")%>">
		<!--[IN038776] Start.-->
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
		<input type="hidden" name="ca_patient_class" id="ca_patient_class" value="<%=ca_patient_class%>">
		<input type="hidden" name="ca_patient_visit_id" id="ca_patient_visit_id" value="<%=ca_patient_visit_id%>"> 
		<!--[IN038776] End.-->
		<input type="hidden" name="order_dispaly_verticalYN" id="order_dispaly_verticalYN" value="<%=order_dispaly_verticalYN%>"> <!--  IN038787 -->
  		<%
			if(pre_sel_order_type_yn.equals("Y"))
				out.println( "<Script>setOrderType('addlSearchCriteriaForm',\"" + pre_sel_order_type_yn + "\") ; </script>" ) ;
			if(disableOrderCategory.equalsIgnoreCase("DISABLED"))
				out.println("<script>disableOrderCategory('addlSearchCriteriaForm')</script>");
			if(disableOrderType.equalsIgnoreCase("DISABLED"))
			
				out.println("<script>disableOrderType('addlSearchCriteriaForm')</script>");
				out.println("<script>OrderTypedisable('addlSearchCriteriaForm')</script>");
			
			
			// Nullifying the objects
			record			= null;		
			if(OrderCategory!=null) {
				OrderCategory.clear();		OrderCategory	= null;
			}
			
		
					 
			// set it back persistence
			putObjectInBean(bean_id,bean,request);
			// Only get method is used, not setting again, so need to persist
			//if(function_from.equals("EXTERNAL_ORDER")) { 
			//	putObjectInBean(existing_bean_id,external_bean_obj,request);
			//	}
		%>
	</form>
	<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}	
	%>
</body>
</html>


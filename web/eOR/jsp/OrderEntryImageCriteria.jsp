<!DOCTYPE html>
<%
/*
-----------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------
27/05/2019		IN069027	Ramesh G											MMS-DM-CRF-0150
17/12/2020	11607		Sivabagyam M		17/12/2020		Ramesh G	SKR-SCF-1531
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
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
		<script language="JavaScript" src="../../eOR/js/OrderEntryTab.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<script language="JavaScript" src="../js/OrderEntryCalendar.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="imageSearchForm" id="imageSearchForm">
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 			= request.getParameter("bean_id");
	String bean_name 		= request.getParameter("bean_name");
	String disableOrderCategory = "";
	String disableOrderType		= "";
	/* Initialize Function specific start */
	//OrderEntryBean bean 		= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);
	OrderEntryBean bean			 = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	
	boolean dxRecordReqYN=bean.isSiteSpecific("DX_CHK_BFR_PLACE_ORDERS");//11607
	/* Initialize Function specific end */
	//Properties properties		= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean
	String ammend_called_from	= bean.checkForNull(request.getParameter("ammend_called_from"),"");
	String privApplicability = "";
	//String pre_sel_order_type_yn	= bean.getPreOrderType(bean.getOrderCategoryValue());
//	String pre_sel_order_category_yn= bean.getOrderCategoryYn();

//	if(ammend_called_from.equalsIgnoreCase("existing_order")) //Make the pre_sel_order_type_yn = "N" , because user cannot change category in the amend order
//		pre_sel_order_category_yn		= "";
	String order_category		= "";
	if(bean.getOrderCategoryYn().equalsIgnoreCase("Y"))
				order_category 	= bean.checkForNull(bean.getOrderCategoryValue(),"");
	String[] record				= null;
	String disbaled= "";//IN069027
	//11607 STARTS
	if(dxRecordReqYN){
		disbaled= "disabled";
	}
	//11607 ENDS
	//if(pre_sel_order_category_yn.equals("N") || ((bean.getOrderCategoryValue().equalsIgnoreCase("") || bean.getOrderCategoryValue().equalsIgnoreCase("RD") || bean.getOrderCategoryValue().equalsIgnoreCase("RX") ) ))
	// restrict for amend
	if(!ammend_called_from.equalsIgnoreCase("existing_order"))
	{
%>

		<table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
		     <td width="10%"   class="label" nowrap><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			 <td  width="20%" class="fields">
		   	 <select name="order_category" id="order_category"  width="15" onChange="allowNewOrders(this,'imageSearchForm');">
			  <%
			  if(dxRecordReqYN){//11607
			 %>
			  <option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option> <!--IN069027--> 
			<%
			}
			  ArrayList OrderCategory = bean.getOrderCategory("Image");
			    for(int i=0; i<OrderCategory.size(); i++)
			    {
					record = (String[])OrderCategory.get(i);
					if(ammend_called_from.equalsIgnoreCase("existing_order") || (bean.getOrderCategoryYn().equalsIgnoreCase("Y") && !bean.getOrderCategoryValue().equalsIgnoreCase("")))
					 	disableOrderCategory = "DISABLED";
					else if(bean.getOrderCategoryYn().equals("N") && bean.getOrderTypeCodeYn().equals("N"))
						disableOrderCategory = "";
					if( ((bean.getOrderCategoryValue().equalsIgnoreCase(record[0]) && bean.getOrderCategoryYn().equals("Y")) || (ammend_called_from.equalsIgnoreCase("existing_order") && bean.getOrderCategoryValue().equalsIgnoreCase(record[0]))) )
						out.println("<option value = '"+record[0]+"' selected> "+record[1]+" </option>");
					else
						out.println("<option value = '"+record[0]+"'> "+record[1]+" </option>");
					record = null;		//nullifying the objects
			    }
%>
			</select>
			</td>
			<td width="10%"   class="label" nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
			<td align="left" width="20%" class="fields">
				<input type='hidden'  name='order_type' id='order_type' value="">
				<input type='text' <%=disbaled%> width='16%' name='order_type_desc' value="" onBlur="populateordertypeSearch(order_type_desc,order_type,'imageSearchForm');clearactivityvalues('imageSearchForm');"  maxlength='' ><!--IN069027 ADDED DISABLED-->
				<input type=button <%=disbaled%> name="ordertypesearch" value='?'  class=button tabIndex="4" onClick="callordertypeSearch(order_type_desc,order_type,'imageSearchForm');"><!--IN069027 ADDED DISABLED-->
			<img src="../../eCommon/images/mandatory.gif" id="order_type_mand" style="visibility:hidden"></img>
			</td>
		 </tr>
		 <tr>	
			<td width="10%" class="label"  nowrap><fmt:message key="eOR.ActivityType.label" bundle="${or_labels}"/></td>
			<td class="fields" width="20%" >
				<input type='hidden'  name='activity_type' id='activity_type' value="">
				<input type='text' <%=disbaled%> width='16%' name='activity_type_desc' value="" onBlur="populateActivitySearch(activity_type_desc,activity_type,'imageSearchForm');"  maxlength='' ><!--IN069027 ADDED DISABLED-->
				<input type=button <%=disbaled%> name=search value='?'  class=button tabIndex="4" onClick="callActivitySearch(activity_type_desc,activity_type,'imageSearchForm');"><!--IN069027 ADDED DISABLED-->
			</td>
			<%
			privApplicability = bean.getPrivilegeApplicability();
			if(privApplicability.equalsIgnoreCase("Y"))
			{
			%>
				<td class="label" nowrap><fmt:message key="eOR.LimitToMyApplicableCatalogs.label" bundle="${or_labels}"/><input type="checkbox" name="ApplicableCatalogs" id="ApplicableCatalogs" checked value="Y" onclick="SetApplicability(this);"></td>
				<td class="label">&nbsp;</td>
			<%
			}
			else
			{
			%>
				<td class="label" colspan="2">&nbsp;</td>
				<input type="hidden" name="ApplicableCatalogs" id="ApplicableCatalogs" value="">
			<%
			}
			%>
		</tr>
		 </table>
		 <%if(!imgUrl.equals("")){ %>
		<img src='<%=imgUrl%>' width='100%' height='15'/> 
		<%}%>
		 	<input type="hidden" name="order_category_yn" id="order_category_yn" value="<%=bean.getOrderCategoryYn()%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="ammend_called_from" id="ammend_called_from" value="<%=ammend_called_from%>">
			<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
			<input type="hidden" name="activity_sql" id="activity_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_ACTIVITY_TYPE_SELECT_LOOKUP")%>">
			<input type="hidden" name="order_type_sql" id="order_type_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_TYPE_LOOKUP")%>">

			<input type="hidden" name="order_type_yn" id="order_type_yn" value="<%=bean.getOrderTypeCodeYn()%>">
		<%
				if(disableOrderCategory.equalsIgnoreCase("DISABLED"))
					out.println("<script>disableOrderCategory('imageSearchForm')</script>");
				if(disableOrderType.equalsIgnoreCase("DISABLED"))
					out.println("<script>disableOrderType('imageSearchForm')</script>");
    				out.println("<script>OrderTypedisable('imageSearchForm')</script>");
		%>
			<script>//document.imageSearchForm.order_category.options[0].selected = true;</script>
		<Script>populateImageOrderType(document.imageSearchForm.order_category);</script>
		<script>imageSearch();</script>
		</form>
		<%
			// Nullifying the objects
			record				= null;				OrderCategory = null;
			
		%>
		
	</body>
<%	} else { %>
	<script>alert(getMessage("IMAGE_PRE_SELECT_CATEGORY","OR"));</script>
<%	} %>
</html>

<%
	// set it back persistence
	//putObjectInBean(bean_id,bean,request);
%>


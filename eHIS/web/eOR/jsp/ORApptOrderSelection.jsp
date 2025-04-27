<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
24/08/2013    IN030284		ChowminyaG 		Created:To capture Pre-consultation orders in Appointment Scheduling
26/09/2013	  IN043755		ChowminyaG		Bru-HIMS-CRF-165.1/09
---------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page
	import="java.util.*,eOR.*,eOR.Common.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String imgUrl = "";
	if (sStyle.equals("IeStyle.css")) {
		imgUrl = "../../eCommon/images/searchBoxBG.jpg";
	}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css' />
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../js/ORApptOrderSelection.js"></script>
<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script> 
	var chkBothCriteria = false;
	var fromCalledP
age = false ;
 </script>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"
	onLoad="callDisable();searchResult();">
	<%
		/* Mandatory checks start */
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String mode = request.getParameter("mode");
		String bean_id = "refusalOrdersBean";
		String bean_name = "eOR.RefusalOrdersBean";
		String order_category = (request.getParameter("order_category") == null)
				? ""
				: request.getParameter("order_category");
		String order_type = (request.getParameter("order_type") == null)
				? ""
				: request.getParameter("order_type");
		String activity_type = (request.getParameter("activity_type") == null)
				? ""
				: request.getParameter("activity_type");
		String searchText = request.getParameter("searchText");
		if (searchText == null)
			searchText = "";
		String called_from = (request.getParameter("called_from") == null)
				? ""
				: request.getParameter("called_from");
		String p_clinic_code = (request.getParameter("p_clinic_code") == null)
				? ""
				: request.getParameter("p_clinic_code");

		RefusalOrdersBean bean = (RefusalOrdersBean) getBeanObject(bean_id,
				bean_name, request);
		bean.setLanguageId(localeName);

		ArrayList getOrderCategory = new ArrayList();
		ArrayList OrderTypes = new ArrayList();
		ArrayList ar;
		ArrayList ActivityType = new ArrayList();
		getOrderCategory = (ArrayList) bean.getOrderCategory();
		OrderTypes = (ArrayList) bean.getLocation(order_category);
		ActivityType = (ArrayList) bean.getActivityType(order_category,
				order_type);
	%>
	<form name="OrderableSearch" id="OrderableSearch" target='' action=''>

		<table align="center" border="0" width="100%" cellspacing="0"
			cellpadding="3">
			<tr>
				<td class="label" nowrap><fmt:message
						key="Common.OrderCategory.label" bundle="${common_labels}" /></td>
				<td class='fields'><select name="ordercategory" id="ordercategory"
					onChange="populateOrderCodes(this)">
						<option value="" selected>
							<fmt:message key="Common.all.label" bundle="${common_labels}" />
						</option>
						<%
							if (!order_category.equals("")) {

								for (int i = 0; i < getOrderCategory.size(); i++) {
									String getcategory[] = (String[]) getOrderCategory.get(i);
						%>
						<option value="<%=getcategory[0].trim()%>"
							<%=eHISFormatter.select(order_category.trim(),
							getcategory[0].trim())%>><%=getcategory[1]%></option>
						<%
							}
							} else 
							{

								for (int i = 0; i < getOrderCategory.size(); i++) 
								{
									String getcategory[] = (String[]) getOrderCategory.get(i);
									//IN043755 - included if condition to restrict PH
									if(!"PH".equals(getcategory[0]))
									{
						%>
						<option value="<%=getcategory[0]%>"><%=getcategory[1]%></option>
						<%
									}
								}
							}
						%>
				</select></td>
				<td class="label" nowrap><fmt:message
						key="Common.OrderTypeCode.label" bundle="${common_labels}" /></td>
				<td class='fields'><select name="typecode" id="typecode"
					onChange="populateActivity(this)">
						<option value="" selected>
							<fmt:message key="Common.all.label" bundle="${common_labels}" />
						</option>
						<%
							if (!order_type.equals("")) {
								for (int i = 0; i < OrderTypes.size(); i++) {
									String getordertype[] = (String[]) OrderTypes.get(i);
						%>
						<option value="<%=getordertype[0].trim()%>"
							<%=eHISFormatter.select(order_type.trim(),
							getordertype[0].trim())%>><%=getordertype[1]%></option>
						<%
							}
							} else {
								for (int i = 0; i < OrderTypes.size(); i++) {
									String getordertype[] = (String[]) OrderTypes.get(i);
						%>
						<option value="<%=getordertype[0]%>"><%=getordertype[1]%></option>
						<%
							}
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td class="label" nowrap><fmt:message
						key="eOR.ActivityType.label" bundle="${or_labels}" /></td>
				<td class="fields"><select name="activity_type" id="activity_type">
						<option value="" selected>
							<fmt:message key="Common.all.label" bundle="${common_labels}" />
						</option>
						<%
							for (int i = 0; i < ActivityType.size(); i++) {
								String getactivitytype[] = (String[]) ActivityType.get(i);
						%>
						<option value="<%=getactivitytype[0].trim()%>"
							<%if (!ActivityType.equals("")) {%>
							<%=eHISFormatter.select(activity_type.trim(),
							getactivitytype[0].trim())%>><%=getactivitytype[1]%></option>
						<%
							} else {
						%>
						<option value="<%=getactivitytype[0]%>"><%=getactivitytype[1]%></option>
						<%
							}
							}
						%>

				</select></td>
				<td class="label" nowrap><fmt:message
						key="Common.searchby.label" bundle="${common_labels}" /></td>
				<td class="fields"><input type="radio" name="search_by" id="search_by"
					class="label" value="D" checked onclick="storeVal(this)">
				<fmt:message key="Common.description.label"
						bundle="${common_labels}" /> <input type="radio" name="search_by" id="search_by"
					class="label" value="C" onclick="storeVal(this)">
				<fmt:message key="Common.code.label" bundle="${common_labels}" /></td>
			</tr>
			<tr>
				<td class="label"><fmt:message
						key="Common.SearchCriteria.label" bundle="${common_labels}" /></td>
				<td class='fields'><select name="search_criteria" id="search_criteria">
						<option value="S">
							<fmt:message key="Common.startsWith.label"
								bundle="${common_labels}" />
						<option value="E">
							<fmt:message key="Common.endsWith.label"
								bundle="${common_labels}" />
						<option value="C">
							<fmt:message key="Common.contains.label"
								bundle="${common_labels}" />
				</select></td>
				<td class="label"><fmt:message key="Common.searchtext.label"
						bundle="${common_labels}" /></td>
				<td class='fields'><input type="text"
					onBlur="makeValidString(this);" name="search_text" id="search_text"
					value='<%=searchText%>' width="30%" align="left" size="40"
					maxlength="70" onKeyPress="populateSearch()"></td>
			</tr>
			<tr>
				<td colspan=3></td>
				<td class="button" align="right" nowrap><input type="button"
					align="left" name="Search" id="Search"
					value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,
					"Common.search.label", "common_labels")%>"
					onClick="searchResult()" class="button"> <input type="button" align="left" name="Reset" id="Reset"
					value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,
					"Common.reset.label", "common_labels")%>"
					onClick="resetFormSearch(this.form)" class="button"></td>
			</tr>

		</table>
		<%
			if (!imgUrl.equals("")) {
		%>
		<img src='<%=imgUrl%>' width='100%' height='15' />
		<%
			}
		%>
		<input type="hidden" name="mode" id="mode" value="<%=mode%>"> 
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>"> 
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>">
		<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
		<input type="hidden" name="templocale" id="templocale" value="<%=localeName%>">
		<input type="hidden" name="p_clinic_code" id="p_clinic_code" value="<%=p_clinic_code%>">

	</form>
</body>
</html>
<%
	ar = bean.getArrayList();

	for (int or = 0; or < ar.size(); ++or) {

		if (!bean.containsTempObject(ar.get(or))) {
			bean.putTempObject(ar.get(or));
		}

	}
	putObjectInBean(bean_id, bean, request);
%>


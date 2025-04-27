<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import = "java.util.*,eOR.*,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eOR/js/OrdersTab.js"></script>
		<!--
	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<form name="frmOrder" id="frmOrder">
<%
	String exist_order = "";
	String new_order = "";
	String Frequent_Orders = "";
	String addl_search = "";
	String tick_sheets ="";
	String order_sets ="";
	String image ="";
	String place_order ="";
%>

<table class='grid' width="100%">
<tr align='center'> <th class=' columnheader'><fmt:message key="eOR.TabName.label" bundle="${or_labels}"/></th>
<th class='columnheader'><fmt:message key="eOR.UserDefinedTabName.label" bundle="${or_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></th> 
<th class='columnheader'><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></th> 

<%
	String bean_id = "Or_OrdersTab";
	String bean_name = "eOR.OrdersTabBean";

	OrdersTabBean bean = (OrdersTabBean)getBeanObject( bean_id,  bean_name , request) ;

	request.setCharacterEncoding("UTF-8");	

	String mode	   = request.getParameter("mode");
	
	//String function_id = request.getParameter("function_id");
	String install_yn = (String )bean.getPhInstall(); 
	// returns either Y or N based on the PH module installation
	HashMap tabData = new HashMap();
	HashMap hashMap = new HashMap();
	String practitioner_id = request.getParameter("practitioner_id"); 
	String patient_class = request.getParameter("patient_class");
	String func_id = request.getParameter("func_id");
	//out.println("<script>alert('"+request.getQueryString()+"');</script>");
	//String facility_id = request.getParameter("facility_id");
	if(practitioner_id.equals("") || practitioner_id == null)
	{
		hashMap = null;
	}
	else
	{
		if(patient_class.equals("") || patient_class == null)
		{
			hashMap = null;
		}
		else
		{
			tabData.put("practitioner_id",practitioner_id.trim());
			tabData.put("patient_class",patient_class.trim());
			tabData.put("func_id",func_id.trim());
			//tabData.put("facility_id",facility_id);
			hashMap = (HashMap ) bean.checkForDuplicates(tabData);
			
		}
	}

	if(hashMap == null)
	{
		mode="1"; // insert mode
		exist_order = "Y";
		new_order ="Y";
		Frequent_Orders = "Y";
		addl_search = "Y";
		tick_sheets ="Y";
		order_sets ="Y";
		image ="Y";
		place_order ="Y";
%>
<tr >
<td class="gridData"  ><div class="label"><fmt:message key="eOR.ExistingOrders.label" bundle="${or_labels}"/></div></td> 
<td class="gridData"> <input type=text name="tabNameForExistOrder" id="tabNameForExistOrder" maxLength=20  value="Existing Orders" size=30> </td> 
<td class="gridData"> <input type=text name="seqNumForExistOrder" id="seqNumForExistOrder" onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)" value="1" size=1 maxLength=1> </td> 
<td class="gridData"> <input type="checkbox" name="existOrderCheck" id="existOrderCheck" checked onclick="validateExistOrder(frmOrder)" > </td> 
</tr>

<tr >
<td class="gridData"  ><div class="label"><fmt:message key="Common.NewOrders.label" bundle="${common_labels}"/></div></td> 
<td class="gridData"> <input type=text name="tabNameForNewOrder" id="tabNameForNewOrder" maxLength=20  value="New Orders" size=30> </td> 
<td class="gridData"> <input type=text name="seqNumForNewOrder" id="seqNumForNewOrder" onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)" value="2" size=1 maxLength=1> </td> 
<td class="gridData"> <input type="checkbox" name="newOrderCheck" id="newOrderCheck" checked onclick="validateNewOrder(frmOrder)" > </td> 
</tr>


<!--<tr align=center>
<td class="QRYODD" align=right><div class="label">  Frequent Orders </div> </td> 
<td class="QRYODD"> <input type=text name="tabNameForFrequentOrders" id="tabNameForFrequentOrders" 
value="Frequent Orders" size=30 maxLength=20> </td> 
<td class="QRYODD"> <input type=text name="seqNumForFrequentOrders" id="seqNumForFrequentOrders"  value="1" size=1 maxLength=1 onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)"> </td> 
<td class="QRYODD"> <input type="checkbox" name="FrequentOrdersCheck" id="FrequentOrdersCheck" checked onclick="validateFrequentOrders(frmOrder)" > </td> 
</tr>
-->
<tr>
<td class="gridData" ><div class="label"><fmt:message key="eOR.AdditionalSearch.label" bundle="${or_labels}"/></div></td>  
<td class="gridData"> <input type=text name="tabNameForSearch" id="tabNameForSearch" 
value="Additional Search" size=30 maxLength=20> </td> 
<td class="gridData"> <input type=text name="seqNumForSearch" id="seqNumForSearch"  value="2" size=1 maxLength=1 onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)"> </td> 
<td class="gridData"> <input type="checkbox" name="addnlSearchCheck" id="addnlSearchCheck" checked onclick="validateAddnlSearch(frmOrder)" > </td> 
</tr>
<tr >
<td class="gridData"  class="label"><div class="label"><fmt:message key="eOR.TickSheets.label" bundle="${or_labels}"/></div></td> 
<td class="gridData" > <input type=text name="tabNameForTickSheet" id="tabNameForTickSheet" size=30 maxLength=20  value="Tick Sheets"> </td> 
<td class="gridData" > <input type=text name="seqNumForTickSheet" id="seqNumForTickSheet"   value="3" size=1 maxLength=1 onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)"> </td> 
<td class="gridData"> <input type="checkbox" name="tickSheetCheck" id="tickSheetCheck" checked  onclick="validateTickSheet(frmOrder)"  > </td> 
</tr>
<tr >
<td class="gridData"  class="label"><div class="label"> <fmt:message key="eOR.OrderSets.label" bundle="${or_labels}"/></div></td> 
<td class="gridData" > <input type=text name="tabNameForOrderSets" id="tabNameForOrderSets" size=30 maxLength=20   value="Order Sets"> </td> 
<td class="gridData" > <input type=text name="seqNumForOrderSets" id="seqNumForOrderSets"  value="4" size=1 maxLength=1 onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)"> </td> 
<td class="gridData"> <input type="checkbox" name="orderSetsCheck" id="orderSetsCheck"  checked onclick="validateOrderSets(frmOrder)" > </td> 
</tr>
<tr >
<td class="gridData" class="label"> <div class="label"><fmt:message key="Common.Image.label" bundle="${common_labels}"/></div></td> 
<td class="gridData" > <input type=text name="tabNameForImage" id="tabNameForImage" size=30 maxLength=20  value="Image"> </td> 
<td class="gridData" > <input type=text name="seqNumForImage" id="seqNumForImage"  value="5" size=1 maxLength=1 onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)"> </td> 
<td class="gridData"> <input type="checkbox" name="imageCheck" id="imageCheck" checked  onclick="validateImage(frmOrder)"   > </td> 
</tr>
<tr>
<td class="gridData"  class="label"><div class="label"><fmt:message key="Common.PlaceOrder.label" bundle="${common_labels}"/></div></td>  
<td class="gridData" > <input type=text name="tabNameForPlaceOrder" id="tabNameForPlaceOrder" size=30 maxLength=20  value="Place Order"> </td> 
<td class="gridData"> <input type=text name="seqNumForPlaceOrder" id="seqNumForPlaceOrder" readonly  value="9" size=1 maxLength=1 > </td> 
<td class="gridData"> <input type="checkbox" name="placeOrderCheck" id="placeOrderCheck" onclick="validatePlaceOrder(frmOrder)" checked disabled  > </td> 
</tr>
	<%
		}// end of if
	else
	{
		mode="2"; //update mode
		Vector data = new Vector();
		int index=0;
		String classvalue="";
		data = (Vector )hashMap.get("listOfRecords");

/****************************************/
if(data.contains("existingOrders"))
		{
			index = data.indexOf("existingOrders");
			classvalue = "gridData";
			exist_order = "Y";
		%>
<tr >
<td class='<%= classvalue %>'  ><div class="label"> <fmt:message key="eOR.ExistingOrders.label" bundle="${or_labels}"/></div></td> 
<td class='<%= classvalue %>'> <input type=text name="tabNameForExistOrder" id="tabNameForExistOrder"  value='<%= (String )data.get(index + 1)%>' size=30 maxLength=20> </td> 
<td class='<%= classvalue %>'> <input type=text name="seqNumForExistOrder" id="seqNumForExistOrder" onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)" value='<%= (String )data.get(index + 2)%>' size=1 maxLength=1> </td> 
<td class='<%= classvalue %>'> <input type="checkbox" name="existOrderCheck" id="existOrderCheck"  onclick="validateExistOrder(frmOrder)" 
checked='<%= (String )data.get(index + 3)%>'> </td> 
</tr>
		<%
		}
		else
		{
			classvalue = "gridData";
			exist_order = "N";
		%>
<tr >
<td class='<%= classvalue %>' ><div class="label"> <fmt:message key="eOR.ExistingOrders.label" bundle="${or_labels}"/></div></td> 
<td class='<%= classvalue %>'> <input type=text name="tabNameForExistOrder" id="tabNameForExistOrder" maxLength=20  value="Existing Orders "  size=30 maxLength=20> </td> 
<td class='<%= classvalue %>'> <input type=text name="seqNumForExistOrder" id="seqNumForExistOrder" onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)" value="" size=1 maxLength=1> </td> 
<td class='<%= classvalue %>'> <input type="checkbox" name="existOrderCheck" id="existOrderCheck"  onclick="validateExistOrder(frmOrder)" > 
</td> 
</tr>
		
<%	}
	if(data.contains("newOrders"))
		{
			index = data.indexOf("newOrders");
			classvalue = "gridData";
			new_order = "Y";
		%>
<tr >
<td class='<%= classvalue %>'  ><div class="label"> <fmt:message key="Common.NewOrders.label" bundle="${common_labels}"/></div></td> 
<td class='<%= classvalue %>'> <input type=text name="tabNameForNewOrder" id="tabNameForNewOrder"  value='<%= (String )data.get(index + 1)%>' size=30 maxLength=20> </td> 
<td class='<%= classvalue %>'> <input type=text name="seqNumForNewOrder" id="seqNumForNewOrder" onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)" value='<%= (String )data.get(index + 2)%>' size=1 maxLength=1> </td> 
<td class='<%= classvalue %>'> <input type="checkbox" name="newOrderCheck" id="newOrderCheck"  onclick="validateNewOrder(frmOrder)" 
checked='<%= (String )data.get(index + 3)%>'> </td> 
</tr>
		<%
		}
		else
		{
			classvalue = "gridData";
			new_order = "N";
		%>
<tr >
<td class='<%= classvalue %>'  ><div class="label"> <fmt:message key="Common.NewOrders.label" bundle="${common_labels}"/></div></td> 
<td class='<%= classvalue %>'> <input type=text name="tabNameForNewOrder" id="tabNameForNewOrder" maxLength=20  value="New Orders "  size=30 maxLength=20> </td> 
<td class='<%= classvalue %>'> <input type=text name="seqNumForNewOrder" id="seqNumForNewOrder" onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)" value="" size=1 maxLength=1> </td> 
<td class='<%= classvalue %>'> <input type="checkbox" name="newOrderCheck" id="newOrderCheck"  onclick="validateNewOrder(frmOrder)" > 
</td> 
</tr>
	<%
		} %>
<tr > <td class='columnheader' > </td>
<td class='columnheader' > </td> 
<td class='columnheader'> </td> 
<td class='columnheader'> </td> </tr>
		

			<%	
		if(data.contains("frequentOrders"))
		{
			index = data.indexOf("frequentOrders");
			classvalue = "gridData";
			Frequent_Orders =  "Y";
		%>
<tr >
<td class='<%= classvalue %>'  ><div class="label"><fmt:message key="eOR.FrequentOrders.labelFrequent" bundle="${or_labels}"/></div></td> 
<td class='<%= classvalue %>'> <input type=text name="tabNameForFrequentOrders" id="tabNameForFrequentOrders"  value='<%= (String )data.get(index + 1)%>' size=30 maxLength=20> </td> 
<td class='<%= classvalue %>'> <input type=text name="seqNumForFrequentOrders" id="seqNumForFrequentOrders" onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)" value='<%= (String )data.get(index + 2)%>' size=1 maxLength=1> </td> 
<td class='<%= classvalue %>'> <input type="checkbox" name="FrequentOrdersCheck" id="FrequentOrdersCheck"  onclick="validateFrequentOrders(frmOrder)" 
checked='<%= (String )data.get(index + 3)%>'> </td> 
</tr>
		<%
		}
		else
		{
			classvalue = "gridData";
			Frequent_Orders =  "N";
		%>
<!--<tr align=center>
<td class='<%= classvalue %>' align=right ><div class="label">  Frequent Orders </div> </td> 
<td class='<%= classvalue %>'> <input type=text name="tabNameForFrequentOrders" id="tabNameForFrequentOrders" maxLength=20  value="Frequent Orders"  size=30 maxLength=20> </td> 
<td class='<%= classvalue %>'> <input type=text name="seqNumForFrequentOrders" id="seqNumForFrequentOrders" onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)" value="" size=1 maxLength=1> </td> 
<td class='<%= classvalue %>'> <input type="checkbox" name="FrequentOrdersCheck" id="FrequentOrdersCheck"  onclick="validateFrequentOrders(frmOrder)" > 
</td> 
</tr>
-->
		<%
		}
		if(data.contains("additionalSearch"))
		{
			index = data.indexOf("additionalSearch");
			classvalue = "gridData";
			addl_search = "Y";
		%>
<tr >
<td class='<%= classvalue %>'  ><div class="label"><fmt:message key="eOR.AdditionalSearch.label" bundle="${or_labels}"/></div></td>  
<td class='<%= classvalue %>'> <input type=text name="tabNameForSearch" id="tabNameForSearch"  value='<%= (String )data.get(index + 1)%>' size=30 maxLength=20> </td> 
<td class='<%= classvalue %>'> <input type=text name="seqNumForSearch" id="seqNumForSearch" onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)" value='<%= (String )data.get(index + 2)%>' size=1 maxLength=1> </td> 
<td class='<%= classvalue %>'> <input type="checkbox" name="addnlSearchCheck" id="addnlSearchCheck"  onclick="validateAddnlSearch(frmOrder)" 
checked='<%= (String )data.get(index + 3)%>'> </td> 
</tr>
		<%
		}
		else
		{
			classvalue = "gridData";
			addl_search = "N";
		%>
<tr >
<td class='<%= classvalue %>'  ><div class="label"> <fmt:message key="eOR.AdditionalSearch.label" bundle="${or_labels}"/></div></td>   
<td class='<%= classvalue %>'> <input type=text name="tabNameForSearch" id="tabNameForSearch" maxLength=20  value="Additional Search"  size=30 maxLength=20> </td> 
<td class='<%= classvalue %>'> <input type=text name="seqNumForSearch" id="seqNumForSearch" onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)" value="" size=1 maxLength=1> </td> 
<td class='<%= classvalue %>'> <input type="checkbox" name="addnlSearchCheck" id="addnlSearchCheck"  onclick="validateAddnlSearch(frmOrder)" > 
</td> 
</tr>
		<%
		}
		if(data.contains("tickSheet"))
		{
			index = data.indexOf("tickSheet");
			classvalue = "gridData";
			tick_sheets = "Y";
		%>
<tr >
<td class='<%= classvalue %>'  ><div class="label"> <fmt:message key="eOR.TickSheets.label" bundle="${or_labels}"/></div></td> 
<td class='<%= classvalue %>'> <input type=text name="tabNameForTickSheet" id="tabNameForTickSheet"   value='<%= (String )data.get(index + 1)%>' size=30 maxLength=20 > </td> 
<td class='<%= classvalue %>'> <input type=text name="seqNumForTickSheet" id="seqNumForTickSheet" onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)" value='<%= (String )data.get(index + 2)%>' size=1 maxLength=1> </td> 
<td class='<%= classvalue %>'> <input type="checkbox" name="tickSheetCheck" id="tickSheetCheck"  onclick="validateTickSheet(frmOrder)" 
checked='<%= (String )data.get(index + 3)%>'> </td> 
</tr>						
		<%
		}
		else
		{
			classvalue = "gridData";
			tick_sheets = "N";
		%>
<tr >
<td class='<%= classvalue %>'  > <div class="label"><fmt:message key="eOR.TickSheets.label" bundle="${or_labels}"/></div></td> 
<td class='<%= classvalue %>'> <input type=text name="tabNameForTickSheet" id="tabNameForTickSheet"  value="Tick Sheets" size=30 maxLength=20> </td> 
<td class='<%= classvalue %>'> <input type=text name="seqNumForTickSheet" id="seqNumForTickSheet" onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)" value="" size=1 maxLength=1> </td> 
<td class='<%= classvalue %>'> <input type="checkbox" name="tickSheetCheck" id="tickSheetCheck"  onclick="validateTickSheet(frmOrder)" > 
</td> 
</tr>	
		<%
		}
		if(data.contains("careSet"))
		{
			index = data.indexOf("careSet");
			classvalue = "gridData";
			order_sets = "Y";
		%>
<tr >
<td class='<%= classvalue %>'  > <div class="label"> <fmt:message key="eOR.OrderSets.label" bundle="${or_labels}"/></div></td> 
<td class='<%= classvalue %>'> <input type=text name="tabNameForOrderSets" id="tabNameForOrderSets" 
		value='<%= (String )data.get(index + 1)%>' size=30 maxLength=20> </td> 
<td class='<%= classvalue %>'> <input type=text name="seqNumForOrderSets" id="seqNumForOrderSets" onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)" value='<%= (String )data.get(index + 2)%>' size=1 maxLength=1> </td> 
<td class='<%= classvalue %>'> <input type="checkbox" name="orderSetsCheck" id="orderSetsCheck"  onclick="validateOrderSets(frmOrder)" 
checked='<%= (String )data.get(index + 3)%>'> </td> 
</tr>

		<%
		}
		else
		{
			classvalue = "gridData";
			order_sets = "N";
		%>
<tr >
<td class='<%= classvalue %>'  ><div class="label"><fmt:message key="eOR.OrderSets.label" bundle="${or_labels}"/></div></td> 
<td class='<%= classvalue %>'> <input type=text name="tabNameForOrderSets" id="tabNameForOrderSets"  value="Order Sets"  size=30 maxLength=20> </td> 
<td class='<%= classvalue %>'> <input type=text name="seqNumForOrderSets" id="seqNumForOrderSets" onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)" value="" size=1 maxLength=1> </td> 
<td class='<%= classvalue %>'> <input type="checkbox" name="orderSetsCheck" id="orderSetsCheck"  onclick="validateOrderSets(frmOrder)"  > 
</td> 
</tr>
		<%
		}
		if(data.contains("image"))
		{
			index = data.indexOf("image");
			classvalue = "gridData";
			image = "Y";
		%>
<tr >
<td class='<%= classvalue %>'  > <div class="label"><fmt:message key="Common.Image.label" bundle="${common_labels}"/></div></td> 
<td class='<%= classvalue %>'> <input type=text name="tabNameForImage" id="tabNameForImage" 
		value='<%= (String )data.get(index + 1)%>' size=30 maxLength=20 > </td> 
<td class='<%= classvalue %>'> <input type=text name="seqNumForImage" id="seqNumForImage" onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)" value='<%= (String )data.get(index + 2)%>' size=1 maxLength=1> </td> 
<td class='<%= classvalue %>'> <input type="checkbox" name="imageCheck" id="imageCheck"  onclick="validateImage(frmOrder)" 
checked='<%= (String )data.get(index + 3)%>'> </td> 
</tr>
		<%
		}
		else
		{
			classvalue = "gridData";
			image = "N";
		%>
<tr >
<td class='<%= classvalue %>'  ><div class="label"><fmt:message key="Common.Image.label" bundle="${common_labels}"/></div></td> 
<td class='<%= classvalue %>'> <input type=text name="tabNameForImage" id="tabNameForImage"  value="Image" size=30 maxLength=20> </td> 
<td class='<%= classvalue %>'> <input type=text name="seqNumForImage" id="seqNumForImage" onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this)" value="" size=1 maxLength=1> </td> 
<td class='<%= classvalue %>'> <input type="checkbox" name="imageCheck" id="imageCheck"  onclick="validateImage(frmOrder)"  > 
</td> 
</tr>		
		<%
		}
		if(data.contains("placeOrder"))
		{
			index = data.indexOf("placeOrder");
			classvalue = "gridData";
			place_order = "Y";
		%>
<tr >
<td class='<%= classvalue %>'  > <div class="label"><fmt:message key="Common.PlaceOrder.label" bundle="${common_labels}"/></div></td> <td class='<%= classvalue %>'> <input type=text name="tabNameForPlaceOrder" id="tabNameForPlaceOrder" 
		value='<%= (String )data.get(index + 1)%>' size=30 maxLength=20 > </td> 
<td class='<%= classvalue %>'> <input type=text name="seqNumForPlaceOrder" id="seqNumForPlaceOrder" readonly value='<%= (String )data.get(index + 2)%>' size=1 maxLength=1 > </td> 
<td class='<%= classvalue %>'> <input type="checkbox" name="placeOrderCheck" id="placeOrderCheck" disabled onclick="validatePlaceOrder(frmOrder)" 
checked='<%= (String )data.get(index + 3)%>'> </td> 
</tr>
		<%
		}
		else
		{
			classvalue = "gridData";
			place_order = "Y";
		%>
<tr >
<td class='<%= classvalue %>'  ><div class="label"><fmt:message key="Common.PlaceOrder.label" bundle="${common_labels}"/></div></td>
<td class='<%= classvalue %>'> <input type=text name="tabNameForPlaceOrder" id="tabNameForPlaceOrder" value="Place Order" size=30 maxLength=20> </td> 
<td class='<%= classvalue %>'> <input type=text name="seqNumForPlaceOrder" id="seqNumForPlaceOrder" readonly  value="9"  size=1 maxLength=1> </td> 
<td class='<%= classvalue %>'> <input type="checkbox" name="placeOrderCheck" id="placeOrderCheck" disabled onclick="validatePlaceOrder(frmOrder)" > 
</td> 
</tr>
		<%
		}

/****************************************/
	} // end of else
	%>
</table>
<!--Hidden variables to store the values temporarily-->

<input type=hidden name="mode" id="mode" value='<%=mode%>'>
<input type=hidden name="install_yn" id="install_yn" value='<%=install_yn%>'>
<% install_yn=""; %>
<input type=hidden name="patient_class_desc" id="patient_class_desc" value="">
<input type=hidden name="patient_class" id="patient_class" value="">
<input type=hidden name="practitioner_id" id="practitioner_id" value="">
<input type="hidden" name="func_id" id="func_id" value="">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="exist_order" id="exist_order" value='<%= exist_order %>' >
<input type="hidden" name="new_order" id="new_order" value='<%= new_order %>' >
<!--<input type="hidden" name="Frequent_Orders" id="Frequent_Orders" value='<%=Frequent_Orders%>' > remove the comment if Frequent orders to be implemented and remove the next hidden line -->
<input type="hidden" name="Frequent_Orders" id="Frequent_Orders" value='N' >

<input type="hidden" name="addl_search" id="addl_search" value='<%= addl_search %>' >
<input type="hidden" name="tick_sheets" id="tick_sheets" value='<%= tick_sheets %>'>
<input type="hidden" name="order_sets" id="order_sets" value='<%= order_sets %>'>
<input type="hidden" name="image" id="image" value='<%= image %>'>
<input type="hidden" name="place_order" id="place_order" value='<%= place_order %>'>
<input type="hidden" name="sys_tab_name_existorder" id="sys_tab_name_existorder" value="existingOrders">
<input type="hidden" name="sys_tab_name_neworder" id="sys_tab_name_neworder" value="newOrders">
<input type="hidden" name="sys_tab_name_FrequentOrders" id="sys_tab_name_FrequentOrders" value="frequentOrders">
<input type="hidden" name="sys_tab_name_search" id="sys_tab_name_search" value="additionalSearch">
<input type="hidden" name="sys_tab_name_ticksheets" id="sys_tab_name_ticksheets" value="tickSheet">
<input type="hidden" name="sys_tab_name_ordersets" id="sys_tab_name_ordersets" value="careSet">
<input type="hidden" name="sys_tab_name_image" id="sys_tab_name_image" value="image">
<input type="hidden" name="sys_tab_name_placeorder" id="sys_tab_name_placeorder" value="placeOrder">
</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>


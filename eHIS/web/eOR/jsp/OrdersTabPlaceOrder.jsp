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


<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrdersTab.js"></script>
	<!--
	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>


<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<form name="frmOrder" id="frmOrder">
<table cellpadding=3 cellspacing=0 border=1 width="100%" align=center>
<tr align=center> <th class=' columnheader'><fmt:message key="eOR.TabName.label" bundle="${or_labels}"/></th>
<th class=' columnheader'><fmt:message key="eOR.UserDefinedTabName.label" bundle="${or_labels}"/></th>
<th class=' columnheader'><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></th> 
<th class=' columnheader'><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></th> 
<tr align=center>
<td class="QRYODD"  ><div class="label"><B> <fmt:message key="eOR.ExistingOrders.label" bundle="${or_labels}"/></div></td> 
<td class="QRYODD"> <input type=text name="tabNameForExistOrder" id="tabNameForExistOrder" maxLength=20  value="Existing Orders" size=30> </td> 
<td class="QRYODD"> <input type=text name="seqNumForExistOrder" id="seqNumForExistOrder" onblur="CheckForNumbers(seqNumForExistOrder)" value="1" size=1 maxLength=1> </td> 
<td class="QRYODD"> <input type="checkbox" name="existOrderCheck" id="existOrderCheck" checked onclick="validateExistOrder(frmOrder)" value="N" ondblclick="clearApplicable(existOrderCheck)"> </td> 
</tr>

<tr align=center>
<td class="QRYEVEN"  ><div class="label"><B> <fmt:message key="Common.NewOrders.label" bundle="${common_labels}"/></div></td>
<td class="QRYEVEN"> <input type=text name="tabNameForNewOrder" id="tabNameForNewOrder" maxLength=20  value="New Orders" size=30> </td> 
<td class="QRYEVEN"> <input type=text name="seqNumForNewOrder" id="seqNumForNewOrder" onblur="CheckForNumbers(seqNumForNewOrder)" value="2" size=1 maxLength=1> </td> 
<td class="QRYEVEN"> <input type="checkbox" name="newOrderCheck" id="newOrderCheck" checked onclick="validateNewOrder(frmOrder)" value="N" ondblclick="clearApplicable(newOrderCheck)"> </td> 
</tr>



<!--<tr align=center>
<td class="QRYODD" align=right ><div class="label"> Frequent Orders </div></td> 
<td class="QRYODD"> <input type=text name="tabNameForFrequentOrders" id="tabNameForFrequentOrders" maxLength=20  value="Frequent Orders " size=30> </td> 
<td class="QRYODD"> <input type=text name="seqNumForFrequentOrders" id="seqNumForFrequentOrders" onblur="CheckForNumbers(seqNumForFrequentOrders)" value="1" size=1 maxLength=1> </td> 
<td class="QRYODD"> <input type="checkbox" name="FrequentOrdersCheck" id="FrequentOrdersCheck" checked onclick="validateFrequentOrders(frmOrder)" value="N" ondblclick="clearApplicable(FrequentOrdersCheck)"> </td> 
</tr>
 -->
<tr align=center>
<td class="QRYODD"  ><div class="label"><fmt:message key="eOR.AdditionalSearch.label" bundle="${or_labels}"/></div></td>  
<td class="QRYODD"> <input type=text name="tabNameForSearch" id="tabNameForSearch" maxLength=20  value="Additional Search" size=30> </td> 
<td class="QRYODD"> <input type=text name="seqNumForSearch" id="seqNumForSearch" onblur="CheckForNumbers(seqNumForSearch)" value="2" size=1 maxLength=1> </td> 
<td class="QRYODD"> <input type="checkbox" name="addnlSearchCheck" id="addnlSearchCheck" checked onclick="validateAddnlSearch(frmOrder)" value="N" ondblclick="clearApplicable(addnlSearchCheck)"> </td> 
</tr>
<tr align=center>
<td class="QRYEVEN"  class="label"> <div class="label"> <fmt:message key="eOR.TickSheets.label" bundle="${or_labels}"/></div></td>
<td class="QRYEVEN" > <input type=text name="tabNameForTickSheet" id="tabNameForTickSheet" size=30 maxLength=20  value="Tick Sheets"> </td> 
<td class="QRYEVEN" > <input type=text name="seqNumForTickSheet" id="seqNumForTickSheet"  onkeypress="CheckForNumbers(seqNumForTickSheet)" value="3" size=1 maxLength=1> </td> 
<td class="QRYEVEN"> <input type="checkbox" name="tickSheetCheck" id="tickSheetCheck" checked onclick="validateTickSheet(frmOrder)" value="N" ondblclick="clearApplicable(tickSheetCheck)"> </td> 
</tr>
<tr align=center>
<td class="QRYODD"  class="label"><div class="label"> <fmt:message key="eOR.OrderSets.label" bundle="${or_labels}"/></div></td>
<td class="QRYODD" > <input type=text name="tabNameForOrderSets" id="tabNameForOrderSets" size=30 maxLength=20  value="Order Sets"> </td> 
<td class="QRYODD" > <input type=text name="seqNumForOrderSets" id="seqNumForOrderSets" onkeypress="CheckForNumbers(seqNumForOrderSets)" value="4" size=1 maxLength=1> </td> 
<td class="QRYODD"> <input type="checkbox" name="orderSetsCheck" id="orderSetsCheck" checked onclick="validateOrderSets(frmOrder)" value="N" ondblclick="clearApplicable(orderSetsCheck)"> </td> 
</tr>
<tr align=center>
<td class="QRYEVEN"  class="label"><div class="label"><fmt:message key="Common.Image.label" bundle="${common_labels}"/></div></td> 
<td class="QRYEVEN" > <input type=text name="tabNameForImage" id="tabNameForImage" size=30 maxLength=20  value="Image"> </td> 
<td class="QRYEVEN" > <input type=text name="seqNumForImage" id="seqNumForImage" onkeypress="CheckForNumbers(seqNumForImage)" value="5" size=1 maxLength=1> </td> 
<td class="QRYEVEN"> <input type="checkbox" name="imageCheck" id="imageCheck" checked onclick="validateImage(frmOrder)"  value="N" ondblclick="clearApplicable(imageCheck)"> </td> 
</tr>
<tr align=center>
<td class="QRYODD"  class="label"><div class="label"><fmt:message key="Common.PlaceOrder.label" bundle="${common_labels}"/></div></td>
<td class="QRYODD" > <input type=text name="tabNameForPlaceOrder" id="tabNameForPlaceOrder" size=30 maxLength=20  value="Place Order"> </td> 
<td class="QRYODD" > <input type=text name="seqNumForPlaceOrder" id="seqNumForPlaceOrder" readonly value="9" size=1 maxLength=1 > </td>
<td class="QRYODD"> <input type="checkbox" name="placeOrderCheck" id="placeOrderCheck" checked onclick="validatePlaceOrder(frmOrder)"  disabled value="N" ondblclick="clearApplicable(placeOrderCheck)"> </td> 
</tr>
</table>
<input type="hidden" name="exist_order" id="exist_order" value="">
<input type="hidden" name="new_order" id="new_order" value="">
<input type="hidden" name="Frequent_Orders" id="Frequent_Orders" value="">
<input type="hidden" name="addl_search" id="addl_search" value="">
<input type="hidden" name="tick_sheets" id="tick_sheets" value="">
<input type="hidden" name="order_sets" id="order_sets" value="">
<input type="hidden" name="image" id="image" value="">
<input type=hidden name="mode" id="mode" value="1">
</form>
</body>
</html>


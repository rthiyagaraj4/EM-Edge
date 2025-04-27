<!DOCTYPE html>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="eST.PhysicalInventoryEntryBean,webbeans.eCommon.*,"
contentType="text/html;charset=UTF-8" %>
<html>
	<head>
	<%
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/PhysicalInventoryEntry.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<body onLoad='FocusFirstElement();'>
	<%

		String bean_id = "PhysicalInventoryEntryBean";
		String bean_name = "eST.PhysicalInventoryEntryBean";
		
		String store_code =	request.getParameter("store_code");
		String item_code = request.getParameter("item_code");
		String phy_inv_id = request.getParameter("phy_inv_id");
		String index = request.getParameter("index");
		HashMap display_batch_lookup_hash = new HashMap();
		String display_batch_lookup = "";
		//String display_batch_lookup_grn = "";
		String display_batch_lookup_all = "";
		String display_header="";
		String checked="";
		String disabled ="";
		String readonly ="";
		// pmd 29/01/05
//		String disabled = "disabled";
		PhysicalInventoryEntryBean bean = (PhysicalInventoryEntryBean)getBeanObject( bean_id, bean_name,request);  
		//bean.clear();
		bean.setLanguageId(locale);
		bean.setStore_code(store_code);
		bean.setItem_code(item_code);
		display_batch_lookup_hash=bean.getBatch_lookup();
		if(display_batch_lookup_hash.size()==0){
		display_batch_lookup_hash=bean.display_batch_lookup();
		}
		//display_batch_lookup_hash=bean.display_batch_lookup();
	
		 display_batch_lookup = bean.checkForNull((String)display_batch_lookup_hash.get("PHY_INV_BATCH_LOOKUP_ENTRY_YN"),"N");
		 display_batch_lookup_all = bean.checkForNull((String)display_batch_lookup_hash.get("APPL_BATCHES_IN_PHY_INV_ENTRY"),"ALL");

		if((display_batch_lookup.equalsIgnoreCase("Y")) && (display_batch_lookup_all.equalsIgnoreCase("GRN")))
		{ 
			display_header="GRN";
		    checked = "";
		    disabled ="disabled"; 
			readonly = "readonly";
		}
		else if((display_batch_lookup.equalsIgnoreCase("Y")) && (display_batch_lookup_all.equalsIgnoreCase("ALL")))
			{
            display_header="All";
			 checked="";
			 disabled ="disabled";
			 readonly = "readonly";
			}
			//Added By Sakti against CRF# - RUT-CRF-0081 icn#34757
			else if((display_batch_lookup.equalsIgnoreCase("B")) && (display_batch_lookup_all.equalsIgnoreCase("ALL")))
			{
            display_header="";
			 checked="checked";
			 disabled ="";
			 readonly = "";
			}
		//Added ends
			else
			{
			display_header="New";
			 checked="checked";
			 disabled ="";
			 readonly = "";
			}
/**
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - 15496
 * @Desc -  Decimal handling in item based.
 */
			int no_of_decimals =0 ;
			String dec_allowed_yn = bean.getAllowDecimalsYN(item_code);
			if(dec_allowed_yn.equals("Y")){
			no_of_decimals = bean.getNoOfDecimals();
			}
	%>
		<form name="formPhysicalInventoryEntryApplyAdd" id="formPhysicalInventoryEntryApplyAdd" target = "framePhysicalInventoryEntryApplyAdded" action = "PhysicalInventoryEntryApplyValues.jsp"  onreset="FocusFirstElement();">
			<table border="0" cellpadding="0" cellspacing="0" width='100%'>
			<th align="left"><%=display_header%> <fmt:message key="Common.BatchDetails.label" bundle="${common_labels}"/></th>
			</table>
			<table border="0" cellpadding="2" cellspacing="0" width='100%' height='75%' align=center >
				<tr>
					<td  class="LABEL"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
					<td class="fields" nowrap><input name="batch_id" id="batch_id" size=18 maxlength=20 <%=readonly%>   value="" onKeyPress="return  CheckForSpecialCharsForAllCase(event);" >
					<% if(display_batch_lookup.equalsIgnoreCase("Y") || display_batch_lookup.equalsIgnoreCase("B")){ %>
					<input type=button name="batch_search_from" id="batch_search_from" class="button" onclick="callBatchSearch();" value='?'><% }%><%=bean.getImage("M")%></td>
					<td  class="LABEL"><fmt:message key="eST.ItemQuantity.label" bundle="${st_labels}"/></td>
					<td class="fields"><input class="NUMBER" name="item_qty" id="item_qty" maxLength=12 size=12 
					value="" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onblur="CheckQuantity1(this);"><%=bean.getImage("M")%></td>
					<!-- Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 Beg -->
					<%if(bean.getAllow_eqvl_uom().equals("Y")){ %>
					<td  class="LABEL" width="90"><fmt:message key="eST.UOM.label" bundle="${st_labels}"/></td>
					<td class="fields"><select name='uom_code' id='uom_code' onchange="getConvFact('<%=item_code%>',this.value,0);"><%=bean.get_uom_code_List(item_code,"")%></select></td>
					<input type="hidden" name="conv_fact_0" id="conv_fact_0" value='<%=bean.getConv_fact()%>'>
					<%}else{ %>
					<td  class="LABEL" width="120"><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></td>
					<td class="fields" width="150"><select name="bin_loc_code" id="bin_loc_code">
					<%=bean.getSTITBin_location_code_List(store_code,item_code,"",locale)%>
					</select><%=bean.getImage("M")%></td>
					<%} %>
					<!-- //Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 End -->
				</tr>
				<tr>
					<!-- Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 Beg -->
					<%if(bean.getAllow_eqvl_uom().equals("Y")){ %>
					<td  class="LABEL" width="140"><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></td>
					<td class="fields" width="170"><select name="bin_loc_code" id="bin_loc_code">
					<%=bean.getSTITBin_location_code_List(store_code,item_code,"",locale)%>
					</select><%=bean.getImage("M")%></td>
					<%} %>
					<!-- //Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 End -->
					<td  class="LABEL" width="140"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
					<td class="fields" width="160"><input name="expiry_date" id="expiry_date" maxLength='10' size='10' value="" onblur="return CheckDate(expiry_date);"<%=disabled%>>
					<% if(display_batch_lookup.equalsIgnoreCase("N") || display_batch_lookup.equalsIgnoreCase("B")){ %>
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('expiry_date');" ></img>
					<%=bean.getImage("M")%></td><%}%>
					<td  class="LABEL" colspan=1 width=50><fmt:message key="Common.TradeID.label" bundle="${common_labels}"/></td>
					<td  class="fields" nowrap><select name="trade_id" id="trade_id" >
					<%=bean.getTradeId()%>
					<% if(display_batch_lookup.equalsIgnoreCase("N") || display_batch_lookup.equalsIgnoreCase("B")){ %>
					</select><%=bean.getImage("M")%><% }%></td>
					<td  class="LABEL" width="50" nowrap><fmt:message key="eST.NewBatch.label" bundle="${st_labels}"/>
					<input type= "checkbox" name="new_batch_YN" id="new_batch_YN" <%=checked%> disabled>
					</td>
					<td  class="fields" colspan=1 nowrap>&nbsp;<input class='button' type='button' name='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' id='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>'  onClick="addToList();" class="label"><input class='button' type='button' name='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' id='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  onClick="clearAll();" class="label"></td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
			<input type="hidden" name="mode" id="mode" value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>'>
			<input type="hidden" name="key_modify" id="key_modify" value="">
			<input type="hidden" name="modify" id="modify" value="no">
			<input type="hidden" name="fromDB" id="fromDB" value="no">
			<input type="hidden" name="index" id="index" value="<%=index%>">
			<input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
			<input type="hidden" name="phy_inv_id" id="phy_inv_id" value="<%=phy_inv_id%>">
           <input type="hidden" name="display_batch_lookup" id="display_batch_lookup" value='<%=display_batch_lookup%>'>
		   <input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=dec_allowed_yn%>">
		   <input type="hidden" name="allow_eqvl_uom" id="allow_eqvl_uom" value='<%=bean.getAllow_eqvl_uom()%>'>
	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>


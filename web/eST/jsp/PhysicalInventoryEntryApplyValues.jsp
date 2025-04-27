<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
20/02/2017		IN0063027		Badmavathi B					GHL-CRF-0413.7 - US005 - Barcode search
15/11/2017		INC065695		Shazana Hasan					MMS-DM-CRF-0112 -US003 - Barcode search
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eST.PhysicalInventoryEntryBean" contentType="text/html;charset=UTF-8"%><html>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/PhysicalInventoryEntry.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id = "PhysicalInventoryEntryBean";
		String bean_name = "eST.PhysicalInventoryEntryBean";
		int index_barcode =0;//Added for GHL-CRF-0413.7
	// pmd 29/01/05
//		String mode = request.getParameter("mode");
		PhysicalInventoryEntryBean bean = (PhysicalInventoryEntryBean) getBeanObject( bean_id, bean_name,request);  
		bean.setLanguageId(locale);
		int i = 0;
		HashMap display_batch_lookup_hash = new HashMap();
		String display_batch_lookup = "";
		display_batch_lookup_hash=bean.getBatch_lookup();
		if(display_batch_lookup_hash.size()==0){
		display_batch_lookup_hash=bean.display_batch_lookup();
		}
        display_batch_lookup = bean.checkForNull((String)display_batch_lookup_hash.get("PHY_INV_BATCH_LOOKUP_ENTRY_YN"),"N");
        //Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 Beg
        String allow_eqvl_uom = bean.checkForNull((String)((HashMap)bean.fetchRecord(bean.getStRepositoryValue("SQL_ALLOW_EQVL_UOMS_PHY_INV_ENTRY_YN"),bean.getLoginFacilityId())).get("ALLOW_EQVL_UOMS_PHY_INV_ENTRY"),"N");
        bean.setAllow_eqvl_uom(allow_eqvl_uom);
      //Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 end
	%>
	<body >
		<form name='formPhyInvEntryList' id='formPhyInvEntryList'>
			<%
				String className;
				java.util.ArrayList result = new java.util.ArrayList();
				java.util.ArrayList modResult = new java.util.ArrayList();
				java.util.HashMap showdataList = new java.util.HashMap();
			%>
			<%
					String store_code =	request.getParameter("store_code");
					String item_code = request.getParameter("item_code");
					String phy_inv_id = request.getParameter("phy_inv_id").trim();
					String index = request.getParameter("index");
					//Added for GHL-CRF-0413.7 starts
					String barcode = bean.checkForNull(bean.getBarcode());
					HashMap batchRecords = bean.fetchRecord("SELECT BATCH_ID,BIN_LOCATION_CODE,to_char(expiry_date_or_receipt_date,'dd/mm/yyyy') EXPIRY_DATE_OR_RECEIPT_DATE FROM ST_ITEM_BATCH WHERE BARCODE_ID =? AND STORE_CODE=? AND ITEM_CODE=?", new String[]{barcode,store_code,item_code});
					String batch_id1 = bean.checkForNull((String)batchRecords.get("BATCH_ID"));
					String bin_loc_code1 = bean.checkForNull((String)batchRecords.get("BIN_LOCATION_CODE"));
					String expiry_date1 = bean.checkForNull((String)batchRecords.get("EXPIRY_DATE_OR_RECEIPT_DATE"));
					/*Added by Shazana for INC065695 MMS-DM-CRF-0112 START*/
					double tmp_conv=bean.getConvFactTemp(item_code,store_code); 
					System.out.println("tmp_conv in : "+tmp_conv);
					/*Added by Shazana for INC065695 MMS-DM-CRF-0112 START*/
					
					//Added for GHL-CRF-0413.7 ends
/**
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - 15496
 * @Desc -  Decimal handling in item based.
 */
					int no_of_decimals = bean.getNoOfDecimals();
					String dec_allowed_yn =bean.getAllowDecimalsYN(item_code);
					if(dec_allowed_yn.equals("N")){
						no_of_decimals = 0;
						}
					
					ArrayList alParam = new ArrayList();
					alParam.add(item_code);
					alParam.add(store_code);
					alParam.add(phy_inv_id);
					String entry_completed_yn = bean.checkForNull((String)((HashMap)bean.fetchRecord("SELECT DISTINCT ENTRY_COMPLETED_YN FROM ST_PHY_INV_DTL WHERE ITEM_CODE = ? AND STORE_CODE = ? AND PHY_INV_ID = ?",alParam)).get("ENTRY_COMPLETED_YN"),"N");
			if (request.getParameter("fromDB").equals("yes"))
				{
					bean.setPhy_inv_id(phy_inv_id);
					bean.setItem_code(item_code);
					bean.setStore_code(store_code);
					bean.clear_values();
				}
			else
			{
			if (request.getParameter("modify").equals("no"))
			{
				String batch_id = CommonBean.checkForNull(request.getParameter("batch_id"),"");
				String item_qty = CommonBean.checkForNull(request.getParameter("item_qty"),"");
				String bin_loc_code = CommonBean.checkForNull(request.getParameter("bin_loc_code"),"");
				String expiry_date = CommonBean.checkForNull(request.getParameter("expiry_date"),"");
				String trade_id = CommonBean.checkForNull(request.getParameter("trade_id"),"");
				String new_batch_YN = CommonBean.checkForNull(request.getParameter("new_batch_YN"),"N");

				String key_to_values = batch_id + "~" + item_qty + "~"+ bin_loc_code + "~"+ expiry_date+ "~" + trade_id+"~"+new_batch_YN;
				bean.add_To_values(key_to_values);
				}
				//bean.clear_values();
			}
				modResult	=	new ArrayList();
				modResult	=	bean.getModResult(Integer.parseInt(index));
				if(modResult.size()>0){
					result	=	new ArrayList();
					result	=	modResult;
				}
				else{
					result	=	new ArrayList();
					result = bean.loadData1(Integer.parseInt(index));
				}
%>		<input type="hidden" value="<%=result.size()%>" name="total_rec">
		<input type="hidden" name="allow_eqvl_uom" id="allow_eqvl_uom" value='<%=allow_eqvl_uom%>'><!--Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 End -->
		<%
			if (result.size() > 0)
			{
				HashMap showdataList_temp = (java.util.HashMap)result.get(0);
				if(((String)showdataList_temp.get("ENTRY_COMPLETED_YN")).equals("Y")){
				 entry_completed_yn="Y";
				}

			%>
		<table border='0' cellpadding='0' cellspacing='1' width = "100%">
			<th align="left" width="70%">&nbsp;&nbsp;</th>
			<th align="left">Entry Completed &nbsp;&nbsp;<input type="checkbox" name="entry_completed_yn" id="entry_completed_yn" value="<%=entry_completed_yn%>" onClick="checkyn(this);" <%=bean.getChecked(entry_completed_yn)%>></th>

		</table>
		<table name ="ListValue" id="ListValue" border='1' cellpadding='0' cellspacing='0' align=center>
			</tr>
		<tr>
			<th></th>
			<th COLSPAN='1'  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></b></font></th>
			<th COLSPAN='1'  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.ItemQuantity.label" bundle="${st_labels}"/></b></font></th>
			<!--Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 Beg -->
			<%if(allow_eqvl_uom.equals("Y")){ %>
			<th COLSPAN='1'  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.UOM.label" bundle="${st_labels}"/></b></font></th>
			<th COLSPAN='1'  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.BaseUOMQty.label" bundle="${st_labels}"/></b></font></th>
			<%}%>
			<!--Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 End -->
			<th COLSPAN='1'  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.BaseUOM.label" bundle="${st_labels}"/></b></font></th><!--Added by suresh.r on 29-07-2014 against MMS-SCF-0390  -->
			<th COLSPAN='1'  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></b></font></th>
			<th COLSPAN='1'  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></b></font></th>
			<th COLSPAN='1'  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></b></font></th>
		<tr>
	
		<%
			}
		String bin_desc =	"";
		String bin_code	=	"";
		String trade_id	=	"";
		String chkyn	=	"";
		String batch_qty=	"";
		String committed_qty =	"";
		String qty_on_hand = "";
				for(i=0;i<result.size();i++)
				{
					chkyn	=	"";
				showdataList = (java.util.HashMap)result.get(i);
				className=(i%2==0)?"OAQRYEVEN":"OAQRYODD";
/**
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - 15496
 * @Desc -  Decimal handling in item based.dec_allowed_yn 
 */
				batch_qty=CommonBean.checkForNull((String)showdataList.get("ITEM_QTY"),"");
				
				if(batch_qty.length()!=0)
				if((bean.checkForNull((String)showdataList.get("ALLOW_DECIMALS_YN"))).equals("Y")){
					batch_qty=bean.setNumber(batch_qty,no_of_decimals);
				}else{
					batch_qty=bean.setNumber(batch_qty,0);
				}
			//Added for GHL-CRF-0413.7 starts
				if(bean.isSite_spec_yn()){
					if(batch_id1.length()!=0){
						if(( batch_id1.equals((String)showdataList.get("BATCH_ID"))) && (bin_loc_code1.equals((String)showdataList.get("BIN_LOC_CODE"))) && (expiry_date1.equals((String)showdataList.get("EXPIRY_DATE")))){
							className ="STLIGHTPINK";
							int batch_qty_temp = Integer.parseInt(bean.checkForNull(batch_qty, "0"));
							/*Added by Shazana for INC065695 MMS-DM-CRF-0112 START*/
							System.out.println("tmp_conv: "+tmp_conv);
							int b1=(int)tmp_conv;
							System.out.println("b1: "+b1);
							
							if(batch_qty_temp==0 && tmp_conv!=1)
							{
								batch_qty_temp++;	
							}
							if(batch_qty_temp==1 && tmp_conv!=1)
							{
								batch_qty_temp=batch_qty_temp*b1;
								
							}
							else if(tmp_conv==1)
							{
								batch_qty_temp=batch_qty_temp+1;
							}
							else
							{
								batch_qty_temp=batch_qty_temp+b1;
							}
							/*Added by Shazana for INC065695 MMS-DM-CRF-0112 END*/
							batch_qty = ""+batch_qty_temp;
							System.out.println("batch_qty: "+batch_qty);
							index_barcode = i;
						}
					}
				}
			//Added for GHL-CRF-0413.7 ends
				%>
		<tr><%
				if((bean.checkForNull((String)showdataList.get("CHECK_YN"),"N")).equals("Y"))
					chkyn="checked";
				if(((String)showdataList.get("NEW_BATCH_YN")).equals("Y")){
			%>
			<td><img src="../images\NewBatch.gif" title='<fmt:message key="eST.NewBatch.label" bundle="${st_labels}"/>' height=10 ></td>
			<%}else{%> 
			<td onclick="disableClick(event);" onmouseover="changeCursor(this);"></td>
			<%}%>
			<input type="hidden" name="check_yn_<%=i%>" id="check_yn_<%=i%>" value="Y">
			<td class="<%=className%>" width='180'>
			<%=CommonBean.checkForNull((String)showdataList.get("BATCH_ID"),"&nbsp;")%></td>
			<td class="<%=className%>"   width='80' class="NUMBER" onclick="disableClick(event);">
			<input type=text size=12 maxlength=12 class="NUMBER" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" name = "item_qty_<%=i%>" id = "item_qty_<%=i%>"  onblur = "checkCommittedQty(<%=i%>,<%=index%>, 'QTY');<%if(allow_eqvl_uom.equals("Y")){ %>set_Base_UOM_Qty(<%=i%>);<%} %>" value="<%=batch_qty%>" onblur="checkQuantity('<%=i%>');"></td><!--Added set_Base_UOM_Qty by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 End -->
			<!--Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 Beg -->
			<%if(allow_eqvl_uom.equals("Y")){ %>
			<td class="<%=className%>"   width='180' onclick="disableClick(event);"><select name='uom_code_<%=i%>' id='uom_code_<%=i%>' onchange="getConvFact('<%=item_code%>',this.value,<%=i%>);set_Base_UOM_Qty(<%=i%>);checkCommittedQty(<%=i%>,<%=index%>,'UOM');">
			<%=bean.get_uom_code_List(item_code,bean.checkForNull((String)showdataList.get("PHY_UOM_CODE")))%>
			</select></td>
			<input type="hidden" name="conv_fact_<%=i%>" id="conv_fact_<%=i%>" value='<%=bean.getConv_fact()%>'>
			<td class="<%=className%>"   width='180' onclick="disableClick(event);"><label id="id_base_uom_qty_<%=i%>" style="border-width: 1;text-align: right;" ></label></td>
			<%out.println("<script>set_Base_UOM_Qty("+i+");</script>");} %>
			<!--Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 End -->
			<td class="<%=className%>"   width='180' onclick="disableClick(event);"><%=(String)showdataList.get("GEN_UOM_DESC")%></td><!--Added by suresh.r on 29-07-2014 against MMS-SCF-0390  -->
			<%
			bin_code=CommonBean.checkForNull((String)showdataList.get("BIN_LOC_CODE"));
			trade_id=CommonBean.checkForNull((String)showdataList.get("TRADE_ID"));
			bean.setBin_code_desc(bin_code);
			bin_desc= bean.getBinlocation_desc();
			%>
			<input type="hidden" name="bin_code_<%=i%>" id="bin_code_<%=i%>" value='<%=bin_code%>'>
 			<input type="hidden" name="new_batch_YN_<%=i%>" id="new_batch_YN_<%=i%>" value='<%=(String)showdataList.get("NEW_BATCH_YN")%>'>
 			<input type="hidden" name="batch_id_<%=i%>" id="batch_id_<%=i%>" value='<%=(String)showdataList.get("BATCH_ID")%>'>
			<input type="hidden" name="trade_id_<%=i%>" id="trade_id_<%=i%>" value='<%=(String)showdataList.get("TRADE_ID")%>'> 
			<input type="hidden" name="genuom_id_<%=i%>" id="genuom_id_<%=i%>" value='<%=(String)showdataList.get("GEN_UOM_DESC")%>'><!--Added by suresh.r on 29-07-2014 against MMS-SCF-0390  --> 
 		<td class="<%=className%>"   width='180' onclick="disableClick(event);" ><!-- added disabled against ML-BRU-SCF-1683-->
				<select name="bin_loc_code_<%=i%>" id="bin_loc_code_<%=i%>"  onblur="checkQuantity('<%=i%>');" disabled>
						<% if(display_batch_lookup.equalsIgnoreCase("Y")) {%>
						<option value=<%=bin_code%>> <%=bin_desc%></option></select>
						<% }else{ %>
						<%=bean.getSTITBin_location_code_List(store_code,item_code,bin_code,locale)%>
				</select><%=bean.getImage("M")%><%}%>
			</td>
		<%
			if(((String)showdataList.get("NEW_BATCH_YN")).equals("Y")){
		%>
				<td class="fields" width='250'>&nbsp;<input name="expiry_date_<%=i%>" id="expiry_date_<%=i%>" maxLength='10' size='10' value="<%=CommonBean.checkForNull((String)showdataList.get("EXPIRY_DATE"),"")%>" onblur="checkDate1(expiry_date_<%=i%>);return CheckDate(expiry_date_<%=i%>);">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('expiry_date_<%=i%>');" ></img><%=bean.getImage("M")%></td>
		<%}else{%>
				<td class="<%=className%>"   width='200' onclick="disableClick(event);">
				<%=CommonBean.checkForNull((String)showdataList.get("EXPIRY_DATE"),"&nbsp;")%></td>
 				<input type="hidden" name="expiry_date_<%=i%>" id="expiry_date_<%=i%>" value='<%=(String)showdataList.get("EXPIRY_DATE")%>'>
		<%}%>
			<td class="<%=className%>"   width='180' onclick="disableClick(event);">
					<%=bean.getTradeDesc(trade_id)%>
			</td>
		</tr>
			<%	
			String _batch_id	=	(String)showdataList.get("BATCH_ID");
			String _expiry_date =	(String)showdataList.get("EXPIRY_DATE");


						
			committed_qty = 	(String)bean.getBatchCommittedQty(item_code ,store_code,_batch_id,bin_code,_expiry_date).get("COMMITTED_QTY");
			qty_on_hand = 	(String)bean.getBatchCommittedQty(item_code ,store_code,_batch_id,bin_code,_expiry_date).get("QTY_ON_HAND");
			

			%>
			<input type="hidden" name="committed_qty_<%=i%>" id="committed_qty_<%=i%>" value='<%=committed_qty%>'>
			<input type="hidden" name="qty_on_hand_<%=i%>" id="qty_on_hand_<%=i%>" value='<%=qty_on_hand%>'>
		<% } %>	
			<input type="hidden" name="item_code" id="item_code" value='<%=item_code%>'>
			<input type="hidden" name="total_records" id="total_records" value='<%=i%>'>
			 <input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=dec_allowed_yn%>">
			 <input type="hidden"		name="index_barcode" id="index_barcode"			 value="<%=index_barcode%>"><!-- Added for GHL-CRF-0413.7 -->
			
		</form>
		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
	<%bean.setBarcode(""); //Added for GHL-CRF-0413.7%>
	<script>
		parent.frames[1].location.href	=	"../../eST/jsp/PhysicalInventoryEntryApplyAdd.jsp?<%=request.getQueryString()%>";
	</script>
	<%
		if(!(result.size()>0))
	%><script>
		//alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		alert("No Batch Details Available For The Selected Item");
	</script>
</html>


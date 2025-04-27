<!DOCTYPE html>

<%@ page import="eST.BatchSearchGoodsReturnToVendorBean, eST.Common.*,eST.*,java.util.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/GoodsReturnToVendor.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>	
	<%
        GoodsReturnToVendorBean bean = (GoodsReturnToVendorBean) getBeanObject("goodsReturnToVendorBean","eST.GoodsReturnToVendorBean",request);
		bean.setLanguageId(locale);
		eST.Common.StDuoHeaderBean beanHdr = (eST.Common.StDuoHeaderBean) getBeanObject("stDuoHeaderBean","eST.Common.StDuoHeaderBean",request);
		beanHdr.setLanguageId(locale);
		int i	=0;
		String EXPIRY_DATE_OR_RECEIPT_DATE="";
		String index=bean.checkForNull(request.getParameter("index"),"-1");
		String function = bean.checkForNull(request.getParameter("function"));
		String item_code = bean.checkForNull(request.getParameter("item_code"));
		String expiry_yn=bean.getExpYN(item_code);
		ArrayList alBatchRecords = null;
		String allow_deci_yn = "";
        String no_deci    = "";
		allow_deci_yn        =       bean.checkForNull(bean.getAllowDecimalsYN(item_code),"N");
            if(allow_deci_yn.equals("Y"))
			no_deci              =       ""+bean.checkForNull(""+bean.getNoOfDecimals(),"0");
			else
            no_deci   = "0";
		HashMap hmBatchRecord = new HashMap();

		String className =	"";
		if(function.equals("modify"))	{
			alBatchRecords =(ArrayList)bean.getExpRecords_temp(Integer.parseInt(index)); 
          if(alBatchRecords==null)
			  alBatchRecords =(ArrayList)bean.getExpRecords(Integer.parseInt(index)); 
			
		}else{
			BatchSearchGoodsReturnToVendorBean bean2 = (BatchSearchGoodsReturnToVendorBean) getBeanObject("BatchSearchGoodsReturnToVendorBean","eST.BatchSearchGoodsReturnToVendorBean", request );
			bean2.setLanguageId(locale);
			alBatchRecords = bean2.getSelectedList();
			putObjectInBean("BatchSearchGoodsReturnToVendorBean",bean2,request);
		 //bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
		}
    	
		bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
		
	%>

	<body ><%//alBatchRecords%>
		<form name='formGoodsReturnToVendorListDetail' id='formGoodsReturnToVendorListDetail'>
			<table name ="tblItemList" border='1' width='100%' cellpadding='0' cellspacing='0'  align=center>
 			<tr>
			<%if(expiry_yn.equals("Y")){%>
				<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
				<%}else{%>
				<th><fmt:message key="Common.receiptdate.label" bundle="${common_labels}"/></th>
				<%}%>
				<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.PurchaseUOM.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.RTVQuantity.label" bundle="${st_labels}"/></th>
			</tr>
			<%
				for(i=0;i<alBatchRecords.size();i++){
				hmBatchRecord=(java.util.HashMap)alBatchRecords.get(i);
				className	=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
			     EXPIRY_DATE_OR_RECEIPT_DATE = (String)hmBatchRecord.get("EXPIRY_DATE_OR_RECEIPT_DATE");
				if(!locale.equals("en"))
					 EXPIRY_DATE_OR_RECEIPT_DATE  = com.ehis.util.DateUtils.convertDate(EXPIRY_DATE_OR_RECEIPT_DATE,"DMY","en",locale);
				else
					EXPIRY_DATE_OR_RECEIPT_DATE =	EXPIRY_DATE_OR_RECEIPT_DATE;

			%>
			<tr>
				<td class="<%=className%>" nowrap ><%=EXPIRY_DATE_OR_RECEIPT_DATE%></td>
				<td class="<%=className%>" nowrap  name="batch_id_<%=i%>"><%=hmBatchRecord.get("BATCH_ID")%></td>
				<td class="<%=className%>" nowrap ><%=hmBatchRecord.get("TRADE_NAME")%></td>
				<td class="<%=className%>" nowrap ><%=hmBatchRecord.get("BIN_LOCATION_DESC")%></td>
				<td class="<%=className%>" nowrap ><%=hmBatchRecord.get("SHORT_DESC")%></td>
				<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Available Qty.				
					-->
				<td class="<%=className%>" nowrap style="TEXT-ALIGN:right" ><%=bean.setNumber((String)hmBatchRecord.get("AVAIL_QTY"),Integer.parseInt(no_deci))%>&nbsp;</td>
				<!-- 		
				* @Name - Priya
				* @Date - 10/02/2010
				* @Inc# - 19092 
				* @Desc - No.of Decimals is passed to isValidNumber function and in onblur  checkdoubleformat is called.			
				-->
				<td class="<%=className%>" nowrap ><input type='text'  name="item_qty_<%=i%>" id="item_qty_<%=i%>"  size=12 maxlength=12 style="text-align:right" class="STSMALL" value="<%=(function.equals("modify"))?bean.setNumber((String)hmBatchRecord.get("RTV_ITEM_QTY"),Integer.parseInt(no_deci)):""%>" onKeyPress="return isValidNumber(this,event,7,<%=Integer.parseInt(no_deci)%>);" onBlur="checkDoubleFormat(this);checkBatchQty(this,available_qty_<%=i%>.value);"></td>
			</tr>
				<input type="hidden" name="available_qty_<%=i%>" id="available_qty_<%=i%>" value="<%=hmBatchRecord.get("AVAIL_QTY")%>">
				<input type="hidden" name="grn_unit_cost_in_pur_uom_<%=i%>" id="grn_unit_cost_in_pur_uom_<%=i%>" value="<%=hmBatchRecord.get("GRN_UNIT_COST_IN_PUR_UOM")%>">
				<input type="hidden" name="grn_doc_srl_no<%=i%>" id="grn_doc_srl_no<%=i%>" value="<%=hmBatchRecord.get("GRN_DOC_SRL_NO")%>">
				<input type="hidden" name="grn_doc_date<%=i%>" id="grn_doc_date<%=i%>" value="<%=hmBatchRecord.get("GRN_DOC_DATE")%>">
	     <% }  %>

			<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
			<input type="hidden" name="pur_uom_conv" id="pur_uom_conv" value="<%=bean.checkForNull((String)hmBatchRecord.get("PUR_UOM_CONV"),"1")%>">
			<input type='hidden' name='allow_deci_yn' id='allow_deci_yn'		value="<%=allow_deci_yn%>">
	 <input type='hidden' name='no_deci' id='no_deci'		value="<%=no_deci%>">
    </form>
	<%
putObjectInBean("goodsReturnToVendorBean",bean,request);
putObjectInBean("stDuoHeaderBean",beanHdr,request);
%>
</body>
</html>


<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import=" eST.StockTransferBean,eST.Common.StHeaderBean,java.util.ArrayList,java.util.HashMap,webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

	<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/StockTransfer.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%

	String bean_id				=    "stockTransferBean";
	String bean_name			=    "eST.StockTransferBean";


	StockTransferBean bean = (StockTransferBean) getBeanObject( "stockTransferBean","eST.StockTransferBean", request  );
	bean.setLanguageId(locale);
	StHeaderBean beanHdr = (StHeaderBean)getBeanObject( "stHeaderBean", "eST.Common.StHeaderBean",request );
	beanHdr.setLanguageId(locale);


	
	String stButtonLegend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String index=bean.checkForNull(request.getParameter("index"),"-1");
	String doc_srl_no=bean.checkForNull(request.getParameter("doc_srl_no"),"-1");

	String item_code		=	"";
	String item_desc		=	"";
	String uom				=	"";
	String uom_code			=	"";
	String stock_available	=	"";
	String item_unit_cost	=	"";
	String item_qty			=	"";
	String item_sal_value	=	"";
	//String remarks			=	"";
	String expiry_yn		=	"";
	String codeDisabled		=	"";
	String stock_item_yn	=	"";
	String store_code		=   "";
	String frm_store_qty_on_hand		= "";
	String frm_store_min_stk_level		= "";
	String frm_store_max_stk_level		= "";
	String frm_store_reorder_level		= "";
	String frm_store_uom_desc			= "";
	String to_store_qty_on_hand			= "";
	String to_store_min_stk_level		= "";
	String to_store_max_stk_level		= "";
	String to_store_reorder_level		= "";
	String to_store_uom_desc			= "";
	String display_flag					= "visibility:hidden";
	String disable_add					= "disabled";
	String allow_deci_yn				= "N";
	String no_deci						= "";
	String kit_item_yn					= "";
	String from_multiples				= "1";
	String to_multiples					= "1";
	String batch_multiples				= "1";
	String trn_type   = null;
	String ret_qty						= request.getParameter("ret_qty")==null?"":request.getParameter("ret_qty");
	System.out.println("ret_qty==71=>" +ret_qty);


	String  trn_type1  = "TFR";
	String	BARCODE_YN = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
	String  barcode_applicable = "";
	String mode = bean.getMode();

	String editqty_appl     =	bean.checkForNull(bean.getBarcodeEditQtyAppl(),"N");
	String Qty_disabled = "";
	String kit_temp_code            =        "";//01/08/12
	String usage_type                =        "";
	
	//Added by Rabbani#AMS-CRF-0068(49822) on 12-AUG-2014
	String min_stk_flag					=		"visibility:hidden";
	String rol_flag					    =		"visibility:hidden";
	boolean min_stk                     =       false;
	boolean rol_stk                     =       false;
	//ends
	
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) && BARCODE_YN.equals("TRUE") && editqty_appl.equals("N")){
		Qty_disabled  = "disabled"	;
	}
	


	if(!index.equals("-1")){
		
		HashMap hmRecord = new HashMap();

		//hmRecord=bean.getDtlRecord(Integer.parseInt(index));

		if (BARCODE_YN.equals("TRUE")){
		hmRecord		=		(HashMap)bean.getDtlRecordforBarCode(Integer.parseInt(index));
		barcode_applicable = "Y";
		}
		else{
		hmRecord		=	    bean.getDtlRecord(Integer.parseInt(index));
		barcode_applicable = "N";
		}

		


		stButtonLegend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		doc_srl_no		=	(String)hmRecord.get("doc_srl_no");
		item_code		=	(String)hmRecord.get("item_code");
		item_desc		=	(String)hmRecord.get("item_desc");
		uom				=	(String)hmRecord.get("uom_desc");
		uom_code		=	(String)hmRecord.get("uom_code");
		stock_available	=	(String)hmRecord.get("stock_available");
		//stock_available	=	(String)hmRecord.get("frm_str_avl_qty");
		item_unit_cost	=	(String)hmRecord.get("item_unit_cost");
		item_qty		=	(String)hmRecord.get("item_qty");
		item_sal_value	=	(String)hmRecord.get("item_cost_value");
		kit_item_yn						=		bean.checkForNull((String)hmRecord.get("kit_item_yn"),"N");
		//remarks			=	(String)hmRecord.get("remarks");
		expiry_yn		=	(String)hmRecord.get("expiry_yn");
		codeDisabled	=	"disabled";
		disable_add		=	"";
		stock_item_yn	=	(String)hmRecord.get("stock_item_yn");
		store_code		=	(String)hmRecord.get("store_code");
		from_multiples	=	bean.checkForNull((String)hmRecord.get("from_multiples"),"1");
		to_multiples	=	bean.checkForNull((String)hmRecord.get("to_multiples"),"1");
		batch_multiples	=	bean.checkForNull((String)hmRecord.get("batch_multiples"),"1");
		frm_store_uom_desc		=	bean.getShortDesc(item_code,store_code);
		to_store_uom_desc		=	bean.getShortDesc(item_code,(String)request.getParameter("to_store_code"));
		kit_temp_code	=	bean.checkForNull((String)hmRecord.get("kit_temp_code"),""); //02/08/12
		usage_type	=	bean.checkForNull((String)hmRecord.get("usage_type"),"");
		
		
		if(hmRecord.containsKey("allow_deci_yn"))
		allow_deci_yn           =   bean.checkForNull((String)hmRecord.get("allow_deci_yn"));
		else
		allow_deci_yn           =   bean.checkForNull((String)hmRecord.get("decimal_allowedYN"));

		if(hmRecord.containsKey("allow_deci_yn"))
		no_deci                 =   bean.checkForNull((String)hmRecord.get("no_deci"));
		else
		no_deci                 =   bean.checkForNull((String)hmRecord.get("no_of_decimals"));

    	 if(allow_deci_yn.equals("N"))
          no_deci ="0";


		System.out.println("hmRecord-decimal_allowedYN--124-->"+hmRecord);
		System.out.println("allow_deci_yn---124-->"+allow_deci_yn);
		System.out.println("no_deci---124-->"+no_deci);

		//HashMap hmMinMaxRecord=bean.getMinMaxRecord(Integer.parseInt(index));
		HashMap hmMinMaxRecord = new HashMap();

		if (BARCODE_YN.equals("TRUE")){
		hmMinMaxRecord=bean.getMinMaxRecordforBarcode(Integer.parseInt(index));
		}else{
		hmMinMaxRecord=bean.getMinMaxRecord(Integer.parseInt(index));
		}

		stock_available  = bean.setNumber(stock_available,Integer.parseInt(no_deci));
        item_qty = bean.setNumber(item_qty,Integer.parseInt(no_deci));  
		//frm_store_qty_on_hand		=	(String)hmRecord.get("stock_available"); // Availabe Qty has to be taken based on document no without commited qty , hmMinMaxRecord.get("frm_store_qty_on_hand") will not give doc no based available qty
		//frm_store_qty_on_hand		=	(String)hmRecord.get("frm_str_avl_qty"); // Availabe Qty has to be taken based on document no without commited qty , hmMinMaxRecord.get("frm_store_qty_on_hand") will not give doc no based available qty
		
		frm_store_qty_on_hand		=	(String)hmMinMaxRecord.get("frm_store_qty_on_hand");
		frm_store_min_stk_level		=	bean.checkForNull((String)hmMinMaxRecord.get("frm_store_min_stk_level"),"0");
		frm_store_max_stk_level		=	(String)hmMinMaxRecord.get("frm_store_max_stk_level");
		frm_store_reorder_level		=	bean.checkForNull((String)hmMinMaxRecord.get("frm_store_reorder_level"),"0");
		to_store_qty_on_hand		=	(String)hmMinMaxRecord.get("to_store_qty_on_hand");
		to_store_min_stk_level		=	(String)hmMinMaxRecord.get("to_store_min_stk_level");
		to_store_max_stk_level		=	(String)hmMinMaxRecord.get("to_store_max_stk_level");
		to_store_reorder_level		=	(String)hmMinMaxRecord.get("to_store_reorder_level");
		
	 	//Added By Rabbani #inc no:28266 on 16/09/11 
	      //Starts Here
	    ArrayList  alist =  bean.getTrnTypeArrayList();
	    for(int k=0; k<alist.size(); k++){
	    HashMap  blist = (HashMap)alist.get(k);
	    for(int l=0; l<blist.size();l++){
	    trn_type = (String)blist.get("TRNTYPE");
	     if(trn_type.equals("TFR")){
	     if(((String)bean.getCostYN(store_code)).equals("Y")){ 
	  	   display_flag	="visibility:visible"; 
		   
			}		 
		   }
	     }
	   }  
	       if(trn_type == null){
	       if(((String)bean.getAccessCostDetails()).equals("Y")){
            display_flag	=		"visibility:visible"; 
            }
           }
		   
		   //Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014
	       if(bean.getMin_Rol_yn(bean.getLoginById(),store_code)){
	  		 if(!frm_store_min_stk_level.equals("0")){
	  		if ( (Double.parseDouble(stock_available) - Double.parseDouble(item_qty))  <  Double.parseDouble(frm_store_min_stk_level)){
	  	    	   min_stk = true;
				 }
				 min_stk_flag = "visibility:visible";
	  		 }
	  		 if(!frm_store_reorder_level.equals("0")){
	  	     if ( (Double.parseDouble(stock_available) - Double.parseDouble(item_qty))  <  Double.parseDouble(frm_store_reorder_level)){
	  	    	   rol_stk = true;
	  	       }
	  	     rol_flag	   = "visibility:visible";
	  		 }
	  	 } //ends
	 
	}

	/**
 * @Name - Priya
 * @Date - 26/05/2010
 * @Inc# - 
 * @Desc -  To get no of decimals for cost and assign it to 'no_of_decimals_for_cost' hidden field 
 */
	String noOfDecimalsForCost=bean.getNoOfDecimalsCost();
	//Added by sakti against ML-BRU-SCF-0963[INC#42099]	
			item_desc = item_desc.replaceAll(" ","%20");
			item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
			item_desc = item_desc.replaceAll("%2520","%20");
		//Added ends

		String item_2d_barcode_yn =bean.barcode2DApplicable();//Added for MOHE-CRF-0167
	%>
	</head>
	<body onLoad="FocusFirstElement();totalqty();">
	<form name='formStockTransferListHeader' id='formStockTransferListHeader'>
		<table border='0' cellpadding='2' cellspacing='0' width='100%' >
		<tr>
			<td colspan = '6' class ="label">&nbsp;</td>
		</tr>
		 <% if(item_2d_barcode_yn.equals("Y")){//Added for MOHE-CRF-0167 starts%>
		<tr>
		<td class='label'><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}" /></td>
			<td colspan=6 align=left class='label' colspan=2>&nbsp;<input type='text' name='barcode' id='barcode'  size=80 maxLength=100 value="" onkeypress="getGTINDetails(event,this);"  ></td>			
		</tr>
		<%} //Added for MOHE-CRF-0167 ends%>
		<tr>
			<td class=label align=left><fmt:message key="Common.item.label" bundle="${common_labels}"/></td> 
			<input type="hidden" name="item_desc_temp" id="item_desc_temp" value="<%=item_desc%>" >
			<td colspan=5 align=left class='label'>&nbsp;<input type=text name=item_desc id=item_desc size=70 maxlength=60  onkeypress="callBarCodeBatchSearch(event,item_desc,trn_type1,parent.parent.frameStockTransferHeader.document.formStockTransferHeader.from_store_code,parent.parent.frameStockTransferHeader.document.formStockTransferHeader.to_store_code,this.form,'<%=bean_id%>','<%=bean_name%>','StockTransferListHeader','StockTransferListDetail','StockTransferDetail');" value="" <%=codeDisabled%>   > <input type=button name="item_search" id="item_search" class="button" onClick="callBarCodeBatchSearch(event,item_desc,trn_type1,parent.parent.frameStockTransferHeader.document.formStockTransferHeader.from_store_code,parent.parent.frameStockTransferHeader.document.formStockTransferHeader.to_store_code,this.form,'<%=bean_id%>','<%=bean_name%>','StockTransferListHeader','StockTransferListDetail','StockTransferDetail');getstorecode();"  value='?' <%=codeDisabled%> ><%=bean.getImage("M")%><input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">&nbsp;<b><span id="id_uom"><%=uom%></span></b>
			
			<!-- //Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014 -->
			&nbsp;&nbsp;
			<label id="id_min_stk_label" style="<%=min_stk_flag%>" >Min.Level:</label>
			<%if(min_stk){ %>
			<label id="id_min_str_stk" style="background-color:red;color:yellow; <%=min_stk_flag%>"  ><b><%=frm_store_min_stk_level%></b></label>
			<%}else{ %>
			<label id="id_min_str_stk" style="<%=min_stk_flag%>" ><b><%=frm_store_min_stk_level%></b></label>
			<%} %>
			&nbsp;&nbsp;
			<label id="id_stk_rol_label" style="<%=rol_flag%>" >ROL:</label>
			<%if(rol_stk) {%>
			<label  id="id_stk_rol" style="background-color:red;color:yellow;<%=rol_flag%>" ><b><%=frm_store_reorder_level%></b></label>
			<%}else{%>
			<label  id="id_stk_rol"  style="<%=rol_flag%>"><b><%=frm_store_reorder_level%></b></label>
			<%} %>
			 
			<!-- ends -->
			</td>
		</tr>
		<tr>  
			<td class=label align=left><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td align=left class="label">&nbsp;<input type=text  name=item_qty id=item_qty size=12 maxlength=12 class="NUMBER" onkeypress ="allow_restrict_decimals(this,event);" onblur="if(checkDoubleFormat(this,true)){checkminmaxstatus();totalqty();return CheckQuantity();}" value="<%=bean.checkForNull(item_qty)%>"  <%=Qty_disabled%> ><%=bean.getImage("M")%></td>
			<td width='75%'>
			<table border=0 cellspacing=0 cellpadding=0 width='100%'>
			<tr>
			<td class='label' align='right'><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/>:</td>
			<td class='label' width='20%'>&nbsp;<b><span id="id_stock_available"><%=stock_available%></span></b></td>
			<td class='label' align='right'>
			<td class='label' align='right'><label id="id_item_unit_cost_label" style="<%=display_flag%>"><fmt:message key="Common.Cost.label" bundle="${common_labels}"/>:</label></td>
			<td width='25%' class='label' width='20%'>&nbsp;<b><label id="id_item_unit_cost" style="<%=display_flag%>"><%=item_unit_cost%></label></b><input name="item_unit_cost" id="item_unit_cost" value="<%=item_unit_cost%>" type="hidden"></td>
			<td align=left width='25%'  class='label'><label id="id_item_sal_value_label" style="<%=display_flag%>"><fmt:message key="Common.Value.label" bundle="${common_labels}"/>:&nbsp;</label><b><label id="id_item_sal_value" width='20%'style="<%=display_flag%>"><%=bean.setNumber(item_sal_value,Integer.parseInt(noOfDecimalsForCost))%></label></b></td>
			</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td class='label' align=right ><fmt:message key="eST.TransferQty.label" bundle="${st_labels}"/></td>
			<td align=left class="label" colspan=4>&nbsp;<input type="text" name="ret_qty" id="ret_qty" value="<%=ret_qty%>" size=10 maxlength=10 class="NUMBER" disabled></td>
		</tr>
		</table>	
		<table border="0" cellspacing="0" cellpadding="2" width="100%"> 
			<tr>
			<td colspan = '8' class ="label">&nbsp;</td>
			</tr>
<!--			 <tr> 
				<td align = right class ="label" nowrap Width="12%"> <B>&nbsp; <fmt:message key="eST.StockLevel.label" bundle="${st_labels}"/>  </B></td>
				<td align = right class ="label" nowrap Width="12%" > <fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
				<td align = right class ="label" nowrap Width="12%" > <fmt:message key="Common.uom.label" bundle="${common_labels}"/></td>
				<td align = right class ="label" nowrap Width="13%"> &nbsp;<fmt:message key="Common.Minimum.label" bundle="${common_labels}"/></td>
				<td align = right class ="label" nowrap Width="12%"> &nbsp;<fmt:message key="Common.maximum.label" bundle="${common_labels}"/></td>
				<td align = right class ="label" nowrap Width="14%"> &nbsp;<fmt:message key="eST.ReOrder.label" bundle="${st_labels}"/></td>
				<td align = right class ="label" nowrap Width="40%">&nbsp;</td>
			</tr>
			<tr>
			<td align = right class ="label" nowrap> <fmt:message key="Common.FromStore.label" bundle="${common_labels}"/></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_frm_store_qty_on_hand">   </label><%=frm_store_qty_on_hand%></td>
			<td align = right class ="label" nowrap> <label class="label" id="lb_frm_store_uom_desc"> </label><%=frm_store_uom_desc%></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_frm_store_min_stk_level"> </label><%=frm_store_min_stk_level%></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_frm_store_max_stk_level"> </label><%=frm_store_max_stk_level%></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_frm_store_reorder_level"> </label><%=frm_store_reorder_level%></td>
			<td align = right class ="label" nowrap>&nbsp;</td>
		</tr>
		<tr>
			<td align = right class ="label" nowrap><fmt:message key="Common.ToStore.label" bundle="${common_labels}"/></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_to_store_qty_on_hand">	</label><%=to_store_qty_on_hand%></td>
			<td align = right class ="label" nowrap> <label class="label" id="lb_to_store_uom_desc"> </label><%=to_store_uom_desc%></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_to_store_min_stk_level"> </label><%=to_store_min_stk_level%></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_to_store_max_stk_level"> </label><%=to_store_max_stk_level%></td>
			<td align = right class ="label" nowrap> &nbsp;&nbsp;<label class="label" id="lb_to_store_reorder_level"> </label><%=to_store_reorder_level%></td>
			<td align = right class ="label" nowrap>&nbsp;</td>
		</tr>
-->		<tr>
			<td class=label align=left colspan='7'>
				<input type=button name="edit" id="edit" value='<fmt:message key="eST.Edit/View.label" bundle="${st_labels}"/>' class=button onclick="editViewBatch();"<%=codeDisabled%>><input type=button name=batchsearch id=batchsearch value='<fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"/>' class=button onclick="callBatchSearch();"  <%= BARCODE_YN.equals("TRUE") && mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))?codeDisabled:""%>><input type=button name="apply" id="apply" value="<%=stButtonLegend%>" class=button onclick="totalqty();addToListforBarCode('<%=bean_id%>','<%=bean_name%>',parent.parent.frameStockTransferHeader.document.formStockTransferHeader.barcode_applicable1,'StockTransferListHeader','StockTransferListDetail','StockTransferDetail');"><input type=button name=Cancel id=Cancel value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class=button onclick="cancel_me();">
			<input class="button" type="button" name="ItemDetails" id="ItemDetails" value='<fmt:message key="eST.StockLevel.label" bundle="${st_labels}"/>' onClick="ItemDetail();" <%=disable_add%>></td>

			


		</tr>
		</table>
		<input type="hidden" name="stock_item_yn" id="stock_item_yn"			value="<%=stock_item_yn%>">
		<input type="hidden" name="store_code" id="store_code"				value="<%=store_code%>">
		<input type="hidden" name="expiry_yn" id="expiry_yn"				value="<%=expiry_yn%>">
		<input type="hidden" name="doc_srl_no" id="doc_srl_no"				value="<%=doc_srl_no%>">
		<input type="hidden" name="uom_code" id="uom_code"				value="<%=uom_code%>">
		<input type="hidden" name="index" id="index"					value="<%=index%>">
		<input type="hidden" name="frm_store_qty_on_hand" id="frm_store_qty_on_hand"	value="<%=frm_store_qty_on_hand%>">
		<input type="hidden" name="frm_store_min_stk_level" id="frm_store_min_stk_level" value="<%=frm_store_min_stk_level%>">
		<input type="hidden" name="frm_store_max_stk_level" id="frm_store_max_stk_level" value="<%=frm_store_max_stk_level%>">
		<input type="hidden" name="frm_store_reorder_level" id="frm_store_reorder_level" value="<%=frm_store_reorder_level%>">
		<input type="hidden" name="frm_store_uom_desc" id="frm_store_uom_desc"		value="<%=frm_store_uom_desc%>">
		<input type="hidden" name="to_store_qty_on_hand" id="to_store_qty_on_hand"	value="<%=to_store_qty_on_hand%>">
		<input type="hidden" name="to_store_min_stk_level" id="to_store_min_stk_level"	value="<%=to_store_min_stk_level%>">
		<input type="hidden" name="to_store_max_stk_level" id="to_store_max_stk_level"	value="<%=to_store_max_stk_level%>">
		<input type="hidden" name="to_store_reorder_level" id="to_store_reorder_level"	value="<%=to_store_reorder_level%>">
		<input type="hidden" name="to_store_uom_desc" id="to_store_uom_desc"		value="<%=to_store_uom_desc%>">
		<input type="hidden" name="tmp_conv" id="tmp_conv"				value="">
		<input type="hidden" name="kit" id="kit"						value="">
		<input type="hidden" name="frm_tmp_conv" id="frm_tmp_conv"			value="">
		<input type="hidden" name="phy_inv_id" id="phy_inv_id"				value="">
		<input type="hidden" name="allow_deci_yn" id="allow_deci_yn"			value="<%=allow_deci_yn%>">
		<input type="hidden" name="no_deci" id="no_deci"					value="<%=no_deci%>">
		<input type="hidden" name="kit_item_yn" id="kit_item_yn"				value="<%=kit_item_yn%>">
		<input type="hidden" name="from_multiples" id="from_multiples"			value="<%=from_multiples%>">
		<input type="hidden" name="to_multiples" id="to_multiples"			value="<%=to_multiples%>">
		<input type="hidden" name="batch_multiples" id="batch_multiples"			value="<%=batch_multiples%>">
		<input type="hidden" name="no_of_decimals_for_cost" id="no_of_decimals_for_cost" value='<%=noOfDecimalsForCost%>'>


		<input type="hidden"    name="trn_type1" id="trn_type1"							    value='<%=trn_type1%>' >
		<input type="hidden"    name="BARCODE_YN" id="BARCODE_YN"							    value='<%=BARCODE_YN%>' >
		<input type="hidden"    name="barcode_applicable" id="barcode_applicable"					value="<%=barcode_applicable%>" >
		<input type="hidden"    name="bar_or_item_code" id="bar_or_item_code"						value="" >
		<input type="hidden"    name="mode" id="mode"						value="<%=mode%>" >
		<input type="hidden"    name="billable_item_yn" id="billable_item_yn"				value="" ><!--dummy-->
		<input type="hidden"    name="sale_req_qty" id="sale_req_qty"				value="" ><!--dummy-->
         <input type="hidden"  name="kit_temp_code" id="kit_temp_code"	        value="<%=kit_temp_code%>" >
		 <input type="hidden" name="usage_type" id="usage_type"				value= '<%=usage_type%>'>
		 <input type="hidden"  name="noofbatchesforbarcode" id="noofbatchesforbarcode"	value="1" >
		<input type="hidden" name="item_2d_barcode_yn" id="item_2d_barcode_yn"	value='<%=item_2d_barcode_yn%>'><!-- added for MOHE-CRF-0167 -->

	</form>
<%
putObjectInBean("stockTransferBean",bean,request);
putObjectInBean("stHeaderBean",beanHdr,request);

%>

	</body>
</html>

<script>
Setitemdesc(document.formStockTransferListHeader.item_desc_temp);
</script>


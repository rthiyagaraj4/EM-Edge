<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
15/11/2017		INC065695			Shazana Hasan							MMS-DM-CRF-0112 -US003 - Barcode search
30/01/2020      IN071972            Haribabu                                AAKH-CRF-0117.2 
07/08/2020  IN073577        B Haribabu          07/08/2020                          MMS-DM-CRF-0174.2
---------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page import=" eST.*, eST.Common.* , eCommon.Common.*, java.util.*,webbeans.eCommon.*,java.sql.*,java.lang.*"%>
<%@ page contentType="text/html;charset=UTF-8" import=" eST.SalesBean, java.util.HashMap,java.util.ArrayList"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/Sales.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<%
	String bean_id				=    "salesBean";
	String bean_name			=    "eST.SalesBean";

	SalesBean bean				=	(SalesBean)getBeanObject( "salesBean", "eST.SalesBean", request );
	bean.setLanguageId(locale);
	bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
	String store_code			=	bean.getStore_code();

	System.out.println("store_code==>"+store_code);
	//Added for GHL-CRF-0413 starts
	//Added for IN:071972 start
     Connection con				= null;
	 
	boolean approval_no_appl = false;
	boolean site_main = false;		
	try 
	{
		con						= ConnectionManager.getConnection(request);
		approval_no_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","APPROVAL_NO_APPL");
		 site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
	} 
	catch (Exception e) 
	{
		e.printStackTrace(System.err);
		System.out.println(" Error in headerlist Page " + e.getMessage());
	} 
	finally 
	{
		if (con != null) ConnectionManager.returnConnection(con, request);
	}
	String approval_no_appl_yn="N";
	if(approval_no_appl)
		approval_no_appl_yn="Y";
	//Added for IN:071972 end
	
	//System.out.println("System.out.println(site_main)===="+site_main);
	bean.setSite_spec_yn(site_main);
	boolean site=bean.isSite_spec_yn();
	//Added for GHL-CRF-0413 ends


	String stButtonLegend		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String index				=	bean.checkForNull(request.getParameter("index"),"-1");
	String doc_srl_no			=	bean.checkForNull(request.getParameter("doc_srl_no"),"-1");
	String item_code			=	"";
	String item_desc			=	"";
	String uom					=	"";
	String uom_code				=	"";
	String stock_available		=	"";
	String item_unit_cost		=	"";
	String item_qty				=	"";
	String item_sal_value		=	"";
	String remarks				=	"";
	String remarks_code			=	"";
	String expiry_yn			=	"";
	String stock_item_yn		=	"";
	String codeDisabled			=	"";
	String payab_amt			=	"";
	String pat_paid_amt			=	"";
	String  charge_amt			=	"";
	String  tot_item_qty		=	"";
	String bl_incl_excl_override_reason_code ="";
	String bl_incl_excl_override_reason_desc = "";
	String bl_def_override_excl_incl_ind = "";
	String bl_override_excl_incl_ind = "";
	String bl_override_allowed_yn = "";
	String approval_reqd_yn = "";
	String decimal_allowedYN = "";
	String disabled = "";
	String billable_item_yn = "N";
	String sale_req_qty = "";
	String trn_type     =	bean.checkForNull(bean.getTrn_type());
	String facility_id  =  bean.checkForNull(bean.getLoginFacilityId());
	String barcode_applicable = "";
	String mode = bean.getMode();
	String Qty_disabled = "";
	String kit_temp_code = "";
	String usage_type = "" ;
	double tmp_conv =  bean.getConvFactTemp(item_code,store_code);//Added for GHL-CRF-0413
	//Added by Rabbani#AMS-CRF-0068(49822) on 12-AUG-2014
	String min_stk_flag					=		"visibility:hidden";
	String rol_flag					    =		"visibility:hidden";
	String disp_req_flag	            =       "visibility:hidden";
	boolean min_stk                     =       false;
	boolean rol_stk                     =       false;
	HashMap rol_min				        =	    null;
	String frm_store_min_stk_level      =       "";
	String frm_store_reorder_level	    = 	     "";
	//ends
	
	
	//Added by Rabbani inc no:26404 on 03/02/12
	String module_id = bean.checkForNull(bean.getModuleId());  
	//System.out.println("module_id =====>" +module_id);
	//this is for modify mode passing from modifydata()
	String	BARCODE_YN      = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
		
	int no_of_decimals =bean.getNoOfDecimals();
	int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());

	String disp_charge = "display:none;";
	String disp_decimal_dtls_yn="";
	String approval_no="";//Added for IN:071972
	if(!index.equals("-1")){
		//no_of_decimals = bean.getNoOfDecimals();
		HashMap hmRecord = new HashMap();
		
		System.out.println(BARCODE_YN);
		if (BARCODE_YN.equals("TRUE")){
		hmRecord		=		(HashMap)bean.getDtlRecordforBarCode(Integer.parseInt(index));
		barcode_applicable = "Y";
		}
		else{
		hmRecord		=	    bean.getDtlRecord(Integer.parseInt(index));
		barcode_applicable = "N";
		}
		
		stButtonLegend			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		
		doc_srl_no				=	(String)hmRecord.get("doc_srl_no");
		item_code				=	(String)hmRecord.get("item_code");
		item_desc				=	(String)hmRecord.get("item_desc");
		uom						=	(String)hmRecord.get("uom_desc");
		uom_code				=	(String)hmRecord.get("uom_code");
		stock_available			=	(String)hmRecord.get("stock_available");
		item_unit_cost			=	(String)hmRecord.get("item_unit_cost");
		item_qty				=	(String)hmRecord.get("item_qty");
		item_sal_value			=	(String)hmRecord.get("item_cost_value");
		remarks					=	(String)hmRecord.get("remarks");
		remarks_code			=	(String)hmRecord.get("remarks_code");
		expiry_yn				=	(String)hmRecord.get("expiry_yn");
		stock_item_yn			=	(String)hmRecord.get("stock_item_yn");
		codeDisabled			=	"disabled";
		
		payab_amt				=(String)hmRecord.get("pat_net_amt");
		charge_amt				=(String)hmRecord.get("gross_charge_amt");			
		pat_paid_amt			=(String)hmRecord.get("pat_paid_amt");
		/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications begin

		**/
		decimal_allowedYN		=	(String)hmRecord.get("decimal_allowedYN");	
		sale_req_qty			=	(String)hmRecord.get("sale_req_qty");	
		billable_item_yn		=	bean.checkForNull((String)hmRecord.get("billable_item_yn"),"N");	
		no_of_decimals			=	Integer.parseInt((String)hmRecord.get("no_of_decimals"));	
		//disp_decimal_dtls_yn	=bean.getDispDecimalDtlsYN();
		tmp_conv =  bean.getConvFactTemp(item_code,store_code);//Added by Shazana for INC065695
		if(bean.getAllowDecimalsYN(item_code).equals("Y")){
			tot_item_qty			=bean.setNumber(""+(Double.parseDouble(item_qty)*tmp_conv),no_of_decimals)	;
		}else{
			tot_item_qty			=bean.setNumber(""+(Double.parseDouble(item_qty)*tmp_conv),0);
		}


		kit_temp_code		=	bean.checkForNull((String)hmRecord.get("kit_temp_code"));
        usage_type		    =	bean.checkForNull((String)hmRecord.get("usage_type"));			

		/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications end

		**/
		/** @ before modification 
		tot_item_qty			=	""+Integer.parseInt(item_qty)*bean.getConvFactTemp(item_code,store_code);
		**/
		approval_no						    = (String)hmRecord.get("approval_no");//Added for IN:071972
		if(bean.getBLModuleInstalled().equals("Y") && billable_item_yn.equals("Y")) {
			disp_charge = "display:inline;";
			bl_override_excl_incl_ind			= (String)hmRecord.get("p_overridden_excl_incl_ind");
			bl_incl_excl_override_reason_code	= (String)hmRecord.get("p_overridden_action_reason");
			bl_incl_excl_override_reason_desc	= (String)hmRecord.get("bl_incl_excl_override_reason_desc");
			bl_def_override_excl_incl_ind		= (String)hmRecord.get("bl_def_override_excl_incl_ind");
			approval_reqd_yn					= (String)hmRecord.get("approval_reqd_yn");
			bl_override_allowed_yn				= (String)hmRecord.get("bl_override_allowed_yn");
			if(bl_override_allowed_yn.equals("")){
			disabled="disabled";
			}
		}	 
		
		//Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014
				if(bean.getMin_Rol_yn(bean.getLoginById(),store_code)){
					rol_min		=	(HashMap)bean.getROL(item_code,store_code);
					frm_store_min_stk_level = bean.checkForNull((String)rol_min.get("MIN_STK_QTY"),"0");
					frm_store_reorder_level	= bean.checkForNull((String)rol_min.get("REORDER_LEVEL"),"0");
					
				 if(!frm_store_min_stk_level.equals("0")){
				if ( (Double.parseDouble(stock_available) - Double.parseDouble(item_qty))  <  Double.parseDouble(frm_store_min_stk_level)){
			    	   min_stk = true;
					   if(bean.getReq_allowed_yn(bean.getLoginById(),store_code)){
			    	   disp_req_flag ="visibility:visible"; 
					    }
					   }
			       
				  min_stk_flag = "visibility:visible"; 
				 }
				 if(!frm_store_reorder_level.equals("0")){
			     if ( (Double.parseDouble(stock_available) - Double.parseDouble(item_qty))  <  Double.parseDouble(frm_store_reorder_level)){
			    	   rol_stk = true; 
					   if(bean.getReq_allowed_yn(bean.getLoginById(),store_code)){
			    	   disp_req_flag ="visibility:visible"; 
					    }
			       }
			            rol_flag	 = "visibility:visible";
				}
				 
				}//ends
			
	}

	//String defaultqty_appl  =   bean.checkForNull(bean.getBarcodeDefaultQtyAppl(),"N"); commented by Shazana for Unused local variable 
	String editqty_appl     =	bean.checkForNull(bean.getBarcodeEditQtyAppl(),"N");
	
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) && BARCODE_YN.equals("TRUE") && editqty_appl.equals("N") && !site_main ){//Added site_main against IN:062328 
		Qty_disabled  = "disabled"	;
	}
	%>
	</head>
	<body>
	<form name="formSalesListHeader" id="formSalesListHeader">
		<table border='0' cellpadding='0' cellspacing='0' width='100vh' height='60vh' align="center" >
	<% if(site_main){//Added for GHL-CRF-0413%>
		<tr>
		<td class='label'><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}" /></td>
			<td colspan=6 align=left class='label' colspan=2><input type='text' name='barcode' id='barcode'  size=80 maxLength=100 value="" onkeypress="callBarCodeBatchSearchforBarcode1(event,barcode,trn_type,parent.parent.frameSalesHeader.document.formSalesHeader.store_code,'',this.form,'<%=bean_id%>','<%=bean_name%>','SalesListHeader','SalesListDetail','SalesDetail');" <%=codeDisabled%> ></td>		<!--Modified for IN:073577 increased size from 70 to 80 -->	
		</tr>
		<%} %>
		<tr>
			<td class=label ><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<td colspan=4  class='fields' nowrap>&nbsp;<input type=text name="item_desc" id="item_desc"  id='item_desc'  onkeypress="callBarCodeBatchSearch(event,item_desc,trn_type,parent.parent.frameSalesHeader.document.formSalesHeader.store_code,'',this.form,'<%=bean_id%>','<%=bean_name%>','SalesListHeader','SalesListDetail','SalesDetail');"    size=70 maxlength=60 value="<%=item_desc%>" <%=codeDisabled%> >
			<input type=button name="item_search" id="item_search" class="button" onClick="callBarCodeBatchSearch(event,item_desc,trn_type,parent.parent.frameSalesHeader.document.formSalesHeader.store_code,'',this.form,'<%=bean_id%>','<%=bean_name%>','SalesListHeader','SalesListDetail','SalesDetail');" value='?'  <%=codeDisabled%> ><%=bean.getImage("M")%><input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">&nbsp;&nbsp;<b><span id="id_uom"><%=uom%></span></b>
			<!-- Added by Rabbani#AMS-CRF-0068(49822) on 12-AUG-2014 -->
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
			
			<%}else{ %>
			<label  id="id_stk_rol"  style="<%=rol_flag%>"  ><b><%=frm_store_reorder_level%></b></label>
			<%} %>
			
			&nbsp;
			<label class=HYPERLINK  name = "request"  onmouseover="changeCursor(this);" onclick="request();" id="sales_req_label" style="color:blue;<%=disp_req_flag%>" ><b>Create Request</b></label>
			<td class='label'>&nbsp;</td>
		</tr>
		<tr class='NODISPLAY'>
			<td class=label  colspan='7'>
			<table border=0 cellspacing=0 cellpadding=0 width='100%' align="center" >
			<tr>
				<td width='25%' class='label' ><fmt:message key="eST.AvailableStock.label" bundle="${st_labels}"/></td>
				<td width='25%' class='label'>&nbsp;</td>
				<td width='25%' class='label' ><fmt:message key="Common.Cost.label" bundle="${common_labels}"/></td>
				<td width='25%' class='label'>&nbsp;<b><span id="id_store_item_unit_cost"><%=item_unit_cost%></span></b></td>
			</tr>
			</table>
			</td>
		</tr>
		 <%
		  if(bean.getBLModuleInstalled().equals("Y") && billable_item_yn.equals("Y")){
			
		 %>
		<tr>
		
			<td class=label ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td  class='fields' width='30%' nowrap>&nbsp;<input type=text name=item_qty id=item_qty size=12 maxlength=12 class="NUMBER" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onchange="CheckQuantity(item_qty);calTotalQty();callItemQtyUpdate('<%=bean_id%>','<%=bean_name%>','SalesListHeader','SalesListDetail','SalesDetail','<%=mode%>');"  onChange="javascript:if(stock_item_yn.value=='Y'  && !(BARCODE_YN.value))edit.disabled=false;" value="<%=item_qty%>" <%=Qty_disabled%> ><%=bean.getImage("M")%> <b><span id="id_uom1"><%=uom%></span></b></td> <!-- modified onblur to onchange for GHL-CRF-0413 -->
			<td class=label nowrap><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/>:&nbsp;<b><span id="id_stock_available"><%=stock_available%></span></b></td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>
<!-- 			<td class=label nowrap><span  id="id_char_amt" ><fmt:message key="eST.chargeAmt.label"      bundle="${st_labels}"/>:&nbsp;<span id="id_charge_amt" ><%=payab_amt%></span></td>
			<td class=label nowrap><span  id="id_pay_amt" ><fmt:message key="Common.PatientPayable.label"  bundle="${common_labels}"/>:&nbsp;
			<span id="id_payable_amt" ><%=charge_amt%></span></b></td>-->
			<td align=left  class='label'><b><span style="visibility:hidden" id="id_item_sal_value"><%=item_sal_value%></span></b></td>		
 			
		</tr>
		<tr>
			<td class=label width='15%'><fmt:message key="Common.Batch.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td  class='fields' width='20%'>&nbsp;<input type=text name=tot_item_qty id=tot_item_qty size=12 maxlength=12 class="NUMBER"  value="<%=tot_item_qty%>" disabled></td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>

		</tr>
		<% 
	} else {

		  %>
		<tr>
			<td class=label ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td  class='fields' width='30%' nowrap>&nbsp;<input type=text name=item_qty id=item_qty size=12 maxlength=12 class="NUMBER" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);"  onblur="CheckQuantity(item_qty);calTotalQty();callItemQtyUpdate('<%=bean_id%>','<%=bean_name%>','SalesListHeader','SalesListDetail','SalesDetail','<%=mode%>');" onChange="javascript:if(stock_item_yn.value=='Y'  && !(BARCODE_YN.value))edit.disabled=false;" value="<%=item_qty%>" <%=Qty_disabled%> ><%=bean.getImage("M")%> <b><span id="id_uom1"><%=uom%></span></b></td>
			<td class=label ><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/>:&nbsp;<b><span id="id_stock_available"><%=stock_available%></span></b></td>
			<td  width='25%'  class='fields'>&nbsp;<b><span style="visibility:hidden" id="id_item_sal_value"><%=item_sal_value%></span></b></td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>
		</tr>
		<tr>
			<td class=label width='15%'><fmt:message key="Common.Batch.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td  class='fields' width='20%'>&nbsp;<input type=text name=tot_item_qty id=tot_item_qty size=12 maxlength=12 class="NUMBER"  value="<%=tot_item_qty%>" disabled></td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>
			<td class = "label">&nbsp;</td>

		</tr>
		<% 
			}
		  %>
		<tr>
			<td class=label ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td colspan=5 class='fields'>&nbsp;<textarea rows=2 cols=50 name=remarks readonly onBlur="checkRemarksLength(this);"><%=remarks%></textarea><input type="hidden" name="remarks_code" id="remarks_code" value = "<%=remarks_code%>" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code,remarks);"></td>
		</tr>
<!-- Billing Details -->
		<tr>
			<td class=label  colspan='6'>
			<table border='0' cellpadding='0' cellspacing='0' width='90%' height='98%'  >
				<tr id='BL_HEADER' style="<%=disp_charge%>" >
					<td class="label" style='TEXT-ALIGN:center;'><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/>:</td>
					<td class="data" id='id_charge_amt' align='center'><%=charge_amt%></td>
					<td class="label"  style='TEXT-ALIGN:center;'><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:</td>
					<td class="data" id='id_payable_amt' align='center'><%=payab_amt%></td>
					<td class="label"  style='TEXT-ALIGN:center;'><fmt:message key="eST.PatientPaid.label" bundle="${st_labels}"/>:</td> 
					<td class="data" id='id_paid_amt' align='center'><%=pat_paid_amt%></td>
				</tr>
			</table>
		</tr>
		<tr>
			<td class=label  colspan='6'>
			<table border='0' cellpadding='0' cellspacing='0' >
				<tr id='BL_VALUES' style="<%=disp_charge%>">
					
				<td class="label" nowrap><fmt:message key="Common.Included.label" bundle="${common_labels}"/>  &nbsp; 
					<span align='center' id='bl_def_override_excl_incl_ind_gif'>&nbsp;&nbsp;
					<%
						if(bl_def_override_excl_incl_ind.equals("I")){
							out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
						}else if(bl_def_override_excl_incl_ind.equals("E")){
							out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
						}else{
							out.println("--&nbsp;--");
						}
					%>
					</span>
					<span id='td_bl_override_excl_incl_ind'>&nbsp;</span>
					</td>	
					
					<td  class="label" nowrap><fmt:message key="eST.OverrideInclExcl.label" bundle="${st_labels}"/> 
					<select name="bl_override_excl_incl_ind" id="bl_override_excl_incl_ind" onchange="assignOverrideExclInclInd(this);" <%=disabled%> >
					
					<%
						
					if(bl_override_allowed_yn.equals("I")){%>
					<option value="S" <%=bl_override_excl_incl_ind.equals("S")?"selected":"" %> >-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --</option>
					<option value="I" <%=bl_override_excl_incl_ind.equals("I")?"selected":"" %>> <fmt:message key="Common.Include.label" bundle="${common_labels}"/> </option>
					<%}else if(bl_override_allowed_yn.equals("E")){%>
					<option value="S" <%=bl_override_excl_incl_ind.equals("S")?"selected":"" %>>-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --</option>
					<option value="E" <%=bl_override_excl_incl_ind.equals("E")?"selected":"" %>> <fmt:message key="Common.Exclude.label" bundle="${common_labels}"/> </option>
					<%}else if(bl_override_allowed_yn.equals("B")){%>
					<option value="S" <%=bl_override_excl_incl_ind.equals("S")?"selected":"" %>>-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --</option>
					<option value="I" <%=bl_override_excl_incl_ind.equals("I")?"selected":"" %>> <fmt:message key="Common.Include.label" bundle="${common_labels}"/> </option>
					<option value="E" <%=bl_override_excl_incl_ind.equals("E")?"selected":"" %>> <fmt:message key="Common.Exclude.label" bundle="${common_labels}"/> </option>
					<%}else{%>
					<option value="S" selected>-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --</option>
					<%}%>
					</select></td>
					<!-- <input type='checkbox' name='bl_override_excl_incl_ind' id='bl_override_excl_incl_ind' value='<%=bl_override_excl_incl_ind%>' onclick='assignOverrideExclInclInd(this)' <%=(bl_override_excl_incl_ind.equals(bl_def_override_excl_incl_ind))?"":"checked"%> <%=(bl_override_allowed_yn.equals("Y"))?"":"disabled"%>>
					</td> -->
					<% String style="visibility:visible";
					if(bl_override_excl_incl_ind.equals("")&& bl_def_override_excl_incl_ind.equals(""))
					bl_override_excl_incl_ind="S";
					
					if((bl_override_excl_incl_ind.equals("S"))|| bl_override_excl_incl_ind.equals(""))
						style="visibility:hidden";
					%>
					<td  class="label" nowrap><fmt:message key="Common.reason.label" bundle="${common_labels}"/>
					&nbsp;
					<input type='text' name='bl_incl_excl_override_reason_desc' id='bl_incl_excl_override_reason_desc' size='25'  value='<%=bl_incl_excl_override_reason_desc%>' readonly >
						<input type="button" name="bl_overriden_action_reason_lkp" id="bl_overriden_action_reason_lkp" value="?" class="button" onClick="searchBLOverrideReason();" <%=(bl_override_excl_incl_ind.equals("S"))?"disabled":""%> <%=disabled%>><img  src="../../eCommon/images/mandatory.gif" id='bl_overriden_action_reason_img' style='<%=style%>'></img>
					</td>						
					<td class="label" nowrap><fmt:message key="ePH.ApprovalReqd.label" bundle="${ph_labels}"/>
					<span align='center'id='bl_approval_reqd_yn'>
					<%
						if(approval_reqd_yn.equals("Y")){
							out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
						}else if(approval_reqd_yn.equals("N")){
							out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
						}else{
							out.println("--&nbsp;--");
						}
					%>

					</span>
					</td>
					<!-- Added for IN:071972 start-->
					
					<td class='label'  nowrap  id="approvalTd"><fmt:message key="eST.ApprovalNumber.label" bundle="${st_labels}"/>
			&nbsp;<input type='text' name="approval_number" id="approval_number"  value="<%=approval_no%>" size=20 maxLength=20" onKeyPress="return KeyPressSpecCharsAprovalno(event)" onBlur="CheckForSpecCharAprovalno(this);" ></td>
			<!-- Added for IN:071972 end-->
				</tr>
				<script language="JavaScript">
						<%
						if(approval_no_appl && charge_amt!=null && payab_amt!=null && charge_amt.equals(payab_amt) ){%>//modified for 23594
						dissableApprovalNo();
						<%}else if(!approval_no_appl){%>
						dissableApprovalNo();
						<%}%>
					</script>		
				<input type='hidden' name='bl_def_override_excl_incl_ind' id='bl_def_override_excl_incl_ind' value='<%=bl_def_override_excl_incl_ind%>'>
				<input type='hidden' name='bl_override_allowed_yn' id='bl_override_allowed_yn' value='<%=bl_override_allowed_yn%>'>
				<input type='hidden' name='bl_incl_excl_override_reason_code' id='bl_incl_excl_override_reason_code' value='<%=bl_incl_excl_override_reason_code%>'>
				<input type='hidden' name='approval_reqd_yn' id='approval_reqd_yn' value='<%=approval_reqd_yn%>'>
				<input type="hidden" name="decimal_allowedYN" id="decimal_allowedYN" value='<%=decimal_allowedYN%>'>
				
				
			</td>
			</tr>
			</table>
			</tr>
		
		
<!-- Billing Details End -->
		<tr>
			<td class='fields'  colspan='7'>
				<input type=button name="edit" id="edit" value='<fmt:message key="eST.Edit/View.label" bundle="${st_labels}"/>'  class=button onclick="editViewBatch();" <%=codeDisabled%>><input type=button name=batchsearch id=batchsearch value='<fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"/>' class=button onclick="callBatchSearch();" <%=stock_item_yn.equals("N")?codeDisabled:""%>  <%= BARCODE_YN.equals("TRUE") && mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))?codeDisabled:""%> ><input type=button name="apply" id="apply" value="<%=stButtonLegend%>" class=button onclick="addToListforBarCode('<%=bean_id%>','<%=bean_name%>',parent.parent.frameSalesHeader.document.formSalesHeader.barcode_applicable1,'SalesListHeader','SalesListDetail','SalesDetail');"><input type=button name=Cancel id=Cancel value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class=button  onclick="cancel_me('<%=index%>');">
<!-- 				<input type=button name=view id=view value='<fmt:message key="Common.Charges.label" bundle="${common_labels}"/>' class=button disabled onclick="viewCharges();">
 -->			</td>
		</tr>
		</table>
		<input type="hidden"	name="stock_item_yn" id="stock_item_yn" value="<%=stock_item_yn%>">
		<input type="hidden"	name="store_code" id="store_code" value="<%=store_code%>">
		<input type="hidden"	name="uom_code" id="uom_code" value="<%=uom_code%>">
        <input type="hidden"	name="unit_cost" id="unit_cost"	value="<%=item_unit_cost%>">
		<input type="hidden"	name="expiry_yn" id="expiry_yn"	value="<%=expiry_yn%>">
		<input type="hidden"	name="doc_srl_no" id="doc_srl_no" value="<%=doc_srl_no%>">
		<input type="hidden"	name="index" id="index" value="<%=index%>">
		<input type="hidden"	name="kit" id="kit" value="">
		<input type="hidden"	name="phy_inv_id" id="phy_inv_id" value="">
		<input type="hidden"	name="rem_trans_type" id="rem_trans_type" value="SAL">
		<input type="hidden"	name="lang_id" id="lang_id"	value="<%=locale%>">
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
		<input type="hidden"    name="no_of_decimals" id="no_of_decimals" value='<%=no_of_decimals%>'>
		<input type="hidden"    name="disp_decimal_dtls_yn" id="disp_decimal_dtls_yn" value='<%=disp_decimal_dtls_yn%>'>
		<input type="hidden"	name="dec_allowed_yn" id="dec_allowed_yn" value="<%=decimal_allowedYN%>">
		<input type="hidden"	name="billable_item_yn" id="billable_item_yn" value="<%=billable_item_yn%>">
		<input type="hidden"    name="no_of_decimals_for_cost" id="no_of_decimals_for_cost"	value='<%=noOfDecimalsForCost%>'>
		<input type="hidden"    name="sale_req_qty" id="sale_req_qty" value='<%=sale_req_qty%>' >
		
		<input type="hidden"    name="trn_type" id="trn_type" value='<%=trn_type%>' >
		<input type="hidden"    name="BARCODE_YN" id="BARCODE_YN" value='<%=BARCODE_YN%>' >
		<input type="hidden"    name="barcode_applicable" id="barcode_applicable" value="<%=barcode_applicable%>" >
		<input type="hidden"    name="defaultqty_appl" id="defaultqty_appl" value="" >
		<input type="hidden"    name="editqty_appl" id="editqty_appl" value="" >
		<input type="hidden"    name="bar_or_item_code" id="bar_or_item_code" value="" >
		<input type="hidden"	name="defaultqty_value" id="defaultqty_value" value="">
		<input type="hidden"	name="mode" id="mode" value="<%=mode%>">
		<input type="hidden"  name="kit_temp_code" id="kit_temp_code"	value="<%=kit_temp_code%>" >
		<input type="hidden"  name="usage_type" id="usage_type"	value="<%=usage_type%>" >
		<input type="hidden"  name="noofbatchesforbarcode" id="noofbatchesforbarcode"	value="1" >
		<input type="hidden"  name="tmp_conv" id="tmp_conv"	value="<%=tmp_conv %>" >
		<input type="hidden"    name="site" id="site"	 value="<%=site%>">
		<input type='hidden' name="approval_no_appl_yn" id="approval_no_appl_yn" value="<%=approval_no_appl_yn%>"> <!-- Added for IN:071972 -->

<script language="JavaScript">
<%if(module_id.equals("ST")){%>
GoItem_desc1();
<%}%>
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</form>
<%
//Added for GHL-CRF-0413
	if(con != null)
		ConnectionManager.returnConnection(con,request);
%>
<%
	putObjectInBean( "salesBean",bean,request);
%>



	</body>

</html>



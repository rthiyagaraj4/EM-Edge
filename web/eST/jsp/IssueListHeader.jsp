<!DOCTYPE html>

<%/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date   		Rev.By 				Description
--------------------------------------------------------------------------------------------------------------------------------
22/06/2020	IN073190		B Haribabu          22/06/2020     	                    ML-BRU-SCF-2033
07/08/2020  IN073577        B Haribabu          07/08/2020                          MMS-DM-CRF-0174.2
17/05/2021                  Chandrashekar Arram                                     MO-CRF-20166
-------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import=" eST.*, eST.Common.* , eCommon.Common.*, java.util.*,webbeans.eCommon.*,java.sql.*,java.lang.*,eST.IssueBean, java.util.ArrayList,java.util.HashMap,eCommon.XSSRequestWrapper"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			=	 (String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/Issue.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
	
	 
 		
 		 
<%
	IssueBean bean						=		(IssueBean)getBeanObject( "issueBean","eST.IssueBean", request  );
	bean.setLanguageId(locale); 

	String bean_id = "issueBean";
	String bean_name = "eST.IssueBean";
	//Added for GHL-CRF-0413 starts
	boolean site=bean.isSite_spec_yn();
	String auth_qty = "";//Added against GHL-CRF-0413.2-US002
	System.out.println("after setting in bean===="+site);
	//Added for GHL-CRF-0413 ends

	//String stButtonLegend				=		"  Add  ";
	String stButtonLegend				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String index						=		bean.checkForNull(request.getParameter("index"),"-1");
	String mode							=		bean.checkForNull(request.getParameter("mode"),"1");
	String disabled						=		"";
	String disable_add					=		"disabled";
	if(mode != null && mode.equals("2")) {
		disabled						=		"disabled";
	}
	String doc_srl_no					=		bean.checkForNull(request.getParameter("doc_srl_no"),"-1");
	String item_code					=		"";
	String item_desc					=		"";
	String uom							=		"";
	String stock_uom_desc				=		"";
	String uom_code						=		"";
	String stock_available				=		"";
	String item_unit_cost				=		"";
	String item_qty						=		"";
	String for_bin_to_store_hidden		=		"";
	String item_sal_value				=		"";
	String remarks						=		"";
	String remarks_code					=		"";
	String expiry_yn					=		"";
	String codeDisabled					=		"";
	String stock_item_yn				=		"";
	String store_code					=		"";
	String iss_uom_code					=		"";
	String iss_uom_qty					=		"";
	String iss_conv_fact				=		"";
	String frm_store_qty_on_hand		=		"";
	String frm_store_min_stk_level		=		"";
	String frm_store_max_stk_level		=		"";
	String frm_store_reorder_level		=		"";
	String to_store_qty_on_hand			=		"";
	String to_store_min_stk_level		=		"";
	String to_store_max_stk_level		=		"";
	String to_store_reorder_level		=		"";
	String to_store_uom_code			=		"";
	String gen_uom_code					=		"";
	String frm_store_uom_desc			=		"";
	String to_store_uom_desc			=		"";
	String display_flag					=		"visibility:hidden";
	String imgMandatory					=		"visibility:hidden";
	String kit_template_uom				=		"";
	String kit_item_yn					=		"";
	String iss_uom_conv_text			=		"";
	String	display_style				=			 "display:none";
	String from_multiples				=		"1";
	String to_multiples					=		"1";
	String batch_multiples				=		"1";
	String issue_uom_multiples			=		"1";
	String kit_temp_code                =        "";
	String usage_type                   =        "";  
    
  //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
	String iss_item_hold_yn              =        "N";
	String iss_item_hold_chk             =        "N";
	String iss_item_hold_qty             =        "";
	//ends	
	
	//Added by Rabbani#AMS-CRF-0068(49822) on 12-AUG-2014
	String min_stk_flag					=		"visibility:hidden";
	String rol_flag					    =		"visibility:hidden";
	boolean min_stk                     =       false;
	boolean rol_stk                     =       false;
	String	iss_history_style		=			 "visibility:hidden";//Adding start for MOD-CRF-20166
	String issue_history_durn = bean.getIssueHistoryDurn();
		if(issue_history_durn ==null || issue_history_durn.equals("0"))
		 issue_history_durn ="";
	//adding end for MO-CRF-20166
	
 	/**
	* @Name - Mahesh
	* @Date - 20/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/

	int no_of_decimals					=			bean.getNoOfDecimals();

		
	String  trn_type  = "URG";
	String  trn_type_barcode  = bean.checkForNull(bean.getTrn_type(), "URG");//Added against GHL-CRF-0413.2-US002
	System.out.println("trn_type_barcode--->"+trn_type_barcode);
	String	BARCODE_YN = request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
	String  barcode_applicable = "";
	String   editqty_appl     =	bean.checkForNull(bean.getBarcodeEditQtyAppl(),"N");
	String Qty_disabled = "";
	String mode1= bean.getMode();
	//if(mode1.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) && BARCODE_YN.equals("TRUE") && editqty_appl.equals("N")) Modified for GHL-CRF-0413
	if(mode1.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) && BARCODE_YN.equals("TRUE") && editqty_appl.equals("N") && !site){
		Qty_disabled  = "disabled"	;
	}


	//String to_store_code				=		request.getParameter("to_store_code");
	String stModifyLegend				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
	if(!index.equals("-1")){
		HashMap hmRecord = new HashMap();

		//HashMap hmRecord				=		bean.getDtlRecord(Integer.parseInt(index));

		if (BARCODE_YN.equals("TRUE")){
		hmRecord		=		(HashMap)bean.getDtlRecordforBarCode(Integer.parseInt(index));
		barcode_applicable = "Y";
		}
		else{
		hmRecord		=	    bean.getDtlRecord(Integer.parseInt(index));
		barcode_applicable = "N";
		}

		//System.out.println("hmRecord===119==>"+hmRecord);



 	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
	*/
		item_code						=		(String)hmRecord.get("item_code");
		if((bean.getAllowDecimalsYN(item_code)).equals("N")){
			no_of_decimals = 0;
		}
		
		stButtonLegend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		doc_srl_no						=		(String)hmRecord.get("doc_srl_no");
		item_desc						=		(String)hmRecord.get("item_desc");
		uom								=		(String)hmRecord.get("uom_desc");
		stock_uom_desc					=		(String)hmRecord.get("stock_uom_desc");
		uom_code						=		(String)hmRecord.get("uom_code");
		stock_available					=		bean.setNumber((String)hmRecord.get("stock_available"),no_of_decimals);
		item_unit_cost					=		(String)hmRecord.get("item_unit_cost");
		for_bin_to_store_hidden			=		(String)hmRecord.get("for_bin_to_store_hidden") ;
		item_sal_value					=		(String)hmRecord.get("item_cost_value");
		//remarks						=		(String)hmRecord.get("remarks");
		remarks							=		bean.checkForNull((String)hmRecord.get("remarks"),"");
		remarks_code					=	bean.checkForNull((String)hmRecord.get("remarks_code"),"");		
		
		expiry_yn						=		(String)hmRecord.get("expiry_yn");
		codeDisabled					=		"disabled";
		disable_add						=		"";
		stock_item_yn					=		(String)hmRecord.get("stock_item_yn");
		store_code						=		(String)hmRecord.get("store_code");
		iss_uom_code					=		(String)hmRecord.get("issue_uom");
		iss_conv_fact					=		(String)hmRecord.get("issue_uom_conv");
		iss_uom_conv_text				=		(String)hmRecord.get("iss_uom_conv_text");
		iss_uom_qty						=		bean.setNumber((String)hmRecord.get("issue_uom_qty"),no_of_decimals);
		//auth_qty						=		bean.setNumber((String)hmRecord.get("issue_uom_qty"),no_of_decimals);//Un used Variable
		from_multiples					=		bean.checkForNull((String)hmRecord.get("from_multiples"),"1");
		to_multiples					=		bean.checkForNull((String)hmRecord.get("to_multiples"),"1");
		batch_multiples					=		bean.checkForNull((String)hmRecord.get("batch_multiples"),"1");
		issue_uom_multiples				=		bean.checkForNull((String)hmRecord.get("issue_uom_multiples"),"1");
		item_qty						= ""+	Double.parseDouble((String)hmRecord.get("issue_uom_qty"))*Double.parseDouble((String)hmRecord.get("issue_uom_conv"));
		if((bean.getAllowDecimalsYN(item_code)).equals("Y")){
			item_qty						=		bean.setNumber(item_qty,no_of_decimals);
		}else{
			item_qty						=		bean.setNumber(item_qty,0);
		}
		kit_template_uom				=		bean.checkForNull((String)hmRecord.get("kit_template_uom"),"");
		kit_temp_code                   =       bean.checkForNull((String)hmRecord.get("kit_temp_code"),""); //01/08/12
		usage_type                      =       bean.checkForNull((String)hmRecord.get("usage_type"),""); //17/09/12
		kit_item_yn						=		bean.checkForNull((String)hmRecord.get("kit_item_yn"),"N");
		if(kit_item_yn.equals("Y")){
		display_style				=			 "display:inline";
		}else{
		display_style				=			 "display:none";
		}
		frm_store_uom_desc				=		bean.getShortDesc(item_code,store_code);
		to_store_uom_desc				=		bean.getShortDesc(item_code,(String)request.getParameter("to_store_code"));

		//HashMap hmMinMaxRecord			=		bean.getMinMaxRecord(Integer.parseInt(index));
		HashMap hmMinMaxRecord = new HashMap();

		if (BARCODE_YN.equals("TRUE")){
		hmMinMaxRecord=bean.getMinMaxRecordforBarcode(Integer.parseInt(index));
		}else{
		hmMinMaxRecord=bean.getMinMaxRecord(Integer.parseInt(index));
		}

		//frm_store_qty_on_hand			=		(String)hmRecord.get("stock_available"); // Availabe Qty has to be taken based on document no without commited qty , hmMinMaxRecord.get("frm_store_qty_on_hand") will not give doc no based available qty
		frm_store_qty_on_hand			=		(String)hmMinMaxRecord.get("frm_store_qty_on_hand"); // Availabe Qty has to be taken based on document no without commited qty , hmMinMaxRecord.get("frm_store_qty_on_hand") will not give doc no based available qty
		frm_store_min_stk_level			=		bean.checkForNull((String)hmMinMaxRecord.get("frm_store_min_stk_level"),"0");
		frm_store_max_stk_level			=		(String)hmMinMaxRecord.get("frm_store_max_stk_level");
		frm_store_reorder_level			=		bean.checkForNull((String)hmMinMaxRecord.get("frm_store_reorder_level"),"0");
		to_store_qty_on_hand			=		(String)hmMinMaxRecord.get("to_store_qty_on_hand");
		to_store_min_stk_level			=		(String)hmMinMaxRecord.get("to_store_min_stk_level");
		to_store_max_stk_level			=		(String)hmMinMaxRecord.get("to_store_max_stk_level");
		to_store_reorder_level			=		(String)hmMinMaxRecord.get("to_store_reorder_level");
		//to_store_uom_code				=		bean.getToStoreUomCode(item_code,to_store_code);
		gen_uom_code					=		bean.getGenItemUOM(item_code);

		if(((String)bean.getAccessCostDetails()).equals("Y"))
			display_flag				=		"visibility:visible";
			
			//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
		iss_item_hold_yn					=		bean.checkForNull((String)hmRecord.get("iss_item_hold_yn"),"Y");
		iss_item_hold_chk					=		bean.checkForNull((String)hmRecord.get("iss_item_hold_chk"),"N");
		iss_item_hold_qty                   =       bean.checkForNull((String)hmRecord.get("iss_item_hold_qty"),"");
		
		if(iss_item_hold_qty.equals(""))
		//iss_item_hold_qty					=		bean.setNumber((String)hmRecord.get("issue_uom_qty"),no_of_decimals);
		iss_item_hold_qty					=	    bean.setNumber((String)hmRecord.get("authorized_item_qty"),no_of_decimals);
		
		//ends
		
		//Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014 
		if(bean.getMin_Rol_yn(bean.getLoginById(),store_code)){
		 if(!frm_store_min_stk_level.equals("0")){
		   if ((Double.parseDouble(stock_available) - Double.parseDouble(iss_uom_qty))  <  Double.parseDouble(frm_store_min_stk_level)){
	    	   min_stk = true;
	        }
		   min_stk_flag = "visibility:visible"; 
		   } 
		   if(!frm_store_reorder_level.equals("0")){
	     if ((Double.parseDouble(stock_available) - Double.parseDouble(iss_uom_qty))  <  Double.parseDouble(frm_store_reorder_level)){
	    	   rol_stk = true;
	       }
	     rol_flag	   = "visibility:visible";
		  }
		} //ends
	}

/**
 * @Name - Priya
 * @Date - 18/05/2010
 * @Inc# - 
 * @Desc -  To get no of decimals for cost and assign it to 'no_of_decimals_for_cost' hidden field 
 */
	String noOfDecimalsForCost=bean.getNoOfDecimalsCost();
	//Added by sakti against ML-BRU-SCF-0963[INC#42099]	
			item_desc = item_desc.replaceAll(" ","%20");
			item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
			item_desc = item_desc.replaceAll("%2520","%20");
		//Added ends
		if(!item_desc.equals("") && !issue_history_durn.equals(""))//Added for MO-CRF-20166
	           iss_history_style          =            "visibility:visible";//Added for MOD-CRF-20166		 


 	%>
	</head>
	<body onLoad="FocusFirstElement();GoBarcode();">
	<form name="formIssueListHeader" id="formIssueListHeader">
	<table border='0' cellpadding='0' cellspacing='0' width='100%' height='50%'>
		<% if(site){//Added for GHL-CRF-0413 starts%>
		<tr>
		<td class='label'><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}" /></td>
			<td colspan=6 align=left class='label' colspan=2><input type='text' name='barcode' id='barcode'  size=80 maxLength=100 value="" onkeypress="callBarCodeBatchSearchforBarcode1(event,barcode,trn_type_barcode,parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code,parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code,this.form,'<%=bean_id%>','<%=bean_name%>','IssueListHeader','IssueListDetail','IssueDetail');" <%=codeDisabled%> ></td>	<!--Modified for IN:073577 increased size from 70 to 80 -->		
		</tr>
		<%} //Added for GHL-CRF-0413 ends%>
		<tr>
			<td class=label align=left><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<td colspan=6 align=left class='label' colspan=2>
			<input type="hidden" name="item_desc_temp" id="item_desc_temp" value="<%=item_desc%>" >
				 <!-- Code Added for #incident 41572 start -->
				<% if(site){ %>
				<input type=text name=item_desc size=70 maxlength=60 onkeypress="callBarCodeBatchSearch(event,barcode,trn_type,parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code,parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code,this.form,'<%=bean_id%>','<%=bean_name%>','IssueListHeader','IssueListDetail','IssueDetail');"    value="<%=item_desc%>" <%=codeDisabled%>>
				<input type=button name="item_search" id="item_search" class="button" <%=disabled%> onClick="callBarCodeBatchSearch(event,barcode,trn_type,parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code,parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code,this.form,'<%=bean_id%>','<%=bean_name%>','IssueListHeader','IssueListDetail','IssueDetail');"  value='?' <%=codeDisabled%> ><%=bean.getImage("M")%>
				<%}else{ %>
				<input type=text name=item_desc size=70 maxlength=60 onkeypress="callBarCodeBatchSearch(event,item_desc,trn_type,parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code,parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code,this.form,'<%=bean_id%>','<%=bean_name%>','IssueListHeader','IssueListDetail','IssueDetail');"    value="<%=item_desc%>" <%=codeDisabled%>>
				<input type=button name="item_search" id="item_search" class="button" <%=disabled%> onClick="callBarCodeBatchSearch(event,item_desc,trn_type,parent.parent.frameIssueHeader.document.formIssueHeader.from_store_code,parent.parent.frameIssueHeader.document.formIssueHeader.to_store_code,this.form,'<%=bean_id%>','<%=bean_name%>','IssueListHeader','IssueListDetail','IssueDetail');"  value='?' <%=codeDisabled%> ><%=bean.getImage("M")%>
				<%} %>
				<!--  Code Added for #incident 41572 end-->
				<input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
				<input type="hidden" name="Auth_status" id="Auth_status" value="1"><!-- // added for GHl-CRF-0465 -->
				<b><span id="id_uom"><%=stock_uom_desc%></span></b>
				<!-- Added by Rabbani#AMS-CRF-0068(49822) on 08-AUG-2014 -->
				&nbsp;
			<label id="id_min_stk_label" style="<%=min_stk_flag%>" >Min.Level:</label>
			<%if(min_stk){ %>
			<label id="id_min_str_stk" style="background-color:red;color:yellow; <%=min_stk_flag%>"  ><b><%=frm_store_min_stk_level%></b></label>
			<%}else{ %>
			<label id="id_min_str_stk" style="<%=min_stk_flag%>" ><b><%=frm_store_min_stk_level%></b></label>
			<%} %>
			&nbsp;
			<label id="id_stk_rol_label" style="<%=rol_flag%>" >ROL:</label>
			<%if(rol_stk) {%>
			<label  id="id_stk_rol" style="background-color:red;color:yellow;<%=rol_flag%>" ><b><%=frm_store_reorder_level%></b></label>
			<%}else{ %>
			<label  id="id_stk_rol"  style="<%=rol_flag%>"  ><b><%=frm_store_reorder_level%></b></label>
			<%} %> 	

			<label class="label" style = "<%=iss_history_style%>"><a name ="iss_history" id ="iss_history" class='gridLink' href="javascript:viewIssueHistory();"> <B>Issue History</B><a></label><!-- Added for MO-CRF-20166 href modified for IN19719-->
			</td>
		</tr>
		<tr>
		<td id="kit_template"  class="label" STYLE="<%=display_style%>" colspan='2' ><fmt:message key="eST.KitTemplateUOM.label" bundle="${st_labels}"/> 
				
		&nbsp;&nbsp;<input type="text" name="kit_template_uom" id="kit_template_uom" value="<%=kit_template_uom%>" size="10"readonly>
			</td>
		</tr>
		<tr>
			<td class=label align=left width=80><fmt:message key="eST.IssueUOM.label" bundle="${st_labels}"/></td>
		<%
			if(!stButtonLegend.equals(stModifyLegend)){
		%>
			<td class='label' width=170>
				<select name='iss_uom_code' id='iss_uom_code' onchange = "calculateConversion();" onBlur="checkUOMConvFactor();" <%=codeDisabled%>>
					<option>&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>	---&nbsp;&nbsp;&nbsp;&nbsp;
					</option>
				</select><img src="../../eCommon/images/mandatory.gif" align=center>
			</td>
			<td class='label' ><fmt:message key="eST.ConvFactorRule.label" bundle="${st_labels}"/>:</td>
			<td class='label'><label id="id_iss_uom_conv" align="right"><%=iss_uom_conv_text%></label></td>
		<%}else{
		%>	
			<td class='label' width=170><select name='iss_uom_code' id='iss_uom_code' onchange = "calculateConversion();" onBlur="checkUOMConvFactor();"  <%=codeDisabled%> ><%=bean.getPur_uom_code_Modify_List(gen_uom_code,iss_uom_code,item_code)%></select><img src="../../eCommon/images/mandatory.gif" align=center></td>
			<td class='label'><fmt:message key="eST.ConvFactorRule.label" bundle="${st_labels}"/>:</td>	

			<td class='label' align="right">&nbsp;&nbsp;&nbsp;<label id="id_iss_uom_conv"><%=iss_uom_conv_text%></label></td>
		<%}%>
		
			<td  class="label"><fmt:message key="eST.IssueUOMQuantity.label" bundle="${st_labels}"/>&nbsp;</td>
			<td class='label'><input type="text" name="iss_uom_qty" id="iss_uom_qty" size=10 maxlength=12 class="NUMBER" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);"  onBlur="valueChange(this);checkDoubleFormat(this);calIssueQty();checkminmaxstatus();return CheckQuantity();" value="<%=iss_uom_qty%>" <%=Qty_disabled%>>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
		</tr>
		<tr>
			<td class='label' align="left"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td class="label"><input type=text name=item_qty id=item_qty size=10 maxlength=15 class="NUMBER" value="<%=item_qty%>" disabled><%=bean.getImage("M")%><b><span id = "uom_desc" width=60><%=uom%></span></b></td>&nbsp;&nbsp;
			<td class='label' ><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/>:</td>
			<td class= 'label' align="left"><label id="id_stock_available" align="right"><%=stock_available%></label></td>
			<td class='label' align='left'><label id="id_item_unit_cost_label" style=<%=display_flag%>><fmt:message key="Common.Cost.label" bundle="${common_labels}"/>:</label>
			<label id="id_item_unit_cost" style=<%=display_flag%>><%=item_unit_cost%></label></td>
			<td align=left   class='label'><label id="id_item_sal_value_label" style=<%=display_flag%>><fmt:message key="Common.Value.label" bundle="${common_labels}"/>:&nbsp;</label><label id="id_item_sal_value" style=<%=display_flag%>><%=item_sal_value%></label></td>
		</tr>
		 <tr>
			<td class=label align=left><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td colspan=6 align=left class='label'><textarea rows=2 cols=60 name="remarks" onKeyPress="return false;"  ><%=remarks%></textarea><input type="hidden" name="remarks_code" id="remarks_code" value = "<%=remarks_code%>" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code,remarks);" ><img id ="remarks_mandatory" src="../../eCommon/images/mandatory.gif" align=center style ="<%=imgMandatory%>"></td>

 		<script>
		//alert(parent.parent.frameIssueHeader.document.formIssueHeader.trn_type.value );
		if(parent.parent.frameIssueHeader.document.formIssueHeader.trn_type.value=="ISS"){
			document.formIssueListHeader.remarks.disabled=false;
			document.formIssueListHeader.remark.disabled=false;
		}
		if(parent.parent.frameIssueHeader.document.formIssueHeader.trn_type.value=="URG"){
			//document.formIssueListHeader.remark.disabled=true;
		}
		</script>
			</tr>
	</table>
	<table border="0" cellspacing="0" cellpadding="2" width="100%"> 
			<tr>
				<!-- <td colspan = '8' class ="label">&nbsp;</td> -->
			</tr>
		<tr>
			<td class='label'>&nbsp;</td>
		<td class=label align=left colspan='7'><input type=button name="edit" id="edit" value='<fmt:message key="eST.Edit/View.label" bundle="${st_labels}"/>' class=button onclick="editViewBatch();"<%=codeDisabled%>>
		<input type=button name=batchsearch value='<fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"/>' class=button onclick="callBatchSearch();"  <%= BARCODE_YN.equals("TRUE") && !site && mode1.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))?codeDisabled:""%> >
		<%if(site){//Added for GHL-CRF-0413.2 starts %>
			<input type=button name="apply" id="apply" value="<%=stButtonLegend%>" class=button onclick= " addToListforBarCode('<%=bean_id%>','<%=bean_name%>  ',parent.parent.frameIssueHeader.document.formIssueHeader.barcode_applicable1,'IssueListHeader','IssueListDetail','IssueDetail');">
		<%}else{ //Added for GHL-CRF-0413.2 starts%>
			<input type=button name="apply" id="apply" value="<%=stButtonLegend%>" class=button onclick= "calIssueQty(); addToListforBarCode('<%=bean_id%>','<%=bean_name%>  ',parent.parent.frameIssueHeader.document.formIssueHeader.barcode_applicable1,'IssueListHeader','IssueListDetail','IssueDetail');">
		<%} %>
		<input type=button name=Cancel value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class=button onclick="cancel_me();">
			<input class="button" type="button" name="ItemDetails" id="ItemDetails" value='<fmt:message key="eST.StockLevel.label" bundle="${st_labels}"/>' onClick="ItemDetail();" <%=disable_add%>></td>
		</tr>
	</table>
		<input type="hidden"	name="stock_item_yn" id="stock_item_yn"						value="Y"><!-- Modified for IN073190 -->
		<input type="hidden"	name="store_code" id="store_code"							value="<%=store_code%>">
		<input type="hidden"	name="expiry_yn" id="expiry_yn"							value="<%=expiry_yn%>">
		<input type="hidden"	name="doc_srl_no" id="doc_srl_no"							value="<%=doc_srl_no%>">
		<input type="hidden"	name="uom_code" id="uom_code"								value="<%=uom_code%>">
		<input type="hidden"	name="index" id="index"								value="<%=index%>">
		<input type="hidden"	name="for_bin_to_store_hidden" id="for_bin_to_store_hidden"				value="<%=for_bin_to_store_hidden%>">
		<input type="hidden"	name="iss_conv_fact" id="iss_conv_fact"						value="<%=iss_conv_fact%>">
		<input type="hidden"	name="item_unit_cost" id="item_unit_cost"						value="<%=item_unit_cost%>">
		<input type="hidden"	name="set_flag" id="set_flag"								value="">
		<input type="hidden"	name="frm_store_qty_on_hand" id="frm_store_qty_on_hand"				value="<%=frm_store_qty_on_hand%>">
		<input type="hidden"	name="frm_store_min_stk_level" id="frm_store_min_stk_level"				value="<%=frm_store_min_stk_level%>">
		<input type="hidden"	name="frm_store_max_stk_level" id="frm_store_max_stk_level"				value="<%=frm_store_max_stk_level%>">
		<input type="hidden"	name="frm_store_reorder_level" id="frm_store_reorder_level"				value="<%=frm_store_reorder_level%>">
		<input type="hidden"	name="to_store_qty_on_hand" id="to_store_qty_on_hand"					value="<%=to_store_qty_on_hand%>">
		<input type="hidden"	name="frm_store_uom_desc" id="frm_store_uom_desc"					value="<%=frm_store_uom_desc%>">
		<input type="hidden"	name="to_store_uom_desc" id="to_store_uom_desc"					value="<%=to_store_uom_desc%>">
		<input type="hidden"	name="to_store_min_stk_level" id="to_store_min_stk_level"				value="<%=to_store_min_stk_level%>">
		<input type="hidden"	name="to_store_max_stk_level" id="to_store_max_stk_level"				value="<%=to_store_max_stk_level%>">
		<input type="hidden"	name="to_store_reorder_level" id="to_store_reorder_level"				value="<%=to_store_reorder_level%>">
		<input type="hidden"	name="to_store_uom_code" id="to_store_uom_code"					value="<%=to_store_uom_code%>">
		<input type="hidden"	name="to_store_code" id="to_store_code"						value="">
		<input type="hidden"	name="tmp_conv" id="tmp_conv"								value="">
		<input type="hidden"	name="frm_conv_fact" id="frm_conv_fact"						value="">
		<input type="hidden"	name="kit" id="kit"									value="">
		<input type="hidden"	name="iss_uom_conv" id="iss_uom_conv"							value="<%=iss_conv_fact%>">
		<input type="hidden"	name="iss_uom_qty_chk" id="iss_uom_qty_chk"						value="<%=iss_uom_qty%>">
		<input type="hidden"	name="phy_inv_id" id="phy_inv_id"							value="">
		<input type="hidden"	name="doc_qty" id="doc_qty"								value="">
		<input type="hidden"	name="lang_id" id="lang_id"								value="<%=locale%>">
		<input type="hidden"	name="mode" id="mode"									value="<%=mode%>">
		<input type="hidden"	name="rem_trans_type" id="rem_trans_type"						value="ISS">
		<input type="hidden"	name="kit_item_yn" id="kit_item_yn"							value="<%=kit_item_yn%>">
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
		<input type="hidden"	name="bean_trans_type_1" id="bean_trans_type_1"						value='<%=bean.checkForNull(bean.getTrnTypeForRemarks(bean.checkForNull(bean.getDoc_no(),"")),"")%>'>
		<input type="hidden" name="from_multiples" id="from_multiples"							value="<%=from_multiples%>">
		<input type="hidden" name="to_multiples" id="to_multiples"							value="<%=to_multiples%>">
		<input type="hidden" name="batch_multiples" id="batch_multiples"							value="<%=batch_multiples%>">
		<input type="hidden" name="issue_uom_multiples" id="issue_uom_multiples"						value="<%=issue_uom_multiples%>">
		<input type="hidden" name="barcode_scanned_yn" id="barcode_scanned_yn"						value="<%=bean.checkForNull(request.getParameter("barcode_scanned_yn"),"N")%>">
		
		
<!-- 	/**
	* @Name - Mahesh
	* @Date - 20/01/2010
	* @Inc# - IN015496
	* @Desc - Code added to accept decimal values dynamically.
	*/

 -->	
		<input type="hidden" name="dec_allowed_yn" id="dec_allowed_yn" value="<%=bean.getAllowDecimalsYN(item_code)%>">
		<input type="hidden" name="no_of_decimals" id="no_of_decimals" value="<%=no_of_decimals%>">
		<input type="hidden" name="no_of_decimals_for_cost" id="no_of_decimals_for_cost" value='<%=noOfDecimalsForCost%>'>


		<input type="hidden"    name="trn_type" id="trn_type"							    value='<%=trn_type%>' >
		<input type="hidden"    name="BARCODE_YN" id="BARCODE_YN"							    value='<%=BARCODE_YN%>' >
		<input type="hidden"    name="barcode_applicable" id="barcode_applicable"					value="<%=barcode_applicable%>" >
		<input type="hidden"    name="bar_or_item_code" id="bar_or_item_code"						value="" >
		<input type="hidden"    name="billable_item_yn" id="billable_item_yn"				value="" ><!--dummy-->
		<input type="hidden"    name="sale_req_qty" id="sale_req_qty"				value="" ><!--dummy-->
        <input type="hidden"  name="kit_temp_code" id="kit_temp_code"	          value="<%=kit_temp_code%>" >
		<input type="hidden"  name="usage_type" id="usage_type"	                    value="<%=usage_type%>" >
		<input type="hidden"  name="noofbatchesforbarcode" id="noofbatchesforbarcode"	value="1" >
		
		<!--  Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014 -->
		<input type="hidden" name="iss_item_hold_yn" id="iss_item_hold_yn"		 value="<%=iss_item_hold_yn%>">
		<input type="hidden" name="iss_item_hold_chk" id="iss_item_hold_chk"		 value = "<%=iss_item_hold_chk %>">
		<input type="hidden" name="iss_item_hold_qty" id="iss_item_hold_qty"		 value = "<%=iss_item_hold_qty %>">
		<!-- ends -->
		<input type="hidden"    name="site" id="site"	 value="<%=site%>"><!--Added against GHL-CRF-0413 -->
		<input type="hidden"    name="trn_type_barcode" id="trn_type_barcode"	 value="<%=trn_type_barcode%>"><!--Added against GHL-CRF-0413.2-US002 -->
		<input type="hidden"    name="auth_qty" id="auth_qty"	 value="<%=auth_qty%>"><!--Added against GHL-CRF-0413.2-US002 -->
		<input type="hidden"   name="auth_qty_1" id="auth_qty_1"  value =""><!-- Added against GHL-CRF-0465-->
			<input type="hidden"   name="issue_qty_1" id="issue_qty_1"  value =""><!-- Added against GHL-CRF-0465-->
		<input type="hidden"   name="issue_history_durn" id="issue_history_durn"  value ="<%=issue_history_durn%>"><!-- Added against MOD-CRF-20166-->
	</form>
	<script>
	if(parent.parent.frameIssueHeader.document.formIssueHeader.trn_type!= null)
	{
		if(parent.parent.frameIssueHeader.document.formIssueHeader.trn_type.value !=null)
		{
			if(parent.parent.frameIssueHeader.document.formIssueHeader.trn_type.value == "URG" && document.formIssueListHeader.item_code.value == ""){
				document.formIssueListHeader.item_search.disabled=false;
			}
			else{
				document.formIssueListHeader.item_search.disabled=true;
			}
		 }
	}
	if(document.formIssueListHeader.item_search.disabled==false)
		document.formIssueListHeader.item_search.focus();
		</script>
<% 
	putObjectInBean("issueBean",bean,request);
%>
</body>
</html>
<script>
Setitemdesc(document.formIssueListHeader.item_desc_temp);
</script>


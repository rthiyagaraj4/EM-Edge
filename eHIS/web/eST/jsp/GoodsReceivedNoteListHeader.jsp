<!DOCTYPE html>
<%@page import="eMM.ItemMasterBean"%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
19/04/2016		4708			B.Badmavathi						GRN Validation removed for UOM for KAUH		
19/05/2017		62881			B.Badmavathi						Unit Cost Mandatory in GRN 
22/4/2021		TFS:14012		Shazana			22/4/2021	   Manickam		MO-CRF-20165 
9/2/2022				TFS28606				Shazana						MO-CRF-20178  
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page  import=" eST.GoodsReceivedNoteBean,eST.Common.StHeaderBean,webbeans.eCommon.*,java.sql.* ,java.util.HashMap, eMM.*"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale				= (String)session.getAttribute("LOCALE");
		String sStyle				=  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script> <!-- added for MO-CRF-20165 -->
	<script language="JavaScript" src="../../eST/js/GoodsReceivedNote.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
	GoodsReceivedNoteBean bean		=	(GoodsReceivedNoteBean) getBeanObject( "goodsReceivedNoteBean", "eST.GoodsReceivedNoteBean" ,request   );
	StHeaderBean stbean				=	(StHeaderBean) getBeanObject( "StHeaderBean", "eST.Common.StHeaderBean" ,request   );
	//Added by B.Badmavathi against KAUH-SCF-0249 STARTS
	Connection con				= null;
	con						= ConnectionManager.getConnection(request);
	boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "MM","MM_GRN");
	bean.setSite_spec_yn(site_main);
	//Added by B.Badmavathi against KAUH-SCF-0249 ENDS
//	Added by B.Badmavathi against GDOH-CRF-0109 STARTS
	boolean check_uc = eCommon.Common.CommonBean.isSiteSpecific(con, "MM","MM_UNIT_COST_MANDATORY_GRN");
	boolean grn_newfields_applicable = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_GRN_NEW_FIELDS");//Added for MO-CRF-20165 
	String item_2d_barcode_yn =bean.barcode2DApplicable();//Added for MOHE-CRF-0167
	String visibilityUnitCost			= 	"";
	if(check_uc)
		visibilityUnitCost =	"visible";	
	else
		visibilityUnitCost =	"hidden";
//	Added by B.Badmavathi against GDOH-CRF-0109 ENDS
	bean.setLanguageId(locale);
	String store_code				=	bean.getStore_code();
	
	String stButtonLegend			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");

	String index					=	bean.checkForNull(request.getParameter("index"),"-1");
	String doc_srl_no				=	bean.checkForNull(request.getParameter("doc_srl_no"),"-1");

	String item_code				=	"";
	String item_desc				=	"";
	String uom						=	"";
	String uom_code					=	"";
	String pur_uom_code				=	"";
	String item_qty_normal			=	"";
	String item_qty_bonus			=	"";
	String item_qty_sample			=	"";
	String item_cost_value			=	"";
	String replace_on_expiry_yn		=	"N";
	String label_reqd_yn			=	"N";
	String expiry_yn				=	"";
	String pur_uom_conv				=	"";
	String store_item_unit_cost		=	"";
	String codeDisabled				=	"";
	String codeDisabled1			=	"";
	String dis_expiry_yn			=	"";
	String no_of_labels				=	"";
	String grn_unit_cost_in_pur_uom	=	"";
	String po_cost					=	"";
	String po_discount				=	"";
	String po_tax					=	"";
	String rate_disabled			=	"";
	String dis						=	"";
	String allow_deci_yn            =    "";
	String pur_uom_conv_id           =    "";
	String remarks_desc           = ""; //added for MO-CRF-20165 
	String catalog_code ="";
	String manufacture_id="";
	String manufacturer_disabled	=  ""; //END 
	String manufac_remarks_disabled = "";  //MO-CRF-20178 
	String manufac_remarks = "";//MO-CRF-20178  
	int no_deci                   =    bean.getNoOfDecimals();
	String visibilityBonus			=	((String)bean.getMmParameter().get("RECEIVE_BONUS_YN")).equals("Y")?"visible":"hidden";	
	String visibilitySample			=	((String)bean.getMmParameter().get("RECEIVE_SAMPLE_YN")).equals("Y")?"visible":"hidden";	
	double effective_qty=0.0;
	double item_qty=0.0;
	double ordered_qty = 0.0;
	String delivery_date = "";

	String conversion_rate = bean.checkForNull(request.getParameter("conversion_rate"));
	String po_unit_cost_in_pur_uom	=	"";

	String mode = bean.getMode();

	String by_po = "";
	String QtyDisabled				=	"";
	String delv_date_override_yn	=	"";
	String price_override_yn		=	"";

	int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());	

	HashMap hmTemp	=	(HashMap)bean.fetchRecord("SELECT PO_DETAILS_APPLICABLE_YN,PO_INTERFACE_YN FROM ST_ACC_ENTITY_PARAM");
	
	String  po_details_applicable_yn	=	bean.checkForNull((String)hmTemp.get("PO_DETAILS_APPLICABLE_YN"),"N");
	String po_interface_yn				=   bean.checkForNull((String)hmTemp.get("PO_INTERFACE_YN"),"N");
		
	 if(po_interface_yn.equals("Y")){
	 
	 HashMap PO_Override				=	bean.fetchRecord(bean.getStRepositoryValue("SQL_PO_PARAMETER_OVERRIDE_ALLOW"));

	 delv_date_override_yn	=	bean.checkForNull((String)PO_Override.get("ALLOW_OVERRIDE_PO_DLVDT"),"N");
	 price_override_yn		=	bean.checkForNull((String)PO_Override.get("ALLOW_PRICE_OVERRIDE_IN_GRN"),"N");
	 }


	if(!index.equals("-1")){

		HashMap hmRecord			=	bean.getDtlRecord(Integer.parseInt(index));

		System.out.println("hmRecord------71----"+hmRecord);


		stButtonLegend				=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		

		doc_srl_no					=	(String)hmRecord.get("doc_srl_no");
		item_code					=	(String)hmRecord.get("item_code");
		item_desc					=	(String)hmRecord.get("item_desc");
		uom							=	(String)hmRecord.get("uom_desc");
		uom_code					=	(String)hmRecord.get("uom_code");
		pur_uom_code				=	(String)hmRecord.get("pur_uom_code"); 
		manufacture_id              =   bean.checkForNull((String)hmRecord.get("manufacturer_id"),""); //Added for MO-CRF-20165 
		remarks_desc                =  	bean.checkForNull((String)hmRecord.get("remarks_desc"),"");
		catalog_code				=  bean.checkForNull((String)hmRecord.get("catalog_code"),"");
		manufac_remarks 			= bean.checkForNull((String)hmRecord.get("manufac_remarks"),"");//MO-CRF-20178    
		bean.setItemRemarks(remarks_desc); //end   

		by_po						=	bean.checkForNull((String)hmRecord.get("by_po"),"N");

		
		if((bean.getAllowDecimalsYN(item_code)).equals("N")){
			no_deci = 0;
		}
		item_qty_normal				=	(bean.checkForNull((String)hmRecord.get("item_qty_normal")).equals(""))?"":bean.setNumber((String)hmRecord.get("item_qty_normal"),no_deci);
		item_qty_bonus				=	(bean.checkForNull((String)hmRecord.get("item_qty_bonus")).equals(""))?"":bean.setNumber((String)hmRecord.get("item_qty_bonus"),no_deci);
		item_qty_sample				=	(bean.checkForNull((String)hmRecord.get("item_qty_sample")).equals(""))?"":bean.setNumber((String)hmRecord.get("item_qty_sample"),no_deci);
		item_cost_value				=	(String)hmRecord.get("item_cost_value");
		replace_on_expiry_yn		=	bean.checkForNull((String)hmRecord.get("replace_on_expiry_yn"),"N");
		label_reqd_yn				=	bean.checkForNull((String)hmRecord.get("label_reqd_yn"),"N");
		expiry_yn					=	(String)hmRecord.get("expiry_yn");   
        allow_deci_yn               =   (String)hmRecord.get("allow_deci_yn");
      
		no_of_labels				=	bean.checkForNull((String)hmRecord.get("no_of_labels")); 	
		
		// Check For Null is added for the Interface Work By Ramana CV on 8/14/2009
		grn_unit_cost_in_pur_uom	=	bean.checkForNull((String)hmRecord.get("grn_unit_cost_in_pur_uom"),"");     
		po_unit_cost_in_pur_uom	=	bean.checkForNull((String)hmRecord.get("grn_unit_cost_in_pur_uom"),"");     
		po_cost						=	bean.checkForNull((String)hmRecord.get("po_cost"));     
		po_discount					=	bean.checkForNull((String)hmRecord.get("po_discount"));     
		po_tax						=	bean.checkForNull((String)hmRecord.get("po_tax"));  
		
		if(hmRecord.containsKey("ordered_qty"))
		ordered_qty   =		Double.parseDouble(bean.checkForNull((String)hmRecord.get("ordered_qty")));

		delivery_date = 	 bean.checkForNull((String)hmRecord.get("delivery_date"));  
		conversion_rate =	 bean.checkForNull(conversion_rate,bean.checkForNull((String)hmRecord.get("conversion_rate")));
	
		if (!((!bean.checkForNull(item_qty_normal,"0").equals("0"))&&bean.checkForNull(item_qty_bonus,"0").equals("0")&&bean.checkForNull(item_qty_sample,"0").equals("0"))) {
			rate_disabled			=	"disabled";
		}
		if (!item_qty_normal.equals("")) {
			effective_qty+=Double.parseDouble(item_qty_normal);
		}
		if (!item_qty_bonus.equals("")) {
			effective_qty+=Double.parseDouble(item_qty_bonus);
		}
		if (no_of_labels.equals("")){
			no_of_labels=""+effective_qty;
		}
		
		double item_value = 0;			
		if(po_interface_yn.equals("Y") && by_po.equals("Y")){
			item_value = (effective_qty * Double.parseDouble(grn_unit_cost_in_pur_uom) * Double.parseDouble(bean.checkForNull(conversion_rate,"1")));
		}else{
			item_value = (effective_qty * Double.parseDouble(grn_unit_cost_in_pur_uom));
		}

		item_cost_value=bean.setNumber((""+item_value),noOfDecimalsForCost);
		

		if (effective_qty!=0 && grn_unit_cost_in_pur_uom.equals("")) {
			double unit_cost		=	Double.parseDouble(item_cost_value)/effective_qty;
			grn_unit_cost_in_pur_uom=bean.setNumber((""+unit_cost),noOfDecimalsForCost);
		}else if(effective_qty!=0 && po_interface_yn.equals("Y")){
			double unit_cost1		=	Double.parseDouble(item_cost_value)/effective_qty;
			grn_unit_cost_in_pur_uom=bean.setNumber((""+unit_cost1),noOfDecimalsForCost);
		}

		if( (replace_on_expiry_yn).equals("N") && (expiry_yn).equals("N") )
			dis_expiry_yn			=	"disabled";

		store_item_unit_cost	=	(String)hmRecord.get("store_item_unit_cost");
		pur_uom_conv			=	(String)hmRecord.get("pur_uom_conv");
		pur_uom_conv_id			=	(String)hmRecord.get("pur_uom_conv_id");
		
		if(pur_uom_conv.equals(pur_uom_conv_id)){
			pur_uom_conv_id=pur_uom_conv;
		}
		if(by_po.equals("N")){
			codeDisabled			=	"disabled";
		}
		codeDisabled1			=	"disabled";


		if(po_interface_yn.equals("Y")){
			QtyDisabled				=	"disabled";	
		}
	}


		if(po_interface_yn.equals("Y")){
		po_details_applicable_yn = "N";
		}

		if(po_details_applicable_yn.equals("Y")){
			if(!((String)bean.checkForNull(po_cost)).equals(""))
				dis = "disabled";
		}
	
		String item_disabled			=	request.getParameter("item_disabled")==null?"":request.getParameter("item_disabled");
	
		if(!((String)bean.checkForNull(bean.getPo_no())).equals("") && po_interface_yn.equals("N"))
		item_disabled="disabled";
		
		if(!index.equals("-1")){ //added for MO-CRF-20165 TFS:19215
			manufacturer_disabled =""; 
		}else{
			if(manufacture_id==null || manufacture_id.trim().equals("")){//MO-CRF-20165 START
				manufacturer_disabled = "disabled" ;
			}
			else{
				manufacturer_disabled="" ;
			} 
		}//END
		
		/*if(mode.equals("2")){
			manufac_remarks_disabled = "";//MO-CRF-20178 
			if(manufac_remarks==null || manufac_remarks.equals("")){
				manufac_remarks_disabled = "";  
			}else{
				manufac_remarks_disabled = "disabled";  	
			}
		}*/
		//MO-CRF-20178 

	%>
	</head>
	<body onload() onLoad="batchdisable();">
	<form name="formGoodsReceivedNoteListHeader" id="formGoodsReceivedNoteListHeader">
	<%try{%>
		<table border='0' cellpadding='2' cellspacing='0' width='100%' height='100%'>
		<% if(item_2d_barcode_yn.equals("Y")){//Added for MOHE-CRF-0167 starts%>
		<tr>
		<td class='label'><fmt:message key="eST.BarcodeId.label" bundle="${st_labels}" /></td>
			<td  align='left' class='fields' colspan='2'><input type='text' name='barcode' id='barcode'  size="50" maxLength="100" value="" onkeypress="getGTINDetails(event,barcode);"  ></td>			
		</tr>
		<%} //Added for MOHE-CRF-0167 ends%>
		<tr>
			<td class='label' ><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<td colspan='5' class='fields'> <input type='text' name='item_desc' id='item_desc' size='50' maxlength=60 value="<%=item_desc%>" <%=codeDisabled1%>><input type='button' name="item_search" id="item_search" class="button" onClick="callItemSearchScreen();batchdisable();"  value='?' <%=codeDisabled1%> <%=item_disabled%>><%=bean.getImage("M")%><input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
			<b><span id="id_uom" class='label'><%=uom%></span></b></td>
			<!--Added By Rabbani #inc no:27056 on 13/10/11-->
			<!-- added for MO-CRF-20165 START-->
			<%if(grn_newfields_applicable){ %>
			<td class='label' ><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></td> 
			<td class='fields'><select name="manufacturer_id" id="manufacturer_id"  <%=manufacturer_disabled%> ><option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>	
			<%
				ArrayList	arrManu				=	null;
				HashMap		hmManu				=	null;	
				String code = "";
				String	desc  = "";
				String Manu_select				=	"";
				//arrManu =	bean.getManufactureList();
				arrManu =	bean.getDropDownList("MANU"); 
				int arrLength	=	arrManu.size();%>
				<% 
				for(int i=0;i<arrLength; i++)
				{
					hmManu		=	(HashMap) arrManu.get(i);

					code				=	(String)hmManu.get("code");
					desc				=	(String)hmManu.get("desc");
					if(code.trim().equals(manufacture_id))
					{
						Manu_select		=	"Selected";
					}
					else
						Manu_select		=	"";
					%>
					
						<option value="<%=code%>" <%=Manu_select%> ><%=desc%></option>
					<%
				} 					
			%>
			</select> </td>
			<td> <textarea name="manufac_remarks"  rows="2" cols="25"  onKeyPress="checkMaxLimit(this,250);" onblur="checkManuRemarksLength(this);" <%=manufac_remarks_disabled%>><%=manufac_remarks%></textarea> </td>  <!-- MO-CRF-20178 -->
			<%} %> <!-- ADDED FOR MO-CRF-20165 END --> 
			<td><input type='button' name='batchsearch' id='batchsearch' value='<fmt:message key="eST.BatchSearch.label" bundle="${st_labels}"  />' class='button'     onclick= "callBatchSearchScreen();"></td>
		</tr>
		<tr>
		<%if(grn_newfields_applicable){ %><!-- MO-CRF-20165 -->
			<td class='label' colspan="3"><fmt:message key="eST.NormalQty.label" bundle="${st_labels}"/></td>
			<%}else { %>
			<td class='label' ><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></td>
			<%} %>
			<!-- 		
			* @Name - Priya
			* @Date - 10/02/2010
			* @Inc# - 19092 
			* @Desc - No.of Decimals is passed to isValidNumber function and in onblur  checkdoubleformat is called.			
		-->
			<td  class='fields'><input type='text' name='item_qty_normal' id='item_qty_normal' size='13' maxlength='13' class="NUMBER" onKeyPress="return isValidNumber(this,event,8,<%=no_deci%>);" onBlur="checkDoubleFormat(this);calculateValue();"  value="<%=item_qty_normal%>"  <%=QtyDisabled%>></td>
			<%if(grn_newfields_applicable){ %><!-- MO-CRF-20165 -->
			<td class='label' ><span style="visibility:<%=visibilityBonus%>"><fmt:message key="eST.BonusQty.label" bundle="${st_labels}"/></span></td>
			<%}else { %>
			<td class='label' ><span style="visibility:<%=visibilityBonus%>"><fmt:message key="eST.Bonus.label" bundle="${st_labels}"/></span></td>
			<%} %> 
			<!-- 		
			* @Name - Priya
			* @Date - 10/02/2010
			* @Inc# - 19092 
			* @Desc - No.of Decimals is passed to isValidNumber function and in onblur  checkdoubleformat is called.			
			-->
			<td class='fields'><span style="visibility:<%=visibilityBonus%>"><input type='text' name='item_qty_bonus' id='item_qty_bonus' size='13' maxlength='13' class="NUMBER" onKeyPress="return isValidNumber(this,event,8,<%=no_deci%>);" onBlur="checkDoubleFormat(this);calculateValue();"  value="<%=item_qty_bonus%>"></span></td>
			<%if(grn_newfields_applicable){ %><!-- MO-CRF-20165 -->
			<td class='label' ><span style="visibility:<%=visibilitySample%>"><fmt:message key="eST.SampleQty.label" bundle="${st_labels}"/></span></td>
			<%}else { %>
			<td class='label' ><span style="visibility:<%=visibilitySample%>"><fmt:message key="eST.Sample.label" bundle="${st_labels}"/></span></td> 
			<%} %> 
			<!-- 		
			* @Name - Priya
			* @Date - 10/02/2010
			* @Inc# - 19092 
			* @Desc - No.of Decimals is passed to isValidNumber function and in onblur  checkdoubleformat is called.			
		-->
			<td class='fields' colspan="5"><span style="visibility:<%=visibilitySample%>"><input type='text' name='item_qty_sample' id='item_qty_sample' size=13 maxlength=13 class="NUMBER" onKeyPress="return isValidNumber(this,event,8,<%=no_deci%>);"  value="<%=item_qty_sample%>" onBlur="checkDoubleFormat(this);calculateValue();" ></span></td>
			
		</tr>
		<%if(po_details_applicable_yn.equals("Y")){%>
			<tr>
				<!-- 		
			* @Name - Priya
			* @Date - 11/02/2010
			* @Inc# - 19088 
			* @Desc - The precision for the field 'po_cost' is changed to 8,noOfDecimalsForCost			
		-->
				<td class='label' ><fmt:message key="eST.POCost.label" bundle="${st_labels}"/></td>
				<td  class='fields'><input type='text' name='po_cost' id='po_cost' size="<%=Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" class="NUMBER" onKeyPress="return isValidNumberCost(this,event,8,<%=noOfDecimalsForCost%>);" onBlur="calculatePoCost(this);calculateValue();checkDoubleFormat(this, false);"  value="<%=po_cost.equals("")?"":bean.setNumber(po_cost,noOfDecimalsForCost)%>"></td>

				<td class='label' ><fmt:message key="eST.PODiscount.label" bundle="${st_labels}"/></td>
				<td  class='fields'><input type='text' name='po_discount' id='po_discount' size="<%=Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" class="NUMBER" onKeyPress="return isValidNumberCost(this,event,12,<%=noOfDecimalsForCost%>);" onBlur="calculatePoCost(this);calculateValue();checkDoubleFormat(this, false);"  value="<%=po_discount.equals("")?"":bean.setNumber(po_discount,noOfDecimalsForCost)%>"></td>
				<td class='label' ><fmt:message key="eST.Tax.label" bundle="${st_labels}"/> %</td>
				<td  class='fields'>
					<!-- 		
			* @Name - Priya
			* @Date - 11/02/2010
			* @Inc# - 19088 
			* @Desc - The precision for the field 'po_tax' is changed to 6,noOfDecimalsForCost			
		-->
				<input type='text' name='po_tax' id='po_tax' size="<%=Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" class="NUMBER" onKeyPress="return isValidNumberCost(this,event,6,<%=noOfDecimalsForCost%>);" onBlur="calculatePoCost(this);calculateValue();checkDoubleFormat(this, false);"  value="<%=po_tax.equals("")?"":bean.setNumber(po_tax,noOfDecimalsForCost)%>"></td>
				
			</tr>
		<%}%>
		<tr>
			<td class='label' ><fmt:message key="Common.UnitCost.label" bundle="${common_labels}"/></td>
			<td  class='fields'>
				<!-- 		
			* @Name - Priya
			* @Date - 11/02/2010
			* @Inc# - 19088 
			* @Desc - The precision for the field 'user_grn_unit_cost_in_pur_uom' is changed to 8,noOfDecimalsForCost			
		-->
			<input type='text' name='user_grn_unit_cost_in_pur_uom'  id='user_grn_unit_cost_in_pur_uom' size="<%=Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" class="NUMBER" onKeyPress="return isValidNumberCost(this,event,8,<%=noOfDecimalsForCost%>);"  onBlur="setPOCost(this);calculateValue();checkDoubleFormat(this, false);"  value="<%=bean.setNumber(grn_unit_cost_in_pur_uom,noOfDecimalsForCost)%>" <%=rate_disabled%> <%=dis%> onChange="grn_unit_cost_in_pur_uom.value=this.value;">
				<span style="visibility:<%=visibilityUnitCost%>"><IMG id='unit_cost_mandatory'  src="../../eCommon/images/mandatory.gif" > <!-- Added against GDOH-CRF-0109 -->
			<input type="hidden" name="grn_unit_cost_in_pur_uom" id="grn_unit_cost_in_pur_uom" value="<%=bean.setNumber(grn_unit_cost_in_pur_uom,noOfDecimalsForCost)%>" ></td>
			<td class='label' ><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
			<td class='fields' colspan="2"><input type='text' name='item_cost_value' id='item_cost_value' size="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" class="NUMBER" onKeyPress="return isValidNumberCost(this,event,12,<%=noOfDecimalsForCost%>);" onBlur="calculateCost();checkDoubleFormat(this, false);"  value="<%=item_cost_value%>" <%=dis%>></td>
			<td colspan='2'></td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.Label.label" bundle="${common_labels}"/></td>
			<td  class='label' colspan='2'>
			<table border='0' cellpadding=2 cellspacing=0 width='100%' align='center'>
			<tr><td class='fields'><input type="checkbox" name='label_reqd_yn' id='label_reqd_yn' value='Y' <%=bean.getChecked(label_reqd_yn)%> onClick="no_of_labels.disabled=!this.checked">
			</td>
			<td  class='label'><fmt:message key="eST.NoofLabels.label" bundle="${st_labels}"/></td>
			</tr>
			</table>
			</td>
			<td  colspan='2'>
			<table border='0' cellpadding=2 cellspacing=0 width='100%' align=center>
			<tr><td>
			<input type='text' name='no_of_labels' id='no_of_labels' size=10 maxlength=10 class="NUMBER" onKeyPress="return isValidInteger();"  value="<%=no_of_labels%>" onBlur="checkIntegerFormat(this, false);" <%=label_reqd_yn.equals("N")?"disabled":""%>></td>
			<td class='label' ><fmt:message key="eST.Replonexpiry.label" bundle="${st_labels}"/></td>
			</tr>
			</table>
			</td>
			<td class='fields' colspan="5"><input type="checkbox" name='replace_on_expiry_yn' id='replace_on_expiry_yn' value='Y' <%=bean.getChecked(replace_on_expiry_yn)%> <%=dis_expiry_yn%> ></td>
		</tr>

		<tr><!-- ADDED FOR MO-CRF-20165 START -->
		<%if(grn_newfields_applicable){ %>
			<td class='label' ><fmt:message key="eST.Catalogue.label" bundle="${st_labels}"/></td>   
			<td colspan=3 class='fields'><select name="catalog_code" id="catalog_code" ><option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>	
			<% 
				ArrayList	arrCatalog				=	null;
				HashMap		hmCatalog				=	null;	
				String code = "";
				String	desc  = "";
				String catalog_select				=	"";
			//	arrCatalog =	bean.getCatalogCodeList(); 
				arrCatalog = bean.getDropDownList("CAT"); 
				int arrLength	=	arrCatalog.size();%> 
				<% 
				for(int i=0;i<arrLength; i++)
				{
					hmCatalog		=	(HashMap) arrCatalog.get(i);

					code				=	(String)hmCatalog.get("code");
					desc				=	(String)hmCatalog.get("desc");
					if(code.trim().equals(catalog_code))
					{
						catalog_select		=	"Selected";
					}
					else
						catalog_select		=	"";				
					%>
					
						<option value="<%=code%>"  <%=catalog_select%> ><%=desc%></option> 
					<%
				} 
								
			%>
			</select> 
			<%} %> <!-- ADDED FOR MO-CRF-20165 END -->
			<td class='label' ><fmt:message key="Common.PurchaseUOM.label" bundle="${common_labels}"/></td>
			<td  colspan=3 class='fields'><select name='pur_uom_code' id='pur_uom_code' onBlur="checkUOMConvFactor();" <%=codeDisabled%>>
			<%=bean.getPur_uom_code_List(pur_uom_code,item_code)%>
			</select><fmt:message key="eST.ConvFactorRule.label" bundle="${st_labels}"/>:<b id="id_pur_uom_conv"><%=pur_uom_conv_id%></b>
			<% if(grn_newfields_applicable){ %> <!-- MO-CRF-20165 -->
			<label onMouseOver="changeCursor(this);"  class="label" onClick = "showItemRemarks();"><font class='HYPERLINK'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font></label></td>	<!-- ADDED for MO-CRF-20165 -->
			<% } %>
			</td>
		
			<td class='fields'  colspan='8'>
				<input type='button' name="apply" id="apply" value="<%=stButtonLegend%>" class=button onclick="if(issueUOMQtyChk()) addToList();"><input type=button name=Cancel id=Cancel value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class=button  onclick="cancel_me();">
			</td>
		</tr>
		</table>
		<%
	 	}
		catch(Exception e){
			out.println("Exception@1: "+e.toString());
			e.printStackTrace();
		}
		finally{
			con.close();
		}
		%>
		<input type="hidden" name="store_item_unit_cost" id="store_item_unit_cost"	value="<%=store_item_unit_cost%>">
		<input type="hidden" name="store_code" id="store_code"				value="<%=store_code%>">
		<input type="hidden" name="uom_code" id="uom_code"				value="<%=uom_code%>">
		<input type="hidden" name="expiry_yn" id="expiry_yn"				value="<%=expiry_yn%>">
		<input type="hidden" name="doc_srl_no" id="doc_srl_no"				value="<%=doc_srl_no%>">
		<input type="hidden" name="index" id="index"					value="<%=index%>">
		<input type="hidden" name="dis_expiry_yn" id="dis_expiry_yn"			value="<%=dis_expiry_yn%>" >
		<input type="hidden" name="tmp_conv" id="tmp_conv"				value="">
		<input type="hidden" name="pur_uom_conv" id="pur_uom_conv"			value="<%=pur_uom_conv%>">
		<input type="hidden" name="item_class_code" id="item_class_code"			value="<%=stbean.getItem_class_code()%>">
		<input type="hidden" name="phy_inv_id" id="phy_inv_id"				value="">
		<input type="hidden" name="po_details_applicable_yn" id="po_details_applicable_yn"value="<%=po_details_applicable_yn%>">
		<input type="hidden" name="tmp_cost" id="tmp_cost"				value="<%=bean.setNumber(grn_unit_cost_in_pur_uom,noOfDecimalsForCost)%>">
		<input type='hidden' name='allow_deci_yn' id='allow_deci_yn'		value="<%=allow_deci_yn%>">
	    <input type='hidden' name='no_deci' id='no_deci'		value="<%=no_deci%>">

		<input type="hidden" name="ordered_qty" id="ordered_qty"		value="<%=ordered_qty%>">
		<input type="hidden" name="delivery_date" id="delivery_date"		value="<%=delivery_date%>">
		<input type="hidden" name="po_interface_yn" id="po_interface_yn"		value="<%=po_interface_yn%>">
		<input type="hidden" name="conversion_rate" id="conversion_rate"		value="<%=bean.checkForNull(conversion_rate,"1")%>">
		<input type="hidden" name="delv_date_override_yn" id="delv_date_override_yn"			 value="<%=delv_date_override_yn%>">
		<input type="hidden" name="price_override_yn" id="price_override_yn"		value='<%=price_override_yn%>'>
		<input type="hidden" name="remarks" id="remarks"				value=""><!-- added for MO-CRF-20165 START-->
		<input type="hidden" name="function_id" id="function_id"				value="<%= request.getParameter("function_id") %>"><!-- END -->
		<!-- 		
		* @Name - Priya
		* @Date - 10/02/2010
		* @Inc# - 19092
		* @Desc - Code added to accept decimal values dynamically.			
		-->
	<input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=bean.getAllowDecimalsYN(item_code)%>">
	<input type="hidden"		name="no_of_decimals" id="no_of_decimals"			 value="<%=no_deci%>">
	<input type="hidden"		name="no_of_decimals_for_cost" id="no_of_decimals_for_cost"	 value='<%=noOfDecimalsForCost%>'>
	<input type="hidden"		name="po_unit_cost_in_pur_uom" id="po_unit_cost_in_pur_uom"	 value='<%=po_unit_cost_in_pur_uom%>'>
	<input type="hidden"		name="by_po" id="by_po"					 value='<%=by_po%>'>
	<input type="hidden"		name="grn_newfields_applicable" id="grn_newfields_applicable"		 			 value='<%=grn_newfields_applicable%>'><!-- added for MO-CRF-20165 --> 
	<input type="hidden"		name="item_2d_barcode_yn" id="item_2d_barcode_yn"		 			 value='<%=item_2d_barcode_yn%>'><!-- added for MOHE-CRF-0167 --> 
	

	</form>
<%
	putObjectInBean("goodsReceivedNoteBean",bean,request);
%>
	</body>
</html>



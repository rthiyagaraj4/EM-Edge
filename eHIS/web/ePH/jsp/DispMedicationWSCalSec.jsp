<!DOCTYPE html>

  
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, java.text.DecimalFormat, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	  request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
    
	String drug_name		= request.getParameter("drug_name");
	String drug_code		= request.getParameter("drug_code");
	String qty				= request.getParameter("qty");
	String drug_form		= request.getParameter("drug_form");
	String patient_id		= request.getParameter("patient_id");
	String order_id			= request.getParameter("order_id");
	String order_line_no	= request.getParameter("order_line_no");
	String qty_uom			= request.getParameter("qty_uom");
	String tot_num_of_drugs = request.getParameter("tot_num_of_drugs");
	String width_legend		= "";
	String width_text		= "";
	String colspan			= "";
	String drug_name_size	= "";
	String rf_qty			= "";
	String drug_qty			= "";
	String rf_qty_uom		= "";
	String facility_id		= (String)session.getValue( "facility_id" );
    String status           =  "";
	String sIngredientsType	= request.getParameter("IngType");
	StringBuffer sbRatioPercentLegend = new StringBuffer();

	if(sIngredientsType!=null && !sIngredientsType.equals("") && !sIngredientsType.equals("S"))
	{
		sbRatioPercentLegend.append(SpringCacheBean.getLabel(pageContext,"ePH.Concentration.label","ph_labels.resources.Labels"));
		if(sIngredientsType.equals("P"))
		{
			sbRatioPercentLegend.append(" ");
			sbRatioPercentLegend.append(SpringCacheBean.getLabel(pageContext,"Common.by.label","common_labels.resources.Labels"));
			sbRatioPercentLegend.append(" ");
			sbRatioPercentLegend.append(SpringCacheBean.getLabel(pageContext,"ePH.Percentage.label","ph_labels.resources.Labels"));	
		}
		else if	(sIngredientsType.equals("R"))
		{
			sbRatioPercentLegend.append(" ");
			sbRatioPercentLegend.append(SpringCacheBean.getLabel(pageContext,"Common.by.label","common_labels.resources.Labels"));
			sbRatioPercentLegend.append(" ");
			sbRatioPercentLegend.append(SpringCacheBean.getLabel(pageContext,"ePH.Ratio.label","ph_labels.resources.Labels"));	
		}
	}


	int tot_disp_qty        =0;
	if(drug_form.equals("P")){
		width_legend="30%";
		width_text="25%";
		colspan = "3";
		drug_name_size="48";
	}else{
		width_legend="30%";
		width_text="70%";
		colspan = "5";
		drug_name_size="60";
	}		

	String bean_id					= "DispMedicationBean" ;
	String bean_name				= "ePH.DispMedicationBean";
	DispMedicationBean bean			= (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	String store_code				= bean.getStoreCode();
	//String spill_qty_yn				= bean.getSpillQtyYN(bean.getDispLocnCatg());
	String spill_qty_yn				= bean.getSpillQtyYN();
	String trade_code				= (String)bean.gettrade_codes(order_id,order_line_no,drug_code);
    String allowchangetradenameyn	= bean.getDispChangeTradeNameYN();
	String allowmultitradeyn	    = bean.getDispAllowMultiTradesYN();
	String allow_short_expiry_drugs_yn =bean.getAllow_short_expiry_drugs_yn();


	String disable_spill_qty="";
	if(spill_qty_yn.equals("N")){
		disable_spill_qty	=	"disabled";
	}
	String bean_id_1				= "DispMedicationAllStages" ;
	String bean_name_1				= "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean_1  = (DispMedicationAllStages)getBeanObject( bean_id_1, bean_name_1, request ) ;

	int iNoOfDecimals				= 0;

	boolean bDecimalAllowed			= bean_1.getDecimalAllowedYN(drug_code);
	if(bDecimalAllowed)
		iNoOfDecimals = bean_1.getINoOfDecimals();

	int iMaxLength					= 5+iNoOfDecimals;

	String multi_strength			= bean_1.checkMultiStrength(drug_code);
	String strDisabled = "";
	if(drug_form.equals("P")){	
		strDisabled = "disabled";
	}
	HashMap rf_fluid_details	  = new HashMap();
	String qty_required_per_order = qty;
	String prepartion_qty		  = qty;
	String qty_avail_from_spillage= "0";
	String qty_drawn_from_stock	  = qty;
	String worksheet_id           = bean.getWorksheetID();	
	String patient_class          = bean.getDispLocnCatg();
	String fluid_qty_as_per_order = "";
	String fluid_qty_preparation  = "";
	String fluid_qty_spillage	  = "0";
	String fluid_qty_drawn		  = "";
	Hashtable ht_drug_details	  = bean.getAllDrugDetails();
	String rf_id				  = "";
	String rf_name				  = "";
	String lbl_stock_qty		  = "";
	String lbl_stock_qty_uom	  = "";
	String display				  = "display:none";
	String rf_name_disabled	      = "";
	String finalised_yn			  ="Y";
	ArrayList un_finalised_val    = new ArrayList();

    ArrayList dosage_dtls		  =	new ArrayList();
	dosage_dtls					  =	bean.getDosageDtls(order_id,order_line_no);		
	String end_date		          =	(String)dosage_dtls.get(2);

	ArrayList arr_list_drug_details = (ArrayList)ht_drug_details.get(order_line_no);
	if(drug_form.equals("P") && (arr_list_drug_details == null))
	{
	
		  rf_fluid_details	  = new HashMap();
          rf_fluid_details=bean.getRFFluidDetails(drug_code);
		  if(rf_fluid_details!=null )
			{
			  rf_id					=(String)rf_fluid_details.get("RF_ID");
			  rf_name				= bean.getRFName(rf_id);
			  rf_qty				=(String)rf_fluid_details.get("RF_QTY");
			  drug_qty				=(String)rf_fluid_details.get("DRUG_QTY");

			  if(drug_qty.equals("0"))
                  drug_qty="1";
	              if(!rf_qty.equals("0")&&!drug_qty.equals("0")&&!qty.equals("0")&&!rf_qty.equals("")&&!drug_qty.equals("")&&!qty.equals("")){
			             fluid_qty_as_per_order=(((Double.parseDouble(rf_qty)/Double.parseDouble(drug_qty))*Double.parseDouble(qty))+"");
                  }
//out.println("~~~ fluid_qty_as_per_order == "+fluid_qty_as_per_order+"  ==rf_qty== "+rf_qty+" ==drug_qty== "+drug_qty +" ==qty== "+qty);
			  fluid_qty_preparation	=fluid_qty_as_per_order;
			  fluid_qty_drawn		=fluid_qty_as_per_order;
			  rf_qty_uom			=(String)rf_fluid_details.get("RF_QTY_UOM");
			  bean.setStockQtyUOM(fluid_qty_drawn,rf_id);
		      lbl_stock_qty			= bean.getStockQty();
		      lbl_stock_qty_uom		= bean.getStockQtyUOM();
			  display				= "";
			 }
	}
	
	if(arr_list_drug_details != null){
		if(arr_list_drug_details.size()==5){
			qty_required_per_order = (String)arr_list_drug_details.get(1);
			prepartion_qty		   = (String)arr_list_drug_details.get(2);
			qty_avail_from_spillage= (String)arr_list_drug_details.get(3);
			qty_drawn_from_stock   = (String)arr_list_drug_details.get(4);


		}else if(arr_list_drug_details.size()==10){
			qty_required_per_order = (String)arr_list_drug_details.get(1);
			prepartion_qty		   = (String)arr_list_drug_details.get(2);
			qty_avail_from_spillage= (String)arr_list_drug_details.get(3);
			qty_drawn_from_stock   = (String)arr_list_drug_details.get(4);

			rf_id				   =(String)arr_list_drug_details.get(5);
			fluid_qty_as_per_order =(String)arr_list_drug_details.get(6);
			fluid_qty_preparation  =(String)arr_list_drug_details.get(7); 
			fluid_qty_spillage     =(String)arr_list_drug_details.get(8); 

			rf_fluid_details=bean.getRFFluidDetails(drug_code);
			if(rf_fluid_details!=null ){
               rf_qty_uom			=(String)rf_fluid_details.get("RF_QTY_UOM");
			}

			if(fluid_qty_preparation != null && !fluid_qty_preparation.equals("") && fluid_qty_spillage != null && !fluid_qty_spillage.equals(""))
				fluid_qty_drawn=(Double.parseDouble(fluid_qty_preparation)-Double.parseDouble(fluid_qty_spillage))+""; 
			else
				fluid_qty_drawn = "";
	
			//fluid_qty_drawn =(String)arr_list_drug_details.get(9); 
			bean.setStockQtyUOM(fluid_qty_drawn,rf_id);
			lbl_stock_qty     = bean.getStockQty();
			lbl_stock_qty_uom = bean.getStockQtyUOM();
			display			  = "";
			rf_name			  = bean.getRFName(rf_id);
			strDisabled		  = "";
			rf_name_disabled  = "disabled";

			
		}
//CODE WRITTEN TO HANDLE REGULAR PRESCRIPTIONS TOTAL DISP QTY
		
		}

	String first_time_yn ="Y";
	 HashMap ws_first_time_yn =(HashMap)bean.getWSFirstYN();
     //if(worksheet_id!=null && !worksheet_id.equals("")){
       if(ws_first_time_yn.containsKey(order_line_no+drug_code)) {
           first_time_yn =(String)ws_first_time_yn.get(order_line_no+drug_code);
	   }
	// }

	finalised_yn = bean.getWorksheetFinalisedYN(worksheet_id,bean.getDispLocnCode(),facility_id);
		tot_disp_qty           =   bean.getTotalDispQtyForWorkSheet(order_id,order_line_no,facility_id);

		if(!finalised_yn.equals("N")&&patient_class.equals("I")&&first_time_yn.equals("Y")){
			  qty_required_per_order =  (Integer.parseInt(qty_required_per_order)-tot_disp_qty)+"";
		 }
         if(first_time_yn.equals("Y")){
				
				if(patient_class.equals("I")){
					if(worksheet_id!=null && !worksheet_id.equals("")){	

						if(finalised_yn.equals("Y")){	
								
								HashMap ht_ws_allocated_drugs  =  bean.getAllAllocatedDrugs();
								if(!ht_ws_allocated_drugs.containsKey(drug_code)){

									if(!prepartion_qty.equals("")){
										//prepartion_qty			=  (Integer.parseInt(prepartion_qty)-tot_disp_qty)+"";
										prepartion_qty			= qty_required_per_order;
										qty_drawn_from_stock	=  prepartion_qty;
										qty_avail_from_spillage = "0";
									}
								}				
					   }
					   else{			   
							un_finalised_val = null;
							un_finalised_val = bean.getDataForUnFinalisedWorksheets(worksheet_id,bean.getDispLocnCode(),order_line_no,facility_id);
							prepartion_qty		   = (String)un_finalised_val.get(0);
							qty_avail_from_spillage= (String)un_finalised_val.get(1);
							qty_drawn_from_stock   = (String)un_finalised_val.get(2);

							 qty_required_per_order =  (Integer.parseInt(qty_required_per_order)-tot_disp_qty)+"";
						  
						}
					 }
					 else{
						 bean.setFinalized_yn("Y");
						 if(tot_disp_qty>0){						
								prepartion_qty			=  (Integer.parseInt(prepartion_qty)-tot_disp_qty)+"";
								qty_drawn_from_stock	=  prepartion_qty;
								qty_avail_from_spillage = "0";									
						 }


					 }	
				}else {
					if(worksheet_id!=null && !worksheet_id.equals("")){	
						//finalised_yn = bean.getWorksheetFinalisedYN(worksheet_id,bean.getDispLocnCode(),facility_id);
						if((bean.getDispStage().equals("F") && (bean.getFillingStatus().equals("A")  ))|| (bean.getDispStage().equals("A") && (bean.getFillingStatus().equals("B")  ))){			
							finalised_yn ="N";

						}else{
							tot_disp_qty        =   bean.getTotalDispQtyForWorkSheet(order_id,order_line_no,facility_id);
							if(tot_disp_qty>0){
							   finalised_yn ="Y";
							} 

						}	
					    //qty_required_per_order  =  (Integer.parseInt(qty_required_per_order)-tot_disp_qty)+"";

						if(finalised_yn.equals("Y")){	
							
								HashMap ht_ws_allocated_drugs  =  bean.getAllAllocatedDrugs();
								if(!ht_ws_allocated_drugs.containsKey(drug_code)){
									if(!prepartion_qty.equals("")){
										//prepartion_qty			=  (Integer.parseInt(prepartion_qty)-tot_disp_qty)+"";
										prepartion_qty			= qty_required_per_order;
										qty_drawn_from_stock	=  prepartion_qty;
										qty_avail_from_spillage = "0";
									}
								}				
					   }else{	
						   
								un_finalised_val = null;
								un_finalised_val = bean.getDataForUnFinalisedWorksheets(worksheet_id,bean.getDispLocnCode(),order_line_no,facility_id);
								prepartion_qty		   = (String)un_finalised_val.get(0);
								qty_avail_from_spillage= (String)un_finalised_val.get(1);
								qty_drawn_from_stock   = (String)un_finalised_val.get(2);
						}
					 }
					 else{
						 bean.setFinalized_yn("Y");
						  if(tot_disp_qty>0){	
							    qty_required_per_order  =  (Integer.parseInt(qty_required_per_order)-tot_disp_qty)+"";
								prepartion_qty			=  (Integer.parseInt(prepartion_qty)-tot_disp_qty)+"";
								qty_drawn_from_stock	=  prepartion_qty;
								qty_avail_from_spillage = "0";									
						 }
					 }		
				}
		 }

         if(finalised_yn.equals("N")&&!patient_class.equals("I")) {
			 status="disabled";
		 } 

%>

<form name="frmDispMedicationWSCalSec" id="frmDispMedicationWSCalSec">
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<td colspan="3">
 			<table cellpadding="0" cellspacing="0" width="100%" border="0" align="left">
			<td  class="COLUMNHEADER"><fmt:message key="ePH.CalculationSection.label" bundle="${ph_labels}"/></th>
			<tr>
				<td  class="label"><b><%=sbRatioPercentLegend.toString()%><b></td>
			</tr>
			</table>
		</td>
	</tr>

	<tr>
		<td width="45%">
			<table cellpadding="0" cellspacing="0" width="100%" border="0" align="left">
 			<td  class="COLUMNHEADER" colspan="<%=colspan%>"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
			<tr>
				<td colspan=2>&nbsp;<input type="text" size="<%=drug_name_size%>" maxlength="60" disabled style="font-size:12" name="drug_name" value="<%=drug_name%>"></td>
			</tr>				
			<tr>
				<td class="label" width="<%=width_legend%>"><fmt:message key="ePH.QtyRequiredasperorder.label" bundle="${ph_labels}"/></td>
				<td width="<%=width_text%>">&nbsp;<input type="text" name="drug_qty_as_per_order" id="drug_qty_as_per_order" value="<%=qty_required_per_order%>" maxlength="4" size="6" style="font-size:12" class="NUMBER" disabled ></td>
			</tr>
			<tr>
				<td class="label"><fmt:message key="ePH.PreparationQuantity.label" bundle="${ph_labels}"/></td>
				<td >&nbsp;<input type="text" name="drug_qty_preparation" id="drug_qty_preparation" value="<%=prepartion_qty%>" maxlength="<%=iMaxLength%>" size="6" style="font-size:12" class="NUMBER"  onKeyPress="return allowValidNumber(this,event,4,<%=iNoOfDecimals%>)" onBlur="if(validateNumbers(this,4,'<%=iNoOfDecimals%>')){validateDrugPreQty(this,'<%=prepartion_qty%>','<%=qty_required_per_order%>','<%=iNoOfDecimals%>');}" <%=status%>></td>
			</tr>

			<tr>
				<td class="label"><fmt:message key="ePH.QtyAvailablefromLeftOver.label" bundle="${ph_labels}"/></td>
				<td >&nbsp;<input type="text" name="drug_qty_spillage" id="drug_qty_spillage" value="<%=qty_avail_from_spillage%>" maxlength="<%=iMaxLength%>" size="6" style="font-size:12" class="NUMBER" onKeyPress="return allowValidNumber(this,event,4,<%=iNoOfDecimals%>)"  onBlur="if(validateNumbers(this,4,'<%=iNoOfDecimals%>')){validateDrugSpillage(this,'<%=qty_required_per_order%>','<%=prepartion_qty%>','<%=iNoOfDecimals%>');}" <%=disable_spill_qty%> <%=status%> ></td>
			</tr>
                
			<tr>
				<td class="label" nowrap><fmt:message key="ePH.QtyTobedrawnfromStock.label" bundle="${ph_labels}"/></td>
				<td >&nbsp;<input type="text" name="drug_qty_drawn" id="drug_qty_drawn" value="<%=qty_drawn_from_stock%>" maxlength="4" size="6" style="font-size:12" class="NUMBER" disabled>
				<%if(status.equals("disabled")){%>
					<br>
					<label id="lblDrugShowBatches" style="color:black;font-size:9" ><fmt:message key="ePH.AllocBatches.label" bundle="${ph_labels}"/></label>
				<%}else{%>
					<br>				     
                    <label id="lblDrugShowBatches" style="color:blue;cursor:pointer;font-size:9" onClick="showWSBatches('D','<%=drug_code%>','<%=trade_code%>')"><fmt:message key="ePH.AllocBatches.label" bundle="${ph_labels}"/></label>  

				<%}%>
				</td>
			</tr>	
			</table>
		</td>
	
<%
		if(drug_form.equals("P")){
%>
		<td width="2%">
 			<table cellpadding="0" cellspacing="0" width="100%"  border="0" align="left">
			<tr>
				<td STYLE="background:white">&nbsp;</td>
			</tr>
			<tr>
				<td STYLE="background:white">&nbsp;</td>
			</tr>
			<tr>
				<td STYLE="background:white">&nbsp;</td>
			</tr>
			<tr>
				<td STYLE="background:white">&nbsp;</td>
			</tr>
			<tr>
				<td STYLE="background:white">&nbsp;</td>
			</tr>
			<tr>
				<td STYLE="background:white">&nbsp;</td>
			</tr>
			<tr>
				<td STYLE="background:white">&nbsp;</td>
			</tr>
			<tr>
				<td STYLE="background:white">&nbsp;</td>
			</tr>
			<tr>
				<td HEIGHT="21" STYLE="background:white">&nbsp;</td>
			</tr>
			</table>
		</td>
	
		<td width="53%">
			<table cellpadding="0" cellspacing="0" width="100%"  border="0" align="left">
			<input type="hidden" name="SQL_PH_DISP_MEDICATION_SELECT38" id="SQL_PH_DISP_MEDICATION_SELECT38" value="SELECT   a.rf_id code, rf_name description FROM ph_reconst_fluid a, PH_RECONST_FLUID_FOR_DRUG b WHERE a.rf_id = b.rf_id and drug_code = '<%=drug_code%>' and a.rf_id LIKE ? AND a.rf_name LIKE ? ORDER BY 2">
			<td  class="COLUMNHEADER"><fmt:message key="ePH.ReconstituentFluid.label" bundle="${ph_labels}"/></td>
			<tr>
				<td>
					<input type="text" name="rf_name" id="rf_name" size="30" maxlength="60" value="<%=rf_name%>" style="font-size:12" <%=rf_name_disabled%>><input type="button" name="btnReconFluidName" id="btnReconFluidName" value="?" class="button" onClick="ReconstituentFluidLookup(rf_name)">
	 				<input type="button" name="btnStabilityInfo" id="btnStabilityInfo" value="Info" class="button" onClick="callStabilityInfo()">
					<input type="hidden" name="rf_id" id="rf_id" value="<%=rf_id%>">
				</td>
			</tr>

			<tr>
				<td>
					<input type="text"  onKeyPress="return allowValidNumber(this,event,4,0)" name="fluid_qty_as_per_order" id="fluid_qty_as_per_order" value="<%=fluid_qty_as_per_order%>" maxlength="4" size="3" style="font-size:12" class="NUMBER" disabled>&nbsp;<b><label id="uom_1" class="label"><%=bean.getUomDisplay(facility_id,rf_qty_uom)%></label></b>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text"  onKeyPress="return allowValidNumber(this,event,4,0)" name="fluid_qty_preparation" id="fluid_qty_preparation" value="<%=fluid_qty_preparation%>" maxlength="4" size="3" style="font-size:12" class="NUMBER"  disabled>&nbsp;<b><label id="uom_2" class="label" ><%=bean.getUomDisplay(facility_id,rf_qty_uom)%></label></b>
				</td>
			</tr>

			<tr>
				<td>
					<input type="text" name="fluid_qty_spillage" id="fluid_qty_spillage" value="<%=retunFormatedInt(fluid_qty_spillage)%>" maxlength="4" size="3" style="font-size:12" onKeyPress="return allowValidNumber(this,event,4,0)" class="NUMBER" onBlur="if(validateNumbers(this,4,'<%=iNoOfDecimals%>')){validateFluidSpillage(this);}" <%=disable_spill_qty%> <%=status%>>&nbsp;<b><label id="uom_3" class="label"><%=bean.getUomDisplay(facility_id,rf_qty_uom)%></label></b>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="fluid_qty_drawn" id="fluid_qty_drawn" value="<%=retunFormatedInt(fluid_qty_drawn)%>" maxlength="4" size="3" style="font-size:12" class="NUMBER" disabled>
					<input type="hidden" name="stock_qty" id="stock_qty" value="">&nbsp;<b><label id="uom_4" class="label"><%=bean.getUomDisplay(facility_id,rf_qty_uom)%></label></b>&nbsp;
					<label id="lbl_stock_qty" style="font-size:10;font-weight:bold;<%=display%>"><%=lbl_stock_qty%></label>
					&nbsp;&nbsp;<label id="lbl_stock_qty_uom" style="font-size:10;font-weight:bold;<%=display%>">
					<%=bean.getUomDisplay(facility_id,lbl_stock_qty_uom)%> </label>
					&nbsp;&nbsp;
					
					<%if(status.equals("disabled")){%>
					    <label id="lblFluidShowBatches" style="color:black;font-size:10" ><fmt:message key="ePH.AllocBatches.label" bundle="${ph_labels}"/></label>
					<%}else{%>
                        <label id="lblFluidShowBatches" style="color:blue;cursor:pointer;font-size:10" onClick="showWSBatches('F',rf_id.value,'')"><fmt:message key="ePH.AllocBatches.label" bundle="${ph_labels}"/></label>

					<%}%>
				</td>
			</tr>
					
			
			</table>
		</td>
       <% } %>
	</tr>
	<tr>
		<td class="white" colspan="3">&nbsp;</td>
	</tr>
	<tr>		
		<td  class="white" colspan="3"> 
			<input type="button" name="btnStockAvailability" id="btnStockAvailability" value='<fmt:message key="ePH.ShowBatches.label" bundle="${ph_labels}"/>' class="button" onClick="callWSBatchSearch('<%=drug_code%>','<%=store_code%>','<%=trade_code%>','<%=allowchangetradenameyn%>','<%=allowmultitradeyn%>','<%=end_date%>','<%=allow_short_expiry_drugs_yn%>')" <%=strDisabled%> <%=status%>>
			<input type="button" name="btnCancel" id="btnCancel" class="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="clearCalSection()" <%=status%>>
		</td>
	</tr>
	</table>
	
	<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
	<input type="hidden" name="drug_form" id="drug_form" value="<%=drug_form%>">	
	<input type="hidden" name="multi_strength" id="multi_strength" value="<%=multi_strength%>">	
	<input type="hidden" name="stability_info" id="stability_info" value="">	
	<input type="hidden" name="rf_qty" id="rf_qty" value="<%=rf_qty%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
	<input type="hidden" name="order_line_no" id="order_line_no" value="<%=order_line_no%>">
	<input type="hidden" name="order_qty" id="order_qty" value="<%=qty%>">
	<input type="hidden" name="qty_uom" id="qty_uom" value="<%=qty_uom%>">
	<input type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">	
	<input type="hidden" name="tot_num_of_drugs" id="tot_num_of_drugs" value="<%=tot_num_of_drugs%>">
	<input type="hidden" name="tot_disp_qty" id="tot_disp_qty" value="<%=tot_disp_qty%>">
	
</form>
<script language="Javascript">
//makeQtyAsReadOnly();
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




</body>
</html>
<%! 
	DecimalFormat dfToInteger = new DecimalFormat("#.####");
	private String retunFormatedInt(String sValue)
	{
		if(sValue != null && !sValue.equals(""))
		{
			return dfToInteger.format(Double.parseDouble(sValue));
		}
		return "";
	}

%>

<%
putObjectInBean(bean_id,bean,request);
//putObjectInBean(bean_id_1,bean_1,request);
%>


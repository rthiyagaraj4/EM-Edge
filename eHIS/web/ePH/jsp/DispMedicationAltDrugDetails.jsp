<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,java.sql.*,webbeans.eCommon.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%> 

<%-- Mandatory declarations start --%>


<!-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
29/05/2020	IN:072092	        Manickavasagam J			     GHL-CRF-0618		 
03/11/2020		IN:074297	        Manickavasagam J			     GHL-SCF-1527
--------------------------------------------------------------------------------------------------------------
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<HTML> 
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
<%
	Connection con			= null;   //GHL-CRF-0549

	try{
	con						   = ConnectionManager.getConnection(request);//added for GHL-CRF-0549
    boolean item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con,"PH","ITEM_TYPE_APP");//added for GHL-CRF-0549
	boolean formulary_billing_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","FORMULARY_BLG_GRP_APP"); //GHL-CRF-0618
	boolean barcode_scan_for_alt_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","BARCODE_SCAN_FOR_ALT_APP"); //MMS-KH-CRF-0030
	String bean_id						= "DispMedicationAllStages" ;
	String bean_name					= "ePH.DispMedicationAllStages";
    DispMedicationAllStages bean		= (DispMedicationAllStages)getBeanObject( bean_id, bean_name,request ) ;

	String	bean_id_1					=	"DispMedicationBean" ;
	String	bean_name_1					=	"ePH.DispMedicationBean";
	DispMedicationBean bean_1			= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
	
	String facility_id					= (String) session.getValue("facility_id");
	String param_bean_id				= "@DrugInterfaceControlBean";
    String param_bean_name				= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
     
	String drug_db_interface_yn		= param_bean.getDrugDBInterface_yn(facility_id); 
	param_bean.clear();
	String encounter_id				=  bean_1.getEncounterID(); //GHL-CRF-0549
	if(encounter_id==null) //GHL-CRF-0549
		encounter_id = "";
	String class_name				=	"";
	String drug_code				=	request.getParameter("drug_code");
	String patient_id				=	request.getParameter("patient_id");
	String order_id					=	request.getParameter("order_id");
	String order_line_no			=	request.getParameter("order_line_no");
	String store_code				=	request.getParameter("store_code");
	String qty_reqd					=	request.getParameter("qty_reqd");
	String eff_expiry				=	request.getParameter("eff_expiry");
	String patient_class            		=   CommonBean.checkForNull(request.getParameter("patient_class"));//GHL-CRF-0549
    String strength_val             =request.getParameter("strength_value");//ADDED FOR GHL-CRF-0548
	String source					=	request.getParameter("source")==null?"":request.getParameter("source");
	String mar_alt_drug_code		=	CommonBean.checkForNull(request.getParameter("mar_alt_drug_code"));//Added for Bru-HIMS-CRF-399 [IN:043767]
	String main_drug_strength		=	bean.getStrengthUOM(drug_code);//request.getParameter("main_strength_uom");
	String iv_prep_yn				=  request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
	String alt_drug_code			=	"";
	String drug_name				=	"";
	String stock_uom				=  "";
	String form_code				=	"";
	String form_desc				=	"";	
	String route_desc				=	"";
	String strength_value			=	"";
	String strength_uom_desc		=	"";
	String prev_form_desc			=	"";
	String strength_uom				=	"";
	String external_prod_id			=	"";
	double tot_qty					=	0;
	int adr_count					=   0;
	if(!eff_expiry.equals(""))
		eff_expiry						=	eff_expiry.substring(0,10); 
	HashMap		drug_details		=	bean.getDrugValues(drug_code); 
	String generic_id				=	(String)drug_details.get("generic_id");  
	String select_status			=	"";
String form_code_medical_item=bean.checkMedicalItemYN(drug_code);//(String)drug_details.get("form_code");//added for ghl-crf-0548 Removed based on data from site for GHL-ICN-0035
	int tot_record					=	0;
	ArrayList alternate_drugs		=	new ArrayList();
	ArrayList multi_drugs			=	new ArrayList();
	ArrayList avail_qty			 	=	new ArrayList();
	LinkedHashMap	stock_alternate_drugs	=	null; //HashMap changed to LinkedHashMap for MMS-DM-CRF-0009 [IN:054440]
	multi_drugs						=	bean.getMultiDrugs(patient_id,order_id,order_line_no);
String disp_locn_catg	=	bean_1.getDispLocnCatg();//GHL-CRF-0549s	
	String module_id				=	bean.getModuleId();
	String alt_drug_remarks_ind = request.getParameter("alt_drug_remarks_ind"); //added for  Bru-HIMS-CRF-082 [IN:029948]
	String medical_applicable=bean.checkMedicalItemYN(drug_code);//added for ghl-crf-0548
	if(source.equals("MAR"))//if Added for Bru-HIMS-CRF-399 [IN:043767]
		module_id = "2";



//GHL-CRF-0549- start
	if(disp_locn_catg.equals("I")) {
		patient_class	=	"IP";
	} else {
		patient_class	=	"OP";
	}
//GHL-CRF-0549- end
	if(module_id.equals("1")) {
		alternate_drugs	=	bean.getAlternateDrugs(drug_code,generic_id);
	}
	else{
		//strength_val ADDED FOR GHL-CRF-0548
		 if(form_code_medical_item.equals("Y")){//*MD* Removed based on data from site for GHL-ICN-0035
			 stock_alternate_drugs	=	bean.getStockAlternateMedicalItem(store_code,qty_reqd,eff_expiry,generic_id,drug_code,strength_val,form_code_medical_item);
		}
		else
			stock_alternate_drugs	=	bean.getStockAlternateDrugs(store_code,qty_reqd,eff_expiry,generic_id,drug_code,strength_val,"N");//modified for GHL-ICN-0075
		
	}
%>
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="DispMedicationAltDrugDetails" id="DispMedicationAltDrugDetails">
<%	
			int n	=	0;
			int i	=	0;
			String bean_drug_code ="",  key="", code ="", desc="";
			HashMap	drug_detail = null;
			HashMap	record				=	new HashMap();
			ArrayList	item_detail		=	new ArrayList();
			Set	alternate_set	=	null;
			Iterator	iter	=	null;
			String	sEqulStrengthUOM	= "";
			String	sEnableDisableCheck	= "";
			//GHL-CRF-0549- start			
			String bl_grp_app		   = "";
			String mm_item_low_cost_yn = "";	
			String mm_item_high_margin_yn = "";
			String mm_item_Innovator_yn = "";
			String low_cost_green_style ="visibility:none";
			String high_margin_green_style ="visibility:none";
			String high_margin_red_style   ="visibility:none";
			String low_cost_red_style	="visibility:none";
			String low_cost_grey_style ="visibility:none";
			String high_margin_grey_style ="visibility:none";
			String innovator_style		="visibility:none";
			String item_type = "";
			String unit_price = "";
			if(item_type_site_app)
			bl_grp_app = bean.getItemTypeApp(patient_id);

		if(bl_grp_app==null || bl_grp_app.equals(""))
			bl_grp_app = "N";
//		System.err.println("DispMedicationAltDrugDetails.jsp====patient_class==142==>"+patient_class+"==bl_grp_app==>"+bl_grp_app+"=item_type_site_app==>"+item_type_site_app);
			
//			bl_grp_app = "L";


			ArrayList stock_params				=	bean.validateForStock(patient_class);
			String disp_charge_dtl_in_drug_lkp_yn="";
			String bl_install_yn= (String) session.getValue( "bl_operational" )==null?"N":(String) session.getValue( "bl_operational" ) ;
			String disp_price_type_in_drug_lkp="";
			String consider_stock	=	"N";
			if(stock_params.size() > 1) {
				consider_stock	=	(String)stock_params.get(0);
				disp_charge_dtl_in_drug_lkp_yn=(String)stock_params.get(2);
				disp_price_type_in_drug_lkp = (String)stock_params.get(3);
			}	
			//bl_install_yn = "Y";
			//disp_price_type_in_drug_lkp = "Y";
			//disp_charge_dtl_in_drug_lkp_yn = "Y";
			//GHL-CRF-0549- end
			//GHL-CRF-0618 - start
			String preference = "";  
			String preference_img = ""; 
			String formulary_value = "";
			String formulary_code  = "";
			String blg_grp_type = "";
			HashMap hmBlgGrp = null;
			ArrayList itemGenericType = null; //GHL-CRF-0618
			boolean non_preference_flag = false; //GHL-CRF-0618
			boolean disp_non_preference_rem_window =false;//GHL-CRF-0618
			if(formulary_billing_app){
				String blng_grp_id = bean.getBillingGrpId();
				formulary_value = bean.getFormularyBillingGrpCode(blng_grp_id);
				formulary_code = formulary_value.substring(0, formulary_value.indexOf("~"));
				blg_grp_type = formulary_value.substring(formulary_value.indexOf("~")+1);
				if(!formulary_code.equals(""))
				 hmBlgGrp = bean.getFormularyBillingGrpCodeDtl(formulary_code,blng_grp_id);//blng_grp_id added for GHL-SCF-1527
				 itemGenericType = bean.getItemGenericType();
			} //GHL-CRF-0618 - end
			

			if(module_id.equals("1")) {	
%>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
					<tr>
					<% 	//GHL-CRF-0549 
						if(bl_install_yn.equals("Y") && item_type_site_app && !encounter_id.equals("") && !iv_prep_yn.equals("7") && !iv_prep_yn.equals("8")) { %>
						<td class="COLUMNHEADER" width="5%" nowrap><fmt:message key="ePH.ItemType.label" bundle="${ph_labels}"/></td>
						<%
					if(formulary_billing_app){	 //GHL-CRF-0618 
					%>
					<td  class="COLUMNHEADER" width="2%"  style="font-size:9" >&nbsp;</td><!-- added for GHL-CRF-0618 -->
					<%}	 

					}%>
						
						<td class= "COLUMNHEADERCENTER" align="center" width="40%"><fmt:message key="ePH.AlternateDrugNames.label" bundle="${ph_labels}"/></td>
						<td class= "COLUMNHEADERCENTER" align="center" width="15%"><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/></td>
						<td class= "COLUMNHEADERCENTER" align="center" width="15%"><fmt:message key="Common.Route.label" bundle="${common_labels}"/></td>
<%						if((bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && item_type_site_app && !encounter_id.equals("") && !iv_prep_yn.equals("7") && !iv_prep_yn.equals("8") ) || form_code_medical_item.equals("Y")){ //added for GHL-CRF-0549 and *MD removed while doing 618 CRF
%>
							<td class="COLUMNHEADER" width="15%"><fmt:message key="Common.UnitPrice.label" bundle="${common_labels}"/>
							</td>
<%
}
%>
						<td class= "COLUMNHEADERCENTER" align="center" width="15%"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></td>
						<td class= "COLUMNHEADERCENTER" align="center" width="15%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
					</tr>
					<tr><td colspan="7" class="white"></td></tr>
<% 
					for( i=0; i<alternate_drugs.size(); i++){ 
						select_status	=	"";
						if(i%2==0)
							class_name	=	"QRYEVENSMALL";
						else
							class_name	=	"QRYODDSMALL";
						drug_detail	=	(HashMap)alternate_drugs.get(i);

						alt_drug_code		=	(String)drug_detail.get("DRUG_CODE");
						drug_name			=	(String)drug_detail.get("DRUG_DESC");
						form_code			=	(String)drug_detail.get("FORM_CODE");
						form_desc			=	(String)drug_detail.get("FORM_DESC");
						route_desc			=	(String)drug_detail.get("ROUTE_DESC");
						strength_value		=	(String)drug_detail.get("STRENGTH_VALUE");
						strength_uom_desc	=	(String)drug_detail.get("STRENGTH_UOM_DESC");
						external_prod_id	=	(String)drug_detail.get("EXTERNAL_PRODUCT_ID");
						stock_uom			= (String)drug_detail.get("STOCK_UOM");					//newly added for 32578

						if(n < multi_drugs.size())	{
							bean_drug_code		=	(String)multi_drugs.get(n);
							if(bean_drug_code.equals(alt_drug_code))
								select_status	=	"checked";
							n	+=	5;
						}
						
						adr_count = bean.getADRCount(patient_id,alt_drug_code);
				
						if(!form_desc.equals(prev_form_desc))	{
							prev_form_desc	=	form_desc;
%>
							<tr><td class= "COLUMNHEADER" colspan="6"><th align="left">&nbsp;<%=form_desc%>(s)</td></tr>
<%
						}
						//GHL-CRF-0549 - start
						if(bl_install_yn.equals("Y") && item_type_site_app && !encounter_id.equals("") && !iv_prep_yn.equals("7") && !iv_prep_yn.equals("8")){
							unit_price = "";
							low_cost_green_style ="visibility:hidden";
							high_margin_green_style ="visibility:hidden";
							high_margin_red_style   ="visibility:hidden";
							low_cost_red_style	="visibility:hidden";
							low_cost_grey_style ="visibility:hidden";
							high_margin_grey_style ="visibility:hidden";
							innovator_style		="visibility:hidden"; 
							high_margin_grey_style = "visibility:hidden"; 
							low_cost_grey_style="visibility:hidden";
							item_type= bean.getItemType(drug_code);
							mm_item_low_cost_yn = item_type.split("~")[0];
							mm_item_high_margin_yn = item_type.split("~")[1];
							mm_item_Innovator_yn = item_type.split("~")[2];
							unit_price = bean.getUnitPrice(patient_class,alt_drug_code,patient_id,disp_price_type_in_drug_lkp);
									if(!bl_grp_app.equals("N")){
										if(mm_item_low_cost_yn.equals("Y")) {
										if(bl_grp_app.equals("L")){
												low_cost_green_style ="visibility:visible";
												low_cost_red_style = "visibility:hidden";
												low_cost_grey_style = "visibility:hidden";
												
											if(mm_item_high_margin_yn.equals("Y")){
												high_margin_red_style = "visibility:visible";
												high_margin_green_style ="visibility:hidden";
												high_margin_grey_style = "visibility:hidden";
											}else{
												high_margin_grey_style = "visibility:hidden";
											}
										}else{
											low_cost_green_style ="visibility:hidden";
											low_cost_red_style = "visibility:visible";
											low_cost_grey_style = "visibility:hidden";


										} 
									}else{
											low_cost_green_style ="visibility:hidden";
											low_cost_red_style = "visibility:hidden";
											low_cost_grey_style = "visibility:hidden";
									}
									if(mm_item_high_margin_yn.equals("Y")){
											if(bl_grp_app.equals("H")){
												high_margin_green_style ="visibility:visible";
												high_margin_red_style = "visibility:hidden";
												high_margin_grey_style = "visibility:hidden";
												if(mm_item_low_cost_yn.equals("Y")) {
												low_cost_red_style ="visibility:visible";
												low_cost_green_style = "visibility:hidden";
												low_cost_grey_style = "visibility:hidden";
												}

											}/*else{
												high_margin_green_style ="visibility:hidden";
												if(mm_item_low_cost_yn.equals("Y")){
													low_cost_red_style = "visibility:visible";
												}
											}*/
									}else{
										
											high_margin_green_style ="visibility:hidden";
											high_margin_red_style = "visibility:hidden";
											high_margin_grey_style = "visibility:hidden";
									}

									if(mm_item_Innovator_yn.equals("Y")){
											innovator_style		="visibility:visible";		
									}else{
											innovator_style		="visibility:hidden";		
									}
								}else{
									low_cost_green_style = "visibility:hidden";
									high_margin_green_style = "visibility:hidden";
									low_cost_red_style = "visibility:hidden";
									high_margin_red_style = "visibility:hidden";

									if(mm_item_low_cost_yn.equals("Y"))
										low_cost_grey_style = "visibility:visible";		
									else
										low_cost_grey_style = "visibility:hidden";					
	
									if(mm_item_high_margin_yn.equals("Y"))
										high_margin_grey_style = "visibility:visible";
									else
										high_margin_grey_style = "visibility:hidden";
									
									if(mm_item_Innovator_yn.equals("Y"))
										innovator_style		="visibility:visible";		
									else
										innovator_style		="visibility:hidden";		
								}
						}
%>								

						<tr>
						<td class='<%=class_name%>'>&nbsp
								<%if(!low_cost_green_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCostGreen.jpg" style='<%=low_cost_green_style%>' height='15' width='15' ><%}
								if(!high_margin_green_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMarginGreen.jpg" style="<%=high_margin_green_style%>" height='15' width='15' >
								<%}if(!low_cost_red_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCostRed.jpg" style="<%=low_cost_red_style%>" height='15' width='15' ><%}if(!high_margin_red_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMarginRed.jpg" style="<%=high_margin_red_style%>" height='15' width='15' ><%} if(!low_cost_grey_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCost.jpg" title="Low Cost Item" style="<%=low_cost_grey_style%>" height='15' width='15' ><%} if(!high_margin_grey_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMargin.jpg" title="High Margin Item" style="<%=high_margin_grey_style%>" height='15' width='15' ><%}if(!innovator_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/Innovator.jpg" title="Innovator Item" style="<%=innovator_style%>"  height='15' width='15' > <%}
									
								%>

								</td> <!-- GHL-CRF-0549 - end-->
						<td  width="40%" class="<%=class_name%>"><input type="hidden" name="alt_drug_code<%=i%>" id="alt_drug_code<%=i%>" value="<%=alt_drug_code%>" ><input type="hidden" name="alt_drug_desc<%=i%>" id="alt_drug_desc<%=i%>" value="<%=drug_name%>" ><input type="hidden" name="form_code<%=i%>" id="form_code<%=i%>" value="<%=form_code%>" ><%=drug_name%>
<%
						if(external_prod_id!=null && !(external_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){%>
							<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=external_prod_id%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>')"></img>
<%
						}
						if(adr_count>0){
%>
							<img  id="ADR_img" src='../../ePH/images/ADR.gif'   height='20'  width='20' title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>'></img>
<%
						}
%>
						<input type="hidden" name="strength_value<%=i%>" id="strength_value<%=i%>" value="<%=strength_value%>" ><input type="hidden" name="strength_uom<%=i%>" id="strength_uom<%=i%>" value="<%=strength_uom_desc%>" ></td>
						<td  width="15%" class="<%=class_name%>"><%=form_desc%><input type="hidden" name="indicator<%=i%>" id="indicator<%=i%>" value="<%=form_desc%>"></td>
						<td  width="15%" class="<%=class_name%>"><%=route_desc%></td>
						<td  width="15%" class="<%=class_name%>"><%=strength_value%>&nbsp;&nbsp;<%=strength_uom_desc%></td>
						<td  width="15%" class="<%=class_name%>"><input type="checkbox" name="select<%=i%>" id="select<%=i%>" <%=select_status%> onClick="evaluateBaseOnForm(this,document.DispMedicationAltDrugDetails)"></td>
					</tr>
<%
					tot_record=i;
				}	
%>
				</table>
<%	
			}	
			else if (stock_alternate_drugs!=null){	
%>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
					<tr>
					<% //added for GHL-CRF-0549
					if(item_type_site_app && bl_install_yn.equals("Y") && !encounter_id.equals("") && !iv_prep_yn.equals("7") && !iv_prep_yn.equals("8") ){%>
						<td class="COLUMNHEADERCENTER" width="8%" nowrap><fmt:message key="ePH.ItemType.label" bundle="${ph_labels}"/></td>
						<%
					if(formulary_billing_app){	//GHL-CRF-0618
					%>
					<td  class="COLUMNHEADER" width="2%"  style="font-size:9" >&nbsp;</td><!-- added for GHL-CRF-0618 -->
					<%}%>	 
					<%}if(form_code_medical_item.equals("Y")){//added for ghl-crf-0548 and and *MD removed while doing 618 CRF%>
						<td class= "COLUMNHEADERCENTER" width="30%"><fmt:message key="ePH.ItemTechname.label" bundle="${ph_labels}"/></td>
						<%} else{%>
						<td class= "COLUMNHEADERCENTER" width="30%"><fmt:message key="ePH.AlternateDrugNames.label" bundle="${ph_labels}"/></td>
						<%}if(form_code_medical_item.equals("Y")){//added for ghl-crf-0548 and *MD removed while doing 618 CRF %>
						
						<td class= "COLUMNHEADERCENTER" width="30%"><fmt:message key="Common.ItemName.label" bundle="${common_labels}"/></td>
						<%} else{%>
						<td class= "COLUMNHEADERCENTER" width="30%"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
						<%}%>
<%//added for GHL-CRF-0549

							if((bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y")  && item_type_site_app && !encounter_id.equals("") && !iv_prep_yn.equals("7") && !iv_prep_yn.equals("8")  ) || form_code_medical_item.equals("Y")){ //added for GHL-CRF-0549 and *MD removed while doing 618 CRF
%>
							<td class="COLUMNHEADERCENTER" width="10%"><fmt:message key="Common.UnitPrice.label" bundle="${common_labels}"/>
							</td>
<%
						} %>
						<td class= "COLUMNHEADERCENTER" width="10%"><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></td>
						<%if(!form_code_medical_item.equals("Y")){ %><!-- added for ghl-crf-0548 and *MD removed while doing 618 CRF -->
						<td class= "COLUMNHEADERCENTER" width="10%"><fmt:message key="ePH.TotalAvailableQuantity.label" bundle="${ph_labels}"/></td>
						<%}%>
						<td class= "COLUMNHEADERCENTER" width="5%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
					</tr>
<%
					n	=	0;
					i	=	0;
					alternate_set	=	stock_alternate_drugs.keySet();
					iter	=	alternate_set.iterator();
					sEqulStrengthUOM	= "";
					sEnableDisableCheck	= "";
					java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
					String fmtQty = "";
		 
					while(iter.hasNext())	{ 
						sEqulStrengthUOM	= "";
						sEnableDisableCheck	= "";
						tot_qty			=	0;			
						select_status	=	"";

						if(i%2==0)
							class_name	=	"QRYEVENSMALL";
						else
							class_name	=	"QRYODDSMALL";

						key	=	(String)iter.next();				
						record			=	(HashMap) stock_alternate_drugs.get(key);
						
						alt_drug_code		=	(String)record.get("DRUG_CODE");
						drug_name			=	(String)record.get("DRUG_DESC");
						strength_value		=	(String)record.get("STRENGTH_VALUE");
						strength_uom		=	(String)record.get("STRENGTH_UOM");
						form_code			=	(String)record.get("FORM_CODE");
						form_desc			=	(String)record.get("FORM_DESC");
						item_detail			=	(ArrayList)record.get("ITEM");
						avail_qty			=	(ArrayList)record.get("AVAIL_QTY"); 
						external_prod_id	=	(String)record.get("EXTERNAL_PRODUCT_ID");
						stock_uom			= (String)record.get("STOCK_UOM");					//newly added for 32578
						disp_non_preference_rem_window =false;//GHL-CRF-0618
						adr_count = bean.getADRCount(patient_id,alt_drug_code);
						if(!medical_applicable.equals("Y")){//if condtion added for ghl-crf-0548
						if(Float.parseFloat(strength_value)<1)
							 strength_value =( Float.parseFloat(strength_value))+"";
						// For the main drug strength UOM, the equalvalent alternate drug strength UOM is not set then dont display the drug itself check both the UOMs are different, then check any equal UOM is available or not. if not hide the drug
						if(!main_drug_strength.equals(strength_uom)){
							sEqulStrengthUOM = bean.getEqvlValue(strength_uom,main_drug_strength);
							if(sEqulStrengthUOM == null || sEqulStrengthUOM.equals(""))
								continue;
						}
						}
						
						if(n < multi_drugs.size())	{
							bean_drug_code		=	(String)multi_drugs.get(n);
							if(bean_drug_code.equals(alt_drug_code))
								select_status	=	"checked";
								n	+=	5;
						}
						if(mar_alt_drug_code.equals(alt_drug_code) && source.equals("MAR"))//if Added for Bru-HIMS-CRF-399 [IN:043767]
							select_status	=	"checked";
						if(!form_desc.equals(prev_form_desc))	{
							prev_form_desc				=	form_desc;  
%>
						<tr><td class= "COLUMNHEADER" colspan="7">&nbsp;<%=form_desc%>(s)</td></tr>
<%	
					}
%>
					<tr>
					<%
				//GHL-CRF-0549
				if((bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && item_type_site_app && !encounter_id.equals("") && !iv_prep_yn.equals("7") && !iv_prep_yn.equals("8") ) || form_code_medical_item.equals("Y")){ //and *MD removed while doing 618 CRF
					unit_price = bean.getUnitPrice(patient_class,alt_drug_code,patient_id,disp_price_type_in_drug_lkp);
							
							if(unit_price==null)
								unit_price = "";
							if(!unit_price.equals(""))
								unit_price = Float.parseFloat(unit_price)+"";
				}
						//added for GHL-CRF-0549 - start	
						if(bl_install_yn.equals("Y") && item_type_site_app && !encounter_id.equals("") && !iv_prep_yn.equals("7") && !iv_prep_yn.equals("8")){
							low_cost_green_style ="visibility:hidden";
							high_margin_green_style ="visibility:hidden";
							high_margin_red_style   ="visibility:hidden";
							low_cost_red_style	="visibility:hidden";
							low_cost_grey_style ="visibility:hidden";
							high_margin_grey_style ="visibility:hidden";
							innovator_style		="visibility:hidden"; 
							high_margin_grey_style = "visibility:hidden"; 
							low_cost_grey_style="visibility:hidden";
							item_type= bean.getItemType(alt_drug_code);
							mm_item_low_cost_yn = item_type.split("~")[0];
							mm_item_high_margin_yn = item_type.split("~")[1];
							mm_item_Innovator_yn = item_type.split("~")[2];
							
						//	mm_item_low_cost_yn = "Y";
						//	mm_item_high_margin_yn = "N";
						//	mm_item_Innovator_yn = "Y";

							/*unit_price = bean.getUnitPrice(patient_class,alt_drug_code,patient_id,disp_price_type_in_drug_lkp);
							if(unit_price==null)
								unit_price = "";
							if(!unit_price.equals(""))
								unit_price = Float.parseFloat(unit_price)+""; */

									if(!bl_grp_app.equals("N")){
									if(mm_item_low_cost_yn.equals("Y")) {
										if(bl_grp_app.equals("L")){
												low_cost_green_style ="visibility:visible";
												low_cost_red_style = "visibility:hidden";
												low_cost_grey_style = "visibility:hidden";
												
											if(mm_item_high_margin_yn.equals("Y")){
												high_margin_red_style = "visibility:visible";
												high_margin_green_style ="visibility:hidden";
												high_margin_grey_style = "visibility:hidden";
											}else{
												high_margin_grey_style = "visibility:hidden";
											}
										}else{
											if(bl_grp_app.equals("H")){
												low_cost_green_style ="visibility:hidden";
												low_cost_red_style = "visibility:visible";
												low_cost_grey_style = "visibility:hidden";
											}
										} 
									}else{
											low_cost_green_style ="visibility:hidden";
											low_cost_red_style = "visibility:hidden";
											low_cost_grey_style = "visibility:hidden";
									}
									if(mm_item_high_margin_yn.equals("Y")){
											if(bl_grp_app.equals("H")){
												high_margin_green_style ="visibility:visible";
												high_margin_red_style = "visibility:hidden";
												high_margin_grey_style = "visibility:hidden";
												if(mm_item_low_cost_yn.equals("Y")) {
												low_cost_red_style ="visibility:visible";
												low_cost_green_style = "visibility:hidden";
												low_cost_grey_style = "visibility:hidden";
												}

											}else{
												if(bl_grp_app.equals("L")){
													high_margin_red_style = "visibility:visible";
												}
											}
									}else{
										
											high_margin_green_style ="visibility:hidden";
											high_margin_red_style = "visibility:hidden";
											high_margin_grey_style = "visibility:hidden";
									}

									if(mm_item_Innovator_yn.equals("Y")){
											innovator_style		="visibility:visible";		
										}else{
											innovator_style		="visibility:hidden";		
										}
									}
								else{
									low_cost_green_style = "visibility:hidden";
									high_margin_green_style = "visibility:hidden";
									low_cost_red_style = "visibility:hidden";
									high_margin_red_style = "visibility:hidden";

									if(mm_item_low_cost_yn.equals("Y"))
										low_cost_grey_style = "visibility:visible";		
									else
										low_cost_grey_style = "visibility:hidden";					
	
									if(mm_item_high_margin_yn.equals("Y"))
										high_margin_grey_style = "visibility:visible";
									else
										high_margin_grey_style = "visibility:hidden";
									
									if(mm_item_Innovator_yn.equals("Y"))
										innovator_style		="visibility:visible";		
									else
										innovator_style		="visibility:hidden";		
								}
								if(formulary_billing_app){//GHL-CRF-0618 - start
									high_margin_red_style = "visibility:hidden";
									high_margin_green_style ="visibility:hidden";
									low_cost_green_style ="visibility:hidden";
									low_cost_red_style = "visibility:hidden";
									
									if(mm_item_low_cost_yn.equals("Y")){
										low_cost_grey_style = "visibility:visible";
									}else{
										low_cost_grey_style = "visibility:hidden";
									}
									if(mm_item_high_margin_yn.equals("Y")){
										high_margin_grey_style = "visibility:visible";								
									}else{
										high_margin_grey_style = "visibility:hidden";
									}
									if(mm_item_Innovator_yn.equals("Y")){
										innovator_style		="visibility:visible";
									}else{
										innovator_style		="visibility:hidden";
									}
									preference_img = "";
									preference = "";
				
									if(hmBlgGrp!=null && hmBlgGrp.size()>0){
										if(itemGenericType!=null && itemGenericType.size()>0){
											if(itemGenericType.contains("D") || (form_code_medical_item.equals("Y") && itemGenericType.contains("M")))
												non_preference_flag = true;
											 }
										

										if(hmBlgGrp.containsKey(alt_drug_code)){
											non_preference_flag = true;
											preference = (String)hmBlgGrp.get(alt_drug_code)==null?"":(String)hmBlgGrp.get(alt_drug_code);
											preference_img = "";
											if(preference.equals("P1")){
												preference_img ="<img src='../../ePH/images/Preference1.jpg' title='Prefered-1 Item'  height='15' width='15'/>";
											}else if(preference.equals("P2")){
												preference_img ="<img src='../../ePH/images/Preference2.jpg' title='Prefered-2 Item' height='15' width='15'/>";
											}else if(preference.equals("P3")){
												preference_img ="<img src='../../ePH/images/Preference3.jpg' title='Prefered-3 Item' height='15' width='15'/>";
											}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' title='Non Prefered Item' height='15' width='15'/>";
											}
										}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' title='Non Prefered Item' height='15' width='15'/>";
											}

									}
								} //GHL-CRF-0618 - end
//System.err.println("drug_code====>"+preference_img);

%>								<td class='<%=class_name%>'>&nbsp
								<%if(!low_cost_green_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCostGreen.jpg" style='<%=low_cost_green_style%>' height='15' width='15' title='<fmt:message key="ePH.Matched.label" bundle="${ph_labels}"/>' ><%}
								if(!high_margin_green_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMarginGreen.jpg" style="<%=high_margin_green_style%>" height='15' width='15'  title='<fmt:message key="ePH.Matched.label" bundle="${ph_labels}"/>'>
								<%}if(!low_cost_red_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCostRed.jpg" style="<%=low_cost_red_style%>" height='15' width='15' title='<fmt:message key="ePH.NotMatched.label" bundle="${ph_labels}"/>'><%}if(!high_margin_red_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMarginRed.jpg" style="<%=high_margin_red_style%>" height='15' width='15' title='<fmt:message key="ePH.NotMatched.label" bundle="${ph_labels}"/>'><%} if(!low_cost_grey_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCost.jpg" title="Low Cost Item" style="<%=low_cost_grey_style%>" height='15' width='15' ><%} if(!high_margin_grey_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMargin.jpg" style="<%=high_margin_grey_style%>" height='15' title="High Margin Item" width='15' ><%}if(!innovator_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/Innovator.jpg" style="<%=innovator_style%>" title="Innovator Item"   height='15' width='15' > <%}%> </td>
								<%	if(formulary_billing_app){
%>								
								<td class="<%=class_name%>">	<%=preference_img%>&nbsp;</td>
<%								}
						}
								%>

								</td><!-- GHL-CRF-0549 -end -->
						<td  width="40%" class="<%=class_name%>"><input type="hidden" name="alt_drug_code<%=i%>" id="alt_drug_code<%=i%>" value="<%=alt_drug_code%>" ><input type="hidden" name="alt_drug_desc<%=i%>" id="alt_drug_desc<%=i%>" value="<%=drug_name%>" ><%=drug_name%>&nbsp;<%=strength_value%>&nbsp;<%=bean.getUomDisplay(facility_id,strength_uom)%>&nbsp;<%=bean.getUomDisplay(facility_id,stock_uom)%> <!--strength_uom to  bean.getUomDisplay(facility_id,strength_uom) for inc 32578 -->
<%   
						if(external_prod_id!=null && !external_prod_id.equals("")&& drug_db_interface_yn.equals("Y")){
%>
							<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=external_prod_id%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>')"></img>  <!-- Passed UTF-8 for drug name regarding incident 25007 on 18/Nov/2010==By Sandhya -->
<% 
						}
						if(adr_count>0){
%>
							<img  id="ADR_img" src='../../ePH/images/ADR.gif'  height='20'  width='20' title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>'></img>
<%
						}
%>
						<input type="hidden" name="indicator<%=i%>" id="indicator<%=i%>" value="<%=form_desc%>"><input type="hidden" name="strength_value<%=i%>" id="strength_value<%=i%>" value="<%=strength_value%>" ><input type="hidden" name="strength_uom<%=i%>" id="strength_uom<%=i%>" value="<%=strength_uom%>" ></td>
						<td  width="15%" class="<%=class_name%>"><input type="hidden" name="form_code<%=i%>" id="form_code<%=i%>" value="<%=form_code%>"><select onChange="displayQuanity(document.DispMedicationAltDrugDetails,this,<%=i%>)" name="item_select<%=i%>" disabled>
						<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<%
						for(int k=0; k<item_detail.size(); k+=2) { 
							code	=	(String)item_detail.get(k);
							desc	=	(String)item_detail.get(k+1);

							if(item_detail.size()==2) {
%>
								<option value="<%=code%>" selected><%=desc%></option>
<%	
							}
							else{	
%>
								<option value="<%=code%>"><%=desc%></option>	
<%
							}
						}
%>
						</td>
	<%						if((bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && item_type_site_app && !encounter_id.equals("") && !iv_prep_yn.equals("7") && !iv_prep_yn.equals("8") ) || form_code_medical_item.equals("Y")){  //and *MD removed while doing 618 CRF%>
						<td>&nbsp;<%= unit_price%></td>
	<%}%>
						<td  width="15%" class="<%=class_name%>">
<% 
						int cnt	=	0;
						for(int p=0; p<item_detail.size(); p+=2) { 
							code	=	(String)item_detail.get(p);
%>
							<input type="hidden" name="qty_<%=code%>" id="qty_<%=code%>" value="<%=(String)avail_qty.get(cnt)%>">
<%	
							cnt++;
						}	
			
						if(item_detail.size()==2 && avail_qty.size() >= 1) {
							fmtQty = df.format(Double.parseDouble((String)avail_qty.get(0)));
%>
							<label id="disp_<%=i%>"><%=fmtQty%></label>
<%
						}
						else {	
%>
							<label id="disp_<%=i%>"></label>
<%	
						}
%>
						</td>
						<%if(!form_code_medical_item.equals("Y")){ //added for ghl-crf-0548 and *MD removed while doing 618 CRF%>
						<td  width="15%" class="<%=class_name%>">&nbsp;
<% 
						for(int q=0; q<avail_qty.size(); q++) {
							if(avail_qty.size() >=1 && !((String)avail_qty.get(q)).equals(""))
								tot_qty	+=	Double.parseDouble((String)avail_qty.get(q));
						}
						fmtQty = df.format(tot_qty);
						if(fmtQty.equals("0")) //code added for IN047266
							sEnableDisableCheck = "disabled"; //code added for IN047266
%>
						<%=fmtQty%>
						</td>
						<%}
						if(non_preference_flag){
							if(blg_grp_type.equals("C")){
								if(!preference.equals("P1")){
									disp_non_preference_rem_window = true;
									
								}
							}else{
								if(!preference.equals("P1")){
									disp_non_preference_rem_window = false;
									sEnableDisableCheck = "disabled";
								}
							}
						}
%>
						<td  width="15%" class="<%=class_name%>"><input type="checkbox" name="select<%=i%>" id="select<%=i%>" <%=select_status%> onClick="evaluateBaseOnForm(this,document.DispMedicationAltDrugDetails,'<%=disp_non_preference_rem_window%>','<%=patient_id%>','<%=encounter_id%>','<%=alt_drug_code%>','<%=order_id%>','<%=order_line_no%>','<%=barcode_scan_for_alt_app%>','<%=drug_code%>','<%=i%>')" <%=sEnableDisableCheck%> ></td><!-- code  '<%=sEnableDisableCheck%>' added for IN047266 -->
					</tr>
<%	
					tot_record=i;
					i++;
				}
%>
				</table>
<%	
			}
%>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
			<input type="hidden" name="tot_record" id="tot_record" value="<%=tot_record%>">
			<input type="hidden" name="order_line_no" id="order_line_no" value="<%=order_line_no%>">
			<input type="hidden" name="alt_drug_remarks_ind" id="alt_drug_remarks_ind" value="<%=alt_drug_remarks_ind%>"><!-- added for  Bru-HIMS-CRF-082 [IN:029948] -->
		</form>
	</body>
</html>
<%
	putObjectInBean(param_bean_id,param_bean,request);
	putObjectInBean(bean_id_1,bean_1,request);

	//putObjectInBean(bean_id,bean,request);
}catch(Exception e){
e.printStackTrace();
}finally{ // added for GHL-CRF-0549
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	}
%>


<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/07/2017      ML-MMOH-SCF-0690  Devindra      	Unable to select batch for alternate drug if the batch expiry is near/lesser than prescribed duration and only on batch exist for the item in the store.
04/19/2017	MMS-DM-SCF-0417   Manickavasagam	Allocated Quantity is showing wrong when the batch gets expired before Allocated days
04/19/2017	BSP-SCF-0041	  Mukesh		Allocated Quantity is showing wrong when the batch gets expired before Allocated days		
10/01/2019	  	IN068344	     	Manickavasagam 		  								GHL-CRF-0549 [IN068344] 
10/05/2019	  	IN068344	     	Manickavasagam 		  								AMS-CRF-0204 
13/08/2019	  	IN071102	     	Manickavasagam 		  								MMS-KH-SCF-0035 
30/08/2019	  	IN070894	     	Devindra 		  									ML-MMOH-SCF-1318(RF) 
29/05/2020		IN:072092	        Manickavasagam J			     GHL-CRF-0618
03/11/2020		IN:074297	        Manickavasagam J			     GHL-SCF-1527
--------------------------------------------------------------------------------------------------------------
 -->

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!--  Added for ML-MMOH-CRF-0690 -->
	</head>
	<body onMouseDown="" onKeyDown="lockKey()" topmargin="0">
		<form name="DispMedicationAllocateDetails" id="DispMedicationAllocateDetails" >
<%
Connection con			= null;  // Added for ML-MMOH-CRF-0468

		
try{

	con				= ConnectionManager.getConnection(request);//added for ml-mmoh-crf-0468
	boolean tpn_mf_label = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_MF_LABEL");// Added for ML-MMOH-CRF-0468
	boolean item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","ITEM_TYPE_APP");//added for GHL-CRF-0549
	String bl_install_yn= CommonBean.checkForNull((String) session.getValue( "bl_operational" ),"N") ; //added for AMS-CRF-204
	boolean formulary_billing_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","FORMULARY_BLG_GRP_APP"); //GHL-CRF-0618


	String	bean_id			=	"DispMedicationAllStages" ;

			String	bean_name		=	"ePH.DispMedicationAllStages";
			
			DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name , request) ;
			bean.setLanguageId(locale);
			
			String	bean_id_1		=	"DispMedicationBean" ;
			String	bean_name_1		=	"ePH.DispMedicationBean";
			
			DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
			bean_1.setLanguageId(locale);
		   
			String facility_id					= (String) session.getValue("facility_id");
			String param_bean_id				= "@DrugInterfaceControlBean";
			String param_bean_name				= "ePH.DrugInterfaceControlBean";
			DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
			String drug_db_interface_yn			= param_bean.getDrugDBInterface_yn(facility_id); 
			param_bean.clear();

			String alt_drug_remarks_ind = bean_1.getAltDrugRemarksInd(); //added for  Bru-HIMS-CRF-082 [IN:029948]
			String alt_drug_remarks_disp = ""; //added for  Bru-HIMS-CRF-082 [IN:029948]

			String patient_id		=	request.getParameter("patient_id");
			String re_load_yn		=	request.getParameter("re_load_yn")==null?"Y":request.getParameter("re_load_yn");
			String order_id			=	request.getParameter("order_id")==null?"":request.getParameter("order_id");
			String chosen_drug		=	request.getParameter("chosen_drug")==null?"":request.getParameter("chosen_drug");
			String source			=	request.getParameter("source")==null?"":request.getParameter("source");
			String recno			=	request.getParameter("recno")==null?"":request.getParameter("recno");
			String resetQty			=	request.getParameter("resetQty");
			String alt_drg_no		=	request.getParameter("alt_drg_no")==null?"0":request.getParameter("alt_drg_no");
			String alt_drg_sel		=	request.getParameter("alt_drg_sel")==null?"N":request.getParameter("alt_drg_sel");
			String durationVal		=	request.getParameter("durationVal")==null?"":request.getParameter("durationVal"); // Added for ML-MMOH-SCF-0690 - Start
			String durnPrdVal		=	request.getParameter("durnPrdVal")==null?"":request.getParameter("durnPrdVal"); 
			if(!durnPrdVal.equals(""))
				durationVal = durnPrdVal; 
			String expiry_date = bean_1.getSysdatePlusDays(durationVal);// Added for ML-MMOH-SCF-0690  - End
			String encounter_id		=	bean_1.getEncounterID(); //AMS-CRF-0204
			String sPRNOrAbsOrder   =   "F";	
			String order_line_no	=	"";
			String drug_code		=	"";
			String drug_name		=	"";	
			String end_date			=	"";
			String pres_qty			=	"";
			String qty_uom			=	"";
			String qty_uom_disp		=	"";
			String alt_drug_code	=	"";
			String alt_drug_desc	=	"";
			String drug_color		=	"";
			String style			=	"";
			String call_function	=	"";
			String form_code		=	"";
			String bms_qty			=	"";
			String uom				=	""; 
			String alt_drug_qty		=	"";	
			String width_1			=	"";
			String width_2			=	"";
			String width_3			=	"";
			String gif				=	"";
			String strength_value	=	"";
			String strength_uom		=	"";
			String strength_uom_disp	=	"";
			String onClick			=	"";
			String filling_status	=	"";	
			String drug_class		=	"";
			String fractroundupyn   =   "";
			String bms_strength_1	=	"";
			String iv_prep_yn	=	"";
			boolean qty_found		=	false;
			double	tot_qty			=	0;
			long		stk_qty		=	0;
			int adr_count			=   0;
			String sOrderType = "", sAbsOrder= "", dischargeIND= "";
			String medical_applicable="";//added for ghl-crf-0548
			String allow_alternate_yn="";//added for ghl-crf-0549
			int alter_drugs_avel		=0;//added for ghl-crf-0548 
			//String allergy		=	"";
			//String exceed_dose	=	"";
			//String duplicate		=	"";
			//String generic_id		=	"";
			//String generic_name	=	"";
			//String dosage_details	=	"";
			//String dosage_dtls	=	"";
			//String start_date		=	"";
			//String duplicate_yn	=	"";
			//String min_dose_dtls	=	"";
			//String ordered_by		=	"";
			//String location		=	"";

			ArrayList	colors	    =	new ArrayList();
			colors.add("#FF0000");
			colors.add("#669900");
			colors.add("#FF9966");
			colors.add("#6699CC");
			colors.add("#FF0000");
			

	//GHL-CRF-549 - start
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
				if(item_type_site_app && !encounter_id.equals(""))
				bl_grp_app = bean.getItemTypeApp(patient_id);
				if(bl_grp_app==null || bl_grp_app.equals(""))//added for AMS-CRF-0204
					bl_grp_app = "N";
				//bl_grp_app = "L";//REMOVED  for AMS-CRF-0204
				//GHL-CRF-549 - end

			ArrayList result		=	null;
			ArrayList orderLineDtls	=	new ArrayList();
			String disp_level		=	bean_1.getDispLevelValue();

			ArrayList alOrderIds    = new ArrayList();
			ArrayList tmpResult     = new ArrayList();

			if(bean_1.getAlTrxOrderIds()!=null){
				alOrderIds = bean_1.getAlTrxOrderIds();
			}
			//Declaration ends 
			if(disp_level.equals("P")) {
				//order lines of all orders
				result			= bean_1.getOrders(patient_id.trim());
				if(bean_1.getCriteriaOrderType()!=null && (bean_1.getCriteriaOrderType().equals("ALL") || bean_1.getCriteriaOrderType().equals("CDR")  || ( tpn_mf_label && bean_1.getCriteriaOrderType().equals("TD")))){ //TD added for  ML-MMOH-CRF-0468 CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
					if(alOrderIds.size()>0){
						for(int i=0;i<result.size();i=i+11) {		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607   //Modified for RUT-CRF-0088 [IN036978] 13->11
							if(alOrderIds.contains(result.get(i+1))){
								for(int j=i;j< i+11;j++)		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607	//Modified for RUT-CRF-0088 [IN036978] 13->11
									tmpResult.add(result.get(j));
							}
						}
					}
					result = tmpResult;
				}
				ArrayList tmp	=	new ArrayList();
				for(int i=0;i<result.size();i=i+11) {		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607	//Modified for RUT-CRF-0088 [IN036978] 13->11
					tmp = (ArrayList)bean_1.getOrderLineDetails(patient_id,(String)result.get(i+1));
					if(tmp.size()!=0) {
						orderLineDtls.add((String)result.get(i+1));
						orderLineDtls.add((String)result.get(i+3));
						orderLineDtls.add((String)result.get(i+4));
					
						for(int j=0; j<tmp.size(); j++)
							orderLineDtls.add(tmp.get(j));
					}
				}
			} 
			else {
				orderLineDtls = (ArrayList)bean_1.getOrderLineDetails(patient_id,order_id);
			}
			String store_code		=	bean_1.getStoreCode();
			String module_id		=	bean.getModuleId();
			filling_status			=	bean_1.getFillingStatus();
			//String disp_stage		=	bean_1.getDispStage();
			
			if(module_id.equals("1")) {
				width_1	=	"50%";
				width_2	=	"25%";
				width_3	=	"25%";
			}
			else {
				width_1	=	"61%";
				width_2	=	"15%";
				width_3	=	"19%";
			}
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
<%
				String classvalue			=	"";
				int recCount				=	1;
				ArrayList stock_opt			=	new ArrayList();
				String image				=	"";
				String alt_strength_value	=	"";
				String alloc_strength		=	"";
				String bms_strength			=	"";
				String tmp_bms_qty			=	"";
				String in_formulary			=	"";
				String tmp_drug_code		=	"";
				String tmp_order_id			=	"";
				String min_end_date			=	"";
				boolean multi_found			=	false;
				//float  prod_qty				=  0.0f;
				String alt_strength_uom		=	"";
				float tmp_alloc				=	0;
				float alt_drug_alloc_qty	=   0;  //added for  ML-BRU-SCF-0474[IN035407]
				StringTokenizer		token	=	null;
				ArrayList		multi_drugs	=	null;
				String qty					=	null;
				String alt_drug				=	null;
				ArrayList alt_qty			=	null;
				HashMap pack_dtls			=	null;
				String 	drug_name_1			=	"";
				float main_pack_size		=   0;
				String tmp_bms_qty_1		=	"";
				String bms_qty_1			=   "";
				String ext_prod_id			=   "";
				String alt_external_prod_id	=	"";
				String drug_verf_reqd_yn	=	"";
				String order_line_status	=	"";
				String main_strength_per_value_pres_uom ="";
				String disp_locn_catg		=	bean_1.getDispLocnCatg();
				String ip_scope             = bean_1.getIPScope();  // Added for ML-MMOH-CRF-0434 [IN057356]
				//String taper, taper_order_yn, taper_order_id, taper_order_line_num, show_remarks, taper_disable; //Commented for RUT-CRF-0088 [IN036978]
				float prescribed_strength	=   0; 
				//GHL-CRF-0618 - start
				String preference = "";  
				String preference_img = ""; 
				String formulary_value = "";
				String formulary_code  = "";
				String blg_grp_type = "";
				HashMap hmBlgGrp = null;

				if(formulary_billing_app){
					String blng_grp_id = bean.getBillingGrpId();
					//formulary_value = bean.getFormularyBillingGrpCode("CBSN");
					formulary_value = bean.getFormularyBillingGrpCode(blng_grp_id);
					formulary_code = formulary_value.substring(0, formulary_value.indexOf("~"));
					blg_grp_type = formulary_value.substring(formulary_value.indexOf("~")+1);
					if(!formulary_code.equals(""))
					 hmBlgGrp = bean.getFormularyBillingGrpCodeDtl(formulary_code,blng_grp_id); //blng_grp_id added for GHL-SCF-1527

				}
				//GHL-CRF-0618  - end
				for(int i=0;i<orderLineDtls.size(); i++){
					if ( recCount % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;
						
						stock_opt		=	new ArrayList();
						image			=	"";
						tot_qty			=	0;
						onClick			=	"";
						alloc_strength	=	"";
						bms_strength	=	"";
						tmp_alloc		=	0;
						alt_drug_remarks_disp = "";

						if(disp_level.equals("P") && ((String)orderLineDtls.get(i)).startsWith("PH")) {
							order_id		=	(String)orderLineDtls.get(i);
							//ordered_by		=	(String)orderLineDtls.get(++i);
							++i;
							++i;
							//location		=	(String)orderLineDtls.get(++i);
							++i;
						}

						//allergy			=	(String)orderLineDtls.get(i);
						//exceed_dose		=	(String)orderLineDtls.get(++i);
						++i;
						++i;
						//duplicate		=	(String)orderLineDtls.get(++i);
						drug_code		=	(String)orderLineDtls.get(++i);
						drug_name		=	(String)orderLineDtls.get(++i);
						drug_name_1		="";
						drug_name_1		=  drug_name;   
								
						if(!drug_name_1.equals("")&&drug_name_1!=null){
							drug_name_1=drug_name_1.replaceAll(" ","%20");
							drug_name_1=	java.net.URLEncoder.encode(drug_name_1,"UTF-8");
							drug_name_1=drug_name_1.replaceAll("%2520","%20");
						}

						//dosage_dtls		=	(String)orderLineDtls.get(++i);
						++i;
						//start_date		=	(String)orderLineDtls.get(++i);
						++i;
						end_date		=	(String)orderLineDtls.get(++i);
						pres_qty		=	(String)orderLineDtls.get(++i);
						qty_uom			=	(String)orderLineDtls.get(++i);
						qty_uom_disp	=	(String)orderLineDtls.get(++i);
						order_line_no	=	(String)orderLineDtls.get(++i);
						//generic_id		=	(String)orderLineDtls.get(++i);				
						//generic_name	=	(String)orderLineDtls.get(++i);				
						//dosage_details	=	(String)orderLineDtls.get(++i);
						i	=	i+3;
						bms_qty			=	(String)orderLineDtls.get(++i);
						i	=	i+7;
						//duplicate_yn	=	(String)orderLineDtls.get(++i);
						//min_dose_dtls	=	(String)orderLineDtls.get(++i);
						i	=	i+1;
						strength_value	=	(String)orderLineDtls.get(++i);

						if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) < 1)
							strength_value = Float.parseFloat(strength_value) +"" ;

						strength_uom	=	(String)orderLineDtls.get(++i);
						strength_uom_disp	=	(String)orderLineDtls.get(++i);
						if(module_id.equals("2")) {
							token	=	new StringTokenizer((String)orderLineDtls.get(++i),"|");
							while(token.hasMoreTokens()){
								stock_opt.add((String)token.nextToken());
							} 
						}
						//strength_uom	=	(String)orderLineDtls.get(++i);
						ext_prod_id  = (String)orderLineDtls.get(++i);
						in_formulary	=	((String)orderLineDtls.get(++i));
						iv_prep_yn	=	((String)orderLineDtls.get(++i));
						drug_class	=	(((String)orderLineDtls.get(++i)).trim());
						i=i+3;
						drug_verf_reqd_yn = (String)orderLineDtls.get(++i);
						order_line_status = (String)orderLineDtls.get(++i);
						main_strength_per_value_pres_uom   =(String)orderLineDtls.get(++i);
						i++;
						sOrderType = orderLineDtls.get(i) == null ?"":orderLineDtls.get(i).toString();
						i++;
						sAbsOrder  = orderLineDtls.get(i) == null ?"":orderLineDtls.get(i).toString();
						dischargeIND = (String)orderLineDtls.get(++i); //dischargeIND
						if(sOrderType.equals("P") || sAbsOrder.equals("N"))	{
							sPRNOrAbsOrder = "T";
						}
						i=i+24;	 //12-->13 for JD-CRF-0179 [IN:041211]//canfed to 22 to 24 for mms-dm-crf-0209.1changed 13 to 14 for Bru-HIMS-CRF-093-DD1[IN047223] // 14 --> 15 for Bru-HIMS-CRF-414- ML-BRU-SCF-1454 [IN:052271] --> 17 for  HSA-CRF-0138 [IN:048414] & Bru-HIMS-CRF-080//Changed 20 to 23 for TH-KW-CRF-0008
						/*Commented for RUT-CRF-0088 [IN036978]
						taper_order_yn 					=	(String)orderLineDtls.get(++i);// RUT-CRF-0069 ICN29607
						taper_order_id					=	(String)orderLineDtls.get(++i);//RUT-CRF-0069 ICN29607
						taper_order_line_num			=	(String)orderLineDtls.get(++i);//RUT-CRF-0069 ICN29607    */
					  /* ------------- commented for TO REMOVE THE DRUG LEVEL VERIFICATION ---------------
					  if(!bean_1.getVerfCombinedWithAlloc().equals("C")&& !disp_locn_catg.equals("I")){
							if(drug_verf_reqd_yn.equals("Y")){
								if(order_line_status.equals("VF")){
									
								}else{
									continue;
								}					
							}
						}
						*/
						//if(!(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals(""))){   //Commented for RUT-CRF-0088 [IN036978] 
							boolean stock_avl	=	bean.checkStock(drug_code,store_code,bms_qty,end_date);
							bean.setStockItems(drug_code,stock_opt);
							if(stock_opt!=null && stock_opt.size()>0 && !stock_opt.get(0).equals("Y")) //if block added for MMS-QF-SCF-0454 [IN:052404]
								stock_avl = false;

							if(end_date.length() >=10)
							end_date		=	end_date.substring(0,10);

							if(strength_value.equals("0")||strength_value.equals("0.0")) {
								strength_value	=	"";
								strength_uom	=	"";
							}	
							if(!chosen_drug.equals("") && !chosen_drug.equals(drug_code))
								continue;
							if(bean.checkHold(order_id,order_line_no)) 
								continue;

							if(in_formulary.equals("N"))
								continue;

							adr_count	=	bean.getADRCount(patient_id,drug_code);
							multi_drugs	=	bean.getMultiDrugs(patient_id,order_id,order_line_no);

							if(multi_drugs.size() >= 1) {
								multi_found		=	true;
								bean.setMultiFound(multi_found);
								//bean.checkBMS(patient_id,order_id,order_line_no,alt_drug_code);
							}

							qty				=	bean.getDrugQuantity(patient_id,order_id,order_line_no);
							if(stock_opt!=null && stock_opt.size()>0 && !stock_opt.get(0).equals("Y")){ //if block added for MMS-SCF-SCF-0417 and BSP-SCF-0041
								qty = "";
							}
							if(!qty.equals("") && !qty.equals("0") && multi_drugs.size() < 1)
								tot_qty				+=	Double.parseDouble(qty);
							medical_applicable=bean.checkMedicalItemYN(drug_code);//added for ghl-crf-0548
							alter_drugs_avel=bean.altDrugsAvelibleYN(drug_code);//added for ghl-crf-0548
							if(!strength_value.equals("")){
								  alt_drug			=	bean.checkMultiStrength(drug_code);
							}
							else if(medical_applicable.equals("Y") && alter_drugs_avel>0 ){//ADDED FOR GHL-CRF-0548
								alt_drug ="Y";
							}
							else{
								alt_drug ="N";
							}
							alt_drug_qty		=	"";

							if(source.equals("Fill")) {
								if(disp_level.equals("O") && filling_status.equals("A")) {
									if(multi_drugs.size()>0){
										for(int n=0; n<multi_drugs.size(); n+=5)	{ 

											alt_drug_code	=	(String)multi_drugs.get(n);
											alt_drug_qty	=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 
											if(!alt_drug_qty.equals(""))
											break;
										}
										//if(qty.equals("") && alt_drug_qty.equals(""))
										 // continue; 
									}
								}
							}
							else  if(source.equals("Alloc")) {
								if(bean.getFilling(patient_id,order_id,order_line_no))
									continue;
							}

							if(!order_id.equals(tmp_order_id) && !drug_code.equals(tmp_drug_code) ) {
								stk_qty	= Long.parseLong(bms_qty);	
								tmp_order_id	=	order_id;
								tmp_drug_code	=	drug_code;
								min_end_date	=	end_date;
							} 
							else {
								stk_qty	+= Long.parseLong(bms_qty);		
							}

							if(multi_drugs.size() < 1)	{
								style				=	"cursor:pointer;color:blue";
								
								if(module_id.equals("2")) {
									call_function	  =	"callStockEntry('"+patient_id+"','"+order_id+"','"+order_line_no+"','"+drug_code+"','"+drug_name_1+"','"+alt_drug+"','','','','"+strength_uom+"','"+bms_qty+"','"+source+"','"+recCount+"','"+strength_value+"','"+alt_strength_value+"','"+end_date+"','"+qty_uom+"','"+drug_class+"','" +stk_qty+"','"+min_end_date+"','"+main_strength_per_value_pres_uom+"','"+sPRNOrAbsOrder+"','"+alt_drg_no+"','"+alt_strength_uom+"','','"+facility_id+"','"+bean_1.getDispLocnCode()+"');changeRowColor('"+recCount+"');"; //added one argument(last) for  ML-BRU-SCF-0474[IN035407]
								}
								else{
									call_function	  =	"callDrugEntry('"+patient_id+"','"+order_id+"','"+order_line_no+"','"+drug_code+"','"+drug_name_1+"','"+alt_drug+"','','','','"+qty_uom+"','"+bms_qty+"','"+source+"','"+sPRNOrAbsOrder+"');changeRowColor('"+recCount+"');";
								}
							}
							else{
								style				=	"font-weight:bold";
								call_function		=	"";
								if(alt_drug_remarks_ind.equals("M") || alt_drug_remarks_ind.equals("O")){ //if block Added for Bru-HIMS-CRF-082 [IN:029948]
									alt_drug_remarks_disp = "&nbsp;<a href=\"javascript:openAltDrugRemarks('"+order_id+"','"+ order_line_no+"','"+ alt_drug_remarks_ind+"','LINK');\" id='altDrugRmkLbl' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"</a>";
									if(alt_drug_remarks_ind.equals("M"))
										alt_drug_remarks_disp=alt_drug_remarks_disp+" <img  id='altDrugRmkMand' src='../../eCommon/images/mandatory.gif'></img>";
								}
							}
							tmp_bms_qty				=	bms_qty;
							//drug_code

							pack_dtls				=	bean.getPackSize(drug_code);
							main_pack_size		=   0;
							if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
								if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
									 main_pack_size	    =	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));	
									tmp_bms_qty_1		=   Float.parseFloat(tmp_bms_qty)*main_pack_size+"";
									bms_qty_1			=   Float.parseFloat(bms_qty)*main_pack_size+"";
								}		
							}
							else{
								tmp_bms_qty_1		=   tmp_bms_qty;
								bms_qty_1			=	bms_qty;
						   }
							if((bean.loadHoldRemarks(order_id,order_line_no).isEmpty() && ip_scope.equals("A")) || !(ip_scope.equals("A"))) {   // if condition Added for ML-MMOH-CRF-0434 [IN057356] - Start
%>
							<tr id="tr_<%=recCount%>" >
<%
							if(module_id.equals("2")) { 
								//if(stock_opt.size()!=0 && ((String)stock_opt.get(0)).equals("N")) {
								if(!stock_avl) {
									image		=	"<img src='../../eCommon/images/disabled.gif' align='center'>";
								}
								else {
									image		=	"";
								}
								if(alt_drug.equals("Y") && alt_drug !=null) {//modified for ghl-crf-0548 	
								//GHL-CRF-0549 - start
									if(item_type_site_app){
										allow_alternate_yn = bean.getAllowAlternateYN(order_id,order_line_no,iv_prep_yn);
										if(allow_alternate_yn==null || allow_alternate_yn.equals(""))
											allow_alternate_yn = "N";
									}

									gif	=	"<img src='../../ePH/images/altenate.jpg' height='15' width='15' align='top' onClick=\"callMultiStrength('"+drug_code+"','"+drug_name_1+"','"+patient_id+"','"+order_id+"','"+order_line_no+"','"+source+"','"+store_code+"','"+pres_qty+"','"+end_date+"','"+strength_uom+"','"+recCount+"','"+alt_drug_remarks_ind+"','"+expiry_date+"','"+disp_locn_catg+"','"+allow_alternate_yn+"','"+item_type_site_app+"','"+strength_value+"','"+iv_prep_yn+"');\" style='cursor:pointer' title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AlternateDrugs.label","ph_labels")+"'>"; // '"+expiry_date+"' Added for ML-MMOH-0690 								//disp_locn_catg,allow_alternate_yn,item_type_site_app passed for GHL-CRF-0549 strength_value added for ghl-crf-0548
								}			
								else {
									gif	=	"";
								}
%>
								<td class="white" width="3%"><%=image%></td>
								<td class="white" width="3%"><%=gif%></td>
<%							//added for AMS-CRF-204 - start
							if(bl_install_yn.equals("Y") && !iv_prep_yn.equals("7") && !iv_prep_yn.equals("8") && item_type_site_app && !encounter_id.equals("")){	
									
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
									//System.err.println("drug_code=========>"+drug_code+"==hmBlgGrp===>"+hmBlgGrp);
									if(hmBlgGrp!=null && hmBlgGrp.size()>0){
										if(hmBlgGrp.containsKey(drug_code)){
											preference = (String)hmBlgGrp.get(drug_code)==null?"":(String)hmBlgGrp.get(drug_code);
											preference_img = "";
											if(preference.equals("P1")){
												preference_img ="<img src='../../ePH/images/Preference1.jpg' height='15' width='15' title='Prefered-1 Item' />";
											}else if(preference.equals("P2")){
												preference_img ="<img src='../../ePH/images/Preference2.jpg' height='15' width='15' title='Prefered-2 Item' />";
											}else if(preference.equals("P3")){
												preference_img ="<img src='../../ePH/images/Preference3.jpg' height='15' width='15' title='Prefered-3 Item' />";
											}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
											}
										}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
											}

									}
								} //GHL-CRF-0618 - end


								//System.err.println("DispMedicationFilling.jsp====low_cost_green_style==>"+low_cost_green_style+"==high_margin_green_style==>"+high_margin_green_style+"==low_cost_red_style==>"+low_cost_red_style+"==high_margin_red_style==>"+high_margin_red_style);
								
									
%>								<td class='<%=classvalue%>' width="5%" nowrap>&nbsp;
								<%if(!low_cost_green_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCostGreen.jpg" style='<%=low_cost_green_style%>' height='15' width='15' title='<fmt:message key="ePH.Matched.label" bundle="${ph_labels}"/>'><%}
								if(!high_margin_green_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMarginGreen.jpg" style="<%=high_margin_green_style%>" height='15' width='15' title='<fmt:message key="ePH.Matched.label" bundle="${ph_labels}"/>' >
								<%}if(!low_cost_red_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCostRed.jpg" style="<%=low_cost_red_style%>" height='15' width='15' title='<fmt:message key="ePH.NotMatched.label" bundle="${ph_labels}"/>'><%}if(!high_margin_red_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMarginRed.jpg" style="<%=high_margin_red_style%>" height='15' width='15' title='<fmt:message key="ePH.NotMatched.label" bundle="${ph_labels}"/>'><%} if(!low_cost_grey_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCost.jpg" title="Low Cost Item"  style="<%=low_cost_grey_style%>" height='15' width='15' ><%} if(!high_margin_grey_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMargin.jpg" style="<%=high_margin_grey_style%>" height='15' width='15' title="High Margin Item"  ><%}if(!innovator_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/Innovator.jpg" style="<%=innovator_style%>"  title="Innovator Item"  height='15' width='15' > <%} %></td>
								<%if(formulary_billing_app){ //GHL-CRF-0618 %>								
									<td class="<%=classvalue%>"><%=preference_img%>&nbsp;</td>
<%									}
								}	
								%>
							 
							<%		//added for AMS-CRF-204 - End
								%>
								<!-- <td class="white" width="3%">&nbsp;&nbsp;&nbsp;&nbsp;</td> -->
								<td class="<%=classvalue%>" width="3%"><label style="cursor:pointer;color:blue;font-size:9" onclick="showDrugDetails('','','<%=order_id%>','<%=drug_code%>','<%=order_line_no%>','ALLOC','<%=bean_1.getDispLocnCode()%>','','', '<%=patient_id%>');"><fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/></label></td>  <!--  , 'patient_id' added for [IN:035667] -->
<%
							}	
							if( !image.equals("")) {
								style				=	"font-weight:bold";
								call_function		=	"";
							}
%>
							<td class="<%=classvalue%>" style="font-size:9;" width="<%=width_1%>"><label style="<%=style%>" onmouseover='resetQtyValue()' onclick="<%=call_function%>" id="drug_desc<%=recCount%>">&nbsp;<%=drug_name%>&nbsp;<%=strength_value%>&nbsp;<%=strength_uom%></label>&nbsp;&nbsp;
<% 
							if ((ext_prod_id!=null)&& !(ext_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){
%>
								<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=ext_prod_id%>','<%=drug_name_1%>')"></img>
<%
							}
							if(adr_count>0){
%>
						         <img  id="ADR_img" src='../../ePH/images/ADR.gif'  height='20'  width='20' title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>'></img>
<%
							}
%>
							<%=alt_drug_remarks_disp%><!-- added for  Bru-HIMS-CRF-082 [IN:029948] -->
<%
							if(module_id.equals("1")) 
								onClick="callDrugEntry";
							else
								onClick="callStockEntry";

							int	k	=	0;
							int alt_drug_count = 0; //added for  ML-BRU-SCF-0474[IN035407]
							alt_qty	=	new ArrayList();
							int alt_drug_line_no=1;  //added for  ML-BRU-SCF-0474[IN035407]
							String alt_drug_desc_1 = "";
							for(int n=0; n<multi_drugs.size(); n+=5)	{ 
								alt_drug_code			=	(String)multi_drugs.get(n);
								alt_drug_desc			=	(String)multi_drugs.get(n+1);
								alt_drug_desc_1	=    alt_drug_desc;
								if(alt_drug_desc_1!=null && !alt_drug_desc_1.equals("")){
									alt_drug_desc_1=alt_drug_desc_1.replaceAll(" ","%20");
									//alt_drug_desc_1=	java.net.URLEncoder.encode(alt_drug_desc_1);
									alt_drug_desc_1  =	java.net.URLEncoder.encode(alt_drug_desc_1,"UTF-8");
									alt_drug_desc_1  = alt_drug_desc_1.replaceAll("%2520","%20");
								}
								form_code				=	(String)multi_drugs.get(n+2);
								alt_strength_value		=	(String)multi_drugs.get(n+3);
								alt_strength_uom		=	(String)multi_drugs.get(n+4);
								drug_color				=	(String)colors.get(k++);
								pack_dtls				=	bean.getPackSize(alt_drug_code);
								fractroundupyn          =   bean.getFractRoundupYN(alt_drug_code);
								//!medical_applicable.equals("Y") added for ghl-crf-0548 
								if(!medical_applicable.equals("Y") && Float.parseFloat(alt_strength_value)<1  )
									alt_strength_value =( Float.parseFloat(alt_strength_value))+"";

								if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
									form_code	=	(String)pack_dtls.get("STOCK_UOM");
								}

								if(pack_dtls!=null && pack_dtls.containsKey("EXTERNAL_PRODUCT_ID")) {
									alt_external_prod_id	=	(String)pack_dtls.get("EXTERNAL_PRODUCT_ID");
								}
								else{
									alt_external_prod_id	= "";
								}
								qty		=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 
								if(!qty.equals("") && !qty.equals("0")) {
									alt_qty.add(alt_drug_code);
									alt_qty.add(qty);
									alt_qty.add(form_code);
									alt_qty.add(alt_strength_value);
								}
								adr_count = bean.getADRCount(patient_id,alt_drug_code);
								/*
								if(!strength_value.equals("") && !alt_strength_value.equals("")) {
									prod_qty			=	Float.parseFloat(strength_value) / Float.parseFloat(alt_strength_value);
									bms_qty				=	new Float(prod_qty  * Float.parseFloat(bms_qty))+"";
								} */

								/*ArrayList link_reqd		=	bean.getAlternateDrugLinkReqd(patient_id,order_id,order_line_no,new Float(bms_qty).intValue());

								if(link_reqd.size() >=1) {
										if(link_reqd.contains(alt_drug_code)) {
												style		=	"cursor:pointer;color:"+drug_color;
										}
										else {
												style		="font-weight:bold";
												onClick		=	"";
										}
								}
								else { */
								style		="cursor:pointer;color:"+drug_color;
								//}
%>	
								<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style="<%=style%>" onclick="<%=onClick%>('<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','<%=drug_name_1%>','<%=alt_drug%>','<%=alt_drug_code%>','<%=alt_drug_desc_1%>','<%=drug_color%>','<%=form_code%>','<%=tmp_bms_qty%>','<%=source%>','<%=recCount%>','<%=strength_value%>','<%=alt_strength_value%>','<%=end_date%>','<%=form_code%>','<%=drug_class%>','<%=stk_qty%>','<%=min_end_date%>','<%=main_strength_per_value_pres_uom%>','','<%=alt_drg_no%>','<%=alt_strength_uom%>','<%=alt_drug_line_no%>','<%=facility_id%>','<%=bean_1.getDispLocnCode()%>');"  id="alte_drug_desc<%=recCount%>_<%=n%>"><%=alt_drug_desc%>&nbsp;<%=alt_strength_value%><%=bean.getUomDisplay(facility_id,alt_strength_uom)%>&nbsp;</label><!-- added alt_drug_line_no for  ML-BRU-SCF-0474[IN035407] -->
<%
								if ((alt_external_prod_id!=null)&& !(alt_external_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){
%>
									<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=alt_external_prod_id%>','<%=alt_drug_desc_1%>')"></img>
<%
								}
								if(adr_count>0){
%>
									<img  id="ADR_img" src='../../ePH/images/ADR.gif' height='20'  width='20'  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>'></img>
<%
								}
								alt_drug_count=alt_drug_line_no; //added for  ML-BRU-SCF-0474[IN035407]
								alt_drug_line_no++; //added for  ML-BRU-SCF-0474[IN035407]
							}
%>
							</td>
<%
							if(multi_drugs.size() > 1 ) {
%>
	
								<td class="<%=classvalue%>" width="<%=width_2%>"><br>
<%
								int x			=	0;
								String alternate_drug		=	"";
								float pack_size				=	1;
								float strength_per_value	=	1.0f;
								prescribed_strength	=0;
								int alt_assign_drug_line_no=1; // added for  ML-BRU-SCF-0474[IN035407]
								HashMap IssueUOMAndBaseUOM       = new HashMap(); // added for ML-BRU-SCF-1892 - Start
								String base_uom				     = "";	
								String orig_dflt_issue_uom		= "";
								double base_to_disp_uom_equl     = 0;
								double base_to_def_uom_equl      = 1; // added for ML-BRU-SCF-1892 - End
								for(int l=0; l<alt_qty.size(); l+=4) { 
									alt_drug_alloc_qty = 0;		//added for  ML-BRU-SCF-0474[IN035407]
									alternate_drug		=	(String)alt_qty.get(l);	
									qty					=	(String)alt_qty.get(l+1);	
									uom					=	(String)alt_qty.get(l+2);	
									alt_strength_value	=	(String)alt_qty.get(l+3);	
									drug_color			=	(String)colors.get(x++);
									pack_dtls			=	bean.getPackSize(alternate_drug);
									
									IssueUOMAndBaseUOM.clear(); // added for ML-BRU-SCF-1892 - Start
									IssueUOMAndBaseUOM		=	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(store_code,alternate_drug); 
									base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("BASE_UOM");
									base_to_disp_uom_equl    =	bean.getEqulValue ( alternate_drug, base_uom, uom);
									orig_dflt_issue_uom      = (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
									base_to_def_uom_equl	 =  bean.getEqulValue ( alternate_drug, base_uom, orig_dflt_issue_uom); // added for ML-BRU-SCF-1892 - End
									
									if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
										if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
											pack_size			=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));
											if(!medical_applicable.equals("Y")){//added for ghl-crf-0548
											strength_per_value	=	Float.parseFloat(((String)pack_dtls.get("STRENGTH_PER_VALUE_PRES_UOM")));
											  if(base_to_disp_uom_equl!=base_to_def_uom_equl ){ // if condition Added for ML-BRU-SCF-1892 // || (!uom.equals(base_uom) && !alternate_drug.equals("")) Added for ML-MMOH-SCF-1160					
												//|| (!uom.equals(base_uom) && !alternate_drug.equals("")) commented for ML-MMOH-SCF-1318
											     qty = Math.ceil(Float.parseFloat(qty)/pack_size)+"";//Added for ML-BRU-SCF-1443 and removed math.round(Integer.parseInt Math.ceil(Float.parseFloat to math.ceil for MMS-KH-SCF-0035
												 
											  }else if(!uom.equals(base_uom) && !alternate_drug.equals("") ){ // else if block added for ML-MMOH-SCF-1318 - Start							
												  qty  =   Math.round(Double.parseDouble(qty)/base_to_disp_uom_equl)+""; 
											  }
											  }
										}		
									}
									if(!medical_applicable.equals("Y")){//added for ghl-crf-0548
									tmp_alloc	+=	 ((Float.parseFloat(alt_strength_value)) * Float.parseFloat(qty)*pack_size)/strength_per_value ;//Changed Integer.parseInt to Float.parseFloat for MMS-KH-SCF-0115 
									alt_drug_alloc_qty = ((Float.parseFloat(alt_strength_value)) * Float.parseFloat(qty)*pack_size)/strength_per_value ;  //added for  ML-BRU-SCF-0474[IN035407]//Changed Integer.parseInt to Float.parseFloat for MMS-KH-SCF-0115 
									}
									if(fractroundupyn.equals("N")) {
										alloc_strength	=	tmp_alloc+""+strength_uom;
									}
									else{
										alloc_strength	=  "";
									}
									//pres_qty		=	bms_qty;
									prescribed_strength	=   0;
									if(strength_value.equals(""))
										strength_value	=	"0";
									prescribed_strength	=	Float.parseFloat(tmp_bms_qty_1) * 	Float.parseFloat(strength_value)/Float.parseFloat(main_strength_per_value_pres_uom);

									if(strength_value.equals("0"))
										strength_value	=	"";

									float balance_strength		=	prescribed_strength - tmp_alloc;
									if(balance_strength<1)
										balance_strength		=	0;
										if(fractroundupyn.equals("N")||fractroundupyn.equals("")) {
											if(balance_strength!=0) {
												bms_qty						=	Math.round(balance_strength / Float.parseFloat(strength_value))+"";
											} 
											else {
												//bms_qty	+=	bms_qty+(Float.parseFloat(pres_qty)- Float.parseFloat(qty)) +"";
												if(!medical_applicable.equals("Y"))//added for ghl-crf-0548
												bms_qty						=	"0";
											}
										}
										else{
											// bms_qty             =   bms_qty;
											 if(strength_value.equals(""))
												 strength_value="0";
												 bms_qty						=	Math.round(balance_strength / Float.parseFloat(strength_value))+"";
											if(strength_value.equals("0"))
												strength_value="";
										} 
										bms_qty=Math.round((Float.parseFloat(bms_qty)*(Float.parseFloat(main_strength_per_value_pres_uom))/main_pack_size))+"";
										bms_strength				=	balance_strength+"";

										if(!qty.equals("") && !qty.equals("0")) {
											tot_qty		+=	Double.parseDouble(qty);
											// tot_qty     =	tot_qty*pack_size;
											qty_found	=	true;
										}
%>
										<label style="color:<%=drug_color%>;font-size:9">&nbsp;<%=qty%>&nbsp;<%=bean.getUomDisplay(facility_id,uom)%><br>
										<input type="hidden" name="alt_tmp_alloc_<%=recCount%>_<%=alt_assign_drug_line_no%>" id="alt_tmp_alloc_<%=recCount%>_<%=alt_assign_drug_line_no%>" value="<%=alt_drug_alloc_qty%>"> <!-- added for  ML-BRU-SCF-0474[IN035407] -->
  <% 
										alt_assign_drug_line_no++ ;// added for  ML-BRU-SCF-0474[IN035407]
									}
									/*if(!alt_strength_value.equals("")) {
									alloc_strength	=	Integer.parseInt(alt_strength_value) * tot_qty+"";
									alloc_strength	=	(Integer.parseInt(alloc_strength)==0)?"":alloc_strength+" "+strength_uom;
									} */
%>
									</label>&nbsp;
									<%if(!alloc_strength.equals("0.0") && !alloc_strength.equals("")){ //added for ghl-crf-0548%>
									<label style="font-size:9;color:black"><b><%=alloc_strength%></b></label>
									<%} %>
									</td>
<%
								}
								else	{	
									if(qty.equals("") || qty.equals("0")) { 
										uom	=	"";	
										qty	=	"";
									}
									else 
										uom=qty_uom;

									if(!qty.equals("") && !qty.equals("0")) {
										qty_found	=	true;

										if(!strength_value.equals("") )
											alloc_strength	=	Float.parseFloat(strength_value) * Double.parseDouble(qty)+" "+strength_uom;
									}
%>
									<td class="<%=classvalue%>" width="<%=width_2%>" id="allocate_qty_<%=recCount%>" style="font-size:9"><label class="label">&nbsp;<%=retunFormatedInt(qty)%>&nbsp;<%=bean.getUomDisplay(facility_id,uom)%></label></td>
										<input type="hidden" name="pres_qty_<%=recCount%>" id="pres_qty_<%=recCount%>" value="<%=pres_qty%>">
										<input type="hidden" name="bms_qty_<%=recCount%>" id="bms_qty_<%=recCount%>" value="<%=tmp_bms_qty%>">
<%	
								}
								if(multi_drugs.size() > 1 ) { 
									/* if(fractroundupyn.equals("Y")){
									   bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
									 }*/
									//if(tot_qty > 0) {
									//}
									/*
									if( Float.parseFloat(strength_value) > Float.parseFloat(alt_strength_value) ) {
										if(tot_qty > 0)
											bms_qty	=	Float.parseFloat(pres_qty) - (tot_qty / prod_qty)+"";
										else 
											bms_qty	=	(Float.parseFloat(bms_qty) / prod_qty)+"";
										}
										else {
											if(tot_qty!=0){
												bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
											}
										} */
										if(medical_applicable.equals("Y")){
										if((Float.parseFloat(bms_qty)- tot_qty)>0)
										bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
									else{
										bms_qty="0";
									}
										}
										
								}
								else {
									if(!qty.equals("") && !qty.equals("0")){
										bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
									}
								}
										
								if(!strength_value.equals("") && !alt_strength_value.equals("")) {
									if(bms_strength.equals(""))
										bms_strength		=	Float.parseFloat(bms_qty_1) * Float.parseFloat(strength_value)+"";	
										//bms_strength		=	Float.parseFloat(bms_qty) * Float.parseFloat(alt_strength_value)+"";

								}
								else if(!strength_value.equals("")) {
									//bms_strength		=	Float.parseFloat(bms_qty) * Float.parseFloat(strength_value)+"";
									bms_strength		=	"";
									strength_uom		=	"";
								}
								else 
									strength_uom	=	"";

								if(bms_qty.indexOf(".")!=-1) {
									int pos	=	bms_qty.indexOf(".");
									if(bms_qty.length() > (pos+3) )
										bms_qty	=	bms_qty.substring(0,(pos+3));
								}

								if(fractroundupyn.equals("Y")) {
									bms_strength_1="";
									strength_uom="";  
								}
								else{
									bms_strength_1=bms_strength;
								}
								//bms_strength_1 =(Float.parseFloat(bms_strength_1)/main_pack_size)+"";
								if(!bms_strength.equals("") && !bms_strength.equals("0.0")){//added for ghl-crf-0548
									 bms_strength =Float.parseFloat(bms_strength)/(Float.parseFloat(main_strength_per_value_pres_uom))+"";
								}
								else
								bms_strength_1="";
%>
								<input type="hidden" name="bms_strength<%=recCount%>" id="bms_strength<%=recCount%>" value="<%=bms_strength%>">
								<input type="hidden" name="prescribed_strength<%=recCount%>" id="prescribed_strength<%=recCount%>" value="<%=prescribed_strength%>">
								<input type="hidden" name="dischargeIND<%=recCount%>" id="dischargeIND<%=recCount%>" value="<%=dischargeIND%>">
								<input type="hidden" name="alt_drug_count_<%=recCount%>" id="alt_drug_count_<%=recCount%>" value="<%=alt_drug_count%>"><!--added for  ML-BRU-SCF-0474[IN035407] -->
								<td class="<%=classvalue%>" width="<%=width_3%>" style="font-size:9" id="bms_det_<%=recCount%>"> &nbsp;<%=pres_qty%>&nbsp;<b>(<%=retunFormatedInt(bms_qty)%>)</b>&nbsp;<%=qty_uom_disp%><br>&nbsp;<b><%=bms_strength_1%></b>&nbsp;<%=strength_uom_disp%>
								<!--/*bean.getUomDisplay(facility_id,qty_uom)*/-->
								</td>	
							</tr>
<%
						//}  //Commented for RUT-CRF-0088 [IN036978]
					recCount++;
			} // Added for ML-MMOH-CRF-0434 [IN057356] - End
					}

				if(!multi_found) {
					bean.setMultiFound(multi_found);
				}
%>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
			<input type="hidden" name="qty_found" id="qty_found" value="<%=qty_found%>">
			<input type="hidden" name="tot_rec" id="tot_rec" value="<%=recCount%>">
			<input type="hidden" name="oper_mode" id="oper_mode" value="">
			<input type="hidden" name="resetQty" id="resetQty" value="<%=resetQty%>">
			<input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%=iv_prep_yn%>">

			<input type="hidden" name="tmp_alloc_val" id="tmp_alloc_val" value="<%=tmp_alloc%>">	 <!--added by Manickavasagam J for SCF-6259 -->

			<input type="hidden" name="bms_strength_val" id="bms_strength_val" >				<!--added by Manickavasagam J for SCF-6259 -->
			<input type="hidden" name="prescribed_bms_strength_val" id="prescribed_bms_strength_val" >  <!--added by Manickavasagam J for SCF-6259 -->
			<input type="hidden" name="alt_strength_value" id="alt_strength_value">			   <!--added by Manickavasagam J for SCF-6259 -->	
			<input type="hidden" name="alt_drug_line_no" id="alt_drug_line_no">			   <!--added for  ML-BRU-SCF-0474[IN035407] -->	
			<input type="hidden" name="alt_drug_count" id="alt_drug_count">			   <!--added for  ML-BRU-SCF-0474[IN035407] -->	
			<input type="hidden" name="main_drug_line_no" id="main_drug_line_no">			   <!-- added for  ML-BRU-SCF-0474[IN035407] -->	
			<input type="hidden" name="alt_drug_remarks_ind" id="alt_drug_remarks_ind" value='<%=alt_drug_remarks_ind%>'>			   <!-- added for Bru-HIMS-CRF-082 [IN:029948] -->	
			<input type="hidden" name="expiry_date" id="expiry_date" value='<%=expiry_date%>'><!--added for ML-MMOH-SCF-0690 -->	
		</form>
	</body>
	<script>
<%! 
		DecimalFormat dfToInteger = new DecimalFormat("#.##");
		private String retunFormatedInt(String sValue){
			if(sValue != null && !sValue.equals("")){
				return dfToInteger.format(Double.parseDouble(sValue));
			}
			return "";
		}

%>
<%
		if(!alt_drg_sel.equals("Y")){
			int rno	=	0;
			if(!recno.equals(""))
				rno		=	Integer.parseInt(recno);
			++rno;	
%>
		clickNextDrug('<%=rno%>',document,window,'','','','<%=source%>');
<%
		}
		else{
			if(re_load_yn.equals("Y")){
%>
				clickNextDrug('<%=recno%>',document,window,'<%=alt_drg_no%>');
<%
			}
			else{
%>
				clickNextDrug('<%=recno%>',document,window);
<%
			}
		}
%>
	</script>
</html>
<%
	putObjectInBean(param_bean_id,param_bean,request);
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_1,bean_1,request);
				}
				 catch(Exception e){
			          	e.printStackTrace();
			          }
			          finally{ // Added for ML-MMOH-SCF-0468 - start
			          	
			          	if(con != null)
			          		ConnectionManager.returnConnection(con,request);	
			          } // Added for ML-MMOH-crf-0468 end

%>


<!DOCTYPE html>
<!--saved on 27th Oct 2005 -->
<!--saved on 25th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%
/*
 ------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------	
28/04/2020  IN:071537        B Haribabu                                         GHL-CRF-0614
28/07/2020      IN:073485                   Haribabu                                PH-MMS-DM-CRF-0165/01-Normal rx-Amend order
24/08/2020      IN073769		   B Haribabu                                           PHIS-PH-Alpha - Exceed Dosage Limit Icon not opening in CA place order
02/09/2020  	IN073795                Manickavasagam J                       MMS-KH-CRF-0034.4[73844]
13/05/2021  	TFS id:-16701	     Manickavasagam J                                    RBU-GHL-CRF-0004 
-------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper,java.sql.*,webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%> 
<%
request.setCharacterEncoding("UTF-8");
Connection con			= null;
	try{
		con				= ConnectionManager.getConnection(request);
		String classValue		= ""; 
		String prev_order_code	= "";
		String patient_id		= request.getParameter("patient_id"); 
		String encounter_id		= request.getParameter("encounter_id");
		String patient_class	= request.getParameter("patient_class");
		String mode				= CommonRepository.getCommonKeyValue( "MODE_INSERT" );

		String drug_db_interface_yn      =  request.getParameter("DRUG_DB_INTERFACE_YN")==null?"":request.getParameter("DRUG_DB_INTERFACE_YN");//Modified for IN:071537
		String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name		= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 bean	= (PrescriptionBean_1)getBeanObject( bean_id, bean_name,request );
		String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
		String presBean_name		= "ePH.PrescriptionBean";
		PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );
		bean.setCalExtDBYN("Y");//Added for TFS id:-16701
		String or_bean_name		= "eOR.OrderEntryBean";
		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean	= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;

		String called_from		=	orbean.getCalledFromFunction();
		String bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
		String bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
        
		String adr_count	    = request.getParameter("adr_count")==null?"":request.getParameter("adr_count");
   		int drug_adr_count = 0;

		String drug_db_duptherapy_check_yn = request.getParameter("DRUG_DB_DUPTHERAPY_YN")==null?"":request.getParameter("DRUG_DB_DUPTHERAPY_YN");//Modified for IN:071537
		String drug_db_allergy_check_yn = request.getParameter("DRUG_DB_ALLERGY_CHECK_YN")==null?"":request.getParameter("DRUG_DB_ALLERGY_CHECK_YN");//Modified for IN:071537
		String conf_drug_code	    = request.getParameter("conf_drug_code")==null?"":request.getParameter("conf_drug_code");
		String conf_srl_no  = request.getParameter("conf_srl_no")==null?"":request.getParameter("conf_srl_no");
		boolean isAmendTaper = false;  //Added for ML-MMOH-CRF-2155.1
		isAmendTaper		= eCommon.Common.CommonBean.isSiteSpecific(con,"PH","JOB_QUEUE_REPORT"); //Added for ML-MMOH-CRF-2155.1		
%>
		<html>
			<head>
				<script language="JavaScript" src="../../eCommon/js/common.js"></script>
				<script language="JavaScript" src="../js/Prescription_1.js"></script>
				 <script language="JavaScript" src="../js/Prescription_2.js"></script>
				<script language="JavaScript" src="../js/PrescriptionTest.js"></script>
				<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
				<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
				<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
				String locale = (String) session.getAttribute("LOCALE");
				bean.setLanguageId(locale);

				String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
				<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			</head>
			<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
				ArrayList presDetails	= (ArrayList) bean.getpresDetails();

				String tmp_srl_no		=	null;
				String tmp_drug_code	=	null;
				HashMap drugDetails		=	null;
				String drug_code		=	null;
				String srl_no			=	null;
				String drug_desc		=	null;
				String generic_name		=	null, drug_name="";
				//Below generic_id is added by sureshkumar T for the ICN No :32596 on 08/05/2012
				String generic_id       =   null;
				String qty_value		=	null;
				String qty_desc			=	null;
				String freq_desc		=	null;
				String durn_value		=	null;
				String durn_desc		=	null;
				String tapered_yn		=	null;
				String order_type_code	=	null;
				String order_type_desc	=	null;
				String scheduled_yn		=	null;
				String amended_yn		=	null;
				ArrayList duplicate_dates	=	null;
				String drug_start_date		=	"";
				String drug_end_date		=	"";
				String dup_start_date		=	"";
				String dup_end_date			=	"";
				String dup_drug_code		=	"";
				String dup_srl_no			=	"";
				String dup_drug_desc		=	"";

				String order_id			= (String) orbean.getOrderId();
				String tapergif			= "";
				String alg_reason		= "";
				String dsg_reason	    = "";
				String dup_reason	    = "";
				String tooltip				= "";
				String available_stock		= "";
				String stock_available_yn	= "";
				String allow_pres_without_stock_yn	=	"";
				String stock_uom					=	"";
				String con_reason ="";
				String int_reason ="";
				String ext_prod_id="";
				String drug_db_dosage_check_flag    = "";
				String drug_db_duptherapy_flag		= "";
				String drug_db_contraind_check_flag	= "";
				String drug_db_interact_check_flag	= "";
				String drug_db_allergy_flag			= "";
				String ext_checks					="";
				String ext_checks_overrided			="";
				String sliding_scale_yn				="";
				String recomm_yn					="";
				String current_rx					="";
				String allergy_yn					="";
				String limit_ind					="";
				String allergy_override				="";
				String currentrx_override			="";
				String dose_override				="";
				String currrx_override_gif			="";
				String allergy_override_gif			="";
				String durn_type					="";
				boolean all_amended					=true;
				/* code Added for ML-BRU-SCF-0190[32621] -- Start*/
				boolean any_amended					=false;  
				String order_line_number			= "";				
				HashSet<Integer> amend_order_line_number = new HashSet<Integer>(); 
				String temp_patient_class	= "";
				String taper				= "";				
				String order_line_no		= "";				
				String taper_drug_code		= "";
				boolean contain_taper_drug 	= false;	
			    String interaction_exists=""; 
			    String abuse_exists	=	"", abuse_action="U",abuse_restric_trn="N", abuse_msg_content="", abuse_override ="",abuse_reason="" ;//added for AAKH-CRF-140
				String abuse_override_remarks="";
				HashMap drugDetail			= null;
				HashMap taperDetail			= new HashMap();
				HashSet taper_drug_count	= new HashSet();
				for(int i=0;i<presDetails.size();i++){
					drugDetail			= (HashMap) presDetails.get(i);
					temp_patient_class	=  (String)drugDetail.get("PATIENT_CLASS")==null?"":(String)drugDetail.get("PATIENT_CLASS");
					taper				= (String)drugDetail.get("TAPERED_YN")==null?"":(String)drugDetail.get("TAPERED_YN"); 
					order_line_no		=  (String)drugDetail.get("ORDER_LINE_NUM")==null?"":(String)drugDetail.get("ORDER_LINE_NUM");					
					taper_drug_code		=  (String)drugDetail.get("DRUG_CODE")==null?"":(String)drugDetail.get("DRUG_CODE");
					
					if(	(temp_patient_class.equals("OP") || temp_patient_class.equals("XT"))&& taper.equals("Y") ){
						taperDetail.put(order_line_no,taper_drug_code);	
						contain_taper_drug = true;
					}	
				}
				/* code Added for ML-BRU-SCF-0190[32621] -- End*/
%>
				<form name="prescription_form" id="prescription_form" >
<%
                //commented during PE By Naveen added in drug details
					/*ArrayList stock_params	=	bean.validateForStock(patient_class);
					if(stock_params.size()==2) {
						allow_pres_without_stock_yn	=	(String)stock_params.get(1);
					}*/
					if(presDetails.size()>0){
						classValue="SELECTEDRUGS";
%>
						<table border="1" width="100%" cellspacing="0" cellpadding="0" id="Selected_drugs">
<%
						for(int i=0;i<presDetails.size();i++){
							classValue	=	"SELECTEDRUGS";
							drugDetails		= (HashMap) presDetails.get(i);
							allow_pres_without_stock_yn	=	CommonBean.checkForNull((String)drugDetails.get("ALLOW_PRES_WITHOUT_STOCK_YN"));
							drug_code			= CommonBean.checkForNull((String)drugDetails.get("DRUG_CODE"));
							srl_no				= CommonBean.checkForNull((String)drugDetails.get("SRL_NO"));
							drug_desc			= CommonBean.checkForNull((String)drugDetails.get("CATALOG_DESC"));
							drug_name			= CommonBean.checkForNull((String)drugDetails.get("CATALOG_DESC"));
							generic_name		= CommonBean.checkForNull((String)drugDetails.get("GENERIC_NAME"));
							//Below generic_id is added by sureshkumar T for the ICN No :32596 on 08/05/2012
							generic_id          = CommonBean.checkForNull((String)drugDetails.get("GENERIC_ID"));
							qty_value			= CommonBean.checkForNull((String)drugDetails.get("QTY_VALUE"));
							if(called_from.equals("RENEW_ORDER")) //if block added for Bru-HIMS-CRF-400 [IN:044502]
								order_id		= (String) drugDetails.get("ORDER_ID");

							qty_desc			= CommonBean.checkForNull((String)drugDetails.get("QTY_UNIT"));
							freq_desc			= CommonBean.checkForNull((String)drugDetails.get("FREQ_DESC"));
							freq_desc			= freq_desc.replaceAll("%26","&");
							freq_desc			= freq_desc.replaceAll("%40","@");
							freq_desc			= freq_desc.replaceAll("%20"," "); 

							durn_value			= CommonBean.checkForNull((String)drugDetails.get("DURN_VALUE"));
							durn_desc			= CommonBean.checkForNull((String)drugDetails.get("DURN_DESC"));
							durn_type			= CommonBean.checkForNull((String)drugDetails.get("DURN_TYPE"));
							tapered_yn			= CommonBean.checkForNull((String)drugDetails.get("TAPERED_YN"));
							order_type_code	= CommonBean.checkForNull((String)drugDetails.get("ORDER_TYPE_CODE"));
							order_type_desc	= CommonBean.checkForNull((String)drugDetails.get("ORDER_TYPE_DESC"));
							scheduled_yn		= CommonBean.checkForNull((String) drugDetails.get("SCHEDULED_YN"));
							amended_yn			= (String) drugDetails.get("AMENDED_YN")==null?"":(String) drugDetails.get("AMENDED_YN");
							available_stock	= CommonBean.checkForNull((String) drugDetails.get("AVAILABLE_STOCK"));
							stock_available_yn	= CommonBean.checkForNull((String) drugDetails.get("STOCK_AVAILABLE_YN"));
							stock_uom			= CommonBean.checkForNull((String) drugDetails.get("STOCK_UOM_DESC"));
							alg_reason		= CommonBean.checkForNull((String)drugDetails.get("ALLERGY_REMARKS"));
							dsg_reason		= CommonBean.checkForNull((String)drugDetails.get("DOSE_REMARKS"));
							dup_reason	= (String)drugDetails.get("CURRENTRX_REMARKS")==null?"":(String)drugDetails.get("CURRENTRX_REMARKS");
							sliding_scale_yn	= (String)drugDetails.get("SLIDING_SCALE_YN");
							
							allergy_yn = (String)drugDetails.get("ALLERGY_YN")==null?"":(String)drugDetails.get("ALLERGY_YN");
							current_rx = (String)drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");
							limit_ind = (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
							if(dup_reason.equals("")){
								currentrx_override = "N";
								drugDetails.put("CURRENTRX_OVERRIDE","N");
							}
							else{
								currentrx_override = "Y";
								drugDetails.put("CURRENTRX_OVERRIDE","Y");
							}
							if(alg_reason.equals("")){
								allergy_override = "N";
								drugDetails.put("ALLERGY_OVERRIDE","N");
							}
							else{
								allergy_override = "Y";
								drugDetails.put("ALLERGY_OVERRIDE","Y");
							}
							if(dsg_reason.equals("")){
								dose_override = "N";
								drugDetails.put("DOSE_OVERRIDE","N");
							}
							else{
								dose_override = "Y";
								drugDetails.put("DOSE_OVERRIDE","Y");
							}

							if(currentrx_override!=null && currentrx_override.equals("N")){
								currrx_override_gif="<img src='../../ePH/images/exceed1.gif' id=currentrx"+srl_no+"></img>";
							}
							else{
								currrx_override_gif="&nbsp;";
							}
							if(allergy_override!=null && allergy_override.equals("N")){
								allergy_override_gif="<img src='../../ePH/images/exceed1.gif' id=allergy"+srl_no+"></img>";
							}
							else{
								allergy_override_gif="&nbsp;";
							}

							recomm_yn	= (String)drugDetails.get("RECOMM_YN");

							ext_prod_id			= (String)drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drugDetails.get("EXTERNAL_PRODUCT_ID");
							con_reason = (String) drugDetails.get("CONTRAIND_OVERRIDE_REASON") == null?"": (String) drugDetails.get("CONTRAIND_OVERRIDE_REASON");
							int_reason = (String) drugDetails.get("INTERACTION_OVERRIDE_REASON") == null?"": (String) drugDetails.get("INTERACTION_OVERRIDE_REASON");
							//Added for IN:073485 
							if(int_reason.equals(""))
								int_reason = (String) drugDetails.get("LAB_INTERACTION_REMARKS") == null?"": (String) drugDetails.get("LAB_INTERACTION_REMARKS");
							if(int_reason.equals(""))
								int_reason = (String) drugDetails.get("FOOD_INTERACTION_REMARKS") == null?"": (String) drugDetails.get("FOOD_INTERACTION_REMARKS");
						        //Added for IN:073485 
							if(int_reason.equals(""))//Added for MMS-DM-CRF-0229
								int_reason = (String) drugDetails.get("DISEASE_INTERACTION_REMARKS") == null?"": (String) drugDetails.get("DISEASE_INTERACTION_REMARKS");
							interaction_exists			= (String) drugDetails.get("INTERACTION_EXISTS")==null?"N": (String) drugDetails.get("INTERACTION_EXISTS");
							abuse_exists	= (String) drugDetails.get("ABUSE_EXISTS")==null?"N": (String) drugDetails.get("ABUSE_EXISTS");
							 abuse_restric_trn=(String) drugDetails.get("ABUSE_RESTRIC_TRN")==null?"N": (String) drugDetails.get("ABUSE_RESTRIC_TRN");
							  abuse_action=(String) drugDetails.get("ABUSE_ACTION")==null?"U": (String) drugDetails.get("ABUSE_ACTION");
													String ext_beanid = "@ExternalProductLinkBean";
							String ext_beanname = "ePH.ExternalProductLinkBean";
							ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);
							
							drug_db_dosage_check_flag      =	 (String)drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG");		
							drug_db_contraind_check_flag	= (String)drugDetails.get("DRUG_DB_CONTRAIND_CHECK_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_CONTRAIND_CHECK_FLAG");		
							drug_db_interact_check_flag	=  (String)drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG");		
							drug_db_duptherapy_flag		=  (String)drugDetails.get("DRUG_DB_DUPTHERAPY_YN")==null?"":(String)drugDetails.get("DRUG_DB_DUPTHERAPY_YN");	//Modified for IN:071537	
							drug_db_allergy_flag		=  (String)drugDetails.get("DRUG_DB_ALLERGY_CHECK_YN")==null?"":(String)drugDetails.get("DRUG_DB_ALLERGY_CHECK_YN");//Modified for IN:071537	
							
							order_line_number		=  (String)drugDetails.get("ORDER_LINE_NUM")==null?"":(String)drugDetails.get("ORDER_LINE_NUM");// code Added for ML-BRU-SCF-0190[32621]
							if(temp_patient_class.equals("OP")||temp_patient_class.equals("XT")|| temp_patient_class.equals("EM"))
								bean.setDispLocnCatg("O");	// code Added for ML-BRU-SCF-0190[32621] -- temp_patient_class
							else
								bean.setDispLocnCatg("I");	// code Added for ML-BRU-SCF-0190[32621] -- temp_patient_class
							
							/* Commented for Perfomence 
							if(!drugDetails.get("EXTERNAL_PRODUCT_ID").equals("")){
								if(drug_db_allergy_check_yn.equals("Y") ){
									ArrayList ex_prod_ids =new ArrayList();
									ex_prod_ids.add(ext_prod_id);
									ext_beanObj.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result
									HashMap drug_alergies =(HashMap)ext_beanObj.getDrugAlergies();
									if(drug_alergies.containsKey(ext_prod_id)){
										drug_db_allergy_flag="Y";
										drugDetails.put("DRUG_DB_ALLERGY_FLAG","Y");
									}	
								}
								if(drug_db_duptherapy_check_yn !=null &&  drug_db_duptherapy_check_yn.equals("Y")){ 
								   String dup_drug_det			= ext_beanObj.isDuplicateTherapy(ext_prod_id);//get dupluicate theraphy result
								   if(dup_drug_det!=null && !dup_drug_det.equals(""))
										drug_db_duptherapy_flag="Y";
										drugDetails.put("DRUG_DB_DUPTHERAPY_FLAG","Y");
								}
							}*/
							if(drugDetails.get("EXTERNAL_PRODUCT_ID")!=null && !drugDetails.get("EXTERNAL_PRODUCT_ID").equals("")){
								HashMap extDBCheckResults = null;
								if(drug_db_allergy_check_yn.equals("Y") ||  drug_db_duptherapy_check_yn.equals("Y")){
									extDBCheckResults = ext_beanObj.getExternalDBCheckResult( ext_prod_id, srl_no);
									if(extDBCheckResults!=null && drug_db_allergy_check_yn.equals("Y")){
										if(ext_beanObj!=null && ext_beanObj.getProdID()!=null && (ext_beanObj.getProdID()).equals("CIMS")){ // for CIMS)
											String allergy_alert			= (String)extDBCheckResults.get("ALLERGYCHECK");
											if(allergy_alert!=null && !allergy_alert.equals(""))
												drug_db_allergy_flag="Y";
										} 
										else{
											HashMap drug_alergies =(HashMap)extDBCheckResults.get("ALLERGYCHECK");
											if(drug_alergies!=null && drug_alergies.containsKey(ext_prod_id))
												drug_db_allergy_flag="Y";
										}
										drugDetails.put("DRUG_DB_ALLERGY_CHECK_YN",drug_db_allergy_flag);//Modified for IN:071537
									}	
									if(extDBCheckResults!=null && drug_db_duptherapy_check_yn !=null &&  drug_db_duptherapy_check_yn.equals("Y")){ 
										String dup_drug_det			= (String)extDBCheckResults.get("DUPCHECK");
										if(dup_drug_det!=null && !dup_drug_det.equals(""))
											drug_db_duptherapy_flag="Y";
										drugDetails.put("DRUG_DB_DUPTHERAPY_YN","Y");//Modified for IN:071537
									}
								}
							}
							if(drug_db_dosage_check_flag.equals("Y")||drug_db_contraind_check_flag.equals("Y")||drug_db_interact_check_flag.equals("Y")||drug_db_duptherapy_flag.equals("Y") || drug_db_allergy_flag.equals("Y")){
								ext_checks="Y";
							}
							else{
								if(drug_db_dosage_check_flag.equals("") && drug_db_contraind_check_flag.equals("") && drug_db_interact_check_flag.equals("") && drug_db_duptherapy_flag.equals("") && drug_db_allergy_flag.equals(""))
									ext_checks="";
								else
									ext_checks="N";
							}
							if((drug_db_dosage_check_flag.equals("Y") && (dsg_reason.equals(""))) && (drug_db_duptherapy_flag.equals("Y")&&(dup_reason.equals(""))) && (drug_db_contraind_check_flag.equals("Y") && (con_reason.equals(""))) && (drug_db_interact_check_flag.equals("Y") && (int_reason.equals(""))) &&  (drug_db_allergy_flag.equals("Y") && (alg_reason.equals("")))){//Modified for IN:071537
								ext_checks_overrided = "N";
							}
							else
								ext_checks_overrided = "Y";

							if(drug_db_duptherapy_flag.equals("Y")){
								current_rx = "N";
								drugDetails.put("CURRENT_RX","N");
							}
							else if(!(dup_reason.equals(""))){
								current_rx = "Y";
								drugDetails.put("CURRENT_RX","Y");
							}

							if(drug_db_allergy_flag.equals("Y")){
								allergy_yn = "N";
								drugDetails.put("ALLERGY_YN","N");
							}
							else if(!(alg_reason.equals(""))){
								allergy_yn = "Y";
								drugDetails.put("ALLERGY_YN","Y");
							}

							if(drug_db_dosage_check_flag.equals("Y")){
								limit_ind = "Y";
								drugDetails.put("LIMIT_IND","Y");
								
							}
							else if(!(dsg_reason.equals(""))){
								limit_ind = "N";
								drugDetails.put("LIMIT_IND","N");
							}
							if(drug_db_interact_check_flag.equals("Y")){
								interaction_exists = "N";
								drugDetails.put("INTERACTION_EXISTS","N");
							}
							else if(!(int_reason.equals(""))){
								interaction_exists = "Y";
								drugDetails.put("INTERACTION_EXISTS","Y");
							}
							/* code Added for ML-BRU-SCF-0190[32621]  -Start */
							if(amended_yn.equals("Y"))  {
								
								
							System.err.println("contain_taper_drug    "+contain_taper_drug);
								if( temp_patient_class.equals("OP") && contain_taper_drug == true && !isAmendTaper ){ //Modified for ML-MMOH-CRF-2155.1
									if( taperDetail.containsKey(order_line_number) ){
										taper_drug_count.add(taperDetail.get(order_line_number) );
										System.err.println("taper_drug_count "+taper_drug_count);
										taperDetail.remove(order_line_number);										
									 }										
										boolean flag = false;	
										Iterator itr = taper_drug_count.iterator();
										while(itr.hasNext()){
											flag=taperDetail.containsValue(itr.next());
											System.err.println("flag   "+flag);
											if(flag == true)
												break;
										}										
										if(flag == false)
											any_amended	= true;	
										else 
											any_amended	= false;	
								}
								else 								
									any_amended	= true; 			
								//Added for ML-MMOH-CRF-2155.1 - start
								if(temp_patient_class.equals("OP") && contain_taper_drug == true && isAmendTaper){
									any_amended	= true; 						
								}
								//Added for ML-MMOH-CRF-2155.1 - end
								amend_order_line_number.add(new Integer(Integer.parseInt(order_line_number)) ) ;
								bean.setAmendOrderLineNumber(amend_order_line_number);								
											
							}
							/* code Added for ML-BRU-SCF-0190[32621]  -End */

							if((!amended_yn.equals("Y")) && tmp_srl_no==null) {
								tmp_srl_no		=	srl_no;
								tmp_drug_code	=	drug_code;				
							}
							else if(amended_yn!=null && amended_yn.equals("Y")){
								classValue	= "AMENDEDDRUGS";	
							}

							if((!amended_yn.equals("Y")) && all_amended) {
								all_amended		=	false;
							}
						
							String dispDesc			= "";
							if(drug_desc!=null && drug_desc.length()>11){
								dispDesc	=	drug_desc.substring(0,11)+"...";
							}
							else {
								dispDesc	=	drug_desc;
							}

							if( tapered_yn!=null && tapered_yn.equals("Y") ){				
								tapergif="<img src='../../ePH/images/taper.gif' title='Tapper Dose' ></img>";					
							}
							else{
								tapergif="";
							} 

							if(!(prev_order_code.equals(order_type_code))){
%>
								<tr>
									<td class='COLUMNHEADER' colspan="8"  ><%=order_type_desc%></td>				
								</tr>
<%
								prev_order_code=order_type_code;
							}
							
							tooltip	= drug_desc+"/"+generic_name+" - "+qty_value+" "+qty_desc+" "+freq_desc+" for "+durn_value+" "+durn_desc;

							if(stock_available_yn.equals("N")){
								if(allow_pres_without_stock_yn.equals("N")){
%>
									<tr  id='row<%=srl_no%>'>
										<td class="white" width="6%"  title='Tappered'><%=tapergif%></td>
										<td class="<%=classValue%>" colspan="" NOWRAP width="64%" title="<%=tooltip%>" onClick="modifyDrug('<%=scheduled_yn%>','<%=drug_code%>','modify','<%=srl_no%>','<%=sliding_scale_yn%>','<%=recomm_yn%>');"  id="<%=drug_code%><%=srl_no%>"><font class='HYPERLINK' size='1'><%=dispDesc%></font>&nbsp;&nbsp;</td><!-- Modified for IN:073769-->
										<td style="background-color:red;font-weight:bold;font-size:11;cursor:pointer;height:20" NOWRAP  colspan="3" title="Available Qty:&nbsp;<%=available_stock%>&nbsp;&nbsp;<%=stock_uom%>"><marquee scrollamount="3"><font style="font-weight:bold;color:white"><fmt:message key="ePH.InsufficientStock-AvailableQuantity.label" bundle="${ph_labels}"/>:&nbsp;<%=available_stock%>&nbsp;<%=stock_uom%></font></marquee></td>
									</tr>
<%			
								}
							} 
							else {				
%>
								<tr  id='row<%=srl_no%>'>
									<td class="white" width="6%"  title='Tappered'><%=tapergif%></td>
									<td class="<%=classValue%>" colspan="" NOWRAP width="64%" title="<%=tooltip%>" onClick="modifyDrug('<%=scheduled_yn%>','<%=drug_code%>','modify','<%=srl_no%>','<%=sliding_scale_yn%>','<%=recomm_yn%>');"  id="<%=drug_code%><%=srl_no%>" onmouseover="changeCursor(this);"><font class='HYPERLINK' size='1'><%=dispDesc%></font>&nbsp;&nbsp;</td><!-- Modified for IN:073769-->
<%
									//if(drug_db_interface_yn.equals("Y") &&  (!ext_prod_id.equals(""))){
                                if( Integer.parseInt(adr_count)>0){
									drug_adr_count = bean.getADRCount(patient_id,drug_code);
									if(drug_adr_count>0){
%>
										<td class=<%=classValue%> colspan=""  width="3%"  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' ><img src='../../ePH/images/ADR.gif' height=20  width=15></img></td>
<%									}
									else{
%>
										<td class=<%=classValue%> colspan=""  width="3%"  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' >&nbsp;</td>
<%
									}
								}	

								if(ext_checks.equals("Y")){
									if(!(dsg_reason.equals("") && dup_reason.equals("") && con_reason.equals("") && int_reason.equals("") && alg_reason.equals(""))){
%>
										<td class="SHIFTTOTAL" width="6%" title="External Override Drug" id='ext_ddb_override_indc<%=srl_no%>' onClick="extDosageCheckFromPad('<%=drug_code%>','<%=srl_no%>','<%=ext_prod_id%>','PAD');" onmouseover="changeCursor1(this);">
<%
										if(ext_checks_overrided.equals("Y")){
%>
											<img name='ext_ddb_override_img<%=srl_no%>' src='../../ePH/images/exceed1.gif' style='display:none;' ></img>
											</td>
<%
										}
										else{
%>
											<img name='ext_ddb_override_img<%=srl_no%>' src='../../ePH/images/exceed1.gif' style='display:inline;' ></img>
											</td>
<%
										}
									}
									else { 
%>
										<td class="<%=classValue%>" width="6%" title="External Override Drug" id='ext_ddb_override_indc<%=srl_no%>' onClick="extDosageCheckFromPad('<%=drug_code%>','<%=srl_no%>','<%=ext_prod_id%>','PAD');" onmouseover="changeCursor1(this);"><img name='ext_ddb_override_img<%=srl_no%>' src='../../ePH/images/exceed1.gif' style='display:none;' ></img>
										</td>
<%
									}
								}
								else{
%>
									<td class="<%=classValue%>" width="6%" title="External Override Drug" id='ext_ddb_override_indc<%=srl_no%>' onClick="extDosageCheckFromPad('<%=drug_code%>','<%=srl_no%>','<%=ext_prod_id%>','PAD');" onmouseover="changeCursor1(this);"><img name='ext_ddb_override_img<%=srl_no%>' src='../../ePH/images/exceed1.gif' style='display:none;' ></img>
									</td>
<%
								}
							//		else{
								//	if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && !(alg_reason.equals("") || ext_checks.equals("Y"))) {	
									
									if(allergy_yn != null && allergy_yn.equals("Y") && (alg_reason == null || alg_reason.equals(""))){
%>
											<td class="ALLERGY" width="6%" title="Allergy Drug">&nbsp;<%=allergy_override_gif%></td>
<%										
									} 
									else if(allergy_yn != null && allergy_yn.equals("Y") && !drug_db_allergy_flag.equals("Y")){
%>	
<!---Below onClickEvent  is added by sureshkumar T for the ICN No :32596 on 08/05/2012 --->
											<td class="ALLERGY" width="6%" title="Allergy Drug" onclick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>');">&nbsp;</td>
<%									}
									else { 
%>
										<td class="<%=classValue%>" width="6%" title="Allergy Drug">&nbsp;</td>
<%
									}				
									if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && !(dsg_reason.equals("") || ext_checks.equals("Y"))) {	
%>
										<td class="DOSELIMIT" width="6%" title="Exeed Dosage Limit">&nbsp;</td>
<% 
									} 
									else { 
%>
										<td class="<%=classValue%>" width="6%" title="Exeed Dosage Limit">&nbsp;</td>
<%
									}
									if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && !int_reason.equals("") && interaction_exists.equals("Y")) {	
%>
										<td class="DOSELIMIT1" width="6%" title='<fmt:message key="Common.DrugInteraction.label" bundle="${common_labels}"/>' onclick="showInractionDtl('<%=drug_code%>','<%=srl_no%>','<%=patient_id%>','<%=encounter_id%>','','<%=order_id%>','<%=order_line_number%>');">&nbsp;</td><!--showInractionDtl added for MMS-KH-CRF-0029 and order_id , order_line_no added for MMS-KH-CRF-0034.4-->
<% 
									} 
									else { 
%>
										<td class="<%=classValue%>" width="6%" title='<fmt:message key="Common.DrugInteraction.label" bundle="${common_labels}"/>'>&nbsp;</td>
<%
									}if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && abuse_exists.equals("Y")&& abuse_action.equals("B")) {	//added for AAKH-CRF-0140
%>
										<td class="DOSELIMIT1" style="BACKGROUND-COLOR:purple;" width="3%" title='Drug Abuse' onclick="showAbuseDtl('<%=drug_code%>','<%=srl_no%>','<%=patient_id%>','<%=encounter_id%>','','<%=order_id%>','<%=order_line_number%>');">&nbsp;</td><!--showInractionDtl added for MMS-KH-CRF-0029 and order_id , order_line_no added for MMS-KH-CRF-0034.4-->
<% 
									} 
									else { 
%>
										<td class="<%=classValue%>" width="6%" title='Drug Abuse'>&nbsp;</td>
<%
									}
									//if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && !(dup_reason.equals("") || ext_checks.equals("Y"))) {
										if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals(""))||drug_db_duptherapy_check_yn.equals("N") ) {//Added for Duplicate button
										if(current_rx != null && current_rx.equals("Y") &&  dup_reason.equals("")  && !drug_db_duptherapy_flag.equals("Y")){
%>
											<td class="CURRENTRX" width="6%" title="Duplicate Medication" id="currentrx<%=srl_no%>">&nbsp;<%=currrx_override_gif%></td>
<%  
										}
										else if(current_rx != null && current_rx.equals("Y") && !drug_db_duptherapy_flag.equals("Y") && !dup_reason.equals("")){
%>										
											<td class="CURRENTRX" width="6%" title='<fmt:message key="ePH.DuplicateMedication.label" bundle="${ph_labels}"/>' id="currentrx<%=srl_no%>">&nbsp;</td>
<%										}
										else { 
%>
											<td class="<%=classValue%>" width="6%" title='<fmt:message key="ePH.DuplicateMedication.label" bundle="${ph_labels}"/>' id="currentrx<%=srl_no%>">&nbsp;</td>
<%
										}	
									}
									else { 
%>
										<td class="<%=classValue%>" width="6%" title='<fmt:message key="ePH.DuplicateMedication.label" bundle="${ph_labels}"/>' id="currentrx<%=srl_no%>">&nbsp;</td>
<%
									}	
%>
								</tr>
<%
							}		
							if(drugDetails!=null && drugDetails.get("AMENDED_YN")==null) {
								ArrayList renew_dates	=	(bean.getRenewDates(durn_value,order_id,drug_code));
								if(renew_dates.size()==2) {
									drug_start_date	=	(String)renew_dates.get(0);
									drug_end_date	=	(String)renew_dates.get(1);
								}
							}
							//Start Duplicate- check
							duplicate_dates		=	presBean.getDuplicateDates(patient_id,drug_code,drug_start_date);
							if(duplicate_dates.size()==2) {
								dup_start_date	=	(String)duplicate_dates.get(0);
								dup_end_date	=	(String)duplicate_dates.get(1);
							}
						// End Duplicate Dates
							if(presBean.duplicateRecord(dup_start_date,dup_end_date,drug_start_date,drug_end_date)) {
								dup_drug_code	=	drug_code;
								dup_srl_no		=	srl_no;
								dup_drug_desc	=	drug_desc;
							 }

							if(called_from.equals("RENEW_ORDER")) {
								//bean.setOldOrder(drug_code,order_id+","+presBean.getLineNo(order_id,drug_code)); //Commneted for Bru-HIMS-CRF-400 [IN:044502]
								bean.setOldOrder(drug_code, order_id+","+order_line_number); //Added for Bru-HIMS-CRF-400 [IN:044502]
							}
							//if(drug_db_interface_yn.equals("Y") &&(!ext_prod_id.equals("")) ){
							if(drug_db_interface_yn.equals("Y") &&!ext_prod_id.equals("") && ((conf_drug_code.equals(drug_code) && conf_srl_no.equals(srl_no))  || ext_checks.equals("") )){
%>
							<script>

								extDosageCheckFromPad('<%=drug_code%>','<%=srl_no%>','<%=ext_prod_id%>','PADLOAD');

							</script>
<%
						}
%>
						<input type="hidden" name="sliding_scale_yn<%=srl_no%>" id="sliding_scale_yn<%=srl_no%>" value="<%=sliding_scale_yn%>" >
<%
					}
%>
					</table>
<%
				}
%>
				<input type="hidden" value="<%=presBean_id%>" name="presBean_id">
				<input type="hidden" value="<%=presBean_name %>" name="presBean_name">
				<input type="hidden" name="dup_drug_code" id="dup_drug_code" value="<%=dup_drug_code%>">
				<input type="hidden" name="dup_srl_no" id="dup_srl_no" value="<%=dup_srl_no%>">
				<input type="hidden" name="srl_no" id="srl_no" value="<%=srl_no%>">
				<input type="hidden" name="dup_drug_desc" id="dup_drug_desc" value="<%=dup_drug_desc%>">
				<input type="hidden" value="<%=patient_id%>" name="patient_id">
				<input type="hidden" value="<%=encounter_id%>" name="encounter_id">
				<input type="hidden" value="<%=bean_id%>" name="bean_id">
				<input type="hidden" value="<%=bean_name%>" name="bean_name">
				<input type="hidden" value="<%=patient_class%>" name="patient_class">
				<input type="hidden" value="<%=mode%>" name="mode">
				<input type="hidden" value="<%=amended_yn%>" name="amended_yn">
				<input type="hidden" value="<%=all_amended%>" name="all_amended">
				<!-- code Added for ML-BRU-SCF-0190[32621]  -Start -->
				<input type="hidden" value="<%=any_amended%>" name="any_amend">
				<input type="hidden" value="<%=temp_patient_class%>" name="tmp_patient_class">
				<!-- code Added for ML-BRU-SCF-0190[32621]  -End -->
			</form>
		</body>
		<script>
<% 
			if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
%>
				getBLErrorDrugs();
<%
			}
			 if( tmp_srl_no!=null ) {
%>
//				var sliding_scale_yn = document.prescription_form.sliding_scale_yn1.value;
				var sliding_scale_yn_tmp = eval(document.prescription_form.sliding_scale_yn<%=tmp_srl_no%>).value;

				modifyDrug('<%=scheduled_yn%>','<%=tmp_drug_code%>','modify','<%=tmp_srl_no%>',sliding_scale_yn_tmp,'<%=recomm_yn%>');
<%
			}
			if(all_amended) { 
%>
				enableRelease();
<%
			}	
%>
			</script>
		</html>
<%
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(or_bean_id,orbean,request);
 		putObjectInBean(presBean_id,presBean,request);
	} 
	catch(Exception e) {
		e.printStackTrace();
	}
%>


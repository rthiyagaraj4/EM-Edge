
<%@page  import="java.sql.*,java.text.DecimalFormat, java.util.*, java.io.*, ePH.Common.*, eOR.Common.*, ePH.*, eOR.*, com.ehis.util.* "  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<% 
/* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
02/07/2017	  	IN061197	     	Mukesh M 										AAKH-CRF-0091 [IN061197] 
09/10/2017	  	71488	     	Manickavasagam J 										SKR-SCF-1270
03/12/2019 		IN070606                Manickavasagam J                       MMS-KH-CRF-0029[IN070606]
29/05/2020		IN:072092	        Manickavasagam J			     GHL-CRF-0618
09/06/2020      IN:072715                   Haribabu	                                       MMS-DM-CRF-0165    
  28/07/2020      IN:073485                   Haribabu                                PH-MMS-DM-CRF-0165/01-Normal rx-Amend order                        		
19/10/2020	IN072263	Manickavasagam	 PMG2020-ICN-001
20/10/2020       IN:069886         Haribabu                       Manickam            MO-CRF-20151                       		
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
-------------------------------------------------------------------------------------------------------------- 
*/
try{ 
        String func_mode			= request.getParameter("func_mode");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		PrescriptionBean_1 bean		= (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request);
		String locale = bean.getLanguageId();
		String presBean_id			= (String) hash.get( "presBean_id" )==null?"PrescriptionBean":(String) hash.get( "presBean_id" );
		String presBean_name		=  (String) hash.get( "presBean_name" )==null?"ePH.PrescriptionBean":(String) hash.get( "presBean_name" );
		PrescriptionBean presBean 	= (PrescriptionBean)getBeanObject(presBean_id,presBean_name,request);
		//AAKH-CRF-0091 starts
		if(func_mode != null && func_mode.equals("stat_yn")){
			String stat_yn			= (String) hash.get( "stat_yn" );
			String drugCode			= (String) hash.get( "drug_code" );
//			String serial_number	= (String) hash.get( "srl_no" );
			String serial_number	= String.valueOf(bean.getSrlNo());//MMS-DM-SCF-0449
			String ext_drug_code	= "";
			String ext_srl_no			=	"";
			String parent_stat_yn = "";//MMS-DM-SCF-0449
			String dosage_type    = "";//MMS-DM-SCF-0449
			String qty_value      = "";//MMS-DM-SCF-0449
			String qty_unit		  = ""; // Added for MMS-MD-SCF-0092
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap Drug_Details =null;
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
					Drug_Details=(HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) Drug_Details.get("DRUG_CODE");
					ext_srl_no=(String) Drug_Details.get("SRL_NO");
					parent_stat_yn = (String) Drug_Details.get("parent_stat_yn");
					if(parent_stat_yn==null || parent_stat_yn.equals(""))
						parent_stat_yn = "N";

					if( drugCode.equals(ext_drug_code) && serial_number.equals(ext_srl_no) ){
						Drug_Details.put("stat_yn", stat_yn);
						Drug_Details.put("DURN_VALUE", "1");
						Drug_Details.put("DURN_TYPE", "D");
						//Drug_Details.put("FREQ_NATURE", "O");
						Drug_Details.put("PRIORITY", "U");//Added for IN:064975
						Drug_Details.put("freq_chng_durn_value", "1");
						Drug_Details.put("freq_chng_durn_desc", "D"); 
						//Drug_Details.put("Override_Check","Y"); 
						break;
					}					
				}					
			}
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
					Drug_Details=(HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) Drug_Details.get("DRUG_CODE");
					stat_yn=(String) Drug_Details.get("stat_yn")==null?"N":(String) Drug_Details.get("stat_yn");
					if(stat_yn.equals("N") && drugCode.equals(ext_drug_code)){
						System.out.println("4799====>");
						Drug_Details.put("parent_stat_yn", "Y");
						dosage_type = (String)Drug_Details.get("DOSAGE_TYPE");//MMS-DM-SCF-0449
						qty_value = (String)Drug_Details.get("QTY_VALUE");//MMS-DM-SCF-0449
						qty_unit  = (String)Drug_Details.get("QTY_DESC_CODE");//MMS-MD-SCF-0092
						break;
					}
				}
			}
			//added for MMS-DM-SCF-0449 - start
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
					Drug_Details=(HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) Drug_Details.get("DRUG_CODE");
					stat_yn=(String) Drug_Details.get("stat_yn")==null?"N":(String) Drug_Details.get("stat_yn");
					if(stat_yn.equals("Y") && drugCode.equals(ext_drug_code)){
						Drug_Details.put("DOSAGE_TYPE",dosage_type);
						Drug_Details.put("QTY_VALUE",qty_value);
						Drug_Details.put("QTY_DESC_CODE",qty_unit); // Added for MMS-MD-SCF-0092
						break;
					}
				}
			}			//added for MMS-DM-SCF-0449 - end
		}	//AAKH-CRF-0091 ends	
			else if(func_mode != null && func_mode.equals("cancelSlidingScale")){
			String drugCode		= (String)hash.get("drug_code");
			String srlNo		= (String)hash.get("srl_no");
			String patient_id	= (String)hash.get("patient_id");
			String encounter_id	= (String)hash.get("encounter_id");
			String order_set_code	= (String)hash.get("order_set_code")==null?"":(String)hash.get("order_set_code");
			String search_bean_id	="@DrugSearchBean"+patient_id+encounter_id;
			String search_bean_name	="ePH.DrugSearchBean";
			int drug_index=0;
			DrugSearchBean searchbean = (DrugSearchBean)getBeanObject( search_bean_id, search_bean_name , request) ;
			int remove_pos	=	0;
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			int codeCount_1=0;
			int codeCount_2=0;
			HashMap ext_drugData	=	null;
			String ext_drug_code	=	null;
			String ext_srl_no		=	null;
			ArrayList atc_dup_drug_code=null;
			String curr_yn    = "";
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData      =  (HashMap) prescriptionDetails.get(j);
				curr_yn			  = "";
				if(ext_drugData.containsKey("ATC_DUP_DRUG_CODE")){
					atc_dup_drug_code  =  (ArrayList) ext_drugData.get("ATC_DUP_DRUG_CODE");
					if(atc_dup_drug_code == null)
						atc_dup_drug_code= new ArrayList();
					if(atc_dup_drug_code.contains(drugCode)){
						atc_dup_drug_code.remove(drugCode);
					}
					if(atc_dup_drug_code.size()== 0){
						ext_drugData.put("CURRENT_RX",curr_yn);
						ext_drugData.put("ATC_LEVEL_DUPLICATION","N");
						ext_drugData.put("ATC_DUP_DRUG_CODE",null);
						ext_drugData.put("CURRENTRX_REMARKS","");
						if(ext_drugData.containsKey("ALERT_YN"))
							ext_drugData.remove("ALERT_YN");
					}
				}
			}
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData=(HashMap) prescriptionDetails.get(j);
				ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
				ext_srl_no=(String) ext_drugData.get("SRL_NO");
				if(drugCode.equals(ext_drug_code)){
					codeCount_1++;
				}
				if(drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no))
					drug_index = j;
			}
			if(codeCount_1>1){
				for(int k=drug_index;k<prescriptionDetails.size();k++){
					ext_drugData=(HashMap) prescriptionDetails.get(k);
					ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
					if(drugCode.equals(ext_drug_code)){
						codeCount_2++;
					}
				}
			}
			for(int h=0;h<prescriptionDetails.size();h++){
				ext_drugData=(HashMap) prescriptionDetails.get(h);
				ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
				ext_srl_no=(String) ext_drugData.get("SRL_NO");
				if( (drugCode.equals(ext_drug_code)) && (srlNo.equals(ext_srl_no)) ){
					remove_pos=h;
					break;
				}
			}
			if(codeCount_1>1 && codeCount_2>1 && order_set_code.equals("")){
				out.println("alertParentRecord('delete')") ;
			}
			else{
				prescriptionDetails.remove((remove_pos));
				searchbean.removeDrugCode(drugCode);
				searchbean.removeSelectedDrug(drugCode);
				bean.getclearscheduleFrequency(drugCode);
				bean.clearCopiedDrugs(drugCode);
				out.println("deleteOROrderCatalog('"+drugCode+"')") ;
			}
			putObjectInBean(search_bean_id,searchbean,request);
			out.println("refreshSlidingScaleFrame()");
		}else if(func_mode != null && func_mode.equals("confirmSlidingScale")){
			String on_load_yn =	(String)hash.get( "on_load_yn");
			String srlNo		= (String)hash.get("srl_no");
			String qty_value		= (String)hash.get( "qty_value");
			String qty_unit			= (String)hash.get( "qty_unit");
			String frequency		= (String)hash.get( "frequency");
			String durn_value		= (String)hash.get( "durn_value");
			String durn_unit		= (String)hash.get( "durn_unit");
			String dosage_type		= (String)hash.get( "dosage_type");
			String start_date		= (String)hash.get( "start_date");
			String end_date			= (String)hash.get( "end_date");
			String drug_code			= (String)hash.get( "drug_code");
			String remarks			= (String)hash.get( "remarks");
			String remarks_codes	= (String)hash.get( "remarks_codes");	
			String sliding_scale_yn	= (String)hash.get( "sliding_scale_yn");
			String freq_desc		= (String)hash.get( "freq_desc");
			freq_desc = java.net.URLDecoder.decode(freq_desc,"UTF-8");
			String tmplDtlString	= (String)hash.get("tmplDtlString")==null?"":(String)hash.get("tmplDtlString");
			String rangeUom	= (String)hash.get("rangeUom")==null?"":(String)hash.get("rangeUom");
			String adminUom	= (String)hash.get("adminUom")==null?"":(String)hash.get("adminUom");
			String template_id	= (String)hash.get("template_id")==null?"":(String)hash.get("template_id");
			String temp = "" ;
			String buildMAR_yn		= (String)hash.get("buildMAR_yn")==null?"":(String)hash.get("buildMAR_yn"); //added for SRR20056-SCF-7882 -29157
			String DrugRemarksEntered		= (String)hash.get("DrugRemarksEntered")==null?"":(String)hash.get("DrugRemarksEntered"); //Added for Antibiotic Screen using Order Entry Format ICN 29904
			String DrugIndicationRemarks            = (String) hash.get("DrugIndicationRemarks")==null?"":(String)hash.get("DrugIndicationRemarks");
			if(!DrugIndicationRemarks.equals(""))
				DrugIndicationRemarks = java.net.URLDecoder.decode(DrugIndicationRemarks,"UTF-8"); ;
			StringTokenizer stTmplDtl = new StringTokenizer(tmplDtlString,"~");
			ArrayList sldScaleTmplDtl = new ArrayList();
			int temp_count = 0;
			while(stTmplDtl.hasMoreTokens()){
				temp_count++;
				temp = stTmplDtl.nextToken();
				if(temp_count % 5 == 0)  //added for IN26689 --03/03/2011-- priya
					temp = java.net.URLDecoder.decode(temp,"UTF-8");
				sldScaleTmplDtl.add(temp);
			}
			freq_desc = java.net.URLDecoder.decode(freq_desc,"UTF-8");
			String freq_nature		= (String)hash.get( "freq_nature");
			String absol_qty		= (String)hash.get( "absol_qty");
			String repeat_value		= (String)hash.get( "repeat_value");
			String override_check	= (String) hash.get("override_remarks")==null?"":(String) hash.get("override_remarks");
			String checkEnabled		= (String) hash.get("checkEnabled")==null?"":(String) hash.get("checkEnabled");
			String pract_name		= (String) hash.get("pract_name")==null?"":(String) hash.get("pract_name");
			String interval_value		= (String) hash.get("interval_value")==null?"1":(String) hash.get("interval_value");
			//added for IN26429_reopen --15/02/2011-- priya -Start
			String bl_incl_excl_override_reason_code = (String) hash.get("bl_incl_excl_override_reason_code")==null?"":(String)hash.get("bl_incl_excl_override_reason_code");
			String bl_incl_excl_override_reason_desc = (String) hash.get("bl_incl_excl_override_reason_desc")==null?"":(String)hash.get("bl_incl_excl_override_reason_desc");
			String bl_def_override_excl_incl_ind     = (String) hash.get("bl_def_override_excl_incl_ind")==null?"":(String)hash.get("bl_def_override_excl_incl_ind");
			String bl_override_excl_incl_ind         = (String) hash.get("bl_override_excl_incl_ind")==null?"":(String)hash.get("bl_override_excl_incl_ind");
			String bl_override_allowed_yn            = (String) hash.get("bl_override_allowed_yn")==null?"":(String)hash.get("bl_override_allowed_yn");
			String temp_drug_code="";
			String temp_srl_no="";
			//added for IN26429_reopen --15/02/2011-- priya -End
			//code added for patient counselling req
			if(absol_qty==null)
				absol_qty	=	"";
			ArrayList presDetails  = (ArrayList) bean.getpresDetails();
			HashMap drugDetails    = null;
			for(int i=0;i<presDetails.size();i++){
				drugDetails    = (HashMap)presDetails.get(i);
				temp_drug_code =(String)drugDetails.get("DRUG_CODE");
				temp_srl_no =(String)drugDetails.get("SRL_NO");
				if(drug_code.equals(temp_drug_code) && srlNo.equals(temp_srl_no)){
					break;
				}
			}
			if(frequency==null || (frequency!=null && frequency.equals(""))){
				frequency = bean.getSlidingScalePRNFreq();
			}
			drugDetails.put("ABSOL_QTY",absol_qty);	
			drugDetails.put("REPEAT_VALUE",repeat_value);	
			drugDetails.put("FREQ_NATURE",freq_nature);
			drugDetails.put("FREQ_CODE",frequency);
			drugDetails.put("FREQ_DESC",freq_desc);
			drugDetails.put("DURN_VALUE",durn_value);
			drugDetails.put("START_DATE",start_date);
			drugDetails.put("END_DATE",end_date);
			drugDetails.put("PRES_QTY_VALUE",qty_value);
			//	drugDetails.put("DOSAGE_TYPE",dosage_type); //Commented for IN25014 --29/11/2010-- priya
			drugDetails.put("DURN_TYPE",durn_unit);
			drugDetails.put("SLIDING_SCALE_YN",sliding_scale_yn);
			drugDetails.put("AMEND_YN","Y");
			drugDetails.put("QTY_VALUE",qty_value);
			drugDetails.put("QTY_DESC",qty_unit);
			drugDetails.put("QTY_DESC_CODE",qty_unit);
			//drugDetails.put("OR_QTY_DESC",qty_unit);
			drugDetails.put("freq_chng_durn_desc",(String) hash.get("durn_desc"));	
			drugDetails.put("OR_QTY_DESC",bean.getUomDisplay((String)session.getValue("facility_id"),qty_unit));
			drugDetails.put("INTERVAL_VALUE",interval_value);
			drugDetails.put("TEMPLATE_ID",template_id);
			drugDetails.put("SLDSCALE_TMPL_DTL",sldScaleTmplDtl);
			drugDetails.put("RANGEUOM",rangeUom);
			drugDetails.put("ADMINUOM",adminUom);
			drugDetails.put("SLIDING_SCALE_REMARKS",java.net.URLDecoder.decode(remarks,"UTF-8"));//code 'remarks' replaced by java.net.URLDecoder.decode(remarks,"UTF-8") for IN047654
			drugDetails.put("SLIDING_SCALE_REMARKS_CODES",remarks_codes);
			drugDetails.put("BUILDMAR_YN",buildMAR_yn); //added for SRR20056-SCF-7882 -29157
			drugDetails.put("DrugRemarksEntered",DrugRemarksEntered); //Added for Antibiotic Screen using Order Entry Format ICN 29904
			drugDetails.put("DRUG_INDICATION",DrugIndicationRemarks); //Added for Antibiotic Screen using Order Entry Format ICN 29904
			//added for IN26429_reopen --15/02/2011-- priya -Start
			drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON_CODE",bl_incl_excl_override_reason_code);
			drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC",bl_incl_excl_override_reason_desc);
			drugDetails.put("BL_OVERRIDE_EXCL_INCL_IND",bl_override_excl_incl_ind); //priya
			//added for IN26429_reopen --15/02/2011-- priya - End
			String allergy_yn  =(String) drugDetails.get("ALLERGY_YN")==null?"N":(String) drugDetails.get("ALLERGY_YN");
			String limit_ind  =(String) drugDetails.get("LIMIT_IND")==null?"N":(String) drugDetails.get("LIMIT_IND");
			String current_rx		= (String) drugDetails.get("CURRENT_RX")==null?"":(String) drugDetails.get("CURRENT_RX");
			String currentrx_remarks		= (String) drugDetails.get("CURRENTRX_REMARKS")==null?"":(String) drugDetails.get("CURRENTRX_REMARKS");
			String dose_remarks		= (String) drugDetails.get("DOSE_REMARKS")==null?"":(String) drugDetails.get("DOSE_REMARKS");
			String allergy_remarks		= (String) drugDetails.get("ALLERGY_REMARKS")==null?"":(String) drugDetails.get("ALLERGY_REMARKS");
			String interaction_exists	= (String) drugDetails.get("INTERACTION_EXISTS")==null?"":(String) drugDetails.get("INTERACTION_EXISTS"); //Added for RUT-CRF-0066 IN[029604]
			String interaction_remarks	= (String) drugDetails.get("INTERACTION_REMARKS")==null?"":(String) drugDetails.get("INTERACTION_REMARKS"); //Added for	RUT-CRF-0066 IN[029604]
			String abuse_override_remarks	= (String) drugDetails.get("abuse_override_remarks")==null?"":(String) drugDetails.get("abuse_override_remarks"); 
			String abuse_exists= (String) drugDetails.get("ABUSE_EXISTS")==null?"":(String) drugDetails.get("ABUSE_EXISTS"); 
			String abuse_action= (String) drugDetails.get("ABUSE_ACTION")==null?"":(String) drugDetails.get("ABUSE_ACTION"); 
					if(override_check.equals("Y") && !checkEnabled.equals("disabled")){
				if(current_rx.equals("Y")){
					if(currentrx_remarks==null || currentrx_remarks.equals(""))
						currentrx_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
					drugDetails.put("CURRENTRX_OVERRIDE","Y");
					drugDetails.put("CURRENTRX_REMARKS",currentrx_remarks);
					drugDetails.put("OVERRIDED_YN","Y");
				}
				if(limit_ind.equals("N")){
					if(dose_remarks==null || dose_remarks.equals(""))
						dose_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
					drugDetails.put("DOSE_OVERRIDE","Y");
					drugDetails.put("DOSE_REMARKS",dose_remarks);
					drugDetails.put("OVERRIDED_YN","Y");
				}
				if( allergy_yn.equals("Y")){
					if(allergy_remarks==null || allergy_remarks.equals(""))
						allergy_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
					drugDetails.put("ALLERGY_OVERRIDE","Y");
					drugDetails.put("ALLERGY_REMARKS",allergy_remarks);
					drugDetails.put("OVERRIDED_YN","Y");
				}
				if( interaction_exists.equals("Y")){ //Added for	RUT-CRF-0066 IN[029604] - start
					if(interaction_remarks==null || interaction_remarks.equals(""))
						interaction_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
					drugDetails.put("DRUGINTRACTION_OVERRIDE","Y");
					drugDetails.put("INTERACTION_REMARKS",interaction_remarks);
				} //Added for	RUT-CRF-0066 IN[029604] - end
				if( abuse_exists.equals("Y")&& abuse_action.equals("B")){
					if(abuse_override_remarks==null || abuse_override_remarks.equals(""))
						abuse_override_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
					drugDetails.put("ABUSE_OVERRIDE","Y");
					drugDetails.put("abuse_override_remarks",abuse_override_remarks);
					drugDetails.put("OVERRIDED_YN","Y");
				}
				drugDetails.put("Override_Check",override_check);
			}
			else{
				String overrided_yn = (String)drugDetails.get("OVERRIDED_YN")==null?"":(String)drugDetails.get("OVERRIDED_YN");
				if((current_rx.equals("Y") || limit_ind.equals("N") || allergy_yn.equals("Y")) && overrided_yn.equals("")){
					out.println("alert(getMessage('OVERRIDE_REASON_NOT_BLANK','PH'));");
					return;
				}
			}
			if(on_load_yn.equals("N"))   // if condition  added for IN24060 --07/10/2010-- priya
				out.println("refreshSlidingScaleFrame()");
		}else if(func_mode != null && func_mode.equals("CheckPatientStock")){ //added for GHL-CRF-0482
			String drug_code		= (String)hash.get("drug_code");
			String facility_id	= (String)hash.get("facility_id");
			String patient_id	= (String)hash.get("patient_id");
			String encounter_id	= (String)hash.get("encounter_id");
			String pres_base_uom = (String)hash.get("pres_base_uom");
			String patient_stock_yn = bean.getPatientStockYN(patient_id,facility_id,encounter_id,drug_code,locale);
			out.println("displayAlert('"+patient_stock_yn.split("~")[0]+"','"+patient_stock_yn.split("~")[1]+"','"+bean.getUomDisplay((String)session.getValue("facility_id"),patient_stock_yn.split("~")[2])+"')");//GHL-CRF-0482
	//	}
		}else if(func_mode != null && func_mode.equals("CheckPatientStockUpdateStatus")){ //added for GHL-CRF-0482
			String drug_code		= (String)hash.get("drug_code");
			String srlNo			= (String)hash.get("srl_no");
			String patient_stock_yn	= (String)hash.get("patient_stock_yn")==null?"N":(String)hash.get("patient_stock_yn");
System.err.println("PrescriptionValidation.jsp====drug_code==>"+drug_code+"==patient_stock_yn==>"+patient_stock_yn+"==srlNo==>"
+srlNo);
			String temp_drug_code   = "";
			String temp_srl_no		= "";
			ArrayList presDetails  = (ArrayList) bean.getpresDetails();
			HashMap drugDetails    = null;
			for(int i=0;i<presDetails.size();i++){
				drugDetails    = (HashMap)presDetails.get(i);
				temp_drug_code =(String)drugDetails.get("DRUG_CODE");
				temp_srl_no =(String)drugDetails.get("SRL_NO");
				if(drug_code.equals(temp_drug_code) && srlNo.equals(temp_srl_no)){
					break;
				}
			}
			drugDetails.put("patient_stock_yn",patient_stock_yn);
		}else if(func_mode != null && func_mode.equals("validatePRNRemarks")){ //added for SKR-SCF-1270
			String amend_yn = "";
			String drug_code_prn = "";
			String freq_nature = "";

			ArrayList prescriptionDetails  = (ArrayList) bean.getpresDetails();

			HashMap ext_drugData    = null;
			for(int k=0; k<prescriptionDetails.size(); k++){
				ext_drugData=(HashMap) prescriptionDetails.get(k);
				freq_nature = (String)ext_drugData.get("FREQ_NATURE")==null?"":(String)ext_drugData.get("FREQ_NATURE");
				amend_yn = (String)ext_drugData.get("AMEND_YN")==null?"N":(String)ext_drugData.get("AMEND_YN");
				drug_code_prn= (String) ext_drugData.get("DRUG_CODE");
				if(freq_nature.equals("P") && amend_yn.equals("N")){
				 HashMap getPRNRemarks  = bean.getPRNRemarks(drug_code_prn);
	
					if(getPRNRemarks==null){
						out.println("displayPRNAlert()");
						break;
					}

				}
			}
			
		}else if(func_mode != null && func_mode.equals("loadDrugInteractionForDrug")){ //added for MMS-KH-CRF-0029 - start
			String patient_id		= (String) hash.get( "patient_id" );
			String drugCode			= (String) hash.get( "drug_code" );
			String serial_number	= String.valueOf(bean.getSrlNo());
			String ext_drug_code	= "";
			String ext_srl_no			=	"";
			
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap Drug_Details =null;
			HashMap DrugInteractionDtl=null;//MMS-KH-CRF-0029
			
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
					Drug_Details=(HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) Drug_Details.get("DRUG_CODE");
					ext_srl_no=(String) Drug_Details.get("SRL_NO");
					

					if( drugCode.equals(ext_drug_code) && serial_number.equals(ext_srl_no) ){
						ArrayList intrType  = new ArrayList();//MMS-KH-CRF-0029
						String form_code = (String)Drug_Details.get("FORM_CODE")==null?"":(String)Drug_Details.get("FORM_CODE");
						String generic_id = (String)Drug_Details.get("GENERIC_ID")==null?"":(String)Drug_Details.get("GENERIC_ID");
						ArrayList alDrugIntrDtlList = bean.getDrugInteractionDtls(drugCode, form_code, generic_id,(String)Drug_Details.get("START_DATE"),(String)Drug_Details.get("END_DATE") , patient_id);
					System.err.println("alDrugIntrDtlList=======392===>"+alDrugIntrDtlList);
					if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()>2){
						String interaction_type  = ""; //MMS-KH-CRF-0029
						Drug_Details.put("SEVERITY_LEVEL", (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2) );
						Drug_Details.put("INTR_RESTRIC_TRN", (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1) );
						Drug_Details.put("INTERACTION_DTL", alDrugIntrDtlList );
						Drug_Details.put("INTERACTION_EXISTS", "Y" );
						if(((String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1)).equals("Y") || ((String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2)).equals("H")){
							Drug_Details.put("INTR_ALERT", "Y" );
						}//added for MMS-KH-CRF-0029 - start
							if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()> 0){

								for(int count=0 ; count<(alDrugIntrDtlList.size()-2) ; count++){

									DrugInteractionDtl =(HashMap) alDrugIntrDtlList.get(count);
									interaction_type = (String)DrugInteractionDtl.get("INTR_TYPE2"); 
									intrType.add(interaction_type);
							}
							if(intrType!=null && intrType.size()>0){
								if(intrType.contains("D") || intrType.contains("G")){
									Drug_Details.put("DRUG_INTERACTION_EXISTS","Y");
								}
								if(intrType.contains("F")){
									Drug_Details.put("FOOD_INTERACTION_EXISTS","Y");
								}
								if(intrType.contains("L")){
									Drug_Details.put("LAB_INTERACTION_EXISTS","Y");
								}
								if(intrType.contains("I")){//Added for MMS-DM-CRF-0229
									Drug_Details.put("DISEASE_INTERACTION_EXISTS","Y");
								}
							}
						   }
						} ////MMS-KH-CRF-0029 -end
						break;
					}					
				}					
			}
		} else if(func_mode != null && func_mode.equals("nonPreferenceRemarks")){ //added for GHL-CRF-0618- start
			String patient_id		= (String) hash.get("patient_id");
			String drug_code		= (String) hash.get("drug_code");
			String remarks_code		= (String) hash.get("remarks_code");
			bean.setNonPrefernceRemarks(drug_code,remarks_code);
			out.println("closeRemarksWindowForDrug()");
		} //added for GHL-CRF-0618- start - end
//Added for IN:072715 START
		else if(func_mode!= null && func_mode.equals("override_remarks")) {
					String reason_code		= (String)hash.get("reason_code"); 
					String trn_type		= (String)hash.get("trn_type");
					String field		= (String)hash.get("field");
					System.out.println("reason_code ="+reason_code+" trn_type ="+trn_type);
					String remarks = bean.getOverrideRemarks(trn_type, reason_code);
					System.out.println("remarks ="+remarks);
					System.out.println("field ="+field);
					out.println("document.DispQueueMgmtHoldReason."+field+".value = '"+remarks+"';");
					out.println("document.DispQueueMgmtHoldReason."+field+".readOnly = true;");
					
					
				}
				//Added for IN:072715 END
				else if(func_mode!= null && func_mode.equals("override_reason")) {
			String drugCode		= (String)hash.get("drug_code");
			String srlNo		= (String)hash.get("srl_no");
			String allergy_yn	= (String)hash.get("allergy_yn");
			String limit_ind	= (String)hash.get("limit_ind");
			String current_rx	= (String)hash.get("current_rx");
			String interaction_remarks	= (String)hash.get("interaction_remarks")==null?"":(String)hash.get("interaction_remarks");//Added for	RUT-CRF-0066 IN[029604] 
			String interaction_exists	= (String)hash.get("interaction_exists")==null?"":(String)hash.get("interaction_exists"); //Added for	RUT-CRF-0066 IN[029604] 
			String allergy		=	"", exceed_dose="",dup_drug="" ;
			String food_interaction_remarks = "",lab_interaction_remarks="",disease_interaction_remarks="";//MMS-KH-CRF-0029[IN070606] disease_interaction_remarks MMS-DM-CRF-0229
			String dose_remarks_code = "", allergy_remarks_code = "", dup_drug_remarks_code = "", interaction_remarks_code = "", lab_interaction_remarks_code = "", food_interaction_remarks_code = "",disease_interaction_remarks_code="";	//Added for IN:072715disease_interaction_remarks_codeadded for MMS-DM-CRF-0229
			String abuse_exists	= (String)hash.get("abuse_exists");//aded for aakh-crf-0140
			String abuse_action	= (String)hash.get("abuse_action");//aded for aakh-crf-0140
			String abuse_override_remarks	=(String)hash.get("abuse_override_remarks");; //aded for aakh-crf-0140
			System.out.println("abuse_exists"+abuse_exists+"abuse_action"+abuse_action+" in validation before"+abuse_override_remarks);
			// Modified for IN:072715 START	
			if(allergy_yn.equals("Y")){
				allergy				= java.net.URLDecoder.decode((String)hash.get("allergy")==null?"":(String)hash.get("allergy"),"UTF-8");
				allergy_remarks_code				= java.net.URLDecoder.decode((String)hash.get("allergy_remarks_code")==null?"":(String)hash.get("allergy_remarks_code"),"UTF-8");
			}
			if(limit_ind.equals("N")){
				exceed_dose			= java.net.URLDecoder.decode((String)hash.get("exceed_dose")==null?"":(String)hash.get("exceed_dose"),"UTF-8");
				dose_remarks_code			= java.net.URLDecoder.decode((String)hash.get("dose_remarks_code")==null?"":(String)hash.get("dose_remarks_code"),"UTF-8");
			}
			if(current_rx.equals("Y")){
				dup_drug			= java.net.URLDecoder.decode((String)hash.get("dup_drug")==null?"":(String)hash.get("dup_drug"),"UTF-8");
				dup_drug_remarks_code			= java.net.URLDecoder.decode((String)hash.get("dup_drug_remarks_code")==null?"":(String)hash.get("dup_drug_remarks_code"),"UTF-8");
			}
			if(interaction_exists.equals("Y")){ //Added for	RUT-CRF-0066 IN[029604] 
				interaction_remarks			= java.net.URLDecoder.decode((String)hash.get("interaction_remarks")==null?"":(String)hash.get("interaction_remarks"),"UTF-8");
				food_interaction_remarks			= java.net.URLDecoder.decode((String)hash.get("food_interaction_remarks")==null?"":(String)hash.get("food_interaction_remarks"),"UTF-8"); //MMS-KH-CRF-0029[IN070606]
				lab_interaction_remarks			= java.net.URLDecoder.decode((String)hash.get("lab_interaction_remarks")==null?"":(String)hash.get("lab_interaction_remarks"),"UTF-8"); //MMS-KH-CRF-0029[IN070606]
				interaction_remarks_code			= java.net.URLDecoder.decode((String)hash.get("interaction_remarks_code")==null?"":(String)hash.get("interaction_remarks_code"),"UTF-8");
				food_interaction_remarks_code			= java.net.URLDecoder.decode((String)hash.get("food_interaction_remarks_code")==null?"":(String)hash.get("food_interaction_remarks_code"),"UTF-8"); 
				lab_interaction_remarks_code			= java.net.URLDecoder.decode((String)hash.get("lab_interaction_remarks_code")==null?"":(String)hash.get("lab_interaction_remarks_code"),"UTF-8"); 	
				disease_interaction_remarks_code			= java.net.URLDecoder.decode((String)hash.get("disease_interaction_remarks_code")==null?"":(String)hash.get("disease_interaction_remarks_code"),"UTF-8"); 
				disease_interaction_remarks			= java.net.URLDecoder.decode((String)hash.get("disease_interaction_remarks")==null?"":(String)hash.get("disease_interaction_remarks"),"UTF-8");
			}
			if(abuse_action.equals("B")){ //aded for aakh-crf-0140
				abuse_override_remarks				= java.net.URLDecoder.decode((String)hash.get("abuse_override_remarks")==null?"":(String)hash.get("abuse_override_remarks"),"UTF-8");
			}
			ArrayList prescriptionDetails	=	(ArrayList)bean.getpresDetails();
			HashMap ext_drugData	=	null;
			String ext_drug_code	=	null;
			String ext_srl_no		=	null;
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData	=(HashMap) prescriptionDetails.get(j);
				ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");
				ext_srl_no		=(String) ext_drugData.get("SRL_NO");
				if( drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no) ){
					if(!allergy.equals("") ) {
						ext_drugData.put("ALLERGY_REMARKS",allergy);
						ext_drugData.put("ALLERGY_OVERRIDE","Y");
						ext_drugData.put("ALLERGY_REMARKS_CODE",allergy_remarks_code);
					}
					if(!exceed_dose.equals("")) {
						ext_drugData.put("DOSE_REMARKS",exceed_dose);
						ext_drugData.put("DOSE_OVERRIDE","Y");
						ext_drugData.put("DOSE_REMARKS_CODE",dose_remarks_code);
					}
					if(!dup_drug.equals("")) {
						ext_drugData.put("CURRENTRX_REMARKS",dup_drug);
						ext_drugData.put("CURRENTRX_OVERRIDE","Y");
						ext_drugData.put("CURRENTRX_REMARKS_CODE",dup_drug_remarks_code);
					}

					if( !interaction_remarks.equals("")|| !food_interaction_remarks.equals("") || !lab_interaction_remarks.equals("") || !disease_interaction_remarks.equals("")){ //modified for MMS-KH-CRF-0029			
						
						ext_drugData.put("DRUGINTRACTION_OVERRIDE","Y");
						ext_drugData.put("INTERACTION_REMARKS",interaction_remarks);
						ext_drugData.put("INTERACTION_REMARKS_CODE",interaction_remarks_code);	
						
						if(!food_interaction_remarks.equals("")){
							ext_drugData.put("FOOD_INTERACTION_REMARKS",food_interaction_remarks);//MMS-KH-CRF-0029[IN070606]
							ext_drugData.put("FOOD_INTERACTION_REMARKS_CODE",food_interaction_remarks_code);		
						}
						
						if(!lab_interaction_remarks.equals("")){
							ext_drugData.put("LAB_INTERACTION_REMARKS",lab_interaction_remarks);//MMS-KH-CRF-0029[IN070606]
							ext_drugData.put("LAB_INTERACTION_REMARKS_CODE",lab_interaction_remarks_code);		
						}
					// Modified for IN:072715 END 	
                     if(!disease_interaction_remarks.equals("")){//Added for MMS-DM-CRF-0229
							ext_drugData.put("DISEASE_INTERACTION_REMARKS",disease_interaction_remarks);
							ext_drugData.put("DISEASE_INTERACTION_REMARKS_CODE",disease_interaction_remarks_code);		
					    }
					System.out.println("abuse_override_remarks"+abuse_override_remarks);
					System.out.println("abuse_exists542"+abuse_exists+"abuse_action"+abuse_action);
					if(abuse_exists.equals("Y")&& abuse_action.equals("B")) {//added for aakh-crf-0140
						
						ext_drugData.put("abuse_override_remarks",abuse_override_remarks);
						ext_drugData.put("ABUSE_OVERRIDE","Y");
						
					}
					ext_drugData.put("Override_Check","Y");
					break;
				}
			}
		  }
		}
		//Added for IN:073485 START
		else if(func_mode!= null && func_mode.equals("override_mand_check")) {
					String drugCode		= (String)hash.get("drug_code");
					String srlNo		= (String)hash.get("srl_no");
					String patient_id	= (String)hash.get("patient_id");
					String encounter_id	= (String)hash.get("encounter_id");
					String bean_id1	="@PrescriptionBean_1"+patient_id+encounter_id;
					String bean_name1	="ePH.PrescriptionBean_1";
					PrescriptionBean_1 bean1		= (PrescriptionBean_1)getBeanObject(bean_id1,bean_name1,request);
					ArrayList prescriptionDetails=(ArrayList)bean1.getpresDetails();
					HashMap ext_drugData	=	null;
					String ext_drug_code	=	null;
					String ext_srl_no		=	null;
					String curr_yn    = "";
					String current_rx="", allergy_yn="", limit_ind="", Override_remarks="";
					for(int j=0;j<prescriptionDetails.size();j++){
						ext_drugData      =  (HashMap) prescriptionDetails.get(j);
						ext_drug_code	=	(String) ext_drugData.get("DRUG_CODE");
						ext_srl_no		=	(String) ext_drugData.get("SRL_NO");
						if( drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no) ){
							allergy_yn  =(String) ext_drugData.get("ALLERGY_YN")==null?"N":(String) ext_drugData.get("ALLERGY_YN");
							limit_ind  =(String) ext_drugData.get("LIMIT_IND")==null?"Y":(String) ext_drugData.get("LIMIT_IND");
							current_rx  =(String) ext_drugData.get("CURRENT_RX")==null?"":(String) ext_drugData.get("CURRENT_RX");
							if(current_rx.equals("Y")){
								Override_remarks=(String)ext_drugData.get("CURRENTRX_REMARKS");
								if(Override_remarks==null || Override_remarks.equals("")){
									out.println("parent.f_detail.document.prescription_detail_form.override_rem_mand.value='Y';");
								}
								
							}
							if(limit_ind.equals("N")){
								Override_remarks="";
								Override_remarks=(String)ext_drugData.get("DOSE_REMARKS");
								if(Override_remarks==null || Override_remarks.equals("")){
									out.println("parent.f_detail.document.prescription_detail_form.override_rem_mand.value='Y';");
								}	
							}
							if( allergy_yn.equals("Y")){
								Override_remarks="";
								Override_remarks=(String)ext_drugData.get("ALLERGY_REMARKS");
								if(Override_remarks==null || Override_remarks.equals("")){
									out.println("parent.f_detail.document.prescription_detail_form.override_rem_mand.value='Y';");
								}
									
							}
							break;
						}
						
					}	
					putObjectInBean(bean_id1,bean1,request);
				}
				//Added for IN:073485 END
				else if(func_mode != null && func_mode.equals("clearDataMedn")){ //moved from prescriptionvalidation_1.jsp to prescriptionvalidation.jsp
			String or_bean_id	="";
			String patient_id	= (String) hash.get( "patient_id" );
			String encounter_id	= (String) hash.get( "encounter_id" );
			String pract_type = (String)hash.get("pract_type")==null?"":(String)hash.get("pract_type"); //added for ML-BRU-SCF-0958 [IN:042045]
			String or_bean_name	="eOR.OrderEntryBean";
			or_bean_id="@orderentrybean"+patient_id+encounter_id;
			OrderEntryBean orbean = (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
			eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
			String key	= (orbean.getPatientId()+orbean.getEncounterId());
			// Unique key to keep the Value in the Bean
			java.util.HashMap previousValues= (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);
			String order_catalog_code 		= orbean.getOrderCatalogCode(previousValues,"PH", pract_type); // pract_type added for ML-BRU-SCF-0958 [IN:042045]
			ArrayList ordeCatalogCode = new ArrayList();
			/*	Added on 07 Sep 2007, to handle the multiple occurance of a same drug from orderset.*/
			if(order_catalog_code != null && !order_catalog_code.equals("")){
				StringTokenizer token = new StringTokenizer(order_catalog_code, ",");
				StringTokenizer catalogdetail;
				String temp;
				while(token.hasMoreTokens()){
					temp = token.nextToken();
					if(temp.indexOf("#")!= -1){
						catalogdetail = new StringTokenizer(temp, "#");
						while(catalogdetail.hasMoreTokens()){
							ordeCatalogCode.add(catalogdetail.nextToken());
						}
					}
					else{
						ordeCatalogCode.add(temp);
						ordeCatalogCode.add("1");
						ordeCatalogCode.add("PH");
					}
				}
			}
			String checkedKey	=	null;
			for(int i=0;i<ordeCatalogCode.size();i+=3){
				checkedKey=(String) ordeCatalogCode.get(i);
				orderEntryRecordBean.removeCheckedEntries (key,"ck"+checkedKey);
				orderEntryRecordBean.removeCheckedEntries (key,"h1"+checkedKey);
				orderEntryRecordBean.removeCheckedEntries (key,"h2"+checkedKey);
			}
			ArrayList arrCheckCatalog = (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("CK_CODE",("CK_CODE_0"));
			String removable_catalog_code="";
			int index=0;
			if(arrCheckCatalog!=null){
				for(int i=0;i<ordeCatalogCode.size();i+=3){
					checkedKey=(String) ordeCatalogCode.get(i);
					removable_catalog_code= "ck"+checkedKey;
					if(arrCheckCatalog.contains(removable_catalog_code)){
						index			  =	arrCheckCatalog.indexOf(removable_catalog_code);
					}
					if(index!=-1){ // If found
						if(((String)arrCheckCatalog.get(index)).equalsIgnoreCase(removable_catalog_code))
							arrCheckCatalog.remove(index);
					}
				}
				if(arrCheckCatalog.size() > 0){
					orderEntryRecordBean.setOrderFormats("CK_CODE", ("CK_CODE_0"),arrCheckCatalog);
				}
				else{
					orbean.setRefreshYn("Y");
				}
			}
			out.println("reloadMIR()");
			putObjectInBean(or_bean_id,orbean,request);
		}//Added for BRU-HIMS-CRF-403
		else if(func_mode!=null && func_mode.equals("getMARDefaulting")){   //  RUT-CRF-0062 [IN029600]  Added to set Build MAR Rule --  begin
			String facility_id	= (String)hash.get("facility_id"); 
			String patient_class	= (String)hash.get("patient_class"); 
			String location_code	= (String) hash.get("location_code")==null?"":(String)hash.get("location_code");
			String form_code		= (String) hash.get("form_code")==null?"":(String)hash.get("form_code");
			String priority			= (String)hash.get("priority");
			String build_MAR_Default=	bean.getMARDefaulting(patient_class,location_code,form_code,priority);
			out.println("setBuildMAR('"+build_MAR_Default+"');");
		} //  RUT-CRF-0062 [IN029600]  Added to set Build MAR Rule --  end
		else if(func_mode!= null && func_mode.equals("GET_EXTERNAL_STATUS")){
			String patient_id	= (String) hash.get("patient_id")==null?"":(String) hash.get("patient_id");
			String encounter_id	= (String) hash.get("encounter_id")==null?"":(String) hash.get("encounter_id");
			String no_extrnal_drug	= (String) hash.get("no_extrnal_drug")==null?"":(String) hash.get("no_extrnal_drug");
			String chk_status	= (String) hash.get("chk_status")==null?"":(String) hash.get("chk_status");
			
			//PrescriptionBean_1 bean		= (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request);
	        //ystem.out.println("in  prescriptionvaliDATIONUPDATE_EXTERNAL_STATUS");
		String no_ext_drug=bean.extDrugApplicableYN(patient_id,encounter_id);
		if(no_extrnal_drug == null){
			no_extrnal_drug="N";
		}
		
		
		out.println("recallmedication('"+no_ext_drug+"');");
		}
			//Added for IN:069886 start, Modified for IN:069886
				else if(func_mode != null && func_mode.equals("assinLastRefillDate")){
			String last_refill_end_date			= (String) hash.get( "last_refill_end_date" ); 
			String srl_no			= (String) hash.get( "srl_no" );
			String last_refill_durn_value			= (String) hash.get( "last_refill_durn_value" );
			String last_refill_freq_chnage_durn_value			= (String) hash.get( "last_refill_freq_chnage_durn_value" );
			String end_date			= (String) hash.get( "end_date" );
			String durn_value			= (String) hash.get( "durn_value" );
			String repeat_durn_type			= (String) hash.get( "repeat_durn_type" );
			String refill_no			= (String) hash.get( "refill_no" );
			if(!locale.equals("en"))
				last_refill_end_date =  DateUtils.convertDate(last_refill_end_date, "DMYHM",locale,"en");
			
			 	HashMap	refill_detail	=(HashMap)	presBean.populateRefillDetail(end_date,durn_value,repeat_durn_type,refill_no);
			
			System.out.println("refill_detail="+refill_detail);
			if(!(refill_no.equals("") || refill_no.equals("0"))){
			ArrayList refill_end_date=(ArrayList) refill_detail.get("refill_end_date");
			System.out.println("refill_end_date="+refill_end_date);
			refill_end_date.set(refill_end_date.size()-1, last_refill_end_date);
			refill_detail.put("refill_end_date", refill_end_date);
			if(!last_refill_durn_value.equals("")){
			refill_detail.put("last_refill_durn_value", last_refill_durn_value);
			refill_detail.put("last_refill_freq_chnage_durn_value", last_refill_freq_chnage_durn_value);
			}
			
			refill_detail.put("end_date", end_date);
			refill_detail.put("durn_value", durn_value);
			refill_detail.put("repeat_durn_type", repeat_durn_type);
			refill_detail.put("refill_no", refill_no);
			
			System.out.println("refill_detail After update="+refill_detail);
			bean.setRefillDetail(srl_no,refill_detail);
			}
			
		}
		else if(func_mode != null && func_mode.equals("removerefill")){
				String srl_no			= (String) hash.get( "srl_no" );
				bean.removeRefillDetail(srl_no);
		}
		else if(func_mode != null && func_mode.equals("saveRefill")){
			String srl_no			= (String) hash.get( "srl_no" );
			String end_date			= (String) hash.get( "end_date" );
			String durn_value			= (String) hash.get( "durn_value" );
			String repeat_durn_type			= (String) hash.get( "repeat_durn_type" );
			String refill_no			= (String) hash.get( "refill_no" );
			HashMap refill_detail	=(HashMap)	presBean.populateRefillDetail(end_date,durn_value,repeat_durn_type,refill_no);
			bean.setRefillDetail(srl_no,refill_detail);
		}
		//Added for IN:069886 end , Modified for IN:069886
			//Added for IN:069887 start
		else if(func_mode!= null && func_mode.equals("override_mand_check_on_confirm")) {
					String drugCode		= (String)hash.get("drug_code");
					String srlNo		= (String)hash.get("srl_no");
					String patient_id	= (String)hash.get("patient_id");
					String encounter_id	= (String)hash.get("encounter_id");
					String interaction_exists	= (String)hash.get("interaction_exists");
					String bean_id1	="@PrescriptionBean_1"+patient_id+encounter_id;
					String bean_name1	="ePH.PrescriptionBean_1";
					PrescriptionBean_1 bean1		= (PrescriptionBean_1)getBeanObject(bean_id1,bean_name1,request);
					ArrayList prescriptionDetails=(ArrayList)bean1.getpresDetails();
					HashMap ext_drugData	=	null;
					String ext_drug_code	=	null;
					String ext_srl_no		=	null;
					String curr_yn    = "";
					String current_rx="", allergy_yn="", limit_ind="", Override_remarks="";
					String allergy_remarks_yn="N", dup_remarks_yn="N", dose_remarks_yn="N", drug_drug_remarks_yn="N", drug_lab_remarks_yn="N",drug_food_remarks_yn="N";
					for(int j=0;j<prescriptionDetails.size();j++){
						ext_drugData      =  (HashMap) prescriptionDetails.get(j);
						ext_drug_code	=	(String) ext_drugData.get("DRUG_CODE");
						ext_srl_no		=	(String) ext_drugData.get("SRL_NO");
						if( drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no) ){
							allergy_yn  =(String) ext_drugData.get("ALLERGY_YN")==null?"N":(String) ext_drugData.get("ALLERGY_YN");
							limit_ind  =(String) ext_drugData.get("LIMIT_IND")==null?"Y":(String) ext_drugData.get("LIMIT_IND");
							current_rx  =(String) ext_drugData.get("CURRENT_RX")==null?"":(String) ext_drugData.get("CURRENT_RX");
							if(current_rx.equals("Y")){
								Override_remarks=(String)ext_drugData.get("CURRENTRX_REMARKS");
								if(Override_remarks==null || Override_remarks.equals("")){
									dup_remarks_yn="Y";
								}
								
							}
							if(limit_ind.equals("N")){
								Override_remarks="";
								Override_remarks=(String)ext_drugData.get("DOSE_REMARKS");
								if(Override_remarks==null || Override_remarks.equals("")){
									//out.println("parent.f_detail.document.prescription_detail_form.override_rem_mand.value='Y';");
									dose_remarks_yn="Y";
								}	
							}
							if( allergy_yn.equals("Y")){
								Override_remarks="";
								Override_remarks=(String)ext_drugData.get("ALLERGY_REMARKS");
								if(Override_remarks==null || Override_remarks.equals("")){
									//out.println("parent.f_detail.document.prescription_detail_form.override_rem_mand.value='Y';");
									allergy_remarks_yn="Y";
									
								}
									
							}
							if(interaction_exists.equals("Y")){
							String interaction_type = "";
							ArrayList intrType= new ArrayList();
							ArrayList alDrugIntrList = (ArrayList) ext_drugData.get("INTERACTION_DTL");
							if(alDrugIntrList!=null && alDrugIntrList.size()>2){
								HashMap hmDrugInteractionDtl = null;
								for(int intr=0; intr<(alDrugIntrList.size()-2); intr++){
									hmDrugInteractionDtl = (HashMap) alDrugIntrList.get(intr);
									//intr_msg_content += (String)hmDrugInteractionDtl.get("intr_name")+", ";
									interaction_type = (String)hmDrugInteractionDtl.get("INTR_TYPE2");
									intrType.add(interaction_type);
									System.err.println("interaction_type=====274===>"+interaction_type); 
									
								}  
							}
							
							if(intrType!=null && intrType.size()>0){
								if(intrType.contains("D") || intrType.contains("G")){
									Override_remarks=(String)ext_drugData.get("INTERACTION_REMARKS");
									if(Override_remarks==null || Override_remarks.equals("")){
										drug_drug_remarks_yn="Y";
									}									
								}
								if(intrType.contains("F")){
									Override_remarks=(String)ext_drugData.get("FOOD_INTERACTION_REMARKS");
									if(Override_remarks==null || Override_remarks.equals("")){
										drug_food_remarks_yn="Y";
									}								}
								if(intrType.contains("L")){
									Override_remarks=(String)ext_drugData.get("LAB_INTERACTION_REMARKS");
									if(Override_remarks==null || Override_remarks.equals("")){
										drug_lab_remarks_yn="Y";//drug_lab_remarks_yn
									}
									}
							}	
							}
							out.println("showOverideMandAlert('"+allergy_remarks_yn+"','"+dup_remarks_yn+"','"+dose_remarks_yn+"','"+drug_drug_remarks_yn+"','"+drug_lab_remarks_yn+"','"+drug_food_remarks_yn+"')");
							//showOverideMandAlert(allergy_remarks_yn, dup_remarks_yn, dose_remarks_yn, drug_drug_remarks_yn, drug_lab_remarks_yn,drug_food_remarks_yn);
							break;
						}
						
					}	
					putObjectInBean(bean_id1,bean1,request);
				}
				else if(func_mode != null && func_mode.equals("setSelSuppDrugs")){
					String selected_drugs			= (String) hash.get( "selected_drugs" );
					String parent_drug              = (String) hash.get( "main_drug" );
					 presBean.setSelSuppList(parent_drug,selected_drugs);
					 putObjectInBean(presBean_id,presBean,request);
		}
else if(func_mode!= null && func_mode.equals("deleteSuppDrugs")) {//Adding start for TH-KW-CRF-0007
				String drugCode		= (String)hash.get("drug_code");
				String patient_id	= (String)hash.get("patient_id");
			    String encounter_id	= (String)hash.get("encounter_id");
				String parent_stat_yn	= "";
				String drug_db_interface_yn = (String)hash.get("drug_db_interface_yn")==null?"":(String)hash.get("drug_db_interface_yn");
			    String stat_yn			="";
				String st_date_local="",end_date_local="",severity_level="",ext_prod_id="" ;
				HashMap ext_drugData	=	null;
			    HashMap addext_drugData	=	null;
				int sno= 0;
				String search_bean_id	="@DrugSearchBean"+patient_id+encounter_id;
				String search_bean_name	="ePH.DrugSearchBean";
				DrugSearchBean searchbean = (DrugSearchBean)getBeanObject( search_bean_id, search_bean_name , request) ;
				drugCode = drugCode.trim();
				int drug_index	=	-1;
				String temp_freq_nature="";
				int remove_pos	=	0;
				ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
				HashMap suppDrugsMap = presBean.getSuppDrugMap();
				ArrayList supp_drug =new ArrayList();
				ArrayList supp_list =new ArrayList();
				HashMap temp			=	new HashMap();
				 if(suppDrugsMap.containsKey(drugCode)){
                      supp_list = (ArrayList)suppDrugsMap.get(drugCode);
				 }
				int codeCount_1=0;
				int codeCount_2=0;
				String ext_drug_code	=	"";
				String ext_srl_no		=	null;
				String generic_id ="";
				String curr_yn    = "";
				parent_stat_yn="";   
				stat_yn="";   
				String sup_drug_code="";
				ArrayList atc_dup_drug_code = new ArrayList();
				ArrayList alDrugIntrDtlList = null;
				
				ArrayList ext_drug = bean.getExternal_drugs(); 
				
				if(supp_list.size()>0){
					 for(int z=0;z<supp_list.size();z++){
						 sup_drug_code =(String)supp_list.get(z);
						 if(ext_drug.size()>0){ 
					         ext_drug.remove(sup_drug_code);
					         bean.setExternal_drugs(ext_drug);
				          }
				for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData      =  (HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
				  if(sup_drug_code.equals(ext_drug_code)){
					ext_srl_no=(String) ext_drugData.get("SRL_NO");
					temp_freq_nature = ext_drugData.get("FREQ_NATURE")==null?"": (String) ext_drugData.get("FREQ_NATURE");
					parent_stat_yn  = (String)ext_drugData.get( "parent_stat_yn" )==null?"N":(String)ext_drugData.get("parent_stat_yn");
                    generic_id      = (String)ext_drugData.get( "GENERIC_ID" )==null?"N":(String)ext_drugData.get("GENERIC_ID");
					curr_yn			  = "";
                   
					if(ext_drugData.containsKey("ATC_DUP_DRUG_CODE")){
						atc_dup_drug_code  =  (ArrayList) ext_drugData.get("ATC_DUP_DRUG_CODE");
						if(atc_dup_drug_code!=null && atc_dup_drug_code.contains(sup_drug_code)){
							atc_dup_drug_code.remove(sup_drug_code);
						}
						if(ext_drugData.get("GENERIC_ID").equals(generic_id))
							atc_dup_drug_code.clear();
						if(!(atc_dup_drug_code.size()>0)) {
							ext_drugData.put("CURRENT_RX",curr_yn);
							ext_drugData.put("ATC_LEVEL_DUPLICATION","N");
							ext_drugData.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
							ext_drugData.put("CURRENTRX_REMARKS","");
							if(ext_drugData.containsKey("ALERT_YN"))
								ext_drugData.remove("ALERT_YN");
						}
					}
					if(ext_drugData.containsKey("ATC_LEVEL4_DUP_DRUG_CODE")){
						atc_dup_drug_code  =  (ArrayList) ext_drugData.get("ATC_LEVEL4_DUP_DRUG_CODE");
						if(atc_dup_drug_code!=null && atc_dup_drug_code.contains(sup_drug_code)){
							atc_dup_drug_code.remove(sup_drug_code);
						}
						
						if(!(atc_dup_drug_code.size()>0))	{
							ext_drugData.put("CURRENT_RX",curr_yn);
							ext_drugData.put("ATC_LEVEL4_DUPLICATION","N");
							ext_drugData.put("ATC_LEVEL4_DUP_DRUG_CODE",atc_dup_drug_code);
							ext_drugData.put("CURRENTRX_REMARKS","");
							if(ext_drugData.containsKey("ALERT_YN"))
								ext_drugData.remove("ALERT_YN");
						}
					}
				
					if( !(temp_freq_nature.equals("P") || temp_freq_nature.equals("O"))){
						if(sup_drug_code.equals(ext_drug_code)){
							codeCount_1++;
						}
						if(sup_drug_code.equals(ext_drug_code))
							drug_index = j;
					}
				if(codeCount_1>1){
						if(sup_drug_code.equals(ext_drug_code)){
							codeCount_2++;
						}
				
				}
					parent_stat_yn  = (String)ext_drugData.get( "parent_stat_yn" )==null?"N":(String)ext_drugData.get("parent_stat_yn");
					
					if( sup_drug_code.equals(ext_drug_code)){
						remove_pos=j;
					}
					prescriptionDetails.remove((remove_pos));
					searchbean.removeDrugCode(sup_drug_code);
					searchbean.removeSelectedDrug(sup_drug_code);
					bean.getclearscheduleFrequency(sup_drug_code);
					bean.removePRNRemarks(sup_drug_code);
					bean.clearCopiedDrugs(sup_drug_code);
					if(prescriptionDetails.size()>0 && remove_pos>0){
						ext_drugData=(HashMap) prescriptionDetails.get(remove_pos-1);
						if(drugCode.equals((String)ext_drugData.get("DRUG_CODE")))
							ext_drugData.put("DRUG_TAPERED_YN","N");
							ext_drugData.put("parent_stat_yn","N");  
							ext_drugData.put("stat_yn","N");  
					}
					String inrteraction_exists="",  restrict_transaction="N"; 
						if(ext_drugData!=null){
							ext_prod_id=  (String) ext_drugData.get("EXTERNAL_PRODUCT_ID")==null?"":(String) ext_drugData.get("EXTERNAL_PRODUCT_ID");
							if((!drug_db_interface_yn.equals("Y")) || ext_prod_id.equals("")){
								inrteraction_exists=(String) ext_drugData.get("INTERACTION_EXISTS")==null?"":(String) ext_drugData.get("INTERACTION_EXISTS");
								if(inrteraction_exists.equals("Y")){
									ext_drugData.put("INTERACTION_EXISTS", "N" );
									ext_drugData.put("INTR_MSG_CONTENT","");
									ext_drugData.put("INTR_RESTRIC_TRN","N");
									st_date_local = (String)ext_drugData.get("START_DATE");
									end_date_local =  (String)ext_drugData.get("END_DATE");
									if(!locale.equals("en")){
										st_date_local =  DateUtils.convertDate(st_date_local, "DMYHM",locale,"en");
										end_date_local =  DateUtils.convertDate(end_date_local, "DMYHM",locale,"en");
									}
									alDrugIntrDtlList = bean.getDrugInteractionDtls(ext_drug_code,  (String) ext_drugData.get("FORM_CODE"), (String) ext_drugData.get("GENERIC_ID"), st_date_local, end_date_local, patient_id);
									if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()>2){
										severity_level = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2) ;
										restrict_transaction= (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1);
										ext_drugData.put("SEVERITY_LEVEL", (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2) );
										ext_drugData.put("INTR_RESTRIC_TRN", (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1) );
										ext_drugData.put("INTERACTION_DTL", alDrugIntrDtlList );
										ext_drugData.put("INTERACTION_EXISTS", "Y" );
										if(restrict_transaction.equals("Y") || severity_level.equals("H")){
											ext_drugData.put("INTR_ALERT", "Y" );
										}
																			
									if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()> 0){
										HashMap DrugInteractionDtl=null;
										String interaction_type  = "";
										ArrayList intrType  = new ArrayList();
										for(int count=0 ; count<(alDrugIntrDtlList.size()-2) ; count++){
											DrugInteractionDtl =(HashMap) alDrugIntrDtlList.get(count);
											interaction_type = (String)DrugInteractionDtl.get("INTR_TYPE2"); 
											intrType.add(interaction_type);
									}
									if(intrType!=null && intrType.size()>0){
										if(intrType.contains("D") || intrType.contains("G")){
											temp.put("DRUG_INTERACTION_EXISTS","Y");
										}
										if(intrType.contains("F")){
											temp.put("FOOD_INTERACTION_EXISTS","Y");
										}
										if(intrType.contains("L")){
											temp.put("LAB_INTERACTION_EXISTS","Y");
										}
										if(intrType.contains("I")){//Added for MMS-DM-CRF-0229
									        temp.put("DISEASE_INTERACTION_EXISTS","Y");
								         }
									}
								   } 
								 }
								}
							}
						}
				      }
					}
					out.println("deleteOROrderCatalog('"+sup_drug_code+"')") ;
				}
				
			}
		    	putObjectInBean(search_bean_id,searchbean,request);
				return;
		}//Adding end for TH-KW-CRF-0007
		else if(func_mode != null && func_mode.equals("chkQuotaLimit")){
			
			String dosage_type       = (String)hash.get("dosage_type");	
			String freq_nature       = (String)hash.get("freq_nature");
			String durn_value        = (String)hash.get("durn_value");
			String pres_base_uom 	 = (String)hash.get("pres_base_uom");
			String qty_desc_code	 = (String)hash.get("qty_desc");
			String absol_qty	     = (String)hash.get("absol_qty");		
			String drugCode			 = (String)hash.get("drug_code");
		    String srlNo			 = (String)hash.get("srl_no");
			String repeat_value		 = (String)hash.get("repeat_value");
			String quotaLimitValue	 = (String)hash.get("quotaLimitValue");
			String setLimitByType	 = (String)hash.get("setLimitByType");
			String quotaCurrValue	 = (String)hash.get("quotaCurrValue");
			String patient_id        = (String)hash.get("patient_id");
			String spec_code         = (String)hash.get("spec_code");
			String quota_limit_access_yn         = (String)hash.get("quota_limit_access_yn");
			String act_pres_appl_yn  = bean.getActivePrepApplQuotaYN();
			HashMap ext_drugData	 =	null;
			String ord_qty           =  "";
			String drug_code         =  "";
			String conv_factor		 =	"";
			String qty_value         =  (String)hash.get("qty_value");
			String sch_size			 =	"";
			String trn_quota_limit_value ="";
			String curr_quota_limit_value ="";
			String temp_quota_limit_value ="";
			String show_alert ="Y";
			System.err.println("drugCode@@@=="+drugCode+"srlNo@@@==="+srlNo+"repeat_value=="+repeat_value+"dosage_type=="+dosage_type+"freq_nature=="+freq_nature+"durn_value=="+durn_value+"pres_base_uom=="+pres_base_uom+"qty_desc_code=="+qty_desc_code+"absol_qty=="+absol_qty+"quotaLimitValue=="+quotaLimitValue+"setLimitByType=="+setLimitByType+"quotaCurrValue=="+quotaCurrValue+"act_pres_appl_yn=="+act_pres_appl_yn+"patient_id=="+patient_id+"spec_code=="+spec_code+"act_pres_appl_yn=="+act_pres_appl_yn);
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			if(setLimitByType.equals("Q")){
			      if(dosage_type.equals("Q"))
				    conv_factor = (String) bean.getConvFactor(qty_desc_code,pres_base_uom);
			      else 
                    conv_factor ="1";
			ArrayList	schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drugCode+srlNo,"0");
			System.err.println("schedule@@=="+schedule);
			if(schedule.size() > 0) {
						 ArrayList dose_list		= (ArrayList)schedule.get(4);
						 if(dose_list!=null && dose_list.size()>0)
							 qty_value		= (String)dose_list.get(0);
						     sch_size		=	""+dose_list.size();
					}
					else {
						     sch_size		=	repeat_value;
					}

		for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData		=(HashMap) prescriptionDetails.get(j);
					drug_code			=(String) ext_drugData.get("DRUG_CODE");
			if(drugCode.equals(drug_code)){
				    if(dosage_type.equals("A") || freq_nature.equals("P")) {
						  qty_value	=	absol_qty;
					}
					//System.err.println("qty_value@@=="+qty_value+"sch_size=="+sch_size+"durn_value=="+durn_value+"dosage_type=="+dosage_type+"conv_factor=="+conv_factor);
					if(freq_nature.equals("P"))
				       ord_qty =absol_qty;
					else
					   ord_qty =bean.getOrderQty(ext_drugData,qty_value,sch_size,durn_value,dosage_type,conv_factor);
                    float new_total_qty=0;
					new_total_qty = Float.parseFloat(ord_qty);
					ord_qty =String.format("%.0f", new_total_qty);
								//System.err.println("ord_qty@@=="+ord_qty);
							
					trn_quota_limit_value = ord_qty+"/"+quotaLimitValue;
					System.err.println("trn_quota_limit_value==="+trn_quota_limit_value);
			     if(Float.parseFloat(ord_qty) > Float.parseFloat(quotaLimitValue)){
					 ext_drugData.put("TRN_QUOTA_LIMIT_VALUE",trn_quota_limit_value);
					 ext_drugData.put("QUOTA_LIMIT_TYPE",setLimitByType);
					 if(quota_limit_access_yn.equals("N")){
					     out.println("alertExccedQuotaLimit()");
				       }
				 }else{
                     ext_drugData.put("TRN_QUOTA_LIMIT_VALUE",trn_quota_limit_value);
				 }
			  }
			}
		  }else if(setLimitByType.equals("P")){
			  for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData		=(HashMap) prescriptionDetails.get(j);
					drug_code			=(String) ext_drugData.get("DRUG_CODE");
			if(drugCode.equals(drug_code)){

			  if(act_pres_appl_yn.equals("Y")){
				  System.err.println("patient_id@@=="+patient_id+"drugCode=="+drugCode+"spec_code=="+spec_code);
				          curr_quota_limit_value =  bean.getActQuotaDrugValue(patient_id,spec_code,drugCode);
						  System.err.println("curr_quota_limit_value from active drugs=="+curr_quota_limit_value);
						  if(curr_quota_limit_value.equals("")){
							  if(quota_limit_access_yn.equals("Y")){
							      curr_quota_limit_value =Integer.parseInt(quotaCurrValue)+1+"";
						          trn_quota_limit_value = curr_quota_limit_value+"/"+quotaLimitValue;
								  temp_quota_limit_value = curr_quota_limit_value;
							  }else{
                                    curr_quota_limit_value   =  Integer.parseInt(quotaCurrValue)+1+"";
				                     temp_quota_limit_value = curr_quota_limit_value;
									   if(Integer.parseInt(curr_quota_limit_value) <= Integer.parseInt(quotaLimitValue)){
										   curr_quota_limit_value   =  curr_quota_limit_value;
									   }else{
										   curr_quota_limit_value =quotaCurrValue;
									   }
								   trn_quota_limit_value = curr_quota_limit_value+"/"+quotaLimitValue;
								   
							  }
						  }else{
							  curr_quota_limit_value =quotaCurrValue;
						      trn_quota_limit_value = curr_quota_limit_value+"/"+quotaLimitValue;
							  temp_quota_limit_value = quotaCurrValue;
							  show_alert ="N";
						  }

                                ext_drugData.put("TRN_QUOTA_LIMIT_VALUE",trn_quota_limit_value);
						        ext_drugData.put("CURR_QUOTA_LIMIT_VALUE",curr_quota_limit_value);
								 ext_drugData.put("QUOTA_LIMIT_TYPE",setLimitByType);
                        if(Integer.parseInt(temp_quota_limit_value) > Integer.parseInt(quotaLimitValue)){			         
							  if(quota_limit_access_yn.equals("N") && show_alert.equals("Y")){
					              out.println("alertExccedQuotaLimit()");
				                }
					          
				           }

			  }else{
				   if(quota_limit_access_yn.equals("Y")){
				       curr_quota_limit_value   =  Integer.parseInt(quotaCurrValue)+1+"";
				       trn_quota_limit_value = curr_quota_limit_value+"/"+quotaLimitValue;
					   temp_quota_limit_value = curr_quota_limit_value;
				   }else{
					   curr_quota_limit_value   =  Integer.parseInt(quotaCurrValue)+1+"";
				       temp_quota_limit_value = curr_quota_limit_value;
					   if(Integer.parseInt(curr_quota_limit_value) <= Integer.parseInt(quotaLimitValue)){
						   curr_quota_limit_value   =  curr_quota_limit_value;
					   }else{
						   curr_quota_limit_value =quotaCurrValue;
					   }
					   trn_quota_limit_value = curr_quota_limit_value+"/"+quotaLimitValue;
				   }
					 ext_drugData.put("TRN_QUOTA_LIMIT_VALUE",trn_quota_limit_value);
					 ext_drugData.put("CURR_QUOTA_LIMIT_VALUE",curr_quota_limit_value);
					 ext_drugData.put("QUOTA_LIMIT_TYPE",setLimitByType);
					 System.err.println("curr_quota_limit_value@@=="+curr_quota_limit_value+"trn_quota_limit_value=="+trn_quota_limit_value);
				   if(Integer.parseInt(temp_quota_limit_value) > Integer.parseInt(quotaLimitValue)){
					   if(quota_limit_access_yn.equals("N")){
					     out.println("alertExccedQuotaLimit()");
				       }      
				     }
			       }
		     	}	  	  
		     }
		  }
		}
	
		//Added for IN:069887  END
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(presBean_id,presBean,request);
	}
	catch (Exception e) {
		e.printStackTrace();
	}	
%>

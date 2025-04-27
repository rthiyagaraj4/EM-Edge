<%@page import="com.ehis.util.BundleMessage"%> 
<%@page import="org.jgroups.Message"%>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*,eXH.*" %> 
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE"); 
   Connection con			= null;  // Added for ML-MMOH-crf-0468 start
    
    // Added for ML-MMOH-CRF-0468 - End
	
	boolean siteTpnStd =false;
	boolean siteTpn =false;
	boolean is_site_drug_label = false;
	boolean disp_sheet_check=false; //Added for GHL-CRF-0627
		
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ; //added for IN070867
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );//added for IN070867
		String func_mode			= request.getParameter("func_mode");
	try {	
		con				= ConnectionManager.getConnection(request);
		siteTpn = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_MF_LABEL");// Added for ML-MMOH-CRF-0468 		
	    siteTpnStd = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_STD_REGIMEN_LABEL");// added for ML-MMOH-CRF-1089
		is_site_drug_label = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_LABEL_FORMAT");// added for ARYU-CRF-0014
		disp_sheet_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISP_SHEET_CHECK");  //Added for GHL-CRF-0627
	}
	catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}
	finally{ // Added for ML-MMOH-SCF-0468 start
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	} // Added for ML-MMOH-SCF-0468 end	
		

		if (func_mode==null) func_mode="";
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		String bean_id				=	"";
		String bean_name			=	"";
		if(hash.containsKey("SEARCH")) {
			hash				= (Hashtable)hash.get( "SEARCH" ) ;
			bean_id				= (String) hash.get( "bean_id" );
			if (bean_id==null) 	bean_id			= "";
			bean_name			= (String) hash.get( "bean_name" );
			if (bean_name==null) bean_name		= "";
		}

		if(bean_id.equals("")){
			bean_id = request.getParameter("bean_id") == null?"":request.getParameter("bean_id") ;
			bean_name = request.getParameter("bean_name")== null?"":request.getParameter("bean_name") ;
		}

		DispMedicationAllStages beanObj =null;
		if (!bean_name.equals("")){
			beanObj		= (DispMedicationAllStages)getBeanObject(bean_id,bean_name,request);
			beanObj.setLanguageId(locale);
		}
		 if(func_mode!= null && func_mode.equals("storeAltDrugRemarks")){// Added for Bru-HIMS-CRF-082 [IN:029948]-start
			String order_id=(String)hash.get("order_id");
			String order_line_num=(String)hash.get("order_line_num");
			String alt_drug_remarks = hash.get("alt_drug_remarks")==null?"":(String)hash.get("alt_drug_remarks");
			beanObj.setAltDrugRemarks(order_id+"~"+order_line_num, java.net.URLDecoder.decode(alt_drug_remarks,"UTF-8"));
				
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject("DispMedicationBean", "ePH.DispMedicationBean", request);
			if((beanObj_1.getDispStage().equals("F")&&(beanObj_1.getDispLocnCatg().equals("O")))|| beanObj_1.getFillList().equals("AF")){ 
				beanObj_1.setValuesChanged(true);
			}
		} // Added For Bru-HIMS-CRF-082 [IN:029948] --end
			else if(func_mode!= null && func_mode.equals("printPrescription")){ //added for GHL-CRF-0453 - start
				
				String login_user		=	(String)session.getValue("login_user");
				String facility_id		=	(String)session.getValue("facility_id");
				String tot_rec				= (String) hash.get("tot_rec");
				String patient_id			= (String) hash.get("patient_id");
				String patient_class		= (String) hash.get("patient_class");
				String locn_code			= (String) hash.get("locn_code");
				String print_yn				= "";
				ArrayList arrPrint			= new ArrayList();
				int order_cunt = 1;
				String from_order_id = "";
				String to_order_id = "";
				StringBuffer order_ids = new StringBuffer();
				StringBuffer order_catalog_codes = new StringBuffer();
			//	System.err.println("DispMedicationValidation.jsp===4230==tot_rec======>"+tot_rec);
				for(int i=1;i<Integer.parseInt(tot_rec);i++){
					print_yn = (String)hash.get("print_"+i);
					if(print_yn!=null && print_yn.equals("Y")){
						if(order_cunt==1)
						  from_order_id = (String)hash.get("order_id_"+i);
						else if(i==Integer.parseInt(tot_rec)-1)
						  to_order_id = (String)hash.get("order_id_"+i);

						arrPrint.add((String)hash.get("order_id_"+i));
						arrPrint.add((String)hash.get("order_line_num_"+i));
						arrPrint.add((String)hash.get("drug_code_"+i));
						order_cunt++;
					}
				}
				if(arrPrint!=null && arrPrint.size()>0){


					for (int i=0;i<arrPrint.size();i=i+3){
							if(arrPrint.size()==3){
								order_ids.append((String)arrPrint.get(0)+"");
								order_catalog_codes.append((String)arrPrint.get(2)+"");
							}else{
								if(i==(arrPrint.size()-3)){
									order_ids.append((String)arrPrint.get(i)+"");
									order_catalog_codes.append((String)arrPrint.get(i+2)+"");
								}
								else{
									order_ids.append((String)arrPrint.get(i)+"','");
									order_catalog_codes.append((String)arrPrint.get(i+2)+"','");
								}
							}
					}
				}
				beanObj.updatePrintValue(arrPrint);
				String report_id = "PHFILLAL";


			
				ecis.utils.OnlineReports onlineReports 		= new ecis.utils.OnlineReports() ;
//				ecis.utils.OnlineReport report1				= new ecis.utils.OnlineReport(facility_id,"PH",report_id) ;
				ecis.utils.OnlineReport report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867				
				report1.addParameter("p_Report_id",report_id) ;
				report1.addParameter("P_USER_NAME",login_user) ;
				report1.addParameter("P_FACILITY_ID",facility_id) ;
				report1.addParameter("p_module_id","PH") ;
				report1.addParameter("p_language_id",locale);
				report1.addParameter("P_LOCNCODE",locn_code) ;
				report1.addParameter("P_FM_ORDER_ID",from_order_id) ;
				report1.addParameter("P_TO_ORDER_ID",to_order_id) ;
				report1.addParameter("p_patient_id",patient_id); 
				report1.addParameter("P_PATCLASS",patient_class) ;
//				report1.addParameter("P_PRINT_YN","Y");
				report1.addParameter("P_ORDER_ID",order_ids.toString());
				report1.addParameter("p_order_catlog",order_catalog_codes.toString());
				

			
				onlineReports.add(report1) ;
				String ReportOutput = onlineReports.execute(request, response );

				report1 = null; 
				
			}
		else if(func_mode.equals("addActiveDrug") || func_mode.equals("recordDrug")){// Added for Bru-HIMS-CRF-072.1[IN 049144] start
			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request); 
			String drug_code=CommonBean.checkForNull((String)hash.get("drug_code"));
			String order_id=CommonBean.checkForNull((String)hash.get("order_id"));
			String order_line_no=CommonBean.checkForNull((String)hash.get("order_line_no"));
			String drug_name = java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("drug_name")),"UTF-8");
			String loc_lang_id = medplan_bean.getStrLocalLangID();
			String primary_lang_id = medplan_bean.getStrPrimaryLangID();
			LinkedHashMap hshmap = new LinkedHashMap();
			hshmap.put("drug_name",drug_name);
			hshmap.put("drug_code",drug_code);
			hshmap.put("qty_issue",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("qty_issue")),"UTF-8"));
			hshmap.put("qty_issuelocal",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("qty_issuelocal")),"UTF-8"));
			hshmap.put("curr_disp_yn",CommonBean.checkForNull((String)hash.get("curr_disp_yn")));
			hshmap.put("merge_yn",CommonBean.checkForNull((String)hash.get("merge_yn")));
			hshmap.put("merged_med_plan_id",CommonBean.checkForNull((String)hash.get("merged_med_plan_id")));
			hshmap.put("pres_drug_code",CommonBean.checkForNull((String)hash.get("pres_drug_code")));
			hshmap.put("disp_drug_code",CommonBean.checkForNull((String)hash.get("disp_drug_code")));
			hshmap.put("plan_recorded",CommonBean.checkForNull((String)hash.get("recorded")));
			hshmap.put("impnote",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("impnote")),"UTF-8"));
			hshmap.put("howtotakelocal",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("howtotakelocal")),"UTF-8"));
			hshmap.put("impnotelocal",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("impnotelocal")),"UTF-8"));
			hshmap.put("howtotake",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("howtotake")),"UTF-8"));
			hshmap.put("drug_name_local",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("drug_name_local")),"UTF-8"));
			hshmap.put("order_id",order_id);
			hshmap.put("order_line_no",order_line_no);
			hshmap.put("chkdrug",CommonBean.checkForNull((String)hash.get("chkdrug")));
			if(((String)hshmap.get("chkdrug")).equals("D"))
				hshmap.put("checked","");
			else if (((String)hshmap.get("chkdrug")).equals("E"))
				hshmap.put("checked","checked");
			if(func_mode.equals("recordDrug")){
				String lang_id = CommonBean.checkForNull((String)hash.get("lang_id"));
				String link = CommonBean.checkForNull((String)hash.get("link"));
				hshmap.put("lang_id",lang_id);
				hshmap.put("encounter_id",CommonBean.checkForNull((String)hash.get("encounter_id")));
				hshmap.put("patient_id",CommonBean.checkForNull((String)hash.get("patient_id")));
				hshmap.put("morning",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("morning")),"UTF-8"));
				hshmap.put("afternoon",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("afternoon")),"UTF-8"));
				hshmap.put("evening",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("evening")),"UTF-8"));
				hshmap.put("night",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("night")),"UTF-8"));
				hshmap.put("morninglocal",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("morninglocal")),"UTF-8"));
				hshmap.put("afternoonlocal",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("afternoonlocal")),"UTF-8"));
				hshmap.put("eveninglocal",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("eveninglocal")),"UTF-8"));
				hshmap.put("nightlocal",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("nightlocal")),"UTF-8"));
				hshmap.put("disp_no",CommonBean.checkForNull((String)hash.get("disp_no")));
				hshmap.put("disp_srl_no",CommonBean.checkForNull((String)hash.get("disp_srl_no")));
				hshmap.put("medicationplanner_flag","true");//added for ML-BRU-SCF-1521.1 [IN:055331](medication planner point alone)
				
				if(lang_id.equals(primary_lang_id)){
					medplan_bean.setMedPlan_DrugDetails(order_id+"_"+order_line_no+"_"+drug_code+"_"+lang_id, hshmap);
					if(((String)hshmap.get("curr_disp_yn")).equals("N") && ((String)hshmap.get("plan_recorded")).equals("N") && link.equals(lang_id))
						medplan_bean.getMedPlan_DrugDetails().remove(order_id+"_"+order_line_no+"_"+drug_code+"_"+lang_id);
				}
				if(lang_id.equals(loc_lang_id)){
					medplan_bean.setMedPlan_Local_DrugDetails(order_id+"_"+order_line_no+"_"+drug_code+"_"+loc_lang_id, hshmap);
					if(((String)hshmap.get("curr_disp_yn")).equals("N") && ((String)hshmap.get("plan_recorded")).equals("N") && link.equals(lang_id))
						medplan_bean.getMedPlan_Local_DrugDetails().remove(order_id+"_"+order_line_no+"_"+drug_code+"_"+lang_id);
				}
				medplan_bean.setMedValuesChanged(true);
			}
			else{
				String dose[] = new String[4],doselocal[] = new String[4];
				dose = medplan_bean.getDoseDetails(order_id, order_line_no,primary_lang_id,drug_code,drug_code);
				doselocal = medplan_bean.getDoseDetails(order_id, order_line_no,loc_lang_id,drug_code,drug_code);
				hshmap.put("morning",dose[0]);
				hshmap.put("afternoon",dose[1]);
				hshmap.put("evening",dose[2]);
				hshmap.put("night",dose[3]);
				hshmap.put("morninglocal",doselocal[0]);
				hshmap.put("afternoonlocal",doselocal[1]);
				hshmap.put("eveninglocal",doselocal[2]);
				hshmap.put("nightlocal",doselocal[3]);
				medplan_bean.setMedPlan_DrugDetails(order_id+"_"+order_line_no+"_"+drug_code+"_"+primary_lang_id, hshmap);
				medplan_bean.setMedPlan_Local_DrugDetails(order_id+"_"+order_line_no+"_"+drug_code+"_"+loc_lang_id, hshmap);
			}
		}
		else if(func_mode.equals("updateMedPlan")){
			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request);
			String patient_id=CommonBean.checkForNull((String)hash.get("patient_id"));
			String mediplan_seq_no=CommonBean.checkForNull((String)hash.get("mediplan_seq_no"));
			String encounter_id=CommonBean.checkForNull((String)hash.get("encounter_id"));
			boolean isMedValuesChanged=medplan_bean.isMedValuesChanged();
			if(isMedValuesChanged){
				if(!mediplan_seq_no.equals(""))
					medplan_bean.updateMediPlan(patient_id,mediplan_seq_no);
				else 
					medplan_bean.insertMediPlan(patient_id);
			}
		}
		else if(func_mode.equals("getDetailsBasedonMedPlanid")){
			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request);
			DispMedicationBean dispBean = (DispMedicationBean)getBeanObject( "DispMedicationBean", "ePH.DispMedicationBean",request);
			DispMedicationAllStages all_bean = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages",request);
			String patient_id=CommonBean.checkForNull((String)hash.get("patient_id"));
			String mediplan_seq_no=CommonBean.checkForNull((String)hash.get("medplanid"));
			String encounter_id=CommonBean.checkForNull((String)hash.get("encounter_id"));
			String order_date_from=CommonBean.checkForNull((String)hash.get("order_date_from"));
			String order_date_to=CommonBean.checkForNull((String)hash.get("order_date_to"));
			String disp_locn_code=CommonBean.checkForNull((String)hash.get("disp_locn_code"));
			String disp_locn_desc=CommonBean.checkForNull((String)hash.get("disp_locn_desc"));
			String disp_stage=CommonBean.checkForNull((String)hash.get("disp_stage"));
			String loc_lang_id = all_bean.getSMLOcalLanguageID();
			if(!mediplan_seq_no.equals("")){
				StringBuilder sb = new StringBuilder("'"+mediplan_seq_no+"',");
				ArrayList<String> mediplan_report_query  =new ArrayList<String>();
				mediplan_report_query.add(patient_id);//0
				mediplan_report_query.add(mediplan_seq_no);//1
				mediplan_report_query.add(order_date_from);//2
				mediplan_report_query.add(order_date_to);//3
				mediplan_report_query.add(disp_locn_code);//4
				mediplan_report_query.add(encounter_id);//5
				mediplan_report_query.add(disp_stage);//6
				
				dispBean.setDispLocnName(disp_locn_desc);
				dispBean.setDispLocnCode(disp_locn_code);//Added for [IN:051273]
				dispBean.setEncounterID(encounter_id);//Added for [IN:051273]
				dispBean.setPatientclass("OP");
				medplan_bean.setMediplan_report_query(mediplan_report_query);
				medplan_bean.setStrCalledFrom("Report");
				medplan_bean.setStrTotal_gross_charge_amount("");
				medplan_bean.setStrPrimaryLangID("en");
				medplan_bean.setStrLocalLangID(loc_lang_id);
				medplan_bean.clearMediPlanSeqNo();
				medplan_bean.setMedValuesChanged(false);
				medplan_bean.setMediPlanSeqNo(mediplan_seq_no);
				medplan_bean.clearMedPlan_DrugDetails();
				medplan_bean.clearMedPlan_Local_DrugDetails();
				medplan_bean.getDetailsBasedonMedPlanid(patient_id, sb);
			}
		}
		else if(func_mode.equals("cancelDrug")){
			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request);
			HashMap hshmedplan = medplan_bean.getMedPlan_DrugDetails();
			HashMap hshTemp = new HashMap();
			List <String> arrTemp= new ArrayList<String>();
			Set <String> hshKeys = new HashSet<String>();
			hshKeys = hshmedplan.keySet();
			if(hshKeys!=null && hshKeys.size()>0){
				for(String key:hshKeys){
					hshTemp = (HashMap)hshmedplan.get(key);
					if(((String)hshTemp.get("curr_disp_yn")).equals("N") && !((String)hshTemp.get("plan_recorded")).equals("Y"))
						arrTemp.add(key);
				}
			}
			hshmedplan =  medplan_bean.getMedPlan_Local_DrugDetails();
			hshKeys = hshmedplan.keySet();
			if(hshKeys!=null && hshKeys.size()>0){
				for(String key:hshKeys){
					hshTemp = (HashMap)hshmedplan.get(key);
					if(((String)hshTemp.get("curr_disp_yn")).equals("N") && !((String)hshTemp.get("plan_recorded")).equals("Y"))
						arrTemp.add(key);
				}
			}
			for(String temp: arrTemp){
				medplan_bean.getMedPlan_DrugDetails().remove(temp);
				medplan_bean.getMedPlan_Local_DrugDetails().remove(temp);
			}
		}// Added for Bru-HIMS-CRF-072.1[IN 049144] end
		else if(func_mode!= null && func_mode.equals("updateReviewDetails")){
			DispMedicationAllStages beanObject =null;
			String login_user				= (String) hash.get("reviewed_by");
			String calling_func			= (String) hash.get("calling_func");
			String order_id			= (String) hash.get("order_id");
			String order_line_no			= (String) hash.get("order_line_no");
			String allergy_cnt			= (String) hash.get("allergy_cnt");
			String alergy_details			= (String) hash.get("alergy_details");
			String duplicate_details			= (String) hash.get("duplicate_details");
			String dosage_details			= (String) hash.get("dosage_details");
			String intaraction_details      =(String) hash.get("intaraction_details");
			String bean_id_remarks	 = (String)hash.get("bean_id");
			String bean_name_remarks = (String)hash.get("bean_name");
			beanObject		= (DispMedicationAllStages)getBeanObject(bean_id_remarks, bean_name_remarks,request);	
			beanObject.setLanguageId(locale);
			beanObject.updateReviewDetails(login_user,calling_func,order_id,order_line_no,allergy_cnt,alergy_details,dosage_details,duplicate_details,intaraction_details);
			
		
		}else if(func_mode!= null && func_mode.equals("ApprovalNo")){ //added for AAKH-CRF-0117 - start
			
			String	bean_id_1			=	"DispMedicationBean" ;
			String	bean_name_1			=	"ePH.DispMedicationBean";
			DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
			
			
			String tot_rec				= (String) hash.get("tot_rec");
			String approval_no = (String)hash.get("approval_no");
			String order_id = "";
			String order_line_no = "";
			String drug_code="";
			for (int i=1;i<Integer.parseInt(tot_rec);i++ ){
				order_id = (String)hash.get("order_id_"+i);
				order_line_no = (String)hash.get("order_line_num_"+i);
				//drug_code = (String)hash.get("drug_code_"+i);
				bean_1.setApprovalNo(order_id,order_line_no,approval_no);//modified for AAKH-CRF-0117
			}
		 
		putObjectInBean(bean_id_1,bean_1,request);
 		}else if(func_mode!= null && func_mode.equals("ApprovalNoForDrug")){ //added for AAKH-CRF-0117 - start
			
			String	bean_id_1			=	"DispMedicationBean" ;
			String	bean_name_1			=	"ePH.DispMedicationBean";
			DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
			
			
			 
			String approval_no = (String)hash.get("approval_no");
			String order_id = "";
			String order_line_no = "";
			String drug_code="";
 
			order_id = (String)hash.get("order_id");
			order_line_no = (String)hash.get("order_line_num");
			//drug_code = (String)hash.get("drug_code");
			bean_1.setApprovalNo(order_id,order_line_no,approval_no);
  		putObjectInBean(bean_id_1,bean_1,request);
 		}//added for IN070605 end
 		else if(func_mode!= null && func_mode.equals("release")) {
			//Called for Releasing 
			String reason					= (String) hash.get( "reason" );
			String remarks					= java.net.URLDecoder.decode( (String) hash.get( "remarks" ),"UTF-8");
			String recno					= (String) hash.get( "recno" );
			String order_line_no			= (String) hash.get( "order_line_no" );
			String order_id					= (String) hash.get( "order_id" );
			beanObj.clearRemarks(recno);
			beanObj.clearHold(order_id,order_line_no);
			beanObj.setRemarks(reason,remarks,recno);
			out.println("callClose('RELEASE')");
		}
 		else if(func_mode!= null && func_mode.equals("filling")) {  // added by senthilkumar on 17/4/2004
			String reason					= (String) hash.get( "reason" );
			String remarks					= (String) hash.get( "remarks" );
			String recno					= (String) hash.get( "recno" );
			String order_line_no			= (String) hash.get( "order_line_no" );
			String order_id					= (String) hash.get( "order_id" );
			//String drug_code				= (String) hash.get( "drug_code" );
			String chk						= ((String) hash.get( "chk" )).trim();
			if(remarks!=null && !remarks.equals("")){
				remarks = java.net.URLDecoder.decode(remarks,"UTF-8");
			}
			if(chk.equals("F")){
				beanObj.clearFillRemarks(order_id+"_"+order_line_no);
				beanObj.setFillingRemarks(reason,remarks,order_id+"_"+order_line_no);
			}
			if(chk.equals("D")){
				beanObj.clearDeliveryFillRemarks(order_id+"_"+order_line_no);
				beanObj.setDeliveryFillingRemarks(reason,remarks,order_id+"_"+order_line_no);
			}
			else if(chk.equals("A")){
				beanObj.clearAllocateFillRemarks(recno);
				beanObj.setAllocateFillingRemarks(reason,remarks,order_id+"_"+order_line_no);
			}
		}

		else if(func_mode!= null && func_mode.equals("cancelFilling")) {  
			
			String reason					= "";
			String remarks					= "";
			String recno					= (String) hash.get( "recno" );
			String order_line_no			= (String) hash.get( "order_line_no" );
			String order_id					= (String) hash.get( "order_id" );
			String chk						= ((String) hash.get( "chk" )).trim();

			if(chk.equals("F")){
				beanObj.clearFillRemarks(recno);
				beanObj.setFillingRemarks(reason,remarks,order_id+"_"+order_line_no);
			}
			else if(chk.equals("D")){
				beanObj.clearDeliveryFillRemarks(recno);
				beanObj.setDeliveryFillingRemarks(reason,remarks,order_id+"_"+order_line_no);
			}
			else if(chk.equals("A")){
				beanObj.clearAllocateFillRemarks(recno);
				beanObj.setAllocateFillingRemarks(reason,remarks,order_id+"_"+order_line_no);
			}
		}

		else if(func_mode!= null && func_mode.equals("userPINAuthValidation")) {   // RUT-CRF-0035 [IN029926] PIN Authentication --begin
			String call_from			= (String) hash.get( "call_from" );
			String user_name			= (String) hash.get( "user_name" );
			String user_id				= (String) hash.get( "user_id" );
			String PIN					= (String) hash.get( "PIN" );	
			String disp_locn_code		= (String) hash.get( "disp_locn_code" );	
			String disp_category		= (String) hash.get( "disp_category" );	
			String witness				= (String) hash.get( "witness" )==null?"":(String) hash.get( "witness" );// Added for AAKH-CRF-0023[IN:038259]//null handled for jd-crf-0200
			String patient_id			= (String) hash.get( "patient_id" );// Added for AAKH-CRF-0023[IN:038259]
			String encounter_id			= (String) hash.get( "encounter_id" );// Added for AAKH-CRF-0023[IN:038259]
			PIN  =java.net.URLDecoder.decode(PIN,"UTF-8");
			String result=beanObj.validateUserAuthPIN(user_id,PIN,call_from,disp_locn_code,disp_category);
			if("1".equals(result)){
				result=user_id;
				if(call_from.equals("MAR") && witness.equals("Y")){// Added for AAKH-CRF-0023[IN:038259] start
					String pres_bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
					String pres_bean_name			= "ePH.PrescriptionBean_1";
					PrescriptionBean_1 presbean		= (PrescriptionBean_1)getBeanObject( pres_bean_id, pres_bean_name, request );
					presbean.setWitnessByUser(user_id);
					putObjectInBean(pres_bean_id,presbean,request);
				}// Added for AAKH-CRF-0023[IN:038259] end
				if("A".equals(call_from) || "F".equals(call_from)|| "D".equals(call_from)|| "AS".equals(call_from)|| "IPF".equals(call_from)|| "IPFA".equals(call_from) || "V".equals(call_from)){
					beanObj.setAuthUserID(user_id);
				}
			}
			out.println(result);
		}
		else if (func_mode !=null && func_mode.equals("setAmendDetails")){
			DispMedicationAllStages beanObject =null;
			String code = ((String)hash.get("reason")).trim();
			String bean_id_remarks	 = (String)hash.get("bean_id");
			String bean_name_remarks = (String)hash.get("bean_name");
			String frmObj			 = (String)hash.get("frmObj");
			String appl_trn_type	 = ((String)hash.get("appl_trn_type")).trim();
			if (!bean_name.equals(""))
			 beanObject		= (DispMedicationAllStages)getBeanObject(bean_id_remarks, bean_name_remarks,request);	
			beanObject.setLanguageId(locale);
			String remarks = beanObject.checkForNull(beanObject.getRemarks(code,appl_trn_type));	
			remarks=remarks.replaceAll(" ","%20");//added for SKR-SCF-0208 -IN029298 -start
			remarks = java.net.URLEncoder.encode(remarks,"UTF-8" );
			remarks=remarks.replaceAll("%2520","%20"); //added for SKR-SCF-0208 -IN029298 -End
			out.println("document."+frmObj+".remarks.value=(decodeURIComponent('"+remarks+"'))");
			putObjectInBean(bean_id_remarks,beanObject,request);
		}
		else if(func_mode!= null && func_mode.equals("amendReason")) {  // added for Amend Prescription...on 5/2/2004
			String reason					= (String) hash.get( "reason" );
			String remarks					= (String) hash.get( "remarks" );
			String order_line_no			= (String) hash.get( "order_line_no" );
			String order_id					= (String) hash.get( "order_id" );
			//String drug_code				= (String) hash.get( "drug_code" );
			String patient_id				= (String) hash.get( "patient_id" );
			String encounter_id				= (String) hash.get( "encounter_id" );
			String chk						= ((String) hash.get( "chk" )).trim();

			String bean_id_2				= "@PrescriptionBean_1"+patient_id+encounter_id;
			String bean_name_2				= "ePH.PrescriptionBean_1";

			PrescriptionBean_1 bean_A		= (PrescriptionBean_1)getBeanObject( bean_id_2, bean_name_2, request );
			bean_A.setLanguageId(locale);
			
			ArrayList reason_val	= new ArrayList();
			reason_val.add(order_id);
			reason_val.add(reason);
			reason_val.add(remarks);
			
			if(chk.equals("O")){
				bean_A.clearAmendReason(order_id);
				bean_A.setAmendReason(order_id,reason_val);	
				bean_A.setAmendReasonTemp(order_id,reason_val);/* code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/	
				String bean_id_1		= "@IVPrescriptionBean"+patient_id+encounter_id;
				String bean_name_1		= "ePH.IVPrescriptionBean";			
				IVPrescriptionBean bean_1	= (IVPrescriptionBean)getBeanObject(bean_id_1,bean_name_1,request);
				bean_1.setAmendReasonTemp(order_id,reason_val);//IN066779
				bean_1.setLanguageId(locale);
				bean_1.setObject(bean_A);
				putObjectInBean(bean_id_1,bean_1,request);	
					
				String bean_id_3			= "@OncologyRegimenBean"+patient_id+encounter_id;
				String bean_name_3		= "ePH.OncologyRegimenBean";
				OncologyRegimenBean bean_3= (OncologyRegimenBean)getBeanObject( bean_id_3, bean_name_3, request ) ;		
				bean_3.setLanguageId(locale);
				bean_3.setObject(bean_A);
				putObjectInBean(bean_id_3,bean_3,request);	/* code Added for ML-BRU-SCF-0098 [IN031837] -- End*/	
				String	bean_id_4					=	"DispMedicationBean" ;/* code Added for ML-BRU-SCF-0190[32621] -- Start*/	
				String	bean_name_4					=	"ePH.DispMedicationBean";
				DispMedicationBean bean_4		= (DispMedicationBean)getBeanObject( bean_id_4, bean_name_4, request);
				bean_4.setLanguageId(locale);
				String disp_locn_catg	=	bean_4.getDispLocnCatg();
				bean_A.setDispLocnCatg(disp_locn_catg);
				bean_A.setOrderLineNumber(order_line_no);/* code Added for ML-BRU-SCF-0190[32621] -- End*/
			}
			putObjectInBean(bean_id_2,bean_A,request);	
		}
		else if(func_mode!= null && func_mode.equals("cancelAmendReason")) {  
			//String reason					= (String) hash.get( "reason" );
			//String remarks					= (String) hash.get( "remarks" );
			String order_line_no			= (String) hash.get( "order_line_no" );
			String order_id					= (String) hash.get( "order_id" );
			//String drug_code				= (String) hash.get( "drug_code" );
			String patient_id				= (String) hash.get( "patient_id" );
			String encounter_id				= (String) hash.get( "encounter_id" );
			String chk						= ((String) hash.get( "chk" )).trim();
			String bean_id_2				= "@PrescriptionBean_1"+patient_id+encounter_id;
			String bean_name_2				= "ePH.PrescriptionBean_1";
			PrescriptionBean_1 bean_A		= (PrescriptionBean_1)getBeanObject( bean_id_2, bean_name_2,request );
			bean_A.setLanguageId(locale);
			ArrayList reason_val	= new ArrayList();
			reason_val.add("");
			reason_val.add("");
			reason_val.add("");
			if(chk.equals("O"))	{
				bean_A.clearAmendReason(order_id);
				bean_A.setAmendReason(order_id,reason_val);
			}
			putObjectInBean(bean_id_2,bean_A,request);
		}

		else if(func_mode!= null && func_mode.equals("setlabelLangId")){ //added for Bru-HIMS-CRF-414 [IN:045554]
			String labelLangId = beanObj.checkForNull((String)hash.get( "labelLangId"),"en");
			String	bean_id_1			=	"DispMedicationBean" ;
			String	bean_name_1			=	"ePH.DispMedicationBean";
			DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
			bean_1.SetEditableLabelLangId(labelLangId);
			putObjectInBean(bean_id_1,bean_1,request);
		}
		else if (func_mode !=null && func_mode.equals("storage_locn1")){
			DispMedicationAllStages beanObject =null;
			String disp_locn_code			= hash.get("disp_locn_code") == null?"":((String)hash.get("disp_locn_code")).trim();
			String str_locn			= hash.get("str_locn") == null?"":((String)hash.get("str_locn")).trim();
			String curr_stage		= hash.get("curr_stage") == null?"":((String)hash.get("curr_stage")).trim();
			String token_series		= hash.get("token_series") == null?"":((String)hash.get("token_series")).trim();  
			String patient_arvd		= hash.get("patient_arvd") == null?"":((String)hash.get("patient_arvd")).trim();  
			String patient_id		= hash.get("patient_id") == null?"":((String)hash.get("patient_id")).trim();
            String Orderresult_id	= hash.get("Orderresult_id") == null?"":((String)hash.get("Orderresult_id")).trim();
            String encounter_id		= hash.get("encounter_id") == null?"":((String)hash.get("encounter_id")).trim();//Added for TH-KW-CRF-0020.9
			String delivery_bin_yn		= hash.get("delivery_bin_yn") == null?"":((String)hash.get("delivery_bin_yn")).trim();//Added for TH-KW-CRF-0020.9
			String token_no ="";
			ArrayList arrTokenList = new ArrayList();//Added for HSA-CRF-0136 [IN:048412]
			if(str_locn == null) 
				str_locn = "";

			bean_id	  = (String)hash.get("bean_id");
			bean_name  = (String)hash.get("bean_name");		
			String bean_id_1	  = (String)hash.get("bean_id_1");
			String bean_name_1  = (String)hash.get("bean_name_1");		
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1, request);
			token_no	= beanObj_1.getTokenNo();
			if(token_series.equals("*A"))//Added for HSA-SCF-0081 [IN:050227]
				token_series="";
			if((token_no!=null || !token_no.equals("")) && !token_series.equals("") )//Condition && !token_series.equals("") added for HSA-CRF-0136 [IN:048412]
				beanObject.setTokenVals(Orderresult_id,token_series+"_"+token_no);//Moved here for HSA-CRF-0136 [IN:048412]
			if(token_no==null || token_no.equals("") || token_series.equals("")){//Condition || token_series.equals("") added for HSA-CRF-0136 [IN:048412]
				arrTokenList	=	beanObj_1.getTokenDetails(disp_locn_code,patient_id,token_series,Orderresult_id);//Changed as ArrayList for HSA-CRF-0136 [IN:048412]
				if(arrTokenList!=null && arrTokenList.size()>0){//Added for HSA-CRF-0136 [IN:048412] start
					beanObject.setTokenVals(Orderresult_id, (String)arrTokenList.get(0)+"_"+(String)arrTokenList.get(1));
					token_series = (String)arrTokenList.get(0);
				}//Added for HSA-CRF-0136 [IN:048412] end
			}
			beanObject		= (DispMedicationAllStages)getBeanObject(bean_id, bean_name, request);	
			//beanObject.setTokenVals(Orderresult_id,token_no); //commented for for HSA-CRF-0136 [IN:048412] 
			beanObject.setStorageLocn(patient_id,disp_locn_code,str_locn,curr_stage,token_series,patient_arvd,delivery_bin_yn,encounter_id);	
			putObjectInBean(bean_id,beanObject,request);
			putObjectInBean(bean_id_1,beanObj_1,request);
		}//added for Bru-HIMS-CRF-142 [IN:030195] - End
		else if(func_mode!= null && func_mode.equals("storeAlloc")) {//Added for KDAH-CRF-0231 [IN-034551] - Start
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject("DispMedicationBean", "ePH.DispMedicationBean", request);
			String patient_id	 = (String)hash.get("patient_id");
			String alloc_tot_qty	 = (String)hash.get("alloc_tot_qty");//Added for KDAH-CRF-0231 [IN-034551]
			String bms_tot_qty	 = (String)hash.get("bms_tot_qty");//Added for KDAH-CRF-0231 [IN-034551]
			ArrayList temp_alloc_drug_detail=null;
			ArrayList batch_list1=new ArrayList();
			String order_id="";
			String order_line_no="";
			double quantity=1.0;
			String batch_id="";
			String item_drug_code="", item_cost, qty_uom, expiry_date, trade_id, trade_name, bin_locn_code, temp_batch;
			ArrayList batch_list =null;
			HashMap batch_map = null;
			HashMap temp_batch_map = null;
			String[] batch_str = null;
			if(!beanObj_1.getStockDtl().containsKey("autoalloc")){
				Iterator batch_val=beanObj_1.getBatch_val().iterator();
				while(batch_val.hasNext()){
					batch_list=(ArrayList)batch_val.next();
					batch_map=(HashMap)batch_list.get(0);
					item_cost="";
					qty_uom="";
					item_drug_code		=	(String)batch_map.get("ITEM_CODE");	
					expiry_date			=	(String)batch_map.get("EXPIRY_DATE");	
					batch_id			=	(String)batch_map.get("BATCH_ID");	
					trade_id			=	(String)batch_map.get("TRADE_ID");	
					trade_name			=	(String)batch_map.get("TRADE_NAME");	
					bin_locn_code		=	(String)batch_map.get("BIN_LOCATION_CODE");
					 
					temp_batch_map=beanObj_1.getTempStockDtls();
					if(temp_batch_map.containsKey(item_drug_code+"~"+batch_id)){
						
						 if(!beanObj_1.getStockDtl().containsKey("allocated"+item_drug_code+batch_id)){//Added for KDAH-CRF-0231 [IN-034551]. -start
							batch_list1.add(batch_list);
						}
						beanObj_1.setStockDtlKey("barcode_applicable"+item_drug_code,"N");//Added for KDAH-CRF-0231 [IN-034551]. -end
						
						temp_batch=temp_batch_map.get(item_drug_code+"~"+batch_id).toString();
						batch_str=temp_batch.split("~");
						order_id=batch_str[0];
						order_line_no=batch_str[1];
						if(beanObj_1.getStockDtl().containsKey(item_drug_code+"qty")){
							quantity=Double.parseDouble(beanObj_1.getStockDtl().get(item_drug_code+"qty").toString());//Added for KDAH-CRF-0231 [IN-034551]
						}
						else{
							quantity=Double.parseDouble(batch_str[2].toString());
						}
						item_cost=batch_str[3];
						qty_uom=batch_str[4];
						temp_alloc_drug_detail=new ArrayList();
						temp_alloc_drug_detail.add(item_drug_code);
						temp_alloc_drug_detail.add(batch_id);
						temp_alloc_drug_detail.add(expiry_date);
						temp_alloc_drug_detail.add((int)(quantity)+"");
						temp_alloc_drug_detail.add(qty_uom);
						temp_alloc_drug_detail.add("");
						temp_alloc_drug_detail.add(trade_id);
						temp_alloc_drug_detail.add(bin_locn_code);
						temp_alloc_drug_detail.add(item_cost);
						temp_alloc_drug_detail.add(batch_str[5]);//qty_uom is changed as batch_str[5] for [IN:049778]
					 }
					 beanObj_1.getStockDtl().remove("batchqty"+item_drug_code+batch_id);//Added for KDAH-CRF-0231 [IN-034551]
				}//Added for KDAH-CRF-0231 [IN-034551].
				beanObj.setDrugDetail(patient_id,order_id,order_line_no,temp_alloc_drug_detail);
				beanObj.setDrugQuantity(patient_id,order_id,order_line_no,quantity);
				if(!(beanObj_1.getStockDtl().containsKey("allocated"+item_drug_code+batch_id) && beanObj_1.getStockDtl().get("allocated"+item_drug_code+batch_id).equals(item_drug_code))){
					Iterator batch_val1=batch_list1.iterator();
					while (batch_val1.hasNext()){
						ArrayList batch_temp=(ArrayList)batch_val1.next();							  
						if(beanObj_1.getBatch_val().contains(batch_temp)){
							beanObj_1.getBatch_val().remove(batch_temp);
						}
					}
				}  
				//Added for KDAH-CRF-0231 [IN-034551].
				beanObj_1.getBatch_val().clear();//Added for KDAH-CRF-0231 [IN-034551]
			}
			else{
				beanObj_1.getStockDtl().remove("autoalloc");
			}
		}
		putObjectInBean(bean_id,beanObj,request);
	
	
%>  

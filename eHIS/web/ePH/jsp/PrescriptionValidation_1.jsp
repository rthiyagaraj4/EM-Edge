
<%@page  import="java.sql.*,java.text.DecimalFormat, java.util.*, java.io.*, ePH.Common.*, eOR.Common.*, ePH.*, eOR.*, com.ehis.util.* "  contentType="text/html;charset=UTF-8" %>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
/* 

--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
26/07/2019      IN070451		    B Haribabu  26/07/2019       Manickam               ML-MMOH-CRF-1408
10/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
25/11/2019  IN071763			Shazana		25/11/2017				NMC-JD-SCF-0030
23/12/2019	IN071727	Shazana												SKR-SCF-1293
23/12/2019	IN071728	Shazana												SKR-SCF-1294
28/2/2020		IN072421			Shazana													TBMC-SCF-0163	
28/07/2020      IN:073485                   Haribabu                                PH-MMS-DM-CRF-0165/01-Normal rx-Amend order		
19/10/2020	IN072263	Manickavasagam	 PMG2020-ICN-001
20/10/2020      IN:069886         Haribabu                       Manickam            MO-CRF-20151	
29/10/2020  IN074259 			   Prabha     29/10/2020         Manickam            AAKH-SCF-0460
10/11/2020	6041			Shazana       										NMC-JD-CRF-0063
23/12/2020	11525					Shazana												NMC-JD-CRF-0063
16/04/2021  	TFS id:-16341    Haribabu	 16/04/2021	 	 Manickavasagam J          NMC-JD-CRF-0097
13/05/2021  	TFS id:-16701	     Manickavasagam J                                    RBU-GHL-CRF-0004
23/05/2023   43528                SREENADH.M                   Suhail                  ML-MMOH-CRF-1823
--------------------------------------------------------------------------------------------------------------
*/
%>
<%
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
		if(func_mode!= null && func_mode.equals("validateDateTime1")){
			String system_date	= (String) hash.get("system_date")==null?"":(String) hash.get("system_date");
			String end_date	= (String) hash.get("end_date")==null?"":(String) hash.get("end_date");
			String discharge_ind	= (String) hash.get("discharge_ind")==null?"":(String) hash.get("discharge_ind");//Added for BRU-HIMS-CRF-403
			//if((bean.getCopyPrevOrderForDishargeMedn()==null || !bean.getCopyPrevOrderForDishargeMedn().equalsIgnoreCase("Y")) && discharge_ind.equalsIgnoreCase("Y")){//Added IF for BRU-HIMS-CRF-403 [IN:049402] //commented for ML-BRU-SCF-1349 [IN:049402]
			if(!(bean.getCopyPrevOrderForDishargeMedn()!=null && bean.getCopyPrevOrderForDishargeMedn().equalsIgnoreCase("Y") && discharge_ind.equalsIgnoreCase("Y"))){//condition changed for ML-BRU-SCF-1349 [IN:049402]
				if(presBean.compareDates(system_date,end_date)){
					out.println("confirm(getMessage('MEDICATIONS_ACTIVE','PH'))");
					//	out.println("var answer = confirm('APP-PH255 One or more medications selected are active. Press OK to repeat as current order or Press Cancel to repeat as future order.')");
				}
				else
					out.println("false");
				return;
			}
		}
		else if(func_mode!=null && func_mode.equals("onChangeUOM")){  //added for SKR-SCF-0309.1  [IN030625] -- begin
			String qty_desc_code	= (String)hash.get("qty_desc_code");
			String drug_code		= (String)hash.get("drug_code");
			String srlNo			= (String)hash.get("srlNo");
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap ext_drugData=null;
			String ext_drug_code,ext_srl_no="";
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
				  ext_drugData				=(HashMap) prescriptionDetails.get(j);
				  ext_drug_code				=(String) ext_drugData.get("DRUG_CODE");
				  ext_srl_no				=(String) ext_drugData.get("SRL_NO");
				  	if( drug_code.equals(ext_drug_code) && (String.valueOf(srlNo)).equals(ext_srl_no) ){
					//if( drug_code.equals(ext_drug_code)){
						ext_drugData.put("QTY_DESC_CODE",qty_desc_code);
						break;
					 }
				}
			}
		}  // SKR-SCF-0309.1  [IN030625] -- end 
		else if(func_mode != null && func_mode.equals("curr_medn_drugs")){
			String answer =(String) hash.get("answer")==null?"":(String) hash.get("answer");
			String curr_date_order_id =(String) hash.get("curr_date_order_id")==null?"":(String) hash.get("curr_date_order_id");
			String curr_date_order_line_num =(String) hash.get("curr_date_order_line_num")==null?"":(String) hash.get("curr_date_order_line_num");
			ArrayList curr_date_drugs =bean.getCurrMednDrugs();
			if(curr_date_drugs ==null) //if bloack added for SKR-SCF-0406 [IN:031208]
				curr_date_drugs = new ArrayList();
			if(answer.equals("true"))
				curr_date_drugs.add(curr_date_order_id+"$"+curr_date_order_line_num);
			else if(answer.equals("false"))
				curr_date_drugs.remove(curr_date_order_id+"$"+curr_date_order_line_num);
			bean.setCurrMednDrugs(curr_date_drugs);
		}
		else if(func_mode != null && func_mode.equals("validateBSA")){
			String height=(String) hash.get("height");
			String weight=(String) hash.get("weight");
			float bsa= (float) presBean.loadBSA(height,weight);
			boolean site = presBean.isSiteSpecific("OR", "OR_ORDER_SET"); // added for ML-MMOH-CRF-1004 -Start
			 String bsaTwoDcml = "";
			if(site){ 
			 bsaTwoDcml = String.format("%.2f", bsa);	
		    } // if condition added for ML-MMOH-CRF-1004 - End
			float bmi=Float.parseFloat(weight)/((Float.parseFloat(height)/100)*(Float.parseFloat(height)/100));
			if(site){ // if condition added for ML-MMOH-CRF-1004 -Start
				out.println("assignBSA(\"" + bsaTwoDcml + "\",\""+bmi+"\");") ;
			} // if condition added for ML-MMOH-CRF-1004 - end
			else{
			   out.println("assignBSA(\"" + bsa + "\",\""+bmi+"\");") ;
			}
		}
		else if(func_mode != null && func_mode.equals("getDrugClass")){
			String order_type=(String) hash.get("order_type");
			String drug_class=(String) bean.getDrugClass(order_type);
			out.println("assignDrugClass(\"" + drug_class + "\");") ;
		}
		else if(func_mode != null && func_mode.equals("loadDrugDetails")){
			String patient_id=(String)hash.get( "patient_id" );
			String encounter_id=(String)hash.get( "encounter_id" );
			String patient_class	= (String) hash.get("patient_class");
			String facility_id		= (String) hash.get("facility_id");
			String sys_date			= (String) hash.get("sys_date");
			String priority			= (String) hash.get("priority");
			String take_home_medication		= (String) hash.get("take_home_medication");
			String locn_type		= "";
			String order_set_code =	(String) hash.get("order_set_code")==null? "" : (String) hash.get("order_set_code");
			String drug_db_interface_yn= (String)hash.get("drug_db_interface_yn")==null?"":(String)hash.get("drug_db_interface_yn");
			String act_patient_class= (String)hash.get("act_patient_class")==null?"":(String)hash.get("act_patient_class");
			String pract_id = (String)hash.get("pract_id")==null?"":(String)hash.get("pract_id");
			String resp_id = (String)hash.get("resp_id")==null?"":(String)hash.get("resp_id");
			String home_leave_yn_val = (String)hash.get("home_leave_yn_val")==null?"":(String)hash.get("home_leave_yn_val");//added for Bru-HIMS-CRF-093[29960]
			String pract_type = (String)hash.get("pract_type")==null?"":(String)hash.get("pract_type"); //added for ML-BRU-SCF-0958 [IN:042045]
			//Added for IN:070451 start
			String weight	= (String) hash.get("weight");
			String bsa		= (String) hash.get("bsa");	
			if(weight!=null && bsa!=null){
				bean.setWeight(weight);
				bean.setBsa(bsa);
			}
			//Added for IN:070451 end
			// added for ghl-crf-0509 start
						String drug_search_bean_id				= "DrugSearchBean";
						String drug_search_bean_name			= "ePH.DrugSearchBean";
						DrugSearchBean drug_bean				= (DrugSearchBean)getBeanObject( drug_search_bean_id, drug_search_bean_name , request);
						//added for ghl-crf-0509 end
					if( bean.getExternalpatient_id()==null  ||((String)bean.getExternalpatient_id()).equals(""))
				locn_type		= (String) hash.get("locn_type");
			else
				locn_type		= "P";
			String locn_code		= (String) hash.get("locn_code");
			String or_bean_name				= "eOR.OrderEntryBean";
			String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
			OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
			eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
			String key	= (orbean.getPatientId()+orbean.getEncounterId());// Unique key to keep the Value in the Bean
			java.util.HashMap previousValues= (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);
			String order_catalog_code 		= orbean.getOrderCatalogCode(previousValues,"PH", pract_type); // pract_type added for ML-BRU-SCF-0958 [IN:042045]
			if(order_catalog_code == null) 
				order_catalog_code="";
			ArrayList ordeCatalogCode = new ArrayList();
			if(order_catalog_code != null && !order_catalog_code.equals("")){
				StringTokenizer token = new StringTokenizer(order_catalog_code, ",");
				StringTokenizer catalogdetail;
				String temp="";
				while(token.hasMoreTokens()){
					temp = token.nextToken();
					if(temp.indexOf("#")!= -1){
						catalogdetail = new StringTokenizer(temp, "#");
						while(catalogdetail.hasMoreTokens()){
							ordeCatalogCode.add(catalogdetail.nextToken());
						}
					}
					else{
						String temp_key ="h2"+temp;
						if(!(previousValues.get(temp_key).equals("MS"))){ //Condition added for IN20339 to prevent display of MS --31/03/2010-- priya
							ordeCatalogCode.add(temp);
							ordeCatalogCode.add("1");
							ordeCatalogCode.add("PH");
						}
					}
				}
			}
			//Added to test duplication of a drug from OrderSet this code should me removed ordeCatalogCode.add(ordeCatalogCode.get(ordeCatalogCode.size()-1));
			//ordeCatalogCode.add(ordeCatalogCode.get(ordeCatalogCode.size()-1));
			HashMap drugDetails		=	null;
			String  drugCode		=	"";
			int srlNo				=    0;
			boolean allow_add		=	true;
			ArrayList presDetails	=	null;
			HashMap drugCodeDetails	=	null;
			String order_set_occur_num		=	"";
			String order_type		=	"";
			//moved date conversion from below to here for IN24946 --08/11/2010-- priya
			if(!locale.equals("en"))
				sys_date  = DateUtils.convertDate(sys_date, "DMYHM",locale,"en");
			if(ordeCatalogCode != null && ordeCatalogCode.size()>0)	{	
				for(int i=0;i<ordeCatalogCode.size();i+=3){
					drugDetails = new HashMap();
					drugCode	  = (String) ordeCatalogCode.get(i);
					order_set_occur_num = (String) ordeCatalogCode.get(i+1)==null?"":(String) ordeCatalogCode.get(i+1);
					order_type = (String) ordeCatalogCode.get(i+2)==null?"":(String) ordeCatalogCode.get(i+2);
					srlNo		= i+1;
					allow_add	= true;
					presDetails = (ArrayList) bean.getpresDetails();
					if(allow_add && !drugCode.equals("") && !order_type.equals("MS")){
bean.setCalled_from_verbal_order(drug_bean.getCalled_from_verbal_order());//added for GHL-CRF-0509
drugDetails=bean.loadDrugDetails(priority,take_home_medication,locn_type,locn_code,facility_id,drugCode,patient_class,patient_id,sys_date,(String.valueOf(srlNo)),order_set_code, order_set_occur_num,  drug_db_interface_yn, "","",act_patient_class, pract_id, resp_id,encounter_id,home_leave_yn_val);
						bean.addDrugDetails(999,drugDetails);
					}
				}
			}
			bean.setSrlNo(srlNo);
			putObjectInBean(or_bean_id,orbean,request);
		}
		else if(func_mode != null && func_mode.equals("saveRemarks")){
			String remarks	= (String) hash.get( "remarks" );
			if(remarks!=null && !remarks.equals("")) //Added if block for  RUT-SCF-0079, RUT-SCF-0080
				remarks = java.net.URLDecoder.decode(remarks,"UTF-8");
			bean.savePresRemarks(remarks);
		}
		else if(func_mode != null && func_mode.equals("populateFrequency")){
			String freq_code	= (String) hash.get( "freq_code" )==null?"":(String) hash.get( "freq_code" );
			String call_mode	= (String) hash.get( "call_mode" );
			String pat_class	= (String) hash.get( "pat_class" );
			String drug_code	= (String) hash.get( "drug_code" );	
			String freqCode		=	"";
			String freqDesc		=	"";
			ArrayList FreqCode	=	null;
			ArrayList FreqDesc	=	null;
			HashMap freqValues =(HashMap)bean.populateFrequencyValues(drug_code,freq_code,call_mode,pat_class);
			if( !freq_code.equals("")){
				if(freqValues.size()>0){
					FreqCode=(ArrayList) freqValues.get("FreqCode");
					FreqDesc=(ArrayList) freqValues.get("FreqDesc");
					out.println("clearFrequencyList()");
					for(int i=0;i<FreqCode.size();i++){
						freqCode=(String) FreqCode.get(i);
						freqDesc=(String) FreqDesc.get(i);
						out.println("addFrequencyList('"+freqCode+"','"+freqDesc+"','"+freq_code.trim()+"')");
					}
					out.println("dfltFreq('"+freq_code.trim()+"','N')");
				}
			}
		}
		else if(func_mode!= null && func_mode.equals("populateQtyDesc")){
			String form_code			= (String) hash.get("form_code");
			String pres_base_uom		= (String) hash.get("pres_base_uom")==null?"":(String) hash.get("pres_base_uom");
			String pres_base_uom_desc	= (String) hash.get("pres_base_uom_desc")==null?"":(String) hash.get("pres_base_uom_desc");
			String rx_qty_by_pres_base_uom_yn		= (String) hash.get("rx_qty_by_pres_base_uom_yn")==null?"N":(String) hash.get("rx_qty_by_pres_base_uom_yn");
			ArrayList QtyDescDetails	= (ArrayList)presBean.loadQtyDetails(form_code);
			String	uom_code	= "", uom_desc="", dflt_yn="";
			boolean deft_set = false;
			out.println("clearQtyDescList()");
			if(!rx_qty_by_pres_base_uom_yn.equals("Y")){
				for(int i=0; i<QtyDescDetails.size(); i+=3)	{
					uom_code	= (String)QtyDescDetails.get(i);
					uom_desc	= (String)QtyDescDetails.get(i+1);
					if(((String)QtyDescDetails.get(i+2)).equals("Y"))
						dflt_yn		= (String)QtyDescDetails.get(i+2);
					out.println("addQtyDescList('"+uom_code+"','"+uom_desc+"')");
					if((!pres_base_uom.equals("")) && pres_base_uom.equals(uom_code)){
						out.println("setdfltQtyUom('"+pres_base_uom+"')");
						deft_set = true;
					}				
				}
				if(!deft_set){
					String fitst_code = "";
					for(int i=0; i<QtyDescDetails.size(); i+=3)	{
						uom_code	= (String)QtyDescDetails.get(i);
						if(fitst_code.equals("")){
							fitst_code = uom_code;
						}
						if(!dflt_yn.equals("")){
							if(((String)QtyDescDetails.get(i+2)).equals("Y")){
								out.println("setdfltQtyUom('"+uom_code+"')");
								break;
							}
						}
						else{
							out.println("setdfltQtyUom('"+fitst_code+"')");
							break;
						}
					}
				}
				if(QtyDescDetails == null || QtyDescDetails.size()==0){
					out.println("addQtyDescList('','   ----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label", "common_labels")+"---   ');");
				}
				else
					out.println("dfltQtyDesc()");
			}
			else{
				if(!pres_base_uom.equals("")){
					out.println("addQtyDescList('"+pres_base_uom+"','"+pres_base_uom_desc+"')");
					out.println("setdfltQtyUom('"+pres_base_uom+"')");
					out.println("dfltQtyDesc()");
				}
				else{
					out.println("addQtyDescList('','   ----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label", "common_labels")+"---   ');");
				}
			}
		}
		else if(func_mode != null && func_mode.equals("populateDurnDesc"))	{
			String repeat_durn_type		= (String) hash.get( "repeat_durn_type" );
			Hashtable DurnDescDetails	= (Hashtable)presBean.loadDurnDesc();//commented for performace ML-MMOH-SCF-00684

			Enumeration keys_des		= DurnDescDetails.keys();
			String	durn_code	= "";
			String	durn_desc	= "";
			boolean flag		= true;
			while(keys_des.hasMoreElements()){
					durn_code	= (String)keys_des.nextElement();
					durn_desc	= (String)DurnDescDetails.get(durn_code);				
					if(repeat_durn_type.equals("M")){
						if(durn_code.equals("M") || durn_code.equals("H") || durn_code.equals("D"))
							flag		= true;
						else
							flag		= false;
					}
					else if(repeat_durn_type.equals("H")){
						if(durn_code.equals("H") || durn_code.equals("D") || durn_code.equals("W"))
							flag		= true;
						else
							flag		= false;
					}
					else if(repeat_durn_type.equals("D")){
						if(durn_code.equals("D") || durn_code.equals("W") || durn_code.equals("L") || durn_code.equals("Y"))
							flag		= true;
						else
							flag		= false;
					}
					else if(repeat_durn_type.equals("W")){
						if(durn_code.equals("W") || durn_code.equals("L") || durn_code.equals("Y"))
							flag		= true;
						else
							flag		= false;
					}
					else if(repeat_durn_type.equals("L")){
						if(durn_code.equals("L") || durn_code.equals("Y"))
							flag		= true;
						else
							flag		= false;
					}
					if(flag){
						out.println("addDurnDescList(\""+durn_code+"\",\""+durn_desc+"\")");
					}
			}
			out.println("dfltDurnDesc('"+repeat_durn_type+"')");
		}
		else if(func_mode != null && func_mode.equals("populateDurationDesc")){
			String freq_code	= (String) hash.get( "freq_code" );
			String durn_desc= "", repeat_durn_type = "", freq_value	= "";
			String freq_nature			= "";
			String interval_value		= "";
			String repeat_value			= "";
			String schedule_yn			= "";
			HashMap freqNature			=(HashMap)presBean.freqValidate(freq_code);
			if(freqNature.size()>0){
				freq_nature		= (String)freqNature.get("freq_nature");
				freq_value		= (String)freqNature.get("freq_value");
				interval_value	= (String)freqNature.get("interval_value");
				repeat_value	= (String)freqNature.get("repeat_value");
				schedule_yn		= (String)freqNature.get("schedule_yn");
				repeat_durn_type= (String)freqNature.get("repeat_durn_type");
			}
			if(freq_nature != null && !freq_nature.equals("O")){
				out.println("assignDurnDesc(\""+repeat_value+"\",\""+repeat_durn_type+"\",\""+freq_nature+"\",\""+interval_value+"\",\""+durn_desc+"\",\""+freq_value+"\",\""+schedule_yn+"\")");
				out.println("dfltDurnDesc(\""+repeat_durn_type+"\")");			
			}
			else{
				durn_desc	="";
				freq_value	="";			
				out.println("assignDurnDesc(\""+repeat_value+"\",\""+repeat_durn_type+"\",\""+freq_nature+"\",\""+interval_value+"\",\""+durn_desc+"\",\""+freq_value+"\",\""+schedule_yn+"\")");
			}
		}
		else if(func_mode != null && func_mode.equals("populateEndDate")){
			String freq_nature			= (String) hash.get( "freq_nature" );
			String start_date			= (String) hash.get( "start_date" );
			String durn_value			= (String) hash.get( "durn_value" );
			String repeat_durn_type		= (String) hash.get( "repeat_durn_type" );
			String drugCode	= (String)hash.get( "drug_code");
			String def_freq_found	= (String)hash.get( "def_freq_found");
			String srlNo	= (String)hash.get( "srlNo");
			String absol_qty = (String) hash.get( "absol_qty" );
			String callFrom = hash.get( "callFrom")==null?"":(String) hash.get( "callFrom"); // added for MO-GN-5490 [IN:054620] - [IN:055921]
			String tmp_start_date = start_date; //added for  SKR-SCF-0547 [IN:033160]
			String ext_prod_id ="";
			if(!locale.equals("en")); 
				tmp_start_date  = DateUtils.convertDate(start_date, "DMYHM",locale,"en");
			String end_date=(String)bean.populateEndDate(freq_nature,tmp_start_date,durn_value,repeat_durn_type); //start_date changed to tmp_start_date for  SKR-SCF-0547 [IN:033160]
			boolean dupCheck = false;
			//if(!locale.equals("en")); 
			end_date  = DateUtils.convertDate(end_date, "DMYHM","en",locale);
			//if(def_freq_found.equals("false")){  //Commented for IN25752 --06/01/2011-- priya
			String ext_drug_code	= "";
			String ext_srl_no			=	"";
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap Drug_Details =null;
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
					Drug_Details=(HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) Drug_Details.get("DRUG_CODE");
					ext_srl_no=(String) Drug_Details.get("SRL_NO");
					if( drugCode.equals(ext_drug_code) && (String.valueOf(srlNo)).equals(ext_srl_no) ){
						Drug_Details.put("START_DATE", start_date); //added for SKR-SCF-0707 [IN36128]
						Drug_Details.put("END_DATE", end_date); // Uncommented for IN25225 --29/11/2010-- priya
						Drug_Details.put("DURN_VALUE", durn_value); //added for IN26267 --02/02/2011-- priya
						Drug_Details.put("ABSOL_QTY", absol_qty); //added for IN26267 --02/02/2011-- priya
						break;
					}
				}
			}
			//}
			out.println("assignEndDate('"+end_date+"','"+callFrom+"')"); // callFrom added for MO-GN-5490 [IN:054620] - [IN:055921]
		}
		else if(func_mode != null && func_mode.equals("validateDosageLimit")){
			String daily_dose		= "";
			String unit_dose		= "";
			String limit_ind		= "";
			String mono_graph		= "";
			String min_daily_dose	= "";
			String min_unit_dose	= "";
			String dose_unit	= "";
			String dose_unit_desc = ""; // Added for ML-MMOH-SCF-0633 [IN:063271]
			String drug_code	= (String) hash.get( "drug_code" );
			String qty_value	= (String) hash.get( "qty_value" );
			String temp_qty	= (String) hash.get( "temp_qty" );//Added for ML-MMOH-SCF-0864
			String repeat_value	= (String) hash.get( "repeat_value" );
			String dosage_type  = (String) hash.get( "dosage_type" );
			String patient_id	= (String) hash.get( "patient_id" );
			String srl_no		= (String) hash.get( "srl_no" );
			//Added for IN:070451 start
			String weight		= (String) hash.get( "weight" );
			String height		= (String) hash.get( "height" );
			String absol_qty = (String) hash.get( "absol_qty" );//added for ml-mmoh-crf-1914
			//Added for IN:070451 end
			String freq_nature		= (String) hash.get("freq_nature")==null?"":(String) hash.get("freq_nature");
			String calc_def_dosage_yn		= (String) hash.get("calc_def_dosage_yn")==null?"":(String) hash.get("calc_def_dosage_yn");
			String ext_srl_no				= null;
			String ext_drug_code            = null;
			HashMap ext_drugData            = null;  
			ArrayList	schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
			ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
			//Added for IN:070451 start
			String max_daily_ceeling_dose	    =   "";
			String min_daily_ceeling_dose	    =   "";
			String max_unit_ceeling_dose	    =   "";
			String min_unit_ceeling_dose	    =   "";
			String dose_unit_desc1 = "";
			//Added for IN:070451 end
			boolean drugDosageLimitAppl = presBean.isSiteSpecific("PH", "PH_BEY_DOSE_PENCIL_ICON_PRN"); // added for ML-MMOH-CRF-1914
			if(!drugDosageLimitAppl && (freq_nature.equals("P") || freq_nature.equals("O"))&& prescriptionDetails!=null ){
				for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData				=(HashMap) prescriptionDetails.get(j);
					ext_drug_code				=(String) ext_drugData.get("DRUG_CODE");
					ext_srl_no				=(String) ext_drugData.get("SRL_NO");
					if( drug_code.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
						ext_drugData.put("LIMIT_IND","Y");
						ext_drugData.put("DOSE_REMARKS","");
						ext_drugData.put("DOSE_REMARKS_CODE","");//Added for IN:073485
						out.println("disableDosageLimit('"+srl_no+"','"+ext_drug_code+"')"); //parameter srl_no added for	SRR20056-SCF-7690 IN 27798 & 28440
						return;
					 }
				}
			}
			if(schedule.size() > 0){
				 ArrayList dose_list		= (ArrayList)schedule.get(4);
				 if(dose_list!=null && dose_list.size()>0)
					 qty_value		=	(String)dose_list.get(0);
				else
					 qty_value="1";
			}
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
				  ext_drugData				=(HashMap) prescriptionDetails.get(j);
				  ext_drug_code				=(String) ext_drugData.get("DRUG_CODE");
				  ext_srl_no				=(String) ext_drugData.get("SRL_NO");
					if( drug_code.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
						ext_drugData.put("LIMIT_IND",limit_ind);
						if(limit_ind.equals("Y")){
							ext_drugData.put("DOSE_REMARKS","");
							ext_drugData.put("DOSE_REMARKS_CODE","");//Added for IN:073485
						}
							
						break;
					 }
				}
			}
			if(calc_def_dosage_yn.equals("Y")){
			//Added for IN:070451 start
				presBean.setPresBean_1(bean);
				if(weight!=null && height!=null){
					float bsa= (float) presBean.loadBSA(height,weight);
					presBean.setWeight(weight);
					presBean.setBsa(bsa);
				}
				//Added for IN:070451 end
					if(drugDosageLimitAppl && freq_nature.equals("P") ){ //added for ml-mmoh-crf-1914
						repeat_value=absol_qty;
		}
		
				HashMap dosageDetails= (HashMap) presBean.chkMaxDosageLimit(drug_code,patient_id,temp_qty,dosage_type,repeat_value);//qty_value replaced temp_qty for ML-MMOH-SCF-0864
				limit_ind= (String) dosageDetails.get("LIMIT_IND");
				if(limit_ind != null && limit_ind.equals("N")){
					daily_dose = (String) dosageDetails.get("DAILY_DOSE");
					unit_dose = (String) dosageDetails.get("UNIT_DOSE");
					mono_graph = (String) dosageDetails.get("MONO_GRAPH");
					min_daily_dose= (String) dosageDetails.get("MIN_DAILY_DOSE");
					min_unit_dose= (String) dosageDetails.get("MIN_UNIT_DOSE");
					dose_unit= (String) dosageDetails.get("DOSAGE_UNIT");
					//Added for IN:070451 start
					max_daily_ceeling_dose = (String) dosageDetails.get("MAX_DAILY_CEELING_DOSE");
					min_daily_ceeling_dose = (String) dosageDetails.get("MIN_DAILY_CEELING_DOSE");
					max_unit_ceeling_dose = (String) dosageDetails.get("MAX_UNIT_CEELING_DOSE");
					min_unit_ceeling_dose = (String) dosageDetails.get("MIN_UNIT_CEELING_DOSE");
					//Added for IN:070451 end
					ext_drugData.put("LIMIT_IND",limit_ind);
					ext_drugData.put("DAILY_DOSE",daily_dose);
					ext_drugData.put("UNIT_DOSE", unit_dose);
					ext_drugData.put("MONO_GRAPH", mono_graph);
					ext_drugData.put("MIN_DAILY_DOSE", min_daily_dose);
					ext_drugData.put("MIN_UNIT_DOSE", min_unit_dose);
					ext_drugData.put("DOSAGE_UNIT",(String) dosageDetails.get("DOSAGE_UNIT"));
					mono_graph=mono_graph.replaceAll(" ","%20");
					mono_graph = java.net.URLEncoder.encode(mono_graph,"UTF-8");
					mono_graph=mono_graph.replaceAll("%2520","%20");
					//Added for IN:073485 start
					String overide_symbol="N";
					String override_remarks=((String) ext_drugData.get("DOSE_REMARKS"))==null?"":((String) ext_drugData.get("DOSE_REMARKS"));
					if(override_remarks.equals("")){
						overide_symbol="Y";
					}
					//Added for IN:073485 end 
					if(dose_unit!=null && dose_unit!=""){ // Added for ML-MMOH-SCF-0633 [IN:063271] - Start
						   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dose_unit); 
	 						if(dose_unit_desc==null || dose_unit_desc=="" ) {
	 						  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dose_unit.split("/")[0]));
	 						 dose_unit_desc1 = dose_unit_desc;//Added for IN:070451
						      dose_unit_desc =dose_unit_desc+"/"+(dose_unit.split("/")[1]);
	 						} 
						}// Added for ML-MMOH-SCF-0633 [IN:063271] - End
					out.println("enableDosageLimit('"+limit_ind+"','"+daily_dose+"','"+unit_dose+"','"+mono_graph+"','"+min_daily_dose+"','"+min_unit_dose+"','"+dose_unit+"','"+srl_no+"','"+dose_unit_desc+"','"+max_daily_ceeling_dose+"','"+min_daily_ceeling_dose+"','"+max_unit_ceeling_dose+"','"+min_unit_ceeling_dose+"','"+dose_unit_desc1+"','"+overide_symbol+"')"); //parameter srl_no added for	SRR20056-SCF-7690 IN 27798 & 28440  // dose_unit_desc added for ML-MMOH-SCF-0633,Modified  for IN:070451,Modified for IN:073485
				}
				else{
					out.println("disableDosageLimit('"+srl_no+"','"+drug_code+"')"); //parameter srl_no added for	SRR20056-SCF-7690 IN 27798 & 28440
				}
			}
		}
		else if(func_mode != null && func_mode.equals("populateRefillDates")){
			String end_date			= (String) hash.get( "end_date" );
			String durn_value		= (String) hash.get( "durn_value" );
			String repeat_durn_type	= (String) hash.get( "repeat_durn_type" );
			String refill_value		= (String) hash.get( "refill_no" );
			String srl_no			= (String) hash.get( "srl_no" );
			String frm				= hash.get( "frm" )==null?"":(String) hash.get( "frm" );
			if(!locale.equals("en"))
				end_date =  DateUtils.convertDate(end_date, "DMYHM",locale,"en");
			HashMap populateRefillDates=(HashMap) presBean.populateRefillDates(end_date,durn_value,repeat_durn_type,refill_value);
			String refill_st_date=(String) populateRefillDates.get("refill_st_date");
			String refill_en_date=(String) populateRefillDates.get("refill_en_date");
			HashMap	refill_detail	=	presBean.populateRefillDetail(end_date,durn_value,repeat_durn_type,refill_value);
			//bean.setRefillDetail(srl_no,refill_detail);// commented for IN:069886
			if(!frm.equals("DurationBlur"))
				out.println("assignRefillDates(\""+ refill_st_date + "\",\""+ refill_en_date + "\");");
		}
		else if(func_mode != null && func_mode.equals("diag_text")){
			String params	=	(String) hash.get( "params" );
			boolean entered	=	false;
			StringTokenizer	 vals	=	new StringTokenizer(params,"|");
			ArrayList diag_text		=	new ArrayList();
			String code		=	null;
			String desc		=	null;
			while(vals.hasMoreTokens()){
				entered			=	true;
				code		= (String)vals.nextToken();
				desc		= (String)vals.nextToken();
				diag_text.add(code);
				diag_text.add("");
				diag_text.add("");
				diag_text.add(desc);
			}
			if(diag_text.size() > 1){
				int i	= diag_text.size();
				while(i<12){
					diag_text.add("");
					i++;
				}
			}
			bean.setDiagText(diag_text);
			out.println("datafound('"+entered+"','"+diag_text.size()+"')");
		}
		else if(func_mode != null && func_mode.equals("getFormatId")){
			String patient_id			=	(String) hash.get( "patient_id" );
			String encounter_id			=	(String) hash.get( "encounter_id" );
			String order_catalog_code	=	(String) hash.get( "drug_code" );
			String order_type			=	(String) hash.get( "order_type" );
			String form_code			=	(String) hash.get( "form_code" );
			String route_code			=	(String) hash.get( "route_code" );
			String called_frm			=	(String) hash.get( "called_frm" );
			String or_bean_name	="eOR.OrderEntryBean";
			String or_bean_id	="@orderentrybean"+patient_id+encounter_id;
			OrderEntryBean orbean = (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
			eOR.Common.OrderEntryRecordBean orderEntryRecordBean 	= (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
			String order_category		=	"PH";
			if(called_frm != null && called_frm.equals("route")){
				if(orderEntryRecordBean.getOrderFormats(order_catalog_code, order_catalog_code+"_0")!=null)	{
					orderEntryRecordBean.removeOrderFormats(order_catalog_code, order_catalog_code+"_0");
				}
			}
			order_catalog_code=  order_catalog_code.substring(0,(order_catalog_code.length())-1);
			String format_id		=	presBean.getFormatId(order_category,order_type,order_catalog_code);
			ArrayList	pres_values	=	presBean.getPresValues(form_code,route_code,order_catalog_code);
			for(int i=0; i<pres_values.size(); i++){
				out.println("prescriptionValues(\""+(String)pres_values.get(i)+"\")");
			}
			out.println("validateRemarks('"+format_id+"')");
			putObjectInBean(or_bean_id,orbean,request);
		}
		/*else if(func_mode != null && func_mode.equals("chkAuthorization")){//Commented for ARYU-CRF-0014
			String pract_id		= (String) hash.get( "pract_id" );
			String resp_id		= (String) hash.get( "resp_id" );
			String src			= (String) hash.get( "src" );
			HashMap authValues = (HashMap) presBean.getAuthorizationReqd(resp_id,pract_id);
			if(authValues.size()>0){
				String auth_yn		=(String) authValues.get("auth_yn");
				String spl_appr_yn	= (String) authValues.get("spl_appr_yn");
				String cosign_yn	= (String) authValues.get("cosign_yn");	
				out.println("assignAuthorization('"+auth_yn+"','"+spl_appr_yn+"','"+cosign_yn+"','"+src+"')");
			}
		}*/
		else if(func_mode != null && func_mode.equals("makeScheduleLink")){
			String drug_code	= (String) hash.get( "drug_code" );
			String drug_codeOnly	= (String) hash.get( "drug_codeOnly" ); //Added for ML-BRU-SCF-1231 [IN:046657]
			String srl_no		= (String) hash.get( "srl_no" );
			String sliding_scale_yn		= (String) hash.get( "sliding_scale_yn" );
			String admin_time	= "", admin_qty="", final_qty="",ad_qty="", temp_admin_time="" ;
			float total_qty		= 0.0f;
			String att="  class=TIP";
			String ext_drug_code	= "", ext_srl_no; //Added for ML-BRU-SCF-1231 [IN:046657] -start
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap ext_drugData =null;
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData				=(HashMap) prescriptionDetails.get(j);
					ext_drug_code				=(String) ext_drugData.get("DRUG_CODE");
					ext_srl_no				=(String) ext_drugData.get("SRL_NO");
					if( drug_codeOnly.equals(ext_drug_code) && srl_no.equals(ext_srl_no) ){
						ext_drugData.put("VALUES_CHANGED","Y");
						break;
					 }
				}
			} //Added for ML-BRU-SCF-1231 [IN:046657] -end
			HashMap chkValuescheduleFrequency=bean.getscheduleFrequency();
			ArrayList frequencyValues = new ArrayList();
			if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0){
				frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code);
			}
			HashMap data	=	null;
			if(frequencyValues !=null && frequencyValues.size()>0){
				ArrayList day_list = new ArrayList();
				ArrayList day_names = new ArrayList();
				ArrayList time_list = new ArrayList();
				ArrayList dose_list = new ArrayList();
				ArrayList freqCharctValues = new ArrayList();
				if(chkValuescheduleFrequency.size()>0){
					frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code);
				}
				freqCharctValues = frequencyValues;
				admin_time = "";
				admin_qty = "";
				if(freqCharctValues != null && freqCharctValues.size() > 0){
					dose_list	= (ArrayList)freqCharctValues.get(4);
					if(dose_list==null  || dose_list.size()>0){
						total_qty	= 0.0f;
						for(int tqI=0;tqI<dose_list.size();tqI++){
							total_qty=total_qty+Float.parseFloat((String)dose_list.get(tqI));
							final_qty	=	(String)dose_list.get(tqI);
						}
						boolean split_chk	=	bean.checkSplit(frequencyValues);	
						if(split_chk)
							final_qty		=	total_qty+"";
						else
							ad_qty          =final_qty;
						if(freqCharctValues != null && freqCharctValues.size() > 0){
							 String tooltiptable ="";
							if(sliding_scale_yn.equals("N"))
								tooltiptable = (String)bean.getTooltipStringFrFreq(freqCharctValues,"toolTip");
							else
								tooltiptable = (String)bean.getTooltipStringFrFreq(freqCharctValues,"Sliding");
							admin_time = tooltiptable;	
						}
						out.println("makeScheduleLink('"+admin_time+"','"+admin_qty+"','"+final_qty+"','"+frequencyValues.size()+"','"+split_chk+"','Modify')");
					}
					else
						out.println("hideScheduleLink()");
				}
				else
					out.println("hideScheduleLink()");
			}
			else
				out.println("hideScheduleLink()");
		}
		else if(func_mode != null && func_mode.equals("disableScheduleLink")){
			HashMap ext_drugData		=	null;
			ArrayList prescriptionDetails=null;
			String drug_code	= (String) hash.get( "drug_code" );
			String amend_yn     ="N";
			String ext_drug_code=null;
			prescriptionDetails=(ArrayList)bean.getpresDetails();
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData	=	(HashMap) prescriptionDetails.get(j);
				ext_drug_code	=	(String) ext_drugData.get("DRUG_CODE");
				amend_yn		=	(String) ext_drugData.get("AMEND_YN");	
				if(drug_code.equals(ext_drug_code)&&amend_yn.equals("N")){
					bean.getclearscheduleFrequency(drug_code);
					out.println("deleteScheduleLink()");
				}
			}
		}
		else if(func_mode != null && func_mode.equals("disableScheduleLink1"))	{
			String drug_code	= (String) hash.get( "drug_code" );
			bean.getclearscheduleFrequency(drug_code);
			out.println("deleteScheduleLink()");
		}
		else if(func_mode!= null && func_mode.equals("deleteSlidingSch")){
			String drug_code	= (String) hash.get( "drug_code" );
			bean.getclearscheduleFrequency(drug_code);
		}
		else if(func_mode!= null && func_mode.equals("updateOROrderType")){
			String patient_id   = (String) hash.get( "patient_id" );
			String encounter_id = (String) hash.get( "encounter_id" );
			String order_type	= (String) hash.get( "order_type" );
			String or_bean_name	="eOR.OrderEntryBean";
			String or_bean_id="@orderentrybean"+patient_id+encounter_id;
			OrderEntryBean orbean = (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
			orbean.setOrderCategoryValue("PH");
			orbean.setOrderTypeValue(order_type);
			putObjectInBean(or_bean_id,orbean,request);
		}
		else if(func_mode!= null && func_mode.equals("chkDuplicateDrugCode")){
			String drug_code	= (String) hash.get( "drug_code" );
			String facility_id	= (String) hash.get( "facility_id" );
			String patient_class= (String) hash.get( "patient_class" );
			String patient_id   = (String) hash.get( "patient_id" );
			String encounter_id   = (String) hash.get( "encounter_id" );
			String order_idC		= (String) hash.get( "order_idC" );
			String ord_line		= (String) hash.get( "ord_line" )==null?"":(String)hash.get("ord_line");
			String modeC		= (String) hash.get( "modeC" )==null?"":(String)hash.get("modeC");; //to be used in PrescriptionDetail_1
			String sys_date     = (String) hash.get( "sys_date" );
			String drugCodes	= (String) hash.get( "drugCodes" );
			String tradeCodes	= (String) hash.get( "tradeCodes" )==null?"":(String) hash.get( "tradeCodes" );
			String tradeNames	= (String) hash.get( "tradeNames" )==null?"":(String) hash.get( "tradeNames" );
			//String priority		= (String) hash.get( "priority" ); //Commented for AAKH-CRF-0091
			String stat_yn		= (String) hash.get( "stat_yn" )==null?"":(String) hash.get( "stat_yn" );//AAKH-CRF-0091 
			String priority		= "";//AAKH-CRF-0091 
			String sch= stat_yn;//AAKH-CRF-0091 
			// added for ghl-crf-0509 start
			//String drug_search_bean_id				= "DrugSearchBean";
			String drug_search_bean_id	="@DrugSearchBean"+patient_id+encounter_id; //Modified for TFS-16341
			String drug_search_bean_name			= "ePH.DrugSearchBean";
			DrugSearchBean drug_bean				= (DrugSearchBean)getBeanObject( drug_search_bean_id, drug_search_bean_name , request);
			//added for ghl-crf-0509 end
			drug_bean.setLanguageId(locale);
			if(sch.equals("Y") && !sch.equals("")){ //AAKH-CRF-0091 
				priority="U";
			}
			else{
				priority=(String) hash.get("priority");
			}			
			String take_home_medication= (String) hash.get( "take_home_medication" );
			String order_set_code=(String)hash.get("order_set_code")==null?"":(String)hash.get("order_set_code");
			String order_set_occur_num=(String)hash.get("order_set_occur_num")==null?"":(String)hash.get("order_set_occur_num");
			String drug_db_interface_yn = (String)hash.get("drug_db_interface_yn")==null?"":(String)hash.get("drug_db_interface_yn");
			String act_patient_class = (String)hash.get("act_patient_class")==null?"":(String)hash.get("act_patient_class");
			String pract_id = (String)hash.get("pract_id")==null?"":(String)hash.get("pract_id");
			String resp_id = (String)hash.get("resp_id")==null?"":(String)hash.get("resp_id");
			String home_leave_yn_val = (String)hash.get("home_leave_yn_val")==null?"":(String)hash.get("home_leave_yn_val");//added for Bru-HIMS-CRF-093[29960]
					
			
			String tradeCodesArr[] = tradeCodes.split(",");
			String tradeNamesArr[] = tradeNames.split(",");
			String locn_type	= "";
			String trade_code="";
			String trade_name="";
			int trade_count=0;
			if( bean.getExternalpatient_id()==null ||  ((String)bean.getExternalpatient_id()).equals("") )
				locn_type	= (String) hash.get( "locn_type" );
			else
				locn_type	= "P";
			String locn_code	= (String) hash.get( "locn_code" );
			boolean allow_add= true;
			HashMap chk	=	null;
		
			bean.setDefaultDispLocnCode(drug_bean.getDispLocnCode()); //Added for TFS-16341-Start
			if(allow_add){
				drugCodes = drugCodes.replace('[',' ');
				drugCodes = drugCodes.replace(']',' ');
				StringTokenizer stDrugCodes = new StringTokenizer(drugCodes.trim(),",");
				while(stDrugCodes.hasMoreTokens()){
					int srl_no	=bean.getSrlNo()+1;
					drug_code	=stDrugCodes.nextToken();
					if(trade_count < tradeCodesArr.length){
						trade_code=tradeCodesArr[trade_count];
						trade_name = java.net.URLDecoder.decode(tradeNamesArr[trade_count++],"UTF-8");
					}
					else{
						trade_code = "";
						trade_name = "";
					}
					sys_date     = (String) hash.get( "sys_date" ); // added for IN23575 --01/09/2010-- priya
					if(!locale.equals("en"));
						sys_date  = DateUtils.convertDate(sys_date, "DMYHM",locale,"en");
					if(sch.equals("Y") && !sch.equals("")){  //AAKH-CRF-0091
						bean.setStatDrug_Yn(drug_code,srl_no, "Y");
					}
    bean.setCalled_from_verbal_order(drug_bean.getCalled_from_verbal_order());//added for GHL-CRF-0509
					chk	=(HashMap)bean.loadDrugDetails(priority,take_home_medication,locn_type,locn_code,facility_id,drug_code.trim(),patient_class,patient_id,sys_date,String.valueOf(srl_no),order_set_code,order_set_occur_num, drug_db_interface_yn, trade_code, trade_name,act_patient_class,pract_id, resp_id,encounter_id,home_leave_yn_val);
					bean.addDrugDetails(999,chk);
					bean.setSrlNo(srl_no);
					if(!drug_db_interface_yn.equals("Y") || chk.get("EXTERNAL_PRODUCT_ID")==null || ((String)chk.get("EXTERNAL_PRODUCT_ID")).equals("")){//MMS-KH-CRF-0029
					
					out.println("loadDrugInteractionForDrug('"+drug_code+"','"+patient_id+"');");
					}

				}
				out.println("loadDetailForm('"+order_idC+"','"+modeC+"','"+ord_line+"');");
			}
			else{
				out.println("invalidDrug();");
			}
		}
		else if(func_mode != null && func_mode.equals("addTaperDrugDetails")){
			ArrayList addprescriptionDetails	=	(ArrayList)bean.getpresDetails();
			String drugCode			= (String)hash.get("drug_code");
			String srlNo			= (String)hash.get("srl_no");
			String patient_id			= (String)hash.get("patient_id");
			String tap_lvl_qty			= (String)hash.get("tap_lvl_qty");  //Added for RUT-CRF-0088 [IN036978]
			String dosage_type			= (String)hash.get("dosage_type");  //Added for RUT-CRF-0088 [IN036978]
			String addext_drug_code = "";
			String addext_srl_no	= "";
			String drug_db_interface_yn  = (String)hash.get("drug_db_interface_yn")==null?"":(String)hash.get("drug_db_interface_yn");
			String ext_prod_id			 = "";
			int order_qty			= Integer.parseInt(hash.get("order_qty").toString());  //Added for RUT-CRF-0088 [IN036978]
			String drug_qty="";
			HashMap addext_drugData	= new HashMap();
			HashMap temp	= new HashMap();
			String st_date_local="", end_date_local="";
			String intr_msg_content ="", intr_restric_trn="N", severity_level="";
			HashMap hmDrugInteractionDtl = null;
			ArrayList alDrugIntrDtlList = null;
			HashMap temp_drugData	= new HashMap(); //Added for  [IN:043763] User can able to do Taper without changing the Dosage and frequency.  -Start
			String temp_drug_code="", taper_up_yn="", taper_down_yn="",multiFreq_yn="", qtyValue="", qty_value="", freq_code="", freq="", freq_nature="";
			float ext_total_qty_value= 0;
			float new_total_qty=0;
			boolean taper_cofirmed= true; //Added for  [IN:043763] -end

			for(int j=0;j<addprescriptionDetails.size();j++){
				addext_drugData		=	(HashMap) addprescriptionDetails.get(j);
				addext_drug_code	=	(String) addext_drugData.get("DRUG_CODE");
				addext_srl_no		=	(String) addext_drugData.get("SRL_NO");
				
				ext_total_qty_value   = Float.parseFloat((String) addext_drugData.get("TOTAL_QTY_VALUE")); //Added for  [IN:043763] User can able to do Taper without changing the Dosage and frequency.  -Start
				freq_code				=  (String) addext_drugData.get("FREQ_CODE")==null?"":(String) addext_drugData.get("FREQ_CODE");
				qtyValue				=  (String) addext_drugData.get("QTY_VALUE")==null?"":(String) addext_drugData.get("QTY_VALUE");
				taper_up_yn					=  (String)addext_drugData.get("TAPER_UP")==null?"":(String)addext_drugData.get("TAPER_UP");
				taper_down_yn				=  (String) addext_drugData.get("TAPER_DOSE_YN")==null?"":(String) addext_drugData.get("TAPER_DOSE_YN"); //Added for  [IN:043763] -end
				if( drugCode.equals(addext_drug_code) && srlNo.equals(addext_srl_no) ){
					for(int t=0; t<j; t++){ //Added for  [IN:043763] User can able to do Taper without changing the Dosage and frequency.  -Start
						temp_drugData		=	(HashMap) addprescriptionDetails.get(t);
						temp_drug_code	=	(String) temp_drugData.get("DRUG_CODE");
						new_total_qty   = Float.parseFloat((String) temp_drugData.get("TOTAL_QTY_VALUE"));
						freq				=  (String) temp_drugData.get("FREQ_CODE")==null?"":(String) temp_drugData.get("FREQ_CODE");
						qty_value				=  (String) temp_drugData.get("QTY_VALUE")==null?"":(String) temp_drugData.get("QTY_VALUE");
						freq_nature				=  (String) temp_drugData.get("FREQ_NATURE")==null?"":(String) temp_drugData.get("FREQ_NATURE");
						if(freq_nature.equals("O") || freq_nature.equals("P") || !addext_drug_code.equals(temp_drug_code) )
							continue;

						if(taper_up_yn.equals("Y")||taper_down_yn.equals("Y"))
							multiFreq_yn = "N";
						else
							multiFreq_yn = "Y";

						if(taper_up_yn.equals("N") && multiFreq_yn.equals("N")){
							if( (new_total_qty >= ext_total_qty_value)){
								taper_cofirmed = false;
								break;
							}
						}	
						else if( multiFreq_yn.equals("N")){
							if(new_total_qty <= ext_total_qty_value){
								taper_cofirmed = false;
								break;
							}
						}
						if(freq.equals(freq_code) && qty_value.equals(qtyValue)){
							taper_cofirmed = false;
							break;
						}
					}
					if(!taper_cofirmed){
						out.println("alert(getMessage('PH_CONFIRM_MAIN_DRUG','PH'))") ;
					}
					else{ //Added for  [IN:043763] -end
						int srl_no				= bean.getSrlNo()+1;
						temp	= (HashMap)	addext_drugData.clone();
						temp.put("SRL_NO",String.valueOf(srl_no));
						temp.put("LOADED_YN","N"); //Added for RUT-CRF-0088 [IN036978](to avoid adding totalTaperQty keep on clicking from drug list without confirm)
						temp.put("AMEND_YN","N");
						addext_drugData.put("DRUG_TAPERED_YN","Y");
						//temp.put("SCHEDULED_YN","N");
						HashMap taperDateParams = new HashMap();
						String t_start_date = (String)temp.get("START_DATE")==null?"":(String)temp.get("START_DATE");
						String t_end_date = (String)temp.get("END_DATE")==null?"":(String)temp.get("END_DATE");
						String t_durn_value = (String)temp.get("DURN_VALUE")==null?"":(String)temp.get("DURN_VALUE") ;
						String t_repeat_durn_type = (String)temp.get("REPEAT_DURN_TYPE")==null?"":(String)temp.get("REPEAT_DURN_TYPE");
						ext_prod_id = (String)temp.get("EXTERNAL_PRODUCT_ID")==null?"":(String)temp.get("EXTERNAL_PRODUCT_ID");
						if(t_durn_value.equals("") || t_durn_value.equals("0"))
							t_durn_value="1";
						// added for IN071728,IN071727,IN072421
						if(!locale.equals("en")){
							t_end_date = DateUtils.convertDate(t_end_date, "DMYHM",locale,"en");
						}
						taperDateParams	=(HashMap)presBean.populateTaperDates(t_end_date,t_durn_value,t_repeat_durn_type);
						if(taperDateParams.size()>0){
							t_start_date	=(String) taperDateParams.get("taper_start_date")==null?"":(String) taperDateParams.get("taper_start_date");
							t_end_date	=(String) taperDateParams.get("taper_end_date")==null?"":(String) taperDateParams.get("taper_end_date");
							//  added for IN071728,IN071727, IN072421
							if(!locale.equals("en")){
								t_start_date = DateUtils.convertDate(t_start_date, "DMYHM","en",locale);
								t_end_date = DateUtils.convertDate(t_end_date, "DMYHM","en",locale);
							}
							temp.put("START_DATE",t_start_date);
							temp.put("END_DATE",t_end_date);
							//Added for	RUT-CRF-0066 IN[029604] -start
							if((!drug_db_interface_yn.equals("Y")) || ext_prod_id.equals("")){
								temp.put("INTERACTION_EXISTS", "N" );
								//temp.put("INTR_MSG_CONTENT","");
								temp.put("INTR_RESTRIC_TRN","N");
								temp.put("INTR_ALERT", "N" );
								st_date_local = t_start_date;
								end_date_local =  t_end_date;
								if(!locale.equals("en")){
									st_date_local =  DateUtils.convertDate(st_date_local, "DMYHM",locale,"en");
									end_date_local =  DateUtils.convertDate(end_date_local, "DMYHM",locale,"en");
								}
								alDrugIntrDtlList = bean.getDrugInteractionDtls(addext_drug_code, (String) temp.get("FORM_CODE"), (String) temp.get("GENERIC_ID"), st_date_local ,end_date_local, patient_id);
								if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()>2){
									severity_level = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2);
									intr_restric_trn = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1);
									temp.put("INTR_RESTRIC_TRN", intr_restric_trn );
									temp.put("INTERACTION_DTL", alDrugIntrDtlList );
									temp.put("INTERACTION_EXISTS", "Y" );
									//added for PMG2020-ICN-001- start
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
								   } //added for PMG2020-ICN-001- end
									if(intr_restric_trn.equals("Y") ){ 
										temp.put("INTR_ALERT","Y");
										//temp.put("INTR_MSG_CONTENT",intr_msg_content);
										/*if(addext_drugData.get("AMEND_YN")!=null && ((String)addext_drugData.get("AMEND_YN")).equals("Y"))
											out.println("alertIntr('"+(String)temp.get("DRUG_DESC")+"','"+intr_msg_content+"');");
										can_taper=false;
										break;*/
									}
								}
								else{
									temp.put("DRUGINTRACTION_OVERRIDE","N");
									temp.put("INTERACTION_REMARKS","");
								}
							}//Added for	RUT-CRF-0066 IN[029604] - end
						}
						//temp.put("TAPER_DOSE_YN","Y"); // was added on 16/02/10 for IN18929---commented on 02/06/2010--Commented again on 21-01-2011-- for IN25968 --priya
						temp.put("TAPPERED_OVER","Y"); // added for IN18929 for Taper legend to display in preview screen 02/06/2010 --priya
						bean.addDrugDetails(j,temp);
						bean.setSrlNo(srl_no);
						out.println("srl_no = "+srl_no+";"); // added for IN19397 -- priya -- 26/02/2010
						break;
					}
				}
			}
		}
		else if(func_mode != null && func_mode.equals("InsertRec")){
			String oper_mode		= (String)hash.get("oper_mode"); 
			String trade_code		= (String) hash.get("trade_code")==null?"":(String)hash.get("trade_code");
			String trade_name		= (String) hash.get("trade_name")==null?"":(String)hash.get("trade_name");
			trade_name= java.net.URLDecoder.decode(trade_name,"UTF-8");
			String buildMAR_yn		= (String)hash.get("buildMAR_yn")==null?"":(String)hash.get("buildMAR_yn");
			String order_set_code	= (String)hash.get("order_set_code")==null?"":(String)hash.get("order_set_code");
			String split_dose_yn_val= (String)hash.get("split_dose_yn_val");
			String DrugRemarksEntered= (String)hash.get("DrugRemarksEntered"); //Added for Antibiotic Screen using Order Entry Format ICN 29904
			String patient_id		= (String) hash.get( "patient_id" );
			String encounter_id		= (String) hash.get( "encounter_id" ); //added for Bru-HIMS-CRF-0265 [IN032315]
			String patient_stock_yn = (String) hash.get( "patient_stock" ); //added for GHL-CRF-0482
			String def_dose_value   = (String) hash.get( "def_dose_value")==null?"0":(String)hash.get( "def_dose_value" ); //added for ARYU-CRF-014
			String dosage_change_yn = (String) hash.get( "dosage_change_yn")==null?"N":(String)hash.get( "dosage_change_yn" ); 
			String allow_alternate_yn = (String) hash.get( "allow_alternate")==null?"N":(String)hash.get( "allow_alternate"); //GHL-CRF-549
			
			String quota_limit_exceded_yn	= (String) hash.get( "quota_limit_excess_yn" )==null?"":(String) hash.get("quota_limit_excess_yn"); // ML-MMOH-CRF-1823 US008- 43528
//System.err.println("quota_limit_exceded_yn@insertRec=="+quota_limit_exceded_yn);
			String addext_drug_code	=	null;
			String ext_drug_code	=	null;
			String addext_srl_no	=	null;
			String durnValue		=	"";
			String freq_code		=	"";
			String qtyValue			=	"";
			String total_qty_value	=	"";
			String multiFreq_yn		=	"N";
			String taper_up_yn		=	"";
			String taper_down_yn	=	"";
			String interval_value	=	"";  // added for SRR20056-SCF-7524
			String repeat_durn_type	=	"";  // added for SRR20056-SCF-7524
			String durn_desc_code	=	"";  // added for SRR20056-SCF-7524
			String freqNature=""; //AAKH-SCF-0460
			String dosageType = ""; //AAKH-SCF-0460
			String bl_incl_excl_override_reason_code = (String) hash.get("bl_incl_excl_override_reason_code")==null?"":(String)hash.get("bl_incl_excl_override_reason_code");
			String bl_incl_excl_override_reason_desc = (String) hash.get("bl_incl_excl_override_reason_desc")==null?"":(String)hash.get("bl_incl_excl_override_reason_desc");
			String bl_def_override_excl_incl_ind     = (String) hash.get("bl_def_override_excl_incl_ind")==null?"":(String)hash.get("bl_def_override_excl_incl_ind");
			String bl_override_excl_incl_ind         = (String) hash.get("bl_override_excl_incl_ind")==null?"":(String)hash.get("bl_override_excl_incl_ind");
			String bl_override_allowed_yn            = (String) hash.get("bl_override_allowed_yn")==null?"":(String)hash.get("bl_override_allowed_yn");
			String DrugIndicationRemarks            = (String) hash.get("DrugIndicationRemarks")==null?"":(String)hash.get("DrugIndicationRemarks");
			String drug_db_interface_yn = (String)hash.get("drug_db_interface_yn")==null?"":(String)hash.get("drug_db_interface_yn");
			String drug_db_duptherapy_yn = (String)hash.get("drug_db_duptherapy_yn")==null?"":(String)hash.get("drug_db_duptherapy_yn");
			String preg_remarks            = (String) hash.get("preg_remarks")==null?"":(String)hash.get("preg_remarks");// added for CRF RUT-CRF-0063[29601]
			String totalTaperQtyDisplay = bean.getTotalTaperQtyDisplay();
			String ext_prod_id = "";
			if(!DrugIndicationRemarks.equals(""))
				DrugIndicationRemarks = java.net.URLDecoder.decode(DrugIndicationRemarks,"UTF-8"); ;
			if(!preg_remarks.equals(""))
				preg_remarks = java.net.URLDecoder.decode(preg_remarks,"UTF-8"); // added for CRF RUT-CRF-0063[29601]
			String intr_msg_content ="", intr_restric_trn="N", severity_level="", st_date_local="",end_date_local="";//,abuse_restric_trn="N" ;
			HashMap hmDrugInteractionDtl = null;
			ArrayList alDrugIntrDtlList = null;
			float ext_total_qty_value = 0;
			
			ArrayList addprescriptionDetails	=	(ArrayList)bean.getpresDetails();
			HashMap temp			=	new HashMap();
			HashMap ext_drugData	=	null;
			HashMap addext_drugData	=	null;
			float new_qty			=	0.0f;
			int new_repeat_value	=0;
			float new_total_qty		=0.0f;
			//AAKH-CRF-0091 starts
			String serial_No			= (String)hash.get("srl_no");
			String scheduled_yn		= (String) hash.get("scheduled_yn");
			String pat_class		= (String) hash.get("patient_class");
			String parent_stat_yn	= (String) hash.get("parent_stat_yn"); //MMS-DM-SCF-0449
			String stat_yn			="";
			String amend_yn =(String)hash.get("amend_yn")==null?"":(String)hash.get("amend_yn");
			stat_yn=(String)hash.get("stat_yn")==null?"N":(String)hash.get("stat_yn");
			String chk_missing_sch_yn =(String)hash.get("chk_missing_sch_yn")==null?"":(String)hash.get("chk_missing_sch_yn");
			String chk_missing_sch_yn_1 =(String)hash.get("chk_missing_sch_yn_1")==null?"":(String)hash.get("chk_missing_sch_yn_1");
			boolean aakh_site=false;
			aakh_site	=presBean.isSiteSpecific("PH","STAT_PARENT_CHILD");
			if(parent_stat_yn==null || parent_stat_yn.equals(""))
				parent_stat_yn = "N";
			if( aakh_site==true && oper_mode.equals("modify") && scheduled_yn.equals("Y") && pat_class.equals("IP")  && parent_stat_yn.equals("N")){ //parent_stat_yn added for MMS-DM-SCF-0449
			String start_date		= (String)hash.get("start_date");
			String drug_code			= (String)hash.get("drug_code");
			String frequency_code      =(String)hash.get("freq_code")==null?"":(String)hash.get("freq_code");
			String trade_Codes	= (String) hash.get( "tradeCodes" )==null?"":(String) hash.get("tradeCodes");
			String trade_Names	= (String) hash.get( "tradeNames" )==null?"":(String) hash.get("tradeNames");
			//String freqNature=""; //moved to top for AAKH-SCF-0460
			HashMap freqValues = null;
			HashMap drugDetails =null;
			HashMap chkValuescheduleFrequency=null;
			ArrayList frequencyValues = new ArrayList();
			ArrayList time_list = new ArrayList();
			chkValuescheduleFrequency=bean.getscheduleFrequency();
			if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0){
				frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code+serial_No);
			}
			if(frequencyValues !=null && frequencyValues.size()>0){
				time_list		= (ArrayList)frequencyValues.get(3);
			}
			String sch_first_time=(String)time_list.get(0);
			boolean chk_date=false;
			boolean statflag=false;
			boolean chk_stat_not=false;
			for(int j=0;j<addprescriptionDetails.size();j++){
				addext_drugData		=	(HashMap) addprescriptionDetails.get(j);
				addext_drug_code	=	(String) addext_drugData.get("DRUG_CODE");
				addext_srl_no		=	(String) addext_drugData.get("SRL_NO");
				freqNature	=  (String) addext_drugData.get("FREQ_NATURE");
				freq_code	=  (String) addext_drugData.get("FREQ_CODE");
				if( drug_code.equals(addext_drug_code) ){
					if(freqNature.equals("O")){
						statflag = true;
						out.println("alert(getMessage('PH_FREQ_NO_CHANGE','PH'));") ;
						break;
					}
				}
			}
			freqValues	=	(HashMap)bean.populateFrequencyValues(drug_code,frequency_code,oper_mode,pat_class);
			ArrayList   F_Nature	= (ArrayList) freqValues.get("FreqNature");
			for(int i=0;i<F_Nature.size();i++){
			String chk_freq=(String)F_Nature.get(i);
				if(chk_freq.equals("O")){
				chk_stat_not=true;
				}
			}
			if(!statflag){	
					chk_date=bean.callingSchedule(start_date,sch_first_time,locale);
			}
			if(chk_date==true){
					out.println("checking_time('"+drug_code+"','"+trade_Codes+"','"+trade_Names+"','"+chk_stat_not+"','"+(Integer.parseInt(serial_No)+1)+"','"+chk_missing_sch_yn_1+"');");
				}
		}//AAKH CRF-0091 ends
			String srlNo_tmp		= (String)hash.get("srl_no"); //GHL-CRF-0549 -start
			String drugCode_temp	= (String)hash.get("drug_code");
			for(int j=0;j<addprescriptionDetails.size();j++){
					addext_drugData		=	(HashMap) addprescriptionDetails.get(j);
					addext_drug_code	=	(String) addext_drugData.get("DRUG_CODE");
					addext_srl_no		=	(String) addext_drugData.get("SRL_NO");
					if(drugCode_temp.equals(addext_drug_code) && srlNo_tmp.equals(addext_srl_no) ){
						addext_drugData.put("allow_alternate_yn",allow_alternate_yn);
						addext_drugData.put("QUOTA_LIMIT_EXCEDED_YN",quota_limit_exceded_yn); //ML-MMOH-CRF-1823 US008- 43528
						//added for AAKH-SCF-0460 - start
						dosageType		= (String) hash.get( "dosage_type" )==null?"":(String) hash.get( "dosage_type" );
						freqNature		= (String) hash.get("freq_nature")==null?"":(String) hash.get("freq_nature");
						if(!dosageType.equals("A") && !freqNature.equals("P")){
							addext_drugData.put("ABSOL_QTY", "0");
						}
						//added for AAKH-SCF-0460 - end
						break;
					}
			}//GHL-CRF-0549 -end
			if(oper_mode != null && oper_mode.equals("taper")){
				boolean can_taper		= false;
				//	int srl_no				= bean.getSrlNo()+1;
				String override_check		= (String) hash.get("override_remarks");//shyampriya
				String checkEnabled			= (String) hash.get("checkEnabled");
				if(override_check==null)
					override_check="";
				if(checkEnabled==null)
					checkEnabled="";			
				String drugCode			= (String)hash.get("drug_code");
				String srlNo			= (String)hash.get("srl_no");
				String durn_value		= (String)hash.get("durn_value");
				String freq				= (String)hash.get("frequency");
				String qty_value		= (String)hash.get("qty_value");
				String repeat_value		= (String)hash.get("repeat_value");
				String ph_version		= (String)hash.get("ph_version");
				int srl_no				= Integer.parseInt(srlNo);
				new_qty			=	Float.parseFloat(qty_value);
				new_repeat_value	=	Integer.parseInt(repeat_value);
				if(split_dose_yn_val!=null && !split_dose_yn_val.equals("Y"))
					new_total_qty	=	(new_qty*new_repeat_value);
				else 
					new_total_qty = new_qty;
				durnValue		=	"";    
				freq_code		=	"";    
				qtyValue			=	"";
				total_qty_value	=	"";
				if(repeat_value==null || repeat_value.equals(""))
					repeat_value="1";
				String pract_name			 = (String) hash.get("pract_name");
				for(int j=0;j<addprescriptionDetails.size();j++){
					addext_drugData		=	(HashMap) addprescriptionDetails.get(j);
					addext_drug_code	=	(String) addext_drugData.get("DRUG_CODE");
					addext_srl_no		=	(String) addext_drugData.get("SRL_NO");
					//if( drugCode.equals(addext_drug_code) && srlNo.equals(addext_srl_no) ){
					if( drugCode.equals(addext_drug_code) ){
						durnValue	=  (String) addext_drugData.get("DURN_VALUE");
						freq_code	=  (String) addext_drugData.get("FREQ_CODE");
						qtyValue	=  (String) addext_drugData.get("QTY_VALUE");
						total_qty_value=  (String) addext_drugData.get("TOTAL_QTY_VALUE");
						taper_up_yn=  (String)addext_drugData.get("TAPER_UP")==null?"":(String)addext_drugData.get("TAPER_UP");
						taper_down_yn=  (String) addext_drugData.get("TAPER_DOSE_YN")==null?"":(String) addext_drugData.get("TAPER_DOSE_YN");
						ext_prod_id=  (String) addext_drugData.get("EXTERNAL_PRODUCT_ID")==null?"":(String) addext_drugData.get("EXTERNAL_PRODUCT_ID");
						ext_total_qty_value=Float.parseFloat(total_qty_value.trim());
						//Added for	RUT-CRF-0066 IN[029604] -start
						if((!drug_db_interface_yn.equals("Y")) || ext_prod_id.equals("")){
							if( drugCode.equals(addext_drug_code) && srlNo.equals(addext_srl_no)){
								addext_drugData.put("INTERACTION_EXISTS", "N" );
								addext_drugData.put("INTR_MSG_CONTENT","");
								addext_drugData.put("INTR_RESTRIC_TRN","N");
								//addext_drugData.put("ABUSE_RESTRIC_TRN","N");
								st_date_local = (String) hash.get("start_date");
								end_date_local =  (String) hash.get("end_date");
								if(!locale.equals("en")){
									st_date_local =  DateUtils.convertDate(st_date_local, "DMYHM",locale,"en");
									end_date_local =  DateUtils.convertDate(end_date_local, "DMYHM",locale,"en");
								}
								alDrugIntrDtlList = bean.getDrugInteractionDtls(addext_drug_code, (String) addext_drugData.get("FORM_CODE"), (String) addext_drugData.get("GENERIC_ID"),st_date_local ,end_date_local , patient_id);
								if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()>2){
									severity_level = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2);
									intr_restric_trn = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1);
									addext_drugData.put("INTR_RESTRIC_TRN", intr_restric_trn );
									addext_drugData.put("INTERACTION_DTL", alDrugIntrDtlList );
									addext_drugData.put("INTERACTION_EXISTS", "Y" );
									//added for PMG2020-ICN-001- start
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
											addext_drugData.put("DRUG_INTERACTION_EXISTS","Y");
										}
										if(intrType.contains("F")){
											addext_drugData.put("FOOD_INTERACTION_EXISTS","Y");
										}
										if(intrType.contains("L")){
											addext_drugData.put("LAB_INTERACTION_EXISTS","Y");
										}
										if(intrType.contains("I")){//Added for MMS-DM-CRF-0229
									        temp.put("DISEASE_INTERACTION_EXISTS","Y");
								         }
									}
								   } //added for PMG2020-ICN-001- end
									if(intr_restric_trn.equals("Y") ){
										temp.put("INTR_ALERT","Y");
										if(addext_drugData.get("AMEND_YN")!=null && ((String)addext_drugData.get("AMEND_YN")).equals("Y"))
											out.println("alertIntr('"+drugCode+"','"+srlNo+"','"+patient_id+"','"+encounter_id+"','N');");
										//addext_drugData.put("INTR_MSG_CONTENT",intr_msg_content);
										//if(addext_drugData.get("AMEND_YN")!=null && ((String)addext_drugData.get("AMEND_YN")).equals("Y"))
										//out.println("alertIntr('"+(String)addext_drugData.get("DRUG_DESC")+"','"+intr_msg_content+"');");
										can_taper=false;
										break;
									}
								}
								else{
									addext_drugData.put("DRUGINTRACTION_OVERRIDE","N");
									addext_drugData.put("INTERACTION_REMARKS","");
								}
							}
						}
						//Added for	RUT-CRF-0066 IN[029604] - end
						if(taper_up_yn.equals("Y")||taper_down_yn.equals("Y"))
							multiFreq_yn = "N";
						else
							multiFreq_yn = "Y";
						if((!srlNo.equals(addext_srl_no)) && ((String)addext_drugData.get("TAPER_UP")).equals("N") && multiFreq_yn.equals("N")){
							if( (new_total_qty >= ext_total_qty_value)){
								can_taper=false;
								out.println("alertNoTaper('greater')") ;
								break;
							}
						}	
						else if((!srlNo.equals(addext_srl_no)) && multiFreq_yn.equals("N")){
							if(new_total_qty <= ext_total_qty_value){
								can_taper=false;
								out.println("alertNoTaper('lesser')") ;
								break;
							}
						}
						if((!srlNo.equals(addext_srl_no)) && freq.equals(freq_code) && qty_value.equals(qtyValue)){
							if(multiFreq_yn.equals("N")){
								can_taper=false;
								out.println("alertNoTaper('nochange')") ;
								break;
							}
							else{
								if((!srlNo.equals(addext_srl_no)) && split_dose_yn_val.equals("N")){
									can_taper=false;

									out.println("alertNoTaper('nochange')") ;
									break;
								}
								else{
									ArrayList	schedule_prev	=	(ArrayList)bean.getScheduleFrequencyStr(drugCode+srlNo,"0");
									ArrayList	schedule_curr	=	(ArrayList)bean.getScheduleFrequencyStr(drugCode+srl_no,"0");

									can_taper = false;
									for(int i=0;i<schedule_prev.size();i++){
										if(!((String)((HashMap)schedule_prev.get(i)).get("admin_qty")).equals((String)((HashMap)schedule_curr.get(i)).get("admin_qty"))){
											can_taper=true;
											break;
										}
									}
									if((!srlNo.equals(addext_srl_no)) && !can_taper ){
										out.println("alertNoTaper('nochange')") ;
										break;
									}
								}
							}
						}
						else{
							can_taper=true;
						}
						/*if(!can_taper){
							temp	= (HashMap)	addext_drugData.clone();
							temp.put("SRL_NO",String.valueOf(srl_no));
							bean.addDrugDetails(j,temp);
							bean.setSrlNo(srl_no);
						}*/
					//	break; // commented for IN23880 --25/10/2010-- priya
					}
				}
				//chekcing the stock avail
				boolean no_stock_allow=true;
				if(can_taper){
					if( ph_version != null && !(ph_version.equals("PHBASIC"))){
						String consider_stock_for_pres_yn=(String)hash.get("consider_stock_for_pres_yn");
						if(consider_stock_for_pres_yn != null && consider_stock_for_pres_yn.equals("Y")){
							//float st_total_qty=0.0f; //commented b'z not used
							//st_total_qty+=Float.parseFloat(durn_value)*Float.parseFloat(repeat_value)*Float.parseFloat(qty_value);  //commented b'z not used
							ArrayList details=(ArrayList)bean.getpresDetails();
							String addext_durn_value	=	null;
							String addext_repeat_value	=	null;
							String addext_qty_value		=	null;
							for(int j=0;j<details.size();j++){
								addext_drugData=(HashMap) details.get(j);
								addext_drug_code=(String) addext_drugData.get("DRUG_CODE");
								addext_durn_value=(String) addext_drugData.get("DURN_VALUE");
								addext_repeat_value=(String) addext_drugData.get("REPEAT_VALUE");
								addext_qty_value=(String) addext_drugData.get("QTY_VALUE");
								if(addext_drug_code.equals(drugCode)){				
									//st_total_qty+=Float.parseFloat(addext_durn_value)*Float.parseFloat(addext_repeat_value)*Float.parseFloat(addext_qty_value);  //commented b'z not used
								}
							}
							consider_stock_for_pres_yn=(String)hash.get("consider_stock_for_pres_yn");
							boolean no_stock_found				=	false;
							ArrayList prescriptionDetails		=	(ArrayList)bean.getpresDetails();
							String stock_available_yn			=	null;
							String allow_pres_without_stock_yn	=	null;
							for(int j=0;j<prescriptionDetails.size();j++){
								ext_drugData=(HashMap) prescriptionDetails.get(j);
								stock_available_yn = (String)ext_drugData.get("STOCK_AVAILABLE_YN");
								allow_pres_without_stock_yn = (String)ext_drugData.get("ALLOW_PRES_WITHOUT_STOCK_YN")==null?"N":(String)ext_drugData.get("ALLOW_PRES_WITHOUT_STOCK_YN");
								if(consider_stock_for_pres_yn != null && consider_stock_for_pres_yn.equals("Y")){
									if(allow_pres_without_stock_yn.equals("N")){
										if(stock_available_yn.equals("N")){
											no_stock_found=true;
											no_stock_allow	=	false;
											break;
										}
									}
								}
							}//for
							if(no_stock_found){
								out.println("alertNoAvailStock()") ;
							}
						}//new if
					}//end of stock avail;
				}
				if(no_stock_allow){
					if(can_taper){
						ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
						String ext_srl_no			=	null;
						String freq_desc = "";
						String drug_tapered = "";
						String tapered_over = "";
						String allergy_yn="", limit_ind="", current_rx="", interaction_exists="", Override_remarks="";
						HashMap prev_extdrugData;
						for(int j=0;j<prescriptionDetails.size();j++){
							ext_drugData=(HashMap) prescriptionDetails.get(j);
							ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
							ext_srl_no=(String) ext_drugData.get("SRL_NO");
							if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
								// Added for SRR20056-SCF-7524 -Start
								new_qty=Float.parseFloat(qty_value);
								new_repeat_value=Integer.parseInt(repeat_value);
								durnValue	    =  (String) hash.get("durn_value");
								repeat_durn_type = (String) hash.get("repeat_durn_type");
								if(repeat_durn_type == null || repeat_durn_type.equals(""))
									repeat_durn_type = (String) hash.get("repeat_durn_type");
								durn_desc_code = (String) hash.get("durn_desc");
								if(durn_desc_code == null || durn_desc_code.equals(""))
									durn_desc_code = (String) hash.get("durn_desc");
								if(durnValue==null || durnValue.equals(""))
									durnValue = "1";
								interval_value		= (String)hash.get("interval_value");
								if(interval_value==null || interval_value.equals(""))
									interval_value = "1";
								durnValue =	(String)bean.getFreqDurnConvValue(repeat_durn_type,durnValue,durn_desc_code);
								new_total_qty=(new_qty*new_repeat_value*(Integer.parseInt(durnValue)/Integer.parseInt(interval_value)));
								// Added for SRR20056-SCF-7524 -End
								ext_drugData.put("ROUTE_CODE",(String) hash.get("route_code"));
								ext_drugData.put("ROUTE_DESC",(String) hash.get("route_desc"));
								ext_drugData.put("DOSAGE_TYPE",(String) hash.get("dosage"));
								ext_drugData.put("FREQ_CODE",(String) hash.get("frequency"));
								ext_drugData.put("REPEAT_VALUE",repeat_value);//(String) hash.get("repeat_value")
								ext_drugData.put("AMEND_YN","Y");
								ext_drugData.put("allow_alternate_yn",allow_alternate_yn); //GHL-CRF-0549 
								ext_drugData.put("INTERVAL_VALUE",interval_value); //(String) hash.get("interval_value")
								ext_drugData.put("FREQ_NATURE",(String) hash.get("freq_nature"));						
								ext_drugData.put("DURN_TYPE",(String) hash.get("repeat_durn_type"));
								ext_drugData.put("REPEAT_DURN_TYPE",(String) hash.get("repeat_durn_type"));
								freq_desc=(String) hash.get("freq_desc");
								freq_desc = java.net.URLDecoder.decode(freq_desc,"UTF-8");
								ext_drugData.put("FREQ_DESC",freq_desc);
								ext_drugData.put("QTY_VALUE",(String) hash.get("qty_value"));
								ext_drugData.put("QTY_DESC",(String) hash.get("qty_desc_code"));
								ext_drugData.put("OR_QTY_DESC",(String) hash.get("or_qty_desc"));
								ext_drugData.put("DURN_VALUE",(String) hash.get("durn_value"));
								ext_drugData.put("DURN_DESC",(String) hash.get("durn_desc"));
								ext_drugData.put("freq_chng_durn_desc",(String) hash.get("durn_desc"));		
								ext_drugData.put("patient_stock_yn",patient_stock_yn);	//GHL-CRF-0482					
								ext_drugData.put("def_dose_value",def_dose_value);	//ARYU-CRF-014
								ext_drugData.put("dosage_change_yn",(String) hash.get("dosage_change_yn"));	
								ext_drugData.put("TAPPERED_OVER","Y");
								ext_drugData.put("TOTTAPPERQTY",(String) hash.get("totTapperQty"));   //Commented for RUT-CRF-0088 [IN036978]
								ext_drugData.put("PREVTOTTAPPERQTY",(String) hash.get("prevTotalTaperQty"));  //Commented for RUT-CRF-0088 [IN036978]
								ext_drugData.put("TAP_LVL_QTY",(String) hash.get("tap_lvl_qty"));  //Added for RUT-CRF-0088 [IN036978]
								ext_drugData.put("TOTAL_QTY_VALUE",""+new_total_qty); //new_total_qty
								ext_drugData.put("DOSE_OVERRIDE",(String) hash.get("dose_override"));
								ext_drugData.put("QTY_DESC_CODE",(String) hash.get("qty_desc"));
								ext_drugData.put("OR_DURN_DESC",(String) hash.get("or_durn_desc"));
								ext_drugData.put("SPLIT_DOSE",(String) hash.get("split_dose"));
								ext_drugData.put("SPLIT_DOSE_YN",(String) hash.get("split_dose_yn"));
								ext_drugData.put("SPLIT_DOSE_YN_VAL",(String) hash.get("split_dose_yn_val"));
								ext_drugData.put("START_DATE",(String) hash.get("start_date"));
								ext_drugData.put("END_DATE",(String) hash.get("end_date"));
								ext_drugData.put("AUTH_YN_VAL",(String) hash.get("authroize_yn_val"));
								ext_drugData.put("APPROVAL_YN_VAL",(String) hash.get("approval_yn_val"));
								ext_drugData.put("COSIGN_YN_VAL",(String) hash.get("cosign_yn_val"));
								ext_drugData.put("ALLOW_REFILL",(String) hash.get("allow_refill"));
								ext_drugData.put("NO_REFILL",(String) hash.get("no_refill"));
								ext_drugData.put("REFILL_START_DATE",(String) hash.get("refill_start_date"));
								ext_drugData.put("REFILL_END_DATE",(String) hash.get("refill_end_date"));
								ext_drugData.put("ADMIN_TIME",(String) hash.get("admin_time"));
								ext_drugData.put("ADMIN_QTY",(String) hash.get("admin_qty"));
								ext_drugData.put("DFLT_QTY_UOM",(String) hash.get("dflt_qty_uom"));
								ext_drugData.put("DFLT_QTY_UOM",(String) hash.get("in_dispensed_uom"));
								ext_drugData.put("TOT_STRENGTH",(String) hash.get("in_total_strength"));
								ext_drugData.put("TOT_STRENGTH_UOM",(String) hash.get("in_total_strength_uom"));
								ext_drugData.put("DISPENSED_QTY",(String) hash.get("in_dispensed_qty"));
								ext_drugData.put("DISPENSED_UOM",(String) hash.get("in_dispensed_uom"));
								ext_drugData.put("BMS_QTY",(String) hash.get("in_bms_qty"));
								ext_drugData.put("SCH_OVER_YN",(String) hash.get("sch_over_yn"));
								ext_drugData.put("TRADE_CODE",trade_code);
								ext_drugData.put("TRADE_NAME",trade_name);
								ext_drugData.put("BL_INCL_EXCL_OVERRIDE_REASON_CODE",bl_incl_excl_override_reason_code);
								ext_drugData.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC",bl_incl_excl_override_reason_desc);
								//ext_drugData.put("BL_DEF_OVERRIDE_EXCL_INCL_IND",bl_def_override_excl_incl_ind);
		                      // if(bl_override_excl_incl_ind.equals("SEL"))
						           //  bl_override_excl_incl_ind ="";
								ext_drugData.put("BL_OVERRIDE_EXCL_INCL_IND",bl_override_excl_incl_ind); //priya
								ext_drugData.put("BUILDMAR_YN",buildMAR_yn);
								ext_drugData.put("DrugRemarksEntered",DrugRemarksEntered); //Added for Antibiotic Screen using Order Entry Format ICN 29904
								ext_drugData.put("DRUG_INDICATION",DrugIndicationRemarks); 
								ext_drugData.put("PREG_REMARKS",preg_remarks); // added for CRF RUT-CRF-0063[29601]
								ext_drugData.put("allow_alternate_yn",allow_alternate_yn);//GHL-CRF-0549
								if(ext_drugData.containsKey("TAP_LVL_QTY"))   //Added for RUT-CRF-0088 [IN036978] 
									ext_drugData.put("TAP_LVL_QTY",(String) hash.get("tap_lvl_qty")); 
								//ext_drugData.put("TAPER_DOSE_YN", "Y");
								allergy_yn  =(String) hash.get("allergy_yn")==null?"N":(String) hash.get("allergy_yn");
								limit_ind  =(String) hash.get("limit_ind")==null?"N":(String) hash.get("limit_ind");
								current_rx  =(String) hash.get("current_rx")==null?"":(String) hash.get("current_rx");
								interaction_exists  =(String) hash.get("interaction_exists")==null?"":(String) hash.get("interaction_exists"); //Added for	RUT-CRF-0066 IN[029604]
								if(override_check.equals("Y") && !checkEnabled.equals("disabled")){
									Override_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
									if(current_rx.equals("Y")){
										ext_drugData.put("CURRENTRX_OVERRIDE","Y");
										ext_drugData.put("CURRENTRX_REMARKS",Override_remarks);
									}
									if(limit_ind.equals("N")){
										ext_drugData.put("DOSE_OVERRIDE","Y");
										ext_drugData.put("DOSE_REMARKS",Override_remarks);
									}
									if( allergy_yn.equals("Y")){
										ext_drugData.put("ALLERGY_OVERRIDE","Y");
										ext_drugData.put("ALLERGY_REMARKS",Override_remarks);
									}
									if( interaction_exists.equals("Y")){ //Added for	RUT-CRF-0066 IN[029604] - start
										ext_drugData.put("DRUGINTRACTION_OVERRIDE","Y");
										ext_drugData.put("INTERACTION_REMARKS",Override_remarks);
									} //Added for	RUT-CRF-0066 IN[029604] - end
									ext_drugData.put("Override_Check",override_check);
								}
								break;
							}
						}
						tapered_over = ext_drugData.get("TAPPERED_OVER")==null?"":(String)ext_drugData.get("TAPPERED_OVER");
						if(tapered_over.equals("Y")){
							for(int j=0;j<prescriptionDetails.size();j++){
								prev_extdrugData =  (HashMap) addprescriptionDetails.get(j);
								ext_drug_code=(String) prev_extdrugData.get("DRUG_CODE");
								ext_srl_no=(String) prev_extdrugData.get("SRL_NO");
								if(prev_extdrugData!=null){
									if(drugCode.equals(ext_drug_code) &&! (String.valueOf(srl_no)).equals(ext_srl_no)){
										if(prev_extdrugData.get("FREQ_NATURE")!=null && !((prev_extdrugData.get("FREQ_NATURE")).equals("O")) && !((prev_extdrugData.get("FREQ_NATURE")).equals("P"))) {
											prev_extdrugData.put("DRUG_TAPERED_YN","Y");
											prev_extdrugData.put("TOTTAPPERQTY",(String)ext_drugData.get("TOTTAPPERQTY")==null?"1":(String)ext_drugData.get("TOTTAPPERQTY"));	 //Commented for RUT-CRF-0088 [IN036978] 
											prev_extdrugData.put("BL_ERROR_CODE",(String)ext_drugData.get("BL_ERROR_CODE")==null?"":(String)ext_drugData.get("BL_ERROR_CODE"));
											prev_extdrugData.put("BL_SYS_MESSAGE_ID",(String)ext_drugData.get("BL_SYS_MESSAGE_ID")==null?"":(String)ext_drugData.get("BL_SYS_MESSAGE_ID"));                        
											prev_extdrugData.put("BL_ERROR_TEXT",(String)ext_drugData.get("BL_ERROR_TEXT")==null?"":(String)ext_drugData.get("BL_ERROR_TEXT"));  
										}
									}
								}
							}
						}
					}
				}
			}
			else if(oper_mode.equals("modify") || oper_mode.equals("tapered") ){
				ext_drugData		=	null;
				String drug_code			=	null;
				String allow_pres_without_stock_yn	=	null;
				ext_drug_code	=	null;
				String ext_srl_no		=	null;
				String drug_tapered, tapered_over;
				String drugCode			= (String)hash.get("drug_code");
				String srlNo			= (String)hash.get("srl_no");
				String durn_value		= ((String)hash.get("durn_value")).trim();
				String qty_value		= ((String)hash.get("qty_value")).trim();
				String freq				= (String)hash.get("frequency");
				String freq_desc        = (String) hash.get("freq_desc");
				freq_desc = java.net.URLDecoder.decode(freq_desc,"UTF-8");
				String repeat_value		= (String)hash.get("repeat_value");
				String dosage			= ((String)hash.get("dosage")).trim();
				String pres_base_uom	= (String)hash.get("pres_base_uom");
				//String qty_desc			= (String)hash.get("qty_desc_code");
				String qty_desc_code	= (String)hash.get("qty_desc");
				String ph_version		= (String)hash.get("ph_version");
				String end_date			= (String)hash.get("end_date");
				String start_date		= (String)hash.get("start_date");
				String dosage_type		= (String) hash.get( "dosage_type" );
				String absol_qty		= (String) hash.get("absol_qty");
				String brought_by_pat	= (String) hash.get("brought_by_pat");
				String freq_nature		= (String) hash.get("freq_nature");
				String current_rx		= (String) hash.get("current_rx");
				String allow_duplicate	= (String) hash.get("allow_duplicate");
				String patient_class	= (String) hash.get("patient_class");
				String take_home		= (String) hash.get("take_home");
				String pat_counseling_reqd	=( ((String)hash.get("pat_counseling_reqd")) ==null)?"N":(String)hash.get("pat_counseling_reqd") ;
				String override_check		= (String) hash.get("override_remarks");
				String checkEnabled			= (String) hash.get("checkEnabled");
				String disp_locn_code		= (String)hash.get("disp_locn_code");
				String drug_db_dosecheck_yn  = (String)hash.get("drug_db_dosecheck_yn")==null?"":(String)hash.get("drug_db_dosecheck_yn");
				ext_prod_id			 = (String)hash.get("ext_prod_id")==null?"":(String)hash.get("ext_prod_id");
				String pract_name			 = (String) hash.get("pract_name");
				String stat_y			= (String)hash.get("stat_yn")==null?"N":(String)hash.get("stat_yn");   //AAKH-CRF-0091 
				String parent_stat_y			= (String)hash.get("parent_stat_yn")==null?"N":(String)hash.get("parent_stat_yn");  //AAKH-CRF-0091 
				String override_select_appl	=( ((String)hash.get("override_select_appl")) ==null)?"N":(String)hash.get("override_select_appl") ;//Added for IN:073485
				if(!locale.equals("en")){
					end_date = DateUtils.convertDate(end_date, "DMYHM",locale,"en");
					start_date = DateUtils.convertDate(start_date, "DMYHM",locale,"en");
				} 
				if(repeat_value==null || repeat_value.equals(""))
					repeat_value="1";
				int drug_index=0;
				boolean can_modify	= true;
				if(oper_mode.equals("tapered")){
					new_qty			    =	Float.parseFloat(qty_value);
					new_repeat_value	=	Integer.parseInt(repeat_value);
					//added on 14/04/2010 -- priya
					if(split_dose_yn_val!=null && !split_dose_yn_val.equals("Y"))
						new_total_qty	=	(new_qty*new_repeat_value);
					else 
						new_total_qty = new_qty;
					//	new_total_qty		=	(new_qty*new_repeat_value);
					int srl_no				= bean.getSrlNo()-1;
					durnValue		=	"";    
					freq_code		=	"";    
					qtyValue			=	"";
					total_qty_value	=	"";
					for(int j=0;j<addprescriptionDetails.size();j++){//Added for	RUT-CRF-0066 IN[029604] - start
						addext_drugData		=	(HashMap) addprescriptionDetails.get(j);
						addext_drug_code	=	(String) addext_drugData.get("DRUG_CODE");
						addext_srl_no		=	(String) addext_drugData.get("SRL_NO");
						ext_prod_id=  (String) addext_drugData.get("EXTERNAL_PRODUCT_ID")==null?"":(String) addext_drugData.get("EXTERNAL_PRODUCT_ID");
						if( drugCode.equals(addext_drug_code) && srlNo.equals(addext_srl_no)){ //GHL-CRF-0549 
							addext_drugData.put("allow_alternate_yn",allow_alternate_yn);
						}
						if((!drug_db_interface_yn.equals("Y")) || ext_prod_id.equals("")){
							if( drugCode.equals(addext_drug_code) && srlNo.equals(addext_srl_no)){
								addext_drugData.put("INTERACTION_EXISTS", "N" );
								//addext_drugData.put("INTR_MSG_CONTENT","");
								addext_drugData.put("INTR_RESTRIC_TRN","N");
								st_date_local = (String) hash.get("start_date");
								end_date_local =  (String) hash.get("end_date");
								if(!locale.equals("en")){
									st_date_local =  DateUtils.convertDate(st_date_local, "DMYHM",locale,"en");
									end_date_local =  DateUtils.convertDate(end_date_local, "DMYHM",locale,"en");
								}
								alDrugIntrDtlList = bean.getDrugInteractionDtls(addext_drug_code,  (String) addext_drugData.get("FORM_CODE"),(String) addext_drugData.get("GENERIC_ID"),st_date_local,end_date_local , patient_id);
								if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()>2){
									severity_level = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2);
									intr_restric_trn = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1);
									addext_drugData.put("INTR_RESTRIC_TRN", intr_restric_trn );
									addext_drugData.put("INTERACTION_DTL", alDrugIntrDtlList );
									addext_drugData.put("INTERACTION_EXISTS", "Y" );
									//added for PMG2020-ICN-001- start
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
											addext_drugData.put("DRUG_INTERACTION_EXISTS","Y");
										}
										if(intrType.contains("F")){
											addext_drugData.put("FOOD_INTERACTION_EXISTS","Y");
										}
										if(intrType.contains("L")){
											addext_drugData.put("LAB_INTERACTION_EXISTS","Y");
										}
										if(intrType.contains("I")){//Added for MMS-DM-CRF-0229
									        temp.put("DISEASE_INTERACTION_EXISTS","Y");
								         }
									}
								   } //added for PMG2020-ICN-001- end
									if(intr_restric_trn.equals("Y") ){
										addext_drugData.put("INTR_ALERT","Y");
										if(addext_drugData.get("AMEND_YN")!=null && ((String)addext_drugData.get("AMEND_YN")).equals("Y"))
											out.println("alertIntr('"+drugCode+"','"+srlNo+"','"+patient_id+"','"+encounter_id+"','N');");
										//addext_drugData.put("INTR_MSG_CONTENT",intr_msg_content);
										//if(addext_drugData.get("AMEND_YN")!=null && ((String)addext_drugData.get("AMEND_YN")).equals("Y"))
										//out.println("alertIntr('"+(String)addext_drugData.get("DRUG_DESC")+"','"+intr_msg_content+"');");
										can_modify=false;
										break;
									}
								}
								else{
									addext_drugData.put("DRUGINTRACTION_OVERRIDE","N");
									addext_drugData.put("INTERACTION_REMARKS","");
								}
							}
						}
					}//Added for	RUT-CRF-0066 IN[029604] - end
					if(can_modify){ 
						for(int j=0;j<addprescriptionDetails.size();j++){
							addext_drugData		=	(HashMap) addprescriptionDetails.get(j);
							addext_drug_code	=	(String) addext_drugData.get("DRUG_CODE");
							addext_srl_no		=	(String) addext_drugData.get("SRL_NO");
							if( drugCode.equals(addext_drug_code) && (Float.parseFloat(srlNo) == (Float.parseFloat(addext_srl_no))+1) ){
								durnValue	    =  (String) addext_drugData.get("DURN_VALUE");
								freq_code	    =  (String) addext_drugData.get("FREQ_CODE");
								qtyValue	    =  (String) addext_drugData.get("QTY_VALUE");
								total_qty_value =  (String) addext_drugData.get("TOTAL_QTY_VALUE");
								ext_total_qty_value   = Float.parseFloat(total_qty_value.trim());
								taper_up_yn					=  (String)addext_drugData.get("TAPER_UP")==null?"":(String)addext_drugData.get("TAPER_UP");
								taper_down_yn				=  (String) addext_drugData.get("TAPER_DOSE_YN")==null?"":(String) addext_drugData.get("TAPER_DOSE_YN");
								if(taper_up_yn.equals("Y")||taper_down_yn.equals("Y"))
									multiFreq_yn = "N";
								else
									multiFreq_yn = "Y";
								if(((String) addext_drugData.get("TAPER_UP")).equals("N") && multiFreq_yn.equals("N")){
									if( (new_total_qty >= ext_total_qty_value)){
										can_modify=false;
										out.println("alertNoTaper('greater')") ;
										break;
									}
								}	
								else if (multiFreq_yn.equals("N")){
									if( (new_total_qty <= ext_total_qty_value)){
										can_modify=false;
										out.println("alertNoTaper('lesser')") ;
										break;
									}
								}
								if(freq.equals(freq_code) && qty_value.equals(qtyValue) ){
									if(multiFreq_yn.equals("N")){
										can_modify=false;
										out.println("alertNoTaper('nochange')") ;
										break;
									}
									else{
										if(split_dose_yn_val.equals("N")){
											can_modify=false;
											out.println("alertNoTaper('nochange')") ;
											break;
										}
										else{
											ArrayList	schedule_prev	=	(ArrayList)bean.getScheduleFrequencyStr(drugCode+srlNo,"0");
											ArrayList	schedule_curr	=	(ArrayList)bean.getScheduleFrequencyStr(drugCode+srl_no,"0");

											can_modify = false;
											for(int i=0;i<schedule_prev.size();i++){
												if(!((String)((HashMap)schedule_prev.get(i)).get("admin_qty")).equals((String)((HashMap)schedule_curr.get(i)).get("admin_qty"))){
													can_modify=true;
													break;
												}
											}
											if(!can_modify){
												out.println("alertNoTaper('nochange')") ;
												break;
											}
										}
									}
								}
								else{
									can_modify=true;
								}
								break;
							}
						}
					} //Added for	RUT-CRF-0066 IN[029604]
				}
				String durn_Value="", freq_chng_durn_value="", freq_chng_durn_desc="";  //Added for MAR Live issue
				if(oper_mode.equals("modify") && order_set_code.equals("")){
					for(int j=0;j<addprescriptionDetails.size();j++){
						addext_drugData		=	(HashMap) addprescriptionDetails.get(j);
						addext_drug_code	=	(String) addext_drugData.get("DRUG_CODE");
						addext_srl_no		=	(String) addext_drugData.get("SRL_NO");
						ext_prod_id=  (String) addext_drugData.get("EXTERNAL_PRODUCT_ID")==null?"":(String) addext_drugData.get("EXTERNAL_PRODUCT_ID");
						// This code disallows same drug with same frequency nature for PRN and Stat frequencies --25/03/2010-- priya
							if( drugCode.equals(addext_drug_code) && !((String.valueOf(srlNo)).equals(addext_srl_no))){
							//	String curr_drug_freq_nature = (String) hash.get("freq_nature")==null?"":(String)hash.get("freq_nature");
								if(addext_drugData.containsKey("FREQ_NATURE")){
									String exist_drug_freq_nature = (String)addext_drugData.get("FREQ_NATURE")==null?"":(String)addext_drugData.get("FREQ_NATURE");
									if((freq_nature.equals("P") || freq_nature.equals("O")) && (exist_drug_freq_nature.equals("P") || exist_drug_freq_nature.equals("O")) && (freq_nature.equals(exist_drug_freq_nature))){										
										out.println("alertNoTaper('changefreq');");
										break;
									}
								}
							}
							if( drugCode.equals(addext_drug_code) && ((String.valueOf(srlNo)).equals(addext_srl_no))){//Added for MAR Live issue -start
								durn_Value = (String)addext_drugData.get("DURN_VALUE")==null?"": (String)addext_drugData.get("DURN_VALUE"); 
								repeat_durn_type = (String)addext_drugData.get("REPEAT_DURN_TYPE")==null?"": (String)addext_drugData.get("REPEAT_DURN_TYPE"); 
								freq_chng_durn_value = (String)addext_drugData.get("freq_chng_durn_value")==null?"": (String)addext_drugData.get("freq_chng_durn_value");
								freq_chng_durn_desc = (String)addext_drugData.get("freq_chng_durn_desc")==null?"": (String)addext_drugData.get("freq_chng_durn_desc");
								if(repeat_durn_type.equals(freq_chng_durn_desc) && !durn_Value.equals(freq_chng_durn_value)){
									out.println("alert('APP-PH000001 Duration value is not updated. Kindly check the duration.');");
									return;
								} 
							}//Added for MAR Live issue -end
							if((!drug_db_interface_yn.equals("Y")) || ext_prod_id.equals("")){//Added for	RUT-CRF-0066 IN[029604] - start
								if( drugCode.equals(addext_drug_code) && ((String.valueOf(srlNo)).equals(addext_srl_no))){
									addext_drugData.put("INTERACTION_EXISTS", "N" );
									addext_drugData.put("INTR_MSG_CONTENT","");
									addext_drugData.put("INTR_RESTRIC_TRN","N");
									st_date_local = (String) hash.get("start_date");
									end_date_local =  (String) hash.get("end_date");
									if(!locale.equals("en")){
										st_date_local =  DateUtils.convertDate(st_date_local, "DMYHM",locale,"en");
										end_date_local =  DateUtils.convertDate(end_date_local, "DMYHM",locale,"en");
									}
									alDrugIntrDtlList = bean.getDrugInteractionDtls(addext_drug_code, (String) addext_drugData.get("FORM_CODE"), (String) addext_drugData.get("GENERIC_ID"),st_date_local,end_date_local , patient_id);
									if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()>2){
										severity_level = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2);
										intr_restric_trn = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1);
										addext_drugData.put("INTR_RESTRIC_TRN", intr_restric_trn );
										addext_drugData.put("INTERACTION_DTL", alDrugIntrDtlList );
										addext_drugData.put("INTERACTION_EXISTS", "Y" );
									//added for PMG2020-ICN-001- start
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
											addext_drugData.put("DRUG_INTERACTION_EXISTS","Y");
										}
										if(intrType.contains("F")){
											addext_drugData.put("FOOD_INTERACTION_EXISTS","Y");
										}
										if(intrType.contains("L")){
											addext_drugData.put("LAB_INTERACTION_EXISTS","Y");
										}
										if(intrType.contains("I")){//Added for MMS-DM-CRF-0229
									        temp.put("DISEASE_INTERACTION_EXISTS","Y");
								         }
									}
								   } //added for PMG2020-ICN-001- end
										if(intr_restric_trn.equals("Y") ){
											addext_drugData.put("INTR_ALERT","Y");
											if(addext_drugData.get("AMEND_YN")!=null && ((String)addext_drugData.get("AMEND_YN")).equals("Y"))
												out.println("alertIntr('"+drugCode+"','"+srlNo+"','"+patient_id+"','"+encounter_id+"','N');");
											/*addext_drugData.put("INTR_MSG_CONTENT",intr_msg_content);
											if(addext_drugData.get("AMEND_YN")!=null && ((String)addext_drugData.get("AMEND_YN")).equals("Y"))
												out.println("alertIntr('"+(String)addext_drugData.get("DRUG_DESC")+"','"+intr_msg_content+"');");*/
											can_modify=false;
											break;
										}
									}
									else{
										addext_drugData.put("DRUGINTRACTION_OVERRIDE","N");
										addext_drugData.put("INTERACTION_REMARKS","");
									}
								}
							}//Added for	RUT-CRF-0066 IN[029604] -end
							/*if( drugCode.equals(addext_drug_code) && (Float.parseFloat(srlNo) != (Float.parseFloat(addext_srl_no)))){
								//if(freq_nature.equals((String) addext_drugData.get("FREQ_NATURE")) && ((String)addext_drugData.get("TAPER_DOSE_YN")).equals("Y")){
								if(freq.equals((String) addext_drugData.get("FREQ_CODE")) && ((String)addext_drugData.get("TAPER_DOSE_YN")).equals("Y")){
									can_modify = false;
									out.println("alertNoTaper('changefreq');");
									break;
								}
							}*/
					}
				}
				if(can_modify){
					if(pract_name==null && pract_name.equals("null"))
						pract_name="";
					if(override_check==null)
						override_check="";
					if(checkEnabled==null)
						checkEnabled="";
					if(brought_by_pat == null) {
						brought_by_pat		=	"";
					} 
					if(absol_qty == null || absol_qty == "")
						 absol_qty		=	"1";

					if(current_rx.equals("Y") && allow_duplicate.equals("N") && !freq_nature.equals("O")) { // (patient_class.equals("IP") || Integer.parseInt(take_home)>0) && 
						out.println("duplicateWarning()");
						return;
					}
					ArrayList	schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drugCode+srlNo,"0");
					String sch_size			=	"";
					if(schedule.size() > 0) {
						/*HashMap detail	=	(HashMap)schedule.get(0);
						 qty_value		=	(String)detail.get("admin_qty");*/
						 ArrayList dose_list		= (ArrayList)schedule.get(4);
						 if(dose_list!=null && dose_list.size()>0)
							 qty_value		= (String)dose_list.get(0);
						 //sch_size		=	""+schedule.size();
						 sch_size		=	""+dose_list.size();
					}
					else {
						sch_size		=	repeat_value;
					}
					boolean no_stock_allow=true;
					if( !(ph_version.equals("PHBASIC"))){
						bean.setDispLocation(srlNo,disp_locn_code);
						String consider_stock_for_pres_yn=(String)hash.get("consider_stock_for_pres_yn");
						String ext_disp_appl_yn = bean.getExtDispYN(disp_locn_code);//IN071763
						if(consider_stock_for_pres_yn != null && consider_stock_for_pres_yn.equals("Y") && ext_disp_appl_yn.equals("N") ){ // added ext_disp_appl_yn for  IN071763
							boolean no_stock_found	=	false;
							String conv_factor		=	"";
							ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
							if(dosage_type.equals("Q"))
								conv_factor = (String) bean.getConvFactor(qty_desc_code,pres_base_uom);
							String available_stock;HashMap stockValues = null;
							for(int j=0;j<prescriptionDetails.size();j++){
								ext_drugData		=(HashMap) prescriptionDetails.get(j);
								drug_code			=(String) ext_drugData.get("DRUG_CODE");
								allow_pres_without_stock_yn = (String)ext_drugData.get("ALLOW_PRES_WITHOUT_STOCK_YN")==null?"N":(String)ext_drugData.get("ALLOW_PRES_WITHOUT_STOCK_YN");
								if(drugCode.equals(drug_code)){
									if(((String)ext_drugData.get("IN_FORMULARY_YN")).equals("Y")) {
										if(consider_stock_for_pres_yn != null && consider_stock_for_pres_yn.equals("Y") && ext_disp_appl_yn.equals("N")){  // added ext_disp_appl_yn for  IN071763
											if(allow_pres_without_stock_yn.equals("N")){
												stockValues			=(HashMap) bean.chkStockAvail(drugCode,disp_locn_code,qty_value,end_date, trade_code);
												available_stock		=(String) stockValues.get("AVAILABLE_STOCK");
												if(dosage_type.equals("A") || freq_nature.equals("P")) {
													qty_value	=	absol_qty;
													dosage		=	"A";
												}
												if(Float.parseFloat(bean.getOrderQty(ext_drugData,qty_value,sch_size,durn_value,dosage,conv_factor)) > Float.parseFloat(available_stock)) {
													no_stock_allow=false;
													out.println("alertNoAvailStock('"+available_stock+"','"+(String)hash.get("stock_uom")+"')") ;
													break;
												}
											}
										}
									}
								}
							}//for
							if(no_stock_found){
								out.println("alertNoAvailStock()") ;
							} 
						}
						else{
							no_stock_allow=true;
						}
					}
					else{
						no_stock_allow=true;
					}
					if(no_stock_allow){
						new_qty=Float.parseFloat(qty_value);
						new_repeat_value=Integer.parseInt(repeat_value);
						durnValue	    =  hash.get("durn_value")==null?"1":(String) hash.get("durn_value");// Added for SRR20056-SCF-7524 -Start
						repeat_durn_type =hash.get("repeat_durn_type")==null?"":(String) hash.get("repeat_durn_type");
						durn_desc_code =hash.get("durn_desc")==null?"":(String) hash.get("durn_desc");
						interval_value		= hash.get("interval_value")==null?"1":(String) hash.get("interval_value");
						durnValue =	(String)bean.getFreqDurnConvValue(repeat_durn_type,durnValue,durn_desc_code);// Added for SRR20056-SCF-7524 -End
						new_total_qty=new_qty*new_repeat_value*(Integer.parseInt(durnValue)/Integer.parseInt(interval_value)); // added " *(Integer.parseInt(durnValue)/Integer.parseInt(interval_value))" for SRR20056-SCF-7524
						int codeCount_1		= 0;
						int codeCount_2		= 0;
						ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
						can_modify	= false;
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
						if(codeCount_1>1 && codeCount_2!=1 && order_set_code.equals("") && !totalTaperQtyDisplay.equals("Y")){
							can_modify=false;
							if(!parent_stat_y.equals("Y")){		//if() added for AAKH-CRF-0091 
								out.println("alertParentRecord('modify')") ;
							}
						}
						else{
							can_modify=true;
						}
						if(can_modify){
							prescriptionDetails=(ArrayList)bean.getpresDetails();
							HashMap prev_extdrugData;
							boolean dupCheck = false;
							String interaction_exists="", allergy_yn="", limit_ind="", Override_remarks="", drug_db_duptherapy_flag="";
							for(int j=0;j<prescriptionDetails.size();j++){
								ext_drugData	=	(HashMap) prescriptionDetails.get(j);
								ext_drug_code	=	(String) ext_drugData.get("DRUG_CODE");
								ext_srl_no		=	(String) ext_drugData.get("SRL_NO");
								ext_prod_id=  (String) ext_drugData.get("EXTERNAL_PRODUCT_ID")==null?"":(String) ext_drugData.get("EXTERNAL_PRODUCT_ID");//Added for ML-BRU-SCF-1423 [IN:050857]
								if( drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no) ){
									ext_drugData.put("AMEND_YN","Y");
									ext_drugData.put("ROUTE_CODE",(String) hash.get("route_code"));
									ext_drugData.put("PRIORITY",(String) hash.get("priority"));
									ext_drugData.put("BROUGHT_BY_PAT",brought_by_pat);
									ext_drugData.put("FREQ_NATURE",(String) hash.get("freq_nature"));
									ext_drugData.put("ROUTE_DESC",(String) hash.get("route_desc"));
									ext_drugData.put("DOSAGE_TYPE",(String) hash.get("dosage"));
									ext_drugData.put("FREQ_CODE",(String) hash.get("frequency"));
									ext_drugData.put("FREQ_DESC",(String) freq_desc);
									ext_drugData.put("QTY_VALUE",(String) hash.get("qty_value"));
									ext_drugData.put("QTY_DESC",(String) hash.get("qty_desc_code"));
									ext_drugData.put("QTY_DESC_CODE",(String) hash.get("qty_desc"));
									ext_drugData.put("REPEAT_VALUE",repeat_value);//(String) hash.get("repeat_value")
									ext_drugData.put("INTERVAL_VALUE",interval_value);//(String) hash.get("interval_value")
									ext_drugData.put("DURN_TYPE",(String) hash.get("repeat_durn_type"));
									ext_drugData.put("REPEAT_DURN_TYPE",(String) hash.get("repeat_durn_type"));
									ext_drugData.put("DURN_VALUE",(String) hash.get("durn_value"));
									ext_drugData.put("DURN_DESC",(String) hash.get("durn_desc"));
									ext_drugData.put("freq_chng_durn_desc",(String) hash.get("durn_desc"));					
									ext_drugData.put("patient_stock_yn",patient_stock_yn);		//added for GHL-CRF-0482	
									ext_drugData.put("def_dose_value",def_dose_value);	//ARYU-CRF-014
									ext_drugData.put("dosage_change_yn",(String) hash.get("dosage_change_yn"));
									ext_drugData.put("SPLIT_DOSE",(String) hash.get("split_dose"));
									ext_drugData.put("SPLIT_DOSE_YN",(String) hash.get("split_dose_yn"));
									ext_drugData.put("SPLIT_DOSE_YN_VAL",(String) hash.get("split_dose_yn_val"));
									ext_drugData.put("TRADE_CODE",trade_code);
									ext_drugData.put("TRADE_NAME",trade_name);
									ext_drugData.put("BUILDMAR_YN",(String) hash.get("buildMAR_yn"));
									ext_drugData.put("DrugRemarksEntered",(String) hash.get("DrugRemarksEntered")); //Added for Antibiotic Screen using Order Entry Format ICN 29904
									ext_drugData.put("DRUG_INDICATION",DrugIndicationRemarks); 
									ext_drugData.put("PREG_REMARKS",preg_remarks);// added for CRF RUT-CRF-0063[29601] and code "PREG_REMRKS" is replaced by "PREG_REMARKS" for  IN040512
									//Added By Karabi..
									interaction_exists  =(String) ext_drugData.get("INTERACTION_EXISTS")==null?"N":(String) ext_drugData.get("INTERACTION_EXISTS"); //Added for	RUT-CRF-0066 IN[029604]
									allergy_yn  =(String) ext_drugData.get("ALLERGY_YN")==null?"N":(String) ext_drugData.get("ALLERGY_YN");
									limit_ind  =(String) ext_drugData.get("LIMIT_IND")==null?"N":(String) ext_drugData.get("LIMIT_IND");
									current_rx  =(String) ext_drugData.get("CURRENT_RX")==null?"":(String) ext_drugData.get("CURRENT_RX");
									drug_db_duptherapy_flag  = ext_drugData.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String) ext_drugData.get("DRUG_DB_DUPTHERAPY_FLAG");
									Override_remarks="";
									String abuse_exists	= (String)hash.get("abuse_exists");//aded for aakh-crf-0140
									String abuse_action	= (String)hash.get("abuse_action");//aded for aakh-crf-0140
									String abuse_override_remarks	=""; //aded for aakh-crf-0140
									
									if(abuse_action.equals("B")){//aded for aakh-crf-0140
										abuse_override_remarks				= java.net.URLDecoder.decode((String)hash.get("abuse_override_remarks")==null?"":(String)hash.get("abuse_override_remarks"),"UTF-8");
									}//if((!drug_db_dosecheck_yn.equals("Y")) || ext_prod_id.equals("")){
									if(!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("") || drug_db_duptherapy_yn.equals("N")){
										dupCheck = presBean.checkDuplicateDrug(patient_id, (String) ext_drugData.get("GENERIC_ID"), start_date,end_date, (String) hash.get("frequency"),"");
										if(!dupCheck && ext_drugData.get("ALERT_YN")==null){
											ext_drugData.put("CURRENT_RX","N");
										}
										if( (ext_drugData.get("ALERT_YN")!=null && (ext_drugData.get("CURRENTRX_REMARKS")==null || ((String)ext_drugData.get("CURRENTRX_REMARKS")).equals("") ) ) || dupCheck) {
											if(dupCheck){//if block added for Bru-HIMS-CRF-0265 [IN032315]
												ext_drugData.put("CURRENT_RX","Y");
												//ext_drugData.put("ORIG_CURRENT_RX","Y"); //commented forHSA-CRF-0151 [IN:048468]
											}
											if(bean.getCancelDiscConDupOrders().equals("Y") && ((bean.getExternalpatient_id()==null) || (bean.getExternalpatient_id().equals("") )) && ext_drugData.get("ORIG_CURRENT_RX")!=null && (((String)ext_drugData.get("ORIG_CURRENT_RX")).equals("Y") || drug_db_duptherapy_flag.equals("Y")) && dupCheck) { //added for Bru-HIMS-CRF-0265 [IN032315] //&&dupCheck added for for HSA-CRF-0138 [IN:048414] -54058
												ext_drugData.put("ORIG_CURRENT_RX","Y"); //Moved from above if for HSA-CRF-0151 [IN:048468]
												//out.println("showDuplicateInd('"+srlNo+"','R','"+(String) hash.get("sliding_scale_yn")+"');");
												out.println("enableDiscCancelOrders('"+patient_id+"', '"+encounter_id+"', '"+(String) ext_drugData.get("GENERIC_ID")+"', '"+start_date+"', '"+end_date+"', '"+(String) hash.get("frequency")+"', '"+drugCode+"', '"+srlNo+"', '"+drug_db_interface_yn+"', '"+ext_prod_id+"', 'C', '"+(String) hash.get("sliding_scale_yn")+"');");
											}
										}
										// Modified for IN:073485 start
										if(override_check.equals("Y") && !checkEnabled.equals("disabled")){											
											if(current_rx.equals("Y")){
												Override_remarks=(String)ext_drugData.get("CURRENTRX_REMARKS");
												if(Override_remarks==null || Override_remarks.equals("")){
													if(override_select_appl.equals("Y")){
														Override_remarks="";
													}
													else{
														Override_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
													}
												}
													
												 ext_drugData.put("CURRENTRX_OVERRIDE","Y");
												 ext_drugData.put("CURRENTRX_REMARKS",Override_remarks);
											}
											if(limit_ind.equals("N")){
												Override_remarks=(String)ext_drugData.get("DOSE_REMARKS");
												if(Override_remarks==null || Override_remarks.equals("")){
													if(override_select_appl.equals("Y")){
														Override_remarks="";
													}
													else{
														Override_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
													}
												}
												ext_drugData.put("DOSE_OVERRIDE","Y");
												ext_drugData.put("DOSE_REMARKS",Override_remarks);
											}
											if( allergy_yn.equals("Y")){
												Override_remarks=(String)ext_drugData.get("ALLERGY_REMARKS");
												if(Override_remarks==null || Override_remarks.equals("")){
													if(override_select_appl.equals("Y")){
														Override_remarks="";
													}
													else{
														Override_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
													}
												}
												ext_drugData.put("ALLERGY_OVERRIDE","Y");
												ext_drugData.put("ALLERGY_REMARKS",Override_remarks);
											}
											if(abuse_exists.equals("Y")&& abuse_action.equals("B")){
												Override_remarks=(String)ext_drugData.get("abuse_override_remarks");
												if(Override_remarks==null || Override_remarks.equals("")){
													
														Override_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
													
												}
												ext_drugData.put("ABUSE_OVERRIDE","Y");
												ext_drugData.put("abuse_override_remarks",Override_remarks);
											}
											if( interaction_exists.equals("Y") && (ext_drugData.get("DRUGINTRACTION_OVERRIDE")==null || !((String)ext_drugData.get("DRUGINTRACTION_OVERRIDE")).equals("Y"))){//Added for	RUT-CRF-0066 IN[029604] - start
												if(Override_remarks==null || Override_remarks.equals("")){
													if(override_select_appl.equals("Y")){
														Override_remarks="";
													}
													else{
														Override_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
													}
												}
												ext_drugData.put("DRUGINTRACTION_OVERRIDE","Y");
												ext_drugData.put("INTERACTION_REMARKS",Override_remarks);
											//added for MMS-KH-CRF-0029 - start
												if(ext_drugData.containsKey("FOOD_INTERACTION_EXISTS")){
													if(((String)ext_drugData.get("FOOD_INTERACTION_REMARKS"))==null || ((String)ext_drugData.get("FOOD_INTERACTION_REMARKS")).equals("") )
													ext_drugData.put("FOOD_INTERACTION_REMARKS",Override_remarks);
												}
												if(ext_drugData.containsKey("LAB_INTERACTION_EXISTS")){
													if(((String)ext_drugData.get("LAB_INTERACTION_REMARKS"))==null || ((String)ext_drugData.get("LAB_INTERACTION_REMARKS")).equals("") )
													ext_drugData.put("LAB_INTERACTION_REMARKS",Override_remarks);
												} //added for MMS-KH-CRF-0029 - end
												System.out.println(abuse_exists+" abuse_existsvalidation1"+abuse_action);
												if(abuse_exists.equals("Y")&& abuse_action.equals("B") && abuse_override_remarks !="") {//added for aakh-crf-0140
													
													ext_drugData.put("abuse_override_remarks",abuse_override_remarks);
													ext_drugData.put("ABUSE_OVERRIDE","Y");
													
												}
												if(ext_drugData.containsKey("DISEASE_INTERACTION_EXISTS")){//Added for MMS-DM-CRF-0229
													if(((String)ext_drugData.get("DISEASE_INTERACTION_EXISTS"))==null || ((String)ext_drugData.get("DISEASE_INTERACTION_EXISTS")).equals("") )
													ext_drugData.put("DISEASE_INTERACTION_EXISTS",Override_remarks);
												} 
											} //Added for	RUT-CRF-0066 IN[029604] - end
											ext_drugData.put("Override_Check",override_check);
										}//End by Karabi
										// Modified for IN:073485 end
									} 												
									else if(ext_drugData.get("ATC_DUP_DRUG_CODE")!=null && !ext_drugData.get("ATC_DUP_DRUG_CODE").equals("")){ // below else condition is added for the incident no 27465 by chandrashekar
										Override_remarks=(String)ext_drugData.get("CURRENTRX_REMARKS");
										if(override_check.equals("Y") && !checkEnabled.equals("disabled")){
											if(Override_remarks==null || Override_remarks.equals("")){
												Override_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
											}
											ext_drugData.put("CURRENTRX_OVERRIDE","Y");
											ext_drugData.put("CURRENTRX_REMARKS",Override_remarks);
										}
										ext_drugData.put("Override_Check",override_check);
									}// adding end 
									if( !current_rx.equals("Y") && !interaction_exists.equals("Y") && !allergy_yn.equals("Y") && !limit_ind.equals("N") && !abuse_exists.equals("Y") ){ //override_check.equals("Y") && removed for ML-BRU-SCF-1423 [IN:050857]
										ext_drugData.put("Override_Check","N");
									} //if block Added for	RUT-CRF-0066 IN[029604]
									ext_drugData.put("START_DATE",(String) hash.get("start_date"));
									ext_drugData.put("END_DATE",(String) hash.get("end_date"));
									ext_drugData.put("OR_QTY_DESC",(String) hash.get("or_qty_desc"));
									ext_drugData.put("DFLT_QTY_UOM",(String) hash.get("dflt_qty_uom"));
									ext_drugData.put("SCHEDULED_YN",(String) hash.get("scheduled_yn"));
									ext_drugData.put("AUTH_YN_VAL",(String) hash.get("authroize_yn_val"));
									ext_drugData.put("APPROVAL_YN_VAL",(String) hash.get("approval_yn_val"));
									ext_drugData.put("COSIGN_YN_VAL",(String) hash.get("cosign_yn_val"));
									ext_drugData.put("ALLOW_REFILL",(String) hash.get("allow_refill"));
									ext_drugData.put("NO_REFILL",(String) hash.get("no_refill"));
									ext_drugData.put("REFILL_START_DATE",(String) hash.get("refill_start_date"));
									ext_drugData.put("REFILL_END_DATE",(String) hash.get("refill_end_date"));
									ext_drugData.put("ADMIN_TIME",(String) hash.get("admin_time"));
									ext_drugData.put("ADMIN_QTY",(String) hash.get("admin_qty"));
									ext_drugData.put("TOTAL_QTY_VALUE",""+new_total_qty);
									ext_drugData.put("TOT_STRENGTH",(String) hash.get("in_total_strength"));
									ext_drugData.put("TOT_STRENGTH_UOM",(String) hash.get("in_total_strength_uom"));
									ext_drugData.put("DISPENSED_QTY",(String) hash.get("in_dispensed_qty"));
									ext_drugData.put("DISPENSED_UOM",(String) hash.get("in_dispensed_uom"));
									ext_drugData.put("BMS_QTY",(String) hash.get("in_bms_qty"));
									ext_drugData.put("SCH_OVER_YN",(String) hash.get("sch_over_yn"));
									ext_drugData.put("LIMIT_IND",(String) hash.get("limit_ind"));
									ext_drugData.put("MONO_GRAPH",(String) hash.get("mono_graph"));
									ext_drugData.put("UNIT_DOSE",(String) hash.get("unit_dose"));
									ext_drugData.put("DAILY_DOSE",(String) hash.get("daily_dose"));
									ext_drugData.put("ABSOL_QTY",absol_qty);
									ext_drugData.put("STOCK_AVAILABLE_YN","Y");
									ext_drugData.put("PAT_COUNSELING_REQD",pat_counseling_reqd);
									ext_drugData.put("BL_INCL_EXCL_OVERRIDE_REASON_CODE",bl_incl_excl_override_reason_code);
									ext_drugData.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC",bl_incl_excl_override_reason_desc);
									ext_drugData.put("DrugRemarksEntered",DrugRemarksEntered); //Added for Antibiotic Screen using Order Entry Format ICN 29904
									ext_drugData.put("TOTTAPPERQTY",(String) hash.get("totTapperQty"));  //Commented for RUT-CRF-0088 [IN036978] -- begin
									ext_drugData.put("PREVTOTTAPPERQTY",(String) hash.get("prevTotalTaperQty"));
									ext_drugData.put("TAP_LVL_QTY",hash.get("tap_lvl_qty").toString());
									ext_drugData.put("DRUG_INDICATION",DrugIndicationRemarks);
									ext_drugData.put("PREG_REMARKS",preg_remarks);// added for CRF RUT-CRF-0063[29601] and code "PREG_REMRKS" is replaced by "PREG_REMARKS" for  IN040512 
									//ext_drugData.put("BL_DEF_OVERRIDE_EXCL_INCL_IND",bl_def_override_excl_incl_ind);
									//	if(bl_override_excl_incl_ind.equals("SEL"))
						                //  bl_override_excl_incl_ind ="";
									ext_drugData.put("BL_OVERRIDE_EXCL_INCL_IND",bl_override_excl_incl_ind); //priya
									if( bean.getExternalpatient_id()!=null &&  !((String)bean.getExternalpatient_id()).equals("") )
										ext_drugData.put("DISP_LOCN_CODE",(String) hash.get("disp_locn_code"));
									if( (!((String) hash.get("dosage")).equals("A"))&&(ext_drugData.get("TAPER_DOSE_YN").equals("Y")|| ext_drugData.get("TAPER_UP").equals("Y"))&&(!(ext_drugData.get("FREQ_NATURE").equals("P")||ext_drugData.get("FREQ_NATURE").equals("O"))))
										ext_drugData.put("PROVIDE_TAPER","Y");
									else
										ext_drugData.put("PROVIDE_TAPER","N");
									/*if(ext_drugData.get("PROVIDE_TAPER").equals("Y"))
										ext_drugData.put("TAPER_DOSE_YN", "Y");
									else
										ext_drugData.put("TAPER_DOSE_YN", "N");*/
									break;
								}
							}
							tapered_over = ext_drugData.get("TAPPERED_OVER")==null?"":(String)ext_drugData.get("TAPPERED_OVER");
							if(tapered_over.equals("Y")){
								for(int j=0;j<prescriptionDetails.size();j++){
									prev_extdrugData =  (HashMap) addprescriptionDetails.get(j);
									ext_drug_code=(String) prev_extdrugData.get("DRUG_CODE");
									ext_srl_no=(String) prev_extdrugData.get("SRL_NO");
									if(prev_extdrugData!=null){
										if(drugCode.equals(ext_drug_code) && !srlNo.equals(ext_srl_no)){
											if(prev_extdrugData.get("FREQ_NATURE")!=null && !((prev_extdrugData.get("FREQ_NATURE")).equals("O")) && !((prev_extdrugData.get("FREQ_NATURE")).equals("P"))){
												prev_extdrugData.put("DRUG_TAPERED_YN","Y");   //Commented for RUT-CRF-0088 [IN036978]
												prev_extdrugData.put("TOTTAPPERQTY",(String)ext_drugData.get("TOTTAPPERQTY")==null?"1":(String)ext_drugData.get("TOTTAPPERQTY"));
												/*prev_extdrugData.put("BL_TOTAL_CHARGE_AMT",(String)ext_drugData.get("BL_TOTAL_CHARGE_AMT")==null?"0.0":(String)ext_drugData.get("BL_TOTAL_CHARGE_AMT"));
												prev_extdrugData.put("BL_PATIENT_PAYABLE_AMT",(String)ext_drugData.get("BL_PATIENT_PAYABLE_AMT")==null?"0.0":(String)ext_drugData.get("BL_PATIENT_PAYABLE_AMT")); 
												prev_extdrugData.put("BL_APPROVAL_REQD_YN",(String)ext_drugData.get("BL_APPROVAL_REQD_YN")==null?"N":(String)ext_drugData.get("BL_APPROVAL_REQD_YN"));	
												prev_extdrugData.put("BL_OVERRIDE_ALLOWED_YN",(String)ext_drugData.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)ext_drugData.get("BL_OVERRIDE_ALLOWED_YN")); 
												prev_extdrugData.put("BL_DEF_OVERRIDE_EXCL_INCL_IND",(String)ext_drugData.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"":(String)ext_drugData.get("BL_DEF_OVERRIDE_EXCL_INCL_IND"));*/
												prev_extdrugData.put("BL_ERROR_CODE",(String)ext_drugData.get("BL_ERROR_CODE")==null?"":(String)ext_drugData.get("BL_ERROR_CODE"));	prev_extdrugData.put("BL_SYS_MESSAGE_ID",(String)ext_drugData.get("BL_SYS_MESSAGE_ID")==null?"":(String)ext_drugData.get("BL_SYS_MESSAGE_ID"));                        
												prev_extdrugData.put("BL_ERROR_TEXT",(String)ext_drugData.get("BL_ERROR_TEXT")==null?"":(String)ext_drugData.get("BL_ERROR_TEXT"));     
											}
										}
									}
								}
							}
						}
					}
					schedule	=	null;
				}
			}
			else if(oper_mode.equals("delete")){
				String drugCode		= (String)hash.get("drug_code");
				String srlNo		= (String)hash.get("srl_no");
				String generic_id		= (String)hash.get("generic_id");//Added generic id for TTM-SCF-0073[IN046928]
				int sno= 0;//Added for RUT-SCF-0320[IN044815]
				if(srlNo!=null && srlNo.trim().length()>0)//Added for RUT-SCF-0320[IN044815]
					sno  = Integer.parseInt(srlNo);//Added for RUT-SCF-0320[IN044815]
				//String patient_id	= (String)hash.get("patient_id");
				//String encounter_id	= (String)hash.get("encounter_id");
				String called_from	= (String)hash.get("called_from")==null?"":(String)hash.get("called_from");
				String search_bean_id	="@DrugSearchBean"+patient_id+encounter_id;
				String search_bean_name	="ePH.DrugSearchBean";
				drugCode = drugCode.trim();
				srlNo = srlNo.trim();
				int drug_index	=	-1;
				String temp_freq_nature="";
				DrugSearchBean searchbean = (DrugSearchBean)getBeanObject( search_bean_id, search_bean_name , request) ;
				int remove_pos	=	0;
				ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
				int codeCount_1=0;
				int codeCount_2=0;
				ext_drugData	=	null;
				ext_drug_code	=	null;
				String ext_srl_no		=	null;
				String curr_yn    = "";
				parent_stat_yn="";   //AAKH-CRF-0091 
				stat_yn="";    //AAKH-CRF-0091 
				ArrayList atc_dup_drug_code = new ArrayList();
				
				ArrayList ext_drug = bean.getExternal_drugs(); // Added for MMS-KH-CRF-0016 - Start
				
				if(ext_drug.size()>0){ 
					ext_drug.remove(drugCode);
					bean.setExternal_drugs(ext_drug);
				} // Added for MMS-KH-CRF-0016 - End
				for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData      =  (HashMap) prescriptionDetails.get(j);
					curr_yn			  = "";
					// ext_drugData.put("CURRENT_RX",curr_yn);
					// ext_drugData.put("ATC_LEVEL_DUPLICATION","N");
					if(ext_drugData.containsKey("ATC_DUP_DRUG_CODE")){
						atc_dup_drug_code  =  (ArrayList) ext_drugData.get("ATC_DUP_DRUG_CODE");
						if(atc_dup_drug_code!=null && atc_dup_drug_code.contains(drugCode)){
							atc_dup_drug_code.remove(drugCode);
						}
						if(ext_drugData.get("GENERIC_ID").equals(generic_id))//Added to clear atc drugcode on same generic id for TTM-SCF-0073[IN046928]
							atc_dup_drug_code.clear();
						
						//ext_drugData.put("CURRENT_RX",curr_yn);
						// commented aboveline and added in if condition below for the incident no.SRR20056-SCF-7745 [Incident No. 28045] and added braces for ifcondition.
						if(!(atc_dup_drug_code.size()>0)) {
							ext_drugData.put("CURRENT_RX",curr_yn);
							ext_drugData.put("ATC_LEVEL_DUPLICATION","N");
							ext_drugData.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
							//ext_drugData.put("ATC_DUP_DRUG_CODE",null);
							ext_drugData.put("CURRENTRX_REMARKS","");
							if(ext_drugData.containsKey("ALERT_YN"))
								ext_drugData.remove("ALERT_YN");
						}
					}
					if(ext_drugData.containsKey("ATC_LEVEL4_DUP_DRUG_CODE")){
						atc_dup_drug_code  =  (ArrayList) ext_drugData.get("ATC_LEVEL4_DUP_DRUG_CODE");
						if(atc_dup_drug_code!=null && atc_dup_drug_code.contains(drugCode)){
							atc_dup_drug_code.remove(drugCode);
						}
						//ext_drugData.put("CURRENT_RX",curr_yn);
						// commented aboveline and added in if condition below for the incident no.SRR20056-SCF-7745 [Incident No. 28045] and added braces for ifcondition.
						if(!(atc_dup_drug_code.size()>0))	{
							ext_drugData.put("CURRENT_RX",curr_yn);
							ext_drugData.put("ATC_LEVEL4_DUPLICATION","N");
							ext_drugData.put("ATC_LEVEL4_DUP_DRUG_CODE",atc_dup_drug_code);
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
					temp_freq_nature = ext_drugData.get("FREQ_NATURE")==null?"": (String) ext_drugData.get("FREQ_NATURE");
					if( !(temp_freq_nature.equals("P") || temp_freq_nature.equals("O"))){
						if(drugCode.equals(ext_drug_code)){
							codeCount_1++;
						}
						if(drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no))
							drug_index = j;
					}
				}
				if(codeCount_1>1){
					for(int k=drug_index; k<prescriptionDetails.size();k++){
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
					parent_stat_yn  = (String)ext_drugData.get( "parent_stat_yn" )==null?"N":(String)ext_drugData.get("parent_stat_yn");		//Added forAAKH-CRF-0091
					
					
					if( drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no)){
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
					bean.removePRNRemarks(drugCode);//Added for SKR-SCF-0647[Inc:35263]
					bean.clearCopiedDrugs(drugCode);
					if(prescriptionDetails.size()>0 && remove_pos>0){
						ext_drugData=(HashMap) prescriptionDetails.get(remove_pos-1);
						if(drugCode.equals((String)ext_drugData.get("DRUG_CODE")))
							ext_drugData.put("DRUG_TAPERED_YN","N");
							ext_drugData.put("parent_stat_yn","N");  //AAKH-CRF-0091 
							ext_drugData.put("stat_yn","N");  //AAKH-CRF-0091 
					}
					if(codeCount_1>0 && prescriptionDetails.size()>0){//Modified for RUT-SCF-0320[IN044815]
						HashMap prev_extdrugData=null;
						srlNo = (String)ext_drugData.get("SRL_NO");
						drugCode = (String)ext_drugData.get("DRUG_CODE");
						String tapered_over = ext_drugData.get("TAPPERED_OVER")==null?"":(String)ext_drugData.get("TAPPERED_OVER");
						if(tapered_over.equals("Y")){
							float tap_lvl_qty = 0;   //Added for RUT-CRF-0088 [IN036978]
							String Ccalled_from				= "ONCANCEL";
							float Cqty_value			= Float.parseFloat(ext_drugData.get("qty_value")==null?"1":(String) ext_drugData.get("qty_value"));
							float Crepeat_value			= Float.parseFloat( ext_drugData.get("repeat_value")==null?"1":(String) ext_drugData.get("repeat_value"));
							float Cdurn_value			= Float.parseFloat(ext_drugData.get("durn_value")==null?"1":(String) ext_drugData.get("durn_value"));
							float Cinterval_value			= Float.parseFloat( ext_drugData.get("interval_value")==null?"1":(String) ext_drugData.get("interval_value"));
							float totTapperQty = bean.getTotalTaperQty(drugCode, srlNo,Ccalled_from,Cqty_value,Crepeat_value,Cdurn_value,Cinterval_value);     //Commented and Added for RUT-CRF-0088 [IN036978]
							float prevTotTapperQty = bean.getTotalTaperQty(drugCode, srlNo,"PREVTOTQTY",Cqty_value,Crepeat_value,Cdurn_value,Cinterval_value);
							tap_lvl_qty=bean.getTotalTaperQty(drugCode, srlNo,Ccalled_from,Cqty_value,Crepeat_value,Cdurn_value,Cinterval_value);
							//tapQtyValues= bean.getTotalTaperQty(drugCode, srlNo,"PREVTOTQTY",Cqty_value,Crepeat_value,Cdurn_value,Cinterval_value);
							String tempsno = null;//Added for RUT-SCF-0320[IN044815]
							for(int j=0;j<prescriptionDetails.size();j++){
								prev_extdrugData =  (HashMap) addprescriptionDetails.get(j);
								ext_drug_code=(String) prev_extdrugData.get("DRUG_CODE");
								ext_srl_no=(String) prev_extdrugData.get("SRL_NO");
								tempsno = String.valueOf(sno);//Added for RUT-SCF-0320[IN044815]--start
								if(sno < Integer.parseInt(ext_srl_no)){
									prev_extdrugData.put("SRL_NO",tempsno);
									sno = sno+1;
								}//Added for RUT-SCF-0320[IN044815]--end
								if(prev_extdrugData!=null){
									if(drugCode.equals(ext_drug_code) ){
										if(prev_extdrugData.get("FREQ_NATURE")!=null && !((prev_extdrugData.get("FREQ_NATURE")).equals("O")) && !((prev_extdrugData.get("FREQ_NATURE")).equals("P"))){
											if(!srlNo.equals(ext_srl_no))
												prev_extdrugData.put("DRUG_TAPERED_YN","Y");
											prev_extdrugData.put("TOTTAPPERQTY",totTapperQty+"");    //Commented for RUT-CRF-0088 [IN036978]
											prev_extdrugData.put("PREVTOTALTAPERQTY",prevTotTapperQty+"");
										}
									}
								}
							}
						}
						else{
							ext_drugData.remove("DRUG_TAPERED_YN");
							ext_drugData.remove("TAP_LVL_QTY");
							ext_drugData.remove("TOTTAPPERQTY");
							ext_drugData.remove("PREVTOTALTAPERQTY");   //Commented for RUT-CRF-0088 [IN036978]
						}
					}
					//Added for	RUT-CRF-0066 IN[029604] - start
					String inrteraction_exists="",  restrict_transaction="N"; 
					for(int h=0;h<prescriptionDetails.size();h++){
						ext_drugData=(HashMap) prescriptionDetails.get(h);
						if(ext_drugData!=null){
							ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
							ext_srl_no=(String) ext_drugData.get("SRL_NO");
							ext_prod_id=  (String) ext_drugData.get("EXTERNAL_PRODUCT_ID")==null?"":(String) ext_drugData.get("EXTERNAL_PRODUCT_ID");
							if((!drug_db_interface_yn.equals("Y")) || ext_prod_id.equals("")){
								inrteraction_exists=(String) ext_drugData.get("INTERACTION_EXISTS")==null?"":(String) ext_drugData.get("INTERACTION_EXISTS");
								if(inrteraction_exists.equals("Y")){
									ext_drugData.put("INTERACTION_EXISTS", "N" );
									//ext_drugData.put("DRUGINTRACTION_OVERRIDE","N");
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
																			//added for PMG2020-ICN-001- start
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
								   } //added for PMG2020-ICN-001- end
									}
								}
							}
						}
					}
					//Added for	RUT-CRF-0066 IN[029604] - end
				HashMap suppDrugsMap = presBean.getSuppDrugMap();//Adding start for TH-KW-CRF-0007
				 if((suppDrugsMap!=null && suppDrugsMap.containsKey(drugCode))){
					    out.println("deleteSuppDrugs('"+drugCode+"')");
					 }//Adding end for TH-KW-CRF-0007
           out.println("deleteOROrderCatalog('"+drugCode+"','"+called_from+"')") ;
				}
				putObjectInBean(search_bean_id,searchbean,request);
				return;
			}
		}
		else if(func_mode != null && func_mode.equals("calculateQuantity")){
			String strength	= (String) hash.get( "strength" );
			String qty_uom		= (String) hash.get( "qty_uom" );
			String conv_factor = (String) bean.getConvFactor(strength,qty_uom);
			if(conv_factor!=null && !(conv_factor.equals(""))){
				out.println("updateConvFactor('"+conv_factor+"')");
			}
		}
		else if(func_mode != null && func_mode.equals("populateStartDate")){
			String sys_date		= (String) hash.get( "start_date" );
			String source		= (String) hash.get( "source" );
			String sliding_scale_yn = (String) hash.get( "sliding_scale_yn" )==null?"":(String) hash.get( "sliding_scale_yn" );
			String future_date	= "";
			String back_date    = "";
			if(!locale.equals("en"))
				sys_date = DateUtils.convertDate(sys_date, "DMYHM",locale,"en");
			HashMap dateParams=(HashMap) presBean.populateDateParams(sys_date);
			if(dateParams.size()>0){
				future_date=(String) dateParams.get("future_date");
				back_date=(String) dateParams.get("back_date");
			}
			if(!locale.equals("en"))
				sys_date = DateUtils.convertDate(sys_date, "DMYHM","en",locale);
			out.println("assignStartDate('"+source+"','"+sys_date+"','"+future_date+"','"+back_date+"','"+sliding_scale_yn+"')"); //passed sliding_scale_yn  for IN22255 
		}
		else if(func_mode != null && func_mode.equals("formGrouping")){
			String patient_id	= (String)hash.get("patient_id");
			String encounter_id	= (String)hash.get("encounter_id");
			String bed_num	    = (String)hash.get("bed_num")==null?"":(String)hash.get("bed_num");
			String room_num	    = (String)hash.get("room_num")==null?"":(String)hash.get("room_num");
			String buildMAR_yn	= (String)hash.get("buildMAR_yn")==null?"":(String)hash.get("buildMAR_yn");
			String split_drug_based_auth_yn	  = (String)hash.get("split_drug_based_auth_yn")==null?"":(String)hash.get("split_drug_based_auth_yn");//added for ml-mmoh-crf-0864
			int split_drug_based_auth_yn_cnt=1;//added for ml-mmoh-crf-0864
			String act_patient_class	      = (String)hash.get("act_patient_class")==null?"":(String)hash.get("act_patient_class");
			String split_based_priority_yn	  = (String)hash.get("split_based_priority_yn")==null?"":(String)hash.get("split_based_priority_yn");
			String split_based_drug_class_yn  = (String)hash.get("split_based_drug_class_yn")==null?"":(String)hash.get("split_based_drug_class_yn");
			String DrugRemarksEntered  = (String)hash.get("DrugRemarksEntered")==null?"":(String)hash.get("DrugRemarksEntered"); //Added for Antibiotic Screen using Order Entry Format ICN 29904
			String DrugIndicationRemarks            = (String) hash.get("DrugIndicationRemarks")==null?"":(String)hash.get("DrugIndicationRemarks");
			String function_from        = (String)hash.get("function_from")==null?"":(String)hash.get("function_from"); //added for JD-CRF-198 
			
		
			if(!DrugIndicationRemarks.equals(""))
				DrugIndicationRemarks = java.net.URLDecoder.decode(DrugIndicationRemarks,"UTF-8"); ;
			String record_gen		=	"";
			String priority			=	"";
			String patient_class	=	"";
			String home_medication	=	"";
			String consent_reqd_yn	=	"";
			patient_class	        =(String) hash.get( "patient_class" );
			home_medication     	=(String) hash.get( "take_home_medication" );
			String allergic_yn	    = (String)hash.get( "allergic_yn" )==null?"N":(String)hash.get( "allergic_yn" );
			String locn_type	    = "";
			if( bean.getExternalpatient_id()==null ||  ((String)bean.getExternalpatient_id()).equals("") )
				locn_type	= (String)hash.get( "source_type" );	
			else
				locn_type	= "P";	
			String locn_code	= (String)hash.get( "source_code" );	
			String or_bean_name	="eOR.OrderEntryBean";
			String or_bean_id   ="@orderentrybean"+patient_id+encounter_id;
			OrderEntryBean orbean = (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name,  request) ;
			eOR.Common.OrderEntryRecordBean orderEntryRecordBean 	= (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
			ArrayList uniqueCode	   = new ArrayList();
			HashMap prevDates		   = new HashMap();
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap ext_drugData		=	null;
			HashMap refill_detail		=	null;
			ArrayList	st_date			=	null;
			ArrayList en_date			=	null;
			HashMap duplicate			=	null;
			String start_date			=	null;
			String end_date				=	null;
			String ph_order_type		=	null;
			String approval_yn_val		=	null;
			String auth_yn_val			=	null;
			String refill_start_date	=	null;
			String refill_end_date		=	null;
			String disp_code			=	null;			                         
			String drug_code			=	null;
			String drug_start_date		=	"";
			String drug_end_date		=   "";
			String temp_auth_rqd_yn     =   "N";
			String temp_apprvl_rqd_yn   =   "N";
			String auth_reqd_yn         =   "";
			String apprvl_reqd_yn       =   "";
			String cosign_reqd_yn       =   "";
			String order_status         =   "10";
			String child_order_yn		=	"";
			String no_refill			=	"";
			String catalog_splty_code	=	"";
			String performing_facility_id=	"";
			String bl_override_excl_incl_ind=	"";
			String currentStage			= 	(String)hash.get("currentStage")==null?"":(String)hash.get("currentStage");//added for  JD-CRF-0198 [IN:058599]
			String srl_no = "";
			String tapered_over = "";
			String freq_nature = "";//added for MO-GN-5490 [IN:054620]
			String patient_stock_yn = ""; //GHL-CRF-0482
			String repeat_durn_type,split_yn,dosage_change_yn = ""; //ARYU-CRF-014
			String freq_code        = "";//ARYU-CRF-014
			String dose_chaged_yn	= "N";//ARYU-CRF-014
			String def_qty_value    = "0";//ARYU-CRF-014
			String dosage_value	= "0";//ARYU-CRF-014
			String sliding_scale_yn = "";//ARYU-SCF-0145
			String last_refill_durn_value="";//Added for IN:069886
			String last_refill_freq_chnage_durn_value="";//Added for IN:069886
			String quota_limit_exceded_yn =""; //CRF-1823-US008
			String quota_limit_access_yn= ""; // ML-MMOH-CRF-1823 US008- 43528
			String quota_limit_req_yn= bean.getQuotaLimitCalcReqYN(); // ML-MMOH-CRF-1823 US008- 43528
			String quota_limit_site_yn=""; // ML-MMOH-CRF-1823 US008- 43528
			String speciality_code=""; // ML-MMOH-CRF-1823 US008- 43528
			for(int n=0; n<prescriptionDetails.size(); n++){
				ext_drugData=(HashMap) prescriptionDetails.get(n);
				refill_detail = new HashMap();
				child_order_yn = (String)ext_drugData.get("CHILD_ORDER_YN")==null?"":(String)ext_drugData.get("CHILD_ORDER_YN");
				no_refill = (String)ext_drugData.get("NO_REFILL")==null?"":(String)ext_drugData.get("NO_REFILL");
				if(child_order_yn.equals("") && !no_refill.equals("")){
					refill_detail	=	bean.getRefillDetail(((String) ext_drugData.get("SRL_NO")));
					if(refill_detail.size()!=0) {
						st_date	=(ArrayList)refill_detail.get("refill_start_date");
						en_date	=(ArrayList)refill_detail.get("refill_end_date");
						last_refill_durn_value = (String)refill_detail.get("last_refill_durn_value");//Added for IN:069886
						last_refill_freq_chnage_durn_value = (String)refill_detail.get("last_refill_freq_chnage_durn_value");//Added for IN:069886
						ext_drugData.put("REFILL_START_DATE","");
						ext_drugData.put("REFILL_END_DATE","");
						ArrayList duplicate_list		=	new ArrayList();
						for(int y=0; y<st_date.size(); y++) {
							duplicate	=	new HashMap();
							start_date	=	(String)st_date.get(y);
							end_date	=	(String)en_date.get(y);
							duplicate	=	(HashMap)ext_drugData.clone();
							duplicate.put("REFILL_START_DATE",start_date);
							duplicate.put("REFILL_END_DATE",end_date);
							duplicate.put("CHILD_ORDER_YN","Y");
							//Added for IN:069886 start
							if(y==(st_date.size()-1) && last_refill_durn_value!=null ){
								duplicate.put("DURN_VALUE",last_refill_durn_value);
								duplicate.put("freq_chng_durn_value",last_refill_freq_chnage_durn_value);
							}
							//Added for IN:069886 end
							duplicate_list.add(duplicate);
						}
						for(int p=0; p<duplicate_list.size(); p++) {
							prescriptionDetails.add((n+p+1),(HashMap)duplicate_list.get(p));
						}
					}
				}
			}
			for(int j=0;j<prescriptionDetails.size();j++){
				disp_code           =   "";
				dose_chaged_yn		= "N"; //ARYU-SCF-0145
				dose_chaged_yn		= "N";//ARYU-SCF-0145
				ext_drugData		=   (HashMap) prescriptionDetails.get(j);
				drug_code			=   (String) ext_drugData.get("DRUG_CODE");
				srl_no					=	 (String) ext_drugData.get("SRL_NO");
				ph_order_type		=   (String) ext_drugData.get("ORDER_TYPE_CODE");
				performing_facility_id	=  (String) ext_drugData.get("PERFORMING_FACILITY_ID");
				approval_yn_val		=   (String) ext_drugData.get("ORD_APPROVED_YN")==null?"":(String) ext_drugData.get("ORD_APPROVED_YN");
				auth_yn_val			=   (String) ext_drugData.get("ORD_AUTHORIZED_YN")==null?"":(String) ext_drugData.get("ORD_AUTHORIZED_YN");
				refill_start_date	=   (String) ext_drugData.get("REFILL_START_DATE")==null?"":(String) ext_drugData.get("REFILL_START_DATE");
				refill_end_date		=   (String) ext_drugData.get("REFILL_END_DATE")==null?"":(String) ext_drugData.get("REFILL_END_DATE");
				auth_reqd_yn		=	(String) ext_drugData.get("ORD_AUTH_REQD_YN")==null?"":(String) ext_drugData.get("ORD_AUTH_REQD_YN");   
				apprvl_reqd_yn	    =	(String) ext_drugData.get("ORD_SPL_APPR_REQD_YN")==null?"":(String) ext_drugData.get("ORD_SPL_APPR_REQD_YN");
				cosign_reqd_yn	    =	(String) ext_drugData.get("ORD_COSIGN_REQD_YN")==null?"":(String) ext_drugData.get("ORD_COSIGN_REQD_YN"); 
				priority	        =	(String) ext_drugData.get("PRIORITY")==null?"":(String) ext_drugData.get("PRIORITY"); 
				catalog_splty_code	=	(String) ext_drugData.get("CATALOG_SPLTY_CODE")==null?"":(String) ext_drugData.get("CATALOG_SPLTY_CODE"); 
				tapered_over =  (String)ext_drugData.get("TAPPERED_OVER")==null?"":(String)ext_drugData.get("TAPPERED_OVER");
				freq_nature =  (String)ext_drugData.get("FREQ_NATURE")==null?"":(String)ext_drugData.get("FREQ_NATURE");//added for MO-GN-5490 [IN:054620]
				patient_stock_yn =  (String)ext_drugData.get("patient_stock_yn")==null?"N":(String)ext_drugData.get("patient_stock_yn");
				repeat_durn_type =  (String)ext_drugData.get("REPEAT_DURN_TYPE")==null?"":(String)ext_drugData.get("REPEAT_DURN_TYPE");
				
				quota_limit_exceded_yn =  (String)ext_drugData.get("QUOTA_LIMIT_EXCEDED_YN")==null?"":(String)ext_drugData.get("QUOTA_LIMIT_EXCEDED_YN"); // ML-MMOH-CRF-1823 US008- 43528
				quota_limit_access_yn =  (String)ext_drugData.get("QUOTA_LIMIT_ACCESS_YN")==null?"":(String)ext_drugData.get("QUOTA_LIMIT_ACCESS_YN"); // ML-MMOH-CRF-1823 US008- 43528
				
				quota_limit_site_yn =  (String)ext_drugData.get("QUOTA_LIMT_SITE_YN")==null?"":(String)ext_drugData.get("QUOTA_LIMT_SITE_YN"); // ML-MMOH-CRF-1823 US008- 43528
			    speciality_code    =
				(String)ext_drugData.get("SPECIALITY_CODE")==null?"":(String)ext_drugData.get("SPECIALITY_CODE"); // ML-MMOH-CRF-1823 US008- 43528
				//System.err.println("quota_limit_exceded_yn@@@ fromgrouping=="+quota_limit_exceded_yn+"quota_limit_access_yn=="+quota_limit_access_yn+"quota_limit_req_yn=="+quota_limit_req_yn+"quota_limit_site_yn=="+quota_limit_site_yn+"speciality_code=="+speciality_code);
				
				//ARYU-CRF-014
				if(freq_nature.equals("O"))//added for MO-GN-5490 [IN:054620]
					ext_drugData.put("REPEAT_VALUE", "1");
				if(ext_drugData.get("BUILDMAR_YN")!=null && ((String)ext_drugData.get("BUILDMAR_YN")).equals("Y")) //added for MMS-QH-CRF-0080 [IN:038064]
					out.println("assignBuildMAR('Y')");
				//if(!((String)ext_drugData.get("TAPER_DOSE_YN")).equals("Y")){
				if(!tapered_over.equals("Y")){
				    record_gen = "";
				}
				//Code added for IN22425 to update SPLIT_DOSE_YN_VAL value on clicking release without confirm --01/06/2010-- priya
				freq_code	     = (String)ext_drugData.get("FREQ_CODE")==null?"":(String)ext_drugData.get("FREQ_CODE");//ARYU-CRF-014
				def_qty_value = (String)ext_drugData.get("def_dose_value")==null?"0":(String)ext_drugData.get("def_dose_value");//ARYU-CRF-014
				dosage_change_yn = (String)ext_drugData.get("dosage_change_yn")==null?"N":(String)ext_drugData.get("dosage_change_yn");
				ArrayList schedule =	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
				sliding_scale_yn	   = (String)ext_drugData.get("SLIDING_SCALE_YN")==null?"N":(String)ext_drugData.get("SLIDING_SCALE_YN");//added for ARYU-SCF-0145
				if(sliding_scale_yn.equals("Y")){
					def_qty_value = "1";
					dose_chaged_yn = "N";
					dosage_change_yn = "N";
				} //ARYU-SCF-0145-end
				boolean split_chk	 =	bean.checkSplit(schedule);
				boolean firTime	= true;
				boolean found	= false;
				String tmp	= "";
				if(split_chk){
					ext_drugData.put("SPLIT_DOSE_YN_VAL","Y");
				} 
				if(ext_drugData.containsKey("BL_OVERRIDE_EXCL_INCL_IND")){
					bl_override_excl_incl_ind = (String)ext_drugData.get("BL_OVERRIDE_EXCL_INCL_IND");
					if(bl_override_excl_incl_ind.equals("SEL"))
						 ext_drugData.put("BL_OVERRIDE_EXCL_INCL_IND","");
				}
			//ARYU-CRF-014 - start
				if((repeat_durn_type.equals("D") || repeat_durn_type.equals("W")) && !freq_nature.equals("P") && !freq_nature.equals("O") && !freq_nature.equals("I") ){
					if(schedule!=null && schedule.size()>0){ //added for BRU-SCF-1899
					ArrayList schTime = (ArrayList)schedule.get(3);
					ArrayList dose_list		= (ArrayList)schedule.get(4);
					if(dose_list!=null && dose_list.size()>0){
					for(int n=0;n<dose_list.size();n++){
							dosage_value	= ((String)dose_list.get(n)).trim();
							if(firTime) {
								tmp			=	dosage_value;
								firTime	=	false;
							}
							else if(!tmp.equals(dosage_value)) {
								found		=	true;
							}
						}
					}
					if(found){
						dose_chaged_yn = "Y";
					}else{
						if(dose_list!=null && dose_list.size()>0){ // if added for ML-BRU-SCF-1899
							dosage_value = ((String)dose_list.get(0)).trim();
						}
						if(dosage_change_yn.equals("N") && Float.parseFloat(dosage_value)!=Float.parseFloat(def_qty_value)){
							dose_chaged_yn = "Y";
						}
					}
					if(dose_chaged_yn.equals("N")){
						ArrayList defSchdTime = bean.getAdminScheduleTime(freq_code);
							if(schTime!=null && schTime.size()>0){ // if added for ML-BRU-SCF-1899
								if(!defSchdTime.containsAll(schTime)){
									dose_chaged_yn = "Y";
								}
							}
						}
					}
				}
				ext_drugData.put("dose_chaged_yn", dose_chaged_yn);
				//ML-MMOH-CRF-1823 US008- 43528 START
				if(quota_limit_site_yn.equals("Y") && quota_limit_req_yn.equals("Y") && quota_limit_exceded_yn.equals("Y") && quota_limit_access_yn.equals("N")){	
					  order_status ="01";
				 } //ML-MMOH-CRF-1823 US008- 43528 END
				else if(auth_reqd_yn.equals("Y")){					
					if(apprvl_reqd_yn.equals("Y")){						
						if(approval_yn_val.equals("Y")){
							if(auth_yn_val.equals("N")){
								temp_apprvl_rqd_yn = "N";
								temp_auth_rqd_yn = "Y";  
								order_status	=	"03"; //PO - Pending Authorization
							}
							else{	
								temp_apprvl_rqd_yn = "N";
								temp_auth_rqd_yn = "N";  
								order_status	=	"10"; //OS - Ordered
							}
						}
						else{
							if(auth_yn_val.equals("Y")){
								temp_apprvl_rqd_yn = "Y";
								temp_auth_rqd_yn = "N";  
								order_status	=	"05"; //PS - Pending Spl Approval
							}
							else{
								temp_apprvl_rqd_yn = "N";
								temp_auth_rqd_yn = "Y";  
								order_status	=	"03"; //PO - Pending Authorization
							}
						}
					}
					else{					
						if(auth_yn_val.equals("Y")){
							temp_apprvl_rqd_yn = "N";
							temp_auth_rqd_yn = "N";  
							order_status	=	"10"; //OS - Ordered
						}
						else{
							temp_apprvl_rqd_yn = "N";
							temp_auth_rqd_yn = "Y";  
							order_status	=	"03"; //PO - Pending Authorization
						}
					}
				}
				else{					
					if(apprvl_reqd_yn.equals("Y")){
						if(approval_yn_val.equals("Y")){
							temp_apprvl_rqd_yn = "N";
							temp_auth_rqd_yn = "N";  
							order_status	=	"10"; //OS - Ordered
						}
						else{
							temp_apprvl_rqd_yn = "Y";
							temp_auth_rqd_yn = "N";  
							order_status	=	"05"; //PS - Pending Spl Approva
						}
					}
					else{
						temp_apprvl_rqd_yn = "N";
						temp_auth_rqd_yn = "N";  
						order_status	=	"10"; //OS - Ordered
					}
				}
				if(currentStage!=null && !currentStage.equals("")){//added for  JD-CRF-0198 [IN:058599]
					order_status	=	currentStage;
				}
			//GHL-CRF-0482
				if(patient_stock_yn.equals("Y"))
					order_status	=	"58";
				if(ext_drugData.get("CONSENT_REQD_YN")==null)
					ext_drugData.put("CONSENT_REQD_YN","N");
				if(ext_drugData.get("CONSENT_REQD_YN").equals("Y") && ext_drugData.get("CONSENT_STAGE").equals("A"))
					order_status = "00"; //PC - Pending consent
				
				ext_drugData.put("ORDER_STATUS", order_status);
                disp_code			= (String) ext_drugData.get("DISP_LOCN_CODE");
				drug_start_date="N";
				drug_end_date="N";
				//record_gen +=(String)ext_drugData.get("IN_FORMULARY_YN");
				//	if(!((String)ext_drugData.get("TAPER_DOSE_YN")).equals("Y")){
				//if(!((String)ext_drugData.get("TAPPERED_OVER")).equals("Y")){
				if(!tapered_over.equals("Y")){
					record_gen +=(String)ext_drugData.get("IN_FORMULARY_YN"); // Commented above and added here for IN25224 --30/11/2010-- priya
					record_gen += performing_facility_id;
					if(split_based_priority_yn.equals("Y"))
						record_gen += priority;
					if(split_based_drug_class_yn.equals("Y"))
						record_gen += (String) ext_drugData.get("DRUG_CLASS");
					//if condtion added for ml-mmoh-crf-0864 
				    if(split_drug_based_auth_yn.equals("Y") && ((auth_reqd_yn.equals("Y") && auth_yn_val.equals("Y") ) || order_status.equals("03")) && patient_class.equals("OP"))	
				    { record_gen += split_drug_based_auth_yn_cnt; 
				    split_drug_based_auth_yn_cnt++;
				    }
					if(quota_limit_site_yn.equals("Y") && quota_limit_req_yn.equals("Y") && quota_limit_exceded_yn.equals("Y")){	//Added for ML-MMOH-CRF-01823
						record_gen += quota_limit_site_yn+quota_limit_req_yn+quota_limit_exceded_yn;
					}
				}
				if(!uniqueCode.contains(drug_code) || ((String)ext_drugData.get("TAPPERED_OVER")).equals("Y")){
					drug_start_date=(String) ext_drugData.get("START_DATE");
					 if(drug_start_date==null) {
						 drug_start_date=(String) ext_drugData.get("START_DATE_TIME");
					 }
					drug_end_date=(String) ext_drugData.get("END_DATE");
					if(drug_end_date==null) {
						 drug_end_date=(String) ext_drugData.get("END_DATE_TIME");
					 }
					//record_gen += ph_order_type+temp_apprvl_rqd_yn+temp_auth_rqd_yn+drug_start_date+refill_start_date +refill_end_date +disp_code+catalog_splty_code;
					//if(!((String)ext_drugData.get("TAPER_DOSE_YN")).equals("Y")){
					//if(!((String)ext_drugData.get("TAPPERED_OVER")).equals("Y")){
					if(!tapered_over.equals("Y")){
						if(!(drug_start_date==null || drug_start_date.equals(""))){//KAUH-SCF-0077 [IN:035019]. Removing Timestamp on date- Begin
							drug_start_date=drug_start_date.substring(0,10);
						}
						if(!(refill_start_date==null || refill_start_date.equals(""))){
							refill_start_date=refill_start_date.substring(0,10);
						}
						if(!(refill_end_date==null || refill_end_date.equals(""))){
							refill_end_date=refill_end_date.substring(0,10);
						}//KAUH-SCF-0077 [IN:035019]. Removing Timestamp on date- End
					    record_gen = record_gen + temp_apprvl_rqd_yn+temp_auth_rqd_yn+drug_start_date+refill_start_date + refill_end_date + disp_code + catalog_splty_code;
					}
					prevDates.put(drug_code,drug_start_date);
				}
				else{
					refill_detail	=	bean.getRefillDetail(((String) ext_drugData.get("SRL_NO")));
					if(refill_detail.size()!=0){
						if(refill_start_date != null && !refill_start_date.equals("")){
							ext_drugData.put("START_DATE",refill_start_date);
							ext_drugData.put("END_DATE",refill_end_date);
						}
					}
					String date_val=(String)prevDates.get(drug_code);
					//record_gen +=ph_order_type+temp_apprvl_rqd_yn+temp_auth_rqd_yn+date_val+refill_start_date+refill_end_date+disp_code+catalog_splty_code;
					record_gen = record_gen + temp_apprvl_rqd_yn + temp_auth_rqd_yn + date_val + refill_start_date + refill_end_date + disp_code + catalog_splty_code;
				}
				ext_drugData.put("RECORD_GEN",record_gen);
				if((ext_drugData.containsKey("CHILD_ORDER_YN"))){
					ext_drugData.put("CONT_ORDER_IND","CR");
				}
				else{
					ext_drugData.put("CONT_ORDER_IND","CO");
				}
				uniqueCode.add(drug_code);
				//Code added for updating tapered_yn coulmn in ph_patient_drug_profile to "Y" even for main drug --IN25621-- 21/02/2011-- priya
				if(ext_drugData.get("TAPPERED_OVER")!=null && ((String)ext_drugData.get("TAPPERED_OVER")).equals("Y")){
					ext_drugData.put("DRUG_TAPERED_YN","Y");
					HashMap prev_extdrugData =  (HashMap) prescriptionDetails.get(j-1);
					if(prev_extdrugData!=null){
						if((ext_drugData.get("DRUG_CODE")).equals(prev_extdrugData.get("DRUG_CODE"))){
							if(prev_extdrugData.get("FREQ_NATURE")!=null && !((prev_extdrugData.get("FREQ_NATURE")).equals("O")) && !((prev_extdrugData.get("FREQ_NATURE")).equals("P"))){
								prev_extdrugData.put("DRUG_TAPERED_YN","Y");
							}
						}
					}
				}
			}
			ArrayList groupRecord=(ArrayList)bean.groupingOrder(patient_class);
			int groupSize=groupRecord.size();
			ArrayList OrderID = new ArrayList();
			if( bean.getExternalpatient_id()==null ||  ((String)bean.getExternalpatient_id()).equals("") ){
				 OrderID=(ArrayList)bean.genOrderID(groupSize,patient_class);
			}
			else{
				patient_class = "XT";
				OrderID=(ArrayList)bean.genOrderID(groupSize,patient_class);
			}
			//pls don't comment this code even though it's shown as a unused varaable 
			//this "if" condotion is commented to control the grouping orders for OP(each drug is each order invariant of patient class) 
			if(patient_class.equals("IP")){
				String debug= (String)bean.genOrderDetailsforIP();
			}
			else{
				bean.genOrderDetails();
			}
			ArrayList OrderDetails =(ArrayList) bean.getOrderDetails();
			ArrayList OrderHeader	=	new ArrayList();
			ArrayList tmp_order_id	=	new ArrayList();
			String parent_order_id	=	"";
			boolean firstTime		=	true;
			HashMap presHeader		=	null;
			ArrayList HeaderArr		=	null;        
			HashMap presDetails		=	null;
			String order_type_code	=	"";
			String ord_auth_reqd_yn	=	"";
			String ord_auth_level	=	""; 			                        
			String ord_appr_reqd_yn	=	"";
			String ord_cosign_reqd_yn	=	"";
			//String refill_yn			=	null;
			String med_admin_reqd_yn	=	"";
			//SKR-SCF-1239 - start
			String source_code = "";
			if(patient_class.equals("IP")){
				 source_code = bean.getCurrentLocn((String) hash.get( "patient_id" ),(String) hash.get( "encounter_id" ));
				 if(source_code==null)
					 source_code="";
				
			} ////SKR-SCF-1239 - end
			for(int j=0;j<OrderID.size();j++){
				presHeader  = new HashMap();
				HeaderArr	= new ArrayList();
				HeaderArr			= (ArrayList) OrderDetails.get(j); 
				presDetails = new HashMap();
				presDetails = (HashMap) HeaderArr.get(0);
				String order_id			= (String) OrderID.get(j);
				tmp_order_id.add(order_id);
				if(!presDetails.containsKey("CHILD_ORDER_YN")){
					firstTime		=	true;
				}
				order_type_code	= (String) presDetails.get("ORDER_TYPE_CODE");
				ord_auth_reqd_yn = (String) presDetails.get("ORD_AUTH_REQD_YN")==null?"N":(String) presDetails.get("ORD_AUTH_REQD_YN");
				
				if((String) presDetails.get("ORD_AUTH_LEVEL")==null){
					presDetails.put("ORD_AUTH_LEVEL","");
				}
				ord_auth_level     = (String) presDetails.get("ORD_AUTH_LEVEL");
				ord_appr_reqd_yn   = (String) presDetails.get("ORD_SPL_APPR_REQD_YN")==null?"N":(String) presDetails.get("ORD_SPL_APPR_REQD_YN");
				ord_cosign_reqd_yn = (String) presDetails.get("ORD_COSIGN_REQD_YN")==null?"N":(String) presDetails.get("ORD_COSIGN_REQD_YN");
				consent_reqd_yn=(String)presDetails.get("CONSENT_REQD_YN")==null?"N":(String)presDetails.get("CONSENT_REQD_YN");
				if(consent_reqd_yn.equals(""))
					consent_reqd_yn = "N";
				med_admin_reqd_yn  = (String) presDetails.get("MED_ADMIN_REQD_YN");
				presHeader.put("ORDER_ID", order_id );
				presHeader.put("MED_ADMIN_REQD_YN", med_admin_reqd_yn );
				presHeader.put("ORDER_TYPE_CODE", order_type_code );
				presHeader.put("FACILITY_ID",(String) hash.get( "facility_id" ));
				presHeader.put("PATIENT_ID",(String) hash.get( "patient_id" ));
				presHeader.put("ENCOUNTER_ID",(String) hash.get( "encounter_id" ));
				presHeader.put("BED_NUM", bed_num);
				presHeader.put("ROOM_NUM", room_num);
				presHeader.put("HEIGHT",(String) hash.get( "height" ));
				presHeader.put("WEIGHT",(String) hash.get( "weight" ));
				presHeader.put("BSA",(String) hash.get( "bsa" ));
				presHeader.put("BMI",(String) hash.get( "bmi" ));
				presHeader.put("HEIGHT_UNIT",(String) hash.get( "height_unit" ));
				presHeader.put("WEIGHT_UNIT",(String) hash.get( "weight_unit" ));
				presHeader.put("BSA_UNIT",(String) hash.get( "bsa_unit" ));
				presHeader.put("PRIORITY",(String) hash.get( "priority" ));
				presHeader.put("ORDER_DATE_TIME",(String) hash.get( "order_date_time" ));
				presHeader.put("TAKE_HOME_MEDICATION",(String) hash.get( "take_home_medication" ));
				presHeader.put("PATIENT_CLASS",(String) hash.get( "patient_class" ));
				presHeader.put("SOURCE_TYPE",(String) hash.get( "source_type" ));
				presHeader.put("SOURCE_CODE",(String) hash.get( "source_code" ));
				presHeader.put("DISP_LOCN_CODE",(String) presDetails.get( "DISP_LOCN_CODE" ));		
				presHeader.put("ALLERGIC_YN",allergic_yn);
				presHeader.put("CATALOG_SPLTY_CODE",(String) presDetails.get( "CATALOG_SPLTY_CODE" ));		
				presHeader.put("HOME_LEAVE_YN_VAL",(String) hash.get( "home_leave_yn_val" ));// added home_leave_yn_val for Bru-HIMS-CRF-093[29960]
				if( home_medication.equals("Y") )
						presHeader.put("DISCHARGE_IND","D");
				else
					presHeader.put("DISCHARGE_IND","");
				if(bean.getOpDischMedInd()!=null && !bean.getOpDischMedInd().equals("") && bean.getOpDischMedInd().equals("Y") && bean.getTakeHomeMedicationOp()!=null && !bean.getTakeHomeMedicationOp().equals("") && bean.getTakeHomeMedicationOp().equals("Y")){//added for NMC-JD-CRF-0063
					presHeader.put("DISCHARGE_IND",""); 
				}
				presHeader.put("ATTEND_PRACT_ID",(String) hash.get( "attend_pract_id" ));
				presHeader.put("ORD_PRACT_ID",(String) hash.get( "ord_pract_id" ));
				presHeader.put("ORD_AUTH_REQD_YN",ord_auth_reqd_yn);
				presHeader.put("QUOTA_LIMIT_ACCESS_YN",(String)presDetails.get("QUOTA_LIMIT_ACCESS_YN"));//ML-MMOH-CRF-1823 US008 - 43528 
				presHeader.put("QUOTA_LIMIT_EXCEDED_YN",(String)presDetails.get("QUOTA_LIMIT_EXCEDED_YN")==null?"":(String)presDetails.get("QUOTA_LIMIT_EXCEDED_YN"));//ML-MMOH-CRF-1823 US008- 43528 
				presHeader.put("QUOTA_LIMIT_SITE_YN",(String)presDetails.get("QUOTA_LIMT_SITE_YN"));//ML-MMOH-CRF-1823 US008- 43528
				presHeader.put("QUOTA_LIMIT_REQ_YN",quota_limit_req_yn);//ML-MMOH-CRF-1823 - 43528
				presHeader.put("SPECIALITY_CODE",(String)presDetails.get("SPECIALITY_CODE"));//ML-MMOH-CRF-1823 - 43528
				    	
				
				
				presHeader.put("ORD_AUTH_LEVEL",ord_auth_level);
				presHeader.put("ORD_APPR_REQD_YN",ord_appr_reqd_yn);
				presHeader.put("ORD_COSIGN_REQD_YN",ord_cosign_reqd_yn);
				presHeader.put("CONSENT_REQD_YN",consent_reqd_yn);
				presHeader.put("BROUGHT_BY_PAT",(String) presDetails.get( "BROUGHT_BY_PAT" ));
				presHeader.put("BUILDMAR_YN",buildMAR_yn);
				presHeader.put("DrugRemarksEntered",DrugRemarksEntered); //Added for Antibiotic Screen using Order Entry Format ICN 29904
				presHeader.put("DRUG_INDICATION",DrugIndicationRemarks);
				if( ( presDetails.containsKey("CHILD_ORDER_YN")) ){
					presHeader.put("CONT_ORDER_IND","CR");
					//presDetails.put("CONT_ORDER_IND","CR");
				}
				else{
					presHeader.put("CONT_ORDER_IND","CO");
					//presDetails.put("CONT_ORDER_IND","CO");
				}
				if((orbean.getCalledFromFunction()!=null) && (orbean.getCalledFromFunction()).equals("RENEW_ORDER")) {
					presHeader.put("CHILD_ORDER_YN","N");
					presHeader.put("PARENT_ORDER_ID","");
				} 
				else {
					if ( presDetails.containsKey("CHILD_ORDER_YN")) {
						presHeader.put("CHILD_ORDER_YN","Y");
						if(firstTime) {
							parent_order_id	=  (String)tmp_order_id.get(j-1);
							firstTime		=	false;
						}
						presHeader.put("PARENT_ORDER_ID",parent_order_id);
					}
					else{
						presHeader.put("CHILD_ORDER_YN","N");
						presHeader.put("PARENT_ORDER_ID","");
					}
				}
				//added for JD-CRF-198 - start
				if(function_from.equals("ALTERNATE_ORDER") ) 
					presHeader.put("ORG_ORDER_ID",bean.getParentOrderIdForAltOrder());
				else
					presHeader.put("ORG_ORDER_ID","");
				//added for JD-CRF-198 -end
				order_status=(String)presDetails.get( "ORDER_STATUS" );
				presHeader.put("ORD_AUTH_REQD_YN",(String)presDetails.get( "ORD_AUTH_REQD_YN" ));
				presHeader.put("ORDER_STATUS",order_status);
			//SKR-SCF-1239 - start
				if(patient_class.equals("IP")&& !source_code.equals("") && !source_code.equals(locn_code)){
					String disp_locn			= bean.getDispLocn((String)presDetails.get( "IN_FORMULARY_YN" ), patient_class, priority, (String)presDetails.get( "DRUG_CODE" ), locn_type, source_code, (String) hash.get("take_home_medication"), order_type_code,(String)presDetails.get( "DRUG_CLASS" ),(String) hash.get("home_leave_yn_val"),patient_id,encounter_id);
					if(disp_locn!=null && !disp_locn.equals("")){
						disp_locn = disp_locn.substring(0,disp_locn.indexOf("|"));
					}
					if(disp_locn!=null && !disp_locn.equals("")){
						presHeader.put("SOURCE_CODE",source_code);
						presHeader.put("DISP_LOCN_CODE",disp_locn);
					}
				}
				//SKR-SCF-1239 - end
				OrderHeader.add(presHeader);
			}
			bean.setpresHeader(OrderHeader);
			OrderHeader=(ArrayList) bean.getpresHeader();
			ArrayList DrugRemarks	= new ArrayList();
			ArrayList OrderDrug		= new ArrayList();
			ArrayList grp=(ArrayList) bean.sortList();
			String exist_code="";
			String order_id="";
			String fr_drug_code="";
			HashMap orderFormatHash	=	null;
			ArrayList arrSeq_num	=	null;
			Hashtable template		=	null;
			for(int j=0;j<grp.size();j++){
				orderFormatHash	= new HashMap(); // To store it in the HashMap
				arrSeq_num	= new ArrayList(); // get the seq in ArrayList
				template		= new Hashtable(); // get the template values in the HashTable
				int seq_num 			= 0;
				String order_format_values = "";
				String catalog_code=(String) grp.get(j);
				String row_value="0";
				arrSeq_num				= (java.util.ArrayList) orderEntryRecordBean.getOrderFormats(catalog_code, catalog_code+"_"+row_value);
				ArrayList headerList	=	null;
				HashMap DrugValues		=	null;	
				String serial_no		=	null;
				for(int k=0;k<OrderDetails.size();k++){
					headerList=new ArrayList();
					headerList=(ArrayList) OrderDetails.get(k);
					if(headerList!=null && headerList.size()>0){//added for ml-mmoh-scf-1899
					for(int h=0;h<headerList.size();h++){
						DrugValues= new HashMap();
						DrugValues=(HashMap) headerList.get(h);
						exist_code=(String)	DrugValues.get("DRUG_CODE");
						serial_no	=	(String)	DrugValues.get("SRL_NO");
						orderFormatHash	= new HashMap();
						if(exist_code.equals(catalog_code)){
							fr_drug_code=exist_code;
							orderFormatHash.put("fr_drug_code",fr_drug_code);
							orderFormatHash.put("serial_no",serial_no);
							if(k > (OrderID.size()-1))
								order_id=(String) OrderID.get(OrderID.size()-1);
							else
								order_id=(String) OrderID.get(k);
							arrSeq_num				= (java.util.ArrayList) orderEntryRecordBean.getOrderFormats((fr_drug_code+serial_no), (fr_drug_code+serial_no)+"_0");
							if(arrSeq_num!= null && arrSeq_num.size() >0){
								int i=0;
								order_format_values = "";
								for(i=0;i<arrSeq_num.size();i++){
									seq_num		=((Integer.parseInt(((String)arrSeq_num.get(i)).trim())) );
									template	= (java.util.Hashtable)	orderEntryRecordBean.getOrderFormats ( (catalog_code+serial_no), ((catalog_code+serial_no)+seq_num) );
									orderFormatHash.put("seq_num"+i,String.valueOf(seq_num));
									orderFormatHash.put("field_mnemonic"+i,(String) template.get("field_mnemonic"));
									orderFormatHash.put("label_text"+i,(String) template.get("label_text"));
									orderFormatHash.put("accept_option"+i,(String) template.get("accept_option"));
									orderFormatHash.put("field_type"+i,(String) template.get("field_type"));
									orderFormatHash.put("field_values"+i,(String) template.get("field_values"));
									String field_values_tmp = "";
									if(((String) template.get("field_mnemonic")).equals("PRES_REMARKS")){
										field_values_tmp = presBean.getPrescriptionRemarks((String) template.get("field_values"));
									}
									else{
										field_values_tmp = ((String) template.get("field_values")).trim();
									}
									if(field_values_tmp != null && !field_values_tmp.equals("") ){
										order_format_values =order_format_values+ ((String) template.get("label_text"))+" : "+ field_values_tmp +",";														
									}
								}
								orderFormatHash.put("order_format_count",(String.valueOf(i)));
								orderFormatHash.put("order_id",order_id);
								orderFormatHash.put("order_format_values",order_format_values);
							}
							else{
								orderFormatHash.put("order_id",order_id);
								orderFormatHash.put("order_format_count","0");
								orderFormatHash.put("order_format_values","");
							}
							DrugRemarks.add(orderFormatHash);
						}
					}
					}
				}
			}
			String ext_order_id="", ext_order_format_count="",ord_id="" ;
			HashMap orderValues	=	null;
			for(int i=0;i<OrderID.size();i++){
				ord_id		=(String)OrderID.get(i);
				orderValues	=new HashMap();
				for(int p=0;p<DrugRemarks.size();p++){
					orderValues=(HashMap) DrugRemarks.get(p);
					ext_order_id = (String) orderValues.get("order_id");
					if(ext_order_id==null)
						ext_order_id="";
					ext_order_format_count= (String) orderValues.get("order_format_count");
					if(ord_id.equals(ext_order_id)){
						if(ext_order_format_count!=null && !(ext_order_format_count.equals(""))){
							OrderDrug.add(orderValues);
						}
					}
				}
			}
			String cn_bean_id					= "@ConsumableOrderBean"+patient_id+encounter_id;
			String cn_bean_name				= "ePH.ConsumableOrderBean";
			ConsumableOrderBean consumableBean = (ConsumableOrderBean)getBeanObject( cn_bean_id, cn_bean_name, request );
			bean.genDrugRemarks(OrderDrug);
			ArrayList presItemList = consumableBean.getPresItemList();
			if(presItemList!=null && presItemList.size()>0){
				HashMap itemDetails = null;
				for(int i=0; i<presItemList.size();i++){
					itemDetails = (HashMap)presItemList.get(i);
					itemDetails.put("ORDERED_DATE",(String) hash.get("order_date_time"));
					itemDetails.put("PATIENT_ID", patient_id);
					itemDetails.put("ENCOUNTER_ID", encounter_id);
					itemDetails.put("FACILITY_ID",(String) hash.get( "facility_id" ));
					itemDetails.put("BED_NUM", bed_num);
					itemDetails.put("ROOM_NUM", room_num);
					itemDetails.put("HEIGHT",(String)hash.get("height"));
					itemDetails.put("WEIGHT",(String) hash.get("weight"));
					itemDetails.put("BSA",(String) hash.get("bsa"));
					itemDetails.put("BMI",(String) hash.get("bmi"));
					itemDetails.put("HEIGHT_UNIT",(String) hash.get("height_unit" ));
					itemDetails.put("WEIGHT_UNIT",(String) hash.get("weight_unit" ));
					itemDetails.put("BSA_UNIT",(String) hash.get( "bsa_unit" ));
					itemDetails.put("PRIORITY",(String) hash.get( "priority" ));
					itemDetails.put("ORDER_DATE_TIME",(String) hash.get( "order_date_time" ));
					itemDetails.put("TAKE_HOME_MEDICATION",(String) hash.get( "take_home_medication" ));
					itemDetails.put("PATIENT_CLASS",(String) hash.get( "patient_class" ));
					itemDetails.put("SOURCE_TYPE",(String) hash.get( "source_type" ));
					itemDetails.put("SOURCE_CODE",(String) hash.get( "source_code" ));
					itemDetails.put("ALLERGIC_YN",allergic_yn);
					if( home_medication.equals("Y") ){
						itemDetails.put("DISCHARGE_IND","D");
					}
					else{
						itemDetails.put("DISCHARGE_IND","");
					}
					itemDetails.put("ATTEND_PRACT_ID",(String) hash.get( "attend_pract_id" ));
					itemDetails.put("ORD_PRACT_ID",(String) hash.get( "ord_pract_id" ));
					itemDetails.put("BROUGHT_BY_PAT",(String) presDetails.get( "BROUGHT_BY_PAT" ));
					itemDetails.put("CONT_ORDER_IND","CO");
					itemDetails.put("CHILD_ORDER_YN","N");
					itemDetails.put("PARENT_ORDER_ID","");
				}
				OrderID=(ArrayList)consumableBean.genOrderID(presItemList.size(),(String) hash.get( "patient_class" ));
				for(int i=0; i<presItemList.size();i++){

					itemDetails = (HashMap)presItemList.get(i);
					itemDetails.put("ORDER_ID", (String)OrderID.get(i));
				}
			}
			bean.setPresItemList(presItemList);
			String print_ord_sht_rule_ind=bean.getPrintOrdShtRuleInd();//Added for Bru-HIMS-CRF-393_1.0
			out.println("showRecords(\""+print_ord_sht_rule_ind+"\")");//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
			putObjectInBean(or_bean_id,orbean,request);
			putObjectInBean(cn_bean_id,consumableBean,request);
		}
		else if(func_mode != null && func_mode.equals("report")) {
			String patient_id				= (String) hash.get( "patient_id" );
			String facility_id				= "C1";
			String report_id				= "PHBOPPRS";
			ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
			ecis.utils.OnlineReport report1	= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
			report1.addParameter("patient_id",patient_id) ;
			report1.addParameter("p_report_id",report_id); 
			onlineReports.add( report1) ;
			String ReportOutput = onlineReports.execute( request, response );
			out.println(ReportOutput);
		}
		else if(func_mode != null && func_mode.equals("validateDuration")){
			String drug_code		= (String) hash.get( "drug_code" );
			String patient_class	= (String) hash.get( "patient_class" );
			String source	        = (String) hash.get( "source" );
			String srlNo			= (String) hash.get( "srlNo" );
			String frm				= hash.get( "frm" )==null?"":(String) hash.get( "frm" );
			String freq_chng_durn_desc = (String) hash.get( "freq_chng_durn_desc" );
			String freq_chng_durn_value = (String) hash.get( "freq_chng_durn_value" );
			String interval_value = hash.get( "interval_value" )==null?"1":(String) hash.get( "interval_value" ); //added for IN24131 -- 14/10/2010-- priya
			String sliding_scale_yn = (String) hash.get( "sliding_scale_yn" )==null?"N": (String) hash.get( "sliding_scale_yn" );
			String repeat_durn_type = (String) hash.get( "repeat_durn_type" ); // added for IN21609 --07/06/2010 -- priya
			String order_set_code	= (String)hash.get("order_set_code")==null?"":(String)hash.get("order_set_code");
			HashMap durnValues=  (HashMap)presBean.validateDuration(drug_code,patient_class);
			HashMap ext_drugData	=	null;
			String ext_drug_code	=	null;
			String ext_srl_no		=	null;
			String ext_total_durn_value	=	null, prev_drun_value="";
			boolean	can_modify	= true;
			String totalTaperQtyDisplay = bean.getTotalTaperQtyDisplay();
			String tapered_yn="", amend_yn = ""; //Added for  [IN:043763] User can able to do Taper without changing the Dosage and frequency. 
			String parent_stat	="";  //AAKH-CRF-0091 
			String stat_yn		="";  //AAKH-CRF-0091 
			if(source.equals("modify")||source.equals("taper")||source.equals("tapered")){
				ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
				 //below code add for the incident no SCF No. SRR20056-SCF-7537, Incident No 27578 by chandra shekar.A
				int codeCount_1 =0;
				int codeCount_2 =0;
				int drug_index =0;
				for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData=(HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
					ext_srl_no=(String) ext_drugData.get("SRL_NO");
					tapered_yn = ext_drugData.get("TAPPERED_OVER")==null?"":(String)ext_drugData.get("TAPPERED_OVER"); //Added for  [IN:043763] User can able to do Taper without changing the Dosage and frequency.  -Start
					amend_yn = ext_drugData.get("AMEND_YN")==null?"":(String)ext_drugData.get("AMEND_YN");
					if(!amend_yn.equals("Y") && tapered_yn.equals("Y") && frm.equals("release")){
						out.println("alertNoTaper('nochange');") ;
						can_modify=false;
						break;
					} //Added for  [IN:043763] -end
					if(drug_code.equals(ext_drug_code)){
						codeCount_1++;
					}
					if(drug_code.equals(ext_drug_code) && srlNo.equals(ext_srl_no)){
						drug_index = j;
						prev_drun_value = (String)ext_drugData.get("DURN_VALUE");
					}
				}
				if(codeCount_1>1){
					for(int k=drug_index;k<prescriptionDetails.size();k++){
						ext_drugData=(HashMap) prescriptionDetails.get(k);
						ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
						stat_yn			= (String)ext_drugData.get("stat_yn")==null?"N":(String)ext_drugData.get("stat_yn");	//AAKH-CRF-0091 					
						if(drug_code.equals(ext_drug_code)){
							codeCount_2++;
						}
					}
				}
				if(can_modify && codeCount_1>1 && codeCount_2!=1 && order_set_code.equals("") && !totalTaperQtyDisplay.equals("Y") ){
					can_modify=false;
					if(stat_yn.equals("Y")){//AAKH-CRF-0091
							out.println("statParent('modify')");
						}
					else{
						out.println("alertParentRecord('modify','"+frm+"',"+prev_drun_value+")") ;
					}
					
				}
				if(can_modify){// code adding is end
					for(int j=0;j<prescriptionDetails.size();j++){
						ext_drugData=(HashMap) prescriptionDetails.get(j);
						ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
						ext_srl_no=(String) ext_drugData.get("SRL_NO");
						if( drug_code.equals(ext_drug_code) && srlNo.equals(ext_srl_no) ){
							//Below if condition commented for IN24132 to update the duration values without confirm (was displaying wrongly in FDB dosage alert) --07/10/2010-- priya
							//if(frm.equals("confirm") || sliding_scale_yn.equals("Y")){ 
							ext_drugData.put("freq_chng_durn_desc",freq_chng_durn_desc);
							//ext_drugData.put("DURN_TYPE",freq_chng_durn_desc);
							if(repeat_durn_type == null || repeat_durn_type.equals("")) // if block added for IN21609 --07/06/2010 -- priya
								repeat_durn_type = (String)ext_drugData.get("REPEAT_DURN_TYPE");
							freq_chng_durn_value =	(String)bean.getFreqDurnConvValue(repeat_durn_type,freq_chng_durn_value,freq_chng_durn_desc);
							//replaced (String)ext_drugData.get("REPEAT_DURN_TYPE") with repeat_durn_type in the function argument for IN18928 --22/02/2010 -- priya
							ext_drugData.put("freq_chng_durn_value",freq_chng_durn_value); // added for IN21609 --07/06/2010 -- priya
							ext_drugData.put("FREQ_DURN_VALUE",freq_chng_durn_value);
							ext_drugData.put("INTERVAL_VALUE",interval_value); //added for IN24131 -- 14/10/2010-- priya
							ext_drugData.put("REPEAT_DURN_TYPE",repeat_durn_type); //added for IN24131 -- 14/10/2010-- priya
							//} // end if(frm.equals("confirm") || sliding_scale_yn.equals("Y"))
							break;
						}
					}
				}
			}
			if(can_modify){
				ArrayList prescription=(ArrayList)bean.getpresDetails();
				int total_durn=0;
				String present_durn_value=(String) hash.get("durn_value");
				for(int j=0;j<prescription.size();j++){
					ext_drugData=(HashMap) prescription.get(j);
					ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
					ext_total_durn_value=(String) ext_drugData.get("DURN_VALUE");
					if( drug_code.equals(ext_drug_code)){
						total_durn+=Integer.parseInt(ext_total_durn_value);
					}
				}
				if(!source.equals("modify")){
					total_durn+=Integer.parseInt(present_durn_value);
				}
				String total_durn_value=""+total_durn;
				if(durnValues.size()>0){
					String max_durn_value = (String)durnValues.get("max_durn_value")==null?"":(String)durnValues.get("max_durn_value");
					String chk_for_max_durn_action = (String)durnValues.get("chk_for_max_durn_action")==null?"":(String)durnValues.get("chk_for_max_durn_action");
					String prompt_msg = (String)durnValues.get("prompt_msg")==null?"":(String)durnValues.get("prompt_msg");
					String max_durn_type = (String)durnValues.get("max_durn_type")==null?"":(String)durnValues.get("max_durn_type");
					out.println("assignDurnvalue('"+total_durn_value+"','"+max_durn_value+"','"+chk_for_max_durn_action+"','"+java.net.URLEncoder.encode(prompt_msg,"UTF-8")+"','"+max_durn_type+"','"+sliding_scale_yn+"')"); //passed sliding_scale_yn  for IN22255 --23/06/2010 --priya
				}
			}
		}
		else if(func_mode!= null && func_mode.equals("setDurationAction")){
			ArrayList prescriptionDetails	=	(ArrayList)bean.getpresDetails();
			HashMap drugDetail	=	null;
			String curr_drug_code = "", curr_srl_no="";
			String drugCode = (String)hash.get("drug_code");
			String srlNo =  (String)hash.get("srl_no");
			String ord_authorized_prev_yn = (String) hash.get("ord_authorized_prev_yn")==null?"":(String)hash.get("ord_authorized_prev_yn");
			String ord_authorized_yn = (String) hash.get("ord_authorized_yn")==null?"":(String)hash.get("ord_authorized_yn");
			String ord_auth_reqd_yn = (String) hash.get("ord_auth_reqd_yn")==null?"":(String)hash.get("ord_auth_reqd_yn");
			String quota_limit_access_yn = (String) hash.get("quota_limit_access_yn")==null?"":(String)hash.get("quota_limit_access_yn"); //ML-MMOH-CRF-1823 - 43528
			for(int j=0;j<prescriptionDetails.size();j++){
				drugDetail	=(HashMap) prescriptionDetails.get(j);
				curr_drug_code	=(String) drugDetail.get("DRUG_CODE");
				curr_srl_no		=(String) drugDetail.get("SRL_NO");
				if( drugCode.equals(curr_drug_code) && srlNo.equals(curr_srl_no) ){
					drugDetail.put("ORD_AUTH_REQD_YN",ord_auth_reqd_yn);
					drugDetail.put("QUOTA_LIMIT_ACCESS_YN",quota_limit_access_yn); //ML-MMOH-CRF-1823 US008- 43528 
					drugDetail.put("ORD_AUTHORIZED_PREV_YN",ord_authorized_prev_yn);
					drugDetail.put("ORD_AUTHORIZED_YN",ord_authorized_yn);
				}
			}
		}
		
		else if(func_mode!= null && func_mode.equals("callSearch")) {
			ArrayList drugCode = new ArrayList();
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap drugData	=	null;
			String drug_code =		null;
			String freq		 =		null;
			if(prescriptionDetails!= null && prescriptionDetails.size()>0){
				for(int j=0;j<prescriptionDetails.size();j++){
					drugData=(HashMap) prescriptionDetails.get(j);
					drug_code = (String) drugData.get("DRUG_CODE")==null?"":(String) drugData.get("DRUG_CODE");
					freq		 = (String) drugData.get("FREQ_NATURE")==null?"":(String) drugData.get("FREQ_NATURE");
					if( ! ((freq.equals("O") || freq.equals("P")) )){
						drugCode.add(drug_code);
					}
				}
			}
			out.println("drugSearch('"+drugCode+"')");
		}
		else if(func_mode!= null && func_mode.equals("clearData")){
			String or_bean_id	    =  "";
			String patient_id	    = (String) hash.get( "patient_id" );
			String encounter_id	    = (String) hash.get( "encounter_id" );
			String pract_type = (String)hash.get("pract_type")==null?"":(String)hash.get("pract_type"); //added for ML-BRU-SCF-0958 [IN:042045]
			String order_set_code	= "";
			if(hash.containsKey("order_set_code")){
			   order_set_code	= (String) hash.get( "order_set_code" );
			}
			String allergic_yn="";
			if(hash.containsKey("allergic_yn")){
			   allergic_yn	= (String) hash.get( "allergic_yn" );
			}
			String or_bean_name	="eOR.OrderEntryBean";
			or_bean_id="@orderentrybean"+patient_id+encounter_id;
			OrderEntryBean orbean = (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
			eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
			String key	= (orbean.getPatientId()+orbean.getEncounterId());// Unique key to keep the Value in the Bean
			java.util.HashMap previousValues= (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);
			String order_catalog_code 		= orbean.getOrderCatalogCode(previousValues,"PH", pract_type); // pract_type added for ML-BRU-SCF-0958 [IN:042045]
			String print_ord_sht_rule_ind	=bean.getPrintOrdShtRuleInd();//Added for Bru-HIMS-CRF-393_1.0
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
				//code written  on 9/1/2005 for orderset reloading problem
				if(!order_set_code.equals("")){
					orderEntryRecordBean.removeCheckedEntries (key,"ck"+order_set_code);
					orderEntryRecordBean.removeCheckedEntries (key,"h1"+order_set_code);
					orderEntryRecordBean.removeCheckedEntries (key,"h2"+order_set_code);
				}
			}
			ArrayList arrCheckCatalog = (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("CK_CODE",("CK_CODE_0"));
			String removable_catalog_code="";
			int index=0;
			if(arrCheckCatalog!=null){
				for(int i=0;i<ordeCatalogCode.size();i+=3){
					checkedKey=(String) ordeCatalogCode.get(i);
					removable_catalog_code= "ck"+checkedKey;
					index=0;
					if(arrCheckCatalog.contains(removable_catalog_code)){
						index			  =	arrCheckCatalog.indexOf(removable_catalog_code);
						if(index!=-1){ // If found
							if(((String)arrCheckCatalog.get(index)).equalsIgnoreCase(removable_catalog_code))
								arrCheckCatalog.remove(index);
						}
					} 				
				} 
				/*	code wriien   on 9/1/2005 for orderset reloading problem */
				if(!order_set_code.equals("")){
				   removable_catalog_code= "ck"+order_set_code;
					if(arrCheckCatalog.contains(removable_catalog_code)){
						 index			  =	arrCheckCatalog.indexOf(removable_catalog_code);
					}
					if(((String)arrCheckCatalog.get(index)).equalsIgnoreCase(removable_catalog_code))
						arrCheckCatalog.remove(index);
				}
				/*  till here */ 
				if(arrCheckCatalog.size() > 0){
					orderEntryRecordBean.setOrderFormats("CK_CODE", ("CK_CODE_0"),arrCheckCatalog);
				}
				else{
					orbean.setRefreshYn("Y");
				}
			}
			if( !allergic_yn.equals("Y")){
				//out.println("reloadPage()");//Commented for Bru-HIMS-CRF-393_1.0
				out.println("reloadPage(\""+print_ord_sht_rule_ind+"\")");//Added for Bru-HIMS-CRF-393_1.0
			 }
			 else{
				bean.clear();
			}
			putObjectInBean(or_bean_id,orbean,request);	
		}
		
		else if(func_mode != null && func_mode.equals("onLinePrinting")){
			String print_yn		= hash.get( "print_yn" )==null?"":(String) hash.get( "print_yn" );
			String locn_code	=  hash.get( "locn_code" )==null?"":(String) hash.get( "locn_code" );
			String patient_class= hash.get( "patient_class" )==null?"":(String) hash.get( "patient_class" );
			String patient_id			=  hash.get("patient_id")==null?"":(String) hash.get("patient_id");
			String encounter_id			=  hash.get("encounter_id")==null?"":(String) hash.get("encounter_id");
			String prescriptionPrint	= hash.get("prescriptionPrint")==null?"":(String) hash.get("prescriptionPrint");
			String NarcoticPrint		=  hash.get("NarcoticPrint")==null?"":(String) hash.get("NarcoticPrint");
			String MARLabelPrint		=  hash.get("MARLabelPrint")==null?"":(String) hash.get("MARLabelPrint");//Added for MMS-QH-CRF-0080 [IN:038064]
			if(prescriptionPrint.equals("Y") || NarcoticPrint.equals("Y") || MARLabelPrint.equals("Y")){
				ArrayList OrderID = new ArrayList();
				OrderID = bean.getOrderID();
				String cn_bean_id					= "@ConsumableOrderBean"+patient_id+encounter_id;
				String cn_bean_name				= "ePH.ConsumableOrderBean";
				ConsumableOrderBean consumableBean = (ConsumableOrderBean)getBeanObject( cn_bean_id, cn_bean_name, request );
				ArrayList cn_OrderID = consumableBean.getOrderID();
				if(cn_OrderID!=null && cn_OrderID.size()>0){
					for(int i=0;i<cn_OrderID.size();i++){
						OrderID.add((String)cn_OrderID.get(i));
					}
				}
				boolean	printed =(boolean)bean.doPrinting(request,response,locn_code,patient_class,prescriptionPrint,NarcoticPrint,MARLabelPrint,patient_id );//code 'patient_id' added for SKR-SCF-0915[IN046734]
				if(printed){
					out.println("reloadPage_1()");
				}
				else{
					out.println("reloadPage_1()");
				}
			}
			else{
				bean.clear(); //moved from down for [IN:040600] - Bean is cleared after loading the pages(java.net.ConnectException: Connection timed out: connect while doPrinting), so null pointer exception.
				out.println("reloadPage_1()");
			}//bean.clear(); //commented for [IN:040600]
		}
		else if(func_mode != null && func_mode.equals("storeSchedule")){
			String freq_code		= (String) hash.get( "freq_code" );
			String freq_desc		= (String)hash.get( "freq_desc");
			freq_desc = java.net.URLDecoder.decode(freq_desc,"UTF-8");
			String freq_nature		= (String)hash.get( "freq_nature");
			String start_date		= (String) hash.get( "start_date" );
			String split_dose_yn	= (String) hash.get( "split_dose_yn" );
			String qty_value		= (String) hash.get( "qty_value" );
			String drug_code		= (String) hash.get( "drug_code" );
			String srl_no			= (String) hash.get( "srl_no" );
			String rowVal			= (String) hash.get( "rowVal" );
			String scheduled_yn		= (String) hash.get( "scheduled_yn" );
			String dose_uom			= (String) hash.get( "dose_uom" );  // added for SKR-SCF-0561 [IN:033486]
			String qty_uom = (String) hash.get( "qty_uom" ); //added for IN23975 --28/09/2010-- priya
			String dosage_type = (String) hash.get( "dosage_type" ); //added for IN24132 --07/10/2010-- priya
			String sch_bean_id		= "OrScheduleFreq" ;
			String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
			Hashtable sch_output	=	null;
			Hashtable schedule_val	=	null; 
			String	 temp_drug_code ="";
			String	 temp_srl_no		="";
			if( scheduled_yn.equals("Y") ) {
				schedule_val	=	new Hashtable();
				ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name ,request);
				schedule_bean.setLanguageId(locale);
				schedule_val.put("facility_id", (String)session.getValue("facility_id"));
				schedule_val.put("start_time_day_param", start_date);
				schedule_val.put("module_id", "PH"); 
				schedule_val.put("split_dose_yn", split_dose_yn); 
				schedule_val.put("split_qty",qty_value);
				schedule_val.put("freq_code",  freq_code );
				schedule_val.put("code",drug_code+srl_no);
				sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
				sch_output.put("code",drug_code+srl_no);
				sch_output.put("row_value",rowVal);
				sch_output.put("start_date_time",start_date);
				bean.setScheduleFrequencyStr(sch_output);
				putObjectInBean(sch_bean_id,schedule_bean,request);
			} 
			// if( scheduled_yn.equals("Y") closed here to set freq_nature for stat and prn orders for IN24061 --06/10/2010-- priya
			ArrayList presDetails  = (ArrayList) bean.getpresDetails();
			HashMap drugDetails    = null;
			for(int i=0;i<presDetails.size();i++){
				drugDetails    = (HashMap)presDetails.get(i);
				temp_drug_code =(String)drugDetails.get("DRUG_CODE");
				temp_srl_no		=(String) drugDetails.get("SRL_NO");
				if( drug_code.equals(temp_drug_code) && srl_no.equals(temp_srl_no) ){
					drugDetails.put("FREQ_NATURE",freq_nature);
					drugDetails.put("FREQ_CODE",freq_code);
					drugDetails.put("FREQ_DESC",freq_desc);
					drugDetails.put("SCHEDULED_YN",scheduled_yn);
					drugDetails.put("OR_QTY_DESC",bean.getUomDisplay((String)session.getValue("facility_id"),dose_uom)); // added for SKR-SCF-0561 [IN:033486] 
					if( scheduled_yn.equals("Y") ) { // if condition added for IN24061 --06/10/2010-- priya
					drugDetails.put("REPEAT_DURN_TYPE",sch_output.get("durationType"));
					}
					drugDetails.put("QTY_VALUE",qty_value);                   //  added for IN22425 --01/06/2010-- priya
					drugDetails.put("QTY_DESC_CODE",qty_uom);   //added for IN23975 --28/09/2010-- priya
					drugDetails.put("SPLIT_DOSE_YN_VAL",split_dose_yn);  //
					drugDetails.put("DOSAGE_TYPE",dosage_type); //added for IN24132 --07/10/2010-- priya
					drugDetails.put("VALUES_CHANGED","Y"); //added for ML-BRU-SCF-1231 [IN:046657]
					break;
				}
			}
			//}// commented and if( scheduled_yn.equals("Y") closed above to set freq_nature for stat and prn orders for IN24061 --06/10/2010-- priya
		} 
		else if(func_mode != null && func_mode.equals("copy_orders")){
			ArrayList orders =  bean.getPrescriptions();
			if(((String)hash.get("chk_status")).equals("Y")) { 
				if(!orders.contains((String)hash.get( "order_id") +","+ (String)hash.get( "order_line"))){
					orders.add((String)hash.get( "order_id") +","+(String)hash.get( "order_line"));
					orders.add((String)hash.get( "drug_code") );
				}
			} 
			else {
				if(orders.contains((String)hash.get( "order_id") +","+ (String)hash.get( "order_line"))){
					orders.remove(((String)hash.get( "order_id") +","+ (String)hash.get( "order_line")));
					orders.remove((String)hash.get( "drug_code") );
				}
			}
		}
		else if(func_mode != null && func_mode.equals("copy_orders_external")){ // Added for MMS-KH-CRF-0016 - Start
			ArrayList extdrugs =  bean.getExternal_drugs_tmp(); // modifed for Inc#70652
				String srl_no=(String)hash.get( "srl_no");//added for IN070786
		  if(((String)hash.get( "chk_status")).equals("Y")){
			 if(!extdrugs.contains(((String)hash.get( "drug_code")))) {
				 extdrugs.add((String)hash.get( "drug_code"));
				 extdrugs.add((String)hash.get( "srl_no"));//added for IN070786
			 }
		  }
		  else{
			 if(extdrugs.contains(((String)hash.get( "drug_code")))){
				extdrugs.remove((String)hash.get( "drug_code"));
				extdrugs.remove((String)hash.get( "srl_no"));//added for IN070786
			 }
		  } 
			// bean.setExternal_drugs(extdrugs); //  commented for Inc#70652
			bean.setExternal_drugs_tmp(extdrugs); // added for Inc#70652
		} // Added for MMS-KH-CRF-0016 - End
		else if(func_mode != null && func_mode.equals("copy_child")) {
			ArrayList line_details =  bean.getLineDetails();
			ArrayList orders =  bean.getPrescriptions();
			for(int i=0; i<line_details.size(); i++) {
				if(((String)line_details.get(i)).startsWith((String)hash.get( "order_id"))){
					if(!orders.contains((String)line_details.get(i))) {
						orders.add((String)line_details.get(i));
						orders.add((String)line_details.get(i+1));
					}
				}
			}
		}
		else if(func_mode != null && func_mode.equals("delete_child")) {
			ArrayList orders =  bean.getPrescriptions();
			String key		=	"";
			String code		=	"";
			for(int i=0; i<orders.size(); i++) {
				if(((String)orders.get(i)).startsWith((String)hash.get( "order_id"))){
					int index	=	orders.indexOf((String)orders.get(i));
					if(orders.size() >=index) {
						key		=	(String)orders.get(index);
						code	=	(String)orders.get(index+1);
						if(orders.contains(key) && orders.contains(code)) {			
							orders.remove(key);
							orders.remove(code);
							if(i==0) {
								i	=	i-1;
							} 
							else if(i>=2) {
								i = i -2;
							}
						}
					}
				}
			} 
		}
		else if(func_mode != null && func_mode.equals("POPULATEENDDATE")) {
			String start_date	= (String)hash.get( "start_date");
			String durn_value	= (String)hash.get( "durn_value");
			String durn_unit	= (String)hash.get( "durn_unit");
			if(!locale.equals("en"))
				start_date = DateUtils.convertDate(start_date, "DMYHM",locale,"en");
			String end_date		= bean.populateEndDateForSlidingScale(start_date, durn_value, durn_unit);
			if(!locale.equals("en"))
				end_date = DateUtils.convertDate(end_date, "DMYHM",locale,"en");
			out.println("setEndDate(\""+ end_date +"\");");
		}
		
	
		else if(func_mode!= null && func_mode.equals("changeoverridevalue")){
			String drugCode					= (String)hash.get("drug_code");
			String srl_no					= (String)hash.get("srl_no");
			String qty_value	= (String) hash.get( "qty_value" );//added to get the limit_ind value from teh bean
			String repeat_value	= (String) hash.get( "repeat_value" );
			String patient_id	= (String) hash.get( "patient_id" );
			String dosage_type  = (String) hash.get( "dosage_type" );
			String freq_nature  = (String) hash.get( "freq_nature" )==null?"":(String) hash.get( "freq_nature" );
			String calc_def_dosage_yn  = (String) hash.get( "calc_def_dosage_yn" )==null?"":(String) hash.get( "calc_def_dosage_yn" );
			String ext_srl_no				= null;
			String ext_drug_code            = null;
			HashMap ext_drugData            = null;  
			String  limit_ind               = null;
			ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
			ArrayList	schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drugCode+srl_no,"0");
			if(freq_nature.equals("P") || freq_nature.equals("O")){
				for(int j=0;j<prescriptionDetails.size();j++){
				  ext_drugData				=(HashMap) prescriptionDetails.get(j);
				  ext_drug_code				=(String) ext_drugData.get("DRUG_CODE");
				  ext_srl_no				=(String) ext_drugData.get("SRL_NO");
					if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
						ext_drugData.put("LIMIT_IND","Y");
						ext_drugData.put("DOSE_REMARKS","");
						out.println("disableoverride('Y')");
						return;
					 }
				}
			}
			if(schedule.size() > 0){
				/*HashMap detail	=	(HashMap)schedule.get(0);
				qty_value		=	(String)detail.get("admin_qty");*/
				ArrayList dose_list		= (ArrayList)schedule.get(4);
				if(dose_list!=null && dose_list.size()>0)
					qty_value		= (String)dose_list.get(0);
			}
			if(calc_def_dosage_yn.equals("Y")){
				HashMap dosageDetails= (HashMap) presBean.chkMaxDosageLimit(drugCode,patient_id,qty_value,dosage_type,repeat_value);
				limit_ind= (String) dosageDetails.get("LIMIT_IND");
			}
			for(int j=0;j<prescriptionDetails.size();j++){//added to get the limit_ind value from teh bean
				ext_drugData				=(HashMap) prescriptionDetails.get(j);
				ext_drug_code				=(String) ext_drugData.get("DRUG_CODE");
				ext_srl_no				=(String) ext_drugData.get("SRL_NO");
				if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
					ext_drugData.put("LIMIT_IND",limit_ind);
					if(limit_ind.equals("Y"))
						ext_drugData.put("DOSE_REMARKS","");
				}
			}
			out.println("disableoverride(\""+limit_ind+"\")");
		}
		else if (func_mode!= null && func_mode.equals("extDosageCheck")){
			String patient_id				  = (String)hash.get("patient_id")==null?"":(String) hash.get( "patient_id" );
			String encounter_id				  = (String)hash.get("encounter_id")==null?"":(String) hash.get( "encounter_id" );
			String drugCode					  = (String)hash.get("drug_code")==null?"":(String) hash.get( "drug_code" );
			String srl_no					  = (String)hash.get("srl_no")==null?"":(String) hash.get( "srl_no" );
			String ext_prod_id				  = (String)hash.get("ext_prod_id")==null?"":(String) hash.get( "ext_prod_id" );
			String drug_db_dosecheck_yn	      = (String) hash.get("drug_db_dosecheck_yn")==null?"":(String) hash.get("drug_db_dosecheck_yn");
			String drug_db_duptherapy_yn      = (String) hash.get("drug_db_duptherapy_yn")==null?"":(String) hash.get("drug_db_duptherapy_yn");
			String drug_db_interact_check_yn  = (String) hash.get("drug_db_interact_check_yn")==null?"":(String) hash.get("drug_db_interact_check_yn");
			String drug_db_contraind_check_yn = (String) hash.get("drug_db_contraind_check_yn")==null?"":(String) hash.get("drug_db_contraind_check_yn");
			String drug_db_allergy_check_yn   = (String) hash.get("drug_db_allergy_check_yn")==null?"":(String) hash.get("drug_db_allergy_check_yn");
			String pract_name	= (String) hash.get( "pract_name" )==null?"":(String) hash.get( "pract_name" );
			String dsg_reason	= (String) hash.get( "dsg_reason" )==null?"":(String) hash.get( "dsg_reason" );
			String dup_reason	= (String) hash.get( "dup_reason" )==null?"":(String) hash.get( "dup_reason" );
			String con_reason	= (String) hash.get( "con_reason" )==null?"":(String) hash.get( "con_reason" );
			String int_reason	= (String) hash.get( "int_reason" )==null?"":(String) hash.get( "int_reason" );
			String alg_reason	= (String) hash.get( "alg_reason" )==null?"":(String) hash.get( "alg_reason" );
			String dose_uom  = (String) hash.get( "dose_uom" )==null?"":(String) hash.get( "dose_uom" ); // added for SKR-SCF-0561 [IN:033486]
			String tappered_over	= "";
			String callfrom	= (String) hash.get( "callfrom" )==null?"":(String) hash.get( "callfrom" );
			String ext_drug_code="";
			String ext_srl_no="";
			String drug_db_dosage_check_flag      ="N"; 
			String drug_db_contraind_check_flag	="N";
			String drug_db_interact_check_flag	="N";
			String drug_db_duptherapy_flag		="N";
			String drug_db_allergy_flag		="N";
			String ext_beanid = "@ExternalProductLinkBean";
			String ext_beanname = "ePH.ExternalProductLinkBean";
			ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);
			HashMap drug_detail= null;
			ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
			if(!ext_prod_id.equals("")){
				if(drug_db_dosecheck_yn.equals("Y")){
					String weight	= (String) hash.get( "weight" )==null?"0":(String) hash.get( "weight" );
					String bsa	= (String) hash.get( "bsa" )==null?"0":(String) hash.get( "bsa" );
					String dosage  = (String) hash.get( "dosage" )==null?"0":(String) hash.get( "dosage" );
					//String dose_uom  = (String) hash.get( "dose_uom" )==null?"":(String) hash.get( "dose_uom" ); //commented  for SKR-SCF-0561 [IN:033486] 
					String repeat_value	= (String) hash.get( "repeat_value" )==null?"1":(String) hash.get( "repeat_value" );
					String interval_value	= (String)hash.get("interval_value")==null?"1":(String) hash.get( "interval_value" );
					String duration	= (String) hash.get( "duration" )==null?"":(String) hash.get( "duration" );
					String dosage_by	= (String) hash.get( "dosage_by" )==null?"":(String) hash.get( "dosage_by" );
					String split_dose_yn	= (String) hash.get( "split_dose_yn" )==null?"":(String) hash.get( "split_dose_yn" );
					String fract_dose_round_up_yn	=	(String) hash.get( "fract_dose_round_up_yn" )==null?"":(String) hash.get( "fract_dose_round_up_yn" );
					String strength_per_value_pres_uom	= (String) hash.get( "strength_per_value_pres_uom" )==null?"1":(String) hash.get( "strength_per_value_pres_uom" );
					String strength_per_pres_uom			= (String) hash.get( "strength_per_pres_uom" )==null?"1":(String) hash.get( "strength_per_pres_uom" );
					// Code added for IN23562 --08/09/2010-- priya -Start
					String repeat_durn_type	= hash.get("repeat_durn_type")==null?"":(String) hash.get( "repeat_durn_type" );
					String durn_type	= hash.get( "durn_type" )==null?"":(String) hash.get( "durn_type" );
					String freq_nature	= hash.get( "freq_nature" )==null?"":(String) hash.get( "freq_nature" );
					String tmp_durn_value	= hash.get( "tmp_durn_value" )==null?"1":(String) hash.get( "tmp_durn_value" );
					String route_code	= (String)hash.get("route_code")==null?"":(String) hash.get( "route_code" );// Added in January 2014 for CIMS dosage check
					String qty_desc_code= (String)hash.get("qty_desc_code")==null?"":(String) hash.get( "qty_desc_code" );// Added in January 2014 for CIMS dosage check
					String frequency = "";
					String freq_nature_pas = "I";	  //Added in January 2014, CIMS Dosage Check
					double num =1.0;
					double day_num =1.0;
					if(interval_value.equals("0") || interval_value.equals(""))
						interval_value = "1";
					if(freq_nature.equals("I")){
						 frequency = ( Float.parseFloat(tmp_durn_value) /Float.parseFloat(interval_value))+""; //  removed Math.ceil and (int) for IN23562 reopen --30/09/2010-- priya
						if(durn_type.equals("M")){
							num = new Float(Math.ceil( (60*24)/Float.parseFloat(tmp_durn_value))).intValue();
							day_num = new Float(Math.ceil( Float.parseFloat(tmp_durn_value)/(60*24))).intValue();
							frequency = new Float(Math.ceil((Float.parseFloat(frequency)*((int)num))/(int)day_num) ).intValue() + "";
						}
						else if(durn_type.equals("H")){
							 num =new Float(/*Math.ceil(*/ (24)/ Float.parseFloat(tmp_durn_value)); //ceil commented for IN23562 reopen //.intValue()--23/09/2010-- priya
							// day_num =new Float(Math.ceil( Float.parseFloat(tmp_durn_value)/(24)));//.intValue()
							day_num = Float.parseFloat(tmp_durn_value)/(24);
							// if(Float.parseFloat(frequency) < 1.0)
							//	 frequency = new Float(Math.ceil((Float.parseFloat(frequency)*(num)))/day_num ).intValue() + "";
							// else
							frequency = new Float(Math.ceil((Float.parseFloat(frequency))/day_num) ).intValue() + "";
						}
						else if(durn_type.equals("W")){ //will not enter
							num = new Float(Math.ceil( Float.parseFloat(tmp_durn_value)*7)).intValue();
							day_num = new Float(Math.ceil( Float.parseFloat(tmp_durn_value)*7)).intValue();
							frequency = new Float(Math.ceil(Float.parseFloat(frequency)*(int)day_num) ).intValue() + "";
						}
						else{
							frequency = new Float(Math.ceil(Float.parseFloat(frequency)*(int)num) ).intValue() + "";
						}
					}
					else{   //	if(!(freq_nature.equals("I")))
						 frequency = (int)Math.ceil( Float.parseFloat(repeat_value) /Float.parseFloat(interval_value))+"";
					}
					if(frequency.equals("0"))
						frequency = "1";	// Code added for IN23562 --08/09/2010-- priya -End
					if(dosage_by != null && dosage_by.equals("S")){
						dosage		=(Float.parseFloat(dosage)*Float.parseFloat(strength_per_value_pres_uom))+"";
						dosage		=	(float)(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom))+"";
						DecimalFormat dfTest = new DecimalFormat("##.##");
						dosage = dfTest.format(Double.parseDouble(dosage));
					}
					if(split_dose_yn.equals("Y")){
						frequency="1";
					}

					HashMap drugDBCheckResult = null;
					HashMap drugDosageResult = null;
					ArrayList dosageCheckParams = new ArrayList();
					dosageCheckParams.add(patient_id);
					dosageCheckParams.add(ext_prod_id);
					dosageCheckParams.add(weight);
					dosageCheckParams.add(bsa);
					dosageCheckParams.add(dosage);
					if(ext_beanObj!=null && (ext_beanObj.getProdID()).equals("CIMS"))  // Added in January 2014 - DOSAGE Checks Added
						dosageCheckParams.add(qty_desc_code);	// Added in January 2014 - DOSAGE Checks Added
					else
						dosageCheckParams.add(dose_uom);
					//dosageCheckParams.add(dose_uom);
					dosageCheckParams.add(frequency);
					if(freq_nature.equals("I")){   //added if-else condition IN23562 --08/09/2010-- priya
						dosageCheckParams.add((new Float(day_num).intValue())+""); 
					}
					else{//replaced duration with tmp_durn_value for IN24020 --06/10/2010-- priya
						if(tmp_durn_value.equals(""))
							dosageCheckParams.add(duration);  
						else
							dosageCheckParams.add(tmp_durn_value);  
					}
					dosageCheckParams.add(route_code);	 // Added in January 2014 for CIMS-Dosage Checks -start
					dosageCheckParams.add(repeat_durn_type);	 
					 if(freq_nature!=null && !freq_nature.equals(""))
						 freq_nature_pas =  freq_nature;
					 dosageCheckParams.add(freq_nature_pas);	
					 dosageCheckParams.add(interval_value);	 // Added in January 2014 for CIMS-Dosage Checks -end
					//drugDosageResult = ext_beanObj.getDrugDosageCheck(dosageCheckParams); 
					ArrayList reqChecks = new ArrayList();
					reqChecks.add("Y"); //Dosage Check 
					reqChecks.add("N"); //Duplicate Check
					reqChecks.add("N"); //DrugInteraction
					reqChecks.add("N"); //Contra Indication
					reqChecks.add("N"); //AllergyCheck
					drugDBCheckResult = ext_beanObj.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", null ,null, dosageCheckParams, "N","",""); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
					drug_db_dosage_check_flag = "N";
					if(drugDBCheckResult != null && drugDBCheckResult.size() > 0){
						drugDosageResult = (HashMap)drugDBCheckResult.get("DOSECHECK");
						if(drugDosageResult != null && drugDosageResult.size() > 0){
							ext_beanObj.setDosageCheck(ext_prod_id, srl_no,drugDosageResult);
							drug_db_dosage_check_flag = "Y";
						}
					}
					for(int j=0;j<prescriptionDetails.size();j++){
						drug_detail				=(HashMap) prescriptionDetails.get(j);
						ext_drug_code				=(String) drug_detail.get("DRUG_CODE");
						ext_srl_no				=(String) drug_detail.get("SRL_NO");
						if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
							drug_detail.put("DRUG_DB_DOSAGE_CHECK_FLAG",drug_db_dosage_check_flag);
							break;
						}
					}
				}
					for(int j=0;j<prescriptionDetails.size();j++){
						drug_detail				=(HashMap) prescriptionDetails.get(j);
						ext_drug_code				=(String) drug_detail.get("DRUG_CODE");
						ext_srl_no				=(String) drug_detail.get("SRL_NO");
						if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
							drug_db_contraind_check_flag	= (String)drug_detail.get("DRUG_DB_CONTRAIND_CHECK_FLAG")==null?"N":(String)drug_detail.get("DRUG_DB_CONTRAIND_CHECK_FLAG");	
							drug_detail.put("OR_QTY_DESC",bean.getUomDisplay((String)session.getValue("facility_id"),dose_uom));  // added for SKR-SCF-0561 [IN:033486] 	
							drug_db_interact_check_flag	=  (String)drug_detail.get("DRUG_DB_INTERACT_CHECK_FLAG")==null?"N":(String)drug_detail.get("DRUG_DB_INTERACT_CHECK_FLAG");		
							drug_db_duptherapy_flag		=  (String)drug_detail.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"N":(String)drug_detail.get("DRUG_DB_DUPTHERAPY_FLAG");		
							drug_db_allergy_flag		=  (String)drug_detail.get("DRUG_DB_ALLERGY_FLAG")==null?"N":(String)drug_detail.get("DRUG_DB_ALLERGY_FLAG");		
							break;
						}
					}
					//}//Commented for control Multiple EXTDB Checks
					if((drug_db_dosage_check_flag.equals("Y"))||drug_db_interact_check_flag.equals("Y")||drug_db_duptherapy_flag.equals("Y")||drug_db_contraind_check_flag.equals("Y") ||drug_db_allergy_flag.equals("Y")){
						if(drug_detail!=null)
							drug_detail.put("DRUG_DB_OVERRIDE_FLAG","Y");
						out.println("displayDosageCheckResult('"+patient_id+"','"+java.net.URLEncoder.encode(pract_name,"UTF-8")+"','"+encounter_id+"','"+ext_prod_id+"','"+drugCode+"','"+srl_no+"','"+drug_db_dosage_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_interact_check_flag+"','"+drug_db_allergy_flag+"','"+java.net.URLEncoder.encode(dsg_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(dup_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(con_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(int_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(alg_reason,"UTF-8")+"','"+callfrom+"');");
					}
					else{
					//if(!(drug_db_dosage_check_flag.equals("Y")||drug_db_contraind_check_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_allergy_flag.equals("Y"))){
					// commented below if codition for the incident no:SRR20056-SCF-6435.3[Incident No. 27028]
							out.println("hideDosageCheckIcon('"+drugCode+"','"+srl_no+"');");
							if(drug_detail!=null)
								drug_detail.put("DRUG_DB_OVERRIDE_FLAG","N");
						//	drug_detail.put("EXT_DDB_DSG_REASON",""); //Commented while fixing  IN26326 --04/02/2011-- priya (dosage reason was getting reset on confirming and reloading the drug)
					//	}
				}
			}
			else{  // else block added for SKR-SCF-0561 [IN:033486] 
				for(int j=0;j<prescriptionDetails.size();j++){
					drug_detail				=(HashMap) prescriptionDetails.get(j);
					ext_drug_code				=(String) drug_detail.get("DRUG_CODE");
					ext_srl_no				=(String) drug_detail.get("SRL_NO");
					if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
						drug_detail.put("OR_QTY_DESC",bean.getUomDisplay((String)session.getValue("facility_id"),dose_uom));  // added for SKR-SCF-0561 [IN:033486] 	
						break;
					}
				}
			}
			putObjectInBean(ext_beanid,ext_beanObj,request);
		}
		else if (func_mode!= null && func_mode.equals("extDosageCheckFromPad")){
			String patient_id					= (String)hash.get("patient_id")==null?"":(String) hash.get( "patient_id" );
			String encounter_id					= (String)hash.get("encounter_id")==null?"":(String) hash.get( "encounter_id" );
			String drugCode					= (String)hash.get("drug_code")==null?"":(String) hash.get( "drug_code" );
			String srl_no					= (String)hash.get("srl_no")==null?"":(String) hash.get( "srl_no" );
			String ext_prod_id					= (String)hash.get("ext_prod_id")==null?"":(String) hash.get( "ext_prod_id" );
			String weight	= (String) hash.get( "weight" )==null?"0":(String) hash.get( "weight" );
			String bsa	= (String) hash.get( "bsa" )==null?"0":(String) hash.get( "bsa" );
			String callfrom	= (String) hash.get( "callfrom" )==null?"":(String) hash.get( "callfrom" );
			String drug_db_product_id =  (String) hash.get("drug_db_product_id")==null?"":(String) hash.get("drug_db_product_id");
			String drug_db_dosecheck_yn	  = (String) hash.get("drug_db_dosecheck_yn")==null?"":(String) hash.get("drug_db_dosecheck_yn");
			String drug_db_duptherapy_yn      = (String) hash.get("drug_db_duptherapy_yn")==null?"":(String) hash.get("drug_db_duptherapy_yn");
			String drug_db_interact_check_yn  = (String) hash.get("drug_db_interact_check_yn")==null?"":(String) hash.get("drug_db_interact_check_yn");
			String drug_db_contraind_check_yn = (String) hash.get("drug_db_contraind_check_yn")==null?"":(String) hash.get("drug_db_contraind_check_yn");
			String drug_db_allergy_check_yn   = (String) hash.get("drug_db_allergy_check_yn")==null?"":(String) hash.get("drug_db_allergy_check_yn");
			String pract_name	= (String) hash.get( "pract_name" )==null?"":(String) hash.get( "pract_name" );
			String tappered_over = "";
			String dsg_reason	= "";
			String dup_reason	= "";
			String con_reason	= "";
			String int_reason	= "";
			String alg_reason	= "";
			String ext_drug_code="";
			String ext_srl_no="";
			String drug_db_contraind_check_flag	="N";
			String drug_db_interact_check_flag	="N";
			String drug_db_duptherapy_flag		="N";
			String drug_db_dosage_check_flag      ="N"; 
			String drug_db_allergy_flag		="N";
			String ext_beanid = "@ExternalProductLinkBean";
			String ext_beanname = "ePH.ExternalProductLinkBean";
			ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);
			ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
			HashMap drug_detail= null;
			//if(drug_db_dosecheck_yn.equals("Y") ) // This condition moved below (else other reasons were not getting stored) --22/11/2010-- priya
			String dosage  = "", dose_uom ="", repeat_value="", interval_value= "", duration= "",dosage_by= "",split_dose_yn= "",fract_dose_round_up_yn	="", strength_per_value_pres_uom	="", strength_per_pres_uom	="",repeat_durn_type = "",durn_type = "",freq_nature = "",tmp_durn_value = "", frequency = "", route_code = "",qty_desc_code  = "" ,chk_durn_type = "" , freq_nature_pas = "I";	  //Added in January 2014, CIMS Dosage Check ;
			double num =1.0;
			double day_num =1.0;
			for(int j=0;j<prescriptionDetails.size();j++){
				drug_detail				=(HashMap) prescriptionDetails.get(j);
				ext_drug_code				=(String) drug_detail.get("DRUG_CODE");
				ext_srl_no				=(String) drug_detail.get("SRL_NO");
				if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
					dosage  = (String) drug_detail.get("QTY_VALUE");
					dose_uom  = (String) drug_detail.get("PRES_BASE_UOM");
					repeat_value	=	(String) drug_detail.get("REPEAT_VALUE")==null?"1":(String) drug_detail.get("REPEAT_VALUE");
					interval_value					= (String) drug_detail.get("INTERVAL_VALUE")==null?"1":(String) drug_detail.get("INTERVAL_VALUE");
					duration	= (String) drug_detail.get("DURN_VALUE");
					dosage_by	= (String) drug_detail.get("DOSAGE_TYPE");
					split_dose_yn	= (String) drug_detail.get("SPLIT_DOSE_YN_VAL");
					fract_dose_round_up_yn	=	(String) drug_detail.get("FRACT_DOSE_ROUND_UP_YN");
					strength_per_value_pres_uom	= (String) drug_detail.get("STRENGTH_PER_VALUE_PRES_UOM");
					strength_per_pres_uom			= (String) drug_detail.get("STRENGTH_PER_PRES_UOM");
					dsg_reason	= (String) drug_detail.get( "EXT_DDB_DSG_REASON" )==null?"":(String) drug_detail.get( "EXT_DDB_DSG_REASON" );    
					dup_reason	= (String) drug_detail.get( "EXT_DDB_DUP_REASON" )==null?"":(String) drug_detail.get( "EXT_DDB_DUP_REASON" );  
					con_reason	= (String) drug_detail.get( "EXT_DDB_CON_REASON" )==null?"":(String) drug_detail.get( "EXT_DDB_CON_REASON" );  
					int_reason	= (String) drug_detail.get( "EXT_DDB_INT_REASON" )==null?"":(String) drug_detail.get( "EXT_DDB_INT_REASON" );      
					alg_reason	= (String) drug_detail.get( "EXT_DDB_ALG_REASON" )==null?"":(String) drug_detail.get( "EXT_DDB_ALG_REASON" );      
					if(drug_db_dosecheck_yn.equals("Y") ){ // moved here from above
						// Code added for IN23562 --08/09/2010-- priya
						repeat_durn_type	= drug_detail.get("REPEAT_DURN_TYPE")==null?"":(String) drug_detail.get( "REPEAT_DURN_TYPE" );
						//	durn_type	= drug_detail.get( "DURN_TYPE" )==null?"":(String) drug_detail.get( "DURN_TYPE" );
						//replaced DURN_TYPE with REPEAT_DURN_TYPE for IN 24131 --14/10/2010-- priya
						chk_durn_type   =   drug_detail.get( "DURN_TYPE" )==null?"":(String) drug_detail.get( "DURN_TYPE" );
						durn_type	= drug_detail.get( "REPEAT_DURN_TYPE" )==null?"":(String) drug_detail.get( "REPEAT_DURN_TYPE" );
						freq_nature	= drug_detail.get( "FREQ_NATURE" )==null?"":(String) drug_detail.get( "FREQ_NATURE" );
						tmp_durn_value= drug_detail.get("FREQ_DURN_VALUE" )==null?"1":(String) drug_detail.get("FREQ_DURN_VALUE" );
						route_code		= drug_detail.get("ROUTE_CODE" )==null?"":(String) drug_detail.get("ROUTE_CODE" );	//Added in January 2014, CIMS Dosage Check
						qty_desc_code	= drug_detail.get("QTY_DESC_CODE" )==null?"":(String) drug_detail.get("QTY_DESC_CODE" );	//Added in January 2014, CIMS Dosage Check
						frequency = "";
						num =1.0;
						day_num =1.0;
						if(interval_value.equals("0") || interval_value.equals(""))
							interval_value = "1";
						if(freq_nature.equals("I")){
							frequency = ( Float.parseFloat(tmp_durn_value) /Float.parseFloat(interval_value))+""; // removed Math.ceil and (int) for IN23562 reopen --30/09/2010-- priya
							if(durn_type.equals("M")){
								 num = new Float(Math.ceil( (60*24)/Float.parseFloat(tmp_durn_value))).intValue();
								 day_num = new Float(Math.ceil( Float.parseFloat(tmp_durn_value)/(60*24))).intValue();
								 frequency = new Float(Math.ceil((Float.parseFloat(frequency)*((int)num))/(int)day_num) ).intValue() + "";
							}
							else if(durn_type.equals("H")){
								num =new Float(/*Math.ceil( */(24)/ Float.parseFloat(tmp_durn_value)); //ceil commented for IN23562 reopen -23/09/2010- priya  //.intValue()
								day_num = Float.parseFloat(tmp_durn_value)/(24);
								frequency = new Float(Math.ceil((Float.parseFloat(frequency))/day_num)   ).intValue() + "";
							}
							else if(durn_type.equals("W")){ //will not enter
								 num = new Float(Math.ceil( Float.parseFloat(tmp_durn_value)*7)).intValue();
								 day_num = new Float(Math.ceil( Float.parseFloat(tmp_durn_value)*7)).intValue();
								 frequency = new Float(Math.ceil(Float.parseFloat(frequency)*(int)day_num) ).intValue() + "";
							}
							else
								frequency = new Float(Math.ceil(Float.parseFloat(frequency)*(int)num) ).intValue() + "";
						}
						else
							 frequency = (int)Math.ceil(Float.parseFloat(repeat_value) /Float.parseFloat(interval_value))+"";
						if(frequency.equals("0"))
							frequency = "1";
						if(dosage_by != null && dosage_by.equals("S")){
							dosage		=(Float.parseFloat(dosage)*Float.parseFloat(strength_per_value_pres_uom))+"";
							dosage		=	(float)(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom))+"";
							DecimalFormat dfTest = new DecimalFormat("##.##");
							dosage = dfTest.format(Double.parseDouble(dosage));
						}
						if(split_dose_yn.equals("Y")){
							frequency="1";
						}
						HashMap drugDosageResult = null;
						HashMap drugDBCheckResult = null;
						ArrayList dosageCheckParams = new ArrayList();
						dosageCheckParams.add(patient_id);
						dosageCheckParams.add(ext_prod_id);
						dosageCheckParams.add(weight);
						dosageCheckParams.add(bsa);
						dosageCheckParams.add(dosage);
						if(ext_beanObj!=null && (ext_beanObj.getProdID()).equals("CIMS")) { // Added in January 2014 - DOSAGE Checks Added
							if(durn_type!=null && durn_type.equals("") && chk_durn_type!=null && !chk_durn_type.equals(""))
								durn_type = chk_durn_type;
							if(freq_nature!=null && !freq_nature.equals(""))
								freq_nature_pas	= freq_nature;
							dosageCheckParams.add(qty_desc_code);	// Added in January 2014 - DOSAGE Checks Added
						}
						else
							dosageCheckParams.add(dose_uom);
						dosageCheckParams.add(frequency);
						if(freq_nature.equals("I")){  //if-else condition added for IN23562 --08/09/2010-- priya
							dosageCheckParams.add((new Float(day_num).intValue())+""); 
						}
						else{
							if(tmp_durn_value.equals(""))//replaced duration with tmp_durn_value for IN24020 --06/10/2010-- priya
								dosageCheckParams.add(duration);  
							else
								dosageCheckParams.add(tmp_durn_value);  
						}
						dosageCheckParams.add(route_code); //route_code Added in January 2014 - CIMS Dosage checks, same to be added for other rx jsp too
						dosageCheckParams.add(durn_type);	 // Added in January 2014 for CIMS-Dosage Checks,  same to be added in other rx jsp
						dosageCheckParams.add(freq_nature_pas);	 // Added in January 2014 for CIMS-Dosage Checks,  same to be added in other rx jsp
						dosageCheckParams.add(interval_value);	 // Added in January 2014 for CIMS-Dosage Checks,  same to be added in other rx jsp
						ArrayList reqChecks = new ArrayList();
						reqChecks.add("Y"); //Dosage Check 
						reqChecks.add("N"); //Duplicate Check
						reqChecks.add("N"); //DrugInteraction
						reqChecks.add("N"); //Contra Indication
						reqChecks.add("N"); //AllergyCheck
						drugDBCheckResult = ext_beanObj.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", null ,null, dosageCheckParams, "N","",""); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
						drug_db_dosage_check_flag = "N";
						if(drugDBCheckResult != null && drugDBCheckResult.size() > 0){
							drugDosageResult = (HashMap)drugDBCheckResult.get("DOSECHECK");
							if(drugDosageResult != null && drugDosageResult.size() > 0){
								ext_beanObj.setDosageCheck(ext_prod_id, srl_no,drugDosageResult);
								drug_db_dosage_check_flag = "Y";
							}
						}
						drug_detail.put("DRUG_DB_DOSAGE_CHECK_FLAG",drug_db_dosage_check_flag);
					} //end if(drug_db_dosecheck_yn.equals("Y")
					break;
				}
			}
			if(callfrom!=null && callfrom.equals("PADLOAD")){ //If condition and else block added for control Multiple EXTDB Checks
				String dup_drug_det			    = "";
				String ext_db_drug_code = "";
				ArrayList exProd				= new ArrayList();
				ArrayList drugDesc				= new ArrayList();
				String startdate="", enddate="";// Added for ML-BRU-SCF-0811 [IN:039394]
				for(int i=0;i<prescriptionDetails.size();i++){
					drug_detail				=(HashMap) prescriptionDetails.get(i);
					ext_db_drug_code				=(String) drug_detail.get("EXTERNAL_PRODUCT_ID");
					ext_drug_code	= (String) drug_detail.get("DRUG_CODE");
					ext_srl_no				=(String) drug_detail.get("SRL_NO");
					tappered_over	= drug_detail.get( "TAPPERED_OVER" )==null?"":(String) drug_detail.get( "TAPPERED_OVER" );
					if(!ext_db_drug_code.equals("")  && !(tappered_over.equals("Y"))){ //added && !(tappered_over.equals("Y")) for IN23796 --22/10/2010-- priya
						exProd.add((String)drug_detail.get("EXTERNAL_PRODUCT_ID"));
						drugDesc.add((String)drug_detail.get("DRUG_DESC")); // moved here from outside if condition for IN25896 --27/01/2011-- priya
					}
					if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
						drug_detail.put("DRUG_DB_PRODUCT_ID",drug_db_product_id);
						startdate	= (String) drug_detail.get( "START_DATE" )==null?"":(String) drug_detail.get( "START_DATE" );// Added for ML-BRU-SCF-0811 [IN:039394]
						enddate		= (String) drug_detail.get( "END_DATE" )==null?"":(String) drug_detail.get( "END_DATE" );// Added for ML-BRU-SCF-0811 [IN:039394]
					}
				}
				if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") ){
					String storeIDs = "N";
					if(exProd.size()>0 && !(tappered_over.equals("Y")))
						storeIDs = "Y";
					HashMap tempDetails= null;
					HashMap tempDetailList = null;   /* Added in JUNE 2012 - New changes - Health Care Interaction */
					String ext_prod_id_without_delim       =    "";	  /* Added in JUNE 2012 - New changes - Health Care Interaction */
					ArrayList reqChecks = new ArrayList();
					if(ext_beanObj!=null && (ext_beanObj.getProdID()).equals("CIMS"))  // Added in JUNE 2012 - DOSAGE Checks Added
					   reqChecks.add(drug_db_dosecheck_yn); //Dosage Check
					else
						reqChecks.add("N"); //Dosage Check  // FDB
					reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
					reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
					reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
					reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
					//Modified for TFS id:-16701 start
					HashMap drugDBCheckResult = null;
					if(ext_beanObj!=null && (ext_beanObj.getProdID()).equals("CIMS") && bean.getCalExtDBYN().equals("N") && storeIDs.equals("Y")){
						 drugDBCheckResult = (HashMap)ext_beanObj.getExternalDBChecksNew( reqChecks, ext_prod_id);
					}
					else{
						bean.setCalExtDBYN("N");
					drugDBCheckResult = (HashMap)ext_beanObj.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,drugDesc, null, storeIDs,startdate,enddate); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean
					}
					 //Modified for TFS id:-16701 end
					if(drugDBCheckResult!=null)
						ext_beanObj.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
					if(drug_db_allergy_check_yn.equals("Y")){
					   if(ext_beanObj!=null && ext_beanObj.getProdID()!=null && (ext_beanObj.getProdID()).equals("CIMS")){ // for CIMS)
						   String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK"); //IN066787- Performance
						   if(allergy_alert!=null && !allergy_alert.equals(""))
								drug_db_allergy_flag="Y";
					   } 
					   else {  
							tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
							if(tempDetails!=null && tempDetails.size()>0){
								 drug_db_allergy_flag="Y";
							}
						} 
					}
					if(drug_db_interact_check_yn.equals("Y")){
						tempDetails =(HashMap)drugDBCheckResult.get("INTRACHECK");
						if(tempDetails!=null && tempDetails.size()>0){
							 drug_db_interact_check_flag="Y";
						}
					}
					if(drug_db_duptherapy_yn.equals("Y")){ 
					   dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
					   if(dup_drug_det!=null && !dup_drug_det.equals(""))
							drug_db_duptherapy_flag="Y";
					}
					if(drug_db_contraind_check_yn.equals("Y")){
						if(ext_beanObj!=null && ext_beanObj.getProdID()!=null && (ext_beanObj.getProdID()).equals("CIMS")){ // for CIMS
							tempDetailList = (HashMap)drugDBCheckResult.get("HEALTHINTRACHECK");	 /* Added in JUNE 2012 - New changes - Health Care Interaction */
						if(tempDetailList!=null && tempDetailList.size()>0){ //IN066787- Performance
							 drug_db_contraind_check_flag="Y";
						}
						
						}
						else{
							tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
							if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
								drug_db_contraind_check_flag="Y";
							}	
						}
					}
				}
				for(int j=0;j<prescriptionDetails.size();j++){
					drug_detail				=(HashMap) prescriptionDetails.get(j);
					ext_drug_code				=(String) drug_detail.get("DRUG_CODE");
					ext_srl_no				=(String) drug_detail.get("SRL_NO");
					if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
						drug_detail.put("DRUG_DB_DOSAGE_CHECK_FLAG",drug_db_dosage_check_flag);
						drug_detail.put("DRUG_DB_CONTRAIND_CHECK_FLAG",drug_db_contraind_check_flag);
						drug_detail.put("DRUG_DB_INTERACT_CHECK_FLAG",drug_db_interact_check_flag);
						drug_detail.put("DRUG_DB_DUPTHERAPY_FLAG",drug_db_duptherapy_flag);
						drug_detail.put("DRUG_DB_ALLERGY_FLAG",drug_db_allergy_flag);
						if(drug_db_allergy_flag.equals("Y"))
							drug_detail.put("ALLERGY_YN","N");
						if(drug_db_duptherapy_flag.equals("Y")){
							drug_detail.put("CURRENT_RX","N");
							//drug_detail.put("ORIG_CURRENT_RX","N"); //Commented for [IN:044495]
							drug_detail.put("CURRENTRX_REMARKS","");  //Added for [IN:044495]
						}
						break;
					}
				}
			}//End If condition for control Multiple EXTDB Checks
			else{ //Else block added for control Multiple EXTDB Checks
				for(int j=0;j<prescriptionDetails.size();j++){
					drug_detail		=(HashMap) prescriptionDetails.get(j);
					ext_drug_code	=(String) drug_detail.get("DRUG_CODE");
					ext_srl_no		=(String) drug_detail.get("SRL_NO");
					if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
						drug_db_contraind_check_flag	= (String)drug_detail.get("DRUG_DB_CONTRAIND_CHECK_FLAG")==null?"N":(String)drug_detail.get("DRUG_DB_CONTRAIND_CHECK_FLAG");		
						drug_db_interact_check_flag	=  (String)drug_detail.get("DRUG_DB_INTERACT_CHECK_FLAG")==null?"N":(String)drug_detail.get("DRUG_DB_INTERACT_CHECK_FLAG");		
						drug_db_duptherapy_flag		=  (String)drug_detail.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"N":(String)drug_detail.get("DRUG_DB_DUPTHERAPY_FLAG");
						drug_db_allergy_flag		=  (String)drug_detail.get("DRUG_DB_ALLERGY_FLAG")==null?"N":(String)drug_detail.get("DRUG_DB_ALLERGY_FLAG");		
						break;
					}
				}
			}
			if((drug_db_dosage_check_flag.equals("Y"))||drug_db_interact_check_flag.equals("Y")||drug_db_duptherapy_flag.equals("Y")||drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_flag.equals("Y")){
				out.println("displayDosageCheckResult('"+patient_id+"','"+java.net.URLEncoder.encode(pract_name,"UTF-8")+"','"+encounter_id+"','"+ext_prod_id+"','"+drugCode+"','"+srl_no+"','"+drug_db_dosage_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_interact_check_flag+"','"+drug_db_allergy_flag+"','"+java.net.URLEncoder.encode(dsg_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(dup_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(con_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(int_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(alg_reason,"UTF-8")+"','"+callfrom+"');");
			}
			else{  //else condition added for IN25277  --06/01/2011-- priya
				out.println("displayDosageCheckResult('"+patient_id+"','"+java.net.URLEncoder.encode(pract_name,"UTF-8")+"','"+encounter_id+"','"+ext_prod_id+"','"+drugCode+"','"+srl_no+"','"+drug_db_dosage_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_interact_check_flag+"','"+drug_db_allergy_flag+"','"+java.net.URLEncoder.encode(dsg_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(dup_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(con_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(int_reason,"UTF-8")+"','"+java.net.URLEncoder.encode(alg_reason,"UTF-8")+"','PADLOAD'"+");");
			}
			putObjectInBean(ext_beanid,ext_beanObj,request);
		}
		else if (func_mode!= null && func_mode.equals("extDosageCheckResult")){
			String drugCode					= (String)hash.get("drug_code")==null?"":(String) hash.get( "drug_code" );
			String srl_no					= (String)hash.get("srl_no")==null?"":(String) hash.get( "srl_no" );
			String dsg_reason	= (String) hash.get( "dsg_reason" )==null?"":(String) hash.get( "dsg_reason" );
			String dup_reason	= (String) hash.get( "dup_reason" )==null?"":(String) hash.get( "dup_reason" );
			String con_reason	= (String) hash.get( "con_reason" )==null?"":(String) hash.get( "con_reason" );
			String int_reason	= (String) hash.get( "int_reason" )==null?"":(String) hash.get( "int_reason" );
			String alg_reason	= (String) hash.get( "alg_reason" )==null?"":(String) hash.get( "alg_reason" );
			String ext_drug_code="";
			String ext_srl_no="";
			HashMap drug_detail= null;
			ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
			for(int j=0;j<prescriptionDetails.size();j++){
				drug_detail				=(HashMap) prescriptionDetails.get(j);
				ext_drug_code				=(String) drug_detail.get("DRUG_CODE");
				ext_srl_no				=(String) drug_detail.get("SRL_NO");
				if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
					drug_detail.put("EXT_DDB_DSG_REASON",java.net.URLDecoder.decode(dsg_reason,"UTF-8"));
					drug_detail.put("EXT_DDB_DUP_REASON",java.net.URLDecoder.decode(dup_reason,"UTF-8"));
					drug_detail.put("EXT_DDB_CON_REASON",java.net.URLDecoder.decode(con_reason,"UTF-8"));
					drug_detail.put("EXT_DDB_INT_REASON",java.net.URLDecoder.decode(int_reason,"UTF-8"));
					drug_detail.put("EXT_DDB_ALG_REASON",java.net.URLDecoder.decode(alg_reason,"UTF-8"));
					break;
				}
			}
		}
		else if (func_mode!= null && func_mode.equals("getChargeDetails")){
			String drug_code			= (String) hash.get("drug_code")==null?"":(String) hash.get("drug_code");
			String srl_no				= (String) hash.get("srl_no")==null?"":(String) hash.get("srl_no");
			String qty_value			= (String) hash.get("qty_value")==null?"":(String) hash.get("qty_value");
			String repeat_value			= (String) hash.get("repeat_value")==null?"1":(String) hash.get("repeat_value");
			String dosage_type			= (String) hash.get("dosage_type")==null?"":(String) hash.get("dosage_type");
			String patient_id			= (String) hash.get("patient_id")==null?"":(String) hash.get("patient_id");
			String encounter_id			= (String) hash.get("encounter_id")==null?"":(String) hash.get("encounter_id");
			String episode_type			= (String) hash.get("episode_type")==null?"":(String) hash.get("episode_type");
			String durn_value			= (String) hash.get("durn_value")==null?"1":(String) hash.get("durn_value");
			String interval_value		= (String) hash.get("interval_value")==null?"1":(String) hash.get("interval_value");
			String qty_desc_code		= (String) hash.get( "qty_desc_code" )==null?"":(String) hash.get("qty_desc_code");
			String bl_override_excl_incl_ind  = (String) hash.get("bl_override_excl_incl_ind")==null?"":(String) hash.get("bl_override_excl_incl_ind");
			String bl_overriden_action_reason = (String) hash.get("bl_overriden_action_reason")==null?"":(String) hash.get("bl_overriden_action_reason");
			String order_Date			= (String) hash.get("order_Date")==null?"":(String) hash.get("order_Date");
			String called_from			= (String) hash.get("called_from")==null?"":(String) hash.get("called_from");
			//String pat_brought_medn	= (String) hash.get("pat_brought_medn")==null?"":(String) hash.get("pat_brought_medn"); //priya 14-05-2010
			String sliding_scale_yn		= (String) hash.get("sliding_scale_yn")==null?"":(String) hash.get("sliding_scale_yn");
			String billable_item_yn	= (String) hash.get("billable_item_yn")==null?"":(String) hash.get("billable_item_yn");
			String pat_brought_medn = (String) hash.get("pat_brought_medn")==null?"":(String) hash.get("pat_brought_medn");
			String drug_desc			= "";
			String in_formulary_yn		= "";
			String bl_def_excl_incl_ind = "";
			String fract_dose_round_up_yn = "";
			String take_home_medication		= (String) hash.get("take_home_medication");
			if(!locale.equals("en"));
				order_Date				= DateUtils.convertDate(order_Date, "DMYHM",locale,"en");
			String ext_srl_no				= null;
			String ext_drug_code            = null;
			HashMap drug_detail             = null;  
			ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
			for(int j=0;j<prescriptionDetails.size();j++){
			  drug_detail					=(HashMap) prescriptionDetails.get(j);
			  ext_drug_code					=(String) drug_detail.get("DRUG_CODE");
			  ext_srl_no					=(String) drug_detail.get("SRL_NO");
				if( drug_code.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
					 drug_detail.put("REPEAT_VALUE",repeat_value);
					drug_desc			    = (String)drug_detail.get("DRUG_DESC");
					in_formulary_yn			= (String)drug_detail.get("IN_FORMULARY_YN");
					drug_detail.put("BROUGHT_BY_PAT",pat_brought_medn);  // added for IN23880 --25/10/2010-- priya
					break;
				 }
			}
			if(drug_detail != null && in_formulary_yn.equals("Y")){ //Code added for IN22611 to calculate  quantity value for split dose and fract_dose_round_up 'Y'  -Start
				fract_dose_round_up_yn = (String) drug_detail.get("FRACT_DOSE_ROUND_UP_YN")==null?"":(String) drug_detail.get("FRACT_DOSE_ROUND_UP_YN");
				ArrayList	schedule	=	(ArrayList)bean.getScheduleFrequencyStr(ext_drug_code+ext_srl_no,"0");
				ArrayList dose_list = null;
				if(schedule!=null && schedule.size() > 0) {
					 dose_list	=	(ArrayList)schedule.get(4);
					 if(dose_list !=null && dose_list.size()>0){
						 if(!dosage_type.equals("A") && !called_from.equals("TAPER_QTY"))
							qty_value		=	(String)dose_list.get(0);
					 }
				}
				boolean split_chk	=	bean.checkSplit(schedule);
				if(split_chk && dose_list !=null && dose_list.size()>0 && !called_from.equals("TAPER_QTY") && !dosage_type.equals("A")){ // && !dosage_type.equals("A") Added for TTM-SCF-0197
					qty_value = "0";
					for(int d=0; d<dose_list.size(); d++){
						if(!((String)dose_list.get(d)).equals("")){
							if(fract_dose_round_up_yn.equals("N"))
								qty_value = (Float.parseFloat(qty_value) + Float.parseFloat((String)dose_list.get(d)))+"";
							else if(fract_dose_round_up_yn.equals("Y"))
								qty_value = (Float.parseFloat(qty_value) + Math.ceil(Float.parseFloat((String)dose_list.get(d))))+"";
						}
					}
				}//Code added for IN22611  -End
				if(!called_from.equals("ASSIGN_OVERRIDE")){
                  bl_override_excl_incl_ind = (String)drug_detail.get("BL_DEF_OVERRIDE_EXCL_INCL_IND");
				}
    			//drug_detail.put("BL_OVERRIDE_EXCL_INCL_IND",bl_override_excl_incl_ind);
				if(billable_item_yn.equals("Y")){
					if(bl_override_excl_incl_ind.equals("SEL")){
						bean.setBillingDetail(drug_detail,dosage_type, qty_value, qty_desc_code, repeat_value,durn_value,interval_value, patient_id, encounter_id, episode_type, order_Date,"", bl_overriden_action_reason, called_from,take_home_medication);//,pat_brought_medn
					}
					else{
					   bean.setBillingDetail(drug_detail,dosage_type, qty_value, qty_desc_code, repeat_value,durn_value,interval_value, patient_id, encounter_id, episode_type, order_Date,bl_override_excl_incl_ind, bl_overriden_action_reason, called_from,take_home_medication);//,pat_brought_medn
					}
				}
				String gross_charge_amt		= (String)drug_detail.get("BL_GROSS_CHARGE_AMT")==null?"0.0":(String)drug_detail.get("BL_GROSS_CHARGE_AMT");//ADDED FOR ML-BRU-CRF-0469
				String bl_total_charge_amt		= (String)drug_detail.get("BL_TOTAL_CHARGE_AMT")==null?"0.0":(String)drug_detail.get("BL_TOTAL_CHARGE_AMT");
				String bl_patient_payable_amt	= (String)drug_detail.get("BL_PATIENT_PAYABLE_AMT")==null?"0.0":(String)drug_detail.get("BL_PATIENT_PAYABLE_AMT");
				String bl_approval_reqd_yn		= (String)drug_detail.get("BL_APPROVAL_REQD_YN")==null?"N":(String)drug_detail.get("BL_APPROVAL_REQD_YN");
				String bl_override_allowed_yn	= (String)drug_detail.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)drug_detail.get("BL_OVERRIDE_ALLOWED_YN");
				bl_def_excl_incl_ind		= (String)drug_detail.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"":(String)drug_detail.get("BL_DEF_OVERRIDE_EXCL_INCL_IND");
				String bl_error_code			= (String)drug_detail.get("BL_ERROR_CODE")==null?"":(String)drug_detail.get("BL_ERROR_CODE"); 
				String bl_sys_message_id		= (String)drug_detail.get("BL_SYS_MESSAGE_ID")==null?"":(String)drug_detail.get("BL_SYS_MESSAGE_ID");
				String bl_error_text			= (String)drug_detail.get("BL_ERROR_TEXT")==null?"":(String)drug_detail.get("BL_ERROR_TEXT");
				if(!(bl_error_code.equals("") && bl_sys_message_id.equals("") && bl_error_text.equals(""))){
					ArrayList blErrorDrugs = new ArrayList();
					if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
					//if (bl_error_code.equals("10") || !bl_error_text.equals("") ||!bl_sys_message_id.equals("")){
						blErrorDrugs.add(drug_code.trim());
						blErrorDrugs.add(srl_no.trim());
						drug_desc=drug_desc.replaceAll(" ","%20");
						drug_desc = java.net.URLEncoder.encode(drug_desc,"UTF-8");
						drug_desc=drug_desc.replaceAll("%2520","%20");
						blErrorDrugs.add(drug_desc);
						blErrorDrugs.add(bl_error_code);
						blErrorDrugs.add(bl_sys_message_id);
						blErrorDrugs.add(bl_error_text);
					}
					if(blErrorDrugs.size()>0){
						out.println("alertBLErrorDrugs('"+blErrorDrugs+"','BLERRORDET');");
					}
				}
				else
					out.println("assignChargeDetails('"+gross_charge_amt+"','"+bl_total_charge_amt+"','"+bl_patient_payable_amt+"','"+bl_def_excl_incl_ind+"','"+bl_approval_reqd_yn+"','"+bl_override_allowed_yn+"','"+bl_error_code+"','"+bl_sys_message_id+"','"+bl_error_text+"','"+bl_override_excl_incl_ind+"');");//ADDED FOR ML-BRU-CRF-0469

				return;
			}
			else{
				out.println("clearDrugdetails('"+sliding_scale_yn+"');");
			}
		}
		else if (func_mode!= null && func_mode.equals("getBLErrorDrugs")){
			String bl_error_code, bl_sys_message_id, bl_error_text, drug_code, drug_desc, srl_no;
			String patient_id	= (String) hash.get("patient_id")==null?"":(String) hash.get("patient_id");
			String encounter_id	= (String) hash.get("encounter_id")==null?"":(String) hash.get("encounter_id");
			String episode_type	= (String) hash.get("episode_type")==null?"":(String) hash.get("episode_type");
			String order_Date	= (String) hash.get("order_Date")==null?"":(String) hash.get("order_Date");
			if(!locale.equals("en"));
				order_Date  = DateUtils.convertDate(order_Date, "DMYHM",locale,"en");
			String qty_value,repeat_value, dosage_type	, durn_value, interval_value,qty_desc_code, bl_override_excl_incl_ind, bl_overriden_action_reason, bl_def_override_excl_incl_ind, in_formulary_yn, freq_nature;
			ArrayList blErrorDrugs				 = new ArrayList();
			HashMap drug_detail					 = null;
			ArrayList prescriptionDetails		 =(ArrayList)bean.getpresDetails();
			if(prescriptionDetails!= null){
				for(int i=0;i<prescriptionDetails.size();i++){			
					drug_detail		= (HashMap) prescriptionDetails.get(i);
					drug_code		= (String)drug_detail.get("DRUG_CODE");
					drug_desc		= (String)drug_detail.get("DRUG_DESC");
					srl_no			= (String)drug_detail.get("SRL_NO");
					qty_value		= (String)drug_detail.get("QTY_VALUE");             
					repeat_value	= (String)drug_detail.get("REPEAT_VALUE");            
					dosage_type		= (String)drug_detail.get("DOSAGE_TYPE"); 
					dosage_type		= (dosage_type!=null&&dosage_type.length()>0)?dosage_type:"";				
					freq_nature		= (String)drug_detail.get("FREQ_NATURE"); 
					freq_nature		= (freq_nature!=null&&freq_nature.length()>0)?freq_nature:"";
					if(dosage_type.equals("A") || freq_nature.equals("P")){
						qty_value	= (String)drug_detail.get("ABSOL_QTY");
						dosage_type = "A";
					}
					durn_value	= (String)drug_detail.get("DURN_VALUE");              
					interval_value	= (String)drug_detail.get("interval_value");              
					qty_desc_code	= (String)drug_detail.get("QTY_DESC_CODE");          
					in_formulary_yn	= (String)drug_detail.get("IN_FORMULARY_YN");          
					bl_override_excl_incl_ind		= (String)drug_detail.get("BL_OVERRIDE_EXCL_INCL_IND")==null?"":(String)drug_detail.get("BL_OVERRIDE_EXCL_INCL_IND"); 
					bl_def_override_excl_incl_ind   = (String)drug_detail.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"":(String)drug_detail.get("BL_DEF_OVERRIDE_EXCL_INCL_IND");
					if(bl_override_excl_incl_ind.equals(bl_def_override_excl_incl_ind)){
						bl_override_excl_incl_ind	=	"";
					}
					if(in_formulary_yn.equals("Y")){
						//bean.setBillingDetail(drug_detail,dosage_type, qty_value, qty_desc_code, repeat_value,durn_value,interval_value, patient_id, encounter_id, episode_type, order_Date,bl_override_excl_incl_ind, bl_overriden_action_reason);
						bl_error_code		= (String)drug_detail.get("BL_ERROR_CODE")==null?"":(String)drug_detail.get("BL_ERROR_CODE");     
						bl_sys_message_id	= (String)drug_detail.get("BL_SYS_MESSAGE_ID")==null?"":(String)drug_detail.get("BL_SYS_MESSAGE_ID"); 
						bl_error_text		= (String)drug_detail.get("BL_ERROR_TEXT")==null?"":(String)drug_detail.get("BL_ERROR_TEXT");   
						in_formulary_yn		= (String)drug_detail.get("IN_FORMULARY_YN");
						if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
							blErrorDrugs.add(drug_code.trim());
							blErrorDrugs.add(srl_no.trim());
							drug_desc=drug_desc.replaceAll(" ","%20");
							drug_desc = java.net.URLEncoder.encode(drug_desc,"UTF-8");
							drug_desc=drug_desc.replaceAll("%2520","%20");
							blErrorDrugs.add(drug_desc);
							blErrorDrugs.add(bl_error_code);
							blErrorDrugs.add(bl_sys_message_id);
							blErrorDrugs.add(bl_error_text);
						}
					}
				}
			}
			if(blErrorDrugs.size()>0){
				out.println("alertBLErrorDrugs('"+blErrorDrugs+"','BLERROR');");
			}
		}
		//added for IN070786 start
		else if(func_mode!= null && func_mode.equals("UPDATE_EXTERNAL_STATUS")){
			String patient_id	= (String) hash.get("patient_id")==null?"":(String) hash.get("patient_id");
			String encounter_id	= (String) hash.get("encounter_id")==null?"":(String) hash.get("encounter_id");
			String no_extrnal_drug	= (String) hash.get("no_extrnal_drug")==null?"":(String) hash.get("no_extrnal_drug");
			String chk_status	= (String) hash.get("chk_status")==null?"":(String) hash.get("chk_status");
			
				bean.updateExternalDrugStatues(patient_id,encounter_id,chk_status,no_extrnal_drug);
		}
		

		else if(func_mode!= null && func_mode.equals("UPDATE_EXTERNAL_DETAILS_STATUS")){
			String patient_id	= (String) hash.get("patient_id")==null?"":(String) hash.get("patient_id");
			String encounter_id	= (String) hash.get("encounter_id")==null?"":(String) hash.get("encounter_id");
			String no_extrnal_drug	= (String) hash.get("no_extrnal_drug")==null?"":(String) hash.get("no_extrnal_drug");
			String recn_yn	= (String) hash.get("recn_yn")==null?"":(String) hash.get("recn_yn");
			
				bean.updateExternalDrugStatuesFromRecn(patient_id,encounter_id,recn_yn,no_extrnal_drug);
		}			
		//added for IN070786 end  
		//added for NMC-JD-CRF-0063 START
		else if(func_mode!= null && func_mode.equals("checkOpDischargeMed")){ 
			String dischMedcheck	= (String) hash.get("dischMedcheck")==null?"":(String) hash.get("dischMedcheck");
			System.out.println("dischMedcheck: "+dischMedcheck);
			if(dischMedcheck.equals("Y")){
				bean.setOpDischMedInd("Y");
				bean.setOpHomeMedicationVal("Y");//added for NMC-JD-CRF-0063 [11525]
			}
			else{
				bean.setOpDischMedInd("N");
				bean.setOpHomeMedicationVal("N");//added for NMC-JD-CRF-0063 [11525]
			}
			System.out.println("Dis med Ind: "+bean.getOpDischMedInd());
			System.out.println("OpHomeMedicationVal: "+bean.getOpHomeMedicationVal()); //added for NMC-JD-CRF-0063  
	}//END
		
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(presBean_id,presBean,request);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
%>

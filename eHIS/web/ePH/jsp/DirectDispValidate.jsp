<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
29/08/2019      IN:070451           B Haribabu  29/08/2019      Manickam                 ML-MMOH-CRF-1408
10/12/2019      IN070606           Manickavasagam                         		 MMS-KH-CRF-0029
18/02/2020		IN071362                Manickavasagam J                       AAKH-CRF-0117
06/07/2020      IN:072715          Haribabu     06/07/2020     Manickavasagam     MMS-DM-CRF-0165
28/07/2020      IN:073485                   Haribabu                                PH-MMS-DM-CRF-0165/01-Normal rx-Amend order
20/10/2020      IN:069886         Haribabu                       Manickam            MO-CRF-20151
12/11/2020     IN:069887       Haribabu         13/11/2020     Manickavasagam     MO-CRF-20152
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/  %> 
<%@page  import="java.sql.*, java.util.*,java.text.DecimalFormat, java.io.*, ePH.Common.*, ePH.*,eST.*,eST.Common.*,eOR.*,java.text.DecimalFormat,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");
%>
<%!
	private String getOrderQty(HashMap ext_drugData,String qty_value,String dup_repeat,String durn,String dosage,String conv_factor){

		String fract_dose						=	(String)ext_drugData.get("FRACT_DOSE_ROUND_UP_YN")==null?"":(String)ext_drugData.get("FRACT_DOSE_ROUND_UP_YN");
		String dosage_type						=	(String)ext_drugData.get("DOSAGE_TYPE")==null?"":(String)ext_drugData.get("DOSAGE_TYPE");
			   dosage_type						=	 dosage;
		String durn_value						=	(String)ext_drugData.get("DURN_VALUE")==null?"":(String)ext_drugData.get("DURN_VALUE");
			   durn_value						=	 durn;
		String repeat_value						=	(String)ext_drugData.get("REPEAT_VALUE")==null?"":(String)ext_drugData.get("REPEAT_VALUE");

	   repeat_value						=	 dup_repeat;
	   if(repeat_value==null || repeat_value.equals("null"))
			repeat_value="1";
		String content_in_pres_base_uom			=	(String)ext_drugData.get("CONTENT_IN_PRES_BASE_UOM")==null?"":(String)ext_drugData.get("CONTENT_IN_PRES_BASE_UOM");
		String strength_per_value_per_pres_uom	=   (String)ext_drugData.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"":(String)ext_drugData.get("STRENGTH_PER_VALUE_PRES_UOM");
		String strength_per_pres_uom			=   (String)ext_drugData.get("STRENGTH_PER_PRES_UOM")==null?"":(String)ext_drugData.get("STRENGTH_PER_PRES_UOM");
		String interval_value					=   (String)ext_drugData.get("INTERVAL_VALUE")==null?"":(String)ext_drugData.get("INTERVAL_VALUE");
		if(interval_value==null || interval_value.equals("null"))
			interval_value="1";
				
		String freq_nature						=   (String)ext_drugData.get("FREQ_NATURE")==null?"":(String)ext_drugData.get("FREQ_NATURE");
		String ord_qty							=	"";
		String tmp_qty							=	"";

		try {
			if(dosage_type!=null && dosage_type.equals("A")){
				ord_qty	=	qty_value;
			} 
			else if(dosage_type!=null && dosage_type.equals("Q")){
				if(fract_dose != null && !fract_dose.equals("Y")){
					ord_qty		=  (Float.parseFloat(qty_value)*Float.parseFloat(durn_value)*Float.parseFloat(repeat_value)* Float.parseFloat(conv_factor))+"";
					ord_qty		=	Math.ceil(Float.parseFloat(ord_qty)/(Float.parseFloat(content_in_pres_base_uom)))+"";
					if(ord_qty.equals("0")){
						ord_qty	=	"1";
					}
				} 
				else {
					if( (Float.parseFloat(qty_value)*Float.parseFloat(conv_factor)) < Float.parseFloat(content_in_pres_base_uom)){
						tmp_qty	=	1+"";
					} 
					else{
						tmp_qty	=  Math.ceil((Float.parseFloat(qty_value)*Float.parseFloat(conv_factor))/Float.parseFloat(content_in_pres_base_uom))+"";
					}
					ord_qty	=  (Float.parseFloat(tmp_qty) *Float.parseFloat(durn_value)*Float.parseFloat(repeat_value))+"";
				}

				ord_qty	=	String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
				
				if(freq_nature != null && freq_nature.equals("F")){
					ord_qty	=	String.valueOf(Math.ceil(Float.parseFloat(ord_qty) / Integer.parseInt(interval_value)));
				}
			} 
			else if(dosage_type!=null && dosage_type.equals("S")){
				if(fract_dose != null && !fract_dose.equals("Y")){	
					//Calculating final order quantity-Multiply by strength_per_pres_value 
					ord_qty		=((Float.parseFloat(qty_value)*Float.parseFloat(durn_value)*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))/(Float.parseFloat(strength_per_pres_uom)))+"";
					ord_qty		=	String.valueOf(Math.ceil(new Double(Float.parseFloat(ord_qty)/Float.parseFloat(content_in_pres_base_uom)).doubleValue()));
				}
				else{
					double unit_qty	= Math.ceil(Double.parseDouble(qty_value)/Double.parseDouble(strength_per_pres_uom)) * (Double.parseDouble(strength_per_value_per_pres_uom));			
					tmp_qty			=  (Math.ceil(unit_qty /Float.parseFloat(content_in_pres_base_uom))+"");
					ord_qty			=  (Float.parseFloat(tmp_qty) * Float.parseFloat(durn_value)*Float.parseFloat(repeat_value))+"";					
				}				
				ord_qty=String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
				if(freq_nature != null && freq_nature.equals("F")){
					ord_qty	=	String.valueOf(Math.ceil(Float.parseFloat(ord_qty) / Integer.parseInt(interval_value)));
				}
			}
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		return ord_qty;
	}
%>
<%
	try {
		
		String	func_mode       	=request.getParameter("func_mode")==null?"":request.getParameter("func_mode");
		String	identity			=request.getParameter("identity")==null?"":request.getParameter("identity");
		String bean_id			    = "";
		String bean_name			= "";
		Hashtable hash1				=null;
		Hashtable hash			=null;
		if(identity.equals("SetItemDetails")||identity.equals("SetBatchDetails")||identity.equals("StoreConcumableBillingDetails")||identity.equals("SetSelectedRecord") ||identity.equals("clearBatchDetails")) {
			hash1				    = (Hashtable)xmlObj.parseXMLString( request ) ;
			hash1					= (Hashtable)hash1.get( "SEARCH" ) ;
		 }
		if(!func_mode.equals("editlabel")&&func_mode.length()!=0){
			hash				    = (Hashtable)xmlObj.parseXMLString( request ) ;
			hash					= (Hashtable)hash.get( "SEARCH" ) ;
		   bean_id					= (String) hash.get( "bean_id" );	
		   bean_name				= (String) hash.get( "bean_name" );
		 }
	 String patient_class		= "";
	 String practioner_id		= "";
	 String encounter_id		= "";
	 String practioner_name		= "";
	 String ord_locn_name		= "";	
	 String patient_id          = "";
	
	 if(!func_mode.equals("editlabel")&&func_mode.length()!=0){
		if (bean_id == null || bean_id.equals(""))
			return ;
	 }
	 else{
		  bean_id			= request.getParameter( "bean_id" );	
	      bean_name		    = request.getParameter( "bean_name" );
	 }

	DirectDispensingBean bean = (DirectDispensingBean)getBeanObject(bean_id,bean_name,request);
	//bean.setLanguageId(locale);
	if (func_mode.equals("saveEncounterIDDetails")) {
		
	     encounter_id		= (String) hash.get( "encounter_id" );
	     practioner_name	= java.net.URLDecoder.decode(((String) hash.get( "practioner_name" )),"UTF-8");
	     ord_locn_name		= java.net.URLDecoder.decode(((String) hash.get( "ord_locn_name" )),"UTF-8");

         bean.setPatientClass((String)hash.get("patient_class"));
		 bean.setPractionerID((String)hash.get("practioner_id"));
		 bean.setOrdLocn((String)hash.get("ord_locn"));
		 bean.setEncounterID(encounter_id);
		 bean.setPractionerName(practioner_name);
		 bean.setOrdLocnName(ord_locn_name);		
	}
	else if(func_mode.equals("validateBSA")){
		String dir_bean_id      = "DirectDispensingBean" ;
		String dir_bean_name    = "ePH.DirectDispensingBean";
		DirectDispensingBean dir_bean = (DirectDispensingBean)getBeanObject( dir_bean_id,dir_bean_name,request) ;
		dir_bean.setLanguageId(locale);
		String height			=(String) hash.get("height");
		String weight			=(String) hash.get("weight");
		encounter_id		= dir_bean.getEncounterID();
		if(encounter_id==null)
			encounter_id="";
		patient_id		= dir_bean.getPatientID();

		String presBean_id		= "@PrescriptionBean"+patient_id+encounter_id;
		String presBean_name		= "ePH.PrescriptionBean";
		PrescriptionBean presBean	= (PrescriptionBean)getBeanObject(presBean_id,presBean_name,request);
		
		float bsa= (float) presBean.loadBSA(height,weight);
		float bmi =0;
		if(!height.equals("0.00")&& !weight.equals("0.00")){
			bmi=Float.parseFloat(weight)/((Float.parseFloat(height)/100)*(Float.parseFloat(height)/100));
		}
		boolean site=dir_bean.isSiteSpecific("OR", "OR_ORDER_SET"); // added for ML-MMOH-CRF-1004 -Start
		 String bsaTwoDcml = "";
		if(site){ // if condition added for ML-MMOH-CRF-1004 -Start
			bsaTwoDcml = String.format("%.2f", bsa);
			out.println("assignBSA(\"" + bsaTwoDcml + "\",\""+bmi+"\");") ;
		} // if condition added for ML-MMOH-CRF-1004 - end
		else{
		out.println("assignBSA(\"" + bsa + "\",\""+bmi+"\");") ;
		}
		putObjectInBean(dir_bean_id,dir_bean,request);
		putObjectInBean(presBean_id,presBean,request);
	}
	else if(func_mode != null && func_mode.equals("CALLPATIENT")){
		patient_id					= (String) hash.get("patient_id");
		encounter_id					= (String) hash.get("encounter_id");
		String called				= (String) hash.get("called");
		String disp_locn_code		= (String) hash.get("disp_locn_code");
		bean.setDispLocnCode(disp_locn_code);
	    ArrayList patientdetails	= bean.getPatientDetails1(patient_id);
		bean.getDispMednDefltValues();
		if(patientdetails.size()==0){
			out.println("chkpatID('Y');") ;
		}
		else{
			if(called.equals("patientid")){
				out.println("chkpatID('N');") ;
			}
			else{
				bean.setPatientID(patient_id);
				boolean allergy_conf_reqd_yn=false;//added for RUT-CRF-0064.1 [IN:041799] -Start
				if(encounter_id!=null && !encounter_id.equals(""))
					allergy_conf_reqd_yn = bean.getAllergyConfDtls(patient_id, encounter_id); 
				out.println("calldrugframes('"+allergy_conf_reqd_yn+"');") ;//added for RUT-CRF-0064.1 [IN:041799] -End
			}
		}
	}
	else if(func_mode != null && func_mode.equals("reset")){
		bean.clear();
		out.println("reset1();") ;
	}
	else if(func_mode != null && func_mode.equals("reset1")){
		bean.clear();
		out.println("reset2();") ;
	}
	else if(func_mode!= null && func_mode.equals("chkDuplicateDrugCode")){		
		patient_id			= bean.getPatientID();	
		encounter_id		    = bean.getEncounterID();
		patient_class		= bean.getPatientClass();
		String drug_code			= (String) hash.get( "drug_code" );
		String facility_id			= (String) hash.get( "facility_id" );	
		String sys_date				= (String) hash.get( "sys_date" );
		String drugCodes			= (String) hash.get( "drugCodes" );
		String priority				= (String) hash.get( "priority" );
		String take_home_medication = (String) hash.get( "take_home_medication" );
		String locn_type			= "C";		
		String locn_code			= (String) hash.get( "locn_code" );
		String drug_db_interface_yn = (String)hash.get("drug_db_interface_yn");
		String Drug_db_prod_id		= (String)hash.get("Drug_db_prod_id");
		String atc_allergy_alert_level		= (String)hash.get("atc_allergy_alert_level")==null?"N":(String)hash.get("atc_allergy_alert_level");

		//String trade_codes			= (String) hash.get( "trade_codes" );
		//String trade_names			= (String) hash.get( "trade_names" );
		String trade_codes	= (String) hash.get( "trade_codes" )==null?"":(String) hash.get( "trade_codes" );
		String trade_names	= (String) hash.get( "trade_names" )==null?"":(String) hash.get( "trade_names" );
		String tradeCodesArr[] = trade_codes.split(",");
		String tradeNamesArr[] = trade_names.split(",");

		String trade_code			="";
		String trade_name			="";	
		int trade_count=0;

		boolean allow_add	= true;
			   HashMap chk	= null;
			if(allow_add){
					drugCodes	= drugCodes.replace('[',' ');
					drugCodes	= drugCodes.replace(']',' ');
					StringTokenizer stDrugCodes = new StringTokenizer(drugCodes.trim(),",");

				//	trade_codes	= trade_codes.replace('[',' ');
				//	trade_codes	= trade_codes.replace(']',' ');
				//	StringTokenizer sttrade_codes = new StringTokenizer(trade_codes.trim(),",");


				//	trade_names	= trade_names.replace('[',' ');
				//	trade_names	= trade_names.replace(']',' ');
				//	StringTokenizer sttrade_names = new StringTokenizer(trade_names.trim(),",");

					
					while(stDrugCodes.hasMoreTokens()){
						int srl_no	=bean.getSrlNo()+1;
						drug_code	=stDrugCodes.nextToken();
					//	if(sttrade_codes.hasMoreTokens())
						//    trade_code	=sttrade_codes.nextToken();
					//	if(sttrade_names.hasMoreTokens())
						//    trade_name	=sttrade_names.nextToken();
						if(trade_count < tradeCodesArr.length){
						trade_code=tradeCodesArr[trade_count];
						trade_name = tradeNamesArr[trade_count++];
					}
					else{
						trade_code = "";
						trade_name = "";
					}
					chk	=(HashMap)bean.loadDrugDetails(priority,take_home_medication,locn_type,locn_code,facility_id,drug_code.trim(),patient_class,patient_id,sys_date.trim(),String.valueOf(srl_no),drug_db_interface_yn,Drug_db_prod_id,trade_code,trade_name, atc_allergy_alert_level);

					bean.addDrugDetails(999,chk);
					bean.setSrlNo(srl_no);
					if(!drug_db_interface_yn.equals("Y") || chk.get("EXTERNAL_PRODUCT_ID")==null || ((String)chk.get("EXTERNAL_PRODUCT_ID")).equals("")){//MMS-KH-CRF-0029
					
					out.println("loadDrugInteractionForDrug('"+drug_code+"','"+patient_id+"','"+String.valueOf(srl_no)+"');");
					}
					//ArrayList	presDetails	=(ArrayList) bean.getpresDetails();					
				}
				out.println("loadDetailForm();");
			}
			else{
				trade_code			="";
				out.println("invalidDrug();");
			}

		//objects nullified after usage
		chk	=	null;

	}
	else if(func_mode != null && func_mode.equals("makeScheduleLink")){
		String drug_code	= (String) hash.get( "drug_code" );
		String admin_time	= "";
		String admin_qty    = "";
		float total_qty		= 0.0f;
		String final_qty	= "";
		String ad_qty       ="";
		ArrayList dose_list	=	null;

		HashMap chkValuescheduleFrequency=bean.getscheduleFrequency();
			
		ArrayList frequencyValues = new ArrayList();
		
		if(chkValuescheduleFrequency.size()>0)
		{
			frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code);			
		}
		//HashMap data	=	null;
		if(frequencyValues !=null && frequencyValues.size()>0)
		{
			/*
			admin_time =admin_time+"<tr>";
				
			for(int i=0;i<frequencyValues.size();i++)
			{
					data=new HashMap();
					data=(HashMap)frequencyValues.get(i);
					String att="align=center class=TIP";
					admin_time= admin_time +"<td "+att+">&nbsp;"+data.get("admin_time")+"&nbsp;</td>";
			}
			
			admin_time= admin_time +"</tr>";
			admin_time= admin_time +"<tr>";
			
			for(int i=0;i<frequencyValues.size();i++)
			{
					data	=	new HashMap();
					String att="align=center class=TIP";
					data=(HashMap)frequencyValues.get(i);
					admin_qty=admin_qty +"<td "+att+">&nbsp;"+data.get("admin_qty")+"&nbsp;</td>";
					total_qty = total_qty + Float.parseFloat((String) data.get("admin_qty"));

					final_qty	=	(String) data.get("admin_qty");
			}
			
			admin_qty =admin_qty +"</tr>";*/
			dose_list	= (ArrayList)frequencyValues.get(4);
			for(int tqI=0;tqI<dose_list.size();tqI++){										
				final_qty	=	(String)dose_list.get(tqI);
				if(!(final_qty.equals("")||final_qty.equals("0")||final_qty==null))
					total_qty	=	total_qty+Float.parseFloat((String)dose_list.get(tqI));
				else
					total_qty +=1.0f;
			}
			
			boolean split_chk	=	bean.checkSplit(frequencyValues);	

			if(split_chk) 
			{
				final_qty		=	String.valueOf(total_qty);
			} else{
				ad_qty          =final_qty;
			}

			String tooltiptable = (String)bean.getTooltipStringFrFreq(frequencyValues,"toolTip");
			admin_time = tooltiptable;	

			out.println("makeScheduleLink('"+admin_time+"','"+admin_qty+"','"+final_qty+"','"+frequencyValues.size()+"','"+split_chk+"','"+ad_qty+"')");
		}
		else
		{
			out.println("hideScheduleLink()");
		}
		
		//variables nullified after usage	
		//data	=	null;
		dose_list	=	null;
		chkValuescheduleFrequency	=	null;
		frequencyValues	=	null;

	}
	else if(func_mode!= null && func_mode.equals("populateQtyDesc")){
		//String drug_codetmp		= (String) hash.get( "drug_code" );
		String form_code		= (String) hash.get("form_code");
		String pres_base_uom		= (String) hash.get("pres_base_uom")==null?"":(String) hash.get("pres_base_uom");
		String pres_base_uom_desc	= (String) hash.get("pres_base_uom_desc")==null?"":(String) hash.get("pres_base_uom_desc");
		String rx_qty_by_pres_base_uom_yn		= (String) hash.get("rx_qty_by_pres_base_uom_yn")==null?"N":(String) hash.get("rx_qty_by_pres_base_uom_yn");

		ArrayList QtyDescDetails		= (ArrayList)bean.loadQtyDetails(form_code);
		String	uom_code	= "";
		String	uom_desc	= "";
		String  dflt_yn		= "";
		String  dflt_uom_code		= "";
		boolean deft_set = false;
		out.println("clearQtyDescList()");
		if(!rx_qty_by_pres_base_uom_yn.equals("Y")){
			for(int i=0; i<QtyDescDetails.size(); i+=3){
				uom_code	= (String)QtyDescDetails.get(i);
				uom_desc	= (String)QtyDescDetails.get(i+1);
				dflt_yn		= (String)QtyDescDetails.get(i+2);
				if(dflt_uom_code.equals("") && dflt_yn.equals("Y"))
					dflt_uom_code = uom_code;
				out.println("addQtyDescList(\""+uom_code+"\",\""+uom_desc+"\")");
				if((!pres_base_uom.equals("")) && pres_base_uom.equals(uom_code)){
					out.println("setdfltQtyUom('"+pres_base_uom+"')");
					deft_set = true;
				}
			}
			if(!deft_set){
				out.println("setdfltQtyUom(\""+dflt_uom_code+"\")");
			}
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
		// objects nullified after usage
		QtyDescDetails	=	null;

	}
	else if(func_mode!= null && func_mode.equals("override_reason")) {

		String drugCode		= (String)hash.get("drug_code");
		String srlNo		= (String)hash.get("srl_no");
		String allergy_yn	= hash.get("allergy_yn")==null?"":(String)hash.get("allergy_yn");
		String limit_ind	= hash.get("limit_ind")==null?"":(String)hash.get("limit_ind");
		String current_rx	= hash.get("current_rx")==null?"":(String)hash.get("current_rx");
		String interaction_exists	= hash.get("interaction_exists")==null?"":(String)hash.get("interaction_exists"); // added for FD-RUT-CRF-0066.1 [IN036975]
		String food_interaction_remarks = "",lab_interaction_remarks="";//MMS-KH-CRF-0029[IN070606]
		String allergy		=	"";
		String exceed_dose	=	"";
		String dup_drug		=	"";
		String interaction_remarks		=	"";
		String dose_remarks_code = "", allergy_remarks_code = "", dup_drug_remarks_code = "", interaction_remarks_code = "", lab_interaction_remarks_code = "", food_interaction_remarks_code = "",disease_interaction_remarks_code="",disease_interaction_remarks="";	//Added for IN:072715//disease_interaction_remarks_code Added for MMS-DM-CRF-0229
//System.err.println("interaction_exists=="+interaction_exists);
		if(allergy_yn.equals("Y")){
			allergy		= (String)hash.get("allergy");
			allergy	= java.net.URLDecoder.decode(allergy,"UTF-8");
			allergy_remarks_code				= java.net.URLDecoder.decode((String)hash.get("allergy_remarks_code")==null?"":(String)hash.get("allergy_remarks_code"),"UTF-8");//Added for IN:072715
		}

		if(limit_ind.equals("N")){
			exceed_dose			= (String)hash.get("exceed_dose");
			exceed_dose	= java.net.URLDecoder.decode(exceed_dose,"UTF-8");
			dose_remarks_code			= java.net.URLDecoder.decode((String)hash.get("dose_remarks_code")==null?"":(String)hash.get("dose_remarks_code"),"UTF-8");//Added for IN:072715
		}

		if(current_rx.equals("Y")){
			dup_drug			= (String)hash.get("dup_drug");
			dup_drug	= java.net.URLDecoder.decode(dup_drug,"UTF-8");
			dup_drug_remarks_code			= java.net.URLDecoder.decode((String)hash.get("dup_drug_remarks_code")==null?"":(String)hash.get("dup_drug_remarks_code"),"UTF-8");//Added for IN:072715
		}
		if(interaction_exists.equals("Y")){ // added for FD-RUT-CRF-0066.1 [IN036975]
			interaction_remarks			= (String)hash.get("interaction_remarks")==null?"":(String)hash.get("interaction_remarks");
			interaction_remarks	= java.net.URLDecoder.decode(interaction_remarks,"UTF-8");
			food_interaction_remarks			= java.net.URLDecoder.decode((String)hash.get("food_interaction_remarks")==null?"":(String)hash.get("food_interaction_remarks"),"UTF-8"); //MMS-KH-CRF-0029[IN070606]
			lab_interaction_remarks			= java.net.URLDecoder.decode((String)hash.get("lab_interaction_remarks")==null?"":(String)hash.get("lab_interaction_remarks"),"UTF-8"); //MMS-KH-CRF-0029[IN070606]
			//Added for IN:072715 start
			interaction_remarks_code			= java.net.URLDecoder.decode((String)hash.get("interaction_remarks_code")==null?"":(String)hash.get("interaction_remarks_code"),"UTF-8");
			food_interaction_remarks_code			= java.net.URLDecoder.decode((String)hash.get("food_interaction_remarks_code")==null?"":(String)hash.get("food_interaction_remarks_code"),"UTF-8"); 
			lab_interaction_remarks_code			= java.net.URLDecoder.decode((String)hash.get("lab_interaction_remarks_code")==null?"":(String)hash.get("lab_interaction_remarks_code"),"UTF-8"); 	
			//Added for IN:072715 end
			disease_interaction_remarks_code			= java.net.URLDecoder.decode((String)hash.get("disease_interaction_remarks_code")==null?"":(String)hash.get("disease_interaction_remarks_code"),"UTF-8"); 
			disease_interaction_remarks			= java.net.URLDecoder.decode((String)hash.get("disease_interaction_remarks")==null?"":(String)hash.get("disease_interaction_remarks"),"UTF-8");
		}

		//HashMap  modifydrugData			=	new HashMap();
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
					ext_drugData.put("ALLERGY_REMARKS_CODE",allergy_remarks_code);//Added for IN:072715
				}
				if(!exceed_dose.equals("")) {
					ext_drugData.put("DOSE_REMARKS",exceed_dose);
					ext_drugData.put("DOSE_OVERRIDE","Y");
					ext_drugData.put("DOSE_REMARKS_CODE",dose_remarks_code);//Added for IN:072715
				}
				if(!dup_drug.equals("")) {
					ext_drugData.put("CURRENTRX_REMARKS",dup_drug);
					ext_drugData.put("CURRENTRX_OVERRIDE","Y");
					ext_drugData.put("CURRENTRX_REMARKS_CODE",dup_drug_remarks_code);//Added for IN:072715
				}
				if( !interaction_remarks.equals("") || !food_interaction_remarks.equals("") || !lab_interaction_remarks.equals("") || !disease_interaction_remarks.equals("")){		 // added for FD-RUT-CRF-0066.1 [IN036975]		//disease_interaction_remarks Added for MMS-DM-CRF-0229								
					ext_drugData.put("DRUGINTRACTION_OVERRIDE","Y");
					if(!interaction_remarks.equals("")){
						ext_drugData.put("INTERACTION_REMARKS",interaction_remarks);
						ext_drugData.put("INTERACTION_REMARKS_CODE",interaction_remarks_code);	//Added for IN:072715
					}
					if(!food_interaction_remarks.equals("")){
						ext_drugData.put("FOOD_INTERACTION_REMARKS",food_interaction_remarks);//MMS-KH-CRF-0029[IN070606]
						ext_drugData.put("FOOD_INTERACTION_REMARKS_CODE",food_interaction_remarks_code);//Added for IN:072715	
					}
					if(!lab_interaction_remarks.equals("")){
						ext_drugData.put("LAB_INTERACTION_REMARKS",lab_interaction_remarks);//MMS-KH-CRF-0029[IN070606]
						ext_drugData.put("LAB_INTERACTION_REMARKS_CODE",lab_interaction_remarks_code);	//Added for IN:072715
					}
				//	System.err.println("disease_interaction_remarks@@==="+disease_interaction_remarks+"disease_interaction_remarks_code=="+disease_interaction_remarks_code);
					if(!disease_interaction_remarks.equals("")){//Added for MMS-DM-CRF-0229
							ext_drugData.put("DISEASE_INTERACTION_REMARKS",disease_interaction_remarks);
							ext_drugData.put("DISEASE_INTERACTION_REMARKS_CODE",disease_interaction_remarks_code);		
						}
						
				}
				break;
			}
		}
		// objects nullified after usage
		//modifydrugData		=	null;
		prescriptionDetails	=	null;
		ext_drugData		=	null;
   }
   else if(func_mode != null && func_mode.equals("InsertExternalOverrideReason")){
		HashMap drugDetails							=	null;
		String extdrugCode								=	"";
		String extsrlNo								=	"";
		String drug_code								= (String) hash.get( "drug_code" );
		String srl_no									= (String) hash.get( "srl_no" );
		String called_from								= (String) hash.get( "called_from" );	
		String External_Dosage_Override_Reason			= (String)hash.get("External_Dosage_Override_Reason");
		String External_Duplicate_Override_Reason		= (String)hash.get("External_Duplicate_Override_Reason");
		String External_Interaction_Override_Reason	= (String)hash.get("External_Interaction_Override_Reason");
		String External_Contra_Override_Reason			= (String)hash.get("External_Contra_Override_Reason");
		String External_Alergy_Override_Reason			= (String)hash.get("External_Alergy_Override_Reason");

		if(!External_Dosage_Override_Reason.equals("")&& External_Dosage_Override_Reason!=null){
			External_Dosage_Override_Reason	=	java.net.URLDecoder.decode(External_Dosage_Override_Reason);
		}
		if(!External_Duplicate_Override_Reason.equals("")&&External_Duplicate_Override_Reason!=null){
			External_Duplicate_Override_Reason	=	java.net.URLDecoder.decode(External_Duplicate_Override_Reason);
		}
		if(!External_Interaction_Override_Reason.equals("")&&External_Interaction_Override_Reason!=null){
			External_Interaction_Override_Reason	=	java.net.URLDecoder.decode(External_Interaction_Override_Reason);
		}
		if(!External_Contra_Override_Reason.equals("")&&External_Contra_Override_Reason!=null){
			External_Contra_Override_Reason	=	java.net.URLDecoder.decode(External_Contra_Override_Reason);
		}
		if(!External_Alergy_Override_Reason.equals("")&&External_Alergy_Override_Reason!=null){
			External_Alergy_Override_Reason	=	java.net.URLDecoder.decode(External_Alergy_Override_Reason);
		}

		ArrayList presDetails			= (ArrayList) bean.getpresDetails();
		if(presDetails!=null && presDetails.size()>0){

			for(int i=0;i<presDetails.size();i++){
				drugDetails				= (HashMap)presDetails.get(i);
				extdrugCode				= (String)drugDetails.get("DRUG_CODE");
				extsrlNo				= (String)drugDetails.get("SRL_NO");
				if(extdrugCode.equals(drug_code) && extsrlNo.equals(srl_no) ){
					
					drugDetails.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",External_Dosage_Override_Reason);
					if(called_from.equals("PRESPAD")||called_from.equals("ONLOAD")){
						drugDetails.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON",External_Duplicate_Override_Reason);
						drugDetails.put("EXTERNAL_INTERACTION_OVERRIDE_REASON",External_Interaction_Override_Reason);
						drugDetails.put("EXTERNAL_CONTRA_OVERRIDE_REASON",External_Contra_Override_Reason);
						drugDetails.put("EXTERNAL_ALERGY_OVERRIDE_REASON",External_Alergy_Override_Reason);
					}
				}
			}
		}
   }
   else if(func_mode != null && func_mode.equals("populateEndDate")){
		String freq_nature			= (String) hash.get( "freq_nature" );
		String start_date			= (String) hash.get( "start_date" );
		String durn_value			= (String) hash.get( "durn_value" );
		String repeat_durn_type		= (String) hash.get( "repeat_durn_type" );
		String end_date=(String)bean.populateEndDate(freq_nature,start_date,durn_value,repeat_durn_type);
		out.println("assignEndDate(\""+end_date+"\")");
	}
	else if(func_mode != null && func_mode.equals("getFormatId")){
		patient_id			=	(String) hash.get( "patient_id" );
		encounter_id			=	(String) hash.get( "encounter_id" );
		String order_catalog_code	=	(String) hash.get( "drug_code" );
		String order_type			=	(String) hash.get( "order_type" );
		String form_code			=	(String) hash.get( "form_code" );
		String route_code			=	(String) hash.get( "route_code" );
		String called_frm			=	(String) hash.get( "called_frm" );

		String or_bean_name	="eOR.OrderEntryBean";
		String or_bean_id	="@orderentrybean"+patient_id+encounter_id;

		OrderEntryBean orbean = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request) ;
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean 	= (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
		String order_category		=	"PH";

		if(called_frm != null && called_frm.equals("route")){
			out.println(orderEntryRecordBean.getOrderFormats(order_catalog_code,order_catalog_code+"_0"));

			if(orderEntryRecordBean.getOrderFormats(order_catalog_code, order_catalog_code+"_0")!=null){
				orderEntryRecordBean.removeOrderFormats(order_catalog_code, order_catalog_code+"_0");
			}
		}
		order_catalog_code=  order_catalog_code.substring(0,(order_catalog_code.length())-1); // moved before bean.getFormatId call for SKR-SCF-0140
		String format_id		=	bean.getFormatId(order_category,order_type,order_catalog_code);

		ArrayList	pres_values	=	bean.getPresValues(form_code,route_code,order_catalog_code);
		
		for(int i=0; i<pres_values.size(); i++){
			out.println("prescriptionValues(\""+(String)pres_values.get(i)+"\")");
		}

		out.println("validateRemarks('"+format_id+"')");

		//variables nullified after usage
		putObjectInBean(or_bean_id,orbean,request);
			pres_values		=	null;
			orbean			=	null;
	}
	else if(func_mode != null && func_mode.equals("disableScheduleLink1")){
	
		String drug_code	= (String) hash.get( "drug_code" );
		bean.getclearscheduleFrequency(drug_code);
		ArrayList	schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code,"0");
		out.println("deleteScheduleLink()");
	}
	else if(func_mode!= null && func_mode.equals("changeoverridevalue")){

		String drugCode					= (String)hash.get("drug_code");
		String srl_no					= (String)hash.get("srl_no");
		ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
		String ext_srl_no				= null;
		String ext_drug_code            = null;
		HashMap ext_drugData            = null;  
		String  limit_ind               = null;
		for(int j=0;j<prescriptionDetails.size();j++){
			ext_drugData				=(HashMap) prescriptionDetails.get(j);
			ext_drug_code				=(String) ext_drugData.get("DRUG_CODE");
			ext_srl_no				=(String) ext_drugData.get("SRL_NO");
			if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
				limit_ind=(String) hash.get("limit_ind");
				ext_drugData.put("LIMIT_IND",limit_ind);
			 }
		}
		out.println("disableoverride(\""+limit_ind+"\")");
	}
	else if(func_mode != null && func_mode.equals("populateDurationDesc")){
		String freq_code			= (String) hash.get( "freq_code" );
		String durn_desc			= "";
		String repeat_durn_type		= "";
		String freq_value			= "";
		String freq_nature			= "";
		String interval_value		= "";
		String repeat_value			= "";
		String schedule_yn			= "";
		HashMap freqNature			=(HashMap)bean.freqValidate(freq_code);
	
		if(freqNature.size()>0){
			freq_nature		= (String)freqNature.get("freq_nature");
			freq_value		= (String)freqNature.get("freq_value");
			interval_value	= (String)freqNature.get("interval_value");
				if(interval_value==null || interval_value.equals("null"))
      				interval_value="1";
      		
			repeat_value	= (String)freqNature.get("repeat_value");
			if(repeat_value==null || repeat_value.equals("null"))
				repeat_value="1";
			schedule_yn		= (String)freqNature.get("schedule_yn");
			repeat_durn_type= (String)freqNature.get("repeat_durn_type");
		}

		if(freq_nature != null && !freq_nature.equals("O")){
			out.println("dfltDurnDesc(\""+repeat_durn_type+"\")");			
			out.println("assignDurnDesc(\""+repeat_value+"\",\""+repeat_durn_type+"\",\""+freq_nature+"\",\""+interval_value+"\",\""+durn_desc+"\",\""+freq_value+"\",\""+schedule_yn+"\")");
		}
		else{
			durn_desc	="";
			freq_value	="";			
			out.println("assignDurnDesc(\""+repeat_value+"\",\""+repeat_durn_type+"\",\""+freq_nature+"\",\""+interval_value+"\",\""+durn_desc+"\",\""+freq_value+"\",\""+schedule_yn+"\")");
		}
		// objects nullified after usage
		freqNature	=	null;

	}
	else if(func_mode != null && func_mode.equals("validateDuration")){
		//String durn_value		= (String) hash.get( "durn_value" );
		String drug_code		= (String) hash.get( "drug_code" );
		patient_class	= (String) hash.get( "patient_class" );
		String source	        = (String) hash.get( "source" );
		String srlNo			= (String) hash.get( "srlNo" );

		HashMap durnValues=(HashMap)bean.validateDuration(drug_code,patient_class);
		HashMap ext_drugData		=	null;
		String ext_drug_code		=	null;
		String ext_srl_no			=	null;
		//String ext_durn_value		=	null;
		String ext_total_durn_value	=	null;

		if(source.equals("modify")){
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData=(HashMap) prescriptionDetails.get(j);
				ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
				ext_srl_no=(String) ext_drugData.get("SRL_NO");
				//ext_durn_value=(String) ext_drugData.get("DURN_VALUE");
				if( drug_code.equals(ext_drug_code) && srlNo.equals(ext_srl_no) ){
					break;
				}
			}
		}
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
		//out.println("alert('total_durn_value"+total_durn_value+"')");

		if(durnValues.size()>0){
			String prompt_msg = (String)durnValues.get("prompt_msg")==null?"":(String)durnValues.get("prompt_msg");
			out.println("assignDurnvalue('"+total_durn_value+"','"+(String)durnValues.get("max_durn_value")+"','"+(String)durnValues.get("chk_for_max_durn_action")+"','"+java.net.URLEncoder.encode(prompt_msg,"UTF-8")+"')");

		}
		// objects nullified after usage
		durnValues		=	null;
		prescription	=	null;
		ext_drugData	=	null;
	}
	else if(func_mode!= null && func_mode.equals("populateStartDate")){

		String sys_date		=	(String) hash.get( "start_date" );
		String source		=	(String) hash.get( "source" );
		String future_date	=	"";
		String back_date    =	"";

		HashMap dateParams	=	(HashMap) bean.populateDateParams(sys_date);
		
		if(dateParams.size()>0){
			future_date	=	(String) dateParams.get("future_date");
			back_date	=	(String) dateParams.get("back_date");
		}
		out.println("assignStartDate('"+source+"','"+sys_date+"','"+future_date+"','"+back_date+"')");
	}
	else if(func_mode != null && func_mode.equals("validateDosageLimit")){
		String daily_dose						= "";
		String unit_dose						= "";
		String limit_ind						= "";
		String mono_graph						= "";
		String min_daily_dose					= "";
		String min_unit_dose					= "";
		String drug_code						= (String) hash.get( "drug_code" );
		String qty_value						= (String) hash.get( "qty_value" );
		String repeat_value						= (String) hash.get( "repeat_value" );
		String factor                           =(String) hash.get( "factor" );//Added for IN:070451
		if(repeat_value==null || repeat_value.equals("null"))
			repeat_value="1";
		patient_id						= (String) hash.get( "patient_id" );
		//String generic_id						= (String) hash.get( "generic_id" );
		//String start_date						= (String) hash.get( "start_date" );
		//String freq_code						= (String) hash.get( "freq_code" );
		String dosage_type						= (String) hash.get( "dosage_type" );
		String srl_no							= (String) hash.get( "srl_no" );
		String perform_external_database_checks_yn    = (String) hash.get( "perform_external_database_checks_yn" );
		if(perform_external_database_checks_yn.equals("N")){
	/*		ArrayList	schedule		=  (ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
			if(schedule.size() > 0) {
				/* HashMap detail	=	(HashMap)schedule.get(0); //commented by Abdul for Multi frequency CRF
				 qty_value		=	(String)detail.get("admin_qty");
				 ArrayList dose_list		= (ArrayList)schedule.get(4);
				 if(dose_list.size()>0){
					qty_value		=	(String)dose_list.get(0);
					if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
						qty_value="1";
				 }
				 else{
					if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
						qty_value="1";
				 }
			}*///commentted for IN:070451
			HashMap dosageDetails= (HashMap) bean.chkMaxDosageLimit(drug_code,patient_id,qty_value,dosage_type,repeat_value,factor);//Modified for IN:070451
			limit_ind	= (String) dosageDetails.get("LIMIT_IND");
			if(limit_ind != null && limit_ind.equals("N")){
				daily_dose		= (String) dosageDetails.get("DAILY_DOSE");
				unit_dose		= (String) dosageDetails.get("UNIT_DOSE");
				mono_graph		=	"";
				min_daily_dose	= (String) dosageDetails.get("MIN_DAILY_DOSE");
				min_unit_dose	= (String) dosageDetails.get("MIN_UNIT_DOSE");	
				out.println("enableDosageLimit('"+limit_ind+"','"+daily_dose+"','"+unit_dose+"','"+mono_graph+"','"+min_daily_dose+"','"+min_unit_dose+"')");
			}
			else{
				out.println("disableDosageLimit()");
			}	
		}
		else{
			out.println("disableDosageLimit()");
		}	
	}
	else if(func_mode != null && func_mode.equals("storeSchedule")){
		String freq_code		= (String) hash.get( "freq_code" );
		String start_date		= (String) hash.get( "start_date" );
		String split_dose_yn	= (String) hash.get( "split_dose_yn" );
		String qty_value		= (String) hash.get( "qty_value" );
		String drug_code		= (String) hash.get( "drug_code" );
		String srl_no			= (String) hash.get( "srl_no" );
		String rowVal			= (String) hash.get( "rowVal" );
		String scheduled_yn		= (String) hash.get( "scheduled_yn" );

		ArrayList schedule		= (ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");

		String sch_bean_id		= "OrScheduleFreq" ;
		String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
		Hashtable sch_output	=	null;
		Hashtable schedule_val	=	null; 
		if(schedule.size()==0 && scheduled_yn.equals("Y") ) {
			schedule_val	=	new Hashtable();

			ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name,request);
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
			
			bean.setScheduleFrequencyStr(sch_output);
			putObjectInBean(sch_bean_id,schedule_bean,request);
		}
	}
	else if(func_mode != null && func_mode.equals("disableScheduleLink")){
		
		HashMap ext_drugData		=	null;
		ArrayList prescriptionDetails=null;
		String drug_code		=	(String) hash.get( "drug_code" );
		String split_dose_yn_val =  (String) hash.get( "split_dose_yn_val" );
		String calling_mode =  (String) hash.get( "calling_mode" );
		String amend_yn			=	"N";
		String allocatedd_yn	=	"N";
		String ext_drug_code	=	null;
		String ext_srl_no       =   "";
		prescriptionDetails=(ArrayList)bean.getpresDetails();
		for(int j=0;j<prescriptionDetails.size();j++){
			ext_drugData	=	(HashMap) prescriptionDetails.get(j);
			ext_drug_code	=	(String) ext_drugData.get("DRUG_CODE");
			amend_yn		=	(String) ext_drugData.get("AMEND_YN");
			allocatedd_yn	=	(String) ext_drugData.get("ALLOCATEDD_YN");
			ext_srl_no		=   (String) ext_drugData.get("SRL_NO");
			if(calling_mode.equals("taper"))
				ext_srl_no = (Integer.parseInt(ext_srl_no)+1)+"";
			if(drug_code.equals(ext_drug_code+ext_srl_no)&&split_dose_yn_val.equals("N")){
				bean.getclearscheduleFrequency(drug_code);
				out.println("deleteScheduleLink()");
			}
		}	
	}
	else if(func_mode != null && func_mode.equals("populateRefillDates")){
		String end_date			= (String) hash.get( "end_date" );
		String durn_value		= (String) hash.get( "durn_value" );
		String repeat_durn_type	= (String) hash.get( "repeat_durn_type" );
		String refill_value		= (String) hash.get( "refill_no" );
		String srl_no			= (String) hash.get( "srl_no" );

		HashMap populateRefillDates=(HashMap) bean.populateRefillDates(end_date,durn_value,repeat_durn_type,refill_value);
		String refill_st_date=(String) populateRefillDates.get("refill_st_date");
		String refill_en_date=(String) populateRefillDates.get("refill_en_date");
		HashMap	refill_detail	=	bean.populateRefillDetail(end_date,durn_value,repeat_durn_type,refill_value);
		//bean.setRefillDetail(srl_no,refill_detail);//Commented for IN:069886
		out.println("assignRefillDates(\""+ refill_st_date + "\",\""+ refill_en_date + "\");");
		//variables nullified after usage
		populateRefillDates	=	null;
		refill_detail		=	null;
	}
	else if(func_mode != null && func_mode.equals("InsertRec")){
		String oper_mode	= (String)hash.get("oper_mode");
		String tmp_durn_value = request.getParameter("tmp_durn_value");
		String drug_db_interface_yn = (String)hash.get("drug_db_interface_yn")==null?"":(String)hash.get("drug_db_interface_yn"); //Added for	RUT-CRF-0066 IN[029604]
		String DrugIndicationRemarks  = (String) hash.get("DrugIndicationRemarks")==null?"":(String)hash.get("DrugIndicationRemarks");//Added for  ML-BRU-CRF-072[Inc:29938]
		if(!DrugIndicationRemarks.equals(""))
			DrugIndicationRemarks = java.net.URLDecoder.decode(DrugIndicationRemarks,"UTF-8");//Added for  ML-BRU-CRF-072[Inc:29938]
		String approval_no = (String)hash.get("approval_no")==null?"":(String)hash.get("approval_no");
		if(oper_mode != null && oper_mode.equals("taper")){
			boolean can_taper	= false;
			int srl_no			= bean.getSrlNo()+1;

			String drugCode		= (String)hash.get("drug_code");
			String srlNo		= (String)hash.get("srl_no");
			String durn_value	= (String)hash.get("durn_value");
			String freq			= (String)hash.get("frequency");
			String qty_value	= (String)hash.get("qty_value");
			String repeat_value = (String)hash.get("repeat_value");
			if(repeat_value==null || repeat_value.equals("null"))
				repeat_value="1";
			//String dosage		= (String)hash.get("dosage");
			//String strength_value= (String)hash.get("strength_value");
			//String pres_base_uom= (String)hash.get("pres_base_uom");
			//String qty_desc		= (String)hash.get("qty_desc");
			String ph_version	= (String)hash.get("ph_version");
			//String end_date		= (String)hash.get("end_date");	
			
			float new_qty		= Float.parseFloat(qty_value);
			int new_repeat_value= Integer.parseInt(repeat_value);
			float new_total_qty = (new_qty*new_repeat_value);		

			String tot_rec				= (String) hash.get("tot_rec");
			int i						= 0;
			int  tot_alloc_qty			= 0;
			String issue_qty			= ""; 
			String batch_select_yn		= "";
			HashMap Sel_batches         = new HashMap();

			int drug_index=0;
			while(Integer.parseInt(tot_rec)>=i){
				issue_qty			= (String)hash.get("issue_qty_"+i);
				batch_select_yn   = (String)hash.get("select_"+i);
				if(issue_qty!=null && !issue_qty.equals("")&&batch_select_yn!=null&& batch_select_yn.equals("Y")){
					tot_alloc_qty		= tot_alloc_qty+Integer.parseInt(issue_qty);
					Sel_batches.put((i+""),issue_qty);
				}
				i=i+1;
			} 
			//HashMap modifydrugData	=new HashMap();
			ArrayList addprescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap temp			=	new HashMap();
			HashMap ext_drugData	=	null;
			HashMap addext_drugData	=	null;
			String addext_drug_code	=	null;
			String ext_drug_code	=	null;
			String addext_srl_no	=	null;
			String durnValue		=	null;
			String freq_code		=	null;
			String qtyValue			=	null;
			String total_qty_value	=	null;
			String ext_prod_id = "";//Added for	RUT-CRF-0066 IN[029604]
			float ext_total_qty_value = 0;

			for(int j=0;j<addprescriptionDetails.size();j++){
				addext_drugData		= (HashMap) addprescriptionDetails.get(j);
				addext_drug_code	= (String) addext_drugData.get("DRUG_CODE");
				addext_srl_no		= (String) addext_drugData.get("SRL_NO");

				if( drugCode.equals(addext_drug_code) && srlNo.equals(addext_srl_no) ){
					durnValue		= (String) addext_drugData.get("DURN_VALUE");
					freq_code		= (String) addext_drugData.get("FREQ_CODE");
					qtyValue		= (String) addext_drugData.get("QTY_VALUE");
					total_qty_value = (String) addext_drugData.get("TOTAL_QTY_VALUE");
					ext_total_qty_value = Float.parseFloat(total_qty_value.trim());
					ext_prod_id=  (String) addext_drugData.get("EXTERNAL_PRODUCT_ID")==null?"":(String) addext_drugData.get("EXTERNAL_PRODUCT_ID");//Added for	RUT-CRF-0066 IN[029604]
					
					if((!drug_db_interface_yn.equals("Y")) || ext_prod_id.equals("")){// added for FD-RUT-CRF-0066.1 [IN036975] -start
						if( drugCode.equals(addext_drug_code) && srlNo.equals(addext_srl_no)){
							addext_drugData.put("INTERACTION_EXISTS", "N" );
							addext_drugData.put("INTR_MSG_CONTENT","");
							addext_drugData.put("INTR_RESTRIC_TRN","N");
							String intr_msg_content ="", intr_restric_trn="N", severity_level="";
							HashMap hmDrugInteractionDtl = null;
							ArrayList alDrugIntrDtlList = bean.getDrugInteractionDtls(addext_drug_code, (String) addext_drugData.get("FORM_CODE"), (String) addext_drugData.get("GENERIC_ID"),(String) hash.get("start_date") ,(String) hash.get("end_date") , patient_id);
							if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()>2){
								severity_level = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2);
								intr_restric_trn = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1);
								addext_drugData.put("INTR_RESTRIC_TRN", intr_restric_trn );
								addext_drugData.put("INTERACTION_DTL", alDrugIntrDtlList );
								addext_drugData.put("INTERACTION_EXISTS", "Y" );
								if(intr_restric_trn.equals("Y") ){
									temp.put("INTR_ALERT","Y");
									if(addext_drugData.get("AMEND_YN")!=null && ((String)addext_drugData.get("AMEND_YN")).equals("Y"))
										out.println("alertIntr('"+drugCode+"','"+srlNo+"','"+patient_id+"','"+encounter_id+"','N');");
									can_taper=false;
									break;
								}
							}
							else{
								addext_drugData.put("DRUGINTRACTION_OVERRIDE","N");
								addext_drugData.put("INTERACTION_REMARKS","");
							}
						}
					}// added for FD-RUT-CRF-0066.1 [IN036975] - end
					if(((String) addext_drugData.get("TAPER_UP")).equals("N")){
						if( (new_total_qty>ext_total_qty_value)){
							can_taper=false;
							out.println("alertNoTaper('greater')") ;
							break;
						}
					}	
					else{
						if( (new_total_qty<ext_total_qty_value)){
							can_taper=false;
							out.println("alertNoTaper('lesser')") ;
							break;
						}
					}	

					if(freq.equals(freq_code) && qty_value.equals(qtyValue) ){
						can_taper=false;
						out.println("alertNoTaper('nochange')") ;
						break;
					}
					else{
						can_taper=true;
					}

					if(can_taper){
						temp	= (HashMap)	addext_drugData.clone();
						temp.put("SRL_NO",String.valueOf(srl_no));
						bean.addDrugDetails(j,temp);
						bean.setSrlNo(srl_no);
					}
					break;
				}
			}
			//chekcing the stock avail
			boolean no_stock_allow=true;
			if(can_taper){
				if( ph_version != null && !(ph_version.equals("PHBASIC"))){
					String consider_stock_for_pres_yn=(String)hash.get("consider_stock_for_pres_yn");
					if(consider_stock_for_pres_yn != null && consider_stock_for_pres_yn.equals("Y")){
						float st_total_qty=0.0f;
						st_total_qty+=Float.parseFloat(durn_value)*Float.parseFloat(repeat_value)*Float.parseFloat(qty_value);						
		
						ArrayList details			= (ArrayList)bean.getpresDetails();
						String addext_durn_value	= null;
						String addext_repeat_value	= null;
						String addext_qty_value		= null;
						
						for(int j=0;j<details.size();j++){
							addext_drugData		= (HashMap) details.get(j);
							addext_drug_code	= (String) addext_drugData.get("DRUG_CODE");
							addext_durn_value	= (String) addext_drugData.get("DURN_VALUE");
							addext_repeat_value	= (String) addext_drugData.get("REPEAT_VALUE");
							addext_qty_value	= (String) addext_drugData.get("QTY_VALUE");

							if(addext_drug_code.equals(drugCode)){				
								st_total_qty+=Float.parseFloat(addext_durn_value)*Float.parseFloat(addext_repeat_value)*Float.parseFloat(addext_qty_value);
							}
						}
			
						//String item_code		   = (String)hash.get("item_code");
						//String disp_locn_code      = (String)hash.get("disp_locn_code");
						consider_stock_for_pres_yn = (String)hash.get("consider_stock_for_pres_yn");
						//float st_conv_value        = 0.0f;

						/*if(dosage != null && dosage.equals("S"))
						{
							//st_conv_value = (st_total_qty)/ (Float.parseFloat(strength_value)) ;
						}
						else
						{
							//String conv_factor = (String) bean.getConvFactor(qty_desc,pres_base_uom);
//	out.println("alert(\"conv_factor" + conv_factor+ "\");") ;
							//st_conv_value      = (st_total_qty)* (Float.parseFloat(conv_factor));
						}	*/		

						boolean no_stock_found				=	false;
						ArrayList prescriptionDetails		=   (ArrayList)bean.getpresDetails();
						//String drug_code					=	null;
						String stock_available_yn			=	null;
						String allow_pres_without_stock_yn	=	null;

						for(int j=0;j<prescriptionDetails.size();j++){
							ext_drugData				= (HashMap) prescriptionDetails.get(j);
							//drug_code					= (String) ext_drugData.get("DRUG_CODE");
							stock_available_yn			= (String)ext_drugData.get("STOCK_AVAILABLE_YN");
							allow_pres_without_stock_yn = (String)ext_drugData.get("ALLOW_PRES_WITHOUT_STOCK_YN");

							if(consider_stock_for_pres_yn.equals("Y")){
								if(allow_pres_without_stock_yn.equals("N")){
									if(stock_available_yn.equals("N")){
										no_stock_found	= true;
										no_stock_allow	= false;
										break;
									}
								}
							}
						}//for
						if(no_stock_found){
							out.println("alertNoAvailStock()") ;
						}
					}//new if
				}
				//end of stock avail;
			}
			if(no_stock_allow){
				if(can_taper){
					ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
					String ext_srl_no			=	null;
					float Alloc_bms_qty = 0.0f;
					String tot_qty		= "0";
					String order_status	= "";
					String allergy_yn="", limit_ind="", current_rx="", interaction_exists="", Override_remarks="", pract_name="", allergy="", exceed_dose="", dup_drug=""; 
					String override_chk		="", overideRemarks="";
					String allergy_remarks="", dose_remarks="", currentrx_remarks="";
					for(int j=0;j<prescriptionDetails.size();j++){
						ext_drugData			= (HashMap) prescriptionDetails.get(j);
						ext_drug_code			= (String) ext_drugData.get("DRUG_CODE");
						ext_srl_no				= (String) ext_drugData.get("SRL_NO");

						if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
							override_chk		="";
							if(hash.containsKey("override_chk")){
								override_chk		= (String) hash.get("override_chk");
							}
							else{
								override_chk		= "N";
							}
							ext_drugData.put("SEL_BATCHES",Sel_batches);
							ext_drugData.put("override_chk",override_chk);
							interaction_exists  =(String) hash.get("interaction_exists")==null?"":(String) hash.get("interaction_exists"); // added for FD-RUT-CRF-0066.1 [IN036975]
							if(override_chk.equals("Y")){
								allergy_yn		= (String) hash.get("allergy_yn");
								current_rx		= (String) hash.get("current_rx");
								limit_ind		= (String) hash.get("limit_ind");
								pract_name		= (String) hash.get("pract_name");	
								allergy			= "";
								exceed_dose		= "";
								dup_drug			= "";
								interaction_exists			= "";
								if(allergy_yn.equals("Y"))
									allergy				="Overridden By "+pract_name ;

								if(limit_ind.equals("N"))
									exceed_dose			="Overridden By "+pract_name ;

								if(current_rx.equals("Y"))
									dup_drug			="Overridden By "+pract_name ;
								if(!allergy.equals("") ) {
									allergy_remarks = (String)ext_drugData.get("ALLERGY_REMARKS");
									if(allergy_remarks.equals("")){
										ext_drugData.put("ALLERGY_REMARKS",allergy);
										ext_drugData.put("ALLERGY_OVERRIDE","Y");
									}
								}
								if(!exceed_dose.equals("")) {
									dose_remarks = (String)ext_drugData.get("DOSE_REMARKS");
									if(dose_remarks.equals("")){
										ext_drugData.put("DOSE_REMARKS",exceed_dose);
										ext_drugData.put("DOSE_OVERRIDE","Y");
									}
								}
								if(!dup_drug.equals("")) {
									currentrx_remarks = (String)ext_drugData.get("CURRENTRX_REMARKS");
									if(currentrx_remarks.equals("")){
										ext_drugData.put("CURRENTRX_REMARKS",dup_drug);
										ext_drugData.put("CURRENTRX_OVERRIDE","Y");
									}
								}
								if(interaction_exists.equals("Y")) { // added for FD-RUT-CRF-0066.1 [IN036975]
									overideRemarks = (String)ext_drugData.get("CURRENTRX_REMARKS");
									if(overideRemarks==null && overideRemarks.equals("")){
										overideRemarks			="Overridden By "+pract_name ;
										ext_drugData.put("DRUGINTRACTION_OVERRIDE",overideRemarks);
										ext_drugData.put("INTERACTION_REMARKS","Y");
									}
								}
							}
							while(Integer.parseInt(tot_rec)>=i){
								issue_qty			= (String)hash.get("issue_qty_"+i);
								batch_select_yn   = (String)hash.get("select_"+i);

								if(issue_qty!=null && !issue_qty.equals("")&&batch_select_yn!=null&& batch_select_yn.equals("Y")){
									tot_alloc_qty		= tot_alloc_qty+Integer.parseInt(issue_qty);
									Sel_batches.put((i+""),issue_qty);
								}
								i=i+1;
							} 
							tot_qty =(String) hash.get("tot_qty");
							if(tot_alloc_qty!=0){
							  Alloc_bms_qty  = new Float( (Float.parseFloat(tot_qty))-(tot_alloc_qty)).intValue();
							  if(Alloc_bms_qty<0)
								  Alloc_bms_qty=0;
							}
							if(Alloc_bms_qty ==0 ||Alloc_bms_qty ==0.0){
								order_status="58";
							}
							else{
								order_status="56";
							}

							ext_drugData.put("ORDER_STATUS",order_status);
							ext_drugData.put("ALLOC_BMS_QTY",Alloc_bms_qty+"");
							ext_drugData.put("ROUTE_CODE",(String) hash.get("route_code"));
							ext_drugData.put("ROUTE_DESC",(String) hash.get("route_desc"));
							ext_drugData.put("DOSAGE_TYPE",(String) hash.get("dosage"));
							ext_drugData.put("FREQ_CODE",(String) hash.get("frequency"));
							ext_drugData.put("FREQ_DESC",java.net.URLDecoder.decode(((String) hash.get("freq_desc")),"UTF-8"));
							ext_drugData.put("QTY_VALUE",(String) hash.get("qty_value"));
							ext_drugData.put("QTY_DESC",(String) hash.get("qty_desc"));
							ext_drugData.put("OR_QTY_DESC",(String) hash.get("or_qty_desc"));
							ext_drugData.put("DURN_VALUE",(String) hash.get("durn_value"));
							ext_drugData.put("DURN_DESC",(String) hash.get("durn_desc"));
							ext_drugData.put("TAPPERED_OVER","Y");
							ext_drugData.put("TOTAL_QTY_VALUE",""+new_total_qty);

							ext_drugData.put("DOSE_OVERRIDE",(String) hash.get("dose_override"));
							ext_drugData.put("QTY_DESC_CODE",(String) hash.get("qty_desc"));
							ext_drugData.put("OR_DURN_DESC",(String) hash.get("or_durn_desc"));
							ext_drugData.put("SPLIT_DOSE",(String) hash.get("split_dose"));
							ext_drugData.put("START_DATE",(String) hash.get("start_date"));
							ext_drugData.put("END_DATE",(String) hash.get("end_date"));
							ext_drugData.put("AUTH_YN",(String) hash.get("authroize_yn"));
							ext_drugData.put("APPROVAL_YN",(String) hash.get("approval_yn"));
							ext_drugData.put("COSIGN_YN",(String) hash.get("cosign_yn"));
							ext_drugData.put("AUTH_YN_VAL",(String) hash.get("authroize_yn_val"));
							ext_drugData.put("APPROVAL_YN_VAL",(String) hash.get("approval_yn_val"));
							ext_drugData.put("COSIGN_YN_VAL",(String) hash.get("cosign_yn_val"));
							ext_drugData.put("ALLOW_REFILL",(String) hash.get("allow_refill"));
							ext_drugData.put("NO_REFILL",(String) hash.get("no_refill"));
							ext_drugData.put("REFILL_START_DATE",(String) hash.get("refill_start_date"));
							ext_drugData.put("REFILL_END_DATE",(String) hash.get("refill_end_date"));
							ext_drugData.put("ADMIN_TIME",(String) hash.get("admin_time"));
							ext_drugData.put("ADMIN_QTY",(String) hash.get("admin_qty"));
							ext_drugData.put("TOT_ALLOC_QTY", tot_alloc_qty+"");
							ext_drugData.put("BASE_UOM", (String) hash.get("BASE_UOM"));//added for AAKH-SCF-0189 [IN:054663]
							ext_drugData.put("ORD_QTY",(String) hash.get("tot_qty"));
							ext_drugData.put("DFLT_QTY_UOM",(String) hash.get("dflt_qty_uom"));
							ext_drugData.put("DFLT_QTY_UOM",(String) hash.get("in_dispensed_uom"));
							ext_drugData.put("TOT_STRENGTH",(String) hash.get("in_total_strength"));
							ext_drugData.put("TOT_STRENGTH_UOM",(String) hash.get("in_total_strength_uom"));
							ext_drugData.put("DISPENSED_QTY",(String) hash.get("in_dispensed_qty"));
							ext_drugData.put("DISPENSED_UOM",(String) hash.get("in_dispensed_uom"));
							ext_drugData.put("BMS_QTY",(String) hash.get("in_bms_qty"));
							ext_drugData.put("DRUG_INDICATION",DrugIndicationRemarks);//Added for  ML-BRU-CRF-072[Inc:29938] 
							ext_drugData.put("approval_no",approval_no);//added for AAKH-CRF-0117
							ext_drugData.put("SCH_OVER_YN",(String) hash.get("sch_over_yn"));
							ext_drugData.put("TMP_DURN_VALUE",tmp_durn_value);
							ArrayList tempBatchDetails= bean.getTaperBatchDetails(ext_drug_code+Integer.parseInt(ext_srl_no)+"");
							//tempBatchDetails==null?new ArrayList():tempBatchDetails;
							ext_drugData.put("BATCH_DETAILS",tempBatchDetails);
						}
					}
				}
			}
		// objects nullified after usage
			//modifydrugData				=	null;
			addprescriptionDetails		=	null;
			temp						=	null;
			ext_drugData				=	null;
			addext_drugData				=	null;
		}
		else if(oper_mode.equals("modify") || oper_mode.equals("taperd")){
			HashMap ext_drugData		=	null;
			String drug_code			=	null;
			String allow_pres_without_stock_yn	=	null;
			String ext_drug_code		=	null;
			String ext_srl_no			=	null;
			String perform_external_database_checks	="";
			String drugCode				= (String)hash.get("drug_code");
			String srlNo				= (String)hash.get("srl_no");
			//String durn_value			= ((String)hash.get("durn_value")).trim();
			String qty_value			= ((String)hash.get("qty_value")).trim();
			String perform_external_database_checks_yn    = (String) hash.get( "perform_external_database_checks_yn" ); // Added for 69759
			String repeat_value			= (String)hash.get("repeat_value");
			if(repeat_value==null || repeat_value.equals("null"))
				repeat_value="1";
			String dosage				= ((String)hash.get("dosage")).trim();
			String pres_base_uom		= (String)hash.get("pres_base_uom");
			String qty_desc				= (String)hash.get("qty_desc");
			String ph_version			= (String)hash.get("ph_version");
			String end_date				= (String)hash.get("end_date");
				   patient_id			= (String) hash.get( "patient_id" );
			String dosage_type			= (String) hash.get( "dosage_type" );
			String absol_qty			= (String) hash.get("absol_qty");
			String brought_by_pat		= (String) hash.get("brought_by_pat");
			String freq_nature			= (String) hash.get("freq_nature");
			String current_rx			= (String) hash.get("current_rx");
			String allow_duplicate		= (String) hash.get("allow_duplicate");
				   patient_class		= (String) hash.get("patient_class");
			String take_home			= (String) hash.get("take_home");
			String pat_counseling_reqd	=( ((String)hash.get("pat_counseling_reqd")) ==null)?"N":(String)hash.get("pat_counseling_reqd") ;
            String drug_db_dose_check_flag			= (String) hash.get("drug_db_dose_check_flag");
            String override_select_appl	=( ((String)hash.get("override_select_appl")) ==null)?"N":(String)hash.get("override_select_appl") ;//Added for IN:073485 
			String trade_code			= (String) hash.get("TRADE_CODE");	
			String tot_rec				= (String) hash.get("tot_rec");
			String validate_overide_on_confirm_yn				=( ((String)hash.get("validate_overide_on_confirm_yn")) ==null)?"N":(String)hash.get("validate_overide_on_confirm_yn") ; //Added for IN:069887 
			int i						= 0;
			int  tot_alloc_qty			= 0;
			String issue_qty			= ""; 
			String batch_select_yn		= "";
			HashMap Sel_batches         = new HashMap();

			int drug_index=0;
			while(Integer.parseInt(tot_rec)>=i){
				issue_qty			= (String)hash.get("issue_qty_"+i);
				batch_select_yn   = (String)hash.get("select_"+i);
				if(issue_qty!=null && !issue_qty.equals("")&& !issue_qty.equals("0")&&batch_select_yn!=null&& batch_select_yn.equals("Y")){
					tot_alloc_qty		= tot_alloc_qty+Integer.parseInt(issue_qty);
					Sel_batches.put((i+""),issue_qty);
				}
				i=i+1;
			} 

			if(brought_by_pat == null) {
				brought_by_pat		=	"";
			} 

			if(absol_qty == null || absol_qty == "")
				 absol_qty		=	"1";
			if(current_rx.equals("Y") && allow_duplicate.equals("N") &&  !freq_nature.equals("O")) { //(patient_class.equals("IP") || Integer.parseInt(take_home)>0) &&
				out.println("duplicateWarning()");
				return;
			}

			ArrayList	schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drugCode+srlNo,"0");
			String sch_size			=	"";			

			if(schedule.size() > 0) {
				/* HashMap detail	=	(HashMap)schedule.get(0); //commented by Abdul for multi frequency CRF
				 qty_value		=	(String)detail.get("admin_qty");
				 sch_size		=	""+schedule.size();*/
				ArrayList dose_list		= (ArrayList)schedule.get(4);
				if(dose_list.size()>0){
					qty_value		= (String)dose_list.get(0);
					if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
						qty_value="1";
				}
				else{
					if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
						qty_value="1";
				}
				sch_size		=	""+dose_list.size();
			} 
			else {
				sch_size		=	repeat_value;
			}
			
			//HashMap dosageDetails	= (HashMap) bean.chkMaxDosageLimit(drugCode,patient_id,qty_value,dosage_type,repeat_value);
			boolean no_stock_allow	= true;

			if( !(ph_version.equals("PHBASIC"))){
				String disp_locn_code	= bean.getDispLocnCode();  
				String consider_stock_for_pres_yn = (String)hash.get("consider_stock_for_pres_yn");
				if(consider_stock_for_pres_yn.equals("Y")){
					boolean no_stock_found	=	false;
					String conv_factor		=	"";
			
					ArrayList prescriptionDetails = (ArrayList)bean.getpresDetails();
					if(dosage_type.equals("Q"))
						conv_factor					  = (String) bean.getConvFactor(qty_desc,pres_base_uom);

					for(int j=0;j<prescriptionDetails.size();j++){
					
						ext_drugData		= (HashMap) prescriptionDetails.get(j);
						drug_code			= (String) ext_drugData.get("DRUG_CODE");

						//stock_available_yn	= (String) ext_drugData.get("STOCK_AVAILABLE_YN");
						allow_pres_without_stock_yn = (String)ext_drugData.get("ALLOW_PRES_WITHOUT_STOCK_YN");
						if(drugCode.equals(drug_code)){
						
							if(((String)ext_drugData.get("IN_FORMULARY_YN")).equals("Y") ) {
								if(consider_stock_for_pres_yn.equals("Y")){
									
									if(allow_pres_without_stock_yn.equals("N")){
										trade_code	=	(String) ext_drugData.get("TRADE_CODE");
										HashMap stockValues			= (HashMap) bean.chkStockAvail(drugCode+"="+trade_code,disp_locn_code,tot_alloc_qty+"",end_date);
										//stock_available_yn			= (String) stockValues.get("STOCK_AVAILABLE_YN");
										String available_stock		= (String) stockValues.get("AVAILABLE_STOCK");

										if(dosage_type.equals("A") || freq_nature.equals("P")) {
											qty_value	=	absol_qty;
											dosage		=	"A";
										}
										if(tot_alloc_qty >Float.parseFloat(available_stock)) {
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
					//return;
					} 
				}
				else{
					no_stock_allow = true;
				}
			}
			else{
				no_stock_allow = true;
			}

			if(no_stock_allow){
				float new_qty			=	Float.parseFloat(qty_value);
				int new_repeat_value	=	Integer.parseInt(repeat_value);
				//int new_durn_value		=	Integer.parseInt(durn_value);
				float new_total_qty		=	(new_qty*new_repeat_value);
				int srno=Integer.parseInt(srlNo);
				int codeCount_1			= 0;
				int codeCount_2			= 0;
				ArrayList prescriptionDetails = (ArrayList)bean.getpresDetails();
				boolean can_modify		= false;

				for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData		=	(HashMap) prescriptionDetails.get(j);
				ext_drug_code		=	(String) ext_drugData.get("DRUG_CODE");
				ext_srl_no=(String) ext_drugData.get("SRL_NO");
				if(drugCode.equals(ext_drug_code)){
					codeCount_1++;
				}
				if(drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no))
					drug_index = j;
				}
				if(codeCount_1>1){
					for(int k=drug_index;k<prescriptionDetails.size();k++){
						ext_drugData	=	(HashMap) prescriptionDetails.get(k);
						ext_drug_code	=	(String) ext_drugData.get("DRUG_CODE");
						if(drugCode.equals(ext_drug_code)){
							codeCount_2++;
						}
					}
				}
				if(codeCount_1>1 && codeCount_2!=1){
					can_modify	=	false;
					out.println("alertParentRecord('modify')") ;
				}
				else{
					can_modify	=	true;
				}
				float Alloc_bms_qty = 0.0f;
				String tot_qty		="0";
				String order_status	="";
				String override_chk		="", allergy_yn="", limit_ind="", pract_name="",allergy="",  exceed_dose="",dup_drug="" ;
				String  currentrx_remarks="",allow1="", allow2="", allow3="", allow4="", allergy_remarks="", dose_remarks="" , interaction_exists="", Override_remarks="", ext_prod_id="";
				if(can_modify){
					//HashMap modifydrugData=new HashMap();
					prescriptionDetails=(ArrayList)bean.getpresDetails();
					for(int j=0;j<prescriptionDetails.size();j++){
						ext_drugData	=	(HashMap) prescriptionDetails.get(j);
						ext_drug_code	=	(String) ext_drugData.get("DRUG_CODE");
						ext_srl_no		=	(String) ext_drugData.get("SRL_NO");
						ext_prod_id=  (String) ext_drugData.get("EXTERNAL_PRODUCT_ID")==null?"":(String) ext_drugData.get("EXTERNAL_PRODUCT_ID");// added for FD-RUT-CRF-0066.1 [IN036975]
						perform_external_database_checks = (String) ext_drugData.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
						if( drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no) ){

							if((!drug_db_interface_yn.equals("Y")) || ext_prod_id.equals("")){// added for FD-RUT-CRF-0066.1 [IN036975] - start
								if( drugCode.equals(ext_drug_code) && ((String.valueOf(srlNo)).equals(ext_srl_no))){
									ext_drugData.put("INTERACTION_EXISTS", "N" );
									ext_drugData.put("INTR_MSG_CONTENT","");
									ext_drugData.put("INTR_RESTRIC_TRN","N");
									String intr_msg_content ="", intr_restric_trn="N", severity_level="";
									HashMap hmDrugInteractionDtl = null;
									ArrayList alDrugIntrDtlList = bean.getDrugInteractionDtls(ext_drug_code, (String) ext_drugData.get("FORM_CODE"), (String) ext_drugData.get("GENERIC_ID"),(String) hash.get("start_date"),(String) hash.get("end_date") , patient_id);
									if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()>2){
										severity_level = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2);
										intr_restric_trn = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1);
										ext_drugData.put("INTR_RESTRIC_TRN", intr_restric_trn );
										ext_drugData.put("INTERACTION_DTL", alDrugIntrDtlList );
										ext_drugData.put("INTERACTION_EXISTS", "Y" );
										if(intr_restric_trn.equals("Y") ){
											ext_drugData.put("INTR_ALERT","Y");
											if(ext_drugData.get("AMEND_YN")!=null && ((String)ext_drugData.get("AMEND_YN")).equals("Y"))
												out.println("alertIntr('"+drugCode+"','"+srlNo+"','"+patient_id+"','"+encounter_id+"','N');");
											can_modify=false;
											break;
										}
									}
									else{
										ext_drugData.put("DRUGINTRACTION_OVERRIDE","N");
										ext_drugData.put("INTERACTION_REMARKS","");
									}
								}
							}// added for FD-RUT-CRF-0066.1 [IN036975] -end
							ext_drugData.put("AMEND_YN","Y");
							ext_drugData.put("ALLOCATEDD_YN","Y");
							ext_drugData.put("ORD_QTY",(String) hash.get("tot_qty"));

							ext_drugData.put("TOT_ALLOC_QTY",tot_alloc_qty+"");
							ext_drugData.put("BASE_UOM", (String) hash.get("BASE_UOM"));//added for AAKH-SCF-0189 [IN:054663]
							ext_drugData.put("SEL_BATCHES",Sel_batches);
							//Sel_batches
							tot_qty =(String) hash.get("tot_qty");
							if(tot_alloc_qty!=0){
								Alloc_bms_qty  = new Float( (Float.parseFloat(tot_qty))-(tot_alloc_qty)).intValue();
								if(Alloc_bms_qty<0)
									Alloc_bms_qty=0;
							}
							if(Alloc_bms_qty ==0 ||Alloc_bms_qty ==0.0){
								order_status="58";
							}
							else{
								order_status="56";
							}
							ext_drugData.put("ORDER_STATUS",order_status);
							ext_drugData.put("ALLOC_BMS_QTY",Alloc_bms_qty+"");
							ext_drugData.put("ROUTE_CODE",(String) hash.get("route_code"));
							ext_drugData.put("PRIORITY",(String) hash.get("priority"));
							ext_drugData.put("BROUGHT_BY_PAT",brought_by_pat);
							ext_drugData.put("FREQ_NATURE",(String) hash.get("freq_nature"));
							ext_drugData.put("ROUTE_DESC",(String) hash.get("route_desc"));
							ext_drugData.put("DOSAGE_TYPE",(String) hash.get("dosage"));
							ext_drugData.put("FREQ_CODE",(String) hash.get("frequency"));
							ext_drugData.put("FREQ_DESC",java.net.URLDecoder.decode(((String) hash.get("freq_desc")),"UTF-8"));
							ext_drugData.put("QTY_VALUE",(String) hash.get("qty_value"));
							ext_drugData.put("QTY_DESC",(String) hash.get("qty_desc"));
							ext_drugData.put("QTY_DESC_CODE",(String) hash.get("qty_desc"));
							ext_drugData.put("REPEAT_VALUE",(String) hash.get("repeat_value"));
							ext_drugData.put("INTERVAL_VALUE",(String) hash.get("interval_value"));
							ext_drugData.put("DURN_TYPE",(String) hash.get("repeat_durn_type"));
							ext_drugData.put("REPEAT_DURN_TYPE",(String) hash.get("repeat_durn_type"));
							ext_drugData.put("DURN_VALUE",(String) hash.get("durn_value"));
							ext_drugData.put("TMP_DURN_VALUE",tmp_durn_value);
							ext_drugData.put("DURN_DESC",(String) hash.get("durn_desc"));
							ext_drugData.put("SPLIT_DOSE",(String) hash.get("split_dose"));
							ext_drugData.put("DRUG_INDICATION",DrugIndicationRemarks);//Added for  ML-BRU-CRF-072[Inc:29938]
							ext_drugData.put("approval_no",approval_no);//added for AAKH-CRF-0117
							ext_drugData.put("SPLIT_DOSE_YN_VAL",(String) hash.get("split_dose_yn_val"));
							//code for conrolling whether to perform External checks or PH module checks    

							if(perform_external_database_checks.equals("N")){				
								if( (ext_drugData.get("ALERT_YN")!=null && (ext_drugData.get("CURRENTRX_REMARKS")==null || ((String)ext_drugData.get("CURRENTRX_REMARKS")).equals("") ) ) || bean.checkDuplicateDrug(patient_id, (String) ext_drugData.get("GENERIC_ID"), (String) hash.get("start_date"),(String) hash.get("end_date"),(String) hash.get("frequency"))) {//end_date Added for ML-BRU-SCF-0811 [IN:039394] 
									ext_drugData.put("CURRENT_RX","Y");
								} 
								/*else {
								ext_drugData.put("CURRENT_RX","N");
								}*/ //Commented for MO-GN-5400 IN[30118]
							}
							else{
								ext_drugData.put("CURRENT_RX","N");
							}
							override_chk		="";
							if(hash.containsKey("override_chk")){
								override_chk		= (String) hash.get("override_chk");
							}
							else{
								override_chk		= "N";
							}
							ext_drugData.put("override_chk",override_chk);
							allergy_yn		= (String) hash.get("allergy_yn");
							current_rx		= (String) hash.get("current_rx");
							limit_ind		= (String) hash.get("limit_ind");
							pract_name		= (String) hash.get("pract_name");	
							interaction_exists  =(String) ext_drugData.get("INTERACTION_EXISTS")==null?"N":(String) ext_drugData.get("INTERACTION_EXISTS"); // added for FD-RUT-CRF-0066.1 [IN036975]
							// Modified for IN:073485 start
							if(override_chk.equals("Y")){
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
								if( interaction_exists.equals("Y") && (ext_drugData.get("DRUGINTRACTION_OVERRIDE")==null || !((String)ext_drugData.get("DRUGINTRACTION_OVERRIDE")).equals("Y"))){	// added for FD-RUT-CRF-0066.1 [IN036975]- start								
									if(Override_remarks==null || Override_remarks.equals("")){
										if(override_select_appl.equals("Y")){
											Override_remarks="";
										}
										else{
											Override_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
										}
									}
									// Modified for IN:073485 end
									ext_drugData.put("DRUGINTRACTION_OVERRIDE","Y");
										//added for MMS-KH-CRF-0029 - start
										if(ext_drugData.containsKey("FOOD_INTERACTION_EXISTS")){
											if(((String)ext_drugData.get("FOOD_INTERACTION_REMARKS"))==null || ((String)ext_drugData.get("FOOD_INTERACTION_REMARKS")).equals("") )
											ext_drugData.put("FOOD_INTERACTION_REMARKS",Override_remarks);
										}
										if(ext_drugData.containsKey("LAB_INTERACTION_EXISTS")){
											if(((String)ext_drugData.get("LAB_INTERACTION_REMARKS"))==null || ((String)ext_drugData.get("LAB_INTERACTION_REMARKS")).equals("") )
											ext_drugData.put("LAB_INTERACTION_REMARKS",Override_remarks);
										} //added for MMS-KH-CRF-0029 - end

									ext_drugData.put("INTERACTION_REMARKS",Override_remarks);
								} // added for FD-RUT-CRF-0066.1 [IN036975] - end

							}
							else{
								allow1="Y";
								allow2="Y";
								allow3="Y";
								allow4="Y";
								if(allergy_yn.equals("Y")){
									allergy_remarks = (String)ext_drugData.get("ALLERGY_REMARKS");
									if(allergy_remarks.equals("")){
										allow1="N"; 
									}
								}

								if(limit_ind.equals("N")){
									dose_remarks =(String) ext_drugData.get("DOSE_REMARKS");
									if(dose_remarks==null || dose_remarks.equals("")){
										allow2="N"; 
									}
								}

								if(current_rx.equals("Y")){
									currentrx_remarks = (String)ext_drugData.get("CURRENTRX_REMARKS");
									if(currentrx_remarks==null || currentrx_remarks.equals("")){
										 allow3="N"; 
									}
								}
								if(interaction_exists.equals("Y")){ // added for FD-RUT-CRF-0066.1 [IN036975]
									Override_remarks = (String)ext_drugData.get("INTERACTION_REMARKS");
									if(Override_remarks==null || Override_remarks.equals("")){
										 allow4="N"; 
									}
								}
								if((allow1.equals("N")||allow2.equals("N")||allow3.equals("N")||allow4.equals("N")) && !perform_external_database_checks_yn.equals("Y")){ // && !perform_external_database_checks_yn.equals("Y") Added for 69759
								// Modified for IN:069887 start
									if(validate_overide_on_confirm_yn.equals("Y")){
										out.println("validateOnConfirm()") ;
									}
									else{
									out.println("alertoverride()") ;
									}
									// Modified for IN:069887 end
								} 
							}

							ext_drugData.put("START_DATE",(String) hash.get("start_date"));
							ext_drugData.put("END_DATE",(String) hash.get("end_date"));
							ext_drugData.put("AUTH_YN",(String) hash.get("authroize_yn"));
							ext_drugData.put("APPROVAL_YN",(String) hash.get("approval_yn"));
							ext_drugData.put("COSIGN_YN",(String) hash.get("cosign_yn"));
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
							ext_drugData.put("UNIT_DOSE",(String) hash.get("unit_dose"));
							ext_drugData.put("DAILY_DOSE",(String) hash.get("daily_dose"));
							ext_drugData.put("ABSOL_QTY",absol_qty);
							ext_drugData.put("STOCK_AVAILABLE_YN","Y");
							ext_drugData.put("PAT_COUNSELING_REQD",pat_counseling_reqd);
							ext_drugData.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dose_check_flag);
							ext_drugData.put("DRUG_INDICATION",DrugIndicationRemarks);//Added for  ML-BRU-CRF-072[Inc:29938]
							ext_drugData.put("approval_no",approval_no);//added for AAKH-CRF-0117
							if( (!((String) hash.get("dosage")).equals("A")) ){
								ext_drugData.put("PROVIDE_TAPER","Y");
							}
							else{
								ext_drugData.put("PROVIDE_TAPER","N");
							}
						}
					}
				}
			}
			schedule			=	null;
		}
		else if(oper_mode.equals("delete")){
			String drugCode		= (String)hash.get("drug_code");
			String srlNo		= (String)hash.get("srl_no");
				   patient_id	= (String)hash.get("patient_id");
				   encounter_id	= (String)hash.get("encounter_id");

			String search_bean_id   ="@DrugSearchBean"+patient_id+encounter_id;
			String search_bean_name ="ePH.DrugSearchBean";

			DrugSearchBean searchbean = (DrugSearchBean)getBeanObject( search_bean_id,search_bean_name,request) ;

			int srno		= Integer.parseInt(srlNo);
			int remove_pos	= 0;
			//HashMap modifydrugData			= new HashMap();
			ArrayList prescriptionDetails   = (ArrayList)bean.getpresDetails();
			int codeCount_1			= 0;
			int codeCount_2			= 0;
			HashMap ext_drugData	= null;
			String ext_drug_code	= null;
			String ext_srl_no		= null;
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData		= (HashMap) prescriptionDetails.get(j);
				ext_drug_code		= (String) ext_drugData.get("DRUG_CODE");
				ext_srl_no			= (String) ext_drugData.get("SRL_NO");
				if(drugCode.equals(ext_drug_code)){
					codeCount_1++;
				}
			}
			if(codeCount_1>1){
				for(int k=(srno-1);k<prescriptionDetails.size();k++){
				ext_drugData		= (HashMap) prescriptionDetails.get(k);
				ext_drug_code		= (String) ext_drugData.get("DRUG_CODE");
				if(drugCode.equals(ext_drug_code)){
					codeCount_2++;
					}
				}
			}
			for(int h=0;h<prescriptionDetails.size();h++){
				ext_drugData		= (HashMap) prescriptionDetails.get(h);
				ext_drug_code		= (String) ext_drugData.get("DRUG_CODE");
				ext_srl_no			= (String) ext_drugData.get("SRL_NO");//To remove corresponding drug details from prescriptionDetails
				if( (drugCode.equals(ext_drug_code)) && (srlNo.equals(ext_srl_no)) ){
					remove_pos = h;
					break;
				}
			}			
			if(codeCount_1>1 && codeCount_2>1){
				out.println("alertParentRecord('delete')") ;
			}
			else{
				prescriptionDetails.remove((remove_pos));
				searchbean.removeDrugCode(drugCode);
				searchbean.removeSelectedDrug(drugCode);
				bean.getclearscheduleFrequency(drugCode+(remove_pos+1));//To remove corresponding [drugcode+srlno] from scheduleFrequency
				bean.removePRNRemarks(drugCode);//Added for SKR-SCF-0647[Inc:35263]
				HashMap issue_uom_qty = bean.getIssueUomQty();
				issue_uom_qty.remove(drugCode+srlNo);	
				
				String inrteraction_exists="", intr_msg_content="", restrict_transaction="N", severity_level="", ext_prod_id=""; // added for FD-RUT-CRF-0066.1 [IN036975] - start
				ArrayList alDrugIntrDtlList = null;
				HashMap hmDrugInteractionDtl = null;
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
								alDrugIntrDtlList = bean.getDrugInteractionDtls(ext_drug_code,  (String) ext_drugData.get("FORM_CODE"), (String) ext_drugData.get("GENERIC_ID"),(String)ext_drugData.get("START_DATE") ,(String)ext_drugData.get("END_DATE") , patient_id);
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
								}
							}
						}
					}
				}// added for FD-RUT-CRF-0066.1 [IN036975]- end
			}
			// objects nullified after usage
			putObjectInBean(search_bean_id,searchbean,request);
			searchbean			=	null;
			//modifydrugData		=	null;
			prescriptionDetails	=	null;
		}
	}
	else if(func_mode!= null && func_mode.equals("editlabel")) {  //added for edit label 19/4/2004
		//newly added for RUT-CRF-0067 start
			String sCalledFrom				= request.getParameter("calledFrom");  
			int iTotalRecords				= Integer.parseInt(request.getParameter("totalRecordds"));
		//newly added for RUT-CRF-0067 --end
			String ext_drug_code			= "";
			String ext_srl_no			    = "";
			String srl_no					= "";
			String drug_code				= "";
			String chk						= "";
			String caution_1				= "";
			String caution_2				= "";
			String special_1				= "";
			String special_2				= "";
			String patient_int				= "";
			String loc_caution_1			= "";
			String loc_caution_2			= "";
			String loc_special_1			= "";
			String loc_special_2			= "";
			String loc_patient_int			= "";
			String drug_indication			= "";//Added DRUG_INDICATION for  ML-BRU-CRF-072[Inc:29938]
//newly added for RUT-CRF-0067 --start			
			int recno = 0;
			ArrayList printList             = new ArrayList();
			String noOfPrints             = "";
//newly added for RUT-CRF-0067 --end
			//String ret_val					="OK";
			HashMap ext_drugData	        = null;
			ArrayList editLabel				= new ArrayList();
			//String recno					= request.getParameter("recno");
			//if (recno==null)     recno="";	
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
//newly added for RUT-CRF-0067 --start
			for(int iCount= 1; iCount<=iTotalRecords;iCount++){

				srl_no					= request.getParameter("srl_no_"+iCount)== null?"":request.getParameter("srl_no_"+iCount);
				drug_code				= request.getParameter( "drug_code_"+iCount )== null?"":request.getParameter( "drug_code_"+iCount );
				recno					= Integer.parseInt(request.getParameter( "recno" )== null?"":request.getParameter( "recno" ));
				chk						= request.getParameter( "chk_"+iCount )== null?"":request.getParameter( "chk_"+iCount );
				caution_1				= request.getParameter( "caution_1_"+iCount)== null?"":request.getParameter( "caution_1_"+iCount);
				caution_2				= request.getParameter( "caution_2_"+iCount)== null?"":request.getParameter( "caution_2_"+iCount);
				special_1				= request.getParameter( "special_1_"+iCount)== null?"":request.getParameter( "special_1_"+iCount);
				special_2				= request.getParameter( "special_2_"+iCount)== null?"":request.getParameter( "special_2_"+iCount);
				patient_int				= request.getParameter( "patient_int_"+iCount)== null?"":request.getParameter( "patient_int_"+iCount);
				loc_caution_1			= request.getParameter( "loc_caution_1_"+iCount )== null?"":request.getParameter( "loc_caution_1_"+iCount );
				loc_caution_2			= request.getParameter( "loc_caution_2_"+iCount )== null?"":request.getParameter( "loc_caution_2_"+iCount );
				loc_special_1			= request.getParameter( "loc_special_1_"+iCount )== null?"":request.getParameter( "loc_special_1_"+iCount );
				loc_special_2			= request.getParameter( "loc_special_2_"+iCount )== null?"":request.getParameter( "loc_special_2_"+iCount );
				loc_patient_int			= request.getParameter( "loc_patient_int_"+iCount )== null?"":request.getParameter( "loc_patient_int_"+iCount );
				drug_indication			= request.getParameter( "drug_ind_"+iCount )== null?"":request.getParameter( "drug_ind_"+iCount );//Added DRUG_INDICATION for  ML-BRU-CRF-072[Inc:29938]

				noOfPrints				= request.getParameter( "noOfPrints"+iCount )== null?"":request.getParameter( "noOfPrints"+iCount );
				//request parameter names changed with index added for RUT-CRF-0067 --end
				editLabel.add(caution_1);
				editLabel.add(caution_2);
				editLabel.add(special_1);
				editLabel.add(special_2);
				editLabel.add(patient_int);			
				editLabel.add(loc_caution_1) ;
				editLabel.add(loc_caution_2) ;
				editLabel.add(loc_special_1) ;
				editLabel.add(loc_special_2) ;
				editLabel.add(loc_patient_int) ;
				editLabel.add(drug_indication) ;//Added DRUG_INDICATION for  ML-BRU-CRF-072[Inc:29938]
				//newly added for RUT-CRF-0067 --start
				printList.add(noOfPrints);
				if(sCalledFrom!=null && sCalledFrom.equals("PRINT_DIALOG")){
					ext_drugData	=	(HashMap) prescriptionDetails.get(iCount-1);
				}else{
					ext_drugData	=	(HashMap) prescriptionDetails.get(recno);
				}
	//			for(int j=0;j<prescriptionDetails.size();j++){
				//	ext_drugData	=	(HashMap) prescriptionDetails.get(iCount-1);
					ext_drug_code	=	(String) ext_drugData.get("DRUG_CODE");
					ext_srl_no		=	(String) ext_drugData.get("SRL_NO");
					if( drug_code.equals(ext_drug_code) ){
					   ext_drugData.put("EDITLABEL",editLabel);
					   ext_drugData.put("DRUG_INDICATION",drug_indication);
					}
	//		    }
			}
			bean.setNoOfPrints(printList);// Code Added For RUT-CRF-0067
			if(sCalledFrom!=null && sCalledFrom.equals("PRINT_DIALOG")){

				String sComputeSetOrder	= request.getParameter("ComputeSetOrder");
				String sObjPrintSelectFrame = request.getParameter("PrintDialogFrame");
				bean.updateDTLValues();
				out.println("<script> ");
				if(sComputeSetOrder.equals("true")){
					out.println(sObjPrintSelectFrame+".recordButton.onclick();");
				}

				//out.println("printOnlineDispense("+sObjPrintSelectFrame+",'OK');");
				out.println("if("+sObjPrintSelectFrame+"!= undefined && "+sObjPrintSelectFrame+".printOK != null){");
				out.println(sObjPrintSelectFrame+".printOK.onclick();");
				out.println("}");
				//oBean.clearAlOrderLineDataForEditLables();
				out.println("</script>");
			}
			//newly added for RUT-CRF-0067 --end	
			out.println("<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
			out.println("<script>parent.window.returnValue='OK';window.close()</script>");
	}
	else if (func_mode !=null && func_mode.equals("setAmendDetails")){
		String code				 = ((String)hash.get("reason")).trim();
		String frmObj			 = (String)hash.get("frmObj");
		String appl_trn_type	 = ((String)hash.get("appl_trn_type")).trim();
		String remarks			 = bean.getRemarks(code,appl_trn_type);	
		if(remarks!= null && !remarks.equals("")){
			remarks=remarks.replaceAll(" ","%20");
			remarks = java.net.URLEncoder.encode(remarks,"UTF-8");
			remarks=remarks.replaceAll("%2520","%20");
		}
		out.println("assignRemarksValue('"+remarks+"');");
	}
	else if(func_mode!= null &&( func_mode.equals("filling")||func_mode.equals("cancel"))) {  
			
		String reason					= (String) hash.get( "reason" );
		String remarks					= (String) hash.get( "remarks" );
		//String recno					= (String) hash.get( "recno" );
		String drug_code				= (String) hash.get( "drug_code" );
		String chk						= ((String)hash.get( "chk" )).trim();
		String srl_no					= (String) hash.get("srl_no");
		String ext_drug_code			= "";
		String ext_srl_no			    = "";
		//String ret_val					="OK";
		HashMap ext_drugData	        = null;
		HashMap del_remarks				= new HashMap();
		if(remarks!=null && !remarks.equals("")){
			remarks = java.net.URLDecoder.decode(remarks,"UTF-8");
		}
		if(chk.equals("D")){				
			 ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			 for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData	=	(HashMap) prescriptionDetails.get(j);
				ext_drug_code	=	(String) ext_drugData.get("DRUG_CODE");
				ext_srl_no		=	(String) ext_drugData.get("SRL_NO");
					
				if( drug_code.equals(ext_drug_code) && srl_no.equals(ext_srl_no) ){
					if(func_mode.equals("filling")){
					   ext_drugData.put("FILLING_REASON",reason);
					   ext_drugData.put("FILLING_REMARKS",remarks);
					   del_remarks.put("FILLING_REASON",reason);
					   del_remarks.put("FILLING_REMARKS",remarks);
					   ext_drugData.put("DELIVERY_REMARKS",del_remarks);
					}
					else if(func_mode.equals("cancel")){
					   ext_drugData.put("FILLING_REASON","");
					   ext_drugData.put("FILLING_REMARKS","");
					   del_remarks.put("FILLING_REASON","");
					   del_remarks.put("FILLING_REMARKS","");
					   ext_drugData.put("DELIVERY_REMARKS","");								
					}
				}
			}
		}
	}
	else if(func_mode != null && func_mode.equals("saveRemarks")){
		String remarks	= (String) hash.get( "remarks" );
		bean.savePresRemarks(remarks);
	}
	else if(func_mode != null && func_mode.equals("InsertDispenseDetails")){
		HashMap ext_drugData	      = null;
		String Complete_Order_yn      = null;
		String deliver_yn			  = null;
		String pat_couns_reqd_yn	  = null;

		String issue_uom	          = null;
		String issue_uom_qty	      = null;
		int count =0;
		 ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
		for(int j=0;j<prescriptionDetails.size();){
			Complete_Order_yn    = "N";
			 deliver_yn		   = "N";
			pat_couns_reqd_yn	   = "N";

			ext_drugData	=	(HashMap) prescriptionDetails.get(j);
			if(ext_drugData.size()>0){
				Complete_Order_yn       =    (String)hash.get("Complete_Order_"+count);
				if( Complete_Order_yn==null || Complete_Order_yn.equals("")){
					Complete_Order_yn  = "N";
				}
				if(Complete_Order_yn.equals("Y")){
					ext_drugData.put("ORDER_STATUS","58");
				}
				ext_drugData.put("COMPLETE_ORDER_YN",Complete_Order_yn);

				pat_couns_reqd_yn  =   (String)hash.get("pat_reqd_"+count);
				if( pat_couns_reqd_yn==null || pat_couns_reqd_yn.equals("")){
					pat_couns_reqd_yn   = "N";
				}
				ext_drugData.put("PAT_COUNS_REQD_YN",pat_couns_reqd_yn);

				deliver_yn  =   (String)hash.get("del_detail_"+count);
				if( deliver_yn==null || deliver_yn.equals("") ){
					deliver_yn      = "N";
				}
				ext_drugData.put("DELIVER_ORDER_YN",deliver_yn);
				issue_uom     = (String)hash.get("issue_uom_"+count);
				ext_drugData.put("ISSUE_UOM",issue_uom);							  
				issue_uom_qty = (String)hash.get("issue_qty_"+count);
				ext_drugData.put("ISSUE_UOM_QTY",issue_uom_qty);							  

				if(deliver_yn.equals("N")){
					ext_drugData.put("ORDER_STATUS","10");                                  
					prescriptionDetails.remove(j);
				}
				else{
					j++;
				}	  
				count++;
			}                          
		}
	}
	else if(func_mode != null && func_mode.equals("formGrouping")){
	   patient_id		= (String)hash.get("patient_id");
	   encounter_id		= (String)hash.get("encounter_id");
	   if(encounter_id==null){
			encounter_id="";
	   }
		String record_gen		=	"";
		String priority			=	"";
		String home_medication	=	"";
		String consent_reqd_yn	=	"";
		patient_class	= (String) hash.get( "patient_class" );
		priority			= (String) hash.get( "priority" );
		home_medication	= (String) hash.get( "take_home_medication" );
		String allergic_yn		= (String) hash.get( "allergic_yn" );
		String language_id		= (String) hash.get( "language_id" );
		String DrugIndicationRemarks            = (String) hash.get("DrugIndicationRemarks")==null?"":(String)hash.get("DrugIndicationRemarks");//Added for  ML-BRU-CRF-072[Inc:29938]
		if(!DrugIndicationRemarks.equals(""))
			DrugIndicationRemarks = java.net.URLDecoder.decode(DrugIndicationRemarks,"UTF-8");//Added for  ML-BRU-CRF-072[Inc:29938]
		String or_bean_name		="eOR.OrderEntryBean";
		String or_bean_id		="@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean   = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
	
		ArrayList uniqueCode		= new ArrayList();
		HashMap prevDates			= new HashMap();
		ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
		ArrayList duplicate_list	=	new ArrayList();
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
		String drug_start_date		=	"N";
		String drug_end_date		=	"N";
		String last_refill_durn_value="";//Added for IN:069886
		String last_refill_freq_chnage_durn_value="";//Added for IN:069886
		for(int n=0; n<prescriptionDetails.size(); n++){
			ext_drugData=(HashMap) prescriptionDetails.get(n);
			refill_detail	=	bean.getRefillDetail(((String) ext_drugData.get("SRL_NO")));

			if(refill_detail.size()!=0) {
				st_date	=(ArrayList)refill_detail.get("refill_start_date");
				en_date	=(ArrayList)refill_detail.get("refill_end_date");
				ext_drugData.put("REFILL_START_DATE","");
				ext_drugData.put("REFILL_END_DATE","");
				last_refill_durn_value = (String)refill_detail.get("last_refill_durn_value");//Added for IN:069886
				last_refill_freq_chnage_durn_value = (String)refill_detail.get("last_refill_freq_chnage_durn_value");//Added for IN:069886
				for(int y=0; y<st_date.size(); y++) {
					duplicate	=	new HashMap();
					start_date	=	(String)st_date.get(y);
					end_date	=	(String)en_date.get(y);
					duplicate	=	(HashMap)ext_drugData.clone();
					start_date  = com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",language_id,"en");
					end_date    = com.ehis.util.DateUtils.convertDate(end_date,"DMYHM",language_id,"en");
					duplicate.put("REFILL_START_DATE",start_date);
					duplicate.put("REFILL_END_DATE",end_date);
					duplicate.put("CHILD_ORDER_YN","Y");
					//Added for IN:069886 start
					if(y==(st_date.size()-1) && last_refill_durn_value!=null){
						duplicate.put("DURN_VALUE",last_refill_durn_value);
						duplicate.put("freq_chng_durn_value",last_refill_freq_chnage_durn_value);
					}
					//Added for IN:069886 end
					duplicate.put("TOT_ALLOC_QTY","0");
					duplicate.put("ORDER_STATUS","10");  
					duplicate.put("DELIVER_ORDER_YN","N"); 		
					duplicate.remove("BATCH_DETAILS");
					duplicate.put("ALLOC_BMS_QTY",(String) ext_drugData.get("ORD_QTY"));
					duplicate_list.add(duplicate);
				}
			}
		}

		for(int p=0; p<duplicate_list.size(); p++) {
			prescriptionDetails.add((HashMap)duplicate_list.get(p));
		}

		for(int j=0;j<prescriptionDetails.size();j++){
			ext_drugData=(HashMap) prescriptionDetails.get(j);
			drug_code			=(String) ext_drugData.get("DRUG_CODE");
			ph_order_type		=(String) ext_drugData.get("ORDER_TYPE_CODE")==null?"":(String) ext_drugData.get("ORDER_TYPE_CODE");
			approval_yn_val		=(String) ext_drugData.get("APPROVAL_YN_VAL")==null?"":(String) ext_drugData.get("APPROVAL_YN_VAL");
			auth_yn_val			=(String) ext_drugData.get("AUTH_YN_VAL")==null?"":(String) ext_drugData.get("AUTH_YN_VAL");
			refill_start_date	=(String) ext_drugData.get("REFILL_START_DATE")==null?"":(String) ext_drugData.get("REFILL_START_DATE");
			refill_end_date		=(String) ext_drugData.get("REFILL_END_DATE")==null?"":(String) ext_drugData.get("REFILL_END_DATE");
			disp_code           = bean.getOrdLocn();     

			if(	ext_drugData.get("PRIORITY") == null) {
				priority		=	"R";
			} 
			else {
				priority			= (String) ext_drugData.get("PRIORITY");
			}
			
			ext_drugData.put("DISP_LOCN_CODE",disp_code);			

			 drug_start_date = "N";
			 drug_end_date   = "N";

			if(!uniqueCode.contains(drug_code)){
				drug_start_date=(String) ext_drugData.get("START_DATE");
				if(drug_start_date==null) {
					 //ext_drugData.put("START_DATE",com.ehis.util.DateUtils.convertDate((String) ext_drugData.get("START_DATE_TIME"),"DMYHM",language_id,"en"));
					 drug_start_date=(String) ext_drugData.get("START_DATE_TIME");
				}
				drug_end_date=(String) ext_drugData.get("END_DATE");
				if(drug_end_date==null) {
					//ext_drugData.put("START_DATE",com.ehis.util.DateUtils.convertDate(drug_end_date=(String) ext_drugData.get("END_DATE_TIME"),"DMYHM",language_id,"en"));
					 drug_end_date=(String) ext_drugData.get("END_DATE_TIME");
				}
				record_gen=priority+ph_order_type+approval_yn_val+auth_yn_val+drug_start_date+refill_start_date+refill_end_date+disp_code;
				prevDates.put(drug_code,drug_start_date);
			}
			else{
				refill_detail	=	bean.getRefillDetail(((String) ext_drugData.get("SRL_NO")));
				if(refill_detail.size()!=0) {
					ext_drugData.put("START_DATE",refill_start_date);
					ext_drugData.put("END_DATE",refill_end_date);
				}
				String date_val=(String)prevDates.get(drug_code);	
				record_gen=priority+ph_order_type+approval_yn_val+auth_yn_val+date_val+refill_start_date+refill_end_date+disp_code;

			}
//			out.println("alert(\"record_gen" + record_gen + "\");") ;
			ext_drugData.put("RECORD_GEN",record_gen);

			uniqueCode.add(drug_code);
		}
		ArrayList groupRecord=(ArrayList)bean.groupingOrder(patient_class);
		int groupSize=groupRecord.size();
		//generating order id
		//code added for External Prescription...
		ArrayList OrderID = (ArrayList)bean.genOrderID(groupSize,patient_class);
//for generating order details
		//out.println("alert('success')"+);
		bean.genOrderDetails();
//generating order details
		ArrayList OrderDetails =(ArrayList) bean.getOrderDetails();			

		ArrayList OrderHeader	=	new ArrayList();
		ArrayList tmp_order_id	=	new ArrayList();
		String parent_order_id	=	"";
		boolean firstTime		=	true;
		HashMap presHeader		=	null;
		ArrayList HeaderArr		=	null;        
		HashMap presDetails		=	null;
		String order_type_code	=	null;
		String ord_auth_reqd_yn	=	null;
		String ord_auth_level	=	null; 			                        
		String ord_appr_reqd_yn	=	null;
		String ord_cosign_reqd_yn	=	null;
		String med_admin_reqd_yn	=	null;

		for(int j=0;j<OrderID.size();j++){

			presHeader  = new HashMap();
			HeaderArr= new ArrayList();

			HeaderArr			= (ArrayList) OrderDetails.get(j);
			presDetails = new HashMap();
			presDetails = (HashMap) HeaderArr.get(0);
			String order_id			= (String) OrderID.get(j);
			tmp_order_id.add(order_id);
			if(!presDetails.containsKey("CHILD_ORDER_YN")){
				firstTime		=	true;
			}
			//out.println("alert('"+(HashMap)presDetails.get("SEL_BATCHES")+"')");
			order_type_code	= (String) presDetails.get("ORDER_TYPE_CODE");
			ord_auth_reqd_yn = (String) presDetails.get("AUTH_YN_VAL");
			ord_auth_level = (String) presDetails.get("ORD_AUTH_LEVEL");
			ord_appr_reqd_yn = (String) presDetails.get("APPROVAL_YN_VAL");
			ord_cosign_reqd_yn = (String) presDetails.get("ORD_SPL_APPR_REQD_YN");
			consent_reqd_yn=(String) presDetails.get("CONSENT_REQD_YN");
			med_admin_reqd_yn=(String) presDetails.get("MED_ADMIN_REQD_YN");
			presHeader.put("ORDER_ID", order_id );
			presHeader.put("MED_ADMIN_REQD_YN", med_admin_reqd_yn );
			presHeader.put("ORDER_TYPE_CODE", order_type_code );
			presHeader.put("FACILITY_ID",(String) hash.get( "facility_id" ));
			presHeader.put("PATIENT_ID",(String) hash.get( "patient_id" ));
			presHeader.put("ENCOUNTER_ID",(String) hash.get( "encounter_id" ));
			presHeader.put("HEIGHT",(String) hash.get( "height" ));
			presHeader.put("WEIGHT",(String) hash.get( "weight" ));
			presHeader.put("BSA",(String) hash.get( "bsa" ));
			presHeader.put("BMI",(String) hash.get( "bmi" ));
			presHeader.put("HEIGHT_UNIT",(String) hash.get( "height_unit" ));
			presHeader.put("WEIGHT_UNIT",(String) hash.get( "weight_unit" ));
			presHeader.put("BSA_UNIT",(String) hash.get( "bsa_unit" ));
			presHeader.put("PRIORITY",(String) hash.get( "priority" ));
			presHeader.put("ORDER_DATE_TIME",com.ehis.util.DateUtils.convertDate((String) hash.get( "order_date_time" ),"DMYHM",language_id,"en"));
			presHeader.put("TAKE_HOME_MEDICATION",(String) hash.get( "take_home_medication" ));
			presHeader.put("PATIENT_CLASS",(String) hash.get( "patient_class" ));
			presHeader.put("SOURCE_TYPE",(String) hash.get( "source_type" ));
			presHeader.put("SOURCE_CODE",(String) hash.get( "source_code" ));
			presHeader.put("LOCN_CODE",(String) hash.get( "source_code" ));
			presHeader.put("LOCN_TYPE",(String) hash.get( "source_type" ));
			presHeader.put("DISP_LOCN_CODE",bean.getDispLocnCode());		
			presHeader.put("ALLERGIC_YN",allergic_yn);
			presHeader.put("PATIENT_NAME", java.net.URLDecoder.decode((String)hash.get( "patient_name" ),"UTF-8"));

			presHeader.put("DELIVER_ORDER_YN",(String) presDetails.get("DELIVER_ORDER_YN")  );
			presHeader.put("DRUG_INDICATION",DrugIndicationRemarks);//Added for  ML-BRU-CRF-072[Inc:29938]


			if( home_medication.equals("Y") ){
				presHeader.put("DISCHARGE_IND","D");
			}
			else{
				presHeader.put("DISCHARGE_IND","");
			}

			presHeader.put("ATTEND_PRACT_ID",(String) hash.get( "attend_pract_id" ));
			presHeader.put("ORD_PRACT_ID",bean.getPractionerID());//Replaced (String) hash.get( ord_pract_id ) with bean.getPractionerID() for INC#048044
			presHeader.put("ORD_AUTH_REQD_YN",ord_auth_reqd_yn);
			presHeader.put("ORD_AUTH_LEVEL",ord_auth_level);
			presHeader.put("ORD_APPR_REQD_YN",ord_appr_reqd_yn);
			presHeader.put("ORD_COSIGN_REQD_YN",ord_cosign_reqd_yn);
			presHeader.put("ORD_COSIGN_REQD_YN",ord_cosign_reqd_yn);
			presHeader.put("CONSENT_REQD_YN",consent_reqd_yn);
			presHeader.put("BROUGHT_BY_PAT",(String) presDetails.get( "BROUGHT_BY_PAT" ));


			if( ( presDetails.containsKey("CHILD_ORDER_YN")) ){
					presHeader.put("CONT_ORDER_IND","CR");
			}else{
					presHeader.put("CONT_ORDER_IND","CO");
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
			presHeader.put("ORDER_STATUS","10");
			OrderHeader.add(presHeader);
		}
		bean.setpresHeader(OrderHeader);
		OrderHeader=(ArrayList) bean.getpresHeader();
		ArrayList order_ids=(ArrayList)bean.getOrderID();
		if(order_ids.size()>0){
		   out.println("showRecords()");
		}
		else{
		   out.println("showMessage()");
		}

	// objects nullified after usage
		putObjectInBean(or_bean_id,orbean,request);
		uniqueCode				=	null;
		prevDates				=	null;
		prescriptionDetails		=	null;
		duplicate_list			=	null;
		ext_drugData			=	null;
		refill_detail			=	null;
		groupRecord				=	null;
		OrderID					=	null;
		OrderDetails			=	null;
		OrderHeader				=	null;
		tmp_order_id			=	null;
		st_date					=	null;
		en_date					=	null;
		duplicate				=	null;
		orbean					=	null;
	}
	else if (func_mode !=null && func_mode.equals("CHECKBMS")) {
	    ArrayList prescriptionDetails   = (ArrayList)bean.getpresDetails();
		String alloc_bms_qty			=   "";
		String  flag					=   "N";
		String label_format				=	"";
		String bal_sheet				=	"";
		String disp_sheet				=	"";
		String complete_order_yn        =   "N";
		String child_order_yn           =   "";
		String Disp_label_yn            =   "N";
		String med_plan				=   " ";//Added for  ML-BRU-CRF-072[Inc:29938]
		HashMap ext_drugData			=	null;
		//HashMap	print_line				=	null;
		ArrayList disp_nos              =   null;
		int count						=   0;
		ArrayList order_ids				=  (ArrayList)bean.getOrderID();
		String disp_locn				=   bean.getDispLocnCode();
		patient_class					=   bean.getPatientClass();	
		HashMap print_line				=   bean.getReqdPrintReports(disp_locn,order_ids,patient_class);
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData	    =	(HashMap) prescriptionDetails.get(j);
				alloc_bms_qty       =   "";		
				complete_order_yn   =   "";

                alloc_bms_qty       =  (String) ext_drugData.get("ALLOC_BMS_QTY");
				complete_order_yn   =  (String) ext_drugData.get("COMPLETE_ORDER_YN");
				if(ext_drugData.containsKey("CHILD_ORDER_YN")){
				   child_order_yn      =  (String) ext_drugData.get("CHILD_ORDER_YN");
				}else{
					child_order_yn           =   "N";
				}
				  
				  
				  if(!alloc_bms_qty.equals("0")&& !alloc_bms_qty.equals("0.0")&& !alloc_bms_qty.equals("")&& alloc_bms_qty!=null&&complete_order_yn.equals("N")&&child_order_yn.equals("N")){
                      count=count+1;
				  }
                 if(count>0){					  
					  flag="Y";
					  break;
				  } 
			}
			 if(print_line.size()>0){
				label_format			=	(String)print_line.get("label_format");
				bal_sheet				=	(String)print_line.get("bal_sheet");
				disp_sheet				=	(String)print_line.get("disp_sheet");	
				Disp_label_yn			=	(String)print_line.get("Disp_label_yn");	
				med_plan				=	(String)print_line.get("med_plan");//Added for  ML-BRU-CRF-072[Inc:29938]	
				disp_nos				=	(ArrayList)print_line.get("disp_no");	
				bean.setDispNos(disp_nos);
			 }
				
			String login_user		    =	(String)session.getValue("login_user");
			String facility_id		    =	(String)session.getValue("facility_id");
         
			String billing_interface_yn = bean.checkforbillinginterface();
			String encounterId	= 	bean.getEncounterID();// Added for HSA-CRF-0113 [IN:048166] 
			if(billing_interface_yn.equals("Y")){
				 String disp_cash_coll_stage = bean.getDispCashCollStage();
		         	String bl_det               = bean.getBLDetails();
		         	String token_no             = bean.getTokenNo();
				out.println("showPrintDialog('"+flag+"','"+label_format+"','"+bal_sheet+"','"+disp_sheet+"','"+login_user+"','"+facility_id+"','"+billing_interface_yn+"','"+Disp_label_yn+"','"+med_plan+"','"+disp_cash_coll_stage+"','"+bl_det+"','"+token_no+"','"+disp_locn+"','"+encounterId+"');");//Added med_plan  for  ML-BRU-CRF-072[Inc:29938]// Added encounterId for HSA-CRF-0113 [IN:048166] 
			}
			else{
               			out.println("showPrintDialog('"+flag+"','"+label_format+"','"+bal_sheet+"','"+disp_sheet+"','"+login_user+"','"+facility_id+"','N','"+Disp_label_yn+"','"+med_plan+"','"+encounterId+"');");//Added med_plan  for  ML-BRU-CRF-072[Inc:29938]// Added encounterId for HSA-CRF-0113 [IN:048166]
			}
		}
		else if(func_mode.equals("orOrder")) {
			String	order_id				=	(String) hash.get("order_id");
			String	order_line_no			=	(String) hash.get("order_line_no");
			
			String	disp_no					=	"";
			String	srl_no					=	(String) hash.get("srl_no");
			String	next_collection_date	=	(String) hash.get("next_collection_date");
			String	bmsReasonCode	=	(String) hash.get("bmsReasonCode");
			String	referral_facility	="";
			String	referral_remarks	="";
					practioner_id		="";
			String	disp_location		="";

			String	flag					=	(String) hash.get("flag");
			 if(flag.equals("E")){	
					referral_facility	=	(String) hash.get("referral_facility");
					referral_remarks	=	(String) hash.get("referral_remarks");
					practioner_id		=	(String) hash.get("practioner_id");
			 }
			 else if(flag.equals("C")){				
					disp_location		=	(String) hash.get("disp_location");
			 }

			HashMap values	= new HashMap();
			values.put("order_id" , order_id);
			values.put("order_line_no" , order_line_no);							
			values.put("disp_no" , disp_no);
			values.put("srl_no" , srl_no);
			values.put("next_collection_date" , next_collection_date);
			values.put("bmsReasonCode" , bmsReasonCode);
			values.put("flag" , flag);
			if(flag.equals("E")){
				values.put("referral_facility" , referral_facility);				
				values.put("referral_remarks" , referral_remarks);
				values.put("practioner_id" , practioner_id);		 
			}
			else if(flag.equals("C")){
				values.put("ReRtdDispLocnCode" , disp_location);
			}
			HashMap result = bean.callinsertNextCollDate(values);
		}
		else if(func_mode.equals("print_dispense")){
			String  language_id		    =   (String)session.getAttribute("LOCALE");
			String	login_user			=	(String) hash.get("login_user");
			String	facility_id			=	(String) hash.get("facility_id");
					patient_id			=	(String) hash.get("patient_id");
			String	locn_code			=	(String) hash.get("locn_code");
					patient_class		=	(String) hash.get("patient_class");
			String  dflt_lang_for_disp_label = (String) hash.get("select_loc_lang");
			String bms_sel_lang			= (String) hash.get("bms_sel_lang");   //newly added by manickam for CRF-0074
			String  print_extr_pres		=	(String) hash.get("print_extr_pres");
			String	print_disp_sheet_yn	=	(String) hash.get("print_disp_sheet_yn");
			String	print_bal_sheet_yn	=	(String) hash.get("print_bal_sheet_yn");
			String	print_disp_label_yn	=	(String) hash.get("print_disp_label_yn");
			String med_plan_sheet_yn    =   (String) hash.get("med_plan_sheet_yn");//Added for  ML-BRU-CRF-072[Inc:29938]
			String  print_pres_yn		=	(String) hash.get("print_pres_yn");
			String ReportOutput			=	"";
			String	report_id			=	"";					
			ArrayList disp_nos			=	null;
					 disp_nos			=	bean.getDispNos();
			ArrayList print_reports		=	new ArrayList();
			ArrayList order_ids			=  (ArrayList)bean.getOrderID();

			String sm_local_language_id     = bean.getSMLOcalLanguageID();

			if(patient_class.equals("EM"))
				patient_class="OP";
			if(print_disp_sheet_yn.equals("Y")){
				print_reports.add("PHPRDISSH"); //DISPENS SHEET
			}

			if(print_bal_sheet_yn.equals("Y")){
			   print_reports.add("PHPRBALMS");	//BALANCE MEDICATION SHEET	
			}

			if(print_disp_label_yn.equals("Y")){  //DISPENSE LABEL

				if(patient_class.equals("IP") ){
					print_reports.add("PHPRDISLB_AL_IP");
				}
				else if(((patient_class.equals("OP"))||(patient_class.equals("XT"))) ){
					print_reports.add("PHPRDISLB_AL_OP");
				}
				/*else if(patient_class.equals("IP") && dflt_lang_for_disp_label.equals("L")){
					print_reports.add("PHPRDISLB_AL_IP_ARA");
				}else if(((patient_class.equals("OP"))||(patient_class.equals("XT")) )&& dflt_lang_for_disp_label.equals("L")){
					print_reports.add("PHPRDISLB_AL_OP_ARA");
				}else if(((patient_class.equals("OP"))||(patient_class.equals("XT")) )&& dflt_lang_for_disp_label.equals("B")){	
					print_reports.add("PHPRDISLBOPEA");	
				}
				*/
			}
			//Newly Added   For ML-BRU-CRF-072[Inc:29938
			if(med_plan_sheet_yn.equals("Y")){
			   print_reports.add("PHPRMEDPL");	//MEDICATION PLAN SHEET	
			}
			
			/*if(patient_class.equals("XT")){
				 print_reports.add("PHBOPPEX");
			}else{*/
			if(print_pres_yn.equals("Y")){
				 print_reports.add("PHBOPPRS");
			}
			/*}*/
		 
			if(print_extr_pres.equals("Y")){
					print_reports.add("PHREFLTR");  //REFERAL LETTER
			}
	
			ecis.utils.OnlineReports onlineReports		=	null;
			ecis.utils.OnlineReport report1				=	null;
			if(disp_nos.size()>0) {
				ArrayList noOfPrints = bean.getNoOfPrints();  //newly added for RUT-CRF-0067 -- start
				ArrayList disp_srl_no = new ArrayList();
				int printcountIndx=0;							//newly added for RUT-CRF-0067	--end
				if(print_reports.contains("PHPRDISSH") ){
					if(print_reports.contains("PHPRDISSH")) {
						report_id	=	"PHPRDISSH";
					}
							
					String fm_disp_no	= (String)disp_nos.get(0);
					String to_disp_no	= (String)disp_nos.get( (disp_nos.size()-1) );
					onlineReports 		= new ecis.utils.OnlineReports() ;
					report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;

					report1.addParameter("p_report_id",report_id) ;
					report1.addParameter("p_user_name",login_user) ;
					report1.addParameter("p_facility_id",facility_id) ;
					report1.addParameter("p_locn_code",locn_code);
					report1.addParameter("p_patient_id",patient_id) ;
					report1.addParameter("p_disp_fm_no",fm_disp_no);
					report1.addParameter("p_disp_to_no",to_disp_no);
					report1.addParameter("p_patient_class",patient_class);
					report1.addParameter("p_module_id", "PH") ;
					report1.addParameter("p_language_id",language_id) ;

					onlineReports.add( report1) ;
					ReportOutput = onlineReports.execute( request, response );
					if(print_reports.contains("PHPRDISSH")) {
						print_reports.remove("PHPRDISSH");
					} 
				}

				for(int k=0; k<disp_nos.size(); k++) {	
					for(int i=0; i<print_reports.size(); i++) {
						report_id		=	(String)print_reports.get(i);	
						disp_srl_no			=	(ArrayList)bean.getDispSrlNO((String)disp_nos.get(k));  //newly added for RUT-CRF-0067
						if(disp_srl_no.size()>0){   //newly added for CRF-0067
							int noPrint=1;		//newly added for CRF-0067
							if(report_id.equals("PHPRBALMS")){
								int count=bean.getBalanceMedicationcount((String)disp_nos.get(k));
								if(count>0){
									onlineReports 		= new ecis.utils.OnlineReports() ;
									report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
									report1.addParameter("p_report_id",report_id) ;
									report1.addParameter("p_user_name",login_user) ;
									report1.addParameter("p_facility_id",facility_id) ;
									report1.addParameter("p_locn_code","");//locn_code removed BSP-SCF-0027
									report1.addParameter("p_locncode",locn_code);//prescription
									report1.addParameter("p_patient_id",patient_id) ;
									report1.addParameter("p_disp_no",(String)disp_nos.get(k));
									report1.addParameter("p_patient_class",patient_class);
									report1.addParameter("p_patclass",patient_class);//prescription
									report1.addParameter("p_module_id", "PH") ;
									report1.addParameter("p_order_id",(String) order_ids.get(k)) ;	
	// if else condition is newly added for CRF-0075 by manickam
									if(!bms_sel_lang.equals("E")){ //changed dflt_lang_for_disp_label to bms_sel_lang for CRF-074 by manickam
										report1.addParameter("p_language_id",sm_local_language_id) ;
									}
									else{
									  report1.addParameter("p_language_id","en") ;
									}
									onlineReports.add( report1) ;					
									ReportOutput = onlineReports.execute( request, response );
								}
							}
							else{
								for(int n=0;n<disp_srl_no.size();n++){			//newly added for TUT-CRF-0067  -- start
									if(printcountIndx<noOfPrints.size()){
										noPrint = Integer.parseInt(noOfPrints.get(printcountIndx)==null?"1":(String) noOfPrints.get(printcountIndx));
										printcountIndx++;
									}
									for(int indxNoP=0; indxNoP<noPrint; indxNoP++){   //newly added for TUT-CRF-0067  --end
										onlineReports 		= new ecis.utils.OnlineReports() ;
										report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
										report1.addParameter("p_report_id",report_id) ;
										report1.addParameter("p_user_name",login_user) ;
										report1.addParameter("p_facility_id",facility_id) ;
										report1.addParameter("p_locn_code",locn_code);
										report1.addParameter("p_locncode",locn_code);//prescription
										report1.addParameter("p_patient_id",patient_id) ;
										report1.addParameter("p_disp_no",(String)disp_nos.get(k));
										report1.addParameter("p_srl_no",(String)disp_srl_no.get(n)); //Added for Multiple printing of DispLabels MMS
										report1.addParameter("p_patient_class",patient_class);
										report1.addParameter("p_patclass",patient_class);//prescription
										report1.addParameter("p_module_id", "PH") ;
										report1.addParameter("p_order_id",(String) order_ids.get(k)) ;	
										if(print_reports.contains("PHPRDISLB_AL_IP") || print_reports.contains("PHPRDISLB_AL_OP")  ){
											if(dflt_lang_for_disp_label.equals("L")){
												report1.addParameter("p_language_id",sm_local_language_id) ;
											}
											else{
											   report1.addParameter("p_language_id","en") ;
											}
										}
										else{
											report1.addParameter("p_language_id",language_id) ;
										}
										onlineReports.add( report1) ;					
										ReportOutput = onlineReports.execute( request, response );
									}
								}
							}
						}
					}
				}
			}
			//objects nullified after usage
			print_reports	=	null;
			bean.clear();
		}
		else if(func_mode.equals("ExternalDoseCheck")){
			String called_from					=	(String)hash.get("called_from");
			String external_prod_id             =	(String)hash.get("external_prod_id");
				   patient_id					=	(String)hash.get("patient_id");	  
			String weight						=	(String)hash.get("weight");				        
			String bsa							=	(String)hash.get("bsa");	
			String dosage						=	(String)hash.get("dose");
			String dosage_by					=	(String)hash.get("dosage_by");	
			String dose_uom						=	(String)hash.get("dose_uom");         
			String repeat_value					=	(String)hash.get("repeat_value");	
			if(repeat_value==null || repeat_value.equals("null"))
			repeat_value="1";
			String interval_value				=	(String)hash.get("interval_value");		
			if(interval_value==null || interval_value.equals("null"))
				interval_value="1";
			
			String duration					    =	(String)hash.get("durn_value");				
			String drug_code					=	(String)hash.get("drug_code");				
			String srl_no						=	(String)hash.get("srl_no");				
			String strength_per_pres_uom	    =	(String)hash.get("strength_per_pres_uom");	
			String strength_per_value_pres_uom	=	(String)hash.get("strength_per_value_pres_uom");	
			String fract_dose_round_up_yn		=	(String)hash.get("fract_dose_round_up_yn");		
			//String split_dose_yn				=	(String)hash.get("split_dose_yn");	
			String external_dosage_override_reason		=	(String)hash.get("external_dosage_override_reason");
			String route_code	= (String)hash.get("route_code")==null?"":(String) hash.get( "route_code" );// Added in January 2014 for CIMS dosage check -start
			String qty_desc_code= (String)hash.get("qty_desc_code")==null?"":(String) hash.get( "qty_desc_code" );
			String repeat_durn_type	= hash.get("repeat_durn_type")==null?"":(String) hash.get( "repeat_durn_type" );
			String freq_nature	= hash.get( "freq_nature" )==null?"":(String) hash.get( "freq_nature" );
			String freq_nature_pas = "I";	  //Added in January 2014, CIMS Dosage Check -end
			
			String drug_db_dose_check_flag		=   "N";
			String frequency					=   (int)Math.ceil( Integer.parseInt(repeat_value) / Integer.parseInt(interval_value))+"";
			String pract_name                   =   (String)hash.get("pract_name");

		   if(dosage_by != null && dosage_by.equals("S")){
				if(fract_dose_round_up_yn.equals("Y")){
					float unit_qty	 =  (float) Math.ceil(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom));	
					dosage			 =   unit_qty * Float.parseFloat(strength_per_value_pres_uom)+"";
				}
				else{
					dosage			 =  (Float.parseFloat(dosage)*Float.parseFloat(strength_per_value_pres_uom))+"";
					dosage			 =  (float)(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom))+"";
				}
				DecimalFormat dfTest =  new DecimalFormat("##.000");
				dosage				 =  dfTest.format(Double.parseDouble(dosage));
				dosage				 =	Math.ceil(Float.parseFloat(dosage))+"";
			}

			String ext_beanid   = "@ExternalProductLinkBean";
			String ext_beanname = "ePH.ExternalProductLinkBean";
			ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);
			HashMap drugDosageResult	= new HashMap();
			ArrayList dosageCheckParams = new ArrayList();
			dosageCheckParams.add(patient_id);
			dosageCheckParams.add(external_prod_id);
			dosageCheckParams.add(weight);
			dosageCheckParams.add(bsa);
			dosageCheckParams.add(dosage);
			if(ext_beanObj!=null && (ext_beanObj.getProdID()).equals("CIMS"))  // Added in January 2014 - DOSAGE Checks Added
				dosageCheckParams.add(qty_desc_code);	// Added in January 2014 - DOSAGE Checks Added
			else
				dosageCheckParams.add(dose_uom);
			dosageCheckParams.add(frequency);
			dosageCheckParams.add(duration);
			dosageCheckParams.add(route_code);	 // Added in January 2014 for CIMS-Dosage Checks -start
			dosageCheckParams.add(repeat_durn_type);	
			if(freq_nature!=null && !freq_nature.equals(""))
				 freq_nature_pas =  freq_nature;
			dosageCheckParams.add(freq_nature_pas);	 
			dosageCheckParams.add(interval_value);	 // Added in January 2014 for CIMS-Dosage Checks -end
			ArrayList reqChecks = new ArrayList();
			reqChecks.add("Y"); //Dosage Check 
			reqChecks.add("N"); //Duplicate Check
			reqChecks.add("N"); //DrugInteraction
			reqChecks.add("N"); //Contra Indication
			reqChecks.add("N"); //AllergyCheck
			HashMap drugDBCheckResult = ext_beanObj.getExternalDBChecks( reqChecks, external_prod_id, patient_id, "", null ,null, dosageCheckParams, "N","",""); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
			drug_db_dose_check_flag = "N";
			if(drugDBCheckResult != null && drugDBCheckResult.size() > 0){
				drugDosageResult = (HashMap)drugDBCheckResult.get("DOSECHECK");
				if(drugDosageResult != null && drugDosageResult.size() > 0){
					ext_beanObj.setDosageCheck(external_prod_id, srl_no,drugDosageResult);
					drug_db_dose_check_flag = "Y";
				}
			}
			if(drug_db_dose_check_flag.equals("N")){
				drugDosageResult =ext_beanObj.getDosageCheck(external_prod_id, srl_no);
				if(drugDosageResult != null && drugDosageResult.size()>0){
					ext_beanObj.removeDosageCheck(external_prod_id, srl_no);
				}
			}
			/*drugDosageResult = ext_beanObj.getDrugDosageCheck(dosageCheckParams);
			if(drugDosageResult != null && drugDosageResult.size() > 0){
				ext_beanObj.setDosageCheck(external_prod_id, srl_no,drugDosageResult);	
				drug_db_dose_check_flag="Y";
			}else{
				 HashMap ext_dosage_det =ext_beanObj.getDosageCheck(external_prod_id, srl_no);
				 if(ext_dosage_det != null && ext_dosage_det.size()>0){
					ext_beanObj.removeDosageCheck(external_prod_id, srl_no);
				 }
			}*/
			putObjectInBean(ext_beanid,ext_beanObj,request);
			ArrayList presDetails			= (ArrayList) bean.getpresDetails();
			HashMap  drugDetails			= new HashMap();
			String extdrugCode		="";
			String extsrlNo		="";
			if(presDetails!=null && presDetails.size()>0){
				for(int i=0;i<presDetails.size();i++){
					drugDetails				= (HashMap)presDetails.get(i);
					extdrugCode				= (String)drugDetails.get("DRUG_CODE");
					extsrlNo				= (String)drugDetails.get("SRL_NO");
					if(extdrugCode.equals(drug_code) && extsrlNo.equals(srl_no) ){					
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dose_check_flag);
					}
				}
			}
			if(!called_from.equals("ONLOAD")&& drug_db_dose_check_flag.equals("Y")){
			    out.println("callMedicationAlert('"+patient_id+"','"+external_prod_id+"','N','N','N','"+drug_db_dose_check_flag+"','"+external_dosage_override_reason+"','"+drug_code+"','"+srl_no+"','"+called_from+"','','','','"+pract_name+"','')");
			}
			else{
                out.println("setextdoseflag('"+drug_db_dose_check_flag+"')");
			}
		}
		else if(func_mode.equals("CheckForExternalOverrideReasons")){

			String drug_db_interact_check_flag			= "N";
			String drug_db_duptherapy_flag				= "N";
			String drug_db_contraind_check_flag			= "N";
			String drug_db_dosage_check_flag			= "N";
			String drug_db_alergy_check_flag			= "N";
			String external_dosage_override_reason		=   "";	
			String external_duplicate_override_reason	=   "";
			String external_interaction_override_reason	=   "";
			String external_contra_override_reason		=   ""; 
			String external_alergy_override_reason		=   ""; 
			String perform_external_database_checks		=	"";
			String current_rx							=	"";
			String currentrx_remarks					=	"";
			
			ArrayList presDetails						= (ArrayList) bean.getpresDetails();
			 HashMap  drugDetails						= new HashMap();
			 String proceed_yn							="Y";
			if(presDetails!=null && presDetails.size()>0){
			  
				for(int i=0;i<presDetails.size();i++){
					drugDetails				= (HashMap)presDetails.get(i);				

					drug_db_interact_check_flag			= (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN");
					drug_db_duptherapy_flag				= (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN");
					drug_db_contraind_check_flag		= (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN");	
					drug_db_dosage_check_flag			= (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");
					drug_db_alergy_check_flag			= (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_ALERGY_CHECK_YN");
					external_dosage_override_reason		= (String)drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");
					external_duplicate_override_reason	= (String)drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
					external_interaction_override_reason= (String)drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
					external_contra_override_reason		= (String)drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
					external_alergy_override_reason		= (String)drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
					perform_external_database_checks	= (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
					HashMap Sel_batches					= (HashMap)drugDetails.get("SEL_BATCHES");
					current_rx							= (String)drugDetails.get("CURRENT_RX");
					currentrx_remarks					= (String)drugDetails.get("CURRENTRX_REMARKS");
					if(Sel_batches.size()==0){
						proceed_yn="M";
						//out.println("alertSelectBatch();");
						break;
					}					

                    if(perform_external_database_checks.equals("Y")){
                       if(drug_db_interact_check_flag.equals("Y") && external_interaction_override_reason.equals("")){
							proceed_yn="N";
							break;
					   }
					   if(drug_db_duptherapy_flag.equals("Y") && external_duplicate_override_reason.equals("")){
							proceed_yn="N";
							break;
					   }
					   if(drug_db_contraind_check_flag.equals("Y") && external_contra_override_reason.equals("")){
							proceed_yn="N";
							break;
					   }
					   if(drug_db_dosage_check_flag.equals("Y")&& external_dosage_override_reason.equals("")){
							proceed_yn="N";
							break;
					   }
					}
					else{
						if(current_rx!=null && !(current_rx.equals("")) && current_rx.equals("Y")){
							if(currentrx_remarks!=null && currentrx_remarks.equals("")){
								proceed_yn="N";
								break;
							}
						}
					}					
				}
              out.println("insertdetails('"+proceed_yn+"')");

			}
		}
		else if(func_mode.equals("StoreBillingDetails")){

            String drug_code						 =	(String)hash.get("drug_code");				
		    String srl_no							 =	(String)hash.get("Srl_no");				
		    String excl_incl_ind					 =	(String)hash.get("excl_incl_ind");				
			String bl_incl_excl_override_reason_code =	(String)hash.get("bl_incl_excl_override_reason_code");		
			String bl_incl_excl_override_reason_desc =	java.net.URLDecoder.decode(((String) hash.get( "bl_incl_excl_override_reason_desc" )),"UTF-8");

					patient_id						 =	(String)hash.get("patient_id");				
				    encounter_id					 =	(String)hash.get("encounter_id");				
		    String sal_trn_type						 =	(String)hash.get("sal_trn_type");				
			String sysdate							 =	(String)hash.get("sysdate");	
			String store_code						 =	(String)hash.get("store_code");	
			String tot_alloc_qty					 =  (String)hash.get("tot_alloc_qty");
			String batch_str						 =  (String)hash.get("batch_str");

            ArrayList prescriptionDetails   = (ArrayList)bean.getpresDetails();
			HashMap ext_drugData		    = new HashMap();
			String ext_drug_code		    = "";
			String ext_srl_no			    = "";
			String item_code			    = "";
			String gross_charge_amount      = "";
			String gross_charge_amount_payable      = "";
			String groos_pat_payable        = "";
			float tot_gross_charge_amount   = 0;
			float tot_groos_pat_payable     = 0;
			float tot_gross_charge_amount_payable   = 0;
			String tot_gross_charge_amount_str   = "";
			String tot_gross_charge_amount_payable_str   = "";
			String tot_groos_pat_payable_str     = "";
			boolean calculate_total         = false;
			String decimalFormatString	    = "";

			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData	=	(HashMap) prescriptionDetails.get(j);
				ext_drug_code	=	(String) ext_drugData.get("DRUG_CODE");
				ext_srl_no		=	(String) ext_drugData.get("SRL_NO");

				if( drug_code.equals(ext_drug_code) && srl_no.equals(ext_srl_no) ){
                    item_code   =  (String) ext_drugData.get("ITEM_CODE");
					ext_drugData.put("EXCL_INCL_IND",excl_incl_ind);
				    ext_drugData.put("BL_INCL_EXCL_OVERRIDE_REASON_CODE",bl_incl_excl_override_reason_code);
				    ext_drugData.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC",bl_incl_excl_override_reason_desc);
					HashMap chareg_det=(HashMap)bean.callItemChargeDtls(patient_id,encounter_id,sal_trn_type,item_code,Integer.parseInt(tot_alloc_qty), batch_str,sysdate,store_code,excl_incl_ind,bl_incl_excl_override_reason_code,"","","");
					if(chareg_det.get("error_msg").equals("")){
						decimalFormatString=(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
						/*if(!chareg_det.get("grosschargeamt").equals("null")){
							gross_charge_amount= (String)chareg_det.get("grosschargeamt");
						}*/ //Commented for ML-BRU-SCF-0368 [IN:034748]
						if(!chareg_det.get("patnetamt").equals("null")){
							groos_pat_payable  = (String)chareg_det.get("patnetamt");
						}
						if(!chareg_det.get("netchargeamt").equals("null")){
							//groos_pat_payable  = (String)chareg_det.get("netchargeamt");
							gross_charge_amount= (String)chareg_det.get("netchargeamt"); //Added for ML-BRU-SCF-0368 [IN:034748]
						}
						if(!chareg_det.get("grosschargeamt").equals("null")){
							//groos_pat_payable  = (String)chareg_det.get("netchargeamt");
							gross_charge_amount_payable= (String)chareg_det.get("grosschargeamt"); //Added for ML-BRU-SCF-0368 [IN:034748]
						}
                        ext_drugData.put("GROSS_CHARGE_AMOUNT",gross_charge_amount);
                        ext_drugData.put("GROOS_PAT_PAYABLE",groos_pat_payable);
                        ext_drugData.put("GROSS_CHARGE_AMOUNT_PAYABLE",gross_charge_amount_payable);
						out.println("setBillingAmounts('"+srl_no+"','"+gross_charge_amount+"','"+groos_pat_payable+"','"+gross_charge_amount_payable+"')");
						calculate_total =true;
                        break;
					   
					}					
				}               
			}
             if(calculate_total){
				 for(int j=0;j<prescriptionDetails.size();j++){
				     ext_drugData	=	(HashMap) prescriptionDetails.get(j);                  
					 if(ext_drugData.containsKey("GROSS_CHARGE_AMOUNT")){ 
							 tot_gross_charge_amount = tot_gross_charge_amount +Float.parseFloat((String)ext_drugData.get("GROSS_CHARGE_AMOUNT"));
					 }
					 if(ext_drugData.containsKey("GROOS_PAT_PAYABLE")){ 
							 tot_groos_pat_payable   = tot_groos_pat_payable +Float.parseFloat((String)ext_drugData.get("GROOS_PAT_PAYABLE"));
					 }
					 if(ext_drugData.containsKey("GROSS_CHARGE_AMOUNT_PAYABLE")){ 
						 tot_gross_charge_amount_payable = tot_gross_charge_amount_payable +Float.parseFloat((String)ext_drugData.get("GROSS_CHARGE_AMOUNT_PAYABLE"));
				 }
				}
                DecimalFormat dfTest    = new DecimalFormat(decimalFormatString);
				tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amount);
				tot_groos_pat_payable_str   = dfTest.format(tot_groos_pat_payable);
				tot_gross_charge_amount_payable_str = dfTest.format(tot_gross_charge_amount_payable_str);
				out.println("setBillingTotalAmounts('"+tot_gross_charge_amount_str+"','"+tot_groos_pat_payable_str+"','"+tot_gross_charge_amount_payable_str+"')");
			}
		}
		else if(identity.equals("SetItemDetails")){
	
			String all_stages_bean_id				 =  (String)hash1.get("all_stages_bean_id");
			String all_stages_bean_name				 =  (String)hash1.get("all_stages_bean_name");
		    String itemCodes	= (String) hash1.get( "itemCodes" )==null?"":(String) hash1.get( "itemCodes" );
			String tradeCodes	= (String) hash1.get( "tradeCodes" )==null?"":(String) hash1.get( "tradeCodes" );
			String tradeNames	= (String) hash1.get( "tradeNames" )==null?"":(String) hash1.get( "tradeNames" );
			String bl_install_yn		= (String) hash1.get( "bl_install_yn" )==null?"":(String) hash1.get( "bl_install_yn" );
			String take_home_medication	= (String) hash1.get( "take_home_medication" )==null?"":(String) hash1.get( "take_home_medication" );
			String priority	= (String) hash1.get( "priority" )==null?"":(String) hash1.get( "priority" );
			String count	= (String) hash1.get( "count" )==null?"0":(String) hash1.get( "count" );
			String tradeCodesArr[] = tradeCodes.split(",");
			String tradeNamesArr[] = tradeNames.split(",");
			String item_code="";
			String item_desc="";
			String trade_code="";
			String trade_name="";
			int trade_count=0;
			itemCodes = itemCodes.replace('[',' ');
			itemCodes = itemCodes.replace(']',' ');
			StringTokenizer stTtemCodes = new StringTokenizer(itemCodes.trim(),",");
			DirectDispensingBean all_stages_bean = (DirectDispensingBean)getBeanObject( all_stages_bean_id, all_stages_bean_name, request);
			while(stTtemCodes.hasMoreTokens()){
				item_code	=stTtemCodes.nextToken();
				if(trade_count < tradeCodesArr.length){
					trade_code=tradeCodesArr[trade_count];
					trade_name = tradeNamesArr[trade_count++];
				}
				else{
					trade_code = "";
					trade_name = "";
				}
				all_stages_bean.loadItemDetail(item_code, trade_code, trade_name, bl_install_yn );
			}

			ArrayList tot_cons_item_dtl  = (ArrayList)all_stages_bean.getConsumableDetails();

			HashMap cons_item_dtls       =  new HashMap();
			int rec_no =Integer.parseInt(count);
			if(tot_cons_item_dtl.size()>0){
			   cons_item_dtls       = (HashMap)tot_cons_item_dtl.get(rec_no);
			}
			putObjectInBean(all_stages_bean_id,all_stages_bean,request);
			item_desc = (String)cons_item_dtls.get("LONG_DESC")==null?"":(String)cons_item_dtls.get("LONG_DESC"); //Encoding added for MMS-SCF-0369 [IN:049801] -start
			item_desc=item_desc.replaceAll(" ","%20");
			item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
			item_desc=item_desc.replaceAll("%2520","%20");//added for MMS-SCF-0369 [IN:049801] -end
			out.println("setItemValues('"+item_desc+"')");
		}
		else if(identity.equals("SetBatchDetails")){	
			String rec_no  =(String)hash1.get("rec_no");
			HashMap  batch_det = new HashMap();
			batch_det.put("BATCH_ID",(String)hash1.get("batch_id"));
			batch_det.put("ITEM_CODE",(String)hash1.get("item_code"));
			batch_det.put("ITEM_NAME",(String)hash1.get("item_name"));
			batch_det.put("STORE_CODE",(String)hash1.get("store_code"));
			batch_det.put("STORE_DESC",(String)hash1.get("store_desc"));
			batch_det.put("EXPIRY_DATE",(String)hash1.get("expiry_date"));
			batch_det.put("BIN_LOCN_CODE",(String)hash1.get("bin_locn_code"));
			batch_det.put("BIN_LOCN_DESC",(String)hash1.get("bin_locn_desc"));
			batch_det.put("TRADE_ID",(String)hash1.get("trade_id"));
			batch_det.put("TRADE_DESC",(String)hash1.get("trade_desc"));
			batch_det.put("MANUFACTURER_CODE",(String)hash1.get("manufacturer_code"));
			batch_det.put("MANUFACTURER_DESC",java.net.URLDecoder.decode((String)hash1.get("manufacturer_desc"),"UTF-8" ));
			batch_det.put("AVAIL_QTY",(String)hash1.get("avail_qty"));

			String sysdate =(String)hash1.get("sysdate");
			

			String all_stages_bean_id				 =  (String)hash1.get("all_stages_bean_id");
			String all_stages_bean_name				 =  (String)hash1.get("all_stages_bean_name");
			
            DirectDispensingBean all_stages_bean = (DirectDispensingBean)getBeanObject( all_stages_bean_id, all_stages_bean_name, request);

			ArrayList tot_cons_item_dtl  = (ArrayList)all_stages_bean.getConsumableDetails();
			HashMap cons_item_dtls       =  new HashMap();
		    int srl_no                   =  Integer.parseInt(rec_no);
			cons_item_dtls               = (HashMap)tot_cons_item_dtl.get(srl_no);
            if(cons_item_dtls.size()>0){
                 cons_item_dtls.put("BATCH_DET",batch_det) ; 
			}
		}
		else if(identity.equals("StoreConcumableBillingDetails")){
            String bl_install_yn                     =  (String) hash1.get("bl_install_yn");
			String all_stages_bean_id				 =  (String)hash1.get("all_stages_bean_id");
			String all_stages_bean_name				 =  (String)hash1.get("all_stages_bean_name");
            String drug_code						 =	(String)hash1.get("drug_code");				
		    String srl_no							 =	(String)hash1.get("Srl_no");				
		    		patient_id						 =	(String)hash1.get("patient_id");				
			 encounter_id					     =	(String)hash1.get("encounter_id");				
		    String sal_trn_type						 =	(String)hash1.get("sal_trn_type");				
			String sysdate							 =	(String)hash1.get("sysdate");	
			String store_code						 =	(String)hash1.get("store_code");	
			String tot_alloc_qty					 =  (String)hash1.get("tot_alloc_qty");
			String batch_str						 =  (String)hash1.get("batch_str");
            String order_id							 =  (String)hash1.get("order_id");
			String order_line_no					 =  (String)hash1.get("order_line_no");
			String old_tot_gross_charge_amount_str	 =  (String)hash1.get("tot_gross_charge_amount");
			String old_tot_groos_pat_payable_str	 =  (String)hash1.get("tot_groos_pat_payable");
			String tot_groos_amt_str	             =  (String)hash1.get("tot_groos_amt")==null?"":(String)hash1.get("tot_groos_amt"); // Added for ML-BRU-CRF-0469 [IN:065426]
			String old_gross_charge_amount_str		 =  (String)hash1.get("old_gross_charge_amount");
			String old_groos_pat_payable_str		 =  (String)hash1.get("old_groos_pat_payable");	   
			String old_groos_amt_str		 =  (String)hash1.get("old_tot_groos_amt")==null?"":(String)hash1.get("old_tot_groos_amt"); // Added for ML-BRU-CRF-0469 [IN:065426]
			float tot_gross_charge_amount			 = 0;
			float tot_groos_pat_payable				 = 0;
			float tot_groos_amt                      = 0; // Added for ML-BRU-CRF-0469 [IN:065426]
			float old_gross_charge_amount			 = 0;
			float old_groos_pat_payable			     = 0;
			float old_groos_amt			             = 0; // Added for ML-BRU-CRF-0469 [IN:065426]
			HashMap  billing_det                     = new HashMap();
			String gross_charge_amount				 =  "";
			String groos_pat_payable				 =  "";			
			String tot_gross_charge_amount_str		 =  "";
			String tot_groos_pat_payable_str		 =  "";
			String decimalFormatString				 =  "";
			String err_msg							 =  "";
            String gross_charge_amount_payable="";   // Added for ML-BRU-CRF-0469 [IN:065426]
			DirectDispensingBean all_stages_bean = (DirectDispensingBean)getBeanObject( all_stages_bean_id, all_stages_bean_name, request);

            if(bl_install_yn.equals("Y")){
				if(!old_tot_gross_charge_amount_str.equals("") && !old_tot_groos_pat_payable_str.equals("")&&!old_gross_charge_amount_str.equals("") && !old_groos_pat_payable_str.equals("")){
					tot_gross_charge_amount			 =  Float.parseFloat((String)hash1.get("tot_gross_charge_amount"));
					tot_groos_pat_payable			 =  Float.parseFloat((String)hash1.get("tot_groos_pat_payable"));  
					old_gross_charge_amount			 =  Float.parseFloat((String)hash1.get("old_gross_charge_amount")); 
					old_groos_pat_payable			 =  Float.parseFloat((String)hash1.get("old_groos_pat_payable"));
				}
				if(!tot_groos_amt_str.equals("") && !old_groos_amt_str.equals("")){  // Added for ML-BRU-CRF-0469 [IN:065426] -Start
					old_groos_amt                    = Float.parseFloat((String)hash1.get("old_tot_groos_amt"));
					tot_groos_amt                    = Float.parseFloat((String)hash1.get("tot_groos_amt"));
				}  // Added for ML-BRU-CRF-0469 [IN:065426] -End

				HashMap chareg_det                      = (HashMap)all_stages_bean.callItemChargeDtls(patient_id,encounter_id,sal_trn_type,drug_code,Integer.parseInt(tot_alloc_qty), batch_str,sysdate,store_code,"","","","","","");
		
				err_msg =(String)chareg_det.get("error_msg");
				
				if(err_msg.equals("")){
					HashMap det =new HashMap();
					decimalFormatString=(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
					/*if(!chareg_det.get("grosschargeamt").equals("null")){
						gross_charge_amount= (String)chareg_det.get("grosschargeamt");
					}*/ //Commented for ML-BRU-SCF-0368 [IN:034748]
					if(!chareg_det.get("netchargeamt").equals("null")){
						gross_charge_amount= (String)chareg_det.get("netchargeamt"); //Added for ML-BRU-SCF-0368 [IN:034748]
					}

					if(!chareg_det.get("patnetamt").equals("null")){
						groos_pat_payable  = (String)chareg_det.get("patnetamt");
					}
					if(!chareg_det.get("grosschargeamt").equals("null")){
						gross_charge_amount_payable= (String)chareg_det.get("grosschargeamt"); // Added for ML-BRU-CRF-0469 [IN:065426]
					}
						 
					tot_gross_charge_amount = tot_gross_charge_amount-old_gross_charge_amount;
					tot_groos_pat_payable = tot_groos_pat_payable-old_groos_pat_payable;
					tot_gross_charge_amount = tot_gross_charge_amount+Float.parseFloat(gross_charge_amount);
					tot_groos_pat_payable   = tot_groos_pat_payable+Float.parseFloat(groos_pat_payable);
					DecimalFormat dfTest    = new DecimalFormat(decimalFormatString);
					tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amount);
					tot_groos_pat_payable_str   = dfTest.format(tot_groos_pat_payable);

					billing_det.put("GROSS_CHARGE_AMOUNT",gross_charge_amount);
					billing_det.put("GROOS_PAT_PAYABLE",gross_charge_amount);
					billing_det.put("GROSS_CHARGE_AMOUNT_PAYABLE",gross_charge_amount_payable); // Added for ML-BRU-CRF-0469 [IN:065426]
					out.println("setConsumableBillingAmounts('"+err_msg+"','"+srl_no+"','"+gross_charge_amount+"','"+groos_pat_payable+"','"+tot_gross_charge_amount_str+"','"+tot_groos_pat_payable_str+"','"+gross_charge_amount_payable+"')");  // gross_charge_amount_payable, Added for ML-BRU-CRF-0469 [IN:065426]
				}
				else{
					out.println("setConsumableBillingAmounts('"+err_msg+"','"+srl_no+"','"+gross_charge_amount+"','"+groos_pat_payable+"','"+tot_gross_charge_amount_str+"','"+tot_groos_pat_payable_str+"','"+gross_charge_amount_payable+"')"); // gross_charge_amount_payable, Added for ML-BRU-CRF-0469 [IN:065426]
				}
				chareg_det =null;
			}
            
            ArrayList tot_cons_item_dtl  = (ArrayList)all_stages_bean.getConsumableDetails();
		    HashMap cons_item_dtls       =  new HashMap();
		    int rec_no                   =  Integer.parseInt(srl_no);
			cons_item_dtls               = (HashMap)tot_cons_item_dtl.get(rec_no);
            HashMap  batch_det           = new HashMap();
	
            if(cons_item_dtls.size()>0){
				cons_item_dtls.put("ALLOC_QTY",tot_alloc_qty);
 	 			if(batch_det!=null)
					batch_det =(HashMap)cons_item_dtls.get("BATCH_DET");
			    String item_cost	=	all_stages_bean.getItemCost((String)hash1.get("drug_code"),(String)hash1.get("store_code"),tot_alloc_qty,sysdate);
			 	if(batch_det!=null)
					batch_det.put("ITEM_COST",item_cost);
 				billing_det.put("GROSS_CHARGE_AMOUNT",gross_charge_amount);
				billing_det.put("GROOS_PAT_PAYABLE",groos_pat_payable);
				billing_det.put("GROSS_CHARGE_AMOUNT_PAYABLE",gross_charge_amount_payable);
				billing_det.put("ERROR_MSG",err_msg);
				cons_item_dtls.put("BILLING_DET",billing_det) ; 
				if(!err_msg.equals("")){
					cons_item_dtls.put("SELECTED_YN","N");   
				}
			} 
		}
		else if(identity.equals("SetSelectedRecord")){
            String srl_no                     =  (String) hash1.get("rec_no");
			String selected_yn				  =  (String)hash1.get("selected_yn");
			String all_stages_bean_id		  =  (String)hash1.get("all_stages_bean_id");
			String all_stages_bean_name		  =  (String)hash1.get("all_stages_bean_name");
			DirectDispensingBean all_stages_bean = (DirectDispensingBean)getBeanObject( all_stages_bean_id, all_stages_bean_name, request);

			ArrayList tot_cons_item_dtl  = (ArrayList)all_stages_bean.getConsumableDetails();
		    HashMap cons_item_dtls       =  new HashMap();
		    int rec_no                   =  Integer.parseInt(srl_no);
			cons_item_dtls               = (HashMap)tot_cons_item_dtl.get(rec_no);

            if(cons_item_dtls.size()>0){
				cons_item_dtls.put("SELECTED_YN",selected_yn);                   
			}  
		}
		else if(identity.equals("clearBatchDetails")){	
			String rec_no                            =  (String)hash1.get("rec_no");
			String all_stages_bean_id				 =  (String)hash1.get("all_stages_bean_id");
			String all_stages_bean_name				 =  (String)hash1.get("all_stages_bean_name");
		
            DirectDispensingBean all_stages_bean = (DirectDispensingBean)getBeanObject( all_stages_bean_id, all_stages_bean_name, request);

			ArrayList tot_cons_item_dtl  = (ArrayList)all_stages_bean.getConsumableDetails();
		    HashMap cons_item_dtls       =  new HashMap();
		    int srl_no                   =  Integer.parseInt(rec_no);
			cons_item_dtls               = (HashMap)tot_cons_item_dtl.get(srl_no);
            if(cons_item_dtls.size()>0){
                 cons_item_dtls.remove("BATCH_DET"); 
				 cons_item_dtls.put("ALLOC_QTY",""); 
				 cons_item_dtls.remove("BILLING_DET");
			}
		}
		else if(func_mode != null && func_mode.equals("onLinePrinting")){
			String print_yn		= (String) hash.get( "print_yn" );
			if(print_yn.equals("Y")){
				ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
				ecis.utils.OnlineReport report2= new ecis.utils.OnlineReport((String)session.getValue( "facility_id" ), "PH", "PHTOKEN") ;
				report2.addParameter("p_module_id", "PH") ;
				report2.addParameter("p_report_id", "PHTOKEN") ;
				report2.addParameter("P_TOKEN_NO", (String) hash.get( "flag" )) ;
				report2.addParameter("P_TRANS_NAME", "DD") ;
				report2.addParameter("P_FACILITY_ID",(String)session.getValue( "facility_id" )) ;
				report2.addParameter("P_DISP_LOCN_CODE",  bean.getDispLocnCode()) ;
				report2.addParameter("P_TOKEN_SERIES",bean.getTokenSeriesCode() ) ;
				report2.addParameter("p_language_id", locale) ;
				report2.addParameter("p_patient_id", bean.getPatientID()) ;
				onlineReports.add( report2) ;
				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
			}
		}
		else if(func_mode!= null && func_mode.equals("callSearch")) {
			ArrayList drugCode = new ArrayList();
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap drugData	=	null;
			String drug_code =		null;
			String freq		 =		null;

			if(prescriptionDetails!=null && prescriptionDetails.size()>0){
				for(int j=0;j<prescriptionDetails.size();j++){
					drugData=(HashMap) prescriptionDetails.get(j);
					drug_code = (String) drugData.get("DRUG_CODE");
					freq		 = (String) drugData.get("FREQ_NATURE");
					//out.println("alert(\"" + freq + "\");") ;
					if( freq!=null &&  ! ((freq.equals("O") || freq.equals("P")) )){
						drugCode.add(drug_code);
					}
				}
			}
			out.println("drugSearch('"+drugCode+"')");
	}
	else if(func_mode!= null && func_mode.equals("IssueUom")){
		//code for setting issue uom onchange
		 String drug_code			=  (String)hash.get("drug_code");
		 String srl_no				=  (String)hash.get("srl_no");
		 String issue_uom           =  (String)hash.get("issue_uom");
		 HashMap  detail            =   new HashMap();
		 detail.put(drug_code+srl_no+"_uom",issue_uom);
		 bean.setIssueUomQty( drug_code+srl_no,detail);
	}
	else if(func_mode!= null && func_mode.equals("GetLocalInstrunction")){
		//code for setting issue uom onchange
		 String label_id			=  (String)hash.get("label_id");		
		 String srlNo				=  (String)hash.get("srlNo");
		 String label_text_type			=  (String)hash.get("label_text_type");		
		 String Local_instruction   =  (String)bean. getLocalInstruction( label_id);
		 out.println("setLocalInstrunction(\""+Local_instruction+"\",\""+srlNo+"\",\""+label_text_type+"\")");
	}
	else if(func_mode != null && func_mode.equals("PRNRemarks")){
		String prnRemarks = (String)hash.get( "remarks");
		String drug_code = (String)hash.get( "drug_code");
		String remarks_code = (String)hash.get( "remarks_code");
		prnRemarks = java.net.URLDecoder.decode(prnRemarks,"UTF-8");
		HashMap remarks = new HashMap();
		remarks.put("remarks_code",remarks_code);
		remarks.put("remarks_dtl",prnRemarks);
		bean.addPRNRemarks(drug_code,remarks);
	}
	else if(func_mode != null && func_mode.equals("PRNText")){
		String drug_code            = (String)hash.get( "drug_code");
		String remarks_code			= (String)hash.get( "remarks_code");
		String remarks_text			= "";	
		ArrayList prnRemarkForDrug  = (ArrayList)bean.getPrnRemarkForDrug(drug_code);
		HashMap temp				= new HashMap();
		for(int i=0; i<prnRemarkForDrug.size(); i++){
		   temp = (HashMap)prnRemarkForDrug.get(i);
		   if(temp.get("REASON_CODE").equals(remarks_code)){
				remarks_text = (String)temp.get("REMARKS")==null?"":(String)temp.get("REMARKS");;
				remarks_text=remarks_text.replaceAll(" ","%20");
				remarks_text = java.net.URLEncoder.encode(remarks_text,"UTF-8");
				remarks_text=remarks_text.replaceAll("%2520","%20");
				out.println("setPRNRemarks(\""+remarks_text+"\")");
		   }
		}
	}
	else if(func_mode != null && func_mode.equals("xcludeRecInCmb" ) ){
		
		String strCmbParms =  request.getParameter("cmbLoad");
		String strSelCmbVal = request.getParameter("selCmbVal");
		

        String  label_text_id                    =   "";
		String  label_text_1                     =   "";
		String  label_text_loc_lang              =   "";

		HashMap labelsTmp = new HashMap();
		ArrayList cautionTmp = new ArrayList();


		labelsTmp		= (HashMap) bean.loadLabels();
		
		cautionTmp		= (ArrayList) labelsTmp.get("caution");
		//out.println("clearCaution();");

		for (int nCtr = 0; nCtr < cautionTmp.size(); nCtr++){
			HashMap dataTmp	 = new HashMap();
			dataTmp		= (HashMap) cautionTmp.get(nCtr);

			label_text_id       =(String)dataTmp.get("label_text_id")==null?"":(String)dataTmp.get("label_text_id");
			label_text_1        =(String)dataTmp.get("label_text_1")==null?"":(String)dataTmp.get("label_text_1");
			label_text_loc_lang =(String)dataTmp.get("label_text_1_loc_lang")==null?"":(String)dataTmp.get("label_text_1_loc_lang");

		
			if(strCmbParms != null && strCmbParms.equals("caution_label_test_id_1") )	{
			//	out.println("addOption(\""+label_text_loc_lang+"\",\""+label_text_id+"\",\""+label_text_1+"\",\""+strSelCmbVal+"\",\"Caution\");");
			if(strSelCmbVal.equalsIgnoreCase(label_text_1))
				out.println("asgnLocCAU(\""+label_text_loc_lang+"\")");
			}
		}
	}else if(func_mode != null && func_mode.equals("xcludeRecInCmbSplInstr" ) ){
		String strCmbParms =  request.getParameter("cmbLoad");
		String strSelCmbVal = request.getParameter("selCmbVal");
        HashMap labelsTmp = new HashMap();
		ArrayList spl_instructionTmp = new ArrayList();
		String  label_text_id                    =   "";
		String  label_text_1                     =   "";
		String  label_text_loc_lang              =   "";


		labelsTmp		= (HashMap) bean.loadLabels();
		spl_instructionTmp = (ArrayList) labelsTmp.get("spl_instruction");

	//	out.println("clearSplInstr();");

		
		for (int nCtr = 0; nCtr < spl_instructionTmp.size(); nCtr++){
			HashMap dataTmp	 = new HashMap();
			dataTmp		= (HashMap) spl_instructionTmp.get(nCtr);

			label_text_id       =(String)dataTmp.get("label_text_id")==null?"":(String)dataTmp.get("label_text_id");
			label_text_1        =(String)dataTmp.get("label_text_1")==null?"":(String)dataTmp.get("label_text_1");
			label_text_loc_lang =(String)dataTmp.get("label_text_1_loc_lang")==null?"":(String)dataTmp.get("label_text_1_loc_lang");
			
			if(strCmbParms != null && strCmbParms.equals("spl_instr_label_text_id") ){
				//out.println("addOption(\""+label_text_loc_lang+"\",\""+label_text_id+"\",\""+label_text_1+"\",\""+strSelCmbVal+"\",\"SplInstr\");");
			if(strSelCmbVal.equals(label_text_1))
				out.println("asgnLocSPL(\""+label_text_loc_lang+"\")");
			}
		}
	}
	else if(func_mode != null && func_mode.equals("getActiontext" ) ){ //Add this condition for SKR-CRF-0006[IN029561]	
		String form_code		= (String) hash.get( "form_code" );
		String route_code		= (String) hash.get( "route_code" );	
		String actionText = bean.getActionText(form_code,route_code);		
		out.println("assignactionText('"+actionText+"');"); 
		
	}
	else if(func_mode!= null && func_mode.equals("storeAuthUserInBean")){		// Added for RUT-CRF-0035 [IN029926]  --begin
		bean.setAuthUserID( (String) hash.get( "auth_user_id" ));
	} // Added for RUT-CRF-0035 [IN029926] --end
	
	else if (func_mode.equals("savePractDetails")) {//Added for INC#048044 --start
		
	         practioner_name = java.net.URLDecoder.decode(((String) hash.get( "practioner_name" )),"UTF-8");
		 bean.setPractionerID((String)hash.get("practioner_id"));
		 bean.setPractionerName(practioner_name);
	}//Added for INC#048044 --end
	else if(func_mode!= null && func_mode.equals("directDispBarcode")){ // MMS-DM-CRF-0112  - Start
		
 		String search_bean_id      = "@DrugSearchBean";
 		String search_bean_name ="ePH.DrugSearchBean";
 		DrugSearchBean searchbean = (DrugSearchBean)getBeanObject( search_bean_id,search_bean_name,request) ;
 		searchbean.setLanguageId(locale); 
		String orderingPrivilige="";
 		String diagnosis_found_yn="";
 		String appl_for_age_grp_yn="";
 		String date_of_birth = (String) hash.get("date_of_birth")==null?"":(String) hash.get("date_of_birth");
 		String gender = (String) hash.get("gender")==null?"":(String) hash.get("gender");
 		String facility_id = (String)session.getValue("facility_id");
 		
 		String drugPrivilige = searchbean.getDefaultPriviligeDrugSelection(facility_id)==null?"":searchbean.getDefaultPriviligeDrugSelection(facility_id);
	    String barcode_id = (String) hash.get("barcode_id")==null?"":(String) hash.get("barcode_id");
		String identity1 = (String)hash.get("identity")==null?"":(String) hash.get("identity");
		String patient_class1 = (String)hash.get("patient_class")==null?"":(String) hash.get("patient_class");
		String drug_priv_appln_yn	= searchbean.getDrugPrivilegeYN();
		String resp_id = (String) session.getValue("responsibility_id");
		String drug_code1 ="";
        bean.setBarcode_id(barcode_id);
		ArrayList drug_details = bean.getSelectedDrugInfo(drug_priv_appln_yn,resp_id,barcode_id,date_of_birth.trim(),gender.trim(),drugPrivilige,patient_class1);
 		
 		if(drug_details.size()>=3){
 			drug_code1          = (String)drug_details.get(0)==null?"":(String)drug_details.get(0);
 			diagnosis_found_yn = (String)drug_details.get(0)==null?"":(String)drug_details.get(1);
 			appl_for_age_grp_yn = (String)drug_details.get(1)==null?"":(String)drug_details.get(2);
 			orderingPrivilige   = (String)drug_details.get(2)==null?"":(String)drug_details.get(3);
 		}
 		else{
 			barcode_id ="";
 			bean.setBarcode_id(barcode_id);
 		}
 		
		ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
		HashMap drugData	=	null;
		String drug_code =		null;
		String freq		 =		null;
        boolean flag1 = false;
		if(prescriptionDetails!=null && prescriptionDetails.size()>0 && !drug_code1.equals("")){
			for(int j=0;j<prescriptionDetails.size();j++){
				drugData=(HashMap) prescriptionDetails.get(j);
				drug_code = (String) drugData.get("DRUG_CODE");
				freq		 = (String) drugData.get("FREQ_NATURE");
				if( freq!=null &&  ! ((freq.equals("O") || freq.equals("P")) )){
					if(drug_code.equals(drug_code1)){
						flag1 = true;
					   break;
					}	
				}
			}
		}
 		out.println("CallDrugBasedOnBarcode('"+drug_code1+"','"+drugPrivilige+"','"+identity1+"','"+orderingPrivilige+"','"+diagnosis_found_yn+"','"+appl_for_age_grp_yn+"','"+flag1+"')");	
 	} // MMS-DM-CRF-0112  - End
	else if(func_mode != null && func_mode.equals("loadDrugInteractionForDrug")){ //added for MMS-KH-CRF-0029 - start
			patient_id		= (String) hash.get( "patient_id" );
			String drugCode			= (String) hash.get( "drug_code" );
			String serial_number	= (String) hash.get( "srl_no" );
			String ext_drug_code	= "";
			String ext_srl_no		=	"";
			
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap Drug_Details =null;
			HashMap DrugInteractionDtl=null;//MMS-KH-CRF-0029
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
					Drug_Details=(HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) Drug_Details.get("DRUG_CODE");
					ext_srl_no=(String) Drug_Details.get("SRL_NO");
					

					if( drugCode.equals(ext_drug_code) && serial_number.equals(ext_srl_no) ){
						String form_code = (String)Drug_Details.get("FORM_CODE")==null?"":(String)Drug_Details.get("FORM_CODE");
						String generic_id = (String)Drug_Details.get("GENERIC_ID")==null?"":(String)Drug_Details.get("GENERIC_ID");
						ArrayList alDrugIntrDtlList = bean.getDrugInteractionDtls(drugCode, form_code, generic_id,(String)Drug_Details.get("START_DATE"),(String)Drug_Details.get("END_DATE") , patient_id);
					System.err.println("alDrugIntrDtlList=======392===>"+alDrugIntrDtlList);
					if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()>2){
						String interaction_type  = "";
						Drug_Details.put("SEVERITY_LEVEL", (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2) );
						Drug_Details.put("INTR_RESTRIC_TRN", (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1) );
						Drug_Details.put("INTERACTION_DTL", alDrugIntrDtlList );
						Drug_Details.put("INTERACTION_EXISTS", "Y" );
						if(((String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1)).equals("Y") || ((String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2)).equals("H")){
							Drug_Details.put("INTR_ALERT", "Y" );
						}
						if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()> 0){
							ArrayList intrType  = new ArrayList();//MMS-KH-CRF-0029
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
							}
						   }
						}

						break;
					}					
				}					
			}
		}
		else if(func_mode!= null && func_mode.equals("ApprovalNoForDrug")){ //added for AAKH-CRF-0117 - start
			HashMap ext_drugData		=	null;
		ArrayList prescriptionDetails=null;
		String drug_code		=	(String) hash.get( "drug_code" );
		String srl_no			=   (String) hash.get( "srl_no" );

		String ext_srl_no       =   "";
		String approval_no      =    (String) hash.get( "approval_no" );; 
		String ext_drug_code    =   "";
		prescriptionDetails=(ArrayList)bean.getpresDetails();
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData	=	(HashMap) prescriptionDetails.get(j);
				ext_drug_code	=	(String) ext_drugData.get("DRUG_CODE");
				ext_srl_no		=   (String) ext_drugData.get("SRL_NO");
				if(drug_code.equals(ext_drug_code) && ext_srl_no.equals(srl_no)){
					ext_drugData.put("approval_no",approval_no);
				}
			 
			}
		} //added for AAKH-CRF-0117 - end
		//Added for IN:072715 start
		else if(func_mode!= null && func_mode.equals("override_remarks")) {
			//Hashtable hash			=  (Hashtable)XMLobj.parseXMLString(request);		
			//hash					=  (Hashtable)hash.get("SEARCH") ;
			String reason_code		= (String)hash.get("reason_code"); 
			String trn_type		= (String)hash.get("trn_type");
			String field		= (String)hash.get("field");
			 patient_id		= (String)hash.get("patient_id");
			 encounter_id		= (String)hash.get("encounter_id");
			String presBean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
			String presBean_name				= "ePH.PrescriptionBean_1";
			PrescriptionBean_1 pres_bean	= (PrescriptionBean_1)getBeanObject( presBean_id, presBean_name , request);
			String remarks = pres_bean.getOverrideRemarks(trn_type, reason_code);
			out.println("document.DispQueueMgmtHoldReason."+field+".value = '"+remarks+"';");
			out.println("document.DispQueueMgmtHoldReason."+field+".readOnly = true;");
			putObjectInBean(presBean_id,pres_bean,request); 
			}
			//Added for IN:072715 end
			//Added for IN:073485 start
			else if(func_mode!= null && func_mode.equals("override_mand_check")) {
					String drugCode		= (String)hash.get("drug_code");
					String srlNo		= (String)hash.get("srl_no");
					String allergy_yn		= (String) hash.get("allergy_yn");
					String current_rx		= (String) hash.get("current_rx");
					String limit_ind		= (String) hash.get("limit_ind");
					ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
					HashMap ext_drugData	=	null;
					String ext_drug_code	=	null;
					String ext_srl_no		=	null;
					String curr_yn    = "";
					String Override_remarks="";
					for(int j=0;j<prescriptionDetails.size();j++){
						ext_drugData      =  (HashMap) prescriptionDetails.get(j);
						ext_drug_code	=	(String) ext_drugData.get("DRUG_CODE");
						ext_srl_no		=	(String) ext_drugData.get("SRL_NO");
						if( drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no) ){
							
							if(current_rx.equals("Y")){
								Override_remarks=(String)ext_drugData.get("CURRENTRX_REMARKS");
								if(Override_remarks==null || Override_remarks.equals("")){
									out.println("parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form.override_rem_mand.value='Y';");
								}
								
							}
							if(limit_ind.equals("N")){
								Override_remarks="";
								Override_remarks=(String)ext_drugData.get("DOSE_REMARKS");
								if(Override_remarks==null || Override_remarks.equals("")){
									out.println("parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form.override_rem_mand.value='Y';");
								}	
							}
							if( allergy_yn.equals("Y")){
								Override_remarks="";
								Override_remarks=(String)ext_drugData.get("ALLERGY_REMARKS");
								if(Override_remarks==null || Override_remarks.equals("")){
									out.println("parent.parent.parent.parent.f_detail.f_ord_detail.f_drug_detail.f_drug.document.prescription_detail_form.override_rem_mand.value='Y';");
								}
									
							}
							break;
						}
						
					}	
				}
				//Added for IN:073485 END
				//Added for IN:069886 start,Modified for IN:069886 start
			else if(func_mode != null && func_mode.equals("assinLastRefillDate")){
				String end_date			= (String) hash.get( "end_date" );
				String srl_no			= (String) hash.get( "srl_no" );
				String last_refill_durn_value			= (String) hash.get( "last_refill_durn_value" );
				String last_refill_freq_chnage_durn_value			= (String) hash.get( "last_refill_freq_chnage_durn_value" );
				String durn_value			= (String) hash.get( "durn_value" );  //Added for IN:069886
				String repeat_durn_type			= (String) hash.get( "repeat_durn_type" );  //Added for IN:069886
				String refill_no			= (String) hash.get( "refill_no" );  //Added for IN:069886
				String last_refill_end_date			= (String) hash.get( "last_refill_end_date" );  //Added for IN:069886
				if(!locale.equals("en"))
					end_date =  com.ehis.util.DateUtils.convertDate(end_date, "DMYHM",locale,"en");
				
					HashMap	refill_detail	=(HashMap)	bean.populateRefillDetail(end_date,durn_value,repeat_durn_type,refill_no);
		
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
			else if(func_mode != null && func_mode.equals("saveRefill")){
				String srl_no			= (String) hash.get( "srl_no" );
				String end_date			= (String) hash.get( "end_date" );
				String durn_value			= (String) hash.get( "durn_value" );
				String repeat_durn_type			= (String) hash.get( "repeat_durn_type" );
				String refill_no			= (String) hash.get( "refill_no" );
				if(!locale.equals("en"))
					end_date =  com.ehis.util.DateUtils.convertDate(end_date, "DMYHM",locale,"en");
				
				HashMap refill_detail	=(HashMap)	bean.populateRefillDetail(end_date,durn_value,repeat_durn_type,refill_no);
				bean.setRefillDetail(srl_no,refill_detail);
				
			}
			//Added for IN:069886 end,Modified for IN:069886 end
			//Added for IN:069887 start
		else if(func_mode!= null && func_mode.equals("override_mand_check_on_confirm")) {
					String drugCode		= (String)hash.get("drug_code");
					String srlNo		= (String)hash.get("srl_no");
					String interaction_exists	= (String)hash.get("interaction_exists");
					ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
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
							/*if(interaction_exists.equals("Y")){
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
							}*/
							if( interaction_exists.equals("Y")){	// added for FD-RUT-CRF-0066.1 [IN036975]- start								
								if(ext_drugData.get("DRUGINTRACTION_OVERRIDE")==null ){
									if(!((String)ext_drugData.get("DRUGINTRACTION_OVERRIDE")).equals("Y")){
										drug_drug_remarks_yn="Y";
										
									}
								}
									if(ext_drugData.containsKey("FOOD_INTERACTION_EXISTS")){
										if(((String)ext_drugData.get("FOOD_INTERACTION_REMARKS"))==null || ((String)ext_drugData.get("FOOD_INTERACTION_REMARKS")).equals("") ){
											drug_food_remarks_yn="Y";
										}
									}
									if(ext_drugData.containsKey("LAB_INTERACTION_EXISTS")){
										if(((String)ext_drugData.get("LAB_INTERACTION_REMARKS"))==null || ((String)ext_drugData.get("LAB_INTERACTION_REMARKS")).equals("") ){
											drug_lab_remarks_yn="Y";
										}
									}
							}
							out.println("showOverideMandAlert('"+allergy_remarks_yn+"','"+dup_remarks_yn+"','"+dose_remarks_yn+"','"+drug_drug_remarks_yn+"','"+drug_lab_remarks_yn+"','"+drug_food_remarks_yn+"')");
							break;
						}
						
					}	
				}
		//Added for IN:069886 start		
		else if(func_mode != null && func_mode.equals("removerefill")){
			String srl_no			= (String) hash.get( "srl_no" );
			bean.removeRefillDetail(srl_no);
		}
		//Added for IN:069886 end
		//Added for IN:069887  END
	putObjectInBean(bean_id,bean,request);
 }
 catch (Exception e) {
	out.println("alert(\"Exception in Direct Dispensing validation" + e + "\");") ;
	e.printStackTrace();
}

%>

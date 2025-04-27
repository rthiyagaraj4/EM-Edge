<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
14/5/2020		IN072851			Shazana			14/7/2020	Manickam				TBMC-SCF-0176
--------------------------------------------------------------------------------------------------------------------
*/ 
%>
<!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link> 
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
		<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>   
		<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
		<script language="Javascript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>

	</HEAD>
	<!-- <BODY> -->
	<body onMouseDown="" onKeyDown="lockKey()">
<%
		String drug_code			=   request.getParameter("drug_code");
		String srl_no				=   request.getParameter("srl_no");
		String mode				    =   request.getParameter("mode");
		String calledFrm = "";
		//calledFrm = request.getParameter("called_from_amend")==null?"":(String)request.getParameter("called_from_amend");
		if(calledFrm.equals("Y")){
%>
			<script language="JavaScript" src="../../ePH/js/Prescription_2.js"></script>
<%
		}else{
%>
			<script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%}
		String patient_id			= request.getParameter("patient_id") ;
		String encounter_id			= request.getParameter("encounter_id") ;
		String patient_class		= request.getParameter("patient_class");
		String bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
		String bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
		String drug_db_interface_yn = request.getParameter("drug_db_interface_yn")==null?"":request.getParameter("drug_db_interface_yn");

		String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name		= "ePH.PrescriptionBean_1";
		String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
		String presBean_name		= "ePH.PrescriptionBean";
		PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );
		String facility_id	= "";
		facility_id	= (String) session.getValue("facility_id");

		String extdrugCode	   ="";
		String srlNo		   ="";
		String freq_code	   ="";
		String durn_type	   =""; //priya
		String durn_value	   ="";
		String start_date	   ="";
		String end_date		   ="";
		String qty_value	   ="";
		ArrayList	code	   =new ArrayList();
		ArrayList	desc	   =new ArrayList();								
		String qty_unit		   ="";	
		String qty_desc	       = "";	
		ArrayList arr_list	   = null;
		String disp_locn_code  = "";
		String disp_locn_desc  = "";
		String back_date	   = "";
		String future_date	   ="";
		String freq_nature	   ="";
		String repeat_durn_type= "";
		String freq_chng_durn_desc= "";
		String freq_value	   = "";
		String interval_value  = "";
		String sch_over_yn	   = "";
		String daily_dose	   = "";
		String unit_dose	   = "";
		String repeat_value	   = "";
		String scheduled_yn	   = "";
		String refill_cont_order_yn	="";
		String generic_id			="";	
		String dosage_type		= "";
		String split_dose_yn	= "";
		String allow_duplicate	= "";
		String stock_uom		= "";
		String stock_Details_uom= "";
		String absol_qty		= "";
		String current_rx		= "";
		String generic_name	    = "";		
		String	 prn_dose		= 	"";
		String prn_yn			="";
		HashMap prn_remarks		=	new HashMap();
		String prn_remarks_code	=	"";
		String prn_remarks_dtl	=	"";
		String orig_current_rx	= "";
		String freq_option	    = "";
		String dsg_reason       = "";
		String dup_reason       = "";
		String int_reason       = "";
		String con_reason       = "";
		String alg_reason       = "";
		String ext_prod_id		=	"";
		String selected_disp	= "";
		String fract_dose_appl_yn     = "";
		String fract_dose_round_up_yn = "";
		String in_formulary_yn        = "";
		String calc_def_dosage_yn     = "";
		String form_code              = "";
		String route_code             = "";
		String order_type_code		  =	"";
		String max_durn_value		  =	"";
		String chk_for_max_durn_action= "";
		boolean	entered				  =	false;
		String bl_incl_excl_override_reason_code ="";
		String bl_incl_excl_override_reason_desc = "";
		String bl_def_override_excl_incl_ind     = "";
		String bl_override_excl_incl_ind         = "";
		String bl_override_allowed_yn            = "";
		boolean def_freq_found                   = false;
		int dose_decimal = 6;
		String called_from_amend = request.getParameter("called_from_amend")==null?"":request.getParameter("called_from_amend");
		HashMap drugDetails         =  null;
		Hashtable DurnDescDetails	=  new Hashtable();
		String duration_option		=  "";
		String freq_durn_type		=  "D";
		String freq_durn_value		=  "";
		String force_auth_yn		=  "";
		String amend_yn		        =  "";
		String include_selected     =  "";
	    String exclude_selected     =  "";
	    String Select_selected      =  "";
		String billable_item_yn	   = "";
		String order_id			= "";
		String ord_line_no			=	"";
		String		strength_per_pres_uom		=   "";
		String		strength_per_value_pres_uom	= 	"";
		String start_date1 = null;//Added for INC#49425 --start
		String end_date1 = null;
		String sys_date = null;	
		String tempstartdate1="";
		String tempenddate1 = "";//Added for INC#49425--end
		boolean displayGrossAmtYn = presBean.isSiteSpecific("PH", "GROSS_AMT_DISPLY_YN"); //ADDED for ML-BRU-CRF-0469
		String def_dosage_type = ""; //added for TBMC-SCF-0176

		PrescriptionBean_1 bean	= (PrescriptionBean_1)getBeanObject( bean_id, bean_name,request);
		bean.setLanguageId(locale);
		bean.setSlidingScaleFreq();
		//ArrayList freq_dtls    = presBean.getFreqValues(); //unused
		ArrayList presDetails  = (ArrayList) bean.getpresDetails();
//corrected for PE By Naveen
		//int take_home					=	bean.getHomeMecdicationYn(encounter_id,(String)session.getValue("facility_id"));
		int take_home					=	(int)bean.getTakeHomeCount();
		prn_yn						    = bean.getchkforPRN();

		if(presDetails!=null && presDetails.size()>0){		
			for(int i=0;i<presDetails.size();i++){
				drugDetails		= (HashMap)presDetails.get(i);
				extdrugCode		= (String)drugDetails.get("DRUG_CODE");
				srlNo			= (String)drugDetails.get("SRL_NO");
				if(extdrugCode.equals(drug_code) && srlNo.equals(srl_no) ){
					ext_prod_id	   = "";
					freq_code	   = CommonBean.checkForNull((String)drugDetails.get("FREQ_CODE"));
					durn_type	   = CommonBean.checkForNull((String)drugDetails.get("DURN_TYPE"));
					durn_value	   = CommonBean.checkForNull((String)drugDetails.get("DURN_VALUE"));
					if(durn_value.equals("") || durn_value.equals("0"))
						durn_value="1";

					start_date	= drugDetails.get("START_DATE")==null?(String)drugDetails.get("START_DATE_TIME"):(String)drugDetails.get("START_DATE");
					end_date	= drugDetails.get("END_DATE")==null?(String)drugDetails.get("END_DATE_TIME"):(String)drugDetails.get("END_DATE");
					start_date	= start_date==null?"":start_date;
					end_date	= end_date==null?"":end_date;
					billable_item_yn = drugDetails.get("BILLABLE_ITEM_YN")==null?"Y":(String)drugDetails.get("BILLABLE_ITEM_YN");
//					qty_value	   = CommonBean.checkForNull((String)drugDetails.get("QTY_VALUE"));
//qty_value was strength value now its changed to quantity value when sliding scale drug is placed
					//qty_value	   = CommonBean.checkForNull((String)drugDetails.get("TAB_QTY_VALUE"));
					qty_value	   = (String)drugDetails.get("TAB_QTY_VALUE")==null?"1":(String)drugDetails.get("TAB_QTY_VALUE");
					//System.err.println("qty_value==184===>"+qty_value);
					if(qty_value.equals("") || qty_value.equals("0")) //TBMC-SCF-0167
						qty_value = "1";
//					dosage_type		= (String) drugDetails.get("DOSAGE_TYPE");
//value of dosage_type is hard coded to Quantity - its considered that if it is a sliding scale drug then dosage_type should go as Q

					dosage_type = "A";
					def_dosage_type               =(String) drugDetails.get("DOSAGE_TYPE")==null?"":(String) drugDetails.get("DOSAGE_TYPE");//added for TBMC-SCF-0176
					if(dosage_type.equals("S")){
						qty_unit			   = CommonBean.checkForNull((String)drugDetails.get("STRENGTH_UOM"));
						qty_desc			   = CommonBean.checkForNull((String)drugDetails.get("STRENGTH_UOM_DESC"));
					}
					else{
						qty_unit			   = CommonBean.checkForNull((String)drugDetails.get("PRES_BASE_UOM"));
						qty_desc			   = CommonBean.checkForNull((String)drugDetails.get("PRES_BASE_UOM_DESC"));
					}
					strength_per_pres_uom		= (String) drugDetails.get("STRENGTH_PER_PRES_UOM");
					strength_per_value_pres_uom	= (String) drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");

					form_code	       = (String) drugDetails.get("FORM_CODE");
					route_code	       = (String) drugDetails.get("ROUTE_CODE");
					back_date	       = CommonBean.checkForNull((String)drugDetails.get("BACK_DATE"));
					future_date	       = CommonBean.checkForNull((String)drugDetails.get("FUTURE_DATE"));
					freq_nature	       = CommonBean.checkForNull((String)drugDetails.get("FREQ_NATURE"));
					//repeat_durn_type= CommonBean.checkForNull((String)drugDetails.get("DURN_TYPE"));
					repeat_durn_type   = CommonBean.checkForNull((String)drugDetails.get("REPEAT_DURN_TYPE"));
					freq_chng_durn_desc= CommonBean.checkForNull((String)drugDetails.get("freq_chng_durn_desc"));
					freq_value	       = CommonBean.checkForNull((String)drugDetails.get("FREQ_VALUE"));
					interval_value     = CommonBean.checkForNull((String)drugDetails.get("INTERVAL_VALUE"));
					sch_over_yn	       = CommonBean.checkForNull((String)drugDetails.get("SCH_OVER_YN"));
					daily_dose	       = CommonBean.checkForNull((String) drugDetails.get("DAILY_DOSE"));
					unit_dose	       = CommonBean.checkForNull((String) drugDetails.get("UNIT_DOSE"));
					repeat_value	   = CommonBean.checkForNull((String) drugDetails.get("REPEAT_VALUE"));
					scheduled_yn	   = CommonBean.checkForNull((String) drugDetails.get("SCHEDULED_YN"));
					refill_cont_order_yn		= (String) drugDetails.get("REFILL_CONT_ORDER_YN");
					max_durn_value				= CommonBean.checkForNull((String) drugDetails.get("MAX_DURN_VALUE"));
					chk_for_max_durn_action		= CommonBean.checkForNull((String) drugDetails.get("CHK_FOR_MAX_DURN_ACTION"));
					generic_id				    = (String) drugDetails.get("GENERIC_ID");
					split_dose_yn	   = (String) drugDetails.get("SPLIT_DOSE_YN");
					allow_duplicate	   = (String) drugDetails.get("ALLOW_DUPLICATE_DRUG");
					if(patient_class.equals("OP"))
						allow_duplicate	   = (String) drugDetails.get("ALLOW_DUPLICATE_DRUG_OP");
					stock_uom		   = (String)drugDetails.get("STOCK_UOM");
				    stock_Details_uom  = bean.getUomDisplay(facility_id,stock_uom); //21/10/09 created
					disp_locn_code	   = (String) drugDetails.get("DISP_LOCN_CODE")==null?"":(String) 						drugDetails.get("DISP_LOCN_CODE");
					disp_locn_desc	   = (String) drugDetails.get("DISP_LOCN_DESC");
					order_id	   = (String) drugDetails.get("ORDER_ID")==null?"":(String) drugDetails.get("ORDER_ID");
					ord_line_no	   = (String) drugDetails.get("ORDER_LINE_NUM")==null?"":(String) drugDetails.get("ORDER_LINE_NUM");
					
					if(called_from_amend.equals("Y")){
						absol_qty		= (String)drugDetails.get("ORDER_QTY"); 
					}
					else{
						if(request.getParameter("order_idC") != null && !(request.getParameter("order_idC").equals("")) && !request.getParameter("order_idC").equals("undefined") && !(request.getParameter("order_idC").equals("null")) && drugDetails.containsKey("PRES_QTY_VALUE")){
							absol_qty		= (String)drugDetails.get("PRES_QTY_VALUE"); 
						}
						else{
							absol_qty		= (String)drugDetails.get("ABSOL_QTY"); 

						}
					}

					prn_dose					= (String)drugDetails.get("PRN_DOSES_PRES_PRD_FILL");
					current_rx		= ((String)drugDetails.get("CURRENT_RX"))==null?"":(String)drugDetails.get("CURRENT_RX");
					generic_name				= (String) drugDetails.get("GENERIC_NAME");
					prn_remarks					=	bean.getPRNRemarks((String)drugDetails.get("DRUG_CODE"));
					if(prn_remarks != null){
						prn_remarks_code			=	(String)prn_remarks.get("prn_remarks_dtl");
						prn_remarks_dtl				=	(String)prn_remarks.get("prn_remarks_code");
					}
					order_type_code				= (String) drugDetails.get("ORDER_TYPE_CODE");
					calc_def_dosage_yn          = (String) drugDetails.get("CALC_DEF_DOSAGE_YN")==null?"":(String) drugDetails.get("CALC_DEF_DOSAGE_YN");
					in_formulary_yn				= (String) drugDetails.get("IN_FORMULARY_YN")==null?"":(String) drugDetails.get("IN_FORMULARY_YN");
					fract_dose_appl_yn          = (String) drugDetails.get("FRACT_DOSE_APPL_YN")==null?"":(String) drugDetails.get("FRACT_DOSE_APPL_YN");
					fract_dose_round_up_yn      = (String) drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
					if(fract_dose_appl_yn.equals("N"))
						dose_decimal = 0;
					force_auth_yn				= (String) drugDetails.get("FORCE_AUTH_YN")==null?"":(String) drugDetails.get("FORCE_AUTH_YN"); // THIS IS TO KNOW IF AUTH YN IS DUE TO FORCE AUT OR DUE TO DURATION EXCEEDED //added for IN22255 --22/06/2010 --priya

					dsg_reason		=	(String)drugDetails.get("EXT_DDB_DSG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DSG_REASON");
					dup_reason		=	(String)drugDetails.get("EXT_DDB_DUP_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DUP_REASON");
					con_reason		=	(String)drugDetails.get("EXT_DDB_CON_REASON")==null?"":(String)drugDetails.get("EXT_DDB_CON_REASON");
					int_reason		=	(String)drugDetails.get("EXT_DDB_INT_REASON")==null?"":(String)drugDetails.get("EXT_DDB_INT_REASON");
					alg_reason		=	(String)drugDetails.get("EXT_DDB_ALG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_ALG_REASON");
					freq_durn_type	=   (String)drugDetails.get("FREQ_DURN_TYPE");
					freq_durn_value	=   (String)drugDetails.get("FREQ_DURN_VALUE");
					amend_yn	    =   CommonBean.checkForNull((String)drugDetails.get("AMEND_YN"),"N"); 
					if(!called_from_amend.equals("Y")){
						if(current_rx.equals("Y") && !drugDetails.containsKey("ORIG_CURRENT_RX")) {
							drugDetails.put("ORIG_CURRENT_RX","Y");							
						}
						if( drugDetails.containsKey("ORIG_CURRENT_RX") && ((String)drugDetails.get("ORIG_CURRENT_RX")).equals("Y") ) {
							orig_current_rx	=	(String)drugDetails.get("ORIG_CURRENT_RX");
						}
					}
					if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
						bl_override_allowed_yn =(String) drugDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"": (String) drugDetails.get("BL_OVERRIDE_ALLOWED_YN"); 
						bl_incl_excl_override_reason_code =(String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE")==null?"": (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE"); 
						bl_incl_excl_override_reason_desc = (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"": (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
						bl_def_override_excl_incl_ind = (String) drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND");  
						bl_override_excl_incl_ind = (String) drugDetails.get("BL_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drugDetails.get("BL_OVERRIDE_EXCL_INCL_IND");  

						if(bl_override_excl_incl_ind.equals(""))
							bl_override_excl_incl_ind = bl_def_override_excl_incl_ind;
						//if(!bl_override_allowed_yn.equals("Y"))
							//bl_override_allowed_yn = "disabled";
					}
				}
			}
		}

		if(prn_dose==null || prn_dose.equals("") || prn_dose.equals("0")) {
			prn_dose	=	"1";
		}
		if(freq_nature.equals("P") && (absol_qty==null)) {
			absol_qty		=	prn_dose;	
		}

		if(absol_qty==null)
			absol_qty			=	"1";

		HashMap freqValues	=	(HashMap)bean.populateFrequencyValues(drug_code,freq_code,"SlidingScale",patient_class); //passed mode as "SlidingScale" for IN21609 --07/06/2010 -- priya
		boolean dup_found	=	false;

		if(orig_current_rx.equals("Y") && allow_duplicate.equals("N")) { // && (patient_class.equals("IP") || take_home>0)
				dup_found	=	true;
		}

		
		if(freqValues.size()>0){
			ArrayList	freqCode	= (ArrayList) freqValues.get("FreqCode");
			ArrayList   freqDesc	= (ArrayList) freqValues.get("FreqDesc");
			ArrayList   FreqNature	= (ArrayList) freqValues.get("FreqNature");
			if(!amend_yn.equals("Y") && freq_nature.equals("P")){ //added for TBMC-SCF-0166 - start
				if(freqValues!=null && freqValues.size()>0){
					freq_code     = 	(String)freqCode.get(0);
					freq_nature   =    (String)FreqNature.get(0);
					 freq_durn_type = bean.getFreqDurnType(freq_code);//TBMC-SCF-0167
						
					if(freq_nature.equals("I") || freq_nature.equals("O"))
						scheduled_yn = "N";
					else
						scheduled_yn = "Y";
					//TBMC-SCF-0167
					if(freq_durn_type==null || freq_durn_type.equals(""))
						freq_durn_type = durn_type ;
					else
						 durn_type = freq_durn_type ; 

					drugDetails.put("FREQ_NATURE",freq_nature);
					drugDetails.put("FREQ_CODE",freq_code);
					drugDetails.put("SCHEDULED_YN",scheduled_yn);
					//TBMC-SCF-0167 - start
					drugDetails.put("DOSAGE_TYPE",dosage_type); 
					drugDetails.put("DURN_TYPE",freq_durn_type);
					drugDetails.put("FREQ_DURN_TYPE",freq_durn_type);
					drugDetails.put("REPEAT_DURN_TYPE",freq_durn_type);
					drugDetails.put("DEF_DOSAGE_TYPE",def_dosage_type);//ADDED FOR TBMC-SCF-0176
					//TBMC-SCF-0167 - end
				}
			} //added for TBMC-SCF-0166 - end
			drugDetails.put("DEF_DOSAGE_TYPE",def_dosage_type);//ADDED FOR TBMC-SCF-0176
			for(int i=0;i<freqCode.size();i++){
				if( dup_found ) {
					if( ((String) FreqNature.get(i)).equals("O")) {//(bean.getFreqNature(((String) freqCode.get(i))))
						freq_option		+=	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
						freq_nature	=	"O";
						freq_code	=((String) freqCode.get(i));
						def_freq_found = true;
					}
				} 
				else {
					//if( !(bean.getFreqNature(((String) freqCode.get(i)))).equals("P")) {
					if(((String) freqCode.get(i)).equals(freq_code)) {
						freq_option		+=	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
						def_freq_found = true;
					}
					else {
						freq_option		+=	"<option value='"+((String) freqCode.get(i))+"'>"+((String) freqDesc.get(i))+"</option>";
					}
					//}
				}
			}
		}
		else if(dup_found) {
			ArrayList stat_freqs	=	presBean.loadStatFreqs();					
			for(int i=0;i<stat_freqs.size();i+=2){
				freq_option		+=	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
				freq_nature	=	"O";
				freq_code	=((String) stat_freqs.get(i));
				def_freq_found = true;
			}
		} 
		if(freq_option.equals("")) {
			ArrayList stat_freqs	=	presBean.loadStatFreqs();					

			for(int i=0;i<stat_freqs.size();i+=2){
				freq_option		+=	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
				def_freq_found = true;
				freq_nature	=	"O";
				freq_code	=((String) stat_freqs.get(i));
			}
		} 
		HashMap chkValuescheduleFrequency	=	null;
		ArrayList frequencyValues			=	null;
		chkValuescheduleFrequency			= bean.getscheduleFrequency();
		if(chkValuescheduleFrequency!= null && chkValuescheduleFrequency.size()>0){
			frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(drug_code+srl_no);
		}
		if(bean.getTakeHomeDates()!=null && bean.getTakeHomeDates().size()>0){// Added  for INC#49425--start
			start_date1 = (String)bean.getTakeHomeDates().get(0);
			end_date1=(String)bean.getTakeHomeDates().get(1);
			tempstartdate1 = start_date1;
			tempenddate1 = end_date1;
			sys_date=(String) presBean.getSysdate();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
			java.util.Date stdate =sdf.parse(start_date1);
			java.util.Date sydate  = sdf.parse(sys_date);
			if(stdate.compareTo(sydate)<0){
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
				tempstartdate1 = formatter.format(sydate);
				String tempendString  = end_date1.substring(0, 10);
				String systempString =tempstartdate1.substring(11, tempstartdate1.length());
				tempenddate1 = tempendString.concat(" "+systempString);
			}
			else if(stdate.compareTo(sydate)>0){
				String tempendString = end_date1.substring(0, 10);
				String systempString =start_date1.substring(11, start_date1.length());
				tempenddate1 = tempendString.concat(" "+systempString);
			}
			
			String checked_yn = bean.getHome_leave_checked();
			if(checked_yn==null)
				checked_yn = "";
			if(checked_yn.equalsIgnoreCase("Y")){
				if(presDetails!=null && presDetails.size()>0 && (!amend_yn.equals("Y"))){
					start_date = tempstartdate1;
					end_date = tempenddate1;
				}
			}
		}//Added for INC#49425--end
		//Added for ICN28477 - Start
		Hashtable sch_output	=	null;
		Hashtable schedule_val	=	null;
		HashMap temp_freq_chars =	null;
		if(freq_nature!=null && !freq_nature.equals("P") && !freq_nature.equals("O")  && freq_code!=null && !freq_code.equals("") && scheduled_yn.equals("Y")){ //if condition added for SKR-SCF-0099 IN29037
			if(chkValuescheduleFrequency==null || frequencyValues == null ){
				String sch_bean_id		= "OrScheduleFreq" ;
				String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
		 
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
				sch_output.put("row_value",srl_no);
				sch_output.put("start_date_time",start_date);

				putObjectInBean(sch_bean_id,schedule_bean,request);
			} 
			if(sch_output!=null) {
				ArrayList values	=	presBean.getFreqDet(order_id,ord_line_no);
				ArrayList freqCharctValues = new ArrayList();
				ArrayList day_list = new ArrayList();
				ArrayList dose_list = new ArrayList();
				ArrayList day_names = new ArrayList();
				ArrayList time_list = new ArrayList();
				frequencyValues	= new ArrayList();
				ArrayList<String> week_days	= new ArrayList<String>();
				week_days = bean.getDayOfWeek(com.ehis.util.DateUtils.convertDate(start_date, "DMYHM",locale, "en")); 
				freqCharctValues = (ArrayList)sch_output.get(drug_code+srl_no);	
				for(int p=0; p<values.size(); p+=4) {
					time_list.add(values.get(p));
					dose_list.add(values.get(p+1));
					day_list.add((values.get(p+3)==null)?"0":values.get(p+3));
				}
				
				if(day_list.size()>0 && ((String)((HashMap)((ArrayList)sch_output.get(drug_code+srl_no)).get(0)).get("durationType")).equals("W")){
					for(int j=0;j<day_list.size();j++){
						if(!day_list.get(j).equals("")){
							String temp = (String)day_list.get(j);

							if (temp == null || temp.equals(""))
								temp = "0";
							if (!temp.equals("0"))
								day_names.add(week_days.get((Integer.parseInt(temp))-1));
						}
					}
				}
				if(freqCharctValues !=null)
					frequencyValues.add(freqCharctValues.get(0));
				else
					frequencyValues.add("");
				frequencyValues.add(day_list);
				frequencyValues.add(day_names);
				frequencyValues.add(time_list);
				frequencyValues.add(dose_list);
				sch_output.put(drug_code+srl_no,frequencyValues);

				bean.setScheduleFrequencyStr(sch_output);
			}
		}
		//Added for ICN28477 - END


		selected_disp				=	bean.getDispLocation(srlNo);
		String legend_style	=	"display:none;color:red;font-weight:bold;";
		String oth_style	=	"display:none";
		String sch_style	=	"";

		if(freq_nature.equals("P"))
			sch_style		=	"display:none";

//		if(freq_nature.equals("P") && !absol_qty.equals("")) {
		if(!absol_qty.equals("")) {
				legend_style	=	"display:inline;color:red;font-weight:bold;";
				oth_style		=	"display:inline";
/*=================================================================================================================*/
//added for IN26583 --17/02/2011-- priya
			if(((int)(Float.parseFloat(absol_qty)/1)) == Float.parseFloat(absol_qty))
			{
				absol_qty = ((int)(Float.parseFloat(absol_qty)/1))+"";
			}

/*=================================================================================================================*/
				
		}
		if(freq_nature.equals("O"))
			sch_style		=	"display:none";

		if(!prn_remarks_dtl.equals("")) {
			prn_remarks_dtl	=	"true";
		}
		else{
			prn_remarks_dtl	=	"false";
		}
		String amend_mode_disable = "";
		if(mode.equals("amend")){
			amend_mode_disable = "disabled";
		}

		if( !mode.equals("blank") ) {
			DurnDescDetails	= (Hashtable)presBean.loadDurnDesc();
			Enumeration keys_des		= DurnDescDetails.keys();
			String	durn_code			= "";
			while(keys_des.hasMoreElements()){
				durn_code		= (String)keys_des.nextElement();
				if(durn_type.equals(durn_code))
					duration_option	= duration_option + "<option value='"+durn_code+"' selected>"+((String)DurnDescDetails.get(durn_code))+"</option> ";
				else
					duration_option	= duration_option + "<option value='"+durn_code+"'>"+((String)DurnDescDetails.get(durn_code))+"</option>";
			}
		}
%>
		<form name="prescription_detail_form" id="prescription_detail_form">
			<input type="hidden" name="tmp_durn_value" id="tmp_durn_value" value="<%=freq_durn_value%>">
						<input type="hidden" name="tmp_durn_desc" id="tmp_durn_desc"  value="<%=freq_durn_type%>">	
						<!-- <input type="hidden" name="durn_desc" id="durn_desc" value="<%=repeat_durn_type%>" > -->
						<input type="hidden" name="durn_unit" id="durn_unit" value="<%=durn_type%>" > <!--priya -->
						<input type="hidden" name="freq_chng_durn_desc" id="freq_chng_durn_desc" value="<%=freq_chng_durn_desc%>" >
			<input type="hidden" name="qty_value" id="qty_value" value="<%=qty_value%>" size="3" maxlength="6" style="text-align:right" onchange="lookForChange(this);" onKeyPress="return allowValidNumber(this,event,8,<%=dose_decimal%>);">
			<input type="hidden" name="qty_unit" id="qty_unit" value="<%=qty_unit%>" >
			<input type="hidden" name="qty_desc" id="qty_desc" value="<%=qty_unit%>" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<th  colspan="11"><font style="font-size:9"><fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/></font></th>
				<tr>
				<!--	<td  class="label" width="9%"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/>
					</td>
					<td  class="label" width="17%">
						<input type="hidden" name="qty_value" id="qty_value" value="<%=qty_value%>" size="3" maxlength="6" style="text-align:right" onchange="lookForChange(this);" onKeyPress="return allowValidNumber(this,event,8,<%=dose_decimal%>);">
						<input type="hidden" name="qty_unit" id="qty_unit" value="<%=qty_unit%>" >
						<input type="hidden" name="qty_desc" id="qty_desc" value="<%=qty_unit%>" ><!-- This is to default the unit on click of schedule button-->
						<!-- <label><b><%=qty_desc%></b></label> -->
					<!-- </td> -->
					<td class="label" width="13%"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
					<td width="22%" colspan =4>
						<select name="frequency" id="frequency" onChange="freqChange(this,'Y','Y');getChargeDetails('<%=in_formulary_yn%>');assignHomeDurationsliding();" style="width:465;"><!-- Added assignHomeDurationsliding() for INC#49425 -->
							<%=freq_option%>
						</select>
					&nbsp;
						<input type="button" name="btnSchedule" id="btnSchedule" value='<fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>' id="dis_split_dose" class="button" onClick="DisplaySchedule()" style="<%=sch_style%>">
					</td>
							
				</tr>
				<tr>
				    <td class="label" >
						<label id="lgd_ord_qty" ><fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/></label>
					</td>
				    <td class="field" >
						<input type="text" name="absol_qty" id="absol_qty" style="<%=oth_style%>" size="3" maxlength="3" class='NUMBER' value="<%=absol_qty%>" onBlur="ValidateAbs(this);CheckPositiveNumber(this);freqChange(frequency,'Y','Y');getChargeDetails('<%=in_formulary_yn%>','ABS_QTY');">&nbsp;
						<label id="lgd_qty_uom" style="<%=oth_style%>"><%=stock_Details_uom%></label>
						<a href="javascript:callPRNDetails();" id="prn_remarks" style="visibility:hidden" title="PRN Remarks"><fmt:message key="ePH.PRNRemarks.label" bundle="${ph_labels}"/></a>
						<img align="center" style="visibility:hidden"  id="prn_remarks_image" src="../../eCommon/images/mandatory.gif"></img>
					</td>	
					<td  class='label' colspan="2"><fmt:message key="Common.duration.label" bundle="${common_labels}"/>&nbsp;&nbsp;
						<input type="text" name="durn_value" id="durn_value" value="<%=durn_value%>" maxlength="3" size="2" style="text-align:right" onBlur="validateDuration(this,'','Y');durationConversn(document.prescription_detail_form.durn_desc);populateEndDate();getChargeDetails('<%=in_formulary_yn%>');assignHomeDurationsliding();" onKeyPress="return(ChkNumberInput(this,event,'0'));" onchange='extDosageCheck();'><!-- Added 	assignHomeDurationsliding() for INC#49425 -->
						
						<!-- <select name="durn_desc" id="durn_desc" onChange="maxDurnValidation();durationConversn(this);"> //this code is commented. because this calls prescription_2.js methods. but that js never included in this jsp -->
						
						<select name="durn_desc" id="durn_desc" onChange="validateDuration(document.prescription_detail_form.durn_value,'','Y');durationConversn(this);populateEndDate();getChargeDetails('<%=in_formulary_yn%>');assignHomeDurationsliding();"><!-- Added assignHomeDurationsliding() for INC#49425 -->
						<!-- validateAllDates(); -->
							<option>-<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>-</option>
							<%=duration_option%>
						</select>
						
					</td>	
					<td class="label"  id="dosage_label">&nbsp;</td>
				</tr>
            <tr>
                <td class='label' ><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/>&nbsp;</td>
					<td>
						<input type="text" name="start_date" id="start_date" value="<%=start_date%>" size="13" maxlength="16"  onblur="chkBackFutureDate(this);assignHomeDurationsliding();" <%=amend_mode_disable%>><img SRC="../../eCommon/images/CommonCalendar.gif" name='stateDateImg'  onclick="if(document.prescription_detail_form.start_date.disabled){return false;};showCalendar('start_date',null,'hh:mm');document.prescription_detail_form.start_date.focus();return false;" ><!-- Added 	assignHomeDurationsliding() for INC#49425 -->			
					</td>
					<td width="28%" class='label' ><fmt:message key="Common.enddate.label" bundle="${common_labels}"/>&nbsp;
						<input type="text" name="end_date" id="end_date" value="<%=end_date%>" size="13" maxlength="16" tabindex='5' readonly onblur="validateEndDate(this,'<%=locale%>');" <%=amend_mode_disable%>><img SRC="../../eCommon/images/CommonCalendar.gif"  name='endDateImg' onclick="if(document.prescription_detail_form.end_date.disabled){return false;};showCalendar('end_date',null,'hh:mm');document.prescription_detail_form.end_date.focus();return false;" > 
					</td>	
<%
					if(current_rx != null && current_rx.equals("Y") && allow_duplicate != null && allow_duplicate.equals("N") ) { //&& (patient_class.equals("IP")||  take_home>0)
%>
						<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
<%
					}
					else {	
%>
<% 
								//if(!(PhLicenceRights.getKey()).equals("PHBASIC") ) { 	
%>
									<td class="label" nowrap><fmt:message key="ePH.DispenseLocation.label"  bundle="${ph_labels}"/></td>
									<td class="label"  >
<%
		// Dispense Location is displayed in list or text based on the no of values
	    // the below code for list box For External Prescription
									if(bean.getExternalpatient_id()!=null && !bean.getExternalpatient_id().equals("")) {
										ArrayList ExternalPresDispCodes = new ArrayList();
										ExternalPresDispCodes			= bean.getExternalPresDispCodes();
										ArrayList ExternalPresDispDesc	= new ArrayList();
										ExternalPresDispDesc			= bean.getExternalPresDispDesc();
%>
										<select name="disp_locn_code" id="disp_locn_code">
<%		
										for(int k=0; k<ExternalPresDispCodes.size(); k++) { 
											if(selected_disp.equals((String)ExternalPresDispCodes.get(k)) ) {
%>
												<option value="<%=(String)ExternalPresDispCodes.get(k)%>" selected><%=(String)ExternalPresDispDesc.get(k)%></option>
<%
											}
											else if(selected_disp.equals("") && !entered){	
												entered	=	true;
%>
												<option value="<%=(String)ExternalPresDispCodes.get(k)%>" selected><%=(String)ExternalPresDispDesc.get(k)%></option>
<%
											}
											else {	
%>
												<option value="<%=(String)ExternalPresDispCodes.get(k)%>"><%=(String)ExternalPresDispDesc.get(k)%></option>
<%
											}
										}	
%>
										</select>
<%  
									}
									else if(code.size() > 1 ) {
%>
										<select name="disp_locn_code" id="disp_locn_code">
<%		
										for(int k=0; k<code.size(); k++) { 
											if(selected_disp.equals((String)code.get(k)) ) {
%>
												<option value="<%=(String)code.get(k)%>" selected><%=(String)desc.get(k)%></option>
<%
											}
											else	if(selected_disp.equals("") && !entered){	
												entered	=	true;
%>
												<option value="<%=(String)code.get(k)%>" selected><%=(String)desc.get(k)%></option>
<%
											}
											else {
%>
												<option value="<%=(String)code.get(k)%>"><%=(String)desc.get(k)%></option>
<%
											}
										}	
%>
										</select>
<%  // below code for text box
									}
									else { 
%>
										<input type="text" size="20" maxlength="20" name="disp_locn_desc" id="disp_locn_desc" disabled value="<%=disp_locn_desc%>">
										<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
<%	
									}
%>
								</td>
<%	
							/*}
							else {	*/
%>
							<!-- 	<td class="label"   >&nbsp;</td>
								<td class="label" ><input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>"></td> -->
<%
							//}	


			}	
%>

          </tr>

			</table>
<%
			if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
%>
				<INPUT TYPE="hidden" name="sql_ph_prescription_bl_action_select_lookup" id="sql_ph_prescription_bl_action_select_lookup" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_PRESCRIPTION_BL_ACTION_SELECT_LOOKUP") %>">						
<%
			}
%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">

				<tr id='BL_HEADERBAR' style='display:none;'>
					<%//added for ml-bru-crf-0469
					if(displayGrossAmtYn){ %>
						<td class='COLUMNHEADER' colspan="7" style="font-size:9" ><fmt:message key="Common.ChargeDetails.label" bundle="${common_labels}"/>	
						<%}else{ %>
						<td class='COLUMNHEADER' colspan="6" style="font-size:9" ><fmt:message key="Common.ChargeDetails.label" bundle="${common_labels}"/>	
						<%   }	 %>
				</tr>
				<tr id='BL_HEADER' style='display:none;'>
					 <td class="label" width='9%'><fmt:message key="Common.Included.label" bundle="${common_labels}"/>
					</td>
					<td class="label" width='9%' id='bl_override_excl_incl_ind_lbl'><fmt:message key="ePH.OverrideIncl/Excl.label" bundle="${ph_labels}"/>
					</td>
						<%//added for ml-bru-crf-0469
						if(displayGrossAmtYn){ %>
						<td  class="label" width='40%'><fmt:message key="Common.reason.label" bundle="${common_labels}"/>
						</td>
							<%}else{%>
							<td  class="label" width='30%'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
								<%}%>
					<%//added for ml-bru-crf-0469
						if(displayGrossAmtYn){ %>
						<td class="label" nowrap width='10%' style='TEXT-ALIGN:center;'> <fmt:message key="ePH.GrossAmount.label" bundle="${ph_labels}"/>
						</td>
						<%}%>
					<td class="label" nowrap width='13%' style='TEXT-ALIGN:center;'><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/>
					</td>
					<td class="label"  width='20%'style='TEXT-ALIGN:center;'><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>
					</td>
					<td class="label" width='9%'><fmt:message key="ePH.ApprovalReqd.label" bundle="${ph_labels}"/>
					</td>
				</tr>
				<tr id='BL_VALUES' style='display:none;'>
					 <td align='center' id='bl_def_override_excl_incl_ind_gif'>&nbsp;
					</td>
					<td class="label" id='td_bl_override_excl_incl_ind'>
					<%     
					include_selected ="";  
					exclude_selected =""; 	
					Select_selected  ="";


				   if(bl_override_excl_incl_ind.equals("I")){
						include_selected ="selected";
					}else if(bl_override_excl_incl_ind.equals("E")){
						exclude_selected ="selected";
					}else {
						Select_selected ="selected";
					}
%>

				<input type = "hidden" name = "bl_override_excl_incl_ind_amend_load" value = "<%=bl_override_excl_incl_ind%>">
                      <select name="bl_override_excl_incl_ind" id="bl_override_excl_incl_ind" onchange="assignOverrideExclInclInd(this)"  >
						  <!--  <option value="SEL">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option> --> 

							<%if(bl_override_allowed_yn.equals("I")){%>
							     <option value="SEL"<%=Select_selected%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
								<option value="I" <%=include_selected%>><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>

							<%}if(bl_override_allowed_yn.equals("E")){%>
							     <option value="SEL"<%=Select_selected%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
								<option value="E" <%=exclude_selected%> ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>

							<%}if(bl_override_allowed_yn.equals("B")){%>
							    <option value="SEL"<%=Select_selected%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							    <option value="I" <%=include_selected%> ><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
							    <option value="E" <%=exclude_selected%> ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
							 <%}%>								
							 <%if(bl_override_allowed_yn.equals(""))%>
							      <option value="SEL"selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>

						</select>
						</td>

					</td>
					<input type='hidden' name='bl_def_override_excl_incl_ind' id='bl_def_override_excl_incl_ind' value='<%=bl_def_override_excl_incl_ind%>'>
					<input type='hidden' name='bl_override_allowed_yn' id='bl_override_allowed_yn' value='<%=bl_override_allowed_yn%>'>
					<td class="label" nowrap>
						<input type='text' name='bl_incl_excl_override_reason_desc' id='bl_incl_excl_override_reason_desc' size='40'  value='<%=bl_incl_excl_override_reason_desc%>' readonly >
<%
					if(bl_incl_excl_override_reason_desc.equals("")){
%>										
						<input type="button" name="bl_overriden_action_reason_lkp" id="bl_overriden_action_reason_lkp" value="?" class="button" onClick="searchBLOverrideReason('<%=locale%>');" disabled><img  src="../../eCommon/images/mandatory.gif" id='bl_overriden_action_reason_img' style='visibility:hidden;'></img>
<%
					}
					else{
%>
						<input type="button" name="bl_overriden_action_reason_lkp" id="bl_overriden_action_reason_lkp" value="?" class="button" onClick="searchBLOverrideReason('<%=locale%>');"><img  src="../../eCommon/images/mandatory.gif" id='bl_overriden_action_reason_img' style='visibility:visible;'></img>
<%
					} 
%>
						<input type='hidden' name='bl_incl_excl_override_reason_code' id='bl_incl_excl_override_reason_code' value='<%=bl_incl_excl_override_reason_code%>'>
					</td>
					<%	//added for ml-bru-crf-0469
					if(displayGrossAmtYn){ %>
						<td class="data" id='gross_charge_amt' align='center'>
						</td>
					<%	} else{ %>
					   <td class="data"  id='gross_charge_amt' align='center' style='display:none;'>
						</td>
						<%} %>
					<td class="data" id='bl_total_charge_amt' align='center'>
					</td>
					<td class="data" id='bl_patient_payable_amt' align='center'>
					</td>
					<td align='center'id='bl_approval_reqd_yn'>
					</td>
				</tr>
			</table>
			<input type="hidden" value="<%=presBean_id%>" name="presBean_id">
			<input type="hidden" value="<%=presBean_name %>" name="presBean_name">
			<input type="hidden" value="<%=ext_prod_id%>" name="ext_prod_id">
			<input type="hidden" value="<%=back_date%>"   name="back_date">
			<input type="hidden" value="<%=future_date%>" name="future_date">
			<input type="hidden" value="<%=freq_nature%>" name="freq_nature">
			<input type="hidden" value="<%=freq_value%>" name="freq_value">
			<input type="hidden" value="<%=interval_value%>" name="interval_value">
			<input type="hidden" value="<%=repeat_durn_type%>" name="repeat_durn_type">
			<input type="hidden" value="N" name="allow_refill" id="allow_refill">
			<input type="hidden" value="<%=bean_id%>" name="bean_id">
			<input type="hidden" value="<%=bean_name%>" name="bean_name">
			<input type="hidden" value="<%=mode%>" name="mode">
			<input type="hidden" value="<%=mode%>" name="source">
			<input type="hidden" value="<%=patient_id%>" name="patient_id">
			<input type="hidden" value="<%=encounter_id%>" name="encounter_id">	
			<input type="hidden" value="<%=drug_code%>" name="drug_code">
			<input type="hidden" value="<%=srl_no%>"    name="srl_no">
			<input type="hidden" value="<%=srl_no%>"    name="rowVal">
			<input type="hidden" value="<%=scheduled_yn%>" name="scheduled_yn">
			<input type="hidden" value="<%=(String)session.getValue("facility_id")%>"    name="facility_id">
			<input type="hidden" value="<%=daily_dose%>"    name="daily_dose">
			<input type="hidden" value="<%=unit_dose%>"    name="unit_dose">
			<input type="hidden" value="<%=split_dose_yn%>"    name="split_dose_yn">
			<input type="hidden" value="<%=split_dose_yn%>" name="split_dose_yn_val">
			<input type="hidden" value="N"    name="qty_reqd_yn" id="qty_reqd_yn">
			<input type="hidden" value="<%=sch_over_yn%>"    name="sch_over_yn">
			<input type="hidden" value="<%=mode%>" name="calling_mode">
			<input type="hidden" value="<%=repeat_value%>" name="repeat_value">
			<input type="hidden" value=""  name="split_dose" id="split_dose">
			<input type="hidden" value=""  name="admin_time" id="admin_time">
			<input type="hidden" value=""  name="admin_qty" id="admin_qty">
			<input type="hidden" name="taper_disable" id="taper_disable" value=""><!-- Added for IN 044131 -->
			<input type="hidden" value="Y" name="sliding_scale_yn" id="sliding_scale_yn">
			<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
			<input type="hidden" value="<%=refill_cont_order_yn%>" name="refill_cont_order_yn">
			<input type="hidden" value="Q" name="dosage" id="dosage">
			<input type="hidden" value="" name="calcualted_durn_value" id="calcualted_durn_value">
			<input type="hidden" value="<%=dosage_type%>" name="dosage_type">
			<input type="hidden" value="<%=generic_id%>" name="generic_id">
			<input type="hidden" name="init_qty" id="init_qty" value="<%=qty_value%>">
			<input type="hidden" name="prn_dose" id="prn_dose" value="<%=prn_dose%>">
			<input type="hidden" name="prn_yn" id="prn_yn" value="<%=prn_yn%>">	
			<input type="hidden" name="prn_remarks_flag" id="prn_remarks_flag" value="<%=prn_remarks%>">	
			<label id="ord_qty_lbl"></label>
			<label id="ord_qty_uom"></label>		
			<input type="hidden" name="allow_duplicate" id="allow_duplicate" value="<%=allow_duplicate%>">
			<input type="hidden" value="<%=dsg_reason%>" name="dsg_reason">
			<input type="hidden" value="<%=dup_reason%>" name="dup_reason">
			<input type="hidden" value="<%=con_reason%>" name="con_reason">
			<input type="hidden" value="<%=int_reason%>" name="int_reason">
			<input type="hidden" value="<%=alg_reason%>" name="alg_reason">
			<input type="hidden" value="<%=fract_dose_appl_yn%>" name="fract_dose_appl_yn">
			<input type="hidden" value="<%=fract_dose_round_up_yn%>" name="fract_dose_round_up_yn">
			<input type="hidden" value="<%=in_formulary_yn%>" name="in_formulary_yn">
			<input type="hidden" value="<%=calc_def_dosage_yn%>" name="calc_def_dosage_yn">
			<input type="hidden" value="<%=def_freq_found%>" name="def_freq_found">
			<input type="hidden" value="<%=order_type_code%>" name="order_type_code">
			<input type="hidden" value="<%=form_code%>" name="form_code">
			<input type="hidden" value="<%=route_code%>" name="route_code">
			<input type="hidden" value="<%=DurnDescDetails%>" name="DurnDescDetails">
			<input type="hidden" value="<%=max_durn_value%>" name="max_durn_value">
			<input type="hidden" value="<%=chk_for_max_durn_action%>" name="chk_for_max_durn_action">
			<input type="hidden" value="<%=force_auth_yn%>" name="force_auth_yn">
			<input type="hidden" value="<%=amend_yn%>" name="amend_yn">
			<input type="hidden" value="<%=billable_item_yn%>" name="billable_item_yn">
			<input type='hidden' name='totalTaperQtyDisplay' id='totalTaperQtyDisplay' value='N'>
			<input type="hidden" value="<%=strength_per_pres_uom%>" name="strength_per_pres_uom">
			<input type="hidden" value="<%=strength_per_value_pres_uom%>" name="strength_per_value_pres_uom">
			<input type="hidden" name="take_home_start_date" id="take_home_start_date" value="<%=start_date1%>"><!--Added for INC#49425-->
			<input type="hidden" name="take_home_end_date" id="take_home_end_date" value="<%=end_date1%>"><!--Added for INC#49425-->
			<input type="hidden" name="pregnency_yn" id="pregnency_yn" value=""><!--Added for INC#49425-->
			<input type="hidden" name="priority" id="priority" value=""><!--Added for INC#49425-->
			<input type="hidden" name="chk_missing_sch_yn" id="chk_missing_sch_yn" value="N"><!--ADDED for ARYU-SCF-0033-->
			<input type="hidden" value="" name="preg_remarks" id="preg_remarks" ><!--Added for ARYU-SCF-0033-->
			<input type="hidden" value="" name="preg_effect" id="preg_effect"><!--Added for ARYU-SCF-0033-->
			<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
				<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" align="center">
					<tr><td width="100%" id="t"></td></tr>
				</table>
			</div>
			<script>
			
			assignDurnTypeList('<%=DurnDescDetails%>'); 
			//reloadDurnTypeList('Y'); //here commented by rawther for for scf 7732
			//dfltDurnDesc('<%=durn_type%>'); //Commented for SKR-SCF-0099 [IN:029037] -Reopend(when thr is no dflt freq setup & max durn exceeds the frq durn)
		//	dfltDurnDesc('<%=freq_chng_durn_desc%>');
<% 
				if(mode.equals("blank")){
%>
					disableItems();
<% 
				}
				else { 
			//if no default frequency(order catalog) matches with the applicable frequency list with respect to patient class
					if(!def_freq_found){
%>
						
						alert(getMessage("PH_NORMAL_RX_DEFAULT_FREQ_NOT_FOUND",'PH'));
						freqChange(document.prescription_detail_form.frequency,"Y",'Y');
<%
					}
%>
	           //     freqChange(document.prescription_detail_form.frequency,"Y",'Y');  //commented for IN22255 --23/06/2010 --priya
				//	dfltDurnDesc('<%=durn_type%>'); //Commented for SKR-SCF-0099 [IN:029037] -Reopend
				//	dfltDurnDesc('<%=freq_chng_durn_desc%>');
					populateEndDate();
					//getFormatId();  //commeted for SKR-SCF-0140
<%	
				}
				HashMap data		=	null;
				String att			=	null;
				String adm_time		=	"";
				String adm_qty		=	"";
				float total_qty	=   0.0f;
				ArrayList dose_list = new ArrayList();
				if(frequencyValues!=null && frequencyValues.size()>0 && def_freq_found){
					//if(def_freq_found){
/*						adm_time+="<tr>";					
						for(int i=0;i<frequencyValues.size();i++){
							data=(HashMap)frequencyValues.get(i);
							att="  class=TIP";
							adm_time+="<td "+att+">&nbsp;"+data.get("admin_time")+"&nbsp;</td>";
						}
						adm_time+="</tr>";
						adm_qty+="<tr>";
						for(int i=0;i<frequencyValues.size();i++){
							att="  class=TIP";
							data=(HashMap)frequencyValues.get(i);
							adm_qty+="<td "+att+">&nbsp;"+data.get("admin_qty")+"&nbsp;</td>";
							total_qty=(String) data.get("admin_qty");
						}
						adm_qty+="</tr>";*/

						dose_list	= (ArrayList)frequencyValues.get(4);
						for(int tqI=0;tqI<dose_list.size();tqI++){
							total_qty=total_qty+Float.parseFloat((String)dose_list.get(tqI));
						//	final_qty	=	(String)dose_list.get(tqI);
						}

						String tooltiptable = (String)bean.getTooltipStringFrFreq(frequencyValues,"Sliding");
						adm_time = tooltiptable;

						boolean split_chk	=	bean.checkSplit(frequencyValues);	
						
						// adm_qty is made "" coz for sliding scale drug, we need to display the qty only time should be displayed, once this is confirmed we can remove adm_qty from above code aswell
						adm_qty="";
						out.println("makeScheduleLink('"+adm_time+"','"+adm_qty+"','"+total_qty+"','"+frequencyValues.size()+"','"+split_chk+"','onLoad')");
					//}
				}
				else{
					out.println("getChargeDetails('"+in_formulary_yn+"')");
					if(dsg_reason.equals("") && dup_reason.equals("") && con_reason.equals("") && int_reason.equals("") && alg_reason.equals(""))
						out.println("extDosageCheck('onLoad')");
				}
%>
				if(document.prescription_detail_form.freq_nature.value=="P"){
					document.getElementById("prn_remarks").style.visibility	= "visible";
					document.getElementById("prn_remarks_image").style.visibility	= "visible";
					document.getElementById("dis_split_dose").style.visibility	= "hidden";
				}
			</script>
<%
			String drug_db_duptherapy_flag      = (String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG");
			if(current_rx != null && (current_rx.equals("Y") ||  drug_db_duptherapy_flag.equals("Y")) && allow_duplicate != null && allow_duplicate.equals("N") ) { //&& (patient_class.equals("IP")||  take_home>0)
				ArrayList curr_info		=	bean.getDuplicateDrugs(patient_id,generic_id);
				HashMap  dup_info		=	null;
				String dup_drug_info	=	"";

				if(curr_info.size()>=1) {
					dup_info	  =	(HashMap)curr_info.get(0);
					dup_drug_info =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PatientisCurrentlyOn.label", "ph_labels")+ " "+generic_name+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Medicationtill.label", "ph_labels")+"  "+dup_info.get("end_date")+";\n";
					dup_drug_info +=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Hasbeenprescribedby.label", "ph_labels")+" "+dup_info.get("practitioner_name")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.from.label", "common_labels")+" "+dup_info.get("location");
				}
%>
				<table border="0" width="100%" cellspacing="0" cellpadding="0">
					<tr>
						<td colspan="6" class="CURRTEXT">
						<marquee  scrollamount="4" ><font  style="font-weight:bold;color:black" size=1><%=dup_drug_info%></font></marquee>
						<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
						</td>
					</tr>
				</table>
<%
			}
			if(dup_found){
%>
				<script>
					setTimeout("freqChange(document.prescription_detail_form.frequency,'','Y');",200);
				</script>	
<%
			}
%>
			<script>
<%			if(!amend_yn.equals("Y")){//Added for INC#49425--start
				if(!dup_found){//TBMC-SCF-0167
%>
		freqChange(document.prescription_detail_form.frequency,'Y','Y')	;
<%}%>
		calulateDurnValue('<%=start_date1%>','<%=end_date1%>','<%=locale%>','<%=tempstartdate1%>','<%=tempenddate1%>','<%=patient_class%>',"sliding");
<%
			}//Added for IN047223--end
%>
			</script>
		</form>
	</body>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(presBean_id,presBean,request);
%>
</html>


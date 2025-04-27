
<%-- JSP Page specific attributes start --%> 
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eST.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" pageEncoding="ISO-8859-1"  %> 
<%-- Mandatory declarations start --%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%  
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
02/07/2017	  	IN061197	     	Mukesh M 		  									AAKH-CRF-0091 [IN061197] 
07/01/2019	  	IN068344	     	Manickavasagam 	 	  								GHL-CRF-0549 [IN068344] 
26/07/2019      IN070451		    B Haribabu   26/07/2019     Manickam                ML-MMOH-CRF-1408
16/4/2020		IN072609			Shazana												SKR-SCF-1317
14/5/2020		IN072851		Shazana		14/5/2020	Manickam				TBMC-SCF-0176
29/05/2020		IN072753           Prabha											   NMC-JD-CRF-0046
10/06/2020              IN:072715              Haribabu                                   MMS-DM-CRF-0165
14/07/2020		IN:073365			Prabha                  							SKR-SCF-1385
15/07/2020		IN073431			Manickavasagam                  						MMS-KH-SCF-0080 
28/07/2020              IN:073485                   Haribabu                                PH-MMS-DM-CRF-0165/01-Normal rx-Amend order
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
20/10/2020      IN:069886         Haribabu                       Manickam            MO-CRF-20151
05/01/2021	 TFS id:7345           Haribabu	      05/01/2021       Manickavasagam J			     MMS-DM-CRF-0177
22-05-2022                        prathyusha                                           AAKH-CRF-0140
23/05/2023   43528                SREENADH.M                   Suhail                  ML-MMOH-CRF-1823
--------------------------------------------------------------------------------------------------------------
*/ 
request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086		
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>
		<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>  
		  
		<link rel="Stylesheet" href="../../eCommon/html/jquery-ui.css" />  
		<!--  //added for PMG2012-CRF-0019 [IN:035859] AutoComplete -start 
		  
		<link rel="Stylesheet" href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/themes/redmond/jquery-ui.css" /><!--//added for PMG2012-CRF-0019 [IN:035859] AutoComplete -end-->
	</head>
	<!-- Added for Bru-HIMS-CRF-0265 [IN032315] -- begin	-->
	<!--<script language="VBScript">
		Function vbConfirm(msg)
		   butVal = 32 + 4 + 0 + 0
		   vbConfirm = MsgBox(msg,butVal,"Duplicate Drug")
		End Function
	</script>-->
	<script language="Javascript">

function jsConfirm(msg) {        
return confirm(msg); 
}
 </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- Added for Bru-HIMS-CRF-0265 [IN032315] -- end	-->
	<script> //added for PMG2012-CRF-0019 [IN:035859] AutoComplete -start
		$(document).ready(function(){
			$(function() {
				var drug_seach_autocomplete_yn	= parent.f_header.document.prescription_header_form.drug_seach_autocomplete_yn.value;
				if(drug_seach_autocomplete_yn =='Y'){
					var pract_type		= parent.f_header.document.prescription_header_form.pract_type.value;
					var practitionerId	= parent.f_header.document.prescription_header_form.pract_id.value;
					var resp_id			= parent.f_header.document.prescription_header_form.resp_id.value;
					var res_by_service	=parent.f_header.document.prescription_header_form.service_search_yn.value;
					var service_code	=parent.f_header.document.prescription_header_form.servide_code.value;
					var take_home_medication_yn = parent.f_header.document.prescription_header_form.take_home_medication.value;
					var patient_class;
					if(take_home_medication_yn=='Y')
						patient_class = parent.f_header.document.prescription_header_form.patient_class.value;
					else
						patient_class = parent.f_header.document.prescription_header_form.actual_patient_class.value;
					var patient_id = parent.f_header.document.prescription_header_form.patient_id.value;
					var encounter_id= parent.f_header.document.prescription_header_form.encounter_id.value;
					var language_id= parent.f_header.document.prescription_header_form.language_id.value;
					var called_from_verbal_order= parent.f_header.document.prescription_header_form.called_from_verbal_order.value;
					var default_prev_drug_sel= parent.f_header.document.prescription_header_form.default_prev_drug_sel.value;
					var allow_priv_to_order_yn= parent.f_header.document.prescription_header_form.allow_priv_to_order_yn.value;
					$("#drug_name_id").autocomplete({          	
						source: function (request, response) {  
							var drugText=$('#drug_name_id').val();
							var xmlHttp = new XMLHttpRequest() ;
							$.ajax({  
								url : "/servlet/ePH.AutoCompleteServlet",
								data : {
									Event : "SEARCHDATA",
									pract_type : pract_type,
									practitionerId : practitionerId,
									resp_id : resp_id,
									res_by_service : res_by_service,
									service_code : service_code,
									take_home_medication_yn : take_home_medication_yn,
									patient_class : patient_class,
									patient_id : patient_id,
									encounter_id : encounter_id,
									drugText : drugText,
									called_from_verbal_order : called_from_verbal_order,
									default_prev_drug_sel : default_prev_drug_sel,
									drug_priv_ssn_ynm : allow_priv_to_order_yn,
									language_id : language_id
								},
								dataType: "json",  
								success:function (data){
									response(data);
									response($.map(data.data, function (items) {
										return {
											value: items.drug_name,
											id:items.drug_code +"~"+items.trade_code
										}
									}
								));
								}
							});  
						},
						minLength: 3,
						select:function (event, ui) {
							var drug_code = new Array();
							var trade_code = new Array();
							var codesList = ui.item.id.split("~");
							drug_code[0]=codesList[0];
							trade_code[0]=codesList[1];
							loadDrugDetails(drug_code,trade_code,'');
						}
					});
				}
			});
		});
	</script> <!-- //added for PMG2012-CRF-0019 [IN:035859] AutoComplete-end -->
<%
Connection con				= null;//added for ml-bru-crf-0469
try{

	HttpSession xx = request.getSession(false);
	Properties jdbc_props = (Properties)xx.getValue("jdbc");
	String patient_id				= "";
	String encounter_id				= "";
	String priority					= "";
	String hr_start_time			= "";
	String drug_code				= "";
	String srl_no					= "";
	String bsa						= "";	
	String prn_yn					="N";
	String man_rem_on_prn_freq_yn	="";
	String order_id					="";
	String order_set_code			="";
	String 	bed_num					= "" ;
	String 	room_num				= "";
	String drug_db_interface_yn		= "";
	String bl_install_yn			= "";
	String bl_disp_charge_dtl_in_rx_yn = "";
	String buildMAR_yn				= "";
	String MAR_app_yn				= "";
	String buildMAR_checked			= "";
	String buildMAR_enable			= "";
	String trade_display_yn			= "";
	int tapper_srl_no				= 1;
	int dose_decimal				= 6;
	String buildMAR_rule			= "";   	//  RUT-CRF-0062 [IN029600]  Added to get Build MAR Rule
	String buildMAR_rule_org="";//ADDED FOR SKR-SCF-1714
	String ext_disp_appl_yn                 =""; //Added for NMC-JD-CRF-0046
	String actionText				=	""; // add for SKR-CRF-0006[IN029561]
	String default_dosage_by					=	"";  //add this for SKR-CRF-PHIS-003[IN028182]
	String default_route_yn				=	"";
	String interaction_exists	=	"", intr_restric_trn="N", intr_msg_content="", interaction_override ="", severity_level="" ; //Added for	RUT-CRF-0066 IN[029604] 
	String abuse_exists	=	"", abuse_restric_trn="N", abuse_remarks="", abuse_override ="" ,abuse_action="",abuse_type="",abuse_override_remarks="";//added for AAKH-CRF-140
			String values_changed="";//added for ML-BRU-SCF-1231 [IN:046657]
 
	String calling_mode			= request.getParameter("mode") ==null?"blank": request.getParameter("mode");
	String modeC      = "";
	String order_idC  = "";
	String order_line = "";
	String taper_disable = ""; //Added for [IN:038913] Bru-HIMS-CRF-093/18
	String tapSlNo="";  //Added for RUT-CRF-0088 [IN036978]
	String tap_lvl_qty="";  //Added for RUT-CRF-0088 [IN036978]
	String freq_chng_durn_value=""; //Added for RUT-CRF-0088 [IN036978]
	String conv_factor=""; //Added for RUT-CRF-0088 [IN036978]
	boolean statFeqFound = false;
	boolean skip_dup_flag = true; //added for CRF-20085.1
	int no_of_days = 0;
	int supp_drug_count = 0; //Adding start for TH-KW-CRF-0007
	//GHL-CRF-0549 - start
	String disp_by_alt_form_drug = "";
	String disp_by_alt_form_param = "";
	String disabled = "";
	String checked  = ""; 	//GHL-CRF-0549 - end
	String drug_indication_mdry="";//added for jd-crf-0220
	
	modeC         = request.getParameter("modeC")==null?"":request.getParameter("modeC");
	order_idC     = request.getParameter("order_idC")==null?"":request.getParameter("order_idC");
	order_line    = request.getParameter("order_line")==null?"":request.getParameter("order_line");
	drug_code	  = request.getParameter("drug_code")==null?"":request.getParameter("drug_code") ;
	srl_no		  = request.getParameter("srl_no")==null?"":request.getParameter("srl_no") ;
	tapSlNo		  = request.getParameter("tapSlNo")==null?"":request.getParameter("tapSlNo") ;   //Added for RUT-CRF-0088 [IN036978]
	bsa			  = request.getParameter("bsa") ;
	MAR_app_yn    = request.getParameter("MAR_app_yn")==null?"Y":request.getParameter("MAR_app_yn");
	drug_db_interface_yn        = request.getParameter("drug_db_interface_yn")==null?"":request.getParameter("drug_db_interface_yn");
	bl_install_yn               = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
	bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
	trade_display_yn            = request.getParameter("trade_display_yn")==null?"Y":request.getParameter("trade_display_yn");

	patient_id		= request.getParameter("patient_id") ;
	encounter_id	= request.getParameter("encounter_id") ;
	priority		= request.getParameter("priority") ;
	hr_start_time	= request.getParameter("start_date") ;
	bed_num			= request.getParameter("bed_num")==null?"":request.getParameter("bed_num") ; 
	room_num		= request.getParameter("room_num")==null?"":request.getParameter("room_num") ;
	order_set_code	= request.getParameter("order_set_code")==null?"":request.getParameter("order_set_code");

	String patient_class		= request.getParameter("patient_class");
	String allow_without_diag	= request.getParameter("allow_without_diag");

	String frm_rx_button_yn			=request.getParameter("frm_rx_button_yn")==null?"N":request.getParameter("frm_rx_button_yn");
	String from_sliding_scale_yn			=request.getParameter("from_sliding_scale_yn")==null?"N":request.getParameter("from_sliding_scale_yn");
	String alternateOrder = request.getParameter("alternateOrder")==null?"N":request.getParameter("alternateOrder");//added for  JD-CRF-0198 [IN:058599]
	String pract_id = request.getParameter("pract_id")==null?"":request.getParameter("pract_id");//added for  ML-MMOH-CRF-01823
	String alternateDisable	=	"";//added for  JD-CRF-0198 [IN:058599]
	 con						= ConnectionManager.getConnection(request);//added for ml-bru-crf-0469
	boolean displayGrossAmtYn = CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN"); //ADDED for ML-BRU-CRF-0469
	boolean item_type_site_app = CommonBean.isSiteSpecific(con, "PH", "ITEM_TYPE_APP"); //added for GHL-CRF-0549
	boolean strength_display_app =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","STRENGTH_DISPLAY_APP");//added for NMC-JD-CRF-0026
	boolean over_ride_remarks_select_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_OVERRIDE_REASON_SELECT_APPL");//Added for IN:072715 
	boolean drug_abuse_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
	boolean quota_byPatient_Qty=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_QUOTA_LIMIT_FOR_DRUG");//ML-MMOH-CRF-1823 US008- 43528 
    //System.out.println("quota_byPatient_Qty>>>>>>>>>>>>>>>>>>>>>>>>>"+quota_byPatient_Qty);
	
	boolean req_diag_pres_found=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REQ_DIAG_PRES_FOUND");
	// added for ML-MMOH-CRF-1914 start
			boolean drugDosageLimitAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"PH", "PH_BEY_DOSE_PENCIL_ICON_PRN"); 
	
	String 		visable_dose_for_prn="";
			if(drugDosageLimitAppl){
				visable_dose_for_prn="validateDosageLimit('hideSchedLink');";
			}
			else
			{
				visable_dose_for_prn="";
			}
			// added for ML-MMOH-CRF-1914 end
			System.out.println("12.14.2.000.0.0.068"+req_diag_pres_found);
	//Added for IN:073485 
	String override_select_appl="N";
			if(over_ride_remarks_select_appl){
				override_select_appl="Y";
			}
	//Added for IN:073485 			
	if(allow_without_diag==null) 
		allow_without_diag	=	"Y";
	if(bsa==null) 
		bsa	=	"";
	if(priority==null)	 priority	=	"";

	if(alternateOrder.equals("Y"))//added for  JD-CRF-0198 [IN:058599]
		alternateDisable = "disabled";
	ArrayList presDetails				    =	null;
	HashMap drugDetails					    =	null;
	HashMap taperdrugDetails				=	null;//Added for  RUT-SCF-0321 [IN044816]
	HashMap taperDetails					=	null;//Added for  RUT-SCF-0321 [IN044816]
	String		extdrugCode					=	"";
	String		srlNo						=	"";
	String		allow_duplicate				=	"";
	//IN30118-SCF No: MO-GN-5400. Adding OutPatient Duplicate Drug Check.
	String		allow_duplicate_op			=	"";
	String ph_drug_overlap_period           =   ""; // Added for MO-CRF-20085.1 [IN057392]
        String previous_order_date              =   ""; // Added for MO-CRF-20085.1 [IN057392]
        String skip_duplicte_alert              =   ""; // Added for MO-CRF-20085.1 [IN057392]
	String		ext_prod_id				    =	"";
	String		drug_desc					=	"";
	String		drug_desc_new					=	"";//Added for TFS id:7345
	String		drug_search_by					=	"";//Added for TFS id:7345
	String		generic_id					=	"";
	String		generic_name				=	"";
	String		drug_class					=	"";
	String		form_code					=	"";
	String		form_desc					=	"";
	String		route_code					=	"";
	String		pres_base_uom				=	"";
	String		pres_base_uom_desc			=	"";
	String		strength_value				=	"";
	String		strength_uom				=	"";
	String		strength_uom_desc			=	"";
	String		strength_per_pres_uom		=   "";
	String		strength_per_value_pres_uom	= 	"";
	String		ord_auth_reqd_yn			= 	"";
	String		ord_authorized_prev_yn		= 	"";
	String		ord_spl_appr_reqd_yn		= 	"";
	String		ord_cosign_reqd_yn			= 	"";
	String		ord_authorized_yn			= 	"";
	String		ord_approved_yn				= 	"";
	String		ord_cosigned_yn				= 	"";
	String		consent_reqd_yn				= 	"";
	String		limit_ind					= 	"";
	String		daily_dose					= 	"";
	String		unit_dose					= 	"";
	String		min_daily_dose				= 	"";
	String		min_unit_dose				= 	"";
	String		mono_graph					= 	"";
	String		qty_value					=   "";
	String		tab_qty_value				= 	"";
	String		freq_code					= 	"";
	String		durn_value					= 	"";
	String		durn_type					= 	"";
	String		consider_stock_for_pres_yn	= 	"";
	String		qty_desc_code				= 	"";
	String		chk_for_max_durn_action		= 	"";
	String		qty_reqd_yn					= 	"";
	String		max_durn_value				= 	"";
	String		allergy_yn					= 	"";
	String		refill_cont_order_yn		= 	"";
	String		start_date					= 	"";
	String		end_date					= 	"";
	String		dosage_type					= 	"";
	String		scheduled_yn				= 	"";
	String		ori_dosage_type				=   "";
	String		repeat_durn_type			= 	"";
	String		max_refills_for_pres		= 	"";
	String		order_type_code				= 	"";
	String		back_date					= 	"";
	String		future_date					= 	"";
	String		split_dose_yn				= 	"";
	String		rowVal						= 	"";
	String		max_durn_for_refill_pres	= 	"";
	String		no_refill					= 	"";
	String		refill_start_date			= 	"";
	String		refill_end_date				= 	"";
	String		admin_time					= 	"";
	String		admin_qty					= 	"";
	String		repeat_value				=   "";
	String		freq_nature					= 	"";
	String		allergy_override			= 	"";
	String		dose_override				= 	"";
	String		currentrx_override			= 	"";
	String		current_rx					= 	"";
	String		dflt_qty_uom				= 	"";
	String		tappered_over				= 	"";
	String		sch_over_yn					= 	"";
	String		disp_locn_code				= 	"";
	String		disp_locn_desc				= 	"";
	String		stock_uom					= 	"";
	String		absol_qty					= 	"";
	String		prn_dose					= 	"";
	String		dosage_option				=	"";
	String		dosage_legend				=	"";
	String		qty_option					=	"";
	String		freq_option					=	"";				
	String		duration_option				=	"";
	String		trade_code					=	"";
	String		trade_name					=	"";
	String		in_formulary_yn				=	"";
	String		freq_chng_durn_desc			=   "";
	String		force_auth_yn			    =   "";
	//Added for IN:070451 start
	String		max_daily_ceeling_dose	    =   "";
	String		min_daily_ceeling_dose	    =   "";
	String		max_unit_ceeling_dose	    =   "";
	String		min_unit_ceeling_dose	    =   "";
	//Added for IN:070451 end
	
	//Added for IN:072715 start
	String		allergy_remarks_code	    =   "";
	String		dose_remarks_code	    =   "";
	String		currentrx_remarks_code	    =   "";
	String		interaction_remarks_code	    =   "";
	String		food_interaction_remarks_code	    =   "";
	String		lab_interaction_remarks_code	    =   "";
	//Added for IN:070451IN:072715 end
	String		disease_interaction_remarks	    =   "";//Added for MMS-DM-CRF-0299
	String		disease_interaction_remarks_code	    =   "";//Added for MMS-DM-CRF-0229
	
	String statFreqCode="";// added for ML-BRU-SCF-1046 [IN:043889]
	String pregnency_yn				=	"";//added for  RUT-CRF-0063 [IN:029601] -start
	String preg_remarks				=   ""; 
	String pregnency_cat ="";
	String preg_effect   ="";
	String preg_category_code="";
	String preg_warn_req_yn="";
	String preg_icon_disp   ="display:none;";
    String pregnency_cat_desc ="";//added for  RUT-CRF-0063 [IN:029601] -End
	//Code Added For 29927	RUT-CRF-0034 -Start
	String backgrndColor= "";
	String fntColor="";
	String route_color = "";
	//Code Added For 29927	RUT-CRF-0034 -End
	String bl_incl_excl_override_reason_code = "";
	String bl_incl_excl_override_reason_desc = "";
	String bl_def_override_excl_incl_ind     = "";
	String bl_override_excl_incl_ind         = "";
	String bl_override_allowed_yn            = "";

	HashMap chkValuescheduleFrequency	=	null;
	ArrayList frequencyValues			=	null;
	String selected_disp				=	"";
	String calendar_status				=	"";
	String route_option					=	"";
	ArrayList		code				=	new ArrayList();
	ArrayList		desc				=	new ArrayList();
	boolean			entered				=	false;
	HashMap taperDateParams				=	null;
	String schedule_status				=	"";
	String absol_qty_status				=	"";
	String u_priority					=	"";
	String r_priority					=	"";
	String refill_status				=	"disabled";
	String brought_by_pat				=	"";
	String brought_by_pat_status		=	"";
	String qty_legend_style				=	"display:none";
	String interval_value				=	"";
	String calc_by_ind					=	"";
	String dosage_std					=	"";
	String dosage_unit					=	"";
	String recomm_yn					=	"";
	String orig_current_rx				=	"";
	HashMap prn_remarks					=	null;
	String prn_remarks_dtl				=	"";
	String prn_remarks_yn				=	"";
	String prn_remarks_code				=	"";
	String pt_coun_reqd_yn				=	"";
	String chk_pat_couns_req			=	"";
	String Disable_recc_dose            =   "";
	String split_dose_yn_val			=   "N";
	String atc_level4_duplication		=   "";
	String ord_set_reqd_or_opt			=	"";
	String sliding_scale_yn				=	"";
	String fract_dose_round_up_yn		=	"";
	int codeCount_1						=   0;
	int codeCount_2						=   0;
	HashMap ext_drugData				=	null;
	String ext_drug_code				=	null;
	String ext_srl_no					=	null;
	boolean def_freq_found				=	false;
	boolean def_freq_not_found          =   false;//Added for GHL-CRF-0508
	int drug_index=0;
	String parent_disable				=	"";
	String dsg_reason					=	"";
	String dup_reason					=	"";
	String int_reason					=	"";
	String con_reason					=	"";
	String alg_reason					=	"";
	String trade_option					=	"";	
	String trade_option_disable			=	"";
	String fract_dose_appl_yn			=	"";
	String calc_def_dosage_yn			=	"";
	String refill_yn		            =	"";
	String refill_yn_from_param	        =	"";
	//introduced to fix bug when 2 drugs, one split and one non-split drug is copied from prev orders.
	String copied_drug_yn				=	"";
	String split_dose					=	"";
	String split_dose_yn_copy			=	"";
	String order_id_copy				=	"";
	String order_line_no_copy			=	"";
	String DrugRemarksEntered			=	""; //Added for Antibiotic Screen using Order Entry Format ICN 29904
	String 		DrugIndicationRemarks				=   "";// ML-BRU-CRF-072[Inc:29938] 
	Hashtable DurnDescDetails			=   new Hashtable();
	String start_date1 = null;//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start
	String end_date1 = null;
	String sys_date = null;	
	String tempstartdate1="";
	String tempenddate1 = "";//Added for Bru-HIMS-CRF-093-DD1[IN047223]--end
	String default_dosage_by_yn=		"";// AAKH-CRF-089 chithra
	boolean checkflag	=	false;//AAKH-CRF-089
	String patient_stock_required_yn = "N";//GHL-CRF-0482
	String ord_authorized_yn_durn="";//added for mo-scf-5533
	if(priority.equals("U")) {
		u_priority		=	"selected";
	}
	else {
		r_priority		=	"selected";
	}
	drug_db_interface_yn	    = request.getParameter("drug_db_interface_yn")==null?"":request.getParameter("drug_db_interface_yn");
	String drug_db_allergy_check_yn	    = request.getParameter("drug_db_allergy_check_yn")==null?"":request.getParameter("drug_db_allergy_check_yn");
	String drug_db_duptherapy_yn	    = request.getParameter("drug_db_duptherapy_yn")==null?"":request.getParameter("drug_db_duptherapy_yn");
	String quota_limit_site_yn="N"; //ML-MMOH-CRF-1823 US008- 43528  START
	String		quota_limit_access_yn			= 	""; //ML-MMOH-CRF-1823 US008 - 43528
	if(quota_byPatient_Qty){
		quota_limit_site_yn="Y"; //ML-MMOH-CRF-1823 US008- 43528 END	
	}

	String or_bean_name				= "eOR.OrderEntryBean";
	String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean			= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
	orbean.setLanguageId(locale);

	String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name				= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean			= (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request);

	String presBean_id					= "@PrescriptionBean"+patient_id+encounter_id;
	String presBean_name				= "ePH.PrescriptionBean";
	PrescriptionBean presBean			= (PrescriptionBean)getBeanObject( presBean_id,presBean_name,request);
System.err.println("PrescriptionDetail_1.jsp-=----410---loading Drug--System.currentTimeMillis()---> " +System.currentTimeMillis()+"==drug_code===>"+drug_code);
	bean.setLanguageId(locale);
	presBean.setLanguageId(locale);
	presBean.setPresBean_1(bean);//Adding start for TH-KW-CRF-0007
	ArrayList presDetails_1					= (ArrayList) bean.getpresDetails();//moved above for ICN-37525
//	System.err.println("practitionerId@@=="+pract_id);
	String specialityCd = bean.getSpecialtyCode(pract_id);
	HashMap suppDrugMap = new HashMap();
	           suppDrugMap = presBean.getSuppDrugMap();
			   if(!drug_code.equals("") && !suppDrugMap.containsKey(drug_code)){
	               supp_drug_count = presBean.getSupportDrugCount(drug_code); //Adding start for TH-KW-CRF-0007
			   }else if((presDetails_1==null || presDetails_1.size()==0 )) {//Adding start for ICN-37525
                      presBean.clear();
			   }//Adding end for ICN-37525
		 System.err.println("supp_drug_count@@==="+supp_drug_count+"drug_code=="+drug_code);
	if(patient_stock_required_yn==null || patient_stock_required_yn.equals("")) //GHL-CRF-0482
		patient_stock_required_yn = "N";
	int profile_count		= bean.getDrugProfileCount();  //added for Bru-HIMS-CRF-0265 [IN032315]
	String discCancFlag		=""; //added for Bru-HIMS-CRF-0265 [IN032315]
	skip_duplicte_alert       = bean.getSkipDuplicateAlertIp_yn(); // Added for MO-CRF-20085.1 [IN057392]
	//Added code For the incident number 21598 for clearing the chargedetails after selecting the medical item and onclick of RXtab. 

	
   if(frm_rx_button_yn.equals("Y") && (presDetails_1==null || presDetails_1.size()==0 )){ 

    String consumable_bean_id				= "@ConsumableOrderBean"+patient_id+encounter_id;
	String consumable_bean_name				= "ePH.ConsumableOrderBean";
	ConsumableOrderBean consumable_bean		= (ConsumableOrderBean)getBeanObject( consumable_bean_id,consumable_bean_name , request );
	    consumable_bean.clear();
		putObjectInBean(consumable_bean_id,consumable_bean,request);
   }

	//corrected during PE By Naveen value is getting setted when checkDiagnosis is called from PrescriptionHeader_1.jsp
	//ArrayList diagnosis	=	bean.checkDiagnosis(patient_id);
	//int diag_size	=	(diagnosis).size();
	int diag_size	=	bean.getDiagnosisSize();
	String mode		= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
	String totalTaperQtyDisplay = bean.getTotalTaperQtyDisplay();
	pregnency_yn	=presBean.getPregnencyYN(patient_id);//added for  RUT-CRF-0063 [IN:029601]
	String overlap_period_for_op        =   bean.getOverlapPeriodForOP();//CRF-20085.1
	String overlap_period_for_ip        =   bean.getOverlapPeriodForIP();//CRF-20085.1
	
	int take_home= 0;
	if(encounter_id!=null && !(encounter_id.equals(""))){
		//take_home=bean.getHomeMecdicationYn(encounter_id,(String)session.getValue("facility_id"));
		take_home=(int)bean.getTakeHomeCount();
	}
	String ph_version				=	(String)PhLicenceRights.getKey();
	String Override_Check		="";
	String Override_Checked		="";
	String checkEnabled			="";
	String display_tdm			="display:none";
	String display_auth_rule	="visibility:hidden";
	String color_auth_rule	    = "RED";
	String order_set_occur_num	= "";
	String recomm_dosage_by     ="";
	String drug_db_allergy_flag         = "";
	String drug_db_duptherapy_flag      = "";
	String drug_db_interact_check_flag  = "";
	String drug_db_contraind_check_flag = "";
	String drug_db_dosage_check_flag    = "";
	String amend_yn					    = "";
	String uom_disp					    = "";

	String include_selected             ="";
	String exclude_selected             ="";
	String Select_selected              ="";
	String billable_item_yn			   ="";
	String diagnosis_found_yn="";//added for mms-dm-crf-0204
	String check_pat_con	 = "";
	String drug_tapered	 = "";
	float totTapperQty =0;
	float temps = 0.0f;//Added for  RUT-SCF-0321 [IN044816]
	float prevTotTapperQty =0;
	String calc_dosg_by_freq_durn_yn = ""; //added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595]
	boolean drug_found = false;
	String trimester="";
	//AAKH-CRF-0091 
	String stat_yn = "";
	String parent_stat_yn			= "";
	String chk_missing_sch_yn	="";  //AAKH-CRF-0091 
	String chk_missing_sch_yn_1 ="";  //AAKH-CRF-0091 
	String default_recm_dose_yn_value="N";//added for ml-mmoh-crf-0978
	String def_qty_value = "";//ARYU-CRF-014
	//GHL-CRF-0549 - start
	String item_type = "";
	String mm_item_low_cost_yn = ""; 
	String mm_item_high_margin_yn = "";
	String mm_item_Innovator_yn  = "";
	String allow_alternate_yn ="N"; //GHL-CRF-0549
	String def_dosage_type = "";//added for TBMC-SCF-0176
	String validate_overide_on_confirm_yn="N";//Added for IN:069887 
	//GHL-CRF-0549 - end	
	boolean default_recm_dose_yn=presBean.isSiteSpecific("PH", "DEFAULT_RECOM_DOSE_YN"); //added for ml-mmoh-crf-0978
	boolean default_freq_not_found =presBean.isSiteSpecific("PH","DEFAULT_FREQUENCY_NOT_FOUND");//added for GHL-CRF-0508
	boolean disc_cancel_flag =presBean.isSiteSpecific("PH","DISCONTINUE_CANCEL_YN");//added for MO-CRF-20159
	boolean validate_overide_on_confirm =presBean.isSiteSpecific("PH","VALIDATE_OVERIDE_ON_CONFIRM");//Added for IN:069887 
	String pre_alloc_appl_yn =bean.getPreAllocApplYN();//Added for TFS id:7345
	drug_indication_mdry=bean.getDrugIndicationMdry();//added for jd-crf-0220
	String def_disp_locn_appl_yn = presBean.defaultDispLocnSelectAppl();//Added for NMC-JD-SCF-0324
	System.out.println("555drug_indication_mdry"+drug_indication_mdry);
if(default_recm_dose_yn){
	default_recm_dose_yn_value="Y";
}
else{
	default_recm_dose_yn_value="N";
}
//Added for IN:069887 start
	if(validate_overide_on_confirm){
		validate_overide_on_confirm_yn="Y";
	}
	//Added for IN:069887  end
	if(!calling_mode.equals("blank")){
			presDetails					= (ArrayList) bean.getpresDetails();
			chkValuescheduleFrequency	= bean.getscheduleFrequency();
			start_date					= hr_start_time;
	//		prn_yn						= bean.getchkforPRN();
	//commented during PE By Naveen now taking from drug details
			//man_rem_on_prn_freq_yn 		= bean.getchkforPRN();
			if(presDetails ==null || presDetails.size()==0){
				calling_mode = "blank";
			}		
			if(presDetails!=null && presDetails.size()>0){
				for(int j=0;j<presDetails.size();j++){
					ext_drugData=(HashMap) presDetails.get(j);
					ext_drug_code = (String) ext_drugData.get("DRUG_CODE");
					ext_srl_no    = (String) ext_drugData.get("SRL_NO");
					if(drug_code.equals(ext_drug_code)){
						drug_found = true;
						break;
					}
				}
				if(!drug_found){
					ext_drugData = (HashMap) presDetails.get(0);
					drug_code    = (String) ext_drugData.get("DRUG_CODE");
					srl_no       = (String) ext_drugData.get("SRL_NO"); 
				}
			}
			order_id				    = bean.getOorderIdForTDMDtls(patient_id,drug_code);
			if(order_id==null||order_id.equals("")){
				display_tdm="display:none";
			}
			else{
				display_tdm="display:inline";
			} 		
		}
		if(presDetails!=null && presDetails.size()>0){
			for(int i=0;i<presDetails.size();i++){

				drugDetails		= (HashMap)presDetails.get(i);
				extdrugCode		= (String)drugDetails.get("DRUG_CODE");
				srlNo			= (String)drugDetails.get("SRL_NO");
				//ph_drug_overlap_period = (String)drugDetails.get("PH_DRUG_OVERLAP_PERIOD");
				if(extdrugCode.equals(drug_code) && srlNo.equals(srl_no) ){
			
		//AAKH-CRF-0091	starts				
		stat_yn			= (String)drugDetails.get("stat_yn")==null?"":(String)drugDetails.get("stat_yn");
		parent_stat_yn  = (String)drugDetails.get( "parent_stat_yn" )==null?"":(String)drugDetails.get("parent_stat_yn");
		//AAKH-CRF-0091	ends
		
					
					taperdrugDetails = drugDetails;//Added for  RUT-SCF-0321 [IN044816]
					if(drugDetails.containsKey("Override_Check")) {
						Override_Check	=(String)drugDetails.get("Override_Check");
					//Added for AAKH-CRF-0091 start
						if(stat_yn.equals("Y")){ 
							Override_Check="Y";
						}
						// added for AAKH-CRF-0091 end
						if(Override_Check.equals("Y")){
							Override_Checked="Checked";
							checkEnabled="disabled";
						}
						else{
							Override_Checked="";
							checkEnabled="";
						}
					}
					order_set_occur_num    = (String) drugDetails.get("ORDER_SET_OCCUR_NUM")==null?"":(String) drugDetails.get("ORDER_SET_OCCUR_NUM");
					if(order_set_code.equals("")){
						order_set_code	   = (String) drugDetails.get("ORDER_SET_CODE")==null?"":(String) drugDetails.get("ORDER_SET_CODE");
					}
					ext_prod_id			   = (String) drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String) drugDetails.get("EXTERNAL_PRODUCT_ID");
					man_rem_on_prn_freq_yn = (String)drugDetails.get("MANDATORY_REM_ON_PRN_FREQ_YN");
					
					if( drug_code.equals(extdrugCode) && (String.valueOf(srl_no)).equals(srlNo) ){ //replaced ext_srl_no with srlNo for IN25872 --17-01-2011-- priya
						drug_db_dosage_check_flag    = (String)drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG");
						drug_db_contraind_check_flag = (String)drugDetails.get("DRUG_DB_CONTRAIND_CHECK_FLAG");
						drug_db_interact_check_flag  = (String)drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG");
						drug_db_duptherapy_flag      = (String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG");
						drug_db_allergy_flag         = (String)drugDetails.get("DRUG_DB_ALLERGY_FLAG");
					}

					copied_drug_yn				= (String) drugDetails.get("COPIED_DRUG_YN")==null?"N":(String) drugDetails.get("COPIED_DRUG_YN");// if the current drug is copied?
					split_dose					= (String) drugDetails.get("SPLIT_DOSE_PREVIEW")==null?"":(String) drugDetails.get("SPLIT_DOSE_PREVIEW");//the dosage schedule string
					split_dose_yn_copy			= (String) drugDetails.get("SPLIT_YN")==null?"":(String) drugDetails.get("SPLIT_YN");//if the copied drug is split?
					order_id_copy				= (String) drugDetails.get("ORDER_ID")==null?"":(String) drugDetails.get("ORDER_ID");
					order_line_no_copy			= (String) drugDetails.get("ORD_LINE")==null?"":(String) drugDetails.get("ORD_LINE");
					allow_duplicate				= (String) drugDetails.get("ALLOW_DUPLICATE_DRUG");
					//IN30118-SCF No: MO-GN-5400. Assingning OutPatient Duplicate Drug Check.
					allow_duplicate_op				= (String) drugDetails.get("ALLOW_DUPLICATE_DRUG_OP");
					//GHL-CRF-0549 - start
					disp_by_alt_form_drug     = (String) drugDetails.get("DISP_ALT_FORM_YN")==null?"N":(String) drugDetails.get("DISP_ALT_FORM_YN");
					disp_by_alt_form_param     = bean.getParamDispByAltForm();
					if(item_type_site_app){
						allow_alternate_yn = (String) drugDetails.get("allow_alternate_yn")==null?"N":(String) drugDetails.get("allow_alternate_yn"); //GHL-CRF-0549
						if(disp_by_alt_form_param.equals("Y") && disp_by_alt_form_drug.equals("Y"))
						{
							item_type = bean.getItemType(drug_code);
							mm_item_low_cost_yn = item_type.split("~")[0];
							mm_item_high_margin_yn = item_type.split("~")[1];
							mm_item_Innovator_yn = item_type.split("~")[2];
							if(mm_item_low_cost_yn.equals("Y") || mm_item_high_margin_yn.equals("Y")){
								checked = "checked";
							}else{
								checked = "";
							}
							if(mm_item_Innovator_yn.equals("Y")) //4/23/2019
								checked = "";
							
							if(!mm_item_low_cost_yn.equals("Y") && !mm_item_high_margin_yn.equals("Y") && !mm_item_Innovator_yn.equals("Y")){ //4/24/2019
								checked = "checked";
							}

							disabled = "";
						
						}else{
							disabled = "disabled";
						}
						if(allow_alternate_yn.equals("Y")) 
							checked = "checked";
					} 	//GHL-CRF-0549 - end
					if(patient_class.equals("OP") || patient_class.equals("EM")|| patient_class.equals("XT")){
						allow_duplicate = allow_duplicate_op;
						skip_duplicte_alert = bean.getSkipDuplicateAlertOp_yn(); // Added for MO-CRF-20085.1 [IN057392]
						//ph_drug_overlap_period = (String)drugDetails.get("PH_DRUG_OVERLAP_PERIOD_OP");// Added for MO-CRF-20085.1 By prathyusha on 05/26/2016
					}
					/*else{
						ph_drug_overlap_period = (String)drugDetails.get("PH_DRUG_OVERLAP_PERIOD_IP");// Added for MO-CRF-20085.1 By prathyusha on 05/26/2016
					}*/
					drug_desc					= (String) drugDetails.get("DRUG_DESC");
					prn_remarks					=	bean.getPRNRemarks((String)drugDetails.get("DRUG_CODE"));
					if(prn_remarks != null){
						prn_remarks_dtl			= prn_remarks.get("prn_remarks_dtl")==null?"":(String)prn_remarks.get("prn_remarks_dtl");
						prn_remarks_code		= prn_remarks.get("prn_remarks_code")==null?"":(String)prn_remarks.get("prn_remarks_code");
					}
					DrugIndicationRemarks = (String) drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");//Added for ML-BRU-CRF-072[Inc:29938]
					if(!DrugIndicationRemarks.equals(""))
						DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8"); 
					// added for CRF RUT-CRF-0063[29601]-start
					preg_remarks = (String) drugDetails.get("PREG_REMARKS")==null?"":(String)drugDetails.get("PREG_REMARKS");// code "PREG_REMRKS" is replaced by "PREG_REMARKS" for  IN040512
					if(!preg_remarks.equals(""))
						preg_remarks = java.net.URLEncoder.encode(preg_remarks,"UTF-8");
					// added for CRF RUT-CRF-0063[29601]-end
					generic_id					= (String) drugDetails.get("GENERIC_ID");
					generic_name				= (String) drugDetails.get("GENERIC_NAME");
					drug_class					= (String) drugDetails.get("DRUG_CLASS");
					form_code					= (String) drugDetails.get("FORM_CODE");
					form_desc					= (String) drugDetails.get("FORM_DESC");
					pres_base_uom				= (String) drugDetails.get("PRES_BASE_UOM");
					pres_base_uom_desc			= (String) drugDetails.get("PRES_BASE_UOM_DESC");
					strength_value				= (String) drugDetails.get("STRENGTH_VALUE");
					strength_uom				= (String) drugDetails.get("STRENGTH_UOM");
					strength_uom_desc			= (String) drugDetails.get("STRENGTH_UOM_DESC");
					strength_per_pres_uom		= (String) drugDetails.get("STRENGTH_PER_PRES_UOM");
					strength_per_value_pres_uom	= (String) drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
					ord_auth_reqd_yn			= (String) drugDetails.get("ORD_AUTH_REQD_YN");
					quota_limit_access_yn			= (String) drugDetails.get("QUOTA_LIMIT_ACCESS_YN"); //ML-MMOH-CRF-1823 US008- 43528
					force_auth_yn				= (String) drugDetails.get("FORCE_AUTH_YN"); // THIS IS TO KNOW IF AUTH YN IS DUE TO FORCE AUT OR DUE TO DURATION EXCEEDED
					ord_spl_appr_reqd_yn		= (String) drugDetails.get("ORD_SPL_APPR_REQD_YN");
					ord_cosign_reqd_yn			= (String) drugDetails.get("ORD_COSIGN_REQD_YN");
					ord_authorized_yn			= (String) drugDetails.get("ORD_AUTHORIZED_YN");
					ord_authorized_prev_yn		= (String) drugDetails.get("ORD_AUTHORIZED_PREV_YN");
					ord_authorized_yn_durn      = (String) drugDetails.get("ORD_AUTHORIZED_YN_DURN");//ADDED FOR MO-SCF-5533
					ord_approved_yn				= (String) drugDetails.get("ORD_APPROVED_YN");
					ord_cosigned_yn				= (String) drugDetails.get("ORD_COSIGNED_YN");
					consent_reqd_yn				= (String) drugDetails.get("CONSENT_REQD_YN");
					limit_ind					= (String) drugDetails.get("LIMIT_IND");
					daily_dose					= (String) drugDetails.get("DAILY_DOSE");
					unit_dose					= (String) drugDetails.get("UNIT_DOSE");
					min_daily_dose				= (String) drugDetails.get("MIN_DAILY_DOSE");
					min_unit_dose				= (String) drugDetails.get("MIN_UNIT_DOSE"); 
					mono_graph					= (String) drugDetails.get("MONO_GRAPH");
					qty_value					= (String) drugDetails.get("QTY_VALUE");
					tab_qty_value				= (String) drugDetails.get("TAB_QTY_VALUE");
					freq_code					= (String) drugDetails.get("FREQ_CODE")==null?"":(String) drugDetails.get("FREQ_CODE");
					values_changed				= (String) drugDetails.get("VALUES_CHANGED")==null?"":(String) drugDetails.get("VALUES_CHANGED");//added for ML-BRU-SCF-1231 [IN:046657]
					durn_value					= (String) drugDetails.get("DURN_VALUE");
					durn_type					= (String) drugDetails.get("DURN_TYPE");
					recomm_yn					= ((String)drugDetails.get("RECOMM_YN"));
					consider_stock_for_pres_yn	= (String) drugDetails.get("CONSIDER_STOCK_FOR_PRES_YN");
					qty_desc_code				= (String) drugDetails.get("QTY_DESC_CODE");
					chk_for_max_durn_action		= (String) drugDetails.get("CHK_FOR_MAX_DURN_ACTION");
					qty_reqd_yn					= (String) drugDetails.get("QTY_REQD_YN");
					max_durn_value				= (String) drugDetails.get("MAX_DURN_VALUE");
					allergy_yn					= (String) drugDetails.get("ALLERGY_YN");
					refill_cont_order_yn		= (String) drugDetails.get("REFILL_CONT_ORDER_YN");
					start_date					= (String) drugDetails.get("START_DATE");
					end_date					= (String) drugDetails.get("END_DATE");
					drug_tapered				= drugDetails.get("DRUG_TAPERED_YN")==null?"":(String)drugDetails.get("DRUG_TAPERED_YN");
					tappered_over				= (String)drugDetails.get("TAPPERED_OVER")==null?"":(String)drugDetails.get("TAPPERED_OVER");
					dosage_type					=  drugDetails.get("DOSAGE_TYPE")==null?"":(String) drugDetails.get("DOSAGE_TYPE");
					totTapperQty				=  Float.parseFloat(drugDetails.get("TOTTAPPERQTY")==null?"0":(String) drugDetails.get("TOTTAPPERQTY"));
					prevTotTapperQty				=  Float.parseFloat(drugDetails.get("PREVTOTALTAPERQTY")==null?"0":(String) drugDetails.get("PREVTOTALTAPERQTY"));
					tap_lvl_qty					=  drugDetails.get("TAP_LVL_QTY")==null?"":drugDetails.get("TAP_LVL_QTY").toString(); //Added for RUT-CRF-0088 [IN036978]
					/*if(from_sliding_scale_yn.equals("Y")){ // added for IN25532 --27/12/2010-- priya (drug was displaying as absolute on unchecking sliding scale)
						dosage_type					=  drugDetails.get("ORI_DOSAGE_TYPE")==null?"":(String) drugDetails.get("ORI_DOSAGE_TYPE");
					}*/
					//dosage_type					=  drugDetails.get("ORI_DOSAGE_TYPE")==null?"":(String) drugDetails.get("ORI_DOSAGE_TYPE"); //replaced "DOSAGE_TYPE" with "ORI_DOSAGE_TYPE" for IN25014 --15/11/2010-- priya (Commented for IN25274 --29/11/2010)
					scheduled_yn				= (String) drugDetails.get("SCHEDULED_YN")==null?"N":(String) drugDetails.get("SCHEDULED_YN");
					patient_stock_required_yn = (String) drugDetails.get("PATIENT_STOCK_REQUIRED")==null?"N":(String) drugDetails.get("PATIENT_STOCK_REQUIRED"); //GHL-CRF-0482
					//Added for IN:070451 start
					max_daily_ceeling_dose				= (String) drugDetails.get("MAX_DAILY_CEELING_DOSE");
					min_daily_ceeling_dose				= (String) drugDetails.get("MIN_DAILY_CEELING_DOSE");
					max_unit_ceeling_dose				= (String) drugDetails.get("MAX_UNIT_CEELING_DOSE");
					min_unit_ceeling_dose				= (String) drugDetails.get("MIN_UNIT_CEELING_DOSE");
					//Added for IN:070451 end
					
					//Added for IN:072715 start
					allergy_remarks_code				= (String) drugDetails.get("ALLERGY_REMARKS_CODE")==null?"":(String) drugDetails.get("ALLERGY_REMARKS_CODE");
					dose_remarks_code				= (String) drugDetails.get("DOSE_REMARKS_CODE")==null?"":(String) drugDetails.get("DOSE_REMARKS_CODE");
					currentrx_remarks_code				= (String) drugDetails.get("CURRENTRX_REMARKS_CODE")==null?"":(String) drugDetails.get("CURRENTRX_REMARKS_CODE");
					interaction_remarks_code				= (String) drugDetails.get("INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("INTERACTION_REMARKS_CODE");
					food_interaction_remarks_code				= (String) drugDetails.get("FOOD_INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("FOOD_INTERACTION_REMARKS_CODE");
					lab_interaction_remarks_code				= (String) drugDetails.get("LAB_INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("LAB_INTERACTION_REMARKS_CODE");
					disease_interaction_remarks_code =(String) drugDetails.get("DISEASE_INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("DISEASE_INTERACTION_REMARKS_CODE");//Added for MMS-DM-CRF-0229
					disease_interaction_remarks =(String) drugDetails.get("DISEASE_INTERACTION_REMARKS")==null?"":(String) drugDetails.get("DISEASE_INTERACTION_REMARKS");//Added for MMS-DM-CRF-0229
					//Added for IN:072715 end
					//2nd occurrence of getDrug_schd_flag_yn()
			//AAKH-CRF-0091	starts		
			drug_desc_new				= (String) drugDetails.get("DRUG_DESC_NEW")==null?"":(String) drugDetails.get("DRUG_DESC_NEW");//Added for TFS id:7345
			drug_search_by				= (String) drugDetails.get("DRUG_SEARCH_BY")==null?"":(String) drugDetails.get("DRUG_SEARCH_BY");//Added for TFS id:7345
			
				if(stat_yn.equals("Y")){
						priority					= "U";
					}
					else{
						priority					= (String)drugDetails.get("PRIORITY");	// IN21582 --26/05/2010 -- priya	
					}
			//AAKH-CRF-0091	ends		  
					if(priority.equals("U")) {
						scheduled_yn = "N";
					}
					def_dosage_type 				=(String) drugDetails.get("DEF_DOSAGE_TYPE"); //added for TBMC-SCF-0176
					ori_dosage_type				= (String) drugDetails.get("ORI_DOSAGE_TYPE");
					repeat_durn_type			= drugDetails.get("REPEAT_DURN_TYPE")==null?"D":(String) drugDetails.get("REPEAT_DURN_TYPE");
					max_refills_for_pres		= (String) drugDetails.get("MAX_REFILLS_FOR_PRES");
					order_type_code				= (String) drugDetails.get("ORDER_TYPE_CODE");
					back_date					= (String) drugDetails.get("BACK_DATE");
					future_date					= (String) drugDetails.get("FUTURE_DATE");
					split_dose_yn				= (String) drugDetails.get("SPLIT_DOSE_YN")==null?"":(String) drugDetails.get("SPLIT_DOSE_YN");
					split_dose_yn_val			= (String) drugDetails.get("SPLIT_DOSE_YN_VAL")==null?"":(String) drugDetails.get("SPLIT_DOSE_YN_VAL");
					rowVal						= (String) drugDetails.get("rowVal");
					max_durn_for_refill_pres	= (String) drugDetails.get("MAX_DURN_FOR_REFILL_PRES");
					no_refill					= (String) drugDetails.get("NO_REFILL");
					refill_start_date			= (String) drugDetails.get("REFILL_START_DATE");
					refill_end_date				= (String) drugDetails.get("REFILL_END_DATE");
					admin_time					= (String) drugDetails.get("ADMIN_TIME");
					admin_qty					= (String) drugDetails.get("ADMIN_QTY");
					repeat_value				= (String) drugDetails.get("REPEAT_VALUE")==null?"1":(String) drugDetails.get("REPEAT_VALUE");
					in_formulary_yn				= (String) drugDetails.get("IN_FORMULARY_YN")==null?"":(String) drugDetails.get("IN_FORMULARY_YN");
					freq_nature					= (String) drugDetails.get("FREQ_NATURE")==null?"": (String) drugDetails.get("FREQ_NATURE");
					fract_dose_appl_yn			= (String) drugDetails.get("FRACT_DOSE_APPL_YN")==null?"":(String) drugDetails.get("FRACT_DOSE_APPL_YN");
					calc_def_dosage_yn			= (String) drugDetails.get("CALC_DEF_DOSAGE_YN")==null?"":(String) drugDetails.get("CALC_DEF_DOSAGE_YN");
					default_dosage_by_yn			=(String)drugDetails.get("DEFAULT_DOSAGE_BY_YN").toString();// AAKH-CRF-089 chithra  
					if(fract_dose_appl_yn.equals("N"))
						dose_decimal = 0;
					
					interaction_exists			= (String) drugDetails.get("INTERACTION_EXISTS")==null?"N": (String) drugDetails.get("INTERACTION_EXISTS"); //Added for	RUT-CRF-0066 IN[029604] -Start
					intr_restric_trn			= (String) drugDetails.get("INTR_RESTRIC_TRN")==null?"N": (String) drugDetails.get("INTR_RESTRIC_TRN");
					severity_level				= (String) drugDetails.get("SEVERITY_LEVEL")==null?"": (String) drugDetails.get("SEVERITY_LEVEL");
					intr_msg_content			= (String) drugDetails.get("INTR_MSG_CONTENT")==null?"": (String) drugDetails.get("INTR_MSG_CONTENT"); //Added for	RUT-CRF-0066 IN[029604] -end
				  //added for AAKH-CRF-0140 start
					if(drug_abuse_appl){ 
				    	
				   
				    	abuse_exists	= (String) drugDetails.get("ABUSE_EXISTS")==null?"N": (String) drugDetails.get("ABUSE_EXISTS");
							 abuse_restric_trn=(String) drugDetails.get("ABUSE_RESTRIC_TRN")==null?"N": (String) drugDetails.get("ABUSE_RESTRIC_TRN");
							 abuse_remarks= (String) drugDetails.get("ABUSE_REMARKS")==null?"": (String) drugDetails.get("ABUSE_REMARKS");
							  abuse_override =(String) drugDetails.get("ABUSE_OVERRIDE")==null?"": (String) drugDetails.get("ABUSE_OVERRIDE");
							  abuse_action=(String) drugDetails.get("ABUSE_ACTION")==null?"U": (String) drugDetails.get("ABUSE_ACTION");
							  abuse_override_remarks=(String) drugDetails.get("abuse_override_remarks")==null?"": (String) drugDetails.get("abuse_override_remarks");
							  System.out.println("abuse_restric_trn 821"+abuse_restric_trn);
				    }
				    else{
				    	abuse_exists	=	"N";// (String) drugDetails.get("ABUSE_EXISTS")==null?"N": (String) drugDetails.get("ABUSE_EXISTS");
						 abuse_restric_trn="N";// (String) drugDetails.get("ABUSE_RESTRIC_TRN")==null?"N": (String) drugDetails.get("ABUSE_RESTRIC_TRN");
						 abuse_remarks="";// (String) drugDetails.get("ABUSE_MSG_CONTENT")==null?"N": (String) drugDetails.get("ABUSE_MSG_CONTENT");
						  abuse_override ="";// (String) drugDetails.get("ABUSE_OVERRIDE")==null?"N": (String) drugDetails.get("ABUSE_OVERRIDE");
						  abuse_action="";// (String) drugDetails.get("ABUSE_OVERRIDE")==null?"N": (String) drugDetails.get("ABUSE_OVERRIDE");
						  abuse_override_remarks="";

				    }
					//added for AAKH-CRF-0140 end
					amend_yn					= (String) drugDetails.get("AMEND_YN")==null?"N": (String) drugDetails.get("AMEND_YN");
					fract_dose_round_up_yn		= (String) drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
					trade_code					= (String) drugDetails.get("TRADE_CODE")==null?"": (String) drugDetails.get("TRADE_CODE");
					trade_name					= (String) drugDetails.get("TRADE_NAME")==null?"": (String) drugDetails.get("TRADE_NAME");
					recomm_dosage_by			= (String)drugDetails.get("RECOMM_DOSAGE_BY")==null?"":(String)drugDetails.get("RECOMM_DOSAGE_BY");
					default_dosage_by			= (String)drugDetails.get("DEFAULT_DOSAGE_BY")==null?"":(String)drugDetails.get("DEFAULT_DOSAGE_BY"); //add DEFAULT_DOSAGE_BY for SKR-CRF-PHIS-003[IN028182]
					default_route_yn			= (String)drugDetails.get("DEFAULT_ROUTE_YN")==null?"":(String)drugDetails.get("DEFAULT_ROUTE_YN"); 
					calc_dosg_by_freq_durn_yn  = (String)drugDetails.get("CALC_DOSG_BY_FREQ_DURN_YN")==null?"":(String)drugDetails.get("CALC_DOSG_BY_FREQ_DURN_YN"); //added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595]
					if(pregnency_yn.equals("Y") && amend_yn.equals("Y") && trimester!=null && !trimester.equals(""))
						trimester=(String) drugDetails.get("trimester");
					else
						trimester=bean.getPregTrimester();
					pregnency_cat  = (String)drugDetails.get("PREG_CATEGORY_GROUP_CODE")==null?"":(String)drugDetails.get("PREG_CATEGORY_GROUP_CODE");	//added for  RUT-CRF-0063 [IN:029601] -start
					preg_effect  = (String)drugDetails.get("PREG_EFFECT")==null?"":(String)drugDetails.get("PREG_EFFECT");
					preg_effect=java.net.URLEncoder.encode(preg_effect,"UTF-8");//code added for IN040512
					preg_category_code  = (String)drugDetails.get("PREG_CATEGORY_CODE")==null?"":(String)drugDetails.get("PREG_CATEGORY_CODE");
                    preg_warn_req_yn  = (String)drugDetails.get("PREG_WARN_REQ_YN")==null?"":(String)drugDetails.get("PREG_WARN_REQ_YN");
					pregnency_cat_desc  = (String)drugDetails.get("CATEGORY_GROUP_DESC")==null?"":(String)drugDetails.get("CATEGORY_GROUP_DESC"); 
					//added for  RUT-CRF-0063 [IN:029601]- end
					//ARYU-CRF-014 - start	
					def_qty_value = (String)drugDetails.get("def_dose_value")==null?"":(String)drugDetails.get("def_dose_value"); //chagned def_qty_value to def_dose_value for ARYU-SCF-0137
				
					 //ARYU-CRF-014 - end  
					if(amend_yn.equals("Y")||default_route_yn.equals("Y")||tappered_over.equals("Y")||copied_drug_yn.equals("Y"))//added copied_drug_yn.equals("Y") for SKR-SCF-0586 [IN034375]
						route_code					= (String) drugDetails.get("ROUTE_CODE")==null?"":(String) drugDetails.get("ROUTE_CODE");
					if(pregnency_yn.equals("Y") && !preg_effect.equals("") ) //if block added for  RUT-CRF-0063 [IN:029601]
						preg_icon_disp="display:inline;";
					else
						preg_icon_disp="display:none;";
					if(recomm_dosage_by.equals("B"))
						recomm_dosage_by = "Q";

					if(durn_value==null || durn_value.equals("") || durn_value.equals("0"))
						durn_value="1";
					freq_chng_durn_desc   =  drugDetails.get("freq_chng_durn_desc")==null?"D":(String) drugDetails.get("freq_chng_durn_desc");

					if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
						bl_override_allowed_yn			  = (String) drugDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"": (String) drugDetails.get("BL_OVERRIDE_ALLOWED_YN"); 
						bl_incl_excl_override_reason_code = (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE")==null?"": (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE"); 
						bl_incl_excl_override_reason_desc = (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"": (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
		/*========= Swapped the values for IN17378 on 21/12/2009	--Shyampriya =============================================*/			
						bl_override_excl_incl_ind        = (String) drugDetails.get("BL_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drugDetails.get("BL_OVERRIDE_EXCL_INCL_IND");  
						bl_def_override_excl_incl_ind    = (String) drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND"); 
						if(bl_override_excl_incl_ind.equals(""))
							bl_override_excl_incl_ind = bl_def_override_excl_incl_ind;
						//if(!bl_override_allowed_yn.equals("Y"))
							//bl_override_allowed_yn = "disabled";
					}
					sliding_scale_yn	= (String)drugDetails.get("SLIDING_SCALE_YN")==null?"N":(String)drugDetails.get("SLIDING_SCALE_YN"); 
					//added for TBMC-SCF-0176
					if(!amend_yn.equals("Y") && !sliding_scale_yn.equals("") && sliding_scale_yn.equals("Y")){
						dosage_type = def_dosage_type;
					}//END
					sliding_scale_yn = "N";
					drugDetails.put("SLIDING_SCALE_YN","N");	
					drugDetails.put("QUOTA_LIMT_SITE_YN",quota_limit_site_yn);
					drugDetails.put("QUOTA_LIMIT_ACCESS_YN",quota_limit_access_yn);
					drugDetails.put("SPECIALITY_CODE",specialityCd);
	//				drugDetails.put("SLIDING_SCALE_YN",sliding_scale_yn);	

	//  RUT-CRF-0062 [IN029600]  Added / Commented to change  Checked / Disabled Properties of Build MAR Checkbox -- begin
	
					/*if(drugDetails.get("BUILDMAR_YN")==null || ((String)drugDetails.get("BUILDMAR_YN")).equals("")){
						drugDetails.put("BUILDMAR_YN",MAR_app_yn);
					}
					buildMAR_yn = (String)drugDetails.get("BUILDMAR_YN");
					*/					
					buildMAR_yn="N";
					buildMAR_rule_org=(String) drugDetails.get("BUILD_MAR_RULE_ORG")==null?"":(String) drugDetails.get("BUILD_MAR_RULE_ORG");//ADDED FOR SKR-SCF-1714
					System.out.println("937 prescriptiondetail_1.jsp buildMAR_rule_org"+buildMAR_rule_org);
					ext_disp_appl_yn=(String) drugDetails.get("EXT_DISP_APPL_YN")==null?"":(String) drugDetails.get("EXT_DISP_APPL_YN"); //Added for NMC-JD-CRF-0046
					if(MAR_app_yn.equals("Y")){						
						/*if(buildMAR_yn.equals("Y"))
							buildMAR_checked ="Checked";		
						*/						
						buildMAR_rule=(String) drugDetails.get("BUILD_MAR_RULE")==null?"":(String) drugDetails.get("BUILD_MAR_RULE");						
						if(drugDetails.get("BUILDMAR_YN")==null || drugDetails.get("BUILDMAR_YN").toString().equals("")){
							if(buildMAR_rule.equals("CE") || buildMAR_rule.equals("CD")){
								buildMAR_checked="checked";
								buildMAR_yn="Y";
							}
							else if(buildMAR_rule.equals("UE") || buildMAR_rule.equals("UD")){
								buildMAR_checked="";
								buildMAR_yn="N";
							}
						}
						else{
							buildMAR_yn=drugDetails.get("BUILDMAR_YN").toString();

							if(buildMAR_yn.equals("Y"))
								buildMAR_checked ="checked";		
							else
								buildMAR_checked ="";		
						}
						
						/* if(buildMAR_rule.equals("CE") || buildMAR_rule.equals("UE")){
							buildMAR_enable="";
						}
						else if(buildMAR_rule.equals("CD") || buildMAR_rule.equals("UD")){
							buildMAR_enable="disabled";
						} */
						
						//  RUT-CRF-0062 [IN029600]  Added to change  Checked / Disabled Properties of Build MAR Checkbox -- end
						
						/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
						if(patient_class.equals("IP") || calling_mode.equals("taper")|| calling_mode.equals("tapered"))
			 SRR20056-CRF-0649.1 */
						if( calling_mode.equals("taper")|| calling_mode.equals("tapered"))
							buildMAR_enable ="disabled";
						if(buildMAR_yn.equals("Y"))
							buildMAR_checked ="Checked";
					}
					
					else
					{
						buildMAR_checked="Checked";
						buildMAR_enable="disabled";
					}
					
					if(ext_disp_appl_yn.equals("Y")) //nmc-jd-crf-0046
					{
						buildMAR_yn= "N";
					}
					allergy_override			= (String) drugDetails.get("ALLERGY_OVERRIDE");
					dose_override				= (String) drugDetails.get("DOSE_OVERRIDE");
					currentrx_override			= (String) drugDetails.get("CURRENTRX_OVERRIDE");
					interaction_override			= (String) drugDetails.get("INTERACTION_OVERRIDE")==null?"":(String) drugDetails.get("INTERACTION_OVERRIDE");
					current_rx					= (String) drugDetails.get("CURRENT_RX")==null?"":(String) drugDetails.get("CURRENT_RX");
					dsg_reason					= (String)drugDetails.get("EXT_DDB_DSG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DSG_REASON");
					dup_reason					= (String)drugDetails.get("EXT_DDB_DUP_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DUP_REASON");
					con_reason					= (String)drugDetails.get("EXT_DDB_CON_REASON")==null?"":(String)drugDetails.get("EXT_DDB_CON_REASON");
					int_reason					= (String)drugDetails.get("EXT_DDB_INT_REASON")==null?"":(String)drugDetails.get("EXT_DDB_INT_REASON");
					alg_reason					= (String)drugDetails.get("EXT_DDB_ALG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_ALG_REASON");
					atc_level4_duplication	    = (String) drugDetails.get("ATC_LEVEL4_DUPLICATION")==null?"":(String) drugDetails.get("ATC_LEVEL4_DUPLICATION");
					ord_set_reqd_or_opt	        = (String) drugDetails.get("REQD_OR_OPT_IND")==null?"":(String) drugDetails.get("REQD_OR_OPT_IND");
					//code added for Patient counselling req 
					pt_coun_reqd_yn					= (String) drugDetails.get("PT_COUN_REQD_YN");

					if( drugDetails.containsKey("ORIG_CURRENT_RX") && ((String)drugDetails.get("ORIG_CURRENT_RX")).equals("Y") ) {
						orig_current_rx	=	(String)drugDetails.get("ORIG_CURRENT_RX");
					}

					dflt_qty_uom				= (String) drugDetails.get("DFLT_QTY_UOM");
					sch_over_yn					= (String)drugDetails.get("SCH_OVER_YN");
					disp_locn_code				= (String) drugDetails.get("DISP_LOCN_CODE")==null?"":(String) drugDetails.get("DISP_LOCN_CODE");
					disp_locn_desc				= (String) drugDetails.get("DISP_LOCN_DESC")==null?"":(String) drugDetails.get("DISP_LOCN_DESC");
					
					stock_uom					= (String)drugDetails.get("STOCK_UOM_DESC");
					absol_qty					= (String)drugDetails.get("ABSOL_QTY"); 
					prn_dose					= (String)drugDetails.get("PRN_DOSES_PRES_PRD_FILL");
				/*	priority					= (String)drugDetails.get("PRIORITY");	
					if(priority.equals("U")) {
						scheduled_yn = "N";
					} */
					brought_by_pat				= (String)drugDetails.get("BROUGHT_BY_PAT");	
					interval_value				= (String)drugDetails.get("INTERVAL_VALUE")==null?"1":(String)drugDetails.get("INTERVAL_VALUE");
					calc_by_ind					= (String)drugDetails.get("CALC_BY_IND");
					dosage_std					= (String)drugDetails.get("DOSAGE_STD");
					dosage_unit					= (String)drugDetails.get("DOSAGE_UNIT");
					check_pat_con			    = (String)drugDetails.get("PAT_COUNSELING_REQD");
					billable_item_yn		 =		 (String) drugDetails.get("BILLABLE_ITEM_YN")==null?"":(String) drugDetails.get("BILLABLE_ITEM_YN");
					DrugRemarksEntered		 =		 (String) drugDetails.get("DrugRemarksEntered")==null?"":(String) drugDetails.get("DrugRemarksEntered"); //Added for Antibiotic Screen using Order Entry Format ICN 29904
					if(req_diag_pres_found){
						diagnosis_found_yn= (String) drugDetails.get("DIAGNOSIS_FOUND_YN");//added for mms-dm-crf-0204	
					}
					else{
						diagnosis_found_yn="G";//added for mms-dm-crf-0204
					}
					
							System.out.println("1004 diagnosis_found_yn"+diagnosis_found_yn);
					if(drugDetails.containsKey("REFILL_YN")){
						refill_yn =drugDetails.get("REFILL_YN")==null?"N":(String)drugDetails.get("REFILL_YN");
					}
					if(drugDetails.containsKey("REFILL_YN_FROM_PARAM")){
						refill_yn_from_param =drugDetails.get("REFILL_YN_FROM_PARAM")==null?"N":(String)drugDetails.get("REFILL_YN_FROM_PARAM");
					}
					if(check_pat_con != null && check_pat_con.equals("Y")){
						chk_pat_couns_req = "checked";
					}

					if(prn_dose==null || prn_dose.equals("")) {
						prn_dose	=	"1";
					}

					if(priority!=null && priority.equals("R")) {
						r_priority	=	"selected";
						u_priority	=	"";
					}
					else if(priority!=null && priority.equals("U")) {
						u_priority	=	"selected";
						r_priority	=	"";
					}

					if(brought_by_pat!=null && brought_by_pat.equals("Y")) {
						brought_by_pat_status	=	"checked";
					}
					
					if(strength_value.equals("0"))
						strength_value			=	"";

					if(limit_ind==null)
							limit_ind	=	"Y";
					if(chkValuescheduleFrequency!= null && chkValuescheduleFrequency.size()>0){
						frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(drug_code+srl_no);
					}

					selected_disp				=	bean.getDispLocation(srlNo);

					if(absol_qty==null || absol_qty.equals(""))
						absol_qty		=	"0";

					if(freq_nature.equals("P") && absol_qty.equals("0")) {
						absol_qty		=	prn_dose;	
					}
				}
			}
			for(int j=0;j<presDetails.size();j++){
				ext_drugData=(HashMap) presDetails.get(j);

				ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
				ext_srl_no=(String) ext_drugData.get("SRL_NO");
				if(drug_code.equals(ext_drug_code)){
					codeCount_1++;
				}
				if(drug_code.equals(ext_drug_code) && srl_no.equals(ext_srl_no))
					drug_index = j;
			}

			if(codeCount_1>1){
				for(int k=drug_index;k<presDetails.size();k++){
					ext_drugData=(HashMap) presDetails.get(k);
					ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
					if(drug_code.equals(ext_drug_code)){
						codeCount_2++;
					}
				}
			}
			if((codeCount_1>1 && codeCount_2>1) || stat_yn.equals("Y")){    //AAKH-CRF-0091	starts

				parent_disable="disabled readOnly";
			}
			tapper_srl_no = bean.getSrlNo();// +1 // modified on 14/04/2010 -- priya
		}
		if(from_sliding_scale_yn.equals("Y")){     // added for IN22691 -- 20/07/2010-- priya
			 bean.getclearscheduleFrequency(drug_code+srl_no); 
			 if(ori_dosage_type.equals("S"))
				qty_value =strength_value;
			 else
				 qty_value = tab_qty_value;
		}
		//delete frequency on reset/without confirm

		if(frequencyValues!=null && frequencyValues.size()>0  && scheduled_yn.equals("N")) { 
			bean.getclearscheduleFrequency(drug_code+srl_no);
			frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(drug_code+srl_no);
		}
		// enable/disable calendar gif
		if(start_date==null || start_date.equals(""))
			calendar_status	=	"disabled";       //AAKH-CRF-0091	

		
		if(stat_yn.equals("Y") || parent_stat_yn.equals("Y"))    //AAKH-CRF-0091	

			calendar_status	=	"disabled";
		//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start
		if(bean.getTakeHomeDates()!=null && bean.getTakeHomeDates().size()>0){
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
				//String tempstartString  = start_date1.substring(0, 10);
				//String tempendString  = end_date1.substring(0, 10);
				//String systempString =sys_date.substring(11, sys_date.length());
				//start_date1 = tempstartString.concat(" "+systempString);
				//end_date1 = tempendString.concat(" "+systempString);
				buildMAR_enable="disabled";//Added for ML-BRU-SCF-1407 [IN 050482]
				buildMAR_checked="";//Added for ML-BRU-SCF-1407 [IN 050482]
				if(presDetails!=null && presDetails.size()>0 && (!amend_yn.equals("Y") && tappered_over.equalsIgnoreCase("N"))){
					start_date = tempstartdate1;
					end_date = tempenddate1;
				}
			}
		}//Added for Bru-HIMS-CRF-093-DD1[IN047223]--end
		
		// Current Rx 
		//corrected for PE by Naveen new method getPatientActiveOrders1(String patient_id,String patient_class) added in Prescription Bean
		/*ArrayList	active_orders		=	bean.getPatientActiveOrders(patient_id,patient_class,"",take_home);
		StringBuffer drug_description	=	new StringBuffer();
		int size						=	active_orders.size();
		HashMap	record					=	new HashMap();
		for(int i=0; i<size; i++)	{
			record					=	(HashMap)active_orders.get(i); 
			drug_description.append((String)record.get("drug_desc"));
			drug_description.append(" , ");
		}*/
		/*ArrayList	active_orders		=	bean.getPatientActiveOrders1(patient_id,patient_class);
		int active_orders_size			=	active_orders.size();
		StringBuffer drug_description	=	new StringBuffer();
		for(int i=0; i<active_orders_size; i++)	{
			drug_description.append(active_orders.get(i));
			drug_description.append(" , ");
		}*/	//PE corrections ends here

	// load applicable routes
	if(!calling_mode.equals("blank")) {	
		if(route_code==null || route_code.equals ("") )
			route_option= route_option + "<option value='' selected>&nbsp;&nbsp;&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.defaultSelect.label", "common_labels")+"---&nbsp;&nbsp;&nbsp;</option>";
		else
			actionText = presBean.getActionText(form_code,route_code);	 //add for SKR-CRF-0006[IN029561]					
		ArrayList routes				=	presBean.getRoutes(form_code); 
		for(int l=0; l<routes.size(); l+=3) { 
			backgrndColor="FFFFFF";
			fntColor="000000";
			route_color = (String)routes.get(l+2);
			if(route_color!= null && !route_color.equals("")){
				if(route_color.length()==12){
				    fntColor= route_color.substring(0, 6);
					backgrndColor= route_color.substring(6, 12);
				}
			}
			if( ((String)routes.get(l)).equals(route_code) ) {  
				route_option	= route_option + "<option style='color:"+fntColor+";background-color:"+backgrndColor+";' value='"+(String)routes.get(l)+"'selected>"+(String)routes.get(l+1)+"</option>";				 
			}
			else {	
				route_option	= route_option + "<option value='"+(String)routes.get(l)+"'   style='color:"+fntColor+";background-color:"+backgrndColor+";'>"+(String)routes.get(l+1)+"</option>";				
			}	
		}
		// Code Ends Here 

		ArrayList trades	=	presBean.getTrades(drug_code); 
//System.err.println("PrescriptionDetail_1.jsp-=--1004---loading-Drug--System.currentTimeMillis()---> " +System.currentTimeMillis()+"==drug_code===>"+drug_code);
		if(trades != null){
			for(int l=0; l<trades.size(); l+=2) { 
				if( ((String)trades.get(l)).equals(trade_code)) {  
					trade_option	= trade_option +"<option value='"+(String)trades.get(l)+"' selected>"+(String)trades.get(l+1)+"</option>";
				} 
				else {	
					trade_option	= trade_option+ "<option value='"+(String)trades.get(l)+"'>"+(String)trades.get(l+1)+"</option>";
				}	
			}
		}
		else
			trade_option="<option value=''>&nbsp;&nbsp;&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.defaultSelect.label", "common_labels")+"---&nbsp;&nbsp;&nbsp;</option>";

		if(trade_option.equals("")|| calling_mode.equals("taper") || calling_mode.equals("tapered"))
			trade_option_disable = "disabled";
		else
			trade_option_disable="";
	}
	// Legend and dosage unit is controlled based on dosage type
	if(dosage_type.equals("A")){
		dosage_legend	= com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels");
		dosage_option	= "<option value='A' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Absolute.label", "common_labels")+"</option>";
	}
	else if(dosage_type.equals("S")){
		dosage_legend	= com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels");
		dosage_option	= "<option value='S' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels")+"</option><option value='Q'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels")+"</option>";
	}
	else if(dosage_type.equals("Q")){
		dosage_legend	=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Dose.label", "ph_labels");
		if(ori_dosage_type.equals("S")){
			dosage_option	= "<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels")+"</option><option value='Q' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels")+"</option>";
		}
		else{
			dosage_option	= "<option value='Q' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels")+"</option>";
		}		
	}
	// Get the unit dose for scheduled
	if(!calling_mode.equals("blank") && split_dose_yn.equals("N")) {
		ArrayList schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
		if(schedule!=null && schedule.size() > 0) {
			 ArrayList dose_list	= (ArrayList)schedule.get(4);
			 if(dose_list!=null && dose_list.size()>0)
			    qty_value	= (String)dose_list.get(0);
		}
	}
	// Default Strength uom
	if(dosage_type.equals("S")){
		qty_option	=  "<option value='"+strength_uom+"' selected>"+strength_uom_desc+"</option>";
	} 
	if(qty_option.equals("")){
		qty_option  =  "<option value=''>&nbsp;&nbsp;&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.defaultSelect.label", "common_labels")+"---&nbsp;&nbsp;&nbsp;</option>";
	}
	boolean dup_found	=	false;
	// Load Frequency
	HashMap freqValues = null;

	if(!calling_mode.equals("blank")) {	
		if(calling_mode.equals("modify")){
			freqValues	=	(HashMap)bean.populateFrequencyValues(drug_code,freq_code,calling_mode,patient_class);
		}
		else{
			
		//AAKH-CRF-0091	starts
			
			if(stat_yn.equals("Y")){
			freqValues	=	(HashMap)bean.populateFrequencyValues(drug_code,freq_code,"modify",patient_class);
			
			}
			else{
		//AAKH-CRF-0091	ends
			freqValues	=	(HashMap)bean.populateFrequencyValues(drug_code,freq_code,"taper",patient_class);
			}
		}
		if(((orig_current_rx.equals("Y") && !amend_yn.equals("Y") )||(drug_db_duptherapy_flag.equals("Y"))) && allow_duplicate.equals("N") && !calling_mode.equals("tapered") && !calling_mode.equals("taper")) { //(patient_class.equals("IP") || take_home>0) && removed for IN30118-SCF No: MO-GN-5400.//&& !amend_yn.equals("Y") added for MO-GN-5490 [IN:054620]
			dup_found	=	true;
		}
//Below if part added for IN25872 --17/01/2011-- priya
//When 2 drugs with same FDB code were placed, on click of the first drug hyperlink, the frequency of the first drug was changed to Stat 
		ArrayList	freqCode	= (ArrayList) freqValues.get("FreqCode");
		ArrayList   freqDesc	= (ArrayList) freqValues.get("FreqDesc");
		ArrayList   FreqNature	= (ArrayList) freqValues.get("FreqNature");
		if(freqValues.size()>0 && (dup_found) && amend_yn.equals("Y")){ 

			/*if((priority != null && priority.equals("U") )) {
				for(int i=0;i<freqCode.size();i++){
					if( (bean.getFreqNature(((String) freqCode.get(i)))).equals("O")) {
						if(calling_mode.equals("modify")){
							if(freq_code.equals((String) freqCode.get(i))){
								freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
								freq_nature	    = "O";
								freq_code	    = ((String) freqCode.get(i));
								def_freq_found  = true;
							}
							else{
								freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  >"+(   (String) freqDesc.get(i))+"</option>";
							}
						}
						else{
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
							freq_nature	    = "O";
							freq_code	    = ((String) freqCode.get(i));
							def_freq_found  = true;
						}
					}
				}
			} 
			else */ //Commented for ML-BRU-SCF-1046 [IN:043889]
			if(allow_duplicate.equals("N")){
				ArrayList stat_freqs	=	presBean.loadStatFreqs();//commented for performance ML-MMOH-SCF-0684
//				ArrayList stat_freqs	=	presBean.getStatFreq();	//added for performaceML-MMOH-SCF-0684
//				if(stat_freqs!=null && stat_freqs.size()==0){ // if() Added for Performance
//					stat_freqs	= (ArrayList)presBean.loadStatFreqs();
//				}
				for(int i=0;i<stat_freqs.size();i+=2){
					if(freq_code.equals((String) stat_freqs.get(i))){
						freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
						freq_code	    = ((String) stat_freqs.get(i));
					}
					else{
						freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"' >"+((String) stat_freqs.get(i+1))+"</option>";
					}
					freq_nature	    = "O";
					//def_freq_found = true;
				}
			}
			else{
				for(int i=0;i<freqCode.size();i++){
					if( dup_found  && !amend_yn.equals("Y")) {
						if( ((String) FreqNature.get(i)).equals("O")) { //(bean.getFreqNature(((String) freqCode.get(i)))).equals("O")) changed for tuning
							freq_option	    = freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
							freq_nature	    = "O";
							freq_code	    = ((String) freqCode.get(i));
							def_freq_found  = true;
						}
					}
					else {
						if(((String) freqCode.get(i)).equals(freq_code)) {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
							freq_nature	    = (String) FreqNature.get(i); //bean.getFreqNature((String) freqCode.get(i));
							def_freq_found  = true;
						} 
						else {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'>"+((String) freqDesc.get(i))+"</option>";
						}
					}
				}
			} 
		}
		else if(freqValues.size()>0 && !(dup_found)){ // && !(dup_found) added while fixing IN25797 --14-01-2011-- priya
			/*if(priority != null && priority.equals("U")) {
				for(int i=0;i<freqCode.size();i++){
					if( (bean.getFreqNature(((String) freqCode.get(i)))).equals("O")) {
						if(calling_mode.equals("modify")){
							if(freq_code.equals((String) freqCode.get(i))){
								freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
								freq_nature	    = "O";
								freq_code	    = ((String) freqCode.get(i));
								def_freq_found  = true;
							}
							else{
								freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  >"+(   (String) freqDesc.get(i))+"</option>";
								def_freq_found  = true; //added for IN26318 --07/02/2011-- priya
							}
						}
						else{
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
							freq_nature	    = "O";
							freq_code	    = ((String) freqCode.get(i));
							def_freq_found  = true;
						}
					}
				}
			} 
			else{*/
				statFreqCode = freq_code;
				if(priority.equals("U") && !amend_yn.equals("Y")){
					ArrayList stat_freqs	=	presBean.loadStatFreqs();//commented for performance ML-MMOH-SCF-00684 un commented for GHL-ICN-0013
					//ArrayList stat_freqs	=	presBean.getStatFreq();	//added for performaceML-MMOH-SCF-00684
					//if(stat_freqs !=null && stat_freqs.size()==0){ //if () added for Performance ML-MMOH-SCF-00684
						//stat_freqs	= (ArrayList)presBean.loadStatFreqs();
					//}
					if(stat_freqs.size()>0){
						for(int i=0;i<stat_freqs.size();i+=2){
							statFreqCode=(String) stat_freqs.get(i);
							for(int j=0;j<freqCode.size();j++){
								freq_code=(String) freqCode.get(j);
								if(statFreqCode.equals(freq_code)){
									statFeqFound = true;
									break;
								}
							}
						}
					}
				}

				if(stat_yn.equals("Y")){    //AAKH-CRF-0091
					statFeqFound = true;
					dup_found=true;
				}
				int freq_count=0; //AAKH-CRF-0091 
				String prior=""; //AAKH-CRF-0091 
				def_freq_not_found = true;//Added for GHL-CRF-0508
				for(int i=0;i<freqCode.size();i++){
					if( dup_found ) {
						if( ((String) FreqNature.get(i)).equals("O")) { //bean.getFreqNature(((String) freqCode.get(i)))
							freq_option	    = freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
							freq_nature	    = "O";
							freq_code	    = ((String) freqCode.get(i));
							def_freq_found  = true;
							statFeqFound = true;
						}
					}
					else {
						if(((String) FreqNature.get(i)).equals("O"))//bean.getFreqNature(((String) freqCode.get(i))
							statFeqFound = true;
						if(((String) freqCode.get(i)).equals(statFreqCode)) {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
							def_freq_not_found= false;//Added for GHL-CRF-0508
							def_freq_found  = true;
							freq_nature	    = (String) FreqNature.get(i); //bean.getFreqNature((String) freqCode.get(i));
						} 
						else {
							//Added for GHL-CRF-0508 start
						if(default_freq_not_found){
							   if(def_freq_not_found){ 
							    freq_option= freq_option + "<option value='' selected>&nbsp;&nbsp;&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.defaultSelect.label", "common_labels")+"---&nbsp;&nbsp;&nbsp;</option>";
							    def_freq_not_found = false;
							 }	
						}
							//Added for GHL-CRF-0508 end
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'>"+((String) freqDesc.get(i))+"</option>";
							//def_freq_found  = true; //added while fixing IN26318 --07/02/2011-- priya //commented for ICN 31700 Reopened point
						}
					}
				}
					
				
			
			if(amend_yn.equals("Y"))
				def_freq_found  = true;
		}
		else if(dup_found ) { 
			for(int i=0;i<freqCode.size();i++){//added for MO-GN-5490 [IN:054620]
				if(((String) FreqNature.get(i)).equals("O")){
					freq_code = (String)freqCode.get(i);
					statFeqFound = true;
					break;
				}
			}
//			ArrayList stat_freqs	=	presBean.loadStatFreqs();	
			ArrayList stat_freqs	=	presBean.getStatFreq();	//added for performace ML-MMOH-SCF-00684
			if(stat_freqs !=null && stat_freqs.size()==0){ //Addded for Performance ML-MMOH-SCF-00684
				stat_freqs	= (ArrayList)presBean.loadStatFreqs();
			}
			for(int i=0;i<stat_freqs.size();i+=2){
				freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
				freq_nature	    = "O";
				//statFeqFound = true;//commented for MO-GN-5490 [IN:054620]
				//freq_code	    = ((String) stat_freqs.get(i)); //commented for MO-GN-5490 [IN:054620]
				//def_freq_found = true;
			}
		} 

		if(freq_option.equals("")) {
//			ArrayList stat_freqs	=	presBean.loadStatFreqs();
			ArrayList stat_freqs	=	presBean.getStatFreq();	//added for performace
			if(stat_freqs !=null && stat_freqs.size()==0){ // Added for Performance
				stat_freqs	= (ArrayList)presBean.loadStatFreqs();
			}
			for(int i=0;i<stat_freqs.size();i+=2){
				freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
				//def_freq_found = true;
				statFeqFound = true;
				freq_nature	   =	"O";
				freq_code	   = ((String) stat_freqs.get(i));
			}
		}
	}
	// Duration values
	if(!calling_mode.equals("blank")) {	
	//	DurnDescDetails	= (Hashtable)presBean.getDurnDesc();//added for performace ML-MMOH-SCF-0684
	//	if(DurnDescDetails !=null && DurnDescDetails.size()==0){ // if() Added for Performance
			DurnDescDetails	= (Hashtable)presBean.loadDurnDesc();
		//}
		Enumeration keys_des		= DurnDescDetails.keys();
		String	durn_code			= "";
		while(keys_des.hasMoreElements())	{
			durn_code		= (String)keys_des.nextElement();
			duration_option	= duration_option + "<option value='"+durn_code+"'>"+((String)DurnDescDetails.get(durn_code))+"</option>";
		}
	}

	// Dispense Location values
/*	if(!calling_mode.equals("blank")  && !(PhLicenceRights.getKey()).equals("PHBASIC") ) { 
		StringTokenizer disp_code	=	new StringTokenizer(disp_locn_code,"|");
		StringTokenizer disp_desc	=	new StringTokenizer(disp_locn_desc,"|");

		while(disp_code.hasMoreTokens()) {
			code.add(disp_code.nextToken());
		}

		while(disp_desc.hasMoreTokens()) {
			desc.add(disp_desc.nextToken());
		}
	}*/

	if(dosage_type.equals("A")) {
		//schedule_status		=	"disabled";
		absol_qty_status	=	"enabled";
	}
	else {
		if(!freq_nature.equals("P"))
			absol_qty			=	"1";
	}

	if(scheduled_yn.equals("N")) {
		schedule_status		=	"disabled";
	}
	// enable/disable refill button
	if(refill_cont_order_yn!=null && refill_cont_order_yn.equals("Y") && refill_yn.equals("Y") && refill_yn_from_param.equals("Y")){
		refill_status="";
	}
	// enable/disable order quantity legend
	if(dosage_type.equals("A") || freq_nature.equals("P")) {
		//qty_legend_style	=	"display:inline";
		qty_legend_style	=	"";
	}
	if(split_dose_yn.equals("Y")){
		Disable_recc_dose  =   "disabled";
	}

	if(freq_nature.equals("P")){
		prn_yn = "Y";
	}
	if( drug_tapered.equals("Y") || stat_yn.equals("Y")) //Added for [IN:038913] Bru-HIMS-CRF-093/18 //|| tappered_over.equals("Y")) - commented for SKR-SCF-0955 [IN:047620]	//stat_yn.equals("Y") added for AAKH-CRF-0091
		taper_disable="disabled";
%>
<!-- Drug Attributes ends-->

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="prescription_detail_form" id="prescription_detail_form" >
	<!-- Below table for CurrentRx details-->
		<table border="0" width="100%" cellspacing="0" cellpadding="0">
			<tr>
				<td  width="10%">
				<input type="button" class="button" value='<fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/>'  onClick="javascript:callActiveOrders('<%=patient_id%>','<%=encounter_id%>','','<%=patient_class%>');"></td>
				<td class="CURRTEXT"  width="75%">&nbsp;
				<!-- <marquee scrollamount="3" title='<fmt:message key="ePH.ClickCurrentRxbuttontoViewCurrentMedication.label" bundle="${ph_labels}"/>'><font  style="font-weight:bold;color:black" size=1></font></marquee> -->
				</td>
				<td class="label"  width="10%"><input type='button' class='button' onClick="showDrugProfile('<%=patient_id%>','Prescription','<%=encounter_id %>')" value='<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/>'></td> <!--encounter_id added for AAKH-CRF-0088.2 --> 
			</tr>
		</table>
<!--CurrentRx table ends-->

<!-- Prescription Writer Table starts-->
<%
	if((allow_without_diag.equals("Y")) ||(allow_without_diag.equals("N") && diag_size!=0) ){
		//if(allergic_yn.equals("N")||allergic_yn.equals("")){
%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
				<td class='COLUMNHEADER' colspan="6" style="font-size:9" ><fmt:message key='ePH.DrugDetail.label' bundle='${ph_labels}'/></td>
					<tr>
						<td class="label"  width="15%"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
<%-- 						<td class="label"  width="45%" colspan="3" ><input type="text" name="drug_name" id="drug_name" id='drug_name_id' size="35"  maxlength="42" value="<%=drug_desc%>"><input type="button" name="drug_search" id="drug_search" value="?" class="button"  onClick="searchDrugName();" onFocus="searchDrugName();" <%=alternateDisable %>>&nbsp;<img  src="../../eCommon/images/mandatory.gif"></img><!-- alternateDisable	//added for  JD-CRF-0198 [IN:058599] --> --%>
					<!-- Modified for TFS id:7345 start -->
						<%if(pre_alloc_appl_yn.equals("Y") && drug_search_by.equals("G")){ %>
						<td class="label"  width="45%" colspan="3" ><input type="text" name="drug_name" id="drug_name" id='drug_name_id' size="35"  maxlength="42" value="<%=drug_desc_new%>" onChange="searchDrugName();" <%=alternateDisable %>><input type="button" name="drug_search" id="drug_search" value="?" class="button"  onClick="searchDrugName();" <%=alternateDisable %>>&nbsp;<img  src="../../eCommon/images/mandatory.gif"></img><!-- alternateDisable	//added for  JD-CRF-0198 [IN:058599] //removed onFocus for SKR-SCF-1317  //OnChange Added for SKR-SCF-1385-->
					<%}else{ %>
						<td class="label"  width="45%" colspan="3" ><input type="text" name="drug_name" id="drug_name" id='drug_name_id' size="35"  maxlength="42" value="<%=drug_desc%>" onChange="searchDrugName();" <%=alternateDisable %>><input type="button" name="drug_search" id="drug_search" value="?" class="button"  onClick="searchDrugName();" <%=alternateDisable %>>&nbsp;<img  src="../../eCommon/images/mandatory.gif"></img><!-- alternateDisable	//added for  JD-CRF-0198 [IN:058599] //removed onFocus for SKR-SCF-1317  //OnChange Added for SKR-SCF-1385-->
						
<%}//Modified for TFS id:7345 end
							if(!drug_code.equals(""))	{
%>						
								<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height='20'  width='20' onClick="openEDLDetails('<%=drug_code%>');"></img>
<%
							}                    
%>                     
							<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" name="preg_alert" value="" src="../../ePH/images/Pregnancy.bmp" height='20'  width='20' onClick="chkPregnencyAlert();" style='<%=preg_icon_disp%>'></img>
						</td>
						<td class="label" width="12%"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
<%
						if( bean.getExternalpatient_id()==null || bean.getExternalpatient_id().equals("") ){
%>
							<!--  ** Added a new function to change the Build MAR Check Box based on priority selection  - RUT - CRF- 0062
								<td class="label"  width="28%">&nbsp;<select name="priority" id="priority" onchange="defFreq(this);freqChange(frequency,'Y')">
							-->
							<!--  RUT-CRF-0062 [IN029600]  Added getBuildMARDefaulting() function to change Build MAR based on Build MAR Rule  -->				
							<td class="label"  width="28%">&nbsp;<select name="priority" id="priority" onchange="getBuildMARDefaulting();defFreq(this);" <%=taper_disable%>>
							
							<%//AAKH-CRF-0091 starts						
									if(stat_yn.equals("Y")){
										
										
								%>	
									
							
									<option value="U" selected><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
									</select>
							</td>
									<% 
									}
									else{
						//AAKH-CRF-0091 ends			%>
						
									<option value="R" <%=r_priority%>><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
									<option value="U" <%=u_priority%>><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
									</select>
							</td>								
				
									<%
									//AAKH-CRF-0091
									}
								%>
								
								
								
<%
						}
						else{
%>
							<td class="label"  width="28%"><select name="priority" id="priority" >
							<option value="R" <%=r_priority%>><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
							</select>
							</td>
<%
						}
%>
					</tr>
					<tr>
						<td class="label"   width="15%"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></td>
<%						
						if(!calling_mode.equals("blank")) { 
							uom_disp = bean.getUomDisplay((String)session.getValue("facility_id"),strength_uom);
							if(uom_disp == null || uom_disp.equals("null"))
								uom_disp = "";
							if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1)
								strength_value = Float.parseFloat(strength_value)+"";//"0"+strength_value ;
								//added for NMC-JD-CRF-0026 start
						if(strength_display_app && strength_value!=null && strength_value!=""){
%>
							<td class="data" id="strength" width="20%">&nbsp;<%=strength_value%>&nbsp;<%=uom_disp%> / <%=strength_per_value_pres_uom%>&nbsp;<%=pres_base_uom_desc%></td>
<%							}else{
	
%>
					<td class="data" id="strength" width="20%">&nbsp;<%=strength_value%>&nbsp;<%=uom_disp%></td>
<%
}	}	//added for NMC-JD-CRF-0026 end
						else{
%>						
						<td class="data" id="strength" width="20%">&nbsp;&nbsp;</td>
<%
						}	
%>
						<td class="label"  width="25%" colspan="2"><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/>&nbsp;&nbsp;<label id="form" style="font-weight:bold"><%=form_desc%></label></td>
						<td class="label"  width="15%"><fmt:message key="Common.Route.label" bundle="${common_labels}"/>&nbsp;</td>
						<td class="label"  width="30%"><select name="route_code" id="route_code" onChange="getFormatId(this);getActionText(this,'<%=form_code%>');changeRoute();" onBlur="(this);" style="width:150;" <%=taper_disable%>><!-- add getActionText function for SKR-CRF-0006[IN029561]  //changeRoute added for SKR-SCF-0586 IN[034375] Reopened-->
<%
						if(calling_mode.equals("blank")) { 
%>
							<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<%
						} 
%>
						<%=route_option%>
						</select>
						</td>
					</tr>
					<tr>
<%						if(trade_display_yn.equals("Y")){
%>
							<td class='label' width="15%"> <fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
							<td class="label"  width="20%" >

							<select name="trade_code_option" id="trade_code_option" onChange="assignTradeCode(this)" <%=trade_option_disable%>>
<%
							if(calling_mode.equals("blank")) { 
%>
								<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<%
							} 
%>
							<%=trade_option%>
							</select>
							<input type='hidden' name='trade_code' id='trade_code' value='<%=trade_code%>'>
							<input type='hidden' name='trade_name' id='trade_name' value='<%=java.net.URLEncoder.encode(trade_name,"UTF-8")%>'>
							
							</td>
<%						}
						else{

%>
							<td class='label' colspan='2'>&nbsp;</td><!--added for alignment issue for SKR-CRF-0006 ICN 29561 -->
							<input type='hidden' name='trade_code' id='trade_code' value=''>
							<input type='hidden' name='trade_name' id='trade_name' value=''>
<%						}
%>
						<td class='label' colspan='3'> <!-- change colspan='5' to colspan='3'  for  SKR-CRF-0006[IN029561]-->
<%
						if(MAR_app_yn.equals("Y")){
							
						if(!ext_disp_appl_yn.equals("Y")){ 
%>
						<!-- Start of NMC-JD-CRF-0046-->	
						<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
						<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='<%=buildMAR_yn%>' <%=buildMAR_checked%> <%=buildMAR_enable%> onclick='assignValue1(this);'>
<%
						}else{ 
%>
						
								<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
							<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value="N" disabled >    <!-- End of NMC-JD-CRF-0046-->
					<%	}						
						}
						else{
%>
							<!-- &nbsp;<input type='hidden' name='buildMAR_yn' id='buildMAR_yn' value='N'> -->
							<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
							<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='N' disabled>
<%
						}
%>
<%
							if(item_type_site_app && disp_by_alt_form_param.equals("Y") && (bean.getExternalpatient_id()==null || bean.getExternalpatient_id().equals(""))){ //GHL-CRF-549
%>
							<fmt:message key="ePH.AllowAlternate.label" bundle="${ph_labels}"/>&nbsp;
							<input type='checkbox' name='allow_alternate_yn' id='allow_alternate_yn' value='<%=allow_alternate_yn%>' <%=disabled%> <%=checked%> > <!-- GHL-CRF-0549-->
<%
							}							
%>						</td>
						<!-- add this td and label for  SKR-CRF-0006[IN029561]-- start -->
						<td class='label'><label style='color:red;' id="actionTextval" ><%=actionText%>
						 </label></td>
						<!-- add this td and label for  SKR-CRF-0006[IN029561]-- end -->
					</tr>
					<tr>
					<td >&nbsp;</td>
<%
						display_auth_rule = "visibility:hidden";
						if(ord_auth_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							color_auth_rule = "color:red";
							if(ord_authorized_yn.equals("Y"))
								color_auth_rule = "color:green";

						}
%>
						<td class="label" align='center'><label id='lbl_authorize' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></label></td>
						
<%
						display_auth_rule = "visibility:hidden";
						color_auth_rule   = "color:red";
						if(ord_spl_appr_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							if(ord_approved_yn.equals("Y"))
								color_auth_rule = "color:green";
						}
%>
						<td class="label"  align='center' colspan='2'><label id='lbl_splapprvl' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="ePH.splapproval.label" bundle="${ph_labels}"/></label></td>
<%
						display_auth_rule = "visibility:hidden";
						color_auth_rule   = "color:red";
						if(ord_cosign_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							if(ord_cosigned_yn.equals("Y"))
								color_auth_rule = "color:green";
						}
%>
						<td class="label" align='center'><label id='lbl_cosign' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="Common.Cosign.label" bundle="${common_labels}"/></label></td>
						<td  class="label"><a href="javascript:viewReasonforRequest('<%=order_id%>');" id="tdm_details"  style="font-size:9;<%=display_tdm%>"  title="TDM Result"><fmt:message key="ePH.TDM.label" bundle="${ph_labels}"/> </a>&nbsp;</td>
					</tr>

					<tr>
						<td class='COLUMNHEADER' colspan="6" style="font-size:9"  ><fmt:message key="ePH.DosageDetail.label" bundle="${ph_labels}"/></td>
					</tr>
					<tr>
						<td class="label"  ><fmt:message key="Common.DosageBy.label" bundle="${common_labels}"/></td>
						<td  class="label" colspan="2"><select name="dosage" id="dosage" onChange="dosageChange(this);makeDefaultQtyvalueEmpty();" style="width:100;" <%=parent_disable%>><!--makeDefaultQtyvalueEmpty added for AAKH-CRF-089-->
<%
						if(calling_mode.equals("blank")) {
%>
							<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<%	
						}	
%>
						<%=dosage_option%>
						</select>
						
						</td>
<%	//Added for RUT-CRF-0088 [IN036978] --begin				
						String sch_size			=	"1";
						ArrayList schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
						if(schedule!=null && schedule.size() > 0) {
	 						ArrayList dose_list	= (ArrayList)schedule.get(4);
							
							if(dose_list != null && dose_list.size() > 0 && (split_dose_yn_val.equals("N")) && !(freq_nature.equals("O"))) {
								sch_size		=	""+dose_list.size();
								if(freq_nature.equals("I")) 
									sch_size = "1";
							}
						}
						freq_chng_durn_value = durn_value;
						if(!freq_chng_durn_desc.equals(repeat_durn_type)){
							freq_chng_durn_value = (String)bean.getFreqDurnConvValue(repeat_durn_type,durn_value,freq_chng_durn_desc);
						}
						if(dosage_type.equals("Q"))
							conv_factor = (String) bean.getConvFactor(qty_desc_code,pres_base_uom);
						//RUT-CRF-0088 [IN036978] -- end
						if(!(calling_mode.equals("blank"))) {
							if(qty_value == null || qty_value.equals("") || qty_value.equals("0") )
								qty_value = "1";
							else
								qty_value = java.lang.Math.abs(Float.parseFloat(qty_value))+"";
						}
					
						if(qty_value != null && qty_value.equals("") && !drug_code.equals("")){
							qty_value = "1";

							if( Float.parseFloat(qty_value) < 1)
								qty_value = Float.parseFloat(qty_value)+"";
						}
						if(amend_yn.equals("N")){
							 def_qty_value = qty_value;
						}
						if(split_dose_yn.equals("Y")){ 
%>
							<td  align='right'><input type="text" id='id_qty_value' name="qty_value" id="qty_value" size="10" maxlength="13" class="NUMBER"  value="<%=qty_value%>" <%=parent_disable%> onchange="if(lookForChange(this)) {durationConversn(document.prescription_detail_form.durn_desc);} getTotalTaperQty('<%=in_formulary_yn%>','TAP_LVL_QTY','N');doseChange(this);"  onKeyPress="checkBeforeDecimal(this, event); return allowValidNumber(this,event,8,<%=dose_decimal%>);" oncopy="return false" onpaste="return false"></td><!--added checkBeforeDecimal() function for ML-BRU-SCF-1437 -->
<%
						}
						else{
%>
							<td align='right'><input type="text" id='id_qty_value' name="qty_value" id="qty_value" size="10" maxlength="13" class="NUMBER"  value="<%=qty_value%>" <%=parent_disable%> onchange="if(freqChange(frequency,'Y','N','ChangeFreq')){ changedoseoverridevalue();durationConversn(document.prescription_detail_form.durn_desc);} getTotalTaperQty('<%=in_formulary_yn%>','TAP_LVL_QTY','N');doseChange(this);" onKeyPress="checkBeforeDecimal(this, event); return allowValidNumber(this,event,8,<%=dose_decimal%>);" oncopy="return false" onpaste="return false"></td><!--added checkBeforeDecimal() function for ML-BRU-SCF-1437 -->
<%
						}
%>
						<td class='fields'>
							<select name="qty_desc" id="qty_desc" style="width:110;" <%=parent_disable%> onchange='extDosageCheck();onChangeUOM();'> <!--added for SKR-SCF-0309.1  [IN030625]  -->
<%
							if(calling_mode.equals("blank")) {
%>
								<option VALUE="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<%	
							}
%>
							<%=qty_option%>
							</select>
						</td>
						<td class="label" id="dosage_label" colspan="1" style='TEXT-ALIGN:center;'><%=dosage_legend%>&nbsp;&nbsp;</td>
					</tr>
					<tr nowrap>
						<td class="label" ><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
						<td class="label" colspan="5"><select name="frequency" id="frequency" onChange="freqChange(this,'Y','N','ChangeFreq','pBilling');getTotalTaperQty('<%=in_formulary_yn%>','TAP_LVL_QTY','N','pBilling');assignHomeDuration();getChargeDetails('<%=in_formulary_yn%>');removeRefill();" style="width:380px;" <%=parent_disable%>><!-- //added pBilling for performance issue MMS --><!-- Modified for IN:069886 -->
<%
						if(calling_mode.equals("blank")) { 
%>	
							<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%	
						}	
%>
						<%=freq_option%>
						</select>&nbsp;
						<input id="dis_split_dose" type="button" class="button" value='<fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>' style="visibility:visible" name="split_dose" onClick="DisplaySchedule()" <%=schedule_status%> <%=taper_disable%>></td>
                       </tr>  
                       <tr>
						<td  class="label" colspan="3" style='TEXT-ALIGN:right;'><a href="javascript:callPRNDetails();" id="prn_remarks" style="visibility:hidden" title='<fmt:message key="ePH.PRNRemarks.label" bundle="${ph_labels}"/>'><fmt:message key="ePH.PRNRemarks.label" bundle="${ph_labels}"/></a><img   style="visibility:hidden"  id="prn_remarks_image" src="../../eCommon/images/mandatory.gif"></img></td>
                    
						<td class="label" colspan="2"><label id='rec_legend' onclick='changeschedule()' style="visibility:hidden">
<%
						if(split_dose_yn.equals("N") && (dosage_type.equals(recomm_dosage_by))){
%>
							<font id='rec_legend_font' class='HYPERLINK' onmouseover='changeCursor(this);'>
<%
						}
						else{
%>
							<font id='rec_legend_font' class='' >
<%
						}
%>
							<fmt:message key="ePH.Recom.Dose.label" bundle="${ph_labels}"/></font></label>
							<label id="rec_value" style="font-size:11;font-weight:bold;color:red;"></label>
							&nbsp;<label id="rec_uom" style="font-size:11;font-weight:bold;color:red"></label>
						</td>
						</tr>
						<td class='COLUMNHEADER' colspan="6" style="font-size:9" ><fmt:message key="ePH.DurationDetail.label" bundle="${ph_labels}"/></td>
						<tr>
							<td class="label"  ><fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
							<td class="label"  ><input type="text" size="1" maxlength="3" name="durn_value" id="durn_value" class="NUMBER"  value="<%=durn_value%>"  onblur="validateDuration(this);putDecimal(this,3,0);populateEndDate();durationConversn(durn_desc);getChargeDetails('<%=in_formulary_yn%>');chkPopulateRefill();extDosageCheck();getTotalTaperQty('<%=in_formulary_yn%>','TAP_LVL_QTY','N');assignHomeDuration();"  onKeyPress="return(ChkNumberInput(this,event,'0'))" onChange="removeRefill();" <%=taper_disable%>>&nbsp;<!--Added onchange="assignHomeDuration(); for Bru-HIMS-CRF-093-DD1[IN047223]  getChargeDetails('<%=in_formulary_yn%>'); added for MMS-DM-CRF-0126.1 durationConversn(this) addded for tbmc-scf-0051 and SKR-SCF-1237 --> <!-- modified for IN:069886 -->
							<select name="durn_desc" id="durn_desc" onChange="validateDuration(durn_value);populateEndDate();durationConversn(this);getChargeDetails('<%=in_formulary_yn%>');getTotalTaperQty('<%=in_formulary_yn%>','TAP_LVL_QTY','N');assignHomeDuration();chkPopulateRefill();removeRefill();" <%=taper_disable%>> <!-- getChargeDetails('<%=in_formulary_yn%>'); added for MMS-DM-CRF-0126.1 --> <!-- modified for IN:069886 -->
							<!-- <option>-<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-</option> -->
							<%=duration_option%>
							</select>
							<input type="hidden" name="tmp_durn_value" id="tmp_durn_value" value="<%=durn_value%>">
							<input type="hidden" name="tmp_durn_desc" id="tmp_durn_desc"  value="D">
							</td>
<%
							String tot_taper_visible="display:none;";
							//String editTotTaper="";
							if((tappered_over.equals("Y") || drug_tapered.equals("Y"))&& totalTaperQtyDisplay.equals("Y")){
								if(!parent_disable.equals("") || tappered_over.equals("Y")){
									//tot_taper_visible="display:inline;";
									tot_taper_visible="";
									qty_legend_style = "display:none"; //added for RUT-SCF-0155 [IN:033595]
								}
								//if(tappered_over.equals("Y"))
									//editTotTaper="readOnly";
								if(totTapperQty==0 || (tappered_over.equals("N") && drug_tapered.equals("Y") && tap_lvl_qty.equals(""))){    //Commented for RUT-CRF-0088 [IN036978]
									//totTapperQty = bean.getTotalTaperQty(drug_code, srl_no,"ONTAPER",qtyValue,durnValue,repeatValue,intervalValue);
									float qtyValue=1.0f;
									float durnValue=1.0f;
									float repeatValue=1.0f;
									float intervalValue=1.0f;
									if(dosage_type.equals("A"))
										qty_value = absol_qty;
									for(int i=0;i<presDetails.size();i++){//Added for  RUT-SCF-0321 [IN044816]--start
										taperDetails		= (HashMap)presDetails.get(i);
										extdrugCode			= (String)taperDetails.get("DRUG_CODE");
										if(extdrugCode.equals(drug_code)){
											totTapperQty				=  Float.parseFloat(taperDetails.get("TOTTAPPERQTY")==null?"0":(String) taperDetails.get("TOTTAPPERQTY"));
											if(temps < totTapperQty)
												temps=totTapperQty;
										}
									}
									totTapperQty = temps;//Added for  RUT-SCF-0321 [IN044816]--end
									tap_lvl_qty = bean.getOrderQty(taperdrugDetails,qty_value,"",durn_value,"",dosage_type,conv_factor,split_dose_yn.equals("Y"));
									taperdrugDetails.put("TAP_LVL_QTY", tap_lvl_qty+"");
									if(totTapperQty==0){
										totTapperQty = Float.parseFloat(tap_lvl_qty);
									}
								}
								if((taperdrugDetails.get("LOADED_YN")==null || taperdrugDetails.get("LOADED_YN").equals("N")) && !amend_yn.equals("Y") ){
									totTapperQty+= Float.parseFloat(tap_lvl_qty);
									taperdrugDetails.put("LOADED_YN", "Y");
									taperdrugDetails.put("TOTTAPPERQTY", totTapperQty+"");//Added for  RUT-SCF-0321 [IN044816]
								}
								if(!tap_lvl_qty.equals(""))
									tap_lvl_qty = ((int)Float.parseFloat(tap_lvl_qty))+"";
								if(dosage_type.equals("A"))
									taperdrugDetails.put("ABSOL_QTY", tap_lvl_qty+"");
									//drugDetails.put("TOTTAPPERQTY", totTapperQty+"");//Commeneted for  RUT-SCF-0321 [IN044816]
							}
							drugDetails = taperdrugDetails;//Added for  RUT-SCF-0321 [IN044816]
%>
							<td  class='label' align='right' colspan='2'><label id="ord_qty_lbl" style="<%=qty_legend_style%>;color:red;font-weight:bold;" ><fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/></label>&nbsp;</td>
							<td class="data" >&nbsp;
								<input class='NUMBER' type="text" size="3" maxlength="5" name="absol_qty" id="absol_qty" value="<%=absol_qty%>" onchange="ValidateAbs(this);getChargeDetails('<%=in_formulary_yn%>','ABS_QTY'); populateEndDate();<%=visable_dose_for_prn%>" onKeyPress="return(ChkNumberInput(this,event,'0')); " <%=absol_qty_status%> style="<%=qty_legend_style%>" <%=parent_disable%>>&nbsp;&nbsp;
								<label id="ord_qty_uom" style="<%=qty_legend_style%>"><%=stock_uom%></label></td>
							<td  class='label' align='right' style='<%=tot_taper_visible%>'>
								<label id="tap_lvl_qty_lbl" style="color:red;font-weight:bold;font-size:9;" ><fmt:message key="Common.Taper.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Qty.label" bundle="${common_labels}"/>    <!--  Modified for RUT-CRF-0088 [IN036978]-->
								</label>&nbsp;&nbsp;
								<input class='NUMBER' type="text" size="3" maxlength="3" name="tap_lvl_qty" id="tap_lvl_qty" value="<%=tap_lvl_qty%>"  onchange="ValidateAbs(this,'TAP_LVL_CHANGE', '<%=tappered_over%>');getTotalTaperQty('<%=in_formulary_yn%>','TAP_LVL_CHANGE','N');" onKeyPress="return(ChkNumberInput(this,event,''))" > &nbsp;&nbsp;
								<label id="tap_lvl_qty_uom"  style="font-size:9;"><%=stock_uom%></label> <!--  Modified for RUT-CRF-0088 [IN036978]-->
							</td>
		<!-- added populateEndDate() onChangefor IN26267 --02/02/2011-- priya -->
						</tr>
						<tr>
							<td class="label"  ><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
							<td class="label"  ><input type="text" name="start_date" id="start_date" size="14"  maxlength="16" onblur="chkBackFutureDate(this,'<%=locale%>');assignHomeDuration();" value="<%=start_date%>" <%=taper_disable%>><img SRC="../../eCommon/images/CommonCalendar.gif" name='stateDateImg' <%=calendar_status%> onclick="if(document.prescription_detail_form.start_date.disabled){return false;};showCalendar('start_date',null,'hh:mm');" <%=taper_disable%>></td><!--Added assignHomeDuration(); for Bru-HIMS-CRF-093-DD1[IN047223]-->
							<td class="label"  colspan="2" nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type="text" name="end_date" id="end_date" size="14"  maxlength="16" value="<%=end_date%>" readonly onblur="validateEndDate(this,'<%=locale%>');" <%=taper_disable%>><img SRC="../../eCommon/images/CommonCalendar.gif"  name='endDateImg' <%=calendar_status%> onclick="if(document.prescription_detail_form.end_date.disabled){return false;};showCalendar('end_date',null,'hh:mm');" <%=taper_disable%>></td><!--Added assignHomeDuration(); for Bru-HIMS-CRF-093-DD1[IN047223]-->
		<!-- code modified for External Prescription..  -->
							<td class="label"    style="" >   <!--Modified for RUT-CRF-0088 [IN036978]-->
<%
							if( (bean.getExternalpatient_id()==null ||  bean.getExternalpatient_id().equals("")) && !(patient_class.equals("IP"))){
%>
								<input type="button" class="button" value='<fmt:message key="ePH.Refill.label" bundle="${ph_labels}"/>'  style="visibility:visible" name="allow_refill" id="allow_refill"  onClick="loadRefillDetails('<%=max_refills_for_pres%>')" <%=refill_status%> <%=taper_disable%> <%=alternateDisable %>>&nbsp;&nbsp;<!-- 		alternateDisable//added for  JD-CRF-0198 [IN:058599] -->
<%
							}
							else{
%>
								<input type="button" class="button" value='<fmt:message key="ePH.Refill.label" bundle="${ph_labels}"/>'  style="visibility:hidden" name="allow_refill" <%=taper_disable%> <%=alternateDisable %>>&nbsp;&nbsp;<!-- 		alternateDisable//added for  JD-CRF-0198 [IN:058599] -->
<%
							}
%>
							<input type="button" class="button" value='<fmt:message key="Common.override.label" bundle="${common_labels}"/>'  style="visibility:hidden;" id="dosage_limit"  name="dosage_limit"  onclick="showOverRideRemarks(document.prescription_detail_form)" >&nbsp;
							<!-- Added for IN:072715 START -->
							<%if(over_ride_remarks_select_appl){System.out.println("over_ride_remarks_select_appl"+over_ride_remarks_select_appl); %>
							<input type="checkbox" class="label" value="<%=Override_Check%>" style="visibility:hidden" name="override_remarks" id="override_remarks" <%=Override_Checked%> <%=checkEnabled%> onclick="showOverRideRemarks(document.prescription_detail_form)"  >
							<%}else{ %>
							<input type="checkbox" class="label" value="<%=Override_Check%>" style="visibility:hidden" name="override_remarks" id="override_remarks" <%=Override_Checked%> <%=checkEnabled%> onclick="checkOverRideRemarks(document.prescription_detail_form)"  >
							<%} %>
							<!-- Added for IN:072715 END -->
								<input type="hidden" name="practitioner_name" id="practitioner_name" value="" >
								<input type="hidden" name="checkEnabled" id="checkEnabled" value="<%=checkEnabled%>" >
							</td>
							<td  class='label' align='right' style='<%=tot_taper_visible%>'>    <!--Moved down for RUT-CRF-0088 [IN036978]  -->
								<label id="tot_tap_qty_lbl" style="color:red;font-weight:bold;font-size:9;" ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Taper.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Qty.label" bundle="${common_labels}"/>
								</label>&nbsp;&nbsp;
<%
								if(calling_mode.equalsIgnoreCase("tapered")|| calling_mode.equalsIgnoreCase("taper")){// Modified for RUT-SCF-321[IN044816]--begin 
%>
									<input class='NUMBER' type="text" size="3" maxlength="3" name="totTapperQty" id="totTapperQty" value="<%=(int)totTapperQty%>"  onchange="ValidateAbs(this,'TOT_TAPER');populateEndDate();updateTapLvlQty('<%=drug_code%>','<%=srl_no%>',this,'<%=(int)totTapperQty%>')" onKeyPress="return(ChkNumberInput(this,event,'0'))" > &nbsp;&nbsp;
<%
								}								
								else{
%>
									<input class='NUMBER' type="text" size="3" maxlength="3" name="totTapperQty" id="totTapperQty" value="<%=(int)totTapperQty%>" disabled onchange="ValidateAbs(this,'TOT_TAPER');populateEndDate();updateTapLvlQty('<%=drug_code%>','<%=srl_no%>',this,'<%=(int)totTapperQty%>')" onKeyPress="return(ChkNumberInput(this,event,'0'))" > &nbsp;&nbsp;
<%
								}//Modified for RUT-SCF-321[IN044816]--end
%>
								<label id="taper_qty_uom"  style="font-size:9;"><%=stock_uom%></label>
							</td>
							<input type='hidden' name='prevTotalTaperQty' id='prevTotalTaperQty' value='<%=((int)totTapperQty)%>'>
							<input type='hidden' name='totalTaperQtyDisplay' id='totalTaperQtyDisplay' value='<%=totalTaperQtyDisplay%>'>
						</tr>
<%		
						String dup_drug_info	=	""; //moved from inside if condition forMO-GN-5490 [IN:054620] -start
						ArrayList curr_info	=null;
						if(allow_duplicate.equals("N")){
							curr_info		=	bean.getDuplicateDrugs(patient_id,generic_id);
							HashMap  dup_info		=	null;
							if(curr_info.size()>=1) {
								dup_info	  =	(HashMap)curr_info.get(0);
								dup_drug_info = "Patient is Currently On "+generic_name+" Medication till :"+dup_info.get("end_date")+";\n";
								dup_drug_info = dup_drug_info+"Has been prescribed by :"+dup_info.get("practitioner_name")+" from "+dup_info.get("location");
							}
							/*else{ //Commented else condition for MO-GN-5498 [IN:056880] and added below inside the if condition
								dup_drug_info = "Patient is Currently On "+generic_name+" Medication";
							}*/
						} //moved from inside if condition for MO-GN-5490 [IN:054620] -end
						if(current_rx != null && (current_rx.equals("Y")||(drug_db_duptherapy_flag.equals("Y"))) && allow_duplicate.equals("N")) { // && (patient_class.equals("IP")||  take_home>0)
%>
							<tr>
								<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
								<td class="label" nowrap><fmt:message key="ePH.DispenseLocation.label"  bundle="${ph_labels}"/></td>
								<td class="label"><input type="text" size="20" maxlength="20" name="disp_locn_desc" id="disp_locn_desc" disabled value="<%=disp_locn_desc%>"></td>
								<td class="label" >
									<a href="javascript:callOrder();" id="drug_remarks" style="visibility:visible" title='<fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/>'><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/></a>
									<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 start -->
									<img  src="../../eCommon/images/mandatory.gif" style='display:none;' id='DrugRemarksMandImg'>
									<input type='hidden' name='DrugRemarksMandatory' id='DrugRemarksMandatory' value='N'>
									<input type='hidden' name='DrugRemarksEntered' id='DrugRemarksEntered' value='<%=DrugRemarksEntered%>'>
								</td>
									<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 --end -->
									<!-- Added for  ML-BRU-CRF-072[Inc:29938] start-->
								<td class="label"  colspan="2">
									<a href="javascript:drugindication_remarks();" id="drug_ind_remarks" style="visibility:visible" title='<fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/>'><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></a>
								<!-- Added for  ML-BRU-CRF-072[Inc:29938] end-->
								<!-- Added for jd-crf-0220-->
							<%	if(drug_indication_mdry.equals("Y")){
								 %>	
								 &nbsp;<img  src="../../eCommon/images/mandatory.gif"></img>
								<%} %>
								</td>
							</tr>
<%
							if(allow_duplicate.equals("N") && curr_info!=null && curr_info.size()==0) //added for MO-GN-5498 [IN:056880]
								dup_drug_info = "Patient is Currently On "+generic_name+" Medication";
						}
						else {	//IN30118-SCF No: MO-GN-5400. OutPatient Duplicate Drug Check.
%>
							<tr>
<% 
								//if(!(PhLicenceRights.getKey()).equals("PHBASIC") ) { 	
%>
									<td class="label" nowrap><fmt:message key="ePH.DispenseLocation.label"  bundle="${ph_labels}"/></td>
									<td class="label"  >
<%
		// Dispense Location is displayed in list or text based on the no of values
	    // the below code for list box For External Prescription
									if(bean.getExternalpatient_id()!=null && !bean.getExternalpatient_id().equals("")){
										ArrayList ExternalPresDispCodes			= bean.getExternalPresDispCodes();
										ArrayList ExternalPresDispDesc			= bean.getExternalPresDispDesc();
%>
										<select name="disp_locn_code" id="disp_locn_code">
<%		
										if(ExternalPresDispCodes!= null && ExternalPresDispDesc !=null){
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
								<!-- <td class="label"   >&nbsp;</td>
								<td class="label" ><input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>"></td> -->
<%
							//}	
%>
							<td class="label"  colspan="2" style='TEXT-ALIGN:right;'>
<%
							//if( (patient_class.equals("OP") || patient_class.equals("EM") || drug_class.equals("C") || drug_class.equals("N"))&& !(take_home>0)) {

							if(pt_coun_reqd_yn!=null && pt_coun_reqd_yn.equals("Y")){
%>
								<fmt:message key="ePH.PatientCounsellingRequired.label" bundle="${ph_labels}"/>&nbsp;<input type="checkbox"  name="pat_counseling_reqd" id="pat_counseling_reqd" value ="N" onClick="assignValue1(this);"  <%=chk_pat_couns_req%>>&nbsp;
<%
							}
							if(!(patient_class.equals("OP") || patient_class.equals("EM"))) {	
%>
								<!-- Below parent_disable Condition is Added By SureshKumar T For SRR20056-SCF-7079[inc:26839] -->
								<br><fmt:message key="ePH.PatientBroughtMedication.label" bundle="${ph_labels}"/>&nbsp;<input type="checkbox" name="brought_by_pat" id="brought_by_pat" onClick="assignValue2(this);" <%=brought_by_pat_status%> <%=parent_disable%>>
<%
							}
%>
							</td>
							<td class="label" >
								<a href="javascript:callOrder();" id="drug_remarks" style="visibility:visible" title='<fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/>'><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/></a>
								<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 start -->
								<img  src="../../eCommon/images/mandatory.gif" style='display:none;' id='DrugRemarksMandImg'>
								<input type='hidden' name='DrugRemarksMandatory' id='DrugRemarksMandatory' value='N'>
								<input type='hidden' name='DrugRemarksEntered' id='DrugRemarksEntered' value='<%=DrugRemarksEntered%>'>
							</td>
								<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 --end -->
								<!-- Added for  ML-BRU-CRF-072[Inc:29938] start-->
							<td class="label"  colspan="2">
								<a href="javascript:drugindication_remarks();" id="drug_ind_remarks" style="visibility:visible" title='<fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/>'><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></a>
							<!-- Added for  ML-BRU-CRF-072[Inc:29938] end-->
								<!-- Added for  ML-BRU-CRF-072[Inc:29938] end-->
							<%	if(drug_indication_mdry.equals("Y")){
								 %>	
								 &nbsp;<img  src="../../eCommon/images/mandatory.gif"></img>
								<%} %>
							</td>
						</tr>
<%
					}
					String duspInfoDisplay = "display:none"; //Added for MO-GN-5490 [IN:054620]
					if(dup_drug_info!= null && !(dup_drug_info.equals(""))){
						//duspInfoDisplay = "display:inline;";
						duspInfoDisplay = "";
						
					}
%>
					<tr style="<%=duspInfoDisplay%>" id='trDupDrugInfo'>
						<td colspan="6" class="CURRTEXT">
						<marquee  scrollamount="4" ><font  style="font-weight:bold;color:black" size=1><%=dup_drug_info%></font></marquee>
						</td>
					</tr> <!-- tr moved from inside if condition for MO-GN-5490 [IN:054620] -->
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
					}
					else if(bl_override_excl_incl_ind.equals("E")){
						exclude_selected ="selected";
					}
					else {
						Select_selected ="selected";
					}
%>
                      <select name="bl_override_excl_incl_ind" id="bl_override_excl_incl_ind" onchange="assignOverrideExclInclInd(this)"  >
						  <!--  <option value="SEL">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option> --> 
							<%if(bl_override_allowed_yn.equals("I")){%>
							     <option value="SEL"<%=Select_selected%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
								<option value="I" <%=include_selected%>><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
<%
							}
							if(bl_override_allowed_yn.equals("E")){
%>
							     <option value="SEL"<%=Select_selected%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
								<option value="E" <%=exclude_selected%> ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
<%
							}
							if(bl_override_allowed_yn.equals("B")){
%>
							    <option value="SEL"<%=Select_selected%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							    <option value="I" <%=include_selected%> ><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
							    <option value="E" <%=exclude_selected%> ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
<%
							}
							if(bl_override_allowed_yn.equals("")){
%>
							      <option value="SEL"selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
							}
%>
						</select>
						</td>
						<input type='hidden' name='bl_def_override_excl_incl_ind' id='bl_def_override_excl_incl_ind' value='<%=bl_def_override_excl_incl_ind%>'>
						<input type='hidden' name='bl_override_allowed_yn' id='bl_override_allowed_yn' value='<%=bl_override_allowed_yn%>'>
						<td class="label" nowrap>
							<input type='text' name='bl_incl_excl_override_reason_desc' id='bl_incl_excl_override_reason_desc' size='40'  value='<%=bl_incl_excl_override_reason_desc%>' readonly >
<%
						if(bl_incl_excl_override_reason_desc.equals("")){
%>										
							<input type="button" name="bl_overriden_action_reason_lkp" id="bl_overriden_action_reason_lkp" value="?" class="button" onClick="searchBLOverrideReason('<%=locale%>');" disabled><img  src="../../eCommon/images/mandatory.gif" id='bl_overriden_action_reason_img' name='bl_overriden_action_reason_img' style='visibility:hidden;'></img>
<%
						}
						else{
%>
							<input type="button" name="bl_overriden_action_reason_lkp" id="bl_overriden_action_reason_lkp" value="?" class="button" onClick="searchBLOverrideReason('<%=locale%>');"><img  src="../../eCommon/images/mandatory.gif" id='bl_overriden_action_reason_img' name='bl_overriden_action_reason_img' style='visibility:visible;'></img>
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
<%
			//}
		}
%>
<!-- Prescription Writer Table ends-->

<!-- Hidden values starts-->
<%
		if(prn_remarks != null && !prn_remarks_dtl.equals("")) {
			prn_remarks_yn	=	"true";
		}
		else {
			prn_remarks_yn	=	"false";
		}
		//ML-MMOH-CRF-1823 US008- 43528 START
		//System.out.println("2346>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		ArrayList quotaLimitDtls = new ArrayList();
		int quotaLimitValue = 0;
		String setLimitByType = "";
		String quotaLimitReqYN = "N";
		String quotaCurrValue ="";
		
		if(quota_limit_site_yn.equals("Y")){
			quotaLimitReqYN = bean.getQuotaLimitCalcReqYN();
		}
		
			if(quotaLimitReqYN.equals("Y")){
				
			//	System.err.println("specialityCd@@=="+specialityCd);
				quotaLimitDtls = bean.getQuotaLimitValue(drug_code,specialityCd);
				if(quotaLimitDtls!=null && quotaLimitDtls.size()>0){
					setLimitByType = (String)quotaLimitDtls.get(0);
					quotaLimitValue = Integer.parseInt((String)quotaLimitDtls.get(1));
					quotaCurrValue = (String)quotaLimitDtls.get(2)==null?"0":(String)quotaLimitDtls.get(2);
					//System.err.println("setLimitByType@@==="+setLimitByType+"quotaLimitValue=="+quotaLimitValue+"quotaCurrValue=="+quotaCurrValue);
				}
		}
		
%>
		<input type="hidden" value="<%=setLimitByType%>" name="setLimitByType">
		<input type="hidden" value="<%=quotaLimitReqYN%>" name="quotaLimitReqYN">
		<input type="hidden" value="<%=quotaLimitValue%>" name="quotaLimitValue"> 
		<input type="hidden" value="<%=quotaCurrValue%>" name="quotaCurrValue"> <!-- ML-MMOH-CRF-1823 US008 - 43528 END -->
		<input type="hidden" value="<%=specialityCd%>" name="speciality_code"> <!-- This is going null in ph__patient_drug_profile now is null but it may required in future-->
		<input type="hidden" value="<%=presBean_id%>" name="presBean_id">
		<input type="hidden" value="<%=presBean_name %>" name="presBean_name">
		<input type="hidden" value="<%=bean_id%>" name="bean_id">
		<input type="hidden" value="<%= bean_name %>" name="bean_name">
		<input type="hidden" value="<%= patient_id %>" name="patient_id">
		<input type="hidden" value="<%= encounter_id %>" name="encounter_id">
		<input type="hidden" value="<%= bed_num %>" name="bed_num">
		<input type="hidden" value="<%= room_num %>" name="room_num">
		<input type="hidden" value="<%=mode%>" name="mode">
		<input type="hidden" value="<%=drug_code%>" name="drug_code">
		<input type="hidden" value="<%=ext_prod_id%>" name="ext_prod_id">
		<input type="hidden" value="<%=srl_no%>" name="srl_no">
		<input type="hidden" value="<%=tapper_srl_no%>" name="tapper_srl_no">
		<input type="hidden" value="<%=form_code%>" name="form_code">
		<input type="hidden" value="<%=strength_uom%>" name="strength_uom">
		<input type="hidden" value="<%=strength_uom_desc%>" name="strength_uom_desc">
		<input type="hidden" value="<%=pres_base_uom%>" name="pres_base_uom">
		<input type="hidden" value="<%=pres_base_uom_desc%>" name="pres_base_uom_desc">
		<input type="hidden" value="<%=dosage_type%>" name="dosage_type">
		<input type="hidden" value="<%=tab_qty_value%>" name="tab_qty_value">
		<input type="hidden" value="<%=strength_value%>" name="strength_value">
		<input type="hidden" value="" name="freq_value" id="freq_value">
		<input type="hidden" value="<%=interval_value%>" name="interval_value">
		<input type="hidden" value="<%=repeat_value%>" name="repeat_value">
		<input type="hidden" value="<%=freq_nature%>" name="freq_nature">
		<input type="hidden" value="<%=repeat_durn_type%>" name="repeat_durn_type">		
		<input type="hidden" value="" name="calcualted_durn_value" id="calcualted_durn_value">
		<input type="hidden" value="<%=max_durn_value%>" name="max_durn_value">
		<input type="hidden" value="<%=chk_for_max_durn_action%>" name="chk_for_max_durn_action">
		<input type="hidden" value="<%=calling_mode%>" name="calling_mode">
		<input type="hidden" value="<%=max_refills_for_pres%>" name="max_refills_for_pres">
		<input type="hidden" value="<%=max_durn_for_refill_pres%>" name="max_durn_for_refill_pres">
		<input type="hidden" value="<%=order_type_code%>" name="order_type_code">
		<input type="hidden" value="<%=back_date%>" name="back_date">
		<input type="hidden" value="<%=future_date%>" name="future_date">
		<input type="hidden" value="<%=rowVal%>" name="rowVal">
		<input type="hidden" value="<%=ord_auth_reqd_yn%>" name="ord_auth_reqd_yn">
		<input type="hidden" value="<%=quota_limit_access_yn%>" name="quota_limit_access_yn"> <!-- ML-MMOH-CRF-1823 US008- 43528 -->
		<input type="hidden" value="<%=force_auth_yn%>" name="force_auth_yn">
		<input type="hidden" value="<%=ord_spl_appr_reqd_yn%>" name="ord_spl_appr_reqd_yn">
		<input type="hidden" value="<%=ord_cosign_reqd_yn%>" name="ord_cosign_reqd_yn">
		<input type="hidden" value="<%=ord_approved_yn%>" name="ord_approved_yn">
		<input type="hidden" value="<%=ord_authorized_yn%>" name="authroize_yn_val">
		<input type="hidden" value="<%=ord_authorized_prev_yn%>" name="ord_authorized_prev_yn">
		<input type="hidden" value="<%=ord_cosigned_yn%>" name="ord_cosigned_yn">
		<input type="hidden" value="<%=split_dose_yn%>" name="split_dose_yn">
		<input type="hidden" value="<%=split_dose_yn_val%>" name="split_dose_yn_val">
		<input type="hidden" value="<%=scheduled_yn%>" name="scheduled_yn">
		<input type="hidden" value="<%=admin_time%>" name="admin_time">
		<input type="hidden" value="<%=admin_qty%>" name="admin_qty">
		<input type="hidden" value="<%=allergy_yn%>" name="allergy_yn">
		<input type="hidden" value="<%=limit_ind%>" name="limit_ind">
		<input type="hidden" value="<%=current_rx%>" name="current_rx">
		<input type="hidden" value="<%=mono_graph%>" name="mono_graph">
		<input type="hidden" value="<%=mono_graph%>" name="monograph">
		<input type="hidden" value="<%=generic_id%>" name="generic_id">
		<input type="hidden" value="<%=generic_name%>" name="generic_name">
		<input type="hidden" value="" name="in_durn_desc" id="in_durn_desc">
		<input type="hidden" value="" name="in_durn_value" id="in_durn_value">
		<input type="hidden" value="" name="in_dispensed_qty" id="in_dispensed_qty">
		<input type="hidden" value="" name="in_dispensed_uom" id="in_dispensed_uom">
		<input type="hidden" value="" name="in_bms_qty" id="in_bms_qty">
		<input type="hidden" value="" name="in_strength_value" id="in_strength_value">
		<input type="hidden" value="" name="in_strength_uom" id="in_strength_uom">
		<input type="hidden" value="" name="in_pres_qty_value" id="in_pres_qty_value">
		<input type="hidden" value="" name="in_pres_qty_uom" id="in_pres_qty_uom">
		<input type="hidden" value="" name="in_total_strength" id="in_total_strength">
		<input type="hidden" value="" name="in_total_strength_uom" id="in_total_strength_uom">
		<input type="hidden" value="<%=dflt_qty_uom%>" name="dflt_qty_uom">
		<input type="hidden" value="<%=qty_desc_code%>" name="qty_desc_code">
		<input type="hidden" value="<%=allergy_override%>" name="allergy_override">
		<input type="hidden" value="<%=dose_override%>" name="dose_override">
		<input type="hidden" value="<%=currentrx_override%>" name="currentrx_override">
		<input type="hidden" value="<%=sch_over_yn%>" name="sch_over_yn">
		<input type="hidden" value="<%=unit_dose%>" name="unit_dose">
		<input type="hidden" value="<%=daily_dose%>" name="daily_dose">
		<input type="hidden" value="" name="conv_factor" id="conv_factor">
		<input type="hidden" value="<%=strength_per_pres_uom%>" name="strength_per_pres_uom">
		<input type="hidden" value="<%=strength_per_value_pres_uom%>" name="strength_per_value_pres_uom">
		<input type="hidden" value="<%=qty_reqd_yn%>" name="qty_reqd_yn">
		<input type="hidden" value="<%=consider_stock_for_pres_yn%>" name="consider_stock_for_pres_yn">
		<input type="hidden" value="<%=calling_mode%>" name="source">
		<input type="hidden" value="<%=modeC%>" name="modeC"> <!-- Added for HSA-ICN-0011 --> 	
		<input type="hidden" value="<%=refill_cont_order_yn%>" name="refill_cont_order_yn">
		<input type="hidden" value="<%=consent_reqd_yn%>" name="consent_reqd_yn">
		<input type="hidden" value="<%=min_daily_dose%>" name="min_daily_dose">
		<input type="hidden" value="<%=min_unit_dose%>" name="min_unit_dose">	
		<input type="hidden" value="<%=freq_code%>"	name="freq_code">
		<input type="hidden" value="<%=qty_value%>" name="init_qty">
		<input type="hidden" value="<%=def_qty_value%>" name="def_qty_value"><!-- ARYU-CRF-014-->
		<input type="hidden" value="N" name="dosage_change_yn" id="dosage_change_yn"><!-- ARYU-CRF-014-->
		<input type="hidden" value="<%=prn_dose%>" name="prn_dose">
		<input type="hidden" value="<%=no_refill%>" name="no_refill">
		<input type="hidden" value="<%=refill_start_date%>" name="refill_start_date">
		<input type="hidden" value="<%=refill_end_date%>" name="refill_end_date">
		<input type="hidden" value="<%=ph_version%>" name="ph_version">
		<input type="hidden" value="<%=stock_uom%>" name="stock_uom">
		<input type="hidden" value="<%=calc_by_ind%>" name="calc_by_ind">
		<input type="hidden" value="<%=dosage_std%>" name="dosage_std">
		<input type="hidden" value="<%=dosage_unit%>" name="dosage_unit">	 
		<input type="hidden" value="<%=presBean.getUOMDesc(dosage_unit)%>" name="dosage_unit_uom">	<!-- code added for ml-mmoh-crf-0978-->
		<INPUT TYPE="hidden" name="recomm_dosage_by" id="recomm_dosage_by" VALUE="<%= recomm_dosage_by %>">
		<input type="hidden" value="<%=recomm_yn%>" name="recomm_yn">	
		<input type="hidden" value="<%=patient_class%>" name="patient_class">
		<input type="hidden" value="<%=allow_duplicate%>" name="allow_duplicate">
		<input type="hidden" value="<%=take_home%>" name="take_home">
		<input type="hidden" value="<%=allow_without_diag%>" name="allow_without_diag">		
		<input type="hidden" value="<%=prn_remarks_yn%>" name="prn_remarks_flag">	
		<input type="hidden" value="<%=prn_yn%>" name="prn_yn" id="prn_yn">	
		<input type="hidden" value="<%=man_rem_on_prn_freq_yn%>" name="man_rem_on_prn_freq_yn">	
		<input type="hidden" value="<%=order_set_code%>" name="order_set_code">
		<input type="hidden" value="<%=order_set_occur_num%>" name="order_set_occur_num">	
		<input type="hidden" value="<%=ord_set_reqd_or_opt%>" name="ord_set_reqd_or_opt">	
		<input type="hidden" value="<%=sliding_scale_yn%>" name="sliding_scale_yn">
		<input type="hidden" value="<%=def_freq_found%>" name="def_freq_found">
		<input type="hidden" value="<%=fract_dose_appl_yn%>" name="fract_dose_appl_yn">
		<input type="hidden" value="<%=fract_dose_round_up_yn%>" name="fract_dose_round_up_yn">
		<input type="hidden" value="<%=dup_found%>" name="dup_found">
		<input type="hidden" value="<%=in_formulary_yn%>" name="in_formulary_yn">
		<input type="hidden" value="<%=drug_class%>" name="drug_class">
		<input type="hidden" value="<%=calc_def_dosage_yn%>" name="calc_def_dosage_yn">
		<input type="hidden" value="<%=dsg_reason%>" name="dsg_reason">
		<input type="hidden" value="<%=dup_reason%>" name="dup_reason">
		<input type="hidden" value="<%=con_reason%>" name="con_reason">
		<input type="hidden" value="<%=int_reason%>" name="int_reason">
		<input type="hidden" value="<%=alg_reason%>" name="alg_reason">
		<input type="hidden" value="<%=DurnDescDetails%>" name="DurnDescDetails">
		<input type="hidden" value="<%=refill_yn%>" name="refill_yn">
		<input type="hidden" value="<%=refill_yn_from_param%>" name="refill_yn_from_param">
		<input type="hidden" value="<%=amend_yn%>" name="amend_yn">
		<input type="hidden" value="<%=billable_item_yn%>" name="billable_item_yn">
		<input type="hidden" value="<%=diagnosis_found_yn%>" name="diagnosis_found_yn"><!-- added for mms-dm-crf-0204 -->
		
		<input type="hidden" value="<%=tappered_over%>" name="tappered_over">
		<input type="hidden" value="<%=drug_tapered%>" name="drug_tapered">
		<input type="hidden" name="DrugIndicationRemarks" id="DrugIndicationRemarks" value="<%=DrugIndicationRemarks%>"><!--Added for  ML-BRU-CRF-072[Inc:29938] -->
		<input type="hidden" name="intr_restric_trn" id="intr_restric_trn" value="<%=intr_restric_trn%>"><!--Added for  RUT-CRF-0066 -->
		<input type="hidden" name="intr_msg_content" id="intr_msg_content" value="<%=intr_msg_content%>"><!--Added for  RUT-CRF-0066 -->
		<input type="hidden" name="interaction_override" id="interaction_override" value="<%=interaction_override%>"><!--Added for  RUT-CRF-0066 -->
		<input type="hidden" name="interaction_exists" id="interaction_exists" value="<%=interaction_exists%>"><!--Added for  RUT-CRF-0066 -->
	    <input type="hidden" name="abuse_action" id="abuse_action" value="<%=abuse_action%>"><!-- Added for AAKH-CRF-140 -->
		<input type="hidden" name="abuse_override" id="abuse_override" value="<%=abuse_override%>"><!-- Added for AAKH-CRF-140 -->
		<input type="hidden" name="abuse_exists" id="abuse_exists" value="<%=abuse_exists%>"><!-- Added for AAKH-CRF-140 -->
		<input type="hidden" name="abuse_remarks" id="abuse_remarks" value="<%=abuse_remarks%>"><!-- Added for AAKH-CRF-140 -->
		<input type="hidden" name="abuse_override_remarks" id="abuse_override_remarks" value="<%=abuse_override_remarks%>"><!-- Added for AAKH-CRF-140 -->
		<input type="hidden" name="abuse_restric_trn" id="abuse_restric_trn" value="<%=abuse_restric_trn%>"><!-- added for aakh-crf-0140 -->
		<input type="hidden" name="ATC_Duplicate_yn" id="ATC_Duplicate_yn" value="">
		<input type="hidden" name="calc_dosg_by_freq_durn_yn" id="calc_dosg_by_freq_durn_yn" value="<%=calc_dosg_by_freq_durn_yn%>"><!-- added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595] -->
			<!--  added for CRF RUT-CRF-0063[29601]--start -->
		<input type="hidden" name="pregnency_yn" id="pregnency_yn" value="<%=pregnency_yn%>">
		<input type="hidden" value="<%=preg_effect%>" name="preg_effect">
        <input type="hidden" value="<%=preg_category_code%>" name="preg_category_code">
		<input type="hidden" value="<%=pregnency_cat%>" name="pregnency_cat" >
		<input type="hidden" value="<%=pregnency_cat_desc%>" name="pregnency_cat_desc" >
		<input type="hidden" value="<%=preg_remarks%>" name="preg_remarks" >
		<input type="hidden" value="<%=drug_desc%>" name="drug_desc" >
		<input type="hidden" value="<%=preg_warn_req_yn%>" name="preg_warn_req_yn" >
		<input type="hidden" name="trimester" id="trimester" value="<%=trimester%>">
		<label id="tool_tip" style="visibility:hidden"></label><!--  added for CRF RUT-CRF-0063[29601]--end -->
		<input type="hidden" name="external_patient_id" id="external_patient_id" value="<%=bean.getExternalpatient_id()==null?"":bean.getExternalpatient_id()%>"><!--added for  [IN:040734]-->			
		<input type="hidden" name="taper_disable" id="taper_disable" value="<%=taper_disable%>"><!--Added for RUT-CRF-0066 -->
		<input type="hidden" name="take_home_start_date" id="take_home_start_date" value="<%=start_date1%>"><!--Added for Bru-HIMS-CRF-093-DD1[IN047223]-->
		<input type="hidden" name="take_home_end_date" id="take_home_end_date" value="<%=end_date1%>"><!--Added for Bru-HIMS-CRF-093-DD1[IN047223]-->
		<input type="hidden" name="order_id_copy" id="order_id_copy" value="<%=order_id_copy%>"><!--Added for ML-BRU-SCF-1333 [IN:049124]-->
		<input type="hidden" name="order_line_no_copy" id="order_line_no_copy" value="<%=order_line_no_copy%>"><!--Added for ML-BRU-SCF-1333 [IN:049124]--> 
		<input type="hidden" name="default_dosage_by_yn" id="default_dosage_by_yn" value="<%=default_dosage_by_yn%>"><!--AAKH-CRF-089--> 
		<input type="hidden" name="parent_stat_yn" id="parent_stat_yn" value="<%=parent_stat_yn%>">	<!--AAKH-CRF-0091-->
<input type="hidden" name="buildMAR_rule_org" id="buildMAR_rule_org" value="<%=buildMAR_rule_org%>">
		<input type="hidden" name="stat_yn" id="stat_yn" value="<%=stat_yn%>"><!--AAKH-CRF-0091-->
		<input type="hidden" name="chk_missing_sch_yn" id="chk_missing_sch_yn" value="N"><!--AAKH-CRF-0091-->
		<input type="hidden" name="chk_missing_sch_yn_1" id="chk_missing_sch_yn_1" value=""><!--AAKH-CRF-0091-->
       <input type="hidden" name="default_recm_dose_yn" id="default_recm_dose_yn" value="<%=default_recm_dose_yn_value%>"><!--ml-mmoh-CRF-0978-->
       <input type="hidden" name="default_freq_not_found" id="default_freq_not_found" value="<%=default_freq_not_found%>"><!-- added for GHL-CRF-0508 -->
       <input type="hidden" name="def_freq_not_found" id="def_freq_not_found" value="<%=def_freq_not_found%>"><!-- added for GHL-CRF-0508 -->
	   <input type="hidden" name="patient_stock_required_yn" id="patient_stock_required_yn" value="<%=patient_stock_required_yn%>"> <!--added for GHL-CRF-0482-->
   	   <input type="hidden" name="patient_stock_yn" id="patient_stock_yn" value=""><!--added for GHL-CRF-0482-->
       <input type="hidden" name="patient_stock_allow_yn" id="patient_stock_allow_yn" value=""><!--added for GHL-CRF-0482-->
       <input type="hidden" name="ord_authorized_yn_durn" id="ord_authorized_yn_durn" value="<%=ord_authorized_yn_durn%>"><!-- Added for mo-scf-5533 -->
      <!-- Added for IN:070451 start -->
       <input type="hidden" value="<%=max_daily_ceeling_dose%>" name="max_daily_ceeling_dose">
       <input type="hidden" value="<%=min_daily_ceeling_dose%>" name="min_daily_ceeling_dose">
       <input type="hidden" value="<%=max_unit_ceeling_dose%>" name="max_unit_ceeling_dose">
       <input type="hidden" value="<%=min_unit_ceeling_dose%>" name="min_unit_ceeling_dose">
       <!-- Added for IN:070451 end -->
       
       <!-- Added for IN:072715 start -->
       <input type="hidden" value="<%=allergy_remarks_code%>" name="allergy_remarks_code">
       <input type="hidden" value="<%=dose_remarks_code%>" name="dose_remarks_code">
       <input type="hidden" value="<%=currentrx_remarks_code%>" name="currentrx_remarks_code">
       <input type="hidden" value="<%=interaction_remarks_code%>" name="interaction_remarks_code">
       <input type="hidden" value="<%=food_interaction_remarks_code%>" name="food_interaction_remarks_code">
       <input type="hidden" value="<%=lab_interaction_remarks_code%>" name="lab_interaction_remarks_code">
       <!-- Added for IN:072715 end -->
       <!-- Added for IN:073485 START -->
       <input type="hidden" value="<%=override_select_appl%>" name="override_select_appl">
       <input type="hidden" value='N' name="override_rem_mand" id="override_rem_mand">
       <input type="hidden" value="N" name="quota_limit_exceded_yn" id="quota_limit_exceded_yn"> <!-- 1823 US008-->
      <!-- Added for IN:073485 end -->
       <input type="hidden" value="<%=validate_overide_on_confirm_yn%>" name="validate_overide_on_confirm_yn"><!-- Added for IN:069887  -->
	   <input type="hidden" value="<%=disease_interaction_remarks%>" name="disease_interaction_remarks"><!-- MMS-DM-CRF-0229 -->
       <input type="hidden" value="<%=disease_interaction_remarks_code%>" name="disease_interaction_remarks_code"><!-- MMS-DM-CRF-0229 -->
      
       
       <input type="hidden" value="<%=disc_cancel_flag%>" name="disc_cancel_flag"><!-- added for MO-CRF-20159-->
	  <input type='hidden' name='ext_disp_appl_yn' id='ext_disp_appl_yn' value='<%=ext_disp_appl_yn%>'><!--added for NMC-JD-SCF-0121 -->
	   <input type='hidden' name='quota_limit_site_yn' id='quota_limit_site_yn' value='<%=quota_limit_site_yn%>'><!--1823 US008-->
	   <input type='hidden' name='preview_rx_yn' id='preview_rx_yn' value='<%=bean.getPreviewRxYN()%>'><!--1823 US008-->
       <input type="hidden" name="drug_indication_mdry" id="drug_indication_mdry" value="<%=drug_indication_mdry%>"><!-- added for jd-crf-0220 -->
	   <input type="hidden" name="def_disp_locn_appl_yn" id="def_disp_locn_appl_yn" value="<%=def_disp_locn_appl_yn%>"><!-- added for NMC-JD-SCF-0324 -->

<!-- Hidden values ends-->

		<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
			<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="90%" >
				<tr><td width="100%" id="t"></td></tr>
			</table>
		</div>

	</form>
</body>
<script>
async function toHoldExecution(){
<%		
// added for CRF-20085.1 - start
			if(patient_class.equals("OP"))
				ph_drug_overlap_period = overlap_period_for_op;
		
			if (patient_class.equals("IP"))
				ph_drug_overlap_period = overlap_period_for_ip;
			if(amend_yn!=null && amend_yn.equals("N") && (!calling_mode.equals("blank"))){
			if(skip_duplicte_alert.equals("Y") && !ph_drug_overlap_period.equals("")){					
					previous_order_date = presBean.getPreviousOrderStartDate(patient_id, generic_id, DateUtils.convertDate(start_date, "DMYHM",locale,"en"),DateUtils.convertDate(end_date, "DMYHM",locale,"en"), freq_code);
				if(previous_order_date==null || previous_order_date.equals(""))
					previous_order_date = start_date;
					no_of_days= DateUtils.daysBetween(previous_order_date, start_date, "DMYHM", locale);
				   if(!locale.equals("en"))
					previous_order_date = DateUtils.convertDate(start_date, "DMYHM","en",locale);
					if(no_of_days<=Integer.parseInt(ph_drug_overlap_period))
						skip_dup_flag = false;
			}
		}
// added for CRF-20085.1 - end
//		if((modeC!=null && modeC.equals("copied_drugs")) || copied_drug_yn.equals("Y")){
		if(copied_drug_yn.equals("Y") && amend_yn!=null && amend_yn.equals("N")){
			// && split_dose_yn_copy.equals("Y")){
			//ArrayList schedule		= (ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
			String sch_bean_id		= "OrScheduleFreq" ;
			String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
			Hashtable sch_output	=	null;
			Hashtable schedule_val	=	null;
			StringTokenizer  stDrugOrder = new StringTokenizer(order_idC,"!");
			String drugOrd = "";
			String  ord_id = "";
			String line_no = "";
			ArrayList admin_qtyc = new ArrayList();
			boolean split_chk = false;
			while(stDrugOrder.hasMoreTokens()) {
				drugOrd = stDrugOrder.nextToken();
				if(drugOrd.indexOf(drug_code) != -1){
					ord_id = drugOrd.substring(0,drugOrd.indexOf(","));
					line_no = drugOrd.substring((drugOrd.indexOf(",")+1),drugOrd.indexOf("$"));
				}
			}

			if(split_dose!=null && !(split_dose.equals(""))&& scheduled_yn.equals("Y")){
				StringTokenizer	 vals	=	new StringTokenizer(split_dose,"|");

				while(vals.hasMoreTokens()) {
					String code1		= (String)vals.nextToken();
					code1=code1+"=";
					StringTokenizer	 inner_vals	=	new StringTokenizer(code1,"=");
					int n=0;
					while(inner_vals.hasMoreTokens()) {
						if(!(n%2==0)){

							String qty		= (String)inner_vals.nextToken();
							if(admin_qtyc.size()!=0 && !admin_qtyc.contains(qty)) {
								split_chk	=	true;
							}
							admin_qtyc.add(qty);
						}
						n++;				
					}
				}
			}
			split_dose_yn = split_dose_yn_copy;
		
			if(scheduled_yn.equals("Y")  && !(dup_found) && !values_changed.equals("Y")) { // && !(dup_found) added for IN25797 --14/01/2011-- priya //values_changed added for ML-BRU-SCF-1231 [IN:046657]
			 //if(scheduled_yn.equals("Y") ) {
				schedule_val	=	new Hashtable();
				ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name,request);
				schedule_bean.setLanguageId(locale);
				schedule_val.put("facility_id", (String)session.getValue("facility_id"));
				//schedule_val.put("start_time_day_param", drug_start_date);
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
				bean.setScheduleFrequencyStr(sch_output);
				putObjectInBean(sch_bean_id,schedule_bean,request);
			} 
			if(sch_output!=null ) { 
				sch_output.put("code",drug_code+srl_no);
				sch_output.put("row_value",srl_no);
				sch_output.put("start_time_assign","");

				line_no = order_line_no_copy;
				ord_id = order_id_copy;
				ArrayList values	=	presBean.getFreqDet(ord_id,line_no);
				ArrayList tmp_freq_values = new ArrayList();
				ArrayList freqCharctValues = new ArrayList();
				ArrayList day_list = new ArrayList();
				ArrayList day_names = new ArrayList();
				ArrayList time_list = new ArrayList();
				ArrayList dose_list = new ArrayList();
				ArrayList<String> week_days	= new ArrayList<String>();
				// date conversion done for IN22002 --11/06/2010-- priya
				week_days = bean.getDayOfWeek(com.ehis.util.DateUtils.convertDate(start_date, "DMYHM",locale, "en")); 
				freqCharctValues = (ArrayList)sch_output.get(drug_code+srl_no);	
				for(int p=0; p<values.size(); p+=4) {
					time_list.add(values.get(p));
					dose_list.add(values.get(p+1));
					//time_list.add(values.get(p+2));
					day_list.add((values.get(p+3)==null)?"0":values.get(p+3));
				}

				if(values.size()==0){ // added for ML-BRU-SCF-1887 - start
					time_list = (ArrayList)freqCharctValues.get(3);
					dose_list = (ArrayList)freqCharctValues.get(4);
					day_list  = (ArrayList)freqCharctValues.get(1);
				} //added for ML-BRU-SCF-1887 - end
				if(day_list.size()>0 && ((String)((HashMap)((ArrayList)sch_output.get(drug_code+srl_no)).get(0)).get("durationType")).equals("W")){
					for(int j=0;j<day_list.size();j++){
						if(!day_list.get(j).equals("")){
							String temp = (String)day_list.get(j);
							if (temp == null || temp.equals("")){
								temp = "0";
							}
							if (!temp.equals("0")){
								if(((Integer.parseInt(temp))-1)< week_days.size())
									day_names.add(week_days.get((Integer.parseInt(temp))-1));
							}
						}
					}
				}
				tmp_freq_values.add(freqCharctValues.get(0));
				tmp_freq_values.add(day_list);
				tmp_freq_values.add(day_names);
				tmp_freq_values.add(time_list);
				tmp_freq_values.add(dose_list);
                sch_output.put(drug_code+srl_no,tmp_freq_values);
				/*int incr=0;
				for(int p=0; p<values.size(); p+=4) {
					incr++;
					sch_output.put("time"+(incr),values.get(p));
					sch_output.put("qty"+(incr),values.get(p+1));
					sch_output.put("admin_day"+(incr+1),values.get(p+3));
				}
				if(incr<=6) {
					for(int q=(incr+1); q<=6; q++) {
						sch_output.put("time"+(q),"");
						//sch_output.put("admin_day"+(q),"");
					}
				}*/
				bean.setScheduleFrequencyStr(sch_output);
			}
			chkValuescheduleFrequency	= bean.getscheduleFrequency();
		}
	//  duplicate check based on atc -- starts	   [SRR20056-SCF-7916, Rawther, Below 2 lines uncommented ]
	if((!drug_db_interface_yn.equals("Y")) || drug_db_duptherapy_yn.equals("N") || (ext_prod_id.equals(""))){//Added drug_db_duptherapy_yn.equals("N") for  BRU-HIMS-CRF-403
		if(current_rx.equals("Y")) {

			//if((drug_db_duptherapy_flag == null || !drug_db_duptherapy_flag.equals("Y"))&&(!drug_db_duptherapy_yn.equals("Y"))	){
			//commented above if codition for the incident no : 27465
			//replaced drug_db_duptherapy_yn with drug_db_duptherapy_flag for IN21942 --11/06/2010-- priya
		// This condition is commented for IN 17323 for making the override reason button appear on load when drug is tappered down  12/01/2010  - Shyampriya -- comment removed
			String atc_level_1		=	"";
			String atc_level_2		=	"";
			String atc_level_3		=	"";
			String atc_level_4		=	"";
			String atc_level_5		=	"";
			String generic_atc_name =   "";
			String provide_taper	=	"";
			String temp_generic_id	=	"";
			String temp_drug_code	=	"";
			String temp_drug_desc	=	"";
			String duplicate_check_at_atc_yn=""; //added for skr-scf-0143 IN 29184
			ArrayList atc_values	=  new ArrayList();
			ArrayList atc_dup_drug_code= null; // added for the incident no 27465
			HashMap drug_detail		=	null;
//System.err.println("PrescriptionDetail_1.jsp-=----2381---loading-end Drug--System.currentTimeMillis()---> " +System.currentTimeMillis()+"==drug_code===>"+drug_code);			
				if(presDetails!=null && presDetails.size()>0){
					for(int i=0;i<presDetails.size();i++){			
						drug_detail=(HashMap) presDetails.get(i);
						duplicate_check_at_atc_yn       = (String) drug_detail.get("DUPLICATE_CHECK_AT_ATC_YN");   //added for skr-scf-0143 IN 29184
						if(duplicate_check_at_atc_yn!=null && duplicate_check_at_atc_yn.equals("Y") ){
							atc_level_1	    =	(String)drug_detail.get("ATC_CLASS_LEV1_CODE");
							atc_level_2	    =	(String)drug_detail.get("ATC_CLASS_LEV2_CODE");
							atc_level_3	    =	(String)drug_detail.get("ATC_CLASS_LEV3_CODE");
							atc_level_4	    =	(String)drug_detail.get("ATC_CLASS_LEV4_CODE");
							atc_level_5	    =	(String)drug_detail.get("ATC_CLASS_LEV5_CODE");
							generic_atc_name=  	(String)drug_detail.get("GENERIC_ATC_NAME");
							temp_generic_id	=	(String)drug_detail.get("GENERIC_ID");
							temp_drug_desc	=	(String)drug_detail.get("DRUG_DESC");
							temp_drug_code  =   (String)drug_detail.get("DRUG_CODE");
							temp_drug_desc=temp_drug_desc.replaceAll(" ","%20");
							temp_drug_desc = java.net.URLEncoder.encode(temp_drug_desc,"UTF-8");
							temp_drug_desc=temp_drug_desc.replaceAll("%2520","%20");

							if(drug_detail.get("TAPPERED_OVER")!=null)
								 provide_taper	= (String)drug_detail.get("TAPPERED_OVER");
							if( (!provide_taper.equals("Y")) && (drug_detail.get("CURRENTRX_REMARKS")==null || ((String)drug_detail.get("CURRENTRX_REMARKS")).equals("") )  ) {	
								atc_dup_drug_code = (ArrayList)drug_detail.get("ATC_DUP_DRUG_CODE"); // added for the incident no 27465 - start
								if(atc_dup_drug_code == null)
									atc_dup_drug_code = new ArrayList();// added for the incident no 27465 - end	
								if(atc_values.contains(temp_generic_id)) {
									current_rx = "Y";
	%>
									document.prescription_detail_form.current_rx.value = "Y"; 
	<%
									drug_detail.put("CURRENT_RX","Y");
									if(drug_code.equals(temp_drug_code)  && skip_dup_flag ){ //skip_dup_flag added for CRF-20085.1
										out.println("alertATCDup('"+temp_drug_desc+"','"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.duplicateswithGeneric.label", "ph_labels")+"','"+generic_name+"',''); ");
										if(!atc_dup_drug_code.contains(temp_drug_code))//Added to avoid duplicate drugcode on atc list for TTM-SCF-0073[IN046928]
										atc_dup_drug_code.add(temp_drug_code);// added for the incident no 27465
										drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);// added for the incident no 27465
									}
								}	// SRR20056-SCF-7689 - Generic name is queried and defaulted (earlier it was code)
									// SRR20056-SCF-6437 - Logic change (removed ATC Level1, ATC Level 2, ATC Level 3)
									// Newly added ATC Level 5 and ATC Level 4, Attached mail in spira for logic details
								else if(atc_values.contains(atc_level_5)&&(drug_code.equals(temp_drug_code))) {
									drug_detail.put("CURRENT_RX","Y");
									current_rx="Y";
	%>
										document.prescription_detail_form.current_rx.value = "Y"; 
	<%
									if(drug_code.equals(temp_drug_code) && skip_dup_flag){ //skip_dup_flag added for CRF-20085.1
										out.println("alertATCDup('"+temp_drug_desc+"','"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.duplicateswith.label", "ph_labels")+"','"+atc_values.get(atc_values.indexOf(atc_level_5)-5)+"','"+" at ATC Classification Level 5') ");
										atc_dup_drug_code.add(temp_drug_code);// added for the incident no 27465
	%>
											document.prescription_detail_form.ATC_Duplicate_yn.value = "Y"; 
	<%
										drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);// added for the incident no 27465
									}
								}
								else if(atc_values.contains(atc_level_4)&&(drug_code.equals(temp_drug_code))) {
									drug_detail.put("CURRENT_RX","Y");
									current_rx="Y";
	%>
										document.prescription_detail_form.current_rx.value = "Y"; 
	<%
									if(drug_code.equals(temp_drug_code) && skip_dup_flag ){ //skip_dup_flag added for CRF-20085.1
										out.println("alertATCDup('"+temp_drug_desc+"','"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.duplicateswith.label", "ph_labels")+"','"+atc_values.get(atc_values.indexOf(atc_level_4)-4)+"','"+"at ATC Classification Level 4') ");
										atc_dup_drug_code.add(temp_drug_code);// added for the incident no 27465
										drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);// added for the incident no 27465
	%>
											document.prescription_detail_form.ATC_Duplicate_yn.value = "Y"; 
	<%
									}
								}
								else {

									//drug_detail.put("CURRENT_RX","Y");
									atc_values.add(temp_drug_desc);
									atc_values.add(temp_drug_code);
									atc_values.add(temp_generic_id);
									if(!(generic_atc_name==null || generic_atc_name.equals(""))){
										atc_values.add(generic_atc_name);
									}
									if(!(atc_level_1==null || atc_level_1.equals(""))){
										atc_values.add(atc_level_1);
									}
									if(!(atc_level_2==null || atc_level_2.equals(""))){
										atc_values.add(atc_level_2);
									}
									if(!(atc_level_3==null || atc_level_3.equals(""))){
										atc_values.add(atc_level_3);
									}
									if(!(atc_level_4==null || atc_level_4.equals(""))){
										atc_values.add(atc_level_4);
									}
									if(!(atc_level_5==null || atc_level_5.equals(""))){
										atc_values.add(atc_level_5);
									}
								}
							}else{ //added for SKR-SCF-1482 - start
							 if(current_rx.equals("Y")){
									atc_values.add(temp_drug_desc);
									atc_values.add(temp_drug_code);
									atc_values.add(temp_generic_id);
									if(!(generic_atc_name==null || generic_atc_name.equals(""))){
										atc_values.add(generic_atc_name);
									}
									if(!(atc_level_1==null || atc_level_1.equals(""))){
										atc_values.add(atc_level_1);
									}
									if(!(atc_level_2==null || atc_level_2.equals(""))){
										atc_values.add(atc_level_2);
									}
									if(!(atc_level_3==null || atc_level_3.equals(""))){
										atc_values.add(atc_level_3);
									}
									if(!(atc_level_4==null || atc_level_4.equals(""))){
										atc_values.add(atc_level_4);
									}
									if(!(atc_level_5==null || atc_level_5.equals(""))){
										atc_values.add(atc_level_5);
									}
							 }
							//added for SKR-SCF-1482 - end
							}
						} //if duplicate_check_at_atc_yn end
					} //for presDetails End 
				} //if presDetails end
			}
			if((amend_yn==null || !amend_yn.equals("Y") || copied_drug_yn.equals("Y")) && interaction_exists.equals("Y")){// && (intr_restric_trn.equals("Y") || severity_level.equals("H"))){ //Added for  RUT-CRF-0066 
%>
					await alertIntr('<%=drug_code%>','<%=srl_no%>', '<%=patient_id%>','<%=encounter_id%>','N')
<%
			}
		} //added for AAKH-CRF-0140 
		if((amend_yn==null || !amend_yn.equals("Y") || copied_drug_yn.equals("Y")) && (abuse_exists.equals("Y") && abuse_action.equals("B"))){
		System.out.println("2810abuse_exists"+abuse_exists+"abuse_action"+abuse_action);
			%>
				await alertAbuse('<%=drug_code%>','<%=srl_no%>', '<%=patient_id%>','<%=encounter_id%>','N')
<%	
		}
		if(  req_diag_pres_found && diagnosis_found_yn.equals("N") ){/* added for mms-dm-crf-0204 */
			
			%>
			await addDrug('delete');  /* added for mms-dm-crf-0204 */
		
			<%	
			
		}
%>
<%	
                if(supp_drug_count>0){//Adding start for TH-KW-CRF-0007
%>
			     await  AlertSupportDrug('<%=drug_code%>');
<%
		        }
%>
			await assignDurnTypeList('<%=DurnDescDetails%>');
<% 
			if(calling_mode.equals("blank")){
%>
				disableItems();
<% 
			}
			else { 	//if no default frequency(order catalog) matches with the applicable frequency list with respect to patient class
				//6th occurrence of getDrug_schd_flag_yn()
	//AAKH-CRF-0091
					
				if(stat_yn.equals("Y")){
					statFeqFound=true;
					def_freq_found=true;
					
					
				}
				
				if(!amend_yn.equals("Y") && orig_current_rx.equals("Y") && allow_duplicate.equals("N") ) {	//&& (patient_class.equals("IP") || take_home>0)
%>
				await	duplicateWarning();
<%
				}
				else if(!amend_yn.equals("Y") && !statFeqFound && priority.equals("U")){
					out.println("alert(getMessage('APPICABLE_STAT_FREQUENCIES_NOT_DEFINED','PH'));");
					out.println("document.prescription_detail_form.priority.value='R'");
				}
				else if(!def_freq_found &&  !amend_yn.equals("Y")){
%>
//added for GHL-CRF-0508 start 
<% if(!default_freq_not_found){%>
					alert(getMessage("PH_NORMAL_RX_DEFAULT_FREQ_NOT_FOUND",'PH'));  
<%}%>
//added for GHL-CRF-0508 end 
					await freqChange(document.prescription_detail_form.frequency,'<%=sliding_scale_yn%>'); //Commented for IN25242 --10/12/2010-- priya //Uncommented for ML-BRU-SCF-1664[58792]
<%
				}
%>
				//freqChange(document.prescription_detail_form.frequency,"Y");
				//reloadDurnTypeList(); //commented to stop max duration alert from displaying twice on load --priya-- 02/03/2010
				//dfltDurnDesc('<%=repeat_durn_type%>');
<%				if(!copied_drug_yn.equals("Y") || (copied_drug_yn.equals("Y") && amend_yn.equals("Y")) ){ // if condition Added for HSA-ICN-0010 %>
				await dfltDurnDesc('<%=freq_chng_durn_desc%>');
<%				} 
				if(copied_drug_yn.equals("Y") && !amend_yn.equals("Y")){//code added for 26089 ---by naveen -24Jan2011
%>
					await dfltDurnDesc('<%=durn_type%>');
<%		
				}
				if(from_sliding_scale_yn.equals("Y")) {
%>
					await storeSchedule(); // added while fixing IN25532 -- priya-- 27/12/2010
<%	
				}
				if(!dosage_type.equals("S")) {	
					if(copied_drug_yn.equals("Y") || amend_yn.equals("Y")){
%>
						await populateQtyDesc('<%=form_code%>','<%=qty_desc_code%>');
<%	
					}
					else if(!amend_yn.equals("Y")){
%>
						await populateQtyDesc('<%=form_code%>','<%=pres_base_uom%>');
<%	
					}
				}
				if(!copied_drug_yn.equals("Y")){ //if added for HSA-ICN-0010
%>
				await populateEndDate();
<%				}
%>
				await getFormatId();  
<%		//modified for AAKH-CRF-0140 
				if(((allergy_yn != null && allergy_yn.equals("Y")) || current_rx.equals("Y") || interaction_exists.equals("Y") || (abuse_exists.equals("Y") && abuse_action.equals("B"))) && (ext_prod_id== null  ||  ext_prod_id.equals("") || !drug_db_interface_yn.equals("Y")|| drug_db_duptherapy_yn.equals("N")) ) {//Added for Duplicate button issue
					   System.out.println("2898abuse_exists"+abuse_exists);
						System.out.println("2898abuse_action"+abuse_action);
%>
					document.prescription_detail_form.dosage_limit.style.visibility="visible";		
					document.prescription_detail_form.override_remarks.style.visibility="visible";
<%
				}
				if(tappered_over!=null && tappered_over.equals("Y")){// If tappered Disable Refill Button 
%>
					document.prescription_detail_form.allow_refill.disabled=true;
<%
				}
			}	
			if( calling_mode.equals("taper")){ 
%>
				document.prescription_detail_form.start_date.disabled=true;
				document.prescription_detail_form.allow_refill.disabled=true;
				document.prescription_detail_form.priority.disabled=true;
				document.prescription_detail_form.dosage.disabled=true;
<%
				ArrayList schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
				bean.addScheduleFrequencyStr(schedule,drug_code+tapper_srl_no);
			}	
			if( calling_mode.equals("tapered")){ 
%>
				document.prescription_detail_form.start_date.disabled=true;
				document.prescription_detail_form.priority.disabled=true;
				document.prescription_detail_form.dosage.disabled=true;
<%
			}
			//if(calling_mode.equals("modify") || calling_mode.equals("taper") || calling_mode.equals("tapered") ) { //priya
			if(!calling_mode.equals("blank") ) { //priya
%>
				//setfocus(document.prescription_detail_form.qty_value);
				// for Stat freq
				if('<%=freq_nature%>'=='O'){
					document.prescription_detail_form.in_durn_desc.value="";
					document.prescription_detail_form.in_durn_value.value="";
					document.prescription_detail_form.durn_desc.value="D";
					document.prescription_detail_form.durn_value.value="1";
					document.prescription_detail_form.durn_value.disabled=true;
					document.prescription_detail_form.end_date.disabled=true;
					document.prescription_detail_form.endDateImg.disabled=true;
					document.prescription_detail_form.durn_desc.disabled=true;
					document.prescription_detail_form.calcualted_durn_value.value="1";
					document.prescription_detail_form.allow_refill.disabled=true;
					document.prescription_detail_form.no_refill.value="";
					document.prescription_detail_form.refill_start_date.value="";
					document.prescription_detail_form.refill_end_date.value="";
				}
				else if('<%=freq_nature%>'=='P'){
					document.prescription_detail_form.durn_desc.value="D";
					document.prescription_detail_form.durn_desc.disabled=true;
					document.prescription_detail_form.durn_value.disabled=false;
					document.prescription_detail_form.allow_refill.disabled=true;
					document.prescription_detail_form.end_date.disabled=false;
					document.prescription_detail_form.endDateImg.disabled=false;
					if(document.prescription_detail_form.no_refill!=null) {
						document.prescription_detail_form.no_refill.value="";
						document.prescription_detail_form.no_refill.disabled=true;
						document.prescription_detail_form.refill_start_date.value="";
						document.prescription_detail_form.refill_end_date.value="";
					}
					interval_value="1";
					//alert("prathyusha1"+repeat_value);
					repeat_value="1";
				}
<%	
				//if(amend_yn!=null && amend_yn.equals("N")) {	
				//	HashMap data		=	null;
				//String att			=	null;
				String adm_time		=	"";
				String adm_qty		=	"";
				float total_qty		= 0.0f;
				String final_qty	= "";
//System.err.println("PrescriptionDetail_1.jsp-=--2639---loading-Drug--System.currentTimeMillis()---> " +System.currentTimeMillis()+"==drug_code===>"+drug_code);
								
				if(chkValuescheduleFrequency!=null)
					frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(drug_code+srl_no);

				ArrayList dose_list = null;
				if(frequencyValues!=null && frequencyValues.size()>0 && def_freq_found){
					dose_list	= (ArrayList)frequencyValues.get(4);
					if(dose_list!=null && dose_list.size()>0){
						for(int tqI=0;tqI<dose_list.size();tqI++){
							total_qty=total_qty+Float.parseFloat((String)dose_list.get(tqI));
							final_qty	=	(String)dose_list.get(tqI);
						} 
						String tooltiptable = (String)bean.getTooltipStringFrFreq(frequencyValues,"toolTip");
						adm_time = tooltiptable;
						boolean split_chk	=	bean.checkSplit(frequencyValues);	
						if(split_chk){
							final_qty		=	String.valueOf(total_qty);
						}
						out.println("makeScheduleLink('"+adm_time+"','"+adm_qty+"','"+final_qty+"','"+frequencyValues.size()+"','"+split_chk+"','onLoad')");
					}
				}
				//	else{  // Commented for IN26326 --04/02/2011-- priya (extDosageCheck was not getting called after dose_uom was loaded)
					//out.println("getChargeDetails('"+in_formulary_yn+"','','"+amend_yn+"')"); -- MMS perf
					//if(dsg_reason.equals("") && dup_reason.equals("") && con_reason.equals("") && int_reason.equals("") && alg_reason.equals("")) // Commented for IN26326 --04/02/2011-- priya (extDosageCheck was not getting called after dose_uom was loaded)
					out.println("extDosageCheck('onLoad')");
				//}
				/* below code added  for SKR-CRF-PHIS-003[IN028182] -- Start */
				if( !copied_drug_yn.equals("Y") &&!ori_dosage_type.equals(default_dosage_by) && !amend_yn.equals("Y") &&  !calling_mode.equals("taper") && !calling_mode.equals("tapered")) //conditions amend_yn,calling_mode added for  ML-BRU-SCF-0168 [IN:032501]
					out.println("dosageChange(document.prescription_detail_form.dosage);");
				/*    SKR-CRF-PHIS-003[IN028182] -- End */		
%>
				if(document.prescription_detail_form.freq_nature.value=="P"){
					document.getElementById("prn_remarks").style.visibility	= "visible";
					if(document.prescription_detail_form.man_rem_on_prn_freq_yn.value == 'Y'){
						document.getElementById("prn_remarks_image").style.visibility	= "visible";
					}
					else{
						document.getElementById("prn_remarks_image").style.visibility	= "hidden";
					}
					document.getElementById("dis_split_dose").style.visibility	= "hidden";
				}
				await checkWtAndHt(prescription_detail_form);
				
<%
				if((orig_current_rx.equals("Y")||(drug_db_duptherapy_flag.equals("Y"))) && allow_duplicate.equals("N")) {	 // && (patient_class.equals("IP") || take_home>0)
%>
					await freqChange(document.prescription_detail_form.frequency,'N', 'N', 'ChangeFreq');
					document.getElementById("priority").disabled	= true;
<%
				}
				else if(copied_drug_yn.equals("N") && !amend_yn.equals("Y")){		
%>
					await freqChange(document.prescription_detail_form.frequency,'N','N','ChangeFreq');
<%
				}
				else if(copied_drug_yn.equals("Y") && !amend_yn.equals("Y")){
%>
					//dfltDurnDesc('<%=durn_type%>');
					await validateAllDates(); //added for IN24020 to update the end date correctly for copied order --28/09/2010-- priya
					// durationConversn(document.prescription_detail_form.durn_desc); // commented for HSA-ICN-0010
<%
				}
				if(!modeC.equals("copied_drugs") && !(split_dose_yn.equals("Y"))){ //  && !(split_dose_yn.equals("Y")) added for IN25596 --21/12/2010-- priya
%>
					await lookForChange(document.prescription_detail_form.qty_value);
<%	
				} 
				//if(calling_mode.equals("modify") || calling_mode.equals("taper") || calling_mode.equals("tapered")) {
%>
<%		
// if condition Added for MO-CRF-20085.1 [IN057392] - End
				if(!calling_mode.equals("blank")) {
					if((!drug_db_interface_yn.equals("Y")) || (ext_prod_id.equals(""))){
						if(atc_level4_duplication.equals("Y")&& currentrx_override.equals("N")){
							   System.out.println("3046abuse_exists");
								System.out.println("3046abuse_action");
%>
							document.prescription_detail_form.dosage_limit.style.visibility="visible";
							document.prescription_detail_form.override_remarks.style.visibility="visible";
<%							if(skip_dup_flag){ //skip_dup_flag added for CRF-20085.1
%>				
							alert(getMessage("ATC_DUPLICATION",'PH'));
<%							}
						}
					}
%>
					if(document.getElementById('prn_yn').value=="N"){
						document.getElementById("prn_remarks_image").style.visibility	= "hidden";
					}
<% 
				}		
				discCancFlag=bean.getCancelDiscConDupOrders();//added for Bru-HIMS-CRF-0265 [IN032315] - begin
				if(discCancFlag.equals("Y") ){
					if(profile_count>=1 && ((bean.getExternalpatient_id()==null) || (bean.getExternalpatient_id().equals("") )) ){
						boolean dupExists = presBean.checkDuplicateDrug(patient_id, generic_id, DateUtils.convertDate(start_date, "DMYHM",locale,"en"),DateUtils.convertDate(end_date, "DMYHM",locale,"en"), freq_code,""); //Added for ML-BRU-SCF-1340 [IN:049282]
						//if((orig_current_rx.equals("Y") || drug_db_duptherapy_flag.equals("Y"))&& !amend_yn.equals("Y") ){//current_rx //Commented for ML-BRU-SCF-1340 [IN:049282]
						if(dupExists && !amend_yn.equals("Y") ){//Added for ML-BRU-SCF-1340 [IN:049282] - replaced the above if condition with this
						/*	if(skip_duplicte_alert.equals("Y") && !ph_drug_overlap_period.equals("")){// if condition Added for MO-CRF-20085.1 [IN057392] - Start							
									previous_order_date = presBean.getPreviousOrderStartDate(patient_id, generic_id, DateUtils.convertDate(start_date, "DMYHM",locale,"en"),DateUtils.convertDate(end_date, "DMYHM",locale,"en"), freq_code);		
							        if(!locale.equals("en"))
							        previous_order_date = DateUtils.convertDate(start_date, "DMYHM","en",locale);
							} // if condition Added for MO-CRF-20085.1 [IN057392] - End
							*/
%>							if(parent.f_button.document.forms[0].btnDiscOrders!=undefined)//added for icn after click on confirm system not responding 
							parent.f_button.document.forms[0].btnDiscOrders.style="display";	
							await callDiscCancelOrders('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>','<%=start_date%>','<%=end_date%>','<%=freq_code%>','<%=drug_code%>','<%=srlNo%>','<%=drug_db_interface_yn%>','<%=ext_prod_id%>','','N','<%=skip_duplicte_alert%>','<%=ph_drug_overlap_period%>','<%=locale%>','<%=previous_order_date%>');
						/* skip_duplicte_alert,ph_drug_overlap_period,locale,previous_order_date Added for MO-CRF-20085.1 [IN057392]  */
							
<%
						}
						else if(dupExists) {//orig_current_rx.equals("Y") replaced with dupExists for ML-BRU-SCF-1340 [IN:049282]
%>							if(parent.f_button.document.forms[0].btnDiscOrders!=undefined)
							parent.f_button.document.forms[0].btnDiscOrders.style="display";
<%
						}
						else{
%>							if(parent.f_button.document.forms[0].btnDiscOrders!=undefined)
							parent.f_button.document.forms[0].btnDiscOrders.style.display = "none";
<%
						}
					}
				}//added for Bru-HIMS-CRF-0265 [IN032315] - end
				if( calling_mode.equals("taper")){  //if block Code added for IN24540 to default duration same as of parent order --21/10/2010-- priya
%>
					document.prescription_detail_form.durn_desc.value='<%=freq_chng_durn_desc%>';
					await populateEndDate(); //aded for IN25777 --07/01/2011-- priya
<%
				}
%>
				try{
					if(document.prescription_detail_form.absol_qty.style.display != 'none'){
						if((document.prescription_detail_form.absol_qty.value!='') && parseInt(document.prescription_detail_form.absol_qty.value)== 0){
							ValidateAbs(document.prescription_detail_form.absol_qty);
						}
					}		
					//Below code added for IN25596 reopen --24/12/2010-- priya
					if(document.prescription_detail_form.qty_value.value!="") {
						document.prescription_detail_form.qty_value.value =Math.abs(document.prescription_detail_form.qty_value.value);
					}
				}
				catch(e){
				}	
<%
				if(pregnency_yn.equals("Y") && !preg_effect.equals("") && preg_warn_req_yn.equals("Y") && !amend_yn.equals("Y") ){ //if block added for  RUT-CRF-0063 [IN:029601]
%>
					await chkPregnencyAlert();
<%
				}
				if(copied_drug_yn.equals("N") && !amend_yn.equals("Y")){		
%>
					await defHdrDuration();
<%
				}
				if(!amend_yn.equals("Y") && tappered_over.equalsIgnoreCase("N")){//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start
%>
					await calulateDurnValue('<%=start_date1%>','<%=end_date1%>','<%=locale%>','<%=tempstartdate1%>','<%=tempenddate1%>','<%=patient_class%>','normaldetail');
<%
				}//Added for IN047223--end
			}
			if(default_dosage_by_yn.equals("N")&&amend_yn.equals("N"))	{ //AAKH-CRF-089  Start   //added Newly amend_yn condition	
				%>
	await makeDefaultQtyvalueEmpty('<%=stat_yn%>');  
			<%}// AAKH-CRF-089  END  Chithra stat_yn added for AAKH-CRF-0091
//AAKH-CRF-0091
	boolean aakh_site=false;
	aakh_site	=presBean.isSiteSpecific("PH","STAT_PARENT_CHILD");
	if(aakh_site==true){
		boolean chk_date = false;
		if(amend_yn.equals("N") && !freq_nature.equals("O") && !freq_nature.equals("I") ){
			
			
			
			ArrayList time_list = new ArrayList();
			
			
			chkValuescheduleFrequency=bean.getscheduleFrequency();
			if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0){
				frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code+srl_no);
			}
			
			if(frequencyValues !=null && frequencyValues.size()>0){
				
				time_list		= (ArrayList)frequencyValues.get(3);
				
			}
			
			String sch_first_time = "";
			if(time_list!=null && time_list.size()>0){ // if condition added  for AAKH-SCF-0340 
				sch_first_time=(String)time_list.get(0);
				chk_date=bean.callingSchedule(start_date,sch_first_time,locale);
			}
			
		}
		if(chk_date){
	%>	
			document.prescription_detail_form.chk_missing_sch_yn.value="Y";
	<%	}

	}
	if((stat_yn.equals("Y") && !stat_yn.equals(""))|| (parent_stat_yn.equals("Y") && !parent_stat_yn.equals("")) ){
		%>
		document.prescription_detail_form.drug_name.disabled=true;
		document.prescription_detail_form.drug_search.disabled=true;
		document.prescription_detail_form.priority.disabled=true;
		document.prescription_detail_form.route_code.disabled=true;
		 document.prescription_detail_form.buildMAR_yn.disabled=true; 
		document.prescription_detail_form.dosage.disabled=true; 
		document.prescription_detail_form.qty_value.disabled=true;
		document.prescription_detail_form.qty_desc.disabled=true;
		document.prescription_detail_form.frequency.disabled=true;
		//document.prescription_detail_form.dosage_limit.disabled=true; //commented for MMS-KH-CRF-0080
//		document.prescription_detail_form.override_remarks.disabled=true; //commented for MMS-KH-SCF-0080
		
		document.prescription_detail_form.dis_split_dose.disabled=true;
		document.prescription_detail_form.durn_value.disabled=true;
		document.prescription_detail_form.durn_desc.disabled=true;
		document.prescription_detail_form.start_date.disabled=true;
		
		document.prescription_detail_form.end_date.disabled=true;
		
<%		if(!stat_yn.equals("") && (stat_yn.equals("Y"))){ //modified for AAKH-CRF-0140 start
			if(!(((allergy_yn != null && allergy_yn.equals("Y")) || current_rx.equals("Y") || (abuse_exists.equals("Y") && abuse_action.equals("B"))|| interaction_exists.equals("Y")) && (ext_prod_id== null  ||  ext_prod_id.equals("") || !drug_db_interface_yn.equals("Y")|| drug_db_duptherapy_yn.equals("N")))){ //Added { for MMS-KH-SCF-0216 if added for MMS-KH-SCF-0080  
              System.out.println("3188abuse_exists"+abuse_exists);
			System.out.println("3188abuse_action"+abuse_action);
%>			
			document.prescription_detail_form.dosage_limit.style.visibility="hidden";
			document.prescription_detail_form.override_remarks.style.visibility="hidden";
<%		
			}//Added } for MMS-KH-SCF-0216
		}
		
	}//AAKH-CRF-0091
%>
		
<% 
	System.err.println("PrescriptionDetail_1.jsp-=----2867---loading-end Drug--System.currentTimeMillis()---> " +System.currentTimeMillis());
		putObjectInBean(or_bean_id,orbean,request); 
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(presBean_id,presBean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{//added for ml-bru-crf-0469
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	
	}
	
%>
				} toHoldExecution(); </script>
</html>


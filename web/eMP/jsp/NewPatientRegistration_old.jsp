<!DOCTYPE html>
<!-- Last Modified Date Time : 11/5/2005 12:38 PM    -->

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.util.ArrayList, java.util.HashMap, java.util.StringTokenizer, webbeans.eCommon.ConnectionManager,java.util.*,eBL.Common.*,  eCommon.Common.*, eBL.*,eMP.*,java.io.*" %>


<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!-- End Of Common Include -->
<% 
	request.setCharacterEncoding("UTF-8");
	 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	 String locale			= (String)session.getAttribute("LOCALE");
%>

<html>
<head> 
	<%@ include file="PatientAddressLegends.jsp"%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language="JavaScript"src="../../eCommon/js/ValidateControl.js" ></Script>
	<Script language="JavaScript" src="../../eMP/js/SmartCard.js"></Script>
	<!--Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1-->
	<Script language="JavaScript" src="../../eMP/js/EmployeePrivilege.js"></Script>

<%
	
		if(session.getValue("smart_path")!= null) {
			if(!session.getValue("smart_path").equals(" ")){
				out.println(session.getValue("smart_path"));
			}
		}
		%>			
		
	<Script src="../../eMP/js/json02.js"></Script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>	
	<%
	 
	if(session.getValue("sekure_ws_yn")!= null) {
		if(session.getValue("sekure_ws_yn").equals("Y")){
			out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>");
		}
	}
	%>
	<Script language="JavaScript"src="../../eCommon/js/DateUtils.js" ></Script>
	<Script language="JavaScript"src="../../eCommon/js/dchk.js" ></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration4.js'></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script language="javascript" src="../../eBL/js/BLClearBean.js"></script>
	<script Language="javascript" src="../../eCommon/js/ScanDocument.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


 <!--Added by Rameswar on  15-03-2016 for MMS-DM-CRF-0035-->
</head>
<%  
 
 
	int tindex				= 1;
	int Demoaddlcnt		= 0;
	int Contactaddlcnt	= 0;
	int Othersaddlcnt		= 0;
	int order					= 1;
	Connection con		= ConnectionManager.getConnection(request);
	Properties p				= (java.util.Properties) session.getValue("jdbc");
	PreparedStatement stmt			= null;
	Boolean iSSiteApplicable = false;//added by shagar against GDOH-CRF-0111
	//PreparedStatement stmt1			= null;
	//PreparedStatement stmt_bl		= null;            
	//PreparedStatement doc_pstmt	= null;
	PreparedStatement oth_stmt		= null;	
	ResultSet rset				= null;
	//ResultSet rs_bl				= null;
	//ResultSet doc_rs			= null;
	ResultSet oth_rset		= null;
	//ResultSet rs		= null;
	String patient_grp		= checkForNull( request.getParameter("group") );
	String bl_install_yn		= (String) session.getValue("mp_bl_oper_yn");
	String Facility				= (String) session.getValue("facility_id");

	String operation				= "";
	String dflt_pat_regn_blng_class = "";
	String sql						= "";
	String maintain_doc_or_file		= "";
	String family_org_id_accept_yn		= "";
	String entitlement_by_pat_cat_yn		= "";
	String pat_category_reqd_yn = ""; //Added by Suji keerthi on 26-Nov-2019 for KDAH-CRF-0522
	String org_member_relationship_code		= "";
	String org_member_relationship_desc		= "";
	String FamilyNoLink				= "";
	String a_nationality_code		= "";
	String ext_system_interface_yn	= "";
	String dfltPSG					= "";
	String citizen_nationality_code	= "";
	//String sql_bl					= null;
	String name_prefix_reqd_yn		="";
   String cust_fields[]			= new String[5];
   
	ArrayList codes	= null;
	ArrayList descs	= null; 
	
	ArrayList acodes	= new ArrayList();
	ArrayList adescs	= new ArrayList();
   
	HashMap hash_Map2 = new HashMap();
	

	Object altidcode[]		= null;
	Object altiddesc[]		= null;
	Object contactmode[]	= null;
	Object contactdesc[]	= null;
	Object relationcode[]	= null;
	Object relationdesc[]	= null;
	
	String[] contact_col_names	= null;
	String[] contact_prompts		= null;
	String[] contact_fields			= null;

	Object oth_code[] = null; 
	Object oth_desc[] = null; 
	
	String PatInfflag = checkForNull(request.getParameter("PatIdflag"));

	/*Added to clear the bean values Start*/
	String bean_id = "";
	String bean_name = "";
	BLInsuranceImageBean blInsuranceImageBean 		= 	null;
	bean_id							= 	"bl_blinsuranceimagebean" ;
	bean_name						= 	"eBL.BLInsuranceImageBean";
	blInsuranceImageBean					= 	(BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request ) ;
	blInsuranceImageBean.clearBean();
	%>
	<script>
		clearBeanForBilling();
	</script>
	<%
	/*Added to clear the bean values End*/		
	
	/****** Imp. Note1: The sequence of getting the alt_id param value should always fallow the getting of AltIdNo param value ******/	

	String AltIdNo		= checkForNull( request.getParameter("Alt_Id_No") ); 

	/*** Thee values of variable 'alt_id' i.e., Alternate ID1 which is Entered through Modal window which appears on click of Button (which is based on Parameter setup). *****/

	String alt_id		= checkForNull(request.getParameter("alt_id")); 
	if(patient_grp.equals("A")) {
		if(!alt_id.equals("")) {
			AltIdNo = alt_id;
		}
	}
	
	/****** End of Imp. Note1 Ends ******/	

	/****** Imp. Note2: The sequence of getting the nat_id param value should always fallow the getting of a_national_id_no param value ******/	

	String a_national_id_no = checkForNull(request.getParameter("National_Id_No"));
	//hash_mp_param=eMP.NewbornDetails.getNewBornRelMandatory(con);
	
     
				
	/*** Thee values of variable 'nat_id' i.e., National ID which is Entered through Modal window which appears on click of Button (which is based on Parameter setup). *****/
	String nat_id = checkForNull( request.getParameter("nat_id") );
				
	if(patient_grp.equals("N")) {
		if(!nat_id.equals("")) {
			a_national_id_no = nat_id;
		}
	}
	
	/****** End of Imp. Note2 Ends ******/	

	String AltIdNo2					=  checkForNull(request.getParameter("Alt_Id2_No")); 
	String AltIdNo3					=  checkForNull(request.getParameter("Alt_Id3_No")); 
	String AltIdNo4					=  checkForNull(request.getParameter("Alt_Id4_No")); 
	String func_act					=  checkForNull(request.getParameter("func_act")); 
	String function_id					=  checkForNull(request.getParameter("function_id")); 
	String referral_id					=  checkForNull(request.getParameter("referral_id")); 
	String booking_ref_no			=  checkForNull(request.getParameter("booking_ref_no"));
	String init_appt_ref_no			=  checkForNull(request.getParameter("appt_ref_no"));
	String init_referral_id				=  checkForNull(request.getParameter("referral_id")); 
	String init_booking_ref_no		=  checkForNull(request.getParameter("booking_ref_no"));
	String init_a_national_id_no	=  checkForNull(request.getParameter("National_Id_No"));
	String init_nat_id					=  checkForNull(request.getParameter("nat_id")); 
	String refIDValue					=  checkForNull(request.getParameter("refIDValue")); 
	String refrlAappt					=  checkForNull(request.getParameter("refrlAappt")); 
	String appt = "";
	String appt_ref_no				= request.getParameter("appt_ref_no");
	String patient_id	=	checkForNull(request.getParameter("patient_id"));
   

	if(refrlAappt.equals("A") || refrlAappt.equals("R") || refrlAappt.equals("L") || refrlAappt.equals("I"))
		PatInfflag="N";
	else if(refrlAappt.equals("P"))
		PatInfflag="Y";

	
	if (appt_ref_no.equals("null"))  
		appt_ref_no = "" ;
    if (appt_ref_no.equals("")) 
		appt="N" ;
    else 
		appt = "Appt";

	if(!func_act.equals("") || !appt_ref_no.equals("")) operation = "insert";
	else operation = "Generate_File";

	if(!patient_grp.equals("N")) {
		if(!AltIdNo.equals("")&& patient_grp.equals("G")) 
			patient_grp = "A" ;
	}
	String q_booking_type = checkForNull( request.getParameter("q_booking_type") );

	String a_alt_id1_no = AltIdNo;

	String a_alt_id2_no	= AltIdNo2, a_alt_id3_no = AltIdNo3, a_alt_id4_no = AltIdNo4, a_alt_id1_exp_date = "";
	String a_alt_id2_exp_date = "", a_alt_id3_exp_date = "", a_alt_id4_exp_date = "";
	String a_oth_alt_id_type = "", a_oth_alt_id_no = "", a_race_code = "", a_ethnic_group_code = "";
	String a_res_addr_line1 = "", a_res_addr_line2	= "", a_res_addr_line3	= "";
	String a_res_addr_line4 = "", a_res_area_code = "", a_res_town_code = "", a_postal_code = "",a_postal_desc="";
	String a_country_code = "", a_res_country_desc = "", a_res_region_code = "", a_res_tel_no = "";
	String a_oth_contact_no = "", a_email_id = "", a_name_prefix = "", a_res_town_desc = "";
	String a_res_area_desc = "", a_res_region_desc = "", a_mail_addr_line1 = "";
	String a_mail_addr_line2 = "", a_mail_addr_line3 = "", a_mail_addr_line4 = "";
	String a_mail_town_code	= "", a_mail_area_code	= "", a_mail_country_code = "";
	String a_mail_country_desc = "", a_mail_postal_code = "", a_mail_region_code = "",a_mail_postal_desc="";
	String a_mail_town_desc	= "", a_mail_area_desc = "", general_remarks = "";
	String a_mail_region_desc = "", Site = "", a_birth_place_code = "", a_birth_place_desc = "";
	String a_place_of_birth	= "", relgn_code = "", contact3_mode = "", contact3_no = "";
	String contact4_mode = "", contact4_no = "", contact5_mode = "", contact5_no = "";
	String nkin_contact_name = "", nkin_contact_relation = "", contact1_nat_id_no = "";
	String contact1_alt_id1_no = "", contact1_alt_id2_no = "", contact1_alt_id3_no = "";
	String contact1_alt_id4_no = "", contact1_oth_alt_id_type = "", nkin_oth_alt_id_no = "";
	String contact1_birth_date = "", nkin_job_title = "", nkin_addr_line1 = "", nkin_addr_line2 = "";
	String nkin_addr_line3 = "", nkin_addr_line4 = "", nkin_area_long_desc = "";
	String nkin_region_long_desc = "", nkin_postal_code	= "", nkin_town_long_desc = "";
	String nkin_country_name = "", nkin_res_tel_no = "", nkin_mob_tel_no = "", nkin_off_tel_no = "";
	String nkin_email_id = "", fton_contact_name = "", fton_contact_relation = "", fton_alt_id_no = "";
	String fton_job_title = "", fton_nat_id_no = "", fton_addr_line1 = "", fton_addr_line2 = "";
	String fton_addr_line3 = "", fton_addr_line4 = "", fton_town_long_desc = "";
	String fton_area_long_desc = "", fton_region_long_desc = "", fton_postal_code = "";
	String fton_country_name = "", fton_res_tel_no = "", fton_mob_tel_no = "", fton_off_tel_no = "";
	String fton_email_id = "", organization_name = "", emplr_contact_name = "", emplr_addr_line1 = "";
	String emplr_addr_line2	= "", emplr_addr_line3	= "", emplr_addr_line4 = "", doc1_num = "";
	String emplr_off_tel_no	= "", emplr_res_tel_no	= "", patient_employee_id = "", doc2_num = "";
	String emplr_town_long_desc	= "", emplr_region_long_desc = "", emplr_area_long_desc	= "";
	String emplr_postal_code = "", emplr_country_name = "", doc1_exp_date = "", doc3_num = "";
	String doc1_place_of_issue = "", doc1_iss_date = "", doc2_exp_date = "", doc2_place_of_issue = "";
	String doc2_iss_date = "", doc3_exp_date = "", doc3_place_of_issue = "", doc3_iss_date = "";
	String doc4_num = "", doc4_exp_date = "", doc4_place_of_issue = "", doc4_iss_date = "";
	String informant = "", informant_remarks = "", dflt_alt_id1_in_emp_id_yn = "N";
	
	/*Below variable added for this [RUT-CRF-0011]*/
	String patient_cat_code=""; String patient_cat_desc=""; String language_id="";String language_desc="";

	String dflt_language_id="",dflt_relgn_code="",inv_pat_search_in_reg_pat_yn="N";
	String res_contact_name ="";
	String mail_contact_name ="";
	
	String a_first_name		= checkForNull( request.getParameter("First_Name") );
	String a_second_name	= checkForNull( request.getParameter("Second_Name") );
	String a_third_name		= checkForNull( request.getParameter("Third_Name") );
	String a_family_name		= checkForNull( request.getParameter("Family_Name") );	

	String a_family_name_loc_lang		= checkForNull( request.getParameter("a_family_name_loc_lang") );
	String a_first_name_loc_lang		= checkForNull( request.getParameter("a_first_name_loc_lang") );
	String a_second_name_loc_lang		= checkForNull( request.getParameter("a_second_name_loc_lang") );
	String a_third_name_loc_lang		= checkForNull( request.getParameter("a_third_name_loc_lang") );
	String a_patient_name_loc_lang		= checkForNull( request.getParameter("a_patient_name_loc_lang") ); 	

	String drfunctionid		= checkForNull( request.getParameter("dr_function_id") );
	// New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
	String country_reqd_yn="N",region_reqd_yn="N",mobile_no_reqd_yn="N";
	String country_visibility = "visibility:hidden";
	String region_visibility = "visibility:hidden";
	String mobile_no_visibility = "visibility:hidden";
	String region_prompt		= "";
	String region_appl_yn		= "";
	// New parameter  is added against AMRI-CRF-0388 by Shagar
	String postal_cd_reqd_yn="N",area_reqd_yn="N";
	String town_reqd_yn="N"; //Added by Suji keerthi on 27-Nov-2019 for KDAH-CRF-0522
	//String postal_visibility = "visibility:hidden";
	//String area_visibility = "visibility:hidden";
	//Ends here
/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
	String addr_line1_prompt		= "";
	String addr_line2_prompt		= "";
	String postal_code_prompt		= "";
	String area_code_prompt		    = ""; /*Added against AMRI-CRF-0388 by Shagar*/
	String town_code_prompt         = ""; /*Added by Suji keerthi on 27-Nov-2019 for KDAH-CRF-0522*/
/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/	

	/*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/
	String alt_addr_line1 = "",alt_addr_line2="",alt_addr_line3="";
	String alt_addr_line4 = "",alt_country_code="", alt_country_desc="", alt_postal_code="";
	String alt_postal_desc = "", alt_area_desc	= "", alt_area_code="",alt_town_code="";
	String alt_town_desc = "",alt_region_code="", alt_region_desc = ""; 
	/*End*/

	// Newly Added against KDAH-CRF-0273 [IN:045012]  By saanthaakumar
	String email_id_reqd_yn = "N";
	String email_visibility = "visibility:hidden"; //Ends here
	if(a_family_name.length() >= 1) {
		int ch = a_family_name.charAt(0);
		if((ch >= 65 && ch <= 90) || (ch >= 97) && ch <= 122) {
			a_family_name = (a_family_name.substring(0,1)).toUpperCase() + a_family_name.substring(1);
		} 
	}
	
	String a_name_suffix = "", a_patient_name = "", a_patient_long_name = "",a_patient_long_name_loc_lang = "",year = "", days	= "", months = "", a_legal_yn = "",hours = "";
	String max_pat_age = "", a_citizen_yn = "", pat_name_as_multipart_yn = "";
	String Accept_oth_alt_id_yn	= "", create_file_at_pat_regn_yn = "";
	String accept_national_id_no_yn	= "N", alt_id1_accept_oth_pat_ser_yn = "N"; 
	String alt_id1_accept_alphanumeric_yn = "N";
	//added by mujafar for ML-MMOH-CRF-524.1 start
	String alt_id1_alphanum_validate_yn = "N" ;
	String alt_id2_alphanum_validate_yn = "N" ;
	String alt_id3_alphanum_validate_yn = "N" ;
	String alt_id4_alphanum_validate_yn = "N" ;
	//added by mujafar for ML-MMOH-CRF-524.1 end
	String nat_id_accept_alphanumeric_yn = "N";
	String a_name_prefix_loc_lang="", a_name_suffix_loc_lang = ""; 

	/*Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] Start */
	String alt_id2_accept_oth_pat_ser_yn		= "";
	String alt_id2_accept_alphanumeric_yn		= "";
	String alt_id3_accept_oth_pat_ser_yn		= "";
	String alt_id3_accept_alphanumeric_yn		= "";
	String alt_id4_accept_oth_pat_ser_yn		= "";
	String alt_id4_accept_alphanumeric_yn		= "";
	/*Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] End */


	
	a_patient_name_loc_lang= "";

	String a_gender			= checkForNull( request.getParameter("Sex") ); 
	if (a_gender.equals("A"))
		 a_gender="";
	String a_date_of_birth	= checkForNull(request.getParameter("Dob")); 
	String a_familyno			= checkForNull(request.getParameter("Family_No"));
	String nat_invoke_routine = "";
	String nat_data_source_id = "";
	String nat_id_check_digit_id = "";
	String nat_id_chk_len  = "";
	String def_nat_id_pat_ser_grp   = "";

	ArrayList contact_addr  = fetchContactAddresses(con, out,"parent.parent.messageFrame",p);
	Site							= (String)contact_addr.get(0);
	contact_col_names		= (String[])contact_addr.get(1);
	contact_prompts			= (String[])contact_addr.get(2);
	contact_fields				= (String[])contact_addr.get(3);
	//contact_addr				= null;
	
	
// This array building is now handled in PatNamesComp.jsp
	
	/*Added by Rameswar on  13-04-2016 for MMS-QF-SCF-0532 TF*/
	Boolean fileTypeSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","FILE_TYPE_RESTRICT");
	
    iSSiteApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "COPY_FIRST_NOTIFY_REMOVED");
	Boolean addr_pincode_mand = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ADDR_PINCODE_MAND");
	/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
	Boolean finDtlsChkNationality = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","FIN_DTLS_CHK_NATIONALITY");//Added by Ashwini on 07-Sep-2018
	
	Boolean alterAddressApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE"); // added by mujafar for ML-MMOH-CRF-0601	
	//Added for this CRF ML-MMOH-CRF-0860.2
	String maxsize="30";
	String col_span_td="";
	String maximumLength="30";
	Boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
	if(increasedaddressLength){
	  col_span_td="2";
	  maximumLength="50";
	 // maxsize="58";
	 maxsize="64";
	}
	//End this ML-MMOH-CRF-0860.2
	
	//Added for this CRF ML-MMOH-CRF-0601
	String colspantd="colspan=4";	
	if(alterAddressApplicable || increasedaddressLength){
		colspantd="colspan=6";		
	}	 
	//End this ML-MMOH-CRF-0601


	if(appt.equals("Appt") || func_act.equals("Visitreg") || func_act.equals("REF_SEARCH") ||func_act.equals("DuplicateRegistration"))
	{ 
		%>
		<script> 
			 if(parent.parent.frames[0].document.forms[0].home)
				 parent.parent.frames[0].document.forms[0].home.disabled = true;
			 if(parent.parent.frames[0].document.forms[0].query)
				 parent.parent.frames[0].document.forms[0].query.disabled = true;
			 if(parent.parent.frames[0].document.forms[0].create)
				 parent.parent.frames[0].document.forms[0].create.disabled = true;
		</script>
		<%
	}
			
	try
	{
		//query to populate values for Patient Information 		

		if(refrlAappt.equals("P"))
		{
			sql="SELECT b.PATIENT_NAME patient_name,b.patient_long_name patient_long_name,b.patient_long_name_loc_lang patient_long_name_loc_lang,a.addr1_line1 res_addr_line1,a.addr1_line2 res_addr_line2,a.addr1_line3 res_addr_line3,a.addr1_line4 res_addr_line4,a.res_town1_code res_town_code, mp_get_desc.MP_RES_TOWN(a.res_town1_code,'"+locale+"',1) res_town_desc,a.res_area1_code res_area_code,mp_get_desc.MP_RES_AREA(a.res_area1_code,'"+locale+"',1) res_area_desc,a.region1_code res_region_code,mp_get_desc.MP_REGION(a.region1_code,'"+locale+"',1) res_region_desc,a.postal1_code postal_code,mp_get_desc.MP_POSTAL_CODE(a.postal1_code,'"+locale+"',2) postal_desc,a.COUNTRY1_CODE res_country_code ,mp_get_desc.MP_COUNTRY(a.COUNTRY1_CODE,'"+locale+"',1) res_country_desc,a.addr2_line1 mail_addr_line1,a.addr2_line2 mail_addr_line2,a.addr2_line3 mail_addr_line3,a.addr2_line4 mail_addr_line4,a.res_town2_code mail_town_code,mp_get_desc.MP_RES_TOWN(a.res_town2_code,'"+locale+"',1) mail_town_desc,a.region2_code mail_region_code, mp_get_desc.MP_REGION(a.region2_code,'"+locale+"',1) mail_region_desc,a.res_area2_code mail_area_code, mp_get_desc.MP_RES_AREA(a.res_area2_code,'"+locale+"',1) mail_area_desc,a.postal2_code,a.COUNTRY2_CODE mail_country_code,mp_get_desc.MP_COUNTRY(a.COUNTRY2_CODE,'"+locale+"',1) mail_country_desc,postal2_code mail_postal_code, mp_get_desc.MP_POSTAL_CODE(a.postal2_code,'"+locale+"',2) mail_postal_desc,b.contact1_no res_tel_no,a.CONTACT1_NAME res_contact_name,CONTACT2_NAME mail_contact_name, a.alt_addr_line1, a.alt_addr_line2, a.alt_addr_line3, a.alt_addr_line4, a.alt_town_code, MP_GET_DESC.MP_RES_TOWN(a.alt_town_code,'"+locale+"','1') alt_town_desc,  a.alt_area_code, MP_GET_DESC.MP_RES_AREA(a.alt_area_code,'"+locale+"','1') alt_area_desc, a.alt_region_code, MP_GET_DESC.MP_REGION(a.alt_region_code,'"+locale+"','1') alt_region_desc, a.alt_country_code, MP_GET_DESC.MP_COUNTRY(a.alt_country_code,'"+locale+"','1') alt_country_desc, a.alt_postal_code, MP_GET_DESC.MP_POSTAL_CODE(a.alt_postal_code,'"+locale+"','2') alt_postal_desc FROM MP_PAT_ADDRESSES a,mp_patient b WHERE b.PATIENT_ID=a.PATIENT_ID AND b.PATIENT_ID='"+refIDValue+"'";//Modified by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601

			
			
			if(oth_rset!=null) oth_rset.close();
			if(oth_stmt!=null) oth_stmt.close();
			oth_stmt = con.prepareStatement(sql);
			oth_rset = oth_stmt.executeQuery();	

		}//Query to populate the values from OP
		else if(func_act.equals("DuplicateRegistration"))
		{
			
				StringBuffer  sqlSb = new StringBuffer();
				sqlSb.append("SELECT patient.alt_id1_type alt_id1_type,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.alt_id1_type IS NOT NULL  THEN (mp_get_desc.MP_ALTERNATE_ID_TYPE(patient.alt_id1_type,'"+locale+"',1))");
				sqlSb.append("         END) alt_id1_desc,");
				sqlSb.append("        patient.alt_id1_no alt_id1_no,");
				sqlSb.append("        TO_CHAR(patient.alt_id1_exp_date,'dd/mm/yyyy') alt_id1_exp_date,");
				sqlSb.append("        patient.alt_id2_type alt_id2_type,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.alt_id2_type IS NOT NULL  THEN (mp_get_desc.MP_ALTERNATE_ID_TYPE(patient.alt_id2_type,'"+locale+"',1))");
				sqlSb.append("         END) alt_id2_desc,");
				sqlSb.append("        patient.alt_id2_no alt_id2_no,");
				sqlSb.append("        TO_CHAR(patient.alt_id2_exp_date,'dd/mm/yyyy') alt_id2_exp_date,");
				sqlSb.append("        patient.alt_id3_type alt_id3_type,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.alt_id3_type IS NOT NULL  THEN (mp_get_desc.MP_ALTERNATE_ID_TYPE(patient.alt_id3_type,'"+locale+"',1))");
				sqlSb.append("         END) alt_id3_desc,");
				sqlSb.append("        patient.alt_id3_no alt_id3_no,");
				sqlSb.append("        TO_CHAR(patient.alt_id3_exp_date,'dd/mm/yyyy') alt_id3_exp_date,");
				sqlSb.append("        patient.alt_id4_type alt_id4_type,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.alt_id4_type IS NOT NULL  THEN (mp_get_desc.MP_ALTERNATE_ID_TYPE(patient.alt_id4_type,'"+locale+"',1))");
				sqlSb.append("         END) alt_id4_desc,");
				sqlSb.append("        patient.alt_id4_no alt_id4_no,");
				sqlSb.append("        TO_CHAR(patient.alt_id4_exp_date,'dd/mm/yyyy') alt_id4_exp_date,");
				sqlSb.append("        patient.birth_place_code birth_place_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.birth_place_code IS NOT NULL  THEN (mp_get_desc.MP_BIRTH_PLACE(patient.birth_place_code,'"+locale+"',1))");
				sqlSb.append("         END) birth_place_desc,");
				sqlSb.append("        patient.place_of_birth place_of_birth,");
				sqlSb.append("  CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),1) ear,");
				sqlSb.append("  CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),2) months,");
				sqlSb.append("  CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),3) days,");
				sqlSb.append("  CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),4) hours,");
				sqlSb.append("        patient.citizen_yn citizen_yn,");
				sqlSb.append("        pat_rl_con.contact1_alt_id1_no,");
				sqlSb.append("        pat_rl_con.contact1_alt_id2_type,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact1_alt_id2_type IS NOT NULL  THEN (mp_get_desc.MP_ALTERNATE_ID_TYPE(pat_rl_con.contact1_alt_id2_type,'"+locale+"',");
				sqlSb.append("                                                                                                     1))");
				sqlSb.append("         END) nkin_alt_id2_desc,");
				sqlSb.append("        pat_rl_con.contact1_alt_id2_no,");
				sqlSb.append("        pat_rl_con.contact1_alt_id3_type,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact1_alt_id3_type IS NOT NULL  THEN (mp_get_desc.MP_ALTERNATE_ID_TYPE(pat_rl_con.contact1_alt_id3_type,'"+locale+"',");
				sqlSb.append("                                                                                                     1))");
				sqlSb.append("         END) nkin_alt_id3_desc,");
				sqlSb.append("        pat_rl_con.contact1_alt_id3_no,");
				sqlSb.append("        pat_rl_con.contact1_alt_id4_type,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact1_alt_id4_type IS NOT NULL  THEN (mp_get_desc.MP_ALTERNATE_ID_TYPE(pat_rl_con.contact1_alt_id4_type,'"+locale+"',");
				sqlSb.append("                                                                                                     1))");
				sqlSb.append("         END) nkin_alt_id4_desc,");
				sqlSb.append("        pat_rl_con.contact1_alt_id4_no,");
				sqlSb.append("        pat_rl_con.contact1_oth_alt_id_type,");
				sqlSb.append("        pat_rl_con.contact1_nat_id_no,");
				sqlSb.append("        pat_rl_con.contact1_alt_id1_type,");
				sqlSb.append("        pat_rl_con.contact2_oth_alt_id_type,");
				sqlSb.append("        patient.contact3_mode contact3_mode,");
				sqlSb.append("        patient.contact3_no contact3_no,");
				sqlSb.append("        patient.contact4_mode contact4_mode,");
				sqlSb.append("        patient.contact4_no contact4_no,");
				sqlSb.append("        patient.contact5_mode contact5_mode,");
				sqlSb.append("        patient.contact5_no contact5_no,");
				sqlSb.append("        patient.oth_alt_id_no oth_alt_id_no,");
				sqlSb.append("        patient.email_id email_id,");
				sqlSb.append("        pat_rl_con.addr3_line1 emplr_addr_line1,");
				sqlSb.append("        pat_rl_con.addr3_line2 emplr_addr_line2,");
				sqlSb.append("        pat_rl_con.addr3_line3 emplr_addr_line3,");
				sqlSb.append("        pat_rl_con.addr3_line4 emplr_addr_line4,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact3_res_area_code IS NOT NULL  THEN (mp_get_desc.MP_RES_AREA(pat_rl_con.contact3_res_area_code,'"+locale+"',");
				sqlSb.append("                                                                                             1))");
				sqlSb.append("         END) emplr_area_long_desc,");
				sqlSb.append("        pat_rl_con.contact3_name emplr_contact_name,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.country3_code IS NOT NULL  THEN (mp_get_desc.MP_COUNTRY(pat_rl_con.country3_code,'"+locale+"',1))");
				sqlSb.append("         END) emplr_country_name,");
				sqlSb.append("        pat_rl_con.off3_tel_no emplr_off_tel_no,");
				sqlSb.append("        pat_rl_con.res3_tel_no emplr_res_tel_no,");
				sqlSb.append("        pat_rl_con.postal3_code emplr_postal_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact3_region_code IS NOT NULL  THEN (mp_get_desc.MP_REGION(pat_rl_con.contact3_region_code,'"+locale+"',");
				sqlSb.append("                                                                                         1))");
				sqlSb.append("         END) emplr_region_long_desc,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact3_res_town_code IS NOT NULL  THEN (mp_get_desc.MP_RES_TOWN(pat_rl_con.contact3_res_town_code,'"+locale+"',");
				sqlSb.append("                                                                                             1))");
				sqlSb.append("         END) emplr_town_long_desc,");
				sqlSb.append("        patient.ethnic_grp_code ethnic_group_code,");
				sqlSb.append("        patient.family_name family_name,");
				sqlSb.append("        patient.first_name first_name,");
				sqlSb.append("        pat_rl_con.addr2_line1 fton_addr_line1,");
				sqlSb.append("        pat_rl_con.addr2_line2 fton_addr_line2,");
				sqlSb.append("        pat_rl_con.addr2_line3 fton_addr_line3,");
				sqlSb.append("        pat_rl_con.addr2_line4 fton_addr_line4,");
				sqlSb.append("        pat_rl_con.contact2_oth_alt_id_no fton_alt_id_no,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact2_res_area_code IS NOT NULL  THEN (mp_get_desc.MP_RES_AREA(pat_rl_con.contact2_res_area_code,'"+locale+"',");
				sqlSb.append("                                                                                             1))");
				sqlSb.append("         END) fton_area_long_desc,");
				sqlSb.append("        pat_rl_con.contact2_name fton_contact_name,");
				sqlSb.append("        pat_rl_con.contact2_relation fton_contact_relation,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.country2_code IS NOT NULL  THEN (mp_get_desc.MP_COUNTRY(pat_rl_con.country2_code,'"+locale+"',1))");
				sqlSb.append("         END) fton_country_name,");
				sqlSb.append("        pat_rl_con.contact2_email_id fton_email_id,");
				sqlSb.append("        pat_rl_con.job2_title fton_job_title,");
				sqlSb.append("        pat_rl_con.contact2_mob_tel_no fton_mob_tel_no,");
				sqlSb.append("        pat_rl_con.contact2_nat_id_no fton_nat_id_no,");
				sqlSb.append("        pat_rl_con.off2_tel_no fton_off_tel_no,");
				sqlSb.append("        pat_rl_con.postal2_code fton_postal_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact2_region_code IS NOT NULL  THEN (mp_get_desc.MP_REGION(pat_rl_con.contact2_region_code,'"+locale+"',");
				sqlSb.append("                                                                                         1))");
				sqlSb.append("         END) fton_region_long_desc,");
				sqlSb.append("        pat_rl_con.res2_tel_no fton_res_tel_no,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact2_res_town_code IS NOT NULL  THEN (mp_get_desc.MP_RES_TOWN(pat_rl_con.contact2_res_town_code,'"+locale+"',");
				sqlSb.append("                                                                                             1))");
				sqlSb.append("         END) fton_town_long_desc,");
				sqlSb.append("        pat_oth_dtls.general_remarks general_remarks,");
				sqlSb.append("        pat_oth_dtls.regn_informant informant,");
				sqlSb.append("        pat_oth_dtls.regn_comments informant_remarks,");
				sqlSb.append("        patient.legal_yn legal_yn,");
				sqlSb.append("        pat_addr.addr2_line1 mail_addr_line1,");
				sqlSb.append("        pat_addr.addr2_line2 mail_addr_line2,");
				sqlSb.append("        pat_addr.addr2_line3 mail_addr_line3,");
				sqlSb.append("        pat_addr.addr2_line4 mail_addr_line4,");
				sqlSb.append("        pat_addr.country2_code mail_country_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_addr.country2_code IS NOT NULL  THEN (mp_get_desc.MP_COUNTRY(pat_addr.country2_code,'"+locale+"',1))");
				sqlSb.append("         END) mail_country_desc,");
				sqlSb.append("        pat_addr.postal2_code mail_postal_code,");
				sqlSb.append("        pat_addr.region2_code mail_region_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_addr.region2_code IS NOT NULL  THEN (mp_get_desc.MP_REGION(pat_addr.region2_code,'"+locale+"',1))");
				sqlSb.append("         END) mail_region_desc,");
				sqlSb.append("        pat_addr.res_area2_code mail_area_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_addr.res_area2_code IS NOT NULL  THEN (mp_get_desc.MP_RES_AREA(pat_addr.res_area2_code,'"+locale+"',1))");
				sqlSb.append("         END) mail_area_desc,");
				sqlSb.append("        pat_addr.res_town2_code mail_town_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_addr.res_town2_code IS NOT NULL  THEN (mp_get_desc.MP_RES_TOWN(pat_addr.res_town2_code,'"+locale+"',1))");
				sqlSb.append("         END) mail_town_desc,");
				sqlSb.append("        patient.name_prefix name_prefix,");
				sqlSb.append("        patient.name_suffix name_suffix,");
				sqlSb.append("        patient.national_id_no national_id_no,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.nationality_code IS NOT NULL  THEN (mp_get_desc.MP_COUNTRY(patient.nationality_code,'"+locale+"',3))");
				sqlSb.append("         END) nationality_desc,");
				sqlSb.append("        pat_rl_con.addr1_line1 nkin_addr_line1,");
				sqlSb.append("        pat_rl_con.addr1_line2 nkin_addr_line2,");
				sqlSb.append("        pat_rl_con.addr1_line3 nkin_addr_line3,");
				sqlSb.append("        pat_rl_con.addr1_line4 nkin_addr_line4,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact1_res_area_code IS NOT NULL  THEN (mp_get_desc.MP_RES_AREA(pat_rl_con.contact1_res_area_code,'"+locale+"',");
				sqlSb.append("                                                                                             1))");
				sqlSb.append("         END) nkin_area_long_desc,");
				sqlSb.append("        pat_rl_con.contact1_name nkin_contact_name,");
				sqlSb.append("        pat_rl_con.contact1_relation nkin_contact_relation,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact1_relation IS NOT NULL  THEN (mp_get_desc.MP_RELATIONSHIP(pat_rl_con.contact1_relation,'"+locale+"',");
				sqlSb.append("                                                                                            2))");
				sqlSb.append("         END) nkin_contact_relation_desc,");
				sqlSb.append("        pat_rl_con.country1_code nkin_country_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.country1_code IS NOT NULL  THEN (mp_get_desc.MP_COUNTRY(pat_rl_con.country1_code,'"+locale+"',1))");
				sqlSb.append("         END) nkin_country_name,");
				sqlSb.append("        pat_rl_con.contact1_email_id nkin_email_id,");
				sqlSb.append("        pat_rl_con.job1_title nkin_job_title,");
				sqlSb.append("        pat_rl_con.contact1_mob_tel_no nkin_mob_tel_no,");
				sqlSb.append("        pat_rl_con.off1_tel_no nkin_off_tel_no,");
				sqlSb.append("        pat_rl_con.contact1_oth_alt_id_no nkin_oth_alt_id_no,");
				sqlSb.append("        pat_rl_con.postal1_code nkin_postal_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact1_region_code IS NOT NULL  THEN (mp_get_desc.MP_REGION(pat_rl_con.contact1_region_code,'"+locale+"',");
				sqlSb.append("                                                                                         1))");
				sqlSb.append("         END) nkin_region_long_desc,");
				sqlSb.append("        pat_rl_con.res1_tel_no nkin_res_tel_no,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_rl_con.contact1_res_town_code IS NOT NULL  THEN (mp_get_desc.MP_RES_TOWN(pat_rl_con.contact1_res_town_code,'"+locale+"',");
				sqlSb.append("                                                                                             1))");
				sqlSb.append("         END) nkin_town_long_desc,");
				sqlSb.append("        pat_rl_con.organization_name,");
				sqlSb.append("        patient.contact2_no oth_contact_no,");
				sqlSb.append("        patient.oth_alt_id_type oth_alt_id_type,");
				sqlSb.append("        pat_rl_con.patient_employee_id patient_employee_id,");
				sqlSb.append("        patient.patient_name patient_name,");
				sqlSb.append("        patient.patient_long_name patient_long_name,");
				sqlSb.append("        patient.patient_long_name_loc_lang patient_long_name_loc_lang,");
				sqlSb.append("        patient.contact1_no res_tel_no,");
				sqlSb.append("        patient.race_code race_code,");
				sqlSb.append("        patient.region_code res_region_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.region_code IS NOT NULL  THEN (mp_get_desc.MP_REGION(patient.region_code,'"+locale+"',1))");
				sqlSb.append("         END) res_region_desc,");
				sqlSb.append("        patient.relgn_code relgn_code,");
				sqlSb.append("        patient.res_area_code res_area_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.res_area_code IS NOT NULL  THEN (mp_get_desc.MP_RES_AREA(patient.res_area_code,'"+locale+"',1))");
				sqlSb.append("         END) res_area_desc,");
				sqlSb.append("        patient.res_town_code res_town_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN patient.res_town_code IS NOT NULL  THEN (mp_get_desc.MP_RES_TOWN(patient.res_town_code,'"+locale+"',1))");
				sqlSb.append("         END) res_town_desc,");
				sqlSb.append("        pat_addr.addr1_line1 res_addr_line1,");
				sqlSb.append("        pat_addr.addr1_line2 res_addr_line2,");
				sqlSb.append("        pat_addr.addr1_line3 res_addr_line3,");
				sqlSb.append("        pat_addr.addr1_line4 res_addr_line4,");
				sqlSb.append("        pat_addr.country1_code res_country_code,");
				sqlSb.append("        (CASE ");
				sqlSb.append("           WHEN pat_addr.country1_code IS NOT NULL  THEN (mp_get_desc.MP_COUNTRY(pat_addr.country1_code,'"+locale+"',1))");
				sqlSb.append("         END) res_country_desc,");
				sqlSb.append("        pat_addr.postal1_code postal_code,");
				sqlSb.append("        patient.second_name second_name,");
				sqlSb.append("        patient.sex gender,");
				sqlSb.append("        patient.third_name third_name,");
				sqlSb.append("        TO_CHAR(patient.date_of_birth,'dd/mm/yyyy') date_of_birth"); 

				sqlSb.append(" , pat_docs.DOC1_TYPE, nvl(pat_docs.DOC1_NUM,' ') DOC1_NUM, to_char(pat_docs.DOC1_EXP_DATE,'dd/mm/yyyy') DOC1_EXP_DATE, nvl(pat_docs.DOC1_PLACE_OF_ISSUE,'') DOC1_PLACE_OF_ISSUE, to_char(pat_docs.DOC1_ISS_DATE,'dd/mm/yyyy') DOC1_ISS_DATE, nvl(pat_docs.DOC2_TYPE,'') DOC2_TYPE, nvl(pat_docs.DOC2_NUM,'') DOC2_NUM, to_char(pat_docs.DOC2_EXP_DATE,'dd/mm/yyyy') DOC2_EXP_DATE, nvl(pat_docs.DOC2_PLACE_OF_ISSUE,'') DOC2_PLACE_OF_ISSUE, to_char(pat_docs.DOC2_ISS_DATE,'dd/mm/yyyy') DOC2_ISS_DATE, nvl(pat_docs.DOC3_TYPE,'') DOC3_TYPE, nvl(pat_docs.DOC3_NUM,'') DOC3_NUM, to_char(pat_docs.DOC3_EXP_DATE,'dd/mm/yyyy') DOC3_EXP_DATE, nvl(pat_docs.DOC3_PLACE_OF_ISSUE,'') DOC3_PLACE_OF_ISSUE, to_char(pat_docs.DOC3_ISS_DATE,'dd/mm/yyyy') DOC3_ISS_DATE, nvl(pat_docs.DOC4_TYPE,'') DOC4_TYPE, nvl(pat_docs.DOC4_NUM,'') DOC4_NUM, to_char(pat_docs.DOC4_EXP_DATE,'dd/mm/yyyy') DOC4_EXP_DATE, nvl(pat_docs.DOC4_PLACE_OF_ISSUE,'') DOC4_PLACE_OF_ISSUE, to_char(pat_docs.DOC4_ISS_DATE,'dd/mm/yyyy') DOC4_ISS_DATE ");
				
				sqlSb.append("        , pat_addr.alt_addr_line1, pat_addr.alt_addr_line2,  pat_addr.alt_addr_line3,  pat_addr.alt_addr_line4, pat_addr.alt_town_code, MP_GET_DESC.MP_RES_TOWN(pat_addr.alt_town_code,'"+locale+"','1') alt_town_desc,  pat_addr.alt_area_code, MP_GET_DESC.MP_RES_AREA(pat_addr.alt_area_code,'"+locale+"','1') alt_area_desc, pat_addr.alt_region_code, MP_GET_DESC.MP_REGION(pat_addr.alt_region_code,'"+locale+"','1') alt_region_desc, pat_addr.alt_country_code, MP_GET_DESC.MP_COUNTRY(pat_addr.alt_country_code,'"+locale+"','1') alt_country_desc, pat_addr.alt_postal_code, MP_GET_DESC.MP_POSTAL_CODE(pat_addr.alt_postal_code,'"+locale+"','2') alt_postal_desc");//Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601

				sqlSb.append(" FROM   mp_patient patient,");
				sqlSb.append("        mp_pat_addresses pat_addr,");
				sqlSb.append("        mp_pat_rel_contacts pat_rl_con,");
				sqlSb.append("        mp_pat_oth_dtls pat_oth_dtls");

				sqlSb.append("		  mp_pat_documents pat_docs");

				sqlSb.append(" WHERE  patient.patient_id = pat_addr.patient_id (+) ");
				sqlSb.append("        AND patient.patient_id = pat_rl_con.patient_id (+) ");
				sqlSb.append("        AND patient.patient_id = pat_oth_dtls.patient_id (+) ");

				sqlSb.append("        AND patient.patient_id = pat_docs.patient_id (+) ");

				sqlSb.append("        AND patient.patient_id ='"+drfunctionid+"'");

			

			oth_stmt = con.prepareStatement(sqlSb.toString());
			oth_rset = oth_stmt.executeQuery();	
		}//end of if for DR...
		else
		if (appt.equals("Appt") || refrlAappt.equals("A"))
		{
		   /*sql = "SELECT facility_id,"+
					 "        appt_ref_no,"+
					 "        clinic_code,"+
					 "        practitioner_id,"+
					 "        name_prefix,"+
					 "        first_name,"+
					 "        second_name,"+
					 "        third_name,"+
					 "        family_name,"+
					 "        name_suffix,"+
					 "        patient_name,"+
					 "        name_prefix_loc_lang,"+
					 "        first_name_loc_lang,"+
					 "        second_name_loc_lang,"+
					 "        third_name_loc_lang,"+
					 "        family_name_loc_lang,"+
					 "        name_suffix_loc_lang,"+
					 "        patient_name_loc_lang,"+
					 "        national_id_no,"+
					 "        alt_id1_no,"+
					 "        alt_id2_no,"+
					 "        alt_id3_no,"+
					 "        alt_id4_no,"+
					 "        oth_alt_id_type,"+
					 "        oth_alt_id_no,"+
					 "        TO_CHAR(alt_id1_exp_date,'DD/MM/YYYY') alt_id1_exp_date,"+
					 "        TO_CHAR(alt_id2_exp_date,'DD/MM/YYYY') alt_id2_exp_date,"+
					 "        TO_CHAR(alt_id3_exp_date,'DD/MM/YYYY') alt_id3_exp_date,"+
					 "        TO_CHAR(alt_id4_exp_date,'DD/MM/YYYY') alt_id4_exp_date,"+
					 "        TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),1) YEAR,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),2) months,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),3) days,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),4) hours,"+
					 "        gender,"+
					 "        birth_place_code,"+
					 "        mp_get_desc.MP_BIRTH_PLACE(a.birth_place_code,'"+locale+"',1) birth_place_desc,"+
					 "        birth_place_desc place_of_birth,"+
					 "        country_code nationality_code,"+
					 "        mp_get_desc.MP_COUNTRY(a.country_code,'"+locale+"',1) nationality_desc,"+
					 "        race_code,"+
					 "        ethnic_group_code,"+
					 "        res_addr_line1,"+
					 "        res_addr_line2,"+
					 "        res_addr_line3,"+
					 "        res_addr_line4,"+
					 "        res_area_code,"+
					 "        mp_get_desc.MP_RES_AREA(a.res_area_code,'"+locale+"',1) res_area_desc,"+
					 "        res_town_code,"+
					 "        mp_get_desc.MP_RES_TOWN(a.res_town_code,'"+locale+"',1) res_town_desc,"+
					 "        res_region_code,"+
					 "        mp_get_desc.MP_REGION(a.res_region_code,'"+locale+"',1) res_region_desc,"+
					 "        postal_code,"+
					 "        res_country_code,"+
					 "        mp_get_desc.MP_COUNTRY(a.res_country_code,'"+locale+"',1) res_country_desc,"+
					 "        mail_addr_line1,"+
					 "        mail_addr_line2,"+
					 "        mail_addr_line3,"+
					 "        mail_addr_line4,"+
					 "        mail_town_code,"+
					 "        mail_area_code,"+
					 "        mp_get_desc.MP_RES_AREA(a.mail_area_code,'"+locale+"',1) mail_area_desc,"+
					 "        mp_get_desc.MP_RES_TOWN(a.mail_town_code,'"+locale+"',1) mail_town_desc,"+
					 "        mail_region_code,"+
					 "        mp_get_desc.MP_REGION(a.mail_region_code,'"+locale+"',1) mail_region_desc,"+
					 "        mail_postal_code,"+
					 "        mail_country_code,"+
					 "        mp_get_desc.MP_COUNTRY(a.mail_country_code,'"+locale+"',1) mail_country_desc,"+
					 "        res_tel_no,"+
					 "        oth_contact_no,"+
					 "        email_id,"+
					 "        referral_id,"+
					 "        contact_reason_code,"+
					 "        mode_of_contact,"+
					 "        citizen_yn,"+
					 "        legal_yn"+
					 " FROM   oa_appt a"+
					 " WHERE  facility_id = '"+ Facility +"'"+
					 "        AND appt_status = '1'";*/
					 /*Below Query modified for this CRF [RUT-CRF-0011]*/
					 
					 sql = "SELECT facility_id,"+
					 "        appt_ref_no,"+
					 "        clinic_code,"+
					 "        practitioner_id,"+
					 "        name_prefix,"+
					 "        first_name,"+
					 "        second_name,"+
					 "        third_name,"+
					 "        family_name,"+
					 "        name_suffix,"+
					 "        patient_name,"+
					 "        patient_long_name,"+
					 "        patient_long_name_loc_lang,"+
					 "        name_prefix_loc_lang,"+
					 "        first_name_loc_lang,"+
					 "        second_name_loc_lang,"+
					 "        third_name_loc_lang,"+
					 "        family_name_loc_lang,"+
					 "        name_suffix_loc_lang,"+
					 "        patient_name_loc_lang,"+
					 "        national_id_no,"+
					 "        alt_id1_no,"+
					 "        alt_id2_no,"+
					 "        alt_id3_no,"+
					 "        alt_id4_no,"+
					 "        oth_alt_id_type,"+
					 "        oth_alt_id_no,"+
					 "        TO_CHAR(alt_id1_exp_date,'DD/MM/YYYY') alt_id1_exp_date,"+
					 "        TO_CHAR(alt_id2_exp_date,'DD/MM/YYYY') alt_id2_exp_date,"+
					 "        TO_CHAR(alt_id3_exp_date,'DD/MM/YYYY') alt_id3_exp_date,"+
					 "        TO_CHAR(alt_id4_exp_date,'DD/MM/YYYY') alt_id4_exp_date,"+
					 "        TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),1) YEAR,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),2) months,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),3) days,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),4) hours,"+
					 "        gender,"+
					 "        birth_place_code,"+
					 "        mp_get_desc.MP_BIRTH_PLACE(a.birth_place_code,'"+locale+"',1) birth_place_desc,"+
					 "        birth_place_desc place_of_birth,"+
					 "        country_code nationality_code,"+
					 "        mp_get_desc.MP_COUNTRY(a.country_code,'"+locale+"',1) nationality_desc,"+
					 "        race_code,"+
					 "        ethnic_group_code,"+
					 "        res_addr_line1,"+
					 "        res_addr_line2,"+
					 "        res_addr_line3,"+
					 "        res_addr_line4,"+
					 "        res_area_code,"+
					 "        mp_get_desc.MP_RES_AREA(a.res_area_code,'"+locale+"',1) res_area_desc,"+
					 "        res_town_code,"+
					 "        mp_get_desc.MP_RES_TOWN(a.res_town_code,'"+locale+"',1) res_town_desc,"+
					 "        res_region_code,"+
					 "        mp_get_desc.MP_REGION(a.res_region_code,'"+locale+"',1) res_region_desc,"+
					 "        postal_code,"+
					 "        res_country_code,"+
					 "        mp_get_desc.MP_COUNTRY(a.res_country_code,'"+locale+"',1) res_country_desc,"+
					 "        mp_get_desc.MP_POSTAL_CODE(a.POSTAL_CODE,'"+locale+"',2) postal_desc,"+
					 "        mail_addr_line1,"+
					 "        mail_addr_line2,"+
					 "        mail_addr_line3,"+
					 "        mail_addr_line4,"+
					 "        mail_town_code,"+
					 "        mail_area_code,"+
					 "        mp_get_desc.MP_RES_AREA(a.mail_area_code,'"+locale+"',1) mail_area_desc,"+
					 "        mp_get_desc.MP_RES_TOWN(a.mail_town_code,'"+locale+"',1) mail_town_desc,"+
					 "        mail_region_code,"+
					 "        mp_get_desc.MP_REGION(a.mail_region_code,'"+locale+"',1) mail_region_desc,"+
					 "        mail_postal_code,"+
					 "        mail_country_code,"+
					 "        mp_get_desc.MP_COUNTRY(a.mail_country_code,'"+locale+"',1) mail_country_desc,"+
					 "         mp_get_desc.MP_POSTAL_CODE(a.MAIL_POSTAL_CODE,'"+locale+"',2) mail_postal_desc,"+
					/*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/
					 "        a.alt_addr_line1,"+
					 "        a.alt_addr_line2,"+
					 "        a.alt_addr_line3,"+
					 "        a.alt_addr_line4,"+
					 "        a.alt_town_code,"+
					 "        a.alt_area_code,"+
					 "        mp_get_desc.MP_RES_AREA(a.alt_area_code,'"+locale+"',1) alt_area_desc,"+
					 "        mp_get_desc.MP_RES_TOWN(a.alt_town_code,'"+locale+"',1) alt_town_desc,"+
					 "        a.alt_region_code,"+
					 "        mp_get_desc.MP_REGION(a.alt_region_code,'"+locale+"',1) alt_region_desc,"+
					 "        a.alt_postal_code,"+
					 "        a.alt_country_code,"+
					 "        mp_get_desc.MP_COUNTRY(a.alt_country_code,'"+locale+"',1) alt_country_desc,"+
					 "         mp_get_desc.MP_POSTAL_CODE(a.alt_postal_code,'"+locale+"',2) alt_postal_desc,"+
					/*End*/
					 "        a.patient_cat_code,mp_get_desc.MP_PAT_CATEGORY(a.patient_cat_code,'"+locale+"',2) pat_cat_desc,"+					 
					 "        a.language_id,mp_get_desc.MP_LANGUAGE(a.language_id,'"+locale+"',1) language_desc,"+					 
					 "        res_tel_no,"+
					 "        oth_contact_no,"+
					 "        email_id,"+
					 "        referral_id,"+
					 "        contact_reason_code,"+
					 "        mode_of_contact,"+
					 "        citizen_yn,"+
					 "        legal_yn"+
					 " FROM   oa_appt a"+
					 " WHERE  facility_id = '"+ Facility +"'"+
					 "        AND appt_status = '1'";
					 

		   if(refrlAappt.equals("A"))
		   {
			   sql = sql + " AND appt_ref_no = '"+ refIDValue +"' ";
		   }
		   else
		   {
			  sql = sql + " AND appt_ref_no = '"+ appt_ref_no +"' ";
		   }

		   if(oth_rset!=null) oth_rset.close();
		   if(oth_stmt!=null) oth_stmt.close();
		   oth_stmt = con.prepareStatement(sql);
		   oth_rset = oth_stmt.executeQuery();		
			
		}//end of if for OA...
		else if(!booking_ref_no.equals("") || refrlAappt.equals("I"))         
		{	 
			if(!q_booking_type.equals("D") || refrlAappt.equals("I"))
			{	
				sql = "SELECT name_prefix,"+
						 "        first_name,"+
						 "        second_name,"+
						 "        third_name,"+
						 "        family_name,"+
						 "        name_suffix,"+
						 "        patient_name,"+
						 "        patient_long_name,"+
						 "        patient_long_name_loc_lang,"+
						 "        name_prefix_loc_lang,"+
						 "        first_name_loc_lang,"+
						 "        second_name_loc_lang,"+
						 "        third_name_loc_lang,"+
						 "        family_name_loc_lang,"+
						 "        name_suffix_loc_lang,"+
						 "        patient_name_loc_lang,"+
						 "        national_id_no,"+
						 "        alt_id1_no,"+
						 "        alt_id2_no,"+
						 "        alt_id3_no,"+
						 "        alt_id4_no,"+
						 "        oth_alt_id_type,"+
						 "        oth_alt_id_no,"+
						 "        TO_CHAR(alt_id1_exp_date,'DD/MM/YYYY') alt_id1_exp_date,"+
						 "        TO_CHAR(alt_id2_exp_date,'DD/MM/YYYY') alt_id2_exp_date,"+
						 "        TO_CHAR(alt_id3_exp_date,'DD/MM/YYYY') alt_id3_exp_date,"+
						 "        TO_CHAR(alt_id4_exp_date,'DD/MM/YYYY') alt_id4_exp_date,"+
						 "        TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),1) YEAR,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),2) months,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),3) days,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),4) hours,"+
						 "        gender,"+
						 "        birth_place_code,"+
						 "        mp_get_desc.MP_BIRTH_PLACE(a.birth_place_code,'"+locale+"',1) birth_place_desc,"+
						 "        birth_place_desc place_of_birth,"+
						 "        mp_get_desc.MP_COUNTRY(a.country_code,'"+locale+"',1) nationality_desc,"+
						 "        nationality_code,"+
						 "        ethnic_grp_code ethnic_group_code,"+
						 "        race_code,"+
						 "        res_addr_line1,"+
						 "        res_addr_line2,"+
						 "        res_addr_line3,"+
						 "        res_addr_line4,"+
						 "        res_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.res_area_code,'"+locale+"',1) res_area_desc,"+
						 "        res_town_code,"+
						 "        mp_get_desc.MP_RES_TOWN(a.res_town_code,'"+locale+"',1) res_town_desc,"+
						 "        res_region_code,"+
						 "        mp_get_desc.MP_REGION(a.res_region_code,'"+locale+"',1) res_region_desc,"+
						 "        postal_code,"+
						 "        country_code res_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.country_code,'"+locale+"',1) res_country_desc,"+
						 "        res_tel_no,"+
						 "        oth_contact_no,"+
						 "        email_id,"+
						 "        mail_addr_line1,"+
						 "        mail_addr_line2,"+
						 "        mail_addr_line3,"+
						 "        mail_addr_line4,"+
						 "        mail_town_code,"+
						 "        mp_get_desc.MP_RES_TOWN(a.mail_town_code,'"+locale+"',1) mail_town_desc,"+
						 "        mail_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.mail_area_code,'"+locale+"',1) mail_area_desc,"+
						 "        mail_region_code,"+
						 "        mp_get_desc.MP_REGION(a.mail_region_code,'"+locale+"',1) mail_region_desc,"+
						 "        mail_postal_code,"+
						 "        mail_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.mail_country_code,'"+locale+"',1) mail_country_desc,"+
						/*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/
						 "        mp_get_desc.MP_POSTAL_CODE(a.MAIL_POSTAL_CODE,'"+locale+"',2) mail_postal_desc,"+
					     "        mp_get_desc.MP_POSTAL_CODE(a.POSTAL_CODE,'"+locale+"',2) postal_desc,"+
						 "        a.alt_addr_line1,"+
						 "        a.alt_addr_line2,"+
						 "        a.alt_addr_line3,"+
						 "        a.alt_addr_line4,"+
						 "        a.alt_town_code,"+
						 "        a.alt_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.alt_area_code,'"+locale+"',1) alt_area_desc,"+
						 "        mp_get_desc.MP_RES_TOWN(a.alt_town_code,'"+locale+"',1) alt_town_desc,"+
						 "        a.alt_region_code,"+
						 "        mp_get_desc.MP_REGION(a.alt_region_code,'"+locale+"',1) alt_region_desc,"+
						 "        a.alt_postal_code,"+
						 "        a.alt_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.alt_country_code,'"+locale+"',1) alt_country_desc,"+
						 "         mp_get_desc.MP_POSTAL_CODE(a.alt_postal_code,'"+locale+"',2) alt_postal_desc,"+
						/*End*/
						 "        referral_id,"+
						 "        mode_of_contact,"+
						 "        citizen_yn,"+
						 "        legal_illegal_yn legal_yn"+
						 " FROM   ip_booking_list a"+
						 " WHERE  facility_id = '"+ Facility +"'" ;

				if(refrlAappt.equals("I"))
				{
					sql = sql + " AND bkg_lst_ref_no = '"+ refIDValue +"' " ;
				}
				else sql = sql +" AND bkg_lst_ref_no = '"+booking_ref_no+"'";
			}//end of if for Daycare
			else
			{
				sql = "SELECT name_prefix,"+
						 "        first_name,"+
						 "        second_name,"+
						 "        third_name,"+
						 "        family_name,"+
						 "        name_suffix,"+
						 "        patient_name,"+
						 "        patient_long_name,"+
						 "        patient_long_name_loc_lang,"+
						 "        name_prefix_loc_lang,"+
						 "        first_name_loc_lang,"+
						 "        second_name_loc_lang,"+
						 "        third_name_loc_lang,"+
						 "        family_name_loc_lang,"+
						 "        name_suffix_loc_lang,"+
						 "        patient_name_loc_lang,"+
						 "        national_id_no,"+
						 "        alt_id1_no,"+
						 "        alt_id2_no,"+
						 "        alt_id3_no,"+
						 "        alt_id4_no,"+
						 "        oth_alt_id_type,"+
						 "        oth_alt_id_no,"+
						 "        TO_CHAR(alt_id1_exp_date,'DD/MM/YYYY') alt_id1_exp_date,"+
						 "        TO_CHAR(alt_id2_exp_date,'DD/MM/YYYY') alt_id2_exp_date,"+
						 "        TO_CHAR(alt_id3_exp_date,'DD/MM/YYYY') alt_id3_exp_date,"+
						 "        TO_CHAR(alt_id4_exp_date,'DD/MM/YYYY') alt_id4_exp_date,"+
						 "        TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),1) YEAR,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),2) months,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),3) days,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),4) hours,"+
						 "        gender,"+
						 "        birth_place_code,"+
						 "        mp_get_desc.MP_BIRTH_PLACE(a.birth_place_code,'"+locale+"',1) birth_place_desc,"+
						 "        birth_place_desc place_of_birth,"+
						 "        mp_get_desc.MP_COUNTRY(a.country_code,'"+locale+"',1) nationality_desc,"+
						 "        country_code nationality_code,"+
						 "        ethnic_group_code,"+
						 "        race_code,"+
						 "        res_addr_line1,"+
						 "        res_addr_line2,"+
						 "        res_addr_line3,"+
						 "        res_addr_line4,"+
						 "        res_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.res_area_code,'"+locale+"',1) res_area_desc,"+
						 "        res_town_code,"+
						 "        mp_get_desc.MP_RES_TOWN(a.res_town_code,'"+locale+"',1) res_town_desc,"+
						 "        res_region_code,"+
						 "        mp_get_desc.MP_REGION(a.res_region_code,'"+locale+"',1) res_region_desc,"+
						 "        postal_code,"+
						 "        country_code res_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.res_country_code,'"+locale+"',1) res_country_desc,"+
						 "        mp_get_desc.MP_POSTAL_CODE(a.POSTAL_CODE,'"+locale+"',2) postal_desc,"+
						 "        res_tel_no,"+
						 "        oth_contact_no,"+
						 "        email_id,"+
						 "        mail_addr_line1,"+
						 "        mail_addr_line2,"+
						 "        mail_addr_line3,"+
						 "        mail_addr_line4,"+
						 "        mail_town_code,"+
						 "        mp_get_desc.MP_RES_TOWN(a.mail_town_code,'"+locale+"',1) mail_town_desc,"+
						 "        mail_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.mail_area_code,'"+locale+"',1) mail_area_desc,"+
						 "        mail_region_code,"+
						 "        mp_get_desc.MP_REGION(a.mail_region_code,'"+locale+"',1) mail_region_desc,"+
						 "        mp_get_desc.MP_POSTAL_CODE(a.MAIL_POSTAL_CODE,'"+locale+"',2) mail_postal_desc,"+
						 "        mail_postal_code,"+
						 "        mail_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.mail_country_code,'"+locale+"',1) mail_country_desc,"+
						/*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/
						 "        a.alt_addr_line1,"+
						 "        a.alt_addr_line2,"+
						 "        a.alt_addr_line3,"+
						 "        a.alt_addr_line4,"+
						 "        a.alt_town_code,"+
						 "        a.alt_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.alt_area_code,'"+locale+"',1) alt_area_desc,"+
						 "        mp_get_desc.MP_RES_TOWN(a.alt_town_code,'"+locale+"',1) alt_town_desc,"+
						 "        a.alt_region_code,"+
						 "        mp_get_desc.MP_REGION(a.alt_region_code,'"+locale+"',1) alt_region_desc,"+
						 "        a.alt_postal_code,"+
						 "        a.alt_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.alt_country_code,'"+locale+"',1) alt_country_desc,"+
						 "         mp_get_desc.MP_POSTAL_CODE(a.alt_postal_code,'"+locale+"',2) alt_postal_desc,"+
						/*End*/
						 "        referral_id,"+
						 "        mode_of_contact,"+
						 "        citizen_yn,"+
						 "        legal_yn"+
						 " FROM   oa_appt a"+
						 " WHERE  facility_id = '"+ Facility +"'"+
						 "        AND appt_ref_no = '"+booking_ref_no+"'";

						/*appt_ref_no		= booking_ref_no;
						booking_ref_no	= "";*/

			}//end of if for IP

			if(oth_rset!=null) oth_rset.close();
			if(oth_stmt!=null) oth_stmt.close();
			oth_stmt = con.prepareStatement(sql);					
			oth_rset = oth_stmt.executeQuery();	
		}
		//Query to populate the values from Ref-search
		else if(func_act.equals("REF_SEARCH") || refrlAappt.equals("L"))
		{	
			
			sql = "SELECT name_prefix,"+
						 "        first_name,"+
						 "        second_name,"+
						 "        third_name,"+
						 "        family_name,"+
						 "        name_suffix,"+
						 "        patient_name,"+
						 "        patient_long_name,"+
						 "        patient_long_name_loc_lang,"+
						 "        name_prefix_loc_lang,"+
						 "        first_name_loc_lang,"+
						 "        second_name_loc_lang,"+
						 "        third_name_loc_lang,"+
						 "        family_name_loc_lang,"+
						 "        name_suffix_loc_lang,"+
						 "        patient_name_loc_lang,"+
						 "        national_id_no,"+
						 "        alt_id1_no,"+
						 "        alt_id2_no,"+
						 "        alt_id3_no,"+
						 "        alt_id4_no,"+
						 "        oth_alt_id_type,"+
						 "        oth_alt_id_no,"+
						 "        TO_CHAR(alt_id1_date,'DD/MM/YYYY') alt_id1_exp_date,"+
						 "        TO_CHAR(alt_id2_date,'DD/MM/YYYY') alt_id2_exp_date,"+
						 "        TO_CHAR(alt_id3_date,'DD/MM/YYYY') alt_id3_exp_date,"+
						 "        TO_CHAR(alt_id4_date,'DD/MM/YYYY') alt_id4_exp_date,"+
						 "        TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),1) YEAR,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),2) months,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),3) days,"+
						 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),4) hours,"+
						 "        sex gender,"+
						 "        birth_place_code,"+
						 "        mp_get_desc.MP_BIRTH_PLACE(a.birth_place_code,'"+locale+"',1) birth_place_desc,"+
						 "        birth_place_desc place_of_birth,"+
						 "        mp_get_desc.MP_COUNTRY(a.country_code,'"+locale+"',1) nationality_desc,"+
						 "        nationality_code,"+
						 "        race_code,"+
						 "        ethnic_grp_code ethnic_group_code,"+
						 "        addr_line1 res_addr_line1,"+
						 "        addr_line2 res_addr_line2,"+
						 "        addr_line3 res_addr_line3,"+
						 "        addr_line4 res_addr_line4,"+
						 "        res_town_code,"+
						 "        mp_get_desc.MP_RES_TOWN(a.res_town_code,'"+locale+"',1) res_town_desc,"+
						 "        res_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.res_area_code,'"+locale+"',1) res_area_desc,"+
						 "        region_code res_region_code,"+
						 "        mp_get_desc.MP_REGION(a.region_code,'"+locale+"',1) res_region_desc,"+
						 "        mp_get_desc.MP_POSTAL_CODE(a.postal_code,'"+locale+"',2) postal_desc,"+
						 "        postal_code,"+
						 "        country_code res_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.country_code,'"+locale+"',1) res_country_desc,"+
						 "        mail_addr_line1,"+
						 "        mail_addr_line2,"+
						 "        mail_addr_line3,"+
						 "        mail_addr_line4,"+
						 "        mail_res_town_code mail_town_code,"+
						 "        mp_get_desc.MP_RES_TOWN(a.mail_res_town_code,'"+locale+"',1) mail_town_desc,"+
						 "        mail_res_area_code mail_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.mail_res_area_code,'"+locale+"',1) mail_area_desc,"+
						 "        mail_region_code,"+
						 "        mp_get_desc.MP_REGION(a.mail_region_code,'"+locale+"',1) mail_region_desc,"+
						 "        mp_get_desc.MP_POSTAL_CODE(a.mail_postal_code,'"+locale+"',2) mail_postal_desc,"+
						 "        mail_postal_code,"+
						 "        mail_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.mail_country_code,'"+locale+"',1) mail_country_desc,"+
						/*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/
						 "        a.alt_addr_line1,"+
						 "        a.alt_addr_line2,"+
						 "        a.alt_addr_line3,"+
						 "        a.alt_addr_line4,"+
						 "        a.alt_town_code,"+
						 "        a.alt_area_code,"+
						 "        mp_get_desc.MP_RES_AREA(a.alt_area_code,'"+locale+"',1) alt_area_desc,"+
						 "        mp_get_desc.MP_RES_TOWN(a.alt_town_code,'"+locale+"',1) alt_town_desc,"+
						 "        a.alt_region_code,"+
						 "        mp_get_desc.MP_REGION(a.alt_region_code,'"+locale+"',1) alt_region_desc,"+
						 "        a.alt_postal_code,"+
						 "        a.alt_country_code,"+
						 "        mp_get_desc.MP_COUNTRY(a.alt_country_code,'"+locale+"',1) alt_country_desc,"+
						 "         mp_get_desc.MP_POSTAL_CODE(a.alt_postal_code,'"+locale+"',2) alt_postal_desc,"+
						/*End*/
						 "        contact1_no res_tel_no,"+
						 "        contact2_no oth_contact_no,"+
						 "        email_id,"+
						 "        referral_id,"+
						 "        citizen_yn,"+
						 "        legal_illegal_yn legal_yn"+
						 " FROM   pr_referral_register a"+
						 " WHERE " ;
			if(refrlAappt.equals("L"))
			{
				sql = sql + " referral_id = '"+ refIDValue +"' " ;
			}
			else sql = sql + " referral_id = '"+ referral_id +"' " ;
			if(oth_rset!=null) oth_rset.close();
			if(oth_stmt!=null) oth_stmt.close();
			oth_stmt = con.prepareStatement(sql);
			oth_rset = oth_stmt.executeQuery();							
		}
		else if(refrlAappt.equals("R"))
		{	
			sql = "SELECT first_name,"+
					 "        second_name,"+
					 "        third_name,"+
					 "        name_suffix,"+
					 "        title_code name_prefix,"+
					 "        short_name patient_name,"+
					 "        last_name family_name,"+
					 "        national_id_num national_id_no,"+
					 "        TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),1) YEAR,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),2) months,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),3) days,"+
					 "        CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),4) hours,"+
					 "        sex gender,"+
					 "        appt_ref_num referral_id,"+
					 "        res_telephone_num res_tel_no,"+
					 "        other_contact_num oth_contact_no,"+
					 "        ln1_res_add res_addr_line1,"+
					 "        ln2_res_add res_addr_line2,"+
					 "        ln3_res_add res_addr_line3,"+
					 "        ln4_res_add res_addr_line4"+
					 " FROM   rd_appt"+
					 " WHERE  appt_ref_num = '"+refIDValue+"'";
		
			oth_stmt = con.prepareStatement(sql);
			oth_rset = oth_stmt.executeQuery();		
		}			
		if(oth_rset!=null && oth_rset.next())
		{
			
			if(refrlAappt.equals("P"))
			{
				a_res_addr_line1			= 	checkForNull( oth_rset.getString("res_addr_line1") );
				a_res_addr_line2			= 	checkForNull( oth_rset.getString("res_addr_line2") );
				a_res_addr_line3			= 	checkForNull( oth_rset.getString("res_addr_line3") );
				a_res_addr_line4			= 	checkForNull( oth_rset.getString("res_addr_line4") );
				a_res_town_code			= 	checkForNull( oth_rset.getString("res_town_code") );
				a_res_town_desc			= 	checkForNull( oth_rset.getString("res_town_desc") );
				a_res_area_code			= 	checkForNull( oth_rset.getString("res_area_code") );
				a_res_area_desc			= 	checkForNull( oth_rset.getString("res_area_desc") );
				a_res_region_code		= 	checkForNull( oth_rset.getString("res_region_code") );
				a_res_region_desc			= 	checkForNull( oth_rset.getString("res_region_desc") );
				a_country_code			= 	checkForNull( oth_rset.getString("res_country_code") );
				a_res_country_desc		= 	checkForNull( oth_rset.getString("res_country_desc") );
				a_postal_code				= 	checkForNull( oth_rset.getString("postal_code") );
				a_mail_addr_line1			= 	checkForNull( oth_rset.getString("mail_addr_line1") );
				a_mail_addr_line2			= 	checkForNull( oth_rset.getString("mail_addr_line2") );
				a_mail_addr_line3			= 	checkForNull( oth_rset.getString("mail_addr_line3") );
				a_mail_addr_line4			= 	checkForNull( oth_rset.getString("mail_addr_line4") );
				a_mail_town_code			= 	checkForNull( oth_rset.getString("mail_town_code") );
				a_mail_town_desc			= 	checkForNull( oth_rset.getString("mail_town_desc") );
				a_mail_area_code			= 	checkForNull( oth_rset.getString("mail_area_code") );
				a_mail_area_desc			= 	checkForNull( oth_rset.getString("mail_area_desc") );
				a_mail_country_code		= 	checkForNull( oth_rset.getString("mail_country_code") );
				a_mail_country_desc		= 	checkForNull( oth_rset.getString("mail_country_desc") );
				a_mail_postal_code		= 	checkForNull( oth_rset.getString("mail_postal_code") );
				a_mail_region_code		= 	checkForNull( oth_rset.getString("mail_region_code") );
				a_mail_region_desc		= 	checkForNull( oth_rset.getString("mail_region_desc") );
				a_res_tel_no				= 	checkForNull( oth_rset.getString("res_tel_no") );
				a_patient_name		=	checkForNull( oth_rset.getString("patient_name") );
				a_patient_long_name		=	checkForNull( oth_rset.getString("patient_long_name") );
				a_patient_long_name_loc_lang		=	checkForNull( oth_rset.getString("patient_long_name_loc_lang") );
				res_contact_name	=	checkForNull( oth_rset.getString("res_contact_name") );
				mail_contact_name	=	checkForNull( oth_rset.getString("mail_contact_name") );
				a_postal_desc	=	checkForNull( oth_rset.getString("postal_desc") );
				a_mail_postal_desc	=	checkForNull( oth_rset.getString("mail_postal_desc") );
				/*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/
				alt_addr_line1			= 	checkForNull( oth_rset.getString("alt_addr_line1") );
				alt_addr_line2			= 	checkForNull( oth_rset.getString("alt_addr_line2") );
				alt_addr_line3			= 	checkForNull( oth_rset.getString("alt_addr_line3") );
				alt_addr_line4			= 	checkForNull( oth_rset.getString("alt_addr_line4") );
				alt_town_code			= 	checkForNull( oth_rset.getString("alt_town_code") );
				alt_town_desc			= 	checkForNull( oth_rset.getString("alt_town_desc") );
				alt_area_code			= 	checkForNull( oth_rset.getString("alt_area_code") );
				alt_area_desc			= 	checkForNull( oth_rset.getString("alt_area_desc") );
				alt_country_code		= 	checkForNull( oth_rset.getString("alt_country_code") );
				alt_country_desc		= 	checkForNull( oth_rset.getString("alt_country_desc") );
				alt_region_code			= 	checkForNull( oth_rset.getString("alt_region_code") );
				alt_region_desc			= 	checkForNull( oth_rset.getString("alt_region_desc") );
				alt_postal_code			= 	checkForNull( oth_rset.getString("alt_postal_code") );
				alt_postal_desc			= 	checkForNull( oth_rset.getString("alt_postal_desc") );
				/*End*/

			}
			else
			{
			a_gender					= 	checkForNull( oth_rset.getString("gender") );
			a_date_of_birth				= 	checkForNull( oth_rset.getString("date_of_birth") );
			if (!a_date_of_birth.equals(""))
			{
				if(!locale.equals("en"))
				{ 	
					a_date_of_birth= DateUtils.convertDate(a_date_of_birth,"DMY","en",locale);
				}
			}
			a_national_id_no			= 	checkForNull( oth_rset.getString("national_id_no") );
			year							= 	checkForNull( oth_rset.getString("YEAR") );
			months						= 	checkForNull( oth_rset.getString("MONTHS") );
			days							= 	checkForNull( oth_rset.getString("DAYS") );
			hours							= 	checkForNull( oth_rset.getString("hours") );
			a_res_tel_no				= 	checkForNull( oth_rset.getString("res_tel_no") );
			a_oth_contact_no			= 	checkForNull( oth_rset.getString("oth_contact_no") );
			a_res_addr_line1			= 	checkForNull( oth_rset.getString("res_addr_line1") );
			a_res_addr_line2			= 	checkForNull( oth_rset.getString("res_addr_line2") );
			a_res_addr_line3			= 	checkForNull( oth_rset.getString("res_addr_line3") );
			a_res_addr_line4			= 	checkForNull( oth_rset.getString("res_addr_line4") );

			

			if(!func_act.equals("DuplicateRegistration"))
			{
				
				a_name_prefix			=	checkForNull( oth_rset.getString("name_prefix") );
				a_family_name			=	checkForNull( oth_rset.getString("family_name") );
				a_patient_name		=	checkForNull( oth_rset.getString("patient_name") );
				a_patient_long_name		=	checkForNull( oth_rset.getString("patient_long_name") );
				a_patient_long_name_loc_lang		=	checkForNull( oth_rset.getString("patient_long_name_loc_lang") );
				a_first_name			=	checkForNull( oth_rset.getString("first_name") );
				a_second_name		=	checkForNull( oth_rset.getString("second_name") );
				a_third_name			=	checkForNull( oth_rset.getString("third_name") );
				a_name_suffix			=	checkForNull( oth_rset.getString("name_suffix") );
				a_name_prefix_loc_lang			=	checkForNull( oth_rset.getString("name_prefix_loc_lang") );
				a_first_name_loc_lang				=	checkForNull( oth_rset.getString("first_name_loc_lang") );
				a_second_name_loc_lang		=	checkForNull( oth_rset.getString("second_name_loc_lang") );
				a_third_name_loc_lang			=	checkForNull( oth_rset.getString("third_name_loc_lang") );
				a_family_name_loc_lang			=	checkForNull( oth_rset.getString("family_name_loc_lang") );
				a_name_suffix_loc_lang			=	checkForNull( oth_rset.getString("name_suffix_loc_lang") );
				a_patient_name_loc_lang			=	checkForNull( oth_rset.getString("patient_name_loc_lang") );

				referral_id				=  checkForNull( oth_rset.getString("referral_id") );
				

			if (appt.equals("Appt") || refrlAappt.equals("A")){
				/*Below Code Added For this CRF [RUT-CRF-0011]*/					
					patient_cat_code=  checkForNull( oth_rset.getString("patient_cat_code") );
					patient_cat_desc=  checkForNull( oth_rset.getString("pat_cat_desc") );
					language_id=  checkForNull( oth_rset.getString("language_id") );
					language_desc=  checkForNull( oth_rset.getString("language_desc") );						
				}

				if(!refrlAappt.equals("R"))
				{
					a_nationality_code = checkForNull( oth_rset.getString("nationality_code") );
				}
				
			}

			if(!refrlAappt.equals("R"))
			{

				a_email_id					= 	checkForNull( oth_rset.getString("email_id") );
				a_alt_id1_no					= 	checkForNull( oth_rset.getString("alt_id1_no") );
				a_alt_id2_no					= 	checkForNull( oth_rset.getString("alt_id2_no") );
				a_alt_id3_no					= 	checkForNull( oth_rset.getString("alt_id3_no") );
				a_alt_id4_no					= 	checkForNull( oth_rset.getString("alt_id4_no") );
				a_oth_alt_id_type			= 	checkForNull( oth_rset.getString("oth_alt_id_type") );
				a_oth_alt_id_no				= 	checkForNull( oth_rset.getString("oth_alt_id_no") );
				a_alt_id1_exp_date			= 	checkForNull( oth_rset.getString("alt_id1_exp_date") );
				a_alt_id2_exp_date			= 	checkForNull( oth_rset.getString("alt_id2_exp_date") );
				a_alt_id3_exp_date			= 	checkForNull( oth_rset.getString("alt_id3_exp_date") );
				a_alt_id4_exp_date			= 	checkForNull( oth_rset.getString("alt_id4_exp_date") );
				if ( !locale.equals("en") )
				{ 
					if (!a_alt_id1_exp_date.equals(""))
							a_alt_id1_exp_date= DateUtils.convertDate(a_alt_id1_exp_date,"DMY","en",locale);
					if (!a_alt_id2_exp_date.equals(""))
							a_alt_id2_exp_date= DateUtils.convertDate(a_alt_id2_exp_date,"DMY","en",locale);
					if (!a_alt_id3_exp_date.equals(""))
							a_alt_id3_exp_date= DateUtils.convertDate(a_alt_id3_exp_date,"DMY","en",locale);
					if (!a_alt_id4_exp_date.equals(""))
							a_alt_id4_exp_date= DateUtils.convertDate(a_alt_id4_exp_date,"DMY","en",locale);
				}
				a_race_code				= 	checkForNull( oth_rset.getString("race_code") );
				a_ethnic_group_code		= 	checkForNull( oth_rset.getString("ethnic_group_code") );
				a_postal_code				= 	checkForNull( oth_rset.getString("postal_code") );
				a_country_code			= 	checkForNull( oth_rset.getString("res_country_code") );
				a_res_country_desc		= 	checkForNull( oth_rset.getString("res_country_desc") );
				a_res_town_code			= 	checkForNull( oth_rset.getString("res_town_code") );
				a_res_town_desc			= 	checkForNull( oth_rset.getString("res_town_desc") );
				a_res_region_code		= 	checkForNull( oth_rset.getString("res_region_code") );
				a_res_region_desc			= 	checkForNull( oth_rset.getString("res_region_desc") );
				a_res_area_code			= 	checkForNull( oth_rset.getString("res_area_code") );
				a_res_area_desc			= 	checkForNull( oth_rset.getString("res_area_desc") );
				a_mail_country_desc		= 	checkForNull( oth_rset.getString("mail_country_desc") );
				a_mail_addr_line1			= 	checkForNull( oth_rset.getString("mail_addr_line1") );
				a_mail_addr_line2			= 	checkForNull( oth_rset.getString("mail_addr_line2") );
				a_mail_addr_line3			= 	checkForNull( oth_rset.getString("mail_addr_line3") );
				a_mail_addr_line4			= 	checkForNull( oth_rset.getString("mail_addr_line4") );
				a_mail_town_code			= 	checkForNull( oth_rset.getString("mail_town_code") );
				a_mail_area_code			= 	checkForNull( oth_rset.getString("mail_area_code") );
				a_mail_country_code		= 	checkForNull( oth_rset.getString("mail_country_code") );
				a_mail_postal_code		= 	checkForNull( oth_rset.getString("mail_postal_code") );
				a_mail_region_code		= 	checkForNull( oth_rset.getString("mail_region_code") );
				a_mail_area_desc			= 	checkForNull( oth_rset.getString("mail_area_desc") );
				a_mail_town_desc			= 	checkForNull( oth_rset.getString("mail_town_desc") );
				a_mail_region_desc		= 	checkForNull( oth_rset.getString("mail_region_desc") );
				a_birth_place_code		= 	checkForNull( oth_rset.getString("birth_place_code") );
				a_birth_place_desc		= 	checkForNull( oth_rset.getString("birth_place_desc") );
				a_place_of_birth			= 	checkForNull( oth_rset.getString("place_of_birth") );
				a_legal_yn					= 	checkForNull( oth_rset.getString("legal_yn") );
				a_citizen_yn					= 	checkForNull( oth_rset.getString("citizen_yn") );
				a_mail_postal_desc	=	checkForNull( oth_rset.getString("mail_postal_desc") );
				a_postal_desc	=	checkForNull( oth_rset.getString("postal_desc") );
				/*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/
				alt_addr_line1			= 	checkForNull( oth_rset.getString("alt_addr_line1") );
				alt_addr_line2			= 	checkForNull( oth_rset.getString("alt_addr_line2") );
				alt_addr_line3			= 	checkForNull( oth_rset.getString("alt_addr_line3") );
				alt_addr_line4			= 	checkForNull( oth_rset.getString("alt_addr_line4") );
				alt_town_code			= 	checkForNull( oth_rset.getString("alt_town_code") );
				alt_town_desc			= 	checkForNull( oth_rset.getString("alt_town_desc") );
				alt_area_code			= 	checkForNull( oth_rset.getString("alt_area_code") );
				alt_area_desc			= 	checkForNull( oth_rset.getString("alt_area_desc") );
				alt_country_code		= 	checkForNull( oth_rset.getString("alt_country_code") );
				alt_country_desc		= 	checkForNull( oth_rset.getString("alt_country_desc") );
				alt_region_code			= 	checkForNull( oth_rset.getString("alt_region_code") );
				alt_region_desc			= 	checkForNull( oth_rset.getString("alt_region_desc") );
				alt_postal_code			= 	checkForNull( oth_rset.getString("alt_postal_code") );
				alt_postal_desc			= 	checkForNull( oth_rset.getString("alt_postal_desc") );
				/*End*/
				
			}

			if(func_act.equals("DuplicateRegistration")) {

				if(!refrlAappt.equals("R")) {
					relgn_code						= 	checkForNull( oth_rset.getString("relgn_code") );
					contact3_mode				= 	checkForNull( oth_rset.getString("contact3_mode") );
					contact3_no					= 	checkForNull( oth_rset.getString("contact3_no") );
					contact4_mode				= 	checkForNull( oth_rset.getString("contact4_mode") );
					contact4_no					= 	checkForNull( oth_rset.getString("contact4_no") );
					contact5_mode				= 	checkForNull( oth_rset.getString("contact5_mode") );
					contact5_no					= 	checkForNull( oth_rset.getString("contact5_no") );
					nkin_contact_name			= 	checkForNull( oth_rset.getString("nkin_contact_name") );
					nkin_contact_relation		= 	checkForNull( oth_rset.getString("nkin_contact_relation") );
					contact1_nat_id_no			=	checkForNull( oth_rset.getString("contact1_nat_id_no") );
					contact1_alt_id1_no			=	checkForNull( oth_rset.getString("contact1_alt_id1_no") );
					contact1_alt_id2_no			=	checkForNull( oth_rset.getString("contact1_alt_id2_no") );
					contact1_alt_id3_no			=	checkForNull( oth_rset.getString("contact1_alt_id3_no") );
					contact1_alt_id4_no			=	checkForNull( oth_rset.getString("contact1_alt_id4_no") );
					contact1_oth_alt_id_type	=	checkForNull( oth_rset.getString("contact1_oth_alt_id_type") );
					nkin_oth_alt_id_no			=	checkForNull( oth_rset.getString("nkin_oth_alt_id_no") );
					contact1_birth_date			=	checkForNull( oth_rset.getString("contact1_birth_date") );

					if  ( !contact1_birth_date.equals("") ) 
					{
							if  ( !localeName.equals("en"))
							contact1_birth_date= DateUtils.convertDate(contact1_birth_date,"DMY","en",localeName);
					}
					nkin_job_title					= 	checkForNull( oth_rset.getString("nkin_job_title") );
					nkin_addr_line1				= 	checkForNull( oth_rset.getString("nkin_addr_line1") );
					nkin_addr_line2				= 	checkForNull( oth_rset.getString("nkin_addr_line2") );
					nkin_addr_line3				= 	checkForNull( oth_rset.getString("nkin_addr_line3") );
					nkin_addr_line4				= 	checkForNull( oth_rset.getString("nkin_addr_line4") );
					nkin_area_long_desc			= 	checkForNull( oth_rset.getString("nkin_area_long_desc") );
					nkin_region_long_desc		= 	checkForNull( oth_rset.getString("nkin_region_long_desc") );
					nkin_town_long_desc		= 	checkForNull( oth_rset.getString("nkin_town_long_desc") );
					nkin_postal_code				= 	checkForNull( oth_rset.getString("nkin_postal_code") );
					nkin_country_name			= 	checkForNull( oth_rset.getString("nkin_country_name") );
					nkin_res_tel_no				=	checkForNull( oth_rset.getString("nkin_res_tel_no") );
					nkin_mob_tel_no				= 	checkForNull( oth_rset.getString("nkin_mob_tel_no") );
					nkin_off_tel_no				=	checkForNull( oth_rset.getString("nkin_off_tel_no") );
					nkin_email_id					= 	checkForNull( oth_rset.getString("nkin_email_id") );
					fton_addr_line1				= 	checkForNull( oth_rset.getString("fton_addr_line1") );
					fton_addr_line2				= 	checkForNull( oth_rset.getString("fton_addr_line2") );
					fton_addr_line3				= 	checkForNull( oth_rset.getString("fton_addr_line3") );
					fton_addr_line4				= 	checkForNull( oth_rset.getString("fton_addr_line4") );
					fton_town_long_desc		=  checkForNull( oth_rset.getString("fton_town_long_desc") );
					fton_area_long_desc			=  checkForNull( oth_rset.getString("fton_area_long_desc") );
					fton_region_long_desc		= 	checkForNull( oth_rset.getString("fton_region_long_desc") );
					fton_postal_code				= 	checkForNull( oth_rset.getString("fton_postal_code") );
					fton_country_name			= 	checkForNull( oth_rset.getString("fton_country_name") );
					fton_contact_name			= 	checkForNull( oth_rset.getString("fton_contact_name") );
					fton_contact_relation		= 	checkForNull( oth_rset.getString("fton_contact_relation") );
					fton_alt_id_no					= 	checkForNull( oth_rset.getString("fton_alt_id_no") );
					fton_job_title					= 	checkForNull( oth_rset.getString("fton_job_title") );
					fton_res_tel_no				= 	checkForNull( oth_rset.getString("fton_res_tel_no") );
					fton_mob_tel_no				= 	checkForNull( oth_rset.getString("fton_mob_tel_no") );
					fton_email_id					= 	checkForNull( oth_rset.getString("fton_email_id") );
					fton_email_id					= 	checkForNull( oth_rset.getString("fton_email_id") );
					organization_name			=	checkForNull( oth_rset.getString("organization_name") );
					emplr_contact_name			= 	checkForNull( oth_rset.getString("emplr_contact_name") );
					emplr_addr_line1				= 	checkForNull( oth_rset.getString("emplr_addr_line1") );
					emplr_addr_line2				= 	checkForNull( oth_rset.getString("emplr_addr_line2") );
					emplr_addr_line3				= 	checkForNull( oth_rset.getString("emplr_addr_line3") );
					emplr_addr_line4				= 	checkForNull( oth_rset.getString("emplr_addr_line4") );
					emplr_town_long_desc		= 	checkForNull( oth_rset.getString("emplr_town_long_desc") );
					emplr_region_long_desc		= 	checkForNull( oth_rset.getString("emplr_region_long_desc") );
					emplr_area_long_desc		= 	checkForNull( oth_rset.getString("emplr_area_long_desc") );
					emplr_postal_code			= 	checkForNull( oth_rset.getString("emplr_postal_code") );
					emplr_country_name			= 	checkForNull( oth_rset.getString("emplr_country_name") );
					emplr_off_tel_no				=	checkForNull( oth_rset.getString("emplr_off_tel_no") );
					emplr_res_tel_no				=	checkForNull( oth_rset.getString("emplr_res_tel_no") );
					patient_employee_id			=	checkForNull( oth_rset.getString("patient_employee_id") );
					informant						=	checkForNull( oth_rset.getString("informant") );
					informant_remarks			=	checkForNull( oth_rset.getString("informant_remarks") );
					general_remarks				=	checkForNull( oth_rset.getString("general_remarks") );
				}

				/*
				doc_pstmt = con.prepareStatement("select DOC1_TYPE, nvl(DOC1_NUM,' ') DOC1_NUM, to_char(DOC1_EXP_DATE,'dd/mm/yyyy') DOC1_EXP_DATE, nvl(DOC1_PLACE_OF_ISSUE,'') DOC1_PLACE_OF_ISSUE, to_char(DOC1_ISS_DATE,'dd/mm/yyyy') DOC1_ISS_DATE, nvl(DOC2_TYPE,'') DOC2_TYPE, nvl(DOC2_NUM,'') DOC2_NUM, to_char(DOC2_EXP_DATE,'dd/mm/yyyy') DOC2_EXP_DATE, nvl(DOC2_PLACE_OF_ISSUE,'') DOC2_PLACE_OF_ISSUE, to_char(DOC2_ISS_DATE,'dd/mm/yyyy') DOC2_ISS_DATE, nvl(DOC3_TYPE,'') DOC3_TYPE, nvl(DOC3_NUM,'') DOC3_NUM, to_char(DOC3_EXP_DATE,'dd/mm/yyyy') DOC3_EXP_DATE, nvl(DOC3_PLACE_OF_ISSUE,'') DOC3_PLACE_OF_ISSUE, to_char(DOC3_ISS_DATE,'dd/mm/yyyy') DOC3_ISS_DATE, nvl(DOC4_TYPE,'') DOC4_TYPE, nvl(DOC4_NUM,'') DOC4_NUM, to_char(DOC4_EXP_DATE,'dd/mm/yyyy') DOC4_EXP_DATE, nvl(DOC4_PLACE_OF_ISSUE,'') DOC4_PLACE_OF_ISSUE, to_char(DOC4_ISS_DATE,'dd/mm/yyyy') DOC4_ISS_DATE FROM MP_PAT_DOCUMENTS where patient_id = '"+drfunctionid+"'");
				doc_rs = doc_pstmt.executeQuery();
				while(doc_rs.next()) {
					*/
					doc1_num					=  	checkForNull( oth_rset.getString("DOC1_NUM") );
					doc1_exp_date				=  	checkForNull( oth_rset.getString("DOC1_EXP_DATE") );
					doc1_place_of_issue		=  	checkForNull( oth_rset.getString("DOC1_PLACE_OF_ISSUE") );
					doc1_iss_date				=  	checkForNull( oth_rset.getString("DOC1_ISS_DATE") );
					doc2_num					=  	checkForNull( oth_rset.getString("DOC2_NUM") );
					doc2_exp_date				=  	checkForNull( oth_rset.getString("DOC2_EXP_DATE") );
					doc2_place_of_issue		=  	checkForNull( oth_rset.getString("DOC2_PLACE_OF_ISSUE") );
					doc2_iss_date				=  	checkForNull( oth_rset.getString("DOC2_ISS_DATE") );
					doc3_num					=  	checkForNull( oth_rset.getString("DOC3_NUM") );
					doc3_exp_date				=  	checkForNull( oth_rset.getString("DOC3_EXP_DATE") );
					doc3_place_of_issue     =  checkForNull( oth_rset.getString("DOC3_PLACE_OF_ISSUE") );
					doc3_iss_date				=  	checkForNull( oth_rset.getString("DOC3_ISS_DATE") );
					doc4_num					=  	checkForNull( oth_rset.getString("DOC4_NUM") );
					doc4_exp_date				=  	checkForNull( oth_rset.getString("DOC4_EXP_DATE") );
					doc4_place_of_issue     =  checkForNull( oth_rset.getString("DOC4_PLACE_OF_ISSUE") );
					doc4_iss_date				=  	checkForNull( oth_rset.getString("DOC4_ISS_DATE") );

					if ( !locale.equals("en") )
					{ 
						if (!doc1_exp_date.equals(""))
							doc1_exp_date= DateUtils.convertDate(doc1_exp_date,"DMY","en",locale);
						if (!doc1_iss_date.equals(""))
							doc1_iss_date= DateUtils.convertDate(doc1_iss_date,"DMY","en",locale);
						if (!doc2_exp_date.equals(""))
							doc2_exp_date= DateUtils.convertDate(doc2_exp_date,"DMY","en",locale);
						if (!doc2_iss_date.equals(""))
							doc2_iss_date= DateUtils.convertDate(doc2_iss_date,"DMY","en",locale);
						if (!doc3_exp_date.equals(""))
							doc3_exp_date= DateUtils.convertDate(doc3_exp_date,"DMY","en",locale);
						if (!doc3_iss_date.equals(""))
							doc3_iss_date= DateUtils.convertDate(doc3_iss_date,"DMY","en",locale);
						if (!doc4_exp_date.equals(""))
							doc4_exp_date= DateUtils.convertDate(doc4_exp_date,"DMY","en",locale);
						if (!doc4_iss_date.equals(""))
							doc4_iss_date= DateUtils.convertDate(doc4_iss_date,"DMY","en",locale);
					}
				//}
			}
		}
		}
	}
	catch(Exception e) {		
		e.printStackTrace();
	}
	finally {
		
		//if(doc_pstmt!=null) doc_pstmt.close();
		//if(doc_rs!=null) doc_rs.close();
	}
	try { 
		//Query to get the values from mp-param
		// Below query  is modified against GHL-CRF-0312 [IN:039856] by Saanthaakumar
		// Below query  is modified against KDAH-CRF-0273 [IN:045012] by Saanthaakumar
		//alt_id2_accept_alphanumeric_yn, alt_id3_accept_alphanumeric_yn, alt_id4_accept_alphanumeric_yn, alt_id2_accept_oth_pat_ser_yn, alt_id3_accept_oth_pat_ser_yn, alt_id4_accept_oth_pat_ser_yn added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772]
		sql = "SELECT NVL(alt_id1_reqd_yn,'N') alt_id1_reqd_yn,NVL(alt_id2_reqd_yn,'N') alt_id2_reqd_yn,NVL(alt_id3_reqd_yn,'N') alt_id3_reqd_yn,NVL(alt_id4_reqd_yn,'N') alt_id4_reqd_yn,alt_id1_type,mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+locale+"','1') alt_id1_desc,alt_id2_type,mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,'"+locale+"','1') alt_id2_desc,alt_id3_type,mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id3_type,'"+locale+"','1') alt_id3_desc,alt_id4_type,mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id4_type,'"+locale+"','1') alt_id4_desc,NVL(first_name_accept_yn,'N') first_name_accept_yn,first_name_order,NVL(first_name_prompt,'First Name') first_name_prompt,NVL(second_name_accept_yn,'N') second_name_accept_yn,second_name_order,NVL(second_name_prompt,'Second Name') second_name_prompt,NVL(third_name_accept_yn,'N') third_name_accept_yn,third_name_order,NVL(third_name_prompt,'Third Name') third_name_prompt,NVL(family_name_accept_yn,'N') family_name_accept_yn,family_name_order,NVL(family_name_prompt,'Family Name') family_name_prompt,name_dervn_logic,NAME_DERVN_LOGIC_LONG,NVL(alt_id1_length,0) alt_id1_length,NVL(alt_id2_length,0) alt_id2_length,NVL(alt_id3_length,0) alt_id3_length,NVL(alt_id4_length,0) alt_id4_length,NVL(name_suffix_accept_yn,'N') name_suffix_accept_yn,NVL(name_prefix_accept_yn,'N') name_prefix_accept_yn,NVL(name_suffix_prompt,'Name Suffix') name_suffix_prompt,NVL(name_prefix_prompt,'Name Prefix') name_prefix_prompt,NVL(first_name_reqd_yn,'N') first_name_reqd_yn,NVL(second_name_reqd_yn,'N') second_name_reqd_yn,NVL(third_name_reqd_yn,'N') third_name_reqd_yn,NVL(family_name_reqd_yn,'N') family_name_reqd_yn,NVL(name_suffix_reqd_yn,'N') name_suffix_reqd_yn,NVL(name_prefix_reqd_yn,'N') name_prefix_reqd_yn,NVL(family_no_link_yn,'N') family_no_link_yn,NVL(patient_id_length,0) patient_id_length,citizen_nationality_code,default_race_code,NVL(alt_id1_unique_yn,'N') alt_id1_unique_yn,NVL(alt_id2_unique_yn,'N') alt_id2_unique_yn,NVL(alt_id3_unique_yn,'N') alt_id3_unique_yn,NVL(alt_id4_unique_yn,'N') alt_id4_unique_yn,DECODE('"+patient_grp+"','N',nat_id_pat_ser_grp,'A',alt_id_pat_ser_grp,'G',gen_pat_ser_grp) dfltpsg,NVL(alt_id_pat_ser_grp,'') altdfltpsg,nat_id_length,NVL(alt_id1_len_validation_yn,'N') alt_id1_len_validation_yn,NVL(alt_id2_len_validation_yn,'N') alt_id2_len_validation_yn,NVL(alt_id3_len_validation_yn,'N') alt_id3_len_validation_yn,NVL(alt_id4_len_validation_yn,'N') alt_id4_len_validation_yn,alt_id1_exp_date_accept_yn,alt_id2_exp_date_accept_yn,alt_id3_exp_date_accept_yn,alt_id4_exp_date_accept_yn,alt_id1_routine_yn,alt_id1_data_source_id alt_id1_routine,alt_id2_routine_yn,alt_id2_data_source_id alt_id2_routine,alt_id3_routine_yn,alt_id3_data_source_id alt_id3_routine,alt_id4_routine_yn,alt_id4_data_source_id alt_id4_routine,NVL(nat_id_pat_ser_grp,'') def_nat_id_pat_ser_grp,NVL(nat_id_prompt,'National ID No') nat_id_prompt,names_in_oth_lang_yn,DECODE(dflt_pat_ser_grp_type,'N',nat_id_pat_ser_grp,'A',alt_id_pat_ser_grp,'G',gen_pat_ser_grp) dflt_grp,alt_id1_chk_digit_scheme,alt_id2_chk_digit_scheme,alt_id3_chk_digit_scheme,alt_id4_chk_digit_scheme,invoke_routine,nat_data_source_id,NVL(nat_id_check_digit_id,'') nat_id_check_digit_id,NVL(addl_field1_prompt,'') addl_field1_prompt,NVL(addl_field1_length,'0') addl_field1_length,NVL(addl_field1_section,'') addl_field1_section,NVL(addl_field2_prompt,'') addl_field2_prompt,NVL(addl_field2_length,'0') addl_field2_length,NVL(addl_field2_section,'') addl_field2_section,NVL(addl_field3_prompt,'') addl_field3_prompt,NVL(addl_field3_length,'0') addl_field3_length,NVL(addl_field3_section,'') addl_field3_section,NVL(addl_field4_prompt,'') addl_field4_prompt,NVL(addl_field4_length,'0') addl_field4_length,NVL(addl_field4_section,'') addl_field4_section,NVL(addl_field5_prompt,'') addl_field5_prompt,NVL(addl_field5_length,'0') addl_field5_length,NVL(addl_field5_section,'') addl_field5_section,NVL(nat_id_chk_len,'N') nat_id_chk_len,TO_CHAR(SYSDATE,'dd/mm/yyyy') serverdate,TO_CHAR(SYSDATE,'ddmmyyyyhhmmss') photo_file_name,NVL(nat_id_reqd_all_series,'N') nat_id_reqd_all_series,NVL(name_prefix_loc_lang_prompt,'') name_prefix_loc_lang_prompt,NVL(first_name_loc_lang_prompt,'') first_name_loc_lang_prompt,NVL(second_name_loc_lang_prompt,'') second_name_loc_lang_prompt,NVL(third_name_loc_lang_prompt,'') third_name_loc_lang_prompt,NVL(family_name_loc_lang_prompt,'') family_name_loc_lang_prompt,NVL(name_suffix_loc_lang_prompt,'') name_suffix_loc_lang_prompt,accept_national_id_no_yn,nat_id_accept_alphanumeric_yn,alt_id1_accept_oth_pat_ser_yn,alt_id1_accept_alphanumeric_yn,max_patient_age,name_dervn_logic_oth_lang,NAME_DERVN_LOGIC_OTH_LANG_LONG,pat_name_as_multipart_yn,accept_oth_alt_id_yn,ext_system_interface_yn,create_file_at_pat_regn_yn,dflt_alt_id1_in_emp_id_yn,NVL(maintain_doc_or_file,'F') maintain_doc_or_file,family_org_id_accept_yn,entitlement_by_pat_cat_yn,pat_category_reqd_yn,TRIM(org_member_relationship_code) org_member_relationship_code,DFLT_LANGUAGE_ID,DFLT_RELGN_CODE,INV_PAT_SEARCH_IN_REG_PAT_YN,COUNTRY_REQD_YN,REGION_REQD_YN,MOBILE_NO_REQD_YN,EMAIL_ID_REQD_YN,postal_cd_reqd_yn,area_reqd_yn,town_reqd_yn,(CASE WHEN org_member_relationship_code IS NOT NULL  THEN (mp_get_desc.MP_RELATIONSHIP(org_member_relationship_code,'"+locale+"',2)) END) org_member_relationship_desc, alt_id2_accept_alphanumeric_yn, alt_id3_accept_alphanumeric_yn, alt_id4_accept_alphanumeric_yn, alt_id2_accept_oth_pat_ser_yn, alt_id3_accept_oth_pat_ser_yn, alt_id4_accept_oth_pat_ser_yn,ALT_ID1_ALPHANUM_VALIDATE_YN,ALT_ID2_ALPHANUM_VALIDATE_YN,ALT_ID3_ALPHANUM_VALIDATE_YN,ALT_ID4_ALPHANUM_VALIDATE_YN  "; // query modified by mujafar for GHL-0524.1

		if(bl_install_yn.equals("Y")) {
			sql = sql+" , (select dflt_pat_regn_blng_class from bl_mp_param) dflt_pat_regn_blng_class ";
		} 		
		
		sql = sql+" FROM mp_param_lang_vw mp_param WHERE module_id = 'MP' AND language_id = '"+locale+"'";
		 
		stmt = con.prepareStatement(sql);
		rset = stmt.executeQuery();		     
		if(rset != null)
		   rset.next();
		ext_system_interface_yn			= checkForNull( rset.getString("ext_system_interface_yn"),"N");
		dflt_alt_id1_in_emp_id_yn			= checkForNull( rset.getString("dflt_alt_id1_in_emp_id_yn"),"N");
		family_org_id_accept_yn			= checkForNull( rset.getString("family_org_id_accept_yn"),"N");
		entitlement_by_pat_cat_yn		= checkForNull( rset.getString("entitlement_by_pat_cat_yn"),"N");
		pat_category_reqd_yn            = checkForNull( rset.getString("pat_category_reqd_yn"),"N"); //Added by Suji keerthi on 26-Nov-2019 for KDAH-CRF-0522
		org_member_relationship_code	= checkForNull( rset.getString("org_member_relationship_code") );
		org_member_relationship_desc	= checkForNull( rset.getString("org_member_relationship_desc") );
		accept_national_id_no_yn			= checkForNull( rset.getString("accept_national_id_no_yn"),"N");
		nat_id_accept_alphanumeric_yn			= checkForNull(rset.getString("nat_id_accept_alphanumeric_yn"),"N");
		alt_id1_accept_oth_pat_ser_yn	= checkForNull( rset.getString("alt_id1_accept_oth_pat_ser_yn"),"N");
		alt_id1_accept_alphanumeric_yn = checkForNull( rset.getString("alt_id1_accept_alphanumeric_yn"),"N");
		 // added by mujafar for ML-MMOH-CRF-524.1 start 
		alt_id1_alphanum_validate_yn = checkForNull( rset.getString("alt_id1_alphanum_validate_yn"),"N");
		alt_id2_alphanum_validate_yn = checkForNull( rset.getString("alt_id2_alphanum_validate_yn"),"N");
		alt_id3_alphanum_validate_yn = checkForNull( rset.getString("alt_id3_alphanum_validate_yn"),"N");
		alt_id4_alphanum_validate_yn = checkForNull( rset.getString("alt_id4_alphanum_validate_yn"),"N");
		 // added by mujafar for ML-MMOH-CRF-524.1 end 

		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
		alt_id2_accept_oth_pat_ser_yn			= checkForNull(rset.getString("alt_id2_accept_oth_pat_ser_yn"),"N");
		alt_id2_accept_alphanumeric_yn			= checkForNull(rset.getString("alt_id2_accept_alphanumeric_yn"),"N");
		alt_id3_accept_oth_pat_ser_yn			= checkForNull(rset.getString("alt_id3_accept_oth_pat_ser_yn"),"N");
		alt_id3_accept_alphanumeric_yn			= checkForNull(rset.getString("alt_id3_accept_alphanumeric_yn"),"N");
		alt_id4_accept_oth_pat_ser_yn			= checkForNull(rset.getString("alt_id4_accept_oth_pat_ser_yn"),"N");
		alt_id4_accept_alphanumeric_yn			= checkForNull(rset.getString("alt_id4_accept_alphanumeric_yn"),"N");
		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */

		pat_name_as_multipart_yn			= checkForNull( rset.getString("pat_name_as_multipart_yn"),"N");
		maintain_doc_or_file					= checkForNull( rset.getString("maintain_doc_or_file") );
		max_pat_age							= checkForNull( rset.getString("max_patient_age") );
		Accept_oth_alt_id_yn				= checkForNull( rset.getString("Accept_oth_alt_id_yn"),"N");
		create_file_at_pat_regn_yn		= checkForNull( rset.getString("create_file_at_pat_regn_yn"),"N");
		nat_invoke_routine				= checkForNull( rset.getString("invoke_routine"));
		nat_data_source_id			= checkForNull( rset.getString("nat_data_source_id"));
		nat_id_check_digit_id			= checkForNull( rset.getString("nat_id_check_digit_id"));
		nat_id_chk_len					= checkForNull( rset.getString("nat_id_chk_len"));
		name_prefix_reqd_yn				= checkForNull( rset.getString("name_prefix_reqd_yn"));
		dflt_language_id				= checkForNull( rset.getString("DFLT_LANGUAGE_ID"));
		dflt_relgn_code					= checkForNull( rset.getString("DFLT_RELGN_CODE"));
		inv_pat_search_in_reg_pat_yn	= checkForNull( rset.getString("INV_PAT_SEARCH_IN_REG_PAT_YN"),"N");
		// New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
		country_reqd_yn	= checkForNull( rset.getString("COUNTRY_REQD_YN"),"N");
		region_reqd_yn	= checkForNull( rset.getString("REGION_REQD_YN"),"N");
		mobile_no_reqd_yn	= checkForNull( rset.getString("MOBILE_NO_REQD_YN"),"N");
		// New parameter  is added against AMRI-CRF-0388 by Shagar
		postal_cd_reqd_yn	= checkForNull( rset.getString("postal_cd_reqd_yn"),"N");
		area_reqd_yn	= checkForNull( rset.getString("area_reqd_yn"),"N");
		town_reqd_yn    = checkForNull( rset.getString("town_reqd_yn"),"N"); //Added by Suji keerthi on 27-Nov-2019 for KDAH-CRF-0522
		// Ends here
		// New Added against KDAH-CRF-0273 [IN:045012]  By saanthaakumar
		email_id_reqd_yn	= checkForNull( rset.getString("EMAIL_ID_REQD_YN"),"N");
		if(bl_install_yn.equals("Y")) {
			dflt_pat_regn_blng_class	= checkForNull( rset.getString("dflt_pat_regn_blng_class"),"");
		}		

		if(AltIdNo.equals("") && !patient_grp.equals("N")) patient_grp = "G" ;
		sql = "SELECT pat_ser_grp_code,"+
				 "        gen_pat_id_yn,"+
				 "        mp_get_desc.MP_PAT_SER_GRP(pat_ser_grp_code,'"+locale+"',2) short_desc"+
				 " FROM   mp_pat_ser_grp"+
				 " WHERE  id_type NOT IN ('X','R')";
		if(oth_rset!=null) oth_rset.close();
		if(oth_stmt!=null) oth_stmt.close();
		oth_stmt = con.prepareStatement(sql);
		oth_rset = oth_stmt.executeQuery();	

		if(oth_rset != null)
		{
			int k= 0;
			out.println("<script>");
			while ( oth_rset.next() )
			{
				out.println("PSGCodeArray["+k+"]=\""+oth_rset.getString("pat_ser_grp_code")+"\";");
				out.println("PSGYNArray["+k+"]=\""+oth_rset.getString("gen_pat_id_yn")+"\";");
				out.println("PSGCodeArrayValues["+k+"]=\""+oth_rset.getString("short_desc")+"\";");
				k++;
			}
			out.println("</script>");
			if(oth_rset != null)  oth_rset.close();
		}

		cust_fields[0] = rset.getString("addl_field1_section")+"`"+rset.getString("addl_field1_prompt")+"`"+ rset.getString("addl_field1_length")+"`addl_field1";
		cust_fields[1] = rset.getString("addl_field2_section")+"`"+rset.getString("addl_field2_prompt")+"`"+ rset.getString("addl_field2_length")+"`addl_field2";
		cust_fields[2] = rset.getString("addl_field3_section")+"`"+rset.getString("addl_field3_prompt")+"`"+ rset.getString("addl_field3_length")+"`addl_field3";
		cust_fields[3] = rset.getString("addl_field4_section")+"`"+rset.getString("addl_field4_prompt")+"`"+ rset.getString("addl_field4_length")+"`addl_field4";
		cust_fields[4] = rset.getString("addl_field5_section")+"`"+rset.getString("addl_field5_prompt")+"`"+ rset.getString("addl_field5_length")+"`addl_field5"; 

		for(int i=0;i<cust_fields.length;i++) {
			if(cust_fields[i].charAt(0) == 'D')
				++Demoaddlcnt;
			if(cust_fields[i].charAt(0) == 'C')
				++Contactaddlcnt;
			/*if(cust_fields[i].charAt(0) == 'N')
				++NoKaddlcnt;
			if(cust_fields[i].charAt(0) == 'F')
				++FtNotifyaddlcnt;
			if(cust_fields[i].charAt(0) == 'E')
				++Empraddlcnt;*/
			if(cust_fields[i].charAt(0) == 'O')
				++Othersaddlcnt;
		}
	}
	catch(Exception e) {
		out.println("Error in the header block:"+e+"<br>"+sql) ;
		e.printStackTrace();
	}
	%>
	<!--chkNatlIdMandatory(); Added by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491]!-->
    <body onSelect="codeArrestThruSelect()" onload='checkPatGenYN();displayScanner();chkNatlIdMandatory("onload");' onKeyPress='return ChkKey(event);'OnMouseDown="CodeArrest()"  onKeyDown='lockKey()'>
		<form name='PatRegForm' id='PatRegForm' method='post'   action='../../servlet/eMP.PatientRegistrationServlet' target='messageFrame'>
		<input type=hidden name='ccount' id='ccount' value=<%=Contactaddlcnt%>>
		<input type='hidden' name='patient_grp' id='patient_grp' value='<%=patient_grp%>'>
		<input type='hidden' name='q_booking_type' id='q_booking_type' value='<%=q_booking_type%>'>
		<%
		try
		{
			%>
		    <!-- <a name='demo'></a> -->
			<div id = 'demo' name='demo'>
			<input type='hidden' name='r_postal_code' id='r_postal_code' value='<%=a_postal_code%>'>
			<input type='hidden' name='alt_postal_code' id='alt_postal_code' value=''> <!-- added by mujafar for ML-MMOH-CRF-0601 -->
			<input type='hidden' name='m_postal_code' id='m_postal_code' value='<%=a_mail_postal_code%>'>
			<input type='hidden' name='next_postal_code' id='next_postal_code' value=''>
			<input type='hidden' name='first_postal_code' id='first_postal_code' value=''>
			<input type='hidden' name='employ_postal_code' id='employ_postal_code' value=''>
			<input type='hidden' name='m_town' id='m_town' value=''>
			<input type='hidden' name='r_town' id='r_town'>
			<input type='hidden' name='n_town' id='n_town'>
			<input type='hidden' name='f_town' id='f_town'>
			<input type='hidden' name='e_town' id='e_town'>
			<input type='hidden' name='r_area' id='r_area' value=''>
			<input type='hidden' name='m_area' id='m_area' value=''>
			<input type='hidden' name='n_area' id='n_area' value=''>
			<input type='hidden' name='f_area' id='f_area' value=''>
			<input type='hidden' name='e_area' id='e_area' value=''>
			<input type='hidden' name='r_region' id='r_region' value=''>
			<input type='hidden' name='m_region' id='m_region' value=''>
			<input type='hidden' name='n_region' id='n_region' value=''>
			<input type='hidden' name='f_region' id='f_region' value=''>
			<input type='hidden' name='e_region' id='e_region' value=''>
			<input type='hidden' name='accept_national_id_no' id='accept_national_id_no' value="<%=accept_national_id_no_yn%>">
			
			<input type='hidden' name='alt_id1_accept_oth_pat_ser_yn' id='alt_id1_accept_oth_pat_ser_yn' value="<%=alt_id1_accept_oth_pat_ser_yn%>">
			<input type='hidden' name='alt_id1_accept_alphanumeric_yn' id='alt_id1_accept_alphanumeric_yn' value="<%=alt_id1_accept_alphanumeric_yn%>">
			<!--added by mujafar for ML-MMOH-CRF-524.1 start -->
			<input type='hidden' name='alt_id1_alphanum_validate_yn' id='alt_id1_alphanum_validate_yn' value="<%=alt_id1_alphanum_validate_yn%>">
			<input type='hidden' name='alt_id2_alphanum_validate_yn' id='alt_id2_alphanum_validate_yn' value="<%=alt_id2_alphanum_validate_yn%>">
			<input type='hidden' name='alt_id3_alphanum_validate_yn' id='alt_id3_alphanum_validate_yn' value="<%=alt_id3_alphanum_validate_yn%>">
			<input type='hidden' name='alt_id4_alphanum_validate_yn' id='alt_id4_alphanum_validate_yn' value="<%=alt_id4_alphanum_validate_yn%>">
			<!--added by mujafar for ML-MMOH-CRF-524.1 end -->

			<!--Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] Start -->
			<input type="hidden" name="alt_id2_accept_oth_pat_ser_yn" id="alt_id2_accept_oth_pat_ser_yn" value="<%=alt_id2_accept_oth_pat_ser_yn%>" />
			<input type="hidden" name="alt_id2_accept_alphanumeric_yn" id="alt_id2_accept_alphanumeric_yn" value="<%=alt_id2_accept_alphanumeric_yn%>" /> 

			<input type="hidden" name="alt_id3_accept_oth_pat_ser_yn" id="alt_id3_accept_oth_pat_ser_yn" value="<%=alt_id3_accept_oth_pat_ser_yn%>" /> 
			<input type="hidden" name="alt_id3_accept_alphanumeric_yn" id="alt_id3_accept_alphanumeric_yn" value="<%=alt_id3_accept_alphanumeric_yn%>" /> 

			<input type="hidden" name="alt_id4_accept_oth_pat_ser_yn" id="alt_id4_accept_oth_pat_ser_yn" value="<%=alt_id4_accept_oth_pat_ser_yn%>" /> 
			<input type="hidden" name="alt_id4_accept_alphanumeric_yn" id="alt_id4_accept_alphanumeric_yn" value="<%=alt_id4_accept_alphanumeric_yn%>" />
			<!--Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] End -->
			
			<!--Below line added for this CRF ML-MMOH-CRF-0860.2-->
	        <input type='hidden' name='a_area' id='a_area' value="">
	        <input type='hidden' name='a_region' id='a_region' value="">
	        <input type='hidden' name='a_town' id='a_town' value="">
	        <!--End this ML-MMOH-CRF-0860.2 -->


		    <input type='hidden' name='max_patient_age' id='max_patient_age' value="<%=max_pat_age%>">
			<input type ='hidden' name='family_org_id_accept_yn' id='family_org_id_accept_yn' value="<%=family_org_id_accept_yn%>"></input>
			<input type ='hidden' name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn' value="<%=entitlement_by_pat_cat_yn%>"></input>
			<input type ='hidden' name='pat_cato_reqd_yn' id='pat_cato_reqd_yn' value="<%=pat_category_reqd_yn%>"></input>  <!-- //Added by Suji keerthi on 26-Nov-2019 for KDAH-CRF-0522 -->
			<input type ='hidden' name='org_member_relationship_code' id='org_member_relationship_code' value="<%=org_member_relationship_code%>"></input>
			<input type ='hidden' name='org_member_relationship_desc' id='org_member_relationship_desc' value="<%=org_member_relationship_desc%>"></input>
			<input type='hidden' name='pat_no_gen_yn' id='pat_no_gen_yn' value=""></input>
			<%
			FamilyNoLink					= checkForNull(rset.getString("Family_No_Link_Yn"),"N");
			dfltPSG							= checkForNull(rset.getString("dfltPSG"));
			
			citizen_nationality_code	= checkForNull(rset.getString("citizen_nationality_code"));
			if(a_race_code.equals("")) {
				a_race_code = checkForNull(rset.getString("default_race_code"));
			} 
			/*Two param added for this CRF [RUT-CRF-0011]*/ 
			// Below appt_ref_no param newly added for Incident 36262 
			%> 

			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<jsp:include page="../../eMP/jsp/ChangePatientSubNames.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name="patient_id" value="<%=patient_id%>" />
					<jsp:param name="group" value="<%=patient_grp%>" />
					<jsp:param name="CalledFromFunction" value="PatientRegistration" />
					
					<jsp:param name="patient_cat_code" value="<%=patient_cat_code%>" />
					<jsp:param name="patient_cat_desc" value="<%=patient_cat_desc%>" />
					<jsp:param name="language_id" value="<%=language_id%>" />
					<jsp:param name="language_desc" value="<%=language_desc%>" /> 
					
					<jsp:param name="a_family_name" value="<%=a_family_name%>" />
					<jsp:param name="a_first_name" value="<%=a_first_name%>" />
					<jsp:param name="a_second_name" value="<%=a_second_name%>" />
					<jsp:param name="a_third_name" value="<%=a_third_name%>" />
					<jsp:param name="a_name_prefix" value="<%=a_name_prefix%>" />
					<jsp:param name="a_name_suffix" value="<%=a_name_suffix%>" />
					<jsp:param name="a_name_prefix_loc_lang" value="<%=a_name_prefix_loc_lang%>" />
					<jsp:param name="a_first_name_loc_lang" value="<%=a_first_name_loc_lang%>" />
					<jsp:param name="a_second_name_loc_lang" value="<%=a_second_name_loc_lang%>" />
					<jsp:param name="a_third_name_loc_lang" value="<%=a_third_name_loc_lang%>" />
					<jsp:param name="a_family_name_loc_lang" value="<%=a_family_name_loc_lang%>" />
					<jsp:param name="a_name_suffix_loc_lang" value="<%=a_name_suffix_loc_lang%>" />
					<jsp:param name="a_patient_name_loc_lang" value="<%=a_patient_name_loc_lang%>" />
					<jsp:param name="a_national_id_no" value="<%=a_national_id_no%>" />
					<jsp:param name="a_oth_alt_id_type" value="<%=a_oth_alt_id_type%>" />
					<jsp:param name="a_oth_alt_id_no" value="<%=a_oth_alt_id_no%>" />
					<jsp:param name="a_alt_id1_no" value="<%=a_alt_id1_no%>" />
					<jsp:param name="a_alt_id1_exp_date" value="<%=a_alt_id1_exp_date%>" />
					<jsp:param name="a_alt_id2_no" value="<%=a_alt_id2_no%>" />
					<jsp:param name="a_alt_id2_exp_date" value="<%=a_alt_id2_exp_date%>" />
					<jsp:param name="a_alt_id3_no" value="<%=a_alt_id3_no%>" />
					<jsp:param name="a_alt_id3_exp_date" value="<%=a_alt_id3_exp_date%>" />
					<jsp:param name="a_alt_id4_no" value="<%=a_alt_id4_no%>" />
					<jsp:param name="a_alt_id4_exp_date" value="<%=a_alt_id4_exp_date%>" />
					<jsp:param name="a_familyno" value="<%=a_familyno%>" />
					<jsp:param name="a_gender" value="<%=a_gender%>" />
					<jsp:param name="a_birth_place_desc" value="<%=a_birth_place_desc%>" />
					<jsp:param name="a_birth_place_code" value="<%=a_birth_place_code%>" />
					<jsp:param name="a_place_of_birth" value="<%=a_place_of_birth%>" />
					<jsp:param name="a_date_of_birth" value="<%=a_date_of_birth%>" />
					<jsp:param name="a_citizen_yn" value="<%=a_citizen_yn%>" />
					<jsp:param name="a_legal_yn" value="<%=a_legal_yn%>" />
					<jsp:param name="a_nationality_code" value="<%=a_nationality_code%>" />
					<jsp:param name="a_race_code" value="<%=a_race_code%>" />
					<jsp:param name="relgn_code" value="<%=relgn_code%>" />
					<jsp:param name="citizen_nationality_code" value="<%=citizen_nationality_code%>" />
					<jsp:param name="dflt_alt_id1_in_emp_id_yn" value="<%=dflt_alt_id1_in_emp_id_yn%>"/>
					<jsp:param name="Site" value="<%=Site%>" />
					<jsp:param name="dfltPSG" value="<%=dfltPSG%>" />
					<jsp:param name="year" value="<%=year%>" />
					<jsp:param name="months" value="<%=months%>" />
					<jsp:param name="days" value="<%=days%>" />
					<jsp:param name="Demoaddlcnt" value="<%=Demoaddlcnt%>" />
					<jsp:param name="dflt_language_id" value="<%=dflt_language_id%>" />
					<jsp:param name="dflt_relgn_code" value="<%=dflt_relgn_code%>" />
					<jsp:param name="inv_pat_search_in_reg_pat_yn" value="<%=inv_pat_search_in_reg_pat_yn%>" />
					<jsp:param name="nat_id_accept_alphanumeric_yn" value="<%=nat_id_accept_alphanumeric_yn%>" />
					<jsp:param name="PatInfflag" value="<%=PatInfflag%>" />
					<jsp:param name="appt_ref_no" value="<%=appt_ref_no%>" /> 
					
				</jsp:include> 
			<tr></tr>
			 <%
					// Code for additional fields for Demographics tab
                    order=0;
					int demo_cnt = 1;
                    for(int i=0; i<cust_fields.length;i++)
                    {
						if(cust_fields[i].charAt(0) == 'D' )
                        {
                           	int intind_0		= cust_fields[i].indexOf('`');
							String strcf		= cust_fields[i];		
							String strs1	 	= strcf.substring(intind_0+1, strcf.length());
												
							int intind_1		= strs1.indexOf('`');
							String lab		= strs1.substring(0, intind_1);
							String strs2	 	= strs1.substring(intind_1+1, strs1.length());
							int intind_2		= strs2.indexOf('`');
							String size		= strs2.substring(0, intind_2);
							
							String strs3	= strs2.substring(intind_2+1, strs2.length());
							String nme		= strs3.substring(0);

							if(order == 0)
                            {
                                out.println("<tr></tr><tr>");
                                out.println("<td colspan=2>");
                            }

                            if( order %2 == 0 || order == 0)
                            {
								out.println("</tr><tr>") ;
								if(Demoaddlcnt == (i+1))
								{ %>
									<td class='label'   ><%=lab%></td>
									<td class='fields' ><input type='text' name="<%=nme%>" id="<%=nme%>" maxlength="<%=size%>" size='20' value=''  onblur='makeValidString(this);if("<%=demo_cnt%>" == "<%=Demoaddlcnt%>") { document.forms[0].pat_ser_grp_code.focus();}'></td>
								<% } else { 
										%>
									<td class='label'   ><%=lab%></td>
									<td class='fields' ><input type='text' name="<%=nme%>" id="<%=nme%>" maxlength="<%=size%>" size='20' value='' onblur='makeValidString(this);if("<%=demo_cnt%>" == "<%=Demoaddlcnt%>") { document.forms[0].pat_ser_grp_code.focus();}'></td>
								<% }
                            }
							if(order %2 != 0 && order!=0)
							{
								if(Demoaddlcnt==(i+1))
								{ 
									%>
									<td class='label'   ><%=lab%></td>
									<td class='fields' ><input type='text' name="<%=nme%>" id="<%=nme%>" maxlength="<%=size%>" size='20' value='' onblur='makeValidString(this);if("<%=demo_cnt%>" == "<%=Demoaddlcnt%>") { document.forms[0].pat_ser_grp_code.focus();}' ></td>
								<% } else { 
										%>
									<td class='label'   ><%=lab%></td>
									<td class='fields' ><input type='text' name="<%=nme%>" id="<%=nme%>" maxlength="<%=size%>" size='20' value='' onblur='makeValidString(this);if("<%=demo_cnt%>" == "<%=Demoaddlcnt%>") { document.forms[0].pat_ser_grp_code.focus();}'></td>
								<% }
							}
                            order++;
							demo_cnt++;
                        }
						
                    }
					if(order %2 != 0 && order!=0)
					{%>
					<td class='label' colspan='2'></td>	
					<%}
                   if (order != 0)
                    {
                        out.println("</table>");
                        out.println("</td>");
                        out.println("</tr>");
                    }
                %>	 
                 </table>
			</div>				
			<!-- <a name='addr'></a> -->
			<div id = 'addr' style = 'display:none'>
            <table width='100%' cellpadding='0' cellspacing='1' border ='0' width='100%'>
                <tr>
                    <td  class='BODYCOLORFILLED' width='1%'></td>
                    <td width='99%'  class='BODYCOLORFILLED' valign='top' colspan='6'>
                    <table cellpadding='2' cellspacing='0' border='0' height='100%' width='99.5%'>
					        <!--Below line added for this CRF ML-MMOH-CRF-0860.2 -->
                        <tr>
                            <td class='COLUMNHEADER'  ></td>
                            <td  class='COLUMNHEADER' colspan='2'><fmt:message key="eMP.residenceaddress.label" bundle="${mp_labels}"/></td>
							<%if(alterAddressApplicable && increasedaddressLength){%>
                            <td  class='COLUMNHEADER' colspan='<%=col_span_td%>' ><fmt:message key="eMP.AlternateAddress.label" bundle="${mp_labels}"/></td>
							<%} if(!alterAddressApplicable && increasedaddressLength){%>
							<td  class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.MailingAddress.label" bundle="${common_labels}"/></td>
							 
							<%} if((!alterAddressApplicable && !increasedaddressLength) || (alterAddressApplicable && increasedaddressLength)){%>
							 <td  class='COLUMNHEADER' colspan='<%=col_span_td%>'><fmt:message key="Common.MailingAddress.label" bundle="${common_labels}"/></td>
							 <%}%>
                        </tr>
                        <%// New Condition  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar 	
						if(region_reqd_yn.equals("Y")){ 
										region_visibility = "visibility:visible";} // Ends here
							
							StringBuffer sb1a			= new StringBuffer();
                            StringBuffer fieldVala		= new StringBuffer();
							StringBuffer sba			= new StringBuffer();
							StringBuffer sbap			= new StringBuffer();
							StringBuffer sbar			= new StringBuffer();
							StringBuffer sb1aa		= new StringBuffer();
                            StringBuffer fieldValaa	= new StringBuffer();
							
							//Added for this CRF ML-MMOH-CRF-0601
							StringBuffer sb_a = new StringBuffer();
							StringBuffer sb_ap			= new StringBuffer();
							StringBuffer sb_ar			= new StringBuffer();
							StringBuffer sb1_aa		= new StringBuffer();
                            StringBuffer fieldVal_aa	= new StringBuffer(); 
							//End this CRF ML-MMOH-CRF-0601

							for(int i=0;i<contact_col_names.length; i++)
                            { 
								%>
                                <tr><td class='label'  ><%=contact_prompts[i]%></td>
								<% 
									String val  = contact_fields[i];
									String val_alt = contact_fields[i]; //Added for this CRF ML-MMOH-CRF-0601
									sb1a.append(val);
                                    fieldVala.append("");
									for(int z=0;z<val.length();z++)
									{
										String tempVal=sb1a.substring(z,z+1);
										
										if(tempVal.equals("@"))
										{
											fieldVala.append("50");
										}
										else
										{
											fieldVala.append(tempVal);
										}
									}
									val = fieldVala.toString();
									val_alt = fieldVala.toString(); //Added for this CRF ML-MMOH-CRF-0601
									
									// modified against GHL-CRF-0312 [IN:039856] by Saanthaakumar
                                   %> <td class='fields' colspan='2'><%=val%><%
									
                                    val = contact_fields[i] ;
									val_alt = contact_fields[i] ; //Added for this CRF ML-MMOH-CRF-0601
																		
                                    sba.append(val) ;
									sb_a.append(val_alt);   //Added for this CRF ML-MMOH-CRF-0601
                                     int j=0 ;
                                     int j1=0 ;
                                     String old_val = "" ;
                                     String new_val = "" ;
									 String new_val_alt=""; //Added for this CRF ML-MMOH-CRF-0601
									if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                                     {
                                        old_val = "r_addr_line1" ;
                                        new_val = "m_addr_line1" ;
										new_val_alt = "a_addr_line1" ; //Added for this CRF ML-MMOH-CRF-0601
                                        if(addr_pincode_mand){/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
                                        out.println("<img id='addr_pincode_mand1' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                                     {
                                        old_val = "r_addr_line2" ;
                                        new_val = "m_addr_line2" ;
										new_val_alt = "a_addr_line2" ;  //Added for this CRF ML-MMOH-CRF-0601
                                        if(addr_pincode_mand){/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
                                        out.println("<img id='addr_pincode_mand2' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                                     {
                                        old_val = "r_addr_line3" ;
                                        new_val = "m_addr_line3" ;
										new_val_alt = "a_addr_line3" ; //Added for this CRF ML-MMOH-CRF-0601
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                                     {
                                        old_val = "r_addr_line4" ;
                                        new_val = "m_addr_line4" ;
										new_val_alt = "a_addr_line4" ; //Added for this CRF ML-MMOH-CRF-0601
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                                     {
                                        old_val = "r_town_code" ;
                                        new_val = "m_town_code" ;
										new_val_alt = "a_town_code" ; //Added for this CRF ML-MMOH-CRF-0601
									if(town_reqd_yn.equals("Y")){/*Added by Suji keerthi on 27-Nov-2019 for KDAH-CRF-0522*/
	                                        out.println("<img id='town_code_mand' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
                                     }//Added by kumar on 13/03/2003 for region 
									 else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                                     {
                                        old_val = "r_region_code" ;
										// Image is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
										out.println("<img id='id1' src='../images/mandatory.gif' style='"+region_visibility+"'</img>");
                                        new_val = "m_region_code" ;
										new_val_alt = "a_region_code" ; //Added for this CRF ML-MMOH-CRF-0601
                                     }
									 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                                     {
                                        old_val = "r_area_code" ;
                                        new_val = "m_area_code" ;
										new_val_alt = "a_area_code" ; //Added for this CRF ML-MMOH-CRF-0601
									if(area_reqd_yn.equals("Y")){/*Added by agiant AMRI-CRF-0388*/
                                        out.println("<img id='area_code_mand' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
                                     }                                     
                                     else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                                     {
                                        old_val = "r_postal_code" ;
                                        new_val = "m_postal_code" ;
										new_val_alt = "alt_postal_code" ;  //Added for this CRF ML-MMOH-CRF-0601
                                       // if(addr_pincode_mand){/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
                                       //out.println("<img id='addr_pincode_mand3' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
									   //above 2 lines commented against AMRI-CRF-0388 by Shagar
									/*Added by agiant AMRI-CRF-0388*/
									if(postal_cd_reqd_yn.equals("Y")){
                                        out.println("<img id='addr_pincode_mand3' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
                                     }
                                    while(val.indexOf(old_val) != -1)
                                    {
                                        j = val.indexOf(old_val,j) ;
                                        sba = sba.replace(j,(j+old_val.length()),new_val);
                                        val = sba.toString();
									}
									//Added for this CRF ML-MMOH-CRF-0601 and ML-MMOH-CRF-0860.2
									while(val_alt.indexOf(old_val) != -1)
                                    {
                                        int jk =0;
										jk = val_alt.indexOf(old_val,jk) ;
                                        sb_a = sb_a.replace(jk,(jk+old_val.length()),new_val_alt);
                                        val_alt = sb_a.toString();
										
									}																		
									
									if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
									{
										sb_ap.append(val_alt);
										while(val_alt.indexOf("r_postal_code") != -1)
										{ 
											
											int jk1 = 0;
											jk1= val_alt.indexOf("r_postal_code",jk1) ;
											
											sb_ap = sb_ap.replace(jk1,(jk1+"r_postal_code".length()),"alt_postal_code");
											val_alt = sb_ap.toString();
									
										}
									}
									if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
									{
										int jk1 = 0;
										sb_ar.append(val_alt);
										while(val_alt.indexOf("r_postal_code") != -1)
										{
											
											jk1 = val_alt.indexOf("r_postal_code",jk1) ;											
											sb_ar = sb_ar.replace(jk1,(jk1+"r_postal_code".length()),"alt_postal_code");
											val_alt = sb_ar.toString();
											
										}
									}
									
									
									sb1_aa.append(val_alt) ;
                                    fieldVal_aa.append("");
									
									for(int z=0;z<val_alt.length();z++)
									{
										String tempVal=sb1_aa.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldVal_aa.append("35");
										}
										else
										{
											fieldVal_aa.append(tempVal);
										}
									}
									
									val_alt = fieldVal_aa.toString();
									
									//End ML-MMOH-CRF-0601 and ML-MMOH-CRF-0860.2
									
									if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
									{ 
										sbap.append(val);
										
										while(val.indexOf("r_postal_code") != -1)
										{
											
											j1 = val.indexOf("r_postal_code",j1) ;
											
											sbap = sbap.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
											val = sbap.toString();
									
										}
									}
									
									
									
									
									if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
									{
										j1 = 0;
										sbar.append(val);
										while(val.indexOf("r_postal_code") != -1)
										{
											
											j1 = val.indexOf("r_postal_code",j1) ;
											
											sbar = sbar.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
											val = sbar.toString();
											
										}
									}
									
									
									
									
									
									
                                    sb1aa.append(val) ;
                                    fieldValaa.append("");
									
									for(int z=0;z<val.length();z++)
									{
										String tempVal=sb1aa.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldValaa.append("65");
										}
										else
										{
											fieldValaa.append(tempVal);
										}
									}
									
									val = fieldValaa.toString();
									%></td>
									
									<!--Below line added for ML-MMOH-CRF-0860.2 and  ML-MMOH-CRF-0601-->
									<%									
									if(alterAddressApplicable){
									if(i == 1)
									{  %>
                                          <td class='fields' colspan='<%=col_span_td%>' ><%=val_alt%> </td> 
									<%}else{   
									    out.println("<td class='fields' colspan='"+col_span_td+"'>"+val_alt+"</td>") ;
									  }						
									}
									%>									
									<!--End this ML-MMOH-CRF-0860.2 and  ML-MMOH-CRF-0601-->
									
									
									<%if(i == 0)
									{ %>
                                    <td class='fields' colspan='<%=col_span_td%>' ><%=val%> <% //Added for ML-MMOH-CRF-0860.2
									if( (!increasedaddressLength) || (increasedaddressLength && ! alterAddressApplicable) ){%>
									<a href='javascript:copyDetails(4)'><fmt:message key="eMP.CopyResidenceAddress.label" bundle="${mp_labels}"/></a>
									<%}//End ML-MMOH-CRF-0860.2%> </td>
									<%}else	
									if(i==1 && alterAddressApplicable)
									{%>
									<td class='fields' colspan='<%=col_span_td%>'><%=val%></td>	
									<%}	
									else
									{
									    out.println("<td class='fields'  colspan='"+col_span_td+"' >"+val+"</td>") ;
									}
									out.println("</tr><tr><td class='label' colspan='4' ></td></tr>") ;
									
									sb1a.setLength(0);
									fieldVala.setLength(0);
									sba.setLength(0);
									sb_a.setLength(0);
									sb1aa.setLength(0);
									sb1_aa.setLength(0);
									fieldValaa.setLength(0);
									fieldVal_aa.setLength(0);
									sbap.setLength(0);
									sb_ap.setLength(0);
									sbar.setLength(0);
									sb_ar.setLength(0);
									
								}
							
							    %>
							 <script>
				        // Added on 13/06/2003 for assigning values to dynamically generated address related fields..
						if(document.forms[0].r_addr_line1)
						document.forms[0].r_addr_line1.value = "<%=a_res_addr_line1%>" ;
						if(document.forms[0].r_addr_line2)
							document.forms[0].r_addr_line2.value = "<%=a_res_addr_line2%>" ;
						if(document.forms[0].r_addr_line3)
							document.forms[0].r_addr_line3.value = "<%=a_res_addr_line3%>" ;
						if(document.forms[0].r_addr_line4)
							document.forms[0].r_addr_line4.value = "<%=a_res_addr_line4%>" ;
						if(document.forms[0].r_town_code)
						{
							document.forms[0].r_town_code.value = "<%=a_res_town_desc%>";
							document.forms[0].r_town.value = "<%=a_res_town_code%>";
						}
						if(document.forms[0].r_region_code)
						{
							document.forms[0].r_region_code.value = "<%=a_res_region_desc%>";
							document.forms[0].r_region.value = "<%=a_res_region_code%>";
						}
						if(document.forms[0].r_area_code)
						{
							document.forms[0].r_area_code.value = "<%=a_res_area_desc%>";
							document.forms[0].r_area.value="<%=a_res_area_code%>";
						}
						if(document.forms[0].r_postal_code1)
							document.forms[0].r_postal_code1.value = "<%=a_postal_desc%>";
						
						if(document.forms[0].m_addr_line1)
						document.forms[0].m_addr_line1.value = "<%=a_mail_addr_line1%>";
						
						if(document.forms[0].m_addr_line2)
							document.forms[0].m_addr_line2.value = "<%=a_mail_addr_line2%>" ;
						if(document.forms[0].m_addr_line3)
							document.forms[0].m_addr_line3.value = "<%=a_mail_addr_line3%>" ;
						if(document.forms[0].m_addr_line4)
							document.forms[0].m_addr_line4.value = "<%=a_mail_addr_line4%>" ;
						if(document.forms[0].m_town_code)
							{
							document.forms[0].m_town.value = "<%=a_mail_town_code%>";
							document.forms[0].m_town_code.value = "<%=a_mail_town_desc%>";
							}
						if(document.forms[0].m_region_code)
							{
							document.forms[0].m_region.value = "<%=a_mail_region_code%>";
							document.forms[0].m_region_code.value = "<%=a_mail_region_desc%>";
							}
						if(document.forms[0].m_area_code)
							{
							document.forms[0].m_area.value = "<%=a_mail_area_code%>";
							document.forms[0].m_area_code.value = "<%=a_mail_area_desc%>";
							}
						if(document.forms[0].m_postal_code1)
							document.forms[0].m_postal_code1.value = "<%=a_mail_postal_desc%>";

						/*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/
						if(document.forms[0].a_addr_line1)
							document.forms[0].a_addr_line1.value	= "<%=alt_addr_line1%>";
						if(document.forms[0].a_addr_line2)
							document.forms[0].a_addr_line2.value	= "<%=alt_addr_line2%>" ;
						if(document.forms[0].a_addr_line3)
							document.forms[0].a_addr_line3.value	= "<%=alt_addr_line3%>" ;
						if(document.forms[0].a_addr_line4)
							document.forms[0].a_addr_line4.value	= "<%=alt_addr_line4%>" ;
						if(document.forms[0].a_town_code){
							document.forms[0].a_town.value			= "<%=alt_town_code%>";
							document.forms[0].a_town_code.value		= "<%=alt_town_desc%>";
						}
						if(document.forms[0].a_region_code){
							document.forms[0].a_region.value		= "<%=alt_region_code%>";
							document.forms[0].a_region_code.value	= "<%=alt_region_desc%>";
						}
						if(document.forms[0].a_area_code){
							document.forms[0].a_area.value			= "<%=alt_area_code%>";
							document.forms[0].a_area_code.value		= "<%=alt_area_desc%>";
						}
						if(document.forms[0].alt_postal_code1){
							document.forms[0].alt_postal_code1.value = "<%=alt_postal_desc%>";
							document.forms[0].alt_postal_code.value	 = "<%=alt_postal_code%>";
						}
						/*End*/
							

						// End of addition on 13/06/2003 for assigning values to dynamically generated address related fields..
						 </script>
						<tr>
                         <%tindex=61;
						 // New Condition  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
						 if(country_reqd_yn.equals("Y")){
						country_visibility = "visibility:visible";}
						// below New Iamge  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar%>   
						 <td  class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/> </td>
                         <td colspan='2' class='fields'><input type='text' name='r_country_desc' id='r_country_desc' value="<%=a_res_country_desc%>" size='15' maxlength='15' onblur='if(this.value != "") {searchCountry(contry_code[0],r_country_desc)} else{clearCountryFields(this);}'  ><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,r_country_desc)' ><img id='id2' src='../images/mandatory.gif' style='<%=country_visibility%>'></img><input type='hidden' name='r_country_code' id='r_country_code' value="<%=a_country_code%>">
                         </td> 
							<%tindex=76;%>
							
							<%
						//Below line added for this CRF and ML-MMOH-CRF-0601 and  ML-MMOH-CRF-0860.2	
						if(alterAddressApplicable)
						{%>
						<td class='fields' colspan='<%=col_span_td%>'>
							<input type='text' name='a_country_desc' id='a_country_desc' size='15' maxlength='15' value="<%=alt_country_desc%>" onblur='if(this.value !="") {searchCountry(contry_code[0],a_country_desc); } else {clearCountryFields(this);}'  ><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,a_country_desc)' >
							<input type='hidden' name='a_country_code' id='a_country_code' value="<%=alt_country_code%>">							
						<%}%>
						   <td class='fields' colspan='<%=col_span_td%>'>
							<input type='text' name='m_country_desc' id='m_country_desc' size='15' maxlength='15' value="<%=a_mail_country_desc%>" onblur='if(this.value !="") {searchCountry(contry_code[0],m_country_desc); } else {clearCountryFields(this);}'  ><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,m_country_desc)' >
							<input type='hidden' name='m_country_code' id='m_country_code' value="<%=a_mail_country_code%>">
						</td>
						<!--End this CRF ML-MMOH-CRF-0860.2-->
						</tr>
                        <input type='hidden' name='r_invalid_yn' id='r_invalid_yn'>
						<input type='hidden' name='m_invalid_yn' id='m_invalid_yn'>
						<input type='hidden' name='a_invalid_yn' id='a_invalid_yn'>
						<!--Below line Modified for this CRF ML-MMOH-CRf-0860.2 -->
                        <tr>
                            <%tindex=63;%>
							<!--below legend name changed ML-MMOH-CRF-939 by Mano--> 
							<td class='label'  ><fmt:message key="eMP.ContactPerson.label" bundle="${mp_labels}"/></td> 
                            <td colspan='2' class='fields'>
                                <input type='text' name='r_contact_name' id='r_contact_name' size='30' maxlength='30'  onblur='makeValidString(this);' value= "<%=res_contact_name%>" >
                            </td>
									<%tindex=78;%>
							<%
							//Below line added for this CRF and ML-MMOH-CRF-0601 
							if(alterAddressApplicable)
							{							
							%>
							<td class='fields' colspan='<%=col_span_td%>'>
                                <input type='text' name='a_contact_name' id='a_contact_name' size='30' maxlength='30'  onblur='makeValidString(this);' value="<%=mail_contact_name%>">
                            </td >
							<%
							}
							%>									
                            <td class='fields' colspan='<%=col_span_td%>'>
                                <input type='text' name='m_contact_name' id='m_contact_name' size='30' maxlength='30'  onblur='makeValidString(this);' value="<%=mail_contact_name%>">
                            </td>							
                        </tr>
						<%if(alterAddressApplicable){%>
						<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td class='fields' colspan='2'><a href='javascript:copyDetails(7)'><fmt:message key="eMP.CopyAlternateAddress.label" bundle="${mp_labels}"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href='javascript:copyDetails(4)'><fmt:message key="eMP.CopyResidenceAddress.label" bundle="${mp_labels}"/></a></td>
						</tr>
						<%}%>
						<!--End this CRF ML-MMOH-CRF-0860.2 --> 
						<tr>
                            <!--Added CRF ML-MMOH-CRF-0601 --> 
							<td class='COLUMNHEADER'  <%=colspantd%>  ><b><fmt:message key="eMP.ContactModes.label" bundle="${mp_labels}"/></b>
							</td>
						</tr>
                        <tr>
                            <%
                                sql="select short_desc,contact_mode from mp_contact_mode_lang_vw where language_id='"+locale+"' and contact_mode in ('PRN','ORN') order by contact_mode desc";
                                if(oth_rset!=null) oth_rset.close();
								if(oth_stmt!=null) oth_stmt.close();
								oth_stmt = con.prepareStatement(sql);
							    oth_rset = oth_stmt.executeQuery();	

                                if(oth_rset.next())
                                {
								   //Modified for this SCF AAKH-SCF-0261							
                                    out.println("<td  class='label'  >"+oth_rset.getString(1)+"</td>");
                                    out.println("<td class='fields'>") ;
                                    out.println("<input type='text' name='contact1_no' id='contact1_no' maxlength='20' size='13' value=\""+a_res_tel_no+"\"  onblur='makeValidString(this);return isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);'>") ;
                                    out.println("<input type='hidden' name='contact1_mode' id='contact1_mode' maxlength='20' size='13' value=\""+oth_rset.getString(2)+"\"  onblur='makeValidString(this);'>") ;
                                    out.println("</td>") ;
                                }
                                else
                                {
								   //Modified for this SCF AAKH-SCF-0261
								   
                                    out.println("<td class='fields'>") ;
                                    out.println("<input type='text' name='contact1_no' id='contact1_no' maxlength='20' size='13' value=\""+a_res_tel_no+"\"  onblur='makeValidString(this);return isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);'>") ;
                                    out.println("<input type='hidden' name='contact1_mode' id='contact1_mode' maxlength='20' size='13' value=\"\"  onblur='makeValidString(this);'>") ;
                                }
								if(mobile_no_reqd_yn.equals("Y")){ 
								   mobile_no_visibility = "visibility:visible";}
                                if(oth_rset.next())
                                {
								   //Modified for this SCF AAKH-SCF-0261
								   
									out.println("<td class='label'  >"+oth_rset.getString(1)+"</td> ");
                                    out.println("<td class='fields'>") ;
                                    out.println("<input type='text' name='contact2_no' id='contact2_no' maxlength='20' size='13' value= \""+a_oth_contact_no+"\"  onblur='makeValidString(this);return isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);' >") ;
									// New Image  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
									out.println("<img id='id3' src='../images/mandatory.gif' style='"+mobile_no_visibility+"'</img>");
									out.println("<input type='hidden' name='contact2_mode' id='contact2_mode' maxlength='20' size='13' value=\""+oth_rset.getString(2)+"\"  ") ;
                                    out.println("</td>") ;
                                }
                                else
                                {
								   //Modified for this SCF AAKH-SCF-0261
								   
                                    out.println("<td  class='fields'>") ;
                                    out.println("<input type='text' name='contact2_no' id='contact2_no' maxlength='20' size='13' value= \""+a_oth_contact_no+"\"  onblur='makeValidString(this);return isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);' >") ;
                                    out.println("<input type='hidden' name='contact2_mode' id='contact2_mode' maxlength='20' size='13' value=\"\" >") ;
                                    out.println("</td>") ;
                                }
								
							//Below line added for this CRF ML-MMOH-CRF-0860.2
						    if(increasedaddressLength){							
							if(email_id_reqd_yn.equals("Y")){email_visibility = "visibility:visible";} 							
							out.println("<td class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"</td>");
							out.println("<td class='fields'><input type='text' name='email' id='email' maxlength=50 size=34.5 value='"+a_email_id+"'  onblur='makeValidString(this);'><img id='id4' src='../images/mandatory.gif' style='"+email_visibility+"'</img></td>");
							}
							//End this CRF ML-MMOH-CRF-0860.2
							
								
							out.println("</tr>");
							
							//Below line added for this CRF ML-MMOH-CRF-0860.2
						    if(!increasedaddressLength){
							// Condition & Iamge Newly Added against KDAH-CRF-0273 [IN:045012]  By saanthaakumar
							if(email_id_reqd_yn.equals("Y")){
							email_visibility = "visibility:visible";} 
							out.println("<tr><td class='label'  >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels")+"</td>");
							out.println("<td class='fields'><input type='text' name='email' id='email' maxlength=50 size=34.5 value='"+a_email_id+"'  onblur='makeValidString(this);'><img id='id4' src='../images/mandatory.gif' style='"+email_visibility+"'</img></td><td class='label' colspan='2' ></td></tr>");
                            if (oth_rset != null)    oth_rset.close() ;
                            %>
                        </tr>
                       <%
					   }//End this CRF ML-MMOH-CRF-0860.2
					   
					   String enabledisable = "disabled";
					   codes = new ArrayList() ; 
					   descs = new ArrayList() ;
					   sql = "select contact_mode,short_desc from mp_contact_mode_lang_vw where language_id='"+locale+"' and eff_status='E' and contact_mode not in ('PRN','ORN') order by 2";
						if(oth_rset!=null) oth_rset.close();
						if(oth_stmt!=null) oth_stmt.close();
						oth_stmt = con.prepareStatement(sql);
						oth_rset = oth_stmt.executeQuery();	
						if(oth_rset!=null) {
							 enabledisable = ""; 
							while (oth_rset.next()) {
							   codes .add(oth_rset.getString(1));
							   descs .add(oth_rset.getString(2));
							}
						}
						contactmode = codes.toArray();   
						contactdesc = descs.toArray();

						codes = null; 
						descs = null;
						if( oth_rset != null )  oth_rset.close();
					/*
						sql = "select contact_mode,short_desc from mp_contact_mode_lang_vw  where language_id='"+locale+"' and eff_status='E' and contact_mode not in ('PRN','ORN') order by 2";
						if(oth_rset!=null) oth_rset.close();
						if(oth_stmt!=null) oth_stmt.close();
						oth_stmt = con.prepareStatement(sql);
						oth_rset = oth_stmt.executeQuery();	
													
						//String enabledisable = "disabled";
						if (oth_rset.next()) enabledisable = ""; 
						*/
						
						
						
						//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){%>
						 <tr>
						<td class='label'><fmt:message key="eMP.othermodes.label" bundle="${mp_labels}"/> </td>
						<td class='fields'>
							<select name='contact3_mode' id='contact3_mode' <%=enabledisable%>  onchange='enableContactNo(this)'>
							<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
							<% for(int i=0;i<contactmode.length;i++) { %>
							<option value="<%=contactmode[i]%>"><%=contactdesc[i]%></option>
							<%}%>
							</select><input type='text' name='contact3_no' id='contact3_no' maxlength='20' size='13'   disabled onChange='func1();makeValidString(this);' value=''>
						</td>
						<td class='label' >&nbsp;</td>
						<td class='fields'><select name='contact4_mode' id='contact4_mode' <%=enabledisable%>  onchange='enableContactNo(this)'>
							<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
							<%
							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							%>
							</select><input type='text' name='contact4_no' id='contact4_no' maxlength='20' size='13'  disabled onchange='func2();makeValidString(this);' value=""></td>
						<td class='label'>&nbsp;</td>
						<td class='fields'><select name='contact5_mode' id='contact5_mode' <%=enabledisable%>  onchange='enableContactNo(this)'>
							<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
							<%
							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							%>
							</select><input type='text' name='contact5_no' id='contact5_no' maxlength='20' size='13'  disabled onblur='makeValidString(this);'value=""></td>
						</tr>
						
						<%}else{%>
						<tr>
						<td class='label'><fmt:message key="eMP.othermodes.label" bundle="${mp_labels}"/> </td>
						<td class='fields'>
							<select name='contact3_mode' id='contact3_mode' <%=enabledisable%>  onchange='enableContactNo(this)'>
							<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
							<% for(int i=0;i<contactmode.length;i++) { %>
							<option value="<%=contactmode[i]%>"><%=contactdesc[i]%></option>
							<%}%>
							</select><input type='text' name='contact3_no' id='contact3_no' maxlength='20' size='13'   disabled onChange='func1();makeValidString(this);' value=''>
						</td>
						<td class='label' colspan='2'></td>
						</tr></tr>
						<td class='label'></td>
						<td class='fields'>
							<select name='contact4_mode' id='contact4_mode' <%=enabledisable%>  onchange='enableContactNo(this)'>
							<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
							<%
							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							%>
							</select><input type='text' name='contact4_no' id='contact4_no' maxlength='20' size='13'  disabled onchange='func2();makeValidString(this);' value="">
						</td>
						<td class='label' colspan='2'></td>
						</tr></tr>
						<td class='fields'></td>
						<td  >
							<select name='contact5_mode' id='contact5_mode' <%=enabledisable%>  onchange='enableContactNo(this)'>
							<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
							<%
							for(int i=0;i<contactmode.length;i++)
							out.println("<option value='"+contactmode[i]+"'>"+contactdesc[i]+ "</option>");
							%>
							</select><input type='text' name='contact5_no' id='contact5_no' maxlength='20' size='13'  disabled onblur='makeValidString(this);'value="">
						<td class='label' colspan='2'></td>
						</td>
						</tr>						
						<% }//End ML-MMOH-CRF-0860.2
						
						for(int i=0; i<cust_fields.length;i++)
								{
									if(cust_fields[i].charAt(0) == 'C' )
									{
									%>
									       <!--Below line added for this CRF ML-MMOH-CRf-0601 -->
										<tr><td class='COLUMNHEADER' <%=colspantd%> ><b><fmt:message key="Common.additionaldetails.label" bundle="${common_labels}"/></b></td></tr>
								<% break;} 
								} %>
						<tr>
<%
							int myflag=0;	
							int custLngth=0;
                            for(int i=0; i<cust_fields.length;i++)
                            {
                                if(cust_fields[i].charAt(0) == 'C' )
                                {
                                    int intind_0	= cust_fields[i].indexOf('`');
									String strcf	= cust_fields[i];	
									String strs1	= strcf.substring(intind_0+1, strcf.length());
														
									int intind_1	= strs1.indexOf('`');
									String lab		= strs1.substring(0, intind_1);
									String strs2	= strs1.substring(intind_1+1, strs1.length());
									int intind_2	= strs2.indexOf('`');
									String size		= strs2.substring(0, intind_2);
									
									String strs3	= strs2.substring(intind_2+1, strs2.length());
									String nme		= strs3.substring(0);
									myflag++;
									out.println("<td class='label'>"+lab+"</td>");
                                    out.println("<td class='fields'><input type='text' name='"+nme+"' id='"+nme+"' maxlength='"+size+"' size='"+size+"'  value=\"\" onblur='makeValidString(this);' value=\"\"></td>");
									if (myflag%2==0)
										out.println("</tr><tr>");
                                }
								custLngth = i;
                            }
							if (myflag%2 != 0)
							{
								out.println("<td class='label' colspan='2'></td></tr>");
							}
                        %>
                        </table>
					</td>
					</tr>
				  </table>
			</div>
           
		    <!-- <a name='kin'></a> -->
			<div id = 'NextOfKin' style = 'display:none'>
			<table cellspacing='0' cellpadding='0' width='100%' border=0>
			<tr>
				<td class="white">
					<ul id="tablist" class="tablist">
						<li class="tablistitem" title="<fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/>">
							<a onclick="invokeTab('kin')" class="tabClicked" id = 'kin'>
								<span class="tabSpanclicked" id="kinspan"><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></span>
							</a>
						</li>
						<li class="tablistitem" title="Contact Mode and Address details">
							<a onclick="invokeTab('kin1')" class="tabA" id = 'kin1'>
								<span class="tabAspan" id="kin1span"><fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/> </span>
							</a>
						</li>
						<li class="tablistitem" title="<fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/>">
							<a onclick="invokeTab('empyr')" class="tabA" id = 'empyr'>
								<span class="tabAspan" id="empyrspan"><fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/></span>
							</a>
						</li>	
					</ul>
				</td>
			</tr>
			</table>
			<table cellspacing='0' cellpadding='0' width='100%' border='0'>
            <tr>
				<td valign=top width='45%'>
				<table cellspacing='0' cellpadding='2' border='0' width='100%'>
				<tr>
					<td  class='label' width='40%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
					<!--Below line modified for ML-MMOH-CRF-0887.1-->
					<td class='fields' width='60%'><%if(increasedaddressLength){%>
					<textarea name='next_contact_name' rows=3 maxlength=80 cols=45 onblur='makeValidString(this); maxLengthPaste(this);' onkeypress='checkMaxLimit(this,80)' onkeyup='RemoveSpecialChar(this)'><%=nkin_contact_name%></textarea>
					<%}else{%>
					<input type="text" name="next_contact_name" id="next_contact_name" value='<%=nkin_contact_name%>' maxlength='80' size='30'>
					<%}%>
					<!--above next_contact name length change against CRF-0887 by mano on 25/7/2017-->
					</td>
				</tr>
				<% 
				sql = "select relationship_code,short_desc from mp_relationship_lang_vw where language_id='"+locale+"' and eff_status='E' order by 2";
							
                    codes =new ArrayList();
                    descs =new ArrayList();

					if(oth_rset!=null) oth_rset.close();
					if(oth_stmt!=null) oth_stmt.close();	

                    oth_stmt = con.prepareStatement(sql);
					oth_rset = oth_stmt.executeQuery();	
								
                    while(oth_rset.next())
                    {
                       codes.add(oth_rset.getString(1)) ;
                       descs.add(oth_rset.getString(2)) ;
                    }
                    relationcode = codes.toArray();   
					relationdesc = descs.toArray();
					
                    codes = null; 
                    descs = null;
                    if( oth_rset != null )  oth_rset.close();  
				%> 
				<tr><td  class='label' ><fmt:message key="Common.relationship.label"     bundle="${common_labels}"/></td>
				
								
				 <td  class='fields'> <input type='text' name='next_contact_relation_desc' id='next_contact_relation_desc' size='20' maxlength='20' value="" onblur='if(this.value!=""){searchRelationship(next_contact_relation,next_contact_relation_desc);}else{clearfields();}'   ><input type='button'  id='next_contact_relation_id'  name='next_contact_relation_code_id' id='next_contact_relation_code_id' value='?' class='button' onclick='searchRelationship(this,next_contact_relation_desc)' >
				<input type='hidden' name='next_contact_relation' id='next_contact_relation' value="">	<td> 
					
				</tr>	
				
				<tr>
				<% 
					String nat_on_blurfn_st = "";
					String nat_id_onKeyPress="";
					if(accept_national_id_no_yn.equals("Y")) { 
					nat_on_blurfn_st = "makeValidString(this);validateNationality(this,'"+Site+"','"+def_nat_id_pat_ser_grp+"','"+nat_invoke_routine+"','"+nat_data_source_id+"','"+nat_id_check_digit_id+"','"+nat_id_chk_len+"','N')";

					if(nat_id_accept_alphanumeric_yn.equals("Y"))
					{
						nat_id_onKeyPress = "CheckForAlphaCharsNatID(event);";
					}
					else
					{
						if(nat_id_check_digit_id.equals("M11"))
							nat_id_onKeyPress = "CheckForCharsNatID(event);";
						else
							nat_id_onKeyPress = "allowValidNumber(this,event,2, 0);";
					}					

					%>
				
				<td  class='label'><%=rset.getString("nat_id_prompt")%></td><td class='fields'> <input type='text' name='contact1_new_nat_id_no' id='contact1_new_nat_id_no' maxlength='<%=rset.getString("nat_id_length") %>' size='<%= rset.getString("nat_id_length") %>'  onblur="<%=nat_on_blurfn_st%>" onkeypress='return <%=nat_id_onKeyPress%>' value='<%=contact1_nat_id_no%>'>   
				</td>
				<%}else{%><td  class='label'><input type='hidden' name='contact1_new_nat_id_no' id='contact1_new_nat_id_no' value='' ></td><%}%>
				</tr>
				<%if( rset.getString("alt_id1_type") != null ) {%>
				<tr><td  class='label'><%= (rset.getString("alt_id1_desc") == null? "":rset.getString("alt_id1_desc")) %></td><td class='fields'><input type='hidden' name='contact1_alt_id1_type' id='contact1_alt_id1_type' value= "<%=rset.getString("alt_id1_type")%>"> <input type='text' name='contact1_alt_id1_no' id='contact1_alt_id1_no' maxlength='<%=rset.getString("Alt_Id1_length")%>' size='<%=rset.getString("Alt_Id1_length")%>' onblur='makeValidString(this);' onKeyPress='return SpecialCharRestriction(event)' value= '<%=contact1_alt_id1_no%>' ></td></tr><%}
				if( rset.getString("alt_id2_type") != null ) {%>
				<tr><td  class='label'><%= (rset.getString("alt_id2_desc") == null? "":rset.getString("alt_id2_desc")) %></td><td class='fields'> <input type='hidden' name='contact1_alt_id2_type' id='contact1_alt_id2_type' value= "<%=rset.getString("alt_id2_type")%>"><input type='text' name='contact1_alt_id2_no' id='contact1_alt_id2_no' maxlength='<%=rset.getString("Alt_Id2_length")%>' size='<%=rset.getString("Alt_Id2_length")%>'  onblur='makeValidString(this);' onKeyPress='return SpecialCharRestriction(event)' value= '<%=contact1_alt_id2_no%>' ></td></tr><%}if( rset.getString("alt_id3_type") != null ) {%>
				<tr><td  class='label'><%= (rset.getString("alt_id3_desc") == null? "":rset.getString("alt_id3_desc")) %></td><td class='fields'><input type='hidden' name='contact1_alt_id3_type' id='contact1_alt_id3_type' value= "<%=rset.getString("alt_id3_type")%>"> <input type='text' name='contact1_alt_id3_no' id='contact1_alt_id3_no' maxlength='<%=rset.getString("Alt_Id3_length")%>' size='<%=rset.getString("Alt_Id3_length")%>'  onblur='makeValidString(this);' onKeyPress='return SpecialCharRestriction(event)' value= '<%=contact1_alt_id3_no%>' ></td></tr><%}if( rset.getString("alt_id4_type") != null ) {%>
				<tr><td  class='label'><%= (rset.getString("alt_id4_desc") == null? "":rset.getString("alt_id4_desc")) %></td><td class='fields'><input type='hidden' name='contact1_alt_id4_type' id='contact1_alt_id4_type' value= "<%=rset.getString("alt_id4_type")%>"> <input type='text' name='contact1_alt_id4_no' id='contact1_alt_id4_no' maxlength='<%=rset.getString("Alt_Id4_length")%>' size='<%=rset.getString("Alt_Id4_length")%>'  onblur='makeValidString(this);' onKeyPress='return SpecialCharRestriction(event)' value= '<%=contact1_alt_id4_no%>' ></td></tr><%}%>
				<% if ( Accept_oth_alt_id_yn.equals("Y") )
					{ 
						sql = "SELECT alt_id_type,long_desc SHORT_DESC FROM MP_ALTERNATE_ID_TYPE_lang_vw WHERE language_id='"+locale+"' and alt_id_type NOT IN (SELECT alt_id1_type FROM MP_PARAM where module_id='MP' UNION SELECT NVL(alt_id2_type,1)  FROM MP_PARAM where module_id='MP' UNION SELECT NVL(alt_id3_type,2) FROM MP_PARAM where module_id='MP' UNION SELECT NVL(alt_id4_type,3) FROM MP_PARAM where module_id='MP') and eff_status='E' order by 2";


						if(oth_rset!=null) oth_rset.close();
						if(oth_stmt!=null) oth_stmt.close();
						oth_stmt = con.prepareStatement(sql);
						oth_rset = oth_stmt.executeQuery();	
						
						while(oth_rset != null && oth_rset.next())
						{         
						    acodes.add(oth_rset.getString(1));
							adescs.add(oth_rset.getString(2));
						}
					altidcode = acodes.toArray();
					altiddesc = adescs.toArray();
					%>			
					<tr><td  class='label'><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>
                    <td class='fields' nowrap>
						<select name='contact1_oth_alt_id_type' id='contact1_oth_alt_id_type' onChange='enableOtherAltIdText(this.value)' > 

						<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						 <%
						for(int i=0;i<altidcode.length;i++)
					       out.println("<option value='"+altidcode[i]+"'>"+altiddesc[i]+ "</option>");
					    %>
						</select>
                        <input type='text' name='contact1_oth_alt_id_no' id='contact1_oth_alt_id_no' maxlength='20' size='20'  onblur='makeValidString(this);'  DISABLED value = "<%=nkin_oth_alt_id_no%>"></td></tr><%}%>
				<tr><td  class='label'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
                    <td class='fields'>
                        <input type='text' name='contact1_birth_date' id='contact1_birth_date' id='birthdate1' maxlength='10' size='10' onblur='makeValidString(this);gotoNext(this)' value='<%=contact1_birth_date%>' ><img src='../../eCommon/images/CommonCalendar.gif' id="birthdate"  onClick="document.forms[0].contact1_birth_date.select();return showCalendar('birthdate1');" >
                    </td></tr>	
				<tr><td  class='label'><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td>
                    <td class='fields'>
                        <input type='text' name='next_job_title' id='next_job_title' maxlength='30' size='30'  onblur='makeValidString(this);' value = '<%=nkin_job_title%>'>
                    </td>
					<%
					 
                    for(int i=0; i<cust_fields.length;i++)
                    {
                        if(cust_fields[i].charAt(0) == 'N' )
                        {
                            out.println("<tr>");
                            int intind_0	= cust_fields[i].indexOf('`');
							String strcf	= cust_fields[i];		
							String strs1	= strcf.substring(intind_0+1, strcf.length());
												
							int intind_1	= strs1.indexOf('`');
							String lab		= strs1.substring(0, intind_1);
							String strs2	= strs1.substring(intind_1+1, strs1.length());
							int intind_2	= strs2.indexOf('`');
							String size	= strs2.substring(0, intind_2);
							
							String strs3	= strs2.substring(intind_2+1, strs2.length());
							String nme	= strs3.substring(0);

                            out.println("<td class='label'   >"+lab+"</td>");
                            out.println("<td class='fields'><input type='text' name='"+nme+"' id='"+nme+"' maxlength='"+size+"' size='"+size+"'  onblur='makeValidString(this);' value = \"\"></td>");
                            out.println("</tr>"); 
                      }
                    }
			   %>
				</table>
				</td> 
				<td width='55%'>
				<table cellspacing='0' cellpadding='2' border='0' width='100%'>
				<%																
					out.println("<tr>") ; 
					StringBuffer sbb = new StringBuffer() ;
					StringBuffer sb1b = new StringBuffer() ;
					StringBuffer sbap1 = new StringBuffer() ;
					StringBuffer sbar1 = new StringBuffer() ;
                    StringBuffer fieldValb = new StringBuffer();
                    for(int i=0;i<contact_col_names.length; i++) {
								String  val = contact_fields[i] ;
                                    sbb.append(val) ;
                                     int j=0 ;
                                     int j1=0 ;
                                     String old_val = "" ;
                                     String new_val = "" ;
                                     
					 if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt")) {
						old_val = "r_addr_line1"  ;
						new_val = "next_addr_line1" ;
							 
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt")) {
						old_val = "r_addr_line2" ;
						new_val = "next_addr_line2" ;
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt")) {
						old_val = "r_addr_line3" ;
						new_val = "next_addr_line3" ;
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt")) {
						old_val = "r_addr_line4" ;
						new_val = "next_addr_line4" ;
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
						old_val = "r_town_code" ;
						new_val = "contact1_res_town_code" ;
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("region_prompt")) {
						old_val = "r_region_code" ;
						new_val = "contact1_region_code" ;
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
						old_val = "r_area_code" ;
						new_val = "contact1_res_area_code" ;
					 }                                     
					 else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt")) {
						old_val = "r_postal_code" ;
						new_val = "next_postal_code" ;
					 }
					out.println("<td class='label'  width='50%'  >"+contact_prompts[i]+"</td>") ;	
					while(val.indexOf(old_val) != -1) {
						j = val.indexOf(old_val,j) ;
						sbb = sbb.replace(j,(j+old_val.length()),new_val);
						val = sbb.toString();
					}
					if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
						sbap1.append(val);
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sbap1 = sbap1.replace(j1,(j1+"r_postal_code".length()),"next_postal_code");
							val = sbap1.toString();
						}
					}
					if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
						j1 = 0;
						sbar1.append(val);
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sbar1 = sbar1.replace(j1,(j1+"r_postal_code".length()),"next_postal_code");
							val = sbar1.toString();
						}
					}
					sb1b.append(val) ;
					fieldValb.append("");
					for(int z=0;z<val.length();z++) {
						String tempVal=sb1b.substring(z,z+1);
						if(tempVal.equals("@")) {
							fieldValb.append(++tindex);
						}
						else {
							fieldValb.append(tempVal);
						}
					}
					val = fieldValb.toString();
					out.println("<td width='50%' class='fields' >"+val) ;
					out.println("</td>");
					out.println("</tr>");
	
					sbb.setLength(0);
					sb1b.setLength(0);
					sbap1.setLength(0);
					sbar1.setLength(0);
					fieldValb.setLength(0);
				}%>                
				<tr>
					<td  class='label' ><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type='text' name='next_country_desc' id='next_country_desc'                       size='15' maxlength='15' value='<%=nkin_country_name%>' onblur='if(this.value !="") {searchCountry(contry_code[0],next_country_desc);}else{clearCountryFields(this);} ' ><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,next_country_desc)' >
					<input type='hidden' name='next_country_code' id='next_country_code' value=''>
					</td>
				</tr>
				<tr>
					<td  class='label'><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type='text' name='next_res_tel_no' id='next_res_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value = '<%=nkin_res_tel_no%>'></td>
				</tr>
				<tr>
                    <td  class='label' ><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>
                    <td class='fields'><input type='text' name='contact1_mob_tel_no' id='contact1_mob_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value='<%=nkin_mob_tel_no%>'></td>
				<tr>
					<td  class='label'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
                    <td class='fields'><input type='text' name='next_off_tel_no' id='next_off_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value = '<%=nkin_off_tel_no%>'>
                    </td>
                </tr>
				<tr>
					<td  class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type='text' name='contact1_email_id' id='contact1_email_id' maxlength='50' size='42'  onblur='makeValidString(this);' value = '<%=nkin_email_id%>'>
                    </td>
                </tr></td></tr></table>
			<tr>
		    </table>
			<tr>
			<td>
			<table border = 0 cellspacing='0' cellpadding='2' width='100%'>
			<tr>
					<td class='label' width='25%'>&nbsp;</td>
					
					 <td class='label' width='20%'><!-- <a href='javascript:copyDetails(5)'><fmt:message key="eMP.CopyFirsttoNotify.label" bundle="${mp_labels}"/></a> --></td>
					 <td class='label' width='55%'>
					 <%   
						if(rset.getString("Family_No_Link_Yn").equals("Y"))
						{%>
						<a href='javascript:copyDetails(1)'  id='copy_head' style='visibility:hidden'><fmt:message key="eMP.CopyHeadofFamily.label" bundle="${mp_labels}"/></a>&nbsp;&nbsp;&nbsp;
						<%} %>
						<!--Added by Shagar GDOH-CRF-0111 -->
                     <%if(iSSiteApplicable){%>
					 
					<a href='javascript:copyDetails(2)'><fmt:message key="eMP.CopyPatientAddress.label" bundle="${mp_labels}"/></a>					 
	                  <%}else{%>
					 <a href='javascript:copyDetails(5)'><fmt:message key="eMP.CopyFirsttoNotify.label" bundle="${mp_labels}"/></a>&nbsp;&nbsp;&nbsp;<a href='javascript:copyDetails(2)'><fmt:message key="eMP.CopyPatientAddress.label" bundle="${mp_labels}"/></a>
					 
					 
					 </td>
					 <%}%>
			  </tr>
			  </table>
			</td></tr></table>
			</div>
           <!-- Added for New tab-->		 			
		<!-- <a name='kin1'></a> -->
		<div id = 'FirstToNotify' style = 'display:none'>
		<table cellspacing='0' cellpadding='0' width='100%' border=0>
		<tr>
		<td width= "100%" class="white">
			<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="<fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/>">
				<a onclick="invokeTab('kin')" class="tabA" id='kin'>
					<span class="tabAspan" id="kinspan"><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Contact Mode and Address details">
				<a onclick="invokeTab('kin1')" class="tabClicked" id='kin1'>
					<span class="tabSpanclicked" id="kin1span"> <fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></span>
				</a>
			</li>

			<li class="tablistitem" title="<fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/>">
				<a onclick="invokeTab('empyr')" class="tabA" id='empyr'>
					<span class="tabAspan" id="empyrspan"><fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>	
			</ul>
		</td>
		</tr>
		</table>
        <table border = 0 cellspacing='0' cellpadding='0' width='100%'>
	 	<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
         <tr>
				<td class='bodycolorfilled' width='15%'></td>
				<td>
					<table cellspacing='0' cellpadding='2' width='100%' border='0'>
					<tr>
							<td  class='label'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td><td class='fields'><input type='text' name='first_contact_name' id='first_contact_name' maxlength='80' value="" value='<%=fton_contact_name%>'>
							</td>
						<%//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){%>
						<td  class='label'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
						<td  class='filed'><input type='text' name='first_off_tel_no' id='first_off_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value = '<%=fton_off_tel_no%>'></td>						   
						<%}
						//End ML-MMOH-CRF-0860.2
						%>
					</tr>
					<!-- Below line commented ML-MMOH-CRF-0860.2-->
					<!--<tr>
						<td class='label'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
						<td class='fields'><input type='text' name='first_contact_relation_desc' id='first_contact_relation_desc' size='20' maxlength='20' value="" onblur='if(this.value!=""){searchRelationship(first_contact_relation,first_contact_relation_desc);}else{clearfields();}'>
						<input type='button'  id='first_contact_relation_id'  name='first_contact_relation_code_id' id='first_contact_relation_code_id' value='?' 
						class='button' onclick='searchRelationship(this,first_contact_relation_desc)'><td>
					
						<td  class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
						<td  class='filed'><input type='text' name='contact2_email_id' id='contact2_email_id' maxlength='50' size='45'  onblur='makeValidString(this);' 
						value = ''></td>						   
						
						<input type='hidden' name='first_contact_relation' id='first_contact_relation' value="">
						<input type='hidden' name='relationship_level' id='relationship_level' value="">
					</tr>-->
					<!--End ML-MMOH-CRF-0860.2-->
					<tr>
					   <td class='label'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
					    <td class='fields'><input type='text' name='first_contact_relation_desc' id='first_contact_relation_desc' size='20' maxlength='20' value="" onblur='if(this.value!=""){searchRelationship(first_contact_relation,first_contact_relation_desc);}else{clearfields();}'>
						<input type='button'  id='first_contact_relation_id'  name='first_contact_relation_code_id' id='first_contact_relation_code_id' value='?' 
						class='button' onclick='searchRelationship(this,first_contact_relation_desc)'></td>
						<%//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){%>
						  <td class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
						  <td class='fields'><input type='text' name='contact2_email_id' id='contact2_email_id' maxlength='50' size='45'  onblur='makeValidString(this);' 
						value = '<%=fton_email_id%>'></td>
						<%}//End ML-MMOh-CRF-0860.2%>
						<input type='hidden' name='first_contact_relation' id='first_contact_relation' value="">
						<input type='hidden' name='relationship_level' id='relationship_level' value="">
					</tr>
					<% 
						if(accept_national_id_no_yn.equals("Y")) { 
					%>
					<tr>
						<td  class='label'><%=rset.getString("nat_id_prompt")%></td>
						<td class='fields'><input type='text' name='contact2_nat_id_no' id='contact2_nat_id_no' value=""  maxlength='<%= rset.getString("nat_id_length") %>' size='<%= rset.getString("nat_id_length") %>'  onblur="<%=nat_on_blurfn_st%>" onkeypress='return <%=nat_id_onKeyPress%>'   value='<%=fton_nat_id_no%>' >
						</td>
						<%//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){%>
						<td  class='label' colspan=2><a href='javascript:copyDetails(6)'><fmt:message key="eMP.CopyNextofKin.label" bundle="${mp_labels}"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href='javascript:copyDetails(3)'><fmt:message key="eMP.CopyPatientAddress.label" bundle="${mp_labels}"/></a> </td>
										   
						<%}
						//End ML-MMOh-CRF-0860.2
						%>
					</tr>
					<%}else{%><input type='hidden' name='contact2_nat_id_no' id='contact2_nat_id_no' value='' ><%
					
					
					}
					//added by gomathi.
				 	if(Accept_oth_alt_id_yn.equals("Y")) 
					{ %>
					<tr><td  class='label'><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>
							<td class='fields'><select name='notify_oth_alt_id_type' id='notify_oth_alt_id_type' onchange='nenableAltID()' >
                            <option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
                            <%
						//sql = "select alt_id_type,long_desc SHORT_DESC from mp_alternate_id_type_lang_vw where language_id='"+locale+"' and eff_status='E' order by 2";
						/*
						sql = "SELECT alt_id_type,long_desc SHORT_DESC FROM MP_ALTERNATE_ID_TYPE_lang_vw WHERE language_id='"+locale+"' AND alt_id_type NOT IN (SELECT alt_id1_type FROM MP_PARAM WHERE module_id = 'MP' UNION SELECT NVL(alt_id2_type,1) FROM MP_PARAM WHERE module_id = 'MP' UNION SELECT NVL(alt_id3_type,2) FROM MP_PARAM WHERE module_id = 'MP' UNION SELECT NVL(alt_id4_type,3) FROM MP_PARAM WHERE module_id = 'MP') AND eff_status='E' ORDER BY 2";						
						if(oth_rset!=null) oth_rset.close();
					    if(oth_stmt!=null) oth_stmt.close();
						oth_stmt = con.prepareStatement(sql);
						oth_rset = oth_stmt.executeQuery();
						
						if(oth_rset != null){
						while (oth_rset.next()){          
							out.println ( "<Option value=\""+oth_rset.getString("alt_id_type")+"\" >"+oth_rset.getString("SHORT_DESC")+"</Option>" ) ;
						}
					}*/
					for(int i=0;i<altidcode.length;i++)
					       out.println("<option value='"+altidcode[i]+"'>"+altiddesc[i]+ "</option>");
					%>
                    </select><input type='text' name='notify_oth_alt_id_text' id='notify_oth_alt_id_text' value='<%=fton_alt_id_no%>'  maxlength='20' size='20' disabled onblur='makeValidString(this);' ></td>
					
						<%//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){%>
						<td  class='label' colspan=2><%if(accept_national_id_no_yn.equals("N")){%><a href='javascript:copyDetails(6)'><fmt:message key="eMP.CopyNextofKin.label" bundle="${mp_labels}"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href='javascript:copyDetails(3)'><fmt:message key="eMP.CopyPatientAddress.label" bundle="${mp_labels}"/></a> <%}%></td>		   
						<%}
						//End ML-MMOH-CRF-0860.2
						%>
					
					</tr>
				<%}%>
				<tr>
					<td  class='label'><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td>
                    <td class='fields'>
                        <input type='text' name='first_job_title' id='first_job_title' maxlength='30' size='30'  onblur='makeValidString(this);' value= '<%=fton_job_title%>'>
                    </td>
						<%//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){%>
						<td  class='label' colspan=2><%if(Accept_oth_alt_id_yn.equals("N") && accept_national_id_no_yn.equals("N")){%><a href='javascript:copyDetails(6)'><fmt:message key="eMP.CopyNextofKin.label" bundle="${mp_labels}"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href='javascript:copyDetails(3)'><fmt:message key="eMP.CopyPatientAddress.label" bundle="${mp_labels}"/></a> <%}%></td>
											   
						<%}
						//End ML-MMOh-CRF-0860.2
						%>
				</tr>
				<% out.println("<tr>") ;
					StringBuffer sbc = new StringBuffer();
					StringBuffer sb1c = new StringBuffer() ;
					StringBuffer sbap2 = new StringBuffer() ;
					StringBuffer sbar2 = new StringBuffer() ;
					StringBuffer fieldValc = new StringBuffer();
					
					//Added for ML-MMOH-CRF-0860.2
					String nextofkin_clospan="";
					if(increasedaddressLength) nextofkin_clospan="3";
					//End  ML-MMOH-CRF-0860.2
					
							for (int i=0;i<contact_col_names.length; i++)
                            {
									out.println("<td class='label'  >"+contact_prompts[i]+"</td>") ;
                                    String val = contact_fields[i] ;
                                    sbc.append(val) ;
                                     int j=0 ;
                                     int j1=0 ;
                                     String old_val = "" ;
                                     String new_val = "" ;
                                     
                                     if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                                     {
                                        old_val = "r_addr_line1" ;
                                        new_val = "first_addr_line1" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                                     {
                                        old_val = "r_addr_line2" ;
                                        new_val = "first_addr_line2" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                                     {
                                        old_val = "r_addr_line3" ;
                                        new_val = "first_addr_line3" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                                     {
                                        old_val = "r_addr_line4" ;
                                        new_val = "first_addr_line4" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                                     {
                                        old_val = "r_town_code" ;
                                        new_val = "contact2_res_town_code" ;
                                     }//Added by kumar on 13/03/2003 for region 
									 else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                                     {
                                        old_val = "r_region_code" ;
                                        new_val = "contact2_region_code" ;
                                     }
									 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                                     {
                                        old_val = "r_area_code" ;
                                        new_val = "contact2_res_area_code" ;
                                     }                                     
                                     else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                                     {
                                        old_val = "r_postal_code" ;
                                        new_val = "first_postal_code" ;
                                     }

                                    while(val.indexOf(old_val) != -1)
                                    {
                                        j = val.indexOf(old_val,j) ;
                                        sbc = sbc.replace(j,(j+old_val.length()),new_val);
                                        val = sbc.toString();
                                    }
									if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
									{
										sbap2.append(val);
										while(val.indexOf("r_postal_code") != -1)
										{
											
											j1 = val.indexOf("r_postal_code",j1) ;
											
											sbap2 = sbap2.replace(j1,(j1+"r_postal_code".length()),"first_postal_code");
											val = sbap2.toString();
											
										}
									}
									if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
									{
										j1 = 0;
										sbar2.append(val);
										while(val.indexOf("r_postal_code") != -1)
										{
											
											j1 = val.indexOf("r_postal_code",j1) ;
											
											sbar2 = sbar2.replace(j1,(j1+"r_postal_code".length()),"first_postal_code");
											val = sbar2.toString();
											
										}
									}
                                    sb1c.append(val);
									fieldValc.append("");
									for(int z=0;z<val.length();z++)
									{
										String tempVal=sb1c.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldValc.append(++tindex);
										}
										else
										{
											fieldValc.append(tempVal);
										}
									}
                                  	val = fieldValc.toString();
									//Below line modified for this ML-MMOH-CRF-0860.2
                                    out.println("<td class='fields'  colspan='"+nextofkin_clospan+"' >"+val) ;
							out.println("</td>");
							out.println("</tr>");
							sbc.setLength(0);
							sb1c.setLength(0);
							sbap2.setLength(0);
							sbar2.setLength(0);
							fieldValc.setLength(0);
						}
					%>                
                <tr>
				  <td  class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
                  <td class='fields'><input  type='text' value='<%=fton_country_name%>' name='first_country_desc'  size='15' maxlength='15' onblur='if(this.value !=""){searchCountry(contry_code[0],first_country_desc);}else{clearCountryFields(this);}' ><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,first_country_desc)' ></td>
				  <input type='hidden' name='first_country_code' id='first_country_code' value=''>
				  	<%//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){%>
						<td  class='label'>&nbsp;</td>
						<td  class='filed'>&nbsp;</td>						   
						<%}
						//End ML-MMOh-CRF-0860.2
						%>
                 
                </tr>
				<tr>
				    <td  class='label' ><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>
                    <td class='fields'><input type='text' name='first_res_tel_no' id='first_res_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value = '<%=fton_res_tel_no%>'>
                    </td>
						<%//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){%>
						<td  class='label'>&nbsp;</td>
						<td  class='filed'>&nbsp;</td>						   
						<%}
						//End ML-MMOh-CRF-0860.2
						%>
					</tr>
					<tr>
						<td  class='label' ><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>
						<td class='fields'><input type='text' name='contact2_mob_tel_no' id='contact2_mob_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value = '<%=fton_mob_tel_no%>'>
						</td>
							<%//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){%>
						<td  class='label'>&nbsp;</td>
						<td  class='filed'>&nbsp;</td>						   
						<%}
						//End ML-MMOh-CRF-0860.2
						%>
					</tr>
					
					<%
					//Added for this CRF ML-MMOh-CRF-0860.2
					if(!increasedaddressLength){
					%>					
					<tr>
						   <td  class='label' ><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
		                   <td class='fields'><input type='text' name='first_off_tel_no' id='first_off_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value = '<%=fton_off_tel_no%>'></td>
					</tr>
					<tr>
							 <td  class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
							 <td class='fields'><input type='text' name='contact2_email_id' id='contact2_email_id' maxlength='50' size='45'  onblur='makeValidString(this);' value = '<%=fton_email_id%>'></td>
					</tr>
					
					<tr>
						<td class='label'></td>
						<td class='fields' ><a href='javascript:copyDetails(6)'><fmt:message key="eMP.CopyNextofKin.label" bundle="${mp_labels}"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href='javascript:copyDetails(3)'><fmt:message key="eMP.CopyPatientAddress.label" bundle="${mp_labels}"/></a>
						</td>
					</tr>
                    <%}
					 //End this ML-MMOh-CRF-0860.2
					%>					
				</table>
				<td class='bodycolorfilled' width='15%'></td>
			</tr>
			</table> 
			</div>
			
            <!-- <a name='empyr'></a> -->
			<div id = 'EmplyrDtls' style = 'display:none'>
			<table cellspacing='0' cellpadding='0' width='100%' border=0>
			<tr>
			<td width= "100%" class="white">
				<ul id="tablist" class="tablist" >
				<li class="tablistitem" title="<fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/>">
					<a onclick="invokeTab('kin')" class="tabA" id='kin'>
						<span class="tabAspan" id="kinspan"><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Contact Mode and Address details">
					<a onclick="invokeTab('kin1')" class="tabA" id='kin1'>
						<span class="tabAspan" id="kin1span"> <fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="<fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/>">
					<a onclick="invokeTab('empyr')" class="tabClicked" id='empyr'>
						<span class="tabSpanclicked" id="empyrspan"><fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/></span>
					</a>
				</li>	
			</ul>
		</td>
		</tr>
		</table>
        <table cellspacing='0' cellpadding='2' width='100%' border=0>
		<tr>
                <td align='center' class='COLUMNHEADER' ><fmt:message key="Common.employerdetails.label" bundle="${common_labels}"/></td>
				<td align='center' class='COLUMNHEADER' ><fmt:message key="Common.employeedetails.label" bundle="${common_labels}"/></td>
        </tr>
		<tr>
			<td>
			<table cellspacing='0' cellpadding='2' width='100%' border=0>
			<!--Below line modified for this CRF ML-MMOH-CRF-0860.2 increase the maxlength 30 to 50-->
				<tr>
					<td class='label' ><fmt:message key="Common.orgName.label" bundle="${common_labels}"/></td>
                    <td class='fields'>
                        <input type='text' name='organization_name' id='organization_name' maxlength='<%=maximumLength%>' size='<%=maxsize%>'   onblur='makeValidString(this);' value = "<%=organization_name%>" ></input>
                    </td>	
			
			</tr>
				<tr>
				 <td class='label' ><fmt:message key="eMP.ContactPersonName.label" bundle="${mp_labels}"/></td>
                  <td class='fields'>
                        <input type='text' name='empyr_contact_name' id='empyr_contact_name' maxlength='30' size='30'  onblur='makeValidString(this);' value = "<%=emplr_contact_name%>"></input>
                    </td>
							
			</tr>
				<%
					out.println("<tr>") ; 
					StringBuffer sbd = new StringBuffer() ;
					StringBuffer  sb1d = new StringBuffer() ;
					StringBuffer  sbap3 = new StringBuffer() ;
					StringBuffer  sbar3 = new StringBuffer() ;
					StringBuffer fieldVald = new StringBuffer();
                    for(int i=0;i<contact_col_names.length; i++)
                            {                             
								out.println("<td class='label'  >"+contact_prompts[i]+"</td>") ;	

                                   String val = contact_fields[i] ;
                                    sbd.append(val) ;
                                     int j=0 ;
                                     int j1=0 ;
                                     String old_val = "" ;
                                     String new_val = "" ;
                                     
                                     if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                                     {
                                        old_val = "r_addr_line1" ;
                                        new_val = "employ_addr_line1" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                                     {
                                        old_val = "r_addr_line2" ;
                                        new_val = "employ_addr_line2" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                                     {
                                        old_val = "r_addr_line3" ;
                                        new_val = "employ_addr_line3" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                                     {
                                        old_val = "r_addr_line4" ;
                                        new_val = "employ_addr_line4" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                                     {
                                        old_val = "r_town_code" ;
                                        new_val = "contact3_res_town_code" ;
                                     }//Added by kumar on 13/03/2003 for region 
									 else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                                     {
                                        old_val = "r_region_code" ;
                                        new_val = "contact3_region_code" ;
                                     }
									 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                                     {
                                        old_val = "r_area_code" ;
                                        new_val = "contact3_res_area_code" ;
                                     }                                     
                                     else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                                     {
                                        old_val = "r_postal_code" ;
                                        new_val = "employ_postal_code" ;
                                     }
                                    while(val.indexOf(old_val) != -1)
                                    {
                                        j = val.indexOf(old_val,j) ;
                                        sbd = sbd.replace(j,(j+old_val.length()),new_val);
                                        val = sbd.toString();
                                    }
									if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
									{
										sbap3.append(val);
										while(val.indexOf("r_postal_code") != -1)
										{
											
											j1 = val.indexOf("r_postal_code",j1) ;
											
											sbap3 = sbap3.replace(j1,(j1+"r_postal_code".length()),"employ_postal_code");
											val = sbap3.toString();
											
										}
									}
									if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
									{
										j1 = 0;
										sbar3.append(val);
										while(val.indexOf("r_postal_code") != -1)
										{
											
											j1 = val.indexOf("r_postal_code",j1) ;
											
											sbar3 = sbar3.replace(j1,(j1+"r_postal_code".length()),"employ_postal_code");
											val = sbar3.toString();
											
										}
									}
                                  sb1d.append(val) ;
								  fieldVald.append("");
									for(int z=0;z<val.length();z++)
									{
										String tempVal = sb1d.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldVald.append(++tindex);
										}
										else
										{
											fieldVald.append(tempVal);
										}
									}
                                    val = fieldVald.toString();
									out.println("<td class='fields' >"+val+"</td>") ;
                               		out.println("<td class='label' colspan='2' ></td>");
									out.println("</tr>") ;
	
							    sbd.setLength(0);
								sb1d.setLength(0);
								sbap3.setLength(0);
								sbar3.setLength(0);
								fieldVald.setLength(0);
                            }
						%>              
                <tr>
                    <td  class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/> </td>
                    <td class='fields'><input type='text' name='empyr_country_desc' id='empyr_country_desc'                       size='15' maxlength='15' value='<%=emplr_country_name%>' onblur='if(this.value !=""){searchCountry(contry_code[0],empyr_country_desc);}else {clearCountryFields(this);} ' ><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,empyr_country_desc)' >
					<input type='hidden' name='empyr_country_code' id='empyr_country_code' value=''>
                   </td>
               </tr>
               <tr>
                   <td  class='label'><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>
                   <td >
                       <input type='text' name='res3_tel_no' id='res3_tel_no' size='20' maxlength='20'  onblur='makeValidString(this);' value = "<%=emplr_res_tel_no%>">
                   </td>
                </tr>
				<tr>
                   <td  class='label'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
                   <td class='fields'>
                        <input type='text' name='empyr_off_tel_no' id='empyr_off_tel_no' size='20' maxlength='20'  onblur='makeValidString(this);' value = "<%=emplr_off_tel_no%>">
                   </td>
               </tr>
			   </table>
			</td>
			<td valign=top>
			<table cellspacing='1' cellpadding='2' width='100%' border=0>
			   <tr>
					<td class='label'  ><fmt:message key="Common.employmentid.label" bundle="${common_labels}"/></td>
                    <td class='fields'>
                        <input type='text' name='empyr_eid' id='empyr_eid' maxlength='20' size='20'  onfocus='' onblur='makeValidString(this);' value = "<%=patient_employee_id%>"></input>
                    </td>
				</tr>

				<%if (!a_alt_id1_no.equals("") && dflt_alt_id1_in_emp_id_yn.equals("Y")) { %> 
						<SCRIPT>document.forms[0].empyr_eid.value = '<%=a_alt_id1_no%>';
						document.forms[0].empyr_eid.readOnly = true;</script>
				<%}%>

				<tr>
					<td class='label'  ><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/></td>
				

					<td  class='fields'> <input type='text' name='occ_class_desc' id='occ_class_desc' size='20' maxlength='20' value="" onblur='if(this.value!=""){searchOccupationClass(occ_class,occ_class_desc);sendToServer(15,occ_class);}else{clearfields();clearOccPer(document.forms[0].occ_of_per);} enableocpn_class();'    ><input type='button'  id='occ_class_id'  name='occ_class_code_id2' id='occ_class_code_id2' value='?' class='button' onclick='searchOccupationClass(this,occ_class_desc);if(document.forms[0].occ_class.value!=""){sendToServer(15,occ_class);}' >
					<input type='hidden' name='occ_class' id='occ_class' value=""> </td>

				</tr>
				<tr>
					<td class='label'  ><fmt:message key="eMP.OccupationofthePerson.label" bundle="${mp_labels}"/></td>
                    <td class='fields'>
                        <select name='occ_of_per' id='occ_of_per'  onChange='enableocpn();'>
                            <option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
                        </select>
						<!--Below line added for this CRF ML-MMOH-CRF-0860.2 increase the maxLength from 30 to 50-->
                        <input type='text' name='occu_of_per_desc' id='occu_of_per_desc' size='<%=maxsize%>' maxlength='<%=maximumLength%>' onblur=''  onblur='makeValidString(this);' value = ""></input>
                    </td>
				</tr>
				<tr>
					<td class='label'  ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
                    <td class='fields'>
                        <select name='empyr_employment_status' id='empyr_employment_status'  onblur="document.forms[0].organization_name.focus()" onchange=''>
                            <option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
                            <option value='FE'><fmt:message key="eMP.FullTimeEmployed.label" bundle="${mp_labels}"/></option>
								<option value='FS'><fmt:message key="eMP.FullTimeStudent.label" bundle="${mp_labels}"/></option>
								<option value='NA'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>					
								<option value='PE'><fmt:message key="eMP.PartTimeEmployed.label" bundle="${mp_labels}"/></option>
								<option value='PS'><fmt:message key="eMP.PartTimeStudent.label" bundle="${mp_labels}"/></option>
								<option value='SE'><fmt:message key="eMP.SelfEmployed.label" bundle="${mp_labels}"/></option>
								<option value='UE'><fmt:message key="eMP.Unemployed.label" bundle="${mp_labels}"/></option>
								<option value='UK'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
                        </select>	
					</td>
				</tr>
				<tr>
			<% for(int i=0; i<cust_fields.length;i++)
				{
					if(cust_fields[i].charAt(0) == 'E' )
					{
						out.println("<tr>") ;
						int intind_0	= cust_fields[i].indexOf('`');
						String strcf	= cust_fields[i];		
						String strs1	= strcf.substring(intind_0+1, strcf.length());
											
						int intind_1	= strs1.indexOf('`');
						String lab		= strs1.substring(0, intind_1);
						String strs2	= strs1.substring(intind_1+1, strs1.length());
						int intind_2	= strs2.indexOf('`');
						String size		= strs2.substring(0, intind_2);
						
						String strs3	= strs2.substring(intind_2+1, strs2.length());
						String nme		= strs3.substring(0);

						 out.println("<td class='label'   >"+lab+"</td>");
						out.println("<td class='fields'><input type='text' name='"+nme+"' id='"+nme+"' maxlength='"+size+"' size='"+size+"'  onblur='makeValidString(this);' value = \"\"></td>");
						out.println("</tr>");
				   }
				}
			   %>
				</table>
			</table>
			</div>             
            <!-- <a name='pat_docs_tab'></a> -->
			<div id = 'pat_docs_tab' style = 'display:none'>
            <table width='100%' cellpadding='2' cellspacing='0'>
                <tr>
                    <td  class='COLUMNHEADER' ><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
                    <td  class='COLUMNHEADER' ><fmt:message key="Common.documentno.label" bundle="${common_labels}"/></td>
                    <td  class='COLUMNHEADER' ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
                    <td  class='COLUMNHEADER' ><fmt:message key="eMP.PlaceOfIssue.label" bundle="${mp_labels}"/></td>
                    <td  class='COLUMNHEADER' ><fmt:message key="Common.IssueDate.label" bundle="${common_labels}"/></td>
					<!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->
					<td  class='COLUMNHEADER' ><fmt:message key="Common.UplodDoc.label" bundle="${common_labels}"/></td>
					 <!--   end PMG2012-CRF-0006 [IN034693]   -->
                </tr>

                <%
                    codes = new ArrayList();
                    descs = new ArrayList();
					/*Modified By Dharma on Feb 11th 2015 against ML-HSA-SCF-0192 [IN:053070] Start*/
                   // sql="Select doc_type,initcap(short_desc)short_name from mp_document_type_lang_vw where language_id='"+locale+"' and  EFF_STATUS='E' order by 2 ";
				    sql="Select doc_type,short_desc short_name from mp_document_type_lang_vw where language_id='"+locale+"' and  EFF_STATUS='E' order by 2 ";
					/*Modified By Dharma on Feb 11th 2015 against ML-HSA-SCF-0192 [IN:053070] End*/
					if(oth_rset!=null) oth_rset.close();
					if(oth_stmt!=null) oth_stmt.close();
                    oth_stmt = con.prepareStatement(sql);
					oth_rset = oth_stmt.executeQuery();	

                    while(oth_rset.next())
                    {
                        codes.add( oth_rset.getString(1) ) ;
                        descs.add( oth_rset.getString(2) ) ;
                    } 

                    oth_code  = codes.toArray();
                    oth_desc  = descs.toArray();

                    codes = null ;
                    descs = null ;
                    if(oth_rset!= null) oth_rset.close() ;
                %>

                <tr>
                  	<td  class='fields'> <input type='text' name='doc_id1_desc' id='doc_id1_desc' size='20' maxlength='20' value="" onblur='if(this.value!=""){searchDocumentType(doc_id1,doc_id1_desc);}else{clearfields();} enbl_disble(this);'   ><input type='button'  id='doc1_id'  name='doc_code_id1' id='doc_code_id1' value='?' class='button' onclick='searchDocumentType(this,doc_id1_desc); enbl_disble(doc_id1_desc);' >
					<input type='hidden' name='doc_id1' id='doc_id1' value="">
					
					</td>
                    
                    <td class='fields'>
						<%if(!doc1_num.equals("")){%>
						<input type='text' name='doc_num1' id='doc_num1'  size=15 maxlength=15  onblur='makeValidString(this);' value="<%=doc1_num%>">
						<%}else{%>
						<input type='text' name='doc_num1' id='doc_num1' value="" size=15 maxlength=15  onblur='makeValidString(this);' disabled value =''>
						<%}%>
						<img id='doc1' style='visibility:hidden' src='../../eCommon/images/mandatory.gif'></img>
                    </td>
                    
                    <td class='fields'>
                        <!--<input type='text' name='doc_exp_dt1' id='doc_exp_dt1' id="docexpdt1" size=10 maxlength=10  onblur = 'validDateObj(this,"DMY",localeName);return ChkForIssueDate(this,document.forms[0].issue_date1);' disabled  onblur='makeValidString(this);' value ='<%=doc1_exp_date%>'>--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->
						<input type='text' name='doc_exp_dt1' id='doc_exp_dt1' id="docexpdt1" size=10 maxlength=10  onblur = 'validDateObj(this,"DMY","<%=localeName%>");return ChkForIssueDate(this,document.forms[0].issue_date1);' disabled  onblur='makeValidString(this);' value ='<%=doc1_exp_date%>'><img src='../../eCommon/images/CommonCalendar.gif' id="docexpdate1" disabled onClick="document.forms[0].doc_exp_dt1.select();return showCalendar('docexpdt1');" >
                    </td>											  
                    
                    <td class='fields'>
                        <input type='text' name='place_of_issue1' id='place_of_issue1' size=30 maxlength=30 disabled  onblur='makeValidString(this);' value="<%=doc1_place_of_issue%>">
                    </td>
                    <td class='fields'>
                        <!--<input type='text' name='issue_date1' id='issue_date1' id="issuedate1" value='<%=doc1_iss_date%>' size=10 maxlength=10  onblur='validDateObj(this,"DMY",localeName);return ChkForIssueDate(this,document.forms[0].issue_date1);' disabled  onblur='makeValidString(this);' value=''>--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->
						<input type='text' name='issue_date1' id='issue_date1' id="issuedate1" value='<%=doc1_iss_date%>' size=10 maxlength=10  onblur='validDateObj(this,"DMY","<%=localeName%>");return ChkForIssueDate(this,document.forms[0].issue_date1);' disabled  onblur='makeValidString(this);' value=''><img src='../../eCommon/images/CommonCalendar.gif' id="issuedt1" disabled onClick="document.forms[0].issue_date1.select();return showCalendar('issuedate1');" >
                    </td>
					<!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->
				 	<td class='fields'><div id='doc1imageId'> <input type='file' name='doc1image' id='doc1image' disabled  value=''  size=40 maxlength=40  onkeypress='return onkeyPressEvent(event);' onblur='ValidateFileType(this)'><!-- This line modified to include div tag for the incident 38504 to clear the file path.-->
					 <!--   end PMG2012-CRF-0006 [IN034693]   -->
					<!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->
					<%
					String sFacilityId = Facility;
					int iDocScanEnabled = 0;
					String document_id="";

					int iDocFolderOption = 0;
					
					List<DocumentConfigBean> oDocConfigList = null;
					List<DocumentTypeBean> oDocTypeList = null;  
					DocumentConfigBean oDocumentConfigBean = null;	
					
					DocumentConfigOption docConfigOption = new DocumentConfigOption(); 		
					oDocConfigList = new ArrayList<DocumentConfigBean>();
					oDocConfigList = docConfigOption.getDocumentConfigDetails(sFacilityId);
					int nDocConfigListsize = oDocConfigList.size();
					if (nDocConfigListsize>0)
					{						
					oDocumentConfigBean = oDocConfigList.get(nDocConfigListsize-1);		
					sFacilityId 	= oDocumentConfigBean.getsFacilityId();
					iDocScanEnabled = oDocumentConfigBean.getiDocScanEnabled();
					iDocFolderOption = oDocumentConfigBean.getiDocFolderOption();
							
					}	
					
					document_id ="doc_id1"+(String) session.getValue( "login_user" )+Long.toString(System.currentTimeMillis());
					%>	
					
					<input type='button' name='doc1scan' id='doc1scan'  value='Scan' disabled  size=4  onClick="ShowScanner('<%=patient_id%>','MP','<%=document_id%>',this);" style='visibility:hidden'> 
					 </div></td></td>
					 <input type='hidden' name='iDocFolderOption' id='iDocFolderOption' value="<%=iDocFolderOption%>">
					<input type='hidden' name='iDocScanEnabled' id='iDocScanEnabled' value="<%=iDocScanEnabled%>">
					 <input type='hidden' name='document_id1' id='document_id1' value="<%=document_id%>">
					 <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->
                </tr>
                
                <tr>
					<!-- Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 - added 'disabled' for doc_id2_desc & doc2_code_id2 -->
         			<td  class='fields'> <input type='text' name='doc_id2_desc' id='doc_id2_desc' size='20' maxlength='20' value="" disabled onblur='if(this.value!=""){searchDocumentType(doc_id2,doc_id2_desc);}else{clearfields();} enbl_disble(this);'    ><input type='button'  id='doc2_id'  name='doc2_code_id2' id='doc2_code_id2' value='?' disabled class='button' onclick='searchDocumentType(this,doc_id2_desc); enbl_disble(doc_id2_desc);'  >
					<input type='hidden' name='doc_id2' id='doc_id2' value="">


                    <td class='fields'>
                        <input type='text' name='doc_num2' id='doc_num2' size=15 maxlength=15 disabled  onblur='makeValidString(this);' value='<%=doc2_num%>'>
						<img id='doc2' style='visibility:hidden' src='../../eCommon/images/mandatory.gif'></img>
                    </td>
                    <td class='fields'>
                        <!--<input type='text' name='doc_exp_dt2' id='doc_exp_dt2' id = "docexpdt2" size=10 maxlength=10 disabled onblur = 'validDateObj(this,"DMY",localeName);return ChkForIssueDate(this,document.forms[0].issue_date2);'  onblur='makeValidString(this);' value='<%=doc2_exp_date%>'>--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->
						<input type='text' name='doc_exp_dt2' id='doc_exp_dt2' id = "docexpdt2" size=10 maxlength=10 disabled onblur = 'validDateObj(this,"DMY","<%=localeName%>");return ChkForIssueDate(this,document.forms[0].issue_date2);'  onblur='makeValidString(this);' value='<%=doc2_exp_date%>'><img src='../../eCommon/images/CommonCalendar.gif' id="docexpdate2" disabled onClick="document.forms[0].doc_exp_dt2.select();return showCalendar('docexpdt2');" >
                    </td>
                    
                    <td class='fields'>
                        <input type='text' name='place_of_issue2' id='place_of_issue2' size=30 maxlength=30 disabled  onblur='makeValidString(this);' value='<%=doc2_place_of_issue%>'>
                    </td>
                    <td>
                        <!--<input type='text' name='issue_date2' id='issue_date2' id="issuedate2" value="<%=doc2_iss_date%>" size=10 maxlength=10 disabled onblur='validDateObj(this,"DMY",localeName);return ChkForIssueDate(this,document.forms[0].issue_date2);return validatIssueDatechk(this,doc_exp_dt2)'  onblur='makeValidString(this);' value=''> --><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->
						<input type='text' name='issue_date2' id='issue_date2' id="issuedate2" value="<%=doc2_iss_date%>" size=10 maxlength=10 disabled onblur='validDateObj(this,"DMY","<%=localeName%>");return ChkForIssueDate(this,document.forms[0].issue_date2);return validatIssueDatechk(this,doc_exp_dt2)'  onblur='makeValidString(this);' value=''><img src='../../eCommon/images/CommonCalendar.gif' id="issuedt2" disabled onClick="document.forms[0].issue_date2.select();return showCalendar('issuedate2');" >
                    </td>
					<!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->
					<td class='fields'> <div id='doc2imageId'><input type='file' name='doc2image' id='doc2image' disabled  value=''  size=40 maxlength=40  onkeypress='return onkeyPressEvent(event);' onblur='ValidateFileType(this)'><!-- This line modified to include div tag for the incident 38504 to clear the file path.-->
					 <!--   end PMG2012-CRF-0006 [IN034693]   -->
					 <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->
					 <%
					document_id ="doc_id2"+(String) session.getValue( "login_user" )+Long.toString(System.currentTimeMillis());
					%>
					
					 <input type='button' name='doc2scan' id='doc2scan'  value='Scan' disabled  size=4  onClick="ShowScanner('<%=patient_id%>','MP','<%=document_id%>',this);" style='visibility:hidden'>
					  </div></td>
					   <input type='hidden' name='document_id2' id='document_id2' value='<%=document_id%>'>
					  <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->
                </tr>
                
                <tr>
					<!-- Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 - added 'disabled' for doc_id3_desc & doc3_code_id3 -->
                 	<td  class='fields'> <input type='text' name='doc_id3_desc' id='doc_id3_desc' size='20' maxlength='20' value="" disabled onblur='if(this.value!=""){searchDocumentType(doc_id3,doc_id3_desc);}else{clearfields();} enbl_disble(this);'   ><input type='button'  id='doc3_id'  name='doc3_code_id3' id='doc3_code_id3' value='?' disabled class='button' onclick='searchDocumentType(this,doc_id3_desc); enbl_disble(doc_id3_desc);'  >
					<input type='hidden' name='doc_id3' id='doc_id3' value="">

                    <td class='fields'>
                        <input type='text' name='doc_num3' id='doc_num3' size=15 maxlength=15 disabled  onblur='makeValidString(this);' value="<%=doc3_num%>">
						<img id='doc3' style='visibility:hidden' src='../../eCommon/images/mandatory.gif'></img>
                    </td>
                    <td class='fields'>
                        <!--<input type='text' name='doc_exp_dt3' id='doc_exp_dt3' id="docexpdt3" size=10 maxlength=10 disabled  onblur='validDateObj(this,"DMY",localeName);return ChkForIssueDate(this,document.forms[0].issue_date3);'  onblur='makeValidString(this);' value="<%=doc3_exp_date%>">--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->
						<input type='text' name='doc_exp_dt3' id='doc_exp_dt3' id="docexpdt3" size=10 maxlength=10 disabled  onblur='validDateObj(this,"DMY","<%=localeName%>");return ChkForIssueDate(this,document.forms[0].issue_date3);'  onblur='makeValidString(this);' value="<%=doc3_exp_date%>"><img src='../../eCommon/images/CommonCalendar.gif' id="docexpdate3" disabled onClick="document.forms[0].doc_exp_dt3.select();return showCalendar('docexpdt3');" >
                    </td>
                    
                    <td class='fields'>
                        <input type='text' name='place_of_issue3' id='place_of_issue3' size=30 maxlength=30 disabled  onblur='makeValidString(this);' value="<%=doc3_place_of_issue%>">
                    </td>
                    <td class='fields'>
                        <!--<input type='text' name='issue_date3' id='issue_date3' id="issuedate3" value="<%=doc3_iss_date%>" size=10 maxlength=10 disabled onblur='validDateObj(this,"DMY",localeName);return ChkForIssueDate(this,document.forms[0].issue_date3);return validatIssueDatechk(this,doc_exp_dt3)'  onblur='makeValidString(this);' value = "">--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->
						<input type='text' name='issue_date3' id='issue_date3' id="issuedate3" value="<%=doc3_iss_date%>" size=10 maxlength=10 disabled onblur='validDateObj(this,"DMY","<%=localeName%>");return ChkForIssueDate(this,document.forms[0].issue_date3);return validatIssueDatechk(this,doc_exp_dt3)'  onblur='makeValidString(this);' value = ""><img src='../../eCommon/images/CommonCalendar.gif' id="issuedt3" disabled onClick="document.forms[0].issue_date3.select();return showCalendar('issuedate3');" >
                    </td>
					  <!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->
					<td class='fields'><div id='doc3imageId'> <input type='file' name='doc3image' id='doc3image' disabled  value=''  size=40 maxlength=40  onkeypress='return onkeyPressEvent(event);' onblur='ValidateFileType(this)'><!-- This line modified to include div tag for the incident 38504 to clear the file path.-->
					 <!--   end PMG2012-CRF-0006 [IN034693]   -->
					  <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->
					   <%
					document_id ="doc_id3"+(String) session.getValue( "login_user" )+Long.toString(System.currentTimeMillis());
					%>
					 
					 <input type='button' name='doc3scan' id='doc3scan'  value='Scan' disabled  size=4  onClick="ShowScanner('<%=patient_id%>','MP','<%=document_id%>',this);" style='visibility:hidden'>
					  </div></td>
					   <input type='hidden' name='document_id3' id='document_id3' value='<%=document_id%>'>
					  <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->
                </tr>
                
                <tr>
					<!-- Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 - added 'disabled' for doc_id4_desc & doc4_code_id4 -->
           			<td  class='fields'> <input type='text' name='doc_id4_desc' id='doc_id4_desc' size='20' maxlength='20' value="" disabled onblur='if(this.value!=""){searchDocumentType(doc_id4,doc_id4_desc);}else{clearfields();} enbl_disble(this);'   ><input type='button'  id='doc4_id'  name='doc4_code_id4' id='doc4_code_id4' value='?' disabled class='button' onclick='searchDocumentType(this,doc_id4_desc); enbl_disble(doc_id4_desc);'  >
					<input type='hidden' name='doc_id4' id='doc_id4' value="">
                    
                    <td class='fields'>
                        <input type='text' name='doc_num4' id='doc_num4' value="<%=doc4_num%>" size=15 maxlength=15 disabled  onblur='makeValidString(this);'>
						<img id='doc4' style='visibility:hidden' src='../../eCommon/images/mandatory.gif'></img>
                    </td>
                    
                    <td class='fields'>
                        <!--<input type='text' name='doc_exp_dt4' id='doc_exp_dt4' id="docexpdt4" size=10 maxlength=10 disabled onblur='validDateObj(this,"DMY",localeName);return ChkForIssueDate(this,document.forms[0].issue_date4);'  onblur='makeValidString(this);' value = "<%=doc4_exp_date%>">--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->
						<input type='text' name='doc_exp_dt4' id='doc_exp_dt4' id="docexpdt4" size=10 maxlength=10 disabled onblur='validDateObj(this,"DMY","<%=localeName%>");return ChkForIssueDate(this,document.forms[0].issue_date4);'  onblur='makeValidString(this);' value = "<%=doc4_exp_date%>"><img src='../../eCommon/images/CommonCalendar.gif' id="docexpdate4" disabled onClick="document.forms[0].doc_exp_dt4.select();return showCalendar('docexpdt4');" >
                    </td>
                    
                    <td class='fields'>
                        <input type='text' name='place_of_issue4' id='place_of_issue4' value="<%=doc4_place_of_issue%>" size=30 maxlength=30 disabled  onblur='makeValidString(this);' >
                    </td>
                    <td class='fields'>
                        <!--<input type='text' name='issue_date4' id='issue_date4' id="issuedate4" value="<%=doc4_iss_date%>" size=10 maxlength=10 disabled onblur='validDateObj(this,"DMY",localeName);return ChkForIssueDate(this,document.forms[0].issue_date4);return validatIssueDatechk(this,doc_exp_dt4)'  onblur='makeValidString(this);'>--><!--Commented and below line changed by Rameswar on 01-Oct-15 for Leap Year Issue-->
						<input type='text' name='issue_date4' id='issue_date4' id="issuedate4" value="<%=doc4_iss_date%>" size=10 maxlength=10 disabled onblur='validDateObj(this,"DMY","<%=localeName%>");return ChkForIssueDate(this,document.forms[0].issue_date4);return validatIssueDatechk(this,doc_exp_dt4)'  onblur='makeValidString(this);'><img src='../../eCommon/images/CommonCalendar.gif' id="issuedt4" disabled onClick="document.forms[0].issue_date4.select();return showCalendar('issuedate4');" >
                    </td>
					<!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->
					<td class='fields'><div id='doc4imageId'> <input type='file' name='doc4image' id='doc4image' disabled  value=''  size=40 maxlength=40  onkeypress='return onkeyPressEvent(event);' onblur='ValidateFileType(this)'><!-- This line modified to include div tag for the incident 38504 to clear the file path.-->
					<!--   end PMG2012-CRF-0006 [IN034693]   -->
					 <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->
					 <%
					document_id ="doc_id4"+(String) session.getValue( "login_user" )+Long.toString(System.currentTimeMillis());
					%>
					 
					 <input type='button' name='doc4scan' id='doc4scan'  value='Scan' disabled  size=4  onClick="ShowScanner('<%=patient_id%>','MP','<%=document_id%>',this);" style='visibility:hidden'>
					  </div></td>
					   <input type='hidden' name='document_id4' id='document_id4' value='<%=document_id%>'>
					  <!--Added by Rameswar on  15-03-2016 for  MMS-DM-CRF-0035-->
					
                </tr>
            </table>
			<br>

				<table width='100%' cellpadding='2' cellspacing='0'>
                <tr>
                    <td  class='COLUMNHEADER' colspan='4'><fmt:message key="Common.Miscellaneous.label" bundle="${common_labels}"/></td>
                </tr>
                <tr>
                    <td  class='label' ><fmt:message key="Common.Dependency.label" bundle="${common_labels}"/></td>

                    <td  class='fields' colspan='3'>
                        <select name='living_dependency' id='living_dependency'>
                            <option value='UN'><fmt:message key="Common.NotKnown.label" bundle="${common_labels}"/></option>
                            <option value='D'><fmt:message key="eMP.SpouseDependent.label" bundle="${mp_labels}"/></option>
                            <option value='M'><fmt:message key="eMP.MedicalSupervisionReqd.label" bundle="${mp_labels}"/></option>
                            <option value='S'><fmt:message key="eMP.SmallChildren.label" bundle="${mp_labels}"/></option>
                            <option value='WU'><fmt:message key="eMP.WalkUp.label" bundle="${mp_labels}"/></option>
                        </select><img src='../../eCommon/images/mandatory.gif'></img>
                    </td>
			   </tr>
                <tr>
                    <td  class='label' ><fmt:message key="eMP.Arrangement.label" bundle="${mp_labels}"/></td>
                    <td class='fields' colspan='3'>
                        <select name='living_arrangement' id='living_arrangement' >
                            <option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/> </option>
                            <option value='A'><fmt:message key="eMP.Alone.label" bundle="${mp_labels}"/></option>
                            <option value='F'><fmt:message key="eMP.family.label" bundle="${mp_labels}"/></option>
                            <option value='R'><fmt:message key="eMP.relative.label" bundle="${mp_labels}"/> </option>
                            <option value='S'><fmt:message key="eMP.spouseonly.label" bundle="${mp_labels}"/> </option>
                        </select><img src='../../eCommon/images/mandatory.gif'></img>
                    </td>
                </tr>
                
                <tr>
                    <td class='label' ><fmt:message key="eMP.EducationLevel.label" bundle="${mp_labels}"/></td>
             		<td  class='fields'> <input type='text' name='education_level_desc' id='education_level_desc' size='20' maxlength='20' value="" onblur='if(this.value!=""){searchEducation(education_level,education_level_desc);}else{clearfields();}'   ><input type='button'  id='education_level_id'  name='education_level_id1' id='education_level_id1' value='?' class='button' onclick='searchEducation(this,education_level_desc)' >
					<input type='hidden' name='education_level' id='education_level' value="">
					
					</td>

                </tr>
                
                <tr><td  class='bodycolorfilled' colspan=5></td></tr>
                <tr><td  class='COLUMNHEADER' colspan=5><fmt:message key="eMP.RegistrationSource.label" bundle="${mp_labels}"/></td></tr>
                <tr>
                    <td  width='25%' class='label' ><fmt:message key="eMP.Informant.label" bundle="${mp_labels}"/></td>
                    <td  width='75%' colspan='4' class='fields'>
                        <input type='text' name='regn_informant' id='regn_informant' maxlength='20' size='20'  onblur='makeValidString(this);' value = '<%=informant%>'></td>
                </tr>

                <tr>
                    <td  width='25%' class='label' ><fmt:message key="eMP.InformantRemarks.label" bundle="${mp_labels}"/></td>
                    <td  class='fields' colspan=3>
                        <font name='verdana'><textarea name='regn_comments' rows='2' cols='45'  onKeyPress='checkMaxLimit(this,100)' onBlur='makeValidString(this);checkLength(this,100)'  value='<%=informant_remarks%>'></textarea></font>
                    </td>
                </tr>

                <tr><td  class='bodycolorfilled' colspan=5></td></tr>
                <tr><td  class='COLUMNHEADER' colspan=5 ><fmt:message key="Common.generalRemarks.label" bundle="${common_labels}"/></td></tr>
               
                <tr>
                    <td width='25%' class='label' ></td>
                    <td width='75%' class='fields' colspan=3>
					<%	
						if(Othersaddlcnt==0){%>    
							<textarea name='general_remarks' rows='5' cols='45'  onKeyPress='checkMaxLimit(this,500)' onblur='makeValidStringRemark(this);checkLength(this,500);'></textarea>
							<%}else{%>
							<textarea name='general_remarks' rows='5' cols='45'  onKeyPress='checkMaxLimit(this,500)' onblur='makeValidStringRemark(this);checkLength(this,500);'><%=general_remarks%></textarea>
								<%}%>
                    </td>
                </tr>
            </table>
			</table>
				<table border='0' cellpadding='2' cellspacing='0' width='100%'>
                   <%
					// Code for additional fields for First Notify tab
                    order=0;
                    for(int i=0; i<cust_fields.length;i++)
                    {
                        if(cust_fields[i].charAt(0) == 'O' )
                        {
                            int intind_0	= cust_fields[i].indexOf('`');
							String strcf	= cust_fields[i];		
							String strs1	= strcf.substring(intind_0+1, strcf.length());
												
							int intind_1	= strs1.indexOf('`');
							String lab		= strs1.substring(0, intind_1);
							String strs2	= strs1.substring(intind_1+1, strs1.length());
							int intind_2	= strs2.indexOf('`');
							String size		= strs2.substring(0, intind_2);
							
							String strs3	= strs2.substring(intind_2+1, strs2.length());
							String nme		= strs3.substring(0);

							if(order == 0)
                            {
                                out.println("<tr></tr><tr></tr><tr>");
                                out.println("<td colspan=2>");
                            }
                            if( order%3 == 0 && order==0)
                            {
								
							out.println("</tr><tr>") ;
							if(Othersaddlcnt==(i+1))
							{
							
                            out.println("<td class='label'   width='13%' >"+lab+"</td>");
							out.println("<td class='fields'><input type='text' name='"+nme+"' id='"+nme+"' maxlength='"+size+"' size='20'  onblur='makeValidString(this);focusBack();' value = \"\"></td>");
							}
							else
							{
							out.println("<td class='label'   width='13%' >"+lab+"</td>");
							out.println("<td class='fields'><input type='text' name='"+nme+"' id='"+nme+"' maxlength='"+size+"' size='20'  onblur='makeValidString(this);' value = \"\"></td>");
							}
                            }
							if( order %3 != 0 && order!=0)
							{
							if(Othersaddlcnt==(i+1))
								{
							
							out.println("<td class='label'   width='15%' >"+lab+"</td>");
							out.println("<td class='fields'><input type='text' name='"+nme+"' id='"+nme+"' maxlength='"+size+"' size='20'  onblur='makeValidString(this);focusBack();' value = \"\"></td>");
								}
							else
								{
								
							out.println("<td class='label'   width='15%' >"+lab+"</td>");
							out.println("<td class='fields'><input type='text' name='"+nme+"' id='"+nme+"' maxlength='"+size+"' size='20'  onblur='makeValidString(this);' value = \"\"></td>");
								}
							}

                            order++;

							
                        }
					}
					// End of the code for additional fields in First Notify Tab
                %>
                </tr>
            </table> 			
<%//Condition  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
try
        {
			
			sql = "SELECT initcap(region_prompt) region_prompt,REGION_APPL_YN,initcap(ADDR_LINE1_PROMPT) addr_line1_prompt,initcap(ADDR_LINE2_PROMPT) addr_line2_prompt,initcap(POSTAL_CODE_PROMPT) postal_code_prompt,initcap(RES_AREA_PROMPT)area_code_prompt, initcap(RES_TOWN_PROMPT)town_code_prompt FROM sm_site_param_LANG_VW where language_id='"+locale+"' ";
			/*Modified by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
			
						if(oth_rset!=null) oth_rset.close();
					    if(oth_stmt!=null) oth_stmt.close();
						oth_stmt = con.prepareStatement(sql);
						oth_rset = oth_stmt.executeQuery();
						
						while (oth_rset.next()){ 
								region_prompt		= oth_rset.getString("region_prompt");
								region_appl_yn		= oth_rset.getString("REGION_APPL_YN");
								/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
								addr_line1_prompt   = oth_rset.getString("addr_line1_prompt");
								addr_line2_prompt   = oth_rset.getString("addr_line2_prompt");
								postal_code_prompt  = oth_rset.getString("postal_code_prompt");
								area_code_prompt    = oth_rset.getString("area_code_prompt");/*Added by shagar for  AMRI-CRF-0388*/
								town_code_prompt    = oth_rset.getString("town_code_prompt");/*Added by Suji keerthi on 27-Nov-2019 for KDAH-CRF-0522*/
								/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
								
			}			if(oth_rset!=null) oth_rset.close();
					    
			 }
			 
		catch(Exception e)
        { }//Ends here%>			
			<script>
				if("<%=nkin_addr_line1%>" != '' && document.getElementById('next_addr_line1') != null)
					document.getElementById('next_addr_line1').value="<%=nkin_addr_line1%>"; 
				if("<%=nkin_addr_line2%>" != '' && document.getElementById('next_addr_line2') != null)
					document.getElementById('next_addr_line2').value="<%=nkin_addr_line2%>"; 
				if("<%=nkin_addr_line3%>" != '' && document.getElementById('next_addr_line3') != null)
					document.getElementById('next_addr_line3').value="<%=nkin_addr_line3%>"; 
				if("<%=nkin_addr_line4%>" != '' && document.getElementById('next_addr_line4') != null)
					document.getElementById('next_addr_line4').value="<%=nkin_addr_line4%>"; 
				if("<%=nkin_area_long_desc%>" != '' && document.getElementById('contact1_res_area_code') != null)
					document.getElementById('contact1_res_area_code').value="<%=nkin_area_long_desc%>"; 
				if("<%=nkin_region_long_desc%>" != '' && document.getElementById('contact1_region_code') != null)
					document.getElementById('contact1_region_code').value="<%=nkin_region_long_desc%>"; 
				if("<%=nkin_postal_code%>" != '' && document.getElementById('next_postal_code') != null)
					document.getElementById('next_postal_code').value="<%=nkin_postal_code%>"; 
				if("<%=nkin_town_long_desc%>" != '' && document.getElementById('contact1_res_town_code') != null)
					document.getElementById('contact1_res_town_code').value="<%=nkin_town_long_desc%>"; 
				if("<%=fton_addr_line1%>" != '' && document.getElementById('fton_addr_line1') != null)
					document.getElementById('fton_addr_line1').value="<%=fton_addr_line1%>"; 
				if("<%=fton_addr_line2%>" != '' && document.getElementById('fton_addr_line2') != null)
					document.getElementById('fton_addr_line2').value="<%=fton_addr_line2%>"; 
				if("<%=fton_addr_line3%>" != '' && document.getElementById('fton_addr_line3') != null)
					document.getElementById('fton_addr_line3').value="<%=fton_addr_line3%>"; 
				if("<%=fton_addr_line4%>" != '' && document.getElementById('fton_addr_line4') != null)
					document.getElementById('fton_addr_line4').value="<%=fton_addr_line4%>"; 
				if("<%=fton_town_long_desc%>" != '' && document.getElementById('contact2_res_town_code') != null)
					document.getElementById('contact2_res_town_code').value="<%=fton_town_long_desc%>"; 
				if("<%=fton_area_long_desc%>" != '' && document.getElementById('contact2_res_area_code') != null)
					document.getElementById('contact2_res_area_code').value="<%=fton_area_long_desc%>" 
				if("<%=fton_region_long_desc%>" != '' && document.getElementById('contact2_region_code') != null)
					document.getElementById('contact2_region_code').value="<%=fton_region_long_desc%>"; 
				if("<%=fton_postal_code%>" != '' && document.getElementById('first_postal_code') != null)
					document.getElementById('first_postal_code').value="<%=fton_postal_code%>"; 
				if("<%=fton_contact_relation%>" != '' && document.getElementById('first_contact_relation') != null)
					document.getElementById('first_contact_relation').value="<%=fton_contact_relation%>"; 
				if("<%=emplr_addr_line1%>" != '' && document.getElementById('employ_addr_line1') != null)
					document.getElementById('employ_addr_line1').value="<%=emplr_addr_line1%>"; 
				if("<%=emplr_addr_line2%>" != '' && document.getElementById('employ_addr_line2') != null)
					document.getElementById('employ_addr_line2').value="<%=emplr_addr_line2%>"; 
				if("<%=emplr_addr_line3%>" != '' && document.getElementById('employ_addr_line3') != null)
					document.getElementById('employ_addr_line3').value="<%=emplr_addr_line3%>" 
				if("<%=emplr_addr_line4%>" != '' && document.getElementById('employ_addr_line4') != null)
					document.getElementById('employ_addr_line4').value="<%=emplr_addr_line4%>"; 
				if("<%=emplr_town_long_desc%>" != '' && document.getElementById('contact2_res_town_code') != null)
					document.getElementById('contact3_res_town_code').value="<%=emplr_town_long_desc%>";
				if("<%=emplr_region_long_desc%>" != '' && document.getElementById('contact3_region_code') != null)
					document.getElementById('contact3_region_code').value="<%=emplr_region_long_desc%>";
				if("<%=emplr_area_long_desc%>" != '' && document.getElementById('contact3_res_area_code') != null)
					document.getElementById('contact3_res_area_code').value="<%=emplr_area_long_desc%>";
				if("<%=emplr_postal_code%>" != '' && document.getElementById('employ_postal_code') != null)
					document.getElementById('employ_postal_code').value="<%=emplr_postal_code%>";
				
				if("<%=contact3_mode%>" != '' && document.getElementById('contact3_mode') != null)
					document.getElementById('contact3_mode').value="<%=contact3_mode%>";
				if("<%=contact3_no%>" != '' && document.getElementById('contact3_no') != null)
					document.getElementById('contact3_no').value="<%=contact3_no%>";
				if("<%=contact4_mode%>" != '' && document.getElementById('contact4_mode') != null)
					document.getElementById('contact4_mode').value="<%=contact4_mode%>";
				if("<%=contact4_no%>" != '' && document.getElementById('contact4_no') != null)
					document.getElementById('contact4_no').value="<%=contact4_no%>"
				if("<%=contact5_mode%>" != '' && document.getElementById('contact5_mode') != null)
					document.getElementById('contact5_mode').value="<%=contact5_mode%>"
				if("<%=contact5_no%>" != '' && document.getElementById('contact5_no') != null)
					document.getElementById('contact5_no').value="<%=contact5_no%>";
				if("<%=nkin_contact_relation%>" != '' && document.getElementById('next_contact_relation') != null)
					document.getElementById('next_contact_relation').value="<%=nkin_contact_relation%>";
				if("<%=contact1_oth_alt_id_type%>" !='' && document.getElementById("contact1_oth_alt_id_type") != null)
				{
					document.getElementById("contact1_oth_alt_id_type").value = "<%=contact1_oth_alt_id_type%>";
				}
			</script>
			

		 <!-- The below hidden fields should always be before the code which is the below script -->
	
			<input type='hidden' name='name_drvn_logic' id='name_drvn_logic' value="<%=rset.getString("name_dervn_logic")%>"></input>
			<input type='hidden' name='name_drvn_logic_oth_lang' id='name_drvn_logic_oth_lang' value="<%=rset.getString("name_dervn_logic_oth_lang")%>"></input>
			<input type='hidden' name='name_drvn_logic_long' id='name_drvn_logic_long' value="<%=rset.getString("NAME_DERVN_LOGIC_LONG")%>"></input>
			<input type='hidden' name='name_drvn_logic_oth_lang_long' id='name_drvn_logic_oth_lang_long' value="<%=rset.getString("NAME_DERVN_LOGIC_OTH_LANG_LONG")%>"></input>
			<input type='hidden' name='patient_name_long' id='patient_name_long' value="<%=a_patient_long_name%>"></input>
			<input type='hidden' name='patient_name_loc_lang_long' id='patient_name_loc_lang_long' value="<%= a_patient_long_name_loc_lang%>"></input>
			<input type='hidden' name='patient_name' id='patient_name' value=""></input>
            <input type='hidden' name='patient_name_loc_lang' id='patient_name_loc_lang' value=""></input>
			<input type='hidden' name='patient_group' id='patient_group' value="<%=patient_grp%>"></input>
			<input type='hidden' name='nat_series_loaded' id='nat_series_loaded' value="N"></input>
			<input type='hidden' name='First_Name' id='First_Name' value="<%=a_first_name%>"></input>
			<input type='hidden' name='Second_Name' id='Second_Name' value="<%=a_second_name%>"></input>
			<input type='hidden' name='Third_Name' id='Third_Name' value="<%=a_third_name%>"></input>
			<input type='hidden' name='Family_Name' id='Family_Name' value="<%=a_family_name%>"></input>
			<input type='hidden' name='patientName' id='patientName' value="<%=a_patient_name%>"></input>
			<input type='hidden' name='patientNameLocLang' id='patientNameLocLang' value="<%=a_patient_name_loc_lang%>"></input>
            <input type='hidden' name='nat_id_val' id='nat_id_val' value='S'></input>
            <input type='hidden' name='pass_val' id='pass_val' value='N'></input>
            <input type='hidden' name='error_alt_no1' id='error_alt_no1' value=""></input>
            <input type='hidden' name='error_alt_no2' id='error_alt_no2' value=""></input>
            <input type='hidden' name='error_alt_no3' id='error_alt_no3' value=""></input>
            <input type='hidden' name='error_alt_no4' id='error_alt_no4' value=""></input>
			<input type='hidden' name='patient_id' id='patient_id' value=""></input>
            <input type='hidden' name='error_expiry_date' id='error_expiry_date' value=""></input>
            <input type='hidden' name='Alt_Id1_Unique_Yn1' id='Alt_Id1_Unique_Yn1' value="<%=rset.getString("Alt_Id1_Unique_Yn")%>"></input>
            <input type='hidden' name='Alt_Id2_Unique_Yn2' id='Alt_Id2_Unique_Yn2' value="<%=rset.getString("Alt_Id2_Unique_Yn")%>"></input>
            <input type='hidden' name='Alt_Id3_Unique_Yn3' id='Alt_Id3_Unique_Yn3' value="<%=rset.getString("Alt_Id3_Unique_Yn")%>"'></input>
            <input type='hidden' name='Alt_Id4_Unique_Yn4' id='Alt_Id4_Unique_Yn4' value="<%=rset.getString("Alt_Id4_Unique_Yn")%>"></input>
			<input type='hidden' name='dflt_nationality_code' id='dflt_nationality_code' value="<%=rset.getString("Citizen_Nationality_Code")%>"></input>
			<input type='hidden' name='default_race_code' id='default_race_code' value="<%=rset.getString("default_race_code")%>"></input>
			<input type='hidden' name='dflt_pat_ser_grp_code' id='dflt_pat_ser_grp_code' value="<%=rset.getString("dfltPSG")%>"></input>
            <input type='hidden' name='dflt_pref_facility_id' id='dflt_pref_facility_id' value="<%=Facility%>"></input>
            <input type='hidden' name='dob' id='dob' value=''></input>
			<input type='hidden' name='func_act' id='func_act' value="<%=func_act%>"></input>
			<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>"></input>
            <input type='hidden' name='town_desc' id='town_desc' value=""></input>
            <input type='hidden' name='appt_ref_no' id='appt_ref_no' value="<%=appt_ref_no%>"></input>
            <input type='hidden' name='booking_ref_no' id='booking_ref_no' value="<%=booking_ref_no%>"></input>
            <input type='hidden' name='referral_id' id='referral_id' value='<%=referral_id%>'></input>
           	<input type='hidden' name='ServerDate' id='ServerDate' value="<%=rset.getString("ServerDate")%>"></input>
			<input type ='hidden' name='refrlAappt' id='refrlAappt' value=''></input>
			<input type ='hidden' name='refIDValue' id='refIDValue' value=''></input>
			<!--New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar-->
			<input type='hidden' name='region_prompt1' id='region_prompt1' value="<%=region_prompt%>"></input>
			<input type='hidden' name='region_appl_yn1' id='region_appl_yn1' value="<%=region_appl_yn%>"></input>

			<!--Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324-->
			<input type='hidden' name='addr_line1_prompt' id='addr_line1_prompt' value="<%=addr_line1_prompt%>"></input>
			<input type='hidden' name='addr_line2_prompt' id='addr_line2_prompt' value="<%=addr_line2_prompt%>"></input>
			<input type='hidden' name='postal_code_prompt' id='postal_code_prompt' value="<%=postal_code_prompt%>"></input>
			<input type='hidden' name='area_code_prompt' id='area_code_prompt' value="<%=area_code_prompt%>"></input><!--Added by shagar on 21-10-2016 for  AMRI-CRF-0388-->
			<input type='hidden' name='town_code_prompt' id='town_code_prompt' value="<%=town_code_prompt%>"></input><!-- Added by Suji keerthi on 27-Nov-2019 for KDAH-CRF-0522 -->
			
			
            <!-- The above hidden fields should always be before the code which is the below script -->
			
			<!-- The below code in the below script should be fallowed by the above hidden fields -->
			<script>
				if('<%=a_national_id_no%>' != '') {
					
					//document.forms[0].national_id_no.focus();
					dispMandatoryImage('N');
				} else FocusFirstElement()
				
				if('<%=a_alt_id1_no%>' != '') {
					dispMandatoryImage('A');
				}

                if('<%=a_date_of_birth%>' != '' && '<%=a_national_id_no%>' == '') {
					gotoNext(document.forms[0].date_of_birth);
				}

            	if(parent.patient_main.document.getElementById('patient_name')) {
					if(('<%=func_act%>' != 'DuplicateRegistration' && '<%=func_act%>' != '') || ('<%=refrlAappt%>' == 'P')) {
						if("<%=a_patient_name%>" != '') {
							
						//	parent.parent.frames[1].frames[0].document.forms[0].patient_name.value = "<%=a_patient_name%>";
						} else {
							putPatientName(document.forms[0].first_name);
						}
					} else {	
						putPatientName(document.forms[0].first_name);
					}
				}
				if(parent.patient_main.document.getElementById('patient_name_loc_lang')) {
					if('<%=func_act%>' != 'DuplicateRegistration' && '<%=func_act%>' != '') {
						if("<%=a_patient_name_loc_lang%>" != '') {
							parent.parent.frames[1].frames[0].document.forms[0].patient_name_loc_lang.value = "<%=a_patient_name_loc_lang%>";
						} else {
							putLocalLangPatientName(document.forms[0].first_name_oth_lang);
						}
					} else {	
						putLocalLangPatientName(document.forms[0].first_name_oth_lang);
					}
				}

				/*
	            if("<%=a_family_name%>" != '') { 
					if ( (parent.frames[0].document.forms[0].patient_name) && (parent.frames[0].document.forms[0].patient_name.value == '') ) {
						parent.frames[0].document.forms[0].patient_name.value = "<%=a_family_name%>";
					}
				}
				*/

				if("<%=a_patient_name%>" != '') { 
					if ( (parent.frames[0].document.forms[0].patient_name) && (parent.frames[0].document.forms[0].patient_name.value == '') ) {
						parent.frames[0].document.forms[0].patient_name.value = "<%=a_patient_name%>";
					}
				}
			</script> 	
	
            <input type='hidden' name='blood_grp' id='blood_grp' value=""></input>
			<input type='hidden' name='rh_factor' id='rh_factor' value=""></input>
			<input type='hidden' name='dflt_nat_id_chk_val' id='dflt_nat_id_chk_val' value=""></input>

			<input type='hidden' name='a_ethnic_group_code' id='a_ethnic_group_code' value="<%=a_ethnic_group_code%>"></input>
			<input type='hidden' name='Dob' id='Dob' value="<%=a_date_of_birth%>"></input>
			<input type='hidden' name='Sex' id='Sex' value="<%=a_gender%>"></input>
			<input type='hidden' name='Family_No' id='Family_No' value="<%=a_familyno%>"></input>
			<input type='hidden' name='Alt_Id_No' id='Alt_Id_No' value="<%=AltIdNo%>"></input>
			<input type='hidden' name='Alt_Id2_No' id='Alt_Id2_No' value="<%=AltIdNo2%>"></input>
			<input type='hidden' name='Alt_Id3_No' id='Alt_Id3_No' value="<%=AltIdNo3%>"></input>
			<input type='hidden' name='Alt_Id4_No' id='Alt_Id4_No' value="<%=AltIdNo4%>"></input>
			<input type='hidden' name='temp_a_national_id_no' id='temp_a_national_id_no' value="<%=init_a_national_id_no%>"></input>
			<input type='hidden' name='temp_referral_id' id='temp_referral_id' value="<%=init_referral_id%>"></input>
			<input type='hidden' name='temp_booking_ref_no' id='temp_booking_ref_no' value="<%=init_booking_ref_no%>"></input>
			<input type='hidden' name='temp_nat_id' id='temp_nat_id' value="<%=init_nat_id%>"></input>
			<input type='hidden' name='temp_appt_ref_no' id='temp_appt_ref_no' value="<%=init_appt_ref_no%>"></input>
			<input type='hidden' name='altId1Desc' id='altId1Desc' value="<%=checkForNull(rset.getString("alt_id1_desc"))%>"></input>
			<input type='hidden' name='altId2Desc' id='altId2Desc' value="<%=checkForNull(rset.getString("alt_id2_desc"))%>"></input>
			<input type='hidden' name='altId3Desc' id='altId3Desc' value="<%=checkForNull(rset.getString("alt_id3_desc"))%>"></input>
			<input type='hidden' name='altId4Desc' id='altId4Desc' value="<%=checkForNull(rset.getString("alt_id4_desc"))%>"></input>
			<input type='hidden' name='FamilyNoLink' id='FamilyNoLink' value="<%=FamilyNoLink%>"></input>
			<input type='hidden' name='create_file_at_pat_regn_yn' id='create_file_at_pat_regn_yn' value="<%=create_file_at_pat_regn_yn%>"></input>
			<input type ='hidden' name='datasource_id' id='datasource_id' value=""></input>
			<input type ='hidden' name='appfirstname' id='appfirstname' value="<%=a_first_name%>"></input>
			<input type ='hidden' name='appsecondname' id='appsecondname' value="<%=a_second_name%>"></input>
            <input type ='hidden' name='appthirdname' id='appthirdname' value="<%=a_third_name%>"></input>
            <input type ='hidden' name='appfamilyname' id='appfamilyname' value="<%=a_family_name%>"></input>
            <input type ='hidden' name='appdateofbirth' id='appdateofbirth' value="<%=a_date_of_birth%>"></input>
            <input type ='hidden' name='appsex' id='appsex' value="<%=a_gender%>"></input>
            <input type ='hidden' name='appprefix' id='appprefix' value="<%=a_name_prefix%>"></input>
            <input type ='hidden' name='appsuffix' id='appsuffix' value="<%=a_name_suffix%>"></input>
            <input type ='hidden' name='appt_yn' id='appt_yn' value="<%=appt%>"></input>
			<input type ='hidden' name='maintain_doc_or_file' id='maintain_doc_or_file' value="<%=maintain_doc_or_file%>"></input>
           	<input type='hidden' name='dr_function_id' id='dr_function_id' value="<%=drfunctionid%>"></input> 
			<input type='hidden' name='sStyle' id='sStyle' value='<%=sStyle%>'></input>
			<input type='hidden' name='operation' id='operation' value='<%=operation%>'></input>
			<input type='hidden' name='dflt_pat_regn_blng_class' id='dflt_pat_regn_blng_class' value="<%=dflt_pat_regn_blng_class%>">
			<input type='hidden' name='bl_install_yn' id='bl_install_yn' value="<%=bl_install_yn%>"></input>
			<input type='hidden' name='photo_file_name' id='photo_file_name' value="<%=rset.getString("photo_file_name")%>.jpg"></input>
			<input type='hidden' name='dflt_alt_id1_in_emp_id_yn' id='dflt_alt_id1_in_emp_id_yn' value="<%=dflt_alt_id1_in_emp_id_yn%>"></input>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
					
			<input type='hidden' name='bl_success' id='bl_success' value="N"></input> 			
			<input type='hidden' name='alt_exp_date_fromHCS' id='alt_exp_date_fromHCS' value="N"></input>
			<input type='hidden' name='called_from' id='called_from' value="PatRegForm"></input>
			<input type='hidden' name='img_dir_name' id='img_dir_name' value=""></input>

			<input type='hidden' name='deceased_yn' id='deceased_yn' value="N"></input>
			<input type='hidden' name='deceased_date' id='deceased_date' value=""></input>
			<input type='hidden' name='dla_image_yn' id='dla_image_yn' value=""></input>
			<input type='hidden' name='upload_patient_id' id='upload_patient_id' value=""></input>
			<input type='hidden' name='output' id='output' value=""></input>
			<input type='hidden' name='funCall' id='funCall' value=""></input>
			<input type='hidden' name='bl_success_msg' id='bl_success_msg' value=""></input>
			<input type='hidden' name='Photo_upload_yn' id='Photo_upload_yn' value="N"></input>
		<% 
			 
			

			if(bl_install_yn.equals("Y")) {	
				String apptrefno="";
				String bookingrefno="";
				if(refrlAappt.equals("A"))
				{
					apptrefno=refIDValue;
				}
				else 
				{
					apptrefno=appt_ref_no;
				}

				if(refrlAappt.equals("I"))
				{
					bookingrefno=refIDValue;
				}
				else 
				{
					bookingrefno=booking_ref_no;
				}				
	
			if(refrlAappt.equals("A") || appt.equals("Appt"))
		   { %>
			<jsp:include page="../../eBL/jsp/BLFinDetHiddenFlds.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name="patient_id" value="" />
			<jsp:param name="calling_module" value="MP" />
			<jsp:param name="calling_function_id" value="<%=function_id%>" />
			<jsp:param name="episode_type" value="" />
			<jsp:param name="apptrefno" value="<%=apptrefno%>" />
			</jsp:include> 
			<%
		   }
		   else if(!booking_ref_no.equals("") || refrlAappt.equals("I"))
			{%>
			
				<jsp:include page="../../eBL/jsp/BLFinDetHiddenFlds.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name="patient_id" value="" />
				<jsp:param name="calling_module" value="MP" />
				<jsp:param name="calling_function_id" value="<%=function_id%>" />
				<jsp:param name="episode_type" value="" />
				<jsp:param name="bookingrefno" value="<%=bookingrefno%>" />
				</jsp:include> 
			<%}
				else
				{%>
				<input type='hidden' name='bl_operation' id='bl_operation' value=''></input>
				<input type='hidden' name='billing_group' id='billing_group' value=""></input>
				<input type='hidden' name='billing_mode' id='billing_mode' value='Add'></input>
				<%}
			}
			else
			{%>
				<input type='hidden' name='bl_operation' id='bl_operation' value=''></input>
				<input type='hidden' name='billing_group' id='billing_group' value=""></input>
				<input type='hidden' name='billing_mode' id='billing_mode' value='Add'></input>
		<%	} 			
	
	%>
			
	
			
			
		<%	hash_Map2.clear();
			
			//if(rs_bl != null) rs_bl.close();
			if(oth_stmt != null) oth_stmt.close();
			if(oth_rset != null) oth_rset.close();
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
			//if(stmt_bl != null) stmt_bl.close();
			if(oth_stmt != null) oth_stmt.close();

		/*stmt = con.prepareStatement("SELECT relationship_code, INITCAP(short_desc) short_desc FROM mp_relationship_lang_vw WHERE relationship_code = '"+org_member_relationship_code+"' and language_id = '"+locale+"' and eff_status = 'E' ORDER BY 2");

			rset = stmt.executeQuery();	
			

			if(rset!=null && rset.next())
			{
				org_member_relationship_desc = rset.getString("short_desc");
			}*/

			
			
			
			if(stmt!=null)
				stmt.close();
			if(rset!=null)
				rset.close();			
						
		}
        catch(Exception e)
		{
			e.printStackTrace();
		}
        finally
	    {
			ConnectionManager.returnConnection(con,request);
        }
		if(ext_system_interface_yn.equals("Y") && nat_data_source_id.equals("NRIC")) 
		{
			
			%>
			<!-- FOR MYKAD READING -->
			<OBJECT id=Cad style=\"WIDTH: 149px; HEIGHT: 25px\" data=data:application/x-oleobject;base64,6bldI31CwEeRWh+s54i2NAADAABmDwAAlQIAAA== classid=clsid:235DB9E9-427D-47C0-915A-1FACE788B634></OBJECT>
			<OBJECT id=jpndf1 style=\"WIDTH: 192px; HEIGHT: 24px\" data=data:application/x-oleobject;base64,arMlNbqDrEKC9D9p0v5gBQADAADYEwAAewIAAA== classid=clsid:3525B36A-83BA-42AC-82F4-3F69D2FE6005></OBJECT>
			<OBJECT id=jpndf4 style=\"LEFT: 0px; WIDTH: 192px; TOP: 0px; HEIGHT: 24px\" data=data:application/x-oleobject;base64,zUFYb5tV40iaOd6s6vQBygADAADYEwAAewIAAA== classid=clsid:6F5841CD-559B-48E3-9A39-DEACEAF401CA></OBJECT>
			<OBJECT id=gmpcpic style=\"WIDTH: 345px; HEIGHT: 303px\" data=data:application/x-oleobject;base64,2lmqMIeVKU6C6+Ww4x0h3QADAACoIwAAUR8AAA== classid=clsid:30AA59DA-9587-4E29-82EB-E5B0E31D21DD></OBJECT>
			<!-- END FOR MYKAD READING -->
			<%
		}
		%>
	 	<script>
		/* 
Below line was added by Suresh.M on 14-Aug-2012  against  SKR-SCF-0631 [IN035065]*/
function makeValidStringRemark(txtObj)
{  
    var text_value  =   txtObj.value;
	
    while(text_value.indexOf('"')!=-1)
    {
        text_value = text_value.replace('"',"'");
    }
	
	while (text_value.indexOf('+')!=-1)
	{ 
	text_value=text_value.replace('+',"");
	}
	while (text_value.indexOf('%')!=-1)
	{ 
	text_value=text_value.replace('%',"");
	}
	
    txtObj.value = text_value;

    if(text_value.indexOf("&")==(text_value.length-1))
    {
        return false;
    }

    for(var i=0; i<text_value.length; i++)
    {
        if( (text_value.charAt(i)=='&')  || (text_value.charAt(i)=='<') )
        {
            if(text_value.charAt(i+1)!=' ')
            {
                text_value  =   text_value.substring(0,(i+1))+' '+ text_value.substring((i+1),text_value.length);
                i++;
            }
        }
    }
    txtObj.value = text_value;
    if(txtObj.value.length>txtObj.maxLength)
    {
        alert(getMessage("EXCEED_MAX_LENGTH", "Sm",null));

        txtObj.select();
        txtObj.focus();
    }
}
		/*SKR-SCF-0631 [IN035065]*/	
			
			populateethnicity();
			dispMandatoryImage();
			dispMandatoryImageForOthNames();
		</script>
		
		<!--Added by Rameswar on  13-04-2016 for MMS-QF-SCF-0532 TF-->
		<input type='hidden' name='fileTypeSiteSpec' id='fileTypeSiteSpec' value='<%=fileTypeSiteSpec%>'></input>
		<input type='hidden' name='alterAddressApplicable' id='alterAddressApplicable' value='<%=alterAddressApplicable%>'></input>
		<!--Added by Ashwini on 07-Sep-2018-->
		<input type='hidden' name='finDtlsChkNationality' id='finDtlsChkNationality' value='<%=finDtlsChkNationality%>'></input>
		
		</form>
    </body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>



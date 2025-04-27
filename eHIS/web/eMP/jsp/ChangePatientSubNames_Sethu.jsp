<!DOCTYPE html>
<!--  
	Last Modified Date Time : 10/27/2005 3:00 PM
	ChangePatientSubNames.jsp is an common component used for functions like Patient Registration, Change Patient Details, Rapid Registration & Emergency Registration. This JSP includes Patient Series, Preferred Fecility, National ID, Other Alternate ID Type and Number and all Alternate ID Type's and Numbers and Naming Fields such as Head of Family Patient ID, Relationship to Head, Name Prefix, Family Name, Name Suffix etc., Gender, Age, Date of Birth,  This file is Dynamically included in the files NewPatientRegistration.jsp, ChangePatientSub.jsp, InsertEmergnRegn.jsp & InsertRapidRegn.jsp. 
	-- by Meghanath.     
-->	  

<%@ page import="java.sql.*, java.util.HashMap, java.util.ArrayList, webbeans.eCommon.ConnectionManager,java.util.*,com.ehis.util.*,eCommon.Common.*,eXH.InterfaceUtil,eXH.XHUtil" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<% 
	request.setCharacterEncoding("UTF-8");
	Properties p				=	(java.util.Properties) session.getValue("jdbc");
	String sStyle			=	checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<html>
<head>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/DateUtils.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/calScript/hj/calendar.js" language="JavaScript"></Script>
<Script src="../../eXH/js/ExternalApplication.js" language="JavaScript"></Script>
<Script src="../../eXH/js/jquery-1.7.min.js" language="JavaScript"></Script>
<script Language="javascript" src="../../eMP/js/json02.js"> </script>
<script Language="javascript" src="../../eMP/js/PasInterface.js"> </script>
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head>
<script>	var pat_name_in_loc_lang = new Array ();  	 
</script> 
	<%
	String Smartcard_path="" ; //added for smart card 
	String function_name="" ; //added for Alkhalej smart card 
	String MdisEnb						= "";
	String ClickVal						= "";
	String year_value					= "";
	String age_or_dob				= "";
	String month_value				= "";
	String day_value					= "";
	String hours_value					= "";
	String age_value					= "";
	String race_trigger					= "";
	String patient_id					= checkForNull(request.getParameter("patient_id"));
	String group							= checkForNull(request.getParameter("group"));
	String CalledFromFunction		= checkForNull(request.getParameter("CalledFromFunction"));	
	String emeg_pat_ser_grp			= checkForNull(request.getParameter("emeg_pat_ser_grp"));
	String default_race_code			= checkForNull(request.getParameter("default_race_code"));
	String facility						= (String) session.getValue("facility_id");
	String hij_appl_YN="N";   //MMS-QH-CRF-0145
	String hijiri_b_date="";
	String myhix_consent=""; // Added for MYHIX integration ML-MMOH-CRF-0507.1.
	String myhix_pat_id="";  // Added for MYHIX integration ML-MMOH-CRF-0507.1.
	String myhix_appl_YN = "N"; // Added for MYHIX integration ML-MMOH-CRF-0507.1.
	
	/*Below line added for this CRF GDOH-CRF-0029 [IN:048764]     */
	
	String regn_date="";
	String old_regn_datetime="";

	//**  variables for NewPatientRegistration.jsp & InsertEmergRegn.jsp files **//
	String dflt_patient_name ="";
	String a_family_name				= checkForNull(request.getParameter("a_family_name"));
	String a_first_name				= checkForNull(request.getParameter("a_first_name"));
	String a_second_name			= checkForNull(request.getParameter("a_second_name"));
	
	String a_third_name				= checkForNull(request.getParameter("a_third_name"));
	String a_name_prefix				= checkForNull(request.getParameter("a_name_prefix"));
	String a_name_suffix				= checkForNull(request.getParameter("a_name_suffix"));
	String a_name_prefix_loc_lang			= checkForNull(request.getParameter("a_name_prefix_loc_lang"));
	String a_first_name_loc_lang			= checkForNull(request.getParameter("a_first_name_loc_lang"));
	String a_second_name_loc_lang		= checkForNull(request.getParameter("a_second_name_loc_lang"));
	String a_third_name_loc_lang			= checkForNull(request.getParameter("a_third_name_loc_lang"));
	String a_family_name_loc_lang			= checkForNull(request.getParameter("a_family_name_loc_lang"));
	String a_name_suffix_loc_lang			= checkForNull(request.getParameter("a_name_suffix_loc_lang"));
	String a_patient_name_loc_lang		= checkForNull(request.getParameter("a_patient_name_loc_lang"));
	String nat_id_accept_alphanumeric_yn = checkForNull(request.getParameter("nat_id_accept_alphanumeric_yn"),"N");
	
		
		
	/*Below Variable Added for this CRF [RET-CRF-0011]*/
	String patient_cat_code	= checkForNull(request.getParameter("patient_cat_code"));
	String patient_cat_desc	= checkForNull(request.getParameter("patient_cat_desc"));	
    String language_id=checkForNull(request.getParameter("language_id")); //checkstyle violation
//	String language_desc=checkForNull(request.getParameter("language_desc"));
	
	//** end of variables for NewPatientRegistration.jsp & InsertEmergRegn.jsp files **//
	
	//** variables for NewPatientRegistration.jsp, InsertEmergRegn.jsp & InsertRapidRegn.jsp files **//

	String a_national_id_no	= checkForNull(request.getParameter("a_national_id_no"));
	String dfltPSG					= checkForNull(request.getParameter("dfltPSG"));
	String defaultSelect			= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");

	//** end of variables for NewPatientRegistration.jsp & InsertEmergRegn.jsp & InsertRapidRegn.jsp files **//
	
	//**  variables for NewPatientRegistration.jsp file **//
	

	String AltdfltPSG					= "";		
	String a_oth_alt_id_type			= checkForNull(request.getParameter("a_oth_alt_id_type")); 
	String a_oth_alt_id_no			= checkForNull(request.getParameter("a_oth_alt_id_no"));
	String a_alt_id1_no					= checkForNull(request.getParameter("a_alt_id1_no"));
	String a_alt_id1_exp_date			= checkForNull(request.getParameter("a_alt_id1_exp_date"));
	String a_alt_id2_no				= checkForNull(request.getParameter("a_alt_id2_no"));
	String a_alt_id2_exp_date		= checkForNull(request.getParameter("a_alt_id2_exp_date"));
	String a_alt_id3_no				= checkForNull(request.getParameter("a_alt_id3_no"));
	String a_alt_id3_exp_date		= checkForNull(request.getParameter("a_alt_id3_exp_date"));
	String a_alt_id4_no				= checkForNull(request.getParameter("a_alt_id4_no"));
	String a_alt_id4_exp_date		= checkForNull(request.getParameter("a_alt_id4_exp_date"));
	String a_gender					= checkForNull(request.getParameter("a_gender"));
	String a_familyno					= checkForNull(request.getParameter("a_familyno"));
	String a_birth_place_desc		= checkForNull(request.getParameter("a_birth_place_desc"));
	String a_birth_place_code		= checkForNull(request.getParameter("a_birth_place_code"));
	String a_place_of_birth			= checkForNull(request.getParameter("a_place_of_birth"));
	String a_date_of_birth				= checkForNull(request.getParameter("a_date_of_birth"));
	String a_citizen_yn					= checkForNull(request.getParameter("a_citizen_yn"));
	
	String a_legal_yn					= checkForNull(request.getParameter("a_legal_yn"));
	String a_nationality_code			= checkForNull(request.getParameter("a_nationality_code"));
	String a_race_code				= checkForNull(request.getParameter("a_race_code"));
	String citizen_nationality_code	= checkForNull(request.getParameter("citizen_nationality_code"));
	
	
	//String relgn_code					= checkForNull(request.getParameter("relgn_code"));
	String flag							= checkForNull(request.getParameter("flag"), "N");
	// flag:  'Y' If Details unknown is 'unchecked' from AE 
	int		 Demoaddlcnt				= Integer.parseInt(checkForNull(request.getParameter("Demoaddlcnt"), "0"));
	//** end of variables for NewPatientRegistration.jsp file **//

	//**  variables for NewPatientRegistration.jsp & InsertRapidRegn.jsp files **//
	String alt_id1_disable			= "";
	String exeStrEmpId			= "";
	String altid1datelookup		= "";
	String altid2datelookup		= "";
	String altid3datelookup		= "";
	String altid4datelookup		= "";
	String rdonly					= ""; 
	String birth_place_desc		= "";
	String birth_place_code		= "";
	String birthenabledisable		= "";
	String birthenabledisable1	= "";
	String place_of_birth			= "";
	String disable_age			= "disabled";
	String disable_hours		= "disabled";
	String disable_time		= "";
	String disable_dob			= "";
	String check_age			= "";
	
	/*Below line added for this CRF GHL-CRF-0332 [IN:042060]*/
	String citizen_visibility = "visibility:hidden";
	String citizen_requied="N";
	
	//End GHL-CRF-0332 [IN:042060]
 
	String def_nat_desc						= checkForNull(request.getParameter("def_nat_desc"));
	String disabled_fields						= checkForNull(request.getParameter("disabled_fields"));
	String dflt_alt_id1_in_emp_id_yn			= checkForNull(request.getParameter("dflt_alt_id1_in_emp_id_yn"), "N");
	//String multi_birth							= checkForNull(request.getParameter("dflt_alt_id1_in_emp_id_yn"), "N");
	String nb_birth_place_code				= checkForNull(request.getParameter("nb_birth_place_code"));
	String nb_birth_place_desc				= checkForNull(request.getParameter("nb_birth_place_desc"));
	//** end of variables for ChangePatientSub.jsp file **//
	
	//**  variables for NewPatientRegistration.jsp & ChangePatientSub.jsp files **//
	String Site		= checkForNull(request.getParameter("Site"));
	String days		= checkForNull(request.getParameter("days"));
	String months	= checkForNull(request.getParameter("months"));
	String year		= checkForNull(request.getParameter("year"));
	//**  end of variables for NewPatientRegistration.jsp & ChangePatientSub.jsp files **//

	String PatInfflag = checkForNull(request.getParameter("PatInfflag"));
	String RapidPatInfflag = checkForNull(request.getParameter("RapidPatInfflag"));
	
	String appt_ref_no = checkForNull(request.getParameter("appt_ref_no")); 
	 
	String selectAttribute		= "";
	String selectAttribute1		= "";

	String disp_nat_man_gif		=	 "";
	String regpat_ser_val			=	 "";
	String MembershipType		=	 "";
	String birthPlace				=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthPlace.label","common_labels");
	String nationality					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nationality.label","common_labels");

	String downtime_regn_yn		= "N";/*Added By Dharma on Sep 9th 2016 against PMG2015-GDOH-CRF-0006.1 [IN061724]*/

	boolean oth_lang = false; 	
	Connection conn	= null;
	conn = ConnectionManager.getConnection(request); 
	Statement stmt_rh = conn.createStatement();	
	PreparedStatement pstmt=null;
	ResultSet rs_rh = null;
	/*Added by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] Start*/
	HashMap hashdata					 = CommonBean.getSiteSpecificDetails(conn, "MP","NATSR_NONNATSR");
	String isNatIdMandatory				 = (String)hashdata.get("value1");
	String isClearNatIdValues			 = (String)hashdata.get("value2");
	/*Added by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] End*/
	boolean isValidateNatIDWithDOB		 = CommonBean.isSiteSpecific(conn, "MP","DOB_NATID_VALIDATION");/*Added by Dharma on Feb 20th 2017 against GDOH-CRF-0140 [IN:063489] */
	boolean disableRegnDate 		 = CommonBean.isSiteSpecific(conn, "MP","DISABLE_REGN_DATE");  //Added by Sangeetha for GDOH-CRF-0148
	boolean chkGenderWithNatID	= CommonBean.isSiteSpecific(conn, "MP","VALIDATE_GENDER_WITH_NATID"); //Added by Thamizh selvi on 24th Mar 2017 for GDOH-CRF-0145 
	boolean chkForm60Allow = CommonBean.isSiteSpecific(conn, "MP","GENERATE_FORM_60");  // added for KDAH-CRF-347 start
	int form60_value_chk = 0;
	if(chkForm60Allow)
	{ int count = 0;
		if(CalledFromFunction.equals("ChangePatDtls") && !patient_id.equals(""))
		{      
			String pat_form60_chk_status = "";
			pat_form60_chk_status=eMP.MPForm60Bean.getForm60StatusForPatient(conn,patient_id);
			if(!pat_form60_chk_status.equals(""))
			{
			String[] retval = pat_form60_chk_status.split("\\##");
			count = Integer.parseInt(retval[1]);	
			form60_value_chk = count;
			}
		}
	} 
	// added by mujafar for KDAH-CRF-347	 end
	//Data added for the Incident no : 34531 as on 10/08/2012
	//String pat_lang_id=""; //commented for checkstyle voilation by  Munisekhar
	//Statement lang_stmt=null;//commented for checkstyle voilation by  Munisekhar
	//ResultSet lang_rest=null;//commented for checkstyle voilation by  Munisekhar
	//End
	HashMap hash_Map	= new HashMap();
	HashMap hash_Map1	= new HashMap();
	HashMap hash_Map2	= new HashMap();
	HashMap hash_Map3	= new HashMap();
	HashMap hash_Map4	= new HashMap();
	HashMap hash_Map5	= new HashMap();
	HashMap hash_Map6	= new HashMap();
	HashMap hash_Map7	= new HashMap();
	//HashMap hash_Map8	= new HashMap(); //commented for checkstyle voilation by  Munisekhar

//	ArrayList arrayList		= new ArrayList();
	ArrayList array_List1	= new ArrayList();
	ArrayList array_List2	= new ArrayList();
	
	array_List1	= eMP.ChangePatientDetails.getResultRows(conn,"mp_alternate_id_type",p);
	hash_Map	= eMP.ChangePatientDetails.getSetupData(facility,group, conn,p);//modified for the incident 34901
	int Alt_Id1_length	=	 Integer.parseInt((String) hash_Map.get("Alt_Id1_length"));
	int Alt_Id2_length	=	 Integer.parseInt((String) hash_Map.get("Alt_Id2_length"));
	int Alt_Id3_length	=	 Integer.parseInt((String) hash_Map.get("Alt_Id3_length"));
	int Alt_Id4_length	=	 Integer.parseInt((String) hash_Map.get("Alt_Id4_length"));
	dflt_patient_name =checkForNull((String) hash_Map.get("dflt_patient_name"));
	String alt_id1_len_validation_yn	=		checkForNull((String) hash_Map.get("alt_id1_len_validation_yn"));	
	String alt_id2_len_validation_yn	=		checkForNull((String) hash_Map.get("alt_id2_len_validation_yn"));
	String alt_id3_len_validation_yn	=		checkForNull((String) hash_Map.get("alt_id3_len_validation_yn"));	
	String alt_id4_len_validation_yn	=		checkForNull((String) hash_Map.get("alt_id4_len_validation_yn"));
	String disp_nat_id_length			=		checkForNull((String) hash_Map.get("nat_id_length"));
	String nat_id_chk_len					=		checkForNull((String)hash_Map.get("nat_id_chk_len"));
	String nat_id_check_digit_id		=		checkForNull((String)hash_Map.get("nat_id_check_digit_id"));
	
	String alt_id1_accept_alphanumeric_yn  =	 checkForNull((String)hash_Map.get("alt_id1_accept_alphanumeric_yn"));
	String alt_id1_chng_allowed_yn  =	 checkForNull((String)hash_Map.get("alt_id1_chng_allowed_yn"));

	/*Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] Start */
	
	String alt_id2_accept_alphanumeric_yn			= checkForNull((String) hash_Map.get("alt_id2_accept_alphanumeric_yn"),"N");
	String alt_id3_accept_alphanumeric_yn			= checkForNull((String) hash_Map.get("alt_id3_accept_alphanumeric_yn"),"N");
	String alt_id4_accept_alphanumeric_yn			= checkForNull((String) hash_Map.get("alt_id4_accept_alphanumeric_yn"),"N");

	/*Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] End */
	
	/*below line added for this CRF GHL-CRF-0332 [IN:042060]*/
	boolean isAltId1ManNonCtz=eOP.QMSInterface.isSiteSpecific(conn,"MP","ALT_ID1_MAN_NON_CTZN");
	//End CRF GHL-CRF-0332 [IN:042060]
	
	String pat_name_loc_lang = "";
	String pat_name_loc_lang_long = "";
	String alt_id1_exp_date = "";
	String alt_id2_exp_date = "";
	String alt_id3_exp_date = "";
	String alt_id4_exp_date = "";
	String nat_id_onKeyPress = "";

	String race_required_yn		= checkForNull((String)hash_Map.get("race_required_yn"),"N");	
	String display_new_born_age_in_hrs	=	checkForNull((String)hash_Map.get("display_new_born_age_in_hrs"));
	String single_patient_numbering_yn	=	checkForNull((String)hash_Map.get("single_patient_numbering_yn"),"N");
	String race_visibility = "";

	String patbloodgrp = "";
	String RHfactor = "";  	


	//for smart card
	pstmt = conn.prepareStatement("select VALUE_1,nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");

	rs_rh = pstmt.executeQuery();	


	if(rs_rh!=null && rs_rh.next())
	{
	Smartcard_path=rs_rh.getString("VALUE_1");
	function_name=rs_rh.getString("VALUE_2");   // alkhaleej smart card

	}		


	if(pstmt!=null)
	pstmt.close();
	if(rs_rh!=null)
	rs_rh.close();
	//for smart card

	//for Hijri MMS-QH-CRF-0145
	 
   Boolean hijirisitespecifApplicable = CommonBean.isSiteSpecific(conn, "MP","CAL_HIJ_APP");
   if(hijirisitespecifApplicable)  hij_appl_YN="Y";

	myhix_appl_YN 	= CommonBean.getMyHixApplicable(conn); //added for MYHIX integration ML-MMOH-CRF-0507.1.
	
	
	/*Added by Rameswar on 24/11/2016 for BSP-SCF-0021*/
	ArrayList column_name=new ArrayList();
	Boolean alt_id2_specialchar_validation =true; 
	Boolean alt_id3_specialchar_validation =true; 
	Boolean alt_id4_specialchar_validation =true; 
	String field_name ="";
	column_name  = CommonBean.getFunctionFieldRestriction(conn, "MP","ALT_ID_DATA_NO_VALIDATE","MP_PARAM","Y","Y"); 
					Iterator itr = column_name.iterator();
					while(itr.hasNext()){	
					field_name=(String)itr.next();
  					if(field_name.equals("ALT_ID2"))
  						alt_id2_specialchar_validation=false;
  					if(field_name.equals("ALT_ID3"))
  						alt_id3_specialchar_validation=false;
  					if(field_name.equals("ALT_ID4"))
  						alt_id4_specialchar_validation=false;
    					}
	/*Added by Rameswar on 24/11/2016 for BSP-SCF-0021*/
	/*pstmt = conn.prepareStatement("select decode(count(*),'1','Y','N') CAL_HIJ_APP  from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='CAL_HIJ_APP' and a.SITE_ID=B.CUSTOMER_ID");

	rs_rh = pstmt.executeQuery();	


	if(rs_rh!=null && rs_rh.next())
	{
	hij_appl_YN=rs_rh.getString("CAL_HIJ_APP");
	

	}		


	if(pstmt!=null)
	pstmt.close();
	if(rs_rh!=null)
	rs_rh.close();*/
	/* Added for GDOH -CRF-0029 by Dharma on 11th sep 2014 Start*/
	String visit_adm_date_time = "";
	if(CalledFromFunction.equals("ChangePatDtls") && !patient_id.equals("")){
	   	String sqlString="select TO_CHAR(min(VISIT_ADM_DATE_TIME) ,'dd/mm/yyyy hh24:mi:ss') VISIT_ADM_DATE_TIME from pr_encounter where patient_id='"+patient_id+"' and (ADT_STATUS!='09' or ADT_STATUS is null) and (VISIT_STATUS!='99' or VISIT_STATUS is null)";
		
		pstmt = conn.prepareStatement(sqlString);
		rs_rh = pstmt.executeQuery();	
		if(rs_rh!=null && rs_rh.next())	{
			visit_adm_date_time= checkForNull(rs_rh.getString("VISIT_ADM_DATE_TIME"));
			visit_adm_date_time=DateUtils.convertDate(visit_adm_date_time,"DMYHMS","en",localeName);
		}
		if(pstmt!=null)pstmt.close();
		if(rs_rh!=null)rs_rh.close();
		
	}
	/* Added for GDOH -CRF-0029 by Dharma on 11th sep 2014 End*/

/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] Start*/
String sqlDate="select to_char(sysdate,'dd/mm/yyyy HH24:mi') as regn_date from dual";
		String dbDate="";
		pstmt = conn.prepareStatement(sqlDate);
		rs_rh = pstmt.executeQuery();	
		if(rs_rh!=null && rs_rh.next())	{
			dbDate= checkForNull(rs_rh.getString("regn_date"));
		
		}
		if(pstmt!=null)pstmt.close();
		if(rs_rh!=null)rs_rh.close();
/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] End*/


	//for Hijri MMS-QH-CRF-0145
	
	if(CalledFromFunction.equals("ChangePatDtls") || PatInfflag.equals("Y") || RapidPatInfflag.equals("Y")) {
		hash_Map1 = eMP.ChangePatientDetails.getPatientData(patient_id, conn,p);	
		hijiri_b_date=checkForNull((String) hash_Map1.get("hijri_birth_date"));
		downtime_regn_yn=checkForNull((String) hash_Map1.get("downtime_regn_yn"));/*Added By Dharma on Sep 9th 2016 against PMG2015-GDOH-CRF-0006.1 [IN061724] */
	
		MembershipType		= checkForNull((String) hash_Map1.get("MembershipType"));
		pat_name_loc_lang    = checkForNull((String)hash_Map1.get("patient_name_loc_lang"));
		pat_name_loc_lang_long    = checkForNull((String)hash_Map1.get("patient_long_name_loc_lang"));
		alt_id1_exp_date = checkForNull((String)hash_Map1.get("alt_id1_exp_date"));
		alt_id2_exp_date = checkForNull((String)hash_Map1.get("alt_id2_exp_date"));
		alt_id3_exp_date = checkForNull((String)hash_Map1.get("alt_id3_exp_date"));
		alt_id4_exp_date = checkForNull((String)hash_Map1.get("alt_id4_exp_date"));
		if ( !localeName.equals("en") )
		{ 
			if (!alt_id1_exp_date.equals(""))
					alt_id1_exp_date= DateUtils.convertDate(alt_id1_exp_date,"DMY","en",localeName);
			if (!alt_id2_exp_date.equals(""))
					alt_id2_exp_date= DateUtils.convertDate(alt_id2_exp_date,"DMY","en",localeName);
			if (!alt_id3_exp_date.equals(""))
					alt_id3_exp_date= DateUtils.convertDate(alt_id3_exp_date,"DMY","en",localeName);
			if (!alt_id4_exp_date.equals(""))
					alt_id4_exp_date= DateUtils.convertDate(alt_id4_exp_date,"DMY","en",localeName);
		}

		patbloodgrp	= checkForNull((String)hash_Map1.get("blood_grp"),"");
		RHfactor	= checkForNull((String)hash_Map1.get("rh_factor"),"");
		
		/*Below line added for this CRF GHL-CRF-0332 [IN:042060]*/
		if(((String)hash_Map1.get("citizen_yn")).equals("N") && isAltId1ManNonCtz){
		   citizen_visibility="visibility:visible";
           citizen_requied="Y";
		   }

	}
		/*Below line added for this CRF  GDOH-CRF-0029 [IN:048764]*/				
		regn_date=checkForNull((String)hash_Map1.get("regn_date"));	
        old_regn_datetime=regn_date;	
		java.util.Date dNow = new java.util.Date();
        java.text.SimpleDateFormat ft = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");     
		
		//if(regn_date.equals(""))regn_date=ft.format(dNow);
		/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] */	
		if(regn_date.equals(""))regn_date=dbDate;	
        
		regn_date=DateUtils.convertDate(regn_date,"DMYHM","en",localeName);//Added by Rameswar on 29-Sep-15 for Leap Year issue
		//End GDOH-CRF-0029 [IN:048764]

		
	String dflt_language_id			=	 checkForNull((String) hash_Map.get("dflt_language_id"));
	String dflt_relgn_code		=	 checkForNull((String) hash_Map.get("dflt_relgn_code"));

	String Accept_oth_alt_id_yn			=	 checkForNull((String) hash_Map.get("Accept_oth_alt_id_yn"));
	String accept_national_id_no_yn		=	 checkForNull((String) hash_Map.get("accept_national_id_no_yn"), "N");
	String family_org_id_accept_yn		=	 checkForNull((String) hash_Map.get("family_org_id_accept_yn"), "N");
	String entitlement_by_pat_cat_yn	=	 checkForNull((String) hash_Map.get("entitlement_by_pat_cat_yn"), "N");
	
	String id_change_allowed_for_series=	 checkForNull((String) hash_Map.get("id_change_allowed_for_series"));
	//String change_national_id_no_yn=	 checkForNull((String) hash_Map.get("change_national_id_no_yn")); //check style violation
	String nat_id_reqd_all_series			=	 checkForNull((String)hash_Map.get("nat_id_reqd_all_series"), "N");
	String nat_id_prompt						=	 checkForNull((String)hash_Map.get("nat_id_prompt"), "N");
	String invoke_routine						=	 checkForNull((String)hash_Map.get("invoke_routine"));
	String nat_data_source_id				=	 checkForNull((String)hash_Map.get("nat_data_source_id"));
	String ext_system_interface_yn			=	 checkForNull((String)hash_Map.get("ext_system_interface_yn"));
	String Alt_Id1_Type							=	 checkForNull((String)hash_Map.get("Alt_Id1_Type"));
	String Alt_Id2_Type							=	 checkForNull((String)hash_Map.get("Alt_Id2_Type"));
	String Alt_Id3_Type							=	 checkForNull((String)hash_Map.get("Alt_Id3_Type"));
	String Alt_Id4_Type							=	 checkForNull((String)hash_Map.get("Alt_Id4_Type"));
	String Family_No_Link_Yn				=	 checkForNull((String)hash_Map.get("Family_No_Link_Yn"));
	String pat_name_in_loc_lang_reqd_yn= checkForNull((String)hash_Map.get("pat_name_in_loc_lang_reqd_yn"),"N");
	String pat_name_as_multipart_yn   =	checkForNull((String)hash_Map.get("pat_name_as_multipart_yn"),"N");
	String names_in_oth_lang_yn			=	 checkForNull((String)hash_Map.get("names_in_oth_lang_yn"),"N");
	String name_pfx_reqd_for_org_mem_yn		= checkForNull((String)hash_Map.get("name_pfx_reqd_for_org_mem_yn"),"N");
	if(CalledFromFunction.equals("ChangePatDtls")) {
		pat_name_in_loc_lang_reqd_yn = checkForNull((String)hash_Map1.get("pat_name_in_loc_lang_reqd_yn"),"N");
	}
	
	boolean alt_id1_exp_date_show = ((String) hash_Map.get("alt_id1_exp_date_accept_yn")).equalsIgnoreCase("Y") ? true : false;
	boolean alt_id2_exp_date_show = ((String) hash_Map.get("alt_id2_exp_date_accept_yn")).equalsIgnoreCase("Y") ? true : false;
	boolean alt_id3_exp_date_show = ((String) hash_Map.get("alt_id3_exp_date_accept_yn")).equalsIgnoreCase("Y") ? true : false;
	boolean alt_id4_exp_date_show = ((String) hash_Map.get("alt_id4_exp_date_accept_yn")).equalsIgnoreCase("Y") ? true : false;
		 
	///*** Start of National ID, Other Alternate ID type and number and all alternate ID type's ***///

	/*Added By Dharma on Sep 9th 2016 against PMG2015-GDOH-CRF-0006.1 [IN061724] Start*/
	if(checkForNull((String)hash_Map1.get("regn_date")).equals("") && downtime_regn_yn.equals("Y") && CalledFromFunction.equals("ChangePatDtls")){
		hash_Map1.put("sex","");
		hash_Map1.put("p_age","");
		hash_Map1.put("date_of_birth","");
		hash_Map1.put("calculated_age_yn","N");
		hash_Map1.put("patient_name","");
	}
	/*Added By Dharma on Sep 9th 2016 against PMG2015-GDOH-CRF-0006.1 [IN061724] End*/

	%>
	<!-- Added for GDOH -CRF-0029 by Dharma on 11th sep 2014 Start -->
	<input type="hidden" name="visit_adm_date_time" id="visit_adm_date_time" value="<%=visit_adm_date_time%>" />
	<!-- Added for GDOH -CRF-0029 by Dharma on 11th sep 2014 End -->
	<!--Added by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] Start-->
	<input type="hidden" name="isNatIdMandatory" id="isNatIdMandatory" value="<%=isNatIdMandatory%>" />
	<input type="hidden" name="isClearNatIdValues" id="isClearNatIdValues" value="<%=isClearNatIdValues%>" />
	<!--Added by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] End-->

	<input type="hidden" name="isValidateNatIDWithDOB" id="isValidateNatIDWithDOB" value="<%=isValidateNatIDWithDOB%>" /><!--Added by Dharma on Feb 20th 2017 against GDOH-CRF-0140 [IN:063489] -->
	<input type="hidden" name="chkGenderWithNatID" id="chkGenderWithNatID" value="<%=chkGenderWithNatID%>" /> <!--Added by Thamizh selvi on 24th Mar 2017 for GDOH-CRF-0145-->
	<input type="hidden" name="chkForm60Allow" id="chkForm60Allow" value="<%=chkForm60Allow%>" />   <!-- added by mujafar for KDAH-CRF-347 -->
	<input type="hidden" name="form60_value_chk" id="form60_value_chk" value="<%=form60_value_chk%>" />  <!-- added by mujafar for KDAH-CRF-370.1 & KDAH-CRF-347 -->
	<input type='hidden' name='pat_cat_sql' id='pat_cat_sql' value="">
	<!--for smart card-->
	<input type="hidden" name="txtSmartcard_path" id="txtSmartcard_path" value="<%=Smartcard_path%>">
	<input type="hidden" name="txtSmartcard_dup" id="txtSmartcard_dup" value="">
	<!--for smart card-->
	<!--for Alkhaleej smart card-->
	<input type="hidden" name="txtSmart_fn_name" id="txtSmart_fn_name" value="<%=function_name%>">
	<input type='hidden' name='nat_id_accept_alphanumeric_yn' id='nat_id_accept_alphanumeric_yn' value="<%=nat_id_accept_alphanumeric_yn%>">
	<input type='hidden' name='display_new_born_age_in_hrs' id='display_new_born_age_in_hrs' value="<%=display_new_born_age_in_hrs%>">
	<table border='0' cellpadding="0" cellspacing="0" width="100%" id=' '>
	<input type='hidden' name='CalledFromFunction' id='CalledFromFunction' value="<%=CalledFromFunction%>">	
	<input type='hidden' name='name_pfx_reqd_for_org_mem_yn' id='name_pfx_reqd_for_org_mem_yn' value="<%=name_pfx_reqd_for_org_mem_yn%>">
	<input type='hidden' name='dflt_patient_name' id='dflt_patient_name' value="<%=dflt_patient_name%>">	
	<input type='hidden' name='birthPlace' id='birthPlace' value="<%=birthPlace%>"></input>
	<input type='hidden' name='nationality' id='nationality' value="<%=nationality%>"></input>
	<input type='hidden' name='associated_relationship_code' id='associated_relationship_code' value=""></input>
	<input type='hidden' name='relation_level1_code' id='relation_level1_code' value="<%=(String)hash_Map1.get("combined_rel_level_code")%>"></input>
	<input type='hidden' name='relationship_level1_description' id='relationship_level1_description' value="<%=(String)hash_Map1.get("combined_rel_level_desc")%>"></input>
	
	<!--Below line added for this CRF GHL-CRF-0332 [IN:042060]-->
	<input type='hidden' name='alt_id1_man_non_ctz' id='alt_id1_man_non_ctz' value="<%=isAltId1ManNonCtz%>">	
	<!--CRF GHL-CRF-0332 [IN:042060] -->
	
	<!--Below line Added for this CRF GDOH-CRF-0029 [IN:048764] -->	
	<input type='hidden' name='localeName' id='localeName' value="<%=localeName%>">
	<input type='hidden' name='old_regn_datetime' id='old_regn_datetime' value="<%=old_regn_datetime%>">
	<!--End  GDOH-CRF-0029 [IN:048764] -->	
	<%
		if (localeName.equals("th"))
		{%>
			<input type='hidden' name='other_era_diff' id='other_era_diff' value="543"></input>
		<%}else{%>
			<input type='hidden' name='other_era_diff' id='other_era_diff' value="0"></input>
	<%}%>
	<input type='hidden' name='Select1' id='Select1' value="<%=defaultSelect%>"></input>
		<tr width="100%">
			<td width='20%'></td>
			<td width='25%'></td>
			<td width='15%'></td>
			<td width='40%'></td>
		</tr>
		<tr>
			<%
			/*Modified by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] Start*/
			String onChangeNatID	= "onChange='";
			if(!CalledFromFunction.equals("ChangePatDtls")) 
			 {
 				regpat_ser_val = "checkPatGenYN();";
			 } else if(CalledFromFunction.equals("ChangePatDtls")) {
				regpat_ser_val = "changeBLSuccess();"; 	
			 }
			if(isNatIdMandatory.equals("Y")){
				 if(regpat_ser_val.equals("")){
					regpat_ser_val = "chkNatlIdMandatory();";
				 }else{
					 regpat_ser_val	= "chkNatlIdMandatory();"+regpat_ser_val+"";
				 }
			}
			regpat_ser_val = onChangeNatID+regpat_ser_val+"'";
			/*Modified by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] End*/
			%>
			<td  class='label'  ><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></td>
			<td  class='fields'  ><Select name='pat_ser_grp_code' id='pat_ser_grp_code'  <%=regpat_ser_val%>>
			<%  String selct = "" ;
				
				 if(!CalledFromFunction.equals("ChangePatDtls")) {
					 if(CalledFromFunction.equals("PatientRegistration")) {
						 
						array_List2 = eMP.ChangePatientDetails.getPatSerGrpCode(conn,group,Site,facility,"PatientRegistration",p);
						flag = "Y";
					 }else if(CalledFromFunction.equals("RapidReg")) {
										

						array_List2 = eMP.ChangePatientDetails.getPatSerGrpCode(conn,group,Site,facility,"RapidReg",p);
						flag = "Y";
						 
					}
					if(CalledFromFunction.equals("EmergencyReg")) {  	 
						array_List2 = eMP.ChangePatientDetails.getPatSerGrpCode(conn,group,Site,facility,"EmergencyReg",p);
					 }
 					int k = 1; // 0th element is 'select' option. So k starts from 1
					%><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option><%
						
					for(int i=0;i<array_List2.size();i+=5) { 
						if(flag.equals("Y")) {	//For normal registartion
							if(((String)array_List2.get(i)).equals(dfltPSG))
							{
								selct = "selected";
								pat_name_in_loc_lang_reqd_yn = (String)array_List2.get(i+3);
							}
							else selct = "";
						}	 else  if(CalledFromFunction.equals("EmergencyReg")) { //For emergency registartion
							if(((String)array_List2.get(i)).equals(emeg_pat_ser_grp))
							{
								selct = "selected";
								pat_name_in_loc_lang_reqd_yn = (String)array_List2.get(i+3);
							}
							else selct = "";
						}	if(((String) array_List2.get(i+2)).equals("A")) 
							AltdfltPSG = (String) array_List2.get(i); 							
						%>
						<Option value="<%=(String)array_List2.get(i)%>"  <%=selct%>><%=(String)array_List2.get(i+1)%></Option>
						<%
						out.println("<script>") ;
						out.println("def_series["+k+"] = \""+(String)array_List2.get(i)+"`"+(String)array_List2.get(i+1)+"\";");
						out.println("pat_sergrp_id_types["+k+"] = \""+(String)array_List2.get(i+2)+"\";");
						out.println("pat_sergrp_reqd_yn["+k+"] = \""+(String)array_List2.get(i+4)+"\";");
						out.println("pat_name_in_loc_lang["+k+"] = \""+(String)array_List2.get(i+3)+"\";");
						k++;
						out.println("</script>");
					}
				}else{ 
					if(single_patient_numbering_yn.equals("Y"))	{
						String pat_ser_code = (String)hash_Map1.get("pat_ser_grp_code");
						//int k = 1;
						int k = 0;//Modified by Dharma on Apr 7th 2015 against HSA-CRF-0191 [IN:049772]
						rs_rh = stmt_rh.executeQuery("SELECT pat_ser_grp_code, short_desc, id_type, pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn FROM mp_pat_ser_grp_lang_vw WHERE language_id = '"+localeName+"' AND GEN_PID_USING_ALT_ID1_RULE_YN='N' and (pat_ser_grp_code='"+pat_ser_code+"' OR ASSOCIATED_PAT_SER_GRP_CODE='"+pat_ser_code+"' OR associated_pat_ser_grp_code in (Select ASSOCIATED_PAT_SER_GRP_CODE FROM MP_PAT_SER_GRP WHERE PAT_SER_GRP_CODE='"+pat_ser_code+"') OR pat_ser_grp_code in (Select ASSOCIATED_PAT_SER_GRP_CODE FROM MP_PAT_SER_GRP WHERE PAT_SER_GRP_CODE='"+pat_ser_code+"'))");
						
						while (rs_rh!=null && rs_rh.next()) {
							String pat_ser = (String)rs_rh.getString("pat_ser_grp_code");
							if(pat_ser.equals(pat_ser_code)) {
							%>
								<Option value="<%=(String)rs_rh.getString("pat_ser_grp_code")%>" selected><%=(String)rs_rh.getString("short_desc")%></Option>
							<%
							} else {

							%>
								<Option value="<%=(String)rs_rh.getString("pat_ser_grp_code")%>"><%=(String)rs_rh.getString("short_desc")%></Option>
								<%
							}
						out.println("<script>") ;
						out.println("def_series["+k+"] = \""+rs_rh.getString("pat_ser_grp_code")+"`"+(String)rs_rh.getString("short_desc")+"\";");
						out.println("pat_sergrp_id_types["+k+"] = \""+(String)rs_rh.getString("id_type")+"\";");
						out.println("pat_sergrp_reqd_yn["+k+"] = \""+(String)rs_rh.getString("prefix_reqd_yn")+"\";");
						out.println("pat_name_in_loc_lang["+k+"] = \""+(String)rs_rh.getString("pat_name_in_loc_lang_reqd_yn")+"\";");
						k++;
						out.println("</script>");

						}
					} else {

					%>
					<option value="<%=(String)hash_Map1.get("pat_ser_grp_code")%>"><%=(String)hash_Map1.get("pat_ser_grp_desc")%></option>

					<% 
						out.println("<script>pat_sergrp_id_types[0] = \""+(String)hash_Map1.get("id_type")+"\";</script>");
					}
				}%></Select><img src='../../eCommon/images/mandatory.gif'></img>

				</td>
				
				<%
/*END : Patient Series*/	
				if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("ChangePatDtls")) { %>
					<td  class='label' ><fmt:message key="eMP.PrefFacility.label" bundle="${mp_labels}"/></td>
					<td class='fields'><TABLE border='0'>
					<TR>

				<%if(CalledFromFunction.equals("PatientRegistration")) { 
					
				hash_Map5 = eMP.ChangePatientDetails.getFacilityDesc(conn, facility ,p);
					%>
				<td  class='fields'> <input type='text' name='pref_facility_desc' id='pref_facility_desc' size='30' maxlength='35' value="<%=checkForNull((String)hash_Map5.get("pref_facility_desc"))%>" onblur='if(this.value!=""){searchFacility(pref_facility_id,pref_facility_desc);}else{clearfields();}'   ><input type='button'  id='pref_facility_code'  name='pref_facility_id_id' id='pref_facility_id_id' value='?' class='button' onclick='searchFacility(this,pref_facility_desc)' >
				<input type='hidden' name='pref_facility_id' id='pref_facility_id' value="<%=checkForNull((String)hash_Map5.get("pref_facility_id"))%>">
				<% }else if(CalledFromFunction.equals("ChangePatDtls")) { %>
				<td  class='fields'> <input type='text' name='pref_facility_desc' id='pref_facility_desc' size='30' maxlength='35' value="<%=(String)hash_Map1.get("pref_facility_name")%>" onblur='if(this.value!=""){searchFacility(pref_facility_id,pref_facility_desc);}else{clearfields();}'   ><input type='button'  id='pref_facility_code'  name='pref_facility_id_id' id='pref_facility_id_id' value='?' class='button' onclick='searchFacility(this,pref_facility_desc)' >
				<input type='hidden' name='pref_facility_id' id='pref_facility_id' value="<%=(String)hash_Map1.get("pref_facility_id")%>">
				<% } %>

				</td>
					
				<%	if(CalledFromFunction.equals("ChangePatDtls")) {
					if(((String)hash_Map1.get("deceased_yn")).equals("Y")) { %>
						 <TD style='background-color:red'><BLINK><font color='yellow'><b><fmt:message key="Common.deceased.label" bundle="${common_labels}"/></b></font></BLINK></TD>
					<%
						String patient_deceased_yn = checkForNull((String)hash_Map1.get("deceased_yn"),"N");
						String patient_deceased_date = checkForNull((String)hash_Map1.get("deceased_date"));

						//code added for 21090

						if (!localeName.equals("en")) {
						patient_deceased_date = DateUtils.convertDate(patient_deceased_date,"DMYHMS","en",localeName); 
						}
					%>
					<input type='hidden' name='patient_deceased_yn' id='patient_deceased_yn' value='<%=patient_deceased_yn%>'>
					<input type='hidden' name='patient_deceased_date' id='patient_deceased_date' value='<%=patient_deceased_date%>'>
					<%}
					}%></TR>
					</TABLE> </TD>
						<%
				} else { %>	<td class='label' colspan='2'> </td><% }
		//		arrayList.clear();%>
				 </tr>
				<tr>
				<input type='hidden' name='pat_name_in_loc_lang_reqd_yn' id='pat_name_in_loc_lang_reqd_yn' value='<%=pat_name_in_loc_lang_reqd_yn%>'>
				<input type='hidden' name='ext_system_interface_yn' id='ext_system_interface_yn' value='<%=ext_system_interface_yn%>'>

				<% if(accept_national_id_no_yn.equals("Y")) { 
					System.out.println("ChangePatientSubNames.jsp::::nat_id_prompt..."+nat_id_prompt);
					%>
				<td class='label' id ='natidprompt' ><%=nat_id_prompt%></td>
				<td class='fields'   >
				<%  
				if (nat_id_reqd_all_series.equals("Y"))
						disp_nat_man_gif = "style='visibility:visible;'";
				else 
						disp_nat_man_gif = "style='visibility:hidden;'";

				if(CalledFromFunction.equals("ChangePatDtls")) {    
					if (id_change_allowed_for_series.equals("A") || (checkForNull((String)hash_Map1.get("id_type"))).equals(id_change_allowed_for_series)) {
						int count	= eMP.ChangePatientDetails.getMRAccessRights(facility, conn,p);

						System.out.println(" ::: Sethu count ::: "+count);
					
						//if(count==0){
						if(count==0 && (!((String)hash_Map1.get("national_id_no")).equals(""))){// Modified By dharma on July 3rd 2015 against PMG2015-CRF-HSA-0002 [IN:055774]
							rdonly = "disabled";	
						}else{
							rdonly = "";
						}
					} else if (((String)hash_Map1.get("national_id_no")).equals("")) {  
						rdonly = "disabled";//included for the CRF - BRU-HIMS-CRF 283 - Coding UT - 34833
						if(!((String)hash_Map1.get("nationality")).equals(def_nat_desc)) { //condition modified for the CRF - BRU-HIMS-CRF 283
							nat_id_reqd_all_series = "N";
							disp_nat_man_gif = "style='visibility:hidden;'";
						}		
					} else {
						rdonly = "disabled";
					}
				} else rdonly = "";
				
				if(disabled_fields.equals("disabled")) {
					nat_id_reqd_all_series = "N";
					disp_nat_man_gif = "style='visibility:hidden;'";
				}
				
				out.println("<input type='text' name='national_id_no' id='national_id_no' id='national_id_no1'  maxlength='"+disp_nat_id_length+"' size='"+disp_nat_id_length+"' "); 
				if(CalledFromFunction.equals("ChangePatDtls")) { 
					out.println(" value='"+checkForNull((String)hash_Map1.get("national_id_no"))+"' ");
				} else if(!a_national_id_no.equals("")) {  
					out.println(" value='"+a_national_id_no+"'  ");
				} 
	
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
	/*Added by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] Start*/
	String onBlurFunc	= "";
	if(isNatIdMandatory.equals("Y")){
		onBlurFunc	= "chkNatlIdMandatory();";
	}
	/*Added by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] End*/
	out.println("onkeypress=\"return "+nat_id_onKeyPress+"\"  onBlur=\"makeValidString(this);"+onBlurFunc+"validateNationality(this,'"+Site+"','"+(String)hash_Map.get("nat_id_pat_ser_grp")+"','"+invoke_routine+"','"+nat_data_source_id+"', '"+nat_id_check_digit_id+"','"+nat_id_chk_len+"','Y','N')\" "+rdonly+">");

				if( ext_system_interface_yn.equals("Y") && nat_id_check_digit_id.equals("M11") && nat_data_source_id.equals("") ) {
					if(CalledFromFunction.equals("ChangePatDtls") || 
						CalledFromFunction.equals("PatientRegistration")) {
				%>
					<input type='button' id='interface_button' value='I' name='ext_button' id='ext_button' class='button' onClick="dla_interface('<%=CalledFromFunction%>')"  <%=rdonly%>>
				<%
					}
				}
				
				/*
				if( ext_system_interface_yn.equals("N") && nat_id_check_digit_id.equals("M11_10") && nat_data_source_id.equals("") ) { }

				if( ext_system_interface_yn.equals("N") && nat_id_check_digit_id.equals("M11_5") && nat_data_source_id.equals("") ) { }

				if( ext_system_interface_yn.equals("N") && nat_id_check_digit_id.equals("") && nat_data_source_id.equals("NRIC") ) { }
				*/

				if( ext_system_interface_yn.equals("Y") && nat_id_check_digit_id.equals("") && nat_data_source_id.equals("NRIC") ) { 
					MdisEnb = "";
					if(CalledFromFunction.equals("ChangePatDtls")) {
						if(rdonly.equals("disabled")) MdisEnb = "disabled";
						else MdisEnb = "";
						ClickVal = "ReadDF1_onclick('C','NC');";
					} else if(CalledFromFunction.equals("PatientRegistration")) {
						ClickVal = "ReadDF1_onclick('P','NC');";
					} else if(CalledFromFunction.equals("EmergencyReg")) {
						ClickVal = "ReadDF1_onclick('E','NC');";
					} else if(CalledFromFunction.equals("RapidReg")) {
						ClickVal = "ReadDF1_onclick('R','NC');";
					}%><input type='button' id='interface_button' value='M' name='ext_button' id='ext_button' class='button' onClick="<%=ClickVal%>"  <%=MdisEnb%>><%
				}
				//ADDED BY PRITHIVI AADHAR CARD BUTTON SITE SPECIFIC KDAH-CRF-0362 14/04/2017
				String eKYCBtnDisabled = "";
				boolean isAADHAAREnabledYN = false; 
			    String profileIdExists = InterfaceUtil.isInterfaceProfileExisting("AADHAARPROF1");
				if("Y".equalsIgnoreCase(profileIdExists) && (CalledFromFunction.equals("ChangePatDtls") || 
					CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("RapidReg")) ) {
					isAADHAAREnabledYN = (XHUtil.singleParamExeQry("Select AADHAR_CONFIG_ENABLED_YN from MP_PARAM").equals("Y")) ? true : false;
					if (isAADHAAREnabledYN)
						eKYCBtnDisabled = "";
					else
						eKYCBtnDisabled = "disabled";

	            %>
					<input type='button' id='aadhar_num_int_button' value='eKYC' name='aadhar_num_int_button' id='aadhar_num_int_button' class='button' onClick="eKYCmp();" <%=eKYCBtnDisabled%> <%=rdonly%>>
					
				<%
				}
			%>
				<!--<input type='hidden' name='aadharPatPhotoStr' id='aadharPatPhotoStr' value=''>-->
				
				<input type='hidden' name='AADHAAR_STATUS' id='AADHAAR_STATUS' id='AADHAAR_STATUS' value=''>
				<input type='hidden' name='AADHAAR_TRANS_ID' id='AADHAAR_TRANS_ID' id='AADHAAR_TRANS_ID' value=''>
				<input type='hidden' name='AADHAAR_PHOTO_STR' id='AADHAAR_PHOTO_STR' id='AADHAAR_PHOTO_STR' value=''>

				<img src='../../eCommon/images/mandatory.gif' <%=disp_nat_man_gif%> name='nat_gif'></img></td>
			<% 
			} else {   
				if(!CalledFromFunction.equals("ChangePatDtls")) {
					%> <input type='hidden' name='national_id_no' id='national_id_no' value=''> <%
				} %><td class='label' colspan='2' ></td><%
			}
			if(CalledFromFunction.equals("ChangePatDtls")) { %>
				<input type='hidden' name='national_id_no_dup' id='national_id_no_dup' value="<%=(String)hash_Map1.get("national_id_no")%>"> 
			<% } %>
			<input type="hidden" name='Site' id='Site' value="<%=Site%>">
			<input type='hidden' name='nat_id_pat_ser_grp' id='nat_id_pat_ser_grp' value="<%=(String)hash_Map.get("nat_id_pat_ser_grp")%>">
			<input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value="<%=nat_id_prompt%>">
			<input type='hidden' name='invoke_routine' id='invoke_routine' value="<%=invoke_routine%>">
			<input type='hidden' name='nat_data_source_id' id='nat_data_source_id' value="<%=nat_data_source_id%>">
			<input type='hidden' name='nat_id_reqd_all_series' id='nat_id_reqd_all_series' value="<%=nat_id_reqd_all_series%>">
			<input type='hidden' name='nat_id_check_digit_id' id='nat_id_check_digit_id' value="<%=nat_id_check_digit_id%>">
			<input type='hidden' name='nat_id_chk_len' id='nat_id_chk_len' value="<%=nat_id_chk_len%>">
			<input type='hidden' name='nat_id_chk_len' id='nat_id_chk_len' value="<%=rdonly%>">
			<%/*For Other Alt No */ 
				if(Accept_oth_alt_id_yn.equals("Y")) 
				{ %>
				<td class='label'  ><fmt:message key="eMP.OtherAltNo.label" bundle="${mp_labels}"/></td>
				<td class='fields'  >			
				<select onchange='enableAltID();' name='other_alt_id' id='other_alt_id' >
				<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</Option>
				<%
				String sel = "";
				for(int i=0;i<array_List1.size();i+=2) {
					sel = "";
						if(CalledFromFunction.equals("ChangePatDtls")) {
							if(((String)hash_Map1.get("oth_alt_id_type")).equals((String)array_List1.get(i)))
								sel="selected"; 
							else sel = ""; 
						} else if(CalledFromFunction.equals("PatientRegistration")) {
							if(a_oth_alt_id_type.equals((String)array_List1.get(i)))
								sel="selected"; 
							else sel = ""; 
					} %>
					<Option value="<%=(String)array_List1.get(i)%>"  <%=sel%>><%=(String)array_List1.get(i+1)%></Option><%
				} %></select>
				<%
				out.println("<input type ='text' name='other_alt_Id_text' id='other_alt_Id_text' size='20' maxlength='20'  disabled ");
				if(CalledFromFunction.equals("ChangePatDtls"))
					out.println(" value=\""+(String)hash_Map1.get("demo_oth_alt_id_no")+"\" >");
				else if(CalledFromFunction.equals("PatientRegistration"))
					out.println(" value=\""+a_oth_alt_id_no+"\" ");
				else out.println(" value='' >");
				%></td><%
			} else { %><td class='label'  colspan='3'></td> <% }
			%>
			</tr>
	<!-- Alternate IDs-->	  
	
			<%
			
				/*Added by Dharma on 22nd Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
				String Alt_Id3_Reqd_Yn		= (String)hash_Map.get("Alt_Id3_Reqd_Yn");
				String isForm60Validation	= "N";
				String isCitizen			= checkForNull((String)hash_Map1.get("citizen_yn"),"Y");
				String form_60_yn			= checkForNull((String)hash_Map1.get("form_60_yn"),"N");
				Boolean isForm60Available	= CommonBean.isSiteSpecific(conn, "MP","REG_PAT_ALT_ID3_PAN_CARD");
				String isDisabledForm60		= "";
				//if(isCitizen.equals("N")){
				/*Commented by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809]*/
				/*if(isCitizen.equals("N") && isForm60Available){ //Modified By Dharma on 20th June 2016 against ML-MMOH-SCF-0434 [IN:060703]
					isDisabledForm60		= "disabled";
				}*/

			//&& isForm60Available
				if((!Alt_Id3_Type.equals("")) && !CalledFromFunction.equals("EmergencyReg") && isForm60Available ) { 
					isForm60Validation	= "Y";
					%>
					<tr>
						<td class='label'  ><fmt:message key="eMP.FormNo60.label" bundle="${mp_labels}"/></td>
						<td class='fields'  >			
							<select onchange='form60OnChange();' name='formno60' id='formno60' id='formno60' <%=isDisabledForm60%>>
								<option value='Y' <%if(form_60_yn.equals("Y")){%> selected<%}%>><fmt:message key="Common.yes.label" bundle="${common_labels}"/></Option>
								<option value='N' <%if(form_60_yn.equals("N")){%> selected<%}%>><fmt:message key="Common.no.label" bundle="${common_labels}"/></Option>
							</select>
						</td>
						<td colspan='2'></td>
					</tr>
				<%}%>
				<input type='hidden' name='isForm60Available' id='isForm60Available' id='isForm60Available' value="<%=isForm60Available%>" />
				<input type='hidden' name='isForm60Validation' id='isForm60Validation' id='isForm60Validation' value="<%=isForm60Validation%>" />
				<input type='hidden' name='isDisabledForm60' id='isDisabledForm60' id='isDisabledForm60' value="<%=isDisabledForm60%>" />
				<!--Added by Dharma on 22nd Jan 2016 for KDAH-CRF-0331 [IN058799] End-->
			<%  	
		if(CalledFromFunction.equals("ChangePatDtls")) {
			if ( ((String)hash_Map.get("alt_id1_accept_oth_pat_ser_yn")).equals("N")
				 && !(checkForNull((String)hash_Map1.get("id_type"))).equals("A")) {
				if( (checkForNull((String)hash_Map1.get("inhouse_birth_yn"))).equals("N"))  
					alt_id1_disable = "disabled";
			}
			if(alt_id1_chng_allowed_yn.equals("Y")) {
				alt_id1_disable = ""; 
			}
			else {
				if((checkForNull((String)hash_Map1.get("alt_id1_no"))).equals("")) alt_id1_disable = "";	 /*alt_id1_no*/
				else alt_id1_disable = "disabled";
				//if(id_change_allowed_for_series.equals("A")) alt_id1_disable = "";
			}
			/*If organization Membership is enabled*/
			if(family_org_id_accept_yn.equals("Y")) alt_id1_disable = "";	
			%><input type='hidden' name='alt_id1_db' id='alt_id1_db' value='<%=checkForNull((String)hash_Map1.get("alt_id1_no"))%>'><%
		}			
		%><tr><%

		if((!Alt_Id1_Type.equals(""))) {
			String onblur_part1 = "";
			if (dflt_alt_id1_in_emp_id_yn.equals("Y"))	exeStrEmpId = "assignEmpID(this);";
			%>						
			<td class='label'    name='alt_id1_desc' id='alt_id1_prompt'><input type='hidden' name='alt_id1_accept_alphanumeric' id='alt_id1_accept_alphanumeric' value="<%=alt_id1_accept_alphanumeric_yn%>"><%=(String)hash_Map.get("alt_id1_desc")%>
			</td><input type='hidden' name='alt_id1_desc' id='alt_id1_desc' value="<%=(String)hash_Map.get("alt_id1_desc")%>"><%
			out.print("<td class='fields'  ><input type='text'  name='alt_id1_no' id='alt_id1_no' maxlength='"+Alt_Id1_length+"' size='"+Alt_Id1_length+"'   ");
		/*Membership ID  validation,'chkMembershipID(this)' is moved to 'onChange' of Membership type - Vinod 3/18/2006*/
           onblur_part1 = "makeValidString(this); clearMembership();"+exeStrEmpId;			

		   if(CalledFromFunction.equals("ChangePatDtls")) {
				onblur_part1 = "chkMembershipID(this);makeValidString(this);"+exeStrEmpId ;
				if(!((String)hash_Map1.get("alt_id1_no")).equals("")) {
						out.print(" value=\""+checkForNull((String)hash_Map1.get("alt_id1_no"))+"\" ");	
					} else {
						out.print(" value=\"\" ");
						altid1datelookup = "disabled";
					}
			} else if(!a_alt_id1_no.equals("")) {
				out.print(" value=\""+a_alt_id1_no+"\" ");
			} else {
				out.print(" value=\"\" ");
				altid1datelookup = "disabled";
			}
			
			/*Depending on above various conditions Alt ID1 is either enabled or disabled*/
			
			out.print(" "+alt_id1_disable+" ");
			out.println(" onKeyPress='return SpecialCharRestriction(event)' ");
			if(((String)hash_Map.get("Alt_Id1_Unique_Yn")).equals("Y")) {
				out.print("onblur=\" ChangeToUpperCase(this);checkAlternateIdForUnique(this,1,'"+(String)hash_Map.get("Alt_Id1_Unique_Yn")+"','"+(String)hash_Map.get("alt_id1_routine_yn")+"','"+(String)hash_Map.get("alt_id1_routine")+"','"+ (String) hash_Map.get("alt_id1_chk_digit_scheme")+"','"+alt_id1_len_validation_yn+"','"+(String)hash_Map.get("alt_id1_accept_alphanumeric_yn")+"');"+onblur_part1+"\"> "); 
			} else {
				out.print("onblur=\" ChangeToUpperCase(this);checkAltIDLength(this,1,'"+alt_id1_len_validation_yn+"','"+(String)hash_Map.get("alt_id1_routine_yn")+"','"+(String)hash_Map.get("alt_id1_routine")+"','"+(String) hash_Map.get("alt_id1_chk_digit_scheme")+"','"+(String)hash_Map.get("alt_id1_accept_alphanumeric_yn")+"');"+onblur_part1+"\"> ");
			}
			String altid1_imgname = " id='alt1_gif' ";
			if(((String)hash_Map.get("Alt_Id1_Reqd_Yn")).equals("Y")) {   
				%><input type='hidden' name='alt_id1_reqd_yn' id='alt_id1_reqd_yn' value='Y'><img src='../../eCommon/images/mandatory.gif' style='visibility:visible' <%=altid1_imgname%>></img></td> 
			<%}else{ %>
					<input type='hidden' name='alt_id1_reqd_yn' id='alt_id1_reqd_yn' value='<%=citizen_requied%>'><img src='../../eCommon/images/mandatory.gif' 
					<%=altid1_imgname%>  style='<%=citizen_visibility%>'></img></td>
			<% }

			if(alt_id1_exp_date_show) { 
				%><td class='label'   ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
				<input type='hidden' name='alt_date1_reqd_yn' id='alt_date1_reqd_yn' value='<%=citizen_requied%>'>
				<!--Above line added for this CRF  GHL-CRF-0332 [IN:042060]-->
				<% 
				out.print("<td class='fields'><input type='text' id='altidexpdate1' name='alt_id1_exp_date' id='alt_id1_exp_date' maxlength='10' size='8'   ");
				if(CalledFromFunction.equals("ChangePatDtls")) {
						out.print(" value=\""+alt_id1_exp_date+"\" ");
						out.print(((String)hash_Map1.get("alt_id1_no")).equals("") ? "readonly" : "");
				} else if(CalledFromFunction.equals("PatientRegistration")) {
			
					if ( a_alt_id1_no.equals("") ) {
						out.print(" value=\""+a_alt_id1_exp_date+"\" readonly");
						altid1datelookup = "disabled";
					}else{
						out.print(" value=\""+a_alt_id1_exp_date+"\" ");
					}
				} else out.print(" value=''  readonly");
				out.print(" onBlur= \""+"makeValidString(this);checkExpiryDate(this,1);"+"\"  "+alt_id1_disable+"><img src='../../eCommon/images/CommonCalendar.gif' id='altidexpdt1' "+altid1datelookup+" onClick=\"return showCalendar('altidexpdate1'); \"  "+alt_id1_disable+" ><img src='../../eCommon/images/mandatory.gif' id='alt1_exp_date1' style='"+citizen_visibility+"'></img></td>");
				/*Above line modified for this CRF  GHL-CRF-0332 [IN:042060]*/
			} else { %> 
			   <input type='hidden' name='alt_date1_reqd_yn' id='alt_date1_reqd_yn' value='N'>
				<td class='label' ></td>
				<td class='label' ></td><%
			} 
			%>
			
			<input type='hidden' name='alt_id1_type' id='alt_id1_type' value="<%=Alt_Id1_Type%>">
			<% if(CalledFromFunction.equals("ChangePatDtls")) { %>
				<input type='hidden' name='alt_id1_no_dup' id='alt_id1_no_dup' value="<%=(String)hash_Map1.get("alt_id1_no")%>"><%
			} %></td><% 
		} else { %> <td colspan='4'></td></tr> <% }
		%><tr><%
		if((!Alt_Id2_Type.equals(""))) { %>
			 <td class='label'   id='alt_id2_prompt'><%=(String)hash_Map.get("alt_id2_desc")%></td><% 
			String alt_id2_disable	= "disabled";
			if(id_change_allowed_for_series.equals("A")) alt_id2_disable = "";
			out.print("<td  class='fields'  ><input type='text' name='alt_id2_no' id='alt_id2_no' maxlength='"+Alt_Id2_length+"' size='"+Alt_Id2_length+"'   '"+alt_id2_disable+"' onKeyPress='if("+alt_id2_specialchar_validation+"){ return SpecialCharRestriction(event)}'");/*Modified by Rameswar on 24/11/2016 for BSP-SCF-0021*/
			if(CalledFromFunction.equals("ChangePatDtls")) {
				if(!((String)hash_Map1.get("alt_id2_no")).equals("")) {
					alt_id2_disable="disabled";
					out.print(" value=\""+(String)hash_Map1.get("alt_id2_no")+"\" ");
				} else {
					out.print(" value=\"\" ");
					altid2datelookup = "disabled";
				}
			} else if(CalledFromFunction.equals("PatientRegistration")) {
				out.print(" value=\""+a_alt_id2_no+"\" ");
			} else {
				out.print(" value=\"\" ");
				altid2datelookup = "disabled";
			}
			if(((String)hash_Map.get("Alt_Id2_Unique_Yn")).equals("Y")) {
				out.print(" onBlur=\"if("+alt_id2_specialchar_validation+"){fnChkAlphaNumericForAltIds(this,2,'"+alt_id2_accept_alphanumeric_yn+"');}makeValidString(this);checkAlternateIdForUnique(this,2,'"+(String)hash_Map.get("Alt_Id2_Unique_Yn")+"','"+(String)hash_Map.get("alt_id2_routine_yn")+"','"+(String)hash_Map.get("alt_id2_routine")+"','"+(String) hash_Map.get("alt_id2_chk_digit_scheme")+"','"+alt_id2_len_validation_yn+"');\" > ");/*Modified by Rameswar on 24/11/2016 for BSP-SCF-0021*/
			} else {
				out.print(" onBlur=\"if("+alt_id2_specialchar_validation+"){fnChkAlphaNumericForAltIds(this,2,'"+alt_id2_accept_alphanumeric_yn+"');}makeValidString(this);checkAltIDLength(this,2,'"+alt_id2_len_validation_yn+"','"+(String)hash_Map.get("alt_id2_routine_yn")+"','"+(String)hash_Map.get("alt_id2_routine")+"','"+(String) hash_Map.get("alt_id2_chk_digit_scheme")+"');\" > ");/*Modified by Rameswar on 24/11/2016 for BSP-SCF-0021*/
			}	 
			if(((String)hash_Map.get("Alt_Id2_Reqd_Yn")).equals("Y")) { 
				String imgName = "";
				if(CalledFromFunction.equals("EmergencyReg")) {
					imgName = " id='alt2_gif' ";
				} 
				%><input type='hidden' name='alt_id2_reqd_yn' id='alt_id2_reqd_yn' value='Y'><img src='../../eCommon/images/mandatory.gif' id='alt2_gif' style='visibility:visible'></img></td><% 
			} else { %> <input type='hidden' name='alt_id2_reqd_yn' id='alt_id2_reqd_yn' value='N' /><img src='../../eCommon/images/mandatory.gif' id='alt2_gif' style='visibility:hidden'></td><% }
			
			if(alt_id2_exp_date_show) { 
				%><td class='label'   ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td><% 
				out.print("<td class='fields'    ><input type='text' id='altidexpdate2' name='alt_id2_exp_date' id='alt_id2_exp_date' maxlength='10' size='8'   ");
				if(CalledFromFunction.equals("ChangePatDtls")) {
					out.print(" value=\""+alt_id2_exp_date+"\" ");
					out.print(((String)hash_Map1.get("alt_id2_no")).equals("")? "readonly" : "");
				} else if(CalledFromFunction.equals("PatientRegistration")) {
			
					if ( a_alt_id2_no.equals("") ) {
						out.print(" value=\""+a_alt_id2_exp_date+"\" readonly");
						altid2datelookup = "disabled";
					}else{
						out.print(" value=\""+a_alt_id2_exp_date+"\" ");
					}
			} else  out.print(" value=\"\"  readonly");
		out.print(" onBlur=\""+"makeValidString(this);checkExpiryDate(this,2);"+"\"><img  src='../../eCommon/images/CommonCalendar.gif' id='altidexpdt2' "+altid2datelookup+" onClick=\"return showCalendar('altidexpdate2');\" >");
		} else { %> <td colspan='2'>&nbsp;</td> <% } %>
		<input type='hidden' name='alt_id2_type' id='alt_id2_type' value="<%=Alt_Id2_Type%>">
		<% if(CalledFromFunction.equals("ChangePatDtls")) { %>
			<input type='hidden' name='alt_id2_no_dup' id='alt_id2_no_dup' value="<%=(String)hash_Map1.get("alt_id2_no")%>"><%
		}%></td><% 
		} 
		else { %> <td colspan='4'></td> <% } %>
		</tr>
		<%if(!CalledFromFunction.equals("EmergencyReg")) { 
			%> <tr> <%
			if (!Alt_Id3_Type.equals("")){ %> 
				<td class='label'    id='alt_id3_prompt'><%=(String)hash_Map.get("alt_id3_desc")%></td>
				<% 
				String alt_id3_disable = "disabled";
				if(id_change_allowed_for_series.equals("A")) alt_id3_disable = "";





				out.print("<td  class='fields'   ><input type='text' name='alt_id3_no' id='alt_id3_no' "+isDisabledForm60+" maxlength='"+Alt_Id3_length+"' size='"+Alt_Id3_length+"'   '"+alt_id3_disable+"' onKeyPress='if("+alt_id3_specialchar_validation+"){return SpecialCharRestriction(event)}'");/*Added by Rameswar on 24/11/2016 for BSP-SCF-0021*/
				if(CalledFromFunction.equals("ChangePatDtls")) {
					if(!(((String)hash_Map1.get("alt_id3_no")).equals(""))) {
						 alt_id3_disable="disabled";
						 out.print(" value=\""+(String)hash_Map1.get("alt_id3_no")+"\" ");
					} else {out.print(" value=\"\" ");altid3datelookup = "disabled";}
				}
				else if(CalledFromFunction.equals("PatientRegistration")) {
					out.print(" value=\""+a_alt_id3_no+"\" ");
				} else {out.print(" value=\"\" ");altid3datelookup = "disabled";}
			if(((String)hash_Map.get("Alt_Id3_Unique_Yn")).equals("Y")) {
				out.print(" onBlur=\"if("+alt_id3_specialchar_validation+"){fnChkAlphaNumericForAltIds(this,3,'"+alt_id3_accept_alphanumeric_yn+"');}makeValidString(this);checkAlternateIdForUnique(this,3,'"+(String)hash_Map.get("Alt_Id3_Unique_Yn")+"','"+(String)hash_Map.get("alt_id3_routine_yn")+"','"+(String)hash_Map.get("alt_id3_routine")+"','"+(String) hash_Map.get("alt_id3_chk_digit_scheme")+"','"+alt_id3_len_validation_yn+"');\" >");/*Modified by Rameswar on 24/11/2016 for BSP-SCF-0021*/
			} else {
				out.print(" onBlur=\"if("+alt_id3_specialchar_validation+"){fnChkAlphaNumericForAltIds(this,3,'"+alt_id3_accept_alphanumeric_yn+"');}makeValidString(this);checkAltIDLength(this,3,'"+alt_id3_len_validation_yn+"','"+ (String)hash_Map.get("alt_id3_routine_yn")+"','"+(String)hash_Map.get("alt_id3_routine")+"','"+(String) hash_Map.get("alt_id3_chk_digit_scheme")+"');\" >");/*Modified by Rameswar on 24/11/2016 for BSP-SCF-0021*/
			}																						 
			//if(((String)hash_Map.get("Alt_Id3_Reqd_Yn")).equals("Y")) { 
			//if(((String)hash_Map.get("Alt_Id3_Reqd_Yn")).equals("Y") || (isForm60Available && isDisabledForm60.equals(""))) { //Modified By Dharma on 22nd Jan 2016 for KDAH-CRF-0331 [IN058799] 
				if(((String)hash_Map.get("Alt_Id3_Reqd_Yn")).equals("Y") && (!isForm60Available)) {//Modified by Dharma on july 13th 2016 against KDAH-SCF-0358 [IN:060809]
				%>
				<input type='hidden' name='alt_id3_reqd_yn' id='alt_id3_reqd_yn' value='Y'><img src='../../eCommon/images/mandatory.gif'  id='alt3_gif' style='visibility:visible'></img>
				<%} else { %> <input type='hidden' name='alt_id3_reqd_yn' id='alt_id3_reqd_yn' value='N'><img src='../../eCommon/images/mandatory.gif'  id='alt3_gif' style='visibility:hidden'></img> 
				
				<% }%> 



			<%if(alt_id3_exp_date_show) { %>
				</td><td class='label'   ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
				<td class='fields'     >
				<% out.print("<input type='text' id='altidexpdate3' name='alt_id3_exp_date' id='alt_id3_exp_date' maxlength='10' size='8'  ");
				if(CalledFromFunction.equals("ChangePatDtls")) {
						if(!((String)hash_Map1.get("alt_id3_exp_date")).equals("")) {
							out.print(" value=\""+alt_id3_exp_date+"\" ");
						} else out.print(" value=\"\"  ");
				} else if(CalledFromFunction.equals("PatientRegistration")) {
					//out.print(" value=\""+a_alt_id3_exp_date+"\" readonly ");
					if ( a_alt_id3_no.equals("") ) {
						out.print(" value=\""+a_alt_id3_exp_date+"\" readonly");
						altid3datelookup = "disabled";
					}else{
						out.print(" value=\""+a_alt_id3_exp_date+"\" ");
					}
				} else out.print(" value=\"\" readonly ");
				out.print(" onBlur=\""+"makeValidString(this);checkExpiryDate(this,3);"+"\"><img src='../../eCommon/images/CommonCalendar.gif' id='altidexpdt3' "+altid3datelookup+" onClick=\"return showCalendar('altidexpdate3');\" >");
		
			} else { %> <td colspan='2'>&nbsp;</td> <% } %>
			<input type='hidden' name='alt_id3_type' id='alt_id3_type' value="<%=Alt_Id3_Type%>">
			<% if(CalledFromFunction.equals("ChangePatDtls")) { %>
			<input type='hidden' name='alt_id3_no_dup' id='alt_id3_no_dup' value="<%=(String)hash_Map1.get("alt_id3_no")%>"><%
			} %>
			
			
			
			</td><%
		} else { %> <td colspan='4'></td> <% }	   %>
		</tr>
		<%
		if (!Alt_Id4_Type.equals(""))  { %> 
		   <tr>
			<td class='label'     id='alt_id4_prompt'><%=(String)hash_Map.get("alt_id4_desc")%></td>
			<% String alt_id4_disable	= "";
			if(id_change_allowed_for_series.equals("A")) alt_id4_disable = "";
			if(CalledFromFunction.equals("ChangePatDtls")) {
				if(!(((String)hash_Map1.get("alt_id4_no")).equals(""))) alt_id4_disable="disabled";
			}
			out.print("<td class='fields'  ><input type='text' name='alt_id4_no' id='alt_id4_no' maxlength='"+Alt_Id4_length+"' size='"+Alt_Id4_length+"'  '"+alt_id4_disable+"' onKeyPress='if("+alt_id4_specialchar_validation+"){return SpecialCharRestriction(event)}'");/*Modified by Rameswar on 24/11/2016 for BSP-SCF-0021*/
			if(CalledFromFunction.equals("ChangePatDtls")) {
				if(!(((String)hash_Map1.get("alt_id4_no")).equals(""))) 
					out.print(" value=\""+(String)hash_Map1.get("alt_id4_no")+"\" ");
				else
				{out.print(" value=\"\" ");altid4datelookup = "disabled";}
			}
			else if(CalledFromFunction.equals("PatientRegistration"))
			{out.print(" value=\""+a_alt_id4_no+"\" ");}
			else 
			{out.print(" value=\"\" ");altid4datelookup = "disabled";}
			if(((String)hash_Map.get("Alt_Id4_Unique_Yn")).equals("Y")) {
				out.print(" onBlur=\"if("+alt_id4_specialchar_validation+"){fnChkAlphaNumericForAltIds(this,4,'"+alt_id4_accept_alphanumeric_yn+"');}makeValidString(this);checkAlternateIdForUnique(this,4,'"+(String)hash_Map.get("Alt_Id4_Unique_Yn")+"','"+(String)hash_Map.get("alt_id4_routine_yn")+"','"+(String)hash_Map.get("alt_id4_routine")+"','"+(String) hash_Map.get("alt_id4_chk_digit_scheme")+"','"+alt_id4_len_validation_yn+"');\" >");/*Modified by Rameswar on 24/11/2016 for BSP-SCF-0021*/
			}
			else {	out.print(" onBlur=\"if("+alt_id4_specialchar_validation+"){fnChkAlphaNumericForAltIds(this,4,'"+alt_id4_accept_alphanumeric_yn+"');}makeValidString(this);checkAltIDLength(this,4,'"+alt_id4_len_validation_yn+"','"+ (String)hash_Map.get("alt_id4_routine_yn") +"','"+ (String)hash_Map.get("alt_id4_routine")+"','"+(String) hash_Map.get("alt_id4_chk_digit_scheme")+"');\" >");/*Modified by Rameswar on 24/11/2016 for BSP-SCF-0021*/
						}
				if(((String)hash_Map.get("Alt_Id4_Reqd_Yn")).equals("Y")) { %>
					<input type='hidden' name='alt_id4_reqd_yn' id='alt_id4_reqd_yn' value='Y'><img src='../../eCommon/images/mandatory.gif' id='alt4_gif' style='visibility:visible'></img>
				<% } else { %> <input type='hidden' name='alt_id4_reqd_yn' id='alt_id4_reqd_yn' value='N'><img src='../../eCommon/images/mandatory.gif' id='alt4_gif' style='visibility:hidden'> <% }
				if(alt_id4_exp_date_show) { %>
					</td><td class='label'   ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td><td class='fields'     >
					<% out.print("<input type='text' name='alt_id4_exp_date' id='alt_id4_exp_date' id='altidexpdate4' maxlength='10' size='8'  ");
						if(CalledFromFunction.equals("ChangePatDtls"))
						{
								out.print(" value=\""+alt_id4_exp_date+"\" ");
								out.print(((String)hash_Map1.get("alt_id4_no")).equals("") ? "readonly" : "" );
						}
						else if(CalledFromFunction.equals("PatientRegistration"))
						{
		
								if ( a_alt_id4_no.equals("") ) 
								{
									out.print(" value=\""+a_alt_id4_exp_date+"\" readonly");
									altid4datelookup = "disabled";
								}
								else
								{
									out.print(" value=\""+a_alt_id4_exp_date+"\" ");
								}
						}
						else out.print(" value=\"\"  readonly");
		
					out.print(" onBlur=\""+"makeValidString(this);checkExpiryDate(this,4);"+"\"><img  src='../../eCommon/images/CommonCalendar.gif' id='altidexpdt4' "+altid4datelookup+" onClick=\"return showCalendar('altidexpdate4');\" >");
				} else { %> <td colspan='2'>&nbsp;</td> <% } %>
				<input type='hidden' name='alt_id4_type' id='alt_id4_type' value="<%=Alt_Id4_Type%>">
				<% if(CalledFromFunction.equals("ChangePatDtls")) { %>
				<input type='hidden' name='alt_id4_no_dup' id='alt_id4_no_dup' value="<%=(String)hash_Map1.get("alt_id4_no")%>">
				<% } %></td>
			<% } else { %> <td colspan='4'></td> <% } %>
			</tr>
			<%}%>
	<%
	//** End of National ID, Other Alternate ID type and number and all alternate ID type's - Start of Naming fields  **//
	if(Family_No_Link_Yn.equals("Y") || family_org_id_accept_yn.equals("Y")) 
	{ 
	%>
		<tr></tr><tr></tr><tr></tr><tr>
		<%if(family_org_id_accept_yn.equals("Y")){%>
				<td  class='label'  ><fmt:message key="eMP.membership.label" bundle="${mp_labels}"/></td>
				<td class='fields' id='obj2'  >
					<select name="family_org_membership" id="family_org_membership" onchange="if (document.forms[0].CalledFromFunction.value=='ChangePatDtls') {changeMakeOrgMand(this)} else {makeOrgMandate(this)}" >
					<option selected value ="" >----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
					<option value ="1"><fmt:message key="eMP.organizationmember.label" bundle="${mp_labels}"/></option>
					<option value ="2"><fmt:message key="eMP.relatedmemberfamily.label" bundle="${mp_labels}"/></option>
					<option value ="3"><fmt:message key="eMP.relatedmembernonfamily.label" bundle="${mp_labels}"/></option>
					<option value ="4"><fmt:message key="eMP.nonorganizationmember.label" bundle="${mp_labels}"/></option>
				</select><img id='family_org_mem_img' src='../../eCommon/images/mandatory.gif'></img>
				<input type='hidden' name='prev_mem_type' id='prev_mem_type' value=''>
				<input type='hidden' name='mem_type_db' id='mem_type_db' value=''></td>
			<%if(CalledFromFunction.equals("ChangePatDtls")){
				String mem_type = (String)hash_Map1.get("MembershipType");%>
					<script> 
						document.forms[0].family_org_membership.value='<%=mem_type%>';
						document.forms[0].prev_mem_type.value='<%=mem_type%>'; 
						document.forms[0].mem_type_db.value='<%=mem_type%>'; 
						if ( '<%=mem_type%>'!='4') 
						{ 
							document.forms[0].alt_id1_no.disabled=false;
							
							if ( '<%=mem_type%>'!=''&& document.forms[0].alt_id1_man_non_ctz && document.forms[0].alt_id1_man_non_ctz.value=="false")  
								document.forms[0].alt1_gif.style.visibility='visible';
						} else { 
								document.forms[0].alt_id1_no.disabled=true;
								document.forms[0].alt1_gif.style.visibility='hidden';
						} 						
					</script><%}
				}
				if(family_org_id_accept_yn.equals("Y"))
					{%><td  class='label'   ><fmt:message key="Common.Organization.label" bundle="${common_labels}"/></td>
						<td  class='fields'  ><input type='text' name='organization' id='organization' disabled maxlength='' size='20' onblur='if(this.value!=""){get_org_sub_org(organization,sub_organization);}' onchange='clearFieldVal("org");'><input type='hidden' name='org_id' id='org_id' value=''><input type='button' disabled class='Button' id='org_id_btn' value='?' onclick='get_org_sub_org(organization,sub_organization)' >&nbsp;<input type='text' name='sub_org_desc' id='sub_org_desc' disabled size='20' onchange='clearFieldVal("suborg");' onblur='if(this.value!=""){get_sub_org(sub_org_desc);getPatCategory();}if(document.forms[0].name_prefix){document.forms[0].name_prefix.disabled=false;}if(document.forms[0].name_prefix_oth_lang){document.forms[0].name_prefix_oth_lang.disabled=false;}populateEmpDat(organization,org_id,this);populateEmpDat(organization,org_id,this);'><input type='hidden' name='sub_organization' id='sub_organization' value=''><input type='button' disabled class='Button' id='sub_org_id_btn' value='?' onclick='get_sub_org(sub_org_desc)' >

		
						<img id='org_sub_org' src='../../eCommon/images/mandatory.gif' style='visibility:hidden'></img><input type='hidden' name='selected_sub' id='selected_sub' value=''></td>
					<%if(CalledFromFunction.equals("ChangePatDtls")){
							
							String Orgname="";
							String Orgsubname = "";
							String OrgsubnameDesc = "";
							String family_org_id = "";
							
							if ( (checkForNull((String)hash_Map1.get("MembershipType")).equals("2")) || 					 (checkForNull((String)hash_Map1.get("MembershipType")).equals("3")) )
							{	
								String  rPatient_id =   eMP.ChangePatientDetails.getMemberPatID(checkForNull((String)hash_Map1.get("alt_id1_no")),conn,p);
								hash_Map2	= eMP.ChangePatientDetails.getOrgMembership(rPatient_id, conn,p);	
								
								Orgname = checkForNull((String)hash_Map2.get("Orgname"));
								Orgsubname = checkForNull((String)hash_Map2.get("Orgsubname"));
								OrgsubnameDesc = checkForNull((String)hash_Map2.get("OrgsubnameDesc"));
								family_org_id = checkForNull((String)hash_Map2.get("family_org_id"));								
								
							}else{
								Orgname = checkForNull((String)hash_Map1.get("Orgname"));
								Orgsubname = checkForNull((String)hash_Map1.get("Orgsubname"));
								OrgsubnameDesc = checkForNull((String)hash_Map1.get("OrgsubnameDesc"));
								family_org_id = checkForNull((String)hash_Map1.get("family_org_id"));
							}							
							%>
						<script>
								document.forms[0].organization.value='<%=Orgname%>';
								document.forms[0].org_id.value='<%=family_org_id%>';
								document.forms[0].selected_sub.value='<%=Orgsubname%>';		
								//document.forms[0].sub_org_desc.disabled=false;
						if ('<%=Orgname%>'!='')	 // for Non Organization member
						{	/*To populate sub org details*/	
							setTimeout('chg_get_sub_org();',1000);
							document.forms[0].sub_organization.value='<%=Orgsubname%>';
							document.forms[0].sub_org_desc.value='<%=OrgsubnameDesc%>';
						} /*For type 2,3,4 org suborg should be not updatable*/
		
						if ( (document.forms[0].family_org_membership.value=='2') 						  						||(document.forms[0].family_org_membership.value=='3')  								    		||(document.forms[0].family_org_membership.value=='4') )
						{
		
							document.forms[0].sub_org_desc.disabled=true;
							document.forms[0].organization.disabled=true;
							document.forms[0].org_id_btn.disabled=true;
							//  family_link_no should be enabled for Non Org member in update mode
							if (document.forms[0].family_org_membership.value!='4')
							{
								if (document.forms[0].family_link_no)
									document.forms[0].family_link_no.disabled=true;
								if (document.forms[0].head_pat_search_reg)
									document.forms[0].head_pat_search_reg.disabled=true;
							}
							else
							{
								if (document.forms[0].family_link_no)
									document.forms[0].family_link_no.disabled=false;
								if (document.forms[0].head_pat_search_reg)
									document.forms[0].head_pat_search_reg.disabled=false;
							}
						}
						</script><%
					}
				 }
				 %></tr><tr><%
				if (Family_No_Link_Yn.equals("Y"))	 {
				%>
				<td  class='label'  ><fmt:message key="eMP.HeadofFamilyPatientID.label" bundle="${mp_labels}"/></td>
				<%out.print("<td  class='fields'   ><input type='text' name='family_link_no' id='family_link_no' maxlength=\""+(String)hash_Map.get("Patient_Id_Length")+"\" size=\""+(String)hash_Map.get("Patient_Id_Length")+"\"   ");
					if(CalledFromFunction.equals("ChangePatDtls"))
					{ out.print(" onblur='getPatCategory();ChangeUpperCase(this);checkCurPatient(this);makeValidString(this);'value=\""+checkForNull((String)hash_Map1.get("family_link_no"))+"\" >"); 
					}else{
					out.print(" onblur='getPatCategory();makeValidString(this);ChangeUpperCase(this);enableimg();sendToServer(4)' value=\""+a_familyno+"\" >");
					}
					if(CalledFromFunction.equals("EmergencyReg"))
					{%><input type='hidden' name='head_pat_search_reg' id='head_pat_search_reg' value=''><input type='button' name='head_pat_search' id='head_pat_search' class='Button' value='?' onclick='get_patient_id()' >
					<%}else{%><input type='button' id='head_pat_search_reg' class='Button' value='?' onclick='get_patient_id()' >
					<%} %>  </td>


				  <td class='label'><fmt:message key="eMP.HeadofFamilyPatientName.label" bundle="${mp_labels}"/></td>
				<td class='data' id='head_pat_name'  colspan='1' >					<%if(CalledFromFunction.equals("ChangePatDtls")){%><%=(String)hash_Map1.get("head_patient_name")%>
					<%}
					%>
					</td>
				</tr>
			<tr>
			<%
					if(family_org_id_accept_yn.equals("Y"))
					{
					%>
					<td class='label'   ><fmt:message key="Common.relationship.label" bundle="${common_labels}"/> </td>
					<%
					}else{
					%>
					<td class='label'   ><fmt:message key="eMP.RelationshiptoHeadofFamily.label" bundle="${mp_labels}"/></td>
					<%}
		
		if(CalledFromFunction.equals("ChangePatDtls")) 
		{ 
		out.println("<td  class='fields'><input type='text' name='relationship_to_head_desc' id='relationship_to_head_desc' size='20' maxlength='20' value='"+(String)hash_Map1.get("relationship_name")+"' onblur='if(this.value!=\"\"){ searchRelationship1(relationship_to_head,relationship_to_head_desc);}else{clearfields();} validateFamilyNumber(this); getLevel(); if(document.forms[0].entitlement_by_pat_cat_yn.value==\"Y\"){getPatCategory();}'");
		}
		else
		 {
		out.println("<td  class='fields'><input type='text' name='relationship_to_head_desc' id='relationship_to_head_desc' size='20' maxlength='20' value='' onblur='if(this.value!=\"\"){ searchRelationship1(relationship_to_head,relationship_to_head_desc);}else{clearfields();} validateFamilyNumber(this); getLevel(); if(document.forms[0].entitlement_by_pat_cat_yn.value==\"Y\"){getPatCategory();if(this.value==\"\"){document.forms[0].pat_cat_code.value=\"\";document.forms[0].pat_cat_desc.value=\"\";document.forms[0].pat_cat_sql.value=\"\";}}'");

		 }
				
					if(CalledFromFunction.equals("ChangePatDtls")) 
					{ 
						if(!(((String)hash_Map1.get("family_link_no")).equals(""))) 
						{ 
							out.println(" >");
						}
						else 
						{ 
							out.println(" disabled >");
						}
							if(family_org_id_accept_yn.equals("Y")) 
							{
							%>
							<script>
								if ( (document.forms[0].family_org_membership.value=='2') || 	
									 (document.forms[0].family_org_membership.value=='3') || (document.forms[0].family_link_no.value!='') )
								{
								document.forms[0].relationship_to_head_desc.disabled=false;
								if(document.getElementById('relationship_to_head_code_id'))
								document.getElementById('relationship_to_head_code_id').disabled=false;
								}
							else
								{
								document.forms[0].relationship_to_head_desc.disabled=true;
								if(document.getElementById('relationship_to_head_code_id'))
								document.getElementById('relationship_to_head_code_id').disabled=true;
								}
							</script>
							<%}
					}
					else 
					{ 
						out.println(" disabled >");
					}  
					
					out.println("<input type='button'  id='relationship_to_head_id'  name='relationship_to_head_code_id' id='relationship_to_head_code_id' value='?' class='button' onclick='searchRelationship1(this,relationship_to_head_desc)' ");

					if(CalledFromFunction.equals("ChangePatDtls")) 
					{ 
						if(!(((String)hash_Map1.get("family_link_no")).equals(""))) 
						{ 
							out.println(" >");
						}
						else 
						{ 
							out.println("	 disabled >");
						}
					}
					else 
						{ 
							out.println("	 disabled >");
						}  
					
					
					if(CalledFromFunction.equals("ChangePatDtls")) 
					{
					out.println("<input type='hidden' name='relationship_to_head' id='relationship_to_head' value='"+(String)hash_Map1.get("relationship_to_head")+"'>");
					}else
					 {
					out.println("<input type='hidden' name='relationship_to_head' id='relationship_to_head' value=''>");
					 }

				%>

						<img id='rel' style='visibility:hidden' src='../../eCommon/images/mandatory.gif'></img>
				  </td>	 				
				  <td class ='label' id='relnlabel'>&nbsp;</td>
				  <td class='fields' id='relntext'>&nbsp;</td>	

					 <%
					}%>
			</tr><%}%>
<tr><td colspan='4' width='100%'>
<table border="0" cellpadding="2" cellspacing="0" width="100%" ><tr>
	<%oth_lang = true;
	if(((String)hash_Map.get("Name_Prefix_Accept_Yn")).equals("Y"))
		{ %>
		
		  <%if(pat_name_as_multipart_yn.equals("Y")){%>
				<td width='6%'></td><td width='5%'></td>
		  <%}else{%>
				<td width='6%' ></td>
		  <%}
		}
		if(pat_name_as_multipart_yn.equals("Y")){%>
			<td width='14%'></td><td width='5%'></td>
			<td width='15%'></td><td width='5%'></td>
			<td width='15%'></td><td width='5%'></td>
			<td width='15%'></td><td width='5%'></td>
	 <%}else{%>
			<td width='2%'></td>
	<%} /*prefix's place is suffix's place in local lang  */%>
	<%
		if ( ( (((String)hash_Map.get("Name_Suffix_Accept_Yn")).equals("Y")) 
			 && (pat_name_as_multipart_yn.equals("Y")) ) 
			|| (((String)hash_Map.get("Name_Prefix_Accept_Yn")).equals("Y")) )
		{%>	
			 <%if(pat_name_as_multipart_yn.equals("Y")){%>
					<td width='6%'></td><td width='5%'></td>
			 <%}else{%>
					<td width='6%' ></td>
			 <%}
		}
	%>
	<input type='hidden' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value="<%=pat_name_as_multipart_yn%>"></input>
	<input type='hidden' name='names_in_oth_lang' id='names_in_oth_lang' value="<%=names_in_oth_lang_yn%>"></input>
	<input type='hidden' name='AltdfltPSG' id='AltdfltPSG' value="<%=AltdfltPSG%>"></input>
	<input type='hidden' name='defaultSelect' id='defaultSelect' value="----<%=defaultSelect%>----"></input>
	</tr>
	<jsp:include page="../../eMP/jsp/PatNamesComp.jsp" ><jsp:param name="flush" value="true" />
	<jsp:param name="patient_id"         value="<%=patient_id%>"/>
	<jsp:param name="group"         value="<%=group%>"/>
	<jsp:param name="CalledFromFunction"         value="<%=CalledFromFunction%>"/>
	<jsp:param name="a_name_prefix"         value="<%=a_name_prefix%>"/>
	<jsp:param name="a_name_suffix"         value="<%=a_name_suffix%>"/>
	<jsp:param name="a_family_name"         value="<%=a_family_name%>"/>
	<jsp:param name="a_first_name"         value="<%=a_first_name%>"/>
	<jsp:param name="a_second_name"         value="<%=a_second_name%>"/>
	<jsp:param name="a_third_name"         value="<%=a_third_name%>"/>
	<jsp:param name="a_name_prefix_loc_lang" value="<%=a_name_prefix_loc_lang%>" />
	<jsp:param name="a_first_name_loc_lang" value="<%=a_first_name_loc_lang%>" />
	<jsp:param name="a_second_name_loc_lang" value="<%=a_second_name_loc_lang%>" />
	<jsp:param name="a_third_name_loc_lang" value="<%=a_third_name_loc_lang%>" />
	<jsp:param name="a_family_name_loc_lang" value="<%=a_family_name_loc_lang%>" />
	<jsp:param name="a_name_suffix_loc_lang" value="<%=a_name_suffix_loc_lang%>" />
	<jsp:param name="a_patient_name_loc_lang" value="<%=a_patient_name_loc_lang%>" />
	<jsp:param name="pat_name_in_loc_lang_reqd_yn" value="<%=pat_name_in_loc_lang_reqd_yn%>"/>
	</jsp:include> 
 <%
%>
</table>
</td>
</tr>
 <!-- End of Naming fields   -->
<tr></tr><tr></tr>
<% String emerg_sex_event = "";
	String sel_male = "";
	String sel_female = "";
	String sel_unknown = "";

			if(CalledFromFunction.equals("EmergencyReg")) { 
				emerg_sex_event = "onchange='callassignUnknowValues();'";
			} 
			
			if(CalledFromFunction.equals("ChangePatDtls")) {

				String gen = (String)hash_Map1.get("sex");
				if(gen.equals("M"))
					sel_male = "selected";
				else if(gen.equals("F"))
					sel_female = "selected";
				else if(gen.equals("U"))
					sel_unknown = "selected";
			}
			
			%>
			<tr>
				<td class='label' ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
				<td class='fields'  colspan='1'  >
				<Select name='sex' id='sex'  <%=emerg_sex_event%>>
					<Option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</Option>
					<option value='M' <%=sel_male%> ><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
					<option value='F'  <%=sel_female%> ><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
					<option value='U' <%=sel_unknown%> ><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				</Select><img src='../../eCommon/images/mandatory.gif'></img><%
				if(CalledFromFunction.equals("ChangePatDtls")) { 				
					
					age_value = (String) hash_Map1.get("p_age")==null?"":(String) hash_Map1.get("p_age");

					if(!age_value.equals("")) {

						StringTokenizer st = new StringTokenizer(age_value," ");

						while ( st.hasMoreTokens() ) {

							String date_elmnt = st.nextToken();						

							char ymdh_char = date_elmnt.charAt(date_elmnt.length()-1);							

							String ymdh_elmnt = date_elmnt.substring(0,(date_elmnt.length()-1));				

							if(ymdh_char=='Y') {
								year_value = ymdh_elmnt;
							     if(year_value.equals("0"))year_value="";
							} else if (ymdh_char=='M') {
								month_value	= ymdh_elmnt;
							     if(month_value.equals("0"))month_value="";
							} else if (ymdh_char=='D') {
								day_value	= ymdh_elmnt;
							   if(day_value.equals("0"))day_value="";
							} else if (ymdh_char=='H') {
								hours_value	= ymdh_elmnt;
								//if(hours_value.equals("0"))hours_value="";
							}
						}							
						
					}

					age_or_dob = (String) hash_Map1.get("calculated_age_yn");

					
					%>
					<script>document.forms[0].sex.value = "<%=(String)hash_Map1.get("sex")%>";</script>
					<input type='hidden' name='v_sex' id='v_sex' value="<%=(String)hash_Map1.get("sex")%>"><%
				} else if(CalledFromFunction.equals("PatientRegistration")) { 
					year_value	= year;
					month_value	= months;
					day_value	= days;
					%><script>document.forms[0].sex.value="<%=a_gender%>";</script><%
				} else if(CalledFromFunction.equals("RapidReg") || CalledFromFunction.equals("EmergencyReg")) { 	
					year_value	= "";
					month_value = "";
					day_value	= "";
					if(CalledFromFunction.equals("RapidReg")) {
						%><script>document.forms[0].sex.value="<%=a_gender%>";</script><%
					}
				} %>
				</td>
				
				<%					
					if(age_or_dob.equals("Y") && CalledFromFunction.equals("ChangePatDtls")) {					
						if( hours_value.equals("") ) {
							disable_age="";
						}
						check_age = "checked";
						disable_dob = "disabled";
					} else {
						disable_age="disabled";						
						check_age = "";
						disable_dob = "";
					}

					if(display_new_born_age_in_hrs.equals("")) {
							disable_hours = "disabled";
							disable_time = "disabled";
					} else if(age_or_dob.equals("Y") && CalledFromFunction.equals("ChangePatDtls")) {
						if( !hours_value.equals("") ) {
							disable_hours = "";
						}						
						disable_time = "disabled";
					} else {
						disable_hours = "disabled";
						disable_time = "";
					}

				%>
				<td class="label" ><fmt:message key="Common.age.label" bundle="${common_labels}"/> & <fmt:message key="Common.birthDate.label" bundle="${common_labels}"/> & <fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
				<td class='label'  ><input type='checkbox' name='age_or_dob' id='age_or_dob' <%=check_age%> onclick='disableEnableDate()' value='Y'></input>
				<input type='text' name='b_age' id='b_age' style='width:35' maxlength='3' onblur='gotoNext(this);disableEnableYMDH(this);' <%=disable_age%>  value='<%=year_value%>' onKeyPress="return ChkNumberInput(this,event,0)">&nbsp;Y
				<input type='text' name='b_months' id='b_months' style='width:25' maxlength='2' onblur='gotoNext(this);disableEnableYMDH(this);' <%=disable_age%>  value='<%=month_value%>' onKeyPress="return ChkNumberInput(this,event,0)">&nbsp;M
				<input type='text' name='b_days' id='b_days' style='width:25' maxlength='2' onblur='gotoNext(this);disableEnableYMDH(this);' <%=disable_age%>  value="<%=day_value%>" onKeyPress="return ChkNumberInput(this,event,0)">&nbsp;D

				<input type='text' name='b_hours' id='b_hours' style='width:25' maxlength='2'      value="<%=hours_value%>" onChange = 'gotoNext(this);' onBlur='disableEnableYMDH(this);' <%=disable_hours%> onKeyPress="return ChkNumberInput(this,event,0);">&nbsp;H

				<% if(CalledFromFunction.equals("ChangePatDtls")) { %>
					<input type='hidden' name='v_age' id='v_age' value="<%=year_value%>">
					<input type='hidden' name='v_months' id='v_months' value="<%=month_value%>">
					<input type='hidden' name='v_days' id='v_days' value="<%=day_value%>">
					<input type='hidden' name='v_hours' id='v_hours' value="<%=hours_value%>">
				<% } %> 
				&nbsp;<input type='text' name='date_of_birth' id='date_of_birth' id='dateofbirth' maxlength='10' size='8' <%=disable_dob%>    value="" onblur='gotoNext(this);disableEnableYMDH(this);calc_hij(this);'><img id='imgdateofbirth' src='../../eCommon/images/CommonCalendar.gif'  onClick="document.forms[0].date_of_birth.select();return showCalendar('dateofbirth','','','');"  <%=disable_dob%>><img src='../../eCommon/images/mandatory.gif'></img>
				<input type='hidden' name='Birth_Date' id='Birth_Date' value=''>
				<input type='hidden' name='v_date_of_birth' id='v_date_of_birth' value=''>				
				<input type='text' name='b_time' id='b_time'  maxlength='5' size='2'  value=""  onBlur="gotoNext(this);disableEnableYMDH(this);calc_hij(document.forms[0].date_of_birth);" <%=disable_time%> >&nbsp;T
				<!--MMS-QH-CRF-0145  added calc_hij(this); on blur of date_of_birth control-->
				<input type='hidden' name='hij_appl_YN' id='hij_appl_YN' value='<%=hij_appl_YN%>'>
				<input type='hidden' name='invalid_dob' id='invalid_dob' value='N'>
				<%if(hij_appl_YN.equals("Y")){ %>
					&nbsp;<img id='imgdateofbirth_hj' src='../../eCommon/images/CommonCalendar.gif'  onClick="document.forms[0].date_of_birth_hj.select();return showCalendar_hj('dateofbirth_hj','','','');"  ><input type='text' name='date_of_birth_hj' id='date_of_birth_hj' id='dateofbirth_hj' maxlength='10' size='8' <%=disable_dob%>    onblur='convertToGD(this);' value="<%=hijiri_b_date%>" ><fmt:message key="eMP.Hijri.label" bundle="${mp_labels}"/>
				<%}%>
				<!--MMS-QH-CRF-0145-->
				<%
					String sDate_of_birth = "";
					if (!a_date_of_birth.equals(""))
					{
							sDate_of_birth = a_date_of_birth;
							
					}
					/*Modified By Dharma on Sep 6th 2016 against PMG2015-GDOH-CRF-0006.1 [IN061724]*/
					//if(CalledFromFunction.equals("ChangePatDtls")) {
					if(CalledFromFunction.equals("ChangePatDtls") && !(checkForNull((String)hash_Map1.get("date_of_birth"))).equals("")) {
						sDate_of_birth = (String)hash_Map1.get("date_of_birth");
					%>
					<script>
						var dob_date='<%=sDate_of_birth%>'; 
						var dob_arr = dob_date.split(' '); 
						birth_date = dob_arr[0]; 
						dob_time = dob_arr[1]; 
						dob_time = dob_time.split(':'); 
						
						//dob_hrs = parseInt(dob_time[0],'10'); 
						//dob_min = parseInt(dob_time[1],'10'); 

						dob_hm = dob_time[0]+":"+dob_time[1];

						/*
						if(dob_min<30) {
							dob_hrs = dob_hrs;
						} else if(dob_min>=30) {
							dob_hrs = dob_hrs+1;
						} 
						if(dob_hrs<=9) {
							dob_hrs='0'+dob_hrs+':00';
						} else { 
							dob_hrs=dob_hrs+':00';
						}
						*/ 

					</script>
					<%						
						if (!localeName.equals("en")) {
						sDate_of_birth = DateUtils.convertDate(sDate_of_birth,"DMYHMS","en",localeName); 
					%>
						<script>
							birth_date = convertDate(birth_date,'DMY','en','<%=localeName%>');	
						</script>						
					<%
						}							
					%>						
						<script>
							document.forms[0].date_of_birth.value=birth_date;
							document.forms[0].v_date_of_birth.value=birth_date;
							document.forms[0].Birth_Date.value='<%=sDate_of_birth%>';
							if(document.getElementById('b_hours').value!="")
								document.forms[0].b_time.value = dob_hm;
						</script>

					<%
						if(hij_appl_YN.equals("Y")){
							if(hijiri_b_date.equals("")){%>
								<script>								
								calc_hij(document.forms[0].date_of_birth)
								</script>
							<%}
						}

						} else if(CalledFromFunction.equals("PatientRegistration")) { %>
					    <script>document.forms[0].date_of_birth.value='<%=sDate_of_birth%>'</script>
					<%
						} else if(CalledFromFunction.equals("RapidReg") || CalledFromFunction.equals("EmergencyReg")) { %>
					    <script>document.forms[0].date_of_birth.value=''</script>
					<%
							if(CalledFromFunction.equals("EmergencyReg")) {
								%>
									<script>document.forms[0].date_of_birth.disabled=false;</script>
								<%
							}						
						} 
					%>
					</td>
					
				</tr>
				<%	
					int count = 0;
					String dis_blood_grp = "";
					
					if(CalledFromFunction.equals("ChangePatDtls")) {							
						rs_rh = stmt_rh.executeQuery("select count(1) from bt_patient_blgrp_rh_ant where patient_id = '"+patient_id+"' ");
						if (rs_rh != null) {
								while(rs_rh.next() ) {
									count = rs_rh.getInt(1);
								}
						} rs_rh.close();								
				  }
					
				if(count > 0)
					dis_blood_grp = "disabled";								
			%>
				
				<tr>
					<td class="label">
						<fmt:message key="Common.bloodgroup.label" bundle="${common_labels}"/>
					</td>
					<td class='fields'>
						<select name='blood_group' id='blood_group' <%=dis_blood_grp%> ><option value='' >------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
							<%
							try {
											
								rs_rh = stmt_rh.executeQuery("select blood_grp , short_desc  from mr_blood_grp_lang_vw  where eff_status='E' AND language_id='"+localeName+"'");
								if (rs_rh != null) {
										while(rs_rh.next() ) {
											String BloodGroup = rs_rh.getString("blood_grp");
											String ShortDesc = rs_rh.getString("short_desc");
											if(CalledFromFunction.equals("ChangePatDtls")) {												
												if(BloodGroup.equals(patbloodgrp))
													selectAttribute="selected";
												else 
												selectAttribute="";	
											} 
											
											out.println("<option value ='"+BloodGroup+"' "+selectAttribute+">"+ShortDesc);
										}
								}
							}catch(Exception e) {
								out.println(e);
							} finally {
								if (rs_rh != null) rs_rh.close();								
							}
							%>
					    </select>
					</td>
					<td class='label'>
						<fmt:message key="eMR.RHDFactor.label" bundle="${mr_labels}"/>
					</td>
					<td class='fields'>
						<select name='rf_code' id='rf_code' <%=dis_blood_grp%> ><option value=''  >------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
							<%
								 try {
								   rs_rh = stmt_rh.executeQuery("select rhesus_factor_code, short_desc from mr_rhesus_factor_lang_vw  where eff_status='E' and language_id='"+localeName+"'");
								   if(rs_rh != null) {
									   while(rs_rh.next()) {
										   if(CalledFromFunction.equals("ChangePatDtls")) {
											   if(rs_rh.getString("rhesus_factor_code").equals(RHfactor))
													selectAttribute1="selected";
											   else 
													selectAttribute1="";	 
										   } 
										   out.println("<option value='" + rs_rh.getString("rhesus_factor_code") + "' "+selectAttribute1+">"+ rs_rh.getString("short_desc"));
									   }
									}
								
								 }catch(Exception e) {
									out.println(e);
								 } finally {
									if (rs_rh != null) rs_rh.close();									
								 }
								 %>
							</select>

							<%
							if(CalledFromFunction.equals("ChangePatDtls") || CalledFromFunction.equals("PatientRegistration"))
							{
								
							%>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<fmt:message key="Common.KnownAllergy.label" bundle="${common_labels}"/>
							<select name='known_allergy_yn' id='known_allergy_yn'  ><option value='U' >--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
							<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
							<option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
							</select>
							<%
							if(CalledFromFunction.equals("ChangePatDtls"))
							{
								String known_allergy_yn1 = checkForNull((String)hash_Map1.get("known_allergy_yn"));

								//String mr_install_yn = "N";
								int allergyCount = 0;

								rs_rh = stmt_rh.executeQuery("select (case when install_yn='Y' then(SELECT COUNT(*) cnt FROM PR_ALLERGY_SENSITIVITY WHERE PATIENT_ID='"+patient_id+"')end) allergyCount from sm_module where module_id = 'MR'");

								if(rs_rh!= null && rs_rh.next()) {
									//mr_install_yn = rs_rh.getString("install_yn");
									allergyCount  = rs_rh.getInt("allergyCount");
								}

								if(rs_rh!=null)
									rs_rh.close();	
								//commented as part of PE
								/*if(mr_install_yn.equals("Y")) {

									rs_rh = stmt_rh.executeQuery("SELECT COUNT(*) cnt FROM PR_ALLERGY_SENSITIVITY WHERE PATIENT_ID='"+patient_id+"'");

									if(rs_rh!=null && rs_rh.next()) {
										allergyCount = rs_rh.getInt("cnt");
									}

									if(rs_rh!=null)
										rs_rh.close();
									if(stmt_rh!=null)	
										stmt_rh.close();
								}*/
															
								%>
								<script>
										document.forms[0].known_allergy_yn.value='<%=known_allergy_yn1%>';
										if(<%=allergyCount%> > 0) {
											document.forms[0].known_allergy_yn.disabled = true;	
										}
								</script>
							<%}
							}
							else
							{%>
								<input type='hidden' name='known_allergy_yn' id='known_allergy_yn' value='U'>
								
							<%}%>
							
						</td>
				</tr>
				<tr>
						<td class='label'   ><fmt:message key="eMP.maritalstatus.label" bundle="${mp_labels}"/></td>

					<%if(CalledFromFunction.equals("ChangePatDtls")) { %>
					<td  class='fields'> <input type='text' name='mar_status_desc' id='mar_status_desc' size='20' maxlength='20' value="<%=(String)hash_Map1.get("mar_status_desc")%>" onblur='if(this.value!=""){searchMaritalStatus(mar_status_code,mar_status_desc);}else{clearfields();}'   ><input type='button'  id='mar_status_id'  name='mar_status_code_id' id='mar_status_code_id' value='?' class='button' onclick='searchMaritalStatus(this,mar_status_desc)' >
					<input type='hidden' name='mar_status_code' id='mar_status_code' value="<%=(String)hash_Map1.get("mar_status_code")%>">
					<% } else { %>
					<td  class='fields'> <input type='text' name='mar_status_desc' id='mar_status_desc' size='20' maxlength='20' value="" onblur='if(this.value!=""){searchMaritalStatus(mar_status_code,mar_status_desc);}else{clearfields();}'   ><input type='button'  id='mar_status_id'  name='mar_status_code_id' id='mar_status_code_id' value='?' class='button' onclick='searchMaritalStatus(this,mar_status_desc)' >
					<input type='hidden' name='mar_status_code' id='mar_status_code' value="">
					<% } %>



						<td class='label'  ><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/></td>
						<td  class='fields'   >	
						<%
						if(CalledFromFunction.equals("ChangePatDtls")) {
							if(!(((String)hash_Map1.get("birth_place_desc")).equals(""))) {
								birth_place_desc	= (String)hash_Map1.get("birth_place_desc");
								birth_place_code	= (String)hash_Map1.get("birth_place_code");
								birthenabledisable	= "disabled";
							}
							if(!(((String)hash_Map1.get("place_of_birth")).equals(""))) 
								birthenabledisable1 = "disabled";
							if(!nb_birth_place_code.equals("")) {
								birth_place_desc	= nb_birth_place_desc;
								birth_place_code	= nb_birth_place_code;
								birthenabledisable	= "disabled";
							} 
							%>
							
							<input type=hidden name='v_birth_place_code' id='v_birth_place_code' value="<%=birth_place_code%>">	
							<input type=hidden name='v_birth_place_desc' id='v_birth_place_desc' value="<%=birth_place_desc%>">
							<input type='text' name='place_of_birth_desc' id='place_of_birth_desc' size='15' maxlength='15' value="<%=birth_place_desc%>" onblur='CheckBirthPlace();if(this.value!="")searchBirthplace(place_of_birth_code,place_of_birth_desc); if(this.value==""){if(document.forms[0].place_of_birth_code)document.forms[0].place_of_birth_code.value="";}' onchange='CheckBirthPlace();'  <%=birthenabledisable1%>><input type='button'  id='birth_place_id'  name='birth_place' id='birth_place' value='?' class='button' onclick='searchBirthplace(this,place_of_birth_desc)'  <%=birthenabledisable1%>>
							<input type='hidden' name='place_of_birth_code' id='place_of_birth_code' value="<%=birth_place_code%>"><%
							if(!(((String)hash_Map1.get("place_of_birth")).equals(""))) { 					place_of_birth = (String)hash_Map1.get("place_of_birth");
							} %>
							<input type='text' name='place_of_birth' id='place_of_birth' maxlength='30' size='20'  value="<%=place_of_birth%>" onblur='makeValidString(this);' onchange='CheckBirthCode();' <%=birthenabledisable%>>
							<input type=hidden name="v_place_of_birth" id="v_place_of_birth" value="<%=place_of_birth%>">
							<%
						} else if ( (CalledFromFunction.equals("PatientRegistration")) || (CalledFromFunction.equals("EmergencyReg"))) { %>
							<input type='text' name='place_of_birth_desc' id='place_of_birth_desc' value="<%=a_birth_place_desc%>" size='15' maxlength='15' onblur='CheckBirthPlace();if(this.value !="")searchBirthplace(place_of_birth_code,place_of_birth_desc);'  onchange='CheckBirthPlace();' ><input type='button' name='birth_place' id='birth_place'  id='birth_place_id'  value='?' class='button' onclick='searchBirthplace(this,place_of_birth_desc)' >
							<input type='hidden' name='place_of_birth_code' id='place_of_birth_code' value=''><% if(a_birth_place_code.equals("")) { %>
								<input type="text" name="place_of_birth" id="place_of_birth" maxlength="30" size="20"  value="<%=a_place_of_birth%>" onblur='makeValidString(this);' onchange='CheckBirthCode();' ><%
							} else { %>
								<input type="text" name="place_of_birth" id="place_of_birth" maxlength="30" size="27"  value='' onblur='makeValidString(this);' onchange='CheckBirthCode();' ><%
							} 
						} else if(CalledFromFunction.equals("RapidReg")) { %>
						
							<input type='text' name='place_of_birth_desc' id='place_of_birth_desc' size='15' maxlength='15' onblur='if(this.value !="")searchBirthplace(place_of_birth_code,place_of_birth_desc);CheckBirthPlace();'  ><input type='button' name='birth_place' id='birth_place' id='birth_place_id' value='?' class='button' onclick='searchBirthplace(this,place_of_birth_desc)' >
							<input type='hidden' name='place_of_birth_code' id='place_of_birth_code' value=''>
							<input type="text" name="place_of_birth" id="place_of_birth" maxlength="23" size="20"   onblur='makeValidString(this);CheckBirthCode();' value=""><%
						} %>
						</td>
				 </tr>
			  	 <tr>
					<td  class="label" ><fmt:message key="Common.category.label" bundle="${common_labels}"/></td>
				<%
					if(CalledFromFunction.equals("ChangePatDtls")) { %>
					<td  class='fields'> <input type='text' name='pat_cat_desc' id='pat_cat_desc' size='20' maxlength='20' value="<%=(String)hash_Map1.get("pat_cat_desc")%>" onblur='if(this.value!=""){searchCategory(pat_cat_code,pat_cat_desc);}else{clearfields();} getExpDate(this.value,"<%=entitlement_by_pat_cat_yn%>")'   ><input type='button'  id='pat_cat_id'  name='pat_cat_code_id' id='pat_cat_code_id' value='?' class='button' onclick='searchCategory(this,pat_cat_desc)' >
					<input type='hidden' name='pat_cat_code' id='pat_cat_code' value="<%=(String)hash_Map1.get("pat_cat_code")%>">
					<% } else { if (entitlement_by_pat_cat_yn.equals("N"))
					{%>
					<td  class='fields'> <input type='text' name='pat_cat_desc' id='pat_cat_desc' size='20' maxlength='20' value="<%=patient_cat_desc%>" onblur='if(this.value!=""){searchCategory(pat_cat_code,pat_cat_desc);}else{clearfields();} getExpDate(this.value,"<%=entitlement_by_pat_cat_yn%>")'   ><input type='button'  id='pat_cat_id'  name='pat_cat_code_id' id='pat_cat_code_id' value='?' class='button' onclick='searchCategory(this,pat_cat_desc)' >
					<input type='hidden' name='pat_cat_code' id='pat_cat_code' value="<%=patient_cat_code%>">

					<%}else {%>
					<td  class='fields'> <input type='text' name='pat_cat_desc' id='pat_cat_desc' size='20' maxlength='20' value=""     onblur='if(this.value!=""){searchCategory(pat_cat_code,pat_cat_desc);}else{clearfields();}getExpDate(this.value,"<%=entitlement_by_pat_cat_yn%>")'><input type='button'  id='pat_cat_id'  name='pat_cat_code_id' id='pat_cat_code_id' value='?' class='button'  onclick='searchCategory(this,pat_cat_desc)'>
					<input type='hidden' name='pat_cat_code' id='pat_cat_code' value="">
					<%}  }%>
					<%if (entitlement_by_pat_cat_yn.equals("Y")){%>
					<img	id='imgCategoryMan' src='../../eCommon/images/mandatory.gif' style="display:inline"></td>
					<%}else{%><img id='imgCategoryMan' src='../../eCommon/images/mandatory.gif' style="display:none"></td><%}%>
					<%	if(CalledFromFunction.equals("ChangePatDtls"))
					{
						String pat_cat_code = checkForNull((String)hash_Map1.get("pat_cat_code"));%>
					<script>
						document.forms[0].pat_cat_code.value='<%=pat_cat_code%>'
					</script>
					<%}%>	
					<%if (entitlement_by_pat_cat_yn.equals("Y")){%>
						<td   class="label"  ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
						<td class='fields' ><input type='hidden' name='exp_val_appl_yn' id='exp_val_appl_yn' value=''><input type='text'  name='pat_cat_code_exp_date' id='pat_cat_code_exp_date' id='catExpDate' maxlength='' size='8' onblur='makeValidString(this);validDateObj(this,"DMY",localeName)' value="" ></input><img src='../../eCommon/images/CommonCalendar.gif' id='imgCatExpDate' 
						onClick="document.forms[0].pat_cat_code_exp_date.select();return showCalendar('catExpDate',null,null,true);" ><img	  id='imgCatExpDateMan' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></img></td>
					<%}else{%><td class='fields' colspan='2'><input type='hidden' name='exp_val_appl_yn' id='exp_val_appl_yn' value=''><input type='hidden' name='pat_cat_code_exp_date' id='pat_cat_code_exp_date' id='catExpDate' value=""><img id='imgCatExpDateMan' src='../../eCommon/images/mandatory.gif' style="visibility:hidden" ></img></td><%}%>
					<%if(CalledFromFunction.equals("ChangePatDtls")){
				String pat_cat_code = checkForNull((String)hash_Map1.get("pat_cat_code"));%>
				<script>document.forms[0].pat_cat_code.value='<%=pat_cat_code%>'</script><%}%>
					<%if ( (CalledFromFunction.equals("ChangePatDtls")) &&(entitlement_by_pat_cat_yn.equals("Y"))){ 
				String patexpirtydate = checkForNull((String)hash_Map1.get("patexpirtydate"));
				if (!patexpirtydate.equals("") && !localeName.equals("en"))
					patexpirtydate= DateUtils.convertDate(patexpirtydate,"DMY","en",localeName);
				%>
			<script>
				if (document.forms[0].pat_cat_code_exp_date)
				{	document.forms[0].pat_cat_code_exp_date.value='<%=patexpirtydate%>';
					if ('<%=patexpirtydate%>'=='')
					{
						document.forms[0].pat_cat_code_exp_date.disabled=true;
						document.getElementById('imgCatExpDate').disabled=true;
					}
					else
					{
						document.forms[0].pat_cat_code_exp_date.disabled=false;
						document.getElementById('imgCatExpDate').disabled=false;
					}
				 }
			</script><%
			} %>
		</tr>
		<tr>
					<% if(CalledFromFunction.equals("ChangePatDtls")) {
					String check		= "";
					String checkNon		= "";
					String checkenable	= "";
					String enableLegal	= "";

					if(((String)hash_Map1.get("citizen_yn")).equals("Y")) check="checked";
					else checkNon="checked";

					if(!(((String)hash_Map1.get("national_id_no")).equals(""))) checkenable="disabled";
					else checkenable="";	
					
					
					
					if(!(((String)hash_Map1.get("national_id_no")).equals(""))) {
						if(((String)hash_Map1.get("citizen_yn")).equals("Y")) {
							enableLegal="disabled";
						} else {
							enableLegal="";
						}
					} else { 
						if(((String)hash_Map1.get("citizen_yn")).equals("Y")) {
							enableLegal="disabled";
						} else {
							enableLegal="";
						}
					} 	

					%>
					<td  class="label"  ><fmt:message key="Common.residency.label" bundle="${common_labels}"/></td>
					<td   >
						<table width='100%'>
						  <tr>
							<td class="oaBorder"   >
								<input type='radio' name='citizen' id='citizen' value='Y' <%=check%> <%=checkenable%> onClick='changestatdis();' ><fmt:message key="Common.citizen.label" bundle="${common_labels}"/>
								<input type='radio' name='citizen' id='citizen' value='Y' <%=checkNon%>	<%=checkenable%> onClick='changestatus();' ><fmt:message key="Common.noncitizen.label" bundle="${common_labels}"/></td>
								<input type=hidden name='citizen_yn' id='citizen_yn' value="<%=(String)hash_Map1.get("citizen_yn")%>">
							</td>
							<td width='15%'>&nbsp;</td>
						  </tr>
						</table>
					</td>
					<td   class="label" ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
					<%  
					check		= "";									  
					checkNon	= "";
					if(((String)hash_Map1.get("legal_yn")).equals("Y")) check = "checked";
					else checkNon = "checked";
					%>
					<td  >
					<table width='100%'>
					<tr>
						<td class="oaBorder"    width='50%'><input type='radio' name='legal' id='legal' value="Y" checked  onClick='selVal();' <%=check%>  <%=enableLegal%> ><fmt:message key="Common.legal.label" bundle="${common_labels}"/><input type='radio' name='legal' id='legal' value="N" onClick='selVal();'  <%=checkNon%> <%=enableLegal%> ><fmt:message key="Common.illegal.label" bundle="${common_labels}"/></td>
						<td >&nbsp;</td>
					</tr>
					</table>
					</td>
					<input type=hidden name='legal_yn' id='legal_yn' value="<%=(String)hash_Map1.get("legal_yn")%>">
				<%} else if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("RapidReg") || CalledFromFunction.equals("EmergencyReg")){%>
					<td  class="label"  ><fmt:message key="Common.residency.label" bundle="${common_labels}"/></td>
					<td    >
						<table width='100%'>
							<tr>
								<td class="oaBorder"  >
								<input type='radio' id='citizenid' name='citizen' id='citizen' value='Y' checked onClick='change_stat_dis();' ><label for='citizenid' id='lbl1'><fmt:message key="Common.citizen.label" bundle="${common_labels}"/></label>
								<%
								if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("RapidReg") ){%>
								<input type='radio' id='citizenid2' name='citizen' id='citizen' value='Y' onClick='change_status();' >
								<%}else{%><input type='radio'  id='citizenid2' name='citizen' id='citizen' value='Y' onClick='change_status_emer();' ><%}%><label for='citizenid2' id='lbl2'><fmt:message key="Common.noncitizen.label" bundle="${common_labels}"/></label></td>
								<input type=hidden name='citizen_yn' id='citizen_yn' value="Y">
								<%if(CalledFromFunction.equals("PatientRegistration")) { %>
								<script>					 
									 if('<%=a_citizen_yn%>' == 'Y') {
										document.PatRegForm.citizen_yn.value='Y';
										document.PatRegForm.citizen[0].checked=true;}
									 else if('<%=a_citizen_yn%>' == 'N') {
										document.PatRegForm.citizen_yn.value='N';
										document.PatRegForm.citizen[1].checked=true;					
									} 
								</script>
								<%}%>
							</td>
							 <td width='15%'>&nbsp;</td> 
							</tr>
						</table>
					</td>
					<td   class="label" ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>				
					<td  ><table width='100%'><tr><td class="oaBorder"    width='50%'><input type='radio' name='legal' id='legal' value="Y" checked onClick='select_val();' 	  disabled><fmt:message key="Common.legal.label" bundle="${common_labels}"/><input type='radio' name='legal' id='legal' value="Y" onClick='select_val();'  disabled><fmt:message key="Common.illegal.label" bundle="${common_labels}"/></td>
					<td class='label' >&nbsp;</td></tr></table></td>
					<input type=hidden name='legal_yn' id='legal_yn' value="Y"><%
					if(CalledFromFunction.equals("PatientRegistration")) { %>
						<script>					 
							if('<%=a_legal_yn%>' == 'Y') {
								document.PatRegForm.legal_yn.value='Y';
								document.PatRegForm.legal[0].checked=true;
							} else if('<%=a_legal_yn%>' == 'N') {
								document.PatRegForm.legal_yn.value='N';
								document.PatRegForm.legal[1].checked=true;
							} 
						</script><%
					}  
				} 
			%>
			</tr>
			<tr>
			 <td class="label" ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
			 <td class='fields' ><% 			

				if(CalledFromFunction.equals("ChangePatDtls") || (PatInfflag.equals("Y")) || (RapidPatInfflag.equals("Y"))) { 
					
					String chkNat = "";
					%>
					<input type='text' name='nationality_desc' id='nationality_desc' size='20' maxlength='20'  onblur='if(this.value !="") searchCountry(contry_code[0], nationality_desc);clearrace();validateResidency(this);' value="<%=(String)hash_Map1.get("nationality_desc")%>"  <%=chkNat%>><input type='button' name='contry_code' id='contry_code' id='nat_id_btn' value='?' class='button' onclick='searchCountry(this,nationality_desc);clearrace();validateResidency(nationality_desc);'  <%=chkNat%>><img src='../images/mandatory.gif'></img>
					<input type='hidden' name='nationality_code' id='nationality_code' value="<%=(String)hash_Map1.get("nationality_code")%>">
					<%
					if(PatInfflag.equals("Y") || RapidPatInfflag.equals("Y"))
					{
					%>
					<input type="hidden" name="dft_natCd" id="dft_natCd" value="<%=checkForNull((String)hash_Map1.get("nationality_code"))%>">
					<input type="hidden" name="dft_natDesc" id="dft_natDesc" value="<%=checkForNull((String)hash_Map1.get("nationality_desc"))%>"></td><%
					}
				} else if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("RapidReg")) { 
					
					hash_Map3 = eMP.ChangePatientDetails.getCountryCodeDesc(conn, a_nationality_code, citizen_nationality_code,p);
					%>
					<input type='text' name='nationality_desc' id='nationality_desc' size='20' maxlength='20'  onblur='if(this.value !="") searchCountry(contry_code[0], nationality_desc); clearrace();validateResidency(this);' value="<%=checkForNull((String)hash_Map3.get("country_long_desc"))%>" ><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,nationality_desc);clearrace();validateResidency(nationality_desc);' ><img src='../images/mandatory.gif'></img>
					<input type='hidden' name='nationality_code' id='nationality_code' value="<%=checkForNull((String)hash_Map3.get("country_code"))%>">
					<input type="hidden" name="dft_natCd" id="dft_natCd" value="<%=checkForNull((String)hash_Map3.get("country_code"))%>">
					<input type="hidden" name="dft_natDesc" id="dft_natDesc" value="<%=checkForNull((String)hash_Map3.get("country_long_desc"))%>"><%
					//}
					} else if(CalledFromFunction.equals("EmergencyReg")) {
					hash_Map3 = eMP.ChangePatientDetails.getCountryCodeDesc(conn, a_nationality_code, citizen_nationality_code,p);
					%>
					<input type='text' name='nationality_desc' id='nationality_desc' size='20' maxlength='20'  onblur='if(this.value !="") search_Country(this, nationality_desc);validateResidency(this);' value="<%=checkForNull((String)hash_Map3.get("country_long_desc"))%>" ><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='search_Country(this,nationality_desc);validateResidency(nationality_desc);' ><img style='visibility:hidden;' name='natimg' src='../images/mandatory.gif'></img>
					<input type='hidden' name='nationality_code' id='nationality_code' value="<%=a_nationality_code%>">
					<input type='hidden' name='dflt_nationality_desc' id='dflt_nationality_desc' value="<%=checkForNull((String)hash_Map3.get("country_long_desc"))%>">
					<input type="hidden" name="dft_natCd" id="dft_natCd" value="<%=checkForNull((String)hash_Map3.get("country_code"))%>">
					
					<%
				} 
					%>
			<%
				race_trigger = "onchange='sendToServer(14,this)'"; 
				
				 hash_Map6 = eMP.ChangePatientDetails.getRaceDesc(conn,checkForNull((String)hash_Map.get("default_race_code")),p);
				 
			%>
				<td  class="label" ><fmt:message key="Common.race.label" bundle="${common_labels}"/>
				<input type = 'hidden' name = 'default_race_desc' value='<%=checkForNull((String)hash_Map6.get("race_desc"))%>'>
				</td>
				
				<%
					
					if(race_required_yn.equals("Y"))
						race_visibility = "visibility:visible";					
					else
						race_visibility = "visibility:hidden";
					
					if(CalledFromFunction.equals("PatientRegistration")) { 
						
						if(PatInfflag.equals("Y"))
						{
							hash_Map6 = eMP.ChangePatientDetails.getRaceDesc(conn, checkForNull((String)hash_Map1.get("race_code")) ,p);
							
							%>
							<td  class='fields'> <input type='text' name='race_desc' id='race_desc' size='20' maxlength='20' value="<%=checkForNull((String)hash_Map6.get("race_desc"))%>" onblur='if(this.value!=""){searchRace(race_code,race_desc);}else{clearfields();}'   ><input type='button'  id='race_id'  name='race_desc_id' id='race_desc_id' value='?' class='button' onclick='searchRace(this,race_desc)' >
							<input type='hidden' name='race_code' id='race_code' value="<%=(String)hash_Map1.get("race_code")%>">
							
							<%
						}
						else
						{
						
						hash_Map6 = eMP.ChangePatientDetails.getRaceDesc(conn,a_race_code ,p); //uncommented for HSA-SCF-0046
						
					%>
				<td  class='fields'> <input type='text' name='race_desc' id='race_desc' size='20' maxlength='20' value="<%=checkForNull((String)hash_Map6.get("race_desc"))%>" onblur='if(this.value!=""){searchRace(race_code,race_desc);}else{clearfields();}'   ><input type='button'  id='race_id'  name='race_desc_id' id='race_desc_id' value='?' class='button' onclick='searchRace(this,race_desc)' >
				<input type='hidden' name='race_code' id='race_code' value="<%=a_race_code%>">
				<% }
						}else if(CalledFromFunction.equals("RapidReg") || CalledFromFunction.equals("EmergencyReg")) { 
							if(RapidPatInfflag.equals("Y"))
						{
							hash_Map6 = eMP.ChangePatientDetails.getRaceDesc(conn, checkForNull((String)hash_Map1.get("race_code")) ,p);
														%>
							<td  class='fields'> <input type='text' name='race_desc' id='race_desc' size='20' maxlength='20' value="<%=checkForNull((String)hash_Map6.get("race_desc"))%>" onblur='if(this.value!=""){searchRace(race_code,race_desc);}else{clearfields();}'   ><input type='button'  id='race_id'  name='race_desc_id' id='race_desc_id' value='?' class='button' onclick='searchRace(this,race_desc)' >
							<input type='hidden' name='race_code' id='race_code' value="<%=(String)hash_Map1.get("race_code")%>">
						
						<%
						}
					else
					{
				hash_Map6 = eMP.ChangePatientDetails.getRaceDesc(conn, default_race_code ,p);
				%>
				<td  class='fields'> <input type='text' name='race_desc' id='race_desc' size='20' maxlength='20' value="<%=checkForNull((String)hash_Map6.get("race_desc"))%>" onblur='if(this.value!=""){searchRace(race_code,race_desc);}else{clearfields();}'   ><input type='button'  id='race_id'  name='race_desc_id' id='race_desc_id' value='?' class='button' onclick='searchRace(this,race_desc)' >
				<input type='hidden' name='race_code' id='race_code' value="<%=checkForNull((String)hash_Map.get("default_race_code"))%>">
				<% } }else if(CalledFromFunction.equals("ChangePatDtls")) { 
					
				hash_Map6 = eMP.ChangePatientDetails.getRaceDesc(conn, (String)hash_Map1.get("race_code") ,p);		%>
				<td  class='fields'> <input type='text' name='race_desc' id='race_desc' size='20' maxlength='20' value="<%=checkForNull((String)hash_Map6.get("race_desc"))%>" onblur='if(this.value!=""){searchRace(race_code,race_desc);}else{clearfields();}'   ><input type='button'  id='race_id'  name='race_desc_id' id='race_desc_id' value='?' class='button' onclick='searchRace(this,race_desc)' >
				<input type='hidden' name='race_code' id='race_code' value="<%=(String)hash_Map1.get("race_code")%>">
				<% } %>
				<font id='eg'><img id='image1' src='../images/mandatory.gif' style='<%=race_visibility%>'></img></font>
				<input type="hidden" name="dft_raceCd" id="dft_raceCd" value="<%=checkForNull((String)hash_Map.get("default_race_code"))%>">
				<input type='hidden' name='race_required_yn' id='race_required_yn' value = '<%=race_required_yn%>'>	
		
			  </td>
			   </tr>
				<tr>
					<td   class="label" ><fmt:message key="eMP.ethnicity.label" bundle="${mp_labels}"/></td>
					<%if((CalledFromFunction.equals("PatientRegistration") && (PatInfflag.equals("Y"))) || (RapidPatInfflag.equals("Y"))) { %>

					<td  class='fields'> <input type='text' name='ethnic_group_desc' id='ethnic_group_desc' size='20' maxlength='20' value="<%=(String)hash_Map1.get("ethnic_long_desc")%>" onblur='if(this.value!=""){searchEthnic(ethnic_group,ethnic_group_desc);}else{clearfields();}'   ><input type='button'  id='ethnic_id'  name='ethnic_group_id' id='ethnic_group_id' value='?' class='button' onclick='searchEthnic(this,ethnic_group_desc)' >
					<input type='hidden' name='ethnic_group' id='ethnic_group' value="<%=(String)hash_Map1.get("ethnic_grp_code")%>">

					<%}else if(CalledFromFunction.equals("ChangePatDtls")) { %>
					<td  class='fields'> <input type='text' name='ethnic_group_desc' id='ethnic_group_desc' size='20' maxlength='20' value="<%=(String)hash_Map1.get("ethnic_long_desc")%>" onblur='if(this.value!=""){searchEthnic(ethnic_group,ethnic_group_desc);}else{clearfields();}'   ><input type='button'  id='ethnic_id'  name='ethnic_group_id' id='ethnic_group_id' value='?' class='button' onclick='searchEthnic(this,ethnic_group_desc)' >
					<input type='hidden' name='ethnic_group' id='ethnic_group' value="<%=(String)hash_Map1.get("ethnic_grp_code")%>">
					<% } else { %>
					<td  class='fields'> <input type='text' name='ethnic_group_desc' id='ethnic_group_desc' size='20' maxlength='20' value="" onblur='if(this.value!=""){searchEthnic(ethnic_group,ethnic_group_desc);}else{clearfields();}'   ><input type='button'  id='ethnic_id'  name='ethnic_group_id' id='ethnic_group_id' value='?' class='button' onclick='searchEthnic(this,ethnic_group_desc)' >
					<input type='hidden' name='ethnic_group' id='ethnic_group' value="">
					<% } %>
					</td>

				<td  class="label" ><fmt:message key="Common.religion.label" bundle="${common_labels}"/></td>

				<%if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("RapidReg") || CalledFromFunction.equals("EmergencyReg")) { 
				if((CalledFromFunction.equals("PatientRegistration") && (PatInfflag.equals("Y"))) || (RapidPatInfflag.equals("Y")))
				{%>
					<td  class='fields'> <input type='text' name='relgn_desc' id='relgn_desc' size='20' maxlength='20' value="<%=(String)hash_Map1.get("relgn_desc")%>" onblur='if(this.value!=""){searchReligion(relgn_code,relgn_desc);}else{clearfields();} '   ><input type='button'  id='relgn_id'  name='relgncode_id' id='relgncode_id' value='?' class='button' onclick='searchReligion(this,relgn_desc)' >
					<input type='hidden' name='relgn_code' id='relgn_code' value="<%=(String)hash_Map1.get("relgn_code")%>">
				<%}
				else
				{
					
				hash_Map7 = eMP.ChangePatientDetails.getReligionDesc(conn, dflt_relgn_code,p);
					%>
				<td  class='fields'> <input type='text' name='relgn_desc' id='relgn_desc' size='20' maxlength='20' value="<%=checkForNull((String)hash_Map7.get("relgn_desc"))%>" onblur='if(this.value!=""){searchReligion(relgn_code,relgn_desc);}else{clearfields();}'   ><input type='button'  id='relgn_id'  name='relgncode_id' id='relgncode_id' value='?' class='button' onclick='searchReligion(this,relgn_desc)' >
				<input type='hidden' name='relgn_code' id='relgn_code' value="<%=checkForNull((String)hash_Map7.get("relgn_code"))%>">
				<% }
				}else if(CalledFromFunction.equals("ChangePatDtls")) { %>
				<td  class='fields'> <input type='text' name='relgn_desc' id='relgn_desc' size='20' maxlength='20' value="<%=(String)hash_Map1.get("relgn_desc")%>" onblur='if(this.value!=""){searchReligion(relgn_code,relgn_desc);}else{clearfields();}'   ><input type='button'  id='relgn_id'  name='relgncode_id' id='relgncode_id' value='?' class='button' onclick='searchReligion(this,relgn_desc)' >
				<input type='hidden' name='relgn_code' id='relgn_code' value="<%=(String)hash_Map1.get("relgn_code")%>">
				<% } %>

				</td>

				</tr>
				<tr>
				
				<td class='label' ><fmt:message key="Common.Language.label" bundle="${common_labels}"/></td>
				<%
				if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("RapidReg") || CalledFromFunction.equals("EmergencyReg")) { 
				if((CalledFromFunction.equals("PatientRegistration") && (PatInfflag.equals("Y"))) || (RapidPatInfflag.equals("Y")))
				{ %>
					<td  class='fields'> <input type='text' name='language_desc' id='language_desc' size='20' maxlength='20' value="<%=(String)hash_Map1.get("language_desc")%>" onblur='if(this.value!="")searchLanguage(language_code,language_desc);'   ><input type='button'  id='language_id'  name='language_code_id' id='language_code_id' value='?' class='button' onclick='searchLanguage(this,language_desc)'  >
					<input type='hidden' name='language_code' id='language_code' value="<%=(String)hash_Map1.get("pat_language_id")%>">
				<%}else if(CalledFromFunction.equals("PatientRegistration") && PatInfflag.equals("") && RapidPatInfflag.equals(""))
				{
				// Code Fix Aganist Incident Number 34531 By SaanthaakumarG Dated on 10-08-2012
				
				if(!appt_ref_no.equals("")&& !language_id.equals("")){
					hash_Map4 = eMP.ChangePatientDetails.getLanguageDesc(conn,language_id,p);
				}else{
					hash_Map4 = eMP.ChangePatientDetails.getLanguageDesc(conn,dflt_language_id,p);
				}
				%>			
				<td  class='fields'><input type='text' name='language_desc' id='language_desc' size='20' maxlength='20' value="<%=checkForNull((String)hash_Map4.get("language_desc"))%>" onblur='if(this.value!="")searchLanguage(language_code,language_desc);'   ><input type='button'  id='language_id'  name='language_code_id' id='language_code_id' value='?' class='button' onclick='searchLanguage(this,language_desc)'  >
				<input type='hidden' name='language_code' id='language_code' value="<%=checkForNull((String)hash_Map4.get("language_id"))%>">			
				
				<%}else
				{
					
				hash_Map4 = eMP.ChangePatientDetails.getLanguageDesc(conn, dflt_language_id,p);
					%>
				<td  class='fields'> <input type='text' name='language_desc' id='language_desc' size='20' maxlength='20' value="<%=checkForNull((String)hash_Map4.get("language_desc"))%>" onblur='if(this.value!="")searchLanguage(language_code,language_desc);'   ><input type='button'  id='language_id'  name='language_code_id' id='language_code_id' value='?' class='button' onclick='searchLanguage(this,language_desc)'  >
				<input type='hidden' name='language_code' id='language_code' value="<%=checkForNull((String)hash_Map4.get("language_id"))%>">
				<% 
				}
				}else if(CalledFromFunction.equals("ChangePatDtls"))
				{ 
				//Issue Fix added for the Incident no : 34531 as on 10/08/2012
				/*try
					{
					lang_stmt=conn.createStatement();
					lang_rest=lang_stmt.executeQuery("select LANGUAGE_ID from mp_patient where patient_id='"+patient_id+"'");
					lang_rest.next();
					pat_lang_id=lang_rest.getString(1);
					
					lang_stmt.close();
					lang_rest.close();
					}
				catch(SQLException e)	
					{
					e.printStackTrace();
					System.out.println("Exception occurred while getting the Language ID from mp_patient "+e);
					}
				finally
					{
					try
						{
						if(lang_stmt!=null)
						lang_stmt.close();
						}
					catch(Exception e)	
						{}
					}
				hash_Map8 = eMP.ChangePatientDetails.getLanguageDesc(conn,pat_lang_id,p);
				//hash_Map1 has been changed to hash_Map8 in the below <TD>
				//End*/
				%>
				
				<td  class='fields'><input type='text' name='language_desc' id='language_desc' size='20' maxlength='20' value="<%=checkForNull((String)hash_Map1.get("language_desc"))%>" onblur='if(this.value!="")searchLanguage(language_code,language_desc);'><input type='button'  id='language_id'  name='language_code_id' id='language_code_id' value='?' class='button' onclick='searchLanguage(this,language_desc)' >
				<input type='hidden' name='language_code' id='language_code'  value="<%=checkForNull((String)hash_Map1.get("pat_language_id"))%>"><!--pat_language_id modified by Rameswar on 09/11/2016 against IN62532 -->
				<% } %>
				<%
				String sel_right = "";
				String sel_left = "";
				String sel_Y = ""; //Added for MYHIX integration ML-MMOH-CRF-0507.1.
				String sel_N = ""; //Added for MYHIX integration ML-MMOH-CRF-0507.1.
				if(CalledFromFunction.equals("ChangePatDtls")) {

					String eye_indicator = checkForNull((String)hash_Map1.get("eye_indicator"));
					
					if(eye_indicator.equals("RE"))
						sel_right = "selected";
					else if(eye_indicator.equals("LE"))
						sel_left = "selected";			


					/*  block added for MYHIX integration ML-MMOH-CRF-0507.1. */
					myhix_consent = checkForNull((String)hash_Map1.get("myhix_consent"));
					myhix_pat_id = checkForNull((String)hash_Map1.get("myhix_pat_id"));


					
					if(myhix_consent.equals("Y")){
						sel_Y = "selected";
					}else{
						sel_N = "selected";	
					}
					/* end MYHIX block */
			   }
				%>
				</td>
				<td class="label">
						<fmt:message key="eMP.OneEye.label" bundle="${mp_labels}"/>
					</td>
					<td class='fields'>
						<select name='eye_indicator' id='eye_indicator'><option value='' >------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
						<option value='RE' <%=sel_right%>><fmt:message key="eMP.OneRightEye.label" bundle="${mp_labels}"/></option>
							<option value='LE' <%=sel_left%>><fmt:message key="eMP.OneLeftEye.label" bundle="${mp_labels}"/></option>
							
					    </select>
					</td>
				</tr><tr>
				<%
				if(CalledFromFunction.equals("PatientRegistration") || CalledFromFunction.equals("ChangePatDtls"))  { %>
					<td   class="label" ><fmt:message key="eMP.AliasName.label" bundle="${mp_labels}"/></td>
					<td  class='fields'><%
					String event_value = "";
					if(Demoaddlcnt > 0) {
						event_value = "onblur='makeValidString(this);'";
					} else {
						if(CalledFromFunction.equals("ChangePatDtls") || CalledFromFunction.equals("PatientRegistration")) { 
							event_value = "onblur='makeValidString(this);'";
						} 
					}
					%>
					<input type='text' name='alias_name' id='alias_name' maxlength='30' size='20' value=""   <%=event_value%>></td>
					<!--Below line Added for this CRF GDOH-CRF-0029 [IN:048764] --><!--below line Removed Seconds-->
					<!-- Added by Sangeetha for GDOH-CRF-0148 on 17-mar-17--> 
					<% if(disableRegnDate) {
						if(CalledFromFunction.equals("ChangePatDtls") && downtime_regn_yn.equals("Y") && checkForNull((String)hash_Map1.get("regn_date")).equals("")) {  %>
							<td   class="label" ><fmt:message key="Common.RegistrationDate.label" bundle="${common_labels}"/> <fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
							<td  class='fields'><input type='text'  id='disasregndatetime' name="disas_regn_date_time" id="disas_regn_date_time"  value="<%=regn_date%>" maxLength='19' size='19' onBlur='chkRegDateTime(this);' ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('disasregndatetime','dd/mm/yyyy' ,'hh:mm',null );" style='cursor:pointer'></img>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></img></td>
						<%}else{ %>
					<td   class="label" ><fmt:message key="Common.RegistrationDate.label" bundle="${common_labels}"/> <fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
							<td class='fields' ><input type='text'  id='disasregndatetime' name="disas_regn_date_time" id="disas_regn_date_time"  value="<%=regn_date%>" maxLength='19' size='19' disabled><img src="../../eCommon/images/CommonCalendar.gif" style='cursor:pointer' disabled></img></td>  
						<%} 
					}
					else{
					%>
						<td   class="label" ><fmt:message key="Common.RegistrationDate.label" bundle="${common_labels}"/> <fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
					<td  class='fields'><input type='text'  id='disasregndatetime' name="disas_regn_date_time" id="disas_regn_date_time"  value="<%=regn_date%>" maxLength='19' size='19' onBlur='chkRegDateTime(this);' ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('disasregndatetime','dd/mm/yyyy' ,'hh:mm',null );" style='cursor:pointer'></img>&nbsp;<img src='../../eCommon/images/mandatory.gif' ></img></td>
					<% } %>
					<!--End GDOH-CRF-0029 [IN:048764] -->
	
					<%if(CalledFromFunction.equals("ChangePatDtls")) {  %>
						<script>
							document.forms[0].alias_name.value = "<%=(String)hash_Map1.get("alias_name")%>";
						</script><%
					}
				} else { %>
					<td class='label' colspan='2'></td> 
				<% } %>
	
			</tr>

			<!-- if block Added for MYHIX integration ML-MMOH-CRF-0507.1. -->
			<% if (myhix_appl_YN.equals("Y")){%>				
				<tr><td class="label" ><fmt:message key="eMP.ConsentforMyHIX.label" bundle="${mp_labels}"/></td><td class="fields" ><select name='myhix_consent' id='myhix_consent'>
							<option value='Y' <%=sel_Y%>>Yes</option>
								<option value='N' <%=sel_N%>>No</option>							
							</select>
					</td>
					<%if(CalledFromFunction.equals("ChangePatDtls")) {  %>			 
						<td class="label" ><fmt:message key="eMP.MyHIXGlobalID.label" bundle="${mp_labels}"/></td>
						<!--td class="fields" ><input type="text" readonly name="myhix_pat_id" id="myhix_pat_id" value='<%=myhix_pat_id%>' size='60'></td-->
						<td class="label" ><%=myhix_pat_id%></td>
					<% }else{%>
						<td colspan='2'>&nbsp;</td>
					<%}%>
				</tr>
			<%}%>


		<% if(conn != null) ConnectionManager.returnConnection(conn,request); %>
		<script>
			if(document.getElementById('alt_id2_exp_date') != null)
				if(document.getElementById('alt_id2_exp_date').value == '')
					document.getElementById('altidexpdt2').disabled = true;
				
			if(document.getElementById('alt_id3_exp_date') != null)
				if(document.getElementById('alt_id3_exp_date').value == '')
					document.getElementById('altidexpdt3').disabled = true;
				
			if(document.getElementById('alt_id4_exp_date') != null)
				if(document.getElementById('alt_id4_exp_date').value == '')
					document.getElementById('altidexpdt4').disabled = true;

			function aa() {
				
				if ( ("<%=CalledFromFunction%>"  == "ChangePatDtls") || (document.forms[0].function_id.value  == "NEWBORN_REG") ) {
			if(parent.patient_main.document.getElementById('patient_name')) {
				parent.patient_main.document.getElementById('patient_name').value="<%=(String)hash_Map1.get("patient_name")%>"; 
			}
					<% if(oth_lang) { %>
					
						if(parent.patient_main.document.getElementById('patient_name_loc_lang'))
						{
							parent.patient_main.document.getElementById('patient_name_loc_lang').value="<%=pat_name_loc_lang%>";							
						}
						if(parent.patient_main.document.getElementById('patient_name_loc_lang_long'))
						{
							parent.patient_main.document.getElementById('patient_name_loc_lang_long').value="<%=pat_name_loc_lang_long%>";							
						}
					<% } %>
				}
			}
			
		</script>

		<%
			if(CalledFromFunction.equals("ChangePatDtls")) {  %>
				<script>
					if(document.forms[0].family_org_membership) {
						if(document.forms[0].family_org_membership.value=='1') {
							if(document.forms[0].name_prefix_img) {
								if(document.getElementById('name_pfx_reqd_for_org_mem_yn')) {
									if(document.getElementById('name_pfx_reqd_for_org_mem_yn').value=='Y') {
										document.forms[0].name_prefix_img.style.visibility='visible';	
									} else {
										document.forms[0].name_prefix_img.style.visibility='hidden';  
									}
								}
							}
						}
					}
				</script><%
			}
		%>
<script>
/*function clearvalue(){
alert("hhdhds");

if(document.forms[0].language_desc.value==""){
alert("kfkdfkd");
document.getElementById("language_code").value=="";
}

}*/

/*Below line added for this CRF  GDOH-CRF-0029 [IN:048764]*/
function chkRegDateTime(Obj)
{
	var fromatFormDate =''; 
	var errors='';	
	var CurrentDate = getCurrentDate("DMYHM",localeName); /*Removed Seconds*/
	if(Obj.value != '') 
	{
		if(!validDate(Obj.value,'DMYHM',localeName))
		{
			alert(getMessage("INVALID_DATE_TIME",'SM'));
			Obj.select();
		}
		else
		{ 
		fromatFormDate = convertDate(Obj.value,"DMYHM",localeName,"en");		/*Removed Seconds*/
		
		var birthDate=document.getElementById('Birth_Date').value; 
		if(birthDate.length==19)birthDate=birthDate.substring(0,16);	
        if(birthDate.length==18)birthDate=birthDate.substring(0,15); //Added for this incident [54759]		
        if(birthDate.length==17)birthDate=birthDate.substring(0,14);	//Added for this incident [54759]		
		birthDate=convertDate(birthDate,"DMYHM",localeName,"en");  /*Removed Seconds*/
		 
       //var birthDate=convertDate(document.getElementById('Birth_Date').value,"DMYHM",localeName,"en");  /*Removed Seconds*/
	   
		       	 
		if(!isAfter(CurrentDate,Obj.value,"DMYHM",localeName)){ /*Removed Seconds*/
			var error = getMessage('CANNOT_GREATER','MP');			
			var message2=getLabel("Common.RegistrationDate.label",'Common')+" "+getLabel("Common.time.label",'Common'); 
			var message1=getLabel("Common.CurrentDate.label",'Common')+" "+getLabel("Common.time.label",'Common'); 
			error = error.replace('$',message1);			
			error = error.replace('#',message2);
			alert(error);
			Obj.value="";
			Obj.select();
		} else if(birthDate!=""&&!isAfter(fromatFormDate,birthDate,"DMYHM",localeName)){  /*Removed Seconds*/		
		    var error = getMessage('CANNOT_LESSER','MP');			
			var message1=getLabel("Common.RegistrationDate.label",'Common')+" "+getLabel("Common.time.label",'Common'); 
			var message2=getLabel("Common.birthDate.label",'Common')+" "+getLabel("Common.time.label",'Common'); 
			error = error.replace('$',message2);			
			error = error.replace('#',message1);
			alert(error);
			Obj.value="";
			Obj.select();
		}
		}
	}
}

//End GDOH-CRF-0029 [IN:048764]

</script>
		
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
%>


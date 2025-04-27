<!DOCTYPE html>
<!-- Last Modified Date Time : 1/4/2006 12:37 PM  -->
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.Connection, java.util.Properties, java.util.HashMap, java.util.ArrayList, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%@ include file="PatientAddressLegends.jsp"%> 
 
<% 
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
		String facility_id=checkForNull((String)session.getAttribute("facility_id")); //added for the incident 34901
		Properties p		= (java.util.Properties) session.getValue("jdbc");
%>	
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language='javascript' src='../../eCommon/js/CommonLookup.js'></Script>
	<Script language='javascript' src='../../eMP/js/SmartCard.js'></Script>
	<!--Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1-->
	<Script language='javascript' src='../../eMP/js/EmployeePrivilege.js'></Script>
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
	<Script language='JavaScript'src='../../eCommon/js/DateUtils.js' ></Script>
	<Script language='JavaScript'src='../../eCommon/js/dchk.js'></Script>
	<Script language='javascript' src='../../eMP/js/ChangePatientDetails.js'></Script>
	<Script language='javascript' src='../../eMP/js/ChangePatientDetails1.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration4.js'></Script>
	<Script src='../../eCommon/js/common.js' language='JavaScript'></Script>
	<script Language='javascript' src='../../eCommon/js/ScanDocument.js'></script> <!--Added by Rameswar on  15-03-2016 for MMS-DM-CRF-0035-->	

</head>	

<%
    
	Connection con	= null;
	con	= ConnectionManager.getConnection(request);
	ResultSet rs			= null;
	PreparedStatement stmt	= null;
	Boolean iSSiteApplicable = false;	// Added by shagar for GDOH-CRF-0111
	String locale			= (String)session.getAttribute("LOCALE");
	String Accept_oth_alt_id_yn			= "";
	String disabled_fields				= ""; 
	String disp_nat_id_length			= "";
	String nat_id_check_digit_id	= "";
	String dflt_alt_id1_in_emp_id_yn	= "N";
	String val="";
	String ocpn_code="";
	String added_date="";
	String modified_date="";
	String nat_on_blurfn_st = "";
	String nat_id_onKeyPress="";
	String accept_pw_in_chng_pat_dtl_yn="";
	String cust_fields[]		= new String[5];
	//New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
	String country_reqd_yn="N",region_reqd_yn="N",mobile_no_reqd_yn="N";
	String country_visibility = "visibility:hidden";
	String region_visibility = "visibility:hidden";
	String mobile_no_visibility = "visibility:hidden";
	String region_prompt		= "";
	String region_appl_yn		= ""; // Ends here
	/* Added for AMRI-CRF-0388 by Shagar */ 
	String postal_cd_reqd_yn="N",area_reqd_yn="N";
	String town_reqd_yn="N";  //Added by Suji keerthi on 28-Nov-2019 for KDAH-CRF-0522
	//String postal_visibility = "visibility:hidden";
	//String area_visibility = "visibility:hidden";
	// Newly Added against KDAH-CRF-0273 [IN:045012]  By saanthaakumar
	/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
	String addr_line1_prompt		= "";
	String addr_line2_prompt		= "";
	String postal_code_prompt		= "";
	String area_code_prompt		    = ""; /*Added against AMRI-CRF-0388 by Shagar*/
	String town_code_prompt		    = ""; /*Added by Suji keerthi on 02-Dec-2019 for KDAH-CRF-0522*/
	/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
	String email_id_reqd_yn = "N";
	String email_visibility = "visibility:hidden";//Ends here	
	int Demoaddlcnt		= 0;
	int Contactaddlcnt	= 0;
	int NoKaddlcnt		= 0;
	int FtNotifyaddlcnt	= 0;
	int Empraddlcnt		= 0;
	int Othersaddlcnt	= 0;
	int custcount		= 0;
	
	//Added by Kamatchi S for ML-MMOH-CRF-1930 US004
	Boolean isVirtualConsultation = false;
	isVirtualConsultation=eCommon.Common.CommonBean.isSiteSpecific(con,"OP","VIRTUAL_CONSULTATION"); 
	String classcode="";
	String classdesc="";
	String countryD = "";
	countryD = checkForNull(eMP.MPCommonBean.getCountryFrmFacility(con,facility_id,locale));
	String countryC = "";
	
	//Added for this CRF ML-MMOH-CRF-0860.2
	Boolean increasedaddressLength =false;
	//added by mujafar for ML-MMOH-CRF-0601	
	Boolean alterAddressApplicable =false;
	String alt_addr_line1=""; 
	String alt_addr_line2="";
	String alt_addr_line3="";
	String alt_addr_line4="";
	String alt_postal_code="";
	String alt_postal_code_desc="";
	String alt_country_code="";
	String alt_country_name="";
	String alt_invalid_yn="";
	String alt_contact_name="";
	String alt_area_code="";
	String alt_area_code_desc="";
	String alt_town_code="";
	String alt_town_code_desc="";
	String alt_region_code="";
	String alt_region_code_desc="";	
	//End ML-MMOH-CRF-0601
	
	String bl_install_yn	= (String)session.getValue("mp_bl_oper_yn");
	
	try {
	
	
	alterAddressApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE"); // Added for ML-MMOH-CRF-0601	
	Boolean finDtlsChkNationality = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","FIN_DTLS_CHK_NATIONALITY");//Added by Ashwini on 07-Sep-2018
	Boolean aliasnameNationalityRace	=eCommon.Common.CommonBean.isSiteSpecific(con, "MP","BMI_REG_PAT_CHNGES_RH101");//Added by Suji Keerthi for ML-MMOH-CRF-1527
	Boolean resiAddMailAdd   	=eCommon.Common.CommonBean.isSiteSpecific(con, "MP","BMI_REG_PAT_CHNGES_RH101");//Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
	//Added for this CRF ML-MMOH-CRF-0860.2
	String maxsize="30";
	String col_span_td="";
	String maximumLength="30";
	increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
	if(increasedaddressLength){
	col_span_td="2";
	maximumLength="50";
	//maxsize="58";
	maxsize="64";
	}
	//End this ML-MMOH-CRF-0860.2
	
	//Added for this CRF ML-MMOH-CRF-0601
	String colspantd="colspan=4";	
	if(alterAddressApplicable || increasedaddressLength){
		colspantd="colspan=6";		
	}	 
	//End this ML-MMOH-CRF-0601
	
	//Added for this CRF ML-MMOH-CRF-0860.2
	//increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
	
	Boolean addr_pincode_mand = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ADDR_PINCODE_MAND");
	iSSiteApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "COPY_FIRST_NOTIFY_REMOVED");
	/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
		HashMap hashMap		= new HashMap();
		HashMap hashMap1	= new HashMap();
		HashMap hashMap2	= new HashMap();
		HashMap hashMap3	= new HashMap();
		HashMap hashMap4	= new HashMap();
		HashMap hashMap5	= new HashMap();
		HashMap hashMap6	= new HashMap();
		HashMap hashMap7	= new HashMap();
		HashMap hashMap8	= new HashMap();
		HashMap hash_mp_param	= new HashMap();
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1527
		HashMap hash_Map3   = new HashMap();
		HashMap hash_Map6	= new HashMap();
		
		ArrayList arrayList		 = new ArrayList();
		ArrayList arrayList1	 = new ArrayList();
		ArrayList arrayList2	 = new ArrayList();
		ArrayList arrayList3	 = new ArrayList();
		ArrayList arrayList5	 = new ArrayList();
		ArrayList arrayList6	 = new ArrayList();
		
		ArrayList contact_addr = fetchContactAddresses(con,out,"parent.parent.messageFrame",p);
		arrayList1 = eMP.ChangePatientDetails.getResultRows(con,"mp_alternate_id_type",p);
		arrayList2 = eMP.ChangePatientDetails.getResultRows(con,"mp_name_prefix",p);
		arrayList3 = eMP.ChangePatientDetails.getResultRows(con,"mp_relationship",p);

		hashMap2 = eMP.ChangePatientDetails.getCizntNatCode(con,p);
		
		String Site = (String)contact_addr.get(0);
		String[] contact_col_names = (String[])contact_addr.get(1);
		String[] contact_prompts   = (String[])contact_addr.get(2);
		String[] contact_fields    = (String[])contact_addr.get(3);
		
		StringBuffer exestr	= new StringBuffer();

		String accept_national_id_no_yn		= "N";
		String nat_id_accept_alphanumeric_yn= "N";
		String mother_patient_id			= "";
		String newborn_param				= "";
		String called_from_newborn			= checkForNull(request.getParameter("called_from_newborn"),"N");
		String def_nat_desc					= "";
		String count						= "0";
		String patient_id			= checkForNull(request.getParameter("patient_id"));
		String function_id			= checkForNull(request.getParameter("function_id"));
		String parent_details		= checkForNull(request.getParameter("parent_details"));
		String numOfbaby			= checkForNull(request.getParameter("numOfbaby"));
		String noOfBirths			= checkForNull(request.getParameter("noOfBirths"));
		String nb_birth_place_code	= checkForNull(request.getParameter("nb_birth_place_code"));
		String nb_birth_place_desc	= checkForNull(request.getParameter("nb_birth_place_desc"));
		String multi_birth			= checkForNull(request.getParameter("multi_birth"),"N");
		String group				= checkForNull(request.getParameter("group"));
		//Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1
		String load_tab				= checkForNull(request.getParameter("load_tab"));
		String reset_dem			= checkForNull(request.getParameter("reset_dem"));
		if(!numOfbaby.equals("")) { 
			disabled_fields = "disabled"; 
			//called_from_newborn = "Y"; 
		}
		if(!multi_birth.equals("")) {
			disabled_fields		= "disabled";
			//called_from_newborn	= "Y";
		}
		hashMap = eMP.ChangePatientDetails.getSetupData(facility_id,group,con,p);
		def_nat_desc = checkForNull((String)hashMap2.get("def_nat_desc"));

	//String invoke_routine=checkForNull((String)hashMap.get("invoke_routine"),"N");

     hash_mp_param=eMP.NewbornDetails.getNewBornRelMandatory(con,p);
	 String family_org_id_accept_yn=(String)hashMap.get("family_org_id_accept_yn");
	 String org_member_relationship_code=(String)hashMap.get("org_member_relationship_code");
	 String org_member_relationship_desc=(String)hashMap.get("org_member_relationship_desc");
	 String entitlement_by_pat_cat_yn=(String)hashMap.get("entitlement_by_pat_cat_yn");	
	 String nat_id_pat_ser_grp=(String)hashMap.get("nat_id_pat_ser_grp");	
	 String nat_invoke_routine=(String)hashMap.get("invoke_routine");	
	 String nat_data_source_id=(String)hashMap.get("nat_data_source_id");
	 String accept_oth_lang_yn=checkForNull((String) hashMap.get("names_in_oth_lang_yn"), "N");
	 String nat_id_chk_len=(String)hashMap.get("nat_id_chk_len");
	// New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
	 country_reqd_yn=checkForNull((String)hashMap.get("COUNTRY_REQD_YN"),"N");	
		region_reqd_yn=checkForNull((String)hashMap.get("REGION_REQD_YN"),"N");	
		mobile_no_reqd_yn=checkForNull((String)hashMap.get("MOBILE_NO_REQD_YN"),"N");	
		email_id_reqd_yn=checkForNull((String)hashMap.get("EMAIL_ID_REQD_YN"),"N");	
		/* Added for AMRI-CRF-0388 by Shagar */
		postal_cd_reqd_yn=checkForNull((String)hashMap.get("POSTAL_CD_REQD_YN"),"N");
		area_reqd_yn=checkForNull((String)hashMap.get("AREA_REQD_YN"),"N");
		town_reqd_yn=checkForNull((String)hashMap.get("TOWN_REQD_YN"),"N");	//Added by Suji keerthi on 28-Nov-2019 for KDAH-CRF-0522	
	 String Alt_Id1_Type = "";
	 String Alt_Id2_Type = "";
	 String Alt_Id3_Type = "";
	 String Alt_Id4_Type = "";

		int Alt_Id1_length		= Integer.parseInt((String) hashMap.get("Alt_Id1_length"));
		int Alt_Id2_length		= Integer.parseInt((String) hashMap.get("Alt_Id2_length"));
		int Alt_Id3_length		= Integer.parseInt((String) hashMap.get("Alt_Id3_length"));

		Alt_Id1_Type			= (String) hashMap.get("Alt_Id1_Type");
		Alt_Id2_Type			= (String) hashMap.get("Alt_Id2_Type");
		Alt_Id3_Type			= (String) hashMap.get("Alt_Id3_Type");
		Alt_Id4_Type			= (String) hashMap.get("Alt_Id4_Type");	

		Accept_oth_alt_id_yn			= (String) hashMap.get("Accept_oth_alt_id_yn");
		accept_national_id_no_yn		= checkForNull((String) hashMap.get("accept_national_id_no_yn"), "N");
		nat_id_accept_alphanumeric_yn	= checkForNull((String) hashMap.get("nat_id_accept_alphanumeric_yn"),"N");
		dflt_alt_id1_in_emp_id_yn		= checkForNull((String) hashMap.get("dflt_alt_id1_in_emp_id_yn"), "N");
		disp_nat_id_length				= checkForNull((String)hashMap.get("nat_id_length"));
		nat_id_check_digit_id		= checkForNull((String)hashMap.get("nat_id_check_digit_id"));
		accept_pw_in_chng_pat_dtl_yn		= (String)hashMap.get("accept_pw_in_chng_pat_dtl_yn");
		//New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
		country_reqd_yn		= checkForNull((String) hashMap.get("COUNTRY_REQD_YN"), "N");
		region_reqd_yn		= checkForNull((String) hashMap.get("REGION_REQD_YN"), "N");
		mobile_no_reqd_yn		= checkForNull((String) hashMap.get("MOBILE_NO_REQD_YN"), "N");
		email_id_reqd_yn		= checkForNull((String) hashMap.get("EMAIL_ID_REQD_YN"), "N");
		/*Added for AMRI-CRF-0388 by Shagar */
		postal_cd_reqd_yn		= checkForNull((String) hashMap.get("POSTAL_CD_REQD_YN"), "N");
		area_reqd_yn		= checkForNull((String) hashMap.get("AREA_REQD_YN"), "N");
		town_reqd_yn		= checkForNull((String) hashMap.get("TOWN_REQD_YN"), "N");	//Added by Suji keerthi on 28-Nov-2019 for KDAH-CRF-0522	
		hashMap1 = eMP.ChangePatientDetails.getPatientData(patient_id,con,p);
	
		String contact1_birth_date = checkForNull((String)hashMap1.get("contact1_birth_date"),"");
			
		if  ( !contact1_birth_date.equals("") ) 
		{
				if  ( !localeName.equals("en"))
				contact1_birth_date= DateUtils.convertDate(contact1_birth_date,"DMY","en",localeName);
		}
		

		if(((String)hashMap1.get("flag")).equals("yes")) {  
			if(((String)hashMap1.get("sex")).equals("F") && (((String)hashMap1.get("national_id_no")).equals("")) && (!function_id.equals("NEWBORN_REG"))) {  
				hashMap8 = eMP.ChangePatientDetails.getMPBirthRegisterCount(patient_id, con,p);
				count = (String)hashMap8.get("count");
				if(count.equals("")) count = "0";
			}

			cust_fields[0] = (String)hashMap.get("addl_field1_section")+"`"+(String)hashMap.get("addl_field1_prompt")+"`"+(String)hashMap.get("addl_field1_length")+"`addl_field1"+"`"+(String)hashMap1.get("addl_field1");
			cust_fields[1] = (String)hashMap.get("addl_field2_section")+"`"+(String)hashMap.get("addl_field2_prompt")+"`"+(String)hashMap.get("addl_field2_length")+"`addl_field2"+"`"+(String)hashMap1.get("addl_field2");
			cust_fields[2] = (String)hashMap.get("addl_field3_section")+"`"+(String)hashMap.get("addl_field3_prompt")+"`"+(String)hashMap.get("addl_field3_length")+"`addl_field3"+"`"+(String)hashMap1.get("addl_field3");
			cust_fields[3] = (String)hashMap.get("addl_field4_section")+"`"+(String)hashMap.get("addl_field4_prompt")+"`"+(String)hashMap.get("addl_field4_length")+"`addl_field4"+"`"+(String)hashMap1.get("addl_field4");
			
			cust_fields[4] = (String)hashMap.get("addl_field5_section")+"`"+(String)hashMap.get("addl_field5_prompt")+"`"+(String)hashMap.get("addl_field5_length")+"`addl_field5"+"`"+(String)hashMap1.get("addl_field5");
			custcount = cust_fields.length;
			for(int i=0;i<custcount;i++) {
				if(cust_fields[i].charAt(0)=='D') ++Demoaddlcnt;
				if(cust_fields[i].charAt(0)=='C') ++Contactaddlcnt;
				if(cust_fields[i].charAt(0)=='N') ++NoKaddlcnt;
				if(cust_fields[i].charAt(0)=='F') ++FtNotifyaddlcnt;
				if(cust_fields[i].charAt(0)=='E') ++Empraddlcnt;  
				if(cust_fields[i].charAt(0)=='O') ++Othersaddlcnt;
			} %>
<%
// Newly Added Against GHL-CRF-0312 [IN:039856] By Saanthaakumar
try
        {
			
		String sql1 = "SELECT initcap(region_prompt) region_prompt,REGION_APPL_YN,initcap(ADDR_LINE1_PROMPT) addr_line1_prompt,initcap(ADDR_LINE2_PROMPT) addr_line2_prompt,initcap(POSTAL_CODE_PROMPT) postal_code_prompt,initcap(RES_AREA_PROMPT)area_code_prompt,initcap(RES_TOWN_PROMPT)town_code_prompt FROM sm_site_param_LANG_VW where language_id='"+locale+"' ";
		/*Modified by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/	
			
						if(rs!=null) rs.close();
					    if(stmt!=null) stmt.close();
						stmt = con.prepareStatement(sql1);
						rs = stmt.executeQuery();
						
						while (rs.next()){ 
								region_prompt		= rs.getString("region_prompt");
								region_appl_yn		= rs.getString("REGION_APPL_YN");
								/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
								addr_line1_prompt   = rs.getString("addr_line1_prompt");
								addr_line2_prompt   = rs.getString("addr_line2_prompt");
								postal_code_prompt  = rs.getString("postal_code_prompt");
								area_code_prompt    = rs.getString("area_code_prompt");
								town_code_prompt    = rs.getString("town_code_prompt"); //Added by Suji keerthi on 02-Dec-2019 for KDAH-CRF-0522
								
			}			if(rs!=null) rs.close();

			 }
			 
		catch(Exception e)
        { }%>
			<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
			<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
			<Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
			<Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
			<Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
			<Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script>
			<Script language='javascript' src='../../eCommon/js/common.js' ></Script>
			<Script language='javascript'src='../../eCommon/js/CommonCalendar.js'></Script>
			<!--chkNatlIdMandatory(); Added by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491]!-->
			<!--focusContactTab() Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1-->
			<body onKeyPress='return ChkKey(event);' onSelect="codeArrestThruSelect()" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onload='<%if(isVirtualConsultation){%>telephone1();<%}%>startBlink();getLevel();form60OnLoad();displayScanner();chkNatlIdMandatory("onload");<%if(load_tab.equals("CONTACT_ADDR_TAB")){%>focusContactTab();<%}%>'>
		<!-- 	<a name='demo'></a> -->
		<div id = 'demo' name='demo'>
			<form name='ChangePatDtlForm' id='ChangePatDtlForm' method='post'  action='../../servlet/eMP.PatientRegistrationServlet' target='messageFrame'>
				<input type='hidden' name='accept_national_id_no' id='accept_national_id_no' value='<%=accept_national_id_no_yn%>'>
				<input type='hidden' name='alt_id1_accept_oth_pat_ser_yn' id='alt_id1_accept_oth_pat_ser_yn' 	value='<%=(String)hashMap.get("alt_id1_accept_oth_pat_ser_yn")%>'>
				<input type='hidden' name='alt_id1_accept_alphanumeric_yn' id='alt_id1_accept_alphanumeric_yn' value='<%=(String)hashMap.get("alt_id1_accept_alphanumeric_yn")%>'>
				<input type='hidden' name='max_patient_age' id='max_patient_age' value='<%=(String)hashMap.get("max_pat_age")%>'>
				<input type='hidden' name='id_type' id='id_type' value='<%=checkForNull((String)hashMap1.get("id_type"))%>'>
				<input type ='hidden' name='family_org_id_accept_yn' id='family_org_id_accept_yn' value="<%=family_org_id_accept_yn%>"></input>
				<input type ='hidden' name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn' value="<%=entitlement_by_pat_cat_yn%>"></input>
				<input type ='hidden' name='org_member_relationship_code' id='org_member_relationship_code' value="<%=org_member_relationship_code%>"></input>
				<input type ='hidden' name='org_member_relationship_desc' id='org_member_relationship_desc' value="<%=org_member_relationship_desc%>"></input>
				<input type='hidden' name='upload_patient_id' id='upload_patient_id' value=""></input>
				<input type='hidden' name='output' id='output' value=""></input>
				<input type='hidden' name='funCall' id='funCall' value=""></input>
				<input type='hidden' name='bl_success_msg' id='bl_success_msg' value=""></input>

				<!--Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start -->
				<input type="hidden" name="alt_id2_accept_oth_pat_ser_yn" id="alt_id2_accept_oth_pat_ser_yn" value="<%=(String)hashMap.get("alt_id2_accept_oth_pat_ser_yn")%>" />
				<input type="hidden" name="alt_id2_accept_alphanumeric_yn" id="alt_id2_accept_alphanumeric_yn" value="<%=(String)hashMap.get("alt_id2_accept_alphanumeric_yn")%>" /> 

				<input type="hidden" name="alt_id3_accept_oth_pat_ser_yn" id="alt_id3_accept_oth_pat_ser_yn" value="<%=(String)hashMap.get("alt_id3_accept_oth_pat_ser_yn")%>" /> 
				<input type="hidden" name="alt_id3_accept_alphanumeric_yn" id="alt_id3_accept_alphanumeric_yn" value="<%=(String)hashMap.get("alt_id3_accept_alphanumeric_yn")%>" /> 

				<input type="hidden" name="alt_id4_accept_oth_pat_ser_yn" id="alt_id4_accept_oth_pat_ser_yn" value="<%=(String)hashMap.get("alt_id4_accept_oth_pat_ser_yn")%>" /> 
				<input type="hidden" name="alt_id4_accept_alphanumeric_yn" id="alt_id4_accept_alphanumeric_yn" value="<%=(String)hashMap.get("alt_id4_accept_alphanumeric_yn")%>" />
				<!--Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End -->
				<!--Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 25th July 2108 Start-->
				<input type="hidden" name="alt_id1_alphanum_validate_yn" id="alt_id1_alphanum_validate_yn" value="<%=(String)hashMap.get("alt_id1_alphanum_validate_yn")%>" />
				<input type="hidden" name="alt_id2_alphanum_validate_yn" id="alt_id2_alphanum_validate_yn" value="<%=(String)hashMap.get("alt_id2_alphanum_validate_yn")%>" />
				<input type="hidden" name="alt_id3_alphanum_validate_yn" id="alt_id3_alphanum_validate_yn" value="<%=(String)hashMap.get("alt_id3_alphanum_validate_yn")%>" />
				<input type="hidden" name="alt_id4_alphanum_validate_yn" id="alt_id4_alphanum_validate_yn" value="<%=(String)hashMap.get("alt_id4_alphanum_validate_yn")%>" />
				<!--Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 25th July 2108 End-->

				


				<% if(!((String)hashMap1.get("data_source")).equals("")) {
					if(((String)hashMap1.get("data_source")).equals((String)hashMap.get("alt_id1_routine"))) {
						exestr.append("checkAlternateIdForUnique(document.forms[0].alt_id1_no,1,'"+(String)hashMap.get("alt_id1_len_validation_yn")+"','"+(String)hashMap.get("alt_id1_routine_yn")+"','"+(String)hashMap.get("alt_id1_routine")+"','"+(String) hashMap.get("alt_id1_chk_digit_scheme")+"');"); 
					} 
				}
				if(!((String)hashMap1.get("data_source")).equals("")) {
					if(((String)hashMap1.get("data_source")).equals( (String)hashMap.get("alt_id2_routine"))) {
						exestr.append( "checkAlternateIdForUnique(document.forms[0].alt_id2_no,2,'"+(String)hashMap.get("alt_id2_len_validation_yn")+"','"+(String)hashMap.get("alt_id2_routine_yn")+"','"+(String)hashMap.get("alt_id2_routine")+"');"); 
					}
				}
				if(!((String)hashMap1.get("data_source")).equals("")) {
					if(((String)hashMap1.get("data_source")).equals( (String)hashMap.get("alt_id3_routine"))) {
						exestr.append("checkAlternateIdForUnique(document.forms[0].alt_id3_no,3,'"+(String)hashMap.get("alt_id3_len_validation_yn")+"','"+(String)hashMap.get("alt_id3_routine_yn")+"','"+(String)hashMap.get("alt_id3_routine")+"','"+(String) hashMap.get("alt_id3_chk_digit_scheme")+"');");   
					}
				}	
				if(!((String)hashMap1.get("data_source")).equals("")) {
				    if(((String)hashMap1.get("data_source")).equals( (String)hashMap.get("alt_id4_routine"))) {
						exestr.append("checkAlternateIdForUnique(document.forms[0].alt_id4_no,4,'"+(String)hashMap.get("alt_id4_len_validation_yn")+"','"+(String)hashMap.get("alt_id4_routine_yn")+"','"+(String)hashMap.get("alt_id4_routine")+"','"+(String) hashMap.get("alt_id4_chk_digit_scheme")+"');");  
					}
				}%> 
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<jsp:include page="../../eMP/jsp/ChangePatientSubNames.jsp" ><jsp:param name="flush" value="true" />
						<jsp:param name="patient_id" value="<%=patient_id%>" />
						<jsp:param name="group" value="<%=group%>" />
						<jsp:param name="CalledFromFunction" value="ChangePatDtls" />
						<jsp:param name="def_nat_desc" value="<%=def_nat_desc%>" />
						<jsp:param name="disabled_fields" value="<%=disabled_fields%>" />
						<jsp:param name="Site" value="<%=Site%>" />
						<jsp:param name="dflt_alt_id1_in_emp_id_yn" value="<%=dflt_alt_id1_in_emp_id_yn%>" />
						<jsp:param name="multi_birth" value="<%=multi_birth%>" />
						<jsp:param name="nb_birth_place_code" value="<%=nb_birth_place_code%>" />
						<jsp:param name="nb_birth_place_desc" value="<%=nb_birth_place_desc%>" />
						<jsp:param name="Demoaddlcnt" value="<%=Demoaddlcnt%>" />
						<jsp:param name="nat_id_accept_alphanumeric_yn" value="<%=nat_id_accept_alphanumeric_yn%>" />
					</jsp:include> 
				<tr></tr><tr></tr><tr>
				 <%
					int order=0;
					int demo_cnt = 1;
					
					for(int i=0; i<cust_fields.length;i++) {
					
					if(cust_fields[i].charAt(0) == 'D')
					{
						int intind_0	= cust_fields[i].indexOf('`');
						
						String strcf	= cust_fields[i];		
						String strs1	= strcf.substring(intind_0+1, strcf.length());
											
						int intind_1	= strs1.indexOf('`');
						String lab		= strs1.substring(0, intind_1);
						String strs2		= strs1.substring(intind_1+1, strs1.length());
						int intind_2	= strs2.indexOf('`');
						String size		= strs2.substring(0, intind_2);
						
						String strs3	= strs2.substring(intind_2+1, strs2.length());
						int intind_3	= strs3.indexOf('`');
						String nme		= strs3.substring(0, intind_3);
							
						String strs4	= strs3.substring(intind_3+1, strs3.length());
						
						val 		= checkForNull(strs4.substring(0));

						if( order %2 == 0 || order == 0)
						{
							out.println("</tr><tr>") ;
						}	
						%>
							<td class='label' ><%=lab%></td>
							<td class='fields' ><input type='text' name="<%=nme%>" id="<%=nme%>" maxlength="<%=size%>" size='20'  value='<%=val%>' onblur='makeValidString(this);if("<%=demo_cnt%>" == "<%=Demoaddlcnt%>") { document.forms[0].pat_ser_grp_code.focus();}'></td>
						<% 
						order++;
						demo_cnt++;
						} 
						
					} 

					if(order %2 != 0 && order!=0)
					{%>
					<td class='label'  colspan='3'>&nbsp;</td>	
					<%}
                   if (order != 0)
                    {
                        out.println("</table>");
                        out.println("</td>");
                        out.println("</tr>");
                    }%>
					<tr><td colspan='4'>&nbsp;</td></tr>
				</table>
				</div>
				<!-- <a name='addr'></a> -->
				<div id = 'addr' style = 'display:none'>
				<table width='100%' cellpadding='0' cellspacing='1' border ='0' width='100%'>
                <tr>
                    <td  class='BODYCOLORFILLED' width='1%'>&nbsp;</td>
                    <td width='99%'  class='BODYCOLORFILLED' valign='top' colspan='3'>
                    <table cellpadding='2' cellspacing='0' border='0' height='100%' width='99%'>
                        <tr>
                            <td class='COLUMNHEADER'>&nbsp;</td>
                            <td  class='COLUMNHEADER' colspan='2'><fmt:message key="eMP.residenceaddress.label" bundle="${mp_labels}"/></td>
							<%if(alterAddressApplicable && increasedaddressLength){%>
                            <td  class='COLUMNHEADER' colspan='<%=col_span_td%>' ><fmt:message key="eMP.AlternateAddress.label" bundle="${mp_labels}"/></td>
							<%}if(!alterAddressApplicable && increasedaddressLength){%>
							<td  class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.MailingAddress.label" bundle="${common_labels}"/></td>  					
							<%}
							if((!alterAddressApplicable && !increasedaddressLength) || (alterAddressApplicable && increasedaddressLength)){%>
                            <td  class='COLUMNHEADER' colspan='<%=col_span_td%>' ><fmt:message key="Common.MailingAddress.label" bundle="${common_labels}"/></td>
							<%}%>
                        </tr>
									<%//New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
									if(region_reqd_yn.equals("Y")){ 
										region_visibility = "visibility:visible";}
										
									StringBuffer sb1		= new StringBuffer();
									StringBuffer fieldVal	= new StringBuffer();
									StringBuffer sb			= new StringBuffer();
									StringBuffer sbap		= new StringBuffer();
									StringBuffer sbar		= new StringBuffer();
									StringBuffer sb11		= new StringBuffer();
									StringBuffer fieldVal1	= new StringBuffer();
									
									//Added for this CRF ML-MMOH-CRF-0601
									StringBuffer sb_a = new StringBuffer();
									StringBuffer sb_ap			= new StringBuffer();
									StringBuffer sb_ar			= new StringBuffer();
									StringBuffer sb1_aa		= new StringBuffer();
									StringBuffer fieldVal_aa	= new StringBuffer(); 
							       //End this CRF ML-MMOH-CRF-0601

		
									for(int i=0;i<contact_col_names.length; i++) { %>
										<tr>
											<td class='label'  ><%=contact_prompts[i]%></td><%
											 val = contact_fields[i];
											String val_alt = contact_fields[i]; //Added for this CRF ML-MMOH-CRF-0601
											sb1.append(val);
											fieldVal.append("");
	
											for(int z=0;z<val.length();z++) {
												String tempVal=sb1.substring(z,z+1);
												if(tempVal.equals("@")) {
													fieldVal.append("50");
											}
											else {
												fieldVal.append(tempVal);
											}
										}
										val = fieldVal.toString();
                                        
										val_alt = fieldVal.toString(); //Added for this CRF ML-MMOH-CRF-0601
										%>
										<td class='fields' colspan='2'><%=val%>
										<%
										val = contact_fields[i];										
										val_alt = contact_fields[i] ; //Added for this CRF ML-MMOH-CRF-0601
										
										sb.append(val);
										sb_a.append(val_alt);   //Added for this CRF ML-MMOH-CRF-0601
										int j	= 0;
										int j1	= 0;
										String old_val = "";
										String new_val = "";
										String new_val_alt=""; //Added for this CRF ML-MMOH-CRF-0601
										int jk=0; //Added for this CRF ML-MMOH-CRF-0601
										int jk1=0; //Added for this CRF ML-MMOH-CRF-0601
										
										if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt")) {
										   old_val = "r_addr_line1";
										   new_val = "m_addr_line1";
										   new_val_alt = "a_addr_line1" ; //Added for this CRF ML-MMOH-CRF-0601
										     if(addr_pincode_mand){/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
										   out.println("<img id='addr_pincode_mand1' src='../images/mandatory.gif' style='visibility:visible'</img>");}
										}
										else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt")) {
											old_val = "r_addr_line2";
											new_val = "m_addr_line2";
											new_val_alt = "a_addr_line2" ;  //Added for this CRF ML-MMOH-CRF-0601
											  if(addr_pincode_mand){/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
											out.println("<img id='addr_pincode_mand2' src='../images/mandatory.gif' style='visibility:visible'</img>");}
										 }
										 else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt")) {
											old_val = "r_addr_line3";
											new_val = "m_addr_line3";
											new_val_alt = "a_addr_line3" ; //Added for this CRF ML-MMOH-CRF-0601
										 }
										 else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt")) {
											old_val = "r_addr_line4";
											new_val = "m_addr_line4";
											new_val_alt = "a_addr_line4" ; //Added for this CRF ML-MMOH-CRF-0601
										 }
										 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
											old_val = "r_area_code";
											new_val = "m_area_code";
											new_val_alt = "a_area_code" ; //Added for this CRF ML-MMOH-CRF-0601
										if(area_reqd_yn.equals("Y")){ //Added by agiant AMRI-CRF-0388 by shagar
                                        out.println("<img id='area_code_mand' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
										 }
										 else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
											old_val = "r_town_code";
											new_val = "m_town_code";
											new_val_alt = "a_town_code" ; //Added for this CRF ML-MMOH-CRF-0601
										if(town_reqd_yn.equals("Y")){ //Added by Suji keerthi on 28-Nov-2019 for KDAH-CRF-0522
		                                        out.println("<img id='town_code_mand' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
										 }
										 else if(contact_col_names[i].equalsIgnoreCase("region_prompt")) {
											old_val = "r_region_code";
											//Image is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
										out.println("<img id='id1' src='../images/mandatory.gif' style='"+region_visibility+"'</img>");
											new_val = "m_region_code";
											
											new_val_alt = "a_region_code" ; //Added for this CRF ML-MMOH-CRF-0601
										 }
										 else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt")) {
											old_val = "r_postal_code";
											new_val = "m_postal_code";
											
											new_val_alt = "alt_postal_code" ;  //Added for this CRF ML-MMOH-CRF-0601
											
											  //if(addr_pincode_mand){/*Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324*/
											//out.println("<img id='addr_pincode_mand3' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
											 //above 2 lines commented against AMRI-CRF-0388 by Shagar
									        //Added by agiant AMRI-CRF-0388 by shagar
		       							if(postal_cd_reqd_yn.equals("Y")){
											out.println("<img id='addr_pincode_mand3' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
										 }
										while(val.indexOf(old_val) != -1) {
											j = val.indexOf(old_val,j);
											sb = sb.replace(j,(j+old_val.length()),new_val);
											val = sb.toString();
										}
										if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
											sbap.append(val);
											while(val.indexOf("r_postal_code") != -1) {
												j1 = val.indexOf("r_postal_code",j1) ;
												sbap = sbap.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
												val = sbap.toString();
											}
										} 
										if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
											j1 = 0;
											sbar.append(val);
											while(val.indexOf("r_postal_code") != -1) {
												j1 = val.indexOf("r_postal_code",j1);
												sbar = sbar.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
												val = sbar.toString();
											}
										}
										sb11.append(val);
										fieldVal1.append("");
										for(int z=0;z<val.length();z++) {
											String tempVal=sb11.substring(z,z+1);
											if(tempVal.equals("@")) fieldVal1.append("68"); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
											else fieldVal1.append(tempVal);
										}
										val = fieldVal1.toString();
										
										
									//Added for this CRF ML-MMOH-CRF-0601 and ML-MMOH-CRF-0860.2
									while(val_alt.indexOf(old_val) != -1)
                                    {
                                        jk =0;
										jk = val_alt.indexOf(old_val,jk) ;
                                        sb_a = sb_a.replace(jk,(jk+old_val.length()),new_val_alt);
                                        val_alt = sb_a.toString();
										
									}																		
									
									if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
									{
										sb_ap.append(val_alt);
										while(val_alt.indexOf("r_postal_code") != -1)
										{ 
											
											jk1 = 0;
											jk1= val_alt.indexOf("r_postal_code",jk1) ;
											
											sb_ap = sb_ap.replace(jk1,(jk1+"r_postal_code".length()),"alt_postal_code");
											val_alt = sb_ap.toString();
									
										}
									}
									if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
									{
										jk1 = 0;
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
											fieldVal_aa.append("64"); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
										}
										else
										{
											fieldVal_aa.append(tempVal);
										}
									}
									
									val_alt = fieldVal_aa.toString();
									
									//End ML-MMOH-CRF-0601 and ML-MMOH-CRF-0860.2
										
										
										
										
										%></td>										 
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
									  <%
									if(i == 0) { %>
											<td class='fields' colspan='<%=col_span_td%>' ><%=val%><% //Added for ML-MMOH-CRF-0860.2
									if( (!increasedaddressLength)  || (increasedaddressLength && !alterAddressApplicable) ){%>
											<a href='javascript:copyDetails(4)'><fmt:message key="eMP.CopyResidenceAddress.label" bundle="${mp_labels}"/></a> <%}%></td>
										<%} else if(i==1 && alterAddressApplicable){
										 %> <td class='fields' colspan='<%=col_span_td%>' ><%=val%></td> 
										 <% }else{
									    out.println("<td class='fields'  colspan='"+col_span_td+"' >"+val+"</td>") ;
									    }%>
									</tr>
									<% 
									sb1.setLength(0);
									fieldVal.setLength(0);
									sb.setLength(0);
									sbap.setLength(0);
									sbar.setLength(0);
									sb11.setLength(0);
									fieldVal1.setLength(0);
									//Added for this CRF ML-MMOH-CRF-0601
									fieldVal_aa.setLength(0);
									sb_a.setLength(0);
									sb_ap.setLength(0);
									sb_ar.setLength(0);
									sb1_aa.setLength(0);                                    									
								}
								//New Condition is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
								 if(country_reqd_yn.equals("Y")){
						country_visibility = "visibility:visible";}%> 		
								<!--//New Iamge is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar-->
							<tr>
								<td  class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
								<td colspan='2' class='fields'><input type='text' name='r_country_desc' id='r_country_desc' size='15' maxlength='15' onblur='if(this.value !=""){searchCountry(contry_code[0],r_country_desc)} else{clearCountryFields(this)}'  value="<%=(String)hashMap1.get("resi_country_name")%>" tabIndex='61'><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,r_country_desc)' tabIndex='61'><img id='id2' src='../images/mandatory.gif' style='<%=country_visibility%>'></img>
								<input type='hidden' name='r_country_code' id='r_country_code' value="<%=(String)hashMap1.get("resi_country_code")%>"></td>						
						<%
						//Below line added for this CRF and ML-MMOH-CRF-0601 and  ML-MMOH-CRF-0860.2	
						if(alterAddressApplicable)
						{%>
						<td class='fields' colspan='<%=col_span_td%>'>
							<input type='text' name='a_country_desc' id='a_country_desc' size='15' maxlength='15' value="" onblur='if(this.value !="") {searchCountry(contry_code[0],a_country_desc); } else {clearCountryFields(this);}' tabIndex='65' ><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,a_country_desc)' tabIndex='65'>
							<input type='hidden' name='a_country_code' id='a_country_code' value="">							
						<%}
						   //End this ML-MMOH-CRF-0601
						%>						
						<td class='fields'><input type='text' name='m_country_desc' id='m_country_desc' size='15' maxlength='15' onblur='if(this.value !=""){searchCountry(contry_code[0],m_country_desc)}else{clearCountryFields(this)}'   value="<%=(String)hashMap1.get("mail_country_name")%>" tabIndex='69'><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,m_country_desc)' tabIndex='69'>
								<input type='hidden' name='m_country_code' id='m_country_code' value="<%=(String)hashMap1.get("mail_country_code")%>"></td>
							</tr>
							<tr>
								<td  class='label'><fmt:message key="Common.invalid.label" bundle="${common_labels}"/></td>
								<td   class='fields' colspan='2'> 
								<% out.print("<input type='checkbox' name='r_invalid_yn' id='r_invalid_yn' value='Y' tabIndex='63' "); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
								if(((String)hashMap1.get("resi_invalid1_yn")).equals("Y") ) out.print(" checked >");
								else out.print(">"); %></td>
							   <% /*Below line added for this CRF ML-MMOH-CRF-0601*/
							   if(alterAddressApplicable){%>
								 <td   class='fields' colspan='2'> 
								<% out.print("<input type='checkbox' name='a_invalid_yn' id='a_invalid_yn' value='Y' tabIndex='66' "); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
								if(((String)hashMap1.get("alt_invalid_yn")).equals("Y") ) out.print(" checked >");
								else out.print(">"); %></td>
								 <%}
								 //End this ML-MMOH-CRF-0601
								 %>
								 
								<td>
								<% out.print("<input type='checkbox' name='m_invalid_yn' id='m_invalid_yn' value='Y' tabIndex='70'"); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
								if(((String)hashMap1.get("mail_invalid1_yn")).equals("Y") ) out.print(" checked >");
								else  out.print(">");
								%></td>
							</tr>
							<tr>
							    <!--below legend name changed ML-MMOH-CRF-939 by Mano-->
								<td  class='label' ><fmt:message key="eMP.ContactPerson.label" bundle="${mp_labels}"/></td>
								<td colspan='2' class='fields'>
								<%
								if(!(((String)hashMap1.get("resi_contact1_name")).equals("") )) { %>
									<input type='text' name='r_contact_name' id='r_contact_name' size='30' maxlength='30'  value="<%=(String)hashMap1.get("resi_contact1_name")%>" onBlur='makeValidString(this);' tabIndex='63'>
								<% } else { %>
								    <input type='text' name='r_contact_name' id='r_contact_name' size='30' maxlength='30'  onBlur='makeValidString(this);' tabIndex='63'>
								<% } %></td>
								
								<%
							//Below line added for this CRF and ML-MMOH-CRF-0601 
							if(alterAddressApplicable)
							{                           							
							%>
							<td class='fields' colspan='<%=col_span_td%>'>
							   <%if(!(((String)hashMap1.get("alt_contact_name")).equals("") )) {%>
                                <input type='text' name='a_contact_name' id='a_contact_name' size='30' maxlength='30'  onblur='makeValidString(this);' 
								value="<%=(String)hashMap1.get("alt_contact_name")%>" tabIndex='67'>
								<% } else { %>
								    <input type='text' name='a_contact_name' id='a_contact_name' size='30' maxlength='30'  onBlur='makeValidString(this);' tabIndex='67'>
								<% } %>
                            </td >
							<%
							}//End this CRF ML-MMOH-CRF-0601
							%>								
							<td><%
								if(!(((String)hashMap1.get("mail_contact1_name")).equals("") )) { %>
								    <input type='text' name='m_contact_name' id='m_contact_name' size='30' maxlength='30'  value="<%=(String)hashMap1.get("mail_contact1_name")%>" onBlur='makeValidString(this);' tabIndex='71'>
								<% } else  { %>
								    <input type='text' name='m_contact_name' id='m_contact_name' size='30' maxlength='30'  onBlur='makeValidString(this);' tabIndex='71'>
								<% } %>
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
					<td  class='COLUMNHEADER'  <%=colspantd%> ><fmt:message key="eMP.ContactModes.label" bundle="${mp_labels}"/></td>
				</tr>
				<tr>
					<%  
					arrayList5 = eMP.ChangePatientDetails.getResultRows(con,"mp_contact_mode1",p);

			
					%>
					<td  class='label'><%=(String)arrayList5.get(0)%></td><%
					if(!(((String)hashMap1.get("prn_tel_no")).equals(""))) {
					     //Modified for this SCF AAKH-SCF-0261
						%> <td class='fields'><input type='text' name='contact1_no' id='contact1_no' maxlength='20' size='13'  value="<%=(String)hashMap1.get("prn_tel_no")%>"  onblur='makeValidString(this);return isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);'></td><%
					} else { 
						%><td class='fields'><input type='text' name='contact1_no' id='contact1_no' maxlength='20' size='13' value="" 
						  onblur='makeValidString(this);return isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);'></td><% 
					}
					%><td  class='label'><%=(String)arrayList5.get(1)%></td> <% 
					//New Conditon  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
					if(mobile_no_reqd_yn.equals("Y")){ 
							   mobile_no_visibility = "visibility:visible";}		
					if(!(((String)hashMap1.get("orn_tel_no")).equals(""))) {
					 //Modified for this SCF AAKH-SCF-0261
					 //New Iamge  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
						%><td class='fields'>
					<!--Added by Kamatchi S for ML-MMOH-CRF-1930 US004-->
					<%if(isVirtualConsultation){
							try{
							stmt=con.prepareStatement("select country_code,long_desc from mp_country where eff_status = 'E' order by long_desc asc");
							rs = stmt.executeQuery();%>
					<select name='country' id='country' onChange= 'telephoneCode1(this);'><option value=''>-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>
					<%				
									countryC = (String)hashMap1.get("contact2_country_code");
									if(!countryD.equals("") && countryC.equals(""))
									{
									countryC = countryD;
									}
									if( rs != null )
									{
										while(rs.next()) 
											{
											classcode = rs.getString( "country_code" ) ;
											classdesc = rs.getString( "long_desc" ) ;
											if(!countryC.equals("")){
												if(countryC.equals(classcode)){
												out.println("<option value=\"" + classcode + "\" selected>" + classdesc );
												}else{ 
													out.println("<option value=\"" + classcode + "\">" + classdesc);
												}
											}
											else{
												out.println("<option value=\"" + classcode + "\">" + classdesc);
											}
											}
									}
									out.println("<input type='hidden' name='countryC' id='countryC' value=\""+countryC+"\" > ") ;
									} catch(Exception e) { 
										out.println(e.toString());
										e.printStackTrace();
									} finally {
									if (rs != null) rs.close();
									if (stmt != null) stmt.close(); 			
									}%>
								</select> <input type='text' name='telephone' id='telephone' maxlength='6' size='6' Readonly value=\"\" >
								
								<%}%>
<input type='text' name='contact2_no' id='contact2_no' maxlength='20' size='13'  value="<%=(String)hashMap1.get("orn_tel_no")%>"  onblur='makeValidString(this);return isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);'><img id='id3' src='../images/mandatory.gif' style='<%=mobile_no_visibility%>'</img><%
					} else  {    
					             //Modified for this SCF AAKH-SCF-0261
								 
								   //New Iamge  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
						%><td class='fields'>
						<!--Added for ML-MMOH-CRF-1930-US004-->
						<%if(isVirtualConsultation){
							try{
							stmt=con.prepareStatement("select country_code,long_desc from mp_country where eff_status = 'E' order by long_desc asc");
							rs = stmt.executeQuery();%>
							<select name='country' id='country' onChange= 'telephoneCode1(this);'><option value=''>-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>
							<%				
									countryC = (String)hashMap1.get("contact2_country_code");
									if(countryC.equals(""))
									{
									countryC = countryD;
									}
									if( rs != null )
									{
										while(rs.next()) 
											{
											classcode = rs.getString( "country_code" ) ;
											classdesc = rs.getString( "long_desc" ) ;
											if(!countryC.equals("")){
												if(countryC.equals(classcode)) {
												out.println("<option value=\"" + classcode + "\" selected>" + classdesc );
												}else{ 
												out.println("<option value=\"" + classcode + "\">" + classdesc);
												}
											}else{
													out.println("<option value=\"" + classcode + "\">" + classdesc);
											}
											}
									}
									out.println("<input type='hidden' name='countryC' id='countryC' value=\""+countryC+"\" > ") ;
									} catch(Exception e) { 
										out.println(e.toString());
										e.printStackTrace();
									} finally {
									if (rs != null) rs.close();
									if (stmt != null) stmt.close(); 			
									}%>
								</select> <input type='text' name='telephone' id='telephone' maxlength='6' size='6' Readonly value=\"\" >
								
								<%}%>
								<!--End ML-MMOH-CRF-1930-US004-->
						<input type='text' name='contact2_no' id='contact2_no' maxlength='20' size='13'  value=""  
						onblur='makeValidString(this);return isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);'><img id='id3' src='../images/mandatory.gif' style='<%=mobile_no_visibility%>'</img><%
					} %>
					</td>
					<%//Below line added for this CRF ML-MMOH-CRF-0860.2
					if(increasedaddressLength){
					    if(email_id_reqd_yn.equals("Y")){ 
							   email_visibility = "visibility:visible";} 
					%>
					<td class='label'  ><fmt:message key="Common.email.label" bundle="${common_labels}"/></td> 
					<td class='fields'><input type='text' name='email' id='email' maxlength=50 size=34 value="<%=(String)hashMap1.get("email_id")%>" onBlur='makeValidString(this);'><img id='id4' src='../images/mandatory.gif' style='<%=email_visibility%>'</img></td> 					
					<%}%>					
					</tr>					
					<%
					//Below line added for this CRF ML-MMOH-CRF-0860.2
					if(!increasedaddressLength){	
					
					if(email_id_reqd_yn.equals("Y")){ 
							   email_visibility = "visibility:visible";} 
					 %>
					<tr>
					<td class='label'  ><fmt:message key="Common.email.label" bundle="${common_labels}"/></td> 
					<td colspan='3' class='fields'><input type='text' name='email' id='email' maxlength=50 size=34 value="<%=(String)hashMap1.get("email_id")%>" onBlur='makeValidString(this);'><img id='id4' src='../images/mandatory.gif' style='<%=email_visibility%>'</img></td></tr> 					
					<%}//End ML-MMOH-CRF-0860.2
					
					String enabledisable		= "";
					String contact_mode_flag	= "";
					
					//Below line added for this CRF ML-MMOH-CRF-0860.2
					if(increasedaddressLength){	%>
					<tr>
						<td class='label' ><fmt:message key="eMP.othermodes.label" bundle="${mp_labels}"/></td>
						<td class='fields'> <select name='contact3_mode' id='contact3_mode' <%=enabledisable%> onchange='enableContactNo(this)'>
					   <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option><%
						arrayList6 = eMP.ChangePatientDetails.getResultRows(con,"mp_contact_mode2",p);
						if(arrayList6.size() > 0) {
							for(int i=0;i<arrayList6.size();i+=2) {
								 out.print("<option value=\""+(String)arrayList6.get(i)+"\"");
								if ( ((String)arrayList6.get(i)).equals((String)hashMap1.get("contact3_mode")) )
									out.print(" selected ");
								out.print(" >"+(String)arrayList6.get(i+1)+ "</option>");
							}
							contact_mode_flag = "yes";
						}
						else contact_mode_flag = "no";
						%></select><% 
						if(!(((String)hashMap1.get("contact3_no")).equals(""))) {
						%><input type='text' name='contact3_no' id='contact3_no' maxlength='20' size='13' value="<%=(String)hashMap1.get("contact3_no")%>" onBlur='makeValidString(this);'>
						<% } else {
					   %><input type='text' name='contact3_no' id='contact3_no' maxlength='20' size='13'  value="" onBlur='makeValidString(this);'>
						<%
						   }

						if(contact_mode_flag.equals("yes"))
						{
							enabledisable = "";
							%>
							<script>
								document.forms[0].contact3_mode.disabled = false;
							</script>						
							<%
						}
						else if(contact_mode_flag.equals("no"))
						{
							enabledisable	= "disabled"; 
							%>
							<script>
								document.forms[0].contact3_mode.disabled = true;
							</script>
							<%
						}
					    %>

						<script>							
							if(document.forms[0].contact3_mode.value=='') 
								document.forms[0].contact3_no.disabled= true;
						</script>
						</td>						
						<td class='label' >&nbsp;</td>
						<td class='fields'><select name='contact4_mode' id='contact4_mode'  <%=enabledisable%> onchange='enableContactNo(this)'>
						<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option><%
						for(int i=0;i<arrayList6.size();i+=2) {
							 out.print("<option value='"+(String)arrayList6.get(i)+"'");
							if ( ((String)arrayList6.get(i)).equals((String)hashMap1.get("contact4_mode")) )
								out.print(" selected ");
							out.print(">"+(String)arrayList6.get(i+1)+ "</option>");
						}
					  %></select><%
						if(!(((String)hashMap1.get("contact4_no")).equals(""))) {
							%><input type='text' name='contact4_no' id='contact4_no' maxlength='20' size='13'  value="<%=(String)hashMap1.get("contact4_no")%>" onBlur='makeValidString(this);'><%
						}else {
						%><input type='text' name='contact4_no' id='contact4_no' maxlength='20' size='13'  value="" onBlur='makeValidString(this);'>
						 <%}%>
						<script>
						if(document.forms[0].contact4_mode.value=='') 
						   document.forms[0].contact4_no.disabled= true; 
					  </script>
					  </td>
					    <td class='label'>&nbsp;</td>
					  <td class='fields'> <select name='contact5_mode' id='contact5_mode'  <%=enabledisable%> onchange='enableContactNo(this)'> <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option><%
						for(int i=0;i<arrayList6.size();i+=2) {
								out.print("<option value='"+(String)arrayList6.get(i)+"'");
							if(((String)arrayList6.get(i)).equals((String)hashMap1.get("contact5_mode")))
								out.print(" selected ");
							out.print(">"+(String)arrayList6.get(i+1)+ "</option>");
						}
					  %></select><%
					  if(!(((String)hashMap1.get("contact5_no")).equals(""))) { %><input type='text' name='contact5_no' id='contact5_no' maxlength='20' size='13'  value="<%=(String)hashMap1.get("contact5_no")%>" onBlur='makeValidString(this);'>
					  <% } else { %><input type='text' name='contact5_no' id='contact5_no' maxlength='20' size='13'  value="" onBlur='makeValidString(this);'> 
					   <%}%>
					  <script>
					  if(document.forms[0].contact5_mode.value=='') 
						   document.forms[0].contact5_no.disabled= true; 
					  </script>
					  
						</tr>
					
					
					<%}else{%>
					<tr>
						<td class='label' ><fmt:message key="eMP.othermodes.label" bundle="${mp_labels}"/></td>
						<td class='fields'> <select name='contact3_mode' id='contact3_mode' <%=enabledisable%> onchange='enableContactNo(this)'>
					   <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option><%
						arrayList6 = eMP.ChangePatientDetails.getResultRows(con,"mp_contact_mode2",p);
						if(arrayList6.size() > 0) {
							for(int i=0;i<arrayList6.size();i+=2) {
								 out.print("<option value=\""+(String)arrayList6.get(i)+"\"");
								if ( ((String)arrayList6.get(i)).equals((String)hashMap1.get("contact3_mode")) )
									out.print(" selected ");
								out.print(" >"+(String)arrayList6.get(i+1)+ "</option>");
							}
							contact_mode_flag = "yes";
						}
						else contact_mode_flag = "no";
						%></select><% 
						if(!(((String)hashMap1.get("contact3_no")).equals(""))) {
						%><input type='text' name='contact3_no' id='contact3_no' maxlength='20' size='13' value="<%=(String)hashMap1.get("contact3_no")%>" onBlur='makeValidString(this);'>
						<% } else {
					   %><input type='text' name='contact3_no' id='contact3_no' maxlength='20' size='13'  value="" onBlur='makeValidString(this);'>
						<%
						   }

						if(contact_mode_flag.equals("yes"))
						{
							enabledisable = "";
							%>
							<script>
								document.forms[0].contact3_mode.disabled = false;
							</script>						
							<%
						}
						else if(contact_mode_flag.equals("no"))
						{
							enabledisable	= "disabled"; 
							%>
							<script>
								document.forms[0].contact3_mode.disabled = true;
							</script>
							<%
						}
					    %>

						<script>							
							if(document.forms[0].contact3_mode.value=='') 
								document.forms[0].contact3_no.disabled= true;
						</script>
						</td>
						<td class='label' colspan='2'>&nbsp;</td>
						</tr>

						<tr>
						<td class='label' >&nbsp;</td>
						<td class='fields'><select name='contact4_mode' id='contact4_mode'  <%=enabledisable%> onchange='enableContactNo(this)'>
						<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option><%
						for(int i=0;i<arrayList6.size();i+=2) {
							 out.print("<option value='"+(String)arrayList6.get(i)+"'");
							if ( ((String)arrayList6.get(i)).equals((String)hashMap1.get("contact4_mode")) )
								out.print(" selected ");
							out.print(">"+(String)arrayList6.get(i+1)+ "</option>");
						}
					  %></select><%
						if(!(((String)hashMap1.get("contact4_no")).equals(""))) {
							%><input type='text' name='contact4_no' id='contact4_no' maxlength='20' size='13'  value="<%=(String)hashMap1.get("contact4_no")%>" onBlur='makeValidString(this);'><%
						}else {
						%><input type='text' name='contact4_no' id='contact4_no' maxlength='20' size='13'  value="" onBlur='makeValidString(this);'>
						 <%}%>
						<script>
						if(document.forms[0].contact4_mode.value=='') 
						   document.forms[0].contact4_no.disabled= true; 
					  </script>
					  </td><td class='label' colspan='2'>&nbsp;</td>
					  </tr>
					  <tr>
  					  <td class='label'></td>
					  <td class='fields'> <select name='contact5_mode' id='contact5_mode'  <%=enabledisable%> onchange='enableContactNo(this)'> <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option><%
						for(int i=0;i<arrayList6.size();i+=2) {
								out.print("<option value='"+(String)arrayList6.get(i)+"'");
							if(((String)arrayList6.get(i)).equals((String)hashMap1.get("contact5_mode")))
								out.print(" selected ");
							out.print(">"+(String)arrayList6.get(i+1)+ "</option>");
						}
					  %></select><%
					  if(!(((String)hashMap1.get("contact5_no")).equals(""))) { %><input type='text' name='contact5_no' id='contact5_no' maxlength='20' size='13'  value="<%=(String)hashMap1.get("contact5_no")%>" onBlur='makeValidString(this);'>
					  <% } else { %><input type='text' name='contact5_no' id='contact5_no' maxlength='20' size='13'  value="" onBlur='makeValidString(this);'> 
					   <%}%>
					  <script>
					  if(document.forms[0].contact5_mode.value=='') 
						   document.forms[0].contact5_no.disabled= true; 
					  </script>
					  </td><td class='label' colspan='2'>&nbsp;</td>
					 </tr>
					 <%}
					  //End ML-MMOH-CRF-0860.2
					 %>
					 <tr><td class='COLUMNHEADER' <%=colspantd%> ><b><fmt:message key="Common.additionaldetails.label" bundle="${common_labels}"/></b></td></tr>
					 <tr>
					 <% 
						int myflag = 0;
						for(int i=0; i<custcount;i++) { 
							if(cust_fields[i].charAt(0) == 'C') {
							int intind_0	= cust_fields[i].indexOf('`');
							String strcf	= cust_fields[i];		
							String strs1	= strcf.substring(intind_0+1, strcf.length());
												
							int intind_1	= strs1.indexOf('`');
							String lab		= strs1.substring(0, intind_1);
							String strs2		= strs1.substring(intind_1+1, strs1.length());
							int intind_2	= strs2.indexOf('`');
							String size		= strs2.substring(0, intind_2);
							
							String strs3	= strs2.substring(intind_2+1, strs2.length());
							int intind_3	= strs3.indexOf('`');
							String nme		= strs3.substring(0, intind_3);
								
							String strs4	= strs3.substring(intind_3+1, strs3.length());
							val 		= checkForNull(strs4.substring(0));
							if (myflag%2==0)
							{
								%></tr><tr><%
							}
							%><td  class='label' ><%=lab%></td>
							 <td class='fields'><input type='text' name='<%=nme%>' id='<%=nme%>' value="<%=val%>" maxlength='<%=size%>' size='<%=size%>' onblur='makeValidString(this);'></td><%
							 myflag++;
							}
							}
							 if (myflag%2 != 0)
							{
								%><td class='label' colspan='2'>&nbsp;</td><%
							}
						%>
					   </tr>
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
	<table cellspacing='0' cellpadding='0' width='100%' border=0>
	<tr>
		<td valign=top width='45%' >
		<table cellspacing='0' cellpadding='2' border=0 width='100%'>
		<tr>
			<td  class='label' ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
			<td class='fields'>
			<!--Added for ML-MMOH-CRF-0887.1-->
			<%if(increasedaddressLength){%>
				<textarea name='next_contact_name' rows=3 maxlength=80 cols=45 onblur='makeValidString(this); maxLengthPaste(this);' onkeypress='checkMaxLimit(this,80)' onkeyup='RemoveSpecialChar(this)' style="background-color: #E5E5E5;color: #A0A0A0;border: 1px solid #BCBCBC;"><%=(String)hashMap1.get("nkin_contact_name")%></textarea>
			<%}else{%>			
			<input type="text" name="next_contact_name" id="next_contact_name" value="<%=(String)hashMap1.get("nkin_contact_name")%>" maxlength='80' size='30'></td>
			<%}%>
			<!--above next_contact name length change against CRF-0887 by mano on 25/7/2017-->
		</tr>			
		<!-- Below added by Suji Keerthi for ML-MMOH-CRF-1527 -->
		<%if(aliasnameNationalityRace){%>
				<tr><td  class="label" ><fmt:message key="eMP.AliasName.label" bundle="${mp_labels}"/></td>
				<td  class='fields'>
				<input type='text' name="rel_alias_name" id="rel_alias_name" maxlength='30' size='20' value="<%=(String)hashMap1.get("nkin_alias_name")%>" ></td>
		</tr>
		<%} %>
		<!-- Ended for ML-MMOH-CRF-1527 -->	
		<tr>
			<td  class='label' ><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td> 	

			 <td  class='fields'> <input type='text' name='next_contact_relation_desc' id='next_contact_relation_desc' size='20' maxlength='20' value="<%=(String)hashMap1.get("nkin_contact_relation_desc")%>" onblur='if(this.value!=""){searchRelationship(next_contact_relation,next_contact_relation_desc);}else{clearfields();}'  ><input type='button'  id='next_contact_relation_id'  name='next_contact_relation_code_id' id='next_contact_relation_code_id' value='?' class='button' onclick='searchRelationship(this,next_contact_relation_desc)' >
			<input type='hidden' name='next_contact_relation' id='next_contact_relation' value="<%=(String)hashMap1.get("nkin_contact_relation")%>">	<td> 

		</tr>
		<tr>
			<% 
				if(accept_national_id_no_yn.equals("Y")) { 
					nat_on_blurfn_st = "makeValidString(this);validateNationality(this,'"+Site+"','"+nat_id_pat_ser_grp+"','"+nat_invoke_routine+"','"+nat_data_source_id+"','"+nat_id_check_digit_id+"','"+nat_id_chk_len+"','N')";

					if(nat_id_accept_alphanumeric_yn.equals("Y"))
					{
						nat_id_onKeyPress = "return CheckForAlphaCharsNatID(event);";
					}
					else
					{
						if(nat_id_check_digit_id.equals("M11"))
							nat_id_onKeyPress = "return CheckForCharsNatID(event);";
						else
							nat_id_onKeyPress = "return allowValidNumber(this,event,2, 0);";
					}						
			%>
			<td  class='label'><%=(String)hashMap.get("nat_id_prompt")%></td>
			<td class='fields'><input type='text' name='contact1_new_nat_id_no' id='contact1_new_nat_id_no' maxlength="<%=disp_nat_id_length%>" size="<%=disp_nat_id_length%>"  onkeypress="<%=nat_id_onKeyPress%>"onblur="<%=nat_on_blurfn_st%>" value= '<%=(String)hashMap1.get("contact1_nat_id_no")%>'  >
			</td>
				<%}else{%><td  class='label'><input type='hidden' name='contact1_new_nat_id_no' id='contact1_new_nat_id_no' value='' ></td><%}%>
		</tr>
		 
		<%if(!Alt_Id1_Type.equals("")) {%>		 
		<tr><td  class='label'><%= (String)hashMap.get("alt_id1_desc") %></td><td class='fields'><input type='hidden' name='contact1_alt_id1_type' id='contact1_alt_id1_type' value= "<%=(String)hashMap1.get("contact1_alt_id1_type")%>"> 
		<input type='text' name='contact1_alt_id1_no' id='contact1_alt_id1_no' maxlength='<%=Alt_Id1_length%>' size='<%=Alt_Id1_length%>' onblur='makeValidString(this);' value= "<%=(String)hashMap1.get("contact1_alt_id1_no")%>" ></td></tr>
		<% } if(!Alt_Id2_Type.equals("")) {%>	
		
		<tr><td  class='label'><%= (String)hashMap.get("alt_id2_desc") %></td><td class='fields'> <input type='hidden' name='contact1_alt_id2_type' id='contact1_alt_id2_type' value= "<%=(String)hashMap1.get("contact1_alt_id2_type")%>">
		<input type='text' name='contact1_alt_id2_no' id='contact1_alt_id2_no' maxlength='<%=Alt_Id2_length%>' size='<%=Alt_Id2_length%>'  onblur='makeValidString(this);' value= "<%=(String)hashMap1.get("contact1_alt_id2_no")%>" ></td></tr>
		<% } if(!Alt_Id3_Type.equals("")) {%>	
		
		<tr><td  class='label'><%=(String)hashMap.get("alt_id3_desc")%></td><td class='fields'><input type='hidden' name='contact1_alt_id3_type' id='contact1_alt_id3_type' value= "<%=(String)hashMap1.get("contact1_alt_id3_type")%>">
		<input type='text' name='contact1_alt_id3_no' id='contact1_alt_id3_no' maxlength='<%=Alt_Id3_length%>' size='<%=Alt_Id3_length%>'  onblur='makeValidString(this);' value= "<%=(String)hashMap1.get("contact1_alt_id3_no")%>" ></td></tr>
		<% } if(!Alt_Id4_Type.equals("")) {%>	
			
		<tr><td  class='label'><%=(String)hashMap.get("alt_id4_desc")%></td><td class='fields'><input type='hidden' name='contact1_alt_id4_type' id='contact1_alt_id4_type' value= "<%=(String)hashMap1.get("contact1_alt_id4_type")%>">
		<input type='text' name='contact1_alt_id4_no' id='contact1_alt_id4_no' maxlength='20' size='20'  onblur='makeValidString(this);' value= "<%=(String)hashMap1.get("contact1_alt_id4_no")%>" ></td></tr>
		<%}	

		} if(Accept_oth_alt_id_yn.equals("Y")){%>
		<tr><td  class='label'><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<select name='contact1_oth_alt_id_type' id='contact1_oth_alt_id_type'  onChange='enableOtherAltIdText(this.value)'> 
		<option value=''>----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------<% 
			for(int i=0;i<arrayList1.size();i+=2) {
			out.print("<option value='"+(String)arrayList1.get(i)+"'");
			if(((String)arrayList1.get(i)).equals((String)hashMap1.get("contact1_oth_alt_id_type")))
				out.print(" selected ");
			out.print(" >"+(String)arrayList1.get(i+1)+"</option>");	
		}%></select>
		<input type='text' name='contact1_oth_alt_id_no' id='contact1_oth_alt_id_no' maxlength='20' size='20'  onblur='makeValidString(this);' disabled value = "<%=(String)hashMap1.get("nkin_oth_alt_id_no")%>">
		</td></tr> <% } %>
		<tr><td  class='label'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='contact1_birth_date' id='contact1_birth_date'  maxlength='10' size='10'  onblur='makeValidString(this);gotoNext(this)' value = "<%=contact1_birth_date%>"><input type='image' src='../../eCommon/images/CommonCalendar.gif' id="birthdate1"  onClick="document.getElementById('contact1_birth_date').select();return showCalendar('contact1_birth_date');" >
                </td></tr>
		<!-- Below added by Suji Keerthi for ML-MMOH-CRF-1527 -->
		<%if(aliasnameNationalityRace){%>
		 <tr>
                <td class="label" ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
			    <td class='fields'>
					<input type='text' name='rel_nationality_desc' id='rel_nationality_desc' size='20' maxlength='20'  onblur='if(this.value !="") {searchCountry(rel_contry_code, rel_nationality_desc);}' value="<%=(String)hashMap1.get("rel_nkin_nationality_desc")%>" ><input type='button' name='rel_contry_code' id='rel_contry_code' value='?' class='button' onclick='searchCountry(this,rel_nationality_desc)' >
					<input type='hidden' name='rel_nationality_code' id='rel_nationality_code' value="<%=(String)hashMap1.get("rel_nkin_nationality_code")%>">
				</td>
		 </tr>
		<%
		
		%>
		        <tr><td  class="label" ><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
				<td  class='fields'> <input type='text' name='rel_race_desc' id='rel_race_desc' size='20' maxlength='20' onblur='if(this.value !="") {searchRace(rel_race_code,rel_race_desc);}' value="<%=(String)hashMap1.get("rel_nkin_race_desc")%>" ><input type='button' name='rel_race_desc_id' id='rel_race_desc_id' value='?' class='button' onclick='searchRace(this,rel_race_desc)' >
				<input type='hidden' name='rel_race_code' id='rel_race_code' value="<%=(String)hashMap1.get("rel_nkin_race_code")%>">		
				</td>
				</td></tr>
				<%} %>
		<!-- Ended for ML-MMOH-CRF-1527 -->
		<tr><td  class='label'><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td><td class='fields'><input type='text' name='next_job_title' id='next_job_title' maxlength='30' size='30'  onblur='makeValidString(this);' value = "<%=(String)hashMap1.get("nkin_job_title")%>"></td> <%
		for(int i=0; i<cust_fields.length;i++) {
			if(cust_fields[i].charAt(0) == 'N') {
				out.println("<tr>");
				int intind_0	= cust_fields[i].indexOf('`');
				String strcf	= cust_fields[i];		
				String strs1	= strcf.substring(intind_0+1, strcf.length());
									
				int intind_1	= strs1.indexOf('`');
				String lab		= strs1.substring(0, intind_1);
				String strs2		= strs1.substring(intind_1+1, strs1.length());
				int intind_2	= strs2.indexOf('`');
				String size		= strs2.substring(0, intind_2);
				
				String strs3	= strs2.substring(intind_2+1, strs2.length());
				int intind_3	= strs3.indexOf('`');
				String nme		= strs3.substring(0, intind_3);
					
				String strs4	= strs3.substring(intind_3+1, strs3.length());
				 val 		= checkForNull(strs4.substring(0));
				%>
				<td class='label'   width=''><%=lab%></td>
				<td class='fields'><input type='text' name='<%=nme%>' id='<%=nme%>' maxlength='<%=size%>' size='<%=size%>' value='<%=val%>'  onblur='makeValidString(this);'></td></tr><%
			}
		}  %> </tr>
			</table>
		</td>
		<td width='55%' >
		<table cellspacing='0' cellpadding='2' border='0' width='100%' >
		<!-- Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->
				<% if(resiAddMailAdd){%>
				<td width='70%'><table cellspacing='0' cellpadding='2' border='0' width='100%'>
				<tr>
                     <td class='COLUMNHEADER'  ></td>
                     <td  class='COLUMNHEADER' ><fmt:message key="eMP.residenceaddress.label" bundle="${mp_labels}"/></td>
                     <td  class='COLUMNHEADER' ><fmt:message key="Common.MailingAddress.label" bundle="${common_labels}"/></td>
                </tr>
                </td>
                <%} %>
        <!-- Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008 -->
		<tr> 
		<%
			StringBuffer sbc		= new StringBuffer();
		    StringBuffer nksbc1       = new StringBuffer(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			StringBuffer sb1c		= new StringBuffer();
			StringBuffer nksb1c1       = new StringBuffer(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			StringBuffer sbap1		= new StringBuffer();
			StringBuffer sbap11       = new StringBuffer(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			StringBuffer sbar1		= new StringBuffer();
			StringBuffer sbar11       = new StringBuffer(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			StringBuffer fieldValc	= new StringBuffer();
			StringBuffer nkfieldValc1       = new StringBuffer(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008

			for(int i=0;i<contact_col_names.length; i++) {
			   val = contact_fields[i] ;
			 String  val3 = contact_fields[i] ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			 sbc.append(val) ;
			 nksbc1.append(val3) ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			 int j = 0 ;
			 int j1 = 0 ;
			 String old_val = "" ;
			 String new_val = "" ;
			 String new_val1 = "" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			 if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt")) {
				old_val = "r_addr_line1" ;
				new_val = "next_addr_line1" ;
				new_val1 = "n_next_addr_line1" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			 }
			 else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt")) {
				old_val = "r_addr_line2" ;
				new_val = "next_addr_line2" ;
				new_val1 = "n_ma_addr_line2" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			 }
			 else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt")) {
				old_val = "r_addr_line3" ;
				new_val = "next_addr_line3" ;
				new_val1 = "n_ma_addr_line3" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			 }
			 else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt")) {
				old_val = "r_addr_line4" ;
				new_val = "next_addr_line4" ;
				new_val1 = "n_ma_addr_line4" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			 }
			 else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
				old_val = "r_town_code" ;
				new_val = "contact1_res_town_code" ;
				new_val1 = "n_contact_ma_town_code" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			 }
			 else if(contact_col_names[i].equalsIgnoreCase("region_prompt")) {
				old_val = "r_region_code" ;
				new_val = "contact1_region_code" ;
				new_val1 = "n_contac_region_code" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			 }
			 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
				old_val = "r_area_code" ;
				new_val = "contact1_res_area_code" ;
				new_val1 = "n_contact_ma_area_code" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			 }                                     
			 else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt")) {
				old_val = "r_postal_code" ;
				new_val = "next_postal_code" ;
				new_val1 = "n_ma_postal_code" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			 } %>
			<td class='label' nowrap><%=contact_prompts[i]%></td>	
			<% while(val.indexOf(old_val) != -1) {
				j = val.indexOf(old_val,j) ;
				sbc = sbc.replace(j,(j+old_val.length()),new_val);
				val = sbc.toString();

				nksbc1 = nksbc1.replace(j,(j+old_val.length()),new_val1); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
				val3 = nksbc1.toString(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			}
			if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
				sbap1.append(val);
				sbap11.append(val3); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
				while(val.indexOf("r_postal_code") != -1) {
					j1 = val.indexOf("r_postal_code",j1) ;
					sbap1 = sbap1.replace(j1,(j1+"r_postal_code".length()),"next_postal_code");
					val = sbap1.toString();

					sbap11 = sbap11.replace(j1,(j1+"r_postal_code".length()),"n_ma_postal_code"); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
					val3 = sbap11.toString(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
				}
			}
			if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
				j1 = 0;
				sbar1.append(val);
				sbar11.append(val3); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
				while(val.indexOf("r_postal_code") != -1) {
					j1 = val.indexOf("r_postal_code",j1) ;
					sbar1 = sbar1.replace(j1,(j1+"r_postal_code".length()),"next_postal_code");
					val = sbar1.toString();

					sbar11 = sbar11.replace(j1,(j1+"r_postal_code".length()),"n_ma_postal_code"); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
					val3 = sbar11.toString();  //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
				}
			}
		    sb1c.append(val);
			fieldValc.append("");
			for(int z=0;z<val.length();z++) {
				String tempVal=sb1c.substring(z,z+1);
				if(tempVal.equals("@")) {
					fieldValc.append("85");
				}
				else {
					fieldValc.append(tempVal);
				}
			}
			val = fieldValc.toString();

			//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
					nksb1c1.append(val3) ;
					nkfieldValc1.append("");
					for(int z=0;z<val3.length();z++) {
						String tempVal=nksb1c1.substring(z,z+1);
						if(tempVal.equals("@")) {
							nkfieldValc1.append("88"); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
						}
						else {
							nkfieldValc1.append(tempVal);
						}
					}
					val3 = nkfieldValc1.toString();

					if(resiAddMailAdd){
			out.println("<td class='fields' >"+val+"&nbsp;&nbsp;") ;
			out.println("<td class='fields' >"+val3+"&nbsp;&nbsp;") ;%>
			</td></td>
			<%}else{
			out.println("<td class='fields' >"+val) ;%>
			</td>
			<%}
			//Ended by Suji keerthi for ML-MMOH-CRF-1527 US008%>
			</tr>
			<%
			sbc.setLength(0);
			nksbc1.setLength(0); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			sbap1.setLength(0);
			sbap11.setLength(0); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			sbar1.setLength(0);
			sbar11.setLength(0); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			sb1c.setLength(0);
			nksb1c1.setLength(0); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			fieldValc.setLength(0);
			nkfieldValc1.setLength(0); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		} %>                
   <tr><td  class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td><td class='fields'><input type='text' name='next_country_desc' id='next_country_desc' size='15' maxlength='15' onblur='if(this.value !=""){ searchCountry(contry_code[0],next_country_desc)}else{clearCountryFields(this)}'  value="<%=(String)hashMap1.get("nkin_country_name")%>" tabindex='86'><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,next_country_desc)' tabindex='86'><input type='hidden' name='next_country_code' id='next_country_code' value='<%=(String)hashMap1.get("nkin_country_code")%>'></td>
   <!--Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->
				<% if(resiAddMailAdd){%>
					
					<td class='fields'><input type='text' name='nk_ma_country_desc' id='nk_ma_country_desc' size='15' maxlength='15' value='<%=(String)hashMap1.get("nk_mail_country_desc")%>' onblur='if(this.value !="") {searchCountry(nk_ma_country_code,nk_ma_country_desc);}else{clearCountryFields(this);} ' tabindex='89'><input type='button' name='nk_ma_country_code' id='nk_ma_country_code' value='?' class='button' onclick='searchCountry(this,nk_ma_country_desc)' tabindex='89'>
					<input type='hidden' name='nkin_mail_country_code' id='nkin_mail_country_code' value="<%=(String)hashMap1.get("nkin_m_country_desc")%>">
					</td>
				</tr>
				<tr>
					<td class='label'  ><fmt:message key="eMP.ContactPerson.label" bundle="${mp_labels}"/></td> 
                    <td class='fields'>
                    <input type='text' name='ra_contact_name' id='ra_contact_name' size='30' maxlength='30'  onblur='makeValidString(this);' value= "<%=(String)hashMap1.get("resadd_contact_name")%>" tabindex='87'>
                    </td>
                    <td class='fields'>
                    <input type='text' name='ma_contact_name' id='ma_contact_name' size='30' maxlength='30'  onblur='makeValidString(this);' value="<%=(String)hashMap1.get("mailadd_contact_name")%>" tabindex='90'>
                    </td></tr>
                 <table border = 0 cellspacing='0' cellpadding='1' width='100%'>
			    <tr><td class='label' width='25%'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    <a href='javascript:copyDetails(10)'><fmt:message key="eMP.CopyFirsttoNotify.label" bundle="${mp_labels}"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href='javascript:copyDetails(8)'><fmt:message key="eMP.CopyPatientAddress.label" bundle="${mp_labels}"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <a href='javascript:copyDetails(9)'><fmt:message key="eMP.CopyResidenceAddress.label" bundle="${mp_labels}"/></a>
			    </td></tr></table>
				</table>
                <%} %>	

   <%if(!resiAddMailAdd){%>
   <tr><td  class='label'><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td><td class='fields'><input type='text' name='next_res_tel_no' id='next_res_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value = "<%=(String)hashMap1.get("nkin_res_tel_no")%>"></td></tr><tr><td  class='label' ><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td><td class='fields'><input type='text' name='contact1_mob_tel_no' id='contact1_mob_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value = "<%=(String)hashMap1.get("nkin_mob_tel_no")%>"></td><tr><td  class='label'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td><td class='fields'><input type='text' name='next_off_tel_no' id='next_off_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value = "<%=(String)hashMap1.get("nkin_off_tel_no")%>"></td></tr><tr><td  class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/></td><td class='fields'><input type='text' name='contact1_email_id' id='contact1_email_id' maxlength='50' size='40' onblur='makeValidString(this);' value = "<%=(String)hashMap1.get("nkin_email_id")%>">
   </td>
   </tr>
   <%}%>
  <!--Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008-->
  </table>
  </td>
  </tr>
   <tr>
	   <td colspan='4'>
	    <% if(!resiAddMailAdd){%>  <!--Added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->
		 <table border = 0 cellspacing='0' cellpadding='2' width='100%'>
			<tr>	
		   <td width='45%'>
		   
			</td><td  width='55%'><span class='label'>
			<% if(((String)hashMap.get("Family_No_Link_Yn")).equals("Y")) 
			{ %>
			<a href='javascript:copyDetails(1)' id='label1'><fmt:message key="eMP.CopyHeadofFamily.label" bundle="${mp_labels}"/></img></a>&nbsp;&nbsp;&nbsp;
			<% } %>
			<%}%>  <!--Added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->
            
			<%if(!function_id.equals("PAT_REG")){%>
			<% if(!resiAddMailAdd){%>  <!--Added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->
			<%if(iSSiteApplicable){%>
				<a href='javascript:copyDetails(2)' id='label1'><fmt:message key="eMP.CopyPatientAddress.label" bundle="${mp_labels}"/></a>
             <%}else {%>
			 <a href='javascript:copyDetails(5)'><fmt:message key="eMP.CopyFirsttoNotify.label" bundle="${mp_labels}"/></a>
				&nbsp;&nbsp;&nbsp;<a href='javascript:copyDetails(2)' id='label2'><fmt:message key="eMP.CopyPatientAddress.label" bundle="${mp_labels}"/></a> 
			<%}%>
			<%}%>  <!--Added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->
				</span>
			</td>
		   </tr>
		  </table>
		  <!--Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->
		  <% if(resiAddMailAdd){%>
  </table>
  <table width="100%"><tr>
				<td  class='COLUMNHEADER' colspan='7' ><fmt:message key="eMP.ContactModes.label" bundle="${mp_labels}"/></td>
                </tr>
				<tr>
				    <td  class='label'><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type='text' name='next_res_tel_no' id='next_res_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);return isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);' value = "<%=(String)hashMap1.get("nkin_res_tel_no")%>"></td>

				    <td  class='label' ><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type='text' name='contact1_mob_tel_no' id='contact1_mob_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);return isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);' value = "<%=(String)hashMap1.get("nkin_mob_tel_no")%>"></td>
				    
					<td  class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type='text' name='contact1_email_id' id='contact1_email_id' maxlength='50' size='40' onblur='makeValidString(this);' value = "<%=(String)hashMap1.get("nkin_email_id")%>"></td>
                    
                </tr>
				  <%String enabledisable		= "";
					String contact_mode_flag	= "";%>
					<tr>
						<td class='label' ><fmt:message key="eMP.othermodes.label" bundle="${mp_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    <select name='nk_contact3_mode' id='nk_contact3_mode' <%=enabledisable%> onchange='enableContactNo(this)'>
					   <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option><%
						arrayList6 = eMP.ChangePatientDetails.getResultRows(con,"mp_contact_mode2",p);
						if(arrayList6.size() > 0) {
							for(int i=0;i<arrayList6.size();i+=2) {
								 out.print("<option value=\""+(String)arrayList6.get(i)+"\"");
								if ( ((String)arrayList6.get(i)).equals((String)hashMap1.get("nk_contact3_mode")) )
									out.print(" selected ");
								out.print(" >"+(String)arrayList6.get(i+1)+ "</option>");
							}
							contact_mode_flag = "yes";
						}
						else contact_mode_flag = "no";
						%></select><% 
						if(!(((String)hashMap1.get("nk_contact3_no")).equals(""))) {
						%><input type='text' name='nk_contact3_no' id='nk_contact3_no' maxlength='20' size='13' value="<%=(String)hashMap1.get("nk_contact3_no")%>" onBlur='makeValidString(this);'>
						<% } else {
					   %><input type='text' name='nk_contact3_no' id='nk_contact3_no' maxlength='20' size='13'  value="" onBlur='makeValidString(this);'>
						<%
						   }

						if(contact_mode_flag.equals("yes"))
						{
							enabledisable = "";
							%>
							<script>
								document.forms[0].nk_contact3_mode.disabled = false;
							</script>						
							<%
						}
						else if(contact_mode_flag.equals("no"))
						{
							enabledisable	= "disabled"; 
							%>
							<script>
								document.forms[0].nk_contact3_mode.disabled = true;
							</script>
							<%
						}
					    %>

						<script>							
							if(document.forms[0].nk_contact3_mode.value=='') 
								document.forms[0].nk_contact3_no.disabled= true;
						</script>
						</td>						
						<td class='label' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<select name='nk_contact4_mode' id='nk_contact4_mode'  <%=enabledisable%> onchange='enableContactNo(this)'>
						<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option><%
						for(int i=0;i<arrayList6.size();i+=2) {
							 out.print("<option value='"+(String)arrayList6.get(i)+"'");
							if ( ((String)arrayList6.get(i)).equals((String)hashMap1.get("nk_contact4_mode")) )
								out.print(" selected ");
							out.print(">"+(String)arrayList6.get(i+1)+ "</option>");
						}
					  %></select><%
						if(!(((String)hashMap1.get("nk_contact4_no")).equals(""))) {
							%><input type='text' name='nk_contact4_no' id='nk_contact4_no' maxlength='20' size='13'  value="<%=(String)hashMap1.get("nk_contact4_no")%>" onBlur='makeValidString(this);'><%
						}else {
						%><input type='text' name='nk_contact4_no' id='nk_contact4_no' maxlength='20' size='13'  value="" onBlur='makeValidString(this);'>
						 <%}%>
						<script>
						if(document.forms[0].nk_contact4_mode.value=='') 
						   document.forms[0].nk_contact4_no.disabled= true; 
					  </script>
					  </td>
					    <td class='label'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    <select name='nk_contact5_mode' id='nk_contact5_mode'  <%=enabledisable%> onchange='enableContactNo(this)'> <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option><%
						for(int i=0;i<arrayList6.size();i+=2) {
								out.print("<option value='"+(String)arrayList6.get(i)+"'");
							if(((String)arrayList6.get(i)).equals((String)hashMap1.get("nk_contact5_mode")))
								out.print(" selected ");
							out.print(">"+(String)arrayList6.get(i+1)+ "</option>");
						}
					  %></select><%
					  if(!(((String)hashMap1.get("nk_contact5_no")).equals(""))) { %><input type='text' name='nk_contact5_no' id='nk_contact5_no' maxlength='20' size='13'  value="<%=(String)hashMap1.get("nk_contact5_no")%>" onBlur='makeValidString(this);'>
					  <% } else { %><input type='text' name='nk_contact5_no' id='nk_contact5_no' maxlength='20' size='13'  value="" onBlur='makeValidString(this);'> 
					   <%}%>
					  <script>
					  if(document.forms[0].nk_contact5_mode.value=='') 
						   document.forms[0].nk_contact5_no.disabled= true; 
					  </script>
					  </td>
						</tr>
                        </table>
				<%} %>	
				<!--Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008-->
</table>
</div>
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
		<!--Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->
        <%if(resiAddMailAdd){%>
        <tr>
				<td class='bodycolorfilled'></td>
				<td valign=top>
					<table cellspacing='1' cellpadding='3' width='100%' border='0'>
							<td  class='label' nowrap><fmt:message key="Common.name.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='first_contact_name' id='first_contact_name' maxlength='80' value="<%=(String)hashMap1.get("fton_contact_name")%>"></td>
				</td>
		 </tr>
		 <tr>
					   <td class='label' nowrap><fmt:message key="Common.relationship.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type='text' name='first_contact_relation_desc' id='first_contact_relation_desc' size='20' maxlength='20' value="<%=(String)hashMap1.get("fton_contact_relation_desc")%>" onblur='if(this.value!=""){searchRelationship(first_contact_relation,first_contact_relation_desc);}else{clearfields();}'   ><input type='button'  id='first_contact_relation_id'  name='first_contact_relation_code_id' id='first_contact_relation_code_id' value='?' class='button' onclick='searchRelationship(this,first_contact_relation_desc)' >
							<input type='hidden' name='first_contact_relation' id='first_contact_relation' value="<%=(String)hashMap1.get("fton_contact_relation")%>"></td>
		 </tr>

		      <% if(accept_national_id_no_yn.equals("Y")) { %>
         <tr>
		      <td  class='label' nowrap><%=(String)hashMap.get("nat_id_prompt")%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='contact2_nat_id_no' id='contact2_nat_id_no' value="<%=(String)hashMap1.get("fton_nat_id_no")%>"  maxlength="<%=disp_nat_id_length%>" size="<%=disp_nat_id_length%>" onblur="<%=nat_on_blurfn_st%>"  onkeypress='<%=nat_id_onKeyPress%>' ></td>  

         </tr>
         <%}else{%><input type='hidden' name='contact2_nat_id_no' id='contact2_nat_id_no' value='' ><%}%>

		 <tr>
                 <%if(Accept_oth_alt_id_yn.equals("Y")){%>
                 <td  class='label' nowrap><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name='notify_oth_alt_id_type' id='notify_oth_alt_id_type' onChange='enableFirstOtherAltIdText(this.value)' >
                 <option value=''>--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</option>
                 <% arrayList.clear();
	             arrayList = eMP.ChangePatientDetails.getResultRows(con,"mp_alternate_id_type",p);
	
                 for(int i=0;i<arrayList.size();i+=2) {
	             out.print("<option value='"+(String)arrayList.get(i)+"'");
		         if(((String)arrayList.get(i)).equals( (String)hashMap1.get("contact2_oth_alt_id_type")) )
			     out.print(" selected ");
	             out.print(" >"+(String)arrayList.get(i+1)+"</option>");
                 } 
                 %> </select>
                 <input type='text' name='notify_oth_alt_id_text' id='notify_oth_alt_id_text' disabled  value="<%=(String)hashMap1.get("fton_alt_id_no")%>" maxlength='20' size='20'  onblur='makeValidString(this);' ></td><%}%>	
		  </tr>
				<tr>
				    <td  class='label' nowrap><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='first_job_title' id='first_job_title' maxlength='30' size='30'  onblur='makeValidString(this);' value= "<%=(String)hashMap1.get("fton_job_title")%>"></td>
				</tr></table>
		<%}
		else
		 {//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008 %>
         <tr>
				<td class='bodycolorfilled' width='15%'>&nbsp;</td>
				<td>
					<table cellspacing='0' cellpadding='2' width='100%' border='0'>
					<tr>
							<td  class='label'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td><td class='fields'><input type='text' name='first_contact_name' id='first_contact_name' maxlength='80' value="<%=(String)hashMap1.get("fton_contact_name")%>"></td>
							<%
							//Below line added for this ML-MMOH-CRF-0860.2 
							if(increasedaddressLength){
							%>
							<td  class='label' ><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text' name='first_off_tel_no' id='first_off_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value = "<%=(String)hashMap1.get("fton_off_tel_no")%>">						
							<%}//End ML-MMOH-CRF-0860.2 
                            %>
							
							</tr>
														
							<tr><td class='label'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td> 
							<td class='fields'><input type='text' name='first_contact_relation_desc' id='first_contact_relation_desc' size='20' maxlength='20' value="<%=(String)hashMap1.get("fton_contact_relation_desc")%>" onblur='if(this.value!=""){searchRelationship(first_contact_relation,first_contact_relation_desc);}else{clearfields();}'   ><input type='button'  id='first_contact_relation_id'  name='first_contact_relation_code_id' id='first_contact_relation_code_id' value='?' class='button' onclick='searchRelationship(this,first_contact_relation_desc)' >
							<input type='hidden' name='first_contact_relation' id='first_contact_relation' value="<%=(String)hashMap1.get("fton_contact_relation")%>"></td>
				<%
					//Below line added for this ML-MMOH-CRF-0860.2 
					if(increasedaddressLength){
						%>
					<td  class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text' name='contact2_email_id' id='contact2_email_id' maxlength='50' size='45'  onblur='makeValidString(this);' value = "<%=(String)hashMap1.get("fton_email_id")%>"></td>							
							<%}//End ML-MMOH-CRF-0860.2 
							%>
						
							</tr> 
<% if(accept_national_id_no_yn.equals("Y")) { %>
<tr><td  class='label'><%=(String)hashMap.get("nat_id_prompt")%></td><td class='fields'><input type='text' name='contact2_nat_id_no' id='contact2_nat_id_no' value="<%=(String)hashMap1.get("fton_nat_id_no")%>"  maxlength="<%=disp_nat_id_length%>" size="<%=disp_nat_id_length%>" onblur="<%=nat_on_blurfn_st%>"  onkeypress='<%=nat_id_onKeyPress%>' ></td>  
 

 <%//Below line added for this CRF ML-MMOH-CRF-0860.2
if(increasedaddressLength){%>
 <td  class='label' colspan=2>
 <%if(!function_id.equals("PAT_REG")){%><a href='javascript:copyDetails(6)'><fmt:message key="eMP.CopyNextofKin.label" bundle="${mp_labels}"/></a><%}%>&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:copyDetails(3)' id='label3'><fmt:message key="eMP.CopyPatientAddress.label" bundle="${mp_labels}"/></a>
 </td>
 <%}//End ML-MMOH-CRF-0860.2
 %>

</tr>
<%}else{%><input type='hidden' name='contact2_nat_id_no' id='contact2_nat_id_no' value='' ><%}%>
<tr>
<%if(Accept_oth_alt_id_yn.equals("Y")){%>
<td  class='label'><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td><td class='fields'><select name='notify_oth_alt_id_type' id='notify_oth_alt_id_type' onChange='enableFirstOtherAltIdText(this.value)' >
<option value=''>--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</option>
<% arrayList.clear();
	arrayList = eMP.ChangePatientDetails.getResultRows(con,"mp_alternate_id_type",p);
	
 for(int i=0;i<arrayList.size();i+=2) {
	out.print("<option value='"+(String)arrayList.get(i)+"'");
		if(((String)arrayList.get(i)).equals( (String)hashMap1.get("contact2_oth_alt_id_type")) )
			out.print(" selected ");
	   out.print(" >"+(String)arrayList.get(i+1)+"</option>");
 } 
 %> </select>
 <input type='text' name='notify_oth_alt_id_text' id='notify_oth_alt_id_text' disabled  value="<%=(String)hashMap1.get("fton_alt_id_no")%>" maxlength='20' size='20'  onblur='makeValidString(this);' ></td><%}%>
 
 <%//Below line added for this CRF ML-MMOH-CRF-0860.2
if(increasedaddressLength){%>
 <td  class='label' colspan=2>
 <%if(accept_national_id_no_yn.equals("N")){
 if(!function_id.equals("PAT_REG")){%><a href='javascript:copyDetails(6)'><fmt:message key="eMP.CopyNextofKin.label" bundle="${mp_labels}"/></a><%}%>&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:copyDetails(3)' id='label3'><fmt:message key="eMP.CopyPatientAddress.label" bundle="${mp_labels}"/></a>
 <%}%>&nbsp;
 </td>
 <%}//End ML-MMOH-CRF-0860.2
 %>
 </tr>
<tr><td  class='label'><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td>
<td class='fields'><input type='text' name='first_job_title' id='first_job_title' maxlength='30' size='30'  onblur='makeValidString(this);' value= "<%=(String)hashMap1.get("fton_job_title")%>">

 <%//Below line added for this CRF ML-MMOH-CRF-0860.2
if(increasedaddressLength){%>
 <td  class='label' colspan=2>
 <%if(Accept_oth_alt_id_yn.equals("N") && accept_national_id_no_yn.equals("N")){
 if(!function_id.equals("PAT_REG")){%><a href='javascript:copyDetails(6)'><fmt:message key="eMP.CopyNextofKin.label" bundle="${mp_labels}"/></a><%}%>&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:copyDetails(3)' id='label3'><fmt:message key="eMP.CopyPatientAddress.label" bundle="${mp_labels}"/></a>
 <%}%>&nbsp;
 </td>
 <%}//End ML-MMOH-CRF-0860.2
 %>


</td>
</tr>
<!--Below added by Suji keerthi for ML-MMOH-CRF-1527 US008-->
		<%}
				if(resiAddMailAdd){%>
				<td width='55%'><table cellspacing='0' cellpadding='3' border='0' width='100%'>
				<tr>
                     <td class='COLUMNHEADER' ></td>
                     <td  class='COLUMNHEADER' ><fmt:message key="eMP.residenceaddress.label" bundle="${mp_labels}"/></td>
                     <td  class='COLUMNHEADER' ><fmt:message key="Common.MailingAddress.label" bundle="${common_labels}"/></td>
                </tr>
                </td>
                <%} %>
				<!--Ended by Suji keerthi for ML-MMOH-CRF-1527 US008-->
<tr>
 <%	StringBuffer sbc1		= new StringBuffer();
    StringBuffer sbc11		= new StringBuffer(); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
	StringBuffer sb1c1		= new StringBuffer();
	StringBuffer sb1c11		= new StringBuffer(); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
	StringBuffer sbar2		= new StringBuffer();
	StringBuffer sbar21		= new StringBuffer(); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
	StringBuffer sbap2		= new StringBuffer();
	StringBuffer sbap21		= new StringBuffer(); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
	StringBuffer fieldValc1	= new StringBuffer();
	StringBuffer fieldValc11	= new StringBuffer(); //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
	
	//Added for this ML-MMOH-CRF-0860.2
	String increasedcolspanLeng="";
	if(increasedaddressLength) increasedcolspanLeng="3";

	for(int i=0;i<contact_col_names.length; i++) { %>
		
		<td class='label' nowrap ><%=contact_prompts[i]%></td>
		<% val = contact_fields[i] ;
		   String val4 = contact_fields[i] ; //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
		 sbc1.append(val) ;
		 sbc11.append(val4) ; //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
		 int j=0 ;
		 int j1=0 ;
		 String old_val = "" ;
		 String new_val = "" ;
		 String new_val2 = ""; //Added by Suji keerthi for ML-MMOH-CRF-1527 US008
		 if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt")) {
			old_val = "r_addr_line1" ;
			new_val = "first_addr_line1" ;
			new_val2 = "fton_mail_addr_line1" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		 }
		 else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt")) {
			old_val = "r_addr_line2" ;
			new_val = "first_addr_line2" ;
			new_val2 = "fton_mail_addr_line2" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		 }
		 else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt")) {
			old_val = "r_addr_line3" ;
			new_val = "first_addr_line3" ;
			new_val2 = "fton_mail_addr_line3" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		 }
		 else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt")) {
			old_val = "r_addr_line4" ;
			new_val = "first_addr_line4" ;
			new_val2 = "fton_mail_addr_line4" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		 }
		 else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
			old_val = "r_town_code" ;
			new_val = "contact2_res_town_code" ;
			new_val2 = "fst_to_no_ma_town_code" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		 }
		 else if(contact_col_names[i].equalsIgnoreCase("region_prompt")) {
			old_val = "r_region_code" ;
			new_val = "contact2_region_code" ;
			new_val2 = "fst_to_no_ma_reg_cod" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		 }
		 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
			old_val = "r_area_code" ;
			new_val = "contact2_res_area_code" ;
			new_val2 = "fst_to_no_ma_area_code" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		 }                                     
		 else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt")) {
			old_val = "r_postal_code" ;
			new_val = "first_postal_code" ;
			new_val2 = "fst_no_ma_pos_cod" ; //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		 }
		while(val.indexOf(old_val) != -1) {
			j = val.indexOf(old_val,j) ;
			sbc1 = sbc1.replace(j,(j+old_val.length()),new_val);
			val = sbc1.toString();

			sbc11 = sbc11.replace(j,(j+old_val.length()),new_val2); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			val4 = sbc11.toString(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		}
		if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
			sbap2.append(val);
			sbap21.append(val4); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			while(val.indexOf("r_postal_code") != -1) {
				j1 = val.indexOf("r_postal_code",j1) ;
				sbap2 = sbap2.replace(j1,(j1+"r_postal_code".length()),"first_postal_code");
				val = sbap2.toString();

				sbap21 = sbap21.replace(j1,(j1+"r_postal_code".length()),"fst_no_ma_pos_cod"); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
				val4 = sbap21.toString(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			}
		}
		if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
			j1 = 0;
			sbar2.append(val);
			sbar21.append(val4); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			while(val.indexOf("r_postal_code") != -1) {
				j1 = val.indexOf("r_postal_code",j1) ;
				sbar2 = sbar2.replace(j1,(j1+"r_postal_code".length()),"first_postal_code");
				val = sbar2.toString();

				sbar21 = sbar21.replace(j1,(j1+"r_postal_code".length()),"fst_no_ma_pos_cod"); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
				val4 = sbar21.toString(); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			}
		}
		sb1c1.append(val);
		fieldValc1.append("");

		for(int z=0;z<val.length();z++) {
			String tempVal = sb1c1.substring(z,z+1);
			if(tempVal.equals("@")) {
				fieldValc1.append("107");
			}
			else{
				fieldValc1.append(tempVal);
			}
		}
		val = fieldValc1.toString();
        //Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		sb1c11.append(val4);
		fieldValc11.append("");

		for(int z=0;z<val4.length();z++) {
			String tempVal = sb1c11.substring(z,z+1);
			if(tempVal.equals("@")) {
				fieldValc11.append("110"); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
			}
			else{
				fieldValc11.append(tempVal);
			}
		}
		val4 = fieldValc11.toString();

		//out.println(val);
		if(resiAddMailAdd){
		out.println("<td class='fields' >"+val+"&nbsp;&nbsp;") ;
		out.println("<td class='fields' >"+val4+"&nbsp;&nbsp;") ;%>
		</td></td>
		<%}else{
		out.println("<td class='fields' colspan='"+increasedcolspanLeng+"'>"+val) ;%>
		</td>
		<%}//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008%>
		</tr><%
		sbc1.setLength(0);
		sbc11.setLength(0); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		sbap2.setLength(0);
		sbap21.setLength(0); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		sbar2.setLength(0);
		sbar21.setLength(0); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		sb1c1.setLength(0);
		sb1c11.setLength(0); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		fieldValc1.setLength(0);
		fieldValc11.setLength(0); //Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
	} %>                
	<tr><td  class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text' name='first_country_desc' id='first_country_desc' size='15' maxlength='15' onblur='if(this.value != "") {searchCountry(contry_code[0],first_country_desc)} else{clearCountryFields(this)}'   value="<%=(String)hashMap1.get("fton_country_name")%>" tabindex='108'><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,first_country_desc)' tabindex='108'>
	<input type='hidden' name='first_country_code' id='first_country_code' value='<%=(String)hashMap1.get("fton_country_code")%>'></td>
	<!--Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->
				<% if(resiAddMailAdd){%>	

					<td class='fields'><input type='text' name='first_mail_country_desc' id='first_mail_country_desc' size='15' maxlength='15' value="<%=(String)hashMap1.get("fton_mail_country_desc")%>" onblur='if(this.value !="") {searchCountry(ma_country_code,first_mail_country_desc);}else{clearCountryFields(this);} ' tabindex='111'><input type='button' name='ma_country_code' id='ma_country_code' value='?' class='button' onclick='searchCountry(this,first_mail_country_desc)' tabindex='111'>
					<input type='hidden' name='first_mail_country_code' id='first_mail_country_code' value='<%=(String)hashMap1.get("fton_m_country_desc")%>'>
					</td>

					</tr>
				<tr>
					<td class='label'  ><fmt:message key="eMP.ContactPerson.label" bundle="${mp_labels}"/></td> 
                    <td class='fields'>
                    <input type='text' name='fton_ra_contact_name' id='fton_ra_contact_name' size='30' maxlength='30'  onblur='makeValidString(this);' value= "<%=(String)hashMap1.get("fton_resadd_contact_name")%>" tabindex='109'>
                    </td>
                    <td class='fields'>
                    <input type='text' name='fton_ma_contact_name' id='fton_ma_contact_name' size='30' maxlength='30'  onblur='makeValidString(this);' value= "<%=(String)hashMap1.get("fton_mailadd_contact_name")%>" tabindex='112'>
                    </td>
				</tr>

				<table border = 0 cellspacing='0' cellpadding='1' width='100%'>
			    <tr><td class='label' width='25%'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    <a href='javascript:copyDetails(13)'><fmt:message key="eMP.CopyNextofKin.label" bundle="${mp_labels}"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href='javascript:copyDetails(11)'><fmt:message key="eMP.CopyPatientAddress.label" bundle="${mp_labels}"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <a href='javascript:copyDetails(12)'><fmt:message key="eMP.CopyResidenceAddress.label" bundle="${mp_labels}"/></a>
			    </td></tr></table></table>
				
				<% } //Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008 %>
                 
				<%//Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008	
				if(!resiAddMailAdd){%>
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
	<td class='fields'><input type='text' name='first_res_tel_no' id='first_res_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value = "<%=(String)hashMap1.get("fton_res_tel_no")%>">	</td>
	<%//Below line added for this CRF ML-MMOH-CRF-0860.2
		if(increasedaddressLength){%>
		<td  class='label'>&nbsp;</td>
		<td  class='filed'>&nbsp;</td>						   
		<%}
		//End ML-MMOh-CRF-0860.2
	%>
	</tr>
	<tr><td  class='label' ><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text' name='contact2_mob_tel_no' id='contact2_mob_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value = "<%=(String)hashMap1.get("fton_mob_tel_no")%>"></td>
	
	<%//Below line added for this CRF ML-MMOH-CRF-0860.2
						if(increasedaddressLength){%>
						<td  class='label'>&nbsp;</td>
						<td  class='filed'>&nbsp;</td>						   
						<%}
						//End ML-MMOh-CRF-0860.2
	%>
	
	
	</tr>
	<%
	//Below line added for ML-MMOH-CRF-0860.2
	 if(!increasedaddressLength){
	%>
	<tr><td  class='label' ><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text' name='first_off_tel_no' id='first_off_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value = "<%=(String)hashMap1.get("fton_off_tel_no")%>"></tr>
	<tr><td  class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text' name='contact2_email_id' id='contact2_email_id' maxlength='50' size='45'  onblur='makeValidString(this);' value = "<%=(String)hashMap1.get("fton_email_id")%>">
	</td></tr>
	<%}
	  //End ML-MMOH-CRF-0860.2
	 //Above line added and below line added for this CRF ML-MMOH-CRF-0860.2
	if(!increasedaddressLength){%>
	<tr>
			<td class='label'></td>
			<td class='label' >
			<%if(!function_id.equals("PAT_REG")){%>
			<a href='javascript:copyDetails(6)'><fmt:message key="eMP.CopyNextofKin.label" bundle="${mp_labels}"/></a>
			<%}%>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href='javascript:copyDetails(3)' id='label3'><fmt:message key="eMP.CopyPatientAddress.label" bundle="${mp_labels}"/></a>
			</td>
		</tr>
       <%}
	   //End this CRF ML-MMOH-CRF-0860.2
				} //Ended for ML-MMOH-CRF-1527 US008
	   %>	
	   <!--Below added by Suji keerthi for ML-MMOH-CRF-1527 US008-->
			<%if(resiAddMailAdd){%>
			<table width="100%"><tr>
				<td  class='COLUMNHEADER' colspan='7' ><fmt:message key="eMP.ContactModes.label" bundle="${mp_labels}"/></td>
                </tr>
				<tr>
				    <td  class='label' nowrap ><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type='text' name='first_res_tel_no' id='first_res_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);return isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);' value = "<%=(String)hashMap1.get("fton_res_tel_no")%>" ></td>
				    
						
				    <td  class='label' nowrap ><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type='text' name='contact2_mob_tel_no' id='contact2_mob_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);return isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);' value = "<%=(String)hashMap1.get("fton_mob_tel_no")%>" ></td>
				    

				    <td  class='label' nowrap ><fmt:message key="Common.email.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type='text' name='contact2_email_id' id='contact2_email_id' maxlength='50' size='45'  onblur='makeValidString(this);' value = "<%=(String)hashMap1.get("fton_email_id")%>" ></td>
                    
                </tr>
				<%String enabledisable		= "";
					String contact_mode_flag	= "";%>
					<tr>
						<td class='label' ><fmt:message key="eMP.othermodes.label" bundle="${mp_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    <select name='fton_contact3_mode' id='fton_contact3_mode' <%=enabledisable%> onchange='enableContactNo(this)'>
					   <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option><%
						arrayList6 = eMP.ChangePatientDetails.getResultRows(con,"mp_contact_mode2",p);
						if(arrayList6.size() > 0) {
							for(int i=0;i<arrayList6.size();i+=2) {
								 out.print("<option value=\""+(String)arrayList6.get(i)+"\"");
								if ( ((String)arrayList6.get(i)).equals((String)hashMap1.get("fton_contact3_mode")) )
									out.print(" selected ");
								out.print(" >"+(String)arrayList6.get(i+1)+ "</option>");
							}
							contact_mode_flag = "yes";
						}
						else contact_mode_flag = "no";
						%></select><% 
						if(!(((String)hashMap1.get("fton_contact3_no")).equals(""))) {
						%><input type='text' name='fton_contact3_no' id='fton_contact3_no' maxlength='20' size='13' value="<%=(String)hashMap1.get("fton_contact3_no")%>" onBlur='makeValidString(this);'>
						<% } else {
					   %><input type='text' name='fton_contact3_no' id='fton_contact3_no' maxlength='20' size='13'  value="" onBlur='makeValidString(this);'>
						<%
						   }

						if(contact_mode_flag.equals("yes"))
						{
							enabledisable = "";
							%>
							<script>
								document.forms[0].fton_contact3_mode.disabled = false;
							</script>						
							<%
						}
						else if(contact_mode_flag.equals("no"))
						{
							enabledisable	= "disabled"; 
							%>
							<script>
								document.forms[0].fton_contact3_mode.disabled = true;
							</script>
							<%
						}
					    %>

						<script>							
							if(document.forms[0].fton_contact3_mode.value=='') 
								document.forms[0].fton_contact3_no.disabled= true;
						</script>
						</td>						
						<td class='label' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<select name='fton_contact4_mode' id='fton_contact4_mode'  <%=enabledisable%> onchange='enableContactNo(this)'>
						<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option><%
						for(int i=0;i<arrayList6.size();i+=2) {
							 out.print("<option value='"+(String)arrayList6.get(i)+"'");
							if ( ((String)arrayList6.get(i)).equals((String)hashMap1.get("fton_contact4_mode")) )
								out.print(" selected ");
							out.print(">"+(String)arrayList6.get(i+1)+ "</option>");
						}
					  %></select><%
						if(!(((String)hashMap1.get("fton_contact4_no")).equals(""))) {
							%><input type='text' name='fton_contact4_no' id='fton_contact4_no' maxlength='20' size='13'  value="<%=(String)hashMap1.get("fton_contact4_no")%>" onBlur='makeValidString(this);'><%
						}else {
						%><input type='text' name='fton_contact4_no' id='fton_contact4_no' maxlength='20' size='13'  value="" onBlur='makeValidString(this);'>
						 <%}%>
						<script>
						if(document.forms[0].fton_contact4_mode.value=='') 
						   document.forms[0].fton_contact4_no.disabled= true; 
					  </script>
					  </td>
					    <td class='label'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    <select name='fton_contact5_mode' id='fton_contact5_mode'  <%=enabledisable%> onchange='enableContactNo(this)'> <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option><%
						for(int i=0;i<arrayList6.size();i+=2) {
								out.print("<option value='"+(String)arrayList6.get(i)+"'");
							if(((String)arrayList6.get(i)).equals((String)hashMap1.get("fton_contact5_mode")))
								out.print(" selected ");
							out.print(">"+(String)arrayList6.get(i+1)+ "</option>");
						}
					  %></select><%
					  if(!(((String)hashMap1.get("fton_contact5_no")).equals(""))) { %><input type='text' name='fton_contact5_no' id='fton_contact5_no' maxlength='20' size='13'  value="<%=(String)hashMap1.get("fton_contact5_no")%>" onBlur='makeValidString(this);'>
					  <% } else { %><input type='text' name='fton_contact5_no' id='fton_contact5_no' maxlength='20' size='13'  value="" onBlur='makeValidString(this);'> 
					   <%}%>
					  <script>
					  if(document.forms[0].fton_contact5_mode.value=='') 
						   document.forms[0].fton_contact5_no.disabled= true; 
					  </script>
					  </td>
						</tr></table>
			<%}%>
	</table>
		<td class='bodycolorfilled' width='15%'>&nbsp;</td>
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
		<td align='center' class='COLUMNHEADER' ><fmt:message key="Common.employeedetails.label" bundle="${common_labels}"/></td></tr><tr>
		<td>
			<table cellspacing='0' cellpadding='2' width='100%' border=0>
			<!--Below line modified for this CRF ML-MMOH-CRF-0860 increase the maxlength 30 to 50-->
			<tr>
				<td class='label' ><fmt:message key="Common.orgName.label" bundle="${common_labels}"/></td>
                <td class='fields'><input type='text' name='organization_name' id='organization_name' maxlength='<%=maximumLength%>' size='<%=maxsize%>'  onblur='makeValidString(this);' value="<%=(String)hashMap1.get("organization_name")%>"></input>
                </td>
			</tr>
			<tr>
				<td class='label' ><fmt:message key="eMP.ContactPersonName.label" bundle="${mp_labels}"/></td>
                <td class='fields'><input type='text' name='empyr_contact_name' id='empyr_contact_name' maxlength='30' size='30'  onblur='makeValidString(this);' value="<%=(String)hashMap1.get("emplr_contact_name")%>"></input></td>
			</tr>
			<tr>
				<% 
					StringBuffer sbcp = new StringBuffer() ;
					StringBuffer  sb1cp = new StringBuffer() ;
					StringBuffer  sbar3 = new StringBuffer() ;
					StringBuffer  sbap3 = new StringBuffer() ;
					StringBuffer fieldValcp = new StringBuffer();
					for(int i=0;i<contact_col_names.length; i++) {
					out.println("<td class='label'  >"+contact_prompts[i]+"</td>");
					 val = contact_fields[i] ;
					sbcp.append(val);
					int j=0 ;
					int j1=0 ;
					String old_val = "" ;
					String new_val = "" ;
					if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt")) {
						old_val = "r_addr_line1" ;
						new_val = "employ_addr_line1" ;
					}
					else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt")) {
						old_val = "r_addr_line2" ;
						new_val = "employ_addr_line2" ;
					}
					else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt")) {
						old_val = "r_addr_line3" ;
						new_val = "employ_addr_line3" ;
					}
					else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt")) {
						old_val = "r_addr_line4" ;
						new_val = "employ_addr_line4" ;
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
						old_val = "r_town_code" ;
						new_val = "contact3_res_town_code" ;
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("region_prompt")) {
						old_val = "r_region_code" ;
						new_val = "contact3_region_code" ;
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
						old_val = "r_area_code" ;
						new_val = "contact3_res_area_code" ;
					 }                                     
					 else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt")) {
						old_val = "r_postal_code" ;
						new_val = "employ_postal_code" ;
					 }
					while(val.indexOf(old_val) != -1) {
						j = val.indexOf(old_val,j) ;
						sbcp = sbcp.replace(j,(j+old_val.length()),new_val);
						val = sbcp.toString();
					}
					if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
						sbap3.append(val);
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sbap3 = sbap3.replace(j1,(j1+"r_postal_code".length()),"employ_postal_code");
							val = sbap3.toString();
						}
					}
					if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
						j1 = 0;
						sbar3.append(val);
						while(val.indexOf("r_postal_code") != -1) {
							j1 = val.indexOf("r_postal_code",j1) ;
							sbar3 = sbar3.replace(j1,(j1+"r_postal_code".length()),"employ_postal_code");
							val = sbar3.toString();
						}
					}
					sb1cp.append(val);
					fieldValcp.append("");
					for(int z=0;z<val.length();z++) {
						String tempVal=sb1cp.substring(z,z+1);
						if(tempVal.equals("@")) {
							fieldValcp.append("119");
						}
						else fieldValcp.append(tempVal);
					}
					val = fieldValcp.toString(); %>
					<td class='fields'><%=val%></td></tr>
					<%
						sbcp.setLength(0);
						sb1cp.setLength(0);
						sbap3.setLength(0);
						sbar3.setLength(0);
						fieldValcp.setLength(0);
					} %>              
					<tr><td  class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/> </td>
                    <td class='fields'><input type='text' name='empyr_country_desc' id='empyr_country_desc' size='15' maxlength='15' onblur='if(this.value !="") { searchCountry(contry_code[0],empyr_country_desc)} else{clearCountryFields(this)}'  value="<%=(String)hashMap1.get("emplr_country_name")%>" ><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,empyr_country_desc)' >
					<input type='hidden' name='empyr_country_code' id='empyr_country_code' value='<%=(String)hashMap1.get("emplr_country_code")%>'>
					</td></tr><tr><td  class='label'><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type='text' name='res3_tel_no' id='res3_tel_no' size='20' maxlength='20'  onblur='makeValidString(this);'
					value = "<%=(String)hashMap1.get("emplr_res_tel_no")%>">
                   </td></tr><tr>
					<td  class='label'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
                   <td class='fields'><input type='text' name='empyr_off_tel_no' id='empyr_off_tel_no' size='20' maxlength='20'  onblur='makeValidString(this);' value = "<%=(String)hashMap1.get("emplr_off_tel_no")%>">
                   </td></tr></table></td>
					<td valign=top><table cellspacing='1' cellpadding='0' width='100%' border='0'>
					<tr><td class='label' ><fmt:message key="Common.employmentid.label" bundle="${common_labels}"/></td>
                    <td class='fields'><input type='text' name='empyr_eid' id='empyr_eid' maxlength='20' size='20'  onfocus="" onblur='makeValidString(this);assignEmpValue();' value = "<%=(String)hashMap1.get("patient_employee_id")%>"></input><input type='hidden' name='patient_employee_id' id='patient_employee_id' value = "<%=(String)hashMap1.get("patient_employee_id")%>">
                    </td></tr>
					<%if ( !((String)hashMap1.get("alt_id1_no")).equals("") && dflt_alt_id1_in_emp_id_yn.equals("Y")) { %> 
						<SCRIPT>document.forms[0].empyr_eid.value = '<%=(String)hashMap1.get("alt_id1_no")%>';
						document.forms[0].empyr_eid.readOnly = true;</script>
					<%}%>
					<tr>
					<td class='label'  ><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/></td>
					

					<td  class='fields'> <input type='text' name='occ_class_desc' id='occ_class_desc' size='20' maxlength='20' value="<%=(String)hashMap1.get("emplr_ocpn_class_desc")%>" onblur='if(this.value!=""){searchOccupationClass(occ_class,occ_class_desc);sendToServer(15,occ_class);}else{clearfields();clearOccPer(document.forms[0].occ_of_per);} enableocpn_class();'   ><input type='button'  id='occ_class_id'  name='occ_class_code_id2' id='occ_class_code_id2' value='?' class='button' onclick='searchOccupationClass(this,occ_class_desc);if(document.forms[0].occ_class.value!=""){sendToServer(15,occ_class);}' >
					<input type='hidden' name='occ_class' id='occ_class' value="<%=(String)hashMap1.get("ocpn_class_code")%>"> </td>
					
					
					</tr>
					<tr><td class='label'  ><fmt:message key="eMP.OccupationofthePerson.label" bundle="${mp_labels}"/></td><td class='fields'>
					<select name='occ_of_per' id='occ_of_per'  onChange='enableocpn();'>
						<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>

<% String sql = "select ocpn_code,short_desc from mp_occupation_lang_vw where language_id='"+locale+"' and ocpn_class_code = '"+(String)hashMap1.get("ocpn_class_code")+"' and eff_status='E' order by 2";
		
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next())
			   {
			ocpn_code=rs.getString("ocpn_code");
		
		out.println("<option value="+ocpn_code);
		if(((String)hashMap1.get("ocpn_code")).equals(ocpn_code)){
		out.println("selected>");
		} else { 
		out.println(">");
		}
		out.println(rs.getString("short_desc")+"</option>"); 

		}%>

		<%
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();	
		%>
                  <%-- if(!(((String)hashMap1.get("ocpn_code")).equals(""))) { --%>
							<!-- <option value="<%=(String)hashMap1.get("ocpn_code")%>" selected><%=(String)hashMap1.get("occupation_desc")%>  -->
					<%-- } --%> </select>
					
					 <!--Below line added for this CRF ML-MMOH-CRF-0860 increase the maxLength from 30 to 50-->
					  <input type='text' name='occu_of_per_desc' id='occu_of_per_desc' size='<%=maxsize%>' maxlength='<%=maximumLength%>' onblur=''  onblur='makeValidString(this);' value =   "<%=(String)hashMap1.get("ocpn_desc")%>" ></input>
                    </td></tr>
					<tr><td class='label'  ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
                    <td class='fields'><select name='empyr_employment_status' id='empyr_employment_status'  onblur='document.forms[0].organization_name.focus();' onchange=''>
                            <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
                            <option value='FE'><fmt:message key="eMP.FullTimeEmployed.label" bundle="${mp_labels}"/></option>
							<option value='FS'><fmt:message key="eMP.FullTimeStudent.label" bundle="${mp_labels}"/></option>
							<option value='NA'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>				
							<option value='PE'><fmt:message key="eMP.PartTimeEmployed.label" bundle="${mp_labels}"/></option>
							<option value='PS'><fmt:message key="eMP.PartTimeStudent.label" bundle="${mp_labels}"/></option>
							<option value='SE'><fmt:message key="eMP.SelfEmployed.label" bundle="${mp_labels}"/></option>
							<option value='UE'><fmt:message key="eMP.Unemployed.label" bundle="${mp_labels}"/></option>
							<option value='UK'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
					<% if(!(((String)hashMap1.get("employment_status")).equals(""))) {					out.println("<script>document.forms[0].empyr_employment_status.value='"+ (String)hashMap1.get("employment_status")+"';</script>");  
					}
					%>
                 </select></td></tr>
           <%  
		   for(int i=0; i<custcount;i++) {
				if(cust_fields[i].charAt(0) == 'E') {
					
					int intind_0	= cust_fields[i].indexOf('`');
					String strcf	= cust_fields[i];		
					String strs1	= strcf.substring(intind_0+1, strcf.length());
										
					int intind_1	= strs1.indexOf('`');
					String lab		= strs1.substring(0, intind_1);
					String strs2		= strs1.substring(intind_1+1, strs1.length());
					int intind_2	= strs2.indexOf('`');
					String size		= strs2.substring(0, intind_2);
					
					String strs3	= strs2.substring(intind_2+1, strs2.length());
					int intind_3	= strs3.indexOf('`');
					String nme		= strs3.substring(0, intind_3);
						
					String strs4	= strs3.substring(intind_3+1, strs3.length());
					 val 		= checkForNull(strs4.substring(0));
					%>
					<tr><td class='label'   width=''><%=lab%></td>
					<td class='fields'><input type='text' name='<%=nme%>' id='<%=nme%>' maxlength='<%=size%>' size='<%=size%>' value="<%=val%>"  onblur='makeValidString(this);' value=""> </td></tr>
			<%	}
			} %> </table></table>	    
	 </div>
	<!-- <a name='pat_docs_tab'></a> -->
	<div id = 'pat_docs_tab' style = 'display:none'>
	<!-- <table width='100%' cellpadding='2' cellspacing='0' border='0'>
	<tr><td  class='COLUMNHEADER' width='20%'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td><td  class='COLUMNHEADER' width='20%'> <fmt:message key="Common.documentno.label" bundle="${common_labels}"/></td><td  class='COLUMNHEADER' width='20%' ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADER' width='25%'><fmt:message key="eMP.PlaceOfIssue.label" bundle="${mp_labels}"/></td>
	<td  class='COLUMNHEADER' width='15%'><fmt:message key="Common.IssueDate.label" bundle="${common_labels}"/></td></tr> -->
	<%
		String general_remarks	= (String)hashMap1.get("gremarks") == null ? "" : (String)hashMap1.get("gremarks");
	%>

	<jsp:include page="../../eMP/jsp/ChangePatientDtlsDocMisc.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name="patient_id"				  value="<%=patient_id%>"/>
		<jsp:param name="cnt"						  value="<%=Othersaddlcnt%>"/>
		<jsp:param name="dependency"			  value="<%=(String)hashMap1.get(\"living_dependency\")%>"/>
		<jsp:param name="arrangement"			  value="<%=(String)hashMap1.get(\"arrangement\")%>"/>
		<jsp:param name="education_level"       value="<%=(String)hashMap1.get(\"elevel\")%>"/>
		<jsp:param name="educ_level_desc"       value="<%=(String)hashMap1.get(\"educ_level_desc\")%>"/>
		<jsp:param name="informant"				  value="<%=(String)hashMap1.get(\"informant\")%>"/>
		<jsp:param name="comments"			  value="<%=(String)hashMap1.get(\"comments\")%>"/>
		<jsp:param name="general_remarks"      value="<%=general_remarks%>"/>
	</jsp:include>

	<table border='0' cellspacing='0' cellpadding='0' align="center" width='100%'>
       	<tr></tr><tr></tr><tr></tr><tr></tr>
		<% for(int i=0; i<custcount;i++) {
				if(cust_fields[i].charAt(0) == 'O') {		                             
					int intind_0	= cust_fields[i].indexOf('`');
					String strcf	= cust_fields[i];		
					String strs1	= strcf.substring(intind_0+1, strcf.length());
										
					int intind_1	= strs1.indexOf('`');
					String lab		= strs1.substring(0, intind_1);
					String strs2		= strs1.substring(intind_1+1, strs1.length());
					int intind_2	= strs2.indexOf('`');
					String size		= strs2.substring(0, intind_2);
					
					String strs3	= strs2.substring(intind_2+1, strs2.length());
					int intind_3	= strs3.indexOf('`');
					String nme		= strs3.substring(0, intind_3);
						
					String strs4	= strs3.substring(intind_3+1, strs3.length());
					 val 		= checkForNull(strs4.substring(0));
					%>
					<td class='label'   width='15%' ><%=lab%></td>
					<td class='fields'><input type='text' name='<%=nme%>' id='<%=nme%>' value="<%=val%>" maxlength='<%=size%>' size='20'  onblur='makeValidString(this);'   value =""></td>
			<%	} 
			} %> 
			</table> 
			</div>

<%
		if(function_id.equals("NEWBORN_REG")) {        
		hashMap3 = eMP.ChangePatientDetails.getNBParentDtls(patient_id, con,p);
		
        if( ((String)hashMap3.get("flag")).equals("yes"))
        {
            mother_patient_id   = (String)hashMap3.get("mother_patient_id");
%>


<a name='ancParent_det'> 
<table cellspacing='0' cellpadding='0' width='90%' align='center' border='1' height='50%' >
    <tr><td class='COLUMNHEADER'></td><td class='COLUMNHEADER' ><fmt:message key="eMP.fatherdetails.label" bundle="${mp_labels}"/></td>
    <td class='COLUMNHEADER' ><fmt:message key="eMP.motherdetails.label" bundle="${mp_labels}"/></td></tr>
    <tr><td class='label' ><B><fmt:message key="Common.patientId.label" bundle="${common_labels}"/><B></td>
    <td class='label'><b><%=(String)hashMap3.get("father_patient_id")%></td>
    <td class='label' height='15%' ><b><%=mother_patient_id%> </b></td></tr>
    <tr><td class='label'  ><b><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
    <td class='label'><b><%=(String)hashMap3.get("father_patient_name")%></td>
    <td class='label'><b><%=(String)hashMap3.get("mother_patient_name")%></td>
    </tr><tr><td class='label' > <b><%=(String)hashMap.get("alt_id1_desc")%></td>
    <td class='label'><b><%=(String)hashMap3.get("father_alt_id1_no")%></td>
    <td class='label'><b><%=(String)hashMap3.get("mother_alt_id1_no")%></td>
    </tr><tr><td class='label' ><b><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
    <td class='label'><b><%=(String)hashMap3.get("fath_citizenship")%></td>
    <td class='label'><b><%=(String)hashMap3.get("moth_citizenship")%></td>
    </tr></table> 
<%	} 
}
%> 
<!-- <a name='add_mod_dtl'> -->
<div id = 'add_mod_dtl' style = 'display:none'>
<table cellspacing=0 cellpadding=0 width='90%' align='center' border='1' height='50%' >
    <tr><td class='COLUMNHEADER'>&nbsp;</td><td  class='COLUMNHEADER' ><fmt:message key="eMP.AddedDetails.label" bundle="${mp_labels}"/></td><td class='COLUMNHEADER' ><fmt:message key="eMP.latestmodifieddetails.label" bundle="${mp_labels}"/></td></tr>
    <tr><td class='QUERYDATA'>&nbsp;<fmt:message key="Common.username.label" bundle="${common_labels}"/></td>
    <td class='QUERYDATA'><%=(String)hashMap1.get("added_user_name")%> </td>
    <td class='QUERYDATA'><%=(String)hashMap1.get("modified_user_name")%></td></tr>
	<tr><td class='QUERYDATA' >&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
	<%
	added_date=(String)hashMap1.get("added_date");
	modified_date=(String)hashMap1.get("modified_date");
	added_date= DateUtils.convertDate(added_date,"DMYHM","en",locale);
	modified_date= DateUtils.convertDate(modified_date,"DMYHM","en",locale);
	%>
    <td class='QUERYDATA'><%=added_date%></td>
    <td class='QUERYDATA'><%=modified_date%></td></tr>   
    <tr><td class='QUERYDATA' >&nbsp;<fmt:message key="Common.workstation.label" bundle="${common_labels}"/></td>
    <td class='QUERYDATA'> <%=(String)hashMap1.get("added_at_ws_no")%></td>
    <td class='QUERYDATA'> <%=(String)hashMap1.get("modified_at_ws_no")%></td></tr>  
    <tr><td class='QUERYDATA' >&nbsp;<fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
    <td class='QUERYDATA'><%=(String)hashMap1.get("added_facility_name")%></td>
    <td class='QUERYDATA'><%=(String)hashMap1.get("modified_facility_name")%></td></tr>
	<tr><td class='QUERYDATA' >&nbsp;<fmt:message key="eMP.RegistrationSource.label" bundle="${mp_labels}"/></td><td class='QUERYDATA'>
	<% if(((String)hashMap1.get("data_source")).equals("")) {%><fmt:message key="eMP.manual.label" bundle="${mp_labels}"/></td><%} else {%><fmt:message key="eMP.repository.label" bundle="${mp_labels}"/></td><%}%>
	<td class='QUERYDATA'>&nbsp;</td></tr></table>
	<input type='hidden' name='dflt_nationality_code' id='dflt_nationality_code' value="<%=(String)hashMap2.get("def_nat_cd")%>"></input>
	<input type='hidden' name='dflt_nationality_desc' id='dflt_nationality_desc' value="<%=checkForNull((String)hashMap2.get("def_nat_desc"))%>"></input>
	<input type='hidden' name='default_race_code' id='default_race_code' value='<%=(String)hashMap.get("default_race_code")%>'></input>
	<input type='hidden' name='dflt_pref_facility_id' id='dflt_pref_facility_id' value='<%=(String)hashMap1.get("alt_id2_type")%>'></input>
	<input type='hidden' name='ServerDate' id='ServerDate' value="<%=(String)hashMap.get("ServerDate")%>"></input> 
	<input type='hidden' name='patient_name' id='patient_name' value='<%=(String)hashMap.get("Alt_Id2_Reqd_Yn")%>'></input>
	<input type='hidden' name='pat_name' id='pat_name' value="<%=(String)hashMap1.get("patient_name")%>"></input>
	<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>"></input>
	<input type='hidden' name='datasource_id' id='datasource_id' value="<%=(String)hashMap1.get("data_source")%>"></input>
	<input type='hidden' name='change_data_source' id='change_data_source' value=''><input type='hidden' name='blood_grp' id='blood_grp' value=""><input type='hidden' name='rh_factor' id='rh_factor' value=""><input type='hidden' name='error_alt_no1' id='error_alt_no1' value=""><input type='hidden' name='error_alt_no2' id='error_alt_no2' value=""><input type='hidden' name='error_alt_no3' id='error_alt_no3' value=""><input type='hidden' name='error_alt_no4' id='error_alt_no4' value=""> 
	<input type='hidden' name='Alt_Id2_Unique_Yn2' id='Alt_Id2_Unique_Yn2' value="">
	<input type='hidden' name='m_town' id='m_town' value=""><input type='hidden' name='r_town' id='r_town' value="">
	<input type='hidden' name='r_postal_code' id='r_postal_code' value=''>
	<input type='hidden' name='m_postal_code' id='m_postal_code' value=''>
	<input type='hidden' name='next_postal_code' id='next_postal_code' value=''>
	<input type='hidden' name='first_postal_code' id='first_postal_code' value=''>
	<input type='hidden' name='employ_postal_code' id='employ_postal_code' value=''>
	<input type='hidden' name='n_town' id='n_town' value=""><input type='hidden' name='f_town' id='f_town' value="">
	<input type='hidden' name='e_town' id='e_town' value=""><input type='hidden' name='r_area' id='r_area' value="">
	<input type='hidden' name='m_area' id='m_area' value=""><input type='hidden' name='n_area' id='n_area' value="">
	<input type='hidden' name='f_area' id='f_area' value=""><input type='hidden' name='e_area' id='e_area' value="">
	<input type='hidden' name='r_region' id='r_region' value=""><input type='hidden' name='m_region' id='m_region' value="">
	<input type='hidden' name='n_region' id='n_region' value=""><input type='hidden' name='f_region' id='f_region' value="">
	<input type='hidden' name='e_region' id='e_region' value=""><input type='hidden' name='first_time_only' id='first_time_only' value='Y'>
	<!--Below line added for this CRF ML-MMOH-CRF-0860.2-->
	<input type='hidden' name='a_area' id='a_area' value="">
	<input type='hidden' name='a_region' id='a_region' value="">
	<input type='hidden' name='a_town' id='a_town' value="">
	<input type='hidden' name='alt_postal_code' id='alt_postal_code' value=''>

    <!--Added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->
	<input type='hidden' name='nkma_town' id='nkma_town' value=''>
	<input type='hidden' name='contact1_region' id='contact1_region' value=''>
	<input type='hidden' name='nkma_area' id='nkma_area' value=''>		
	<input type='hidden' name='n_ma_postal_code' id='n_ma_postal_code' value=''>

	<input type='hidden' name='contact2_res_town' id='contact2_res_town' value=''>
	<input type='hidden' name='contact2_region' id='contact2_region' value=''>
	<input type='hidden' name='contact2_res_area' id='contact2_res_area' value=''>		
	<input type='hidden' name='fst_no_ma_pos_cod' id='fst_no_ma_pos_cod' value=''>
	<!--Added by Suji Keerthi for ML-MMOH-CRF-1527 US008-->

	<!--End this ML-MMOH-CRF-0860.2 -->
	<script language='javascript'>
	
    setTimeout('aa()',500);
	
	/*Below line added for this ML-MMOH-CRF-0601*/
	if("<%=alterAddressApplicable%>" =="true"){
	  	  
	 if("<%=(String)hashMap1.get("alt_addr_line1")%>" != '' && document.getElementById('a_addr_line1') != null)
		document.getElementById('a_addr_line1').value="<%=(String)hashMap1.get("alt_addr_line1")%>"
	 if("<%=(String)hashMap1.get("alt_addr_line2")%>" != '' && document.getElementById('a_addr_line2') != null)
		document.getElementById('a_addr_line2').value="<%=(String)hashMap1.get("alt_addr_line2")%>"
     if("<%=(String)hashMap1.get("alt_addr_line3")%>" != '' && document.getElementById('a_addr_line3') != null)
		document.getElementById('a_addr_line3').value="<%=(String)hashMap1.get("alt_addr_line3")%>"
     if("<%=(String)hashMap1.get("alt_addr_line4")%>" != '' && document.getElementById('a_addr_line4') != null)
		document.getElementById('a_addr_line4').value="<%=(String)hashMap1.get("alt_addr_line4")%>"
     if("<%=(String)hashMap1.get("alt_postal_code")%>" != '' && document.getElementById('alt_postal_code1') != null){
	   	document.getElementById("alt_postal_code").value="<%=(String)hashMap1.get("alt_postal_code")%>"
	    document.getElementById('alt_postal_code1').value="<%=(String)hashMap1.get("alt_postal_code_desc")%>"
	} 	
    if("<%=(String)hashMap1.get("alt_town_code_desc")%>" != '' && document.getElementById('a_town_code') != null)
		document.getElementById('a_town_code').value="<%=(String)hashMap1.get("alt_town_code_desc")%>"
	if("<%=(String)hashMap1.get("alt_town_code")%>" != '')
		document.getElementById('a_town').value="<%=(String)hashMap1.get("alt_town_code")%>"
	if("<%=(String)hashMap1.get("alt_area_code_desc")%>" != '' && document.getElementById('a_area_code') != null)
		document.getElementById('a_area_code').value="<%=(String)hashMap1.get("alt_area_code_desc")%>"
	if("<%=(String)hashMap1.get("alt_area_code")%>" != '')
		document.getElementById('a_area').value="<%=(String)hashMap1.get("alt_area_code")%>"
	if("<%=(String)hashMap1.get("alt_region_code_desc")%>" != '' && document.getElementById('a_region_code') != null)
		document.getElementById('a_region_code').value="<%=(String)hashMap1.get("alt_region_code_desc")%>"
	if("<%=(String)hashMap1.get("alt_region_code")%>" != '')
		document.getElementById('a_region').value="<%=(String)hashMap1.get("alt_region_code")%>"	
	if("<%=(String)hashMap1.get("alt_country_name")%>" != '' && document.getElementById('a_country_code') != null)
		document.getElementById('a_country_desc').value="<%=(String)hashMap1.get("alt_country_name")%>"
	if("<%=(String)hashMap1.get("alt_country_code")%>" != ''  && document.getElementById('a_country_code') != null )
		document.getElementById('a_country_code').value="<%=(String)hashMap1.get("alt_country_code")%>"	
	}	
	
	//End ML-MMOH-CRF-0601
	
    if("<%=(String)hashMap1.get("data_source")%>" == '') document.getElementById('first_time_only').value = 'N'
    if("<%=(String)hashMap1.get("resi_addr_line1")%>" != '' && document.getElementById('r_addr_line1') != null)
		document.getElementById('r_addr_line1').value="<%=(String)hashMap1.get("resi_addr_line1")%>"
	if("<%=(String)hashMap1.get("mail_addr_line1")%>" != '' && document.getElementById('m_addr_line1') != null)
		document.getElementById('m_addr_line1').value="<%=(String)hashMap1.get("mail_addr_line1")%>"
	if("<%=(String)hashMap1.get("resi_addr_line2")%>" != '' && document.getElementById('r_addr_line2') != null)
		document.getElementById('r_addr_line2').value="<%=(String)hashMap1.get("resi_addr_line2")%>"
	if("<%=(String)hashMap1.get("mail_addr_line2")%>" != '' && document.getElementById('m_addr_line2') != null)
		document.getElementById('m_addr_line2').value="<%=(String)hashMap1.get("mail_addr_line2")%>"
	if("<%=(String)hashMap1.get("resi_addr_line3")%>" != '' && document.getElementById('r_addr_line3') != null)
		document.getElementById('r_addr_line3').value="<%=(String)hashMap1.get("resi_addr_line3")%>"
	if("<%=(String)hashMap1.get("mail_addr_line3")%>" != '' && document.getElementById('m_addr_line3') != null)
		document.getElementById('m_addr_line3').value="<%=(String)hashMap1.get("mail_addr_line3")%>"
	if("<%=(String)hashMap1.get("resi_addr_line4")%>" != '' && document.getElementById('r_addr_line4') != null)
		document.getElementById('r_addr_line4').value="<%=(String)hashMap1.get("resi_addr_line4")%>"
	if("<%=(String)hashMap1.get("mail_addr_line4")%>" != '' && document.getElementById('m_addr_line4') != null)
		document.getElementById('m_addr_line4').value="<%=(String)hashMap1.get("mail_addr_line4")%>"
	if("<%=(String)hashMap1.get("resi_postal_code")%>" != '' && document.getElementById('r_postal_code1') != null){
		document.getElementById('r_postal_code').value="<%=(String)hashMap1.get("resi_postal_code")%>"
	document.getElementById('r_postal_code1').value="<%=(String)hashMap1.get("resi_postal_code_desc")%>"
	}
	if("<%=(String)hashMap1.get("mail_postal_code")%>" != '' && document.getElementById('m_postal_code1') != null)
			   {
		document.getElementById('m_postal_code').value="<%=(String)hashMap1.get("mail_postal_code")%>"
		document.getElementById('m_postal_code1').value="<%=(String)hashMap1.get("mail_postal_code_desc")%>"
			   }
	if("<%=(String)hashMap1.get("nkin_addr_line1")%>" != '' && document.getElementById('next_addr_line1') != null)
		document.getElementById('next_addr_line1').value="<%=(String)hashMap1.get("nkin_addr_line1")%>"
	if("<%=(String)hashMap1.get("fton_addr_line1")%>" != '' && document.getElementById('first_addr_line1') != null)
		document.getElementById('first_addr_line1').value="<%=(String)hashMap1.get("fton_addr_line1")%>"
	if("<%=(String)hashMap1.get("nkin_addr_line2")%>" != '' && document.getElementById('next_addr_line2') != null)
		document.getElementById('next_addr_line2').value="<%=(String)hashMap1.get("nkin_addr_line2")%>"
	if("<%=(String)hashMap1.get("fton_addr_line2")%>" != '' && document.getElementById('first_addr_line2') != null)
		document.getElementById('first_addr_line2').value="<%=(String)hashMap1.get("fton_addr_line2")%>"
	if("<%=(String)hashMap1.get("nkin_addr_line3")%>" != '' && document.getElementById('next_addr_line3') != null)
		document.getElementById('next_addr_line3').value="<%=(String)hashMap1.get("nkin_addr_line3")%>"
	if("<%=(String)hashMap1.get("fton_addr_line3")%>" != '' && document.getElementById('first_addr_line3') != null)
		document.getElementById('first_addr_line3').value="<%=(String)hashMap1.get("fton_addr_line3")%>"
	if("<%=(String)hashMap1.get("nkin_addr_line4")%>" != '' && document.getElementById('next_addr_line4') != null)
		document.getElementById('next_addr_line4').value="<%=(String)hashMap1.get("nkin_addr_line4")%>"
	if("<%=(String)hashMap1.get("fton_addr_line4")%>" != '' && document.getElementById('first_addr_line4') != null)
		document.getElementById('first_addr_line4').value="<%=(String)hashMap1.get("fton_addr_line4")%>"
	if("<%=(String)hashMap1.get("nextpostalcode")%>" != '' && document.getElementById('next_postal_code1') != null)
			   {
		document.getElementById('next_postal_code').value="<%=(String)hashMap1.get("nextpostalcode")%>"
		document.getElementById('next_postal_code1').value="<%=(String)hashMap1.get("nextpostalcode_desc")%>"

			   }
	if("<%=(String)hashMap1.get("firstpostalcode")%>" != '' && document.getElementById('first_postal_code1') != null)
			   {
		document.getElementById('first_postal_code').value="<%=(String)hashMap1.get("firstpostalcode")%>"
		document.getElementById('first_postal_code1').value="<%=(String)hashMap1.get("firstpostalcode_desc")%>"

			   }
	if("<%=(String)hashMap1.get("emplr_addr_line1")%>" != '' && document.getElementById('employ_addr_line1') != null)
		document.getElementById('employ_addr_line1').value="<%=(String)hashMap1.get("emplr_addr_line1")%>"
	if("<%=(String)hashMap1.get("emplr_addr_line2")%>" != '' && document.getElementById('employ_addr_line2') != null)
		document.getElementById('employ_addr_line2').value="<%=(String)hashMap1.get("emplr_addr_line2")%>"
    if("<%=(String)hashMap1.get("emplr_addr_line3")%>" != '' && document.getElementById('employ_addr_line3') != null)
		document.getElementById('employ_addr_line3').value="<%=(String)hashMap1.get("emplr_addr_line3")%>"
	if("<%=(String)hashMap1.get("emplr_addr_line4")%>" != '' && document.getElementById('employ_addr_line4') != null)
		document.getElementById('employ_addr_line4').value="<%=(String)hashMap1.get("emplr_addr_line4")%>"
	if("<%=(String)hashMap1.get("emplr_postal_code")%>" != '' && document.getElementById('employ_postal_code1') != null)
			   {
		document.getElementById('employ_postal_code').value="<%=(String)hashMap1.get("emplr_postal_code")%>"
		document.getElementById('employ_postal_code1').value="<%=(String)hashMap1.get("emplr_postal_code_desc")%>"

			   }
	if("<%=(String)hashMap1.get("res_town_long_desc")%>" != '' && document.getElementById('r_town_code') != null)
		document.getElementById('r_town_code').value="<%=(String)hashMap1.get("res_town_long_desc")%>"
	if("<%=(String)hashMap1.get("res_town_code")%>" != '')
		document.getElementById('r_town').value="<%=(String)hashMap1.get("res_town_code")%>"
	if("<%=(String)hashMap1.get("res_area_long_desc")%>" != '' && document.getElementById('r_area_code') != null)
		document.getElementById('r_area_code').value="<%=(String)hashMap1.get("res_area_long_desc")%>"
	if("<%=(String)hashMap1.get("res_area_code")%>" != '')
		document.getElementById('r_area').value="<%=(String)hashMap1.get("res_area_code")%>"
	if("<%=(String)hashMap1.get("region_long_desc")%>" != '' && document.getElementById('r_region_code') != null)
		document.getElementById('r_region_code').value="<%=(String)hashMap1.get("region_long_desc")%>"
	if("<%=(String)hashMap1.get("region_code")%>" != '')
		document.getElementById('r_region').value="<%=(String)hashMap1.get("region_code")%>"
	if("<%=(String)hashMap1.get("mail_res_town_long_desc")%>" != '' && document.getElementById('m_town_code') != null)
		document.getElementById('m_town_code').value="<%=(String)hashMap1.get("mail_res_town_long_desc")%>"
	if("<%=(String)hashMap1.get("mail_res_town")%>" != '')
		document.getElementById('m_town').value="<%=(String)hashMap1.get("mail_res_town")%>"
	if("<%=(String)hashMap1.get("mail_res_area_long_desc")%>" != '' && document.getElementById('m_area_code') != null)
		document.getElementById('m_area_code').value="<%=(String)hashMap1.get("mail_res_area_long_desc")%>"
	if("<%=(String)hashMap1.get("mail_res_area")%>" != '')
		document.getElementById('m_area').value="<%=(String)hashMap1.get("mail_res_area")%>"
	if("<%=(String)hashMap1.get("mail_region_long_desc")%>" != '' && document.getElementById('m_region_code') != null)
		document.getElementById('m_region_code').value="<%=(String)hashMap1.get("mail_region_long_desc")%>"
	if("<%=(String)hashMap1.get("mail_region_code")%>" != '')
		document.getElementById('m_region').value="<%=(String)hashMap1.get("mail_region_code")%>"
	if("<%=(String)hashMap1.get("nkin_town_long_desc")%>" != '' && document.getElementById('contact1_res_town_code') != null)
		document.getElementById('contact1_res_town_code').value="<%=(String)hashMap1.get("nkin_town_long_desc")%>"
	if("<%=(String)hashMap1.get("contact1_res_town_code")%>" != '')
		document.getElementById('n_town').value="<%=(String)hashMap1.get("contact1_res_town_code")%>"
	if("<%=(String)hashMap1.get("nkin_area_long_desc")%>" != '' && document.getElementById('contact1_res_area_code') != null)
		document.getElementById('contact1_res_area_code').value="<%=(String)hashMap1.get("nkin_area_long_desc")%>"
	if("<%=(String)hashMap1.get("contact1_res_area_code")%>" != '')
		document.getElementById('n_area').value="<%=(String)hashMap1.get("contact1_res_area_code")%>"
	if("<%=(String)hashMap1.get("nkin_region_long_desc")%>" != '' && document.getElementById('contact1_region_code') != null)
		document.getElementById('contact1_region_code').value="<%=(String)hashMap1.get("nkin_region_long_desc")%>"
	if("<%=(String)hashMap1.get("contact1_region_code")%>" != '')
		document.getElementById('n_region').value="<%=(String)hashMap1.get("contact1_region_code")%>"
	if("<%=(String)hashMap1.get("fton_town_long_desc")%>" != '' && document.getElementById('contact2_res_town_code') != null)
		document.getElementById('contact2_res_town_code').value="<%=(String)hashMap1.get("fton_town_long_desc")%>"
	if("<%=(String)hashMap1.get("contact2_res_town_code")%>" != '')
		document.getElementById('f_town').value="<%=(String)hashMap1.get("contact2_res_town_code")%>"
	if("<%=(String)hashMap1.get("fton_area_long_desc")%>" != '' && document.getElementById('contact2_res_area_code') != null)
		document.getElementById('contact2_res_area_code').value="<%=(String)hashMap1.get("fton_area_long_desc")%>"
	if("<%=(String)hashMap1.get("contact2_res_area_code")%>" != '')
		document.getElementById('f_area').value="<%=(String)hashMap1.get("contact2_res_area_code")%>"
	if("<%=(String)hashMap1.get("fton_region_long_desc")%>" != '' && document.getElementById('contact2_region_code') != null)
		document.getElementById('contact2_region_code').value="<%=(String)hashMap1.get("fton_region_long_desc")%>"
	if("<%=(String)hashMap1.get("contact2_region_code")%>" != '')
		document.getElementById('f_region').value="<%=(String)hashMap1.get("contact2_region_code")%>"
	if("<%=(String)hashMap1.get("emplr_town_long_desc")%>" != '' && document.getElementById('contact3_res_town_code') != null)
		document.getElementById('contact3_res_town_code').value="<%=(String)hashMap1.get("emplr_town_long_desc")%>"
	if("<%=(String)hashMap1.get("emplr_area_long_desc")%>" != '' && document.getElementById('contact3_res_area_code') != null)
		document.getElementById('contact3_res_area_code').value="<%=(String)hashMap1.get("emplr_area_long_desc")%>"
	if("<%=(String)hashMap1.get("emplr_region_long_desc")%>" != '' && document.getElementById('contact3_region_code') != null)
		document.getElementById('contact3_region_code').value="<%=(String)hashMap1.get("emplr_region_long_desc")%>"
	if("<%=(String)hashMap1.get("contact3_region_code")%>" != '')
		document.getElementById('e_region').value="<%=(String)hashMap1.get("contact3_region_code")%>"
	if("<%=(String)hashMap1.get("contact3_res_town_code")%>" != '')
		document.getElementById('e_town').value="<%=(String)hashMap1.get("contact3_res_town_code")%>"
	if("<%=(String)hashMap1.get("contact3_res_area_code")%>" != '')
		document.getElementById('e_area').value="<%=(String)hashMap1.get("contact3_res_area_code")%>"
    //Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
	if("<%=(String)hashMap1.get("n_next_addr_line1")%>" != '' && document.getElementById('n_next_addr_line1') != null)
		document.getElementById('n_next_addr_line1').value="<%=(String)hashMap1.get("n_next_addr_line1")%>"
	if("<%=(String)hashMap1.get("n_ma_addr_line2")%>" != '' && document.getElementById('n_ma_addr_line2') != null)
		document.getElementById('n_ma_addr_line2').value="<%=(String)hashMap1.get("n_ma_addr_line2")%>"
	if("<%=(String)hashMap1.get("n_ma_addr_line3")%>" != '' && document.getElementById('n_ma_addr_line3') != null)
		document.getElementById('n_ma_addr_line3').value="<%=(String)hashMap1.get("n_ma_addr_line3")%>"
	if("<%=(String)hashMap1.get("n_ma_addr_line4")%>" != '' && document.getElementById('n_ma_addr_line4') != null)
		document.getElementById('n_ma_addr_line4').value="<%=(String)hashMap1.get("n_ma_addr_line4")%>"
	if("<%=(String)hashMap1.get("rl_nk_town_desc")%>" != '' && document.getElementById('n_contact_ma_town_code') != null)
		document.getElementById('n_contact_ma_town_code').value="<%=(String)hashMap1.get("rl_nk_town_desc")%>"
	if("<%=(String)hashMap1.get("n_contact_ma_town_code")%>" != '')
		document.getElementById('nkma_town').value="<%=(String)hashMap1.get("n_contact_ma_town_code")%>"
	if("<%=(String)hashMap1.get("rl_nk_region_desc")%>" != '' && document.getElementById('n_contac_region_code') != null)
		document.getElementById('n_contac_region_code').value="<%=(String)hashMap1.get("rl_nk_region_desc")%>"
	if("<%=(String)hashMap1.get("n_contac_region_code")%>" != '')
		document.getElementById('contact1_region').value="<%=(String)hashMap1.get("n_contac_region_code")%>"
	if("<%=(String)hashMap1.get("rl_nk_area_desc")%>" != '' && document.getElementById('n_contact_ma_area_code') != null)
		document.getElementById('n_contact_ma_area_code').value="<%=(String)hashMap1.get("rl_nk_area_desc")%>"
	if("<%=(String)hashMap1.get("n_contact_ma_area_code")%>" != '')
		document.getElementById('nkma_area').value="<%=(String)hashMap1.get("n_contact_ma_area_code")%>"
	if("<%=(String)hashMap1.get("n_ma_postal_code")%>" != '' && document.getElementById('n_ma_postal_code1') != null)
			   {
		document.getElementById('n_ma_postal_code').value="<%=(String)hashMap1.get("n_ma_postal_code")%>"
		document.getElementById('n_ma_postal_code1').value="<%=(String)hashMap1.get("rl_nk_postal_code")%>"
			   }
	if("<%=(String)hashMap1.get("fton_mail_addr_line1")%>" != '' && document.getElementById('fton_mail_addr_line1') != null)
		document.getElementById('fton_mail_addr_line1').value="<%=(String)hashMap1.get("fton_mail_addr_line1")%>"
	if("<%=(String)hashMap1.get("fton_mail_addr_line2")%>" != '' && document.getElementById('fton_mail_addr_line2') != null)
		document.getElementById('fton_mail_addr_line2').value="<%=(String)hashMap1.get("fton_mail_addr_line2")%>"
	if("<%=(String)hashMap1.get("fton_mail_addr_line3")%>" != '' && document.getElementById('fton_mail_addr_line3') != null)
		document.getElementById('fton_mail_addr_line3').value="<%=(String)hashMap1.get("fton_mail_addr_line3")%>"
	if("<%=(String)hashMap1.get("fton_mail_addr_line4")%>" != '' && document.getElementById('fton_mail_addr_line4') != null)
		document.getElementById('fton_mail_addr_line4').value="<%=(String)hashMap1.get("fton_mail_addr_line4")%>"
	if("<%=(String)hashMap1.get("rl_fton_town_desc")%>" != '' && document.getElementById('fst_to_no_ma_town_code') != null)
		document.getElementById('fst_to_no_ma_town_code').value="<%=(String)hashMap1.get("rl_fton_town_desc")%>"
	if("<%=(String)hashMap1.get("fst_to_no_ma_town_code")%>" != '')
		document.getElementById('contact2_res_town').value="<%=(String)hashMap1.get("fst_to_no_ma_town_code")%>"
	if("<%=(String)hashMap1.get("rl_fton_region_desc")%>" != '' && document.getElementById('fst_to_no_ma_reg_cod') != null)
		document.getElementById('fst_to_no_ma_reg_cod').value="<%=(String)hashMap1.get("rl_fton_region_desc")%>"
	if("<%=(String)hashMap1.get("fst_to_no_ma_reg_cod")%>" != '')
		document.getElementById('contact2_region').value="<%=(String)hashMap1.get("fst_to_no_ma_reg_cod")%>"

	if("<%=(String)hashMap1.get("rl_fton_area_desc")%>" != '' && document.getElementById('fst_to_no_ma_area_code') != null)
		document.getElementById('fst_to_no_ma_area_code').value="<%=(String)hashMap1.get("rl_fton_area_desc")%>"
	if("<%=(String)hashMap1.get("fst_to_no_ma_area_code")%>" != '')
		document.getElementById('contact2_res_area').value="<%=(String)hashMap1.get("fst_to_no_ma_area_code")%>"

	if("<%=(String)hashMap1.get("fst_no_ma_pos_cod")%>" != '' && document.getElementById('fst_no_ma_pos_cod1') != null)
			   {
		document.getElementById('fst_no_ma_pos_cod').value="<%=(String)hashMap1.get("fst_no_ma_pos_cod")%>"
		document.getElementById('fst_no_ma_pos_cod1').value="<%=(String)hashMap1.get("rl_fton_postal_code")%>"
			   }
    //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
</script>
<input type='hidden' name='dflt_pat_ser_grp_code' id='dflt_pat_ser_grp_code' value='UN'></input>
<input type='hidden' name='patient_name_loc_lang' id='patient_name_loc_lang' value="">  
<input type='hidden' name='details_unknown' id='details_unknown' value='<%=(String)hashMap1.get("pat_dtls_unknown_yn")%>'>
<input type='hidden' name='town_desc' id='town_desc' value="" ></input>

<input type='hidden' name='operation' id='operation' value='modify'></input>
<input type='hidden' name='pat_no_gen_yn' id='pat_no_gen_yn' value=""></input>
<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>"></input>
<input type='hidden' name='alt_exp_date_fromHCS' id='alt_exp_date_fromHCS' value="N"></input>
	
<input type='hidden' name='bl_install_yn' id='bl_install_yn' value="<%=bl_install_yn%>"></input>
<input type='hidden' name='bl_success' id='bl_success' value="N"></input>
<input type='hidden' name='name_drvn_logic' id='name_drvn_logic' value='<%=(String) hashMap.get("NameDrvnLogic")%>'>
<input type='hidden' name='name_drvn_logic_oth_lang' id='name_drvn_logic_oth_lang' value='<%=(String)hashMap.get("NameDrvnLogicOthLang")%>'>
<input type='hidden' name='name_drvn_logic_long' id='name_drvn_logic_long' value='<%=(String)hashMap.get("name_dervn_logic_long")%>'>
<input type='hidden' name='name_drvn_logic_oth_lang_long' id='name_drvn_logic_oth_lang_long' value='<%=(String)hashMap.get("name_dervn_logic_oth_lang_long")%>'>
<input type='hidden' name='patient_name_long' id='patient_name_long' value="<%=(String)hashMap1.get("patient_long_name")%>"></input>
<%if (accept_oth_lang_yn.equals("Y")){%>
<input type='hidden' name='patient_name_loc_lang_long' id='patient_name_loc_lang_long' value="<%=(String)hashMap1.get("patient_long_name_loc_lang")%>"></input><%}else if(accept_oth_lang_yn.equals("N")){%>
<input type='hidden' name='patient_name_loc_lang_long' id='patient_name_loc_lang_long' value=""></input><%}%>
<input type='hidden' name='patient_group' id='patient_group' value='A'>
<input type='hidden' name='nat_id_val' id='nat_id_val' value='S'>
	<% 
	if(bl_install_yn.equals("Y")) {
			String dflt_nb_blng_grp_as_mother_yn = "", newborn_blng_grp_id="", settlement_ind="";
			hashMap5 = eMP.ChangePatientDetails.getBlMPParamDtls("bl_mp_param", con,p);
			if(((String)hashMap5.get("flag")).equals("yes")) {
				dflt_nb_blng_grp_as_mother_yn	= (String)hashMap5.get("dflt_nb_blng_grp_as_mother_yn");
				newborn_blng_grp_id				= (String)hashMap5.get("newborn_blng_grp_id");
				if(dflt_nb_blng_grp_as_mother_yn.equals("N")) {
					hashMap6 = eMP.ChangePatientDetails.getBlBlngGrpDtls(newborn_blng_grp_id, con,p);
					settlement_ind = (String)hashMap6.get("settlement_ind");
				}
			}
			else newborn_param = "N";
				
			if(function_id.equals("NEWBORN_REG") && dflt_nb_blng_grp_as_mother_yn.equals("Y")) { %>			 <jsp:include page="../../eBL/jsp/BLFinDetHiddenFlds.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name="patient_id" value="<%=mother_patient_id%>" />
				<jsp:param name="calling_module" value="MP" />
				<jsp:param name="calling_function_id" value="<%=function_id%>" />
				<jsp:param name="episode_type" value="" />
				</jsp:include> 
				<script>document.forms[0].bl_operation.value ='Insert'</script>
		<%	} else if (function_id.equals("NEWBORN_REG") && dflt_nb_blng_grp_as_mother_yn.equals("N") && 			!newborn_blng_grp_id.equals("")) { %>
	           	<input type='hidden' name='billing_group' id='billing_group' value="<%=newborn_blng_grp_id%>"></input>
				<input type='hidden' name='billing_class' id='billing_class' value=""></input><input type='hidden' name='employer_code' id='employer_code' value=""></input><input type='hidden' name='cash_set_type1' id='cash_set_type1' value=""></input><input type='hidden' name='cash_insmt_ref1' id='cash_insmt_ref1' value=""></input>
				<input type='hidden' name='cash_insmt_date1' id='cash_insmt_date1' value=""></input><input type='hidden' name='cash_insmt_rmks1' id='cash_insmt_rmks1' value=""></input><input type='hidden' name='cust_1' id='cust_1' value=""></input><input type='hidden' name='credit_doc_ref1' id='credit_doc_ref1' value=""></input>
				<input type='hidden' name='credit_doc_date1' id='credit_doc_date1' value=""></input><input type='hidden' name='cust_2' id='cust_2' value=""></input><input type='hidden' name='credit_doc_ref2' id='credit_doc_ref2' value=""></input><input type='hidden' name='credit_doc_date2' id='credit_doc_date2' value=""></input>
				<input type='hidden' name='cust_3' id='cust_3' value=""></input><input type='hidden' name='policy_type' id='policy_type' value=""></input><input type='hidden' name='policy_no' id='policy_no' value=""></input><input type='hidden' name='policy_expiry_date' id='policy_expiry_date' value=""></input>
				<input type='hidden' name='non_insur_blng_grp' id='non_insur_blng_grp' value=""></input><input type='hidden' name='cash_set_type2' id='cash_set_type2' value=""></input><input type='hidden' name='cash_insmt_ref2' id='cash_insmt_ref2' value=""></input><input type='hidden' name='cash_insmt_date2' id='cash_insmt_date2' value=""></input>
				<input type='hidden' name='cash_insmt_rmks2' id='cash_insmt_rmks2' value=""></input><input type='hidden' name='cust_4' id='cust_4' value=""></input><input type='hidden' name='credit_doc_ref3' id='credit_doc_ref3' value=""></input><input type='hidden' name='credit_doc_date3' id='credit_doc_date3' value=""></input>
				<input type='hidden' name='setlmt_ind' id='setlmt_ind' value="<%=settlement_ind%>"></input>
				<input type='hidden' name='upd_fin_dtls' id='upd_fin_dtls' value=""></input><input type='hidden' name='credit_auth_ref' id='credit_auth_ref' value=""></input><input type='hidden' name='credit_auth_date' id='credit_auth_date' value=""></input><input type='hidden' name='app_days' id='app_days' value=""></input>
				<input type='hidden' name='app_amount' id='app_amount' value=""></input><input type='hidden' name='eff_frm_date' id='eff_frm_date' value=""></input><input type='hidden' name='remarks' id='remarks' value=""></input><input type='hidden' name='billing_mode' id='billing_mode' value='Add'></input>
				<input type='hidden' name='bl_operation' id='bl_operation' value=''></input><input type='hidden' name='health_card_expired_yn' id='health_card_expired_yn' value=""></input><input type='hidden' name='annual_income' id='annual_income' value=""></input><input type='hidden' name='family_asset' id='family_asset' value=""></input>
				<input type='hidden' name='no_of_dependants' id='no_of_dependants' value=""></input><input type='hidden' name='resp_for_payment' id='resp_for_payment' value=""></input><input type='hidden' name='credit_doc_reqd_yn1' id='credit_doc_reqd_yn1' value=""></input><input type='hidden' name='credit_doc_reqd_yn2' id='credit_doc_reqd_yn2' value=""></input>
				<input type='hidden' name='gl_holder_name' id='gl_holder_name' value=""></input><input type='hidden' name='gl_holder_reln' id='gl_holder_reln' value=""></input>
				<% } else { %>
				<jsp:include page="../../eBL/jsp/BLFinDetHiddenFlds.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name="patient_id" value="<%=patient_id%>" />
				<jsp:param name="calling_module" value="MP" />
				<jsp:param name="calling_function_id" value="<%=function_id%>" />
				<jsp:param name="episode_type" value="" />
				</jsp:include> 
			<% } %>
			<script>if ( (document.forms[0].billing_group) && (document.forms[0].billing_group.value != '') ) document.forms[0].bl_success.value = 'Y';</script>
			<%	if(function_id.equals("NEWBORN_REG")) {
				hashMap4 = eMP.ChangePatientDetails.getBlMPParamDtls("bl_mp_param1", con,p);
			}
			else {
				hashMap4 = eMP.ChangePatientDetails.getBlMPParamDtls("bl_mp_param2", con,p);
			}
		} %>

<script>    
	 if('<%=function_id%>' != 'PAT_REG') FocusFirstElement();
</script>
<input type='hidden' name='sStyle' id='sStyle' value="<%=sStyle%>">		
<input type='hidden' name='maintain_doc_or_file' id='maintain_doc_or_file' value="<%= (String) hashMap.get("maintain_doc_or_file")%>">		
<input type='hidden' name='newborn_param' id='newborn_param' value='<%=newborn_param%>'><input type='hidden' name='cred_start_dt1' id='cred_start_dt1' value=""></input> <input type='hidden' name='cred_start_dt2' id='cred_start_dt2' value=""></input>  
<input type='hidden' name='cred_start_dt3' id='cred_start_dt3'  value=""></input><input type='hidden' name='dflt_pat_regn_blng_class' id='dflt_pat_regn_blng_class' value="<%=(String)hashMap4.get("dflt_regn_blng_class")%>">
<input type='hidden' name='called_from' id='called_from' value="ChangePatDtlForm"></input>
<input type='hidden' name='multi_birth' id='multi_birth' value="<%=multi_birth%>"></input>
<input type='hidden' name='parent_details' id='parent_details' value="<%=parent_details%>"></input>
<input type='hidden' name='mother_patient_id' id='mother_patient_id' value="<%=mother_patient_id%>"></input>
<input type='hidden' name='numOfbaby' id='numOfbaby' value="<%=numOfbaby%>"></input>
<input type='hidden' name='noOfBirths' id='noOfBirths' value="<%=noOfBirths%>"></input>
<input type='hidden' name='called_from_newborn' id='called_from_newborn' value="<%=called_from_newborn%>"></input>
<input type='hidden' name='dflt_alt_id1_in_emp_id_yn' id='dflt_alt_id1_in_emp_id_yn' value="<%=dflt_alt_id1_in_emp_id_yn%>">	
<input type='hidden' name='count' id='count' value="<%=count%>">	
<input type='hidden' name='nb_mother_cutoff_age' id='nb_mother_cutoff_age' value="<%=(String)hashMap.get("nb_mother_cutoff_age")%>">
<input type='hidden' name='dflt_nat_id_chk_val' id='dflt_nat_id_chk_val' value="<%=(String)hashMap1.get("nationality_code")%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='accept_pw_in_chng_pat_dtl_yn' id='accept_pw_in_chng_pat_dtl_yn' value="<%=accept_pw_in_chng_pat_dtl_yn%>">
<!--New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar--> 
<input type='hidden' name='region_prompt1' id='region_prompt1' value="<%=region_prompt%>"></input>
<input type='hidden' name='region_appl_yn1' id='region_appl_yn1' value="<%=region_appl_yn%>"></input>

<!--Added by Rameswar on 21-10-2016 for  KDAH-CRF-0324-->
<input type='hidden' name='addr_line1_prompt' id='addr_line1_prompt' value="<%=addr_line1_prompt%>"></input>
<input type='hidden' name='addr_line2_prompt' id='addr_line2_prompt' value="<%=addr_line2_prompt%>"></input>
<input type='hidden' name='postal_code_prompt' id='postal_code_prompt' value="<%=postal_code_prompt%>"></input>
<input type='hidden' name='area_code_prompt' id='area_code_prompt' value="<%=area_code_prompt%>"></input>  
<input type='hidden' name='town_code_prompt' id='town_code_prompt' value="<%=town_code_prompt%>"></input> 
<!-- Added by Suji keerthi on 21-Nov-2019 for KDAH-CRF-0522 -->
<input type ='hidden' name='altId1Desc' id='altId1Desc' value="<%=(String)hashMap.get("alt_id1_desc")%>">
<input type ='hidden' name='altId2Desc' id='altId2Desc' value="<%=(String)hashMap.get("alt_id2_desc")%>">
<input type ='hidden' name='altId3Desc' id='altId3Desc' value="<%=(String)hashMap.get("alt_id3_desc")%>">
<input type ='hidden' name='altId4Desc' id='altId4Desc' value="<%=(String)hashMap.get("alt_id4_desc")%>">
<input type ='hidden' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' value="<%=(String)hashMap.get("upt_contact_dtls_oa_yn")%>"><!--added changes for HSA-CRF-0226 [IN:050599]-->
<input type ='hidden' name='upd_pat_dtls_referral_yn' id='upd_pat_dtls_referral_yn' value="<%=(String)hashMap.get("upd_pat_dtls_referral_yn")%>"><!--Added by Dharma against HSA-CRF-0303 [IN:054572] on Apr 8th 2016-->
<input type='hidden' name='deceased_yn' id='deceased_yn' value="N"></input>
<input type='hidden' name='deceased_date' id='deceased_date' value=""></input>
<input type='hidden' name='dla_image_yn' id='dla_image_yn' value=""></input>

<!--Added by Ashwini on 07-Sep-2018-->
<input type='hidden' name='finDtlsChkNationality' id='finDtlsChkNationality' value='<%=finDtlsChkNationality%>'></input>
<!-- Below Added by Suji keerthi for ML-MMOH-CRF-1527 US007 -->
<input type='hidden' name='aliasnameNationalityRace' id='aliasnameNationalityRace' value='<%=aliasnameNationalityRace%>'></input>
<!-- Below Added by Suji keerthi for ML-MMOH-CRF-1527 US008 -->
<input type='hidden' name='resiAddMailAdd' id='resiAddMailAdd' value='<%=resiAddMailAdd%>'></input>

<!--Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1-->
<input type='hidden' name='load_tab' id='load_tab' value='<%=load_tab%>'></input>
<input type='hidden' name='reset_dem' id='reset_dem' value='<%=reset_dem%>'></input>

<input type='hidden' name='isVirtualConsultation' id='isVirtualConsultation' value='<%=isVirtualConsultation%>'></input>

<!-- <input type='hidden' name='alt_postal_code' id='alt_postal_code' value=''>--> <!-- Added for this ML-MMOH-CRF-0601-->

<%/*Added by Rameswar on  13-04-2016 for MMS-QF-SCF-0532 TF*/
Boolean fileTypeSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","FILE_TYPE_RESTRICT");%>
		<!--Added by Rameswar on  13-04-2016 for MMS-QF-SCF-0532 TF-->
		<input type='hidden' name='fileTypeSiteSpec' id='fileTypeSiteSpec' value='<%=fileTypeSiteSpec%>'></input>

<script> 
	/*Added to check the alt_id1_no should be disabled or enabled for the current patient series. 
	   Function is in PatientRegistration2.js     -   5/10/2006*/
	  dispMandatoryImage();
	/*Added by Vinod*/

	<%=exestr%>
	if('<%=function_id%>' != '' && '<%=called_from_newborn%>' != 'Y')
    {
        enable_disable('<%=function_id%>')
		if(document.forms[0].next_contact_name)
		document.forms[0].next_contact_name.disabled=true;
		if(document.getElementById('birthdate1'))
		document.getElementById('birthdate1').disabled=true;
		if(document.getElementById('imgdateofbirth'))
		document.getElementById('imgdateofbirth').disabled=true;
		if(document.getElementById('label1'))
		document.getElementById('label1').style.visibility='hidden';
		if(document.getElementById('label2'))
		document.getElementById('label2').style.visibility='hidden';
		if(document.getElementById('label3'))
		document.getElementById('label3').style.visibility='hidden';
    }
    var nms = new Array();
    var vals = new Array();
    for(var i=0;i<document.forms[0].length;i++) {
        nms [i] =document.forms[0].elements[i].name
        vals [i] =document.forms[0].elements[i].value
    }
    original_vals[0] = nms
    original_vals[1] = vals

	if('<%=called_from_newborn%>' == 'Y')
	{
      if(document.getElementById('rel'))
		document.getElementById('rel').style.visibility='visible';
	}
</script>
 
<% if((((String)hashMap.get("ext_system_interface_yn")).equals("Y")) && (nat_data_source_id.equals("NRIC"))) { 
	
	%>
		<OBJECT id=Cad style=\"WIDTH: 149px; HEIGHT: 25px\" data=data:application/x-oleobject;base64,6bldI31CwEeRWh+s54i2NAADAABmDwAAlQIAAA== classid=clsid:235DB9E9-427D-47C0-915A-1FACE788B634></OBJECT>
		<OBJECT id=jpndf1 style=\"WIDTH: 192px; HEIGHT: 24px\" data=data:application/x-oleobject;base64,arMlNbqDrEKC9D9p0v5gBQADAADYEwAAewIAAA== classid=clsid:3525B36A-83BA-42AC-82F4-3F69D2FE6005></OBJECT>
		<OBJECT id=jpndf4 style=\"LEFT: 0px; WIDTH: 192px; TOP: 0px; HEIGHT: 24px\" data=data:application/x-oleobject;base64,zUFYb5tV40iaOd6s6vQBygADAADYEwAAewIAAA== classid=clsid:6F5841CD-559B-48E3-9A39-DEACEAF401CA></OBJECT>
		<OBJECT id=gmpcpic style=\"WIDTH: 345px; HEIGHT: 303px\" data=data:application/x-oleobject;base64,2lmqMIeVKU6C6+Ww4x0h3QADAACoIwAAUR8AAA== classid=clsid:30AA59DA-9587-4E29-82EB-E5B0E31D21DD></OBJECT>
	<% } %>

</form>
</body>
<html>

<script>
enableocpn();
document.getElementById('occu_of_per_desc').value='<%=(String)hashMap1.get("ocpn_desc")%>'
</script>

<% } else if(((String)hashMap1.get("flag")).equals("no")) { %>
		<script>alert(getMessage('INCOMPLETE_PAT_REC','MP'));</script>
	<script>parent.parent.f_query_add_mod.location.href='../../eMP/jsp/blank.jsp?step_1=5';</script>
<% }

if(!((String)hashMap.get("alt_id1_chng_allowed_yn")).equals("Y")) {
%>
			
			<script>				
				if(document.getElementById('alt_id1_no')){
					document.getElementById('alt_id1_no').disabled=true
					//document.getElementById('alt_id1_no').readOnly="readonly";
				}

			if(document.getElementById('alt_id1_exp_date'))
			{	
				//document.getElementById('alt_id1_exp_date').readOnly=true;
				document.getElementById('alt_id1_exp_date').disabled=true;
				document.getElementById('altidexpdt1').disabled=true;
			}
				</script>

			<% 
	}
/*Added by Dharma on Apr 7th 2015 against HSA-CRF-0191 [IN:049772] Start*/

if(!((String)hashMap.get("alt_id2_chng_allowed_yn")).equals("Y")) {
	%>
		<script>				
			if(document.getElementById('alt_id2_no')){
				document.getElementById('alt_id2_no').disabled=true;
			}

			if(document.getElementById('alt_id2_exp_date')) {	
				document.getElementById('alt_id2_exp_date').disabled=true;
				document.getElementById('altidexpdt2').disabled=true;
			}

		</script>
	<% 
}
if(!((String)hashMap.get("alt_id3_chng_allowed_yn")).equals("Y")) {
	%>
		<script>				
			if(document.getElementById('alt_id3_no')){
				document.getElementById('alt_id3_no').disabled=true;
			}

			if(document.getElementById('alt_id3_exp_date')) {	
				document.getElementById('alt_id3_exp_date').disabled=true;
				document.getElementById('altidexpdt3').disabled=true;
			}
		</script>
	<% 
}
if(!((String)hashMap.get("alt_id4_chng_allowed_yn")).equals("Y")) {
	%>
		<script>				
			if(document.getElementById('alt_id4_no')){
				document.getElementById('alt_id4_no').disabled=true;
			}
			if(document.getElementById('alt_id4_exp_date')) {	
				document.getElementById('alt_id4_exp_date').disabled=true;
				document.getElementById('altidexpdt4').disabled=true;
			}
		</script>
	<% 
}


 
/*Added by Dharma on Apr 7th 2015 against HSA-CRF-0191 [IN:049772] End*/
/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
%><script>
	
	function form60OnLoad(){
		if(document.getElementById('isDisabledForm60').value!="" && document.getElementById('isForm60Validation').value=="Y" &&  document.getElementById('isForm60Available').value=="true"){
			document.getElementById('formno60').disabled=true;
			document.getElementById('alt_id3_no').disabled=true;
			document.getElementById('alt3_gif').style.visibility='hidden';
		}else if(document.getElementById('isForm60Validation').value=="Y" &&  document.getElementById('isForm60Available').value=="true"){
			if(document.getElementById('formno60').value=="Y"){
				document.getElementById('alt_id3_no').disabled=true;
				//Commented by Dharma on july 13th 2016 against KDAH-SCF-0358 [IN:060809]
				/*document.getElementById('alt_id3_reqd_yn').value="N";
				document.getElementById('alt3_gif').style.visibility='hidden';*/

			}

		}
	}
	/*Added By Dharma for AAKH-CRF-0128.1*/
	function focusContactTab(){
		
		var load_tab = document.getElementById('load_tab').value;
		var reset_dem = document.getElementById('reset_dem').value;
		
		if(load_tab == 'CONTACT_ADDR_TAB' && reset_dem == '')
		{
			parent.patient_main.prevTabObj = 'demogrp_tab';
			parent.patient_main.invokeTab('cmodeaddr_tab');
		}else if(load_tab == 'CONTACT_ADDR_TAB' && reset_dem == 'DEM_DTLS_TAB')
		{
			parent.patient_main.invokeTab('demogrp_tab');
		}
	}
</script>
<%
/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/

hashMap.clear();hashMap1.clear();hashMap2.clear();hashMap3.clear();hashMap4.clear();hashMap5.clear();hashMap6.clear();hashMap7.clear();hashMap8.clear();arrayList.clear();arrayList1.clear();arrayList2.clear(); arrayList3.clear();arrayList6.clear();arrayList5.clear();
}catch(Exception e){ out.println("Exception in Change Patient Sub file : "+e.toString()); e.printStackTrace();}
finally { if(con!=null) ConnectionManager.returnConnection(con,request); }
%>
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


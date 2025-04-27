<!DOCTYPE html>
<!-- Last Modified Date Time : 9/30/2005 12:20 PM -->

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.*,com.ehis.util.*,java.io.* ,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="PatientAddressLegends.jsp"%>
<%
String Facility_Id = (String) session.getValue("facility_id");


String function_id1="";
request.setCharacterEncoding("UTF-8");
function_id1=request.getParameter("function_id");
Connection con = null;
ResultSet  rs_lang=null; 

String locale			= (String)session.getAttribute("LOCALE");
String patient=request.getParameter("Patient");

String disp_dup_pat_dtls=request.getParameter("disp_dup_pat_dtls");
String group_status=request.getParameter("group_status") ; 

Properties p		= (java.util.Properties) session.getValue("jdbc");
String age_value = "";
String language_direction="";
String family_org_id_accept_yn="";
	 String entitlement_by_pat_cat_yn="";
		
/* Friday, April 30, 2010 PE_EXE Venkat S 
StringBuffer sqlresp = new StringBuffer("select view_pat_photo_yn from mp_access_rights where resp_id = '");
sqlresp.append(resp_id);
sqlresp.append("'");
String view_pat_photo_yn = "N"; */

String view_pat_photo_yn=request.getParameter("view_pat_photo_yn");
if(view_pat_photo_yn == null ||view_pat_photo_yn.equals(""))
	view_pat_photo_yn = "N";

String total=request.getParameter("total");
if(total == null ||total.equals(""))
	total = "";
int count = Integer.parseInt(total);

ResultSet rs=null;
ResultSet rs2=null;
PreparedStatement pstmt = null;
PreparedStatement pstmt1 = null;



try
{

	con = ConnectionManager.getConnection(request);
	// Friday, April 30, 2010 
	//pstmt = con.prepareStatement(sqlresp.toString());
	//rs=pstmt.executeQuery();

 //   if (rs.next())
     //   view_pat_photo_yn = rs.getString(1);

		
/*
		if(pstmt1 != null) pstmt1.close();
		if(rs2 != null) rs2.close();
		
		pstmt1 = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
		
		rs2 = pstmt1.executeQuery() ;
             
		 if ( rs2 != null && rs2.next() ) 
		 {
		 count = rs2.getInt("total");
		 }
*/

		if ( count==1 ) 
		{
			 language_direction = "R" ;
		}else
		{
			 language_direction = "L" ;
		}

		//if(pstmt1 != null) pstmt1.close();
		//if(rs2 != null) rs2.close();

}
catch(Exception e)
{
	e.printStackTrace();

}

StringBuffer sql=new StringBuffer();
StringBuffer sql2 =  new StringBuffer();

String citizen_yn="";
String legal_yn="";
String Patient_id="";
String Patient_Name ="";
String Pat_Ser_Grp_Code="";
String Pat_Ser_Grp_Desc  ="";
String National_Id_No  ="";
String Pref_Facility_Id  ="";
String Pref_Facility_Name ="";
String Alt_Id1_Type ="";
String Alt_Id1_No    ="";
String Alt_Id1_Exp_Date  ="";
String Alt_Id2_Type   ="";
String Alt_Id2_No   ="";
String Alt_Id2_Exp_Date ="";
String Alt_Id3_Type    ="";
String Alt_Id3_No     ="";
String Alt_Id3_Exp_Date  ="";
String Alt_Id4_Type   ="";
String Alt_Id4_No     ="";
String  Alt_Id4_Exp_Date ="";
String Family_Link_No    ="";
String Relationship_To_Head ="";
String Relationship_Name  ="";
String Name_Prefix     ="";
String First_Name      ="";
String Second_Name    ="";
String Third_Name     ="";
String Family_Name    ="";
String Name_Suffix   ="";
String Sex          ="";
String Date_Of_Birth  ="";
String Place_Of_Birth ="";
String birth_place_code = "";
String birth_place_desc = "";
String Mar_Status_Code  ="";
String Mar_Status_Desc ="";
String Alias_Name   ="";
String Relgn_Code   ="";
String Relgn_Desc   ="";
String Nationality_Code ="";
String Nationality_Desc  ="";
String Mother_Maiden_Name ="";
String Pat_Cat_Code       ="";
String Pat_Cat_Desc    ="";
String Ref_Source_Code  ="";
String Ref_Source_Desc  ="";
String Age="";
String regn_facility_name = "";


String First_Name_Accept_Yn ="";
int First_Name_Order=0;
String First_Name_Prompt ="";
String Second_Name_Accept_Yn ="";
int Second_Name_Order =0;
String Second_Name_Prompt ="";
String Third_Name_Accept_Yn ="";
int Third_Name_Order =0;
String Third_Name_Prompt ="";
String Family_Name_Accept_Yn ="";
int Family_Name_Order =0;
String Family_Name_Prompt ="";
String Name_Suffix_Accept_Yn ="";
String Name_Suffix_Prompt ="";
String Name_Prefix_Accept_Yn = "";
String Name_Prefix_Prompt = "";
String Family_No_Link_Yn="";
String Resi_Addr_Line1="";	
String Resi_Addr_Line2="";
String Resi_Addr_Line3="";
String Resi_Addr_Line4="";
String Resi_Postal_Code="";
String Resi_Country_Name="";
String Resi_Invalid1_Yn="";
String Resi_Contact1_Name="";
String Resi_Area_Desc="";
String Resi_Town_Desc="";
String Mail_Addr_Line1="";
String Mail_Addr_Line2="";
String Mail_Addr_Line3="";
String Mail_Addr_Line4="";

String name_prefix_loc_lang  =""   ;
String first_name_loc_lang      =""  ;
String second_name_loc_lang=""    ; 
String third_name_loc_lang    =""    ;
String family_name_loc_lang  =""   ;
String name_suffix_loc_lang   =""  ;
String patient_name_loc_lang=""    ;

String Mail_Postal_Code="";
String Mail_Country_Name="";
String Mail_Invalid1_Yn="";
String Mail_Contact1_Name="";

String Prn_Tel_No="";
String Orn_Tel_No="";
String Contact3_Mode="";
String Contact4_Mode="";
String Contact5_Mode="";
String CONTACT3_MODE_DESC="";
String CONTACT4_MODE_DESC="";
String CONTACT5_MODE_DESC="";
String Contact3_No="";
String Contact4_No="";
String Contact5_No="";
String email_id = "";

String Nkin_Contact_Name="";
String Nkin_Job_Title ="";
String Nkin_Addr_Line1 ="";
String Nkin_Addr_Line2="";
String Nkin_Addr_Line3="";
String Nkin_Addr_Line4="";
String Nkin_Region_Code="";
String Nkin_Area_Code = "";
String Nkin_Town_Code="";
String Nkin_Postal_Desc ="";
String Nkin_Postal_Code ="";
String Nkin_Country_Code="";
String Nkin_Country_Name="";
String Nkin_Res_Tel_No ="";
String Nkin_Off_Tel_No=""; 
String Fton_Contact_Relation_Desc="";

String Fton_Contact_Name="";
String Fton_Job_Title ="";
String Fton_Addr_Line1="";
String Fton_Addr_Line2 ="";
String Fton_Addr_Line3 ="";
String Fton_Addr_Line4  ="";
String Fton_Postal_Code ="";
String Fton_Country_Code="";
String Fton_Country_Name ="";
String Fton_Res_Tel_No ="";
String Fton_Off_Tel_No ="";
String Nkin_Contact_Relation_Desc="";

String Ocpn_Desc="";
String Patient_Employee_Id="";
String Employment_Status="";
String Emplr_Contact_Name="";
String Emplr_Job_Title="";
String Emplr_Addr_Line1="";
String Emplr_Addr_Line2="";
String Emplr_Addr_Line3="";
String Emplr_Addr_Line4="";
String Emplr_Postal_Code="";

String Emplr_Country_Name="";
String Emplr_Res_Tel_No="";
String Emplr_Off_Tel_No="";
String Off_Fax_No="";
String Living_Dependency="";
String Living_Arrangement="";
String Education_Level="";
String Informant="";
String Informant_Remarks="";
String General_Remarks="";

String Suspend_Yn       = "";
String Status_Reason_Desc   = "";
String Status_Remarks       = "";
String Active_Yn        = "";
String Last_Contact_Date    = "";
String Deceased_Yn      = "";
String Deceased_Date        = "";
String Death_Status_Remarks     = "";
String cust_fields[] = new String[5];

String nat_id_prompt = "";
String added_by_id = "";
String added_user_name  = "";
String added_date = "";
String added_at_ws_no = "";
String added_facility_id = "";
String added_facility_name = "";
String modified_by_id = "";
String modified_user_name = "";
String modified_date = "";
String modified_at_ws_no = "";
String modified_facility_id  = "";
String modified_facility_name  = "";

String name_prefix_loc_lang_prompt  ="" ;
String first_name_loc_lang_prompt   ="" ;
String second_name_loc_lang_prompt  ="" ;
String third_name_loc_lang_prompt   ="" ;
String family_name_loc_lang_prompt  ="" ;
String name_suffix_loc_lang_prompt  ="" ;
String head_patient_name = "";
String mail_res_area_desc = ""; //added by Dheeraj
String mail_res_town_desc = ""; //added by Dheeraj
String language_name  = "";
//String LANGUAGE_ID = ""; 

ArrayList contact_addr = fetchContactAddresses(con, out,"parent.parent.messageFrame",p) ;
String[] contact_col_names = (String[])contact_addr.get(1) ;
String[] contact_prompts   = (String[])contact_addr.get(2) ;
String Addr_val = "";
String related_Addr_val = ""; // added by Dheeraj
String nKin_Addr_val = ""; // added by Dheeraj
String data_source = "";
//Added by kumar on 17/03/2003 for Malaysia Enhancements
String mail_region_desc = "", region_desc = "", race_long_desc = "",ethnic_long_desc="";
//End of Code

////////////////////////////////////////////////////////////// suresh 16/08/2003
String contact1_birth_date="";

String nkin_town_desc="";
String fton_town_desc="";
String emplr_town_desc="";

String nkin_area_desc="";
String fton_area_desc="";	
String emplr_area_desc="";	

String nkin_region_desc="";
String fton_region_desc="";
String emplr_region_desc="";

String nkin_mob_tel_no="";
String fton_mob_tel_no="";

String nkin_email_id="";
String fton_email_id="";

String organization_name="";
String emplr_ocpn_class_desc="";

String demo_oth_alt_id_desc="";
String demo_oth_alt_id_no="";

String fton_alt_desc="";
String fton_alt_id_no="";

String nkin_oth_alt_desc="";
String nkin_oth_alt_id_no="";

/* Friday, April 30, 2010 venkat s PE_EXE
String aid2=null;
String aid3=null;
String aid4=null; */
String contact1_alt_id1_type="";		
String contact1_alt_id1_no="";		
String alt_id1_exp_date_accept_yn = "";
String alt_id2_exp_date_accept_yn = "";
String alt_id3_exp_date_accept_yn = "";
String alt_id4_exp_date_accept_yn = "";
String accept_oth_alt_id_yn = "";
String contact1_alt_id2_type="";		
String contact1_alt_id2_no="";		
String contact1_alt_id3_type="";		
String contact1_alt_id3_no="";		
String contact1_alt_id4_type="";		
String contact1_alt_id4_no="";	
String contact1_nat_id_no="";	
String fton_nat_id_no="";	
String doc_or_file="";	

//Newly added on 13/02/2012 by Saanthaakumar  ---> SCF NO : RUT-SCF-0062 [30973]
String create_file_yn="";


String names_in_oth_lang_yn="";	
//Newly added by shyam on 21/02/2006
String MembershipType="";	
String Orgsubname="";	
String Orgname="";	
String patexpirtydate="";
String accept_national_id_no_yn="";

String  doc1_exp_date="";
String  doc1_iss_date="";
String  doc2_exp_date="";
String  doc2_iss_date="";
String  doc3_exp_date="";
String  doc3_iss_date="";
String  doc4_exp_date="";
String  doc4_iss_date="";

String blood_grp_desc=" ";
String rh_factor_desc=" ";

String contactModeOne = "";
String contactModeTwo = "";
// Tuesday, May 04, 2010  PE_EXE Venkat S 
String doc1_type_desc="";
String doc1_num="";
String doc1_place_of_issue="";

String doc2_type_desc="";
String doc2_num="";
String doc2_place_of_issue="";

String doc3_type_desc="";
String doc3_num="";
String doc3_place_of_issue="";

String doc4_type_desc="";
String doc4_num="";
String doc4_place_of_issue="";
int file_cnt=0;
/* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
InputStream  doc1=null; 
InputStream  doc2=null; 
InputStream  doc3=null; 
InputStream  doc4=null; 
/* end PMG2012-CRF-0006 [IN034693] */ 

//for Hijri MMS-QH-CRF-0145
String hijri_birth_date="";  
Boolean hijirisitespecifApplicable = CommonBean.isSiteSpecific(con, "MP","CAL_HIJ_APP");
boolean chkAadhaarValidate = CommonBean.isSiteSpecific(con, "MP","AADHAAR_PROFILE");
// end  PE_EXE 
/*
	HashMap hash_mp_param=new HashMap();
	hash_mp_param=eMP.NewbornDetails.getNewBornRelMandatory(con,p);
*/
sql.append("SELECT nvl(Alt_Id1_reqd_yn,'N') Alt_Id1_reqd_yn, nvl(Alt_Id2_reqd_yn,'N') Alt_Id2_reqd_yn, nvl(Alt_Id3_reqd_yn,'N') Alt_Id3_reqd_yn, nvl(Alt_Id4_reqd_yn,'N') Alt_Id4_reqd_yn, Alt_Id1_type, Alt_Id2_type, Alt_Id3_type, Alt_Id4_type, nvl(First_Name_Accept_Yn,'N') First_Name_Accept_Yn , nvl(First_Name_Order,'0') First_Name_Order, nvl(First_Name_Prompt,'First Name') First_Name_Prompt, nvl(Second_Name_Accept_Yn,'N') Second_Name_Accept_Yn, nvl(Second_Name_Order,'0') Second_Name_Order, nvl(Second_Name_Prompt,'Second Name') Second_Name_Prompt, nvl(Third_Name_Accept_Yn,'N') Third_Name_Accept_Yn, nvl(Third_Name_Order,'0') Third_Name_Order, nvl(Third_Name_Prompt,'Third Name') Third_Name_Prompt, nvl(Family_Name_Accept_Yn,'N') Family_Name_Accept_Yn, nvl(Family_Name_Order,'0') Family_Name_Order, nvl(Family_Name_Prompt,'Family Name') Family_Name_Prompt, name_dervn_logic, nvl(Alt_Id1_length,'0') Alt_Id1_length, nvl(Alt_Id2_length,'0') Alt_Id2_length, nvl(Alt_Id3_length,'0') Alt_Id3_length, nvl(Alt_Id4_length,'0') Alt_Id4_length, nvl(name_suffix_accept_yn,'N') name_suffix_accept_yn, nvl(name_prefix_accept_yn,'N') name_prefix_accept_yn, nvl(name_suffix_prompt,'Name Suffix') name_suffix_prompt, nvl(name_prefix_prompt,'Name Prefix') name_prefix_prompt, nvl(first_name_reqd_yn,'N') first_name_reqd_yn, nvl(second_name_reqd_yn,'N') second_name_reqd_yn, nvl(third_name_reqd_yn,'N') third_name_reqd_yn, nvl(family_name_reqd_yn,'N') family_name_reqd_yn, nvl(name_suffix_reqd_yn,'N') name_suffix_reqd_yn, nvl(name_prefix_reqd_yn,'N') name_prefix_reqd_yn, nvl(family_no_link_yn,'N') family_no_link_yn, nvl(patient_id_length,0) patient_id_length, nvl(citizen_nationality_code,'') citizen_nationality_code, nvl(Alt_Id1_Unique_yn,'N') Alt_Id1_Unique_yn, nvl(Alt_Id2_Unique_yn,'N') Alt_Id2_Unique_yn, nvl(Alt_Id3_Unique_yn,'N') Alt_Id3_Unique_yn, nvl(Alt_Id4_Unique_yn,'N') Alt_Id4_Unique_yn, nat_id_length, nvl(ALT_ID1_LEN_VALIDATION_YN,'N') ALT_ID1_LEN_VALIDATION_YN, nvl(ALT_ID2_LEN_VALIDATION_YN,'N') ALT_ID2_LEN_VALIDATION_YN, nvl(ALT_ID3_LEN_VALIDATION_YN,'N') ALT_ID3_LEN_VALIDATION_YN, nvl(ALT_ID4_LEN_VALIDATION_YN,'N') ALT_ID4_LEN_VALIDATION_YN, alt_id1_exp_date_accept_yn, alt_id2_exp_date_accept_yn, alt_id3_exp_date_accept_yn, alt_id4_exp_date_accept_yn, alt_id1_routine_yn, alt_id1_data_source_id alt_id1_routine, alt_id2_routine_yn, alt_id2_data_source_id alt_id2_routine, alt_id3_routine_yn, alt_id3_data_source_id  alt_id3_routine, alt_id4_routine_yn, alt_id4_data_source_id  alt_id4_routine, NAT_ID_PAT_SER_GRP, nvl(ID_CHANGE_ALLOWED_FOR_SERIES,'*') ID_CHANGE_ALLOWED_FOR_SERIES, nvl(ADDL_FIELD1_PROMPT,'') ADDL_FIELD1_PROMPT, nvl(ADDL_FIELD1_LENGTH,'0') ADDL_FIELD1_LENGTH, nvl(ADDL_FIELD1_SECTION,'') ADDL_FIELD1_SECTION, nvl(ADDL_FIELD2_PROMPT,'') ADDL_FIELD2_PROMPT, nvl(ADDL_FIELD2_LENGTH ,'0') ADDL_FIELD2_LENGTH, nvl(ADDL_FIELD2_SECTION ,'') ADDL_FIELD2_SECTION, nvl(ADDL_FIELD3_PROMPT ,'') ADDL_FIELD3_PROMPT, nvl(ADDL_FIELD3_LENGTH ,'0') ADDL_FIELD3_LENGTH, nvl(ADDL_FIELD3_SECTION ,'') ADDL_FIELD3_SECTION, nvl(ADDL_FIELD4_PROMPT ,'') ADDL_FIELD4_PROMPT, nvl(ADDL_FIELD4_LENGTH,'0') ADDL_FIELD4_LENGTH, nvl(ADDL_FIELD4_SECTION ,'') ADDL_FIELD4_SECTION, nvl(ADDL_FIELD5_PROMPT,'') ADDL_FIELD5_PROMPT, nvl(ADDL_FIELD5_LENGTH ,'0') ADDL_FIELD5_LENGTH, nvl(ADDL_FIELD5_SECTION ,'') ADDL_FIELD5_SECTION, nvl(nat_id_prompt,'National Id No') nat_id_prompt, nvl(NAT_ID_CHK_LEN,'N') NAT_ID_CHK_LEN, nat_id_check_digit_id,  alt_id1_chk_digit_scheme, alt_id2_chk_digit_scheme, alt_id3_chk_digit_scheme, alt_id4_chk_digit_scheme, nvl(NAME_PREFIX_LOC_LANG_PROMPT,'&nbsp;') NAME_PREFIX_LOC_LANG_PROMPT, nvl(FIRST_NAME_LOC_LANG_PROMPT,'&nbsp;') FIRST_NAME_LOC_LANG_PROMPT, nvl(SECOND_NAME_LOC_LANG_PROMPT,'&nbsp;') SECOND_NAME_LOC_LANG_PROMPT, nvl(THIRD_NAME_LOC_LANG_PROMPT,'&nbsp;') THIRD_NAME_LOC_LANG_PROMPT, nvl(FAMILY_NAME_LOC_LANG_PROMPT,'&nbsp;') FAMILY_NAME_LOC_LANG_PROMPT, nvl(NAME_SUFFIX_LOC_LANG_PROMPT,'&nbsp;') NAME_SUFFIX_LOC_LANG_PROMPT, accept_national_id_no_yn, alt_id1_accept_oth_pat_ser_yn, alt_id1_accept_alphanumeric_yn, invoke_routine, nat_data_source_id, max_patient_age, name_dervn_logic_oth_lang, pat_name_as_multipart_yn, nat_id_reqd_all_series, Accept_oth_alt_id_yn, alt_id1.long_desc alt_id1_desc, alt_id2.long_desc alt_id2_desc, alt_id3.long_desc alt_id3_desc, alt_id4.long_desc alt_id4_desc, ext_system_interface_yn, default_race_code, names_in_oth_lang_yn, to_char(sysdate,'dd/mm/yyyy') ServerDate, dflt_alt_id1_in_emp_id_yn, nb_mother_cutoff_age,create_file_yn,maintain_doc_or_file,family_org_id_accept_yn,entitlement_by_pat_cat_yn FROM mp_param_lang_vw, mp_alternate_id_type_lang_vw alt_id1, mp_alternate_id_type_lang_vw alt_id2, mp_alternate_id_type_lang_vw alt_id3, mp_alternate_id_type_lang_vw alt_id4 WHERE alt_id1_type = alt_id1.alt_id_type AND alt_id2_type = alt_id2.alt_id_type(+) AND alt_id3_type = alt_id3.alt_id_type(+) AND alt_id4_type = alt_id4.alt_id_type(+) and alt_id1.language_id(+) = '"+locale+"' and alt_id2.language_id(+) = '"+locale+"' and alt_id3.language_id(+) = '"+locale+"' and alt_id4.language_id(+) = '"+locale+"' and mp_param_lang_vw.language_id = '"+locale+"'" );

pstmt = con.prepareStatement(sql.toString());
rs=pstmt.executeQuery(); 

if(rs != null) {
    if(rs.next()) {
        Alt_Id1_Type = rs.getString("Alt_Id1_Type")==null ? "" : rs.getString("alt_id1_desc");
        Alt_Id2_Type = rs.getString("Alt_Id2_Type")==null ? "" : rs.getString("alt_id2_desc");
        Alt_Id3_Type = rs.getString("Alt_Id3_Type")==null ? "" : rs.getString("alt_id3_desc");
        Alt_Id4_Type = rs.getString("Alt_Id4_Type")==null ? "" : rs.getString("alt_id4_desc");
		
		alt_id1_exp_date_accept_yn = rs.getString("alt_id1_exp_date_accept_yn")==null ? "" : rs.getString("alt_id1_exp_date_accept_yn");

		alt_id2_exp_date_accept_yn = rs.getString("alt_id2_exp_date_accept_yn")==null ? "" : rs.getString("alt_id2_exp_date_accept_yn");
			
		alt_id3_exp_date_accept_yn = rs.getString("alt_id3_exp_date_accept_yn")==null ? "" : rs.getString("alt_id3_exp_date_accept_yn");

		alt_id4_exp_date_accept_yn = rs.getString("alt_id4_exp_date_accept_yn")==null ? "" : rs.getString("alt_id4_exp_date_accept_yn");

		accept_oth_alt_id_yn = rs.getString("accept_oth_alt_id_yn")==null ? "" : rs.getString("accept_oth_alt_id_yn");
		names_in_oth_lang_yn = rs.getString("names_in_oth_lang_yn")==null ? "N" : rs.getString("names_in_oth_lang_yn");

		First_Name_Accept_Yn = rs.getString("First_Name_Accept_Yn")==null ? "N" : rs.getString("First_Name_Accept_Yn");
        First_Name_Order = rs.getInt("First_Name_Order");
        First_Name_Prompt = rs.getString("First_Name_Prompt") == null ? "" : rs.getString("First_Name_Prompt");
        Second_Name_Accept_Yn = rs.getString("Second_Name_Accept_Yn")==null ? "N" : rs.getString("Second_Name_Accept_Yn");
        Second_Name_Order = rs.getInt("Second_Name_Order");
        Second_Name_Prompt = rs.getString("Second_Name_Prompt") == null ? "" : rs.getString("Second_Name_Prompt");
        Third_Name_Accept_Yn = rs.getString("Third_Name_Accept_Yn")==null ? "N" : rs.getString("Third_Name_Accept_Yn");
        Third_Name_Order = rs.getInt("Third_Name_Order");
        Third_Name_Prompt = rs.getString("Third_Name_Prompt") == null ? "" : rs.getString("Third_Name_Prompt");
        Family_Name_Accept_Yn = rs.getString("Family_Name_Accept_Yn")==null ? "N" : rs.getString("Family_Name_Accept_Yn");
        Family_Name_Order = rs.getInt("Family_Name_Order");
        Family_Name_Prompt = rs.getString("Family_Name_Prompt")== null ? "" : rs.getString("Family_Name_Prompt");

        Name_Prefix_Accept_Yn = rs.getString("Name_Prefix_Accept_Yn");
        Name_Suffix_Accept_Yn = rs.getString("Name_Suffix_Accept_Yn");
        Name_Prefix_Prompt = rs.getString("Name_Prefix_Prompt");
        Name_Suffix_Prompt = rs.getString("Name_Suffix_Prompt");

        Family_No_Link_Yn = rs.getString("family_no_link_yn");
        
        cust_fields[0] = rs.getString("addl_field1_section")+"`"+rs.getString("ADDL_FIELD1_PROMPT");
        cust_fields[1] = rs.getString("addl_field2_section")+"`"+rs.getString("ADDL_FIELD2_PROMPT");
        cust_fields[2] = rs.getString("addl_field3_section")+"`"+rs.getString("ADDL_FIELD3_PROMPT");
        cust_fields[3] = rs.getString("addl_field4_section")+"`"+rs.getString("ADDL_FIELD4_PROMPT");
        cust_fields[4] = rs.getString("addl_field5_section")+"`"+rs.getString("ADDL_FIELD5_PROMPT");
        nat_id_prompt = rs.getString("nat_id_prompt");
        
        name_prefix_loc_lang_prompt     =rs.getString("name_prefix_loc_lang_prompt");
        first_name_loc_lang_prompt      =rs.getString("first_name_loc_lang_prompt");
        second_name_loc_lang_prompt     =rs.getString("second_name_loc_lang_prompt");
        third_name_loc_lang_prompt      =rs.getString("third_name_loc_lang_prompt");
        family_name_loc_lang_prompt     =rs.getString("family_name_loc_lang_prompt");
        name_suffix_loc_lang_prompt     =rs.getString("name_suffix_loc_lang_prompt");
        doc_or_file						=rs.getString("maintain_doc_or_file");
		
		//Newly added on 13/02/2012 by Saanthaakumar  ---> SCF NO : RUT-SCF-0062 [30973]
		create_file_yn					=rs.getString("create_file_yn");
		
		
        accept_national_id_no_yn						=rs.getString("accept_national_id_no_yn");
        family_org_id_accept_yn						=rs.getString("family_org_id_accept_yn")==null?"":rs.getString("family_org_id_accept_yn");
        entitlement_by_pat_cat_yn						=rs.getString("entitlement_by_pat_cat_yn")==null?"":rs.getString("entitlement_by_pat_cat_yn");	
    }
}
%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
<meta http-equiv="Expires" content="0">
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
<Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
<Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<Script src="../js/ViewPatDetails.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/calScript/hj/calendar.js" language="JavaScript"></Script>


<script language="JavaScript">
function showPatientPhoto() {
	var view_photo_yn = "<%=view_pat_photo_yn%>";
	if (view_photo_yn=="Y")
	{
		document.patient_photo.src = document.patient_photo.src ;
		document.patient_photo.src = document.patient_photo.src ;
		document.patient_photo.src = document.patient_photo.src ;
	}
}
function f1()
 {
	 parent.patient_main.document.getElementById('refrel').click()
 }
/*
function lockKey()
{
	if(event.keyCode == 93 || event.keyCode ==32)
	{
		alert(getMessage('WELCOME','Common'));
		event.returnValue=false;
		}
}
*/
	function tab_click2(id,idval){
			//selectTab(idval);
			tab_click1(id);
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onSelect="codeArrestThruSelect()" OnMouseDown="CodeArrest();" onKeyDown='lockKey()'>
<form name='PatRegForm' id='PatRegForm' method='post'>
<a name='demo' id='name'></a>
<%
try{ 
	try{   
  sql2.append("SELECT patient.patient_name Patient_Name, patient.pat_ser_grp_code pat_ser_grp_code, (CASE WHEN patient.pat_ser_grp_code IS NOT NULL THEN (mp_get_desc.mp_pat_ser_grp(patient.pat_ser_grp_code,'"+locale+"',2)) END ) pat_ser_grp_desc, NVL(pat_ser_grp.ID_TYPE, '') ID_TYPE, pat_ser_grp.allow_family_no_yn, pat_ser_grp.pat_name_in_loc_lang_reqd_yn, patient.national_id_no national_id_no, patient.pref_facility_id pref_facility_id, (CASE WHEN patient.pref_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.pref_facility_id, '"+locale+"', 1)) END ) pref_facility_name, patient.regn_facility_id regn_facility_id, (CASE WHEN patient.regn_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.regn_facility_id, '"+locale+"', 1)) END ) regn_facility_name, patient.alt_id1_type alt_id1_type, (CASE WHEN patient.alt_id1_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id1_type,'"+locale+"',1)) END ) alt_id1_desc, patient.alt_id1_no alt_id1_no, to_char(patient.alt_id1_exp_date,'dd/mm/yyyy') alt_id1_exp_date, patient.alt_id2_type alt_id2_type, (CASE WHEN patient.alt_id2_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id2_type,'"+locale+"',2)) END ) alt_id2_desc, patient.alt_id2_no alt_id2_no, to_char(patient.alt_id2_exp_date,'dd/mm/yyyy') alt_id2_exp_date, patient.alt_id3_type alt_id3_type, (CASE WHEN patient.alt_id3_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id3_type,'"+locale+"',2)) END ) alt_id3_desc, patient.alt_id3_no alt_id3_no, to_char(patient.alt_id3_exp_date,'dd/mm/yyyy') alt_id3_exp_date, patient.alt_id4_type alt_id4_type, (CASE WHEN patient.alt_id4_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.alt_id4_type,'"+locale+"',2)) END ) alt_id4_desc, patient.alt_id4_no alt_id4_no, to_char(patient.alt_id4_exp_date,'dd/mm/yyyy') alt_id4_exp_date, patient.oth_alt_id_type oth_alt_id_type, (CASE WHEN patient.oth_alt_id_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(patient.oth_alt_id_type,'"+locale+"',1)) END ) demo_oth_alt_id_desc, patient.oth_alt_id_no demo_oth_alt_id_no, patient.family_link_no family_link_no, (CASE WHEN patient.family_link_no IS NOT NULL THEN (mp_get_desc.mp_patient(patient.family_link_no,1)) END ) head_patient_name, patient.relationship_to_head relationship_to_head, (CASE WHEN patient.relationship_to_head IS NOT NULL THEN (mp_get_desc.mp_relationship(patient.relationship_to_head,'"+locale+"',2)) END ) relationship_name, patient.name_prefix name_prefix, patient.first_name first_name, patient.second_name second_name, patient.third_name third_name, patient.family_name family_name, patient.name_suffix name_suffix, patient.name_prefix_loc_lang name_prefix_loc_lang, patient.first_name_loc_lang first_name_loc_lang, patient.second_name_loc_lang second_name_loc_lang, patient.third_name_loc_lang third_name_loc_lang, patient.family_name_loc_lang family_name_loc_lang, patient.name_suffix_loc_lang name_suffix_loc_lang, patient.patient_name_loc_lang patient_name_loc_lang, patient.sex sex, to_char(patient.date_of_birth, 'dd/mm/yyyy') date_of_birth, patient.calculated_age_yn calculated_age_yn, patient.birth_place_code birth_place_code, (CASE WHEN patient.birth_place_code IS NOT NULL THEN (mp_get_desc.mp_birth_place(patient.birth_place_code,'"+locale+"',1))  END ) birth_place_desc, patient.place_of_birth place_of_birth, patient.mar_status_code mar_status_code, (CASE WHEN patient.mar_status_code IS NOT NULL THEN (mp_get_desc.mp_marital_status(patient.mar_status_code,'"+locale+"',2)) END ) mar_status_desc, patient.alias_name alias_name, patient.relgn_code relgn_code, (CASE WHEN patient.relgn_code IS NOT NULL THEN (mp_get_desc.mp_religion(patient.relgn_code,'"+locale+"',2)) END ) relgn_desc, patient.ethnic_grp_code ethnic_grp_code, (CASE WHEN patient.ethnic_grp_code IS NOT NULL THEN (mp_get_desc.mp_ethnic_group(patient.ethnic_grp_code,'"+locale+"',2)) END ) ethnic_short_desc, (CASE WHEN patient.ethnic_grp_code IS NOT NULL THEN (mp_get_desc.mp_ethnic_group(patient.ethnic_grp_code,'"+locale+"',1)) END ) ethnic_long_desc, patient.race_code race_code, (CASE WHEN patient.race_code IS NOT NULL THEN (mp_get_desc.mp_race(patient.race_code,'"+locale+"',2)) END ) race_short_desc, (CASE WHEN patient.race_code IS NOT NULL THEN (mp_get_desc.mp_race(patient.race_code,'"+locale+"',1)) END ) race_long_desc, patient.citizen_yn CITIZEN_YN, patient.legal_yn LEGAL_YN, patient.nationality_code nationality_code, (CASE WHEN patient.nationality_code IS NOT NULL THEN (mp_get_desc.mp_country(patient.nationality_code,'"+locale+"',3)) END ) nationality_desc, patient.mother_maiden_name mother_maiden_name, patient.pat_cat_code pat_cat_code, (CASE WHEN patient.pat_cat_code IS NOT NULL THEN (mp_get_desc.mp_pat_category(patient.pat_cat_code,'"+locale+"',2)) END ) pat_cat_desc, patient.referral_facility_id referral_facility_id, patient.ref_source_code ref_source_code, NULL ref_source_desc, pat_addr.addr1_line1 resi_addr_line1, pat_addr.addr1_line2 resi_addr_line2, pat_addr.addr1_line3 resi_addr_line3, pat_addr.addr1_line4 resi_addr_line4, mp_get_desc.mp_postal_code(pat_addr.postal1_code,'"+locale+"',2) resi_postal_code, pat_addr.country1_code resi_country_code, (CASE WHEN pat_addr.country1_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_addr.country1_code,'"+locale+"',1)) END ) resi_country_name, pat_addr.invalid1_yn resi_invalid1_yn, pat_addr.contact1_name resi_contact1_name, patient.res_area_code res_area_code, (CASE WHEN patient.res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(patient.res_area_code,'"+locale+"',2)) END ) res_area_desc, (CASE WHEN patient.res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(patient.res_area_code,'"+locale+"',1)) END ) res_area_long_desc, patient.res_town_code res_town_code, (CASE WHEN patient.res_town_code IS NOT NULL  THEN (mp_get_desc.mp_res_town(patient.res_town_code,'"+locale+"',2)) END ) res_town_desc, (CASE WHEN patient.res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(patient.res_town_code,'"+locale+"',1)) END ) res_town_long_desc, patient.region_code region_code, (CASE WHEN patient.region_code IS NOT NULL THEN (mp_get_desc.mp_region(patient.region_code,'"+locale+"',2)) END ) region_desc, (CASE WHEN patient.region_code IS NOT NULL THEN (mp_get_desc.mp_region(patient.region_code,'"+locale+"',1)) END ) region_long_desc, pat_addr.addr2_line1 mail_addr_line1, pat_addr.addr2_line2 mail_addr_line2, pat_addr.addr2_line3 mail_addr_line3, pat_addr.addr2_line4 mail_addr_line4, mp_get_desc.mp_postal_code(pat_addr.postal2_code,'"+locale+"',2) mail_postal_code, pat_addr.country2_code mail_country_code, (CASE WHEN pat_addr.country2_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_addr.country2_code,'"+locale+"',1)) END ) mail_country_name, pat_addr.invalid2_yn mail_invalid1_yn, pat_addr.contact2_name mail_contact1_name, pat_addr.res_area2_code mail_res_area, (CASE WHEN pat_addr.res_area2_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_addr.res_area2_code,'"+locale+"',2)) END ) mail_res_area_desc, (CASE WHEN pat_addr.res_area2_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_addr.res_area2_code,'"+locale+"',1)) END ) mail_res_area_long_desc, pat_addr.res_town2_code mail_res_town, (CASE WHEN pat_addr.res_town2_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_addr.res_town2_code,'"+locale+"',2)) END ) mail_res_town_desc, (CASE WHEN pat_addr.res_town2_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_addr.res_town2_code,'"+locale+"',1))            END ) mail_res_town_long_desc, pat_addr.region2_code mail_region_code, (CASE WHEN pat_addr.region2_code IS NOT NULL  THEN (mp_get_desc.mp_region(pat_addr.region2_code,'"+locale+"',2)) END ) mail_region_desc, (CASE WHEN pat_addr.region2_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_addr.region2_code,'"+locale+"',1)) END ) mail_region_long_desc, patient.contact1_no prn_tel_no, patient.contact2_no orn_tel_no, patient.email_id email_id, patient.contact3_mode contact3_mode, (CASE WHEN patient.contact3_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(patient.contact3_mode,'"+locale+"',2)) END ) contact3_mode_desc, patient.contact3_no contact3_no, patient.contact4_mode contact4_mode, (CASE WHEN patient.contact4_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(patient.contact4_mode,'"+locale+"',2)) END ) contact4_mode_desc, patient.contact4_no contact4_no, patient.contact5_mode contact5_mode, (CASE WHEN patient.contact5_mode IS NOT NULL THEN (mp_get_desc.mp_contact_mode(patient.contact5_mode,'"+locale+"',2)) END ) contact5_mode_desc, patient.contact5_no contact5_no, pat_rl_con.contact1_name nkin_contact_name, pat_rl_con.job1_title nkin_job_title, pat_rl_con.contact1_relation nkin_contact_relation, (CASE WHEN pat_rl_con.contact1_relation IS NOT NULL THEN (mp_get_desc.mp_relationship(pat_rl_con.contact1_relation,'"+locale+"',2)) END ) nkin_contact_relation_desc,  to_char(pat_rl_con.contact1_birth_date, 'dd/mm/yyyy') contact1_birth_date, pat_rl_con.contact1_nat_id_no, pat_rl_con.contact1_alt_id1_type, (CASE WHEN pat_rl_con.contact1_alt_id1_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id1_type,'"+locale+"',2)) END ) nkin_alt_id1_desc, pat_rl_con.contact1_alt_id1_no, pat_rl_con.contact1_alt_id2_type, (CASE WHEN pat_rl_con.contact1_alt_id2_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id2_type,'"+locale+"',2)) END ) nkin_alt_id2_desc, pat_rl_con.contact1_alt_id2_no, pat_rl_con.contact1_alt_id3_type, (CASE WHEN pat_rl_con.contact1_alt_id3_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id3_type,'"+locale+"',2)) END ) nkin_alt_id3_desc,  pat_rl_con.contact1_alt_id3_no, pat_rl_con.contact1_alt_id4_type, (CASE WHEN pat_rl_con.contact1_alt_id4_type IS NOT NULL   THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_alt_id4_type,'"+locale+"',2)) END ) nkin_alt_id4_desc, pat_rl_con.contact1_alt_id4_no, pat_rl_con.contact1_oth_alt_id_type, (CASE WHEN pat_rl_con.contact1_oth_alt_id_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact1_oth_alt_id_type,'"+locale+"',1)) END ) nkin_oth_alt_desc, pat_rl_con.contact1_oth_alt_id_no nkin_oth_alt_id_no, pat_rl_con.addr1_line1 nkin_addr_line1,  pat_rl_con.addr1_line2 nkin_addr_line2, pat_rl_con.addr1_line3 nkin_addr_line3, pat_rl_con.addr1_line4 nkin_addr_line4, pat_rl_con.contact1_res_town_code, (CASE WHEN pat_rl_con.contact1_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact1_res_town_code,'"+locale+"',2)) END ) nkin_town_desc, (CASE WHEN pat_rl_con.contact1_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact1_res_town_code,'"+locale+"',1)) END ) nkin_town_long_desc, pat_rl_con.contact1_res_area_code, (CASE WHEN pat_rl_con.contact1_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact1_res_area_code,'"+locale+"',2)) END ) nkin_area_desc, (CASE WHEN pat_rl_con.contact1_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact1_res_area_code,'"+locale+"',1)) END ) nkin_area_long_desc, pat_rl_con.contact1_region_code, (CASE WHEN pat_rl_con.contact1_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact1_region_code,'"+locale+"',2)) END ) nkin_region_desc, (CASE WHEN pat_rl_con.contact1_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact1_region_code,'"+locale+"',1)) END ) nkin_region_long_desc,mp_get_desc.mp_postal_code(pat_rl_con.postal1_code,'"+locale+"',2)  nkin_postal_code, pat_rl_con.country1_code nkin_country_code, (CASE WHEN pat_rl_con.country1_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.country1_code,'"+locale+"',1))  END ) nkin_country_name, pat_rl_con.res1_tel_no nkin_res_tel_no, pat_rl_con.off1_tel_no nkin_off_tel_no, pat_rl_con.contact1_mob_tel_no nkin_mob_tel_no, pat_rl_con.contact1_email_id nkin_email_id, pat_rl_con.contact2_relation fton_contact_relation, (CASE WHEN pat_rl_con.contact2_relation IS NOT NULL THEN (mp_get_desc.mp_relationship(pat_rl_con.contact2_relation,'"+locale+"',2)) END ) fton_contact_relation_desc,  pat_rl_con.contact2_name fton_contact_name, pat_rl_con.contact2_nat_id_no fton_nat_id_no, pat_rl_con.contact2_oth_alt_id_type, (CASE WHEN pat_rl_con.contact2_oth_alt_id_type IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(pat_rl_con.contact2_oth_alt_id_type,'"+locale+"',1)) END ) fton_alt_desc, pat_rl_con.contact2_oth_alt_id_no fton_alt_id_no, pat_rl_con.job2_title fton_job_title, pat_rl_con.addr2_line1 fton_addr_line1, pat_rl_con.addr2_line2 fton_addr_line2, pat_rl_con.addr2_line3 fton_addr_line3, pat_rl_con.addr2_line4 fton_addr_line4, pat_rl_con.contact2_res_town_code, (CASE WHEN pat_rl_con.contact2_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact2_res_town_code,'"+locale+"',2)) END ) fton_town_desc, (CASE WHEN pat_rl_con.contact2_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact2_res_town_code,'"+locale+"',1)) END ) fton_town_long_desc, pat_rl_con.contact2_res_area_code, (CASE WHEN pat_rl_con.contact2_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact2_res_area_code,'"+locale+"',2)) END ) fton_area_desc, (CASE WHEN pat_rl_con.contact2_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact2_res_area_code,'"+locale+"',1)) END ) fton_area_long_desc, pat_rl_con.contact2_region_code, (CASE WHEN pat_rl_con.contact2_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact2_region_code,'"+locale+"',2)) END ) fton_region_desc, (CASE WHEN pat_rl_con.contact2_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact2_region_code,'"+locale+"',1)) END ) fton_region_long_desc, mp_get_desc.mp_postal_code(pat_rl_con.postal2_code,'"+locale+"',2) fton_postal_code, pat_rl_con.country2_code fton_country_code,          (CASE WHEN pat_rl_con.country2_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.country2_code,'"+locale+"',1)) END ) fton_country_name, pat_rl_con.contact2_mob_tel_no fton_mob_tel_no, pat_rl_con.contact2_email_id fton_email_id, pat_rl_con.res2_tel_no fton_res_tel_no, pat_rl_con.off2_tel_no fton_off_tel_no, pat_rl_con.organization_name,   pat_rl_con.patient_employee_id patient_employee_id,pat_rl_con.employment_status employment_status, pat_rl_con.contact3_name emplr_contact_name, pat_rl_con.job3_title emplr_job_title, pat_rl_con.contact3_relation emplr_contact_relation, (CASE WHEN pat_rl_con.contact3_relation IS NOT NULL THEN (mp_get_desc.mp_relationship(pat_rl_con.contact3_relation,'"+locale+"',2)) END ) emplr_contact_relation_desc,           pat_rl_con.ocpn_class_code, (CASE WHEN pat_rl_con.ocpn_class_code IS NOT NULL THEN (mp_get_desc.mp_occupation_class(pat_rl_con.ocpn_class_code,'"+locale+"',1)) END ) emplr_ocpn_class_desc,           pat_rl_con.ocpn_code ocpn_code, (CASE WHEN pat_rl_con.ocpn_code IS NOT NULL THEN (mp_get_desc.mp_occupation(pat_rl_con.ocpn_code,'"+locale+"',2))  ELSE ocpn_desc END ) occupation_desc,   pat_rl_con.addr3_line1 emplr_addr_line1, pat_rl_con.addr3_line2 emplr_addr_line2, pat_rl_con.addr3_line3 emplr_addr_line3,  pat_rl_con.addr3_line4 emplr_addr_line4, pat_rl_con.contact3_res_town_code, (CASE WHEN pat_rl_con.contact3_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact3_res_town_code,'"+locale+"',2)) END ) emplr_town_desc, (CASE WHEN pat_rl_con.contact3_res_town_code IS NOT NULL THEN (mp_get_desc.mp_res_town(pat_rl_con.contact3_res_town_code,'"+locale+"',1)) END ) emplr_town_long_desc, pat_rl_con.contact3_res_area_code, (CASE WHEN pat_rl_con.contact3_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact3_res_area_code,'"+locale+"',2)) END ) emplr_area_desc, (CASE WHEN pat_rl_con.contact3_res_area_code IS NOT NULL THEN (mp_get_desc.mp_res_area(pat_rl_con.contact3_res_area_code,'"+locale+"',1)) END ) emplr_area_long_desc, pat_rl_con.contact3_region_code, (CASE WHEN pat_rl_con.contact3_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact3_region_code,'"+locale+"',2)) END ) emplr_region_desc, (CASE WHEN pat_rl_con.contact3_region_code IS NOT NULL THEN (mp_get_desc.mp_region(pat_rl_con.contact3_region_code,'"+locale+"',1))    END ) emplr_region_long_desc,mp_get_desc.mp_postal_code(pat_rl_con.postal3_code,'"+locale+"',2)  emplr_postal_code, pat_rl_con.country3_code emplr_country_code, (CASE WHEN pat_rl_con.country3_code IS NOT NULL THEN (mp_get_desc.mp_country(pat_rl_con.country3_code,'"+locale+"',1))            END ) emplr_country_name, pat_rl_con.off3_tel_no emplr_off_tel_no, pat_rl_con.res3_tel_no emplr_res_tel_no, pat_rl_con.off_fax_no off_fax_no,pat_oth_dtls.living_dependency living_dependency, pat_oth_dtls.living_arrangement living_arrangement, mr_get_desc.mr_blood_grp(pat_oth_dtls.blood_grp,'"+locale+"',2) blood_grp_desc, mr_get_desc.mr_rhesus_factor(pat_oth_dtls.rh_factor,'"+locale+"',2) rh_factor_desc, pat_oth_dtls.education_level education_level, (CASE WHEN pat_oth_dtls.education_level IS NOT NULL THEN (mp_get_desc.mp_education_level(pat_oth_dtls.education_level,'"+locale+"',2)) END ) educ_level_desc, pat_oth_dtls.regn_informant informant, pat_oth_dtls.regn_comments informant_remarks, pat_oth_dtls.general_remarks general_remarks, patient.suspend_yn suspend_yn ,patient.hijri_birth_date hijri_birth_date, patient.status_reason_code status_reason_code, (CASE WHEN patient.status_reason_code IS NOT NULL THEN (mp_get_desc.mp_pat_susp_reason(patient.status_reason_code,'"+locale+"',2)) END ) status_reason_desc, patient.status_remarks status_remarks, patient.active_yn active_yn, to_char(patient.last_contact_date,'dd/mm/yyyy') last_contact_date, patient.deceased_yn deceased_yn, to_char(patient.deceased_date,'dd/mm/yyyy') deceased_date, patient.death_status_remarks death_status_remarks, patient.primary_language_id primary_language_id, patient.language_id pat_language_id,(CASE WHEN patient.language_id IS NOT NULL THEN (mp_get_desc.mp_language(patient.language_id,'"+locale+"',1)) END ) language_name,  pat_oth_dtls.addl_field1 addl_field1, (CASE WHEN pat_oth_dtls.addl_field1 IS NOT NULL THEN (SELECT addl_field1_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field1_prompt, (CASE WHEN pat_oth_dtls.addl_field2 IS NOT NULL THEN (SELECT addl_field2_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field2_prompt, pat_oth_dtls.addl_field2 addl_field2, (CASE WHEN pat_oth_dtls.addl_field3 IS NOT NULL THEN (SELECT addl_field3_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field3_prompt, pat_oth_dtls.addl_field3 addl_field3, (CASE WHEN pat_oth_dtls.addl_field4 IS NOT NULL THEN (SELECT addl_field4_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field4_prompt, pat_oth_dtls.addl_field4 addl_field4, (CASE WHEN pat_oth_dtls.addl_field5 IS NOT NULL THEN (SELECT addl_field5_prompt FROM mp_param_lang_vw where module_id = 'MP' and language_id = '"+locale+"') END ) addl_field5_prompt, pat_oth_dtls.addl_field5 addl_field5, patient.added_by_id, (CASE WHEN patient.added_by_id IS NOT NULL THEN (sm_get_desc.sm_appl_user(patient.added_by_id,'"+locale+"',1)) END ) added_user_name, TO_CHAR (patient.added_date, 'DD/MM/YYYY HH24:MI') added_date, patient.added_at_ws_no, patient.added_facility_id, (CASE WHEN patient.added_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.added_facility_id, '"+locale+"', 1))  END ) added_facility_name, patient.modified_by_id, (CASE WHEN patient.modified_by_id IS NOT NULL THEN (sm_get_desc.sm_appl_user(patient.modified_by_id,'"+locale+"',1)) END ) modified_user_name, TO_CHAR (patient.modified_date, 'DD/MM/YYYY HH24:MI') modified_date, patient.modified_at_ws_no, patient.modified_facility_id, (CASE WHEN patient.modified_facility_id IS NOT NULL THEN (sm_get_desc.sm_facility_param(patient.modified_facility_id, '"+locale+"', 1))END ) modified_facility_name, patient.pat_dtls_unknown_yn, patient.inhouse_birth_yn, patient.data_source data_source, MP_GET_AGE_YMDH(patient.date_of_birth,patient.deceased_date) age,/*  CALCULATE_AGE_HOURS(to_char(Date_Of_Birth,'dd/mm/yyyy hh24:mi:ss'),1)||'Y'|| CALCULATE_AGE_HOURS(to_char(Date_Of_Birth,'dd/mm/yyyy hh24:mi:ss'),2)||'M'||CALCULATE_AGE_HOURS(to_char(Date_Of_Birth,'dd/mm/yyyy hh24:mi:ss'),3)||'D'||CALCULATE_AGE_HOURS(to_char(Date_Of_Birth,'dd/mm/yyyy hh24:mi:ss'),4)||'H' age,*/ patient.FAMILY_ORG_MEMBERSHIP MembershipType, ( case when patient.FAMILY_ORG_SUB_ID is not null then (select FAMILY_ORG_SUB_NAME from mp_family_org_sub_lang_vw where FAMILY_ORG_ID = patient.FAMILY_ORG_ID and FAMILY_ORG_SUB_ID= patient.FAMILY_ORG_SUB_ID and language_id = '"+locale+"') end) Orgsubname, (case when patient.FAMILY_ORG_ID is not null then ( select FAMILY_ORG_NAME from MP_FAMILY_ORG_lang_vw where FAMILY_ORG_ID= patient.FAMILY_ORG_ID and language_id = '"+locale+"') end) Orgname, to_char(patient.PAT_CAT_CODE_EXP_DATE,'dd/mm/yyyy') patexpirtydate, ");  
  // Tuesday, May 04, 2010  PE_EXE Venkat S 
  sql2.append("(CASE WHEN f.doc1_type IS NOT NULL THEN(mp_get_desc.mp_document_type(f.doc1_type, '"+locale+"', 2)) END) doc1_type_desc,doc1_num,TO_CHAR(doc1_exp_date, 'DD/MM/YYYY') doc1_exp_date, doc1_place_of_issue, TO_CHAR(doc1_iss_date, 'DD/MM/YYYY') doc1_iss_date,");
  sql2.append("(CASE WHEN f.doc2_type IS NOT NULL THEN(mp_get_desc.mp_document_type(f.doc2_type, '"+locale+"',2)) END) doc2_type_desc, doc2_num, TO_CHAR(doc2_exp_date, 'DD/MM/YYYY') doc2_exp_date, doc2_place_of_issue, TO_CHAR(doc2_iss_date, 'DD/MM/YYYY') doc2_iss_date,");
  sql2.append("(CASE WHEN f.doc3_type IS NOT NULL THEN(mp_get_desc.mp_document_type(f.doc3_type, '"+locale+"', 2)) END) doc3_type_desc, doc3_num, TO_CHAR(doc3_exp_date, 'DD/MM/YYYY') doc3_exp_date, doc3_place_of_issue,       TO_CHAR(doc3_iss_date, 'DD/MM/YYYY') doc3_iss_date,");
  sql2.append("(CASE WHEN f.doc4_type IS NOT NULL THEN(mp_get_desc.mp_document_type(f.doc4_type, '"+locale+"', 2) ) END) doc4_type_desc, doc4_num, TO_CHAR(doc4_exp_date, 'DD/MM/YYYY') doc4_exp_date, doc4_place_of_issue,       TO_CHAR(doc4_iss_date, 'DD/MM/YYYY') doc4_iss_date,f.DOC1_IMAGE,f.DOC2_IMAGE,f.DOC3_IMAGE,f.DOC4_IMAGE,");


  if(group_status.equals(""))
  {   
	  if(disp_dup_pat_dtls.equals("Duplicate"))
	  {
		    sql2.append("(select count(file_no) from mr_pat_file_index WHERE facility_id = '"+Facility_Id+"' AND patient_id = patient.valid_patient_id) file_cnt, ");
			sql2.append(" patient.DUPLICATE_PATIENT_ID Patient_id FROM DR_MP_PATIENT patient, DR_MP_PAT_ADDRESSES pat_addr, DR_MP_PAT_REL_CONTACTS pat_rl_con, DR_MP_PAT_OTH_DTLS pat_oth_dtls, mp_pat_ser_grp pat_ser_grp,mp_pat_documents f WHERE patient.DUPLICATE_PATIENT_ID = pat_addr.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = pat_rl_con.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = pat_oth_dtls.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = f.patient_id(+) AND patient.pat_ser_grp_code = pat_ser_grp.pat_ser_grp_code AND patient.DUPLICATE_PATIENT_ID = ? ");	
	  
	  }
	  else
	  {
		  sql2.append("(select count(file_no) from mr_pat_file_index WHERE facility_id = '"+Facility_Id+"' AND patient_id = patient.patient_id) file_cnt, ");
			sql2.append(" patient.patient_id Patient_id FROM mp_patient patient, mp_pat_addresses pat_addr, mp_pat_rel_contacts pat_rl_con, mp_pat_oth_dtls pat_oth_dtls, mp_pat_ser_grp pat_ser_grp,mp_pat_documents f WHERE patient.patient_id = pat_addr.patient_id(+) AND patient.patient_id = pat_rl_con.patient_id(+) AND patient.patient_id = pat_oth_dtls.patient_id(+) AND patient.patient_id = f.patient_id(+) AND patient.pat_ser_grp_code = pat_ser_grp.pat_ser_grp_code AND patient.patient_id = ? ");
	      
	  }
  }else if(!group_status.equals(""))
  {
	if(disp_dup_pat_dtls.equals("Duplicate") && group_status.equals("S") )
	{	 	
			 sql2.append("(select count(file_no) from mr_pat_file_index WHERE facility_id = '"+Facility_Id+"' AND patient_id = patient.valid_patient_id) file_cnt, ");
			sql2.append(" patient.DUPLICATE_PATIENT_ID Patient_id FROM DR_MP_PATIENT patient, DR_MP_PAT_ADDRESSES pat_addr, DR_MP_PAT_REL_CONTACTS pat_rl_con, DR_MP_PAT_OTH_DTLS pat_oth_dtls, mp_pat_ser_grp pat_ser_grp,mp_pat_documents f WHERE patient.DUPLICATE_PATIENT_ID = pat_addr.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = pat_rl_con.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = pat_oth_dtls.DUPLICATE_PATIENT_ID(+) AND patient.DUPLICATE_PATIENT_ID = f.patient_id(+) AND patient.pat_ser_grp_code = pat_ser_grp.pat_ser_grp_code AND patient.DUPLICATE_PATIENT_ID = ? ");	
	
	
	}	
	else
	{
		  sql2.append("(select count(file_no) from mr_pat_file_index WHERE facility_id = '"+Facility_Id+"' AND patient_id = patient.patient_id) file_cnt, ");
		  sql2.append(" patient.patient_id Patient_id FROM mp_patient patient, mp_pat_addresses pat_addr, mp_pat_rel_contacts pat_rl_con, mp_pat_oth_dtls pat_oth_dtls, mp_pat_ser_grp pat_ser_grp,mp_pat_documents f  WHERE patient.patient_id = pat_addr.patient_id(+) AND patient.patient_id = pat_rl_con.patient_id(+) AND patient.patient_id = pat_oth_dtls.patient_id(+) AND patient.patient_id = f.patient_id(+) AND patient.pat_ser_grp_code = pat_ser_grp.pat_ser_grp_code AND patient.patient_id = ? ");	
	       
	}

  }
 

pstmt = con.prepareStatement(sql2.toString());
pstmt.setString(1, patient);
rs=pstmt.executeQuery();
if(rs != null) {
    if(rs.next()) 
	{
       /* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
	    doc1 = rs.getBinaryStream("DOC1_IMAGE");
		doc2 = rs.getBinaryStream("DOC2_IMAGE");
		doc3 = rs.getBinaryStream("DOC3_IMAGE");
		doc4 = rs.getBinaryStream("DOC4_IMAGE");
	  /* end PMG2012-CRF-0006 [IN034693] */ 
		
	Patient_id=rs.getString("Patient_id");
	  //Added for MMS-QH-CRF-0145
	  
	  hijri_birth_date =rs.getString("hijri_birth_date"); 
	  if(hijri_birth_date==null)hijri_birth_date=""; 
	  
	  //Added for MMS-QH-CRF-0145
	  
		citizen_yn=rs.getString("CITIZEN_YN");
		legal_yn=rs.getString("LEGAL_YN");

		if (citizen_yn == null) citizen_yn="&nbsp; ";
		if (legal_yn == null) legal_yn="&nbsp; ";

		Patient_Name=rs.getString("Patient_Name");
        Pat_Ser_Grp_Code= rs.getString("pat_ser_grp_code");
        Pat_Ser_Grp_Desc  =rs.getString("pat_ser_grp_desc") ;
        if (Pat_Ser_Grp_Desc == null) Pat_Ser_Grp_Desc="&nbsp; ";
        National_Id_No  =rs.getString("national_id_no");
		National_Id_No = eXH.XHUtil.getNationalID(Patient_id);
		if(National_Id_No ==null)National_Id_No ="&nbsp; ";
        Pref_Facility_Id  =rs.getString("pref_facility_id");
        if(Pref_Facility_Id==null) Pref_Facility_Id="";
		if(!Pref_Facility_Id.equals(""))
		{
			if(!Pref_Facility_Id.equals(Facility_Id))
			{
				out.println("<script>alert(getMessage('PREF_FCY_NOT_LOG_FCY','MP'));</script>");
			}
		}
        Pref_Facility_Name =rs.getString("pref_facility_name");
        if(Pref_Facility_Name==null)Pref_Facility_Name="&nbsp; ";

        Alt_Id1_No    =rs.getString("alt_id1_no") ;
        if(Alt_Id1_No ==null){Alt_Id1_No ="&nbsp; ";}

        Alt_Id1_Exp_Date  =rs.getString("alt_id1_exp_date");
        //if(Alt_Id1_Exp_Date==null)Alt_Id1_Exp_Date="&nbsp; ";
		if(Alt_Id1_Exp_Date!=null){
			Alt_Id1_Exp_Date=DateUtils.convertDate(Alt_Id1_Exp_Date,"DMY","en",locale); 
		}
		else
			Alt_Id1_Exp_Date="&nbsp;";


        Alt_Id2_No   =rs.getString("alt_id2_no");
        if(Alt_Id2_No==null){Alt_Id2_No="&nbsp; ";}

        regn_facility_name = rs.getString("regn_facility_name");
        if(regn_facility_name == null)  regn_facility_name = "&nbsp";
        
        Alt_Id2_Exp_Date =rs.getString("alt_id2_exp_date");
      //  if(Alt_Id2_Exp_Date==null)Alt_Id2_Exp_Date="&nbsp; ";
	  if(Alt_Id2_Exp_Date!=null){
			Alt_Id2_Exp_Date=DateUtils.convertDate(Alt_Id2_Exp_Date,"DMY","en",locale); 
		}
		else
			Alt_Id2_Exp_Date="&nbsp;";

        Alt_Id3_No     =rs.getString("alt_id3_no");
        if(Alt_Id3_No ==null){Alt_Id3_No ="&nbsp; ";}

        Alt_Id3_Exp_Date  =rs.getString("alt_id3_exp_date");

		if(Alt_Id3_Exp_Date!=null){
			Alt_Id3_Exp_Date=DateUtils.convertDate(Alt_Id3_Exp_Date,"DMY","en",locale); 
		}
		else
			Alt_Id3_Exp_Date="&nbsp;";

        Alt_Id4_No     =rs.getString("alt_id4_no");
        if(Alt_Id4_No  ==null){Alt_Id4_No  ="&nbsp; ";}
		

        Alt_Id4_Exp_Date =rs.getString("alt_id4_exp_date");
    	if(Alt_Id4_Exp_Date!=null){
			Alt_Id4_Exp_Date=DateUtils.convertDate(Alt_Id4_Exp_Date,"DMY","en",locale); 
		}
		else
			Alt_Id4_Exp_Date="&nbsp;";
		
        Family_Link_No    =rs.getString("family_link_no");
        if(Family_Link_No ==null)Family_Link_No ="&nbsp; ";

        Relationship_To_Head =rs.getString("relationship_to_head");
        if(Relationship_To_Head ==null)Relationship_To_Head ="&nbsp; ";
        Relationship_Name  =rs.getString("relationship_name");
        if(Relationship_Name==null)Relationship_Name="&nbsp; ";

        Name_Prefix     =rs.getString("name_prefix");
        if(Name_Prefix ==null)Name_Prefix ="&nbsp; ";

        First_Name      =rs.getString("first_name");
        if(First_Name==null)First_Name="&nbsp; ";

        Second_Name    =rs.getString("second_name");

        if(Second_Name==null)Second_Name="&nbsp; ";

        Third_Name     =rs.getString("third_name");
        if(Third_Name ==null)Third_Name ="&nbsp; ";

        Family_Name    =rs.getString("family_name");
        if(Family_Name==null)Family_Name="&nbsp; ";

        Name_Suffix   =rs.getString("name_suffix");
        if(Name_Suffix ==null)Name_Suffix ="&nbsp; ";

        name_prefix_loc_lang   =rs.getString("name_prefix_loc_lang");
        if(name_prefix_loc_lang ==null)name_prefix_loc_lang ="&nbsp; ";

        first_name_loc_lang   =rs.getString("first_name_loc_lang");
        if(first_name_loc_lang ==null)first_name_loc_lang =" &nbsp;";

        second_name_loc_lang   =rs.getString("second_name_loc_lang");
        if(second_name_loc_lang ==null)second_name_loc_lang =" &nbsp;";

        third_name_loc_lang   =rs.getString("third_name_loc_lang");
        if(third_name_loc_lang ==null)third_name_loc_lang =" &nbsp;";

        family_name_loc_lang   =rs.getString("family_name_loc_lang");
       
		if(family_name_loc_lang ==null)family_name_loc_lang ="&nbsp; ";

        name_suffix_loc_lang   =rs.getString("name_suffix_loc_lang");
        if(name_suffix_loc_lang ==null)name_suffix_loc_lang =" &nbsp;";

        patient_name_loc_lang   =rs.getString("patient_name_loc_lang");
        if(patient_name_loc_lang ==null)patient_name_loc_lang =" &nbsp;";
        
        head_patient_name = rs.getString("head_patient_name");
        if(head_patient_name == null)   head_patient_name = "&nbsp;" ;

        mail_res_area_desc = rs.getString("mail_res_area_long_desc");
        if(mail_res_area_desc == null)   mail_res_area_desc = "&nbsp;" ;

        mail_res_town_desc = rs.getString("mail_res_town_long_desc");
        if(mail_res_town_desc == null)   mail_res_town_desc = "&nbsp;" ;

		race_long_desc = rs.getString("race_long_desc");
        if(race_long_desc == null)   race_long_desc = "&nbsp;" ;

		ethnic_long_desc = rs.getString("ethnic_long_desc");
	    if(ethnic_long_desc == null)   ethnic_long_desc = "&nbsp;" ;

		region_desc = rs.getString("region_long_desc");
        if(region_desc == null)   region_desc = "&nbsp;" ;
		mail_region_desc = rs.getString("mail_region_long_desc");
        if(mail_region_desc == null)   mail_region_desc = "&nbsp;" ;

        Sex          =rs.getString("sex");
        if(Sex==null)Sex="";
	
		blood_grp_desc = rs.getString("blood_grp_desc");
		if(blood_grp_desc==null)
			blood_grp_desc="&nbsp; ";
		
		rh_factor_desc = rs.getString("rh_factor_desc");
		if(rh_factor_desc==null)
			rh_factor_desc="&nbsp; ";


        Date_Of_Birth  =rs.getString("date_of_birth");
        if(Date_Of_Birth==null)
			Date_Of_Birth=""; 
		else 
		{
			Date_Of_Birth=Date_Of_Birth.substring(0,10);
			Date_Of_Birth=DateUtils.convertDate(Date_Of_Birth,"DMY","en",locale); 
		}
	
		contact1_birth_date=rs.getString("contact1_birth_date");
        if(contact1_birth_date==null)contact1_birth_date="";
		else
		{	
		contact1_birth_date=contact1_birth_date.substring(0,10);
		contact1_birth_date=DateUtils.convertDate(contact1_birth_date,"DMY","en",locale); 
		}

		nkin_town_desc = rs.getString("nkin_town_long_desc");
        if(nkin_town_desc == null)   nkin_town_desc = "&nbsp;" ;

		fton_town_desc = rs.getString("fton_town_long_desc");
        if(fton_town_desc == null)   fton_town_desc = "&nbsp;" ;

		emplr_town_desc = rs.getString("emplr_town_long_desc");
        if(emplr_town_desc == null)   emplr_town_desc = "&nbsp;" ;  


		nkin_area_desc = rs.getString("nkin_area_long_desc");
        if(nkin_area_desc == null)   nkin_area_desc = "&nbsp;" ;

		fton_area_desc = rs.getString("fton_area_long_desc");
        if(fton_area_desc == null)   fton_area_desc = "&nbsp;" ;

		emplr_area_desc = rs.getString("emplr_area_long_desc");
        if(emplr_area_desc == null)   emplr_area_desc = "&nbsp;" ;  


		nkin_region_desc = rs.getString("nkin_region_long_desc");
        if(nkin_region_desc == null)   nkin_region_desc = "&nbsp;" ;

		fton_region_desc = rs.getString("fton_region_long_desc");
        if(fton_region_desc == null)   fton_region_desc = "&nbsp;" ;

		emplr_region_desc = rs.getString("emplr_region_long_desc");
        if(emplr_region_desc == null)   emplr_region_desc = "&nbsp;" ;  

		nkin_mob_tel_no = rs.getString("nkin_mob_tel_no");
        if(nkin_mob_tel_no == null)   nkin_mob_tel_no = "&nbsp;" ;

		fton_mob_tel_no = rs.getString("fton_mob_tel_no");
        if(fton_mob_tel_no == null)   fton_mob_tel_no = "&nbsp;" ;

		nkin_email_id = rs.getString("nkin_email_id");
        if(nkin_email_id == null)   nkin_email_id = "&nbsp;" ;

		fton_email_id = rs.getString("fton_email_id");
        if(fton_email_id == null)   fton_email_id = "&nbsp;" ;

		organization_name = rs.getString("organization_name");
        if(organization_name == null)   organization_name = "&nbsp;" ;		

		emplr_ocpn_class_desc = rs.getString("emplr_ocpn_class_desc");
        if(emplr_ocpn_class_desc == null)   emplr_ocpn_class_desc = "&nbsp;" ;		

		demo_oth_alt_id_desc = rs.getString("demo_oth_alt_id_desc");
        if(demo_oth_alt_id_desc == null)   demo_oth_alt_id_desc = "&nbsp;" ;		

		demo_oth_alt_id_no = rs.getString("demo_oth_alt_id_no");
        if(demo_oth_alt_id_no == null)   demo_oth_alt_id_no = "&nbsp;" ;	

		fton_alt_desc = rs.getString("fton_alt_desc");
        if(fton_alt_desc == null)   fton_alt_desc = "&nbsp;";		

		fton_alt_id_no = rs.getString("fton_alt_id_no");
        if(fton_alt_id_no == null)   fton_alt_id_no = "&nbsp;";	

		nkin_oth_alt_desc = rs.getString("nkin_oth_alt_desc");
        if(nkin_oth_alt_desc == null)   nkin_oth_alt_desc = "&nbsp;" ;	

		nkin_oth_alt_id_no = rs.getString("nkin_oth_alt_id_no");
        if(nkin_oth_alt_id_no == null)   nkin_oth_alt_id_no = "&nbsp;" ;	

		contact1_alt_id1_type	 = rs.getString("nkin_alt_id1_desc");
        if(contact1_alt_id1_type	 == null)   contact1_alt_id1_type	 = "" ;	

		contact1_alt_id1_no = rs.getString("contact1_alt_id1_no");
        if(contact1_alt_id1_no == null)   contact1_alt_id1_no = "" ;	

		contact1_alt_id2_type = rs.getString("nkin_alt_id2_desc");
        if(contact1_alt_id2_type == null)   contact1_alt_id2_type = "" ;	

		contact1_alt_id2_no = rs.getString("contact1_alt_id2_no");
        if(contact1_alt_id2_no == null)   contact1_alt_id2_no = "" ;	

		contact1_alt_id3_type = rs.getString("nkin_alt_id3_desc");
        if(contact1_alt_id3_type == null)   contact1_alt_id3_type = "" ;	

		contact1_alt_id3_no = rs.getString("contact1_alt_id3_no");
        if(contact1_alt_id3_no == null)   contact1_alt_id3_no = "" ;	

		contact1_alt_id4_type = rs.getString("nkin_alt_id4_desc");
        if(contact1_alt_id4_type == null)   contact1_alt_id4_type = "" ;	

		contact1_alt_id4_no = rs.getString("contact1_alt_id4_no");
        if(contact1_alt_id4_no == null)   contact1_alt_id4_no = "" ;

		contact1_nat_id_no = rs.getString("contact1_nat_id_no");
        if(contact1_nat_id_no == null)   contact1_nat_id_no = "&nbsp;" ;

		fton_nat_id_no = rs.getString("fton_nat_id_no");
        if(fton_nat_id_no == null)   fton_nat_id_no = "&nbsp;" ;

        Place_Of_Birth =rs.getString("place_of_birth");
        if(Place_Of_Birth==null)Place_Of_Birth="";

		birth_place_code = rs.getString("birth_place_code");
		if(birth_place_code==null)birth_place_code="";

		birth_place_desc = rs.getString("birth_place_desc");
		if(birth_place_desc==null) birth_place_desc="";

        Mar_Status_Code  =rs.getString("mar_status_code");
        if(Mar_Status_Code==null)Mar_Status_Code="";

        Mar_Status_Desc =rs.getString("mar_status_desc");
        if(Mar_Status_Desc==null)Mar_Status_Desc="";

        Alias_Name   =rs.getString("alias_name");
        if(Alias_Name ==null)Alias_Name ="";

        Relgn_Code   =rs.getString("relgn_code" );
        if(Relgn_Code==null)Relgn_Code="";

        Relgn_Desc   =rs.getString("relgn_desc");
        if(Relgn_Desc ==null)Relgn_Desc ="";

        Nationality_Code =rs.getString("nationality_code");
        if(Nationality_Code==null)Nationality_Code="";

     // LANGUAGE_ID  =rs.getString("language_id");
      //  if(LANGUAGE_ID ==null)LANGUAGE_ID =""; 

		Nationality_Desc  =rs.getString("nationality_desc");
        if(Nationality_Desc ==null)Nationality_Desc ="";


        Mother_Maiden_Name =rs.getString("mother_maiden_name");
        if(Mother_Maiden_Name==null)Mother_Maiden_Name="";

		language_name = rs.getString("language_name");
		if(language_name==null)language_name="";
		
		Pat_Cat_Code       =rs.getString("pat_cat_code");
        if(Pat_Cat_Code ==null)Pat_Cat_Code ="";

        Pat_Cat_Desc    =rs.getString("pat_cat_desc");
        if(Pat_Cat_Desc  ==null)Pat_Cat_Desc  ="";

        Ref_Source_Code  =rs.getString("ref_source_code");
        if(Ref_Source_Code==null)Ref_Source_Code="";

        Ref_Source_Desc  =rs.getString("ref_source_desc" );
        if(Ref_Source_Desc==null)Ref_Source_Desc="";

        Resi_Addr_Line1=rs.getString("resi_addr_line1");
        if(Resi_Addr_Line1==null)Resi_Addr_Line1="";

        Resi_Addr_Line2=rs.getString("resi_addr_line2");
        if( Resi_Addr_Line2==null) Resi_Addr_Line2="";

        Resi_Addr_Line3=rs.getString("resi_addr_line3");
        if(Resi_Addr_Line3==null)Resi_Addr_Line3="";

        Resi_Addr_Line4=rs.getString("resi_addr_line4");
        if(Resi_Addr_Line4==null)Resi_Addr_Line4="";

        Resi_Postal_Code=rs.getString("resi_postal_code");
        if( Resi_Postal_Code==null)Resi_Postal_Code="";

        Resi_Country_Name=rs.getString("resi_country_name");
        if(Resi_Country_Name==null)Resi_Country_Name="";

        Resi_Invalid1_Yn=rs.getString("resi_invalid1_yn");
        if(Resi_Invalid1_Yn==null)Resi_Invalid1_Yn="";

        Resi_Contact1_Name=rs.getString("resi_contact1_name");
        if(Resi_Contact1_Name==null)Resi_Contact1_Name="";

        Resi_Area_Desc=rs.getString("res_area_long_desc");
        if(Resi_Area_Desc==null)Resi_Area_Desc="";

        Resi_Town_Desc=rs.getString("res_town_long_desc");
        if(Resi_Town_Desc==null)Resi_Town_Desc="";

        Mail_Addr_Line1=rs.getString("mail_addr_line1");
        if(Mail_Addr_Line1==null)Mail_Addr_Line1="";

        Mail_Addr_Line2=rs.getString("mail_addr_line2");
        if(Mail_Addr_Line2==null)Mail_Addr_Line2="";

        Mail_Addr_Line3=rs.getString("mail_addr_line3");
        if(Mail_Addr_Line3==null)Mail_Addr_Line3="";

        Mail_Addr_Line4=rs.getString("mail_addr_line4");
        if(Mail_Addr_Line4==null)Mail_Addr_Line4="";

        Mail_Postal_Code=rs.getString("mail_postal_code");
        if(Mail_Postal_Code==null)Mail_Postal_Code="";

        Mail_Country_Name=rs.getString("mail_country_name");
        if(Mail_Country_Name==null)Mail_Country_Name="";

        Mail_Invalid1_Yn=rs.getString("mail_invalid1_yn");
        if(Mail_Invalid1_Yn==null)Mail_Invalid1_Yn="";
    
        Mail_Contact1_Name=rs.getString("mail_contact1_name");
        if(Mail_Contact1_Name==null)Mail_Contact1_Name="";

        Prn_Tel_No=rs.getString("prn_tel_no");
        if(Prn_Tel_No==null)Prn_Tel_No="";

        Orn_Tel_No=rs.getString("orn_tel_no");
        if(Orn_Tel_No==null)Orn_Tel_No="";

        Contact3_Mode=rs.getString("contact3_mode");
        if(Contact3_Mode==null)Contact3_Mode="";

        Contact4_Mode=rs.getString("contact4_mode");
        if(Contact4_Mode==null)Contact4_Mode="";


        Contact5_Mode=rs.getString("contact5_mode");
        if(Contact5_Mode==null)Contact5_Mode="";

        Contact3_No=rs.getString("contact3_no");
        if(Contact3_No==null)Contact3_No="";

        Contact4_No=rs.getString("contact4_no");
        if(Contact4_No==null)Contact4_No="";

        Contact5_No=rs.getString("contact5_no");
        if(Contact5_No==null)Contact5_No="";

		email_id = rs.getString("email_id");
		if(email_id==null) email_id="";
		
        Nkin_Contact_Relation_Desc=rs.getString("nkin_contact_relation_desc");
        if(Nkin_Contact_Relation_Desc==null)Nkin_Contact_Relation_Desc="";

        Nkin_Contact_Name=rs.getString("nkin_contact_name");
        if(Nkin_Contact_Name==null)Nkin_Contact_Name="";

        Nkin_Job_Title =rs.getString("nkin_job_title");
        if(Nkin_Job_Title==null)Nkin_Job_Title="";

        Nkin_Addr_Line1 =rs.getString("nkin_addr_line1");
        if(Nkin_Addr_Line1==null)Nkin_Addr_Line1="";

        Nkin_Addr_Line2=rs.getString("nkin_addr_line2");
        if(Nkin_Addr_Line2==null)Nkin_Addr_Line2="";

        Nkin_Addr_Line3=rs.getString("nkin_addr_line3");
        if(Nkin_Addr_Line3==null)Nkin_Addr_Line3="";

        Nkin_Addr_Line4=rs.getString("nkin_addr_line4");
        if(Nkin_Addr_Line4==null)Nkin_Addr_Line4="";

        Nkin_Postal_Code =rs.getString("nkin_postal_code");
        if(Nkin_Postal_Code==null)Nkin_Postal_Code="";

        Nkin_Country_Code=rs.getString("nkin_country_code");
        if(Nkin_Country_Code==null)Nkin_Country_Code="";

        Nkin_Country_Name=rs.getString("nkin_country_name");
        if(Nkin_Country_Name==null)Nkin_Country_Name="";

        Nkin_Res_Tel_No =rs.getString("nkin_res_tel_no");
        if(Nkin_Res_Tel_No==null)Nkin_Res_Tel_No="";

        Nkin_Off_Tel_No=rs.getString("nkin_off_tel_no");
        if(Nkin_Off_Tel_No==null)Nkin_Off_Tel_No="";

        Fton_Contact_Relation_Desc =rs.getString("fton_contact_relation_desc");
        if(Fton_Contact_Relation_Desc==null)Fton_Contact_Relation_Desc="";

        Fton_Contact_Name=rs.getString("fton_contact_name");
        if(Fton_Contact_Name==null)Fton_Contact_Name="";

        Fton_Job_Title =rs.getString("fton_job_title");
        if(Fton_Job_Title==null)Fton_Job_Title="";

        Fton_Addr_Line1=rs.getString("fton_addr_line1");
        if(Fton_Addr_Line1==null)Fton_Addr_Line1="";

        Fton_Addr_Line2 =rs.getString("fton_addr_line2");
        if(Fton_Addr_Line2==null)Fton_Addr_Line2="";

        Fton_Addr_Line3 =rs.getString("fton_addr_line3");
        if(Fton_Addr_Line3==null)Fton_Addr_Line3="";

        Fton_Addr_Line4  =rs.getString("fton_addr_line4");
        if(Fton_Addr_Line4==null)Fton_Addr_Line4="";

        Fton_Postal_Code =rs.getString("fton_postal_code");
        if(Fton_Postal_Code==null)Fton_Postal_Code="";

        Fton_Country_Code=rs.getString("fton_country_code");
        if(Fton_Country_Code==null)Fton_Country_Code="";

        Fton_Country_Name =rs.getString("fton_country_name");
        if(Fton_Country_Name==null)Fton_Country_Name="";

        Fton_Res_Tel_No =rs.getString("fton_res_tel_no");
        if(Fton_Res_Tel_No==null)Fton_Res_Tel_No="";

        Fton_Off_Tel_No =rs.getString("fton_off_tel_no");
        if(Fton_Off_Tel_No==null)Fton_Off_Tel_No="";

        Ocpn_Desc=rs.getString("occupation_desc");
        if(Ocpn_Desc==null)Ocpn_Desc="";

        Patient_Employee_Id=rs.getString("patient_employee_id");
        if(Patient_Employee_Id==null)Patient_Employee_Id="";

        Employment_Status=rs.getString("employment_status");
        if(Employment_Status==null)Employment_Status="";
		
	   if(Employment_Status.equals("FE"))
		{
		Employment_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FullTimeEmployed.label","mp_labels"); 
		}
		else if(Employment_Status.equals("PE"))
		{
		Employment_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PartTimeEmployed.label","mp_labels"); 
		}
		else if(Employment_Status.equals("SE"))
		{
		Employment_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SelfEmployed.label","mp_labels"); 
		}
		else if(Employment_Status.equals("UE"))
		{
		Employment_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Unemployed.label","mp_labels"); 
		}
		else if(Employment_Status.equals("FS"))
		{
		Employment_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FullTimeStudent.label","mp_labels"); 
		}
		else if(Employment_Status.equals("PS"))
		{
		Employment_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PartTimeStudent.label","mp_labels"); 
		}
		else if(Employment_Status.equals("UK"))
		{
		Employment_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels"); 
		}
		else if(Employment_Status.equals("NA"))
		{
		Employment_Status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels"); 
		}
				


        Emplr_Contact_Name=rs.getString("emplr_contact_name");
        if(Emplr_Contact_Name==null)Emplr_Contact_Name="";

        Emplr_Job_Title=rs.getString("emplr_job_title");
        if(Emplr_Job_Title==null)Emplr_Job_Title="";

        Emplr_Addr_Line1=rs.getString("emplr_addr_line1");
        if(Emplr_Addr_Line1==null)Emplr_Addr_Line1="";

        Emplr_Addr_Line2=rs.getString("emplr_addr_line2");
        if(Emplr_Addr_Line2==null)Emplr_Addr_Line2="";

        Emplr_Addr_Line3=rs.getString("emplr_addr_line3");
        if(Emplr_Addr_Line3==null)Emplr_Addr_Line3="";

        Emplr_Addr_Line4=rs.getString("emplr_addr_line4");
        if(Emplr_Addr_Line4==null)Emplr_Addr_Line4="";

        Emplr_Postal_Code=rs.getString("emplr_postal_code");
        if(Emplr_Postal_Code==null)Emplr_Postal_Code="";

        Emplr_Country_Name=rs.getString("emplr_country_name");
        if(Emplr_Country_Name==null)Emplr_Country_Name="";


        Emplr_Res_Tel_No=rs.getString("emplr_res_tel_no");
        if(Emplr_Res_Tel_No==null)Emplr_Res_Tel_No="";

        Emplr_Off_Tel_No=rs.getString("emplr_off_tel_no");
        if(Emplr_Off_Tel_No==null)Emplr_Off_Tel_No="";

        Off_Fax_No=rs.getString("off_fax_no");
        if(Off_Fax_No==null)Off_Fax_No="";


        Living_Dependency=rs.getString("living_dependency");
        if(Living_Dependency==null)Living_Dependency="";

		if(Living_Dependency.equals("D"))
		{
		Living_Dependency = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SpouseDependent.label","mp_labels"); 
		}
		else if(Living_Dependency.equals("M"))
		{
		Living_Dependency = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.MedicalSupervisionReqd.label","mp_labels"); 
		}
		else if(Living_Dependency.equals("S"))
		{
		Living_Dependency = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SmallChildren.label","mp_labels"); 
		}
		else if(Living_Dependency.equals("WU"))
		{
		Living_Dependency = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.WalkUp.label","mp_labels"); 
		}
		else if(Living_Dependency.equals("UN"))
		{
		Living_Dependency = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NotKnown.label","common_labels"); 
		}

        Living_Arrangement=rs.getString("living_arrangement");
        if(Living_Arrangement==null)Living_Arrangement="";

		if(Living_Arrangement.equals("A"))
		{
		Living_Arrangement = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Alone.label","mp_labels"); 
		}
		else if(Living_Arrangement.equals("F"))
		{
		Living_Arrangement = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.family.label","mp_labels"); 
		}
		else if(Living_Arrangement.equals("R"))
		{
		Living_Arrangement = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.relative.label","mp_labels"); 
		}
		else if(Living_Arrangement.equals("U"))
		{
		Living_Arrangement = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels"); 
		}
		else if(Living_Arrangement.equals("S"))
		{
		Living_Arrangement = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.spouseonly.label","mp_labels"); 
		}

        Education_Level=rs.getString("educ_level_desc");
        if(Education_Level==null)Education_Level="";

        Informant=rs.getString("informant");
        if(Informant==null)Informant="";

        Informant_Remarks=rs.getString("informant_remarks");
        if(Informant_Remarks==null)Informant_Remarks="";

        General_Remarks=rs.getString("general_remarks");
        if(General_Remarks==null)General_Remarks="";

        Suspend_Yn = rs.getString("suspend_yn");
        if (Suspend_Yn==null) Suspend_Yn="";

        Status_Reason_Desc = rs.getString("status_reason_desc");
        if (Status_Reason_Desc==null) Status_Reason_Desc="";

        Status_Remarks = rs.getString("status_remarks");
        if (Status_Remarks==null) Status_Remarks="";


        Active_Yn = rs.getString("active_yn");
        if (Active_Yn==null) Active_Yn="";

        Last_Contact_Date = rs.getString("last_contact_date");
        if (Last_Contact_Date!=null)
		{
			Last_Contact_Date=DateUtils.convertDate(Last_Contact_Date,"DMY","en",locale); 
		}
		else
			Last_Contact_Date="";

        Deceased_Yn = rs.getString("deceased_yn");
        if (Deceased_Yn==null) Deceased_Yn="";

        Deceased_Date = rs.getString("deceased_date");

       // if (Deceased_Date==null) Deceased_Date="";
	    if (Deceased_Date!=null)
		{
			Deceased_Date=DateUtils.convertDate(Deceased_Date,"DMY","en",locale); 
		}
		else
			Deceased_Date="";

        Death_Status_Remarks = rs.getString("death_status_remarks");
        if(Death_Status_Remarks==null) Death_Status_Remarks="";
        
        cust_fields[0] =  cust_fields[0] + "`"+(rs.getString("addl_field1")==null?"&nbsp;":rs.getString("addl_field1")) ;
        cust_fields[1] =  cust_fields[1] +"`"+(rs.getString("addl_field2")==null?"&nbsp;":rs.getString("addl_field2")) ;
        cust_fields[2] =  cust_fields[2] +"`"+(rs.getString("addl_field3")==null?"&nbsp;":rs.getString("addl_field3")) ;
        cust_fields[3] =  cust_fields[3] +"`"+(rs.getString("addl_field4")==null?"&nbsp;":rs.getString("addl_field4")) ;
        cust_fields[4] =  cust_fields[4] +"`"+(rs.getString("addl_field5")==null?"&nbsp;":rs.getString("addl_field5")) ;

        added_by_id = rs.getString("added_by_id");
        added_user_name = rs.getString("added_user_name");
		if(added_user_name==null)added_user_name="&nbsp;";
        added_date = rs.getString("added_date");
		added_date=DateUtils.convertDate(added_date,"DMYHM","en",locale); 

        added_at_ws_no = rs.getString("added_at_ws_no");
        added_facility_id = rs.getString("added_facility_id");
        added_facility_name = rs.getString("ADDED_FACILITY_NAME");
        modified_by_id = rs.getString("modified_by_id");
        modified_user_name = rs.getString("modified_user_name");
		if(modified_user_name==null)modified_user_name="&nbsp;";
        modified_date = rs.getString("modified_date");
		modified_date=DateUtils.convertDate(modified_date,"DMYHM","en",locale); 

        modified_at_ws_no = rs.getString("modified_at_ws_no");
        modified_facility_id  = rs.getString("modified_facility_id");
        modified_facility_name  = rs.getString("modified_facility_name");
		data_source = rs.getString("data_source");
		if (data_source==null) data_source="";
		Age = rs.getString("age");
		if (Age==null) Age="";

		if(!Age.equals("")) {

			StringTokenizer st = new StringTokenizer(Age," ");

				while ( st.hasMoreTokens() ) {

							String date_elmnt = st.nextToken();						

							char ymdh_char = date_elmnt.charAt(date_elmnt.length()-1);							

							String ymdh_elmnt = date_elmnt.substring(0,(date_elmnt.length()-1));				

							if(ymdh_char=='Y') {
								if(!ymdh_elmnt.equals("0"))
									age_value = age_value+ymdh_elmnt+"Y ";								
							} else if (ymdh_char=='M') {
								if(!ymdh_elmnt.equals("0"))
									age_value = age_value+ymdh_elmnt+"M ";								
							} else if (ymdh_char=='D') {
								if(!ymdh_elmnt.equals("0"))
									age_value = age_value+ymdh_elmnt+"D ";								
							} else if (ymdh_char=='H') {
								//if(!ymdh_elmnt.equals("0"))
									age_value = age_value+ymdh_elmnt+"H ";
							}
						}	
						
		}


		CONTACT3_MODE_DESC=rs.getString("CONTACT3_MODE_DESC");
        if(CONTACT3_MODE_DESC==null)CONTACT3_MODE_DESC="";
		
		CONTACT4_MODE_DESC=rs.getString("CONTACT4_MODE_DESC");
        if(CONTACT4_MODE_DESC==null)CONTACT4_MODE_DESC="";
		
		CONTACT5_MODE_DESC=rs.getString("CONTACT5_MODE_DESC");
        if(CONTACT5_MODE_DESC==null)CONTACT5_MODE_DESC="";
		MembershipType=rs.getString("MembershipType");
        if(MembershipType==null)MembershipType="";
		Orgsubname=rs.getString("Orgsubname");
        if(Orgsubname==null)Orgsubname="";
		Orgname=rs.getString("Orgname");
        if(Orgname==null)Orgname="";
		patexpirtydate=rs.getString("patexpirtydate");
        if(patexpirtydate!=null)
		{
			patexpirtydate=DateUtils.convertDate(patexpirtydate,"DMY","en",locale);
		}
		else
			patexpirtydate="";
		

// newly start Tuesday, May 04, 2010  PE_EXE Venkat S 


			file_cnt = rs.getInt("file_cnt");

			doc1_type_desc = rs.getString("doc1_type_desc")==null?"&nbsp;":rs.getString("doc1_type_desc");
			doc1_num = rs.getString("doc1_num")==null?"&nbsp;":rs.getString("doc1_num");
			doc1_place_of_issue = rs.getString("doc1_place_of_issue")==null?"&nbsp;":rs.getString("doc1_place_of_issue");

			doc2_type_desc = rs.getString("doc2_type_desc")==null?"&nbsp;":rs.getString("doc2_type_desc");
			doc2_num = rs.getString("doc2_num")==null?"&nbsp;":rs.getString("doc2_num");
			doc2_place_of_issue = rs.getString("doc2_place_of_issue")==null?"&nbsp;":rs.getString("doc2_place_of_issue");

			doc3_type_desc = rs.getString("doc3_type_desc")==null?"&nbsp;":rs.getString("doc3_type_desc");
			doc3_num = rs.getString("doc3_num")==null?"&nbsp;":rs.getString("doc3_num");
			doc3_place_of_issue = rs.getString("doc3_place_of_issue")==null?"&nbsp;":rs.getString("doc3_place_of_issue");

			doc4_type_desc = rs.getString("doc4_type_desc")==null?"&nbsp;":rs.getString("doc4_type_desc");
			doc4_num = rs.getString("doc4_num")==null?"&nbsp;":rs.getString("doc4_num");
			doc4_place_of_issue = rs.getString("doc4_place_of_issue")==null?"&nbsp;":rs.getString("doc4_place_of_issue");



			doc1_exp_date=rs.getString("DOC1_EXP_DATE");
				if(doc1_exp_date != null)
				{
				doc1_exp_date= DateUtils.convertDate(doc1_exp_date,"DMY","en",localeName);
				}
				else
					doc1_exp_date="&nbsp;";
				
				doc1_iss_date=rs.getString("DOC1_ISS_DATE");
				if(doc1_iss_date != null)
				{
					doc1_iss_date= DateUtils.convertDate(doc1_iss_date,"DMY","en",localeName);
				}
				else
					doc1_iss_date="&nbsp;";

				doc2_exp_date=rs.getString("DOC2_EXP_DATE");
				if(doc2_exp_date != null)
				{
					doc2_exp_date= DateUtils.convertDate(doc2_exp_date,"DMY","en",localeName);
				}
				else
					doc2_exp_date="&nbsp;";
				doc2_iss_date=rs.getString("DOC2_ISS_DATE");
				if(doc2_iss_date != null)
				{
					doc2_iss_date= DateUtils.convertDate(doc2_iss_date,"DMY","en",localeName);
				}
				else
					doc2_iss_date="&nbsp;";

				doc3_exp_date=rs.getString("DOC3_EXP_DATE");
				if(doc3_exp_date != null)
				{
					doc3_exp_date= DateUtils.convertDate(doc3_exp_date,"DMY","en",localeName);
				}
				else
					doc3_exp_date="&nbsp;";

				doc3_iss_date=rs.getString("DOC3_ISS_DATE");
				if(doc3_iss_date != null)
				{
					doc3_iss_date= DateUtils.convertDate(doc3_iss_date,"DMY","en",localeName);
				}
				else
					doc3_iss_date="&nbsp;";

				doc4_exp_date=rs.getString("DOC4_EXP_DATE");
				if(doc4_exp_date != null)
				{
					doc4_exp_date= DateUtils.convertDate(doc4_exp_date,"DMY","en",localeName);
				}
				else
					doc4_exp_date="&nbsp;";

				doc4_iss_date=rs.getString("DOC4_ISS_DATE");
				if(doc4_iss_date != null)
				{
					doc4_iss_date= DateUtils.convertDate(doc4_iss_date,"DMY","en",localeName);
				}
				else
					doc4_iss_date="&nbsp;";
		// end  PE_EXE 
    }
	else
	{
		//out.println("<script>alert(getMessage('INCOMPLETE_PAT_REC'));</script>");
		//out.println("<script>parent.parent.frames[1].location.href ='../../eMP/jsp/blank.jsp?step_1=3';</script>");
		if(!function_id1.equals("VIEW_PAT_DTLS")){
		out.println("<script>alert(getMessage('INCOMPLETE_PAT_REC','MP'));</script>");
		out.println("<script>window.close();</script>");
		}else {
           out.println("<script>alert(getMessage('INCOMPLETE_PAT_REC','MP'));</script>");
		   out.println("<script>parent.parent.frames[1].location.href ='../../eMP/jsp/blank.jsp?step_1=3';</script>");
		}
	}
}
}catch(Exception e){
	
	e.printStackTrace();}

//added by Dheeraj on 15-7-02  - Begin
//this is to display the alert message if the file has not been created for the facility.

if (doc_or_file.equals("F")&&(create_file_yn.equals("Y")))
{
	//Newly added on 13/02/2012 by Saanthaakumar  ---> SCF NO : RUT-SCF-0062 [30973]
	
	
	if(file_cnt==0)
	{
	out.println("<script>alert(getMessage('FILE_NOT_FOR_FACILITY','MP'));</script>");
	}

/* Tuesday, May 04, 2010 PE_EXE venkat s StringBuffer  sblQry{ = new StringBuffer();
	out.println("----------");
	String slFile_No = "";
	sblQry.append("select file_no from mr_pat_file_index where facility_id = '"+ Facility_Id +"' and patient_id  = ?");

	pstmt = con.prepareStatement(sblQry.toString());
	pstmt.setString(1, patient);

	rs = pstmt.executeQuery();

		if((rs.next())){
			slFile_No = rs.getString("file_no");

		}else{
			out.println("<script>alert(getMessage('FILE_NOT_FOR_FACILITY','MP'));</script>");
		} */
}%>

<table border='0' cellpadding='3' cellspacing='0' width="97%" align="center">
		
		<tr>	
				<td  class='label' width='24%'><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></td>
				<td  class='data' width='24%'>
				<%=Pat_Ser_Grp_Desc %></td>
				<td  class='label' width='24%' ><fmt:message key="eMP.PrefFacility.label" bundle="${mp_labels}"/></td>
				<td  class='data' width='24%' ><%=Pref_Facility_Name%></td>
		</tr>
<%
    session.putValue( "patient_id", patient ) ;
	view_pat_photo_yn = "N"; 
    if (view_pat_photo_yn.equals("Y"))
    {%>
			 <jsp:include page="../../eCommon/jsp/photo_display.jsp" flush="true"/>
    <%}%>
		<tr>
				<td class="COLUMNHEADER" colspan='4' width='24%'><fmt:message key="eMP.identitydetails.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr>
				<%if(accept_national_id_no_yn.equals("Y")){
		%><td  class='label'  width='24%'><%=nat_id_prompt%></td>
				<td  class='data' width='24%'><%=National_Id_No%></td>
					<%} else {%>
  					<td colspan=2  class='data'  ></td>
		      <%}%>

				<%if(accept_oth_alt_id_yn.equals("Y"))
				{%>

					<td  class='label' width='25%' ><fmt:message key="eMP.OtherAltNo.label" bundle="${mp_labels}"/></td>
					<td   class='data'   width='25%'><%=demo_oth_alt_id_desc%>&nbsp;&nbsp;&nbsp;<%=demo_oth_alt_id_no%></td> 
		       <%}
			   else
			   {%>
					<td colspan=2  class='data'  ></td>
		      <%}%>
        </tr>
		<tr>
				<td  class='label' ><%=Alt_Id1_Type%></td>
				<td  class='data' ><%=Alt_Id1_No%></td>
				<%
				if(alt_id1_exp_date_accept_yn.equals("Y"))
				{%>
					<td  class='label'  ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
					<td  class='data'  ><%=Alt_Id1_Exp_Date%></td>
				<%
				}else
				{
				%>
					 <td  colspan = 2 >&nbsp;</td>
				<%
				}
				%>
		</tr>
	<%
	if(Alt_Id2_Type != "") {
	%>
		<tr>
			<td  class='label' ><%=Alt_Id2_Type%></td>
			<td  class='data' > <%=Alt_Id2_No%></td>
			<%if(alt_id2_exp_date_accept_yn.equals("Y"))
			  { %>
				    <td  class='label'  >
					<fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
					<td  class='data'  >
					<%=Alt_Id2_Exp_Date%></td> 
			 <%}else{%>
					<td colspan = 2 >&nbsp;</td>
             <%}
	}
    %></tr>
    
	<%
	if(Alt_Id3_Type != "") {
	%> 
		<tr>
			<td  class='label' ><%=Alt_Id3_Type%></td>
			<td  class='data' ><%=Alt_Id3_No%></td>
			
		    <%if(alt_id3_exp_date_accept_yn.equals("Y"))
			 {  %>
				    <td  class='label' >
					<fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/>
					</td>
					<td  class='data'  >
					<%=Alt_Id3_Exp_Date%></td> 
			<%}else{%>
					<td colspan = 2 >&nbsp;</td>
			<%}%>
		</tr>
	 <%}%>
		
		
		<%
		if(Alt_Id4_Type != "") 
		{
		%>
			<tr>
				<td  class='label' ><%=Alt_Id4_Type%></td>
				<td class='data' ><%=Alt_Id4_No%> </td>
				
				<%if(alt_id4_exp_date_accept_yn.equals("Y"))
					{  %>
					 <td  class='label' ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
					 <td  class='data' >
					 <%=Alt_Id4_Exp_Date%></td>
				<%}else{%>
					 <td class='label'  colspan='2'>&nbsp;</td>
				<%}%>
			</tr>
		<%}%>
		

<%

/*
	String family_org_id_accept_yn=(String)hash_mp_param.get("FAMILY_ORG_ID_ACCEPT_YN");
	String entitlement_by_pat_cat_yn=(String)hash_mp_param.get("entitlement_by_pat_cat_yn");
*/
	 
	 
%>
	<%if(family_org_id_accept_yn.equals("Y"))
		{%>
		<tr>
			<td class="COLUMNHEADER" colspan='4'><fmt:message key="eMP.headfamilydetails.label" bundle="${mp_labels}"/></td>
		</tr>
		
		<tr>
				<td  class='label'  width='24%'><fmt:message key="eMP.membership.label" bundle="${mp_labels}"/></td>

				<td  class='data'  width='24%'>
				<%if(MembershipType.equals("1")){%>
					<fmt:message key="eMP.organizationmember.label" bundle="${mp_labels}"/>
				<%}else if (MembershipType.equals("2")){%>
				    <fmt:message key="eMP.relatedmemberfamily.label" bundle="${mp_labels}"/>
				<%}else if(MembershipType.equals("3")){%>
				    <fmt:message key="eMP.relatedmembernonfamily.label" bundle="${mp_labels}"/>
				<%}else if(MembershipType.equals("4")){%>
				    <fmt:message key="eMP.nonorganizationmember.label" bundle="${mp_labels}"/>
				<%}%>
			</td>
			<td  class='label'  width='24%'><fmt:message key="Common.Organization.label" bundle="${common_labels}"/></td>
			<td  class='data'    width='25%'><%=Orgname%>&nbsp;
			<%if(!Orgname.equals("") && !Orgsubname.equals("")){ %>/&nbsp;<%}%><%=Orgsubname%></td>
			</tr>
			 <%}else{%>
				<tr>
				<td colspan=4 class='label' >&nbsp;</td>
				</tr>
			<%}%>

         
	 <%if(Family_No_Link_Yn.equals("Y"))
		 {%>
		   <tr>
				<td  class='label'>
				<fmt:message key="eMP.HeadPatientID.label" bundle="${mp_labels}"/></td>
				<td  class='data' ><%=Family_Link_No%>
				<!-- <%if(family_org_id_accept_yn.equals("Y"))
				{%>
					 <td colspan=1 align='left' class='data' >
				<%}
				else 
				{%>
					  <td colspan=2 align='left' class='data' >
			   <%}%> -->
			   <%=head_patient_name%></td>
			   <td  class='label'  ><fmt:message key="eMP.RelationshiptoHeadofFamily.label" bundle="${mp_labels}"/></td>
			   <td  class='data'><%=Relationship_Name%></td>
		 </tr>
		 <%}
		 else
		 {%>
			 <tr>
				<td colspan=4  class='data' width='45%'>&nbsp;</td>
			 </tr>
		 <%}%>
 	 
<!-- </table>
<table border="0" cellpadding="0" cellspacing="0" width="97%" align="center"> -->
<tr>
<td width="100%" class="BORDER" colspan='4'>
<table  cellpadding='3' cellspacing='0' border='0' width="100%" >
<tr><td class="COLUMNHEADER" colspan='6'><fmt:message key="eMP.names.label" bundle="${mp_labels}"/></td></tr>
<tr>
<%
if ( Name_Prefix_Accept_Yn.equals("Y") )
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+Name_Prefix_Prompt+"</td>");

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
        out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name_Prompt + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name_Prompt + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name_Prompt + "</td>");

}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name_Prompt + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name_Prompt + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name_Prompt + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name_Prompt + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name_Prompt + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name_Prompt + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name_Prompt + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name_Prompt + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name_Prompt + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name_Prompt + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name_Prompt + "</td>");
}
    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name_Prompt + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name_Prompt + "</td>");
}


if ( Name_Suffix_Accept_Yn.equals("Y") )
    out.println("<td  width='16%' class='label' style=\"border-right-style: solid; border-right-color: white\">"+Name_Suffix_Prompt+"</td>");

%>
</tr>

<tr>
<%

if ( Name_Prefix_Accept_Yn.equals("Y") )
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+Name_Prefix+"</td>");


if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
        out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name + "</td>");

}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name + "</td>");
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name + "</td>");
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ First_Name + "</td>");
}
else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Second_Name + "</td>");
}
    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Third_Name + "</td>");
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + Family_Name + "</td>");
}


if ( Name_Suffix_Accept_Yn.equals("Y") )
    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+Name_Suffix+"</td>");

%>
</tr>

<%

try
{
	if(names_in_oth_lang_yn.equals("Y"))
	{

    %>
        <tr >
        <%
		 if(!language_direction.equals("R"))
		{
       
		 if ( Name_Prefix_Accept_Yn.equals("Y") )
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+name_prefix_loc_lang_prompt+"</td>");

       if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }

//start
        if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }
//3
        if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3)  {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }
//2
        if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
                out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");

        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }
//1
		 if ( Name_Suffix_Accept_Yn.equals("Y") )
            out.println("<td  width='16%' class='label' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+name_suffix_loc_lang_prompt+"</td>");
       
        %>
        </tr>
        <tr>
        <%
          
			if ( Name_Prefix_Accept_Yn.equals("Y") )
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+name_prefix_loc_lang+"</td>");        

            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ first_name_loc_lang + "</td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + second_name_loc_lang + "</td>");
            }
                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + third_name_loc_lang + "</td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + family_name_loc_lang + "</td>");
            }

//start
            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ first_name_loc_lang + "</td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + second_name_loc_lang + "</td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + third_name_loc_lang + "</td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + family_name_loc_lang + "</td>");
            }
//3
            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ first_name_loc_lang + "</td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + second_name_loc_lang + "</td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + third_name_loc_lang + "</td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + family_name_loc_lang + "</td>");
            }
//1
            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
                    out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">"+ first_name_loc_lang + "</td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + second_name_loc_lang + "</td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + third_name_loc_lang + "</td>");

            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
                out.println("<td  width='16%' class='data' style=\"border-right-style: solid; border-right-color: white\">" + family_name_loc_lang + "</td>");
            }
			
			  if ( Name_Suffix_Accept_Yn.equals("Y") )
                out.println("<td  width='16%' class='data'  style=\"border-right-style: solid; border-right-color: white\">"+name_suffix_loc_lang+"</td>");

		}
		else if(language_direction.equals("R"))
		{

	
		if ( Name_Suffix_Accept_Yn.equals("Y") )
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+name_suffix_loc_lang_prompt+"</td>");


	  if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");

        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }



		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3)  {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }



		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
        else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }


			

       if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+ first_name_loc_lang_prompt + "</td>");
        }
        else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + second_name_loc_lang_prompt + "</td>");
        }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + third_name_loc_lang_prompt + "</td>");
        }
        else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">" + family_name_loc_lang_prompt + "</td>");
        }


		if ( Name_Prefix_Accept_Yn.equals("Y") )
            out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid;border-top-style: solid; border-right-color: white;border-top-color: white\">"+name_prefix_loc_lang_prompt+"</td>");
		
       
        %>
        </tr>
        <tr>
        <%
          
			if ( Name_Suffix_Accept_Yn.equals("Y") )
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+name_suffix_loc_lang+"</b></td>");

			if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
                    out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+ first_name_loc_lang + "</b></td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + second_name_loc_lang + "</b></td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + third_name_loc_lang + "</b></td>");

            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + family_name_loc_lang + "</b></td>");
            }



			if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+ first_name_loc_lang + "</b></td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + second_name_loc_lang + "</b></td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + third_name_loc_lang + "</b></td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + family_name_loc_lang + "</b></td>");
            }


			
			if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+ first_name_loc_lang + "</b></td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + second_name_loc_lang + "</b></td>");
            }
            else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + third_name_loc_lang + "</b></td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + family_name_loc_lang + "</b></td>");
            }

			

            if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+ first_name_loc_lang + "</b></td>");
            }
            else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + second_name_loc_lang + "</b></td>");
            }
                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + third_name_loc_lang + "</b></td>");
            }
            else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>" + family_name_loc_lang + "</b></td>");
            }



			if ( Name_Prefix_Accept_Yn.equals("Y") )
                out.println("<td  width='16%' class='arabic' style=\"border-right-style: solid; border-right-color: white\" dir='RTL'><b>"+name_prefix_loc_lang+"</b></td>"); 
			
			

		}
            
		}
}
catch(Exception e){out.println(e);
e.printStackTrace();}
%>
</tr>
</table>
</td>
</tr>
<!-- </table>
<table border='0' cellpadding='4' cellspacing='0' width="97%" align="center"> -->
	<tr>
	     <td class="COLUMNHEADER" colspan='4'><fmt:message key="eMP.personaldetails.label" bundle="${mp_labels}"/></td>
	</tr>
    
    <tr>
	    <td   class="label" width="24%" ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
	    <td  class='data' width="24%" >
	       <%if(Sex.equals("M"))
			{  %>
				<fmt:message key="Common.male.label" bundle="${common_labels}"/>
		   <%}else if(Sex.equals("F")){%>
				<fmt:message key="Common.female.label" bundle="${common_labels}"/>
		   <%}else if(Sex.equals("U")){%>
				<fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
		   <%}%>
		 </td>
		 <td   class="label" width="24%" ><fmt:message key="Common.bloodgroup.label" bundle="${common_labels}"/>/<fmt:message key="Common.RhFactor.label" bundle="${common_labels}"/> 
		 </td>
		 <td  class='data' width="24%" ><%=blood_grp_desc%> /<%=rh_factor_desc%></td>

	</tr>
		
    <tr>
	    <td   class="label" width="24%" ><fmt:message key="Common.age.label" bundle="${common_labels}"/> </td>
	    <td  class='data' width="24%" ><%=age_value%></td>
		<td  width="24%" class="label"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
		<td  width="25%" class="label"><b><%=Date_Of_Birth%></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%if(hijirisitespecifApplicable){%><fmt:message key="eMP.Hijri.label" bundle="${mp_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><span id="hiji_date_display"><%=hijri_birth_date%></span></b><%}%></td>
	</tr>
	 <!--above line added for this CRF MMS-QH-CRF-0145 -->
 
    <tr>
    	<td  width="24%" class="label"><fmt:message key="eMP.maritalstatus.label" bundle="${mp_labels}"/></td>
	    <td  class='data' width="15%"><%=Mar_Status_Desc%></td>
		<td  width="24%" class="label"><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/></td>
	    <td class='data' width="25%" >
			<%
			if(!(Place_Of_Birth==null))	
			out.println(Place_Of_Birth);
			if(!(birth_place_code==null))
			out.println(birth_place_desc);	
			%>
		</td>
     </tr>
			
	 <tr>
			<td  class="label"><fmt:message key="Common.category.label" bundle="${common_labels}"/></td>
			<td   class="data" ><%=Pat_Cat_Desc%></td>
		<%if(entitlement_by_pat_cat_yn.equals("Y")){%>	
			<td  class="label"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
			<td   class="data">
		    
				<%if(!patexpirtydate.equals("")){%>
					/<%}%><%=patexpirtydate%>
						</td><%}else {%>
						<td  class="label" colspan='2'>&nbsp;</td>
					<%}%>
	 </tr>

			

     <tr>
	     <td  class="label"><fmt:message key="Common.residency.label" bundle="${common_labels}"/></td>
         <td  class="data">
             <%
					if(citizen_yn.equals("Y")) { %><fmt:message key="Common.citizen.label" bundle="${common_labels}"/> <% }
					else if(citizen_yn.equals("N")) { %><fmt:message key="Common.noncitizen.label" bundle="${common_labels}"/><% } %>
					
        </td>
        <td class="label">
		<fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
        <td  class="data">
			<%
					if(legal_yn.equals("Y")){ %><fmt:message key="Common.legal.label" bundle="${common_labels}"/><% }
					else if(legal_yn.equals("N")){ %><fmt:message key="Common.illegal.label" bundle="${common_labels}"/><% } %>
				  
       </td>
    </tr>
     		
    <tr>
			<td  class="label"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
			<td  class="data">
			<%=Nationality_Desc%></td>
			<td  class="label"><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
			<td  class="data">
		    <%=race_long_desc%>&nbsp;
			</td>
	</tr>
       		
    <tr>
		  <td  class="label"><fmt:message key="eMP.ethnicity.label" bundle="${mp_labels}"/></td>
		  <td  class="data" >
		  <%=ethnic_long_desc%>&nbsp;</td>
		  <td  class="label"><fmt:message key="Common.religion.label" bundle="${common_labels}"/></td>
          <td class="data">
          <%=Relgn_Desc%>&nbsp;</td>
		  
    </tr>
	<tr>
		<td class="label"><fmt:message key="Common.Language.label" bundle="${common_labels}"/></td>
		<td class='data' ><%=language_name%>&nbsp;</td>
        <td class="label"><fmt:message key="eMP.AliasName.label" bundle="${mp_labels}"/></td>
		<td class='data' ><%=Alias_Name%>&nbsp;</td>
        
   </tr>
   
<!--
</table>

<table border='0'  cellspacing='0' cellpadding='4' width='97%' align='center'>
-->
 		
    <%
		
	int order = 0;
    for(int i=0;i<cust_fields.length;i++)
    {

		if(cust_fields[i].charAt(0) == 'D')
        {
            if (i==0)
			{
			   %>
				   <tr>
				        <td class='COLUMNHEADER' colspan='4' > <fmt:message key="Common.additionaldetails.label" bundle="${common_labels}"/>
				        </td>
				   </tr>
			   <%
			}
			if( order%2 == 0)
			{
				if ( i != 0 ) //out.println("<tr><td class='data' colspan='4' height=5>&nbsp</td></tr>");
				out.println("<tr>");
			}
			
		
			int intind_0	= cust_fields[i].indexOf('`');
			String strcf	= cust_fields[i];		
			String strs1	= strcf.substring(intind_0+1, strcf.length());
			int intind_1	= strs1.indexOf('`');
			String lab		= strs1.substring(0, intind_1);
			String val		= strs1.substring(intind_1+1);
            out.println("<td class='label'>"+lab+"</td>") ;
			out.println("<td class='data'>"+val+"</td>");
            order++;
        }
    }
	if( order %2 != 0 && order!=0)
	{
	out.println("<td  colspan='2'></td></tr>");
	
	}
	
%>

</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<a name='addr'></a>
       <table cellpadding='4' cellspacing='1' border ='0' width='99%' align='center'>
                <tr>
                    <td  class='BODYCOLORFILLED' width='1%'>&nbsp;</td>
                    <td width='99%'  class='BODYCOLORFILLED' valign='top' colspan='4'>
                    <table cellpadding='2' cellspacing='0' border='0' height='100%' width='99%'>
                        <tr>
                            <td class='COLUMNHEADER'>&nbsp;</td>
                            <td  class='COLUMNHEADER' ><fmt:message key="eMP.residenceaddress.label" bundle="${mp_labels}"/></td>
                            <td  class='COLUMNHEADER' colspan='2'><fmt:message key="Common.MailingAddress.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        </tr>
	                    
<%
    Addr_val = "" ;
    for(int i=0;i<contact_col_names.length;i++)
    {
            out.println("<tr>") ;
            out.println("<td class='label' width='24%' >"+contact_prompts[i]+"&nbsp;</td>") ;
            if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                Addr_val = Resi_Addr_Line1;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                Addr_val = Resi_Addr_Line2;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                Addr_val = Resi_Addr_Line3;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                Addr_val = Resi_Addr_Line4;
            else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                Addr_val = Resi_Area_Desc;
            else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                Addr_val = Resi_Town_Desc;
			else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                Addr_val = region_desc;
            else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                Addr_val = Resi_Postal_Code;
            out.println("<td   class='data' width='24%'>"+Addr_val+"</td>") ;

            if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                Addr_val = Mail_Addr_Line1;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                Addr_val = Mail_Addr_Line2;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                Addr_val = Mail_Addr_Line3;
            else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                Addr_val = Mail_Addr_Line4;
            else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                Addr_val = mail_res_area_desc;
            else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                Addr_val = mail_res_town_desc;
			else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                Addr_val = mail_region_desc;
            else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                Addr_val = Mail_Postal_Code;

        out.println("<td  class='data' width='24%'>"+Addr_val+"</td>") ;
        out.println("<td  class='data' width='25%'>&nbsp;</td>") ;
        out.println("</tr>") ;
		out.println("");
    }
%>
<tr>
	<td  class='label' width='24%'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
	<td class='data' width='24%'><%=Resi_Country_Name%></td>
	<td class='data' width='24%'><%=Mail_Country_Name%></td>
	<td class='data' >&nbsp;</td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.valid.label" bundle="${common_labels}"/></td>
	<%
	if(Resi_Invalid1_Yn.equals("N"))
	{
	%>

		<td ><img src='../../eCommon/images/enabled.gif' ></td>

	<% }
	else
	{
	%>
		<td ><img src='../../eCommon/images/RRnwd.gif'></td>

	<% }

    if(Mail_Invalid1_Yn.equals("N"))
     {
%>

        <td ><img src='../../eCommon/images/enabled.gif' ></td>

<%  }

  else
    {
%>
    
    <td ><img src='../../eCommon/images/RRnwd.gif'></td>

<% 
    }
%>
<td class='data' >&nbsp;</td>
</tr>
<tr>
	<td  class='label' ><fmt:message key="Common.contact.label" bundle="${common_labels}"/></td>
	<td  class='data'><%=Resi_Contact1_Name%></td>
	<td class='data' ><%=Mail_Contact1_Name%></td>
	<td class='data' >&nbsp;</td>
</tr>

</table>
<!--
</td></tr></table>
</td>
</tr>
</table>
</td>
</tr>
</table>
-->
<tr>
<td  class='BODYCOLORFILLED' width='1%'>&nbsp;</td>
<td width='99%'  class='BODYCOLORFILLED' valign='top' colspan='4'>
<table cellpadding='2' cellspacing='0' border='0' height='100%' width='99%'>
	<tr>
                <td  class='COLUMNHEADER' colspan='4'  width='100%'><fmt:message key="eMP.ContactModes.label" bundle="${mp_labels}"/></td>
     </tr> 

	 <%
		  String sql_sel="select short_desc,contact_mode from mp_contact_mode_lang_vw where language_id='"+locale+"' and contact_mode in ('PRN','ORN') order by contact_mode desc";
		  pstmt1 = con.prepareStatement(sql_sel);
		  rs2 = pstmt1.executeQuery();
		  while (rs2.next()) {
			  if(rs2.getString("contact_mode").equals("PRN")) {
				  contactModeOne = rs2.getString("short_desc");
			  } else if(rs2.getString("contact_mode").equals("ORN")) {
				  contactModeTwo = rs2.getString("short_desc");
			  }
		  }
          if(pstmt1 != null) pstmt1.close();
		  if(rs2 != null) rs2.close();
		
	 %>

<tr>
		<!--<td  class='label' width='24%'><fmt:message key="eMP.primaryresidenceno.label" bundle="${mp_labels}"/></td> -->
		<td  class='label' width='24%'><%=contactModeOne%></td>
		<td  class='data' width='24%'><%=Prn_Tel_No%></td>
		<!-- <td  class='label' width='24%'><fmt:message key="Common.OtherRes.label" bundle="${common_labels}"/></td> -->
		<td  class='label' width='24%'><%=contactModeTwo%></td>
		<td  class='data' width='25%'><%=Orn_Tel_No%></td>
</tr>

<tr>
      <td  class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
      <td  class='data' ><%=email_id%></td>
      <td  class='data' colspan='2'>&nbsp;</td>
</tr>

<tr>
	<td  class='label'><fmt:message key="eMP.othermodes.label" bundle="${mp_labels}"/> </td>
	<td colspan=3 class='label' >&nbsp;</td>
</tr>
	
<tr>
    <td  class='label'><%=CONTACT3_MODE_DESC%></td>
    <td  class='data' ><%=Contact3_No%></td>
    <td  class='label' colspan=2></td>
</tr>

<tr> 
	<td  class='label'><%=CONTACT4_MODE_DESC %></td>
	<td  class='data' ><%=Contact4_No%></td>
	<td  class='label' colspan=2></td>
</tr>

<tr>
	<td  class='label'><%=CONTACT5_MODE_DESC%></td>
    <td  class='data' ><%=Contact5_No %></td>
	<td  class='label' colspan=2></td>
</tr>

<%
    order = 0;
    for(int i=0;i<cust_fields.length;i++)
    {
        if(cust_fields[i].charAt(0) == 'C')
        {
			if (i==0)
			{
			   %>
				   <tr>
				       <td class='COLUMNHEADER' colspan='4'><fmt:message key="Common.additionaldetails.label" bundle="${common_labels}"/></td>
				   </tr>
			   <%
			}

            if(order%2 == 0)        
                //out.println("<tr></tr><tr>");

            out.println("");
			int intind_0	= cust_fields[i].indexOf('`');
			String strcf	= cust_fields[i];		
			String strs1	= strcf.substring(intind_0+1, strcf.length());
			int intind_1	= strs1.indexOf('`');
			String lab		= strs1.substring(0, intind_1);
			String val		= strs1.substring(intind_1+1);

            out.println("<tr><td class=label >"+lab+"</td>") ;
            out.println("<td class='data' >"+val+"</td>");
			out.println("<td colspan=2 class='label'>&nbsp;</td></tr>");
			
        }
    }
%>
</tr>

</table>
</td>
</tr>
</table>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	
<a name='fin'></a>
<% 
 // if(bl_install_yn.equals("Y"))
    //{%>

<%--  <jsp:include page= "../../eBL/jsp/BLFinDtlQryMain.jsp"  flush="true">
<jsp:param name="patient_id" value="<%=patient%>" />
</jsp:include>--%>
<%//}%>
<%
    Addr_val = "" ;
    related_Addr_val = "";
	String line4="";
	String postalcode="";
	String tempPro="";
	String tempProVal="";
	int tempProF=0;

    for(int i=0;i<contact_col_names.length;i++)
    {    
       
			tempPro=contact_prompts[i];

			if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
			{
		        nKin_Addr_val="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				nKin_Addr_val = nKin_Addr_val+"<td   class='data' >"+Nkin_Addr_Line1+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
			{    
		        Addr_val="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Addr_val= Addr_val+"<td   class='data' >"+Nkin_Addr_Line2+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
			{               
		        related_Addr_val="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				related_Addr_val=related_Addr_val+"<td    class='data'>"+Nkin_Addr_Line3+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
			{                
		        line4="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				line4 =line4+"<td   class='data'>"+Nkin_Addr_Line4+"&nbsp;</td>" ;				
            }

			else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
			{   
				Nkin_Area_Code="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Nkin_Area_Code=Nkin_Area_Code+"<td   class='data'>"+nkin_area_desc+"&nbsp;</td>" ;
			}
            else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
            {   
				Nkin_Town_Code="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Nkin_Town_Code=Nkin_Town_Code+"<td   class='data'>"+nkin_town_desc+"&nbsp;</td>" ;
			}
			else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
            {   
				Nkin_Region_Code="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Nkin_Region_Code=Nkin_Region_Code+"<td   class='data'>"+nkin_region_desc+"&nbsp;</td>" ;
				
			}
            else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
              {   
				Nkin_Postal_Desc="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Nkin_Postal_Desc=Nkin_Postal_Desc+"<td   class='data'>"+Nkin_Postal_Code+"&nbsp;</td>" ;
			}
                     
    }
%>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<a name='kin'></a>
			<ul id="tablist" class="tablist">
				<li class="tablistitem" title="<fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/>">
					<a onclick="tab_click2('#kin','firstkin')" class="tabClicked" id="firstkin" >
						<span class="tabSpanclicked" id="firstkinspan"><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Contact Mode and Address details">
					<a onclick="tab_click2('#kin1','firstkin1')" class="tabA" id="firstkin1" >
						<span class="tabAspan" id="firstkin1span"><fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="<fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/>">
					<a onclick="tab_click2('#empyr','firstempyr')" class="tabA" id="firstempyr" >
						<span class="tabAspan" id="firstempyrspan"><fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/></span>
					</a>
				</li>	
			</ul>
<table border="0" cellpadding="0" cellspacing="0" width="97%" align="center" valign=top>
<tr>
<td width=100% class="BORDER" valign=top>
<table width='100%' border=0 cellpadding='4' cellspacing='0' valign=top>
<tr>
<td valign=top>
<table width='100%' cellpadding='4' cellspacing='1' border=0 valign=top>
<tr>
	<td  class='label' width="24%">&nbsp;</td>
	<td class='DATA' width="24%">&nbsp;</td>
	<td class='DATA' width="24%">&nbsp;</td>
	<td class='DATA' width="25%">&nbsp;</td>
</tr>
<tr>
		<td  class='label'  ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
		<td  class='data' ><%=Nkin_Contact_Name%></td>
		<%=nKin_Addr_val%>
 </tr>

<tr>
		<td  class='label'  ><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
		<td  class='data' ><%=Nkin_Contact_Relation_Desc%></td>
		<%=Addr_val%>
</tr>


<tr>
		<%if(accept_national_id_no_yn.equals("Y")){%>
		<td  class='label'  ><%=nat_id_prompt%></td>
		<td  class='data' ><%=contact1_nat_id_no%></td>
		<%} else {%>
		<td class='label' colspan='2'>&nbsp;</td>
		<%}%>
		<%=related_Addr_val%>
		<%
	
		%>
</tr>


<tr>
		<td  class='label'  ><%=Alt_Id1_Type%></td>
		<td class='data' ><%=contact1_alt_id1_no%></td>
		<%=line4%>
</tr>

<%	 //Code added by Gomathi Shankar.
/* Friday, April 30, 2010 venkat s PE_EXE
	   try
	   {
	   stmt=con.createStatement();
	   rs1=stmt.executeQuery("SELECT ALT_ID2_TYPE,ALT_ID3_TYPE,ALT_ID4_TYPE FROM MP_PARAM");
	   while(rs1.next())
		{
		   
		   aid2= rs1.getString(1);
		   if(aid2==null) aid2="";
		   aid3= rs1.getString(2);
		   if(aid3==null)aid3="";
		   aid4= rs1.getString(3);
		   if(aid4==null)aid4="";
		}
	   }catch(Exception e){out.println(e); e.printStackTrace();}
	   */
%>

<tr>
	<td  class='label' ><%=Alt_Id2_Type%></td>
	<td  class='data' ><%=contact1_alt_id2_no%></td>
	<%=Nkin_Town_Code%>
</tr>


<tr>
	<td  class='label' ><%=Alt_Id3_Type%></td>
	<td  class='data' ><%=contact1_alt_id3_no%></td>
	<%=Nkin_Area_Code%>
	
</tr>
<tr>
	<td  class='label' ><%=Alt_Id4_Type%></td>
	<td  class='data' ><%=contact1_alt_id4_no%></td>
	<%=Nkin_Region_Code%>	
</tr>

<tr>
<%
 if(accept_oth_alt_id_yn.equals("Y"))
	{%>
		<td  class='label'  ><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>
		<td  class='data' ><%=nkin_oth_alt_desc%>&nbsp;&nbsp;&nbsp;<%=nkin_oth_alt_id_no%></td>
   <%}else{%>
				<td colspan='2' class = 'label'>&nbsp;</td>
   <%}%>
               <%=Nkin_Postal_Desc%>
</tr>

<tr>
		<td class='label'  ><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
		<td  class='data' ><%=contact1_birth_date%></td>
		<td  class='label'  ><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
		<td class='DATA'  ><%=Nkin_Country_Name%></td>
</tr>

<tr>
		<td  class='label'  ><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td>
		<td  class='data' ><%=Nkin_Job_Title%></td>
		<td  class='label'  ><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>
		<td class='DATA'  ><%=Nkin_Res_Tel_No%></td>
</tr>

<tr>
		<td  class='data' >&nbsp;</td>
		<td  class='data' >&nbsp;</td>
		<td  class='label'  ><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>
		<td class='DATA'  ><%=nkin_mob_tel_no%></td>
</tr>

<tr>
		<td  class='data'>&nbsp;</td>
		<td  class='data'>&nbsp;</td>
		<td  class='label'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
		<td class='DATA' ><%=Nkin_Off_Tel_No%></td>
</tr>

<tr>
		<td class='DATA' >&nbsp;</td>
		<td class='DATA' >&nbsp;</td>
		<td  class='label' ><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
		<td class='DATA' ><%=nkin_email_id%>&nbsp;</td>
</tr>


<%
    order = 0;
    for(int i=0;i<cust_fields.length;i++)
    {
        if(cust_fields[i].charAt(0) == 'N')
        {
			 if (i==0)
			{
			   %>
				   <tr><td class='COLUMNHEADER' colspan='4' >&nbsp;<fmt:message key="Common.additionaldetails.label" bundle="${common_labels}"/></td></tr>
			   <%
			}
            if(order%2 == 0)        
                out.println("</tr><tr>");

			int intind_0	= cust_fields[i].indexOf('`');
			String strcf	= cust_fields[i];		
			String strs1	= strcf.substring(intind_0+1, strcf.length());
			int intind_1	= strs1.indexOf('`');
			String lab		= strs1.substring(0, intind_1);
			String val		= strs1.substring(intind_1+1);

            out.println("<td class=label '>"+lab+"&nbsp;</td>") ;
            out.println("<td class='data'>"+val+"</td>");
       }
    }
    out.println("</tr>") ;
%>
<tr>
	<td class='label' >&nbsp;</td>
	<td class='DATA'>&nbsp;</td>
	<td class='DATA' >&nbsp;</td>
	<td class='DATA' >&nbsp;</td>
</tr>
</table>
</td></tr></table>
</td></tr></table>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%
    Addr_val = "" ;
    related_Addr_val = "";
	line4="";
	postalcode="";
	tempPro="";
	tempProVal="";
	tempProF=0;

    for(int i=0;i<contact_col_names.length;i++)
    {    
        
			tempPro=contact_prompts[i];

			if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
			{
		        nKin_Addr_val="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				nKin_Addr_val=nKin_Addr_val+"<td   class='data'>"+Fton_Addr_Line1+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
			{    
		        Addr_val="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Addr_val=Addr_val+"<td   class='data'>"+Fton_Addr_Line2+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
			{               
		        related_Addr_val="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				related_Addr_val=related_Addr_val+"<td   class='data'>"+Fton_Addr_Line3+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
			{                
		        line4="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				line4=line4+"<td   class='data' >"+Fton_Addr_Line4+"&nbsp;</td>" ;				
            }
			else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
			{   
				Nkin_Area_Code="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Nkin_Area_Code=Nkin_Area_Code+"<td   class='data'>"+fton_area_desc+"&nbsp;</td>" ;
			}
            else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
            {   
				Nkin_Town_Code="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Nkin_Town_Code=Nkin_Town_Code+"<td   class='data'>"+fton_town_desc+"&nbsp;</td>" ;
			}
			else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
            {   
				Nkin_Region_Code="<td   class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Nkin_Region_Code=Nkin_Region_Code+"<td   class='data'>"+fton_region_desc+"&nbsp;</td>" ;
				
			}
			else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
			{
		        postalcode="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				postalcode=postalcode+"<td   class='data' >"+Fton_Postal_Code+"&nbsp;</td>";				

            }
       }
%>
		 <a name='kin1'></a>
			<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="<fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/>">
				<a onclick="tab_click2('#kin','secondkin')" class="tabA" id="secondkin" >
					<span class="tabAspan" id="secondkinspan"><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Contact Mode and Address details">
				<a onclick="tab_click2('#kin1','secondkin1')" class="tabClicked" id="secondkin1" >
					<span class="tabSpanclicked" id="secondkin1span"> <fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></span>
				</a>
			</li>

			<li class="tablistitem" title="<fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/>">
				<a onclick="tab_click2('#empyr','secondempr')" class="tabA" id="secondempr" >
					<span class="tabAspan" id="secondemprspan"><fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>	
		</ul>


<table cellspacing='0' cellpadding='0' width='97%' align=center>
<tr><td>
		<table cellspacing='1' cellpadding='4' width='100%' border=0>

			<tr>
					<td class='label' width="24%" >&nbsp;</td>
					<td class='DATA' width="24%" >&nbsp;</td>
					<td class='DATA' width="24%" >&nbsp;</td>
					<td class='DATA' width="25%" >&nbsp;</td>
			</tr>
			<tr>
					<td  class='label' ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
					<td  class='data' ><%=Fton_Contact_Name%>&nbsp;</td>
					<%=nKin_Addr_val%>
			</tr>

			

			<tr>
					<td  class='label' ><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
					<td  class='data' ><%=Fton_Contact_Relation_Desc%>&nbsp;</td>
					<%=Addr_val%>
			</tr>

			

			<tr>
					<%if(accept_national_id_no_yn.equals("Y")){%>
					<td  class='label'  ><%=nat_id_prompt%>&nbsp;</td>			
					<td  class='data' ><%=fton_nat_id_no%></td>
					<%} else {%>
					<td class='label' colspan='2'>&nbsp;</td>
					<%}%>
					<%=related_Addr_val%>
			</tr>

			

			<%
			 if(accept_oth_alt_id_yn.equals("Y"))
			{%>
			<tr>
					<td  class='label'  ><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>
					<td  class='data'  ><%=fton_alt_desc%>&nbsp;&nbsp;&nbsp;<%=fton_alt_id_no%></td>
			<%}else{%>
						<td colspan='2' class='label'>&nbsp;</td>
			<%}%>
					    <%=line4%>
			</tr>

			

			<tr>
					<td  class='label' ><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td>
					<td  class='data'><%=Fton_Job_Title%>&nbsp;</td>
					<%=Nkin_Town_Code%>
			</tr>

			

			<tr>
					<td  class='label' ><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>
					<td class='DATA'  ><%=Fton_Res_Tel_No%>&nbsp;</td>
					<%=Nkin_Area_Code%>
			</tr>

			

			<tr>
					<td  class='label'  ><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>
					<td class='DATA'  ><%=fton_mob_tel_no%>&nbsp;</td>
					<%=Nkin_Region_Code%>
			</tr>

			

			<tr>
					<td  class='label'  ><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
					<td class='DATA' ><%=Fton_Off_Tel_No%>&nbsp;</td>
					<%=postalcode%>
			</tr>

			

			<tr>
					<td  class='label'  ><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
					<td class='DATA'  ><%=fton_email_id%></td>
					<td class='label' ><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>	
					<td class='DATA' ><%=Fton_Country_Name%>&nbsp;</td>
			</tr>
			<tr>
					<td class='label'  >&nbsp;</td>
					<td class='DATA'  >&nbsp;</td>
					<td class='DATA' >&nbsp;</td>
					<td class='DATA'  >&nbsp;</td>
			</tr> 
		</table>
	<br>
		
</td></tr></table>


	<table border='0' cellpadding='4' cellspacing='0' width='97%' align='center'>
		 <tr></tr><tr></tr><tr></tr>
		 <tr></tr><tr></tr><tr></tr>
 <%
     order = 0;
    for(int i=0;i<cust_fields.length;i++)
    {
        if(cust_fields[i].charAt(0) == 'F')
        {
			 if (i==0)
			{
			   %>
				   <tr><td class='COLUMNHEADER' colspan='4' >&nbsp;<fmt:message key="Common.additionaldetails.label" bundle="${common_labels}"/></td></tr>
			   <%
			}
            if( order%2 == 0)
            out.println("<tr>");
			
			int intind_0	= cust_fields[i].indexOf('`');
			String strcf	= cust_fields[i];		
			String strs1	= strcf.substring(intind_0+1, strcf.length());
			int intind_1	= strs1.indexOf('`');
			String lab		= strs1.substring(0, intind_1);
			String val		= strs1.substring(intind_1+1);

            out.println("<td colspan='6' class='label'  width='1%'  >"+lab+"&nbsp;</td>") ;
			out.println("<td class='data' width='1%' >" +val+"</td>");
			
            order++;

			
        }
    }
	if( order %2 != 0 && order!=0)
	out.println("<td  COLSPAN=7>&nbsp;</td>");
%>

 </table>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%
    Addr_val = "" ;
    related_Addr_val = "";
	line4="";
	postalcode="";
	tempPro="";
	tempProVal="";
	tempProF=0;
	String empr_region_code="";
	String empr_area_code="";
	String empr_town_code="";


    for(int i=0;i<contact_col_names.length;i++)
    {    
       		tempPro=contact_prompts[i];

			if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
			{
		        nKin_Addr_val="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				nKin_Addr_val=nKin_Addr_val+"<td   class='data' >"+Emplr_Addr_Line1+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
			{    
		        Addr_val="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				Addr_val=Addr_val+"<td   class='data' >"+Emplr_Addr_Line2+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
			{               
		        related_Addr_val="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				related_Addr_val=related_Addr_val+"<td   class='data' >"+Emplr_Addr_Line3+"&nbsp;</td>" ;
            }
			else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
			{                
		        line4="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				line4=line4+"<td   class='data' >"+Emplr_Addr_Line4+"&nbsp;</td>" ;				
            }
			else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
			{
		        empr_region_code="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				empr_region_code=empr_region_code+"<td   class='data' >"+emplr_region_desc+"&nbsp;</td>";				
            }
			else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
			{
		        empr_town_code="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				empr_town_code=empr_town_code+"<td   class='data' >"+emplr_town_desc+"&nbsp;</td>";				
            }
			else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
			{
		        empr_area_code="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				empr_area_code=empr_area_code+"<td   class='data' >"+emplr_area_desc+"&nbsp;</td>";				
            }
			else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
			{
		        postalcode="<td  class='label'  >"+contact_prompts[i]+"&nbsp;</td>";
				postalcode=postalcode+"<td   class='data' >"+Emplr_Postal_Code+"&nbsp;</td>";
            }
    }
	
%>
<br>
<a name='empyr'></a>
	<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="<fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/>">
				<a onclick="tab_click2('#kin','thirdkin')" class="tabA" id="thirdkin" >
					<span class="tabAspan" id="thirdkinspan"><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Contact Mode and Address details">
				<a onclick="tab_click2('#kin1','thirdkin1')" class="tabA" id="thirdkin1" >
					<span class="tabAspan" id="thirdkin1span"> <fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></span>
				</a>
			</li>

			
			<li class="tablistitem" title="<fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/>">
				<a onclick="tab_click2('#empyr','thirdempr')" class="tabClicked" id="thirdempr" >
					<span class="tabSpanclicked" id="thirdemprspan"><fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>	
		</ul>

<table cellspacing='0' cellpadding='0' width='97%' align=center>
<tr><td>
<table cellspacing='0' cellpadding='4' width='100%' border=0>
<tr><td  width="5%" class='columnheader'>&nbsp;</td><td  width="20%" class='columnheader'><fmt:message key="Common.employerdetails.label" bundle="${common_labels}"/>&nbsp;</td><td class='COLUMNHEADERCENTER' colspan='2' width="40%"><fmt:message key="Common.employeedetails.label" bundle="${common_labels}"/></td></tr>
<tr>
		<td  class='label' width="24%">&nbsp;</td>
		<td class='DATA' width="24%">&nbsp;</td>
		<td class='DATA' width="24%">&nbsp;</td>
		<td class='DATA' width="25%">&nbsp;</td>
</tr>
<tr>
		<td class='label'  ><fmt:message key="Common.orgName.label" bundle="${common_labels}"/></td>
		<td class='DATA'  ><%=organization_name%></td>
		<td class='label'   ><fmt:message key="Common.employmentid.label" bundle="${common_labels}"/></td>
		<td class='DATA'  ><%=Patient_Employee_Id%></td>
</tr>
<tr>
		<td  class='label'  ><fmt:message key="eMP.ContactPersonName.label" bundle="${mp_labels}"/></td>
		<td class='DATA' ><%=Emplr_Contact_Name%>&nbsp;</td>
		<td  class='label'  ><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/></td>
		<td class='DATA'  ><%=emplr_ocpn_class_desc%></td>
</tr>
<tr>
		<%=nKin_Addr_val%>
		<td class='label'  ><fmt:message key="eMP.OccupationofthePerson.label" bundle="${mp_labels}"/></td>
		<td class='DATA' ><%=Ocpn_Desc%></td>
</tr>



<tr>
		<%=Addr_val%>
		<td class='label'  valign=top><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class='DATA' ><%=Employment_Status%></td>
</tr>



<tr>
		<%=related_Addr_val%>
		<td  class='data'>&nbsp;</td>
		<td  class='data'>&nbsp;</td>
</tr>



<tr>
		<%=line4%>
		<td  class='data'>&nbsp;</td>
		<td  class='data'>&nbsp;</td>
</tr>



<tr>
		<%=empr_town_code%>	
		<td class='data'>&nbsp;</td>
		<td class='data'>&nbsp;</td>
</tr>



<tr>
		<%=empr_area_code%>
		<td width="20%" class='data'>&nbsp;</td>
		<td width="20%" class='data'>&nbsp;</td>
</tr>



	<tr>
		<%=empr_region_code%>
		<td width="20%" class='data'>&nbsp;</td>
		<td width="20%" class='data'>&nbsp;</td>
</tr>



<tr>
		<%=postalcode%>
		<td width="20%" class='data'>&nbsp;</td>
		<td width="20%" class='data'>&nbsp;</td>
</tr>
<tr>
		<td class='label' ><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
		<td class='DATA' ><%=Emplr_Country_Name%></td>
		<td class='data'>&nbsp;</td>
		<td class='data'>&nbsp;</td>
</tr>
<tr>
		<td class='label' ><fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></td>
		<td class='DATA' ><%=Emplr_Res_Tel_No%>&nbsp;</td>
		<td class='data'>&nbsp;</td>
		<td class='data'>&nbsp;</td>
</tr>
	


<tr>
		<td  class='label' ><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
		<td class='DATA' ><%=Emplr_Off_Tel_No%></td>
		<td  class='data'>&nbsp;</td>
		<td  class='data'>&nbsp;</td>
</tr>



<tr>
		 <td  class='label' >&nbsp;</td>
		 <td class='DATA' >&nbsp;</td>
		 <td class='DATA' >&nbsp;</td>
		 <td class='DATA' >&nbsp;</td>
</tr></table>
</td>
</tr>
</table>

	 <table border='0' cellspacing='0' cellpadding='4' width='97%' align='center'>
	 <tr></tr><tr></tr><tr></tr><tr></tr>

  <%
   order = 0;
    for(int i=0;i<cust_fields.length;i++)
    {
        if(cust_fields[i].charAt(0) == 'E')
        {
			if (i==0)
			{
			   %>
				   <tr><td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.additionaldetails.label" bundle="${common_labels}"/></td></tr>
			   <%
			}
            if( order%2 == 0)
            out.println("<tr>");
			
			int intind_0	= cust_fields[i].indexOf('`');
			String strcf	= cust_fields[i];		
			String strs1	= strcf.substring(intind_0+1, strcf.length());
			int intind_1	= strs1.indexOf('`');
			String lab		= strs1.substring(0, intind_1);
			String val		= strs1.substring(intind_1+1);

            out.println("<td colspan='6' class='label'  width='1%'  >"+lab+"&nbsp;</td>") ;
			out.println("<td class='data' width='1%' >" +val+"</td>");
			
            order++;

			
        }
    }
	if( order %2 != 0 && order!=0)
	out.println("<td  COLSPAN=7>&nbsp;</td>");
%>

 </table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<!--<a name='pat_docs_tab'></a>

<table width='100%' cellpadding='0' cellspacing='0' border='0'>
<tr>
        <td  class='COLUMNHEADER' width='20%'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
        <td  class='COLUMNHEADER' width='20%'><fmt:message key="Common.documentno.label" bundle="${common_labels}"/></td>
        <td  class='COLUMNHEADER' width='20%'><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
        <td  class='COLUMNHEADER' width='20%'><fmt:message key="eMP.PlaceOfIssue.label" bundle="${mp_labels}"/></td>
        <td  class='COLUMNHEADER' width='30%'><fmt:message key="Common.IssueDate.label" bundle="${common_labels}"/></td>
		
		 <td  class='COLUMNHEADER' width='20%'><fmt:message key="Common.view.label" bundle="${common_labels}"/><fmt:message key="Common.Document.label" bundle="${common_labels}"/></td>
    </tr>
</table>
</td></tr><tr><td> -->
<!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->
<a name='pat_docs_tab'></a>
<table width='97%%' cellpadding='0' align='center' cellspacing='0' border='0'>
<tr>
        <td  class='COLUMNHEADER' width='20%'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
        <td  class='COLUMNHEADER' width='15%'><fmt:message key="Common.documentno.label" bundle="${common_labels}"/></td>
        <td  class='COLUMNHEADER' width='15%'><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
        <td  class='COLUMNHEADER' width='30%'><fmt:message key="eMP.PlaceOfIssue.label" bundle="${mp_labels}"/></td>
        <td  class='COLUMNHEADER' width='30%'><fmt:message key="Common.IssueDate.label" bundle="${common_labels}"/></td>
		
		 <td  class='COLUMNHEADER' width='30%'><fmt:message key="Common.view.label" bundle="${common_labels}"/><fmt:message key="Common.Document.label" bundle="${common_labels}"/></td>
    </tr>
	 <!--   end PMG2012-CRF-0006 [IN034693]   -->
    <%
      
    	/* sql.setLength(0);
		sql.append("SELECT (SELECT SHORT_DESC FROM MP_DOCUMENT_TYPE_LANG_VW WHERE DOC_TYPE = A.DOC1_TYPE AND LANGUAGE_ID = '"+locale+"') DOC1_TYPE_DESC, DOC1_NUM, TO_CHAR(DOC1_EXP_DATE,'DD/MM/YYYY') DOC1_EXP_DATE, DOC1_PLACE_OF_ISSUE, TO_CHAR(DOC1_ISS_DATE,'DD/MM/YYYY') DOC1_ISS_DATE, (SELECT SHORT_DESC FROM MP_DOCUMENT_TYPE_LANG_VW WHERE DOC_TYPE = A.DOC2_TYPE AND LANGUAGE_ID = '"+locale+"') DOC2_TYPE_DESC, DOC2_NUM, TO_CHAR(DOC2_EXP_DATE,'DD/MM/YYYY') DOC2_EXP_DATE, DOC2_PLACE_OF_ISSUE, TO_CHAR(DOC2_ISS_DATE,'DD/MM/YYYY') DOC2_ISS_DATE, (SELECT SHORT_DESC FROM MP_DOCUMENT_TYPE_LANG_VW WHERE DOC_TYPE = A.DOC3_TYPE AND LANGUAGE_ID = '"+locale+"') DOC3_TYPE_DESC,DOC3_NUM, TO_CHAR(DOC3_EXP_DATE,'DD/MM/YYYY') DOC3_EXP_DATE, DOC3_PLACE_OF_ISSUE, TO_CHAR(DOC3_ISS_DATE,'DD/MM/YYYY') DOC3_ISS_DATE, (SELECT SHORT_DESC FROM MP_DOCUMENT_TYPE_LANG_VW WHERE DOC_TYPE = A.DOC4_TYPE AND LANGUAGE_ID = '"+locale+"') DOC4_TYPE_DESC, DOC4_NUM, TO_CHAR(DOC4_EXP_DATE,'DD/MM/YYYY') DOC4_EXP_DATE, DOC4_PLACE_OF_ISSUE, TO_CHAR(DOC4_ISS_DATE,'DD/MM/YYYY') DOC4_ISS_DATE,  FROM MP_PAT_DOCUMENTS A WHERE PATIENT_ID = ?");
        
		   pstmt = con.prepareStatement(sql.toString());
		  pstmt.setString(1, patient);
         oth_rset = pstmt.executeQuery();
       if(oth_rset !=null)
           if(oth_rset.next())
           {
				 doc1_exp_date=oth_rset.getString("DOC1_EXP_DATE");
				if(doc1_exp_date != null)
				{
				doc1_exp_date= DateUtils.convertDate(doc1_exp_date,"DMY","en",localeName);
				}
				else
					doc1_exp_date="&nbsp;";
				
				doc1_iss_date=oth_rset.getString("DOC1_ISS_DATE");
				if(doc1_iss_date != null)
				{
					doc1_iss_date= DateUtils.convertDate(doc1_iss_date,"DMY","en",localeName);
				}
				else
					doc1_iss_date="&nbsp;";

				doc2_exp_date=oth_rset.getString("DOC2_EXP_DATE");
				if(doc2_exp_date != null)
				{
					doc2_exp_date= DateUtils.convertDate(doc2_exp_date,"DMY","en",localeName);
				}
				else
					doc2_exp_date="&nbsp;";
				doc2_iss_date=oth_rset.getString("DOC2_ISS_DATE");
				if(doc2_iss_date != null)
				{
					doc2_iss_date= DateUtils.convertDate(doc2_iss_date,"DMY","en",localeName);
				}
				else
					doc2_iss_date="&nbsp;";

				doc3_exp_date=oth_rset.getString("DOC3_EXP_DATE");
				if(doc3_exp_date != null)
				{
					doc3_exp_date= DateUtils.convertDate(doc3_exp_date,"DMY","en",localeName);
				}
				else
					doc3_exp_date="&nbsp;";

				doc3_iss_date=oth_rset.getString("DOC3_ISS_DATE");
				if(doc3_iss_date != null)
				{
					doc3_iss_date= DateUtils.convertDate(doc3_iss_date,"DMY","en",localeName);
				}
				else
					doc3_iss_date="&nbsp;";

				doc4_exp_date=oth_rset.getString("DOC4_EXP_DATE");
				if(doc4_exp_date != null)
				{
					doc4_exp_date= DateUtils.convertDate(doc4_exp_date,"DMY","en",localeName);
				}
				else
					doc4_exp_date="&nbsp;";

				doc4_iss_date=oth_rset.getString("DOC4_ISS_DATE");
				if(doc4_iss_date != null)
				{
					doc4_iss_date= DateUtils.convertDate(doc4_iss_date,"DMY","en",localeName);
				}
				else
					doc4_iss_date="&nbsp;";

			Tuesday, May 04, 2010 pe_exe Venkat s commented*/ 
				
    %>
                
                     <td class='data' width='20%' >&nbsp;<%=doc1_type_desc%></td>
                    <td class='data' width='20%'><%=doc1_num%></td>
                    <td class='data' width='15%'><%=doc1_exp_date %></td>
                    <td class='data' width='30%'><%=doc1_place_of_issue%></td>
                    <td class='data' width='30%'><%=doc1_iss_date%></td>
					<!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->
				   <% if(doc1!=null){%> 
					 <td class='data' width='30%'><a href="javascript:viewDocument('<%=patient%>','DOC1_IMAGE')"><fmt:message key="Common.view.label" bundle="${common_labels}"/></a></td>
					<%}%>
                 </tr>
                    <!-- end PMG2012-CRF-0006 [IN034693]  -->

                 <tr> 
                     <td class='data'>&nbsp;<%=doc2_type_desc%></td>
                     <td class='data'><%=doc2_num%></td>
                     <td class='data' width='15%'><%=doc2_exp_date %></td>
                     <td class='data' width='30%'><%=doc2_place_of_issue%></td>
                     <td class='data' width='30%'><%= doc2_iss_date%></td>
					 <!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->
				   <% if(doc2!=null){%> 
					 <td class='data' width='30%'><a href="javascript:viewDocument('<%=patient%>','DOC2_IMAGE')"><fmt:message key="Common.view.label" bundle="${common_labels}"/></a></td>
					<%}%>
                 </tr>
                   <!-- end PMG2012-CRF-0006 [IN034693]  -->

                 <tr> 
                     <td class='data'>&nbsp;<%=doc3_type_desc%></td>
                     <td class='data'><%=doc3_num%></td>
                     <td class='data' width='15%'><%=doc3_exp_date%></td>
                     <td class='data' width='30%'><%=doc3_place_of_issue %></td>
                     <td class='data' width='30%'><%=doc3_iss_date%></td>
					   <!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->
				   <% if(doc3!=null){%> 
					 <td class='data' width='30%'><a href="javascript:viewDocument('<%=patient%>','DOC3_IMAGE')"><fmt:message key="Common.view.label" bundle="${common_labels}"/></a></td>
					<%}%>
                </tr>
                  <!-- end PMG2012-CRF-0006 [IN034693]  -->
               <tr> 
                     <td class='data'>&nbsp;<%=doc4_type_desc%></td>
                     <td class='data'><%=doc4_num%></td>
                     <td class='data' width='15%'><%=doc4_exp_date%></td>
                     <td class='data' width='30%'><%=doc4_place_of_issue %></td>
                     <td class='data' width='30%'><%=doc4_iss_date%></td>
					    <!-- Below line was added by Venkatesh.S on  Feb/2013  against PMG2012-CRF-0006 [IN034693]  -->
				   <% if(doc4!=null){%> 
					 <td class='data' width='30%'><a href="javascript:viewDocument('<%=patient%>','DOC4_IMAGE')"><fmt:message key="Common.view.label" bundle="${common_labels}"/></a></td>
					<%}%>
                 </tr>
                   <!-- end PMG2012-CRF-0006 [IN034693]  -->
			 

</table>

<br>


<a name='misc'></a>
<table border="0" cellpadding="0" cellspacing="0" width="97%" align="center">
 <tr>
   <td width=100% class="BORDER">

		<table width='100%' cellpadding='0' cellspacing='0' >
		<tr>
			<td class="COLUMNHEADER" colspan='5'><fmt:message key="Common.Miscellaneous.label" bundle="${common_labels}"/></td>
		</tr>
			<tr>
				   <td colspan=5 class='label' height=5></td>
			</tr>
		<tr>
		<td>
			<table width='100%' cellpadding='3' cellspacing='0' border='0'>
			<tr>
					<td width='20%' class='label'><fmt:message key="Common.Dependency.label" bundle="${common_labels}"/></td>
					<td width='20%' class='data' ><%=Living_Dependency%></td>
					<td width='20%' class='label' ><fmt:message key="eMP.Arrangement.label" bundle="${mp_labels}"/></td>
					<td width='40%' class='data' colspan='2'><%=Living_Arrangement%></td>
					
			</tr>
			<tr>
				   <td colspan=5 class='label' height=5></td>
			</tr>
			<tr>
					<td  class='label'><fmt:message key="eMP.EducationLevel.label" bundle="${mp_labels}"/></td>
					<td  class='data'><%=Education_Level%></td>
					<td  class='data' colspan='3'>&nbsp;</td>
			</tr>
			</table>
      </p></td>
  </tr>
</table>

<% if(!((General_Remarks.length()>180) &&(Deceased_Yn.equals("Yes")) &&(Status_Remarks.length()>150))){ %>
<br>
<% } %>
<table width='100%' cellpadding='0' cellspacing='0' border='0'>
  <tr>
		<td class="COLUMNHEADER" colspan='5'><fmt:message key="eMP.RegistrationSource.label" bundle="${mp_labels}"/></td>
  </tr>
 <tr>
  <td>
		<table width='100%' cellpadding='3' cellspacing='1' border='0'>
		<tr>
			 <td width='20%' class='label' ><fmt:message key="eMP.Informant.label" bundle="${mp_labels}"/></td>
			 <td  width='20%' class='data' >
			 <%=Informant%></td>
			 <td width='60%' colspan=3 class='label' >&nbsp;</td>
		</tr>
		
		<tr>
				<td class='label' ><fmt:message key="eMP.InformantRemarks.label" bundle="${mp_labels}"/></td>
				<td class='data' colspan='4'>
				<%
				String str3="";
				int len1 = Informant_Remarks.length();

				if (len1 >85 )
				  str3=Informant_Remarks.substring(0,84)+" "+Informant_Remarks.substring(85,len1);
				else
				  str3=Informant_Remarks;
				if (len1 >169 )
				  str3=str3.substring(0,169)+" "+str3.substring(170,len1);
				%>
				<%=str3%></td>
		 </tr>
		</table>
</p>
</td>
</tr>
</table>

<% if(!((General_Remarks.length()>180) &&(Deceased_Yn.equals("Yes")) &&(Status_Remarks.length()>150))){ %>
<br>
<% } %>

<% if(!(General_Remarks.equals("")))
{

String str1="";
int len = General_Remarks.length();
int i1=0;
int n_incre = 0;
int max = 0;

 /* This condition modified by venkateshS on 14/June/2013 against SKR-SCF-0799 [IN:040863] */
if (len > 100) 
{ 
    for ( i1=0; i1 <= (len/100);i1++) 
	{   
		if((i1+1)*100 < len)
			max = (i1+1)*100;
		 else
		  max = len;
		
        str1=str1+" "+General_Remarks.substring((i1*100),max);
		
        n_incre = 1;
    }}
else  {
 str1=General_Remarks;
 }

  /* end SKR-SCF-0799 [IN:040863] */
 

%>
<table width='100%' cellpadding='0' cellspacing='0' border='0'>
	<tr>
		<td class="COLUMNHEADER" colspan='5'><fmt:message key="Common.generalRemarks.label" bundle="${common_labels}"/></td>
	</tr>
<tr>
<td>
<table width='100%' cellpadding='3' cellspacing='1' border='0'>

<tr>
		<td width='100%'  class='data' colspan=5>
        <%=str1%></td>
</tr>
</table>
</p>
</td>
</tr>

</table>
<%
}


if(Suspend_Yn.equals("Yes")){

String str1="";
int len = Status_Remarks.length();
int n=1;
String str2 ="";
int i1=0;

for(int i=0;i<len;i++) {
    str2 = str2 + Status_Remarks.substring(i,i+1);
    if( n == 70) {
        str1 = str1 + " " +  str2;
        str2="";
        n=1;
        i1=i;
    }
    else n++;
}
if(len>2)
str1= str1 + " " + Status_Remarks.substring(i1+1,len);


%>
<table width='100%' cellpadding='0' cellspacing='0' border='0'>
<tr>
	<td class="COLUMNHEADER" colspan='5'><fmt:message key="eMP.suspstatusremarks.label" bundle="${mp_labels}"/></td>
</tr>
<tr>
<td>
<table width='100%' cellpadding='3' cellspacing='1' border='0'>

<tr>
		<td  width="20%"  valign="top" class="data"><%=Status_Reason_Desc %></td>
		<td  width="80%" class="data" colspan='5'><%=str1 %></td>
</tr>
</table>
</p>
</td>
</tr>
</table>

<% } %>

<% if(!((General_Remarks.length()>180) &&(Deceased_Yn.equals("Yes")) &&(Status_Remarks.length()>150))){ %>
<br>
<% } %>
<table width='100%' cellpadding='0' cellspacing='0' border='0'>
<tr>
<td class="COLUMNHEADER" colspan='5'><fmt:message key="eMP.ActiveStatus.label" bundle="${mp_labels}"/></td>
</tr>
<tr>
<td>

<table width='100%' cellpadding='3' cellspacing='1' border='0'>

<tr>
		<td width="20%"class="label"><fmt:message key="Common.active.label" bundle="${common_labels}"/></td>

		<% 
			if(Active_Yn.equals("Y"))
			{
		%>
				<td width="20%"class="data"><img src='../../eCommon/images/enabled.gif'></td>
		<%
			}
			else if(Active_Yn.equals("N"))
			{
		%>
				<td width="20%"class="data"><img src='../../eCommon/images/disabled.gif'></td>
		<%	
			}
		%>
		<td width="20%"class="label"><fmt:message key="eMP.lastcontact.label" bundle="${mp_labels}"/></td>
		<td width="40%" class="data" colspan='2'><%= Last_Contact_Date%></td>
		
</tr>
</table>
</td>
</tr>
</table>
</td></tr></table>
<table width='100%' cellspacing=0 cellpadding=0>
<%
if(Deceased_Yn.equals("Yes")){
String str1="";
int len =Death_Status_Remarks.length();

if (len >85 )
  str1=Death_Status_Remarks.substring(0,84)+" "+Death_Status_Remarks.substring(85,len);
else
  str1=Death_Status_Remarks;
if (len >169 )
  str1=str1.substring(0,169)+" "+str1.substring(170,len);
%>

<% if(!((General_Remarks.length()>180) &&(Deceased_Yn.equals("Yes")) &&(Status_Remarks.length()>150))){ %>
<br>
<% } %>
<table width='100%' cellpadding='0' cellspacing='0' border='0'>
<tr>
<td class="COLUMNHEADER" colspan='5'><fmt:message key="eMP.expiration.label" bundle="${mp_labels}"/></td>
</tr>
<tr>
<td>
<table width='100%' cellpadding='3' cellspacing='1' border='0'>
<tr>
		<td  width="20%" class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td  width="80%" class="data" colspan='4'><%=Deceased_Date%></td>
</tr>
<tr>
		<td  width="20%" class="label" valign="top"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td  class="data" width="80%" colspan='4'><%=str1%></td>
</tr>
</table>
</td>
</tr>

<% } %>

<TR>
<TD colspan=5> </TABLE>
<table cellspacing=0 cellpadding=0 width='97%' border=0 align='center' border='0'>
<tr></tr><tr></tr><tr></tr><tr></tr>
<%
     order = 0;
    for(int i=0;i<cust_fields.length;i++)
    {
        if(cust_fields[i].charAt(0) == 'O')
        {
			if (i==0)
			{
			   %>
				   <tr><td class='COLUMNHEADER' colspan='5' >&nbsp;<fmt:message key="Common.additionaldetails.label" bundle="${common_labels}"/></td></tr>
			   <%
			}
            if( order%2 == 0)
            out.println("<tr>");
			
			int intind_0	= cust_fields[i].indexOf('`');
			String strcf	= cust_fields[i];		
			String strs1	= strcf.substring(intind_0+1, strcf.length());
			int intind_1	= strs1.indexOf('`');
			String lab		= strs1.substring(0, intind_1);
			String val		= strs1.substring(intind_1+1);

            out.println("<td colspan='5' class='label'  width='1%'  >"+lab+"&nbsp;</td>") ;
			out.println("<td class='data' width='1%' >" +val+"</td>");
			
            order++;

			
        }
    }
	if( order %2 != 0 && order!=0)
	out.println("<td  COLSPAN=5>&nbsp;</td>");
%>

</TABLE>    
<br><br><br><BR><br><br><br><br><br><br><br><BR><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<a name='add_mod_dtl'>
<table cellspacing=0 cellpadding=4 width='90%' align='center' border=1 height='50%' >
    <tr>
        <td class='COLUMNHEADER'>&nbsp;</td>
        <td  class='COLUMNHEADER' ><fmt:message key="eMP.AddedDetails.label" bundle="${mp_labels}"/></td>
        <td class='COLUMNHEADER' ><fmt:message key="eMP.latestmodifieddetails.label" bundle="${mp_labels}"/></td>
    </tr>
    <tr>
        <td class='data' ><fmt:message key="Common.username.label" bundle="${common_labels}"/></td>
        <td class='data'><%=added_user_name%></td>
        <td class='data'><%=modified_user_name%></td>
    </tr>

    <tr>
        <td class='data' ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
        <td class='data'><%=added_date%></td>
        <td class='data'><%=modified_date%></td>
     </tr>   
   
     <tr>
        <td class='data' ><fmt:message key="Common.workstation.label" bundle="${common_labels}"/></td>
        <td class='data'> <%=added_at_ws_no%></td>
        
        <td class='data'> <%=modified_at_ws_no%></td>
      </tr>  

      <tr>
        <td class='data'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
        <td class='data'><%=added_facility_name%></td>
        <td class='data'><%=modified_facility_name%></td>
    </tr>								  
	<tr>
        <td class='data' ><fmt:message key="eMP.RegistrationSource.label" bundle="${mp_labels}"/></td>
        <td class='data'><%if(data_source.equals("")) {%><fmt:message key="eMP.manual.label" bundle="${mp_labels}"/></td><%}else {%><fmt:message key="eMP.repository.label" bundle="${mp_labels}"/></td><%}%>
        <td class='label'>&nbsp;</td>
    </tr>
</table> 
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%
	if(rs!=null) rs.close();
//	if(oth_rset!=null) oth_rset.close();
	if(rs_lang!=null) rs_lang.close();
	if(pstmt!=null) pstmt.close();
	sql.setLength(0);
	 sql2.setLength(0);
}catch(Exception e){out.println("Exception in main try"+e.getMessage()); e.printStackTrace();}
finally {
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
 <input type='hidden' name='patient_id' id='patient_id' value='<%=Patient_id%>'>
<script>

/* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
 function viewDocument(patientID,column_name)
{

var dialogHeight = '30' ;
var dialogWidth  = '30' ;
var features     = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;'
var arguments    = '' ;
 var retVal = window.showModalDialog("../../eMP/jsp/ViewPatientDocFrame.jsp?patient_id="+patientID+"&column_name="+column_name,arguments,features); 
 
} 
/* end PMG2012-CRF-0006 [IN034693] */
//Added for MMS-QH-CRF-0145
if(<%=hijirisitespecifApplicable%>&&'<%=hijri_birth_date%>'==""){
var hijDay=convertToHij('<%=Date_Of_Birth%>'); 
document.getElementById('hiji_date_display').innerHTML=hijDay;
}

</script>
 
 </form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


<!DOCTYPE html>
<!-- Last Modified Date Time : 9/23/2005 11:28 AM -->	
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<Script src="../../eMP/js/SmartCard.js" language="JavaScript"></Script>
<Script src="../../eXH/js/ExternalApplication.js" language="JavaScript"></Script><!--Added by kamatchi S form MOHE-CRF-0016.1 on 26-AUG-2020-->
<Script language='javascript' src='../../eMP/js/PatientSearch.js'></Script><!--Added by Lakshmanan form MOHE-CRF-00164.1 on 17-feb-2022-->
<%
	
	if(session.getValue("smart_path")!= null) {
		if(!session.getValue("smart_path").equals(" ")){
			out.println(session.getValue("smart_path"));
		}
	}
	%>
<Script src="../../eMP/js/json02.js"></Script>
<Script src="../../eMP/js/jquery.min.js"></Script>	
<%
	
	if(session.getValue("sekure_ws_yn")!= null) {
		if(session.getValue("sekure_ws_yn").equals("Y")){
			out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>");
		}
	}
	%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<Script language="JavaScript"src="../../eCommon/js/DateUtils.js" ></Script>
<%
	String sessionID 		= 			session.getId();
	String facility			= (String) session.getValue("facility_id");
	String loginUser		= (String) session.getValue("login_user");
	Properties p = (java.util.Properties) session.getValue("jdbc");
	String p_ws_no = p.getProperty("client_ip_address");

    Connection con = null;
    PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
    ResultSet rs=null;
    ResultSet rs1=null;
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale			= (String)session.getAttribute("LOCALE");
	String language_direction="";
	//String pat_ser_grp_code="";
	//String pat_ser_grp_desc="";
	int count=0;
	String nat_id_prompt ="";
	String names_in_oth_lang_yn="";
	String ext_system_interface_yn="";
	String nat_data_source_id="";
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
    int patient_id_length =0;
    int nat_id_length =0;
    int alt_id1_length =0;
    int alt_id2_length =0;
    int alt_id3_length =0;
    int alt_id4_length =0;

    String Family_No_Link_Yn ="";
    String Family_No_Prompt ="";
    String Res_Area_Prompt = "";
    //String orderby="";
    String Alt_Id1 = "" ;
    String Alt_Id2 = "" ;
    String Alt_Id3 = "" ;
    String Alt_Id4 = "" ;
	String prn_label="";
	String orn_label="";
    String addl_field1_prompt = "";
    int addl_field1_length = 0;
    String addl_field2_prompt = "";
    int addl_field2_length = 0;
    String addl_field3_prompt = "";
    int addl_field3_length = 0;
    String addl_field4_prompt = "";
    int addl_field4_length = 0;
    String addl_field5_prompt = "";
    int addl_field5_length = 0;
	String accept_national_id_no_yn = "N";
	String nat_id_accept_alphanumeric_yn = "N";
	String alt_id1_accept_alphanumeric_yn ="";
	String accept_oth_alt_id_yn = "N";
	String family_org_id_accept_yn = "N";
	String Family_Name_loc_lang_Prompt="";
	String Third_Name_loc_lang_Prompt="";
	String Second_Name_loc_lang_Prompt="";
	String First_Name_loc_lang_Prompt="";
	String jsp_name=request.getParameter("jsp_name");
	String cr_jsp_name=request.getParameter("jsp_name");
    String window_styl=request.getParameter("window_styl");
    String cr_window_styl=request.getParameter("window_styl");
    String close_yn=request.getParameter("close_yn");
    String cr_close_yn=request.getParameter("close_yn");
    //String win_height   =request.getParameter("win_height");
    String cr_win_height   =request.getParameter("win_height");
  //  String win_width    =request.getParameter("win_width");
    String cr_win_width    =request.getParameter("win_width");
   // String win_top      =request.getParameter("win_top");
    String cr_win_top      =request.getParameter("win_top");
   // String act_yn   =request.getParameter("act_yn");
    String cr_act_yn   =request.getParameter("act_yn");
   // String srr = request.getParameter("srr");
    String cr_srr = request.getParameter("srr");
    String register_button_yn = request.getParameter("register_button_yn");
    String cr_register_button_yn = request.getParameter("register_button_yn");
    String func_act = request.getParameter("func_act");
    String cr_func_act = request.getParameter("func_act");
    func_act = (func_act == null)?"":func_act;
    String func_idpassed = request.getParameter("func_idpassed");
    String cr_func_idpassed = request.getParameter("func_idpassed");
	if (func_idpassed == null || func_idpassed.equals("null")) func_idpassed = "";
	if (cr_func_idpassed == null || cr_func_idpassed.equals("null")) cr_func_idpassed = "";

	String defaultgender        =   request.getParameter("default_gender")==null?"":request.getParameter("default_gender");
	String cr_defaultgender        =   request.getParameter("default_gender")==null?"":request.getParameter("default_gender");
    String enablegenderyn   =   request.getParameter("enable_gender_yn")==null?"":request.getParameter("enable_gender_yn");
    String cr_enablegenderyn   =   request.getParameter("enable_gender_yn")==null?"":request.getParameter("enable_gender_yn");
	
	//Added for this CRF HSA-CRF-0289
	String alterIdSearch=request.getParameter("alterIdSearch")==null?"":request.getParameter("alterIdSearch");
	String isAlternateId=request.getParameter("isAlternateId")==null?"":request.getParameter("isAlternateId");
	String alternate_no=request.getParameter("alternate_no")==null?"":request.getParameter("alternate_no");
	//End HSA-CRF-0289
	//Maheshwaran K added for MMS-DM-CRF-0208.1 - suspend_inactive_pat_yn
	String suspend_inactive_pat_yn=request.getParameter("suspend_inactive_pat_yn")==null?"N":request.getParameter("suspend_inactive_pat_yn");

    String self     = "";
    String selm = "";
    String dis      = "";
    String sdisable = "";
	//Below Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]
	String alt_id1_pat_sch_exact_yn="";
	String alt_id2_pat_sch_exact_yn="";
	String alt_id3_pat_sch_exact_yn="";
	String alt_id4_pat_sch_exact_yn="";

    if(defaultgender.equals("F")) self = "selected";
    else if(defaultgender.equals("M")) selm = "selected";

    if(enablegenderyn.equals("N")) dis = "DISABLED";


    String Soundex ="";
  //  String fieldname = "";
 //   String str="";
 //   String str_new ="";
  //  String dateofbirthyn="N";
    //Added by kumar on 8/3/2002 for DR Module
    String function_id  =   request.getParameter("dr_function_id")==null?"":request.getParameter("dr_function_id");
    String cr_function_id  =   request.getParameter("dr_function_id")==null?"":request.getParameter("dr_function_id");
   
    if(!function_id.equals("") && !function_id.equals("PAT_REG") && !function_id.equals("NEWBORN_REG")) sdisable = "disabled";
	
	if(func_act.equals("DuplicateRegistration"))
	sdisable = "";
	String dr_install_yn = "N";
   // boolean Sndx = false;
    String errFlag = "N";
	String separate_file_no_yn = "N";
	String mrn_length = "20";
	int cntPrefFac = 0;
	String dft_national_id="";
	String pat_name_as_multipart_yn	= "";
	String maintain_doc_or_file		= "";
	String docDisableField			= "";
	String first_name_length = "";
	String second_name_length = "";
	String third_name_length = "";
	String family_name_length = "";
	String file_type_appl_yn = "";
	String firstRowElement="";
	String firstRowCompleted="";

	/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/
	String fam_name_ind="N";

	boolean isAlternateAddressAppl = false;//Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601

	boolean isAddressLengthIncAppl = false;//Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0860.2
	
	boolean isPatientNameContainsAppl = false;  //Added by Mujafar  against ML-MMOH-CRF-1127
	String select_val=""; //Added by Mujafar  against ML-MMOH-CRF-1127
	/*Added by kamatchi S for MOHE-CRF-0016.1 ON 26-AUG-2020*/
	boolean isInsuranceCardReader = false;
	
	String Smartcard_path="" ; //Added by lakshmanan MOHE-CRF-0164.1 
	String function_name="" ; //Added by lakshmanan MOHE-CRF-0164.1 
			
	String insurance_id = "";
	/*Added by kamatchi S for MOHE-CRF-0016.1 ON 26-AUG-2020*/
	try 
	{	 
		con = ConnectionManager.getConnection(request);
		//for smart card
		pstmt = con.prepareStatement("select VALUE_1,nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");

		rs = pstmt.executeQuery();	


		if(rs!=null && rs.next())
		{
		Smartcard_path=rs.getString("VALUE_1");
		function_name=rs.getString("VALUE_2");  

		}
		

		isAlternateAddressAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE");//Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601

		isAddressLengthIncAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");//Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0860.2
		
		isPatientNameContainsAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","PATIENT_NAME_CONTAINS_APPL"); //Added by Mujafar  against ML-MMOH-CRF-1127

		isInsuranceCardReader = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INSURANCE_CARD_READER"); //Added by kamatchi S for MOHE-CRF-0016.1 ON 26-AUG-2020

		
		if(isPatientNameContainsAppl)
			select_val = "selected";
		
		if(pstmt!=null)
		pstmt.close();
		if(rs!=null)
		rs.close();
		
		
		
		

        pstmt = con.prepareStatement("SELECT Dflt_Sndx_type, separate_file_no_yn, pat_name_as_multipart_yn, maintain_doc_or_file,family_org_id_accept_yn,first_name_length, second_name_length,third_name_length,family_name_length,file_type_appl_yn,dft_national_id FROM mp_param where module_id='MP'");
        rs=pstmt.executeQuery();
        if(rs.next()) 
		{
            Soundex = checkForNull(rs.getString(1));      
			separate_file_no_yn = checkForNull(rs.getString(2));
			pat_name_as_multipart_yn = checkForNull(rs.getString(3));
			maintain_doc_or_file = checkForNull(rs.getString(4));
			first_name_length = rs.getString("first_name_length");
			second_name_length = rs.getString("second_name_length");
			third_name_length = rs.getString("third_name_length");
			family_name_length = rs.getString("family_name_length");
			file_type_appl_yn = checkForNull(rs.getString("file_type_appl_yn"));
			if(maintain_doc_or_file == null) maintain_doc_or_file = "F";
			family_org_id_accept_yn = checkForNull(rs.getString("family_org_id_accept_yn"),"N"); 
			dft_national_id=checkForNull(rs.getString("dft_national_id"));//Added by Maheshwaran K for AAKH-CRF-0168
        }       
        else
        {
            errFlag = "Y";
            out.println("<script>alert(getMessage('MP_PARAM_NOT_FOUND','MP'));</script>");
            out.println("<script>parent.window.close();</script>");         
        }
		
		if(maintain_doc_or_file.equals("D")) docDisableField = "disabled";
	    try 
		{
			pstmt = con.prepareStatement("Select install_yn from sm_module where module_id ='DR'");
	        rs=pstmt.executeQuery();
			if(rs.next()) 
			{           
				dr_install_yn= rs.getString(1);
			}
		}
		catch(Exception e)
		{   
			out.println(e.toString());
		}

		try 
		{
pstmt = con.prepareStatement("Select count(1) from mp_pat_search_result where field_select='Y' and UPPER(field_name)='PREF_FACILITY_ID'");
			rs=pstmt.executeQuery();
			if(rs.next()) 
			{           
				cntPrefFac = rs.getInt(1);
			}
		}
	    catch(Exception e)
		{   
			out.println(e.toString());
		}

		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");

		
		
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();


		pstmt = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status = 'E'" ) ;
		
		rs = pstmt.executeQuery() ;
             
			
        if ( rs != null && rs.next() ) 
		 {
		 count = rs.getInt("total");
		 }

		if ( count==1 ) 
		{
			 language_direction = "R" ;
		}else
		{
			 language_direction = "L" ;
		}


		 if(pstmt != null) pstmt.close();
		 if(rs != null) rs.close();
	%>
<html>
    <head>
        <link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
          
        <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>       
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
        <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script>
		<Script language='javascript' src='../../eMP/js/PatientSearch.js'></Script>
        <Script language="JavaScript">
            //Added by kumar on 16/03/2003 for Family Name Search if Pat Name as Multi Part is N
			function EnableFamSearch(obj)
			{
				
			}

        </Script>




    </head>

                         <%
                            try{
								  //String sql1="Select nvl(param.Nat_Id_Prompt, 'National ID No') Nat_ID_Prompt, param.nat_data_source_id,  param.Patient_Id_Length,param.Nat_Id_Length,param.Family_No_Link_Yn,param.Family_No_Prompt,param.First_Name_Accept_Yn,param.First_Name_Order,param.First_Name_Prompt,param.Second_Name_Accept_Yn,param.Second_Name_Order,param.Second_Name_Prompt,param.Third_Name_Accept_Yn,param.Third_Name_Order,param.Third_Name_Prompt,param.Family_Name_Accept_Yn,param.Family_Name_Order,param.Family_Name_Prompt,First_Name_loc_lang_Prompt, Second_Name_loc_lang_Prompt, Third_Name_loc_lang_Prompt, Family_Name_loc_lang_Prompt,param.alt_id1_accept_alphanumeric_yn, param.Alt_Id1_type,alt_id1.long_desc alt_id1_desc, param.Alt_Id2_type,alt_id2.long_desc alt_id2_desc, param.Alt_Id3_type,alt_id3.long_desc alt_id3_desc,param.Alt_Id4_type,(alt_id4.long_desc) alt_id4_desc, param.alt_id1_length, param.alt_id2_length, param.alt_id3_length, param.alt_id4_length, param.addl_field1_prompt, param.addl_field1_length, param.addl_field2_prompt, param.addl_field2_length, addl_field3_prompt, addl_field3_length, param.addl_field4_prompt, param.addl_field4_length, param.addl_field5_prompt, param.addl_field5_length,param.accept_national_id_no_yn,param.nat_id_accept_alphanumeric_yn,param.ext_system_interface_yn,param.accept_oth_alt_id_yn,NAMES_IN_OTH_LANG_YN from MP_PARAM_LANG_VW param,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id1,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id2,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id3,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id4 where param.module_id='MP' and param.language_id ='"+locale+"' and  param.language_id=alt_id1.language_id and param.language_id=alt_id2.language_id(+) and param.language_id=alt_id3.language_id(+) and param.language_id=alt_id4.language_id(+) and param.alt_id1_type=alt_id1.alt_id_type and param.alt_id2_type=alt_id2.alt_id_type(+) and param.alt_id3_type=alt_id3.alt_id_type(+) and param.alt_id4_type=alt_id4.alt_id_type(+)";

								  /*String sql1="SELECT NVL(param.nat_id_prompt, 'National ID No') nat_id_prompt,   param.nat_data_source_id, param.patient_id_length, param.nat_id_length,       param.family_no_link_yn, param.family_no_prompt,      param.first_name_accept_yn, param.first_name_order,       param.first_name_prompt, param.second_name_accept_yn,       param.second_name_order, param.second_name_prompt,       param.third_name_accept_yn, param.third_name_order,       param.third_name_prompt, param.family_name_accept_yn,       param.family_name_order, param.family_name_prompt,       first_name_loc_lang_prompt, second_name_loc_lang_prompt,       third_name_loc_lang_prompt, family_name_loc_lang_prompt,       param.alt_id1_accept_alphanumeric_yn, (CASE WHEN param.alt_id1_type IS NOT NULL	THEN (SELECT long_desc FROM mp_alternate_id_type_lang_vw WHERE alt_id_type = param.alt_id1_type AND language_id = '"+locale+"')END) alt_id1_desc, (CASE WHEN param.alt_id2_type IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type_lang_vw WHERE alt_id_type = param.alt_id2_type             AND language_id = '"+locale+"') END) alt_id2_desc, (CASE WHEN param.alt_id3_type IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type_lang_vw            WHERE alt_id_type = param.alt_id3_type AND language_id = '"+locale+"') END) alt_id3_desc, (CASE WHEN param.alt_id4_type IS NOT NULL THEN (SELECT long_desc  FROM mp_alternate_id_type_lang_vw WHERE alt_id_type = param.alt_id4_type        AND language_id = '"+locale+"') END) alt_id4_desc, param.alt_id1_length, param.alt_id2_length, param.alt_id3_length, param.alt_id4_length, param.addl_field1_prompt, param.addl_field1_length, param.addl_field2_prompt,   param.addl_field2_length, addl_field3_prompt, addl_field3_length,     param.addl_field4_prompt, param.addl_field4_length,       param.addl_field5_prompt, param.addl_field5_length,       param.accept_national_id_no_yn, param.nat_id_accept_alphanumeric_yn,       param.ext_system_interface_yn, param.accept_oth_alt_id_yn,       names_in_oth_lang_yn FROM mp_param_lang_vw param WHERE param.module_id = 'MP' AND param.language_id = '"+locale+"' ";*/

                                 
								  String sql1="SELECT alt_id1_pat_sch_exact_yn,alt_id2_pat_sch_exact_yn,alt_id3_pat_sch_exact_yn,alt_id4_pat_sch_exact_yn,NVL(param.nat_id_prompt, 'National ID No') nat_id_prompt,   param.nat_data_source_id, param.patient_id_length, param.nat_id_length,       param.family_no_link_yn, param.family_no_prompt,      param.first_name_accept_yn, param.first_name_order,       param.first_name_prompt, param.second_name_accept_yn,       param.second_name_order, param.second_name_prompt,       param.third_name_accept_yn, param.third_name_order,       param.third_name_prompt, param.family_name_accept_yn,       param.family_name_order, param.family_name_prompt,       first_name_loc_lang_prompt, second_name_loc_lang_prompt,       third_name_loc_lang_prompt, family_name_loc_lang_prompt,       param.alt_id1_accept_alphanumeric_yn, (CASE WHEN param.alt_id1_type IS NOT NULL	THEN (SELECT long_desc FROM mp_alternate_id_type_lang_vw WHERE alt_id_type = param.alt_id1_type AND language_id = '"+locale+"')END) alt_id1_desc, (CASE WHEN param.alt_id2_type IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type_lang_vw WHERE alt_id_type = param.alt_id2_type             AND language_id = '"+locale+"') END) alt_id2_desc, (CASE WHEN param.alt_id3_type IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type_lang_vw            WHERE alt_id_type = param.alt_id3_type AND language_id = '"+locale+"') END) alt_id3_desc, (CASE WHEN param.alt_id4_type IS NOT NULL THEN (SELECT long_desc  FROM mp_alternate_id_type_lang_vw WHERE alt_id_type = param.alt_id4_type        AND language_id = '"+locale+"') END) alt_id4_desc, param.alt_id1_length, param.alt_id2_length, param.alt_id3_length, param.alt_id4_length, param.addl_field1_prompt, param.addl_field1_length, param.addl_field2_prompt,   param.addl_field2_length, addl_field3_prompt, addl_field3_length,     param.addl_field4_prompt, param.addl_field4_length,       param.addl_field5_prompt, param.addl_field5_length,       param.accept_national_id_no_yn, param.nat_id_accept_alphanumeric_yn,       param.ext_system_interface_yn, param.accept_oth_alt_id_yn,       names_in_oth_lang_yn FROM mp_param_lang_vw param WHERE param.module_id = 'MP' AND param.language_id = '"+locale+"' ";
								  //Modified by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]
								  pstmt = con.prepareStatement(sql1);

									
                                    rs = pstmt.executeQuery();
                                    if (rs !=null) {
                                        if (rs.next())
                                        {
                                            nat_id_prompt = rs.getString("Nat_Id_Prompt");
                                            if (nat_id_prompt==null) nat_id_prompt = "";
											ext_system_interface_yn = rs.getString("ext_system_interface_yn");
											nat_data_source_id = checkForNull(rs.getString("nat_data_source_id"),"");
                                            patient_id_length = rs.getInt("Patient_Id_Length");
                                            nat_id_length = rs.getInt("Nat_Id_Length");
                                            Family_No_Link_Yn =rs.getString("Family_No_Link_Yn")== null ?  "N" : rs.getString("Family_No_Link_Yn");
                                            Family_No_Prompt =rs.getString("Family_No_Prompt")== null ? "Head of the Family" : rs.getString("Family_No_Prompt");
                                            First_Name_Accept_Yn = rs.getString("First_Name_Accept_Yn")==null ? "N" : rs.getString("First_Name_Accept_Yn");
											names_in_oth_lang_yn=rs.getString("names_in_oth_lang_yn");
                                            First_Name_Order = rs.getInt("First_Name_Order");
                                            First_Name_Prompt = rs.getString("First_Name_Prompt")==null ? "First Name" : rs.getString("First_Name_Prompt");
                                            Second_Name_Accept_Yn = rs.getString("Second_Name_Accept_Yn")==null ? "N" : rs.getString("Second_Name_Accept_Yn");
											
                                            Second_Name_Order = rs.getInt("Second_Name_Order");
                                            Second_Name_Prompt = rs.getString("Second_Name_Prompt")==null ? "Second Name" : rs.getString("Second_Name_Prompt");
                                            Third_Name_Accept_Yn = rs.getString("Third_Name_Accept_Yn")==null ? "N" : rs.getString("Third_Name_Accept_Yn");
                                            Third_Name_Order = rs.getInt("Third_Name_Order");
                                            Third_Name_Prompt = rs.getString("Third_Name_Prompt")==null ? "Third Name" : rs.getString("Third_Name_Prompt");
											
											 First_Name_loc_lang_Prompt=checkForNull(rs.getString("First_Name_loc_lang_Prompt"));
											Second_Name_loc_lang_Prompt=checkForNull(rs.getString("Second_Name_loc_lang_Prompt"));
											Third_Name_loc_lang_Prompt=checkForNull(rs.getString("Third_Name_loc_lang_Prompt"));
											Family_Name_loc_lang_Prompt=checkForNull(rs.getString("Family_Name_loc_lang_Prompt"));

                                            Family_Name_Accept_Yn = rs.getString("Family_Name_Accept_Yn")==null ? "N" : rs.getString("Family_Name_Accept_Yn");
                                            Family_Name_Order = rs.getInt("Family_Name_Order");
											accept_oth_alt_id_yn = rs.getString("accept_oth_alt_id_yn")==null ? "N" : rs.getString("accept_oth_alt_id_yn");
											
											alt_id1_accept_alphanumeric_yn = rs.getString("alt_id1_accept_alphanumeric_yn")==null ? "N" : rs.getString("alt_id1_accept_alphanumeric_yn");
											
											 
											if 	(pat_name_as_multipart_yn.equals("N"))
										{
												Family_Name_Order = 4;
												//family_name_length = "40";
											}
											else
											{
												//family_name_length = "15";
											
										}											
											Family_Name_Prompt = rs.getString("Family_Name_Prompt")==null ? "Family Name" : rs.getString("Family_Name_Prompt");
                                            Res_Area_Prompt = "Area";
                                            Alt_Id1 = rs.getString("alt_id1_desc")==null?"Alt ID No":rs.getString("alt_id1_desc");
                                            Alt_Id2 = rs.getString("alt_id2_desc")==null?"":rs.getString("alt_id2_desc");
                                            Alt_Id3 = rs.getString("alt_id3_desc")==null?"":rs.getString("alt_id3_desc");
                                            Alt_Id4 = rs.getString("alt_id4_desc")==null?"":rs.getString("alt_id4_desc");
											
                                            alt_id1_length = rs.getInt("alt_id1_length");
                                            alt_id2_length = rs.getInt("alt_id2_length");
                                            alt_id3_length = rs.getInt("alt_id3_length");
                                            alt_id4_length = rs.getInt("alt_id4_length");
											
                                            addl_field1_prompt = rs.getString("addl_field1_prompt")==null?"":rs.getString("addl_field1_prompt");
                                            addl_field1_length = rs.getInt("addl_field1_length");
                                            addl_field2_prompt = rs.getString("addl_field2_prompt")==null?"":rs.getString("addl_field2_prompt");
                                            addl_field2_length = rs.getInt("addl_field2_length");   
                                            addl_field3_prompt = rs.getString("addl_field3_prompt")==null?"":rs.getString("addl_field3_prompt");
                                            addl_field3_length = rs.getInt("addl_field3_length");  
											
                                            addl_field4_prompt = rs.getString("addl_field4_prompt")==null?"":rs.getString("addl_field4_prompt");
                                            addl_field4_length = rs.getInt("addl_field4_length");   
                                            addl_field5_prompt = rs.getString("addl_field5_prompt")==null?"":rs.getString("addl_field5_prompt");
                                            addl_field5_length = rs.getInt("addl_field5_length");
											
											accept_national_id_no_yn = rs.getString("accept_national_id_no_yn");
											if (accept_national_id_no_yn==null) accept_national_id_no_yn = "N";

											nat_id_accept_alphanumeric_yn = rs.getString("nat_id_accept_alphanumeric_yn");
											if (nat_id_accept_alphanumeric_yn==null) nat_id_accept_alphanumeric_yn = "N";
											if (separate_file_no_yn.equals("N")) mrn_length= rs.getString("Patient_Id_Length");

											//Below Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]
											alt_id1_pat_sch_exact_yn=rs.getString("alt_id1_pat_sch_exact_yn")==null?"N":rs.getString("alt_id1_pat_sch_exact_yn");
											alt_id2_pat_sch_exact_yn=rs.getString("alt_id2_pat_sch_exact_yn")==null?"N":rs.getString("alt_id2_pat_sch_exact_yn");
											alt_id3_pat_sch_exact_yn=rs.getString("alt_id3_pat_sch_exact_yn")==null?"N":rs.getString("alt_id3_pat_sch_exact_yn");
											alt_id4_pat_sch_exact_yn=rs.getString("alt_id4_pat_sch_exact_yn")==null?"N":rs.getString("alt_id4_pat_sch_exact_yn");
											
											
                                        }
                                    }
                                }catch(Exception e) { out.println(e.toString());}
                                finally
                                {
                                    if (pstmt != null) pstmt.close();
                                    if (rs != null) rs.close();
                                }

                                  pstmt = con.prepareStatement("select contact_mode, short_desc from mp_contact_mode_lang_vw where contact_mode in ('PRN', 'ORN') and language_id = ?");
								  try{
									pstmt.setString(1,locale);
									rs = pstmt.executeQuery();
									String cnt_mode="";
									while(rs!=null && rs.next()){
										cnt_mode=rs.getString("contact_mode");
										if(cnt_mode.equals("PRN"))
											prn_label=rs.getString("short_desc");
										if(cnt_mode.equals("ORN"))
											orn_label=rs.getString("short_desc");
									}
								  } catch(Exception ex) {
									  ex.printStackTrace();
								  } finally {
									  if (pstmt != null) pstmt.close();
									  if (rs != null) rs.close();
								  }

                                %> 


    <body class='content' topmargin='0' OnMouseDown="CodeArrest()" onLoad="" onKeyDown = 'lockKey()'> 
    <form name="Basic_Patient_Search_Form" id="Basic_Patient_Search_Form" method='post' action='../../eMP/jsp/BasicPatientSearchCriteria.jsp'>
	<input type="hidden" name="maintain_doc_or_file" id="maintain_doc_or_file" value="<%=maintain_doc_or_file%>">
	<input type ='hidden' name='family_org_id_accept_yn' id='family_org_id_accept_yn' value="<%=family_org_id_accept_yn%>"></input>
	<input type ='hidden' name='func_idpassed' id='func_idpassed' value="<%=func_idpassed%>"></input>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>


    <a name='simple' id='simple'></a>
	

<center>
            <table border="0" cellpadding="2" cellspacing="0" width="100%">
			<tr>
                    <td width='100%' class="BORDER" valign=top>
					<table border="0" cellpadding="2" cellspacing="0" width="100%">	
									<tr>
									<td  width='20%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>

									<td  width='30%' class="fields" ><input type="text" name="Patient_Id1" id="Patient_Id1" onKeyPress="return CheckForSpecChars(event)"  size="25" onFocus="MoveFocusSimple(2)" maxlength="<%=patient_id_length%>" onBlur="makeValidQueryCriteria(this);ChangeCase(this)"> &nbsp; 
										<select name="patient_id_search_by" id="patient_id_search_by">
											<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
											<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
											<option value="C" selected><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
										</select>
									</td>
									<% 

									if (accept_national_id_no_yn.equals("Y"))
									{ 
									%><td  width='20%' class="label"><%=nat_id_prompt%></td>
										<td  width='30%' class="fields"><input type="text" name="National_Id_No1" id="National_Id_No1" size="25" maxlength="<%=nat_id_length%>" 
										onKeyPress="return CheckForSpecChars(event)" onBlur="makeValidQueryCriteria(this)" onFocus="MoveFocusSimple(2)"> <%if(function_name.equals("07")){ %>  
										<input name='NatID_Btn' id='NatID_Btn' class='button' Onclick="NationalID_Search('<%=sessionID%>','<%=facility%>','<%=loginUser%>','<%=p_ws_no%>')" type="button" value='M'    <%} // MOHE-CRF-0164.1%> </td>
									   <%}else{%>
									  <input type="hidden" name="National_Id_No1" id="National_Id_No1"  
								       value=''> 
									<%}	%> 
									</tr>
									<tr>
								<%if(!Alt_Id1.equals("")){%> <!--Below line modified by venkatesh on 07/Oct/2013 against 43291-->							 
							    <td  width='20%' class="label"><%=Alt_Id1%></td>
							     <td  width='30%' class="fields" ><input type="text" name="Alt_Id1_No1" id="Alt_Id1_No1" size="25" maxlength="<%=alt_id1_length%>" value='' onKeyPress='return CheckForSpeclChars(event,"Alt_Id1")'onFocus="MoveFocusSimple(2)" onBlur="makeValidQueryCriteria(this);enableSuffix()"  ><input type="hidden" name="Expiry_Date11" id="Expiry_Date11" size="18" maxlength="10"  onFocus="MoveFocusSimple(1)">
								<input type="hidden" name="newborn_suffix" id="newborn_suffix" size='1' onKeyPress="return allowValidNumber(this,event,2,0);" onBlur="makeValidQueryCriteria(this);"
								maxlength='2'  disabled></td>
                            <%}%>
							<%if(!isInsuranceCardReader){//Added by kamatchi S for MOHE-CRF-0016.1 ON 26-AUG-2020
									if(!Alt_Id2.equals("")){
							%>   
								<!--below code change done for SRR20056-SCF-12671-->
								<td  width='20%' class="label"><%=Alt_Id2%></td>
								<td  width='30%' class="fields"><input type="text" name="Alt_Id2_No1" id="Alt_Id2_No1" size="25" maxlength="<%=alt_id2_length%>" value='' onKeyPress="return altID234Validations(event)" onBlur="makeValidQueryCriteria(this)" onFocus="MoveFocusSimple(2)" ><input type="hidden" name="Expiry_Date21" id="Expiry_Date21" size="8" maxlength="10"  onFocus="MoveFocusSimple(1)"></td>
							<%}}else{%><!--Added by kamatchi S form MOHE-CRF-0016.1 on 26-AUG-2020-->
							 
								<td class='label'  width='15%'><fmt:message key="Common.Insurance.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
								<td class='fields' ><div id='insurance_div'><textarea name='insurance_id' id='insurance_id' rows="3" cols="50" maxlength="300"  tabindex = '6'   value = "<%=insurance_id%>" readonly></textarea>&nbsp;<input type='button' class='button' Value=' Read ' onClick='insCardReader(insurance_id,insurance_div)'> 
								<input type="hidden" name="insurance_id_1" id="insurance_id_1" value="<%=insurance_id%>"></div></td>
								<%}%>
					</tr>
					<tr>
							<%if(!Alt_Id3.equals("")){%>   
								<!--below code change done for SRR20056-SCF-12671-->
								<td  width='20%' class="label"><%=Alt_Id3%></td>
								<td  width='30%' class="fields"><input type="text" name="Alt_Id3_No1" id="Alt_Id3_No1" size="25" value='' maxlength="<%=alt_id3_length%>" onKeyPress="return altID234Validations(event)" onBlur="makeValidQueryCriteria(this)" onFocus="MoveFocusSimple(2)" ><input type="hidden" name="Expiry_Date31" id="Expiry_Date31" size="8" maxlength="10"  onFocus="MoveFocusSimple(1)"></td>
							<%}%>
							<%if(!Alt_Id4.equals("")){%>
								<!--below code change done for SRR20056-SCF-12671-->
								<td  width='20%' class="label"><%=Alt_Id4%></td>
								
								<td  width='30%' class="fields"><input type="text" name="Alt_Id4_No1" id="Alt_Id4_No1" size="25" maxlength="<%=alt_id4_length%>" value='' onKeyPress="return altID234Validations(event)" onBlur="makeValidQueryCriteria(this)" onFocus="MoveFocusSimple(2)" ><input type="hidden" name="Expiry_Date41" id="Expiry_Date41" size="8" maxlength="10"  onFocus="MoveFocusSimple(1)" ></td>
							<%}%>
				</tr>
				<!--<tr>
								<td  width='25%' class="label"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
								<td  width='25%' class="fields"><input type="text" name="pat_name1" id="pat_name1" size="25" value='' maxlength="80" onBlur="ChangeInitCase(this);"></td>
								<%if(names_in_oth_lang_yn.equals("Y")){%>
								<td  width='25%' class="label"><fmt:message key="eMP.PatientNameLocal.label" bundle="${mp_labels}"/></td>
								<td  width='25%' class="fields"><input type="text" name="pat_name_local1" id="pat_name_local1" size="25" value='' maxlength="80"></td>
								<%}%>
				</tr>-->

<!--Patient Name Derivation Logic Starts For Basic Search-->
<!--modified onBlur='makeValidQueryCriteria' to  onBlur='makeValidString' for the incident IN031010 on 8-3-2012 by Shanthi Begins-->
				<tr>
						<%if(pat_name_as_multipart_yn.equals("Y")){  
								 	
                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                                        out.println("<td   width='20%' class='label'>" + First_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='First_Name1' id='First_Name1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'></td>");
										firstRowElement="Y";
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                                        out.println("<td  width='20%' class='label'>" + Second_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields' ><input type='text' name='Second_Name1' id='Second_Name1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										firstRowElement="Y";
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 ) {
                                        out.println("<td   width='20%' class='label'>" + Third_Name_Prompt + "</td>");
                                        out.println("<td    width='30%' class='fields'><input type='text' name='Third_Name1' id='Third_Name1' size='25' maxlength='15' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										firstRowElement="Y";
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
									
                                        out.println("<td   width='20%' class='label'>" + Family_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='Family_Name1' id='Family_Name1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\">");
										firstRowElement="Y";

						/*Added by Rameswar on  21-04-2016 for HSA-CRF-0299-Start*/
						  if (First_Name_Accept_Yn.equals("N") && Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") && Family_Name_Accept_Yn.equals("Y") ){
 
											fam_name_ind ="Y";
//											String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By' ><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
								} /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299-End*/

                                    }
                                   

                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='First_Name1' id='First_Name1' >");
                                }
                                else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='Second_Name1' id='Second_Name1' >");
                                }
                                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='Third_Name1' id='Third_Name1' >");
                                }
                                else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='Family_Name1' id='Family_Name1' >");
                                    }
									 if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                                        out.println("<td  width='20%' class='label'>" + First_Name_Prompt + "</td>");
                                        out.println("<td  width='30%' class='fields' ><input type='text' name='First_Name1' id='First_Name1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                                        out.println("<td  width='20%' class='label'>" + Second_Name_Prompt + "</td>");
                                        out.println("<td  width='30%' class='fields' ><input type='text' name='Second_Name1' id='Second_Name1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 ) {
                                        out.println("<td  width='20%' class='label'>" + Third_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='Third_Name1' id='Third_Name1' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
                                        out.println("<td   width='20%' class='label'>" + Family_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='Family_Name1' id='Family_Name1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\">");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}

										 /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299-Start*/
						  if (First_Name_Accept_Yn.equals("N") && Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") && Family_Name_Accept_Yn.equals("Y") ){

											fam_name_ind ="Y";
//											String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By' ><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
								} /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299-End*/

                                    }
                                   

									if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   width='20%' class='label'>" + First_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='First_Name1' id='First_Name1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='20%'  class='label'>" + Second_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='Second_Name1' id='Second_Name1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='20%' class='label'>" + Third_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='Third_Name1' id='Third_Name1' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   width='20%' class='label'>" + Family_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='Family_Name1' id='Family_Name1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}

										 /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299-Start*/
						  if (First_Name_Accept_Yn.equals("N") && Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") && Family_Name_Accept_Yn.equals("Y") ){

											fam_name_ind ="Y";
//											String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By' ><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
								} /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299-End*/

                                    }
                         
                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='20%' class='label'>" + First_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields' ><input type='text' name='First_Name1' id='First_Name1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='20%' class='label'>" + Second_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='Second_Name1' id='Second_Name1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td></tr><tr>");
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='20%' class='label'>" + Third_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='Third_Name1' id='Third_Name1' size='25' maxlength='"+third_name_length+"'	onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
                                    }
                                   else
									  if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4) {
									   if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   width='20%' class='label'>" + Family_Name_Prompt + "</td>");
                                        out.println("<td  width='30%' class='fields'><input type='text' name='Family_Name1' id='Family_Name1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
										
								    /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299-Start*/
						  if (First_Name_Accept_Yn.equals("N") && Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") && Family_Name_Accept_Yn.equals("Y") ){

											fam_name_ind ="Y";
//											String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By' ><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
								} /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299-End*/


								   }
								      else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }

                                  
								}
								
								if (pat_name_as_multipart_yn.equals("N"))	
								{			out.println("<td nowrap  width='20%' class='label'>" + Family_Name_Prompt + "</td>");
											out.println("<td nowrap  class='fields' width='30%'><input type='text' name='Family_Name1' id='Family_Name1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);EnableSearchBy(this)'   style=\"text-align:left\">");
//											String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By' ><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
									}
										else
										out.println("</td>");
                                    
                            /*        else {
                                        out.println("<td  width='13%' class='label'>&nbsp;</td>");
                                        out.println("<td  width='11%' class='label'>&nbsp;&nbsp;</td>");
                                    }*/ %>
									</tr>
			
				<%	
					if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4) 
					  {
						 if (pat_name_as_multipart_yn.equals("N"))	
						 { %>
							     <input type="hidden" name="First_Name1" id="First_Name1">
								 <input type="hidden" name="Second_Name1" id="Second_Name1">
								 <input type="hidden" name="Third_Name1" id="Third_Name1">
						 <%}
					 }
                  %>
				    
						<%
					      if(names_in_oth_lang_yn.equals("Y")){
							firstRowElement="";
							firstRowCompleted="";

							if(!language_direction.equals("R"))
							{
					      if(pat_name_as_multipart_yn.equals("Y")){  
								%>
										<tr>  
                                <% 
										
                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                                        out.println("<td   class='label' width='20%'>" + First_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields' ><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='30%'><input type='text' name='first_name_loc_lang1' id='first_name_loc_lang1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");
									 firstRowElement="Y";

                                    }else if( First_Name_Accept_Yn.equals("N") && First_Name_Order ==1 )
									{
										 out.println("<input type='hidden' name='first_name_loc_lang1' id='first_name_loc_lang1' >");
									}
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                                        out.println("<td   class='label' width='20%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                     //   out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");

									  out.println("<td   class='fields' width='30%'><input type='text' name='second_name_loc_lang1' id='second_name_loc_lang1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

									  if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										firstRowElement="Y";


                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 ) {
                                        out.println("<td   class='label' width='20%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='30%'><input type='text' name='third_name_loc_lang1' id='third_name_loc_lang1' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										firstRowElement="Y";


                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
									
                                        out.println("<td   class='label' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									  out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

									  if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										firstRowElement="Y";
                                    }
                                   

                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='first_name_loc_lang1' id='first_name_loc_lang1' >");
                                }else if( First_Name_Accept_Yn.equals("N") && First_Name_Order ==0)
								{
									 out.println("<input type='hidden' name='first_name_loc_lang1' id='first_name_loc_lang1' >");
								}
                                else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='second_name_loc_lang1' id='second_name_loc_lang1'>");
                                }
                                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='third_name_loc_lang1' id='third_name_loc_lang1' >");
                                }
                                else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='family_name_loc_lang1' id='family_name_loc_lang1' >");
                                    }
									 if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                                        out.println("<td   class='label' width='20%'>" + First_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='30%'><input type='text' name='first_name_loc_lang1' id='first_name_loc_lang1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");
									 if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                                        out.println("<td   class='label' width='20%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='30%'><input type='text' name='second_name_loc_lang1' id='second_name_loc_lang1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										 out.println("></td>");
										 if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 ) {
                                        out.println("<td   class='label' width='20%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");

                                        out.println("<td   class='fields' width='30%'><input type='text' name='third_name_loc_lang1' id='third_name_loc_lang1' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
                                        out.println("<td   class='label' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                      
										out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                   

									if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='20%'>" + First_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                        
										out.println("<td   class='fields' width='30%'><input type='text' name='first_name_loc_lang1' id='first_name_loc_lang1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='20%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='30%'><input type='text' name='second_name_loc_lang1' id='second_name_loc_lang1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='20%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                     //   out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

                                        out.println("<td   class='fields' width='30%'><input type='text' name='third_name_loc_lang1' id='third_name_loc_lang1' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                     
										out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    
									

									
                                %>
                               
                          <%if(pat_name_as_multipart_yn.equals("Y")){  }%>
                           
								<%
                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
									if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='20%'>" + First_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='30%'><input type='text' name='first_name_loc_lang1' id='first_name_loc_lang1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='20%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                        
										out.println("<td   class='fields' width='30%'><input type='text' name='second_name_loc_lang1' id='second_name_loc_lang1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td></tr><tr>");
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='20%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"'	onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                      
										out.println("<td   class='fields' width='30%'><input type='text' name='third_name_loc_lang1' id='third_name_loc_lang1' size='25' maxlength='"+third_name_length+"'	onBlur='makeValidString(this)' ");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									   out.println("></td>");
                                    }
                                   else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4) {
									   if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td    class='label' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\">");
                                        out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");
										
								   }
						       else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }
						  }
										if (pat_name_as_multipart_yn.equals("N"))	
										{
											 out.println("<td  nowrap  class='label' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
											out.println("<td nowrap  class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);EnableSearchBy(this);'   style=\"text-align:left\">");
//											String selects1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By_Lang' id='Search_By_Lang'><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
							
										}

										out.println("</td>");

						}
						else
						{
							/**** Added for Arabic ****/
							firstRowElement="";
							firstRowCompleted="";
					      if(pat_name_as_multipart_yn.equals("Y")){  
								%>
										<tr>                    
                           
								<%
                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                                        out.println("<td   class='arabic' width='20%'>" + First_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='30%'><input type='text' name='first_name_loc_lang1' id='first_name_loc_lang1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
									//	firstRowElement="Y";
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                                        out.println("<td   class='arabic' width='20%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                        
										out.println("<td   class='fields' width='30%'><input type='text' name='second_name_loc_lang1' id='second_name_loc_lang1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
									//	firstRowElement="Y";
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 ) {
                                        out.println("<td   class='arabic' width='20%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"'	onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                      
										out.println("<td   class='fields' width='30%'><input type='text' name='third_name_loc_lang1' id='third_name_loc_lang1' size='25' maxlength='"+third_name_length+"'	onBlur='makeValidString(this)' ");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									   out.println("></td>");
									  // firstRowElement="Y";
                                    }
                                   else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2) {
                                        out.println("<td    class='arabic' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\">");
                                        out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");
								//	 firstRowElement="Y";
										
								   }
						       else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }


									if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                                        out.println("<td   class='arabic' width='20%'>" + First_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                        
										out.println("<td   class='fields' width='30%'><input type='text' name='first_name_loc_lang1' id='first_name_loc_lang1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										/*
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}*/
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                                        out.println("<td   class='arabic' width='20%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='30%'><input type='text' name='second_name_loc_lang1' id='second_name_loc_lang1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										/*
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										} */
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 ) {
                                        out.println("<td   class='arabic' width='20%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                     //   out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

                                        out.println("<td   class='fields' width='30%'><input type='text' name='third_name_loc_lang1' id='third_name_loc_lang1' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										/*
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}*/
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
                                        out.println("<td   class='arabic' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                     
										out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										/*
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										} */

                                    } else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }
									%></tr><tr><%
									
									if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
										/*(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='20%'>" + First_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='30%'><input type='text' name='first_name_loc_lang1' id='first_name_loc_lang1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");
									 /*
									 if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										} */
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
										//if(firstRowCompleted.equals("Y")){
											//out.println("</tr><tr>");
										//}
                                        out.println("<td   class='arabic' width='20%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='30%'><input type='text' name='second_name_loc_lang1' id='second_name_loc_lang1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)' ");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										 out.println("></td>");
										 /*
										 if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}*/
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 ) {
										/*if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='20%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");

                                        out.println("<td   class='fields' width='30%'><input type='text' name='third_name_loc_lang1' id='third_name_loc_lang1' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										/*
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}*/
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
										/*if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                      
										out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										/*
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}*/
                                    } else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }


                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
										/*if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='20%'>" + First_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields' ><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='30%'><input type='text' name='first_name_loc_lang1' id='first_name_loc_lang1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");

                                    }else if( First_Name_Accept_Yn.equals("N") && First_Name_Order ==3 )
									{
										 out.println("<input type='hidden' name='first_name_loc_lang' id='first_name_loc_lang' >");
									}
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
										/*if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='20%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                     //   out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");

									  out.println("<td   class='fields' width='30%'><input type='text' name='second_name_loc_lang1' id='second_name_loc_lang1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

									  if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");


                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 ) {
										/*if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='20%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='30%'><input type='text' name='third_name_loc_lang1' id='third_name_loc_lang1' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");


                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
										/*if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
									
                                        out.println("<td   class='arabic' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									  out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

									  if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
                                    }  else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }
                                   %></tr><%

                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='first_name_loc_lang1' id='first_name_loc_lang1' >");
                                }else if( First_Name_Accept_Yn.equals("N") && First_Name_Order ==0)
								{
									 out.println("<input type='hidden' name='first_name_loc_lang1' id='first_name_loc_lang1' >");
								}
                                else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='second_name_loc_lang1' id='second_name_loc_lang1'>");
                                }
                                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='third_name_loc_lang1' id='third_name_loc_lang1' >");
                                }
                                else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='family_name_loc_lang1' id='family_name_loc_lang1' >");
                                    }
					
                              
						  }
										if (pat_name_as_multipart_yn.equals("N"))	
										{
											 out.println("<td    class='arabic' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
											out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);EnableSearchBy(this);'   dir='RTL' >");
//											String selects1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By_Lang' id='Search_By_Lang'><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
							
										}

										out.println("</td>");

										/**** End of Arabic changes ****/

						}
						} %>
				</tr>

<!--modified onBlur='makeValidQueryCriteria' to  onBlur='makeValidString' for the incident IN031010 on 8-3-2012 by Shanthi Ends-->
<!--Patient Name Derivation Logic Ends For Basic Search -->

				<tr>
								<td  width='25%' class="label"><%=prn_label%></td>
								<td  width='25%' class="fields"><input type="text" name="pr_resNo1" id="pr_resNo1" size="25" value='' maxlength="20"></td>
								<td  width='25%' class="label"><%=orn_label%></td>
								<td  width='25%' class="fields"><input type="text" name="oth_no1" id="oth_no1" size="25" value='' maxlength="20" onblur='movefocusout(this)'></td>
				</tr>
				<tr>
				<td   class="label" width='25%'><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td> <td class='fields'>
				<select name='order_by1' id='order_by1'>
				<OPTION value='P'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/><!--Patient Id defaulted in the search patient page for the incident 30979 by Shanthi on 22-2-2012 -->
				<OPTION value='X'>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----
				 
				</select>
				</td>
				<td/><td/>
				</tr>

</table>
</center>
   </table>
			
   </table>
   <!-- <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><br><br> -->
<input type='hidden' name='isAlternateAddressAppl' id='isAlternateAddressAppl' value="<%=isAlternateAddressAppl%>"><!--Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601-->
<input type='hidden' name='isAddressLengthIncAppl' id='isAddressLengthIncAppl' value="<%=isAddressLengthIncAppl%>"><!--Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0860.2-->
 <input type="hidden" name="isInsuranceCardReader" id="isInsuranceCardReader" value="<%=isInsuranceCardReader%>"><!--Added by kamatchi S for MOHE-CRF-0016.1 ON 28-AUG-2020-->
		<%      
            }catch(Exception e) {
                out.println(e.toString());
            }
            finally {
                if(pstmt != null) pstmt.close();
				if(pstmt1 != null) pstmt1.close();
                if(rs !=null) rs.close();
				if(rs1 !=null) rs1.close();
                if(con!=null) ConnectionManager.returnConnection(con,request);                
            }            
        %>	
	<!--//Maheshwaran K added for MMS-DM-CRF-0208.1 - suspend_inactive_pat_yn-->
	<input type="hidden" name="suspend_inactive_pat_yn" id="suspend_inactive_pat_yn" value="<%=suspend_inactive_pat_yn%>">
    <input type="hidden" name="1" id="1" value="">
    <input type="hidden" name="FULLSQL" id="FULLSQL" value="">
    <input type="hidden" name="ORDERBY" id="ORDERBY" value="">
    <input type="hidden" name="jsp_name" id="jsp_name" value="<%=jsp_name%>">
    <input type="hidden" name="window_styl" id="window_styl" value="<%=window_styl%>">
    <input type="hidden" name="close_yn" id="close_yn" value="<%=close_yn%>">
    <input type="hidden" name="register_button_yn" id="register_button_yn" value="<%=register_button_yn%>">
    <input type="hidden" name="func_act" id="func_act" value="<%=func_act%>">
    <input type="hidden" name="soundex_dflt" id="soundex_dflt" value="<%=Soundex%>">
	<input type='hidden' name='alt_id1_accept_alphanumeric' id='alt_id1_accept_alphanumeric' value="<%=alt_id1_accept_alphanumeric_yn%>">
   	<input type="hidden" name="names_in_oth_lang_yn_hd" id="names_in_oth_lang_yn_hd" value="<%=names_in_oth_lang_yn%>">
   	<input type="hidden" name="pat_name_as_multipart_yn_hd" id="pat_name_as_multipart_yn_hd" value="<%=pat_name_as_multipart_yn%>">
	<!-- Suresh on 13.12.2010 language_direction -->
   	<input type="hidden" name="language_direction" id="language_direction" value="<%=language_direction%>">
   	<input type="hidden" name="simplesearch_select_yn" id="simplesearch_select_yn" value="Y">
   	<input type="hidden" name="morelessexpand" id="morelessexpand" value="Y">

   	<input type="hidden" name="cr_jsp_name" id="cr_jsp_name" value="<%=cr_jsp_name%>">
   	<input type="hidden" name="cr_window_styl" id="cr_window_styl" value="<%=cr_window_styl%>">
   	<input type="hidden" name="cr_close_yn" id="cr_close_yn" value="<%=cr_close_yn%>">
   	<input type="hidden" name="cr_win_top" id="cr_win_top" value="<%=cr_win_top%>">
   	<input type="hidden" name="cr_win_width" id="cr_win_width" value="<%=cr_win_width%>">
   	<input type="hidden" name="cr_win_height" id="cr_win_height" value="<%=cr_win_height%>">
   	<input type="hidden" name="cr_act_yn" id="cr_act_yn" value="<%=cr_act_yn%>">
   	<input type="hidden" name="cr_srr" id="cr_srr" value="<%=cr_srr%>">
   	<input type="hidden" name="cr_register_button_yn" id="cr_register_button_yn" value="<%=cr_register_button_yn%>">
   	<input type="hidden" name="cr_func_act" id="cr_func_act" value="<%=cr_func_act%>">
   	<input type="hidden" name="cr_defaultgender" id="cr_defaultgender" value="<%=cr_defaultgender%>">
   	<input type="hidden" name="cr_enablegenderyn" id="cr_enablegenderyn" value="<%=cr_enablegenderyn%>">
   	<input type="hidden" name="cr_function_id" id="cr_function_id" value="<%=cr_function_id%>">
   	<input type="hidden" name="cr_func_idpassed" id="cr_func_idpassed" value="<%=cr_func_idpassed%>">
   	<input type="hidden" name="Gender" id="Gender" value="<%=defaultgender%>">
	<!--Below Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]-->
	<input type="hidden" name="alt_id1_pat_sch_exact_yn" id="alt_id1_pat_sch_exact_yn" value="<%=alt_id1_pat_sch_exact_yn%>">
	<input type="hidden" name="alt_id2_pat_sch_exact_yn" id="alt_id2_pat_sch_exact_yn" value="<%=alt_id2_pat_sch_exact_yn%>">
	<input type="hidden" name="alt_id3_pat_sch_exact_yn" id="alt_id3_pat_sch_exact_yn" value="<%=alt_id3_pat_sch_exact_yn%>">
	<input type="hidden" name="alt_id4_pat_sch_exact_yn" id="alt_id4_pat_sch_exact_yn" value="<%=alt_id4_pat_sch_exact_yn%>">
    <!--Below line added for this CRF HSA-CRF-0289 -->	
	  <input type="hidden" name="alterIdSearch" id="alterIdSearch" value="<%=alterIdSearch%>">
	  <input type="hidden" name="isAlternateId" id="isAlternateId" value="<%=isAlternateId%>">
	  <input type="hidden" name="alternate_no" id="alternate_no" value="<%=alternate_no%>">

	  <input type="hidden" name="fam_name_ind" id="fam_name_ind" value="<%=fam_name_ind%>">
	  <!--//Added by Maheshwaran K for AAKH-CRF-0168-->
  <input type="hidden" name="dft_national_id" id="dft_national_id" value="<%=dft_national_id%>">
	   <!--Added by Rameswar on  19-04-2016 for HSA-CRF-0299 -->
	  
   </form>
    <script>
	if('<%=alterIdSearch%>'!=""&&'<%=isAlternateId%>'=="true"){ 
	     setTimeout("AlternateIdFocus('<%=alterIdSearch%>','<%=isAlternateId%>','<%=alternate_no%>')",500)
	}else{ 
	     setTimeout('FocusFirstElement()',500)
	}</script>
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


<!DOCTYPE html>

<!-- Last Modified Date Time : 9/23/2005 11:28 AM -->
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<Script src="../../eMP/js/SmartCard.js" language="JavaScript"></Script>

<!-- Added by Ashwin K for AAKH-CRF-0150-->
	<Script src="../../eMP/js/SmartCard01.js" language="JavaScript"></Script>

<Script src="../../eXH/js/ExternalApplication.js" language="JavaScript"></Script><!--Added by kamatchi S form MOHE-CRF-0016.1 on 26-AUG-2020-->
<%
	
		if(session.getValue("smart_path")!= null) {
			if(!session.getValue("smart_path").equals(" ")){
				out.println(session.getValue("smart_path"));
			}
		}
		%>			
<Script src="../../eMP/js/json02.js"></Script>
<Script src="../../eMP/js/jquery.min.js"></Script>	
<!-- Added By Ashwin K for AAKH-CRF-0150 -->
<script  src="../../eCommon/js/jquery-ui.js" language="JavaScript"></script>  
<link href="../../eCommon/html/jquery-ui.css" rel="stylesheet" type="text/css">
<!-- Ended By Ashwin K for AAKH-CRF-0150 -->
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

	// Added for MOHE-CRF-164.1 by lakshmanan
	String sessionID 		= 			session.getId();
	String facility			= (String) session.getValue("facility_id");
	String loginUser		= (String) session.getValue("login_user");
	Properties p = (java.util.Properties) session.getValue("jdbc");
	String p_ws_no = p.getProperty("client_ip_address");
    // MOHE-CRF-0164 end


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
	String pat_ser_grp_code="";
	String pat_ser_grp_desc="";
	int count=0;
	String nat_id_prompt ="";
	String names_in_oth_lang_yn="";
	String ext_system_interface_yn="";
	String nat_data_source_id="";
	String nat_id_check_digit_id="";
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
	String firstRowElement="";
	String firstRowCompleted="";
    String Family_No_Link_Yn ="";
    String Family_No_Prompt ="";
    String Res_Area_Prompt = "";
    //String orderby="";
    String Alt_Id1 = "" ;
    String Alt_Id2 = "" ;
    String Alt_Id3 = "" ;
    String Alt_Id4 = "" ;
	//String prn_label="";
	//String orn_label="";
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
    //String win_width    =request.getParameter("win_width");
    String cr_win_width    =request.getParameter("win_width");
    //String win_top      =request.getParameter("win_top");
    String cr_win_top      =request.getParameter("win_top");
    //String act_yn   =request.getParameter("act_yn");
    String cr_act_yn   =request.getParameter("act_yn");
    //String srr = request.getParameter("srr");
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

	// Added for IN0 by Suresh M on 20.12.2010
	String patient_class=request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	
	//Added for this CRF HSA-CRF-0289
	String alterIdSearch=request.getParameter("alterIdSearch")==null?"":request.getParameter("alterIdSearch");
	String isAlternateId=request.getParameter("isAlternateId")==null?"":request.getParameter("isAlternateId");
	String alternate_no=request.getParameter("alternate_no")==null?"":request.getParameter("alternate_no");
	//End HSA-CRF-0289
	//Maheshwaran K added for MMS-DM-CRF-0208.1
	String suspend_inactive_pat_yn=request.getParameter("suspend_inactive_pat_yn")==null?"N":request.getParameter("suspend_inactive_pat_yn");
	String smart_contact_no=request.getParameter("smart_contact_no")==null?"":request.getParameter("smart_contact_no"); //Added by Ashwin K for AAKH-CRF-0150
	

    String self     = "";
    String selm = "";
    String dis      = "";
    String sdisable = "";
	String Smartcard_path="" ; //added for smart card 
	String function_name="" ; //added for Alkhalej smart card 
	String name_dervn_logic="";

    if(defaultgender.equals("F")) self = "selected";
    else if(defaultgender.equals("M")) selm = "selected";

    if(enablegenderyn.equals("N")) dis = "DISABLED";


    String Soundex ="";
    //String fieldname = "";
    //String str="";
    //String str_new ="";
    //String dateofbirthyn="N";
    //Added by kumar on 8/3/2002 for DR Module
    String function_id  =   request.getParameter("dr_function_id")==null?"":request.getParameter("dr_function_id");
    String cr_function_id  =   request.getParameter("dr_function_id")==null?"":request.getParameter("dr_function_id");
   
    if(!function_id.equals("") && !function_id.equals("PAT_REG") && !function_id.equals("NEWBORN_REG")) sdisable = "disabled";
	
	if(func_act.equals("DuplicateRegistration"))
	sdisable = "";
	//String dr_install_yn = "N";
   // boolean Sndx = false;
    String errFlag = "N";
	String separate_file_no_yn = "N";
	String mrn_length = "20";
	int cntPrefFac = 0;

	String pat_name_as_multipart_yn	= "";
	String maintain_doc_or_file		= "";
	String docDisableField			= "";
	String first_name_length = "";
	String second_name_length = "";
	String third_name_length = "";
	String family_name_length = "";
	String file_type_appl_yn = "";
	String review_nb_links_bef_reg_yn = "";
//	String patient_id_length = "";
/*Indivisual Quires */
	//Below Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]
	String alt_id1_pat_sch_exact_yn="";
	String alt_id2_pat_sch_exact_yn="";
	String alt_id3_pat_sch_exact_yn="";
	String alt_id4_pat_sch_exact_yn="";
	String dft_national_id="";
	String biometric_authentication_yn="N"; //Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
	boolean isAlternateAddressAppl = false;//Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601

	boolean isAddressLengthIncAppl = false;//Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0860.2
	
	boolean isPatientNameContainsAppl = false;  //Added by Mujafar  against ML-MMOH-CRF-1127
	String select_val=""; //Added by Mujafar  against ML-MMOH-CRF-1127
	
	boolean isInsuranceCardReader = false;//Added by kamatchi S for MOHE-CRF-0016.1 ON 26-AUG-2020
	String insurance_id = "";//Added by kamatchi S for MOHE-CRF-0016.1 ON 26-AUG-2020
	String ndhm_appl_YN = "N"; // Added for NDHM integration GHL-CRF o657.1
/*Query For Select  Some Of theFileds From MP_Pararm*/

		String Qry_For_Param="SELECT Dflt_Sndx_type, separate_file_no_yn, pat_name_as_multipart_yn, maintain_doc_or_file,family_org_id_accept_yn,first_name_length, second_name_length,third_name_length,family_name_length,file_type_appl_yn,review_nb_links_bef_reg_yn,patient_id_length,dft_national_id,biometric_authentication_yn FROM mp_param where module_id='MP'";

/*Query For Other Alt ID Type Drop Down*/

		String Qry_For_AltType = "SELECT alt_id_type,nvl((select desc1_value from SM_OTH_LANG_DATA_SKEY where table_id ='MP_ALTERNATE_ID_TYPE' and language_id =? and pk_value=mp_alternate_id_type.alt_id_type),SHORT_DESC) SHORT_DESC FROM mp_alternate_id_type WHERE alt_id_type NOT IN (SELECT alt_id1_type FROM MP_PARAM where module_id='MP'  UNION SELECT NVL(alt_id2_type,1) FROM MP_PARAM where module_id='MP'  UNION SELECT NVL(alt_id3_type,2) FROM MP_PARAM where module_id='MP' UNION SELECT NVL(alt_id4_type,3) FROM MP_PARAM where module_id='MP') and eff_status='E' order by 2";

/*Query For Patient Series Drop Down*/
		String Qry_For_PatSeries="select pat_ser_grp_code,short_desc from mp_pat_ser_grp_lang_vw where 	language_id=? order by short_desc"; 
/*Query For Order By Drop Down*/
		String Qry_for_OrderBy="select field_name,field_desc from mp_pat_search_result_lang_vw where field_select='Y' and language_id =? order by field_order ";
/*Query For Contact Mode  Drop Down*/
		String Qry_For_CntMode="Select Contact_Mode,short_desc from mp_contact_mode_lang_vw where language_id=? and eff_status='E' order by short_desc";


/**ENDS**/
/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/
	String fam_name_ind="N";

	try 
	{	  
		con = ConnectionManager.getConnection(request);
		//for smart card
		pstmt = con.prepareStatement("select VALUE_1,nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");

		rs = pstmt.executeQuery();	
  

		if(rs!=null && rs.next())
		{
		Smartcard_path=rs.getString("VALUE_1");
		function_name=rs.getString("VALUE_2");   // alkhaleej smart card

		}		

		isAlternateAddressAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE");//Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601

		isAddressLengthIncAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");//Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0860.2
		
		isPatientNameContainsAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","PATIENT_NAME_CONTAINS_APPL"); //Added by Mujafar  against ML-MMOH-CRF-1127
		ndhm_appl_YN 	= getNDHMApplicable(con);  //Maheshwaran K added for GHL-CRF-0657.2 as 06-09-2923

	
		if(isPatientNameContainsAppl) //Added by Mujafar  against ML-MMOH-CRF-1127
			select_val = "selected";

		isInsuranceCardReader = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INSURANCE_CARD_READER"); //Added by kamatchi S for MOHE-CRF-0016.1 ON 26-AUG-2020

		if(pstmt!=null)
		pstmt.close();
		if(rs!=null)
		rs.close();
		//for smart card
        pstmt = con.prepareStatement(Qry_For_Param);
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
			review_nb_links_bef_reg_yn = checkForNull(rs.getString("review_nb_links_bef_reg_yn"),"N"); 
//			patient_id_length = checkForNull(rs.getString("patient_id_length"),""); 
			dft_national_id=checkForNull(rs.getString("dft_national_id"));//Added by Maheshwaran K for AAKH-CRF-0168
			biometric_authentication_yn=checkForNull(rs.getString("biometric_authentication_yn"));//Added by Maheshwaran K for AAKH-CRF-0175
        }       
        else
        {
            errFlag = "Y";
            out.println("<script>alert(getMessage('MP_PARAM_NOT_FOUND','MP'));</script>");
            //out.println("<script>parent.window.close();</script>"); 
			out.println("<script>const dialogTag = parent.parent.document.getElementById('dialog_tag'); dialogTag.close();</script>");      			
        }
		
		if(maintain_doc_or_file.equals("D")) docDisableField = "disabled";
	  /*  try 
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
		}*/

		/*try 
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
		}*/

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

        <Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script>
		<Script language='javascript' src='../../eMP/js/PatientSearch.js'></Script>
       <Script language="JavaScript">
        </Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




		<!--Added by Ashwin K for AAKH-CRF-0150 -->
	 <script>
		function MButton_click_PatSearch()
			{
			var res = PatSearch_ReadDF1_onclick(<%=function_name%>);
			var arr = res.split("!~");
			//alert("arr length "+arr.length);
			var res_natid = arr[0].replace(/^\s+|\s+$/gm,'');
			var res_mobno = arr[1].replace(/^\s+|\s+$/gm,'');
			$.ajax({
			type: "POST",
			url: "../../eMP/jsp/getPatientCount.jsp",
			data: {
				NatID : res_natid,
				smart_data : res	
			},
			async: false
		})
		.done (function(data, textStatus, jqXHR) { 
		});	
		}

			$(document).ready(function()
				{
				$("#M_Btn").prop('disabled', false);
				$("#National_Id_No").prop('disabled', true);
				$("#EmiratesID_edit").click(function() {
				if($('#EmiratesID_edit').is(':checked'))
				{
				var auth_userEmirates = EditEmiratesID_authScr();
				//alert("auth_userEmirates ="+auth_userEmirates);
				if(auth_userEmirates == true)
					{
					$("#National_Id_No").prop('disabled', false);
					$("#M_Btn").prop('disabled', true);
					}
				else
					{
					$('#EmiratesID_edit').prop('checked', false);
					}
				}
				else
					{
					$("#National_Id_No").prop('disabled', true);
					$("#M_Btn").prop('disabled', false);
					}
				});
			});


async function EditEmiratesID_authScr()
{	
	var retVal=new Array();
	var dialogHeight= "10" ;
	var dialogWidth	= "22" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal =await window.showModalDialog("../../eSM/jsp/AuthorizeMain.jsp?mode=s",arguments,features);
	return retVal;

}
		</script>
<!-- Ended By Ashwin K for AAKH-CRF-0150 -->
    </head>         
	<%
                            try{
								  //String Qry_For_Slct_Flds="Select nvl(param.Nat_Id_Prompt, 'National ID No') Nat_ID_Prompt, param.nat_data_source_id, param.nat_id_check_digit_id, param.Patient_Id_Length,param.Nat_Id_Length,param.Family_No_Link_Yn,param.Family_No_Prompt,param.First_Name_Accept_Yn,param.First_Name_Order,param.First_Name_Prompt,param.Second_Name_Accept_Yn,param.Second_Name_Order,param.Second_Name_Prompt,param.Third_Name_Accept_Yn,param.Third_Name_Order,param.Third_Name_Prompt,param.Family_Name_Accept_Yn,param.Family_Name_Order,param.Family_Name_Prompt,First_Name_loc_lang_Prompt, Second_Name_loc_lang_Prompt, Third_Name_loc_lang_Prompt, Family_Name_loc_lang_Prompt,param.alt_id1_accept_alphanumeric_yn, param.Alt_Id1_type,alt_id1.long_desc alt_id1_desc, param.Alt_Id2_type,alt_id2.long_desc alt_id2_desc, param.Alt_Id3_type,alt_id3.long_desc alt_id3_desc,param.Alt_Id4_type,(alt_id4.long_desc) alt_id4_desc, param.alt_id1_length, param.alt_id2_length, param.alt_id3_length, param.alt_id4_length, param.addl_field1_prompt, param.addl_field1_length, param.addl_field2_prompt, param.addl_field2_length, addl_field3_prompt, addl_field3_length, param.addl_field4_prompt, param.addl_field4_length, param.addl_field5_prompt, param.addl_field5_length,param.accept_national_id_no_yn,param.nat_id_accept_alphanumeric_yn,param.ext_system_interface_yn,param.accept_oth_alt_id_yn,NAMES_IN_OTH_LANG_YN from MP_PARAM_LANG_VW param,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id1,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id2,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id3,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id4 where param.module_id='MP' and param.language_id =? and  param.language_id=alt_id1.language_id and param.language_id=alt_id2.language_id(+) and param.language_id=alt_id3.language_id(+) and param.language_id=alt_id4.language_id(+) and param.alt_id1_type=alt_id1.alt_id_type and param.alt_id2_type=alt_id2.alt_id_type(+) and param.alt_id3_type=alt_id3.alt_id_type(+) and param.alt_id4_type=alt_id4.alt_id_type(+)";
								  /*String Qry_For_Slct_Flds="SELECT NVL (param.nat_id_prompt, 'National ID No') nat_id_prompt,param.nat_data_source_id, param.nat_id_check_digit_id,param.patient_id_length, param.nat_id_length, param.family_no_link_yn,param.family_no_prompt, param.first_name_accept_yn,param.first_name_order, param.first_name_prompt,param.second_name_accept_yn, param.second_name_order,param.second_name_prompt, param.third_name_accept_yn,param.third_name_order, param.third_name_prompt,param.family_name_accept_yn, param.family_name_order,param.family_name_prompt, first_name_loc_lang_prompt,second_name_loc_lang_prompt, third_name_loc_lang_prompt,family_name_loc_lang_prompt, param.alt_id1_accept_alphanumeric_yn,param.alt_id1_type,mp_get_desc.mp_alternate_id_type(param.alt_id1_type,param.language_id,'1') alt_id1_desc,param.alt_id2_type,mp_get_desc.mp_alternate_id_type(param.alt_id2_type,param.language_id,'1') alt_id2_desc,param.alt_id3_type,mp_get_desc.mp_alternate_id_type(param.alt_id3_type,param.language_id,'1') alt_id3_desc,param.alt_id4_type,mp_get_desc.mp_alternate_id_type(param.alt_id4_type,param.language_id,'1') alt_id4_desc,param.alt_id1_length,param.alt_id2_length, param.alt_id3_length, param.alt_id4_length,param.addl_field1_prompt, param.addl_field1_length,param.addl_field2_prompt, param.addl_field2_length, addl_field3_prompt,addl_field3_length, param.addl_field4_prompt, param.addl_field4_length,param.addl_field5_prompt, param.addl_field5_length,param.accept_national_id_no_yn, param.nat_id_accept_alphanumeric_yn,param.ext_system_interface_yn, param.accept_oth_alt_id_yn,names_in_oth_lang_yn,name_dervn_logic FROM   mp_param_lang_vw param WHERE  param.module_id = 'MP' AND param.language_id = ?";//Query modified for Performance tuning*/
								  String Qry_For_Slct_Flds="SELECT param.alt_id1_pat_sch_exact_yn,param.alt_id2_pat_sch_exact_yn,param.alt_id3_pat_sch_exact_yn,param.alt_id4_pat_sch_exact_yn,NVL (param.nat_id_prompt, 'National ID No') nat_id_prompt,param.nat_data_source_id, param.nat_id_check_digit_id,param.patient_id_length, param.nat_id_length, param.family_no_link_yn,param.family_no_prompt, param.first_name_accept_yn,param.first_name_order, param.first_name_prompt,param.second_name_accept_yn, param.second_name_order,param.second_name_prompt, param.third_name_accept_yn,param.third_name_order, param.third_name_prompt,param.family_name_accept_yn, param.family_name_order,param.family_name_prompt, first_name_loc_lang_prompt,second_name_loc_lang_prompt, third_name_loc_lang_prompt,family_name_loc_lang_prompt, param.alt_id1_accept_alphanumeric_yn,param.alt_id1_type,mp_get_desc.mp_alternate_id_type(param.alt_id1_type,param.language_id,'1') alt_id1_desc,param.alt_id2_type,mp_get_desc.mp_alternate_id_type(param.alt_id2_type,param.language_id,'1') alt_id2_desc,param.alt_id3_type,mp_get_desc.mp_alternate_id_type(param.alt_id3_type,param.language_id,'1') alt_id3_desc,param.alt_id4_type,mp_get_desc.mp_alternate_id_type(param.alt_id4_type,param.language_id,'1') alt_id4_desc,param.alt_id1_length,param.alt_id2_length, param.alt_id3_length, param.alt_id4_length,param.addl_field1_prompt, param.addl_field1_length,param.addl_field2_prompt, param.addl_field2_length, addl_field3_prompt,addl_field3_length, param.addl_field4_prompt, param.addl_field4_length,param.addl_field5_prompt, param.addl_field5_length,param.accept_national_id_no_yn, param.nat_id_accept_alphanumeric_yn,param.ext_system_interface_yn, param.accept_oth_alt_id_yn,names_in_oth_lang_yn,name_dervn_logic FROM   mp_param_lang_vw param WHERE  param.module_id = 'MP' AND param.language_id = ?";//Query modified for Performance tuning and few columns are added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]
                                  pstmt = con.prepareStatement(Qry_For_Slct_Flds);
								  pstmt.setString(1,locale);
								  rs = pstmt.executeQuery();
                                  if (rs !=null){
                                        if (rs.next())
                                        {
                                            nat_id_prompt = rs.getString("Nat_Id_Prompt");
                                            if (nat_id_prompt==null) nat_id_prompt = "";
											ext_system_interface_yn = rs.getString("ext_system_interface_yn");
											nat_data_source_id = checkForNull(rs.getString("nat_data_source_id"),"");
											nat_id_check_digit_id = checkForNull(rs.getString("nat_id_check_digit_id"),"");
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
											name_dervn_logic = rs.getString("name_dervn_logic")==null ? "N" : rs.getString("name_dervn_logic");
											
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
											/*Below Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]*/
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

                                /*  pstmt = con.prepareStatement("select contact_mode, short_desc from mp_contact_mode_lang_vw where contact_mode in ('PRN', 'ORN') and language_id = '"+locale+"'");
								  try{
                                    rs = pstmt.executeQuery();
									String cnt_mode="";
									while(rs!=null && rs.next()){
										cnt_mode=rs.getString("contact_mode");
										if(cnt_mode.equals("PRN"))
											prn_label=rs.getString("short_desc");
										if(cnt_mode.equals("ORN"))
											orn_label=rs.getString("short_desc");
									}
								  }catch(Exception ex){
									 ex.printStackTrace();
								  }finally{
									  if (pstmt != null) pstmt.close();
									  if (rs != null) rs.close();
								  }*/

                                %> 


    <body class='content' topmargin='0' OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="DefaultSelect('<%=Soundex%>');dfltPatClass('<%=patient_class%>');"> 
    <form name="Advnc_Patient_Search_Form" id="Advnc_Patient_Search_Form" id="DupPatForm" method='post' action='../../eMP/jsp/PatientSearchCriteria.jsp' >
	<input type="hidden" name="maintain_doc_or_file" id="maintain_doc_or_file" value="<%=maintain_doc_or_file%>">
	<input type ='hidden' name='family_org_id_accept_yn' id='family_org_id_accept_yn' value="<%=family_org_id_accept_yn%>"></input>
	<input type ='hidden' name='func_idpassed' id='func_idpassed' value="<%=func_idpassed%>"></input>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>

            <table border="0" cellpadding="2" cellspacing="0" width="100%">
              <tr>
                    <td width='100%' class="BORDER" valign=top>

									<table border="0" cellpadding="2" cellspacing="0" width="100%">	
									
								
									<tr>
									<td  width='25%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
										
									<td  width='30%' class="fields" ><input type="text" name="Patient_Id" id="Patient_Id" size="25" maxlength="<%=patient_id_length%>" onFocus="MoveFocus(2)" onKeyPress="return CheckForSpecChars(event)" onBlur="makeValidQueryCriteria(this);ChangeCase(this)" > &nbsp;
										<select name="patient_id_search_by" id="patient_id_search_by">
											<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
											<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
											<option value="C" selected><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
										</select>
									
									</td>

									<% 

									String nat_id_onKeyPress = "";
										
									if(nat_id_accept_alphanumeric_yn.equals("Y"))
									{
										nat_id_onKeyPress = "CheckForAlphaCharsNatID(event);";
									}
									else
									{
										nat_id_onKeyPress = "allowValidNumber(this,event,2, 0);";
									}
									//Maheshwaran K added for GHL-CRF-0657.2 as 06-09-2923	
						
									if(ndhm_appl_YN.equals("Y")) {
										%>
									<td class="label" ><fmt:message key="eMP.ABHANumber.label" bundle="${mp_labels}"/></td> 
									<td class="label"><input type="text" name="abha_pat_id" id="abha_pat_id"     value='' size='20' >&nbsp;&nbsp;&nbsp;<input type=button value='S' id='S_Btn' name='S_Btn' id='S_Btn' class= 'button' onClick="scanAndShareAbhaId('','<%=facility%>','<%=loginUser%>','<%=p_ws_no%>','<%=sessionID%>');"/></td>	
									<%	}
									else {
									if (accept_national_id_no_yn.equals("Y"))
									{ 
										if (ext_system_interface_yn.equals("Y") && nat_data_source_id.equals("NRIC") && nat_id_check_digit_id.equals(""))
										{
										%>									
											
											<td nowrap align='right' class="label" nowrap><%=nat_id_prompt%></td>
											<!-- Added  id="National_Id_No" by Ashwin K for AAKH-CRF-0150 -->
											<td align="left" width="15%">&nbsp;&nbsp;<input type="text" <%if(function_name.equals("01")){%> id="National_Id_No" <%}%> name="National_Id_No" size="<%=nat_id_length%>" maxlength="<%=nat_id_length%>" 
											onkeypress="return <%=nat_id_onKeyPress%>"	onBlur='makeValidQueryCriteria(this);validateID(this,"<%=nat_id_check_digit_id%>");check_clear();' tabindex=1>
											
										<!-- Added by Ashwin K for AAKH-CRF-0150 -->
									<%if(function_name.equals("01")){%>
									<input type=button value='M' id='M_Btn' name='M_Btn' id='M_Btn' class= 'button' onClick='MButton_click_PatSearch();'>
									<input type="checkbox"  name="EmiratesID_edit" id="EmiratesID_edit"  >
									<%}
									else if(function_name.equals("05")){ %><!--"05" Added  by santhosh for TH-KW-CRF-0019.1 -->
									<input type=button value='M' id='M_Btn' name='M_Btn' id='M_Btn' class= 'button' onClick='MButton_click_PatSearch();'>
									<% } 
									else if( function_name.equals("07")){ %> <!--"07" Added  by Lakhsmanan for MOHE-CRF-0164.1 -->
									<input name='NatID_Btn1' id='NatID_Btn1' class='button' Onclick="NationalID_Search('<%=sessionID%>','<%=facility%>','<%=loginUser%>','<%=p_ws_no%>')" type="button" value='M'>   <%} // MOHE-CRF-0164.1
									else { %>
									<input type=button value='M' class= 'button' onClick='PatSearch_ReadDF1_onclick();'>
									<% } %>
									<!-- Ended by Ashwin K for AAKH-CRF-0150 -->
										<%
										if(function_name.equals("01")){%>
											<!-- <applet code="CardReaderApplet.class" name="CardReader"
											codebase="../../eMP/CardReader/" archive="CardReaderApplet.jar" width="5"
											height="5">
											<PARAM name="button_width" value="0" />
											<PARAM name="button_height" value="0" />
											<PARAM name="button_label" value="0" />						
											<param name="separate_jvm" value="true" />
											Sorry, Your browser does not support Java applet!
											</applet>  -->
											
											<!-- Commented above old card reader applet and added for AAKH-CRF-0158 -->

											<APPLET style="border:solid 1px gray" id="PublicDataWebComponent" name="PublicDataWebComponent" codebase="../../eMP/CardReader/" CODE="emiratesid.jio.webcomponents.PublicDataReader"
                                                        ARCHIVE="PublicDataApplet-Sagem.jar" WIDTH="0" HEIGHT="0">
                                                        <param name="EncryptParameters" value="false" />
                                                        <param name="RelativeCertPath" value="certs" />
														<param name="separate_jvm" value="true" />
														<PARAM name="button_label" value="0" />	
                                                         This browser does not support Applets.
                                             </APPLET> 
										<%}%>
											</td>                                 
										<%}
										else 
										 {%><td  width='25%' class="label"><%=nat_id_prompt%></td>
											<td  width='25%' class="fields"><input type="text" name="National_Id_No" id="National_Id_No" size="25" maxlength="<%=nat_id_length%>" 
											onkeypress="return <%=nat_id_onKeyPress%>"	onBlur="makeValidQueryCriteria(this)" onFocus="MoveFocus(2)" tabindex=1></td>
										   <%}
									}else{%>
									  <input type="hidden" name="National_Id_No" id="National_Id_No"  
								       value=''> 
									<%}	%>
									<input type="hidden" name="abha_pat_id" id="abha_pat_id"    id="abha_pat_id" value='' size='20' >
									<%									
									}%> 
									
						</tr>
						<tr><!--Below line modified by venkatesh on 07/Oct/2013 against 43291-->
							<%if(!Alt_Id1.equals("")){%>							 
							    <td  width='25%' class="label"><%=Alt_Id1%></td>
							    <td  width='25%' class="fields" ><input type="text" name="Alt_Id1_No" id="Alt_Id1_No" size="25" maxlength="<%=alt_id1_length%>" value='' onKeyPress='return CheckForSpeclChars(event,"Alt_Id1")'onFocus="MoveFocus(2)" onBlur="makeValidQueryCriteria(this);AdnvcenableSuffix()"  ><input type="hidden" name="Expiry_Date1" id="Expiry_Date1" size="8" maxlength="10"  onFocus="MoveFocus(1)">
								<input type="hidden" name="newborn_suffix" id="newborn_suffix" size='1' onKeyPress="return allowValidNumber(this,event,2,0);" onBlur="makeValidQueryCriteria(this);"
								maxlength='2'  disabled></td>
                            <%}%>
							<%
									if(!isInsuranceCardReader){//Added by kamatchi S for MOHE-CRF-0016.1 ON 26-AUG-2020
									if(!Alt_Id2.equals("")){%>   
								<!--below code change done for SRR20056-SCF-12671-->
								<td  width='25%' class="label"><%=Alt_Id2%></td>
								<td  width='25%' class="fields"><input type="text" name="Alt_Id2_No" id="Alt_Id2_No" size="25" maxlength="<%=alt_id2_length%>" value='' onKeyPress='return altID234Validations(event)' onBlur="makeValidQueryCriteria(this)" onFocus="MoveFocus(2)" ><input type="hidden" name="Expiry_Date2" id="Expiry_Date2" size="8" maxlength="10"  onFocus="MoveFocus(1)"></td>
							<%}
								}else{%>
								<td class='label'  width='15%'><fmt:message key="Common.Insurance.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
								<td class='fields' ><div id='insurance_div'><textarea name='insurance_id' id='insurance_id' rows="3" cols="50" maxlength='300'  tabindex = '6'  value = "<%=insurance_id%>" readonly></textarea>&nbsp;<input type='button' class='button' Value=' Read ' onClick='insCardReader(insurance_id,insurance_div)'> 
								<input type="hidden" name="insurance_id_2" id="insurance_id_2" value="<%=insurance_id%>">
								<input type="hidden" name="Alt_Id2_No" id="Alt_Id2_No" value=""></div></td>
							<%}%>
							</tr>
							<tr>
							<%if(!Alt_Id3.equals("")){%>   
								<!--below code change done for SRR20056-SCF-12671-->
								<td  width='25%' class="label"><%=Alt_Id3%></td>
								<td  width='25%' class="fields"><input type="text" name="Alt_Id3_No" id="Alt_Id3_No" size="25" value='' maxlength="<%=alt_id3_length%>" onKeyPress='return altID234Validations(event)' onBlur="makeValidQueryCriteria(this)" onFocus="MoveFocus(2)" ><input type="hidden" name="Expiry_Date3" id="Expiry_Date3" size="8" maxlength="10"  onFocus="MoveFocus(1)"></td>
							<%}%>
							<%if(!Alt_Id4.equals("")){%>
								<!--below code change done for SRR20056-SCF-12671-->
								<td  width='25%' class="label"><%=Alt_Id4%></td>
								
								<td  width='25%' class="fields"><input type="text" name="Alt_Id4_No" id="Alt_Id4_No" size="25" maxlength="<%=alt_id4_length%>" value='' onKeyPress='return altID234Validations(event)' onBlur="makeValidQueryCriteria(this)" onFocus="MoveFocus(2)" ><input type="hidden" name="Expiry_Date4" id="Expiry_Date4" size="8" maxlength="10"  onFocus="MoveFocus(1)" ></td>
							<%}%>
				</tr>
					
					<tr>
							<%if(accept_oth_alt_id_yn.equals("Y")){%>
								
								<td  width='25%' class="label" ><fmt:message key="Common.OtherAltType.label" bundle="${common_labels}"/></td>
								
								<td  width='25%' class="fields" ><select onchange='enableOtherAltId(this.value)' name='other_alt_id' id='other_alt_id' ><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----

								<%
									
									pstmt = con.prepareStatement(Qry_For_AltType);
									pstmt.setString(1,locale);
									rs = pstmt.executeQuery();	
									
									if(rs != null){
										while (rs.next()){          
											out.println ( "<Option value=\""+rs.getString("alt_id_type")+"\" >"+rs.getString("SHORT_DESC")+"</Option>" ) ;
										}
									}	
								%>
								</select></td>
								
								<td  class=label  width='25%'><fmt:message key="eMP.OtherAltNo.label" bundle="${mp_labels}"/></td>
								<td class=fields  width='25%'>
								<!--<input type ='text' name = 'other_alt_Id_no' value="" size='25' maxlength='20' disabled onKeyPress="return CheckForSpecChars(event)">-->
								<input type ='text' name = 'other_alt_Id_no' value="" size='25' maxlength='20' disabled>
								
								</td>
							<%}%>
					</tr>
<!-- Name part -->
<!-- Modified onBlur='makeValidString(this)' for the incident IN031010 by Shanthi on 8-3-2012 -->
				<tr>
						<%
							if(pat_name_as_multipart_yn.equals("Y")){  
									
                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                                        out.println("<td   width='25%' class='label'>" + First_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'></td>");
										firstRowElement="Y";
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                                        out.println("<td  width='25%' class='label'>" + Second_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields' ><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										firstRowElement="Y";
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 ) {
                                        out.println("<td   width='25%' class='label'>" + Third_Name_Prompt + "</td>");
                                        out.println("<td    width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='15' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										firstRowElement="Y";
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
									
                                        out.println("<td   width='25%' class='label'>" + Family_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\">");
										firstRowElement="Y";

										 /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299*/
						  if (First_Name_Accept_Yn.equals("N") && Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") && Family_Name_Accept_Yn.equals("Y") ){

											fam_name_ind ="Y";
											//String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By'><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
								}
                                    }
                                   

                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='First_Name' id='First_Name' >");
                                }
                                else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='Second_Name' id='Second_Name' >");
                                }
                                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='Third_Name' id='Third_Name' >");
                                }
                                else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='Family_Name' id='Family_Name' >");
                                    }
									 if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                                        out.println("<td  width='25%' class='label'>" + First_Name_Prompt + "</td>");
                                        out.println("<td  width='25%' class='fields' ><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                                        out.println("<td  width='25%' class='label'>" + Second_Name_Prompt + "</td>");
                                        out.println("<td  width='25%' class='fields' ><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 ) {
                                        out.println("<td  width='25%' class='label'>" + Third_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
                                        out.println("<td   width='25%' class='label'>" + Family_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\">");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}

										 /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299*/
						  if (First_Name_Accept_Yn.equals("N") && Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") && Family_Name_Accept_Yn.equals("Y") ){

											fam_name_ind ="Y";
											//String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By'><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
								}
                                    }
                                   

									if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   width='25%' class='label'>" + First_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
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
                                        out.println("<td  width='25%'  class='label'>" + Second_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
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
                                        out.println("<td  width='25%' class='label'>" + Third_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
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
                                        out.println("<td   width='25%' class='label'>" + Family_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}

										 /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299*/
						  if (First_Name_Accept_Yn.equals("N") && Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") && Family_Name_Accept_Yn.equals("Y") ){

											fam_name_ind ="Y";
											//String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By'><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
								}
                                    }
                         
                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='25%' class='label'>" + First_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields' ><input type='text' name='First_Name' id='First_Name' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='25%' class='label'>" + Second_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='Second_Name' id='Second_Name' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='25%' class='label'>" + Third_Name_Prompt + "</td>");
                                        out.println("<td   width='25%' class='fields'><input type='text' name='Third_Name' id='Third_Name' size='25' maxlength='"+third_name_length+"'	onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
                                    }
                                   else
									  if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4) {
									   if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   width='25%' class='label'>" + Family_Name_Prompt + "</td>");
                                        out.println("<td  width='25%' class='fields'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
										
								    /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299*/
						  if (First_Name_Accept_Yn.equals("N") && Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") && Family_Name_Accept_Yn.equals("Y") ){

											fam_name_ind ="Y";
											//String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By'><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
								}

								   }
								      else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }

                                     
								}
								
								if (pat_name_as_multipart_yn.equals("N"))	
								{			out.println("<td nowrap  width='25%' class='label'>" + Family_Name_Prompt + "</td>");
											out.println("<td  nowrap class='fields' width='25%'><input type='text' name='Family_Name' id='Family_Name' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);EnableSearchBy(this);'     style=\"text-align:left\">");
											//String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By'><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
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
							     <input type="hidden" name="First_Name" id="First_Name">
								 <input type="hidden" name="Second_Name" id="Second_Name">
								 <input type="hidden" name="Third_Name" id="Third_Name">
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
                                        out.println("<td   class='label' width='25%'>" + First_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields' ><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='25%'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

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
										 out.println("<input type='hidden' name='first_name_loc_lang' id='first_name_loc_lang' >");
									}
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                                        out.println("<td   class='label' width='25%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                     //   out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");

									  out.println("<td   class='fields' width='25%'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

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
                                        out.println("<td   class='label' width='25%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='25%'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

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
									
                                        out.println("<td   class='label' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									  out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

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
                                    out.println("<input type='hidden' name='first_name_loc_lang' id='first_name_loc_lang' >");
                                }else if( First_Name_Accept_Yn.equals("N") && First_Name_Order ==0)
								{
									 out.println("<input type='hidden' name='first_name_loc_lang' id='first_name_loc_lang' >");
								}
                                else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='second_name_loc_lang' id='second_name_loc_lang'>");
                                }
                                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='third_name_loc_lang' id='third_name_loc_lang' >");
                                }
                                else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='family_name_loc_lang' id='family_name_loc_lang' >");
                                    }
									 if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                                        out.println("<td   class='label' width='25%'>" + First_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='25%'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

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
										//out.println("Second");
                                        out.println("<td   class='label' width='25%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='25%'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

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
                                        out.println("<td   class='label' width='25%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");

                                        out.println("<td   class='fields' width='25%'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

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
                                        out.println("<td   class='label' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                      
										out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

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
                                        out.println("<td   class='label' width='25%'>" + First_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                        
										out.println("<td   class='fields' width='25%'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

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
                                        out.println("<td   class='label' width='25%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='25%'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

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
                                        out.println("<td   class='label' width='25%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                     //   out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

                                        out.println("<td   class='fields' width='25%'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

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
                                        out.println("<td   class='label' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                     
										out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

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
                                        out.println("<td   class='label' width='25%'>" + First_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='25%'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

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
                                        out.println("<td   class='label' width='25%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                        
										out.println("<td   class='fields' width='25%'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

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
                                        out.println("<td   class='label' width='25%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"'	onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                      
										out.println("<td   class='fields' width='25%'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='25' maxlength='"+third_name_length+"'	onBlur='makeValidString(this)' ");

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
                                        out.println("<td    class='label' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\">");
                                        out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

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
											 out.println("<td nowrap   class='label' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
											out.println("<td  nowrap   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);EnableSearchBy(this);'style=\"text-align:left\">");
//											String selects1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By_Lang' id='Search_By_Lang' disabled><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
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
										
									  %>
                               
                          <!-- <%if(pat_name_as_multipart_yn.equals("Y")){  }%> -->
                           
								<%
                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                                        out.println("<td   class='arabic' width='25%'>" + First_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='25%'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										//firstRowElement="Y";
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                                        out.println("<td   class='arabic' width='25%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                        
										out.println("<td   class='fields' width='25%'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										//firstRowElement="Y";
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2) {
                                        out.println("<td   class='arabic' width='25%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"'	onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                      
										out.println("<td   class='fields' width='25%'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='25' maxlength='"+third_name_length+"'	onBlur='makeValidString(this)' ");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									   out.println("></td>");
									   //firstRowElement="Y";
                                    }
                                   else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2) {
                                        out.println("<td    class='arabic' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\">");
                                        out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");
									// firstRowElement="Y";
										
								   }else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }


									if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                                        out.println("<td   class='arabic' width='25%'>" + First_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                        
										out.println("<td   class='fields' width='25%'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

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
                                        out.println("<td   class='arabic' width='25%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='25%'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

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
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 ) {
                                        out.println("<td   class='arabic' width='25%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                     //   out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

                                        out.println("<td   class='fields' width='25%'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

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
                                        out.println("<td   class='arabic' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                     
										out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

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
                                    }else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }
									%></tr><tr><%
									
									if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
										/*
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='25%'>" + First_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='25%'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

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
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
										/*
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/

                                        out.println("<td   class='arabic' width='25%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='25%'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

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
										/*
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='25%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");

                                        out.println("<td   class='fields' width='25%'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

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
										/*
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                      
										out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

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
                                    }else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }


                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
										/*
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='25%'>" + First_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields' ><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='25%'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)' ");

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
										/*
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='25%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                     //   out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");

									  out.println("<td   class='fields' width='25%'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

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
										/*
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										} */
                                        out.println("<td   class='arabic' width='25%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='25%'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

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
										/*
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
									
                                        out.println("<td   class='arabic' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									  out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

									  if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
                                    }else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }
                                   %></tr><%

                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='first_name_loc_lang' id='first_name_loc_lang' >");
                                }else if( First_Name_Accept_Yn.equals("N") && First_Name_Order ==0)
								{
									 out.println("<input type='hidden' name='first_name_loc_lang' id='first_name_loc_lang' >");
								}
                                else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='second_name_loc_lang' id='second_name_loc_lang'>");
                                }
                                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='third_name_loc_lang' id='third_name_loc_lang' >");
                                }
                                else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='family_name_loc_lang' id='family_name_loc_lang' >");
                                    }


									
                              
						  }
										if (pat_name_as_multipart_yn.equals("N"))	
										{
											 out.println("<td    class='arabic' width='25%'>" + Family_Name_loc_lang_Prompt + "</td>");
											out.println("<td   class='fields' width='25%'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);EnableSearchBy(this);'   dir='RTL' >");
//											String selects1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By_Lang' id='Search_By_Lang' ><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
							
										}

										out.println("</td>");

										/**** End of Arabic changes ****/

						}
						} %>
				</tr>
				


			<tr>
							<%if(pat_name_as_multipart_yn.equals("N")){%>
									<td  width='25%' class="label"></td>
									<td  width='25%' class="label"><input type="hidden" name="Soundex" id="Soundex" value=''></td>
								
								<%}else{%>
									
								<td  width='25%' class="label"><fmt:message key="Common.soundex.label" bundle="${common_labels}"/></td>

                                <td  width='25%' class="fields" ><Select name="Soundex" id="Soundex"  onChange="EnableFamSearch(this);"  ><%%>
								<Option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----<Option value="E"><fmt:message key="Common.Ethnic.label" bundle="${common_labels}"/><Option value="G"><fmt:message key="Common.generic.label" bundle="${common_labels}"/></Select></td>
							<%}%>

								<td  width='25%' class="label"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>

								<td  width='25%' class="fields"><Select name="Sex" id="Sex" <%=dis%> ><Option value="" >----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----<Option value="A" ><fmt:message key="Common.all.label" bundle="${common_labels}"/><Option value="M" <%=selm%>><fmt:message key="Common.male.label" bundle="${common_labels}"/></option><Option value="F" <%=self%>><fmt:message key="Common.female.label" bundle="${common_labels}"/></option><option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option></Select>
								</td>
					 </tr>

				<tr>
							
								
							<td  width='25%' class="label"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/> </td>
							
							<td  width='25%' class="fields"><input type="text" name="Dob" id="Dob" size="11"  onBlur="validDateObj(this,'DMY',localeName)" maxlength="10" ><img style="cursor='hand'" id='dobCal' name='dobCal' src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].Dob.select(); return showCalendar('Dob',null,null,true);" >
								
							&nbsp;&nbsp;<Select name="By" id="By" ><Option value="D" Selected><fmt:message key="Common.date.label" bundle="${common_labels}"/><Option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/></Select></td> 
					
					<%if(Family_No_Link_Yn.equals("Y")) {%>
								
							<td  align='25%'   class="label" ><fmt:message key="eMP.HeadPatientID.label" bundle="${mp_labels}"/></td>

							<td align='25%'   class="fields" ><input type="text" name="Family_No" id="Family_No" size="25" maxlength="<%=patient_id_length%>" onblur='ChangeCase(this);' ></td> 
					<%} else {%>
								
							<td align='right'   class="fields"><input type="hidden" name="Family_No" id="Family_No" size="25" maxlength=""  ></td> 
					<%}%>


					</tr>
					
					<tr>	

							<td  width='25%' class="label"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>

                            <td  width='25%' class="fields"><input type='text' name="nationality_desc" id="nationality_desc" size='22' maxlength='30' onblur='getNationality(this);'><input type='hidden' name='Nationality' id='Nationality' value=''><input type='button' class='button' Value='?' name='natCode' id='natCode' onClick='getNationality(this);'>
								<input type='hidden' name='nationality_desc_hid' id='nationality_desc_hid' value=''>								<input type='hidden' name='Nationality_hid' id='Nationality_hid' value=''></TD>

							<td  width='25%' class="label"><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>

                            <td  width='25%' class="fields" ><input type='text' name='ethnic_group_desc' id='ethnic_group_desc' value='' size='22' maxlength='30'   onblur='getRace(this);'><input type='button' class='button' name='raceBt' id='raceBt' value='?' onclick='getRace(this);'   ><input type='hidden' name="ethnic_group" id="ethnic_group"   value=''>
							<input type='hidden' name='ethnic_group_desc_hid' id='ethnic_group_desc_hid' value=''>									<input type='hidden' name='ethnic_group_hid' id='ethnic_group_hid' value=''>
							</td>	

							
								
								
				</tr>
					
					<tr>
					    

								<td align='25%'   class="label"><fmt:message key="Common.area.label" bundle="${common_labels}"/></td>

                                <td align='25%'   class="fields"><input type='hidden' name="Area" id="Area" value=''><input type='text' name='area_desc' id='area_desc' size='22' value=''    onBlur='getArea(this);'><input type='button' class='button' value='?' onClick='getArea(this);'  ></td>  

								<input type='hidden' name='area_desc_hid' id='area_desc_hid' value=''>										<input type='hidden' name='Area_hid' id='Area_hid' value=''>


								<td align='25%'   class="label"><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></td>
								<td class="fields">
							   <select name='patient_series' id='patient_series' > 
                                <option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
						     <%
				             	pstmt1 = con.prepareStatement(Qry_For_PatSeries);
								pstmt1.setString(1,locale);
							   rs1= pstmt1.executeQuery();
					          while(rs1.next())
					          {	
								pat_ser_grp_code=rs1.getString("pat_ser_grp_code");
								pat_ser_grp_desc=rs1.getString("short_desc");
								out.println( "<option value='"+pat_ser_grp_code+"' >"+pat_ser_grp_desc) ;
						      }
				       
						 
					    
	                   %>  
								
							</select>
                        </td>
					</tr>	
						 <%--<%//if (dr_install_yn.equals("Y")){    
                             /*
							 if (function_id.equals("") || function_id.equals("PAT_REG") || function_id.equals("NEWBORN_REG") ||
											func_act.equals("DuplicateRegistration"))
                                                sel2 = "selected";
                                            else
                                                sel1 = "selected";
                         */
                             ///if( First_Name_Accept_Yn.equals("N"))       out.println("<input type='hidden' name='First_Name' id='First_Name' value=''>");
                            // if( Second_Name_Accept_Yn.equals("N"))  out.println("<input type='hidden' name='Second_Name' id='Second_Name' value=''>");
                             //if( Third_Name_Accept_Yn.equals("N"))       out.println("<input type='hidden' name='Third_Name' id='Third_Name' value=''>");
                            // if( Family_Name_Accept_Yn.equals("N"))  out.println("<input type='hidden' name='Family_Name' id='Family_Name' value=''>");
                          %>
                          <% //} --%>
						<%if(family_org_id_accept_yn.equals("Y")){%>	
							<tr>	
							<td  class="label" width='25%' ><fmt:message key="eMP.membership.label" bundle="${mp_labels}"/></td>

							<td  class="fields" width='25%' id='mem_type' >
							<SELECT name="family_org_membership" id="family_org_membership" onchange="">
							<option selected value ="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- </option>
							<option value ="1"><fmt:message key="eMP.organizationmember.label" bundle="${mp_labels}"/></option>
							<option value ="2"><fmt:message key="eMP.relatedmemberfamily.label" bundle="${mp_labels}"/></option>
							<option value ="3"><fmt:message key="eMP.relatedmembernonfamily.label" bundle="${mp_labels}"/></option>
							<option value ="4"><fmt:message key="eMP.nonorganizationmember.label" bundle="${mp_labels}"/></option>
							</SELECT></TD>

						<%}else{%>

							<td  class="label" width='25%' colspan='2'>&nbsp;</td>

						<%}%>
					</tr>
			    <tr>
				
									
					<%if(family_org_id_accept_yn.equals("Y")){%>
						
						<td  class="label" width='25%' ><fmt:message key="Common.Organization.label" bundle="${common_labels}"/></td>
						
						<td  class="fields" width='25%'><input type='text' name='organization' id='organization'  size='22' maxlength='30' onBlur='get_org_sub_org_blur(organization,sub_org_desc,this);'  tabindex=23><input type='hidden' name='org_id' id='org_id' value=''><input type='button' class='Button' value='?' onclick='get_org_sub_org(organization,sub_organization,this)'>
						<input type='hidden' name='organization_hid' id='organization_hid' value=''>

						<td  class="label" width='25%'><fmt:message key="eMP.suborgn.label" bundle="${mp_labels}"/></td>

						<td class="fields" width='25%'><input type='text' name='sub_org_desc' id='sub_org_desc' size='22' onBlur='get_sub_org_blur(sub_org_desc);' tabindex='23'><input type='hidden' name='sub_organization' id='sub_organization'value=''><input type='button' class='Button' id='sub_org_id_btn' value='?' onclick='get_sub_org(sub_org_desc)'>
				        </td> 

						<!--	 
						 <td  class="fields" width='25%'><SELECT name="sub_organization" id="sub_organization" onblur="moveFocustoAddl();" tabindex=23>
						<option selected disabled value =""> --------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
						</SELECT>
				        </td>
						-->
					<%}else{%>
						<td colspan=2>&nbsp;</td>
					<%}%>					
			</tr>
			<tr >
                                <td  class="label" width="25%"><fmt:message key="Common.contactNo.label" bundle="${common_labels}"/></td>
								<!--Added smart_contact_no by Ashwin K for AAKH-CRF-0150 -->
                                <td  class="fields" width="25%"><input type="text" name="Contact_No" id="Contact_No" size="25" maxlength="20" onBlur="makeValidQueryCriteria(this);MoveFocus(3)" value="<%=smart_contact_no%>" tabindex=26>
								 &nbsp;

								 <!--Added  by Ashwin K for AAKH-CRF-0150 --><!--"05" Added  by santhosh for TH-KW-CRF-0019.1 -->
								 <%if(function_name.equals("01") || function_name.equals("05")){%> 
										<select name="contact_search_by" id="contact_search_by">
											<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
											<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
											<option value="C" selected><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
										</select>
										<%}%>
								<!--Ended by Ashwin K for AAKH-CRF-0150 -->
								</td>
                               
								<td  class="label" width="25%"><fmt:message key="Common.mode.label" bundle="${common_labels}"/></td>
                                <td class="fields" width="25%"><Select name="Mode" id="Mode" onFocus="MoveFocus(3)" tabindex=27 disabled><Option value="" selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
                                <%
								
                                try{
                                    pstmt = con.prepareStatement(Qry_For_CntMode);
									pstmt.setString(1,locale);
                                    rs = pstmt.executeQuery();
                                        if(rs != null)
                                            while(rs.next()) {
                                                String Contact_Mode = rs.getString("contact_mode");
                                                String short_desc=rs.getString("short_desc");
                                                out.println("<Option value='" + Contact_Mode + "'>" + short_desc);
                                            }
                                }catch(Exception e) { out.println(e.toString());}
                                finally
                                {
                                    if (pstmt != null) pstmt.close();
                                    if (rs != null) rs.close();
                                }
                                %>
								<!-- Below line added for this CRF  PMG2013-MMS-CRF-0004 [IN:045277] -->
								<option value='NHPN'><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/>  <fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></option>
								<option value='NMPN'><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/>  <fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></option>
								<option value='NOPN'><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/>  <fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></option>								
								<option value='FHPN'><fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/>  <fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></option>
								<option value='FMPN'><fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/>  <fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></option>
								<option value='FOPN'><fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/>  <fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></option>								
								<option value='EHPN'><fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/>  <fmt:message key="Common.homephoneno.label" bundle="${common_labels}"/></option>
								<option value='EOPN'><fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/>  <fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></option>
								<!-- End this CRF  PMG2013-MMS-CRF-0004 [IN:045277] -->
								</Select></td>  
							</tr>  
		
			<tr>
						<td   class="label" width='25%'><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
                        
						<td    class="fields" width='25%'><Select name="order_by" id="order_by" onBlur='moveFocustoAddl();' >
						<OPTION value='X'>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----
						<%
                                try
                                {
									
                                    pstmt = con.prepareStatement(Qry_for_OrderBy);
									pstmt.setString(1,locale);
                                    rs = pstmt.executeQuery();
                                        if(rs != null)
                                            while(rs.next()) 
                                            {
                                                if(!rs.getString(1).equals("Pat_Photo")) 
                                                {
                                                    String order_field_code = rs.getString("field_name");
                                                    String order_field_desc =rs.getString("field_desc");
                                                    out.println("<Option value='" + order_field_code + "'>" + order_field_desc);
                                                }
                                            }
                                }
                                catch(Exception e) { out.println(e.toString());}
                                %>
                                </select>
                        </td> 
						<td   class="label" width='25%' style="display:None"><fmt:message key="Common.searchIn.label" bundle="${common_labels}"/></td>
						
						<td   class="fields" width='25%' style="display:None" ><Select name="search_in" id="search_in"  disabled <%=sdisable%>>
							<Option value="P" selected ><fmt:message key="eMP.PatientMaster.label" bundle="${mp_labels}"/>
							<Option value="B" ><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
							<Option value="D"><fmt:message key="eMP.DuplicateMaster.label" bundle="${mp_labels}"/>
							</Select></td> 
							<td>&nbsp;</td><td><input type='button' class='BUTTON' name='Moreless' id='Moreless' title= 'Moreless' align='right' value='<fmt:message key="Common.morecriteria.label" bundle="${common_labels}"/>' onClick="parent.Pat_Search_Criteria_Frame.MoreLess();"></td>
				</tr>



								<tbody id="rowExpansion" style="display:none">
                                
							<tr>
<%--

								<td  class="label" width="25%"><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/> </td>
								<td class="fields" width="25%" >
									<select name='sltDocType' id='sltDocType'
									onChange="enableDocType()" tabindex=28">
										<option>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
							<%
							try{
									pstmt = con.prepareStatement(Qry_For_Doctype);
                                    rs = pstmt.executeQuery();
									if(rs != null)
									{
                                           while(rs.next())
											{
                               %>
										<option value='<%=rs.getString("doc_type")%>'><%=rs.getString("short_desc")%></option>
								<%   
                                            }
									}
								}catch(Exception e) { out.println(e.toString());}
                                finally
                                {
                                    if (pstmt != null) pstmt.close();
                                    if (rs != null) rs.close();
                                }
							%>
							
								</select>
								<input type='text' name='txtDocType' id='txtDocType' disabled tabindex=29 maxlength=15 size='15'></td>
--%>
								<td  class="label" width="25%"><fmt:message key="eMP.Deceasedonly.label" bundle="${mp_labels}"/></td>
                               <td class="fields" width="25%">
							<%if(func_act.equals("MO")){%>
							   <input type="checkbox" name="deceased_yn" id="deceased_yn" checked tabindex=30 value='Y'></td> 
							   <%}else{%>
								<input type="checkbox" name="deceased_yn" id="deceased_yn" tabindex=30 value="N"  ></td><%}%> 

								<% if(!addl_field1_prompt.equals(""))
                               {%>
                                <td  class="label" width="25%"><%=addl_field1_prompt%></td>
                                <td class="fields" width="25%"><input type="text" name="addl_field1" id="addl_field1" size='25' maxlength='<%=addl_field1_length%>' onBlur='makeValidString(this)' tabindex=33></td>
                             <%}
                               else 
                               {%>
                                <td >&nbsp;<input type='hidden' name="addl_field1" id="addl_field1"></td>
								 <td >&nbsp;</td>
								 <%}%>
								  
							</tr>


                            <tr>
                              <td  class="label" width="25%"><fmt:message key="eMP.Suspendedonly.label" bundle="${mp_labels}"/></td>
                               <td class="fields" width="25%"><input type="checkbox" value="N" name="suspend_yn" id="suspend_yn" tabindex=31 ></td>   
                                              
                            <% if (!addl_field2_prompt.equals(""))
                               {%>
                                <td  class="label" width="25%"><%=addl_field2_prompt%></td>
                                <td class="fields" width="25%"><input type="text" name="addl_field2" id="addl_field2" size='25' maxlength='<%=addl_field2_length%>' onBlur='makeValidString(this)' tabindex=34></td>
                             <%}
                               else 
                               {%>
                                <td>&nbsp;<input type='hidden' name="addl_field2" id="addl_field2"></td>
								    <td >&nbsp;</td>
                             <%}%> 
							
							 </tr>
							 <tr>
                               <td  align='right' class="label"><fmt:message key="eMP.Inactiveonly.label" bundle="${mp_labels}"/></td>
                               <td class="fields" width="25%"><input type="checkbox" name="active_yn" id="active_yn" onBlur='moveFocustoGeneral(this)' value="N" tabindex=32 ></td>   
                             
							   <% if (!addl_field3_prompt.equals(""))
                               {%>
                                <td  class="label" width="25%"><%=addl_field3_prompt%></td>
                                <td class="fields" width="25%"><input type="text" name="addl_field3" id="addl_field3" size='25' maxlength='<%=addl_field3_length%>' onBlur='makeValidString(this)' tabindex=35></td>
                             <%}
                               else 
                               {%>
                                <td >&nbsp;<input type='hidden' name="addl_field3" id="addl_field3"></td>
								    <td >&nbsp;</td>
                             <%}%>	
							</tr>	

							<tr>
                             <td  class="label" width="25%"><fmt:message key="eMP.mothername.label" bundle="${mp_labels}"/></td>
							<td class="fields" width="25%"><input type='text' name='mother_maiden_name' id='mother_maiden_name' size='25' maxlength='80' onBlur='makeValidString(this)' tabindex=35></td>
                              <% if (!addl_field4_prompt.equals(""))
                               {%>
								
                                <td  class="label" width="25%"><%=addl_field4_prompt%></td>
                                <td class="fields" width="25%"><input type="text" name="addl_field4" id="addl_field4" size='25' onBlur='makeValidString(this);moveFocustoGeneral(this)' maxlength='<%=addl_field4_length%>' tabindex=36></td>
                             <%}
                               else 
                               {%>
                                <input type='hidden' name="addl_field4" id="addl_field4">
								    <td >&nbsp;</td>
								    <td >&nbsp;</td>
                             <%}%>
                           
                            </tr>   

                            <tr>
						 <td class="label"><fmt:message key="eMP.RegistrationMode.label" bundle="${mp_labels}"/></td>
						   <td class="fields" colspan='1'><SELECT name="reg_mode" id="reg_mode">
						   <option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						   <option value='N'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
						   <option value='Y'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
						   <option value='R'><fmt:message key="eMP.Rapid.label" bundle="${mp_labels}"/></option>
						   </SELECT></td>
                            <% if (!addl_field5_prompt.equals(""))
                               {%>
								
                                <td  class="label" width="25%"><%=addl_field5_prompt%></td>
                                <td class="fields" width="25%"><input type="text" name="addl_field5" id="addl_field5" size='<%=addl_field5_length%>' onBlur='makeValidString(this);moveFocustoGeneral(this)' maxlength='<%=addl_field5_length%>' tabindex=37></td>
                             <%}
                               else 
                               {%>
                               <td   class="label" width="25%"><input type='hidden' name="addl_field5" id="addl_field5"></td>
								    <td >&nbsp;</td>
                             <%}%>
                           </tr>  
			   	<tr>
					<td   width="25%" class="label" ><fmt:message key="eMP.OldFileNo.label" bundle="${mp_labels}"/></td>
					<td class="fields" width="25%" ><input type="text" name="OldFileNo" id="OldFileNo" size="20" maxlength="20" onKeyPress="return allowAlphaNumeric(event)" onBlur='makeValidString(this);ChangeCase(this)' tabindex=25 <%=docDisableField%>></td>					
				<%if (!file_type_appl_yn.equals("Y")){%>
					<td   width="25%" class="label"><fmt:message key="Common.PatientFileNo.label" bundle="${common_labels}"/></td>
					<td class="fields" width="25%" ><input type="text" name="MRN" id="MRN" size="20%" maxlength="<%=patient_id_length%>" onKeyPress="return allowAlphaNumeric(event)" onBlur='makeValidString(this);ChangeCase(this)' tabindex=24  <%=docDisableField%>></td>
				<%}else{%>
						<td colspan='2' class="label" width="50%"></td>
				<%}%>
				</tr>
				<tr>
					<td   width="25%" class="label" ><fmt:message key="eMP.CurrentPatientClass.label" bundle="${mp_labels}"/></td>
					<td class="fields" width="25%" colspan='3'><input type="checkbox" name="IP_yn" id="IP_yn" value='IP'><fmt:message key="Common.IP.label" bundle="${common_labels}"/>&nbsp;<input type="checkbox" name="DC_yn" id="DC_yn" value='DC'><fmt:message key="Common.DC.label" bundle="${common_labels}"/>&nbsp;<input type="checkbox" name="OP_yn" id="OP_yn" value='OP'><fmt:message key="Common.OP.label" bundle="${common_labels}"/>&nbsp;<input type="checkbox" name="EM_yn" id="EM_yn" value='EM' onblur='movefocusout(this)'><fmt:message key="eMP.EM.label" bundle="${mp_labels}"/></td>
					<td colspan=2></td>
				</tr>
				</tbody>
				
				  </table>
                    </td>
                </tr>							 
			
		 </table>
        </center>
   </table>

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
    <input type="hidden" name="1" id="1" value="">
    <input type="hidden" name="FULLSQL" id="FULLSQL" value="">
    <input type="hidden" name="ORDERBY" id="ORDERBY" value="">
    <input type="hidden" name="jsp_name" id="jsp_name" value="<%=jsp_name%>">
    <input type="hidden" name="window_styl" id="window_styl" value="<%=window_styl%>">
    <input type="hidden" name="close_yn" id="close_yn" value="<%=close_yn%>">
    <input type="hidden" name="register_button_yn" id="register_button_yn" value="<%=register_button_yn%>">
    <input type="hidden" name="func_act" id="func_act" value="<%=func_act%>">
    <input type="hidden" name="soundex_dflt" id="soundex_dflt" value="<%=Soundex%>">
    <input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
	<input type='hidden' name='alt_id1_accept_alphanumeric' id='alt_id1_accept_alphanumeric' value="<%=alt_id1_accept_alphanumeric_yn%>">
   	<input type="hidden" name="names_in_oth_lang_yn_hd" id="names_in_oth_lang_yn_hd" value="<%=names_in_oth_lang_yn%>">
   	<input type="hidden" name="pat_name_as_multipart_yn_hd" id="pat_name_as_multipart_yn_hd" value="<%=pat_name_as_multipart_yn%>">
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
   	<input type="hidden" name="cntPrefFac" id="cntPrefFac" value="<%=cntPrefFac%>">
   	<input type="hidden" name="allow_nb_review" id="allow_nb_review" value="<%=review_nb_links_bef_reg_yn%>">
   	<input type="hidden" name="patient_id_length" id="patient_id_length" value="<%=patient_id_length%>">
	<!--for smart card-->
	<input type="hidden" name="txtSmartcard_path" id="txtSmartcard_path" value="<%=Smartcard_path%>">
	<!--for Alkhaleej smart card-->
	<input type="hidden" name="txtSmart_fn_name" id="txtSmart_fn_name" value="<%=function_name%>">
	<input type="hidden" name="nat_id_prompt" id="nat_id_prompt" value="<%=nat_id_prompt%>">
	<input type="hidden" name="nat_id_accept_alphanumeric_yn" id="nat_id_accept_alphanumeric_yn" value="<%=nat_id_accept_alphanumeric_yn%>">
	<input type="hidden" name="name_dervn_logic" id="name_dervn_logic" value="<%=name_dervn_logic%>">
	<input type="hidden" name="txtSmartcard_dup" id="txtSmartcard_dup" value="">
	<input type="hidden" name="alert_reqd_yn" id="alert_reqd_yn" value="">
	<input type='hidden' name='isAlternateAddressAppl' id='isAlternateAddressAppl' value="<%=isAlternateAddressAppl%>"><!--Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601-->
	<input type='hidden' name='isAddressLengthIncAppl' id='isAddressLengthIncAppl' value="<%=isAddressLengthIncAppl%>"><!--Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0860.2-->
	
	<!--for smart card-->
	<!--Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]-->
	<input type="hidden" name="alt_id1_pat_sch_exact_yn" id="alt_id1_pat_sch_exact_yn" value="<%=alt_id1_pat_sch_exact_yn%>">
	<input type="hidden" name="alt_id2_pat_sch_exact_yn" id="alt_id2_pat_sch_exact_yn" value="<%=alt_id2_pat_sch_exact_yn%>">
	<input type="hidden" name="alt_id3_pat_sch_exact_yn" id="alt_id3_pat_sch_exact_yn" value="<%=alt_id3_pat_sch_exact_yn%>">
	<input type="hidden" name="alt_id4_pat_sch_exact_yn" id="alt_id4_pat_sch_exact_yn" value="<%=alt_id4_pat_sch_exact_yn%>">
	<!--Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]-->
	  <!--Below line added for this CRF HSA-CRF-0289 -->	
	  <input type="hidden" name="alterIdSearch" id="alterIdSearch" value="<%=alterIdSearch%>">
	  <input type="hidden" name="isAlternateId" id="isAlternateId" value="<%=isAlternateId%>">
	  <input type="hidden" name="alternate_no" id="alternate_no" value="<%=alternate_no%>">

	   <input type="hidden" name="fam_name_ind" id="fam_name_ind" value="<%=fam_name_ind%>">
	    <input type="hidden" name="isInsuranceCardReader" id="isInsuranceCardReader" value="<%=isInsuranceCardReader%>"><!--Added by kamatchi S for MOHE-CRF-0016.1 ON 28-AUG-2020-->
		<!--//Added by Maheshwaran K for AAKH-CRF-0168-->
		<input type="hidden" name="dft_national_id" id="dft_national_id" value="<%=dft_national_id%>">
				<!--//Added by Maheshwaran K for AAKH-CRF-0175-->
		<input type="hidden" name="biometric_authentication_yn" id="biometric_authentication_yn" value="<%=biometric_authentication_yn%>">
	 <!--Added by Rameswar on  19-04-2016 for HSA-CRF-0299-->
	    <input type="hidden" name="suspend_inactive_pat_yn" id="suspend_inactive_pat_yn" value="<%=suspend_inactive_pat_yn%>">
		 <input type="hidden" name="ndhm_appl_YN" id="ndhm_appl_YN" value="<%=ndhm_appl_YN%>"><!-- //Maheshwaran K added for GHL-CRF-0657.2 as 06-09-2923-->
		
   </form>
    <!--<script>setTimeout('FocusFirstElement()',500)</script>-->
	<script>
	if('<%=alterIdSearch%>'!=""&&'<%=isAlternateId%>'=="true"){ 
	     setTimeout("AlternateIdFocus('<%=alterIdSearch%>','<%=isAlternateId%>','<%=alternate_no%>')",500)
	}else{ 
	     setTimeout('FocusFirstElement()',500)
	}
	</script>
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
/*Added by lakshmanan on nov 03 2022 against GHL-CRF-0657.1*/
	public static String getNDHMApplicable(Connection con){
		String sqlNDHMApplicable="SELECT count(*) FROM XH_STANDARD_PROFILE WHERE PROFILE_ID LIKE '%NDHMPROF1%' and NVL(EFF_STATUS,'Y') = 'Y' AND ROWNUM = 1  ";
		int count=0;
		String ndhmYN="N";
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		try{
			pstmt=con.prepareStatement(sqlNDHMApplicable);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
			if(count > 0){
				ndhmYN="Y";
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return ndhmYN;
	}
%>


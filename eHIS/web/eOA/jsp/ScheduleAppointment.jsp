<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8"         import="java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<html>
<head>     
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css' </link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eOA/js/Validate.js" language="JavaScript"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'> </script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	var NamePrefixArray = new Array(); 
	var NamePrefixLocArray = new Array();
	var PrefixSexArray = new Array();	
	var NameSuffixArray = new Array();	
	var NameSuffixLocArray = new Array();	
	var SuffixSexArray = new Array();	
</script>
</head>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
	//String or_operational="N";
	String order_id=request.getParameter("order_id");	
	if(order_id ==null) order_id="";
	String order_line_num=request.getParameter("order_line_num");
	if(order_line_num ==null) order_line_num="";
	String quer_date_end_param=request.getParameter("quer_date_end");
	if(quer_date_end_param ==null) quer_date_end_param ="";
	String order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
	String order_category=request.getParameter("order_category")==null?"":request.getParameter("order_category");
	String specialty_codema1=request.getParameter("specialty_codema")==null?"":request.getParameter("specialty_codema");	
	String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");	
	if(rd_appt_yn.equals(""))rd_appt_yn="N";
	String disRdApp ="";
	//String specialty_codenew=request.getParameter("specialty_code");
	String callingMode = request.getParameter("callingMode");
	if(callingMode==null) callingMode="";
	session.putValue("callingMode_new",callingMode);
	String apptrefno = request.getParameter("apptrefno");
	if(apptrefno == null) apptrefno ="";
	if(callingMode.equals("RSCAPPT")){
		session.putValue("apptrefno",apptrefno);
	}else{
		session.removeAttribute("apptrefno");
	}
	String module_id = request.getParameter("module_id");
	if(module_id == null) module_id ="";
	String from_AE=request.getParameter("from_AE");
	if(from_AE==null) from_AE="N";		
	String op_practitioner = request.getParameter("practitioner_id");
	String web_request_yn = request.getParameter("web_request_yn")==null?"N":request.getParameter("web_request_yn");
	if (op_practitioner==null) op_practitioner="";
	String speclty_Cd="";
	String disablePract = "";
	String code_val="";
	String from_wait_list=request.getParameter("from_wait_list");
	if(from_wait_list==null) from_wait_list="N";
	String waitListNo=request.getParameter("waitListNo");
	if(waitListNo==null) waitListNo="";
	String care_locn_ind=request.getParameter("care_locn_ind");
	String from_page=request.getParameter("from_page")	;
	if(from_page==null) from_page="";

	String resource_class=request.getParameter("resource_class");
	if(care_locn_ind==null) care_locn_ind="";
	String visit_flag_OP=request.getParameter("visit_flag_OP");
	if(visit_flag_OP==null) visit_flag_OP="N";	
	if(module_id.equals("CA")){
		care_locn_ind ="";
	}
	//out.println("<script>alert('from_wait_list :"+from_wait_list+"')</script>");
	//out.println("<script>alert('waitListNo :"+waitListNo+"')</script>");
	if(resource_class==null) resource_class="";
	String ca_mode="";
	String is_ca=request.getParameter("CA");
	String direct_ip=request.getParameter("DirectIP");
	if(direct_ip==null) direct_ip="N";
	String direct_ip_practid= request.getParameter("i_practitioner_id");
	if(direct_ip_practid==null) direct_ip_practid="";
	
	String customer_id=(String)session.getValue("CUSTOMER_ID");
	
String primary_resource_class=""; //Added By Saanthaakumar Against CRF 34318	Bru-HIMS-CRF-0135
// Added by Jithesh on 18-Nov-03 to handle from  CA
	if(is_ca!=null && is_ca.equals("Y")){
		ca_mode="ca_mode";
		session.putValue("ca_mode","Y");
	}else{
		session.putValue("ca_mode","N");
	}
	if(from_wait_list.equals("Y")){
		ca_mode="ca_mode";
		session.putValue("ca_mode","Y");
		session.putValue("from_wait_list","Y");
		session.putValue("waitListNo",waitListNo);
	}else{
		session.putValue("from_wait_list","N");
	}
	String from_OR=request.getParameter("from_OR");
	if(from_OR ==null) from_OR="N";
	String ca_patient_id=request.getParameter("patient_id");
	if(ca_patient_id==null) ca_patient_id="";
	session.putValue("ca_patient_id_new",ca_patient_id);
	String i_clinic_code=request.getParameter("i_clinic_code");
	if(i_clinic_code==null) i_clinic_code="";
	String req_id=request.getParameter("request_id");
	if(req_id==null) req_id="";
	String appt_date=request.getParameter("appt_date");
	if(appt_date ==null) appt_date="";
	String locale=(String)session.getAttribute("LOCALE");
	String loc_type_OP= request.getParameter("loc_type");
	if(loc_type_OP ==null) loc_type_OP="";
	String no_dwm=request.getParameter("no_dwm");
	if(no_dwm ==null || no_dwm.equals("undefined") ) no_dwm="";
	String visittype=request.getParameter("visittype");
	if(visittype ==null) visittype="";
	String dwm_desc=request.getParameter("dwm_desc");
	if(dwm_desc ==null) dwm_desc="";
	String from_facility_id= request.getParameter("from_facility_id");
	if(from_facility_id ==null) from_facility_id="";
	String from_encounter_id= request.getParameter("from_encounter_id");
	if(from_encounter_id ==null) from_encounter_id="";
	String referral_id= request.getParameter("referral_id");
	if(referral_id ==null) referral_id="";	
	session.setAttribute("referral_id_app",referral_id);
	String calledFrom= request.getParameter("calledFrom");
	if(calledFrom ==null) calledFrom="";
	//Added by S.Sathish for IN021901 on Friday, June 11, 2010 starts here
	String locn_code = request.getParameter("locn_code")==null?"":request.getParameter("locn_code");
	String locnDesc = request.getParameter("locnDesc")==null?"":request.getParameter("locnDesc");
	String resourceId = request.getParameter("resourceId")==null?"":request.getParameter("resourceId");
	String resourceDesc = request.getParameter("resourceDesc")==null?"":request.getParameter("resourceDesc");	
    String locn_disable="";	
	if(!locn_code.equals("") && !locnDesc.equals(""))
		locn_disable="";
    else
	   locn_disable="disabled";
//Ends here 
	
	Connection con =null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt_ter=null;
	Statement stmt = null;
	Statement stmt1=null;
	Statement stmt3=null;
	Statement stmt5=null;
	Statement stmt7=null;
	Statement stmt8=null;
	Statement stmt9=null;
	Statement stmt11=null;
	ResultSet rs=null;
	ResultSet rs_ter=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	ResultSet rs3=null;
	ResultSet rs5=null;
	ResultSet rs7=null;
	ResultSet rs8=null;
	ResultSet rs9=null;
	ResultSet rs11=null;
	ResultSet rs_or=null;
	StringBuffer sql4=new StringBuffer();
	String install_yn_val="";
	boolean allow_inside=true;

	String position=request.getParameter("position")==null?"":request.getParameter("position");
	String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");
	String splty_desc="";
	String splty_code="";
	Boolean isAlertApplicableforBookAppt=false; //Added by Mujafar  for GHL-CRF-0527
	
	try{
		
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		stmt5=con.createStatement();
		stmt8=con.createStatement();
		Properties p=(Properties)session.getValue("jdbc");
		String facilityid=(String)session.getValue("facility_id");
		String globaluser = (String)p.getProperty("login_user");

		install_yn_val=request.getParameter("install_yn_val");
		
		if(install_yn_val ==null) install_yn_val="";
		isAlertApplicableforBookAppt = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "ALRT_DISP_APPL_BOOK_APPT");//Added by Mujafar  for GHL-CRF-0527


		if(install_yn_val.equals("")){
			String sql="select Operational_yn from sm_modules_facility where facility_id = '"+facilityid+"' and module_id = 'OR' ";

			rs=stmt.executeQuery(sql);
			if(rs !=null ){
				while (rs.next()){
					install_yn_val=rs.getString("Operational_yn");
				}
			}
		}
		// Added for Rutnin CRF
		String rule_appl_yn="N";
		String rd_oa_integration_yn="N";
		String per_chk_cancld_past_appts="0";
		String per_chk_cancld_fut_appts="0";
		String per_chk_past_resch_appts="0";
		String per_chk_fut_resch_appts="0";
		String no_of_cancld_appts_for_alert="0";
		String no_of_resch_appts_for_alert="0";
		String per_chk_for_no_show_alert="0";
		String no_of_noshow_appts_for_alert="0";
		String mob_num_req_yn="N";
		String lang_req_yn ="N";
		String no_of_fut_appts_for_alert="0";
		String per_chk_for_fut_appts_alert="0";
		String patient_id_length="";
		String pat_name_as_multipart_yn="";
		String name_prefix_accept_yn="";
		String name_prefix_reqd_yn="";
		String name_prefix_length="";
		String name_prefix_prompt="";
		String first_name_accept_yn="";
		String first_name_reqd_yn="";
		String first_name_order="";
		String first_name_prompt="";
		String first_name_length="";
		String second_name_accept_yn="";
		String second_name_reqd_yn="";
		String second_name_order="";
		String second_name_prompt="";
		String second_name_length="";
		String third_name_accept_yn="";
		String third_name_reqd_yn="";
		String third_name_order="";
		String third_name_prompt="";
		String third_name_length="";
		String family_name_accept_yn="";
		String family_name_reqd_yn="";
		String family_name_order="";
		String family_name_prompt="";
		String family_name_length="";
		String name_suffix_accept_yn="";
		String name_suffix_reqd_yn="";
		//String name_prefix_length="";
		String name_suffix_prompt="";
		
		String names_in_oth_lang_yn="";
		String name_prefix_loc_lang_prompt="";
		String first_name_loc_lang_prompt="";
		String second_name_loc_lang_prompt="";
		String third_name_loc_lang_prompt="";
		String family_name_loc_lang_prompt="";
		String name_suffix_loc_lang_prompt="";
		
		
		String patient_id_temp	= checkForNull(request.getParameter("patient_id_temp"));
		String first_name_temp	= checkForNull(request.getParameter("first_name_temp"));
		String second_name_temp	= checkForNull(request.getParameter("second_name_temp"));
		String third_name_temp	= checkForNull(request.getParameter("third_name_temp"));
		String family_name_temp	= checkForNull(request.getParameter("family_name_temp"));
		String first_name_oth_lang_temp	= checkForNull(request.getParameter("first_name_oth_lang_temp"));
		String second_name_oth_lang_temp	= checkForNull(request.getParameter("second_name_oth_lang_temp"));
		String third_name_oth_lang_temp	= checkForNull(request.getParameter("third_name_oth_lang_temp"));
		String family_name_oth_lang_temp	= checkForNull(request.getParameter("family_name_oth_lang_temp"));
		//String gender_temp		= checkForNull(request.getParameter("gender_temp"));
		String contact_no_temp	= checkForNull(request.getParameter("contact_no_temp"));
		String nationality_code_temp	= checkForNull(request.getParameter("nationality_code_temp"));
		String language_code_temp	= checkForNull(request.getParameter("language_code_temp"));
		String nat_desc_temp	="";
		String lang_desc_temp	="";
		
		if(!ca_patient_id.equals("")){
		// added by N Munisekhar on 04-May-2012 against [IN:039768]

		if(ca_patient_id.equals("dummy_patinetID")){
			patient_id_temp = "";
			}
			else{
			patient_id_temp = ca_patient_id;
			}
		}
		String sql="select RULE_APPL_YN, PER_CHK_CANCLD_PAST_APPTS,PER_CHK_CANCLD_FUT_APPTS,PER_CHK_PAST_RESCH_APPTS,PER_CHK_FUT_RESCH_APPTS,NO_OF_CANCLD_APPTS_FOR_ALERT,NO_OF_RESCH_APPTS_FOR_ALERT,PER_CHK_FOR_NO_SHOW_ALERT,NO_OF_NOSHOW_APPTS_FOR_ALERT,MOB_NUM_REQ_YN,LANGUAGE_REQ_YN,NO_OF_FUT_APPTS_FOR_ALERT,PER_CHK_FOR_FUT_APPTS_ALERT,rd_oa_integration_yn from oa_param ";
		rs=stmt.executeQuery(sql);
		if(rs !=null ){
			while (rs.next()){
				rd_oa_integration_yn=rs.getString("rd_oa_integration_yn")==null?"N":rs.getString("rd_oa_integration_yn");
				rule_appl_yn=rs.getString("RULE_APPL_YN")==null?"N":rs.getString("RULE_APPL_YN");
				per_chk_cancld_past_appts=rs.getString("per_chk_cancld_past_appts")==null?"0":rs.getString("per_chk_cancld_past_appts");
				per_chk_cancld_fut_appts=rs.getString("per_chk_cancld_fut_appts")==null?"0":rs.getString("per_chk_cancld_fut_appts");
				per_chk_past_resch_appts=rs.getString("per_chk_past_resch_appts")==null?"0":rs.getString("per_chk_past_resch_appts");;
				per_chk_fut_resch_appts=rs.getString("per_chk_fut_resch_appts")==null?"0":rs.getString("per_chk_fut_resch_appts");
				no_of_cancld_appts_for_alert=rs.getString("no_of_cancld_appts_for_alert")==null?"0":rs.getString("no_of_cancld_appts_for_alert");
				no_of_resch_appts_for_alert=rs.getString("no_of_resch_appts_for_alert")==null?"0":rs.getString("no_of_resch_appts_for_alert");;
				per_chk_for_no_show_alert=rs.getString("per_chk_for_no_show_alert")==null?"0":rs.getString("per_chk_for_no_show_alert");
				no_of_noshow_appts_for_alert=rs.getString("no_of_noshow_appts_for_alert")==null?"0":rs.getString("no_of_noshow_appts_for_alert");
				mob_num_req_yn=rs.getString("mob_num_req_yn")==null?"N":rs.getString("mob_num_req_yn");
				lang_req_yn=rs.getString("LANGUAGE_REQ_YN")==null?"N":rs.getString("LANGUAGE_REQ_YN");
				no_of_fut_appts_for_alert=rs.getString("NO_OF_FUT_APPTS_FOR_ALERT")==null?"0":rs.getString("NO_OF_FUT_APPTS_FOR_ALERT");
				per_chk_for_fut_appts_alert=rs.getString("PER_CHK_FOR_FUT_APPTS_ALERT")==null?"0":rs.getString("PER_CHK_FOR_FUT_APPTS_ALERT");

			}
		}
		if(rule_appl_yn.equals("Y")){
			sql="Select patient_id_length,Nat_Id_Length,alt_id1_length, pat_name_as_multipart_yn,NAME_PREFIX_ACCEPT_YN,NAME_PREFIX_REQD_YN,NAME_PREFIX_LENGTH,NAME_PREFIX_PROMPT,FIRST_NAME_ACCEPT_YN, FIRST_NAME_REQD_YN, FIRST_NAME_ORDER, FIRST_NAME_PROMPT, SECOND_NAME_ACCEPT_YN, SECOND_NAME_REQD_YN, SECOND_NAME_ORDER, SECOND_NAME_PROMPT, THIRD_NAME_ACCEPT_YN, THIRD_NAME_REQD_YN, THIRD_NAME_ORDER, THIRD_NAME_PROMPT, FAMILY_NAME_ACCEPT_YN, FAMILY_NAME_REQD_YN, FAMILY_NAME_ORDER, FAMILY_NAME_PROMPT, FAMILY_NAME_PREFIX_YN, FAMILY_NO_PROMPT,FAMILY_NAME_LENGTH, FIRST_NAME_LENGTH, SECOND_NAME_LENGTH, THIRD_NAME_LENGTH,NAME_SUFFIX_ACCEPT_YN,NAME_SUFFIX_REQD_YN,NAME_SUFFIX_PROMPT,NAMES_IN_OTH_LANG_YN,NAME_PREFIX_LOC_LANG_PROMPT,FIRST_NAME_LOC_LANG_PROMPT,SECOND_NAME_LOC_LANG_PROMPT,THIRD_NAME_LOC_LANG_PROMPT,FAMILY_NAME_LOC_LANG_PROMPT,NAME_SUFFIX_LOC_LANG_PROMPT from mp_param where module_id='MP'";
			rs=stmt.executeQuery(sql);
			if(rs !=null ){
				while (rs.next()){
					patient_id_length=rs.getString("patient_id_length")==null?"":rs.getString("patient_id_length");
					pat_name_as_multipart_yn=rs.getString("pat_name_as_multipart_yn")==null?"":rs.getString("pat_name_as_multipart_yn");
					
					name_prefix_accept_yn=rs.getString("name_prefix_accept_yn")==null?"":rs.getString("name_prefix_accept_yn");
					name_prefix_reqd_yn=rs.getString("NAME_PREFIX_REQD_YN")==null?"":rs.getString("NAME_PREFIX_REQD_YN");
					name_prefix_length=rs.getString("name_prefix_length")==null?"":rs.getString("name_prefix_length");
					name_prefix_prompt=rs.getString("name_prefix_prompt")==null?"":rs.getString("name_prefix_prompt");
					
					first_name_accept_yn=rs.getString("FIRST_NAME_ACCEPT_YN")==null?"":rs.getString("FIRST_NAME_ACCEPT_YN");
					first_name_reqd_yn=rs.getString("FIRST_NAME_REQD_YN")==null?"":rs.getString("FIRST_NAME_REQD_YN");
					first_name_order=rs.getString("FIRST_NAME_ORDER")==null?"0":rs.getString("FIRST_NAME_ORDER"); //incident 35325
					first_name_prompt=rs.getString("FIRST_NAME_PROMPT")==null?"":rs.getString("FIRST_NAME_PROMPT");
					first_name_length=rs.getString("FIRST_NAME_LENGTH")==null?"":rs.getString("FIRST_NAME_LENGTH");

					second_name_accept_yn=rs.getString("SECOND_NAME_ACCEPT_YN")==null?"":rs.getString("SECOND_NAME_ACCEPT_YN");
					second_name_reqd_yn=rs.getString("SECOND_NAME_REQD_YN")==null?"":rs.getString("SECOND_NAME_REQD_YN");
					second_name_order=rs.getString("SECOND_NAME_ORDER")==null?"0":rs.getString("SECOND_NAME_ORDER"); //incident 35325
					second_name_prompt=rs.getString("SECOND_NAME_PROMPT")==null?"":rs.getString("SECOND_NAME_PROMPT");
					second_name_length=rs.getString("SECOND_NAME_LENGTH")==null?"":rs.getString("SECOND_NAME_LENGTH");

					third_name_accept_yn=rs.getString("THIRD_NAME_ACCEPT_YN")==null?"":rs.getString("THIRD_NAME_ACCEPT_YN");
					third_name_reqd_yn=rs.getString("THIRD_NAME_REQD_YN")==null?"":rs.getString("THIRD_NAME_REQD_YN");
					third_name_order=rs.getString("THIRD_NAME_ORDER")==null?"0":rs.getString("THIRD_NAME_ORDER"); //incident35325
					third_name_prompt=rs.getString("THIRD_NAME_PROMPT")==null?"":rs.getString("THIRD_NAME_PROMPT");
					third_name_length=rs.getString("THIRD_NAME_LENGTH")==null?"":rs.getString("THIRD_NAME_LENGTH");

					family_name_accept_yn=rs.getString("FAMILY_NAME_ACCEPT_YN")==null?"":rs.getString("FAMILY_NAME_ACCEPT_YN");
					family_name_reqd_yn=rs.getString("FAMILY_NAME_REQD_YN")==null?"":rs.getString("FAMILY_NAME_REQD_YN");
					family_name_order=rs.getString("FAMILY_NAME_ORDER")==null?"":rs.getString("FAMILY_NAME_ORDER");
					family_name_prompt=rs.getString("FAMILY_NAME_PROMPT")==null?"":rs.getString("FAMILY_NAME_PROMPT");
					family_name_length=rs.getString("FAMILY_NAME_LENGTH")==null?"":rs.getString("FAMILY_NAME_LENGTH");
					
					name_suffix_accept_yn=rs.getString("name_suffix_accept_yn")==null?"":rs.getString("name_suffix_accept_yn");
					name_suffix_reqd_yn=rs.getString("name_suffix_reqd_yn")==null?"":rs.getString("name_suffix_reqd_yn");
					//name_prefix_length=rs.getString("name_prefix_length")==null?"":rs.getString("name_prefix_length");
					name_suffix_prompt=rs.getString("name_suffix_prompt")==null?"":rs.getString("name_suffix_prompt");
					
					names_in_oth_lang_yn=rs.getString("names_in_oth_lang_yn")==null?"N":rs.getString("names_in_oth_lang_yn");
					name_prefix_loc_lang_prompt=rs.getString("name_prefix_loc_lang_prompt")==null?"":rs.getString("name_prefix_loc_lang_prompt");
					first_name_loc_lang_prompt=rs.getString("first_name_loc_lang_prompt")==null?"":rs.getString("first_name_loc_lang_prompt");
					second_name_loc_lang_prompt=rs.getString("second_name_loc_lang_prompt")==null?"":rs.getString("second_name_loc_lang_prompt");
					third_name_loc_lang_prompt=rs.getString("third_name_loc_lang_prompt")==null?"":rs.getString("third_name_loc_lang_prompt");
					family_name_loc_lang_prompt=rs.getString("family_name_loc_lang_prompt")==null?"":rs.getString("family_name_loc_lang_prompt");
					name_suffix_loc_lang_prompt=rs.getString("name_suffix_loc_lang_prompt")==null?"":rs.getString("name_suffix_loc_lang_prompt");
				}
			}
			String lan_natSQL="select (select long_desc description from mp_country_lang_vw where COUNTRY_CODE='"+nationality_code_temp+"' and language_id='"+locale+"')country_desc,(Select LONG_DESC description from MP_LANGUAGE_LANG_VW where  MP_LANGUAGE_ID='"+language_code_temp+"' and language_id='"+locale+"')lang_desc from dual";
			if(rs!=null)rs.close();
			rs=stmt.executeQuery(lan_natSQL);
			if(rs!=null && rs.next()){
				nat_desc_temp=rs.getString("country_desc")==null?"":rs.getString("country_desc");
				lang_desc_temp=rs.getString("lang_desc")==null?"":rs.getString("lang_desc");
			}
		}
		
	/*	
		//Added for OP Checkout
		if (!op_practitioner.equals("")){
			disablePract = "disabled";
		}
		//End of addition
*/
		String clinic_code="";
		String short_desc="";
		String visit_type_code="";
		String speciality_codes="";
		String book_appt_yn ="";                  
		String pref_from_date="";   
		String create_wait_list_yn ="";   
		String oper_stn_id=request.getParameter("oper_stn_id");
		if(oper_stn_id ==null) oper_stn_id="";
		String or_cat_desc="";		
		book_appt_yn=request.getParameter("book_appt_yn");
		if(book_appt_yn ==null) book_appt_yn="";

		create_wait_list_yn=request.getParameter("create_wait_list_yn");
		if(create_wait_list_yn ==null) create_wait_list_yn="";

		



		if (callingMode.equals("OR") || callingMode.equals("OH") || callingMode.equals("RD")){
			if(!order_catalog_code.equals("null")){
				String order_cat_or="select short_desc from OR_ORDER_CATALOG_LANG_VW where ORDER_CATALOG_CODE='"+order_catalog_code+"' and language_id='"+locale+"'"	;
				rs_or = stmt.executeQuery(order_cat_or);
				if(rs_or !=null && rs_or.next()){
					or_cat_desc=rs_or.getString("short_desc");
				}
			}
		}
        if (rs_or!=null) rs_or.close();

		if(oper_stn_id.equals("")){


			String sql2="SELECT a.oper_stn_id,a.book_appt_yn,a.CREATE_WAIT_LIST_YN FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityid+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+globaluser+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";
			stmt1=con.createStatement();							
			rs2=stmt1.executeQuery(sql2);
			if (rs2!=null && rs2.next()){
				oper_stn_id=rs2.getString("oper_stn_id");
				book_appt_yn=rs2.getString("book_appt_yn"); 	
				create_wait_list_yn=rs2.getString("CREATE_WAIT_LIST_YN"); 	
			}else{					
				allow_inside=false;%>
				<script>
				alert(getMessage('NO_OPER_STN_FOR_USER','Common'));
					location.href='../../eCommon/jsp/home.jsp';
					document.location.href='../../eCommon/jsp/dmenu.jsp';
				</script>
					<%
			}
		}else{
		
			allow_inside=true;
		}
		
		if(rs1 !=null) rs1.close();
		if(allow_inside){
			if(book_appt_yn.equals("N")){%>
			<script>alert(getMessage('SCH_NOT_ALLOW','OA'));
				parent.frames[0].document.location.href='../../eCommon/jsp/home.jsp?called_from=CA';
			</script>
			<%}
			String  sql3="Select clinic_code, to_char(sysdate,'dd/mm/yyyy') sys_date from op_clinic a, am_locn_for_oper_stn b where  a.facility_id='"+facilityid+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn ='Y' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and b.eff_status='E'";

			
			stmt3=con.createStatement();
			rs3=stmt3.executeQuery(sql3);
			int check=0;
			while(rs3.next()){
				pref_from_date=rs3.getString("sys_date");
				if(check == 0)
					clinic_code="'"+rs3.getString("clinic_code")+"'";
				else
					clinic_code=clinic_code+",'"+rs3.getString("clinic_code")+"'";
				check++;
			}
			clinic_code="("+clinic_code+")";
			String clinic_code_main = clinic_code;
			String clnc_code=checkForNull(request.getParameter("clinic_code"));
			String chk_status="";
			if(!callingMode.equals("MR")){ 
				speclty_Cd=request.getParameter("specialty_code");	
				
			}else if( module_id.equals("OA") && callingMode.equals("MR") || callingMode.equals("OH")){
				speclty_Cd=specialty_codema1;
				chk_status="Y";
			}
			if(speclty_Cd ==null) speclty_Cd="";
			String ref_id=(String) session.getValue("ref_id");
			if(ref_id==null) ref_id="";
		%>
		<body  onLoad="disp_data();focuschk();Disable_oprv();" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
		<form name='schedule_appointment' id='schedule_appointment'>
		<%
		if(rule_appl_yn.equals("Y")){
		%>
			<table border="0" cellpadding="0" cellspacing="0" width="100%" valign='top' id='rule_table' >
				<tr>
					<td colspan='10' class='COLUMNHEADER'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>

				</tr>
			
					<td align='left' class='label' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class='fields' ><input type= 'text' name='patient_id' id='patient_id'  size='<%=patient_id_length%>'  maxlength='<%=patient_id_length%>' value='<%=patient_id_temp%>' onKeyPress='return CheckForSpecChars(event)' value="" onBlur="searchPatient(document.getElementById('patient_id'),'<%=patient_id_length%>')" tabIndex='1'><input type='button' name='searchPatientButton' id='searchPatientButton' value='?' class="BUTTON" onClick="patqry()" tabIndex="-1" ></td>
					
					<td class="label" nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
					<td class='fields'><select name='gender' id='gender'><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option><option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option><option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option></select><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>

					<td colspan=2>&nbsp;</td>

				</tr>
				
				<tr>
					<%
						int colCount=6;
						if(name_prefix_accept_yn.equals("Y")){
							colCount--;
							%>
								<td  class='label'  nowrap><%=name_prefix_prompt%></td>
							<%
						}
						if(pat_name_as_multipart_yn.equals("Y")){
							for(int order=1;order<=4;++order){
								if(order==Integer.parseInt(first_name_order)){
									if(first_name_accept_yn.equals("Y")){
									%>
										<td class='label' nowrap><input type='hidden' name='firstnameprompt' id='firstnameprompt' value="<%=first_name_prompt%>"><%=first_name_prompt%><%if(first_name_reqd_yn.equals("Y")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%></td>
									<%}else{
									}
								}else if(order==Integer.parseInt(second_name_order)){
									if(second_name_accept_yn.equals("Y")){
								%>
									<td class='label' nowrap><input type='hidden' name='secondnameprompt' id='secondnameprompt' value="<%=second_name_prompt%>"><%=second_name_prompt%><%if(second_name_reqd_yn.equals("Y")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%></td>
									<%}else{
									}
								}else if(order==Integer.parseInt(third_name_order)){
									if(third_name_accept_yn.equals("Y")){
								%>
									<td class='label' nowrap><input type='hidden' name='thirdnameprompt' id='thirdnameprompt' value="<%=third_name_prompt%>"><%=third_name_prompt%><%if(third_name_reqd_yn.equals("Y")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%></td>
									<%}else{
									}
								}else if(order==Integer.parseInt(family_name_order)){
									if(family_name_accept_yn.equals("Y")){
								%>
									<td class='label' nowrap><input type='hidden' name='familynameprompt' id='familynameprompt' value="<%=family_name_prompt%>"><%=family_name_prompt%><%if(family_name_reqd_yn.equals("Y")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%></td>
									<%}else{
									}
								}
							}						
						}else{
							if(family_name_accept_yn.equals("Y")){
							%>
								<td class='label' nowrap><input type='hidden' name='familynameprompt' id='familynameprompt' value="<%=family_name_prompt%>"><%=family_name_prompt%><%if(family_name_reqd_yn.equals("Y")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%></td>
								<%}else{
								}
						}
						if(name_suffix_accept_yn.equals("Y")){
							colCount--;
							%>
								<td  class='label'  nowrap><%=name_suffix_prompt%></td>
							<%
							
							out.println("</script>");
							ArrayList nameSuffixArrayList = new ArrayList();
							nameSuffixArrayList = eMP.ChangePatientDetails.getResultRows(con,"mp_name_suffix2",p);
							out.println("<script>");
							int a = 0;
							for(int i=0;i<nameSuffixArrayList.size();i+=3) 
							{
								out.print("NameSuffixArray["+a+"]=escape(\""+(String)nameSuffixArrayList.get(i)+"\");");
								out.print("NameSuffixLocArray["+a+"]=escape(\""+(String)nameSuffixArrayList.get(i+1)+"\");");
								out.print("SuffixSexArray["+a+"]=escape(\""+(String)nameSuffixArrayList.get(i+2)+"\");");				
								a++;
							}
							out.println("</script>");
						}						
					%>
				</tr>
				<tr>
					<input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='<%=name_prefix_reqd_yn%>'>
					<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='<%=first_name_reqd_yn%>'>
					<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='<%=second_name_reqd_yn%>'>
					<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='<%=third_name_reqd_yn%>'>
					<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='<%=family_name_reqd_yn%>'>
					<input type='hidden' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='<%=name_suffix_reqd_yn%>'>
					<input type='hidden' name='names_in_oth_lang_yn' id='names_in_oth_lang_yn' value='<%=names_in_oth_lang_yn%>'>
					
					<%
						if(name_prefix_accept_yn.equals("Y")){
							ArrayList namePrefixArrayList = new ArrayList();
							namePrefixArrayList = eMP.ChangePatientDetails.getResultRows(con,"mp_name_prefix",p);
							//System.out.println("namePrefixArrayList :"+namePrefixArrayList.toString());
							int a = 0;
							out.println("<script>");
							for(int i=0;i<namePrefixArrayList.size();i+=3) 
							{								
								out.print("NamePrefixArray["+a+"]=escape(\""+(String)namePrefixArrayList.get(i)+"\");");
								out.print("NamePrefixLocArray["+a+"]=escape(\""+(String)namePrefixArrayList.get(i+1)+"\");");								
								out.print("PrefixSexArray["+a+"]=escape(\""+(String)namePrefixArrayList.get(i+2)+"\");");				
								a++;
							}
							out.println("</script>");							
						%>
							
							<input type='hidden' name='name_prefix_prompt' id='name_prefix_prompt' value="<%=name_prefix_prompt%>">
							<td  class='fields' >
								<Select name='name_prefix' id='name_prefix' onchange='prefixToGenderDflt(this)'>
									<Option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
									<script>									
										prefix_length = NamePrefixArray.length;
										for(i = 0; i < prefix_length; i++) {
											opt = document.createElement("OPTION");
											name_pfx = unescape(NamePrefixArray[i]);
											opt.text = name_pfx;
											opt.value = name_pfx; 
											document.forms[0].name_prefix.options.add(opt);	
										}
										
									</script>
								</select><%if(name_prefix_reqd_yn.equals("Y")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%>
							</td>
						<%}
					%>
					<%
						if(pat_name_as_multipart_yn.equals("Y")){
							for(int order=1;order<=4;++order){
								if(order==Integer.parseInt(first_name_order)){
									if(first_name_accept_yn.equals("Y")){
									%>
										<td><input type= 'text' name='first_name' id='first_name' size='20'  maxlength='<%=first_name_length%>' value ='<%=first_name_temp%>'></td>
									<%}else{
									}
								}else if(order==Integer.parseInt(second_name_order)){
									if(second_name_accept_yn.equals("Y")){
								%>
									<td><input type= 'text' name='second_name' id='second_name'  size='20' maxlength='<%=second_name_length%>' value ='<%=second_name_temp%>'></td>
									<%}else{
									}
								}else if(order==Integer.parseInt(third_name_order)){
									if(third_name_accept_yn.equals("Y")){
								%>
									<td><input type= 'text' name='third_name' id='third_name' size='20'  maxlength='<%=third_name_length%>' value ='<%=third_name_temp%>'></td>
									<%}else{
									}
								}else if(order==Integer.parseInt(family_name_order)){
									if(family_name_accept_yn.equals("Y")){
								%>
									<td><input type= 'text' name='family_name' id='family_name'  size='20'  maxlength='<%=family_name_length%>' value ='<%=family_name_temp%>'></td>
									<%}else{
									}
								}
							}
						}else{
							if(family_name_accept_yn.equals("Y")){
								%>
									<td><input type= 'text' name='family_name' id='family_name'  size='20'  maxlength='<%=family_name_length%>' value ='<%=family_name_temp%>'></td>
									<%}else{
									}
						}						
					%>

					<%
						if(name_suffix_accept_yn.equals("Y")){							
						%>
							
							<input type='hidden' name='name_suffix_prompt' id='name_suffix_prompt' value="<%=name_suffix_prompt%>">
							<td  class='fields' >
								<Select name='name_suffix' id='name_suffix' onchange='suffixToGenderDflt(this)'>
									<Option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
									<script>									
										suffix_length = NameSuffixArray.length;
										for(i = 0; i < suffix_length; i++) {
											opt = document.createElement("OPTION");
											name_sfx = unescape(NameSuffixArray[i]);
											opt.text = name_sfx;
											opt.value = name_sfx; 
											document.forms[0].name_suffix.options.add(opt);	
										}
										
									</script>
								</select><%if(name_suffix_reqd_yn.equals("Y")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%>
							</td>
						<%}
						

					%>

					</tr>
					<%
					if(names_in_oth_lang_yn.equals("Y")){%>
							<tr>
							<%
								int colCount1=6;
								if(name_prefix_accept_yn.equals("Y")){
									colCount1--;
									%>
										<td  class='label'  nowrap><%=name_prefix_loc_lang_prompt%><input type='hidden' name='name_prefix_oth_lang_prompt' id='name_prefix_oth_lang_prompt' value="<%=name_prefix_loc_lang_prompt%>"></td>
									<%
								}
								if(pat_name_as_multipart_yn.equals("Y")){
									for(int order=1;order<=4;++order){
										if(order==Integer.parseInt(first_name_order)){
											if(first_name_accept_yn.equals("Y")){
											%>
												<td class='label' nowrap><input type='hidden' name='first_name_oth_lang_prompt' id='first_name_oth_lang_prompt' value="<%=first_name_loc_lang_prompt%>"><%=first_name_loc_lang_prompt%><%if(first_name_reqd_yn.equals("Y")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%></td>
											<%}else{
											}
										}else if(order==Integer.parseInt(second_name_order)){
											if(second_name_accept_yn.equals("Y")){
										%>
											<td class='label' nowrap><input type='hidden' name='second_name_oth_lang_prompt' id='second_name_oth_lang_prompt' value="<%=second_name_loc_lang_prompt%>"><%=second_name_loc_lang_prompt%><%if(second_name_reqd_yn.equals("Y")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%></td>
											<%}else{
											}
										}else if(order==Integer.parseInt(third_name_order)){
											if(third_name_accept_yn.equals("Y")){
										%>
											<td class='label' nowrap><input type='hidden' name='third_name_oth_lang_prompt' id='third_name_oth_lang_prompt' value="<%=third_name_loc_lang_prompt%>"><%=third_name_loc_lang_prompt%><%if(third_name_reqd_yn.equals("Y")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%></td>
											<%}else{
											}
										}else if(order==Integer.parseInt(family_name_order)){
											if(family_name_accept_yn.equals("Y")){
										%>
											<td class='label' nowrap><input type='hidden' name='family_name_oth_lang_prompt' id='family_name_oth_lang_prompt' value="<%=family_name_loc_lang_prompt%>"><%=family_name_loc_lang_prompt%><%if(family_name_reqd_yn.equals("Y")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%></td>
											<%}else{
											}
										}
									}								
								}else{
									if(family_name_accept_yn.equals("Y")){
										%>
											<td class='label' nowrap><input type='hidden' name='family_name_oth_lang_prompt' id='family_name_oth_lang_prompt' value="<%=family_name_loc_lang_prompt%>"><%=family_name_loc_lang_prompt%><%if(family_name_reqd_yn.equals("Y")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%></td>
											<%}else{
											}
								}
								if(name_suffix_accept_yn.equals("Y")){
									colCount--;
									%>
										<td  class='label'  nowrap><%=name_suffix_loc_lang_prompt%><input type='hidden' name='name_suffix_oth_lang_prompt' id='name_suffix_oth_lang_prompt' value="<%=name_suffix_loc_lang_prompt%>"></td>
									<%					
									
								}						
							%>
						</tr>
						
						<tr>
							<%
								if(name_prefix_accept_yn.equals("Y")){%>
									<td  class='fields' >
								<!--modified by N Munisekhar on 28-Jan-2013 against RUT-SCF-0216 [IN:037457] -->
										<Select name='name_prefix_oth_lang' id='name_prefix_oth_lang' onchange='prefixToGenderDflt(this)' >
									    <!--End of RUT-SCF-0216 [IN:037457] -->
											<Option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
											<script>									
												prefix_loc_length = NamePrefixLocArray.length;
												for(i = 0; i < prefix_loc_length; i++) {
													loc_name_pfx = unescape(NamePrefixLocArray[i]);
													if(loc_name_pfx!='') {
														opt = document.createElement("OPTION");									
														opt.text = loc_name_pfx;
														opt.value = loc_name_pfx; 
														document.forms[0].name_prefix_oth_lang.options.add(opt);	
													}
												}
												
											</script>
										</select><%if(name_prefix_reqd_yn.equals("Y")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%>
									</td>
								<%}
								if(pat_name_as_multipart_yn.equals("Y")){
									for(int order=1;order<=4;++order){
										if(order==Integer.parseInt(first_name_order)){
											if(first_name_accept_yn.equals("Y")){
											%>
											<td><input type= 'text' name='first_name_oth_lang' id='first_name_oth_lang' size='20'  maxlength='<%=first_name_length%>' value ='<%=first_name_oth_lang_temp%>'></td>
											<%}else{
											}
										}else if(order==Integer.parseInt(second_name_order)){
											if(second_name_accept_yn.equals("Y")){
											%>
											<td><input type= 'text' name='second_name_oth_lang' id='second_name_oth_lang'  size='20' maxlength='<%=second_name_length%>' value ='<%=second_name_oth_lang_temp%>'></td>
											<%}else{
											}
										}else if(order==Integer.parseInt(third_name_order)){
											if(third_name_accept_yn.equals("Y")){
											%>
											<td><input type= 'text' name='third_name_oth_lang' id='third_name_oth_lang' size='20'  maxlength='<%=third_name_length%>' value ='<%=third_name_oth_lang_temp%>'></td>
											<%}else{
											}
										}else if(order==Integer.parseInt(family_name_order)){
											if(family_name_accept_yn.equals("Y")){
											%>
											<td><input type= 'text' name='family_name_oth_lang' id='family_name_oth_lang'  size='20'  maxlength='<%=family_name_length%>' value ='<%=family_name_oth_lang_temp%>'></td>
											<%}else{
											}
										}
									}
								}else{
									if(family_name_accept_yn.equals("Y")){
										%>
										<td><input type= 'text' name='family_name_oth_lang' id='family_name_oth_lang'  size='20'  maxlength='<%=family_name_length%>' value ='<%=family_name_oth_lang_temp%>'></td>
										<%}else{
										}
								}								
								if(name_suffix_accept_yn.equals("Y")){%>
									<td  class='fields' >
								<!--modified by N Munisekhar on 28-Jan-2013 against RUT-SCF-0216 [IN:037457] -->
									<Select name='name_suffix_oth_lang' id='name_suffix_oth_lang' onchange='suffixToGenderDflt(this)' >
									<!-- End of RUT-SCF-0216 [IN:037457]-->
											<Option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
											<script>									
												suffix_loc_length = NameSuffixLocArray.length;
												for(i = 0; i < suffix_loc_length; i++) {
													loc_name_sfx = unescape(NameSuffixLocArray[i]);
													if(loc_name_sfx!='') {
														opt = document.createElement("OPTION");									
														opt.text = loc_name_sfx;
														opt.value = loc_name_sfx; 
														document.forms[0].name_suffix_oth_lang.options.add(opt);	
													}
												}
												
											</script>
										</select><%if(name_suffix_reqd_yn.equals("Y")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%>
									</td>
								<%}
							%>
						</tr>
					<%}%>
					<tr>



					<td align='left' class='label' nowrap><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>
					<td><input type= 'text' name='contact_no' id='contact_no' size='20' maxlength='20' value ='<%=contact_no_temp%>'><%if(mob_num_req_yn.equals("Y")){%><img src='../../eCommon/images/mandatory.gif' align='center' id='contact_no_gif' style='visibility:visible'></img><%}%></td>
						
					<td class="label"  nowrap><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
					<td class='fields' >
					<input type='text' name='nationality_desc' id='nationality_desc' size='20' maxlength='20'  onblur='get_Nationality(this);' value="<%=nat_desc_temp%>" ><input type='button' name='nationality_button' id='nationality_button' value='?' class='button' onclick='get_Nationality(this);' ><input type='hidden' name='nationality_code' id='nationality_code' value="<%=nationality_code_temp%>"></td>

					<td class="label"  nowrap><fmt:message key="Common.Language.label" bundle="${common_labels}"/></td>
					<td class='fields' >
					<input type='text' name='language_desc' id='language_desc' size='20' maxlength='20'  onblur='searchLanguage(this);'value="<%=lang_desc_temp%>"><input type='button' name='language_button' id='language_button' value='?' class='button' onclick='searchLanguage(this);'><%if(lang_req_yn.equals("Y")){%><img id = 'lang_mand' src = '../../eCommon/images/mandatory.gif'><%}%><input type='hidden' name='language_code' id='language_code' value="<%=language_code_temp%>"></td>

					<td>&nbsp;</td>
					<td  >
					<input type='button'  name='view_history' id='view_history' value='<fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.History.label" bundle="${common_labels}"/>' onclick='displayPatientDetails()' class='BUTTON'>
					<input type='button'  name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='BUTTON' onclick='clearValues()'></td> 


				</tr>
			</table>
		<%}%>
		<input type='hidden' name='help_function_id' id='help_function_id' value='SCHEDULE_APPOINTMENT'>

		<table border="0" cellpadding="0" cellspacing="0" width="100%" valign='top'>
		<td class='COLUMNHEADER'><fmt:message key="eOA.ScheduleCriteria.label" bundle="${oa_labels}"/></td>
		<table  cellpadding="0" cellspacing="0" width="100%" valign='top' border='0'>
		<tr>
			<td  class='label' width='23%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td  class=fields nowrap>
				<select name='speciality' id='speciality' tabindex=0 onchange = 'enaable_ear(this)'><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----
				<%
					//THIS IS FOR POPULATING SPECIALITY-DROP-DOWN
					String ORspe="";
					StringBuffer sql6=new StringBuffer();
					if(direct_ip.equals("N")){
						sql6.append("select am_get_desc.AM_SPECIALITY(speciality_code,'"+locale+"',2) short_desc, speciality_code from am_speciality where  eff_status='E' and speciality_code ");
						if(callingMode.equals("OP") || callingMode.equals("IP")||callingMode.equals("RSCAPPT")){
							sql6.append("='"+speclty_Cd+"' ");
						}else{
							sql6.append(" in (select speciality_code from op_clinic where facility_id='"+facilityid+"' and clinic_code in "+clinic_code_main+") ");
						}
						sql6.append(" order by short_desc");
						if(!(clinic_code_main.equals("()"))){
							stmt7=con.createStatement();
							rs7=stmt7.executeQuery(sql6.toString());
		
							while(rs7.next()){
								short_desc=rs7.getString("short_desc");
								speciality_codes=rs7.getString("speciality_code");
								if(callingMode.equals("OP") || callingMode.equals("IP") || module_id.equals("OA")|| callingMode.equals("OH")||callingMode.equals("RSCAPPT")){
									if(speciality_codes.equals(speclty_Cd)){%>
										<option value='<%=speciality_codes%>' selected><%=short_desc%>
									<%}else{%>
										<option value='<%=speciality_codes%>'><%=short_desc%>
								<%}
								}else if(chk_status.equals("Y")){
									if(speclty_Cd.equals(speciality_codes)){%>
										<option value='<%=speciality_codes%>' selected><%=short_desc%>
									<%}else{%>
										<option value='<%=speciality_codes%>'><%=short_desc%>
									<%}
									}else{%>
										<option value='<%=speciality_codes%>'><%=short_desc%>
								<%}
							}							
						}//if
					}
					sql6=null;
					if(callingMode.equals("OR")){
						ORspe="select am_get_desc.AM_SPECIALITY(speciality_code,'"+locale+"',2) short_desc, speciality_code from am_speciality where speciality_code !='"+specialty_codema1+"' and eff_status='E'";
						stmt11=con.createStatement();
						rs11=stmt11.executeQuery(ORspe);
						if(rs11.next()){
							//spect_OR=rs11.getString("short_desc");
							code_val=rs11.getString("speciality_code");
						}
					}
				%>
				</select>
				<td class='label' nowrap width='25%'><fmt:message key="eOA.DisplayEarliestSch.label" bundle="${oa_labels}"/></td>				
				<td class='label' nowrap align='left' width='50%'><input type='checkbox' name='disp_next' id='disp_next'  tabindex=8 disabled>&nbsp;&nbsp;&nbsp;
				<%if(rule_appl_yn.equals("Y")){%>
					<fmt:message key="eOA.PractUnSpecified.label" bundle="${oa_labels}"/><input type='checkbox' name='tr_rule_applicable' id='tr_rule_applicable' onclick='CheckRule(this,"Y")'>&nbsp;&nbsp;&nbsp;
				<%}%>
				<%if(rd_oa_integration_yn.equals("Y")){ //Below line modified for this incident  [IN:038362]
						if(callingMode.equals("OP_RV") || callingMode.equals("OP") ||  callingMode.equals("OR")) disRdApp="disabled";
						String radChk = "";
						if(rd_appt_yn.equals("Y")) radChk="checked"; /*Below line Modified for this SCF [ML-BRU-SCF-0692]*/ %>
					<fmt:message key="eOA.RadAppt.label" bundle="${oa_labels}"/><input type='checkbox' name='rd_appt_yn' id='rd_appt_yn' <%=disRdApp%> value='<%=rd_appt_yn%>' <%=radChk%>  onclick='radRuleAppl(this)'>
				<%}%>
				</td>
		</tr>
		<tr>
			<td class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td class='fields'>
			<% 
			
			/*
				Below a.PRIMARY_RESOURCE_CLASS is added for query to getprimary resource type for clinic
				By Sudhakar
			*/
				sql4.append(" select a.open_to_all_pract_yn, a.long_desc, a.clinic_code,a.PRIMARY_RESOURCE_CLASS from op_clinic_lang_vw a, am_os_user_locn_access_vw b where a.facility_id='"+facilityid+"' and a.language_id = '"+locale+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind = 'A' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+globaluser+"' and (b.book_appt_yn='Y' or b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.eff_status = 'E' and a.clinic_type=b.locn_type");
				if(direct_ip.equals("N")){	
					if(callingMode.equals("OP") || callingMode.equals("IP") || callingMode.equals("OR") || module_id.equals("OA") || callingMode.equals("MR")|| callingMode.equals("OH") || callingMode.equals("OP_RV")||callingMode.equals("RSCAPPT") ){
						sql4.append(" and a.CARE_LOCN_TYPE_IND=Nvl('"+care_locn_ind+"',CARE_LOCN_TYPE_IND) and a.speciality_code = nvl('"+speclty_Cd+"', a.speciality_code) ");
						sql4.append(" and a.clinic_code = nvl('"+clnc_code+"',a.clinic_code) ");
					}
				}else{
					sql4.append(" and a.clinic_code = '"+clnc_code+"' ");
				}
				sql4.append(" order by a.long_desc");

			%>
				<SELECT name='location_type' id='location_type' tabindex=0 onChange="javascript:populateLocations(this)">
					<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
				<%
					if(loc_type_OP.equals("")){
						rs5=stmt5.executeQuery("select locn_type, am_get_desc.am_care_locn_type(LOCN_TYPE,'"+locale+"',2) short_desc, care_locn_type_ind from am_care_locn_type where sys_user_def_ind = 'S' and locn_type in ('C','E','Y')  order by short_desc");
					}else if(loc_type_OP.equals("C")){
						rs5=stmt5.executeQuery("select locn_type, am_get_desc.am_care_locn_type(LOCN_TYPE,'"+locale+"',2) short_desc, care_locn_type_ind from am_care_locn_type where sys_user_def_ind = 'S' and locn_type ='"+loc_type_OP+"'  order by short_desc");
					}else if(loc_type_OP.equals("E")){
						rs5=stmt5.executeQuery("select locn_type, am_get_desc.am_care_locn_type(LOCN_TYPE,'"+locale+"',2) short_desc, care_locn_type_ind from am_care_locn_type where sys_user_def_ind = 'S' and locn_type ='"+loc_type_OP+"' order by short_desc");
					}else if(loc_type_OP.equals("CE")){
						rs5=stmt5.executeQuery("select locn_type, am_get_desc.am_care_locn_type(LOCN_TYPE,'"+locale+"',2) short_desc, care_locn_type_ind from am_care_locn_type where sys_user_def_ind = 'S' and locn_type in ('C','E') order by short_desc");
					}
					while(rs5.next()){
						if(care_locn_ind.equals(rs5.getString("locn_type"))){
							if(!callingMode.equals("CA")){%>				
								<option value='<%=rs5.getString("locn_type")%>' selected> <%=rs5.getString("short_desc")%>
							<%}else {%>
								<option value='<%=rs5.getString("locn_type")%>'><%=rs5.getString("short_desc")%>
							<%}%>
						<%}else if(loc_type_OP.equals("C")) {%>
							<option value='<%=rs5.getString("locn_type")%>' selected> <%=rs5.getString("short_desc")%>
						<%}else if(loc_type_OP.equals("E")) {%>
							<option value='<%=rs5.getString("locn_type")%>' selected> <%=rs5.getString("short_desc")%>
						<%}else if(loc_type_OP.equals("CE")) {%>
							<option value='<%=rs5.getString("locn_type")%>'> <%=rs5.getString("short_desc")%>
						<%}else{%>
							<option value='<%=rs5.getString("CARE_LOCN_TYPE_IND")%>'><%=rs5.getString("short_desc")%>
						<%}%>
					<%}%>							
				</select>
			<%
				if(rs5 !=null)rs5.close();
				if(callingMode.equals("OP") || callingMode.equals("IP") ||callingMode.equals("OR") || module_id.equals("OA") || callingMode.equals("MR") || callingMode.equals("OH") || callingMode.equals("OP_RV")||callingMode.equals("RSCAPPT")){
					rs5=stmt5.executeQuery(sql4.toString());
					sql4=null;
					//int count_rec=1;
					String clinic_code_frmQuer="";
					short_desc="";
					clinic_code="";
					

					if(rs5.next()){
						primary_resource_class=rs5.getString("primary_resource_class");
						short_desc=rs5.getString("long_desc");
						clinic_code_frmQuer=rs5.getString("clinic_code");
						clinic_code=rs5.getString("open_to_all_pract_yn")+'$'+clinic_code_frmQuer;
						if(i_clinic_code.equals("") && web_request_yn.equals("Y")){
							clinic_code="";
							short_desc="";
						}
						if(clnc_code.equals("") &&  module_id.equals("OA")){
							short_desc="";
							clinic_code_frmQuer="";
							clinic_code="";
						}
						if(clnc_code.equals("") &&  callingMode.equals("OP")){
							short_desc="";
							clinic_code_frmQuer="";
							clinic_code="";
						}
						 
						if(ref_id.equals("N")){ /*Below line Modified for this SCF [ML-BRU-SCF-0692]*/%>
							<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
							<td class='label'><input type='text' size='25' maxlength='25' name='b_loc_val' id='b_loc_val' value='<%=short_desc%>' onblur="ena_loc_lookup(this);"><input type="hidden" name="clinic" id="clinic" value='<%=clinic_code%>' ><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup();" class='button'></td>
						<%}else{ /*Below line Modified for this SCF [ML-BRU-SCF-0692]*/%>
							<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
							<td class='label'><input type='text' size='25' maxlength='25' name='b_loc_val' id='b_loc_val' value='<%=short_desc%>'onblur="ena_loc_lookup(this);">
							<input type="hidden" name="clinic" id="clinic" value='<%=clinic_code%>' ><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup();" class='button'></td>
						<%}
					}else{ /*Below line Modified for this SCF [ML-BRU-SCF-0692]*/%>
						<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
						<td class='label'><input type='text' size='25' maxlength='25' name='b_loc_val' id='b_loc_val' value='<%=short_desc%>' onblur="ena_loc_lookup(this);"><input type="hidden" name="clinic" id="clinic" value='<%=clinic_code%>' ><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup();" class='button'></td>
					<%}
				}else { /*Below line Modified for this SCF [ML-BRU-SCF-0692]*/%>
					<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
					<td class='label'><input type='text'  size='25' maxlength='25' name='b_loc_val' id='b_loc_val' <%=locn_disable%> value='<%=locnDesc%>' onblur="ena_loc_lookup(this);"><input type="hidden" name="clinic" id="clinic" value='<%=locn_code%>'><input type='button'  name="b_loc_search" id="b_loc_search" value="?" <%=locn_disable%> onClick="open_loc_lookup();" class='button'></td>
				<%}%>
		</tr>	
		<%
			String tt_pract_name="";
			if(from_wait_list.equals("N") ){ 				
			String sql77="";
			if(callingMode.equals("OP") || module_id.equals("OA") || callingMode.equals("MR")|| callingMode.equals("OH")||callingMode.equals("RSCAPPT") ){
			//	resource_class="P";			
			if(!module_id.equals("OA"))resource_class="P"; 		
				  if(resource_class.equals("P")){
						sql77="select am_get_desc.am_practitioner(PRACTITIONER_ID,'"+locale+"',1) long_name from am_practitioner where  practitioner_id='"+op_practitioner+"'"; 							
				   }else if(resource_class.equals("R")){
						sql77="select am_get_desc.am_facility_room(OPERATING_FACILITY_ID,ROOM_NUM,'"+locale+"',1) long_name from am_facility_room where operating_facility_id = '"+facilityid+"' and room_num='"+op_practitioner+"' ";
					}else if(resource_class.equals("O")){
						sql77="select am_get_desc.am_resource(FACILITY_ID,RESOURCE_ID,'"+locale+"',1) long_name from am_resource where facility_id ='"+facilityid+"' and resource_id='"+op_practitioner+"' and resource_class='O' ";
					}else if(resource_class.equals("E")){
						sql77="select am_get_desc.am_resource(FACILITY_ID,RESOURCE_ID,'"+locale+"',1) long_name from am_resource where facility_id ='"+facilityid+"' and resource_id='"+op_practitioner+"' and resource_class='E' ";					
					}
					//Below Changes Done By Saanthaakumar Against CRF 34318	Bru-HIMS-CRF-0135 &&  CRF-PAS-Bru-HIMS-CRF-0135/01 ? OP Checkout - Book Appointment [IN:039854] 
					if(callingMode.equals("OP") && !primary_resource_class.equals("P")){
						op_practitioner = "";
					}
					if((resource_class.equals("P"))&& (primary_resource_class.equals("P"))){
						rs8=stmt8.executeQuery(sql77);
						if(rs8 !=null && rs8.next()){
							tt_pract_name=rs8.getString("long_name");
							 }
						 else
						 tt_pract_name="";
				    }
				resource_class="";
			}
		%>
				<tr id='resource_part'><jsp:include page="OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name ="from_page" value= "schedule_appt" />
				<jsp:param name ="pract_value" value= "<%=tt_pract_name%>" />
				<jsp:param name ="resourceId" value= "<%=resourceId%>" />
				<jsp:param name ="resourceDesc" value= "<%=resourceDesc%>" />			
				</jsp:include>
			<%}else{
				if(!direct_ip_practid.equals("")){						
					String sql77="";
					if(resource_class.equals("P")){
						sql77="select am_get_desc.am_practitioner(PRACTITIONER_ID,'"+locale+"',1) long_name from am_practitioner where practitioner_id='"+direct_ip_practid+"'";
					}else if(resource_class.equals("R")){
						sql77="select am_get_desc.am_facility_room(OPERATING_FACILITY_ID,ROOM_NUM,'"+locale+"',1) long_name from am_facility_room where operating_facility_id = '"+facilityid+"' and room_num='"+direct_ip_practid+"' ";
					}else if(resource_class.equals("O")){
						sql77="select am_get_desc.am_resource(FACILITY_ID,RESOURCE_ID,'"+locale+"',1) long_name from am_resource where facility_id ='"+facilityid+"' and resource_id='"+direct_ip_practid+"' and resource_class='O' ";
					}else if(resource_class.equals("E")){
						sql77="select am_get_desc.am_resource(FACILITY_ID,RESOURCE_ID,'"+locale+"',1) long_name from am_resource where facility_id ='"+facilityid+"' and resource_id='"+direct_ip_practid+"' and resource_class='E' ";
					
					}
					rs8=stmt8.executeQuery(sql77);
					rs8.next();
					tt_pract_name=rs8.getString("long_name");
				}
				
			%>
				<jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name ="from_page" value= "schedule_appt_diff" />
				<jsp:param name ="pract_value" value= "<%=tt_pract_name%>" />
				<jsp:param name ="pract_id" value= "<%=direct_ip_practid%>" />
				</jsp:include>
			<%}//end of else%>			
		</tr>
		<%if(customer_id.equals("SRR")||customer_id.equals("RTN")){
				String position_code="";
				String position_desc="";
				String positionSQL="select position_code,position_desc from am_position_lang_vw where language_id=? and eff_status='E' order by 2";
				pstmt = con.prepareStatement(positionSQL);
				pstmt.setString(1,locale);
				if(rs!=null)rs.close();
				rs=pstmt.executeQuery();
				%>
			<tr>
				<td class="label"><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
				<td  class="fields">
					<select name='position' id='position'>
						<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----
				<%
					while(rs!=null && rs.next()){
						position_code=rs.getString("position_code");
						position_desc=rs.getString("position_desc");
						if(position.equals(position_code)){
														%>
								<option value='<%=position_code%>' selected><%=position_desc%></option>
							<%
						}else{
							%>
								<option value='<%=position_code%>'><%=position_desc%></option>
							<%
						}
					}
					if(!addtl_splty.equals("")){
						if(pstmt!=null){
							pstmt.close();
						}
						if(rs!=null){
							rs.close();
						}
						StringTokenizer splty_token=null;
						StringBuffer addtl_spl=new StringBuffer("");
						String addtl_splty_1="";
						String addtl_splty_2="";
						if(!addtl_splty.equals("")){
							splty_token=new StringTokenizer(addtl_splty,",");
							if(splty_token.hasMoreTokens()){
								addtl_splty_1=splty_token.nextToken();
							}
							if(splty_token.hasMoreTokens()){
								addtl_splty_2=splty_token.nextToken();
							}
						}
						addtl_spl.append("select speciality_code,short_desc from am_speciality where speciality_code in('"+addtl_splty_1+"'");
						if(!addtl_splty_2.equals("")){
							addtl_spl.append(",'"+addtl_splty_2+"')");
						}else{
							addtl_spl.append(")");
						}
						
						pstmt = con.prepareStatement(addtl_spl.toString());
						rs=pstmt.executeQuery();
						int k=0;
						while(rs!=null && rs.next()){
							if(k==0){
								splty_desc=rs.getString("short_desc");
								splty_code=rs.getString("speciality_code");
							}else{
								splty_desc=splty_desc+","+rs.getString("short_desc");
								splty_code=splty_code+","+rs.getString("speciality_code");
							}
							k++;
						}
					}
				%>
				</select>
				</td>
				<td class='label'><input type='button' name='addtl_splty_button' id='addtl_splty_button' value='<fmt:message key="Common.Additional.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>' onClick="addtnl_splty()" class='BUTTON'></td>
				<td  class="fields"><input type='text' name="addtl_splty_text" id="addtl_splty_text" size='30' value="<%=splty_desc%>" readonly/></td>
			</tr>
			<%
				if(pstmt!=null){
					pstmt.close();
				}
				if(rs!=null){
					rs.close();
				}
			}%>
		<tr>
			<td  nowrap class="label"><fmt:message key="eOA.ShowSchAfter.label" bundle="${oa_labels}"/></td>
			<td  class="fields" nowrap>
			<%
				if(from_wait_list.equals("N")){%>
					<input type=text name='no_dwm' id='no_dwm' tabindex=0  style='text-align:right' size='2' maxlength='3'  onblur="CheckNum(this);calucalte_enddate(1);" value="<%=no_dwm%>" onKeyPress='return allowValidNumber(this,event,3,0)'></input>
					<select name='dwm_desc' id='dwm_desc' tabindex=0  onChange="calucalte_enddate(1);">
						<option name='day' value='D'><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
						<option name='day' value='W'><fmt:message key="Common.weeks.label" bundle="${common_labels}"/></option>
						<option name='day' value='M'><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
					</select> 
				<%}else{%>
					<input type=text name='no_dwm' id='no_dwm' tabindex=0  style='text-align:right' size='2' maxlength='3' disabled onblur="CheckNum(this);calucalte_enddate(1);" value="<%=no_dwm%>" onKeyPress='return allowValidNumber(this,event,3,0)'></input>
						<select name='dwm_desc' id='dwm_desc' tabindex=0  disabled onChange="calucalte_enddate(1);">
						<option name='day' value='D'><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
						<option name='day' value='W'><fmt:message key="Common.weeks.label" bundle="${common_labels}"/></option>
						<option name='day' value='M'><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
					</select> 
				<%}%>
			</td>																
			<td  class="label" nowrap id='pref_per'><fmt:message key="Common.preferredperiod.label" bundle="${common_labels}"/></td>
			<td  class="label"  nowrap ><input type=hidden name='prefdate_curr' id='prefdate_curr'  value="<%=pref_from_date %>">
			<input type="hidden" name="hddSpeciality" id="hddSpeciality" value="<%=speclty_Cd%>">
			<%	// added by jitesh for tracking entry from OP
				if(rs8 !=null)rs8.close();
				String quer_date="";

				String quer_date_end="";
				String disable="";
				if(callingMode.equals("OP") || module_id.equals("OA")|| callingMode.equals("OH")||callingMode.equals("RSCAPPT") ){
					quer_date=request.getParameter("recall_date") ==null?"":request.getParameter("recall_date");
					pref_from_date=quer_date;
					//THIS IS FOR GETTING end date based on start date from OP
					
					rs8=stmt8.executeQuery("select to_char(to_date('"+quer_date+"','dd/mm/yyyy') + 29,'dd/mm/yyyy')dat_val from dual");
					rs8.next();
					quer_date_end=rs8.getString("dat_val")==null?"":rs8.getString("dat_val");
				}
				if(callingMode.equals("OR")){
					quer_date=request.getParameter("recall_date") ==null?"":request.getParameter("recall_date");
					quer_date_end=quer_date;
					pref_from_date=quer_date;
				}
				if(callingMode.equals("MR")){
					quer_date=appt_date;
					quer_date_end=appt_date;
				}
				if(direct_ip.equals("Y")){
					quer_date=request.getParameter("recall_date")==null?"":request.getParameter("recall_date");
				}
				if(callingMode.equals("OP_RV")){
					quer_date=pref_from_date;
					quer_date_end=pref_from_date;
					disable = "disabled";
				}

				if(!quer_date_end_param.equals("")){
					quer_date_end=quer_date_end_param;
				}

				String quer_date_display =DateUtils.convertDate(quer_date,"DMY","en",locale);
			
				String quer_date_end_display =DateUtils.convertDate(quer_date_end,"DMY","en",locale);
			%>
			<% // To handle IP entry
				if(callingMode.equals("IP")){
					callingMode="OP";
					from_AE="Y";
				}
				session.putValue("CallMode",callingMode);
				
			%>
				<input type="hidden" name="fromTracker" id="fromTracker" value="<%=callingMode%>">
			<%  // Below Condition Changed Against Incident [IN:039954] By SaanthaakumarG
				if(!from_wait_list.equals("")){%>
					<span id='prevDateBtn'><img id='prevDateDiasbled' name='prevDateDiasbled' style="cursor:pointer;display:none" src="../../eCommon/images/PrevDisable.PNG" tabindex=0 /><img id='prevDate' name='prevDate' style="cursor:pointer;display:none" src="../../eCommon/images/Prev.PNG"  onClick="invokeRule(this)" /></span><input id="date_of_expiry" tabindex=0 type=text name='prefdate1' id='prefdate1' size='10' maxlength='10' value='<%=quer_date_display%>' <%=disable%> Onblur="DateCompare_from('from',this);validate_date_from(this,prefenddate1);"><img id='frm_img' style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" tabindex=0 onClick="return showCalendar('date_of_expiry',null);" <%=disable%> >&nbsp;<span id='date_of_expiry2_span'>-&nbsp;
					<input id="date_of_expiry2" tabindex=0 type=text name='prefenddate1' id='prefenddate1' size='10' maxlength='10' value='<%=quer_date_end_display%>' <%=disable%> Onblur='DateCompare_from("To",this);validate_date_to(this,prefdate1);'><img id='to_img' style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" tabindex=0 onClick="return showCalendar('date_of_expiry2',null);" <%=disable%> ></span><span id='nextDateBtn'><img id='nextDateDiasbled' name='nextDateDiasbled' style="cursor:pointer;display:none" src="../../eCommon/images/NextDisable.PNG" tabindex=0 /><img id='nextDate' name='nextDate' style="cursor:pointer;display:none" src="../../eCommon/images/Next.PNG"  onClick="invokeRule(this)" /></span><span id='timeID' style="visibility:hidden"><input type='text' name='From_timeval' id='From_timeval' value=''  size='3' maxlength='5' onBlur='CheckTime(this,"FM")' onKeyUp="javascript:formatTimePerPatient(this)" ><img id='prevTimePlusDisabled' name='prevTimePlusDisabled' style="cursor:pointer;vertical-align:top;display:none" src="../../eCommon/images/UpArrowDisable.PNG" tabindex=0 /><img id='prevTimeMinusDisabled' name='prevTimeMinusDisabled' style="cursor:pointer;vertical-align:bottom;position:relative;left:-10px;display:none" src="../../eCommon/images/DownArrowDisable.PNG" tabindex=0 /><img id='prevTimePlus' name='prevTimePlus' onClick="invokeRule(this)"style="cursor:pointer;vertical-align:top;display:none" src="../../eCommon/images/UpArrow.PNG" tabindex=0 /><img id='prevTimeMinus' name='prevTimeMinus' onClick="invokeRule(this)" style="cursor:pointer;vertical-align:bottom;position:relative;left:-10px;display:none" src="../../eCommon/images/DownArrow.PNG" tabindex=0 /> - <input type='text' name='To_timeval' id='To_timeval'   size='3' maxlength='5'  value='' onBlur='CheckTime(this,"TO")' onKeyUp="javascript:formatTimePerPatient(this)"><span id='nextTimeBtn'><img id='nextTimePlusDisabled' name='nextTimePlusDisabled' style="cursor:pointer;vertical-align:top;" src="../../eCommon/images/UpArrowDisable.PNG" tabindex=0 style="display:none"/><img id='nextTimeMinusDisabled' name='nextTimeMinusDisabled' style="cursor:pointer;vertical-align:bottom;position:relative;left:-10px;display:none" src="../../eCommon/images/DownArrowDisable.PNG" tabindex=0 /><img id='nextTimePlus' name='nextTimePlus' onClick="invokeRule(this)"style="cursor:pointer;vertical-align:top;display:none" src="../../eCommon/images/UpArrow.PNG" tabindex=0 /><img id='nextTimeMinus' name='nextTimeMinus' onClick="invokeRule(this)" style="cursor:pointer;vertical-align:bottom;position:relative;left:-10px;display:none" src="../../eCommon/images/DownArrow.PNG" tabindex=0 /></span><img src='../../eCommon/images/mandatory.gif' align='center'></img></span>
					<input type='hidden' name='prefdate' id='prefdate' size='10' maxlength='10' value='<%=quer_date%>'>
					<input type='hidden' name='prefenddate' id='prefenddate' size='10' maxlength='10' value='<%=quer_date_end%>' >
				<%}else{%>
					<%if(!quer_date.equals("")) {%>
						<span id='prevDateBtn' ><img id='prevDateDiasbled' name='prevDateDiasbled' style="cursor:pointer;display:none" src="../../eCommon/images/PrevDisable.PNG" tabindex=0 style="display:none"/><img id='prevDate' name='prevDate' style="cursor:pointer;display:none" src="../../eCommon/images/Prev.PNG"  onClick="invokeRule(this)" /></span><input id="date_of_expiry" tabindex=0 type=text name='prefdate1' id='prefdate1' disabled size='10' maxlength='10'  value="<%=quer_date_display%>" Onblur="DateCompare_from('from',this);validate_date_from(this,prefenddate1);"><img  id='frm_img' style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" disabled onClick="return showCalendar('date_of_expiry',null);">&nbsp;<span id='date_of_expiry2_span'>-&nbsp;
						<input id="date_of_expiry2" tabindex=0 type=text name='prefenddate1' id='prefenddate1' disabled size='10' maxlength='10'  value="<%=quer_date_display%>"  Onblur='DateCompare_from("To",this);validate_date_to(this,prefdate1);'><img id='to_img' style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" disabled onClick="return showCalendar('date_of_expiry2',null);" ></span><span id='nextDateBtn'><img id='nextDateDiasbled' name='nextDateDiasbled' style="cursor:pointer;display:none" src="../../eCommon/images/NextDisable.PNG" tabindex=0 /><img id='nextDate' name='nextDate' style="cursor:pointer;display:none" src="../../eCommon/images/Next.PNG"  onClick="invokeRule(this)" /><input type='button' name='prevTime' id='prevTime' value='Prev Time' onClick='invokeRule(this)' class='BUTTON' disabled /></span><span id='timeID' style="visibility:hidden"><input type='text' name='From_timeval' id='From_timeval' value=''  size='3' maxlength='5' onBlur='CheckTime(this,"FM")' onKeyUp="javascript:formatTimePerPatient(this)" > - <input type='text' name='To_timeval' id='To_timeval'   size='3' maxlength='5'  value='' onBlur='CheckTime(this,"TO")' onKeyUp="javascript:formatTimePerPatient(this)"><img src='../../eCommon/images/mandatory.gif' align='center'></img><span id='nextTimeBtn' style="display:none"><input type='button' name='nextTime' id='nextTime' value='Next Time' onClick='invokeRule(this)' class='BUTTON' disabled /></span></span>
					 <%}else{%>
						<span id='prevDateBtn' style="display:none"><img id='prevDateDiasbled' name='prevDateDiasbled' style="cursor:pointer;display:none" src="../../eCommon/images/PrevDisable.PNG" tabindex=0 /><img id='prevDate' name='prevDate' style="cursor:pointer;display:none" src="../../eCommon/images/Prev.PNG"  onClick="invokeRule(this)" /></span><input id="date_of_expiry" tabindex=0 type=text name='prefdate1' id='prefdate1' size='10' maxlength='10'  value="<%=quer_date_display%>" Onblur="DateCompare_from('from',this);validate_date_from(this,prefenddate1);"><img id='frm_img'  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" tabindex=0   onClick="return showCalendar('date_of_expiry',null);">&nbsp;<span id='date_of_expiry2_span'>-&nbsp;
						<input id="date_of_expiry2" tabindex=0 type=text name='prefenddate1' id='prefenddate1' size='10' maxlength='10'  value="<%=quer_date_display%>"  Onblur='DateCompare_from("To",this);validate_date_to(this,prefdate1);'><img id='to_img' style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" tabindex=0 onClick="return showCalendar('date_of_expiry2',null);" ></span><span id='nextDateBtn'><img id='nextDateDiasbled' name='nextDateDiasbled' style="cursor:pointer;display:none" src="../../eCommon/images/NextDisable.PNG" tabindex=0 /><img id='nextDate' name='nextDate' style="cursor:pointer;display:none" src="../../eCommon/images/Next.PNG"  onClick="invokeRule(this)" /></span><span id='prevTimeBtn' style="display:none"><input type='button' name='prevTime' id='prevTime' value='Prev Time' onClick='invokeRule(this)' class='BUTTON' disabled /></span><span id='timeID' style="visibility:hidden"><input type='text' name='From_timeval' id='From_timeval' value=''  size='3' maxlength='5' onBlur='CheckTime(this,"FM")' onKeyUp="javascript:formatTimePerPatient(this)" > - <input type='text' name='To_timeval' id='To_timeval'   size='3' maxlength='5'  value='' onBlur='CheckTime(this,"TO")' onKeyUp="javascript:formatTimePerPatient(this)"><img src='../../eCommon/images/mandatory.gif' align='center'></img><span id='nextTimeBtn' style="display:none"><input type='button' name='nextTime' id='nextTime' value='Next Time' onClick='invokeRule(this)' class='BUTTON' disabled /></span></span>
					 <%}%>
					<input type='hidden' name='prefdate' id='prefdate' size='10' maxlength='10' value='<%=quer_date%>'>
					<input type='hidden' name='prefenddate' id='prefenddate' size='10' maxlength='10' value='<%=quer_date_end%>' >
				<%}%>
			 </td>
		</tr>
		<tr>
			<td  class='label'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
			<td  class="fields" >
				<Select name="visittype" id="visittype" tabindex=0><Option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----
				<%
					StringBuffer sql10=new StringBuffer();
					sql10.append("select short_desc,visit_type_code from op_visit_type_lang_vw where facility_id='"+facilityid+"' and eff_status='E' and language_id='"+locale+"'");
					sql10.append(" order by short_desc");
					stmt9=con.createStatement();
					rs9=stmt9.executeQuery(sql10.toString());
					sql10=null;
					while(rs9.next()){
						short_desc=rs9.getString("short_desc");
						visit_type_code=rs9.getString("visit_type_code");
						if(visit_type_code.equals(visittype)){%>
							<option value='<%=visit_type_code%>' selected><%=short_desc%>
						<%}else {%>
							<option value='<%=visit_type_code%>'><%=short_desc%>
						<%}
					}				
				%>
				</Select>
			</td>
		<%
			if(install_yn_val.equals("Y")){%>
				<td class=label><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
				<td class=label ><input type=text name='or_catalogue_desc' id='or_catalogue_desc' size=30 onblur="clear_vals()"><input type='button' class='button' value='?' <%=disablePract%> name='search_or' onClick="callORSearch();"   tabindex=0><img src='../../eCommon/images/mandatory.gif' align='center' id='ordCatImg' style="visibility:hidden"></img>
				</td>
				<input type="hidden" name="or_catalogue_code" id="or_catalogue_code" value=<%=order_catalog_code%>>
			<%}else {%>
				<td class='label' colspan='2'>&nbsp;</td>
			<%}%>
		</tr>
<%
			if(rule_appl_yn.equals("Y")){
				StringBuffer termset_list_values=new StringBuffer();
				String TERM_SET_QRY="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE PROC_SPEC_YN='Y' AND EFF_STATUS='E' ORDER BY TERM_SET_DESC ASC";
				pstmt_ter=con.prepareStatement(TERM_SET_QRY);
				rs_ter=pstmt_ter.executeQuery();
				while(rs_ter.next()){
					termset_list_values.append("<option value='"+rs_ter.getString("TERM_SET_ID")+"'>"+rs_ter.getString("TERM_SET_DESC")+"</option><br>");
				}
				pstmt_ter.close();
				rs_ter.close();
			%>
		
		
		<tr>
		<td class="label" nowrap><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></td>
		<td class="fields"><select name="term_set_id" id="term_set_id" onchange='visibleProcCode(this);'>
								<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>	
								<%=termset_list_values.toString()%>	
							   </select>
		</td>
<%/*Below line changed for this SCF[ML-BRU-SCF-0692]*/%>
		<td  class="label" nowrap><label id="change_lookup_to"><fmt:message key="Common.ProcedureCode.label" bundle="${common_labels}"/></label></td>
		<td  class="label" ><input type="text" name="linking_desc" id="linking_desc" size='50' maxlength='50' onblur="getProcedurecode(linking_desc,linking_code)" disabled><input type="hidden" name="linking_code" id="linking_code" value=""><input type='button' name='link_lokup_btn' id='link_lokup_btn' value='?' onclick="getProcedurecode(linking_desc,linking_code)" disabled><img src='../../eCommon/images/mandatory.gif' align='center' id='PractProcImg' style="visibility:hidden"></img></td>
		</tr>
		<%}%>		
		<tr>
			<td class='button' colspan=4 align='right'><input type='button' tabindex=11 name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="fetchResult1();" class='BUTTON'>
			<input type='button' tabindex=12 name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick='clearFields()' class='BUTTON'>
			<!-- 	removed module_id.equals("OA") || -->
			<!-- 	ADDED callingMode.equals("CA") || -->
			<%				
			%>
			<input type=<%=(callingMode.equals("IP") || callingMode.equals("OR") || callingMode.equals("CA") ||  callingMode.equals("MR") || callingMode.equals("OP_RV") || module_id.equals("CA") || create_wait_list_yn.equals("N") || from_wait_list.equals("Y") || callingMode.equals("OH")||callingMode.equals("RSCAPPT") )?"hidden":"button"%> tabindex=12 name='CreateWlist' value='<fmt:message key="Common.CreateWaitList.label" bundle="${common_labels}"/>' onClick='showCreate()' class='BUTTON'  >

			<%//removed module_id.equals("OA")||
				if(callingMode.equals("OP") || callingMode.equals("IP")|| callingMode.equals("OH")||callingMode.equals("RSCAPPT")){%>
					<input type='button' tabindex=13 name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='exitval()' class='BUTTON'>
				<%}%>
			</td>									
		</tr>
	</table>
</table>
<input type='hidden' name='oper_stn_id' id='oper_stn_id' value=<%=oper_stn_id%> >
<input type='hidden' name='hidden_from_date' id='hidden_from_date' value=<%=pref_from_date %> >
<input type='hidden' name='ca_mode' id='ca_mode' value=<%=ca_mode %> >
<input type='hidden' name='ca_patient_id' id='ca_patient_id' value=<%=ca_patient_id %> >				
<input type='hidden' name='p_from' id='p_from'  value="" >
<input type='hidden' name='p_to' id='p_to'  value="" >
<input type='hidden' name='clinic1' id='clinic1' value="" >
<input type='hidden' name='practitioner1' id='practitioner1' value="" >
<input type='hidden' name='practitioner_type1' id='practitioner_type1' value="" >
<input type='hidden' name='speciality1' id='speciality1' value=""  >
<input type='hidden' name='visittype1' id='visittype1' value="" > 
<input type='hidden' name='facilityid' id='facilityid' value="<%=facilityid%>" > 
<input type='hidden' name='prefenddate2' id='prefenddate2' value="" > 
<input type='hidden' name='call_date_yn' id='call_date_yn' value="N" > 
<input type='hidden' name='practitioner_type' id='practitioner_type' value="" > 
<input type='hidden' name='start_sch_date' id='start_sch_date' value="" > 
<input type='hidden' name='callingMode' id='callingMode' value="<%=callingMode%>" > 
<input type='hidden' name='from_AE' id='from_AE' value="<%=from_AE%>" > 
<input type='hidden' name='passed_clinic' id='passed_clinic' value="<%=clnc_code%>" > 
<input type='hidden' name='from_wait_list' id='from_wait_list' value="<%=from_wait_list%>" > 
<input type='hidden' name='waitListNo' id='waitListNo' value="<%=waitListNo%>" >
<input type='hidden' name='order_category' id='order_category' value='<%=order_category%>'>
<input type='hidden' name='order_catalog_code' id='order_catalog_code' value='<%=order_catalog_code%>'>
<input type='hidden' name='order_id' id='order_id' value='<%=order_id%>'>
<input type='hidden' name='order_line_num' id='order_line_num' value='<%=order_line_num%>'>
<input type='hidden' name='specialty_codema1' id='specialty_codema1' value='<%=specialty_codema1%>'>
<input type='hidden' name='spe_or_value' id='spe_or_value' value='<%=code_val%>'>
<input type="hidden" name="speciality_op" id="speciality_op" value="<%=speclty_Cd%>">
<input type="hidden" name="speclty_Cd" id="speclty_Cd" value="<%=speclty_Cd%>">
<input type="hidden" name="resource_class" id="resource_class" value="<%=resource_class%>">					
<input type="hidden" name="care_locn_ind" id="care_locn_ind" value="<%=care_locn_ind%>">	
<input type="hidden" name="i_clinic_code" id="i_clinic_code" value="<%=i_clinic_code%>">
<input type="hidden" name="op_practitioner" id="op_practitioner" value="<%=op_practitioner%>">
<input type="hidden" name="req_id" id="req_id" value="<%=req_id%>">
<input type="hidden" name="install_yn_val" id="install_yn_val" value="<%=install_yn_val%>">
<input type="hidden" name="from_OR" id="from_OR" value="<%=from_OR%>">
<input type="hidden" name='create_wait_list_yn' id='create_wait_list_yn' value='<%=create_wait_list_yn%>'>
<input type="hidden" name='visit_flag_OP' id='visit_flag_OP' value='<%=visit_flag_OP%>'>
<input type="hidden" name='locale' id='locale' value='<%=locale%>'>
<input type="hidden" name='loc_type_OP' id='loc_type_OP' value='<%=loc_type_OP%>'>
<input type="hidden" name='tt_pract_name' id='tt_pract_name' value='<%=tt_pract_name%>'>
<input type="hidden" name='module_id' id='module_id' value='<%=module_id%>'>
<input type="hidden" name='dwm_desc_old' id='dwm_desc_old' value='<%=dwm_desc%>'>
<input type="hidden" name='from_page_new' id='from_page_new' value='<%=from_page%>'>
<input type="hidden" name='from_facility_id' id='from_facility_id' value='<%=from_facility_id%>'>
<input type="hidden" name='from_encounter_id' id='from_encounter_id' value='<%=from_encounter_id%>'>
<input type="hidden" name='web_request_yn' id='web_request_yn' value='<%=web_request_yn%>'>
<input type="hidden" name='direct_ip_practid' id='direct_ip_practid' value='<%=direct_ip_practid%>'>
<input type="hidden" name='calledFrom' id='calledFrom' value='<%=calledFrom%>'>
<input type="hidden" name='addtl_splty' id='addtl_splty' value="<%=splty_code%>">
<input type="hidden" name='or_cat_desc' id='or_cat_desc' value="<%=or_cat_desc%>">
<input type="hidden" name='rule_appl_yn' id='rule_appl_yn' value="<%=rule_appl_yn%>">
<input type="hidden" name='rd_oa_integration_yn' id='rd_oa_integration_yn' value="<%=rd_oa_integration_yn%>">
<input type="hidden" name='first_name_accept_yn' id='first_name_accept_yn' value="<%=first_name_accept_yn%>">
<input type="hidden" name='first_name_order' id='first_name_order' value="<%=first_name_order%>">
<input type="hidden" name='first_name_prompt' id='first_name_prompt' value="<%=first_name_prompt%>">
<input type="hidden" name='first_name_length' id='first_name_length' value="<%=first_name_length%>">

<input type="hidden" name='second_name_accept_yn' id='second_name_accept_yn' value="<%=second_name_accept_yn%>">
<input type="hidden" name='second_name_order' id='second_name_order' value="<%=second_name_order%>">
<input type="hidden" name='second_name_prompt' id='second_name_prompt' value="<%=second_name_prompt%>">
<input type="hidden" name='second_name_length' id='second_name_length' value="<%=second_name_length%>">

<input type="hidden" name='third_name_accept_yn' id='third_name_accept_yn' value="<%=third_name_accept_yn%>">
<input type="hidden" name='third_name_order' id='third_name_order' value="<%=third_name_order%>">
<input type="hidden" name='third_name_prompt' id='third_name_prompt' value="<%=third_name_prompt%>">
<input type="hidden" name='third_name_length' id='third_name_length' value="<%=third_name_length%>">

<input type="hidden" name='family_name_accept_yn' id='family_name_accept_yn' value="<%=family_name_accept_yn%>">
<input type="hidden" name='family_name_order' id='family_name_order' value="<%=family_name_order%>">
<input type="hidden" name='family_name_prompt' id='family_name_prompt' value="<%=family_name_prompt%>">
<input type="hidden" name='family_name_length' id='family_name_length' value="<%=family_name_length%>">
<input type="hidden" name='per_chk_cancld_past_appts' id='per_chk_cancld_past_appts' value="<%=per_chk_cancld_past_appts%>">
<input type="hidden" name='per_chk_cancld_fut_appts' id='per_chk_cancld_fut_appts' value="<%=per_chk_cancld_fut_appts%>">
<input type="hidden" name='per_chk_past_resch_appts' id='per_chk_past_resch_appts' value="<%=per_chk_past_resch_appts%>">
<input type="hidden" name='per_chk_fut_resch_appts' id='per_chk_fut_resch_appts' value="<%=per_chk_fut_resch_appts%>">
<input type="hidden" name='no_of_cancld_appts_for_alert' id='no_of_cancld_appts_for_alert' value="<%=no_of_cancld_appts_for_alert%>">
<input type="hidden" name='no_of_resch_appts_for_alert' id='no_of_resch_appts_for_alert' value="<%=no_of_resch_appts_for_alert%>">
<input type="hidden" name='per_chk_for_no_show_alert' id='per_chk_for_no_show_alert' value="<%=per_chk_for_no_show_alert%>">
<input type="hidden" name='no_of_noshow_appts_for_alert' id='no_of_noshow_appts_for_alert' value="<%=no_of_noshow_appts_for_alert%>">
<input type="hidden" name='mob_num_req_yn' id='mob_num_req_yn' value="<%=mob_num_req_yn%>">
<input type="hidden" name='no_of_fut_appts_for_alert' id='no_of_fut_appts_for_alert' value="<%=no_of_fut_appts_for_alert%>">
<input type="hidden" name='per_chk_for_fut_appts_alert' id='per_chk_for_fut_appts_alert' value="<%=per_chk_for_fut_appts_alert%>">

<input type="hidden" name='sys_time' id='sys_time' value="">
<input type="hidden" name='apptrefno' id='apptrefno' value="<%=apptrefno%>">
<input type="hidden" name='isAlertApplicableforBookAppt' id='isAlertApplicableforBookAppt' value="<%=isAlertApplicableforBookAppt%>"> <!-- added by mujafar for GHL-CRF-0527 -->
</form>
<%
}
	if(rs !=null)rs.close();
	if(rs1 !=null) rs1.close();
	if(rs2 !=null) rs2.close();
	if(rs3 !=null) rs3.close();
	if(rs5!=null) rs5.close();
	if(rs7!=null) rs7.close();
	if(rs8!=null) rs8.close();
	if(rs9!=null) rs9.close();
	if(rs11!=null) rs11.close();
	if(rs_or !=null) rs_or.close();
	if(stmt !=null) stmt.close();
	if(stmt1 !=null) stmt1.close();
	if(stmt3 !=null) stmt3.close();
	if(stmt5 !=null) stmt5.close();
	if(stmt7 !=null) stmt7.close();
	if(stmt8 !=null) stmt8.close();
	if(stmt9 !=null) stmt9.close();
	if(stmt11 !=null) stmt11.close();

}catch(Exception e ){
	e.printStackTrace();
}finally{	
	ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>
<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>


<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
   
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, webbeans.eCommon.*,java.util.*,com.ehis.util.*, eCommon.XSSRequestWrapper" %>

<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script type="text/javascript">
function close_window()
{
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}
</script>
		<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
				String waitlist_no=request.getParameter("waitlist_no");
				String elapsed=request.getParameter("elapsed");
				String facilityid=(String)session.getValue( "facility_id" ) ;
				String oper_stn_id=request.getParameter("oper_stn_id");
				String ALCN_CRITERIA_YN=request.getParameter("ALCN_CRITERIA_YN");
				if(ALCN_CRITERIA_YN ==null) ALCN_CRITERIA_YN="";
				String reason_for_modify=request.getParameter("reason_for_modify");
				if(reason_for_modify ==null) reason_for_modify="";
				String open_to_all_pract_yn_val="";
				String install_yn="N";
				String waitlist_category_appl_yn="";				 
				String waitlist_category_reqd_yn="";
				String restrict_wl_cat_agst_splty_yn="";

				install_yn = request.getParameter("install_yn");
				waitlist_category_appl_yn = request.getParameter("waitlist_category_appl_yn");
				waitlist_category_reqd_yn = request.getParameter("waitlist_category_reqd_yn");
				restrict_wl_cat_agst_splty_yn = request.getParameter("restrict_wl_cat_agst_splty_yn");

				String wait_list_ref_no=request.getParameter("wait_list_ref_no");
				if(wait_list_ref_no ==null) wait_list_ref_no="";
				
				Connection conn = null;
				Statement stmt=null;				 
				Statement stsql3=null;				 
				ResultSet rs1=null;
				ResultSet rssql3=null;
			 

				StringBuffer contactAddress=new StringBuffer();
				String dateofbirth_display="";
				String clinicshortdesc="";
				String practname="";
				String patientid="";
				String patientname="";
				String ETHNIC_GROUP_DESC="";
				String CLINIC_CODE="";
				String RACE_DESC="";
				String CITIZEN_YN="";
				String LEGAL_YN="";
				String BIRTH_PLACE_DESC="";
				String BIRTH_PLACE_DESCRIPTION="";
				String RES_AREA_CODE="";
				String RES_AREA_DESC="";
				String RES_TOWN_CODE="";	
				String RES_TOWN_DESC="";
				String RES_REGION_CODE="";
				String RES_REGION_DESC="";
				String RES_COUNTRY_CODE="";
				String RES_COUNTRY_NAME="";
				String MAIL_ADDR_LINE1="";
				String MAIL_ADDR_LINE2="";
				String MAIL_ADDR_LINE3="";
				String MAIL_ADDR_LINE4="";
				String MAIL_AREA_CODE="";
				String MAIL_AREA_DESC="";
				String MAIL_TOWN_CODE="";
				String MAIL_TOWN_DESC="";
				String MAIL_REGION_CODE="";
				String 	MAIL_REGION_DESC="";
				String MAIL_POSTAL_CODE="";
				String MAIL_COUNTRY_CODE="";
				String MAIL_COUNTRY_NAME="";
				String ALT_ID1_TYPE="";
				String ALT_ID1_NO="";
				String ALT_ID1_EXP_DATE="";
				String ALT_ID2_TYPE="";
				String ALT_ID2_NO="";
				String ALT_ID2_EXP_DATE="";
				String ALT_ID3_TYPE="";
				String ALT_ID3_NO="";
				String ALT_ID3_EXP_DATE="";
				String ALT_ID4_TYPE="";
				String ALT_ID4_NO="";
				String ALT_ID4_EXP_DATE="";
				String OTH_ALT_ID_TYPE="";
				String OTH_ALT_ID_NO="";
				String genderdesc="";
				String gender="";
				String restelno="";
				String othtelno="";
				String 	emailid="";
				String 	nationalid="";
				String 	resaddrl1="";
				String 	resaddrl2="";
				String 	resaddrl3="";
				String 	resaddrl4="";
				String 	postalcode="";
				String speciality="";
				String preferred_date="";
				String care_locn_type_desc="";
				String agey="";
				String agem="";
				String aged="";
				String dateofbirth="";
				 
				/*Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 Start*/
				String alt_addr_line1	= "";
				String alt_addr_line2	= "";
				String alt_addr_line3	= "";
				String alt_addr_line4	= "";
				String alt_postal_code  = "";
				String alt_postal_desc  = "";
				String alt_country_code = "";
				String alt_country_desc = "";
				String alt_area_code	= "";
				String alt_area_desc	= "";
				String alt_town_code	= "";
				String alt_town_desc	= "";
				String alt_region_code	= "";
				String alt_region_desc	= "";
				String res_postal_desc="";
				String mail_postal_desc="";
				boolean isAlternateAddressAppl = false;
				/*End*/
			 
				String others_id = ""; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

				String nat_id_prompt="";
				String modify_wait_list_yn="";
				String rd_waitlist_yn="";
				String nationality="";
				String Status="";
				String rsClass="";
				 
				 
				String care_locn_type_ind="";
				String practitioner_id="";
				String speciality_code="";
				String ALT_ID1_Desc="";
				String ALT_ID2_Desc="";
				String ALT_ID3_Desc="";
				String ALT_ID4_Desc="";
				String wtlt_category="";
				String waitlist_cat_one_desc="";
				String waitlist_cat_one_code="";				 
				String wait_list_priority_desc="";				 
				String order_catalog_code_val="";
				String ALT_ID1_EXP_DATE_display="";
				String ALT_ID2_EXP_DATE_display="";
				String ALT_ID3_EXP_DATE_display="";
				String ALT_ID4_EXP_DATE_display="";
				String preferred_date_display="";
				Properties p=(Properties)session.getValue("jdbc");
				String globaluser = (String)p.getProperty("login_user");
				String locale=(String)session.getAttribute("LOCALE");

				String reason_for_modify_disc="";
				String remarks_for_modify = ""; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

	%>

<%
try
{
		conn = ConnectionManager.getConnection(request);
		stmt=conn.createStatement();	
		StringBuffer sql=new StringBuffer();

		isAlternateAddressAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "MP","ALTERNATE_ADDRESS_APPLICABLE");//Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601

		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		HashMap hashdata	= eCommon.Common.CommonBean.getSiteSpecificDetails(conn, "OA","REMARKS_FOR_OTHERS");
		others_id	= (String)hashdata.get("value1");
		if(others_id == null) others_id = "";
		/*End ML-MMOH-CRF-1114*/

	 sql.append("select (decode(care_locn_type_ind, 'N', (IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, locn_code,'"+locale+"','1')), OP_GET_DESC.OP_CLINIC(FACILITY_ID, locn_code, '"+locale+"','1'))) clinic_short_desc, to_char(PREFERRED_DATE_TIME,'dd/mm/yyyy') preferred_date, WAIT_LIST_PRIORITY, WAIT_LIST_PRIORITY WAIT_LIST_PRIORITY_DESC, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') SPECIALITY_DESC, RESOURCE_CLASS, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(resource_id,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, resource_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, resource_id,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, resource_id,'"+locale+"','2'))  PRACTITIONER_SHORT_NAME, patient_id, name_prefix, first_name, second_name, third_name, family_name, name_suffix, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name, gender, to_char(date_of_birth,'dd/mm/yyyy') date_of_birth, MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GROUP_CODE,'"+locale+"','1') ETHNIC_GROUP_DESC, MP_GET_DESC.MP_RACE(RACE_CODE,'"+locale+"','1')RACE_DESC, CITIZEN_YN,LEGAL_YN, MP_GET_DESC.MP_BIRTH_PLACE(BIRTH_PLACE_CODE,'"+locale+"','1') BIRTH_PLACE_DESC, BIRTH_PLACE_DESC BIRTH_PLACE_DESCRIPTION, res_addr_line1, res_addr_line2, res_addr_line3, res_addr_line4, RES_AREA_CODE, MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','1')RES_AREA_DESC, RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','1') RES_TOWN_DESC, RES_REGION_CODE, MP_GET_DESC.MP_REGION(RES_REGION_CODE,'"+locale+"','1') RES_REGION_DESC, RES_COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(RES_COUNTRY_CODE,'"+locale+"','1') RES_COUNTRY_NAME, MAIL_ADDR_LINE1, MAIL_ADDR_LINE2, MAIL_ADDR_LINE3, MAIL_ADDR_LINE4, MAIL_AREA_CODE, MP_GET_DESC.MP_RES_AREA(MAIL_AREA_CODE,'"+locale+"','1') MAIL_AREA_DESC, MAIL_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(MAIL_TOWN_CODE,'"+locale+"','1') MAIL_TOWN_DESC, MAIL_REGION_CODE, MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+locale+"','1') MAIL_REGION_DESC, MAIL_POSTAL_CODE, MAIL_COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(MAIL_COUNTRY_CODE,'"+locale+"','1') MAIL_COUNTRY_NAME, alt_addr_line1, alt_addr_line2, alt_addr_line3, alt_addr_line4, alt_area_code, MP_GET_DESC.MP_RES_AREA(alt_area_code,'"+locale+"','1') alt_area_desc, alt_town_code, MP_GET_DESC.MP_RES_TOWN(alt_town_code,'"+locale+"','1') alt_town_desc, alt_region_code, MP_GET_DESC.MP_REGION(alt_region_code,'"+locale+"','1') alt_region_desc, alt_postal_code, MP_GET_DESC.mp_postal_code(alt_postal_code,'"+locale+"','2') alt_postal_desc, alt_country_code, MP_GET_DESC.MP_COUNTRY(alt_country_code,'"+locale+"','1') alt_country_desc, MP_GET_DESC.mp_postal_code(RES_POSTAL_CODE,'"+locale+"','2') postal_desc , MP_GET_DESC.mp_postal_code(MAIL_POSTAL_CODE,'"+locale+"','2') mail_postal_desc, ALT_ID1_TYPE, ALT_ID1_NO, to_char(ALT_ID1_EXP_DATE,'dd/mm/yyyy') ALT_ID1_EXP_DATE , ALT_ID2_TYPE, ALT_ID2_NO, to_char(ALT_ID2_EXP_DATE,'dd/mm/yyyy') ALT_ID2_EXP_DATE, ALT_ID3_TYPE, ALT_ID3_NO, to_char(ALT_ID3_EXP_DATE,'dd/mm/yyyy') ALT_ID3_EXP_DATE, ALT_ID4_TYPE, ALT_ID4_NO, to_char(ALT_ID4_EXP_DATE,'dd/mm/yyyy') ALT_ID4_EXP_DATE, OTH_ALT_ID_TYPE, OTH_ALT_ID_NO, email_id, oth_contact_no, res_tel_no, res_postal_code, national_id_no, AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_IND,'"+locale+"','1') care_locn_type_desc, calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1) year1, calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),2) month1, calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),3) day1, MP_GET_DESC.MP_COUNTRY(nationality_code,'"+locale+"','3')nationality, to_char(preferred_date_time,'hh24:mi') preferred_time, WAIT_LIST_STATUS, resource_class rsClass, CARE_LOCN_TYPE_IND, RESOURCE_ID PRACTITIONER_ID, SPECIALTY_CODE, (CASE WHEN pr_wait_list.waitlist_category_code IS NOT NULL THEN (SELECT long_desc FROM oa_waitlist_category_lang_vw WHERE waitlist_category_code = pr_wait_list.waitlist_category_code and language_id = '"+locale+"') END) WAITLIST_CAT_DESC, WAITLIST_CATEGORY_CODE, ORDER_CATALOG_CODE, LOCN_CODE CLINIC_CODE, (select nat_id_prompt from mp_param) nat_id_prompt, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID1_TYPE,'"+locale+"','1') alt_id1_desc, MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID2_TYPE,'"+locale+"','1') alt_id2_desc,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID3_TYPE,'"+locale+"','1') alt_id3_desc,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(ALT_ID4_TYPE,'"+locale+"','1') alt_id4_desc,AM_GET_DESC.AM_CONTACT_REASON(REASON_FOR_MODIFY,'"+locale+"','1')  REASON_FOR_MODIFY_DISC ,REASON_FOR_MODIFY,WAIT_LIST_REF_NO, REMARKS_FOR_MODIFY, (select MODIFY_WAIT_LIST_YN from AM_OS_USER_LOCN_ACCESS_VW where facility_id='"+facilityid+"' AND APPL_USER_ID='"+globaluser+"' AND LOCN_CODE='"+CLINIC_CODE+"' and OPER_STN_ID=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityid+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+globaluser+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)))) modify_wait_list_yn,rd_waitlist_yn ");//Modified by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114


	if(install_yn.equals("N")) {
		 sql.append("from pr_wait_list where facility_id='"+facilityid+"' and wait_list_no='"+waitlist_no+"'");
    } else {
		 sql.append(", (case when pr_wait_list.order_catalog_code is not null then (select long_desc from or_order_catalog where order_catalog_code = pr_wait_list.order_catalog_code) end) ORDER_CATALOG_DESC from pr_wait_list where facility_id='"+facilityid+"' and wait_list_no='"+waitlist_no+"'");
    }
	if (rs1!=null) rs1.close();		
	rs1=stmt.executeQuery(sql.toString());

		if(rs1.next())
		{
				nationality=rs1.getString("nationality");
				 if (nationality==null) nationality="";
				 waitlist_cat_one_desc=rs1.getString("WAITLIST_CAT_DESC");
				 if (waitlist_cat_one_desc==null) waitlist_cat_one_desc="";
				 waitlist_cat_one_code=rs1.getString("WAITLIST_CATEGORY_CODE");
				 if (waitlist_cat_one_code==null) waitlist_cat_one_code="";
				 if(install_yn.equals("Y")){
				 order_catalog_code_val=rs1.getString("ORDER_CATALOG_CODE");
				 if(order_catalog_code_val ==null)order_catalog_code_val="";
				 }
				rsClass=rs1.getString("rsClass");
				 if (rsClass==null) rsClass="";
				care_locn_type_ind=rs1.getString("care_locn_type_ind");
				 if (care_locn_type_ind==null) care_locn_type_ind="";
				 CLINIC_CODE=rs1.getString("CLINIC_CODE");
				 if(CLINIC_CODE ==null) CLINIC_CODE="";
				speciality_code=rs1.getString("SPECIALTY_CODE");
				 if (speciality_code==null) speciality_code="";
				practitioner_id=rs1.getString("PRACTITIONER_ID");
				 if (practitioner_id==null) practitioner_id="";
				
				Status=rs1.getString("WAIT_LIST_PRIORITY");
				 if (Status==null) Status="";
				wait_list_priority_desc=rs1.getString("WAIT_LIST_PRIORITY_DESC");
				 if(wait_list_priority_desc ==null) 
				{		 
				 wait_list_priority_desc="";
				}
				else
					if(wait_list_priority_desc.equals("U"))
						{
						wait_list_priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
						}else if(wait_list_priority_desc.equals("S"))
						{
						wait_list_priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.semiurgent.label","common_labels");
						}else if(wait_list_priority_desc.equals("N"))
						{
						wait_list_priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels");
						}
					if(install_yn.equals("Y")){
			    wtlt_category=rs1.getString("ORDER_CATALOG_DESC");
				if(wtlt_category ==null) wtlt_category="";
					}
				care_locn_type_desc=rs1.getString("care_locn_type_desc");
			     if (care_locn_type_desc==null) care_locn_type_desc="";
				agey=rs1.getString("year1");
				 if(agey==null)agey="";
				agem=rs1.getString("month1");
				 if(agem==null)agem="";
				aged=rs1.getString("day1");	  
				 if(aged==null)aged="";
				dateofbirth=rs1.getString("date_of_birth");
				 if (dateofbirth==null)
				dateofbirth="";
				  dateofbirth_display=DateUtils.convertDate(dateofbirth,"DMY","en",locale);
				speciality=rs1.getString("SPECIALITY_DESC");
				 if(speciality == null) speciality="";
				preferred_date=rs1.getString("preferred_date");
				 if(preferred_date == null) preferred_date="";
				 preferred_date_display=DateUtils.convertDate(preferred_date,"DMY","en",locale);
				clinicshortdesc=rs1.getString("clinic_short_desc");
				 if(clinicshortdesc == null) clinicshortdesc="";
				practname=rs1.getString("PRACTITIONER_SHORT_NAME");
				 if(practname == null) practname="";
				patientid=rs1.getString("patient_id");
				if(patientid == null) patientid="";
				patientname=rs1.getString("patient_name");
				 if(patientname == null) patientname="";
				ETHNIC_GROUP_DESC=rs1.getString("ETHNIC_GROUP_DESC");
				 if(ETHNIC_GROUP_DESC == null) ETHNIC_GROUP_DESC="";
				RACE_DESC=rs1.getString("RACE_DESC");
				 if(RACE_DESC == null) RACE_DESC="";
				CITIZEN_YN=rs1.getString("CITIZEN_YN");
				 if(CITIZEN_YN == null) CITIZEN_YN="";
				LEGAL_YN=rs1.getString("LEGAL_YN");
				 if(LEGAL_YN == null) LEGAL_YN="";
				BIRTH_PLACE_DESC=rs1.getString("BIRTH_PLACE_DESC");
				 if(BIRTH_PLACE_DESC == null) BIRTH_PLACE_DESC="";
				BIRTH_PLACE_DESCRIPTION=rs1.getString("BIRTH_PLACE_DESCRIPTION");
				 if(BIRTH_PLACE_DESCRIPTION == null) BIRTH_PLACE_DESCRIPTION="";
				 if(BIRTH_PLACE_DESC.equals(""))
				BIRTH_PLACE_DESC=BIRTH_PLACE_DESCRIPTION;
				RES_AREA_CODE=rs1.getString("RES_AREA_CODE");
				 if(RES_AREA_CODE == null) RES_AREA_CODE="";

				 
				rd_waitlist_yn=rs1.getString("rd_waitlist_yn")==null?"N":rs1.getString("rd_waitlist_yn");
				modify_wait_list_yn=rs1.getString("modify_wait_list_yn");
				  if(modify_wait_list_yn == null) modify_wait_list_yn="Y";

		
				 

				RES_AREA_DESC=rs1.getString("RES_AREA_DESC");
				 if(RES_AREA_DESC == null) RES_AREA_DESC="";
				
				
				RES_TOWN_CODE=rs1.getString("RES_TOWN_CODE");
				 if(RES_TOWN_CODE == null) RES_TOWN_CODE="";
				RES_TOWN_DESC=rs1.getString("RES_TOWN_DESC");
				 if(RES_TOWN_DESC == null) RES_TOWN_DESC="";
				RES_REGION_CODE=rs1.getString("RES_REGION_CODE");
				 if(RES_REGION_CODE == null) RES_REGION_CODE="";
				RES_REGION_DESC=rs1.getString("RES_REGION_DESC");
				 if(RES_REGION_DESC == null) RES_REGION_DESC="";
				RES_COUNTRY_CODE=rs1.getString("RES_COUNTRY_CODE");
				 if(RES_COUNTRY_CODE == null) RES_COUNTRY_CODE="";
				RES_COUNTRY_NAME=rs1.getString("RES_COUNTRY_NAME");
				 if(RES_COUNTRY_NAME == null) RES_COUNTRY_NAME="";
				MAIL_ADDR_LINE1=rs1.getString("MAIL_ADDR_LINE1");
				 if(MAIL_ADDR_LINE1 == null) MAIL_ADDR_LINE1="";
				MAIL_ADDR_LINE2=rs1.getString("MAIL_ADDR_LINE2");
				 if(MAIL_ADDR_LINE2 == null) MAIL_ADDR_LINE2="";
				MAIL_ADDR_LINE3=rs1.getString("MAIL_ADDR_LINE3");
				 if(MAIL_ADDR_LINE3 == null) MAIL_ADDR_LINE3="";
				MAIL_ADDR_LINE4=rs1.getString("MAIL_ADDR_LINE4");
				 if(MAIL_ADDR_LINE4 == null) MAIL_ADDR_LINE4="";
				MAIL_AREA_CODE=rs1.getString("MAIL_AREA_CODE");
				 if(MAIL_AREA_CODE == null) MAIL_AREA_CODE="";
				MAIL_AREA_DESC=rs1.getString("MAIL_AREA_DESC");
				 if(MAIL_AREA_DESC == null) MAIL_AREA_DESC="";
				MAIL_TOWN_CODE=rs1.getString("MAIL_TOWN_CODE");
				 if(MAIL_TOWN_CODE == null) MAIL_TOWN_CODE="";
				MAIL_TOWN_DESC=rs1.getString("MAIL_TOWN_DESC");
				 if(MAIL_TOWN_DESC == null) MAIL_TOWN_DESC="";
				MAIL_REGION_CODE=rs1.getString("MAIL_REGION_CODE");
				 if(MAIL_REGION_CODE == null) MAIL_REGION_CODE="";
				MAIL_REGION_DESC=rs1.getString("MAIL_REGION_DESC");
				 if(MAIL_REGION_DESC == null) MAIL_REGION_DESC="";
				MAIL_POSTAL_CODE=rs1.getString("MAIL_POSTAL_CODE");
				 if(MAIL_POSTAL_CODE == null) MAIL_POSTAL_CODE="";
				MAIL_COUNTRY_CODE=rs1.getString("MAIL_COUNTRY_CODE");
				 if(MAIL_COUNTRY_CODE == null) MAIL_COUNTRY_CODE="";
				MAIL_COUNTRY_NAME=rs1.getString("MAIL_COUNTRY_NAME");
				 if(MAIL_COUNTRY_NAME == null) MAIL_COUNTRY_NAME="";
				ALT_ID1_TYPE=rs1.getString("ALT_ID1_TYPE");
				 if(ALT_ID1_TYPE == null) ALT_ID1_TYPE="";
				ALT_ID1_NO=rs1.getString("ALT_ID1_NO");
				 if(ALT_ID1_NO == null) ALT_ID1_NO="";
				ALT_ID1_EXP_DATE=rs1.getString("ALT_ID1_EXP_DATE");
				 if(ALT_ID1_EXP_DATE == null) ALT_ID1_EXP_DATE="";
				ALT_ID2_TYPE=rs1.getString("ALT_ID2_TYPE");
				 if(ALT_ID2_TYPE == null) ALT_ID2_TYPE="";
				ALT_ID2_NO=rs1.getString("ALT_ID2_NO");
				 if(ALT_ID2_NO == null) ALT_ID2_NO="";
				ALT_ID2_EXP_DATE=rs1.getString("ALT_ID2_EXP_DATE");
				 if(ALT_ID2_EXP_DATE == null) ALT_ID2_EXP_DATE="";
				ALT_ID3_TYPE=rs1.getString("ALT_ID3_TYPE");
				 if(ALT_ID3_TYPE == null) ALT_ID3_TYPE="";
				ALT_ID3_NO=rs1.getString("ALT_ID3_NO");
				 if(ALT_ID3_NO == null) ALT_ID3_NO="";
				ALT_ID3_EXP_DATE=rs1.getString("ALT_ID3_EXP_DATE");
				 if(ALT_ID3_EXP_DATE == null) ALT_ID3_EXP_DATE="";
				ALT_ID4_TYPE=rs1.getString("ALT_ID4_TYPE");
				 if(ALT_ID4_TYPE == null) ALT_ID4_TYPE="";
				ALT_ID4_NO=rs1.getString("ALT_ID4_NO");
				 if(ALT_ID4_NO == null) ALT_ID4_NO="";
				ALT_ID4_EXP_DATE=rs1.getString("ALT_ID4_EXP_DATE");
				 if(ALT_ID4_EXP_DATE == null) ALT_ID4_EXP_DATE="";
				OTH_ALT_ID_TYPE=rs1.getString("OTH_ALT_ID_TYPE");
				 if(OTH_ALT_ID_TYPE == null) OTH_ALT_ID_TYPE="";
				OTH_ALT_ID_NO=rs1.getString("OTH_ALT_ID_NO");
				 if(OTH_ALT_ID_NO == null) OTH_ALT_ID_NO="";

				/*Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 Start*/
				alt_addr_line1		= checkForNull(rs1.getString("alt_addr_line1"));
				alt_addr_line2		= checkForNull(rs1.getString("alt_addr_line2"));
				alt_addr_line3		= checkForNull(rs1.getString("alt_addr_line3"));
				alt_addr_line4		= checkForNull(rs1.getString("alt_addr_line4"));
				alt_area_code		= checkForNull(rs1.getString("alt_area_code"));
				alt_area_desc		= checkForNull(rs1.getString("alt_area_desc"));
				alt_town_code		= checkForNull(rs1.getString("alt_town_code"));
				alt_town_desc		= checkForNull(rs1.getString("alt_town_desc"));
				alt_region_code		= checkForNull(rs1.getString("alt_region_code"));
				alt_region_desc		= checkForNull(rs1.getString("alt_region_desc"));
				alt_postal_code		= checkForNull(rs1.getString("alt_postal_code"));
				alt_postal_desc		= checkForNull(rs1.getString("alt_postal_desc"));
				alt_country_code	= checkForNull(rs1.getString("alt_country_code"));
				alt_country_desc	= checkForNull(rs1.getString("alt_country_desc"));
				mail_postal_desc	= checkForNull(rs1.getString("mail_postal_desc"));
				res_postal_desc			= checkForNull(rs1.getString("postal_desc"));
				/*End*/
				
				 reason_for_modify_disc=rs1.getString("REASON_FOR_MODIFY_DISC");
				 if(reason_for_modify_disc == null) reason_for_modify_disc="";
				 
				reason_for_modify=rs1.getString("REASON_FOR_MODIFY");
				 if(reason_for_modify == null) reason_for_modify="";
				 
				 /*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
				 remarks_for_modify = rs1.getString("REMARKS_FOR_MODIFY");
				 if(remarks_for_modify == null) remarks_for_modify = "";
				 /*End ML-MMOH-CRF-1114*/
				
                wait_list_ref_no=rs1.getString("WAIT_LIST_REF_NO");
				 if(wait_list_ref_no == null) wait_list_ref_no="";

				 gender=rs1.getString("gender");
				 if(gender.equals("M")) 
				{
					genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				}
				else if(gender.equals("F")) {
					genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				}
				else if(gender.equals("U")) {
					genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				}

				restelno=rs1.getString("res_tel_no");
				if (restelno==null)
				restelno="";
				othtelno=rs1.getString("oth_contact_no");
				if(othtelno==null)
				othtelno="";
				emailid=rs1.getString("email_id");
				if(emailid==null)
				emailid="";
				nationalid=rs1.getString("national_id_no");
				if(nationalid == null) nationalid="";
				nat_id_prompt=rs1.getString("nat_id_prompt");
				if (nat_id_prompt == null) nat_id_prompt="National Id No.";
		 
				 ALT_ID1_Desc=rs1.getString("alt_id1_desc");
					 ALT_ID2_Desc=rs1.getString("alt_id2_desc");
					 ALT_ID3_Desc=rs1.getString("alt_id3_desc");
					 ALT_ID4_Desc=rs1.getString("alt_id4_desc");
					 if (ALT_ID1_Desc==null) ALT_ID1_Desc="";
					 if (ALT_ID2_Desc==null) ALT_ID2_Desc="";
					 if (ALT_ID3_Desc==null) ALT_ID3_Desc="";
					 if (ALT_ID4_Desc==null) ALT_ID4_Desc="";
					 ALT_ID1_Desc=ALT_ID1_Desc.trim();
					 ALT_ID2_Desc=ALT_ID2_Desc.trim();
					 ALT_ID3_Desc=ALT_ID3_Desc.trim();
					 ALT_ID4_Desc=ALT_ID4_Desc.trim();


					 resaddrl1=rs1.getString("res_addr_line1");
				if(resaddrl1 == null) resaddrl1="";
				resaddrl2=rs1.getString("res_addr_line2");
				if(resaddrl2 == null) resaddrl2="";
				resaddrl3=rs1.getString("res_addr_line3");
				if(resaddrl3 == null) resaddrl3="";
				resaddrl4=rs1.getString("res_addr_line4");
				if(resaddrl4 == null) resaddrl4="";
				postalcode=rs1.getString("res_postal_code");
				if(postalcode == null) postalcode="";

				contactAddress.append(""+"^^");
				contactAddress.append(resaddrl1+"^^");
				contactAddress.append(resaddrl2+"^^");
				contactAddress.append(resaddrl3+"^^");
				contactAddress.append(resaddrl4+"^^");
				contactAddress.append(RES_TOWN_CODE+"^^");
				contactAddress.append(RES_AREA_CODE+"^^");
				
				contactAddress.append(postalcode+"^^");
				contactAddress.append(RES_REGION_CODE+"^^");
				contactAddress.append(RES_COUNTRY_CODE+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(MAIL_ADDR_LINE1+"^^");
				contactAddress.append(MAIL_ADDR_LINE2+"^^");
				contactAddress.append(MAIL_ADDR_LINE3+"^^");
				contactAddress.append(MAIL_ADDR_LINE4+"^^");
				contactAddress.append(MAIL_TOWN_CODE+"^^");
				contactAddress.append(MAIL_AREA_CODE+"^^");
				contactAddress.append(MAIL_POSTAL_CODE+"^^");
				contactAddress.append(MAIL_REGION_CODE+"^^");
				contactAddress.append(MAIL_COUNTRY_CODE+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(restelno+"^^");
				contactAddress.append(othtelno+"^^");
				contactAddress.append(emailid+"^^");
				contactAddress.append(""+"^^");
				contactAddress.append(RES_TOWN_DESC+"^^");
				contactAddress.append(RES_AREA_DESC+"^^");
				contactAddress.append(RES_REGION_DESC+"^^");
				contactAddress.append(MAIL_TOWN_DESC+"^^");
				contactAddress.append(MAIL_AREA_DESC+"^^");
				contactAddress.append(MAIL_REGION_DESC+"^^");
				//contactAddress.append(MAIL_COUNTRY_NAME+"^^");
				//contactAddress.append(RES_COUNTRY_NAME+"^^");
				/*Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 Start*/
				contactAddress.append(RES_COUNTRY_NAME+"^^");
				contactAddress.append(MAIL_COUNTRY_NAME+"^^");
				contactAddress.append(res_postal_desc+"^^");
				contactAddress.append(mail_postal_desc+"^^");
				contactAddress.append(alt_addr_line1+"^^");
				contactAddress.append(alt_addr_line2+"^^");
				contactAddress.append(alt_addr_line3+"^^");
				contactAddress.append(alt_addr_line4+"^^");
				contactAddress.append(alt_town_code+"^^");
				contactAddress.append(alt_area_code+"^^");
				contactAddress.append(alt_postal_code+"^^");
				contactAddress.append(alt_region_code+"^^");
				contactAddress.append(alt_country_code+"^^");
				contactAddress.append(alt_town_desc+"^^");
				contactAddress.append(alt_area_desc+"^^");
				contactAddress.append(alt_postal_desc+"^^");
				contactAddress.append(alt_region_desc+"^^");
				contactAddress.append(alt_country_desc);
				/*End*/

		if(!ALT_ID1_EXP_DATE.equals(""))
	{
	 ALT_ID1_EXP_DATE_display=DateUtils.convertDate(ALT_ID1_EXP_DATE,"DMY","en",locale);
	}
	if(!ALT_ID2_EXP_DATE.equals(""))
	{
	 ALT_ID2_EXP_DATE_display=DateUtils.convertDate(ALT_ID2_EXP_DATE,"DMY","en",locale);
	}
	if(!ALT_ID3_EXP_DATE.equals(""))
	{
	 ALT_ID3_EXP_DATE_display=DateUtils.convertDate(ALT_ID3_EXP_DATE,"DMY","en",locale);
	}
	if(!ALT_ID4_EXP_DATE.equals(""))
	{
	 ALT_ID4_EXP_DATE_display=DateUtils.convertDate(ALT_ID4_EXP_DATE,"DMY","en",locale);
	}
}
	 
	if(modify_wait_list_yn.equals("N")) {
	%>
		<script>
		alert(getMessage('OPER_STN_FUNC_RESTRN','OA'));
		window.close();
		</script>
 <%}
		if (rs1!=null) rs1.close();
			if (stmt !=null) stmt.close();
		 
			stsql3=conn.createStatement();
			StringBuffer sql3=new StringBuffer();
			if (!care_locn_type_ind.equals("N"))
			{
					 sql3.append("Select a.long_desc long_desc, a.clinic_code clinic_code, a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn from op_clinic_lang_vw a , AM_OS_USER_LOCN_ACCESS_VW b  where a.facility_id='"+facilityid+"' and a.speciality_code='"+speciality_code+"' and a.facility_id=b.facility_id and b.oper_stn_id='"+oper_stn_id+"'  AND a.clinic_code=b.locn_code AND b.appl_user_id='"+globaluser+"' AND b.MODIFY_WAIT_LIST_YN='Y' and clinic_code='"+CLINIC_CODE+"' and ");

					  if(care_locn_type_ind.equals("D")){
						  sql3.append(" clinic_type='Y' ");

					  }else{
						  sql3.append(" clinic_type='"+care_locn_type_ind+"' ");

					  }
					 sql3.append(" and CARE_LOCN_TYPE_IND='"+care_locn_type_ind+"' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"'  and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' and a.clinic_type=b.locn_type and language_id = '"+locale+"' order by a.long_desc");
			}
			else if (care_locn_type_ind.equals("N"))
			{
				// modified on 22 mar 2010 to handle the ursing unit flow
				//sql3.append("Select a.long_desc long_desc, a.NURSING_UNIT_CODE clinic_code from IP_Nursing_unit_lang_vw a , AM_OS_USER_LOCN_ACCESS_VW b, ip_nurs_unit_for_specialty c  where B.locn_type = 'N' and a.facility_id='"+facilityid+"' and a.facility_id = b.facility_id and a.NURSING_UNIT_CODE=b.locn_code and b.oper_stn_id='"+oper_stn_id+"'  AND A.EFF_STATUS = 'E' and c.SPECIALTY_CODE='"+speciality_code+"' and c.NURSING_UNIT_CODE=a.NURSING_UNIT_CODE and c.facility_id='"+facilityid+"' AND b.appl_user_id='"+globaluser+"'  and clinic_code='"+CLINIC_CODE+"' AND b.MODIFY_WAIT_LIST_YN='Y' and language_id = '"+locale+"' order by a.long_desc");

				sql3.append("Select a.long_desc long_desc, a.NURSING_UNIT_CODE clinic_code from IP_Nursing_unit_lang_vw a , AM_OS_USER_LOCN_ACCESS_VW b, ip_nurs_unit_for_specialty c  where B.locn_type = 'N' and a.facility_id='"+facilityid+"' and a.facility_id = b.facility_id and a.NURSING_UNIT_CODE=b.locn_code and b.oper_stn_id='"+oper_stn_id+"'  AND A.EFF_STATUS = 'E' and c.SPECIALTY_CODE='"+speciality_code+"' and c.NURSING_UNIT_CODE=a.NURSING_UNIT_CODE and c.facility_id='"+facilityid+"' AND b.appl_user_id='"+globaluser+"'  and a.NURSING_UNIT_CODE='"+CLINIC_CODE+"' AND b.MODIFY_WAIT_LIST_YN='Y' and language_id = '"+locale+"' order by a.long_desc");
			}
				%>

				<html>
				<head>
				
				 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

				<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
				<Script src="../../eOA/js/Validate.js" language="JavaScript"></Script>
				<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
				<script src='../../eCommon/js/common.js' language='javascript'></script>
				<script src='../../eCommon/js/dchk.js' language='javascript'></script>
				<script src='../../eOA/js/WaitListMgmt.js' language='javascript'></script>
				<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
				<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
				<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
				<head>
				<!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
				<body onload='enable_category_gif2();displayRemarksForOtherReason(document.forms[0].reason_modify_code);' OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >
				<form name="recur_day_results" id="recur_day_results" method="post">

 <table border='0' cellpadding='3' cellspacing='0' width='98%' align='center' valign='top' >
				
	<tr>
				<td class='COLUMNHEADER' colspan='4'><fmt:message key="eOA.WaitListApptDetails.label" bundle="${oa_labels}"/></td>
	</tr>
	

	<tr>
			<td class='label'  nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
			
			<td  class='QUERYDATA'  nowrap><%=speciality%></td>
			
					<%if(waitlist_category_appl_yn.equals("Y")) {%>
				
			<td class='label'   nowrap ><fmt:message key="eOA.WaitlistCategory.label" bundle="${oa_labels}"/></td>

			<td class='fields'  nowrap>
				<input type='text'  name='walst_category' id='walst_category'   onblur='open_lookup_one();' value='<%=waitlist_cat_one_desc%>' size='20' maxlength='20'><input type='button' class='BUTTON' name='walst_cate_search' id='walst_cate_search' value='?' onClick='open_lookup();'><img align=center src='../../eCommon/images/mandatory.gif' id='wait_lst_cat' style='visibility:hidden'></img></td>
				
								
						<%}else {%>
			<td class='label'  colspan='2'>&nbsp;</td>
						<%}%>


    </tr>
	<tr>

			<%
			if(install_yn.equals("Y"))
			{ %>

				<td class='label' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
				
				<td class='fields'>					
					<input type=text name='or_catalogue_desc' id='or_catalogue_desc' <%=elapsed.equals("Y")?"disabled":""%>size=20 onblur="clear_vals()"><input type='button' class='button' value='?' <%=elapsed.equals("Y")?"disabled":""%> name='search_or' onClick="callORSearch();" tabindex=0>
					<input type="hidden" name="or_catalogue_code" id="or_catalogue_code" value='<%=order_catalog_code_val%>'>
				</td>

		<%} else {%>
				<td class='label' colspan='2'>&nbsp;</td>
		<%}%>
				<td class='label' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>

    			<td  class='QUERYDATA' nowrap><%=wait_list_priority_desc%></td> 
	</tr>
	
	<tr>
				<td class='label' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
				
				<td align='left' class='QUERYDATA' nowrap><%=care_locn_type_desc%></td>
				

				<td class='label' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				
				<td class='fields'>	
				 
				
						<%				
							
						 rssql3=stsql3.executeQuery(sql3.toString());	
				
						if (rssql3!=null)
						{
							String clinicDes="";
							String clinicCd="";
							String open_to_all_pract_yn="";
							//String sel="";
							if(rssql3.next())
							{
								clinicDes=rssql3.getString("long_desc");

								clinicCd=rssql3.getString("clinic_code");
								if ( !care_locn_type_ind.equals("N"))
								{						   
									open_to_all_pract_yn=rssql3.getString("open_to_all_pract_yn");
								}else{
									  open_to_all_pract_yn="*";
								}
								
								
							open_to_all_pract_yn_val=open_to_all_pract_yn+"|"+clinicCd+"|"+care_locn_type_ind;
							}
						}%>
					<input type='text' size='25' maxlength='25' name='b_loc_val' id='b_loc_val' value='<%=clinicshortdesc%>' onblur="ena_loc_lookup1(this);"><input type="hidden" name="clinic_code" id="clinic_code" value='<%=open_to_all_pract_yn_val%>' ><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup1();" class='button'>
					</td>
	</tr>
	<tr>
      				<td class='label' nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
					
					<td id='pract_type1' width='5%' class='QUERYDATA' nowrap></td>
<% if (elapsed.equals("Y")) {%>
<td class='label' nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>

					<td  class='QUERYDATA' nowrap >
					<input type=hidden name='resourceType1' id='resourceType1' value=''>
                    <input type='text' name='practitioner_name' id='practitioner_name' size='30' value="<%=practname%>" disabled  tabindex=2><input type=button class='button' value='?' name='search_pract' id='search_pract' disabled ></td>
<%}else {%>
					<jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name ="from_page" value= "wait_list_modify" />
					<jsp:param name ="pract_value" value= "<%=practname%>" />
					<jsp:param name ="pract_id" value= "<%=practitioner_id%>" />
					</jsp:include>
					<%}%>
						
					<!-- <td class='label' nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>

					<td  class='QUERYDATA' nowrap >
					<input type=hidden name='rsClass' id='rsClass' value=''>
                    <input type='text' name='b_pract_name' id='b_pract_name' size='30' value="<%=practname%>" onblur="onblurcheck(this,b_pract_name);" tabindex=2><input type=button class='button' value='?' name='b_pract_butt' id='b_pract_butt' onclick='callPractSearch1(this,b_pract_name)' <%=elapsed.equals("Y")?"disabled":""%>></td> -->

				
	</tr>
    				
					
	
	<tr>
					<td class='label'  nowrap><fmt:message key="Common.waitlistno.label" bundle="${common_labels}"/></td>
    				
					<td class='QUERYDATA' nowrap><%=waitlist_no%></td>
						
			  	<td class='label' nowrap ><%=elapsed.equals("Y")?"Prev Pref ":"Preferred "%><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
					
					
					<td class='QUERYDATA' nowrap>
						
			

						<input name='preferred_date' id='preferred_date' id='pref_date' size='10' maxlength='10' value='<%=preferred_date_display%>' onBlur='validatePrefDate_new(this);' tabindex=3><img  style="cursor:pointer" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('pref_date',null);">
					</td>
			

					
	</tr>
					
	
										
	<tr>
					<td class='label' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
					
					<td class='QUERYDATA' nowrap>
							
						<select name='status' id='status' tabindex=4 <%=elapsed.equals("Y")?"disabled":""%>>
						<option value=''> -- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --</option>
						<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
						<option value='S'><fmt:message key="Common.semiurgent.label" bundle="${common_labels}"/></option>
						<option value='N'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
						</select><img name='mandatory1' src='../../eCommon/images/mandatory.gif'></td>
							
					<td class='label' nowrap></td>
					
					<td  class='QUERYDATA' nowrap></td>
					
													
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr>
<td  class=label width="38%"  ><fmt:message key="Common.referenceno.label" bundle="${common_labels}"/></td>
<td width="3%" ><input type='textbox' name='wait_list_ref_no' id='wait_list_ref_no' value="<%=wait_list_ref_no%>" size='15' maxlength='12' onKeyPress='return(ChkNumberInput1(this,event,0));'  ></td>
<td>&nbsp;</td>
</tr>
<tr><td>&nbsp;</td></tr>
	
						
	<tr>
				<td class='COLUMNHEADER' colspan ='4'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
							
	</tr>
		
	<tr>
				<td class='label' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
							
				<td class='QUERYDATA' nowrap><%=patientid%></td>

							
				<td class='label' nowrap><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
							
				<td class='QUERYDATA' nowrap><%=patientname%></td>
							
	</tr>

				


	<tr>
				
				<td class='label' nowrap ><%=nat_id_prompt%></td>
				
				<td  class='QUERYDATA' ><%=nationalid%></td>
				
				<td class='label' colspan='2'>&nbsp;</td>
		
	</tr>



	<tr>
	
				<td class='label'  nowrap><%=(ALT_ID1_Desc.replace('.',' ')).trim()%></td>
				
				<td class='QUERYDATA' nowrap><%=ALT_ID1_NO%></td>
			
				<td class='label'  nowrap><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
							
				<td class='QUERYDATA' nowrap><%=ALT_ID1_EXP_DATE_display%></td>
					
		
	</tr>
							
	
							
	<tr>
				<td class='label' nowrap><%=ALT_ID2_Desc%></td>
						
				<td class='QUERYDATA' nowrap><%=ALT_ID2_NO%></td>

			
				<td class='label' nowrap><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
								
				<td class='QUERYDATA' nowrap><%=ALT_ID2_EXP_DATE_display%></td>
					
			
	</tr>
	
	<tr>
				
				<td class='label'  nowrap><%=ALT_ID3_Desc%></td>
				
				<td class='QUERYDATA' nowrap><%=ALT_ID3_NO%></td>

				<td  class='label' nowrap><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
				
				<td class='QUERYDATA' nowrap ><%=ALT_ID3_EXP_DATE_display%></td>
				
			
	</tr>
	
			
	<tr>
			
				<td class='label' nowrap><%=ALT_ID4_Desc%></td>
				
				<td class='QUERYDATA' nowrap><%=ALT_ID4_NO%></td>

				
				<td class='label' nowrap><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
				
				<td class='QUERYDATA' nowrap><%=ALT_ID4_EXP_DATE_display%></td>
				
				
	</tr>		
	
	<tr>		
				<td class='label'  nowrap><fmt:message key="Common.OtherAltType.label" bundle="${common_labels}"/></td>
				
				<td  class='QUERYDATA' nowrap ><%=OTH_ALT_ID_TYPE%></td>

				<td class='label'  nowrap><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>
				
				<td  class='QUERYDATA' nowrap ><%=OTH_ALT_ID_NO%></td>

					
				 
	</tr>
								
	
	<tr>
				<td class='label' nowrap ><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/></td>
	
				<td class='QUERYDATA' ><%=BIRTH_PLACE_DESC%></td>
					
				<td class="label"  nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
							
				<td class='QUERYDATA' nowrap><%=genderdesc%></td>


	</tr>				

	
	<tr>
							
				<td class='label'  nowrap><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
							
				<td class='QUERYDATA' nowrap><%=agey%>Y&nbsp;<%=agem%>M&nbsp;<%=aged%>D&nbsp;</td>

							
				<td class='label' nowrap><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
							
				<td class='QUERYDATA' nowrap><%=dateofbirth_display%></td>
	</tr>
				
				
			


	<tr>
			<td class='label' nowrap ><fmt:message key="Common.residency.label" bundle="${common_labels}"/></td>
		
			<td class='QUERYDATA' >
					<%if(CITIZEN_YN.equals("Y")){%>
						<fmt:message key="Common.citizen.label" bundle="${common_labels}"/>
					<%}else{%>
						<fmt:message key="Common.noncitizen.label" bundle="${common_labels}"/>
					<%}%>
			</td>
				

			<td class='label'  nowrap ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				
			<td class='QUERYDATA' >
					<%if(LEGAL_YN.equals("Y")){%>
						<fmt:message key="Common.legal.label" bundle="${common_labels}"/>
					<%}else{%>
						<fmt:message key="Common.illegal.label" bundle="${common_labels}"/>
					<%}%>	
			</td>
	<tr>

			<td class='label' nowrap ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
				
			<td class='QUERYDATA' ><%=nationality%></td>


			<td class='label'  nowrap ><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
	
			<td class='QUERYDATA' nowrap ><%=RACE_DESC%></td>

	</tr>

	<tr>
				
				<td class='label' nowrap><fmt:message key="eMP.ethnicity.label" bundle="${mp_labels}"/></td>
	
				<td class='QUERYDATA' nowrap><%=ETHNIC_GROUP_DESC%></td>

				<td class='button' nowrap colspan='2' align="right"><input type='button' name='ContactDetails' id='ContactDetails' value='<fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/>' onClick='Modal_Contact_Details()' class="BUTTON" ></td>
	</tr>

				


			
<tr> 
				<td  class='label'  nowrap ><fmt:message key="eOA.ReasonforModification.label" bundle="${oa_labels}"/></td>	
				
				<td  class='fields' nowrap>	
				<!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
				<input type=text name='reason_modify' id='reason_modify' size=20 onblur="open_lookup_modify();displayRemarksForOtherReason(reason_modify_code);" value="<%=reason_for_modify_disc%>"><input type='button' class='button' value='?' name='search_or' id='search_or' onClick="open_lookup_two();displayRemarksForOtherReason(reason_modify_code);"   tabindex=0>
				<input type="hidden" name="reason_modify_code" id="reason_modify_code" value="<%=reason_for_modify%>"><img align=center src='../../eCommon/images/mandatory.gif' id='reason_code' ></img></td>

				<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
				<td class=label id='remarks_labl' style='visibility:hidden'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
				<td class="fields" id='remarks_fld' style='visibility:hidden'><textarea rows=2 cols=45 name="other_remarks" onkeyPress='checkMaxLimit(this,100)' onBlur="SPCheckMaxLen('Remarks',this,100)"><%=remarks_for_modify%></textarea><img src='../../eCommon/images/mandatory.gif' id='remarks_img' style='visibility:hidden'></td>
				<!--End ML-MMOH-CRF-1114-->
</tr>
<tr>
				<td class='label' colspan=2>&nbsp;</td>
				
				<td class='button' colspan=2 align="right">
					
				<input type='button' class='button' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>'  name='select' onClick='modifyWiatListappt()' style= 'height:4vh;width:10vw' >
				
				<input type='button' name='reviseclose' id='reviseclose' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="BUTTON" onclick='close_window()' style= 'height:4vh;width:10vw' >
				</td>
</tr>	
</table>
				

	<%
	 
	 
		if (rssql3 !=null) rssql3.close();
		if (rs1!=null) rs1.close();	 
		if (stsql3!=null) stsql3.close();	 
		if (stmt !=null) stmt.close();
}catch(Exception ex){
	//out.println("exception is "+ ex);
	ex.printStackTrace();
}finally{
			if (stmt!=null) stmt.close();
		    ConnectionManager.returnConnection(conn,request);
}

%>
<input type="hidden" name="facilityid" id="facilityid" value="<%=facilityid%>">
<input type="hidden" name="waitlist_no" id="waitlist_no" value="<%=waitlist_no%>">
<input type=hidden name='statusCriteria' id='statusCriteria' value='<%=Status%>'>
<input type='hidden' name='concat_address_hidden' id='concat_address_hidden' value="<%=contactAddress.toString()%>">	
<input type=hidden name='resClass' id='resClass' value='<%=rsClass%>'>
<input type=hidden name='b_pract' id='b_pract' value='<%=practitioner_id%>'>
<input type=hidden name='locn_type' id='locn_type' value='<%=care_locn_type_ind%>'>
<input type=hidden name='elapsed' id='elapsed' value='<%=elapsed%>'>
<input type=hidden name='speciality_code' id='speciality_code' value='<%=speciality_code%>'> 
<input type=hidden name='speciality' id='speciality' value='<%=speciality_code%>'> 
<input type=hidden name='walst_category_code' id='walst_category_code' value='<%=waitlist_cat_one_code%>'>
<input type=hidden name='wtlt_category' id='wtlt_category' value='<%=wtlt_category%>'>
<input type=hidden name='waitlist_category_appl_yn' id='waitlist_category_appl_yn' value='<%=waitlist_category_appl_yn%>'>
<input type=hidden name='waitlist_category_reqd_yn' id='waitlist_category_reqd_yn' value='<%=waitlist_category_reqd_yn%>'>
<input type=hidden name='restrict_wl_cat_agst_splty_yn' id='restrict_wl_cat_agst_splty_yn' value='<%= restrict_wl_cat_agst_splty_yn%>'>
<input type=hidden name='cnt' id='cnt' value=''>
<input type=hidden name='patientid' id='patientid' value='<%=patientid%>' >
<input type=hidden name='waitlist_cat_one_code' id='waitlist_cat_one_code' value='<%=waitlist_cat_one_code%>' >
<input type=hidden name='locale' id='locale' value='<%=locale%>' >
<input type=hidden name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>' >
<input type=hidden name='rd_waitlist_yn' id='rd_waitlist_yn' value='<%=rd_waitlist_yn%>' >

<input type='hidden' name='isAlternateAddressAppl' id='isAlternateAddressAppl' value="<%=isAlternateAddressAppl%>"><!--Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601-->

<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
<input type='hidden' name='others_id' id='others_id' value='<%=others_id%>'>


</form>
<script>
if(document.forms[0].wtlt_category.value !="" )
                 
{
	document.forms[0].or_catalogue_desc.value='<%=wtlt_category%>';
	
}
var obj=document.forms[0].status;
if (document.forms[0].statusCriteria.value=='U')  
obj.options.selectedIndex=1;
else if(document.forms[0].statusCriteria.value=='S')
obj.options.selectedIndex=2;
else if(document.forms[0].statusCriteria.value=='N')
obj.options.selectedIndex=3;
document.forms[0].resourceType1.value='<%=rsClass%>'
if (document.forms[0].b_loc_val.value==''){
	document.forms[0].practitioner_name.disabled=true;
	document.forms[0].search_pract.disabled=true;
}else
{
	displayPrimaryResource();
}

</script>
<%!
public static String checkForNull(String inputString)
{
	return ( ((inputString == null) || (inputString.equals("null"))) ? "" : inputString );
}
%>
</body>
</html>


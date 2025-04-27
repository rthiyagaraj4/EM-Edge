<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*, webbeans.eCommon.*,java.util.*,javax.servlet.http.*,javax.servlet.jsp.JspWriter,com.ehis.util.* " contentType="text/html;charset=UTF-8"%>	 
<head>
	<%request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
     <link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<!-- 	<script src='../../eMP/js/RegPatReferral.js' language='javascript'></script> -->
	<script src='../../eMP/js/RegPatReferral1.js' language='javascript'></script>

	<script language='javascript'>
	async function Clinical_Details(obj,calling_from,mode)
	{

		if(obj.name=="clinical_details")
		{

			var retVal =    new String();
			var dialogHeight= "250px" ;
			var dialogWidth = "700px" ;
			var status = "no";
			
			
			var concat_vals=escape(document.forms[0].exm_clinical_find.value)+"&"+escape(document.forms[0].diagnosis.value)+"&"+escape(document.forms[0].treatment.value);				
			
			var arguments	=concat_vals;
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog( "../../eMP/jsp/RegPatReferralClinicalDtls.jsp?calling_from="+calling_from+"&mode="+mode,arguments,features);

			if(retVal != null)
			{
				var arr = retVal.split("&");

			document.forms[0].exm_clinical_find.value=unescape(arr[0]);
			document.forms[0].diagnosis.value=unescape(arr[1]);
			document.forms[0].treatment.value=unescape(arr[2]);
			}


				
		}
	}

//This variable is let to show that by default on load Arrived tab is enabled.
var currentTab = new String();
currentTab = "rfrd_from";

// This function is used for calling the function for changing the tab img displays and also the function for corresponding page displays for that particular tab.

function tab_click(objName){
selectTab(objName)
   
	if(objName == "rfrd_from"){
    //changeTab(objName);
	moveToTab(2);
	}

	

	else if(objName == "rfrd_to"){
	//	changeTab(objName);
		moveToTab(3);
	}


}

function func1()
{
	if(document.forms[0].otherDocAttached)
	{
	var otherDocAttached=document.forms[0].otherDocAttached.value;
	document.forms[0].txt.value=otherDocAttached;
	}
}

// function to change the tab display images according to functionality.



function moveToTab(TabIndex) {

if ( TabIndex == 2 )
	{
		//setTimeout("parent.document.frames[1].document.getElementById("rfrdfrom").scrollIntoView()",300);
       //setTimeout("parent.document.frames[1].document.getElementById("clinical_details").foc/us()",300);
	   document.getElementById('reftotable').style.display='';
	   document.getElementById('rfrdto1').style.display='none';
	   
	}
    else if ( TabIndex == 3 )
	{
		document.getElementById('reftotable').style.display='none';
	   document.getElementById('rfrdto1').style.display='';	//setTimeout("parent.document.frames[1].document.getElementById('rfrdto').scrollIntoView()",300);
	}
}

function tabFocus(){
  	//document.getElementById('ViewPatMain').scrollIntoView();
	moveToTab(0);
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<style>
textarea {
  resize: none;
}
</style>
</head>

<%	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null ;
	PreparedStatement orgTypePstmt = null;
	ResultSet orgTypeRS = null;
	String org_type_data ="";
	String orderCatalog = "";
    //String facility_id		=	(String)		session.getValue("facility_id");
    String  action_date_time="";
    String action_type_desc="";
    String action_reason_desc="";
    String action_ref_id		="";
    String action_remarks	="";
    String  actioned_by		="";
    String or_install_yn="";
    String ordercatlogcode = request.getParameter("orderCatalogCode")==null ?"" :request.getParameter("orderCatalogCode");
	String referralid = checkForNull(request.getParameter("referral_id"));
	//String frame_name=	checkForNull(request.getParameter("frame_name"));
	String visibility_table="";
	/*if(frame_name.equals("first"))
		visibility_table="visible";
	else
		visibility_table="visible";*/
		
	//added for Bru-HIMS-CRF-380 Start
	String facility_id	= request.getParameter("facility_id");
	if(facility_id==null || facility_id.equals(""))//Modified by Thamizh selvi on 3rd July 2018 against MMS-DM-CRF-0115.3 
		facility_id = (String) session.getValue("facility_id");
	//added for Bru-HIMS-CRF-380 End
	


	String[] names			= new String[4] ;
    String[] name_prompts	= new String[4] ;
	String[] names_local	= new String[4] ;
    String[] name_prompts_local	= new String[4] ;
	StringBuffer sql		= new StringBuffer();
	String patient_id		= "";
	String patient_name		= "";
	String gender			= "";
	String agey				= "";
	String agem				= "";
	String aged				= "";
	String date_of_birth	= "";
	String nationality		= "";
	String addr_line1		= "";
	String addr_line2		= "";
	String addr_line3		= "";
	String addr_line4		= "";
	String contact1_no		= "";
	String contact2_no		= "";	
	String referral_date	= "";
	String referral_letter_no	= "";
	String preferred_treatment_date	= "";
	String referral_priority= "";
	String received_date	= "";
	String classValue="";
	String from_ref_type= "";
	String from_ref_type_desc="";
	String from_ref_locn_type="";
	String from_ref_locn_desc= "";
	String from_ref_pract_name= "";
	String to_speciality_desc= "";
	String to_service_desc= "";
	String to_ref_pract_name= "";
	String displaydata		= "";
	String prefix_prompt	= "";
	String prefix           = "";
	String suffix_prompt	= "";
	String suffix           = "";
	String first_name_prompt	= "";
	String first_name_order	= "";
	String first_name           = "";
	String second_name_prompt	= "";
	String second_name_order	= "";
	String second_name           = "";
	String third_name_prompt	= "";
	String third_name_order	= "";
	String third_name           = "";
	String family_name_prompt	= "";
	String family_name_order    ="";
	String family_name           = "";
	String status="";
	boolean citizen=true;
	String nationalIdNo="";
	String altIdTypeDescription[]=new String[4];
	String altIdType[]=new String[4];
	String altIdNo[]=new String[4];
	String othAltIdTypeDescription="";
	String othAltIdNo="";
	String mailAddress[]=new String[4];
	String mailResTownCode="";
	String mailResAreaCode="";
	String mailCountryCode="";
	String mailPostalCode="";
	String mailRegionCode="";
	String referralReason="";
	String otherDocAttached="";
	boolean legal=true;
	String raceDesc="";
	String toSpecialityDesc="";
	String examAndClinFindings="";
	String diagnosis="";
	String treatment="";
	String practitionerResTelNo="";
	String practitionerMobileNo="";
	String practitionerPagerNo="";
	String toRefType="";
	String toRefTypeDesc="";
	String toRefLocnDesc="";
	String toRefPractName="";
	String from_hcare_setting_desc	= "";
	String toHcareSettingDesc="";
	String referredForIP="";
	String resTownCode="";
	String resAreaCode="";
	String countryCode="";
	String regionCode="";
	String postalCode="";
	String nationalIDPrompt="";
	String Birth_place_desc="";
	String Race_desc="";
	String From_Splty_desc="";
	String Alt_ID1_date="";
	String Alt_ID2_date="";
	String Alt_ID3_date="";
	String Alt_ID4_date="";
	String Ref_source="";
	String ToRef_source="";

	String altIdTypeDesc1 = "";
	String altIdTypeDesc2 = "";
	String altIdTypeDesc3 = "";
	String altIdTypeDesc4 = "";

	String altIdNo1 = "";
	String altIdNo2 = "";
	String altIdNo3 = "";
	String altIdNo4 = "";
	String family_name_loc_lang="";
	String third_name_loc_lang="";
	String second_name_loc_lang="";
	String first_name_loc_lang="";
	String name_prefix_loc_lang="";
	String name_suffix_loc_lang="";
	String patient_name_loc_lang="";

	String name_prefix_loc_lang_prompt="";
	String first_name_loc_lang_prompt="";
	String second_name_loc_lang_prompt="";
	String third_name_loc_lang_prompt="";
	String family_name_loc_lang_prompt="";
	String name_suffix_loc_lang_prompt="";
	String names_in_oth_lang_yn="";
	String name_prefix_accept_yn="";
	String name_suffix_accept_yn="";
	String from_long_name="";
	String to_long_name="";

	Clob note = null;

	String exp_date_desc="Exp. Date";
	String to_locn_type_desc="";
	boolean NRICNamePrefixAvailable=true;
	boolean NRICFirstNameAvailable=true;
	boolean NRICSecondNameAvailable=true;
	boolean NRICThirdNameAvailable=true;
	boolean NRICFamilyNameAvailable=true;
	boolean NRICNameSuffixAvailable=true;

	for(int i=0;i<4;i++)
	{
		altIdTypeDescription[i]="";
		altIdType[i]="";
		altIdNo[i]="";
		mailAddress[i]="";
	}

	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	String called_from	= checkForNull(request.getParameter("called_from"));
	String RepDb		= checkForNull(request.getParameter("RepDb"));
	String clob_data	= checkForNull(request.getParameter("clob_data"));
	String cdrPatientId	= checkForNull(request.getParameter("cdrPatientId"));
	String sqlFinal		= "";
	/*End*/
%>
<body  onKeyDown ='lockKey()' onLoad="window.toolbar=true;tab_click('rfrd_from')">

<%
	try
	{	
	con = ConnectionManager.getConnection(request);

     //Below Added by Suji Keerthi for NMC-JD-CRF-0130
        Boolean isReferralPriorityAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","REFERRAL_PRIORITY_DESC");
     //Ended by Suji Keerthi for NMC-JD-CRF-0130

	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	if(called_from.equals("CDR"))
		eMP.MPCommonBean.insReferralDataForCDR(con, cdrPatientId, RepDb);
	/*End*/


  // 	sql.append("select name_prefix_accept_yn, name_suffix_accept_yn,  nvl(name_prefix_prompt,'')name_prefix_prompt, first_name_accept_yn,  nvl(first_name_prompt,'')first_name_prompt, nvl(name_suffix_prompt,'')name_suffix_prompt, second_name_accept_yn, nvl(second_name_prompt,'')second_name_prompt, third_name_accept_yn, nvl(third_name_prompt,'')third_name_prompt, family_name_accept_yn, first_name_order, second_name_order, third_name_order, family_name_order,nvl(family_name_prompt,'')family_name_prompt,alternateID1.alt_id_type alternateIDType1,alternateID2.alt_id_type alternateIDType2,alternateID3.alt_id_type alternateIDType3,alternateID4.alt_id_type alternateIDType4, alternateID1.short_desc alternateID1desc, alternateID2.short_desc alternateID2desc, alternateID3.short_desc alternateID3desc, alternateID4.short_desc alternateID4desc, nvl(nat_id_prompt, 'NRIC No.') nat_id_prompt ,name_prefix_loc_lang_prompt,first_name_loc_lang_prompt,second_name_loc_lang_prompt,third_name_loc_lang_prompt,family_name_loc_lang_prompt,name_suffix_loc_lang_prompt,names_in_oth_lang_yn");
	//sql.append(" from mp_param, mp_alternate_id_type alternateID1, mp_alternate_id_type alternateID2, mp_alternate_id_type alternateID3, mp_alternate_id_type alternateID4 where alternateID1.alt_id_type = mp_param.alt_id1_type and alternateid2.alt_id_type(+) = mp_param.alt_id2_type  AND alternateid3.alt_id_type(+) = mp_param.alt_id3_type AND alternateid4.alt_id_type(+) = mp_param.alt_id4_type ");

	sql.append("select name_prefix_accept_yn, name_suffix_accept_yn,  nvl(name_prefix_prompt,'')name_prefix_prompt, first_name_accept_yn,  nvl(first_name_prompt,'')first_name_prompt, nvl(name_suffix_prompt,'')name_suffix_prompt, second_name_accept_yn, nvl(second_name_prompt,'')second_name_prompt, third_name_accept_yn, nvl(third_name_prompt,'')third_name_prompt, family_name_accept_yn, first_name_order, second_name_order, third_name_order, family_name_order,nvl(family_name_prompt,'')family_name_prompt,alternateID1.alt_id_type alternateIDType1,alternateID2.alt_id_type alternateIDType2,alternateID3.alt_id_type alternateIDType3,alternateID4.alt_id_type alternateIDType4,   mp_get_desc.MP_ALTERNATE_ID_TYPE ##REPDB##(alternateID1.alt_id_type,'"+localeName+"',1) alternateID1desc   ,mp_get_desc.MP_ALTERNATE_ID_TYPE ##REPDB##(alternateID2.alt_id_type,'"+localeName+"',2) alternateID2desc   ,mp_get_desc.MP_ALTERNATE_ID_TYPE ##REPDB##(alternateID3.alt_id_type,'"+localeName+"',2) alternateID3desc   ,mp_get_desc.MP_ALTERNATE_ID_TYPE ##REPDB##(alternateID4.alt_id_type,'"+localeName+"',2) alternateID4desc , nvl(nat_id_prompt, '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalID.label","mp_labels")+"') nat_id_prompt ,name_prefix_loc_lang_prompt,first_name_loc_lang_prompt,second_name_loc_lang_prompt,third_name_loc_lang_prompt,family_name_loc_lang_prompt,name_suffix_loc_lang_prompt,names_in_oth_lang_yn");
	sql.append(" from mp_param_lang_vw ##REPDB##, mp_alternate_id_type ##REPDB## alternateID1, mp_alternate_id_type ##REPDB## alternateID2, mp_alternate_id_type ##REPDB## alternateID3, mp_alternate_id_type ##REPDB## alternateID4 where alternateID1.alt_id_type = alt_id1_type and alternateid2.alt_id_type(+) = alt_id2_type  AND alternateid3.alt_id_type(+) = alt_id3_type AND alternateid4.alt_id_type(+) = alt_id4_type AND module_id='MP' AND language_id='"+localeName+"' ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	
	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	sqlFinal = sql.toString();
	sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
	/*End*/
	pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	rs = pstmt.executeQuery();
    while(rs!=null &&rs.next())
		{
			name_prefix_accept_yn			= rs.getString("name_prefix_accept_yn");
		 if (name_prefix_accept_yn==null) name_prefix_accept_yn="N";
		 name_suffix_accept_yn			= rs.getString("name_suffix_accept_yn");
		 if (name_suffix_accept_yn==null) name_suffix_accept_yn="N";

		 prefix_prompt			= rs.getString("name_prefix_prompt");
		 if (prefix_prompt==null) prefix_prompt="";
		
		 suffix_prompt			= rs.getString("name_suffix_prompt");
		 if (suffix_prompt==null) suffix_prompt="";
		
		 first_name_prompt		= rs.getString("first_name_prompt");
		 if (first_name_prompt==null) first_name_prompt="";
		 first_name_order		= rs.getString("first_name_order");
		 if (first_name_order==null) first_name_order = "0";
		 second_name_prompt		= rs.getString("second_name_prompt");
		 if (second_name_prompt==null) second_name_prompt="";
		 second_name_order		= rs.getString("second_name_order");
		 if (second_name_order==null) second_name_order = "0";
		
		 third_name_prompt		= rs.getString("third_name_prompt");
		 if (third_name_prompt==null) third_name_prompt="";
		 third_name_order		= rs.getString("third_name_order");
		 if (third_name_order==null) third_name_order = "0";
		 family_name_prompt		= rs.getString("family_name_prompt");
		 if (family_name_prompt==null) family_name_prompt="";

		 names_in_oth_lang_yn		= rs.getString("names_in_oth_lang_yn");
		 if (names_in_oth_lang_yn==null) names_in_oth_lang_yn="N";

		 name_prefix_loc_lang_prompt			= rs.getString("name_prefix_loc_lang_prompt");
		 if (name_prefix_loc_lang_prompt==null) name_prefix_loc_lang_prompt="";
		
		 name_suffix_loc_lang_prompt			= rs.getString("name_suffix_loc_lang_prompt");
		 if (name_suffix_loc_lang_prompt==null) name_suffix_loc_lang_prompt="";
		
		 first_name_loc_lang_prompt		= rs.getString("first_name_loc_lang_prompt");
		 if (first_name_loc_lang_prompt==null) first_name_loc_lang_prompt="";

		 second_name_loc_lang_prompt		= rs.getString("second_name_loc_lang_prompt");
		 if (second_name_loc_lang_prompt==null) second_name_loc_lang_prompt="";
		
		 third_name_loc_lang_prompt		= rs.getString("third_name_loc_lang_prompt");
		 if (third_name_loc_lang_prompt==null) third_name_loc_lang_prompt="";
		 family_name_loc_lang_prompt		= rs.getString("family_name_loc_lang_prompt");
		 if (family_name_loc_lang_prompt==null) family_name_loc_lang_prompt="";	


		 family_name_order		= rs.getString("family_name_order");
		 if (family_name_order==null) family_name_order = "0";

		 nationalIDPrompt		= rs.getString("nat_id_prompt");
		 if(nationalIDPrompt==null) nationalIDPrompt="";

		 altIdTypeDesc1 = rs.getString("alternateID1desc");
			 if(altIdTypeDesc1 == null) altIdTypeDesc1="";
 		 altIdTypeDesc2 = rs.getString("alternateID2desc");
			 if(altIdTypeDesc2 == null) altIdTypeDesc2="";
		 altIdTypeDesc3 = rs.getString("alternateID3desc");
			 if(altIdTypeDesc3 == null) altIdTypeDesc3="";
		 altIdTypeDesc4 = rs.getString("alternateID4desc");
			if(altIdTypeDesc4 == null) altIdTypeDesc4="";

		for(int i=0;i<4;i++)
		{
			altIdType[i]=rs.getString("alternateIDType"+(i+1));
			if(altIdType[i]==null)	altIdType[i]="";
		}
		
	}
	
	if (rs!=null) rs.close();
    if (pstmt!=null) pstmt.close();

	sql.setLength(0);

   sql.append("select operational_yn from sm_modules_facility ##REPDB## where facility_id='"+facility_id+"' and module_id='OR'");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1

	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	sqlFinal = sql.toString();
	sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
	/*End*/
		
	pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	rs = pstmt.executeQuery();   
	if (rs!=null && rs.next())	  {
		  or_install_yn = rs.getString("operational_yn");
	 }
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
	if(or_install_yn.equals("Y"))
		{sql.setLength(0);
	     sql.append("select short_desc from or_order_catalog_lang_vw ##REPDB## where ORDER_CATALOG_CODE='"+ordercatlogcode+"' and language_id='"+localeName+"'");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	
	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	sqlFinal = sql.toString();
	sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
	/*End*/
	pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	rs = pstmt.executeQuery();
    while(rs!=null &&rs.next())
		{
		orderCatalog=rs.getString("short_desc"); 
	   
		}

	 if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
	  
		}
	   
	 sql.setLength(0);
	   
	  // sql.append("select res_area_code, res_town_code, country_code, postal_code, region_code, mail_region_code, referred_for_ip, national_id_no, alt_id1_type, alt_id2_type,alt_id3_type, alt_id4_type, oth_alt_id_type, alt_id1_no, alt_id2_no,alt_id3_no, alt_id4_no, oth_alt_id_no, mail_addr_line1, mail_addr_line2,  mail_addr_line3, mail_res_town_code, mail_res_area_code, mail_country_code, mail_postal_code,  mail_addr_line4, race_desc, referral_reason, other_doc_att, exam_and_clin_findings, diagnosis, treatment, pract_res_tel_num, pract_mobile_num, pract_pager_num, patient_id,patient_name,sex gender, name_prefix,first_name,second_name,third_name,family_name,name_suffix,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1)||'Y' agey,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),2)||'M' agem, calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),3)||'D' aged,to_char(date_of_birth,'dd/mm/yyyy') date_of_birth,nationality,addr_line1,addr_line2,addr_line3,addr_line4,	contact1_no,contact2_no,from_hcare_setting_desc, decode(from_ref_type,'X',from_ref_desc,from_facility_name) Ref_source,decode(to_ref_type,'X',to_ref_desc,to_facility_name) ToRef_source, to_hcare_setting_desc,to_char(referral_date,'dd/mm/yyyy') referral_date,referral_letter_no,to_char(preferred_treatment_date,'dd/mm/yyyy') preferred_treatment_date, referral_priority , to_char(received_date,'dd/mm/yyyy') received_date,from_ref_type, to_ref_type, from_locn_type  from_locn_type_desc, decode(from_ref_type,'X',from_ref_locn_desc, decode(from_locn_type,'C',from_clinic_desc,'E',from_clinic_desc,'D',from_clinic_desc,from_nurs_unit_desc)) from_ref_locn_desc, decode(to_ref_type,'X',to_ref_locn_desc,decode(to_locn_type,'C',to_clinic_desc,'E',to_clinic_desc,'Y',to_clinic_desc,'W',to_clinic_desc,to_nurs_unit_desc)) to_ref_locn_desc, to_locn_type to_locn_type_desc, decode(from_ref_type,'X',from_ref_pract_name, from_fcy_pract_name)from_ref_pract_name, decode(to_ref_type,'X',to_ref_pract_name,to_fcy_pract_name) to_ref_pract_name, to_speciality_desc, to_service_desc, ref_notes, status, decode(citizen_yn,'Y','true','false') citizen, decode(legal_illegal_yn,'Y','true','false') legal, mp_alternate_id_type.short_desc alternateIDdesc, NVL2(BIRTH_PLACE_CODE, BIRTH_PLACE_DESC, BIRTH_PLACE_DESCRIPTION) BIRTH_PLACE_DESC ,ETHNIC_GROUP_DESC , FROM_SPLTY_DESC ,			to_char(ALT_ID1_DATE,'dd/mm/yyyy') ALT_ID1_DATE,		to_char(ALT_ID2_DATE,'dd/mm/yyyy') ALT_ID2_DATE,	to_char(ALT_ID3_DATE,'dd/mm/yyyy') ALT_ID3_DATE,	to_char(ALT_ID4_DATE,'dd/mm/yyyy') ALT_ID4_DATE,family_name_loc_lang,third_name_loc_lang,second_name_loc_lang,first_name_loc_lang,name_prefix_loc_lang,name_suffix_loc_lang,patient_name_loc_lang  from pr_referral_register_vw, mp_alternate_id_type where  referral_id = ? and mp_alternate_id_type.alt_id_type (+) = nvl(pr_referral_register_vw.oth_alt_id_type, ?) " );

		sql.append("SELECT" );
		sql.append("  res_area_code " );
		sql.append("  , res_town_code " );
		sql.append("  , country_code " );
		sql.append("  , postal_code " );
		sql.append("  , region_code " );
		sql.append("  , mail_region_code " );
		sql.append("  , referred_for_ip " );
		sql.append("  , national_id_no " );
		sql.append("  , alt_id1_type " );
		sql.append("  , alt_id2_type " );
		sql.append("  ,alt_id3_type " );
		sql.append("  , alt_id4_type " );
		sql.append("  , oth_alt_id_type " );
		sql.append("  , alt_id1_no " );
		sql.append("  , alt_id2_no " );
		sql.append("  ,alt_id3_no " );
		sql.append("  , alt_id4_no " );
		sql.append("  , oth_alt_id_no " );
		sql.append("  , mail_addr_line1 " );
		sql.append("  , mail_addr_line2 " );
		sql.append("  , mail_addr_line3 " );
		sql.append("  , mail_res_town_code " );
		sql.append("  , mail_res_area_code " );
		sql.append("  , mail_country_code " );
		sql.append("  , mail_postal_code " );
		sql.append("  , mail_addr_line4 " );
		sql.append("  , mp_get_desc.MP_RACE ##REPDB##(RACE_CODE,'"+localeName+"',1) race_desc " );
		sql.append("  , am_get_desc.AM_CONTACT_REASON ##REPDB##(REFERRAL_REASON_CODE,'"+localeName+"',1) referral_reason " );
		sql.append("  , other_doc_att " );
		sql.append("  , exam_and_clin_findings " );
		sql.append("  , diagnosis " );
		sql.append("  , treatment " );
		sql.append("  , pract_res_tel_num " );
		sql.append("  , pract_mobile_num " );
		sql.append("  , pract_pager_num " );
		sql.append("  , patient_id " );
		sql.append("  ,decode('"+localeName+"', '"+localeName+"', patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name " );
		sql.append("  ,sex gender " );
		sql.append("  , name_prefix " );
		sql.append("  ,first_name " );
		sql.append("  ,second_name " );
		sql.append("  ,third_name " );
		sql.append("  ,family_name " );
		sql.append("  ,name_suffix " );
		sql.append("  ,calculate_age ##REPDB##(TO_CHAR(date_of_birth,'dd/mm/yyyy'),1)||'Y' agey " );
		sql.append("  ,calculate_age ##REPDB##(TO_CHAR(date_of_birth,'dd/mm/yyyy'),2)||'M' agem " );
		sql.append("  , calculate_age ##REPDB##(TO_CHAR(date_of_birth,'dd/mm/yyyy'),3)||'D' aged " );
		sql.append("  ,TO_CHAR(date_of_birth,'dd/mm/yyyy') date_of_birth " );
		sql.append("  ,mp_get_desc.MP_COUNTRY ##REPDB##(NATIONALITY_CODE,'"+localeName+"',1) nationality " );
		sql.append("  ,addr_line1 " );
		sql.append("  ,addr_line2 " );
		sql.append("  ,addr_line3 " );
		sql.append("  ,addr_line4 " );
		sql.append("  , contact1_no " );
		sql.append("  ,contact2_no " );
		sql.append("  ,am_get_desc.AM_HCARE_SETTING_TYPE ##REPDB##(FROM_HCARE_SETTING_TYPE,'"+localeName+"',2) from_hcare_setting_desc " );
		sql.append("  , decode(from_ref_type,'X',am_get_desc.AM_REFERRAL ##REPDB##(FROM_REF_CODE,'"+localeName+"',1),sm_get_desc.SM_FACILITY_PARAM ##REPDB##(FROM_FACILITY_ID,'"+localeName+"',1)) Ref_source " );
		sql.append("  , decode(from_ref_type,'X',am_get_desc.AM_REFERRAL ##REPDB##(FROM_REF_CODE,'"+localeName+"',3),'') from_long_name " );
		sql.append("  ,decode(to_ref_type,'X',am_get_desc.AM_REFERRAL ##REPDB##(TO_REF_CODE,'"+localeName+"',1),sm_get_desc.SM_FACILITY_PARAM ##REPDB##(TO_FACILITY_ID,'"+localeName+"',1)) ToRef_source " );
		sql.append("  , decode(to_ref_type,'X',am_get_desc.AM_REFERRAL ##REPDB##(TO_REF_CODE,'"+localeName+"',3),'') to_long_name " );
		sql.append("  , am_get_desc.AM_HCARE_SETTING_TYPE ##REPDB##(TO_HCARE_SETTING_TYPE,'"+localeName+"',2) to_hcare_setting_desc " );
		//sql.append("  ,TO_CHAR(referral_date,'dd/mm/yyyy') referral_date " );
		/*Modified By Dharma on 9th jan 2014 against MMS-SCF-0207 [IN:046319]*/
		sql.append("  ,TO_CHAR(referral_date,'dd/mm/yyyy hh24:mi') referral_date " );
		sql.append("  ,referral_letter_no " );
		sql.append("  ,TO_CHAR(preferred_treatment_date,'dd/mm/yyyy') preferred_treatment_date " );
		sql.append("  , referral_priority " );
		sql.append("  , TO_CHAR(received_date,'dd/mm/yyyy') received_date " );
		sql.append("  ,from_ref_type " );
		sql.append("  , to_ref_type " );
		sql.append("  , from_locn_type from_locn_type_desc " );
		sql.append("  , decode(from_ref_type,'X',FROM_LOCN_DESC, decode(from_locn_type,'N',ip_get_desc.IP_NURSING_UNIT ##REPDB##(FROM_FACILITY_ID,FROM_LOCN_CODE,'"+localeName+"',1),op_get_desc.OP_CLINIC ##REPDB##(FROM_FACILITY_ID,FROM_LOCN_CODE,'"+localeName+"',1))) from_ref_locn_desc " );
		sql.append("  , decode(to_ref_type,'X',TO_LOCN_DESC, decode(to_locn_type,'N',ip_get_desc.IP_NURSING_UNIT ##REPDB##(TO_FACILITY_ID,TO_LOCN_CODE,'"+localeName+"',1),op_get_desc.OP_CLINIC ##REPDB##(TO_FACILITY_ID,TO_LOCN_CODE,'"+localeName+"',1))) to_ref_locn_desc " );
		sql.append("  , to_locn_type to_locn_type_desc " );
		sql.append("  , decode(from_ref_type,'X',FROM_PRACT_NAME, am_get_desc.AM_PRACTITIONER ##REPDB##(FROM_PRACT_ID,'"+localeName+"',1)) from_ref_pract_name " );

	   sql.append(" ,(CASE WHEN to_pract_id IS NULL THEN to_pract_name ELSE DECODE (to_ref_type, 'X', am_get_desc.am_ext_practitioner ##REPDB##(to_pract_id, '"+localeName+"', 1 ), am_get_desc.am_practitioner ##REPDB##(to_pract_id, '"+localeName+"', 1)) END ) to_ref_pract_name ");

	//	sql.append("  , decode(to_ref_type,'X',TO_PRACT_NAME,am_get_desc.AM_PRACTITIONER(TO_PRACT_ID,'"+localeName+"',1)) to_ref_pract_name " );
		sql.append("  , am_get_desc.AM_SPECIALITY ##REPDB##(TO_SPECIALITY_CODE,'"+localeName+"',2) to_speciality_desc " );
		sql.append("  , am_get_desc.AM_SERVICE ##REPDB##(TO_SERVICE_CODE,'"+localeName+"',2) to_service_desc " );
		sql.append("  , ref_notes " );
		sql.append("  , status " );
		sql.append("  , decode(citizen_yn,'Y','true','false') citizen " );
		sql.append("  , decode(legal_illegal_yn,'Y','true','false') legal " );
		sql.append("  , mp_get_desc.mp_alternate_id_type ##REPDB##(oth_alt_id_type,'"+localeName+"',1) alternateIDdesc " );
		sql.append("  , NVL2(BIRTH_PLACE_CODE, mp_get_desc.MP_BIRTH_PLACE ##REPDB##(BIRTH_PLACE_CODE,'"+localeName+"',1), BIRTH_PLACE_DESC) BIRTH_PLACE_DESC " );
		sql.append("  ,mp_get_desc.MP_ETHNIC_GROUP ##REPDB##(ETHNIC_GRP_CODE,'"+localeName+"',1) ETHNIC_GROUP_DESC " );
		sql.append("  ,am_get_desc.AM_SPECIALITY ##REPDB##(FROM_SPECIALITY_CODE,'"+localeName+"',2) FROM_SPLTY_DESC " );
		sql.append("  , TO_CHAR(ALT_ID1_DATE,'dd/mm/yyyy') ALT_ID1_DATE " );
		sql.append("  , TO_CHAR(ALT_ID2_DATE,'dd/mm/yyyy') ALT_ID2_DATE " );
		sql.append("  , TO_CHAR(ALT_ID3_DATE,'dd/mm/yyyy') ALT_ID3_DATE " );
		sql.append("  , TO_CHAR(ALT_ID4_DATE,'dd/mm/yyyy') ALT_ID4_DATE " );
		sql.append("  ,family_name_loc_lang " );
		sql.append("  ,third_name_loc_lang " );
		sql.append("  ,second_name_loc_lang " );
		sql.append("  ,first_name_loc_lang " );
		sql.append("  ,name_prefix_loc_lang " );
		sql.append("  ,name_suffix_loc_lang " );
		sql.append("  ,patient_name_loc_lang " );
		sql.append("FROM" );
		sql.append("  pr_referral_register##CLOB## " );
		sql.append("WHERE referral_id = ? " );
		//Modified above query by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1

	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	sqlFinal = sql.toString();
	sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
	sqlFinal = sqlFinal.replaceAll("##CLOB##",clob_data);
	/*End*/
	pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
    pstmt.setString(1, referralid);
//	pstmt.setString(2, altIdType[0]);
	rs = pstmt.executeQuery();

	if(rs!=null)
	{
		if(rs.next())
		{
		patient_id				= rs.getString("patient_id");
		patient_name			= rs.getString("patient_name");
		prefix					= rs.getString("name_prefix");
		first_name				= rs.getString("first_name");
		second_name				= rs.getString("second_name");
		third_name				= rs.getString("third_name");
		family_name				= rs.getString("family_name");
		suffix					= rs.getString("name_suffix");
		gender					= rs.getString("gender");
		agey					= rs.getString("agey");
		agem					= rs.getString("agem");
		aged					= rs.getString("aged");
		date_of_birth			= rs.getString("date_of_birth");
		date_of_birth=DateUtils.convertDate(date_of_birth,"DMY","en",localeName);
		nationality				= rs.getString("nationality");
		addr_line1				= rs.getString("addr_line1");
		addr_line2				= rs.getString("addr_line2");
		addr_line3				= rs.getString("addr_line3");
		addr_line4				= rs.getString("addr_line4");
		contact1_no				= rs.getString("contact1_no");
		contact2_no				= rs.getString("contact2_no");
		from_hcare_setting_desc	= rs.getString("from_hcare_setting_desc");
		referral_date			= rs.getString("referral_date");
		//referral_date=DateUtils.convertDate(referral_date,"DMY","en",localeName);
		/*Modified By Dharma on 9th jan 2014 against MMS-SCF-0207 [IN:046319]*/
		referral_date=DateUtils.convertDate(referral_date,"DMYHM","en",localeName);
		referral_letter_no		= rs.getString("referral_letter_no");
		preferred_treatment_date= rs.getString("preferred_treatment_date");
		preferred_treatment_date=DateUtils.convertDate(preferred_treatment_date,"DMY","en",localeName);
		referral_priority		= rs.getString("referral_priority");
		
		received_date			= rs.getString("received_date");	received_date=DateUtils.convertDate(received_date,"DMY","en",localeName);
		
		from_ref_type			= rs.getString("from_ref_type");


		first_name_loc_lang			= rs.getString("first_name_loc_lang");
		if(first_name_loc_lang==null)
			first_name_loc_lang="";
		second_name_loc_lang			= rs.getString("second_name_loc_lang");
		if(second_name_loc_lang==null)
			second_name_loc_lang="";
		third_name_loc_lang			= rs.getString("third_name_loc_lang");
		if(third_name_loc_lang==null)
			third_name_loc_lang="";
		family_name_loc_lang			= rs.getString("family_name_loc_lang");
		if(family_name_loc_lang==null)
			family_name_loc_lang="";
		name_prefix_loc_lang			= rs.getString("name_prefix_loc_lang");
		if(name_prefix_loc_lang==null)
			name_prefix_loc_lang="";
		name_suffix_loc_lang			= rs.getString("name_suffix_loc_lang");
		if(name_suffix_loc_lang==null)
			name_suffix_loc_lang="";
		patient_name_loc_lang			= rs.getString("patient_name_loc_lang");
		if(patient_name_loc_lang==null)
			patient_name_loc_lang="";


		if (from_ref_type != null)
		{
			if (from_ref_type.equals("X"))
				from_ref_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
			else
			if (from_ref_type.equals("E"))
				from_ref_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enterprise.label","common_labels");
			else
			if (from_ref_type.equals("L"))
				from_ref_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.loginfacility.label","common_labels");
		}
		from_ref_locn_type			= rs.getString("from_locn_type_desc");
		if(from_ref_locn_type==null)
			from_ref_locn_type="";
	if(!from_ref_locn_type.equals(""))
			{
				switch (from_ref_locn_type.charAt(0))
				{
					case  'C' :
								from_ref_locn_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels") ;		
								break;
					case  'Y' :
								from_ref_locn_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
								break;
					case  'E' :
								from_ref_locn_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
								break;
					case  'N' :
								from_ref_locn_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
								break;
				}
			}
		from_ref_locn_desc		= rs.getString("from_ref_locn_desc");
		from_ref_pract_name		= rs.getString("from_ref_pract_name");
		to_speciality_desc			= rs.getString("to_speciality_desc");
		to_service_desc			= rs.getString("to_service_desc");
		to_ref_pract_name			= rs.getString("to_ref_pract_name");
		status							= rs.getString("status");
		citizen						= Boolean.valueOf(rs.getString("citizen")).booleanValue();
		nationalIdNo					= rs.getString("national_id_no");
		othAltIdTypeDescription	= rs.getString("alternateIDdesc");
		othAltIdNo					= rs.getString("oth_alt_id_no");
		mailResTownCode			= rs.getString("mail_res_town_code");
		mailResAreaCode			= rs.getString("mail_res_area_code");
		mailCountryCode		= rs.getString("mail_country_code");
		mailPostalCode			= rs.getString("mail_postal_code");
		mailRegionCode			= rs.getString("mail_region_code");
		referralReason			= rs.getString("referral_reason");
		otherDocAttached		= rs.getString("other_doc_att");
		legal					= Boolean.valueOf(rs.getString("legal")).booleanValue();
		raceDesc				= rs.getString("race_desc");
		examAndClinFindings		= rs.getString("exam_and_clin_findings");
		diagnosis				= rs.getString("diagnosis");
		treatment				= rs.getString("treatment");
		practitionerResTelNo	= rs.getString("pract_res_tel_num");
		practitionerMobileNo	= rs.getString("pract_mobile_num");
		practitionerPagerNo		= rs.getString("pract_pager_num");
		toRefType				= rs.getString("to_ref_type");
		if (toRefType != null)
		{
			if (toRefType.equals("X"))
				toRefTypeDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
			else
			if (toRefType.equals("E"))
				toRefTypeDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enterprise.label","common_labels");
			else
			if (toRefType.equals("L"))
				toRefTypeDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.loginfacility.label","common_labels");
		}
		toRefLocnDesc			= checkForNull(rs.getString("to_ref_locn_desc"));

		to_locn_type_desc       = checkForNull(rs.getString("to_locn_type_desc"));

	if(!to_locn_type_desc.equals("")) 
	{
		switch (to_locn_type_desc.charAt(0))
		{
			case  'C' :
						to_locn_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels") ;		
						break;
			case  'Y' :
						to_locn_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
						break;
			case  'E' :
						to_locn_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
						break;
			case  'N' :
						to_locn_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
						break;
			case  'W' :
						to_locn_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RadiologyWing.label","common_labels");
						break;
		}
	}
		toHcareSettingDesc		= rs.getString("to_hcare_setting_desc");
		referredForIP			= rs.getString("referred_for_ip");
		if(referredForIP == null) referredForIP="";
		else
		{
		if (referredForIP.equals("B"))
			referredForIP = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booking.label","common_labels");
		else
		if (referredForIP.equals("A"))
			referredForIP = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
		}
//decode(referred_for_ip,'B','Booking','A','Admission','')
		resAreaCode				= rs.getString("res_area_code");
		resTownCode				= rs.getString("res_town_code");
		countryCode				= rs.getString("country_code");
		regionCode				= rs.getString("region_code");
		postalCode				= rs.getString("postal_code");
		Birth_place_desc		= rs.getString("BIRTH_PLACE_DESC");
		Race_desc				= rs.getString("ETHNIC_GROUP_DESC");
		From_Splty_desc			= rs.getString("FROM_SPLTY_DESC");
		Alt_ID1_date			= rs.getString("ALT_ID1_DATE");
		Alt_ID1_date=DateUtils.convertDate(Alt_ID1_date,"DMY","en",localeName);
		Alt_ID2_date			= rs.getString("ALT_ID2_DATE");
		Alt_ID2_date=DateUtils.convertDate(Alt_ID2_date,"DMY","en",localeName);
		Alt_ID3_date			= rs.getString("ALT_ID3_DATE");
		Alt_ID3_date=DateUtils.convertDate(Alt_ID3_date,"DMY","en",localeName);
		Alt_ID4_date			= rs.getString("ALT_ID4_DATE");
		Alt_ID4_date=DateUtils.convertDate(Alt_ID4_date,"DMY","en",localeName);
		Ref_source			= rs.getString("Ref_source");
		ToRef_source        = rs.getString("ToRef_source");
		from_long_name= checkForNull(rs.getString("from_long_name"));
		to_long_name= checkForNull(rs.getString("to_long_name"));


		altIdNo1 = rs.getString("alt_id1_no");
			if(altIdNo1==null || altIdTypeDesc1.equals("")) altIdNo1="";
		altIdNo2 = rs.getString("alt_id2_no");
			if(altIdNo2==null || altIdTypeDesc2.equals("")) altIdNo2="";
		altIdNo3 = rs.getString("alt_id3_no");
			if(altIdNo3==null || altIdTypeDesc3.equals("")) altIdNo3="";
		altIdNo4 = rs.getString("alt_id4_no");
			if(altIdNo4==null || altIdTypeDesc4.equals("")) altIdNo4="";

		for(int i=0;i<4;i++)
		{
			mailAddress[i]=rs.getString("mail_addr_line"+(i+1));
		}
		
		if (patient_id==null) patient_id ="";
		if (patient_name==null) patient_name ="";
		if (prefix==null){ prefix =""; NRICNamePrefixAvailable=false; }
		if (first_name==null){ first_name =""; NRICFirstNameAvailable=false; }
		if (second_name==null){ second_name =""; NRICSecondNameAvailable=false; }
		if (third_name==null){ third_name =""; NRICThirdNameAvailable=false; }
		if (family_name==null){ family_name =""; NRICFamilyNameAvailable=false; }
		if (suffix==null){ suffix =""; NRICNameSuffixAvailable=false; }
		if (gender==null) gender ="";
		if (agey==null) agey ="";
		if (agem==null) agem ="";
		if (aged==null) aged ="";
		if (date_of_birth==null) date_of_birth ="";
		if (nationality==null) nationality ="";
		if (addr_line1==null) addr_line1 ="";
		if (addr_line2==null) addr_line2 ="";
		if (addr_line3==null) addr_line3 ="";
		if (addr_line4==null) addr_line4 ="";
		if (contact1_no==null) contact1_no ="";
		if (contact2_no==null) contact2_no ="";
		if (from_hcare_setting_desc==null) from_hcare_setting_desc ="";
		if (referral_date==null) referral_date ="";
		if (referral_letter_no==null) referral_letter_no ="";
		if (from_ref_type==null) from_ref_type ="";
		  
		if (from_ref_locn_type==null) from_ref_locn_type ="";
		if (from_ref_locn_desc==null) from_ref_locn_desc ="";
		if (from_ref_pract_name==null) from_ref_pract_name ="";
		if (referral_priority==null) referral_priority ="";
		if (received_date==null) received_date ="";
		if (to_speciality_desc==null) to_speciality_desc ="";
		if (preferred_treatment_date==null) preferred_treatment_date ="";
		if (to_service_desc==null) to_service_desc ="";
		if (to_ref_pract_name==null) to_ref_pract_name ="";
		note=rs.getClob("REF_NOTES");
		if(note!=null)
		{
			java.io.BufferedReader r = new java.io.BufferedReader(note.getCharacterStream());
			String line = null;
			while((line=r.readLine()) != null) displaydata= displaydata+line+"\n";
		}

		if(status==null) status="";
		if(nationalIdNo==null) nationalIdNo="";
		if(othAltIdTypeDescription==null) {othAltIdTypeDescription=""; othAltIdNo="";}
		if(othAltIdNo==null) othAltIdNo="";
		if(mailResTownCode==null) mailResTownCode="";
		if(mailResAreaCode==null) mailResAreaCode="";
		if(mailCountryCode==null) mailCountryCode="";
		if(mailPostalCode==null) mailPostalCode="";
		if(mailRegionCode==null) mailRegionCode="";
		if(referralReason==null) referralReason="";
		if(otherDocAttached==null) otherDocAttached="";
		if(raceDesc==null) raceDesc="";
		if(toSpecialityDesc==null) toSpecialityDesc="";
		if(examAndClinFindings==null) examAndClinFindings="";
		if(diagnosis==null) diagnosis="";
		if(treatment==null) treatment="";

		
		if(practitionerResTelNo==null) practitionerResTelNo="";
		if(practitionerMobileNo==null) practitionerMobileNo="";
		if(practitionerPagerNo==null) practitionerPagerNo="";
		if(toRefType==null) toRefType="";
		if(toRefTypeDesc ==null) toRefTypeDesc ="";
		
		if(to_locn_type_desc==null)to_locn_type_desc="";

		if(!to_locn_type_desc.equals(""))
		{
		if(toRefLocnDesc!=null)
			toRefLocnDesc = toRefLocnDesc;
		}
		
		
		if(toRefLocnDesc==null) toRefLocnDesc="";

		if(toRefPractName==null) toRefPractName="";
		if(toHcareSettingDesc==null) toHcareSettingDesc="";
		if(resAreaCode==null) resAreaCode="";
		if(resTownCode==null) resTownCode="";
		if(countryCode==null) countryCode="";
		if(regionCode==null) regionCode="";
		if(postalCode==null) postalCode="";
		if(	Birth_place_desc==null) Birth_place_desc="";
		if(	Race_desc==null) Race_desc="";
		if(From_Splty_desc==null) From_Splty_desc="";
		if(Alt_ID1_date==null) Alt_ID1_date="";
		if(Alt_ID2_date==null) Alt_ID2_date="";
		if(Alt_ID3_date==null) Alt_ID3_date="";
		if(Alt_ID4_date==null) Alt_ID4_date="";
		if(Ref_source==null) Ref_source="";
		if(ToRef_source==null)ToRef_source="";

		for(int i=0;i<4;i++)
		{
			if(altIdNo[i]==null)
				altIdNo[i]="";

			if(mailAddress[i]==null)
				mailAddress[i]="";
			
			name_prompts[i]="";
			names[i]="";
			names_local[i]="";
			name_prompts_local[i]="";
		
		}
		
		if( first_name_order.equals("1") )
		{
			names[0]		=first_name  ;
			name_prompts[0] = first_name_prompt ;
			names_local[0]		=first_name_loc_lang  ;
			name_prompts_local[0] = first_name_loc_lang_prompt ;
		}
		else if(first_name_order.equals("2"))
		{
			names[1]		=first_name  ;
			name_prompts[1] = first_name_prompt;
			names_local[1]		=first_name_loc_lang  ;
			name_prompts_local[1] = first_name_loc_lang_prompt ;
		}
		else if(first_name_order.equals("3"))
		{
			names[2]		=first_name;
			name_prompts[2] = first_name_prompt;
			names_local[2]		=first_name_loc_lang  ;
			name_prompts_local[2] = first_name_loc_lang_prompt ;
		}
		else if(first_name_order.equals("4"))
		{
			names[3]		=first_name  ;
			name_prompts[3] = first_name_prompt;
			names_local[3]		=first_name_loc_lang  ;
			name_prompts_local[3] = first_name_loc_lang_prompt ;
		}

		if( second_name_order.equals("1") )
		{
			names[0]			 =second_name  ;
			name_prompts[0]		 = second_name_prompt ;
			names_local[0]		 =second_name_loc_lang  ;
			name_prompts_local[0]= second_name_loc_lang_prompt ;
		}
		else if(second_name_order.equals("2"))
		{
			names[1]		=second_name  ;
			name_prompts[1] = second_name_prompt;
			names_local[1]		 =second_name_loc_lang  ;
			name_prompts_local[1]= second_name_loc_lang_prompt ;
		}
		else if(second_name_order.equals("3"))
		{
			names[2]		=second_name  ;
			name_prompts[2] = second_name_prompt;
			names_local[2]		 =second_name_loc_lang  ;
			name_prompts_local[2]= second_name_loc_lang_prompt ;
		}
		else if(second_name_order.equals("4"))
		{
			names[3]		=second_name  ;
			name_prompts[3] = second_name_prompt;
			names_local[3]		 =second_name_loc_lang  ;
			name_prompts_local[3]= second_name_loc_lang_prompt ;
		}
	
		if( third_name_order.equals("1") )
		{
			names[0]		=third_name  ;
			name_prompts[0] = third_name_prompt ;
			names_local[0]		 =third_name_loc_lang  ;
			name_prompts_local[0]= third_name_loc_lang_prompt ;
		}
		else if(third_name_order.equals("2"))
		{
			names[1]		=third_name  ;
			name_prompts[1] = third_name_prompt;
			names_local[1]		 =third_name_loc_lang  ;
			name_prompts_local[1]= third_name_loc_lang_prompt ;
		}
		else if(third_name_order.equals("3"))
		{
			names[2]		=third_name  ;
			name_prompts[2] = third_name_prompt;
			names_local[2]		 =third_name_loc_lang  ;
			name_prompts_local[2]= third_name_loc_lang_prompt ;
		}
		else if(third_name_order.equals("4"))
		{
			names[3]		=third_name  ;
			name_prompts[3] = third_name_prompt;
			names_local[3]		 =third_name_loc_lang  ;
			name_prompts_local[3]= third_name_loc_lang_prompt ;
		}
	
		if( family_name_order.equals("1") )
		{
			names[0]		=family_name  ;
			name_prompts[0] = family_name_prompt ;
			names_local[0]		 =family_name_loc_lang  ;
			name_prompts_local[0]= family_name_loc_lang_prompt ;
		}
		else if(family_name_order.equals("2"))
		{
			names[1]		=family_name  ;
			name_prompts[1] = family_name_prompt;
			names_local[1]		 =family_name_loc_lang  ;
			name_prompts_local[1]= family_name_loc_lang_prompt ;
		}
		else if(family_name_order.equals("3"))
		{
			names[2]		=family_name  ;
			name_prompts[2] = family_name_prompt;
			names_local[2]		 =family_name_loc_lang  ;
			name_prompts_local[2]= family_name_loc_lang_prompt ;
		}
		else if(family_name_order.equals("4"))
		{
			names[3]		=family_name  ;
			name_prompts[3] = family_name_prompt;
			names_local[3]		 =family_name_loc_lang  ;
			name_prompts_local[3]= family_name_loc_lang_prompt ;
		}

		/*
		
		for(int i=0;i<4;i++)
		{
			if(name_prompts[i].equals(""))
			{
				names[i]="";
			}
			if(name_prompts_local[i].equals(""))
			{
				names_local[i]="";
			}
		}

		*/
    
	try{

	String orgTypeSQL ="select org_type from pr_referral_register##CLOB##, am_referral ##REPDB## where referral_id = ? and from_ref_code = referral_code";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	
	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	orgTypeSQL = orgTypeSQL.replaceAll("##REPDB##",RepDb);
	orgTypeSQL = orgTypeSQL.replaceAll("##CLOB##",clob_data);
	/*End*/
					orgTypePstmt = con.prepareStatement( orgTypeSQL );
	                orgTypePstmt.setString ( 1, referralid ) ;
					orgTypeRS = orgTypePstmt.executeQuery() ;
		            if(orgTypeRS.next()) {
						org_type_data = orgTypeRS.getString( "org_type");

					if(org_type_data!=null && org_type_data.equals("P"))  		
						org_type_data="P";
					else
						org_type_data="G";
					


					}else{
					
					org_type_data="G";
					}

					if(orgTypeRS != null) orgTypeRS.close();
					if(orgTypePstmt != null) orgTypePstmt.close();
	}
catch(Exception e){

e.printStackTrace();
}
 %>
<form name="ViewPatReferral_form" id="ViewPatReferral_form" value="<%=referralid%>" target=messageFrame method=post>
<a name="ViewPatMain" ></a> 
<table cellpadding=0 cellspacing=0 border="0" width="100%">
<tr>
<td colspan="4">
	<table cellpadding=0 cellspacing=0 border=0 width="100%" colspan="4">
		<tr><td colspan=4 class=label height=5></td></tr>
			<tr>
				<td  width='24%' class=label ><fmt:message key="Common.referralid.label" bundle="${common_labels}"/>
				</td><td  class='label'   ><b><%=referralid%></b></td>
				<td   class=label ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
				</td><td  class='label' width='262pt' ><b><%=patient_id%></b></td>
			</tr>
		<tr><td colspan=4 class=label height=5></td></tr>
			<tr>
				
				<td class='label' width='204pt'  ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
				<td  class='label' colspan='3'  ><b><%=patient_name%>&nbsp;<%=patient_name_loc_lang%></b> </td>
			</tr>
		<tr><td colspan=4 class=label height=5></td></tr>
		<tr>
			<td class='label'   ><%=nationalIDPrompt%></td>
			<td  class='label' ><B><%=nationalIdNo%></B></td>

			<%if(!othAltIdNo.equals("")){%>

				<td  class=label  ><%=othAltIdTypeDescription%></td>
				<td  class=label ><B><%=othAltIdNo%></B> </td>
			<%}%>
		</tr>
		<tr><td colspan=4 class=label height=3></td></tr>
<!-- 	</table>

	<table cellpadding=0 cellspacing=0 border=0 width="100%"> -->

		<%if(!altIdTypeDesc1.equals("") || !altIdTypeDesc2.equals("") )
		{%>

		<tr>
 			<td  class=label   width='24%'><%=altIdTypeDesc1%></td>
			<td  class=label  width='260pt'><B><%=altIdNo1%></B>
			</td>
			<%if(altIdTypeDesc1.equals("")){ exp_date_desc="";Alt_ID1_date="";}else exp_date_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");%>
			<td  class=label width='205pt%' ><%=exp_date_desc%></td>
			<td  class=label ><B><%=Alt_ID1_date%></B></td>
            </tr>
			<tr>
			<td  class=label  ><%=altIdTypeDesc2%></td>
			<td  class=label  ><B><%=altIdNo2%></B>
			</td>
			<%if(altIdTypeDesc2.equals("")){ exp_date_desc="";Alt_ID2_date="";}else exp_date_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");%>
			<td  class=label  ><%=exp_date_desc%></td>
			<td  class=label ><B><%=Alt_ID2_date%></B></td>
	    </tr>
			<tr><td colspan=4 class=label height=5></td></tr>
				<%
			}
		if( !altIdTypeDesc3.equals("") || !altIdTypeDesc4.equals(""))
		{
				%>
		<tr>
			<td  class=label  ><%=altIdTypeDesc3%></td>
			<td  class=label  ><B><%=altIdNo3%></B>
			</td>
			<%if(altIdTypeDesc3.equals("")) {exp_date_desc="";Alt_ID3_date="";}else exp_date_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");%>
			<td  class=label  ><%=exp_date_desc%></td>
			
			<td  class=label ><B><%=Alt_ID3_date%></B></td>
            </tr>
           <tr>   
			<td  class=label ><%=altIdTypeDesc4%></td>
			<td  class=label  ><B><%=altIdNo4%></B>
			</td>
            
			<%if(altIdTypeDesc4.equals("")){ exp_date_desc="";Alt_ID4_date="";}else exp_date_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");%>
			<td  class=label  ><%=exp_date_desc%></td>
			<td  class=label ><B><%=Alt_ID4_date%></B></td>
		</tr>

	<%}
	%>
	<tr><td colspan=4 class=label height=3></td></tr>
	<tr><td colspan=4 class=label height=3></td></tr>
	<tr><td colspan=4 class=label height=3></td></tr>

<!--  </table> -->
<tr><td colspan=4>
<table cellpadding=0 cellspacing=0 border=0 width="100%" > 
<%if(NRICFirstNameAvailable || NRICSecondNameAvailable || NRICThirdNameAvailable || NRICFamilyNameAvailable){%>
<tr><td colspan=4 class=label height=5></td></tr>		
<tr>
	<%if(name_prefix_accept_yn.equals("Y")){ %>
	<td  class=label ><%=prefix_prompt%></td>
	<%}for(int i=0;i<4;i++){%>
		<td  class=label  ><%=name_prompts[i]%></td>
	<%}if(name_suffix_accept_yn.equals("Y")){%>
	<td  class=label ><%=suffix_prompt%></td><td colspan=2></td>
	<%}%>
</tr>
<tr>
<!--Modified by N Munisekhar on 07-Feb-2012 against ML-BRU-SCF-0690 [IN:037810]-->
<%if(name_prefix_accept_yn.equals("Y")){ %>
	<td  class=label><B><%=prefix%></B>	</td>		
		<%}for(int i=0;i<4;i++) { %>
			<td  class=label  ><B><%=names[i]%></B></td>

		<%}if(name_suffix_accept_yn.equals("Y")){%>
		<td  class=label ><B><%=suffix%></B></td>
			<%}%>
		<td colspan=2></td> 
	</tr>
<%if(names_in_oth_lang_yn.equals("Y")){%>
<tr>
	<%if(name_prefix_accept_yn.equals("Y")){%>
	<td  class=label ><%=name_prefix_loc_lang_prompt%></td>
	<%}for(int i=0;i<4;i++){%>
		<td  class=label  ><%=name_prompts_local[i]%></td>
	<%}if(name_suffix_accept_yn.equals("Y")){%>
	<td  class=label ><%=name_suffix_loc_lang_prompt%></td>
	<%}%>
	<td colspan=2></td>
</tr>
<tr>
<%if(name_prefix_accept_yn.equals("Y")){ %>
	<td  class=label><B><%=name_prefix_loc_lang%></B></td>		
		<%}for(int i=0;i<4;i++) { %>
			<td  class=label  ><B><%=names_local[i]%></B>&nbsp;</td>
		<%}if(name_suffix_accept_yn.equals("Y")){%>
		<td  class=label ><B><%=name_suffix_loc_lang%></B></td>
		<%}%>
	<!--End of ML-BRU-SCF-0690 [IN:037810] 	-->
		<td colspan=2></td> 
	</tr>
		<%}%> 
		<%}%> 
 	</table>
</td></tr>
	<!-- <table cellpadding=0 cellspacing=0 border=0 width="100%" colspan="8">  -->
	<tr><td colspan=4 class=label height=5></td></tr>
	<tr>
		<td  class=label width='24%'><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/></td>
		<td  class=label  width='260pt'><B><%=Birth_place_desc%></B></td>

		<td  class=label ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td  class=label ><B>
		  <%if(gender.equals("M"))
			{  %>
				<b><fmt:message key="Common.male.label" bundle="${common_labels}"/><b>
		   <%}else if(gender.equals("F")){%>
				<b><fmt:message key="Common.female.label" bundle="${common_labels}"/><b>
		   <%}else if(gender.equals("U")){%>
				<b><fmt:message key="Common.unknown.label" bundle="${common_labels}"/><b>
		   <%}%>
		</B></td>

		</tr>
		<tr>
		<td  class=label ><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
		<td  class=label >
		<B><%=agey%><%=agem%><%=aged%></B></td>

		<td  class=label wrap><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
		<td  class=label ><B><%=date_of_birth%></B></td>
		<td colspan=2></td>
	</tr>

	<tr><td colspan=4 class=label height=5></td></tr>

	<tr>
		
		<td  class=label><fmt:message key="Common.residency.label" bundle="${common_labels}"/></td>
		<td  class=label >
		<%if(citizen){%>
			<B><fmt:message key="Common.citizen.label" bundle="${common_labels}"/></B>
		<%}else{
			%>
			<B><fmt:message key="Common.noncitizen.label" bundle="${common_labels}"/></B>
		<%}%>
		</td>

		<td  class=label><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td  class=label >
		<%
			if(legal){
			%>
			
			

			<B><fmt:message key="Common.LegalResident.label" bundle="${common_labels}"/></B>
			<%}else{%>
			<B><fmt:message key="Common.IllegalResident.label" bundle="${common_labels}"/></B>
			<%}%>
		
		</td>
	</tr>
	<tr><td colspan=4 class=label height=5></td></tr>
	<tr>
		<td  class=label ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
		<td  class=label  ><B><%=nationality%></B></td>

		<td  class=label ><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
		<td  class=label  ><B><%=raceDesc%></B></td>
     <tr>
	<tr>
		<td  class=label ><fmt:message key="eMP.ethnicity.label" bundle="${mp_labels}"/></td>
		<td  class=label ><B><%=Race_desc%></B></td>
	</tr>
	</table>

</td>
</tr>
<tr><td colspan=4 class=label height=5></td></tr>
</table>


<script>prevTabObj='rfrd_from'</script>
<table border='0' width='100%' tabindex=-1>
<tr ><td  class='white' >
 <ul class="tablist" style="padding-left:0px">
			<li class="tablistitem" title="<fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/>">
					<a onclick="tab_click('rfrd_from')" class="tabClicked" id="rfrd_from" tabindex=-1 >
						<span class="tabSpanclicked" id="rfrd_fromspan"><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="<fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/>">
					<a onclick="javascript:tab_click('rfrd_to')" id="rfrd_to" class="tabA" >
					<span class="tabAspan" id="rfrd_tospan"><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></span>
					</a>
				</li>
		 </ul>
	</td></tr>
</table>

<a name='start' id='start'></a>
<table cellpadding=0 cellspacing=0 border=0 width="100%" id='reftotable' tabindex=-1 >
<tr><td colspan=4 class=label >&nbsp;</td></tr>
<tr>
	 <td class=label width='24%'><fmt:message key="eMP.ReferralLetterNo.label" bundle="${mp_labels}"/></td>
	<td  class=label   width='260pt'><B><%=referral_letter_no%></B></td>
	 <td  class=label width='205pt'><fmt:message key="Common.ReceivedDate.label" bundle="${common_labels}"/></td>
	 <td  class=label ><B><%=received_date%></B></td>
    
</tr>
 <tr><td colspan=4 class=label >&nbsp;</td></tr>

  <tr>
	  <td class=label  ><fmt:message key="Common.ReferredDate.label" bundle="${common_labels}"/></td>
      <td  class=label ><B><%=referral_date%></B></td>
	  <td  class=label  ><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></td>
	  <td  class=label ><B><%=preferred_treatment_date%></B>	</td>
 </tr>
  <tr><td colspan=4 class=label >&nbsp;</td></tr>

  <tr>
	  <td  class=label   ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
      <td  class=label  ><B><%=referralReason%></B></td>
      <td  class=label   ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
	  <td  class=label  ><B><%=from_ref_type_desc%>
	
	  </B></td>
  </tr>
  <tr><td colspan=4 class=label >&nbsp;</td></tr>

  <tr>
      <td  class=label  ><fmt:message key="Common.HealthcareSettingType.label" bundle="${common_labels}"/></td>
	  <td  class=label  > <B><%=from_hcare_setting_desc%></B></td>
     <!-- <td  class=label  ><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></td> -->
	 <!-- Below lines was added against ML-MMOH-SCF-0301 on 12-jan-2016 -->
      <td  class=label  ><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></td>
	  <td  class=label ><B><%=Ref_source%></B>
		<%if(from_ref_type.equals("X") && ! from_long_name.equals("") && ! from_long_name.equals("--select--")){%>
			<img src='../../eCommon/images/more.gif' name="lng_name" id="lng_name" align=center alt="<%=from_long_name%>">
		<%}%>
	</td>
  </tr>
  <tr><td colspan=4 class=label >&nbsp;</td></tr>

  <tr>
      <td  class=label  ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
      <td  class=label ><B><%=From_Splty_desc%></B></td> 
      <td colspan=2 align=right><input type='button' class='button' name='clinical_details' id='clinical_details' value='<fmt:message key="eMP.clinicaldetails.label" bundle="${mp_labels}"/>' onclick="Clinical_Details(this,'View_Referral');" >&nbsp;<input  type="button" class=BUTTON value='<fmt:message key="Common.notes.label" bundle="${common_labels}"/>' onClick="ref_note()" onBlur="" id='notes' name='notes' >
	  </td>
  </tr> 
  <tr><td colspan=4 class=label >&nbsp;</td></tr>

  <tr>
  	<%
	if(from_ref_type.equals("L") || from_ref_type.equals("E"))
		{%><td  class=label ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
	 <%if(!from_ref_locn_desc.equals(""))
		{
		%>
			<td  class=label><B><%=from_ref_locn_type%></b></td>
			<td  class=label ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td  class=label ><B><%=from_ref_locn_desc%></b></td>
	   	<%
	  	}
		else
		{%>
			<td  class=label colspan=3 ><B><%=from_ref_locn_type%></B></td>
		<%
		}
		}
		else
		{%>
			<td  class=label ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td  class=label colspan='3'><B><%=from_ref_locn_desc%></B></td>
			<%
		}
			%>
	</tr>

 <!--   <table cellpadding=0 cellspacing=0 border=0 width="100%" colspan="4"> -->
   <tr><td colspan=4 class=label >&nbsp;</td></tr>
 
   <tr>
	    <td  class=label width='24%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
 	    <td  class=label   width='260pt'><B><%=from_ref_pract_name%></B></td> 
	    <td  class=label width='200pt' ><fmt:message key="Common.telno.label" bundle="${common_labels}"/></td>
	    <td  class=label  ><B><%=practitionerResTelNo%></B></td>
     </tr>
   <tr><td colspan=4 class=label >&nbsp;</td></tr>
  
   <tr>
		<td  class=label ><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>
 	    <td  class=label  ><B><%=practitionerMobileNo%></B></td> 
	    <td  class=label><fmt:message key="Common.PagerNo.label" bundle="${common_labels}"/></td>
	    <td  class=label ><B><%=practitionerPagerNo%></B></td>
    </tr>
 <!-- <tr><td colspan=18 class=label height=5></td></tr>  -->
<!-- </table>

<table cellpadding=0 cellspacing=0 border=0 width="100%" colspan="4"> -->
  <tr>   <td colspan=4 class=columnheader><b><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></b></td></tr>
 
<!--      
</table>


<table cellpadding=0 cellspacing=0 border=0 width="100%" colspan="4" style='visibility:<%=visibility_table%>'> -->
<tr><td colspan=4 class=label height=7></td></tr>
<tr>
	 <td  class=label width='24%'  ><fmt:message key="eMP.OtherDocAttached.label" bundle="${mp_labels}"/></td>
	 <td  colspan='2'><textarea name="txt" rows="3" cols="56" value='' readOnly></textarea> </td>
	<td class=label height=5></td>	
</tr>
<tr><td colspan=4 class=label height=8></td></tr>
<tr>
	<td colspan=4 class=label height=5></td>
	
</tr>
<!-- </table> -->
<tr><td colspan=4 class=label height=5></td></tr>
</table>

<a name='rfrdto' id='rfrdto' tabindex='' >
<table  cellpadding=4 cellspacing=0 border=0 width="100%"  id='rfrdto1'>
  <tr>
	
	<td   class=label ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td  class=label  ><B><%=to_speciality_desc%></B> </td>
	<td   class=label ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
	<td  class=label  ><B><%=to_service_desc%></B></td>
 </tr>
	<tr>
	<td  class=label ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/> </td>
	<td  class=label ><B><%=to_locn_type_desc%></B></td>
	<td class=label><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td class=label><B><%=toRefLocnDesc%></B></td>
	</tr>
	<tr> 
    <td  class=label ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
	<td  class=label ><B><%=to_ref_pract_name%></B></td>	
    <%if(or_install_yn.equals("Y"))
  {%>

    <td  class=label  ><fmt:message key="eMP.OrderableProcedure.label" bundle="${mp_labels}"/></td>
	<td  class=label ><B><%=orderCatalog%></B></td>
  <%}else{%>
    <td  class=label  ></td>
	<td  class=label ><B></B></td>
  	
	<%}%>
 
   </tr>
   <tr>
    <td   class=label ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
	
	<!--Added by Suji Keerthi for NMC-JD-CRF-0130-->
	
 <% 
                         if(isReferralPriorityAppl){ 	
                            	PreparedStatement prestmt			= null;      		
                   				ResultSet resultSet				= null;
                   				String ref_priority="";
                   				
                   				try 
                   				{				
                   				prestmt		= con.prepareStatement("SELECT PRIORITY_DESC FROM AM_REFERRAL_PRIORITY WHERE PRIORITY_CODE = (SELECT REFERRAL_PRIORITY FROM PR_REFERRAL_REGISTER WHERE REFERRAL_ID = ?)");
                   				prestmt.setString(1,referralid);			
                   						
                   				resultSet	= prestmt.executeQuery() ;
                   				if (resultSet !=null && resultSet.next())
                   				{
                   					ref_priority = resultSet.getString("PRIORITY_DESC");
                   				}
                   				}catch(Exception e){
                   					e.printStackTrace();
                   				}finally
                   				{
                   					if(resultSet!=null)resultSet.close();
                   					if(prestmt!=null)prestmt.close();
                   				}
%>					<td  class=label ><B><%=ref_priority%> </B></td><%	
						}else{   													
%> <!--Ended by Suji Keerthi for NMC-JD-CRF-0130-->
					<td  class=label ><B>
<%
		if((referral_priority.equalsIgnoreCase("E"))) 
			  out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels"));
			if((referral_priority.equalsIgnoreCase("U"))) 
			 out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.semiemergency.label","common_labels"));
			if((referral_priority.equalsIgnoreCase("R")))
			 out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.for.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels"));
			if((referral_priority.equalsIgnoreCase("L")))
			 out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.elective.label","common_labels"));
						
%>				</B></td><%
					}
	 %>
	
	<td  class=label  ><fmt:message key="eMP.ReferredForIP.label" bundle="${mp_labels}"/></td>
	<td  class=label ><B><%=referredForIP%></B></td>
   </tr>
    <tr>
	<td   class=label width='24%'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
	<td  class=label   width='255pt'><B><%=toRefTypeDesc%></B> </td>
	<td   class=label   width='200pt'><fmt:message key="Common.HealthcareSettingType.label" bundle="${common_labels}"/></td>
	<td  class=label   ><B><%=toHcareSettingDesc%></B></td>
    </tr>
	<tr>
	<td   class=label ><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></td>
	<td  class=label colspan=3><B><%=ToRef_source%></B>
		 <%if(toRefType.equals("X") && ! to_long_name.equals("") && ! from_long_name.equals("--select--")){%>
			<img src='../../eCommon/images/more.gif' name="lng_name" id="lng_name" align=center alt="<%=to_long_name%>">
		<%}%>
</td>
	</tr>
<tr><td colspan="4">

	
<table  cellpadding=2 cellspacing=0 border=0 width="100%" colspan="4">

<%int i=0;
    sql.setLength(0);
	sql.append("select to_char(a.ACTION_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') action_date_time,DECODE(a.ACTION_TYPE,'AS', 'Appt Scheduled','AR', 'Appt Re-scheduled','AC', 'Appt Cancelled','RF', 'Follow-up','RR', 'Rejected','CO', 'Completed') ACTION_TYPE_DESC,b.CONTACT_REASON ACTION_REASON_DESC,a.ACTION_REF_ID,a.ACTION_REMARKS,a.ACTIONED_BY from PR_REFERRAL_REGISTER_ACTION ##REPDB## a, am_contact_reason ##REPDB## b where a.ACTION_REASON_CODE=b.CONTACT_REASON_CODE(+) and a.REFERRAL_ID='"+referralid +"' and a.FACILITY_ID='"+facility_id+"'order by a.ACTION_DATE_TIME desc");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	
	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	sqlFinal = sql.toString();
	sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
	/*End*/
	pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	rs = pstmt.executeQuery();
    
	int j=0;
	while(rs!=null &&rs.next())
		{
	       if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	       else
		  	classValue = "QRYODD" ;
		
		 action_date_time			= rs.getString("action_date_time");
		 if (action_date_time!=null)
		{
			 action_date_time= DateUtils.convertDate(action_date_time,"DMYHMS","en",localeName);
		}
		else
			action_date_time="";
		
		 action_type_desc			= rs.getString("action_type_desc");
		 if (action_type_desc==null) action_type_desc="";
		
		 action_reason_desc		= rs.getString("action_reason_desc");
		 if (action_reason_desc==null) action_reason_desc = "";
		 action_ref_id		= rs.getString("action_ref_id");
		 if (action_ref_id==null) action_ref_id="";
		 action_remarks		= rs.getString("action_remarks");
		 if (action_remarks==null) action_remarks = "";
		
		 actioned_by		= rs.getString("actioned_by");
		 if (actioned_by==null) actioned_by="";
    if(j==0)
	{
		%> 


<tr>
<td class='columnheader' ><fmt:message key="Common.datetime.label" bundle="${common_labels}"/> </td>
<td class='columnheader'><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.reason.label" bundle="${common_labels}"/> </td>
<td class='columnheader'><fmt:message key="eMP.Reference.label" bundle="${mp_labels}"/> </td>
<td class='columnheader'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </td>
<td class='columnheader'><fmt:message key="Common.ActionedBy.label" bundle="${common_labels}"/></td>
</tr>
		
	<%j=1;}%>	
		
<tr>
<td class='<%=classValue%>'  ><font size=1><%=action_date_time%></font></td>
<td class='<%=classValue%>' ><font size=1><%=action_type_desc%></font></td>
<td class='<%=classValue%>'><font size=1><%=action_reason_desc%></font></td>
<td class='<%=classValue%>' ><font size=1><%=action_ref_id%></font></td>
<td class='<%=classValue%>' ><font size=1><%=action_remarks%></font></td>
<td class='<%=classValue%>' ><font size=1><%=actioned_by%></font></td>
</tr>
		<%i++;}

if(rs!=null)rs.close();
if(pstmt!=null)pstmt.close();


%>

</table>
</td>
</tr>
</table>


	</a>

<input type='hidden' name='referral_notes' id='referral_notes' value = "<%=displaydata%>"  ></input>

<input type='hidden' name='otherDocAttached' id='otherDocAttached' value="<%=otherDocAttached%>"></input>

<input type='hidden' name='exm_clinical_find' id='exm_clinical_find' value="<%=examAndClinFindings%>"></input>
<input type='hidden' name='concat_address_hidden' id='concat_address_hidden' value="">		
<input type='hidden' name='diagnosis' id='diagnosis' value="<%=diagnosis%>"></input>
<input type='hidden' name='treatment' id='treatment' value="<%=treatment%>"></input>
<input type='hidden' name='addr1_type' id='addr1_type' value=''>
<input type='hidden' name='addr_line1' id='addr_line1' value='<%=addr_line1%>' maxlength='30'>
<input type='hidden' name='addr_line2' id='addr_line2' value='<%=addr_line2%>' maxlength='30'>
<input type='hidden' name='addr_line3' id='addr_line3' value='<%=addr_line3%>' maxlength='30'>
<input type='hidden' name='addr_line4' id='addr_line4' value='<%=addr_line4%>' maxlength='30'>
<input type='hidden' name='res_town_code' id='res_town_code' value='<%=resTownCode%>' maxlength='6'>
<input type='hidden' name='res_area_code' id='res_area_code' value='<%=resAreaCode%>' maxlength='6'>
<input type='hidden' name='postal_code' id='postal_code' value='<%=postalCode%>' maxlength='8'>	
<input type='hidden' name='region_code' id='region_code' value='<%=regionCode%>' maxlength='8'>	
<input type='hidden' name='country_code' id='country_code' value='<%=countryCode%>' maxlength='4'>
<input type='hidden' name='contact1_name' id='contact1_name' value='<%=contact1_no%>'>
<input type='hidden' name='invalid1_yn' id='invalid1_yn' value=''>

<input type='hidden' name='addr2_type' id='addr2_type' value=''>
<input type='hidden' name='mail_addr_line1' id='mail_addr_line1' maxlength='30' value='<%=mailAddress[0]%>'>
<input type='hidden' name='mail_addr_line2' id='mail_addr_line2' maxlength='30' value='<%=mailAddress[1]%>'>
<input type='hidden' name='mail_addr_line3' id='mail_addr_line3' value='<%=mailAddress[2]%>'  maxlength='30'>
<input type='hidden' name='mail_addr_line4' id='mail_addr_line4' value='<%=mailAddress[3]%>' maxlength='30'>
<input type='hidden' name='mail_res_town_code' id='mail_res_town_code' value='<%=mailResTownCode%>' maxlength='6'>
<input type='hidden' name='mail_res_area_code' id='mail_res_area_code' value='<%=mailResAreaCode%>' maxlength='6'>
<input type='hidden' name='mail_postal_code' id='mail_postal_code' value='<%=mailPostalCode%>' maxlength='8'>
<input type='hidden' name='mail_region_code' id='mail_region_code' value='<%=mailRegionCode%>' maxlength='8'>
<input type='hidden' name='mail_country_code' id='mail_country_code' value='<%=mailCountryCode%>' maxlength='4'>
<input type='hidden' name='contact2_name' id='contact2_name' value='<%=contact2_no%>'>
<input type='hidden' name='invalid2_yn' id='invalid2_yn' value=''>

<input type='hidden' name='ct_tab_name' id='ct_tab_name' > 

</form>
</body>

<script>
	func1();
</script>

<%
 }
}

  sql.setLength(0);
  if(rs!=null)	rs.close();
  if(pstmt!=null)	pstmt.close();

}catch(Exception e)
	{
		out.print(e.toString());
		e.printStackTrace();
		
	}finally
	{
	   if(con != null)         
		ConnectionManager.returnConnection(con,request);
	}
%>

</html>

<%!
public static String checkForNull(String inputString)
{
	return((inputString == null || inputString.equals("null")) ? "" : inputString);
}
	
%>


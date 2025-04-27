<!DOCTYPE html>
<%@ page import ="java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<head>

	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eOP/js/RegPatReferral.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>

async function ref_note()
{
	var notes = document.forms[0].referral_notes.value;

	var dialogHeight= "11" ;
	var dialogWidth = "47" ;                    
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=no" ;
	var arguments	= unescape(document.forms[0].referral_notes.value);
	var temp=notes;
	var arr =new Array();
	arr=temp.split('\n');
	for(u=0;u<arr.length;u++)
	arr[u]=arr[u]+"`";
	var retVal =await  window.showModalDialog("../../eOP/jsp/Referral_Notes.jsp?from=search",arguments,features);
}

function close_win()
{
 window.close();
}

</script>
<title><fmt:message key="eCA.ViewReferralDetails.label" bundle="${ca_labels}"/></title>
</head>

<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null ;
	PreparedStatement orgTypePstmt = null;
	ResultSet orgTypeRS = null;
	String org_type_data ="";
	String org_type_data_display ="";
		
	
	String referralid = request.getParameter("referral_id");

	String[] names			= new String[4] ;
    String[] name_prompts	= new String[4] ;
	StringBuffer sql				=new StringBuffer();
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
	String from_ref_type= "";
	String from_ref_locn_desc= "";
	String from_ref_pract_name= "";
	String to_speciality_desc= "";
	String to_service_desc= "";
	String to_ref_pract_name= "";
	//Clob ref_notes		= null;
	StringBuffer displaydata		= new StringBuffer();
	
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


%>
	
	<body  onLoad="FocusFirstElement();window.toolbar=true" OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
	<form name="ViewPatReferral_form" id="ViewPatReferral_form" value="<%=referralid%>" target=messageFrame method=post>
<%
	try
	{	
	
	con = ConnectionManager.getConnection(request);

   	sql.append( "select name_prefix_accept_yn, name_suffix_accept_yn, ");
    sql.append(" nvl(name_prefix_prompt,'&nbsp;')name_prefix_prompt, first_name_accept_yn,  nvl(first_name_prompt,'&nbsp;')first_name_prompt, nvl(name_suffix_prompt,'&nbsp;')name_suffix_prompt,");
	sql.append(" second_name_accept_yn, nvl(second_name_prompt,'&nbsp;')second_name_prompt, third_name_accept_yn, ");
	sql.append(	" nvl(third_name_prompt,'&nbsp;')third_name_prompt, family_name_accept_yn,");
	sql.append(	" first_name_order, second_name_order, third_name_order, family_name_order,nvl(family_name_prompt,'&nbsp;')family_name_prompt,alternateID1.alt_id_type alternateIDType1,alternateID2.alt_id_type alternateIDType2,alternateID3.alt_id_type alternateIDType3,alternateID4.alt_id_type alternateIDType4, alternateID1.short_desc alternateID1desc, alternateID2.short_desc alternateID2desc, alternateID3.short_desc alternateID3desc, alternateID4.short_desc alternateID4desc, nvl(nat_id_prompt, 'NRIC No.') nat_id_prompt "); 
	sql.append(" from mp_param, mp_alternate_id_type alternateID1, mp_alternate_id_type alternateID2, mp_alternate_id_type alternateID3, mp_alternate_id_type alternateID4 where alternateID1.alt_id_type = mp_param.alt_id1_type and alternateID2.alt_id_type = nvl(mp_param.alt_id2_type, mp_param.alt_id1_type) and alternateID3.alt_id_type = nvl(mp_param.alt_id3_type, mp_param.alt_id1_type) and alternateID4.alt_id_type = nvl(mp_param.alt_id4_type, mp_param.alt_id4_type) ");	 
		
		//out.println("<script>alert(\"sql1="+sql+"\");</script>");
		//out.println("sql1="+sql);
	pstmt = con.prepareStatement(sql.toString());
	rs = pstmt.executeQuery();
    while(rs!=null &&rs.next())
		{
		// prefix_accept_yn		= rs.getString("name_prefix_accept_yn");
		 prefix_prompt			= rs.getString("name_prefix_prompt");
		 if (prefix_prompt==null) prefix_prompt="";
		// suffix_accept_yn		= rs.getString("name_suffix_accept_yn");
		 suffix_prompt			= rs.getString("name_suffix_prompt");
		 if (suffix_prompt==null) suffix_prompt="";
		// first_name_accept_yn   = rs.getString("first_name_accept_yn");
		 first_name_prompt		= rs.getString("first_name_prompt");
		 if (first_name_prompt==null) first_name_prompt="";
		 first_name_order		= rs.getString("first_name_order");
		 if (first_name_order==null) first_name_order = "0";
		// second_name_accept_yn  = rs.getString("second_name_accept_yn");
		 second_name_prompt		= rs.getString("second_name_prompt");
		 if (second_name_prompt==null) second_name_prompt="";
		 second_name_order		= rs.getString("second_name_order");
		 if (second_name_order==null) second_name_order = "0";
		 //third_name_accept_yn	= rs.getString("third_name_accept_yn");
		 third_name_prompt		= rs.getString("third_name_prompt");
		 if (third_name_prompt==null) third_name_prompt="";
		 third_name_order		= rs.getString("third_name_order");
		 if (third_name_order==null) third_name_order = "0";
		// family_name_accept_yn  = rs.getString("family_name_accept_yn");
		 family_name_prompt		= rs.getString("family_name_prompt");
		 if (family_name_prompt==null) family_name_prompt="";

		 family_name_order		= rs.getString("family_name_order");
		 if (family_name_order==null) family_name_order = "0";

		 nationalIDPrompt		= rs.getString("nat_id_prompt");
		 if(nationalIDPrompt==null) nationalIDPrompt="";

		 for(int i=0;i<4;i++)
		 {
		 	altIdTypeDescription[i]=rs.getString("alternateID"+(i+1)+"desc");
			if(altIdTypeDescription[i]==null) altIdTypeDescription[i]="";
		 }
		// alternateIDType4

		for(int i=0;i<4;i++)
		{
			altIdType[i]=rs.getString("alternateIDType"+(i+1));
			if(altIdType[i]==null)	altIdType[i]="";
		}
		
	}
	
	if (rs!=null) rs.close();
    if (pstmt!=null) pstmt.close();
	   
	   sql.append("select res_area_code, res_town_code, country_code, postal_code, region_code, mail_region_code, decode(referred_for_ip,'B','Booking','A','Admission','No') referred_for_ip, national_id_no, alt_id1_type, alt_id2_type,alt_id3_type, alt_id4_type, oth_alt_id_type, alt_id1_no, alt_id2_no,alt_id3_no, alt_id4_no, oth_alt_id_no, mail_addr_line1, mail_addr_line2,  mail_addr_line3, mail_res_town_code, mail_res_area_code, mail_country_code, mail_postal_code,  mail_addr_line4, race_desc, referral_reason, other_doc_att, exam_and_clin_findings, diagnosis, treatment, pract_res_tel_num, pract_mobile_num, pract_pager_num, patient_id,patient_name,decode(sex,'M','Male','F','Female','U','Unknown') gender,name_prefix,first_name,second_name,third_name,family_name,name_suffix,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1)||'Y' agey,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),2)||'M' agem, calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),3)||'D' aged,to_char(date_of_birth,'dd/mm/yyyy') date_of_birth,nationality,addr_line1,addr_line2,addr_line3,addr_line4,	contact1_no,contact2_no,from_hcare_setting_desc, decode(to_ref_type,'X',to_ref_desc,to_facility_name)Ref_source, to_hcare_setting_desc,to_char(referral_date,'dd/mm/yyyy') referral_date,referral_letter_no,to_char(preferred_treatment_date,'dd/mm/yyyy') preferred_treatment_date,decode(referral_priority,'E','Emergency','R','Regular','U','Urgent')referral_priority ,to_char(received_date,'dd/mm/yyyy') received_date,decode(from_ref_type,'X','External','E','Enterprise','Login Facility') from_ref_type, decode(to_ref_type,'X','External','E','Enterprise','Login Facility') to_ref_type,decode(from_ref_type,'X',from_ref_locn_desc,decode(from_locn_type,'C',from_clinic_desc,from_nurs_unit_desc)) from_ref_locn_desc, decode(to_ref_type,'X',to_ref_locn_desc,decode(to_locn_type,'C',to_clinic_desc,to_nurs_unit_desc)) to_ref_locn_desc,decode(from_ref_type,'X',from_ref_pract_name,from_fcy_pract_name)from_ref_pract_name,decode(to_ref_type,'X',to_ref_pract_name,to_fcy_pract_name) to_ref_pract_name,to_speciality_desc, to_service_desc, ref_notes, status, decode(citizen_yn,'Y','true','false') citizen, decode(legal_illegal_yn,'Y','true','false') legal, mp_alternate_id_type.short_desc alternateIDdesc, NVL2(BIRTH_PLACE_CODE, BIRTH_PLACE_DESC, BIRTH_PLACE_DESCRIPTION) BIRTH_PLACE_DESC ,RACE_DESC , FROM_SPLTY_DESC ,			to_char(ALT_ID1_DATE,'dd/mm/yyyy') ALT_ID1_DATE,		to_char(ALT_ID2_DATE,'dd/mm/yyyy') ALT_ID2_DATE,	to_char(ALT_ID3_DATE,'dd/mm/yyyy') ALT_ID3_DATE,	to_char(ALT_ID4_DATE,'dd/mm/yyyy') ALT_ID4_DATE  from pr_referral_register_vw, mp_alternate_id_type where  referral_id = ? and mp_alternate_id_type.alt_id_type (+) = nvl(pr_referral_register_vw.oth_alt_id_type, ?) ");

	pstmt = con.prepareStatement(sql.toString());
    pstmt.setString(1, referralid);
	pstmt.setString(2, altIdType[0]);
	rs = pstmt.executeQuery();
	while (rs!=null && rs.next())
	{
		//out.println("<script>alert(\"here\")</script>");
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
		nationality				= rs.getString("nationality");
		addr_line1				= rs.getString("addr_line1");
		addr_line2				= rs.getString("addr_line2");
		addr_line3				= rs.getString("addr_line3");
		addr_line4				= rs.getString("addr_line4");
		contact1_no				= rs.getString("contact1_no");
		contact2_no				= rs.getString("contact2_no");
		from_hcare_setting_desc	= rs.getString("from_hcare_setting_desc");
		//out.println("<script>alert(\""+from_hcare_setting_desc+"\")</script>");
		referral_date			= rs.getString("referral_date");
		referral_letter_no		= rs.getString("referral_letter_no");
		preferred_treatment_date= rs.getString("preferred_treatment_date");
		referral_priority		= rs.getString("referral_priority");
		received_date			= rs.getString("received_date");
		from_ref_type			= rs.getString("from_ref_type");
		//out.println("<script>alert(\""+from_ref_type+"\")</script>");
		from_ref_locn_desc		= rs.getString("from_ref_locn_desc");
		from_ref_pract_name		= rs.getString("from_ref_pract_name");
		to_speciality_desc		= rs.getString("to_speciality_desc");
		to_service_desc			= rs.getString("to_service_desc");
		to_ref_pract_name		= rs.getString("to_ref_pract_name");
		//ref_notes				= rs.getClob("ref_notes");
		status					= rs.getString("status");
		citizen					= Boolean.valueOf(rs.getString("citizen")).booleanValue();
		nationalIdNo			= rs.getString("national_id_no");
		othAltIdTypeDescription	= rs.getString("alternateIDdesc");
		othAltIdNo				= rs.getString("oth_alt_id_no");
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
		toRefLocnDesc			= rs.getString("to_ref_locn_desc");
		toHcareSettingDesc		= rs.getString("to_hcare_setting_desc");
		referredForIP			= rs.getString("referred_for_ip");
		resAreaCode				= rs.getString("res_area_code");
		resTownCode				= rs.getString("res_town_code");
		countryCode				= rs.getString("country_code");
		regionCode				= rs.getString("region_code");
		postalCode				= rs.getString("postal_code");
		Birth_place_desc		= rs.getString("BIRTH_PLACE_DESC");
		Race_desc				= rs.getString("RACE_DESC");
		From_Splty_desc			= rs.getString("FROM_SPLTY_DESC");
		Alt_ID1_date			= rs.getString("ALT_ID1_DATE");
		Alt_ID2_date			= rs.getString("ALT_ID2_DATE");
		Alt_ID3_date			= rs.getString("ALT_ID3_DATE");
		Alt_ID4_date			= rs.getString("ALT_ID4_DATE");
		Ref_source			= rs.getString("Ref_source");

		for(int i=0;i<4;i++)
		{
			altIdNo[i]=rs.getString("alt_id"+(i+1)+"_no");
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
		if (nationality==null) nationality ="&nbsp;&nbsp;";
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
		if (from_ref_locn_desc==null) from_ref_locn_desc ="";
		if (from_ref_pract_name==null) from_ref_pract_name ="";
		if (referral_priority==null) referral_priority ="";
		if (received_date==null) received_date ="";
		if (to_speciality_desc==null) to_speciality_desc ="";
		if (preferred_treatment_date==null) preferred_treatment_date ="";
		if (to_service_desc==null) to_service_desc ="";
		if (to_ref_pract_name==null) to_ref_pract_name ="";
		//	if (ref_notes==null) ref_notes ="";
		Clob note=rs.getClob("REF_NOTES");
		if(note!=null)
			{
			java.io.BufferedReader r = new java.io.BufferedReader(note.getCharacterStream());
			String line = null;
			while((line=r.readLine()) != null) displaydata.append(line+"\n");
		}

	if(status==null) status="";
	if(nationalIdNo==null) nationalIdNo="";;
	if(othAltIdTypeDescription==null) othAltIdTypeDescription="";;
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
	if(diagnosis==null) diagnosis="";;
	if(treatment==null) treatment="";
	if(practitionerResTelNo==null) practitionerResTelNo="";
	if(practitionerMobileNo==null) practitionerMobileNo="";
	if(practitionerPagerNo==null) practitionerPagerNo="";
	if(toRefType==null) toRefType="";
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



	for(int i=0;i<4;i++)
	{
		if(altIdNo[i]==null)
			altIdNo[i]="";

		if(mailAddress[i]==null)
			mailAddress[i]="";
		
		name_prompts[i]="";
		names[i]="";
	
	}
		
		if( first_name_order.equals("1") )
		{
			names[0]		=first_name  ;
			name_prompts[0] = first_name_prompt ;
		}
		else if(first_name_order.equals("2"))
		{
			names[1]		=first_name  ;
			name_prompts[1] = first_name_prompt;
		}
		else if(first_name_order.equals("3"))
		{
			names[2]		=first_name;
			name_prompts[2] = first_name_prompt;
		}
		else if(first_name_order.equals("4"))
		{
			names[3]		=first_name  ;
			name_prompts[3] = first_name_prompt;
		}

	
		if( second_name_order.equals("1") )
		{
			names[0]		=second_name  ;
			name_prompts[0] = second_name_prompt ;
		}
		else if(second_name_order.equals("2"))
		{
			names[1]		=second_name  ;
			name_prompts[1] = second_name_prompt;
		}
		else if(second_name_order.equals("3"))
		{
			names[2]		=second_name  ;
			name_prompts[2] = second_name_prompt;
		}
		else if(second_name_order.equals("4"))
		{
			names[3]		=second_name  ;
			name_prompts[3] = second_name_prompt;
		}
	
		if( third_name_order.equals("1") )
		{
			names[0]		=third_name  ;
			name_prompts[0] = third_name_prompt ;
		}
		else if(third_name_order.equals("2"))
		{
			names[1]		=third_name  ;
			name_prompts[1] = third_name_prompt;
		}
		else if(third_name_order.equals("3"))
		{
			names[2]		=third_name  ;
			name_prompts[2] = third_name_prompt;
		}
		else if(third_name_order.equals("4"))
		{
			names[3]		=third_name  ;
			name_prompts[3] = third_name_prompt;
		}
	
		if( family_name_order.equals("1") )
		{
			names[0]		=family_name  ;
			name_prompts[0] = family_name_prompt ;
		}
		else if(family_name_order.equals("2"))
		{
			names[1]		=family_name  ;
			name_prompts[1] = family_name_prompt;
		}
		else if(family_name_order.equals("3"))
		{
			names[2]		=family_name  ;
			name_prompts[2] = family_name_prompt;
		}
		else if(family_name_order.equals("4"))
		{
			names[3]		=family_name  ;
			name_prompts[3] = family_name_prompt;
		}

try{

	String orgTypeSQL ="select org_type from pr_referral_register, am_referral where referral_id = ? and from_ref_code = referral_code";
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
}
catch(Exception e){
//out.println("Exception @ ViewPatReferral.jsp"+e.toString());//COMMON-ICN-0181
e.printStackTrace();//COMMON-ICN-0181
}

if(org_type_data.equals("G"))
	{
		org_type_data_display="Gov";
	}
else 
	{
	org_type_data_display="Pvt";
	}

%>
<%!
public ArrayList getData1(String sql,String[] whereClause,HttpServletRequest request,JspWriter out,Connection con) throws Exception
{

   ArrayList arrL_of_HashMap                            = new ArrayList() ;
 //  Connection con                                                                     = null ;
   PreparedStatement pstmt                              = null ;
   ResultSet resultSet                                                  = null ;
   ResultSetMetaData resultSetMetaData  = null;
   

 try {

	   pstmt    = con.prepareStatement(sql) ;

                 
        if (whereClause!=null)
                for (int index=0; index<whereClause.length ;index++ )
                        pstmt.setString( index+1, whereClause[index]);

    resultSet = pstmt.executeQuery() ;
        if ( resultSet != null )
         {
                        resultSetMetaData   =   resultSet.getMetaData();

                        while ( resultSet.next() )
                                {
                                
                                HashMap hmRecord                                =  new HashMap();

                                for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ )
                                {
                                        String column_Val=resultSet.getString(resultSetMetaData.getColumnName(i));
                                        if(column_Val==null) column_Val="";     

                                        hmRecord.put(resultSetMetaData.getColumnName(i),column_Val);
                                
                                }       


                                        arrL_of_HashMap.add(hmRecord) ;
                                        //hmRecord.clear(); //modified here

                                 }
                
        }
   
	if(resultSet!=null) resultSet.close();
    }catch ( Exception e )
        {
            
            e.printStackTrace() ;
                 //   out.println(e.toString());  //COMMON-ICN-0181
                      e.printStackTrace();//COMMON-ICN-0181   
        }
        finally
        {
            try {
                        
                                if(pstmt!=null) pstmt.close();
                                if(resultSet!=null)     resultSet.close();
                //              ConnectionManager.returnConnection(con,request);

              }
                catch(Exception es) { }
        }

        return arrL_of_HashMap;

}
%>

<table cellpadding=3 cellspacing=0 border="0" width="100%">
<tr>
<td width='100%'>
<table cellpadding=3 cellspacing=0 border=0 width="100%" colspan="4">
	<tr>
		<td  class=label   width='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td  class='label' width='25%'><b><%=patient_id%></b></td>
		<td  class='label' width='25%' ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
		<td  class='label' width="25%" ><b><%=patient_name%></b> </td>
	</tr>
</table>

<table cellpadding=3 cellspacing=0 border=0 width="100%">
<tr>
	<td class='label' width='25%' ><%=nationalIDPrompt%></td>
	<td class='label' width='25%'><B><%=nationalIdNo%></B></td>
	<td width='25%'>&nbsp;</td>
	<td width='25%'>&nbsp;</td>
</tr>

<%if(!othAltIdNo.equals("")){%>
	<tr>
		<td class=label width='25%'><%=othAltIdTypeDescription%></td>
		<td  class=label width='25%'><B><%=othAltIdNo%></B> </td>
		<td width='25%'>&nbsp;</td>
		<td width='25%'>&nbsp;</td>
	</tr>

<%}%>

<%if(!altIdTypeDescription[0].equals("") || !altIdTypeDescription[1].equals("") || !altIdTypeDescription[2].equals("") || !altIdTypeDescription[3].equals(""))
{%>
	<tr>
	<%	for(int i=0;i<4;i++)
		{ %>
			<td  class=label width='12%' nowrap><%=altIdTypeDescription[i]%></td>
			<td  class=label width='13%'><B><%=altIdNo[i]%></B>
			</td>
	<%  } %>
	</tr>

<%}
if(!Alt_ID1_date.equals("") || !Alt_ID2_date.equals("") || !Alt_ID3_date.equals("") || !Alt_ID4_date.equals(""))
{%>
	<tr>
		<td  class=label width='25%' ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
		<td  class=label width='25%'><B><%=Alt_ID1_date%></B></td>
		<td  class=label width='25%'><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
		<td class=label width='25%'><B><%=Alt_ID2_date%></B></td>
	</tr>
    <tr>
		<td  class=label width='25%'><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
		<td  class=label width='25%'><B><%=Alt_ID3_date%></B></td>
		<td  class=label width='25%'><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
		<td  class=label width='25%' ><B><%=Alt_ID4_date%></B></td>
	</tr>
<% } %>

</tr>

</table>

<table cellpadding=3 cellspacing=0 border=0 width="100%" align='center' colspan="7">
<%if(NRICFirstNameAvailable || NRICSecondNameAvailable || NRICThirdNameAvailable || NRICFamilyNameAvailable){%>
<tr>
	<td align=right class=label width='10%'><fmt:message key="eMP.prefix.label" bundle="${mp_labels}"/></td>
	<%for(int i=0;i<4;i++)
	{%>
		<td align=left class=label nowrap width="15%"><%=name_prompts[i]%></td>
	<%}%>
	<td align=right class=label width='15%'><fmt:message key="eMP.Suffix.label" bundle="${mp_labels}"/></td><td colspan=2></td>
</tr>
<tr>
	<td align=center class=label ><%if(NRICNamePrefixAvailable){%>
	<B><%=prefix%></B>&nbsp;&nbsp;&nbsp;&nbsp;	<%}%>
	</td>
		<%for(int i=0;i<4;i++) {%>
			<td align=left class=label nowrap><B><%=names[i]%></B></td>
		<%}%>
	<td align=right class=label  nowrap>
		<%if(NRICNameSuffixAvailable){%>
		<B><%=suffix%></B>
		<%}%>
	</td>
	<td colspan=2></td> 
</tr>

<%}%>

<tr>
	<td align=right class=label ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
	<td align=left class=label ><B><%=gender%>&nbsp;</B></td>

	<td align=right class=label ><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
	<td align=left class=label  >
	<B><%=agey%>&nbsp;&nbsp;<%=agem%>&nbsp;&nbsp;<%=aged%>&nbsp;</B></td>

	<td align=right class=label wrap><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
	<td align=left class=label ><B><%=date_of_birth%>&nbsp;</B></td>
	<td colspan=2></td>
</tr>

<tr>
	
	<td align=right class=label  nowrap><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/></td>
	<td align=left class=label  ><B><%=Birth_place_desc%>&nbsp;</B></td>

<td align=right class=label><fmt:message key="Common.residency.label" bundle="${common_labels}"/></td>
	<td align=left class=label >
	<%if(citizen){%>
		<B><fmt:message key="Common.citizen.label" bundle="${common_labels}"/></B>
	<%}else{
		%>
		<B><fmt:message key="Common.noncitizen.label" bundle="${common_labels}"/></B>
	<%}%>
	</td>


	<td align=right class=label><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	<td align=left class=label >
	<%
		if(legal){
		%>
		<B><fmt:message key="Common.LegalResident.label" bundle="${common_labels}"/></B>
		<%}else{%>
		<B><fmt:message key="Common.IllegalResident.label" bundle="${common_labels}"/></B>
		<%}%>
	
	</td>
</tr>
<tr>
	<td align=right class=label ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
	<td align=left class=label ><B><%=nationality%>&nbsp;</B></td>

	<td align=right class=label ><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
	<td align=left class=label  ><B><%=Race_desc%>&nbsp;</B></td>

	<td align=right class=label  ><fmt:message key="eMP.ethnicity.label" bundle="${mp_labels}"/></td>
	<td align=left class=label  ><B><%=raceDesc%>&nbsp;</B></td>

	<!-- <td align=center> 
	<input type='button' class='button' name='contact_details' id='contact_details' value='Contact Details'  onclick='Modal_Clinical_Details(this,"View_Referral");'>
	</td> -->
</tr>
</table>
</td>
</tr>

<tr>
<td width='100%'>
<table cellpadding=3 cellspacing=0 border=0 width="100%" colspan="8" align='center'>
	<td class='columnheader' colspan=10 ><fmt:message key="eMP.ReferredFrom.label" bundle="${mp_labels}"/></td>
<tr>
	<td align=right class=label width="10%"><fmt:message key="Common.referraltype.label" bundle="${common_labels}"/></td>
	<td align=left class=label width="15%"><B><%=from_ref_type%>&nbsp;</B></td>

	<td align=right class=label nowrap width="10%">HealthCare Setting</td>
	<td align=left class=label nowrap width="15%"> <B><%=from_hcare_setting_desc%>&nbsp;</B></td>

	<td align=right class=label width="10%" nowrap><fmt:message key="Common.referralsource.label" bundle="${common_labels}"/></td>
 	<td align=left class=label width="20%" ><B><%=Ref_source%>&nbsp;</B></td>  
<!-- 	<td align=left class=label ><B><%=from_ref_locn_desc%>&nbsp;</B></td>  -->

<!-- 	<td align=right class=label >Organization Type&nbsp;&nbsp;</td> -->
	<td align=right class=label width="10%"><B><%=org_type_data_display%></B>&nbsp;</td>
	<td align=left class=label width="15%">&nbsp;</td>

</tr>
<tr>
	<td align=right class=label  ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
 	<td align=left class=label ><B><%=From_Splty_desc%>&nbsp;</B>&nbsp;</td> 

	<td align=right class=label ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td align=left class=label colspan=2><B><%=from_ref_locn_desc%>&nbsp;</B></td>
	<td colspan=5></td>
</tr>

<tr>
	<td align=left class=label colspan='2' ><b><fmt:message key="Common.PractitionerDetails.label" bundle="${common_labels}"/></b></td>

	<td align=right class=label><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
	<td align=left class=label colspan=2><B><%=from_ref_pract_name%>&nbsp;</B></td>

	<td colspan=3></td>
</tr>
<tr>
	<td align=right class=label><fmt:message key="Common.telno.label" bundle="${common_labels}"/></td>
	<td align=left class=label ><B><%=practitionerResTelNo%>&nbsp;</B></td>

	<td align=right class=label><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>
	<td align=left class=label colspan=2><B><%=practitionerMobileNo%>&nbsp;</B></td>

	<td align=right class=label ><fmt:message key="Common.PagerNo.label" bundle="${common_labels}"/></td>
	<td align=left class=label colspan=2><B><%=practitionerPagerNo%>&nbsp;</B></td>
</tr>
<tr>
	<td align=right class=label>Ref Letter No&nbsp;&nbsp;</td>
	<td align=left class=label><B><%=referral_letter_no%>&nbsp;</B></td>

	<td align=right class=label><fmt:message key="eCA.RefDate.label" bundle="${ca_labels}"/></td>
	<td align=left class=label><B><%=referral_date%>&nbsp;</B></td>

	<td align=right class=label><fmt:message key="eCA.RecDate.label" bundle="${ca_labels}"/></td>
	<td align=left class=label><B><%=received_date%>&nbsp;</B></td>

	<td align=right class=label nowrap>Pref Date&nbsp;&nbsp;</td>
	<td align=left class=label><B><%=preferred_treatment_date%>&nbsp;</B>
	</td>
</tr>

<tr>
	<td align=right class=label  nowrap><fmt:message key="Common.ReasonforReferral.label" bundle="${common_labels}"/></td>
	<td align=left class=label colspan="8"><B><%=referralReason%>&nbsp;</B></td>
	
</tr>

<table cellpadding=0 cellspacing=0 border=0 width="100%" colspan="4">
<tr>
	<td align=right class=label nowrap ><fmt:message key="eMP.OtherDocAttached.label" bundle="${mp_labels}"/></td>
	<td align=left class=label  wrap width="50%"><B><%=otherDocAttached%>&nbsp;</B></td>

	<td><input width="15%" type='button' class='button' name='clinical_details' id='clinical_details' value='Clinical Details' onclick="Modal_Clinical_Details(this,'View_Referral');"></td>
	<td><input width="15%" type="button" class=BUTTON value="Referral Notes" onClick="ref_note()"> </td>
</tr>
</table>


</table>

</td>
</tr>

<tr>
<td>
<table  cellpadding=3 cellspacing=0 border=0 width="100%" colspan="8">
	<tr id = "ref_to"><th colspan=8 align=left><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></th></tr>
	<tr><td colspan=10 class=label height=5></td></tr>
<tr>
	<td  align=right class=label width="10%"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
	<td align=left class=label width="15%"><B><%=referral_priority%>&nbsp;</B></td>

	<td  align=right class=label width="10%">Specialty&nbsp;&nbsp;</td>
	<td align=left class=label width="15%" nowrap><B><%=to_speciality_desc%>&nbsp;</B> </td>

	<td align=right class=label width="8%" nowrap><fmt:message key="eMP.ReferredForIP.label" bundle="${mp_labels}"/></td>
	<td align=left class=label width="15%"><B><%=referredForIP%>&nbsp;</B></td>
	
	<td align=right class=label width="10%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td align=left class=label width="17%"><B><%=toRefLocnDesc%>&nbsp;</B></td>
</tr>
<tr>
	<td  align=right class=label ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
	<td align=left class=label nowrap><B><%=to_service_desc%>&nbsp;</B></td>

	<td align=right class=label ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
	<td align=left class=label ><B><%=to_ref_pract_name%>&nbsp;</B></td>
	
	<td  align=right class=label >Ref Type&nbsp;&nbsp;</td>
	<td align=left class=label ><B><%=toRefType%>&nbsp;</B></td>

	<td align=right class=label nowrap><fmt:message key="Common.referralsource.label" bundle="${common_labels}"/></td>
	<td align=left class=label ><B><%=toRefLocnDesc%>&nbsp;</B></td>
</tr>
<tr>

	<td align='right'colspan="8"><input type='button' class='BUTTON' name='Close' id='Close' value='Close' title='Closing' onclick="close_win()" > </input></td>
</tr>
</table>
</td>
</tr>
</table>
<input type='hidden' name='referral_notes' id='referral_notes' value = '<%=displaydata.toString()%>'  ></input>
<input type='hidden' name='exm_clinical_find' id='exm_clinical_find' value='<%=examAndClinFindings%>'></input>
<input type='hidden' name='concat_address_hidden' id='concat_address_hidden' value=''>		
<input type='hidden' name='diagnosis' id='diagnosis' value='<%=diagnosis%>'></input>
<input type='hidden' name='treatment' id='treatment' value='<%=treatment%>'></input>
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

</form>
</body>

<%
	}
	
	if(rs!=null)rs.close();
	if(pstmt!=null)	pstmt.close();
	if (orgTypeRS != null)   orgTypeRS.close();
	if (orgTypePstmt != null) orgTypePstmt.close();
	}
	catch(Exception e)
	{
		//out.print(e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
			             
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>
</html>


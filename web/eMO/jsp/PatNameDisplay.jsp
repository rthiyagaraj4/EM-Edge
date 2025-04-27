<!DOCTYPE html>
<!--
          venkatesh
-->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, webbeans.eCommon.*,java.util.*,javax.servlet.http.*,javax.servlet.jsp.JspWriter " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>


<%     request.setCharacterEncoding("UTF-8");
        webbeans.op.PatientData patdata 	= new webbeans.op.PatientData();
		String	facility_id		    = (String) session.getValue( "facility_id" ) ;
		String	 	strNamePrefix			= "";
		String	 	strFirstName			= "";
		String	 	strSecondName		= "";
		String		strThirdName			= "";
		String	 	strFamilyName			= "";
		String 	strNameSuffix			= "";
		String patientIdStatus          ="";
		String family_name_loc_lang="";
		String third_name_loc_lang="";
		String second_name_loc_lang="";
		String first_name_loc_lang="";
		String name_prefix_loc_lang="";
		String patient_long_name="";
		String patient_long_name_loc_lang="";
		String name_suffix_loc_lang="";
		String patient_name_loc_lang="";
		String patient_name="";
	

		String 	strSex					= "";
		String AltId1No				= "";
		String AltId2No				= "";
		String AltId3No				= "";
		String AltId4No				= "";
		String OtherAltIdNo			= "";
		String OtherAltIdType       = "";
		
		String 	strDateOfBirth			= "";
		String 	strNationalityCode    = "";
		String	strNationalityDesc	= "";
		String 	strPrimaryResNo		= "";
		String 	strOtherResNo			= "";
		String 	strYear					= "";
		String 	strMonth					= "";
		String 	strDays					= "";
		String		strCitizenYN			= "";
		String		strLegalYN				= "";

		String		strNatIdNo				= "";
		String		strPatdtlsUnknownYN= "N";


			String a_res_addr_line1 = "";
			String a_res_addr_line2 = "";
			String a_res_addr_line3 = "";
			String a_res_addr_line4 = "";
			String a_country_code  = "";
			String country1_desc   ="";
			String country2_desc    ="";
			String a_postal_code    = "";
			
			String a_res_area			= "";
			String a_res_area_code = "";
			String a_res_town2_code = "";
			String a_res_town2_desc = "";
			String a_res_region_code = "";
			String a_res_region_desc = "" ;

			String m_res_addr_line1 = "";
			String m_res_addr_line2 = "";
			String m_res_addr_line3 = "";
			String m_res_addr_line4 = "";
			String m_postal_code    = "";
			String m_postal_code1		= "";
			String a_postal_code1   = "";
			String m_country_code   = "";
			String m_res_area_code  = "";
			String m_res_area_desc  = "";
			String m_res_town2_code = "";
			String m_res_town2_desc = "";
			String m_res_region_code = "";
			String m_res_region_desc = "";

			
			String strEmail			   = "";
			String strRaceCd			   = "";
			String strRaceDesc			   = "";
			String strEthnicGrpCd		   = "";
			String strBirthPldesc	   = "";
			String birth_place_code    ="";
			String place_of_birth      ="";

			String alt_id1_exp_date ="";
			String alt_id2_exp_date ="";
			String alt_id3_exp_date ="";
			String alt_id4_exp_date ="";


			
			String ethnic_desc="";
			String a_country_desc="";
			String m_country_desc="";
			String postal2_desc="";
			String postal_desc="";
			String pat_id =request.getParameter("pat_id");
			String locale	=	 ((String)session.getAttribute("LOCALE"));
			Connection con = ConnectionManager.getConnection(request);
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	
			
			 

	 try{
	   patdata.setFacility_id(facility_id);
	   patientIdStatus = patdata.CheckStatus(con,pat_id);	
       
       if(patientIdStatus.equals("")){   	   
	   String sql = "SELECT a.name_prefix, a.patient_name, a.first_name, a.second_name,a.third_name, a.family_name_prefix, a.family_name, a.name_suffix,       a.national_id_no, NVL (a.alt_id1_no, '') alt_id1_no, a.alt_id2_type, NVL (alt_id2_no, '') alt_id2_no, a.alt_id3_type, NVL (a.alt_id3_no, '') alt_id3_no, a.alt_id4_type,       NVL (a.alt_id4_no, '') alt_id4_no, TO_CHAR (a.alt_id1_exp_date, 'dd/mm/yyyy') alt_id1_exp_date, TO_CHAR (a.alt_id2_exp_date, 'dd/mm/yyyy') alt_id2_exp_date,       TO_CHAR (a.alt_id3_exp_date, 'dd/mm/yyyy') alt_id3_exp_date, TO_CHAR (a.alt_id4_exp_date, 'dd/mm/yyyy') alt_id4_exp_date, a.oth_alt_id_type, NVL (a.oth_alt_id_no, '') oth_alt_id_no, a.sex,TO_CHAR (a.date_of_birth, 'dd/mm/yyyy') date_of_birth,NVL (a.nationality_code, '') nationality_code,       mp_get_desc.mp_country (nationality_code,'"+locale+"','3' ) nationality_desc, contact1_no primary_resi_no, contact2_no other_resi_no, NVL (active_yn, 'N') active_yn, NVL (suspend_yn, 'N') suspend_yn, NVL (deceased_yn, 'N') deceased_yn,calculate_age (TO_CHAR (a.date_of_birth, 'dd/mm/yyyy'), 1) y,       calculate_age (TO_CHAR (a.date_of_birth, 'dd/mm/yyyy'), 2) m,calculate_age (TO_CHAR (a.date_of_birth, 'dd/mm/yyyy'), 3) d,a.citizen_yn, a.legal_yn, a.pat_dtls_unknown_yn, a.pat_cat_code, mp_get_desc.mp_pat_category (a.pat_cat_code, '"+locale+"',  2 ) pat_cat_desc,  a.race_code,  mp_get_desc.mp_race (a.race_code, '"+locale+"', 1) race_desc, mp_get_desc.mp_ethnic_group (a.ethnic_grp_code,  '"+locale+"',  '1'    ) ethnic_desc,  a.ethnic_grp_code, a.place_of_birth, a.birth_place_code,  mp_get_desc.mp_birth_place (a.birth_place_code,  '"+locale+"',  '1'  ) birth_place_desc,    a.family_name_loc_lang, a.third_name_loc_lang, a.second_name_loc_lang,  a.first_name_loc_lang, a.name_suffix_loc_lang, a.patient_name_loc_lang, a.name_prefix_loc_lang, language_id, mp_get_desc.mp_language (language_id, '"+locale+"', 1) language_desc,  a.patient_long_name, a.patient_long_name_loc_lang FROM mp_patient a, mp_pat_addresses b WHERE a.patient_id = '"+pat_id+"' AND a.patient_id = b.patient_id";
	    
		
		
		pstmt = con.prepareStatement(sql) ;
		
		rs      = pstmt.executeQuery() ;
	  
	   if(rs != null) {
	    while(rs.next()){
		strNamePrefix			= checkForNull(rs.getString("name_prefix"));
		strFirstName			=checkForNull(rs.getString("first_name"));
		strSecondName		    = checkForNull(rs.getString("second_name"));
		strThirdName			= checkForNull(rs.getString("third_name"));
	    strFamilyName			= checkForNull(rs.getString("family_name"));
		patient_name	        =checkForNull(rs.getString("patient_name"));
        strNameSuffix			= checkForNull(rs.getString("name_suffix"));
	    name_prefix_loc_lang	=checkForNull(rs.getString("name_prefix_loc_lang"));
		first_name_loc_lang		=checkForNull(rs.getString("first_name_loc_lang"));
		second_name_loc_lang		=checkForNull(rs.getString("second_name_loc_lang"));
		third_name_loc_lang		= checkForNull(rs.getString("third_name_loc_lang")); 
		family_name_loc_lang		=checkForNull(rs.getString("family_name_loc_lang"));
	 	name_suffix_loc_lang		=checkForNull(rs.getString("name_suffix_loc_lang"));
		strSex					=  checkForNull(rs.getString("sex"));
		strDateOfBirth			= checkForNull(rs.getString("date_of_birth"));
		strNatIdNo				= checkForNull(rs.getString("national_id_no"));
		patient_long_name		=checkForNull(rs.getString("patient_long_name"));
		patient_long_name_loc_lang		=checkForNull(rs.getString("patient_name_loc_lang")); 
		
		OtherAltIdType					=checkForNull(rs.getString("OTH_ALT_ID_TYPE"));
		OtherAltIdNo					=checkForNull(rs.getString("OTH_ALT_ID_NO"));
		}
	   }
	   if(rs != null) rs.close(); 
	   if(pstmt != null) pstmt.close();	
		  
	  String addressQuery  ="SELECT a.addr1_type,a.addr1_line1,a.addr1_line2, a.addr1_line3,addr1_line4,  nvl(a.postal1_code,'') postal1_code,MP_GET_DESC.MP_POSTAL_CODE(a.postal1_code,'"+locale+"','2') postal1_desc, a.country1_code,  MP_GET_DESC.MP_COUNTRY(a.country1_code,'"+locale+"','1') country1_desc, a.contact1_name, a.invalid1_yn, MP_GET_DESC.MP_RES_AREA(b.RES_AREA_CODE,'"+locale+"','1') res_area,  b.res_area_code ,MP_GET_DESC.MP_RES_TOWN(b.RES_TOWN_CODE,'"+locale+"','1') res_town, b.res_town_code , MP_GET_DESC.MP_REGION(b.region_code,'"+locale+"','1') region, b.region_code, a.addr2_type, a.addr2_line1, a.addr2_line2, a.addr2_line3, a.addr2_line4, a.postal2_code, MP_GET_DESC.MP_POSTAL_CODE(a.postal2_code,'"+locale+"','2') postal2_desc, a.country2_code, MP_GET_DESC.MP_COUNTRY(a.country2_code,'"+locale+"','1') country2_desc, a.contact2_name, a.invalid2_yn, MP_GET_DESC.MP_RES_AREA(a.res_area2_code,'"+locale+"','1') res_area2, a.res_area2_code, MP_GET_DESC.MP_RES_TOWN(a.res_town2_code,'"+locale+"','1') res_town2, a.res_town2_code, MP_GET_DESC.MP_REGION(region2_code,'"+locale+"','1') region2_desc,  a.region2_code, b.CONTACT1_NO, b.CONTACT2_NO,  b.EMAIL_ID FROM mp_pat_addresses a , MP_PATIENT b WHERE b.PATIENT_ID=a.PATIENT_ID  and  b.patient_id='"+pat_id+"'";
	
	
	    pstmt       = con.prepareStatement(addressQuery) ;
		   rs         = pstmt.executeQuery() ;
	      if(rs != null) {
		  if(rs.next()){
		    a_res_addr_line1  = checkForNull(rs.getString("addr1_line1"));
			a_res_addr_line2  = checkForNull(rs.getString("addr1_line2"));
			a_res_addr_line3  = checkForNull(rs.getString("addr1_line3"));
			a_res_addr_line4  = checkForNull(rs.getString("addr1_line4"));
			a_res_town2_code  = checkForNull(rs.getString("res_town_code"));
		    a_res_town2_desc  = checkForNull(rs.getString("res_town"));
			a_res_area_code   = checkForNull(rs.getString("res_area_code"));
			a_res_area        = checkForNull(rs.getString("res_area") );
            a_res_region_code = checkForNull(rs.getString("region_code"));
			a_res_region_desc = checkForNull(rs.getString("region"));	
            a_postal_code     = checkForNull(rs.getString("postal1_code"));
			a_postal_code1    = checkForNull(rs.getString("postal1_desc"));	
			 a_country_code    = checkForNull(rs.getString("country1_code"));
			country1_desc	  = checkForNull(rs.getString("country1_desc"));	
			country2_desc	  = checkForNull(rs.getString("country2_desc"));
			strPrimaryResNo   = checkForNull(rs.getString("CONTACT1_NO"));
			strOtherResNo     = checkForNull(rs.getString("CONTACT2_NO"));
			strEmail	      = checkForNull(rs.getString("EMAIL_ID"));	
			
			m_res_addr_line1  = checkForNull(rs.getString("addr2_line1"));
			m_res_addr_line2  = checkForNull(rs.getString("addr2_line2"));
			m_res_addr_line3  = checkForNull(rs.getString("addr2_line3"));
			m_res_addr_line4  = checkForNull(rs.getString("addr2_line4"));
			m_res_town2_code  = checkForNull(rs.getString("res_town2_code"));
		    m_res_town2_desc  = checkForNull(rs.getString("res_town2"));
			m_res_area_code   = checkForNull(rs.getString("res_area2_code"));
			m_res_area_desc   = checkForNull(rs.getString("res_area2"));
			m_res_region_code = checkForNull(rs.getString("region2_code"));
		    m_res_region_desc = checkForNull(rs.getString("region2_desc"));
			m_postal_code     = checkForNull(rs.getString("postal2_code"));
			m_postal_code1    = checkForNull(rs.getString("postal2_desc"));
			m_country_code    = checkForNull(rs.getString("country2_code"));
			
			
		   }
		  }
	 
	 
%>
<script>
    
	
	 
    if(parent.frames[1].frames[1].frames[1].document.forms[0].name_prefix){
	parent.frames[1].frames[1].frames[1].document.forms[0].name_prefix.value		  ='<%=strNamePrefix%>'
    parent.frames[1].frames[1].frames[1].document.forms[0].name_prefix.disabled=true}
	
	if(parent.frames[1].frames[1].frames[1].document.forms[0].first_name){
	parent.frames[1].frames[1].frames[1].document.forms[0].first_name.value		  ='<%=strFirstName%>';
	parent.frames[1].frames[1].frames[1].document.forms[0].first_name.disabled=true
	}
	
	if(parent.frames[1].frames[1].frames[1].document.forms[0].second_name){
    parent.frames[1].frames[1].frames[1].document.forms[0].second_name.value		  ='<%=strSecondName%>';
	parent.frames[1].frames[1].frames[1].document.forms[0].second_name.disabled=true
	}
	
	if(parent.frames[1].frames[1].frames[1].document.forms[0].third_name){
    parent.frames[1].frames[1].frames[1].document.forms[0].third_name.value		  ='<%=strThirdName%>';
	parent.frames[1].frames[1].frames[1].document.forms[0].third_name.disabled=true
	}
	
	if(parent.frames[1].frames[1].frames[1].document.forms[0].third_name_oth_lang){
    parent.frames[1].frames[1].frames[1].document.forms[0].third_name_oth_lang.value  ='<%=third_name_loc_lang%>';
    parent.frames[1].frames[1].frames[1].document.forms[0].third_name_oth_lang.disabled=true
	}
	
	if(parent.frames[1].frames[1].frames[1].document.forms[0].second_name_oth_lang){
	parent.frames[1].frames[1].frames[1].document.forms[0].second_name_oth_lang.value  ='<%=second_name_loc_lang%>';
	 parent.frames[1].frames[1].frames[1].document.forms[0].second_name_oth_lang.disabled=true
	 }
	
	 if(parent.frames[1].frames[1].frames[1].document.forms[0].family_name){
	parent.frames[1].frames[1].frames[1].document.forms[0].family_name.value		  ='<%=strFamilyName%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].family_name.disabled=true
	}
	
	if(parent.frames[1].frames[1].frames[1].document.forms[0].name_suffix){
	parent.frames[1].frames[1].frames[1].document.forms[0].name_suffix.value		  ='<%=strNameSuffix%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].name_suffix.disabled=true
	}
	
	if(parent.frames[1].frames[1].frames[1].document.forms[0].first_name_oth_lang){
	parent.frames[1].frames[1].frames[1].document.forms[0].first_name_oth_lang.value  ='<%=first_name_loc_lang%>'
	 parent.frames[1].frames[1].frames[1].document.forms[0].first_name_oth_lang.disabled=true
	}
	
	if(parent.frames[1].frames[1].frames[1].document.forms[0].name_suffix_oth_lang){
	parent.frames[1].frames[1].frames[1].document.forms[0].name_suffix_oth_lang.value ='<%=name_suffix_loc_lang%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].name_suffix_oth_lang.disabled=true
	}
	
	if(parent.frames[1].frames[1].frames[1].document.forms[0].name_prefix_oth_lang){
	parent.frames[1].frames[1].frames[1].document.forms[0].name_prefix_oth_lang.value ='<%=name_prefix_loc_lang%>'
 	parent.frames[1].frames[1].frames[1].document.forms[0].name_prefix_oth_lang.disabled=true
	}
	
	if(parent.frames[1].frames[1].frames[1].document.forms[0].family_name_oth_lang){
	parent.frames[1].frames[1].frames[1].document.forms[0].family_name_oth_lang.value ='<%=family_name_loc_lang%>'
    parent.frames[1].frames[1].frames[1].document.forms[0].family_name_oth_lang.disabled=true
	}
	if(parent.frames[1].frames[1].frames[1].document.forms[0].requestor_dob){
	parent.frames[1].frames[1].frames[1].document.forms[0].requestor_dob.value		='<%=strDateOfBirth%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].requestor_dob.disabled=true
	}
	if(parent.frames[1].frames[1].frames[1].document.forms[0].national_id_no){
    parent.frames[1].frames[1].frames[1].document.forms[0].national_id_no.value       ='<%=strNatIdNo%>'
    parent.frames[1].frames[1].frames[1].document.forms[0].national_id_no.disabled=true
	}	
	
	parent.frames[1].frames[1].frames[1].document.forms[0].patient_name_loca_long.value  ='<%=patient_long_name_loc_lang%>'
	
	if(parent.frames[1].frames[1].frames[1].document.forms[0].other_alt_Id_text){
	parent.frames[1].frames[1].frames[1].document.forms[0].other_alt_Id_text.value           ='<%=OtherAltIdNo%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].other_alt_Id_text.disabled=true
	}
	
	parent.frames[1].frames[1].frames[1].document.forms[0].patient_name.value           ='<%=patient_name%>'
	
	  
	 var obj1=parent.frames[1].frames[1].frames[1].document.forms[0].other_alt_id.options
         for(var k=0;k<obj1.options.length;k++)
		{        
				if(obj1.options[k].value == '<%=OtherAltIdType%>')
					obj1.options[k].selected = true;
		}
        parent.frames[1].frames[1].frames[1].document.forms[0].other_alt_id.disabled=true	 	
       
	 var obj		=		parent.frames[1].frames[1].frames[1].document.forms[0].sex.options
	
	for(var k=0;k<obj.options.length;k++)
		{    
				if(obj.options[k].value == '<%=strSex%>')
					obj.options[k].selected = true;
		} 
	   parent.frames[1].frames[1].frames[1].document.forms[0].sex.disabled=true
	
	/*Applicant Address */
	if(parent.frames[1].frames[1].frames[1].document.forms[0].addr_line1)
	parent.frames[1].frames[1].frames[1].document.forms[0].addr_line1.value			='<%=a_res_addr_line1%>'
	
	if(parent.frames[1].frames[1].frames[1].document.forms[0].addr_line2)
	parent.frames[1].frames[1].frames[1].document.forms[0].addr_line2.value           ='<%=a_res_addr_line2%>'
	
	if(parent.frames[1].frames[1].frames[1].document.forms[0].addr_line3)
	parent.frames[1].frames[1].frames[1].document.forms[0].addr_line3.value           ='<%=a_res_addr_line3%>'
	
	if(parent.frames[1].frames[1].frames[1].document.forms[0].addr_line4)
	parent.frames[1].frames[1].frames[1].document.forms[0].addr_line4.value           ='<%=a_res_addr_line4%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].res_town_code.value        ='<%=a_res_town2_code%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].res_town_desc.value        ='<%=a_res_town2_desc%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].res_area_code.value        ='<%=a_res_area_code%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].res_area_desc.value        ='<%=a_res_area%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].res_region_code.value      ='<%=a_res_region_code%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].region_desc.value          ='<%=a_res_region_desc%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].postal_code.value          ='<%=a_postal_code%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].postals_code.value         ='<%=a_postal_code1%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].r_postal_code1.value       ='<%=a_postal_code1%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].country_code.value         ='<%=a_country_code%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].country_desc.value         ='<%=country1_desc%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].contact1_no.value          ='<%=strPrimaryResNo%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].contact2_no.value          ='<%=strOtherResNo%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].email.value                ='<%=strEmail%>'
	/*Applicant Address End*/
	
	/* Embalm Address */
	parent.frames[1].frames[1].frames[1].document.forms[0].mail_addr_line1.value       ='<%=m_res_addr_line1%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].mail_addr_line2.value       ='<%=m_res_addr_line2%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].mail_addr_line3.value       ='<%=m_res_addr_line3%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].mail_addr_line4.value       ='<%=m_res_addr_line4%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].mail_res_town_code.value    ='<%=m_res_town2_code%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].mail_res_town_desc.value    ='<%=m_res_town2_desc%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].mail_res_area_code.value    ='<%=m_res_area_code%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].mail_res_area_desc.value    ='<%=m_res_area_desc%>'
    parent.frames[1].frames[1].frames[1].document.forms[0].mail_region_code.value      ='<%=m_res_region_code%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].mail_region_desc.value      ='<%=m_res_region_desc%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].mail_postal_code.value      ='<%=m_postal_code%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].m_postal_code12.value       ='<%=m_postal_code1%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].mail_country_code.value     ='<%=m_country_code%>'
	parent.frames[1].frames[1].frames[1].document.forms[0].mail_country_desc.value     ='<%=country2_desc%>'
	

	
	
	parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp"
		
		
	
</script>
<%
} else{  
        if(patientIdStatus.equals("SUSPENDED")){  
      out.println("<script>alert(parent.frames[1].getMessage('PAT_SUSPENDED_NOT_ALLOWED','MP'));parent.frames[1].frames[1].frames[1].document.forms[0].requestor_id.value=''; parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp'</script>");
	  }else if (patientIdStatus.equals("DECEASED")){
          out.println("<script>alert(parent.frames[1].getMessage('PAT_DECEASED_NOT_ALLOWED','MP'));parent.frames[1].frames[1].frames[1].document.forms[0].requestor_id.value=''; parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp'</script>");
		}else if(patientIdStatus.equals("INVALID_PATIENT")){
		out.println( "<script>alert(parent.frames[1].getMessage('INVALID_PATIENT','MP'));parent.frames[1].frames[1].frames[1].document.forms[0].requestor_id.value=''; parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp'</script>");
		 }else if(patientIdStatus.equals("SECURED")){
		 out.println( "<script>alert(parent.frames[1].getMessage('SECURED_NOT_ALLOWED','COMMON'));parent.frames[1].frames[1].frames[1].document.forms[0].requestor_id.value=''; parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp'</script>");
		 }else if(patientIdStatus.equals("INACTIVE")){ 
		 out.println( "<script>alert(parent.frames[1].getMessage('PAT_INACTIVE_NOT_ALLOWED','MP'));parent.frames[1].frames[1].frames[1].document.forms[0].requestor_id.value=''; parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp'</script>");
		 }else if(patientIdStatus.equals("BLACKLISTED_PATIENT")){
		  out.println( "<script>alert(parent.frames[1].getMessage('BLACKLISTED_PATIENT','MP'));parent.frames[1].frames[1].frames[1].document.forms[0].requestor_id.value=''; parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp'</script>");
		 }
		
		}


}catch(Exception e){
   
      e.printStackTrace();
  } finally{
	    if(rs != null) rs.close(); 
	   if(pstmt != null) pstmt.close();	
	   //Added for checkstyle for COMMON-ICN-0056
	   if(con != null)		
	    ConnectionManager.returnConnection(con,request);
	   //con.close(); //Commented for checkstyle for COMMON-ICN-0056
  }%>


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

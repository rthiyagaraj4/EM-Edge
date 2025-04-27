<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*, java.text.*,java.io.*,java.net.*, javax.servlet.jsp.JspWriter,webbeans.eCommon.ConnectionManager,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
    <head>

<%
    String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    request.setCharacterEncoding("UTF-8");

%>


	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
        <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>        
		<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

    <body CLASS='MESSAGE' onKeyDown ='lockKey()'>
        <form name="DynamicFile" id="DynamicFile">
		<%
		  Connection con = null ;		  
		  PreparedStatement   pstmt = null;
		  PreparedStatement   pstmt1 = null;
		 
		  ResultSet     rs = null;
		  String facility_id       = (String) session.getValue("facility_id");

		  String prompt_patient_id	= request.getParameter("prompt_patient_id") ;
		  String q_from_funct		= request.getParameter("q_from_funct") ;
		  String q_booking_ref_no	= request.getParameter("q_booking_ref_no") ;
		  String q_appt_ref_no		= request.getParameter("q_appt_ref_no") ;
		   String q_booking_type = request.getParameter("q_booking_type")==null?"":request.getParameter("q_booking_type"); 
		  String p_referral_id		= request.getParameter("p_referral_id") ;	
		  String from_VR			= request.getParameter("from_VR") ;
		  
		  String locale		= request.getParameter("localeName") ;//Added by Rameswar on 1st Sept 2015
		  boolean isPortalPatient= false;// Added by Rameswar on 27th Aug 2015
		  String site_id="";//Added by Rameswar on 09-Oct-15 for Patient Portal
		  String site_IP="";//Added by Rameswar on 09-Oct-15 for Patient Portal
		  int port;//Added by Rameswar on 09-Oct-15 for Patient Portal
		  HashMap hashdata    = new HashMap();//Added by Rameswar on 09-Oct-15 for Patient Portal

          if(from_VR == null)  from_VR = "Y" ;
          if(q_from_funct == null)  q_from_funct = "" ;
		  
		  


     try
       {
      con = ConnectionManager.getConnection(request);

				
		pstmt = con.prepareStatement("select c.addr1_line1 addr1_line1, c.addr1_line2 addr1_line2, c.addr1_line3 addr1_line3, c.addr1_line4 addr1_line4, c.postal1_code postal1_code, a.patient_id patient_id, a.patient_name  patient_name, a.patient_long_name patient_long_name,a.patient_long_name_loc_lang patient_long_name_loc_lang, a.national_id_no national_id_no, a.name_prefix name_prefix, a.alt_id1_no alt_id1_no,  a.first_name first_name, a.second_name second_name, a.third_name third_name, a.family_name family_name, a.name_suffix name_suffix, a.name_prefix_loc_lang name_prefix_loc_lang, a.first_name_loc_lang first_name_loc_lang, a.second_name_loc_lang second_name_loc_lang, a.third_name_loc_lang third_name_loc_lang, a.family_name_loc_lang family_name_loc_lang, a.name_suffix_loc_lang name_suffix_loc_lang, a.patient_name_loc_lang patient_name_loc_lang, a.sex sex, to_char(a.alt_id1_exp_date,'dd/mm/yyyy') alt_id1_exp_date, to_char(a.date_of_birth,'dd/mm/yyyy') date_of_birth, a.contact1_no contact1_no, a.contact2_no contact2_no, a.email_id email_id, a.nationality_code nationality_code,a.res_area_code res_area_code,a.res_town_code res_town_code,a.citizen_yn citizen_yn,a.legal_yn legal_yn,a.alt_id1_type alt_id1_type,a.alt_id2_type,a.alt_id2_no,to_char(a.alt_id2_exp_date,'dd/mm/yyyy') alt_id2_exp_date,a.alt_id3_type,a.alt_id3_no,to_char(a.alt_id3_exp_date,'dd/mm/yyyy') alt_id3_exp_date,a.alt_id4_type,a.alt_id4_no,to_char(a.alt_id4_exp_date,'dd/mm/yyyy') alt_id4_exp_date,a.oth_alt_id_type,a.oth_alt_id_no,a.birth_place_code,(select long_desc from mp_birth_place where birth_place_code = a.birth_place_code) birth_place_desc, a.ethnic_grp_code,a.race_code,a.region_code,c.addr2_line1,c.addr2_line2, c.addr2_line3,c.addr2_line4,c.postal2_code,c.country2_code,c.res_area2_code,c.res_town2_code,c.region2_code,a.pat_cat_code pat_cat_code  from mp_patient a, mp_pat_addresses c where a.patient_id = c.patient_id(+) and a.patient_id = '"+prompt_patient_id+"' ");

        rs = pstmt.executeQuery();
                    
        if( rs != null )
        { 
          if( rs.next() )
          {
			 
		  String patient_id     =rs.getString("patient_id");	
          String name_prefix    =rs.getString("name_prefix");	if(name_prefix==null)  name_prefix="";
          String first_name     =rs.getString("first_name");	if(first_name==null)   first_name="";
          String second_name    =rs.getString("second_name");	if(second_name==null)  second_name="";
		  String third_name     =rs.getString("third_name");	if(third_name==null)   third_name="";
          String family_name    =rs.getString("family_name");	if(family_name==null)  family_name="";
		  String name_suffix    =rs.getString("name_suffix");	if(name_suffix==null)  name_suffix="";

		  String name_prefix_loc_lang    =rs.getString("name_prefix_loc_lang");	if(name_prefix_loc_lang==null)  name_prefix_loc_lang="";
		  String first_name_loc_lang    =rs.getString("first_name_loc_lang");	if(first_name_loc_lang==null)  first_name_loc_lang="";
		  String second_name_loc_lang    =rs.getString("second_name_loc_lang");	if(second_name_loc_lang==null)  second_name_loc_lang="";
		  String third_name_loc_lang    =rs.getString("third_name_loc_lang");	if(third_name_loc_lang==null)  third_name_loc_lang="";
		  String family_name_loc_lang    =rs.getString("family_name_loc_lang");	if(family_name_loc_lang==null)  family_name_loc_lang="";
		  String name_suffix_loc_lang    =rs.getString("name_suffix_loc_lang");	if(name_suffix_loc_lang==null)  name_suffix_loc_lang="";
		  String patient_name_loc_lang    =rs.getString("patient_name_loc_lang");	if(patient_name_loc_lang==null)  patient_name_loc_lang="";

          String sex            =rs.getString("sex");
		  String date_of_birth  =rs.getString("date_of_birth");
		  String patient_name   =rs.getString("patient_name");
		  String patient_long_name   =rs.getString("patient_long_name");
		  String patient_long_name_loc_lang   =rs.getString("patient_long_name_loc_lang");
		  String addr1_line1	=rs.getString("addr1_line1");	if(addr1_line1==null)  addr1_line1="";	
		  String addr1_line2	=rs.getString("addr1_line2");	if(addr1_line2==null)  addr1_line2="";	
		  String addr1_line3	=rs.getString("addr1_line3");	if(addr1_line3==null)  addr1_line3="";	
		  String addr1_line4	=rs.getString("addr1_line4");	if(addr1_line4==null)  addr1_line4="";	
		  String postal1_code	=rs.getString("postal1_code");	if(postal1_code==null) postal1_code="";	
		  String national_id_no	=rs.getString("national_id_no");
											if(national_id_no==null)  national_id_no="";
		  String area1_code= rs.getString("res_area_code");	if(area1_code==null) area1_code="";
		  String town1_code= rs.getString("res_town_code");	if(town1_code==null) town1_code="";
		  String res_region_code=(rs.getString("region_code") == null)?"":rs.getString("region_code");
		  String citizen_yn=(rs.getString("citizen_yn") == null)?"":rs.getString("citizen_yn");
		  String legal_yn=(rs.getString("legal_yn") == null)?"":rs.getString("legal_yn");
		  String alt_id1_type = (rs.getString("alt_id1_type") == null)?"":rs.getString("alt_id1_type");
		  String alt_id1_no		=rs.getString("alt_id1_no");	if(alt_id1_no==null)  alt_id1_no="";
		  String alt_id1_exp_date = rs.getString("alt_id1_exp_date");	
				if(alt_id1_exp_date==null || alt_id1_exp_date.equals("null"))  alt_id1_exp_date="";
		  String alt_id2_type = (rs.getString("alt_id2_type") == null)?"":rs.getString("alt_id2_type");
		  String alt_id2_no		=rs.getString("alt_id2_no");	if(alt_id2_no==null)  alt_id2_no="";
		  String alt_id2_exp_date = rs.getString("alt_id2_exp_date");	
				if(alt_id2_exp_date==null || alt_id2_exp_date.equals("null"))  alt_id2_exp_date="";
		  String alt_id3_type = (rs.getString("alt_id3_type") == null)?"":rs.getString("alt_id3_type");
		  String alt_id3_no		=rs.getString("alt_id3_no");	if(alt_id3_no==null)  alt_id3_no="";
		  String alt_id3_exp_date = rs.getString("alt_id3_exp_date");	
				if(alt_id3_exp_date==null || alt_id3_exp_date.equals("null"))  alt_id3_exp_date="";
		  String alt_id4_type = (rs.getString("alt_id4_type") == null)?"":rs.getString("alt_id4_type");
		  String alt_id4_no		=rs.getString("alt_id4_no");	if(alt_id4_no==null)  alt_id4_no="";
		  String alt_id4_exp_date = rs.getString("alt_id4_exp_date");	
				if(alt_id4_exp_date==null || alt_id4_exp_date.equals("null"))  alt_id4_exp_date="";
		  String oth_alt_id_type= (rs.getString("oth_alt_id_type") == null)?"":rs.getString("oth_alt_id_type");	
		  String oth_alt_id_no= (rs.getString("oth_alt_id_no") == null)?"":rs.getString("oth_alt_id_no");	
		
		  String contact1_no 	=rs.getString("contact1_no");	if(contact1_no==null)  contact1_no="";	
		  String contact2_no	=rs.getString("contact2_no");	if(contact2_no==null)  contact2_no="";	
		  String email_id		=rs.getString("email_id");	if(email_id==null)  email_id="";
		  String nationality_code=rs.getString("nationality_code");	
											if(nationality_code==null)  nationality_code="";
		  String birth_place_code=(rs.getString("birth_place_code") == null)?"":rs.getString("birth_place_code");	
		  String birth_place_desc= (rs.getString("birth_place_desc") == null)?"":rs.getString("birth_place_desc");	
		  String ethnic_grp_code = (rs.getString("ethnic_grp_code") == null)?"":rs.getString("ethnic_grp_code");	
		  String race_code= (rs.getString("race_code") == null)?"":rs.getString("race_code");	
		
		 String addr2_line1	=rs.getString("addr2_line1");	if(addr2_line1==null)  addr2_line1="";	
		 String addr2_line2	=rs.getString("addr2_line2");	if(addr2_line2==null)  addr2_line2="";	
		 String addr2_line3	=rs.getString("addr2_line3");	if(addr2_line3==null)  addr2_line3="";	
		 String addr2_line4	=rs.getString("addr2_line4");	if(addr2_line4==null)  addr2_line4="";	
		 String postal2_code	=rs.getString("postal2_code");	if(postal2_code==null) postal2_code="";
		 String country2_code= rs.getString("country2_code");	if(country2_code==null) country2_code="";
		 String area2_code= rs.getString("res_area2_code");	if(area2_code==null) area2_code="";
		 String town2_code= rs.getString("res_town2_code");	if(town2_code==null) town2_code="";
		 String region2_code= rs.getString("region2_code");	if(region2_code==null) region2_code="";
		 String pat_cat_code=rs.getString("pat_cat_code");	if(pat_cat_code==null) pat_cat_code="";
		 

		  if(q_from_funct.equals("IP_ADMISSION") && !q_booking_type.equals("D"))
		  { 
			  //int upd_rows =0;  
			  try{
                String upd_sql2 = " Update ip_booking_list set patient_id='"+patient_id+"', name_prefix='"+name_prefix+"', first_name='"+first_name+"', second_name='"+second_name+"', third_name='"+third_name+"', family_name='"+family_name+"', patient_long_name='"+patient_long_name+"', patient_long_name_loc_lang='"+patient_long_name_loc_lang+"',  name_prefix_loc_lang='"+name_prefix_loc_lang+"', first_name_loc_lang='"+first_name_loc_lang+"', second_name_loc_lang='"+second_name_loc_lang+"', third_name_loc_lang='"+third_name_loc_lang+"', family_name_loc_lang='"+family_name_loc_lang+"', name_suffix_loc_lang='"+name_suffix_loc_lang+"', patient_name_loc_lang='"+patient_name_loc_lang+"', date_of_birth=to_date('"+date_of_birth+"','dd/mm/yyyy'), gender='"+sex+"', name_suffix= '"+name_suffix+"', patient_name='"+patient_name+"',res_tel_no = '"+contact1_no+"', oth_contact_no = '"+contact2_no+"', email_id = '"+email_id+"', national_id_no = '"+national_id_no+"', alt_id1_no = '"+alt_id1_no+"', res_addr_line1 = '"+addr1_line1+"', res_addr_line2 = '"+addr1_line2+"', res_addr_line3 = '"+addr1_line3+"', res_addr_line4 = '"+addr1_line4+"', postal_code = '"+postal1_code+"', country_code  = '"+nationality_code+"', alt_id1_exp_date = to_date('"+alt_id1_exp_date+"','dd/mm/yyyy')   where BKG_LST_REF_NO = '"+q_booking_ref_no+"' and facility_id='"+facility_id+"' ";

				pstmt1 = con.prepareStatement( upd_sql2 );
			  
				 pstmt1.executeUpdate();

				if(pstmt1 != null) pstmt1.close();
				con.commit();
			  }catch(Exception ee)
			  {
				  ee.printStackTrace();
			  }

		  }
          else
          {

			 if(q_booking_type.equals("D")){
				q_appt_ref_no	= q_booking_ref_no;
			}
			   if(from_VR.equals("Y"))
               {    /*Below Query Modified for this CRF [RUT-CRF-0011]*/
			       
				   //int rows = 0;
				   try{
					String upd_sql = "Update oa_appt set  PATIENT_ID = ?, NAME_PREFIX = ?, FIRST_NAME = ?, SECOND_NAME = ?, THIRD_NAME = ?, FAMILY_NAME = ?, NAME_SUFFIX = ?, PATIENT_NAME = ?, GENDER = ?, DATE_OF_BIRTH = to_date(?,'dd/mm/yyyy'), RES_TEL_NO = ?, OTH_CONTACT_NO = ?, EMAIL_ID = ?, NATIONAL_ID_NO = ?, ALT_ID1_NO = ?, RES_ADDR_LINE1 = ?, RES_ADDR_LINE2 = ?, RES_ADDR_LINE3 = ?, RES_ADDR_LINE4 = ?, POSTAL_CODE = ?, COUNTRY_CODE  = ? ,RES_AREA_CODE = ?, RES_TOWN_CODE=?, CITIZEN_YN=?, LEGAL_YN=?, ALT_ID1_TYPE=?, ALT_ID1_EXP_DATE=to_date(?,'dd/mm/yyyy'), ALT_ID2_TYPE=?, ALT_ID2_NO=?, ALT_ID2_EXP_DATE=to_date(?,'dd/mm/yyyy'), ALT_ID3_TYPE=?, ALT_ID3_NO=?, ALT_ID3_EXP_DATE=to_date(?,'dd/mm/yyyy'), ALT_ID4_TYPE=?, ALT_ID4_NO=?, ALT_ID4_EXP_DATE=to_date(?,'dd/mm/yyyy'), OTH_ALT_ID_TYPE=?, OTH_ALT_ID_NO=?, BIRTH_PLACE_CODE=?, ETHNIC_GROUP_CODE=?,RACE_CODE=?,RES_REGION_CODE=?, MAIL_ADDR_LINE1=?,MAIL_ADDR_LINE2=?, MAIL_ADDR_LINE3=?, MAIL_ADDR_LINE4=?, MAIL_AREA_CODE=?, MAIL_TOWN_CODE=?, MAIL_REGION_CODE=?, MAIL_POSTAL_CODE=?, MAIL_COUNTRY_CODE=?, BIRTH_PLACE_DESC=?,NAME_PREFIX_LOC_LANG=?, FIRST_NAME_LOC_LANG=?, SECOND_NAME_LOC_LANG=?, THIRD_NAME_LOC_LANG=?, FAMILY_NAME_LOC_LANG=?, NAME_SUFFIX_LOC_LANG=?, PATIENT_NAME_LOC_LANG=?, PATIENT_CAT_CODE=?,patient_long_name=?, patient_long_name_loc_lang=? where appt_ref_no = ? and facility_id = ?";

					pstmt1 = con.prepareStatement( upd_sql );
					pstmt1.setString (1, patient_id);
					pstmt1.setString (2, name_prefix);
					pstmt1.setString (3, first_name);
					pstmt1.setString (4, second_name);
					pstmt1.setString (5, third_name);
					pstmt1.setString (6, family_name);
					pstmt1.setString (7, name_suffix);
					pstmt1.setString (8, patient_name);
					pstmt1.setString (9, sex);
					pstmt1.setString (10, date_of_birth);
					pstmt1.setString (11, contact1_no);
					pstmt1.setString (12, contact2_no);
					pstmt1.setString (13, email_id);
					pstmt1.setString (14, national_id_no);
					pstmt1.setString (15, alt_id1_no);
					pstmt1.setString (16, addr1_line1);
					pstmt1.setString (17, addr1_line2);
					pstmt1.setString (18, addr1_line3);
					pstmt1.setString (19, addr1_line4);
					pstmt1.setString (20, postal1_code);
					pstmt1.setString (21, nationality_code);
					pstmt1.setString (22, area1_code);
					pstmt1.setString (23, town1_code);
					pstmt1.setString (24, citizen_yn);
					pstmt1.setString (25, legal_yn);
					pstmt1.setString (26, alt_id1_type);
					pstmt1.setString (27, alt_id1_exp_date);
					pstmt1.setString (28, alt_id2_type);
					pstmt1.setString (29, alt_id2_no);
					pstmt1.setString (30, alt_id2_exp_date);
					pstmt1.setString (31, alt_id3_type);
					pstmt1.setString (32, alt_id3_no);
					pstmt1.setString (33, alt_id3_exp_date);
					pstmt1.setString (34, alt_id4_type);
					pstmt1.setString (35, alt_id4_no);
					pstmt1.setString (36, alt_id4_exp_date);
					pstmt1.setString (37, oth_alt_id_type);
					pstmt1.setString (38, oth_alt_id_no);
					pstmt1.setString (39, birth_place_code);
					pstmt1.setString (40, ethnic_grp_code);
					pstmt1.setString (41, race_code);
					pstmt1.setString (42, res_region_code);
					pstmt1.setString (43, addr2_line1);
					pstmt1.setString (44, addr2_line2);
					pstmt1.setString (45, addr2_line3);
					pstmt1.setString (46, addr2_line4);
					pstmt1.setString (47, area2_code);
					pstmt1.setString (48, town2_code);
					pstmt1.setString (49, region2_code);
					pstmt1.setString (50, postal2_code);
					pstmt1.setString (51, country2_code);
					pstmt1.setString (52, birth_place_desc);
					pstmt1.setString (53, name_prefix_loc_lang);
					pstmt1.setString (54, first_name_loc_lang);
					pstmt1.setString (55, second_name_loc_lang);
					pstmt1.setString (56, third_name_loc_lang);
					pstmt1.setString (57, family_name_loc_lang);
					pstmt1.setString (58, name_suffix_loc_lang);
					pstmt1.setString (59, patient_name_loc_lang);
					pstmt1.setString (60, pat_cat_code);
					pstmt1.setString (61, patient_long_name);
					pstmt1.setString (62, patient_long_name_loc_lang);
					pstmt1.setString (63, q_appt_ref_no);
					pstmt1.setString (64, facility_id); 
					 pstmt1.executeUpdate();

					if(pstmt1 != null) pstmt1.close();
				   }catch(Exception ee1)
				   {
					   ee1.printStackTrace();
				   }
                }
				

               if(!p_referral_id.equals(""))
               {
				   try{
					String upd_sql1 = "Update pr_referral_register set PATIENT_ID = ?, NAME_PREFIX = ?, FIRST_NAME = ?, SECOND_NAME = ?, THIRD_NAME = ?, FAMILY_NAME = ?, NAME_SUFFIX = ?, PATIENT_NAME = ?, SEX = ?, DATE_OF_BIRTH = to_date(?,'dd/mm/yyyy'), NATIONALITY_CODE = ?, ADDR_LINE1 = ?, ADDR_LINE2 = ?, ADDR_LINE3  = ?, ADDR_LINE4 = ?, CONTACT1_NO = ?, CONTACT2_NO = ?,POSTAL_CODE=?,COUNTRY_CODE=?,RES_AREA_CODE=?,RES_TOWN_CODE=?,NATIONAL_ID_NO=?,ALT_ID1_TYPE=?,ALT_ID1_NO=?,ALT_ID1_DATE=to_date(?,'dd/mm/yyyy'),ALT_ID2_TYPE=?,ALT_ID2_NO=?,ALT_ID2_DATE=to_date(?,'dd/mm/yyyy'),ALT_ID3_TYPE=?,ALT_ID3_NO=?,ALT_ID3_DATE=to_date(?,'dd/mm/yyyy'),ALT_ID4_TYPE=?,ALT_ID4_NO=?,ALT_ID4_DATE=to_date(?,'dd/mm/yyyy'),OTH_ALT_ID_TYPE=?,OTH_ALT_ID_NO=?,CITIZEN_YN=?,LEGAL_ILLEGAL_YN=?,RACE_CODE=?,REGION_CODE=?,MAIL_ADDR_LINE1=?,MAIL_ADDR_LINE2=?,MAIL_ADDR_LINE3=?,MAIL_ADDR_LINE4=?,MAIL_RES_TOWN_CODE=?,MAIL_RES_AREA_CODE=?,MAIL_COUNTRY_CODE=?,MAIL_POSTAL_CODE=?,MAIL_REGION_CODE=?,BIRTH_PLACE_CODE=?,ETHNIC_GRP_CODE=?,BIRTH_PLACE_DESC=?, NAME_PREFIX_LOC_LANG=?, FIRST_NAME_LOC_LANG=?, SECOND_NAME_LOC_LANG=?, THIRD_NAME_LOC_LANG=?, FAMILY_NAME_LOC_LANG=?,NAME_SUFFIX_LOC_LANG=?, PATIENT_NAME_LOC_LANG=?,patient_long_name=?, patient_long_name_loc_lang=? where referral_id = ?";

					pstmt1 = con.prepareStatement( upd_sql1 );
					pstmt1.setString (1, patient_id);
					pstmt1.setString (2, name_prefix);
					pstmt1.setString (3, first_name);
					pstmt1.setString (4, second_name);
					pstmt1.setString (5, third_name);
					pstmt1.setString (6, family_name);
					pstmt1.setString (7, name_suffix);
					pstmt1.setString (8, patient_name);
					pstmt1.setString (9, sex);					
					pstmt1.setString (10, date_of_birth);
					pstmt1.setString (11, nationality_code);
					pstmt1.setString (12, addr1_line1);
					pstmt1.setString (13, addr1_line2);
					pstmt1.setString (14, addr1_line3);
					pstmt1.setString (15, addr1_line4);
					pstmt1.setString (16, contact1_no);
					pstmt1.setString (17, contact2_no);
					pstmt1.setString (18, postal1_code);
					pstmt1.setString (19, nationality_code);
					pstmt1.setString (20, area1_code);
					pstmt1.setString (21, town1_code);
					pstmt1.setString (22, national_id_no);
					pstmt1.setString (23, alt_id1_type);
					pstmt1.setString (24, alt_id1_no);
					pstmt1.setString (25, alt_id1_exp_date);
					pstmt1.setString (26, alt_id2_type);
					pstmt1.setString (27, alt_id2_no);
					pstmt1.setString (28, alt_id2_exp_date);
					pstmt1.setString (29, alt_id3_type);
					pstmt1.setString (30, alt_id3_no);
					pstmt1.setString (31, alt_id3_exp_date);
					pstmt1.setString (32, alt_id4_type);
					pstmt1.setString (33, alt_id4_no);
					pstmt1.setString (34, alt_id4_exp_date);
					pstmt1.setString (35, oth_alt_id_type);
					pstmt1.setString (36, oth_alt_id_no);
					pstmt1.setString (37, citizen_yn);
					pstmt1.setString (38, legal_yn);
					pstmt1.setString (39, race_code);
					pstmt1.setString (40, res_region_code);
					pstmt1.setString (41, addr2_line1);
					pstmt1.setString (42, addr2_line2);
					pstmt1.setString (43, addr2_line3);
					pstmt1.setString (44, addr2_line4);
					pstmt1.setString (45, town2_code);
					pstmt1.setString (46, area2_code);
					pstmt1.setString (47, country2_code);
					pstmt1.setString (48, postal2_code);
					pstmt1.setString (49, region2_code);
					pstmt1.setString (50, birth_place_code);
					pstmt1.setString (51, ethnic_grp_code);
					pstmt1.setString (52, birth_place_desc);
					pstmt1.setString (53, name_prefix_loc_lang);
					pstmt1.setString (54, first_name_loc_lang);
					pstmt1.setString (55, second_name_loc_lang);
					pstmt1.setString (56, third_name_loc_lang);
					pstmt1.setString (57, family_name_loc_lang);
					pstmt1.setString (58, name_suffix_loc_lang);
					pstmt1.setString (59, patient_name_loc_lang);
					pstmt1.setString (60, patient_long_name);
					pstmt1.setString (61, patient_long_name_loc_lang);
					pstmt1.setString (62, p_referral_id);

					pstmt1.executeUpdate();

					if(pstmt1 != null) pstmt1.close();
				   }catch(Exception ee2)
				   {
					  ee2.printStackTrace();
				   }
               }
               con.commit();
			   isPortalPatient	=CommonBean.isPortalPatient(con,q_appt_ref_no,facility_id);
				hashdata		=CommonBean.portalInstallation(con);
				site_IP			=(String)hashdata.get("site_ip");
				site_id			=(String)hashdata.get("site_id");
				port			=(Integer)hashdata.get("port")==null?0:(Integer)hashdata.get("port");
				
				/* Added by Karthik to Support Online portal Update From EM Operations - Starts Added Site Id on 2/2/2017 */
			
				if(isPortalPatient){
					if(port!=0&&site_IP!=""&&site_IP!=null){
		
					URL url = new URL("http://"+site_IP+":"+port+"/patientportal/rest/updateportaldb");    //PatientId and AppointmentId needs to be assigned
						System.err.println("url 314 ==> "+url.toString());
					String postInputJsonParams = "{\"locale\":\""+locale+"\",\"siteId\":\""+site_id+"\",\"appointmentId\":\""+q_appt_ref_no+"\",\"patientId\":\""+patient_id+"\"}";
					CommonBean.restPostRequest(url,postInputJsonParams);
				
					}
				}
				/* Added by Karthik to Support Online portal Update From EM Operations - Ends */
		  }

		  }
		}
	   }
        catch(Exception e){e.printStackTrace();}
        finally
        {
           try{
			if(rs != null)    rs.close() ;
            if(pstmt != null)   pstmt.close() ;
			if(pstmt1 != null)   pstmt1.close() ;
			}catch(Exception e){}
            if(con!=null) ConnectionManager.returnConnection(con,request);
        }
		%>
		</form>
	</body>
</html> 


<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page  contentType="text/html;charset=UTF-8"  import ="java.sql.*, webbeans.eCommon.*,java.util.*,javax.servlet.http.*,javax.servlet.jsp.JspWriter " %>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    String locale =((String)session.getAttribute("LOCALE"));
    request.setCharacterEncoding("UTF-8");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<script src='../../eMP/js/RegPatReferral.js' language='javascript'></script>	
		<script src='../../eCommon/js/dchk.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 	
		<script>
		function tab_click1(id1){
			
			//alert(id1);
			selectTab(id1);
			
			tab_click(id1);
	        }
		</script>
	</head>
	<%
		String facilityid = (String) session.getValue("facility_id");
		Connection con=null;
		PreparedStatement pstmt=null;
		
		ResultSet mod_rs=null ;
		

		try
		{
			con = ConnectionManager.getConnection(request);	
			String pat_ID = (request.getParameter("pat_ID") == null)?"":request.getParameter("pat_ID");	
			String calling_from		= (request.getParameter("calling_from") == null)?"":request.getParameter("calling_from");	
			String p_calling_function		= (request.getParameter("p_calling_function") == null)?"":request.getParameter("p_calling_function");
			String ass_func_id="";
			if(p_calling_function.equals("OP_REG_VISIT"))
			{
				ass_func_id=(request.getParameter("ass_func_id") == null)?"":request.getParameter("ass_func_id");
			}	
			String referral_id	= (request.getParameter("referral_id") == null)?"":request.getParameter("referral_id");		
			String mode = (request.getParameter("mode") == null)?"insert":request.getParameter("mode");	
			if(mode.equals("")) mode="insert";
			String ca_patient_id= (request.getParameter("ca_patient_id") == null)?"":request.getParameter("ca_patient_id");
			StringBuffer mod_sql			= new StringBuffer();
			String patientid="";
		    String family_name_loc_lang="";
			String third_name_loc_lang="";
			String second_name_loc_lang="";
			String first_name_loc_lang="";
			String name_prefix_loc_lang="";
			String name_suffix_loc_lang="";
			String patient_name_loc_lang="";
			String mail_postal_desc="";
			String postal_desc="";
			String patient_name		= "";
			String name_prefix		= "";
			String first_name		= "";
			String second_name		= "";
			String third_name		= "";
			String family_name		= "";
			String name_suffix		= "";
			String sex				= "";
			String date_of_birth	= "";
			String nationality_code	= "";
			String display_nationality_desc	= "";
			String birth_place_desc	= "";
			String birth_place_code	= "";
			String birth_place_desc_referral = "";
			String addr_line1		= "";
			String addr_line2		= "";
			String addr_line3		= "";
			String addr_line4		= "";
			String contact1_no		= "";
			String contact2_no		= "";
			String age				= "";
			String months			= "";
			String days				= "";
			String national_id_no=""; 
			String alt_id1_id=""; 
			String alt_id2_id=""; 
			String alt_id3_id=""; 
			String alt_id4_id=""; 
			String alt_id1_date=""; 
			String alt_id2_date="";
			String alt_id3_date ="";
			String alt_id4_date ="";
			String res_town_code="";
			String res_area_code=""; 
			String country_code=""; 
			String postal_code="";
			String region_code="";
			String mail_addr_line1="";
			String mail_addr_line2=""; 
			String mail_addr_line3=""; 
			String mail_addr_line4=""; 
			String mail_res_town_code="";
			String mail_res_area_code=""; 
			String mail_region_code=""; 
			String mail_country_code =""; 
			String mail_postal_code =""; 
			String citizen_yn="";
			String legal_illegal_yn="";
			String race_code="";
			String race_desc="";
			String ethnic_grp_code="";
			String ethnic_grp_desc="";	
			String email_id="";
			String country1_desc="";
			String country2_desc="";
			String res_town_desc="";
			String res_area_desc="";
			String region_desc="";
			String mail_res_town_desc="";
			String mail_res_area_desc="";
			String mail_region_desc="";
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
			/*End*/
		
			String oth_alt_Id="";
			String oth_alt_type="";
			String oth_alt_id_type_desc="";
			if(mode.equals("modify") || mode.equals("RegisterMoreReferral"))
			{
				mod_sql.append("select a.national_id_no, a.alt_id1_no, a.alt_id2_no, a.alt_id3_no, a.alt_id4_no, to_char (a.alt_id1_date, 'dd/mm/yyyy') alt_id1_date, to_char (a.alt_id2_date, 'dd/mm/yyyy') alt_id2_date, to_char (a.alt_id3_date, 'dd/mm/yyyy') alt_id3_date, to_char(a.alt_id4_date, 'dd/mm/yyyy') alt_id4_date, a.res_town_code, mp_get_desc.mp_res_town(a.res_town_code, '"+locale+"','1') res_town_desc, a.res_area_code, mp_get_desc.mp_res_area(a.res_area_code, '"+locale+"','1') res_area_desc, a.country_code, mp_get_desc.mp_country(a.country_code, '"+locale+"','1') country1_desc, a.region_code, mp_get_desc.mp_region(a.region_code, '"+locale+"','2') region_desc, a.postal_code, mp_get_desc.mp_postal_code(a.postal_code, '"+locale+"','2') postal_desc, a.mail_res_town_code, mp_get_desc.mp_res_town(a.mail_res_town_code, '"+locale+"','1') mail_res_town_desc, a.mail_res_area_code, mp_get_desc.mp_res_area(a.mail_res_area_code, '"+locale+"','1') mail_res_area_desc, a.mail_country_code, mp_get_desc.mp_country(a.mail_country_code, '"+locale+"','1') country2_desc, a.mail_region_code, mp_get_desc.mp_region(a.mail_region_code, '"+locale+"','2') mail_region_desc,a.mail_postal_code, mp_get_desc.mp_postal_code(a.mail_postal_code, '"+locale+"','2') mail_postal_desc, a.race_code, mp_get_desc.mp_race(a.race_code, '"+locale+"','1') race_desc, a.nationality_code, mp_get_desc.mp_country(a.nationality_code, '"+locale+"','3') nationality_desc, a.birth_place_code, mp_get_desc.mp_birth_place(a.birth_place_code, '"+locale+"','1') birth_place_desc, a.ethnic_grp_code, mp_get_desc.mp_ethnic_group(a.ethnic_grp_code, '"+locale+"','1') ethnic_grp_desc, mp_get_desc.mp_alternate_id_type(a.oth_alt_id_type, '"+locale+"','1') oth_alt_id_type_desc,    a.mail_addr_line1, a.mail_addr_line2, a.mail_addr_line3, a.mail_addr_line4, a.citizen_yn, a.legal_illegal_yn, a.patient_id, a.patient_name, a.name_prefix, a.first_name, a.second_name, a.third_name, a.family_name, a.name_suffix, a.sex, to_char(a.date_of_birth, 'dd/mm/yyyy') date_of_birth, calculate_age (to_char (a.date_of_birth, 'dd/mm/yyyy'), 1) age, calculate_age (to_char (a.date_of_birth, 'dd/mm/yyyy'), 2) months, calculate_age (to_char (a.date_of_birth, 'dd/mm/yyyy'), 3) days, a.nationality_code, birth_place_code, a.addr_line1, a.addr_line2, a.addr_line3, a.addr_line4, a.contact1_no, a.contact2_no, a.email_id, a.birth_place_desc birth_place_desc_referral, a.oth_alt_id_type, a.oth_alt_id_no, a.family_name_loc_lang, a.third_name_loc_lang, a.second_name_loc_lang, a.first_name_loc_lang, a.name_suffix_loc_lang, a.patient_name_loc_lang, a.name_prefix_loc_lang, a.alt_addr_line1, a.alt_addr_line2, a.alt_addr_line3, a.alt_addr_line4, a.alt_area_code, MP_GET_DESC.MP_RES_AREA(a.alt_area_code,'"+locale+"','1') alt_area_desc, a.alt_town_code, MP_GET_DESC.MP_RES_TOWN(a.alt_town_code,'"+locale+"','1') alt_town_desc, a.alt_region_code, MP_GET_DESC.MP_REGION(a.alt_region_code,'"+locale+"','1') alt_region_desc, a.alt_postal_code, MP_GET_DESC.mp_postal_code(a.alt_postal_code,'"+locale+"','2') alt_postal_desc, a.alt_country_code, MP_GET_DESC.MP_COUNTRY(a.alt_country_code,'"+locale+"','1') alt_country_desc from pr_referral_register a ");//Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601
				if(mode.equals("modify"))
				{
					mod_sql.append(" where a.referral_id =? ");
				}
				else if(mode.equals("RegisterMoreReferral"))
				{
					if(!pat_ID.equals(""))
					{
					  mod_sql.append(" where a.patient_id =? order by a.referral_id ");
					}
					else
					{
						mod_sql.append(" where a.referral_id =? order by a.referral_id ");
					}
				}
				pstmt = con.prepareStatement(mod_sql.toString());
				if(mode.equals("modify"))
				{
					pstmt.setString(1,referral_id);
				}
				else if(mode.equals("RegisterMoreReferral"))
				{
					if(!pat_ID.equals(""))
					{
					pstmt.setString(1,pat_ID);
					}
					else
					{
					pstmt.setString(1,referral_id);
					}	
				}
				mod_rs = pstmt.executeQuery();
				while(mod_rs !=null&& mod_rs.next())
				{
					oth_alt_type = mod_rs.getString("oth_alt_id_type");
					if (oth_alt_type==null) oth_alt_type="";

					oth_alt_Id = mod_rs.getString("oth_alt_id_no");
					if (oth_alt_Id==null) oth_alt_Id="";

					oth_alt_id_type_desc = mod_rs.getString("oth_alt_id_type_desc");
					if (oth_alt_id_type_desc==null) oth_alt_id_type_desc="";					

					email_id = mod_rs.getString("email_id");
					if (email_id==null) email_id="";
					region_code             = mod_rs.getString("region_code");
					if (region_code==null) region_code="";

					mail_region_code                = mod_rs.getString("mail_region_code");
					if (mail_region_code==null) mail_region_code="";

					race_code               = mod_rs.getString("race_code");
					if (race_code==null) race_code="";		

					race_desc  = mod_rs.getString("race_desc");
					if (race_desc==null) race_desc="";	

					ethnic_grp_code     = mod_rs.getString("ethnic_grp_code");
					if (ethnic_grp_code==null) ethnic_grp_code="";						

					ethnic_grp_desc     = mod_rs.getString("ethnic_grp_desc");
					if (ethnic_grp_desc==null) ethnic_grp_desc="";

					legal_illegal_yn                = mod_rs.getString("legal_illegal_yn");
					if (legal_illegal_yn==null) legal_illegal_yn="";

					citizen_yn              = mod_rs.getString("citizen_yn");
					if (citizen_yn==null) citizen_yn="";

					alt_id2_date            = mod_rs.getString("alt_id2_date");
					if (alt_id2_date==null) alt_id2_date="";


					alt_id1_date            = mod_rs.getString("alt_id1_date");
					if (alt_id1_date==null) alt_id1_date="";

					alt_id4_id              = mod_rs.getString("alt_id4_no");
					if (alt_id4_id==null) alt_id4_id="";

					alt_id3_id              = mod_rs.getString("alt_id3_no");
					if (alt_id3_id==null) alt_id3_id="";

					alt_id2_id              = mod_rs.getString("alt_id2_no");
					if (alt_id2_id==null) alt_id2_id="";

					alt_id1_id              = mod_rs.getString("alt_id1_no");
					if (alt_id1_id==null) alt_id1_id="";

					national_id_no          = mod_rs.getString("national_id_no");
					if (national_id_no==null) national_id_no="";

					alt_id3_date            = mod_rs.getString("alt_id3_date");
					if (alt_id3_date==null) alt_id3_date="";

					alt_id4_date            = mod_rs.getString("alt_id4_date");
					if (alt_id4_date==null) alt_id4_date="";

					res_town_code           = mod_rs.getString("res_town_code");
					if (res_town_code==null) res_town_code="";
					mail_postal_code                = mod_rs.getString("mail_postal_code");
					if (mail_postal_code==null) mail_postal_code="";


					mail_country_code                = mod_rs.getString("mail_country_code");
					if (mail_country_code==null) mail_country_code="";

					mail_res_area_code              = mod_rs.getString("mail_res_area_code");
					if (mail_res_area_code==null) mail_res_area_code="";
					mail_res_town_code              = mod_rs.getString("mail_res_town_code");
					if (mail_res_town_code==null) mail_res_town_code="";
					mail_addr_line4          = mod_rs.getString("mail_addr_line4");
					if (mail_addr_line4==null) mail_addr_line4="";

					mail_addr_line3                 = mod_rs.getString("mail_addr_line3");
					if (mail_addr_line3==null) mail_addr_line3="";

					mail_addr_line2                 = mod_rs.getString("mail_addr_line2");
					if (mail_addr_line2==null) mail_addr_line2="";

					mail_addr_line1          = mod_rs.getString("mail_addr_line1");
					if (mail_addr_line1==null) mail_addr_line1="";

					res_area_code           = mod_rs.getString("res_area_code");
					if (res_area_code==null) res_area_code="";

					country_code            = mod_rs.getString("country_code");
					if (country_code==null) country_code="";


					postal_code              = mod_rs.getString("postal_code");
					if (postal_code==null) postal_code="";

					postal_desc              = mod_rs.getString("postal_desc");
					if (postal_desc==null) postal_desc="";

					mail_postal_desc              = mod_rs.getString("mail_postal_desc");
					if (mail_postal_desc==null) mail_postal_desc="";

					mail_region_desc            = mod_rs.getString("mail_region_desc");
					if (mail_region_desc==null) mail_region_desc="";

					mail_res_area_desc              = mod_rs.getString("mail_res_area_desc");
					if (mail_res_area_desc==null) mail_res_area_desc="";

					mail_res_town_desc            = mod_rs.getString("mail_res_town_desc");
					if (mail_res_town_desc==null) mail_res_town_desc="";

					region_desc              = mod_rs.getString("region_desc");
					if (region_desc==null) region_desc="";

					res_area_desc            = mod_rs.getString("res_area_desc");
					if (res_area_desc==null) res_area_desc="";

					res_town_desc              = mod_rs.getString("res_town_desc");
					if (res_town_desc==null) res_town_desc="";

					country2_desc            = mod_rs.getString("country2_desc");
					if (country2_desc==null) country2_desc="";

					country1_desc              = mod_rs.getString("country1_desc");
					if (country1_desc==null) country1_desc="";
					patientid			=mod_rs.getString("patient_id");
					if (patientid==null) patientid="";

					patient_name		=mod_rs.getString("patient_name");
					if (patient_name==null) patient_name="";
					name_prefix		=mod_rs.getString("name_prefix");
					if (name_prefix==null) name_prefix="";
					first_name			=mod_rs.getString("first_name");
					if (first_name==null) first_name="";
					second_name		=mod_rs.getString("second_name");
					if (second_name==null) second_name="";
					third_name			=mod_rs.getString("third_name");
					if (third_name==null) third_name="";
					family_name		=mod_rs.getString("family_name");
					if (family_name==null) family_name="";
					name_suffix		=mod_rs.getString("name_suffix");
					if (name_suffix==null) name_suffix="";

					patient_name_loc_lang		=mod_rs.getString("patient_name_loc_lang");
					if (patient_name_loc_lang==null) patient_name_loc_lang="";
					
					name_prefix_loc_lang		=mod_rs.getString("name_prefix_loc_lang");
					if (name_prefix_loc_lang==null) name_prefix_loc_lang="";

					first_name_loc_lang		=mod_rs.getString("first_name_loc_lang");
					if (first_name_loc_lang==null) first_name_loc_lang="";

					second_name_loc_lang		=mod_rs.getString("second_name_loc_lang");
					if (second_name_loc_lang==null) second_name_loc_lang="";

					third_name_loc_lang		=mod_rs.getString("third_name_loc_lang");
					if (third_name_loc_lang==null) third_name_loc_lang="";

					family_name_loc_lang		=mod_rs.getString("family_name_loc_lang");
					if (family_name_loc_lang==null) family_name_loc_lang="";

					name_suffix_loc_lang		=mod_rs.getString("name_suffix_loc_lang");
					if (name_suffix_loc_lang==null) name_suffix_loc_lang="";

					sex				=mod_rs.getString("sex");
					if (sex==null) sex="";
					date_of_birth		=mod_rs.getString("date_of_birth");
					if (date_of_birth==null) date_of_birth="";
					
					if ( !date_of_birth.equals("") )
					{
						if (!localeName.equals("en"))
						{
							date_of_birth = DateUtils.convertDate(date_of_birth,"DMY","en",localeName); 
						}
					}
					age		=mod_rs.getString("age");
					if (age==null) age="";
					months		=mod_rs.getString("months");
					if (months==null) months="";
					days		=mod_rs.getString("days");
					if (days==null) days="";
					nationality_code	=mod_rs.getString("nationality_code");
					if (nationality_code==null) nationality_code="";

					display_nationality_desc	=mod_rs.getString("nationality_desc");
					if (display_nationality_desc==null) display_nationality_desc="";
					birth_place_desc	=mod_rs.getString("birth_place_desc");
					if (birth_place_desc==null) birth_place_desc="";

					birth_place_desc_referral = mod_rs.getString("birth_place_desc_referral");
					if (birth_place_desc_referral==null) birth_place_desc_referral="";

					birth_place_code	=mod_rs.getString("birth_place_code");
					if (birth_place_code==null) birth_place_code="";
					addr_line1			=mod_rs.getString("addr_line1");
					if (addr_line1==null) addr_line1="";
					addr_line2			=mod_rs.getString("addr_line2");
					if (addr_line2==null) addr_line2="";
					addr_line3			=mod_rs.getString("addr_line3");
					if (addr_line3==null) addr_line3="";
					addr_line4			=mod_rs.getString("addr_line4");
					if (addr_line4==null) addr_line4="";
					contact1_no		=mod_rs.getString("contact1_no");
					if (contact1_no==null) contact1_no="";
					contact2_no		=mod_rs.getString("contact2_no");
					if (contact2_no==null) contact2_no="";

					/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
					alt_addr_line1		= checkForNull(mod_rs.getString("alt_addr_line1"));
					alt_addr_line2		= checkForNull(mod_rs.getString("alt_addr_line2"));
					alt_addr_line3		= checkForNull(mod_rs.getString("alt_addr_line3"));
					alt_addr_line4		= checkForNull(mod_rs.getString("alt_addr_line4"));
					alt_area_code		= checkForNull(mod_rs.getString("alt_area_code"));
					alt_area_desc		= checkForNull(mod_rs.getString("alt_area_desc"));
					alt_town_code		= checkForNull(mod_rs.getString("alt_town_code"));
					alt_town_desc		= checkForNull(mod_rs.getString("alt_town_desc"));
					alt_region_code		= checkForNull(mod_rs.getString("alt_region_code"));
					alt_region_desc		= checkForNull(mod_rs.getString("alt_region_desc"));
					alt_postal_code		= checkForNull(mod_rs.getString("alt_postal_code"));
					alt_postal_desc		= checkForNull(mod_rs.getString("alt_postal_desc"));
					alt_country_code	= checkForNull(mod_rs.getString("alt_country_code"));
					alt_country_desc	= checkForNull(mod_rs.getString("alt_country_desc"));
					/*End*/

				}
				if(mod_rs != null) mod_rs.close();
				if(pstmt != null) pstmt.close();
				mod_sql.setLength(0);

			}
			
			%>
				
			<body OnMouseDown='CodeArrest()' onKeyDown ='lockKey()' onSelect = "resMove()" >
			<form name="RegPatReferral_form" id="RegPatReferral_form" >
				<input type='hidden' name='ct_tab_name' id='ct_tab_name' >
				<table cellpadding=0 cellspacing=0 border=0 width="100%" tabindex=-1>
				<%
			/*
				try
				{
					
					mod_sql.append("  select nvl(name_prefix_prompt,'')name_prefix_prompt, nvl(first_name_prompt,'')first_name_prompt, nvl(name_suffix_prompt,'')name_suffix_prompt,nvl(second_name_prompt,'')second_name_prompt, nvl(third_name_prompt,'') third_name_prompt, pat_name_as_multipart_yn, nvl(family_name_prompt,'')family_name_prompt, patient_id_length, NVL(nat_id_prompt,'National ID No') nat_id_prompt  from mp_param_lang_vw where language_id='"+locale+"'");
					
					pstmt=con.prepareStatement(mod_sql.toString());			
					rset = pstmt.executeQuery();
					if(rset!=null && rset.next())
					{				

						nat_id_prompt=rset.getString("nat_id_prompt");			
						if(nat_id_prompt== null) nat_id_prompt="";	
						nameprefixprompt		= rset.getString("NAME_PREFIX_PROMPT");
						firstnameprompt			= rset.getString("FIRST_NAME_PROMPT");
						secondnameprompt	= rset.getString("SECOND_NAME_PROMPT");
						thirdnameprompt		= rset.getString("THIRD_NAME_PROMPT");
						familynameprompt		= rset.getString("FAMILY_NAME_PROMPT");
						namesuffixprompt		= rset.getString("NAME_SUFFIX_PROMPT");
						//Added on 15/03/2003
						pat_name_as_multipart_yn = rset.getString("pat_name_as_multipart_yn");
						if(pat_name_as_multipart_yn==null) pat_name_as_multipart_yn="N";
						//End of addition on 15/03/2003			*/			
						%>				
					<%--	<input type='hidden' name='name_prefix_prompt' id='name_prefix_prompt' value="">
						<input type='hidden' name='first_name_prompt' id='first_name_prompt' value="">
						<input type='hidden' name='second_name_prompt' id='second_name_prompt' value="">
						<input type='hidden' name='third_name_prompt' id='third_name_prompt' value="">
						<input type='hidden' name='family_name_prompt' id='family_name_prompt' value="">
						<input type='hidden' name='name_suffix_prompt' id='name_suffix_prompt' value="">
						<input type='hidden' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value=""> --%>
						<%
				/*	}

					if(rset != null) rset.close();
					if(pstmt != null) pstmt.close();
					mod_sql.setLength(0);
				}catch(Exception e)
				{
					out.println("Exception in Nat ID modify :"+e);
					e.printStackTrace();
				}
			*/
				if(mode.equals("modify"))
				{	%>
				<tr>
					<td class=label  width='20%'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td><td><input type="text" name="ref_id" id="ref_id"  value ="<%=referral_id%>" size = 15 readonly tabindex=-1></td>
				</tr>
				<%		
				}else{	%>
					<tr>
					<td align=left class = label colspan=4 ></td>
				</tr>
				<%}%>

				</table>
				<table cellpadding=0 cellspacing=0 border=0 width="100%" tabindex=-1>
				<tr >
					<td colspan=4>	

				<%		
				if(mode.equals("modify") || mode.equals("RegisterMoreReferral"))
				{		
					%>
					<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" flush="true" >
					<jsp:param name ="patient_id"    value= "" />
					<jsp:param name ="alert_reqd_yn"  value= ""  />
					<jsp:param name ="bodyFrame"  value= "parent.frames[1].frames[0]"  />
					<jsp:param name ="op_call"  value= "reg_pat"  />
					</jsp:include>
					<%
				}
				else if(p_calling_function.equals("CHG_REG_DTLS"))
				{
					%>
					<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" flush="true" >
					<jsp:param name ="patient_id"    value= "" />
					<jsp:param name ="alert_reqd_yn"  value= ""  />
					<jsp:param name ="bodyFrame"  value= "parent.frames[1].frames[0]"  />
					<jsp:param name ="op_call"  value= "ae_reg_pat"  />
					</jsp:include>
					<%
				}
					else if(!ca_patient_id.equals(""))
				{ 
					%>
					<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" flush="true" >
					<jsp:param name ="patient_id"  value= "" />
					
					<jsp:param name ="alert_reqd_yn"   value= ""  />
					<jsp:param name ="bodyFrame"  value= "parent.frames[1].frames[0]"  />
					<jsp:param name ="op_call"  value= "ae_reg_pat"  />
					</jsp:include>
					<%	
				}
				else
				{ 
					%>
					<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" flush="true" >
					<jsp:param name ="patient_id"  value= "" />	
					<jsp:param name ="alert_reqd_yn"   value= ""  />
					<jsp:param name ="bodyFrame"  value= "parent.frames[1].frames[0]"  />
					<jsp:param name ="op_call"  value= "reg_pat"  />
					</jsp:include>
					<%	
				}	
				%>
					</td>
				</tr>
				
				<%if(!mode.equals("modify")){%>
				<tr>
					<td colspan=4 ></td>
				</tr>
			 	<%}%>
		</table>
		<input type='hidden' name='ca_patient_id' id='ca_patient_id' value='<%=ca_patient_id%>'>
		<input type="hidden" name="operation_type" id="operation_type" value="<%=mode%>">
 		<input type='hidden' name='serdang' id='serdang' value='serdang'>
		<input type="hidden" name="facilityid" id="facilityid" value="<%=facilityid%>">		
		<input type='hidden' name='function_id' id='function_id' value='REGISTER_PAT_REFERRAL'>
		<input type='hidden' name='calling_from' id='calling_from' value='<%=calling_from%>'>	
		<input type='hidden' name='referral_id' id='referral_id' value=''>
		<input type='hidden' name='race_code1' id='race_code1' value=''>
		<input type='hidden' name='concat_address_hidden' id='concat_address_hidden' value=''>
		<input type='hidden' name='concat_NatIdDetails_hidden' id='concat_NatIdDetails_hidden' value=''>
		<input type='hidden' name='p_calling_function' id='p_calling_function' value='<%=p_calling_function%>'>	
		<input type='hidden' name='ass_func_id' id='ass_func_id' value='<%=ass_func_id%>'>
		<input type='hidden' name='citizenvalue' id='citizenvalue' value=''>
		<input type='hidden' name='illegalvalue' id='illegalvalue' value=''>		
		
	</form>
</body>
		<%//condition modified for the incident - ML-BRU-SCF-0946 [IN:041858] - IP_ADMIT, AE_REGISTER_ATTN  and IP_BOOKING included
		if(mode.equals("RegisterMoreReferral") || p_calling_function.equals("CHG_REG_DTLS") || p_calling_function.equals("CHG_ADM_DTLS") ||
		p_calling_function.equals("OA_BOOK_APPT") || p_calling_function.equalsIgnoreCase("OA_MODIFY_APPT")  || !ca_patient_id.equals("") || 
		p_calling_function.equals("OP_REG_VISIT") || p_calling_function.equalsIgnoreCase("REV_VISIT_DTLS") || p_calling_function.equals("IP_ADMIT") 
		|| p_calling_function.equals("AE_REGISTER_ATTN") || p_calling_function.equals("IP_BOOKING") )
		{
			patientid = pat_ID; 
			
		}

		if(mode.equals("modify") || mode.equals("RegisterMoreReferral"))
		{
			%>
			<script>
				setTimeout("populate_details()",250);
				function populate_details()
				{					
					if(parent.frames[0].document.forms[0].patient_id.readOnly==true)
					{
						parent.frames[0].document.forms[0].patient_id.readOnly=false;
						parent.frames[0].document.forms[0].patient_id.value ="<%=patientid%>";
						parent.frames[0].document.forms[0].patient_id.readOnly=true;
					}
					else
					{
						parent.frames[0].document.forms[0].patient_id.value ="<%=patientid%>";
						
					}
					disableNatId();
					if(parent.frames[0].document.getElementById('patient_name1'))
						parent.frames[0].document.getElementById('patient_name1').innerHTML ="<b>"+"<%=patient_name%>";
					if(parent.frames[1].document.getElementById('patient_name'))
						parent.frames[1].document.getElementById('patient_name').value="<%=patient_name%>";
					if (parent.frames[0].document.forms[0].name_prefix)
						parent.frames[0].document.forms[0].name_prefix.value ="<%=name_prefix%>";
					if (parent.frames[0].document.forms[0].first_name)
						parent.frames[0].document.forms[0].first_name.value ="<%=first_name%>";
					if (parent.frames[0].document.forms[0].second_name)
						parent.frames[0].document.forms[0].second_name.value ="<%=second_name%>";
					if (parent.frames[0].document.forms[0].third_name)
						parent.frames[0].document.forms[0].third_name.value ="<%=third_name%>";
					if (parent.frames[0].document.forms[0].family_name)
						parent.frames[0].document.forms[0].family_name.value ="<%=family_name%>";
					if (parent.frames[0].document.forms[0].name_suffix)
						parent.frames[0].document.forms[0].name_suffix.value ="<%=name_suffix%>";
					
					if(parent.frames[0].document.forms[0].patient_name_local_lang)
						parent.frames[0].document.forms[0].patient_name_local_lang.value ="<%=patient_name_loc_lang%>";
					if(parent.frames[0].document.getElementById('patient_name_local_lang1'))
						parent.frames[0].document.getElementById('patient_name_local_lang1').innerHTML ="<b>"+"<%=patient_name_loc_lang%>";

					if (parent.frames[0].document.forms[0].first_name_oth_lang)
						parent.frames[0].document.forms[0].first_name_oth_lang.value ="<%=first_name_loc_lang%>";

					if (parent.frames[0].document.forms[0].second_name_oth_lang)
						parent.frames[0].document.forms[0].second_name_oth_lang.value ="<%=second_name_loc_lang%>";

					if (parent.frames[0].document.forms[0].third_name_oth_lang)
						parent.frames[0].document.forms[0].third_name_oth_lang.value ="<%=third_name_loc_lang%>";

					if (parent.frames[0].document.forms[0].family_name_oth_lang)
						parent.frames[0].document.forms[0].family_name_oth_lang.value ="<%=family_name_loc_lang%>";

					if (parent.frames[0].document.forms[0].name_prefix_oth_lang)
						parent.frames[0].document.forms[0].name_prefix_oth_lang.value ="<%=name_prefix_loc_lang%>";

					if (parent.frames[0].document.forms[0].name_suffix_oth_lang)
						parent.frames[0].document.forms[0].name_suffix_oth_lang.value ="<%=name_suffix_loc_lang%>";



					if (parent.frames[0].document.forms[0].sex)
						parent.frames[0].document.forms[0].sex.value ="<%=sex%>";

					if (parent.frames[0].document.forms[0].b_age)
						parent.frames[0].document.forms[0].b_age.value ="<%=age%>";

					if (parent.frames[0].document.forms[0].b_months)
						parent.frames[0].document.forms[0].b_months.value ="<%=months%>";

					if (parent.frames[0].document.forms[0].b_days)
						parent.frames[0].document.forms[0].b_days.value ="<%=days%>";

					if (parent.frames[0].document.forms[0].date_of_birth)
					{
						parent.frames[0].document.forms[0].date_of_birth.value ="<%=date_of_birth%>";
					}

					if (parent.frames[0].document.forms[0].primary_resi_no)
						parent.frames[0].document.forms[0].primary_resi_no.value ="<%=contact1_no%>";


					if (parent.frames[0].document.forms[0].other_resi_no)
						parent.frames[0].document.forms[0].other_resi_no.value ="<%=contact2_no%>";

					if(parent.frames[0].document.forms[0].national_id_no)
						parent.frames[0].document.forms[0].national_id_no.value = "<%=national_id_no%>";

					if(parent.frames[0].document.forms[0].alt_id1_no)
						parent.frames[0].document.forms[0].alt_id1_no.value = "<%=alt_id1_id%>"; 

					if(parent.frames[0].document.forms[0].alt_id2_no)
						parent.frames[0].document.forms[0].alt_id2_no.value = "<%=alt_id2_id%>";

					if(parent.frames[0].document.forms[0].alt_id3_no)
						parent.frames[0].document.forms[0].alt_id3_no.value ="<%=alt_id3_id%>";

					if(parent.frames[0].document.forms[0].alt_id4_no)
						parent.frames[0].document.forms[0].alt_id4_no.value = "<%=alt_id4_id%>";

					if(parent.frames[0].document.forms[0].alt_id1_exp_date)
						parent.frames[0].document.forms[0].alt_id1_exp_date.value = "<%=alt_id1_date%>";

					if(parent.frames[0].document.forms[0].alt_id2_exp_date)
						parent.frames[0].document.forms[0].alt_id2_exp_date.value ="<%=alt_id2_date%>";

					if(parent.frames[0].document.forms[0].alt_id3_exp_date)
						parent.frames[0].document.forms[0].alt_id3_exp_date.value = "<%=alt_id3_date%>";

					if(parent.frames[0].document.forms[0].alt_id4_exp_date)
						parent.frames[0].document.forms[0].alt_id4_exp_date.value = "<%=alt_id4_date%>";		

					if(parent.frames[0].document.forms[0].nationality_code1)
						parent.frames[0].document.forms[0].nationality_code1.value = "<%=nationality_code%>";

					if(parent.frames[0].document.forms[0].nationality_desc)
					parent.frames[0].document.forms[0].nationality_desc.value = "<%=display_nationality_desc%>";

					if(parent.frames[0].document.forms[0].birth_place)
					parent.frames[0].document.forms[0].birth_place.value = "<%=birth_place_desc%>";

					if(parent.frames[0].document.forms[0].place_of_birth)
					parent.frames[0].document.forms[0].place_of_birth.value = "<%=birth_place_desc_referral%>";

					if(parent.frames[0].document.forms[0].birth_place_code)
					parent.frames[0].document.forms[0].birth_place_code.value = "<%=birth_place_code%>";

					if (parent.frames[0].document.forms[0].addr_line1)
					parent.frames[0].document.forms[0].addr_line1.value ="<%=addr_line1%>";
					if (parent.frames[0].document.forms[0].addr_line2)
					parent.frames[0].document.forms[0].addr_line2.value ="<%=addr_line2%>";
					if (parent.frames[0].document.forms[0].addr_line3)
					parent.frames[0].document.forms[0].addr_line3.value ="<%=addr_line3%>";
					if (parent.frames[0].document.forms[0].addr_line4)
					parent.frames[0].document.forms[0].addr_line4.value ="<%=addr_line4%>";
					parent.frames[0].document.forms[0].res_town_code.value			= "<%=res_town_code%>";
					parent.frames[0].document.forms[0].res_area_code.value				 = "<%=res_area_code%>";
					parent.frames[0].document.forms[0].postal_code.value					 = "<%=postal_code%>";
					parent.frames[0].document.forms[0].r_postal_code_desc.value					 = "<%=postal_desc%>";
					parent.frames[0].document.forms[0].region_code.value					 = "<%=region_code%>";
					parent.frames[0].document.forms[0].country_code.value				 = "<%=country_code%>";

					parent.frames[0].document.forms[0].mail_addr_line1.value			 = "<%=mail_addr_line1%>";
					parent.frames[0].document.forms[0].mail_addr_line2.value			 = "<%=mail_addr_line2%>";
					parent.frames[0].document.forms[0].mail_addr_line3.value			 = "<%=mail_addr_line3%>";
					parent.frames[0].document.forms[0].mail_addr_line4.value			 = "<%=mail_addr_line4%>";
					parent.frames[0].document.forms[0].mail_res_town_code.value	 = "<%=mail_res_town_code%>";
					parent.frames[0].document.forms[0].mail_res_area_code.value	 = "<%=mail_res_area_code%>";
					parent.frames[0].document.forms[0].mail_postal_code.value	     = "<%=mail_postal_code%>";
					parent.frames[0].document.forms[0].m_postal_code_desc.value	     = "<%=mail_postal_desc%>";
					parent.frames[0].document.forms[0].mail_region_code.value		 = "<%=mail_region_code%>";
					parent.frames[0].document.forms[0].mail_country_code.value		 = "<%=mail_country_code%>";
					parent.frames[0].document.forms[0].contact1_no.value = "<%=contact1_no%>";
					parent.frames[0].document.forms[0].contact2_no.value = "<%=contact2_no%>";
					parent.frames[0].document.forms[0].email.value = "<%=email_id%>";
					parent.frames[0].document.forms[0].res_town_desc.value = "<%=res_town_desc%>";
					parent.frames[0].document.forms[0].res_area_desc.value = "<%=res_area_desc%>";
					parent.frames[0].document.forms[0].region_desc.value = "<%=region_desc%>";
					parent.frames[0].document.forms[0].mail_res_town_desc.value = "<%=mail_res_town_desc%>";
					parent.frames[0].document.forms[0].mail_res_area_desc.value = "<%=mail_res_area_desc%>";
					parent.frames[0].document.forms[0].mail_region_desc.value = "<%=mail_region_desc%>";
					parent.frames[0].document.forms[0].country_desc.value = "<%=country1_desc%>";
					parent.frames[0].document.forms[0].mail_country_desc.value = "<%=country2_desc%>";
					/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
					parent.frames[0].document.forms[0].alt_addr_line1.value		= "<%=alt_addr_line1%>";
					parent.frames[0].document.forms[0].alt_addr_line2.value		= "<%=alt_addr_line2%>";
					parent.frames[0].document.forms[0].alt_addr_line3.value		= "<%=alt_addr_line3%>";
					parent.frames[0].document.forms[0].alt_addr_line4.value		= "<%=alt_addr_line4%>";
					parent.frames[0].document.forms[0].alt_area_code.value		= "<%=alt_area_code%>";
					parent.frames[0].document.forms[0].alt_area_desc.value		= "<%=alt_area_desc%>";
					parent.frames[0].document.forms[0].alt_town_code.value		= "<%=alt_town_code%>";
					parent.frames[0].document.forms[0].alt_town_desc.value		= "<%=alt_town_desc%>";
					parent.frames[0].document.forms[0].alt_postal_code.value	= "<%=alt_postal_code%>";
					parent.frames[0].document.forms[0].alt_postal_desc.value	= "<%=alt_postal_desc%>";
					parent.frames[0].document.forms[0].alt_region_code.value	= "<%=alt_region_code%>";
					parent.frames[0].document.forms[0].alt_region_desc.value	= "<%=alt_region_desc%>";
					parent.frames[0].document.forms[0].alt_country_code.value	= "<%=alt_country_code%>";
					parent.frames[0].document.forms[0].alt_country_desc.value	= "<%=alt_country_desc%>";
					/*End*/

					if("<%=citizen_yn%>"=="Y"){
					parent.frames[0].document.forms[0].citizen_yn[0].value="<%=citizen_yn%>";
					parent.frames[0].document.forms[0].citizen_yn[0].checked=true;
					}
					else{
					parent.frames[0].document.forms[0].citizen_yn[1].value="<%=citizen_yn%>";
					parent.frames[0].document.forms[0].citizen_yn[1].checked=true;
					}

					if("<%=legal_illegal_yn%>"=="Y"){
					parent.frames[0].document.forms[0].legal_yn[0].value="<%=legal_illegal_yn%>";
					parent.frames[0].document.forms[0].legal_yn[0].checked=true;
					}
					else{ 
					parent.frames[0].document.forms[0].legal_yn[1].value="<%=legal_illegal_yn%>";
					parent.frames[0].document.forms[0].legal_yn[1].checked=true;
					}
					parent.frames[0].document.forms[0].race_code.value="<%=race_code%>";
					parent.frames[0].document.forms[0].race_desc.value="<%=race_desc%>";
					parent.frames[0].document.forms[0].ethnic_group.value = "<%=ethnic_grp_code%>";
					if("<%=ethnic_grp_code%>"!="")
					{
						popEthnicSubGroup("<%=ethnic_grp_code%>","<%=ethnic_grp_desc%>");
					} 
					
					
					if("<%=oth_alt_type%>"!="")
					{
						popOth_alt_type("<%=oth_alt_type%>","<%=oth_alt_id_type_desc%>");				if("<%=oth_alt_Id%>"!="")
							parent.frames[0].document.forms[0].other_alt_Id.value='<%=oth_alt_Id%>';
					}
					
					var patient_id = "<%=patientid%>";
		
					if (patient_id!="")
					{
						disableItems()				
						parent.frames[0].document.forms[0].patient_id.readOnly=true;
					}
				}
			</script>
		<%
		}
		%>
			<script>
			
				if(parent.frames[1].document.getElementById("p_calling_function") != null && parent.frames[1].document.getElementById("p_calling_function").value == "CHG_REG_DTLS" ) 
				{					
					if(parent.frames[0].document.forms[0].patient_id.readOnly==true)
					{
						parent.frames[0].document.forms[0].patient_id.readOnly=false;
						parent.frames[0].document.forms[0].patient_id.value ="<%=patientid%>";
						parent.frames[0].document.forms[0].patient_id.readOnly=true;
					}
					else
					{
						parent.frames[0].document.forms[0].patient_id.value ="<%=patientid%>";						
						
					}
				}
              /*Below Line Added by Senthil for this incident[33096]*/				
				if(parent.frames[1].document.getElementById("p_calling_function")){
					//condition modified for the incident - ML-BRU-SCF-0946 [IN:041858] - IP_ADMIT, OP_REG_VISIT, AE_REGISTER_ATTN and IP_BOOKING included
				if(parent.frames[1].document.getElementById("p_calling_function") != null && parent.frames[1].document.getElementById("p_calling_function").value == "CHG_ADM_DTLS" || 
						parent.frames[1].document.getElementById("p_calling_function").value == "OA_BOOK_APPT" || parent.frames[1].document.getElementById("p_calling_function").value == "OA_MODIFY_APPT"|| 
						parent.frames[1].document.getElementById("p_calling_function").value == "REV_VISIT_DTLS" || parent.frames[1].document.getElementById("p_calling_function").value == "CHG_REG_DTLS" || 
						parent.frames[1].document.getElementById("p_calling_function").value == "IP_ADMIT" || parent.frames[1].document.getElementById("p_calling_function").value == "OP_REG_VISIT" ||
						parent.frames[1].document.getElementById("p_calling_function").value == "AE_REGISTER_ATTN" || parent.frames[1].document.getElementById("p_calling_function").value == "IP_BOOKING") {
               		parent.frames[0].document.forms[0].patient_id.value ="<%=patientid%>";						
						if(parent.frames[0].document.forms[0].patient_id != null && parent.frames[0].document.forms[0].patient_id.value != ''){			parent.frames[0].document.forms[0].patient_id.onblur();
								parent.frames[0].document.forms[0].patient_id.disabled = true;
								parent.frames[0].document.forms[0].search.disabled = true;
						}
				}
				}
			
				if(parent.frames[0].document.forms[0].patient_id != null)
				{	
					if(parent.frames[0].document.forms[0].patient_id.disabled==false)
					{
						//parent.frames[0].document.forms[0].patient_id.focus();  // re-open 13835
						if(parent.frames[0].document.forms[0].patient_id1)
						parent.frames[0].document.forms[0].patient_id1.blur();
					
					}
				}
				if(parent.frames[1].document.getElementById('ca_patient_id')) {
					if(parent.frames[1].document.getElementById('ca_patient_id').value !="")
					{
						parent.frames[0].document.forms[0].patient_id.value ="<%=patientid%>";
						//parent.frames[0].document.forms[0].patient_id.readOnly=true;
						//parent.frames[0].document.forms[0].patient_id.focus();
						parent.frames[0].document.forms[0].patient_id.disabled = true;
						parent.frames[0].document.forms[0].patient_id.onblur();
					}
				}
			</script>
				<%
		if(mode.equals("modify"))
		 {
		 %><script>currentTab = "rejfrom_tab";</script>
		 <%}else{%><script>currentTab = "reffrom_tab";</script>
		  <%}

		}catch(Exception e)
		{
			out.println("Exception in main Nat ID="+e);
			e.printStackTrace();
		}
		finally
		{
			try{	
			if(mod_rs!=null)	mod_rs.close();
			if(pstmt != null) pstmt.close();
			}catch(Exception ee){
			ee.printStackTrace();
			}

			ConnectionManager.returnConnection(con,request);
		}
		%> 
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
%>
</html>


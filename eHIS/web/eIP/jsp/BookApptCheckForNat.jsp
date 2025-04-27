<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8"  import = "webbeans.eCommon.*,java.sql.*"%>
<html>
<head>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eIP/js/Booking.js' language='javascript'></script>
<script src='../../eIP/js/Booking1.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function nationalidvalues()
{
	var HTMLVal1 = new String();
	var natid1=nat_id_val.value;
	setTimeout('nat()',0);
}

function nat() 
{
	HTMLVal1 = "<HTML><BODY onKeyDown='lockKey()'><form name='form2' id='form2' method='post' action='../jsp/BookAppointmentValues.jsp'><input name='nat_id' id='nat_id' type='hidden' value='"+nat_id_val.value+"'><input type='hidden' name='step' id='step' value='N'></form></BODY></HTML>";
	parent.document.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal1);
	parent.document.frames[2].document.form2.submit();

}

</script>
<body bgcolor='#B2B6D7' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
	Connection			con		= null;
	Statement			stmt	= null;
	ResultSet			rs		= null;
	PreparedStatement	pstmt1	= null;
	ResultSet			rs1		= null;
	ResultSet			rset		= null;
	try
	{
		con = ConnectionManager.getConnection(request);
		String function = request.getParameter("step");
		String ser_code = "";
		String ser_desc = "";
		if(function.equals("first"))
		{
			String patid			= "";
			String altid1no			= "";
			String altid1expdate	= "";
			String altid2no			= "";
			String altid2expdate	= "";
			String altid3no			= "";
			String altid3expdate	= "";
			String altid4no			= "";
			String altid4expdate	= "";
			String oth_alt_id_type	= "";
			String oth_alt_id_no	= "";
			String national_id_no	= "";
			String addr_line1		= "";
			String addr_line2		= "";
			String addr_line3		= "";
			String addr_line4		= "";
			String contact1_no		= "";
			String contact2_no		= "";
			String emailid			= "";
			String postalcode		= "";
		    String postal_desc      = "";
			String countrycode		= "";
			String countryDesc		= "";
			String res_town_code	= "";
			String res_town_desc	= "";
			String res_area_code	= "";
			String res_area_desc	= "";
			String res_region_code	= "";
			String res_region_desc	= "";
			String mail_addr_line1	= "";
			String mail_addr_line2	= "";
			String mail_addr_line3	= "";
			String mail_addr_line4	= "";
			String mail_town_code	= "";
			String mail_town_desc	= "";
			String mail_area_code	= "";
			String mail_area_desc	= "";
			String mail_region_code	= "";
			String mail_region_desc	= "";
			String mail_postal_code	= "";
			String mail_postal_desc	= "";
			String mail_country_code= "";
			String mail_country_desc= "";
			String patient_class	= "";
			/*Added by Thamizh selvi on 14th Feb 2018 against ML-MMOH-CRF-0601 Start*/
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
		String referralid = request.getParameter("referral_id");
		stmt=con.createStatement();
		StringBuffer bookSql = new StringBuffer();
		bookSql.append("select PATIENT_ID,TO_PRACT_ID, am_get_desc.am_practitioner(TO_PRACT_ID, '"+localeName+"', 1) TO_FCY_PRACT_NAME,");
		//bookSql.append(" TO_SPECIALITY_CODE, AM_GET_DESC.AM_SPECIALITY(TO_SPECIALITY_CODE,'"+localeName+"','2') TO_SPECIALITY_DESC, NAME_PREFIX,");
		bookSql.append(" TO_SPECIALITY_CODE, AM_GET_DESC.AM_SPECIALITY(TO_SPECIALITY_CODE,'"+localeName+"','2') TO_SPECIALITY_DESC, NAME_PREFIX,NAME_PREFIX_LOC_LANG,");
		//bookSql.append("FIRST_NAME, SECOND_NAME, THIRD_NAME, FAMILY_NAME, ");
		bookSql.append("FIRST_NAME,FIRST_NAME_LOC_LANG, SECOND_NAME,SECOND_NAME_LOC_LANG, THIRD_NAME,THIRD_NAME_LOC_LANG, FAMILY_NAME, FAMILY_NAME_LOC_LANG,");
		//bookSql.append("NAME_SUFFIX, decode('"+localeName+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))PATIENT_NAME, SEX, ");
		bookSql.append("NAME_SUFFIX,NAME_SUFFIX_LOC_LANG, decode('"+localeName+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))PATIENT_NAME, SEX, ");
		bookSql.append("to_char(DATE_OF_BIRTH,'dd/mm/rrrr') DATE_OF_BIRTH, ");
		bookSql.append("to_char(Nvl(PREFERRED_TREATMENT_DATE, ");
		bookSql.append(" REFERRAL_DATE),'dd/mm/rrrr')|| ' ' || ");
		bookSql.append(" to_char(sysdate,'hh24:mi')");
		bookSql.append("REFERRAL_DATE,calculate_age");
		bookSql.append("(to_char(DATE_OF_BIRTH,'dd/mm/rrrr'),1) years,");
		bookSql.append(" calculate_age(to_char(DATE_OF_BIRTH,'dd/mm/rrrr'),2)");
		bookSql.append("months,");
		bookSql.append("calculate_age(to_char(DATE_OF_BIRTH,'dd/mm/rrrr'),3)");
		bookSql.append("days, NATIONALITY_CODE, MP_GET_DESC.MP_COUNTRY(nationality_code,'"+localeName+"','1') NATIONALITY,  ADDR_LINE1,");
		bookSql.append("ADDR_LINE2, ADDR_LINE3, ADDR_LINE4, REGION_CODE,");
		bookSql.append("MP_GET_DESC.MP_REGION(REGION_CODE,'"+localeName+"','1') REGION_DESC,  RES_AREA_CODE, MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+localeName+"','1') RES_AREA_DESC, ");
		bookSql.append("RES_TOWN_CODE, MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+localeName+"','1') RES_TOWN_DESC, POSTAL_CODE,  MP_GET_DESC.MP_POSTAL_CODE(POSTAL_CODE,'"+localeName+"','2') POSTAL_DESC,");
		bookSql.append("COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(COUNTRY_CODE,'"+localeName+"','1') COUNTRY_NAME, CONTACT1_NO, CONTACT2_NO, ");
		bookSql.append("EMAIL_ID,  NATIONAL_ID_NO, ALT_ID1_TYPE, ALT_ID1_NO,");
		bookSql.append("to_char(ALT_ID1_DATE,'dd/mm/rrrr') ALT_ID1_DATE,");
		bookSql.append("ALT_ID2_TYPE, ALT_ID2_NO,"); bookSql.append("to_char(ALT_ID2_DATE,'dd/mm/rrrr')ALT_ID2_DATE, ");
		bookSql.append("ALT_ID3_TYPE, ALT_ID3_NO, ");
		bookSql.append("to_char(ALT_ID3_DATE,'dd/mm/rrrr')ALT_ID3_DATE, ");
		bookSql.append("ALT_ID4_TYPE, ALT_ID4_NO,  ");
		bookSql.append("to_char(ALT_ID4_DATE,'dd/mm/rrrr')ALT_ID4_DATE,");
		bookSql.append("OTH_ALT_ID_TYPE, OTH_ALT_ID_NO, MAIL_ADDR_LINE1, ");
		bookSql.append("MAIL_ADDR_LINE2, MAIL_ADDR_LINE3, MAIL_ADDR_LINE4, ");
		bookSql.append("MAIL_REGION_CODE, MP_GET_DESC.MP_REGION(MAIL_REGION_CODE,'"+localeName+"','1')  MAIL_REGION_DESC, ");
		bookSql.append("MAIL_RES_AREA_CODE, MP_GET_DESC.MP_RES_AREA(MAIL_RES_AREA_CODE,'"+localeName+"','1') MAIL_AREA_DESC, MAIL_RES_TOWN_CODE,");
		//bookSql.append("MP_GET_DESC.MP_RES_TOWN(MAIL_RES_TOWN_CODE,'"+localeName+"','1') MAIL_RES_TOWN_DESC,MAIL_POSTAL_CODE, MAIL_POSTAL_DESC,");
		bookSql.append("MP_GET_DESC.MP_RES_TOWN(MAIL_RES_TOWN_CODE,'"+localeName+"','1') MAIL_RES_TOWN_DESC,MAIL_POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(MAIL_POSTAL_CODE,'"+localeName+"','2') MAIL_POSTAL_DESC , ");
		bookSql.append("MAIL_COUNTRY_CODE, MP_GET_DESC.MP_COUNTRY(MAIL_COUNTRY_CODE,'"+localeName+"','1') MAIL_COUNTRY_NAME, CITIZEN_YN,  ");
		/*Added by Thamizh selvi on 14th Feb 2018 against ML-MMOH-CRF-0601 Start*/
		bookSql.append("  alt_addr_line1" );
		bookSql.append("  , alt_addr_line2" );
		bookSql.append("  , alt_addr_line3" );
		bookSql.append("  , alt_addr_line4" );
		bookSql.append("  , alt_town_code" );
		bookSql.append("  , mp_get_desc.MP_RES_TOWN(alt_town_code,'"+localeName+"','1') alt_town_desc" );
		bookSql.append("  , alt_area_code" );
		bookSql.append("  , mp_get_desc.MP_RES_AREA(alt_area_code,'"+localeName+"','1') alt_area_desc" );
		bookSql.append("  , alt_region_code" );
		bookSql.append("  , mp_get_desc.MP_REGION(alt_region_code,'"+localeName+"','1') alt_region_desc" );
		bookSql.append("  , alt_postal_code" );
		bookSql.append("  , mp_get_desc.MP_POSTAL_CODE(alt_postal_code,'"+localeName+"',2) alt_postal_desc" );
		bookSql.append("  , alt_country_code" );
		bookSql.append("  , mp_get_desc.MP_COUNTRY(alt_country_code,'"+localeName+"','1') alt_country_desc, " );
		/*End*/
		bookSql.append("LEGAL_ILLEGAL_YN, RACE_CODE, MP_GET_DESC.MP_RACE(RACE_CODE,'"+localeName+"','1') RACE_DESC, ETHNIC_GRP_CODE,");
		bookSql.append(" MP_GET_DESC.MP_ETHNIC_GROUP(ETHNIC_GRP_CODE,'"+localeName+"','1') ETHNIC_GROUP_DESC, BIRTH_PLACE_CODE, MP_GET_DESC.MP_BIRTH_PLACE(BIRTH_PLACE_CODE,'"+localeName+"','1') BIRTH_PLACE_DESC,");
		bookSql.append("BIRTH_PLACE_DESCRIPTION, TO_LOCN_TYPE, FROM_REF_CODE, FROM_REF_TYPE, TO_NURS_UNIT_CODE, IP_GET_DESC.IP_NURSING_UNIT(TO_FACILITY_ID, TO_NURS_UNIT_CODE,'"+localeName+"','2') TO_NURS_UNIT_DESC, TO_SERVICE_CODE, AM_GET_DESC.AM_SERVICE(TO_SERVICE_CODE,'"+localeName+"','2') TO_SERVICE_DESC from ");
		bookSql.append("PR_REFERRAL_REGISTER_VW a where referral_id = ");
		bookSql.append("'"+referralid+"' ");
		
		//out.println("<script>alert(\""+bookSql.toString()+"\");</script>");

		rs=stmt.executeQuery(bookSql.toString());
		
		if( rs != null && rs.next())
		{
			patid = checkForNull(rs.getString("PATIENT_ID"));
			String patient_name		= checkForNull(rs.getString("PATIENT_NAME"));		
			String pract_id			= checkForNull(rs.getString("TO_PRACT_ID"));
			String pract_desc		= checkForNull(rs.getString("TO_FCY_PRACT_NAME"));
			String specialty_code	= checkForNull(rs.getString("TO_SPECIALITY_CODE"));
			String specialty_desc	= checkForNull(rs.getString("TO_SPECIALITY_DESC"));
			String nurs_unit_code	= checkForNull(rs.getString("TO_NURS_UNIT_CODE"));
			String nurs_unit_desc	= checkForNull(rs.getString("TO_NURS_UNIT_DESC"));
			String service_code		= checkForNull(rs.getString("TO_SERVICE_CODE"));
			String date_of_birth	= checkForNull(rs.getString("DATE_OF_BIRTH"));
			String birth_place_code = checkForNull(rs.getString("BIRTH_PLACE_CODE"));
			String birth_place_desc = checkForNull(rs.getString("BIRTH_PLACE_DESC"));
			String bp_desc			= checkForNull(rs.getString("BIRTH_PLACE_DESCRIPTION"));
			String eth_grp_code		= checkForNull(rs.getString("ETHNIC_GRP_CODE"));
			String eth_grp_desc		= checkForNull(rs.getString("ETHNIC_GROUP_DESC"));
			String race_code		= checkForNull(rs.getString("race_code"));
			String race_desc		= checkForNull(rs.getString("RACE_DESC"));// Uncommented by Dharma on 15th Dec 2014 against HSA-SCF-0046.1 [IN:052933]
			String nationality_code	= checkForNull(rs.getString("NATIONALITY_CODE"));
			String nationality_desc = checkForNull(rs.getString("NATIONALITY"));
			String name_prefix		= checkForNull(rs.getString("NAME_PREFIX"));
			String name_suffix		= checkForNull(rs.getString("NAME_SUFFIX"));
			String first_name		= checkForNull(rs.getString("FIRST_NAME"));
			String second_name		= checkForNull(rs.getString("SECOND_NAME"));
			String third_name		= checkForNull(rs.getString("THIRD_NAME"));
			String family_name		= checkForNull(rs.getString("FAMILY_NAME"));
			String referral_date	= checkForNull(rs.getString("REFERRAL_DATE"));
			String from_ref_code	= checkForNull(rs.getString("FROM_REF_CODE"));
			String from_ref_type	= checkForNull(rs.getString("FROM_REF_TYPE"));
			String citizen_yn		= checkForNull(rs.getString("CITIZEN_YN"));
			String legal_yn			= checkForNull(rs.getString("LEGAL_ILLEGAL_YN"));
			String locale_lang_name_prefix		= checkForNull(rs.getString("NAME_PREFIX_LOC_LANG"));
			String locale_lang_name_suffix		= checkForNull(rs.getString("NAME_SUFFIX_LOC_LANG"));
			String locale_lang_first_name		= checkForNull(rs.getString("FIRST_NAME_LOC_LANG"));
			String locale_lang_second_name		= checkForNull(rs.getString("SECOND_NAME_LOC_LANG"));
			String locale_lang_third_name		= checkForNull(rs.getString("THIRD_NAME_LOC_LANG"));
			String locale_lang_family_name		= checkForNull(rs.getString("FAMILY_NAME_LOC_LANG"));

			addr_line1		= checkForNull(rs.getString("ADDR_LINE1"));
			addr_line2		= checkForNull(rs.getString("ADDR_LINE2"));
			addr_line3		= checkForNull(rs.getString("ADDR_LINE3"));
			addr_line4		= checkForNull(rs.getString("ADDR_LINE4"));
			contact1_no		= checkForNull(rs.getString("CONTACT1_NO"));
			contact2_no		= checkForNull(rs.getString("CONTACT2_NO"));
			emailid			= checkForNull(rs.getString("EMAIL_ID"));
			postalcode		= checkForNull(rs.getString("POSTAL_CODE"));
			postal_desc		= checkForNull(rs.getString("POSTAL_DESC"));
			countrycode		= checkForNull(rs.getString("COUNTRY_CODE"));
			countryDesc		= checkForNull(rs.getString("COUNTRY_NAME"));
			res_town_code	= checkForNull(rs.getString("RES_TOWN_CODE"));
			res_town_desc	= checkForNull(rs.getString("RES_TOWN_DESC"));
			res_area_code	= checkForNull(rs.getString("RES_AREA_CODE"));
			res_area_desc	= checkForNull(rs.getString("RES_AREA_DESC"));
			res_region_code	= checkForNull(rs.getString("REGION_CODE"));
			res_region_desc	= checkForNull(rs.getString("REGION_DESC"));
			mail_addr_line1	= checkForNull(rs.getString("MAIL_ADDR_LINE1"));
			mail_addr_line2	= checkForNull(rs.getString("MAIL_ADDR_LINE2"));
			mail_addr_line3	= checkForNull(rs.getString("MAIL_ADDR_LINE3"));
			mail_addr_line4	= checkForNull(rs.getString("MAIL_ADDR_LINE4"));
			mail_town_code	= checkForNull(rs.getString("MAIL_RES_TOWN_CODE"));
			mail_town_desc	= checkForNull(rs.getString("MAIL_RES_TOWN_DESC"));
			mail_area_code	= checkForNull(rs.getString("MAIL_RES_AREA_CODE"));
			mail_area_desc	= checkForNull(rs.getString("MAIL_AREA_DESC"));
			mail_region_code= checkForNull(rs.getString("MAIL_REGION_CODE"));
			mail_region_desc= checkForNull(rs.getString("MAIL_REGION_DESC"));
			mail_postal_code= checkForNull(rs.getString("MAIL_POSTAL_CODE"));
			mail_postal_desc= checkForNull(rs.getString("MAIL_POSTAL_DESC"));
			mail_country_code= checkForNull(rs.getString("MAIL_COUNTRY_CODE"));
			mail_country_desc= checkForNull(rs.getString("MAIL_COUNTRY_NAME"));
			patient_class		= checkForNull(rs.getString("TO_LOCN_TYPE"));
			altid1no			= checkForNull(rs.getString("ALT_ID1_NO"));
			altid1expdate		= checkForNull(rs.getString("ALT_ID1_DATE"));
			altid2no			= checkForNull(rs.getString("ALT_ID2_NO"));
			altid2expdate		= checkForNull(rs.getString("ALT_ID2_DATE"));
			altid3no			= checkForNull(rs.getString("ALT_ID3_NO"));
			altid3expdate		= checkForNull(rs.getString("ALT_ID3_DATE"));
			altid4no			= checkForNull(rs.getString("ALT_ID4_NO"));
			altid4expdate		= checkForNull(rs.getString("ALT_ID4_DATE"));
			oth_alt_id_type		= checkForNull(rs.getString("OTH_ALT_ID_TYPE"));
			oth_alt_id_no		= checkForNull(rs.getString("OTH_ALT_ID_NO"));
			national_id_no		= checkForNull(rs.getString("NATIONAL_ID_NO"));
			/*Added by Thamizh selvi on 14th Feb 2018 against ML-MMOH-CRF-0601 Start*/
			alt_addr_line1		= checkForNull(rs.getString("alt_addr_line1"));
			alt_addr_line2		= checkForNull(rs.getString("alt_addr_line2"));
			alt_addr_line3		= checkForNull(rs.getString("alt_addr_line3"));
			alt_addr_line4		= checkForNull(rs.getString("alt_addr_line4"));
			alt_area_code		= checkForNull(rs.getString("alt_area_code"));
			alt_area_desc		= checkForNull(rs.getString("alt_area_desc"));
			alt_town_code		= checkForNull(rs.getString("alt_town_code"));
			alt_town_desc		= checkForNull(rs.getString("alt_town_desc"));
			alt_region_code		= checkForNull(rs.getString("alt_region_code"));
			alt_region_desc		= checkForNull(rs.getString("alt_region_desc"));
			alt_postal_code		= checkForNull(rs.getString("alt_postal_code"));
			alt_postal_desc		= checkForNull(rs.getString("alt_postal_desc"));
			alt_country_code	= checkForNull(rs.getString("alt_country_code"));
			alt_country_desc	= checkForNull(rs.getString("alt_country_desc"));
			/*End*/

			if(patient_class.equals("D"))
				patient_class = "DC";
			else
				patient_class = "IP";
			
			String facilityId = (String)session.getValue("facility_id"); %>

			<script>
				parent.f_query_add_mod.document.forms[0].team_id.disabled = false;
				/*Below condtion Added for this incident  [IN:043737]*/
				if('<%=patid%>'!="")parent.f_query_add_mod.document.forms[0].patient_id.value ="<%=patid%>";	
				
				
				parent.f_query_add_mod.document.forms[0].patient_id.onblur();/*16586*/				
				parent.f_query_add_mod.document.forms[0].search.disabled = true;
				parent.f_query_add_mod.document.forms[0].patient_id.disabled=true;

				parent.f_query_add_mod.document.forms[0].Splcode_desc.value ="<%= specialty_desc%>";
				parent.f_query_add_mod.document.forms[0].Splcode_desc_hid.value ="<%= specialty_desc%>";
				parent.f_query_add_mod.document.forms[0].Splcode.value="<%=specialty_code%>";
				
				if(parent.f_query_add_mod.document.forms[0].nursing_unit != null)
					parent.f_query_add_mod.document.forms[0].nursing_unit_desc.value="<%=nurs_unit_desc%>";

				parent.f_query_add_mod.document.forms[0].nursing_unit.value="<%=nurs_unit_code%>";
				parent.f_query_add_mod.document.forms[0].service_code.value="<%=service_code%>";
				
				if(parent.f_query_add_mod.document.forms[0].service_code != null)
				{
				<%		
					String Sql= " select service_code, short_desc from AM_SERVICE_LANG_VW where language_id = '"+localeName+"' and Service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code = '"+nurs_unit_code+"') ";
					stmt = con.createStatement();
					rset = stmt.executeQuery(Sql);
					if(rset!=null )
					{
						while (rset.next())
						{	
							ser_code = checkForNull(rset.getString("service_code"));
							ser_desc = checkForNull(rset.getString("short_desc"));
							%>		
								var opt = parent.f_query_add_mod.document.createElement('Option');
								opt.text="<%=ser_desc%>";
								opt.value="<%=ser_code%>";
								if(opt.value == "<%=service_code%>")     
									opt.selected = true;
								var obj = parent.f_query_add_mod.document.forms[0].service_desc;
								obj.add(opt);
					<%	}
					}	%>
				}
				parent.f_query_add_mod.document.forms[0].practid_desc.value = "<%=pract_desc%>";
				parent.f_query_add_mod.document.forms[0].practid_desc_hid.value = "<%=pract_desc%>";
				parent.f_query_add_mod.document.forms[0].practid.value = "<%=pract_id%>";
				/*Thursday, January 21, 2010 , modified for 18385 since passing patient class to app_pat_class hidden variable .*/
				//parent.f_query_add_mod.document.forms[0].app_pat_class.value = "<%=patient_class%>";
							
				if(parent.f_query_add_mod.document.forms[0].alt_id1_no != null)
				{
					parent.f_query_add_mod.document.forms[0].alt_id1_no.value = "<%=altid1no%>";
					parent.f_query_add_mod.document.forms[0].alt_id1_no.disabled = true;
				}
				
				if(parent.f_query_add_mod.document.forms[0].alt_id1_exp_date != null)	
					parent.f_query_add_mod.document.forms[0].alt_id1_exp_date.value = "<%=altid1expdate%>";

				if(parent.f_query_add_mod.document.forms[0].alt_id2_no != null)
				{
					parent.f_query_add_mod.document.forms[0].alt_id2_no.value = "<%=altid2no%>";
					parent.f_query_add_mod.document.forms[0].alt_id2_no.disabled = true;
				}
				if(parent.f_query_add_mod.document.forms[0].alt_id2_exp_date != null)	
					parent.f_query_add_mod.document.forms[0].alt_id2_exp_date.value = "<%=altid2expdate%>";
					
				if(parent.f_query_add_mod.document.forms[0].alt_id3_no != null)
				{			
					parent.f_query_add_mod.document.forms[0].alt_id3_no.value = "<%=altid3no%>";
					parent.f_query_add_mod.document.forms[0].alt_id3_no.disabled = true;
				}
				if(parent.f_query_add_mod.document.forms[0].alt_id3_exp_date != null)	
					parent.f_query_add_mod.document.forms[0].alt_id3_exp_date.value = "<%=altid3expdate%>";
				
				if(parent.f_query_add_mod.document.forms[0].alt_id4_no != null)
				{
					parent.f_query_add_mod.document.forms[0].alt_id4_no.value = "<%=altid4no%>";
					parent.f_query_add_mod.document.forms[0].alt_id4_no.disabled = true;
				}
				if(parent.f_query_add_mod.document.forms[0].alt_id4_exp_date != null)	
					parent.f_query_add_mod.document.forms[0].alt_id4_exp_date.value = "<%=altid4expdate%>";

				if(parent.f_query_add_mod.document.forms[0].other_alt_Id != null)
				{
					parent.f_query_add_mod.document.forms[0].other_alt_Id.value = "<%=oth_alt_id_no%>";
					parent.f_query_add_mod.document.forms[0].other_alt_Id.disabled = true;
				}
				if(parent.f_query_add_mod.document.forms[0].other_alt_type != null)	
				{
					parent.f_query_add_mod.document.forms[0].other_alt_type.value = "<%=oth_alt_id_type%>";

					parent.f_query_add_mod.document.forms[0].other_alt_type.disabled = true;

				}
				
				parent.f_query_add_mod.document.forms[0].national_id_no.value="<%=national_id_no%>";

				parent.f_query_add_mod.document.forms[0].national_id_no.disabled = true;
				parent.f_query_add_mod.document.forms[0].patient_name.value="<%=patient_name%>";
				parent.f_query_add_mod.document.forms[0].patient_name.disabled =true;	parent.f_query_add_mod.document.forms[0].date_of_birth.value="<%=date_of_birth%>";
				parent.f_query_add_mod.document.forms[0].patient_name.disabled =true;	parent.f_query_add_mod.document.forms[0].date_of_birth.value="<%=date_of_birth%>";

				parent.f_query_add_mod.document.forms[0].date_of_birth.disabled = true;
				parent.f_query_add_mod.document.forms[0].b_age.value='<%=rs.getString("years")%>';
				parent.f_query_add_mod.document.forms[0].b_months.value='<%=rs.getString("months")%>';
				parent.f_query_add_mod.document.forms[0].b_days.value='<%=rs.getString("days")%>';
				
				parent.f_query_add_mod.document.forms[0].Birth_place_code.value="<%=birth_place_code%>";
				parent.f_query_add_mod.document.forms[0].birth_place.value="<%= birth_place_desc%>";
				parent.f_query_add_mod.document.forms[0].place_of_birth.value="<%=bp_desc%>";
				parent.f_query_add_mod.document.forms[0].birth_place.disabled =true;
				parent.f_query_add_mod.document.forms[0].place_of_birth.disabled=true;
				
				parent.f_query_add_mod.document.forms[0].b_birth.disabled=true;
				parent.f_query_add_mod.document.forms[0].nationality_id.disabled=true;
	<%
		if(citizen_yn.equals("Y")) { %>
	 
			parent.f_query_add_mod.document.forms[0].citizen_yn[0].checked = true;
			parent.f_query_add_mod.document.forms[0].citizen.value = "Y";
			//parent.f_query_add_mod.document.forms[0].eth_gif.style.visibility= "visible";
	<%	}else{%>		 
			//parent.f_query_add_mod.document.forms[0].eth_gif.style.visibility= "hidden";
			parent.f_query_add_mod.document.forms[0].citizen_yn[1].checked = true;
			parent.f_query_add_mod.document.forms[0].citizen.value = "N";			 
		<%}%>
		parent.f_query_add_mod.document.forms[0].citizen_yn[0].disabled=true;
		parent.f_query_add_mod.document.forms[0].citizen_yn[1].disabled=true;
		
	<%	if(legal_yn.equals("Y")) { %>
			parent.f_query_add_mod.document.forms[0].legal_yn[0].checked = true;
			parent.f_query_add_mod.document.forms[0].legal.value = "Y";
		<% }else { %>
			parent.f_query_add_mod.document.forms[0].legal_yn[1].checked = true;
			parent.f_query_add_mod.document.forms[0].legal.value = "N";
		<%}%>
		parent.f_query_add_mod.document.forms[0].legal_yn[0].disabled=true;
		parent.f_query_add_mod.document.forms[0].legal_yn[1].disabled=true;
		
			parent.f_query_add_mod.document.forms[0].race_code.value = "<%= race_code%>";
			parent.f_query_add_mod.document.forms[0].race_desc.disabled = true;
		    parent.f_query_add_mod.document.forms[0].race_desc_id.disabled = true;
			/*Added by Dharma on 15th Dec 2014 against HSA-SCF-0046.1 [IN:052933] Start*/
			if(parent.f_query_add_mod.document.forms[0].race_code.value!="")
				parent.f_query_add_mod.document.forms[0].race_desc.value	= "<%=race_desc%>"
			/*Added by Dharma on 15th Dec 2014 against HSA-SCF-0046.1 [IN:052933] End*/
		<%
			if((!race_code.equals(""))&&(eth_grp_code.equals("")))
			{
				
				String sql = "select ethnic_group_code, long_desc from mp_ethnic_group_lang_vw where race_code = '"+race_code+"' and language_id = '"+localeName+"' order by 2";
				pstmt1 = con.prepareStatement(sql) ;
				rs1      = pstmt1.executeQuery() ;
				%>
				var obj = parent.f_query_add_mod.document.forms[0].ethnic_group;
				for(i=0;i<obj.length;i++)
				obj.remove(1);
				<%while(rs1.next())
				{
				%>

				var opt = parent.f_query_add_mod.document.createElement('Option');
				opt.text = "<%=rs1.getString(2)%>";
				opt.value = "<%=rs1.getString(1)%>";
				obj.add(opt);
		<%}

			}
			%>
		<%if(!eth_grp_code.equals("")){%>
			var obj = parent.f_query_add_mod.document.forms[0].ethnic_group;
				for(i=0;i<obj.length;i++)
				obj.remove(1);
			var opt = parent.f_query_add_mod.document.createElement('Option');
			opt.value = "<%= eth_grp_code%>";
			opt.text  = "<%= eth_grp_desc%>";
			obj.add(opt);
			opt.selected = true;
			obj.disabled = true;
		<%}else{
					%>
      parent.f_query_add_mod.document.forms[0].ethnic_group.disabled=true;
	<% } %>
					//Commented on 10-10-2004 for disabling the race and ethnicity if the values are there.	
		
		//added on 24-09-2003 by dhanasekaran
		parent.f_query_add_mod.document.getElementById('dob').disabled=true;

		
		parent.f_query_add_mod.document.forms[0].b_age.disabled=true;
		parent.f_query_add_mod.document.forms[0].b_months.disabled=true;
		parent.f_query_add_mod.document.forms[0].b_days.disabled=true;

		parent.f_query_add_mod.document.forms[0].nationality_code1.value = "<%=nationality_code%>";

		parent.f_query_add_mod.document.forms[0].nationality_desc.value= "<%= nationality_desc%>";
		parent.f_query_add_mod.document.forms[0].nationality_desc.disabled = true;
		
					if(parent.f_query_add_mod.document.forms[0].name_prefix1!=null)
					{
						p = parent.f_query_add_mod.document.forms[0].name_prefix1.options;
						for (i=0; i<p.options.length; i++) {
							if(p.options[i].value == "<%=name_prefix%>")
								p.options[i].selected = true;
						}
						parent.f_query_add_mod.document.forms[0].name_prefix1.disabled=true;
					}

					if(parent.f_query_add_mod.document.forms[0].name_prefix!=null)
					{
						p = parent.f_query_add_mod.document.forms[0].name_prefix.options;
						for (i=0; i<p.options.length; i++) {
							if(p.options[i].value == "<%=name_prefix%>")
								p.options[i].selected = true;
						}
						parent.f_query_add_mod.document.forms[0].name_prefix.disabled=true;
					}
				
				
					if(parent.f_query_add_mod.document.forms[0].name_suffix1!=null)
					{
						p = parent.f_query_add_mod.document.forms[0].name_suffix1.options;
						for (i=0; i<p.options.length; i++) {
							if(p.options[i].value == "<%=name_suffix%>")
								p.options[i].selected = true;
						}
						parent.f_query_add_mod.document.forms[0].name_suffix1.disabled=true;
					}

					if(parent.f_query_add_mod.document.forms[0].name_suffix!=null)
					{
						p = parent.f_query_add_mod.document.forms[0].name_suffix.options;
						for (i=0; i<p.options.length; i++) {
							if(p.options[i].value == "<%=name_suffix%>")
								p.options[i].selected = true;
						}
						parent.f_query_add_mod.document.forms[0].name_suffix.disabled=true;
					}
				
					p = parent.f_query_add_mod.document.forms[0].sex.options;
					for (i=0; i<p.options.length; i++) {
						if(p.options[i].value == '<%=rs.getString("SEX")%>')
							p.options[i].selected = true;
					}
					parent.f_query_add_mod.document.forms[0].sex.disabled=true;

					if(parent.f_query_add_mod.document.forms[0].first_name!=null)
					{
						parent.f_query_add_mod.document.forms[0].first_name.value = "<%=first_name%>";
						parent.f_query_add_mod.document.forms[0].first_name.disabled =true;
					}
			
					if(parent.f_query_add_mod.document.forms[0].second_name!=null)
					{
						parent.f_query_add_mod.document.forms[0].second_name.value = "<%=second_name%>";
						parent.f_query_add_mod.document.forms[0].second_name.disabled = true;
					}
			
					if(parent.f_query_add_mod.document.forms[0].third_name!=null)
					{
						parent.f_query_add_mod.document.forms[0].third_name.value = "<%=third_name%>";
						parent.f_query_add_mod.document.forms[0].third_name.disabled = true;
					}
			
					if(parent.f_query_add_mod.document.forms[0].family_name!=null)
					{
						parent.f_query_add_mod.document.forms[0].family_name.value = "<%=family_name%>";
						parent.f_query_add_mod.document.forms[0].family_name.disabled = true;
					}
			
					
					if(parent.f_query_add_mod.document.forms[0].name_prefix_oth_lang!=null)
					{
						p = parent.f_query_add_mod.document.forms[0].name_prefix_oth_lang.options;
						for (i=0; i<p.options.length; i++) {
							if(p.options[i].value == "<%=locale_lang_name_prefix%>")
								p.options[i].selected = true;
						}
						parent.f_query_add_mod.document.forms[0].name_prefix_oth_lang.disabled=true;
					}

					if(parent.f_query_add_mod.document.forms[0].name_suffix_oth_lang!=null)
					{
						p = parent.f_query_add_mod.document.forms[0].name_suffix_oth_lang.options;
						for (i=0; i<p.options.length; i++) {
							if(p.options[i].value == "<%=locale_lang_name_suffix%>")
								p.options[i].selected = true;
						}
						parent.f_query_add_mod.document.forms[0].name_suffix_oth_lang.disabled=true;
					}


					if(parent.f_query_add_mod.document.forms[0].first_name_oth_lang!=null)
					{
						parent.f_query_add_mod.document.forms[0].first_name_oth_lang.value = "<%=locale_lang_first_name%>";
						parent.f_query_add_mod.document.forms[0].first_name_oth_lang.disabled =true;
					}
			
					if(parent.f_query_add_mod.document.forms[0].second_name_oth_lang!=null)
					{
						parent.f_query_add_mod.document.forms[0].second_name_oth_lang.value = "<%=locale_lang_second_name%>";
						parent.f_query_add_mod.document.forms[0].second_name_oth_lang.disabled = true;
					}
			
					if(parent.f_query_add_mod.document.forms[0].third_name_oth_lang!=null)
					{
						parent.f_query_add_mod.document.forms[0].third_name_oth_lang.value = "<%=locale_lang_third_name%>";
						parent.f_query_add_mod.document.forms[0].third_name_oth_lang.disabled = true;
					}
			
					if(parent.f_query_add_mod.document.forms[0].family_name_oth_lang!=null)
					{
						parent.f_query_add_mod.document.forms[0].family_name_oth_lang.value = "<%=locale_lang_family_name%>";
						parent.f_query_add_mod.document.forms[0].family_name_oth_lang.disabled = true;
					}
			
									
					if(parent.f_query_add_mod.document.forms[0].pref_adm_date!=null)
					{
						if(parent.f_query_add_mod.document.forms[0].pref_adm_date.value =='')
						{
						parent.f_query_add_mod.document.forms[0].pref_adm_date.value = "<%=referral_date%>";
						}
					}
				
				parent.f_query_add_mod.document.forms[0].source_type.value = "<%= from_ref_type%>";

				parent.f_query_add_mod.document.forms[0].source.value = "<%= from_ref_code%>";

				parent.f_query_add_mod.document.forms[0].addr_line1.value = "<%= addr_line1%>";
				parent.f_query_add_mod.document.forms[0].addr_line2.value="<%= addr_line2%>";
				parent.f_query_add_mod.document.forms[0].addr_line3. value="<%= addr_line3%>";
				parent.f_query_add_mod.document.forms[0].addr_line4. value="<%= addr_line4%>" ;
				parent.f_query_add_mod.document.forms[0].res_town_code. value="<%= res_town_code%>" ;
				parent.f_query_add_mod.document.forms[0].res_town_desc. value="<%= res_town_desc%>" ;
				parent.f_query_add_mod.document.forms[0].res_area_code. value="<%= res_area_code%>";
				parent.f_query_add_mod.document.forms[0].res_area_desc. value="<%= res_area_desc%>";
				parent.f_query_add_mod.document.forms[0].postal_code.value="<%= postalcode%>";	
				parent.f_query_add_mod.document.forms[0].r_postal_code_desc.value="<%= postal_desc%>";	
				parent.f_query_add_mod.document.forms[0].region_code.value="<%= res_region_code%>";	
				parent.f_query_add_mod.document.forms[0].region_desc.value="<%= res_region_desc%>";	
				parent.f_query_add_mod.document.forms[0].country_code.value="<%= countrycode%>";
				parent.f_query_add_mod.document.forms[0].country_desc.value="<%= countryDesc%>";
				parent.f_query_add_mod.document.forms[0].mail_addr_line1. value="<%= mail_addr_line1%>";
				parent.f_query_add_mod.document.forms[0].mail_addr_line2. value="<%= mail_addr_line2%>";
				parent.f_query_add_mod.document.forms[0].mail_addr_line3. value="<%= mail_addr_line3%>";
				parent.f_query_add_mod.document.forms[0].mail_addr_line4. value="<%= mail_addr_line4%>" ;
				parent.f_query_add_mod.document.forms[0].mail_res_town_code. value="<%= mail_town_code%>" ;
				parent.f_query_add_mod.document.forms[0].mail_res_town_desc. value="<%= mail_town_desc%>";
				parent.f_query_add_mod.document.forms[0].mail_res_area_code. value="<%= mail_area_code%>"; 
				parent.f_query_add_mod.document.forms[0].mail_res_area_desc. value="<%= mail_area_desc%>"; 
				parent.f_query_add_mod.document.forms[0].mail_postal_code. value="<%= mail_postal_code%>"; 
				parent.f_query_add_mod.document.forms[0].m_postal_code_desc.value="<%= mail_postal_desc%>";	
			
				parent.f_query_add_mod.document.forms[0].mail_region_code. value="<%= mail_region_code%>"; 
				parent.f_query_add_mod.document.forms[0].mail_region_desc. value="<%= mail_region_desc%>"; 
				parent.f_query_add_mod.document.forms[0].mail_country_code. value="<%= mail_country_code%>"; 
				parent.f_query_add_mod.document.forms[0].mail_country_desc. value="<%= mail_country_desc%>"; 
				parent.f_query_add_mod.document.forms[0].contact1_no.value="<%= contact1_no%>";
				parent.f_query_add_mod.document.forms[0].contact2_no.value="<%= contact2_no%>";
				parent.f_query_add_mod.document.forms[0].email.value="<%= emailid%>"; 
				parent.f_query_add_mod.document.forms[0].pref_adm_date.focus();
				/*Added by Thamizh selvi on 14th Feb 2018 against ML-MMOH-CRF-0601 Start*/
				parent.f_query_add_mod.document.forms[0].alt_addr_line1.value	= "<%=alt_addr_line1%>";
				parent.f_query_add_mod.document.forms[0].alt_addr_line2.value	= "<%=alt_addr_line2%>";
				parent.f_query_add_mod.document.forms[0].alt_addr_line3.value	= "<%=alt_addr_line3%>";
				parent.f_query_add_mod.document.forms[0].alt_addr_line4.value	= "<%=alt_addr_line4%>";
				parent.f_query_add_mod.document.forms[0].alt_town_code.value	= "<%=alt_town_code%>";
				parent.f_query_add_mod.document.forms[0].alt_town_desc.value	= "<%=alt_town_desc%>";
				parent.f_query_add_mod.document.forms[0].alt_area_code.value	= "<%=alt_area_code%>";
				parent.f_query_add_mod.document.forms[0].alt_area_desc.value	= "<%=alt_area_desc%>";
				parent.f_query_add_mod.document.forms[0].alt_postal_desc.value	= "<%=alt_postal_desc%>";
				parent.f_query_add_mod.document.forms[0].alt_postal_code.value	= "<%=alt_postal_code%>";
				parent.f_query_add_mod.document.forms[0].alt_region_code.value	= "<%=alt_region_code%>";
				parent.f_query_add_mod.document.forms[0].alt_region_desc.value	= "<%=alt_region_desc%>";
				parent.f_query_add_mod.document.forms[0].alt_country_code.value	= "<%=alt_country_code%>";
				parent.f_query_add_mod.document.forms[0].alt_country_desc.value	= "<%=alt_country_desc%>";
				/*End*/
				//parent.f_query_add_mod.PopulateService();
				/*IN016586*/
				setTimeout('parent.f_query_add_mod.PopulateService();',100);
	</script>

<%	try{
			if(!pract_id.equals(""))
			{
				if(bookSql.length()>0) bookSql.delete(0,bookSql.length());
				bookSql.append("select a.short_desc short_desc, a.team_id team_id, b.practitioner_id from 	");
				bookSql.append(" am_medical_team_lang_Vw a, am_pract_for_team b where");
				bookSql.append(" a.facility_id ='"+facilityId+"' and a.facility_id = b.facility_id 		");
				bookSql.append(" and b.practitioner_id ='"+pract_id+"' and a.speciality_code = '"+specialty_code+"' and b.team_id=a.team_id and a.appl_for_ip_yn = 'Y' and language_id = '"+localeName+"' order by 1");
				String team_id = "";
				String team_desc=""; 
				
			%>
				<script>
				var obj =parent.f_query_add_mod.document.forms[0].team_id;
				var length  = obj.length;
				for(i=0;i<length;i++) {obj.remove(1);}


			<%	if(rs1 != null) rs1.close();
				rs1=stmt.executeQuery(bookSql.toString());
				if( rs1 != null)
				if(rs1.next())
				{
					team_id = rs1.getString("team_id");
					team_desc = rs1.getString("short_desc");
				%>
					
					var 
					element = parent.frames[1].document.createElement('OPTION');
					element.text = "<%=team_desc%>";
					element.value= "<%=team_id%>";
					parent.f_query_add_mod.document.forms[0].team_id.add(element);
					
				<%}%>
					 
				</script>
			<%}
		}catch(Exception z) {
			
			z.printStackTrace();
		}
			%>
				<script>	
					HTMLVal1 = "<HTML><BODY onKeyDown='lockKey()'><form name='form2' id='form2' method='post' action='../jsp/BookAppointmentValues.jsp'><input name='pat_id1' id='pat_id1' type='hidden' value='<%=patid%>'><input type='hidden' name='step' id='step' value='P'></form></BODY></HTML>";
					parent.document.frames[2].document.body.insertAdjacentHTML('afterbegin', HTMLVal1);
					parent.document.frames[2].document.form2.submit();
				</script>
			<%	
		}
		else
		{	%>
			<script>
				alert(getMessage("INV_REF_ID","IP")); 
				parent.f_query_add_mod.document.forms[0].referral_id.focus();
			</script>
			<%
		}
		if(rs!=null)    rs.close(); 
		if(stmt!=null)  stmt.close();
	}
	else if(function.equals("second"))
	{
	String national_id_no = request.getParameter("national_id_no");
	
	%>
	<html>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<input type='hidden' name='nat_id_val' id='nat_id_val' value="<%=national_id_no%>">
	
	<%
	stmt=con.createStatement();
	String sql="select 1 from mp_patient where national_id_no ='"+national_id_no+"'";
	rs=stmt.executeQuery(sql);
	rs.next();
	String result = rs.getString(1);
	
	
	if (result.equals("1"))
	{%>
	<script language='javascript'> nationalidvalues();</script>
	<%}
	else
	{	%>
			<script language='javascript'>
			parent.f_query_add_mod.window.alert(getMessage('INVALID_NAT_ID','MP'));
			parent.f_query_add_mod.document.getElementById("national_id").focus();
			</script>
			<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%	}
}
}catch(Exception e){e.printStackTrace();}
finally
{
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	if(rs1 != null) rs1.close();
	if (pstmt1 != null) pstmt1.close();
	ConnectionManager.returnConnection(con,request);
}

%>
</head>

</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
%>


<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,,webbeans.eCommon.ConnectionManager" %> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<title></title>
    <link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/DateUtils.js" language="JavaScript"></Script> <!-- added by mujafar for KDAH-CRF-370.1  -->
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>   
    <script  src='../../eMP/js/PatientRegistration1.js' language='javascript'></script>
    <script  src='../../eMP/js/RapidRegn.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
        String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		request.setCharacterEncoding("UTF-8");
        String params = request.getQueryString() ;
        String source = url + params ;
		
		String facilityId = (String) session.getValue("facility_id");
		String locale			= (String)session.getAttribute("LOCALE");
        Connection con = ConnectionManager.getConnection(request);
        java.sql.PreparedStatement pstmt = null ;
		ResultSet rset=null;

        try
        {
		   //Below line added for ML-MMOH-CRF-0887.1
		   String meessageframeSize="50";
		   Boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");	
		   if(increasedaddressLength) meessageframeSize="38";
		   //End ML-MMOH-CRF-0887.1
		 
			String sqlQuery = "";
			String dflt_pat_ser_grp_type = "" ;
			String alt_id1_type = "" ;
			String nat_id_prompt = "" ;
			String parameters = "" ;
			String patient_id_length = "" ;
			String names_in_oth_lang_yn = "" ;
			String accept_national_id_no_yn = "";
			String photo_file_name = "";
			String serverdate = "";		
			String alt_id1_unique_yn = "";
			String alt_id2_unique_yn = "";
			String alt_id3_unique_yn = "";
			String alt_id4_unique_yn = "";
			String dflt_grp = "";
			String default_race_code = "";
			String family_no_link_yn = "";
			String name_dervn_logic = "";
			String citizen_nationality_code = "";	
			String create_file_at_pat_regn_yn ="";			
			String maintain_doc_or_file ="";
			String alt_id4_desc ="";
			String alt_id3_desc ="";
			String alt_id2_desc ="";
			String alt_id1_desc ="";
			String nat_data_source_id ="";
			String ext_system_interface_yn ="";
			String accept_oth_alt_id_yn ="";
			String name_dervn_logic_oth_lang ="";
			String altdfltpsg ="";
			String max_patient_age ="";
			String nat_id_accept_alphanumeric_yn ="";
			String alt_id1_accept_oth_pat_ser_yn ="";
			String alt_id1_accept_alphanumeric_yn ="";

			/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start */
			String alt_id2_accept_oth_pat_ser_yn		= "";
			String alt_id2_accept_alphanumeric_yn		= "";
			String alt_id3_accept_oth_pat_ser_yn		= "";
			String alt_id3_accept_alphanumeric_yn		= "";
			String alt_id4_accept_oth_pat_ser_yn		= "";
			String alt_id4_accept_alphanumeric_yn		= "";
			/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End */





			int cntSeries = 0 ;
			int cntPatSeries = 0 ;
			int cntLang = 0 ;
			//alt_id2_accept_alphanumeric_yn, alt_id3_accept_alphanumeric_yn, alt_id4_accept_alphanumeric_yn, alt_id2_accept_oth_pat_ser_yn, alt_id3_accept_oth_pat_ser_yn, alt_id4_accept_oth_pat_ser_yn added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772]

			//sqlQuery = "SELECT dflt_pat_ser_grp_type,NVL(alt_id1_type,'Alt ID No')alt_id1_type,NVL(nat_id_prompt,'National ID No')nat_id_prompt,patient_id_length,family_no_link_yn,name_dervn_logic, citizen_nationality_code,default_race_code,                    DECODE(dflt_pat_ser_grp_type,'N',nat_id_pat_ser_grp,'A',alt_id_pat_ser_grp,'G',gen_pat_ser_grp) dflt_grp, NVL(alt_id1_unique_yn,'N') alt_id1_unique_yn, NVL(alt_id2_unique_yn,'N') alt_id2_unique_yn, NVL(alt_id3_unique_yn,'N') alt_id3_unique_yn,  NVL(alt_id4_unique_yn,'N') alt_id4_unique_yn,TO_CHAR(SYSDATE,'dd/mm/yyyy') serverdate,TO_CHAR(SYSDATE,'ddmmyyyyhhmmss') photo_file_name, accept_national_id_no_yn,nat_id_accept_alphanumeric_yn,alt_id1_accept_oth_pat_ser_yn,			alt_id1_accept_alphanumeric_yn, max_patient_age,NVL(alt_id_pat_ser_grp,'') altdfltpsg,name_dervn_logic_oth_lang, accept_oth_alt_id_yn,ext_system_interface_yn, nat_data_source_id,	mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id1_type,?,'1') alt_id1_desc,  mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,?,'1') alt_id2_desc,	mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id3_type,?,'1') alt_id3_desc, mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id4_type,?,'1') alt_id4_desc,maintain_doc_or_file, create_file_at_pat_regn_yn , names_in_oth_lang_yn,(select count(1) from mp_pat_ser_grp where id_type not in ('R', 'X')) cntSeries,(SELECT COUNT (1) FROM mp_pat_ser_grp WHERE (id_type NOT IN ('R', 'X') AND gen_pat_id_yn = 'Y' AND (pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM mp_pat_ser_facility WHERE site_or_facility_id = DECODE (site_or_facility,'S',(select site_id from sm_site_param), 'F',? )))) OR gen_pat_id_yn = 'N') cntPatSeries,(select count(*) from sm_language where language_direction='R' and eff_status='E') cntLang FROM mp_param WHERE module_id = 'MP' ";


			sqlQuery = "SELECT dflt_pat_ser_grp_type,NVL(alt_id1_type,'Alt ID No')alt_id1_type,NVL(nat_id_prompt,'National ID No')nat_id_prompt,patient_id_length,family_no_link_yn,name_dervn_logic, citizen_nationality_code,default_race_code,                    DECODE(dflt_pat_ser_grp_type,'N',nat_id_pat_ser_grp,'A',alt_id_pat_ser_grp,'G',gen_pat_ser_grp) dflt_grp, NVL(alt_id1_unique_yn,'N') alt_id1_unique_yn, NVL(alt_id2_unique_yn,'N') alt_id2_unique_yn, NVL(alt_id3_unique_yn,'N') alt_id3_unique_yn,  NVL(alt_id4_unique_yn,'N') alt_id4_unique_yn,TO_CHAR(SYSDATE,'dd/mm/yyyy') serverdate,TO_CHAR(SYSDATE,'ddmmyyyyhhmmss') photo_file_name, accept_national_id_no_yn,nat_id_accept_alphanumeric_yn,alt_id1_accept_oth_pat_ser_yn,			alt_id1_accept_alphanumeric_yn, max_patient_age,NVL(alt_id_pat_ser_grp,'') altdfltpsg,name_dervn_logic_oth_lang, accept_oth_alt_id_yn,ext_system_interface_yn, nat_data_source_id,	mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id1_type,?,'1') alt_id1_desc,  mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,?,'1') alt_id2_desc,	mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id3_type,?,'1') alt_id3_desc, mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id4_type,?,'1') alt_id4_desc,maintain_doc_or_file, create_file_at_pat_regn_yn , names_in_oth_lang_yn,(select count(1) from mp_pat_ser_grp where id_type not in ('R', 'X')) cntSeries,(SELECT COUNT (1) FROM mp_pat_ser_grp WHERE (id_type NOT IN ('R', 'X') AND gen_pat_id_yn = 'Y' AND (pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM mp_pat_ser_facility WHERE site_or_facility_id = DECODE (site_or_facility,'S',(select site_id from sm_site_param), 'F',? )))) OR gen_pat_id_yn = 'N') cntPatSeries,(select count(*) from sm_language where language_direction='R' and eff_status='E') cntLang,alt_id2_accept_alphanumeric_yn, alt_id3_accept_alphanumeric_yn, alt_id4_accept_alphanumeric_yn, alt_id2_accept_oth_pat_ser_yn, alt_id3_accept_oth_pat_ser_yn, alt_id4_accept_oth_pat_ser_yn FROM mp_param WHERE module_id = 'MP' ";
			
			pstmt = con.prepareStatement(sqlQuery);			
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,facilityId);
            rset = pstmt.executeQuery() ;
            if(rset.next())
            {							
				create_file_at_pat_regn_yn = checkForNull(rset.getString("create_file_at_pat_regn_yn"));
				maintain_doc_or_file = checkForNull(rset.getString("maintain_doc_or_file"));
				alt_id4_desc = checkForNull(rset.getString("alt_id4_desc"));
				alt_id3_desc = checkForNull(rset.getString("alt_id3_desc"));
				alt_id2_desc = checkForNull(rset.getString("alt_id2_desc"));
				alt_id1_desc = checkForNull(rset.getString("alt_id1_desc"));
				nat_data_source_id = checkForNull(rset.getString("nat_data_source_id"));
				ext_system_interface_yn = checkForNull(rset.getString("ext_system_interface_yn"));
				accept_oth_alt_id_yn = checkForNull(rset.getString("accept_oth_alt_id_yn"));
				name_dervn_logic_oth_lang = checkForNull(rset.getString("name_dervn_logic_oth_lang"));
				altdfltpsg = checkForNull(rset.getString("altdfltpsg"));
				max_patient_age = checkForNull(rset.getString("max_patient_age"));
				alt_id1_accept_alphanumeric_yn = checkForNull(rset.getString("alt_id1_accept_alphanumeric_yn"));
				alt_id1_accept_oth_pat_ser_yn = checkForNull(rset.getString("alt_id1_accept_oth_pat_ser_yn"));
				nat_id_accept_alphanumeric_yn = checkForNull(rset.getString("nat_id_accept_alphanumeric_yn"));


				/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start */
				alt_id2_accept_oth_pat_ser_yn			= checkForNull(rset.getString("alt_id2_accept_oth_pat_ser_yn"),"N");
				alt_id2_accept_alphanumeric_yn			= checkForNull(rset.getString("alt_id2_accept_alphanumeric_yn"),"N");
				alt_id3_accept_oth_pat_ser_yn			= checkForNull(rset.getString("alt_id3_accept_oth_pat_ser_yn"),"N");
				alt_id3_accept_alphanumeric_yn			= checkForNull(rset.getString("alt_id3_accept_alphanumeric_yn"),"N");
				alt_id4_accept_oth_pat_ser_yn			= checkForNull(rset.getString("alt_id4_accept_oth_pat_ser_yn"),"N");
				alt_id4_accept_alphanumeric_yn			= checkForNull(rset.getString("alt_id4_accept_alphanumeric_yn"),"N");
				/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End */


				accept_national_id_no_yn = checkForNull(rset.getString("accept_national_id_no_yn"));
				photo_file_name = checkForNull(rset.getString("photo_file_name"));
				serverdate = checkForNull(rset.getString("serverdate"));
				
				alt_id4_unique_yn = checkForNull(rset.getString("alt_id4_unique_yn"));
				alt_id3_unique_yn = checkForNull(rset.getString("alt_id3_unique_yn"));
				alt_id2_unique_yn = checkForNull(rset.getString("alt_id2_unique_yn"));
				alt_id1_unique_yn = checkForNull(rset.getString("alt_id1_unique_yn"));
				dflt_grp = checkForNull(rset.getString("dflt_grp"));
				default_race_code = checkForNull(rset.getString("default_race_code"));
				citizen_nationality_code = checkForNull(rset.getString("citizen_nationality_code"));
				name_dervn_logic = checkForNull(rset.getString("name_dervn_logic"));
				family_no_link_yn = checkForNull(rset.getString("family_no_link_yn"));
				dflt_pat_ser_grp_type = checkForNull(rset.getString("dflt_pat_ser_grp_type"));
				alt_id1_type = checkForNull(rset.getString("alt_id1_type"));
				nat_id_prompt = checkForNull(rset.getString("nat_id_prompt"));
				names_in_oth_lang_yn = checkForNull(rset.getString("names_in_oth_lang_yn"));
				patient_id_length = checkForNull(rset.getString("patient_id_length"));
				cntSeries = rset.getInt("cntSeries");
				cntPatSeries = rset.getInt("cntPatSeries");
				cntLang = rset.getInt("cntLang");				
				
				//alt_id2_accept_alphanumeric_yn, alt_id3_accept_alphanumeric_yn, alt_id4_accept_alphanumeric_yn, alt_id2_accept_oth_pat_ser_yn, alt_id3_accept_oth_pat_ser_yn, alt_id4_accept_oth_pat_ser_yn added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772]

				//parameters = "dflt_pat_ser_grp_type="+dflt_pat_ser_grp_type+"&alt_id1_type="+alt_id1_type+"&nat_id_prompt="+java.net.URLEncoder.encode(nat_id_prompt)+"&cntSeries="+cntSeries+"&cntPatSeries="+cntPatSeries+"&patient_id_length="+patient_id_length+"&names_in_oth_lang_yn="+names_in_oth_lang_yn+"&cntLang="+cntLang+"&name_dervn_logic="+java.net.URLEncoder.encode(name_dervn_logic)+"&family_no_link_yn="+family_no_link_yn+"&citizen_nationality_code="+citizen_nationality_code+"&default_race_code="+default_race_code+"&dflt_grp="+dflt_grp+"&alt_id1_unique_yn="+alt_id1_unique_yn+"&alt_id2_unique_yn="+alt_id2_unique_yn+"&alt_id3_unique_yn="+alt_id3_unique_yn+"&alt_id4_unique_yn="+alt_id4_unique_yn+"&serverdate="+serverdate+"&photo_file_name="+photo_file_name+"&accept_national_id_no_yn="+accept_national_id_no_yn+"&nat_id_accept_alphanumeric_yn="+nat_id_accept_alphanumeric_yn+"&alt_id1_accept_oth_pat_ser_yn="+alt_id1_accept_oth_pat_ser_yn+"&alt_id1_accept_alphanumeric_yn="+alt_id1_accept_alphanumeric_yn+"&max_patient_age="+max_patient_age+"&altdfltpsg="+altdfltpsg+"&name_dervn_logic_oth_lang="+java.net.URLEncoder.encode(name_dervn_logic_oth_lang)+"&accept_oth_alt_id_yn="+accept_oth_alt_id_yn+"&ext_system_interface_yn="+ext_system_interface_yn+"&nat_data_source_id="+nat_data_source_id+"&alt_id1_desc="+java.net.URLEncoder.encode(alt_id1_desc)+"&alt_id2_desc="+java.net.URLEncoder.encode(alt_id2_desc)+"&alt_id3_desc="+java.net.URLEncoder.encode(alt_id3_desc)+"&alt_id4_desc="+java.net.URLEncoder.encode(alt_id4_desc)+"&maintain_doc_or_file="+maintain_doc_or_file+"&create_file_at_pat_regn_yn="+create_file_at_pat_regn_yn+" ";

				parameters = "dflt_pat_ser_grp_type="+dflt_pat_ser_grp_type+"&alt_id1_type="+alt_id1_type+"&nat_id_prompt="+java.net.URLEncoder.encode(nat_id_prompt)+"&cntSeries="+cntSeries+"&cntPatSeries="+cntPatSeries+"&patient_id_length="+patient_id_length+"&names_in_oth_lang_yn="+names_in_oth_lang_yn+"&cntLang="+cntLang+"&name_dervn_logic="+java.net.URLEncoder.encode(name_dervn_logic)+"&family_no_link_yn="+family_no_link_yn+"&citizen_nationality_code="+citizen_nationality_code+"&default_race_code="+default_race_code+"&dflt_grp="+dflt_grp+"&alt_id1_unique_yn="+alt_id1_unique_yn+"&alt_id2_unique_yn="+alt_id2_unique_yn+"&alt_id3_unique_yn="+alt_id3_unique_yn+"&alt_id4_unique_yn="+alt_id4_unique_yn+"&serverdate="+serverdate+"&photo_file_name="+photo_file_name+"&accept_national_id_no_yn="+accept_national_id_no_yn+"&nat_id_accept_alphanumeric_yn="+nat_id_accept_alphanumeric_yn+"&alt_id1_accept_oth_pat_ser_yn="+alt_id1_accept_oth_pat_ser_yn+"&alt_id1_accept_alphanumeric_yn="+alt_id1_accept_alphanumeric_yn+"&max_patient_age="+max_patient_age+"&altdfltpsg="+altdfltpsg+"&name_dervn_logic_oth_lang="+java.net.URLEncoder.encode(name_dervn_logic_oth_lang)+"&accept_oth_alt_id_yn="+accept_oth_alt_id_yn+"&ext_system_interface_yn="+ext_system_interface_yn+"&nat_data_source_id="+nat_data_source_id+"&alt_id1_desc="+java.net.URLEncoder.encode(alt_id1_desc)+"&alt_id2_desc="+java.net.URLEncoder.encode(alt_id2_desc)+"&alt_id3_desc="+java.net.URLEncoder.encode(alt_id3_desc)+"&alt_id4_desc="+java.net.URLEncoder.encode(alt_id4_desc)+"&maintain_doc_or_file="+maintain_doc_or_file+"&create_file_at_pat_regn_yn="+create_file_at_pat_regn_yn+"&alt_id2_accept_alphanumeric_yn="+alt_id2_accept_alphanumeric_yn+"&alt_id3_accept_alphanumeric_yn="+alt_id3_accept_alphanumeric_yn+"&alt_id4_accept_alphanumeric_yn="+alt_id4_accept_alphanumeric_yn+"&alt_id2_accept_oth_pat_ser_yn="+alt_id2_accept_oth_pat_ser_yn+"&alt_id3_accept_oth_pat_ser_yn="+alt_id3_accept_oth_pat_ser_yn+"&alt_id4_accept_oth_pat_ser_yn="+alt_id4_accept_oth_pat_ser_yn;

			//Below line modified for ML-MMOH-CRF-0887.1	
			%>
				<iframe name='commontoolbarFrame' id='commontoolbarFrame'    src='<%= source %>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
					<iframe name='f_query_add_mod' id='f_query_add_mod'   src='../../eCommon/html/blank.html' frameborder=0 style='height:83vh;width:100vw' scrolling='no'></iframe>
					<iframe name='messageFrame' id='messageFrame'      src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
				<input type = "hidden" name="parameters" id="parameters" value=<%=parameters%>>
			 <%
            }
            else
                out.println("<script>alert(parent.frames[0].getMessage('MP_PARAM_NOT_FOUND','MP'));window.location.href = '../../eCommon/jsp/dmenu.jsp'</script>") ;
        }
        catch(Exception e ){/* out.println(e); */e.printStackTrace();}
        finally
        {
			if(rset!=null) rset.close();
            if(pstmt != null)    pstmt.close() ;
            if(con!=null) ConnectionManager.returnConnection(con,request);
        }
 %>
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


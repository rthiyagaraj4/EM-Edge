<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.ConnectionManager" %> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<title><fmt:message key="eMP.EmerRegn.label" bundle="${mp_labels}"/></title>
    <link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
        <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>   
        <script language='javascript' src='../../eMP/js/EmergRegn.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

        String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
        request.setCharacterEncoding("UTF-8");
		String params = request.getQueryString() ;
        String source = url + params ;
		Connection con = ConnectionManager.getConnection(request);    
        java.sql.PreparedStatement pstmt = null ;
        ResultSet rs  = null;
 
		String facility_id = (String) session.getValue("facility_id");
		String locale			= (String)session.getAttribute("LOCALE");	
        String function_id = request.getParameter("function_id");
		int serCnt = 0;
		int countSeries = 0;
		int cntLang = 0;

		String bl_install_yn= (String) session.getValue( "bl_operational" ) ;

		if(bl_install_yn.equals("Y")) {
		%>
			 <jsp:include page="../../eBL/jsp/BLSessionValuesReset.jsp" ><jsp:param name="flush" value="true" />
			 <jsp:param name="fin_dtls_reset" value="Y" />
		     </jsp:include>
		<%
		}
        
		try
        {
		String patient_id_length = "";
		String names_in_oth_lang_yn = "";
		String parameters = "";
		String accept_national_id_no_yn			= "N";
		String nat_id_accept_alphanumeric_yn	= "N";
		String alt_id1_accept_oth_pat_ser_yn	= "N"; 
		String alt_id1_accept_alphanumeric_yn	= "N";
		String max_pat_age						= "";
		String dflt_nationality					= "";
		String default_race_code				= "";
		String gen_slno_unknown_pat_yn			= "";
		String maintain_doc_or_file			= "";
		String create_file_at_pat_regn_yn			= "";
		String Accept_oth_alt_id_yn			= "";
		String ext_system_interface_yn			= "";
		String nat_data_source_id			= "";
		String org_member_relationship_desc			= "";
		String family_org_id_accept_yn	 = "";
		String org_member_relationship_code = "";
		String entitlement_by_pat_cat_yn = "" ;
		String pat_category_reqd_yn = "" ; //Added by Suji keerthi on 04-Dec-2019 for KDAH-CRF-0522
		String name_dervn_logic = "";
		String name_drvn_logic_long = "";
		String emeg_pat_ser_grp = "";
		String alt_id1_unique_yn = "";
		String alt_id2_unique_yn = "";
		String name_dervn_logic_oth_lang = "";
		String name_dervn_logic_oth_lang_long = "";
		String dflt_grp = "";
		String alt_id1_desc = "";
		 String alt_id2_desc = "";
		 String alt_id3_desc = "";
		 String alt_id4_desc = "";
		 String gen_pat_ser_grp  = "";
		 String site_id  = "";
		/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start */
		String alt_id2_accept_oth_pat_ser_yn		= "";
		String alt_id2_accept_alphanumeric_yn		= "";
		String alt_id3_accept_oth_pat_ser_yn		= "";
		String alt_id3_accept_alphanumeric_yn		= "";
		String alt_id4_accept_oth_pat_ser_yn		= "";
		String alt_id4_accept_alphanumeric_yn		= "";
		/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End */
			
	/* added by mujafar for ML-MMOH-CRF-524.1 start */
	String alt_id1_alphanum_validate_yn = "N" ;
	String alt_id2_alphanum_validate_yn = "N" ;
	String alt_id3_alphanum_validate_yn = "N" ;
	String alt_id4_alphanum_validate_yn = "N" ;
	/* added by mujafar for ML-MMOH-CRF-524.1 end */		

		String sqlQuery = "";

		//alt_id2_accept_alphanumeric_yn, alt_id3_accept_alphanumeric_yn, alt_id4_accept_alphanumeric_yn, alt_id2_accept_oth_pat_ser_yn, alt_id3_accept_oth_pat_ser_yn, alt_id4_accept_oth_pat_ser_yn added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772]

		//sqlQuery ="SELECT patient_id_length, emeg_pat_ser_grp, name_dervn_logic, name_dervn_logic_long, name_dervn_logic_oth_lang_long,NVL (emeg_pat_ser_grp,'') dflt_grp,NVL (alt_id1_unique_yn, 'N') alt_id1_unique_yn, NVL (alt_id2_unique_yn,'N') alt_id2_unique_yn,names_in_oth_lang_yn, accept_national_id_no_yn, nat_id_accept_alphanumeric_yn, alt_id1_accept_oth_pat_ser_yn,alt_id1_accept_alphanumeric_yn, max_patient_age, name_dervn_logic_oth_lang,family_org_id_accept_yn,org_member_relationship_code,entitlement_by_pat_cat_yn,citizen_nationality_code,default_race_code, ext_system_interface_yn, nat_data_source_id, accept_oth_alt_id_yn,mp_get_desc.mp_relationship (org_member_relationship_code, 'en', 2) org_member_relationship_desc, gen_slno_unknown_pat_yn,mp_get_desc.mp_alternate_id_type (alt_id1_type,?,1) alt_id1_desc,mp_get_desc.mp_alternate_id_type (alt_id2_type,?,'1') alt_id2_desc,mp_get_desc.mp_alternate_id_type (alt_id3_type,?,'1') alt_id3_desc,mp_get_desc.mp_alternate_id_type (alt_id4_type,?,'1') alt_id4_desc, (SELECT site_id  FROM sm_site_param) site_id, gen_pat_ser_grp,maintain_doc_or_file, create_file_at_pat_regn_yn, names_in_oth_lang_yn, (SELECT COUNT (1) FROM mp_pat_ser_grp WHERE id_type IN ('E', 'U') AND id_type NOT IN ('R', 'X')) serCnt, (SELECT COUNT (1) FROM mp_pat_ser_grp WHERE id_type IN ('E', 'U') AND id_type NOT IN ('R', 'X') AND (gen_pat_id_yn = 'Y' AND (pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM mp_pat_ser_facility  WHERE site_or_facility_id = DECODE (site_or_facility,'S', (SELECT site_id  FROM sm_site_param),'F', ?))))  OR gen_pat_id_yn = 'N') countSeries,(select count(*) from sm_language where language_direction='R' and eff_status='E') cntLang FROM mp_param where module_id='MP' ";
		sqlQuery ="SELECT patient_id_length, emeg_pat_ser_grp, name_dervn_logic, name_dervn_logic_long, name_dervn_logic_oth_lang_long,NVL (emeg_pat_ser_grp,'') dflt_grp,NVL (alt_id1_unique_yn, 'N') alt_id1_unique_yn, NVL (alt_id2_unique_yn,'N') alt_id2_unique_yn,names_in_oth_lang_yn, accept_national_id_no_yn, nat_id_accept_alphanumeric_yn, alt_id1_accept_oth_pat_ser_yn,alt_id1_accept_alphanumeric_yn, max_patient_age, name_dervn_logic_oth_lang,family_org_id_accept_yn,org_member_relationship_code,entitlement_by_pat_cat_yn,pat_category_reqd_yn,citizen_nationality_code,default_race_code, ext_system_interface_yn, nat_data_source_id, accept_oth_alt_id_yn,mp_get_desc.mp_relationship (org_member_relationship_code, 'en', 2) org_member_relationship_desc, gen_slno_unknown_pat_yn,mp_get_desc.mp_alternate_id_type (alt_id1_type,?,1) alt_id1_desc,mp_get_desc.mp_alternate_id_type (alt_id2_type,?,'1') alt_id2_desc,mp_get_desc.mp_alternate_id_type (alt_id3_type,?,'1') alt_id3_desc,mp_get_desc.mp_alternate_id_type (alt_id4_type,?,'1') alt_id4_desc, (SELECT site_id  FROM sm_site_param) site_id, gen_pat_ser_grp,maintain_doc_or_file, create_file_at_pat_regn_yn, names_in_oth_lang_yn, (SELECT COUNT (1) FROM mp_pat_ser_grp WHERE id_type IN ('E', 'U') AND id_type NOT IN ('R', 'X')) serCnt, (SELECT COUNT (1) FROM mp_pat_ser_grp WHERE id_type IN ('E', 'U') AND id_type NOT IN ('R', 'X') AND (gen_pat_id_yn = 'Y' AND (pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM mp_pat_ser_facility  WHERE site_or_facility_id = DECODE (site_or_facility,'S', (SELECT site_id  FROM sm_site_param),'F', ?))))  OR gen_pat_id_yn = 'N') countSeries,(select count(*) from sm_language where language_direction='R' and eff_status='E') cntLang,alt_id2_accept_alphanumeric_yn, alt_id3_accept_alphanumeric_yn, alt_id4_accept_alphanumeric_yn, alt_id2_accept_oth_pat_ser_yn, alt_id3_accept_oth_pat_ser_yn, alt_id4_accept_oth_pat_ser_yn,alt_id1_alphanum_validate_yn, alt_id2_alphanum_validate_yn, alt_id3_alphanum_validate_yn, alt_id4_alphanum_validate_yn FROM mp_param where module_id='MP' "; 
		//modified by mujafar for ML-MMOH-CRF-524.1

		pstmt = con.prepareStatement(sqlQuery) ;
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,facility_id);		
		rs=pstmt.executeQuery();
			if(rs!=null && rs.next()) {

				patient_id_length = checkForNull(rs.getString("patient_id_length"));
				names_in_oth_lang_yn = checkForNull(rs.getString("names_in_oth_lang_yn"),"N")	;				
				accept_national_id_no_yn			= checkForNull(rs.getString("accept_national_id_no_yn"),"N");
				nat_id_accept_alphanumeric_yn	= checkForNull(rs.getString("nat_id_accept_alphanumeric_yn"),"N");
				alt_id1_accept_oth_pat_ser_yn	= checkForNull(rs.getString("alt_id1_accept_oth_pat_ser_yn"),"N");
				alt_id1_accept_alphanumeric_yn	= checkForNull(rs.getString("alt_id1_accept_alphanumeric_yn"),"N");

				/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start */
				alt_id2_accept_oth_pat_ser_yn			= checkForNull(rs.getString("alt_id2_accept_oth_pat_ser_yn"),"N");
				alt_id2_accept_alphanumeric_yn			= checkForNull(rs.getString("alt_id2_accept_alphanumeric_yn"),"N");
				alt_id3_accept_oth_pat_ser_yn			= checkForNull(rs.getString("alt_id3_accept_oth_pat_ser_yn"),"N");
				alt_id3_accept_alphanumeric_yn			= checkForNull(rs.getString("alt_id3_accept_alphanumeric_yn"),"N");
				alt_id4_accept_oth_pat_ser_yn			= checkForNull(rs.getString("alt_id4_accept_oth_pat_ser_yn"),"N");
				alt_id4_accept_alphanumeric_yn			= checkForNull(rs.getString("alt_id4_accept_alphanumeric_yn"),"N");
				/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End */

		/* added by mujafar for ML-MMOH-CRF-524.1 start */		
		alt_id1_alphanum_validate_yn = checkForNull( rs.getString("alt_id1_alphanum_validate_yn"),"N");
		alt_id2_alphanum_validate_yn = checkForNull( rs.getString("alt_id2_alphanum_validate_yn"),"N");
		alt_id3_alphanum_validate_yn = checkForNull( rs.getString("alt_id3_alphanum_validate_yn"),"N");
		alt_id4_alphanum_validate_yn = checkForNull( rs.getString("alt_id4_alphanum_validate_yn"),"N");

		/* added by mujafar for ML-MMOH-CRF-524.1 end */	

				max_pat_age							=checkForNull(rs.getString("max_patient_age"));
				dflt_nationality							= checkForNull(rs.getString("Citizen_Nationality_Code"));
				default_race_code					= checkForNull(rs.getString("default_race_code"));
				gen_slno_unknown_pat_yn			=checkForNull(rs.getString("gen_slno_unknown_pat_yn"),"N");
				maintain_doc_or_file					= checkForNull(rs.getString("maintain_doc_or_file"),"F");
				create_file_at_pat_regn_yn		= checkForNull(rs.getString("create_file_at_pat_regn_yn"),"N");
				Accept_oth_alt_id_yn				= checkForNull(rs.getString("Accept_oth_alt_id_yn"),"N");
				ext_system_interface_yn			= checkForNull(rs.getString("ext_system_interface_yn"),"N");
				nat_data_source_id			= checkForNull(rs.getString("nat_data_source_id"));
				serCnt = rs.getInt("serCnt");
				countSeries = rs.getInt("countSeries");
				cntLang = rs.getInt("cntLang");				
				family_org_id_accept_yn			= checkForNull(rs.getString("family_org_id_accept_yn"));
				org_member_relationship_code			= checkForNull(rs.getString("org_member_relationship_code"));
				entitlement_by_pat_cat_yn			= checkForNull(rs.getString("entitlement_by_pat_cat_yn"));
				pat_category_reqd_yn        = checkForNull(rs.getString("pat_category_reqd_yn")); //Added by Suji keerthi on 04-Dec-2019 for KDAH-CRF-0522
				name_dervn_logic			= checkForNull(rs.getString("name_dervn_logic"));
				alt_id1_unique_yn			= checkForNull(rs.getString("alt_id1_unique_yn"));
				alt_id2_unique_yn			= checkForNull(rs.getString("alt_id2_unique_yn"));
				name_dervn_logic_oth_lang			= checkForNull(rs.getString("name_dervn_logic_oth_lang"));				
				name_drvn_logic_long			= checkForNull(rs.getString("name_dervn_logic_long"));				
				name_dervn_logic_oth_lang_long			= checkForNull(rs.getString("name_dervn_logic_oth_lang_long"));				
				dflt_grp			= checkForNull(rs.getString("dflt_grp"));				
				emeg_pat_ser_grp			= checkForNull(rs.getString("emeg_pat_ser_grp"));				
				gen_pat_ser_grp			= checkForNull(rs.getString("gen_pat_ser_grp"));				
				alt_id1_desc			= checkForNull(rs.getString("alt_id1_desc"));			
				alt_id2_desc			= checkForNull(rs.getString("alt_id2_desc"));			
				alt_id3_desc			= checkForNull(rs.getString("alt_id3_desc"));			
				alt_id4_desc			= checkForNull(rs.getString("alt_id4_desc"));		
				site_id			= checkForNull(rs.getString("site_id"));						
				org_member_relationship_desc= checkForNull(rs.getString("org_member_relationship_desc"));				
				
				//parameters = "cntLang="+cntLang+"&patient_id_length="+patient_id_length+"&names_in_oth_lang_yn="+names_in_oth_lang_yn+"&accept_national_id_no_yn="+accept_national_id_no_yn+"&nat_id_accept_alphanumeric_yn="+nat_id_accept_alphanumeric_yn+"&alt_id1_accept_oth_pat_ser_yn="+alt_id1_accept_oth_pat_ser_yn+"&alt_id1_accept_alphanumeric_yn="+alt_id1_accept_alphanumeric_yn+"&max_pat_age="+max_pat_age+"&dflt_nationality="+dflt_nationality+"&default_race_code="+default_race_code+"&gen_slno_unknown_pat_yn="+gen_slno_unknown_pat_yn+"&maintain_doc_or_file="+maintain_doc_or_file+"&create_file_at_pat_regn_yn="+create_file_at_pat_regn_yn+"&Accept_oth_alt_id_yn="+Accept_oth_alt_id_yn+"&ext_system_interface_yn="+ext_system_interface_yn+"&nat_data_source_id="+nat_data_source_id+"&family_org_id_accept_yn="+family_org_id_accept_yn+"&org_member_relationship_code="+org_member_relationship_code+"&entitlement_by_pat_cat_yn="+entitlement_by_pat_cat_yn+"&alt_id1_unique_yn="+alt_id1_unique_yn+"&alt_id2_unique_yn="+alt_id2_unique_yn+"&dflt_grp="+dflt_grp+"&name_dervn_logic_oth_lang="+java.net.URLEncoder.encode(name_dervn_logic_oth_lang)+"&name_dervn_logic="+java.net.URLEncoder.encode(name_dervn_logic)+"&name_drvn_logic_long="+java.net.URLEncoder.encode(name_drvn_logic_long)+"&name_dervn_logic_oth_lang_long="+java.net.URLEncoder.encode(name_dervn_logic_oth_lang_long)+"&emeg_pat_ser_grp="+emeg_pat_ser_grp+"&gen_pat_ser_grp="+gen_pat_ser_grp+"&alt_id1_desc="+java.net.URLEncoder.encode(alt_id1_desc)+"&alt_id2_desc="+java.net.URLEncoder.encode(alt_id2_desc)+"&alt_id3_desc="+java.net.URLEncoder.encode(alt_id3_desc)+"&alt_id4_desc="+java.net.URLEncoder.encode(alt_id4_desc)+"&org_member_relationship_desc="+org_member_relationship_desc+"&Site="+site_id+"";


				parameters = "alt_id1_alphanum_validate_yn="+alt_id1_alphanum_validate_yn+"&alt_id2_alphanum_validate_yn="+alt_id2_alphanum_validate_yn+"&alt_id3_alphanum_validate_yn="+alt_id3_alphanum_validate_yn+"&alt_id4_alphanum_validate_yn="+alt_id4_alphanum_validate_yn+"&cntLang="+cntLang+"&patient_id_length="+patient_id_length+"&names_in_oth_lang_yn="+names_in_oth_lang_yn+"&accept_national_id_no_yn="+accept_national_id_no_yn+"&nat_id_accept_alphanumeric_yn="+nat_id_accept_alphanumeric_yn+"&alt_id1_accept_oth_pat_ser_yn="+alt_id1_accept_oth_pat_ser_yn+"&alt_id1_accept_alphanumeric_yn="+alt_id1_accept_alphanumeric_yn+"&max_pat_age="+max_pat_age+"&dflt_nationality="+dflt_nationality+"&default_race_code="+default_race_code+"&gen_slno_unknown_pat_yn="+gen_slno_unknown_pat_yn+"&maintain_doc_or_file="+maintain_doc_or_file+"&create_file_at_pat_regn_yn="+create_file_at_pat_regn_yn+"&Accept_oth_alt_id_yn="+Accept_oth_alt_id_yn+"&ext_system_interface_yn="+ext_system_interface_yn+"&nat_data_source_id="+nat_data_source_id+"&family_org_id_accept_yn="+family_org_id_accept_yn+"&org_member_relationship_code="+org_member_relationship_code+"&entitlement_by_pat_cat_yn="+entitlement_by_pat_cat_yn+"&pat_category_reqd_yn="+pat_category_reqd_yn+"&alt_id1_unique_yn="+alt_id1_unique_yn+"&alt_id2_unique_yn="+alt_id2_unique_yn+"&dflt_grp="+dflt_grp+"&name_dervn_logic_oth_lang="+java.net.URLEncoder.encode(name_dervn_logic_oth_lang)+"&name_dervn_logic="+java.net.URLEncoder.encode(name_dervn_logic)+"&name_drvn_logic_long="+java.net.URLEncoder.encode(name_drvn_logic_long)+"&name_dervn_logic_oth_lang_long="+java.net.URLEncoder.encode(name_dervn_logic_oth_lang_long)+"&emeg_pat_ser_grp="+emeg_pat_ser_grp+"&gen_pat_ser_grp="+gen_pat_ser_grp+"&alt_id1_desc="+java.net.URLEncoder.encode(alt_id1_desc)+"&alt_id2_desc="+java.net.URLEncoder.encode(alt_id2_desc)+"&alt_id3_desc="+java.net.URLEncoder.encode(alt_id3_desc)+"&alt_id4_desc="+java.net.URLEncoder.encode(alt_id4_desc)+"&org_member_relationship_desc="+org_member_relationship_desc+"&Site="+site_id+"&alt_id2_accept_alphanumeric_yn="+alt_id2_accept_alphanumeric_yn+"&alt_id3_accept_alphanumeric_yn="+alt_id3_accept_alphanumeric_yn+"&alt_id4_accept_alphanumeric_yn="+alt_id4_accept_alphanumeric_yn+"&alt_id2_accept_oth_pat_ser_yn="+alt_id2_accept_oth_pat_ser_yn+"&alt_id3_accept_oth_pat_ser_yn="+alt_id3_accept_oth_pat_ser_yn+"&alt_id4_accept_oth_pat_ser_yn="+alt_id4_accept_oth_pat_ser_yn;
				// modified by mujafar for ML-MMOH-CRF-524.1 
				
			
				if (serCnt > 0) {
					if(!function_id.equals("EM_PAT_REG")) {					
						if (countSeries > 0) {						
					%>
					<iframe name='commontoolbarFrame' id='commontoolbarFrame'    src=<%= source %> frameborder=0 scrolling='no' noresize style='height:9vh;width:100vw;border:0'></iframe>
						<iframe name='f_query_add_mod' id='f_query_add_mod'   src='../../eCommon/html/blank.html' frameborder=0 style='height:83vh;width:100vw;border:0' scrolling="no"></iframe>
						<iframe name='messageFrame' id='messageFrame'      src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:7vh;width:100vw;border:0'></iframe>
				 <%} else {
							out.println("<script>alert(getMessage('PAT_NUM_NOT_CREATED','MP'));  if (window.dialogArguments != null) { self.close(); } else { window.location.href = '../../eCommon/jsp/dmenu.jsp'}</script>") ;
					    }
					} else { 	%>
						<iframe name='commontoolbarFrame' id='commontoolbarFrame'    src="../jsp/EmergRegToolBar.jsp"  frameborder=0 scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
							<iframe name='f_query_add_mod' id='f_query_add_mod'   src="PaintEmergRegn.jsp?<%=parameters%>&<%=request.getQueryString()%>" frameborder=0 style='height:83vh;width:100vw' scrolling="no"></iframe>
							<iframe name='messageFrame' id='messageFrame'      src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:9vh;width:100vw'></iframe>
			<%	  }

				}else 	{
					out.println("<script>alert(getMessage('PAT_SER_NOT_CREATED','MP'));  if (window.dialogArguments != null) { self.close(); } else { window.location.href = '../../eCommon/jsp/dmenu.jsp'}</script>") ;
				}
			} else {			
               out.println("<script>alert(getMessage('MP_PARAM_NOT_FOUND','MP')); if (window.dialogArguments != null) { self.close(); } else { window.location.href = '../../eCommon/jsp/dmenu.jsp'}</script>") ;
			}     
			%><input type ="hidden" name = "parameters" id = "parameters" value = <%=parameters%>><%
        }
        catch(Exception e ){out.println(e);e.printStackTrace();}
        finally
        {
			if (rs!=null) rs.close();
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


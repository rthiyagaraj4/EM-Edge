<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<!--<%@ page contentType="text/html;charset=UTF-8" import="java.sql.Connection,java.io.*, java.sql.Statement, java.sql.ResultSet, java.sql.PreparedStatement, webbeans.eCommon.ConnectionManager" %> -->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String facility_id=checkForNull((String)session.getAttribute("facility_id")); //added for the incident 34901%>
<html>
    <head> 
		<%@ include file="PatientAddressLegends.jsp"%>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
        <link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
        <Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
		<Script language="JavaScript" src="../../eMP/js/SmartCard.js"></Script>
		<!--Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1-->
		<Script language="JavaScript" src="../../eMP/js/EmployeePrivilege.js"></Script>
<%
	
		if(session.getValue("smart_path")!= null) {
			if(!session.getValue("smart_path").equals(" ")){
				out.println(session.getValue("smart_path"));
			}
		}
		%>			
		<Script src="../../eMP/js/json02.js"></Script>
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>	
		<%
	
	if(session.getValue("sekure_ws_yn")!= null) {
		if(session.getValue("sekure_ws_yn").equals("Y")){
			out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>");
		}
	}
	%>
		<Script language="JavaScript"src="../../eCommon/js/DateUtils.js" ></Script>
		<Script language="JavaScript"src="../../eCommon/js/dchk.js" ></Script>
        <Script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script>
        <script language='javascript' src='../../eMP/js/RapidRegn.js'></script>
        <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></Script>
		<Script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script> 		
		<script language="javascript" src="../../eBL/js/BLClearBean.js"></script>
<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>



	
<!--Below line added for this SCF AAKH-SCF-0261-->
<script>		
function SpecialCharsChk(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-+';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
function isValidCharacter(elementRef) {   
   var regExp ="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-+";
   var checkValue = new String(elementRef.value);     
	 for (var i=0; i<checkValue.length; i++)
	 {	
		if (regExp.indexOf(checkValue.charAt(i)) == -1) {	
				var msg = getMessage("RES_MOB_NO_SPL_NOT_ALLOWED",'MP');
				elementRef.value = "";
				alert(msg);
				elementRef.focus();
				return false;		  
		}
	  
    }  
}
</script>
<!--End AAKH-SCF-0261-->
		
		
		<%
	 	
		
		Connection con						= null;
		java.sql.Statement oth_stmt		= null;
		java.sql.Statement inner_stmt	= null;
		PreparedStatement pstmt			= null;
		PreparedStatement stmt_bl		= null;
		ResultSet rs_bl					= null;
		ResultSet rset					= null;
		ResultSet rs					= null;
		ResultSet oth_rset		= null;
		PreparedStatement oth_stmt1		= null;	
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String locale			= (String)session.getAttribute("LOCALE");
		Properties p		= (java.util.Properties) session.getValue("jdbc");
       	String group		= checkForNull(request.getParameter("group"));
		String patient_id	=	checkForNull(request.getParameter("patient_id"));
		String RapidPatInfflag = checkForNull(request.getParameter("RapidPatInfflag"));
		String refrlAappt = checkForNull(request.getParameter("refrlAappt"));
		String refIDValue = checkForNull(request.getParameter("refIDValue"));
		//New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
		String country_reqd_yn="N",region_reqd_yn="N",mobile_no_reqd_yn="N";
		String country_visibility = "visibility:hidden";
		String region_visibility = "visibility:hidden";
		String mobile_no_visibility = "visibility:hidden";
		String region_prompt		= "";
		String region_appl_yn		= "";
		/*added against AMRI--CRF-0388 by Shagar*/
		String postal_cd_reqd_yn="N",area_reqd_yn="N";
		String town_reqd_yn="N";// Added by Suji keerthi on 02-Dec-2019 for KDAH-CRF-0522
		String area_code_prompt ="";
		String town_code_prompt=""; // Added by Suji keerthi on 02-Dec-2019 for KDAH-CRF-0522
		String postal_code_prompt ="";
		//Ends here

		con			= ConnectionManager.getConnection(request);
		oth_stmt	= con.createStatement();
		inner_stmt	= con.createStatement() ;
// New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar   

// Below line added for ML-MMOH-CRF-0601
Boolean alterAddressApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE"); 
Boolean finDtlsChkNationality = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","FIN_DTLS_CHK_NATIONALITY");//Added by Ashwini on 07-Sep-2018
	//Added for this CRF ML-MMOH-CRF-0860.2
	String col_span_td="2";
	Boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
	if(increasedaddressLength) col_span_td="2";
	//End this ML-MMOH-CRF-0860.2
	
	//Added for this CRF ML-MMOH-CRF-0601
	String colspantd="colspan=7";	
	if(alterAddressApplicable){
		colspantd="colspan=7";		
	}	
    	
	//End this ML-MMOH-CRF-0601

  
try
        {
			
		String sql1 = "SELECT initcap(region_prompt) region_prompt,REGION_APPL_YN,initcap(postal_code_prompt)postal_code_prompt,initcap(RES_AREA_PROMPT)area_code_prompt,initcap(RES_TOWN_PROMPT)town_code_prompt FROM sm_site_param_LANG_VW where language_id='"+locale+"' ";
			
			
						if(rs!=null) rs.close();
					    if(pstmt!=null) pstmt.close();
						pstmt = con.prepareStatement(sql1);
						rs = pstmt.executeQuery();
						
						while (rs.next()){ 
								region_prompt		= rs.getString("region_prompt");
								region_appl_yn		= rs.getString("REGION_APPL_YN");
								postal_code_prompt  = rs.getString("postal_code_prompt");
								area_code_prompt    = rs.getString("area_code_prompt");  
								town_code_prompt    = rs.getString("town_code_prompt");  //Added by Suji keerthi on 02-Dec-2019 for KDAH-CRF-0522
								
			}			if(rs!=null) rs.close();
				
			 }
			 
		catch(Exception e)
        { } // Ends here  
		String bl_install_yn = (String)session.getValue("mp_bl_oper_yn");        
		String sql								= "";
		String gen_pat_id_yn					= "N";		
        String exestr							= "";
		String alt_id	 = "";
		String alt_id2 =	"";
		String alt_id3 =	"";
		String alt_id4 ="";
		String nat_id							= "";
		String a_national_id_no					= "";	
		String dflt_pat_regn_blng_class			= "";
		String a_gender							= "";
		String sql_bl							= null;
		String dfltPSG							= "";	
		String Nationality_Code					= "";		
		String[] contact_col_names	= null;
		String[] contact_prompts	= null;
		String[] contact_fields		= null;
						

			String patient_id_length = "";
			String family_no_link_yn = "";
			String name_dervn_logic = "";
			String citizen_nationality_code = "";
			String default_race_code = "";
			String dflt_grp = "";
			String alt_id1_unique_yn = "";
			String alt_id2_unique_yn = "";
			String alt_id3_unique_yn = "";
			String alt_id4_unique_yn = "";
			String serverdate = "";
			String photo_file_name = "";
			String accept_national_id_no_yn = "";
			String nat_id_accept_alphanumeric_yn = "";
			String alt_id1_accept_oth_pat_ser_yn = "";
			String alt_id1_accept_alphanumeric_yn = "";
			String max_patient_age = "";
			String name_dervn_logic_oth_lang = "";		
			String alt_id1_desc = "";
			String alt_id2_desc = "";
			String alt_id3_desc = "";
			String alt_id4_desc = "";
			String maintain_doc_or_file = "";
			String create_file_at_pat_regn_yn = "";
			String ext_system_interface_yn = "";
			String nat_data_source_id = "";
			String altdfltpsg = "";

			String a_res_addr_line1 = "", a_res_addr_line2	= "", a_res_addr_line3	= "";
			String a_res_addr_line4 = "", a_res_area_code = "", a_res_town_code = "",a_postal_code = "",a_postal_desc="";
			String a_country_code = "", a_res_country_desc = "", a_res_region_code = "", a_res_tel_no = "";
			String a_res_area_desc = "", a_res_region_desc = "", a_mail_addr_line1 = "";
			String a_mail_addr_line2 = "", a_mail_addr_line3 = "", a_mail_addr_line4 = "";
			String a_mail_town_code	= "", a_mail_area_code	= "", a_mail_country_code = "";
			String a_mail_country_desc = "", a_mail_postal_code = "", a_mail_region_code = "",a_mail_postal_desc = "";
			String a_mail_town_desc	= "", a_mail_area_desc = "",a_mail_region_desc = "";
			String a_patient_name = "",res_contact_name = "",mail_contact_name ="",a_res_town_desc ="";

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

		int tindex			= 1;
		
		ArrayList codes = new ArrayList();
		ArrayList descs = new ArrayList();

		Object relationcode[] = null;
		Object relationdesc[] = null;

		ArrayList arrayList2 = new ArrayList();
		arrayList2 = eMP.ChangePatientDetails.getResultRows(con,"mp_name_prefix",p);
		HashMap hash_mp_param=new HashMap();
        hash_mp_param=eMP.ChangePatientDetails.getSetupData(facility_id,group,con,p);//modified for the incident 34901
		
		String family_org_id_accept_yn=checkForNull((String)hash_mp_param.get("family_org_id_accept_yn"));
		
		
		String org_member_relationship_code=checkForNull((String)hash_mp_param.get("org_member_relationship_code"));
		String org_member_relationship_desc=checkForNull((String)hash_mp_param.get("org_member_relationship_desc"));
		
		String entitlement_by_pat_cat_yn=checkForNull((String)hash_mp_param.get("entitlement_by_pat_cat_yn"));		
		//New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
		country_reqd_yn=checkForNull((String)hash_mp_param.get("COUNTRY_REQD_YN"),"N");	
		region_reqd_yn=checkForNull((String)hash_mp_param.get("REGION_REQD_YN"),"N");	
		mobile_no_reqd_yn=checkForNull((String)hash_mp_param.get("MOBILE_NO_REQD_YN"),"N");	
		//Added Against AMRI-CRF-0388 by shagar
		postal_cd_reqd_yn=checkForNull((String)hash_mp_param.get("POSTAL_CD_REQD_YN"),"N");	
		area_reqd_yn=checkForNull((String)hash_mp_param.get("AREA_REQD_YN"),"N");
		town_reqd_yn=checkForNull((String)hash_mp_param.get("TOWN_REQD_YN"),"N");
		/* added by mujafar for ML-MMOH-CRF-524.1 start */
		alt_id1_alphanum_validate_yn = checkForNull( (String)hash_mp_param.get("alt_id1_alphanum_validate_yn"),"N");
		alt_id2_alphanum_validate_yn = checkForNull( (String)hash_mp_param.get("alt_id2_alphanum_validate_yn"),"N");
		alt_id3_alphanum_validate_yn = checkForNull( (String)hash_mp_param.get("alt_id3_alphanum_validate_yn"),"N");
		alt_id4_alphanum_validate_yn = checkForNull( (String)hash_mp_param.get("alt_id4_alphanum_validate_yn"),"N");
		/* added by mujafar for ML-MMOH-CRF-524.1 start */
		//Ends here	
        try {

			String Town			= request.getParameter("Town");
			String Family_Name1 = request.getParameter("Family_Name");
			String Region		= request.getParameter("Region");
			String Area			= request.getParameter("Area");
						
			if(Town == null) Town = "";
			if(Family_Name1 == null) Family_Name1 = "";
			if(Region == null) Region = "";
			if(Area == null) Area = "";	
			
			a_gender = request.getParameter("Sex"); 
			if(a_gender == null) a_gender = "";
			if (a_gender.equals("A"))
			a_gender="";

			String AltdfltPSG	= "";

            String patient_grp	= request.getParameter("group") == null ? "" : request.getParameter("group");
			
			/*** Thee values of variable 'alt_id' i.e., Alternate ID1 which is Entered through Modal window which appears on click of Button (which is based on Parameter setup). *****/

			alt_id = request.getParameter("alt_id") == null ? "" : request.getParameter("alt_id");
			alt_id2 = request.getParameter("Alt_Id2_No") == null ? "" : request.getParameter("Alt_Id2_No");
			alt_id3 = request.getParameter("Alt_Id3_No") == null ? "" : request.getParameter("Alt_Id3_No");
			alt_id4 = request.getParameter("Alt_Id4_No") == null ? "" : request.getParameter("Alt_Id4_No");	

			a_national_id_no	= request.getParameter("National_Id_No");
			if(a_national_id_no == null || a_national_id_no.equals("null")) a_national_id_no = "";
			
			/****** Imp. Note: The sequence of retrieving nat_id param should always fallow the retrieving of a_national_id_no param value **********/	

			nat_id = request.getParameter("nat_id") == null ? "" : request.getParameter("nat_id");

			if(patient_grp.equals("N"))
			{
				/*** Thee values of variable 'nat_id' i.e., National ID which is Entered through Modal window which appears on click of Button (which is based on Parameter setup). *****/
			
				if(!nat_id.equals("")) 
				{
					a_national_id_no = nat_id;
				}
			}
			
			/****** Imp. Note2 Ends **********/		
				
			
			
			patient_id_length = request.getParameter("patient_id_length");
			family_no_link_yn = checkForNull(request.getParameter("family_no_link_yn"),"N");
			name_dervn_logic = request.getParameter("name_dervn_logic");
			citizen_nationality_code = request.getParameter("citizen_nationality_code");
			default_race_code = request.getParameter("default_race_code");
			dflt_grp = request.getParameter("dflt_grp");
			alt_id1_unique_yn = request.getParameter("alt_id1_unique_yn");
			alt_id2_unique_yn = request.getParameter("alt_id2_unique_yn");
			alt_id3_unique_yn = request.getParameter("alt_id3_unique_yn");
			alt_id4_unique_yn = request.getParameter("alt_id4_unique_yn");
			serverdate = request.getParameter("serverdate");
			photo_file_name = request.getParameter("photo_file_name");
			accept_national_id_no_yn = request.getParameter("accept_national_id_no_yn");
			nat_id_accept_alphanumeric_yn = checkForNull(request.getParameter("nat_id_accept_alphanumeric_yn"),"N");
			alt_id1_accept_oth_pat_ser_yn = checkForNull(request.getParameter("alt_id1_accept_oth_pat_ser_yn"),"N");
			alt_id1_accept_alphanumeric_yn = checkForNull(request.getParameter("alt_id1_accept_alphanumeric_yn"),"N");


			/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start */
			alt_id2_accept_oth_pat_ser_yn			= checkForNull(request.getParameter("alt_id2_accept_oth_pat_ser_yn"),"N");
			alt_id2_accept_alphanumeric_yn			= checkForNull(request.getParameter("alt_id2_accept_alphanumeric_yn"),"N");
			alt_id3_accept_oth_pat_ser_yn			= checkForNull(request.getParameter("alt_id3_accept_oth_pat_ser_yn"),"N");
			alt_id3_accept_alphanumeric_yn			= checkForNull(request.getParameter("alt_id3_accept_alphanumeric_yn"),"N");
			alt_id4_accept_oth_pat_ser_yn			= checkForNull(request.getParameter("alt_id4_accept_oth_pat_ser_yn"),"N");
			alt_id4_accept_alphanumeric_yn			= checkForNull(request.getParameter("alt_id4_accept_alphanumeric_yn"),"N");
			/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End */
		
			
			max_patient_age = request.getParameter("max_patient_age");
			altdfltpsg = request.getParameter("altdfltpsg");
			name_dervn_logic_oth_lang = request.getParameter("name_dervn_logic_oth_lang");
		
			alt_id1_desc = request.getParameter("alt_id1_desc");
			alt_id2_desc = request.getParameter("alt_id2_desc");
			alt_id3_desc = request.getParameter("alt_id3_desc");
			alt_id4_desc = request.getParameter("alt_id4_desc");
			maintain_doc_or_file =checkForNull(request.getParameter("maintain_doc_or_file"),"F");
			create_file_at_pat_regn_yn =checkForNull(request.getParameter("create_file_at_pat_regn_yn"),"N");		
			ext_system_interface_yn =checkForNull(request.getParameter("ext_system_interface_yn"),"N");
			nat_data_source_id =checkForNull(request.getParameter("nat_data_source_id"),"N");			
		
			ArrayList contact_addr = fetchContactAddresses(con, out,"parent.parent.messageFrame",p) ;
						
            
			String Site = (String) contact_addr.get(0) ;

            contact_col_names = (String[])contact_addr.get(1) ;
            contact_prompts   = (String[])contact_addr.get(2) ; 
            contact_fields    = (String[])contact_addr.get(3) ;
			contact_addr = null;
			
            
            sql= "SELECT pat_ser_grp_code,nvl(gen_pat_id_yn,'N') gen_pat_id_yn FROM mp_pat_ser_grp WHERE id_type NOT IN ('X', 'R')";
            rs = inner_stmt.executeQuery(sql);
           
            if(rs != null) {
                int k = 0;
                out.println("<script>");

                while(rs.next()) {
                    if((dflt_grp==null?"":dflt_grp).equals( (rs.getString(1) ==null? "" :rs.getString(1))  ))
						gen_pat_id_yn = (rs.getString(2) == null ?"N":rs.getString(2));
                    out.println("PSGCodeArray["+k+"]='"+rs.getString(1)+"';");
                    out.println("PSGYNArray["+k+"]='"+rs.getString(2)+"';");
                    k++;
				}
                out.println("</script>");
                
				if(rs != null) rs.close();
			}

			if(refrlAappt.equals("P"))
			{

				sql="SELECT b.PATIENT_NAME patient_name,a.addr1_line1 res_addr_line1,a.addr1_line2 res_addr_line2,a.addr1_line3 res_addr_line3,a.addr1_line4 res_addr_line4,a.res_town1_code res_town_code, mp_get_desc.MP_RES_TOWN(a.res_town1_code,'"+locale+"',1) res_town_desc,a.res_area1_code res_area_code,mp_get_desc.MP_RES_AREA(a.res_area1_code,'"+locale+"',1) res_area_desc,a.region1_code res_region_code,mp_get_desc.MP_REGION(a.region1_code,'"+locale+"',1) res_region_desc,a.postal1_code postal_code, mp_get_desc.MP_POSTAL_CODE(a.postal1_code,'"+locale+"',2) postal_desc,a.COUNTRY1_CODE res_country_code ,mp_get_desc.MP_COUNTRY(a.COUNTRY1_CODE,'"+locale+"',1) res_country_desc,a.addr2_line1 mail_addr_line1,a.addr2_line2 mail_addr_line2,a.addr2_line3 mail_addr_line3,a.addr2_line4 mail_addr_line4,a.res_town2_code mail_town_code,mp_get_desc.MP_RES_TOWN(a.res_town2_code,'"+locale+"',1) mail_town_desc,a.region2_code mail_region_code, mp_get_desc.MP_REGION(a.region2_code,'"+locale+"',1) mail_region_desc,a.res_area2_code mail_area_code, mp_get_desc.MP_RES_AREA(a.res_area2_code,'"+locale+"',1) mail_area_desc,a.postal2_code,a.COUNTRY2_CODE mail_country_code,mp_get_desc.MP_COUNTRY(a.COUNTRY2_CODE,'"+locale+"',1) mail_country_desc,postal2_code mail_postal_code, mp_get_desc.MP_POSTAL_CODE(a.postal2_code,'"+locale+"',2) mail_postal_desc,b.contact1_no res_tel_no,a.CONTACT1_NAME res_contact_name,CONTACT2_NAME mail_contact_name FROM MP_PAT_ADDRESSES a,mp_patient b WHERE b.PATIENT_ID=a.PATIENT_ID AND b.PATIENT_ID='"+refIDValue+"'";

			
			if(oth_rset!=null) oth_rset.close();
			if(oth_stmt1!=null) oth_stmt1.close();
			oth_stmt1 = con.prepareStatement(sql);
			oth_rset = oth_stmt1.executeQuery();
			
			if(oth_rset.next())
			{

				a_res_addr_line1			= 	checkForNull( oth_rset.getString("res_addr_line1") );
				a_res_addr_line2			= 	checkForNull( oth_rset.getString("res_addr_line2") );
				a_res_addr_line3			= 	checkForNull( oth_rset.getString("res_addr_line3") );
				a_res_addr_line4			= 	checkForNull( oth_rset.getString("res_addr_line4") );
				a_res_town_code			= 	checkForNull( oth_rset.getString("res_town_code") );
				a_res_town_desc			= 	checkForNull( oth_rset.getString("res_town_desc") );
				a_res_area_code			= 	checkForNull( oth_rset.getString("res_area_code") );
				a_res_area_desc			= 	checkForNull( oth_rset.getString("res_area_desc") );
				a_res_region_code		= 	checkForNull( oth_rset.getString("res_region_code") );
				a_res_region_desc			= 	checkForNull( oth_rset.getString("res_region_desc") );
				a_country_code			= 	checkForNull( oth_rset.getString("res_country_code") );
				a_res_country_desc		= 	checkForNull( oth_rset.getString("res_country_desc") );
				a_postal_code				= 	checkForNull( oth_rset.getString("postal_code") );
				a_mail_addr_line1			= 	checkForNull( oth_rset.getString("mail_addr_line1") );
				a_mail_addr_line2			= 	checkForNull( oth_rset.getString("mail_addr_line2") );
				a_mail_addr_line3			= 	checkForNull( oth_rset.getString("mail_addr_line3") );
				a_mail_addr_line4			= 	checkForNull( oth_rset.getString("mail_addr_line4") );
				a_mail_town_code			= 	checkForNull( oth_rset.getString("mail_town_code") );
				a_mail_town_desc			= 	checkForNull( oth_rset.getString("mail_town_desc") );
				a_mail_area_code			= 	checkForNull( oth_rset.getString("mail_area_code") );
				a_mail_area_desc			= 	checkForNull( oth_rset.getString("mail_area_desc") );
				a_mail_country_code		= 	checkForNull( oth_rset.getString("mail_country_code") );
				a_mail_country_desc		= 	checkForNull( oth_rset.getString("mail_country_desc") );
				a_mail_postal_code		= 	checkForNull( oth_rset.getString("mail_postal_code") );
				a_mail_region_code		= 	checkForNull( oth_rset.getString("mail_region_code") );
				a_mail_region_desc		= 	checkForNull( oth_rset.getString("mail_region_desc") );
				a_res_tel_no				= 	checkForNull( oth_rset.getString("res_tel_no") );
				a_patient_name		=	checkForNull( oth_rset.getString("patient_name") );
				res_contact_name	=	checkForNull( oth_rset.getString("res_contact_name") );
				mail_contact_name	=	checkForNull( oth_rset.getString("mail_contact_name") );
				a_postal_desc	=	checkForNull( oth_rset.getString("postal_desc") );
				a_mail_postal_desc	=	checkForNull( oth_rset.getString("mail_postal_desc") );
				
			}
			}
			%>
	        <script>
				if (parent.frames[0].document.getElementById('patient_id'))
		        parent.frames[0].document.getElementById('patient_id').maxLength = 	<%=patient_id_length%>
			</script>
	    </head>
		<!--chkNatlIdMandatory(); Added by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491]!-->
		<body onSelect="codeArrestThruSelect()" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onload='populateethnicity();chkNatlIdMandatory("onload");'>
			<form name="Rapid_Regn" id="Rapid_Regn" action="../../servlet/eMP.PatientRegistrationServlet" method="post" target="messageFrame" >
				<!-- <a name='demo'></a> -->
				<div id = 'demo' name='demo'>
				<input type='hidden' name='operation' id='operation' value='Generate_File'></input>
				<input type='hidden' name='datasource_id' id='datasource_id' value=""></input>
				<input type='hidden' name='accept_national_id_no' id='accept_national_id_no' value="<%=accept_national_id_no_yn%>">
				<input type='hidden' name='alt_id1_accept_oth_pat_ser_yn' id='alt_id1_accept_oth_pat_ser_yn' value="<%=alt_id1_accept_oth_pat_ser_yn%>">
				<input type='hidden' name='alt_id1_accept_alphanumeric_yn' id='alt_id1_accept_alphanumeric_yn' value="<%=alt_id1_accept_alphanumeric_yn%>">
				<input type='hidden' name='max_patient_age' id='max_patient_age' value="<%=max_patient_age%>">
				<input type ='hidden' name='family_org_id_accept_yn' id='family_org_id_accept_yn' value="<%=family_org_id_accept_yn%>"></input>
				<input type ='hidden' name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn' value="<%=entitlement_by_pat_cat_yn%>"></input>
				<input type ='hidden' name='org_member_relationship_code' id='org_member_relationship_code' value="<%=org_member_relationship_code%>"></input>
				<input type ='hidden' name='org_member_relationship_desc' id='org_member_relationship_desc' value="<%=org_member_relationship_desc%>"></input>

				<!--Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start -->
				<input type="hidden" name="alt_id2_accept_oth_pat_ser_yn" id="alt_id2_accept_oth_pat_ser_yn" value="<%=alt_id2_accept_oth_pat_ser_yn%>" />
				<input type="hidden" name="alt_id2_accept_alphanumeric_yn" id="alt_id2_accept_alphanumeric_yn" value="<%=alt_id2_accept_alphanumeric_yn%>" /> 

				<input type="hidden" name="alt_id3_accept_oth_pat_ser_yn" id="alt_id3_accept_oth_pat_ser_yn" value="<%=alt_id3_accept_oth_pat_ser_yn%>" /> 
				<input type="hidden" name="alt_id3_accept_alphanumeric_yn" id="alt_id3_accept_alphanumeric_yn" value="<%=alt_id3_accept_alphanumeric_yn%>" /> 

				<input type="hidden" name="alt_id4_accept_oth_pat_ser_yn" id="alt_id4_accept_oth_pat_ser_yn" value="<%=alt_id4_accept_oth_pat_ser_yn%>" /> 
				<input type="hidden" name="alt_id4_accept_alphanumeric_yn" id="alt_id4_accept_alphanumeric_yn" value="<%=alt_id4_accept_alphanumeric_yn%>" />
				<!--Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End -->
			<!-- added by mujafar for ML-MMOH-CRF-524.1 start -->
			<input type='hidden' name='alt_id1_alphanum_validate_yn' id='alt_id1_alphanum_validate_yn' value="<%=alt_id1_alphanum_validate_yn%>" >
			<input type='hidden' name='alt_id2_alphanum_validate_yn' id='alt_id2_alphanum_validate_yn' value="<%=alt_id2_alphanum_validate_yn%>">
			<input type='hidden' name='alt_id3_alphanum_validate_yn' id='alt_id3_alphanum_validate_yn' value="<%=alt_id3_alphanum_validate_yn%>">
			<input type='hidden' name='alt_id4_alphanum_validate_yn' id='alt_id4_alphanum_validate_yn' value="<%=alt_id4_alphanum_validate_yn%>">
			<!-- added by mujafar for ML-MMOH-CRF-524.1 end -->	
				<%
				dfltPSG =dflt_grp==null ? "" :dflt_grp;
				if(dfltPSG == null) dfltPSG = "";
				
				default_race_code = default_race_code  == null ? "" : default_race_code;
				
				Nationality_Code = citizen_nationality_code  == null ? "" :citizen_nationality_code;
												
				%>
				
			<script>		clearBeanForBilling();	</script>
	
				<table border="0" cellpadding="0" cellspacing="0" width="100%">					
						<jsp:include page="../../eMP/jsp/ChangePatientSubNames.jsp" ><jsp:param name="flush" value="true" />
							<jsp:param name="patient_id" value="<%=patient_id%>" />
							<jsp:param name="group" value="<%=patient_grp%>" />
							<jsp:param name="CalledFromFunction" value="RapidReg" />
							<jsp:param name="a_national_id_no" value="<%=a_national_id_no%>" />
							<jsp:param name="a_alt_id1_no" value="<%=alt_id%>" />
							<jsp:param name="a_alt_id2_no" value="<%=alt_id2%>" />
							<jsp:param name="a_alt_id3_no" value="<%=alt_id3%>" />
							<jsp:param name="a_alt_id4_no" value="<%=alt_id4%>" />
							<jsp:param name="a_gender" value="<%=a_gender%>" />
							<jsp:param name="Site" value="<%=Site%>" />
							<jsp:param name="dfltPSG" value="<%=dfltPSG%>" />
							<jsp:param name="default_race_code" value="<%=default_race_code%>" />
							<jsp:param name="a_nationality_code" value="<%=Nationality_Code%>" />
							<jsp:param name="nat_id_accept_alphanumeric_yn" value="<%=nat_id_accept_alphanumeric_yn%>" />
							<jsp:param name="RapidPatInfflag" value="<%=RapidPatInfflag%>" />
						</jsp:include>					
					<tr></tr>
				</table>	
			</div>

	<!-- <a name='misc'></a> -->
    <div id = 'misc' style = 'display:none'>

	<table width='100%' cellpadding='0' cellspacing='0' border='0'>
		<tr>
			<td>
				  <table cellpadding='0' cellspacing='0' border='0' width='100%' HEIGHT='100%'>
					   <tr>
							<td  class='COLUMNHEADER'><fmt:message key="eMP.ContactAddresses.label" bundle="${mp_labels}"/></td>

							<td  class='COLUMNHEADER' colspan='<%=col_span_td%>' ><fmt:message key="Common.residence.label" bundle="${common_labels}"/></td>
							<%if(alterAddressApplicable && increasedaddressLength){%>
                            <td  class='COLUMNHEADER' colspan='<%=col_span_td%>' ><fmt:message key="eMP.AlternateAddress.label" bundle="${mp_labels}"/></td>
							<%}if(!alterAddressApplicable && increasedaddressLength){%>
							<td  class='COLUMNHEADER' colspan='4' ><fmt:message key="eMP.mailing.label" bundle="${mp_labels}"/></td>
							 <%}		
							  if((alterAddressApplicable && increasedaddressLength) || (!alterAddressApplicable && !increasedaddressLength)){
							%>
							<td  colspan='<%=col_span_td%>' class='COLUMNHEADER'><fmt:message key="eMP.mailing.label" bundle="${mp_labels}"/></td>
							
							<%}%>
							
						</tr>
						<%
						//New Condition  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
						if(region_reqd_yn.equals("Y")){ 
										region_visibility = "visibility:visible";}
						StringBuffer sb12		= new StringBuffer();
						StringBuffer fieldVal2	= new StringBuffer();
						StringBuffer sb21		= new StringBuffer();
						StringBuffer sb121		= new StringBuffer();
						StringBuffer fieldVal21 = new StringBuffer();
						StringBuffer sbaa = new StringBuffer();
						StringBuffer sbrr = new StringBuffer();
						
						//Below line added for this CRF ML-MMOH-CRF-0601						
						//StringBuffer alt_sb = new StringBuffer();	                       
							StringBuffer sb_a = new StringBuffer();
							StringBuffer sb_ap			= new StringBuffer();
							StringBuffer sb_ar			= new StringBuffer();
							StringBuffer sb1_aa		= new StringBuffer();
                            StringBuffer fieldVal_aa	= new StringBuffer(); 							
						//End ML-MMOH-CRF-0601
						

						for(int i=0;i<contact_col_names.length; i++) {
							out.println("<tr>");
							out.println("<td class='label'  >"+contact_prompts[i]+"</td>");

							String val = contact_fields[i];
							
							String val_alt = contact_fields[i]; //Added for this CRF ML-MMOH-CRF-0601

							sb12.append(val);
							fieldVal2.append("");
							
							for(int z=0;z<val.length();z++) {
								String tempVal = sb12.substring(z,z+1);
								if(tempVal.equals("@")) {
									fieldVal2.append("50");
								}
								else {
									fieldVal2.append(tempVal);
								}
							}
							val = fieldVal2.toString();							
							val_alt = fieldVal2.toString(); //Added for this CRF ML-MMOH-CRF-0601
							
							//Modified against GHL-CRF-0312 [IN:039856] by Saanthaakumar
							out.println("<td class='fields' colspan='"+col_span_td+"' >"+val);
							val = contact_fields[i] ;
							
							val_alt = contact_fields[i] ; //Added for this CRF ML-MMOH-CRF-0601
							
							sb21.append(val) ;
							
							//alt_sb.append(val_alt);   //Added for this CRF ML-MMOH-CRF-0601
							
							sb_a.append(val_alt);   //Added for this CRF ML-MMOH-CRF-0601
							
							int j = 0;
							int j1=0 ;
							String old_val = "" ;
							String new_val = "" ;
							
							String new_val_alt=""; //Added for this CRF ML-MMOH-CRF-0601

							if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt")) {
								old_val = "r_addr_line1" ;
								new_val = "m_addr_line1" ;
								new_val_alt = "a_addr_line1" ; //Added for this CRF ML-MMOH-CRF-0601
							}
							else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt")) {
								old_val = "r_addr_line2" ;
								new_val = "m_addr_line2" ;
								new_val_alt = "a_addr_line2" ; //Added for this CRF ML-MMOH-CRF-0601
							}
							else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt")) {
								old_val = "r_addr_line3" ;
								new_val = "m_addr_line3" ;
								new_val_alt = "a_addr_line3" ; //Added for this CRF ML-MMOH-CRF-0601
							}
							else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt")) {
								old_val = "r_addr_line4" ;
								new_val = "m_addr_line4" ;
								new_val_alt = "a_addr_line4" ; //Added for this CRF ML-MMOH-CRF-0601
							}
							else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
								old_val = "r_area_code" ;
								new_val = "m_area_code" ;
								new_val_alt = "a_area_code" ;  
								if(area_reqd_yn.equals("Y")){//Added for AMRI-CRF-0388 by shagar
                                         out.println("<img id='area_code_mand' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
								//Added for this CRF ML-MMOH-CRF-0601
							}
							else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
								old_val = "r_town_code" ;
								new_val = "m_town_code" ;
								new_val_alt = "a_town_code" ;  //Added for this CRF ML-MMOH-CRF-0601
								if(town_reqd_yn.equals("Y")){ //Added by Suji keerthi on 02-Dec-2019 for KDAH-CRF-0522
                                    out.println("<img id='town_code_mand' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
							}
							else if(contact_col_names[i].equalsIgnoreCase("region_prompt")) {
								old_val = "r_region_code" ;
								//New Iamge is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
								out.println("<img id='id1' src='../images/mandatory.gif' style='"+region_visibility+"'</img>");
								new_val = "m_region_code" ;
								
								new_val_alt = "a_region_code" ; //Added for this CRF ML-MMOH-CRF-0601
								
							}   
							else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt")) {
								old_val = "r_postal_code" ;
								new_val = "m_postal_code" ;
								if(postal_cd_reqd_yn.equals("Y")){//Added for AMRI-CRF-0388 by shagar
                                         out.println("<img id='postal_code_mand' src='../images/mandatory.gif' style='visibility:visible'</img>"); }
								new_val_alt = "alt_postal_code" ; //Added for this CRF ML-MMOH-CRF-0601
							}
							
							//Added for this CRF ML-MMOH-CRF-0601 and ML-MMOH-CRF-0860.2
							while(val_alt.indexOf(old_val) != -1){
                                        int jk =0;
										jk = val_alt.indexOf(old_val,jk) ;
                                        sb_a = sb_a.replace(jk,(jk+old_val.length()),new_val_alt);
                                        val_alt = sb_a.toString();
										
							}												
							if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
									{
										sb_ap.append(val_alt);
										while(val_alt.indexOf("r_postal_code") != -1)
										{ 
											
											int jk1 = 0;
											jk1= val_alt.indexOf("r_postal_code",jk1) ;
											
											sb_ap = sb_ap.replace(jk1,(jk1+"r_postal_code".length()),"alt_postal_code");
											val_alt = sb_ap.toString();
									
										}
									}
							if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")){
										int jk1 = 0;
										sb_ar.append(val_alt);
										while(val_alt.indexOf("r_postal_code") != -1)
										{
											
											jk1 = val_alt.indexOf("r_postal_code",jk1) ;											
											sb_ar = sb_ar.replace(jk1,(jk1+"r_postal_code".length()),"alt_postal_code");
											val_alt = sb_ar.toString();
											
										}
									}
									
									
							sb1_aa.append(val_alt) ;
                            fieldVal_aa.append("");
									
							for(int z=0;z<val_alt.length();z++)	{
									String tempVal=sb1_aa.substring(z,z+1);
									if(tempVal.equals("@"))	{
											fieldVal_aa.append("52"); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
									}else{
											fieldVal_aa.append(tempVal);
									}
							}
									
							val_alt = fieldVal_aa.toString();									
							//End ML-MMOH-CRF-0601 and ML-MMOH-CRF-0860.2
							
							
							
							
																							
							while(val.indexOf(old_val) != -1) {
								j = val.indexOf(old_val,j) ;
								sb21 = sb21.replace(j,(j+old_val.length()),new_val);
								val = sb21.toString();
							}
							if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
							{
								sbaa.append(val);
								while(val.indexOf("r_postal_code") != -1)
								{
									
									j1 = val.indexOf("r_postal_code",j1) ;
									
									sbaa = sbaa.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
									val = sbaa.toString();
							
								}
							}
							if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
							{
								j1 = 0;
								sbrr.append(val);
								while(val.indexOf("r_postal_code") != -1)
								{
									
									j1 = val.indexOf("r_postal_code",j1) ;
									
									sbrr = sbrr.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
									val = sbrr.toString();
									
								}
							}
							sb121.append(val);
							fieldVal21.append("");
							for(int z=0;z<val.length();z++) {
								String tempVal = sb121.substring(z,z+1);
								if(tempVal.equals("@")) {
									fieldVal21.append("54"); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
								} else {
									fieldVal21.append(tempVal);
								}
							}
							val = fieldVal21.toString();
							out.println("</td>") ;
                              %>							
							
							<!--Below line added for ML-MMOH-CRF-0860.2 and  ML-MMOH-CRF-0601-->
									<%								
									if(alterAddressApplicable){
									if(i == 1)
									{  %>
                                          <td class='fields' colspan='<%=col_span_td%>' ><%=val_alt%> </td> 
									<%}else{   
									    out.println("<td class='fields' colspan='"+col_span_td+"'>"+val_alt+"</td>") ;
									  }						
									}
									%>									
									<!--End this ML-MMOH-CRF-0860.2 and  ML-MMOH-CRF-0601-->
									
                             <%
							if(i==0)
							{ 
							  
							  String colspan_td="";
							  if(increasedaddressLength && !alterAddressApplicable){
							  colspan_td=col_span_td;
							  col_span_td="4";
							  }
							%>
							
                            <td class='fields' colspan='<%=col_span_td%>' ><%=val%> <% //Added for ML-MMOH-CRF-0860.2
							  if(increasedaddressLength && !alterAddressApplicable) col_span_td=colspan_td;
							  
							if( (!increasedaddressLength) || (increasedaddressLength && !alterAddressApplicable)){%><a href='javascript:copyDetails(3)'><fmt:message key="eMP.CopyResidenceAddress.label" bundle="${mp_labels}"/></a><%}//End ML-MMOH-CRF-0860.2%> </td>
							<%}else	if(i==1 && alterAddressApplicable){%>
								<td class='fields' colspan='<%=col_span_td%>'><%=val%></td>	
							<%}else{
								  out.println("<td class='fields'  colspan='"+col_span_td+"' >"+val+"</td>") ;
							 }
							out.println("</tr><tr><td class='label' colspan='4' ></td></tr>") ;

							sb12.setLength(0);
							fieldVal2.setLength(0);
							sb21.setLength(0);
							sb121.setLength(0);
							fieldVal21.setLength(0);
							sbaa.setLength(0);
							sbrr.setLength(0);
							
						//Below line added for ML-MMOH-CRF-0860.2
							 sb_a.setLength(0);
							 sb_ap.setLength(0);
							 sb_ar.setLength(0);
							 sb1_aa.setLength(0);
                             fieldVal_aa.setLength(0);							
						//End ML-MMOH-CRF-860.2
							
						} //Condition is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
						if(country_reqd_yn.equals("Y")){
						country_visibility = "visibility:visible";}
						
						%> 
						
						<script>
						// Added for assigning values to dynamically generated address related fields..

							if(document.forms[0].r_addr_line1)
						document.forms[0].r_addr_line1.value = "<%=a_res_addr_line1%>" ;
						if(document.forms[0].r_addr_line2)
							document.forms[0].r_addr_line2.value = "<%=a_res_addr_line2%>" ;
						if(document.forms[0].r_addr_line3)
							document.forms[0].r_addr_line3.value = "<%=a_res_addr_line3%>" ;
						if(document.forms[0].r_addr_line4)
							document.forms[0].r_addr_line4.value = "<%=a_res_addr_line4%>" ;
						if(document.forms[0].r_town_code)
						{
							document.forms[0].r_town_code.value = "<%=a_res_town_desc%>";
							
						}
						if(document.forms[0].r_region_code)
						{
							document.forms[0].r_region_code.value = "<%=a_res_region_desc%>";
							
						}
						if(document.forms[0].r_area_code)
						{
							document.forms[0].r_area_code.value = "<%=a_res_area_desc%>";
							
						}
						if(document.forms[0].r_postal_code1)
							document.forms[0].r_postal_code1.value = "<%=a_postal_desc%>";
						
						if(document.forms[0].m_addr_line1)
						document.forms[0].m_addr_line1.value = "<%=a_mail_addr_line1%>";
						
						if(document.forms[0].m_addr_line2)
							document.forms[0].m_addr_line2.value = "<%=a_mail_addr_line2%>" ;
						if(document.forms[0].m_addr_line3)
							document.forms[0].m_addr_line3.value = "<%=a_mail_addr_line3%>" ;
						if(document.forms[0].m_addr_line4)
							document.forms[0].m_addr_line4.value = "<%=a_mail_addr_line4%>" ;
						if(document.forms[0].m_town_code)
							{
							
							document.forms[0].m_town_code.value = "<%=a_mail_town_desc%>";
							}
						if(document.forms[0].m_region_code)
							{
							
							document.forms[0].m_region_code.value = "<%=a_mail_region_desc%>";
							}
						if(document.forms[0].m_area_code)
							{								
								document.forms[0].m_area_code.value = "<%=a_mail_area_desc%>";
							}
						if(document.forms[0].m_postal_code1)
							document.forms[0].m_postal_code1.value = "<%=a_mail_postal_desc%>";
							

						// End of addition on 13/06/2003 for assigning values to dynamically generated address related fields..
						
						</script>
						<!--New Iamge  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar -->
						
						 <tr>
							<%tindex=61;%>
							<td class='label' ><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
							<td class='fields' colspan='<%=col_span_td%>' ><input type='text' name='r_country_desc' id='r_country_desc' size='15' maxlength='15' onblur='if(this.value !=""){searchCountry(contry_code[0],r_country_desc);} else{clearCountryFields(this)}'  value="<%=a_res_country_desc%>" tabindex='51'><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,r_country_desc)' tabindex='51'><img id='id2' src='../images/mandatory.gif' style='<%=country_visibility%>'></img> 
							<input type='hidden' name='r_country_code' id='r_country_code' value='<%=a_country_code%>'>
							</td>
							<%tindex=76;%>							
							<%
						//Below line added for this CRF and ML-MMOH-CRF-0601 and  ML-MMOH-CRF-0860.2	
						if(alterAddressApplicable)
						{%>
						<td class='fields' colspan='<%=col_span_td%>'>
							<input type='text' name='a_country_desc' id='a_country_desc' size='15' maxlength='15' value="<%=a_mail_country_desc%>" onblur='if(this.value !="") {searchCountry(contry_code[0],a_country_desc); } else {clearCountryFields(this);}' tabindex='53' ><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,a_country_desc)' tabindex='53'>
							<input type='hidden' name='a_country_code' id='a_country_code' value="<%=a_mail_country_code%>">							
						<%}
						  //End ML-MMOH-CRF-0601 and  ML-MMOH-CRF-0860.2
						%>
							
							<td colspan='2' class='fields'><input type='text' name='m_country_desc' id='m_country_desc' size='15' maxlength='15' onblur='if(this.value !=""){searchCountry(contry_code[0],m_country_desc);}else{clearCountryFields(this)}'  value="<%=a_mail_country_desc%>" tabindex='55'><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,m_country_desc)' tabindex='55'> 
							<input type='hidden' name='m_country_code' id='m_country_code' value="<%=a_mail_country_code%>">
							</td>
						</tr>
				</td>
			</tr>
			   <!-- Below line added for ML-MMOH-CRF-0860.2 -->   
			    <%if(alterAddressApplicable){%>
						<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td class='fields' colspan='2'><a href='javascript:copyDetails(4)'><fmt:message key="eMP.CopyAlternateAddress.label" bundle="${mp_labels}"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href='javascript:copyDetails(3)'><fmt:message key="eMP.CopyResidenceAddress.label" bundle="${mp_labels}"/></a></td>
						</tr>
					<%}%>
				<!--End this CRF ML-MMOH-CRF-0860.2 -->  			
			
			<tr><td  class='COLUMNHEADER'  <%=colspantd%> ><fmt:message key="eMP.ContactModes.label" bundle="${mp_labels}"/></td></tr>
						<%
//Condition is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar						
						if(mobile_no_reqd_yn.equals("Y")){ 
								   mobile_no_visibility = "visibility:visible";}
						 tindex = 78;
						sql=" select mp_get_desc.MP_CONTACT_MODE(contact_mode,'"+locale+"',2) short_desc,contact_mode from mp_contact_mode where contact_mode in ('PRN','ORN') order by contact_mode desc ";
						rs = inner_stmt.executeQuery(sql);
						if(rs != null) {
							if(rs.next()) {
							    //Modifed for this SCF AAKH-SCF-0261
								out.println("<tr><td class='label'  >"+rs.getString(1)+"</td>");
								out.println("<td class='fields'><input type='text' name='contact1_no' id='contact1_no' maxlength='20' size='15' value=\""+a_res_tel_no+"\" onblur='makeValidString(this);isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);'>");
								out.println("<input type='hidden' name='contact1_mode' id='contact1_mode' maxlength='20' size='15' value='"+rs.getString(2)+"' ></td>");
																
								
							}
							if(rs.next()) {
							    //Modified for this SCF AAKH-SCF-0261
								out.println("<td class='label'  >"+rs.getString(1)+"</td>") ;
								
								out.println("<td class='fields'><input type='text' name='contact2_no' id='contact2_no' maxlength='20' size='15' value=\"\"  onblur='makeValidString(this);isValidCharacter(this);' onKeyPress='return SpecialCharsChk(event);'>");
								//New Iamge is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
								out.println("<img id='id3' src='../images/mandatory.gif' style='"+mobile_no_visibility+"'</img>");
								out.println("<input type='hidden' name='contact2_mode' id='contact2_mode' maxlength='20' size='15' value='"+rs.getString(2)+"' ></td>");
								
								if(increasedaddressLength){%>
							    <td class='label'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
								<td class='fields' colspan=2 ><input type='text' name='next_off_tel_no' id='next_off_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value=""></td></tr>
								<%}else{
								out.println("</tr>");
								}
							}
						}
						if(rs != null) rs.close();
						%>
			<tr>
			    <!--Below line added for this ML-MMOH-CRF-0601--> 
				<td  class='COLUMNHEADER'  <%=colspantd%> ><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></td>
			</tr>
				<% if(family_no_link_yn.equals("Y")) { %>
					<tr>
						<td class='label' ><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
						<td class='fields'>
						<% 
						sql="SELECT relationship_code, initcap(mp_get_desc.MP_RELATIONSHIP(relationship_code,'"+locale+"',2)) Short_Desc FROM mp_relationship WHERE eff_status='E' order by 2";
						rs = inner_stmt.executeQuery(sql);
						if(rs != null ) 
						while(rs.next()) {
							codes.add(rs.getString("Relationship_Code")) ;
							descs.add(rs.getString("Short_Desc")) ;
						}
						relationcode = codes.toArray();   
						relationdesc = descs.toArray();

						out.println("<select name='next_contact_relation' id='next_contact_relation' onFocus=''>");
						out.println("<option value=\"\">--------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------------- </option>");
						for(int i=0;i<relationcode.length;i++)
							out.println("<option value='"+relationcode[i]+"'>"+relationdesc[i]+ "</option>");
						out.println("</select>");
						%><a href='javascript:copyDetails(1)'><fmt:message key="eMP.CopyHeadofFamily.label" bundle="${mp_labels}"/></a></td><%
					} else { %><td>&nbsp;</td><td>&nbsp;</td><% } %>
					<td class='label' ><fmt:message key="eMP.telephoneres.label" bundle="${mp_labels}"/></td>
					<td class='fields'><input type='text' name='next_res_tel_no' id='next_res_tel_no' maxlength='20' size='20' onblur='makeValidString(this);' value="">
					<% //Below line added for ML-MMOH-CRF-0887.1
					if(increasedaddressLength){%>
					<a href='javascript:copyDetails(2)'><fmt:message key="eMP.CopyPatientAddress.label" bundle="${mp_labels}"/></a>
					<%}%>
					</td> 
					 <% //Below line modified for ML-MMOH-CRF-0860.2 and ML-MMOH-CRF-0887.1
					if(increasedaddressLength){%>
						 <td class='label' ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
						 <td class='fields' colspan=2 ><textarea name='next_contact_name' rows=3 maxlength=80 cols=45 onblur='makeValidString(this); maxLengthPaste(this);' onkeypress='checkMaxLimit(this,80)' onkeyup='RemoveSpecialChar(this)'></textarea></td> 
					<%}%>
				</tr>
				<%
				//Below line added ML-MMOH-CRF-0860.2				   
				  if(!increasedaddressLength){				   
				%>
				<tr>
					<td class='label'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
					<td class='fields'> <!--below CRF length increased against CRF-887 by mano-->
					<input type='text' name='next_contact_name' id='next_contact_name' maxlength='80' size='25' onblur='makeValidString(this);'  value= "">
					<a href='javascript:copyDetails(2)'><fmt:message key="eMP.CopyPatientAddress.label" bundle="${mp_labels}"/></a></td> <td  class='label'><fmt:message key="Common.officephoneno.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type='text' name='next_off_tel_no' id='next_off_tel_no' maxlength='20' size='20'  onblur='makeValidString(this);' value=""></td> 
					 <% //Added for ML-MMOH-CRF-0860.2
					   if(increasedaddressLength){
							    out.println("<td class='label' >&nbsp;</td><td class='label' >&nbsp;</td><td class='label' >&nbsp;</td>");
						}
						%>
				</tr>
				<%} //End ML-MMOH-CRF-0860.2
				
				
				StringBuffer sbc			=	new StringBuffer();
				StringBuffer sb1c			=	new StringBuffer();
				StringBuffer fieldValc		=	new StringBuffer();
				StringBuffer sbap			=	new StringBuffer();
				StringBuffer sbar			=	new StringBuffer();
				
				//Below line added for ML-MMOH-CRF-0860.2				
				int displayCountry=contact_col_names.length-1;				
				int conutry=0;
				
				System.err.println("InsertRapidRegn.jsp displayCountry===>"+displayCountry);
				System.err.println("InsertRapidRegn.jsp contact_col_names.length===>"+contact_col_names.length);
				
				for(int i=0;i<contact_col_names.length; i++) {
				   
					//Below line added for ML-MMOH-CRF-0860.2
					if(increasedaddressLength){
					if(i==0 || i==3 || i==6){
					conutry=i;
					out.println("<tr>") ;
					}					
					out.println("<td class='label' >"+contact_prompts[i]+"</td>") ;					
					}else{
					out.println("<tr>") ;
					out.println("<td class='label' >"+contact_prompts[i]+"</td>") ;
					}
                     //End ML-MMOH-CRF-0860.2					
					 String val = contact_fields[i] ;					
					 sbc.append(val) ;
					
					int j = 0;
					int j1=0 ;
					String old_val = "" ;
					String new_val = "" ;
					if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
					{
						old_val = "r_addr_line1" ;
						new_val = "next_addr_line1" ;
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
					 {
						old_val = "r_addr_line2" ;
						new_val = "next_addr_line2" ;
					}
					 else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
					 {
						old_val = "r_addr_line3" ;
						new_val = "next_addr_line3" ;
					 }
					 else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
					{
						old_val = "r_addr_line4" ;
						new_val = "next_addr_line4" ;
					}
					else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
					{
						old_val = "r_town_code" ;
						new_val = "contact1_res_town_code" ;
					}
					else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
					{
						old_val = "r_region_code" ;
						new_val = "contact1_region_code" ;
					}
					else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
					{
						old_val = "r_area_code" ;
						new_val = "contact1_res_area_code" ;
					}                                     
					else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
					{
						old_val = "r_postal_code" ;
						new_val = "next_postal_code" ;
					}				
					while(val.indexOf(old_val) != -1)
					{
						j = val.indexOf(old_val,j) ;
						sbc = sbc.replace(j,(j+old_val.length()),new_val);
						val = sbc.toString();
					}
					if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
					{
						sbap.append(val);
						while(val.indexOf("r_postal_code") != -1)
						{
							
							j1 = val.indexOf("r_postal_code",j1) ;
							
							sbap = sbap.replace(j1,(j1+"r_postal_code".length()),"next_postal_code");
							val = sbap.toString();
					
						}
					}
					if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
					{
						j1 = 0;
						sbar.append(val);
						while(val.indexOf("r_postal_code") != -1)
						{							
							j1 = val.indexOf("r_postal_code",j1) ;
							
							sbar = sbar.replace(j1,(j1+"r_postal_code".length()),"next_postal_code");
							val = sbar.toString();
							
						}
					}
					sb1c.append(val);
					fieldValc.append("");
					for(int z=0;z<val.length();z++)
					{
						String tempVal=sb1c.substring(z,z+1);
						if(tempVal.equals("@"))
						{
							fieldValc.append(60); //Modified by Suji Keerthi for PMG2020-ML-MMOH-CRF-0001
						}
						else
						{
							fieldValc.append(tempVal);
						}
					}	
					val = fieldValc.toString();
 
                    //Below line added for this ML-MMOH-CRF-0860.2
					if(increasedaddressLength){					
					out.println("<td class='fields' >"+val+"</td>") ;
					//System.err.println("InsertRapidRegn.jsp   i==>"+i);
					 
					if((i==displayCountry && contact_col_names.length ==7) || (i==displayCountry && contact_col_names.length ==8) || (i==displayCountry && contact_col_names.length ==2) || (i==displayCountry && contact_col_names.length ==1) || (i==displayCountry && contact_col_names.length ==4 || (i==displayCountry && contact_col_names.length ==5))){
					//if(i==7){
					 %>
				    <td class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type='text' name='next_country_desc' id='next_country_desc'                   size='15' maxlength='15' onblur='if(this.value !=""){searchCountry(contry_code[0],next_country_desc);}else{clearCountryFields(this)}' tabindex='61'><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,next_country_desc)' tabindex='61'>
					<input type='hidden' name='next_country_code' id='next_country_code' value=''>					 
					 <%}
					if(i==2 || i==5 || i==7){					
					out.println("<td>&nbsp;</td></tr>") ; 
					//out.println("</tr>") ;
					}
					//else{
                     
					 //}					
					}else{
					out.println("<td class='fields' >"+val+"</td>") ;
					out.println(" <td>&nbsp;</td><td>&nbsp;</td></tr>") ;
					}
					//End ML-MMOH-CRF-0860.2

					sbc.setLength(0);
					sb1c.setLength(0);
					fieldValc.setLength(0);
					sbap.setLength(0);
					sbar.setLength(0);
				}
				
				//Below line added for ML-MMOH-CRF-0860.2
				if((!increasedaddressLength) || (increasedaddressLength && contact_col_names.length==0)){		
				%>
				<tr>
					<td class='label'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type='text' name='next_country_desc' id='next_country_desc' size='15' maxlength='15' onblur='if(this.value !=""){searchCountry(contry_code[0],next_country_desc);}else{clearCountryFields(this)}' tabindex='61'><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,next_country_desc)' tabindex='61'>
					<input type='hidden' name='next_country_code' id='next_country_code' value=''>
					</td><td>&nbsp;</td><td>&nbsp;</td>
				</tr>
				<%}
				//End ML-MMOH-CRF-0860.2
				%>
			</tr> 
		</table>
	</td>
</tr>
</table>

<%
	if(bl_install_yn.equals("Y"))
	{
		sql_bl="select dflt_pat_regn_blng_class from bl_mp_param";
		stmt_bl = con.prepareStatement(sql_bl);
		rs_bl = stmt_bl.executeQuery();
		if(rs_bl!=null)
		{
			while(rs_bl.next())
			{
				dflt_pat_regn_blng_class = rs_bl.getString(1)==null?"":rs_bl.getString(1);
			}
		}
	}
	%>

	<input type='hidden' name='blood_grp' id='blood_grp' value=""></input>
	<input type='hidden' name='rh_factor' id='rh_factor' value=""></input>
	<input type='hidden' name='r_postal_code' id='r_postal_code' value='<%=a_postal_code%>'>
	<input type='hidden' name='m_postal_code' id='m_postal_code' value='<%=a_mail_postal_code%>'>
	<input type='hidden' name='next_postal_code' id='next_postal_code' value=''>
	<input type='hidden' name='m_town' id='m_town' value='<%=a_mail_town_code%>'></input>
	<input type='hidden' name='r_town' id='r_town' value='<%=a_res_town_code%>'></input>
	<input type='hidden' name='n_town' id='n_town' value=''></input>
	<input type='hidden' name='r_area' id='r_area' value='<%=a_res_area_code%>'></input>
	<input type='hidden' name='m_area' id='m_area' value='<%=a_mail_area_code%>'></input>
	<input type='hidden' name='n_area' id='n_area' value=''></input>
	<input type='hidden' name='r_region' id='r_region' value='<%=a_res_region_code%>'></input>
	<input type='hidden' name='m_region' id='m_region' value='<%=a_mail_region_code%>'></input>
	<input type='hidden' name='n_region' id='n_region' value=''></input>
	<input type='hidden' name='function_id' id='function_id' value='RAPID_REG'></input>
	<input type='hidden' name='patient_group' id='patient_group' value="<%=patient_grp%>"></input>
	<input type='hidden' name='nat_series_loaded' id='nat_series_loaded' value="N"></input>
	<input type='hidden' name='patient_id' id='patient_id' value=""></input>
	<input type='hidden' name='patient_name' id='patient_name' value=""></input>
	<input type='hidden' name='patient_name_loc_lang' id='patient_name_loc_lang' value=""></input>
	<input type='hidden' name='name_drvn_logic' id='name_drvn_logic' value='<%=name_dervn_logic%>'></input>
	<input type='hidden' name='name_drvn_logic_oth_lang' id='name_drvn_logic_oth_lang' value='<%=name_dervn_logic_oth_lang%>'></input>
	<input type='hidden' name='pat_no_gen_yn' id='pat_no_gen_yn' value='<%=gen_pat_id_yn%>'></input>
	<input type='hidden' name='nat_id_val' id='nat_id_val' value='S'></input>
	<input type='hidden' name='dflt_grp' id='dflt_grp' value="<%=dflt_grp%>"></input>
	<input type='hidden' name='town_desc' id='town_desc' value=""></input>
	<input type='hidden' name='Alt_Id1_Unique_Yn1' id='Alt_Id1_Unique_Yn1' value='<%=alt_id1_unique_yn%>'></input>
	<input type='hidden' name='Alt_Id2_Unique_Yn2' id='Alt_Id2_Unique_Yn2' value='<%=alt_id2_unique_yn%>'></input>
	<input type='hidden' name='Alt_Id3_Unique_Yn3' id='Alt_Id3_Unique_Yn3' value='<%=alt_id3_unique_yn%>'></input>
	<input type='hidden' name='Alt_Id4_Unique_Yn4' id='Alt_Id4_Unique_Yn4' value='<%=alt_id4_unique_yn%>'></input>
	<!-- <input type='hidden' name='AltdfltPSG' id='AltdfltPSG' value="<%=AltdfltPSG%>"></input> -->
	<input type='hidden' name='dflt_nationality_code' id='dflt_nationality_code' value="<%=citizen_nationality_code%>"></input>
	<input type='hidden' name='default_race_code' id='default_race_code' value="<%=default_race_code%>"></input>
	<input type='hidden' name='dflt_nat_id_chk_val' id='dflt_nat_id_chk_val' value=""></input>
	<input type='hidden' name='ServerDate' id='ServerDate' value='<%=serverdate%>'></input>
	
	<!--Below line added for this CRF ML-MMOH-CRF-0860.2-->
	<input type='hidden' name='a_area' id='a_area' value="">
	<input type='hidden' name='a_region' id='a_region' value="">
	<input type='hidden' name='a_town' id='a_town' value="">
	<input type='hidden' name='alt_postal_code' id='alt_postal_code' value="">
	<!--End this ML-MMOH-CRF-0860.2 -->
	

	<input type ='hidden' name='refrlAappt' id='refrlAappt' value=''></input>
	<input type ='hidden' name='refIDValue' id='refIDValue' value=''></input>
	
	<script>			
		var natid = "<%=nat_id%>";
		var altid = "<%=alt_id%>";

		if(natid != '') dispMandatoryImage('N');
		if(altid != '') dispMandatoryImage('A');
		
		var val = ""
        val ="<%=request.getParameter("apply_oth_name")%>"
		if(val=="") val = "N";
		
        if(val =="N")
        {
			val ="<%=request.getParameter("First_Name")%>"
          	if(val !="" && val !='null')
            {
				if(document.getElementById('first_name_oth_lang'))
				{
					document.getElementById('first_name').value=val
					putPatientName(document.getElementById('first_name'))
    			}
			}
            val ="<%=request.getParameter("Second_Name")%>"
          			if(val !="" && val !='null')
            {
				if(document.getElementById('second_name_oth_lang'))
				{
					document.getElementById('second_name').value=val
					putPatientName(document.getElementById('second_name'))
    			}
			}
            val ="<%=request.getParameter("Third_Name")%>"
            if(val !="" && val !='null')
            {
	            if(document.getElementById('third_name'))
				{
					document.getElementById('third_name').value=val
					putPatientName(document.getElementById('third_name'))
    			}
			}

			val ="<%=request.getParameter("Family_Name")%>"
				
            if(val !="" && val !='null')
            {
				if(document.getElementById('family_name'))
				{
					document.getElementById('family_name').value=val
					putPatientName(document.getElementById('family_name'))
				}
            }
	//	}
      //   if(val =="N")
        //{
				
			val ="<%=request.getParameter("first_name_loc_lang")%>"
    		if(val !="" && val !='null')
            {
				if(document.getElementById('first_name_oth_lang'))
				{
					 document.getElementById('first_name_oth_lang').value=val
					 putPatientName(document.getElementById('first_name_oth_lang'))
				}
			}
            val ="<%=request.getParameter("second_name_loc_lang")%>"
            if(val !="" && val !='null')
            {
				if(document.getElementById('second_name_oth_lang'))
				{
					document.getElementById('second_name_oth_lang').value=val
					putPatientName(document.getElementById('second_name_oth_lang'))
                }
			}

            val ="<%=request.getParameter("third_name_loc_lang")%>"
            if(val !="" && val !='null')
            {
				if(document.getElementById('third_name_oth_lang'))
				{
					document.getElementById('third_name_oth_lang').value=val
					putPatientName(document.getElementById('third_name_oth_lang'))
                }
			}

            val ="<%=request.getParameter("family_name_loc_lang")%>"
				
			if(val !="" && val !='null')
			{
				if(document.getElementById('family_name_oth_lang'))
				{
					document.getElementById('family_name_oth_lang').value=val
					putPatientName(document.getElementById('family_name_oth_lang'))
				}
			}
        }
            
        val ="<%=request.getParameter("Alt_Id_No")%>"
		if(document.getElementById('alt_id1_no') != null)
		{
			if(val !='null' && document.getElementById('alt_id1_no').value == '')
	        {
				if(document.getElementById('alt_id1_no'))
			    document.getElementById('alt_id1_no').value=val
			}
		}
		val ="<%=request.getParameter("Alt_Id2_No")%>"
		if(document.getElementById('alt_id2_no') != null)
		{
			if(document.getElementById('alt_id2_no'))
			{
				if(val !='null' && document.getElementById('alt_id2_no').value == '')
					document.getElementById('alt_id2_no').value = val
			}
		}
        val ="<%=request.getParameter("National_Id_No")%>"
        if(document.forms[0].national_id_no.value == '' && val !="null")
        {
			if(document.forms[0].national_id_no)
			{
                document.forms[0].national_id_no.value=val;
			    <%=exestr%>
			}
		}
   
        val ="<%=request.getParameter("Dob")%>"
        if(val !="" && val !='null')
        {
			if(document.getElementById('date_of_birth'))
			{
				document.getElementById('date_of_birth').value = val
				document.getElementById('date_of_birth').focus();
			}
		}
            
       val ="<%=request.getParameter("Area")%>"
		var par_ser_cnt = document.getElementById('pat_ser_grp_code').options.length;
		if (par_ser_cnt <=1)
		{
			if(document.getElementById('national_id_no'))
				document.getElementById('national_id_no').focus();
			else 
				FocusFirstElement()
		}
		else
			FocusFirstElement()
		

		var nationalIDNum = "<%=a_national_id_no%>"; 
			
		if(nationalIDNum != ''){
			//document.forms[0].national_id_no.focus();
			}
		else
			FocusFirstElement()

			/*
			if (parent.frames[0].document.getElementById("patient_name"))
			{
				parent.frames[0].document.getElementById("patient_name").readOnly = false;
				if('<%=refrlAappt%>' == 'P')
				{
					if("<%=a_patient_name%>" != '') {
							parent.parent.frames[1].frames[0].document.forms[0].patient_name.value = "<%=a_patient_name%>";
					}
				}
			}
			*/
	

	</script>
	<input type='hidden' name='billing_group' id='billing_group' value=""></input>
	<input type='hidden' name='billing_class' id='billing_class' value=""></input>
	<input type='hidden' name='employer_code' id='employer_code' value=""></input>
	<input type='hidden' name='cash_set_type1' id='cash_set_type1' value=""></input>
	<input type='hidden' name='cash_insmt_ref1' id='cash_insmt_ref1' value=""></input>
	<input type='hidden' name='cash_insmt_date1' id='cash_insmt_date1' value=""></input>
	<input type='hidden' name='cash_insmt_rmks1' id='cash_insmt_rmks1' value=""></input>
	<input type='hidden' name='cust_1' id='cust_1' value=""></input>
	<input type='hidden' name='credit_doc_ref1' id='credit_doc_ref1' value=""></input>
	<input type='hidden' name='credit_doc_date1' id='credit_doc_date1' value=""></input>
	<input type='hidden' name='cust_2' id='cust_2' value=""></input>
	<input type='hidden' name='credit_doc_ref2' id='credit_doc_ref2' value=""></input>
	<input type='hidden' name='credit_doc_date2' id='credit_doc_date2' value=""></input>
	<input type='hidden' name='cust_3' id='cust_3' value=""></input>
	<input type='hidden' name='policy_type' id='policy_type' value=""></input>
	<input type='hidden' name='policy_no' id='policy_no' value=""></input>
	<input type='hidden' name='policy_expiry_date' id='policy_expiry_date' value=""></input>
	<input type='hidden' name='non_insur_blng_grp' id='non_insur_blng_grp' value=""></input>
	<input type='hidden' name='cash_set_type2' id='cash_set_type2' value=""></input>
	<input type='hidden' name='cash_insmt_ref2' id='cash_insmt_ref2' value=""></input>
	<input type='hidden' name='cash_insmt_date2' id='cash_insmt_date2' value=""></input>
	<input type='hidden' name='cash_insmt_rmks2' id='cash_insmt_rmks2' value=""></input>
	<input type='hidden' name='cust_4' id='cust_4' value=""></input>
	<input type='hidden' name='credit_doc_ref3' id='credit_doc_ref3' value=""></input>
	<input type='hidden' name='credit_doc_date3' id='credit_doc_date3' value=""></input>
	<input type='hidden' name='setlmt_ind' id='setlmt_ind' value=""></input>
	<input type='hidden' name='upd_fin_dtls' id='upd_fin_dtls' value=""></input>
	<input type='hidden' name='credit_auth_ref' id='credit_auth_ref' value=""></input>
	<input type='hidden' name='credit_auth_date' id='credit_auth_date' value=""></input>
	<input type='hidden' name='app_days' id='app_days' value=""></input>
	<input type='hidden' name='app_amount' id='app_amount' value=""></input>
	<input type='hidden' name='eff_frm_date' id='eff_frm_date' value=""></input>
	<input type='hidden' name='remarks' id='remarks' value=""></input>
	<input type='hidden' name='billing_mode' id='billing_mode' value='Add'></input>
	<input type='hidden' name='health_card_expired_yn' id='health_card_expired_yn' value=""></input>
	<input type='hidden' name='annual_income' id='annual_income' value=""></input>
	<input type='hidden' name='family_asset' id='family_asset' value=""></input>
	<input type='hidden' name='no_of_dependants' id='no_of_dependants' value=""></input>
	<input type='hidden' name='resp_for_payment' id='resp_for_payment' value=""></input>
	<input type='hidden' name='credit_doc_reqd_yn1' id='credit_doc_reqd_yn1' value=""></input>
	<input type='hidden' name='credit_doc_reqd_yn2' id='credit_doc_reqd_yn2' value=""></input>
	<input type='hidden' name='bl_install_yn' id='bl_install_yn' value="<%=bl_install_yn%>"></input>
	<input type='hidden' name='bl_success' id='bl_success' value="N"></input>
	<input type='hidden' name='called_from' id='called_from' value="Rapid_Regn"></input>
	<input type='hidden' name='cred_start_dt1' id='cred_start_dt1' value=""></input>  
	<input type='hidden' name='cred_start_dt2' id='cred_start_dt2' value=""></input>  
	<input type='hidden' name='cred_start_dt3' id='cred_start_dt3'  value=""></input> 
	<input type='hidden' name='gl_holder_name' id='gl_holder_name' value=""></input> 
	<input type='hidden' name='gl_holder_reln' id='gl_holder_reln' value=""></input>
	<input type='hidden' name='dflt_pat_regn_blng_class' id='dflt_pat_regn_blng_class' value=<%=dflt_pat_regn_blng_class%>>
	<input type='hidden' name='dflt_pat_ser_grp_code' id='dflt_pat_ser_grp_code' value="<%=dflt_grp%>"></input>
	
	<input type='hidden' name='photo_file_name' id='photo_file_name' value='<%=photo_file_name%>.jpg'></input>
	<input type='hidden' name='alt_exp_date_fromHCS' id='alt_exp_date_fromHCS' value="N"></input>
	<input type='hidden' name='error_alt_no1' id='error_alt_no1' value="">
	<input type='hidden' name='error_alt_no2' id='error_alt_no2' value="">
	<input type='hidden' name='error_alt_no3' id='error_alt_no3' value="">
	<input type='hidden' name='error_alt_no4' id='error_alt_no4' value="">
	<input type='hidden' name='maintain_doc_or_file' id='maintain_doc_or_file' value="<%=maintain_doc_or_file%>"></input>
	<input type='hidden' name='sStyle' id='sStyle' value="<%=sStyle%>"></input>
	<input type='hidden' name='create_file_at_pat_regn_yn' id='create_file_at_pat_regn_yn' value="<%=create_file_at_pat_regn_yn%>"></input>
 	 <input type='hidden' name='locale' id='locale' value="<%=locale%>">
	 <input type ='hidden' name='altId1Desc' id='altId1Desc' value="<%= (alt_id1_desc == null? "&nbsp;":alt_id1_desc) %>">
	 <input type ='hidden' name='altId2Desc' id='altId2Desc' value="<%= (alt_id2_desc== null? "&nbsp;":alt_id2_desc) %>">
	 <input type ='hidden' name='altId3Desc' id='altId3Desc' value="<%= (alt_id3_desc == null? "&nbsp;":alt_id3_desc) %>">
	 <input type ='hidden' name='altId4Desc' id='altId4Desc' value="<%= (alt_id4_desc == null? "&nbsp;":alt_id4_desc) %>">
	 <input type='hidden' name='name_drvn_logic_long' id='name_drvn_logic_long' value='<%=(String)hash_mp_param.get("name_dervn_logic_long")%>'>
	 <input type='hidden' name='name_drvn_logic_oth_lang_long' id='name_drvn_logic_oth_lang_long' value="<%=(String)hash_mp_param.get("name_dervn_logic_oth_lang_long")%>">
	<input type='hidden' name='patient_name_long' id='patient_name_long' value=""></input>
	<input type='hidden' name='patient_name_loc_lang_long' id='patient_name_loc_lang_long' value=""></input>
	<!--New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar-->
	<input type='hidden' name='region_prompt1' id='region_prompt1' value="<%=region_prompt%>"></input>
	<input type='hidden' name='region_appl_yn1' id='region_appl_yn1' value="<%=region_appl_yn%>"></input>
	<input type='hidden' name='postal_code_prompt' id='postal_code_prompt' value="<%=postal_code_prompt%>"></input>
    <input type='hidden' name='area_code_prompt' id='area_code_prompt' value="<%=area_code_prompt%>"></input>
    <!-- Added by Suji keerthi on 02-Dec-2019 for KDAH-CRF-0522 -->
    <input type='hidden' name='town_code_prompt' id='town_code_prompt' value="<%=town_code_prompt%>"></input>
	<!--Added by Ashwini on 07-Sep-2018-->
	<input type='hidden' name='finDtlsChkNationality' id='finDtlsChkNationality' value='<%=finDtlsChkNationality%>'></input>
	 </div>

	 <%
		if(pstmt != null) pstmt.close();
		if(inner_stmt != null) inner_stmt.close();
		if(rset != null) rset.close();
		if(rs != null) rs.close();
		if(oth_stmt != null) oth_stmt.close();
		if(oth_stmt1 != null) oth_stmt1.close();
	}
    catch(Exception e)
    {
		out.println("Exception in main try"+e.getMessage()+sql);
		e.printStackTrace();
	}
    finally
    {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	if(ext_system_interface_yn.equals("Y") && nat_data_source_id.equals("NRIC")) {
		
		%>
		<!-- FOR MYKAD READING -->
		<OBJECT id=Cad style=\"WIDTH: 149px; HEIGHT: 25px\" data=data:application/x-oleobject;base64,6bldI31CwEeRWh+s54i2NAADAABmDwAAlQIAAA== classid=clsid:235DB9E9-427D-47C0-915A-1FACE788B634></OBJECT>
		<OBJECT id=jpndf1 style=\"WIDTH: 192px; HEIGHT: 24px\" data=data:application/x-oleobject;base64,arMlNbqDrEKC9D9p0v5gBQADAADYEwAAewIAAA== classid=clsid:3525B36A-83BA-42AC-82F4-3F69D2FE6005></OBJECT>
		<OBJECT id=jpndf4 style=\"LEFT: 0px; WIDTH: 192px; TOP: 0px; HEIGHT: 24px\" data=data:application/x-oleobject;base64,zUFYb5tV40iaOd6s6vQBygADAADYEwAAewIAAA== classid=clsid:6F5841CD-559B-48E3-9A39-DEACEAF401CA></OBJECT>
		<OBJECT id=gmpcpic style=\"WIDTH: 345px; HEIGHT: 303px\" data=data:application/x-oleobject;base64,2lmqMIeVKU6C6+Ww4x0h3QADAACoIwAAUR8AAA== classid=clsid:30AA59DA-9587-4E29-82EB-E5B0E31D21DD></OBJECT>
		<!-- FOR MYKAD READING -->
	<% } %>
		<script>
			checkPatGenYN();	
		</script>
	</form>
    </body>
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


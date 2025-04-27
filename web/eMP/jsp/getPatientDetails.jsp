<!DOCTYPE html>
<!-- Last Modified Date Time : 9/23/2005 3:02 PM --> 

<%@ page contentType="text/html; charset=UTF-8" import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.Statement, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			
		<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
	</head>

<body class='message' onKeyDown='lockKey();'>
<%
	Connection con				= null;
    PreparedStatement pstmt		= null;
    java.sql.Statement stmt3	= null;
    java.sql.Statement stmt4	= null;
    ResultSet rset				= null;
    ResultSet rset2				= null;
	ResultSet rset3				= null;
	ResultSet rset4				= null;

    String value1 = request.getParameter("field1") == null ? "" : request.getParameter("field1");
	String value2 = request.getParameter("field2") == null ? "" : request.getParameter("field2");

	String sql					= "";
	String sex					= "";
	String fathername			= "";
	String fathername_loc_lang	= "";    
	String alt_id1_no			= "";
	String alt_id2_no			= "";
	String alt_id3_no			= "";
	String first_name			= "";
	String second_name			= "";
	String third_name			= "";
	String family_name			= "";
	String first_name_loc_lang	= "";
	String second_name_loc_lang = "";
	String third_name_loc_lang	= "";
	String family_name_loc_lang	= "";
	String date_of_birth		= "";
	String nationality			= "";
	String religion				= "";
	String occupation			= "";
	String education			= "";
	String residence			= "";
	String relationship			= "";
	String inhouse_birth_yn		= "";
	String hj_date				= "";

    try
    {
		con = ConnectionManager.getConnection(request);

		if(value1.equals("father_patient_id"))
        {
			String frames_list = "";
			frames_list = "parent.frames[1].frames[2].";

			sql ="SELECT decode('"+localeName+"', 'en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,SEX, patient_name_loc_lang, alt_id1_no, alt_id2_no, alt_id3_no, first_name, second_name, third_name, family_name, first_name_loc_lang, second_name_loc_lang, third_name_loc_lang, family_name_loc_lang, to_char(date_of_birth,'dd/mm/yyyy') date_of_birth, mp_country.long_desc nationality, relgn_code, education_level, ocpn_code FROM mp_patient pat, mp_pat_oth_dtls oth_dtls, mp_pat_rel_contacts rel, mp_country where pat.PATIENT_ID = ? AND pat.patient_id = oth_dtls.patient_id AND pat.patient_id = rel.patient_id(+) AND pat.nationality_code = mp_country.country_code(+)";
                
            if(pstmt != null) pstmt.close();
            pstmt = con.prepareStatement(sql);
                
            pstmt.setString(1,value2);
            rset = pstmt.executeQuery();
                
            boolean flag=true;

            if(rset.next())
            {                    
				if(rset.getString(2).equals("M"))
                {
					fathername				= rset.getString(1);
					fathername_loc_lang		= rset.getString("patient_name_loc_lang");  
					alt_id1_no				= rset.getString("alt_id1_no");
					alt_id2_no				= rset.getString("alt_id2_no");
					alt_id3_no				= rset.getString("alt_id3_no");
					first_name				= rset.getString("first_name");
					second_name				= rset.getString("second_name");
					third_name				= rset.getString("third_name");
					family_name				= rset.getString("family_name");
					first_name_loc_lang		= rset.getString("first_name_loc_lang");
					second_name_loc_lang	= rset.getString("second_name_loc_lang");
					third_name_loc_lang		= rset.getString("third_name_loc_lang");
					family_name_loc_lang	= rset.getString("family_name_loc_lang");
					date_of_birth			= rset.getString("date_of_birth");
					religion				= rset.getString("relgn_code");
					occupation				= rset.getString ("ocpn_code");
					education				= rset.getString("education_level");
					

					if(first_name == null) first_name = "";
					if(second_name == null) second_name = "";
					if(third_name == null) third_name = "";
					if(family_name == null) family_name = "";
					if(first_name_loc_lang == null) first_name_loc_lang = "";
					if(second_name_loc_lang == null) second_name_loc_lang = "";
					if(third_name_loc_lang == null) third_name_loc_lang = "";
					if(family_name_loc_lang == null) family_name_loc_lang = "";
					if(alt_id1_no == null) alt_id1_no = "";
					if(alt_id2_no == null) alt_id2_no = "";
					if (alt_id3_no == null) alt_id3_no = "";
					if(fathername_loc_lang == null) fathername_loc_lang = "";
					if(religion == null) religion = "";
					if (occupation == null) occupation = "";
					if (education == null) education = "";
					nationality = rset.getString("nationality");
					if(nationality == null) nationality = "";
	
					fathername = fathername_loc_lang + "  "+fathername;
					out.println("<script>						"+frames_list+"document.forms[0].father_patient_name.value=\""+fathername+"\";	"+frames_list+"document.forms[0].father_patient_name_loc_lang.value=\""+fathername_loc_lang+"\";						"+frames_list+"document.getElementById('fathername').innerHTML=\"<b>  "+fathername+"\";		"+frames_list+"document.forms[0].fath_qid_no.value=\""+alt_id1_no+"\";			"+frames_list+"document.forms[0].fath_hmc_no.value=\""+alt_id2_no+"\";			"+frames_list+"document.forms[0].fath_name1.value=\""+first_name+"\";		"+frames_list+"document.forms[0].fath_name2.value=\""+second_name+"\";	"+frames_list+"document.forms[0].fath_name3.value=\""+third_name+"\";		"+frames_list+"document.forms[0].fath_name6.value=\""+family_name+"\";	"+frames_list+"document.forms[0].fath_name_oth_lang1.value=\""+first_name_loc_lang+"\";		"+frames_list+"document.forms[0].fath_name_oth_lang2.value=\""+second_name_loc_lang+"\";								"+frames_list+"document.forms[0].fath_name_oth_lang3.value=\""+third_name_loc_lang+"\";								"+frames_list+"document.forms[0].fath_name_oth_lang4.value=\""+family_name_loc_lang+"\";										"+frames_list+"document.forms[0].fath_date_of_birth.value='"+date_of_birth+"';	"+frames_list+"document.forms[0].fath_nationality.value='"+nationality+"';		"+frames_list+"document.forms[0].fath_religion.value='"+religion+"';		"+frames_list+"document.forms[0].fath_occupation.value='"+occupation+"';		"+frames_list+"document.forms[0].fath_education.value='"+education+"';			"+frames_list+"document.forms[0].fath_qid_no.readOnly=true;						"+frames_list+"document.forms[0].fath_hmc_no.readOnly=true;						"+frames_list+"document.forms[0].fath_date_of_birth.readOnly=true; ");
					out.println("</script>");						
				}                    
				else
                {
					flag = false;
					out.println("<script>alert(getMessage('GENDER_MISMATCH','MP'));						"+frames_list+"document.forms[0].father_patient_name.value='';				"+frames_list+"document.forms[0].father_patient_name_loc_lang.value='';			"+frames_list+"document.forms[0].father_patient_id.value='';					"+frames_list+"document.forms[0].father_patient_id.focus();						</script>");
				}
			}
            else
            {
				flag = false;
                out.println("<script>alert(getMessage('FATHER_PATID_INVALID','MP'));					"+frames_list+"document.forms[0].father_patient_name.value='';				"+frames_list+"document.forms[0].father_patient_name_loc_lang.value='';	"+frames_list+"document.forms[0].father_patient_id.value='';					"+frames_list+"document.forms[0].father_patient_id.focus();</script>");
			}
            if(flag)
            {
				String sql2=" select to_char(DATE_OF_BIRTH,'dd/mm/yyyy')  from mp_patient where patient_id=? ";
					
				if(pstmt != null) pstmt.close();
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1,value2) ;
					
				rset2 = pstmt.executeQuery();
				String dob = "";
				while(rset2.next())
				{
					dob= rset2.getString(1);
				}

				String sql3=" select NB_FATHER_MIN_AGE from mp_param ";
					
				stmt3 = con.createStatement();
				rset3 = stmt3.executeQuery(sql3);
				int father_min_age=0;
				while(rset3.next())
				{
					father_min_age=rset3.getInt(1);
				}
				int pat_age=0;
				String sql4="select calculate_age('"+dob+"',1) from dual ";
				stmt4 = con.createStatement();
				rset4 = stmt4.executeQuery(sql4);
				while(rset4.next())
				{
					pat_age=rset4.getInt(1);
				}
				if(pat_age < father_min_age)
				{
					out.println("<script>alert(getMessage('FATHER_AGE_PARAM','MP'));	"+frames_list+"document.forms[0].father_patient_name.value='';				"+frames_list+"document.forms[0].father_patient_name_loc_lang.value='';			"+frames_list+"document.forms[0].father_patient_id.value='';					"+frames_list+"document.forms[0].father_patient_id.focus();						</script>");
				}
			}                
		}            
		else if (value1.equals("not_patient_id"))
		{
			String frames_list = "";
			frames_list = "parent.frames[1].frames[2].";
			sql ="select decode('"+localeName+"', 'en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,SEX, patient_name_loc_lang, alt_id1_no, alt_id2_no, alt_id3_no, first_name, second_name, third_name, family_name, first_name_loc_lang, second_name_loc_lang, third_name_loc_lang, family_name_loc_lang, to_char(date_of_birth,'dd/mm/yyyy') date_of_birth,  pat.nationality_code nationality, relgn_code, education_level, ocpn_code, relationship_to_head, res_area_code, inhouse_birth_yn  from mp_patient pat, mp_pat_oth_dtls oth_dtls, mp_pat_rel_contacts rel, mp_country  where pat.PATIENT_ID=? and pat.patient_id = oth_dtls.patient_id and pat.patient_id = rel.patient_id(+) and pat.nationality_code = mp_country.country_code(+)";
               
			if(pstmt != null) pstmt.close();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,value2);
            rset = pstmt.executeQuery();
                
            boolean flag=true;

            if(rset.next())
            {                    
				inhouse_birth_yn = rset.getString("inhouse_birth_yn");
				if(inhouse_birth_yn==null) inhouse_birth_yn = "";
				if(inhouse_birth_yn.equals("N"))
				{
					fathername = rset.getString(1);
					sex = rset.getString("sex");
					fathername_loc_lang = rset.getString("patient_name_loc_lang");  
					if(fathername_loc_lang == null) fathername_loc_lang = "";

					alt_id1_no = rset.getString("alt_id1_no");
					alt_id2_no = rset.getString("alt_id2_no");
					alt_id3_no = rset.getString("alt_id3_no");

					if(alt_id1_no == null) alt_id1_no = "";
					if(alt_id2_no == null) alt_id2_no = "";
					if(alt_id3_no == null) alt_id3_no = "";
						
					first_name = rset.getString("first_name");
					second_name = rset.getString("second_name");
					third_name = rset.getString("third_name");
					family_name = rset.getString("family_name");
					first_name_loc_lang = rset.getString("first_name_loc_lang");
					second_name_loc_lang = rset.getString("second_name_loc_lang");
					third_name_loc_lang = rset.getString("third_name_loc_lang");
					family_name_loc_lang = rset.getString("family_name_loc_lang");
					if (first_name == null) first_name = "";
					if (second_name == null) second_name = "";
					if (third_name == null) third_name = "";
					if (family_name == null) family_name = "";
					if (first_name_loc_lang == null) first_name_loc_lang = "";
					if (second_name_loc_lang == null) second_name_loc_lang = "";
					if (third_name_loc_lang == null) third_name_loc_lang = "";
					if (family_name_loc_lang == null) family_name_loc_lang = "";
					date_of_birth = rset.getString("date_of_birth");

					nationality = rset.getString("nationality");
					if (nationality==null || nationality.equals("null")) nationality="";
					religion = rset.getString("relgn_code");
					if (religion == null) religion = "";
					occupation = rset.getString ("ocpn_code");
					if (occupation == null) occupation = "";
					education = rset.getString("education_level");
					if (education == null) education = "";
					relationship = rset.getString("relationship_to_head");
					if (relationship == null) relationship = "";
					residence = rset.getString("res_area_code");
					if (residence == null) residence = "";

					out.println("<script>						"+frames_list+"document.forms[0].not_patient_name.value=\""+fathername+"\";	"+frames_list+"document.forms[0].not_patient_name_loc_lang.value=\""+fathername_loc_lang+"\";            												"+frames_list+"document.forms[0].not_qid_no.value=\""+alt_id1_no+"\";			"+frames_list+"document.forms[0].not_date_of_birth.value='"+date_of_birth+"';	"+frames_list+"document.forms[0].not_nationality.value='"+nationality+"';		"+frames_list+"document.forms[0].not_nationality_val.value='"+nationality+"';	"+frames_list+"document.forms[0].not_religion.value='"+religion+"';		"+frames_list+"document.forms[0].not_occupation.value='"+occupation+"';		"+frames_list+"document.forms[0].not_gender.value='"+sex+"';				"+frames_list+"document.forms[0].not_gender_val.value='"+sex+"';					"+frames_list+"document.forms[0].not_relationship.value='"+relationship+"';		"+frames_list+"document.forms[0].not_res_area.value='"+residence+"';		"+frames_list+"document.forms[0].not_qid_no.readOnly = true; "+frames_list+"document.forms[0].not_date_of_birth.readOnly = true; "+frames_list+"document.forms[0].not_nationality.disabled = true; "+frames_list+"document.forms[0].not_gender.disabled = true; "+frames_list+"document.forms[0].not_relationship.disabled = true; "+frames_list+"document.forms[0].not_res_area.disabled = true;");												
					out.println("</script>");
				}
				else
				{
					out.println("<script>alert(getMessage('NOT_PATID_INVALID','MP')); "+frames_list+"document.forms[0].not_patient_id.value='';					"+frames_list+"document.forms[0].not_patient_id.focus();					"+frames_list+"document.forms[0].not_patient_name.value='';				"+frames_list+"document.forms[0].not_patient_name_loc_lang.value='';</script>");
				}
			}
            else
            {
				flag = false;                    out.println("<script>alert(getMessage('NOT_PATID_INVALID','MP')); "+frames_list+"document.forms[0].not_patient_id.value='';					"+frames_list+"document.forms[0].not_patient_id.focus();					"+frames_list+"document.forms[0].not_patient_name.value='';					"+frames_list+"document.forms[0].not_patient_name_loc_lang.value='';</script>");
			}                            				
		}
		else if(value1.equals("gr_date_of_birth"))
		{
			String frames_list = "";
			String day_of_week = "";
			frames_list = "parent.frames[1].frames[2].";
			sql = "select hij_date(?),InitCap(to_char(to_date(?,'dd/mm/yyyy'),'day')) day_of_week from dual";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, value2);
			pstmt.setString(2, value2);
			rset = pstmt.executeQuery();
			if(rset.next())
			{
				hj_date = rset.getString(1);
				day_of_week = rset.getString(2);
			}
			out.println("<script>"+frames_list+"document.forms[0].hj_date_of_birth.value='"+hj_date+"'</script>");				
			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body class='MESSAGE' onKeyDown='lockKey()'><script language='javascript'>"+frames_list+"document.getElementById('day_of_week').innerHTML=\"<b>&nbsp;&nbsp;"+day_of_week+"\"</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></body></html>");
		}
		if(rset != null) rset.close();
		if(rset2 != null) rset2.close();
		if(pstmt != null) pstmt.close();		
		if(rset3 != null) rset3.close();
		if(stmt3 != null) stmt3.close();
		if(rset4 != null) rset4.close();
		if(stmt4 != null) stmt4.close();
    }
	catch(Exception e)
	{
		out.println(e.toString());
	}
    finally
    {        
        if(con != null) ConnectionManager.returnConnection(con,request);
    }

%>
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


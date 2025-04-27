<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, webbeans.eCommon.*,java.util.*,javax.servlet.http.*,javax.servlet.jsp.JspWriter " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% 
		String sStyle	= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");     
		String locale	=	 ((String)session.getAttribute("LOCALE"));
		request.setCharacterEncoding("UTF-8");
%>

<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script>
function get_message_text(message,prompt)
{
    var message_text;
    message_text = getMessage(message);
    return message_text;
}
</script>
<%
	String strBodyFrame = request.getParameter("bodyFrame");
	String strSubmitFrame = request.getParameter("submitFrame");
	String op_call =checkForNull(request.getParameter("op_call"));
	String strAlertReqdYn = request.getParameter("alert_reqd_yn");
	String strNameDrvnLogic = request.getParameter("name_dervn_logic");
	String strPatNameAsMultiPart = request.getParameter("pat_name_as_multipart_yn");

	String facilityid=(String)session.getValue("facility_id");
//	String AltId1Type = request.getParameter("AltId1Type");//checkstyle changes - 35886
  //  String AltId2Type = request.getParameter("AltId2Type");
//	String AltId3Type = request.getParameter("AltId3Type");
//	String AltId4Type = request.getParameter("AltId4Type");
	String AcceptOtherAltId = request.getParameter("AcceptOtherAltId");
	webbeans.op.PatientData patdata = new webbeans.op.PatientData();
	boolean continue_yn = true;
%>

<script>
	function clr_flds(){
            
			var op_call = '<%=op_call%>'
			if(op_call=="reg_pat" || op_call=="ae_reg_pat")
				varBodyFrame = "parent.frames[1].frames[0]";
			else
			varBodyFrame = '<%=strBodyFrame%>'
			
				if(eval(varBodyFrame).document.getElementById("patient_name") != null)
				{
					eval(varBodyFrame).document.getElementById("patient_name").value = "";
					eval(varBodyFrame).document.getElementById("patient_name1").innerHTML = "";
				}
				if(eval(varBodyFrame).document.getElementById("patient_name_local_lang") != null)
				{
					eval(varBodyFrame).document.getElementById("patient_name_local_lang").value = "";
					eval(varBodyFrame).document.getElementById("patient_name_local_lang1").innerHTML = "";
				}
 
				if(eval(varBodyFrame).document.getElementById("name_prefix") != null)
				{
					eval(varBodyFrame).document.getElementById("name_prefix").disabled = false
					eval(varBodyFrame).document.getElementById("name_prefix").value = "";
				}
				if(eval(varBodyFrame).document.getElementById("first_name") != null)
				{
					eval(varBodyFrame).document.getElementById("first_name").disabled = false;
					eval(varBodyFrame).document.getElementById("first_name").value = "";
				}
				if(eval(varBodyFrame).document.getElementById("second_name") != null)
				{
					eval(varBodyFrame).document.getElementById("second_name").disabled = false
					eval(varBodyFrame).document.getElementById("second_name").value= "";
				}
				if(eval(varBodyFrame).document.getElementById("third_name") != null)
				{
					eval(varBodyFrame).document.getElementById("third_name").disabled = false;
					eval(varBodyFrame).document.getElementById("third_name").value= "";
				}
				if(eval(varBodyFrame).document.getElementById("family_name") != null)
				{
					eval(varBodyFrame).document.getElementById("family_name").disabled = false;
					eval(varBodyFrame).document.getElementById("family_name").value = "";
				}
				if(eval(varBodyFrame).document.getElementById("name_suffix") != null)
				{
					eval(varBodyFrame).document.getElementById("name_suffix").disabled = false;
					eval(varBodyFrame).document.getElementById("name_suffix").value = "";
				}
	// added for local lang names
				if(eval(varBodyFrame).document.getElementById("first_name_oth_lang") != null)
				{
					eval(varBodyFrame).document.getElementById("first_name_oth_lang").disabled = false;
					eval(varBodyFrame).document.getElementById("first_name_oth_lang").value = "";
				}
				if(eval(varBodyFrame).document.getElementById("second_name_oth_lang") != null)
				{
					eval(varBodyFrame).document.getElementById("second_name_oth_lang").disabled = false
					eval(varBodyFrame).document.getElementById("second_name_oth_lang").value= "";
				}
				if(eval(varBodyFrame).document.getElementById("third_name_oth_lang") != null)
				{
					eval(varBodyFrame).document.getElementById("third_name_oth_lang").disabled = false;
					eval(varBodyFrame).document.getElementById("third_name_oth_lang").value= "";
				}
				if(eval(varBodyFrame).document.getElementById("family_name_oth_lang") != null)
				{
					eval(varBodyFrame).document.getElementById("family_name_oth_lang").disabled = false;
					eval(varBodyFrame).document.getElementById("family_name_oth_lang").value = "";
				}
				if(eval(varBodyFrame).document.getElementById("name_prefix_oth_lang") != null)
				{
					eval(varBodyFrame).document.getElementById("name_prefix_oth_lang").disabled = false;
					eval(varBodyFrame).document.getElementById("name_prefix_oth_lang").value = "";
				}
				
				if(eval(varBodyFrame).document.getElementById("name_suffix_oth_lang") != null)
				{
					eval(varBodyFrame).document.getElementById("name_suffix_oth_lang").disabled = false;
					eval(varBodyFrame).document.getElementById("name_suffix_oth_lang").value = "";
				}


				if(eval(varBodyFrame).document.getElementById("sex") != null)
				{
					eval(varBodyFrame).document.getElementById("sex").disabled = false;
					eval(varBodyFrame).document.getElementById("sex").value = "";
				}
				if(eval(varBodyFrame).document.getElementById("date_of_birth") != null)
				{
					eval(varBodyFrame).document.getElementById("date_of_birth").disabled = false;
					eval(varBodyFrame).document.getElementById("date_of_birth").value= "";
				}
				
				if(eval(varBodyFrame).document.getElementById("b_age") != null)
				{
					eval(varBodyFrame).document.getElementById("b_age").disabled = false;
					eval(varBodyFrame).document.getElementById("b_age").value = "";
				}
				if(eval(varBodyFrame).document.getElementById("b_months") != null)
				{
					eval(varBodyFrame).document.getElementById("b_months").disabled = false;
					eval(varBodyFrame).document.getElementById("b_months").value = "";
				}
				if(eval(varBodyFrame).document.getElementById("b_days") != null)
				{
					eval(varBodyFrame).document.getElementById("b_days").disabled = false;
					eval(varBodyFrame).document.getElementById("b_days").value = "";
				}
				if(eval(varBodyFrame).document.getElementById("dob") != null)
				{
					eval(varBodyFrame).document.getElementById("dob").disabled = false;
					eval(varBodyFrame).document.getElementById("dob").value = "";
				}
				
				if(eval(varBodyFrame).document.getElementById("birth_place") != null)
				{
					eval(varBodyFrame).document.getElementById("birth_place").disabled = false;
					eval(varBodyFrame).document.getElementById("birth_place").value = "";
					eval(varBodyFrame).document.getElementById("Birth_place_code").value = "";
					eval(varBodyFrame).document.getElementById("b_birth").disabled = false;
				}
				if(eval(varBodyFrame).document.getElementById("place_of_birth") != null)
				{
					eval(varBodyFrame).document.getElementById("place_of_birth").disabled = false;
					eval(varBodyFrame).document.getElementById("place_of_birth").value = "";
				}
				if(eval(varBodyFrame).document.getElementById("nationality_desc") != null)
				{
					eval(varBodyFrame).document.getElementById("nationality_desc").disabled = false
					eval(varBodyFrame).document.getElementById("nationality_desc").value = "";
					eval(varBodyFrame).document.getElementById("nationality_code1").value = "";
					eval(varBodyFrame).document.getElementById("nationality_id").disabled = false
					
				}

				if(eval(varBodyFrame).document.getElementById("race_desc") != null)
				{
					//eval(varBodyFrame).document.getElementById("race_code").disabled = false
					eval(varBodyFrame).document.getElementById("race_desc").disabled = false
					eval(varBodyFrame).document.getElementById("race_desc_id").disabled = false
					//eval(varBodyFrame).document.getElementById("race_code").options[0].selected = true
					eval(varBodyFrame).document.getElementById("race_code").value = "";
					eval(varBodyFrame).document.getElementById("race_desc").value = "";
					
					eval(varBodyFrame).document.getElementById("ethnic_group").disabled = false
					//eval(varBodyFrame).loadEthnicSubGroup();
						
				}

				if(eval(varBodyFrame).document.getElementById("nationality_desc") != null)
				{
					eval(varBodyFrame).document.getElementById("nationality_desc").disabled = false
					eval(varBodyFrame).document.getElementById("nationality_desc").value = "";
					eval(varBodyFrame).document.getElementById("nationality_code1").value = "";
					eval(varBodyFrame).document.getElementById("nationality_id").disabled = false
					
				}
				if(eval(varBodyFrame).document.getElementById("citizen_yn")!=null)
				{
				if(eval(varBodyFrame).document.getElementById("citizen_yn") != null)
				{
					eval(varBodyFrame).document.getElementById("citizen_yn").checked = true;		
				}
				if(eval(varBodyFrame).document.getElementById("citizen_yn") != null)
				{
//					eval(varBodyFrame).document.getElementById("citizen_yn")[1].disabled = true;					
				}
				if(eval(varBodyFrame).document.getElementById("legal_yn") != null)
				{
					eval(varBodyFrame).document.getElementById("legal_yn").checked = true;		
					eval(varBodyFrame).document.getElementById("legal_yn").disabled = true;
				}
				if(eval(varBodyFrame).document.getElementById("legal_yn") != null)
				{
//					eval(varBodyFrame).document.getElementById("legal_yn")[1].disabled = true;					
				}
				}
				if(eval(varBodyFrame).document.getElementById("national_id_no") != null)
				{
					eval(varBodyFrame).document.getElementById("national_id_no").disabled = false;
					eval(varBodyFrame).document.getElementById("national_id_no").value = "";
				}
				if(eval(varBodyFrame).document.getElementById("alt_id1_no") != null)
				{
					eval(varBodyFrame).document.getElementById("alt_id1_no").disabled = false;
					eval(varBodyFrame).document.getElementById("alt_id1_no").value = "";
				}
				if(eval(varBodyFrame).document.getElementById("alt_id2_no") != null)
				{
					eval(varBodyFrame).document.getElementById("alt_id2_no").disabled = false;
					eval(varBodyFrame).document.getElementById("alt_id2_no").value = "";
				}
				if(eval(varBodyFrame).document.getElementById("alt_id3_no") != null)
				{
					
					eval(varBodyFrame).document.getElementById("alt_id3_no").disabled = false;
					eval(varBodyFrame).document.getElementById("alt_id3_no").value = "";
				}
				if(eval(varBodyFrame).document.getElementById("alt_id4_no") != null)
				{
					eval(varBodyFrame).document.getElementById("alt_id4_no").disabled = false;
					eval(varBodyFrame).document.getElementById("alt_id4_no").value = "";
				}
				if(eval(varBodyFrame).document.getElementById("alt_id1_exp_date") != null)
				{
					eval(varBodyFrame).document.getElementById("alt_id1_exp_date").disabled = false;
					eval(varBodyFrame).document.getElementById("alt_id1_exp_date").value = "";
					eval(varBodyFrame).document.getElementById("alt_id_exp_dt1").disabled = false;
				}
				if(eval(varBodyFrame).document.getElementById("alt_id2_exp_date") != null)
				{
					eval(varBodyFrame).document.getElementById("alt_id2_exp_date").disabled = false;
					eval(varBodyFrame).document.getElementById("alt_id2_exp_date").value = "";
					eval(varBodyFrame).document.getElementById("alt_id_exp_dt2").disabled = false;
				}
				if(eval(varBodyFrame).document.getElementById("alt_id3_exp_date") != null)
				{
					eval(varBodyFrame).document.getElementById("alt_id3_exp_date").disabled = false;
					eval(varBodyFrame).document.getElementById("alt_id3_exp_date").value = "";
					eval(varBodyFrame).document.getElementById("alt_id_exp_dt3").disabled = false;
				}
				if(eval(varBodyFrame).document.getElementById("alt_id4_exp_date")!= null)
				{
					eval(varBodyFrame).document.getElementById("alt_id4_exp_date").disabled = false;
					eval(varBodyFrame).document.getElementById("alt_id4_exp_date").value = "";
					eval(varBodyFrame).document.getElementById("alt_id_exp_dt4").disabled = false;
				}
				if(eval(varBodyFrame).document.getElementById("other_alt_type")!= null)
				{
					eval(varBodyFrame).document.getElementById("other_alt_type").disabled = false;
					eval(varBodyFrame).document.getElementById("other_alt_type").value = "";
					
				}

		if(eval(varBodyFrame).document.getElementById("other_alt_Id"))
			{
			  eval(varBodyFrame).document.getElementById("other_alt_Id").value = "";
			  eval(varBodyFrame).document.getElementById("other_alt_Id").disabled = false;
			}
	  	   	eval(varBodyFrame).document.forms[0].addr1_type.value					= "";  
			eval(varBodyFrame).document.forms[0].addr_line1.value						= "";
			eval(varBodyFrame).document.forms[0].addr_line2.value						= "";
			eval(varBodyFrame).document.forms[0].addr_line3.value						= "";
			eval(varBodyFrame).document.forms[0].addr_line4.value						= "";
			eval(varBodyFrame).document.forms[0].res_town_code.value			    = "";
			eval(varBodyFrame).document.forms[0].res_area_code.value				= "";
			eval(varBodyFrame).document.forms[0].postal_code.value					= "";
			eval(varBodyFrame).document.forms[0].region_code.value					= "";
			eval(varBodyFrame).document.forms[0].country_code.value				= "";
			eval(varBodyFrame).document.forms[0].contact1_name.value				= "";
			eval(varBodyFrame).document.forms[0].invalid1_yn.value				    = "";
			eval(varBodyFrame).document.forms[0].addr2_type.value					= "";
			eval(varBodyFrame).document.forms[0].mail_addr_line1.value				= "";
			eval(varBodyFrame).document.forms[0].mail_addr_line2.value			= "";
			eval(varBodyFrame).document.forms[0].mail_addr_line3.value			= "";
			eval(varBodyFrame).document.forms[0].mail_addr_line4.value			= "";
			eval(varBodyFrame).document.forms[0].mail_res_town_code.value	= "";
			eval(varBodyFrame).document.forms[0].mail_res_area_code.value	= "";
			eval(varBodyFrame).document.forms[0].mail_postal_code.value	    = "";

			eval(varBodyFrame).document.forms[0].mail_region_code.value		= "";
			eval(varBodyFrame).document.forms[0].mail_country_code.value		= "";

			eval(varBodyFrame).document.forms[0].contact2_name.value		=  "";
			eval(varBodyFrame).document.forms[0].invalid2_yn.value		=  "";

			eval(varBodyFrame).document.forms[0].contact1_no.value		=  "";
			eval(varBodyFrame).document.forms[0].contact2_no.value		=  "";
			eval(varBodyFrame).document.forms[0].email.value		=  "";
			eval(varBodyFrame).document.forms[0].mail_country_desc.value		=  "";
			eval(varBodyFrame).document.forms[0].country_desc.value		=  "";
			/*Added by Thamizh selvi on 30th Jan 2018 against ML-MMOH-CRF-0601 Start*/
			eval(varBodyFrame).document.forms[0].alt_addr_line1.value	= "";
			eval(varBodyFrame).document.forms[0].alt_addr_line2.value	= "";
			eval(varBodyFrame).document.forms[0].alt_addr_line3.value	= "";
			eval(varBodyFrame).document.forms[0].alt_addr_line4.value	= "";
			eval(varBodyFrame).document.forms[0].alt_town_code.value	= "";
			eval(varBodyFrame).document.forms[0].alt_town_desc.value	= "";
			eval(varBodyFrame).document.forms[0].alt_area_code.value	= "";
			eval(varBodyFrame).document.forms[0].alt_area_desc.value	= "";
			eval(varBodyFrame).document.forms[0].alt_postal_code.value	= "";
			eval(varBodyFrame).document.forms[0].alt_postal_desc.value	= "";
			eval(varBodyFrame).document.forms[0].alt_region_code.value	= "";
			eval(varBodyFrame).document.forms[0].alt_region_desc.value	= "";
			eval(varBodyFrame).document.forms[0].alt_country_code.value	= "";
			eval(varBodyFrame).document.forms[0].alt_country_desc.value	= "";
			/*End*/
			}
</script>


<script>
varBodyFrame = '<%=strBodyFrame%>'
					
var prev_set_objs = new Array() ;
function putPatientName()   {

/*    var logic = new String();
   

    logic = document.getElementById("strNameDrvnLogic_one").value;
    var derivedName = new String();
    derivedName = '';
    var logicElements = new Array();
	if(logic !="")
	{
    logicElements = logic.split('!');
	}
    var i=0;

    for ( i=0;i<logicElements.length;i++)
    {
        if ( logicElements[i] == '1N' && eval(varBodyFrame).document.getElementById("first_name") != null)
        {
            if ( eval(varBodyFrame).document.getElementById("first_name").value != '' )
                derivedName = derivedName + eval(varBodyFrame).document.getElementById("first_name").value;
        }
        else if ( logicElements[i] == '2N' && eval(varBodyFrame).document.getElementById("second_name") != null )
        {
            if ( eval(varBodyFrame).document.getElementById("second_name").value != '' )
                derivedName = derivedName + eval(varBodyFrame).document.getElementById("second_name").value;
        }
        else if ( logicElements[i] == '3N' && eval(varBodyFrame).document.getElementById("third_name") != null)
        {
            if ( eval(varBodyFrame).document.getElementById("third_name").value != '' )
                derivedName = derivedName + eval(varBodyFrame).document.getElementById("third_name").value;
        }
        else if ( logicElements[i] == 'FN' && eval(varBodyFrame).document.getElementById("family_name") != null)
        {
			
            if ( eval(varBodyFrame).document.getElementById("family_name").value != '' )
                derivedName = derivedName + eval(varBodyFrame).document.getElementById("family_name").value;
        }
        else if ( logicElements[i] == 'PR' && eval(varBodyFrame).document.getElementById("name_prefix") != null)
        {
			
            if ( eval(varBodyFrame).document.getElementById("name_prefix").value != '' )
                derivedName = derivedName + eval(varBodyFrame).document.getElementById("name_prefix").value;
        }
        else if ( logicElements[i] == 'SF' && eval(varBodyFrame).document.getElementById("name_suffix") != null)
        {
            if ( eval(varBodyFrame).document.getElementById("name_suffix").value != '' )
                derivedName = derivedName + eval(varBodyFrame).document.getElementById("name_suffix").value;
        }
        else
        {
            if ( logicElements[i] != '1N' &&  logicElements[i] != '2N' && logicElements[i] != '3N' && logicElements[i] != 'FN' && logicElements[i] != 'PR' && logicElements[i] != 'SF' )
            {
                var arLen = logicElements[i].length;
                var tempVal = logicElements[i].substring(1,arLen - 1);
                derivedName = derivedName + tempVal;
            }
        }
    }
	if (eval(varBodyFrame).document.getElementById("pat_name_as_multipart_yn").value=="Y")
	{
		if ( derivedName.length >= 40 )
			derivedName = derivedName.substr(0,40);			
	}
	else
	{
		if ( derivedName.length >= 60 )
			derivedName = derivedName.substr(0,60);
	}
	var derievedName1 = derivedName.split(',');
	if(derievedName1[1] == ' ')
	{
		derivedName = 	derievedName1[0];
	}
   
	eval(varBodyFrame).document.getElementById("patient_name1").innerHTML = "<b>"+derivedName;
	eval(varBodyFrame).document.getElementById("patient_name").value =derivedName;
	*/	
}
</script>
<input type='hidden' name='alert_reqd_yn' id='alert_reqd_yn' value="<%=strAlertReqdYn%>">
<input type='hidden' name='strNameDrvnLogic_one' id='strNameDrvnLogic_one' value="<%=strNameDrvnLogic%>">
    <input type='hidden' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value="<%=strPatNameAsMultiPart%>" >

<%
	Connection con = ConnectionManager.getConnection(request);
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs1 = null;
	//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 09/01/2013
	Statement stmt = null;
	ResultSet rset = null;
%>

<!-- @Get the Patient Id and Check the Status of the Patient -->
	<%
		patdata.setFacility_id(facilityid);
	String pat_id = request.getParameter("pat_id");	
	
	
    String patientIdStatus = patdata.CheckStatus(con,pat_id);			
	
	String In_patient_status =  "";
	String alternateIdStatus = "";
	
%>
<%
%>
<%
		String	 	strNamePrefix			= "";
		String	 	strFirstName			= "";
		String	 	strSecondName		= "";
		String		strThirdName			= "";
		String	 	strFamilyName			= "";
		String 	strNameSuffix			= "";
		
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


			String	 a_res_addr_line1 = "";
			String a_res_addr_line2 = "";
			String a_res_addr_line3 = "";
			String a_res_addr_line4 = "";
			String a_country_code  = "";
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
			String m_country_code  = "";
			String m_res_area_code = "";
			String m_res_area_desc = "";
			String m_res_town2_code = "";
			String m_res_town2_desc = "";
			String m_res_region_code = "";
			String m_res_region_desc = "";

			/*Added by Thamizh selvi on 30th Jan 2018 against ML-MMOH-CRF-0601 Start*/
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
	/*Below variable declare for this CRF [RUT-CRF-0011]*/
			String patcat_code="";
			String patcat_desc="";
			String language_id ="";
			String language_desc="";


%>
<!-- @SQL Query Used -->
<%
//String sql = "Select a.patient_id,name_prefix,first_name,second_name,third_name,family_name_prefix,family_name, name_suffix,patient_name,national_id_no,alt_id1_type,nvl(alt_id1_no,'')alt_id1_no,alt_id2_type,nvl(alt_id2_no,'')alt_id2_no,alt_id3_type,nvl(alt_id3_no,'')alt_id3_no,alt_id4_type,nvl(alt_id4_no,'')alt_id4_no,to_char(alt_id1_exp_date,'dd/mm/yyyy') alt_id1_exp_date,to_char(alt_id2_exp_date,'dd/mm/yyyy')alt_id2_exp_date,to_char(alt_id3_exp_date,'dd/mm/yyyy')alt_id3_exp_date,to_char(alt_id4_exp_date,'dd/mm/yyyy')alt_id4_exp_date,oth_alt_id_type,nvl(oth_alt_id_no,'')oth_alt_id_no,sex,to_char(date_of_birth,'dd/mm/yyyy') date_of_birth, nvl(a.nationality_code,'') nationality_code,c.long_desc nationality_desc,contact1_no primary_resi_no, contact2_no Other_Resi_No,nvl(active_yn,'N') active_yn,nvl(suspend_yn,'N') suspend_yn, nvl(deceased_yn,'N')  deceased_yn  , b.addr1_line1,b.addr1_line2,b.addr1_line3,b.addr1_line4,pref_facility_id,  calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1) y,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),2) m,calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),3) d ,  citizen_yn , legal_yn, national_id_no,a.pat_dtls_unknown_yn,a.RACE_CODE,(select long_desc  from mp_ethnic_group where ethnic_group_code= a.ethnic_grp_code) ethnic_desc,a.ETHNIC_GRP_CODE,a.PLACE_OF_BIRTH,a.birth_place_code,(select long_desc  from MP_BIRTH_PLACE where birth_place_code= a.Birth_place_code) birth_place_desc   from mp_patient a, mp_pat_addresses b,mp_country c  where a.patient_id = '"+pat_id+"'  and a.patient_id = b.patient_id  and a.nationality_code = c.country_code (+)";


				 
				 
	/*String sql = "SELECT  "+
				 "        a.name_prefix,"+
				 "        a.patient_name,"+
				 "        a.first_name,"+
				 "        a.second_name,"+
				 "        a.third_name,"+
				 "        a.family_name_prefix,"+
				 "        a.family_name,"+
				 "        a.name_suffix,"+
				 "        a.national_id_no,"+
				 "        NVL(a.alt_id1_no,'') alt_id1_no,"+
				 "        a.alt_id2_type,"+
				 "        NVL(alt_id2_no,'') alt_id2_no,"+
				 "        a.alt_id3_type,"+
				 "        NVL(a.alt_id3_no,'') alt_id3_no,"+
				 "        a.alt_id4_type,"+
				 "        NVL(a.alt_id4_no,'') alt_id4_no,"+
				 "        TO_CHAR(a.alt_id1_exp_date,'dd/mm/yyyy') alt_id1_exp_date,"+
				 "        TO_CHAR(a.alt_id2_exp_date,'dd/mm/yyyy') alt_id2_exp_date,"+
				 "        TO_CHAR(a.alt_id3_exp_date,'dd/mm/yyyy') alt_id3_exp_date,"+
				 "        TO_CHAR(a.alt_id4_exp_date,'dd/mm/yyyy') alt_id4_exp_date,"+
				 "        a.oth_alt_id_type,"+
				 "        NVL(a.oth_alt_id_no,'') oth_alt_id_no,"+
				 "        a.sex,"+
				 "        TO_CHAR(a.date_of_birth,'dd/mm/yyyy') date_of_birth,"+
				 "        NVL(a.nationality_code,'') nationality_code,"+
				 "        mp_get_desc.MP_COUNTRY(nationality_code,'"+locale+"','3') nationality_desc,"+
				 "        contact1_no primary_resi_no,"+
				 "        contact2_no other_resi_no,"+
				 "        NVL(active_yn,'N') active_yn,"+
				 "        NVL(suspend_yn,'N') suspend_yn,"+
				 "        NVL(deceased_yn,'N') deceased_yn,"+
				 "        CALCULATE_AGE(TO_CHAR(a.date_of_birth,'dd/mm/yyyy'),1) y,"+
				 "        CALCULATE_AGE(TO_CHAR(a.date_of_birth,'dd/mm/yyyy'),2) m,"+
				 "        CALCULATE_AGE(TO_CHAR(a.date_of_birth,'dd/mm/yyyy'),3) d,"+
				 "        a.citizen_yn,"+
				 "        a.legal_yn,"+
				 "        a.pat_dtls_unknown_yn,"+
				 "        a.race_code,mp_get_desc.MP_RACE(a.race_code,'"+locale+"',1) race_desc,"+
				 "        mp_get_desc.MP_ETHNIC_GROUP(a.ethnic_grp_code,'"+locale+"','1') ethnic_desc,"+
				 "        a.ethnic_grp_code,"+
				 "        a.place_of_birth,"+
				 "        a.birth_place_code,"+
				 "        mp_get_desc.MP_BIRTH_PLACE(a.birth_place_code,'"+locale+"','1') birth_place_desc"+
				 ",a.family_name_loc_lang, a.third_name_loc_lang, a.second_name_loc_lang, a.first_name_loc_lang, a.name_suffix_loc_lang, a.patient_name_loc_lang,a.name_prefix_loc_lang"+
				 " FROM   mp_patient a,"+
				 "        mp_pat_addresses b"+
				 " WHERE  a.patient_id = '"+pat_id+"'"+
				 "        AND a.patient_id = b.patient_id";*/		

/*get the patient Category, Above Query Commented and below query Modified for this RUT-CRF-0011*/
/*String sql = "SELECT  "+
				 "        a.name_prefix,"+
				 "        a.patient_name,"+
				 "        a.first_name,"+
				 "        a.second_name,"+
				 "        a.third_name,"+
				 "        a.family_name_prefix,"+
				 "        a.family_name,"+
				 "        a.name_suffix,"+
				 "        a.national_id_no,"+
				 "        NVL(a.alt_id1_no,'') alt_id1_no,"+
				 "        a.alt_id2_type,"+
				 "        NVL(alt_id2_no,'') alt_id2_no,"+
				 "        a.alt_id3_type,"+
				 "        NVL(a.alt_id3_no,'') alt_id3_no,"+
				 "        a.alt_id4_type,"+
				 "        NVL(a.alt_id4_no,'') alt_id4_no,"+
				 "        TO_CHAR(a.alt_id1_exp_date,'dd/mm/yyyy') alt_id1_exp_date,"+
				 "        TO_CHAR(a.alt_id2_exp_date,'dd/mm/yyyy') alt_id2_exp_date,"+
				 "        TO_CHAR(a.alt_id3_exp_date,'dd/mm/yyyy') alt_id3_exp_date,"+
				 "        TO_CHAR(a.alt_id4_exp_date,'dd/mm/yyyy') alt_id4_exp_date,"+
				 "        a.oth_alt_id_type,"+
				 "        NVL(a.oth_alt_id_no,'') oth_alt_id_no,"+
				 "        a.sex,"+
				 "        TO_CHAR(a.date_of_birth,'dd/mm/yyyy') date_of_birth,"+
				 "        NVL(a.nationality_code,'') nationality_code,"+
				 "        mp_get_desc.MP_COUNTRY(nationality_code,'"+locale+"','3') nationality_desc,"+
				 "        contact1_no primary_resi_no,"+
				 "        contact2_no other_resi_no,"+
				 "        NVL(active_yn,'N') active_yn,"+
				 "        NVL(suspend_yn,'N') suspend_yn,"+
				 "        NVL(deceased_yn,'N') deceased_yn,"+
				 "        CALCULATE_AGE(TO_CHAR(a.date_of_birth,'dd/mm/yyyy'),1) y,"+
				 "        CALCULATE_AGE(TO_CHAR(a.date_of_birth,'dd/mm/yyyy'),2) m,"+
				 "        CALCULATE_AGE(TO_CHAR(a.date_of_birth,'dd/mm/yyyy'),3) d,"+
				 "        a.citizen_yn,"+
				 "        a.legal_yn,"+
				 "        a.pat_dtls_unknown_yn,"+
				 "        a.pat_cat_code,mp_get_desc.MP_PAT_CATEGORY(a.pat_cat_code,'"+locale+"',2) pat_cat_desc,"+
				 "        a.race_code,mp_get_desc.MP_RACE(a.race_code,'"+locale+"',1) race_desc,"+
				 "        mp_get_desc.MP_ETHNIC_GROUP(a.ethnic_grp_code,'"+locale+"','1') ethnic_desc,"+
				 "        a.ethnic_grp_code,"+
				 "        a.place_of_birth,"+
				 "        a.birth_place_code,"+
				 "        mp_get_desc.MP_BIRTH_PLACE(a.birth_place_code,'"+locale+"','1') birth_place_desc"+
				 ",a.family_name_loc_lang, a.third_name_loc_lang, a.second_name_loc_lang, a.first_name_loc_lang, a.name_suffix_loc_lang, a.patient_name_loc_lang,a.name_prefix_loc_lang"+
				 ",language_id,mp_get_desc.MP_LANGUAGE(language_id,'"+locale+"',1)language_desc,a.patient_name_long,a.patient_name_loc_lang_long"+
				 " FROM   mp_patient a,"+
				 "        mp_pat_addresses b"+
				 " WHERE  a.patient_id = '"+pat_id+"'"+
				 "        AND a.patient_id = b.patient_id";		 
				 
				 */

				 String sql = "SELECT a.name_prefix, a.patient_name, a.first_name, a.second_name,a.third_name, a.family_name_prefix, a.family_name, a.name_suffix,       a.national_id_no, NVL (a.alt_id1_no, '') alt_id1_no, a.alt_id2_type, NVL (alt_id2_no, '') alt_id2_no, a.alt_id3_type, NVL (a.alt_id3_no, '') alt_id3_no, a.alt_id4_type,       NVL (a.alt_id4_no, '') alt_id4_no, TO_CHAR (a.alt_id1_exp_date, 'dd/mm/yyyy') alt_id1_exp_date, TO_CHAR (a.alt_id2_exp_date, 'dd/mm/yyyy') alt_id2_exp_date,       TO_CHAR (a.alt_id3_exp_date, 'dd/mm/yyyy') alt_id3_exp_date, TO_CHAR (a.alt_id4_exp_date, 'dd/mm/yyyy') alt_id4_exp_date, a.oth_alt_id_type, NVL (a.oth_alt_id_no, '') oth_alt_id_no, a.sex,TO_CHAR (a.date_of_birth, 'dd/mm/yyyy') date_of_birth,NVL (a.nationality_code, '') nationality_code,       mp_get_desc.mp_country (nationality_code,'"+locale+"','3' ) nationality_desc, contact1_no primary_resi_no, contact2_no other_resi_no, NVL (active_yn, 'N') active_yn, NVL (suspend_yn, 'N') suspend_yn, NVL (deceased_yn, 'N') deceased_yn,calculate_age (TO_CHAR (a.date_of_birth, 'dd/mm/yyyy'), 1) y,       calculate_age (TO_CHAR (a.date_of_birth, 'dd/mm/yyyy'), 2) m,calculate_age (TO_CHAR (a.date_of_birth, 'dd/mm/yyyy'), 3) d,a.citizen_yn, a.legal_yn, a.pat_dtls_unknown_yn, a.pat_cat_code, mp_get_desc.mp_pat_category (a.pat_cat_code, '"+locale+"',  2 ) pat_cat_desc,  a.race_code,  mp_get_desc.mp_race (a.race_code, '"+locale+"', 1) race_desc, mp_get_desc.mp_ethnic_group (a.ethnic_grp_code,  '"+locale+"',  '1'    ) ethnic_desc,  a.ethnic_grp_code, a.place_of_birth, a.birth_place_code,  mp_get_desc.mp_birth_place (a.birth_place_code,  '"+locale+"',  '1'  ) birth_place_desc,    a.family_name_loc_lang, a.third_name_loc_lang, a.second_name_loc_lang,  a.first_name_loc_lang, a.name_suffix_loc_lang, a.patient_name_loc_lang, a.name_prefix_loc_lang, language_id, mp_get_desc.mp_language (language_id, '"+locale+"', 1) language_desc,  a.patient_long_name, a.patient_long_name_loc_lang  FROM mp_patient a, mp_pat_addresses b WHERE a.patient_id = '"+pat_id+"' AND a.patient_id = b.patient_id";
				 
%>

<%
        
         
		pstmt = con.prepareStatement(sql) ;
		
		rs      = pstmt.executeQuery() ;
%>

<%
	if(rs != null)
	{
		while(rs.next())
		{
			
			strNamePrefix			= rs.getString("name_prefix");
			strFirstName			= rs.getString("first_name");
			strSecondName		= rs.getString("second_name");
			strThirdName			= rs.getString("third_name");
			strFamilyName			= rs.getString("family_name");
			strNameSuffix			= rs.getString("name_suffix");

			patient_name	=checkForNull(rs.getString("patient_name"));
			patient_name_loc_lang		=checkForNull(rs.getString("patient_name_loc_lang"));
			name_prefix_loc_lang		=checkForNull(rs.getString("name_prefix_loc_lang"));
			patient_long_name		=checkForNull(rs.getString("patient_long_name"));
			patient_long_name_loc_lang		=checkForNull(rs.getString("patient_long_name_loc_lang"));
			first_name_loc_lang		=checkForNull(rs.getString("first_name_loc_lang"));
			second_name_loc_lang		=checkForNull(rs.getString("second_name_loc_lang"));
			third_name_loc_lang		= checkForNull(rs.getString("third_name_loc_lang"));
			family_name_loc_lang		=checkForNull(rs.getString("family_name_loc_lang"));
			name_suffix_loc_lang		=checkForNull(rs.getString("name_suffix_loc_lang"));
			
			patcat_code		=checkForNull(rs.getString("pat_cat_code"));			
			patcat_desc		=checkForNull(rs.getString("pat_cat_desc"));
			strNatIdNo				= checkForNull(rs.getString("national_id_no"));
			AltId1No					= checkForNull(rs.getString("alt_id1_no"));
			AltId2No					= checkForNull(rs.getString("alt_id2_no"));
			AltId3No					= checkForNull(rs.getString("alt_id3_no"));
			AltId4No					= checkForNull(rs.getString("alt_id4_no"));

			alt_id1_exp_date     = checkForNull(rs.getString("alt_id1_exp_date"));
			alt_id2_exp_date     = checkForNull(rs.getString("alt_id2_exp_date"));
			alt_id3_exp_date     = checkForNull(rs.getString("alt_id3_exp_date"));
			alt_id4_exp_date     = checkForNull(rs.getString("alt_id4_exp_date"));

			if ( !localeName.equals("en") )
			{ 
				if (!alt_id1_exp_date.equals(""))
						alt_id1_exp_date= DateUtils.convertDate(alt_id1_exp_date,"DMY","en",localeName);
				if (!alt_id2_exp_date.equals(""))
						alt_id2_exp_date= DateUtils.convertDate(alt_id2_exp_date,"DMY","en",localeName);
				if (!alt_id3_exp_date.equals(""))
						alt_id3_exp_date= DateUtils.convertDate(alt_id3_exp_date,"DMY","en",localeName);
				if (!alt_id4_exp_date.equals(""))
						alt_id4_exp_date= DateUtils.convertDate(alt_id4_exp_date,"DMY","en",localeName);
			}

		

			OtherAltIdType		= rs.getString("oth_alt_id_type");
			OtherAltIdNo			= checkForNull(rs.getString("oth_alt_id_no"));
			strSex					= rs.getString("sex");
			strDateOfBirth			= rs.getString("date_of_birth");
			
			if (!strDateOfBirth.equals(""))
			{
				if(!localeName.equals("en"))
				{ 	
					strDateOfBirth= DateUtils.convertDate(strDateOfBirth,"DMY","en",localeName);
				}
			}

			strNationalityCode    = rs.getString("nationality_code");
			strNationalityDesc	= checkForNull(rs.getString("nationality_desc"));
			strPrimaryResNo		= rs.getString("primary_resi_no");
			strOtherResNo			= rs.getString("Other_Resi_No");
			strYear					= rs.getString("y");
			strMonth					= rs.getString("m");
			strDays					= rs.getString("d");
			strCitizenYN			= rs.getString("citizen_yn");
			strLegalYN				= rs.getString("legal_yn");	
			strRaceCd				= rs.getString("RACE_CODE");
			strRaceDesc				= rs.getString("race_desc");
			strEthnicGrpCd			= rs.getString("ETHNIC_GRP_CODE");
			strBirthPldesc			= rs.getString("BIRTH_PLACE_DESC");
			birth_place_code		= rs.getString("BIRTH_PLACE_CODE");
			place_of_birth			= rs.getString("PLACE_OF_BIRTH");
			ethnic_desc			= rs.getString("ethnic_desc");
			strPatdtlsUnknownYN = rs.getString("pat_dtls_unknown_yn");
			language_id	= checkForNull(rs.getString("language_id"));
			language_desc	= checkForNull(rs.getString("language_desc"));
		}
	}
	
	if(pstmt != null)pstmt.close();
	if(rs!=null) rs.close();

	
	String strContact = "SELECT a.addr1_line1,"+
								 "        a.addr1_line2,"+
								 "        a.addr1_line3,"+
								 "        a.addr1_line4,"+
								 "        a.postal1_code,"+
								 "        mp_get_desc.MP_POSTAL_CODE(a.postal1_code,'"+locale+"',2) postal_desc,"+
								 "        a.country1_code,"+
								 "        mp_get_desc.MP_COUNTRY(a.country1_code,'"+locale+"','1') country_desc_1,"+
								 "        a.contact1_name,"+
								 "        mp_get_desc.MP_RES_AREA(b.res_area_code,'"+locale+"','1') res_area,"+
								 "        b.res_area_code,"+
								 "        mp_get_desc.MP_RES_TOWN(b.res_town_code,'"+locale+"','1') res_town,"+
								 "        b.res_town_code,"+
								 "        mp_get_desc.MP_REGION(b.region_code,'"+locale+"','1') region,"+
								 "        b.region_code,"+
								 "        a.addr2_line1,"+
								 "        a.addr2_line2,"+
								 "        a.addr2_line3,"+
								 "        a.addr2_line4,"+
								 "        a.postal2_code,"+
								 "        mp_get_desc.MP_POSTAL_CODE(a.postal2_code,'"+locale+"',2) postal2_desc,"+
								 "        a.country2_code,"+
								 "        mp_get_desc.MP_COUNTRY(a.country2_code,'"+locale+"','1') country_desc_2,"+
								 "        a.contact2_name,"+
								 "        mp_get_desc.MP_RES_AREA(a.res_area2_code,'"+locale+"','1') res_area2,"+
								 "        a.res_area2_code,"+
								 "        mp_get_desc.MP_RES_TOWN(a.res_town2_code,'"+locale+"','1') res_town2,"+
								 "        a.res_town2_code,"+
								 "        mp_get_desc.MP_REGION(a.region2_code,'"+locale+"','1') region2_desc,"+
								 "        a.region2_code,"+
								 "        b.contact1_no,"+
								 "        b.contact2_no,"+
								 "        b.email_id,"+
								 "        a.alt_addr_line1,"+
								 "        a.alt_addr_line2,"+
								 "        a.alt_addr_line3,"+
								 "        a.alt_addr_line4,"+
								 "        a.alt_postal_code,"+
								 "        mp_get_desc.MP_POSTAL_CODE(a.alt_postal_code,'"+locale+"',2) alt_postal_desc,"+
								 "        a.alt_country_code,"+
								 "        mp_get_desc.MP_COUNTRY(a.alt_country_code,'"+locale+"','1') alt_country_desc,"+
								 "        a.alt_area_code,"+
								 "        mp_get_desc.MP_RES_AREA(a.alt_area_code,'"+locale+"','1') alt_area_desc,"+
								 "        a.alt_town_code,"+
								 "        mp_get_desc.MP_RES_TOWN(a.alt_town_code,'"+locale+"','1') alt_town_desc,"+
								 "        a.alt_region_code,"+
								 "        mp_get_desc.MP_REGION(a.alt_region_code,'"+locale+"','1') alt_region_desc"+
								 " FROM   mp_pat_addresses a,"+
								 "        mp_patient b"+
								 " WHERE  b.patient_id = a.patient_id"+
								 "        AND b.patient_id = '"+pat_id+"'";//Modified by Thamizh selvi on 30th Jan 2018 against ML-MMOH-CRF-0601

	
	pstmt = con.prepareStatement(strContact) ;
	rs      = pstmt.executeQuery() ; 
	
	if(rs != null)
	{
		while(rs.next())
		{
			a_res_addr_line1 = rs.getString("addr1_line1");
			a_res_addr_line2 = rs.getString("addr1_line2");
			a_res_addr_line3 = rs.getString("addr1_line3");
			a_res_addr_line4 = rs.getString("addr1_line4");
			a_country_code  = rs.getString("country1_code");
			a_postal_code    = rs.getString("postal1_code");
			postal2_desc    = rs.getString("postal2_desc");
			postal_desc    = rs.getString("postal_desc");
			
			a_res_area_code		= rs.getString("res_area_code");
			a_res_area				= rs.getString("res_area");			
			a_res_town2_code	= rs.getString("res_town_code");
			a_res_town2_desc	= rs.getString("res_town");
			a_res_region_code	= rs.getString("region_code");
			a_res_region_desc	= rs.getString("region");			

			m_res_addr_line1		= rs.getString("addr2_line1");
			m_res_addr_line2		= rs.getString("addr2_line2");
			m_res_addr_line3		= rs.getString("addr2_line3");
			m_res_addr_line4		= rs.getString("addr2_line4");
			m_postal_code			= rs.getString("postal2_code");
			m_country_code		= rs.getString("country2_code");
			m_res_area_code		= rs.getString("res_area2_code");
			m_res_area_desc		= rs.getString("res_area2");
			m_res_town2_code	= rs.getString("res_town2_code");
			m_res_town2_desc	= rs.getString("res_town2");
			m_res_region_code	= rs.getString("region2_code");
			m_res_region_desc	= rs.getString("region2_desc");
			strPrimaryResNo		= rs.getString("CONTACT1_NO");
			strOtherResNo			= rs.getString("CONTACT2_NO");
			strEmail					= rs.getString("EMAIL_ID");	
			a_country_desc		= rs.getString("country_desc_1");	
			m_country_desc		= rs.getString("country_desc_2");
			
			/*Added by Thamizh selvi on 30th Jan 2018 against ML-MMOH-CRF-0601 Start*/
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
		}
	}

	
			if(a_res_addr_line1 == null)a_res_addr_line1="";
			if(a_res_addr_line2 == null)a_res_addr_line2="";
			if(a_res_addr_line3 == null)a_res_addr_line3="";
			if(a_res_addr_line4 == null)a_res_addr_line4="";
			if(a_country_code == null)a_country_code="";
			if(a_postal_code == null)a_postal_code="";
			if(postal_desc == null)postal_desc="";
			if(postal2_desc == null)postal2_desc="";
			if(a_res_area_code == null)a_res_area_code="";
			if(a_res_area == null)a_res_area="";
			if(a_res_town2_code == null)a_res_town2_code="";
			if(a_res_town2_desc == null)a_res_town2_desc="";
			if(a_res_region_code == null)a_res_region_code="";
			if(a_res_region_desc == null)a_res_region_desc="";
			if(m_res_addr_line1 == null)m_res_addr_line1="";
			if(m_res_addr_line2 == null)m_res_addr_line2="";
			if(m_res_addr_line3 == null)m_res_addr_line3="";
			if(m_res_addr_line4 == null)m_res_addr_line4="";
			if(m_postal_code == null)m_postal_code="";
			if(m_country_code == null)m_country_code="";
			if(m_res_area_code == null)m_res_area_code="";
			if(m_res_area_desc == null)m_res_area_desc="";
			if(m_res_town2_code == null)m_res_town2_code="";
			if(m_res_town2_desc == null)m_res_town2_desc="";
			if(m_res_region_code == null)m_res_region_code="";
			if(m_res_region_desc == null)m_res_region_desc="";
			if(strPrimaryResNo == null)strPrimaryResNo="";
			if(strOtherResNo == null)strOtherResNo="";
			if(strEmail == null)strEmail="";

			if(a_country_desc == null)a_country_desc="";
			if(m_country_desc == null)m_country_desc="";
			if(strRaceCd == null)strRaceCd="";
			if(strRaceDesc == null)strRaceDesc="";
			if(strEthnicGrpCd == null)strEthnicGrpCd="";
			if(birth_place_code == null)birth_place_code="";
			if(place_of_birth == null)place_of_birth="";
			if(strBirthPldesc == null)strBirthPldesc="";
			if(ethnic_desc == null)ethnic_desc="";
			if(strEmail == null)strEmail="";
			
%>

<script>

varBodyFrame = '<%=strBodyFrame%>'
var op_call = '<%=op_call%>'
if(op_call=="reg_pat" || op_call == "ae_reg_pat")
  varBodyFrame = "parent.frames[1].frames[0]"
var invFlg='F';

var varFlag = true;
varSubmitFrame = '<%=strSubmitFrame%>'
var op_call = '<%=op_call%>'
if(op_call == "reg_pat" || op_call =="ae_reg_pat")
  varSubmitFrame = "parent.frames[2]"

<%

	//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 24/01/2013
	//Start
	
	if(op_call.equals("IP_BOOKING"))
	{
	try
		{
		String ot_sql="SELECT a.order_id order_id,c.order_line_no order_line_no,b.oper_code oper_code,b.short_desc oper_desc, TO_CHAR (a.pref_surg_date, 'dd/mm/yyyy') pref_surg_date   FROM ot_pending_orders_vw a, ot_oper_mast_lang_vw b ,ot_pending_order_line c WHERE a.language_id = '"+locale+"'  AND b.language_id = '"+locale+"' AND a.performing_facility_id = '"+facilityid+"' and b.order_catalog_code=c.order_catalog_code  and a.order_id=c.order_id  AND b.order_catalog_code IN (SELECT order_catalog_code   FROM ot_pending_order_line WHERE order_id = a.order_id AND ROWNUM = 1)  AND a.pref_surg_date BETWEEN TO_DATE (NVL (to_char(SYSDATE,'DD/MM/YYYY'), '01/01/1900') || '00:00','DD/MM/YYYY HH24:MI') AND TO_DATE (NVL ('', '01/01/3000') || '23:59','DD/MM/YYYY HH24:MI') and a.order_id not in (select order_id from ip_booking_list where patient_id='"+pat_id+"' and facility_id='"+facilityid+"'and order_id is not null) and a.patient_id='"+pat_id+"'";
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rset=stmt.executeQuery(ot_sql);
		}
	catch(SQLException e)	
		{
		//System.out.println("Exception occurred while executing the query to get Surgery Order Details : "+e);
		e.printStackTrace();
		}
	try
		{
		if(rset!=null)
			{
			rset.last();
			int ot_order_cnt=rset.getRow();
			rset.beforeFirst();
			if(ot_order_cnt==1)
				{
				rset.next();
				%>
				eval(varBodyFrame).document.getElementById("surgery_order_id").value="<%=rset.getString("order_id")%>";
				eval(varBodyFrame).document.getElementById("surgery_order_line_no").value="<%=rset.getString("order_line_no")%>";
				eval(varBodyFrame).document.getElementById("surgery_order").value="<%=rset.getString("oper_desc")%>";
				eval(varBodyFrame).document.getElementById("surgery_order_code").value="<%=rset.getString("oper_code")%>";
				eval(varBodyFrame).document.getElementById("surgery_order_date").value="<%=com.ehis.util.DateUtils.convertDate(rset.getString("pref_surg_date"),"DMY","en",locale)%>";
				eval(varBodyFrame).document.getElementById('surgery_order_dt_id').innerHTML="<%=com.ehis.util.DateUtils.convertDate(rset.getString("pref_surg_date"),"DMY","en",locale)%>";
				eval(varBodyFrame).document.getElementById("surgery_order_desc_hid").value="<%=rset.getString("oper_desc")%>";//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
				//eval(varBodyFrame).document.getElementById("surgery_order_name").disabled=true;//Maheshwaran K commented for the Inci No : RUT-SCF-0258 [IN:039356] as on 15/04/2013
				<%
				}
			else
				{
				%>
				eval(varBodyFrame).document.getElementById("surgery_order_id").value="";
				eval(varBodyFrame).document.getElementById("surgery_order_line_no").value="";
				eval(varBodyFrame).document.getElementById("surgery_order").value="";
				eval(varBodyFrame).document.getElementById("surgery_order_desc_hid").value="";//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
				eval(varBodyFrame).document.getElementById("surgery_order_code").value="";
				eval(varBodyFrame).document.getElementById("surgery_order_date").value="";
				eval(varBodyFrame).document.getElementById('surgery_order_dt_id').innerHTML="";
				eval(varBodyFrame).document.getElementById("surgery_order_name").disabled=false;
				<%
				}
			}
		stmt.close();
		rset.close();
		}
	catch(SQLException e)	
		{
		//System.out.println("Exception occurred while getting the Surgery Order Details  : "+e);
		e.printStackTrace();
		}	
	finally
		{
		try
			{if(stmt!=null)
			stmt.close();
			}
		catch(Exception e)	
			{}
		}
	}
	//End
	if(patientIdStatus != ""){

			if (patientIdStatus.equals("BLACKLISTED_PATIENT")){
				continue_yn = false;
%>
				alert(getMessage('BLACKLISTED_PATIENT','MP'));
				varFlag = false;
				eval(varBodyFrame).document.getElementById("patient_id").value = "";
				if(eval(varBodyFrame).document.getElementById("patient_id").readOnly == false && eval(varBodyFrame).document.getElementById("patient_id").disabled == false)
				{
					eval(varBodyFrame).document.getElementById("patient_id").focus();
				}
<%			
			}else if (patientIdStatus.equals("SUSPENDED")){
				continue_yn = false;
%>
				alert(getMessage('PAT_SUSPENDED_NOT_ALLOWED','MP'));
				varFlag = false;
				eval(varBodyFrame).document.getElementById("patient_id").value = "";
				if(eval(varBodyFrame).document.getElementById("patient_id").readOnly == false && eval(varBodyFrame).document.getElementById("patient_id").disabled == false)
				{
					eval(varBodyFrame).document.getElementById("patient_id").focus();
				}
<%
			}else if (patientIdStatus.equals("DECEASED")){
				continue_yn = false;
%>
				alert(getMessage('PAT_DECEASED_NOT_ALLOWED','MP'));
				varFlag = false;			
				eval(varBodyFrame).document.getElementById("patient_id").value = "";
				if(eval(varBodyFrame).document.getElementById("patient_id").readOnly == false && eval(varBodyFrame).document.getElementById("patient_id").disabled == false)
				{
					eval(varBodyFrame).document.getElementById("patient_id").focus();
				}
<%
			}else if (patientIdStatus.equals("INACTIVE")){
				continue_yn = false;
%>
				alert(getMessage('PAT_INACTIVE_NOT_ALLOWED','MP'));				
				varFlag = false;		
				eval(varBodyFrame).document.getElementById("patient_id").value = "";
				if(eval(varBodyFrame).document.getElementById("patient_id").readOnly == false && eval(varBodyFrame).document.getElementById("patient_id").disabled == false)
				{
					eval(varBodyFrame).document.getElementById("patient_id").focus();
				}
<%
			}else if ( patientIdStatus.equals("INVALID_PATIENT")){
				continue_yn = false;
				String chkPatDispArch = "";
				if(op_call.equals("OA") || op_call.equals("IP_BOOKING")){
					chkPatDispArch=patdata.checkPatientDisposeArchive(con,pat_id);
				}
				if(chkPatDispArch.equals("I")){
				%>
					if(confirm(getMessage('PAT_ACTIVATE','MP'))){	
							var xmlDoc = "";
							var xmlHttp = new XMLHttpRequest();
							xmlStr ='<root><SEARCH /></root>';
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open('POST','../../eMP/jsp/MPIntermediate.jsp?action=activate_pat&patientId=<%=pat_id%>',false);
							xmlHttp.send(xmlDoc);
							responseText=xmlHttp.responseText;
							responseText = trimString(responseText);
							if(eval(varBodyFrame).document.getElementById("patient_id").readOnly == false && eval(varBodyFrame).document.getElementById("patient_id").disabled == false) {
								eval(varBodyFrame).document.getElementById("patient_id").focus();
								eval(varBodyFrame).document.getElementById("patient_id").onblur();
							}
						}else{
							invFlg='T';
				varFlag = false;
							eval(varBodyFrame).document.getElementById("patient_id").value = "";
						}
				
				<%}else{
%>				
				invFlg='T';
				varFlag = false;
				alert(getMessage('INVALID_PATIENT','MP'));
				eval(varBodyFrame).document.getElementById("patient_id").value = "";
<%				
				}
			}else if (patientIdStatus.indexOf("PATIENT_MERGED_VALID")>=0 ) {
				continue_yn = false;
				StringTokenizer token=new StringTokenizer(patientIdStatus,"$");
				String valid_patient_id = token.nextToken();
				valid_patient_id = token.nextToken();				
%>		
				varFlag = false;
				var error= getMessage( "PATIENT_MERGED_VALID" ,'MP');
				error = error.replace('#',"<%=valid_patient_id%>");				
				alert(error);	
				eval(varBodyFrame).document.getElementById("patient_id").value = "<%=valid_patient_id%>";
				if(eval(varBodyFrame).document.getElementById("patient_id").readOnly == false && eval(varBodyFrame).document.getElementById("patient_id").disabled == false)
				{
					eval(varBodyFrame).document.getElementById("patient_id").focus();
				}
<%						
			}
		}

		if(continue_yn == true) {
			In_patient_status =  patdata.CheckInPatient(con,pat_id,facilityid);
			alternateIdStatus = patdata.CheckAlternateId(con,pat_id,localeName);
		}
			if(In_patient_status.equals("CURRENTLY_IN_PATIENT")){
					%>				
	                                eval(varBodyFrame).focus();
					var err_age3 = getMessage("CURRENTLY_IN_PATIENT",'common');
					alert(err_age3);	
					
					<%
				}
				
	if(strPatdtlsUnknownYN.equalsIgnoreCase("Y"))
	{
%>
	if (eval(varBodyFrame).document.getElementById("nat_gif_nat_gif"))
		eval(varBodyFrame).document.getElementById("nat_gif_nat_gif").style.visibility = 'hidden';
	if (eval(varBodyFrame).document.getElementById("nat_gif_yn"))
		eval(varBodyFrame).document.getElementById("nat_gif_yn").value = 'N'
	 
	/*    Commented the below code against IN017676 by Suresh M on 29/12/2009

			if (eval(varBodyFrame).document.getElementById("eth_gif")!=null)
				eval(varBodyFrame).document.getElementById("eth_gif").style.visibility='hidden';
			if (eval(varBodyFrame).document.getElementById("eth_gif_yn"))
				eval(varBodyFrame).document.getElementById("eth_gif_yn").value = 'N'
	*/

<%
	} else if(strPatdtlsUnknownYN.equalsIgnoreCase("N")) { %>
			if (eval(varBodyFrame).document.getElementById("nat_gif_nat_gif"))
				eval(varBodyFrame).document.getElementById("nat_gif_nat_gif").style.visibility = 'visible';
			if (eval(varBodyFrame).document.getElementById("nat_gif_yn"))
				eval(varBodyFrame).document.getElementById("nat_gif_yn").value = 'Y'		 
<%}%>



//**@Check the AlterNateId Status **//
	//out.println("alert('"+pat_id+"')");
	// added  @UAT-3 Starts
if(!((eval(varBodyFrame).document.getElementById("alt_id1_no")) == null))
{
	eval(varBodyFrame).document.getElementById("alt_id1_no").value = "<%=AltId1No%>"
}
if(!((eval(varBodyFrame).document.getElementById("alt_id2_no")) == null))
{
	eval(varBodyFrame).document.getElementById("alt_id2_no").value = "<%=AltId2No%>"
}
if(!((eval(varBodyFrame).document.getElementById("alt_id3_no")) == null))
{
	eval(varBodyFrame).document.getElementById("alt_id3_no").value = "<%=AltId3No%>"
}
if(!((eval(varBodyFrame).document.getElementById("alt_id4_no")) == null))
{
	eval(varBodyFrame).document.getElementById("alt_id4_no").value = "<%=AltId4No%>"
}// added  @UAT-3 Ends
if(!((eval(varBodyFrame).document.getElementById("alt_id1_exp_date")) == null))
{
	eval(varBodyFrame).document.getElementById("alt_id1_exp_date").value = "<%=alt_id1_exp_date%>"
}
if(!((eval(varBodyFrame).document.getElementById("alt_id2_exp_date")) == null))
{
	eval(varBodyFrame).document.getElementById("alt_id2_exp_date").value = "<%=alt_id2_exp_date%>"
}
if(!((eval(varBodyFrame).document.getElementById("alt_id3_exp_date")) == null))
{
	eval(varBodyFrame).document.getElementById("alt_id3_exp_date").value = "<%=alt_id3_exp_date%>"
}
if(!((eval(varBodyFrame).document.getElementById("alt_id4_exp_date")) == null))
{
	eval(varBodyFrame).document.getElementById("alt_id4_exp_date").value = "<%=alt_id4_exp_date%>"
}
// Changed @UAT-3 Starts
<%if(AcceptOtherAltId.equals("Y")) {%>
	eval(varBodyFrame).document.getElementById("other_alt_type").value = "";
	eval(varBodyFrame).document.getElementById("other_alt_Id").value = "";
	<%if(!(OtherAltIdNo=="")){%>
		var obj = eval(varBodyFrame).document.getElementById("other_alt_type");
		for(var k=0;k<obj.options.length;k++){
			if(obj.options[k].value == "<%=OtherAltIdType%>")
				obj.options[k].selected = true;
		}
		eval(varBodyFrame).document.getElementById("other_alt_Id").value = "<%=OtherAltIdNo%>"
	<%}
}// Changed @UAT-3 Ends
   
  if (!alternateIdStatus.equals("")) 
	{
		char val=alternateIdStatus.charAt(0);
		char vall=alternateIdStatus.charAt(1);
%>
		if(varFlag == true)
		{  
			if("<%=val%>" == 'W')
			{
			<%
				String mmsg=alternateIdStatus.substring(2,alternateIdStatus.length());
			%>
					var ret = confirm("<%=mmsg%>");
					if(!ret)
					{
						varFlag = false;
						eval(varBodyFrame).document.getElementById("patient_id").value = "";
						if(eval(varBodyFrame).document.getElementById("patient_id").readOnly == false && eval(varBodyFrame).document.getElementById("patient_id").disabled == false)
						{
							eval(varBodyFrame).document.getElementById("patient_id").focus();
						}
					}
					else
					{
						if("<%=vall%>" == "1")
							eval(varBodyFrame).document.getElementById("alt_id1_no").value = "<%=AltId1No%>"
						else if("<%=vall%>" == "2")
							eval(varBodyFrame).document.getElementById("alt_id1_no").value = "<%=AltId2No%>"
						else if("<%=vall%>" == "3")
							eval(varBodyFrame).document.getElementById("alt_id1_no").value = "<%=AltId3No%>"
						else if("<%=vall%>" == "4")
							eval(varBodyFrame).document.getElementById("alt_id1_no").value = "<%=AltId4No%>"
					}
			}else if("<%=val%>" =='C')
			{<%
				String mmsg1=alternateIdStatus.substring(1,alternateIdStatus.length());
				%>
						varFlag = false;
						alert("<%=mmsg1%>");
						eval(varBodyFrame).document.getElementById("patient_id").value = "";
						if(eval(varBodyFrame).document.getElementById("patient_id").readOnly == false && eval(varBodyFrame).document.getElementById("patient_id").disabled == false)
						{
							eval(varBodyFrame).document.getElementById("patient_id").focus();
						}
			}else
			{<%
				String mmsg2=alternateIdStatus.substring(2,alternateIdStatus.length());
			%>
						alert("<%=mmsg2%>");
						if("<%=vall%>" == "1")
							eval(varBodyFrame).document.getElementById("alt_id1_no").value = "<%=AltId1No%>"
						else if("<%=vall%>" == "2")
							eval(varBodyFrame).document.getElementById("alt_id1_no").value = "<%=AltId2No%>"
						else if("<%=vall%>" == "3")
							eval(varBodyFrame).document.getElementById("alt_id1_no").value = "<%=AltId3No%>"
						else if("<%=vall%>" == "4")
							eval(varBodyFrame).document.getElementById("alt_id1_no").value = "<%=AltId4No%>"
			}
	   }
<%	}
   
%>
<!-- @Check forthe Citlzenship -->
		if(eval(varBodyFrame).document.getElementById("citizen_yn")!=null)
		{
		eval(varBodyFrame).document.getElementById("citizen_yn").disabled = false;
		eval(varBodyFrame).document.getElementById("citizen_yn").disabled = false;
		}
<%
		if(strCitizenYN.equalsIgnoreCase("Y"))
		{
%>		/*		Commented the below code against IN017676 by Suresh M on 29/12/2009
					
					if(eval(varBodyFrame).document.getElementById("race_required_yn")) {
						if(eval(varBodyFrame).document.getElementById("race_required_yn").value=='Y') {				
							if(eval(varBodyFrame).document.getElementById("eth_gif")!=null)
								eval(varBodyFrame).document.getElementById("eth_gif").style.visibility='visible';
						}
					}
					eval(varBodyFrame).document.getElementById("race_yn").value = 'Y';
			*/
			if(eval(varBodyFrame).document.getElementById("citizen_yn")!=null)
			{
			eval(varBodyFrame).document.getElementById("citizen_yn").checked = true; 
<%				if(strLegalYN.equalsIgnoreCase("Y")){ %>
				eval(varBodyFrame).document.getElementById("legal_yn").checked = true;
<%				} else if(strLegalYN.equalsIgnoreCase("N")) { %>
				eval(varBodyFrame).document.getElementById("legal_yn").checked = true;
<%				} %>
			}
<%
		}
		else
		{
%>	/*		Commented the below code against IN017676 by Suresh M on 29/12/2009
				
				if(eval(varBodyFrame).document.getElementById("eth_gif")!=null)
				eval(varBodyFrame).document.getElementById("eth_gif").style.visibility='hidden'	
				eval(varBodyFrame).document.getElementById("race_yn").value = 'N';	
		*/
			if(eval(varBodyFrame).document.getElementById("citizen_yn")!=null)
			{
			eval(varBodyFrame).document.getElementById("citizen_yn").checked = true;
<%			if(strLegalYN.equalsIgnoreCase("Y")) { %>
				eval(varBodyFrame).document.getElementById("legal_yn").checked = true;
<%			} else if(strLegalYN.equalsIgnoreCase("N")) { %>
				eval(varBodyFrame).document.getElementById("legal_yn").checked = true;
<%			} %>

			
			}
			
<%
		}
%>
<!-- @Check Legal -->
<%

%>
	eval(varSubmitFrame).document.location.href = '../../eCommon/jsp/error.jsp?err_value=0';

	if(varFlag == false)
	{
		if(invFlg=='T'){
			if(eval(varBodyFrame).document.getElementById("birth_place")!=null){
				eval(varBodyFrame).document.getElementById("birth_place").value = "";
				eval(varBodyFrame).document.getElementById("Birth_place_code").value = "";
				eval(varBodyFrame).document.getElementById("b_birth").disabled = false;
				if(eval(varBodyFrame).document.getElementById("race_required_yn")) {
					if(eval(varBodyFrame).document.getElementById("race_required_yn").value=='Y') {	
						eval(varBodyFrame).document.getElementById("eth_gif").style.visibility='visible';	
					}
				}
			}

			if(eval(varBodyFrame).document.getElementById("nationality_desc")!=null){
				eval(varBodyFrame).document.getElementById("nationality_id").disabled = false;
			}
			
			

			if(eval(varBodyFrame).document.getElementById("race_desc")!=null){
				//eval(varBodyFrame).document.getElementById("race_code").disabled = false;
				eval(varBodyFrame).document.getElementById("race_desc").disabled = false;
				eval(varBodyFrame).document.getElementById("race_desc_id").disabled = false;
				//eval(varBodyFrame).document.getElementById("race_code").options[0].selected = true
				eval(varBodyFrame).document.getElementById("race_code").value = "";
				eval(varBodyFrame).document.getElementById("race_desc").value = "";

				eval(varBodyFrame).document.getElementById("ethnic_group").disabled = false
				eval(varBodyFrame).document.getElementById("ethnic_group").options[0].selected = true
			}
			if(eval(varBodyFrame).document.getElementById("patient_id").readOnly == false && eval(varBodyFrame).document.getElementById("patient_id").disabled == false)
			{
				eval(varBodyFrame).document.getElementById("patient_id").focus();
			}
			
			clr_flds();
		}else{
				clr_flds();
		}
	}
	else
	{

		eval(varBodyFrame).document.getElementById("addr1_type").value = ""
		eval(varBodyFrame).document.getElementById("addr_line1").value = "<%=a_res_addr_line1%>"
		eval(varBodyFrame).document.getElementById("addr_line2").value = "<%=a_res_addr_line2%>"
		eval(varBodyFrame).document.getElementById("addr_line3").value = "<%=a_res_addr_line3%>"
		eval(varBodyFrame).document.getElementById("addr_line4").value = "<%=a_res_addr_line4%>"
		eval(varBodyFrame).document.getElementById("res_town_code").value = "<%=a_res_town2_code%>"
		eval(varBodyFrame).document.getElementById("res_town_desc").value = "<%=a_res_town2_desc%>"
		eval(varBodyFrame).document.getElementById("res_area_code").value = "<%=a_res_area_code%>"
		eval(varBodyFrame).document.getElementById("res_area_desc").value = "<%=a_res_area%>"
		eval(varBodyFrame).document.getElementById("postal_code").value = "<%=a_postal_code%>"
		eval(varBodyFrame).document.getElementById("r_postal_code_desc").value = "<%=postal_desc%>"
		eval(varBodyFrame).document.getElementById("region_code").value = "<%=a_res_region_code%>"
		eval(varBodyFrame).document.getElementById("region_desc").value = "<%=a_res_region_desc%>"
		eval(varBodyFrame).document.getElementById("country_code").value = "<%=a_country_code%>"
		eval(varBodyFrame).document.getElementById("country_desc").value = "<%=a_country_desc%>"
		eval(varBodyFrame).document.getElementById("contact1_name").value = ""
		eval(varBodyFrame).document.getElementById("invalid1_yn").value = ""
		eval(varBodyFrame).document.getElementById("addr2_type").value = ""
		eval(varBodyFrame).document.getElementById("mail_addr_line1").value = "<%=m_res_addr_line1%>"
		eval(varBodyFrame).document.getElementById("mail_addr_line2").value = "<%=m_res_addr_line2%>"
		eval(varBodyFrame).document.getElementById("mail_addr_line3").value = "<%=m_res_addr_line3%>"
		eval(varBodyFrame).document.getElementById("mail_addr_line4").value = "<%=m_res_addr_line4%>"
		eval(varBodyFrame).document.getElementById("mail_res_town_code").value = "<%=m_res_town2_code%>"
		eval(varBodyFrame).document.getElementById("mail_res_town_desc").value = "<%=m_res_town2_desc%>"
		eval(varBodyFrame).document.getElementById("mail_res_area_code").value = "<%=m_res_area_code%>"
		eval(varBodyFrame).document.getElementById("mail_res_area_desc").value = "<%=m_res_area_desc%>"
		eval(varBodyFrame).document.getElementById("mail_postal_code").value = "<%=m_postal_code%>"
		eval(varBodyFrame).document.getElementById("m_postal_code_desc").value = "<%=postal2_desc%>"
		eval(varBodyFrame).document.getElementById("mail_region_code").value = "<%=m_res_region_code%>"
		eval(varBodyFrame).document.getElementById("mail_region_desc").value = "<%=m_res_region_desc%>"
		eval(varBodyFrame).document.getElementById("mail_country_code").value = "<%=m_country_code%>"
		eval(varBodyFrame).document.getElementById("mail_country_desc").value = "<%=m_country_desc%>"
		eval(varBodyFrame).document.getElementById("contact2_name").value = ""
		eval(varBodyFrame).document.getElementById("invalid2_yn").value = ""
		eval(varBodyFrame).document.getElementById("contact1_no").value ="<%=strPrimaryResNo%>"
		eval(varBodyFrame).document.getElementById("contact2_no").value ="<%=strOtherResNo%>"
		eval(varBodyFrame).document.getElementById("email").value ="<%=strEmail%>"
		if(eval(varBodyFrame).document.getElementById("Birth_place_code")!=null)
		eval(varBodyFrame).document.getElementById("Birth_place_code").value ="<%=birth_place_code%>"
		if(eval(varBodyFrame).document.getElementById("place_of_birth")!=null)
		eval(varBodyFrame).document.getElementById("place_of_birth").value ="<%=place_of_birth%>"
		if(eval(varBodyFrame).document.getElementById("birth_place")!=null)
		eval(varBodyFrame).document.getElementById("birth_place").value = "<%=strBirthPldesc%>"
		/*Added by Thamizh selvi on 30th Jan 2018 against ML-MMOH-CRF-0601 Start*/
		eval(varBodyFrame).document.getElementById("alt_addr_line1").value = "<%=alt_addr_line1%>"
		eval(varBodyFrame).document.getElementById("alt_addr_line2").value = "<%=alt_addr_line2%>"
		eval(varBodyFrame).document.getElementById("alt_addr_line3").value = "<%=alt_addr_line3%>"
		eval(varBodyFrame).document.getElementById("alt_addr_line4").value = "<%=alt_addr_line4%>"
		eval(varBodyFrame).document.getElementById("alt_town_code").value = "<%=alt_town_code%>"
		eval(varBodyFrame).document.getElementById("alt_town_desc").value = "<%=alt_town_desc%>"
		eval(varBodyFrame).document.getElementById("alt_area_code").value = "<%=alt_area_code%>"
		eval(varBodyFrame).document.getElementById("alt_area_desc").value = "<%=alt_area_desc%>"
		eval(varBodyFrame).document.getElementById("alt_postal_desc").value = "<%=alt_postal_desc%>"
		eval(varBodyFrame).document.getElementById("alt_postal_code").value = "<%=alt_postal_code%>"
		eval(varBodyFrame).document.getElementById("alt_region_code").value = "<%=alt_region_code%>"
		eval(varBodyFrame).document.getElementById("alt_region_desc").value = "<%=alt_region_desc%>"
		eval(varBodyFrame).document.getElementById("alt_country_code").value = "<%=alt_country_code%>"
		eval(varBodyFrame).document.getElementById("alt_country_desc").value = "<%=alt_country_desc%>"
		/*End*/

		if(eval(varBodyFrame).document.getElementById("name_prefix") != null)
		{			
			var obj = eval(varBodyFrame).document.getElementById("name_prefix");			
			for(var k=0;k<obj.options.length;k++)
			{
					if(obj.options[k].value == "<%=strNamePrefix%>")
					{
							obj.options[k].selected = true;							
					}
			}
			eval(varBodyFrame).document.getElementById("name_prefix").disabled = true
		}

		if(eval(varBodyFrame).document.getElementById("race_desc") != null)
		{
			eval(varBodyFrame).document.getElementById("race_code").value = "<%=strRaceCd%>";
			eval(varBodyFrame).document.getElementById("race_desc").value = "<%=strRaceDesc%>";
			/*
			var obj = eval(varBodyFrame).document.getElementById("race_code");			
			for(var k=0;k<obj.options.length;k++)
			{
					if(obj.options[k].value == "<%=strRaceCd%>")
					{
							obj.options[k].selected = true;
					}
			}
			*/
			eval(varBodyFrame).document.getElementById("ethnic_group").disabled = true
		}

			//race_desc,strRaceCd, 
		
		if(eval(varBodyFrame).document.getElementById("ethnic_group") != null){
			
			if("<%=strEthnicGrpCd%>" !=''){
				opt = document.createElement("OPTION");
				var n = eval(varBodyFrame).document.forms[0].ethnic_group.options.length;
				for(var i=0;i<n;i++)
				eval(varBodyFrame).document.forms[0].ethnic_group.remove("ethnic_group");	
				opt.text = "<%=ethnic_desc%>";
				opt.value=  "<%=strEthnicGrpCd%>";
							
				eval(varBodyFrame).document.getElementById("ethnic_group").add(opt);
				eval(varBodyFrame).document.getElementById("ethnic_group").options[0].selected = true
				eval(varBodyFrame).document.getElementById("ethnic_group").disabled = true
				
			}else{
				
				var n = eval(varBodyFrame).document.forms[0].ethnic_group.options.length;
				for(var i=0;i<n;i++)
					eval(varBodyFrame).document.forms[0].ethnic_group.remove("ethnic_group");	
				var temp = "";
				var temp1="--------"+getLabel('Common.defaultSelect.label','Common')+"--------";
				var opt=eval(varBodyFrame).document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				eval(varBodyFrame).document.forms[0].ethnic_group.add(opt);	
				eval(varBodyFrame).document.getElementById("ethnic_group").options[0].selected = true
			}
			
		}
        
		if(eval(varBodyFrame).document.getElementById("first_name") != null)
		{  
			eval(varBodyFrame).document.getElementById("first_name").value = "<%=strFirstName==null?"":strFirstName%>"
			eval(varBodyFrame).document.getElementById("first_name").disabled = true;
			if(eval(varBodyFrame).document.getElementById("bf"))
			eval(varBodyFrame).document.getElementById("bf").disabled = true//added by  munisekhar  for [IN:046231]
			
			
		}
		if(eval(varBodyFrame).document.getElementById("second_name") != null)
		{
			eval(varBodyFrame).document.getElementById("second_name").value = "<%=strSecondName==null?"":strSecondName%>"
			eval(varBodyFrame).document.getElementById("second_name").disabled = true
			if(eval(varBodyFrame).document.getElementById("bs"))
			eval(varBodyFrame).document.getElementById("bs").disabled = true//added by  munisekhar  for [IN:046231]
		}
		if(eval(varBodyFrame).document.getElementById("third_name") != null)
		{
			eval(varBodyFrame).document.getElementById("third_name").value = "<%=strThirdName==null?"":strThirdName%>"
			eval(varBodyFrame).document.getElementById("third_name").disabled = true;
			if(eval(varBodyFrame).document.getElementById("bt"))
			eval(varBodyFrame).document.getElementById("bt").disabled = true//added by  munisekhar  for [IN:046231]
		}
		
		if(eval(varBodyFrame).document.getElementById("family_name") != null)
		{
			eval(varBodyFrame).document.getElementById("family_name").value = "<%=strFamilyName==null?"":strFamilyName%>"
			eval(varBodyFrame).document.getElementById("family_name").disabled = true;

		if(eval(varBodyFrame).document.getElementById("bfam"))
			eval(varBodyFrame).document.getElementById("bfam").disabled = true//added by  munisekhar  for [IN:046231]
	
		}
		if(eval(varBodyFrame).document.getElementById("name_suffix") != null)
		{
			var obj = eval(varBodyFrame).document.getElementById("name_suffix");
			for(var k=0;k<obj.options.length;k++)
			{
				if(obj.options[k].value == "<%=strNameSuffix%>")
					obj.options[k].selected = true;
			}
			eval(varBodyFrame).document.getElementById("name_suffix").disabled = true;
		}

// add for local language names
	if(eval(varBodyFrame).document.getElementById("first_name_oth_lang") != null)
			{
				eval(varBodyFrame).document.getElementById("first_name_oth_lang").value = "<%=first_name_loc_lang%>"
				eval(varBodyFrame).document.getElementById("first_name_oth_lang").disabled = true;
				if(eval(varBodyFrame).document.getElementById("bfo"))
				eval(varBodyFrame).document.getElementById("bfo").disabled = true;//added by  munisekhar  for [IN:046231]
			}
			if(eval(varBodyFrame).document.getElementById("second_name_oth_lang") != null)
			{
				eval(varBodyFrame).document.getElementById("second_name_oth_lang").value = "<%=second_name_loc_lang%>"
				eval(varBodyFrame).document.getElementById("second_name_oth_lang").disabled = true
				if(eval(varBodyFrame).document.getElementById("bso"))
				eval(varBodyFrame).document.getElementById("bso").disabled = true;//added by  munisekhar  for [IN:046231]
			}
			if(eval(varBodyFrame).document.getElementById("third_name_oth_lang") != null)
			{
				eval(varBodyFrame).document.getElementById("third_name_oth_lang").value = "<%=third_name_loc_lang%>"
				eval(varBodyFrame).document.getElementById("third_name_oth_lang").disabled = true;
				if(eval(varBodyFrame).document.getElementById("bto"))
				eval(varBodyFrame).document.getElementById("bto").disabled = true;//added by  munisekhar  for [IN:046231]
			}
			
			if(eval(varBodyFrame).document.getElementById("family_name_oth_lang") != null)
			{
				eval(varBodyFrame).document.getElementById("family_name_oth_lang").value = "<%=family_name_loc_lang%>"
				eval(varBodyFrame).document.getElementById("family_name_oth_lang").disabled = true;
				if(eval(varBodyFrame).document.getElementById("bfamo"))
				eval(varBodyFrame).document.getElementById("bfamo").disabled = true;//added by  munisekhar  for [IN:046231]
			}
			if(eval(varBodyFrame).document.getElementById("name_suffix_oth_lang") != null)
			{
				var obj = eval(varBodyFrame).document.getElementById("name_suffix_oth_lang");
				for(var k=0;k<obj.options.length;k++)
				{
					if(obj.options[k].value == "<%=name_suffix_loc_lang%>")
						obj.options[k].selected = true;
				}
				eval(varBodyFrame).document.getElementById("name_suffix_oth_lang").disabled = true;
			}

			if(eval(varBodyFrame).document.getElementById("name_prefix_oth_lang") != null)
		{		
			//var obj = eval(varBodyFrame).document.getElementById("name_prefix_oth_lang");
			var obj = eval(varBodyFrame).document.getElementById("name_prefix_oth_lang");
			for(var k=0;k<obj.options.length;k++)
			{
					if(obj.options[k].value == "<%=name_prefix_loc_lang%>")
					{
							obj.options[k].selected = true;							
					}
			}
			eval(varBodyFrame).document.getElementById("name_prefix_oth_lang").disabled = true
		}
		eval(varBodyFrame).document.getElementById("patient_name_local_lang1").innerHTML = "<b><%=patient_name_loc_lang%></b>"
		eval(varBodyFrame).document.getElementById("patient_name_local_lang").value = "<%=patient_name_loc_lang%>"
		
		eval(varBodyFrame).document.getElementById("patient_name1").innerHTML = "<b><%=patient_name%></b>";
		eval(varBodyFrame).document.getElementById("patient_name").value ="<%=patient_name%>";


		if(eval(varBodyFrame).document.getElementById("patient_name_long") != null)		   
			eval(varBodyFrame).document.getElementById("patient_name_long").value = "<%=patient_long_name==null?"":patient_long_name%>"

		if(eval(varBodyFrame).document.getElementById("patient_name_loc_lang_long") != null)		   
			eval(varBodyFrame).document.getElementById("patient_name_loc_lang_long").value = "<%=patient_long_name_loc_lang==null?"":patient_long_name_loc_lang%>"
					
		if(eval(varBodyFrame).document.getElementById("national_id_no") != null)
		{
			
			eval(varBodyFrame).document.getElementById("national_id_no").value = "<%=strNatIdNo%>"
			
			eval(varBodyFrame).document.getElementById("national_id_no").disabled = true;
			//eval(varBodyFrame).document.getElementById("nationality_desc").disabled = true;
			//eval(varBodyFrame).document.getElementById("nationality_id").disabled = true;
			
		}
		if(eval(varBodyFrame).document.getElementById("myKadBtn")!=null)
		{
			eval(varBodyFrame).document.getElementById("myKadBtn").disabled = true;
		}
		if(eval(varBodyFrame).document.getElementById("alt_id1_no")!=null)
		{
			eval(varBodyFrame).document.getElementById("alt_id1_no").disabled = true;
		}
		if(eval(varBodyFrame).document.getElementById("alt_id2_no")!=null)
		{
			eval(varBodyFrame).document.getElementById("alt_id2_no").disabled = true;
		}
		if(eval(varBodyFrame).document.getElementById("alt_id3_no")!=null)
		{
			eval(varBodyFrame).document.getElementById("alt_id3_no").disabled = true;
		}
		if(eval(varBodyFrame).document.getElementById("alt_id4_no")!=null)
		{
			eval(varBodyFrame).document.getElementById("alt_id4_no").disabled = true;
		}

		if(eval(varBodyFrame).document.getElementById("alt_id1_exp_date")!=null)
		{
			eval(varBodyFrame).document.getElementById("alt_id1_exp_date").disabled = true;
			eval(varBodyFrame).document.getElementById("alt_id_exp_dt1").disabled = true;
		}

		if(eval(varBodyFrame).document.getElementById("alt_id2_exp_date")!= null)
		{
			eval(varBodyFrame).document.getElementById("alt_id2_exp_date").disabled = true;
			eval(varBodyFrame).document.getElementById("alt_id_exp_dt2").disabled = true;
		}

		if(eval(varBodyFrame).document.getElementById("alt_id3_exp_date")!= null)
		{

			eval(varBodyFrame).document.getElementById("alt_id3_exp_date").disabled = true;
			eval(varBodyFrame).document.getElementById("alt_id_exp_dt3").disabled = true;
		}
		


		if(eval(varBodyFrame).document.getElementById("alt_id4_exp_date")!= null)
		{
			eval(varBodyFrame).document.getElementById("alt_id4_exp_date").disabled = true;
			eval(varBodyFrame).document.getElementById("alt_id_exp_dt4").disabled = true;
		}

		if(eval(varBodyFrame).document.getElementById("other_alt_type")!=null)
		{
			eval(varBodyFrame).document.getElementById("other_alt_type").disabled = true;
		}
		if(eval(varBodyFrame).document.getElementById("other_alt_Id")!=null)
		{
			eval(varBodyFrame).document.getElementById("other_alt_Id").disabled = true;
		}
		//var obj = eval(varBodyFrame).document.getElementById("sex").options;
		var obj = eval(varBodyFrame).document.getElementById("sex");
		for(var k=0;k<obj.options.length;k++)
		{
				if(obj.options[k].value == "<%=strSex%>")
					obj.options[k].selected = true;
		}
		eval(varBodyFrame).document.getElementById("sex").disabled = true;
		if(eval(varBodyFrame).document.getElementById("date_of_birth")!=null)
		{
			eval(varBodyFrame).document.getElementById("date_of_birth").value = "<%=strDateOfBirth%>"
			eval(varBodyFrame).document.getElementById("date_of_birth").disabled = true;
		}
		eval(varBodyFrame).document.getElementById("b_age").value = "<%=strYear%>";
		eval(varBodyFrame).document.getElementById("b_age").disabled = true;
		eval(varBodyFrame).document.getElementById("b_months").value = "<%=strMonth%>";
		eval(varBodyFrame).document.getElementById("b_months").disabled = true;
		eval(varBodyFrame).document.getElementById("b_days").value ="<%=strDays%>";
		eval(varBodyFrame).document.getElementById("b_days").disabled = true;
		if(eval(varBodyFrame).document.getElementById("dob")!=null)
		eval(varBodyFrame).document.getElementById("dob").disabled = true;
		
		/*below code added for this CRF [RUT-CRF-0011]*/
		//if(eval(varBodyFrame).document.getElementById("pat_cat_desc").value!=null)		
		
				
		if('<%=pat_id%>'!="" && '<%=op_call%>'=="OA")
		{
		eval(varBodyFrame).document.getElementById("pat_cat_code").value = "<%=patcat_code%>"
		eval(varBodyFrame).document.getElementById("pat_cat_desc").value = "<%=patcat_desc%>"
		eval(varBodyFrame).document.getElementById("pat_cat_desc").disabled = true		
		eval(varBodyFrame).document.getElementById("pat_cat_code_id").disabled = true
		}else{
		if('<%=op_call%>'=="OA"){		
		eval(varBodyFrame).document.getElementById("pat_cat_code").value = '';
		eval(varBodyFrame).document.getElementById("pat_cat_desc").value = '';
		eval(varBodyFrame).document.getElementById("pat_cat_code_id").value='?'; 
		eval(varBodyFrame).document.getElementById("pat_cat_desc").disabled = false
		eval(varBodyFrame).document.getElementById("pat_cat_code_id").disabled = false
		}
		} 
		
		/*End*/		

		if(eval(varBodyFrame).document.getElementById("nationality_desc")!=null)
		{
		var obj = eval(varBodyFrame).document.getElementById("nationality_desc");
		obj.value = "<%=strNationalityDesc%>"
		
		eval(varBodyFrame).document.getElementById("nationality_code1").value = "<%=strNationalityCode%>"
		if(	eval(varBodyFrame).document.getElementById("nationality_desc").value!="")
		{
		eval(varBodyFrame).document.getElementById("nationality_desc").disabled = true
		eval(varBodyFrame).document.getElementById("nationality_id").disabled = true
		} 
		else
		{
		eval(varBodyFrame).document.getElementById("nationality_desc").disabled = false
		eval(varBodyFrame).document.getElementById("nationality_id").disabled = false
		
		}
		}
		if(eval(varBodyFrame).document.getElementById("birth_place")!=null)
		{
		  eval(varBodyFrame).document.getElementById("birth_place").disabled = true;
		  eval(varBodyFrame).document.getElementById("b_birth").disabled = true; 
		}
		if(eval(varBodyFrame).document.getElementById("place_of_birth")!=null)
		{
		if(eval(varBodyFrame).document.getElementById("place_of_birth").value!=null)
				  eval(varBodyFrame).document.getElementById("place_of_birth").disabled = true;
		}
		if(eval(varBodyFrame).document.getElementById("birth_place")!=null)
		eval(varBodyFrame).document.getElementById("birth_place").disabled = true
		if(eval(varBodyFrame).document.getElementById("place_of_birth")!=null)
		eval(varBodyFrame).document.getElementById("place_of_birth").disabled = true
		if('<%=pat_id%>'!="" && eval(varBodyFrame).document.getElementById("language_desc")){
			eval(varBodyFrame).document.getElementById("language_desc").value = "<%=language_desc%>"
			eval(varBodyFrame).document.getElementById("language_id").value = "<%=language_id%>"
		}
		if(eval(varBodyFrame).document.getElementById("citizen_yn")!=null)
		{
		/* Added for IN:046495 by Dharma on 20th Jan 2014 Start*/

		if(eval(varBodyFrame).document.getElementById("alt_id1_man_non_ctz").value=="true"){
			if(eval(varBodyFrame).document.getElementById("citizen_yn").value!=null){
				if(eval(varBodyFrame).document.getElementById("citizen_yn").checked==true) { 
				  if(eval(varBodyFrame).document.getElementById("alt1_gif")){
					  eval(varBodyFrame).document.getElementById("alt_id1_reqd_yn").value='N'; 
					  eval(varBodyFrame).document.getElementById("alt1_gif").style.visibility='hidden';
				   }
				   if(eval(varBodyFrame).document.getElementById("alt1_exp_date1")){
					  eval(varBodyFrame).document.getElementById("alt_date1_reqd_yn").value='N';
					  eval(varBodyFrame).document.getElementById("alt1_exp_date1").style.visibility='hidden';
				   } 

				}
			}
			
			if(eval(varBodyFrame).document.getElementById("citizen_yn").value!=null){
				if(eval(varBodyFrame).document.getElementById("citizen_yn").checked==true) { 
				  if(eval(varBodyFrame).document.getElementById("alt1_gif")){
				
					  eval(varBodyFrame).document.getElementById("alt_id1_reqd_yn").value='Y'; 
					  eval(varBodyFrame).document.getElementById("alt1_gif").style.visibility='visible';
				   }
				   if(eval(varBodyFrame).document.getElementById("alt1_exp_date1")){
					  eval(varBodyFrame).document.getElementById("alt_date1_reqd_yn").value='Y';
					  eval(varBodyFrame).document.getElementById("alt1_exp_date1").style.visibility='visible';
				   } 

				}
			}

		}
		/* Added for IN:046495 by Dharma on 20th Jan 2014 End*/

		if(eval(varBodyFrame).document.getElementById("citizen_yn").value!=null)
				   eval(varBodyFrame).document.getElementById("citizen_yn").disabled = true;
				if(eval(varBodyFrame).document.getElementById("citizen_yn").value!=null)
					{
				     eval(varBodyFrame).document.getElementById("citizen_yn").disabled = true;
					 //eval(varBodyFrame).document.getElementById("eth_gif").style.visibility = 'hidden';
					}
			   if(eval(varBodyFrame).document.getElementById("legal_yn").value!=null)
				   eval(varBodyFrame).document.getElementById("legal_yn").disabled = true;
				if(eval(varBodyFrame).document.getElementById("legal_yn").value!=null)
				   eval(varBodyFrame).document.getElementById("legal_yn").disabled = true;
			  /*
			  if(eval(varBodyFrame).document.getElementById("race_code").value!= "")
				 eval(varBodyFrame).document.getElementById("race_code").disabled = true;
			  else
				 eval(varBodyFrame).document.getElementById("race_code").disabled = false;
			  */
			  if(eval(varBodyFrame).document.getElementById("race_desc").value!= "") {
				 eval(varBodyFrame).document.getElementById("race_desc").disabled = true;
				 eval(varBodyFrame).document.getElementById("race_desc_id").disabled = true;
			  }  else {
				 eval(varBodyFrame).document.getElementById("race_desc").disabled = false;
				 eval(varBodyFrame).document.getElementById("race_desc_id").disabled = false;
			  }
		}
		//Added on 10-10-2004
		if(eval(varBodyFrame).document.getElementById("ethnic_group")!=null)
		{
		<%
		if(!strRaceCd.equals(""))
		{
		sql = "select ethnic_group_code, long_desc from mp_ethnic_group_lang_vw where language_id = '"+locale+"' and race_code = '"+strRaceCd+"' and eff_status='E' order by 2";
		pstmt1 = con.prepareStatement(sql) ;
		rs1      = pstmt1.executeQuery() ;
		%>
		var obj = eval(varBodyFrame).document.getElementById("ethnic_group").options;
		for(i=0;i<obj.length;i++)
			obj.remove(1);
		<%while(rs1.next())
		{
		%>
		
		var opt = eval(varBodyFrame).document.createElement('Option');
		opt.text = "<%=rs1.getString(2)%>";
		opt.value = "<%=rs1.getString(1)%>";
		obj.add(opt);
		<%}
		}	
		%> 
		}
		putPatientName();
	}
</script>
<%
	if(pstmt != null)pstmt.close();
	if(rs!=null) rs.close();
	if(pstmt1 != null)pstmt1.close();
	if(rs1!=null) rs1.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
%>
<%!	
	private String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%> 
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
<Script language='javascript' src='../../eMP/js/PatientSearch.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% 

Connection conn = null;
java.sql.PreparedStatement pstmt = null;
ResultSet rs =null;

try
{  
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	conn = ConnectionManager.getConnection(request);	
	String appt_ref_no = request.getParameter("appt_ref_no");
	String ap = request.getParameter("ap");
	String facilityId = (String) session.getValue("facility_id");
	
	String nat_id_chk_digit_scheme = "";
	String FirstName=request.getParameter("First_Name");if(FirstName==null)FirstName="";
	String SecondName=request.getParameter("Second_Name");if(SecondName==null)SecondName="";
	String ThirdName=request.getParameter("Third_Name");if(ThirdName==null)ThirdName="";
	String FamilyName=request.getParameter("Family_Name");if(FamilyName==null)FamilyName="";

	String a_family_name_loc_lang		= checkForNull( request.getParameter("family_name_loc_lang") );
	String a_first_name_loc_lang		= checkForNull( request.getParameter("first_name_loc_lang") );
	String a_second_name_loc_lang		= checkForNull( request.getParameter("second_name_loc_lang") );
	String a_third_name_loc_lang		= checkForNull( request.getParameter("third_name_loc_lang") );
	String a_patient_name_loc_lang		= checkForNull( request.getParameter("patient_name_loc_lang") );

	/*a_family_name_loc_lang		= java.net.URLEncoder.encode(a_family_name_loc_lang);
	a_first_name_loc_lang		= java.net.URLEncoder.encode(a_first_name_loc_lang);
	a_second_name_loc_lang		= java.net.URLEncoder.encode(a_second_name_loc_lang);
	a_third_name_loc_lang		= java.net.URLEncoder.encode(a_third_name_loc_lang);
	a_patient_name_loc_lang		= java.net.URLEncoder.encode(a_patient_name_loc_lang);*/
	
	//out.println("<script>alert(1010101);alert('"+a_second_name_loc_lang+"');alert(121212212)</script>");

	String AltIdNo=request.getParameter("Alt_Id_No");if(AltIdNo==null)AltIdNo="";

	/*FirstName = java.net.URLEncoder.encode(FirstName) ;
	SecondName = java.net.URLEncoder.encode(SecondName) ;
	ThirdName = java.net.URLEncoder.encode(ThirdName) ;
	FamilyName = java.net.URLEncoder.encode(FamilyName) ; */
	AltIdNo = java.net.URLEncoder.encode(AltIdNo) ;

	String NationalIdNo=request.getParameter("National_Id_No");if(NationalIdNo==null)NationalIdNo="";
	String MRN=request.getParameter("MRN");if(MRN==null)MRN="";
	String Dob=request.getParameter("Dob");if(Dob==null)Dob="";
	String Sex=request.getParameter("Sex");if(Sex==null)Sex="";
	String Area=request.getParameter("Area");if(Area==null)Area="";
	String FamilyNo=request.getParameter("Family_No");if(FamilyNo==null) FamilyNo="";
	String func_act = request.getParameter("func_act");if(func_act == null) func_act="";
	String function_id = request.getParameter("function_id");if(function_id == null) function_id="";
	String booking_ref_no = request.getParameter("booking_ref_no") == null? "": request.getParameter("booking_ref_no");
	String q_booking_type = request.getParameter("q_booking_type");
	if(q_booking_type==null) q_booking_type="";
	//out.println("<script>alert('Pat reg"+q_booking_type+"')</script>");
	String referral_id = request.getParameter("referral_id");if(referral_id==null) referral_id="";
	String series="";
	String accept_national_id_no_yn = "";
	String AltId2No=request.getParameter("Alt_Id2_No");if(AltId2No==null)AltId2No="";
	String AltId3No=request.getParameter("Alt_Id3_No");if(AltId3No==null)AltId3No="";
	String AltId4No=request.getParameter("Alt_Id4_No");if(AltId4No==null)AltId4No="";
	String drfunctionid = request.getParameter("dr_function_id");
	if(drfunctionid == null) drfunctionid="";
	String calledFromModule = request.getParameter("calledFromModule");
	if(calledFromModule == null || calledFromModule.equals("null")) calledFromModule="";

	int cntSeries = 0, cntPatSeries = 0,cntlang = 0;
	AltId2No = java.net.URLEncoder.encode(AltId2No) ;
	AltId3No = java.net.URLEncoder.encode(AltId3No) ;
	AltId4No = java.net.URLEncoder.encode(AltId4No) ;
	//out.println("referral_id:"+referral_id);
	out.println("&nbsp;");

	String pat_name_as_multipart_yn = "";
	String acpt_appt_rfrl_in_reg_pat_yn = "N";
	String names_in_oth_lang_yn = "";
	String toDayDate = "";
	String patient_id_length = "";
	String oainstall_yn = "";
	String rdinstall_yn = "";
	String opinstall_yn = "";
	String ipinstall_yn = "";
//Added By Dharma on 20th Aug 2020 against ML-MMOH-SCF-1384
	String a_race_code  = request.getParameter("race_code");
		if(a_race_code == null)a_race_code = "";


	//String appt_ref_no = "90";
	String sql ="";
	sql = "select dflt_pat_ser_grp_type, nvl(alt_id1_type,'Alt ID No'), nvl(nat_id_prompt,'National ID No')nat_id_prompt, accept_national_id_no_yn, nat_id_chk_digit_scheme, pat_name_as_multipart_yn, acpt_appt_rfrl_in_reg_pat_yn, names_in_oth_lang_yn, to_char(sysdate, 'dd/mm/yyyy') toDayDate, patient_id_length, (select count(*) as total from sm_language where language_direction='R' and eff_status='E') total, (SELECT COUNT (1) FROM mp_pat_ser_grp WHERE id_type NOT IN ('X', 'R')) cntSeries, (select count(1) from mp_pat_ser_grp where (id_type not in ('X', 'R') and gen_pat_id_yn = 'Y' and (pat_ser_grp_code in (select pat_ser_grp_code from mp_pat_ser_facility where site_or_facility_id = decode(site_or_facility,'S',(select site_id from sm_site_param),'F',?)))) or gen_pat_id_yn = 'N' ) cntPatSeries, (SELECT install_yn FROM sm_module WHERE module_id = 'OA' AND install_yn = 'Y') oainstall_yn, (SELECT operational_yn FROM sm_modules_facility WHERE module_id = 'RD' AND facility_id = 'HS' AND operational_yn = 'Y') rdinstall_yn, (SELECT install_yn opinstall_yn FROM sm_module WHERE module_id = 'OP' AND install_yn = 'Y') opinstall_yn,(SELECT install_yn ipinstall_yn FROM sm_module WHERE module_id = 'IP' AND install_yn = 'Y') ipinstall_yn from  mp_param_lang_vw where language_id=? and module_id='MP' ";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,facilityId);
	pstmt.setString(2,localeName);
	rs = pstmt.executeQuery();

	if ( rs.next() )
	{

		series = rs.getString(1); 
		accept_national_id_no_yn = rs.getString("accept_national_id_no_yn");
		if (accept_national_id_no_yn==null) accept_national_id_no_yn = "N";		
		nat_id_chk_digit_scheme = checkForNull(rs.getString("nat_id_chk_digit_scheme"));		
		oainstall_yn = checkForNull(rs.getString("oainstall_yn"),"N");		
		rdinstall_yn = checkForNull(rs.getString("rdinstall_yn"),"N");		
		opinstall_yn = checkForNull(rs.getString("opinstall_yn"),"N");		
		ipinstall_yn = checkForNull(rs.getString("ipinstall_yn"),"N");		
		cntSeries = rs.getInt("cntSeries");
		cntPatSeries = rs.getInt("cntPatSeries");	
		pat_name_as_multipart_yn		=	 rs.getString("pat_name_as_multipart_yn");
		acpt_appt_rfrl_in_reg_pat_yn	=	 rs.getString("acpt_appt_rfrl_in_reg_pat_yn");
		names_in_oth_lang_yn			=	 rs.getString("names_in_oth_lang_yn");
		toDayDate							=	 rs.getString("toDayDate");
		patient_id_length							=	 rs.getString("patient_id_length");
		cntlang = rs.getInt("total");		
		
		if (cntSeries > 0)
		{
			if (cntPatSeries > 0)
			{
				if  ( rs.getString(1).equals("G") ) 
				{			
				%>  
					<html>
					<head>
					<title> <fmt:message key="eMP.PatientRegistrationTitle.label" bundle="${mp_labels}"/></title>
					</head>
					<body onKeyDown = 'lockKey()'>
					<form name ="Pass">
					<input type = "hidden" id = "SecondName" name = "SecondName" value = "<%=SecondName%>">					
					<input type = "hidden" id = "FirstName" name = "FirstName" value = "<%=FirstName%>">
					<input type = "hidden" id = "ThirdName" name = "ThirdName" value = "<%=ThirdName%>">
					
					<input type = "hidden" id = "FamilyName" name = "FamilyName" value = "<%=FamilyName%>">
					<input type = "hidden" id = "a_first_name_loc_lang" name = "a_first_name_loc_lang" value ="<%=a_first_name_loc_lang%>">
					<input type = "hidden" id = "a_second_name_loc_lang" name = "a_second_name_loc_lang" value ="<%=a_second_name_loc_lang%>">
					<input type = "hidden" id = "a_third_name_loc_lang" name = "a_third_name_loc_lang" value ="<%=a_third_name_loc_lang%>">
					<input type = "hidden" id = "a_family_name_loc_lang" name = "a_family_name_loc_lang" value ="<%=a_family_name_loc_lang%>">
					<input type = "hidden" id = "a_patient_name_loc_lang" name = "a_patient_name_loc_lang" value ="<%=a_patient_name_loc_lang%>">
					
					<script language='javascript'> 
			document.location="PatRegMain.jsp?group=G&appt_ref_no=<%=appt_ref_no%>&ap=<%=ap%>&First_Name="+encodeURIComponent(document.Pass.FirstName.value)+"&Second_Name="+encodeURIComponent(document.Pass.SecondName.value)+"&Third_Name="+encodeURIComponent(document.Pass.ThirdName.value)+"&Family_Name="+encodeURIComponent(document.Pass.FamilyName.value)+"&Alt_Id_No=<%=AltIdNo%>&National_Id_No=<%=NationalIdNo%>&Sex=<%=Sex%>&MRN=<%=MRN%>&Area=<%=Area%>&Dob=<%=Dob%>&Family_No=<%=FamilyNo%>&func_act=<%=func_act%>&booking_ref_no=<%=booking_ref_no%>&q_booking_type=<%=q_booking_type%>&referral_id=<%=referral_id%>&Alt_Id2_No=<%=AltId2No%>&Alt_Id3_No=<%=AltId3No%>&Alt_Id4_No=<%=AltId4No%>&function_id=<%=function_id%>&dr_function_id=<%=drfunctionid%>&calledFromModule=<%=calledFromModule%>&a_first_name_loc_lang="+encodeURIComponent(document.Pass.a_first_name_loc_lang.value)+"&a_second_name_loc_lang="+encodeURIComponent(document.Pass.a_second_name_loc_lang.value)+"&a_third_name_loc_lang="+encodeURIComponent(document.Pass.a_third_name_loc_lang.value)+"&a_family_name_loc_lang="+encodeURIComponent(document.Pass.a_family_name_loc_lang.value)+"&a_patient_name_loc_lang="+encodeURIComponent(document.Pass.a_patient_name_loc_lang.value)+"&pat_name_as_multipart_yn=<%=pat_name_as_multipart_yn%>&acpt_appt_rfrl_in_reg_pat_yn=<%=acpt_appt_rfrl_in_reg_pat_yn%>&names_in_oth_lang_yn=<%=names_in_oth_lang_yn%>&toDayDate=<%=toDayDate%>&cntlang=<%=cntlang%>&patient_id_length=<%=patient_id_length%>&oainstall_yn=<%=oainstall_yn%>&rdinstall_yn=<%=rdinstall_yn%>&opinstall_yn=<%=opinstall_yn%>&ipinstall_yn=<%=ipinstall_yn%>&race_code=<%=a_race_code%>"
						
					

					</script>




					</form>
					</body>
					</html>

				<%
				}
				else 
				{
				String prompts= rs.getString(2)+"~"+rs.getString(3) ;
				String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
				%>
				<html>
				<head>
				<title><fmt:message key="eMP.PatientRegistrationTitle.label" bundle="${mp_labels}"/></title>
				<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
				<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
				<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
				</head>
					<body class="CONTENT" onKeyDown = 'lockKey()'>
				<form name ="Pass" id ="Pass">
					<input type = "hidden" id = "SecondName" name = "SecondName" value = "<%=SecondName%>">					
					<input type = "hidden" id = "FirstName" name = "FirstName" value = "<%=FirstName%>">
					<input type = "hidden" id = "ThirdName" name = "ThirdName" value = "<%=ThirdName%>">
					
					<input type = "hidden" id = "FamilyName" name = "FamilyName" value = "<%=FamilyName%>">
					<input type = "hidden" id = "a_first_name_loc_lang" name = "a_first_name_loc_lang" value ="<%=a_first_name_loc_lang%>">
					<input type = "hidden" id = "a_second_name_loc_lang" name = "a_second_name_loc_lang" value ="<%=a_second_name_loc_lang%>">
					<input type = "hidden" id = "a_third_name_loc_lang" name = "a_third_name_loc_lang" value ="<%=a_third_name_loc_lang%>">
					<input type = "hidden" id = "a_family_name_loc_lang" name = "a_family_name_loc_lang" value ="<%=a_family_name_loc_lang%>">
					<input type = "hidden" id = "a_patient_name_loc_lang" name = "a_patient_name_loc_lang" value ="<%=a_patient_name_loc_lang%>">
				<script language='javascript'>
				
				async function showModal()    { 
					var retVal =    new String();

					//var dialogHeight    = "11" ;
					//var dialogWidth = "20" ;
					
						var dialogHeight= "30vh" ; ///added by Arun
						var dialogTop = "0vh" ;
						var dialogWidth	= "25vw" ;
	
					var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no ;";
					var arguments   = "" ;
					
					if (('<%=accept_national_id_no_yn%>'=='Y' && '<%=series%>'=='N') || ('<%=series%>'=='A'))
					{
						if( '<%=AltId2No%>' == '' && '<%=AltId3No%>' == '' && '<%=AltId4No%>' == '' && '<%=AltIdNo%>' == '' && '<%=NationalIdNo%>' == '') 
						{
							retVal = await window.showModalDialog("loadModal.jsp?series=<%=series%>&alt_id=<%=AltIdNo%>&National_Id_No=<%=NationalIdNo%>&prompt="+encodeURIComponent('<%=prompts%>')+"&nat_id_chk_digit_scheme=<%=nat_id_chk_digit_scheme%>",arguments,features);
							if(retVal == null)  retVal='G'
						 }
						 else
							retVal = 'G'
					}
					else
						retVal = 'G'

					var pat_grp = retVal.charAt(0);
					
					if ( pat_grp == 'N' )
					{ 
						var pat_id = escape(retVal.substr(1));
						//Below line modified for this incident [IN:038818]		
						window.location="PatRegMain.jsp?group="+pat_grp+"&nat_id="+pat_id+"&appt_ref_no=<%=appt_ref_no%>&ap=<%=ap%>&First_Name="+encodeURIComponent(document.Pass.FirstName.value)+"&Second_Name="+encodeURIComponent(document.Pass.SecondName.value)+"&Third_Name="+encodeURIComponent(document.Pass.ThirdName.value)+"&Family_Name="+encodeURIComponent(document.Pass.FamilyName.value)+"&Alt_Id_No=<%=AltIdNo%>&Sex=<%=Sex%>&MRN=<%=MRN%>&Area=<%=Area%>&Dob=<%=Dob%>&Family_No=<%=FamilyNo%>&func_act=<%=func_act%>&booking_ref_no=<%=booking_ref_no%>&referral_id=<%=referral_id%>&Alt_Id2_No=<%=AltId2No%>&Alt_Id3_No=<%=AltId3No%>&Alt_Id4_No=<%=AltId4No%>&function_id=<%=function_id%>&dr_function_id=<%=drfunctionid%>&calledFromModule=<%=calledFromModule%>&a_first_name_loc_lang="+encodeURIComponent(document.Pass.a_first_name_loc_lang.value)+"&a_second_name_loc_lang="+encodeURIComponent(document.Pass.a_second_name_loc_lang.value)+"&a_third_name_loc_lang="+encodeURIComponent(document.Pass.a_third_name_loc_lang.value)+"&a_family_name_loc_lang="+encodeURIComponent(document.Pass.a_family_name_loc_lang.value)+"&a_patient_name_loc_lang="+encodeURIComponent(document.Pass.a_patient_name_loc_lang.value)+"&pat_name_as_multipart_yn=<%=pat_name_as_multipart_yn%>&acpt_appt_rfrl_in_reg_pat_yn=<%=acpt_appt_rfrl_in_reg_pat_yn%>&names_in_oth_lang_yn=<%=names_in_oth_lang_yn%>&toDayDate=<%=toDayDate%>&cntlang=<%=cntlang%>&patient_id_length=<%=patient_id_length%>&oainstall_yn=<%=oainstall_yn%>&rdinstall_yn=<%=rdinstall_yn%>&opinstall_yn=<%=opinstall_yn%>&ipinstall_yn=<%=ipinstall_yn%>&race_code=<%=a_race_code%>"; 
					}
					else if ( pat_grp == 'A' )
					{
						var alt_id = escape(retVal.substr(1));
				        //Below line modified for this incident [IN:038818]		
						
						window.location="PatRegMain.jsp?group="+pat_grp+"&alt_id="+alt_id+"&appt_ref_no=<%=appt_ref_no%>&ap=<%=ap%>&First_Name="+encodeURIComponent(document.Pass.FirstName.value)+"&Second_Name="+encodeURIComponent(document.Pass.SecondName.value)+"&Third_Name="+encodeURIComponent(document.Pass.ThirdName.value)+"&Family_Name="+encodeURIComponent(document.Pass.FamilyName.value)+"&National_Id_No=<%=NationalIdNo%>&Sex=<%=Sex%>&MRN=<%=MRN%>&Area=<%=Area%>&Dob=<%=Dob%>&Family_No=<%=FamilyNo%>&func_act=<%=func_act%>&booking_ref_no=<%=booking_ref_no%>&referral_id=<%=referral_id%>&Alt_Id2_No=<%=AltId2No%>&Alt_Id3_No=<%=AltId3No%>&Alt_Id4_No=<%=AltId4No%>&function_id=<%=function_id%>&dr_function_id=<%=drfunctionid%>&calledFromModule=<%=calledFromModule%>&a_first_name_loc_lang="+encodeURIComponent(document.Pass.a_first_name_loc_lang.value)+"&a_second_name_loc_lang="+encodeURIComponent(document.Pass.a_second_name_loc_lang.value)+"&a_third_name_loc_lang="+encodeURIComponent(document.Pass.a_third_name_loc_lang.value)+"&a_family_name_loc_lang="+encodeURIComponent(document.Pass.a_family_name_loc_lang.value)+"&a_patient_name_loc_lang="+encodeURIComponent(document.Pass.a_patient_name_loc_lang.value)+"&pat_name_as_multipart_yn=<%=pat_name_as_multipart_yn%>&acpt_appt_rfrl_in_reg_pat_yn=<%=acpt_appt_rfrl_in_reg_pat_yn%>&names_in_oth_lang_yn=<%=names_in_oth_lang_yn%>&toDayDate=<%=toDayDate%>&cntlang=<%=cntlang%>&patient_id_length=<%=patient_id_length%>&oainstall_yn=<%=oainstall_yn%>&rdinstall_yn=<%=rdinstall_yn%>&opinstall_yn=<%=opinstall_yn%>&ipinstall_yn=<%=ipinstall_yn%>&race_code=<%=a_race_code%>"; 
					}
					else if ( pat_grp == 'G' )
					{ //Below line modified for this incident [IN:038818]		
					 window.location="PatRegMain.jsp?from_modal=Y&group=G&appt_ref_no=<%=appt_ref_no%>&ap=<%=ap%>&First_Name="+encodeURIComponent(document.Pass.FirstName.value)+"&Second_Name="+encodeURIComponent(document.Pass.SecondName.value)+"&Third_Name="+encodeURIComponent(document.Pass.ThirdName.value)+"&Family_Name="+encodeURIComponent(document.Pass.FamilyName.value)+"&Alt_Id_No=<%=AltIdNo%>&National_Id_No=<%=NationalIdNo%>&Sex=<%=Sex%>&MRN=<%=MRN%>&Area=<%=Area%>&Dob=<%=Dob%>&Family_No=<%=FamilyNo%>&func_act=<%=func_act%>&booking_ref_no=<%=booking_ref_no%>&referral_id=<%=referral_id%>&Alt_Id2_No=<%=AltId2No%>&Alt_Id3_No=<%=AltId3No%>&Alt_Id4_No=<%=AltId4No%>&function_id=<%=function_id%>&dr_function_id=<%=drfunctionid%>&calledFromModule=<%=calledFromModule%>&a_first_name_loc_lang="+encodeURIComponent(document.Pass.a_first_name_loc_lang.value)+"&a_second_name_loc_lang="+encodeURIComponent(document.Pass.a_second_name_loc_lang.value)+"&a_third_name_loc_lang="+encodeURIComponent(document.Pass.a_third_name_loc_lang.value)+"&a_family_name_loc_lang="+encodeURIComponent(document.Pass.a_family_name_loc_lang.value)+"&&a_patient_name_loc_lang="+encodeURIComponent(document.Pass.a_patient_name_loc_lang.value)+"&pat_name_as_multipart_yn=<%=pat_name_as_multipart_yn%>&acpt_appt_rfrl_in_reg_pat_yn=<%=acpt_appt_rfrl_in_reg_pat_yn%>&names_in_oth_lang_yn=<%=names_in_oth_lang_yn%>&toDayDate=<%=toDayDate%>&cntlang=<%=cntlang%>&patient_id_length=<%=patient_id_length%>&oainstall_yn=<%=oainstall_yn%>&rdinstall_yn=<%=rdinstall_yn%>&opinstall_yn=<%=opinstall_yn%>&ipinstall_yn=<%=ipinstall_yn%>&race_code=<%=a_race_code%>"; 
					}
				}
				</script>
				
			
				<script language='javascript'>

				setTimeout("showModal()",500);

				</script>


				</body>
				</html>
				<% 
				} 
			}
			else
				out.println("<script>alert(getMessage('PAT_NUM_NOT_CREATED','MP'));</script>") ;
		}
		else
			out.println("<script>alert(getMessage('PAT_SER_NOT_CREATED','MP'));</script>") ;
	} 
	else 
	{
		out.println("<script>alert(getMessage('MP_PARAM_NOT_FOUND','MP'));");
out.println("parent.parent.parent.parent.frames[1].expand()</script>");
	}
 
	if (rs!= null) rs.close();	
	if (pstmt != null) pstmt.close();	
}
catch(Exception e){out.println(e);out.println("test1"); e.printStackTrace();}
finally
{
  if(conn!=null) ConnectionManager.returnConnection(conn,request);
}

%>
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


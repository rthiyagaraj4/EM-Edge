<!DOCTYPE html>
<!-- Last Modified Date Time : 9/23/2005 11:29 AM -->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,eCommon.XSSRequestWrapper" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% 
request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String pat_grp		= request.getParameter("group");
String appt_ref_no	= request.getParameter("appt_ref_no");
String FirstName	= request.getParameter("First_Name");if(FirstName==null)FirstName="";
String SecondName	= request.getParameter("Second_Name");if(SecondName==null)SecondName="";
String ThirdName	= request.getParameter("Third_Name");if(ThirdName==null)ThirdName="";
String FamilyName=request.getParameter("Family_Name");if(FamilyName==null)FamilyName="";
String AltIdNo=request.getParameter("Alt_Id_No");if(AltIdNo==null)AltIdNo="";
String NationalIdNo=request.getParameter("National_Id_No");if(NationalIdNo==null)NationalIdNo="";
String MRN=request.getParameter("MRN");if(MRN==null)MRN="";
String Dob=request.getParameter("Dob");if(Dob==null)Dob="";
String Sex=request.getParameter("Sex");if(Sex==null)Sex="";
String Area=request.getParameter("Area");if(Area==null)Area="";
String FamilyNo=request.getParameter("Family_No");if(FamilyNo==null) FamilyNo="";
String func_act = request.getParameter("func_act");if(func_act == null) func_act="";
String frommodal=request.getParameter("from_modal");if(frommodal == null) frommodal="";
String booking_ref_no = request.getParameter("booking_ref_no") == null? "": request.getParameter("booking_ref_no");
String referral_id = request.getParameter("referral_id");if(referral_id==null) referral_id="";
String q_booking_type = request.getParameter("q_booking_type");
if(q_booking_type==null) q_booking_type="";

String AltId2No=request.getParameter("Alt_Id2_No");if(AltId2No==null)AltId2No="";
String AltId3No=request.getParameter("Alt_Id3_No");if(AltId3No==null)AltId3No="";
String AltId4No=request.getParameter("Alt_Id4_No");if(AltId4No==null)AltId4No="";
String drfunctionid = request.getParameter("dr_function_id");
if(drfunctionid == null) drfunctionid="";
String calledFromModule = request.getParameter("calledFromModule");
if(calledFromModule == null || calledFromModule.equals("null")) calledFromModule="";
/*FirstName = java.net.URLEncoder.encode(FirstName);
SecondName = java.net.URLEncoder.encode(SecondName);
ThirdName = java.net.URLEncoder.encode(ThirdName);
FamilyName = java.net.URLEncoder.encode(FamilyName);*/

AltIdNo = java.net.URLEncoder.encode(AltIdNo);
AltId2No = java.net.URLEncoder.encode(AltId2No);
AltId3No = java.net.URLEncoder.encode(AltId3No);
AltId4No = java.net.URLEncoder.encode(AltId4No);

String a_family_name_loc_lang		= checkForNull( request.getParameter("a_family_name_loc_lang") );
String a_first_name_loc_lang		= checkForNull( request.getParameter("a_first_name_loc_lang") );
String a_second_name_loc_lang		= checkForNull( request.getParameter("a_second_name_loc_lang") );
String a_third_name_loc_lang		= checkForNull( request.getParameter("a_third_name_loc_lang") );

String pat_name_as_multipart_yn		= checkForNull( request.getParameter("pat_name_as_multipart_yn") );
String acpt_appt_rfrl_in_reg_pat_yn		= checkForNull( request.getParameter("acpt_appt_rfrl_in_reg_pat_yn") );
String names_in_oth_lang_yn		= checkForNull( request.getParameter("names_in_oth_lang_yn") );
String cntlang		= checkForNull( request.getParameter("cntlang") );
String toDayDate		= checkForNull( request.getParameter("toDayDate") );
String patient_id_length		= checkForNull( request.getParameter("patient_id_length"));

String oainstall_yn		= checkForNull( request.getParameter("oainstall_yn") );
String rdinstall_yn		= checkForNull( request.getParameter("rdinstall_yn") );
String opinstall_yn		= checkForNull( request.getParameter("opinstall_yn") );
String ipinstall_yn		= checkForNull( request.getParameter("ipinstall_yn") );

String a_race_code  = checkForNull(request.getParameter("race_code"));//Added By Dharma on 20th Aug 2020 against ML-MMOH-SCF-1384


if(q_booking_type.equals("D") && !booking_ref_no.equals("")){
	appt_ref_no = booking_ref_no;
	booking_ref_no = "";
}


if(pat_grp.equals("N"))
{
    String nat_id = request.getParameter("nat_id");
   nat_id = java.net.URLEncoder.encode(nat_id) ;

  <!--out.println("<html><frameset rows=\"76,*\" frameborder=\"0\" border=\"0\" framespacing=\"1\"><frame name=\"patient_main\"  id=\"patient_main\" src=\"../jsp/PatientRegHead.jsp?operation=insert&group=N&dr_function_id="+drfunctionid+"&appt_ref_no="+appt_ref_no+"&booking_ref_no="+booking_ref_no+"&referral_id="+referral_id+"&calledFromModule="+calledFromModule+"&pat_name_as_multipart_yn="+pat_name_as_multipart_yn+"&acpt_appt_rfrl_in_reg_pat_yn="+acpt_appt_rfrl_in_reg_pat_yn+"&names_in_oth_lang_yn="+names_in_oth_lang_yn+"&cntlang="+cntlang+"&toDayDate="+toDayDate+"&patient_id_length="+patient_id_length+"&oainstall_yn="+oainstall_yn+"&rdinstall_yn="+rdinstall_yn+"&opinstall_yn="+opinstall_yn+"&ipinstall_yn="+ipinstall_yn+"\" scrolling=\"no\" noresize> <frame name=\"patient_sub\" id=\"patient_sub\" src=\"../jsp/NewPatientRegistration.jsp?group="+pat_grp+"&dr_function_id="+drfunctionid+"&nat_id="+nat_id+"&appt_ref_no="+appt_ref_no+"&First_Name="+java.net.URLEncoder.encode(FirstName)+"&Second_Name="+java.net.URLEncoder.encode(SecondName)+"&Third_Name="+java.net.URLEncoder.encode(ThirdName)+"&Family_Name="+FamilyName+"&Alt_Id_No="+AltIdNo+"&National_Id_No="+NationalIdNo+"&MRN="+MRN+"&Dob="+Dob+"&Sex="+Sex+"&Area="+Area+"&Family_No="+FamilyNo+"&func_act="+func_act+"&booking_ref_no="+booking_ref_no+"&referral_id="+referral_id+"&Alt_Id2_No="+AltId2No+"&Alt_Id3_No="+AltId3No+"&Alt_Id4_No="+AltId4No+"&calledFromModule="+calledFromModule+"&a_first_name_loc_lang="+a_first_name_loc_lang+"&a_second_name_loc_lang="+a_second_name_loc_lang+"&a_third_name_loc_lang="+a_third_name_loc_lang+"&race_code="+a_race_code+"&a_family_name_loc_lang="+a_family_name_loc_lang+"\" scrolling=\"no\" noresize></frameset></html>");//Modified on 8-3-2012 for the incident IN031010-->
    out.println("<html><iframe name=\"patient_main\"  id=\"patient_main\" src=\"../jsp/PatientRegHead.jsp?operation=insert&group=N&dr_function_id="+drfunctionid+"&appt_ref_no="+appt_ref_no+"&booking_ref_no="+booking_ref_no+"&referral_id="+referral_id+"&calledFromModule="+calledFromModule+"&pat_name_as_multipart_yn="+pat_name_as_multipart_yn+"&acpt_appt_rfrl_in_reg_pat_yn="+acpt_appt_rfrl_in_reg_pat_yn+"&names_in_oth_lang_yn="+names_in_oth_lang_yn+"&cntlang="+cntlang+"&toDayDate="+toDayDate+"&patient_id_length="+patient_id_length+"&oainstall_yn="+oainstall_yn+"&rdinstall_yn="+rdinstall_yn+"&opinstall_yn="+opinstall_yn+"&ipinstall_yn="+ipinstall_yn+"\" scrolling=\"no\" noresize style='height:15vh;width:100vw'></iframe> <iframe name=\"patient_sub\" id='patient_sub' src='../jsp/NewPatientRegistration.jsp?group="+pat_grp+"&dr_function_id="+drfunctionid+"&nat_id="+nat_id+"&appt_ref_no="+appt_ref_no+"&First_Name="+java.net.URLEncoder.encode(FirstName)+"&Second_Name="+java.net.URLEncoder.encode(SecondName)+"&Third_Name="+java.net.URLEncoder.encode(ThirdName)+"&Family_Name="+FamilyName+"&Alt_Id_No="+AltIdNo+"&National_Id_No="+NationalIdNo+"&MRN="+MRN+"&Dob="+Dob+"&Sex="+Sex+"&Area="+Area+"&Family_No="+FamilyNo+"&func_act="+func_act+"&booking_ref_no="+booking_ref_no+"&referral_id="+referral_id+"&Alt_Id2_No="+AltId2No+"&Alt_Id3_No="+AltId3No+"&Alt_Id4_No="+AltId4No+"&calledFromModule="+calledFromModule+"&a_first_name_loc_lang="+a_first_name_loc_lang+"&a_second_name_loc_lang="+a_second_name_loc_lang+"&a_third_name_loc_lang="+a_third_name_loc_lang+"&race_code="+a_race_code+"&a_family_name_loc_lang="+a_family_name_loc_lang+"' scrolling=\"no\" noresize style='height:85vh;width:100vw'><iframe></html>");//Modified on 8-3-2012 for the incident IN031010

   //Above line modified for this incident [IN:038818]
}

if ( pat_grp.equals("A") )
{
    AltIdNo = request.getParameter("alt_id");
    AltIdNo = java.net.URLEncoder.encode(AltIdNo) ;
  
	out.println("<html><iframe name=\"patient_main\" id=\"patient_main\" src=\"../jsp/PatientRegHead.jsp?operation=insert&group=A&dr_function_id="+drfunctionid+"&appt_ref_no="+appt_ref_no+"&booking_ref_no="+booking_ref_no+"&referral_id="+referral_id+"&calledFromModule="+calledFromModule+"&pat_name_as_multipart_yn="+pat_name_as_multipart_yn+"&acpt_appt_rfrl_in_reg_pat_yn="+acpt_appt_rfrl_in_reg_pat_yn+"&names_in_oth_lang_yn="+names_in_oth_lang_yn+"&cntlang="+cntlang+"&toDayDate="+toDayDate+"&patient_id_length="+patient_id_length+"&oainstall_yn="+oainstall_yn+"&rdinstall_yn="+rdinstall_yn+"&opinstall_yn="+opinstall_yn+"&ipinstall_yn="+ipinstall_yn+"\" frameborder=\"0\" scrolling=\"no\" noresize style='height:15vh;width:100vw'></iframe> <iframe name=\"patient_sub\" id='patient_sub' src='../jsp/NewPatientRegistration.jsp?group="+pat_grp+"&dr_function_id="+drfunctionid+"&appt_ref_no="+appt_ref_no+"&First_Name="+java.net.URLEncoder.encode(FirstName)+"&Second_Name="+java.net.URLEncoder.encode(SecondName)+"&Third_Name="+java.net.URLEncoder.encode(ThirdName)+"&Family_Name="+FamilyName+"&Alt_Id_No="+AltIdNo+"&National_Id_No="+NationalIdNo+"&MRN="+MRN+"&Dob="+Dob+"&Sex="+Sex+"&Area="+Area+"&Family_No="+FamilyNo+"&func_act="+func_act+"&booking_ref_no="+booking_ref_no+"&referral_id="+referral_id+"&Alt_Id2_No="+AltId2No+"&Alt_Id3_No="+AltId3No+"&Alt_Id4_No="+AltId4No+"&calledFromModule="+calledFromModule+"&a_first_name_loc_lang="+a_first_name_loc_lang+"&a_second_name_loc_lang="+a_second_name_loc_lang+"&a_third_name_loc_lang="+a_third_name_loc_lang+"&race_code="+a_race_code+"&a_family_name_loc_lang="+a_family_name_loc_lang+"' frameborder=\"0\" scrolling=\"no\" noresize style='height:85vh;width:100vw'><iframe></html>");//Modified on 8-3-2012 for the incident IN031010
	//Above line modified for this incident [IN:038818]
}


if ( pat_grp.equals("G") )
{
   SecondName = java.net.URLEncoder.encode(SecondName,"UTF-8") ;
   FirstName = java.net.URLEncoder.encode(FirstName,"UTF-8") ;
   ThirdName = java.net.URLEncoder.encode(ThirdName,"UTF-8") ;
   FamilyName = java.net.URLEncoder.encode(FamilyName,"UTF-8") ;
   a_first_name_loc_lang = java.net.URLEncoder.encode(a_first_name_loc_lang,"UTF-8") ;
   a_family_name_loc_lang = java.net.URLEncoder.encode(a_family_name_loc_lang,"UTF-8") ;    
   a_second_name_loc_lang = java.net.URLEncoder.encode(a_second_name_loc_lang,"UTF-8") ;
	a_third_name_loc_lang = java.net.URLEncoder.encode(a_third_name_loc_lang,"UTF-8") ;
   
	out.println("<html><iframe name=\"patient_main\" id=\"patient_main\"   src=\"../jsp/PatientRegHead.jsp?operation=insert&group=G&dr_function_id="+drfunctionid+"&appt_ref_no="+appt_ref_no+"&booking_ref_no="+booking_ref_no+"&referral_id="+referral_id+"&calledFromModule="+calledFromModule+"&pat_name_as_multipart_yn="+pat_name_as_multipart_yn+"&acpt_appt_rfrl_in_reg_pat_yn="+acpt_appt_rfrl_in_reg_pat_yn+"&names_in_oth_lang_yn="+names_in_oth_lang_yn+"&cntlang="+cntlang+"&toDayDate="+toDayDate+"&patient_id_length="+patient_id_length+"&oainstall_yn="+oainstall_yn+"&rdinstall_yn="+rdinstall_yn+"&opinstall_yn="+opinstall_yn+"&ipinstall_yn="+ipinstall_yn+"\" frameborder=\"0\" scrolling=\"no\" noresize style='height:14vh;width:100vw'></iframe> <iframe name=\"patient_sub\" id='patient_sub' src='../jsp/NewPatientRegistration.jsp?from_modal="+frommodal+"&dr_function_id="+drfunctionid+"&group=G&appt_ref_no="+appt_ref_no+"&First_Name="+FirstName+"&Second_Name="+SecondName+"&Third_Name="+ThirdName+"&Family_Name="+FamilyName+"&Alt_Id_No="+AltIdNo+"&National_Id_No="+NationalIdNo+"&MRN="+MRN+"&Dob="+Dob+"&Sex="+Sex+"&Area="+Area+"&Family_No="+FamilyNo+"&func_act="+func_act+"&booking_ref_no="+booking_ref_no+"&q_booking_type="+q_booking_type+"&referral_id="+referral_id+"&Alt_Id2_No="+AltId2No+"&Alt_Id3_No="+AltId3No+"&Alt_Id4_No="+AltId4No+"&calledFromModule="+calledFromModule+"&a_first_name_loc_lang="+a_first_name_loc_lang+"&a_second_name_loc_lang="+a_second_name_loc_lang+"&a_third_name_loc_lang="+a_third_name_loc_lang+"&race_code="+a_race_code+"&a_family_name_loc_lang="+a_family_name_loc_lang+"'  frameborder=\"0\" scrolling=\"no\" noresize style='height:85vh;width:100vw'><iframe></html>");//Modified on 8-3-2012 for the incident IN031010
	//Above line modified for this incident [IN:038818]
	
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


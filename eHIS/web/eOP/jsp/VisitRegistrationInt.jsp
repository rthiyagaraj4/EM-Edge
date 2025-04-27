<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*, java.text.*,java.io.*, javax.servlet.jsp.JspWriter,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*,eCommon.Common.*,org.json.simple.*,eCommon.XSSRequestWrapper" %>
<HTML>
<HEAD>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eOP/js/VisitRegistrationQuery.js' language='javascript'></script>
<script src='../../eOP/js/VisitRegistration.js' language='javascript'></script>
<script src='../../eBL/js/AddModifyPatFinDetails.js' language='Javascript'></script>
<script language='javascript' src='../../eCommon/js/jquery.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</script>
<script>

</script>
<%
     request.setCharacterEncoding("UTF-8");
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");       
	 response.addHeader("X-Content-Type-Options", "nosniff");
	 String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</HEAD>
<BODY CLASS='MESSAGE' onKeyDown="lockKey()">
  <form name='testform' id='testform'>
   <%
	Connection con 	= null;
	PreparedStatement pstmt=null;
	Statement stmt    = null;
	ResultSet rs    = null; 
	String str1="";
    String str2="";
	char  alert_yn='N';
	
	// String fromchk="";
	try
	{
    
	con = ConnectionManager.getConnection(request);
	Boolean isAllowRegForSameService=false; //Added by Mujafar  for ML-MMOH-CRF-1437
	isAllowRegForSameService = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "ALLOW_VISIT_SAME_SER");//Added by Mujafar  for GHL-CRF-0527
	String fromPatidF1="";
 // String functionId="";
	String  allow_walk_in_yn="";
	String allow_referral_yn="";
	String allow_appt_yn="";
	String callFromMenu_yn="";
	String func_source="";
    String fromchk="";
	String locale=(String)session.getAttribute("LOCALE");
	//venkat
	String entitlement_by_cat_yn=request.getParameter("entitlement_by_cat_yn");
    /*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
	String upt_contact_dtls_oa_yn=request.getParameter("upt_contact_dtls_oa_yn")==null?"":request.getParameter("upt_contact_dtls_oa_yn");
	
	String queryString=request.getParameter("query_str")==null?"":request.getParameter("query_str");
	queryString=java.net.URLDecoder.decode(queryString,"UTF-8");
	String userid         = (String) session.getValue("login_user");
	String bl_install_yn=request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
	String or_install_yn=request.getParameter("or_install_yn")==null?"":request.getParameter("or_install_yn");
	String p_referral_id=request.getParameter("p_referral_id")==null?"":request.getParameter("p_referral_id");
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String register_visit_walkin=request.getParameter("register_visit_walkin")==null?"":request.getParameter("register_visit_walkin");
	String register_visit_referral=request.getParameter("register_visit_referral")==null?"":request.getParameter("register_visit_referral");
	String list_name=  request.getParameter("list_name")==null?"":request.getParameter("list_name");
	String oper_stn_id=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
	String emer_regn_allow_yn=request.getParameter("emer_regn_allow_yn")==null?"":request.getParameter("emer_regn_allow_yn");
    String  visit_for_inpat_yn=request.getParameter("visit_for_inpat_yn")==null?"":request.getParameter("visit_for_inpat_yn");	
	String q_appt_ref_no= request.getParameter("q_appt_ref_no")==null?"":request.getParameter("q_appt_ref_no");
	//String l_service_encounter_id="";
	String prompt_patient_id= request.getParameter("prompt_patient_id")==null?"":request.getParameter("prompt_patient_id");
	String alt_id_type_desc="";
	String alt_id_type=request.getParameter("alt_id_type")==null?"":request.getParameter("alt_id_type");
	String sql="";
	String build_episode_rule=request.getParameter("build_episode_rule")==null?"":request.getParameter("build_episode_rule");
	String functionId=request.getParameter("functionId")==null?"":request.getParameter("functionId");
	String nat_id_prompt=request.getParameter("nat_id_prompt")==null?"":request.getParameter("nat_id_prompt");
	
	StringBuffer vsql =new StringBuffer();
	String VisitDate = "";
	//String l_encounter_id   = request.getParameter("l_encounter_id")==null?"":request.getParameter("l_encounter_id");
	String service_code= request.getParameter("service_code")==null?"":request.getParameter("service_code");
	String q_visit_adm_type_ind= request.getParameter("q_visit_adm_type_ind")==null?"":request.getParameter("q_visit_adm_type_ind");
	String visit_adm_type = request.getParameter("visit_adm_type")==null?"":request.getParameter("visit_adm_type");	
	//String prev_visit = request.getParameter("prev_visit")==null?"N":request.getParameter("prev_visit") ;
	String facility_id= (String) session.getValue("facility_id");
	String episodeReqd=request.getParameter("episodeReqd")==null?"":request.getParameter("episodeReqd");
	String subservicecode="";
	String locncode = request.getParameter("care_locn_code")==null?"":request.getParameter("care_locn_code");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String allow_pop_subser = request.getParameter("allow_pop_subser")==null?"":request.getParameter("allow_pop_subser");
	String frame_ref="parent.frames[1].frames[3].document.";

	String override_vtype_on_epsd_yn = request.getParameter("override_vtype_on_epsd_yn")==null?"N":request.getParameter("override_vtype_on_epsd_yn");	
	String populate_visit_type = request.getParameter("populate_visit_type")==null?"":request.getParameter("populate_visit_type");	
	String visit_type_derv_rule = request.getParameter("visit_type_derv_rule")==null?"":request.getParameter("visit_type_derv_rule");	
	String attend_practitioner_id = request.getParameter("attend_practitioner_id")==null?"":request.getParameter("attend_practitioner_id");	
	String appt_vst_type_code = request.getParameter("appt_vst_type_code")==null?"":request.getParameter("appt_vst_type_code");	//Included for the MMS-SCF-0010 
	
	/*Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659] */
	String order_count_select=request.getParameter("order_count_select")==null?"0":request.getParameter("order_count_select");
	int order_count_appointment=Integer.parseInt(order_count_select);	

	boolean isMohbr = CommonBean.isSiteSpecific(con, "OP","DFLT_APPT_VISIT_TYPE");//Added for the CRF - PMG2013-BRU-CRF-0002
	boolean isUHID_valid_appl = CommonBean.isSiteSpecific(con, "MP","UHID_VALID_DAYS_APPL"); // Added by mujafar for AMRI-CRF-0357

	Boolean isNationalIdValidationAppl = CommonBean.isSiteSpecific(con, "MP", "NATIONAL_ID_VALIDATION"); //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
	boolean isNatIdOrAltIdMandVisaType = CommonBean.isSiteSpecific(con, "MP", "MP_RES_VAL_VISA_TYPE"); /*Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750]*/
	boolean isNatIdAltIdMandVisaType = CommonBean.isSiteSpecific(con, "MP", "MP_VAL_VISA_TYPE");//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
	boolean isInvokeChngPatDtls = CommonBean.isSiteSpecific(con, "MP", "MP_RESIDENCY_NAT_ALT1_ID_MAND"); //Added by Dharma on 24th Apr 2019 against MMS-DM-CRF-0152.1 [IN:070226]
	String isRoomMandatoryRegVisit = request.getParameter("isRoomMandatoryRegVisit")==null?"false":request.getParameter("isRoomMandatoryRegVisit"); // added by mujafar for NMC-JD-CRF-0025
	boolean isChkMPParamMandFlds = CommonBean.isSiteSpecific(con, "MP", "MP_CHK_MAND_FLDS"); /*Added by Dharma on 12th May 2020 against KDAH-CRF-0522.1*/

	boolean isCountryRegionValAppl = CommonBean.isSiteSpecific(con, "MP", "CHECK_COUNTRY_REGION");//Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1
	
%>
<script>
  <%

if (list_name.equals("check_pat"))// on blur if patient id...
 {
	 	
	 	StringBuffer whereClause =new StringBuffer();
		String NRICNo = request.getParameter("NRICNo")==null?"":request.getParameter("NRICNo");
		String otherAlternateIDType = request.getParameter("otherAlternateIDType")==null?"":request.getParameter("otherAlternateIDType");
		String otherAlternateIDNo = request.getParameter("otherAlternateIDNo")==null?"":request.getParameter("otherAlternateIDNo");

		String altIdNo1 = request.getParameter("alternateIDNo1")==null?"":request.getParameter("alternateIDNo1");
		String names_in_oth_lang_yn = request.getParameter("names_in_oth_lang_yn")==null?"N":request.getParameter("names_in_oth_lang_yn");
			
		/*Below line Added for this SCF  MMS-SCF-0071 [IN:042582]*/		
		String altIdNo2 = request.getParameter("alternateIDNo2")==null?"":request.getParameter("alternateIDNo2");
		String altIdNo3 = request.getParameter("alternateIDNo3")==null?"":request.getParameter("alternateIDNo3");
		String altIdNo4 = request.getParameter("alternateIDNo4")==null?"":request.getParameter("alternateIDNo4");
	   //End MMS-SCF-0071 [IN:042582]

		//whereClause.append(" where ");
		String alternateIDNo[]=new String[4];
		String alternateIDDesc[] =new String[4];
		boolean alternateIDExists = false;
		String altstr="";			
		//String names_in_oth_lang_yn = "N";

		/*
			
		sql = "SELECT   mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+locale+"','1') alt_id1_desc,  mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,'"+locale+"','1') alt_id2_desc,  mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id3_type,'"+locale+"','1') alt_id3_desc,  mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id4_type,'"+locale+"','1') alt_id4_desc,names_in_oth_lang_yn FROM   mp_param WHERE module_id='MP'";

		
		pstmt = con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
		  for(int j=0;j<4;j++)
			{
			  alternateIDDesc[j]=rs.getString("alt_id"+(j+1)+"_desc");
			}
			names_in_oth_lang_yn = rs.getString("names_in_oth_lang_yn")==null?"N":rs.getString("names_in_oth_lang_yn");
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		*/		
	
		if(patient_id.equals(""))
		{    
		  PreparedStatement idStatement=null;
		  ResultSet idResult=null;

		  if(!NRICNo.equals(""))
		  {
			whereClause.append(" UPPER(national_id_no) = UPPER('"+NRICNo+"') "); // this line modified for this SCF MMS-SCF-0071 [IN:042582]
			altstr="National ID";
			alternateIDExists = true;
		  }
		
		  if(!otherAlternateIDNo.equals(""))
		  {
			if(alternateIDExists) {
				whereClause.append(" and oth_alt_id_type = '"+otherAlternateIDType+"' and UPPER(oth_alt_id_no) = UPPER('"+otherAlternateIDNo+"') ");
				// this line modified for this SCF MMS-SCF-0071 [IN:042582]
			} else {
				whereClause.append(" oth_alt_id_type = '"+otherAlternateIDType+"' and UPPER(oth_alt_id_no) = UPPER('"+otherAlternateIDNo+"') "); // this line modified for this SCF MMS-SCF-0071 [IN:042582]
			}
			altstr="Other Alternate ID";
			alternateIDExists = true;
		  }

		
		   if(!prompt_patient_id.equals(""))
		   {
			 if(alternateIDExists) {
				whereClause.append(" and patient_id='"+prompt_patient_id+"' ");
			 } else {
				whereClause.append(" patient_id='"+prompt_patient_id+"' ");
			 }
		   } 

		   for(int i=0;i<4;i++)
		   {
				alternateIDDesc[i]=request.getParameter("alt_id"+(i+1)+"_desc");			
				alternateIDNo[i]=request.getParameter("alternateIDNo"+(i+1));
				
				if(alternateIDNo[i] == null)
					alternateIDNo[i] = "";
				
				if(!alternateIDNo[i].equals(""))
				{
					if(alternateIDExists || (!prompt_patient_id.equals(""))) {
						whereClause.append(" and UPPER(alt_id"+(i+1)+"_no) = UPPER('"+alternateIDNo[i]+"') "); // this line modified for this SCF MMS-SCF-0071 [IN:042582]
					} else {
						whereClause.append(" UPPER(alt_id"+(i+1)+"_no) = UPPER('"+alternateIDNo[i]+"') "); // this line modified for this SCF MMS-SCF-0071 [IN:042582]
					}
					altstr=alternateIDDesc[i];
					alternateIDExists = true;
				}
		   } 		 
		  
		 if(alternateIDExists || (!prompt_patient_id.equals("")))
		{
		   if(alternateIDExists) {  
		   //Below condtion added Query tuning for full table scan [IN:051268]
		    if(!whereClause.toString().equals("")) whereClause.append(" AND  PATIENT_ID BETWEEN NVL ('%%','%%')  AND NVL ('',PATIENT_ID) AND PATIENT_ID LIKE '%%'");
			
		   String idSql="Select patient_id from mp_patient where " + whereClause.toString(); 	

           	   
		   
		   idStatement=con.prepareStatement(idSql);	
		   idResult=idStatement.executeQuery();
		   
		  
			  if(idResult!=null && idResult.next())
			  {
					
					prompt_patient_id = idResult.getString("patient_id");
	/*Below condtion modified for this SCF this SCF  MMS-SCF-0071 [IN:042582]*/				
	if(!altIdNo1.equals("") || !altIdNo2.equals("") || !altIdNo3.equals("") || !altIdNo4.equals("") || !otherAlternateIDNo.equals("")) { 
						if(idResult.next()) {
							prompt_patient_id = "";
							%>
							; async function toHoldShowModal1(){
							var dialogHeight= "80vh" ;
							var dialogWidth = "80vw" ;
		                    var wintop = "210"
							var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:" + wintop +";status=no";
		                    var arguments   = "" ;

							
							/*Below line modified for this SCF MMS-SCF-0071 [IN:042582]*/

							var patientId = await top.window.showModalDialog("../../eOP/jsp/OPPatientListforAltId.jsp?altIdNo1=<%=altIdNo1%>&altIdNo2=<%=altIdNo2%>&altIdNo3=<%=altIdNo3%>&altIdNo4=<%=altIdNo4%>&otherAlternateIDType=<%=otherAlternateIDType%>&otherAlternateIDNo=<%=otherAlternateIDNo%>&names_in_oth_lang_yn=<%=names_in_oth_lang_yn%>",arguments,features); 						    
							if(patientId!=undefined && patientId!='undefined') {
								showPatientListforAltId1(patientId);							
							}
							}
							toHoldShowModal1();
							<%
							

						}
					}
			
			  }
			  else
			  {
				if(alternateIDExists){
					prompt_patient_id="";
					out.println("var message=parent.frames[1].frames[1].getMessage('INVALID_ALT_ID','MP'); alert(message.replace('$','"+altstr+"'));parent.frames[1].frames[1].document.forms[0].clear1.click();");
				}
			  }
					alert_yn = 'N';
			}
			  } else {
				 out.println("var message=parent.frames[1].frames[1].getMessage('ANY_ONE_CRITERIA','Common');alert(message);parent.frames[1].frames[1].document.forms[0].clear1.click();");
			  }

			

			if(idResult != null) idResult.close();
			if(idStatement != null) idStatement.close();
			whereClause.setLength(0);
	  
    }
  
   
   if(!prompt_patient_id.equals("")){ //modified by mujafar for AMRI-CRF-0357
/*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
	/*Modified by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
	/* isNatIdOrAltIdMandVisaType Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750]*/
	//isChkMPParamMandFlds Added By Dharma on 12th May 2020 against KDAH-CRF-0522.1
	//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
	check_patient_id(out,prompt_patient_id,prompt_patient_id,facility_id,fromchk,con,functionId, bl_install_yn,fromPatidF1,callFromMenu_yn,func_source,called_from,register_visit_walkin,register_visit_referral,oper_stn_id,build_episode_rule,or_install_yn,emer_regn_allow_yn,visit_for_inpat_yn,nat_id_prompt,queryString,locale,entitlement_by_cat_yn,upt_contact_dtls_oa_yn,isUHID_valid_appl,isNationalIdValidationAppl,isNatIdOrAltIdMandVisaType,isInvokeChngPatDtls,isChkMPParamMandFlds,isCountryRegionValAppl,isNatIdAltIdMandVisaType);
   }

  
}

if (list_name.equals("financial_detail_ref_id"))
{
	patient_id=request.getParameter("patient_id");
    PreparedStatement pstmt_ref_id_finance=null;
    ResultSet rset_ref_id_finance = null;
    String org_type_data ="";
    String referral_id_data="";
    PreparedStatement refTypePstmt = null;
    ResultSet refTypeRS = null;
    String 	from_ref_type="";
    String 	from_ref_code="";
    pstmt_ref_id_finance=con.prepareStatement("select referral_id from op_patient_queue where facility_id = '"+facility_id+"' and patient_id ='"+patient_id+"' and episode_id = (select episode_id from op_episode_for_service where patient_id ='"+patient_id+"' and operating_facility_id = '"+facility_id+"'  and service_code ='"+service_code+"' and episode_status = '01'  ) and referral_id is not null order by modified_date desc");
    rset_ref_id_finance = pstmt_ref_id_finance.executeQuery();

	if ( rset_ref_id_finance.next())
    {
	    referral_id_data= rset_ref_id_finance.getString( "referral_id" ) ;
        if(referral_id_data==null) referral_id_data="ref_id_not_found";

		//naren - execute the below query only if referral_id_data is not null

		if(!referral_id_data.equals(""))
		{	
			String refTypeSQL ="select from_ref_type, from_ref_code, (case when from_ref_code is not null then (select org_type from am_referral where referral_code = from_ref_code) end) org_type from pr_referral_register where referral_id = ?";
			
			refTypePstmt = con.prepareStatement( refTypeSQL);
			refTypePstmt.setString (1,referral_id_data ) ;
			refTypeRS = refTypePstmt.executeQuery() ;
			
			if(refTypeRS!=null && refTypeRS.next()) 
			{	
			   from_ref_type = refTypeRS.getString( "from_ref_type");
			   from_ref_code = refTypeRS.getString( "from_ref_code");
			}
		}

		if(from_ref_type.equals("E") || from_ref_type.equals("L"))
		{
			org_type_data="G";				
		}
		else
		{
			org_type_data = refTypeRS.getString( "org_type");

				 /*
				  String orgTypeSQL ="select org_type from am_referral where referral_code = ?";
				  orgTypePstmt = con.prepareStatement( orgTypeSQL );
				  orgTypePstmt.setString ( 1, from_ref_code ) ;
				  orgTypeRS = orgTypePstmt.executeQuery() ;

				  if(orgTypeRS!=null && orgTypeRS.next()) 
				   {
					  org_type_data = orgTypeRS.getString( "org_type");
					  if(org_type_data==null)  		
					  org_type_data="";					
				   }
					if(orgTypeRS != null) orgTypeRS.close();
					if(orgTypePstmt != null) orgTypePstmt.close();*/
		 }

		if(refTypeRS != null) refTypeRS.close();
		if(refTypePstmt != null) refTypePstmt.close();
      }
}

if (list_name.equals("ValidateReferal"))
{
	
   boolean chk_valid = true ; 
  sql="select A.TO_FACILITY_ID, A.TO_LOCN_TYPE, A.TO_LOCN_CODE, A.TO_SERVICE_CODE, A.ORDER_CATALOG_CODE, A.STATUS, A.PATIENT_ID, A.TO_PRACT_ID from PR_REFERRAL_REGISTER A where A.REFERRAL_ID=? and to_facility_id = ? " ;
    
   pstmt = con.prepareStatement(sql);
   pstmt.setString(1,p_referral_id);
   pstmt.setString(2,facility_id);
   rs    =  pstmt.executeQuery();
   StringBuffer sqlsel=new StringBuffer();
   sqlsel.setLength(0);
   if(rs.next())
    {
	String to_facility_id   = "";
	String to_locn_type     = "";   
	String to_clinic_code   = "";  
	String ref_status   = "";   
	String to_pract_id  = "";     
	String clinic_valid_yn = "Y" ;
	
	String level_of_care_ind="";
	String to_service_code="";
	String to_order_code="";
	String menu_function_id = functionId;
	String function_id = "";
	
	to_facility_id = rs.getString("TO_FACILITY_ID")==null?"":rs.getString("TO_FACILITY_ID");
	to_locn_type   = rs.getString("TO_LOCN_TYPE")==null?"":rs.getString("TO_LOCN_TYPE");  
	to_clinic_code = rs.getString("TO_LOCN_CODE")==null?"":rs.getString("TO_LOCN_CODE");
	to_service_code = rs.getString("TO_SERVICE_CODE")==null?"":rs.getString("TO_SERVICE_CODE");
	to_order_code  =rs.getString("ORDER_CATALOG_CODE")==null?"":rs.getString("ORDER_CATALOG_CODE");
	ref_status     = rs.getString("STATUS");        if(ref_status == null)    ref_status = "" ;
	patient_id     = rs.getString("PATIENT_ID");    if(patient_id == null)  patient_id = "" ;
	to_pract_id    = rs.getString("TO_PRACT_ID");   if(to_pract_id == null)  to_pract_id = "" ;
	if(!to_locn_type.equals("")) {
		if(to_locn_type.equals("C")) {	 			
			function_id = "VISIT_REGISTRATION";
		} else if(to_locn_type.equals("E"))	{
			function_id = "PROCD_REGISTRATION";
		} 
	}	// naren - to be checked and removed	 

	if(!to_locn_type.equals("") ) {
	  if(to_locn_type.equals("C") || to_locn_type.equals("E")) {
        if(pstmt != null) pstmt.close();	       
		   if(!to_clinic_code.equals("")) {            
				sqlsel.append("select 'Y',level_of_care_ind from op_clinic a, (select day_no from sm_day_of_week where "+
				" day_of_week=rtrim(to_char(sysdate,'DAY'))) where a.clinic_code = '"+to_clinic_code+"' and "+			"decode(day_no,'1',working_day_1,'2',working_day_2,'3',working_day_3,'4',working_day_4,'5',working_day_5,'6',working_day_6,working_day_7)='Y' "+
				" and level_of_care_ind='A' and "+
				" allow_visit_regn_yn ='Y' and eff_status='E' ");
				if(function_id.equals("VISIT_REGISTRATION")) {
					 sqlsel.append(" and a.care_locn_type_ind = 'C' "); 
				 } else if(function_id.equals("PROCD_REGISTRATION"))	{
					 sqlsel.append( "  and a.care_locn_type_ind ='E' "); 
				 }			  
				sqlsel.append( " and ((age_group_code is null ) or ((age_group_code is not null) and "+
				" exists (select age_group.age_group_code from am_age_group age_group where "+
				" nvl(age_group.gender,'M')='F' and trunc(sysdate)-trunc(SYSDATE-200) between "+
				" decode(age_group.age_unit,'Y',365,'M',30,1)*age_group.min_age and  "+
				" decode(age_group.age_unit,'Y',365,'M',30,1)*age_group.max_age and age_group.eff_status='E' ))) and "+
				" facility_id='"+facility_id+"'  and (facility_id, clinic_type, clinic_code) in "+
				" (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where "+
				" facility_id ='"+facility_id+"' and oper_stn_id ='"+oper_stn_id+"' and appl_user_id = '"+userid+"' and register_visit_yn = 'Y' ) " );				
				pstmt = con.prepareStatement(sqlsel.toString());
				rs    =  pstmt.executeQuery();
				if(rs!=null && rs.next()) {
					 clinic_valid_yn = rs.getString(1);
					 level_of_care_ind=rs.getString(2);
				} else	{
					 clinic_valid_yn = "N" ;
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				sqlsel.setLength(0);

           }   // End of if to_locn_type & to_clinic_code
		

		if(clinic_valid_yn == null) clinic_valid_yn = "N" ;
		/* Start Referral ID Validations */
		
		if( !to_facility_id.equals(facility_id)) {
           out.println(" alert(parent.frames[1].frames[1].getMessage('REF_NOT_FOR_CURR_FAC','OP'));parent.frames[1].frames[1].document.forms[0].clear1.click();") ;
           chk_valid = false ;
        }else if( to_locn_type.equals("N")) {
		    out.println(" alert(parent.frames[1].frames[1].getMessage('REF_OUTPATIENT_ALLOW','OP'));parent.frames[1].frames[1].document.forms[0].clear1.click();") ;
		    chk_valid = false ;
        }
					  /*else if( register_visit_yn.equals("N")){
							out.println(" alert(parent.frames[1].frames[1].getMessage('USER_NOT_AUTH_TO_VISIT','OP'));") ;
							chk_valid = false ;
						}*/
		else if(level_of_care_ind.equals("E")) {
		   out.println(" alert(parent.frames[1].frames[1].getMessage('EMER_CLINIC_NOT_ALLOWED','COMMON'));parent.frames[1].frames[1].document.forms[0].clear1.click();") ;
           chk_valid = false ;
		}else if( clinic_valid_yn.equals("N")) {
            out.println(" alert(parent.frames[1].frames[1].getMessage('CLINIC_NOT_WORK','OP'));parent.frames[1].frames[1].document.forms[0].clear1.click();") ;
		    chk_valid = false ;
		}else if( !ref_status.equals("O")){
			PreparedStatement pstmtOA   = con.prepareStatement( "SELECT APPT_STATUS FROM OA_APPT WHERE REFERRAL_ID = '"+p_referral_id+"' and facility_id='"+facility_id+"'");
			ResultSet rsOA = pstmtOA.executeQuery();
			String oa_appt_status = "";
			if(rsOA != null) {
			   while(rsOA.next()){
				  oa_appt_status = rsOA.getString(1);
				}
			}
			if(rsOA != null) rsOA.close();
			if(pstmtOA != null) pstmtOA.close();
			if(oa_appt_status == null)	oa_appt_status = "";			       
			if(!oa_appt_status.equals("1")) {
				out.println(" alert(parent.frames[1].frames[1].getMessage('INVALID_REF_ID','OP'));parent.frames[1].frames[1].document.forms[0].clear1.click();") ;
				 chk_valid = false ;
			}
        }else if(patient_id.equals("")) {	
			out.println("alert(parent.frames[1].frames[1].getMessage('PAT_ID_NOT_FOUND_FOR_REF','OP'));pat_id=parent.frames[1].frames[1].show_patwindowReferral('"+to_clinic_code+"','"+q_appt_ref_no+"','"+p_referral_id+"');") ;
		  %>
		    patFlag=pat_id.charAt(0);
			if(patFlag=="Y")
				pat_id=pat_id.substring(1,pat_id.length);
			else if(patFlag=="N")
			    pat_id=pat_id.substring(1,pat_id.length);
			if(pat_id!="N" &&pat_id!="C") {			 /*if(updatePatDet(pat_id,"","","<%=q_appt_ref_no%>","<%=p_referral_id%>"))  {*/
				parent.frames[1].frames[1].document.forms[0].pat_id1.value=pat_id; 
				//Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
				parent.frames[1].frames[1].document.forms[0].srch_code.disabled=false;
				parent.frames[1].frames[1].document.forms[0].srch_code.click();
				parent.frames[1].frames[1].document.forms[0].srch_code.disabled=true;
				<%if(!(isUHID_valid_appl && chk_valid == true && bl_install_yn.equals("Y")) ){%>
               parent.frames[1].frames[3].document.location.href="../../eOP/jsp/VisitRegistrationResult.jsp?emer_regn_allow_yn=<%=emer_regn_allow_yn%>visit_for_inpat_yn=<%=visit_for_inpat_yn%>&order_catalog_code=<%=to_order_code%>&q_practitioner_id=<%=to_pract_id%>&referral_id=<%=p_referral_id%>&q_clinic_code=<%=to_clinic_code%>&locn_ind=<%=to_locn_type%>&or_install_yn=<%=or_install_yn%>&build_episode_rule=<%=build_episode_rule%>&oper_stn_id=<%=oper_stn_id%>&bl_interface_yn=<%=bl_install_yn%>&functionId=<%=function_id%>&menu_function_id=<%=menu_function_id%>&patient="+pat_id+"&patFlag="+patFlag+"&query_String="+encodeURIComponent("<%=queryString%>");
				<%}%>
															/*  }  parent.frames[1].frames[1].document.forms[0].srch_code.click(); */
			}else{
				parent.frames[1].frames[1].document.forms[0].clear1.click();
			}
			<%
            chk_valid = false ;
        }else{
		  	/*
		     if(functionId.equals("VISIT_REGISTRATION") && !to_locn_type.equals("C") && !to_locn_type.equals("E")) {
			 out.println(" alert(parent.frames[1].frames[1].getMessage('INVALID_REF_ID','OP'));") ;
			 chk_valid = false ;
		    }
			 */                                    
			if(function_id.equals("VISIT_REGISTRATION") && !to_locn_type.equals("C")){
				out.println(" alert(parent.frames[1].frames[1].getMessage('INVALID_REF_ID','OP'));") ;
				chk_valid = false ;
			}else if(function_id.equals("PROCD_REGISTRATION") && !to_locn_type.equals("E")){
			    out.println(" alert(parent.frames[1].frames[1].getMessage('INVALID_REF_ID','OP'));") ;
			    chk_valid = false ;
			}
		}
		/*Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750] Start*/
		JSONObject patDtlsObj	= new JSONObject();
		String natId					= "";
		String altId1					= ""; 
		String altId2					= ""; 
		String pat_dtls_unknown_yn		= ""; 
		String citizen_yn				= ""; 
		String visa_type				= "";
		String altId1Desc				= ""; 
		String altId2Desc				= ""; 
		String natIdPrompt				= ""; 
		String errMsg					= "";
		String showAlert				= "N";
		//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
		if((isInvokeChngPatDtls || isNatIdOrAltIdMandVisaType || isNatIdAltIdMandVisaType) && chk_valid == true){
			patDtlsObj						= eMP.MPCommonBean.chkNatIDAltIDAvail(con, patient_id,locale);
			natId					= (String)patDtlsObj.get("national_id_no");
			altId1					= (String)patDtlsObj.get("alt_id1_no");
			altId2					= (String)patDtlsObj.get("alt_id2_no");
			pat_dtls_unknown_yn		= (String)patDtlsObj.get("pat_dtls_unknown_yn");
			citizen_yn				= (String)patDtlsObj.get("citizen_yn");
			visa_type				= (String)patDtlsObj.get("visa_type");//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
			altId1Desc				= (String)patDtlsObj.get("alt_id1_type_desc");
			altId2Desc				= (String)patDtlsObj.get("alt_id2_type_desc");
			natIdPrompt				= (String)patDtlsObj.get("nat_id_prompt");
			showAlert				= (String)patDtlsObj.get("showAlert");
			//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
			if(visa_type.equals(""))
			visa_type="W";
		}
		if(isNatIdOrAltIdMandVisaType && chk_valid == true){
	
			if(pat_dtls_unknown_yn.equals("N") && showAlert.equals("Y")){
				if(citizen_yn.equals("Y") && natId.equals("")){
					errMsg	= natIdPrompt;
				}else if(citizen_yn.equals("N") && altId1.equals("") && altId2.equals("") ){
					errMsg	= altId1Desc+"/"+altId2Desc;
				}
			}
			/*Below Condition commented for KDAH-CRF-0522.1*/
			/*if(!errMsg.equals("")){
				out.println("var message= getMessage('NATID_ALTID_NOT_AVAILABLE','MP'); alert(message.replace('#','"+errMsg+"'));");
				chk_valid = false;
				out.println("parent.frames[1].frames[1].document.forms[0].clear1.click()");
				out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_value=0&error_num=aa'");
			}else{
				chk_valid = true;
			}*/
		}
		/*Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750] End*/
		
		/*Added By Dharma on 14th May 2020 against KDAH-CRF-0522.1 Start*/

		String strMPParamMandFlds	= "";
		if(isChkMPParamMandFlds && chk_valid == true){
			strMPParamMandFlds = eMP.MPCommonBean.chkMPMandFieldsForEncCreation(con, patient_id,locale);
			if(!strMPParamMandFlds.equals("Y")){
				errMsg	= strMPParamMandFlds;
			}
		}

		if((isChkMPParamMandFlds || isNatIdOrAltIdMandVisaType) && chk_valid == true && !errMsg.equals("")){
		if(!errMsg.equals("")){
				out.println("var message= getMessage('NATID_ALTID_NOT_AVAILABLE','MP'); alert(message.replace('#','"+errMsg+"'));");
				chk_valid = false;
				out.println("parent.frames[1].frames[1].document.forms[0].clear1.click()");
				out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_value=0&error_num=aa'");
			}else{
				chk_valid = true;
			}
		}
		/*Added By Dharma on 14th May 2020 against KDAH-CRF-0522.1 End*/
/*Added by Dharma on 24th Apr 2019 against MMS-DM-CRF-0152.1 Start*/
//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
		if((isInvokeChngPatDtls || isNatIdAltIdMandVisaType)&& chk_valid == true){
			if(pat_dtls_unknown_yn.equals("N") && showAlert.equals("Y")){
				if(isInvokeChngPatDtls)
					{
					if(citizen_yn.equals("Y") && natId.equals("")){
						errMsg	= natIdPrompt;
					}else if(citizen_yn.equals("N") && altId1.equals("")){
						errMsg	= altId1Desc;
						}	
					}
				//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
				if(isNatIdAltIdMandVisaType)
				{
					if(citizen_yn.equals("Y") && natId.equals("")){
					errMsg	= natIdPrompt;
					}	
					else if(citizen_yn.equals("N") && (visa_type.equals("W")) && natId.equals("") ){
					errMsg	= natIdPrompt;
					}
					else if(citizen_yn.equals("N") && (visa_type.equals("V")) && altId1.equals("") && !altId2.equals("") ){
					errMsg	= altId1Desc;	
					}
					else if(citizen_yn.equals("N") && (visa_type.equals("V")) && !altId1.equals("") && altId2.equals("")){
					errMsg	= altId2Desc;	
					}
					else if(citizen_yn.equals("N") && (visa_type.equals("V")) && altId1.equals("") && altId2.equals("")){
					errMsg	= altId1Desc+"/"+altId2Desc;	
					}
				}
			}
			if(!errMsg.equals("")){
				out.println("async function toHoldShowModal2(){");
				out.println("var message= getMessage('NATID_ALTID_NOT_AVAILABLE_UPDATE','MP'); message = message.replace('#','"+errMsg+"');");
				out.println("if(confirm(message)){");
				out.println("var dialogTop   = '65'");
				out.println("var dialogHeight    = '80vh'") ; 
				out.println("var dialogWidth = '85vw'") ;
				out.println("var features  = 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';status=no; scroll=no'");
				out.println("var arguments = '' ");
				out.println("var retVal = '';");
				out.println("var url='../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=N&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&Patient_ID="+patient_id+"';");
				out.println("retVal = await top.window.showModalDialog(url,arguments,features);");
				out.println("if(retVal){");
					out.println("if( retVal != null || retVal.length != 0)");
					out.println("parent.close();");
					out.println("parent.frames[1].frames[1].document.forms[0].srch_code.disabled=false;");
					out.println("parent.frames[1].frames[1].document.forms[0].srch_code.click();");
					out.println("parent.frames[1].frames[1].document.forms[0].srch_code.disabled=true;");

					out.println("}else{");
						out.println("parent.frames[0].document.getElementById('reset').click();");
					out.println("}");
				out.println("}else{");
				out.println("parent.frames[0].document.getElementById('reset').click();");
				out.println("}");
				out.println("} toHoldShowModal2(); ");

			}else{
				chk_valid = true;
			}
		}
/*Added by Dharma on 24th Apr 2019 against MMS-DM-CRF-0152.1 End*/

		/*Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1*/
		if(isCountryRegionValAppl && chk_valid == true){

			JSONObject SMSiteJSONObj = new JSONObject();
			SMSiteJSONObj = eSM.SMCommonBean.getSMSiteParamDetails(con);
			String region_prompt = (String)SMSiteJSONObj.get("region_prompt");

			JSONObject MPParamJSONObj = new JSONObject();
			MPParamJSONObj = eMP.MPCommonBean.getMPAuditTrailDetails(con);
			String country_reqd_yn = (String)MPParamJSONObj.get("country_reqd_yn");
			String region_reqd_yn = (String)MPParamJSONObj.get("region_reqd_yn");

			JSONObject PatAddrJSONObj = new JSONObject();
			PatAddrJSONObj = eMP.MPCommonBean.getMPPatContactDetails(con,patient_id);
			String country_code = (String)PatAddrJSONObj.get("country_code");	
			String region_code = (String)PatAddrJSONObj.get("region_code");

			String dispMsg = "";

			if(country_code.equals("") || region_code.equals(""))
			{
				if(country_reqd_yn.equals("Y") && region_reqd_yn.equals("N") && country_code.equals(""))
				{
					dispMsg = "Y";
					out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#',getLabel('Common.country.label','Common'));");
				}
				else if(country_reqd_yn.equals("N") && region_reqd_yn.equals("Y") && region_code.equals(""))
				{
					dispMsg = "Y";
					out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#','"+region_prompt+"');");
				}
				else if(country_reqd_yn.equals("Y") && region_reqd_yn.equals("Y"))
				{
					if(country_code.equals("") && region_code.equals(""))
					{
						dispMsg = "Y";
						out.println("var cr_prompt = getLabel('Common.country.label','Common')+' '+getLabel('Common.and.label','Common')+' '+'"+region_prompt+"';");
						out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#',cr_prompt);");
					}
					else if(country_code.equals("") && !region_code.equals(""))
					{
						dispMsg = "Y";
						out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#',getLabel('Common.country.label','Common'));");
					}
					else if(!country_code.equals("") && region_code.equals(""))
					{
						dispMsg = "Y";
						out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#','"+region_prompt+"');");
					}
				}else
				{
					dispMsg = "";
				}
			}

			if(!dispMsg.equals("")){
				out.println("async function toHoldShowModal3(){");
				out.println("if(confirm(message)){");
				out.println("var dialogTop   = '65'");
				out.println("var dialogHeight    = '80vh'") ; 
				out.println("var dialogWidth = '85vw'") ;
				out.println("var features  = 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';status=no; scroll=no'");
				out.println("var arguments = '' ");
				out.println("var retVal = '';");
				out.println("var url='../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=N&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&load_tab=CONTACT_ADDR_TAB&Patient_ID="+patient_id+"';");
				out.println("retVal = await top.window.showModalDialog(url,arguments,features);");
				out.println("if(retVal){");
					out.println("if( retVal != null || retVal.length != 0)");
					out.println("parent.close();");
					out.println("parent.frames[1].frames[1].document.forms[0].srch_code.disabled=false;");
					out.println("parent.frames[1].frames[1].document.forms[0].srch_code.click();");
					out.println("parent.frames[1].frames[1].document.forms[0].srch_code.disabled=true;");

					out.println("}else{");
						out.println("parent.frames[0].document.getElementById('reset').click();");
					out.println("}");
				out.println("}else{");
				out.println("parent.frames[0].document.getElementById('reset').click();");
				out.println("}} toHoldShowModal3();");

			}else{
				chk_valid = true;
			}
		}
		/*End AAKH-CRF-0128.1*/

		/*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
		if(isNationalIdValidationAppl && chk_valid == true)
		{
			JSONObject valJSONObj	= new JSONObject();
			valJSONObj				= eMP.MPCommonBean.getNationalIdValidationYN(con, patient_id, facility_id, "OP");
			String validate_yn		= (String)valJSONObj.get("validate_yn");
			String national_id		= (String)valJSONObj.get("national_id");
			String chk_citizen_yn	= (String)valJSONObj.get("citizen_yn");

			if(validate_yn.equals("Y") && national_id.equals("") && chk_citizen_yn.equals("Y"))
			{		
				out.println("alert(getMessage('VALIDATE_NATIONAL_ID','MP'))");
		
				chk_valid = false;
					
				out.println("parent.frames[1].frames[1].document.forms[0].clear1.click()");
				out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_value=0&error_num=aa'");
			}else
			{
				chk_valid = true;
			}
		}
		/*End MO-CRF-20148*/
		
		if(isUHID_valid_appl && chk_valid == true && bl_install_yn.equals("Y") )
		{
			// added for referral start
			
			
							String UHIDValidCount = "0";
							String UHIDValidCount_tmp = "";
							String pat_ser_grp_code = "";
					try{
							
							
						 UHIDValidCount_tmp	= eMP.MPCommonBean.getUHIDValidCount(con,patient_id,facility_id);
					
						
						%>
						parent.frames[1].frames[1].document.forms[0].pat_id1.value="<%=patient_id%>";
						<%
						 
						String arr_temp[] = UHIDValidCount_tmp.split("~~");
						UHIDValidCount = arr_temp[0];
						if(arr_temp.length>1)
							pat_ser_grp_code = arr_temp[1]; 
						 
						if(UHIDValidCount.equals("0"))
						{
							
							
							 
					out.println("if(confirm(getMessage('UHID_EXPIRED','MP'))){ 	");
					out.println("var check1 = blUHIDBillchk('"+patient_id+"','VISIT_REGISTRATION','OP','"+pat_ser_grp_code+"');");
					
					out.println("if(check1 == 'Y'){");
					out.println("parent.frames[1].frames[1].document.forms[0].srch_code.disabled=false;");
					out.println("parent.frames[1].frames[1].document.forms[0].srch_code.click();");
					out.println("parent.frames[1].frames[1].document.forms[0].srch_code.disabled=true;");
					out.println("}else{");
					 chk_valid = false;
					out.println("parent.frames[1].frames[1].document.forms[0].clear1.click()");
					out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_value=0&error_num=aa'");
					out.println("}");
					
						out.println("}else{");
					 //alert_yn = 'N'; // continue_yn = "N";
					 chk_valid = false;
					//valid_patient_id="";
					
					out.println("parent.frames[1].frames[1].document.forms[0].clear1.click()");
					out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_value=0&error_num=aa'");
					out.println("}");	 
						
						}
						else
						{
							 
							
							 
						}
						
							}
							catch(Exception e1) {
										e1.printStackTrace();
								 } 
				
				
				
			
			
			// added for referral end
			
			
			
			
			
		}
		
		
		
		
		
      }else{
		 out.println("alert(parent.frames[1].frames[1].getMessage('INVALID_REF_ID','OP'));");
		 out.println("parent.frames[1].frames[1].document.forms[0].clear1.click();");
		 chk_valid = false ;
	  }
   }
   if(chk_valid==true){	  
	%>	
	if(parent.frames[1].frames[3] != null){
		if(parent.frames[1].frames[1].document.getElementById('referal_id1').value!=''){
		    PatVisHid(3);// added by munisekhar for MMS-QH-CRF-0162
			/*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
			parent.frames[1].frames[1].document.forms[0].pat_id1.value="<%=patient_id%>"
		    parent.frames[1].frames[3].document.location.href="../../eOP/jsp/VisitRegistrationResult.jsp?emer_regn_allow_yn=<%=emer_regn_allow_yn%>&visit_for_inpat_yn=<%=visit_for_inpat_yn%>&order_catalog_code=<%=to_order_code%>&q_practitioner_id=<%=to_pract_id%>&referral_id=<%=p_referral_id%>&q_clinic_code=<%=to_clinic_code%>&locn_ind=<%=to_locn_type%>&or_install_yn=<%=or_install_yn%>&build_episode_rule=<%=build_episode_rule%>&oper_stn_id=<%=oper_stn_id%>&bl_interface_yn=<%=bl_install_yn%>&functionId=<%=function_id%>&upt_contact_dtls_oa_yn=<%=upt_contact_dtls_oa_yn%>&menu_function_id=<%=menu_function_id%>&patient=<%=patient_id%>"
		   
		 }
	 }
       <%
	}
    }else {		  out.println("alert(parent.frames[1].frames[1].getMessage('INVALID_REF_ID','OP'));parent.frames[1].frames[1].document.forms[0].referal_id1.value='';parent.frames[1].frames[1].document.forms[0].clear1.click();") ;
        }	
 }
String p_visit_type_ind = "";
if (list_name.equals("visit_adm_type"))
 {
    locncode    = request.getParameter("assign_care_locn_code");
	String visitadmtype  = request.getParameter("visit_adm_type");
	episodeReqd  = request.getParameter("episodeReqd");
	//String servicecode  = request.getParameter("service_code")==null?"":request.getParameter("service_code");
	subservicecode   = request.getParameter("subservice_code");  

	//String str1="";
	//String str2="";
	//PreparedStatement pstmt11=null;
	//ResultSet rs11 =null;
    
	String p_order_cat="";
    pstmt   = con.prepareStatement( "select  visit_type_ind,order_catalog_criteria from op_visit_type where visit_type_code='"+visitadmtype+"' and facility_id='"+facility_id+"'");
    rs = pstmt.executeQuery();
    if( rs != null )
     {
     if( rs.next() )
      {
		str1 = rs.getString( "visit_type_ind" );
		// str2 = rs.getString( "visit_type_ind_desc" );
         if(str1.equals("F"))
		  {
		  str2 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels");
		  }else if(str1.equals("L"))
		  {
		  str2 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels");
		  }else if(str1.equals("R"))
		  {
		  str2 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		  }else if(str1.equals("E"))
		  {
		  str2 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
		  }else if(str1.equals("S"))
		  {
		  str2 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels");
		  }else if(str1.equals("C"))
		  {
		  str2 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels");
		  }



		p_visit_type_ind = str1;
		p_order_cat=(rs.getString("order_catalog_criteria") == null)?"":rs.getString("order_catalog_criteria");
                //out.println(frame_ref+"forms[0].order_cat_txt.value='';"); 
				//out.println(frame_ref+"forms[0].order_cat_code.value='';"); 
		if(or_install_yn.equals("Y"))
		 {
		    if(!p_order_cat.equals(""))
		     {
			  if(p_order_cat.equals("R"))
			   {
				 /*Below condtion Added for this CRF CRF Bru-HIMS-CRF-165.1 [IN:035659]*/
				
				   if(order_count_appointment>0){	
			       out.println(frame_ref+"forms[0].order_cat_txt.readOnly=true;");
				   out.println(frame_ref+"forms[0].order_cat_butt.disabled=true;");
				   out.println(" if("+frame_ref+"all.gifpopord != null){ "+frame_ref+"all.gifpopord.style.visibility='hidden';}");
				   out.println(frame_ref+"forms[0].order_req.value='"+p_order_cat+"';");
				   }else{				   
					   out.println(frame_ref+"forms[0].order_cat_txt.readOnly=false;");
					   out.println(frame_ref+"forms[0].order_cat_butt.disabled=false;");
					   out.println(" if("+frame_ref+"all.gifpopord != null){ "+frame_ref+"all.gifpopord.style.visibility='visible';}");
					   out.println(frame_ref+"forms[0].order_req.value='"+p_order_cat+"';");
				   }
				  //End this CRF Bru-HIMS-CRF-165.1 [IN:035659]
			   }
			   else
			      { /*Below condtion Added for this CRF CRF Bru-HIMS-CRF-165.1 [IN:035659]*/	
				   				      
				   if(order_count_appointment>0){ 			
				       out.println(frame_ref+"forms[0].order_cat_txt.readOnly=true;");
					   out.println(frame_ref+"forms[0].order_cat_butt.disabled=true;");					  
					   }else{	 	
				       out.println(frame_ref+"forms[0].order_cat_txt.readOnly=false;");
				       out.println(frame_ref+"forms[0].order_cat_butt.disabled=false;");				       
					 }
				     out.println("if("+frame_ref+"all.gifpopord != null){ "+frame_ref+"all.gifpopord.style.visibility='hidden';}");
			         out.println(frame_ref+"forms[0].order_req.value='"+p_order_cat+"';");
				   //End this CRF Bru-HIMS-CRF-165.1 [IN:035659]
			      }
		     }else
			 {
				out.println(frame_ref+"forms[0].order_cat_txt.readOnly=true;");
			 	out.println(frame_ref+"forms[0].order_cat_butt.disabled=true;");
				out.println(" if("+frame_ref+"all.gifpopord != null){ "+frame_ref+"all.gifpopord.style.visibility='hidden';}");
				out.println(frame_ref+"forms[0].order_req.value='"+p_order_cat+"';");
                         }
		  }
		  else
		     {
				out.println(frame_ref+"forms[0].order_cat_txt.readOnly=true;");
				out.println(frame_ref+"forms[0].order_cat_butt.disabled=true;");
				out.println(" if("+frame_ref+"all.gifpopord != null){ "+frame_ref+"all.gifpopord.style.visibility='hidden';}");
				out.println(frame_ref+"forms[0].order_req.value='"+p_order_cat+"';");
                      }
                		if(rs != null) rs.close();
		        	if(pstmt != null) pstmt.close();

		    out.println(frame_ref+"forms[0].h_visit_type_ind.value=\""+str1+"\";");
		    out.println(frame_ref+"forms[0].visit_adm_type.value='"+visitadmtype+"';");
			out.println(frame_ref+"forms[0].vst_type_ind.value=\""+str1+"\";");//Added for the SCF - MMS-SCF-0167		  
          }
      }    
	 

    // Episode Validations
    //  episode_validation(out, p_visit_type_ind,episodeReqd, servicecode, subservicecode, patient_id,con,facility_id,frame_ref);
}



if (list_name.equals("check_patient_id")|| list_name.equals("ok"))
{
	facility_id = (String) session.getValue("facility_id"); 
    list_name   = request.getParameter("list_name")==null?"":request.getParameter("list_name");
    if(list_name.equals("check_patient_id") || list_name.equals("ok"))
     {
       alert_yn='Y';
       fromPatidF1=request.getParameter("from_PatIDF1")==null?"":request.getParameter("from_PatIDF1");
     }
     out.println("var js_alt_status='';");
     out.println("var cont ='Y';");          
    
    if(!alt_id_type.equals(""))
     {
		  stmt=con.createStatement();
		  rs=stmt.executeQuery("select long_desc from mp_alternate_id_type_lang_vw where ALT_ID_TYPE='"+alt_id_type+"' and language_id='"+locale+"'");
		  if(rs.next())
		   {
			  alt_id_type_desc=rs.getString(1);
			  if(alt_id_type_desc == null) alt_id_type_desc="";
		   }
		  if(rs != null) rs.close();
		  stmt=con.createStatement();
		  rs = stmt.executeQuery("select patient_id from mp_patient where alt_id1_no ='"+request.getParameter("alt_id1_no")+"'") ;
		  if(rs!=null && rs.next())
		   {
			prompt_patient_id = rs.getString(1) ;
		   }
		   else
			  {out.println("var val1 = parent.frames[1].frames[1].getMessage('INVALID_ALT_ID','MP'); val1 =     val1.replace('$','"+alt_id_type_desc+"'); alert(val1);");
			   alert_yn='N';
			   prompt_patient_id= "";
			   out.println("cont = 'N'");
			  }
      }
      if(rs != null) rs.close();
      if(stmt != null) stmt.close();
      boolean nextCheck=false;
      if (!prompt_patient_id.equals(""))
       {
        if (!list_name.equals("register"))
         {
		 /*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
			/*Modified by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
			/* isNatIdOrAltIdMandVisaType Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750]*/
			//isChkMPParamMandFlds Added By Dharma on 12th May 2020 against KDAH-CRF-0522.1
			//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
           nextCheck=check_patient_id(out,prompt_patient_id,prompt_patient_id,facility_id,fromchk,con,functionId, bl_install_yn,fromPatidF1,callFromMenu_yn,func_source,called_from,register_visit_walkin,register_visit_referral,oper_stn_id,build_episode_rule,or_install_yn,emer_regn_allow_yn,visit_for_inpat_yn,nat_id_prompt,queryString,locale,entitlement_by_cat_yn,upt_contact_dtls_oa_yn,isUHID_valid_appl,isNationalIdValidationAppl,isNatIdOrAltIdMandVisaType,isInvokeChngPatDtls,isChkMPParamMandFlds,isCountryRegionValAppl,isNatIdAltIdMandVisaType); // modified by mujafar for AMRI-CRF-0357
	     }
       }
     
 
	
 

}

 //  if(service_code.equals(""))
   if(list_name.equals("populate_service"))
   {
	 
   String appt_id = request.getParameter("appt_ref_no")==null?"":request.getParameter("appt_ref_no");
   if(appt_id==null) appt_id="";
   String invite_no=request.getParameter("invitation_no")==null?"":request.getParameter("invitation_no");
   if(!invite_no.equals(""))
	{
	   
	  appt_id="";
	}
	
	String fileCreateSql =  "{call GET_WORKING_DAY_YN(?,?,?,sysdate,?,?)}";
	String clinicWorkingYN="N";
	String P_ERR_MSG="";
	String practid="";
	String OP_APPL_YN="N";
	String IP_APPL_YN="N";
	String DC_APPL_YN="N";
	String EM_APPL_YN="N";
	String SPECIALITY_CODE="";
	String open_to_all_pract_yn="";
	String ident_at_checkin="";
	String primary_resource_class="";
	CallableStatement fileCreateCS = con.prepareCall(fileCreateSql);
	fileCreateCS.setString(1, facility_id);
	fileCreateCS.setString(2, locncode);
	fileCreateCS.setString(3, practid);
	fileCreateCS.registerOutParameter( 4,java.sql.Types.VARCHAR);
	fileCreateCS.registerOutParameter( 5,java.sql.Types.VARCHAR);
	fileCreateCS.execute();
	clinicWorkingYN = fileCreateCS.getString(4);
    if(clinicWorkingYN==null) clinicWorkingYN="";	
    P_ERR_MSG = fileCreateCS.getString(5);
    if(P_ERR_MSG==null) P_ERR_MSG="";   
       
    if(!clinicWorkingYN.equals(""))
	 {
          
       if(clinicWorkingYN.equals("Y"))
        { 
           String sqlc="select allow_walk_in_yn,allow_referral_yn,allow_appt_yn,allow_non_referral_yn,allow_visit_regn_yn,OP_APPL_YN, DC_APPL_YN, IP_APPL_YN, EM_APPL_YN, SPECIALITY_CODE, open_to_all_pract_yn, ident_at_checkin, primary_resource_class from op_clinic  where facility_id='"+facility_id+"' and clinic_code='"+locncode+"'";
           
		   pstmt   = con.prepareStatement(sqlc);
           rs = pstmt.executeQuery();
           while( rs.next() )
               {
				allow_walk_in_yn = rs.getString( "allow_walk_in_yn" );
				allow_referral_yn = rs.getString( "allow_referral_yn" );
				allow_appt_yn = rs.getString( "allow_appt_yn" );
				OP_APPL_YN = rs.getString( "OP_APPL_YN" );
				IP_APPL_YN = rs.getString( "IP_APPL_YN" );
				DC_APPL_YN = rs.getString( "DC_APPL_YN" );
				EM_APPL_YN = rs.getString( "EM_APPL_YN" );
				SPECIALITY_CODE = rs.getString( "SPECIALITY_CODE" ); 				open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"N":rs.getString("open_to_all_pract_yn");
				ident_at_checkin=rs.getString("ident_at_checkin")==null?"N":rs.getString("ident_at_checkin");	primary_resource_class=rs.getString("primary_resource_class")==null?"N":rs.getString("primary_resource_class");
               }
	   if(rs != null) rs.close();
	   if(pstmt != null) pstmt.close();

	  %>
		
			parent.frames[1].frames[3].document.forms[0].locationSpeciality.value='<%=SPECIALITY_CODE%>'
		  
	  <%
	   if(allowToProceed(locncode,con,facility_id,p_referral_id,appt_id,allow_walk_in_yn,allow_referral_yn,allow_appt_yn,out))
		{
		   if(functionId.equals("PROCD_REGISTRATION"))
			{
				PreparedStatement pstmtPatClass2   = con.prepareStatement( "Select Patient_Class, Short_Desc from AM_PATIENT_CLASS_lang_vw WHERE language_id='"+locale+"' and PATIENT_CLASS in(		decode(?,'Y','OP'),decode(?,'Y','IP'),decode(?,'Y','EM'),decode(?,'Y','DC'))");
				pstmtPatClass2.setString(1,OP_APPL_YN);
				pstmtPatClass2.setString(2,IP_APPL_YN);
				pstmtPatClass2.setString(3,EM_APPL_YN);
				pstmtPatClass2.setString(4,DC_APPL_YN);
				rs = pstmtPatClass2.executeQuery();
				while( rs.next())
				{
				   out.println(  "if("+frame_ref+"forms[0].pat_class != null) {var element = "+frame_ref+"createElement('OPTION');"+
				  "element.text = \""+rs.getString( "Short_Desc" )+"\";"+
				  "element.value= \""+rs.getString( "Patient_Class" )+"\";"+
				  frame_ref+"forms[0].pat_class.add(element);}");
				}
		  
				if(rs != null) rs.close();
				if(pstmtPatClass2 != null) pstmtPatClass2.close();
			}
			/*
			pstmt   = con.prepareStatement( "select open_to_all_pract_yn,ident_at_checkin,primary_resource_class from op_clinic where clinic_code='"+locncode+"' and facility_id='"+facility_id+"'");
			rs = pstmt.executeQuery();
			if (rs.next())
			 {
			   String open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"N":rs.getString("open_to_all_pract_yn");
			   String ident_at_checkin=rs.getString("ident_at_checkin")==null?"N":rs.getString("ident_at_checkin");
			   String primary_resource_class=rs.getString("primary_resource_class")==null?"N":rs.getString("primary_resource_class");
			*/
			   
			   out.println(frame_ref+"forms[0].open_to_all_pract_yn.value='"+open_to_all_pract_yn+"'");
			   out.println(frame_ref+"forms[0].ident_at_checkin.value='"+ident_at_checkin+"'");
			   out.println(frame_ref+"forms[0].clptype.value='"+primary_resource_class+"'");
			   
			/* }
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();  
			*/

			StringBuffer servsql1=new StringBuffer();
			servsql1.setLength(0);
			
			servsql1.append("SELECT   service_code,  short_desc FROM   am_service_lang_vw WHERE  language_id='"+locale+"' and eff_status = 'E' AND service_code in (SELECT service_code FROM op_clinic WHERE clinic_code ='"+locncode+"' AND   facility_id='"+facility_id+"' UNION SELECT b.service_code FROM OP_CLINIC_FOR_SERVICE b WHERE b.clinic_code ='"+locncode+"' AND b.facility_id='"+facility_id+"'");
			
		
			if(functionId.equals("VISIT_REGISTRATION"))
			 {
			  servsql1.append( " and b.care_locn_type_ind = 'C')");
			 }
			 else if(functionId.equals("PROCD_REGISTRATION"))
				{
				  servsql1.append(" and b.care_locn_type_ind = 'E')");
				} servsql1.append( " order by 2 ");			
			int serviceCount = 0;
			pstmt   = con.prepareStatement(servsql1.toString());
			rs = pstmt.executeQuery();
			if( rs != null )
			 {
			  while( rs.next())
				  {
					serviceCount++;
					out.println(  "var element = "+frame_ref+"createElement('OPTION');"+
					"element.text = \""+rs.getString( "short_desc" )+"\";"+
					"element.value= \""+rs.getString( "service_code" )+"\";"+
					frame_ref+"forms[0].service_code.add(element);");

				  }
			 }			
			 // The below condition serviceCount is newly added for CRF PMG20089-CRF-0855 [IN:024101] by Suresh M on 30.11.2010.
			 
			if(serviceCount == 1)
				out.println(""+frame_ref+"forms[0].service_code.options[1].selected = true; "+frame_ref+"forms[0].service_code.onchange();");
			 
		// query tuning.. modified by venkat S
		/* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
		pstmt   = con.prepareStatement( "SELECT a.practitioner_id ROOM_NO, b.room_type room_type,am_get_desc.am_facility_room (a.facility_id, b.room_num, '"+locale+"', 2) shor_desc FROM op_pract_for_clinic a,  am_facility_room b WHERE a.facility_id='"+facility_id+"' AND a.clinic_code='"+locncode+"' AND  a.eff_status='E' AND  a.resource_class='R' AND  a.practitioner_id=b.room_num  AND a.facility_id=b.OPERATING_FACILITY_ID");
		/*CRF end SS-CRF-0010 [IN034516]*/
			int recordCount = 0;
			rs = pstmt.executeQuery();
			while( rs.next())
			{  
				recordCount++;
				String room_type = rs.getString( "room_type" );
				/* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
				out.println(  "var element = "+frame_ref+"createElement('OPTION');"+
				"element.text = '"+rs.getString("ROOM_NO")+" "+rs.getString("shor_desc")+"';"+
				"element.value= '"+rs.getString("ROOM_NO")+"';"+
				"if("+frame_ref+"forms[0].room_no != null){"+frame_ref+"forms[0].room_no.add(element);}"+
				"if("+frame_ref+"forms[0].room_type != null){"+frame_ref+"forms[0].room_type.value='"+room_type+"';}");		
                /*CRF end SS-CRF-0010 [IN034516]*/				
			}
			if(isRoomMandatoryRegVisit.equals("true") && recordCount > 0){ //  added by mujafar for NMC-JD-CRF-0025
			
					out.println(" "+frame_ref+"all.room_img.style.visibility = 'visible'; ");
			}
				 
	//		if(recordCount == 1)
	//		 	out.println(""+frame_ref+"forms[0].room_no.options[1].selected = true;");
	   }
	 }else
        {
           out.println("alert(parent.frames[1].frames[1].getMessage(\"VISIT_REGISTRATION_NOT_ALLOWED_ON_HOLIDAY\",'OP'))");
       }
  }
}
/* Below line was commented by Venkatesh.S against 36090 on 07/Nove/2012 */
 /*if(list_name.equals("populate_room")){
	 String room_no = request.getParameter("room_no")==null?"":request.getParameter("room_no");
	 if(room_no==null) room_no="";
	 String short_desc = "" ; 
     String sqlQuery="select short_desc from am_facility_room where room_num = '"+room_no+"' and operating_facility_id = '"+facility_id+"' ";
         
		   pstmt   = con.prepareStatement(sqlQuery);
           rs = pstmt.executeQuery();
           if( rs.next() ) {
				short_desc = rs.getString( "short_desc" );
				
               }
			     
	   if(rs != null) rs.close();
	   if(pstmt != null) pstmt.close();     		    	 
	   out.println(" "+frame_ref+"all.roomDesc.innerHTML='&nbsp;/&nbsp;' + '"+short_desc+"' ");			 
} */
/* end 36090 */

if(list_name.equals("default_Visit")){
try{ 

		  String VisitRule = "";
		  String strDesc="";
		  String strCode="";			
		   pstmt=con.prepareStatement("Select op_validation_for_visit_type(?,?,?,?) from Dual");		 
		   pstmt.setString( 1, facility_id);
		   pstmt.setString( 2, attend_practitioner_id);
		   pstmt.setString( 3, patient_id);
		   pstmt.setString( 4, service_code);	
		   rs = pstmt.executeQuery();
		   if(rs.next()){
				VisitRule = rs.getString(1);				
		   }
		   int count = 0;
           // below IF condition is modified by Srinivas.Y for IN:35753
		   if((!VisitRule.equals(""))&&(!attend_practitioner_id.equals(""))){		  
    
		   String visitTypeQuery = "SELECT a.visit_type_code,op_get_desc.op_visit_type (a.facility_id,a.visit_type_code,'en','2') short_desc FROM op_visit_type_for_clinic a,op_visit_type b WHERE a.facility_id = '"+facility_id+"' and a.facility_id=b.facility_id and a.visit_type_code=b.visit_type_code AND a.clinic_code = '"+locncode+"' AND a.eff_status = 'E' and b.eff_status='E'  and a.visit_type_ind in('"+VisitRule+"','E') order by 2";

		    pstmt   = con.prepareStatement(visitTypeQuery);
		    rs = pstmt.executeQuery() ;
			  if( rs != null ) { 
				while(rs.next()) {				
					strDesc = rs.getString( "short_desc" ) ;
					strCode = rs.getString( "visit_type_code" );
					out.println(  "var element = "+frame_ref+"createElement('OPTION');"+"element.text = \""+strDesc+"\";"+"element.value= \""+strCode+"\";"+frame_ref+"forms[0].visit_adm_type.add(element);");			
					count++;					
				}
			  }					  
			out.println(""+frame_ref+"forms[0].visit_adm_type.disabled = false;");					

			if(count == 1) {
				out.println(""+frame_ref+"forms[0].visit_adm_type.options[1].selected = true;");
				out.println(""+frame_ref+"forms[0].visit_adm_type.onchange();");
			}
				
			 episode_validation_pract(out, VisitRule,episodeReqd, service_code, subservicecode, patient_id,con,facility_id,frame_ref,locncode,populate_visit_type);       
		   
	
		   }
}catch(Exception e){
	e.printStackTrace();
}

		    
}
//Following if loop added for 41.1
if(list_name.equals("visit_for_blng") && bl_install_yn.equals("Y")){
try{ 	
	boolean allowPopulation=true;
	pstmt = con.prepareStatement("select '1' from op_patient_queue where facility_id = ?  and patient_id = ? and service_code = ?  and queue_status < '07'");		
	pstmt.setString(1,facility_id);
	//pstmt.setString(2,locncode);
	pstmt.setString(2,patient_id);
	pstmt.setString(3,service_code);
	rs = pstmt.executeQuery(); 	
	if(rs.next())
	{
	  //out.println("alert(parent.frames[1].frames[1].getMessage('OPEN_VISIT_STATUS_FOR_CLINIC','OP'));");
	  allowPopulation = false;
	  out.println(frame_ref+"visit_registration.vst_type_ind.value = '';");
	//  out.println(frame_ref+"visit_registration.visit_adm_type.options[0].selected = true;");
	}
	if(rs != null)rs.close();
	if(pstmt != null)pstmt.close();
	if(allowPopulation){
		  String VisitRule = "";
		  String strDesc="";
		  String strCode="";					 

		   String visit_type_ind=request.getParameter("vst_typ_frm_blng")==null?"":request.getParameter("vst_typ_frm_blng");
		   String vst_date_time=request.getParameter("vst_date_time")==null?"":request.getParameter("vst_date_time");
		   		  //Changes for the SCF - MMS-SCF-0082
		  String episode_id=request.getParameter("episode_id")==null?"":request.getParameter("episode_id");		
		  String blng_grp_id=request.getParameter("blng_grp_id")==null?"":request.getParameter("blng_grp_id");					 
		  String cust_grp_code=request.getParameter("cust_grp_code")==null?"":request.getParameter("cust_grp_code");
		  String cust_code=request.getParameter("cust_code")==null?"":request.getParameter("cust_code");					 
		  String policy_type_code=request.getParameter("policy_type_code")==null?"":request.getParameter("policy_type_code");					 
		  String old_vst_type_ind=request.getParameter("old_vst_type_ind")==null?"":request.getParameter("old_vst_type_ind");		
		  String billing_frame=request.getParameter("billing_frame")==null?"":request.getParameter("billing_frame");		
		   if(visit_type_ind.equals("")){ //commented for the SCF - MMS-SCF-0163
			CallableStatement billingCS = null;
			String billingSql =  "{call bl_interface_proc.proc_first_or_followup_visit(?,?,?,?,to_date('"+vst_date_time+"','DD/MM/YYYY HH24:MI:SS'),'','','','',?,?,?,?,?,?)}";//modified for the SCF - MMS-SCF-0082
//			String billingSql =  "{call bl_interface_proc.proc_first_or_followup_visit(?,?,?,?,to_date('"+vst_date_time+"','DD/MM/YYYY HH24:MI:SS'),'','','',?,?)}";//modified for the SCF - MMS-SCF-0082
			billingCS = con.prepareCall(billingSql);
			billingCS.setString(1, facility_id);
			billingCS.setString(2, patient_id);
			billingCS.setString(3, "O");
			billingCS.setString(4, locncode);
			billingCS.registerOutParameter( 5,java.sql.Types.VARCHAR);
			billingCS.registerOutParameter( 6,java.sql.Types.VARCHAR);
			//Added for the SCF - MMS-SCF-0082
			billingCS.registerOutParameter( 7,java.sql.Types.VARCHAR);
			billingCS.registerOutParameter( 8,java.sql.Types.VARCHAR);
			billingCS.registerOutParameter( 9,java.sql.Types.VARCHAR);
			billingCS.registerOutParameter( 10,java.sql.Types.VARCHAR);

			 try{
				billingCS.execute();
				episode_id = billingCS.getString(5)==null?"":billingCS.getString(5);//Added for the SCF - MMS-SCF-0082
				visit_type_ind = billingCS.getString(6);
				if(visit_type_ind==null) visit_type_ind="F";
				
				//Added for the SCF - MMS-SCF-0082
				blng_grp_id = billingCS.getString(7)==null?"":billingCS.getString(7);
				cust_grp_code = billingCS.getString(8)==null?"":billingCS.getString(8);
				cust_code = billingCS.getString(9)==null?"":billingCS.getString(9);
				policy_type_code = billingCS.getString(10)==null?"":billingCS.getString(10);
				System.err.println("In VisitRegistrationInt.jsp - Billing values obtained from the procedure");
				System.err.println("blng_grp_id-->"+blng_grp_id);
				System.err.println("cust_grp_code-->"+cust_grp_code);
				System.err.println("cust_code-->"+cust_code);
				System.err.println("policy_type_code-->"+policy_type_code);
				System.err.println("episode_id-->"+episode_id);
				System.err.println("visit_type_ind-->"+visit_type_ind);
					
			} catch(Exception e1) {
					e1.printStackTrace();
				} finally{billingCS.close();}
			   }
		   int count = 0;

		   String visitTypeQuery = "SELECT a.visit_type_code,op_get_desc.op_visit_type (a.facility_id,a.visit_type_code,'en','2') short_desc FROM op_visit_type_for_clinic a,op_visit_type b WHERE a.facility_id = '"+facility_id+"' and a.facility_id=b.facility_id and a.visit_type_code=b.visit_type_code AND a.clinic_code = '"+locncode+"' AND a.eff_status = 'E' and b.eff_status='E' and a.visit_type_ind in('"+visit_type_ind+"') order by 2";
		
		    pstmt   = con.prepareStatement(visitTypeQuery);
		    rs = pstmt.executeQuery() ;
			  if( rs != null ) { 
				while(rs.next()) {				
					strDesc = rs.getString( "short_desc" ) ;
					strCode = rs.getString( "visit_type_code" );
					out.println(  "var element = "+frame_ref+"createElement('OPTION');"+"element.text = \""+strDesc+"\";"+"element.value= \""+strCode+"\";"+frame_ref+"forms[0].visit_adm_type.add(element);");			
					count++;					
				}
			  }					  
			out.println(""+frame_ref+"forms[0].visit_adm_type.disabled = false;");					

			if(count == 1) {
				out.println(""+frame_ref+"forms[0].visit_adm_type.options[1].selected = true;");
				out.println(""+frame_ref+"forms[0].visit_adm_type.onchange();");
			}else if(!old_vst_type_ind.equals("")){
				out.println("alert(getMessage('FIN_CHNGD_SEL_VST_TYPE','OP'))");
			}
				 			
			 //Added for the sCF - MMS-SCF-0082
			//}

			 out.println(""+frame_ref+"forms[0].blng_grp_id.value = '"+blng_grp_id+"'");
			 out.println(""+frame_ref+"forms[0].cust_grp_code.value = '"+cust_grp_code+"'");
			 out.println(""+frame_ref+"forms[0].cust_code.value = '"+cust_code+"'");
			 out.println(""+frame_ref+"forms[0].policy_type_code.value = '"+policy_type_code+"'");
			 episode_validation_insurance(out, visit_type_ind,patient_id,con,facility_id,frame_ref,locncode,episode_id);       		   	
		   }
}catch(Exception e){
	e.printStackTrace();
}

		    
}
// populates subservice based on the service.................................
  if(!service_code.equals(""))
  {

	boolean allowPopulation = true;
	boolean onChange = true;//Included for the MMS-SCF-0010 
	String clinic_code = request.getParameter("care_locn_code")==null?"":request.getParameter("care_locn_code");
	if(!list_name.equals("visit_adm_type")) { 		

		// Commented for PE tuning on 23/04/2010
		//pstmt = con.prepareStatement("select '1' from op_current_patient where facility_id = ? and locn_code = ? and patient_id = ? and service_code = ? and trunc(queue_date) = trunc(sysdate) and queue_status < '07' ");
	//	pstmt = con.prepareStatement("select '1' from op_current_patient where facility_id = ?  and patient_id = ? and service_code = ?  and queue_status < '07'");
		// changed the table name by Suresh M on 26.08.2010
		 

        // added by mujafar for ML-MMOH-CRF-1437 START
		if(isAllowRegForSameService)
		{
		pstmt = con.prepareStatement("select '1' from op_patient_queue where facility_id = ? and locn_code = ?  and patient_id = ? and service_code = ?  and queue_status < '07'");		
		pstmt.setString(1,facility_id);
		pstmt.setString(2,locncode);
		pstmt.setString(3,patient_id);
		pstmt.setString(4,service_code);
		}
		else
		{
		
		pstmt = con.prepareStatement("select '1' from op_patient_queue where facility_id = ?   and patient_id = ? and service_code = ?  and queue_status < '07'");		
		pstmt.setString(1,facility_id);
		//pstmt.setString(2,locncode);
		pstmt.setString(2,patient_id);
		pstmt.setString(3,service_code);
		}
		// added by mujafar for ML-MMOH-CRF-1437 START



		rs = pstmt.executeQuery(); 	
		
		if(rs.next())
		{
		  out.println("alert(parent.frames[1].frames[1].getMessage('OPEN_VISIT_STATUS_FOR_CLINIC','OP'));");
		  allowPopulation = false;
		  out.println(frame_ref+"visit_registration.service_code.options[0].selected = true;");
		//Added for the MMS-SCF-0189
		  if(visit_type_derv_rule.equals("B") ){
		  	out.println(frame_ref+"visit_registration.vst_type_ind.value = '';");
		  }
		}
		if(rs != null)rs.close();
		if(pstmt != null)pstmt.close();
   
		if(allowPopulation)
			{
			//String str1="";
			//String str2="";			
			if(allow_pop_subser.equals("Y"))
			{				
				
				pstmt = con.prepareStatement(" SELECT  SUBSERVICE_CODE subservice_code, AM_GET_DESC.AM_SUBSERVICE(SERVICE_CODE,SUBSERVICE_CODE,'"+locale+"','2') short_desc FROM AM_FACILITY_SUBSRVC WHERE  OPERATING_FACILITY_ID='"+facility_id+"' AND  SERVICE_CODE='"+service_code+"' ORDER BY 2");
	
				rs = pstmt.executeQuery();
				while( rs.next() )
				{
						str1 = rs.getString( "short_desc" );
						str2 = rs.getString( "subservice_code" );
						out.println(  "var element = "+frame_ref+"createElement('OPTION');"+
						"element.text = \""+str1+"\";"+
						"element.value= \""+str2+"\";"+
						frame_ref+"forms[0].subservice_code.add(element);");
				}
				if(rs != null) rs.close();
				if(pstmt!=null) pstmt.close();

		   }	
		if(visit_type_derv_rule.equals("S") ){
		   pstmt=con.prepareStatement("Select OP_EPISODE_VALIDATION(?,?,'',?,?) from Dual");
		   pstmt.setString( 1, facility_id);
		   pstmt.setString( 2, service_code);
		   pstmt.setString( 3, patient_id);
		   pstmt.setString( 4, clinic_code);
		   rs = pstmt.executeQuery();
		   if(rs.next())
		   {
				VisitDate = rs.getString(1);
		   }

		   /* 		  
		   if(visit_adm_type != null && !visit_adm_type.equals(""))
		   { 
			    episode_validation(out, p_visit_type_ind,episodeReqd, service_code, subservicecode, patient_id,con,facility_id,frame_ref,clinic_code,override_vtype_on_epsd_yn);
				//episode_validation(out, q_visit_adm_type_ind,episodeReqd, service_code, subservicecode,patient_id,con,facility_id,frame_ref);
		   }
		   */

			
			
		 //  if(!q_visit_adm_type_ind.equals("R"))//If Condition commented for the SCF - MMS-SCF-0010
		  // {
			  if(!isMohbr){//Condition added for the CRF-PMG2013-BRU-CRF-0002
			  vsql.setLength(0);
			  vsql.append("select a.visit_type_code, OP_GET_DESC.OP_VISIT_TYPE(a.FACILITY_ID, a.VISIT_TYPE_CODE,'"+locale+"','2') short_desc ");
			  vsql.append(" from op_visit_type_for_clinic a ,op_visit_type b where ");
			  
			  vsql.append(" a.facility_id = '"+facility_id+"' and a.facility_id=b.facility_id and a.visit_type_code=b.visit_type_code and a.clinic_code ='"+locncode+"' and a.eff_status='E' and b.eff_status='E'");

/*override_vtype_on_epsd_yn parameter check is modified for the MMS-SCF-0010 - start*/
			  if(override_vtype_on_epsd_yn.equals("Y"))
			  {	
				  if( (VisitDate.equals("-1")|| VisitDate.equals("0")))
					vsql.append(" and a.visit_type_ind = 'F' ");			  
			  }
			  else if(override_vtype_on_epsd_yn.equals("N"))
			  {
				  if( (VisitDate.equals("-1")|| VisitDate.equals("0")))
					vsql.append(" and a.visit_type_ind = 'F' ");
				  else
					vsql.append(" and a.visit_type_ind = 'L' "); 
			  }//override_vtype_on_epsd_yn parameter check is modified for the MMS-SCF-0010 - end
			  vsql.append(" order by 2 ");

	
			  //Included for the MMS-SCF-0010 - start
			 if(!appt_vst_type_code.equals("")){
				 
				 out.println(  "var element = "+frame_ref+"createElement('OPTION');"+"element.text = \""+str1+"\";"+"element.value= \""+str2+"\";"+frame_ref+"forms[0].visit_adm_type.remove(0);");	
				out.println(  "var element = "+frame_ref+"createElement('OPTION');"+"element.text = \"-----Select-----\";"+"element.value= \"\";"+frame_ref+"forms[0].visit_adm_type.add(element);");	
			 }
			 //Included for the MMS-SCF-0010 - end
			  int visitAdmCount = 0;
			  pstmt   = con.prepareStatement( vsql.toString());
			  rs = pstmt.executeQuery() ;
			  if( rs != null ) { 
				while( rs.next() ) {
					visitAdmCount++;
					str1 = rs.getString( "short_desc" ) ;
					str2 = rs.getString( "visit_type_code" );
					out.println(  "var element = "+frame_ref+"createElement('OPTION');"+"element.text = \""+str1+"\";"+"element.value= \""+str2+"\";"+frame_ref+"forms[0].visit_adm_type.add(element);");	
					//Included for the MMS-SCF-0010 - start
					if(!appt_vst_type_code.equals("") && appt_vst_type_code.equals(str2)){
						onChange=false;
						out.println(frame_ref+"forms[0].visit_adm_type.options["+(visitAdmCount)+"].selected = true;");
						out.println(""+frame_ref+"forms[0].visit_adm_type.onchange();");
					}
					//Included for the MMS-SCF-0010 - end
				}
			  } 
			  // The below condition visitAdmCount is newly added for CRF PMG20089-CRF-0855 [IN:024101] by Suresh M on 30.11.2010.
			if(visitAdmCount == 1 && onChange) { //condition modified for the MMS-SCF-0010								
					out.println(""+frame_ref+"forms[0].visit_adm_type.options[1].selected = true;");
					out.println(""+frame_ref+"forms[0].visit_adm_type.onchange();");				
			}
		   }else{//Else part added for the CRF-PMG2013-BRU-CRF0002 - start
			  if(!q_visit_adm_type_ind.equals("R")){
			  vsql.setLength(0);
			  
			 vsql.append("select a.visit_type_code, OP_GET_DESC.OP_VISIT_TYPE(a.FACILITY_ID, a.VISIT_TYPE_CODE,'"+locale+"','2') short_desc ");
			  vsql.append(" from op_visit_type_for_clinic a ,op_visit_type b where ");
			  vsql.append(" a.facility_id = '"+facility_id+"' and a.facility_id=b.facility_id and a.visit_type_code=b.visit_type_code and a.clinic_code ='"+locncode+"' and a.eff_status='E' and b.eff_status='E' ");

			  if(override_vtype_on_epsd_yn.equals("Y"))
			  {	
				  if( (VisitDate.equals("-1")|| VisitDate.equals("0")))
					vsql.append(" and a.visit_type_ind = 'F' ");			  
			  }
			  else if(override_vtype_on_epsd_yn.equals("N"))
			  {
				  if( (VisitDate.equals("-1")|| VisitDate.equals("0")))
					vsql.append(" and a.visit_type_ind = 'F' ");
				  else
					vsql.append(" and a.visit_type_ind = 'L' "); 
			  }
			  vsql.append(" order by 2 ");

			  
			  int visitAdmCount = 0;
			  pstmt   = con.prepareStatement( vsql.toString());
			  rs = pstmt.executeQuery() ;
			  if( rs != null ) { 
				while( rs.next() ) {
					visitAdmCount++;
					str1 = rs.getString( "short_desc" ) ;
					str2 = rs.getString( "visit_type_code" );
					out.println(  "var element = "+frame_ref+"createElement('OPTION');"+"element.text = \""+str1+"\";"+"element.value= \""+str2+"\";"+frame_ref+"forms[0].visit_adm_type.add(element);");						
				}
			  } 
			  // The below condition visitAdmCount is newly added for CRF PMG20089-CRF-0855 [IN:024101] by Suresh M on 30.11.2010.
			if(visitAdmCount == 1) { 
					out.println(""+frame_ref+"forms[0].visit_adm_type.options[1].selected = true;");
					out.println(""+frame_ref+"forms[0].visit_adm_type.onchange();");				
			}
		   }
		}//changes for the CRF-PMG2013-CRF-BRU-CRF-0002 -End
		}
       }
  }
	   if(visit_adm_type != null && !visit_adm_type.equals("") && allowPopulation)
	   { 
		   if(visit_type_derv_rule.equals("S")){		   
		    episode_validation(out, p_visit_type_ind,episodeReqd, service_code, subservicecode, patient_id,con,facility_id,frame_ref,clinic_code,override_vtype_on_epsd_yn);  
			}
       }
	   
	   //Added for the crf - Bru-HIMS-CRF-0198
	   if(visit_type_derv_rule.equals("S")){
		   checkMultipleSpeciality(out,con,facility_id,clinic_code,frame_ref);
	   }
	   //Added for the crf - Bru-HIMS-CRF-0198
  }
}
catch(Exception e)
	{
	out.print(e);
	e.printStackTrace();
	}
	finally
	{
	ConnectionManager.returnConnection(con,request);
	}
%>
<%!
void episode_validation(javax.servlet.jsp.JspWriter out, String p_visit_type_ind,String episodeReqd, String servicecode,String subservicecode, String l_patient_id,Connection con,String facility_id,String frame_list1,String locncode,String override_vtype_on_epsd_yn) throws IOException
  { 
	String setreadonly  = "F";
    String visit_date = "";
    //String str4     = "";   
	String chkFlag = "Y";
	String episode_close_days_fu="";
    String episode_close_days_wo_fu="";
	String last_visit_fu_reqd_yn="";
	//String last_visit_num="";
	int last_visit_num=0;
	String last_visit_date="";
	String episode_id="";
	String sql="";
//    String str1="";
    PreparedStatement pstmt=null;         
	PreparedStatement pstmt2=null;
	PreparedStatement pstmt3=null;
	ResultSet rs=null;
	ResultSet rset2=null;
	ResultSet rset3=null;

	String dur_for_fu_vsts_in_days = "";
	int no_of_fu_visits_allowed = 0;

    try
      {
	  if (!(episodeReqd.equals("X")))
       {
	     if(!servicecode.equals(""))
	      {
			 out.println("if("+frame_list1+"all.build_episode_rule != null){"+frame_list1+"all.build_episode_rule.value='S';}");
			 /*
			try{
		       pstmt = con.prepareStatement( " select build_episode_rule from op_param_for_facility_service where service_code='"+servicecode+"' and operating_facility_id='"+facility_id+"'",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
               str1  = "";
		       int maxrecord=0;
               rs = pstmt.executeQuery();
               if( rs != null )
                {
			       rs.last();
		           maxrecord=rs.getRow();
			       rs.beforeFirst();
			       if(maxrecord != 0 )
		         	{
			          while( rs.next() )
			              {
				            str1 = rs.getString( "build_episode_rule" );
							out.println("if("+frame_list1+"all.build_episode_rule != null){"+frame_list1+"all.build_episode_rule.value='"+str1+"';}");
			              }
		             }
                 }
		        if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
		      }catch(Exception e){out.println("alert(e);");e.printStackTrace();}
			  */
	     }
	  
		 sql = "";
		 // modified by N Munisekhar on 06-Mar-2012 against MMS-SCF-0003 [IN:038242]
         sql = "SELECT episode_id, last_visit_fu_reqd_yn,TO_CHAR (last_visit_date, 'yyyy-mm-dd') last_visit_date,NVL (last_visit_num, 0) + 1 last_visit_num FROM op_episode_for_service WHERE last_visit_date =(SELECT MAX (last_visit_date) FROM op_episode_for_service WHERE operating_facility_id ='"+facility_id+"' AND episode_status = '01' AND patient_id ='"+l_patient_id+"'";

         if (!servicecode.equals(""))
		  {
		       sql = sql+" and service_code='"+servicecode+"') and service_code='"+servicecode+"'";                     
          }    
		 sql = sql+"AND operating_facility_id ='"+facility_id+"' AND episode_status = '01' AND patient_id ='"+l_patient_id+"'";   		 
		  // End MMS-SCF-0003 [IN:038242]
		  
        /*
		 * else if (str1.equals("R") && !servicecode.equals(""))//to be verified {
		 * sql = sql+" and service_code='"+servicecode+"' and
		 * subservice_code=nvl('"+subservicecode+"',subservice_code)"; }
		 */ 
		
	      pstmt   = con.prepareStatement(sql);
          rs  = pstmt.executeQuery();    
		 
             
          if( rs != null && rs.next())
          {   
				
				  if (rs.getString("episode_id") != null)
                  episode_id = rs.getString( "episode_id" );
                  if (rs.getString("last_visit_fu_reqd_yn") != null)
                  last_visit_fu_reqd_yn = rs.getString( "last_visit_fu_reqd_yn" );
                  if (rs.getString("last_visit_date") != null)
                  last_visit_date = rs.getString( "last_visit_date" );

				  last_visit_num = rs.getInt( "last_visit_num" );

				  /*	
                  if (rs.getString("last_visit_num") != null)
                  last_visit_num = rs.getString( "last_visit_num" );
				  */
				
            	   if(!servicecode.equals(""))
			       {
					 if(override_vtype_on_epsd_yn.equals("Y"))
					 {					 
						 sql = "select  nvl(sign(months_between((trunc(to_date('"+last_visit_date+"','rrrr-mm-dd')) + decode('"+last_visit_fu_reqd_yn+"','Y',nvl(episode_close_days_fu,0),nvl(episode_close_days_wo_fu,0))),trunc(sysdate))),0) visit_date, nvl(episode_close_days_fu,0), nvl(episode_close_days_wo_fu,0) from op_param_for_facility_service where service_code ='"+servicecode+"' and operating_facility_id='"+facility_id+"'" ;						 
				
						 pstmt2   = con.prepareStatement(sql);
						 rset2 = pstmt2.executeQuery();
						 if (!rset2.next())
						  {
							
							sql = "select  nvl(sign(months_between((trunc(to_date('"+last_visit_date+"','rrrr-mm-dd')) + decode('"+last_visit_fu_reqd_yn+"','Y',nvl(episode_close_days_fu,0),nvl(episode_close_days_wo_fu,0))),trunc(sysdate))),0) visit_date, nvl(episode_close_days_fu,0), nvl(episode_close_days_wo_fu,0) from op_param where operating_facility_id='"+facility_id+"'" ;							
							
							pstmt3   = con.prepareStatement( sql );
							rset3 = pstmt3.executeQuery();     
							if (!rset3.next())
							 {
								
								chkFlag = "N";
							 }
							 else
								{
								   
									episode_close_days_fu = rset3.getString(2);
									episode_close_days_wo_fu = rset3.getString(3);
									visit_date = rset3.getString("visit_date");
								}           
							  if(rset3 != null) rset3.close();
							  if(pstmt3 != null) pstmt3.close();
						  }else
							  {
									
									episode_close_days_fu = rset2.getString(2);
									episode_close_days_wo_fu =rset2.getString(3);
									visit_date = rset2.getString("visit_date");
							  }
						if(rset2 != null) rset2.close();
						if(pstmt2 != null) pstmt2.close();
				   }
				   else if(override_vtype_on_epsd_yn.equals("N"))
				   {
					    sql = "select nvl(sign(months_between((trunc(to_date('"+last_visit_date+"','rrrr-mm-dd'))+ nvl(dur_for_follow_up_vsts_in_days,0)),trunc(sysdate))),0) visit_date, nvl(dur_for_follow_up_vsts_in_days,0) dur_for_follow_up_vsts_in_days, no_of_follow_up_visits_allowed from op_visit_type_control where service_code ='"+servicecode+"' and facility_id ='"+facility_id+"' and clinic_code = '"+locncode+"'" ;	
				
						 pstmt2   = con.prepareStatement(sql);
						 rset2 = pstmt2.executeQuery();
						 if (!rset2.next())
						 {							
							sql = "select nvl(sign(months_between((trunc(to_date('"+last_visit_date+"','rrrr-mm-dd'))+ nvl(dur_for_follow_up_vsts_in_days,0)),trunc(sysdate))),0) visit_date, nvl(dur_for_follow_up_vsts_in_days,0) dur_for_follow_up_vsts_in_days, no_of_follow_up_visits_allowed from op_param where operating_facility_id='"+facility_id+"'" ;								
							
							pstmt3 = con.prepareStatement( sql );
							rset3  = pstmt3.executeQuery();     
							if (!rset3.next())
							 {
								
								chkFlag = "N";
							 }
							 else
							 {
								   
									dur_for_fu_vsts_in_days = rset3.getString("dur_for_follow_up_vsts_in_days");
									no_of_fu_visits_allowed = rset3.getInt("no_of_follow_up_visits_allowed");
									visit_date = rset3.getString("visit_date");
							 }           
							 if(rset3 != null) rset3.close();
							 if(pstmt3 != null) pstmt3.close();
						  }else
							  {
									
									dur_for_fu_vsts_in_days = rset2.getString("dur_for_follow_up_vsts_in_days");
									no_of_fu_visits_allowed = rset2.getInt("no_of_follow_up_visits_allowed");
									visit_date = rset2.getString("visit_date");
							  }
						if(rset2 != null) rset2.close();
						if(pstmt2 != null) pstmt2.close();


				   }

		         } 
		         else if(servicecode.equals(""))
		               {
			               chkFlag = "N";
		               }		
			

                  if(chkFlag.equals("Y"))
                 {
												   
					if(override_vtype_on_epsd_yn.equals("Y"))
					{
						out.println("if("+frame_list1+"forms[0].episode_close_days_fu != null){"+frame_list1+"forms[0].episode_close_days_fu.value='"+episode_close_days_fu+"';}");
						out.println("if("+frame_list1+"forms[0].episode_close_days_wo_fu != null){"+frame_list1+"forms[0].episode_close_days_wo_fu.value='"+episode_close_days_wo_fu+"';}");

						 if (visit_date.equals("-1")|| visit_date.equals("0"))
						 {						  
							 out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
							 out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
							 out.println(frame_list1+"forms[0].op_episode_id.value='';"); 					 
						 }
						 else
						 {       
							   
							 if(p_visit_type_ind.equals("F"))
							 {
								   
								out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
								out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
								out.println(frame_list1+"forms[0].op_episode_id.value='';"); 
								
								}
								else
								   {
									
									
									
								out.println(frame_list1+"forms[0].new_op_episode_yn.value='N';");
								out.println(frame_list1+"forms[0].op_episode_visit_num.value='"+last_visit_num+"';");
								out.println(frame_list1+"forms[0].op_episode_id.value='"+episode_id+"';");
								out.println(frame_list1+"forms[0].old_episode_no.value='"+episode_id+"';");
								  }
					
							 if(episode_id.equals(""))
							  {
								
								out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
							   out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
								out.println(frame_list1+"forms[0].op_episode_id.value='';");
							  }
						 }
					}
					else 
					{
						out.println("if("+frame_list1+"forms[0].dur_for_fu_vsts_in_days != null){"+frame_list1+"forms[0].dur_for_fu_vsts_in_days.value='"+dur_for_fu_vsts_in_days+"';}");
						out.println("if("+frame_list1+"forms[0].no_of_fu_visits_allowed != null){"+frame_list1+"forms[0].no_of_fu_visits_allowed.value='"+no_of_fu_visits_allowed+"';}");						

						 if (visit_date.equals("-1")|| visit_date.equals("0")|| last_visit_num > (no_of_fu_visits_allowed+1))
						 {	
							 out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
							 out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
							 out.println(frame_list1+"forms[0].op_episode_id.value='';"); 				 
						 }
						 else
						 {       
							   
								if(p_visit_type_ind.equals("F"))
								{									   
									out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
									out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
									out.println(frame_list1+"forms[0].op_episode_id.value='';"); 				
								}
								else
								{									
									out.println(frame_list1+"forms[0].new_op_episode_yn.value='N';");			out.println(frame_list1+"forms[0].op_episode_visit_num.value='"+last_visit_num+"';");
									out.println(frame_list1+"forms[0].op_episode_id.value='"+episode_id+"';");
									out.println(frame_list1+"forms[0].old_episode_no.value='"+episode_id+"';");
								}
					
							   if(episode_id.equals(""))
							   {																						out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
									out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
									out.println(frame_list1+"forms[0].op_episode_id.value='';");
							   }
						 }
					}

				 }
            }			 
          else
          {
					if(override_vtype_on_epsd_yn.equals("Y"))
					{
						pstmt2   = con.prepareStatement("select episode_close_days_fu,episode_close_days_wo_fu from op_param where operating_facility_id = '"+facility_id+"'");

						rset2 = pstmt2.executeQuery();

						if (rset2!= null)
						{
							if(rset2.next())
							{
							  episode_close_days_fu   = rset2.getString("episode_close_days_fu");
							  episode_close_days_wo_fu= rset2.getString("episode_close_days_wo_fu");						  
							}
						}

						out.println(frame_list1+"forms[0].episode_close_days_fu.value='"+episode_close_days_fu+"';");
						out.println(frame_list1+"forms[0].episode_close_days_wo_fu.value='"+episode_close_days_wo_fu+"';");

						if (rset2 != null)   rset2.close();
						if (pstmt2 != null) pstmt2.close();

					}

					out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
					out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
					out.println(frame_list1+"forms[0].op_episode_id.value='';");
		}

		  if(rs != null) rs.close();
		  if(pstmt != null)  pstmt.close();

        
      }
      else
      { 
		
        setreadonly = "T";
      }
    
	  if (setreadonly.equals("T") && !(episodeReqd.equals("X")))
       {
		   
			//out.println(frame_list1+"forms[0].new_op_episode_yn.disabled=false;");
			//out.println(frame_list1+"forms[0].new_op_episode_yn.checked=true;");
			//out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
			//out.println(frame_list1+"forms[0].new_op_episode_yn.disabled=true;");
			out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
			out.println(frame_list1+"forms[0].op_episode_id.value='';");
			out.println(frame_list1+"forms[0].episode_close_days_fu.value='0';");
			out.println(frame_list1+"forms[0].episode_close_days_wo_fu.value='0';");
	   }
     }
     catch(Exception ex){
		 ex.printStackTrace();
     out.println(ex);
     out.println("alert('exception');");
    }
  }
  
  %>
<%!
  void episode_validation_pract(javax.servlet.jsp.JspWriter out, String p_visit_type_ind,String episodeReqd, String servicecode,String subservicecode, String l_patient_id,Connection con,String facility_id,String frame_list1,String locncode,String populate_visit_type) throws IOException
  { 
	String setreadonly  = "F";     
	String last_visit_fu_reqd_yn="";	
	int last_visit_num=0;
	String last_visit_date="";
	String episode_id="";
	String sql="";
    PreparedStatement pstmt=null; 
	ResultSet rs=null;	 
    try
      {
		
	  if(!(episodeReqd.equals("X"))){
		  		
	     if(!servicecode.equals("")){
			 out.println("if("+frame_list1+"all.build_episode_rule != null){"+frame_list1+"all.build_episode_rule.value='S';}");			
	     }	  
		 sql = "";
          // modified by N Munisekhar on 06-Mar-2012 against MMS-SCF-0003 [IN:038242]
        /* sql = "SELECT episode_id, last_visit_fu_reqd_yn,TO_CHAR (last_visit_date, 'yyyy-mm-dd') last_visit_date,NVL (last_visit_num, 0) + 1 last_visit_num FROM op_episode_for_service WHERE last_visit_date =(SELECT MAX (last_visit_date) FROM op_episode_for_service WHERE operating_facility_id ='"+facility_id+"' AND episode_status = '01' AND patient_id ='"+l_patient_id+"'";

         if (!servicecode.equals(""))
		  {
		       sql = sql+" and service_code='"+servicecode+"') and service_code='"+servicecode+"'";                     
          }    
		 sql = sql+"AND operating_facility_id ='"+facility_id+"' AND episode_status = '01' AND patient_id ='"+l_patient_id+"'";  
		 // End MMS-SCF-0003 [IN:038242]   */
		 //above lines commented for the SCF - KDAH -SCF-0177 
		  sql = "select episode_id, last_visit_fu_reqd_yn , to_char(last_visit_date,'yyyy-mm-dd') last_visit_date, nvl(last_visit_num,0)+1 last_visit_num from op_episode_for_service where operating_facility_id='"+facility_id+"' and episode_status='01' and patient_id='"+l_patient_id+"'";
         if (!servicecode.equals("")){
		       sql = sql+" and service_code='"+servicecode+"'";                     
          }
				sql = sql+" order by added_date desc";    
		  
		  
	      pstmt   = con.prepareStatement(sql);
          rs  = pstmt.executeQuery();             
          if( rs != null && rs.next()){   
				
				  if (rs.getString("episode_id") != null)
                  episode_id = rs.getString( "episode_id" );
                  if (rs.getString("last_visit_fu_reqd_yn") != null)
                  last_visit_fu_reqd_yn = rs.getString( "last_visit_fu_reqd_yn" );
                  if (rs.getString("last_visit_date") != null)
                  last_visit_date = rs.getString( "last_visit_date" );
				  last_visit_num = rs.getInt( "last_visit_num" );	
				  			  
				  
            	   if(!servicecode.equals("")){				
					   
						if(p_visit_type_ind.equals("F")){									   
							out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
							out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
							out.println(frame_list1+"forms[0].op_episode_id.value='';"); 				
							out.println(frame_list1+"forms[0].vst_type_ind.value='F';"); 		//added for the CRF MMS-QH-CRF 41.1		
						}else{									
							out.println(frame_list1+"forms[0].new_op_episode_yn.value='N';");			out.println(frame_list1+"forms[0].op_episode_visit_num.value='"+last_visit_num+"';");
							out.println(frame_list1+"forms[0].op_episode_id.value='"+episode_id+"';");
							out.println(frame_list1+"forms[0].old_episode_no.value='"+episode_id+"';");
							out.println(frame_list1+"forms[0].vst_type_ind.value='L';");//added for the CRF MMS-QH-CRF 41.1
						}
					}
		  if(rs != null) rs.close();
		  if(pstmt != null)  pstmt.close();
		  }else{
					
					out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
					out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
					out.println(frame_list1+"forms[0].op_episode_id.value='';");
					out.println(frame_list1+"forms[0].vst_type_ind.value='F';");//added for the CRF MMS-QH-CRF 41.1
		  }
      }
      else
      { 
		
        setreadonly = "T";
      }
    
	  if (setreadonly.equals("T") && !(episodeReqd.equals("X")))
       {			 
			out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
			out.println(frame_list1+"forms[0].op_episode_id.value='';");
			out.println(frame_list1+"forms[0].episode_close_days_fu.value='0';");
			out.println(frame_list1+"forms[0].episode_close_days_wo_fu.value='0';");
	   }
     }
     catch(Exception ex){
		 ex.printStackTrace();
     out.println(ex);
     out.println("alert('exception');");
    }
  }
  
  %>

<%!
  void episode_validation_insurance(javax.servlet.jsp.JspWriter out,String p_visit_type_ind,String l_patient_id,Connection con,String facility_id,String frame_list1,String locncode,String episode_id) throws IOException
  { 
	String setreadonly  = "F";     
	String last_visit_fu_reqd_yn="";	
	int last_visit_num=0;
	String last_visit_date="";
	//String episode_id="";
	String sql="";
    PreparedStatement pstmt=null; 
	ResultSet rs=null;	 
    try
      {			
		 sql = "";
		 
			 out.println("if("+frame_list1+"all.build_episode_rule != null){"+frame_list1+"all.build_episode_rule.value='S';}");			
	  
        // if(!episode_id.equals("")){
			  sql = "select  last_visit_fu_reqd_yn , to_char(last_visit_date,'yyyy-mm-dd') last_visit_date, nvl(last_visit_num,0)+1 last_visit_num from op_episode_for_service where operating_facility_id='"+facility_id+"' and episode_status='01' and patient_id='"+l_patient_id+"' " ;
			  if(!episode_id.equals(""))
				  sql=sql+" and episode_id='"+episode_id+"'";                     
				else{
					sql=sql+" and clinic_code='"+locncode+"'";
				}
				sql = sql+" order by added_date desc"; 
				pstmt   = con.prepareStatement(sql);
				rs  = pstmt.executeQuery();             
				 if( rs != null && rs.next()){   
				
					if (rs.getString("last_visit_fu_reqd_yn") != null)
					 last_visit_fu_reqd_yn = rs.getString( "last_visit_fu_reqd_yn" );
					 if (rs.getString("last_visit_date") != null)
					 last_visit_date = rs.getString( "last_visit_date" );
					 last_visit_num = rs.getInt( "last_visit_num" );	
					 if(p_visit_type_ind.equals("F")){									   
						out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
						out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
						out.println(frame_list1+"forms[0].op_episode_id.value='';"); 				
						out.println(frame_list1+"forms[0].vst_type_ind.value='F';"); 		
					}else{									
						out.println(frame_list1+"forms[0].new_op_episode_yn.value='N';");			
						out.println(frame_list1+"forms[0].op_episode_visit_num.value='"+last_visit_num+"';");
						out.println(frame_list1+"forms[0].op_episode_id.value='"+episode_id+"';");
						out.println(frame_list1+"forms[0].old_episode_no.value='"+episode_id+"';");
						out.println(frame_list1+"forms[0].vst_type_ind.value='L';");
					}
				}else{
					out.println(frame_list1+"forms[0].new_op_episode_yn.value='Y';");
					out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
					out.println(frame_list1+"forms[0].op_episode_id.value='';");
					out.println(frame_list1+"forms[0].vst_type_ind.value='F';");
				}
				   				
		  if(rs != null) rs.close();
		  if(pstmt != null)  pstmt.close();

		/* }else{
				
		 }*/
		    
		  
		  
	      
		  
      /*}
      else
      { 
		
        setreadonly = "T";
      }
    
	  if (setreadonly.equals("T") && !(episodeReqd.equals("X")))
       {			 
			out.println(frame_list1+"forms[0].op_episode_visit_num.value='';");
			out.println(frame_list1+"forms[0].op_episode_id.value='';");
			out.println(frame_list1+"forms[0].episode_close_days_fu.value='0';");
			out.println(frame_list1+"forms[0].episode_close_days_wo_fu.value='0';");
	   }*/
     }
     catch(Exception ex){
		 ex.printStackTrace();
     out.println(ex);
     out.println("alert('exception');");
    }
  }
  
  %>

<%!



public boolean allowToProceed(String locncode, Connection con,String facility_id,String refid, String appt_id,String allow_walk_in_yn,String allow_referral_yn,String allow_appt_yn,JspWriter out)  throws Exception
{
	
  StringBuffer alertString = new StringBuffer( "" ) ;
  if(!refid.equals(""))
   { out.println("PatVisHid(3);");// added by munisekhar for MMS-QH-CRF-0162
    if(allow_referral_yn.equals("N"))
     {  out.println("alert(parent.frames[1].frames[1].getMessage(\"REF_NOT_ALLOWED_FOR_CURR_CLINIC\",'OP'))");
       return false;
     }
   }
  if(! appt_id.equals(""))
   {
    if(allow_appt_yn.equals("N"))
	  {
         out.println("alert(parent.frames[1].frames[1].getMessage(\"APPT_NOT_ALLOWED_FOR_CURR_CLINIC\",'OP'))");
         return false;
     }	 
  }

 if( allow_walk_in_yn.equals("N"))
 {
 	out.println("alert(parent.frames[1].frames[1].getMessage(\"WALK_INS_NOT_ALLOWED_FOR_CURR_CLINIC\",'OP'))");
	out.println("parent.frames[1].frames[3].document.forms[0].assign_care_locn_desc.value='';");//added by munisekhar for [IN:046603] 
    out.println("PatVisHid(2);");//added by munisekhar for [IN:046603] 
    return false;
 }

 if(!alertString.toString().equals(""))
  {
	//out.println("alert(\""+alertString.toString()+"\")");
	return false;
  }
else{
	return true;
 }

}
%>

<%!
boolean check_patient_id(javax.servlet.jsp.JspWriter out,String patient_id,String prompt,String fac_id,String fromchk, Connection con,String functionId,String bl_install_yn,String fromPatidF1,String callFromMenu_yn,String func_source,String called_from,String register_visit_walkin,String register_visit_referral,String oper_stn_id,String build_episode_rule,String or_install_yn,String emer_regn_allow_yn,String visit_for_inpat_yn,String nat_id_prompt,String queryString,String locale,String entitlement_by_cat_yn,String upt_contact_dtls_oa_yn,boolean isUHID_valid_appl,boolean isNationalIdValidationAppl,boolean isNatIdOrAltIdMandVisaType,boolean isInvokeChngPatDtls,boolean isChkMPParamMandFlds,boolean isCountryRegionValAppl,boolean isNatIdAltIdMandVisaType) // modified by mujafar for AMRI-CRF-0357 //Modified by Ashwini on 06-Mar-2019 for MO-CRF-20148
	{ 
		/* isNatIdOrAltIdMandVisaType Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750]*/
		//isChkMPParamMandFlds Added By Dharma on 12th May 2020 against KDAH-CRF-0522.1
		//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
		String alt_status="";
		String  continue_yn="";
		String isPatDispChk	= "";
		char merged_yn='N';
		char  alert_yn='Y';
		String warning_text="";
		String valid_patient_id=patient_id;
		String HcExpired="";
		//String from_appt="";
		String oa_install_yn="";
		String in_pat_status = "";
		
		 String result_pr_enc_ref_man	= "Y";/* Added By Dharma for Non-Citizen Validation on 30th Dec 2013 Start*/
			PreparedStatement pstmt1=null;
			Statement stmt1    = null;
			ResultSet rs1    = null;
		 
		 try
          { 
            
			if (prompt!=null)
            prompt = "true"; 
            else
            prompt = "";
			webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
			patdata.setFacility_id(fac_id);
			String pat_status = patdata.CheckStatus(con,patient_id);
			//in_pat_status = patdata.CheckInPatient(con,patient_id,fac_id);
			
			//alt_status = patdata.CheckAlternateId(con,patient_id,locale);  
			
			//String file_status= patdata.CheckFileDetails(con,patient_id,fac_id);
			
	        if (pat_status.equals("SUSPENDED"))
             {
                out.println("alert(parent.frames[1].frames[1].getMessage('PAT_SUSPENDED_NOT_ALLOWED','MP'));");
		        out.println("parent.frames[1].frames[1].document.forms[0].clear1.click()");
				alert_yn = 'N';  continue_yn = "N";
 	            if(!fromPatidF1.equals("true"))
		        {  
					out.println("if(parent.frames[1].frames[1].document.getElementById('pat_id1') != null) {");
					out.println("parent.frames[1].frames[1].document.getElementById('pat_id1').readOnly=false;");
					out.println("parent.frames[1].frames[1].document.getElementById('pat_id1').value='';");
					out.println("}");
		       }
		      valid_patient_id="";
	      }
          else if (pat_status.equals("DECEASED"))
                {
					out.println("alert(parent.frames[1].frames[1].getMessage('PAT_DECEASED_NOT_ALLOWED','MP'));");
					out.println("parent.frames[1].frames[1].document.forms[0].clear1.click()");
					alert_yn = 'N';  continue_yn = "N";
				if(!fromPatidF1.equals("true"))
				 {   
					out.println("if(parent.frames[1].frames[1].document.getElementById('pat_id1') != null) {");
					out.println("parent.frames[1].frames[1].document.forms[0].reset()");
					out.println("}");
                 }else
		             { 
				     out.println("parent.frames[0].document.getElementById('patient_id').disabled=false;");
				     out.println("parent.frames[0].document.getElementById('patient_id').value='';");
		            }
		       valid_patient_id="";
		
	          }     
	      else if (pat_status.equals("SECURED"))
                {
       	          out.println("alert(parent.frames[1].frames[1].getMessage('SECURED_NOT_ALLOWED','COMMON'));");
    	          out.println("parent.frames[1].frames[1].document.forms[0].clear1.click()");
				  alert_yn = 'N';  continue_yn = "N";
                  if(!fromPatidF1.equals("true")){
				  out.println("if(parent.frames[1].frames[1].document.getElementById('pat_id1') != null) {");
				  out.println("parent.frames[1].frames[1].document.forms[0].reset()");
				  out.println("}");
					}
		          valid_patient_id="";
	           }
	      else if (pat_status.equals("INACTIVE"))
                {
		         out.println("alert(parent.frames[1].frames[1].getMessage('PAT_INACTIVE_NOT_ALLOWED','MP'));");
		         out.println("parent.frames[1].frames[1].document.forms[0].clear1.click()");
				alert_yn = 'N';  continue_yn = "N";
	            if(!fromPatidF1.equals("true")){  
				out.println("if(parent.frames[1].frames[1].document.getElementById('pat_id1') != null) {");
				out.println("parent.frames[1].frames[1].document.forms[0].reset()");
				
				out.println("}");
         	  }
		  else
		  {
			  out.println("parent.frames[0].document.getElementById('patient_id').disabled=false;");
			  out.println("parent.frames[0].document.getElementById('patient_id').value='';");
		  }
		valid_patient_id="";
	  }
      else if ( pat_status.equals("INVALID_PATIENT") || alt_status.equals("INVALID_PATIENT") )
      {
		/*Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857] Start*/
		String chkPatDispArch=patdata.checkPatientDisposeArchive(con,patient_id);
		if(chkPatDispArch.equals("D")){
			isPatDispChk	= "D";
			out.println("async function toHoldShowModal4(){");
			out.println("if(confirm(getMessage('PAT_DISPOSED_REGISTER','MP'))){	");
			out.println("var retVal =  new String();");
					out.println("var dialogTop   = '0vh'");
					out.println("var dialogHeight    = '90vh'") ; 
					out.println("var dialogWidth = '90vw'") ;
					out.println("var features  = 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';status=no; scroll=no'");
					out.println("var arguments = '' ");
					out.println("var function_id = 'VISIT_REGISTRATION';");
					out.println("var url='../../eMP/jsp/PatientRegistrationMain.jsp?&module_id=MP&function_id='+function_id+'&function_type=F&access=YYYNN&func_act=Visitreg';");
					out.println("retVal = await top.window.showModalDialog(url,arguments,features);");
					out.println("if(retVal){");
					out.println("if( retVal != null || retVal.length != 0)");
					out.println("parent.close();");
					out.println("parent.frames[1].frames[1].document.forms[0].pat_id1.value=retVal;");
					out.println("parent.frames[1].frames[1].document.forms[0].srch_code.disabled=false;");
					out.println("parent.frames[1].frames[1].document.forms[0].srch_code.click();");
					out.println("parent.frames[1].frames[1].document.forms[0].srch_code.disabled=true;");
					out.println("}");
					out.println("}else{");
					out.println("parent.frames[1].frames[1].document.forms[0].clear1.click()");
					out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_value=0&error_num=aa'");
					out.println("}");
					alert_yn = 'N';  continue_yn = "N";
		}else if(chkPatDispArch.equals("I")){
			isPatDispChk	= "I";
			out.println("if(confirm(getMessage('PAT_ACTIVATE','MP'))){	");
				out.println("var xmlDoc = '';");
				out.println("var xmlHttp = new XMLHttpRequest();");
				out.println("xmlStr ='<root><SEARCH /></root>';");
				out.println("xmlDoc = new DOMParser().parseFromString(xmlStr, 'text/xml');");
				out.println("xmlHttp.open('POST','../../eMP/jsp/MPIntermediate.jsp?action=activate_pat&patientId="+patient_id+"',false);");
				out.println("xmlHttp.send(xmlDoc);");
				out.println("responseText=xmlHttp.responseText;");
				out.println("responseText = trimString(responseText);");
				out.println("parent.frames[1].frames[1].document.forms[0].srch_code.disabled=false;");
				out.println("parent.frames[1].frames[1].document.forms[0].srch_code.click();");
				out.println("parent.frames[1].frames[1].document.forms[0].srch_code.disabled=true;");
			out.println("}else{");
			out.println("parent.frames[1].frames[1].document.forms[0].clear1.click()");
			out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_value=0&error_num=aa'");
			out.println("}}toHoldShowModal4();");
			alert_yn = 'N';  continue_yn = "N";
		}else{
			/*Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857] End*/
		out.println("alert(parent.frames[1].frames[1].getMessage('INVALID_PATIENT','MP'));");       
        out.println("parent.frames[1].frames[1].document.forms[0].clear1.click()");
		alert_yn = 'N';  continue_yn = "N";
 		  if(!fromPatidF1.equals("true")){   
		out.println("if(parent.frames[1].frames[1].document.getElementById('pat_id1') != null) {");
		out.println("parent.frames[1].frames[1].document.forms[0].reset()");
		
		out.println("}");
		out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_value=0&error_num=aa'");
			}//Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857]
			else {
		  out.println("parent.frames[0].document.getElementById('patient_id').disabled=false;");
		  out.println("parent.frames[0].document.getElementById('patient_id').value='';");
	    }
		valid_patient_id="";
			}
	 } 
	else if (pat_status.equals("BLACKLISTED_PATIENT"))
      {
		out.println("alert(parent.frames[1].frames[1].getMessage('BLACKLISTED_PATIENT','MP'));");
		out.println("parent.frames[1].frames[1].document.forms[0].clear1.click()");
		alert_yn = 'N';  continue_yn = "N";
	  if(!fromPatidF1.equals("true"))
	   {
		out.println("if(parent.frames[1].frames[1].document.getElementById('pat_id1') != null) {");
		out.println("parent.frames[1].frames[1].document.forms[0].reset()");
		out.println("}");
		}
		valid_patient_id="";
	  }
	else if (pat_status.indexOf("PATIENT_MERGED_VALID")>=0 )
	{
		StringTokenizer token=new StringTokenizer(pat_status,"$");
		valid_patient_id = token.nextToken(); 
		valid_patient_id = token.nextToken();
		
		alert_yn = 'N';  
		continue_yn = "N";
		merged_yn = 'Y';
		out.println("var msg =parent.frames[1].frames[1].getMessage('PATIENT_MERGED_VALID','MP')");
		out.println("msg = msg.replace('#','"+valid_patient_id+"');alert(msg);");
		out.println("parent.frames[1].frames[1].document.forms[0].pat_id1.value='"+valid_patient_id+"'"); 
		patient_id=valid_patient_id;
	}
	else if (pat_status != "")
      {
        warning_text=warning_text+pat_status+ "<br>";
      }
	        
	        
	        /* Added By Dharma for Non-Citizen Validation on 30th Dec 2013 Start*/
	  	  if((!valid_patient_id.equals(""))){
	  		  
	  			  	if(pstmt1 != null) pstmt1.close();
	  				if(rs1  != null) rs1.close();
	  				String PrEncRefManSql =  "select  PR_ENC_REF_MAN(?,?,?,?) from dual";
	  				pstmt1 = con.prepareStatement(PrEncRefManSql);
	  				pstmt1.setString(1,fac_id);
	  				pstmt1.setString(2,valid_patient_id);
	  				pstmt1.setString(3,"");
	  				pstmt1.setString(4,"OP");
	  				rs1 = pstmt1.executeQuery();
	  			 try{
	  				 if(rs1!=null && rs1.next()){
	  					 result_pr_enc_ref_man	= rs1.getString(1);
	  				 }
	  				
	  				 if(result_pr_enc_ref_man.equals("N")){
	  					  out.println("alert(parent.frames[1].frames[1].getMessage('PATIENT_IS_NOT_A_CITIZEN','COMMON'));");
	  				      out.println("parent.frames[1].frames[1].document.forms[0].clear1.click()");
	  			 		  if(!fromPatidF1.equals("true")){   
	  						out.println("if(parent.frames[1].frames[1].document.getElementById('pat_id1') != null) {");
	  						out.println("parent.frames[1].frames[1].document.forms[0].reset()");
	  						out.println("}");
	  						out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_value=0&error_num=aa'");
	  			 		  }
	  			 		  alert_yn	= 'N';
	  				 }
	  			  } catch(Exception e1) {
	  					e1.printStackTrace();
	  			  } finally{
	  				 if(pstmt1 != null) pstmt1.close();
	  				 if(rs1  != null) rs1.close();
	  				}
	  	
	  	  }
	  	  /* Added By Dharma for Non-Citizen Validation on 30th Dec 2013 End*/  
			  
		    
	if(alert_yn != 'N') 
	{
	out.println("PatVisHid(3);");// added by munisekhar for MMS-QH-CRF-0162
		in_pat_status = patdata.CheckInPatient(con,patient_id,fac_id);	
		alt_status = patdata.CheckAlternateId(con,patient_id,locale);
	
		String pat_status_temp="proceed";
	
		/*Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750] Start*/		
			
		JSONObject patDtlsObj	= new JSONObject();
		String natId					= "";
		String natIddft					= "";
		String altId1					= "";
		String altId2					= "";
		String pat_dtls_unknown_yn		= "";
		String citizen_yn				= "";
		String visa_type				= "";
		String altId1Desc				= "";
		String altId2Desc				= "";
		String natIdPrompt				= "";
		String errMsg					= "";
		String showAlert					= "N";
		//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
		if((isNatIdOrAltIdMandVisaType || isInvokeChngPatDtls || isNatIdAltIdMandVisaType) && alert_yn != 'N'){
			patDtlsObj						= eMP.MPCommonBean.chkNatIDAltIDAvail(con, patient_id,locale);
			natId					= (String)patDtlsObj.get("national_id_no");
			natIddft				= (String)patDtlsObj.get("national_id_no_dft");//Maheshwaran added AAKH-CRF-0168 as on 19-11-2022
			altId1					= (String)patDtlsObj.get("alt_id1_no");
			altId2					= (String)patDtlsObj.get("alt_id2_no");
			pat_dtls_unknown_yn		= (String)patDtlsObj.get("pat_dtls_unknown_yn");
			citizen_yn				= (String)patDtlsObj.get("citizen_yn");
			visa_type				= (String)patDtlsObj.get("visa_type");//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
			altId1Desc				= (String)patDtlsObj.get("alt_id1_type_desc");
			altId2Desc				= (String)patDtlsObj.get("alt_id2_type_desc");
			natIdPrompt				= (String)patDtlsObj.get("nat_id_prompt");
			showAlert				= (String)patDtlsObj.get("showAlert");
		}
		//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
		JSONObject MPParamJSONObj1 = new JSONObject();
		MPParamJSONObj1 = eMP.MPCommonBean.getMPAuditTrailDetails(con);
		String dft_national_id = (String)MPParamJSONObj1.get("dft_national_id");//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
		//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
		if(visa_type.equals(""))
			visa_type="W";
		if(isNatIdOrAltIdMandVisaType && alert_yn != 'N'){
			if(pat_dtls_unknown_yn.equals("N") && showAlert.equals("Y")){
				if(citizen_yn.equals("Y") && natId.equals("")){
					errMsg	= natIdPrompt;
				}else if(citizen_yn.equals("N") && altId1.equals("") && altId2.equals("") ){
					errMsg	= altId1Desc+"/"+altId2Desc;
				}
			}
			/*if(!errMsg.equals("")){
				
				out.println("var message=parent.frames[1].frames[1].getMessage('NATID_ALTID_NOT_AVAILABLE','MP'); alert(message.replace('#','"+errMsg+"'));");
				out.println("parent.frames[0].document.getElementById('reset').click();");
				alert_yn	= 'N';
				continue_yn = "N";
				valid_patient_id = "";
			}else{
				alert_yn = 'Y';
			}
			if(alert_yn == 'N') {
				alt_status = "";
				in_pat_status="";
			}*/
		}
		/*Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750] End*/
		/*Added By Dharma on 12th May 2020 against KDAH-CRF-0522.1 Start*/
		String strMPParamMandFlds	= "";
		if(isChkMPParamMandFlds && alert_yn != 'N'){
			strMPParamMandFlds = eMP.MPCommonBean.chkMPMandFieldsForEncCreation(con, patient_id,locale);
			if(!strMPParamMandFlds.equals("Y")){
				errMsg	= strMPParamMandFlds;
			}
		}

		if((isNatIdOrAltIdMandVisaType || isChkMPParamMandFlds) && alert_yn != 'N' && !errMsg.equals("")){
			if(!errMsg.equals("")){
				out.println("var message=parent.frames[1].frames[1].getMessage('NATID_ALTID_NOT_AVAILABLE','MP'); alert(message.replace('#','"+errMsg+"'));");
				out.println("parent.frames[0].document.getElementById('reset').click();");
				alert_yn	= 'N';
				continue_yn = "N";
				valid_patient_id = "";
			}else{
				alert_yn = 'Y';
			}
			if(alert_yn == 'N') {
				alt_status = "";
				in_pat_status="";
			}
		}
		/*Added By Dharma on 12th May 2020 against KDAH-CRF-0522.1 End*/
		/*Added by Dharma on 24th Apr 2019 against MMS-DM-CRF-0152.1 Start*/
		//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
		if((isInvokeChngPatDtls || isNatIdAltIdMandVisaType )&& alert_yn != 'N'){
			if(pat_dtls_unknown_yn.equals("N") && showAlert.equals("Y")){
				if(isInvokeChngPatDtls)
				{
				if(citizen_yn.equals("Y") && natId.equals("")){
					errMsg	= natIdPrompt;
				}else if(citizen_yn.equals("N") && altId1.equals("")){
					errMsg	= altId1Desc;
				}
				}
			//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022	
			if(isNatIdAltIdMandVisaType)
				{
				if((citizen_yn.equals("Y") && !dft_national_id.equals("")) || (citizen_yn.equals("N") &&  !dft_national_id.equals("") && (visa_type.equals("") || visa_type.equals("W"))))
					{
					//National ID null	
					if(natId.equals("")  )
						{						
						if(!altId1.equals("") && !altId2.equals("")&& !dft_national_id.equals(natIddft))	
							{
							errMsg	= natIdPrompt;									
							}
						if(altId1.equals("") && !altId2.equals("") && !dft_national_id.equals(natIddft))	
							{
							errMsg	= natIdPrompt+"/"+altId1Desc;								
							}	
						if(!altId1.equals("") && (altId2.equals("") && !dft_national_id.equals(natIddft)))	
							{
							errMsg	= natIdPrompt+"/"+altId2Desc;									
							}	
					
						}
					//Alt ID1 null		
					if(altId1.equals(""))
						{						
						if(!natId.equals("") && !altId2.equals(""))	
							{
							errMsg	= altId1Desc;									
							}
						if(natId.equals("") && !altId2.equals(""))	
							{
							errMsg	= natIdPrompt+"/"+altId1Desc;								
							}	
						if(!natId.equals("") && (altId2.equals("") && dft_national_id.equals(natId)))	
							{
							errMsg	= altId1Desc+"/"+altId2Desc;		
							}	
						}
					//Alt ID2 null		
					if(altId2.equals("") )
						{						
						if(!natId.equals("") && !altId1.equals("") && dft_national_id.equals(natIddft))	
							{
							errMsg	= altId2Desc;									
							}
						if(natId.equals("") && natIddft.equals("")  && !altId1.equals("") && dft_national_id.equals(natIddft))	
							{
							errMsg	= natIdPrompt+"/"+altId2Desc;								
							}	
						if(natId.equals("") && !natIddft.equals("")  && !altId1.equals("") && dft_national_id.equals(natIddft))	
							{
							errMsg	= altId2Desc;								
							}	
						if(natId.equals("") && !altId1.equals("") && !dft_national_id.equals(natIddft))	
							{
							errMsg	= natIdPrompt;								
							}	
						if(natId.equals("") && altId1.equals("") && !dft_national_id.equals(natIddft))	
							{
							errMsg	= natIdPrompt+"/"+altId1Desc;								
							}	
						if(!natId.equals("") && altId1.equals("") && dft_national_id.equals(natIddft))		
							{
							errMsg	= altId1Desc+"/"+altId2Desc;									
							}
						if(!natId.equals("") && altId1.equals("") && !dft_national_id.equals(natIddft))		
							{
							errMsg	= altId1Desc;									
							}
							//newly added
						if(natId.equals("")  && natIddft.equals("")   && altId1.equals("") && dft_national_id.equals(natIddft))	
							{
							errMsg	= natIdPrompt+"/"+altId1Desc+"/"+altId2Desc;									
							}	
						if(natId.equals("")  && !natIddft.equals("")   && altId1.equals("") && dft_national_id.equals(natIddft))	
							{
							errMsg	= altId1Desc+"/"+altId2Desc;									
							}		
						}

					}
				else if(citizen_yn.equals("N"))
					{
					if(visa_type.equals("V"))
						{
						if(altId1.equals("") && !altId2.equals(""))
							{
							errMsg	= altId1Desc;	
							}	
						if(!altId1.equals("") && altId2.equals(""))
							{
							errMsg	= altId2Desc;	
							}		
						if(altId1.equals("") && altId2.equals(""))
							{
							errMsg	= altId1Desc+"/"+altId2Desc;		
							}
															
						}														
					} 	
				
				}
			}
			if(!errMsg.equals("")){
				out.println("async function toHoldShowModal5(){");
				out.println("var message= getMessage('NATID_ALTID_NOT_AVAILABLE_UPDATE','MP'); message = message.replace('#','"+errMsg+"');");
				out.println("if(confirm(message)){");
					out.println("var dialogTop   = '65'");
					out.println("var dialogHeight    = '90vh'");
					out.println("var dialogWidth = '90vw'");
					out.println("var features  = 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';status=no; scroll=no'");
					out.println("var arguments = ''"); 
					out.println("var retVal = '';");
					out.println("var url='../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=N&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&Patient_ID="+patient_id+"';");
					out.println("retVal = await top.window.showModalDialog(url,arguments,features);");
					out.println("if(retVal){");
						out.println("if( retVal != null || retVal.length != 0)");
						out.println("parent.close();");
						out.println("parent.frames[1].frames[1].document.forms[0].srch_code.disabled=false;");
						out.println("parent.frames[1].frames[1].document.forms[0].srch_code.click();");
						out.println("parent.frames[1].frames[1].document.forms[0].srch_code.disabled=true;");
						out.println("}else{");
						out.println("parent.frames[0].document.getElementById('reset').click();");
						out.println("}");
					out.println("}else{");
					out.println("parent.frames[0].document.getElementById('reset').click();");
					out.println("}} toHoldShowModal5();");
					alert_yn	= 'N';
					continue_yn = "N";
					valid_patient_id = "";
			}else{
				alert_yn = 'Y';
			}

			if(alert_yn == 'N') {
				alt_status = "";
				in_pat_status="";
			}
		}
	   
	 /*Added by Dharma on 24th Apr 2019 against MMS-DM-CRF-0152.1 End*/   

		/*Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1*/
		if(isCountryRegionValAppl && alert_yn != 'N'){

			JSONObject SMSiteJSONObj = new JSONObject();
			SMSiteJSONObj = eSM.SMCommonBean.getSMSiteParamDetails(con);
			String region_prompt = (String)SMSiteJSONObj.get("region_prompt");

			JSONObject MPParamJSONObj = new JSONObject();
			MPParamJSONObj = eMP.MPCommonBean.getMPAuditTrailDetails(con);
			String country_reqd_yn = (String)MPParamJSONObj.get("country_reqd_yn");
			String region_reqd_yn = (String)MPParamJSONObj.get("region_reqd_yn");

			JSONObject PatAddrJSONObj = new JSONObject();
			PatAddrJSONObj = eMP.MPCommonBean.getMPPatContactDetails(con,patient_id);
			String country_code = (String)PatAddrJSONObj.get("country_code");	
			String region_code = (String)PatAddrJSONObj.get("region_code");

			String dispMsg = "";

			if(country_code.equals("") || region_code.equals(""))
			{
				if(country_reqd_yn.equals("Y") && region_reqd_yn.equals("N") && country_code.equals(""))
				{
					dispMsg = "Y";
					out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#',getLabel('Common.country.label','Common'));");
				}
				else if(country_reqd_yn.equals("N") && region_reqd_yn.equals("Y") && region_code.equals(""))
				{
					dispMsg = "Y";
					out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#','"+region_prompt+"');");
				}
				else if(country_reqd_yn.equals("Y") && region_reqd_yn.equals("Y"))
				{
					if(country_code.equals("") && region_code.equals(""))
					{
						dispMsg = "Y";
						out.println("var cr_prompt = getLabel('Common.country.label','Common')+' '+getLabel('Common.and.label','Common')+' '+'"+region_prompt+"';");
						out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#',cr_prompt);");
					}
					else if(country_code.equals("") && !region_code.equals(""))
					{
						dispMsg = "Y";
						out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#',getLabel('Common.country.label','Common'));");
					}
					else if(!country_code.equals("") && region_code.equals(""))
					{
						dispMsg = "Y";
						out.println("var message = getMessage('MAND_VALIDATION_TRANS','MP'); message = message.replace('#','"+region_prompt+"');");
					}
				}else
				{
					dispMsg = "";
				}
			}

			if(!dispMsg.equals("")){
				out.println("async function toHoldShowModal6(){");
				out.println("if(confirm(message)){");
					out.println("var dialogTop   = '65'");
					out.println("var dialogHeight    = '44'");
					out.println("var dialogWidth = '65'");
					out.println("var features  = 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';status=no; scroll=no'");
					out.println("var arguments = ''"); 
					out.println("var retVal = '';");
					out.println("var url='../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=N&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&load_tab=CONTACT_ADDR_TAB&Patient_ID="+patient_id+"';");
					out.println("retVal = await top.window.showModalDialog(url,arguments,features);");
					out.println("if(retVal){");
						out.println("if( retVal != null || retVal.length != 0)");
						out.println("parent.close();");
						out.println("parent.frames[1].frames[1].document.forms[0].srch_code.disabled=false;");
						out.println("parent.frames[1].frames[1].document.forms[0].srch_code.click();");
						out.println("parent.frames[1].frames[1].document.forms[0].srch_code.disabled=true;");
						out.println("}else{");
						out.println("parent.frames[0].document.getElementById('reset').click();");
						out.println("}");
					out.println("}else{");
					out.println("parent.frames[0].document.getElementById('reset').click();");
					out.println("}} toHoldShowModal6();");
					alert_yn	= 'N';
					continue_yn = "N";
					valid_patient_id = "";
			}else{
				alert_yn = 'Y';
			}

			if(alert_yn == 'N') {
				alt_status = "";
				in_pat_status="";
			}
		}
		/*End AAKH-CRF-0128.1*/

		/*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
		if(isNationalIdValidationAppl && alert_yn != 'N')
		{
			JSONObject valJSONObj	= new JSONObject();
			valJSONObj				= eMP.MPCommonBean.getNationalIdValidationYN(con, patient_id, fac_id, "OP");
			String validate_yn		= (String)valJSONObj.get("validate_yn");
			String national_id		= (String)valJSONObj.get("national_id");
			String chk_citizen_yn	= (String)valJSONObj.get("citizen_yn");

			if(validate_yn.equals("Y") && national_id.equals("") && chk_citizen_yn.equals("Y"))
			{		
				out.println("alert(getMessage('VALIDATE_NATIONAL_ID','MP'))");

				alert_yn = 'N';  
				continue_yn = "N";
				valid_patient_id = "";
					
				out.println("parent.frames[0].document.getElementById('reset').click();");	
			}else
			{
				alert_yn = 'Y';
			}

			if(alert_yn == 'N')
			{
				alt_status = "";
				in_pat_status = "";
			}
		}
		/*End MO-CRF-20148*/
		
		
		//if(isUHID_valid_appl && bl_install_yn.equals("Y") && alert_yn != 'N'  )
		if(isUHID_valid_appl && bl_install_yn.equals("Y") && alert_yn != 'N'  )
		{
							String UHIDValidCount = "0";
							String UHIDValidCount_tmp = "";
							String pat_ser_grp_code = "";
					try{
							
							
						 UHIDValidCount_tmp	= eMP.MPCommonBean.getUHIDValidCount(con,patient_id,fac_id);
						 
						String arr_temp[] = UHIDValidCount_tmp.split("~~");
						UHIDValidCount = arr_temp[0];
						if(arr_temp.length>1)
							pat_ser_grp_code = arr_temp[1];
						
						
						
						if(UHIDValidCount.equals("0"))
						{
							
							 
							 
					out.println("if(confirm(getMessage('UHID_EXPIRED','MP'))){	");
					out.println("var check = blUHIDBillchk('"+patient_id+"','VISIT_REGISTRATION','OP','"+pat_ser_grp_code+"');");
					
					out.println("if(check == 'Y'){");
					out.println("parent.frames[1].frames[1].document.forms[0].srch_code.disabled=false;");
					out.println("parent.frames[1].frames[1].document.forms[0].srch_code.click();");
					out.println("parent.frames[1].frames[1].document.forms[0].srch_code.disabled=true;");
					out.println("}else{");
					 alert_yn = 'N';  continue_yn = "N";
					valid_patient_id="";
					out.println("parent.frames[0].document.getElementById('reset').click();");
					
					out.println("}");
					
					out.println("}else{");
					 alert_yn = 'N';  continue_yn = "N";
					valid_patient_id="";
					out.println("parent.frames[0].document.getElementById('reset').click();");
					out.println("}");	 
						
						}
						else
						{
							 
							
							 
						}
						
							}
							catch(Exception e1) {
										e1.printStackTrace();
								 } 
								 
								 
							
				
			if(alert_yn == 'N')
			{
					alt_status = "";
					in_pat_status="";
					
			}
				
			
		}
		
		
		
		
		
		
		
		
		if(in_pat_status.equals("CURRENTLY_IN_PATIENT"))
		{
		 if(visit_for_inpat_yn.equals("Y")){
		     out.println("alert(parent.frames[1].frames[1].getMessage('CURRENTLY_IN_PATIENT','COMMON'));");
		 }
		 else{
			 out.println("alert(parent.frames[1].frames[1].getMessage('VIS_REGN_NOT_ALLOWED_FOR_CURR_INPAT','OP'));");
			 alert_yn = 'N';  continue_yn = "N";
			 valid_patient_id="";
			 out.println("parent.frames[0].document.getElementById('reset').click();");
		 }
		}
		// added by mujafar for AMRI-CRF-0357
		
	} 
      // char alt_stat =alert_yn ;
	  out.println("var contyn='Y';");
	  HcExpired = "N";
		
	  if(!alt_status.equals(""))
	  {
		char val=alt_status.charAt(0);
		if(val == 'W')
		{
			String val1=alt_status.substring(2,alt_status.length());
			out.println("contyn = confirm(\""+val1+"\");  if(!contyn) setValue();");
			//valid_patient_id="";
		}else if(val =='C')
		{			
			String val1=alt_status.substring(1,alt_status.length());
			out.println("alert(\""+val1+"\");setValue();");
			//valid_patient_id="";
		}else 
		{
			String val1=alt_status.substring(2,alt_status.length());
			out.println("alert(\""+val1+"\");");
		}
	  }
	  
	  
	
  
	//if((!valid_patient_id.equals(""))&&fromPatidF1.equals(""))
		/* Modified By Dharma for Non-Citizen Validation on 30th Dec 2013*/
		if((!valid_patient_id.equals(""))&&fromPatidF1.equals("") && result_pr_enc_ref_man.equals("Y") && isPatDispChk.equals(""))
		
	 {//out.println("parent.frames[1].frames[2].location.href='../../eCommon/jsp/patLine.jsp?Patient_Id="+valid_patient_id+"'");
	 	// lnk Inc: 48147 - Assigning patient id to the respective[pat_id1] field.
		
		/*below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] */
	
		out.println("if(contyn){parent.frames[1].frames[1].document.forms[0].pat_id1.value='"+patient_id+"'; parent.frames[1].frames[3].document.location.href=\"../../eOP/jsp/VisitRegistrationResult.jsp?emer_regn_allow_yn="+emer_regn_allow_yn+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&visit_for_inpat_yn="+visit_for_inpat_yn+"&register_visit_walkin="+register_visit_walkin+"&register_visit_referral"+register_visit_referral+"&oa_install_yn="+oa_install_yn+"&or_install_yn="+or_install_yn+"&build_episode_rule="+build_episode_rule+"&oper_stn_id="+oper_stn_id+"&upt_contact_dtls_oa_yn="+upt_contact_dtls_oa_yn+"&bl_interface_yn="+bl_install_yn+"&nat_id_prompt="+nat_id_prompt+"&functionId="+functionId+"&patient="+patient_id+"&query_String="+java.net.URLEncoder.encode(queryString,"UTF-8")+"\";parent.frames[1].frames[4].document.location.href=\"../../eOP/jsp/VisitRegistrationApptRecds.jsp?emer_regn_allow_yn="+emer_regn_allow_yn+"&visit_for_inpat_yn="+visit_for_inpat_yn+"&register_visit_walkin="+register_visit_walkin+"&register_visit_referral"+register_visit_referral+"&oa_install_yn="+oa_install_yn+"&or_install_yn="+or_install_yn+"&build_episode_rule="+build_episode_rule+"&oper_stn_id="+oper_stn_id+"&bl_interface_yn="+bl_install_yn+"&nat_id_prompt="+nat_id_prompt+"&function_id="+functionId+"&patient_id="+patient_id+"&query_String="+java.net.URLEncoder.encode(queryString,"UTF-8")+"\"} else{ parent.frames[1].frames[3].document.location.href=\"../../eCommon/html/blank.html"+"\"}");
			
				
				}
	
    }
    catch (Exception ce){try{out.println("check_patient_id:"+ce);}catch(Exception e){e.printStackTrace();}}
  
  
  //if(!valid_patient_id.equals(""))
	  /* Modified By Dharma for Non-Citizen Validation on 30th Dec 2013*/
	 if(!valid_patient_id.equals("") && result_pr_enc_ref_man.equals("Y")) 
		{
		return true;
		}else{
		return false;
		}
  
  }%>
<%!
//Added for the CRF - Bru-HIMS-CRF-0198
void checkMultipleSpeciality(javax.servlet.jsp.JspWriter out,Connection con,String facility_id,String clinic_code,String frame_list1){
	PreparedStatement pstmt=null; 
	ResultSet rs=null;	 
	String practitioner_id="";
	String practitioner_name="";
	String sql="";
	try{
	sql = "select PRACTITIONER_ID,PRACTITIONER_NAME from op_clinic a,am_practitioner b where a.MULTI_SPECIALITY_YN='Y' and a.SPECIALITY_CODE=b.PRIMARY_SPECIALITY_CODE and a.facility_id=? and a.clinic_code=? ";    
	  
	  
     pstmt   = con.prepareStatement(sql);
	 pstmt.setString(1,facility_id);
	 pstmt.setString(2,clinic_code);
     rs  = pstmt.executeQuery();             
     if( rs != null && rs.next()){ 
    	 practitioner_id=rs.getString("PRACTITIONER_ID");
    	 practitioner_name=rs.getString("PRACTITIONER_NAME");
     }
     if(practitioner_id!=null && !practitioner_id.equals("")){
	     out.println(frame_list1+"forms[0].pract_name.value='"+practitioner_name+"';");
	     out.println(frame_list1+"forms[0].pract_name.disabled=true;");
	     out.println("if("+frame_list1+"forms[0].pract_butt){"+frame_list1+"forms[0].pract_butt.disabled=true;}");
	     out.println(frame_list1+"forms[0].attend_practitioner_id.value='"+practitioner_id+"';");
     }
     
	}catch(Exception e){
		e.printStackTrace();
	}
}
%>

var alternate_id_cont_yn = "Y";
function setValue()
{   
	

	alternate_id_cont_yn = "N";
parent.frames[1].frames[1].document.forms[0].clear1.click();
}

 </script>	

</form>
</body>
</html>


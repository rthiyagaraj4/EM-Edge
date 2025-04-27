<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
  <head>
    <!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%   
	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script><!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 21st Nov 2013-->
	
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
   <!--  <Script src="../../eMP/js/PatientRegistration.js" language="JavaScript"></Script>  -->
    <Script src="../../eOP/js/ReviseVisit.js" language="JavaScript"></Script>
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eOP/js/OPPractitionerComponent.js'></script>
	<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
    <script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>   
    <script language="javascript" src="../../eOP/js/Checkblockscheduleforpract.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013-->
     
<%

 Connection con=null;
 PreparedStatement pstmt=null;
 PreparedStatement pstmt1= null;
 ResultSet rs1 = null;
try{     request.setCharacterEncoding("UTF-8");
    String episodeReqd ="";      
    boolean isQMSapplicable=false;
    String appt_case            = "";   
    String q_appt_ref_no        = "";   
    String userid               = (String) session.getValue("login_user");   
	String locale = (String) session.getValue("LOCALE");
    String l_encounter_id       = "";    
    String patient_id       ="";
    String locn_desc        ="";
    String locn_type_desc       ="";
    String service_desc         ="";
    String pract_name       ="";
    String visit_type_desc      ="";
    String cur_locn_code        ="";
    String cur_locn_type        ="";
    String cur_room_num		="";
    String cur_service_code     ="";
    String cur_pract_type       = "";
	String cur_pract_type_desc  = "";
    String cur_visit_type_ind   = "";
	String visit_desc       = "";
    String care_locn_type_ind   = "";
    String p_clinic_code        = "";
    String p_clinic_type        = "";
    String p_clinic_type_code   = "";
    String p_clinic_desc        = "";
	String p_open_to_all_pract_yn = "";
    String constr               = "";
    String p_gender             = "";
    String p_dob                = "";
    String p_visit_type_short_desc  = "";
    String p_visit_type_code    = ""; 
    String p_cur_practitioner_id    = "";
    String p_cur_open_to_all_pract_yn = "";
    String p_cur_visit_type_code    = "";
    String subservice_code      = "";
	String subservice_desc      = "";
    String cur_specialty_code   = "";   
	String episode_id       = "";
	String last_visit_num       = "";       
	String visit_case       = "";     
	String asn_visit_type_ind_desc  = "";		
	String visit_type_code      = "";
	String allow_referral_yn      = "";
	String disableReferral      = "";
	
	String asn_care_locn_type   = "";
	String contact_reason_code  = "";		
	String revise_reason_code="";		
	String visit_adm_date_time = null;
	String roomnum="";
	/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	String room_desc="";
	/*CRF end SS-CRF-0010 [IN034516]*/
	String p_speciality_code="";
	String visit_adm_type_ind="";
	String entitlement_by_pat_cat_yn = "";

	//Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	String other_reason_remarks = "";
	String others_id = "";
	String revise_visit_remarks = "";
	
	String sql="";
	String resource_class="";
	String resource_type="";
	String subServiceSQL = null;
	String subService = "";
	String subServiceCode = "";	
	String practitionerMandatory = null;
	String APPT_OR_WALK_IN_IND = "";
	ResultSet subServiceResult = null;
	PreparedStatement subServiceStatement = null;
	String referral_id="";
    String referral_details="";
    StringBuffer locsql=new StringBuffer();
	String 	  oper_id =request.getParameter("oper_id")==null?"":request.getParameter("oper_id");
	l_encounter_id      = request.getParameter("encounter_id");
	String facilityid   = (String) session.getValue("facility_id");
	String queue_status=request.getParameter("QStatus");
	 if(queue_status == null) queue_status="";
	String status=request.getParameter("status");
	 if(status == null) status="";
	 String disableFields = "";
	 if(status.equals("04")){
		 disableFields = "disabled";
	 }
	String arrive_date_time=request.getParameter("ArriveDTime");
	 if(arrive_date_time == null) arrive_date_time="";
	String vital_signs_date_time=request.getParameter("VitalDTime");
	 if(vital_signs_date_time == null) vital_signs_date_time="";
	con      = ConnectionManager.getConnection(request);
	
	String queue_num = request.getParameter("queue_num");	
	if(queue_num == null) queue_num="0";
	String other_res_class="";
	String other_res_id="";
	String other_res_desc="";
	String res_class_desc="";
	String res_tot="";
	String appt_walk_ind="";
	String queue_id="";
	String disableRoom = "";
  
	   ResultSet rs=null;     
       String record ="N";
       String bl_interface_yn = request.getParameter("bl_interfaced_yn");	
       String assign_q_num_by = request.getParameter("assign_queue_num_by");	
       String queue_date = request.getParameter("sys_date");		   
	   //For Billing
	   String bl_install_yn = (String) session.getValue("bl_operational");	
	   String action_on_pract_schedule	= "N";// Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013
	   String Sysdate	= "";// Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013

	   /*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		HashMap hashdata	= eCommon.Common.CommonBean.getSiteSpecificDetails(con, "OA","REMARKS_FOR_OTHERS");
		others_id	= (String)hashdata.get("value1");
		if(others_id == null) others_id = "";
		/*End ML-MMOH-CRF-1114*/
		
		isQMSapplicable=eCommon.Common.CommonBean.isSiteSpecific(con,"OP","EXT_QUEUE_NO");
		
		//Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11
		Boolean isInvokeUploadDocAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"MP","INVOKE_UPLOAD_DOCUMENT");

	  //String sql_new="SELECT A.patient_id patient_id ,TO_CHAR(A.QUEUE_DATE,'dd/mm/yyyy hh24:mi') visit_adm_date_time  ,decode(A.APPT_OR_WALK_IN_IND, 'A', 'Y', 'N') appt_case_yn , A.APPT_OR_WALK_IN_IND APPT_OR_WALK_IN_IND , A.appt_id appt_id ,A.SPECIALITY_CODE specialty_code ,null patient_type ,A.referral_id referral_id, A.episode_id episode_id ,A.OP_EPISODE_VISIT_NUM OP_EPISODE_VISIT_NUM ,B.SEX gender ,TO_CHAR(b.DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH, d.long_desc LOCN_DESC , A.locn_type ASSIGN_CARE_LOCN_TYPE  ,AM_GET_DESC.AM_CARE_LOCN_TYPE(A.LOCN_TYPE,'"+locale+"','2') LOCN_TYPE_DESC   ,am_get_desc.AM_SERVICE(A.SERVICE_CODE,'"+locale+"',2) service_desc ,DECODE (A.LOCN_TYPE,'N', NULL, d.open_to_all_pract_yn) cur_open_to_all_pract_yn ,op_get_desc.op_visit_type(a.facility_id,a.VISIT_TYPE_CODE,'"+locale+"',2) visit_type_desc  ,NULL  RESCLASS , c.pract_type  RESTYPE ,A.LOCN_CODE CUR_LOCN_CODE ,A.LOCN_TYPE CUR_LOCN_TYPE ,A.SERVICE_CODE CUR_SERVICE_CODE , A.PRACTITIONER_ID CUR_PRACTITIONER_ID, c.practitioner_name pract_name ,c.pract_type CUR_PRACT_TYPE , am_get_desc.am_pract_type(c.pract_type,'"+locale+"',2)  PRACT_TYPE_DESC , d.level_of_care_ind CUR_LEVEL_OF_CARE_IND, A.VISIT_TYPE_CODE VISIT_TYPE_CODE ,decode(A.APPT_OR_WALK_IN_IND, 'A', 'Y', 'N') VISIT_CASE  ,A.VISIT_TYPE_IND CUR_VISIT_TYPE_IND ,op_get_desc.op_visit_type(a.facility_id,a.visit_type_code,'"+locale+"',2) VISIT_DESC  ,A.VISIT_TYPE_code P_CUR_VISIT_TYPE_CODE, A.SUBSERVICE_CODE SUBSERVICE_CODE  ,am_get_desc.am_subService(a.service_code,a.subservice_code,'"+locale+"',2) SUBSERVICE_DESC, A.ROOM_NUM ROOM_NUM ,A.REVISE_REASON_CODE REVISE_REASON_CODE , A.CONTACT_REASON_CODE CONTACT_REASON_CODE  , am_get_desc.am_contact_reason(a.contact_reason_code,'"+locale+"',1) REASON_FOR_CONTACT  ,A.OTHER_RES_CLASS OTHER_RES_CLASS , A.OTHER_RESOURCE_ID OTHER_RESOURCE_ID , am_get_desc.AM_RESOURCE(a.facility_id,a.other_resource_id,'"+locale+"',2)  other_resource_desc, A.QUEUE_ID QUEUE_ID, d.primary_resource_class, d.ident_at_checkin, d.allow_referral_yn, (select entitlement_by_pat_cat_yn from mp_param where module_id = 'MP') entitlement_by_pat_cat_yn FROM OP_PATIENT_QUEUE A, MP_PATIENT B, am_practitioner_lang_vw C, op_clinic d WHERE A.FACILITY_ID = '"+facilityid+"'  AND A.ENCOUNTER_ID = '"+l_encounter_id+"' AND A.PATIENT_CLASS = 'OP' AND a.patient_id = b.patient_id AND d.clinic_code = a.locn_code and d.facility_id = a.facility_id and  C.practitioner_id(+)=A.practitioner_id and c.language_id (+)= '"+locale+"'";  	  
		
	  // Modified for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013
	  //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	  String sql_new="SELECT (select action_on_pract_schedule from op_param where OPERATING_FACILITY_ID='"+facilityid+"' ) action_on_pract_schedule,TO_CHAR(SYSDATE,'dd/mm/yyyy') Sys_date,A.patient_id patient_id ,TO_CHAR(A.QUEUE_DATE,'dd/mm/yyyy hh24:mi') visit_adm_date_time  ,decode(A.APPT_OR_WALK_IN_IND, 'A', 'Y', 'N') appt_case_yn , A.APPT_OR_WALK_IN_IND APPT_OR_WALK_IN_IND , A.appt_id appt_id ,A.SPECIALITY_CODE specialty_code ,null patient_type ,A.referral_id referral_id, A.episode_id episode_id ,A.OP_EPISODE_VISIT_NUM OP_EPISODE_VISIT_NUM ,B.SEX gender ,TO_CHAR(b.DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH, d.long_desc LOCN_DESC , A.locn_type ASSIGN_CARE_LOCN_TYPE  ,AM_GET_DESC.AM_CARE_LOCN_TYPE(A.LOCN_TYPE,'"+locale+"','2') LOCN_TYPE_DESC   ,am_get_desc.AM_SERVICE(A.SERVICE_CODE,'"+locale+"',2) service_desc ,DECODE (A.LOCN_TYPE,'N', NULL, d.open_to_all_pract_yn) cur_open_to_all_pract_yn ,op_get_desc.op_visit_type(a.facility_id,a.VISIT_TYPE_CODE,'"+locale+"',2) visit_type_desc  ,NULL  RESCLASS , c.pract_type  RESTYPE ,A.LOCN_CODE CUR_LOCN_CODE ,A.LOCN_TYPE CUR_LOCN_TYPE ,A.SERVICE_CODE CUR_SERVICE_CODE , A.PRACTITIONER_ID CUR_PRACTITIONER_ID, c.practitioner_name pract_name ,c.pract_type CUR_PRACT_TYPE , am_get_desc.am_pract_type(c.pract_type,'"+locale+"',2)  PRACT_TYPE_DESC , d.level_of_care_ind CUR_LEVEL_OF_CARE_IND, A.VISIT_TYPE_CODE VISIT_TYPE_CODE ,decode(A.APPT_OR_WALK_IN_IND, 'A', 'Y', 'N') VISIT_CASE  ,A.VISIT_TYPE_IND CUR_VISIT_TYPE_IND ,op_get_desc.op_visit_type(a.facility_id,a.visit_type_code,'"+locale+"',2) VISIT_DESC  ,A.VISIT_TYPE_code P_CUR_VISIT_TYPE_CODE, A.SUBSERVICE_CODE SUBSERVICE_CODE  ,am_get_desc.am_subService(a.service_code,a.subservice_code,'"+locale+"',2) SUBSERVICE_DESC, A.ROOM_NUM ROOM_NUM ,A.REVISE_REASON_CODE REVISE_REASON_CODE , A.CONTACT_REASON_CODE CONTACT_REASON_CODE  , am_get_desc.am_contact_reason(a.contact_reason_code,'"+locale+"',1) REASON_FOR_CONTACT  ,A.OTHER_RES_CLASS OTHER_RES_CLASS , A.OTHER_RESOURCE_ID OTHER_RESOURCE_ID , am_get_desc.AM_RESOURCE(a.facility_id,a.other_resource_id,'"+locale+"',2)  other_resource_desc, A.QUEUE_ID QUEUE_ID, d.primary_resource_class, d.ident_at_checkin, d.allow_referral_yn, (select entitlement_by_pat_cat_yn from mp_param where module_id = 'MP') entitlement_by_pat_cat_yn, A.other_reason_remarks, A.revise_visit_remarks FROM OP_PATIENT_QUEUE A, MP_PATIENT B, am_practitioner_lang_vw C, op_clinic d WHERE A.FACILITY_ID = '"+facilityid+"'  AND A.ENCOUNTER_ID = '"+l_encounter_id+"' AND A.PATIENT_CLASS = 'OP' AND a.patient_id = b.patient_id AND d.clinic_code = a.locn_code and d.facility_id = a.facility_id and  C.practitioner_id(+)=A.practitioner_id and c.language_id (+)= '"+locale+"'";
	  pstmt= con.prepareStatement(sql_new);
	  rs= pstmt.executeQuery();
	
	  if(rs!=null && rs.next())
      {
         //while(rs.next())
         //{		    
        	 	action_on_pract_schedule	= rs.getString("action_on_pract_schedule");// Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013
        	 	Sysdate						= rs.getString("Sys_date");// Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013
        	 	visit_adm_date_time = rs.getString("visit_adm_date_time");
				if(visit_adm_date_time == null) visit_adm_date_time="";
				appt_case = rs.getString("appt_case_yn") ;
				 if(appt_case ==null) appt_case="";
				 
				 q_appt_ref_no = rs.getString("appt_id");
				  if(q_appt_ref_no == null) q_appt_ref_no = ""; 
				 
				 patient_id = rs.getString("patient_id");
				 if(patient_id == null) patient_id= "";     
												  
				 cur_specialty_code = rs.getString("specialty_code");
				 if(cur_specialty_code  == null ) cur_specialty_code = "";
			 
				referral_id = rs.getString("referral_id");

				APPT_OR_WALK_IN_IND = rs.getString("APPT_OR_WALK_IN_IND");
				
				if(referral_id == null) referral_id="";
                /*Below line commeneted and added for this incident [60902]*/
				/*if(!(referral_id.equals("") && q_appt_ref_no.equals("")))
					appt_walk_ind="A";
				else if(!referral_id.equals(""))
					appt_walk_ind="R";
				else
					appt_walk_ind=APPT_OR_WALK_IN_IND;*/
					
			    if(!q_appt_ref_no.equals("")){
					appt_walk_ind="A";
				}else if(!referral_id.equals("")){
					appt_walk_ind="R";
				}else{
					appt_walk_ind=APPT_OR_WALK_IN_IND;	
                }
                //End this incident [60902]				
 
				episode_id = rs.getString("episode_id");
                last_visit_num = rs.getString("OP_EPISODE_VISIT_NUM");

				p_gender    =   rs.getString("gender");
				p_dob       =   rs.getString("DATE_OF_BIRTH");
			//
            locn_desc   = rs.getString("LOCN_DESC");  
			   
            locn_type_desc  = rs.getString("locn_type_desc");
			if(locn_type_desc.equals("C"))
				locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			else if(locn_type_desc.equals("E"))
				locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
			else if(locn_type_desc.equals("D"))
				locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
            else if(locn_type_desc == null) locn_type_desc = "";

			            
            cur_service_code = rs.getString("cur_service_code");
		    if(cur_service_code == null ) cur_service_code = "";
            
            service_desc    = rs.getString("service_desc");
            if(service_desc == null) service_desc = "";         
            
            subservice_desc    = rs.getString("subservice_desc");
            if(subservice_desc == null) subservice_desc = "";         

            pract_name  = rs.getString("pract_name");
            if(pract_name == null) pract_name = "";
            
            visit_type_desc = rs.getString("visit_type_desc");   
            if(visit_type_desc == null) visit_type_desc = "";
            
            cur_locn_code   = rs.getString("cur_locn_code");
			
		    if(cur_locn_code == null) cur_locn_code = "";
            
            cur_locn_type   = rs.getString("cur_locn_type");
		    if(cur_locn_type == null) cur_locn_type = "";

			asn_care_locn_type= cur_locn_type;
            
            cur_room_num=rs.getString("room_num");
            if(cur_room_num == null) cur_room_num="";
             
            cur_pract_type     = rs.getString("cur_pract_type");
		    if((cur_pract_type == null) || (cur_pract_type.equals("?"))) cur_pract_type = ""; 
			
		    cur_pract_type_desc     = rs.getString("pract_type_desc");
            if(cur_pract_type_desc == null) cur_pract_type_desc = "";

			cur_visit_type_ind = rs.getString("cur_visit_type_ind");
            if(cur_visit_type_ind == null) cur_visit_type_ind = "";
            
            visit_adm_type_ind=cur_visit_type_ind;

			visit_desc     = rs.getString("visit_desc");
            if(visit_desc == null) visit_desc = "";
            
            visit_type_code =  rs.getString("visit_type_code");
             if(visit_type_code == null) visit_type_code = "";         
           
			care_locn_type_ind=cur_locn_type;
			resource_class=rs.getString("resclass");
			if(resource_class == null) resource_class="";
			
			resource_type=rs.getString("restype");
			if(resource_type == null) resource_type="";

			if(resource_type == null) resource_type="";		

			other_res_class=rs.getString("OTHER_RES_CLASS");
			if(other_res_class == null) other_res_class="";

			other_res_id=rs.getString("other_resource_id");
			if(other_res_id == null) other_res_id="";

			if(other_res_class.equals("E"))
			res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			else if(other_res_class.equals("O"))
		   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");

			other_res_desc=rs.getString("OTHER_RESOURCE_DESC");
			if(other_res_desc == null) other_res_desc="";

			if(!other_res_id.equals(""))
				res_tot=res_class_desc+"/"+other_res_desc;
			else
				res_tot=res_class_desc;

			queue_id=rs.getString("QUEUE_ID");
			if(queue_id == null) queue_id="";
            
            p_cur_practitioner_id = rs.getString("cur_practitioner_id");
             if(p_cur_practitioner_id == null) p_cur_practitioner_id ="";
             
            p_cur_open_to_all_pract_yn = rs.getString("cur_open_to_all_pract_yn");			
             if(p_cur_open_to_all_pract_yn == null) p_cur_open_to_all_pract_yn ="";
             
            p_cur_visit_type_code = rs.getString("p_cur_visit_type_code") ;
             if(p_cur_visit_type_code == null) p_cur_visit_type_code ="";             
            
             
	        subservice_code = rs.getString("subservice_code") ;
             if(subservice_code == null) subservice_code = "";
             
            visit_case = rs.getString("visit_case") ;
             if(visit_case == null) visit_case = "";            

			contact_reason_code = rs.getString("contact_reason_code");
					
    		if(contact_reason_code == null || contact_reason_code.equals("null")) 
				contact_reason_code = "";
			
			/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
			other_reason_remarks = rs.getString("other_reason_remarks");
    		if(other_reason_remarks == null || other_reason_remarks.equals("null")) 
			other_reason_remarks = "";

			revise_visit_remarks = rs.getString("revise_visit_remarks");
    		if(revise_visit_remarks == null || revise_visit_remarks.equals("null")) 
			revise_visit_remarks = "";
			/*End ML-MMOH-CRF-1114*/

			revise_reason_code=rs.getString("revise_reason_code");
			if(revise_reason_code == null || revise_reason_code.equals("null")) 
				revise_reason_code = "";
			
			resource_class = rs.getString("primary_resource_class");
			practitionerMandatory = rs.getString("ident_at_checkin");
			allow_referral_yn = rs.getString("allow_referral_yn");
			entitlement_by_pat_cat_yn = rs.getString("entitlement_by_pat_cat_yn");

			if(resource_class == null) resource_class="";
			if(allow_referral_yn == null) allow_referral_yn="";
			if(practitionerMandatory == null) practitionerMandatory="";
			if(entitlement_by_pat_cat_yn == null) entitlement_by_pat_cat_yn="";

         //}  
    }    
		

	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	String qms_interfaced_yn=eOP.QMSInterface.isClinicQMSInterfaced(cur_locn_code,facilityid,con);
	/* 
	   try
		{
		   pstmt=con.prepareStatement("select PRIMARY_RESOURCE_CLASS,IDENT_AT_CHECKIN,ALLOW_REFERRAL_YN from op_clinic where facility_id='"+facilityid+"' and clinic_code='"+cur_locn_code+"' ");
		   
		   rs=pstmt.executeQuery();
		   if(rs != null)
			{
			   if(rs.next())
				{
					resource_class=rs.getString(1);
					practitionerMandatory=rs.getString(2);
					allow_referral_yn=rs.getString(3);
					if(resource_class == null) resource_class="";
					if(allow_referral_yn == null) allow_referral_yn="";
				}
			}
			
		   if(rs != null) rs.close();
		   if(pstmt != null) pstmt.close();

		  
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	*/
		
	if(!allow_referral_yn.equals("Y"))
		disableReferral = "disabled";
   
	/** Populate the Visit adm type desc**/

    if(cur_visit_type_ind.equals("F"))
		asn_visit_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels");
	else if(cur_visit_type_ind.equals("L"))
		asn_visit_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels");
	else if(cur_visit_type_ind.equals("R"))
		asn_visit_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
	else if(cur_visit_type_ind.equals("E"))
		asn_visit_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
	else if(cur_visit_type_ind.equals("S"))
		asn_visit_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels");
	else if(cur_visit_type_ind.equals("C"))
		asn_visit_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels");

   if(!referral_id.equals(""))
     {
        //String from="FROM";
        String sql1 = "select  GET_REFERRAL_DETAIL_LINE('"+referral_id+"', 'FROM','"+locale+"') from dual " ;	
        String check="";
        Statement cs = null ;
		ResultSet csrs=null;
        try
         {
			cs = con.createStatement() ;
			csrs=cs.executeQuery(sql1) ;
			if(csrs!=null)
			{
				while(csrs.next())
				{
					check=csrs.getString(1).substring(0,13);
					if(check.equals("ORACLE__ERROR") || check.equals("NO_DATA_FOUND"))
					referral_details="";
					else referral_details=csrs.getString(1).substring(2,csrs.getString(1).length());

				}
                }
              
				if(csrs!=null)  csrs.close();
				if(cs != null)  cs.close() ;
			
			}
          catch(Exception e) { 
			  out.println("Exception in Stored proc="+e.toString());
			  e.printStackTrace();
			  }
           
        }
		
%>     

</head>
<!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
<body class='content' onload='FocusFirstElement();displayRemarksForOtherReason(document.forms[0].revise_reason_code);' onMouseDown="CodeArrest();"onKeyDown ='lockKey();' topmargin='0' bottommargin='0'  >
<form name='revise_visit_form' id='revise_visit_form' method='post' action='../../servlet/eOP.ReviseVisitServlet' target="messageFrame">

 <table border='0' cellpadding='2' cellspacing='0' width='97%' align='center'>
	<%       
	    if(!q_appt_ref_no.equals(""))
         {
	%>      <tr>  
			<td class='label' width='25%'><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
            <td class='QUERYDATA' colspan='3' width='75%'><%=q_appt_ref_no%></td>
			</tr>	
	<%	
         }
	%>       
          
          <tr>
             <td class='label' width='25%'><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></td>
             <td class='QUERYDATA' colspan='3' width='75%'><%= queue_status %>
             </td>             
          </tr>
        </table>       
       <%
      
	  if(referral_details!=null && !(referral_details.equals(""))) {
			%>
      <table border='0' cellpadding='0' cellspacing='0' width='97%' align='center'>
      <tr>	 
	  <td class='columnheader'><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></td>
      </tr>
      </table>
	  <table border='0' cellpadding='2' cellspacing='0' width='97%' align='center'>			
      <tr>
		<td class='querydata' colspan='4'>&nbsp;<%=referral_details%></td>
      </tr>
      </table>	 
      
		  <%
			 }
	     %>
    
		 <!-- Display the Encounter Details -->
		 
	   <table border='0' cellpadding='0' cellspacing='0' width='97%' align='center'>
         <tr>
		    <th align="left" class='columnheader'><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></th> 
         </tr>
       </table>       
       <table border='0' cellpadding='2' cellspacing='0' width='97%' align='center' name='revise_detailstab' id='revise_detailstab' >  
       <tr>
		  <td class='CAGROUPHEADING'>&nbsp;</td>	
		  <td class='CAGROUPHEADING'><fmt:message key="eOP.CurrentVisit.label" bundle="${op_labels}"/></td>
          <td class='CAGROUPHEADING'><fmt:message key="Common.ReviseVisit.label" bundle="${common_labels}"/></td>
		  <!--Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11-->
		  <%
		  int ins_count = eMP.MPCommonBean.getInsuranceCount(con,l_encounter_id,patient_id);
		  
		  if(isInvokeUploadDocAppl && ins_count > 0){%>
			<td class='CAGROUPHEADING' nowrap><a href="javascript:UploadDocument();"><b><fmt:message key="Common.UploadInsDoc.label" bundle="${common_labels}"/>&nbsp;</b></a></td>
		  <%}else{%>
			<td class='CAGROUPHEADING'>&nbsp;</td>
		  <%}%>
	   </tr>  
	   <tr>
          <td class= 'label' width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		  <td class='QUERYDATA' width='30%'><%=locn_desc%>/<%=locn_type_desc%></td>
    <%         
	
	try
	{
		
        locsql.append(" SELECT a.clinic_code ass_clinic_code, a.clinic_type ,c.short_desc ass_clinic_type,a.long_desc short_desc  , a.speciality_code ass_speciality_code,a.open_to_all_pract_yn open_to_all_pract_yn,a.pract_type pract_type,a.ident_at_checkin ident_at_checkin FROM op_clinic_lang_vw a,(SELECT day_no FROM sm_day_of_week WHERE day_of_week = RTRIM(TO_CHAR(SYSDATE,'DAY'))  ) b,am_care_locn_type_lang_vw c WHERE a.LANGUAGE_id='"+locale+"' AND c.language_id='"+locale+"' AND ");

		if(!appt_case.equals("Y") && q_appt_ref_no.equals(""))
		{
		locsql.append(" DECODE(b.day_no,'1',working_day_1,'2',working_day_2,'3',working_day_3,'4', working_day_4,'5',working_day_5,'6',working_day_6,'7',working_day_7)='Y' AND ");
		}

		locsql.append("level_of_care_ind = 'A' AND allow_visit_regn_yn='Y' AND eff_status='E' AND UPPER(clinic_type) IN (SELECT    locn_type FROM am_care_locn_type WHERE care_locn_type_ind='"+care_locn_type_ind+"') AND ((age_group_code IS NULL) OR (age_group_code IS NOT NULL)     AND EXISTS (SELECT age_group_code FROM am_age_group WHERE   age_group_code=a.age_group_code AND NVL(gender,'"+care_locn_type_ind+"') = '"+p_gender+"'      AND TO_DATE(TO_CHAR(SYSDATE,'dd/mm/yyyy'),'dd/mm/yyyy') - TO_DATE('"+p_dob+"','dd/mm/yyyy') BETWEEN DECODE(age_unit,'Y',365,'M',30,1)*min_age AND DECODE(age_unit,'Y',365,'M',30,1)*max_age AND eff_status='E')) AND facility_id = '"+facilityid+"' AND a.CLINIC_CODE IN (SELECT CLINIC_CODE FROM OP_CLINIC WHERE FACILITY_ID = '"+facilityid+"' AND SERVICE_CODE = '"+cur_service_code+"' UNION SELECT    CLINIC_CODE  FROM OP_CLINIC_FOR_SERVICE WHERE FACILITY_ID = '"+facilityid+"' AND SERVICE_CODE = '"+cur_service_code+"') AND c.locn_type = a.clinic_type   AND c.care_locn_type_ind = '"+care_locn_type_ind+"'  AND EXISTS (SELECT LOCN_CODE FROM AM_OS_USER_LOCN_ACCESS_VW WHERE FACILITY_ID = A.FACILITY_ID AND LOCN_CODE = A.CLINIC_CODE AND LOCN_TYPE=a.clinic_type and OPER_STN_ID = '"+oper_id+"' AND APPL_USER_ID = '"+userid+"' AND revise_visit_yn = 'Y') ORDER BY short_desc");
		
		pstmt = con.prepareStatement(locsql.toString());
		rs = pstmt.executeQuery();		
		 
        out.println("<td class='fields' width='20%'>" + "<select name='asn_locn_code' id='asn_locn_code' onChange='ChangeObj(this)' "+disableFields+" tabIndex='1'><option value='' >&nbsp;--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------"); //below width changes mano

        if (rs != null)
        {
            while (rs.next())
            {
                p_clinic_code      = rs.getString("ass_clinic_code");
                p_clinic_type      = rs.getString("ass_clinic_type");
                p_clinic_type_code = rs.getString("clinic_type");
                p_clinic_desc      = rs.getString("short_desc");
				p_open_to_all_pract_yn = rs.getString("open_to_all_pract_yn");
				p_speciality_code=rs.getString("ass_speciality_code");
				
				//practitionerMandatory = rs.getString("ident_at_checkin");

	            constr = p_clinic_code +"|"+p_clinic_type+"|"+p_clinic_type_code+"|"+p_open_to_all_pract_yn+"|"+p_speciality_code;

                if (p_clinic_code.equals(cur_locn_code))
                {
                    out.println("<option value='"+constr+"' selected>"+p_clinic_desc);
                   
                }
                else
                {
                    out.println("<option value='"+constr+"'>"+p_clinic_desc);
                }
				 
             }			
			 
			
			 
			    out.println("</select><img src='../../eCommon/images/mandatory.gif'></td>");
				
				
				if(!cur_room_num.equals("*ALL") && status.equals("04")) {
					disableRoom = "disabled";
				}
                				
				out.println("<td class='QUERYDATA' id='asn_care_locn_text' width='30%' nowrap>"+locn_type_desc+"</td></tr>"); //below changes mano
				//out.println("<tr><td colspan='4' nowrap>&nbsp;</td></tr>");
                /* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
				out.println("<tr><td class='label' nowrap width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels")+"</td>");
				/*CRF end SS-CRF-0010 [IN034516]*/
				
                out.println("<td width='30%'></td><td colspan=2 class='fields' id='room_value' width='45%' ><select name='Room_numsel' id='Room_numsel' onChange='setroomno()' tabIndex='2' "+disableRoom+"><option value=''>&nbsp;-------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --------&nbsp;");
				/* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
				sql="select a.practitioner_id ROOM_NO,am_get_desc.am_facility_room (a.facility_id, a.practitioner_id,'"+locale+"', 2) room_desc  from op_pract_for_clinic a where facility_id='"+facilityid+"' and clinic_code='"+cur_locn_code+"' and eff_status='E' and resource_class='R' order by practitioner_id";
				/*CRF end SS-CRF-0010 [IN034516]*/
				pstmt1 = con.prepareStatement(sql);
				rs1=pstmt1.executeQuery();
		
				boolean flagvalue=false;
				while(rs1.next())
				{flagvalue=true;
					roomnum=rs1.getString(1);
					/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
					room_desc=rs1.getString("room_desc");
					/*CRF end SS-CRF-0010 [IN034516]*/


				   /* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */				
					if(cur_room_num != "" && roomnum.equals(cur_room_num))
					{
					 out.println("<option value='"+roomnum+"' selected>"+roomnum+" "+room_desc);
					}	 
					else
					{
						out.println("<option value='"+roomnum+"' >"+roomnum+" "+room_desc);
					}	
                    /*CRF end SS-CRF-0010 [IN034516]*/					
				}
			
				if(flagvalue)
			{
				out.println("</select><img src='../../eCommon/images/mandatory.gif'>");
			}
			  else
			{
			cur_room_num="NoRoom";
			out.println("</select>");
			}
			  
			  
			
		if(rs1 != null) rs1.close();
		if(pstmt1 != null) pstmt1.close();
		
		}
       if(rs!=null)rs.close();
	   if(pstmt!=null) pstmt.close();
	   locsql.setLength(0);
	 }catch (Exception e)
				{
					e.printStackTrace();
				}
%>      
 </td></tr> 		
		<tr>
           <td class= 'label' width='25%'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
           <td class='QUERYDATA' nowrap width='30%'><%=visit_desc%>/<%=asn_visit_type_ind_desc%></td>
		   <td colspan=2 class='QUERYDATA' width='45%'><%=visit_desc%></td>      
    </tr>
<%-- Code added/modified by Tushar .T. Bhat on 17-Feb-04 --%>   	

<tr>   
	<td class= 'label'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
    <td class='QUERYDATA'><%=service_desc%></td>
    <td colspan=2 class='QUERYDATA'><%=service_desc%></td>
    </td>
</tr>	  
<tr>
    <!-- Populate the services  -->
		   <td class= 'label' nowrap ><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
           <td class='QUERYDATA' nowrap><%=subservice_desc%></td>
           <td class='QUERYDATA' colspan=2 ><select name='subService' id='subService' onChange='ChangeObj(this)' <%=disableFields%> tabIndex='5'>
		   <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp; 
		   
		   <%
			   //subServiceSQL = "select subservice_code, short_desc from am_subservice where service_code = ? and eff_status = 'E' order by 2";

			  			   subServiceSQL = "select subservice_code, short_desc from am_subservice_lang_vw where language_id='"+locale+"' and service_code = ? and eff_status = 'E' order by 2";

		   subServiceStatement = con.prepareStatement(subServiceSQL);
		   subServiceStatement.setString(1,cur_service_code);		   
		   subServiceResult = subServiceStatement.executeQuery();

		   
		   if(subServiceResult!=null)
		   {
			   while(subServiceResult.next())
			   {
				   subService = subServiceResult.getString("short_desc");
				   subServiceCode=subServiceResult.getString("subservice_code");
				   
				   if(subService!=null)
				   {
					   out.println("<option value = '"+subServiceCode+"' ");
					   if(subServiceCode.equals(subservice_code))
					      out.println("selected");

					   out.println(">"+subService);
				   }
			   }
		   }
		   
		   if(subServiceResult != null) subServiceResult.close();
		   if(subServiceStatement != null) subServiceStatement.close();%>

		   </select>
		   </td>
</tr>
<tr>
        <td class= 'label'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
        <td class='QUERYDATA' nowrap><%=pract_name%></td>
			  
		<%
		if(practitionerMandatory == null)
			practitionerMandatory = "X";

		
		String practitionerMandatoryGIFStatus = null;
		char identifyPractitionerAtCheckIn = 'Y';
		
		if(practitionerMandatory.equalsIgnoreCase("P")&& (!resource_class.equals("R")))
		{
			practitionerMandatoryGIFStatus = "visible";
			identifyPractitionerAtCheckIn = 'Y';
		}
		else
		{
			practitionerMandatoryGIFStatus = "hidden";
			identifyPractitionerAtCheckIn = 'N';
		}
			%>
		<td class='fields' colspan="2"><input type="text" name="pract_name" id="pract_name" maxlength="30" size="30" <%=disableFields%> value="<%=pract_name%>" onBlur="onBlurCallPractitionerSearch(document.getElementById('pract_butt'),pract_name)" tabIndex='4' ><input type="button" name="pract_butt" id="pract_butt" value="?" class="button" onClick="callPractSearchRevise(this,pract_name);" <%=disableFields%> ><img ALIGN = center src = "../../eCommon/images/mandatory.gif" style = 'visibility:<%=practitionerMandatoryGIFStatus%>' id = 'practitionerMandatoryGIF' ></img><input type="hidden" name="asn_pract_id" id="asn_pract_id" value="<%=p_cur_practitioner_id%>"></td>
	</tr>	
	<tr>
        <td class= 'label'><fmt:message key="eOP.OtherResource.label" bundle="${op_labels}"/></td>
        <td class='QUERYDATA' nowrap><%=res_tot%></td>
		<td class='fields' colspan="2"><select name='other_res_type' id='other_res_type' onChange='clearResourceVal(this);' <%=disableFields%>><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
		<%if(other_res_class.equals("E")){%>
		<option value='E' selected><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option><option value='O'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
		<%}else if(other_res_class.equals("O")){%>
		<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option><option value='O' selected><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
		<%}else{%>
		<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option><option value='O'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
		<%}%>
		</select>/<input type='text' name='other_res_txt' id='other_res_txt' maxlength='15' size='16' value='<%=other_res_desc%>' <%=disableFields%>><input type='button' class='button' name='other_res_butt' id='other_res_butt' value='?' <%=disableFields%> onClick='otherResourceLookUp(this,other_res_txt);'  >
		<input type='hidden' name='other_res_code' id='other_res_code' value='<%=other_res_id%>'></td>
	</tr>
	<tr><td class='label' ><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td>
	<td  class='Fields' colspan = "4">
	<input type='text' name='referal_id1' id='referal_id1' value='<%=referral_id%>' <%=disableReferral%> maxlength='20' size='25' onblur='searchReferral(this)'><input type='button' class='button' value='?' <%=disableReferral%> name='ref_id_search' onClick='getReferralID()'></td></tr>

 <!--   <tr>
           <td   class= 'label' nowrap><fmt:message key="eOP.NewEpisode.label" bundle="${op_labels}"/></td>
			<td  class='fields'  colspan=3>
			<input type = 'checkbox' value='Y' name='new_op_episode_yn' id='new_op_episode_yn' value="N" disabled checked onClick="new_episode_yn_func(this)" tabIndex='8'>
           </td>
		</tr>
		<tr><td colspan='4'>&nbsp;</td></tr>
		<tr>
        <td  align='left' class='label' nowrap><fmt:message key="eOP.EpisodeNoVisitNo.label" bundle="${op_labels}"/>                                    
           </td>           
           <td  class='fields'  class='QUERYDATA'  colspan=3 nowrap ><b>
                <input type="hidden" name='last_episode_no' id='last_episode_no' value='<%=episode_id%>'  size='12' maxlength='12' readOnly ><%=episode_id%>/<%=last_visit_num%>
          </td>           
           <input type="hidden" name='last_visit_no' id='last_visit_no' value='<%=last_visit_num%>'  size='12' maxlength='12' readOnly >
           
	</tr> -->		
     <tr>
     <td class='label'><fmt:message key="Common.ReasonForContact.label" bundle="${common_labels}"/></td>
     
 <%   
         if(!contact_reason_code.equals(""))
         {
            //pstmt   = con.prepareStatement( "select contact_reason_code,contact_reason from am_contact_reason where contact_reason_code = '"+contact_reason_code+"'") ;

			pstmt   = con.prepareStatement( "select contact_reason_code,contact_reason from am_contact_reason_lang_vw  where contact_reason_code = '"+contact_reason_code+"' and language_id='"+locale+"'") ;

			rs = pstmt.executeQuery();
            if( rs != null )
            {
              while( rs.next() )
              {
               if(contact_reason_code.equals(rs.getString(1)))
				  {
			   %>
				    <td class='querydata' colspan='3'><%=rs.getString(2)%>
				   <%
				  }
              }
          }
         if(rs!=null)rs.close();
	     if(pstmt!=null) pstmt.close();
		 out.println("</td>");
         }
		 else{	 
			out.println("<td colspan='3'></td>");
		 }
	 %>     
 </tr>

		<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
		<%if(!other_reason_remarks.equals(""))
		{%>
		<tr>
			<td class='label'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class='QUERYDATA' style='word-wrap:break-word;width:300px;'><%=other_reason_remarks%></td>
		</tr>
		<%}%>
		<!--End ML-MMOH-CRF-1114-->

 <tr>
			<!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
            <td class= 'label' nowrap><fmt:message key="eOP.ReasonForReviseVisit.label" bundle="${op_labels}"/></td>
			<td colspan = "4"><select name='revise_reason_code' id='revise_reason_code' tabIndex='11' onChange='displayRemarksForOtherReason(revise_reason_code);'><option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
 <%               
            //pstmt   = con.prepareStatement( "select contact_reason_code,contact_reason from am_contact_reason where nvl(revise_visit_yn,'N') = 'Y' and eff_status='E' order by contact_reason" ) ;

			pstmt   = con.prepareStatement("Select contact_reason_code,contact_reason from am_contact_reason_lang_vw where nvl(revise_visit_yn,'N') = 'Y' and eff_status='E' and language_id='"+locale+"' order by contact_reason" ) ;

            rs = pstmt.executeQuery();
            if( rs != null )
             {
			  while( rs.next() )
			  {                      
				String Value  = rs.getString("contact_reason_code");
				String Label  = rs.getString("contact_reason");
				
				if(revise_reason_code.equals(Value))
				  {
					
					out.println( "<option value='" + Value + "' selected>" + Label);
				  }
				  else
				  {
						 out.println( "<option value='" + Value + "' >" + Label );    
				  }           
			   }
              }
			if(rs!=null)rs.close();
	        if(pstmt!=null) pstmt.close();
%>          
            </select><img src='../../eCommon/images/mandatory.gif'></img>             
           </td>
		   <td  id='queue_div' style='visibility:hidden;display:none' class='label' width='20%'><fmt:message key="Common.QueueNo.label" bundle="${common_labels}"/>
			<input type='text' name='queue_no' id='queue_no' size='15' value='<%=queue_num%>' onKeyPress='return Check_SpecCharsValidationOP(event);' onPaste='return checkspecialandalphanumericOP(event);' onblur = 'chkValue(this);' maxlength='15' ><img src='../../eCommon/images/mandatory.gif'></td>
		</tr> 

		<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
		<tr>
			<td class=label id='remarks_labl' style='visibility:hidden'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class="fields" id='remarks_fld' style='visibility:hidden'><textarea rows=2 cols=45 name="other_remarks" onkeyPress='checkMaxLimit(this,100)' onBlur="SPCheckMaxLen('Remarks',this,100)"><%=revise_visit_remarks%></textarea><img src='../../eCommon/images/mandatory.gif' id='remarks_img' style='visibility:hidden'></td>
		</tr>
		<!--End ML-MMOH-CRF-1114-->

       </table>    
      <input type='hidden' name='ambulatory_status' id='ambulatory_status' value=''></input>
	  <input type='hidden' name='locale' id='locale' value='<%=locale%>'></input>
	  <input type='hidden' name='facility_id' id='facility_id' value='<%=facilityid%>'></input>
	  <input type='hidden' name='q_appt_ref_no' id='q_appt_ref_no' value='<%= q_appt_ref_no %>'>
      <input type='hidden' name='queue_status' id='queue_status'  value='<%= queue_status %>'>
      <input type='hidden' name='cur_locn_code' id='cur_locn_code' value='<%= cur_locn_code %>'>
      <input type='hidden' name='cur_locn_desc' id='cur_locn_desc' value='<%= locn_desc %>'>
      <input type='hidden' name='cur_locn_type' id='cur_locn_type' value='<%= cur_locn_type %>'>
      <input type='hidden' name='cur_locn_type_desc' id='cur_locn_type_desc' value='<%= locn_type_desc %>'>               
      <input type='hidden' name='asn_care_locn_type' id='asn_care_locn_type' value='<%= asn_care_locn_type %>'>             
      <input type='hidden' name='cur_specialty_code' id='cur_specialty_code' value='<%=cur_specialty_code%>'>
	  <input type='hidden' name='room_num' id='room_num' value='<%=cur_room_num%>'>	  	  
	  <input type='hidden' name='referral_id_old' id='referral_id_old' value='<%=referral_id%>'>	  	  
	  	  	  
	  <input type='hidden' name='room_change' id='room_change' value=''>
	  <input type='hidden' name='room_cur' id='room_cur' value='<%=cur_room_num%>'>
      <input type='hidden' name='cur_visit_type_code' id='cur_visit_type_code'  value='<%= p_cur_visit_type_code %>'>
      <input type='hidden' name='cur_visit_desc' id='cur_visit_desc'       value='<%= visit_desc %>'>
      <input type='hidden' name='cur_visit_type_ind' id='cur_visit_type_ind'   value='<%= cur_visit_type_ind %>'>
	  <input type='hidden' name='cur_service_code' id='cur_service_code'     value='<%= cur_service_code %>'>
      <input type='hidden' name='cur_service_desc' id='cur_service_desc'     value='<%= service_desc %>'>         
      <input type='hidden' name='cur_subservice_code' id='cur_subservice_code'  value='<%= subservice_code %>'>
      <input type='hidden' name='cur_pract_name' id='cur_pract_name'       value='<%= pract_name %>'>
      <input type='hidden' name='cur_pract_type' id='cur_pract_type'       value='<%= cur_pract_type %>'>
      <input type='hidden' name='cur_practitioner_id' id='cur_practitioner_id'  value='<%= p_cur_practitioner_id %>'>
      <input type='hidden' name='patient_id' id='patient_id'       value='<%=patient_id%>'>
      <input type='hidden' name='p_clinic_type' id='p_clinic_type'    value='<%=p_clinic_type%>'>
      <input type='hidden' name='p_clinic_code' id='p_clinic_code'    value='<%=p_clinic_code%>'>
      <input type='hidden' name='p_visit_type_code' id='p_visit_type_code'    value='<%=p_visit_type_code%>'>
      <input type='hidden' name='p_visit_type_short_desc' id='p_visit_type_short_desc' value='<%=p_visit_type_short_desc%>'>
      <input type='hidden' name='visit_adm_type_ind' id='visit_adm_type_ind'   value='<%= visit_adm_type_ind %>'>
	  <input type='hidden' name='unlinkapptcaseyn' id='unlinkapptcaseyn' value='N'>
	   <input type='hidden' name='visit_case' id='visit_case' value='<%=visit_case%>'>     
      <input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value="N">
      <input type='hidden' name='pract_type' id='pract_type' value="">
      <input type='hidden' name='ident_at_checkin' id='ident_at_checkin' value='<%=practitionerMandatory%>'>
      <input type='hidden' name='visit_type_code' id='visit_type_code' value='<%=visit_type_code%>'>
      <input type='hidden' name='episodeReqd' id='episodeReqd' value="<%=episodeReqd%>">
      <input type='hidden' name='last_episode_no' id='last_episode_no' value="<%=episode_id%>">
      <input type='hidden' name='last_visit_no' id='last_visit_no' value="<%=last_visit_num%>">
      <input type='hidden' name='h_visit_type_ind' id='h_visit_type_ind' value="<%=cur_visit_type_ind%>">
      <input type='hidden' name='pract_type' id='pract_type' value="">
	  <input type='hidden' name='userid' id='userid' value="<%=userid%>">

	  <input type='hidden' name='assign_q_num_by' id='assign_q_num_by' value="<%=assign_q_num_by%>">
	  
      <input type='hidden' name='l_encounter_id' id='l_encounter_id' value="<%=l_encounter_id%>">
      <input type='hidden' name='visit_adm_date_time' id='visit_adm_date_time' value="<%=visit_adm_date_time%>">
      <input type='hidden' name='bl_interface_yn' id='bl_interface_yn' value="<%=bl_interface_yn%>">
	  <input type='hidden' name='bl_install_yn' id='bl_install_yn' value="<%=bl_install_yn%>">
	  <input type='hidden' name='service' id='service' value="<%=cur_service_code%>">
	  <input type = 'hidden' name = 'identifyPractitionerAtCheckIn' value = '<%=identifyPractitionerAtCheckIn%>' >
	  <input type='hidden' name='help_function_id' id='help_function_id' value='REVISE_VISIT'>
	  <input type='hidden' name='resclass' id='resclass' value="<%=resource_class%>">
	  <input type='hidden' name='restype' id='restype' value="<%=resource_type%>">
	  <input type='hidden' name='chg_flag' id='chg_flag' value=''>
      <input type='hidden' name='old_locn_code' id='old_locn_code'        value='<%= cur_locn_code %>'>
      <input type='hidden' name='old_srvc_code' id='old_srvc_code'     value='<%= cur_service_code %>'>
	  <input type='hidden' name='arrive_date_time' id='arrive_date_time' value='<%=arrive_date_time%>'>
      <input type='hidden' name='vital_signs_date_time' id='vital_signs_date_time' value='<%=vital_signs_date_time%>'>
	  <input type='hidden' name='res_class' id='res_class' value='<%=resource_class%>'>
	  <input type='hidden' name='appt_walk_ind' id='appt_walk_ind' value='<%=appt_walk_ind%>'>
	  <input type='hidden' name='oth_res_id' id='oth_res_id' value='<%=other_res_id%>'>
	  <input type='hidden' name='queue_date' id='queue_date' value='<%=queue_date%>'>
	  <input type='hidden' name='queue_num' id='queue_num' value='<%=queue_num%>'>
	  <input type='hidden' name='open_to_all' id='open_to_all' value='<%=p_cur_open_to_all_pract_yn%>'>
	  <input type='hidden' name='queue_id' id='queue_id' value='<%=queue_id%>'>
	  <input type='hidden' name='status' id='status' value='<%=status%>'>
	  <input type='hidden' name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn' value='<%=entitlement_by_pat_cat_yn%>'>
	  <input type='hidden' name='cur_qms_interfaced_yn' id='cur_qms_interfaced_yn' value='<%=qms_interfaced_yn%>'>
	  <input type='hidden' name='qms_interfaced_yn' id='qms_interfaced_yn' value='N'>
	  <input type='hidden' name='qms_exception' id='qms_exception' value='N'>

	  <!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
	  <input type='hidden' name='others_id' id='others_id' value='<%=others_id%>'>
	  <input type='hidden' name='contact_reason_code' id='contact_reason_code' value='<%=contact_reason_code%>'>
	  <input type='hidden' name='other_reason_remarks' id='other_reason_remarks' value='<%=other_reason_remarks%>'>
	  
	  <!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013 Start-->		
		<input type='hidden' name='Sysdate' id='Sysdate' id='Sysdate' value='<%=Sysdate%>'	 />
		<input type='hidden' name='Systime' id='Systime' id='Systime'	 />
		<input type='hidden' name='is_prac_blocked' id='is_prac_blocked' id='is_prac_blocked' 	 /> 
		<input type='hidden' name='action_on_pract_schedule' id='action_on_pract_schedule' id='action_on_pract_schedule' value='<%=action_on_pract_schedule %>' 	 />
		<input type='hidden' name='exist_pract_id' id='exist_pract_id' id='exist_pract_id' value='<%=p_cur_practitioner_id%>'	 /> 
		
		<!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013 End-->
		<input type='hidden' name='isQMSapplicable' id='isQMSapplicable' value=<%= isQMSapplicable%>>
	  	
		
   <script>

        function EnabApply()
        {           
            parent.parent.frames[0].document.forms[0].apply.disabled= false ;                   
        }
		
		if(document.forms[0].status.value =="04")
			alert(getMessage("CONSPROG_ONLY_REFDET_CHANGE","OP"))
			
  </script>       
<%
if (bl_interface_yn.equals("Y"))
     {
%>
<jsp:include page="../../eBL/jsp/BLFinDetHiddenFlds.jsp" flush="true">
<jsp:param name="patient_id" value="<%=patient_id%>" />
<jsp:param name="episode" value="<%=episode_id%>" />
<jsp:param name="record" value="<%=record%>" />
<jsp:param name="calling_module" value="OP" />
<jsp:param name="episode_type" value="O" />
<jsp:param name="calling_function_id" value="REVISE_VISIT" />
</jsp:include>
<%
	}
    
 
     if (bl_interface_yn.equals("Y"))
     {      
            out.println("<input type='hidden' name='process_flag' id='process_flag' value=''>");      
     }
     
if(pstmt != null) pstmt.close();
if(rs != null) rs.close();

}catch(Exception e ){
	out.println("Errors encountered 2" + e.toString());
	e.printStackTrace();
	}
finally
{
	
	if(con!=null)
        ConnectionManager.returnConnection(con,request);
}

%>      
      </form>
  </body>
</html>


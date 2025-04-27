<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--  Function Name Cancel Visit
  Created by M.Sathis Kumar on 28/02/2000 -->
<%@ page import ="java.sql.*, webbeans.eCommon.*,com.ehis.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
  <head>
     <meta http-equiv="Expires" content="0"> 
  
<%   
	 request.setCharacterEncoding("UTF-8");
	 String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	 <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
     <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
     <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>    
     <Script src="../../eOP/js/CancelVisit.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
   
 <%
      Connection con    = null;
	  PreparedStatement pstmt=null;
	  ResultSet rs=null;
	  //Statement stmt_ref=null;
      //Statement stmt_bl_yn = null;
      //ResultSet rset_bl_yn =null;

	  try{
      con    = ConnectionManager.getConnection(request);
      String facility_id      = (String) session.getValue("facility_id");   
	  
      String encounter_id     = request.getParameter("encounter_id");
      //String queue_date       = request.getParameter("queue_date");  
	  String locale = (String)session.getValue("LOCALE");
      String module_id        = request.getParameter("module_id");
      String bl_interfaced_yn        = request.getParameter("bl_interfaced_yn")==null?"":request.getParameter("bl_interfaced_yn");
	/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
      String room_desc="";
	  /*CRF end SS-CRF-0010 [IN034516]*/

	  /*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		HashMap hashdata	= eCommon.Common.CommonBean.getSiteSpecificDetails(con, "OA","REMARKS_FOR_OTHERS");
		String others_id	= (String)hashdata.get("value1");
		if(others_id == null) others_id = "";
		/*End ML-MMOH-CRF-1114*/
	  
     // String queueStatus        = request.getParameter("queueStatus");
	   String function_name        = request.getParameter("function_name")==null?"":request.getParameter("function_name");
	   String qms_interfaced_yn="N";
	   String multi_speciality_yn="N";//Added for the CRF - Bru-HIMS-CRF-198
	  if((module_id==null) || (module_id.equals("null")) || (module_id=="") || (module_id.equals(""))) module_id		= "OP"; 
	 
	    String referral_id="";
        String referral_details="";
        String status="";
		String status_enabled="";
		String episode_type = "";
		String arrive_data_time="";
		String vital_signs_date_time="";
		String queue_num="";
		String ref_dtl_line = "";
        
        //stmt_ref=con.createStatement();
		//stmt_bl_yn=con.createStatement();
      
 //     String bl_interfaced_yn="";
      int count1 = 0;
      
      //String policy_type_code="";
      //String cust_code="";

      String patient_id           = "";
      String appt_case_yn         = "";
      String visit_adm_type       = "";
      String visit_type_desc      = "";
      String visit_type_ind       = "";
    
      String episode_id           = "";
      String op_episode_visit_num = "";
      String new_op_episode_yn    = "";      
      
      String assign_care_locn_code  = "";
      String assign_care_locn_type  = "";
      String attend_practitioner_id = "";
      String service_code           = "";
      String service_short_desc     = "";      
      String subservice_code        = "";
      String subservice_short_desc  = "";            
      String new_op_episode_yn_property = "";
      String appt_case_yn_property      = "";      
      
      String queue_status           = "";
      String queue_date_time        = ""; 
	  String queue_date_time_display = "";
	  String appointment_no        = ""; 
	  String room_num="";
	  String treatment_area_desc="";
	  String ae_bed_no="";
	  String priority_zone="";
	 /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	  String sql              ="";
	  String color            ="";
	  String green            ="";
	  String red              ="";
      String yellow           ="";
      String unassigned       ="";
 	/* CRF  SKR-CRF-0021 [IN028173] end  */
	  
	  StringBuffer sqlPrEnc = new StringBuffer();
	  
    try{   
    
      /*sqlPrEnc.append("select   encounter.patient_id,encounter.referral_id referral_id, nvl(encounter.appt_case_yn,'W') appt_case_yn, ");
        sqlPrEnc.append("encounter.Visit_adm_type, visit_type.visit_type_ind, visit_type.short_desc visit_type_desc,  ");
        sqlPrEnc.append("decode(visit_type_ind,'F','First','L','Follow-up','R','Routine','E', ");
        sqlPrEnc.append("'Emergency','S','Series','C','Referral for Consult') visit_type_ind_desc, ");
        sqlPrEnc.append("episode_id,op_episode_visit_num, new_op_episode_yn, ");
        sqlPrEnc.append("encounter.assign_care_locn_type, encounter.assign_care_locn_code, ");
        sqlPrEnc.append("encounter.attend_practitioner_id,  ");
        sqlPrEnc.append("service.service_code, service.service_short_desc service_short_desc, "); 
        sqlPrEnc.append("subservice.subservice_code, subservice.subservice_short_desc subservice_short_desc ,  ");
        sqlPrEnc.append("patient_type.short_desc patient_type_short_desc ,encounter.assign_room_num " );
        sqlPrEnc.append("from pr_encounter encounter, op_visit_type visit_type, ");
        sqlPrEnc.append("am_facility_service_vw service, am_facility_subsrvc_vw subservice, ");
        sqlPrEnc.append("am_patient_type patient_type ");
        sqlPrEnc.append("where  visit_type.visit_type_code    = encounter.visit_adm_type ");
        sqlPrEnc.append("and    visit_type.facility_id        = encounter.facility_id ");
        sqlPrEnc.append("and    encounter.encounter_id        = '"+encounter_id+"' ");
        sqlPrEnc.append("and    encounter.facility_id         = '"+facility_id+"' ");
        sqlPrEnc.append("and    service.service_code(+)       = encounter.service_code ");
        sqlPrEnc.append("and    service.operating_facility_id(+)        = encounter.facility_id ");
        sqlPrEnc.append("and    subservice.service_code(+)    = encounter.service_code ");
        sqlPrEnc.append( "and    subservice.subservice_code(+) = encounter.subservice_code ");
        sqlPrEnc.append("and    subservice.operating_facility_id(+)     = encounter.facility_id ");
        sqlPrEnc.append("and    patient_type.patient_type(+)  = encounter.patient_type");*/

		/* Below line query modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
		sqlPrEnc.append("SELECT encounter.patient_id, encounter.referral_id referral_id, NVL(encounter.appt_case_yn,'W') appt_case_yn, encounter.Visit_adm_type, encounter.VISIT_ADM_TYPE_IND visit_type_ind, op_get_desc.OP_VISIT_TYPE(facility_id,encounter.visit_adm_type,'"+locale+"',2) visit_type_desc, encounter.VISIT_ADM_TYPE_IND visit_type_ind_desc, episode_id, op_episode_visit_num, new_op_episode_yn, encounter.assign_care_locn_type, encounter.assign_care_locn_code, encounter.attend_practitioner_id, encounter.service_code, am_get_desc.am_service(encounter.service_code,'"+locale+"',2) service_short_desc, encounter.subservice_code, am_get_desc.am_subservice(encounter.service_code,encounter.subservice_code,'"+locale+"',2) subservice_short_desc  ,am_get_desc.AM_PATIENT_TYPE(encounter.patient_type,'"+locale+"',2)patient_type_short_desc, encounter.assign_room_num,  am_get_desc.am_facility_room (encounter.facility_id, encounter.assign_room_num, '"+locale+"', 2) room_desc,(select multi_speciality_yn from op_clinic where CLINIC_CODE=encounter.assign_care_locn_code and FACILITY_ID='"+facility_id+"') multi_speciality_yn FROM pr_encounter encounter WHERE encounter.encounter_id = '"+encounter_id+"' AND encounter.facility_id = '"+facility_id+"'"); 	
       /*CRF end SS-CRF-0010 [IN034516]*/		
		
		pstmt =con.prepareStatement(sqlPrEnc.toString());
		rs = pstmt.executeQuery();
      
	 	  
	  if (rs!= null)
      {
        while(rs.next())
        {
          patient_id           = rs.getString("patient_id");
          appt_case_yn         = rs.getString("appt_case_yn");
		 
          visit_adm_type       = rs.getString("visit_type_ind");
          visit_type_desc      = rs.getString("visit_type_desc");
          visit_type_ind       = rs.getString("visit_type_ind_desc");
		  if(visit_type_ind.equals("F"))
			  visit_type_ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels");
		  else if(visit_type_ind.equals("L"))
			  visit_type_ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels");
		  else if(visit_type_ind.equals("R"))
			  visit_type_ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		  else if(visit_type_ind.equals("E"))
			  visit_type_ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
		  else if(visit_type_ind.equals("S"))
			  visit_type_ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels");
		  else if(visit_type_ind.equals("C"))
			  visit_type_ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels");
		  else if(visit_type_ind == null)
			  visit_type_ind=""; 
		  
		  op_episode_visit_num = rs.getString("op_episode_visit_num");
          new_op_episode_yn    = rs.getString("new_op_episode_yn");
		  if( new_op_episode_yn==null || new_op_episode_yn.equals("null"))
			  new_op_episode_yn="";
		  

          assign_care_locn_code  = rs.getString("assign_care_locn_code");
          assign_care_locn_type  = rs.getString("assign_care_locn_type");
          attend_practitioner_id = rs.getString("attend_practitioner_id");
          if(attend_practitioner_id==null)
              attend_practitioner_id="";
          service_code           = rs.getString("service_code");
          service_short_desc     = rs.getString("service_short_desc");
		  subservice_code        = rs.getString("subservice_code");
          subservice_short_desc  = rs.getString("subservice_short_desc");
          
          //added by shubha
          episode_id        = rs.getString("episode_id");
          //added by smitha
          room_num = rs.getString("assign_room_num");
	      /* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
		  room_desc=rs.getString("room_desc")== null?"":rs.getString("room_desc");/*Modified by Suresh M Against IN057475 on 14th Sept 2015*/
		  /*CRF end SS-CRF-0010 [IN034516]*/
		  referral_id = rs.getString("referral_id") == null?"":rs.getString("referral_id");
		  multi_speciality_yn = rs.getString("multi_speciality_yn") == null?"N":rs.getString("multi_speciality_yn");//Added for the crf - Bru-HIMS-CRF 198

        }
      }
    qms_interfaced_yn=eOP.QMSInterface.isClinicQMSInterfaced(assign_care_locn_code,facility_id,con);
	if(qms_interfaced_yn==null || qms_interfaced_yn.equals("")){
	qms_interfaced_yn="N";
	}
	 if(rs != null )rs.close();
	 if(pstmt !=null )pstmt.close();
 
     sqlPrEnc.setLength(0);

    }catch(Exception e) { 
		
		e.printStackTrace();}
       
	sqlPrEnc.setLength(0);

	StringBuffer sqlOPPatQ = new StringBuffer();

	try{
			/*sqlOPPatQ.append("select decode(Queue_Status,'01','Checked In','02',");
			sqlOPPatQ.append("'Arrived At Nursing Station','03', 'Initial Check-Up/Vital Signs Recorded',");
			sqlOPPatQ.append("'04','Consultation Progress','05', 'Undergoing Treatment/Investigation',");
			sqlOPPatQ.append("'06','Returned from investigation') queue_status,");
			sqlOPPatQ.append( "to_char (decode(queue_Status,'01',check_in_date_time,'02',arrive_date_time,");
			sqlOPPatQ.append("'03',vital_signs_date_time, '04',cons_srvc_start_date_time,'05',null,");
			sqlOPPatQ.append("'06',subs_arrive_date_time),'dd/mm/yyyy hh24:mi') queue_date_time, appt_id ,ARRIVE_DATE_TIME, VITAL_SIGNS_DATE_TIME ");
			sqlOPPatQ.append("from   op_patient_queue where patient_id = '"+patient_id+"' ");
			sqlOPPatQ.append("and  facility_id ='"+facility_id+"' and trunc(queue_date) = to_date('"+queue_date+"','dd/mm/yyyy') ");
			sqlOPPatQ.append("and    locn_type   ='"+assign_care_locn_type+"' ");
			sqlOPPatQ.append("and  locn_code   ='"+assign_care_locn_code+"' ");
			sqlOPPatQ.append("and  practitioner_id = nvl('"+attend_practitioner_id+"','*ALL') ");
			sqlOPPatQ.append("and    queue_shift='*ALL' and encounter_id = "+encounter_id);*/

			if (module_id.equals("AE"))
			{
				episode_type ="E";

				sqlOPPatQ.append("SELECT Queue_Status queue_status, TO_CHAR(DECODE(queue_Status,'01',check_in_date_time,'02',arrive_date_time,'03',vital_signs_date_time, '04',cons_srvc_start_date_time,'05',NULL,'06',subs_arrive_date_time),'dd/mm/yyyy hh24:mi') queue_date_time, ARRIVE_DATE_TIME, VITAL_SIGNS_DATE_TIME, PRIORITY_ZONE, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(FACILITY_ID,LOCN_CODE,treatment_area_code,'"+locale+"' ,'2') treatment_area_desc,AE_BED_NO,(select BILLING_INTERFACED_YN from ae_param where operating_facility_id='"+facility_id+"') bl_interfaced_yn ");

				if(!referral_id.equals("")) {
					sqlOPPatQ.append(" , GET_REFERRAL_DETAIL_LINE('"+referral_id+"', 'FROM','"+locale+"') ref_dtl_line ");
				}
				
				sqlOPPatQ.append(" FROM ae_current_patient where facility_id ='"+facility_id+"' AND encounter_id = '"+encounter_id+"'");
			} else {

				episode_type ="O";

				sqlOPPatQ.append("SELECT Queue_Status queue_status, TO_CHAR(DECODE(queue_Status,'01',check_in_date_time,'02',arrive_date_time,'03',vital_signs_date_time, '04',cons_srvc_start_date_time,'05',NULL,'06',subs_arrive_date_time),'dd/mm/yyyy hh24:mi') queue_date_time, appt_id ,ARRIVE_DATE_TIME, VITAL_SIGNS_DATE_TIME,queue_num "); 

				if(!referral_id.equals("")) {
					sqlOPPatQ.append(" , GET_REFERRAL_DETAIL_LINE('"+referral_id+"', 'FROM','"+locale+"') ref_dtl_line ");
				}
				
				sqlOPPatQ.append(" FROM op_current_patient where facility_id ='"+facility_id+"' AND encounter_id = '"+encounter_id+"'"); 
			}

			//sqlOPPatQ.append("SELECT Queue_Status queue_status, TO_CHAR(DECODE(queue_Status,'01',check_in_date_time,'02',arrive_date_time,'03',vital_signs_date_time, '04',cons_srvc_start_date_time,'05',NULL,'06',subs_arrive_date_time),'dd/mm/yyyy hh24:mi') queue_date_time, appt_id   ,ARRIVE_DATE_TIME, VITAL_SIGNS_DATE_TIME FROM op_current_patient where facility_id ='"+facility_id+"' AND encounter_id = '"+encounter_id+"'"); 

			//sqlOPPatQ.append("SELECT Queue_Status queue_status, TO_CHAR(DECODE(queue_Status,'01',check_in_date_time,'02',arrive_date_time,'03',vital_signs_date_time, '04',cons_srvc_start_date_time,'05',NULL,'06',subs_arrive_date_time),'dd/mm/yyyy hh24:mi') queue_date_time,   ,ARRIVE_DATE_TIME, VITAL_SIGNS_DATE_TIME FROM ae_current_patient where facility_id ='"+facility_id+"' AND encounter_id = '"+encounter_id+"'"); 
		  
		  pstmt =con.prepareStatement(sqlOPPatQ.toString());
		  rs = pstmt.executeQuery();
          if (rs!= null && rs.next())
          {
			  queue_status    = rs.getString(1);
			 
			  if(queue_status.equals("01"))				  queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.CheckedIn.label","op_labels");
			  else if(queue_status.equals("02"))				  queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ArrivedAtNursStn.label","op_labels");
			  else if(queue_status.equals("03"))				  queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.InitChkUpORVtlSgnRec.label","op_labels");
			  else if(queue_status.equals("04"))				  queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");
			  else if(queue_status.equals("05"))				  queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.UndergoingTrtORInvst.label","op_labels");
			  else if(queue_status.equals("06"))				  queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.RetFrmInvest.label","op_labels");

			  if (module_id.equals("AE")) {
				  queue_date_time = rs.getString(2);
				  arrive_data_time= rs.getString("ARRIVE_DATE_TIME");
				  vital_signs_date_time=rs.getString("VITAL_SIGNS_DATE_TIME");
				  treatment_area_desc=rs.getString("treatment_area_desc");
				  if(treatment_area_desc == null) treatment_area_desc = "";
				  ae_bed_no=rs.getString("ae_bed_no");
				   if(ae_bed_no == null) ae_bed_no = "";
				  priority_zone=rs.getString("priority_zone");
				  bl_interfaced_yn=rs.getString("bl_interfaced_yn");
				   if(bl_interfaced_yn == null) bl_interfaced_yn = "";

			  } else {
				  queue_date_time = rs.getString(2);
				  appointment_no  = rs.getString(3);
				  arrive_data_time= rs.getString("ARRIVE_DATE_TIME");
				  vital_signs_date_time=rs.getString("VITAL_SIGNS_DATE_TIME");
				  queue_num=rs.getString("queue_num");
			  }

			  if(!referral_id.equals("")) {
				ref_dtl_line = rs.getString("ref_dtl_line") == null?"":rs.getString("ref_dtl_line");
				String check = ref_dtl_line.substring(0,13);
                        
				if(check.equals("ORACLE__ERROR") || check.equals("NO_DATA_FOUND")) {
					referral_details = "";
				} else {
                    status = ref_dtl_line.substring(0,1);
                    referral_details = ref_dtl_line.substring(2,ref_dtl_line.length());
                }
			  }
		  }

		  if(rs != null   )rs.close();
	      if(pstmt !=null )pstmt.close();

		  sqlOPPatQ.setLength(0);

		  queue_date_time_display = DateUtils.convertDate(queue_date_time,"DMYHM","en",locale);

    }catch(Exception e) {
		e.printStackTrace();}
   
	//if(referral_id == null) referral_id="";
	// out.println("refer"+referral_id);

		/*
		if(!referral_id.equals(""))
        {
          
		      
			String from="FROM";
            String sql1 = "select  GET_REFERRAL_DETAIL_LINE('"+referral_id+"', '"+from+"','"+locale+"') from dual    " ;  
            String check="";
			ResultSet csrs=stmt_ref.executeQuery(sql1) ;
                if(csrs!=null)
                {
                    while(csrs.next())
                    {
                        check=csrs.getString(1).substring(0,13);
                        //out.println(check);
						if(check.equals("ORACLE__ERROR") || check.equals("NO_DATA_FOUND"))
                        referral_details="";
                        else
                        {
                            status=csrs.getString(1).substring(0,1);
                            referral_details=csrs.getString(1).substring(2,csrs.getString(1).length());
                        }
                    }
                }

				//out.println(referral_details);
				if(csrs != null) csrs.close();
				if(stmt_ref != null) stmt_ref.close();

		}
		*/
		
	// The following conditions were added by Smita Unnikrishnan on 21-04-04  as the Delink referral checkbox had to be disabled if the Patient was an appointment case
	if(!appt_case_yn.equals("A"))
		  {
	 if(status.equals("C")){ status_enabled="";}
    else if(status.equals("O")) {status_enabled="disabled";}
		  }
		  else
		  {
			status_enabled="disabled";
		  }
	
      if (new_op_episode_yn.equals("Y"))
         new_op_episode_yn_property = " checked ";
              
      if (appt_case_yn.equals("A"))
         appt_case_yn_property = " checked ";
         
      if (service_short_desc == null)
            service_short_desc = "";

      if (subservice_short_desc == null)
            subservice_short_desc = "";
        
      if(appointment_no == null || appointment_no.equals("null"))  appointment_no = "";	
/*
    try
    {

	
		String sql_bl ="";
		if (module_id.equals("AE"))
        {
            sql_bl="select BILLING_INTERFACED_YN from ae_param where operating_facility_id='"+facility_id+"'  ";
	       
			rset_bl_yn = stmt_bl_yn.executeQuery(sql_bl);
            if(rset_bl_yn!=null )
            {
              while(rset_bl_yn.next())
                {
                    bl_interfaced_yn=rset_bl_yn.getString("BILLING_INTERFACED_YN");
                }
            }
		}	   
	   if (rset_bl_yn != null) rset_bl_yn.close();
	 // if(bl_interfaced_yn.equals("Y"))
      //{
         	 // String sql = "";
			 // if (module_id.equals("AE"))
             // {
			
           //     sql="select count(*) count1 from bl_patient_charges_folio where (module_id != 'AE'  and episode_id='"+episode_id+"' and visit_id='"+op_episode_visit_num+"' and nvl(trx_status,'A')!='C') or(module_id!='AE' and episode_id='"+episode_id+"'  and visit_id='"+op_episode_visit_num+"'  and nvl(trx_status,'A')!='C' and nvl(billed_flag,'N')='Y' and nvl(trx_posted_ind,'N') ='Y')";

			//  }else{
    			
				
				//sql="select count(*) count1 from bl_patient_charges_folio where (module_id != 'OP'  and episode_id='"+episode_id+"' and visit_id='"+op_episode_visit_num+"' and nvl(trx_status,'A')!='C') or(module_id!='OP' and episode_id='"+episode_id+"'  and visit_id='"+op_episode_visit_num+"'  and nvl(trx_status,'A')!='C' and nvl(billed_flag,'N')='Y' and nvl(trx_posted_ind,'N') ='Y')";
			
		//	}
			//rset_bl_yn= stmt_bl_yn.executeQuery(sql);
          //  rset_bl_yn.next();
           // count1 = rset_bl_yn.getInt("count1");
			
			//if (rset_bl_yn != null) rset_bl_yn.close();
	// }     

   }catch(Exception e) { out.println(e.toString());e.printStackTrace();}
   */
	%>

  </head>
  <body class='content' onMouseDown="CodeArrest();"onload="Focusing('cancel_case_yn')" topmargin='0' bottommargin='0' onKeyDown ='lockKey()' >
    <form name="CancelVisitFrame2" id="CancelVisitFrame2" method='post' action='../../servlet/eOP.CancelVisitServlet' target="messageFrame">
      <table border='0' cellpadding='0' cellspacing='0' width='97%' align='center'>       
        <tr>
          <th class='columnheader'><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></th>          
        </tr>
	  </table>  
	  <table border='0' cellpadding='2' cellspacing='0' width='97%' align='center'>
		<tr>
          <td class='label' width='40%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
          <td class='querydata' width='60%'><%=queue_status%>&nbsp;/&nbsp;<%=queue_date_time_display%>
          </td>        
        </tr>        
        <%
        if(room_num != null)
        {
        %>
        <tr><!--  Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516]  -->
          <td class='label'><fmt:message key="Common.room.label" bundle="${common_labels}"/></td>
          <td class='querydata'><%=room_num%> <%=room_desc%>
		  <!-- CRF end SS-CRF-0010 [IN034516] -->
		   </tr>
        <%}%>
        <tr>
          <td class='label'><fmt:message key="Common.Appointment.label" bundle="${common_labels}"/></td>        
          <td class='fields'><input type="checkbox" name="appt_case_yn_disp" id="appt_case_yn_disp" value="<%=appt_case_yn%>" <%=appt_case_yn_property%> disabled>
          </td>
        </tr>
        <tr>
          <td class='label'><fmt:message key="Common.service.label" bundle="${common_labels}"/>/<fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
          <td class='querydata'><%=service_short_desc%>/<%=subservice_short_desc%>
          </td>
        </tr> 
        <tr>
          <td class='label'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/>/<fmt:message key="Common.visittype.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
          <td class='querydata'><%=visit_type_desc%>/<%=visit_type_ind%>            
          </td>
        </tr>        
     <!--   <tr>
          <td   class="label"><fmt:message key="eOP.NewEpisode.label" bundle="${op_labels}"/></td>
          <td  class='data' colspan=3>
            <input type="checkbox" name="new_op_episode_yn" id="new_op_episode_yn" value="<%=new_op_episode_yn%>" <%=new_op_episode_yn_property%> disabled>
          </td>
		</tr>
			<tr>
          <td   class="label"><fmt:message key="eOP.EpisodeNoVisitNo.label" bundle="${op_labels}"/></td>
          <td  align="left" class='data' colspan=3><b>          
            <%=episode_id%>/<%=op_episode_visit_num%></b>
          </td>
        </tr> -->         
      
   <%
    //out.println("ssss"+referral_details);

         if(!referral_details.equals(""))
          {
       %>  
 
		</table>  
		<table border='0' cellpadding='0' cellspacing='0' width='97%' align='center'>
        <tr>
          <td class='columnheader'><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></td>    
        </tr>
		</table>  
		<table border='0' cellpadding='2' cellspacing='0' width='97%' align='center'>
        <tr><td class='querydata' colspan='2'>&nbsp;<%=referral_details%></td>
        </tr>    
        <tr>
            <td class=label width='40%'><fmt:message key="eOP.DelinkReferral.label" bundle="${op_labels}"/></td>		
            <td class='fields' width='60%'><input type=checkbox name=delink_referral id=delink_referral value=C  <%=status_enabled%> ></td>				
        </tr>	
         
    
		 <%
         }
         %>
        </table>  
		<%
			 /*		Modified for CRF - PMG20089-CRF-0541 (IN08081)
						Modified by Suresh M
						Starts
			*/
			 if (module_id.equals("AE")) {%>
			 <table border='0' cellpadding='0' cellspacing='0' width='97%' align='center'>       
				<tr>
					<td class='columnheader'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Detail.label" bundle="${common_labels}"/></td>          
				</tr>
		     </table> 
			 <table border='0' cellpadding='3' cellspacing='0' width='97%' align='center'>       
				<tr>
					  <td class='label' width='40%'><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
					  <%
					  /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
					  
//					  StringBuffer sb = new StringBuffer();
	                  sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E'";
				
			    pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rs    = pstmt.executeQuery();
				while(rs!=null && rs.next())
				{
				  color      =rs.getString("PRIORITY_ZONE");
				 if (color.equals("G")) {green=rs.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("R")) {red=rs.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("Y")) {yellow=rs.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("U")) {unassigned=rs.getString("PRIORITY_ZONE_DESC");}
				}
		    
			
		   if(rs != null   )rs.close();
	       if(pstmt !=null )pstmt.close();
					  %>
					  
					  
					  <%if(priority_zone.equals("U")) {%>
					  <td class='querydata' width='60%'><%=unassigned%></td>   
					  <%} else if(priority_zone.equals("R")) {%>
					  <td class='querydata' width='60%'><%=red%></td>
					  <%} else if(priority_zone.equals("Y")) {%>
					  <td class='querydata' width='60%'><%=yellow%></td>
					  <%} else if(priority_zone.equals("G")) {%>
					   <td class='querydata' width='60%'><%=green%></td>
				  <%}
			
/* CRF  SKR-CRF-0021 [IN028173] end  */			
			%>
				</tr>
				<tr>
					  <td class='label' width='40%'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
					  <td class='querydata' width='60%'><%=treatment_area_desc%></td>        
				</tr>
				<tr>
					  <td class='label' width='40%'><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></td>
					  <td class='querydata' width='60%'><%=ae_bed_no%></td>        
				</tr>
			</table>
		<% } %>
		<table border='0' cellpadding='0' cellspacing='0' width='97%' align='center'>
        <tr>
          <th class='columnheader'><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></th>
        </tr>
		</table>  
		<table border='0' cellpadding='2' cellspacing='0' width='97%' align='center'>
        <tr>
		  <!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
          <td class='label' width='40%'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/></td>        
          <td class='fields' width='60%'><input type="checkbox" name="cancel_case_yn" id="cancel_case_yn" value="Y"  checked  onClick="cancel_reason_code.disabled=!this.checked;cancel_reason_code.value='';reason.value=''; displayRemarksForOtherReason(cancel_reason_code);"  >
          </td>
        </tr>

    <tr>
		   <!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
           <td class= 'label'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
           <td class='fields'><select name='cancel_reason_code' id='cancel_reason_code' onChange="javascript:(this.value!='')?reason.value=this.options[selectedIndex].text:reason.value=''; displayRemarksForOtherReason(cancel_reason_code);" ><option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
 <%               


	    //pstmt   = con.prepareStatement( "select contact_reason_code,contact_reason from am_contact_reason where nvl(cancel_visit_yn,'N') = 'Y' and eff_status='E' order by contact_reason" ) ;

		pstmt   = con.prepareStatement( "select contact_reason_code,contact_reason from am_contact_reason_lang_vw where language_id='"+locale+"' and nvl(cancel_visit_yn,'N') = 'Y' and eff_status='E' order by contact_reason" ) ;
	    rs = pstmt.executeQuery();
	    if( rs != null )
	    {
	      while( rs.next() )
	      {                      
			String Value  = rs.getString(1);
			String Label  = rs.getString(2);
                    	out.println( "<option value='" + Value + "' >" + Label );
              }
                               
         }
			if(rs != null )rs.close();
			if(pstmt !=null )pstmt.close();
%>          
            </select>
			<img src="../../eCommon/images/mandatory.gif"></img>
           </td>
    </tr>  
	
	<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
	<tr>
		<td class=label id='remarks_labl' style='visibility:hidden'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class="fields" id='remarks_fld' style='visibility:hidden'><textarea rows=2 cols=45 name="other_remarks" onkeyPress='checkMaxLimit(this,100)' onBlur="SPCheckMaxLen('Remarks',this,100)"></textarea><img src='../../eCommon/images/mandatory.gif' id='remarks_img' style='visibility:hidden'></td>
	</tr>
	<!--End ML-MMOH-CRF-1114-->

      </table>
	  <input type='hidden' name='module_id' id='module_id' value = '<%=module_id%>'> 
      <input type='hidden' name='reason' id='reason' value = ''>    
	  <input type='hidden' name='query_string' id='query_string' value = '<%=request.getQueryString()%>'>    

	  <input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
      <input type='hidden' name='function' id='function' value='modify'>      
      <input type='hidden' name='funct_name' id='funct_name' value='modify'>
      <input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>' >      
      <input type='hidden' name='appt_case_yn' id='appt_case_yn' value='<%=appt_case_yn%>'>            
      <input type='hidden' name='service_code' id='service_code' value='<%=service_code%>'>                  
      <input type='hidden' name='subservice_code' id='subservice_code' value='<%=subservice_code%>'>                  
                    
      <input type='hidden' name='attend_practitioner_id' id='attend_practitioner_id' value='<%=attend_practitioner_id%>'>                  
      <input type='hidden' name='assign_care_locn_type' id='assign_care_locn_type' value='<%=assign_care_locn_type%>'>
      <input type='hidden' name='assign_care_locn_code' id='assign_care_locn_code' value='<%=assign_care_locn_code%>'>      
      <input type='hidden' name='visit_adm_type' id='visit_adm_type' value='<%=visit_adm_type%>'>
     
      <input type='hidden' name='bl_interfaced_yn' id='bl_interfaced_yn' value='<%=bl_interfaced_yn%>'>
      <input type='hidden' name='episode_id' id='episode_id' value='<%=episode_id%>'>
      <input type='hidden' name='op_episode_visit_num' id='op_episode_visit_num' value='<%=op_episode_visit_num%>'>
      <input type='hidden' name='visit_type_ind' id='visit_type_ind' value='<%=visit_type_ind%>'>   
      <input type='hidden' name='count1' id='count1' value='<%=count1%>'>
      <input type='hidden' name='appointment_no' id='appointment_no' value='<%=appointment_no%>'>
	  <input type='hidden' name='help_function_id' id='help_function_id' value='CANCEL_VISIT'>
	  <input type='hidden' name='function_name' id='function_name' value='<%=function_name%>'>
	  <!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
	  <input type='hidden' name='others_id' id='others_id' value='<%=others_id%>'>
      
    <%
		/*
		
	int epid=Integer.parseInt(episode_id.substring(4));
     
    if (op_episode_visit_num==null) op_episode_visit_num ="0";
    if (op_episode_visit_num.length() > 4)
    op_episode_visit_num = op_episode_visit_num.substring(0,3);
    
  if(bl_interfaced_yn.equals("Y"))
  {
    try{
		 
		String bl_fin ="";
        if (module_id.equals("AE"))
        {
		episode_type ="E";
        bl_fin ="select policy_type_code,cust_code from bl_visit_fin_dtls where operating_facility_id='"+facility_id+"' and  episode_id='"+epid+"' and EPISODE_TYPE='E' and PATIENT_ID='"+patient_id+"' and visit_id='"+op_episode_visit_num+"' ";

		}else{
		episode_type ="O";
		bl_fin ="select policy_type_code,cust_code from bl_visit_fin_dtls where  operating_facility_id='"+facility_id+"' and episode_id='"+epid+"' and EPISODE_TYPE='O' and PATIENT_ID='"+patient_id+"' and visit_id='"+op_episode_visit_num+"'";

		}
        rset_bl_yn= stmt_bl_yn.executeQuery(bl_fin);
        if (rset_bl_yn.next())
        { 
            
            policy_type_code=rset_bl_yn.getString("policy_type_code") == null ? "" :rset_bl_yn.getString("policy_type_code");
            cust_code=rset_bl_yn.getString("cust_code")== null ? "" :rset_bl_yn.getString("cust_code");
        }

      if (rset_bl_yn != null) rset_bl_yn.close();
	  if(stmt_bl_yn != null ) stmt_bl_yn.close();
	 
    }catch(Exception e) { out.println(e.toString());e.printStackTrace();}
    
  }
  */
    %>
    <input type='hidden' name='referral_id' id='referral_id' value='<%=referral_id%>'>
	<input type='hidden' name='episode_type' id='episode_type' value='<%=episode_type%>'>
	<input type='hidden' name='arrive_data_time' id='arrive_data_time' value='<%=arrive_data_time%>'>
	<input type='hidden' name='vital_signs_date_time' id='vital_signs_date_time' value='<%=vital_signs_date_time%>'>
	<input type='hidden' name='queue_num' id='queue_num' value='<%=queue_num%>'>
	 <input type='hidden' name='qms_interfaced_yn' id='qms_interfaced_yn' value='<%=qms_interfaced_yn%>'>
	 <input type='hidden' name='multi_speciality_yn' id='multi_speciality_yn' value='<%=multi_speciality_yn%>'>
  </form>   
  </body>
</html>
<%
}catch(Exception e){
		e.printStackTrace();}
    finally{

		try
		{
			//if (rset_bl_yn != null) rset_bl_yn.close();
			if( rs != null) rs.close();
			//if(stmt_bl_yn != null ) stmt_bl_yn.close();
			if(pstmt != null) pstmt.close();

		}catch (Exception e){
			e.printStackTrace();
		}

		if(con!=null) ConnectionManager.returnConnection(con,request);
   }
    
%>


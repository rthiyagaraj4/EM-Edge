<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
  <!-- Developed By	   :-	Prashant Bhalsingh
	 Created on   	   :	21/06/2001
	 Module Name 	   :	FM\File current storage location
-->
<!--modified for this CRF HSA-CRF-0306 -->
<%@ page contentType="text/html; charset=UTF-8" import="java.sql.*, java.util.*, webbeans.eCommon.* ,eCommon.Common.*, java.text.* , java.sql.Date,eFM.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	Properties p=(java.util.Properties) session.getValue("jdbc");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eFM/js/QueryFMCurrentFileStatus.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- Supporting Js File For Fixed Header with scroll.... -->
<script> 
window.onload=function(){ 
			if(document.getElementById("dataTable")!=null)	{		
				fxheaderInit('dataTable',320);
			}
}
</script>
<head>
<BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name="QueryFMSearchResult" id="QueryFMSearchResult" action="../../eFM/jsp/QueryFMCurrentFileStatusResult.jsp" method="post">
<%
	Connection con				= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	ResultSet rset				= null;
	java.sql.Statement stmt1	= null;
	ResultSet rset1				= null;
	java.sql.Statement stmt2	= null;
	ResultSet rs				= null;
    java.sql.Statement stmt3	= null;
	ResultSet rs1				= null;
	
	String fcy_id = (String) session.getValue("facility_id");

	String iss_date_time = "";
	String return_date_time = "";
	String file_creation_date = "";
    String duration_type="";
	String return_criteria="";
	String no_of_dh_to_return_op="0";
	int parameter_hours=0;
	String curr_fs_locn_code="";
	String discharge_date_time="";
	String prev_facility_name="";
	String curr_filetrans="";
	String queryCriteria	= (request.getParameter("criteria")==null)?"":request.getParameter("criteria") ;
    String volume_no		= (request.getParameter("volume_no")==null)?"":request.getParameter("volume_no") ;
	String facility			= (request.getParameter("facility")==null)?"":request.getParameter("facility") ;
	String patientid		= (request.getParameter("patientid")==null)?"":request.getParameter("patientid") ;
	String currStatDesc		= (request.getParameter("currStatDesc")==null)?"":request.getParameter("currStatDesc") ;
	String currIdDesc		= (request.getParameter("currIdDesc")==null)?"":request.getParameter("currIdDesc") ;
	String Curr_locn_desc		= (request.getParameter("Curr_locn_desc")==null)?"":request.getParameter("Curr_locn_desc") ;
	String appointmentDays	=(request.getParameter("appointmentDays")==null)?"":request.getParameter("appointmentDays") ;
	String bookingDays		= (request.getParameter("bookingDays")==null)?"":request.getParameter("bookingDays") ;
	String sql	= "" ;
	
	StringBuffer SelectSqlBuffer	= null;
	SelectSqlBuffer					= new StringBuffer();
    String perm_fs_locn_code="";
	String file_status1="";
	//Below line added for this CRF HSA-CRF-0306
	String PatientClass="",NursingUnit="",Room="",Bed="",Specility="",Clinic="",Priorityzone="",Treatmentarea="",AssignCareType="",Assigncarecode="",returndate="",dischargedatetime="";
	String returndatetime="";//HSA-CRF-0306.1
	String fs_curr_locn_id=""; //HSA-CRF-0306.1
	int recorCount=0;
	boolean isCurrentFsLocation = false;//Added for this CRF HSA-CRF-0306
	String return_date_manual_yn="N"; //Added for this CRF HSA-CRF-0306.1
	
	String canceldischarge=""; //Added for this CRF HSA-CRF-0306.1
	String return_date=""; //Added for this CRF HSA-CRF-0306.1
	
	//Below line added for this CRF HSA-CRF-0306.1 and SCF HSA-SCF-0204
	String requestedby="",issuedby="",transferedby="",transfereddatetime="",movementtype="",narration="",transportdesc="",carriedby="",transfermode="",issueddatetime="",narration_desc="",reqname="",issued_by="", trfType="";//Modified by Thamizh selvi on 25th Aug 2017 for ML-MMOH-CRF-0716
	
	String curr_locn_dischage_datetime=""; //CRF HSA-CRF-0306.1
/* Below line(s) added by Venkatesh.s against ML-MMOH-CRF-0393 */
	String remarkforborrow="";
	String borrowing_reason="";
		
	try
	{
	   isCurrentFsLocation = CommonBean.isSiteSpecific(con,"FM","CURRENT_FS_LOCATION");//Added for this CRF HSA-CRF-0306
	
		String p_nursing_unit 	= "";
		String p_room_num		= "";
		String p_bed_num		= "";
        String pr_nursing_unit 	= "";
		String pr_room_num		= "";
		String pr_bed_num		= ""; 
		String curr_facility_id="";
		String dest_locn_identity="";
		int p_count		= 1;
		int count	    = 0;
		int appt_count  = 0;

		 stmt2 = con.createStatement();
	 
		 sql = "select count(1) from oa_appt where patient_id='"+patientid+"' and facility_id ='"+fcy_id+"' and trunc(appt_date)>=trunc(sysdate) and nvl(appt_status,1) != 'A'";
		 rs = stmt2.executeQuery(sql);
		 if(rs.next())
		 {
			 appt_count = rs.getInt(1);
		 }
		 if(rs != null)	rs.close();
	
		if(appt_count == 0)
		{
			sql="select count(1) from ip_booking_list where patient_id is not null and patient_id='"+patientid+"' and trunc(preferred_date)>=trunc(sysdate) and nvl(booking_status,1)=1";
			stmt2=con.createStatement();
			rs=stmt2.executeQuery(sql);
			 if (rs.next())
				 appt_count = rs.getInt(1);
		} if(rs!=null)	rs.close();	

		if(p_count == 1)
		{
			/*sql = "select c.long_desc NURSING_UNIT_SHORT_DESC,nvl(a.room_num,'&nbsp;')room_no,nvl(a.bed_num,'&nbsp;')bed_no from ip_open_encounter a, fm_curr_locn b, ip_nursing_unit c where a.facility_id=b.curr_facility_id and a.patient_id=b.patient_id and a.facility_id = c.facility_id and a.nursing_unit_code = c.nursing_unit_code and b.facility_id='"+facility+"' and b.file_no='"+queryCriteria+"' ";
			 
			rs = stmt2.executeQuery(sql);
			
			while(rs.next())
			{
				p_nursing_unit	=			(rs.getString("NURSING_UNIT_SHORT_DESC")==null)?"":rs.getString("NURSING_UNIT_SHORT_DESC");
				p_room_num	= (rs.getString("room_no")==null)?"":rs.getString("room_no");
				p_bed_num	= (rs.getString("bed_no")==null)?"":rs.getString("bed_no");

				++count ;
			} if(rs!=null)	rs.close();*/
			//if(stmt2!=null)	stmt2.close();
				
		/*String  sql1=" SELECT       ip_get_desc.Ip_nursing_unit(facility_id,fr_nursing_unit_code,'en','2')FR_NURSING_UNIT_desc,fr_room_no,fr_bed_no   FROM ip_adt_trn  WHERE srl_no = (SELECT MAX(srl_no)  FROM ip_adt_trn    WHERE patient_id    ='"+patientid+"')     AND patient_id = '"+patientid+"' " ;
             
	    rs = stmt2.executeQuery(sql1);
			
			while(rs.next())
			{
				pr_nursing_unit	=			(rs.getString("FR_NURSING_UNIT_desc")==null)?"":rs.getString("FR_NURSING_UNIT_desc");
				pr_room_num	= (rs.getString("fr_room_no")==null)?"":rs.getString("fr_room_no");
				pr_bed_num	= (rs.getString("fr_bed_no")==null)?"":rs.getString("fr_bed_no");

				//++count ;
			} if(rs!=null)	rs.close();*/
			//if(stmt2!=null)	stmt2.close();
			
			//Added for this CRF HSA-CRF-0306.1 SCF HSA-SCF-0204
			ArrayList currentfslocation=(ArrayList)FMCurrentEncounterDetails.getCurrentFsLocationDetails(con, patientid, queryCriteria, volume_no, p);
			for(int m=0; m<currentfslocation.size(); m++){
			FMCurrentEncounterDetailsBean currentfslocationDetails=(FMCurrentEncounterDetailsBean)currentfslocation.get(m); 			
				movementtype=currentfslocationDetails.getMovementtype();
				carriedby=currentfslocationDetails.getCarriedby();	
                transportdesc=currentfslocationDetails.getTransportdesc();	
				if(!movementtype.equals("")&&movementtype.equals("F")){
				transferedby=currentfslocationDetails.getTransferedby(); 
				transfereddatetime=currentfslocationDetails.getTransferdatetime();                				
				}
				/*Added by Thamizh selvi on 22nd Aug 2017 against ML-MMOH-SCF-0716 Start*/
				else{
					transferedby		= "";
					transfereddatetime	= "";
				}/*End*/
			    if(!transportdesc.equals("")&&!carriedby.equals("")){
				 transfermode=transportdesc+" - "+carriedby;				 
				}
				/*Added by Thamizh selvi on 22nd Aug 2017 against ML-MMOH-SCF-0752 Start*/
				else{
				 transfermode="";
				}/*End*/
			}
			
			
			ArrayList requestDetls=(ArrayList)FMCurrentEncounterDetails.getCurrentFsLocationRequestDetails(con, patientid, queryCriteria, volume_no, p);
			for(int n=0; n<requestDetls.size(); n++){
			FMCurrentEncounterDetailsBean requestedDetailsBean=(FMCurrentEncounterDetailsBean)requestDetls.get(n); 
				narration=requestedDetailsBean.getNarration();	
				/* Below line(s) added by Venkatesh.s against ML-MMOH-CRF-0393 */
               remarkforborrow=requestedDetailsBean.getRemarkforBorrow();	 
				requestedby=requestedDetailsBean.getRequestedby();
				issuedby=requestedDetailsBean.getIssuedby();
				issueddatetime=requestedDetailsBean.getIssuedDatetime();
				
			}
			
			//End HSA-CRF-0306.1 and SCF HSA-SCF-0204
			
			
			//Below line added for this CRF HSA-CRF-0306
			ArrayList nursingunitDetails=(ArrayList)FMCurrentEncounterDetails.getFromNursingunitDetails(con,patientid,facility,p);
			for(int j=0; j<nursingunitDetails.size(); j++){
			FMCurrentEncounterDetailsBean frmnursingunitDetails=(FMCurrentEncounterDetailsBean)nursingunitDetails.get(j); 
                pr_nursing_unit=frmnursingunitDetails.getFromnursingunit();
				pr_room_num	=frmnursingunitDetails.getFromroom(); 
				pr_bed_num=frmnursingunitDetails.getFrombed();				  
			}
			if(!isCurrentFsLocation){
			ArrayList List=(ArrayList)FMCurrentEncounterDetails.getCurrentEncounterDetails(con,queryCriteria,facility,p);
			recorCount=List.size(); 
			for(int i=0; i<List.size(); i++){
			   FMCurrentEncounterDetailsBean currencounterDetails=(FMCurrentEncounterDetailsBean)List.get(i);                
				PatientClass=currencounterDetails.getPatientClass();
				Assigncarecode=currencounterDetails.getAssigncarecode(); 
				AssignCareType=currencounterDetails.getAssignCareType();
				p_nursing_unit=currencounterDetails.getNursingUnit();
				p_room_num=currencounterDetails.getRoom();
				p_bed_num=currencounterDetails.getBed();
				Specility=currencounterDetails.getSpecility();
				Clinic=currencounterDetails.getClinic();
				Priorityzone=currencounterDetails.getPriorityzone();
				Treatmentarea=currencounterDetails.getTreatmentarea();		   
			    dischargedatetime=currencounterDetails.getDischargedatetime();
			}
						
			//End HSA-CRF-0306
			
		//Below line modified for this CRF HSA-CRF-0306 
			//if(count >= 1 ){
			if(recorCount >= 1 ){
				int add = 0;
				int len = p_nursing_unit.length();

				add = 18 -len ; 

				for(int i=0; i<add; i++)
				p_nursing_unit = p_nursing_unit + "&nbsp;";
                pr_nursing_unit = pr_nursing_unit + "&nbsp;";
				len = 0;
				add = 0;
				len = p_room_num.length();
				add = 8 -len ;

				for(int k=0; k<add; k++)
					p_room_num = p_room_num +  "&nbsp;"	;
			        pr_room_num = pr_room_num +  "&nbsp;"	;
					
			//Added clinic for HSA-CRF-0306
                len = 0;
				add = 0;	
                len = Clinic.length();
				add = 18 -len ; 
                for(int m=0; m<add; m++)
				Clinic = Clinic + "&nbsp;";  
				
             //Added speciality for HSA-CRF-0306
                len = 0;
				add = 0;	
                len = Specility.length();
				add = 18 -len ; 
                for(int n=0; n<add; n++)
				Specility = Specility + "&nbsp;"; 
             
             //Added Treatmentarea for HSA-CRF-0306
                len = 0;
				add = 0;	
                len = Treatmentarea.length();
				add = 18 -len ; 
                for(int k=0; k<add; k++)
				Treatmentarea = Treatmentarea + "&nbsp;"; 	
              
               //Added Priorityzone for HSA-CRF-0306
                len = 0;
				add = 0;	
                len = Priorityzone.length(); 
				add = 18 -len ;   
                for(int l=0; l<add; l++)
				Priorityzone = Priorityzone + "&nbsp;";    			  
			
			}
		  }//Added for this CRF HSA-CRF-0306.1
		}

		int record_count = 0;

	//SelectSqlBuffer.append("SELECT a.file_no, get_patient_line (a.patient_id,'"+localeName+"') patient_line, a.curr_fs_locn_code, d.short_desc curr_fs_locn_short_desc, a.prev_fs_locn_code, g.short_desc prev_fs_locn_desc, (CASE WHEN a.prev_fs_locn_code IS NOT NULL AND g.holder_name IS NOT NULL THEN (SELECT appl_user_name FROM sm_appl_user WHERE appl_user_id = g.holder_name) END ) prev_holder_name, g.holder_phone_no prev_phone_no, DECODE (a.curr_fs_locn_identity, 'D', 'Department', 'T', 'Practitioner', 'C', 'Clinic', 'N', 'Nursing Unit', 'X', 'External', 'E', 'Procedure Unit', 'Y', 'Daycare Unit' ) curr_fs_locn_identity, DECODE (g.locn_identity, 'D', 'Department', 'T', 'Practitioner', 'C', 'Clinic', 'N', 'Nursing Unit', 'X', 'External', 'E', 'Procedure Unit', 'Y', 'Daycare Unit' ) prev_fs_locn_identity, a.curr_file_status file_status, (CASE WHEN a.narration_code IS NOT NULL THEN (SELECT short_desc FROM fm_narration WHERE narration_code = a.narration_code) END ) narration_desc, TO_CHAR (a.added_date, 'dd/mm/rrrr hh24:mi') file_creation_date, DECODE (a.curr_file_status, 'I', 'Inside', 'O', 'Outside', 'L', 'Lost', 'T', 'InTransit', 'R', 'Returned', 'A', 'Archived', 'E', 'Other Facility' ) curr_file_status, (CASE WHEN a.curr_file_status = 'T' THEN    ' / ' || c.short_desc || ' (' || DECODE (c.locn_identity, 'D', 'Department', 'C', 'Clinic', 'N', 'Nursing Unit', 'T', 'Practitioner', 'E', 'Procedure Unit', 'Y', 'Daycare Unit' ) || ')' ELSE ' ' END ) dest_locn, TO_CHAR (a.iss_date_time, 'dd/mm/rrrr hh24:mi') iss_date_time, TO_CHAR (a.return_date_time, 'dd/mm/rrrr hh24:mi') return_date_time, (CASE WHEN a.facility_id <> a.curr_facility_id THEN ' / ' || (SELECT facility_name FROM sm_facility_param WHERE facility_id = a.curr_facility_id) ELSE ' ' END ) curr_facility_name, (CASE WHEN a.facility_id <> a.prev_facility_id THEN ' / ' || (SELECT facility_name FROM sm_facility_param WHERE facility_id = a.prev_facility_id) ELSE ' ' END ) prev_facility_name, (CASE WHEN a.curr_file_status = 'T' THEN (CASE WHEN c.holder_name IS NOT NULL THEN (SELECT appl_user_name FROM sm_appl_user WHERE appl_user_id = c.holder_name) END ) ELSE (CASE WHEN d.holder_name IS NOT NULL THEN (SELECT appl_user_name FROM sm_appl_user WHERE appl_user_id = d.holder_name) END ) END ) holder_name, (CASE WHEN a.curr_file_status = 'T' THEN c.holder_phone_no ELSE d.holder_phone_no END ) holder_phone_no, a.req_remarks, (CASE WHEN (    a.curr_facility_id = a.facility_id AND a.curr_fs_locn_code = a.perm_fs_locn_code AND a.curr_file_status = 'I' ) THEN 'Y' ELSE 'N' END ) owner_locn_yn, a.curr_locn_id, a.curr_fs_locn_identity locn_iden, c.locn_identity, i.src_user_id, (CASE WHEN i.src_user_id IS NOT NULL THEN (SELECT appl_user_name FROM sm_appl_user WHERE appl_user_id = i.src_user_id) END ) issued_by, i.transport_mode, i.carried_by_name, (CASE WHEN i.transport_mode IS NOT NULL THEN (SELECT long_desc FROM am_transport_mode WHERE transport_mode = i.transport_mode) END ) transport_desc, (CASE WHEN i.dest_user_id IS NOT NULL THEN (SELECT appl_user_name FROM sm_appl_user WHERE appl_user_id = i.dest_user_id) END ) reqname,j.carried_by_name carried_by_ret,(CASE WHEN j.transport_mode IS NOT NULL THEN (SELECT long_desc FROM am_transport_mode WHERE transport_mode = j.transport_mode) END ) transport_desc_ret FROM fm_curr_locn a, fm_transit_file b, fm_storage_locn c, fm_storage_locn d, fm_storage_locn g, fm_movement_log i, fm_movement_log j WHERE a.facility_id = '"+ facility + "' AND a.file_no = '" + queryCriteria + "' AND a.volume_no = "+volume_no+" AND a.facility_id = b.facility_id(+) AND a.file_no = b.file_no(+) AND b.facility_id = c.facility_id(+) AND b.dest_fs_locn_code = c.fs_locn_code(+) AND a.curr_facility_id = d.facility_id AND a.curr_fs_locn_code = d.fs_locn_code AND a.prev_facility_id = g.facility_id(+) AND a.prev_fs_locn_code = g.fs_locn_code(+) AND a.facility_id = i.facility_id(+) AND a.file_no = i.file_no(+) AND a.volume_no = i.volume_no(+) AND a.ISS_DATE_TIME = i.sent_date_time(+) AND a.facility_id = j.facility_id(+) AND a.file_no = j.file_no(+) AND a.volume_no = j.volume_no(+) AND a.last_movement_date_time = j.sent_date_time(+) ");
	SelectSqlBuffer.append("SELECT" );
	SelectSqlBuffer.append("  b.DEST_FS_LOCN_CODE,b.DEST_FACILITY_ID,a.file_no " );
	SelectSqlBuffer.append("  , get_patient_line (a.patient_id,'"+localeName+"') patient_line " );
	SelectSqlBuffer.append("  , a.curr_fs_locn_code " );
    SelectSqlBuffer.append("  , a.perm_fs_locn_code " );
	SelectSqlBuffer.append("  , a.deficiency_status " );
	SelectSqlBuffer.append("  , d.short_desc curr_fs_locn_short_desc " );
	SelectSqlBuffer.append("  , d.locn_identity other_locn_identity " );
	SelectSqlBuffer.append("  , a.prev_fs_locn_code " );
	SelectSqlBuffer.append("  , g.short_desc prev_fs_locn_desc " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.prev_fs_locn_code IS" );
	SelectSqlBuffer.append("    NOT NULL " );
	SelectSqlBuffer.append("    AND g.holder_name IS" );
	SelectSqlBuffer.append("    NOT NULL " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    (SM_GET_DESC.SM_APPL_USER(g.holder_name,'"+localeName+"','1')) " );
	SelectSqlBuffer.append("  END) prev_holder_name " );
	SelectSqlBuffer.append("  , g.holder_phone_no prev_phone_no " );
	SelectSqlBuffer.append("  , a.curr_fs_locn_identity curr_fs_locn_identity " );
	SelectSqlBuffer.append("  , g.locn_identity prev_fs_locn_identity " );
	SelectSqlBuffer.append("  , a.curr_file_status file_status " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.narration_code IS" );
	SelectSqlBuffer.append("    NOT NULL " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    (FM_GET_DESC.FM_NARRATION(A.NARRATION_CODE,'"+localeName+"','2')) " );
	SelectSqlBuffer.append("  END) narration_desc " );
	SelectSqlBuffer.append("  , TO_CHAR (a.added_date, 'dd/mm/rrrr hh24:mi') file_creation_date " );
	SelectSqlBuffer.append("  , a.curr_file_status curr_file_status " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.curr_file_status = 'T' " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    ' / ' || FM_GET_DESC.FM_STORAGE_LOCN(B.FACILITY_ID, b.dest_fs_locn_code,'"+localeName+"','2') || ' (' || c.locn_identity || ')' " );
	SelectSqlBuffer.append("  ELSE ' ' " );
	SelectSqlBuffer.append("  END ) dest_locn " );
	SelectSqlBuffer.append("  , TO_CHAR (a.iss_date_time, 'dd/mm/rrrr hh24:mi') iss_date_time " );
	SelectSqlBuffer.append("  , TO_CHAR (a.return_date_time, 'dd/mm/rrrr hh24:mi') return_date_time " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.facility_id <> a.curr_facility_id " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    ' / ' || (SM_GET_DESC.SM_FACILITY_PARAM(a.curr_facility_id,'"+localeName+"','1')) " );
	SelectSqlBuffer.append("  ELSE ' ' " );
	SelectSqlBuffer.append("  END) curr_facility_name " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.facility_id <> a.prev_facility_id " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    ' / ' || (SM_GET_DESC.SM_FACILITY_PARAM(a.prev_facility_id,'"+localeName+"','1')) " );
	SelectSqlBuffer.append("  ELSE ' ' " );
	SelectSqlBuffer.append("  END ) prev_facility_name " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.curr_file_status = 'T' " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    ( " );
	SelectSqlBuffer.append("    CASE " );
	SelectSqlBuffer.append("    WHEN c.holder_name IS" );
	SelectSqlBuffer.append("      NOT NULL " );
	SelectSqlBuffer.append("    THEN" );
	SelectSqlBuffer.append("      (SM_GET_DESC.SM_APPL_USER(c.holder_name,'"+localeName+"','1')) " );
	SelectSqlBuffer.append("    END) " );
	SelectSqlBuffer.append("  ELSE ( " );
	SelectSqlBuffer.append("    CASE " );
	SelectSqlBuffer.append("    WHEN d.holder_name IS" );
	SelectSqlBuffer.append("      NOT NULL " );
	SelectSqlBuffer.append("    THEN" );
	SelectSqlBuffer.append("      (SM_GET_DESC.SM_APPL_USER(d.holder_name,'"+localeName+"','1')) " );
	SelectSqlBuffer.append("    END) " );
	SelectSqlBuffer.append("  END) holder_name " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.curr_file_status = 'T' " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    c.holder_phone_no  " );
	SelectSqlBuffer.append("  ELSE d.holder_phone_no  " );
	SelectSqlBuffer.append("  END ) holder_phone_no  " );
 
   SelectSqlBuffer.append("  , ( " );
   SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.curr_file_status = 'T' " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    b.dest_locn_identity " );
	SelectSqlBuffer.append("  ELSE null " );
	SelectSqlBuffer.append("  END ) dest_locn_identity " );
  SelectSqlBuffer.append("  , a.req_remarks " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN ( a.curr_facility_id = a.facility_id " );
	SelectSqlBuffer.append("    AND a.curr_fs_locn_code = a.perm_fs_locn_code " );
	SelectSqlBuffer.append("    AND a.curr_file_status = 'I' ) " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    'Y' " );
	SelectSqlBuffer.append("  ELSE 'N' " );
	SelectSqlBuffer.append("  END) owner_locn_yn " );
	SelectSqlBuffer.append("  , a.curr_locn_id,a.curr_facility_id " );
	SelectSqlBuffer.append("  , a.curr_fs_locn_identity locn_iden " );
	SelectSqlBuffer.append("  , c.locn_identity " );
	SelectSqlBuffer.append("  , j.src_user_id, NVL(i.movement_type,j.movement_type) trfType" ); //Modified by Thamizh selvi on 25th Aug 2017 for ML-MMOH-CRF-0716
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN j.src_user_id IS" );
	SelectSqlBuffer.append("    NOT NULL " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    (SM_GET_DESC.SM_APPL_USER(j.src_user_id,'"+localeName+"','1')) " );
	SelectSqlBuffer.append("  END) issued_by " );
	SelectSqlBuffer.append("  , j.transport_mode " );
	SelectSqlBuffer.append("  , j.carried_by_name " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN j.transport_mode IS" );
	SelectSqlBuffer.append("    NOT NULL " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    ( am_get_desc.am_transport_mode(j.transport_mode,'"+localeName+"','1') ) " );
	SelectSqlBuffer.append("  END) transport_desc " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN i.dest_user_id IS" );
	SelectSqlBuffer.append("    NOT NULL " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    (SM_GET_DESC.SM_APPL_USER(i.dest_user_id,'"+localeName+"','1')) " );
	SelectSqlBuffer.append("  END) reqname " );
	SelectSqlBuffer.append("  , j.carried_by_name carried_by_ret " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN j.transport_mode IS" );
	SelectSqlBuffer.append("    NOT NULL " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    ( am_get_desc.am_transport_mode(j.transport_mode,'"+localeName+"','1') ) " );
	SelectSqlBuffer.append("  END) transport_desc_ret " );	
	 /*Below line(s) borrowing_reason column added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
	SelectSqlBuffer.append(", TO_CHAR (a.discharge_date_time, 'dd/mm/rrrr hh24:mi') curr_locn_dis_date_time , return_date_manual_yn,a.borrowing_reason ");
	
	//Added for this CRF HSA-CRF-0306.1
   	SelectSqlBuffer.append("FROM" );
	SelectSqlBuffer.append("  fm_curr_locn a " );
	SelectSqlBuffer.append("  , fm_transit_file b " );
	SelectSqlBuffer.append("  , fm_storage_locn_lang_vw c " );
	SelectSqlBuffer.append("  , fm_storage_locn_lang_vw d " );
	SelectSqlBuffer.append("  , fm_storage_locn_lang_vw g " );
	SelectSqlBuffer.append("  , fm_movement_log i " );
	SelectSqlBuffer.append("  , fm_movement_log j " );
	//SelectSqlBuffer.append("WHERE a.facility_id = '"+ facility + "' " );
	SelectSqlBuffer.append("  WHERE a.file_no = '" + queryCriteria + "' " );
	SelectSqlBuffer.append("  AND a.patient_id ='"+patientid+"' " );
	SelectSqlBuffer.append("  AND a.volume_no = "+volume_no+" " );
	SelectSqlBuffer.append("  AND a.facility_id = b.facility_id(+) " );
	SelectSqlBuffer.append("  AND a.file_no = b.file_no(+) " );
	SelectSqlBuffer.append("  AND a.volume_no = b.volume_no (+) " );
	SelectSqlBuffer.append("  AND b.facility_id = c.facility_id(+) " );
	SelectSqlBuffer.append("  AND b.dest_fs_locn_code = c.fs_locn_code(+) " );
	SelectSqlBuffer.append("  AND c.language_id(+) = '"+localeName+"' " );
	SelectSqlBuffer.append("  AND a.curr_facility_id = d.facility_id " );
	SelectSqlBuffer.append("  AND a.curr_fs_locn_code = d.fs_locn_code " );
	SelectSqlBuffer.append("  AND d.language_id = '"+localeName+"' " );
	SelectSqlBuffer.append("  AND a.prev_facility_id = g.facility_id(+) " );
	SelectSqlBuffer.append("  AND a.prev_fs_locn_code = g.fs_locn_code(+) " );
	SelectSqlBuffer.append("  AND g.language_id(+) = '"+localeName+"' " );
	SelectSqlBuffer.append("  AND a.facility_id = i.facility_id(+) " );
	SelectSqlBuffer.append("  AND a.file_no = i.file_no(+) " );
	SelectSqlBuffer.append("  AND a.volume_no = i.volume_no(+) " );
	SelectSqlBuffer.append("  AND to_char(a.iss_date_time,'dd/mm/rrrr hh24:mi') = to_char(i.sent_date_time(+),'dd/mm/rrrr hh24:mi') " );////Modified by Thamizh selvi on 25th Aug 2017 for ML-MMOH-CRF-0716
	SelectSqlBuffer.append("  AND a.facility_id = j.facility_id(+) " );
	SelectSqlBuffer.append("  AND a.file_no = j.file_no(+) " );
	SelectSqlBuffer.append("  AND a.volume_no = j.volume_no(+) " );
	SelectSqlBuffer.append("  AND a.last_movement_date_time = j.sent_date_time(+) " );
	
  
	
	stmt	= con.createStatement();
    rset	= stmt.executeQuery(SelectSqlBuffer.toString());
	String location_identity = "";
	String current_locn		 = "";
	String sqlString		 = "";	
	String location_desc	 = "";	
    String other_locn_identity="";
	String desc_facility_id="";
	String desc_fs_locn_code="";
	String deficiency_status = "";
%>
<table border="0" cellpadding="0" cellspacing="0" align='center' width="98%">
	<tr>
		<td colspan='4'>
		<jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name="Patient_ID" value="<%=patientid%>"/>
		</jsp:include>
		</td>
	</tr>
</table>
<br>
<table border="0" cellpadding="3" cellspacing="0" align='center' width="100%" style="border:1x solid black" id="dataTable" >
	<%
	int i = 0;
	String p_req_remarks = "", p_owner_locn_yn="", p_owner_phone_yn="";
	String issue_trf_by = "";	
	if(rset.next())
	{ 
		issue_trf_by = rset.getString("iss_date_time");
		if((issue_trf_by==null) || (issue_trf_by.equals("null")))
		{
			//issue_trf_by="Transferred By";			
			issue_trf_by=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransferredBy.label","common_labels");			
		}
		else
		{
			//issue_trf_by="Issued By";			
			issue_trf_by=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.issuedby.label","common_labels");			
		}
		p_req_remarks = rset.getString("req_remarks");
		p_owner_locn_yn = rset.getString("owner_locn_yn");
		if (p_owner_locn_yn.trim().equals("Y"))
		{
			//p_owner_locn_yn="Holder Name";
			//p_owner_phone_yn="Holder Phone No.";
			p_owner_locn_yn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.HolderName.label","fm_labels");
			p_owner_phone_yn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.HolderPhoneNo..label","fm_labels");
		}
		else
		{
			p_owner_locn_yn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.HolderName.label","fm_labels");
			p_owner_phone_yn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.HolderPhoneNo..label","fm_labels");
		}
		%>	
		<td class='columnheader' width='30%' style="background:#1E3F64" >&nbsp;</td>
		<td class='columnheader' width='35%' style="background:#1E3F64" >&nbsp;</td>
		<td class='columnheader' width='35%' style="background:#1E3F64" > &nbsp;</td>
		<tr>
		<td class='columnheader' width='30%' style="background:#1E3F64" >&nbsp;</td>
		<th class='columnheader' width='35%' style="background:#1E3F64" ><fmt:message key="Common.CurrentFileStatus.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width='35%' style="background:#1E3F64" > <fmt:message key="eFM.PreviousFileStatus.label" bundle="${fm_labels}"/></th>
		</tr>
		<tr>
		<td class='label'><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/></td>
		<%
			String identity = 			(rset.getString("curr_fs_locn_identity")==null)?"&nbsp":rset.getString("curr_fs_locn_identity");
		        /*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
			borrowing_reason =(rset.getString("borrowing_reason")==null)?"":rset.getString("borrowing_reason");
				/* end ML-MMOH-CRF-0393-IN057159  */
			String prev_identity = 			(rset.getString("prev_fs_locn_identity")==null)?"&nbsp":rset.getString("prev_fs_locn_identity");
			desc_facility_id = 			(rset.getString("DEST_FACILITY_ID")==null)?"&nbsp":rset.getString("DEST_FACILITY_ID");
			desc_fs_locn_code = 			(rset.getString("DEST_FS_LOCN_CODE")==null)?"&nbsp":rset.getString("DEST_FS_LOCN_CODE");
			
			
			String locn_iden = 			(rset.getString("locn_iden")==null)?"&nbsp":rset.getString("locn_iden");
			location_identity	= rset.getString("locn_identity");
			
			
			current_locn		= rset.getString("curr_locn_id");
			/*Added for this CRF HSA-CRF-0306.1*/
			if(isCurrentFsLocation){
			if(current_locn==null || current_locn.equals("null")) current_locn="";
			ArrayList List=(ArrayList)FMCurrentEncounterDetails.getFileCurrentEncounterDetails(con,patientid,current_locn,locn_iden,facility,p);
			recorCount=List.size();  
			for(int k=0; k<List.size(); k++){
			   FMCurrentEncounterDetailsBean currencounterDetails=(FMCurrentEncounterDetailsBean)List.get(k);                
				PatientClass=currencounterDetails.getPatientClass();
				Assigncarecode=currencounterDetails.getAssigncarecode(); 
				AssignCareType=currencounterDetails.getAssignCareType();
				p_nursing_unit=currencounterDetails.getNursingUnit();
				p_room_num=currencounterDetails.getRoom();
				p_bed_num=currencounterDetails.getBed();
				Specility=currencounterDetails.getSpecility();
				Clinic=currencounterDetails.getClinic();
				Priorityzone=currencounterDetails.getPriorityzone();
				Treatmentarea=currencounterDetails.getTreatmentarea();		   
			    dischargedatetime=currencounterDetails.getDischargedatetime();
				canceldischarge=currencounterDetails.getCanceldischarge();				
				if((canceldischarge==null) || (canceldischarge.equals("null")))	canceldischarge = "";
				
				if((dischargedatetime==null) || (dischargedatetime.equals("null")))	dischargedatetime = "";
			}
			
			
						
			if(recorCount >= 1 ){
				int add = 0;
				int len = p_nursing_unit.length();

				add = 18 -len ; 

				for(int z=0; z<add; z++)
				p_nursing_unit = p_nursing_unit + "&nbsp;";
                pr_nursing_unit = pr_nursing_unit + "&nbsp;";
				len = 0;
				add = 0;
				len = p_room_num.length();
				add = 8 -len ;

				for(int q=0; q<add; q++)
					p_room_num = p_room_num +  "&nbsp;"	;
			        pr_room_num = pr_room_num +  "&nbsp;"	;
					
			//Added clinic for HSA-CRF-0306
                len = 0;
				add = 0;	
                len = Clinic.length();
				add = 18 -len ; 
                for(int r=0; r<add; r++)
				Clinic = Clinic + "&nbsp;";  
				
             //Added speciality for HSA-CRF-0306
                len = 0;
				add = 0;	
                len = Specility.length();
				add = 18 -len ; 
                for(int t=0; t<add; t++)
				Specility = Specility + "&nbsp;"; 
             
             //Added Treatmentarea for HSA-CRF-0306
                len = 0;
				add = 0;	
                len = Treatmentarea.length();
				add = 18 -len ; 
                for(int u=0; u<add; u++)
				Treatmentarea = Treatmentarea + "&nbsp;"; 	
              
               //Added Priorityzone for HSA-CRF-0306
                len = 0;
				add = 0;	
                len = Priorityzone.length(); 
				add = 18 -len ;   
                for(int b=0; b<add; b++)
				Priorityzone = Priorityzone + "&nbsp;";    			  
			
			}
		  }	
       		  
		/*End HSA-CRF-0306.1*/
			
            curr_facility_id     =  rset.getString("curr_facility_id");
			 other_locn_identity= rset.getString("other_locn_identity");
			String curr_file_status= rset.getString("curr_file_status")==null ? "&nbsp":rset.getString("curr_file_status");
			dest_locn_identity= rset.getString("dest_locn_identity")==null ? "":rset.getString("dest_locn_identity");	
			narration_desc= rset.getString("narration_desc")==null ? "":rset.getString("narration_desc");	
			reqname= rset.getString("reqname")==null ? "":rset.getString("reqname");	
			issued_by= rset.getString("issued_by")==null ? "":rset.getString("issued_by");	
			trfType		= rset.getString("trfType")==null ? "":rset.getString("trfType");//Modified by Thamizh selvi on 25th Aug 2017 for ML-MMOH-CRF-0716
			if(narration.equals("")) narration=narration_desc;
			if(issuedby.equals("")) issuedby=issued_by;
			 file_status1=curr_file_status;
			 stmt3 = con.createStatement();			 
			 		
			if((location_identity==null) || (location_identity.equals("null")))
				location_identity = locn_iden;
			
		if(curr_file_status.equals("T"))
		{
		 location_identity=dest_locn_identity;
		}
			if((current_locn==null) || (current_locn.equals("null")))
				current_locn = "";

					
		if( identity.equals(other_locn_identity))
		{
		  
		}
		else{
		identity=other_locn_identity;
		} 
			if(!identity.equals(""))
		{
			switch(identity.charAt(0))
			{
				case 'D' : identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}
       
		 		
		if(!prev_identity.equals(""))
		{
			switch(prev_identity.charAt(0))
			{
				case 'D' : prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}
				if(location_identity.equals("N")) {
				sqlString	=	"SELECT long_desc short_desc FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code = '"+current_locn+"'  AND facility_id = '"+curr_facility_id+"' AND eff_status = 'E' and language_id='"+localeName+"'";
			} else if (location_identity.equals("C") || location_identity.equals("E")) {
				sqlString	=	"SELECT long_desc short_desc FROM op_clinic_lang_vw WHERE clinic_code = '"+current_locn+"' AND facility_id = '"+curr_facility_id+"' AND eff_status = 'E'  and language_id='"+localeName+"'";
			} else if (location_identity.equals("D")) {
				//sqlString	=	"SELECT long_desc short_desc FROM op_clinic_lang_vw WHERE clinic_code = '"+current_locn+"' AND facility_id = '"+curr_facility_id+"' AND eff_status = 'E'  and language_id='"+localeName+"'";
				sqlString	=	"SELECT short_desc from fm_storage_locn WHERE fs_locn_code  = '"+desc_fs_locn_code+"' AND facility_id = '"+desc_facility_id+"' AND eff_status = 'E'  ";
			} else if (location_identity.equals("T")) {
				sqlString	=	"SELECT practitioner_name short_desc FROM am_practitioner_lang_vw  WHERE practitioner_id = '"+current_locn+"' AND eff_status = 'E'  and language_id='"+localeName+"' ";
			}		// Condition Newly Added for FM Incident By Saanthaakumarg
			else if (location_identity.equals("Y")) {
				//sqlString	=	"SELECT short_desc from fm_storage_locn WHERE fs_locn_code  = '"+desc_fs_locn_code+"' AND facility_id = '"+desc_facility_id+"' AND eff_status = 'E'  ";
				sqlString	=	"SELECT long_desc short_desc FROM op_clinic_lang_vw WHERE clinic_code = '"+current_locn+"' AND facility_id = '"+curr_facility_id+"' AND eff_status = 'E'  and language_id='"+localeName+"'";
			}	
					
			if(!sqlString.equals(""))
			{				
				if(stmt2!=null)	stmt2.close();
				stmt2 = con.createStatement();
				rs = stmt2.executeQuery(sqlString);
				if ((rs!=null) && (rs.next()))
					location_desc = rs.getString("short_desc");
				// Line commented against IN018199 by Muthu on 18/01/2010 
				//if(curr_file_status.equals("I") || curr_file_status.equals("R"))
				if(curr_file_status.equals("I"))
					location_desc = "&nbsp;";
				else 
					location_desc = ((location_desc==null) || (location_desc.equals("null"))||(location_desc.equals(""))) ? "&nbsp;" : (" / ("+location_desc+") ");
			}

			if(!curr_file_status.equals(""))
			{
				switch(curr_file_status.charAt(0))
				{
					case 'T' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels"); break;

					case 'I' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisInside.label","fm_labels"); break;

					case 'L' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisLost.label","fm_labels"); break;

					case 'A' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisArchived.label","fm_labels"); break;

					case 'O' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisOutside.label","fm_labels"); break;

					case 'R' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.returned.label","common_labels"); break;

					case 'E' :
				curr_filetrans =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels");;	
			    curr_file_status =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherFacility.label","common_labels");
			 curr_file_status=curr_filetrans+"&nbsp;"+"/"+"&nbsp;" +curr_file_status;
			   break;
			
				
				
				}
			}
			
		 prev_facility_name = 			(rset.getString("prev_facility_name")==null)?"&nbsp":rset.getString("prev_facility_name");
				
		if(prev_identity.equals("") || prev_identity.equals("&nbsp") )
		  prev_facility_name="&nbsp";
		%>
	   	<td class='querydata'><b><%=(rset.getString("CURR_FS_LOCN_SHORT_DESC")==null)?"&nbsp":rset.getString("CURR_FS_LOCN_SHORT_DESC") + "(" + identity + ")"%><%=rset.getString("curr_facility_name")%></td>
	   	<td class='querydata' ><b><%=(rset.getString("prev_fs_locn_desc")==null)?"&nbsp":rset.getString("prev_fs_locn_desc") + "(" + prev_identity + ")"%><%=prev_facility_name%></td>
		</tr>
		<tr>
		<td class='label'><fmt:message key="eFM.FileStatus.label" bundle="${fm_labels}"/></td>
		<td class='querydata'><b>
			
		
		<%
			deficiency_status = (rset.getString("deficiency_status")==null)?"":rset.getString("deficiency_status") ;
			if(deficiency_status.equals(""))
		   { %>
           <%=curr_file_status%><%=location_desc%>
		   <% }
			
			if(deficiency_status.equals("O"))
			{%><%=curr_file_status%>&nbsp;/&nbsp;<fmt:message key="Common.incomplete.label" bundle="${common_labels}"/><%=location_desc%><% } else if(deficiency_status.equals("C")){ %><%=curr_file_status%><%=location_desc%>&nbsp;/&nbsp;<fmt:message key="Common.closed.label" bundle="${common_labels}"/> <% } else if(deficiency_status.equals("X")){ %><%=curr_file_status%><%=location_desc%>&nbsp;/&nbsp;<fmt:message key="Common.cancelled.label" bundle="${common_labels}"/> <% } 
		%>
		</td>
		<td width="40%" height="20" class='label'>&nbsp;</td>
		</tr>
		<!--Below line modified for this CRF HSA-CRF-0306 -->
		<% //if(recorCount >= 1){ %>
	
		<!--Below line modified for this CRF HSA-CRF-0306 -->
		<tr>  
			<td class='label'><%if(isCurrentFsLocation){%><fmt:message key="eIP.CurrentEncounterDetails.label" bundle="${ip_labels}"/><%}else{%><fmt:message key="eFM.InpatientDetails.label" bundle="${fm_labels}"/><%}%></td>
			 <%/*Added for this CRF HSA-CRF-0306*/
			    String tdclass="", fontsize="",nursingUnitDaycare=""; 
			    if(PatientClass.equals("IP"))tdclass="labelcenter";
				if(PatientClass.equals("IP"))
				nursingUnitDaycare=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
				if(PatientClass.equals("DC")&&isCurrentFsLocation)
				nursingUnitDaycare=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
				   
				   if(PatientClass.equals("IP")||(PatientClass.equals("DC")&&isCurrentFsLocation)){%><td >
			<TABLE border='0' width='100%'>
			      
					<TR>
						<TD class='label' width='25%' nowrap><%=nursingUnitDaycare%></TD>
						<TD class='label'  width='20%' nowrap><fmt:message key="Common.room.label" bundle="${common_labels}"/></TD>
						<TD class='label'  width='20%' nowrap><fmt:message key="Common.Bed.label" bundle="${common_labels}"/></TD>
						<TD class='label'  width='35%'>&nbsp;</TD>
					</TR>
					<TR>
						<TD   nowrap class='querydata'><%=p_nursing_unit%></TD>
						<TD   nowrap class='querydata'><%=p_room_num%></TD>
						<TD   nowrap class='querydata'><%=p_bed_num%></TD>
						<TD  >&nbsp;</TD>
					</TR>
			</TABLE>
			 </td><%} /*Added for this CRF HSA-CRF-0306*/%>
			<%/*Added for this CRF HSA-CRF-0306*/
			 if(PatientClass.equals("IP")||(PatientClass.equals("DC")&&isCurrentFsLocation)){			   
			 %>
			 <td ><TABLE border='0' width='100%' >			 
					<TR>
						<TD class='label' width='25%' nowrap><%=nursingUnitDaycare%></TD>
						<TD class='label'  width='20%' nowrap><fmt:message key="Common.room.label" bundle="${common_labels}"/></TD>
						<TD class='label'  width='20%' nowrap><fmt:message key="Common.Bed.label" bundle="${common_labels}"/></TD>
						<TD class='label'  width='35%'>&nbsp;</TD>
					</TR>	
					<TR>
						<TD  nowrap class='querydata'><%=pr_nursing_unit%></TD>
						<TD  nowrap class='querydata'><%=pr_room_num%></TD>
						<TD  nowrap class='querydata'><%=pr_bed_num%></TD>
						<TD >&nbsp;</TD>
					</TR>
			</TABLE>
			 </td><%}//Added for this CRF HSA-CRF-0306
			
			 if(PatientClass.equals("OP")&&isCurrentFsLocation){%>
			  <td ><TABLE border='0' width='100%'>
			         <TR>						
						<TD width='25%' class='label' nowrap ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></TD>
						<TD width='20%' class='label' nowrap ><%if(AssignCareType.equals("C")){%><fmt:message key="Common.clinic.label" bundle="${common_labels}"/><%}if(AssignCareType.equals("E")){%><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/><%}%></TD>
						<TD width='20%'>&nbsp;</TD>
						<TD width='35%'>&nbsp;</TD>
						
					</TR>	
					<TR>						
						<TD nowrap class='querydata'><%=Specility%></TD>
						<TD nowrap class='querydata'><%=Clinic%></TD>
						<TD nowrap>&nbsp;</TD>
						<TD nowrap>&nbsp;</TD>
						
					</TR></TABLE>
			 </td><%} if(PatientClass.equals("EM")&&isCurrentFsLocation){%>
			  <td ><TABLE border='0' width='100%'>
			         <TR>						
						<TD  width='25%' class='label' nowrap><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></TD>
						<TD  width='20%' class='label' nowrap><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></TD>
						<TD width='35%' class='label'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></TD>
						<TD width='20%' class='label'><fmt:message key="Common.Bed.label" bundle="${common_labels}"/></TD>
					</TR>	
					<TR>						
						<TD nowrap class='querydata'><%=Clinic%></TD>
						<TD nowrap class='querydata'><%=Priorityzone%></TD>
						<TD nowrap class='querydata'><%=Treatmentarea%></TD>
						<TD nowrap class='querydata'><%=p_bed_num%></TD>
					</TR></TABLE>
			 </td>			 
			 <%}%>
			 
			 <!--Added for this CRF HSA-CRF-0306 -->
			 
		</tr>
		<% //}%>	
				<tr>
		<td  class='label'><fmt:message key="eFM.ReturnDueDateTime.label" bundle="${fm_labels}"/></td>
		<%

		return_date_time=rset.getString("return_date_time")==null?"":rset.getString("return_date_time");		
       String returnDateChkBlank	= return_date_time;
       //Added for this CRF HSA-CRF-0306.1
	      curr_locn_dischage_datetime=rset.getString("curr_locn_dis_date_time")==null?"":rset.getString("curr_locn_dis_date_time");
		   if(!curr_locn_dischage_datetime.equals(""))
			{
			   curr_locn_dischage_datetime=DateUtils.convertDate(curr_locn_dischage_datetime,"DMYHM","en",localeName);	
				
			}
	return_date_manual_yn=rset.getString("return_date_manual_yn")==null?"N":rset.getString("return_date_manual_yn"); //Added for this CRF HSA-CRF-0306.1	   
	   
			if(isCurrentFsLocation) {
				 returndate=return_date_time;
				 if(!returndate.equals(""))returndate=DateUtils.convertDate(returndate,"DMYHM","en",localeName);
			 } 
		//End HSA-CRF-0306.1
		
		if(!return_date_time.equals("") || return_date_time.equals("0"))
		{
			return_date_time=DateUtils.convertDate(return_date_time,"DMYHM","en",localeName);
			
			
		
		}
		else
			return_date_time = "&nbsp;";
	
		%>
		<%
	 
	 
	 
	 
	 if(rset1!=null)	rset1.close();
     if(stmt1!=null) stmt1.close();
		
		String sqlString1="select return_criteria  ,no_of_dh_to_return_op  , duration_type from  fm_storage_locn where fs_locn_code='"+curr_fs_locn_code+"' and facility_id='"+fcy_id+"'";
		
				
			  stmt1 = con.createStatement();
				rset1 = stmt1.executeQuery(sqlString1);
	while(rset1 != null && rset1.next()){
    return_criteria =rset1.getString("return_criteria");
    no_of_dh_to_return_op=rset1.getString("no_of_dh_to_return_op");
    duration_type=rset1.getString("duration_type");
    }
    	 
	 if(rset1!=null)	rset1.close();
     if(stmt1!=null) stmt1.close();
		
	       if(no_of_dh_to_return_op==null) no_of_dh_to_return_op="0";
	    	if(return_criteria==null) return_criteria="";
			if(duration_type==null) duration_type="";
		 		
			
			if(duration_type.equals("D"))
					{
					parameter_hours = Integer.parseInt(no_of_dh_to_return_op) * 24;
					}
					else
					{
				parameter_hours = Integer.parseInt(no_of_dh_to_return_op);	
					}	
		
	
		  
		 if(return_criteria.equals("D"))
			{
		  
		   String sqlString2="SELECT to_char(discharge_date_time+ "+(parameter_hours)+" / 24, 'dd/mm/yyyy hh24:mi') discharge_date_time  FROM pr_encounter WHERE discharge_date_time is not null AND facility_id ='"+fcy_id+"' AND assign_care_locn_code='"+current_locn+"' AND patient_id in (SELECT patient_id FROM fm_movement_log WHERE file_no ='"+queryCriteria+"' and patient_id='"+patientid+"'  AND facility_id ='"+fcy_id+"' AND sent_date_time IS NOT null)";
		      
			  stmt1 = con.createStatement();
				rset1 = stmt1.executeQuery(sqlString2);
    		 while(rset1 != null && (rset1.next())){
        discharge_date_time =rset1.getString("discharge_date_time");
          
		   }
       if(rset1!=null)	rset1.close();
       if(stmt1!=null) stmt1.close();
	       if(discharge_date_time==null) discharge_date_time="";
		  
		  if(!discharge_date_time.equals("") || discharge_date_time!=null)
				{
					discharge_date_time=DateUtils.convertDate(discharge_date_time,"DMYHM","en",localeName);
				}		
				 if(return_criteria.equals("D") && return_date_time!=null && !return_date_time.equals("&nbsp;") )
				{
                     
				}
		else	if(return_date_time.equals("&nbsp;") || return_date_time!=null)
				{
				 return_date_time=discharge_date_time;
							
				}
			
		/*	 if(parameter_hours<=0)
							{
        //     return_date_time="";
							} */
			if(return_date_time.equals(""))  return_date_time="&nbsp;";
			}
		
		//Added for this CRF HSA-CRF-0306.1 
		 String current_fs_locn_code="",number="",durations_type="",permenant_fs_locn_code="",duration_day_hours="",fslocn_return_criteria="",day_hour_return="",permanent_file_area_yn="",locn_identity="", current_file_status="";
		 int hours=0;		 
		 String currLocQuery="select curr_fs_locn_code, perm_fs_locn_code, curr_file_status from fm_curr_locn where facility_id='"+fcy_id+"' and file_no='"+queryCriteria+"' and volume_no='"+volume_no+"'";         		 
		 stmt1 = con.createStatement();
		 rset1 = stmt1.executeQuery(currLocQuery);
    	 if(rset1 != null && rset1.next()){
             current_fs_locn_code =rset1.getString("curr_fs_locn_code");
             permenant_fs_locn_code	=rset1.getString("perm_fs_locn_code");	
             current_file_status=rset1.getString("curr_file_status");				 
		 }		  
       if(rset1!=null)	rset1.close();
       if(stmt1!=null) stmt1.close();				
		 
		String durationsqlQuery="SELECT (CASE  WHEN locn_identity IN 'C' and exists (SELECT 1 FROM op_clinic             WHERE clinic_type = 'C' AND level_of_care_ind = 'E'   AND clinic_code = '"+current_locn+"' AND mr_location_code = '"+current_fs_locn_code+"' ) THEN  no_of_dh_to_return_em     ELSE (CASE                  WHEN locn_identity IN ('C', 'E') THEN no_of_dh_to_return_op   ELSE (CASE                            WHEN locn_identity = 'N' THEN no_of_dh_to_return_ip    ELSE (CASE                                      WHEN locn_identity = 'Y' THEN no_of_dh_to_return_dc   END)  END)                  END) END) no_of_dh_to_return, duration_type, return_criteria, permanent_file_area_yn, locn_identity FROM fm_storage_locn WHERE fs_locn_code = '"+current_fs_locn_code+"' AND facility_id='"+fcy_id+"'" ;
		
		
        		
		stmt1 = con.createStatement();
		rset1 = stmt1.executeQuery(durationsqlQuery);
    	if(rset1!= null&&rset1.next()){
            number= rset1.getString(1);
			durations_type= rset1.getString(2);
            fslocn_return_criteria= rset1.getString(3);	
            permanent_file_area_yn= rset1.getString(4);	
			locn_identity= rset1.getString(5);				
		 }         
       if(rset1!=null)	rset1.close();
       if(stmt1!=null) stmt1.close();
         if(number==null || number.equals("")) number = "0";
		 if(fslocn_return_criteria == null || fslocn_return_criteria.equals("null")) fslocn_return_criteria = "";
		 if(fslocn_return_criteria.equals("")) fslocn_return_criteria="I";
	     if(durations_type == null || durations_type.equals("null")) durations_type = "";
         if(durations_type.equals("D")){ 
			 hours = Integer.parseInt(number); 		 

			 if(isCurrentFsLocation&&recorCount >= 1 &&dischargedatetime.equals("")&&fslocn_return_criteria.equals("D")&&!current_file_status.equals("I")&&!current_file_status.equals("T")&& Integer.parseInt(number)!=0){
            
			 /*if(isCurrentFsLocation&&returndate.equals("")&&recorCount >= 1 &&dischargedatetime.equals("")&&fslocn_return_criteria.equals("D")&&!current_file_status.equals("I")&&!current_file_status.equals("T")&& Integer.parseInt(number)!=0){*/
			 	
			       
			  		 //returndate=number;					 
					 return_date=number; 
					 
					 if(Integer.parseInt(number)==1){ 
					       day_hour_return=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.Day.label","fm_labels");				
					 }else{
					       day_hour_return=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
					 } 				 
				
        duration_day_hours=day_hour_return+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.fromdischarge.label","fm_labels");				 
			  }
		}if(durations_type.equals("H")){   
		     //hours = Integer.parseInt(number); 
			      
             if(isCurrentFsLocation&&recorCount >= 1&&dischargedatetime.equals("")&&fslocn_return_criteria.equals("D")&&!current_file_status.equals("I")&&!current_file_status.equals("T")&&Integer.parseInt(number)!=0){
				  
            /*if(isCurrentFsLocation&&returndate.equals("")&&recorCount >= 1&&dischargedatetime.equals("")&&fslocn_return_criteria.equals("D")&&!current_file_status.equals("I")&&!current_file_status.equals("T")&&Integer.parseInt(number)!=0){*/
			               		 
               			  
				 //returndate=number;
				 return_date=number; 
				 
				 if(Integer.parseInt(number)==1){ 
				       day_hour_return=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.Hour.label","fm_labels");				
 				 }else{
				       day_hour_return=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.hours.label","common_labels");
				 }				 
				duration_day_hours=day_hour_return+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.fromdischarge.label","fm_labels") ;
			 }
		}	 
		
	   //End HSA-CRF-0306.1
	   
			%>
		
		<td class='querydata'><B>
		
		<%
		if(isCurrentFsLocation && fslocn_return_criteria.equals("D") && recorCount >= 1 && !dischargedatetime.equals("") &&!current_file_status.equals("I")&&!current_file_status.equals("T")){%>
			<%=returndate%>
	    <%}else if(isCurrentFsLocation && fslocn_return_criteria.equals("D") && recorCount >= 1 && dischargedatetime.equals("") && return_date_manual_yn.equals("Y") && !current_file_status.equals("I") && !current_file_status.equals("T")){%>
			<%=returndate%>
		<%}else if(isCurrentFsLocation && fslocn_return_criteria.equals("D") && recorCount >= 1 && dischargedatetime.equals("") && !current_file_status.equals("I") && !current_file_status.equals("T")){%>
			<%=return_date%>&nbsp;<%=duration_day_hours%>
		<%}else if(isCurrentFsLocation && fslocn_return_criteria.equals("D") && recorCount==0 && return_date_manual_yn.equals("Y") && !returndate.equals("") && !current_file_status.equals("I") && !current_file_status.equals("T")){%>
		   <%=returndate%>
		<%}else if(isCurrentFsLocation && fslocn_return_criteria.equals("I") && !current_file_status.equals("I") && !current_file_status.equals("T")){%>
		   <%=returndate%>
		<%}else if(!isCurrentFsLocation){%>
			<%=return_date_time%>
		<%}%>
		
		</td>
		<td class='label'>&nbsp;</td>
		</tr>
		<!---Added for this CRF HSA-CRF-0306.1-->
		<tr>
		<td class='label'><fmt:message key="Common.FileCreatedDateTime.label" bundle="${common_labels}"/></td>
		<%
			file_creation_date=rset.getString("FILE_CREATION_DATE");
			if(file_creation_date != null)
			{
				file_creation_date=DateUtils.convertDate(file_creation_date,"DMYHM","en",localeName);
			}
			else{
				file_creation_date = "&nbsp;";
		    }
     			
%>
		<td class='querydata'><b><%=file_creation_date%>
		</td>		
		<td class='label'></td>
		</tr>
	
		<tr><td class='columnheader' width='100%' style="background:#1E3F64" colspan=3>&nbsp;</td></tr>
		
	  <%
	  String file_status = rset.getString("file_status")==null?"":rset.getString("file_status");	
	   //if(file_status.equals("T") || file_status.equals("O")){
	  if((file_status.equals("T") || file_status.equals("O") || movementtype.equals("I") || movementtype.equals("F") || movementtype.equals("T"))&&!issuedby.equals("") && !file_status.equals("I"))//Modified by Thamizh selvi on 22nd Aug 2017 against ML-MMOH-SCF-0716
	{ 
	  %>
		<tr>
		<td class='label'><fmt:message key="Common.issuedby.label" bundle="${common_labels}"/></td>
		<td  class='querydata'><b><%=issuedby%></td>		
		<td  class='label'></td>
		</tr>
	
		<%}%>
		<!--End for this CRF HSA-CRF-0306.1 -->
		<% if(!file_status.equals("I")){ %><!--Modified by Thamizh selvi on 22nd Aug 2017 against ML-MMOH-SCF-0716-->
		<tr>
		<td class='label'><fmt:message key="Common.issueddatetime.label" bundle="${common_labels}"/></td>
		<%
		iss_date_time = rset.getString("iss_date_time");
		
	//Below code commented by Thamizh selvi on 23rd Aug 2017 against ML-MMOH-SCF-0716 since issueddatetime is obtained from fm_req_dtl table which is only applicable in the case of request and issue file and not during transfer file/change file storage location

	/*if(iss_date_time != null)
		{
			iss_date_time=DateUtils.convertDate(iss_date_time,"DMYHM","en",localeName);
		}
		else
			iss_date_time = "&nbsp;";*/
		/*Above line commented and below line added for HSA-SCF-0204 and HSA-CRF-0306.1*/
		
        /*if(issueddatetime != null)
		{
			issueddatetime=DateUtils.convertDate(issueddatetime,"DMYHM","en",localeName);
		}else{
			issueddatetime = "&nbsp;";
        }			
			
	
		curr_fs_locn_code=rset.getString("curr_fs_locn_code");
	if(curr_fs_locn_code==null) curr_fs_locn_code="";
			perm_fs_locn_code=rset.getString("perm_fs_locn_code");
	if(perm_fs_locn_code==null) perm_fs_locn_code="";

		/*if(perm_fs_locn_code.equals(curr_fs_locn_code) && file_status1.equals("I"))
		{
		iss_date_time = "&nbsp;";
		}*/
		/*Above line commented and below line added for HSA-SCF-0204 and HSA-CRF-0306.1
		if(perm_fs_locn_code.equals(curr_fs_locn_code) && file_status1.equals("I"))
		{
		issueddatetime = "&nbsp;";
		}*/
		
		if(iss_date_time==null || iss_date_time.equals("null")) iss_date_time="";  //This line for check the null value
		
		//if(issueddatetime.equals("")) issueddatetime=iss_date_time;//Commented by Thamizh selvi on 23rd Aug 2017 against ML-MMOH-SCF-0716
		%>
		<td class='querydata'><b><%=iss_date_time%></td><!--Modified issueddatetime to iss_date_time against ML-MMOH-SCF-0716-->
		<td class='label'>&nbsp;</td>
		</tr>
		<% } %>
		<% 
		 
		if((file_status.equals("T") || file_status.equals("O") ||  movementtype.equals("F") || movementtype.equals("T"))&&!transferedby.equals("") && !file_status.equals("I") && !trfType.equals("C"))//Modified by Thamizh selvi on 22nd Aug 2017 against ML-MMOH-SCF-0716
	       { 
	  %>
		<tr>
		<td class='label'><fmt:message key="Common.TransferredBy.label" bundle="${common_labels}"/> </td>
		<td  class='querydata'><b><%=transferedby%>
		</td>		
		<td  class='label'></td>
		</tr>		
		<tr>
		<td class='label'><fmt:message key="eFM.TransferredDateTime.label" bundle="${fm_labels}"/></td>
		<td  class='querydata'><b><%=transfereddatetime%>
		</td>		
		<td  class='label'></td>
		</tr>
		<%}%>
		<tr>
		<td class='label'><%=p_owner_locn_yn%></td>
		<td class='querydata'><B><%=(rset.getString("HOLDER_NAME")==null)?"&nbsp":rset.getString("HOLDER_NAME")%></td>
		<td class='querydata'><B><%=(rset.getString("prev_holder_name")==null)?"&nbsp":rset.getString("prev_holder_name")%></td>
		</tr>
		<tr>
		<td class='label'><%=p_owner_phone_yn%></td>
		<td class='querydata'><b><%=(rset.getString("holder_phone_no")==null)?"&nbsp":rset.getString("holder_phone_no")%></td>		
		<td  class='querydata'><b><%=(rset.getString("prev_phone_no")==null)?"&nbsp":rset.getString("prev_phone_no")%></td>
		</tr>	
	<%
	//if(file_status.equals("T") || file_status.equals("O"){	
	if(requestedby.equals("")) requestedby=reqname;
	if(file_status.equals("T") || file_status.equals("O") || movementtype.equals("I") || movementtype.equals("F") )
	{ 
	//Above line commented and below line modified for HSA-CRF-0306.1 and HSA-SCF-0204
		%>
		<tr>
		<td class='label'><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/></td>
		<td  class='querydata'><b><%=requestedby%></td>		
		<td class='label'><%if(p_req_remarks != null){%>
	      <a href='javascript:GetShowRemarks("ReqComm<%=i%>","<%=p_req_remarks%>","R")'><fmt:message key="eFM.RequestRemarks.label" bundle="${fm_labels}"/></a>
			<input type='hidden' name="ReqComm<%=i%>" id="ReqComm<%=i%>" value='<%=p_req_remarks%>'>
			<%}%></td>
		</tr>	
		<tr>
		<td class='label'><fmt:message key="eFM.ReasonForBorrowing.label" bundle="${fm_labels}"/></td>
		<!-- Below lines added by Venkatesh.s against ML-MMOH-CRF-0393 -->
		<% if(narration.equalsIgnoreCase("others")){	%>
		 <td class='querydata'><a href='javascript:GetShowRemarks("ReqComm<%=i%>","RQ")'> <%=narration%> </a>
          <% if(!remarkforborrow.equals("")){
		  %>
			<input type='hidden' name='ReqComm<%=i%>' id='ReqComm<%=i%>' value="<%=remarkforborrow%>">
			<%}%>
			<%if(!borrowing_reason.equals("")){ %>
			<input type='hidden' name='ReqComm<%=i%>' id='ReqComm<%=i%>' value="<%=borrowing_reason%>">
			<%}%>
			</td>	 
           <!--end ML-MMOH-CRF-0393 -->			
		<%}else if(narration_desc.equalsIgnoreCase("others")){ %>
		 <td class='querydata'><a href='javascript:GetShowRemarks("ReqComm<%=i%>","RQ")'> <%=narration_desc%> </a>
		   <% if(!remarkforborrow.equals("")){
		  %>
			<input type='hidden' name='ReqComm<%=i%>' id='ReqComm<%=i%>' value="<%=remarkforborrow%>">
			<%}%>
			<%if(!borrowing_reason.equals("")){ %>
			<input type='hidden' name='ReqComm<%=i%>' id='ReqComm<%=i%>' value="<%=borrowing_reason%>">
			<%}%>
		 </td>
		<%}else{%>
		<td class='querydata'><b><%=narration%> </td>	
		<%}%><!--modified for HSA-CRF-0306.1 and HSA-SCF-0204 -->	
		<td  class='label'></td>
		</tr>
		<% } %>
		<% if(!file_status.equals("I")){ %><!--Added by Thamizh selvi on 22nd Aug 2017 against ML-MMOH-SCF-0716-->
		<tr>
		<td class='label'><fmt:message key="eFM.TransportDetail.label" bundle="${fm_labels}"/></td>
		<%
		if(file_status.equals("T") || file_status.equals("O") || movementtype.equals("I") || movementtype.equals("F") || movementtype.equals("T"))
	   {
			if(trfType.equals("C") && file_status.equals("O")){transfermode = "";}//Modified by Thamizh selvi on 25th Aug 2017 for ML-MMOH-CRF-0716
		%>
		<td  class='querydata'><b><%=transfermode%>		
		</td>
		<% }else{ %>
			<td   class='querydata'><b><%=(rset.getString("transport_desc_ret")==null)?"&nbsp":rset.getString("transport_desc_ret")%>
		<% if(!(rset.getString("carried_by_ret")==null)){	%>
			&nbsp-&nbsp<%=(rset.getString("carried_by_ret")==null)?"&nbsp":rset.getString("carried_by_ret")%>
		<% } %>
		</td>
		<% } %>
		<td  class='label'></td>
		</tr>
		<% } %>
		<tr>
		   <td class='label'><fmt:message key="eFM.OPDAppointmentfor.label" bundle="${fm_labels}"/></td>
		   <td class='querydata'><b><b><%=appointmentDays%>&nbsp;&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.inpatientbooking.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<b><%=bookingDays%>&nbsp;&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</b></td>		
		   <td class='label'></td>		
		</tr>
		
		<tr>
		<td class='label'>&nbsp;</td>
		 <td colspan="2" class='fields'>&nbsp;<input type='button' class='button' name='View' id='View' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.AppointmentDetail.label","fm_labels")%>' onClick='ViewAppointment("<%=patientid%>","<%=appointmentDays%>","<%=bookingDays%>" );' style="border:1x solid black;">
			<!--Added for this CRF HSA-CRF-0306-->
			<%if(isCurrentFsLocation){%>
			&nbsp;<input type='button' class='button' name='audit' id='audit' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AuditTrail.label","common_labels")%>' onClick='ViewAuditTrail("<%=patientid%>","<%=queryCriteria%>","<%=volume_no%>");' style="border:1x solid black;">
			&nbsp;<input type='button' class='button' name='filemovement' id='filemovement' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileMovement.label","fm_labels")%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.History.label","common_labels")%>' onClick='FileMovementHistory("<%=patientid%>","<%=queryCriteria%>","<%=volume_no%>");' style="border:1x solid black; width:150px;" >
			<%} //End HSA-CRF-0306%>
			</td>
		</tr>
		<%	if (appt_count==0) {
			// commented by Abdulhamid for EDGE Work - TFS BUG 77187.
			//out.println("<script>if(document.forms[0].View)document.forms[0].View.style.visibility='hidden';</script>");
		} %>
			<tr><td  colspan="3" height="5" ></td></tr>
		<%		
		record_count++;
		}

		if(record_count == 0)
		{
			%>
			
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
				parent.searchResultFrame.document.location.href="../../eCommon/html/blank.html";
				parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
			</script>
			<%
		}
	%>
	</table>
	<%
//	}


	if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
	{
		SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
	}
	if(rset!=null)	rset.close();
	if(rset1!=null)	rset1.close();
	if(rs!=null)	rs.close();
	if(rs1!=null)	rs1.close();
	if(stmt!=null)	stmt.close();
	if(stmt1!=null)	stmt1.close();
	if(stmt2!=null)	stmt2.close();
	if(stmt3!=null)	stmt3.close();
	}catch(Exception e){
	out.println("Exception  :" + e ) ;
	e.printStackTrace() ;
	}finally{
		if(stmt2!=null)	stmt2.close();
		ConnectionManager.returnConnection(con, request);
	}
%>
	<input type='hidden' name='criteria' id='criteria' value='<%=queryCriteria%>'>
	<input type='hidden' name='facility' id='facility' value='<%=facility%>'>
	<input type='hidden' name='patientid' id='patientid' value='<%=patientid%>'>
	<input type='hidden' name='currStatDesc' id='currStatDesc' value='<%=currStatDesc%>'>
	<input type='hidden' name='currIdDesc' id='currIdDesc' value='<%=currIdDesc%>'>
	<input type='hidden' name='Curr_locn_desc' id='Curr_locn_desc' value='<%=Curr_locn_desc%>'>
	<input type='hidden' name='appointmentDays' id='appointmentDays' value='<%=appointmentDays%>'>
	<input type='hidden' name='bookingDays' id='bookingDays' value='<%=bookingDays%>'>
</form>
</body>
</html>


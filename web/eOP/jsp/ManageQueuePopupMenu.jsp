<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*, java.util.*,java.net.*, java.text.*,javax.servlet.jsp.JspWriter,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
    <head>
	 	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
       <script language='javascript' src='../../eCommon/js/common.js'></script>
       <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
       <script language='javascript' src='../../eOP/js/ManageSPatQueue.js'></script>
    </head>
	<body  onKeyDown = 'lockKey();'>

  
    <%  
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
        //Connection con=null;
        //Added by Ajay Hatwate for MMS-DM-CRF-0210.1
        java.util.Properties p;
    	p = (java.util.Properties) session.getValue( "jdbc" ) ;
    	String logged_in_user = p.getProperty( "login_user" ) ;
    	//End of MMS-DM-CRF-0210.1
        try{       
		//con=ConnectionManager.getConnection(request);
        String EncounterId=request.getParameter("Encounter_Id");
		String queue_status=request.getParameter("p_queue_status");
		String attend_practitioner_id  =request.getParameter("pract_id");
		
		String episode_id	= request.getParameter("episode_id")==null?"":request.getParameter("episode_id");// Added for MMS-QH-CRF-0126 [IN:041880]
		String op_episode_visit_num	= request.getParameter("op_episode_visit_num")==null?"":request.getParameter("op_episode_visit_num");// Added for MMS-QH-CRF-0126 [IN:041880]
		
		/*Below line added for this CRF Bru-HIMS-CRF-133*/
		String curr_locntype = request.getParameter("curr_locntype")==null?"":request.getParameter("curr_locntype");
		String curr_locncode = request.getParameter("curr_locncode")==null?"":request.getParameter("curr_locncode");
		String isPatientEncMovement	= request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
		String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
	
		//End this CRF Bru-HIMS-CRF-133
		
		String assign_care_locn_type =request.getParameter("curr_loc_type");
		String assign_care_locn_code =request.getParameter("locn_code");
		String PreviousDay = request.getParameter("previous_day");
		if(PreviousDay == null || PreviousDay.equals("null") || PreviousDay.equals(""))
			PreviousDay = "0";
		if(PreviousDay.equals("1"))		PreviousDay = "-1";
		if(PreviousDay.equals("0"))		PreviousDay = "+0";
		String patient_id=request.getParameter("patient_id");
		String visit_adm_type=request.getParameter("visit_adm_type");
		//String locn_code=request.getParameter("locn_code");
		//String curr_loc_type=request.getParameter("curr_loc_type");
		//String pract_id=request.getParameter("pract_id");
	//	String p_queue_status=request.getParameter("p_queue_status");
		//String bl_install_yn= ((String)session.getValue( "bl_operational" ))==null?"N":((String)session.getValue( "bl_operational" )) ;
		
		String p_patient_class=request.getParameter("p_patient_class");
		String CARE_LOCN_TYPE_IND=request.getParameter("CARE_LOCN_TYPE_IND");
		String sex=request.getParameter("sex");
		String dob=request.getParameter("DATE_OF_BIRTH");
		String room_num=request.getParameter("room_num");
		String p_status = request.getParameter("p_status");
        p_status=java.net.URLDecoder.decode(p_status,"UTF-8");
		String dt=request.getParameter("dt");
		String appt_id=request.getParameter("appt_id");
		String p_queue_date=request.getParameter("p_queue_date");
		String arrival_date=request.getParameter("arrival_date");
		String curr_locn=request.getParameter("curr_locn");		
		String calling_module=request.getParameter("calling_module")==null?"":request.getParameter("calling_module");
		//String package_bl_install_YN=request.getParameter("package_bl_install_YN")==null?"N":request.getParameter("package_bl_install_YN");

		String pkg_pat_yn = request.getParameter("pkg_pat_yn")==null?"N":request.getParameter("pkg_pat_yn");
		String pkg_enc_yn = request.getParameter("pkg_enc_yn")==null?"N":request.getParameter("pkg_enc_yn");
		
		curr_locn=java.net.URLDecoder.decode(curr_locn,"UTF-8");
		String curr_locn_type_desc=request.getParameter("curr_locn_type_desc")==null?"":request.getParameter("curr_locn_type_desc");
		curr_locn_type_desc=java.net.URLDecoder.decode(curr_locn_type_desc,"UTF-8");
		String VISIT_ADM_TYPE_IND=request.getParameter("VISIT_ADM_TYPE_IND");
		String appt_case_yn=request.getParameter("appt_case_yn");
		String ARRIVE_DATE_TIME=request.getParameter("ARRIVE_DATE_TIME");
		String VITAL_SIGNS_DATE_TIME=request.getParameter("VITAL_SIGNS_DATE_TIME");
		String other_res_class=request.getParameter("other_res_class");
		if(other_res_class == null) other_res_class="";
		String other_res_code=request.getParameter("other_res_code");
		if(other_res_code == null) other_res_code="";
		String queue_num=request.getParameter("queue_num");
		if(queue_num == null) queue_num="";
		String appt_walk_ind=request.getParameter("appt_walk_ind");
		if(appt_walk_ind == null) appt_walk_ind="";
		String queue_id=request.getParameter("queue_id");
		if(queue_id == null) queue_id="";
		String callfrom =request.getParameter("callfrom");
		if(callfrom == null) callfrom="";
		//int episode_id=0;
		//int op_episode_visit_num=0;
		//String resultFlag="N";
  
	    String mode="";
		String ca_install_yn = request.getParameter("caInsYn") == null?"N":request.getParameter("caInsYn");
        String check_out_yn="N";
		String allergy_yn = request.getParameter("allergy_yn") == null?"":request.getParameter("allergy_yn");
		String OsVal = request.getParameter("OsVal_chkout") == null?"":request.getParameter("OsVal_chkout");

		 
		String isQMSapplicable=request.getParameter("isQMSapplicable");//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 24-05-2023 Started-->

		
		
		
            try
            {
                //PreparedStatement pstmt=null;
				//ResultSet rs=null;
       
				if(!(attend_practitioner_id==null ||attend_practitioner_id.equals("*ALL")))
                    mode="R";
                  else
                    mode="A";

				/*
				            
				String sql_new = "Select AM_OPER_STN_ACCESS_CHECK('"+facilityid+"','"+userid+"','X','','CHECKOUT_PAT_YN') OsVal, (select install_yn from sm_module where module_id ='CA') install_yn, GET_TASK_APPLICABILITY('ALLERGIES', NULL, '"+resp_id+"', NULL) allergy_yn FROM dual" ;         
        
               pstmt=con.prepareStatement(sql_new);
               rs=pstmt.executeQuery();
               rs.next();
	           OsVal=rs.getString("OsVal");
			   ca_install_yn = rs.getString("install_yn");
			   allergy_yn = rs.getString("allergy_yn");	
			  
			   if(bl_install_yn.equals("Y") && package_bl_install_YN.equals("Y")){
				   sql_new =" select EPISODE_ID,OP_EPISODE_VISIT_NUM from op_current_patient where facility_id='"+facilityid+"' and encounter_id="+EncounterId;  
					pstmt=con.prepareStatement(sql_new);
					rs=pstmt.executeQuery();
					if(rs!=null && rs.next()){
						episode_id=Integer.parseInt(rs.getString("EPISODE_ID"));
						op_episode_visit_num=Integer.parseInt(rs.getString("OP_EPISODE_VISIT_NUM"));
					}
					sql_new ="SELECT blpackage.get_pkg_pat_yn('"+facilityid+"','"+patient_id+"','"+episode_id+"','"+op_episode_visit_num+"') pat_pakYN FROM dual"; 
					pstmt=con.prepareStatement(sql_new);
					rs=pstmt.executeQuery();
					if(rs!=null && rs.next()){
						resultFlag=rs.getString(1);
					}
				}
				*/
        
			if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")))
	        {
			   check_out_yn="Y";
			   
            }

			/*
			if(pstmt!=null ) pstmt.close();	
			if (rs != null)  rs.close();
			*/

%>
      <script>
	  /*  Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013 */
		var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='contextMenu' width='100%' height='100%' align='center'>"
	    tab_dat     += "<tr>";
      </script>
<% // if( queue_status .equals("01") || ( ( queue_status.equals("02") /*|| queue_status.equals("03") || queue_status.equals("04") || queue_status.equals("05") || queue_status.equals("06") ) &&  (! assign_care_locn_type.equals(current_locn_type) || !assign_care_locn_code.equals(current_locn_code))*/)  )
                

                
			 
				if(allergy_yn.equals("A"))
				{	
					
				if( (queue_status.equals("02") || queue_status.equals("03") || queue_status.equals("04") || queue_status.equals("05") || queue_status.equals("06"))  && ca_install_yn.equals("Y")) // Added
				// for
				// Excluding
				// Record
				// Vital
				// Signs
				// option
				// for
				// Previous
				// Days
				// Visits.
                {			

				%>
					<script>
					/* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013 */
					/*Below line modifie for this CRF Bru-HIMS-CRF-133*/
                    tab_dat     += "<tr>";
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CallFunction('<%=queue_status%>','<%=patient_id%>','<%=EncounterId%>','<%=assign_care_locn_type%>','<%=assign_care_locn_code%>','<%=attend_practitioner_id%>','<%=visit_adm_type%>','<%=sex%>','<%=dob%>','<%=mode%>','<%=PreviousDay%>','<%=p_patient_class%>',\""+escape("<%=curr_locn%>")+"\",'<%=URLEncoder.encode(arrival_date)%>','"+escape('<%=p_status%>')+"','<%=URLEncoder.encode(dt)%>','<%=appt_id%>','<%=p_queue_date%>','<%=room_num%>',\""+escape("<%=curr_locn%>")+"\",\""+escape("<%=curr_locn_type_desc%>")+"\",'<%=VISIT_ADM_TYPE_IND%>','<%=appt_case_yn%>','<%=URLEncoder.encode(ARRIVE_DATE_TIME)%>','<%=URLEncoder.encode(VITAL_SIGNS_DATE_TIME)%>','<%=other_res_class%>','<%=other_res_code%>','<%=queue_num%>','<%=appt_walk_ind%>','<%=queue_id%>','Allergy','<%=callfrom%>','','','<%=episode_id%>','<%=op_episode_visit_num%>','<%=curr_locntype%>','<%=curr_locncode%>','<%=isPatientEncMovement%>','<%=Sydate%>');>"+getLabel('Common.RecordAllergy.label','Common')+"</a></td>";	
					tab_dat     += "</tr>";
               </script>
                <%
                       // MenuElements.append("Record Vital Signs"+";");
				}
                }	
						
				
				if(queue_status .equals("01"))
                {  %>
					<script>
					/* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
					/*Below line modifie for this CRF Bru-HIMS-CRF-133*/
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CallFunction('<%=queue_status%>','<%=patient_id%>','<%=EncounterId%>','<%=CARE_LOCN_TYPE_IND%>','<%=assign_care_locn_code%>','<%=attend_practitioner_id%>','<%=visit_adm_type%>','<%=sex%>','<%=dob%>','<%=mode%>','<%=PreviousDay%>','<%=p_patient_class%>',\""+escape("<%=curr_locn%>")+"\",'<%=URLEncoder.encode(arrival_date)%>','"+escape('<%=p_status%>')+"','<%=URLEncoder.encode(dt)%>','<%=appt_id%>','<%=p_queue_date%>','<%=room_num%>',\""+escape("<%=curr_locn%>")+"\",\""+escape("<%=curr_locn_type_desc%>")+"\",'<%=VISIT_ADM_TYPE_IND%>','<%=appt_case_yn%>','<%=URLEncoder.encode(ARRIVE_DATE_TIME)%>','<%=URLEncoder.encode(VITAL_SIGNS_DATE_TIME)%>','<%=other_res_class%>','<%=other_res_code%>','<%=queue_num%>','<%=appt_walk_ind%>','<%=queue_id%>','Arrived','<%=callfrom%>','','','<%=episode_id%>','<%=op_episode_visit_num%>','<%=curr_locntype%>','<%=curr_locncode%>','<%=isPatientEncMovement%>','<%=Sydate%>');>"+getLabel('eOP.arrived.label','OP')+"</a></td>";	
					tab_dat     += "</tr>";
				    </script>
                <%}
                
					
				
				if( (queue_status.equals("02") || queue_status.equals("03") || queue_status.equals("04") || queue_status.equals("05") || queue_status.equals("06")) && PreviousDay.equals("+0") && ca_install_yn.equals("Y")) // Added
				// for
				// Excluding
				// Record
				// Vital
				// Signs
				// option
				// for
				// Previous
				// Days
				// Visits.
                {
				%>
					<script>
                /* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
                /*Below line modifie for this CRF Bru-HIMS-CRF-133*/
				
	                tab_dat     += "<tr>";
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CallFunction('<%=queue_status%>','<%=patient_id%>','<%=EncounterId%>','<%=assign_care_locn_type%>','<%=assign_care_locn_code%>','<%=attend_practitioner_id%>','<%=visit_adm_type%>','<%=sex%>','<%=dob%>','<%=mode%>','<%=PreviousDay%>','<%=p_patient_class%>',\""+escape("<%=curr_locn%>")+"\",'<%=URLEncoder.encode(arrival_date)%>','"+escape('<%=p_status%>')+"','<%=URLEncoder.encode(dt)%>','<%=appt_id%>','<%=p_queue_date%>','<%=room_num%>',\""+escape("<%=curr_locn%>")+"\",\""+escape("<%=curr_locn_type_desc%>")+"\",'<%=VISIT_ADM_TYPE_IND%>','<%=appt_case_yn%>','<%=URLEncoder.encode(ARRIVE_DATE_TIME)%>','<%=URLEncoder.encode(VITAL_SIGNS_DATE_TIME)%>','<%=other_res_class%>','<%=other_res_code%>','<%=queue_num%>','<%=appt_walk_ind%>','<%=queue_id%>','Record','<%=callfrom%>','','','<%=episode_id%>','<%=op_episode_visit_num%>','<%=curr_locntype%>','<%=curr_locncode%>','<%=isPatientEncMovement%>','<%=Sydate%>');>"+getLabel('eOP.recordvitalsigns.label','OP')+"</a></td>";	
					tab_dat     += "</tr>";

                    </script>
                <%
                       // MenuElements.append("Record Vital Signs"+";");
                }
                if((attend_practitioner_id==null || attend_practitioner_id.equals("*ALL"))  && ( ( queue_status.equals("01") || queue_status.equals("02") || queue_status.equals("03") ) ) )
                {
				%>
					<script>
                    /* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
                    /*Below line modifie for this CRF Bru-HIMS-CRF-133*/
	                tab_dat     += "<tr>";
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CallFunction('<%=queue_status%>','<%=patient_id%>','<%=EncounterId%>','<%=assign_care_locn_type%>','<%=assign_care_locn_code%>','<%=attend_practitioner_id%>','<%=visit_adm_type%>','<%=sex%>','<%=dob%>','<%=mode%>','<%=PreviousDay%>','<%=p_patient_class%>',\""+escape("<%=curr_locn%>")+"\",'<%=URLEncoder.encode(arrival_date)%>','"+escape('<%=p_status%>')+"','<%=URLEncoder.encode(dt)%>','<%=appt_id%>','<%=p_queue_date%>','<%=room_num%>',\""+escape("<%=curr_locn%>")+"\",\""+escape("<%=curr_locn_type_desc%>")+"\",'<%=VISIT_ADM_TYPE_IND%>','<%=appt_case_yn%>','<%=URLEncoder.encode(ARRIVE_DATE_TIME)%>','<%=URLEncoder.encode(VITAL_SIGNS_DATE_TIME)%>','<%=other_res_class%>','<%=other_res_code%>','<%=queue_num%>','<%=appt_walk_ind%>','<%=queue_id%>','Assign','<%=callfrom%>','','','<%=episode_id%>','<%=op_episode_visit_num%>','<%=curr_locntype%>','<%=curr_locncode%>','<%=isPatientEncMovement%>','<%=Sydate%>');>"+getLabel('eOP.assignpractitioner.label','OP')+"</a></td>";	
					tab_dat     += "</tr>";
                    </script>
                <%

                       // MenuElements.append("Assign Practitioner"+";");
                }
                if(!(attend_practitioner_id==null || attend_practitioner_id.equals("*ALL")) && (queue_status.equals("01") || queue_status.equals("02") || queue_status.equals("03") ) )
                {
				%>
					<script>
					/* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
					/*Below line modifie for this CRF Bru-HIMS-CRF-133*/
	                tab_dat     += "<tr>";
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CallFunction('<%=queue_status%>','<%=patient_id%>','<%=EncounterId%>','<%=assign_care_locn_type%>','<%=assign_care_locn_code%>','<%=attend_practitioner_id%>','<%=visit_adm_type%>','<%=sex%>','<%=dob%>','<%=mode%>','<%=PreviousDay%>','<%=p_patient_class%>',\""+escape("<%=curr_locn%>")+"\",'<%=URLEncoder.encode(arrival_date)%>','"+escape('<%=p_status%>')+"','<%=URLEncoder.encode(dt)%>','<%=appt_id%>','<%=p_queue_date%>','<%=room_num%>',\""+escape("<%=curr_locn%>")+"\",\""+escape("<%=curr_locn_type_desc%>")+"\",'<%=VISIT_ADM_TYPE_IND%>','<%=appt_case_yn%>','<%=URLEncoder.encode(ARRIVE_DATE_TIME)%>','<%=URLEncoder.encode(VITAL_SIGNS_DATE_TIME)%>','<%=other_res_class%>','<%=other_res_code%>','<%=queue_num%>','<%=appt_walk_ind%>','<%=queue_id%>','ReAssign','<%=callfrom%>','','','<%=episode_id%>','<%=op_episode_visit_num%>','<%=curr_locntype%>','<%=curr_locncode%>','<%=isPatientEncMovement%>','<%=Sydate%>');>"+getLabel('eOP.reassignpractitioner.label','OP')+"</a></td>";	
					tab_dat     += "</tr>";

                    </script>
                <%

                        // MenuElements.append("Re-Assign Practitioner"+";");
                }
                if(!(attend_practitioner_id ==null || attend_practitioner_id.equals("*ALL")) && (queue_status.equals("01") || queue_status.equals("02") || queue_status.equals("03") || queue_status.equals("05") || queue_status.equals("06")))
                {
				%>
					<script>
					/* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
					/*Below line modifie for this CRF Bru-HIMS-CRF-133*/
	                tab_dat     += "<tr>";
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CallFunction('<%=queue_status%>','<%=patient_id%>','<%=EncounterId%>','<%=assign_care_locn_type%>','<%=assign_care_locn_code%>','<%=attend_practitioner_id%>','<%=visit_adm_type%>','<%=sex%>','<%=dob%>','<%=mode%>','<%=PreviousDay%>','<%=p_patient_class%>',\""+escape("<%=curr_locn%>")+"\",'<%=URLEncoder.encode(arrival_date)%>','"+escape('<%=p_status%>')+"','<%=URLEncoder.encode(dt)%>','<%=appt_id%>','<%=p_queue_date%>','<%=room_num%>',\""+escape("<%=curr_locn%>")+"\",\""+escape("<%=curr_locn_type_desc%>")+"\",'<%=VISIT_ADM_TYPE_IND%>','<%=appt_case_yn%>','<%=URLEncoder.encode(ARRIVE_DATE_TIME)%>','<%=URLEncoder.encode(VITAL_SIGNS_DATE_TIME)%>','<%=other_res_class%>','<%=other_res_code%>','<%=queue_num%>','<%=appt_walk_ind%>','<%=queue_id%>','Start','<%=callfrom%>','','','<%=episode_id%>','<%=op_episode_visit_num%>','<%=curr_locntype%>','<%=curr_locncode%>','<%=isPatientEncMovement%>','<%=Sydate%>');>"+getLabel("Common.StartConsult.label",'Common')+"</a></td>";	
					tab_dat     += "</tr>";

                    </script>
                <%

                       // MenuElements.append("Start Consultation"+";");
                }
              //<!--added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Started-->
           	 if(isQMSapplicable.equals("true")){
               if(queue_status.equals("02") && CARE_LOCN_TYPE_IND.equals("C"))
				 
                {
                	%>
                	<script>
					tab_dat     += "<tr>";
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CallFunction('<%=queue_status%>','<%=patient_id%>','<%=EncounterId%>','<%=assign_care_locn_type%>','<%=assign_care_locn_code%>','<%=attend_practitioner_id%>','<%=visit_adm_type%>','<%=sex%>','<%=dob%>','<%=mode%>','<%=PreviousDay%>','<%=p_patient_class%>',\""+escape("<%=curr_locn%>")+"\",'<%=URLEncoder.encode(arrival_date)%>','"+escape('<%=p_status%>')+"','<%=URLEncoder.encode(dt)%>','<%=appt_id%>','<%=p_queue_date%>','<%=room_num%>',\""+escape("<%=curr_locn%>")+"\",\""+escape("<%=curr_locn_type_desc%>")+"\",'<%=VISIT_ADM_TYPE_IND%>','<%=appt_case_yn%>','<%=URLEncoder.encode(ARRIVE_DATE_TIME)%>','<%=URLEncoder.encode(VITAL_SIGNS_DATE_TIME)%>','<%=other_res_class%>','<%=other_res_code%>','<%=queue_num%>','<%=appt_walk_ind%>','<%=queue_id%>','QueueNoUpdate','<%=callfrom%>','','','<%=episode_id%>','<%=op_episode_visit_num%>','<%=curr_locntype%>','<%=curr_locncode%>','<%=isPatientEncMovement%>','<%=Sydate%>');>"+getLabel("eOP.UpdateQueueNumber.label",'OP')+"</a></td>";	
					tab_dat     += "</tr>";
					</script>
				<% }
                }
                //<!--added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Ends-->
				if(queue_status.equals("02") || queue_status.equals("03"))
				{
				%>
					<script>
					/* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
					/*Below line modifie for this CRF Bru-HIMS-CRF-133*/
	                tab_dat     += "<tr>";
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CallFunction('<%=queue_status%>','<%=patient_id%>','<%=EncounterId%>','<%=assign_care_locn_type%>','<%=assign_care_locn_code%>','<%=attend_practitioner_id%>','<%=visit_adm_type%>','<%=sex%>','<%=dob%>','<%=mode%>','<%=PreviousDay%>','<%=p_patient_class%>',\""+escape("<%=curr_locn%>")+"\",'<%=URLEncoder.encode(arrival_date)%>','"+escape('<%=p_status%>')+"','<%=URLEncoder.encode(dt)%>','<%=appt_id%>','<%=p_queue_date%>','<%=room_num%>',\""+escape("<%=curr_locn%>")+"\",\""+escape("<%=curr_locn_type_desc%>")+"\",'<%=VISIT_ADM_TYPE_IND%>','<%=appt_case_yn%>','<%=URLEncoder.encode(ARRIVE_DATE_TIME)%>','<%=URLEncoder.encode(VITAL_SIGNS_DATE_TIME)%>','<%=other_res_class%>','<%=other_res_code%>','<%=queue_num%>','<%=appt_walk_ind%>','<%=queue_id%>','Revert','<%=callfrom%>','','','<%=episode_id%>','<%=op_episode_visit_num%>','<%=curr_locntype%>','<%=curr_locncode%>','<%=isPatientEncMovement%>','<%=Sydate%>');>"+getLabel("eOP.ReverttoCheckin.label",'OP')+"</a></td>";	
					tab_dat     += "</tr>";

                    </script>
                <%

						// MenuElements.append("Revert to Check-in"+";");
				}

				if((queue_status.equals("02") || queue_status.equals("03") || queue_status.equals("04") || queue_status.equals("05") || queue_status.equals("06")) && ca_install_yn.equals("Y") && (!attend_practitioner_id.equals("*ALL")))
				{
				%>
					<script>
	           
			       /* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
			       /*Below line modifie for this CRF Bru-HIMS-CRF-133*/


					/*Modified by Dharma on Feb 27th 2015 against ML-BRU-SCF-1540 [IN:053334] Start */
				    tab_dat     += "<tr>";
					//tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CallFunction('<%=queue_status%>','<%=patient_id%>','<%=EncounterId%>','<%=assign_care_locn_type%>','<%=assign_care_locn_code%>','<%=attend_practitioner_id%>','<%=visit_adm_type%>','<%=sex%>','<%=dob%>','<%=mode%>','<%=PreviousDay%>','<%=p_patient_class%>',\""+escape('<%=curr_locn%>')+"\",'<%=URLEncoder.encode(arrival_date)%>','"+escape('<%=p_status%>')+"','<%=URLEncoder.encode(dt)%>','<%=appt_id%>','<%=p_queue_date%>','<%=room_num%>',\""+escape("<%=curr_locn%>")+"\",\""+escape("<%=curr_locn_type_desc%>")+"\",'<%=VISIT_ADM_TYPE_IND%>','<%=appt_case_yn%>','<%=URLEncoder.encode(ARRIVE_DATE_TIME)%>','<%=URLEncoder.encode(VITAL_SIGNS_DATE_TIME)%>','<%=other_res_class%>','<%=other_res_code%>','<%=queue_num%>','<%=appt_walk_ind%>','<%=queue_id%>','Patient','<%=callfrom%>','','','<%=episode_id%>','<%=op_episode_visit_num%>','<%=curr_locntype%>','<%=curr_locncode%>','<%=isPatientEncMovement%>','<%=Sydate%>');>"+getLabel('Common.patientchart.label','common')+"</a></td>";	

					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CallFunction('<%=queue_status%>','<%=patient_id%>','<%=EncounterId%>','<%=assign_care_locn_type%>','<%=assign_care_locn_code%>','<%=attend_practitioner_id%>','<%=visit_adm_type%>','<%=sex%>','<%=dob%>','<%=mode%>','<%=PreviousDay%>','<%=p_patient_class%>',\""+escape("<%=curr_locn%>")+"\",'<%=URLEncoder.encode(arrival_date)%>','"+escape('<%=p_status%>')+"','<%=URLEncoder.encode(dt)%>','<%=appt_id%>','<%=p_queue_date%>','<%=room_num%>',\""+escape("<%=curr_locn%>")+"\",\""+escape("<%=curr_locn_type_desc%>")+"\",'<%=VISIT_ADM_TYPE_IND%>','<%=appt_case_yn%>','<%=URLEncoder.encode(ARRIVE_DATE_TIME)%>','<%=URLEncoder.encode(VITAL_SIGNS_DATE_TIME)%>','<%=other_res_class%>','<%=other_res_code%>','<%=queue_num%>','<%=appt_walk_ind%>','<%=queue_id%>','Patient','<%=callfrom%>','','','<%=episode_id%>','<%=op_episode_visit_num%>','<%=curr_locntype%>','<%=curr_locncode%>','<%=isPatientEncMovement%>','<%=Sydate%>','<%=logged_in_user%>');>"+getLabel('Common.patientchart.label','common')+"</a></td>";
					/*Modified by Dharma on Feb 27th 2015 against ML-BRU-SCF-1540 [IN:053334] End */
					tab_dat     += "</tr>";

                    </script>
                <%

						// MenuElements.append("Patient Chart"+";");
				}
				//added as part of package billing Starts
				if((queue_status.equals("01") || queue_status.equals("02") || queue_status.equals("04")) && pkg_pat_yn.equals("Y")){%>
					<script>
					/* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
					 /*Below line modifie for this CRF Bru-HIMS-CRF-133*/
	                    tab_dat     += "<tr>";
						tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CallFunction('<%=queue_status%>','<%=patient_id%>','<%=EncounterId%>','<%=assign_care_locn_type%>','<%=assign_care_locn_code%>','<%=attend_practitioner_id%>','<%=visit_adm_type%>','<%=sex%>','<%=dob%>','<%=mode%>','<%=PreviousDay%>','<%=p_patient_class%>',\""+escape("<%=curr_locn%>")+"\",'<%=URLEncoder.encode(arrival_date)%>','"+escape('<%=p_status%>')+"','<%=URLEncoder.encode(dt)%>','<%=appt_id%>','<%=p_queue_date%>','<%=room_num%>',\""+escape("<%=curr_locn%>")+"\",\""+escape("<%=curr_locn_type_desc%>")+"\",'<%=VISIT_ADM_TYPE_IND%>','<%=appt_case_yn%>','<%=URLEncoder.encode(ARRIVE_DATE_TIME)%>','<%=URLEncoder.encode(VITAL_SIGNS_DATE_TIME)%>','<%=other_res_class%>','<%=other_res_code%>','<%=queue_num%>','<%=appt_walk_ind%>','<%=queue_id%>','multirefreg','<%=callfrom%>','','','<%=episode_id%>','<%=op_episode_visit_num%>','<%=curr_locntype%>','<%=curr_locncode%>','<%=isPatientEncMovement%>','<%=Sydate%>');>Multi Consult Orders</a></td>";	
					    tab_dat     += "</tr>";

                    </script>
				<%}
					//added as part of package billing ends
                if(queue_status.equals("04") || queue_status.equals("05") || queue_status.equals("06"))
                {

                if(check_out_yn.equals("Y")){
				%>
					<script>
					    /* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/  
					    /*Below line modifie for this CRF Bru-HIMS-CRF-133*/
	                    tab_dat     += "<tr>";
						tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:CallFunction('<%=queue_status%>','<%=patient_id%>','<%=EncounterId%>','<%=assign_care_locn_type%>','<%=assign_care_locn_code%>','<%=attend_practitioner_id%>','<%=visit_adm_type%>','<%=sex%>','<%=dob%>','<%=mode%>','<%=PreviousDay%>','<%=p_patient_class%>',\""+escape("<%=curr_locn%>")+"\",'<%=URLEncoder.encode(arrival_date)%>','"+escape('<%=p_status%>')+"','<%=URLEncoder.encode(dt)%>','<%=appt_id%>','<%=p_queue_date%>','<%=room_num%>',\""+escape("<%=curr_locn%>")+"\",\""+escape("<%=curr_locn_type_desc%>")+"\",'<%=VISIT_ADM_TYPE_IND%>','<%=appt_case_yn%>','<%=URLEncoder.encode(ARRIVE_DATE_TIME)%>','<%=URLEncoder.encode(VITAL_SIGNS_DATE_TIME)%>','<%=other_res_class%>','<%=other_res_code%>','<%=queue_num%>','<%=appt_walk_ind%>','<%=queue_id%>','Check','<%=callfrom%>','<%=pkg_pat_yn%>','<%=pkg_enc_yn%>','<%=episode_id%>','<%=op_episode_visit_num%>','<%=curr_locntype%>','<%=curr_locncode%>','<%=isPatientEncMovement%>','<%=Sydate%>');>"+getLabel('Common.CheckOut.label','Common')+"</a></td>";	
					    tab_dat     += "</tr>";

                    </script>
                <%
					}
           }
		  
		   if(callfrom.equals("S")){%>
            <script>
			   
		   tab_dat     += "</table>";
			
			   
			   parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
			   /*Below line modified by Venkatesh.S on 04/FEB/2012 against Bru-HIMS-CRF-179 [IN030297] */
			   parent.frames[1].frame2.document.getElementById("t").innerHTML = tab_dat;
			   /*end Bru-HIMS-CRF-179 [IN030297] */
            </script>
           <%}else{%>
            <script>

				<%
					if(calling_module.equals("CA"))
					{				%>parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?menu_id=OP&module_id=OP&function_id=MANAGE_PAT_QUEUE&function_name=Manage Patient Queue&function_type=F&access=NNNNN&home_required_yn=N&call_from=CA";
				<%
					}
				%>

			   tab_dat     += "</table>";
			
			   parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
			   parent.frames[1].frames[1].PatQ.document.getElementById("t").innerHTML = tab_dat;
				
            </script>
            <% }
			}
            catch(Exception e){e.printStackTrace();}
       }catch(Exception e) {}
finally{	
	//if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</body>  


<!DOCTYPE html>
<%@ page import= "java.util.*,java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<%
		request.setCharacterEncoding("UTF-8");	

		String fac_id       = (String) session.getValue( "facility_id" ) ;
		String userid                  = (String) session.getValue("login_user");
		String locale=(String)session.getAttribute("LOCALE"); 		
		
		String P_encounter_id = request.getParameter("episode_id") == null?"":request.getParameter("episode_id");	
		String P_locn_code = request.getParameter("location_code") == null?"":request.getParameter("location_code");	
		String P_locn_type = request.getParameter("location_type") == null?"":request.getParameter("location_type");	
		String P_patient_id = request.getParameter("patient_id") == null?"":request.getParameter("patient_id"); 
		String option_id = request.getParameter("option_id") == null?"":request.getParameter("option_id");	
		
		int visit_status =0;
		

		PreparedStatement stmt1=null;
		ResultSet rs1=null;

		PreparedStatement stmt=null;
		ResultSet rs=null;
		Connection con=null;

		StringBuffer sql               = new StringBuffer(); 	
		String practitioner_name       = "";		
		String episode_type="";
		String visit_type_code=""; 		
		String diagReqd="N";
		String notesReqd="N";
		String dispReqd="N";
		String OsVal = "";
		String vital_signs_date_time="";
		String arrive_date_time="";
		String close_pat_chart_on_checkout_yn="";		
		String called_from = "CA";
		String ca_practitioner_id="";
		String ca_pract_type="";
		

		if(called_from.equals("CA"))
		{
			ca_practitioner_id=(String) session.getValue("ca_practitioner_id") ;
			if(ca_practitioner_id == null)ca_practitioner_id="";
		}	
		
		
		String P_practitioner_id = "";			
		String p_queue_date="";	  		   
		String P_module_id = ""; 
		String P_ae_brought_dead_yn = "";		
		String P_ae_treatment_area_code = ""; 		
		String patient_class="";
		int mother_cut_off_age=0;
		int mother_max_age=0;
		int mother_min_age=0; 	
		String appt_id="";
		String visit_adm_type_ind=""; 		   
		String X_visit_type_desc    ="";
		String X_attend_prac_id     ="";
		String X_episode_id ="";			
		String systemdatetime="";		
		String check_out_yn="";	 		
		String episode_visit_num="";  
		String referral_id = "";	
		int patientage=0;
		String patientgender=""; 		
		String X_pract_assigned_yn = "N";			
		String mlc_yn=""; 	  
		String deceased_time="";
		String dronly="";
		String ddis="";
		String medical_yn="";
		String surgical_yn="";
		String spec_code=""; 		
		String reg_reff_chkout_yn="";
		String disposition_type="";	
		String circumstance_of_injury="";	
		String reason="";
		String deceased_yn = "";
		String charging_stage = "";
		String med_charging_stage = "";

		try
			{
				con=ConnectionManager.getConnection(request);

				stmt1 = con.prepareStatement("Select nvl(DISP_REQD_FOR_MDS_YN,'N') DISP_YN, nvl(DIAG_REQD_FOR_MDS_YN,'N') DIAG_YN, nvl(NOTES_REQD_FOR_MDS_YN,'N') NOTES_YN,REG_REFERRAL_ON_CHECKOUT_YN ,DISP_TYPE_FOR_CHECKOUT,close_pat_chart_on_checkout_yn  from OP_PARAM where operating_facility_id = '"+fac_id+"'");
				
				rs1 = stmt1.executeQuery();
				if(rs1!=null  && rs1.next())
				{	
					dispReqd=rs1.getString("DISP_YN");
					diagReqd=rs1.getString("DIAG_YN");
					notesReqd=rs1.getString("NOTES_YN");
		            reg_reff_chkout_yn=rs1.getString("REG_REFERRAL_ON_CHECKOUT_YN");
			        disposition_type=rs1.getString("DISP_TYPE_FOR_CHECKOUT"); 		         close_pat_chart_on_checkout_yn=rs1.getString("close_pat_chart_on_checkout_yn")==null?"N":
						rs1.getString("close_pat_chart_on_checkout_yn");			
					if(disposition_type==null)disposition_type="";
				}
				if(rs1 != null) rs1.close();
				if(stmt1 != null) stmt1.close();

				stmt1 = con.prepareStatement("SELECT CHARGING_STAGE, MED_CHARGING_STAGE FROM BL_OP_CLINIC WHERE	FACILITY_ID = '"+fac_id+"' AND CLINIC_CODE = '"+P_locn_code+"' AND CHARGING_STAGE IS NOT NULL");

				rs1 = stmt1.executeQuery();
				if(rs1!=null  && rs1.next())
				{	
					charging_stage = rs1.getString("CHARGING_STAGE");
					med_charging_stage = rs1.getString("MED_CHARGING_STAGE");
				}
				
				if(rs1 != null) rs1.close();
				if(stmt1 != null) stmt1.close();	

				stmt1=con.prepareStatement("Select queue_Status visit_status, practitioner_id attend_practitioner_id, patient_class, brought_dead_yn, treatment_area_code  from op_patient_queue where facility_id  = '"+fac_id+"' and encounter_id = "+P_encounter_id+"");
				rs1=stmt1.executeQuery();

				if(rs1!=null)
				{
					while(rs1.next()){
						visit_status=rs1.getInt(1);
						P_practitioner_id=rs1.getString("attend_practitioner_id")==null?"":rs1.getString("attend_practitioner_id");
						patient_class=rs1.getString("patient_class");
						P_ae_treatment_area_code=rs1.getString("treatment_area_code")==null?"":rs1.getString("treatment_area_code");
						P_ae_brought_dead_yn = rs1.getString("brought_dead_yn");
						if(P_ae_brought_dead_yn==null) P_ae_brought_dead_yn="N";
						if(P_ae_brought_dead_yn.equals("Y"))
							deceased_yn	 = "Y";
					}
				}
				if(rs1!=null) rs1.close();
				if(stmt1!=null) stmt1.close();
				if(patient_class.equals("EM"))
				{
					P_module_id="AE";						

					/*String sql_ae2="Select treatment_area_code from op_patient_queue where facility_id='"+fac_id+"' and encounter_id="+P_encounter_id+" ";
					stmt=con.prepareStatement(sql_ae2);
					rs=stmt.executeQuery();

					if(rs!=null)
					{
						while(rs.next())
						{
							P_ae_treatment_area_code = rs.getString(1);
						}
					}*/

				}
				else
					P_module_id = "OP";

				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();

				if(called_from.equals("CA")) { 				
					String sql_new = "Select AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','CHECKOUT_PAT_YN') FROM dual" ;  
						
					stmt=con.prepareStatement(sql_new);
					rs=stmt.executeQuery();
					rs.next();
					OsVal=rs.getString(1);
					
					if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
					{
					   check_out_yn="Y";
					} else {
					   check_out_yn="N";
					}  	
					if(rs!=null)
						rs.close();
					if(stmt!=null)
						stmt.close();
				} else {
					 check_out_yn="Y";
				}

				if(close_pat_chart_on_checkout_yn.equals("N") || reg_reff_chkout_yn.equals("Y")) {
					%>
						<script>
							alert(getMessage("DIRECT_VISIT_COMPL_PARAM_NOT_DEFINED","OP"));
							history.go(-1);
							if(top.content.CommonToolbar.ShowMenu)
								top.content.CommonToolbar.ShowMenu.click();								
						</script>
					<% 				

				} else if(rs1==null ||  visit_status>=7) {
					%>
						<script>
							alert(getMessage('CONS_NOT_APPL','CA'));
							history.go(-1);
							if(top.content.CommonToolbar.ShowMenu)
								top.content.CommonToolbar.ShowMenu.click();
						</script>
					<%

				}  else if(check_out_yn.equals("N")) {
					%>
						<script>
							alert(getMessage("MANAGE_QUEUE_NOT_ALL_CHECKOUT","OP"));
							history.go(-1);
							if(top.content.CommonToolbar.ShowMenu)
								top.content.CommonToolbar.ShowMenu.click();							
						</script>
					<%
				} else if(P_practitioner_id.equals("")) {
					%>
						<script>
							alert(getMessage("PRACT_NOT_ASSIGN","OP"));
							history.go(-1);
							if(top.content.CommonToolbar.ShowMenu)
								top.content.CommonToolbar.ShowMenu.click();							
						</script>
					<%					
				} else if(charging_stage.equals("COMP") || med_charging_stage.equals("COMP")) {
					%>
						<script>
							alert(getMessage("INAPPROPRAITE_BILLIG_SETUP","OP"));
							history.go(-1);
							if(top.content.CommonToolbar.ShowMenu)
								top.content.CommonToolbar.ShowMenu.click();							
						</script>
					<%
				}
				else
				{
						sql.append("SELECT  SERVICE_CODE,am_get_desc.am_service(SERVICE_CODE,'"+locale+"',2)SERVICE_desc,  TO_CHAR(a.queue_date,'dd/mm/yyyy hh24:mi') visit_adm_date_time   ,a. patient_class   ,a.patient_class Nature,a.LOCN_CODE assign_care_locn_code ,a.LOCN_TYPE assign_care_locn_type  ,a.VISIT_TYPE_CODE adm_type  ,op_get_desc.OP_VISIT_TYPE(facility_id,a.VISIT_TYPE_CODE,'"+locale+"',2) visit_type ,DECODE(a.practitioner_id,'*ALL','',a. practitioner_id) prac_id ,a.referral_id  ,CALCULATE_AGE(TO_CHAR(c.DATE_OF_BIRTH,'DD/MM/YYYY'),1)age ,c.sex,a.arrive_date_time arrive_date_time ,a.vital_signs_date_time vital_signs_date_time,a.VISIT_TYPE_IND visit_adm_type_ind,a.appt_id appt_id  ,a.episode_id episode_id,a.OP_EPISODE_VISIT_NUM episode_visit_num,a.treatment_area_code treatment_area_code  ,a.mlc_yn mlc_yn  ,TO_CHAR(c.DECEASED_DATE,'dd/mm/yyyy hh24:mi') deceased_time  ,a.medical_yn medical_yn  ,a.surgical_yn surgical_yn  ,a.SPECIALITY_CODE SPECIALTY_CODE,TO_CHAR(a.queue_date,'dd/mm/yyyy') queue_date, TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi') sydate  ,am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"',1) practitioner_name FROM  op_patient_queue a ,mp_patient c WHERE a.facility_id = '"+fac_id+"' AND a.encounter_id = '"+P_encounter_id+"' AND a.patient_id=c.patient_id"); 	   		
			
						stmt=con.prepareStatement(sql.toString());
						rs = stmt.executeQuery();
						if(rs!=null && rs.next())
						{                  
								   
							X_visit_type_desc = (rs.getString("visit_type") == null)?"":rs.getString("visit_type");
							X_attend_prac_id = (rs.getString("prac_id") == null)?"":rs.getString("prac_id");
							practitioner_name = (rs.getString("practitioner_name") == null)?"":rs.getString("practitioner_name");

							if(X_attend_prac_id == null)
								X_attend_prac_id="";
							
							P_locn_code = rs.getString("assign_care_locn_code") ;
							if(P_locn_code==null)   P_locn_code = "" ;
							P_locn_type = rs.getString("ASSIGN_CARE_LOCN_TYPE") ;
							if(P_locn_type==null)   P_locn_type = "" ; 							
							referral_id = rs.getString("referral_id");
							if(referral_id == null || referral_id.equals("null")) referral_id = "";
							patient_class=(rs.getString("patient_class")== null)?"":rs.getString("patient_class");
							if(patient_class.equals("EM"))
							episode_type="E";	
							else
							episode_type="O";	 
							
							patientage=Integer.parseInt(rs.getString("age"));
							patientgender=(rs.getString("sex") == null)?"":rs.getString("sex");
							arrive_date_time= (rs.getString("arrive_date_time") == null)?"":rs.getString("arrive_date_time");
							vital_signs_date_time=(rs.getString("vital_signs_date_time") == null)?"":rs.getString("vital_signs_date_time");
							visit_adm_type_ind=(rs.getString("visit_adm_type_ind") == null)?"":rs.getString("visit_adm_type_ind");
							appt_id=(rs.getString("appt_id") == null)?"":rs.getString("appt_id");
							X_episode_id=(rs.getString("episode_id") == null)?"":rs.getString("episode_id");
							visit_type_code=(rs.getString("adm_type") == null)?"":rs.getString("adm_type");
							episode_visit_num =(rs.getString("episode_visit_num") == null)?"":rs.getString("episode_visit_num");

							if(P_ae_treatment_area_code.equals(""))
							{
								P_ae_treatment_area_code=(rs.getString("treatment_area_code") == null)?"":rs.getString("treatment_area_code");
							}
							
							P_practitioner_id=X_attend_prac_id;

							mlc_yn=rs.getString("mlc_yn");
							if(mlc_yn == null) mlc_yn="N";
							deceased_time=rs.getString("deceased_time");
							
							if(deceased_time == null) deceased_time="";

							if(!deceased_time.equals(""))
							{
								dronly="";
								ddis="";
							}
							else
							{
								dronly="readOnly";
								ddis="disabled";
							}
							
							medical_yn=rs.getString("medical_yn");
							if(medical_yn == null) medical_yn="N";

							surgical_yn=rs.getString("surgical_yn");
							if(surgical_yn == null) surgical_yn="N"; 
							
							spec_code=rs.getString("SPECIALTY_CODE");
							if(spec_code == null) spec_code="";
							p_queue_date=rs.getString("queue_date");
							if(p_queue_date == null) p_queue_date="";
							systemdatetime = rs.getString("sydate"); 							
												
							if(patientgender.equals("F"))
							{
								stmt1=con.prepareStatement("select nb_mother_cutoff_age mother_cut_off_age, nb_mother_upper_age mother_max_age,nb_mother_min_age mother_min_age from mp_param");
								rs1=stmt1.executeQuery();
								if(rs1 != null && rs1.next())
								{
									mother_cut_off_age=(rs1.getString("mother_cut_off_age")	== null)?Integer.parseInt("0"):							Integer.parseInt(rs1.getString("mother_cut_off_age"));
									mother_max_age=(rs1.getString("mother_max_age")	== null)?Integer.parseInt("0"):Integer.parseInt(rs1.getString("mother_max_age"));
									mother_min_age=(rs1.getString("mother_min_age")	== null)?Integer.parseInt("0"):Integer.parseInt(rs1.getString("mother_min_age"));

								}

								if(rs1 != null) rs1.close();
								if(stmt1 != null) stmt1.close();
							}              
						 }

						if(rs != null) rs.close();
						if(stmt != null) stmt.close();		
						sql.setLength(0);

						if(called_from.equals("CA") && patient_class.equals("EM"))
						{
							stmt=con.prepareStatement("select PRACT_TYPE from am_practitioner where practitioner_id='"+ca_practitioner_id+"'");
							rs=stmt.executeQuery();
							if(rs != null && rs.next())
							{
								ca_pract_type=rs.getString("PRACT_TYPE");
							}

							
							if(rs != null) rs.close();
							if(stmt != null) stmt.close();
						}
						if((!X_attend_prac_id.equals("") && !patient_class.equals("EM"))  || ((called_from.equals("CA") && !patient_class.equals("EM")) || ((called_from.equals("CA") && patient_class.equals("EM")) && (!ca_pract_type.equals("MD") && !ca_pract_type.equals("SG") && !ca_pract_type.equals("PS") && !ca_pract_type.equals("DN")))))
						{
							P_practitioner_id = X_attend_prac_id;	
						}
						else
						{
							X_pract_assigned_yn = "Y";						
						}  

						stmt=con.prepareStatement("Select short_desc, circumstance_of_injury_code from AM_CIRCUM_OF_INJURY_LANG_VW where language_id='"+locale+"' and eff_status = 'E' order by short_desc ");
						rs = stmt.executeQuery();

						if( rs != null )
						{
							while( rs.next() )
							{
								 circumstance_of_injury = rs.getString( "circumstance_of_injury_code" );  		 
							}
						}

						if(rs != null) rs.close();
						if(stmt != null) stmt.close();

						stmt=con.prepareStatement("select contact_reason_code,contact_reason from am_contact_reason_lang_vw where nvl(REASON_FOR_RECALL_YN,'N') = 'Y' and eff_status='E' and language_id='"+locale+"' order by contact_reason");	
						rs=stmt.executeQuery();
						if(rs != null)
						{
							while(rs.next())
							{
								reason = rs.getString("contact_reason_code");
								
								
							}
						}
						if(rs != null) rs.close();
						if(stmt != null) stmt.close();
							

	%>
					<script> 

						function submitToServlet() {

							if(parent.messageFrame.document.body) {
								parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);	
								parent.messageFrame.document.Checkout_form.submit();
							}
						}

						var HTMLVal  = "<html><form name='Checkout_form' id='Checkout_form'action='../../servlet/eOP.PatCheckoutServlet' method='post'><input type='hidden' name='function_name' id='function_name' value=''><input type='hidden' name='called_from' id='called_from' value='<%=called_from%>'><input type='hidden' name='Encounter' id='Encounter' value='<%=P_encounter_id%>'>	<input type='hidden' name='P_patient_id' id='P_patient_id' value='<%=P_patient_id%>'>						<input type='hidden' name='P_locn_code' id='P_locn_code' value='<%=P_locn_code%>'>						<input type='hidden' name='episode_type' id='episode_type' value='<%=episode_type%>'>						<input type='hidden' name='reg_reff_chkout_yn' id='reg_reff_chkout_yn' value='<%=reg_reff_chkout_yn%>'>			<input type='hidden' name='episode_id' id='episode_id' value='<%=X_episode_id%>'>						<input type='hidden' name='episode_visit_num' id='episode_visit_num' value='<%=episode_visit_num%>'>			<input type='hidden' name='P_practitioner_id' id='P_practitioner_id' value='<%=P_practitioner_id%>'>			<input type='hidden' name='module_id' id='module_id' value='<%=P_module_id%>'><input type='hidden' name='ae_treatment_area_code' id='ae_treatment_area_code' value='<%=P_ae_treatment_area_code%>'><input type='hidden' name='SickLeaveRecordFlag' id='SickLeaveRecordFlag' value='N'><input type='hidden' name='SickLeaveDetails' id='SickLeaveDetails' value=''>	<input type='hidden' name='DECEASED_YN' id='DECEASED_YN' value='<%=deceased_yn%>'> 						<input type='hidden' name='Conclude' id='Conclude' value=''>	   										<input type='hidden' name='medical_yn' id='medical_yn' value='<%=medical_yn%>'>							<input type='hidden' name='surgical_yn' id='surgical_yn' value='<%=surgical_yn%>'>	  					<input type='hidden' name='mlc_yn' id='mlc_yn' value='<%=mlc_yn%>'>	  								<input type='hidden' name='bl_install_yn' id='bl_install_yn' value='N'><input type='hidden' name='deceased_date_time' id='deceased_date_time' value=''><input type='hidden' name='released_date_time' id='released_date_time' value=''> <input type='hidden' name='postmortem_yn' id='postmortem_yn' value='<%=medical_yn%>'><input type='hidden' name='tocomeback' id='tocomeback' value='N'><input type='hidden' name='high_risk_yn' id='high_risk_yn' value='N'><input type='hidden' name='bdead_yn' id='bdead_yn' value='<%=P_ae_brought_dead_yn%>'><input type='hidden' name='days_unit' id='days_unit' value=''><input type='hidden' name='dat_val' id='dat_val' value=''>					<input type='hidden' name='P_locn_type' id='P_locn_type' value='<%=P_locn_type%>'> 						<input type='hidden' name='circumstance_of_injury' id='circumstance_of_injury' value='<%=circumstance_of_injury%>'>	<input type='hidden' name='attending_practitioner' id='attending_practitioner' value='<%=X_attend_prac_id%>'>		<input type='hidden' name='inv_ordered1' id='inv_ordered1' value=''><input type='hidden' name='inv_ordered2' id='inv_ordered2' value=''><input type='hidden' name='inv_ordered3' id='inv_ordered3' value=''>								<input type='hidden' name='disposition_date_time1' id='disposition_date_time1' value='<%=systemdatetime%>'>			<input type='hidden' name='disposition_type' id='disposition_type' value='<%=disposition_type%>'>				<input type='hidden' name='reason' id='reason' value='<%=reason%>'><input type='hidden' name='instructionsrecall' id='instructionsrecall' value=''><input type='hidden' name='pract_assigned_yn' id='pract_assigned_yn' value='<%=X_pract_assigned_yn%>'><!-- <input type='hidden' name='prn_visit_yn' id='prn_visit_yn' value=''>	<input type='hidden' name='prn_visit_before' id='prn_visit_before' value=''> --><input type='hidden' name='p_queue_date' id='p_queue_date' value='<%=p_queue_date%>'><input type='hidden' name='dispReqd' id='dispReqd' value='<%=dispReqd%>'><input type='hidden' name='diagReqd' id='diagReqd' value='<%=diagReqd%>'>		<input type='hidden' name='notesReqd' id='notesReqd' value='<%=notesReqd%>'><input type='hidden' name='arrive_date_time' id='arrive_date_time' value='<%=arrive_date_time%>'><input type='hidden' name='vital_signs_date_time' id='vital_signs_date_time' value='<%=vital_signs_date_time%>'><input type='hidden' name='i_appt_ref_no' id='i_appt_ref_no' value='<%=appt_id%>'><input type='hidden' name='visit_adm_type_ind' id='visit_adm_type_ind' value='<%=visit_adm_type_ind%>'>  <input type='hidden' name='pract_type' id='pract_type' value=''>	  <input type='hidden' name='pract_speciality' id='pract_speciality' value=''><input type='hidden' name='visit_type_code' id='visit_type_code' value='<%=visit_type_code%>'><input type='hidden' name='option_id' id='option_id' value='<%=option_id%>'><input type='hidden' name='close_pat_chart_on_checkout_yn' id='close_pat_chart_on_checkout_yn' value='<%=close_pat_chart_on_checkout_yn%>'></form></html>"; 

						setTimeout("submitToServlet()",200);

						</script> 		
        
<%
				}
				
			}catch(Exception e)
			{
				out.println("Exception::"+e);
				e.printStackTrace();	
			}
			finally
			{
				if(stmt!=null) stmt.close();
				if(rs!=null) rs.close();

				if(stmt1!=null) stmt1.close();
				if(rs1!=null) rs1.close();
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}
%>
				


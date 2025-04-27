<!DOCTYPE html>

<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
    <head>
      <%
	  request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script language='javascript' src='../../eOP/js/OPParameter.js'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/FieldFormatMethods.js' 
		language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    	
		<script>
		function waitListYN(obj)
		{
			 if(obj.checked)
			{
				 obj.value="Y";
				 document.forms[0].wait_list_yn.value="Y";
				 document.getElementById('allow_inv1').style.visibility='visible';
				 document.getElementById('allow_inv2').style.visibility='visible';

			}else
			{
				obj.value="N";
				document.forms[0].wait_list_yn.value="N";
				document.getElementById('allow_inv1').style.visibility='hidden';
				document.getElementById('allow_inv2').style.visibility='hidden';
			}
		}
		
		function invokeDays(obj){
			if(obj.checked){
				obj.value="Y";				
				document.forms[0].visit_backdate_days.disabled = false;
				document.getElementById('backdategif').style.visibility='visible';
			}else{
				obj.value="N";
				document.forms[0].visit_backdate_days.value = "";
				document.forms[0].visit_backdate_days.disabled = true;
				document.getElementById('backdategif').style.visibility='hidden';
			}
		}

		function checkForZero(obj){	  
			if(obj.value == '0' || obj.value == '00'){		 
				alert(getMessage("VALUE_GREAT_ZERO","MP")) ;
				obj.value="";
				obj.focus();
			}
		}//Added by Shanmukh on 29th-JUNE-2018 for ML-MMOH-CRF-1121
	    function change_queue_value(){
				if(document.forms[0].mand_queue_no.checked==true)
				{
					document.forms[0].mand_queue_no_chk_yn.value='Y';
				}
				else
				{
					document.forms[0].mand_queue_no_chk_yn.value='N';			
				}	
			}
			//END
			
		</script>
		<%
            Connection con = null;
			 Boolean isMandQueueNoAppl;//Added by Shanmukh on nd-JULY-2018 for ML-MMOH-CRF-1121
			 Boolean isPatientEncRevokeDeathAppl; // added by mujafar for JULY-2019 for ML-MMOH-CRF-1427
            try{
            con=ConnectionManager.getConnection(request);
            String facilityid= (String) session.getValue("facility_id");
            Statement stmt=null;
            ResultSet rset=null ;
            Statement stmt1=null;
            ResultSet rset1=null ;
            String sql="";
            String sql1="";
            isMandQueueNoAppl = CommonBean.isSiteSpecific(con,"OP","MANDATORY_QUEUE_NO");//Added by Shanmukh on 29th-JUNE-2018 for ML-MMOH-CRF-1121
			isPatientEncRevokeDeathAppl = CommonBean.isSiteSpecific(con,"MP","PATIENT_ENC_REVOKE_DEATH"); // added by mujafar  for ML-MMOH-CRF-1427 
			String dispTypeForRevokeDeath=""; // added by mujafar  for ML-MMOH-CRF-1427
			/*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
			Boolean isNationalIdValidationAppl = CommonBean.isSiteSpecific(con, "MP", "NATIONAL_ID_VALIDATION"); 
            Boolean isclinicCategory = CommonBean.isSiteSpecific(con, "OP", "CLINIC_CATEGORY");
			String validate_natid_reg_visit = "";
			String validate_natid_chk = "";
			 /*End MO-CRF-20148*/
             String functionname="insert";
		     //String ca_install="N"; 
            String VisitControl="";
            String VisitCompletion="";
            String Disposition ="";
            String PDiagnosis="";
            String notes="";
            String BOEpisode="";
            String FollowUp="";
            String NoFollowUp="";
            String Group="";
            String OntimeApptStatus="";
            String NoshowApptStatus="";
            String DispositionType="";
            String dispTypeForCheckout="";
            String chkval="";
            String selval="";
            String RefreshInterval="";
            String BlInterfaceYN = "N";
            String ca_install_yn= "N";
            String template_yn="N";
            String InstallYN = (String)session.getValue("bl_operational");
			if(InstallYN == null) InstallYN="";
			String emer_pat_yn="";
			String emer_pat_yn_chk="";
			String override_episode = "Y";
			String override_chk_val = "Checked";
					
			String ALLOW_WL_INV_WO_APPT_YN="N";
			String inc_arrive_cons_start_pats_yn="N";
			String inc_arrive_cons_start_pats__chk="N";
			String mins1_for_wait_time= "";
			String mins2_for_wait_time= "";
			String checkval="";		
			String accept_dis_inv_no="";
			String selAcc = "";
			String selDis = "";
			String allow_inv_style = ""; 			
			String VISIT_BACKDATE_DAYS = "";
			String selManual = "";
			String selSystem = "";
			String ASSIGN_QUEUE_NUM_BY = "";
			
			// Added against Bru-HIMS-CRF-179-DD1
			String CALC_WAIT_TIME_BASED_ON = ""; 
			String selVitalSign = "";
			String selArrived = "";
			String selCheckedIn = "";
			
			String override_pract_for_appt_yn = "";
			String override_pract_chk = "";
			String reg_visit_for_inpat_yn = "";
			String reg_visit_for_inpat_chk = "";
			String inv_visitregn_mpq_from_ca_yn = "";
			String inv_visitregn_mpq_from_ca_chk = "";
			String inv_visitregn_mpq_from_ca_disb = "";
            String  Max_dur_allow="" ;
		    String  Max_no_visit="" ;
		    String  visit_type_derv_rule="S" ;
		    String  serviceDisplay="" ;
		    String  practDisplay="" ;
		 	// MMS-QH-CRF- 0041.1 changes - start 
		    String  Pract_disDervRule="";
		    String  Serv_disDervRule="";
		    String  Insur_disDervRule="";
			
		    String  dfltruleid="" ;
		    //String  disDervRule="" ;
		    // MMS-QH-CRF- 0041.1 changes - end 
            String registre_reff_yn="";				
			String clo_pat_onclos_opchk_yn="";			
			String image1="";			
			String image3="";			
			String image6="";			
			String image8="";			
			String image5="";			
			String image7="";			
			String visit_backdating_allowed_yn="N";			
			String visit_backdating_allowed_chk="";			
			String backDatingDays="disabled";			
			//Maheshwaran K added for the Bru-HIMS-CRF-170(IN030289) as on 06/08/2013
			//Start
			String episode_closure_by="";
			String episode_closure_style="disabled";
			String episode_closure_days="";
			String episode_closure_pract="";
			String episode_closure_insu="";
			String episode_closure_noshow="";
			//End
			String selWarning 			= "";
			String selStop				= "";
			String selNoAction			= "";
			String ACTION_ON_PENDING_BILL = "";
			
			//Added by Ajay for MMS-DM-CRF-0209.4
			String cliniccatagory="N";//added manju
			String cliniccatagory_checked="N";
            		String clinicCatagoryman="N";
            		String clinicCatagoryman_checked="N";
			String clinicCatMandDisabled = "disabled";
			String clinicReffReqVal = "";
			String clinicReffReqValChecked = "";
			/* Added For JD-CRF-0183 [IN:041353] by Dharma on Nov 14th 2013 start*/
			String selWarningforpract	= "";
			String selStopforpract		= "";
			String selNoActionforpract	= "";
			String action_on_pract_schedule = "";
			/* Added For JD-CRF-0183 [IN:041353] by Dharma on Nov 14th 2013 end*/
			String mand_queue_no="";//Added by Shanmukh on 29th-JUNE-2018 for ML-MMOH-CRF-1121
			String mand_queue_no_chk_yn="";//Added by Shanmukh on 29th-JUNE-2018 for ML-MMOH-CRF-1121
	        
			try
			{                
                /* The sql query takes all the op_parameter values based on the facility id value; these values are being displayed as default values  --- Srijagadeesh. */
				sql1="select install_yn installyn from sm_module where module_id='CA'";
				stmt1=con.createStatement();
				rset1=stmt1.executeQuery(sql1);
				if(rset1!=null)
                {
                    if(rset1.next())
                    {
						ca_install_yn = rset1.getString("installyn")==null?"":rset1.getString("installyn");
					}
				}
				      //Start
				           if(visit_type_derv_rule.equals("P")){
								serviceDisplay = "display:none";
								practDisplay   = "display:";
							}else if(visit_type_derv_rule.equals("S")){
								serviceDisplay = "display:";
								practDisplay   = "display:none";
							}else if(visit_type_derv_rule.equals("B")){
								serviceDisplay = "display:none";
								practDisplay   = "display:none";
							}
			    		//End
				

				sql="select * from op_param where operating_facility_id='"+facilityid+"'";
				
                stmt= con.createStatement();
                rset=stmt.executeQuery(sql);
				
				
                if(rset!=null)
                {
                    if(rset.next())
                    {
						 functionname="modify";
                         
					 Max_no_visit=rset.getString("NO_OF_FOLLOW_UP_VISITS_ALLOWED");                     
								if(Max_no_visit==null)		Max_no_visit="";
					
					 visit_type_derv_rule=rset.getString("visit_type_derv_rule");                     
								if(Max_no_visit==null)		Max_no_visit="";
					
					 dfltruleid=rset.getString("dflt_rule_id");                     
								if(Max_no_visit==null)		Max_no_visit="";

					 inc_arrive_cons_start_pats_yn=rset.getString("inc_arrive_cons_start_pats_yn");                     
								if(inc_arrive_cons_start_pats_yn==null)		inc_arrive_cons_start_pats_yn="";

					 if(inc_arrive_cons_start_pats_yn.equals("Y"))						
						inc_arrive_cons_start_pats__chk = "checked";						
					 else
						inc_arrive_cons_start_pats__chk = "";							

					 Max_dur_allow=rset.getString("DUR_FOR_FOLLOW_UP_VSTS_IN_DAYS");
								if(Max_dur_allow==null)		Max_dur_allow="";
						 				 						 
					 VisitControl=rset.getString("VISIT_REV_CANCEL_DAYS");
                             if(VisitControl==null)		VisitControl="";	 
							//Added by Ajay for MMS-DM-CRF-0209.4
							clinicReffReqVal = rset.getString("REFERRAL_REQ_YN");
							if(clinicReffReqVal.equals("Y")){ 
								clinicReffReqValChecked = "checked";
							}
							 cliniccatagory=rset.getString("CLINIC_CATAGORY_YN");
							 
                               if(cliniccatagory==null)		cliniccatagory="";
                      
					if(cliniccatagory.equals("Y")){						
							cliniccatagory_checked = "checked";
							clinicCatMandDisabled = " ";
					}
					else{
						cliniccatagory_checked= "";
					}
					  clinicCatagoryman=rset.getString("CLINIC_CATAGORY_MAND_YN");
							 
                    if(clinicCatagoryman==null)		clinicCatagoryman="";
                      
					if(clinicCatagoryman.equals("Y"))						
						clinicCatagoryman_checked = "checked";						
					else
						clinicCatagoryman_checked= "";
					VisitCompletion=rset.getString("VISIT_COMPL_DAYS");
                            if(VisitCompletion==null)	VisitCompletion="";
                      Disposition =rset.getString("DISP_REQD_FOR_MDS_YN");
                            if(Disposition==null)		Disposition="";
                     PDiagnosis=rset.getString("DIAG_REQD_FOR_MDS_YN");
                            if(PDiagnosis==null)		PDiagnosis="";
                     notes=rset.getString("NOTES_REQD_FOR_MDS_YN");
                            if(notes==null)				notes="";
                     BOEpisode=rset.getString("BUILD_EPISODE_YN");
                            if(BOEpisode==null)			BOEpisode="";
                     FollowUp=rset.getString("EPISODE_CLOSE_DAYS_FU");
                            if(FollowUp==null)			FollowUp="";
                     registre_reff_yn=rset.getString("REG_REFERRAL_ON_CHECKOUT_YN");
						 if(registre_reff_yn==null)			registre_reff_yn="N";
				     clo_pat_onclos_opchk_yn=rset.getString("CLOSE_PAT_CHART_ON_CHECKOUT_YN");
						 if(clo_pat_onclos_opchk_yn==null)	clo_pat_onclos_opchk_yn="N";
					 NoFollowUp=rset.getString("EPISODE_CLOSE_DAYS_WO_FU");
                            if(NoFollowUp==null)		NoFollowUp="";
				     Group=rset.getString("VITAL_SIGNS_BATTERY_ID");
							if(Group==null)				Group=""    ;
					ALLOW_WL_INV_WO_APPT_YN=rset.getString("ALLOW_WL_INV_WO_APPT_YN");
						if(ALLOW_WL_INV_WO_APPT_YN==null) ALLOW_WL_INV_WO_APPT_YN="N";

						if(ALLOW_WL_INV_WO_APPT_YN.equals("Y"))
						{
							checkval="checked";
						}else
						{
							checkval="";
						}


						OntimeApptStatus=rset.getString("CI_PERIOD_IN_MIN_FOR_ONTIME");
                            if(OntimeApptStatus==null)	OntimeApptStatus="";
						

                         NoshowApptStatus=rset.getString("CI_PERIOD_IN_MIN_FOR_NOSHOW");
                            if(NoshowApptStatus==null)	NoshowApptStatus="";
						

                         DispositionType=rset.getString("DISP_TYPE_FOR_AUTO_VISIT_COMPL");
                            if(DispositionType==null)	DispositionType="";

							

						dispTypeForCheckout=rset.getString("DISP_TYPE_FOR_CHECKOUT")==null?"":rset.getString("DISP_TYPE_FOR_CHECKOUT");
          dispTypeForRevokeDeath =rset.getString("REVOKE_DEATH_DISP_TYPE")==null?"":rset.getString("REVOKE_DEATH_DISP_TYPE"); 	// added by mujafar  for ML-MMOH-CRF-1427  					 
						 			 
                         RefreshInterval=rset.getString("QUEUE_REFRESH_INTERVAL");
                            if(RefreshInterval==null)	RefreshInterval="";

						template_yn=rset.getString("USE_TEMPLATE_IN_VIS_REGN_YN");
						if(template_yn==null) template_yn="N";

                         BlInterfaceYN =rset.getString("BL_INTERFACED_YN");
                            if(BlInterfaceYN == null)		BlInterfaceYN="N";

						emer_pat_yn=rset.getString("ALLOW_EMER_REGN_YN");
							if(emer_pat_yn!=null && emer_pat_yn.equals("N"))
						{
								emer_pat_yn_chk="";
							
						}
							else
						{
								emer_pat_yn_chk="checked";
							
						}						

						override_episode=rset.getString("OVERRIDE_VTYPE_ON_EPSD_YN");
							if(override_episode==null)		override_episode="N";    

							if(override_episode.equals("Y") && !visit_type_derv_rule.equals("B"))
						{
							override_chk_val = "Checked"; 
							image1 = "visibility:hidden";
							image3 = "visibility:hidden";
							image6 = "visibility:visible";
							image8 = "visibility:visible";
							image5 = "visibility:visible";
							image7 = "visibility:visisble";
							//MMS-QH-CRF- 0041.1 changes
							Serv_disDervRule  = "disabled";
							Insur_disDervRule = "disabled";
							//serviceDisplay = "display:inline";
							//practDisplay   = "display:none";							
							if(visit_type_derv_rule.equals("P")){
							    serviceDisplay = "display:none";
							    practDisplay   = "display:inline";
							}else if(visit_type_derv_rule.equals("S")){
							    serviceDisplay = "display:display";
							    practDisplay   = "display:none";
							}else if(visit_type_derv_rule.equals("B")){
								serviceDisplay = "display:none";
								practDisplay   = "display:none";
							}
						}
							else
						{						
							override_chk_val = "UnChecked";
							image1 = "visibility:visible";
							image3 = "visibility:visible";
							image6 = "visibility:hidden";
							image8 = "visibility:hidden";
							image5 = "visibility:hidden";
							image7 = "visibility:hidden";
							//MMS-QH-CRF- 0041.1 changes
							Serv_disDervRule = "";
							Insur_disDervRule = "";
							
							// MMS-QH-CRF- 0041.1 changes start - added InsuranceGroup option 
							if(visit_type_derv_rule.equals("P")){
								serviceDisplay = "display:none";
								practDisplay   = "display:";
							}else if(visit_type_derv_rule.equals("S")){
								serviceDisplay = "display:";
								practDisplay   = "display:none";
							}else if(visit_type_derv_rule.equals("B")){
								serviceDisplay = "display:none";
								practDisplay   = "display:none";
							}
						}
						
						accept_dis_inv_no = rset.getString("ACCEPT_DISPLAY_INV_NO") == null ? " " :  												rset.getString("ACCEPT_DISPLAY_INV_NO");
						if(accept_dis_inv_no.equals("A"))
							selAcc = "selected";
						else if(accept_dis_inv_no.equals("D"))
							selDis = "selected";

						ASSIGN_QUEUE_NUM_BY = rset.getString("ASSIGN_QUEUE_NUM_BY") == null ? " " :  												rset.getString("ASSIGN_QUEUE_NUM_BY");
						if(ASSIGN_QUEUE_NUM_BY.equals("M"))
							selManual = "selected";
						else if(ASSIGN_QUEUE_NUM_BY.equals("S"))
							selSystem = "selected";

						//Added against Bru-HIMS-CRF-179-DD1
						CALC_WAIT_TIME_BASED_ON = rset.getString("CALC_WAIT_TIME_BASED_ON") == null ? " " :  												rset.getString("CALC_WAIT_TIME_BASED_ON");
						if(CALC_WAIT_TIME_BASED_ON.equals("01"))
							selCheckedIn = "selected";
						else if(CALC_WAIT_TIME_BASED_ON.equals("02"))
							selArrived = "selected";
						else
							selCheckedIn = "selected";
							
						override_pract_for_appt_yn = rset.getString("OVERRIDE_PRACT_FOR_APPT_YN") == null ? "N" :					                                          rset.getString("OVERRIDE_PRACT_FOR_APPT_YN");

						if(override_pract_for_appt_yn.equals("Y"))						
							override_pract_chk="checked";						
						else
							override_pract_chk="";	

						/*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
						validate_natid_reg_visit = rset.getString("VALIDATE_NATID_REG_VISIT") == null ? "N" :					                                          rset.getString("VALIDATE_NATID_REG_VISIT");
						if(validate_natid_reg_visit.equals("Y"))						
							validate_natid_chk="checked";						
						 /*End MO-CRF-20148*/
						reg_visit_for_inpat_yn = rset.getString("REG_VISIT_FOR_INPAT_YN") == null ? "N" :					                                          rset.getString("REG_VISIT_FOR_INPAT_YN");						

						if(reg_visit_for_inpat_yn.equals("Y"))						
							reg_visit_for_inpat_chk = "checked";						
						else
							reg_visit_for_inpat_chk = "";
						
						inv_visitregn_mpq_from_ca_yn  = rset.getString("INV_VISITREGN_MPQ_FROM_CA_YN") == null ? "N" :					                                     rset.getString("INV_VISITREGN_MPQ_FROM_CA_YN");					
						
						VISIT_BACKDATE_DAYS = rset.getString("VISIT_BACKDATE_DAYS") == null ? "" :	rset.getString("VISIT_BACKDATE_DAYS");
						visit_backdating_allowed_yn = rset.getString("VISIT_BACKDATING_ALLOWED_YN")==null?"N":rset.getString("VISIT_BACKDATING_ALLOWED_YN");
						mins1_for_wait_time = rset.getString("mins1_for_wait_time") == null ? "" :rset.getString("mins1_for_wait_time");
						mins2_for_wait_time = rset.getString("mins2_for_wait_time") == null ? "" :rset.getString("mins2_for_wait_time");
						ACTION_ON_PENDING_BILL = rset.getString("ACTION_ON_PENDING_BILL") == null ? "N" :rset.getString("ACTION_ON_PENDING_BILL");
					
						action_on_pract_schedule = 	rset.getString("action_on_pract_schedule") == null ? "N" :rset.getString("action_on_pract_schedule"); /* Added For JD-CRF-0183 [IN:041353] by Dharma on Nov 14th 2013*/
						
						
						//Maheshwaran K added for the Bru-HIMS-CRF-170(IN030289) as on 06/08/2013
						//Start
						episode_closure_by = rset.getString("EPISODE_CLOSURE_BY") == null ? "" :rset.getString("EPISODE_CLOSURE_BY");
						if((episode_closure_by.equals("D"))||(episode_closure_by.equals("")))
						episode_closure_days="selected";
						/*if(episode_closure_by.equals("P"))
						episode_closure_pract="selected";
						if(episode_closure_by.equals("I"))
						episode_closure_insu="selected";*/
						if(episode_closure_by.equals("N"))
						episode_closure_noshow="selected";
						if(episode_closure_by.equals(""))
						episode_closure_style="";
						//End
                        if(ca_install_yn.equals("Y"))	
						{
							inv_visitregn_mpq_from_ca_disb = "";

							if(inv_visitregn_mpq_from_ca_yn.equals("Y"))						
								inv_visitregn_mpq_from_ca_chk = "checked";						
							else
								inv_visitregn_mpq_from_ca_chk = "";
						}								
						else
						{
							inv_visitregn_mpq_from_ca_chk = "";
							inv_visitregn_mpq_from_ca_disb = "disabled";
						}
						//Added by Shanmukh on 29th-JUNE-2018 for ML-MMOH-CRF-1121
						mand_queue_no = rset.getString("QUEUE_NO_MNDT_YN") == null ? "N": rset.getString("QUEUE_NO_MNDT_YN");
					   
                    }					
                }   
				
				if(visit_backdating_allowed_yn.equals("Y")){						
					visit_backdating_allowed_chk = "checked";	
					backDatingDays = "";
				}else{
					visit_backdating_allowed_chk = "";
					backDatingDays = "disabled";
				}
			
				
				if(ACTION_ON_PENDING_BILL.equals("W"))
					selWarning = "selected";
				else if(ACTION_ON_PENDING_BILL.equals("S"))
					selStop = "selected";
				else if(ACTION_ON_PENDING_BILL.equals("N"))
					selNoAction = "selected";
				
				
				/* Added For JD-CRF-0183 [IN:041353] by Dharma on Nov 14th 2013 Start*/
				if(action_on_pract_schedule.equals("W"))
					selWarningforpract = "selected";
				else if(action_on_pract_schedule.equals("S"))
					selStopforpract = "selected";
				else if(action_on_pract_schedule.equals("N"))
					selNoActionforpract = "selected";
				/* Added For JD-CRF-0183 [IN:041353] by Dharma on Nov 14th 2013 end*/

				
				if(functionname.equals("modify")){
					Pract_disDervRule="disabled";
					Serv_disDervRule="disabled";
					Insur_disDervRule="disabled";
				}else{
					Pract_disDervRule="";
					Serv_disDervRule="";
					Insur_disDervRule="";
				}
				// MMS-QH-CRF- 0041.1 changes end - added InsuranceGroup option 

			  if (stmt != null) stmt.close();
              if (rset != null) rset.close();
			  if (stmt1 != null) stmt1.close();
              if (rset1 != null) rset1.close();
			}catch(Exception e) { out.println(e.toString()); e.printStackTrace();}
            finally
            {
                if (stmt != null) stmt.close();
                if (rset != null) rset.close();
				if (stmt1 != null) stmt1.close();
				if (rset1 != null) rset1.close();
            }
        
		
		%>
    </head>

    <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();' >
        <form name='OPParameter_form' id='OPParameter_form' method='post' action='../../servlet/eOP.OPParameterServlet' target='messageFrame'>
        <div align='center'>
            <table width='100%' cellpadding='3' align='center' cellspacing=0>    
                <tr>
                    <td>
                        <table width='100%' cellpadding='0' cellspacing=0  align='center' border=0>
                                <th  class="columnHeader" align="left"><fmt:message key="Common.VisitControls.label" bundle="${common_labels}"/></th>
						</table>
						<table width='100%' cellpadding='3' cellspacing=0  align='center' border=0>
						<tr>
                                <td class='label' width='40.7%'><fmt:message key="eOP.AllowbackdatingVisitDateTime.label" bundle="${op_labels}"/></td>
                                <td class='fields' width='3%'><input type='checkbox' name='visit_backdating_allowed_yn' id='visit_backdating_allowed_yn' onclick='invokeDays(this)' value='<%=visit_backdating_allowed_yn%>'  <%=visit_backdating_allowed_chk%>>		
								</td>
								 <td class='label' width='5%'><fmt:message key="Common.within.label" bundle="${common_labels}"/></td>
                                <td class='fields' width='52%'><input type='text' name='visit_backdate_days' id='visit_backdate_days' onBlur='CheckNum(this);checkForZero(this)'  onKeyPress='return(ChkNumberInput(this,event,0))' maxlength=2 size=2 value='<%=VISIT_BACKDATE_DAYS%>' <%=backDatingDays%>><img id='backdategif' src='../../eCommon/images/mandatory.gif'><fmt:message key="Common.days.label" bundle="${common_labels}"/>	
								</td>
						</tr>
						<table>

						<table width='100%' cellpadding='3' cellspacing=0  align='center' border=0>
                            <tr>
                                <td class='label' width='40.7%'><fmt:message key="eOP.MaxNoofdaysforvisitreviscancel.label" bundle="${op_labels}"/></td>
                                <td class='fields' width='18%'><input type='text' name='Visit_Control' id='Visit_Control' maxlength=6 size=6 onBlur='CheckNum(this)' value='<%=VisitControl%>'   onKeyPress='return(ChkNumberInput(this,event,0))'><img src='../../eCommon/images/mandatory.gif'></img></td>                                  
								<% 
								if(checkval.equals("checked"))
								{
									allow_inv_style = "visibility:visible";									
								} 
								else 									
								{
									allow_inv_style = "visibility:hidden";									
								}
								%>	
								<td width='30%' class='label' id='allow_inv1' style='<%=allow_inv_style%>'><fmt:message key="eOP.AllowInvitationNo.label" bundle="${op_labels}"/></td>
								<td class='fields' id='allow_inv2' style='<%=allow_inv_style%>' width='12%'><select name='allow_inv_no' id='allow_inv_no'><option value='A' <%=selAcc%> >&nbsp;<fmt:message key="Common.Accept.label" bundle="${common_labels}"/> &nbsp;</option>
								<option value='D' <%=selDis%> >&nbsp;<fmt:message key="Common.display.label" bundle="${common_labels}"/>&nbsp;</option></select>
								</td>
							</tr>
							<tr>			
								<td class='label'><fmt:message key="eOP.AlwVstRegForEmerSerPatients.label" bundle="${op_labels}"/></td>
                                <td class='fields' ><input type='checkbox' name='emer_pat_chk_yn' id='emer_pat_chk_yn' value="<%=emer_pat_yn%>" onclick='change_value();' <%=emer_pat_yn_chk%> ><input type='hidden' name='emer_pat_yn' id='emer_pat_yn' value="" ></td>

								<td class='label'><fmt:message key="eOP.AlwVstRegForInPatients.label" bundle="${op_labels}"/></td>
                                <td class='fields'><input type='checkbox' name='reg_visit_for_inpat_yn' id='reg_visit_for_inpat_yn' 				value='<%=reg_visit_for_inpat_yn%>'  <%=reg_visit_for_inpat_chk%> >		
								</td>												
                            </tr>
							<tr>
                                <td class='label'><fmt:message key="eOP.AllowVisitRegWaitListInvwithoutAppt.label" bundle="${op_labels}"/></td>
                                <td class='fields' ><input type='checkbox' name='wait_list' id='wait_list' value='<%=ALLOW_WL_INV_WO_APPT_YN%>'  <%=checkval%> onclick='waitListYN(this);'>
								<input type='hidden' name='wait_list_yn' id='wait_list_yn' value='<%=ALLOW_WL_INV_WO_APPT_YN%>'></td>

								<td class='label'><fmt:message key="eOP.VisitDtlsTemplate.label" bundle="${op_labels}"/></td>
                                <td class='fields'>						
						        <%if(template_yn.equals("Y")){ %>
					                	<input type='checkbox' name='ean_vst_dtls_temp_yn' id='ean_vst_dtls_temp_yn' value='Y' checked  >	
					            <%} else {%>
						            <input type='checkbox' name='ean_vst_dtls_temp_yn' id='ean_vst_dtls_temp_yn' value='Y' >	
						         <%}%>
						        </td>																
							</tr>											
							<tr>
                                <td class='label'><fmt:message key="eOP.InvokeVisRegnFromCA.label" bundle="${op_labels}"/></td>
                                <td class='fields' ><input type='checkbox' name='inv_visitregn_mpq_from_ca_yn' id='inv_visitregn_mpq_from_ca_yn' 					value='<%=inv_visitregn_mpq_from_ca_yn%>'  <%=inv_visitregn_mpq_from_ca_chk%> <%=inv_visitregn_mpq_from_ca_disb%>>		
								</td>
								<td class='label'><fmt:message key="eOP.OverridePractForAppt.label" bundle="${op_labels}"/></td>
                                <td class='fields'><input type='checkbox' name='override_pract_for_appt_yn' id='override_pract_for_appt_yn' 										value='<%=override_pract_for_appt_yn%>'  <%=override_pract_chk%> >		
								</td>
								</tr> 	
								
								<!--  Added For JD-CRF-0183 [IN:041353] by Dharma on Nov 14th 2013  Start-->							
								<tr>
	                                <td class='label'><fmt:message key="eOP.ActiononVisitRegistrationPractitionerScheduleisblocked.label" bundle="${op_labels}"/></td>
	                                <td class='fields'  colspan=2>
	                                	<select name='action_on_pract_schedule' id='action_on_pract_schedule'>
											<option value='N' <%=selNoActionforpract%>>No Action</option>					
											<option value='W' <%=selWarningforpract%> >Warning</option>
											<option value='S' <%=selStopforpract%> >Stop</option>
										</select>		
									</td>
								</tr>
								<!--  Added For JD-CRF-0183 [IN:041353] by Dharma on Nov 14th 2013  End--> 
								<!--Added by Ashwini on 06-Mar-2019 for MO-CRF-20148-->
								<%if(isNationalIdValidationAppl){%>
								<tr>
									<td class='label'><fmt:message key="eOP.ValidateNatIDRegVisit.label" bundle="${op_labels}"/></td>
									<td class='fields'><input type='checkbox' name='validate_natid_reg_visit' id='validate_natid_reg_visit' value='<%=validate_natid_reg_visit%>' <%=validate_natid_chk%>></td>
								</tr>
								<%}%>
								<!--End MO-CRF-20148-->
													
						</table>
                    </td>
                </tr> 
				<tr>
                    <td>
                    <table width='100%' cellpadding=0  cellspacing=0 border=0>
                    <tr>
                    <th class="columnHeader" align="left"><fmt:message key="eOP.VisitCompletion.label" bundle="${op_labels}"/></td>
                            </tr>
					</table>
						<table width='100%' cellpadding='3' cellspacing=0  align='center' border=0>
                            <tr>
                                <td width='40.7%' class='label'><fmt:message key="eOP.MaxNoofdaysforvisitcompletion.label" bundle="${op_labels}"/></td>
                                <td class='fields' width='18%'><input type='text' name='Visit_Completion' id='Visit_Completion' maxlength='6' size='6' onBlur='CheckNum(this)' value='<%=VisitCompletion%>' 
								onKeyPress='return(ChkNumberInput(this,event,0))' ><img src='../../eCommon/images/mandatory.gif'></td> 
								<td width='30%' class='label'><fmt:message key="eOP.RegReflOnClsCons.label" bundle="${op_labels}"/> </td>
                                <td class='fields' width='12%'>
									
					            <%if(registre_reff_yn.equals("Y")){ %>
					            <input type='checkbox' name='registre_reff_yn' id='registre_reff_yn' value='Y' checked>
						        <%}else {%>		
						 		<input type='checkbox' name='registre_reff_yn' id='registre_reff_yn' value='Y' >
								<%}%>								
								</td>												
								</tr>									
								<tr>
								<td width='40.7%' class='label'><fmt:message key="eOP.DispTypeForCloseConsCheckOut.label" bundle="${op_labels}"/>
                                    </td>
                                    <td class='fields' width='18%' ><select name='DISP_TYPE_FOR_CHECKOUT' id='DISP_TYPE_FOR_CHECKOUT' >
                                            <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
										<%
						                try{ 	
						
										  sql="select disp_type, short_desc from am_disposition_type where eff_status='E' and use_at_concl_yn='Y' and DECEASED_YN = 'N' order by 2";

										 stmt=con.createStatement();
										 rset=stmt.executeQuery(sql);
										 if(rset!=null) {
										 String id1="";
										 String val1="";
										 
										 while(rset.next()) {
											 id1=rset.getString("disp_type");
											 val1=rset.getString("short_desc");
											 if(id1.equals(dispTypeForCheckout))
											   selval="selected";
											 
											 out.print("<option value='"+id1+"' "+selval+">"+val1+"</option>");
											 selval="";
										 }
										 }
										 }catch(Exception e) { out.println(e.toString());e.printStackTrace();}
										 finally
										 {
											 if (stmt != null) stmt.close();
											 if (rset != null) rset.close();
										 }
				           %>
                    </select><img id=id1 src='../../eCommon/images/mandatory.gif' style="visibility:hidden;">
                    </td>
                                <td class='label'><fmt:message key="eOP.ClosePatChart.label" bundle="${op_labels}"/> </td>
                                <td class='fields'>
							
								<%if(ca_install_yn.equals("Y"))	{
								if(clo_pat_onclos_opchk_yn.equals("Y")) {%>								
								   <input type='checkbox' name='clo_pat_cha_clo_con_yn' id='clo_pat_cha_clo_con_yn' 	value='Y' checked>		
								<%} else{%>             
									<input type='checkbox' name='clo_pat_cha_clo_con_yn' id='clo_pat_cha_clo_con_yn' value='Y'>														
								<%}}else{%>
								<input type='checkbox' name='clo_pat_cha_clo_con_yn' id='clo_pat_cha_clo_con_yn' 	disabled value='N'>	
								<%}%>							
						</td>
							</tr>
							
							<tr>
							
							<%
								if(isPatientEncRevokeDeathAppl)
								{ // Added by mujafar for ML-MMOH-CRF-1427
								%>	
									<td  class='label'><fmt:message key="eOP.DispTypeFOrOPEncounterRevokeDeath.label" bundle="${op_labels}"/>
                                    </td>
                                    <td class='fields'   ><select name='DISP_TYPE_FOR_REVOKE_DEATH' id='DISP_TYPE_FOR_REVOKE_DEATH' >
                                            <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
										<%
						                try{ 	
						
										  sql="select disp_type, short_desc from am_disposition_type where eff_status='E' and use_at_concl_yn='Y' and DECEASED_YN = 'N' order by 2";

										 stmt=con.createStatement();
										 rset=stmt.executeQuery(sql);
										 if(rset!=null) {
										 String id1="";
										 String val1="";
										 
										 while(rset.next()) {
											 id1=rset.getString("disp_type");
											 val1=rset.getString("short_desc");
											 if(id1.equals(dispTypeForRevokeDeath))
											   selval="selected";
											 
											 out.print("<option value='"+id1+"' "+selval+">"+val1+"</option>");
											 selval="";
										 }
										 }
										 }catch(Exception e) { out.println(e.toString());e.printStackTrace();}
										 finally
										 {
											 if (stmt != null) stmt.close();
											 if (rset != null) rset.close();
										 }
				           %>
							</select>
							</td>
									
									
								<%}%>	
							
							
							
							</tr>
							
							
							
							
							
                        </table>
                    </td>
                </tr>	 
				
               <tr>
                    <td>
                        <table width='100%' cellpadding=0 cellspacing=0>
                                <th class="columnHeader" align="left"><fmt:message key="eOP.OutpatientEpisodes.label" bundle="${op_labels}"/></td>							
						</table>
						<table width='100%' cellpadding=0 cellspacing=0>
                      <tr>
						<td width='40.7%' class='label'> <fmt:message key="eOP.VisitTypeDerivationRule.label" bundle="${op_labels}"/></td>
							<td class='fields' width='40.7%'>
								<%if(visit_type_derv_rule.equals("P")){%>
									<input type='radio' value='P' name='visit_type_derv_rule' id="radioPract" checked <%=Pract_disDervRule%> onclick='visitTypeRule(this)'>&nbsp;<fmt:message key="eOP.PractitionerBased.label" bundle="${op_labels}"/>
									<%}else{%>
									<input type='radio' value='P' name='visit_type_derv_rule' id="radioPract" <%=Pract_disDervRule%> onclick='visitTypeRule(this)'>&nbsp;<fmt:message key="eOP.PractitionerBased.label" bundle="${op_labels}"/>
									<%}
									if(visit_type_derv_rule.equals("S")){	%>
									<input type='radio' value='S' name='visit_type_derv_rule' id="radioService" checked <%=Serv_disDervRule%> onclick='visitTypeRule(this)'><fmt:message key="eOP.ServiceBased.label" bundle="${op_labels}"/>	
									<%} else{%>
									<input type='radio' value='S' name='visit_type_derv_rule' id="radioService" <%=Serv_disDervRule%> onclick='visitTypeRule(this)'><fmt:message key="eOP.ServiceBased.label" bundle="${op_labels}"/>	
									<%}		%>
									
									<%if(visit_type_derv_rule.equals("B")){	%>
									<input type='radio' value='B' name='visit_type_derv_rule' id="radioInsurance" checked <%=Insur_disDervRule%> onclick='visitTypeRule(this)'><fmt:message key="eOP.InsuranceGroup.label" bundle="${op_labels}"/>	
									<%} else{%>
									<input type='radio' value='B' name='visit_type_derv_rule' id="radioInsurance" <%=Insur_disDervRule%> onclick='visitTypeRule(this)'><fmt:message key="eOP.InsuranceGroup.label" bundle="${op_labels}"/>	
									<%}	
									%>
									<input type = 'hidden' name = 'visit_type_derv_rule_hdn' id='visit_type_derv_rule_hdn' value = <%=visit_type_derv_rule%>>
									
								</td>
								<td class='label' width='20%'>&nbsp;</td>
								  </tr>							
						</table>
					</td>
					<tr id = 'practitionerbased' style = <%=practDisplay%>>
					<td>
						<table width='100%' cellpadding=3 cellspacing=0 border=0>							
							<tr>
                                    <td width='40.7%' class='label'><fmt:message key="eOP.DefalutRuleID.label" bundle="${op_labels}"/>	
                                    </td>
                                    <td class='fields' width='40.7%' ><select name='dfltruleid' id='dfltruleid' >
                                            <option value=''>&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --&nbsp;</option>
										<%
						                try{ 	
						
										  sql="select rule_id, rule_desc from op_visit_rule where eff_status='E' order by 2";

										 stmt=con.createStatement();
										 rset=stmt.executeQuery(sql);
										 if(rset!=null)
										 {
										 String id1="";
										 String val1="";
										 
										 while(rset.next())
										 {
											 id1=rset.getString("rule_id");
											 val1=rset.getString("rule_desc");
											 if(id1.equals(dfltruleid))
											   selval="selected";
											 
											 out.print("<option value='"+id1+"' "+selval+">"+id1+"</option>");
											 selval="";
										 }
										 }
										 }catch(Exception e) { out.println(e.toString());e.printStackTrace();}
										 finally
										 {
											 if (stmt != null) stmt.close();
											 if (rset != null) rset.close();
										 }
				           %>
                    </select><img id=id1 src='../../eCommon/images/mandatory.gif'>
                    </td>
					<td class='label' width='30%'>&nbsp;</td>
					<td class='label' width='12%'>&nbsp;</td>
					</tr>
							
						</table>
						</td>
					</tr>				
				<tr id = 'servicebased' style = <%=serviceDisplay%>>
			
					<td>
					    <table width='100%' cellpadding='3' cellspacing=0  align='center' border=0>
                            <tr>
                       			<td width='40.7%' class='label'><fmt:message key="eOP.OverrideVisitTypecontrolonEpisode.label" bundle="${op_labels}"/></td>
								<td class='fields' width='18%'><input type='checkbox'  name='override_episode_yn' id='override_episode_yn' value='<%=override_episode%>' <%=override_chk_val%> onClick="setOverrideValue(this);VisiTypecoEpi(this);"></td>
								<!--Maheshwaran K added for the Bru-HIMS-CRF-170(IN030289) as on 06/08/2013-->
								<!--Start-->
								<td width='30%' class='label'><fmt:message key="eOP.EpisodeClosureBy.label" bundle="${op_labels}"/></td>
								<td class='fields'  width='12%'><select name='episode_closure_by' id='episode_closure_by' <%=episode_closure_style%>><option value='D' <%=episode_closure_days%> >&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/> &nbsp;</option>
								<!-- <option value='P' <%=episode_closure_pract%> >&nbsp;<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> &nbsp;</option>
								<option value='I' <%=episode_closure_insu%> >&nbsp;<fmt:message key="Common.Insurance.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Group.label" bundle="${common_labels}"/></option> -->
								<option value='N' <%=episode_closure_noshow%> >&nbsp;<fmt:message key="Common.NoShows.label" bundle="${common_labels}"/> &nbsp;</option></select>
								</td>
								<!--<td class='label' width='30%'>&nbsp;</td>
								<td class='label' width='12%'>&nbsp;</td>-->
								<!--End-->
                          	</tr>
						</table>
                           <table width='100%' cellpadding=3 cellspacing=0 border=0> 						
								<tr>
								<td width='40.7%' class='label'><fmt:message  key="eOP.FollowUpVisitDuratin.label"  bundle="${op_labels}"/></td>									
								<td class='fields' width='18%'>
								<% if( (override_episode.equals("Y")) || ( "N".equalsIgnoreCase(override_episode) && "B".equals(visit_type_derv_rule)) )  { %>
								<input type='text' name="Max_dur_allow" id="Max_dur_allow" maxlength=6 size=6 onBlur='CheckNum(this)' value='<%=Max_dur_allow%>' disabled
								   onKeyPress='return(ChkNumberInput(this,event,0))' ><img id='followup_img' style='<%=image1%>' src='../../eCommon/images/mandatory.gif'>
									<% } else {%>
								<input type='text' name="Max_dur_allow" id="Max_dur_allow" maxlength=6 size=6 onBlur='CheckNum(this)' value='<%=Max_dur_allow %>' onKeyPress='return(ChkNumberInput(this,event,0))' ><img id='followup_img' src='../../eCommon/images/mandatory.gif'>
								 <%}%>
								  </td>
							   
								<td width='30%' class='label'><fmt:message  key="eOP.NoofFollowUpVisitAllowed.label"  bundle="${op_labels}"/></td>
								<td class='fields' width='12%'>
									<% if(override_episode.equals("Y")  || ( "N".equalsIgnoreCase(override_episode) && "B".equals(visit_type_derv_rule)) )  { %>
								<input type='text' name="Max_no_visit" id="Max_no_visit" maxlength=6 size=6  onBlur='CheckNum(this)' value='<%=Max_no_visit%>'  disabled onKeyPress='return(ChkNumberInput(this,event,0))' > <img id='non_followup_img' style='<%=image3%>' src='../../eCommon/images/mandatory.gif'>
								 <% } else {%>
								<input type='text' name="Max_no_visit" id="Max_no_visit" maxlength=6 size=6  onBlur='CheckNum(this)' value='<%=Max_no_visit%>' 
								onKeyPress='return(ChkNumberInput(this,event,0))' > <img id='non_followup_img' src='../../eCommon/images/mandatory.gif'>
									<%}%>	
									 </td>
									</tr>
									 </table>
                                <table width='100%' cellpadding=3 cellspacing=0 border=0>									
								<tr>
                                <td class='label' width='30%'><fmt:message key="eOP.Minimumdayselapsedfromlastvisit.label" bundle="${op_labels}"/>:</td>
								<td class='label' width='10.7%'><fmt:message key="Common.followup.label" bundle="${common_labels}"/></td>
                                <td class='fields' width='18%'>
							<% if(override_episode.equals("N"))  { %>
								<input type='text' name="follow_up" id="follow_up" maxlength=6 size=6 onBlur='CheckNum(this)' value="<%=FollowUp%>"    disabled   onKeyPress='return(ChkNumberInput(this,event,0))' ><img id='min_elapse_img' style='<%=image5%>' src='../../eCommon/images/mandatory.gif'>
                              <%}else{%>
                              <input type='text' name="follow_up" id="follow_up" maxlength=6 size=6 onBlur='CheckNum(this)' value="<%=FollowUp%>"     onKeyPress='return(ChkNumberInput(this,event,0))' ><img id='min_elapse_img' style='<%=image6%>' src='../../eCommon/images/mandatory.gif'>
								<%}%>
                              </td>
								
							  <td class='label' width='30%'><fmt:message key="eOP.NoFollowup.label" bundle="${op_labels}"/></td>
                              <td class='fields' width='12%'>
								<% if(override_episode.equals("N"))  { %>  
							  <input type='text' name="no_follow_up" id="no_follow_up" maxlength=6 size=6 onBlur='CheckNum(this)' value="<%=NoFollowUp%>"    disabled   onKeyPress='return(ChkNumberInput(this,event,0))' ><img id='nofollowup_img' style='<%=image5%>' src='../../eCommon/images/mandatory.gif'></td>
                            <%}else{%>
					    <input type='text' name="no_follow_up" id="no_follow_up" maxlength=6 size=6 onBlur='CheckNum(this)' value="<%=NoFollowUp%>"    onKeyPress='return(ChkNumberInput(this,event,0))' ><img id='nofollowup_img' style='<%=image8%>' src='../../eCommon/images/mandatory.gif'></td>
							  <%}%>
							  </tr>
                        </table>
                    </td>
                </tr>               

                <tr>
                    <td>
                        <table width='100%' cellpadding=3 cellspacing=0 border=0>
                                <th class="columnHeader" align="left"><fmt:message key="Common.QueueManagement.label" bundle="${common_labels}"/></td>
					    </table>
						<table width='100%' cellpadding='3' cellspacing=0  align='center' border=0>
                            <tr>
                                <td class='label' width='40.7%'><fmt:message key="Common.RefreshInterval.label" bundle="${common_labels}"/></td>
                                <td class='fields' width='18%'><input type='text' name='RefreshInterval' id='RefreshInterval' maxlength=4 size=4 onBlur='CheckNum(this);checkvalid(this);' value="<%=RefreshInterval%>" onKeyPress='return(ChkNumberInput(this,event,0))'><img src='../../eCommon/images/mandatory.gif'></td>
                                <td class='QUERYDATA' width='29%'>&nbsp;<fmt:message key="Common.MIN.label" bundle="${common_labels}"/></td> </tr>

                            <tr>
                                <td class='label' width='40.7%'><fmt:message key="eOP.OntimeAppointmentstatusIfcheckinisatleast.label" bundle="${op_labels}"/></td>
                                <td class='fields' width='18%'><input type='text' name='OntimeApptStatus' id='OntimeApptStatus' maxlength=4 size=4 onBlur='CheckNum(this)' value="<%=OntimeApptStatus%>" 
								onKeyPress='return(ChkNumberInput(this,event,0))' ></td>
                                <td class='QUERYDATA' width='29%'>&nbsp;<fmt:message key="eOP.Minbeforeappointmenttime.label" bundle="${op_labels}"/></td>
                            </tr>

                            <tr>
                                <td class='label' width='40.7%'><fmt:message           key="eOP.NoshowApptstatus.label" bundle="${op_labels}"/></td>
                                <td class='fields' width='18%'><input type='text' name='NOShowApptStatus' id='NOShowApptStatus' maxlength=4 size=4 onBlur='CheckNum(this)' value="<%=NoshowApptStatus%>" 
								onKeyPress='return(ChkNumberInput(this,event,0))' ></td>
								<td class='QUERYDATA' width='29%'>&nbsp;<fmt:message key="eOP.Minafterappointmenttime.label" bundle="${op_labels}"/></td>
                            </tr>

							<tr>
								<td class='label' width='40.7%'><fmt:message key="eOP.AssignQueueNumberby.label" bundle="${op_labels}"/></td>
								<td class='fields' width='18%'><select name='assign_q_num_by' id='assign_q_num_by' <%if(isMandQueueNoAppl){%>onChange='chkShow()'<%}%>>					
								<option value='M' <%=selManual%> ><fmt:message key="eMP.manual.label" bundle="${mp_labels}"/></option>
								<option value='S' <%=selSystem%> ><fmt:message key="Common.System.label" bundle="${common_labels}"/></option></select><img src='../../eCommon/images/mandatory.gif'></td> 
							<td class='label' width = '30%'>&nbsp;<fmt:message  key="eOP.IncludeArrivedConsStartedPatients.label" bundle="${op_labels}"/></td>
							<td width = '12%'><input type='checkbox'  name='inc_arrive_cons_start_pats_yn' id='inc_arrive_cons_start_pats_yn' value="N" <%=inc_arrive_cons_start_pats__chk%>></td>
								
                              </tr>
							  <!--Added by Shanmukh on 29th-JUNE-2018 for ML-MMOH-CRF-1121 -->
							  <%if(isMandQueueNoAppl){%>
							  <tr  id='chkShow1' style='display:none'>			
								<td class='label'><fmt:message key="eOP.NonMandatoryQueueNo.label" bundle="${op_labels}"/></td>
							  <td class='fields'><input type='checkbox' name='mand_queue_no' id='mand_queue_no' value="Y" <%if(("Y").equals(mand_queue_no)){%>checked<%}%> onclick='change_queue_value();'></td>
							  </tr>
							  <%}%>
							  <!-- Bru-HIMS-CRF-179-DD1 changes -Start -->
							  <tr>
									<td class='label' width='40.7%'><fmt:message key="eOP.calculateWaitTime.label" bundle="${op_labels}"/></td>
									<td class='fields' width='18%'><select name='cal_wait_time_based' id='cal_wait_time_based'>		
									<option value='01' <%=selCheckedIn%> ><fmt:message key="eOP.CheckedIn.label" bundle="${op_labels}"/></option>
									<option value='02' <%=selArrived%> ><fmt:message key="eOP.ArrivedAtNursStn.label" bundle="${op_labels}"/></option>
									</select></td> 
							  </tr>
							  <!-- Bru-HIMS-CRF-179-DD1 changes -End -->
							   </table>
							   
								<table width='100%' cellpadding='3' cellspacing=0  align='center' border=0>
								<tr>
									<td class='label'  width = '43%'><fmt:message   key="eOP.WaitTimeColorIndicator.label" bundle="${op_labels}"/></td>
									<td class='fields' width = '3%'><input type='text' name='minMinutes' id='minMinutes' onBlur='CheckNum(this), valid_dat(this)' onKeyPress='return(ChkNumberInput(this,event,0))' value = "<%=mins1_for_wait_time%>" maxlength=3 size=3></td>
									<td class='label'  width = '3%'> <fmt:message   key="eOP.Mins.label" bundle="${op_labels}"/></td>
									<td class='label'  width = '3%'><fmt:message   key="eOP.Colour.label" bundle="${op_labels}"/></td>
									<td width = '4%'  style = 'background-color:#00BFFF' ></td>	

									<td width = '4%'></td>

									<td class='fields' width = '3%'><input type='text' name='maxMinutes' id='maxMinutes' value = "<%=mins2_for_wait_time%>" onBlur='CheckNum(this), valid_dat(this)' onKeyPress='return(ChkNumberInput(this,event,0))' maxlength=3 size=3></td>
									<td class='label'  width = '3%'> <fmt:message   key="eOP.Mins.label" bundle="${op_labels}"/></td>
									<td class='label'  width = '3%'><fmt:message   key="eOP.Colour.label" bundle="${op_labels}"/></td>
									<td width = '4%' style ="background-color:#FFA500"></td>
									<td width = '9%'></td>
									<td width = '10%'></td>
									<td width = '10%'></td>
								</tr>
								</table>
								
								<tr>
                    				<td>
                        				<table width='100%' cellpadding=3 cellspacing=0 border=0>
											<tr>
												<td class='label' width='40.7%'><fmt:message key="eOP.ActionUnsettledorUnbilledAmountfortheEncounter.label" bundle="${op_labels}"/></td>
												<td class='fields' width='18%'>
													<select name='action_on_pending_bill' id='action_on_pending_bill'>
														<option value='N' <%=selNoAction%>>No Action</option>					
														<option value='W' <%=selWarning%> >Warning</option>
														<option value='S' <%=selStop%> >Stop</option>
													</select>
												</td> 
												<td class='label' width = '42%' colspan="2">&nbsp;</td>
	                              			</tr>
                              	
                              			</table>
                              		</td>
                              	</tr>
                             </table>
                             </td>
                             </tr>            
                             <tr>
                             <td>
                            <table width='100%' border=0 cellpadding=0 cellspacing=0>
                                    <th width='70%' class="columnHeader" align="left" ><fmt:message key="eOP.AutoCompletionofincompletevisits.label" bundle="${op_labels}"/></th>
                                    <th width='30%' class="columnHeader" align="left"><fmt:message key="eOP.VitalSignsNursingMeasures.label" bundle="${op_labels}"/></th>
							</table>
						    <table width='100%' cellpadding='3' cellspacing=0  align='center' border=0>
                              <tr>
                                    <td width='40.7%' class='label'><fmt:message key="Common.DispType.label" bundle="${common_labels}"/>
                                    </td>
                                    <td class='fields' width='18%' ><select name='disptype' id='disptype' >
                                            <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
										<%
						                try{ 	
						
										  sql="select disp_type, short_desc from am_disposition_type where eff_status='E' and use_at_concl_yn='Y' and DECEASED_YN = 'N' order by 2";

										 stmt=con.createStatement();
										 rset=stmt.executeQuery(sql);
										 if(rset!=null)
										 {
										 String id1="";
										 String val1="";
										 
										 while(rset.next())
										 {
											 id1=rset.getString("disp_type");
											 val1=rset.getString("short_desc");
											 if(id1.equals(DispositionType))
											   selval="selected";
											 
											 out.print("<option value='"+id1+"' "+selval+">"+val1+"</option>");
											 selval="";
										 }
										 }
										 }catch(Exception e) { out.println(e.toString());e.printStackTrace();}
										 finally
										 {
											 if (stmt != null) stmt.close();
											 if (rset != null) rset.close();
										 }
				           %>
                    </select><img id=id1 src='../../eCommon/images/mandatory.gif' style="visibility:hidden;">
                    </td>
					<td class='label' width='22%'><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td class='fields' width='20%'><select name='group' id='group'>
                     <option value=' '>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
					   bundle="${common_labels}"/> --------&nbsp;</option>
					  <%
					  try
						 {
						     
							 /* The following sql query fetches the short discription of the group where the effective status is enabled and result_type is 'V' --- Srijagadeesh */

							 sql="select short_desc,discr_msr_id from am_discr_msr where eff_Status ='E' and "+
								" result_type ='V' order by 1 ";
						     stmt=con.createStatement();
						     rset=stmt.executeQuery(sql);
						     if(rset!=null)
						     {
							 String id="";
							 String val="";
							 
							 while(rset.next())
							 {
							     id=rset.getString("discr_msr_id");
							     val=rset.getString("short_desc");
							     if(id.equals(Group))
								   selval="selected";
								 
							     out.print("<option value='"+id+"' "+selval+">"+val+"</option>");
							     selval="";
							 }
						     }
						 }catch(Exception e) { out.println(e.toString());e.printStackTrace();}
						 finally
						 {
						     if (stmt != null) stmt.close();
						     if (rset != null) rset.close();
						 }
				           
					           %>
							</select>&nbsp
						
							<img id='visinvs' style="visibility:hidden" src='../../eCommon/images/mandatory.gif'></td>
					
                                </tr>
                            </table>
                        </td>
                    </tr>
              
                    
        <%  
			/* This part of the code executes only when the patient billing module is installed; here  the billing parameters are being displayed. --- Srijagadeesh. */						

			if(InstallYN.equals("Y"))
            {%>
                    <tr>
                        <td>
                            <table width='100%' cellpadding=0 cellspacing=0>
                                <tr>
                                    <th class="columnHeader" align="left"><fmt:message key="eOP.BillingParameters.label" bundle="${op_labels}"/></td>
                                </tr>
							</table>
							<table width='100%' cellpadding=3 cellspacing=0 border=0>
                                <tr>
                                    <td width='40.7%' class='label'><fmt:message key="Common.InterfacetoBillingModule.label" bundle="${common_labels}"/></td>
                                    <td class='fields'>
                                        <%
                                        if(BlInterfaceYN!=null)
                                        {
                                            if(BlInterfaceYN.equals("Y") )
                                            {
                                                chkval="checked";
												
                                            }
											
                                        }
                                        %>                              
                                        <input type='checkbox' name='bl_interface' id='bl_interface' value='<%=BlInterfaceYN%>' onClick='enableDisable(this)' <%=chkval%> >
                                        <%chkval="";%>
										<input type='hidden' name='bl_interface_yn' id='bl_interface_yn' value='<%=BlInterfaceYN%>'>
                                    </td>									                                   
										 <%chkval="";%>
                                </tr>
                            </table>
                        </td>
                    </tr>
                <%
                }
                %>
				<% if(isclinicCategory){ %>
				<!--Added by Ajay for MMS-DM-CRF-0209.4 -->
					<tr>
                        <td>
                            <table width='100%' cellpadding=0 cellspacing=0>
                                <tr>
                                    <th class="columnHeader" align="left"><fmt:message key="eOP.clinic.label" bundle="${op_labels}"/></td>
                                </tr>
							</table>
							<table width='100%' cellpadding=3 cellspacing=0 border=0>
                                <tr>
                                    <td width='40.7%' class='label'><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
                                    <td><input type='checkbox' onClick="changeMandFld(this);"  name='cliniccatagory' id='cliniccatagory' value="N" <%=cliniccatagory_checked%>></td></td>
									<td width='40.7%' class='label'><fmt:message key="Common.category1.label" bundle="${common_labels}"/> <fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></td>
                                     <td class='fields'>
                                       <input type='checkbox' name='clinicCatagoryman' id='clinicCatagoryman' value="N" <%=clinicCatagoryman_checked%> <%=clinicCatMandDisabled%>></td>
									   </tr>
									   <tr>
									   <td width='40.7%' class='label'><fmt:message key="Common.referral.label" bundle="${common_labels}"/> <fmt:message key="Common.required.label" bundle="${common_labels}"/></td>
                                     <td class='fields'>
                                       <input type='checkbox' name='ClinicRefrlReq1' id='ClinicRefrlReq1' <%=clinicReffReqValChecked%> disabled></td>
									   <input type='hidden' name='ClinicRefrlReq' id='ClinicRefrlReq' value="N"></td><td>&nbsp</td><td>&nbsp</td>
									   </tr>
									   </table>
		
					</tr>
					<!-- End of MMS-DM-CRF-0209.4 -->
				<% }%>
            </table>
            <input type='hidden' name='function' id='function'  value='<%=functionname%>'>            
            <input type='hidden' name='InstallYN' id='InstallYN'  value='<%=InstallYN%>'>
			<input type='hidden' name='disposition' id='disposition' value='<%=Disposition%>'>
			<input type='hidden' name='pdiagnosis' id='pdiagnosis' value='<%=PDiagnosis%>'>
			<input type='hidden' name='notes' id='notes' value='<%=notes%>'>
			<input type='hidden' name='BOEpisode' id='BOEpisode' value='<%=BOEpisode%>'>
			
			<!--Added by Shanmukh on 29th-JUNE-2018 for ML-MMOH-CRF-1121-->
			<input type = 'hidden' name = 'mand_queue_no_chk_yn'  value="N">
			<input type='hidden' name='assign_queue_num_by' id='assign_queue_num_by' value='<%=ASSIGN_QUEUE_NUM_BY%>'>
			<input type='hidden' name='isMandQueueNoAppl' id='isMandQueueNoAppl' value='<%=isMandQueueNoAppl%>'>
			<!--END-->
			<!--Added by Ashwini on 06-Mar-2019 for MO-CRF-20148-->
			<input type='hidden' name='isNationalIdValidationAppl' id='isNationalIdValidationAppl' value='<%=isNationalIdValidationAppl%>'>
			<input type='hidden' name='isclinicCategory' id='isclinicCategory' value='<%=isclinicCategory%>'>
        </div>
		<script>
			if(document.forms[0].visit_backdating_allowed_yn.checked==true)
				document.forms[0].backdategif.style.visibility='visible';
			else
				document.forms[0].backdategif.style.visibility='hidden';
			
			//Added by Shanmukh on 29th-JUNE-2018 for ML-MMOH-CRF-1121
				if((document.forms[0].isMandQueueNoAppl.value=="true")&&(document.forms[0].assign_queue_num_by.value=="M")){
				document.getElementById("chkShow1").style.display="inline";
				}else if(document.forms[0].isMandQueueNoAppl.value=="true"){ 
				document.getElementById("chkShow1").style.display="none";
				}
			
			function chkShow(){
				if(document.forms[0].assign_q_num_by.value=="M"){
				document.getElementById("chkShow1").style.display="inline";
				}else{
					if(document.forms[0].mand_queue_no.checked==true){
						document.forms[0].mand_queue_no_chk_yn.value="Y";
					}
					document.getElementById("chkShow1").style.display="none";
				}
			  }
			  
		if((document.forms[0].isMandQueueNoAppl.value=="true")&&(document.forms[0].mand_queue_no.checked==true)){
		document.forms[0].mand_queue_no_chk_yn.value="Y";
		}
			//END
		</script>
        </form>
    </body>
</html>
<%
            }catch(Exception e){e.printStackTrace();}
            finally{
            if(con!=null) ConnectionManager.returnConnection(con,request);
            }
%>


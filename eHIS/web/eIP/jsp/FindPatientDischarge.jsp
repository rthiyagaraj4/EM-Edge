<!DOCTYPE html>
<!-- MOD#0A import blipin.* -->
<%@ page  contentType="text/html;charset=UTF-8"  import="webbeans.eCommon.*,java.sql.*,blipin.*,java.util.*,eCommon.XSSRequestWrapper"  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue 
	Connection con  = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rsetBL = null;
    con = ConnectionManager.getConnection(request);	
	
	String bl_operational =	(String)session.getValue("bl_operational");
	//String loginUser		=	checkForNull((String)session.getValue("login_user"));
	String err_mesg = "";
	String dis_adv_status = "";
	String disc_blg_stage = "";
	String disc_bill_exists = "";
	//String rect_loc_code    = "";
	//String cancel_bill = "";
	String mode = request.getParameter("mode");
		if (mode==null) mode = "";

	String patient_id = request.getParameter("patient_Id");
		if (patient_id==null) patient_id = "";
	
	String encid		= request.getParameter("encounter_Id");
		if (encid==null) encid = "";
	
	String practitioner_id = request.getParameter("practitioner_Id");
		if (practitioner_id==null) practitioner_id ="";
	
	String call_function = request.getParameter("call_function");		
		if (call_function==null) call_function ="";
		

	String sex = request.getParameter("Sex");		
		if (sex==null) sex ="";

	
	
	String IPval = request.getParameter("IPval");		
		if (IPval==null) IPval ="";
	
	String p_service_type = request.getParameter("p_service_type");	
		if (p_service_type==null) p_service_type =""; 

	String bl_install_yn = checkForNull(request.getParameter("bl_install_yn"));	
	String oth_adt_status = "";
	String function_id    = checkForNull(request.getParameter("function_id"));

		
	String bl_interfaced_yn    = checkForNull(request.getParameter("bl_interfaced_yn"));
	String discharge_checklist_app_yn    = checkForNull(request.getParameter("discharge_checklist_app_yn"));
	String bed_block_period_dis    = checkForNull(request.getParameter("bed_block_period_dis"));
	String dis_date_chk_days    = checkForNull(request.getParameter("dis_date_chk_days"));
	String dis_date_chk_days_unit    = checkForNull(request.getParameter("dis_date_chk_days_unit"));
	String diag_update_period_max_unit    = checkForNull(request.getParameter("diag_update_period_max_unit"));
	String max_disch_period_for_predc    = checkForNull(request.getParameter("max_disch_period_for_predc"));
	String deactivate_pseudo_bed_yn    = checkForNull(request.getParameter("deactivate_pseudo_bed_yn"));
	String disch_reason_mand_yn=checkForNull(request.getParameter("disch_reason_mand_yn"));
	String allow_late_discharge_reason=checkForNull(request.getParameter("allow_late_discharge_reason"));
	
	String weight_on_admn_mandatory			= checkForNull(request.getParameter("weight_on_admn_mandatory"));//Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541] 
	String height_on_admn_mandatory			= checkForNull(request.getParameter("height_on_admn_mandatory"));//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
	String enable_height_bmi_pat_cls		= checkForNull(request.getParameter("enable_height_bmi_pat_cls"));//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527		
			/*
		String location_code	=	checkForNull(request.getParameter("location_code"));
			if (location_code==null) location_code ="";

		String oper_stn_id	=	checkForNull(request.getParameter("oper_stn_id"));
			if (oper_stn_id==null) oper_stn_id ="";

		String bed_no	=	checkForNull(request.getParameter("bed_no"));
			if (bed_no==null) bed_no ="";

//out.println("<script>alert(\"QueryString:"+request.getQueryString()+"\");</script>");bed_no
out.println("<script>alert(\"call_function:"+call_function+"\");</script>");
		*/



	/* START MODIFICATION BY ARUN */
		// MOD#01 Billing starts here
//out.println("<script>alert(\"call_function:"+call_function+"\");</script>");
		
		
	try
	{
		String facility_id = (String)session.getValue("facility_id");		
		
		try
		{
			if(call_function.equals("PaintDischargePatient.jsp"))
			{
				try
				{
					stmt = con.createStatement();
					rsetBL = stmt.executeQuery(" SELECT oth_adt_status from IP_OPEN_ENCOUNTER where patient_id ='"+patient_id+"' and facility_id='"+facility_id+"' and encounter_id='"+encid+"'  ");
					while(rsetBL.next())
					{
						oth_adt_status = rsetBL.getString("oth_adt_status");
						if(oth_adt_status == null) oth_adt_status = "";
	//out.println("<script>alert(\""+oth_adt_status+"\");</script>");				
					}

				
				if(!oth_adt_status.equals("7"))
				  err_mesg = "NO_ACTV_DISC_ADV_NO_DISC";
				//err_mesg = "ADMIN_ALREADY_CANCELLED";
					if(rsetBL!=null) rsetBL.close();
					if(stmt!=null) stmt.close();
				}
				catch(Exception ed)
				{
				out.println("Exception in FindPatientDischarge.jsp page"+ed.toString());
				ed.printStackTrace();
				}
			}
			
			if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
			{
				/*Tuesday, June 01, 2010 , commented for PE , query executed in InpatientLookupQueryResult.jsp at line no 166*/
				/*StringBuffer mo_deceased_check = new StringBuffer();
				if (mo_deceased_check.length() > 0)
					mo_deceased_check.delete(0,mo_deceased_check.length());
				mo_deceased_check.append("select  install_yn from  sm_module where   module_id ='MO'");
				String mo_install_yn = "N";

				try
				{
					stmt	= con.createStatement();
					rsetBL	= stmt.executeQuery(mo_deceased_check.toString());	
					if(rsetBL != null && rsetBL.next())
					{
						mo_install_yn				= rsetBL.getString("install_yn");	
					}
					if(rsetBL!=null) rsetBL.close();
					//if(stmt!=null) stmt.close();
				}
				catch(Exception e)
				{
					out.println("Exception in FindPatientDischarge.jsp page on fetch of data from sm_module table"+e.toString());
					e.printStackTrace();
				}*/
				/*Tuesday, June 01, 2010 commented for PE , query moved to InpatientLookupQueryResult.jsp at line no 2492 & alert message at line no 644*/
				/*
				try	{

					String chk_open_enc = "select 1 cnt from ip_open_encounter where facility_id = '"+facility_id+"' and patient_id = '"+patient_id+"'";
						
					rsetBL	= stmt.executeQuery(chk_open_enc);	
				
					if(rsetBL != null && rsetBL.next())
					{
						int no_of_open_enc = rsetBL.getInt("cnt");	
							
						if(no_of_open_enc>0)
							err_mesg = "CANNOT_CANCEL_DISCHARGE";						
					}
					if(rsetBL!=null) rsetBL.close();
					//if(stmt!=null) stmt.close();
				}
				catch(Exception e)
				{
					out.println("Exception in FindPatientDischarge.jsp page on fetch of data from mo_mortuary_regn table");
					e.printStackTrace();
				}
				*/
				String mo_install_yn = request.getParameter("mo_install_yn")==null?"N":request.getParameter("mo_install_yn");
				StringBuffer mo_deceased_check = new StringBuffer();
				if (mo_deceased_check.length() > 0)
					mo_deceased_check.delete(0,mo_deceased_check.length());
				if(mo_install_yn.equals("Y"))
				{
					if (mo_deceased_check.length() > 0)
						mo_deceased_check.delete(0,mo_deceased_check.length());
					mo_deceased_check.append(" select count(*) no_of_record from mo_mortuary_regn where  patient_id='"+patient_id+"' and facility_id='"+facility_id+"' and encounter_id='"+encid+"' ");

					try
					{
						stmt	= con.createStatement();
						rsetBL	= stmt.executeQuery(mo_deceased_check.toString());	
						if(rsetBL != null && rsetBL.next())
						{
							int no_of_record				= rsetBL.getInt("no_of_record");	
							
							if(no_of_record>0)
								err_mesg = "REGISTERED_IN_MORTUARY";
						}
						if(rsetBL!=null) rsetBL.close();
						if(stmt!=null) stmt.close();
					}
					catch(Exception e)
					{
						out.println("Exception in FindPatientDischarge.jsp page on fetch of data from mo_mortuary_regn table");
						e.printStackTrace();
					}
				}			

			}
			
			//10/17/2008 5089 MF-CRF-0017 IP
			
			if(call_function.equals("TransferPatient"))
			{
				//out.println("<script>alert(\"QueryString:"+request.getQueryString()+"\");</script>");
				/*
				StringBuffer user_rest_check = new StringBuffer();
				user_rest_check.append("Select locn_code from AM_OS_USER_LOCN_ACCESS_VW b where b.facility_id = '"+facility_id+"' and locn_code = '"+location_code+"' and b.locn_type = 'N' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+loginUser+"' and b.ASSIGN_BED_YN ='Y'");

				try
				{
					stmt	= con.createStatement();
					rsetBL	= stmt.executeQuery(user_rest_check.toString());	
					if(rsetBL != null && rsetBL.next())
					{
						rect_loc_code				= rsetBL.getString("1");	
						if(rect_loc_code == null) rect_loc_code = "";


					}
//out.println("<script>alert(\"rect_loc_code:"+rect_loc_code+"\");</script>");
					if(!rect_loc_code.equals(""))
					err_mesg = "ASSIGN_BED_USER_ACCESS";
					if(rsetBL!=null) rsetBL.close();
					if(stmt!=null) stmt.close();
				}
				catch(Exception e)
				{
					out.println("Exception in FindPatientDischarge.jsp page on fetch of data from sm_module table");
				}

			}*/
			}
			//10/17/2008 5089 MF-CRF-0017 IP
		if(bl_operational.equals("Y") && err_mesg.equals("") && bl_install_yn.equals("Y")) 
		{
				
			String episode_id = encid;
			if(call_function.equals("PaintDischargePatient.jsp"))
			{	
				try
				{
					stmt = con.createStatement();
					rsetBL = stmt.executeQuery(" SELECT BL_IP_DETAILS.GET_DISCHARGE_BILLING_STAGE('"+facility_id+"') disc_blg_stage FROM dual ");
					while(rsetBL!=null && rsetBL.next())
					{
						disc_blg_stage = rsetBL.getString("disc_blg_stage");
						if(disc_blg_stage == null) disc_blg_stage = "";

					}
				}catch (Exception e)
				{
					out.println("1st Exception in FindPatientDischarge.jsp : "+e);
					e.printStackTrace();
				}

				if(disc_blg_stage.equals("1"))
				{
				
					if(rsetBL != null )rsetBL.close();
					if(stmt != null )stmt.close();
					try
					{
						stmt = con.createStatement();
						rsetBL = stmt.executeQuery(" SELECT BL_IP_DETAILS.GET_DISCHARGE_BILL_EXIST('"+facility_id+"','"+episode_id+"') disc_bill_exists FROM dual ");
						while(rsetBL.next())
						{
							disc_bill_exists = rsetBL.getString("disc_bill_exists");
							if(disc_bill_exists == null) disc_bill_exists = "";
						}

					}catch (Exception e)
					{
						out.println("2nd Exception in FindPatientDischarge.jsp : "+e);
						e.printStackTrace();
					}
	
				
					if(disc_bill_exists.equals("N") && !call_function.equals("CANCEL_DISCHARGE_PATIENT"))
					{
						err_mesg = "BL9312";
					}
				//else if(disc_bill_exists.equals("Y") && call_function.equals("CANCEL_DISCHARGE_PATIENT"))
					//err_mesg = "DISCHARGE_BILL_RAISED";

					if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";

				}
				else if(disc_blg_stage.equals("2") && !call_function.equals("CANCEL_DISCHARGE_PATIENT"))
				{
					pstmt = con.prepareStatement( " select dis_adv_status from ip_discharge_advice where encounter_id = '"+encid+"' and  dis_adv_srl_no = (select max(dis_adv_srl_no) from ip_discharge_advice where encounter_id ='"+encid+"' and FACILITY_ID = '"+facility_id+"') " );
					if(rsetBL != null )rsetBL.close();
					rsetBL = pstmt.executeQuery();
					while(rsetBL.next())
					{
						dis_adv_status = rsetBL.getString("dis_adv_status");
						if(dis_adv_status == null) dis_adv_status = "";
					}
					if(dis_adv_status.equals("9"))
					{
					    err_mesg = "NO_ACTV_DISC_ADV_NO_DISC";
					}
			
					if (err_mesg==null || err_mesg.equals("")) 
						err_mesg = "0";
				}
            if(rsetBL != null )rsetBL.close();
			if(stmt != null )stmt.close();
			

			if(err_mesg.equals("0") || err_mesg.equals(""))
				{
             
					if(call_function.equals("PaintDischargePatient.jsp"))
					{
						function_id ="DISCHARGE_PATIENT" ;
					}
					

					String billinSql =  "{call BL_IP_DETAILS.CHECK_FIN_CLEAR_DUR_IP_TRX(?,?,?,?)}";
					CallableStatement fileCreateCS = con.prepareCall(billinSql);
					fileCreateCS.setString(1, function_id);
					fileCreateCS.setString(2, facility_id);
					fileCreateCS.setString(3, episode_id);
					fileCreateCS.registerOutParameter( 4,java.sql.Types.VARCHAR);

					try
					{
						fileCreateCS.execute();
						err_mesg = fileCreateCS.getString(4);
						
						if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";

						

					    fileCreateCS.close();

					} catch(Exception e1) {

						e1.printStackTrace();
					} 
				}
			}else if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
			{
					//
					try{
					stmt = con.createStatement();
					rsetBL = stmt.executeQuery("SELECT BL_IP_DETAILS.check_cancel_discharge('"+facility_id+"','"+episode_id+"') from dual");
					while(rsetBL!=null && rsetBL.next())
					{
						disc_bill_exists = rsetBL.getString(1);
						if(disc_bill_exists == null) disc_bill_exists = "";

					}
				}catch(Exception e)
				{
					out.println("Exception in FindPatientDischarge.jsp : "+e);
					e.printStackTrace();
				}

				
				
				if(!disc_bill_exists.equals(""))
				{
				
					if(disc_bill_exists.equals("BL9314"))
					{
						err_mesg = "BL9314";
						
					}
					else if(disc_bill_exists.equals("BL9315"))
					{
						err_mesg = "BL9315";
						
					}

				if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";
					//
				}

				}
				
			}
			

				if(rsetBL != null )rsetBL.close();
			if(stmt != null )stmt.close();
		if(pstmt != null )pstmt.close();
	
	}catch (Exception e)
	{
		out.println("3rd Exception in FindPatientDischarge.jsp : "+e);
		e.printStackTrace();
	}
		 // End of MOD#01
	/* END MODIFICATION BY ARUN */
	if (err_mesg==null || err_mesg.equals("null") || err_mesg =="") 
		err_mesg = "0";
	
	if(!(err_mesg.equals("0")))
	{
		out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
		out.println("<script language='javascript' src='../../eCommon/js/common.js'></script>");
		
		out.println("<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>");
		out.println("<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>");

		out.println("</head><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' class='message'></body></html>");

		if (!err_mesg.substring(0,2).equals("**") && !call_function.equals("CANCEL_DISCHARGE_PATIENT")) 
		 {
			
			if(dis_adv_status.equals("9"))
			 {
			%>
			<script>alert(getMessage('<%=err_mesg%>','IP'));</script>
			<%
			 }
			  else if(!oth_adt_status.equals("7"))
			{%>
				<script>alert(getMessage('<%=err_mesg%>','IP'));</script>
			<%
			}
			 else
			 {
			%>
			<script>alert(getMessage('<%=err_mesg%>','BL'));</script>
			<%
			 }
		 }
		 else if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
		{ 
			
			 if(!disc_bill_exists.equals("")){%>
			 <script>alert(getMessage('<%=err_mesg%>','BL'));</script>
			 <%}else{%>
			
			<script>alert(getMessage('<%=err_mesg%>','IP'));</script>
			<%}%>
		<%
		}
		 else	{	
			out.println("<script>alert('"+err_mesg+"');</script>");	
			%>
			<input type = 'hidden' name ='err_mesg' value='<%=err_mesg%>'>
			<%}
			
		
	}
	else
	{ 
		out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
		out.println("<script language='javascript' src='../../eCommon/js/common.js'></script>");
		
		out.println("<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>");
		out.println("<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>");


		out.println("</head><body class='message' onKeyDown='lockKey()'></body></html>");
		%>
		<script> 

		findPatDischOnload();

		async function findPatDischOnload(){
		
			var frames_list = parent.frames[2].document.forms[0];
			
			
			
			if( frames_list.modal.value != 'yes')
			{
				
				var jsp_name1=frames_list.jsp_name.value;
				/*alert(jsp_name1)
				//10/17/2008	
				var call_function = '<%=call_function%>'
				var bed_no = '<%--=bed_no--%>'
				//
				if(call_function == 'TransferPatient')
				{
				//var jsp_name1=parent.frames[2].document.forms[0].jsp_name.value;
				if(bed_no==""){
							var confirmref=window.confirm(getMessage('BED_CAN_NOT_ASSIGN_CONFIRM',"IP"));

						if(confirmref)
							jsp_name1='AssignBedMain.jsp';

							else 
							 jsp_name1="PaintEmergencyTransfer.jsp";	
						}
				}
				//10/17/2008
				*/
				
				
				var patient_id	= "<%=patient_id%>";	
				var encid		= "<%=encid%>";
				var practitioner_id = "<%=practitioner_id%>";	
				var call_function = "<%=call_function%>";
				var sex = "<%=sex%>";			
				var IPval = "<%=IPval%>";		
				var p_service_type = "<%=p_service_type%>"; 				
				var function_id = "<%=function_id%>"; 				

				var win_height=frames_list.win_height.value;
					if(win_height == "" || win_height <= 27) win_height="32";
				
				var dialogTop=frames_list.dialogTop.value;
					if(dialogTop == "") dialogTop="80";				
				
				var win_width=frames_list.win_width.value;
					if(win_width == "") win_width="40";
				
				var module1=frames_list.module.value;
					if(module1 == "") module1="eIP";
				
				var model_window=frames_list.model_window.value;
				if( model_window == "") model_window ="";

				if( model_window == 'NO')
				{  
					//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
					parent.parent.frames[1].document.location.href="../../"+module1+"/jsp/"+jsp_name1+"?encounterId="+encid+"&patientId="+patient_id+"&Practitioner_Id="+practitioner_d+"&callfrom=IP&call_function="+call_function+"&Sex="+sex+"&function_id="+function_id+"&weight_on_admn_mandatory=<%=weight_on_admn_mandatory%>&height_on_admn_mandatory=<%=height_on_admn_mandatory%>&enable_height_bmi_pat_cls=<%=enable_height_bmi_pat_cls%>";
				}
				else
				if( model_window == 'N')
				{	
					//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
					parent.frames[3].document.location.href="../../"+module1+"/jsp/"+jsp_name1+"?encounterId="+encid+"&patientId="+patient_id+"&Practitioner_Id="+practitioner_id+"&callfrom=IP&call_function="+call_function+"&Sex="+sex+"&function_id="+function_id+"&weight_on_admn_mandatory=<%=weight_on_admn_mandatory%>&height_on_admn_mandatory=<%=height_on_admn_mandatory%>&enable_height_bmi_pat_cls=<%=enable_height_bmi_pat_cls%>";
				}			
				else
				{
														
					var retVal = 	new String();
					var dialogHeight= "95vh";
					var dialogWidth = "85vw";
					var dialogHeight= "95vh";
					var dialogPadding = "3px";
					var dialogTop	= "0vh";
					if(call_function=="CANCEL_DISCHARGE_PATIENT")
					{
						
						dialogHeight= "95vh";
						dialogWidth = "85vw";
						dialogTop	= "0vh";
					}
					
					var center = "1" ;
					var status="no";
					
					var features	="dialogPadding:" + dialogPadding + ";dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments	= "" ;	

					/*alert("module1------------->"+module1);
					alert("jsp_name1------------->"+jsp_name1);
					alert("IPval------------->"+IPval);
					alert("encid------------->"+encid);
					alert("patient_id------------->"+patient_id);
					alert("practitioner_id------------->"+practitioner_id);
					alert("call_function------------->"+call_function);
					alert("p_service_type.value------------->"+p_service_type.value);
					alert("sex------------->"+sex);
					alert("function_id------------->"+function_id);*/
					
					retVal = await parent.window.showModalDialog("../../"+module1+"/jsp/"+jsp_name1+"?location_code="+IPval+"&encounterId="+encid+"&patientId="+patient_id+"&Practitioner_Id="+practitioner_id+"&callfrom=IP&call_function="+call_function+"&p_service_type="+p_service_type.value+"&Sex="+sex+"&mode=modal&function_id="+function_id+"&bl_interfaced_yn=<%=bl_interfaced_yn%>&discharge_checklist_app_yn=<%=discharge_checklist_app_yn%>&bed_block_period_dis=<%=bed_block_period_dis%>&dis_date_chk_days=<%=dis_date_chk_days%>&dis_date_chk_days_unit=<%=dis_date_chk_days_unit%>&diag_update_period_max_unit=<%=diag_update_period_max_unit%>&max_disch_period_for_predc=<%=max_disch_period_for_predc%>&deactivate_pseudo_bed_yn=<%=deactivate_pseudo_bed_yn%>&allow_late_discharge_reason=<%=allow_late_discharge_reason%>&disch_reason_mand_yn=<%=disch_reason_mand_yn%>&weight_on_admn_mandatory=<%=weight_on_admn_mandatory%>&height_on_admn_mandatory=<%=height_on_admn_mandatory%>&enable_height_bmi_pat_cls=<%=enable_height_bmi_pat_cls%>" ,arguments,features);
					//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
					parent.frames[2].document.location.reload();	
				}
			}
			else
			{
				window.parent.returnValue=enc;
				window.parent.close();
			}
		}
		</script> 
	<%	}
}catch (Exception e)
{
	out.println("Final Exception in FindPatientDischarge.jsp : "+e);
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


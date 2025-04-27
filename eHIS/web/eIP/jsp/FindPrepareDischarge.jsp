<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*,blipin.*,java.util.*,eCommon.XSSRequestWrapper"  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection con =null;
	ResultSet rs =null;
	Boolean bill_result=true;
	String bl_operational =	(String)session.getValue("bl_operational");
	String err_mesg = "";
	String mode = request.getParameter("mode");
	if (mode==null) mode = "";
	String facility_id	= (String)session.getValue("facility_id");
	String patient_id = request.getParameter("patient_Id");
	if (patient_id==null) patient_id = "";
	String encid		= request.getParameter("encounter_Id");
	 if (encid==null) encid = "";
	String leave_exp_dt_flag = request.getParameter("leave_exp_dt_flag");
	if(leave_exp_dt_flag==null) leave_exp_dt_flag = "";
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
	
	String p_patient_class = request.getParameter("patient_class");
	if (p_patient_class==null) p_patient_class ="";
	String function_id = request.getParameter("function_id");
	if (function_id==null) function_id ="";
	String bl_interfaced_yn						 = checkForNull(request.getParameter("bl_interfaced_yn"));
	String allow_discharge_date_predc	 = checkForNull(request.getParameter("allow_discharge_date_predc"));
	String max_disch_period_for_predc	 = checkForNull(request.getParameter("max_disch_period_for_predc"));
	String setup_bl_dtls_in_ip_yn			 = checkForNull(request.getParameter("setup_bl_dtls_in_ip_yn"));
	String mother_cut_off_age_pda		 = checkForNull(request.getParameter("mother_cut_off_age_pda"));
	String mother_max_age_pda				 = checkForNull(request.getParameter("mother_max_age_pda"));
	String pat_dtls_unknown_yn_pda		 = checkForNull(request.getParameter("pat_dtls_unknown_yn_pda"));
	String contact1_name_pda				 = checkForNull(request.getParameter("contact1_name_pda"));
	String contact2_name_pda				 = checkForNull(request.getParameter("contact2_name_pda"));
	String weight_on_admn_mandatory			= checkForNull(request.getParameter("weight_on_admn_mandatory"));//Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541] 
	String height_on_admn_mandatory			= checkForNull(request.getParameter("height_on_admn_mandatory"));//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
	String enable_height_bmi_pat_cls		= checkForNull(request.getParameter("enable_height_bmi_pat_cls"));//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
		CallableStatement cstmt = null;
	try
	{
		con = ConnectionManager.getConnection(request);	
		try 
		{
	 		
			if ( bl_operational.equals("Y")) 
	 		{
	 			HttpSession httpSession = request.getSession(false);
	 			Properties p = (Properties)httpSession.getValue("jdbc");	
	 			String episode_id = encid;
				String episode_type ="";
				if(p_patient_class.equals("IP"))
	 				episode_type = "I";
				else if(p_patient_class.equals("DC"))
					episode_type = "D";
	 			Hashtable hashtableBL = new Hashtable();
	 			hashtableBL.put("patient_id",patient_id);
	 			hashtableBL.put("encid",encid);
	 			hashtableBL.put("call_function",call_function);
	 			hashtableBL.put("episode_type",episode_type);
	 			hashtableBL.put("episode_id",episode_id);
	 			hashtableBL.put("facility_id",facility_id);
	 			BLPrepareDischargeAdvice blPrepareDischargeAdvice = new BLPrepareDischargeAdvice();
	 			Hashtable resultsBL = blPrepareDischargeAdvice.billPatientService(p,con,hashtableBL);
				bill_result = ((Boolean) resultsBL.get("status")).booleanValue();
				if(!bill_result)
	 				err_mesg	 = (String) resultsBL.get("error");	
				if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";
	 		}
	 	}
	 	catch (Exception e)
	 	{
	 		out.println("Exception "+e);
	       
	 	}
		// End of MOD#01
		/* END MODIFICATION BY ARUN */
		if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";
		if(!(err_mesg.equals("0")))
		{
			out.println("<html><head>");
			out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
			out.println("<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
			
			out.println("</head><body class='message' onKeyDown='lockKey()'></body></html>");
			if (!err_mesg.substring(0,2).equals("**")) 
			{
				%>
				<script>
					//alert(getMessage('<%=err_mesg%>','BL'));				
						alert('<%=err_mesg%>');
				</script>
				<%
			}
			else		
				out.println("<script>alert('"+err_mesg+"');</script>");
		}
		else
		{
			out.println("<html><head>");
			out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
			out.println("<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
			
			out.println("</head><body class='message' onKeyDown='lockKey()'></body></html>");
			%>
			<script>

			findprepdischonload();
			
			async function findprepdischonload(){
			var frames_list = parent.frames[2].document.forms[0];
			if( frames_list.modal.value != 'yes')
		    {   
				var jsp_name1=frames_list.jsp_name.value;
				var patient_id	= "<%=patient_id%>";
				var encid		= "<%=encid%>";
				var practitioner_id = "<%=practitioner_id%>";
				var leave_exp_dt_flag = "<%=leave_exp_dt_flag%>";
				var call_function = "<%=call_function%>";
				var sex = "<%=sex%>";
				var IPval = "<%=IPval%>";
				var p_service_type = "<%=p_service_type%>";
				var function_id = "<%=function_id%>";
				/*Added On 5/5/2010 for PE passing the values from Result page to PDA pages*/
				var setup_bl_dtls_in_ip_yn = "<%=setup_bl_dtls_in_ip_yn%>";
				var bl_interfaced_yn = "<%=bl_interfaced_yn%>";
				var allow_discharge_date_predc  = "<%=allow_discharge_date_predc%>";
				var max_disch_period_for_predc = "<%=max_disch_period_for_predc%>";
				var mother_cut_off_age_pda		= "<%=mother_cut_off_age_pda%>";
				var mother_max_age_pda			= "<%=mother_max_age_pda%>";
				var pat_dtls_unknown_yn_pda	= "<%=pat_dtls_unknown_yn_pda%>";
				var contact1_name_pda				= "<%=contact1_name_pda%>";
				var contact2_name_pda				= "<%=contact2_name_pda%>";
				/**/
				var win_height=frames_list.win_height.value;
				if(win_height == "") win_height="27";
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
					parent.parent.frames[1].document.location.href="../../"+module1+"/jsp/"+jsp_name1+"?encounterId="+encid+"&patientId="+patient_id+"&Practitioner_Id="+practitioner_d+"&leave_exp_dt_flag="+leave_exp_dt_flag+"&callfrom=IP&call_function="+call_function+"&Sex="+sex+"&function_id="+function_id+"&weight_on_admn_mandatory=<%=weight_on_admn_mandatory%>&height_on_admn_mandatory=<%=height_on_admn_mandatory%>&enable_height_bmi_pat_cls=<%=enable_height_bmi_pat_cls%>";
				}
				else
				if( model_window == 'N')
				{
					//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
					parent.frames[3].document.location.href="../../"+module1+"/jsp/"+jsp_name1+"?encounterId="+encid+"&leave_exp_dt_flag="+leave_exp_dt_flag+"&patientId="+patient_id+"&Practitioner_Id="+practitioner_id+"&callfrom=IP&call_function="+call_function+"&Sex="+sex+"&function_id="+function_id+"&weight_on_admn_mandatory=<%=weight_on_admn_mandatory%>&height_on_admn_mandatory=<%=height_on_admn_mandatory%>&enable_height_bmi_pat_cls=<%=enable_height_bmi_pat_cls%>";
				}
				else
				{
					
					var retVal = 	new String();
					var dialogHeight= "90vh";
					var dialogWidth = "90vw";
					var dialogTop	= "2";
					var center = "1" ;
					var status="no";
					var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments	= "" ;
					retVal = await top.window.showModalDialog("../../"+module1+"/jsp/"+jsp_name1+"?location_code="+IPval+"&encounterId="+encid+"&leave_exp_dt_flag="+leave_exp_dt_flag+"&patientId="+patient_id+"&Practitioner_Id="+practitioner_id+"&callfrom=IP&call_function="+call_function+"&p_service_type="+p_service_type.value+"&Sex="+sex+"&mode=modal&function_id="+function_id+"&setup_bl_dtls_in_ip_yn="+setup_bl_dtls_in_ip_yn+"&bl_interfaced_yn="+bl_interfaced_yn+"&allow_discharge_date_predc="+allow_discharge_date_predc+"&max_disch_period_for_predc="+max_disch_period_for_predc+"&mother_cut_off_age_pda="+mother_cut_off_age_pda+"&mother_max_age_pda="+mother_max_age_pda+"&pat_dtls_unknown_yn_pda="+pat_dtls_unknown_yn_pda+"&contact1_name_pda="+encodeURIComponent(contact1_name_pda)+"&contact2_name_pda="+encodeURIComponent(contact2_name_pda)+"&weight_on_admn_mandatory=<%=weight_on_admn_mandatory%>&height_on_admn_mandatory=<%=height_on_admn_mandatory%>&enable_height_bmi_pat_cls=<%=enable_height_bmi_pat_cls%>",arguments,features);//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
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
			<%
		}
	}//E.o.Try
	catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
	finally
	{
		if(rs!=null)	rs.close();
		if(cstmt!=null) cstmt.close();
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


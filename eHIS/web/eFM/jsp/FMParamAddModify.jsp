<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eFM/js/FMParam.js'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


<BODY onMouseDown="CodeArrest()" onKeyDown = 'lockKey();' onload='ClearIncomplFSLoc();'>
<FORM name = 'fm_param_form' action='../../servlet/eFM.FMParameterServlet' method='post' target='messageFrame'>
<%
	Connection con = ConnectionManager.getConnection(request);
	
	java.sql.Statement stmt		= null;
	java.sql.Statement stmt1	= null;
	java.sql.Statement stmt2	= null;
	java.sql.Statement stmt3	= null;
	java.sql.Statement stmt4	= null;
	java.sql.Statement stmt5	= null;
	ResultSet rs				= null;
	ResultSet rs1				= null;
	ResultSet rs2				= null;
	ResultSet rs3				= null;
	ResultSet rs4				= null;
	ResultSet rs5				= null;
	String maintain_doc_or_file = "";
	
	
	Boolean isRefreshIntervalAvailable = CommonBean.isSiteSpecific(con, "FM","ISSUE_FILE_AUTO_REFRESH");	/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014*/


	
	String mysql				= "SELECT maintain_doc_or_file FROM mp_param";
	try
	{
		stmt5 = con.createStatement();
		rs5   =  stmt5.executeQuery(mysql);
		if(rs5 != null && rs5.next())
		{
			maintain_doc_or_file = rs5.getString("maintain_doc_or_file");
		}

		stmt	= con.createStatement();		

		String facilityid 				= (String) session.getValue("facility_id");

		String sql								= "";
		String sql1								= "";
		String sql5								= "";
		String p_user_security_yn				= "";
		String p_print_tr_card_yn				= "";
		String p_fs_to_fs_locn_yn				= "";
		String p_auto_rec_ward_yn				= "";
		String p_auto_rec_clinic_yn				= "";
		String p_auto_rec_daycare_yn			= "";
		String p_auto_rec_procedure_yn			= "";
		String p_auto_rec_pract_yn				= "";
		String p_auto_rec_dept_yn				= "";
		String p_auto_rec_ext_yn				= "";
		String p_inactive_locn					= "";
		String p_lost_locn						= "";
		String p_fs_locn						= "";
		String p_narr_auto_track				= "";
		String p_narr_file_return				= "";
		String p_no_of_days						= "";
		String p_files_icd_yn					= "";
		String checkbox_checked					= "";
		String p_dflt_incomplete_fs_locn_code	= "";
	//	String p_dflt_admission_fs_locn_code	= "";
		String p_no_days_check_book_inquiry		= "";
		String p_link_bet_file_and_enctr_yn		= ""; 
		String accept_out_intransit_yn				= ""; 
		String mntr_fldfcy_inc_fslocn_ntdf_yn   = "";
		String autotrack_upon_confirm_pl_yn				= ""; 
		String p_function						= "insert";
		String pull_list_gen_by_gender			= "N";
		String checkbox_checked_mn              = "";
		String checkbox_val                     = "";
		/*Below Line Added for this CRF [SKR-CRF-0012]*/
		String auto_check_patient_file_request="";
		String checkbox_checked_autocheck="";
		String checkbox_val_autochk="";
		String issue_file_refresh_interval	= "";/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 17th 2014*/
	
		//sql = " SELECT user_security_yn,print_tr_card_iss_from_mr_yn,transfer_file_yn rest_fs_locn_to_fs_locn_idt_yn,link_bet_file_and_enctr_yn,auto_rec_ward_yn,auto_rec_clinic_yn,auto_rec_daycare_yn,auto_rec_procedure_yn,auto_rec_pract_yn,auto_rec_dept_yn,auto_rec_external_yn, dflt_archive_fs_locn_code dflt_inactive_fs_locn_code,dflt_lost_fs_locn_code,dflt_fs_locn_code,dflt_narr_code_for_auto_track,dflt_narr_code_for_note_rtn,no_days_check_appt_inquiry,files_icd_confirm_yn,pull_list_gen_by_gender, dflt_incomplete_fs_locn_code,/*dflt_admission_fs_locn_code,*/no_days_check_book_inquiry,accept_out_intransit_yn,autotrack_upon_confirm_pl_yn,mntr_fldfcy_inc_fslocn_ntdf_yn FROM fm_parameter WHERE facility_id = '"+facilityid+"' ";
	
	/*Above Query Commented and Below Line Added for this CRF [SKR-CRF-0012]*/
	/*ISSUE_FILE_REFRESH_INTERVAL Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 17th 2014*/
	sql = " SELECT user_security_yn,print_tr_card_iss_from_mr_yn,transfer_file_yn rest_fs_locn_to_fs_locn_idt_yn,link_bet_file_and_enctr_yn,auto_rec_ward_yn,auto_rec_clinic_yn,auto_rec_daycare_yn,auto_rec_procedure_yn,auto_rec_pract_yn,auto_rec_dept_yn,auto_rec_external_yn, dflt_archive_fs_locn_code dflt_inactive_fs_locn_code,dflt_lost_fs_locn_code,dflt_fs_locn_code,dflt_narr_code_for_auto_track,dflt_narr_code_for_note_rtn,no_days_check_appt_inquiry,files_icd_confirm_yn,pull_list_gen_by_gender, dflt_incomplete_fs_locn_code,/*dflt_admission_fs_locn_code,*/no_days_check_book_inquiry,accept_out_intransit_yn,autotrack_upon_confirm_pl_yn,mntr_fldfcy_inc_fslocn_ntdf_yn,auto_check_pat_file_request,issue_file_refresh_interval FROM fm_parameter WHERE facility_id = '"+facilityid+"' ";
	
	
		rs = stmt.executeQuery(sql);
		if(rs != null)
		{
			while (rs.next())
		   {
				p_function = "modify";

				p_user_security_yn				= rs.getString("user_security_yn");
				p_print_tr_card_yn				= rs.getString("print_tr_card_iss_from_mr_yn");
				p_fs_to_fs_locn_yn				= rs.getString("rest_fs_locn_to_fs_locn_idt_yn");
				p_auto_rec_ward_yn				= rs.getString("auto_rec_ward_yn");
				p_auto_rec_clinic_yn			= rs.getString("auto_rec_clinic_yn");
				p_auto_rec_daycare_yn			= rs.getString("auto_rec_daycare_yn");
				p_auto_rec_procedure_yn			= rs.getString("auto_rec_procedure_yn");
				p_auto_rec_pract_yn				= rs.getString("auto_rec_pract_yn");
				p_auto_rec_dept_yn				= rs.getString("auto_rec_dept_yn");
				p_auto_rec_ext_yn				= rs.getString("auto_rec_external_yn");
				p_inactive_locn					= rs.getString("dflt_inactive_fs_locn_code");
				p_lost_locn						= rs.getString("dflt_lost_fs_locn_code");
				p_fs_locn						= rs.getString("dflt_fs_locn_code");
				p_narr_auto_track				= rs.getString("dflt_narr_code_for_auto_track");
				p_narr_file_return				= rs.getString("dflt_narr_code_for_note_rtn");
				p_no_of_days					= rs.getString("no_days_check_appt_inquiry");
				p_files_icd_yn					= rs.getString("files_icd_confirm_yn");
				pull_list_gen_by_gender			= rs.getString("pull_list_gen_by_gender");
				p_dflt_incomplete_fs_locn_code	= rs.getString("dflt_incomplete_fs_locn_code");
				//p_dflt_admission_fs_locn_code	= rs.getString("dflt_admission_fs_locn_code");
				p_no_days_check_book_inquiry	= rs.getString("no_days_check_book_inquiry");
				p_link_bet_file_and_enctr_yn    = rs.getString("link_bet_file_and_enctr_yn"); 	
				accept_out_intransit_yn    = rs.getString("accept_out_intransit_yn"); 	
				autotrack_upon_confirm_pl_yn    = rs.getString("autotrack_upon_confirm_pl_yn"); 	
				mntr_fldfcy_inc_fslocn_ntdf_yn  = rs.getString("mntr_fldfcy_inc_fslocn_ntdf_yn"); 
				/*Below Line Added for this CRF [SKR-CRF-0012]*/
				auto_check_patient_file_request  = rs.getString("auto_check_pat_file_request"); 
				issue_file_refresh_interval		= (rs.getString("issue_file_refresh_interval")==null || rs.getString("issue_file_refresh_interval")=="") ? "" : rs.getString("issue_file_refresh_interval");/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 17th 2014*/
			}	
		}	
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	
		if(p_user_security_yn == null) p_user_security_yn = "N";
		if(p_print_tr_card_yn == null) p_print_tr_card_yn = "N";
		if(p_fs_to_fs_locn_yn == null) p_fs_to_fs_locn_yn = "N";
		if(p_auto_rec_ward_yn == null) p_auto_rec_ward_yn = "N";
		if(p_auto_rec_clinic_yn == null) p_auto_rec_clinic_yn = "N";
		if(p_auto_rec_daycare_yn == null) p_auto_rec_daycare_yn = "N";
		if(p_auto_rec_procedure_yn == null) p_auto_rec_procedure_yn = "N";
		if(p_auto_rec_pract_yn == null) p_auto_rec_pract_yn = "N";
		if(p_auto_rec_dept_yn == null) p_auto_rec_dept_yn = "N";
		if(p_auto_rec_ext_yn == null) p_auto_rec_ext_yn = "N";
		if(p_files_icd_yn == null) p_files_icd_yn = "N";
		if(p_no_of_days == null) p_no_of_days = "";
		if(pull_list_gen_by_gender == null) pull_list_gen_by_gender = "N";
		if(p_link_bet_file_and_enctr_yn == null) p_link_bet_file_and_enctr_yn = "N";
		if(accept_out_intransit_yn == null) accept_out_intransit_yn = "N";
		if(autotrack_upon_confirm_pl_yn == null) autotrack_upon_confirm_pl_yn = "N";
		if(p_dflt_incomplete_fs_locn_code == null) p_dflt_incomplete_fs_locn_code = "";
		//if(p_dflt_admission_fs_locn_code == null) p_dflt_admission_fs_locn_code = "";
		if(p_no_days_check_book_inquiry == null)	p_no_days_check_book_inquiry = "";
		if(mntr_fldfcy_inc_fslocn_ntdf_yn == null)	mntr_fldfcy_inc_fslocn_ntdf_yn = "N";
		/*Below Line Added for this CRF [SKR-CRF-0012]*/
		if(auto_check_patient_file_request==null)auto_check_patient_file_request="N";

		sql5 = "SELECT fs_locn_code, short_desc long_desc FROM fm_storage_locn WHERE eff_status = 'E' AND mr_locn_yn='Y' AND permanent_file_area_yn = 'Y' and  facility_id = '"+facilityid+"' ORDER BY 2";
		stmt = con.createStatement(); 
		rs = stmt.executeQuery(sql5);

		String p_fs_locn_code = "";
		String p_fs_locn_desc = "";

		sql = "SELECT fs_locn_code, short_desc long_desc FROM fm_storage_locn WHERE eff_status = 'E' AND  facility_id = '"+facilityid+"' ORDER BY 2";
		stmt1 = con.createStatement();
		rs1 = stmt1.executeQuery(sql);

		String sql3 = "SELECT fs_locn_code, short_desc long_desc FROM fm_storage_locn WHERE eff_status='E' AND  locn_identity = 'D' AND  facility_id = '"+facilityid+"' ORDER BY 2";
		stmt3 = con.createStatement();
		rs3 = stmt3.executeQuery(sql3);

		String sql4 = "SELECT fs_locn_code, short_desc long_desc FROM fm_storage_locn WHERE eff_status = 'E' and  locn_identity = 'N' AND  facility_id = '"+facilityid+"' ORDER BY 2";
		stmt4 = con.createStatement();
		rs4 = stmt4.executeQuery(sql4);

		sql1 = "SELECT narration_code,short_desc long_desc from fm_narration WHERE eff_status='E' ORDER BY 2";
		stmt2 = con.createStatement();
		rs2= stmt2.executeQuery(sql1);

		String p_fs_narr_code = "";
		String p_fs_narr_desc = "";
%>
		<TABLE border='0' cellpadding='3' cellspacing='0' width='95%' align='center'>
			<TR>
				<Th colspan='4' class='columnheader' align='left'><fmt:message key="eFM.SecurityRules.label" bundle="${fm_labels}"/></Th>
			</TR>
			<TR>
				<TD width='30%' class='label'><fmt:message key="eFM.SecurityAccesstobeenforced.label" bundle="${fm_labels}"/></TD>
				<TD width='20%'  class='fields'>
				<%
					if(p_user_security_yn.equals("Y")) checkbox_checked = "checked";
					else checkbox_checked = "";
				%>
				<input type='checkbox' name='security_appl_to_users_yn' id='security_appl_to_users_yn' value='<%=p_user_security_yn%>' <%=checkbox_checked%> onClick="checkbox_value(this)">
				</TD>
				<TD width='30%' class= 'label'><fmt:message key="eFM.Transferof.label" bundle="${fm_labels}"/> <%
			if(maintain_doc_or_file.equals("D"))
			{
		%>Document <%
		}
		else
		{
	%>File <%		
		}
	%> outside MRD is Allowed</TD>
				<TD width='20%' class='fields'>
				<% 
					if(p_fs_to_fs_locn_yn.equals("Y")) checkbox_checked = "checked";
					else checkbox_checked = "";
				%>
				<input type='checkbox' name='rest_movement_yn' id='rest_movement_yn' value='<%=p_fs_to_fs_locn_yn%>' <%=checkbox_checked%> onClick="checkbox_value(this)">
				</TD>
			</TR>
			<TR><Th colspan='4' class='columnheader' align='left' ><fmt:message key="eFM.TracerCard.label" bundle="${fm_labels}"/></Th></TR>
			<TR>
				<TD class='label'><fmt:message key="eFM.PrintTracerCardonIssueof.label" bundle="${fm_labels}"/> <%
			if(maintain_doc_or_file.equals("D"))
			{
		%>documents <%
		}
		else
		{
	%>files<%		
		}
	%> </TD>
				<TD  class='fields'>
				<%
					if(p_print_tr_card_yn.equals("Y")) checkbox_checked = "checked";
					else checkbox_checked = ""; 		
				%>
				<input type='checkbox' name='print_tracer_card_yn' id='print_tracer_card_yn' value='<%=p_print_tr_card_yn%>' <%=checkbox_checked%> onClick="checkbox_value(this)">
				</TD>
				<TD  class='label'></TD>
				<TD  class='QUERYDATA'></td>
			</TR>
			<TR><Th colspan='4' class='columnheader' align='left'><fmt:message key="eFM.AutoReceiptRules.label" bundle="${fm_labels}"/></Th></TR>
			<TR><TD  class='label'> <b><fmt:message key="eFM.AutoReceive.label" bundle="${fm_labels}"/> <%
			if(maintain_doc_or_file.equals("D"))
			{
		%>Document <%
		}
		else
		{
	%>File<%		
		}
	%> on Issue to :</b>
		</TD>
		<td class='label' colspan='3'></td>
		</TR>
		<!-- </TABLE>
		<TABLE border='1' cellpadding='0' cellspacing='0' width='95%' align='center'> -->
			<TR>
				<TD  class='label'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></TD>
				<TD  class='fields'>
				<%
					if(p_auto_rec_ward_yn.equals("Y")) checkbox_checked = "checked";
					else checkbox_checked = "";
				%>
				<input type='checkbox' name='nursing_unit_yn' id='nursing_unit_yn' value='<%=p_auto_rec_ward_yn%>' <%=checkbox_checked%> onClick="checkbox_value(this)" >
				</TD>
				<TD  class='label'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></TD>
				<TD  class='fields'>
				<%
					if(p_auto_rec_clinic_yn.equals("Y")) checkbox_checked = "checked";
					else checkbox_checked = "";	
				%>
				<input type='checkbox' name='clinic_yn' id='clinic_yn' value='<%=p_auto_rec_clinic_yn%>' <%=checkbox_checked%> onClick="checkbox_value(this)">
				</TD>
				</tr>
				<tr>
				<TD  class='label'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></TD>
				<TD  class='fields'>
				<%
					if(p_auto_rec_daycare_yn.equals("Y")) checkbox_checked = "checked";
					else checkbox_checked = "";
				%>
				<input type='checkbox' name='daycare_yn' id='daycare_yn' value='<%=p_auto_rec_daycare_yn%>' <%=checkbox_checked%> onClick="checkbox_value(this)">
				</TD>
				<TD   class='label'><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></TD>
				<TD   class='fields'>
				<%
					if(p_auto_rec_procedure_yn.equals("Y")) checkbox_checked="checked";
					else checkbox_checked = "";
				%>
				<input type='checkbox' name='procedure_yn' id='procedure_yn' value='<%=p_auto_rec_procedure_yn%>' <%=checkbox_checked%> onClick="checkbox_value(this)">
				</TD>
			</TR>
			<TR>
				<TD   class= 'label'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></TD>
				<TD  class='fields'>
				<%
					if(p_auto_rec_pract_yn.equals("Y")) checkbox_checked = "checked";
					else checkbox_checked = "";
				%>
				<input type=checkbox name=practitioner_yn value='<%=p_auto_rec_pract_yn%>' <%=checkbox_checked%> onClick="checkbox_value(this)">
				</TD>
				<TD    class= 'label'><fmt:message key="Common.department.label" bundle="${common_labels}"/></TD>
				<TD class='fields'>
				<%
					if(p_auto_rec_dept_yn.equals("Y")) checkbox_checked = "checked";
					else checkbox_checked = "";
				%>
				<input type=checkbox name=department_yn value='<%=p_auto_rec_dept_yn%>' <%=checkbox_checked%> onClick="checkbox_value(this)">
				</TD>
				</tr>
				<tr>
				<TD   class= 'label'><fmt:message key="Common.OtherFacility.label" bundle="${common_labels}"/></TD>
				<TD  class='fields'>
				<%
					if(p_auto_rec_ext_yn.equals("Y")) checkbox_checked = "checked";
					else checkbox_checked = "";
				%>
				<input type=checkbox name=external_yn value='<%=p_auto_rec_ext_yn%>' <%=checkbox_checked%> onClick="checkbox_value(this)">
				</TD>
				<TD colspan='2'></TD>
			</TR>
		</TABLE>

		<TABLE border='0' cellpadding='3' cellspacing='0' width='95%' align='center'>
			<TR><Th colspan = '4' class='columnheader' align='left'><fmt:message key="eFM.DefaultSettings.label" bundle="${fm_labels}"/></Th></TR>
			<TR>
				<TD width ='30%'  class= 'label'><fmt:message key="eFM.PermanentFSLocation.label" bundle="${fm_labels}"/></TD>
				<TD width = '20%' class='fields'>
					<select name=mrd_code>
					<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<%
					while (rs.next())
					{
						p_fs_locn_code = rs.getString("FS_LOCN_CODE");
						p_fs_locn_desc = rs.getString("LONG_DESC");

						if(p_fs_locn_code.equals(p_fs_locn))
						{
							%>
							<option value='<%=p_fs_locn_code%>' selected><%=p_fs_locn_desc%>
							<%
						}
						else 
						{
							%>
							<option value='<%=p_fs_locn_code%>'><%=p_fs_locn_desc%>
							<%
						}
					}
					if(rs!=null) rs.close();
					%>
					</select><img src='../../eCommon/images/mandatory.gif' align='center'></img> 
				</TD>
				<TD width='30%' class= 'label'><fmt:message key="eFM.InactiveFSLocation.label" bundle="${fm_labels}"/></TD>
				<TD  class='fields' width='20%'>
					<select name=inactive_code>
					<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<%
					p_fs_locn_code = "";
					p_fs_locn_desc = "";

					while(rs3.next())
					{
						p_fs_locn_code = rs3.getString("FS_LOCN_CODE");
						p_fs_locn_desc = rs3.getString("LONG_DESC");
				
						if(p_fs_locn_code.equals(p_inactive_locn))
						{
							%>
							<option value='<%=p_fs_locn_code%>' selected><%=p_fs_locn_desc%>
							<%
						}
						else
						{
							%>
							<option value='<%=p_fs_locn_code%>' ><%=p_fs_locn_desc%>
							<%
						}
					}
					if(rs3!=null)	rs3.close();
					%>
					</select><img src='../../eCommon/images/mandatory.gif' align='center'></img> 
				</TD>
			</TR>
			<TR>
				<TD  class= 'label'><fmt:message key="eFM.LostFSLocation.label" bundle="${fm_labels}"/></TD>
				<TD  class='fields'>
				<select name=lost_code>
				<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<%
				rs3=stmt3.executeQuery(sql3);
				while (rs3.next())
				{
					p_fs_locn_code = rs3.getString("FS_LOCN_CODE");
					p_fs_locn_desc = rs3.getString("LONG_DESC");
						
					if(p_fs_locn_code.equals(p_lost_locn))
					{
						%>
						<option value='<%=p_fs_locn_code%>' selected><%=p_fs_locn_desc%>
						<%
					}
					else
					{
						%>
						<option value='<%=p_fs_locn_code%>' ><%=p_fs_locn_desc%>
						<%
					}
				}
				if(rs3!=null) rs3.close();
				%>
				</select><img src='../../eCommon/images/mandatory.gif' align='center'></img> 
				</TD>
				<TD   class= 'label'><fmt:message key="eFM.IncompleteFSLocation.label" bundle="${fm_labels}"/></TD>
				<TD  class='fields'>
				<select name=dflt_incomplete_fs_locn_code  onChange ='disableMonitorFileDef(this);'>
				<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<%
				rs3 = stmt.executeQuery(sql3);
				while(rs3.next())
				{
					p_fs_locn_code = rs3.getString("FS_LOCN_CODE");
					p_fs_locn_desc = rs3.getString("LONG_DESC");
					
					if(p_fs_locn_code.equals(p_dflt_incomplete_fs_locn_code))
					{
						%>
						<option value='<%=p_fs_locn_code%>' selected><%=p_fs_locn_desc%>
						<%
					}
					else
					{
						%>
						<option value='<%=p_fs_locn_code%>' ><%=p_fs_locn_desc%>
						<%
					}
				}
				%>
				</select></img> 
				</TD>
			</TR>
			<TR>
				 
				</TD>
				<TD    class= 'label'><fmt:message key="eFM.NarrationforAutoTrackouttoOPD.label" bundle="${fm_labels}"/></TD>
				<TD   class='fields'>
				<select name=auto_track_narr_code>
				<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<%
				while(rs2.next())
				{
					p_fs_narr_code = rs2.getString("NARRATION_CODE");
					p_fs_narr_desc = rs2.getString("LONG_DESC");
						
					if (p_fs_narr_code.equals(p_narr_auto_track))
					{
						%>
						<option value='<%=p_fs_narr_code%>' selected><%=p_fs_narr_desc%>
						<%
					}
					else
					{
						%>
						<option value='<%=p_fs_narr_code%>' ><%=p_fs_narr_desc%>
						<%
					}
				}
				if(rs2!=null) rs2.close();
				%>
				</select><img src='../../eCommon/images/mandatory.gif' align='center'></img> 
				</TD>


				<TD  class= 'label'><fmt:message key="eFM.NarrForReturnFileToMRD.label" bundle="${fm_labels}"/></TD>
				<TD   class='fields'>
				<select name=return_files_mr_code>
				<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<%
				rs2=stmt2.executeQuery(sql1);
				while (rs2.next())
				{
					p_fs_narr_code = rs2.getString("NARRATION_CODE");
					p_fs_narr_desc = rs2.getString("LONG_DESC");
						
					if(p_fs_narr_code.equals(p_narr_file_return))
					{
						%>
						<option value='<%=p_fs_narr_code%>' selected><%=p_fs_narr_desc%>
						<%
					}
					else
					{
						%>
						<option value='<%=p_fs_narr_code%>' ><%=p_fs_narr_desc%>
						<%
					}
				}
				%>
				</select>
				</TD>
			</TR>
			
			<TR><Th colspan = '4' class='columnheader' align='left'><fmt:message key="eFM.OtherRules.label" bundle="${fm_labels}"/></Th></TR>
	<!-- 	</TABLE>

		<TABLE border='1' cellpadding='0' cellspacing='0' width='95%' align='center'> -->
			<TR>
				<TD  class= 'label' colspan = '2'><fmt:message key="eFM.NoofDaysuptowhichtocheckforappointmentsinFileInquiry.label" bundle="${fm_labels}"/></TD>
				<TD  class='fields'><input type=text name=no_of_days_notes_inquiry size=3 maxlength=3 value='<%=p_no_of_days%>' onKeyPress='return  allowValidNumber(this,event,3,0);' onBlur="CheckNumber(this)" >
				</TD>
				<TD  class='QUERYDATA'>
				</TD>
			</TR>
			<TR>
				<TD  class= 'label' colspan = '2'><fmt:message key="eFM.NoofDaysuptowhichtocheckforbookingsinFileInquiry.label" bundle="${fm_labels}"/></TD>
				<TD  class='fields'><input  type=text name=no_days_check_book_inquiry size=3 maxlength=3 value='<%=p_no_days_check_book_inquiry%>' onBlur="CheckNumber(this)" onKeyPress='return  allowValidNumber(this,event,3,0);'>
				</TD>
				<TD class='QUERYDATA'>
				</TD>
			</TR>
			<TR>
			<%
				if(pull_list_gen_by_gender.equals("Y")) checkbox_checked = "checked";
				else checkbox_checked = ""; 

				String dis_pull_list_gen_by_gender = "pull_list_gen_by_gender";
				String pull_list_name1 = "" ;

				if(p_function.equals("modify"))
				{
					dis_pull_list_gen_by_gender = "disabled";
					pull_list_name1				= "pull_list_gen_by_gender1"	;
					out.println("<input type = hidden name = pull_list_gen_by_gender value = '"+pull_list_gen_by_gender+"'>");
				}
				%>
				<TD  class= 'label' colspan = '2'><fmt:message key="eFM.ControlPullingListGenerationbyGender.label" bundle="${fm_labels}"/></TD>
				<TD  class='fields'><input type=checkbox name=<%=pull_list_name1%> value='<%=pull_list_gen_by_gender%>' <%=checkbox_checked%> <%=dis_pull_list_gen_by_gender%> onclick ="checkbox_value(this)" >
				</TD>
				<TD  class='QUERYDATA'>
				</TD>
			</TR>
			<TR>
				<TD  class= 'label' colspan = '2'><fmt:message key="eFM.LinkBetweenFileandEncounterRequired.label" bundle="${fm_labels}"/></TD>
				<TD  class='fields'>
				<%
					if(p_link_bet_file_and_enctr_yn.equals("Y")) checkbox_checked = "checked";
					else checkbox_checked = "";
				%>
				<input type=checkbox name="link_bet_file_and_enctr_yn" id="link_bet_file_and_enctr_yn" value='<%=p_link_bet_file_and_enctr_yn%>' <%=checkbox_checked%> onClick="checkbox_value(this)" >
				</TD>
				<TD   class='QUERYDATA'></td>
			</TR>

			<TR>
				<TD  class= 'label' colspan = '2'><fmt:message key="eFM.AcceptOutsideTransitFiles.label" bundle="${fm_labels}"/></TD>
				<TD  class='fields'>
				<%
					if(accept_out_intransit_yn.equals("Y")) checkbox_checked = "checked";
					else checkbox_checked = "";
				%>
				<input type=checkbox name="accept_out_intransit_yn" id="accept_out_intransit_yn" value='Y' <%=checkbox_checked%> >
				</TD>
				<TD   class='QUERYDATA'></td>
			</TR>

			<TR>
				<TD  class= 'label' colspan = '2'><fmt:message key="eFM.AutoTrackOutUponCnPL.label" bundle="${fm_labels}"/></TD>
				<TD  class='fields'>
				<%
				String disable_auto_track = "";
				if(p_function.equals("modify"))
					disable_auto_track = "disabled";
				else
					disable_auto_track = "";

					if(autotrack_upon_confirm_pl_yn.equals("Y")) checkbox_checked = "checked";
					else checkbox_checked = "";
				%>
				<input type=checkbox name="autotrack_upon_confirm_pl_yn" id="autotrack_upon_confirm_pl_yn" value='Y' <%=checkbox_checked%> <%=disable_auto_track%> >
				</TD>
				<TD   class='QUERYDATA'></td>
			</TR>
			<TR>
				<TD  class= 'label' colspan = '2'><fmt:message key="eFM.EnableMonitorFileDefFSLocation.label" bundle="${fm_labels}"/></TD>
				<TD  class='fields'>
				<%
					if(mntr_fldfcy_inc_fslocn_ntdf_yn.equals("Y"))
					{ 
						checkbox_checked_mn = "checked";
						checkbox_val ="Y";
					}
					else 
					{
						checkbox_checked_mn = "";
						checkbox_val ="N";
					}
				%>

				<input type=checkbox name="enable_Monitor_FDefFSL_yn" id="enable_Monitor_FDefFSL_yn"  value='<%=checkbox_val%>' onclick='chkValue(this);' <%=checkbox_checked_mn%>>
				</TD>
				<TD   class='QUERYDATA'></td>
			</TR>
			
			<%/*Below Line Added for this CRF [SKR-CRF-0012]*/%>
			
			<TR>
				<TD  class= 'label' colspan = '2'><fmt:message key="eFM.AutoCheckPrintPatientFileRequestSlip.label" bundle="${fm_labels}"/></TD>
				<TD  class='fields'>
				<%
					if(auto_check_patient_file_request.equals("Y"))
					{ 
						checkbox_checked_autocheck = "checked";
						checkbox_val_autochk ="Y";
					}
					else 
					{
						checkbox_checked_autocheck = "";
						checkbox_val_autochk ="N";
					}
					
					
				%>

				<input type=checkbox name="auto_chk_patient_file_request" id="auto_chk_patient_file_request"  value='<%=checkbox_val_autochk%>' onclick='chkAutoPatFile(this);' <%=checkbox_checked_autocheck%>>
				</TD>
				<TD   class='QUERYDATA'></td>
			</TR>
			<%/*Above Line Added for this CRF [SKR-CRF-0012]*/%>
			<!--Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 17th 2014 Start -->
			<%if(isRefreshIntervalAvailable){ %>
				 <tr>
	               <td class='label' colspan='2'><fmt:message key="eFM.RefreshIntervalforIssuefile.label" bundle="${fm_labels}"/></td>
	               <td class='fields querydata' ><input type='text' name=issue_file_refresh_interval maxlength=4 size=4 onBlur='CheckNum(this);checkvalid(this);' value="<%=issue_file_refresh_interval%>" onKeyPress='return(ChkNumberInput(this,event,0))'><img src='../../eCommon/images/mandatory.gif'> &nbsp;<fmt:message key="Common.MIN.label" bundle="${common_labels}"/></td>
	             </tr>
             <% }%>
             <!--Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 17th 2014 End -->
			
		</TABLE>
		<input type='hidden' name='isRefreshIntervalAvailable' id='isRefreshIntervalAvailable' value='<%=isRefreshIntervalAvailable%>' > <!--Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 -->
		<input type='hidden' name=functionval value='<%=p_function%>'>
		<input type='hidden' name=return_of_files_yn value='N'>
		</FORM>
		<%
		if(stmt!=null) stmt.close();
		if(stmt1!=null) stmt1.close();
		if(stmt2!=null) stmt2.close();
		if(stmt3!=null) stmt3.close();
		if(stmt4!=null) stmt4.close();
		if(stmt5!=null) stmt5.close();
		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if(rs2!=null) rs2.close();
		if(rs3!=null) rs3.close();
		if(rs4!=null) rs4.close();
		if(rs5!=null) rs5.close();
	}
	catch(Exception e) { out.println(e); 
	e.printStackTrace();}
	finally 
	{	
		ConnectionManager.returnConnection(con,request);
	}
%>
</BODY>
</HTML>


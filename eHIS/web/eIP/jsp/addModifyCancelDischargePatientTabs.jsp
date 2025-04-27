<!DOCTYPE html>
<html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HEAD>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eIP/js/CancelDischarge.js' language='javascript'></script>
	<script src='../../eIP/js/IPPractitionerComponent.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection con	= null;
	Statement stmt 	= null;
	ResultSet rset	= null;
	Statement stmt1 = null;
	ResultSet rset1	= null;
	PreparedStatement pstmt = null;//Added by Ajay Hatwate for AAKH-CRF-0179
	con		= ConnectionManager.getConnection(request);
	/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
	boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MLC_TO_MEDICO_LEGAL_CASE"); 
	/*end ML-MMOH-CRF-0354 [IN057191] */
	String locale					= (String)session.getAttribute("LOCALE");
	String bl_operational			= (String)session.getValue("bl_operational");
	String serverDate				= "";
	String facilityId				= checkForNull((String)session.getAttribute("facility_id"));
	String locn_code				= checkForNull(request.getParameter("location_code"));
	String eid						= checkForNull(request.getParameter("encounter_id"));
	long encounterid				= Long.parseLong(eid);
	String post_mortem_req_yn		= checkForNull(request.getParameter("post_mortem_req_yn"));
	String to_ref_code				= checkForNull(request.getParameter("to_ref_code"));
	String to_specialty_code		= checkForNull(request.getParameter("to_specialty_code"));
	String to_service_code			= checkForNull(request.getParameter("to_service_code"));
	String to_locn_type				= checkForNull(request.getParameter("to_locn_type"));
	String to_locn_code				= checkForNull(request.getParameter("to_locn_code"));
	String med_lgl_case_yn			= checkForNull(request.getParameter("med_lgl_case_yn"));
	String informed_to				= checkForNull(request.getParameter("informed_to"));
	String informed_date_time		= checkForNull(request.getParameter("informed_date_time")); 
	/*String informed_name			= checkForNull(request.getParameter("informed_name"));
	String pol_rep_no				= checkForNull(request.getParameter("pol_rep_no"));
	String pol_stn_id				= checkForNull(request.getParameter("pol_stn_id"));
	String pol_id					= checkForNull(request.getParameter("pol_id"));
	String reported_to				= checkForNull(request.getParameter("reported_to"));
	String blocking_remarks			= checkForNull(request.getParameter("blocking_remarks"));
	String discharge_narration		= checkForNull(request.getParameter("discharge_narration"));*/
	/*
	String informed_name			= (String)pageContext.getAttribute("informed_name",pageContext.SESSION_SCOPE);
	String pol_rep_no				= (String)pageContext.getAttribute("pol_rep_no",pageContext.SESSION_SCOPE);
	String pol_stn_id				= (String)pageContext.getAttribute("pol_stn_id",pageContext.SESSION_SCOPE);
	String pol_id					= (String)pageContext.getAttribute("pol_id",pageContext.SESSION_SCOPE);
	String discharge_narration		= (String)pageContext.getAttribute("discharge_narration",pageContext.SESSION_SCOPE);
	String reported_to				= (String)pageContext.getAttribute("reported_to",pageContext.SESSION_SCOPE);
	String blocking_remarks			= (String)pageContext.getAttribute("blocking_remarks",pageContext.SESSION_SCOPE);

	pageContext.removeAttribute("discharge_narration",pageContext.SESSION_SCOPE);
	pageContext.removeAttribute("reported_to",pageContext.SESSION_SCOPE);
	pageContext.removeAttribute("informed_name",pageContext.SESSION_SCOPE);
	pageContext.removeAttribute("pol_rep_no",pageContext.SESSION_SCOPE);
	pageContext.removeAttribute("pol_stn_id",pageContext.SESSION_SCOPE);
	pageContext.removeAttribute("pol_id",pageContext.SESSION_SCOPE);
	pageContext.removeAttribute("blocking_remarks",pageContext.SESSION_SCOPE);
	*/
	String blocking_remarks			= "";
	String discharge_narration		= "";
	String reported_to				= "";
	String informed_name			= "";
	String pol_rep_no				= "";
	String pol_stn_id				= "";
	String pol_id					= "";
	try
	{
/* 		stmt	 = con.createStatement(); */
		pstmt	 = con.prepareStatement("select reported_to,informed_name,pol_rep_no,pol_stn_id,pol_id,discharge_narration from ip_discharge_advice where facility_id = ? and encounter_id = ? and dis_adv_status = '1'");
		pstmt.setString(1, facilityId);
		pstmt.setLong(2, encounterid);
		rset = pstmt.executeQuery();
		if(rset != null && rset.next()) {
			informed_name			= checkForNull(rset.getString("informed_name"));
			pol_rep_no				= checkForNull(rset.getString("pol_rep_no"));
			pol_stn_id				= checkForNull(rset.getString("pol_stn_id"));
			pol_id					= checkForNull(rset.getString("pol_id"));
			discharge_narration		= checkForNull(rset.getString("discharge_narration"));
			reported_to				= checkForNull(rset.getString("reported_to"));
		}
		if(rset != null) rset.close(); 
		if(pstmt != null) pstmt.close();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	String admission_date_time		= checkForNull(request.getParameter("admission_date_time"));
	//String admission_short_desc	= checkForNull(request.getParameter("admission_short_desc"));
	//String specialty_short_desc	= checkForNull(request.getParameter("specialty_short_desc"));
	String practitioner_name		= checkForNull(request.getParameter("practitioner_name"));
	//String patient_type_short_desc= checkForNull(request.getParameter("patient_type_short_desc"));
	//String nursing_unit_short_desc= checkForNull(request.getParameter("nursing_unit_short_desc"));
	//String service_short_desc		= checkForNull(request.getParameter("service_short_desc"));
	String bed_no					= checkForNull(request.getParameter("bed_no"));
	String room_no					= checkForNull(request.getParameter("room_no"));
	//String bed_class_short_desc	= checkForNull(request.getParameter("bed_class_short_desc"));
	String patient_id				= checkForNull(request.getParameter("patient_id"));
	String bed_type_code			= checkForNull(request.getParameter("bed_type_code"));
	String bed_class_code			= checkForNull(request.getParameter("bed_class_code"));
	String practitioner_id			= checkForNull(request.getParameter("practitioner_id"));
	String specialty_code			= checkForNull(request.getParameter("specialty_code")); 
	String auth_practitioner_id		= checkForNull(request.getParameter("auth_practitioner_id"));
	String auth_practitioner_name	= checkForNull(request.getParameter("auth_practitioner_name"));
	
	String nursing_unit_code		= checkForNull(request.getParameter("nursing_unit_code"));
	String service_code				= checkForNull(request.getParameter("service_code"));
	String patient_type				= checkForNull(request.getParameter("patient_type"));
	String gender					= checkForNull(request.getParameter("gender"));
	String date_of_birth			= checkForNull(request.getParameter("date_of_birth"));
	String locn_type				= checkForNull(request.getParameter("locn_type"));
	String patient_class			= checkForNull(request.getParameter("patient_class"));
	String patient_status			= checkForNull(request.getParameter("patient_status"));
	String absconded_date			= checkForNull(request.getParameter("absconded_date"));
	//String absconded_yn			= checkForNull(request.getParameter("absconded_yn"));
	
	String EXPECTED_DISCHARGE_DATE	= checkForNull(request.getParameter("EXPECTED_DISCHARGE_DATE"));
	String discharge_date_time		= checkForNull(request.getParameter("discharge_date_time"));
	String discharge_type_desc		= checkForNull(request.getParameter("discharge_type_desc"));
	//String last_encounter_inform_to= checkForNull(request.getParameter("last_encounter_inform_to"));
	//String last_encounter_inform_name	= checkForNull(request.getParameter("last_encounter_inform_name"));
	String last_encounter_inform_date_time	= checkForNull(request.getParameter("last_encounter_inform_date_time"));
	//String bed_block_date_time		= checkForNull(request.getParameter("bed_block_date_time"));
	String bed_block_date_time		= "";
	String body_released_date_time	= checkForNull(request.getParameter("body_release_date_time"));
	//String blocking_type_code		= checkForNull(request.getParameter("blocking_type_code"));
	//String blocking_type_desc		= checkForNull(request.getParameter("blocking_type_desc"));
	String blocking_type_desc		= "";
	String informed_to_desc			= "";
	String highriskbody				= checkForNull(request.getParameter("high_risk_body_yn"));
	String discharge_date			= checkForNull(request.getParameter("discharge_date"));
	String assign_care_locn_type	= checkForNull(request.getParameter("assign_care_locn_type"));
	String admission_type			= checkForNull(request.getParameter("admission_type"));
	String disposition_type			= checkForNull(request.getParameter("disposition_type"));
	String referral_id				= checkForNull(request.getParameter("referral_id"));
	String discharge_status_code	= checkForNull(request.getParameter("discharge_status_code"));
	//String function_id			= checkForNull(request.getParameter("function_id"));
	String mo_install_yn			= "";
	//int no_of_record				= 0;
	String is_mo_mortuary_regn		= "N";
	StringBuffer chk_request		= new StringBuffer();
	try
	{
		if(!((nursing_unit_code==null || nursing_unit_code.equals("")) || (bed_no==null || bed_no.equals(""))))
		{

			if (chk_request.length() > 0)
					chk_request.delete(0,chk_request.length());

			chk_request.append(" SELECT ");
			chk_request.append(" blocking_type_code, IP_GET_DESC.IP_BLOCKING_TYPE(blocking_type_code,?,2) blocking_type_desc, TO_CHAR (blocked_until_date_time,'dd/mm/rrrr hh24:mi') blocked_until_date_time,blocking_remarks ");    
			chk_request.append(" from  ip_bed_booking");
			chk_request.append(" WHERE facility_id = ? ");
			//stringBuffer.append(" AND patient_id = '"+patient_id+"' ");
			chk_request.append(" AND booking_type = 'D'  ");
			chk_request.append(" AND req_nursing_unit_code = ?  ");
			chk_request.append(" AND req_bed_no =   ? ");
			chk_request.append(" AND booking_status = '0'  ");
			chk_request.append(" AND blocked_until_date_time IN( SELECT MAX(blocked_until_date_time) FROM ip_bed_booking  WHERE req_bed_no = ?  AND req_nursing_unit_code = ?  AND booking_type = 'D'     AND booking_status = '0' AND facility_id = ?)  ");

/* 			stmt	 = con.createStatement();
			rset	 =	 stmt.executeQuery(chk_request.toString()); */
			pstmt	 = con.prepareStatement(chk_request.toString());
			pstmt.setString(1, locale);
			pstmt.setString(2, facilityId);
			pstmt.setString(3, nursing_unit_code);
			pstmt.setString(4, bed_no);
			pstmt.setString(5, bed_no);
			pstmt.setString(6, nursing_unit_code);
			pstmt.setString(7, facilityId);
			rset	= pstmt.executeQuery();
			if(rset != null && rset.next())
			{
				blocking_type_desc		= checkForNull(rset.getString("blocking_type_desc"));
				bed_block_date_time		= checkForNull(rset.getString("blocked_until_date_time"));
				blocking_remarks		= checkForNull(rset.getString("blocking_remarks"));				
			}

			if(rset != null) rset.close(); 
			if(pstmt != null) pstmt.close();

		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	/* Added by Ajay Hatwate for AAKH-CRF-0179 on 22/08/2023 */
	Boolean isDeathRegisterFormAppl = false;
	String enable_death_reg_form = "N";
	String death_reg_form_accession_num = "";
	String deceased_yn = "N";
	isDeathRegisterFormAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "DEATH_REGISTER_FORM_APPL"); //Added by Ajay Hatwate for AAKH-CRF-0179 on 22-08-2023
	if(isDeathRegisterFormAppl){
				enable_death_reg_form	= eMP.MPCommonBean.getEnableDeathRegisterFormYN(con);		
		if(enable_death_reg_form.equals("Y")){
			try{
				pstmt = con.prepareStatement(" SELECT death_reg_form_accession_num,(select deceased_yn from ip_discharge_type_lang_vw where discharge_type_code = ? and language_id = ? and eff_status = 'E') deceased_yn  FROM PR_ENCOUNTER WHERE FACILITY_ID=? and ENCOUNTER_ID = ?");
				pstmt.setString(1, disposition_type);
				pstmt.setString(2, locale);
				pstmt.setString(3, facilityId);
				pstmt.setString(4, String.valueOf(encounterid));
				rset = pstmt.executeQuery();
				if(rset != null && rset.next()) {
					death_reg_form_accession_num	= checkForNull(rset.getString("death_reg_form_accession_num"));
					deceased_yn	= checkForNull(rset.getString("deceased_yn"));
				}
			}
			catch(Exception e){
				e.printStackTrace();	
			}
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
	}
	}
	/* End of AAKH-CRF-0179 */
	if(!(last_encounter_inform_date_time==null || last_encounter_inform_date_time.equals("")))
		last_encounter_inform_date_time	=	DateUtils.convertDate(last_encounter_inform_date_time,"DMYHM","en",locale);	
	if(!(absconded_date==null || absconded_date.equals("")))
		absconded_date					=	DateUtils.convertDate(absconded_date,"DMYHM","en",locale);	
	if(!(bed_block_date_time==null || bed_block_date_time.equals("")))
		bed_block_date_time				=	DateUtils.convertDate(bed_block_date_time,"DMYHM","en",locale);	
	if(!(body_released_date_time==null || body_released_date_time.equals("")))
		body_released_date_time			=	DateUtils.convertDate(body_released_date_time,"DMYHM","en",locale);	
	if(!(informed_date_time==null || informed_date_time.equals("")))
		informed_date_time				=	DateUtils.convertDate(informed_date_time,"DMYHM","en",locale);	

	if(!(discharge_date_time==null || discharge_date_time.equals("")))
		discharge_date_time				=	DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);	

	if(!(EXPECTED_DISCHARGE_DATE==null || EXPECTED_DISCHARGE_DATE.equals("")))
		EXPECTED_DISCHARGE_DATE				=	DateUtils.convertDate(EXPECTED_DISCHARGE_DATE,"DMYHM","en",locale);
	
	if(informed_to.equals("01"))
		informed_to_desc				=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nextofkin.label","common_labels");
	else if(informed_to.equals("02"))
		informed_to_desc				=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.firsttonotify.label","common_labels"); 
	else if(informed_to.equals("03"))
		informed_to_desc				=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels"); 
	String from_time				= "";
	String diag_update_period_max_unit	=	"";
	int discharge_after_hrs 		= 0;
	int dis_date_chk_days 			= 0;
	String dis_date_chk_days_unit 	= "";
	String deactivate_pseudo_bed_yn	= "";
	int max_disch_period_for_dc		= 0;
	String bl_interfaced_yn			= "N";
	String indicator				= ""; 

	if (chk_request.length() > 0)
		chk_request.delete(0,chk_request.length());
	chk_request.append("select nvl(bl_interfaced_yn,'N') bl_interfaced_yn, discharge_checklist_app_yn, bed_block_period_dis, dis_date_chk_days,dis_date_chk_days_unit, diag_update_period_max_unit, max_disch_period_for_dc,deactivate_pseudo_bed_yn, to_char(sysdate,'dd/mm/rrrr hh24:mi')serverDate from IP_PARAM where facility_id='"+facilityId+"' ");
	try
	{
		stmt = con.createStatement();
		rset = stmt.executeQuery(chk_request.toString());	
		if(rset != null && rset.next())
		{
			bl_interfaced_yn				= rset.getString("bl_interfaced_yn");
			discharge_after_hrs				= rset.getInt("bed_block_period_dis");
			diag_update_period_max_unit		= rset.getString("diag_update_period_max_unit");
			dis_date_chk_days				= rset.getInt("dis_date_chk_days");
			dis_date_chk_days_unit			= rset.getString("dis_date_chk_days_unit");
			max_disch_period_for_dc			= rset.getInt("max_disch_period_for_dc");
			deactivate_pseudo_bed_yn		= rset.getString("deactivate_pseudo_bed_yn");
			serverDate						= rset.getString("serverDate");
		}
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception in addModifyCancelDischargePatientTabs.jsp page on fetch of data from IP Param table");
		e.printStackTrace();
	}
	
	/*if (chk_request.length() > 0)
		chk_request.delete(0,chk_request.length());
	chk_request.append(" select  install_yn from  sm_module where   module_id ='mo'");

	try
	{
		stmt = con.createStatement();
		rset = stmt.executeQuery(chk_request.toString());	
		if(rset != null && rset.next())
		{
			mo_install_yn				= rset.getString("install_yn");			
		}
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception in addModifyCancelDischargePatientTabs.jsp page on fetch of data from sm_module table");
	}

	if (chk_request.length() > 0)
		chk_request.delete(0,chk_request.length());
	chk_request.append(" select count(*) no_of_record from mo_mortuary_regn where  patient_id='"+patient_id+"' and facility_id='"+facilityId+"' and encounter_id='"+eid+"' ");

	try
	{
		stmt = con.createStatement();
		rset = stmt.executeQuery(chk_request.toString());	
		if(rset != null && rset.next())
		{
			no_of_record				= rset.getInt("no_of_record");		
			if(no_of_record>0)
				is_mo_mortuary_regn = "Y";
		}
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception in addModifyCancelDischargePatientTabs.jsp page on fetch of data from mo_mortuary_regn table");
	}*/

		//String meddesc 					= "";
		String medteamid 				= checkForNull(request.getParameter("medteamid"));
		//String dis_val					= "";
		//String check_val				= "";
	//	StringBuffer stringBuffer = new StringBuffer();
		try
		{
			//java.text.SimpleDateFormat dateFormat1 = new java.text.SimpleDateFormat( "dd/MM/yyyy HH:mm" ) ;
			//java.sql.Timestamp sdate	= new Timestamp(System.currentTimeMillis()) ;
		//	String Sdate = dateFormat1.format(sdate) ;
			java.text.SimpleDateFormat dateFormat	= new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
			java.util.Date dt						= new java.util.Date();
			String d								= dateFormat.format( dt ) ;
			String curdateWithoutTime				= d;
			String sec								= String.valueOf(dt.getMinutes());
			if ((sec).length()==1) 
				sec="0"+sec; 
			else sec = sec;
			d					=	d + " "+String.valueOf(dt.getHours())+":"+sec;
			int hrs				= discharge_after_hrs+dt.getHours();
			java.util.Date dt1	= new java.util.Date(dt.getYear(),dt.getMonth(),dt.getDate(),hrs,dt.getMinutes());
			String d1			= dateFormat.format( dt1 ) ;
			String sec1			= String.valueOf(dt.getMinutes());
			if ((sec1).length()==1) 
				sec1 = "0" + sec1; 
			else sec1 = sec1;
			d1  = d1 + " "+String.valueOf(dt1.getHours())+":"+sec1;
            d						    = checkForNull(request.getParameter("EXPECTED_DISCHARGE_DATE"));
			//String dischargetypecode	= checkForNull(request.getParameter("discharge_type_code"));
			//String dischargesummaryyn	= checkForNull(request.getParameter("discharge_summary_yn"));
			//String takehomenewmedyn		= checkForNull(request.getParameter("take_home_new_med_yn"));
			String death_date_time		= checkForNull(request.getParameter("deceased_date_time"));
			d1						    = "";
	%>	
<body onLoad="checkform();FocusFirstElement();" onMouseDown="" onKeyDown="lockKey()">
<form name='DischargePatient_form' id='DischargePatient_form'  method="post" action="../../servlet/eIP.CancelDischargePatientServlet" target="messageFrame">
<!--<a name="tab1" tabindex='0'></a>  -->
<div id = 'discharge_dtl'>
<ul id="tablist" class="tablist">
	<li class="tablistitem" title="Discharge Details">
		<a onclick="tab_click('discharge_details')" class="tabClicked" id="discDetails" >
			<span class="tabSpanclicked" id="dischargespan"><fmt:message key="eIP.DischargeDetails.label" bundle="${ip_labels}"/></span>
		</a>
	</li>
	<li class="tablistitem" title="Additional Discharge Details">
		<a onclick="tab_click('additional_details')" class="tabA" id="addDetails" >
			<span class="tabAspan" id="additionalspan"><fmt:message key="eIP.AdditionalDischargeDetails.label" bundle="${ip_labels}"/></span>
		</a>
	</li>
</ul>
<table cellpadding='3' cellspacing=0 width="100%" border='0'>
	<!--<tr><td class='DEFAULTBLANKROW' colspan=4 height="2"></td></tr>-->
	<tr><td  colspan=4 class= "COLUMNHEADER"><!--<fmt:message key="eIP.DischargeDetails.label" bundle="${ip_labels}"/>--></td></tr>
	<tr>
		<td class='label' width='25%'><fmt:message key="eIP.AuthorizedPractitioner.label" bundle="${ip_labels}"/></td>
		<td class='querydata' width='30%'><%=auth_practitioner_name%></td>
		<td class='label' width='20%'><fmt:message key="eIP.DischargingPractitioner.label" bundle="${ip_labels}"/></td>
		<td class='querydata' width='25%'><%=practitioner_name%></td>
	</tr>
	<tr>
		<td class=label ><fmt:message key="eIP.ExpectedDischargeDateTime.label" bundle="${ip_labels}"/></td>
		<td nowrap class='querydata'><%=EXPECTED_DISCHARGE_DATE%></td>
		<td class=label ><fmt:message key="Common.dischargedatetime.label" bundle="${common_labels}"/></td>
		<td class='querydata'><%=discharge_date_time%></td>
	</tr>
	<tr>
		<td class=label ><fmt:message key="Common.dischargetype.label" bundle="${common_labels}"/></td>
		<td nowrap class='querydata'><%=discharge_type_desc%></td>
		<td class=label width="25%"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='querydata' style = 'word-break:break-all;'><%=discharge_narration%></td>
	</tr>
	<tr><td class='DEFAULTBLANKROW' colspan=4 height="2"></td></tr>
	<tr><td  colspan=4 class= "COLUMNHEADER"><fmt:message key="Common.deceaseddetails.label" bundle="${common_labels}"/></td></tr>
	<tr><td class='DEFAULTBLANKROW' colspan=4 height="2"></td></tr>
	<tr>				
		<td class=label nowrap width='25%'><fmt:message key="Common.deceased.label" bundle="${common_labels}"/></td>
		<td width='30%' class='label'>
		<%
			if(!death_date_time.equals(""))
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	%>	</td>
		<td class=label nowrap width='20%'><fmt:message key="Common.deathdatetime.label" bundle="${common_labels}"/></td>
		<td width='25%' class='querydata'><%=death_date_time%></td>
	</tr> 
	<tr>
		<td class=label nowrap><fmt:message key="eIP.PostMortemRequested.label" bundle="${ip_labels}"/></td>
		<%	
			if(post_mortem_req_yn.equals("Y"))
				out.println("<td class='label'><img src='../../eCommon/images/enabled.gif'></img></td>");
			else
				out.println("<td class='label'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
		%>	
		<td class=label nowrap><fmt:message key="eIP.BodyReleasedtoMortuary.label" bundle="${ip_labels}"/></td>
		<td class='querydata'><%=body_released_date_time%></td>
	</tr>
	<tr>
		<td class='label' nowrap><fmt:message key="Common.highriskbody.label" bundle="${common_labels}"/></td>
		<%	
			
			if(highriskbody.equals("Y"))
				out.println("<td class='label'><img src='../../eCommon/images/enabled.gif'></img></td>");
			else
				out.println("<td class='label'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
		%>	
			<!-- Added by Ajay Hatwate for AAKH-CRF-0179 on 22-08-2023  -->
	<% if(isDeathRegisterFormAppl && enable_death_reg_form.equals("Y") && deceased_yn.equals("Y") && !death_reg_form_accession_num.equals("")){ %>
	<td class='label'>
   		<a href="javascript:getDeathRegFormAccessionNum('<%=patient_id %>','<%=encounterid %>','','<%=admission_date_time%>','<%=patient_class %>','<%=specialty_code %>','<%=locn_code %>','<%=death_reg_form_accession_num %>','');" id='deathRegFormLink'><fmt:message key="Common.DeathRegForm.label" bundle="${common_labels}"/></a>
  	</td>
	<%}else{ %>
		<td class='label' colspan='2' ></td>
	<%} %>	
	</tr>
	<tr><td class='DEFAULTBLANKROW' colspan=4 height="2"></td></tr>
	<tr>
	
	<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
	     <%if(siteSpecific){%>
		 <td colspan='4' class= "COLUMNHEADER"><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/> <fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
	<tr>
		 <td class='label' ><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/></td> 
		 <%}else {%>
		 <td colspan='4' class= "COLUMNHEADER"><fmt:message key="Common.mlcdetails.label" bundle="${common_labels}"/></td>
	<tr>
		<td class='label' ><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td> 
		<%}%>
		<!--end ML-MMOH-CRF-0354 [IN057191 -->
		<%	
			if(med_lgl_case_yn.equals("Y"))
				out.println("<td class='label'><img src='../../eCommon/images/enabled.gif'></img></td>");
			else
				out.println("<td class='label'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
		%>
		<td class='querydata' ></td>
		<td class='label' colspan='2' ></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="Common.PoliceReportNo.label" bundle="${common_labels}"/></td>
		<td class='querydata' style = 'word-break:break-all;'><%=pol_rep_no%></td>
		<td class='label' colspan='2' ></td>
	</tr>
	<tr>
		<td class='label'  ><fmt:message key="Common.station.label" bundle="${common_labels}"/></td>
		<td class='querydata' style = 'word-break:break-all;'><%=pol_stn_id%></td>
		<td class='label'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
		<td class='querydata' style = 'word-break:break-all;'><%=pol_id%></td>
	</tr>
	<tr>
		<td class="label" width='25%' ><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></TD>
		<td class='label' width='25%'><select name='cancel_reason' id='cancel_reason' tabindex='1'><option value=''> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
		<%
		try
			{
				stmt = con.createStatement();
				//rset = stmt.executeQuery("select Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON_LANG_VW where LANGUAGE_ID = '"+locale+"' and CANCEL_DISCHARGE_YN = 'Y' and Eff_Status = 'E' order by 1");
				/*Tuesday, June 01, 2010 , modified for PE*/
				rset = stmt.executeQuery("select am_get_desc.am_contact_reason(contact_reason_code,'"+locale+"',1) Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON where CANCEL_DISCHARGE_YN = 'Y' and Eff_Status = 'E' order by 1");
				if(rset!=null)
				{
					while(rset.next())
					{
						String contact_code = rset.getString("Contact_Reason_Code");
						String contact_desc = rset.getString("Contact_Reason");
						out.println("<option value='"+contact_code+"'>"+contact_desc+"</option>"); 
					}
				}
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
			}
			catch(Exception e)
			{
				//out.println("Exception in getting reason code:"+e.toString());
				e.printStackTrace();
			}

		%>
		</select><img src="../../eCommon/images/mandatory.gif"></td>
		<td class="label" width='25%'><fmt:message key="Common.cancelledby.label" bundle="${common_labels}"/></TD>
		<td class="fields" width='25%'><input type='text' name='cancel_pract' id='cancel_pract'  size='15' maxlength='30' value="<%=practitioner_name%>" onblur="if(this.value==''){document.forms[0].cancel_pract_id.value='';};BeforeGetPractID1(document.forms[0].cancel_pract_lookup,cancel_pract);" tabindex='2'><input type='hidden' name='cancel_pract_id' id='cancel_pract_id'  value='<%=practitioner_id%>'></input><input type='button' value='?' name='cancel_pract_lookup' id='cancel_pract_lookup' class='button' onClick="if(document.forms[0].cancel_pract.value == '') getPractitioner(this,cancel_pract,'<%=facilityId%>','<%=specialty_code%>','<%=nursing_unit_code%>','Q5');" tabindex='3'></input><img  src="../../eCommon/images/mandatory.gif"></TD>
	</tr>
	<tr>
		<td class="label" width='25%'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></TD>
		<td class='fields' width='25%'><input type='text' name='cancel_discharge_bed_no' id='cancel_discharge_bed_no' size="8" maxlength = "8" readonly value=<%=bed_no%> tabindex='4'><input type='button' name='bed_avail_chart' id='bed_avail_chart' onClick="openBedChart(this);" value='?'class='button' tabindex='5'><img align="center" src="../../eCommon/images/mandatory.gif"></td>
		<td class="label" colspan='2'></td>
	</tr>	
	</table>	
	</div>
	<!--BR><br><BR><br-->
	<!-- IP_17591 one line break added -->
	<!--BR><br><BR><br-->
 <!--<a name="tab2" ></a>-->
 <div id = "addl_dtl" style = 'display:none'>
 <ul id="tablist" class="tablist" >
	<li class="tablistitem" title="Discharge Details">
		<a onclick="tab_click('discharge_details')" class="tabA" id="discDetails" >
			<span class="tabASpan" id="dischargespan"><fmt:message key="eIP.DischargeDetails.label" bundle="${ip_labels}"/></span>
		</a>
	</li>
	<li class="tablistitem" title="Additional Discharge Details">
		<a onclick="tab_click('additional_details')" class="tabClicked" id="addDetails" >
			<span class="tabSpanclicked" id="additionalspan"><fmt:message key="eIP.AdditionalDischargeDetails.label" bundle="${ip_labels}"/></span>
		</a>
	</li>
</ul>
<table cellpadding='3' cellspacing=0 width="100%" border=0>
	<tr><td class='DEFAULTBLANKROW' colspan=4 height="4"></td></tr>
	<tr>
		<td colspan=4 width="100%" class= "COLUMNHEADER"><fmt:message key="eIP.BedBlockDetails.label" bundle="${ip_labels}"/></td>
	</tr>
	<tr><td class=label colspan=4></td></tr>
	<TR>
		<TD class="label" width='25%'  ><fmt:message key="eIP.BlockType.label" bundle="${ip_labels}"/></TD>
		<TD class='querydata' ><%=blocking_type_desc%></TD>
		<TD class='label' colspan='2'></td>
	</tr>
	<TR>
		<TD class="label" ><fmt:message key="eIP.BedBlockleduntil.label" bundle="${ip_labels}"/></TD>
		<TD class='querydata' ><%=bed_block_date_time%></TD>
		<TD class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></TD>
		<TD class="querydata" style = 'word-break:break-all;'><%=blocking_remarks%></TD>
	</TR>
	<tr><td colspan=4 width="100%" class= "COLUMNHEADER"><fmt:message key="eIP.InformedDetails.label" bundle="${ip_labels}"/></td></tr>
	<tr><td class='DEFAULTBLANKROW' colspan=4 height="4"></td></tr>
	<TR>
		<TD class="label" width='25%'><fmt:message key="eIP.InformedTo.label" bundle="${ip_labels}"/></TD>
		<TD class='querydata' ><%=informed_to_desc%></TD>
		<TD class="label" width='25%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></TD>
		<TD class='querydata' style = 'word-break:break-all;'><%=informed_name%></TD>
	</TR>
	<TR>
		<TD class="label" width='25%'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></TD>
		<TD class='querydata' ><%=informed_date_time%></TD>
		<td class='label' colspan='2' ></td>
	</TR>
	<tr><td class='DEFAULTBLANKROW' colspan=4 height="4"></td></tr>
	<tr><td colspan=4 width="100%" class= "COLUMNHEADER"><fmt:message key="eIP.AbscondingDetails.label" bundle="${ip_labels}"/></td></tr>
	<tr><td class='DEFAULTBLANKROW' colspan=4 height="4"></td></tr>
	<tr>
		<td class="label" width='25%'><fmt:message key="eIP.InformedOthers.label" bundle="${ip_labels}"/></TD>
		<td class='querydata' style = 'word-break:break-all;'><%=reported_to%></td>
		<td class="label" width='25%'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></TD>
		<td class='querydata' ><%=absconded_date%></td>
	</tr>	
</table>
</div>
	<input type='hidden' name='practid' id='practid' value="<%=auth_practitioner_id%>" >
	<input type="hidden"  name="indicator" id="indicator" value="<%=indicator%>">
	<input type="hidden"  name="admission_date_time" id="admission_date_time" value="<%=admission_date_time%>">
	<input type="hidden"  name="bed_no" id="bed_no" value="<%=bed_no%>">
	<input type="hidden"  name="room_no" id="room_no" value="<%=room_no%>">
	<input type="hidden" name="bed_class_code" id="bed_class_code" value="<%=bed_class_code%>">
	<input type="hidden" name="bed_type_code" id="bed_type_code" value="<%=bed_type_code%>">
	<input type="hidden" name="bl_interfaced_yn" id="bl_interfaced_yn" value="<%=bl_interfaced_yn%>">
	<input type="hidden" name="bl_operational" id="bl_operational" value="<%=bl_operational%>">
	<input type="hidden" name="curdateWithoutTime" id="curdateWithoutTime" value="<%=curdateWithoutTime%>">
	<input type="hidden" name="dischargeafterhrs" id="dischargeafterhrs" value="<%=discharge_after_hrs%>">
	<input type="hidden" name="disdatechkdays" id="disdatechkdays" value="<%=dis_date_chk_days%>">	
	<input type="hidden" name="disdatechkdaysunit" id="disdatechkdaysunit" value="<%=dis_date_chk_days_unit%>">	
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterid%>">
	<input type="hidden" name="gender" id="gender" value="<%=gender%>">
	<input type="hidden" name="i_clinic_code" id="i_clinic_code"  value ="<%=locn_code%>" >
	<input type="hidden" name="i_practitioner_id" id="i_practitioner_id"  value ="<%=practitioner_id%>" >
	<input type="hidden" name="location_code" id="location_code"  value ="<%=locn_code%>" >
	<input type="hidden" name="location_type" id="location_type"  value ="<%=locn_type%>" >
	<input type="hidden" name="locn_code_value" id="locn_code_value" value="<%=to_locn_code%>">
	<input type="hidden" name="locn_type" id="locn_type" value="<%=to_locn_type%>">
	<input type="hidden" name="locn_type_val" id="locn_type_val" value="<%=to_locn_type%>">		
	<input type="hidden" name="max_disch_period_for_dc" id="max_disch_period_for_dc" value="<%=max_disch_period_for_dc%>" >
	<input type="hidden" name="medicalteam" id="medicalteam" value="<%=medteamid%>">
	<input type="hidden" name="nursing_unit_code" id="nursing_unit_code" value="<%=nursing_unit_code%>">
	<input type="hidden" name="patient_class_value" id="patient_class_value" value="<%=patient_class%>" >
	<input type="hidden" name="patient_id" id="patient_id"  value ="<%=patient_id%>" >
	<input type="hidden" name="patient_type_code" id="patient_type_code" value="<%=patient_type%>">
	<input type="hidden" name="ref_code" id="ref_code" value="<%=to_ref_code%>">
	<input type="hidden" name="sStyle" id="sStyle" value="<%=sStyle%>">
	<input type="hidden" name="serv_code" id="serv_code" value="<%=to_service_code%>">
	<input type="hidden" name="server_date" id="server_date" value="<%=serverDate%>">
	<input type="hidden" name="service_code" id="service_code" value="<%=service_code%>">
	<input type="hidden" name="specialty_code" id="specialty_code" value="<%=specialty_code%>">
	<input type="hidden" name="sysdatetime" id="sysdatetime" value="<%=serverDate%>">
	<input type="hidden" name="to_specialty_code" id="to_specialty_code" value="<%=to_specialty_code%>">
	<input type='hidden' name="from_time" id="from_time" value="<%=from_time%>">
	<input type='hidden' name="locale1" id="locale1" value="<%=locale%>">
	<input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value="<%=deactivate_pseudo_bed_yn%>">
	<input type='hidden' name='diag_update_period_max_unit' id='diag_update_period_max_unit' value="<%=diag_update_period_max_unit%>">
	<input type='hidden' name='patient_status' id='patient_status' value="<%=patient_status%>">
	<input type='hidden' name='post_mortem_req_yn' id='post_mortem_req_yn' value="<%=post_mortem_req_yn%>">
	<input type='hidden' name='discharge_date' id='discharge_date' value="<%=discharge_date%>">
	<input type='hidden' name='mo_install_yn' id='mo_install_yn' value="<%=mo_install_yn%>"> 
	<input type='hidden' name='is_mo_mortuary_regn' id='is_mo_mortuary_regn' value="<%=is_mo_mortuary_regn%>">
	<input type='hidden' name='assign_care_locn_type' id='assign_care_locn_type' value="<%=assign_care_locn_type%>">
	<input type='hidden' name='admission_type' id='admission_type' value="<%=admission_type%>">
	<input type='hidden' name='dateofbirth' id='dateofbirth' value="<%=date_of_birth%>">
	<input type='hidden' name='disposition_type' id='disposition_type' value="<%=disposition_type%>">	
	<input type='hidden' name='referral_id' id='referral_id' value="<%=referral_id%>">	
	<input type='hidden' name='facility_id' id='facility_id' value="<%=facilityId%>">
	<input type='hidden' name='discharge_status_code' id='discharge_status_code' value="<%=discharge_status_code%>">	
	<input type='hidden' name='death_reg_form_accession_num' id='death_reg_form_accession_num' value="<%=death_reg_form_accession_num%>">	<!-- Added by Ajay Hatwate for AAKH-CRF-0179 on 22-08-2023 -->
	<input type ='hidden' name= 'callback_mode' value="View">
</form>
<%
	if(rset!=null) rset.close();
	if(rset1!=null) rset1.close();
	if(stmt!=null) stmt.close();
	if(stmt1!=null) stmt1.close();

	}catch(Exception e)
	{
	//	out.print("Exception "+e);
		e.printStackTrace();
	}	
	finally   
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
	</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>


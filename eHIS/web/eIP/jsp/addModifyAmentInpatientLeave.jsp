<!DOCTYPE html>
<%/*	LEAVE_STATUS - added by Sridhar R 
	obj.value = '1'>Revise Leave
	obj.value = '2'>Record Return
	obj.value = '3'>Record No Show
	obj.value = '9'>Cancel Leave
	out.println("sqlsd2"+sqlsd2);
*/%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
    <head>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<title><fmt:message key="eIP.AmendInpatientLeave.label" bundle="${ip_labels}"/></title>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../js/AmendInpatientLeave.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale			= (String)session.getAttribute("LOCALE");
	
	String encounterid  = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String srl_no   = request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
	String facilityid       = (String) session.getValue("facility_id");
	
	String call_function    = request.getParameter("call_function")==null?"":request.getParameter("call_function");

	String loginUser = (String)session.getValue("login_user");

	Connection con      = null;
	Statement stmt		= null;
	ResultSet rset      = null;
	Statement stmt_opn	= null;
	ResultSet rs_opn	= null;
	PreparedStatement pstmt    =   null;

	String p_oper_stn_id		= "";
	String admission_date_time	= "";
	String adm_date_display		= "";
	String patient_id           = "";
	String practitioner_name	= "";
	String leave_fr_date		= "";
	String leave_fr_display		= "";
	String leave_to_date		= "";
	String leave_to_display		= "";
	String leave_remarks		= "";
	String amend_remarks		= "";
	String max_leave_period		= "";
	String release_bed_yn		= ""; 
	String old_nursing_unit_code= "";
	String old_room_no			= "";
	String old_bed_no			= "";  
	String old_to_daily_rate	= "";
	String trn_date_time		= "";
	String trn_type				= "";
	String trn_code				= "";
	String allow_rel_bed		= "";
	String chk					= "";
	String pseudobed			= "";
	String record_no_show_yn	= "N";
	String cancel_leave_yn		= "N";
	String fr_nursing_unit		= "";
	String fr_bed_class			= "";
	String fr_bed_type			= "";
	String fr_speciality		= "";
	String fr_practitioner		= "";
	String fr_service_code		= "";
	String to_service_code		= "";
	String reported_to			= "";
	String AbsDateTime			= "";
	String AbsYN				= "";
	String absconding_yn		= "";
	String fr_room_no			= "";
	String fr_bed_no			= "";
	String pol_rep_no1			= "";
	String pol_stn_id1			= "";
	String pol_id1				= "";
	String informed_to1			= "";
	String informed_name1		= "";
	String informed_date_time1	= "";
	String pseudo_bed_yn		= "";
	String deactivate_pseudoBed	= "";
	String leave_status			= "";
	String setup_bl_dtls_in_ip_yn		= "";
	String to_nursing_unit_short_desc	= "";
	String allow_release_bed_on_lv		= "";
	String warn_or_error_max_leave		= "";
	String max_allowed_lv_cancel_period	= "";
	String def_leave_to_date			= "";
	String patient_class				= "";
	String modified_date				= "";
	java.sql.Timestamp to_date = null;
	long leave_prd = 0;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm") ;
	java.util.Date dt = new java.util.Date();
	String d = dateFormat.format(dt) ;
try
{
	con = ConnectionManager.getConnection(request);
	p_oper_stn_id		 =  request.getParameter("p_oper_stn_id")==null?"":request.getParameter("p_oper_stn_id");
	if(p_oper_stn_id.equals(""))
	{
		StringBuffer operSql = new StringBuffer();
		operSql.append(" SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id=? AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b.appl_user_id =? AND trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate)) ");
		
		pstmt = con.prepareStatement(operSql.toString());
		pstmt.setString(1, facilityid);
		pstmt.setString(2, loginUser);
		
		rs_opn = pstmt.executeQuery();
		
/* 		stmt_opn = con.createStatement();
		rs_opn = stmt_opn.executeQuery(operSql.toString()); */

		if (rs_opn.next())
		{
			p_oper_stn_id = checkForNull(rs_opn.getString("oper_stn_id"));
		}
		if(rs_opn != null) rs_opn.close();
/* 		if(stmt_opn != null) stmt_opn.close(); */
		if(pstmt != null) pstmt.close();
	}
	/*Thursday, May 13, 2010 , commented for PE
	stmt = con.createStatement();
	
	StringBuffer sql_bl = new StringBuffer();
	sql_bl.append("select setup_bl_dtls_in_ip_yn, to_char((sysdate+max_allowed_lv_period/24),'dd/mm/rrrr hh24:mi') def_leave_to_preriod from ip_param where facility_id='"+facilityid+"' ");
	rset = stmt.executeQuery( sql_bl.toString() );

	if(rset!=null )
	{
		while(rset.next())
		 {
			setup_bl_dtls_in_ip_yn	= checkForNull(rset.getString("setup_bl_dtls_in_ip_yn"));
			def_leave_to_date		= checkForNull(rset.getString("def_leave_to_preriod"));
		 }
		if(rset != null) rset.close();
	}*/
	/* Commented for PE and merged with below query - 10/05/2010
	
	StringBuffer pseudobed_sql = new StringBuffer();
	pseudobed_sql.append("select PSEUDO_BED_YN, patient_class from IP_OPEN_ENCOUNTER_VW a where a.ENCOUNTER_ID = '"+encounterid+"' and a.facility_id = '"+facilityid+"' ");
	rset = stmt.executeQuery(pseudobed_sql.toString());
	if(rset!=null )
	{
		while(rset.next())
		 {
			pseudo_bed_yn	= checkForNull(rset.getString("PSEUDO_BED_YN"));
			patient_class   = checkForNull(rset.getString("patient_class"));
		 }
		if(rset != null) rset.close();
	}*/

	StringBuffer sql = new StringBuffer();
	sql.append(" select a.reported_to, to_char(a.leave_fr_date,'dd/mm/rrrr hh24:mi') leave_fr_date_disp, a.leave_fr_date, to_char(a.leave_to_date,'dd/mm/rrrr hh24:mi') leave_to_date_disp, a.leave_to_date, a.release_bed_yn, a.leave_remarks, decode(a.release_bed_yn,'Y','Yes','N','No') release_bed_yn, decode(a.override_yn,'Y','Yes','N','No') override_yn, a.approved_by_id, a.amend_remarks, a.leave_recorded_by, a.absconding_yn, to_char(a.ABSCONDING_DATE,'dd/mm/rrrr hh24:mi') absconding_date, a.leave_status, a.pol_rep_no, a.pol_stn_id, a.pol_id, a.informed_to, a.informed_name, to_char(a.informed_date_time,'dd/mm/rrrr hh24:mi') informed_date_time, (case when b.bed_num is not null then (select PSEUDO_BED_YN from ip_nursing_unit_bed where facility_id = b.facility_id and nursing_unit_code = b.nursing_unit_code and bed_no = b.bed_num) end ) PSEUDO_BED_YN, b.patient_class,to_char(a.modified_date,'dd/mm/rrrr hh24:mi:ss') modified_date from IP_LEAVE_DETAIL a, IP_OPEN_ENCOUNTER b where a.facility_id = ? and a.encounter_id = ? and a.srl_no = ? and a.facility_id = b.facility_id  and a.encounter_id = b.encounter_id "); 
	
	pstmt = con.prepareStatement(sql.toString());
	pstmt.setString(1, facilityid);
	pstmt.setString(2, encounterid);
	pstmt.setString(3, srl_no);
	
	rset = pstmt.executeQuery();
/* 	stmt = con.createStatement();
	rset = stmt.executeQuery(sql.toString()); */
	if(rset != null)
	{
		if(rset.next())
		{
			pseudo_bed_yn	= checkForNull(rset.getString("PSEUDO_BED_YN"));
			patient_class   = checkForNull(rset.getString("patient_class"));
			leave_fr_date		= checkForNull(rset.getString("leave_fr_date_disp"));
			if(!(leave_fr_date==null || leave_fr_date.equals("")))
				leave_fr_display = DateUtils.convertDate(leave_fr_date,"DMYHM","en",locale);
			leave_to_date		= rset.getString("leave_to_date_disp")==null ? "" : rset.getString("leave_to_date_disp") ;
			if(!(leave_to_date==null || leave_to_date.equals("")))
				leave_to_display = DateUtils.convertDate(leave_to_date,"DMYHM","en",locale);
			leave_remarks		= checkForNull(rset.getString("leave_remarks"));
			amend_remarks		= rset.getString("amend_remarks") == null ?"" : rset.getString("amend_remarks") ;
			release_bed_yn		= rset.getString("release_bed_yn");
			leave_status		= rset.getString("leave_status");
			reported_to			= rset.getString("REPORTED_TO") == null ?"" : rset.getString("REPORTED_TO") ;
			AbsYN	= rset.getString("ABSCONDING_YN");
			if(AbsYN == null) AbsYN = "N";
			absconding_yn = AbsYN.equals("Y") ?"checked" :"" ;
			AbsDateTime	= rset.getString("ABSCONDING_DATE") == null ?"":rset.getString("ABSCONDING_DATE");
			if(!(AbsDateTime==null || AbsDateTime.equals("")))
						AbsDateTime = DateUtils.convertDate(AbsDateTime,"DMYHM","en",locale);


			pol_rep_no1	= rset.getString("POL_REP_NO")==null?"":rset.getString("POL_REP_NO");
			pol_stn_id1	= rset.getString("POL_STN_ID")==null?"":rset.getString("POL_STN_ID");
			pol_id1	= rset.getString("POL_ID")==null?"":rset.getString("POL_ID");

			informed_to1	= rset.getString("INFORMED_TO")==null?"":rset.getString("INFORMED_TO");
			if(informed_to1.equals(""))
				informed_to1="0";
			informed_name1	= rset.getString("INFORMED_NAME")==null?"":rset.getString("INFORMED_NAME");

			informed_date_time1	= rset.getString("INFORMED_DATE_TIME")==null?"":rset.getString("INFORMED_DATE_TIME");
	
			java.sql.Timestamp from_date= rset.getTimestamp("leave_fr_date");
			to_date	= rset.getTimestamp("leave_to_date");

			long to_dt_long_val=0;
			long from_dt_long_val= 0;

			if(from_date != null)
			{
				from_dt_long_val =  from_date.parse(from_date.toLocaleString())/(60*60*1000) ;
			}
			if(to_date != null)
			{
				to_dt_long_val =  to_date.parse(to_date.toLocaleString())/(60*60*1000) ;           
			}

			leave_prd	= to_dt_long_val - from_dt_long_val ;

			if(leave_prd%24 == 0)
			{
				leave_prd =leave_prd/24;
			}
			
			modified_date		= rset.getString("modified_date")==null?"":rset.getString("modified_date");

			if(rset != null)    {rset.close(); rset = null;}
			if(pstmt != null)	pstmt.close();

			if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" select trn_type, trn_code,to_nursing_unit ,patient_id, to_room_no, to_bed_no, to_bed_class_code , to_bed_type_code ,to_daily_rate ,to_practitioner_id , AM_GET_DESC.AM_PRACTITIONER(to_practitioner_id,?,'1') to_practitioner_long_name , fr_specialty_code, fr_practitioner_id,to_specialty_code,to_char(trn_date_time,'dd/mm/rrrr hh24:mi') trn_date_time, to_char(admission_date_time,'dd/mm/rrrr hh24:mi')admission_date_time, fr_room_no, fr_bed_no, fr_bed_class_code, fr_nursing_unit_code, fr_bed_type_code, AM_GET_DESC.AM_PRACTITIONER(fr_practitioner_id,?,'1') fr_practitioner_long_name , fr_room_no, fr_bed_no, IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, TO_NURSING_UNIT,?,'2') to_nursing_unit_short_desc, FR_SERVICE_CODE, TO_SERVICE_CODE from IP_ADT_TRN where facility_id = ? and encounter_id = ?   and srl_no = (SELECT MAX(SRL_NO) FROM IP_ADT_TRN WHERE  facility_id = ? and ENCOUNTER_ID = ?) "); 

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, locale);
			pstmt.setString(2, locale);
			pstmt.setString(3, locale);
			pstmt.setString(4, facilityid);
			pstmt.setString(5, encounterid);
			pstmt.setString(6, facilityid);
			pstmt.setString(7, encounterid);
			
			rset = pstmt.executeQuery();
				
/* 			rset = stmt.executeQuery ( sql.toString() ); */
			if(rset != null)
			{
				if(rset.next())
				{
					patient_id                = rset.getString("patient_id");

					practitioner_name         = rset.getString("to_practitioner_long_name");
					if (rset.getString("to_practitioner_long_name")==null)
						practitioner_name = rset.getString("fr_practitioner_long_name");

					old_nursing_unit_code  = rset.getString("to_nursing_unit");
					if (rset.getString("to_nursing_unit")==null)
					old_nursing_unit_code  = rset.getString("fr_nursing_unit_code");
			
					old_room_no              = rset.getString("to_room_no");

					if (rset.getString("to_room_no")==null)
						old_room_no  = rset.getString("fr_room_no");

					if(old_room_no == null || old_room_no.equals("")) 
							old_room_no = "";

					old_bed_no  = rset.getString("to_bed_no");

					if (old_bed_no == null)
					old_bed_no  = rset.getString("fr_bed_no");

					if(release_bed_yn.equals("Y"))
					pseudobed = old_bed_no;

					admission_date_time = checkForNull(rset.getString("admission_date_time"));
					if(!(admission_date_time==null || admission_date_time.equals("")))
						adm_date_display = DateUtils.convertDate(admission_date_time,"DMYHM","en",locale);

					if(setup_bl_dtls_in_ip_yn.equals("Y")) 
						old_to_daily_rate         = rset.getString("to_daily_rate");

					trn_type                          =rset.getString("trn_type")==null ? "" :  rset.getString("trn_type"); 
					
					trn_code     =rset.getString("trn_code")==null ? ""  :  rset.getString("trn_code"); 
					
					trn_date_time = rset.getString("trn_date_time");
					fr_room_no=rset.getString("fr_room_no");
					if(fr_room_no == null || fr_room_no.equals("null")) fr_room_no = "";
					
					fr_bed_no=rset.getString("fr_bed_no");
					if(fr_bed_no == null) fr_bed_no = "";
					
					fr_service_code=rset.getString("FR_SERVICE_CODE");
					if(fr_service_code == null) fr_service_code = "";

					to_service_code=rset.getString("TO_SERVICE_CODE");
					if(to_service_code == null) to_service_code = "";

					to_nursing_unit_short_desc = rset.getString("to_nursing_unit_short_desc");
					if(to_nursing_unit_short_desc == null) to_nursing_unit_short_desc = "";

					fr_nursing_unit = rset.getString("fr_nursing_unit_code");
					if(fr_nursing_unit == null) fr_nursing_unit = "";

					fr_bed_class = rset.getString("fr_bed_class_code");
					if(fr_bed_class == null) fr_bed_class = "";

					fr_bed_type = rset.getString("fr_bed_type_code");
					if(fr_bed_type == null) fr_bed_type = "";

					fr_practitioner = rset.getString("fr_practitioner_id");
					if(fr_practitioner == null) fr_practitioner = "";

					fr_speciality = rset.getString("fr_specialty_code");
					if(fr_speciality == null) fr_speciality = "";
				}
			}
		}
		if(rset != null) rset.close();
		if(pstmt != null)	pstmt.close();
	}
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(" select a.DEACTIVATE_PSEUDO_BED_YN, b.RELEASE_BED_ON_LEAVE_YN, a.max_allowed_lv_period, a.warn_or_error_max_leave, a.max_allowed_lv_cancel_period, a.allow_release_bed_on_lv,a.setup_bl_dtls_in_ip_yn, to_char((sysdate+a.max_allowed_lv_period/24),'dd/mm/rrrr hh24:mi') def_leave_to_preriod ");
		//sql.append(",(select leave_fr_date+(a.max_allowed_lv_cancel_period/1440) from ip_leave_detail where facility_id='"+facilityid+"' and encounter_id ="+encounterid+" and leave_status = '1')leave_fr_date");
		sql.append("from ip_param a,ip_nursing_unit b where a.facility_id = ? and  a.facility_id = b.facility_id  and b.nursing_unit_code=? ");

		pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, facilityid);
		pstmt.setString(2, old_nursing_unit_code);
		
		rset = pstmt.executeQuery();
/*         rset = stmt.executeQuery( sql.toString() ) ; */



	if( rset != null )
	{
		if(rset.next())
		{
	        deactivate_pseudoBed		= checkForNull(rset.getString("DEACTIVATE_PSEUDO_BED_YN"));
			allow_release_bed_on_lv		= checkForNull(rset.getString("allow_release_bed_on_lv"));
			max_allowed_lv_cancel_period= checkForNull(rset.getString("max_allowed_lv_cancel_period"));
   
			max_leave_period		= rset.getString("max_allowed_lv_period");
			if(max_leave_period == null) max_leave_period = "0";

			warn_or_error_max_leave = rset.getString("warn_or_error_max_leave");
			if(warn_or_error_max_leave ==null) warn_or_error_max_leave ="";	

			allow_rel_bed = checkForNull(rset.getString("RELEASE_BED_ON_LEAVE_YN")); 

			setup_bl_dtls_in_ip_yn	= checkForNull(rset.getString("setup_bl_dtls_in_ip_yn"));
			def_leave_to_date		= checkForNull(rset.getString("def_leave_to_preriod"));
		}



		if(rset != null)    rset.close();

		if(sql.length() > 0) sql.delete(0,sql.length());
		if(pstmt!=null) pstmt.close();
		if(max_allowed_lv_cancel_period == "") max_allowed_lv_cancel_period = "0";
		sql.append(" select leave_fr_date+(?/1440) from ip_leave_detail where facility_id=? and encounter_id =? and leave_status = '1' " );
		
		pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, max_allowed_lv_cancel_period);
		pstmt.setString(2, facilityid);
		pstmt.setString(3, encounterid);
		
		rset = pstmt.executeQuery();


/* 		rset = stmt.executeQuery(sql.toString()) ; */

			if(rset != null)
			{
				if(rset.next())
				{
					if(rset.getTimestamp(1).after( new Timestamp(System.currentTimeMillis())))
					{
						cancel_leave_yn = "Y";
					}
								
				if(to_date != null)
				{
					if (to_date.before(new Timestamp(System.currentTimeMillis())))
						record_no_show_yn = "Y";
				}

			}
		}
		if(rset != null) rset.close();
	}
		if(rset != null)	    rset.close();
		if(rs_opn != null)		rs_opn.close();
		if(stmt_opn != null)    stmt_opn.close();
		if(stmt != null)		stmt.close();
		if(pstmt != null)		pstmt.close();

	}catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();}
	finally
	{
        ConnectionManager.returnConnection(con,request);
    }
%>
</head>

    <body onLoad='document.forms[0].trans_type.focus();dispAmendDetail()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
        <form name="AmendInpatientLeave_form" id="AmendInpatientLeave_form" method=post action='../../servlet/eIP.IPAmendIPLeaveServlet' target='dummy'>
        <input type="hidden" name=leave_fr_date id=leave_fr_date value="<%=leave_fr_date%>">
        <input type="hidden" name=leave_to_date id=leave_to_date value="<%=leave_to_date%>">
        <input type="hidden" name=hddPseudobed id=hddPseudobed value="<%=pseudobed%>">
<table cellpadding=0 cellspacing=0 align=center width="100%" border=0>
	<tr>
				<td class="COLUMNHEADER" colspan='4' id='leave_dtls_th'><b><fmt:message key="eIP.LeaveDetails.label" bundle="${ip_labels}"/></b></td>
	</tr>
	<tr><td colspan='4' class='label'></td></tr>
	<tr><td colspan='4' class='label'></td></tr>
	<tr><td colspan='4' class='label'></td></tr>

      <tr>
           <td class='label' width='25%'><fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/></td>
            <td width='30%' class='fileds'>
                        <select name='trans_type' id='trans_type' onchange = "validateTransType(this);populateAmenddtls(this)">
                            <option value = '2'><fmt:message key="eIP.RecordReturn.label" bundle="${ip_labels}"/></option>
                            <%if(record_no_show_yn.equals("Y")){ %>
                            <option value = '3'><fmt:message key="eIP.RecordNoShow.label" bundle="${ip_labels}"/></option><%}%>
							<%if(!leave_status.equals("4")){%>
                            <option value = '1'><fmt:message key="eIP.ReviseLeave.label" bundle="${ip_labels}"/></option><%}%>
                            <%if(cancel_leave_yn.equals("Y")){%>
                            <option value = '9'><fmt:message key="eIP.CancelLeave.label" bundle="${ip_labels}"/></option><%}%>
                        </select>
              </td>
            <td  class='label' nowrap width='20%'></td>
            <td  class='querydata' nowrap width='25%'></td>
       </tr>
		<tr><td colspan='4' class='label' height='6'></td></tr>
        <tr>
			<td class='label'><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/> </td>
			<td class='querydata'> <%=adm_date_display%></td>
            <td class='label' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
            <td nowrap class='querydata'><%=practitioner_name%></td>
                    
        </tr>		
		<tr>
			<td class='label'><fmt:message key="Common.ReleaseBed.label" bundle="${common_labels}"/></td>
                    <%if(release_bed_yn.equals("Y")) chk = "checked"; else chk="";%>
                    <td class='fileds'><input type="checkbox" name="release_bed" id="release_bed" value="Y" <%=chk%> onClick="validatePseudoBed(this)" disabled></td>
                    <td class='label' nowrap><fmt:message key="eIP.PseudoBed.label" bundle="${ip_labels}"/></td>
                    <td class='fileds'>
                    <input type="text" name="pseudo_bed" id="pseudo_bed" size=6 maxlength=8 readonly value=""><input type='button' value='?' onclick ='searchPseudoBed()' class='button' name='PseudoBed_chart' id='PseudoBed_chart' disabled><img id="pseudoImg" src='../../eCommon/images/mandatory.gif' ></img></td> 
		</tr>			
			<tr>
				<td class='label'  id='leave_period_lgd'><fmt:message key="Common.LeavePeriod.label" bundle="${common_labels}"/></td>
				<td  class='querydata' id='from_date1' colspan='2'><input type='hidden'  value="<%=leave_fr_date%>" name='from_date'>
				<input type='hidden' value="<%=leave_to_date%>" name='to_date'>
				</td>
				<td class='querydata' id='to_date1'></td>
			</tr>			
			<tr>
				<td class='label' id='leave_remarks_lgd'><fmt:message key="eIP.LeaveRemarks.label" bundle="${ip_labels}"/></td>
				<td colspan='3' class='fileds'><textarea rows='3' cols='60' style = "resize: none;" name='leave_remarks' onBlur='makeValidString(this)' ><%=leave_remarks%></textarea></td>
            </tr>
			
			<tr><td colspan='4' class='label'></td></tr>
			<tr>
				<td class="COLUMNHEADER" colspan='4' ><b><fmt:message key="eIP.PreviousBedDetails.label" bundle="${ip_labels}"/></b></td>
	       </tr>

			<tr>
			<td height='2'> </td>
			<td height='2'> </td>
			<td height='2'> </td>
			<td height='2'> </td>			
			</tr>
		   <tr>
				 <td class='label'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
				<td class='querydata'  ><%=fr_bed_no%></td>
				<td class='label'><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
				<td class='querydata'><%=fr_room_no%></td>
			
			</tr>

			<tr>
			<td height='2'> </td>
			<td height='2'> </td>
			<td height='2'> </td>
			<td height='2'> </td>			
			</tr>
			
			<tr><td colspan='4' class='label'></td></tr>

			<tr>
				<td class="COLUMNHEADER" colspan='4' ><b><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></b></td>
	       </tr>

			<tr><td colspan='4' class='label'></td></tr>
			<tr><td colspan='4' class='label'></td></tr>
			<tr><td colspan='4' class='label'></td></tr>
	
			<tr>
				<td class='label'   ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
				<td  class='fileds'>
				<input type=text value="<%=to_nursing_unit_short_desc%>" readonly name="nursing_unit_desc" maxlength=15 size=15 ><input type=button class=button name=nursing_unit_lookup value='?' onClick="NursingUnitLookup('<%=facilityid%>','<%=loginUser%>','<%=p_oper_stn_id%>')">
				<input type="hidden" name="nursing_unit" id="nursing_unit" value="<%=old_nursing_unit_code%>"><img id = "gifpop3" src='../../eCommon/images/mandatory.gif'align='center'></img></td>
				<td class='label' ></td>
				<td class='label'></td>
				
				
			</tr>

			<tr><td colspan='4' class='label' height='6'></td></tr>

	<tr> 
			<td class='label' ><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
			<td class='fileds'><input type='text' name="bed_no" id="bed_no" value="<%=old_bed_no%>" size='8' maxlength='8' onBlur='ChangeUpperCase(this);validate_Bed_No();checkbed();' readOnly onKeyPress='return CheckForSpecChars(event)' ><input type='button' value='?' onclick ='searchBed()' class='button' name='bed_chart' id='bed_chart' disabled> </td>
			<td colspan='1' align='right' class='label' nowrap><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
				<td class='fileds'><input type='text' name='disp_room_no' id='disp_room_no' value="<%=old_room_no%>" readOnly size=10 maxlength=10> </td>
			
	</tr>
			<tr><td colspan='4' class='label' height='6'></td></tr>
			<tr><td colspan='4' class='label'></td></tr>
			<tr><td colspan='4' class='label'></td></tr>
			<tr><td colspan='4' class='label'></td></tr> 
	<tr>
			<td class='label' ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
			<td ><jsp:include page='BedClassComponent.jsp' flush='true'></jsp:include><img id ="gifpop4"  src='../../eCommon/images/mandatory.gif'align='center'></img></td>
			<td class='label'><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
			<td class='fileds'><jsp:include page='BedTypeComponent.jsp' flush='true'></jsp:include></td>
	</tr>
		<tr>
				<td class="COLUMNHEADER" colspan='4' id='amend_dtl'></td>
	    </tr>				
	<!-- CODED BY SRIDHAR ON 16 FEB 2004 -->				    
	<!-- ADDITION FOR ABSCONDING STATUS & ABSCONDING DATE & TIME --> 
	<TR>
	<TD colspan="4" class="LABEL">&nbsp;
	<jsp:include page="../../eIP/jsp/AbscondingDetails.jsp" ><jsp:param name="flush" value="true" />
	<jsp:param name="call_function" value="<%=call_function%>"/>
	<jsp:param name="absconding_yn" value="<%=absconding_yn%>"/>
	<jsp:param name="AbsDateTime" value="<%=AbsDateTime%>"/>
	<jsp:param name="reported_to" value="<%=reported_to%>"/>
	</jsp:include>
	</td>
	</tr>
	<tr><td colspan='4' class='label' height='6'></td></tr>
	<tr><td colspan='4' class='label'></td></tr> 


	<tr>
		<td class='label' id='trans_remarks_lgd' ><fmt:message key="Common.TransactionRemarks.label" bundle="${common_labels}"/></td>
		<td colspan='3' class='fileds'><textarea  rows='2' cols='60' name='amend_remarks' id='amend_remarks' style = "resize: none;" onBlur='checkMaxLimit1(this,500);makeValidString(this)' onKeyPress = 'chklim(this,500)'><%=amend_remarks%></textarea></td>
	</tr>

	<tr><td colspan='4' class='label' height='6'></td></tr>
	<tr>
		<td class='label' id='date_time_lgd'><fmt:message key="eIP.DateTimeReturned.label" bundle="${ip_labels}"/></td><td colspan=3 class='fileds'><input type="text" name="returned_date_time" id= "returned_date_time" size=16 maxlength=16 readonly onBlur="validateDate('R',this)" ><img name='redt' src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].returned_date_time.select();return showCalendar('returned_date_time',null,'hh:mm');"><img id = "gifpop1" src='../../eCommon/images/mandatory.gif'align='center'></img></td>
	</tr>
	
		<tr>
					<td class="COLUMNHEADER" colspan='4' id='oth_details'><b><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></b></td></tr>
	    </tr>
		<TR>
		<TD colspan="4" class='fileds'>
		<jsp:include page="../../eIP/jsp/InformedDetails.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name="patient_id" value="<%=patient_id%>" />            
		<jsp:param name="called_from" value="ament_inpatient_leave" />   
		<jsp:param name="informed_to" value="<%=informed_to1%>" />
		<jsp:param name="informed_name" value="<%=informed_name1%>" />
		<jsp:param name="informed_date_time" value="<%=informed_date_time1%>" />
		<jsp:param name="system_date_time" value="<%=d%>" />
		</jsp:include>                                                      
	</td>
	</tr>
		<TR>
	<TD colspan="4" class='fileds'>
		<jsp:include page="../../eIP/jsp/MLCDetails.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name="called_from" value="amend_leave" />
		<jsp:param name="pol_rep_no" value="<%=pol_rep_no1%>" />
		<jsp:param name="pol_stn_id" value="<%=pol_stn_id1%>" />
		<jsp:param name="pol_id" value="<%=pol_id1%>" />
		</jsp:include>
	</td>
	</tr> 
	<tr><td height=2 colspan=4></td></tr>
	<tr>
		<td> </td>
		<td> </td>
		<td> </td>
		<td class='fileds'><input type='button' name ='record' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' class='button' onclick='apply()'>
		<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class='button' onclick='const dialogTag = parent.parent.document.getElementById("dialog_tag"); dialogTag.close();'>
		</td>
	</tr>
	</table>
		<input type='hidden' value="<%=patient_class%>" name='patient_class'>
		<input type='hidden' value="<%=sStyle%>" name='sStyle'>
		<input type='hidden' value="<%=srl_no%>" name='srl_no'>
		<input type='hidden' value="<%=encounterid%>" name='encounter_id'>
		<input type='hidden' value="<%=patient_id%>" name='patient_id'>
		<input type='hidden' value="<%=release_bed_yn%>" name='release_bed_yn'>
		<input type='hidden' value="<%=max_leave_period%>" name='max_allowed_lv_period'>
		<input type='hidden' value="<%=warn_or_error_max_leave%>" name = 'warn_or_error_max_leave'>
		<input type='hidden' value="<%=release_bed_yn%>" name='old_release_bed_yn'>
		<!-- modified by senthil on 18th Dec 2003 -->
		<input type='hidden' value="<%=fr_nursing_unit%>" name='old_nursing_unit_code'>
		<input type='hidden' value="<%=fr_room_no%>" name='old_room_no'>
		<input type='hidden' value="<%=fr_bed_no%>" name='old_bed_no'>
		<input type='hidden' value="<%=fr_bed_class%>" name='old_bed_class_code'>
		<input type='hidden' value="<%=fr_bed_type%>" name='old_bed_type_code'>
		<input type='hidden' value="<%=old_to_daily_rate%>" name='old_to_daily_rate'>
		<input type='hidden' value="<%=fr_practitioner%>" name='old_practitioner_id'>
		<input type='hidden' value="<%=fr_speciality%>" name='old_speciality_code'>  
		<input type='hidden' value="<%=fr_service_code%>" name='fr_service_code'>  
		<input type='hidden' value="<%=trn_type%>" name='trn_type'> 
		<input type='hidden' value="<%=trn_code%>" name='trn_code'>
		<input type='hidden' value="<%=d%>" name='sys_date'>
		<input type='hidden' value="<%=def_leave_to_date%>" name='def_leave_to_date'>
		<input type='hidden' value="<%=trn_date_time%>" name='trn_date_time'>
		<input type='hidden' value="<%=admission_date_time%>" name='admdate'>
		<input type='hidden' value="<%=to_service_code%>" name='to_service_code'>
		<input type='hidden' value="" name='bed_cls_code' id='bed_cls_code'>
		<input type='hidden' value="" name='bed_typ_code' id='bed_typ_code'> 
		<input type='hidden' value="" name='practitioner_id' id='practitioner_id'>
		<input type='hidden' value="" name='speciality_code' id='speciality_code'>
		<input type='hidden' value="" name='nursing_unit_code' id='nursing_unit_code'>
		<input type='hidden' value="" name='room_no' id='room_no'>
		<input type='hidden' value='N' name='bed_no_val' id='bed_no_val'>
		<input type='hidden' value='N' name='generate_pseudo_bed' id='generate_pseudo_bed'>
		<input type='hidden' value="<%=setup_bl_dtls_in_ip_yn%>" name='setup_bl_dtls_in_ip_yn'>
		<input type='hidden' value="<%=java.net.URLEncoder.encode(request.getQueryString())%>" name='query_string'>
		<input type='hidden' name='hdd_allow_release_bed_on_lv' id='hdd_allow_release_bed_on_lv' value="<%=allow_release_bed_on_lv%>">
		<input type='hidden' name='hdd_allow_rel_bed' id='hdd_allow_rel_bed' value="<%=allow_rel_bed%>">
		<input type='hidden' name='hdd_trans_type' id='hdd_trans_type' value=''>
		<input type='hidden' name='hdd_peudobed_val' id='hdd_peudobed_val' value=''>
		<input type='hidden' name='pseudo_bed_yn' id='pseudo_bed_yn' value="<%=pseudo_bed_yn%>">
		<input type='hidden' name='deactivate_pseudoBed' id='deactivate_pseudoBed' value="<%=deactivate_pseudoBed%>">
		<input type='hidden' name='modified_date_val' id='modified_date_val' value="<%=modified_date%>">

<%
// Added by Sridhar R on 15 JUNE 2004
// This part of code will check the value of allow release bed obtained from ip_pram & ip_nursing_unit & will enable Release bed Check box if the value is 'Y'
if(allow_release_bed_on_lv.equals("Y") && allow_rel_bed.equals("Y"))
{
%>
	<script>
		document.forms[0].release_bed.disabled		= false;
		document.forms[0].PseudoBed_chart.disabled	= true;
		document.forms[0].pseudoImg.style.visibility="hidden";	
	</script>
		<input type='hidden' name='hddPseudoBedVal' id='hddPseudoBedVal' value='pseudo'>
<%
}
else
{
%>
	<script>
		document.forms[0].release_bed.disabled		= true;
		document.forms[0].PseudoBed_chart.disabled	= true;
		document.forms[0].pseudoImg.style.visibility="hidden";	
	</script>
		<input type='hidden' name='hddPseudoBedVal' id='hddPseudoBedVal' value=''>
<%
} 	
%>
<%	if(leave_status.equals("4"))         
	{	%> 
		<script>
			document.getElementById("leave_dtls_th").innerText=getLabel("eIP.AbscondedDetails.label","IP");
			document.getElementById("reported_to_lgd").innerHTML=getLabel("eIP.InformedOthers.label","IP");
			document.getElementById("leave_period_lgd").innerHTML=getLabel("eIP.AbscondedFrom.label","IP");
			document.getElementById("leave_remarks_lgd").innerHTML=getLabel("eIP.AbscondedRemarks.label","IP");
			document.getElementById("trans_remarks_lgd").innerHTML=getLabel("eIP.ReturnedRemarks.label","IP");
			document.getElementById("Abscndng_lgd").style.visibility			    =	"Hidden";
			document.getElementById("Dateofabs_lgd").style.visibility			    =	"Hidden";
			document.getElementById("AbsStatusID").style.visibility			    =	"Hidden"; 
			document.getElementById("AbsDateID").style.visibility				    =	"Hidden";
			document.getElementById("absgif").style.visibility				    =	"Hidden";
			document.getElementById("calgif").style.visibility					=	"Hidden"; 
			document.getElementById("pol_rep_no").disabled		= true;
			document.getElementById("pol_rep_no").value		= "<%=pol_rep_no1%>";
			document.getElementById("pol_stn_id").disabled		= true;
			document.getElementById("pol_stn_id").value		= "<%=pol_stn_id1%>";
			document.getElementById("pol_id").disabled			= true;
			document.getElementById("pol_id").value			= "<%=pol_id1%>";
		<%	if(!informed_to1.equals(""))
			{	%>
				var informed_select = "<%=informed_to1%>";
				document.getElementById("inform_to").options[informed_select].selected	= true;
		<%	}	%>
	
			document.getElementById("inform_to").disabled			= true;
			document.getElementById("informed_name").disabled		= true;
			document.getElementById("informed_name").value		= "<%=informed_name1%>";
			document.getElementById("informed_date").disabled		= true;
			document.getElementById("informed_date").value		= "<%=informed_date_time1%>";
		</script>
<%	}	%>
			<input type='hidden' name='leave_stat' id='leave_stat' value="<%=leave_status%>" >
			<script> 
				validateTransType(document.forms[0].trans_type);
				validate_Bed_No();
			</script>
		</form>
	</body>
</html>
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


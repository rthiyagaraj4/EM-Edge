<!DOCTYPE html>
 	<!--
	Developed by 	:	Chitra 
	Created on 	:	24/08/2001
	Module		:	ip
-->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%@ page contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*,com.ehis.util.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= "";
	Connection con			= null;
	Statement stmt			= null;
	ResultSet rset			= null;
	Statement stmt1			= null;
	ResultSet rset1			= null;
	Statement stmt_bl		= null;
	ResultSet rs_bl			= null;	
	Statement stmt_opn		= null;
	ResultSet rs_opn		= null;	
	String countpriority	= "";
	String facilityId		= "";
	String bl_operational	= "";
	String bl_interfaced_yn	= "";
	String priotity_status	= "";
	String change_bed_class_yn	= "";
	String deactivate_pseudo_bed_yn	= "";

try
{
	con						= ConnectionManager.getConnection(request);
   	stmt					= con.createStatement();
	locale					= (String)session.getAttribute("LOCALE");
	facilityId				= (String)session.getValue("facility_id");
	bl_operational			= (String)session.getValue("bl_operational");

	String autoCnrmTfrReq	= eIP.IPCommonBean.getAutoCnrmTfrReqParam(con,facilityId);//Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617

	bl_interfaced_yn		= checkForNull(request.getParameter("bl_interfaced_yn"));
	priotity_status			= checkForNull(request.getParameter("priotity_status"));
	change_bed_class_yn		= checkForNull(request.getParameter("change_bed_class_yn"),"N");
	deactivate_pseudo_bed_yn	= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
	String transfer_wo_delink_yn	= checkForNull(request.getParameter("transfer_wo_delink_yn"),"N");//Added for the CRF - HSA-CRF-0035
	String billing_group_id		= "";
	String billing_group_desc	= "";
	String frbedno				= "";
	String frpractitionerid		= "";
	String frpractdesc			= "";
	String frspecialitycode		= "";   
	String frspecialitydesc		= "";
	String frbedclass			= ""; 
	String frbedclassdesc		= ""; 
	String frnursingunitdesc	= "";
	String frroomno				= "";
	String frbedtype			= "";
	String frbedtypedesc		= "";
	int    frdailycharge		= 0;
	String age					= "";
	String gender				= "";
	String frservicecode		= "";
	String frservicedesc		= "";
	String frsubservcode		= "";
	String frsubservdesc		= "";
	String patient_class		= "";
	String frmeddesc			= "";
	String frmedid				= "";
	String d_converted			= "";
	String reserved_bed			= "";
	String reserved_room		= "";
	String reserved_nursing_unit			= "";
	String r_bed				= "";
	String r_room				= "";
	String r_nursing_unit		= "";
	String allow_emerg_trf_yn		= "";
	String allow_multiple_bed_for_resv_yn		= "";
	String reserve_bed_on_tfr_yn		= "";
	String r_nursing_unit_desc		= "";
	String pseudo_bed_yn			= "";
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
    <script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eIP/js/BedBookingTransfer.js" language="javascript"></script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
	
</head>
	<body onLoad= "getOnload_tfrDtls();focusFirst();setDesable_tfrDtls();checkform();" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
		
		java.text.SimpleDateFormat dateFormat	= null ;
		java.util.Date dt						= null ;
		String d								= "";
		String patientid						= "";
		String eid								= "";
		String loginUser						= "";

		dateFormat				= new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
		dt						= new java.util.Date();
		d						= dateFormat.format( dt ) ;
		d						= d + " "+String.valueOf(dt.getHours())+":"+String.valueOf(dt.getMinutes());
		if(!(d==null || d.equals("")))
				d_converted		= DateUtils.convertDate(d,"DMYHM","en",locale);	
		
		patientid				= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		eid						= request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
		long    encounterid		= Long.parseLong(eid);
		session.putValue("patientid",patientid);
		session.putValue("encounter_id",eid);
		String admissiondate	= "";
		String admissiontype	= "";
		String admissiondesc	= "";
		String frnursingunitcode= "";
		String p_oper_stn_id	= "";
		loginUser				= (String)session.getValue("login_user");
		String sdate			= "";
		String oper_stn_bed_class_yn	= "";
		String admissiondate_converted	= "";
		String sdate_converted	= "";
		String MAX_TRN_DATE_TIME= "";
		int mother_status		= 0;
		int reserved_bed_cont	= 0;
		
		/*StringBuffer sdatsql = new StringBuffer();

		sdatsql.append("Select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from dual");    
		rset    = stmt.executeQuery(sdatsql.toString());
		if(rset != null)
		{
		if(rset.next())
		   {
			sdate = rset.getString("sdate");
			if(sdate == null) sdate = "";
			if(!(sdate == null || sdate.equals("")))
				sdate_converted = DateUtils.convertDate(sdate,"DMYHM","en",locale);
		   }  
		   if(rset!=null) rset.close();
		   if(stmt!=null) stmt.close();
		}*/
		
		StringBuffer operSql = new StringBuffer();
		operSql.append(" SELECT to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate, a.oper_stn_id  OPER_STN_ID, a.BED_CLASS_CHANGE_YN FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginUser+"' AND trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate)) ");
		stmt_opn = con.createStatement();
		rs_opn = stmt_opn.executeQuery(operSql.toString());

		if (rs_opn != null && rs_opn.next())
		{
			p_oper_stn_id = rs_opn.getString("oper_stn_id")== null ? "" : rs_opn.getString("oper_stn_id");
			oper_stn_bed_class_yn = rs_opn.getString("BED_CLASS_CHANGE_YN")== null ? "" : rs_opn.getString("BED_CLASS_CHANGE_YN");
			sdate = rs_opn.getString("sdate");
			if(sdate == null) sdate = "";
			if(!(sdate == null || sdate.equals("")))
				sdate_converted = DateUtils.convertDate(sdate,"DMYHM","en",locale);
			if(rs_opn   != null)   rs_opn.close();
			if(stmt_opn   != null)   stmt_opn.close();
		}
		
		
		
		
		StringBuffer sql2 = new StringBuffer();

/*10/9/2008 for FS102IPSRRCRF0228 */
		sql2.append("select to_char(a.admission_date_time,'dd/mm/rrrr hh24:MI') admission_date, a.admission_type, ip_get_desc.ip_admission_type(a.admission_type, '"+locale+"', 2) admission_short_desc, a.nursing_unit_code, ip_get_desc.ip_nursing_unit (a.facility_id, a.nursing_unit_code, '"+locale+"', 2 ) nursing_unit_short_desc, a.specialty_code, am_get_desc.am_speciality (a.specialty_code, '"+locale+"', 2 ) specialty_short_desc, a.attend_practitioner_id practitioner_id, am_get_desc.am_practitioner (a.attend_practitioner_id, '"+locale+"', 1) practitioner_name, a.bed_num bed_no, a.room_num room_no, a.bed_class_code, ip_get_desc.ip_bed_class (a.bed_class_code, '"+locale+"', 2 ) bed_class_short_desc, null dly_charge, a.bed_type_code, ip_get_desc.ip_bed_type (a.bed_type_code, '"+locale+"', 2) BED_TYPE_SHORT_DESC, b.sex gender, to_char(b.date_of_birth,'dd/mm/rrrr') DATE_OF_BIRTH, a.service_code, am_get_desc.am_service(a.service_code,'"+locale+"',2) service_short_desc, SUBSERVICE_CODE, am_get_desc.am_subservice(a.service_code,a.subservice_code,'"+locale+"',2) SUBSERVICE_SHORT_DESC, a.PATIENT_CLASS, a.team_id, am_get_desc.am_medical_team(a.facility_id, a.team_id, '"+locale+"', 2) team_desc,a.reserved_bed_no,a.reserved_room_no,a.reserved_nurs_unit_code,ip_get_desc.ip_nursing_unit (a.facility_id, a.reserved_nurs_unit_code, '"+locale+"', 2 ) res_nursing_unit_short_desc, c.ALLOW_EMERG_TRF_YN, (SELECT to_char(MAX(TRN_DATE_TIME),'dd/mm/rrrr hh24:mi')  FROM IP_ADT_TRN WHERE FACILITY_ID = a.facility_id AND ENCOUNTER_ID = a.encounter_id) MAX_TRN_DATE_TIME, (select count(*) from ip_nursing_unit_bed where facility_id = a.facility_id and nursing_unit_code = a.nursing_unit_code and main_bed_no = a.bed_num and occupying_patient_id is not null) m_status");
		/*Monday, September 13, 2010 , SRR20056-SCF-5155 [IN:023680]*/
		sql2.append(",(select pseudo_bed_yn from ip_nursing_unit_bed where  facility_id = a.facility_id and  nursing_unit_code = a.nursing_unit_code and bed_no = a.bed_num) pseudo_bed_yn  ");
		/*Monday, October 04, 2010 ,if EDD is less than current sysdate and if any bed was reserved before current sysdate and was not released from Release Bed function , reserved bed details will not be available because of condition  blocked_until_date_time > SYSDATE but IP_RESERVED_BED_DTL table having reserved bed data*/
		sql2.append(" ,(SELECT COUNT(1) FROM ip_bed_booking WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id AND booking_type = 'N' AND (blocked_until_date_time IS NULL OR blocked_until_date_time > SYSDATE) ) reserved_bed_cont ");
		sql2.append(", d.allow_multiple_bed_for_resv_yn, d.reserve_bed_on_tfr_yn from ip_open_encounter a, mp_patient b, ip_nursing_unit c, ip_param d where a.facility_id = '"+facilityId+"' and a.encounter_id ='"+encounterid+"' and a.patient_id = b.patient_id and a.facility_id = c.facility_id and a.nursing_unit_code = c.nursing_unit_code and a.facility_id = d.facility_id");
		stmt = con.createStatement() ;
		
		rset = stmt.executeQuery(sql2.toString()) ;
		if(rset != null)
		{
			if(rset.next())
				admissiondate		= checkForNull(rset.getString("admission_date"));
				if(!(admissiondate.equals("") || admissiondate == null))
						admissiondate_converted = DateUtils.convertDate(admissiondate,"DMYHM","en",locale); 
				admissiontype		= checkForNull(rset.getString("admission_type"));
				admissiondesc		=checkForNull(rset.getString("admission_short_desc"));
				frnursingunitcode	= checkForNull(rset.getString("nursing_unit_code")); 
				
				frbedno				= checkForNull(rset.getString("bed_no"));
				frpractitionerid	= checkForNull(rset.getString("practitioner_id")); 
				frpractdesc			= checkForNull(rset.getString("practitioner_name"));
				frspecialitycode	= checkForNull(rset.getString("specialty_code"));   
				frspecialitydesc	= checkForNull(rset.getString("specialty_short_desc"));
				frbedclass			= checkForNull(rset.getString("bed_class_code"));  
				frbedclassdesc		= checkForNull(rset.getString("bed_class_short_desc")); 
				frnursingunitdesc	= checkForNull(rset.getString("nursing_unit_short_desc")); 
				frroomno			= checkForNull(rset.getString("room_no"));
				frbedtype			= checkForNull(rset.getString("bed_type_code")); 
				frbedtypedesc		= checkForNull(rset.getString("bed_type_short_desc"));
				frdailycharge		= rset.getInt("dly_charge");
				age					= checkForNull(rset.getString("date_of_birth"));
				gender				= checkForNull(rset.getString("gender"));
				frservicecode		= checkForNull(rset.getString("service_code"));
				frservicedesc		= checkForNull(rset.getString("service_short_desc"));
				frsubservcode		= checkForNull(rset.getString("SUBSERVICE_CODE"));
				frsubservdesc		= checkForNull(rset.getString("SUBSERVICE_SHORT_DESC"));
				patient_class		= checkForNull(rset.getString("PATIENT_CLASS"));
				frmeddesc			= checkForNull(rset.getString("TEAM_DESC"));
				frmedid				= checkForNull(rset.getString("TEAM_ID"));
				/*10/9/2008 for CRF 3698*/
				r_bed				= checkForNull(rset.getString("reserved_bed_no"));
				r_room				= checkForNull(rset.getString("reserved_room_no"));
				r_nursing_unit		= checkForNull(rset.getString("reserved_nurs_unit_code"));
				r_nursing_unit_desc	= checkForNull(rset.getString("res_nursing_unit_short_desc"));
				allow_emerg_trf_yn = checkForNull(rset.getString("allow_emerg_trf_yn"));
				MAX_TRN_DATE_TIME	= rset.getString("MAX_TRN_DATE_TIME");
				MAX_TRN_DATE_TIME = DateUtils.convertDate(MAX_TRN_DATE_TIME,"DMYHM","en",locale);
				mother_status = rset.getInt("m_status");
				allow_multiple_bed_for_resv_yn = checkForNull(rset.getString("allow_multiple_bed_for_resv_yn"));
				reserve_bed_on_tfr_yn = checkForNull(rset.getString("reserve_bed_on_tfr_yn"));
				pseudo_bed_yn		= checkForNull(rset.getString("pseudo_bed_yn"),"N");
				reserved_bed_cont		= rset.getInt("reserved_bed_cont");
			   if(rset!=null) rset.close();
			   if(stmt!=null) stmt.close();
		}

/*10/20/2008 FS102IPSRRCRF0228V2.0 */

			 /*commented the below queries & merged with above query for PE - 11/05/2010
			String sql_nu	= " select ALLOW_EMERG_TRF_YN  from IP_NURSING_UNIT_VW where nursing_unit_code='"+frnursingunitcode+"' and facility_id ='"+facilityId+"' ";
			
			stmt = con.createStatement() ;	
			rset = stmt.executeQuery(sql_nu.toString());
			
			if( rset != null &&  rset.next())
				{
					allow_emerg_trf_yn = checkForNull(rset.getString("allow_emerg_trf_yn"));
				 }
				if(rset!=null) rset.close();
			

		String sql_param	= " select allow_multiple_bed_for_resv_yn ,reserve_bed_on_tfr_yn from IP_PARAM where  facility_id ='"+facilityId+"' ";
			
			stmt = con.createStatement() ;	
			rset = stmt.executeQuery(sql_param.toString());
			
			if( rset != null &&  rset.next())
				{
					allow_multiple_bed_for_resv_yn = checkForNull(rset.getString("allow_multiple_bed_for_resv_yn"));
					reserve_bed_on_tfr_yn = checkForNull(rset.getString("reserve_bed_on_tfr_yn"));
				 }
				if(rset!=null) rset.close();

			String trn_date = "SELECT to_char(MAX(TRN_DATE_TIME),'dd/mm/rrrr hh24:mi')  FROM IP_ADT_TRN WHERE FACILITY_ID = '"+facilityId+"' AND ENCOUNTER_ID = '"+encounterid+"'";
			rset	=stmt.executeQuery(trn_date.toString());
			if(rset != null){
				if(rset.next()){
					MAX_TRN_DATE_TIME = rset.getString(1);
				}
			}
			if(rset!=null)rset.close();
			
		MAX_TRN_DATE_TIME = DateUtils.convertDate(MAX_TRN_DATE_TIME,"DMYHM","en",locale);
		

		//int mother_status=0;
		StringBuffer mother_bed = new StringBuffer();
		
		mother_bed.append("select count(*) m_status from ip_nursing_unit_bed a, ip_open_encounter b where a.facility_id = b.facility_id and a.nursing_unit_code = b.nursing_unit_code and a.main_bed_no = b.bed_num and b.encounter_id = '"+encounterid+"'  and b.facility_id = '"+facilityId+"' and a.occupying_patient_id is not null and a.nursing_unit_code = '"+frnursingunitcode+"' ");
		stmt = con.createStatement();
		rset = stmt.executeQuery(mother_bed.toString());
			if(rset != null)
			{
				if(rset.next())
				{
					mother_status = rset.getInt("m_status");
				}
				
			   if(rset!=null) rset.close();
			   if(stmt!=null) stmt.close();
			}*/

if(bl_operational.equals("Y"))
	{
		StringBuffer bl_elig = new StringBuffer();		
		bl_elig.append("select a. BLNG_GRP_ID, a.SHORT_DESC from bl_blng_grp a, BL_EPISODE_FIN_DTLS b where a.BLNG_GRP_ID = b.BLNG_GRP_ID and b.OPERATING_FACILITY_ID ='"+facilityId+"' and b.EPISODE_ID = '"+eid+"'");
		stmt  = con.createStatement();
		rset = stmt.executeQuery(bl_elig.toString());
		while(rset.next())
		{
			billing_group_id = rset.getString("BLNG_GRP_ID");
			billing_group_desc = rset.getString("SHORT_DESC");
		}
			   if(rset!=null) rset.close();
			   if(stmt!=null) stmt.close();
	}	
	%>
	<!--
	@Name: Added by kishore on 4/26/2004
	-->
	<script language="JavaScript">

	function checkform()
	{

			var mother_status = document.forms[0].mother_status.value;
			var transfer_wo_delink_yn = document.forms[0].transfer_wo_delink_yn.value;
			if (mother_status != '0')
			{				
				if(transfer_wo_delink_yn=='N'){
					if(confirm(getMessage('DELINK_BABY_YN','IP')))
					{
						document.forms[0].mother_bed_status.value='Y';
						return true;
					}
					else
					{
						document.forms[0].mother_bed_status.value='N';
						window.close();
					}
				}else{
					document.forms[0].mother_bed_status.value='Y';
					return true;
				}
			}
			else
				document.forms[0].mother_bed_status.value='N';
	}

	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<form name="BedBookingTransfer_form" id="BedBookingTransfer_form"  method="post" action="../../servlet/eIP.BedBookingTransferServlet" target="parent.frames[1];">

	<table border='0' width="100%" cellpadding='2' cellspacing=0>
	<tr>
		<td class='BLANKROWSmallPt' colspan=4>&nbsp;</td>
	</tr>
	<tr>
		<td  class="label" width='25%' ><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>
		<td  class='querydata' width='25%'><input type="hidden" name="admission_date" id="admission_date" value="<%=admissiondate%>" ><%=admissiondate_converted%>
			</td>
		<td  class="label" width='25%'><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
		<td  class='querydata' width='25%'><input type="hidden" name="admission_type" id="admission_type" value="<%=admissiontype%>" ><%=admissiondesc%>
			</td> 
	</tr>
	<tr>
		<td class='BLANKROWSmallPt' colspan=4>&nbsp;
			</td>
	</tr>
	<tr>
		<td  class="label" ><fmt:message key="eIP.TransferBookingDate.label" bundle="${ip_labels}"/></td>
		<td class='fields' ><input type="hidden" name="transfer_date" id="transfer_date"  value="<%=d%>"> <%=d_converted%> 
			</td>
		<td  class="label"  nowrap><fmt:message key="eIP.ReasonforTransfer.label" bundle="${ip_labels}"/></td>
		<td class="fields" >
			<select name="transfer_type" id="transfer_type">
				<option value="">---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---
				<%
					stmt = con.createStatement();
					//rset = stmt.executeQuery("select transfer_type_code,short_desc from IP_TRANSFER_TYPE_LANG_VW where language_id='"+locale+"'  and  eff_status = 'E' order by short_desc");
					rset = stmt.executeQuery("SELECT transfer_type_code , ip_get_desc.ip_transfer_type(transfer_type_code,'"+locale+"',2) short_desc FROM ip_transfer_type WHERE eff_status = 'E' ORDER BY short_desc");
					if(rset != null)
					{
						while(rset.next())
						{
							String desc = rset.getString("short_desc")== null ? "" : rset.getString("short_desc");
							String code = rset.getString("transfer_type_code")==null ? "":rset.getString("transfer_type_code");
							out.print("<option value='"+code+"' >"+desc );
						}
			   if(rset!=null) rset.close();
			   if(stmt!=null) stmt.close();
					}
				%>
			</select>
			<img align="center" src="../../eCommon/images/mandatory.gif">
		</td>
	</tr>		
	<tr>
		<td class='BLANKROWSmallPt' colspan=4>&nbsp;
			</td>
	</tr>
	<tr>
		<!--
		@coded by kishore on 4/23/2004
		-->
		<% 
		if(priotity_status.equals("Y"))
		{
			String code1= "";
			String desc1= "";
			String code = "";
			String desc = "";

			stmt = con.createStatement();
			//rset = stmt.executeQuery(" select a.priority_code,a.short_desc from IP_TRANSFER_PRIORITY_LANG_VW a where a.language_id='"+locale+"' and eff_status = 'E' and a.facility_id='"+facilityId+"' and priority_code in (select b.dflt_priority_for_tfr_req from IP_PARAM b where b.facility_id='"+facilityId+"') order by 2 ");
			rset = stmt.executeQuery(" SELECT a.priority_code, ip_get_desc.ip_transfer_priority (a.facility_id,a.priority_code,'"+locale+"','2')short_desc FROM  ip_transfer_priority a  WHERE eff_status = 'E' AND a.facility_id = '"+facilityId+"' AND priority_code IN (SELECT b.dflt_priority_for_tfr_req FROM ip_param b  WHERE b.facility_id = '"+facilityId+"') ORDER BY 2  ");

			if (rset == null && !rset.next())
			{ %>
				<td  class="label" >
					</td>
				<td >
					</td>
	  <%	}
			else
			{
				if (rset!= null)
				{
					while(rset.next())
					{
						code1 = checkForNull(rset.getString("PRIORITY_CODE"));
						desc1 = checkForNull(rset.getString("short_desc"));
					}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
				}
				%>
				<td  class="label" ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
				<td class='fields'><select name="priority" id="priority" onChange="">
					<option value="<%=code1%>"><%=desc1%></option>
			<%
				stmt = con.createStatement();
				//rset = stmt.executeQuery(" Select a.PRIORITY_CODE,a.short_desc from IP_TRANSFER_PRIORITY_LANG_VW a where a.language_id='"+locale+"' and a.facility_id='"+facilityId+"' and a.eff_status='E' and PRIORITY_CODE not in (select b.DFLT_PRIORITY_FOR_TFR_REQ from ip_param b where b.facility_id='"+facilityId+"') order by short_desc ");
				rset = stmt.executeQuery(" SELECT a.priority_code, ip_get_desc.ip_transfer_priority (a.facility_id,a.priority_code,'"+locale+"','2')short_desc FROM ip_transfer_priority a WHERE a.facility_id = '"+facilityId+"'  AND a.eff_status = 'E'  AND priority_code NOT IN (SELECT b.dflt_priority_for_tfr_req FROM ip_param b  WHERE b.facility_id = '"+facilityId+"') ORDER BY short_desc ");
				if (rset != null)
				{
					while(rset.next())
					{
						code = checkForNull(rset.getString("PRIORITY_CODE"));
						desc = checkForNull(rset.getString("short_desc"));
						out.print("<option value='"+code+"' >"+desc );
					}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
				}
				%>
				</select>
				<input type="hidden" name="exp_date_time" id="exp_date_time" value="">
				</td>
		<%	}	
		
		
		}
		else
		{	%>
			<td class="label" ></td>
			<td >&nbsp;</td>
			<%}%>
			
			<td  class="label" ><fmt:message key="eIP.PreferredDateTime.label" bundle="${ip_labels}"/></td><td  class='fields'><INPUT TYPE="text" name="pref_date_time" id="pref_date_time" id="prefDate" size="16" maxlength="16" value="<%=sdate_converted%>" onblur="compareSystemDate(this);"  onKeyPress='return(ChkNumberInput(this,event,2))'><img name='beddt' src='../../eCommon/images/CommonCalendar.gif'  onClick="document.forms[0].pref_date_time.focus();return showCalendar('prefDate',null,'hh:mm');" align='center'/><img src='../../eCommon/images/mandatory.gif' align='center'></img></td> 
		</tr>
	</table>
	<jsp:include page="../../eIP/jsp/TransferDetails.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name ="call_function"  value="Request_Trasnfer"/>	
		<jsp:param name ="admissiondate"  value="<%=admissiondate%>" />
		<jsp:param name ="frnursingunitcode"  value="<%=frnursingunitcode%>" />
		<jsp:param name ="frbedno"  value="<%=frbedno%>" />
		<jsp:param name ="frpractitionerid"  value="<%=frpractitionerid%>" />
		<jsp:param name ="frpractdesc"  value="<%=frpractdesc%>" />
		<jsp:param name ="frspecialitycode"  value="<%=frspecialitycode%>" />
		<jsp:param name ="frspecialitydesc"  value="<%=frspecialitydesc%>" />
		<jsp:param name ="frbedclass"  value="<%=frbedclass%>" />
		<jsp:param name ="frbedclassdesc"  value="<%=frbedclassdesc%>" />
		<jsp:param name ="frnursingunitdesc"  value="<%=frnursingunitdesc%>" />
		<jsp:param name ="frroomno"  value="<%=frroomno%>" />
		<jsp:param name ="frbedtype"  value="<%=frbedtype%>" />
		<jsp:param name ="frbedtypedesc"  value="<%=frbedtypedesc%>" />
		<jsp:param name ="frdailycharge"  value="<%=frdailycharge%>" />
		<jsp:param name ="age"  value="<%=age%>" />
		<jsp:param name ="gender"  value="<%=gender%>" />
		<jsp:param name ="frservicecode"  value="<%=frservicecode%>" />
		<jsp:param name ="frservicedesc"  value="<%=frservicedesc%>" />
		<jsp:param name ="frsubservcode"  value="<%=frsubservcode%>" />
		<jsp:param name ="frsubservdesc"  value="<%=frsubservdesc%>" />
		<jsp:param name ="patient_class"  value="<%=patient_class%>" />
		<jsp:param name ="frmeddesc"  value="<%=frmeddesc%>" />
		<jsp:param name ="frmedid"  value="<%=frmedid%>" />
		<jsp:param name ="ch_bed_class_param"  value="<%=change_bed_class_yn%>" />
		<jsp:param name ="deact_pseudo_bed"  value="<%=deactivate_pseudo_bed_yn%>" />
	</jsp:include>

	
	<!--10/20/2008 FS102IPSRRCRF0228V2.0-->
	<%if(reserve_bed_on_tfr_yn.equals("Y")){%>
	<%if(!allow_emerg_trf_yn.equals("Y")){%>
		<table width='100%' cellpadding='2' cellspacing='0' BORDER='0'>
	<tr>
		<td colspan=4 width="100%" class="COLUMNHEADER"><fmt:message key="eIP.ReserveBedDetails.label" bundle="${ip_labels}"/></td>
	</tr>
	<TR>
	<TD  class="label" width='25%'><fmt:message key="eIP.ReserveBed.label" bundle="${ip_labels}"/></TD>
	<TD   class="fields" colspan='3'><INPUT TYPE="checkbox" name="reserved_bed_yn" id="reserved_bed_yn" onClick="setReserveBedDtls();"><input type="hidden" name="is_reserved_bed_checked" id="is_reserved_bed_checked"  value="N"></TD>
	</TR>
	<TR>
	<TD  class="label" width='25%'><fmt:message key="eIP.ReasonforReserveBed.label" bundle="${ip_labels}"/></TD>
	<TD   class="fields" colspan='3'>
	<select name='reason_for_reserved_bed' id='reason_for_reserved_bed' ><option value="">-----&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;-----</option>
	<%
		try{
			
			stmt = con.createStatement();
			// The  query changed for SRR20056-SCF-7627 [IN : 27703] by Jayashree on 5/7/2011
			String sqlQuery	= " SELECT  a.BLOCKING_TYPE_CODE, IP_GET_DESC.IP_BLOCKING_TYPE(a.BLOCKING_TYPE_CODE,'"+locale+"','2') SHORT_DESC FROM IP_BLOCKING_TYPE a WHERE  a.EFF_STATUS = 'E' ORDER BY a.SHORT_DESC ";
			
			
			String reason_code="";
			String reason_desc="";
			rset = stmt.executeQuery(sqlQuery);
			if( rset != null )
				{
				  while( rset.next() )
				  {
						reason_code   = rset.getString("BLOCKING_TYPE_CODE") ;
						reason_desc  = rset.getString("SHORT_DESC") ;
						out.println("<option value=\""+reason_code+"\">"+reason_desc+"</option>");
				  }
				
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
				}
			}catch(Exception e) {out.println(e.toString());}
		
	%>


	</select>
	<img src='../../eCommon/images/mandatory.gif' align='center' id='reserved_bed_img' style='visibility:hidden'></img >
	</TD>
	</TR>
	</table>
	<%}}%>
	<!---->
	
	<input type="hidden" name="confirmValue" id="confirmValue" value="Y">
	<input type="hidden" name="reqRadioBtn" id="reqRadioBtn" value=""><!--Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866-->
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patientid%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterid%>">
	<input type="hidden" name="fr_bed_type" id="fr_bed_type" value="<%=frbedtype%>">
	<input type="hidden" name="bl_interfaced_yn" id="bl_interfaced_yn" value="<%=bl_interfaced_yn%>">
	<input type="hidden" name="TFR_REQ_TYPE" id="TFR_REQ_TYPE" value="RT">
	
	<!--Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start-->
	<% if(autoCnrmTfrReq.equals("Y")){ %>
		<input type="hidden" name="TFR_REQ_STATUS" id="TFR_REQ_STATUS" value=1>
	<% }else{ %>
		<input type="hidden" name="TFR_REQ_STATUS" id="TFR_REQ_STATUS" value=0>
	<% } %>
	<!--End-->
	<input type="hidden" name="cnt_pririty" id="cnt_pririty" value="<%=countpriority%>">	
	<input type="hidden" name="sysdate" id="sysdate" value="<%=sdate%>">
	<input type="hidden" name="change_bed_class_yn" id="change_bed_class_yn" value="<%=oper_stn_bed_class_yn%>">
	<input type="hidden" name="oper_stn_bed_class_yn" id="oper_stn_bed_class_yn" value="<%=oper_stn_bed_class_yn%>">
	<input type="hidden" name="continue_yn" id="continue_yn" value="">
	<input type="hidden" name="call_function" id="call_function" value="Request_Trasnfer">	
	<input type="hidden" name="mother_status" id="mother_status" value="<%=mother_status%>">
	<input type="hidden" name="mother_bed_status" id="mother_bed_status" value="">
	<input type="hidden" name="p_oper_stn_id" id="p_oper_stn_id" value="<%=p_oper_stn_id%>">
	<input type="hidden" name="bl_operational" id="bl_operational" value="<%=bl_operational%>">
	<input type='hidden' name='billing_group_id' id='billing_group_id' value="<%=billing_group_id%>">
	<input type='hidden' name='billing_group_desc' id='billing_group_desc' value="<%=billing_group_desc%>">
	<input type='hidden' name='patientgender' id='patientgender' value="<%=gender%>">
	<input type='hidden' name='dateofbirth' id='dateofbirth' value="<%=age%>">
	<input type='hidden' name='res_bed_no' id='res_bed_no' value="<%=reserved_bed%>">
	<input type='hidden' name='res_room_no' id='res_room_no' value="<%=reserved_room%>">
	<input type='hidden' name='res_nursing_unit' id='res_nursing_unit' value="<%=reserved_nursing_unit%>">
	<input type='hidden' name='r_bed_no' id='r_bed_no' value="<%=r_bed%>">
	<input type='hidden' name='r_room_no' id='r_room_no' value="<%=r_room%>">
	<input type='hidden' name='r_nursing_unit' id='r_nursing_unit' value="<%=r_nursing_unit%>">
	<input type='hidden' name='allow_transfer' id='allow_transfer' value="<%=allow_emerg_trf_yn%>">
	<input type='hidden' name='allow_multiple_bed_for_resv_yn' id='allow_multiple_bed_for_resv_yn' value="<%=allow_multiple_bed_for_resv_yn%>">
	<input type='hidden' name='reserve_bed_on_tfr_yn' id='reserve_bed_on_tfr_yn' value="<%=reserve_bed_on_tfr_yn%>">
	<input type='hidden' name='max_trn_date_time' id='max_trn_date_time' value="<%=MAX_TRN_DATE_TIME%>">
	<input type='hidden' name='r_nursing_unit_desc' id='r_nursing_unit_desc' value="<%=r_nursing_unit_desc%>">
	<input type='hidden' name='pseudo_bed' id='pseudo_bed' value="<%=pseudo_bed_yn%>">
	<input type="hidden" name="deact_pseudo_bed" id="deact_pseudo_bed" value="<%=deactivate_pseudo_bed_yn%>">
	<input type="hidden" name="reserved_bed_cont" id="reserved_bed_cont" value="<%=reserved_bed_cont%>">
	<input type="hidden" name="transfer_wo_delink_yn" id="transfer_wo_delink_yn" value="<%=transfer_wo_delink_yn%>"><!-- Added for the CRF - HSA-CRF-0035 -->

	<%
	if(bl_interfaced_yn.equals("Y"))
	{
	%>
		<input type='hidden' name='transfer_chargeable_yn' id='transfer_chargeable_yn' value='Y'>
		<input type='hidden' name='transfer_serv_charge' id='transfer_serv_charge' value=''>
		<input type='hidden' name='surgery_reqd_yn' id='surgery_reqd_yn' value='Y'>
		<input type='hidden' name='addnl_dep_amt' id='addnl_dep_amt' value=''>
		<input type="hidden" name="bill_type_code" id="bill_type_code" value="">
		<input type="hidden" name="blng_class_code" id="blng_class_code" value="">
		<input type="hidden" name="blng_serv_code" id="blng_serv_code" value="">
		<input type='hidden' name='modified_bed_type_code' id='modified_bed_type_code' value=''>
	<%
	}
	%>

	<table border='0' width='100%'  cellpadding=2 cellspacing=0 align="right">
	
	<tr><td align=right><%
		if(bl_interfaced_yn.equals("Y")) {%>
			<input type="hidden" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Compute.label","common_labels")%>" name ='compute' onclick="ComputeBlDtl();"><input type="button" class="button" id ='confirm'  name ='confirm'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels")%>" onclick="submitForm();">
		<%} else {%>
			<input type="button" class="button" name ='confirm' id ='confirm'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels")%>" onclick="submitForm(); "><%}%><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="cancel();"></td>
		<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>">
	</tr>
	</table>
<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>">
	<%
		if(rs_bl	!= null)   rs_bl.close();
		if(rset		!= null)   rset.close();
		if(rset1!= null)   rset1.close();
		if(stmt   != null)   stmt.close();
		if(stmt1   != null)   stmt1.close();
		if(rs_opn   != null)   rs_opn.close();
		if(stmt_opn   != null)   stmt_opn.close();
		if(stmt_bl   != null)   stmt_bl.close();

	}catch(Exception e){
		out.println(e.toString());
	}
	finally {
		ConnectionManager.returnConnection(con,request);
	}
	 %>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

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


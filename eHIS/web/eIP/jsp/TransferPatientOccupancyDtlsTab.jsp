<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="webbeans.eCommon.*,eCommon.Common.*,java.sql.*, java.text.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= "";
String sStyle			= "";

 %>
<% sStyle				= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rset		= null;
	Statement stmt1		= null;
	ResultSet rs1		= null;
	Statement medstmt	= null;
	ResultSet medrs		= null;
	PreparedStatement pstmt = null ;
	StringBuffer SqlSB		= new StringBuffer();
	String sel				= "";
	String bed_class_allowed			= "";
	String bl_interfaced_yn				= "";
	String priority_applicable_yn		= "";
	String pat_check_in_allowed_yn		= "";
	String blokcing_type_short_desc		= "";
	String loginUser					= "";
	String facilityId					= "";
	String DOB							= "";
	String patientid					= "";
	String p_oper_stn_id				= "";
	String sdate						= "";
	String eid							= "";
	String frpractitionerid				= "";
	String frpractdesc					= "";
	String frspecialitycode				= "";
	String frspecialitydesc				= "";
	String frbedclass					= "";
	String frbedclassdesc				= "";
	String frnursingunitcode			= "";
	String frnursingunitdesc			= "";
	String frbedno						= "";
	String frroomno						= "";
	String frbedtype					= "";
	String frbedtypedesc				= "";
	String gender						= "";
	String age							= "";
	String frservicecode				= "";
	String frservicedesc				= "";
	String frsubservicecode				= "";
	String frsubservicedesc				= "";
	String patient_class				= "";
	String admission_date				= "";
	String frmeddesc					= "";
	String frteamid						= "";
	String dateofbirth					= "";
	String year							= "";
	String call_function				= "";
	String reserve_bed_on_tfr_yn		= "";
	String allow_multiple_bed_for_resv_yn	= "";
	String pseudo_bed_yn				= "";
	String bl_operational				= "";
	java.text.SimpleDateFormat dateFormat	= null;
	java.util.Date dt					= null;
	String d							= "";
	String min							= "";
	String transfer_wo_delink_yn			= "";//Added for the CRF HSA-CRF-0035
	
	/*Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start*/
	boolean isCnrmReqPatOutChngAppl	= false;
	String autoCnrmTfrReq			= "N";
	/*End*/
		
	try
	{
		con						= ConnectionManager.getConnection(request);

		Boolean restrictPseudoBed	= CommonBean.isSiteSpecific(con,"IP","RESTRICT_PSEUDO_BED"); //Added by Sangeetha on  23/05/17 for GDOH-CRF-0151
				
		locale					= (String)session.getAttribute("LOCALE");
		loginUser				= checkForNull((String)session.getValue("login_user"));
		facilityId				= checkForNull((String)session.getValue("facility_id"));
		DOB						= checkForNull(request.getParameter("DOB"));
		patientid				= checkForNull(request.getParameter("patient_id"));
		p_oper_stn_id			= checkForNull(request.getParameter("oper_stn_id"));
		sdate					= checkForNull(request.getParameter("sdate"));
		eid						= checkForNull(request.getParameter("encounter_id"));
		frpractitionerid		= checkForNull(request.getParameter("frpractitionerid"));
		frpractdesc				= checkForNull(request.getParameter("frpractdesc"));
		frspecialitycode		= checkForNull(request.getParameter("frspecialitycode"));
		frspecialitydesc		= checkForNull(request.getParameter("frspecialitydesc"));
		frbedclass				= checkForNull(request.getParameter("frbedclass"));
		frbedclassdesc			= checkForNull(request.getParameter("frbedclassdesc"));
		frnursingunitcode		= checkForNull(request.getParameter("frnursingunitcode"));
		frnursingunitdesc		= checkForNull(request.getParameter("frnursingunitdesc"));
		frbedno					= checkForNull(request.getParameter("frbedno"));
		frroomno				= checkForNull(request.getParameter("frroomno"));
		frbedtype				= checkForNull(request.getParameter("frbedtype"));
		frbedtypedesc			= checkForNull(request.getParameter("frbedtypedesc"));
		gender					= checkForNull(request.getParameter("gender"));
		age						= checkForNull(request.getParameter("age"));
		frservicecode			= checkForNull(request.getParameter("frservicecode"));
		frservicedesc			= checkForNull(request.getParameter("frservicedesc"));
		frsubservicecode		= checkForNull(request.getParameter("frsubservicecode"));
		frsubservicedesc		= checkForNull(request.getParameter("frsubservicedesc"));
		patient_class			= checkForNull(request.getParameter("patient_class"));
		admission_date			= checkForNull(request.getParameter("admission_date"));
		frmeddesc				= checkForNull(request.getParameter("frmeddesc"));
		frteamid				= checkForNull(request.getParameter("frteamid"));
		dateofbirth				= checkForNull(request.getParameter("dateofbirth"));
		year					= checkForNull(request.getParameter("year"));
		call_function			= checkForNull(request.getParameter("call_function"));
		pat_check_in_allowed_yn	= checkForNull(request.getParameter("pat_check_in_allowed_yn"),"N");
		reserve_bed_on_tfr_yn	= checkForNull(request.getParameter("reserve_bed_on_tfr_yn"),"N");
		allow_multiple_bed_for_resv_yn	= checkForNull(request.getParameter("allow_multiple_bed_for_resv_yn"),"N");
		pseudo_bed_yn			= checkForNull(request.getParameter("pseudo_bed_yn"),"N");
		transfer_wo_delink_yn			= checkForNull(request.getParameter("transfer_wo_delink_yn"),"N");

		/*Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start*/
		isCnrmReqPatOutChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","AUTO_CNRM_TFR_REQ_PAT_OUT_CHNG");
		autoCnrmTfrReq	= eIP.IPCommonBean.getAutoCnrmTfrReqParam(con,facilityId);
		/*End*/

		bl_operational			= (String)session.getValue("bl_operational");
		String status			= "0";
		long  encounterid		= 0;
		if(!eid.equals(""))
		{
			encounterid			=	Long.parseLong(eid);
		}

		StringBuffer strBuffer		= new StringBuffer();
		String billing_group_id		= "";
		String billing_group_desc	= "";
%>

<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../js/TransferPatient.js" language="javascript"></script> 
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
 	<Script src="../js/TransferPatOccupancyDtls.js" language="JavaScript"></Script> 	
	<Script src="../js/IPPractitionerComponent.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 	 
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	
</head>
<%

	dateFormat					= new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	dt							= new java.util.Date();
	d							= dateFormat.format( dt ) ;
	min							= String.valueOf(dt.getMinutes()) ;
	if(min.length() == 1)   min = "0"+min ;
	d = d + " "+String.valueOf(dt.getHours())+":"+min;
	int block_period			= 0;
	String medcode				= "";
	String meddesc				= "";
	String frpractteamid		= "";
	String priority				= "";
	String tfr_req_type			= "";
	String priority_code		= "N";
	String toNursingUnitCode	= "";
	String toNursingUnit_Desc	= "";
	String toServiceCode		= "";
	String toService_Desc		= "";
	String toSubServiceCode		= "";
	String toSubService_Desc	= "";
	String toSplCode			= "";
	String toSplDesc			= "";
	String toPractId			= "";
	String toPractName			= "";
	String toMedTeam			= "";
	String toMedTeam_Desc		= "";
	String bkgRefNo				= "";
	String colspanValue			= "";
	String to_bed_class_code	= "";
	String to_bed_class_desc	= "";
	String to_bed_no			= "";
	String to_room_no			= "";
	String req_bed_type_code	= "";
	String PRACTITIONER_DESIGNATION = "";
	String to_nursing_unit_locn_type= "";
	String to_bedtypedesc			= "";
	String deactivate_pseudo_bed_yn	= "";
	String dflt_blk_prd_for_tfr_out	= "";
	String bed_block_period_normal	= "";
	String req_bed_type_code_by_defn= "";
	String tfr_req_code				= "";
	String blocking_type			= "";
	String blocked_until_date		= "";
	String blocking_code			= "";
	String block_unit				= "";
	String override_yn				= "";
	String modified_date_val		= "";
	StringBuffer portBuffer=new StringBuffer();
	String mode_of_transport			= "";
	String accomp_person1				= "";
	String accomp_person2				= "";
	String accomp_person3				= "";
	String accomp_person4				= "";
	String accomp_person5				= "";
	String accomp_person6				= "";
	String accomp_person7				= "";
	String equipment1					= "";
	String equipment2					= "";
	String equipment3					= "";
	String equipment4					= "";
	String equipment5					= "";
	String equipment6					= "";
	String equipment7					= "";
	String blood_and_medication1		= "";
	String blood_and_medication2		= "";
	String blood_and_medication3		= "";
	String blood_and_medication4		= "";
	String blood_and_medication5		= "";
	String blood_and_medication6		= "";
	String blood_and_medication7		= "";
	String blood_and_medication8		= "";
	String blood_and_medication9		= "";
	String blood_and_medication10		= "";
	String records_and_documents1		= "";
	String records_and_documents2		= "";
	String records_and_documents3		= "";
	String records_and_documents4		= "";
	String records_and_documents5		= "";
	String patient_belongings1			= "";
	String patient_belongings2			= "";
	String patient_belongings3			= "";
	String patient_belongings4			= "";
	String patient_belongings5			= "";
	String patient_belongings6			= "";
	String patient_belongings7			= "";
	String patient_belongings8			= "";
	String patient_belongings9			= "";
	String patient_belongings10			= "";
	String port_received_yn				= "";
	String port_recd_status				= "";
	String port_recd_remarks			= "";
	String mother_bed_status			= "";
	String reserve_bed_no				= "";
	String reserve_nurs_unit_code		= "";
	String reserve_room_no				= "";
	String reserve_specialty_code		= "";
	String reserve_practitioner_id		= "";
	String reserve_bed_type_code		= "";
	String reserve_service_code			= "";
	String reserve_bed_class_code		= "";
	String tfr_req_status				= "";
	String reserved_nursing_unit		= "";
	String reserved_bed					= "";
	String reserved_room			    = "";
	String r_nursing_unit				= "";
	String r_bed						= "";
	String r_room						= "";
	String blocking_remarks             = "";
	String blocking_type_code           = "";
	String blocking_period	            = "";
	String r_nursing_unit_desc	        = "";
	String exp_discharge_date_time	    = "";
	String prct_Designation			    = "";
	String change_bed_class_yn			= "";
	
	/*Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start*/
	String informed_dtls_mand_yn		= "";
	StringBuffer accompPerson			= new StringBuffer();
	String accomp_person1_desc			= "";
	String accomp_person2_desc			= "";
	String accomp_person3_desc			= "";
	String accomp_person4_desc			= "";
	String accomp_person5_desc			= "";
	String accomp_person6_desc			= "";
	/*End*/

	String reserved_reason_code=""; //thie line added GHL-SCF-794 [IN:047142] 
	
	int mother_status					= 0;
	int reserved_bed_cont				= 0;
	if(bl_operational.equals("Y"))
	{
		String bl_elig = "select a. blng_grp_id, a.short_desc from bl_blng_grp a, bl_episode_fin_dtls b where a.blng_grp_id = b.blng_grp_id and b.operating_facility_id ='"+facilityId+"' and b.episode_id = '"+eid+"'";
		stmt  = con.createStatement();
		rset = stmt.executeQuery(bl_elig);
		while(rset.next())
		{
			billing_group_id = rset.getString("blng_grp_id");
			billing_group_desc = rset.getString("short_desc");
		}
			if(rset	!= null)   rset.close();
			if(stmt  != null)   stmt.close();		
	}	
	int max_period = -1;
	if (strBuffer.length() > 0)		
	strBuffer.delete(0, strBuffer.length());
	/*Tuesday, May 04, 2010 , commented for PE
	stmt  = con.createStatement();
	rset = stmt.executeQuery("select PAT_CHECK_IN_ALLOWED_YN,RESERVE_BED_ON_TFR_YN,allow_multiple_bed_for_resv_yn from ip_param where facility_id='"+facilityId+"' ") ;
	if(rset.next())
	{
		if(rset != null)
		{
			pat_check_in_allowed_yn = rset.getString("pat_check_in_allowed_yn");
			reserve_bed_on_tfr_yn = rset.getString("RESERVE_BED_ON_TFR_YN");
			allow_multiple_bed_for_resv_yn = rset.getString("allow_multiple_bed_for_resv_yn");
			if(pat_check_in_allowed_yn == null) pat_check_in_allowed_yn="N";
			if(reserve_bed_on_tfr_yn == null) reserve_bed_on_tfr_yn="N";
			if(allow_multiple_bed_for_resv_yn == null) allow_multiple_bed_for_resv_yn="N";
		}
	}
		if(rset	!= null)    rset.close();
		if(stmt  != null)   stmt.close();	
	*/
		
	if(reserve_bed_on_tfr_yn.equals("Y") && call_function.equals("TransferPatientIn"))
	{
	
		if(strBuffer.length()>0)	strBuffer.delete(0,strBuffer.length());
		strBuffer.append(" select " );
		strBuffer.append(" a.reserved_nurs_unit_code ");
		strBuffer.append(" ,a.reserved_room_no ");
		strBuffer.append(" ,a.reserved_bed_no ");
		strBuffer.append(" ,a.specialty_code ");
		strBuffer.append(" ,a.admit_practitioner_id ");
		strBuffer.append(" ,a.bed_type_code ");
		strBuffer.append(" ,a.service_code ");
		strBuffer.append(" ,a.bed_class_code ");
		strBuffer.append(" from ");
		strBuffer.append(" ip_open_encounter  a, ");
		strBuffer.append(" ip_reserved_bed_dtl b ");
		strBuffer.append(" where a.facility_id = '"+facilityId+"' ");
		strBuffer.append(" and a.facility_id = b.facility_id ");
		strBuffer.append(" and a.encounter_id = '"+eid+"' ");
		strBuffer.append(" and a.encounter_id = b.encounter_id ");
		strBuffer.append(" and a.reserved_nurs_unit_code = b.reserved_nursing_unit_code ");
		strBuffer.append(" and a.reserved_bed_no =  b.reserved_bed_no ");
		strBuffer.append(" and b.reserved_to_time is null ");
		stmt = con.createStatement() ;
		rset = stmt.executeQuery(strBuffer.toString()) ;
		if(rset != null && rset.next())
		{
			reserve_nurs_unit_code	= checkForNull(rset.getString("reserved_nurs_unit_code"));
			reserve_room_no	= checkForNull(rset.getString("reserved_room_no"));
			reserve_bed_no	= checkForNull(rset.getString("reserved_bed_no"));
			reserve_specialty_code  = checkForNull(rset.getString("specialty_code"));
			reserve_practitioner_id  = checkForNull(rset.getString("admit_practitioner_id"));
			reserve_bed_type_code  = checkForNull(rset.getString("bed_type_code"));
			reserve_service_code  = checkForNull(rset.getString("service_code"));
			reserve_bed_class_code  = checkForNull(rset.getString("bed_class_code"));
		}
		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();
	}
	change_bed_class_yn			= checkForNull(request.getParameter("change_bed_class_yn"),"N");
	bl_interfaced_yn			= checkForNull(request.getParameter("bl_interfaced_yn"));
	priority_applicable_yn		= checkForNull(request.getParameter("priotity_status"),"N");
	deactivate_pseudo_bed_yn	= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
	dflt_blk_prd_for_tfr_out	= checkForNull(request.getParameter("dflt_blk_prd_for_tfr_out"));
	if(!dflt_blk_prd_for_tfr_out.equals(""))
		max_period = Integer.parseInt(dflt_blk_prd_for_tfr_out);
	bed_block_period_normal	= checkForNull(request.getParameter("bed_block_period_normal"));
	if(!bed_block_period_normal.equals(""))
		block_period = Integer.parseInt(bed_block_period_normal);
	bed_class_allowed		= change_bed_class_yn;
	strBuffer.delete(0, strBuffer.length());
	strBuffer.append("select count(*) from ip_transfer_request where tfr_req_status = '1' and encounter_id =");
	strBuffer.append(encounterid);
	strBuffer.append("  and facility_id = '");
	strBuffer.append(facilityId);
	strBuffer.append("' ");
	stmt  = con.createStatement();
	rset  = stmt.executeQuery(strBuffer.toString());
	int nRec=0;
	if(rset.next())
	{
		nRec = rset.getInt(1);
		if(rset	!= null)   rset.close();
		if(stmt  != null)   stmt.close();		
	}

	//Added by kishore on 7/2/2004
	if(call_function.equals("TransferPatientIn"))
	{
		nRec = 1;
	}
	if(nRec>0)
	{
		
		if(call_function.equals("TransferPatientIn"))
		{
		    //Below line modified for SCF GHL-SCF-794 [IN:047142]
					
			strBuffer.delete(0, strBuffer.length());
			strBuffer.append("select a.priority_code, ip_get_desc.ip_transfer_priority(a.facility_id, a.priority_code,'"+locale+"',2) priority_short_desc, a.req_nursing_unit_code nursing_unit_code, ip_get_desc.ip_nursing_unit(a.facility_id, a.req_nursing_unit_code,'"+locale+"',2 ) nursing_unit_short_desc, a.req_service_code service_code, am_get_desc.am_service(a.req_service_code,'"+locale+"',2 ) service_short_desc, a.req_specialty_code specialty_code, am_get_desc.am_speciality(a.req_specialty_code,'"+locale+"',2 ) specialty_short_desc, a.req_practitioner_id practitioner_id, am_get_desc.am_practitioner(a.req_practitioner_id,'"+locale+"',1) practitioner_name, a.tfr_req_type, a.req_subservice_code subservice_code, am_get_desc.am_subservice(a.req_service_code, a.req_subservice_code,'"+locale+"',2 ) subservice_short_desc, a.tfr_req_reason, a.req_team_id team_id, am_get_desc.am_medical_team(a.facility_id,a.req_team_id,'"+locale+"',2) team_short_desc, a.tfr_req_ref_no, a.req_bed_class_code bed_class_code, ip_get_desc.ip_bed_class(a.req_bed_class_code,'"+locale+"',2)bed_class_short_desc, a.req_bed_no bed_no, a.req_room_no room_no, a.req_bed_type_code bed_type_code, ip_get_desc.ip_bed_type(a.req_bed_type_code,'"+locale+"',2 ) bed_type_short_desc, to_char(a.informed_date_time, 'dd/mm/rrrr hh24:mi') informed_date_time, a.informed_name, a.informed_to, a.informed_yn, a.bed_blk_period_hrs, to_char(a.auth_trf_date_time,'dd/mm/rrrr hh24:mi') auth_trf_date_time, a.mode_of_transport, a.accomp_person1, a.accomp_person2, a.accomp_person3, a.accomp_person4, a.accomp_person5, a.accomp_person6, a.accomp_person7,sm_get_desc.sm_appl_user (a.accomp_person1, 'en', 1 ) accomp_person1_desc,sm_get_desc.sm_appl_user (a.accomp_person2, 'en', 1 ) accomp_person2_desc, sm_get_desc.sm_appl_user (a.accomp_person3, 'en', 1 ) accomp_person3_desc, sm_get_desc.sm_appl_user (a.accomp_person4, 'en', 1 ) accomp_person4_desc, sm_get_desc.sm_appl_user (a.accomp_person5, 'en', 1 ) accomp_person5_desc, sm_get_desc.sm_appl_user (a.accomp_person6, 'en', 1 ) accomp_person6_desc, a.equipment1, a.equipment2, a.equipment3, a.equipment4, a.equipment5, a.equipment6, a.equipment7, a.blood_and_medication1, a.blood_and_medication2, a.blood_and_medication3, a.blood_and_medication4, a.blood_and_medication5, a.blood_and_medication6, a.blood_and_medication7, a.blood_and_medication8, a.blood_and_medication9, a.blood_and_medication10, a.records_and_documents1, a.records_and_documents2, a.records_and_documents3, a.records_and_documents4, a.records_and_documents5, a.patient_belongings1, a.patient_belongings2, a.patient_belongings3, a.patient_belongings4, a.patient_belongings5, a.patient_belongings6, a.patient_belongings7, a.patient_belongings8, a.patient_belongings9, a.patient_belongings10, a.port_received_yn, a.port_recd_status, a.port_recd_remarks, 'N' nursing_unit_locn_type, b.attend_practitioner_id from_practitioner_id, am_get_desc.am_practitioner(b.attend_practitioner_id,'"+locale+"',1) from_practitioner_name, b.specialty_code from_specialty_code, am_get_desc.am_speciality(b.specialty_code,'"+locale+"',2 ) from_specialty_short_desc, b.bed_class_code from_bed_class_code, ip_get_desc.ip_bed_class(b.bed_class_code,'"+locale+"',2 ) from_bed_class_short_desc , b.nursing_unit_code from_nursing_unit_code, ip_get_desc.ip_nursing_unit(b.facility_id, b.nursing_unit_code, '"+locale+"', 2) from_nursing_unit_short_desc, b.bed_num from_bed_no, b.room_num from_room_no, b.service_code from_service_code, am_get_desc.am_service(b.service_code,'"+locale+"',2 ) from_service_short_desc, b.subservice_code from_subservice_code, am_get_desc.am_subservice(b.service_code, b.subservice_code,'"+locale+"',2) from_subservice_short_desc, b.team_id from_team_id, am_get_desc.am_medical_team(b.facility_id, b.team_id,'"+locale+"',2) from_team_short_desc, a.delink_baby_yn, a.req_bed_type_code_by_defn, to_char(a.modified_date,'dd/mm/rrrr hh24:mi')  modified_date,a.tfr_req_status,b.reserved_bed_no,b.reserved_room_no,b.reserved_nurs_unit_code,a.blocking_type_code,a.reserve_reason_code,ip_get_desc.ip_blocking_type(a.blocking_type_code,'"+locale+"',2)blokcing_type_short_desc,ip_get_desc.ip_nursing_unit (b.facility_id, b.reserved_nurs_unit_code, '"+locale+"', 2 ) res_nursing_unit_short_desc,to_char(b.exp_discharge_date_time,'dd/mm/rrrr hh24:MI') exp_discharge_date_time ");
			/*Tuesday, May 04, 2010 ,added for PE*/
			strBuffer.append (" ,(select dflt_min_block_period  from ip_blocking_type where blocking_type_code = a.blocking_type_code) dflt_min_block_period ");
			strBuffer.append(" ,(select count(*) m_status from ip_nursing_unit_bed ");
			strBuffer.append(" where ");
			strBuffer.append("  main_bed_no = b.bed_num and occupying_patient_id is not null and facility_id = b.facility_id ");
			strBuffer.append(" and nursing_unit_code = b.nursing_unit_code) m_status ");
			strBuffer.append(" ,(select am_get_desc.am_position(position_code, '"+locale+"',1)practitioner_designation from am_practitioner where  practitioner_id = b.attend_practitioner_id) practitioner_designation  ");
			strBuffer.append(" ,a.blocking_remarks ");
			/*Monday, October 04, 2010 ,if EDD is less than current sysdate and if any bed was reserved before current sysdate and was not released from Release Bed function , reserved bed details will not be available because of condition  blocked_until_date_time > SYSDATE but IP_RESERVED_BED_DTL table having reserved bed data*/
			strBuffer.append(" ,(SELECT COUNT(1) FROM ip_bed_booking WHERE facility_id = b.facility_id AND encounter_id = b.encounter_id AND booking_type = 'N' AND (blocked_until_date_time IS NULL OR blocked_until_date_time > SYSDATE) ) reserved_bed_cont ");
			strBuffer.append (" from ip_transfer_request a, ip_open_encounter b where a.facility_id ='"+facilityId+"' and a.encounter_id = '"+encounterid+"' and a.tfr_req_status = '3' and a.facility_id = b.facility_id and a.encounter_id = b.encounter_id");
		}
		else
		{
			strBuffer.delete(0, strBuffer.length());
			strBuffer.append("select" );
			strBuffer.append(" a.priority_code" );
			strBuffer.append(" , ip_get_desc.ip_transfer_priority(a.facility_id, a.priority_code,'"+locale+"',2) priority_short_desc" );
			strBuffer.append(" , a.req_nursing_unit_code nursing_unit_code" );
			strBuffer.append(" , ip_get_desc.ip_nursing_unit(a.facility_id, a.req_nursing_unit_code,'"+locale+"',2 )nursing_unit_short_desc" );
			strBuffer.append(" , a.req_service_code service_code" );
			strBuffer.append(" , am_get_desc.am_service(a.req_service_code,'"+locale+"',2) service_short_desc" );
			strBuffer.append(" , a.req_specialty_code specialty_code" );
			strBuffer.append(" , am_get_desc.am_speciality(a.req_specialty_code,'"+locale+"',2) specialty_short_desc" );
			strBuffer.append(" , a.req_practitioner_id practitioner_id" );
			strBuffer.append(" , am_get_desc.am_practitioner(a.req_practitioner_id,'"+locale+"',1) practitioner_name" );
			strBuffer.append(" , a.tfr_req_type" );
			strBuffer.append(" , a.tfr_req_type tfr_req_type_desc" );
			strBuffer.append(" , a.req_subservice_code subservice_code" );
			strBuffer.append(" , am_get_desc.am_subservice(a.req_service_code, a.req_subservice_code,'"+locale+"',2 ) subservice_short_desc" );
			strBuffer.append(" , a.req_team_id team_id" );
			strBuffer.append(" , am_get_desc.am_medical_team(a.facility_id, a.req_team_id,'"+locale+"',2) team_short_desc" );
			strBuffer.append(" , b.team_id from_team_id" );
			strBuffer.append(" , a.tfr_req_reason" );
			strBuffer.append(" , am_get_desc.am_medical_team(b.facility_id, b.team_id ,'"+locale+"',2) from_team_short_desc" );
			strBuffer.append(" , a.tfr_req_ref_no" );
			strBuffer.append(" , a.req_bed_class_code bed_class_code" );
			strBuffer.append(" , a.req_bed_no bed_no" );
			strBuffer.append(" , a.req_room_no room_no" );
			strBuffer.append(" , a.req_bed_type_code bed_type_code" );
			strBuffer.append(" , ip_get_desc.ip_bed_type(a.req_bed_type_code,'"+locale+"',2) bed_type_short_desc" );
			strBuffer.append(" , b.attend_practitioner_id from_practitioner_id" );
			strBuffer.append(" , am_get_desc.am_practitioner(b.attend_practitioner_id,'"+locale+"',1) from_practitioner_name" );
			strBuffer.append(" , b.specialty_code from_specialty_code" );
			strBuffer.append(" , am_get_desc.am_speciality(b.specialty_code,'"+locale+"',2) from_specialty_short_desc" );
			strBuffer.append(" , b.bed_class_code from_bed_class_code" );
			strBuffer.append(" , ip_get_desc.ip_bed_class(b.bed_class_code, '"+locale+"', 2) from_bed_class_short_desc" );
			strBuffer.append(" ,  ip_get_desc.ip_bed_class(a.req_bed_class_code,'"+locale+"',2)bed_class_short_desc" );
			strBuffer.append(" , b.nursing_unit_code from_nursing_unit_code" );
			strBuffer.append(" , ip_get_desc.ip_nursing_unit(b.facility_id, b.nursing_unit_code, '"+locale+"', 2) from_nursing_unit_short_desc" );
			strBuffer.append(" , b.bed_num from_bed_no" );
			strBuffer.append(" , b.room_num from_room_no" );
			strBuffer.append(" , b.service_code from_service_code" );
			strBuffer.append(" , am_get_desc.am_service(b.service_code,'"+locale+"',2) from_service_short_desc" );
			strBuffer.append(" , am_get_desc.am_subservice(b.service_code, b.subservice_code,'"+locale+"',2) from_subservice_short_desc" );
			strBuffer.append(" , 'N' nursing_unit_locn_type " );
			strBuffer.append(" , to_char(a.modified_date,'dd/mm/rrrr hh24:mi')  modified_date, a.tfr_req_status " );
			strBuffer.append(",b.reserved_bed_no,b.reserved_room_no,b.reserved_nurs_unit_code,a.blocking_type_code ,ip_get_desc.ip_blocking_type(a.blocking_type_code,'"+locale+"',2)blokcing_type_short_desc,ip_get_desc.ip_nursing_unit (b.facility_id, b.reserved_nurs_unit_code, '"+locale+"', 2 ) res_nursing_unit_short_desc");
			/*Tuesday, May 04, 2010 added for PE*/
			strBuffer.append(",(select dflt_min_block_period  from ip_blocking_type where blocking_type_code=a.blocking_type_code)dflt_min_block_period ");
			strBuffer.append(" ,(select count(*) m_status from ip_nursing_unit_bed ");
			strBuffer.append(" where ");
			strBuffer.append(" main_bed_no = b.bed_num and occupying_patient_id is not null and facility_id = b.facility_id ");
			strBuffer.append(" and nursing_unit_code = b.nursing_unit_code) m_status ");
			strBuffer.append(" ,(select am_get_desc.am_position(position_code, '"+locale+"',1)practitioner_designation from am_practitioner where  practitioner_id = b.attend_practitioner_id) practitioner_designation  ");
			strBuffer.append(" ,a.blocking_remarks ");
			/*Monday, October 04, 2010 ,if EDD is less than current sysdate and if any bed was reserved before current sysdate and was not released from Release Bed function , reserved bed details will not be available because of condition  blocked_until_date_time > SYSDATE but IP_RESERVED_BED_DTL table having reserved bed data*/
			strBuffer.append(" ,(SELECT COUNT(1) FROM ip_bed_booking WHERE facility_id = b.facility_id AND encounter_id = b.encounter_id AND booking_type = 'N' AND (blocked_until_date_time IS NULL OR blocked_until_date_time > SYSDATE) ) reserved_bed_cont ");
			strBuffer.append(" from ");
			strBuffer.append(" ip_transfer_request a" );
			strBuffer.append(" , ip_open_encounter b " );
			strBuffer.append(" where " );
			strBuffer.append(" a.facility_id = '"+facilityId+"' " );
			strBuffer.append(" and a.encounter_id = '"+encounterid+"'" );
			strBuffer.append(" and a.facility_id = b.facility_id " );
			strBuffer.append(" and a.encounter_id = b.encounter_id " );
			strBuffer.append(" and a.tfr_req_status = '1'" );
			status = "1";
		}
		stmt  = con.createStatement();
		rset  = stmt.executeQuery(strBuffer.toString());
		if(rset.next())
		{
			try
			{
				priority_code				=	rset.getString("priority_code")==null?"N":rset.getString("priority_code"); 
				tfr_req_type				=	checkForNull(rset.getString("tfr_req_type"));
				modified_date_val			=	checkForNull(rset.getString("modified_date"));
				priority					=	checkForNull(rset.getString("priority_short_desc"));
				toNursingUnitCode			=	checkForNull(rset.getString("nursing_unit_code"));
				toNursingUnit_Desc			=	checkForNull(rset.getString("nursing_unit_short_desc"));
				toServiceCode				=	checkForNull(rset.getString("service_code"));
				toService_Desc				=	checkForNull(rset.getString("service_short_desc"));
				toSubServiceCode			=	checkForNull(rset.getString("subservice_code"));
				toSubService_Desc			=	checkForNull(rset.getString("subservice_short_desc"));
				toSplCode					=	checkForNull(rset.getString("specialty_code"));
				toSplDesc					=	checkForNull(rset.getString("specialty_short_desc"));
				toPractId					=	checkForNull(rset.getString("practitioner_id"));
				toPractName					=	checkForNull(rset.getString("practitioner_name"));
				PRACTITIONER_DESIGNATION	=	checkForNull(rset.getString("practitioner_designation"));
				toMedTeam					=	checkForNull(rset.getString("team_id"));
				toMedTeam_Desc				=	checkForNull(rset.getString("team_short_desc"));
				bkgRefNo					=	checkForNull(rset.getString("tfr_req_ref_no"));
				to_bed_class_code			=	checkForNull(rset.getString("bed_class_code"));
				to_bed_class_desc			=	checkForNull(rset.getString("bed_class_short_desc"));
				to_bed_no					=	checkForNull(rset.getString("bed_no"));
				to_room_no					=	checkForNull(rset.getString("room_no"));
				req_bed_type_code			=	checkForNull(rset.getString("bed_type_code"));
				to_bedtypedesc				=	checkForNull(rset.getString("bed_type_short_desc"));
				to_nursing_unit_locn_type	=	checkForNull(rset.getString("nursing_unit_locn_type"));
				frpractitionerid			=	checkForNull(rset.getString("from_practitioner_id"));
				frpractdesc					=	checkForNull(rset.getString("from_practitioner_name"));
				frspecialitycode			=	checkForNull(rset.getString("from_specialty_code"));
				frspecialitydesc			=	checkForNull(rset.getString("from_specialty_short_desc"));
				frbedclass					=	checkForNull(rset.getString("from_bed_class_code"));
				frbedclassdesc				=	checkForNull(rset.getString("from_bed_class_short_desc"));
				frnursingunitcode			=	checkForNull(rset.getString("from_nursing_unit_code"));
				frnursingunitdesc			=	checkForNull(rset.getString("from_nursing_unit_short_desc"));
				frbedno						=	checkForNull(rset.getString("from_bed_no"));       
				frroomno					=	checkForNull(rset.getString("from_room_no"));  
				frmeddesc					=	checkForNull(rset.getString("from_team_short_desc"));
				frteamid					=	checkForNull(rset.getString("from_team_id"));
				frservicecode				=	checkForNull(rset.getString("from_service_code"));
				frservicedesc				=	checkForNull(rset.getString("from_service_short_desc"));
				frsubservicedesc			=	checkForNull(rset.getString("from_subservice_short_desc"));
				tfr_req_code				=	checkForNull(rset.getString("tfr_req_reason"));
				tfr_req_status				= checkForNull(rset.getString("tfr_req_status"));
				r_bed						= checkForNull(rset.getString("reserved_bed_no"));
				r_room						= checkForNull(rset.getString("reserved_room_no"));
				r_nursing_unit				= checkForNull(rset.getString("reserved_nurs_unit_code"));
				blocking_type_code          = checkForNull(rset.getString("blocking_type_code"));
				
				blocking_remarks            = checkForNull(rset.getString("blocking_remarks"));
				blokcing_type_short_desc	= checkForNull(rset.getString("blokcing_type_short_desc"));
				r_nursing_unit_desc         = checkForNull(rset.getString("res_nursing_unit_short_desc"));
				blocking_period				= checkForNull(rset.getString("dflt_min_block_period"));
				mother_status				= rset.getInt("m_status");
				prct_Designation			= checkForNull(rset.getString("practitioner_designation"));
				reserved_bed_cont			= rset.getInt("reserved_bed_cont");
				
			}
			catch(SQLException ex)
			{
				
				ex.printStackTrace();
			}
			if(call_function.equals("TransferPatientIn"))
			{	
				mother_bed_status			= checkForNull(rset.getString("delink_baby_yn"));
				req_bed_type_code_by_defn	= checkForNull(rset.getString("req_bed_type_code_by_defn"));
				mode_of_transport			= checkForNull(rset.getString("mode_of_transport"));
				accomp_person1				= checkForNull(rset.getString("accomp_person1"));
				accomp_person2				= checkForNull(rset.getString("accomp_person2"));
				accomp_person3				= checkForNull(rset.getString("accomp_person3"));
				accomp_person4				= checkForNull(rset.getString("accomp_person4"));
				accomp_person5				= checkForNull(rset.getString("accomp_person5"));
				accomp_person6				= checkForNull(rset.getString("accomp_person6"));
				accomp_person7				= checkForNull(rset.getString("accomp_person7"));
				equipment1					= checkForNull(rset.getString("equipment1"));
				equipment2					= checkForNull(rset.getString("equipment2"));
				equipment3					= checkForNull(rset.getString("equipment3"));
				equipment4					= checkForNull(rset.getString("equipment4"));
				equipment5					= checkForNull(rset.getString("equipment5"));
				equipment6					= checkForNull(rset.getString("equipment6"));
				equipment7					= checkForNull(rset.getString("equipment7"));
				blood_and_medication1		= checkForNull(rset.getString("blood_and_medication1"));
				blood_and_medication2		= checkForNull(rset.getString("blood_and_medication2"));
				blood_and_medication3		= checkForNull(rset.getString("blood_and_medication3"));
				blood_and_medication4		= checkForNull(rset.getString("blood_and_medication4"));
				blood_and_medication5		= checkForNull(rset.getString("blood_and_medication5"));
				blood_and_medication6		= checkForNull(rset.getString("blood_and_medication6"));
				blood_and_medication7		= checkForNull(rset.getString("blood_and_medication7"));
				blood_and_medication8		= checkForNull(rset.getString("blood_and_medication8"));
				blood_and_medication9		= checkForNull(rset.getString("blood_and_medication9"));
				blood_and_medication10		= checkForNull(rset.getString("blood_and_medication10"));
				records_and_documents1		= checkForNull(rset.getString("records_and_documents1"));
				records_and_documents2		= checkForNull(rset.getString("records_and_documents2"));
				records_and_documents3		= checkForNull(rset.getString("records_and_documents3"));
				records_and_documents4		= checkForNull(rset.getString("records_and_documents4"));
				records_and_documents5		= checkForNull(rset.getString("records_and_documents5"));
				patient_belongings1			= checkForNull(rset.getString("patient_belongings1"));
				patient_belongings2			= checkForNull(rset.getString("patient_belongings2"));
				patient_belongings3			= checkForNull(rset.getString("patient_belongings3"));
				patient_belongings4			= checkForNull(rset.getString("patient_belongings4"));
				patient_belongings5			= checkForNull(rset.getString("patient_belongings5"));
				patient_belongings6			= checkForNull(rset.getString("patient_belongings6"));
				patient_belongings7			= checkForNull(rset.getString("patient_belongings7"));
				patient_belongings8			= checkForNull(rset.getString("patient_belongings8"));
				patient_belongings9			= checkForNull(rset.getString("patient_belongings9"));
				patient_belongings10		= checkForNull(rset.getString("patient_belongings10"));
				port_received_yn			= checkForNull(rset.getString("port_received_yn"));
				port_recd_status			= checkForNull(rset.getString("port_recd_status"));
				port_recd_remarks			= checkForNull(rset.getString("port_recd_remarks"));
				exp_discharge_date_time     = checkForNull(rset.getString("exp_discharge_date_time"));
				
				reserved_reason_code         = checkForNull(rset.getString("reserve_reason_code"));   //this line added for SCF GHL-SCF-794 [IN:047142]
				
				/*Added by Thamizh selvi on 16th May 2017 for ML-MMOH-CRF-0617 Start*/
				accomp_person1_desc				= checkForNull(rset.getString("accomp_person1_desc"));
				accomp_person2_desc				= checkForNull(rset.getString("accomp_person2_desc"));
				accomp_person3_desc				= checkForNull(rset.getString("accomp_person3_desc"));
				accomp_person4_desc				= checkForNull(rset.getString("accomp_person4_desc"));
				accomp_person5_desc				= checkForNull(rset.getString("accomp_person5_desc"));
				accomp_person6_desc				= checkForNull(rset.getString("accomp_person6_desc"));
				/*End*/
				if(rset	!= null)   rset.close();
				if(stmt  != null)   stmt.close();		
				portBuffer.append(mode_of_transport);
				portBuffer.append("^^");
				portBuffer.append(accomp_person1);
				portBuffer.append("^^");
				portBuffer.append(accomp_person2);
				portBuffer.append("^^");
				portBuffer.append(accomp_person3);
				portBuffer.append("^^");
				portBuffer.append(accomp_person4);
				portBuffer.append("^^");
				portBuffer.append(accomp_person5);
				portBuffer.append("^^");
				portBuffer.append(accomp_person6);
				portBuffer.append("^^");
				portBuffer.append(accomp_person7);
				portBuffer.append("^^");
				portBuffer.append(equipment1);
				portBuffer.append("^^");
				portBuffer.append(equipment2);
				portBuffer.append("^^");
				portBuffer.append(equipment3);
				portBuffer.append("^^");
				portBuffer.append(equipment4);
				portBuffer.append("^^");
				portBuffer.append(equipment5);
				portBuffer.append("^^");
				portBuffer.append(equipment6);
				portBuffer.append("^^");
				portBuffer.append(equipment7);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication1);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication2);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication3);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication4);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication5);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication6);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication7);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication8);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication9);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication10);
				portBuffer.append("^^");
				portBuffer.append(records_and_documents1);
				portBuffer.append("^^");
				portBuffer.append(records_and_documents2);
				portBuffer.append("^^");
				portBuffer.append(records_and_documents3);
				portBuffer.append("^^");
				portBuffer.append(records_and_documents4);
				portBuffer.append("^^");
				portBuffer.append(records_and_documents5);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings1);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings2);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings3);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings4);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings5);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings6);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings7);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings8);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings9);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings10);
				portBuffer.append("^^");
				portBuffer.append(port_received_yn);
				portBuffer.append("^^");
				portBuffer.append(port_recd_status);
				portBuffer.append("^^");
				portBuffer.append(port_recd_remarks);

				/*Added by Thamizh selvi on 16th May 2017 for ML-MMOH-CRF-0617 Start*/
				accompPerson.append(accomp_person1_desc);
				accompPerson.append("^^");
				accompPerson.append(accomp_person2_desc);
				accompPerson.append("^^");
				accompPerson.append(accomp_person3_desc);
				accompPerson.append("^^");
				accompPerson.append(accomp_person4_desc);
				accompPerson.append("^^");
				accompPerson.append(accomp_person5_desc);
				accompPerson.append("^^");
				accompPerson.append(accomp_person6_desc);
				accompPerson.append("^^");
				/*End*/
			}
		}
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
		if(SqlSB.length() > 0)
			SqlSB.delete(0, SqlSB.length());
		if(call_function.equals("TransferPatientOut"))
		{
			SqlSB.append(" select blocking_type_code, ip_get_desc.ip_blocking_type(blocking_type_code,'"+locale+"',2) blokcing_type_short_desc,");
			SqlSB.append(" block_period, block_units,override_yn ");
			/*Tuesday, May 04, 2010 , added for PE*/
			SqlSB.append(",to_char (decode(block_units,'D',sysdate + block_period,'H',sysdate + block_period / 24), 'dd/mm/rrrr hh24:mi') blocked_until_date, informed_dtls_mand_yn ");//Modified by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617
			SqlSB.append(" from ip_transfer_type_vw where transfer_type_code ='"+tfr_req_code+"' ");
			stmt				   =	con.createStatement();
			rset                   = stmt.executeQuery(SqlSB.toString());
			if (rset.next())
			{
				blocking_code	   = checkForNull(rset.getString("blocking_type_code"));
				blocking_type	   = checkForNull(rset.getString("blokcing_type_short_desc"));
				block_unit		   = checkForNull(rset.getString("block_units"));
				block_period	   = rset.getInt("block_period");
				if(block_unit.equals("D"))
					block_period   =(block_period)*24;
				override_yn		   = checkForNull(rset.getString("override_yn"));
				blocked_until_date = checkForNull(rset.getString("blocked_until_date"));
				informed_dtls_mand_yn = checkForNull(rset.getString("informed_dtls_mand_yn"),"N");//Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617
			}
				/*Tuesday, May 04, 2010 commted for PE*/
				/*
				if(!blocking_code.equals(""))
				{
					if(block_period >0 )
					{
						if(block_unit.equals("D"))
						block_period =(block_period)*24;	

						str_block_period = "select to_char((sysdate+'"+block_period+"'/24),'dd/mm/rrrr hh24:mi') a from dual";
						stmt			=	con.createStatement();
						rset = stmt.executeQuery(str_block_period);
						if (rset != null && rset.next())
						{
							blocked_until_date = rset.getString("a");
							if(blocked_until_date==null) blocked_until_date="";
						}
						if(rset !=null) rset.close(); if(stmt != null) stmt.close();
					}
					else
					{
						str_block_period = "select to_char((sysdate+'"+block_period+"'/24),'dd/mm/rrrr hh24:mi') a from dual";
						stmt			=	con.createStatement();
						rset = stmt.executeQuery(str_block_period);
						while(rset.next())
						{
							blocked_until_date = rset.getString("a");
						if(blocked_until_date==null) blocked_until_date="";
						}
						if(rset !=null) rset.close(); if(stmt != null) stmt.close();
					}
				}*/%>
				
		<%}
	}
	else
	{
		
		if(toServiceCode.equals(""))
			toServiceCode = frservicecode;
		if(toService_Desc.equals(""))
			toService_Desc = frservicedesc;
		if(toSubServiceCode.equals("")) 	
			toSubServiceCode = frsubservicecode;
		if(toSubService_Desc.equals(""))
			toSubService_Desc = frsubservicedesc;
		if(toSplCode.equals(""))
			toSplCode = frspecialitycode;
		if(toSplDesc.equals(""))
			toSplDesc = frspecialitydesc;
		if(toPractId.equals(""))
			toPractId = frpractitionerid;
		if(toPractName.equals(""))
			toPractName = frpractdesc;
		if(toMedTeam.equals(""))			
			toMedTeam = frteamid;
		if(toMedTeam_Desc.equals(""))			
			toMedTeam_Desc = frmeddesc;
		if(to_bed_class_code.equals(""))
		{
			to_bed_class_code=frbedclass;
			to_bed_class_desc=frbedclassdesc;
		}
		if(req_bed_type_code.equals(""))
			req_bed_type_code=frbedtype;
			to_bedtypedesc	=frbedtypedesc;
			/*FS102IPSRRCRF0228V2.0*/
			
			if(strBuffer.length()>0)	strBuffer.delete(0,strBuffer.length());
			strBuffer.append(" select " );
			strBuffer.append(" a.reserved_nurs_unit_code ");
			strBuffer.append(" ,a.reserved_room_no ");
			strBuffer.append(" ,a.reserved_bed_no ");
			strBuffer.append(" ,ip_get_desc.ip_nursing_unit (a.facility_id, a.reserved_nurs_unit_code, '"+locale+"', 2 ) res_nursing_unit_short_desc ");
			/*Monday, October 04, 2010 ,if EDD is less than current sysdate and if any bed was reserved before current sysdate and was not released from Release Bed function , reserved bed details will not be available because of condition  blocked_until_date_time > SYSDATE but IP_RESERVED_BED_DTL table having reserved bed data*/
			strBuffer.append(" ,(SELECT COUNT(1) FROM ip_bed_booking WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id AND booking_type = 'N' AND (blocked_until_date_time IS NULL OR blocked_until_date_time > SYSDATE) ) reserved_bed_cont ");
			strBuffer.append(" from ");
			strBuffer.append(" IP_OPEN_ENCOUNTER  a ");
			strBuffer.append(" ,ip_reserved_bed_dtl b ");
			strBuffer.append(" where a.facility_id = '"+facilityId+"' ");
			strBuffer.append(" and a.encounter_id = '"+eid+"' ");
			strBuffer.append(" and a.facility_id = b.facility_id ");
			strBuffer.append(" and a.encounter_id = b.encounter_id ");
			strBuffer.append(" and a.reserved_nurs_unit_code = b.reserved_nursing_unit_code ");
			strBuffer.append(" and a.reserved_bed_no =  b.reserved_bed_no ");
			stmt = con.createStatement() ;
			rset = stmt.executeQuery(strBuffer.toString()) ;
			if(rset != null && rset.next())
			{
				r_nursing_unit				= checkForNull(rset.getString("reserved_nurs_unit_code"));
				r_room						= checkForNull(rset.getString("reserved_room_no"));
				r_bed						= checkForNull(rset.getString("reserved_bed_no"));
				r_nursing_unit_desc         = checkForNull(rset.getString("res_nursing_unit_short_desc"));
				reserved_bed_cont	        = rset.getInt("reserved_bed_cont");
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
			
			/*FS102IPSRRCRF0228V2.0*/
}

			//Added by kishore on 9/24/2004 for check newborn function
		/*Tuesday, May 04, 2010 ,commented for PE and merged with main query.*/
		
		if(SqlSB.length() > 0)
			SqlSB.delete(0, SqlSB.length());

		SqlSB.append(" select count(*) m_status from ip_nursing_unit_bed ");
		SqlSB.append(" where ");
		SqlSB.append("  main_bed_no = '"+frbedno+"' and occupying_patient_id is not null and facility_id = '"+facilityId+"' ");
		SqlSB.append(" and nursing_unit_code = '"+frnursingunitcode+"' ");
		
		stmt = con.createStatement();
		rset = stmt.executeQuery(SqlSB.toString());
			if(rset != null)
			{
				if(rset.next())
				{
					mother_status = rset.getInt("m_status");
				}
				if(rset	!= null)   rset.close();
				if(stmt  != null)   stmt.close();		
			}
		
	//Getting Operation Station ID for Nursing Unit
	if(SqlSB.length() > 0)
	SqlSB.delete(0, SqlSB.length());

	//11/13/2008 FS102IPSRRCRF0228V2.0
		/*
		String reason_period 	= " select dflt_min_block_period  from ip_blocking_type where blocking_type_code='"+blocking_remarks+"'  ";
			
			stmt = con.createStatement() ;	
			rset = stmt.executeQuery(reason_period.toString());
			
			if( rset != null &&  rset.next())
				{
					blocking_period = checkForNull(rset.getString("dflt_min_block_period"));
				 }
				if(rset!=null) rset.close();
				
		*/
			
		
	//11/13/2008

%>
<script>

function validateFrTo()
{
	var call_function = document.forms[0].call_function.value;
	var from_bed_class	= document.forms[0].fr_bed_class.value;
	var to_bed_class = "";

	if(call_function == 'Transfer_In')
	{
		to_bed_class	= document.forms[0].Bedcode.value;
	}
	
	if(call_function == 'Transfer_Out')
	{
		to_bed_class	= document.forms[0].to_bed_class.value;
	}

	var from_bed_type	= document.forms[0].fr_bed_type.value;
	var to_bed_type		= document.forms[0].bed_type_code.value;

	if( (from_bed_class == to_bed_class) && (from_bed_type == to_bed_type) )
	{
		self.document.forms[0].bed_change.checked = false;
		self.document.forms[0].bed_change.value = "N";
		self.document.forms[0].bed_change.onclick();
	}
}


function CheckNursingUnit()
{		
	var nursingunit=document.forms[0].nursing_unit_desc.value;
	if(nursingunit == '')
	{
	document.forms[0].nursing_unit_code.value='';
	document.forms[0].service.value='';
	document.forms[0].sub_service.value='';
	document.forms[0].pract_desig.value='';

	<%if(call_function.equals("TransferPatientIn"))
	{%>
	if (document.forms[0].bed_status_name != null)
			document.forms[0].bed_status_name.style.visibility = "Hidden" ;
	document.forms[0].to_bed_no.value='';
	document.forms[0].to_room_no.value = '';	
	if(document.forms[0].bed_class_allowed.value !='Y'){
	document.forms[0].Bedcode.value='';
	var obj =document.forms[0].bed_type_code;		
		var length  = obj.length;
		for(i=0;i<length;i++) 
		{
		obj.remove(1);
		}
	}
	<%}%>
	var obj =document.forms[0].service;		
		var length  = obj.length;
		for(i=0;i<length;i++) 
		{
		obj.remove(1);
		}
	var obj1 =document.forms[0].sub_service;
		var length1  = obj1.length;
		for(i=0;i<length1;i++) 
		{
		obj1.remove(1);
		}
	}
	if(document.forms[0].nursing_unit_desc.value ==document.forms[0].fr_nursing_unit_desc.value)
	{
		var error = getMessage('TFR_SAME_NU_NOT_ALLOW','IP');
		error = error.replace('$',getLabel('Common.nursingUnit.label','Common'));
		alert(error);
		var obj =document.forms[0].service;		
		var length  = obj.length;
		for(i=0;i<length;i++) 
		{
		obj.remove(1);
		}
		var obj1 =document.forms[0].sub_service;
		var length1  = obj1.length;
		for(i=0;i<length1;i++) 
		{
		obj1.remove(1);
		}
		document.forms[0].nursing_unit_desc.value ="";

		document.forms[0].nursing_unit_desc.focus();
		return false;
	}
}

function compareSystemDate_tout(calid2)
{

  if (calid2.value != "" || calid2.value != '')
	{
		if(!validDateObj(calid2,"DMYHM",localeName))
		{
			return ;
		}
		
		var greg_authorizationDateTime = convertDate(calid2.value,'DMYHM',localeName,'en');
		var greg_prefDateTime = convertDate(parent.frames[1].document.trf_form.pref_date.value,'DMYHM',localeName,'en');
		/* 17956 Thursday, January 07, 2010*/
		var max_trn_date_time = convertDate(parent.frames[1].document.forms[0].max_trn_date_time.value,'DMYHM',localeName,'en');
				
		if(!isBefore(greg_authorizationDateTime,greg_prefDateTime,'DMYHM','en'))
		{
			/* 17956 Thursday, January 07, 2010*/ 
			var error = getMessage('DATE1_GT_DATE2','IP');
			error = error.replace('$',getLabel("eIP.AuthorizationDateTime.label","IP"));
			error = error.replace('#',getLabel("eIP.PreferredDateTime.label","IP"));
			alert(error);
			calid2.value= "";
			calid2.focus();
			
			return false;
		}
		if(!isBefore(parent.frames[1].document.trf_form.admission_date.value,greg_authorizationDateTime,'DMYHM','en'))
		{
			/* 17956 Thursday, January 07, 2010*/
			var error = getMessage('DATE1_LT_DATE2','IP');
			error = error.replace('$',getLabel("eIP.AuthorizationDateTime.label","IP"));
			error = error.replace('#',getLabel("Common.AdmissionDateTime.label","Common"));
			alert(error);
			calid2.value= "";
			calid2.focus;
			return false;
		}
		/* 17956 Thursday, January 07, 2010*/
		if(!isBefore(max_trn_date_time,greg_authorizationDateTime,'DMYHM','en')){
			 var error = getMessage('DATE1_LT_DATE2','IP');
			 var last_encounter = getLabel("eIP.LastTransactionDateTime.label","IP");
			 error = error.replace('$',getLabel("eIP.AuthorizationDateTime.label",'IP'));
			 error = error.replace('#',last_encounter);
			 alert(error);
   			 calid2.value= "";
			 calid2.select();
 			return false;

		}
		
	}
}

function compareSystemDate1(calid)
{
	if (calid.value != "" || calid.value != '' )
	{
		
		if(!validDateObj(calid,"DMYHM",localeName))
		{
			return ;
		}
		/* 17956 Thursday, January 07, 2010*/
		var max_trn_date_time = convertDate(parent.frames[1].document.forms[0].max_trn_date_time.value,'DMYHM',localeName,'en');
		var greg_informedDateTime = convertDate(calid.value,'DMYHM',localeName,'en');
		var greg_prefDateTime = convertDate(parent.frames[1].document.trf_form.pref_date.value,'DMYHM',localeName,'en');
		/*  17956 Thursday, January 07, 2010 */
		if(!isBefore(greg_informedDateTime,greg_prefDateTime,'DMYHM','en'))
		{
			var error = getMessage('DATE1_GT_DATE2','IP');
			error = error.replace('$',getLabel("Common.InformedDate/Time.label","Common"));
			/*  17956 Thursday, January 07, 2010 */
			error = error.replace('#',getLabel("eIP.PreferredDateTime.label","IP"));
			alert(error);	
			calid.select();
			calid.focus;
			return false;
		}

		if(!isBefore(parent.frames[1].document.trf_form.admission_date.value,greg_informedDateTime,'DMYHM','en'))
		{
			var error = getMessage('DATE1_LT_DATE2','IP');
			error = error.replace('$',getLabel("Common.InformedDate/Time.label","Common"));
			/*  17956 Thursday, January 07, 2010 */
			error = error.replace('#',getLabel("Common.AdmissionDateTime.label","Common"));
			alert(error);
			calid.select();
			calid.focus;
			return false;
		}
			/* 17956 Thursday, January 07, 2010*/
		if(!isBefore(max_trn_date_time,greg_informedDateTime,'DMYHM','en')){
			 var error = getMessage('DATE1_LT_DATE2','IP');
			 var last_encounter = getLabel("eIP.LastTransactionDateTime.label","IP");
			 error = error.replace('$',getLabel("Common.InformedDate/Time.label","Common"));
			 error = error.replace('#',last_encounter);
			 alert(error);
   			 calid.value= "";
			 calid.select();
 			return false;

		}

	}
}

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
}
function disabledAllFields()
	{
		
		document.getElementById('nursing_unit_desc').disabled	= true;
		document.getElementById('nursing_unit_lookup').disabled	= true;
		document.getElementById('service').disabled				= true;
		document.getElementById('sub_service').disabled			= true;
		document.getElementById('Bedcode').disabled				= true;
		document.getElementById('bed_type_code').disabled		=true;
		if (document.getElementById('to_bed_class').value == "")
			document.getElementById('Bedcode').value				= "";	
		else
		document.getElementById('Bedcode').value				= document.getElementById('to_bed_class').value;
		document.getElementById('to_bed_no').disabled			= true;
		document.getElementById('to_room_no').disabled			= true;
		document.getElementById('Splcode_desc').disabled		= true;
		document.getElementById('pract_desc').disabled			= true;
		document.getElementById('pract_desig').disabled			= true;
		document.getElementById('team_id').disabled				= true;
		document.getElementById('info_pat_relatives').disabled	= true;
		document.getElementById('info_date_time').disabled		= true;
		document.getElementById('inform_to').disabled			= true;
		document.getElementById('auth_date_time').disabled		= true;
		document.getElementById('info_pat_name').disabled		= true;
		document.getElementById('bed_avail').disabled			= true;
		document.getElementById('Splcode_lookup').disabled		= true;
		document.getElementById('pract_id_search').disabled		= true;

		document.getElementById('cancel_reason').value			= "";
		document.getElementById("ondate1").disabled					= true;	
		document.getElementById('inform_button').disabled = true;
		document.getElementById("img2").style.visibility				= 'hidden';
		document.getElementById("img3").style.visibility				= 'hidden';
		document.getElementById("img4").style.visibility				= 'hidden';
		document.getElementById("img5").style.visibility				= 'hidden';
		document.getElementById("ondate1").style.visibility			= 'hidden';
		document.getElementById("ondate2").style.visibility			= 'hidden';
		document.getElementById("serv_img").style.visibility			= 'hidden';
		document.getElementById("received_img").style.visibility		= 'hidden';
		document.getElementById('Bedcode').disabled = true;
		document.getElementById('to_bed_class').disabled = true;
		document.getElementById("img_informed_date").style.visibility = "Hidden";
		document.getElementById("img_m").style.visibility				= "hidden";
		document.getElementById('cancel_reason').disabled		= true;	 
		document.getElementById("cancelreasonid").style.visibility   = "hidden";	 
		document.getElementById('cancel_reason').value		= "";	 
		
		if (document.forms[0].inform_to.value != "")
			document.getElementById("img_informed_date").style.visibility = "Visible";
		else	
			document.getElementById("img_informed_date").style.visibility = "Hidden";
		document.getElementById("img_auth_date").style.visibility = "Hidden";
		
	}

function ChkNumberInput(fld, e, deci)
{
if (parseInt(deci)>0)
   var strCheck = '.0123456789 /:';
else
   var strCheck = '0123456789 /:';

   var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  // Enter
	key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}


function ValidatePrefDateTime(from,to)
{
    from = from.value
    to   = to.value
    var a=  from.split(" ")
    splitdate=a[0];
    splittime=a[1]
    var splitdate1 =splitdate.split("/")
    var splittime1= splittime.split(":")
    var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
    a=  to.split(" ")
    splitdate=a[0];
    splittime=a[1]
	splitdate1 =splitdate.split("/")
	splittime1= splittime.split(":")
	time3=splittime1[1]
	var strCheck = ':0123456789';
	for(var i=0;i<=time3.length;i++) 
	{
		if (strCheck.indexOf(time3.charAt(i)) == -1)
		{
			alert(getMessage("INVALID_DATE_TIME","SM"));
			return false;
			break;
		}
	}
     var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	if(Date.parse(to_date) < Date.parse(from_date))
    {
        return false;
    }
    else
        return true;
}

//added by kishore on 9/6/2004
function setDesable()
{

	var obj =document.getElementById('bed_type_code');		
	var length  = obj.length;
	for(i=0;i<length;i++) 
	{
		obj.remove(1);
	}
	var opt= parent.frames[1].document.createElement('Option');
	opt.text="<%=to_bedtypedesc%>"; 
	opt.value="<%=req_bed_type_code%>";

	if(opt.text != '')
	{
		opt.selected = true;
		obj.add(opt);
	}
	parent.frames[1].document.createElement('Option');
	if(document.forms[0].call_function_name.value=='TransferPatientIn')
		var obj1 =document.getElementById('Bedcode');	
	else
		var obj1 =document.getElementById('to_bed_class');	

	var length  = obj1.length;
	
	for(i=0;i<length;i++) 
	{
		obj1.remove(1);
	}
	
	var opt= parent.frames[1].document.createElement('Option');
	opt.text="<%=to_bed_class_desc%>"; 
	opt.value="<%=to_bed_class_code%>";
	opt.selected = true;
	obj1.add(opt);
	parent.frames[1].document.createElement('Option');

	if(document.forms[0].bed_class_allowed.value=='Y')
	{
		document.forms[0].to_bed_class.disabled=true;
		document.forms[0].Bedcode.disabled=true;
		document.forms[0].bed_type_code.disabled=true;
	}
	else if(document.forms[0].bed_class_allowed.value=='N')
	{
	<%	if(call_function.equals("TransferPatientOut")&& !priority.equals(""))
		{	%>
			document.forms[0].to_bed_class.disabled=true;
			document.forms[0].Bedcode.disabled=true;
			document.forms[0].bed_type_code.disabled=true;
	<%	}	%>
	}
	//11/14/2008  FS102IPSRRCRF0228V2.0 
	if(document.forms[0].call_function.value == "Transfer_In"){
		if(document.forms[0].reserve_bed_on_tfr_yn.value == 'Y'){
			if(document.forms[0].reserved_bed_yn.value.checked == true)
			{
				//document.forms[0].reason_for_reserved_bed.disabled=false;
				//document.forms[0].reserved_bed_img.style.visibility='visible';
			}else
			{
				//document.forms[0].reason_for_reserved_bed.value = '';
				//document.forms[0].reason_for_reserved_bed.disabled=true;
				//document.forms[0].reserved_bed_img.style.visibility='hidden';
			}
		}
	}
	
	
	if(document.forms[0].call_function.value == "Transfer_Out"){
		if(document.forms[0].reserve_bed_on_tfr_yn.value == 'Y'){
			if(document.forms[0].reserved_bed_yn.checked == true){
				document.forms[0].reason_for_reserved_bed.disabled = false;
			}else{
				document.forms[0].reason_for_reserved_bed.disabled = true;
			}
		}
	}
	
}

function setEnable()
{
	var call_func = document.forms[0].call_function_name.value;
	if (document.forms[0].bed_change.checked==true)
	{
		document.forms[0].bed_change.value="Y";
		document.forms[0].to_bed_class.disabled=false;
		document.forms[0].bed_type_code.disabled=false;
		
			if(call_func == 'TransferPatientOut')
			{
				getBedClass();
			}
			else
				getBedtype();
	}
	else
	{
	document.forms[0].bed_change.value="N";
    document.forms[0].to_bed_class.value=document.forms[0].frbedclass.value;
	document.forms[0].to_bed_class.disabled=true;
	document.forms[0].bed_type_code.disabled=true;
	if(call_func == 'TransferPatientOut')
	{
		var obj = document.forms[0].to_bed_class;
		var length  = obj.length;
		for(i=0;i<length;i++) 
		{
			obj.remove(1);
		}
		var opt= document.createElement('Option');
		opt.text=document.forms[0].fr_bed_class_descn.value; 
		opt.value=document.forms[0].frbedclass.value;
		obj.add(opt)
		opt.selected = true;
	}
	else
	{
		document.getElementById('bed_type_code').value = document.getElementById('fr_bed_type').value;
	}
		var obj = document.getElementById('bed_type_code');
		var length  = obj.length;
		for(i=0;i<length;i++) 
		{
			obj.remove(1);
		}
		var opt= document.createElement('Option');
		opt.text=document.getElementById('frbedtypedesc').value; 
		opt.value=document.getElementById('fr_bed_type').value;
		obj.add(opt)
		opt.selected = true;
	}
}
	function getBedClass()
	{
		var obj1 = parent.frames[2].document.forms[0].nursing_unit_desc;
		var obj_nUnit_code = parent.frames[2].document.forms[0].nursing_unit_code;
		var deactivate_pseudo_bed_yn = parent.frames[2].document.forms[0].deactivate_pseudo_bed_yn.value;
		if((obj1.value!=null)&&(obj1.value!=""))
		{
		var bed_class = parent.frames[2].document.forms[0].to_bed_class.value;

		var obj2 = parent.frames[2].document.forms[0].to_bed_class;
		var length  = obj2.length;
		for(i=0;i<length;i++) 
		{
		obj2.remove(1);
		}

		var obj = parent.frames[2].document.forms[0].bed_type_code;
		length  = obj.length;
		for(i=0;i<length;i++) 
		{
			obj.remove(1);
		}
	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form1' id='dum_form1' method='post' action='../../eIP/jsp/TransferValidation.jsp' ><input type='hidden' name='field4' id='field4' value='getBedClass'><input type='hidden' name='function_Id' id='function_Id' value='TRANSFER_PAT_OUT'><input type='hidden' name='nursingunitcode' id='nursingunitcode' value=\""+obj_nUnit_code.value+"\"><input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value=\""+deactivate_pseudo_bed_yn+"\"></form></body></html>";
	parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[3].document.dum_form1.submit();
	}
 }

function getBedtype()
{
	if(document.forms[0].call_function_name.value=='TransferPatientIn')
		var bed_class = document.forms[0].Bedcode.value;
	else
		var bed_class = document.forms[0].to_bed_class.value;

	document.forms[0].bed_type_code.value='';
	document.forms[0].to_bed_no.value='';
	document.forms[0].to_room_no.value='';
	var obj =document.forms[0].bed_type_code;		
		var length  = obj.length;
		for(i=0;i<length;i++) 
		{
		obj.remove(1);
		}
	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/TransferValidation.jsp'>"+
	" <input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value=''> "+
	" <input type='hidden' name='field3' id='field3' value="+document.forms[0].nursing_unit_code.value+"><input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value="+document.forms[0].deactivate_pseudo_bed_yn.value+"><input type='hidden' name='field4' id='field4' value=''><input type='hidden' name='field8' id='field8' value=''><input type='hidden' name='field9' id='field9' value='Tfr_out'><input type='hidden' name='bed_class' id='bed_class' value=\""+bed_class+"\"></form></body></html>";
 
	parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[3].document.dum_form.submit();
}
		function expandCollapse(calledFrom) {					

					if(calledFrom == 'Occupancy_Details') {

						document.getElementById("Occupancy").style.display = 'inline';
						document.getElementById("Other").style.display = 'none';
						document.getElementById("Porterage").style.display = 'none';
						document.getElementById("Medical").style.display = 'none';
						document.getElementById("Patient").style.display = 'none';
						parent.Button_frame.document.getElementById('button_s').disabled = false;
						if(document.forms[0].call_function_name.value == 'TransferPatientOut'){
						if(document.forms[0].reserve_reason_code.value != "" && eval(document.forms[0].bed_blocking_period.value) != "")
							setReserveBedDtls();
						}
						
					} else if(calledFrom == 'other_details') {
						
						document.getElementById("Occupancy").style.display = 'none';
						document.getElementById("Other").style.display = 'inline';
						document.getElementById("Porterage").style.display = 'none';
						document.getElementById("Medical").style.display = 'none';
						document.getElementById("Patient").style.display = 'none';
						if(document.forms[0].call_function_name.value == 'TransferPatientOut' && document.forms[0].book_conf_yn.value > 0)
							getBlockBedDate();
						
					} else if(calledFrom == 'porterage_details') {

						document.getElementById("Occupancy").style.display = 'none';
						document.getElementById("Other").style.display = 'none';
						document.getElementById("Porterage").style.display = 'inline';
						document.getElementById("Patient").style.display = 'inline';
						document.getElementById("Medical").style.display = 'none';



					} else if(calledFrom == 'Patient_Details') {

						document.getElementById("Occupancy").style.display = 'none';
						document.getElementById("Other").style.display = 'none';
						document.getElementById("Porterage").style.display = 'inline';
						document.getElementById("Patient").style.display = 'inline';
						document.getElementById("Medical").style.display = 'none';

					} else if(calledFrom == 'Medical_details') {

						document.getElementById("Occupancy").style.display = 'none';
						document.getElementById("Other").style.display = 'none';
						document.getElementById("Porterage").style.display = 'inline';
						document.getElementById("Patient").style.display = 'none';
						document.getElementById("Medical").style.display = 'inline';
					}
					
				}
	
</script>
	<%if(call_function.equals("TransferPatientIn"))
	{
	%>
	<body onload='disabledAllFields();populateDetails();setDesable();' onMouseDown='CodeArrest()' onKeyDown='lockKey();'>
	<%}
	else
	{
	if(call_function.equals("TransferPatientOut")&& nRec>0){ %>
	<body onload='populateDetails();getBlockBedDates();<%if(autoCnrmTfrReq.equals("Y")){%>enableBedNo();<%}%><%if(isCnrmReqPatOutChngAppl){%>chkInformedDtlsMandOnLoad();<%}%><%if(!blocking_type_code.equals("")){%>setReserveBedDtls();<%}%>' onMouseDown='CodeArrest()' onKeyDown='lockKey();'><!--Modified by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617-->
	<%}
	else{%>
	<body onload='checkform();populateDetails();disabledef();<%if(autoCnrmTfrReq.equals("Y")){%>enableBedNo();<%}%><%if(isCnrmReqPatOutChngAppl){%>chkInformedDtlsMandOnLoad();<%}%>' onMouseDown='CodeArrest()' onKeyDown='lockKey();'><!--Modified by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617-->
	<%}%>
	<%}%>
	<form name="EmergencyTransfer_form" id="EmergencyTransfer_form"  method="post" <%if(call_function.equals("TransferPatientIn"))
	{%>action="../../servlet/eIP.TransferPatientInServlet"  <%}else 		{%>action="../../servlet/eIP.TransferPatientOutServlet" <%}%> target="parent.frames[1]">
	<input type='hidden' name='call_function_hdd' id='call_function_hdd' value="<%=call_function%>">
	
	<!-- <a name="demo" tabindex='0'></a>  -->
	<div id ="Occupancy">
	
	<ul id="tablist" class="tablist">
		<li class="tablistitem" title="Occupancy Details">
			<a onclick="expandCollapse('Occupancy_Details')"  class="tabClicked" id="Occupancy_Details" ><span class="tabSpanclicked " id="Occup_tabspan"><fmt:message key="eIP.OccupancyDetails.label" bundle="${ip_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Other Details">
			<a onclick="expandCollapse('other_details')" class="tabA" id="other_details" ><span class="tabAspan" id="Othe_tabspan"><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Porterage Details">
			<a onclick="expandCollapse('porterage_details')" class="tabA" id="porterage_details" ><span class="tabAspan" id="Port_tabspan"><fmt:message key="eIP.PorterageDetails.label" bundle="${ip_labels}"/></span>
			</a>
		</li>
	</ul>
	<table border="0" width="100%" cellpadding="3" cellspacing="0">
		 <tr>
				<th  width='25%' class='columnheader'>&nbsp;</th>
	            <th align="left" style=" color: white;" width='25%' class='columnheader'><fmt:message key="Common.current.label" bundle="${common_labels}"/> </th>
				<th  width='25%' class='columnheader'>&nbsp;</th>
	            <th align="left" style=" color: white;" class='columnheader' width='25%'><fmt:message key="Common.TransferTo.label" bundle="${common_labels}"/></th>
		        
		</tr>
	
		<tr>
			<td colspan=4 class='CAGROUP'><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></td>
		</tr> 
		<%
			 if(!priority.equals(""))
			 {
		 %>
		<tr>
		<td class="label" ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class="label" >&nbsp;</td>
			
			<td  class='querydata'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class='fileds'>
				<select name="priority" id="priority" disabled>
					<option value="<%=priority_code%>"><%=priority%> </option>
				</select>
			</td>
		</tr>
		 <%
			 }
		 %>
		<tr>
			<td class="label" ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			<td  class='querydata' ><%=frnursingunitdesc%>
				<input type="hidden" name="fr_nursing_unit_code" id="fr_nursing_unit_code" value="<%=frnursingunitcode%>">
				<input type="hidden" name="fr_nursing_unit_desc" id="fr_nursing_unit_desc" value="<%=frnursingunitdesc%>">
			</td>
			<td class="label" ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		 	<td class='fileds'><input type=text name="nursing_unit_desc" id="nursing_unit_desc"  maxlength=15 size=15 <%if((nRec==0)){%> value='' <%}else{%>value="<%=toNursingUnit_Desc%>" <%}%> onblur="beforeGetNursingUnit(nursing_unit_desc,'<%=facilityId%>','<%=loginUser%>','<%=patient_class%>');CheckNursingUnit();<%if(call_function.equals("TransferPatientOut")){%>enbldisbchk(this);<%}%>"  ><input type=button class=button name=nursing_unit_lookup id=nursing_unit_lookup value='?' onClick="checkNursTxtVal(nursing_unit_desc,'<%=facilityId%>','<%=loginUser%>','<%=patient_class%>');" ><img align="center" id = "img2" src="../../eCommon/images/mandatory.gif">
			<input type=hidden name="nursing_unit_code" id="nursing_unit_code"  value="<%=toNursingUnitCode%>" >
			<input type=hidden name="nurs_desc_hid" id="nurs_desc_hid" value="<%=toNursingUnit_Desc%>"></td>
			</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			<td  class='querydata' ><%=frservicedesc%>
				<input type="hidden" name="fr_service_code" id="fr_service_code" value="<%=frservicecode%>">
				<input type="hidden" name="fr_service_desc" id="fr_service_desc" value="<%=frservicedesc%>">
			</td>
			<td class="label" ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			<td  class="fileds" nowrap>	
			
			<select name="service" id="service" <% if((nRec>0)&(call_function.equals("TransferPatientOut"))){%>onChange='' <%}else{%> onChange='onServiceChange()' <%}%> >

			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<%if((nRec!=0))
			{%>
			<%
				String service_code = "", service_desc = "";
				
				if(SqlSB.length() > 0)
					SqlSB.delete(0, SqlSB.length());

				SqlSB.append(" select service_code, am_get_desc.am_service(service_code,?,2 ) service_short_desc from ip_nurs_unit_for_service where facility_id = ? ");
				SqlSB.append(" and nursing_unit_code = ? union select service_code, am_get_desc.am_service(service_code,?,2 ) service_short_desc ");
				SqlSB.append(" from ");
				SqlSB.append(" ip_nursing_unit where ");
				SqlSB.append(" facility_id = ? ");
				SqlSB.append(" and nursing_unit_code = ? order by 2 ");
				pstmt = con.prepareStatement(SqlSB.toString());
				pstmt.setString(1,locale);
				pstmt.setString(2,facilityId);
				pstmt.setString(3,toNursingUnitCode);
				pstmt.setString(4,locale);
				pstmt.setString(5,facilityId);
				pstmt.setString(6,toNursingUnitCode);
				rset = pstmt.executeQuery();
				if(rset!=null )
				{
					while(rset.next())
					{
						service_code  = rset.getString("service_code");
						service_desc = rset.getString("service_short_desc");
						
						if (service_code.equals(toServiceCode))
							sel = "selected";
						else
							sel = "";
						out.print("<option value=\""+service_code+"\" "+sel+">"+service_desc+"");
					}
				if(rset	!= null)   rset.close();
				if(pstmt  != null)   pstmt.close();		
				}
			%>
			<%}%>
			</select><img align="center" id="serv_img" src="../../eCommon/images/mandatory.gif">
			</td>
		</tr>
		
		<tr>
			<td class="label" ><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
			<td  class='querydata' ><%=frsubservicedesc%>
				<input type="hidden" name="fr_sub_service_code" id="fr_sub_service_code" value="<%=frsubservicecode%>">
			<input type="hidden" name="fr_service_desc" id="fr_service_desc" value="<%=frsubservicedesc%>">
			</td>
			<td class="label" ><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
			<td  class="fileds" nowrap>	
			<select name="sub_service" id="sub_service" >
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<%if((nRec!=0))
			{%>
			<%
				String subsel = "";
				String sersql="";
				String subservice_code = "", subservice_desc = "";
				
				if(nRec>0)
				{
					
					sersql = "select service_code, am_get_desc.am_service(service_code,?,2 )service_short_desc, subservice_code, am_get_desc.am_subservice(service_code,subservice_code,?,2 ) subservice_short_desc from am_facility_subsrvc where operating_facility_id = ? and service_code = ? and eff_status = 'E'";
				}
				else
				{
					sersql = "select service_code,am_get_desc.am_service(service_code,?,2 ) service_short_desc, subservice_code, am_get_desc.am_subservice(service_code,subservice_code,?,2 )subservice_short_desc   from am_facility_subsrvc where operating_facility_id = ? and service_code = ? and eff_status = 'E'";
				}
				pstmt = con.prepareStatement(sersql);
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,facilityId);
				if(nRec>0)
					pstmt.setString(4,toServiceCode);
				else
					pstmt.setString(4,frservicecode);
				rset = pstmt.executeQuery();
				if(rset!=null )
				{
					while(rset.next()){
						subservice_code  = rset.getString("SUBSERVICE_CODE");
						subservice_desc = rset.getString("SUBSERVICE_SHORT_DESC");
						if(nRec>0)
						{						
						if (subservice_code.equals(toSubServiceCode))
							subsel = "selected";
						else
							subsel = "";
						out.print("<option value=\""+subservice_code+"\" "+subsel+">"+subservice_desc+"");
						}
						else
						{
						if (subservice_code.equals(frsubservicecode))
						subsel = "selected";
						else
							subsel = "";
						out.print("<option value=\""+subservice_code+"\" "+subsel+">"+subservice_desc+"");
						}
					}
				if(rset	!= null)   rset.close();
				if(pstmt  != null)   pstmt.close();		
				}
			%>
				<%}%>
			</select>
			</td>

		</tr>
		<%
	if(bed_class_allowed.equals("Y")&& nRec<=0){
		%>
		<tr>
			<td class="label" ><fmt:message key="eIP.RequestBedClassChange.label" bundle="${ip_labels}"/></td>
			<td  class='querydata' >&nbsp;</td>
			<td class="label"  ><fmt:message key="eIP.RequestBedClassChange.label" bundle="${ip_labels}"/></td>
			<td class='fileds' >
				<input type='checkbox' name='bed_change' id='bed_change'  onClick="setEnable();"  >
			</td>
		</tr>
		<%}%>
		<tr>
			<td class="label" ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
			<td class='querydata'  <%=colspanValue%> ><%=frbedclassdesc%><input type="hidden" name="fr_bed_class" id="fr_bed_class" value="<%=frbedclass%>"  >
			<input type="hidden" name="fr_bed_class_descn" id="fr_bed_class_descn" value="<%=frbedclassdesc%>" >
			</td>
			<td class="label"  ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
			
			<td  class='fileds'>	
			<select <%if(call_function.equals("TransferPatientIn")){%> id='Bedcode' name='Bedcode' <%} else{%> id='to_bed_class' name='to_bed_class'<%}%> onChange='getBedtype();' ><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
	<%
			if(call_function.equals("TransferPatientIn")){
			try{
			//String sql2="Select bed_class_code, short_desc from ip_bed_class_lang_vw where eff_status='E'  and language_id='"+locale+"' order by short_desc ";
			String sql2="Select bed_class_code, ip_get_desc.ip_bed_class(bed_class_code,?,2)short_desc from ip_bed_class where eff_status='E'  order by short_desc ";
			String bedcode="";
			String beddesc="";
			String subsel	="";
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1,locale);
			if(to_bed_class_code.equals(""))
				to_bed_class_code=frbedclass;
			rset = pstmt.executeQuery();
				if( rset != null )
				{
			  while( rset.next() )
				  {
					bedcode   = rset.getString("bed_class_code") ;
					 beddesc   = rset.getString("short_desc") ;


					if (bedcode.equals(to_bed_class_code))
						subsel = "selected";
					
					else
						subsel = "";
					out.println("<option value=\""+bedcode+"\" "+subsel+">"+beddesc+"</option>");
					}
				if(rset	!= null)   rset.close();
				if(pstmt  != null)   pstmt.close();		
				}
			}catch(Exception e) 
			{
				
				e.printStackTrace();
			}
		}
	%>

	</select><img align="center" src="../../eCommon/images/mandatory.gif">
			
		<input type="hidden" name="hid_bed_code" id="hid_bed_code" value="<%=to_bed_class_code%>" >	
			</td>

		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
			<td  class='querydata' ><input type="hidden" name="fr_bed_type" id="fr_bed_type" value="<%=frbedtype%>" ><%=frbedtypedesc%></td><input type="hidden" name="frbedtypedesc" id="frbedtypedesc" value="<%=frbedtypedesc%>" >
			<td class="label" ><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
			<%-- <td ><select name='bed_type_code' id='bed_type_code' onchange='validateFrTo();' ><option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<input type="hidden" name="hid_bed_type" id="hid_bed_type" value="" ><img align="center" src="../../eCommon/images/mandatory.gif"></td> --%>
			<td ><select name='bed_type_code' id='bed_type_code' onchange='validateFrTo();' ><option value='<%=frbedtype%>' selected><%=frbedtypedesc%><input type="hidden" name="hid_bed_type" id="hid_bed_type" value="" ><img align="center" src="../../eCommon/images/mandatory.gif"></td>
			</tr>
		<tr>
			<td class="label"  ><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
			<td class='querydata'  <%=colspanValue%> ><input type="hidden" name="fr_bed_no" id="fr_bed_no" value="<%=frbedno%>" > <%=frbedno%></td>
			
			<!-- Modified by Sangeetha on 25/05/17 for GDOH-CRF-0151-->
			<td class="label" ><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
			
				<td class='fileds'><input type="text" readOnly name="to_bed_no" id="to_bed_no"  value="<%=to_bed_no%>" size=8 maxlength=8 onBlur="ChangeUpperCase(this);getRoomNo(this);<% if(restrictPseudoBed){ %>chkforVacantNormalBed();<% }%>" onKeyPress='return CheckForSpecChars(event)' disabled ><input type="button" class="button" name="bed_avail" id="bed_avail" value="?" onclick="callBedAvailChart();" <% if(restrictPseudoBed){ %>onblur="chkforVacantNormalBed()" <% }%> disabled >
				
				<% if(isCnrmReqPatOutChngAppl && autoCnrmTfrReq.equals("Y")){ %>
					<% if(!priority.equals("")|| call_function.equals("TransferPatientIn") || call_function.equals("TransferPatientOut")){ %>
						<img align="center" id="img3" src="../../eCommon/images/mandatory.gif">
					<% } %>
				<% }else{ %>
					<% if(!priority.equals("")|| call_function.equals("TransferPatientIn")){ %>
						<img align="center" id="img3" src="../../eCommon/images/mandatory.gif">
					<%}%>
				<% } %>
					<%
						if (!to_bed_no.equals(""))
						{
					%>
							<jsp:include page="OccupiedBedDetails.jsp" ><jsp:param name="flush" value="true" />
								<jsp:param name="to_room_no" value="<%=to_room_no%>" />
								<jsp:param name="to_bed_no" value="<%=to_bed_no%>" />
							</jsp:include>
					<%
						}
					%>
				</td>
			
		</tr>
 		<tr>
			<td class="label" ><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></td>
			<td class='querydata'  ><input type="hidden" name="fr_room_no" id="fr_room_no" value="<%=frroomno%>" ><%=frroomno%> </td>
			
			<td class="label"  ><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></td>
			<td ><input type="text" name="to_room_no" id="to_room_no"  value="<%=to_room_no%>" size=4 maxlength=4 readonly onBlur="specialChar(this,'Char')" disabled > </td>
			
		</tr>		
			
		<tr>
			<td class="label"  ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='querydata'  ><%=frspecialitydesc%>
				<input type="hidden" name="fr_speciality_code" id="fr_speciality_code" value="<%=frspecialitycode%>">
			</td>
			<td class="label" ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='fileds' ><input type=text name='Splcode_desc' id='Splcode_desc' onblur="beforeGetSpecialty(Splcode_desc,'<%=facilityId%>');" maxlength=15 size=15  value="<%=toSplDesc%>" ><input type=hidden name='Splcode' id='Splcode'  value="<%=toSplCode%>"><input type=button name='Splcode_lookup' id='Splcode_lookup' value='?' class=button onClick="checkSpecTxtVal(Splcode_desc,'<%=facilityId%>');" ><img id = "img4"  src='../../eCommon/images/mandatory.gif'align='center'></img><input type=hidden name="spec_desc_hid" id="spec_desc_hid" value="<%=toSplDesc%>"></td>
			
		</tr>
		<tr>
			
			<td class="label" ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td class='querydata' id="PractDesc"  nowrap ><%=frpractdesc%>
				<input type="hidden" name="fr_practitioner_id" id="fr_practitioner_id" value="<%=frpractitionerid%>">
			</td>
			<td class="label" ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td nowrap class='fileds'><input type='hidden' name='practid' id='practid' value="<%=toPractId%>" readonly><input type='text' name='pract_desc' id='pract_desc' value="<%=toPractName%>" size='25' maxlength='30' onblur="clearDesignation();beforeGetPractitioner(practid,this,'<%=facilityId%>');" ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button'  onClick="checkPractTxtVal(document.forms[0].practid,pract_desc, '<%=facilityId%>');"  ><img align="center" id="img5" src="../../eCommon/images/mandatory.gif"><input type=hidden name="pract_desc_hid" id="pract_desc_hid" value="<%=frpractdesc%>"> 
			</td>			
		</tr>
		
			<%--
				/* commented for PE and added in main query
				String sql_prct_desg= "select B.POSITION_DESC PRACTITIONER_DESIGNATION from AM_PRACTITIONER_lang_vw A, AM_POSITION_LANG_VW B WHERE  a.position_code=b.position_code(+) and a.PRACTITIONER_ID ='"+frpractitionerid+"' and a.language_id='"+locale+"' and b.language_id='"+locale+"'";
				String prct_Designation="";
				stmt = con.createStatement();
				rset = stmt.executeQuery(sql_prct_desg);
				if(rset!=null )
				{
					while(rset.next())
					{
					prct_Designation=rset.getString("PRACTITIONER_DESIGNATION");
					if(prct_Designation ==null)prct_Designation="";
					}
				if(rset	!= null)   rset.close();
				if(stmt  != null)   stmt.close();		
				}*/
			--%>
			<tr>
			<td class="label" ><fmt:message key="eIP.PractitionerDesignation.label" bundle="${ip_labels}"/></td>
			<td class='querydata' id="PractDesc"   nowrap><%=prct_Designation%>
				<input type="hidden" name="fr_practitioner_id" id="fr_practitioner_id" value="<%=prct_Designation%>">
			</td>
			<td class="label"  ><fmt:message key="eIP.PractitionerDesignation.label" bundle="${ip_labels}"/></td>
			<td nowrap class='fileds'>
			<input type='text' name='pract_desig' id='pract_desig'  value="<%=PRACTITIONER_DESIGNATION%>" size='25' maxlength='30' readonly >
					
			</td>			
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
			<td  class='querydata' id="MedTeamDesc" ><%=frmeddesc%>
			<input type="hidden" name="fr_team_id" id="fr_team_id" value="<%=frpractteamid%>">
			</td>
			<td class="label"  ><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
			<td class='fileds' ><select name="team_id" id="team_id"  onblur='reserve_bed();'>
					<option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
<%

					String medValsql = "";
					medValsql		 = "select team_id,am_get_desc.am_medical_team(facility_id, team_id, ?,1) team_short_desc from am_pract_for_team_vw where facility_id = ? and practitioner_id =? and speciality_code = ?";

					pstmt = con.prepareStatement(medValsql);
					pstmt.setString(1,locale);
					pstmt.setString(2,facilityId);
					pstmt.setString(3,toPractId);
					pstmt.setString(4,toSplCode);
					rs1 = pstmt.executeQuery();
					if(rs1!= null)
					{
						while(rs1.next())
						{				
							medcode = rs1.getString("team_id");
							if(medcode == null) medcode="";
							meddesc = rs1.getString("team_short_desc");
							String optSelected="";
							if(medcode.equals(toMedTeam))
								optSelected="selected";
							else
								optSelected="";
							out.println("<option value=\""+medcode+"\"" +optSelected+">"+meddesc+"</option>");							
						}			
					if(rs1	!= null)   rs1.close();
					if(pstmt  != null)   pstmt.close();		
					}					
%>					
				</select>				
			</td>
		</tr>
	</table>
	<table border=0 width="100%" cellpadding='2' cellspacing=0 id='cancelreasonid' style="visibility:hidden">
	<%
	if(call_function.equals("TransferPatientIn"))
	{
		/*stmt = con.createStatement();
	    String reasonQuery = "select contact_reason_code, contact_reason from am_contact_reason_lang_vw where EFF_STATUS ='E' and cancel_transfer_yn = 'Y' and language_id='"+locale+"' order by contact_reason";
	    rset  = stmt.executeQuery(reasonQuery );*/
	%>
	
	<tr>
			<td class="label" width='25%'  onkeydown='cancelreason1();'><fmt:message key="Common.ReasonforRejection.label" bundle="${common_labels}"/></td>
			<td class='fileds' colspan='3'  <%=colspanValue%> >
			<select name='cancel_reason' id='cancel_reason'  onblur="cancelreason();">
				<option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<%--
				/*while(rset.next())
				{
					String code   = rset.getString(1) ;
					String desc   = rset.getString(2) ;								
				--%>
				 <!--<OPTION VALUE="<%--=code--%>" ><%--=desc--%></option>-->
				<%-- /*}
				if(rset	!= null)   rset.close();
				if(stmt  != null)   stmt.close();
					*/		
				--%> 
				</select>						
				<img src='../../eCommon/images/mandatory.gif' id="img_m"></img></td>
				
		</tr>
	<%}
		%>
	<!--<tr>
		
		<td  colspan=4 align=right><input type="button" class="button" name="button_s" id="button_s" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" onclick="submit_Form();"><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="cancel();" onblur="setfus();" ></td>
	</tr> -->
</table>
</tr>
</table>
	<!--10/20/2008 FS102IPSRRCRF0228V2.0-->
	<% 
	
	if(reserve_bed_on_tfr_yn.equals("Y") && call_function.equals("TransferPatientIn")) {%>
	<!--<%--if(!call_function.equals("TransferPatientIn")){--%>-->
	<table width='100%' cellpadding='2' cellspacing='0' BORDER='0'>
	<tr>
		<td colspan=4 width="100%" class="COLUMNHEADER" ><fmt:message key="eIP.ReserveBedDetails.label" bundle="${ip_labels}"/></td>
	</tr>
	<TR>
	<TD  class="label" width='25%' ><fmt:message key="eIP.ReserveBed.label" bundle="${ip_labels}"/></TD> <!--Below line modified GHL-SCF-794 [IN:047142] -->
	<TD   class="fields" colspan='3'><INPUT TYPE="checkbox" name="reserved_bed_yn" id="reserved_bed_yn"  onClick="setReserveBedDtls();" disabled <%if(!reserved_reason_code.equals("")){%>checked<%}%>><input type="hidden" name="is_reserved_bed_checked" id="is_reserved_bed_checked"  value="N"></TD>
	</TR>
	
	</table>

	<%}else if(reserve_bed_on_tfr_yn.equals("Y") && call_function.equals("TransferPatientOut")){%>

	<table width='100%' cellpadding='2' cellspacing='0' BORDER='0'>
	<tr>
		<td colspan=4 width="100%" class="COLUMNHEADER" ><fmt:message key="eIP.ReserveBedDetails.label" bundle="${ip_labels}"/></td>
	</tr>
	<TR>
	<TD  class="label" width='25%' ><fmt:message key="eIP.ReserveBed.label" bundle="${ip_labels}"/></TD>
	<TD   class="fields" colspan='3'><INPUT TYPE="checkbox" name="reserved_bed_yn" id="reserved_bed_yn" onClick="setReserveBedDtls();" <%if(!blocking_type_code.equals("")){%>checked<%}%>  ><input type="hidden" name="is_reserved_bed_checked" id="is_reserved_bed_checked"  value="N"></TD>
	</TR>
	<TR>
	<TD  class="label" width='25%' ><fmt:message key="eIP.ReasonforReserveBed.label" bundle="${ip_labels}"/></TD>
	<TD   class="fields" colspan='3'>
	<select name='reason_for_reserved_bed' id='reason_for_reserved_bed' ><option value="">-----&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;-----</option>
	<%
	/*Wednesday, May 05, 2010 , commnted for PE , query will be executed on click of setReserveBedDtls() function*/
	/*	
	try{
			
			stmt = con.createStatement();
			String sqlQuery	= " SELECT  a.BLOCKING_TYPE_CODE, IP_GET_DESC.IP_BLOCKING_TYPE(a.BLOCKING_TYPE_CODE,'"+locale+"','2') SHORT_DESC FROM IP_BLOCKING_TYPE a WHERE  a.ADDED_FACILITY_ID ='"+facilityId+"' AND a.EFF_STATUS = 'E' ORDER BY a.SHORT_DESC ";
			
			
			String reason_code="";
			String reason_desc="";
			rset = stmt.executeQuery(sqlQuery);
			if( rset != null )
				{
				  while(rset.next()){
						reason_code   = rset.getString("BLOCKING_TYPE_CODE") ;
						reason_desc  = rset.getString("SHORT_DESC") ;
						if(blocking_remarks.equals(reason_code))
							out.println("<option value=\""+reason_code+"\" selected>"+reason_desc+"</option>");
						else
							out.println("<option value=\""+reason_code+"\">"+reason_desc+"</option>");
				  }
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
				}
			}catch(Exception e) 
			{
				out.println(e.toString());
				e.printStackTrace();
			}*/
		
	%>


	</select>
	<img src='../../eCommon/images/mandatory.gif' align='center' id='reserved_bed_img' style='visibility:hidden'></img >
	</TD>
	</TR>
	</table>
	
	<%}%>
		
	
    <input type="hidden" name="locale1" id="locale1" value="<%=locale%>">  
	<input type="hidden" name="status" id="status" value="<%=status%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patientid%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterid%>">
	<input type="hidden" name="sStyle" id="sStyle" value="<%=sStyle%>">
	<input type="hidden" name="fr_team_id" id="fr_team_id" value="">
	<input type="hidden" name="prefered_date" id="prefered_date" value="">	
	<input type="hidden" name="patient_gender" id="patient_gender" value="<%=gender%>">
	<input type="hidden" name="gender" id="gender" value="<%=gender%>">
	<input type="hidden" name="age" id="age" value="<%=age%>">
	<input type="hidden" name="year" id="year" value="<%=year%>">
	<input type="hidden" name="dateofbirth" id="dateofbirth" value="<%=dateofbirth%>">
	<input type="hidden" name="DOB" id="DOB" value="<%=DOB%>">
	<input type="hidden" name="blng_serv_code" id="blng_serv_code" value="">
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>">
	<input type="hidden" name="continue_yn" id="continue_yn" value="">
	<input type="hidden" name="book_conf_yn" id="book_conf_yn" value="<%=nRec%>">
	<input type="hidden" name="book_ref_no" id="book_ref_no" value="<%= bkgRefNo%>">
	<input type="hidden" name="sysdate" id="sysdate" value="<%=sdate%>">
	<input type="hidden" name="porterage_hid" id="porterage_hid" value="<%=portBuffer.toString()%>">
	<input type='hidden' name='to_nursing_unit_locn_type' id='to_nursing_unit_locn_type' value="<%=to_nursing_unit_locn_type%>">	
	<input type="hidden" name="bed_class_allowed" id="bed_class_allowed" value="<%=change_bed_class_yn%>">
	<input type="hidden" name="change_bed_class_yn" id="change_bed_class_yn" value="">
	<input type="hidden" name="to_bed_class_code_val" id="to_bed_class_code_val" value="<%=to_bed_class_code%>">
	<input type="hidden" name="ipparam_bed_yn" id="ipparam_bed_yn" value="<%=change_bed_class_yn%>">
	<input type="hidden" name="deactivate_pseudo_bed_yn" id="deactivate_pseudo_bed_yn" value="<%=deactivate_pseudo_bed_yn%>">
	<input type="hidden" name="allow_multiple_bed_for_resv_yn" id="allow_multiple_bed_for_resv_yn" value="<%=allow_multiple_bed_for_resv_yn%>">
	<input type="hidden" name="reserve_bed_on_tfr_yn" id="reserve_bed_on_tfr_yn" value="<%=reserve_bed_on_tfr_yn%>">

	<input type="hidden" name="accomp_person" id="accomp_person" value="<%=accompPerson.toString()%>"><!--Added by Thamizh selvi on 16th May 2017 for ML-MMOH-CRF-0617-->

<%	

if(call_function.equals("TransferPatientIn"))
	{	%>
	<input type="hidden" name="booking_ref_no" id="booking_ref_no" value="<%=bkgRefNo%>">
	<input type="hidden" name="pat_check_in_allowed_yn" id="pat_check_in_allowed_yn" value="<%=pat_check_in_allowed_yn%>">
	<input type='hidden' name='to_bed_class' id='to_bed_class' value="<%=to_bed_class_code%>">
	<input type='hidden' name='call_function' id='call_function' value='Transfer_In'>
	<input type="hidden" name="mother_bed_status" id="mother_bed_status" value="<%=mother_bed_status%>">
	<input type="hidden" name="mother_status" id="mother_status" value="<%=mother_status%>"> 
	<input type="hidden" name="res_nurs_unit_code" id="res_nurs_unit_code" value="<%=reserve_nurs_unit_code%>">
	<input type="hidden" name="res_room_no" id="res_room_no" value="<%=reserve_room_no%>">
	<input type="hidden" name="res_bed_no" id="res_bed_no" value="<%=reserve_bed_no%>">
	<input type="hidden" name="reserve_nurs_unit_code" id="reserve_nurs_unit_code" value="">
	<input type="hidden" name="reserve_room_no" id="reserve_room_no" value="">
	<input type="hidden" name="reserve_bed_no" id="reserve_bed_no" value="">
	<input type="hidden" name="confirm_yn" id="confirm_yn" value="N">
	<input type="hidden" name="is_to_bed_equals_reserve_bed" id="is_to_bed_equals_reserve_bed" value="N">
	<input type="hidden" name="reserve_specialty_code" id="reserve_specialty_code" value="<%=reserve_specialty_code%>">
	<input type="hidden" name="reserve_practitioner_id" id="reserve_practitioner_id" value="<%=reserve_practitioner_id%>">
	<input type="hidden" name="reserve_bed_type_code" id="reserve_bed_type_code" value="<%=reserve_bed_type_code%>">
	<input type="hidden" name="reserve_service_code" id="reserve_service_code" value="<%=reserve_service_code%>">
	<input type="hidden" name="reserve_bed_class_code" id="reserve_bed_class_code" value="<%=reserve_bed_class_code%>">
	<input type="hidden" name="exp_discharge_date_time" id="exp_discharge_date_time" value="<%=exp_discharge_date_time%>">
	
	<%}%>
	<%if(call_function.equals("TransferPatientOut")){%>
	<input type='hidden' name='Bedcode' id='Bedcode' value="<%=to_bed_class_code%>">
	<input type='hidden' name='call_function' id='call_function' value='Transfer_Out'>
	<input type="hidden" name="mother_status" id="mother_status" value="<%=mother_status%>">
	<input type="hidden" name="mother_bed_status" id="mother_bed_status" value="">
	<%}%>
	<input type="hidden" name="to_bed_no_val" id="to_bed_no_val" value="<%=to_bed_no%>">
	<input type="hidden" name="to_room_no_val" id="to_room_no_val" value="<%=to_room_no%>">
	<input type="hidden" name="req_bed_type_code" id="req_bed_type_code" value="<%=req_bed_type_code%>">
	<input type="hidden" name="max_period" id="max_period" value="<%=max_period%>">
	<input type="hidden" name="without_booking" id="without_booking" value="">
	<input type="hidden" name="to_daily_rate" id="to_daily_rate" value="0">	
	<input type="hidden" name="transfer_date" id="transfer_date" value="">
	<input type="hidden" name="transfer_type" id="transfer_type" value="">
	<input type="hidden" name="to_subservice_desc" id="to_subservice_desc" value="<%=toSubService_Desc%>">
	<input type="hidden" name="to_subservice_code" id="to_subservice_code" value="<%=toServiceCode%>">
	<input type="hidden" name="tobedtype" id="tobedtype" value="">
	<input type="hidden" name="to_bed_type" id="to_bed_type" value="">
	<input type="hidden" name="from_daily_rate" id="from_daily_rate" value="0">
	<input type="hidden" name="transfer_status" id="transfer_status" value="">
	
	<input type="hidden" name="port_received_yn1" id="port_received_yn1" value="">
	<input type="hidden" name="received1" id="received1" value="">	
	<input type="hidden" name="port_remarks1" id="port_remarks1" value="">
	<input type="hidden" name="call_function_name" id="call_function_name" value="<%=call_function%>">
	<input type="hidden" name="oper_stn_id" id="oper_stn_id" value="<%=p_oper_stn_id%>">
	<input type="hidden" name="def_nursing_unit" id="def_nursing_unit" value="<%=toNursingUnitCode%>">
	<input type="hidden" name="frbedclass" id="frbedclass" value="<%=frbedclass%>">	
	<input type="hidden" name="bl_interface_yn" id="bl_interface_yn" value="<%=bl_interfaced_yn%>">
	<input type="hidden" name="bl_operational" id="bl_operational" value="<%=bl_operational%>">
	<input type='hidden' name='billing_group_id' id='billing_group_id' value="<%=billing_group_id%>">
	<input type='hidden' name='billing_group_desc' id='billing_group_desc' value="<%=billing_group_desc%>">
	<input type='hidden' name='modified_bed_type_code' id='modified_bed_type_code' value="<%=req_bed_type_code_by_defn%>">
	<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>">
	<input type='hidden' name='admission_date' id='admission_date' value="<%=admission_date%>">
	<input type='hidden' name='priority_status' id='priority_status' value="<%=priority%>">
	<input type='hidden' name='priority_applicable_yn' id='priority_applicable_yn' value="<%=priority_applicable_yn%>">
	<input type='hidden' name='temp_blocking_type' id='temp_blocking_type' value="<%=blocking_type%>">
	<input type='hidden' name='temp_blocking_code' id='temp_blocking_code' value="<%=blocking_code%>">	
	<input type='hidden' name='temp_block_period' id='temp_block_period' value="<%=block_period%>">	
	<input type='hidden' name='temp_blocked_until_date' id='temp_blocked_until_date' value="<%=blocked_until_date%>">
	<input type='hidden' name='temp_override_yn' id='temp_override_yn' value="<%=override_yn%>">	
	<input type='hidden' name='modified_date_val' id='modified_date_val' value="<%=modified_date_val%>">
	<input type='hidden' name='tfr_req_type' id='tfr_req_type' value="<%=tfr_req_type%>">
	<input type="hidden" name="bed_class_chk" id="bed_class_chk" value="N">
	<input type="hidden" name="tfr_req_status" id="tfr_req_status" value="<%=tfr_req_status%>">
	<input type='hidden' name='res_bed_no' id='res_bed_no' value="<%=reserved_bed%>">
	<input type='hidden' name='res_room_no' id='res_room_no' value="<%=reserved_room%>">
	<input type='hidden' name='res_nursing_unit' id='res_nursing_unit' value="<%=reserved_nursing_unit%>">
	<input type='hidden' name='r_bed_no' id='r_bed_no' value="<%=r_bed%>">
	<input type='hidden' name='r_room_no' id='r_room_no' value="<%=r_room%>">
	<input type='hidden' name='r_nursing_unit' id='r_nursing_unit' value="<%=r_nursing_unit%>">
	<input type='hidden' name='blocking_period' id='blocking_period' value="<%=blocking_period%>">
	<input type='hidden' name='r_nursing_unit_desc' id='r_nursing_unit_desc' value="<%=r_nursing_unit_desc%>">	
	<input type='hidden' name='blocking_remarks' id='blocking_remarks' value="<%=blocking_remarks%>">	
	<input type='hidden' name='reserve_reason_code' id='reserve_reason_code' value="<%=blocking_type_code%>">	
	<input type='hidden' name='pseudo_bed' id='pseudo_bed' value="<%=pseudo_bed_yn%>">	
	<input type='hidden' name='reserved_bed_cont' id='reserved_bed_cont' value="<%=reserved_bed_cont%>">	
	<input type='hidden' name='transfer_wo_delink_yn' id='transfer_wo_delink_yn' value="<%=transfer_wo_delink_yn%>">	
	
	<!--Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start-->
	<input type='hidden' name='informed_dtls_yn' id='informed_dtls_yn' value="<%=informed_dtls_mand_yn%>">
	<input type='hidden' name='autoCnrmTfrReq' id='autoCnrmTfrReq' value="<%=autoCnrmTfrReq%>">
	<!--End-->

	<!--below line added for this CRF GHL-CRF-0340 -->
	 <input type="hidden" name="specialtyCheck" id="specialtyCheck" value="0">  
     <input type="hidden" name="practitionerCheck" id="practitionerCheck" value="0"> 	 
	 <!--End GHL-CRF-0340 -->
	 
	 <input type="hidden" name="isArrivalDateAppl" id="isArrivalDateAppl" value=""> <!-- added by mujafar for ML-MMOH-CRF-1136 -->
	 <input type="hidden" name="arrival_date" id="arrival_date" value=""> <!-- added by mujafar for ML-MMOH-CRF-1136 -->
	

	<!-- <a name="addr" tabindex='0'></a>  -->
	</div>
	<div id ="Other" style = 'display:none'>

	<ul id="tablist" class="tablist">
		<li class="tablistitem" title="Occupancy Details">
			<a onclick="expandCollapse('Occupancy_Details')"  class="tabA" id="Occu_tab1" ><span class="tabAspan " id="Occup_tabspan1"><fmt:message key="eIP.OccupancyDetails.label" bundle="${ip_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Other Details">
			<a onclick="expandCollapse('other_details')" class="tabClicked" id="Oth_tab1" ><span class="tabSpanclicked " id="othe_tabspan1"><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Porterage Details">
			<a onclick="expandCollapse('porterage_details')" class="tabA" id="Port_tab1" ><span class="tabAspan" id="port_tabspan1"><fmt:message key="eIP.PorterageDetails.label" bundle="${ip_labels}"/></span>
			</a>
		</li>
	</ul>
	<jsp:include page="TransferPatientOtherDtlsTab.jsp" ><jsp:param name="flush" value="true" />
	<jsp:param name="function_name" value="<%=call_function%>" />	
	<jsp:param name="frpract_id" value="<%=frpractitionerid%>" />	
	<jsp:param name="frpract_desc" value="<%=frpractdesc%>" />	
	</jsp:include>
<!--Tuesday, June 29, 2010 , modified for PMG20089-CRF-0851-IN022285 ,frpract_id &  frpract_desc added to default Transferring Practitioner with Attending Practitioner -->
	</div>


	<div id ="Porterage" style = 'display:none'>
	<!-- <a name="tab3" tabindex='0'></a> --> 
	
	<script>
	var arguments	= document.forms[0].porterage_hid.value;
	/*
	var isShift = false;
function setShift(){
		var keyCode=window.event.keyCode;
		if(keyCode == 16) isShift=true;
	}

function shift_tab(){
		var keyCode=window.event.keyCode;
		if(keyCode == 9 && isShift == true){
		parent.frames[5].button_s.focus();
	
		}
		
	}
*/
	function reserve_bed(){
		if("<%=reserve_bed_on_tfr_yn%>"=="N")
			{
			document.forms[0].nursing_unit_desc.focus();
			}
	}

function cancelreason(){
	if("<%=reserve_bed_on_tfr_yn%>"=="N"){
if(parent.frames[1].document.forms[0].transfer_in_status.value=='02'){
parent.frames[5].button_s.focus();
}
}
}

function cancelreason1()
	{
	var keyCode=window.event.keyCode;
	var transfer_in_status =parent.frames[1].document.forms[0].transfer_in_status.value
	if(keyCode == 9 ){
			if("<%=reserve_bed_on_tfr_yn%>"=="N"){
    if(parent.frames[1].document.forms[0].transfer_in_status.value==""){
    parent.frames[5].button_s.focus();
  }
 }
 }
}
/*
function DisabledTab(obj){
	var keyCode=window.event.keyCode;
	
		if(obj.disabled==true){
			//if(keyCode == 9 ){
			
			parent.frames[5].button_s.focus();

		//}
	}
}
*/
	</script>
	<jsp:include page="PorterageDetailsTab1.jsp" ><jsp:param name="flush" value="true" />
	<jsp:param name="function_name" value="<%=call_function%>" />
	</jsp:include>
	
	</div>

<%		
		if(call_function.equals("TransferPatientOut"))
			{
	%>
				<script>
					document.forms[0].auth_date_time.value = parent.Transfer_frame.document.forms[0].pref_date.value;
		if(parent.frames[2].document.forms[0].nursing_unit_desc.value == "")
				{
				if(parent.frames[2].document.forms[0].bed_change!=null)
					parent.frames[2].document.forms[0].bed_change.disabled = true;
				}
				</script>
	<%		}

		if(stmt   != null)			stmt.close();
		if(rset	  != null)			rset.close();
		if(rs1	  != null)			rs1.close();
		if(stmt1   != null)			stmt1.close();
		if(medrs	  != null)		medrs.close();
		if(medstmt   != null)		medstmt.close();
	}catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally 
	{
		ConnectionManager.returnConnection(con,request);
	}

	%>
	 
<script>
	enabledDisabled();
	parent.frames[2].src = "../../eCommon/html/blank.html";
</script>

</form>
<script>
setDesable();
</script>
</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>


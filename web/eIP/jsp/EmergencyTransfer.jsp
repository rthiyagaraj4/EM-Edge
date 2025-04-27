<!DOCTYPE html>
<!--
	Developed by 	:	Chitra 
	Created on 	:	13/07/2001
	Module		:	ip
-->
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale				= "";
	Connection con				= null;
	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	ResultSet rset				= null;
	String billing_group_id		= "";
	String billing_group_desc	= "";
	String bl_operational		= "";
	String loginUser			= "";
	String facilityId			= "";
	bl_operational				= (String)session.getValue("bl_operational");
	loginUser					= (String)session.getValue("login_user");
	facilityId					= (String)session.getValue("facility_id");
	String admissiondesc		= "";
	StringBuffer sqlQuery		= new StringBuffer();
	
	String modified_date_val	= "";
	String frmeddesc			= "";
	String admissiondate		= "";
	String frpractitionerid		= "";
	String frpractdesc			= "";
	String frspecialitycode		= "";
	String frspecialitydesc		= "";
	String frbedclass			= "";
	String frbedclassdesc		= "";
	String frnursingunitcode	= "";
	String frnursingunitdesc	= "";
	String frbedno				= "";
	String frroomno				= "";
	String frbedtype			= "";
	String frbedtypedesc		= "";
	int    frdailycharge		= 0;
	String gender				= "";
	String age					= "";
	String frservicecode		= "";
	String frservicedesc		= "";
	String frsubservcode		= "";
	String frsubservdesc		= "";
	String patient_class		= "";
	String frmedid				= "";
	String reserve_bed_no		= "";
	String reserve_nurs_unit_code	= "";
	String reserve_room_no		= "";
	String reserve_specialty_code	= "";
	String reserve_practitioner_id  = "";
	String reserve_bed_type_code	= "";
	String reserve_service_code		= "";
	String reserve_bed_class_code	= "";
	int BED_BLOCK_PERIOD_MAX	= 0;
	//String BED_BLOCK_PERIOD_MAX	="";
	int req_count				= 0;
	int tfr_req_count			= 0;
	int mother_status			= 0;
	int reserved_bed_cont		= 0;
	String admissiondate_converted = "";
	String d_converted			= "";

	String isreadonly			= "";
	String isenable				= "";
	String exp_discharge_date_time	    = "";
	String pseudo_bed_yn	    = "";
	String func_id				= "";
	String patientid			= "";
	String req_count_str		= "";
	String tfr_req_count_str	= "";
	String p_oper_stn_id		= "";
	String eid					= "";
	String d					= "";
	String min					= "";
	String admissiontype		= "";

	String change_bed_class_yn		= "";

	String entitlement_by_pat_cat_yn		= "";
	java.text.SimpleDateFormat dateFormat	= null ;
	java.util.Date dt						= null ;

	locale						= (String)session.getAttribute("LOCALE");
	try
	{
		func_id					= checkForNull(request.getParameter("func_id"));
		
		if(func_id!=null && func_id.equals("MODIFY_SERVICE_INPATIENT"))
		{
			isreadonly			= "ReadOnly";
			isenable			= "Disabled";
		}
		
		patientid				= checkForNull(request.getParameter("patient_id"));

		req_count_str			= checkForNull(request.getParameter("bed_class_req_cnt"));
		if(!req_count_str.equals(""))
			req_count			= Integer.parseInt(req_count_str);
		tfr_req_count_str		= checkForNull(request.getParameter("trans_req_cnt"));
		if(!tfr_req_count_str.equals(""))
			tfr_req_count		= Integer.parseInt(tfr_req_count_str);
	
		String sdate				= "";
		String install_yn			= "";
		String bedBlock_normal		= "";
		String max_blk_type			= "";
		String deact_pseudo_bed		= "";
		String ch_bed_class_param	= "";
		String reserve_bed_on_tfr_yn= "";
		String res_reserve_bed_intraward_yn= "";//Mahesh
		String transfer_wo_delink_yn= "";//Added for the CRF - HSA-CRF-0035
		String bed_blk_period_max	= "";
		String MAX_TRN_DATE_TIME    = "";
		String year					= "";
		p_oper_stn_id				= checkForNull(request.getParameter("oper_stn_id"));
		eid							= checkForNull(request.getParameter("encounter_id"));
		long    encounterid			= Long.parseLong(eid);
		
		install_yn					= checkForNull(request.getParameter("bl_interfaced_yn"),"N");
		bedBlock_normal				= checkForNull(request.getParameter("bed_block_period_normal"));
		bed_blk_period_max			= checkForNull(request.getParameter("bed_block_period_max"));
		BED_BLOCK_PERIOD_MAX		= Integer.parseInt(bed_blk_period_max);
		max_blk_type				= checkForNull(request.getParameter("bed_block_period_max_type"));
		if(max_blk_type.equals("D"))
				BED_BLOCK_PERIOD_MAX=(BED_BLOCK_PERIOD_MAX)*24;
		deact_pseudo_bed			= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
		ch_bed_class_param			= checkForNull(request.getParameter("change_bed_class_yn"),"N");
		reserve_bed_on_tfr_yn		= checkForNull(request.getParameter("reserve_bed_on_tfr_yn"),"N");
		res_reserve_bed_intraward_yn		= checkForNull(request.getParameter("res_reserve_bed_intraward_yn"),"N");//Mahesh
		//Added for the CRF - HSA- CRF-0035 -- Begin
		transfer_wo_delink_yn		= checkForNull(request.getParameter("transfer_wo_delink_yn"),"N");
		if(transfer_wo_delink_yn.equals(""))
			transfer_wo_delink_yn="N";
		//Added for the CRF - HSA- CRF-0035 -- End
		session.putValue("patientid",patientid);
		session.putValue("encounter_id",eid);
		con							= ConnectionManager.getConnection(request);
		stmt						= con.createStatement();	
		/*Thursday, April 29, 2010 , commented for PE getting data from InpatientLookupQueryResult.jsp*/
		/*
		sqlQuery.append(" select nvl(bl_interfaced_yn,'N') bl_interfaced_yn, bed_block_period_max, bed_block_period_max_type, bed_block_period_normal, deactivate_pseudo_bed_yn, change_bed_class_yn, reserve_bed_on_tfr_yn, to_char(sysdate,'dd/mm/rrrr hh24:mi')sdate  from IP_PARAM where facility_id = '"+facilityId+"' ");
		
		try
		{
			rset	=stmt.executeQuery(sqlQuery.toString());
			if(rset.next())
			{
				
				sdate					= rset.getString("sdate");
				install_yn				= rset.getString("bl_interfaced_yn");
				bedBlock_normal			= rset.getString("bed_block_period_normal");
				BED_BLOCK_PERIOD_MAX	= rset.getInt("BED_BLOCK_PERIOD_MAX");
				max_blk_type			= rset.getString("BED_BLOCK_PERIOD_MAX_TYPE");
				deact_pseudo_bed		= rset.getString("deactivate_pseudo_bed_yn");
				ch_bed_class_param		= rset.getString("CHANGE_BED_CLASS_YN");

				reserve_bed_on_tfr_yn	= rset.getString("reserve_bed_on_tfr_yn");
				if(reserve_bed_on_tfr_yn == null) reserve_bed_on_tfr_yn = "N";
				if(max_blk_type.equals("D"))
					BED_BLOCK_PERIOD_MAX=(BED_BLOCK_PERIOD_MAX)*24;
			}
			if(rset!=null)rset.close();
			//if(stmt!=null)stmt.close();
			
		//added by kishore on 8/21/2004
		}
		catch(Exception e)
		{
			out.println("Exception @try1"+e.toString());
			e.printStackTrace();
		}
		/*Thursday, April 29, 2010 , commendted for PE , merged with main query*/
		/*modified for 12/15/2008 6021  MF-SCF-0051
		try{
		
		String trn_date = "SELECT to_char(MAX(TRN_DATE_TIME),'dd/mm/rrrr hh24:mi'), to_char(sysdate,'dd/mm/rrrr hh24:mi')sdate  FROM IP_ADT_TRN WHERE FACILITY_ID = '"+facilityId+"' AND ENCOUNTER_ID = '"+eid+"'";
		rset	=stmt.executeQuery(trn_date.toString());
			if(rset != null){
				if(rset.next()){
					MAX_TRN_DATE_TIME = rset.getString(1);
					sdate			= rset.getString(2);
				}
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
			
		}
		catch(Exception ex){
			out.println("Exception"+ex);
			ex.printStackTrace();
				}

MAX_TRN_DATE_TIME = DateUtils.convertDate(MAX_TRN_DATE_TIME,"DMYHM","en",locale);
*/


		
%>
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../js/EmergencyTransfer.js" language="javascript"></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/DateUtils.js" language="JavaScript"></Script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<script>

function validateBackDate(tfrDate)
{
	var max_trn_date_time = document.forms[0].max_trn_date_time.value;
	if (tfrDate.value != ""  || tfrDate.value != '')
	{
		if(!validDateObj(tfrDate,"DMYHM",localeName))
		{
			return ;
		}
		var greg_tfrDateTime = convertDate(tfrDate.value,'DMYHM',localeName,'en');
		var greg_maxtfrDateTime = convertDate(max_trn_date_time,'DMYHM',localeName,'en');

		if(!isBefore(document.forms[0].admission_date.value,greg_tfrDateTime,'DMYHM','en'))
		{
			var error = getMessage('DATE1_LT_DATE2','IP');
		/* 17956 Thursday, January 07, 2010*/
			error = error.replace('$',getLabel("Common.transferdate.label",'Common')+"/"+getLabel("Common.time.label",'Common'));
			error = error.replace('#',getLabel("Common.AdmissionDateTime.label",'Common'));
			alert(error);
			tfrDate.select();
		}
		//else if(isBefore(document.forms[0].sdate.value,greg_tfrDateTime,'DMYHM','en'))
		/* 17956 Thursday, January 07, 2010*/
		else if(!isBeforeNow(greg_tfrDateTime,'DMYHM','en'))
		{
			var error = getMessage('DATE1_GT_DATE2','IP');
			/* 17956 Thursday, January 07, 2010*/
			error = error.replace('$',getLabel("Common.transferdate.label",'Common')+"/"+getLabel("Common.time.label",'Common'));
			error = error.replace('#',getLabel("Common.SystemDateTime.label",'Common'));
			alert(error);
			tfrDate.select();
		}//modified for 12/15/2008 6021  MF-SCF-0051
		else if(!isBefore(greg_maxtfrDateTime,convertDate(document.forms[0].transfer_date.value,'DMYHM',localeName,'en'),'DMYHM','en')){
			
			var error = getMessage('DATE1_LT_DATE2','IP');
			//var last_encounter = getLabel("Common.Last.label","Common")+" "+getLabel("Common.encounterdate.label","Common");
			/*Monday, December 06, 2010 , SRR20056-SCF-6173 [IN:025371]*/
			var last_encounter = getLabel("eIP.LastTransactionDateTime.label","ip_labels");
			error = error.replace('$',getLabel("Common.transferdate.label",'Common')+"/"+getLabel("Common.time.label",'Common'));
			error = error.replace('#',last_encounter);
			alert(error);
			tfrDate.select();
		}//
	}
}

function checkform()
{
<%	if(req_count > 0)
	{	%>
		var error	= getMessage('ONLY_ONE_REQ_BKG','IP');
		error		= error.replace('$',getLabel("eIP.RequestTransfer.label",'IP'));
		alert(error);	
		window.close();
<%	}
	else
	{	
		if (tfr_req_count > 0)
		{	%>
			var error = getMessage('ONLY_ONE_REQ_BKG','IP');
			error = error.replace('$',getLabel("eIP.RequestTransfer.label",'IP'));
			alert(error);	
			window.close();

	<%	}	
	}	%>
	
	var mother_status = document.forms[0].mother_status.value;
	var transfer_wo_delink_yn = document.forms[0].transfer_wo_delink_yn.value;//Added for the CRF HSA-CRF-0035	
	if (mother_status != '0' ) 
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
		}
	}
	else
		document.forms[0].mother_bed_status.value='N';
}
</script>
</head>


<body onload='checkform();focusFirst();setDesable_tfrDtls();getOnload_tfrDtls();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
			
			dateFormat								= new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
			dt										= new java.util.Date();
			d										= dateFormat.format( dt ) ;
			min										= String.valueOf(dt.getMinutes()) ;
            if(min.length() == 1)   min = "0"+min ;

			d=d + " "+String.valueOf(dt.getHours())+":"+min;

			if(!(d==null || d.equals("")))
				d_converted = DateUtils.convertDate(d,"DMYHM","en",locale);
			
			/* Commented and merged with below query for PE - 11/05/2010
			if(reserve_bed_on_tfr_yn.equals("Y"))
			{
				if(sqlQuery.length()>0)	sqlQuery.delete(0,sqlQuery.length());
				sqlQuery.append(" SELECT " );
				sqlQuery.append(" a.RESERVED_NURS_UNIT_CODE ");
				sqlQuery.append(" ,a.RESERVED_ROOM_NO ");
				sqlQuery.append(" ,a.RESERVED_BED_NO ");
				sqlQuery.append(" ,a.SPECIALTY_CODE ");
				sqlQuery.append(" ,a.ADMIT_PRACTITIONER_ID ");
				sqlQuery.append(" ,a.BED_TYPE_CODE ");
				sqlQuery.append(" ,a.SERVICE_CODE ");
				sqlQuery.append(" ,a.BED_CLASS_CODE ");
				sqlQuery.append(" FROM ");
				sqlQuery.append(" IP_OPEN_ENCOUNTER  a, ");
				sqlQuery.append(" IP_RESERVED_BED_DTL b ");
				sqlQuery.append(" WHERE a.facility_id = '"+facilityId+"' ");
				sqlQuery.append(" AND a.facility_id = b.facility_id ");
				sqlQuery.append(" AND a.encounter_id = '"+encounterid+"' ");
				sqlQuery.append(" AND a.encounter_id = b.encounter_id ");
				sqlQuery.append(" AND a.RESERVED_NURS_UNIT_CODE = b.RESERVED_NURSING_UNIT_CODE ");
				sqlQuery.append(" AND a.RESERVED_BED_NO =  b.RESERVED_BED_NO ");
				sqlQuery.append(" AND b.RESERVED_TO_TIME IS null ");

				stmt = con.createStatement() ;
				rset = stmt.executeQuery(sqlQuery.toString()) ;
				if(rset != null && rset.next())
				{
					reserve_nurs_unit_code			= checkForNull(rset.getString("RESERVED_NURS_UNIT_CODE"));
					reserve_room_no					= checkForNull(rset.getString("RESERVED_ROOM_NO"));
					reserve_bed_no					= checkForNull(rset.getString("RESERVED_BED_NO"));
					reserve_specialty_code			= checkForNull(rset.getString("SPECIALTY_CODE"));
					reserve_practitioner_id			= checkForNull(rset.getString("ADMIT_PRACTITIONER_ID"));
					reserve_bed_type_code			= checkForNull(rset.getString("BED_TYPE_CODE"));
					reserve_service_code			= checkForNull(rset.getString("SERVICE_CODE"));
					reserve_bed_class_code			= checkForNull(rset.getString("BED_CLASS_CODE"));
				}

				if(rset!=null)rset.close();
				if(stmt!=null)stmt.close();

			
			} */
	


			if(sqlQuery.length()>0)	sqlQuery.delete(0,sqlQuery.length());

		
			sqlQuery.append("SELECT" );
			sqlQuery.append("  TO_CHAR(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date" );
			sqlQuery.append("  ,a.admission_type" );
			sqlQuery.append("  ,IP_GET_DESC.IP_ADMISSION_TYPE(a.ADMISSION_TYPE,'"+locale+"','2') admission_short_desc" );
			sqlQuery.append("  ,a.nursing_unit_code" );
			sqlQuery.append("  , IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.NURSING_UNIT_CODE,'"+locale+"','2') nursing_unit_short_desc" );
			sqlQuery.append("  , a.specialty_code" );
			sqlQuery.append("  ,AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+locale+"','2') specialty_short_desc" );
			sqlQuery.append("  ,a.attend_practitioner_id practitioner_id" );
			sqlQuery.append("  ,AM_GET_DESC.AM_PRACTITIONER(a.attend_PRACTITIONER_ID,'"+locale+"','1') practitioner_name" );
			sqlQuery.append("  ,a.room_num room_no" );
			sqlQuery.append("  ,a.bed_num bed_no" );
			sqlQuery.append("  ,a.bed_class_code" );
			sqlQuery.append("  ,IP_GET_DESC.IP_BED_CLASS(a.bed_class_code,'"+locale+"','2') bed_class_short_desc" );
			sqlQuery.append("  , null dly_charge" );
			sqlQuery.append("  ,a.bed_type_code" );
			sqlQuery.append("  ,IP_GET_DESC.IP_BED_TYPE(a.bed_type_code,'"+locale+"','2') BED_TYPE_SHORT_DESC" );
			sqlQuery.append("  ,b.sex gender" );
			sqlQuery.append("  ,TO_CHAR (b.date_of_birth, 'dd/mm/rrrr') date_of_birth" );
			sqlQuery.append("  , a.service_code" );
			sqlQuery.append("  , AM_GET_DESC.AM_SERVICE(a.service_code,'"+locale+"','2') service_short_desc" );
			sqlQuery.append("  ,a.SUBSERVICE_CODE" );
			sqlQuery.append("  ,AM_GET_DESC.AM_SUBSERVICE(a.service_code, a.SUBSERVICE_CODE,'"+locale+"','2') SUBSERVICE_SHORT_DESC" );
			sqlQuery.append("  , a.PATIENT_CLASS" );
			sqlQuery.append("  ,Am_Get_desc.AM_MEDICAL_TEAM(a.Facility_Id, a.Team_Id,'"+locale+"','2') TEAM_DESC" );
			sqlQuery.append("  ,a.TEAM_ID " );
			sqlQuery.append("  ,to_char(a.modified_date,'dd/mm/rrrr hh24:mi') modified_date " );
			sqlQuery.append("  ,to_char(a.exp_discharge_date_time,'dd/mm/rrrr hh24:MI') exp_discharge_date_time " );
			/*Thursday, April 29, 2010 added for PE*/
			sqlQuery.append("  ,(select bed_class_change_yn from am_os_user_locn_access_vw where facility_id = a.facility_id and oper_stn_id = '"+p_oper_stn_id+"' and appl_user_id = '"+loginUser+"' and  LOCN_CODE=a.nursing_unit_code and locn_type = 'N') bed_class_change_yn " );
			sqlQuery.append("  ,(select count(*) m_status from ip_nursing_unit_bed where  occupying_patient_id is not null and facility_id = a.facility_id and  nursing_unit_code = a.nursing_unit_code and main_bed_no = a.bed_num) m_status " );
			/*Monday, September 13, 2010 , SRR20056-SCF-5155 [IN:023680]*/
			sqlQuery.append("  ,(select pseudo_bed_yn from ip_nursing_unit_bed where  facility_id = a.facility_id and  nursing_unit_code = a.nursing_unit_code and bed_no = a.bed_num) pseudo_bed_yn " );
			sqlQuery.append("  ,to_char(sysdate,'dd/mm/rrrr hh24:mi')sdate " );
			sqlQuery.append("  ,(SELECT to_char(MAX(TRN_DATE_TIME),'dd/mm/rrrr hh24:mi') FROM IP_ADT_TRN WHERE FACILITY_ID = a.facility_id AND ENCOUNTER_ID = a.encounter_id) TRN_DATE_TIME " );
			sqlQuery.append("  ,(select entitlement_by_pat_cat_yn from MP_PARAM where module_id = 'MP')entitlement_by_pat_cat_yn " );
			sqlQuery.append("  ,calculate_age(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),1)year " );
			if(reserve_bed_on_tfr_yn.equals("Y"))
			{
				sqlQuery.append(" ,a.RESERVED_NURS_UNIT_CODE ");
				sqlQuery.append(" ,a.RESERVED_ROOM_NO ");
				sqlQuery.append(" ,a.RESERVED_BED_NO ");
				sqlQuery.append(" ,a.SPECIALTY_CODE ");
				sqlQuery.append(" ,a.ADMIT_PRACTITIONER_ID ");
				sqlQuery.append(" ,a.BED_TYPE_CODE ");
				sqlQuery.append(" ,a.SERVICE_CODE ");
				sqlQuery.append(" ,a.BED_CLASS_CODE ");
				/*Monday, October 04, 2010 ,if EDD is less than current sysdate and if any bed was reserved before current sysdate and was not released from Release Bed function , reserved bed details will not be available because of condition  blocked_until_date_time > SYSDATE but IP_RESERVED_BED_DTL table having reserved bed data*/
				sqlQuery.append(" ,(SELECT COUNT(1) FROM ip_bed_booking WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id AND booking_type = 'N' AND (blocked_until_date_time IS NULL OR blocked_until_date_time > SYSDATE) ) reserved_bed_cont ");
			}	
			sqlQuery.append("FROM" );
			sqlQuery.append("  IP_OPEN_ENCOUNTER a, mp_patient b " );
			if(reserve_bed_on_tfr_yn.equals("Y")){
				sqlQuery.append("  , IP_RESERVED_BED_DTL c " );
			}
			sqlQuery.append("WHERE a.facility_id = '"+facilityId+"' " );
			sqlQuery.append("  AND a.encounter_id = '"+encounterid+"' and a.patient_id = b.patient_id" );
			if(reserve_bed_on_tfr_yn.equals("Y")){
				sqlQuery.append(" AND a.facility_id = c.facility_id(+) ");
				sqlQuery.append(" AND a.encounter_id = c.encounter_id(+) ");
				sqlQuery.append(" AND a.RESERVED_NURS_UNIT_CODE = c.RESERVED_NURSING_UNIT_CODE(+) ");
				sqlQuery.append(" AND a.RESERVED_BED_NO =  c.RESERVED_BED_NO(+) ");
				sqlQuery.append(" AND c.RESERVED_TO_TIME(+) IS null ");
			}
			stmt = con.createStatement() ;

			rset = stmt.executeQuery(sqlQuery.toString()) ;
			if(rset != null && rset.next())
			{
				modified_date_val	= checkForNull(rset.getString("modified_date"));
				admissiondate		= checkForNull(rset.getString("admission_date"));
				if(!(admissiondate.equals("") || admissiondate == null))
						admissiondate_converted = DateUtils.convertDate(admissiondate,"DMYHM","en",locale); 
				admissiontype		= checkForNull(rset.getString("admission_type"));
				admissiondesc		= checkForNull(rset.getString("admission_short_desc"));
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
				frbedtypedesc		= checkForNull(rset.getString("BED_TYPE_SHORT_DESC"));
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
				change_bed_class_yn = checkForNull(rset.getString("bed_class_change_yn"),"N");
				mother_status		= rset.getInt("m_status");
				MAX_TRN_DATE_TIME	= rset.getString("TRN_DATE_TIME");
				entitlement_by_pat_cat_yn = checkForNull(rset.getString("entitlement_by_pat_cat_yn"),"N");
				year				= checkForNull(rset.getString("year"));
				sdate				= rset.getString("sdate");
				exp_discharge_date_time     = checkForNull(rset.getString("exp_discharge_date_time"));
				pseudo_bed_yn		= checkForNull(rset.getString("pseudo_bed_yn"),"N");
				if(reserve_bed_on_tfr_yn.equals("Y")){
					reserve_nurs_unit_code			= checkForNull(rset.getString("RESERVED_NURS_UNIT_CODE"));
					reserve_room_no					= checkForNull(rset.getString("RESERVED_ROOM_NO"));
					reserve_bed_no					= checkForNull(rset.getString("RESERVED_BED_NO"));
					reserve_specialty_code			= checkForNull(rset.getString("SPECIALTY_CODE"));
					reserve_practitioner_id			= checkForNull(rset.getString("ADMIT_PRACTITIONER_ID"));
					reserve_bed_type_code			= checkForNull(rset.getString("BED_TYPE_CODE"));
					reserve_service_code			= checkForNull(rset.getString("SERVICE_CODE"));
					reserve_bed_class_code			= checkForNull(rset.getString("BED_CLASS_CODE"));
					reserved_bed_cont				= rset.getInt("reserved_bed_cont");
				}			
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
			MAX_TRN_DATE_TIME		= DateUtils.convertDate(MAX_TRN_DATE_TIME,"DMYHM","en",locale);
			if(bl_operational.equals("Y"))
			{
				if(sqlQuery.length()>0)	sqlQuery.delete(0,sqlQuery.length());
				sqlQuery.append("select a. BLNG_GRP_ID, a.SHORT_DESC from bl_blng_grp a, BL_EPISODE_FIN_DTLS b where a.BLNG_GRP_ID = b.BLNG_GRP_ID and b.OPERATING_FACILITY_ID ='"+facilityId+"' and b.EPISODE_ID = '"+eid+"'");

				if(patient_class.equals("IP"))
				{
					sqlQuery.append(" and b.EPISODE_TYPE = 'I' ");
				}
				else if(patient_class.equals("DC"))
				{
					sqlQuery.append(" and b.EPISODE_TYPE = 'D' ");
				}

				stmt = con.createStatement();
				rset = stmt.executeQuery(sqlQuery.toString());

				while(rset.next())
				{
					billing_group_id	= checkForNull(rset.getString("BLNG_GRP_ID"));
					billing_group_desc	= checkForNull(rset.getString("SHORT_DESC"));
				}
				if(rset!=null)rset.close();
				if(stmt!=null)stmt.close();
			}	
			/*Thursday, April 29, 2010 , commented for PE merged in main query*/
			/*
			if(gender.equals("F"))
			{
				//Added by kishore on 9/24/2004 for check newborn function
				
				if(sqlQuery.length()>0)	sqlQuery.delete(0,sqlQuery.length());
				sqlQuery.append("select count(*) m_status from ip_nursing_unit_bed where  occupying_patient_id is not null and facility_id = '"+facilityId+"' and  nursing_unit_code = '"+frnursingunitcode+"' and main_bed_no = '"+frbedno+"' ");
				stmt = con.createStatement(); 
				rset = stmt.executeQuery(sqlQuery.toString());
				if(rset != null)
				{
					if(rset.next())
					{
						mother_status = rset.getInt("m_status");
					}
					
				}
				if(rset!=null)rset.close();
				if(stmt!=null)stmt.close();
			}
		
		//SQL For change_bed_class_yn value
			if(sqlQuery.length()>0)	sqlQuery.delete(0,sqlQuery.length());
			sqlQuery.append("select bed_class_change_yn from am_os_user_locn_access_vw where facility_id = '"+facilityId+"' and oper_stn_id = '"+p_oper_stn_id+"' and appl_user_id = '"+loginUser+"' and  LOCN_CODE='"+frnursingunitcode+"'");
			stmt = con.createStatement();
			rset = stmt.executeQuery(sqlQuery.toString());

			if (rset != null && rset.next())
			 change_bed_class_yn = checkForNull(rset.getString("bed_class_change_yn"));
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
		//Ended Here
		*/
	
%>
	<form name="EmergencyTransfer_form" id="EmergencyTransfer_form"  method="post" <% if(func_id!=null && func_id.equals("MODIFY_SERVICE_INPATIENT")){%> action="../../servlet/eIP.ModifyServiceServlet" <%}else{%> action="../../servlet/eIP.EmergencyTransferServlet"  <%}%>target="parent.frames[1]">
	<table border=0 width="100%" cellpadding=2 cellspacing=0>
	<%
		//if(install_yn.equals("N"))
		//{%>
		<!-- <br><br><br> -->
		<%//}
	%>
		<!-- <tr><td class='BLANKROW1PT' colspan=4></td></tr> -->
		<tr><!-- 17956 Thursday, January 07, 2010 -->
			<td  class="label" width='25%'><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></td>
			 <td  class='querydata' width='24%'><input type="hidden" name="admission_date" id="admission_date" value="<%=admissiondate%>"  ><%=admissiondate_converted%></td>
			<td  class="label" width='24%'><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
			<td  class='querydata' width='28%'><input type="hidden" name="admission_type" id="admission_type" value="<%=admissiontype%>" ><%=admissiondesc%></td> 
		</tr>
		<tr><!-- 17956 Thursday, January 07, 2010 -->
			<td  class="label" width='23%'><fmt:message key="Common.transferdate.label" bundle="${common_labels}"/>/<fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
			
			<!-- <td class='querydata' width='24%' ><input type="hidden" name="transfer_date" id="transfer_date"  value="<%=d%>"> <%=d_converted%> </td> -->

		<td class='fields'><input type=text name='transfer_date' id='transfer_date' value="<%=d_converted%>" id='transfer_date_id' maxlength="16" size="16" onBlur="validateBackDate(this);" onKeyPress='return(ChkNumberInput(this,event,2));'  <%=isreadonly%> <%=isenable%>><img src='../../eCommon/images/CommonCalendar.gif' id='ondate1'  onClick="document.forms[0].transfer_date.select();return showCalendar('transfer_date_id',null,'hh:mm');" />
		<%
			if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
			{
		%>
			<img src="../../eCommon/images/mandatory.gif"></img>
		<%
			}
		%>
		</td>
			<td  class="label" width='26%'><fmt:message key="eIP.ReasonforTransfer.label" bundle="${ip_labels}"/></td>
			<td  width='28%'>
				<select name="transfer_type" id="transfer_type" onChange="getBlockBedDate();" <%=isreadonly%> <%=isenable%>>
					<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----
					<%
							
							if(sqlQuery.length()>0)	sqlQuery.delete(0,sqlQuery.length());
							//sqlQuery.append("select a.short_desc, a.transfer_type_code||'='|| a.blocking_type_code || '=' ||b.short_desc ||'='|| decode(b.DFLT_BLOCK_UNITS, 'H', DFLT_MIN_BLOCK_PERIOD, 'D', DFLT_MIN_BLOCK_PERIOD*24)   ||'='|| to_char(sysdate+(decode(b.DFLT_BLOCK_UNITS, 'H', DFLT_MIN_BLOCK_PERIOD, 'D', DFLT_MIN_BLOCK_PERIOD*24)/24), 'dd/mm/rrrr hh24:mi') || '='||b.DFLT_BLOCK_UNITS||'='|| override_yn ||'='||('"+bedBlock_normal+"') default_block_period from ip_transfer_type_lang_vw a, ip_blocking_type_lang_vw b where a.language_id='"+locale+"' and a.language_id=b.language_id(+) and a.blocking_type_code=b.BLOCKING_TYPE_CODE(+)  AND A.EFF_STATUS ='E' ORDER BY 1");
							/*Thursday, April 29, 2010 , modified for PE*/
							sqlQuery.append("select ip_get_desc.ip_transfer_type (a.transfer_type_code,?,2) short_desc, a.transfer_type_code||'='|| a.blocking_type_code || '=' || ip_get_desc.IP_BLOCKING_TYPE(b.blocking_type_code,?,'2') ||'='|| decode(b.DFLT_BLOCK_UNITS, 'H', DFLT_MIN_BLOCK_PERIOD, 'D', DFLT_MIN_BLOCK_PERIOD*24)   ||'='|| to_char(sysdate+(decode(b.DFLT_BLOCK_UNITS, 'H', DFLT_MIN_BLOCK_PERIOD, 'D', DFLT_MIN_BLOCK_PERIOD*24)/24), 'dd/mm/rrrr hh24:mi') || '='||b.DFLT_BLOCK_UNITS||'='|| override_yn ||'='||(?) default_block_period from ip_transfer_type a, ip_blocking_type b where a.blocking_type_code=b.BLOCKING_TYPE_CODE(+)   and a.TRANSFER_TYPE_CODE like '%%' and A.EFF_STATUS ='E' ORDER BY 1");

							pstmt = con.prepareStatement(sqlQuery.toString());
							pstmt.setString(1,locale);
							pstmt.setString(2,locale);
							pstmt.setString(3,bedBlock_normal);
							rset=pstmt.executeQuery();

							String desc		= "";
							String code		= "";
							while(rset.next())
							{
								desc		= rset.getString("short_desc");
								code		= rset.getString("DEFAULT_BLOCK_PERIOD");

								out.println("<option value=\""+code+"\" >"+desc );
							}
							if(rset!=null)rset.close();
							if(pstmt!=null)pstmt.close();
					%>
				</select>
				<%%>
				<%
						if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
						{
				%>
							<img align="center" src="../../eCommon/images/mandatory.gif">
				<%
						}
				%>
				<input type="hidden" name="transfer_type_code" id="transfer_type_code"  value="">
			</td>
		</tr>
		</table>
	<jsp:include page="../../eIP/jsp/TransferDetails.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name ="call_function"  value="Transfer_patient" />
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
		<jsp:param name ="BED_BLOCK_PERIOD_MAX"  value="<%=BED_BLOCK_PERIOD_MAX%>" />
		<jsp:param name ="max_blk_type"  value="<%=max_blk_type%>" />
		<jsp:param name ="deact_pseudo_bed"  value="<%=deact_pseudo_bed%>" />
		<jsp:param name ="ch_bed_class_param"  value="<%=ch_bed_class_param%>" />
		<jsp:param name ="func_id"  value="<%=func_id%>" />

	</jsp:include>
	
	<table border=0 width="100%" cellpadding=2 cellspacing=0>
	<%
		if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
		{
	%>
	<tr><td colspan=4></td></tr>
		<tr>
		<td colspan=4 width="100%" class="COLUMNHEADER"><fmt:message key="eIP.BedBlockDetails.label" bundle="${ip_labels}"/></td>
	</tr>
		</table>
	<jsp:include page="../../eIP/jsp/BlockingDetails.jsp" ><jsp:param name="flush" value="true" />
	<jsp:param name ="called_from"  value="tfr_patient" />
	</jsp:include>
	<!--
	<table width='100%' cellpadding='2' cellspacing='0' BORDER='0'>
	
	
		<% if(install_yn.equals("Y")) {%><tr><td><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Compute.label","common_labels")%>" onclick="ComputeBlDtl();"><td></tr> <%}%>
	</table>-->
	<table width='100%' cellpadding='2' cellspacing='0' BORDER='0'>
	<% if(reserve_bed_on_tfr_yn.equals("Y")) {%>
	<tr>
		<td colspan=4 width="100%" class="COLUMNHEADER"><fmt:message key="eIP.ReserveBedDetails.label" bundle="${ip_labels}"/></td>
	</tr>
	<TR>
	<TD  class="label" width='25%'><fmt:message key="eIP.ReserveBed.label" bundle="${ip_labels}"/></TD>
	<TD   class="fields" colspan='3'><INPUT TYPE="checkbox" name="reserved_bed_yn" id="reserved_bed_yn" onClick="setReserveBedDtls();" <%if(res_reserve_bed_intraward_yn.equals("Y")){%> disabled<%}%>><input type="hidden" name="is_reserved_bed_checked" id="is_reserved_bed_checked"  value="N" ></TD>
	</TR>
	<TR>
	<TD  class="label" width='25%'><fmt:message key="eIP.ReasonforReserveBed.label" bundle="${ip_labels}"/></TD>
	<TD   class="fields" colspan='3'>
	<select name='reason_for_reserved_bed' id='reason_for_reserved_bed' ><option value="">-----&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;-----</option>
	<%
		/*try{
			
			if(sqlQuery.length() > 0 ) sqlQuery.delete(0,sqlQuery.length());
				sqlQuery.append(" SELECT  a.BLOCKING_TYPE_CODE, IP_GET_DESC.IP_BLOCKING_TYPE(a.BLOCKING_TYPE_CODE,?,'2') SHORT_DESC FROM IP_BLOCKING_TYPE a WHERE  a.ADDED_FACILITY_ID =? AND a.EFF_STATUS = 'E' ORDER BY a.SHORT_DESC ");
			
			pstmt = con.prepareStatement(sqlQuery.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,facilityId);
			rset = pstmt.executeQuery();
			if( rset != null )
				{
				  while( rset.next() )
				  {
						reason_code   = rset.getString("BLOCKING_TYPE_CODE") ;
						reason_desc  = rset.getString("SHORT_DESC") ;
						out.println("<option value=\""+reason_code+"\">"+reason_desc+"</option>");
				  }
				
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				}
			}catch(Exception e) {out.println(e.toString());e.printStackTrace();}*/
		
	%>


	</select>
	<img src='../../eCommon/images/mandatory.gif' align='center' id='reserved_bed_img' style='visibility:hidden'></img >
	</TD>
	</TR>
	<%}%>
	<%
		}
	%>
	 <tr>
		<td class='label' width='25%'></td>
		<td align='right' colspan='3'>
		<input type="button" class="button" name="transfer" id="transfer" <% if(func_id!=null && func_id.equals("MODIFY_SERVICE_INPATIENT")) {%>value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" <%}else{%> value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transfer.label","common_labels")%>" <%}%> onclick="submitForm_em();"><input type="button" class="button"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="cancel();"></td>
	</tr>
	
	</table>	
		<!-- Added By Dharma on 16th Jan 2020 against AMRI-CRF-0362.1 Start -->
		<input type = 'hidden' name = 'bl_adm_remarks' id = 'bl_adm_remarks' value="">
		<input type = 'hidden' name = 'bl_bed_request' id = 'bl_bed_request' value="">
		<input type = 'hidden' name = 'bl_bed_type_code' id = 'bl_bed_type_code' value="">
		<!-- Added By Dharma on 16th Jan 2020 against AMRI-CRF-0362.1 End -->
			
		<input type="hidden" name="sdate" id="sdate" value="<%=sdate%>">
		<input type="hidden" name="modified_date_val" id="modified_date_val" value="<%=modified_date_val%>">
		<input type="hidden" name="max_trn_date_time" id="max_trn_date_time" value="<%=MAX_TRN_DATE_TIME%>">
		<input type="hidden" name="sStyle" id="sStyle" value="<%=sStyle%>">
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patientid%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterid%>">
		<input type="hidden" name="encounter_id1" id="encounter_id1" value="<%=encounterid%>">
		<input type="hidden" name="fr_bed_type" id="fr_bed_type" value="<%=frbedtype%>">
		<input type="hidden" name="fr_bed_type1" id="fr_bed_type1" value="<%=frbedtype%>">
		<input type='hidden' name='modified_bed_type_code' id='modified_bed_type_code' value=''>
		<input type='hidden' name='billing_group_id' id='billing_group_id' value="<%=billing_group_id%>">
		<input type='hidden' name='billing_group_desc' id='billing_group_desc' value="<%=billing_group_desc%>">
		<input type="hidden" name="tobedtype" id="tobedtype" value="">
		<input type="hidden" name="fr_team_id" id="fr_team_id" value="">
		<input type="hidden" name="open_enctr_gender" id="open_enctr_gender" value="<%=gender%>">
 		<input type="hidden" name="open_enctr_age" id="open_enctr_age" value="<%=age%>"> 
		<input type="hidden" name="call_function" id="call_function" value="Transfer_Patient">	
		<input type="hidden" name="bl_interface_yn" id="bl_interface_yn" value="<%=install_yn%>">
		<input type="hidden" name="fr_daily_rate" id="fr_daily_rate" value="0">
		<input type="hidden" name="to_daily_rate" id="to_daily_rate" value="0">
		<input type="hidden" name="bill_type_code" id="bill_type_code" value="">
		<input type="hidden" name="blng_class_code" id="blng_class_code" value="">
		<input type="hidden" name="blng_serv_code" id="blng_serv_code" value="">
		<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>">
		<input type="hidden" name="continue_yn" id="continue_yn" value="">
		<input type='hidden' name = 'bl_operational' value="<%=bl_operational%>">
		<input type="hidden" name="def_max_period" id="def_max_period" value="<%=BED_BLOCK_PERIOD_MAX%>">
		
		<input type="hidden" name="change_bed_class_yn" id="change_bed_class_yn" value="<%=change_bed_class_yn%>">
		<input type="hidden" name="entitlement_by_pat_cat_yn" id="entitlement_by_pat_cat_yn" value="<%=entitlement_by_pat_cat_yn%>">
		<input type="hidden" name="counter" id="counter" value="<%=req_count%>">
		<input type="hidden" name="mother_status" id="mother_status" value="<%=mother_status%>">
		<input type="hidden" name="transfer_wo_delink_yn" id="transfer_wo_delink_yn" value="<%=transfer_wo_delink_yn%>"><!-- Added for the CRF - HSA-CRF-0035 -->
		<input type="hidden" name="mother_bed_status" id="mother_bed_status" value="">
		<input type="hidden" name="override_yn" id="override_yn" value="">	
		<input type="hidden" name="bed_class_chk" id="bed_class_chk" value="Y">
		<input type="hidden" name="reserve_nurs_unit_code" id="reserve_nurs_unit_code" value="<%=reserve_nurs_unit_code%>">
		<input type="hidden" name="reserve_room_no" id="reserve_room_no" value="<%=reserve_room_no%>">
		<input type="hidden" name="reserve_bed_no" id="reserve_bed_no" value="<%=reserve_bed_no%>">
		<input type="hidden" name="reserve_specialty_code" id="reserve_specialty_code" value="<%=reserve_specialty_code%>">
		<input type="hidden" name="reserve_practitioner_id" id="reserve_practitioner_id" value="<%=reserve_practitioner_id%>">
		<input type="hidden" name="reserve_bed_type_code" id="reserve_bed_type_code" value="<%=reserve_bed_type_code%>">
		<input type="hidden" name="reserve_service_code" id="reserve_service_code" value="<%=reserve_service_code%>">
		<input type="hidden" name="reserve_bed_class_code" id="reserve_bed_class_code" value="<%=reserve_bed_class_code%>">
		<input type="hidden" name="confirm_yn" id="confirm_yn" value="N">
		<input type="hidden" name="remove_bed" id="remove_bed" value="N">
		<input type="hidden" name="is_to_bed_equals_reserve_bed" id="is_to_bed_equals_reserve_bed" value="N">
		<input type="hidden" name="reserve_bed_on_tfr_yn" id="reserve_bed_on_tfr_yn" value="<%=reserve_bed_on_tfr_yn%>">
		<input type="hidden" name="func_id" id="func_id" value="<%=func_id%>">
		<input type="hidden" name="year" id="year" value="<%=year%>">
		<input type="hidden" name="retain_res_bed" id="retain_res_bed" value="N">
		<input type="hidden" name="exp_discharge_date_time" id="exp_discharge_date_time" value="<%=exp_discharge_date_time%>">
		<input type="hidden" name="pseudo_bed" id="pseudo_bed" value="<%=pseudo_bed_yn%>">
		<input type="hidden" name="deact_pseudo_bed" id="deact_pseudo_bed" value="<%=deact_pseudo_bed%>">
		<input type="hidden" name="reserved_bed_cont" id="reserved_bed_cont" value="<%=reserved_bed_cont%>">
		<!-- Added for the CRF HSA-CRF-0035 -- start-->
		<input type="hidden" name="linked_baby_count" id="linked_baby_count" value="">
		<input type="hidden" name="available_baby_beds" id="available_baby_beds" value="">
		<!-- Added for the CRF HSA-CRF-0035 -- End-->
		<input type="hidden" name="reqRadioBtn" id="reqRadioBtn" value=""><!--Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866-->

		

	<%
	if(install_yn.equals("Y"))
	{
	%>
		<input type='hidden' name='transfer_chargeable_yn' id='transfer_chargeable_yn' value='Y'>
		<input type='hidden' name='transfer_serv_charge' id='transfer_serv_charge' value=''>
		<input type='hidden' name='surgery_reqd_yn' id='surgery_reqd_yn' value='Y' >
		<input type='hidden' name='addnl_dep_amt' id='addnl_dep_amt' value=''>

	<%
	}
	%>
	
<script>
		document.forms[0].nursing_unit.value=document.forms[0].fr_nursing_unit_code.value;
		document.forms[0].practid.value=document.forms[0].fr_practitioner_id.value;
		document.forms[0].Splcode.value=document.forms[0].fr_speciality_code.value;
		var count=0
			if(count==0)
			{
				popDynamicValues_em(document.forms[0].nursing_unit);
				count++;
			}

</script>
	</form>
<%		
	}catch(Exception e){
		out.print("Exception EmergencyTransfer :"+e.toString());
		e.printStackTrace();
	}
	finally 
	{
		try
		{
			if(stmt			!= null)   stmt.close();
			if(rset			!= null)   rset.close();
			ConnectionManager.returnConnection(con,request);
		}catch(Exception ee){out.print("Error in while closing the connections:"+ee.toString());}
	}
 %>
	 

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



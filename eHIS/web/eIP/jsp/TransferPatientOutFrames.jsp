<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title><fmt:message key="eIP.TransferPatientOut.label" bundle="${ip_labels}"/></title>
</head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
<%
	request.setCharacterEncoding("UTF-8");
	String patientid				=	checkForNull(request.getParameter("patientId"));
	String encounterid				=	checkForNull(request.getParameter("encounterId"));
	String facilityId				=	(String)session.getValue("facility_id");
	String locale					= (String)session.getAttribute("LOCALE");
    String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
	String confirmIP				=	checkForNull(request.getParameter("confirmIP"));
	String call_function			=	checkForNull(request.getParameter("call_function"));
	String oper_stn_id				=	checkForNull(request.getParameter("oper_stn_id"));
	String status_value				=	checkForNull(request.getParameter("status_value"));
	String change_bed_class_yn		= checkForNull(request.getParameter("change_bed_class_yn"));
	String bl_interfaced_yn			= checkForNull(request.getParameter("bl_interfaced_yn"));
	String priotity_status			= checkForNull(request.getParameter("priotity_status"),"N");
	String deactivate_pseudo_bed_yn	= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
	String dflt_blk_prd_for_tfr_out	= checkForNull(request.getParameter("dflt_blk_prd_for_tfr_out"));
	String bed_block_period_normal	= checkForNull(request.getParameter("bed_block_period_normal"));
	String pat_check_in_allowed_yn	= checkForNull(request.getParameter("pat_check_in_allowed_yn"),"N");
	String reserve_bed_on_tfr_yn	= checkForNull(request.getParameter("reserve_bed_on_tfr_yn"),"N");
	String allow_multiple_bed_for_resv_yn	= checkForNull(request.getParameter("allow_multiple_bed_for_resv_yn"),"N");
	String transfer_wo_delink_yn	= checkForNull(request.getParameter("transfer_wo_delink_yn"),"N");//Added for the CRF - HSA-CRF-0035

	String sdate			= "";
	String admissiondate	= "";
	String admissiontype	= "";

	String frpractitionerid	= "";
	String frpractdesc		= "";
	String frspecialitycode	= "";
	String frspecialitydesc	= "";
	String frbedclass		= "";
	String frbedclassdesc	= "";
	String frnursingunitcode= "";
	String frnursingunitdesc= "";
	String frbedno			= "";
	String frroomno			= "";
	String frbedtype		= "";
	String frbedtypedesc	= "";
	String gender			= "";
	String age				= "";
	String frservicecode	= "";
	String frservicedesc	= "";
	String frsubservicecode	= "";
	String frsubservicedesc	= "";
	String patient_class	= "";
	String frmeddesc		= "";
	String frteamid			= "";
	String params			= "";
	String dateofbirth		= "";
	String allow_emerg_trf_yn	= "";
	String max_trn_date_time	= "";
	String year				= "";
	String pseudo_bed_yn	= "";
	Connection con			= null;
	Statement stmt			= null;
	ResultSet rset			= null;
	try
	{
		StringBuffer strBuffer	= new StringBuffer();
		con						=	ConnectionManager.getConnection(request);
		/*Monday, May 03, 2010 , commented for PE added in main query
		/*
		strBuffer.append("Select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from dual");    
		stmt  = con.createStatement();
		rset    = stmt.executeQuery(strBuffer.toString());
		if(rset != null)
		{
			if(rset.next())
			{
				sdate = checkForNull(rset.getString("sdate"));
			}    
			if(rset	!= null)   rset.close();
			if(stmt  != null)   stmt.close();
		}*/
		if(strBuffer.length()>0) strBuffer.delete(0,strBuffer.length());

		strBuffer.append("SELECT" );
		strBuffer.append("  TO_CHAR(a.admission_date_time,'dd/mm/rrrr hh24:MI') admission_date" );
		strBuffer.append("  , ip_get_desc.ip_admission_type(a.admission_type, '"+locale+"', 2) admission_short_desc" );
		strBuffer.append("  , a.attend_practitioner_id practitioner_id" );
		strBuffer.append("  , am_get_desc.am_practitioner (a.attend_practitioner_id, '"+locale+"', 1) practitioner_name" );
		strBuffer.append("  , a.specialty_code" );
		strBuffer.append("  , am_get_desc.am_speciality (a.specialty_code, '"+locale+"', 2 ) specialty_short_desc" );
		strBuffer.append("  , a.nursing_unit_code" );
		strBuffer.append("  , ip_get_desc.ip_nursing_unit (a.facility_id, a.nursing_unit_code, '"+locale+"', 2 ) nursing_unit_short_desc" );
		strBuffer.append("  , a.bed_class_code" );
		strBuffer.append("  , ip_get_desc.ip_bed_class (a.bed_class_code, '"+locale+"', 2 ) bed_class_short_desc" );
		strBuffer.append("  , a.bed_type_code" );
		strBuffer.append("  , ip_get_desc.ip_bed_type (a.bed_type_code, '"+locale+"', 2) BED_TYPE_SHORT_DESC" );
		strBuffer.append("  , a.bed_num bed_no" );
		strBuffer.append("  , a.room_num room_no" );
		strBuffer.append("  , b.sex gender" );
		strBuffer.append("  , get_age(b.date_of_birth) age" );
		strBuffer.append("  , a.PATIENT_CLASS" );
		strBuffer.append("  , a.service_code" );
		strBuffer.append("  , am_get_desc.am_service(a.service_code,'"+locale+"',2) service_short_desc" );
		strBuffer.append("  , SUBSERVICE_CODE" );
		strBuffer.append("  , am_get_desc.am_subservice(a.service_code,a.subservice_code,'"+locale+"',2) SUBSERVICE_SHORT_DESC" );
		strBuffer.append("  , a.team_id" );
		strBuffer.append("  , am_get_desc.am_medical_team(a.facility_id, a.team_id, '"+locale+"', 2) team_desc" );
		strBuffer.append("  , TO_CHAR(b.date_of_birth,'dd/mm/rrrr') DATE_OF_BIRTH " );
		/*Monday, May 03, 2010 , added for PE*/
		strBuffer.append("  ,(select allow_emerg_trf_yn  from ip_nursing_unit where nursing_unit_code=a.nursing_unit_code and facility_id =a.facility_id )allow_emerg_trf_yn " );
		strBuffer.append("  ,to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate " );
		strBuffer.append("  ,calculate_age(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),1)year " );
		strBuffer.append("  , (Select to_char(MAX(TRN_DATE_TIME),'dd/mm/rrrr hh24:mi') trn_date_time from IP_ADT_TRN where encounter_id = a.encounter_id and facility_id  = a.facility_id)max_trn_date_time " );
		/*Monday, September 13, 2010 , SRR20056-SCF-5155 [IN:023680]*/
		strBuffer.append("  ,(select pseudo_bed_yn from ip_nursing_unit_bed where  facility_id = a.facility_id and  nursing_unit_code = a.nursing_unit_code and bed_no = a.bed_num) pseudo_bed_yn " );
		/**/
		strBuffer.append("FROM" );
		strBuffer.append("  ip_open_encounter a" );
		strBuffer.append("  , mp_patient b " );
		strBuffer.append("WHERE " );
		strBuffer.append("  a.facility_id = '"+facilityId+"' " );
		strBuffer.append("  AND a.encounter_id ="+encounterid+" " );
		strBuffer.append("  AND a.patient_id = b.patient_id" );

		stmt  = con.createStatement();
		rset    = stmt.executeQuery(strBuffer.toString());
		if(rset != null)
		{
			if(rset.next())
			{
				admissiondate		= checkForNull(rset.getString("admission_date"));
				admissiontype		= checkForNull(rset.getString("admission_short_desc"));
				frpractitionerid	= checkForNull(rset.getString("practitioner_id"));
				frpractdesc			= checkForNull(rset.getString("practitioner_name"));
				frspecialitycode	= checkForNull(rset.getString("specialty_code"));
				frspecialitydesc	= checkForNull(rset.getString("specialty_short_desc"));
				frbedclass			= checkForNull(rset.getString("bed_class_code"));
				frbedclassdesc		= checkForNull(rset.getString("bed_class_short_desc"));
				frnursingunitcode	= checkForNull(rset.getString("nursing_unit_code"));
				frnursingunitdesc	= checkForNull(rset.getString("nursing_unit_short_desc"));
				frbedno				= checkForNull(rset.getString("bed_no"));       
				frroomno			= checkForNull(rset.getString("room_no"));   
				frbedtype			= checkForNull(rset.getString("bed_type_code"));
				frbedtypedesc		= checkForNull(rset.getString("BED_TYPE_SHORT_DESC"));
				gender				= checkForNull(rset.getString("gender"));
				age					= checkForNull(rset.getString("age"));
				frservicecode		= checkForNull(rset.getString("service_code"));
				frservicedesc		= checkForNull(rset.getString("service_short_desc"));
				frsubservicecode	= checkForNull(rset.getString("SUBSERVICE_CODE"));
				frsubservicedesc	= checkForNull(rset.getString("SUBSERVICE_SHORT_DESC"));
				patient_class		= checkForNull(rset.getString("PATIENT_CLASS"));
				frmeddesc			= checkForNull(rset.getString("team_desc"));
				frteamid			= checkForNull(rset.getString("team_id"));
				dateofbirth			= checkForNull(rset.getString("DATE_OF_BIRTH"));
				//tfr_req_status		= checkForNull(rset.getString("tfr_req_status"));
				allow_emerg_trf_yn  = checkForNull(rset.getString("allow_emerg_trf_yn"));
				sdate				= checkForNull(rset.getString("sdate"));
				max_trn_date_time	= checkForNull(rset.getString("max_trn_date_time"));
				year				= checkForNull(rset.getString("year"));
				pseudo_bed_yn		= checkForNull(rset.getString("pseudo_bed_yn"),"N");

			}    
			if(rset	!= null)   rset.close();
			if(stmt  != null)   stmt.close();
		}
/*10/20/2008 FS102IPSRRCRF0228V2.0 */
			
			
			 
			 /*Monday, May 03, 2010 , commented for PE added in main query
			String sql_nu	= " select ALLOW_EMERG_TRF_YN  from IP_NURSING_UNIT_VW where nursing_unit_code='"+frnursingunitcode+"' and facility_id ='"+facilityId+"' ";
			stmt = con.createStatement() ;	
			rset = stmt.executeQuery(sql_nu.toString());
			
			if( rset != null &&  rset.next())
				{
					allow_emerg_trf_yn = checkForNull(rset.getString("allow_emerg_trf_yn"));
				 }
				if(rset!=null) rset.close();
		*/
		params = "admission_date="+java.net.URLEncoder.encode(admissiondate)+"&encounter_id="+java.net.URLEncoder.encode(encounterid)+"&patient_id="+java.net.URLEncoder.encode(patientid)+"&call_function="+java.net.URLEncoder.encode(call_function)+"&confirmIP="+java.net.URLEncoder.encode(confirmIP)+"&oper_stn_id="+java.net.URLEncoder.encode(oper_stn_id)+"&sdate="+java.net.URLEncoder.encode(sdate)+"&frpractitionerid="+java.net.URLEncoder.encode(frpractitionerid)+"&frpractdesc="+java.net.URLEncoder.encode(frpractdesc,"UTF-8")+"&frspecialitycode="+java.net.URLEncoder.encode(frspecialitycode)+"&frspecialitydesc="+java.net.URLEncoder.encode(frspecialitydesc,"UTF-8")+"&frbedclass="+java.net.URLEncoder.encode(frbedclass)+"&frbedclassdesc="+java.net.URLEncoder.encode(frbedclassdesc,"UTF-8")+"&frnursingunitcode="+java.net.URLEncoder.encode(frnursingunitcode)+"&frnursingunitdesc="+java.net.URLEncoder.encode(frnursingunitdesc,"UTF-8")+"&frbedno="+java.net.URLEncoder.encode(frbedno)+"&frroomno="+java.net.URLEncoder.encode(frroomno)+"&frbedtype="+java.net.URLEncoder.encode(frbedtype)+"&frbedtypedesc="+java.net.URLEncoder.encode(frbedtypedesc,"UTF-8")+"&gender="+java.net.URLEncoder.encode(gender)+"&age="+java.net.URLEncoder.encode(age)+"&frservicecode="+java.net.URLEncoder.encode(frservicecode)+"&frservicedesc="+java.net.URLEncoder.encode(frservicedesc,"UTF-8")+"&frsubservicecode="+java.net.URLEncoder.encode(frsubservicecode)+"&frsubservicedesc="+java.net.URLEncoder.encode(frsubservicedesc,"UTF-8")+"&patient_class="+java.net.URLEncoder.encode(patient_class)+"&frmeddesc="+java.net.URLEncoder.encode(frmeddesc,"UTF-8")+"&frteamid="+java.net.URLEncoder.encode(frteamid)+"&dateofbirth="+java.net.URLEncoder.encode(dateofbirth)+"&bl_interfaced_yn="+java.net.URLEncoder.encode(bl_interfaced_yn)+"&priotity_status="+java.net.URLEncoder.encode(priotity_status)+"&deactivate_pseudo_bed_yn="+java.net.URLEncoder.encode(deactivate_pseudo_bed_yn)+"&dflt_blk_prd_for_tfr_out="+java.net.URLEncoder.encode(dflt_blk_prd_for_tfr_out)+"&bed_block_period_normal="+java.net.URLEncoder.encode(bed_block_period_normal)+"&change_bed_class_yn="+java.net.URLEncoder.encode(change_bed_class_yn)+"&allow_emerg_trf_yn="+java.net.URLEncoder.encode(allow_emerg_trf_yn)+"&pat_check_in_allowed_yn="+java.net.URLEncoder.encode(pat_check_in_allowed_yn)+"&reserve_bed_on_tfr_yn="+java.net.URLEncoder.encode(reserve_bed_on_tfr_yn)+"&allow_multiple_bed_for_resv_yn="+java.net.URLEncoder.encode(allow_multiple_bed_for_resv_yn)+"&year="+java.net.URLEncoder.encode(year)+"&transfer_wo_delink_yn="+transfer_wo_delink_yn;//modified for the CRF - HSA-CRF-0035

	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally 
	{
		ConnectionManager.returnConnection(con,request);
	}

%>	
	<iframe src="../../eCommon/jsp/pline.jsp?Facility_Id=<%=java.net.URLEncoder.encode(facilityId)%>&EncounterId=<%=java.net.URLEncoder.encode(encounterid)%>" name="PatientLine_frame"  scrolling='no' style='height:9vh;width:98vw'></iframe>
	<iframe src="../../eIP/jsp/TransferPatientOutMain.jsp?function_id=<%=function_id%>&encounter_id=<%=java.net.URLEncoder.encode(encounterid)%>&patient_id=<%=java.net.URLEncoder.encode(patientid)%>&call_function=<%=call_function%>&confirmIP=<%=confirmIP%>&oper_stn_id=<%=oper_stn_id%>&status_value=<%=status_value%>&sdate=<%=java.net.URLEncoder.encode(sdate)%>&admissiondate=<%=java.net.URLEncoder.encode(admissiondate)%>&admissiontype=<%=admissiontype%>&max_trn_date_time=<%=java.net.URLEncoder.encode(max_trn_date_time)%>" name="Transfer_frame" scrolling='no' style="height:12vh;width:98vw"></iframe>
	<iframe src="../../eIP/jsp/TransferPatientOccupancyDtlsTab.jsp?<%=params%>&pseudo_bed_yn=<%=pseudo_bed_yn%>" name="Transfer_frame"  scrolling='auto' style="height:61vh;width:98vw"></iframe>
	<iframe src="../../eCommon/html/blank.html" name="Dummy_frame" id="Dummy_frame" scrolling='no'  style='height:0vh;width:98vw'></iframe> 
	<iframe src="../../eCommon/html/blank.html" name="blankFrame" id="blankFrame" scrolling='no'  style='height:0vh;width:98vw'></iframe> 
	<iframe src="../../eIP/jsp/TransferPatientButtons.jsp" name="Button_frame" id="Button_frame" scrolling='no'  style='height:4vh;width:98vw'></iframe> 

</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>


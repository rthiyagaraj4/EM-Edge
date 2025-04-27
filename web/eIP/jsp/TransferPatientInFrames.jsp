<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
	<title><fmt:message key="eIP.TransferPatientIn.label" bundle="${ip_labels}"/></title>
</head>
<%
	int dflt_blk_prd_for_tfr_out_int = 0;
	int bed_block_period_normal_int = 0;

	String patientid		= request.getParameter("patientId");
	String encounterid		= request.getParameter("encounterId");
	String facilityId		= (String)session.getValue("facility_id");
	String confirmIP		= checkForNull(request.getParameter("confirmIP"));
	String call_function	= request.getParameter("call_function");
	String oper_stn_id		= checkForNull(request.getParameter("oper_stn_id"));

	String deactivate_pseudo_bed_yn	= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");

	String change_bed_class_yn		= checkForNull(request.getParameter("change_bed_class_yn"));

	String bl_interfaced_yn	= checkForNull(request.getParameter("bl_interfaced_yn"));
	String priotity_status	= checkForNull(request.getParameter("priotity_status"),"N");

	String dflt_blk_prd_for_tfr_out	= checkForNull(request.getParameter("dflt_blk_prd_for_tfr_out"));
	if(!dflt_blk_prd_for_tfr_out.equals(""))
		dflt_blk_prd_for_tfr_out_int = Integer.parseInt(dflt_blk_prd_for_tfr_out);

	String bed_block_period_normal	= checkForNull(request.getParameter("bed_block_period_normal"));
	if(!bed_block_period_normal.equals(""))
		bed_block_period_normal_int = Integer.parseInt(bed_block_period_normal);
     String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
	String pat_check_in_allowed_yn	= checkForNull(request.getParameter("pat_check_in_allowed_yn"),"N");
	String reserve_bed_on_tfr_yn	= checkForNull(request.getParameter("reserve_bed_on_tfr_yn"),"N");
	String allow_multiple_bed_for_resv_yn	= checkForNull(request.getParameter("allow_multiple_bed_for_resv_yn"),"N");
	String transfer_wo_delink_yn	= checkForNull(request.getParameter("transfer_wo_delink_yn"),"N");//Added for the CRF - HSA-CRF-0035
	String sdate			= "";
	String DOB				= "";
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
	String max_trn_date_time= "";
	String year				= "";
	Connection con			= null;
	Statement stmt			= null;
	ResultSet rset			= null;
	String locale			= (String)session.getAttribute("LOCALE");
    
	try
	{
		StringBuffer strBuffer	= new StringBuffer();
		con						=	ConnectionManager.getConnection(request);
		/*Tuesday, May 04, 2010, commnted for PE .
		strBuffer.append("Select to_char(sysdate,'dd/mm/yyyy hh24:mi') sdate from dual");    
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
		strBuffer.append("select to_char(a.admission_date_time,'dd/mm/rrrr hh24:MI') admission_date, ip_get_desc.ip_admission_type(a.admission_type, '"+locale+"', 2) admission_short_desc, a.nursing_unit_code, ip_get_desc.ip_nursing_unit (a.facility_id, a.nursing_unit_code, '"+locale+"', 2 ) nursing_unit_short_desc, a.specialty_code, am_get_desc.am_speciality (a.specialty_code, '"+locale+"', 2 ) specialty_short_desc, a.attend_practitioner_id practitioner_id, am_get_desc.am_practitioner (a.attend_practitioner_id, '"+locale+"', 1) practitioner_name, a.bed_num bed_no, a.room_num room_no, a.bed_class_code, ip_get_desc.ip_bed_class (a.bed_class_code, '"+locale+"', 2 ) bed_class_short_desc, null dly_charge, a.bed_type_code, ip_get_desc.ip_bed_type (a.bed_type_code, '"+locale+"', 2) BED_TYPE_SHORT_DESC, b.sex gender,get_age(b.date_of_birth) age,to_char(b.date_of_birth,'dd/mm/rrrr') DATE_OF_BIRTH, a.service_code, am_get_desc.am_service(a.service_code,'"+locale+"',2) service_short_desc, SUBSERVICE_CODE, am_get_desc.am_subservice(a.service_code,a.subservice_code,'"+locale+"',2) SUBSERVICE_SHORT_DESC, a.PATIENT_CLASS, a.team_id, am_get_desc.am_medical_team(a.facility_id, a.team_id, '"+locale+"', 2) team_desc, to_char(date_of_birth,'dd/mm/rrrr') DOB ,to_char(sysdate,'dd/mm/yyyy hh24:mi') sdate,(Select to_char(MAX(TRN_DATE_TIME),'dd/mm/rrrr hh24:mi') trn_date_time from IP_ADT_TRN where encounter_id = a.encounter_id and facility_id  = a.facility_id)max_trn_date_time,calculate_age(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),1)year from ip_open_encounter a, mp_patient b where  a.facility_id = '"+facilityId+"' and a.encounter_id ="+encounterid+" and a.patient_id = b.patient_id");
	
		stmt  = con.createStatement();
		rset    = stmt.executeQuery(strBuffer.toString());
		if(rset != null)
		{
			if(rset.next())
			{
				admissiondate		= checkForNull(rset.getString("admission_date"));
				DOB					= checkForNull(rset.getString("DOB"));
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
				sdate				= checkForNull(rset.getString("sdate"));
				max_trn_date_time	= checkForNull(rset.getString("max_trn_date_time"));
				year				= checkForNull(rset.getString("year"));
			}    
			if(rset	!= null)   rset.close();
			if(stmt  != null)   stmt.close();
		}
				params="DOB="+java.net.URLEncoder.encode(DOB)+"&admission_date="+java.net.URLEncoder.encode(admissiondate)+"&encounter_id="+java.net.URLEncoder.encode(encounterid)+"&patient_id="+java.net.URLEncoder.encode(patientid)+"&call_function="+java.net.URLEncoder.encode(call_function)+"&confirmIP="+java.net.URLEncoder.encode(confirmIP)+"&oper_stn_id="+java.net.URLEncoder.encode(oper_stn_id)+"&sdate="+java.net.URLEncoder.encode(sdate)+"&frpractitionerid="+java.net.URLEncoder.encode(frpractitionerid)+"&frpractdesc="+java.net.URLEncoder.encode(frpractdesc,"UTF-8")+"&frspecialitycode="+java.net.URLEncoder.encode(frspecialitycode)+"&frspecialitydesc="+java.net.URLEncoder.encode(frspecialitydesc,"UTF-8")+"&frbedclass="+java.net.URLEncoder.encode(frbedclass)+"&frbedclassdesc="+java.net.URLEncoder.encode(frbedclassdesc,"UTF-8")+"&frnursingunitcode="+java.net.URLEncoder.encode(frnursingunitcode)+"&frnursingunitdesc="+java.net.URLEncoder.encode(frnursingunitdesc,"UTF-8")+"&frbedno="+java.net.URLEncoder.encode(frbedno)+"&frroomno="+java.net.URLEncoder.encode(frroomno)+"&frbedtype="+java.net.URLEncoder.encode(frbedtype)+"&frbedtypedesc="+java.net.URLEncoder.encode(frbedtypedesc,"UTF-8")+"&gender="+java.net.URLEncoder.encode(gender)+"&age="+java.net.URLEncoder.encode(age)+"&frservicecode="+java.net.URLEncoder.encode(frservicecode)+"&frservicedesc="+java.net.URLEncoder.encode(frservicedesc,"UTF-8")+"&frsubservicecode="+java.net.URLEncoder.encode(frsubservicecode)+"&frsubservicedesc="+java.net.URLEncoder.encode(frsubservicedesc,"UTF-8")+"&patient_class="+java.net.URLEncoder.encode(patient_class)+"&frmeddesc="+java.net.URLEncoder.encode(frmeddesc,"UTF-8")+"&frteamid="+java.net.URLEncoder.encode(frteamid)+"&dateofbirth="+java.net.URLEncoder.encode(dateofbirth)+"&deactivate_pseudo_bed_yn="+java.net.URLEncoder.encode(deactivate_pseudo_bed_yn)+"&dflt_blk_prd_for_tfr_out="+dflt_blk_prd_for_tfr_out_int+"&bed_block_period_normal="+bed_block_period_normal_int+"&bl_interfaced_yn="+java.net.URLEncoder.encode(bl_interfaced_yn)+"&priotity_status="+java.net.URLEncoder.encode(priotity_status)+"&change_bed_class_yn="+java.net.URLEncoder.encode(change_bed_class_yn)+"&pat_check_in_allowed_yn="+java.net.URLEncoder.encode(pat_check_in_allowed_yn)+"&reserve_bed_on_tfr_yn="+java.net.URLEncoder.encode(reserve_bed_on_tfr_yn)+"&allow_multiple_bed_for_resv_yn="+java.net.URLEncoder.encode(allow_multiple_bed_for_resv_yn)+"&year="+java.net.URLEncoder.encode(year)+"&transfer_wo_delink_yn="+transfer_wo_delink_yn;//modified for the CRF - HSA-CRF-0035

	}catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally 
	{
		ConnectionManager.returnConnection(con,request);
	}

%>	
		<iframe name="PatientLine_frame" id="PatientLine_frame" src="../../eCommon/jsp/pline.jsp?Facility_Id=<%=java.net.URLEncoder.encode(facilityId)%>&EncounterId=<%=java.net.URLEncoder.encode(encounterid)%>"  scrolling='no' style='height:10vh;width:97vw'></iframe>
		<iframe src="../jsp/TransferPatientOutMain.jsp?function_id=<%=function_id%>&encounter_id=<%=java.net.URLEncoder.encode(encounterid)%>&patient_id=<%=java.net.URLEncoder.encode(patientid)%>&call_function=<%=call_function%>&confirmIP=<%=confirmIP%>per_stn_id%>&sdate=<%=java.net.URLEncoder.encode(sdate)%>&admissiondate=<%=java.net.URLEncoder.encode(admissiondate)%>&admissiontype=<%=admissiontype%>&max_trn_date_time=<%=java.net.URLEncoder.encode(max_trn_date_time)%>" name="Transfer_in"  scrolling='no'  style="height:15vh;width:97vw" ></iframe>
		<iframe src="../jsp/TransferPatientOccupancyDtlsTab.jsp?<%=params%>" name="Transfer_frame" noresize scrolling='auto' style='height:59vh;width:97vw'></iframe> 
		<!-- <iframe src="../../eCommon/html/blank.html" name="Dummy_frame" id="Dummy_frame" scrolling='no' noresize style='height:46vh;width:100vw'></iframe> -->
		<iframe src="../../eCommon/html/blank.html" name="Dummy_frame" id="Dummy_frame" scrolling='no' noresize style='height:0vh;width:97vw'></iframe> 
		<iframe src="../jsp/TransferPatientButtons.jsp" name="Button_frame" id="Button_frame" scrolling='no' noresize style='height:4vh;width:97vw'></iframe> 
	
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}

%>


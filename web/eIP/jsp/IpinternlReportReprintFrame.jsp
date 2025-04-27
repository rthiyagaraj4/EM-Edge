<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page contentType="text/html;charset=UTF-8"%>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String encounterid=request.getParameter("encounterId"); 
	String facilityId = (String) session.getValue( "facility_id" ) ;	
	String patientid=request.getParameter("patientId");    
	String nursing_unit_code = request.getParameter("location_code");
	if (nursing_unit_code==null) nursing_unit_code = "";
	
	String booking_list_ref_no	= request.getParameter("booking_list_ref_no");    
	if (booking_list_ref_no==null || booking_list_ref_no.equals("")) booking_list_ref_no = "";
	
	String location_type = "N";
	String gen_file_no = "";

	String sqlString = "select a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, a.module_id from ip_online_report a, sm_report b  where  a.module_id = 'IP' and b.internal_request_yn='Y' and a.facility_id='"+facilityId+"' and (a.print_on_admission_yn='Y' or a.print_on_transfer_request_yn='Y' or a.print_on_conform_transfer_yn='Y' or a.print_on_bed_assigned_yn='Y' or a.print_on_discharge_yn='Y') and a.nursing_unit_code ='"+nursing_unit_code+"'  and a.report_id = b.report_id order by 2 ";
	
	String reportParamNames = "p_encounter_id,p_clinic_code,p_clinic_type,p_patient_id,p_file_no";
	String reportParamValues = ""+encounterid+","+nursing_unit_code+","+location_type+","+patientid+","+gen_file_no+"";
%>
	<title><fmt:message key="Common.internalreport.label" bundle="${common_labels}"/></title>
	<iframe name='comps' id='comps' src='../../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString=<%=java.net.URLEncoder.encode(sqlString)%>&EncounterId=<%=encounterid%>&dest_locn_type=<%=location_type%>&dest_locn_code=<%=nursing_unit_code%>&reportParamNames=<%=reportParamNames%>&reportParamValues=<%=reportParamValues%>' frameborder=no noresize></iframe>
<head>
<html>


<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>

<html>
<head><title><fmt:message key="eMP.CreatePatientFile.label" bundle="${mp_labels}"/></title>
</head>
<%
		
		String called_from = request.getParameter("Called_From")==null?"":request.getParameter("Called_From");

		String location_type = request.getParameter("Location_Type")==null?"":request.getParameter("Location_Type");
		String location_code = request.getParameter("Location_Code")==null?"":request.getParameter("Location_Code");
		String p_patient_id = request.getParameter("P_Patient_ID")==null?"":request.getParameter("P_Patient_ID");

		String p_single_or_multi_files_ind = request.getParameter("P_Single_or_multi_files_ind")==null?"":request.getParameter("P_Single_or_multi_files_ind");

		String p_separate_file_no_yn = request.getParameter("P_Seperate_file_no_yn")==null?"":request.getParameter("P_Seperate_file_no_yn");
		
		String p_pat_ser_grp_code = request.getParameter("P_Pat_Ser_Grp_Code")==null?"":request.getParameter("P_Pat_Ser_Grp_Code");


		String p_mr_section_type = request.getParameter("P_Mr_Section_Type")==null?"":request.getParameter("P_Mr_Section_Type");

		String p_mr_section_code = request.getParameter("P_Mr_Section_Code")==null?"":request.getParameter("P_Mr_Section_Code");

		String p_encounter_id = request.getParameter("p_encounter_id")==null?"":request.getParameter("p_encounter_id");        
		String p_patient_class = request.getParameter("p_patient_class")==null?"":request.getParameter("p_patient_class");       
		String p_encounter_date_time = request.getParameter("p_encounter_date_time")==null?"":request.getParameter("p_encounter_date_time");

		if(location_code.equals("null"))
		{
			location_code="";
		}

%>
<iframe src="../../eMP/jsp/CreateFileComponent.jsp?called_from=<%=called_from%>&location_type=<%=location_type%>&location_code=<%=location_code%>&p_patient_id=<%=p_patient_id%>&p_single_or_multi_files_ind=<%=p_single_or_multi_files_ind%>&p_separate_file_no_yn=<%=p_separate_file_no_yn%>&p_pat_ser_grp_code=<%=p_pat_ser_grp_code%>&p_mr_section_type=<%=p_mr_section_type%>&p_mr_section_code=<%=p_mr_section_code%>&p_encounter_id=<%=p_encounter_id%>&p_patient_class=<%=p_patient_class%>&p_encounter_date_time=<%=p_encounter_date_time%>" name="frame0"  NORESIZE=NORESIZE   scrolling="no" style="height:80vh;width:90vw;border:0"></iframe>
<iframe src="../../eCommon/jsp/error.jsp" name="frame1" id="frame1" scrolling="no" NORESIZE=NORESIZE  style="height:0vh;width:90vw;border:0"></iframe>
</html>


<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,java.sql.Clob,java.text.*,java.util.*,webbeans.eCommon.ConnectionManager,java.io.*,eOH.*,eCommon.Common.CommonAdapter,eOH.Common.*,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!-- <% request.setCharacterEncoding("UTF-8");%> -->
<!-- <%@include file="../../eCommon/jsp/Common.jsp" %> -->
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8"); 

	
	String facility_id      = (String) session.getAttribute("facility_id");
	//String login_user      = (String) session.getAttribute("login_user");
	String practitioner_id = (String)session.getValue("ca_practitioner_id") ;

	String tooth_numbering_system	= request.getParameter("tooth_numbering_system");
	String upper_arch_desc			= request.getParameter("upper_arch_desc");
	String lower_arch_desc			= request.getParameter("lower_arch_desc");
	String Q1_id					= request.getParameter("Q1_id");
	String Q2_id					= request.getParameter("Q2_id");
	String Q3_id					= request.getParameter("Q3_id");				  
	String Q4_id					= request.getParameter("Q4_id");
	String Q1_desc					= request.getParameter("Q1_desc");
	String Q2_desc					= request.getParameter("Q2_desc");
	String Q3_desc					= request.getParameter("Q3_desc");
	String Q4_desc					= request.getParameter("Q4_desc");
	String permanent_deciduous_flag = request.getParameter("permanent_deciduous_flag");
	String mixed_dentition_YN        = request.getParameter("mixed_dentition_YN");
	String asOnDatePrint        = request.getParameter("asOnDatePrint");
	String oh_chart_level        = request.getParameter("oh_chart_level");
	String other_chart_facility_id        = request.getParameter("other_chart_facility_id");
	String baseline_chart_yn        = request.getParameter("baseline_chart_yn");
	String patient_id = request.getParameter( "patient_id" ) ;
	String chart_num =CommonAdapter.checkForNull(request.getParameter("chart_num")) ;
	Connection con=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	PreparedStatement pstmt3=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	ResultSet rs3=null;
	String sql = "";

	String tooth_num = "";
	String tooth_name ="";
	String tooth_sn = "";
	String mapped_tooth_string = "";
	String site_type = "";
	String location = "";
	String practitioner_name = "";
	String super_key_num = "";
	
	int mapped_tooth_no = 0;
	int k = 1;
	int z = 0;
	StringBuilder content									=	new StringBuilder();

	String currentAgeOfPatient = "";
	String numbering_system_desc = "";
	String patientName = "";
	String arch_desc = "";
	String quad_desc = "";
	String desc = "";
	String date = "";
	String doneby = "";
	String status = "";
	String trmt_category_type = "";
	String super_yn = "";
	String RD_yn = "";
	String tooth_no_display = "";
	String condition_trmt_code_desc = "";
	String dtl_status = "";
	String remarks = "";
	String PD_flag = "";
	String display_tooth_no = "";
	String treatment_condition = "";
	String treatment_int_ext = "";
	String status_desc = "";
	String chart_closed_date = "";
	String chart_date = "";
	String gender = "";
	String hospital_number = "";
	String currentDate = "";
	String dentist_comments = "";
	String baseline_created_by = "";
	String facility_name = "";
	String tooth_no_for_Permanent_chart = "";
	String tooth_no_for_Mixed_Deciduous_chart = "";
	String tooth_no_for_Mixed_Permanent_chart = "";
	String as_on_date_chart_num = "";
	String condition_type = "";
	String trmt_outcome = "";
	String trmt_outcome_falure_success = "";
	String super_tooth_no = "";
	String retained_tooth_no = "";
	int count_charts = 0;
	
	StringBuilder images = new StringBuilder();
	StringBuilder conditions = new StringBuilder();
	StringBuilder ext_treatment = new StringBuilder();
	StringBuilder trmt_to_do = new StringBuilder();
	StringBuilder trmt_done = new StringBuilder();
	StringBuilder signed_data = new StringBuilder();
	Boolean flag_print = false;
	Boolean records_permanent_tooth = false;
	Boolean record_deciduous_tooth = false;

	int m = 1;
	int n = 1;
	int o = 1;
	int p = 1;

	if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){
		PD_flag = "P";
	}
	else{
		PD_flag = "D";
	}

	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	}

	String tooth_no_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothArchQuad.Label","oh_labels");
	String condition_type_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ConditionType.Label","oh_labels");
	String condition_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Conditions.Label","oh_labels");
	String date_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels");
	String recorded_by_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RecordedBy.label","common_labels");
	String treatment_category_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TreatmentCategory.label","common_labels");
	String ext_trmts_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ExternalTreatment.Label","oh_labels");
	String location_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels");  
	String treatment_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Treatment.Label","oh_labels");  
	String status_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels");  
	String period_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Period.label","common_labels");  
	String patient_name_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels");  
	String age_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels");  
	String gender_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels");  
	String hn_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.HN.Label","oh_labels");  
	String baseline_created_by_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.BaselineCreatedBy.Label","oh_labels");  
	String numbering_system_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.NumberingSystem.Label","oh_labels");  
	String signed_by_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.SignedBy.Label","oh_labels");  
	String signed_date_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.SignedDate.Label","oh_labels");  
	String external_trmts_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ExternalTreatments.Label","oh_labels");  
	String trmt_done_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentsDone.Label","oh_labels");  
	String trmt_to_do_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentsToDo.Label","oh_labels");  
	String dental_condition_treatmt_chart_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.DentalConditionTreatmentChart.Label","oh_labels"); 
	String condition_trmt_details_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ConditionsTreatmentDetails.Label","oh_labels");  
	
	String super_numerary_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.SuperNumerary.Label","oh_labels");  
	String missing_teeth_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.MissingTeeth.Label","oh_labels");  
	String partial_eruption_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.PartialEruption.Label","oh_labels");  
	String attrition_abrasion_erosion_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.AttritionAbrationErotion.Label","oh_labels");  
	String uneruption_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Uneruption.Label","oh_labels");  
	String impaction_normal_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ImpactionNormal.Label","oh_labels");  
	String extraction_planned_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Extraction(Planned).Label","oh_labels");  
	String extraction_performed_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Extraction(Performed).Label","oh_labels");  
	String denture_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Denture.Label","oh_labels"); 
	String bridge_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Bridge.Label","oh_labels"); 
	String ortho_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.OrthodonticAppliance.Label","oh_labels"); 
	String impaction_trmt_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ImpactionTreatment.Label","oh_labels"); 
	String tooth_trmt_planned_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothTrmt(Planned).Label","oh_labels"); 
	String tooth_trmt_performed_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothTrmt(Performed).Label","oh_labels"); 
	String mobility_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Mobility.Label","oh_labels"); 
	String trauma_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Trauma.label","common_labels"); 
	//Added by Sharon Crasta on 1/28/2010 for SRR20056-CRF-0498(IN010982)
	//Added to display the images for Mal position and Mal Occlusion
	String malocclusion_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Malocclusion.Label","oh_labels"); 
	String malposition_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Malposition.Label","oh_labels"); 
	//End
	String implant_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Implant.label","common_labels");  
	String dentist_comments_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.DentistComments.Label","oh_labels");  
	String dentist_department_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.DentalDepartment.Label","oh_labels");  
	String dental_chart_print_preview_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.PrintPreview.Label","oh_labels");  
	String crownup_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.CrownForUA.Label","oh_labels");  
	String crowndown_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.CrownForLA.Label","oh_labels");  
	String outcome_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.outcome.label","common_labels");  
	String failure_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Failure.label","common_labels");  
	String success_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Success.label","common_labels");  
	
%>
<%	
	try{
		con = ConnectionManager.getConnection(request);

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
		/*if(oh_chart_level.equals("E")){
			pstmt=con.prepareStatement("SELECT (SELECT PREF_NUMBERING_SYSTEM FROM OH_USER_PREFERENCES  WHERE APPL_USER_ID = ?) USER_TOOTH_NUMBERING_SYSTEM,TOOTH_NUMBERING_SYSTEM FROM OH_PARAM");
			pstmt.setString(1,login_user);
		}else{	//End
		  	pstmt=con.prepareStatement("SELECT (SELECT PREF_NUMBERING_SYSTEM FROM OH_USER_PREFERENCES  WHERE APPL_USER_ID = ?) USER_TOOTH_NUMBERING_SYSTEM, TOOTH_NUMBERING_SYSTEM FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?");
			pstmt.setString(1,login_user);
			pstmt.setString(2,other_chart_facility_id);
		}
		rs=pstmt.executeQuery();
		while(rs.next()){
			tooth_numbering_system = CommonAdapter.checkForNull(rs.getString("USER_TOOTH_NUMBERING_SYSTEM"));
		}*/

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		pstmt=con.prepareStatement("SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER WHERE PRACTITIONER_ID = ?");
		pstmt.setString(1,practitioner_id);
		rs=pstmt.executeQuery();
		while(rs.next()){
			practitioner_name = CommonAdapter.checkForNull(rs.getString("PRACTITIONER_NAME"));
		} 

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		pstmt=con.prepareStatement("SELECT ADDED_BY_ID FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID=? AND CHART_NUM = ?");
		pstmt.setString(1,patient_id);
		pstmt.setString(2,chart_num);
		rs=pstmt.executeQuery();
		while(rs.next()){
			baseline_created_by = CommonAdapter.checkForNull(rs.getString("ADDED_BY_ID"));
		} 

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		pstmt=con.prepareStatement("SELECT FACILITY_NAME FROM SM_FACILITY_PARAM WHERE FACILITY_ID=?");
		pstmt.setString(1,other_chart_facility_id);
		rs=pstmt.executeQuery();
		while(rs.next()){
			facility_name = CommonAdapter.checkForNull(rs.getString("FACILITY_NAME"));
		} 
		
		currentDate = com.ehis.util.DateUtils.getCurrentDate("DMY","en");
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(oh_chart_level.equals("E")){
			pstmt=con.prepareStatement("SELECT COUNT(*)COUNT_CHART FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID=?");
			pstmt.setString(1,patient_id);
		}else {
			pstmt=con.prepareStatement("SELECT COUNT(*)COUNT_CHART FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID=?");
			pstmt.setString(1,other_chart_facility_id);
			pstmt.setString(2,patient_id);
		}
		rs=pstmt.executeQuery();
		while(rs.next()){
			count_charts = Integer.parseInt(CommonAdapter.checkForNull(rs.getString("COUNT_CHART")));
			
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(oh_chart_level.equals("E")){
			if(baseline_chart_yn.equals("Y") || (asOnDatePrint.equals(currentDate))){
				pstmt=con.prepareStatement("SELECT TO_CHAR(CHART_DATE,'DD/MM/YYYY') CHART_DATE, TO_CHAR (CHART_CLOSE_DATE,'DD/MM/YYYY') CHART_CLOSE_DATE, DENTIST_COMMENTS, CHART_NUM AS_ON_DATE_CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID=? AND CHART_NUM = ?");

				//pstmt=con.prepareStatement("SELECT TO_CHAR(CHART_DATE,'DD/MM/YYYY') CHART_DATE,TO_CHAR (?,'DD/MM/YYYY') CHART_CLOSE_DATE, DENTIST_COMMENTS FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID=? AND CHART_NUM = ?");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
			}else {
				pstmt=con.prepareStatement("SELECT TO_CHAR(CHART_DATE,'DD/MM/YYYY') CHART_DATE,TO_CHAR (CHART_CLOSE_DATE,'DD/MM/YYYY') CHART_CLOSE_DATE, DENTIST_COMMENTS,(SELECT MAX (CHART_NUM) FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND TO_DATE (?, 'DD/MM/YYYY') BETWEEN TRUNC (CHART_DATE) AND TRUNC(NVL (CHART_CLOSE_DATE, SYSDATE))) AS_ON_DATE_CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID=? AND CHART_NUM = (SELECT MAX (CHART_NUM) FROM OH_RESTORATIVE_CHART_HDR  WHERE  PATIENT_ID = ?)");
				//pstmt=con.prepareStatement("SELECT TO_CHAR(CHART_DATE,'DD/MM/YYYY') CHART_DATE,TO_CHAR (?,'DD/MM/YYYY') CHART_CLOSE_DATE, DENTIST_COMMENTS FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID=? AND CHART_NUM = ?");
				
				String asOnDate1 = checkForNull(com.ehis.util.DateUtils.convertDate(asOnDatePrint, "DMY", locale, "en"));
				pstmt.setString(1,patient_id);
				pstmt.setString(2,asOnDate1);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,patient_id);
		
			}
		}else{
			 if(baseline_chart_yn.equals("Y") || (asOnDatePrint.equals(currentDate))){
				pstmt=con.prepareStatement("SELECT TO_CHAR(CHART_DATE,'DD/MM/YYYY') CHART_DATE,TO_CHAR (CHART_CLOSE_DATE,'DD/MM/YYYY') CHART_CLOSE_DATE, DENTIST_COMMENTS, CHART_NUM AS_ON_DATE_CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM = ?");
				//pstmt=con.prepareStatement("SELECT TO_CHAR(CHART_DATE,'DD/MM/YYYY') CHART_DATE,TO_CHAR (CHART_CLOSE_DATE,'DD/MM/YYYY') CHART_CLOSE_DATE, DENTIST_COMMENTS FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM = ?");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
			 }else{
				pstmt=con.prepareStatement("SELECT TO_CHAR (CHART_DATE, 'DD/MM/YYYY') CHART_DATE, DENTIST_COMMENTS, (SELECT MAX (CHART_NUM) FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND TO_DATE (?, 'DD/MM/YYYY') BETWEEN TRUNC (CHART_DATE) AND TRUNC(NVL (CHART_CLOSE_DATE, SYSDATE))) AS_ON_DATE_CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = (SELECT MIN (CHART_NUM)	FROM OH_RESTORATIVE_CHART_HDR  WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ?)");
				
				String asOnDate1 = checkForNull(com.ehis.util.DateUtils.convertDate(asOnDatePrint, "DMY", locale, "en"));

				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,asOnDate1);
				pstmt.setString(4,other_chart_facility_id);
				pstmt.setString(5,patient_id);
				pstmt.setString(6,other_chart_facility_id);
				pstmt.setString(7,patient_id);

			 }
			
		}
		rs=pstmt.executeQuery();
		while(rs.next()){
			chart_date = CommonAdapter.checkForNull(rs.getString("CHART_DATE"));
			if(baseline_chart_yn.equals("Y") || (asOnDatePrint.equals(currentDate))) {
				chart_closed_date = CommonAdapter.checkForNull(rs.getString("CHART_CLOSE_DATE"));
			}
			dentist_comments = CommonAdapter.checkForNull(rs.getString("DENTIST_COMMENTS"));
			as_on_date_chart_num = CommonAdapter.checkForNull(rs.getString("AS_ON_DATE_CHART_NUM"));
		}

		if(baseline_chart_yn.equals("Y") || (asOnDatePrint.equals(currentDate))){
			if(chart_closed_date.equals("")){
				chart_closed_date = currentDate;
			}
		}else{
			chart_closed_date = asOnDatePrint;
		}
		currentDate = com.ehis.util.DateUtils.convertDate(currentDate,"DMY","en",locale); 
    	chart_date = com.ehis.util.DateUtils.convertDate(chart_date,"DMY","en",locale); 
		asOnDatePrint = com.ehis.util.DateUtils.convertDate(asOnDatePrint,"DMY",locale,"en"); 
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		pstmt=con.prepareStatement("SELECT (SELECT NUMBERING_SYSTEM_DESC FROM OH_NUMBERING_SYSTEM_LANG_VW B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ?) NUMBERING_SYSTEM_DESC, PATIENT_NAME, (SELECT  MP_CALCULATE_AGE_YMD(DATE_OF_BIRTH,'YMD') FROM MP_PATIENT WHERE PATIENT_ID=?) PATIENT_AGE, SEX, ALT_ID1_NO FROM MP_PATIENT WHERE PATIENT_ID=? ");
		pstmt.setString(1,locale);
		pstmt.setString(2,tooth_numbering_system);
		pstmt.setString(3,patient_id);
		pstmt.setString(4,patient_id);
		rs=pstmt.executeQuery();
		while(rs.next()){
			numbering_system_desc = CommonAdapter.checkForNull(rs.getString("NUMBERING_SYSTEM_DESC"));
			patientName = CommonAdapter.checkForNull(rs.getString("PATIENT_NAME")); /*CommonAdapter.checkForNull(rs.getString("FIRST_NAME")) + " " + CommonAdapter.checkForNull(rs.getString("SECOND_NAME")) + " " + CommonAdapter.checkForNull(rs.getString("FAMILY_NAME")) + " " + CommonAdapter.checkForNull(rs.getString("NAME_SUFFIX"));*/
			currentAgeOfPatient = CommonAdapter.checkForNull(rs.getString("PATIENT_AGE"));
			gender = CommonAdapter.checkForNull(rs.getString("SEX"));
			hospital_number = CommonAdapter.checkForNull(rs.getString("ALT_ID1_NO"));
		}

		if(gender.equals("F")){
			gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}else{
			gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels"); 		
		}
		

    	content.append("<title>"+dental_chart_print_preview_legend+"</title>");
		content.append("<HTML><HEAD><link rel='StyleSheet' href='../../eCommon/html/"+sStyle+"' type='text/css'/>");
		
		//content.append("<style>TABLE{BACKGROUND-COLOR:#CACEF9;table-layout:fixed;}TD{BACKGROUND-COLOR:white;border-color:#999999}TD.OTHER{	BACKGROUND-COLOR:#D7E6F9;COLOR:navy;FONT-SIZE: 8pt;TEXT-ALIGN: LEFT;}TD.ARCH{BACKGROUND-COLOR:#99ddee;COLOR:navy;FONT-SIZE: 8pt; TEXT-ALIGN: LEFT;}TD.QUADRANT{BACKGROUND-COLOR:#CCECFF;COLOR:navy;FONT-SIZE: 8pt;TEXT-ALIGN: LEFT;WIDTH:150px;}.label{COLOR:navy;  FONT-SIZE: 8pt;TEXT-ALIGN: CENTER;  FONT-WEIGHT: bolder;}@media print {input#printButton {display: none;}}@media print{input#closeButton {display:none;}}@media print{input#dent_comm {border:0;}th {  solid #666666; }} </style>");
		//content.append("<style>TABLE{BACKGROUND-COLOR:#CACEF9;}TD{BACKGROUND-COLOR:white;border-color:#999999}TD.OTHER{	BACKGROUND-COLOR:#D7E6F9;COLOR:navy;FONT-SIZE: 8pt;TEXT-ALIGN: LEFT;}TD.ARCH{BACKGROUND-COLOR:#99ddee;COLOR:navy;FONT-SIZE: 8pt; TEXT-ALIGN: LEFT;}TD.QUADRANT{BACKGROUND-COLOR:#CCECFF;COLOR:navy;FONT-SIZE: 8pt;TEXT-ALIGN: LEFT;}.label{COLOR:navy;  FONT-SIZE: 8pt;TEXT-ALIGN: CENTER;  FONT-WEIGHT: bolder;} @media print {input#printButton {display: none;}}@media print{input#closeButton {display:none;}}@media print{input#dent_comm {border:0;}}th {	COLOR: white ;	height:18px; position:relative;	background-color:#83AAB4;  border:1px solid #666666;	font-family: Verdana;	font-size: 8pt;	font-weight:bold; BORDER-LEFT-COLOR: #363636; BORDER-RIGHT-COLOR: #363636; 	 border-top-color: #838383; 	 border-bottom-color: #838383; } </style>");
		//content.append("<style>TABLE{BACKGROUND-COLOR:#CACEF9;}TD{BACKGROUND-COLOR:white;border-color:#999999}TD.OTHER{	BACKGROUND-COLOR:#D7E6F9;COLOR:navy;FONT-SIZE: 8pt;TEXT-ALIGN: LEFT;}TD.ARCH{BACKGROUND-COLOR:#99ddee;COLOR:navy;FONT-SIZE: 8pt; TEXT-ALIGN: LEFT;}TD.QUADRANT{BACKGROUND-COLOR:#CCECFF;COLOR:navy;FONT-SIZE: 8pt;TEXT-ALIGN: LEFT;}.label{COLOR:navy;  FONT-SIZE: 8pt;TEXT-ALIGN: CENTER;  FONT-WEIGHT: bolder;} @media print {input#printButton {display: none;}}@media print{input#closeButton {display:none;}}@media print{input#dent_comm {border:0;}}@media print{TD {font-size:10px; margin-right:10px;margin-left:10px; }} th {	  border:1px solid #666666; }TEXTAREA{white-space:normal;} </style>");
		content.append("<style>TABLE{BACKGROUND-COLOR:#CACEF9;}TD{BACKGROUND-COLOR:white;border-color:#999999}TD.OTHER{	BACKGROUND-COLOR:#D7E6F9;COLOR:navy;FONT-SIZE: 8pt;TEXT-ALIGN: LEFT;}TD.ARCH{BACKGROUND-COLOR:#99ddee;COLOR:navy;FONT-SIZE: 8pt; TEXT-ALIGN: LEFT;}TD.QUADRANT{BACKGROUND-COLOR:#CCECFF;COLOR:navy;FONT-SIZE: 8pt;TEXT-ALIGN: LEFT;}.label{COLOR:navy;  FONT-SIZE: 8pt;TEXT-ALIGN: CENTER;  FONT-WEIGHT: bolder;} @media print {input#printButton {display: none;}}@media print{input#closeButton {display:none;}}@media print{input#dent_comm {border:0;}{page-break-after:auto}@media print{TD {font-size:10px;}} th {	  border:1px solid #666666; }TEXTAREA{white-space:normal;} </style>");
		
		content.append("<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript' ></script><script language='javascript' src='../../eOH/js/DentalTreatment.js'></script><script language='javascript' src='../../eOH/js/HistDentalChart.js'></script><script language='javascript' src='../../eOH/js/PrintChart.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD>");

		content.append("<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'><form name='dentalChartPrintForm' id='dentalChartPrintForm'><input type='hidden' name='teethClickedOn' id='teethClickedOn' value=''>");

	
		//content.append("<div id='printme'>");
		//content.append("<table width='100%' border='3'><tr>");
		//content.append("<table width='99%' border='0'><tr><td align='left'><input type='button' class='button' name='' id='' value='Close' onclick='javascript:window.close();'>&nbsp;<input type='button' class='button' name='' id='' value='Print' onclick='javascript:print();'>	</td></tr></table>");
		//content.append("<table width='99%' border='0'><tr><td align='left'><input type='button' class='button' name='' id='' value='Close' onclick='javascript:window.close();'>&nbsp;<input type='button' class='button' name='' id='' value='Print' onclick='javascript:printCurrentWindow();'>	</td></tr></table>");
		content.append("<table width='99%' border='0' cellspacing='0' cellpadding='0'><tr><td align='left'><input type='button' id='printButton' class='button' name='' id='' value='Print' onclick='javascript:printCurrentWindow();'>&nbsp;<input type='button' id='closeButton' class='button' name='' id='' value='Close' onclick='javascript:window.close();'></td></tr></table>");
		
		
		//content.append("<table width='50%' border='0' cellspacing='0' cellpadding='0'><tr><td align='left'><img border='0' src='../../eCommon/images/orgLogo.gif'/></td><td class = 'CAGROUPHEADING' style='text-align:left'>Dental Department</td></tr><tr><td></td><td class = 'CAGROUPHEADING' style='text-align:left'>Siriraj Hospital</td></tr></table>");
		content.append("<br></br>");
		//content.append("<table width=100%' border='0' cellspacing='0' cellpadding='0'><tr><td align='left' width='10%'><img border='0' src='../../eCommon/images/orgLogo.gif'/></td><td class = 'CAGROUPHEADING' style='text-align:left'> Dental Department </td><td></td><td></td><td></td><td class = 'CAGROUPHEADING' style='text-align:left' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Patient Name : "+patientName+"</td></tr><tr><td></td><td class = 'CAGROUPHEADING' style='text-align:left'>Siriraj Hospital</td><td></td><td></td><td></td><td class = 'CAGROUPHEADING' style='text-align:left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; HN : "+patient_id+"&nbsp;&nbsp;  Age : "+currentAgeOfPatient+"  &nbsp;&nbsp;   Gender : "+gender+"&nbsp;</td></tr></table>");
		content.append("<table width=100%' border='0' cellspacing='0' cellpadding='0'><tr><td align='left' width='10%'><img border='0' src='../../eCommon/images/orgLogo.gif'/ ></td><td width='20%' style='text-align:left'><b>"+dentist_department_legend+"</b></td><td></td><td></td><td></td><td style='text-align:left' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b>"+patient_name_legend+" : </b>"+patientName+"</td></tr><tr><td></td><td style='text-align:left'><b>"+facility_name+"</b></td><td></td><td></td><td></td><td style='text-align:left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b>"+hn_legend+" : </b>"+patient_id+"&nbsp;&nbsp; <b>"+age_legend+" : </b>"+currentAgeOfPatient+"  &nbsp;&nbsp; <b>"+gender_legend+" : </b>"+gender+"&nbsp;</td></tr></table>");
		
		
		//content.append("<table width='50%' border='0' cellspacing='0' cellpadding='0'><tr><td align='left'><img border='0' src='../../eCommon/images/orgLogo.gif'/></td><td class = 'CAGROUPHEADING' style='text-align:left'>Dental Department</td></tr><tr><td></td><td class = 'CAGROUPHEADING' style='text-align:left'>Siriraj Hospital</td></tr></table>");
		//content.append("<table width='50%' border='0' cellspacing='0' cellpadding='0'><tr><td class = 'CAGROUPHEADING' style='text-align:left'>Siriraj Hospital</td><td></td><td></td><td class = 'CAGROUPHEADING' style='text-align:left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; HN : "+hospital_number+"  Age : "+currentAgeOfPatient+"     Gender : "+gender+"</td></tr></table>");
		
		//content.append("<table width='50%' border='0' cellspacing='0' cellpadding='1'><tr><td class = 'CAGROUPHEADING'>Patient Name : </td></tr></table>");
		content.append("<br></br>");
		content.append("<HR width = '98%'>");
		content.append("<table width='99%' border='0' cellspacing='0' cellpadding='0'><tr>");
		content.append("<td style='text-align:center'><b>"+dental_condition_treatmt_chart_legend+"</b></td></tr></table>");
		content.append("<br></br>");
		//content.append("<table width='99%' border='0' cellspacing='0' cellpadding='0'><tr><td class = 'CAGROUPHEADING' style='text-align:left'>Base line Created By : </b>" +login_user+"	</td>");
		content.append("<table width='100%' border='0' cellspacing='0' cellpadding='3'><tr><td  style='text-align:left'><b>"+baseline_created_by_legend+" : </b>" +baseline_created_by+"	</td>");
		content.append("<td style='text-align:left'><b>"+period_legend+" : </b>" +chart_date +" - " + chart_closed_date +"	</td></tr>");
		content.append("<tr><td style='text-align:left'><b>"+numbering_system_legend+" : </b>" +numbering_system_desc+"	</td><td></td></tr></table>");
		
		/*content.append("<input type='button' class='button' name='Print' id='Print' value='Print' onClick='javascript:window.print();'>");
		content.append("&nbsp;&nbsp");
		content.append("<input type='button' class='button' name='Close' id='Close' value='Close' onClick='javascript:window.close();'>");  */ 
		
		//content.append("<LABEL class='LABEL' align='center'>Header</LABEL>");	 
	//	content.append("<table width='99%'  align='center'><tr class='LABEL'>Header</tr><tr><td>Dental Condition and Treatment Chart</td><td></td></tr><tr><td>Base line created by : " +  currentAgeOfPatient +"</td><td>As on :"+ chart_type_desc +"</td><td>Numbering System : " + numbering_system_desc+"</td><td></td></tr></table>");
		
		//content.append("<table width='99%'><tr><td align='left' class='button'><input type='button' class='button' name='Print' id='Print' value='Print' onClick='javascript:window.print();'></td></tr></table>");
		//content.append("<table width='99%'><tr><td align='left' class='button'><input type='button' class='button' name='Close' id='Close' value='Close' onClick='javascript:window.close();'></td></tr></table>");
		content.append("<br></br>");
		/*content.append("<table cellpadding='1' cellspacing='0' border='0' BORDERCOLOR='GRAY' >");
		content.append("<tr><td colspan='8' class='LABEL'>");
		content.append("<table cellpadding='4' cellspacing='2' border='2'><tr>");
		content.append("<td width='7%'><img border='1' style='border-color:white' id='TRUMTH' src='../../eOH/images/Trauma.gif' alt='Trauma'/></td>");
		content.append("<td width='7%'><img border='1' style='border-color:white' id='ATRARER' src='../../eOH/images/AttritionAbrationErotion.gif' alt='Attrition Abrasion Erosion'/></td>");
		content.append("<td width='7%'><img border='1' style='border-color:white' id='SUPRTH' src='../../eOH/images/SuperNumerary.gif' alt='Super Numerary'/></td>");
		content.append("<td width='7%'><img border='1' style='border-color:white' id='MISSTH' src='../../eOH/images/MissingTeeth.gif' alt='Missing Teeth' /></td>");
		content.append("<td width='7%'><img border='1' style='border-color:white' id='PARERTH' src='../../eOH/images/PartialEruption.gif' alt='Partial Eruption'/></td>");
		content.append("<td width='7%'><img border='1' style='border-color:white' id='UNERTH' src='../../eOH/images/Uneruption.gif' alt='Uneruption' /></td>");
		content.append("<td width='7%'><img border='1' style='border-color:white' id='IMPACTN' src='../../eOH/images/Impaction-Normal.gif' alt='Impaction Normal'/></td> ");
		content.append("<td width='5%'><img src='../../eOH/images/Extraction-CrownYellow.gif' alt='Extraction(Planned)'  width='18' height='16'/></td>");
		content.append("<td width='5%'><img src='../../eOH/images/Extraction-CrownGreen.gif' alt='Extraction(Performed)'  width='18' height='16'/></td>");
		content.append("<td width='5%'><img src='../../eOH/images/Implant.gif' alt='Implant' /></td>");
		content.append("<td width='5%'><img src='../../eOH/images/Denture.gif' alt='Denture'/></td>");
		content.append("<td width='5%'><img src='../../eOH/images/Bridge.gif' alt='Bridge'/></td> ");
		content.append(" <td width='5%'><img src='../../eOH/images/Ortho.gif' alt='Orthodontic Appliance'/></td>"); 
		content.append("<td width='5%'><img src='../../eOH/images/Impaction-Treatment.gif' alt='Impaction Treatment'  /></td> ");
		content.append(" <td width='5%'><img src='../../eOH/images/TRMT_Planned.gif'  alt='Tooth Treatment(Planned)'   /></td> ");
		content.append("<td width='5%'><img src='../../eOH/images/TRMT_Perf.gif'  alt='Tooth Treatment(Performed)'   /></td> ");
		content.append("</tr></table></td></tr>	</table></td>");  */

		//out.println(images.toString());
		content.append("<br><br>");
		content.append("&nbsp;&nbsp;&nbsp;");
		content.append("<table width='88%' border='1.0' cellspacing='0' cellpadding='0' align='left' valign='top'><tr><td><table width='100%' border='1.0' cellspacing='0' cellpadding='0' ><tr>");
		
		 			
		content.append("<td width='33%' class='QUADRANT' style='text-align:left' nowrap ><table border='0' width='100%'><tr><td id='COLORQ"+Q1_id+"' class='QUADRANT' style='text-align:left' nowrap >"+Q1_desc+"</td><td id='Q"+Q1_id+"' class='QUADRANT' style='text-align:left' nowrap></td></tr></table></td>");

		content.append("<td width='33%' class='ARCH' style='text-align:center' nowrap ><table border='0' width='100%'><tr><td id='COLORAU' class='ARCH' style='text-align:left' nowrap >"+upper_arch_desc+"</td><td id='AU' class='ARCH' style='text-align:left' nowrap></td></tr></table></td>");

		content.append("<td width='33%' class='QUADRANT' style='text-align:left' nowrap ><table border='0' width='100%'><tr><td id='COLORQ"+Q2_id+"' class='QUADRANT' style='text-align:left' nowrap >"+Q2_desc+"</td><td id='Q"+Q2_id+"' class='QUADRANT' style='text-align:left' nowrap></td></tr></table></td>");

		content.append("</tr></table></td></tr>");
		
		
		content.append("<tr><td valign='top'><table width='100%' border='0.85' cellspacing='0' cellpadding='0'><tr><td valign='top'><table  width='100%' border='1.0' cellpadding='0' cellspacing='0'><tr>");

		content.append("<td><table border='1.0' cellpadding='0' cellspacing='0'><tr>");

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
			sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW  B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY MIXED_DENT_TOOTH_ORDER";
		}else{
			sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND B.PERMANENT_DECIDUOUS = ?";
		}
		pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,	ResultSet.CONCUR_UPDATABLE);
		pstmt.setString(1,locale);
		pstmt.setString(2,tooth_numbering_system);
		pstmt.setString(3,permanent_deciduous_flag);
		rs=pstmt.executeQuery();
		k=1;
		z=32;

		while(rs.next()){
			if(k<=8){
				tooth_sn = rs.getString("TOOTH_NO");
				tooth_num = rs.getString("TOOTH_NUM");
				tooth_name = rs.getString("TOOTH_NAME");
				mapped_tooth_string = rs.getString("MAPPED_TOOTH_NO");
				if(mapped_tooth_string != null){
					mapped_tooth_no = Integer.parseInt(mapped_tooth_string);
				}
				
				if(permanent_deciduous_flag.equals("P")){
					if(mixed_dentition_YN.equals("Y")){
						if(k == 1){
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
						
						}
						else if(k!=1 && k<=3){
							content.append("<td id ='decith_table"+k+"' align='center'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td id='R"+k+ "'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td id='T"+k+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border='0.85' cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");

						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td id='R"+tooth_sn+ "' align='center' background-color='red'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0.85' usemap='#MapRUR" + k + "' /></div></td></tr>");
						
							content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0.85' usemap= '#MapTUR1'  /></div></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");
						
							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border='0.85' cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");
							
						}
					}
					else if(mixed_dentition_YN.equals("N")){
					/*	content.append("<td id ='decith_table"+tooth_sn+"'><table border='0.85' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0.85' usemap='#MapRUR" + k + "'  /></div></td></tr>");

						
						content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0.85' usemap= '#MapTUR1'  /></div></td></tr>");

						content.append("<tr><td id='check_num"+tooth_sn+"' align='center'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");
						
						content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border='0.85' cellpadding=0 cellspacing=0><tr><td  width='45'  >&nbsp;</td></tr></table></td></tr></table></td>");	   */
						if(k == 1){ //Remove Images for 3rd Molars(Extreame Teeth)
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");
						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0' ><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0.85' usemap='#MapRUR" + k + "'  /></div></td></tr>");
							
							content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0.85' usemap= '#MapTUR1' /></div></td></tr>");
						}

						content.append("<tr><td id='check_num"+tooth_sn+"' align='center'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");
												
						content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0.85 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
					}
				}
				else if(permanent_deciduous_flag.equals("D")){
					
					if(mixed_dentition_YN.equals("Y")){
						if(k == 1){
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
						
						}
						else if(k!=1 && k<=3){
							content.append("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td id='R"+tooth_sn+ "'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border='0.85' cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
						}
						else{
							if(k==4 || k==5){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R3.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR3' /></div></td></tr>");

								content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
							}
							else{
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' /></div></td></tr>");

								content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
							}
						}
					}else if(mixed_dentition_YN.equals("N")){
						while(mapped_tooth_no != k){
							content.append("<td><table border='0.85' cellpadding='0' cellspacing='0'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");

							k++;
							z--;
						}
						if(k==4 || k==5){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R3.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR3'/></div></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1'/></div></td></tr>");
							
							content.append("<tr><td id='check_num"+tooth_sn+"' align='center'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'>					</td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1'/></div></td></tr>");
							
							content.append("<tr><td id='check_num"+tooth_sn+"' align='center'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
						}
					}
				}
				k++;
			}
			else{
				rs.previous();
				break;
			}
		}

		content.append("</tr></table></td></tr></table></td>");
		content.append("<td valign='top'><table  width='100%' border='1.0' cellpadding='0' cellspacing='0'><tr><td><table  width='100%' border='1.0' cellpadding='0' cellspacing='0'><tr>");

		while(rs.next()){
			tooth_sn = rs.getString("TOOTH_NO");
			tooth_num = rs.getString("TOOTH_NUM");
			tooth_name = rs.getString("TOOTH_NAME");
			mapped_tooth_string = rs.getString("MAPPED_TOOTH_NO");
			if(mapped_tooth_string != null){
				mapped_tooth_no = Integer.parseInt(mapped_tooth_string);
			}
			if(k<=16){
				if(permanent_deciduous_flag.equals("P")){
					if(mixed_dentition_YN.equals("Y")){
						if(k == 16){
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
						
						}
						else if(k!=16 && k>=14){
							content.append("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td id='R"+tooth_sn+ "'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border='0.85' cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");
						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0.85' usemap='#MapRUR" + k + "'  /></div></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0.85'  /></div></td></tr>");

							content.append("<tr><td id='check_num"+tooth_sn+"' align='center' >" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border='0.85' cellpadding=0 cellspacing=0><tr><td  width='45'  >&nbsp;</td></tr></table></td></tr></table></td>");
						}
					}
					else if(mixed_dentition_YN.equals("N")){
						if(k == 16){ //Remove Images for 3rd Molars(Extreame Teeth)
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");
						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'/></div></td></tr>");
						}
							
						content.append("<tr><td id='check_num"+tooth_sn+"' align='center' >" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");
						
						content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
					}
				}
				else if(permanent_deciduous_flag.equals("D")){
					if(mixed_dentition_YN.equals("Y")){
						if(k == 16){
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
						
						}
						else if(k!=16 && k>=14){
							content.append("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td id='R"+tooth_sn+ "'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'  >&nbsp;</td></tr></table></td></tr></table></td>");
						}
						else{
							if(k==12 || k==13){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R14.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR14' /></div></td></tr>");

								content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'/></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");
								
								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");
							}
							else{
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");

								content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");
								
								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
							}
						}
					}else if(mixed_dentition_YN.equals("N")){
						if(mapped_tooth_no == k){
							if(k==12 || k==13){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R14.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR14' /></div></td></tr>");

								content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");
								
								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
							}
							else{
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");

								content.append("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");
								
								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
							}

						}else{
							content.append("<td><table border='0' cellpadding='0' cellspacing='0'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");

							z--;
						}
					}
				}
				k++;
			}
			else{
				break;
			}
		}

		content.append("</tr></table></td></tr></table></td>");
		content.append("</tr></table></td></tr>");
		content.append("<tr><td valign='top'><table width='100%' border='0.85' cellspacing='0' cellpadding='0'><tr><td valign='top'><table  width='100%' border='1.0' cellpadding='0' cellspacing='0'><tr><td><table border='1.0' cellpadding='0' cellspacing='0'><tr>");

		//LOGIC FOR DISPLAYING LOWER RIGHT QUADRANT OF DENTAL CHART
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
			sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW  B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY MIXED_DENT_TOOTH_ORDER DESC";
		}else{
			sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW  B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND B.PERMANENT_DECIDUOUS = ? ORDER BY B.TOOTH_NO DESC";
		}
		pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,	ResultSet.CONCUR_UPDATABLE);
		pstmt.setString(1,locale);
		pstmt.setString(2,tooth_numbering_system);
		pstmt.setString(3,permanent_deciduous_flag);
		rs=pstmt.executeQuery();

		k=32;

		while(rs.next()){
			tooth_sn = rs.getString("TOOTH_NO");
			tooth_num = rs.getString("TOOTH_NUM");
			tooth_name = rs.getString("TOOTH_NAME");
			mapped_tooth_string = rs.getString("MAPPED_TOOTH_NO");
			if(mapped_tooth_string != null){
				mapped_tooth_no = Integer.parseInt(mapped_tooth_string);
			}
			if(k>=25){
				if(permanent_deciduous_flag.equals("P")){
					if(mixed_dentition_YN.equals("Y")){
						if(k == 32){
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
							
						}
						else if(k!=32 && k>=30){
							content.append("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+ "'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'  >&nbsp;</td></tr></table></td></tr></table></td>");
						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0.85'/></div></td></tr>");
						
							content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0.85' usemap='#MapRUR" + k + "' /></div></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
						}
					}
					else if(mixed_dentition_YN.equals("N")){
						if(k == 32){//Remove Images for 3rd Molars(Extreame Teeth)
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");
						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' /></div></td></tr>");
							
							content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");
						}

						content.append("<tr><td id='check_num"+tooth_sn+"' align='center' >" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

						content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
					}
				}
				else if(permanent_deciduous_flag.equals("D")){
					if(mixed_dentition_YN.equals("Y")){
						if(k == 32){
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
							
						}
						else if(k!=32 && k>=30){
							content.append("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+ "'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");
						}
						else{
							if(k==29 || k==28){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'/></div></td></tr>");

								content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R30.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR30' /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");	
							}
							else{
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' /></div></td></tr>");

								content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");				
							}
						}
					}else if(mixed_dentition_YN.equals("N")){
						while(mapped_tooth_no != k){
							content.append("<td><table border='0.85' cellpadding='0' cellspacing='0'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");

							k--;
							z--;
						}

						if(k==29 || k==28){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'/></div></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R30.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR30' /></div></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
						}else{
							//content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'/></div></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
						}
					}
				}
				k--;
			}
			else{
				rs.previous();
				break;
			}
		}
		content.append("</tr></table></td></tr></table></td>");
		content.append("<td valign='top'><table  width='100%' border='1.0' cellpadding='0' cellspacing='0'><tr><td><table  width='100%' border='1.0' cellpadding='0' cellspacing='0'><tr>");

		while(rs.next()){
			tooth_sn = rs.getString("TOOTH_NO");
			tooth_num = rs.getString("TOOTH_NUM");
			tooth_name = rs.getString("TOOTH_NAME");
			mapped_tooth_string = rs.getString("MAPPED_TOOTH_NO");
			if(mapped_tooth_string != null){
				mapped_tooth_no = Integer.parseInt(mapped_tooth_string);
			}
			if(k>=17){
				if(permanent_deciduous_flag.equals("P")){
					if(mixed_dentition_YN.equals("Y")){
						if(k == 17){
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
							
						}
						else if(k!=17 && k<=19){
							content.append("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+ "'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0.0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");
						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"'  border='0.85' /></div></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0.85' usemap='#MapRUR" + k + "' /></div></td></tr>");

							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0.0 cellpadding=0 cellspacing=0><tr><td  width='45' >&nbsp;</td></tr></table></td></tr></table></td>");
						}
					}
					else if(mixed_dentition_YN.equals("N")){
						if(k == 17){//Remove Images for 3rd Molars(Extreame Teeth)
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

						}
						else{
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"'  border='0'/></div></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");
							
						}
						content.append("<tr><td id='check_num"+tooth_sn+"' align='center' >" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

						content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
					}
				}
				else if(permanent_deciduous_flag.equals("D")){
					if(mixed_dentition_YN.equals("Y")){
						if(k == 17){
							content.append("<td id ='decith_table"+tooth_sn+"'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
							
						}
						else if(k!=17 && k<=19){
							content.append("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0.85' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+ "'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td id='R"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");


							content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

							content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
						}
						else{
							if(k==20 || k==21){ //Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' /></div></td></tr>");

								content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R19.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR19' /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
							}
							else{
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' /></div></td></tr>");

								content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "'/></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
							}
						}
					}else if(mixed_dentition_YN.equals("N")){
						if(mapped_tooth_no == k){
							if(k==20 || k==21){ //Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' /></div></td></tr>");

								content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R19.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR19' /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
							}
							else{
								content.append("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='0' cellspacing='0'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0'/></div></td></tr>");

								content.append("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' /></div></td></tr>");

								content.append("<tr><td align='center' id='check_num"+tooth_sn+"'>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'></td></tr>");

								content.append("<tr><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>&nbsp;</td></tr></table></td></tr></table></td>");
							}
						}
						else{
							content.append("<td><table border='0' cellpadding='0' cellspacing='0'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

							content.append("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

							content.append("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
						}
					}
				}
				k--;
			}
			else{
				break;
			}
		}

		content.append("</tr></table></td></tr></table></td></tr></table></td></tr>");
		
		content.append("<tr><td><table width='100%' border='1.0' cellspacing='0' cellpadding='0'><tr>");
	
		content.append("<td width='33%' class='QUADRANT' style='text-align:left' nowrap ><table border=0 width='100%'><tr><td id='COLORQ"+Q4_id+"' class='QUADRANT' style='text-align:left' nowrap >"+Q4_desc+"</td><td id='Q"+Q4_id+"' class='QUADRANT' style='text-align:left' nowrap></td></tr></table></td>");

		content.append("<td width='33%' class='ARCH' style='text-align:center' nowrap ><table border=0 width='100%'><tr><td id='COLORAL' class='ARCH' style='text-align:left' nowrap >"+lower_arch_desc+"</td><td id='AL' class='ARCH' style='text-align:left' nowrap></td></tr></table></td>");

		content.append("<td width='33%' class='QUADRANT' style='text-align:left' nowrap ><table border=0 width='100%'><tr><td id='COLORQ"+Q3_id+"' class='QUADRANT' style='text-align:left' nowrap >"+Q3_desc+"</td><td id='Q"+Q3_id+"' class='QUADRANT' style='text-align:left' nowrap></td></tr></table></td>");

		content.append("</tr></table></td></tr></table></td></tr></table>");

		//content.append(newLine);
		//content.append("<br><br>");

		//content.append("<table width='100%' border='0.85' cellspacing='0' cellpadding='0' align='center' valign='top'>");
		//content.append("<tr><td class='CAGROUPHEADING' colspan='2'>Task Description</td></tr>");
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		/*pstmt_result_entry=con.prepareStatement("SELECT DISCR_MSR_PANEL_ID, DISCR_MSR_ID, (SELECT D.SHORT_DESC FROM AM_DISCR_MSR D WHERE D.DISCR_MSR_ID = A.DISCR_MSR_ID) DISCR_MSR_DESC, RESULT_NUM, RESULT_NUM_UOM, (SELECT U.SHORT_DESC FROM AM_UOM U WHERE U.UOM_CODE = A.RESULT_NUM_UOM) RESULT_UOM_DESC, RESULT_STR, RESULT_DATA FROM OR_RESULT_DETAIL A WHERE ORDER_ID = ? AND LINE_SRL_NO = ? ORDER BY REPORT_SRL_NO, LINE_SRL_NO, SRL_NO");
		
		pstmt=con.prepareStatement("SELECT TASK_DESC, PERFORMED_DATE,(SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG WHERE PRACTITIONER_ID=A.PRACTITIONER_ID AND LANGUAGE_ID = ?) PRACTITIONER_NAME, A.ORDER_ID, A.ORDER_LINE_NUM FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS B WHERE A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID = ? AND A.CHART_NUM =? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE=? AND A.TASK_CODE = B.TASK_CODE ORDER BY CHART_NUM, CHART_LINE_NUM");

		String task_order_id = "";
		String task_order_line_num = "";
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,patient_id);
		pstmt.setString(4,chart_num);
		pstmt.setString(5,chart_line_num);
		pstmt.setString(6,trmt_code);
		rs=pstmt.executeQuery();
		while(rs.next()){
			task_desc = CommonAdapter.checkForNull(rs.getString("TASK_DESC"));
			performed_date = CommonAdapter.checkForNull(rs.getString("PERFORMED_DATE"));
			practitioner_name = CommonAdapter.checkForNull(rs.getString("PRACTITIONER_NAME"));
			task_order_id = CommonAdapter.checkForNull(rs.getString("ORDER_ID"));
			task_order_line_num = CommonAdapter.checkForNull(rs.getString("ORDER_LINE_NUM"));

			content.append("<tr><td class='CAGROUPHEADING' colspan='2'><a name='"+task_desc+"'>Task:"+task_desc+"</a></td></tr>");
			content.append("<tr><td>Performed Date:"+performed_date+"</td><td>Performed By:"+practitioner_name+"</td></tr>");
			content.append("<tr><td colspan='2'>&nbsp;</td></tr>");

			content.append("<tr><td class='CAGROUPHEADING' colspan='2'>Result</td></tr>");
			if(rs_result_entry != null) rs_result_entry.close();

			content.append("<tr><td colspan='2'>");
			//Get tHe Result Entry data for the task
			pstmt_result_entry.setString(1,task_order_id);
			pstmt_result_entry.setString(2,task_order_line_num);
			
			rs_result_entry=pstmt_result_entry.executeQuery();

			while(rs_result_entry.next()){
				discr_msr_panel_id = CommonAdapter.checkForNull(rs_result_entry.getString("DISCR_MSR_PANEL_ID"));
				discr_msr_desc = CommonAdapter.checkForNull(rs_result_entry.getString("DISCR_MSR_DESC")); 
				result_num = CommonAdapter.checkForNull(rs_result_entry.getString("RESULT_NUM")); 
				result_uom_desc = CommonAdapter.checkForNull(rs_result_entry.getString("RESULT_UOM_DESC")); 
				result_str = CommonAdapter.checkForNull(rs_result_entry.getString("RESULT_STR")); 
				clob_result_text = rs_result_entry.getClob("RESULT_DATA");
			
				if(!discr_msr_panel_id.equals("")){
					content.append(discr_msr_desc+":");
				}

				if(!result_num.equals("")){
					content.append(result_num);
					content.append(result_uom_desc);
				}
				else if(!result_str.equals("")){
					content.append(result_str);
				}
				else{
					if(clob_result_text!=null){
						bf_content_reader = new java.io.BufferedReader(clob_result_text.getCharacterStream());
						char[] arr_result_text = new char[(int)clob_result_text.length()];
						bf_content_reader.read(arr_result_text,0,(int)clob_result_text.length());
						result_text = new String(arr_result_text);
						content.append(result_text);
						bf_content_reader.close();
					}
				}
				
			}
			content.append("</td></tr>");
			content.append("<tr><td colspan='2'>&nbsp;</td></tr>");
			content.append("<tr><td colspan='2'>&nbsp;</td></tr>");
		}  */
		
	
		content.append("</table>");
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		//if(pstmt_result_entry != null) pstmt_result_entry.close();

		
		
		//content.append("<input type='hidden' name='locale' id='locale' value="+locale+" ><input type='hidden' name='patient_id' id='patient_id' value="+patient_id+" ><input type='hidden' name='encounter_id' id='encounter_id' value="+encounter_id+" ><input type='hidden' name='facility_id' id='facility_id' value="+facility_id+" ><input type='hidden' name='chart_num' id='chart_num' value="+chart_num+" ><input type='hidden' name='header_tab' id='header_tab' value="+header_tab+" ><input type='hidden' name='mixed_dentition_YN' id='mixed_dentition_YN' value="+mixed_dentition_YN+" ><input type='hidden' name='tooth_numbering_system' id='tooth_numbering_system' value="+tooth_numbering_system+" ><input type='hidden' name='permanent_deciduous_flag' id='permanent_deciduous_flag' value="+permanent_deciduous_flag+" ><input type='hidden' name='chart_line_num' id='chart_line_num' value="+chart_line_num+" ><input type='hidden' name='applyTrmts' id='applyTrmts' value="+applyTrmts+" >");
		//Commented and Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
		//content.append("<input type='hidden' name='locale' id='locale' value="+locale+" ><input type='hidden' name='patient_id' id='patient_id' value="+patient_id+" ><input type='hidden' name='facility_id' id='facility_id' value="+facility_id+" ><input type='hidden' name='chart_num' id='chart_num' value="+chart_num+" ><input type='hidden' name='header_tab' id='header_tab' value="+header_tab+" ><input type='hidden' name='mixed_dentition_YN' id='mixed_dentition_YN' value="+mixed_dentition_YN+" ><input type='hidden' name='tooth_numbering_system' id='tooth_numbering_system' value="+tooth_numbering_system+" ><input type='hidden' name='permanent_deciduous_flag' id='permanent_deciduous_flag' value="+permanent_deciduous_flag+" ><input type='hidden' name='chart_line_num' id='chart_line_num' value="+chart_line_num+" >");
		//content.append("<input type='hidden' name='locale' id='locale' value="+locale+" ><input type='hidden' name='patient_id' id='patient_id' value="+patient_id+" ><input type='hidden' name='facility_id' id='facility_id' value="+facility_id+" ><input type='hidden' name='chart_num' id='chart_num' value="+chart_num+" ><input type='hidden' name='header_tab' id='header_tab' value="+header_tab+" ><input type='hidden' name='mixed_dentition_YN' id='mixed_dentition_YN' value="+mixed_dentition_YN+" ><input type='hidden' name='tooth_numbering_system' id='tooth_numbering_system' value="+tooth_numbering_system+" ><input type='hidden' name='permanent_deciduous_flag' id='permanent_deciduous_flag' value="+permanent_deciduous_flag+" ><input type='hidden' name='chart_line_num' id='chart_line_num' value="+chart_line_num+" ><input type='hidden' name='oh_chart_level' id='oh_chart_level' value="+oh_chart_level+" >");
		//content.append("<input type='hidden' name='locale' id='locale' value="+locale+" ><input type='hidden' name='patient_id' id='patient_id' value="+patient_id+" ><input type='hidden' name='facility_id' id='facility_id' value="+facility_id+" ><input type='hidden' name='chart_num' id='chart_num' value="+chart_num+" ><input type='hidden' name='mixed_dentition_YN' id='mixed_dentition_YN' value="+mixed_dentition_YN+" ><input type='hidden' name='tooth_numbering_system' id='tooth_numbering_system' value="+tooth_numbering_system+" ><input type='hidden' name='permanent_deciduous_flag' id='permanent_deciduous_flag' value="+permanent_deciduous_flag+" ><input type='hidden' name='oh_chart_level' id='oh_chart_level' value="+oh_chart_level+" ><input type='hidden' name='asOnDatePrint' id='asOnDatePrint' value="+asOnDatePrint+" ><input type='hidden' name='other_chart_facility_id' id='other_chart_facility_id' value="+other_chart_facility_id+" ><input type='hidden' name='baseline_chart_yn' id='baseline_chart_yn' value="+baseline_chart_yn+" ><input type='hidden' name='dentist_comments' id='dentist_comments' value="+dentist_comments+" >");
		//
		
		//content.append("</form>");
		
		content.append("<br></br><br></br>");
		//images.append("<td width='15%' valign='top'>");
		images.append("<br></br><br></br><br></br><br></br><br></br><br></br><br></br></br><br></br><br></br>");
		/*images.append("<table width='88%' cellpadding='0' cellspacing='0' border='2' BORDERCOLOR='BLACK'  >");
		images.append("<tr><td colspan='8' class='LABEL'>");  */
		images.append("<table width='88%' cellpadding='2' cellspacing='2' border='1'><tr>");
		images.append("<td width='7%'><img border='1' style='border-color:white' id='TRUMTH' src='../../eOH/images/Trauma.gif'/>"+ " - " + trauma_legend+" </td>");
		images.append("<td width='7%'><img border='1' style='border-color:white' id='ATRARER' src='../../eOH/images/AttritionAbrationErotion.gif'/>"+ " - " + attrition_abrasion_erosion_legend+ " </td>");
		images.append("<td width='7%'><img border='1' style='border-color:white' id='SUPRTH' src='../../eOH/images/SuperNumerary.gif'/>"+ " - " + super_numerary_legend+ " </td>");
		images.append("<td width='7%'><img border='1' style='border-color:white' id='MISSTH' src='../../eOH/images/MissingTeeth.gif'/>"+ " - " + missing_teeth_legend+ "</td>");
		images.append("<td width='7%'><img border='1' style='border-color:white' id='PARERTH' src='../../eOH/images/PartialEruption.gif'/>"+ " - " + partial_eruption_legend+ "</td>");
		images.append("<td width='7%'><img border='1' style='border-color:white' id='UNERTH' src='../../eOH/images/Uneruption.gif'/>"+ " - " + uneruption_legend+ "</td>");
		images.append("<td width='7%'><img border='1' style='border-color:white' id='IMPACTN' src='../../eOH/images/Impaction-Normal.gif'/>"+ " - " + impaction_normal_legend+ " </td> ");
		images.append("<td width='7%'><img border='1' style='border-color:white' id='MOBILITY' src='../../eOH/images/Mobility.gif'/>"+ " - " + mobility_legend+ " </td> "); 
		//Addded by Sharon Crasta on 1/28/2010 for SRR20056-CRF-0498(IN010982)
		//Added to display the images for Mal position and Mal Occlusion
		images.append("<td width='7%'><img border='1' style='border-color:white' id='MALOCLN' src='../../eOH/images/MalOcclution.gif'/>"+ " - " + malocclusion_legend+ " </td> ");
		images.append("<td width='7%'><img border='1' style='border-color:white' id='MALPOSN' src='../../eOH/images/MalPosition.gif'/>"+ " - " + malposition_legend+ " </td> ");
		//End
		images.append("</tr></table>");
		/*images.append("</td></tr></table></td>");
		images.append("<td width='20%' >");
		images.append("<table width='88%' cellpadding='0' cellspacing='0' border='2' bordercolor='GRAY'><tr><td colspan='5' class='LABEL'>");*/
		images.append("<table width='88%' cellpadding='2' cellspacing='2' border='1'><tr>");						
		/*images.append("<td width='7%'><img src='../../eOH/images/Extraction-CrownYellow.gif' width='18' height='16'/>"+ " - " + extraction_planned_legend+ " </td>");
		images.append("<td width='7%'><img src='../../eOH/images/Extraction-CrownGreen.gif'   width='18' height='16'/> "+ " - " + extraction_performed_legend+ " </td>");
		images.append("<td width='7%'><img src='../../eOH/images/Implant.gif' align='left'/>"+ " - " + implant_legend+ " </td>");
		images.append("<td width='7%'><img src='../../eOH/images/Denture.gif'/ >"+ " - " + denture_legend+ " </td>");
		images.append("<td width='7%'><img src='../../eOH/images/Bridge.gif'/>"+ " - " + bridge_legend+ "  </td> ");
		images.append("<td width='7%'><img src='../../eOH/images/Ortho.gif'/>"+ " - " + ortho_legend+ " </td>"); 
		images.append("<td width='7%'><img src='../../eOH/images/Impaction-Treatment.gif'/>"+ " - " + impaction_trmt_legend+ " </td> ");
		images.append(" <td width='7%'>&nbsp;&nbsp;<img src='../../eOH/images/TRMT_Planned.gif'/>"+ " - " + tooth_trmt_planned_legend+ " </td> ");
		images.append("<td width='7%'>&nbsp;&nbsp;&nbsp;<img src='../../eOH/images/TRMT_Perf.gif'/>"+ " - " + tooth_trmt_performed_legend+ " </td> ");
		images.append("<td width='7%'><img src='../../eOH/images/CrownUpTool.gif'/>"+ " - " + crownup_legend+ " </td> ");
		images.append("<td width='7%'><img src='../../eOH/images/CrownDownTool.gif'/>"+ " - " + crowndown_legend+ " </td> ");*/
         
       
        images.append("<td width='7%'><img src='../../eOH/images/Extraction-CrownYellow.gif' width='18' height='16'/>"+ " - " + extraction_planned_legend+ " </td>");
		images.append("<td width='7%'><img src='../../eOH/images/Extraction-CrownGreen.gif'   width='18' height='16'/> "+ " - " + extraction_performed_legend+ " </td>");
		images.append(" <td width='7%'>&nbsp;&nbsp;<img src='../../eOH/images/TRMT_Planned.gif'/>"+ " - " + tooth_trmt_planned_legend+ " </td> ");
		images.append("<td width='7%'>&nbsp;&nbsp;&nbsp;<img src='../../eOH/images/TRMT_Perf.gif'/>"+ " - " + tooth_trmt_performed_legend+ " </td> ");
		images.append("<td width='7%'><img src='../../eOH/images/Ortho.gif'/>"+ " - " + ortho_legend+ " </td>"); 
		images.append("</tr></table>");

		images.append("<table width='88%' cellpadding='2' cellspacing='2' border='1'><tr>");	
		images.append("<td width='7%'><img src='../../eOH/images/Impaction-Treatment.gif'/>"+ " - " + impaction_trmt_legend+ " </td> ");
		images.append("<td width='7%'><img src='../../eOH/images/Implantindicator.gif' align='left'/>"+ " - " + implant_legend+ " </td>");
		images.append("<td width='7%'><img src='../../eOH/images/Denture.gif'/ >"+ " - " + denture_legend+ " </td>");
		images.append("<td width='7%'><img src='../../eOH/images/Bridge.gif'/>"+ " - " + bridge_legend+ "  </td> ");
		//added by parul on 05/02/2010 for CRF-442
		images.append("<td width='7%'><img src='../../eOH/images/CrownDownTool.gif'/>"+ " - " + crownup_legend+ " </td> ");
		images.append("<td width='7%'><img src='../../eOH/images/CrownUpTool.gif'/>"+ " - " + crowndown_legend+ " </td> ");

		images.append("</tr></table>");
		//images.append("</td></tr></table></td>");
		conditions.append("<br></br><br></br><br></br>");
		conditions.append("<table width='88%' cellpadding='0' cellspacing='0' border='0'><tr><td class = 'CAGROUPHEADING' style='text-align:center'>"+condition_trmt_details_legend+"</td></tr>	</table>"); 
		//content.append("<script>getImageForHistory();</script>");	
		//Sharon Crasta
		//content.append("<script>getStaticImageForHistory();</script>");	
		/*content.append("<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>");
		content.append("<table width='101.1%'><tr><td><table border=1 cellpadding=0 cellspacing=0 width='100%'><tr><td class = 'CAGROUPHEADING' style='text-align:center' colspan='7'>Conditions</th></tr>");
		content.append("<tr><th WIDTH='8%' style='text-align:center'>Tooth No</th><th WIDTH='18%' style='text-align:center'>Condition Type</th><th WIDTH='18%' style='text-align:center'>Conditions</th><th WIDTH='10%' style='text-align:center'>Date</th><th WIDTH='20%' style='text-align:center'>Remarks</th><th WIDTH='20%' style='text-align:center'>Recorded By</th>");*/ 
		
		//pstmt=con.prepareStatement("SELECT SITE_TYPE, TREATMENT_INT_EXT,LOCATION,TREATMENT_CONDITION_DATE,    A.MODIFIED_BY_ID, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN,TOOTH_NO, STATUS, STATUS DTL_STATUS,TRMT_CONDITION, CONDITION_TRMT_DESC,CONDITION_TRMT_CODE_DESC, TRMT_CATEGORY_TYPE, REMARKS , B.LONG_DESC STATUS_DESC,TYPE1, SEQ FROM(SELECT   A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT,A.LOCATION, TO_CHAR (A.TREATMENT_CONDITION_DATE, 'DD/MM/YYYY HH24:MI') TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID,A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC                         FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC        FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)                 ) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B   WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE                           AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS ,'CONDITION' TYPE1, 1 SEQ FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND E.CHART_STATUS = 'A' AND A.TREATMENT_CONDITION = 'C' UNION SELECT   A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT,A.LOCATION, TO_CHAR (A.TREATMENT_CONDITION_DATE,                  'DD/MM/YYYY HH24:MI') TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE                    WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B                         WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B    WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION,        'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE           AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC                   FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS ,'EXT TREATMENT' TYPE1, 2 SEQ FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND E.CHART_STATUS = 'A' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'E' UNION SELECT   A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT,A.LOCATION, TO_CHAR (A.TREATMENT_CONDITION_DATE,                   'DD/MM/YYYY HH24:MI') TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE                    WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B                         WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION,         'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE           AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC                  FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS ,'TREATMENTS TO DO' TYPE1, 3 SEQ FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E    WHERE A.PATIENT_ID = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND E.CHART_STATUS = 'A' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND STATUS <>'60'	UNION SELECT A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT,A.LOCATION, TO_CHAR (A.TREATMENT_CONDITION_DATE, 'DD/MM/YYYY HH24:MI') TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B  WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC                       FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS ,'TREATMENTS DONE' TYPE1, 4 SEQ FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E 		WHERE A.PATIENT_ID = ?  AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND E.CHART_STATUS = 'A'  AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND STATUS ='60')A,OR_ORDER_STATUS_CODE B	WHERE A.STATUS = b.ORDER_STATUS_TYPE(+) ORDER BY SEQ");
		//pstmt=con.prepareStatement("SELECT SITE_TYPE, TREATMENT_INT_EXT,LOCATION, TO_CHAR(TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:MI')TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN,TOOTH_NO, STATUS, STATUS DTL_STATUS,TRMT_CONDITION, CONDITION_TRMT_DESC,CONDITION_TRMT_CODE_DESC, TRMT_CATEGORY_TYPE, REMARKS , B.LONG_DESC STATUS_DESC,TYPE1, SEQ FROM(SELECT   A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT,A.LOCATION,  A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID,A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC     FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC        FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)                 ) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B   WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE                           AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS ,'CONDITION' TYPE1, 1 SEQ FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND E.CHART_STATUS = 'A' AND A.TREATMENT_CONDITION = 'C' UNION SELECT   A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT,A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC     FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS ,'EXT TREATMENT' TYPE1, 2 SEQ FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND E.CHART_STATUS = 'A' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'E' UNION SELECT   A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT,A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE                    WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B                         WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION,         'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE           AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC                  FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS ,'TREATMENTS TO DO' TYPE1, 3 SEQ FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E    WHERE A.PATIENT_ID = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND E.CHART_STATUS = 'A' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND STATUS <>'60'	UNION SELECT A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT,A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B  WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC                       FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS ,'TREATMENTS DONE' TYPE1, 4 SEQ FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E 		WHERE A.PATIENT_ID = ?  AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND E.CHART_STATUS = 'A'  AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND STATUS ='60')A,OR_ORDER_STATUS_CODE B	WHERE A.STATUS = b.ORDER_STATUS_TYPE(+) AND TREATMENT_CONDITION_DATE <= TO_DATE(?,'DD/MM/YYYY HH24:MI' )ORDER BY SEQ");
		//pstmt=con.prepareStatement("SELECT SITE_TYPE, TREATMENT_INT_EXT,LOCATION, TO_CHAR(TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:MI')TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN,TOOTH_NO, STATUS, STATUS DTL_STATUS,TRMT_CONDITION, CONDITION_TRMT_DESC,CONDITION_TRMT_CODE_DESC, TRMT_CATEGORY_TYPE, REMARKS , B.LONG_DESC STATUS_DESC,TYPE1, SEQ FROM(SELECT   A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT,A.LOCATION,  A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID,A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC     FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC        FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)                 ) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B   WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE                           AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS ,'CONDITION' TYPE1, 1 SEQ FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'C' UNION SELECT   A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT,A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC     FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS ,'EXT TREATMENT' TYPE1, 2 SEQ FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'E' UNION SELECT   A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT,A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE                    WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B                         WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION,         'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE           AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC                  FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS ,'TREATMENTS TO DO' TYPE1, 3 SEQ FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E    WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND STATUS <>'60'	UNION SELECT A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT,A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE), 'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B  WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC, DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC                       FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS ,'TREATMENTS DONE' TYPE1, 4 SEQ FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E 		WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND STATUS ='60')A,OR_ORDER_STATUS_CODE B	WHERE A.STATUS = B.ORDER_STATUS_TYPE(+) AND TREATMENT_CONDITION_DATE <= TO_DATE(? ||' 23:59','DD/MM/YYYY HH24:MI' )ORDER BY SEQ");
		if(oh_chart_level.equals("E")){
			if(baseline_chart_yn.equals("Y")){
				pstmt=con.prepareStatement("SELECT SUPER_TOOTH_NO, RETAINED_TOOTH_NO, TREATMENTS_OUTCOME, SUPER_KEY_NUM, SITE_TYPE, TREATMENT_INT_EXT, LOCATION,          DECODE(TREATMENT_INT_EXT,'E',TO_CHAR (TREATMENT_CONDITION_DATE, 'DD/MM/YYYY'),TO_CHAR (TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:MI'))  TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN,   TOOTH_NO, STATUS, DTL_STATUS, TRMT_CONDITION,CONDITION_TRMT_DESC, CONDITION_TRMT_CODE_DESC, TRMT_CATEGORY_TYPE,REMARKS, B.SHORT_DESC STATUS_DESC, TYPE1, SEQ, ARCH_DESC,QUADRANT_DESC, TREATMENT_CONDITION_DATE TRMT_COND_DATE, COND_TYPE FROM (SELECT A.SUPER_TOOTH_NO, A.RETAINED_TOOTH_NO, A.TREATMENTS_OUTCOME, A.SUPER_KEY_NUM, A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE,             A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE         FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC                         FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC         FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,         DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B                         WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B  WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS, 'CONDITION' TYPE1, 1 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E, OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB  WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'C' UNION SELECT A.SUPER_TOOTH_NO, A.RETAINED_TOOTH_NO, A.TREATMENTS_OUTCOME, A.SUPER_KEY_NUM, A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,           A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,          A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),       'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE =                 B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC         FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS, 'EXT TREATMENT' TYPE1, 2 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A,            OH_RESTORATIVE_CHART_HDR E, OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N'AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'E' UNION SELECT A.SUPER_TOOTH_NO, A.RETAINED_TOOTH_NO, A.TREATMENTS_OUTCOME, A.SUPER_KEY_NUM, A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,             A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,         A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE                   WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE(TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC           FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS, 'TREATMENTS TO DO' TYPE1,3 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E, OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID             AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E'AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND (STATUS <> (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE ='60') AND STATUS IS NOT NULL) UNION SELECT A.SUPER_TOOTH_NO, A.RETAINED_TOOTH_NO, A.TREATMENTS_OUTCOME, A.SUPER_KEY_NUM, A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE,             A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE          FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS,A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B     WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE(TREATMENT_CONDITION,           'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE           AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B   WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE, A.REMARKS, 'TREATMENTS DONE' TYPE1, 4 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E, OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE ='60') AND STATUS IS NOT NULL) A, OR_ORDER_STATUS_CODE B WHERE A.STATUS = B.ORDER_STATUS_TYPE(+) AND TREATMENT_CONDITION_DATE <= TO_DATE (? || ' 23:59', 'DD/MM/YYYY HH24:MI') ORDER BY TYPE1 ASC, TRMT_COND_DATE DESC");
		

				int index=1;
				pstmt.setString(index++,locale);
				pstmt.setString(index++,patient_id);
				pstmt.setString(index++,chart_num);
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,tooth_numbering_system);
				
				pstmt.setString(index++,locale);
				pstmt.setString(index++,patient_id);
				pstmt.setString(index++,chart_num);
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,tooth_numbering_system);
				
				
				pstmt.setString(index++,locale);
				pstmt.setString(index++,patient_id);
				pstmt.setString(index++,chart_num);
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,tooth_numbering_system);
				
				
				pstmt.setString(index++,locale);
				pstmt.setString(index++,patient_id);
				pstmt.setString(index++,chart_num);
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,asOnDatePrint);	
			}else{
			  // pstmt=con.prepareStatement("SELECT SITE_TYPE, TREATMENT_INT_EXT, LOCATION,          DECODE(TREATMENT_INT_EXT,'E',TO_CHAR (TREATMENT_CONDITION_DATE, 'DD/MM/YYYY'),TO_CHAR (TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:MI'))  TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN,   TOOTH_NO, STATUS, DTL_STATUS, TRMT_CONDITION,CONDITION_TRMT_DESC, CONDITION_TRMT_CODE_DESC, TRMT_CATEGORY_TYPE,REMARKS, B.SHORT_DESC STATUS_DESC, TYPE1, SEQ, ARCH_DESC,QUADRANT_DESC, TREATMENT_CONDITION_DATE TRMT_COND_DATE, COND_TYPE FROM (SELECT A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE,             A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE         FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC                         FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC         FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,         DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B                         WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B  WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE, A.REMARKS, 'CONDITION' TYPE1, 1 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E, OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.PATIENT_ID = ? AND A.CHART_NUM = (SELECT MAX(CHART_NUM)FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND TO_DATE(?,'DD/MM/YYYY')  BETWEEN TRUNC(CHART_DATE) AND TRUNC(NVL(CHART_CLOSE_DATE,SYSDATE))) AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'C' UNION SELECT A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,           A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,          A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),       'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE =                 B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC          FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS, 'EXT TREATMENT' TYPE1, 2 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A,            OH_RESTORATIVE_CHART_HDR E, OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.PATIENT_ID = ? AND A.CHART_NUM = (SELECT MAX(CHART_NUM)FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND TO_DATE(?,'DD/MM/YYYY')  BETWEEN TRUNC(CHART_DATE) AND TRUNC(NVL(CHART_CLOSE_DATE,SYSDATE))) AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N'AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'E' UNION SELECT A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,             A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,         A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE                   WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE(TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC           FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE, A.REMARKS, 'TREATMENTS TO DO' TYPE1,3 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E,  OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.PATIENT_ID = ? AND A.CHART_NUM = (SELECT MAX(CHART_NUM)FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND TO_DATE(?,'DD/MM/YYYY')  BETWEEN TRUNC(CHART_DATE) AND TRUNC(NVL(CHART_CLOSE_DATE,SYSDATE))) AND A.PATIENT_ID = E.PATIENT_ID             AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E'AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND (STATUS <> (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE ='60') AND STATUS IS NOT NULL) UNION SELECT A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE,             A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE          FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS,A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B     WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE(TREATMENT_CONDITION,           'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE           AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B   WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE, A.REMARKS, 'TREATMENTS DONE' TYPE1, 4 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E, OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.PATIENT_ID = ? AND A.CHART_NUM = (SELECT MAX(CHART_NUM)FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND TO_DATE(?,'DD/MM/YYYY')  BETWEEN TRUNC(CHART_DATE) AND TRUNC(NVL(CHART_CLOSE_DATE,SYSDATE))) AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE ='60') AND STATUS IS NOT NULL) A, OR_ORDER_STATUS_CODE B WHERE A.STATUS = B.ORDER_STATUS_TYPE(+) AND TREATMENT_CONDITION_DATE <= TO_DATE (? || ' 23:59', 'DD/MM/YYYY HH24:MI') ORDER BY TYPE1, TRMT_COND_DATE");
			   pstmt=con.prepareStatement("SELECT SUPER_TOOTH_NO, RETAINED_TOOTH_NO, TREATMENTS_OUTCOME, SUPER_KEY_NUM, SITE_TYPE, TREATMENT_INT_EXT, LOCATION,          DECODE(TREATMENT_INT_EXT,'E',TO_CHAR (TREATMENT_CONDITION_DATE, 'DD/MM/YYYY'),TO_CHAR (TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:MI'))  TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN,   TOOTH_NO, STATUS, DTL_STATUS, TRMT_CONDITION,CONDITION_TRMT_DESC, CONDITION_TRMT_CODE_DESC, TRMT_CATEGORY_TYPE,REMARKS, B.SHORT_DESC STATUS_DESC, TYPE1, SEQ, ARCH_DESC,QUADRANT_DESC, TREATMENT_CONDITION_DATE TRMT_COND_DATE, COND_TYPE FROM (SELECT A.SUPER_TOOTH_NO, A.RETAINED_TOOTH_NO, A.TREATMENTS_OUTCOME, A.SUPER_KEY_NUM, A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE,             A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE         FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC                         FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC         FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,         DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B                         WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B  WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE, A.REMARKS, 'CONDITION' TYPE1, 1 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E, OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'C' UNION SELECT A.SUPER_TOOTH_NO, A.RETAINED_TOOTH_NO, A.TREATMENTS_OUTCOME, A.SUPER_KEY_NUM, A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,           A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,          A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),       'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE =                 B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC          FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS, 'EXT TREATMENT' TYPE1, 2 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A,            OH_RESTORATIVE_CHART_HDR E, OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N'AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'E' UNION SELECT A.SUPER_TOOTH_NO, A.RETAINED_TOOTH_NO, A.TREATMENTS_OUTCOME, A.SUPER_KEY_NUM, A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,             A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,         A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE                   WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE(TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC           FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE, A.REMARKS, 'TREATMENTS TO DO' TYPE1,3 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E,  OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID             AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E'AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND (STATUS <> (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE ='60') AND STATUS IS NOT NULL) UNION SELECT A.SUPER_TOOTH_NO, A.RETAINED_TOOTH_NO, A.TREATMENTS_OUTCOME, A.SUPER_KEY_NUM, A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE,             A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE          FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS,A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B     WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE(TREATMENT_CONDITION,           'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE           AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B   WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE, A.REMARKS, 'TREATMENTS DONE' TYPE1, 4 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E, OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE ='60') AND STATUS IS NOT NULL) A, OR_ORDER_STATUS_CODE B WHERE A.STATUS = B.ORDER_STATUS_TYPE(+) AND TREATMENT_CONDITION_DATE <= TO_DATE (? || ' 23:59', 'DD/MM/YYYY HH24:MI') ORDER BY TYPE1 ASC, TRMT_COND_DATE DESC");
		

				int index=1;
				pstmt.setString(index++,locale);
				pstmt.setString(index++,patient_id);
				//pstmt.setString(index++,chart_num);
				pstmt.setString(index++,as_on_date_chart_num);//Added by Sridevi Joshi on 6/8/2010 for IN021890
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,tooth_numbering_system);

				pstmt.setString(index++,locale);
				pstmt.setString(index++,patient_id);
				//pstmt.setString(index++,chart_num);
				pstmt.setString(index++,as_on_date_chart_num);//Added by Sridevi Joshi on 6/8/2010 for IN021890
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,tooth_numbering_system);

				pstmt.setString(index++,locale);
				pstmt.setString(index++,patient_id);
				//pstmt.setString(index++,chart_num);
				pstmt.setString(index++,as_on_date_chart_num);//Added by Sridevi Joshi on 6/8/2010 for IN021890
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,tooth_numbering_system);

				pstmt.setString(index++,locale);
				pstmt.setString(index++,patient_id);
				//pstmt.setString(index++,chart_num);
				pstmt.setString(index++,as_on_date_chart_num);//Added by Sridevi Joshi on 6/8/2010 for IN021890
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,asOnDatePrint);
			}
		}else{
			if(baseline_chart_yn.equals("Y")){
				pstmt=con.prepareStatement("SELECT SUPER_TOOTH_NO, RETAINED_TOOTH_NO, TREATMENTS_OUTCOME, SUPER_KEY_NUM, SITE_TYPE, TREATMENT_INT_EXT, LOCATION,          DECODE(TREATMENT_INT_EXT,'E',TO_CHAR (TREATMENT_CONDITION_DATE, 'DD/MM/YYYY'),TO_CHAR (TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:MI'))  TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN,   TOOTH_NO, STATUS, DTL_STATUS, TRMT_CONDITION,CONDITION_TRMT_DESC, CONDITION_TRMT_CODE_DESC, TRMT_CATEGORY_TYPE,REMARKS, B.SHORT_DESC STATUS_DESC, TYPE1, SEQ, ARCH_DESC, QUADRANT_DESC, TREATMENT_CONDITION_DATE TRMT_COND_DATE, COND_TYPE FROM (SELECT A.SUPER_TOOTH_NO, A.RETAINED_TOOTH_NO, A.TREATMENTS_OUTCOME, A.SUPER_KEY_NUM, A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE,             A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE         FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC                         FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC         FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,         DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B                         WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B  WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,     A.TRMT_CATEGORY_TYPE, A.REMARKS, 'CONDITION' TYPE1, 1 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E, OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM  AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'C' UNION SELECT A.SUPER_TOOTH_NO, A.RETAINED_TOOTH_NO, A.TREATMENTS_OUTCOME, A.SUPER_KEY_NUM, A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,           A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,          A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),       'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE =                 B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC          FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS, 'EXT TREATMENT' TYPE1, 2 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A,            OH_RESTORATIVE_CHART_HDR E, OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N'AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'E' UNION SELECT A.SUPER_TOOTH_NO, A.RETAINED_TOOTH_NO, A.TREATMENTS_OUTCOME, A.SUPER_KEY_NUM, A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,             A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,         A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE                   WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE(TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC           FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS, 'TREATMENTS TO DO' TYPE1,3 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E,  OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID  AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E'AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND (STATUS <> (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE ='60') AND STATUS IS NOT NULL) UNION SELECT A.SUPER_TOOTH_NO, A.RETAINED_TOOTH_NO, A.TREATMENTS_OUTCOME, A.SUPER_KEY_NUM, A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE,             A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE          FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS,A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B     WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE(TREATMENT_CONDITION,           'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE           AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B   WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE, A.REMARKS, 'TREATMENTS DONE' TYPE1, 4 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E, OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE ='60') AND STATUS IS NOT NULL) A, OR_ORDER_STATUS_CODE B WHERE A.STATUS = B.ORDER_STATUS_TYPE(+) AND TREATMENT_CONDITION_DATE <= TO_DATE (? || ' 23:59', 'DD/MM/YYYY HH24:MI') ORDER BY TYPE1 ASC, TRMT_COND_DATE DESC");
		

				int index=1;
				pstmt.setString(index++,locale);
				pstmt.setString(index++,other_chart_facility_id);
				pstmt.setString(index++,patient_id);
				pstmt.setString(index++,chart_num);
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,tooth_numbering_system);

				pstmt.setString(index++,locale);
				pstmt.setString(index++,other_chart_facility_id);
				pstmt.setString(index++,patient_id);
				pstmt.setString(index++,chart_num);
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,tooth_numbering_system);

				pstmt.setString(index++,locale);
				pstmt.setString(index++,other_chart_facility_id);
				pstmt.setString(index++,patient_id);
				pstmt.setString(index++,chart_num);
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,tooth_numbering_system);

				pstmt.setString(index++,locale);
				pstmt.setString(index++,other_chart_facility_id);
				pstmt.setString(index++,patient_id);
				pstmt.setString(index++,chart_num);
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,asOnDatePrint);	
			}
			else{
			  //pstmt=con.prepareStatement("SELECT SITE_TYPE, TREATMENT_INT_EXT, LOCATION,TO_CHAR (TREATMENT_CONDITION_DATE,  'DD/MM/YYYY HH24:MI') TREATMENT_CONDITION_DATE,A.MODIFIED_BY_ID, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN,   TOOTH_NO, STATUS, STATUS DTL_STATUS, TRMT_CONDITION,CONDITION_TRMT_DESC, CONDITION_TRMT_CODE_DESC, TRMT_CATEGORY_TYPE,REMARKS, B.SHORT_DESC STATUS_DESC, TYPE1, SEQ, ARCH_QUAD_DESC FROM (SELECT A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE,             A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE         FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC                         FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC         FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,         DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B                         WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B  WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,     DECODE (SITE_TYPE, 'ARCH', (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW AV WHERE AV.LANGUAGE_ID = ? AND AV.ARCH_ID = AR.ARCH_ID AND AV.NUMBERING_SYSTEM = AR.NUMBERING_SYSTEM AND AR.NUMBERING_SYSTEM = ? AND AR.ARCH_SNO = A.ARCH_SNO), 'QUAD', (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW QDV WHERE QDV.LANGUAGE_ID = ? AND QDV.QUADRANT_ID = QB.QUADRANT_ID AND QDV.NUMBERING_SYSTEM = QB.NUMBERING_SYSTEM AND QB.NUMBERING_SYSTEM = ?   AND QB.QUADRANT_SNO = A.QUADRANT_SNO)) ARCH_QUAD_DESC,A.TRMT_CATEGORY_TYPE, A.REMARKS, 'CONDITION' TYPE1, 1 SEQ FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E, OH_ARCH AR,OH_QUADRANT QB WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = (SELECT MAX(CHART_NUM)FROM OH_RESTORATIVE_CHART_HDR WHERE A.OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND TO_DATE(?,'DD/MM/YYYY')  BETWEEN TRUNC(CHART_DATE) AND TRUNC(NVL(CHART_CLOSE_DATE,SYSDATE))) AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'C' UNION SELECT A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,           A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,          A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),       'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE =                 B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC          FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, DECODE (SITE_TYPE,'ARCH', (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW AV               WHERE AV.LANGUAGE_ID = ? AND AV.ARCH_ID = AR.ARCH_ID AND AV.NUMBERING_SYSTEM = AR.NUMBERING_SYSTEM         AND AR.NUMBERING_SYSTEM = ? AND AR.ARCH_SNO = A.ARCH_SNO), 'QUAD', (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW QDV WHERE QDV.LANGUAGE_ID = ? AND QDV.QUADRANT_ID = QB.QUADRANT_ID AND QDV.NUMBERING_SYSTEM =QB.NUMBERING_SYSTEM AND QB.NUMBERING_SYSTEM = ? AND QB.QUADRANT_SNO = A.QUADRANT_SNO)) ARCH_QUAD_DESC,       A.TRMT_CATEGORY_TYPE, A.REMARKS, 'EXT TREATMENT' TYPE1, 2 SEQ FROM OH_RESTORATIVE_CHART_DTL A,            OH_RESTORATIVE_CHART_HDR E, OH_ARCH AR,OH_QUADRANT QB WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = (SELECT MAX(CHART_NUM)FROM OH_RESTORATIVE_CHART_HDR WHERE A.OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND TO_DATE(?,'DD/MM/YYYY')  BETWEEN TRUNC(CHART_DATE) AND TRUNC(NVL(CHART_CLOSE_DATE,SYSDATE))) AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N'AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'E' UNION SELECT A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,             A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,         A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE                   WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE(TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC           FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, DECODE (SITE_TYPE,'ARCH', (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW AV                WHERE AV.LANGUAGE_ID = ? AND AV.ARCH_ID = AR.ARCH_ID AND AV.NUMBERING_SYSTEM = AR.NUMBERING_SYSTEM            AND AR.NUMBERING_SYSTEM = ? AND AR.ARCH_SNO = A.ARCH_SNO),'QUAD', (SELECT QUADRANT_DESC                       FROM OH_QUADRANT_LANG_VW QDV WHERE QDV.LANGUAGE_ID = ? AND QDV.QUADRANT_ID = QB.QUADRANT_ID AND QDV.NUMBERING_SYSTEM = QB.NUMBERING_SYSTEM AND QB.NUMBERING_SYSTEM = ? AND QB.QUADRANT_SNO = A.QUADRANT_SNO)) ARCH_QUAD_DESC,A.TRMT_CATEGORY_TYPE, A.REMARKS, 'TREATMENTS TO DO' TYPE1,3 SEQ FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E, OH_ARCH AR,OH_QUADRANT QB WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = (SELECT MAX(CHART_NUM)FROM OH_RESTORATIVE_CHART_HDR WHERE A.OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND TO_DATE(?,'DD/MM/YYYY')  BETWEEN TRUNC(CHART_DATE) AND TRUNC(NVL(CHART_CLOSE_DATE,SYSDATE))) AND A.PATIENT_ID = E.PATIENT_ID             AND A.CHART_NUM = E.CHART_NUM AND NVL (A.STATUS, 'X') != 'E'AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND (STATUS <> (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE ='60') AND STATUS IS NOT NULL) UNION SELECT A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE,             A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE          FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS,A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B     WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE(TREATMENT_CONDITION,           'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE           AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B   WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,DECODE (SITE_TYPE,'ARCH', (SELECT ARCH_DESC        FROM OH_ARCH_LANG_VW AV WHERE AV.LANGUAGE_ID = ? AND AV.ARCH_ID = AR.ARCH_ID AND AV.NUMBERING_SYSTEM =       AR.NUMBERING_SYSTEM AND AR.NUMBERING_SYSTEM = ? AND AR.ARCH_SNO = A.ARCH_SNO),'QUAD', (SELECT QUADRANT_DESC   FROM OH_QUADRANT_LANG_VW QDV WHERE QDV.LANGUAGE_ID = ? AND QDV.QUADRANT_ID = QB.QUADRANT_ID AND QDV.NUMBERING_SYSTEM = QB.NUMBERING_SYSTEM AND QB.NUMBERING_SYSTEM = ? AND QB.QUADRANT_SNO = A.QUADRANT_SNO)) ARCH_QUAD_DESC,A.TRMT_CATEGORY_TYPE, A.REMARKS, 'TREATMENTS DONE' TYPE1, 4 SEQ FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E, OH_ARCH AR, OH_QUADRANT QB WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = (SELECT MAX(CHART_NUM)FROM OH_RESTORATIVE_CHART_HDR WHERE A.OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND TO_DATE(?,'DD/MM/YYYY')  BETWEEN TRUNC(CHART_DATE) AND TRUNC(NVL(CHART_CLOSE_DATE,SYSDATE))) AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE ='60') AND STATUS IS NOT NULL) A, OR_ORDER_STATUS_CODE B WHERE A.STATUS = B.ORDER_STATUS_TYPE(+) AND TREATMENT_CONDITION_DATE <= TO_DATE (? || ' 23:59', 'DD/MM/YYYY HH24:MI') ORDER BY SEQ");
			 // pstmt=con.prepareStatement("SELECT SITE_TYPE, TREATMENT_INT_EXT, LOCATION,          DECODE(TREATMENT_INT_EXT,'E',TO_CHAR (TREATMENT_CONDITION_DATE, 'DD/MM/YYYY'),TO_CHAR (TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:MI'))  TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN,   TOOTH_NO, STATUS, DTL_STATUS, TRMT_CONDITION,CONDITION_TRMT_DESC, CONDITION_TRMT_CODE_DESC, TRMT_CATEGORY_TYPE,REMARKS, B.SHORT_DESC STATUS_DESC, TYPE1, SEQ , ARCH_DESC, QUADRANT_DESC, TREATMENT_CONDITION_DATE TRMT_COND_DATE, COND_TYPE FROM (SELECT A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE,             A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE         FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC                         FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC         FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,         DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B                         WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B  WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,     A.TRMT_CATEGORY_TYPE, A.REMARKS, 'CONDITION' TYPE1, 1 SEQ , ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E,  OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = (SELECT MAX(CHART_NUM)FROM OH_RESTORATIVE_CHART_HDR WHERE A.OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND TO_DATE(?,'DD/MM/YYYY')  BETWEEN TRUNC(CHART_DATE) AND TRUNC(NVL(CHART_CLOSE_DATE,SYSDATE))) AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM 	AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'C' UNION SELECT A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,           A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,          A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),       'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE =                 B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC          FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE, A.REMARKS, 'EXT TREATMENT' TYPE1, 2 SEQ , ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E,  OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = (SELECT MAX(CHART_NUM)FROM OH_RESTORATIVE_CHART_HDR WHERE A.OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND TO_DATE(?,'DD/MM/YYYY')  BETWEEN TRUNC(CHART_DATE) AND TRUNC(NVL(CHART_CLOSE_DATE,SYSDATE))) AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N'AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'E' UNION SELECT A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,             A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,         A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE                   WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE(TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC           FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS, 'TREATMENTS TO DO' TYPE1,3 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E,  OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = (SELECT MAX(CHART_NUM)FROM OH_RESTORATIVE_CHART_HDR WHERE A.OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND TO_DATE(?,'DD/MM/YYYY')  BETWEEN TRUNC(CHART_DATE) AND TRUNC(NVL(CHART_CLOSE_DATE,SYSDATE))) AND A.PATIENT_ID = E.PATIENT_ID             AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E'AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND (STATUS <> (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE ='60') AND STATUS IS NOT NULL) UNION SELECT A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE,             A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE          FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS,A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B     WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE(TREATMENT_CONDITION,           'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE           AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B   WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE, A.REMARKS, 'TREATMENTS DONE' TYPE1, 4 SEQ , ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E, OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = (SELECT MAX(CHART_NUM)FROM OH_RESTORATIVE_CHART_HDR WHERE A.OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND TO_DATE(?,'DD/MM/YYYY')  BETWEEN TRUNC(CHART_DATE) AND TRUNC(NVL(CHART_CLOSE_DATE,SYSDATE))) AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE ='60') AND STATUS IS NOT NULL) A, OR_ORDER_STATUS_CODE B WHERE A.STATUS = B.ORDER_STATUS_TYPE(+) AND TREATMENT_CONDITION_DATE <= TO_DATE (? || ' 23:59', 'DD/MM/YYYY HH24:MI') ORDER BY TYPE1,TRMT_COND_DATE");
			  pstmt=con.prepareStatement("SELECT SUPER_TOOTH_NO, RETAINED_TOOTH_NO, TREATMENTS_OUTCOME, SUPER_KEY_NUM, SITE_TYPE, TREATMENT_INT_EXT, LOCATION, DECODE(TREATMENT_INT_EXT,'E',TO_CHAR (TREATMENT_CONDITION_DATE, 'DD/MM/YYYY'),TO_CHAR (TREATMENT_CONDITION_DATE,'DD/MM/YYYY HH24:MI'))  TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN,   TOOTH_NO, STATUS, DTL_STATUS, TRMT_CONDITION,CONDITION_TRMT_DESC, CONDITION_TRMT_CODE_DESC, TRMT_CATEGORY_TYPE,REMARKS, B.SHORT_DESC STATUS_DESC, TYPE1, SEQ , ARCH_DESC, QUADRANT_DESC, TREATMENT_CONDITION_DATE TRMT_COND_DATE, COND_TYPE FROM (SELECT A.SUPER_TOOTH_NO, A.RETAINED_TOOTH_NO,A.TREATMENTS_OUTCOME, A.SUPER_KEY_NUM, A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE,             A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE         FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC                         FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC         FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,         DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B                         WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?), 'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B  WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,     A.TRMT_CATEGORY_TYPE, A.REMARKS, 'CONDITION' TYPE1, 1 SEQ , ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E,  OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM 	AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'C' UNION SELECT A.SUPER_TOOTH_NO, A.RETAINED_TOOTH_NO, A.TREATMENTS_OUTCOME, A.SUPER_KEY_NUM, A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,           A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,          A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION, 'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),       'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE =                 B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC          FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE, A.REMARKS, 'EXT TREATMENT' TYPE1, 2 SEQ , ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E,  OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N'AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'E' UNION SELECT A.SUPER_TOOTH_NO, A.RETAINED_TOOTH_NO, A.TREATMENTS_OUTCOME, A.SUPER_KEY_NUM, A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,             A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE, A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,         A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE                   WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS DTL_STATUS, A.TREATMENT_CONDITION, DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE(TREATMENT_CONDITION,'C', (SELECT B.CONDITION_DESC           FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC, A.TRMT_CATEGORY_TYPE, A.REMARKS, 'TREATMENTS TO DO' TYPE1,3 SEQ, ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E,  OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID             AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E'AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND (STATUS <> (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE ='60') AND STATUS IS NOT NULL) UNION SELECT A.SUPER_TOOTH_NO, A.RETAINED_TOOTH_NO, A.TREATMENTS_OUTCOME, A.SUPER_KEY_NUM, A.SITE_TYPE, A.TREATMENT_CONDITION TRMT_CONDITION,A.TREATMENT_INT_EXT, A.LOCATION, A.TREATMENT_CONDITION_DATE,             A.MODIFIED_BY_ID, A.SUPERNUMERARY_YN,A.MIXED_DENT_DECIDUOUS_YN, A.TOOTH_NO,(SELECT ORDER_STATUS_TYPE          FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS,A.STATUS DTL_STATUS, A.TREATMENT_CONDITION,DECODE (TREATMENT_CONDITION,'C', (SELECT B.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE),'T', (SELECT B.TRMT_CATEGORY_DESC FROM OH_TREATMENT_CATEGORY B     WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE)) CONDITION_TRMT_DESC,DECODE(TREATMENT_CONDITION,           'C', (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE           AND A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?),'T', (SELECT B.TRMT_DESC FROM OH_TREATMENT B   WHERE A.TRMT_CODE = B.TRMT_CODE)) CONDITION_TRMT_CODE_DESC,A.TRMT_CATEGORY_TYPE, A.REMARKS, 'TREATMENTS DONE' TYPE1, 4 SEQ , ARCH_DESC, QUADRANT_DESC, A.CONDITION_TYPE COND_TYPE FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR E, OH_ARCH_LANG_VW  AR, OH_QUADRANT_LANG_VW QB WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.ARCH_SNO  = AR.ARCH_ID(+) AND A.QUADRANT_SNO = QB.QUADRANT_SNO(+) AND AR.NUMBERING_SYSTEM(+) = ? AND AR.LANGUAGE_ID(+) = ? AND QB.LANGUAGE_ID(+) = ? AND QB.NUMBERING_SYSTEM(+) = ? AND NVL (A.STATUS, 'X') != 'E' AND NVL (A.COND_CLOSED_YN, 'N') = 'N' AND A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT = 'I' AND STATUS = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE ='60') AND STATUS IS NOT NULL) A, OR_ORDER_STATUS_CODE B WHERE A.STATUS = B.ORDER_STATUS_TYPE(+) AND TREATMENT_CONDITION_DATE <= TO_DATE (? || ' 23:59', 'DD/MM/YYYY HH24:MI') ORDER BY TYPE1 ASC, TRMT_COND_DATE DESC");
		

				int index=1;
				pstmt.setString(index++,locale);
				pstmt.setString(index++,other_chart_facility_id);
				pstmt.setString(index++,patient_id);
				//pstmt.setString(index++,chart_num);
				pstmt.setString(index++,as_on_date_chart_num);//Added by Sridevi Joshi on 6/8/2010 for IN021890
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,tooth_numbering_system);

				pstmt.setString(index++,locale);
				pstmt.setString(index++,other_chart_facility_id);
				pstmt.setString(index++,patient_id);
				//pstmt.setString(index++,chart_num);
				pstmt.setString(index++,as_on_date_chart_num);//Added by Sridevi Joshi on 6/8/2010 for IN021890
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,tooth_numbering_system);

				pstmt.setString(index++,locale);
				pstmt.setString(index++,other_chart_facility_id);
				pstmt.setString(index++,patient_id);
				//pstmt.setString(index++,chart_num);
				pstmt.setString(index++,as_on_date_chart_num);//Added by Sridevi Joshi on 6/8/2010 for IN021890
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,tooth_numbering_system);
				
				pstmt.setString(index++,locale);
				pstmt.setString(index++,other_chart_facility_id);
				pstmt.setString(index++,patient_id);
				//pstmt.setString(index++,chart_num);
				pstmt.setString(index++,as_on_date_chart_num);//Added by Sridevi Joshi on 6/8/2010 for IN021890
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,locale);
				pstmt.setString(index++,tooth_numbering_system);
				pstmt.setString(index++,asOnDatePrint);	
			}
		}
		rs=pstmt.executeQuery();
		while(rs.next()){
			site_type = checkForNull(rs.getString("SITE_TYPE"));
			desc = checkForNull(rs.getString("CONDITION_TRMT_DESC"));
			//chart_date_start_2 = com.ehis.util.DateUtils.convertDate(rs.getString("CHART_START"),"DMY","en",locale); 
			date = checkForNull(rs.getString("TREATMENT_CONDITION_DATE"));
			//date = com.ehis.util.DateUtils.convertDate(rs.getString("TREATMENT_CONDITION_DATE"),"DMY","en",locale);
			doneby = checkForNull(rs.getString("MODIFIED_BY_ID"));
			status = checkForNull(rs.getString("STATUS"));
			trmt_category_type = checkForNull(rs.getString("TRMT_CATEGORY_TYPE"));
			super_yn =  checkForNull(rs.getString("SUPERNUMERARY_YN"));
			RD_yn =  checkForNull(rs.getString("MIXED_DENT_DECIDUOUS_YN"));
			condition_trmt_code_desc =  checkForNull(rs.getString("CONDITION_TRMT_CODE_DESC"));
			dtl_status =  checkForNull(rs.getString("DTL_STATUS")); 
			remarks = checkForNull(rs.getString("REMARKS"));
			display_tooth_no = checkForNull(rs.getString("TOOTH_NO"));
			treatment_condition = checkForNull(rs.getString("TRMT_CONDITION"));
			treatment_int_ext = checkForNull(rs.getString("TREATMENT_INT_EXT"));
			location = checkForNull(rs.getString("LOCATION"));
			status_desc = checkForNull(rs.getString("STATUS_DESC"));
			arch_desc = checkForNull(rs.getString("ARCH_DESC"));
			quad_desc = checkForNull(rs.getString("QUADRANT_DESC"));
			condition_type = checkForNull(rs.getString("COND_TYPE"));
			super_key_num = checkForNull(rs.getString("SUPER_KEY_NUM"));
			trmt_outcome = checkForNull(rs.getString("TREATMENTS_OUTCOME"));
			super_tooth_no = checkForNull(rs.getString("SUPER_TOOTH_NO"));
			retained_tooth_no = checkForNull(rs.getString("RETAINED_TOOTH_NO"));

			if(trmt_outcome.equals("F")){
				trmt_outcome_falure_success = failure_legend;
			}
			else if(trmt_outcome.equals("S")){
				trmt_outcome_falure_success = success_legend;
			}
			else{
				trmt_outcome_falure_success = "";
			}
		
			 
			/*if(super_yn.equals("Y")){ //Supernumerarary Case
				//tooth_no_display = display_tooth_no+"s";
				tooth_no_display = tooth_no_display+"s";

			}
			else if(RD_yn.equals("R") || RD_yn.equals("D")){ //Retained Deciduous Case
			
				pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
				
				pstmt2.setString(1,tooth_numbering_system);
				pstmt2.setString(2,tooth_no);
				pstmt2.setString(3,PD_flag);
				rs2 = pstmt2.executeQuery();
				while(rs2.next()){
					tooth_no_display = rs2.getString("NS_TOOTH_NO");
				}
			}
			else{
				tooth_no_display = display_tooth_no;
			}  */
			if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){
				if(rs3 != null)rs3.close();
				if(pstmt3 != null)pstmt3.close();



				pstmt3 =con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO = ?")	;
				pstmt3.setString(1,tooth_numbering_system);
				pstmt3.setString(2,display_tooth_no);
				rs3 = pstmt3.executeQuery();
				while(rs3.next()){
					tooth_no_for_Mixed_Deciduous_chart = rs3.getString("NS_TOOTH_NO");
				}
				if(super_yn.equals("Y") && RD_yn.equals("M")){
					tooth_no_display = super_key_num+"(" + tooth_no_for_Mixed_Deciduous_chart +")";
				}
				else if(super_yn.equals("Y") && !RD_yn.equals("M")){ //Supernumerarary Case
					/* By Sridevi on 07/08/09 to Display tooth no for deciduous tooth for which SUPRTH is recorded*/
					//if(!(tooth_no.equals("2") ||  tooth_no.equals("3") || tooth_no.equals("14") || tooth_no.equals("15") || tooth_no.equals("18") || tooth_no.equals("19") || tooth_no.equals("30") || tooth_no.equals("31"))){
					if(!(display_tooth_no.equals("2") ||  display_tooth_no.equals("3") || display_tooth_no.equals("14") || display_tooth_no.equals("15") || display_tooth_no.equals("18") || display_tooth_no.equals("19") || display_tooth_no.equals("30") || display_tooth_no.equals("31"))){
						pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
						
						pstmt2.setString(1,tooth_numbering_system);
						//pstmt2.setString(2,tooth_no);
						pstmt2.setString(2,display_tooth_no);
						pstmt2.setString(3,PD_flag);
						rs2 = pstmt2.executeQuery();
						while(rs2.next()){
							tooth_no_display = rs2.getString("NS_TOOTH_NO");
						}

						tooth_no_display = tooth_no_display+"s";
					}
					else{ /* By Sridevi on 07/08/09 to Display tooth no for permanent tooth for which SUPRTH is recorded*/
						//tooth_no_display = display_tooth_no+"s";
						tooth_no_display = tooth_no_for_Mixed_Deciduous_chart+"s";
					}
					/* Commented by Sridevi on 07/08/09 to display Permanent tooth no after EXFOLTH--->ERUPTH--->SUPRTH
						if (RD_yn.equals("")|| RD_yn.equals(null) || RD_yn.equals("null")){
							tooth_no_display = display_tooth_no+"s";
						}else{
							tooth_no_display = tooth_no_display+"s";
						}
					*/
				}
				
				else if((RD_yn.equals("R") || RD_yn.equals("M")) && !site_type.equals("MAXFS")) {
					tooth_no_display = tooth_no_for_Mixed_Deciduous_chart;
				}
				else if(dtl_status.equals("Z")){
						//Commented by Sharon Crasta on 9/22/2009 for IN014657
						//Passed PERMANENT_DECIDUOUS as P, when RD_YN and super_yn are null 
						//pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
						pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = 'P'");
						pstmt2.setString(1,tooth_numbering_system);
						//pstmt2.setString(2,tooth_no);
						pstmt2.setString(2,display_tooth_no);
						//pstmt2.setString(3,PD_flag);
						rs2 = pstmt2.executeQuery();
						while(rs2.next()){
							tooth_no_display = rs2.getString("NS_TOOTH_NO");
						}
					 }
					else{
						if(!records_permanent_tooth){
						   	tooth_no_display = tooth_no_for_Mixed_Deciduous_chart;
						} 
						else{
							//Commented by Sharon Crasta on 9/22/2009 for IN014657
							//Passed PERMANENT_DECIDUOUS as P, when RD_YN and super_yn are null 
							//pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
							pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = 'P'");
							pstmt2.setString(1,tooth_numbering_system);
							//pstmt2.setString(2,tooth_no);
							pstmt2.setString(2,display_tooth_no);
							//pstmt2.setString(3,PD_flag);
							rs2 = pstmt2.executeQuery();
							while(rs2.next()){
								tooth_no_display = rs2.getString("NS_TOOTH_NO");
							}
						}	  
						
						/* To Display tooth no for Permanent tooth(After EXFOLTH--->ERUPTH) for conditions other than SUPRTH */
						if(tooth_no_display.equals("") || tooth_no_display.equals("null") || tooth_no_display.equals(null)){  
							//tooth_no_display = display_tooth_no;
							tooth_no_display = tooth_no_for_Mixed_Deciduous_chart;
							
						}
						

						/* By Sridevi on 07/08/09 to Display tooth no for extream tooth for conditions other than SUPRTH */
						//if((tooth_no.equals("2") ||  tooth_no.equals("3") || tooth_no.equals("14") || tooth_no.equals("15") || tooth_no.equals("18") || tooth_no.equals("19") || tooth_no.equals("30") || tooth_no.equals("31"))){
						if((display_tooth_no.equals("2") ||  display_tooth_no.equals("3") || display_tooth_no.equals("14") || display_tooth_no.equals("15") || display_tooth_no.equals("18") || display_tooth_no.equals("19") || display_tooth_no.equals("30") || display_tooth_no.equals("31"))){
							//tooth_no_display = display_tooth_no;
							tooth_no_display = tooth_no_for_Mixed_Deciduous_chart;
						}
					}
					if(display_tooth_no.equals("")){
						tooth_no_display = display_tooth_no;
					}
					if(condition_type.equals("EXFOLTH") && ( RD_yn.equals("R") || RD_yn.equals("M"))){
						records_permanent_tooth	 = true;
					}
				
			}else if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("P")){
					pstmt3 =con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO = ?")	;
					pstmt3.setString(1,tooth_numbering_system);
					pstmt3.setString(2,display_tooth_no);
					rs3 = pstmt3.executeQuery();
					while(rs3.next()){
						tooth_no_for_Mixed_Permanent_chart = rs3.getString("NS_TOOTH_NO");
					}
					
					if(super_yn.equals("Y") && RD_yn.equals("D")){//added by parul (record Deciduoud,supernum.....than trauma on same toothâ?¦Deciduous tooth no is C,super it will C,Cs â?¦.than truma tooth no is comng 6,6s )
						pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
				
							pstmt2.setString(1,tooth_numbering_system);
							//pstmt2.setString(2,tooth_no);
							pstmt2.setString(2,display_tooth_no);
							pstmt2.setString(3,PD_flag);
							rs2 = pstmt2.executeQuery();
							while(rs2.next()){
								tooth_no_display = rs2.getString("NS_TOOTH_NO");
							}
								
							//Commented by Sharon Crasta on 1/13/2010 for IN010894(SRR20056-CRF-0481) for new SUPRTH changes
							//tooth_no_display = tooth_no_display+"s";
							//tooth_no_display = "s1(" + tooth_no_display +")";
							tooth_no_display = super_key_num+"(" + tooth_no_display +")";

					}

					else if(super_yn.equals("Y")){ //Supernumerarary Case
						//tooth_no_display = display_tooth_no+"s";
						
						//Commented by Sharon Crasta on 1/13/2010 for IN010894(SRR20056-CRF-0481) for new SUPRTH changes
						//tooth_no_display = tooth_no_for_Mixed_Permanent_chart+"s";
						tooth_no_display = super_key_num+"(" + tooth_no_for_Mixed_Permanent_chart +")";

					}
					else if((RD_yn.equals("R") || RD_yn.equals("D")) && !site_type.equals("MAXFS")){
					//else if(RD_yn.equals("R") || RD_yn.equals("D")){ //Retained Deciduous Case
						pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
					
						pstmt2.setString(1,tooth_numbering_system);
						//pstmt2.setString(2,tooth_no);
						pstmt2.setString(2,display_tooth_no);
						pstmt2.setString(3,PD_flag);
						rs2 = pstmt2.executeQuery();
						while(rs2.next()){
							tooth_no_display = rs2.getString("NS_TOOTH_NO");
						}
					}
				else{
					if(!record_deciduous_tooth){
						//tooth_no_display = display_tooth_no;
						tooth_no_display = tooth_no_for_Mixed_Permanent_chart;
					}else{
						pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
					
						pstmt2.setString(1,tooth_numbering_system);
						//pstmt2.setString(2,tooth_no);
						pstmt2.setString(2,display_tooth_no);
						pstmt2.setString(3,PD_flag);
						rs2 = pstmt2.executeQuery();
						while(rs2.next()){
							tooth_no_display = rs2.getString("NS_TOOTH_NO");
						}
					}
				}
				if(condition_type.equals("DECITH")){
					record_deciduous_tooth = true;
				}
				if(condition_type.equals("EXFOLTH") && RD_yn.equals("D")) {
					record_deciduous_tooth = false;				
				}
				if(display_tooth_no.equals("")){
					tooth_no_display = display_tooth_no;
				}
				//Added by Sharon Crasta on 4/7/2010
				//Added since the tooth no display was going wrong.
				else{
					record_deciduous_tooth = false;		
				}//End
			}
			else{
				if(rs3 != null)rs3.close();
				if(pstmt3 != null)pstmt3.close();

				pstmt3 =con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO = ?")	;
				pstmt3.setString(1,tooth_numbering_system);
				pstmt3.setString(2,display_tooth_no);
				rs3 = pstmt3.executeQuery();
				while(rs3.next()){
					tooth_no_for_Permanent_chart = rs3.getString("NS_TOOTH_NO");
				}

				if(super_yn.equals("Y")){ //Supernumerarary Case
					//tooth_no_display = display_tooth_no+"s";
					//Commented by Sharon Crasta on 1/13/2010 for IN010894(SRR20056-CRF-0481) for new SUPRTH changes
					//tooth_no_display = tooth_no_for_Permanent_chart+"s";
					tooth_no_display = super_key_num+"(" + tooth_no_for_Permanent_chart +")";
				}
				else if(RD_yn.equals("R") || RD_yn.equals("D")){ //Retained Deciduous Case
				
					pstmt2 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?");
					
					pstmt2.setString(1,tooth_numbering_system);
					//pstmt2.setString(2,tooth_no);
					pstmt2.setString(2,display_tooth_no);
					pstmt2.setString(3,PD_flag);
					//pstmt2.setString(3,permanent_deciduous_flag);
					rs2 = pstmt2.executeQuery();
					while(rs2.next()){
						tooth_no_display = rs2.getString("NS_TOOTH_NO");
					}
				}
				else{
					tooth_no_display = tooth_no_for_Permanent_chart;
				}
				if(display_tooth_no.equals("")){
					tooth_no_display = display_tooth_no;
				}

			}
			if(site_type.equals("QUAD")){
			   tooth_no_display = quad_desc;
			}
			else if(site_type.equals("ARCH")){
			   tooth_no_display = arch_desc;
			}
			if(treatment_int_ext.equals("E")){
				date = com.ehis.util.DateUtils.convertDate(date,"DMY","en",locale);// Convert to the locale format
			}else{
				date = com.ehis.util.DateUtils.convertDate(date,"DMYHM","en",locale);// Convert to the locale format
			}


			if(treatment_condition.equals("C"))	{
				
				if(m == 1){
					//conditions.append("<br></br><br></br></br><br></br><br></br><br></br>");
					conditions.append("<br></br>");
					conditions.append("<table border ='1' cellpadding=0 cellspacing=0 width='88%' style='border:2px solid #666666';><tr></tr><tr><td class = 'CAGROUPHEADING' style='text-align:center' colspan='7'>"+condition_legend+"</th></td></tr>");
					conditions.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					//conditions.append("<tr><th  WIDTH='9%' style='text-align:center'>"+site_type_legend+"</th>");
					conditions.append("<th  WIDTH='8%' style='text-align:center'>"+tooth_no_legend+"</th>");
					conditions.append("<th  WIDTH='18%' style='text-align:center'>"+condition_type_legend+"</th>");
					conditions.append("<th  WIDTH='18%' style='text-align:center'>"+condition_legend+"</th>");
					conditions.append("<th  WIDTH='10%' style='text-align:center'>"+date_legend+"</th>");
					//conditions.append("<th WIDTH='20%' style='text-align:center'>Remarks</th>");
					conditions.append("<th  WIDTH='20%' style='text-align:center'>"+recorded_by_legend+"</th></tr>");
					
					/*conditions.append("<td  WIDTH='8%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+tooth_no_legend+"</b></font></td>");
					conditions.append("<td  WIDTH='18%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+condition_type_legend+"</b></font></td>");
					conditions.append("<td  WIDTH='18%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+condition_legend+"</b></font></td>");
					conditions.append("<td  WIDTH='10%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+date_legend+"</b></font></td>");
					//conditions.append("<th WIDTH='20%' style='text-align:center'>Remarks</th>");
					conditions.append("<td  WIDTH='20%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+recorded_by_legend+"</b></font></td></tr>");	 */

					//conditions.append("<tr><td bgcolor = 'BLACK' style='text-align:center' >Site Type</td>");
					/*conditions.append("<td WIDTH='8%' style='text-align:center;background-color:669999 ' >Tooth No / Quadrant / Arch</td>");
					conditions.append("<td WIDTH='18%' style='text-align:center;background-color:669999 '  >Condition Type</td>");
					conditions.append("<td WIDTH='18%' style='text-align:center;background-color:669999  ' >Conditions</td>");
					conditions.append("<td WIDTH='10%' style='text-align:center;background-color:669999 ' >Date</td>");
					//conditions.append("<th WIDTH='20%' style='text-align:center'>Remarks</th>");
					conditions.append("<td WIDTH='20%' style='text-align:center;background-color:669999' >Recorded By</td></tr>");*/	
					
					m++;
				}									

				/*conditions.append("<tr>");
				conditions.append(tooth_no_display);
				conditions.append(desc);
				conditions.append(condition_trmt_code_desc);
				conditions.append(date);
				conditions.append(remarks);
				conditions.append(doneby);
				conditions.append("##");  */

			   conditions.append("<tr>");
			   //conditions.append("<td WIDTH='5%' style='text-align:center';text-color:navy;text-size:2>"+site_type+"</td>");
			   conditions.append("<td WIDTH='5%' style='text-align:center';text-color:navy;text-size:2>"+tooth_no_display+"</td>");
			   conditions.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+desc+"</td>");
			   conditions.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+condition_trmt_code_desc+"</td>");
			   conditions.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+date+"</td>");
			  // conditions.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+remarks+"</td>");
			   conditions.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+doneby+"</td></tr>");
				
				/*if(m == 1){
					content.append("<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>");
					content.append("<table id ='condition' border=1 cellpadding=0 cellspacing=0 width='100%'><tr><td class = 'CAGROUPHEADING' style='text-align:center' colspan='7'>Conditions</th></td></tr>");
					content.append("<tr><th WIDTH='8%' style='text-align:center'>Tooth No</th>");
					content.append("<th WIDTH='18%' style='text-align:center'>Condition Type</th>");
					content.append("<th WIDTH='18%' style='text-align:center'>Conditions</th>");
					content.append("<th WIDTH='10%' style='text-align:center'>Date</th>");
					content.append("<th WIDTH='20%' style='text-align:center'>Remarks</th>");
					content.append("<th WIDTH='20%' style='text-align:center'>Recorded By</th></tr>");

					m++;
				}
				if(m > 1){

					content.append("<script>addNewRow(condition);</script>");

					//content.append("<script>addNewRow();<script/>");
				} 
			   content.append("<tr>");
			   content.append("<td WIDTH='5%' style='text-align:center';text-color:navy;text-size:2>"+tooth_no_display+"</td>");
			   content.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+desc+"</td>");
			   content.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+condition_trmt_code_desc+"</td>");
			   content.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+date+"</td>");
			   content.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+remarks+"</td>");
			   content.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+doneby+"</td></tr></table>");	*/
			}

			if(treatment_condition.equals("T") && treatment_int_ext.equals("E"))	{
				//out.println(conditions.toString());
				if(n == 1){
					ext_treatment.append("</table>");
					ext_treatment.append("<br></br><br></br>");
					ext_treatment.append("<table border=1 cellpadding=0 cellspacing=0 width='88%' style='border:2px solid #666666';><tr><td class = 'CAGROUPHEADING' style='text-align:center' colspan='7'>"+external_trmts_legend+"</th></td></tr>");
					//ext_treatment.append("<tr><th WIDTH='8%' style='text-align:center'>"+site_type_legend+"</th>");
					ext_treatment.append("<th WIDTH='10%' style='text-align:center'>"+tooth_no_legend+"</th>");
					ext_treatment.append("<th WIDTH='18%' style='text-align:center'>"+treatment_category_legend+"</th>");
					ext_treatment.append("<th WIDTH='18%' style='text-align:center'>"+ext_trmts_legend+"</th>");
					ext_treatment.append("<th WIDTH='20%' style='text-align:center'>"+location_legend+"</th>");
					ext_treatment.append("<th WIDTH='10%' style='text-align:center'>"+date_legend+"</th>");
					ext_treatment.append("<th WIDTH='20%' style='text-align:center'>"+recorded_by_legend+"</th>"); 
					ext_treatment.append("<th WIDTH='20%' style='text-align:center'>"+outcome_legend+"</th></tr>"); //Added by Sridevi Joshi on 4/7/2010 for IN020500

					/*ext_treatment.append("<td WIDTH='10%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+tooth_no_legend+"</b></font></td>");
					ext_treatment.append("<td WIDTH='18%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+treatment_category_legend+"</b></font></td>");
					ext_treatment.append("<td WIDTH='18%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+ext_trmts_legend+"</b></font></td>");
					ext_treatment.append("<td WIDTH='20%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+location_legend+"</b></font></td>");
					ext_treatment.append("<td WIDTH='10%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+date_legend+"</b></font></td>");
					ext_treatment.append("<td WIDTH='20%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+recorded_by_legend+"</b></font></td></tr>");	 */

					n++;
				}
			   ext_treatment.append("<tr>");
			  // ext_treatment.append("<td WIDTH='5%' style='text-align:center';text-color:navy;text-size:2>"+site_type+"</td>");
			   ext_treatment.append("<td WIDTH='5%' style='text-align:center';text-color:navy;text-size:2>"+tooth_no_display+"</td>");
			   ext_treatment.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+desc+"</td>");
			   ext_treatment.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+condition_trmt_code_desc+"</td>");
			  // ext_treatment.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+remarks+"</td>");
			   ext_treatment.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+location+"</td>");
			   ext_treatment.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+date+"</td>");
			   ext_treatment.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+doneby+"</td>"); 
			   ext_treatment.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+trmt_outcome_falure_success+"</td></tr>"); //Added by Sridevi Joshi on 4/7/2010 for IN020500
			}	
			if(treatment_condition.equals("T") && treatment_int_ext.equals("I") && !status.equals("60")){
				if(o == 1){
					trmt_to_do.append("</table>");
					trmt_to_do.append("<br></br><br></br>");
					trmt_to_do.append("<table border=1 cellpadding=0 cellspacing=0 width='88%' style='border:2px solid #666666';><tr><td class = 'CAGROUPHEADING' style='text-align:center' colspan='7'>"+trmt_to_do_legend+"</th></td></tr>");
					//trmt_to_do.append("<tr><th WIDTH='8%' style='text-align:center'>"+site_type_legend+"</th>");
					trmt_to_do.append("<th WIDTH='10%' style='text-align:center'>"+tooth_no_legend+"</th>");
					trmt_to_do.append("<th WIDTH='18%' style='text-align:center'>"+treatment_category_legend+"</th>");
					trmt_to_do.append("<th WIDTH='18%' style='text-align:center'>"+treatment_legend+"</th>");
					trmt_to_do.append("<th WIDTH='18%' style='text-align:center'>"+status_legend+"</th>");
					//trmt_to_do.append("<th WIDTH='20%' style='text-align:center'>Remarks</th>");
					trmt_to_do.append("<th WIDTH='10%' style='text-align:center'>"+date_legend+"</th>");
					trmt_to_do.append("<th WIDTH='20%' style='text-align:center'>"+recorded_by_legend+"</th></tr>");

					/*trmt_to_do.append("<td WIDTH='10%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+tooth_no_legend+"</b></font></td>");
					trmt_to_do.append("<td WIDTH='18%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+treatment_category_legend+"</b></font></td>");
					trmt_to_do.append("<td WIDTH='18%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+treatment_legend+"</b></font></td>");
					trmt_to_do.append("<td WIDTH='18%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+status_legend+"</b></font></td>");
					//trmt_to_do.append("<th WIDTH='20%' style='text-align:center'>Remarks</th>");
					trmt_to_do.append("<td WIDTH='10%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+date_legend+"</b></font></td>");
					trmt_to_do.append("<td WIDTH='20%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+recorded_by_legend+"</b></font></td></tr>");*/

					o++;
				}
			   trmt_to_do.append("<tr>");
			   //trmt_to_do.append("<td WIDTH='5%' style='text-align:center';text-color:navy;text-size:2>"+site_type+"</td>");
			   trmt_to_do.append("<td WIDTH='5%' style='text-align:center';text-color:navy;text-size:2>"+tooth_no_display+"</td>");
			   trmt_to_do.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+desc+"</td>");
			   trmt_to_do.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+condition_trmt_code_desc+"</td>");
			   trmt_to_do.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+status_desc+"</td>");
			   //trmt_to_do.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+remarks+"</td>");
			   trmt_to_do.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+date+"</td>");
			   trmt_to_do.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+doneby+"</td></tr>"); 
			}

			if(treatment_condition.equals("T") && treatment_int_ext.equals("I") && status.equals("60"))	{
				if(p == 1){
					trmt_done.append("</table>");
					trmt_done.append("<br></br><br></br>");
					//content.append("<table width='101.1%'><tr><td><table border=1 cellpadding=0 cellspacing=0 width='100%'><tr><td class = 'CAGROUPHEADING' style='text-align:center' colspan='7'>Treatments Done</th></tr>");
					trmt_done.append("<table border=1 cellpadding=0 cellspacing=0 width='88%' style='border:2px solid #666666';><tr><td class = 'CAGROUPHEADING' style='text-align:center' colspan='7'>"+trmt_done_legend+"</th></tr><tr>");
					//trmt_done.append("<th WIDTH='8%' style='text-align:center'>"+site_type_legend+"</th>");
					trmt_done.append("<th WIDTH='10%' style='text-align:center'>"+tooth_no_legend+"</th>");
					trmt_done.append("<th WIDTH='18%' style='text-align:center'>"+treatment_category_legend+"</th>");
					trmt_done.append("<th WIDTH='18%' style='text-align:center'>"+treatment_legend+"</th>");
					trmt_done.append("<th WIDTH='18%' style='text-align:center'>"+status_legend+"</th>");
					//trmt_done.append("<th WIDTH='20%' style='text-align:center'>Remarks</th>");
					trmt_done.append("<th WIDTH='10%' style='text-align:center'>"+date_legend+"</th>");
					trmt_done.append("<th WIDTH='20%' style='text-align:center'>"+recorded_by_legend+"</th>");
					trmt_done.append("<th WIDTH='10%' style='text-align:center'>"+outcome_legend+"</th></tr>");//Added by Sridevi Joshi on 4/7/2010 for IN020500

					/*trmt_done.append("<td WIDTH='10%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+tooth_no_legend+"</b></font></td>");
					trmt_done.append("<td WIDTH='18%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+treatment_category_legend+"</b></font></td>");
					trmt_done.append("<td WIDTH='18%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+treatment_legend+"</b></font></td>");
					trmt_done.append("<td WIDTH='18%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+status_legend+"</b></font></td>");
					//trmt_done.append("<th WIDTH='20%' style='text-align:center'>Remarks</th>");
					trmt_done.append("<td WIDTH='10%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+date_legend+"</b></font></td>");
					trmt_done.append("<td WIDTH='20%' style='text-align:center;background-color:669999'><font color='#FFFFFF' size='1'><b>"+recorded_by_legend+"</b></font></td></tr>"); */

					p++;
				}
			   trmt_done.append("<tr>");
			   //trmt_done.append("<td WIDTH='5%' style='text-align:center';text-color:navy;text-size:2>"+site_type+"</td>");
			   trmt_done.append("<td WIDTH='5%' style='text-align:center';text-color:navy;text-size:2>"+tooth_no_display+"</td>");
			   trmt_done.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+desc+"</td>");
			   trmt_done.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+condition_trmt_code_desc+"</td>");
			   trmt_done.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+status_desc+"</td>");
			   //trmt_done.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+remarks+"</td>");
			   trmt_done.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+date+"</td>");
			   trmt_done.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+doneby+"</td>"); 
			   trmt_done.append("<td WIDTH='18%' style='text-align:center';text-color:navy;text-size:2>"+trmt_outcome_falure_success+"</td></tr></td>"); //Added by Sridevi Joshi on 4/7/2010 for IN020500
			}

			signed_data.append("</table>");
		}
		content.append("<br></br><br></br>");
		signed_data.append("<br></br><br></br>");
		signed_data.append("<table width=88%' border='0' cellspacing='0' cellpadding='0'><tr><td  style='text-align:left' > <b>"+patient_name_legend+" : </b>"+patientName+"</td><td style='text-align:left'><b>"+hn_legend+" : </b>"+patient_id+"</td><td style='text-align:left' > <b>"+age_legend+" : </b>"+currentAgeOfPatient+"</td><td style='text-align:left' ><b>"+gender_legend+" : </b>"+gender+"</td></tr></table>");
		signed_data.append("<br></br><br></br>");

		signed_data.append("<table width=88%' border='0' cellspacing='0' cellpadding='0'><tr><td  style='text-align:left'> <b>"+dentist_comments_legend+" : </b></td></tr><tr><td width='100%'><TEXTAREA id='dent_comm' STYLE='overflow:visible;' rows='20' cols = '100' maxlength='1000' onBlur='return ismaxlength(this)' nowrap>"+dentist_comments+"</TEXTAREA></td></tr></table>"); 
		
		signed_data.append("<br></br><br></br>");
		signed_data.append("<table border=0 cellpadding=0 cellspacing=0 width='100%'><tr><td  width='44%'><b>"+signed_by_legend+" :  </b></td><td width='50%' align='right'><b>"+signed_date_legend+" : </b>"+currentDate+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr><tr><td width='44%' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ( "+practitioner_name+" )</td><td></td><td></td></tr></table>");
		signed_data.append("<br></br><br></br>");

		content.append("<input type='hidden' name='locale' id='locale' value="+locale+" ><input type='hidden' name='patient_id' id='patient_id' value="+patient_id+" ><input type='hidden' name='facility_id' id='facility_id' value="+facility_id+" ><input type='hidden' name='chart_num' id='chart_num' value="+chart_num+" ><input type='hidden' name='mixed_dentition_YN' id='mixed_dentition_YN' value="+mixed_dentition_YN+" ><input type='hidden' name='tooth_numbering_system' id='tooth_numbering_system' value="+tooth_numbering_system+" ><input type='hidden' name='permanent_deciduous_flag' id='permanent_deciduous_flag' value="+permanent_deciduous_flag+" ><input type='hidden' name='oh_chart_level' id='oh_chart_level' value="+oh_chart_level+" ><input type='hidden' name='asOnDatePrint' id='asOnDatePrint' value="+asOnDatePrint+" ><input type='hidden' name='other_chart_facility_id' id='other_chart_facility_id' value="+other_chart_facility_id+" ><input type='hidden' name='baseline_chart_yn' id='baseline_chart_yn' value="+baseline_chart_yn+" ><input type='hidden' name='dentist_comments' id='dentist_comments' value="+dentist_comments+"><input type='hidden' name='dentist_comments_hid' id='dentist_comments_hid' value=''><input type='hidden' name='count_charts' id='count_charts' value="+count_charts+" ><input type='hidden' name='as_on_date_chart_num' id='as_on_date_chart_num' value="+as_on_date_chart_num+" >");
		
		content.append("</form>");
		content.append("</body></html>");
		content.append("<script>getStaticImageForHistoryDummy();</script>");

		out.println(content.toString());
		out.println(images.toString());
		out.println(conditions.toString());
		out.println(ext_treatment.toString());
		out.println(trmt_to_do.toString());
		out.println(trmt_done.toString());
		out.println(signed_data.toString());   

	%>
	

	<%

						
}catch ( Exception e ) {
	e.printStackTrace() ;
	System.err.println("HistDentalTreatment, Exception at 865: qrystring="+request.getQueryString());
	System.err.println("content:=="+content.toString());
}finally {
	try{
		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if(rs2!=null) rs2.close();
		if(rs3!=null) rs3.close();
		if(pstmt!=null) pstmt.close();
		if(pstmt1!=null) pstmt1.close();
		if(pstmt2!=null) pstmt2.close();
		if(pstmt3!=null) pstmt3.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>


<script Language="javascript">
		/*if('<%=flag_print%>') {
		//window.location.href = "../../eOH/html/dummy_1.html";
			//document.getElementById("printme").value;
		//	checkSpl_print();

			var value =  '<%=dentist_comments%>';
			//alert(value);
			//value = value.replace(/+/g,"a");
			var dentist_comments_encoded_value = encodeURIComponent('<%=dentist_comments%>');
		   
			var dentist_comments_hid = decodeURIComponent(dentist_comments_encoded_value);
			dentist_comments_hid = decodeURIComponent(dentist_comments_hid);
			

			//dentist_comments_hid = decodeURIComponent('<%=dentist_comments%>');
			//var result = checkSpl_print(dentist_comments_hid);
			//alert(dentist_comments_hid);
			document.getElementById("dent_comm").value = dentist_comments_hid;
		} 
		if('<%=count_charts%>' == 0){
			document.getElementById("dent_comm").disabled = true;
		}  */
		


	function ismaxlength(obj){
		var mlength=obj.getAttribute ? parseInt(obj.getAttribute("maxlength")) : "";
		if (obj.getAttribute && obj.value.length > mlength){
			alert(getMessage("APP-OH000132","OH"));
			obj.value=obj.value.substring(0,mlength);
		}
		else{
		//	obj.value = checkSpl( obj.value );
			//obj.value = obj.value.replace(/>/g,""); 
		}
	}
	
	

</script>
<script Language="vbscript">
	Dim WSHShell
    Dim myHeader
    Dim myFooter
    Dim myMarginleft 
    Dim myMarginright 
    Set WSHShell = CreateObject("WScript.Shell")
    REM myHeader = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\header")
    REM myFooter = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer")
    REM myMarginleft = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_left") 
    REM myMarginright = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_right") 
	
    REM WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", "&bPage &p of &P"
    REM WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", "&b&d"
    WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", ""
    WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", "&bPage &p of &P   "
	REM WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_left", "0.2"
    REM WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_right", "0.5"
</script>


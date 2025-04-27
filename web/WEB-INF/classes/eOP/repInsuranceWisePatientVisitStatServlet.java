package eOP;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import java.lang.reflect.Method;
import webbeans.eCommon.ConnectionManager;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.*;


public class repInsuranceWisePatientVisitStatServlet extends javax.servlet.http.HttpServlet {

/*
	java.util.Properties p;
	HttpSession session;
	Connection conn=null;
	String facilityId		= "";
	String locale			= "";
	CallableStatement callStmt = null;
	ResultSet rset = null;
	Statement stmt =  null; */
	
	

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest request,	HttpServletResponse response) 
		throws javax.servlet.ServletException,IOException {
	
		java.util.Properties p = null;
		HttpSession session = null;
		Connection conn=null;
		String facilityId		= "";
		String locale			= "";
		CallableStatement callStmt = null;
		ResultSet rset = null;
		Statement stmt =  null;
		System.err.println("111==>");
		System.err.println("222==>");
		System.err.println("333==>");

		session = request.getSession(false);
		p = (java.util.Properties) session.getValue("jdbc");
		facilityId = (String) session.getValue("facility_id");
		conn = ConnectionManager.getConnection(request);
		locale = p.getProperty("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
		java.util.Locale loc = new java.util.Locale(locale);
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.addHeader("Content-Disposition", "inline");
		response.setHeader("Content-Disposition","attachment;filename=OPIWPVSR.xls");

		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
		java.util.ResourceBundle op_labels = java.util.ResourceBundle.getBundle( "eOP.resources.Labels",loc);
		java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle( "eBL.resources.Labels",loc);
		java.util.ResourceBundle mp_labels = java.util.ResourceBundle.getBundle( "eMP.resources.Labels",loc);

		try {
				
			java.util.Date dNow = new java.util.Date();
			java.text.SimpleDateFormat ft = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm"); 
			String repGenDateTime		= ft.format(dNow);
		
			
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("OPIWPVSR");

			String hdrSql =  "{call get_header_dtls(?,?,?,?,?,?,?,?)}";
			callStmt = conn.prepareCall(hdrSql);
			callStmt.setString(1, "OP");
			callStmt.setString(2, "OPIWPVSR");
			callStmt.setString(3, facilityId);
			callStmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			callStmt.registerOutParameter(5,java.sql.Types.VARCHAR);
			callStmt.registerOutParameter(6,java.sql.Types.VARCHAR);
			callStmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			callStmt.setString(8, locale);
			String reportName 		= "";
			String reportExecName 	= "";
			String facilityName 	= "";
			String siteName 		= "";

			try{
				callStmt.execute();
				reportName 		= callStmt.getString(4);
				reportExecName 	= callStmt.getString(5);
				facilityName 	= callStmt.getString(6);
				siteName 		= callStmt.getString(7);
			
			} catch(Exception e1) {
				e1.printStackTrace();
			} finally{
				callStmt.close();
			}
			/*Search Critiria Request*/
			String visitAdmDateFrom		= checkForNull(request.getParameter("visitAdmDateFrom"));
			String visitAdmDateTo		= checkForNull(request.getParameter("visitAdmDateTo"));
			String episodeType			= checkForNull(request.getParameter("episodeType"));
			String specialityFrom		= checkForNull(request.getParameter("specialityFrom").toUpperCase());
			String specialityTo			= checkForNull(request.getParameter("specialityTo").toUpperCase());
			String locationCodeFrom		= checkForNull(request.getParameter("locationCodeFrom").toUpperCase());
			String locationCodeTo		= checkForNull(request.getParameter("locationCodeTo").toUpperCase());
			String nursingUnitCodeFrom	= checkForNull(request.getParameter("nursingUnitCodeFrom").toUpperCase());
			String nursingUnitCodeTo	= checkForNull(request.getParameter("nursingUnitCodeTo").toUpperCase());
			String practitionerIdFrom	= checkForNull(request.getParameter("practitionerIdFrom").toUpperCase());
			String practitionerIdTo		= checkForNull(request.getParameter("practitionerIdTo").toUpperCase());
			String billingGroupFrom		= checkForNull(request.getParameter("billingGroupFrom").toUpperCase());
			String billingGroupTo		= checkForNull(request.getParameter("billingGroupTo").toUpperCase());
			String customerGroupFrom	= checkForNull(request.getParameter("customerGroupFrom").toUpperCase());
			String customerGroupTo		= checkForNull(request.getParameter("customerGroupTo").toUpperCase());
			String customerCodeFrom		= checkForNull(request.getParameter("customerCodeFrom").toUpperCase());
			String customerCodeTo		= checkForNull(request.getParameter("customerCodeTo").toUpperCase());
			String policyType			= checkForNull(request.getParameter("policyType").toUpperCase());
			String policyNo				= checkForNull(request.getParameter("policyNo"));
			String patientId			= checkForNull(request.getParameter("patientId"));
			String orderBy				= checkForNull(request.getParameter("orderBy"));
			//String orderByTxt			= checkForNull(request.getParameter("orderByTxt")); //Commented for checkstyle
			String episodeTypeTxt		= checkForNull(request.getParameter("episodeTypeTxt"));


			/*Search Critiria Labels*/
		
				
		
			
			String visitAdmDateFromLable		= op_labels.getString("eOP.VisitAdmDate.label")+" "+common_labels.getString("Common.from.label");
			String visitAdmDateToLable			= op_labels.getString("eOP.VisitAdmDate.label")+" "+common_labels.getString("Common.to.label");
			String specialityFromLable			= common_labels.getString("Common.SpecialityCode.label")+" "+common_labels.getString("Common.from.label");
			String specialityToLable			= common_labels.getString("Common.SpecialityCode.label")+" "+common_labels.getString("Common.to.label");
			String locationCodeFromLable		= common_labels.getString("Common.locationcode.label")+" "+common_labels.getString("Common.from.label");
			String locationCodeToLable			= common_labels.getString("Common.locationcode.label")+" "+common_labels.getString("Common.to.label");
			String nursingUnitCodeFromLable		= common_labels.getString("Common.NursingUnitCode.label")+" "+common_labels.getString("Common.from.label");
			String nursingUnitCodeToLable		= common_labels.getString("Common.NursingUnitCode.label")+" "+common_labels.getString("Common.to.label");
			String practitionerIdFromLable		= common_labels.getString("Common.practitionerid.label")+" "+common_labels.getString("Common.from.label");
			String practitionerIdToLable		= common_labels.getString("Common.practitionerid.label")+" "+common_labels.getString("Common.to.label");
			String billingGroupFromLable		= common_labels.getString("Common.BillingGroup.label")+" "+common_labels.getString("Common.from.label");
			String billingGroupToLable			= common_labels.getString("Common.BillingGroup.label")+" "+common_labels.getString("Common.to.label");
			String customerGroupFromLable		= common_labels.getString("Common.Customer.label")+" "+common_labels.getString("Common.GroupCode.label")+" "+common_labels.getString("Common.from.label");
			String customerGroupToLable			= common_labels.getString("Common.Customer.label")+" "+common_labels.getString("Common.GroupCode.label")+" "+common_labels.getString("Common.to.label");
			String customerCodeFromLable		= common_labels.getString("Common.CustomerCode.label")+" "+common_labels.getString("Common.from.label");

			String customerCodeToLable			= common_labels.getString("Common.CustomerCode.label")+" "+common_labels.getString("Common.to.label");
			String episodeTypeLable				=  bl_labels.getString("eBL.EpisodeType.label");
			String policyTypeLable				= bl_labels.getString("eBL.POLICY_TYPE.label");
			String policyNoLable				= bl_labels.getString("eBL.POLICY.label")+" "+bl_labels.getString("eBL.NUM.label");
			//String patientIdLable				= common_labels.getString("Common.patientId.label");
		//	String orderByLable					= common_labels.getString("Common.orderBy.label");

			/*write a Search Critirias into Excel Start*/
			LinkedHashMap searchcritiria = new LinkedHashMap();	
			searchcritiria.put(visitAdmDateFromLable,visitAdmDateFrom);
			searchcritiria.put(visitAdmDateToLable,visitAdmDateTo);
			searchcritiria.put(specialityFromLable,specialityFrom);
			searchcritiria.put(specialityToLable,specialityTo);
			searchcritiria.put(locationCodeFromLable,locationCodeFrom);
			searchcritiria.put(locationCodeToLable,locationCodeTo);
			searchcritiria.put(nursingUnitCodeFromLable,nursingUnitCodeFrom);
			searchcritiria.put(nursingUnitCodeToLable,nursingUnitCodeTo);
			searchcritiria.put(practitionerIdFromLable,practitionerIdFrom);
			searchcritiria.put(practitionerIdToLable,practitionerIdTo);
			searchcritiria.put(billingGroupFromLable,billingGroupFrom);
			searchcritiria.put(billingGroupToLable,billingGroupTo);
			searchcritiria.put(customerGroupFromLable,customerGroupFrom);
			searchcritiria.put(customerGroupToLable,customerGroupTo);
			searchcritiria.put(customerCodeFromLable,customerCodeFrom);
			searchcritiria.put(customerCodeToLable,customerCodeTo);
			searchcritiria.put(episodeTypeLable,episodeTypeTxt);
			searchcritiria.put(policyTypeLable,policyType);
			searchcritiria.put(policyNoLable,policyNo);
			//searchcritiria.put(patientIdLable,patientId);
			//searchcritiria.put(orderByLable,orderByTxt);

			//int i=1; //Commented for checkstyle
			int rowCount =1;
			HSSFRow row = null;
			
			
			HSSFFont font = workbook.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short)12);
			HSSFCellStyle style = workbook.createCellStyle();
			style.setFont(font);

			HSSFCellStyle style1=workbook.createCellStyle();
			style1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style1.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style1.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);


			Region cellRegion1 = new Region(1, (short)3, 1, (short)4); 
			Region cellRegion2 = new Region(2, (short)3, 2, (short)4); 
			Region cellRegion3 = new Region(3, (short)3, 3, (short)4); 
			sheet.addMergedRegion(cellRegion1);
			sheet.addMergedRegion(cellRegion2);
			sheet.addMergedRegion(cellRegion3);
			
			row				= sheet.createRow(rowCount++);
			HSSFCell hc1	= row.createCell(3);	
			hc1.setCellValue(siteName);
			hc1.setCellStyle(style);
			
			HSSFCell hc4	= row.createCell(5);	
			hc4.setCellValue(repGenDateTime);
			hc4.setCellStyle(style1);
			

			
			row				= sheet.createRow(rowCount++);
			HSSFCell hc2	= row.createCell(3);	
			hc2.setCellValue(facilityName);
			hc2.setCellStyle(style);

			row = sheet.createRow(rowCount++);
			HSSFCell hc3 = row.createCell(3);	
			hc3.setCellValue(reportName);
			hc3.setCellStyle(style);



			

			rowCount	= rowCount+2;
			rowCount	= generateSearchcritiria(workbook,searchcritiria,sheet,row,rowCount);
			/*write a Search Critirias into Excel End*/
			
			/*write a Search Results header into Excel Start*/
			rowCount		= rowCount+5;
			row = sheet.createRow(rowCount);

			
			LinkedHashMap searchResultsHeader = new LinkedHashMap();
			int index	= 0;
			searchResultsHeader.put(index++, common_labels.getString("Common.SerialNo.label"));
			searchResultsHeader.put(index++,bl_labels.getString("eBL.CUSTOMER_GROUP.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.patientId.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.PatientName.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.DateofBirth.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.Clinician.label")+" "+mp_labels.getString("eMP.Name_bc.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.Specialty.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.nursingUnit.label")+"/"+common_labels.getString("Common.Location.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.EpisodeType.label"));
			searchResultsHeader.put(index++,op_labels.getString("eOP.VisitAdmDate.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.Customer.label"));
			searchResultsHeader.put(index++,bl_labels.getString("eBL.POLICY_START_DATE.label"));
			searchResultsHeader.put(index++,bl_labels.getString("eBL.PolicyEndDate.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.BillingGroup.label"));
			searchResultsHeader.put(index++,bl_labels.getString("eBL.POLICY_TYPE.label"));
			searchResultsHeader.put(index++,bl_labels.getString("eBL.POLICY.label")+" "+bl_labels.getString("eBL.NUM.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.encounter.label"));

			rowCount	= generateSearchResultsHdr(workbook,searchResultsHeader,sheet,row,rowCount);
			
			/*Write a Search Results header into Excel End*/
			
					String sql		= "SELECT CASE WHEN b.patient_class IN ('OP', 'EM') THEN op_get_desc.op_clinic (b.facility_id, b.assign_care_locn_code, '"+locale+"', 2 ) END nursing_unit_desc, b.assign_care_locn_code nursing_unit, a.patient_id, DECODE ('"+locale+"', 'en', a.patient_name, NVL (a.patient_name_loc_lang, a.patient_name) ) patient_name, TO_CHAR (a.date_of_birth, 'dd/mm/yyyy') dob, am_get_desc.am_practitioner (b.attend_practitioner_id, '"+locale+"', 2 ) clinician_name, CASE WHEN b.patient_class IN ('OP', 'EM') THEN am_get_desc.am_speciality (b.specialty_code, '"+locale+"', 2 ) END speciality_desc, DECODE (b.patient_class, 'OP', 'Outpatient', 'EM', 'Emergency' ) patient_class, c.episode_type, b.encounter_id, TO_CHAR (b.visit_adm_date_time, 'DD/MM/RRRR HH24:MI SS' ) visit_adm_date_time, (SELECT SUBSTR (short_desc, 1, 15) FROM ar_cust_group_lang_vw ar WHERE ar.cust_group_code = c.cust_group_code AND language_id = '"+locale+"') || '/' || c.blng_grp_id customer_bl_grp_desc, c.blng_grp_id, c.policy_number, (SELECT SUBSTR (short_desc, 1, 15) FROM ar_cust_group_lang_vw ar WHERE ar.cust_group_code = c.cust_group_code AND language_id = '"+locale+"') customer_desc, (SELECT SUBSTR (short_name, 1, 15) FROM ar_customer_lang_vw ar1 WHERE ar1.cust_code = c.cust_code AND ar1.language_id = '"+locale+"') payer_desc, (SELECT SUBSTR (short_desc, 1, 15) FROM bl_ins_policy_types_lang_vw pt WHERE pt.policy_type_code = c.policy_type_code AND language_id = '"+locale+"') policy_type, (SELECT TO_CHAR (pp.policy_start_date, 'dd/mm/yyyy' ) FROM bl_encounter_payer_priority pp WHERE pp.patient_id = c.patient_id AND pp.acct_seq_no = c.cur_acct_seq_no AND pp.episode_id = c.episode_id AND pp.encounter_id = c.encounter_id AND pp.priority = 1 AND pp.settlement_ind != 'C' AND pp.episode_type IN ('O', 'E') AND pp.blng_grp_id = c.blng_grp_id AND pp.cust_code = c.cust_code AND pp.cust_group_code = c.cust_group_code) policy_start_date, (SELECT TO_CHAR (pp.policy_expiry_date, 'dd/mm/yyyy') FROM bl_encounter_payer_priority pp WHERE pp.patient_id = c.patient_id AND pp.acct_seq_no = c.cur_acct_seq_no AND pp.episode_id = c.episode_id AND pp.encounter_id = c.encounter_id AND pp.priority = 1 AND pp.settlement_ind != 'C' AND pp.episode_type IN ('O', 'E') AND pp.blng_grp_id = c.blng_grp_id AND pp.cust_code = c.cust_code AND pp.cust_group_code = c.cust_group_code) policy_end_date FROM mp_patient a, pr_encounter b, bl_visit_fin_dtls c WHERE a.patient_id = b.patient_id AND a.patient_id = c.patient_id AND b.facility_id = c.operating_facility_id AND b.patient_id = c.patient_id AND b.encounter_id = c.encounter_id AND b.facility_id = '"+facilityId+"' AND (b.patient_class = '"+episodeType+"' OR '"+episodeType+"' = 'ALL') AND c.episode_type IN ('O', 'E') AND c.settlement_ind != 'C' AND b.visit_status != '99' AND b.visit_adm_date_time BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'dd/mm/yyyy hh24:mi' ) AND TO_DATE ('"+visitAdmDateTo+"', 'dd/mm/yyyy hh24:mi' ) AND b.assign_care_locn_code BETWEEN NVL ('"+locationCodeFrom+"', '!') AND NVL ('"+locationCodeTo+"', '~') AND b.specialty_code BETWEEN NVL ('"+specialityFrom+"', '!') AND NVL ('"+specialityTo+"', '~') AND NVL (b.attend_practitioner_id, 'X') BETWEEN NVL ('"+practitionerIdFrom+"', '!') AND NVL ('"+practitionerIdTo+"', '~') AND c.blng_grp_id BETWEEN NVL ('"+billingGroupFrom+"', '!') AND NVL ('"+billingGroupTo+"', '~') AND c.cust_group_code BETWEEN NVL ('"+customerGroupFrom+"', '!') AND NVL ('"+customerGroupTo+"', '~') AND c.cust_code BETWEEN NVL ('"+customerCodeFrom+"', '!') AND NVL ('"+customerCodeTo+"', '~') AND NVL(c.policy_type_code,'x')LIKE UPPER(NVL('"+policyType+"','%%')) AND NVL(c.policy_number,'x') LIKE UPPER(NVL('"+policyNo+"','%%')) AND ( a.patient_id = NVL ('"+patientId+"', a.patient_id) OR a.patient_id IS NULL ) UNION SELECT CASE WHEN b.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit (b.facility_id, b.assign_care_locn_code, '"+locale+"', 2 ) END nursing_unit_desc, assign_care_locn_code nursing_unit, a.patient_id, DECODE ('"+locale+"', 'en', a.patient_name, NVL (a.patient_name_loc_lang, a.patient_name) ) patient_name, TO_CHAR (a.date_of_birth, 'dd/mm/yyyy') dob, am_get_desc.am_practitioner (b.admit_practitioner_id, '"+locale+"', 2 ) clinician_name, CASE WHEN b.patient_class IN ('IP', 'DC') THEN am_get_desc.am_speciality (b.specialty_code, '"+locale+"', 2 ) END speciality_desc, DECODE (b.patient_class, 'IP', 'Inpatient', 'DC', 'Daycare' ) patient_class, c.episode_type, b.encounter_id, TO_CHAR (b.visit_adm_date_time, 'DD/MM/RRRR HH24:MI SS' ) visit_adm_date_time, (SELECT SUBSTR (short_desc, 1, 15) FROM ar_cust_group_lang_vw ar WHERE ar.cust_group_code = c.cust_group_code AND language_id = '"+locale+"') || '/' || c.blng_grp_id customer_bl_grp_desc, c.blng_grp_id, c.policy_number, (SELECT SUBSTR (short_desc, 1, 15) FROM ar_cust_group_lang_vw ar WHERE ar.cust_group_code = c.cust_group_code AND language_id = '"+locale+"') customer_desc, (SELECT SUBSTR (short_name, 1, 15) FROM ar_customer_lang_vw ar1 WHERE ar1.cust_code = c.cust_code AND ar1.language_id = '"+locale+"') payer_desc, (SELECT SUBSTR (short_desc, 1, 15) FROM bl_ins_policy_types_lang_vw pt WHERE pt.policy_type_code = c.policy_type_code AND language_id = '"+locale+"') policy_type, (SELECT TO_CHAR (pp.policy_start_date, 'dd/mm/yyyy' ) FROM bl_encounter_payer_priority pp WHERE pp.patient_id = c.patient_id AND pp.acct_seq_no = c.cur_acct_seq_no AND pp.episode_id = c.episode_id AND pp.encounter_id = c.encounter_id AND pp.priority = 1 AND pp.settlement_ind != 'C' AND pp.episode_type IN ('I', 'D') AND pp.blng_grp_id = c.blng_grp_id AND pp.cust_code = c.cust_code AND pp.cust_group_code = c.cust_group_code) policy_start_date, (SELECT TO_CHAR (pp.policy_expiry_date, 'dd/mm/yyyy') FROM bl_encounter_payer_priority pp WHERE pp.patient_id = c.patient_id AND pp.acct_seq_no = c.cur_acct_seq_no AND pp.episode_id = c.episode_id AND pp.encounter_id = c.encounter_id AND pp.priority = 1 AND pp.settlement_ind != 'C' AND pp.episode_type IN ('I', 'D') AND pp.blng_grp_id = c.blng_grp_id AND pp.cust_code = c.cust_code AND pp.cust_group_code = c.cust_group_code) policy_end_date FROM mp_patient a, pr_encounter b, bl_episode_fin_dtls c WHERE a.patient_id = b.patient_id AND a.patient_id = c.patient_id AND b.facility_id = c.operating_facility_id AND b.patient_id = c.patient_id AND b.encounter_id = c.encounter_id AND b.facility_id = '"+facilityId+"' AND (b.patient_class = '"+episodeType+"' OR '"+episodeType+"' = 'ALL') AND episode_type IN ('I', 'D') AND c.settlement_ind != 'C' AND b.adt_status != '09' AND b.visit_adm_date_time BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'dd/mm/yyyy hh24:mi' ) AND TO_DATE ('"+visitAdmDateTo+"', 'dd/mm/yyyy hh24:mi' ) AND b.assign_care_locn_code BETWEEN NVL ('"+nursingUnitCodeFrom+"', '!') AND NVL ('"+nursingUnitCodeTo+"', '~') AND b.specialty_code BETWEEN NVL ('"+specialityFrom+"', '!') AND NVL ('"+specialityTo+"', '~') AND b.admit_practitioner_id BETWEEN NVL ('"+practitionerIdFrom+"', '!') AND NVL ('"+practitionerIdTo+"', '~') AND c.blng_grp_id BETWEEN NVL ('"+billingGroupFrom+"', '!') AND NVL ('"+billingGroupTo+"', '~') AND c.cust_group_code BETWEEN NVL ('"+customerGroupFrom+"', '!') AND NVL ('"+customerGroupTo+"', '~') AND c.cust_code BETWEEN NVL ('"+customerCodeFrom+"', '!') AND NVL ('"+customerCodeTo+"', '~') AND NVL(c.policy_type_code,'x')LIKE UPPER(NVL('"+policyType+"','%%')) AND NVL(c.policy_number,'x') LIKE UPPER(NVL('"+policyNo+"','%%')) AND ( a.patient_id = NVL ('"+patientId+"', a.patient_id) OR a.patient_id IS NULL ) ORDER BY "+orderBy+"";			
		
			stmt =  conn.createStatement();
			rset =  stmt.executeQuery(sql);

			int sno	= 1;
			while(rset!=null && rset.next()) {

				row = sheet.createRow(rowCount);
				
				HSSFCell c1 = row.createCell(0);	
				c1.setCellValue(sno++);
				c1.setCellStyle(style1);

				HSSFCell c2 = row.createCell(1);	
				c2.setCellValue(checkForNull(rset.getString("CUSTOMER_DESC")));
				c2.setCellStyle(style1);

				HSSFCell c3 = row.createCell(2);	
				c3.setCellValue(checkForNull(rset.getString("PATIENT_ID")));
				c3.setCellStyle(style1);

				HSSFCell c4 = row.createCell(3);	
				c4.setCellValue(checkForNull(rset.getString("PATIENT_NAME")));
				c4.setCellStyle(style1);

				HSSFCell c5 = row.createCell(4);	
				c5.setCellValue(checkForNull(rset.getString("DOB")));
				c5.setCellStyle(style1);

				HSSFCell c6 = row.createCell(5);	
				c6.setCellValue(checkForNull(rset.getString("CLINICIAN_NAME")));
				c6.setCellStyle(style1);

				HSSFCell c7 = row.createCell(6);	
				c7.setCellValue(checkForNull(rset.getString("SPECIALITY_DESC")));
				c7.setCellStyle(style1);
			
				HSSFCell c16 = row.createCell(7);	
				c16.setCellValue(checkForNull(rset.getString("nursing_unit_desc")));
				c16.setCellStyle(style1);

				HSSFCell c8 = row.createCell(8);	
				c8.setCellValue(checkForNull(rset.getString("PATIENT_CLASS")));
				c8.setCellStyle(style1);

				HSSFCell c9 = row.createCell(9);	
				c9.setCellValue(checkForNull(rset.getString("VISIT_ADM_DATE_TIME")));
				c9.setCellStyle(style1);
				
				HSSFCell c17 = row.createCell(10);	
				c17.setCellValue(checkForNull(rset.getString("PAYER_DESC")));
				c17.setCellStyle(style1);

				HSSFCell c10 = row.createCell(11);	
				c10.setCellValue(checkForNull(rset.getString("POLICY_START_DATE")));
				c10.setCellStyle(style1);

				HSSFCell c11 = row.createCell(12);	
				c11.setCellValue(checkForNull(rset.getString("POLICY_END_DATE")));
				c11.setCellStyle(style1);

				HSSFCell c12 = row.createCell(13);	
				c12.setCellValue(checkForNull(rset.getString("BLNG_GRP_ID")));
				c12.setCellStyle(style1);

				HSSFCell c13 = row.createCell(14);	
				c13.setCellValue(checkForNull(rset.getString("POLICY_TYPE")));
				c13.setCellStyle(style1);

				HSSFCell c14 = row.createCell(15);	
				c14.setCellValue(checkForNull(rset.getString("POLICY_NUMBER")));
				c14.setCellStyle(style1);

				HSSFCell c15 = row.createCell(16);	
				c15.setCellValue(checkForNull(rset.getString("ENCOUNTER_ID")));
				c15.setCellStyle(style1);

				rowCount++;

			}
			/*write a Search Critirias into Excel End*/
			workbook.write(response.getOutputStream());
			if(stmt !=null) stmt.close(); //Added for checkstyle
			if(rset !=null) rset.close();  //Added for checkstyle
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				ConnectionManager.returnConnection(conn, request);
		}
	}


	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}
	
	
	public static int generateSearchcritiria(HSSFWorkbook workbook,LinkedHashMap searchcritiria,HSSFSheet sheet,HSSFRow row,int rowCount){
		
		int i=1;

		HSSFCellStyle style=workbook.createCellStyle();
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		
		Iterator it = searchcritiria.entrySet().iterator();
		while (it.hasNext()) {
			
			Map.Entry searchValues = (Map.Entry)it.next();

			String label	= (String) searchValues.getKey();
			String value	= (String) searchValues.getValue();
	

		 if(i%2!=0){
				row = sheet.createRow(rowCount);
				HSSFCell c1 = row.createCell(0);	
				c1.setCellValue(label);
				c1.setCellStyle(style);

				HSSFCell c2 = row.createCell(1);	
				c2.setCellValue(value);
				c2.setCellStyle(style);
				rowCount++;

			}else{
				HSSFCell c3 = row.createCell(2);	
				c3.setCellValue(label);
				c3.setCellStyle(style);

				HSSFCell c4 = row.createCell(3);	
				c4.setCellValue(value);
				c4.setCellStyle(style);
			}
			
			i++;
		}
		return rowCount;
	}

	public static int generateSearchResultsHdr(HSSFWorkbook workbook,LinkedHashMap searchResultsHeader,HSSFSheet sheet,HSSFRow row,int rowCount){
		
		int i=0;

		row = sheet.createRow(rowCount);
		
			
	
		HSSFCellStyle style=workbook.createCellStyle();

		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);


		Iterator it = searchResultsHeader.entrySet().iterator();
		while (it.hasNext()) {
			
			Map.Entry values = (Map.Entry)it.next();
			String value	= (String) values.getValue();
			HSSFCell c1 = row.createCell(i);	
			c1.setCellValue(value);
			sheet.setColumnWidth(i, 7500);
			c1.setCellStyle(style);
			i++;
		}
	
		return rowCount+1;
	}

}
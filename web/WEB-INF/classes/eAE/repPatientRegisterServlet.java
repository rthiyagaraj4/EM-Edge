package eAE;

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


public class repPatientRegisterServlet extends javax.servlet.http.HttpServlet {

	PrintWriter out;
	java.util.Properties p;
	HttpSession session;
	Connection conn=null;
	String facilityId		= "";
	String locale			= "";
	CallableStatement callStmt = null;
	ResultSet rset = null;
	Statement stmt =  null;
	
	

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest request,	HttpServletResponse response) 
		throws javax.servlet.ServletException,IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.setHeader("Content-Disposition","attachment;filename=AEPATREG.xls");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");

		session = request.getSession(false);
		this.p = (java.util.Properties) session.getValue("jdbc");
		this.facilityId = (String) session.getValue("facility_id");
		this.conn = ConnectionManager.getConnection(request);
		locale = p.getProperty("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
		java.util.Locale loc = new java.util.Locale(locale);

		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
		java.util.ResourceBundle op_labels = java.util.ResourceBundle.getBundle( "eOP.resources.Labels",loc);
		java.util.ResourceBundle ae_labels = java.util.ResourceBundle.getBundle( "eAE.resources.Labels",loc);
		java.util.ResourceBundle mo_labels = java.util.ResourceBundle.getBundle( "eMO.resources.Labels",loc);


		try {
			
			java.util.Date dNow = new java.util.Date();
			java.text.SimpleDateFormat ft = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm"); 
			String repGenDateTime		= ft.format(dNow);	

			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("AEPATREG");

			String hdrSql =  "{call get_header_dtls(?,?,?,?,?,?,?,?)}";
			callStmt = conn.prepareCall(hdrSql);
			callStmt.setString(1, "AE");
			callStmt.setString(2, "AEPATREG");
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
			String nationality					= checkForNull(request.getParameter("nationality"));
			String visitDateFrom				= checkForNull(request.getParameter("visitDateFrom"));
			String visitDateTo					= checkForNull(request.getParameter("visitDateTo"));
			String visitTypeCodeFrom			= checkForNull(request.getParameter("visitTypeCodeFrom"));
			String visitTypeCodeTo				= checkForNull(request.getParameter("visitTypeCodeTo"));
			String locationCodeFrom				= checkForNull(request.getParameter("locationCodeFrom"));
			String locationCodeTo				= checkForNull(request.getParameter("locationCodeTo"));
			String specialityCodeFrom			= checkForNull(request.getParameter("specialityCodeFrom"));
			String specialityCodeTo				= checkForNull(request.getParameter("specialityCodeTo"));
			String serviceCodeFrom				= checkForNull(request.getParameter("serviceCodeFrom"));
			String serviceCodeTo				= checkForNull(request.getParameter("serviceCodeTo"));
			String practitionerTypeFrom			= checkForNull(request.getParameter("practitionerTypeFrom"));
			String practitionerTypeTo			= checkForNull(request.getParameter("practitionerTypeTo"));
			String practitionerIdFrom			= checkForNull(request.getParameter("practitionerIdFrom"));
			String practitionerIdTo				= checkForNull(request.getParameter("practitionerIdTo"));
			String nationalityTxt				= checkForNull(request.getParameter("nationalityTxt"));
			String practitionerTypeFromTxt		= checkForNull(request.getParameter("practitionerTypeFromTxt"));
			String practitionerTypeToTxt		= checkForNull(request.getParameter("practitionerTypeToTxt"));

			

			/*Search Critiria Labels*/
		
				
		
			
			String nationalityLable		= common_labels.getString("Common.nationality.label");
			String visitDateFromLable			= common_labels.getString("Common.VisitDate.label")+" "+common_labels.getString("Common.from.label");
			String visitDateToLable			= common_labels.getString("Common.VisitDate.label")+" "+common_labels.getString("Common.to.label");
			String visitTypeCodeFromLable			= common_labels.getString("Common.VisitTypeCode.label")+" "+common_labels.getString("Common.from.label");
			String visitTypeCodeToLable			= common_labels.getString("Common.VisitTypeCode.label")+" "+common_labels.getString("Common.to.label");
			String locationCodeFromLable		= common_labels.getString("Common.locationcode.label")+" "+common_labels.getString("Common.from.label");
			String locationCodeToLable			= common_labels.getString("Common.locationcode.label")+" "+common_labels.getString("Common.to.label");
			String specialityCodeFromLable		= common_labels.getString("Common.speciality.label")+" "+common_labels.getString("Common.code.label")+" "+common_labels.getString("Common.from.label");
			String specialityCodeToLable		= common_labels.getString("Common.speciality.label")+" "+common_labels.getString("Common.code.label")+" "+common_labels.getString("Common.to.label");
			String serviceCodeFromLable		= common_labels.getString("Common.ServiceCode.label")+" "+common_labels.getString("Common.from.label");
			String serviceCodeToLable		= common_labels.getString("Common.ServiceCode.label")+" "+common_labels.getString("Common.to.label");
			String practitionerTypeFromLable		= common_labels.getString("Common.practitionertype.label")+" "+common_labels.getString("Common.from.label");
			String practitionerTypeToLable			= common_labels.getString("Common.practitionertype.label")+" "+common_labels.getString("Common.to.label");
			String practitionerIdFromLable		= common_labels.getString("Common.practitionerid.label")+" "+common_labels.getString("Common.from.label");
			String practitionerIdToLable			= common_labels.getString("Common.practitionerid.label")+" "+common_labels.getString("Common.to.label");


			/*write a Search Critirias into Excel Start*/
			LinkedHashMap searchcritiria = new LinkedHashMap();	
			searchcritiria.put(visitDateFromLable,visitDateFrom);
			searchcritiria.put(visitDateToLable,visitDateTo);
			searchcritiria.put(visitTypeCodeFromLable,visitTypeCodeFrom);
			searchcritiria.put(visitTypeCodeToLable,visitTypeCodeTo);
			searchcritiria.put(locationCodeFromLable,locationCodeFrom);
			searchcritiria.put(locationCodeToLable,locationCodeTo);
			searchcritiria.put(specialityCodeFromLable,specialityCodeFrom);
			searchcritiria.put(specialityCodeToLable,specialityCodeTo);
			searchcritiria.put(serviceCodeFromLable,serviceCodeFrom);
			searchcritiria.put(serviceCodeToLable,serviceCodeTo);
			searchcritiria.put(practitionerTypeFromLable,practitionerTypeFromTxt);
			searchcritiria.put(practitionerTypeToLable,practitionerTypeToTxt);
			searchcritiria.put(practitionerIdFromLable,practitionerIdFrom);
			searchcritiria.put(practitionerIdToLable,practitionerIdTo);
			searchcritiria.put(nationalityLable,nationalityTxt);


			
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
			searchResultsHeader.put(index++, common_labels.getString("Common.Series.label")+" "+common_labels.getString("Common.no.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.date.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.time.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.PatientName.label"));
			searchResultsHeader.put(index++,op_labels.getString("eOP.MRN.label")+" "+common_labels.getString("Common.no.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.nationality.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.encounterid.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.age.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.Sex.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.time.label")+" "+ae_labels.getString("eAE.Triage.label"));
			searchResultsHeader.put(index++,ae_labels.getString("eAE.TriageLevel.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.nurse.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.ChiefComplaint.label"));
			searchResultsHeader.put(index++,mo_labels.getString("eMO.Doctor.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.time.label")+" "+op_labels.getString("eOP.Seen.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.diagnosis.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.Treatment.label")+" "+common_labels.getString("Common.Procedure.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.DispType.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.time.label")+" "+common_labels.getString("Common.of.label")+" "+common_labels.getString("Common.Discharge.label"));

			rowCount	= generateSearchResultsHdr(workbook,searchResultsHeader,sheet,row,rowCount);
			
			/*Write a Search Results header into Excel End*/
			
			String sql		= "SELECT b.FACILITY_ID, TO_CHAR (b.queue_date,'dd/mm/yyyy') DAT, TO_CHAR (b.queue_date, 'HH24:MI') TIME_REGISTERED, a.PATIENT_NAME, b.PATIENT_ID MRN, b.ENCOUNTER_ID, mp_get_desc.mp_country (a.nationality_code, '"+locale+"', '3' ) NATIONALITY,  get_age (a.date_of_birth) AGE, a.SEX, am_get_desc.am_practitioner (b.practitioner_id, '"+locale+"', '1' ) PRACTITIONER, TO_CHAR (b.cons_srvc_start_date_time, 'HH24:MI') CONS_SRVC_START, am_get_desc.am_disposition_type (b.disposition_type, '"+locale+"', '2' ) DISPOSITION_TYPE, TO_CHAR (c.recorded_date, 'HH24:MI') TIME_TRIAGE, TO_DATE(TO_CHAR (c.recorded_date, 'HH24:MI'),'HH24:MI') TIME_TRIAGE_ORDER, (SELECT priority_zone_desc FROM ae_priority_zone WHERE priority_zone = c.priority_zone) TRIAGE_LEVEL, sm_get_desc.sm_appl_user (c.added_by_id, '"+locale+"', '1') NURSE, TO_CHAR(B.DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI') DISCHARGE_DATE FROM mp_patient a, op_patient_queue b, ae_pat_emergency_detail c, am_practitioner d WHERE  a.patient_id = b.patient_id AND c.facility_id = b.facility_id AND c.encounter_id = b.encounter_id AND b.practitioner_id = d.practitioner_id(+) AND b.patient_class = 'EM' AND b.facility_id = '"+facilityId+"' AND B.QUEUE_STATUS !='99' AND a.nationality_code LIKE UPPER (NVL ('"+nationality+"', '%')) AND TRUNC (b.queue_date) BETWEEN TO_DATE ('"+visitDateFrom+"', 'DD/MM/YYYY') AND TO_DATE ('"+visitDateTo+"', 'DD/MM/YYYY') AND NVL(b.visit_type_code,'x') BETWEEN NVL ('"+visitTypeCodeFrom+"', '!') AND NVL ('"+visitTypeCodeTo+"', '~') AND NVL(b.locn_code,'x') BETWEEN NVL ('"+locationCodeFrom+"', '!') AND NVL ('"+locationCodeTo+"', '~') AND NVL(b.speciality_code,'x') BETWEEN NVL ('"+specialityCodeFrom+"', '!') AND NVL ('"+specialityCodeTo+"', '~') AND NVL(b.service_code,'x') BETWEEN NVL ('"+serviceCodeFrom+"', '!')  AND NVL ('"+serviceCodeTo+"', '~') AND NVL(d.pract_type,'x') BETWEEN NVL ('"+practitionerTypeFrom+"', '!') AND NVL ('"+practitionerTypeTo+"', '~') AND NVL(d.practitioner_id,'x') BETWEEN NVL ('"+practitionerIdFrom+"', '!') AND NVL ('"+practitionerIdTo+"', '~')  ORDER BY DAT,TIME_TRIAGE_ORDER DESC";			

			stmt =  conn.createStatement();
			rset =  stmt.executeQuery(sql);

			int sno	= 1;
			int cellno	= 0;
			while(rset!=null && rset.next()) {

				row = sheet.createRow(rowCount);
				cellno		= 0;

				String facId	= checkForNull(rset.getString("FACILITY_ID"));
				String encId	= checkForNull(rset.getString("ENCOUNTER_ID"));
				String patId	= checkForNull(rset.getString("MRN"));

				String ChiefComplaintAll				= getChiefComplaint(conn,facId,encId);
				String dianosisDetails					= getDianosisDetails(conn,facId,encId,patId,locale);
				String treatmentProcedureDetails		= getTreatmentProcedureDetails(conn,facId,encId,patId,locale);

				HSSFCell c1 = row.createCell(cellno++);	
				c1.setCellValue(sno++);
				c1.setCellStyle(style1);

				HSSFCell c2 = row.createCell(cellno++);	
				c2.setCellValue(checkForNull(rset.getString("DAT")));
				c2.setCellStyle(style1);

				HSSFCell c3 = row.createCell(cellno++);	
				c3.setCellValue(checkForNull(rset.getString("TIME_REGISTERED")));
				c3.setCellStyle(style1);

				HSSFCell c4 = row.createCell(cellno++);	
				c4.setCellValue(checkForNull(rset.getString("PATIENT_NAME")));
				c4.setCellStyle(style1);

				HSSFCell c5 = row.createCell(cellno++);	
				c5.setCellValue(checkForNull(rset.getString("MRN")));
				c5.setCellStyle(style1);

				HSSFCell c6 = row.createCell(cellno++);	
				c6.setCellValue(checkForNull(rset.getString("NATIONALITY")));
				c6.setCellStyle(style1);

				HSSFCell c7 = row.createCell(cellno++);	
				c7.setCellValue(checkForNull(rset.getString("ENCOUNTER_ID")));
				c7.setCellStyle(style1);

				HSSFCell c19 = row.createCell(cellno++);	
				c19.setCellValue(checkForNull(rset.getString("AGE")));
				c19.setCellStyle(style1);

				HSSFCell c8 = row.createCell(cellno++);	
				c8.setCellValue(checkForNull(rset.getString("SEX")));
				c8.setCellStyle(style1);

				HSSFCell c9 = row.createCell(cellno++);	
				c9.setCellValue(checkForNull(rset.getString("TIME_TRIAGE")));
				c9.setCellStyle(style1);

				HSSFCell c10 = row.createCell(cellno++);	
				c10.setCellValue(checkForNull(rset.getString("TRIAGE_LEVEL")));
				c10.setCellStyle(style1);

				HSSFCell c11 = row.createCell(cellno++);	
				c11.setCellValue(checkForNull(rset.getString("NURSE")));
				c11.setCellStyle(style1);


				HSSFCell c12 = row.createCell(cellno++);	
				c12.setCellValue(ChiefComplaintAll);
				c12.setCellStyle(style1);

				HSSFCell c13 = row.createCell(cellno++);	
				c13.setCellValue(checkForNull(rset.getString("PRACTITIONER")));
				c13.setCellStyle(style1);

				HSSFCell c14 = row.createCell(cellno++);	
				c14.setCellValue(checkForNull(rset.getString("CONS_SRVC_START")));
				c14.setCellStyle(style1);

				HSSFCell c15 = row.createCell(cellno++);	
				c15.setCellValue(dianosisDetails);
				c15.setCellStyle(style1);

				HSSFCell c16 = row.createCell(cellno++);	
				c16.setCellValue(treatmentProcedureDetails);
				c16.setCellStyle(style1);

				HSSFCell c17 = row.createCell(cellno++);	
				c17.setCellValue(checkForNull(rset.getString("DISPOSITION_TYPE")));
				c17.setCellStyle(style1);
				
				String dischargeDate	= getDischargeDate(conn,facId,encId,patId);
				System.err.println("dischargeDate 334==>"+dischargeDate);
				if(dischargeDate.equals("")){
					dischargeDate		= checkForNull(rset.getString("DISCHARGE_DATE"));
				}
			

				HSSFCell c18 = row.createCell(cellno++);	
				c18.setCellValue(dischargeDate);
				c18.setCellStyle(style1);

				rowCount++;

			}
							if(stmt !=null) stmt.close();
				if(rset !=null) rset.close();
			/*write a Search Critirias into Excel End*/
			workbook.write(response.getOutputStream());
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

	public static String getChiefComplaint(Connection conn,String facId,String encId){

		String complaint_desc	= "";
		PreparedStatement pstmt				= null;
		ResultSet rs						= null;
		try {	
		
			String sql	= "SELECT  A.FACILITY_ID,A.ENCOUNTER_ID, WM_CONCAT(complaint_desc) complaint_desc FROM ca_encntr_chief_complaint a where a.facility_id=? and A.ENCOUNTER_ID = ? GROUP BY  A.FACILITY_ID,A.ENCOUNTER_ID";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,facId);
			pstmt.setString(2,encId);
			rs = pstmt.executeQuery();
			if(rs !=null)  {
				if(rs.next())  {
					complaint_desc		= checkForNull(rs.getString("complaint_desc"));
				}
			}
		} catch ( Exception e ) {
			System.err.println( e ) ;
		} finally {
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
				} catch(Exception fe){
			}
		}
	
		return complaint_desc;
	}

	public static String getDianosisDetails(Connection conn,String facId,String encId,String patId,String locale){

		String term_code_short_desc	= "";
		PreparedStatement pstmt				= null;
		ResultSet rs						= null;
		try {	
		
			String sql	= "SELECT patient_id,encounter_id,facility_id,WM_CONCAT(term_code_short_desc)term_code_short_desc  FROM (SELECT a.patient_id, a.encounter_id, a.facility_id, a.term_code_short_desc, a.term_code AS term_code  FROM mr_diagnosis_recoding_dtl a WHERE a.status != 'E' AND NOT EXISTS ( SELECT 'Y' FROM mr_diagnosis_recoding_dtl y, mr_diag_proc_recoding_hdr x  WHERE y.facility_id = x.facility_id    AND x.encounter_id = y.encounter_id    AND x.patient_id = y.patient_id    AND (   x.level1_status = 'A'   OR x.level3_status = 'A'   OR x.level3_status = 'A'  )    AND y.status != 'E'    AND y.recode_status = 'R'    AND a.facility_id = y.facility_id    AND a.patient_id = y.patient_id    AND a.encounter_id = y.encounter_id    AND a.term_set_id = y.orig_term_set_id    AND a.term_code = y.orig_term_code    AND a.occur_srl_no = y.occur_srl_no    AND y.confirm_yn = 'Y'   )   AND a.recode_status = 'O'   AND a.stage_no = 0   and a.patient_id='"+patId+"' and a.encounter_id ='"+encId+"' and a.facility_id ='"+facId+"'UNION  SELECT y.patient_id, y.encounter_id, y.facility_id, mr_get_desc.mr_term_code (y.term_set_id,   y.term_code,   '"+locale+"',   '2'  ) term_code_short_desc,   y.term_code AS term_code  FROM mr_diagnosis_recoding_dtl y, mr_diag_proc_recoding_hdr x WHERE y.facility_id = x.facility_id   AND x.encounter_id = y.encounter_id   AND x.patient_id = y.patient_id   AND (x.level1_status = 'A' OR x.level3_status = 'A'  OR x.level3_status = 'A' )   AND y.status != 'E'   AND y.recode_status = 'R'   AND y.confirm_yn = 'Y' and y.patient_id='"+patId+"' and y.encounter_id ='"+encId+"' and y.facility_id ='"+facId+"'UNION SELECT y.patient_id, y.encounter_id, y.facility_id, mr_get_desc.mr_term_code (y.term_set_id,   y.term_code,   '"+locale+"',   '2'  ) term_code_short_desc, y.term_code AS term_code  FROM mr_diagnosis_recoding_dtl y, mr_diag_proc_recoding_hdr x WHERE y.facility_id = x.facility_id   AND x.encounter_id = y.encounter_id   AND x.patient_id = y.patient_id   AND (x.level1_status = 'A' OR x.level3_status = 'A'  OR x.level3_status = 'A' )   AND y.status != 'E'   AND y.recode_status = 'N'   AND y.confirm_yn = 'Y' and y.patient_id='"+patId+"' and y.encounter_id ='"+encId+"' and y.facility_id ='"+facId+"'   )   GROUP BY patient_id,encounter_id,facility_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs !=null)  {
				if(rs.next())  {
					term_code_short_desc		= checkForNull(rs.getString("term_code_short_desc"));
				}
			}
		} catch ( Exception e ) {
			System.err.println( e ) ;
		} finally {
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
				} catch(Exception fe){
			}
		}
	
		return term_code_short_desc;
	}

	public static String getTreatmentProcedureDetails(Connection conn,String facId,String encId,String patId,String locale){

		String procedure_des	= "";
		PreparedStatement pstmt				= null;
		ResultSet rs						= null;
		try {	
		
			String sql	= "SELECT patient_id,encounter_id,facility_id,WM_CONCAT(procedure_des)procedure_des   FROM  (SELECT b.patient_id, b.encounter_id, b.facility_id, mr_get_desc.mr_term_code (b.proc_code_scheme, b.proc_code, '"+locale+"', '2' ) procedure_des, b.proc_code AS term_code   FROM mr_diag_proc_recoding_hdr a, mr_procedure_recoding_dtl b  WHERE a.facility_id = b.facility_id AND a.encounter_id = b.encounter_id AND a.patient_id = b.patient_id AND b.recode_status = 'O' AND b.active_yn = 'Y' AND b.status != 'E' AND NOT EXISTS ( SELECT 'Y' FROM mr_diag_proc_recoding_hdr y, mr_procedure_recoding_dtl x WHERE y.facility_id = x.facility_id  AND y.encounter_id = x.encounter_id  AND y.patient_id = x.patient_id  AND (   y.level1_status = 'A' OR y.level3_status = 'A' OR y.level3_status = 'A' )  AND (x.status != 'E' OR x.status IS NULL)  AND x.recode_status = 'R'  AND x.active_yn = 'Y'  AND x.confirm_yn = 'Y'  AND b.facility_id = x.facility_id  AND b.patient_id = x.patient_id  AND b.encounter_id = x.encounter_id  AND b.proc_code_scheme = x.orig_proc_code_scheme  AND b.proc_code = x.orig_proc_code ) AND b.stage_no = 0 and b.patient_id='"+patId+"' and b.encounter_id ='"+encId+"' and b.facility_id ='"+facId+"' UNION SELECT x.patient_id, x.encounter_id, x.facility_id, mr_get_desc.mr_term_code (x.proc_code_scheme, x.proc_code, '"+locale+"', '2' ) procedure_des, x.proc_code AS term_code   FROM mr_diag_proc_recoding_hdr y, mr_procedure_recoding_dtl x  WHERE y.facility_id = x.facility_id AND y.encounter_id = x.encounter_id AND y.patient_id = x.patient_id AND (y.level1_status = 'A' OR y.level3_status = 'A'  OR y.level3_status = 'A' ) AND (x.status != 'E' OR x.status IS NULL) AND x.recode_status = 'R' AND x.active_yn = 'Y' AND x.confirm_yn = 'Y' and x.patient_id='"+patId+"' and x.encounter_id ='"+encId+"' and x.facility_id ='"+facId+"' UNION SELECT x.patient_id, x.encounter_id, x.facility_id, mr_get_desc.mr_term_code (x.proc_code_scheme, x.proc_code, '"+locale+"', '2' ) procedure_des, x.proc_code AS term_code   FROM mr_diag_proc_recoding_hdr y, mr_procedure_recoding_dtl x  WHERE y.facility_id = x.facility_id AND y.encounter_id = x.encounter_id AND y.patient_id = x.patient_id AND (y.level1_status = 'A' OR y.level3_status = 'A'  OR y.level3_status = 'A' ) AND (x.status != 'E' OR x.status IS NULL) AND x.recode_status = 'N' AND x.active_yn = 'Y' AND x.confirm_yn = 'Y' and x.patient_id='"+patId+"' and x.encounter_id ='"+encId+"' and x.facility_id ='"+facId+"') GROUP BY patient_id,encounter_id,facility_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs !=null)  {
				if(rs.next())  {
					procedure_des		= checkForNull(rs.getString("procedure_des"));
				}
			}
		} catch ( Exception e ) {
			System.err.println( e ) ;
		} finally {
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
				} catch(Exception fe){
			}
		}
	
		return procedure_des;
	}

	public static String getDischargeDate(Connection conn,String facId,String encId,String patId){

		String dischargeDate				= "";
		PreparedStatement pstmt				= null;
		ResultSet rs						= null;
		try {	
		
			String sql	= "SELECT A.RESULT_STR DISCHARGE_DATE FROM cr_encounter_detail A WHERE A.CONTR_SYS_EVENT_CODE= 'DMA0192' AND A.PATIENT_CLASS='EM' AND A.FACILITY_ID='"+facId+"' AND A.PATIENT_ID='"+patId+"' AND A.ENCOUNTER_ID='"+encId+"' AND EXISTS(SELECT 'Y' FROM cr_encounter_detail B WHERE  B.PATIENT_CLASS='EM' AND B.FACILITY_ID=A.FACILITY_ID AND B.PATIENT_ID=A.PATIENT_ID AND B.ENCOUNTER_ID=A.ENCOUNTER_ID AND B.ACCESSION_NUM=SUBSTR(A.ACCESSION_NUM,1,21) AND B.EVENT_CLASS='NUR$')";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs !=null)  {
				if(rs.next())  {
					dischargeDate		= checkForNull(rs.getString("DISCHARGE_DATE"));
				
				}
			}
			
			if(pstmt !=null) pstmt.close();
			if(rs !=null) rs.close();

			if(dischargeDate.equals("")){
				sql	= "SELECT A.RESULT_STR DISCHARGE_DATE FROM  cr_encounter_detail A WHERE A.CONTR_SYS_EVENT_CODE='DMA0192' AND A.PATIENT_CLASS='EM' AND A.FACILITY_ID='"+facId+"' AND A.PATIENT_ID='"+patId+"' AND A.ENCOUNTER_ID='"+encId+"' AND EXISTS(SELECT 'Y' FROM cr_encounter_detail B WHERE  B.PATIENT_CLASS='EM' AND B.FACILITY_ID=A.FACILITY_ID AND B.PATIENT_ID=A.PATIENT_ID AND B.ENCOUNTER_ID=A.ENCOUNTER_ID AND B.ACCESSION_NUM=SUBSTR(A.ACCESSION_NUM,1,21)AND B.EVENT_CLASS='PHY$' )";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs !=null)  {
					if(rs.next())  {
						dischargeDate		= checkForNull(rs.getString("DISCHARGE_DATE"));
					}
					
				}
			}
		

		} catch ( Exception e ) {
			System.err.println( e ) ;
		} finally {
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
				} catch(Exception fe){
			}
		}
	
		return dischargeDate;
	}

}
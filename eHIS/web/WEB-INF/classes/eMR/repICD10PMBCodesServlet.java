package eMR;

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


public class repICD10PMBCodesServlet extends javax.servlet.http.HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

    public synchronized void doPost(HttpServletRequest request,	HttpServletResponse response) 
		throws javax.servlet.ServletException,IOException {
		java.util.Properties p		= null;
		HttpSession session			= null;
		Connection conn				=null;
		String facilityId			= "";
		String locale				= "";
		CallableStatement callStmt  = null;
		ResultSet rset				= null;
		Statement stmt				=  null;

		session		= request.getSession(false);
		p			= (java.util.Properties) session.getValue("jdbc");
		facilityId  = (String) session.getValue("facility_id");
		conn		= ConnectionManager.getConnection(request);
		locale		= p.getProperty("LOCALE");
		locale		= (locale == null || locale.equals(""))?"en":locale;

		java.util.Locale loc = new java.util.Locale(locale);

		java.util.ResourceBundle common_labels  = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
		java.util.ResourceBundle mr_labels		= java.util.ResourceBundle.getBundle( "eMR.resources.Labels",loc);
		java.util.ResourceBundle bl_labels		= java.util.ResourceBundle.getBundle( "eBL.resources.Labels",loc);

		java.util.Date dNow1			  = new java.util.Date();
		java.text.SimpleDateFormat ft1 = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		String nameForExcel		  = ft1.format(dNow1);

		String reportType	  = checkForNull(request.getParameter("reportType")); 
        String reporttypeDesc = "";
		String PMBReportID    = "";
			if(reportType.equals("1")){
                reporttypeDesc = mr_labels.getString("eMR.Top10PMBICDCodes.label");
                PMBReportID = "MRT10PMB";
			}
			else if(reportType.equals("2")){
                reporttypeDesc = mr_labels.getString("eMR.PMBCodes.label");
                PMBReportID = "MRPMBCOD";
			}
			else if(reportType.equals("3")){
                reporttypeDesc = mr_labels.getString("eMR.IncompleteICDCodes.label");
                PMBReportID = "MRINCOMP";
			}
			else if(reportType.equals("4")){
                reporttypeDesc = mr_labels.getString("eMR.IncorrectICDCodes.label");
                PMBReportID = "MRINCORCT";
			}

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.addHeader("Content-Disposition", "inline");
		response.setHeader("Content-Disposition","attachment;filename="+PMBReportID+nameForExcel+".xls");

		try {

			java.util.Date dNow			  = new java.util.Date();
			java.text.SimpleDateFormat ft = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm"); 
			String repGenDateTime		  = ft.format(dNow);
		
			HSSFWorkbook workbook         = new HSSFWorkbook();
			HSSFSheet sheet				  = workbook.createSheet(PMBReportID);

			String hdrSql =  "{call get_header_dtls(?,?,?,?,?,?,?,?)}";
			callStmt = conn.prepareCall(hdrSql);
			callStmt.setString(1, "MR");
			callStmt.setString(2, PMBReportID);
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

            /*Search Critiria */
			String patientIDFrom		= checkForNull(request.getParameter("patientIDFrom"));
			String patientIDTO			= checkForNull(request.getParameter("patientIDTO"));
			String visitAdmDateFrom		= checkForNull(request.getParameter("visitAdmDateFrom"));
			String visitAdmDateTo		= checkForNull(request.getParameter("visitAdmDateTo"));
            String billingGroupFrom		= checkForNull(request.getParameter("billingGroupFrom"));
			String billingGroupTo		= checkForNull(request.getParameter("billingGroupTo"));
			String customerFrom			= checkForNull(request.getParameter("customerFrom"));
			String customerTo			= checkForNull(request.getParameter("customerTo"));
			String termcodeFrom			= checkForNull(request.getParameter("termcodeFrom"));
			String termcodeTo			= checkForNull(request.getParameter("termcodeTo"));
            String visitType			= checkForNull(request.getParameter("visitType"));
			String visitType1			= checkForNull(request.getParameter("visitType1"));
			String visitType2			= checkForNull(request.getParameter("visitType2"));
			String visitType3			= checkForNull(request.getParameter("visitType3"));
			String P_facility_id		= checkForNull(request.getParameter("P_facility_id"));
			

			

			/*Search Critiria Labels*/
            String patientIDFromLable		= common_labels.getString("Common.patientId.label")+" "+common_labels.getString("Common.from.label");
			String patientIDTOLable			= common_labels.getString("Common.patientId.label")+" "+common_labels.getString("Common.to.label");
			String visitAdmDateFromLable	= mr_labels.getString("eMR.AdmVisitMonth.label")+" "+common_labels.getString("Common.from.label");
			String visitAdmDateToLable		= mr_labels.getString("eMR.AdmVisitMonth.label")+" "+common_labels.getString("Common.to.label");
            String billingGroupFromLable	= common_labels.getString("Common.BillingGroup.label")+" "+common_labels.getString("Common.from.label");
			String billingGroupToLable		= common_labels.getString("Common.BillingGroup.label")+" "+common_labels.getString("Common.to.label");
			String customerFromLable		= common_labels.getString("Common.Customer.label")+" "+common_labels.getString("Common.from.label");
			String customerToLable			= common_labels.getString("Common.Customer.label")+" "+common_labels.getString("Common.to.label");
			String termcodeFromLable		= mr_labels.getString("eMR.ICD10CODE.label")+" "+common_labels.getString("Common.from.label");
			String termcodeToLable			= mr_labels.getString("eMR.ICD10CODE.label")+" "+common_labels.getString("Common.to.label");
            String visitTypeLable			= common_labels.getString("Common.visittype.label");
			String reportTypeLable			= common_labels.getString("Common.reporttype.label");

			/*write a Search Critirias into Excel*/
			LinkedHashMap searchcritiria = new LinkedHashMap();	
			searchcritiria.put(patientIDFromLable,patientIDFrom);
			searchcritiria.put(patientIDTOLable,patientIDTO);
            searchcritiria.put(visitAdmDateFromLable,visitAdmDateFrom);
            searchcritiria.put(visitAdmDateToLable,visitAdmDateTo);
			searchcritiria.put(billingGroupFromLable,billingGroupFrom);
			searchcritiria.put(billingGroupToLable,billingGroupTo);
			searchcritiria.put(customerFromLable,customerFrom);
			searchcritiria.put(customerToLable,customerTo);
			searchcritiria.put(termcodeFromLable,termcodeFrom);
			searchcritiria.put(termcodeToLable,termcodeTo);
			searchcritiria.put(visitTypeLable,visitType);
			searchcritiria.put(reportTypeLable,reporttypeDesc);

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

            /*write a Search Results header into Excel Start*/
			rowCount		= rowCount+5;
			row = sheet.createRow(rowCount);
            
			sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 0, 3));
			sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 4, 5));
			sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 6, 8));
			sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 9, 13));
			String visitTypeheader	= common_labels.getString("Common.visittype.label");
			String inpatientDates	= common_labels.getString("Common.inpatient.label")+" "+common_labels.getString("Common.date.label")+"s";

			HSSFCellStyle stylem=workbook.createCellStyle();
			stylem.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			stylem.setBorderTop(HSSFCellStyle.BORDER_THIN);
			stylem.setBorderRight(HSSFCellStyle.BORDER_THIN);
			stylem.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			stylem.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			
			row = sheet.createRow(rowCount++);
			int indexrow1 = 0;

            HSSFCell mhc01 = row.createCell(indexrow1++);	
			mhc01.setCellStyle(stylem);

			HSSFCell mhc02 = row.createCell(indexrow1++);	
			mhc02.setCellStyle(stylem);

			HSSFCell mhc03 = row.createCell(indexrow1++);	
			mhc03.setCellStyle(stylem);

			HSSFCell mhc04 = row.createCell(indexrow1++);	
			mhc04.setCellStyle(stylem);

			HSSFCell mhc1 = row.createCell(indexrow1++);	
			mhc1.setCellValue(visitTypeheader);
			mhc1.setCellStyle(stylem);

			HSSFCell mhc12 = row.createCell(indexrow1++);	
			mhc12.setCellStyle(stylem);

			HSSFCell mhc13 = row.createCell(indexrow1++);	
			mhc13.setCellValue(inpatientDates);
			mhc13.setCellStyle(stylem);
		
			HSSFCell mhc2 = row.createCell(indexrow1++);	
			mhc2.setCellStyle(stylem);

			HSSFCell mhc22 = row.createCell(indexrow1++);	
			mhc22.setCellStyle(stylem);

			HSSFCell mhc31 = row.createCell(indexrow1++);	
			mhc31.setCellStyle(stylem);

			HSSFCell mhc32 = row.createCell(indexrow1++);	
			mhc32.setCellStyle(stylem);

			HSSFCell mhc33 = row.createCell(indexrow1++);	
			mhc33.setCellStyle(stylem);

			HSSFCell mhc34 = row.createCell(indexrow1++);	
			mhc34.setCellStyle(stylem);

			HSSFCell mhc35 = row.createCell(indexrow1++);	
			mhc35.setCellStyle(stylem);
			
			LinkedHashMap searchResultsHeader = new LinkedHashMap();
			String ICD10code	= mr_labels.getString("eMR.ICD10.label")+" "+common_labels.getString("Common.code.label")+"/"+mr_labels.getString("eMR.PMBCode.label");
			String episodenumber = bl_labels.getString("eBL.Episode.label")+" "+bl_labels.getString("eBL.NUM.label");
			int index	= 0;
			searchResultsHeader.put(index++,common_labels.getString("Common.patientId.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.age.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.Sex.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.id_passport_assylum.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.opd.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.VisitDate.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.IP.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.admissiondate.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.dischargedate.label"));
			searchResultsHeader.put(index++,mr_labels.getString("eMR.lengthofstay.label"));
			searchResultsHeader.put(index++,episodenumber);
			searchResultsHeader.put(index++,common_labels.getString("Common.BillingGroup.label"));
			searchResultsHeader.put(index++,common_labels.getString("Common.Customer.label"));
			searchResultsHeader.put(index++,ICD10code);
			
			rowCount	= generateSearchResultsHdr(workbook,searchResultsHeader,sheet,row,rowCount);
			/*Write a Search Results header into Excel End*/

			/*Write a Search Results into Excel*/
			String sql	= "";
            if(reportType.equals("3")){

			sql		= "SELECT c.patient_id, TRUNC (MONTHS_BETWEEN (SYSDATE, date_of_birth) / 12) age, c.sex, ( ( CASE WHEN c.national_id_no IS NOT NULL THEN national_id_no ELSE '-' END || '/' ) || (CASE WHEN c.alt_id1_no IS NOT NULL THEN alt_id1_no ELSE '-' END || '/' ) || (CASE WHEN c.alt_id3_no IS NOT NULL THEN alt_id3_no ELSE '-' END || '/' ) || (CASE WHEN c.alt_id4_no IS NOT NULL THEN alt_id4_no ELSE '-' END) ) nat_id, NULL opd, NULL visit_date, decode(d.patient_class,'IP','IP','DC','DC')ipd, decode(d.patient_class,'IP',to_char(d.visit_adm_date_time,'dd/mm/rrrr'),'DC',to_char(d.visit_adm_date_time,'dd/mm/rrrr'))adm_date, to_char(d.discharge_date_time,'dd/mm/yyyy') discharge_date, trunc(d.discharge_date_time - d.visit_adm_date_time)+1 lenght_of_stay, d.encounter_id episode_number, x.BLNG_GRP_ID, (select y.short_name from ar_customer y WHERE x.cust_code = y.cust_code AND x.cust_group_code = y.cust_group_code) customer FROM mp_patient c, pr_encounter d, bl_episode_fin_dtls x WHERE c.patient_id = d.patient_id AND c.patient_id = x.patient_id AND d.patient_id = x.patient_id AND d.encounter_id = x.encounter_id AND d.facility_id = x.operating_facility_id AND adt_status !=09 AND d.patient_class in('IP','DC') AND NOT EXISTS (SELECT 1 FROM pr_diagnosis_enc_dtl b,pr_encounter c WHERE b.patient_id = c.patient_id AND b.patient_id = d.patient_id AND b.encounter_id = d.encounter_id AND b.patient_id = x.patient_id AND b.encounter_id = x.encounter_id AND b.facility_id = d.facility_id AND b.facility_id = x.operating_facility_id AND b.patient_id = c.patient_id AND b.encounter_id = c.encounter_id AND b.facility_id = c.facility_id AND b.status IN ('A','R') AND trunc(c.visit_adm_date_time) between to_date('"+visitAdmDateFrom+"','mm/yyyy') and LAST_DAY(to_date('"+visitAdmDateTo+"','mm/yyyy')) ) AND c.patient_id between NVL('"+patientIDFrom+"','!') and NVL('"+patientIDTO+"','~') AND trunc(d.visit_adm_date_time) between to_date('"+visitAdmDateFrom+"','mm/yyyy') and LAST_DAY(to_date('"+visitAdmDateTo+"','mm/yyyy')) AND x.blng_grp_id between NVL('"+billingGroupFrom+"','!') and NVl('"+billingGroupTo+"','~') AND NVL(x.cust_code,'X') between NVl('"+customerFrom+"','!') and NVl('"+customerTo+"','~') AND d.facility_id = '"+P_facility_id+"' AND (('"+visitType1+"'= 'IP' AND d.patient_class IN ('IP','DC')) OR (('"+visitType1+"' IS NULL AND '"+visitType2+"' IS NULL AND '"+visitType3+"' IS NULL) AND d.patient_class IN('IP','DC','EM','OP'))) UNION ALL SELECT c.patient_id, TRUNC (MONTHS_BETWEEN (SYSDATE, date_of_birth) / 12) age, c.sex, ( ( CASE WHEN c.national_id_no IS NOT NULL THEN national_id_no ELSE '-' END || '/' ) || (CASE WHEN c.alt_id1_no IS NOT NULL THEN alt_id1_no ELSE '-' END || '/' ) || (CASE WHEN c.alt_id3_no IS NOT NULL THEN alt_id3_no ELSE '-' END || '/' ) || (CASE WHEN c.alt_id4_no IS NOT NULL THEN alt_id4_no ELSE '-' END) ) nat_id, decode(d.patient_class,'OP','OP','EM','AE')opd, decode(d.patient_class,'OP',to_char(d.visit_adm_date_time,'dd/mm/rrrr'),'EM',to_char(d.visit_adm_date_time,'dd/mm/rrrr'))visit_date, NULL, NULL, NULL discharge_date, NULL lenght_of_stay, d.encounter_id episode_number,x.BLNG_GRP_ID, (select short_name from ar_customer y where x.cust_code = y.cust_code AND x.cust_group_code = y.cust_group_code)customer FROM mp_patient c, pr_encounter d, bl_visit_fin_dtls x WHERE c.patient_id = d.patient_id AND c.patient_id = x.patient_id AND d.patient_id = x.patient_id AND d.encounter_id = x.encounter_id AND d.facility_id = x.operating_facility_id AND d.visit_status !=99 AND d.patient_class in('OP','EM') AND NOT EXISTS (SELECT 1 FROM pr_diagnosis_enc_dtl b,pr_encounter c WHERE b.patient_id = c.patient_id AND b.patient_id = d.patient_id AND b.encounter_id = d.encounter_id AND b.patient_id = x.patient_id AND b.encounter_id = x.encounter_id AND b.facility_id = d.facility_id AND b.facility_id = x.operating_facility_id AND b.patient_id = c.patient_id AND b.encounter_id = c.encounter_id AND b.facility_id = c.facility_id AND b.status IN ('A','R') AND trunc(c.visit_adm_date_time) between to_date('"+visitAdmDateFrom+"','mm/yyyy') and LAST_DAY(to_date('"+visitAdmDateTo+"','mm/yyyy')) ) AND c.patient_id between NVL('"+patientIDFrom+"','!') and NVL('"+patientIDTO+"','~') AND trunc(d.visit_adm_date_time) between to_date('"+visitAdmDateFrom+"','mm/yyyy') and LAST_DAY(to_date('"+visitAdmDateTo+"','mm/yyyy')) AND x.blng_grp_id between NVL('"+billingGroupFrom+"','!') and NVl('"+billingGroupTo+"','~') AND NVL(x.cust_code,'X') between NVl('"+customerFrom+"','!') and NVl('"+customerTo+"','~') AND d.facility_id = '"+P_facility_id+"' AND ( ('"+visitType2+"' = 'OP' AND d.patient_class ='OP') OR ('"+visitType3+"' = 'EM' AND d.patient_class ='EM') OR (('"+visitType1+"' IS NULL AND '"+visitType2+"' IS NULL AND '"+visitType3+"' IS NULL ) AND d.patient_class IN('OP','EM','IP','DC'))) ORDER by patient_id";

			}

			if(reportType.equals("2")){

			sql		= "SELECT d.facility_id, d.patient_id, d.encounter_id, b.term_code term_code_order, b.term_code || '/' || (SELECT pmb_code FROM mr_pmb_code x WHERE x.term_code = b.term_code AND ROWNUM = 1) term_code, TRUNC (MONTHS_BETWEEN (SYSDATE, e.date_of_birth) / 12) age, e.sex, ( ( CASE WHEN e.national_id_no IS NOT NULL THEN national_id_no ELSE '-' END || '/' ) || (CASE WHEN e.alt_id1_no IS NOT NULL THEN alt_id1_no ELSE '-' END || '/') || (CASE WHEN e.alt_id3_no IS NOT NULL THEN alt_id3_no ELSE '-' END || '/') || (CASE WHEN e.alt_id4_no IS NOT NULL THEN alt_id4_no ELSE '-' END) ) nat_id, NULL opd, NULL visit_date, DECODE (d.patient_class, 'IP', 'IP', 'DC', 'DC') ipd, DECODE (d.patient_class, 'IP', TO_CHAR (d.visit_adm_date_time, 'dd/mm/rrrr'), 'DC', TO_CHAR (d.visit_adm_date_time, 'dd/mm/rrrr') ) adm_date, TO_CHAR (d.discharge_date_time, 'dd/mm/yyyy') discharge_date, TRUNC (d.discharge_date_time - d.visit_adm_date_time) + 1 lenght_of_stay, d.encounter_id episode_number, f.blng_grp_id, (SELECT y.short_name FROM ar_customer y WHERE f.cust_code = y.cust_code AND f.cust_group_code = y.cust_group_code) customer FROM pr_diagnosis_enc_dtl b, pr_encounter d, mp_patient e, bl_episode_fin_dtls f WHERE b.patient_id = d.patient_id AND b.encounter_id = d.encounter_id AND b.patient_id = e.patient_id AND b.patient_id = f.patient_id AND b.encounter_id = f.encounter_id AND d.patient_id = e.patient_id AND d.patient_id = f.patient_id AND d.encounter_id = f.encounter_id AND d.patient_class IN ('IP', 'DC') AND b.status !='E' AND e.patient_id BETWEEN NVL ('"+patientIDFrom+"', '!') AND NVL ('"+patientIDTO+"', '~') AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy') AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND f.blng_grp_id BETWEEN NVL ('"+billingGroupFrom+"', '!') AND NVL ('"+billingGroupTo+"', '~') AND NVL (f.cust_code, 'X') BETWEEN NVL ('"+customerFrom+"', '!') AND NVL ('"+customerTo+"', '~') AND b.term_code BETWEEN NVL ('"+termcodeFrom+"', '!') AND NVL ('"+termcodeTo+"', '~') AND d.facility_id = '"+P_facility_id+"' AND ( ('"+visitType1+"' = 'IP' AND d.patient_class IN ('IP', 'DC')) OR ( ( '"+visitType1+"' IS NULL AND '"+visitType2+"' IS NULL AND '"+visitType3+"' IS NULL ) AND d.patient_class IN ('IP', 'DC', 'EM', 'OP') ) ) AND EXISTS (SELECT 'Y' FROM mr_pmb_code x WHERE x.term_code = b.term_code) AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy') AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND NOT EXISTS ( SELECT 'Y' FROM pr_support_diagnosis x WHERE x.patient_id = b.patient_id AND x.term_set_id = b.term_set_id AND x.term_code = b.term_code) UNION SELECT b.facility_id, b.patient_id, b.encounter_id, c.term_code, c.term_code || '/' || (SELECT pmb_code FROM mr_pmb_code x WHERE x.term_code = b.term_code AND x.term_support_code = c.supp_term_code AND ROWNUM = 1) term_code, TRUNC (MONTHS_BETWEEN (SYSDATE, e.date_of_birth) / 12) age, e.sex, ( ( CASE WHEN e.national_id_no IS NOT NULL THEN national_id_no ELSE '-' END || '/' ) || (CASE WHEN e.alt_id1_no IS NOT NULL THEN alt_id1_no ELSE '-' END || '/') || (CASE WHEN e.alt_id3_no IS NOT NULL THEN alt_id3_no ELSE '-' END || '/') || (CASE WHEN e.alt_id4_no IS NOT NULL THEN alt_id4_no ELSE '-' END) ) nat_id, NULL opd, NULL visit_date, DECODE (d.patient_class, 'IP', 'IP', 'DC', 'DC') ipd, DECODE (d.patient_class, 'IP', TO_CHAR (d.visit_adm_date_time, 'dd/mm/rrrr'), 'DC', TO_CHAR (d.visit_adm_date_time, 'dd/mm/rrrr') ) adm_date, TO_CHAR (d.discharge_date_time, 'dd/mm/yyyy') discharge_date, TRUNC (d.discharge_date_time - d.visit_adm_date_time) + 1 lenght_of_stay, d.encounter_id episode_number, f.blng_grp_id, (SELECT y.short_name FROM ar_customer y WHERE f.cust_code = y.cust_code AND f.cust_group_code = y.cust_group_code) customer FROM pr_diagnosis_enc_dtl b, pr_support_diagnosis c, pr_encounter d, mp_patient e, bl_episode_fin_dtls f WHERE b.patient_id = c.patient_id AND b.term_set_id = c.term_set_id AND b.term_code = c.term_code AND b.patient_id = c.patient_id AND b.occur_srl_no = c.occur_srl_no AND b.patient_id = d.patient_id AND b.encounter_id = d.encounter_id AND b.patient_id = e.patient_id AND b.patient_id = f.patient_id AND b.encounter_id = f.encounter_id AND c.patient_id = e.patient_id AND c.patient_id = f.patient_id AND d.patient_id = e.patient_id AND d.patient_id = f.patient_id AND d.encounter_id = f.encounter_id AND e.patient_id = f.patient_id AND d.patient_class IN ('IP', 'DC') AND b.status != 'E' AND e.patient_id BETWEEN NVL ('"+patientIDFrom+"', '!') AND NVL ('"+patientIDTO+"', '~') AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy') AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND f.blng_grp_id BETWEEN NVL ('"+billingGroupFrom+"', '!') AND NVL ('"+billingGroupTo+"', '~') AND NVL (f.cust_code, 'X') BETWEEN NVL ('"+customerFrom+"', '!') AND NVL ('"+customerTo+"', '~') AND b.term_code BETWEEN NVL ('"+termcodeFrom+"', '!') AND NVL ('"+termcodeTo+"', '~') AND d.facility_id = '"+P_facility_id+"' AND ( ('"+visitType1+"' = 'IP' AND d.patient_class IN ('IP', 'DC')) OR ( ( '"+visitType1+"' IS NULL AND '"+visitType2+"' IS NULL AND '"+visitType3+"' IS NULL ) AND d.patient_class IN ('IP', 'DC', 'EM', 'OP') ) ) AND EXISTS ( SELECT 'Y' FROM mr_pmb_code x WHERE x.term_code = b.term_code AND x.term_support_code = c.supp_term_code) AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy') AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND (b.facility_id, b.patient_id, b.encounter_id, c.term_code) NOT IN ( SELECT b.facility_id, b.patient_id, b.encounter_id, c.term_code FROM pr_diagnosis_enc_dtl b, pr_support_diagnosis c, pr_encounter d WHERE b.patient_id = c.patient_id AND b.term_set_id = c.term_set_id AND b.term_code = c.term_code AND b.patient_id = c.patient_id AND b.occur_srl_no = c.occur_srl_no AND b.patient_id = d.patient_id AND b.encounter_id = d.encounter_id AND NOT EXISTS ( SELECT 'Y' FROM mr_pmb_code x WHERE x.term_code = b.term_code AND x.term_support_code = c.supp_term_code) AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy' ) AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) )) UNION ALL SELECT d.facility_id, d.patient_id, d.encounter_id, b.term_code term_code_order, b.term_code || '/' || (SELECT pmb_code FROM mr_pmb_code x WHERE x.term_code = b.term_code AND ROWNUM = 1) term_code, TRUNC (MONTHS_BETWEEN (SYSDATE, e.date_of_birth) / 12) age, e.sex, ( ( CASE WHEN e.national_id_no IS NOT NULL THEN national_id_no ELSE '-' END || '/' ) || (CASE WHEN e.alt_id1_no IS NOT NULL THEN alt_id1_no ELSE '-' END || '/') || (CASE WHEN e.alt_id3_no IS NOT NULL THEN alt_id3_no ELSE '-' END || '/') || (CASE WHEN e.alt_id4_no IS NOT NULL THEN alt_id4_no ELSE '-' END) ) nat_id, DECODE (d.patient_class, 'OP', 'OP', 'EM', 'AE') opd, DECODE (d.patient_class, 'OP', TO_CHAR (d.visit_adm_date_time, 'dd/mm/rrrr'), 'EM', TO_CHAR (d.visit_adm_date_time, 'dd/mm/rrrr') ) visit_date, NULL, NULL, NULL discharge_date, NULL lenght_of_stay, d.encounter_id episode_number, f.blng_grp_id, (SELECT y.short_name FROM ar_customer y WHERE f.cust_code = y.cust_code AND f.cust_group_code = y.cust_group_code) customer FROM pr_diagnosis_enc_dtl b, pr_encounter d, mp_patient e, bl_visit_fin_dtls f WHERE b.patient_id = d.patient_id AND b.encounter_id = d.encounter_id AND b.patient_id = e.patient_id AND b.patient_id = f.patient_id AND b.encounter_id = f.encounter_id AND d.patient_id = e.patient_id AND d.patient_id = f.patient_id AND d.encounter_id = f.encounter_id AND d.patient_class IN ('OP', 'EM') AND b.status !='E' AND e.patient_id BETWEEN NVL ('"+patientIDFrom+"', '!') AND NVL ('"+patientIDTO+"', '~') AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy') AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND f.blng_grp_id BETWEEN NVL ('"+billingGroupFrom+"', '!') AND NVL ('"+billingGroupTo+"', '~') AND NVL (f.cust_code, 'X') BETWEEN NVL ('"+customerFrom+"', '!') AND NVL ('"+customerTo+"', '~') AND b.term_code BETWEEN NVL ('"+termcodeFrom+"', '!') AND NVL ('"+termcodeTo+"', '~') AND d.facility_id = '"+P_facility_id+"' AND ( ('"+visitType2+"' = 'OP' AND d.patient_class = 'OP') OR ('"+visitType3+"' = 'EM' AND d.patient_class = 'EM') OR ( ( '"+visitType1+"' IS NULL AND '"+visitType2+"' IS NULL AND '"+visitType3+"' IS NULL ) AND d.patient_class IN ('OP', 'EM', 'IP', 'DC') ) ) AND EXISTS (SELECT 'Y' FROM mr_pmb_code x WHERE x.term_code = b.term_code) AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy') AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND NOT EXISTS ( SELECT 'Y' FROM pr_support_diagnosis x WHERE x.patient_id = b.patient_id AND x.term_set_id = b.term_set_id AND x.term_code = b.term_code) UNION SELECT b.facility_id, b.patient_id, b.encounter_id, c.term_code, c.term_code || '/' || (SELECT pmb_code FROM mr_pmb_code x WHERE x.term_code = b.term_code AND x.term_support_code = c.supp_term_code AND ROWNUM = 1) term_code, TRUNC (MONTHS_BETWEEN (SYSDATE, e.date_of_birth) / 12) age, e.sex, ( ( CASE WHEN e.national_id_no IS NOT NULL THEN national_id_no ELSE '-' END || '/' ) || (CASE WHEN e.alt_id1_no IS NOT NULL THEN alt_id1_no ELSE '-' END || '/') || (CASE WHEN e.alt_id3_no IS NOT NULL THEN alt_id3_no ELSE '-' END || '/') || (CASE WHEN e.alt_id4_no IS NOT NULL THEN alt_id4_no ELSE '-' END) ) nat_id, DECODE (d.patient_class, 'OP', 'OP', 'EM', 'AE') opd, DECODE (d.patient_class, 'OP', TO_CHAR (d.visit_adm_date_time, 'dd/mm/rrrr'), 'EM', TO_CHAR (d.visit_adm_date_time, 'dd/mm/rrrr') ) visit_date, NULL, NULL, NULL discharge_date, NULL lenght_of_stay, d.encounter_id episode_number, f.blng_grp_id, (SELECT y.short_name FROM ar_customer y WHERE f.cust_code = y.cust_code AND f.cust_group_code = y.cust_group_code) customer FROM pr_diagnosis_enc_dtl b, pr_support_diagnosis c, pr_encounter d, mp_patient e, bl_visit_fin_dtls f WHERE b.patient_id = c.patient_id AND b.term_set_id = c.term_set_id AND b.term_code = c.term_code AND b.patient_id = c.patient_id AND b.occur_srl_no = c.occur_srl_no AND b.patient_id = d.patient_id AND b.encounter_id = d.encounter_id AND b.patient_id = e.patient_id AND b.patient_id = f.patient_id AND b.encounter_id = f.encounter_id AND c.patient_id = e.patient_id AND c.patient_id = f.patient_id AND d.patient_id = e.patient_id AND d.patient_id = f.patient_id AND d.encounter_id = f.encounter_id AND e.patient_id = f.patient_id AND d.patient_class IN ('OP', 'EM') AND b.status != 'E' AND e.patient_id BETWEEN NVL ('"+patientIDFrom+"', '!') AND NVL ('"+patientIDTO+"', '~') AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy') AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND f.blng_grp_id BETWEEN NVL ('"+billingGroupFrom+"', '!') AND NVL ('"+billingGroupTo+"', '~') AND NVL (f.cust_code, 'X') BETWEEN NVL ('"+customerFrom+"', '!') AND NVL ('"+customerTo+"', '~') AND b.term_code BETWEEN NVL ('"+termcodeFrom+"', '!') AND NVL ('"+termcodeTo+"', '~') AND d.facility_id = '"+P_facility_id+"' AND ( ('"+visitType2+"' = 'OP' AND d.patient_class = 'OP') OR ('"+visitType3+"' = 'EM' AND d.patient_class = 'EM') OR ( ( '"+visitType1+"' IS NULL AND '"+visitType2+"' IS NULL AND '"+visitType3+"' IS NULL ) AND d.patient_class IN ('OP', 'EM', 'IP', 'DC') ) ) AND EXISTS ( SELECT 'Y' FROM mr_pmb_code x WHERE x.term_code = b.term_code AND x.term_support_code = c.supp_term_code) AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy') AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND (b.facility_id, b.patient_id, b.encounter_id, c.term_code) NOT IN ( SELECT b.facility_id, b.patient_id, b.encounter_id, c.term_code FROM pr_diagnosis_enc_dtl b, pr_support_diagnosis c, pr_encounter d WHERE b.patient_id = c.patient_id AND b.term_set_id = c.term_set_id AND b.term_code = c.term_code AND b.patient_id = c.patient_id AND b.occur_srl_no = c.occur_srl_no AND b.patient_id = d.patient_id AND b.encounter_id = d.encounter_id AND NOT EXISTS ( SELECT 'Y' FROM mr_pmb_code x WHERE x.term_code = b.term_code AND x.term_support_code = c.supp_term_code) AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy' ) AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ))ORDER BY patient_id, term_code_order";

			}

			if(reportType.equals("4")){

			sql		= "SELECT c.patient_id,CASE WHEN a.pmb_code is not null THEN a.orig_term_code||'/'||a.pmb_code ELSE a.orig_term_code END term_code, TRUNC (MONTHS_BETWEEN (SYSDATE, date_of_birth) / 12) age, c.sex, ( ( CASE WHEN c.national_id_no IS NOT NULL THEN national_id_no ELSE '-' END || '/' ) || (CASE WHEN c.alt_id1_no IS NOT NULL THEN alt_id1_no ELSE '-' END || '/' ) || (CASE WHEN c.alt_id3_no IS NOT NULL THEN alt_id3_no ELSE '-' END || '/' ) || (CASE WHEN c.alt_id4_no IS NOT NULL THEN alt_id4_no ELSE '-' END) ) nat_id, NULL opd, NULL visit_date, decode(d.patient_class,'IP','IP','DC','DC')ipd, decode(d.patient_class,'IP',to_char(d.visit_adm_date_time,'dd/mm/rrrr'),'DC',to_char(d.visit_adm_date_time,'dd/mm/rrrr'))adm_date, to_char(d.discharge_date_time,'dd/mm/yyyy') discharge_date, trunc(d.discharge_date_time - d.visit_adm_date_time)+1 lenght_of_stay, d.encounter_id episode_number, x.BLNG_GRP_ID, (select y.short_name from ar_customer y WHERE x.cust_code = y.cust_code AND x.cust_group_code = y.cust_group_code) customer FROM (SELECT distinct y.patient_id, y.encounter_id, y.facility_id, y.ORIG_TERM_CODE,z.pmb_code FROM mr_diagnosis_recoding_dtl y, mr_diag_proc_recoding_hdr x,mr_pmb_code z WHERE y.facility_id = x.facility_id AND x.encounter_id = y.encounter_id AND x.patient_id = y.patient_id AND y.orig_term_code = z.term_code(+) AND (x.level1_status = 'A' OR x.level3_status = 'A' OR x.level3_status = 'A' ) AND y.status != 'E' AND y.recode_status = 'R' AND EXISTS (SELECT 'Y' FROM pr_diagnosis_enc_dtl a WHERE a.patient_id = y.patient_id AND a.encounter_id = y.encounter_id AND a.facility_id = y.facility_id AND a.patient_id = x.patient_id AND a.encounter_id = x.encounter_id AND a.facility_id = x.facility_id AND a.status != 'E' AND a.term_code = y.orig_term_code AND a.term_set_id = y.orig_term_set_id)) a, mp_patient c, pr_encounter d, bl_episode_fin_dtls x WHERE a.patient_id = c.patient_id AND a.patient_id = d.patient_id AND a.encounter_id = d.encounter_id AND a.patient_id = x.patient_id AND a.encounter_id = x.encounter_id AND c.patient_id = d.patient_id AND c.patient_id = x.patient_id AND d.patient_id = x.patient_id AND d.encounter_id = x.encounter_id AND d.facility_id = x.operating_facility_id AND d.adt_status !=09 AND c.patient_id between NVL('"+patientIDFrom+"','!') and NVL('"+patientIDTO+"','~') AND trunc(d.visit_adm_date_time) between to_date('"+visitAdmDateFrom+"','mm/yyyy') and LAST_DAY(to_date('"+visitAdmDateTo+"','mm/yyyy')) AND x.blng_grp_id between NVL('"+billingGroupFrom+"','!') and NVl('"+billingGroupTo+"','~') AND NVL(x.cust_code,'X') between NVl('"+customerFrom+"','!') and NVl('"+customerTo+"','~') AND a.orig_term_code between NVL('"+termcodeFrom+"','!') and NVL('"+termcodeTo+"','~') AND d.facility_id = '"+P_facility_id+"' AND (('"+visitType1+"'= 'IP' AND d.patient_class IN ('IP','DC')) OR (('"+visitType1+"' IS NULL AND '"+visitType2+"' IS NULL AND '"+visitType3+"' IS NULL) AND d.patient_class IN('IP','DC','EM','OP'))) UNION ALL SELECT c.patient_id,CASE WHEN a.pmb_code is not null THEN a.orig_term_code||'/'||a.pmb_code ELSE a.orig_term_code END term_code, TRUNC (MONTHS_BETWEEN (SYSDATE, date_of_birth) / 12) age, c.sex, ( ( CASE WHEN c.national_id_no IS NOT NULL THEN national_id_no ELSE '-' END || '/' ) || (CASE WHEN c.alt_id1_no IS NOT NULL THEN alt_id1_no ELSE '-' END || '/' ) || (CASE WHEN c.alt_id3_no IS NOT NULL THEN alt_id3_no ELSE '-' END || '/' ) || (CASE WHEN c.alt_id4_no IS NOT NULL THEN alt_id4_no ELSE '-' END) ) nat_id, decode(d.patient_class,'OP','OP','EM','AE')opd, decode(d.patient_class,'OP',to_char(d.visit_adm_date_time,'dd/mm/rrrr'),'EM',to_char(d.visit_adm_date_time,'dd/mm/rrrr'))visit_date, NULL, NULL, NULL discharge_date, NULL lenght_of_stay, d.encounter_id episode_number,x.BLNG_GRP_ID, (select y.short_name from ar_customer y where x.cust_code = y.cust_code AND x.cust_group_code = y.cust_group_code)customer FROM (SELECT distinct y.patient_id, y.encounter_id, y.facility_id, y.ORIG_TERM_CODE,z.pmb_code FROM mr_diagnosis_recoding_dtl y, mr_diag_proc_recoding_hdr x,mr_pmb_code z WHERE y.facility_id = x.facility_id AND x.encounter_id = y.encounter_id AND x.patient_id = y.patient_id AND y.orig_term_code = z.term_code(+) AND (x.level1_status = 'A' OR x.level3_status = 'A' OR x.level3_status = 'A' ) AND y.status != 'E' AND y.recode_status = 'R' AND EXISTS (SELECT 'Y' FROM pr_diagnosis_enc_dtl a WHERE a.patient_id = y.patient_id AND a.encounter_id = y.encounter_id AND a.facility_id = y.facility_id AND a.patient_id = x.patient_id AND a.encounter_id = x.encounter_id AND a.facility_id = x.facility_id AND a.status != 'E' AND a.term_code = y.orig_term_code AND a.term_set_id = y.orig_term_set_id)) a, mp_patient c, pr_encounter d, bl_visit_fin_dtls x WHERE a.patient_id = c.patient_id AND a.patient_id = d.patient_id AND a.encounter_id = d.encounter_id AND a.patient_id = x.patient_id AND a.encounter_id = x.encounter_id AND c.patient_id = d.patient_id AND c.patient_id = x.patient_id AND d.patient_id = x.patient_id AND d.encounter_id = x.encounter_id AND d.facility_id = x.operating_facility_id AND d.visit_status !=99 AND c.patient_id between NVL('"+patientIDFrom+"','!') and NVL('"+patientIDTO+"','~') AND trunc(d.visit_adm_date_time) between to_date('"+visitAdmDateFrom+"','mm/yyyy') and LAST_DAY(to_date('"+visitAdmDateTo+"','mm/yyyy')) AND x.blng_grp_id between NVL('"+billingGroupFrom+"','!') and NVl('"+billingGroupTo+"','~') AND NVL(x.cust_code,'X') between NVl('"+customerFrom+"','!') and NVl('"+customerTo+"','~') AND a.orig_term_code between NVL('"+termcodeFrom+"','!') and NVL('"+termcodeTo+"','~') AND d.facility_id = '"+P_facility_id+"' AND ( ('"+visitType2+"' = 'OP' AND d.patient_class ='OP') OR ('"+visitType3+"' = 'EM' AND d.patient_class ='EM') OR (('"+visitType1+"' IS NULL AND '"+visitType2+"' IS NULL AND '"+visitType3+"' IS NULL ) AND d.patient_class IN('OP','EM','IP','DC'))) ORDER BY TERM_CODE asc,patient_id";
			}

			if(reportType.equals("1")){

			sql		= "SELECT c.patient_id, b.term_code term_code, a.term_code_cnt, b.term_code || '/' || (SELECT pmb_code FROM mr_pmb_code x WHERE x.term_code = b.term_code AND ROWNUM = 1) term_code_pmb, TRUNC (MONTHS_BETWEEN (SYSDATE, date_of_birth) / 12) age, c.sex, ( ( CASE WHEN c.national_id_no IS NOT NULL THEN national_id_no ELSE '-' END || '/' ) || (CASE WHEN c.alt_id1_no IS NOT NULL THEN alt_id1_no ELSE '-' END || '/') || (CASE WHEN c.alt_id3_no IS NOT NULL THEN alt_id3_no ELSE '-' END || '/') || (CASE WHEN c.alt_id4_no IS NOT NULL THEN alt_id4_no ELSE '-' END) ) nat_id, NULL opd, NULL visit_date, DECODE (d.patient_class, 'IP', 'IP', 'DC', 'DC') ipd, DECODE (d.patient_class, 'IP', TO_CHAR (d.visit_adm_date_time, 'dd/mm/rrrr'), 'DC', TO_CHAR (d.visit_adm_date_time, 'dd/mm/rrrr') ) adm_date, TO_CHAR (d.discharge_date_time, 'dd/mm/yyyy') discharge_date, TRUNC (d.discharge_date_time - d.visit_adm_date_time ) + 1 lenght_of_stay, d.encounter_id episode_number, x.blng_grp_id, (SELECT y.short_name FROM ar_customer y WHERE x.cust_code = y.cust_code AND x.cust_group_code = y.cust_group_code) customer FROM (SELECT term_code_cnt, term_code FROM (SELECT COUNT (b.term_code) term_code_cnt, b.term_code FROM pr_diagnosis_enc_dtl b, pr_encounter d WHERE b.patient_id = d.patient_id AND b.encounter_id = d.encounter_id AND b.status != 'E' AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy' ) AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND b.term_code BETWEEN NVL ('"+termcodeFrom+"', '!') AND NVL ('"+termcodeTo+"', '~') AND d.facility_id = '"+P_facility_id+"' AND EXISTS (SELECT 'Y' FROM mr_pmb_code x WHERE x.term_code = b.term_code) AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy' ) AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND ('"+visitType1+"' = 'IP' AND d.patient_class IN ('IP', 'DC') OR ('"+visitType2+"' = 'OP' AND d.patient_class = 'OP') OR ('"+visitType3+"' = 'EM' AND d.patient_class = 'EM') OR ( ( '"+visitType1+"' IS NULL AND '"+visitType2+"' IS NULL AND '"+visitType3+"' IS NULL ) AND d.patient_class IN ('IP', 'DC', 'EM', 'OP') ) ) AND NOT EXISTS ( SELECT 'Y' FROM pr_support_diagnosis x WHERE x.patient_id = b.patient_id AND x.term_set_id = b.term_set_id AND x.term_code = b.term_code) GROUP BY b.term_code UNION SELECT COUNT (c.term_code) term_code_cnt, c.term_code FROM pr_diagnosis_enc_dtl b, pr_support_diagnosis c, pr_encounter d WHERE b.patient_id = c.patient_id AND b.term_set_id = c.term_set_id AND b.term_code = c.term_code AND b.patient_id = c.patient_id AND b.occur_srl_no = c.occur_srl_no AND b.patient_id = d.patient_id AND b.encounter_id = d.encounter_id AND b.status != 'E' AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy' ) AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND b.term_code BETWEEN NVL ('"+termcodeFrom+"', '!') AND NVL ('"+termcodeTo+"', '~') AND d.facility_id = '"+P_facility_id+"' AND EXISTS ( SELECT 'Y' FROM mr_pmb_code x WHERE x.term_code = b.term_code AND x.term_support_code = c.supp_term_code) AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy' ) AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND ('"+visitType1+"' = 'IP' AND d.patient_class IN ('IP', 'DC') OR ('"+visitType2+"' = 'OP' AND d.patient_class = 'OP') OR ('"+visitType3+"' = 'EM' AND d.patient_class = 'EM') OR ( ( '"+visitType1+"' IS NULL AND '"+visitType2+"' IS NULL AND '"+visitType3+"' IS NULL ) AND d.patient_class IN ('IP', 'DC', 'EM', 'OP') ) ) AND (b.facility_id, b.patient_id, b.encounter_id, c.term_code ) NOT IN ( SELECT b.facility_id, b.patient_id, b.encounter_id, c.term_code FROM pr_diagnosis_enc_dtl b, pr_support_diagnosis c, pr_encounter d WHERE b.patient_id = c.patient_id AND b.term_set_id = c.term_set_id AND b.term_code = c.term_code AND b.patient_id = c.patient_id AND b.occur_srl_no = c.occur_srl_no AND b.patient_id = d.patient_id AND b.encounter_id = d.encounter_id AND NOT EXISTS ( SELECT 'Y' FROM mr_pmb_code x WHERE x.term_code = b.term_code AND x.term_support_code = c.supp_term_code) AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy' ) AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) )) GROUP BY c.term_code ORDER BY term_code_cnt DESC) WHERE ROWNUM <= 10) a, pr_diagnosis_enc_dtl b, mp_patient c, pr_encounter d, bl_episode_fin_dtls x WHERE a.term_code = b.term_code AND b.patient_id = c.patient_id AND b.patient_id = d.patient_id AND b.encounter_id = d.encounter_id AND b.patient_id = x.patient_id AND b.encounter_id = x.encounter_id AND b.facility_id = d.facility_id AND b.facility_id = x.operating_facility_id AND c.patient_id = d.patient_id AND c.patient_id = x.patient_id AND d.patient_id = x.patient_id AND d.encounter_id = x.encounter_id AND d.facility_id = x.operating_facility_id AND adt_status != 09 AND b.status != 'E' AND c.patient_id BETWEEN NVL ('"+patientIDFrom+"', '!') AND NVL ('"+patientIDTO+"', '~') AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy' ) AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND x.blng_grp_id BETWEEN NVL ('"+billingGroupFrom+"', '!') AND NVL ('"+billingGroupTo+"', '~') AND NVL (x.cust_code, 'X') BETWEEN NVL ('"+customerFrom+"', '!') AND NVL ('"+customerTo+"', '~') AND b.term_code BETWEEN NVL ('"+termcodeFrom+"', '!') AND NVL ('"+termcodeTo+"', '~') AND d.facility_id = '"+P_facility_id+"' AND ( ('"+visitType1+"' = 'IP' AND d.patient_class IN ('IP', 'DC')) OR ( ( '"+visitType1+"' IS NULL AND '"+visitType2+"' IS NULL AND '"+visitType3+"' IS NULL ) AND d.patient_class IN ('IP', 'DC', 'EM', 'OP') ) ) UNION ALL SELECT c.patient_id, b.term_code term_code, a.term_code_cnt, b.term_code || '/' || (SELECT pmb_code FROM mr_pmb_code x WHERE x.term_code = b.term_code AND ROWNUM = 1) term_code_pmb, TRUNC (MONTHS_BETWEEN (SYSDATE, date_of_birth) / 12) age, c.sex, ( ( CASE WHEN c.national_id_no IS NOT NULL THEN national_id_no ELSE '-' END || '/' ) || (CASE WHEN c.alt_id1_no IS NOT NULL THEN alt_id1_no ELSE '-' END || '/') || (CASE WHEN c.alt_id3_no IS NOT NULL THEN alt_id3_no ELSE '-' END || '/') || (CASE WHEN c.alt_id4_no IS NOT NULL THEN alt_id4_no ELSE '-' END) ) nat_id, DECODE (d.patient_class, 'OP', 'OP', 'EM', 'AE') opd, DECODE (d.patient_class, 'OP', TO_CHAR (d.visit_adm_date_time, 'dd/mm/rrrr'), 'EM', TO_CHAR (d.visit_adm_date_time, 'dd/mm/rrrr') ) visit_date, NULL, NULL, NULL discharge_date, NULL lenght_of_stay, d.encounter_id episode_number, f.blng_grp_id, (SELECT y.short_name FROM ar_customer y WHERE f.cust_code = y.cust_code AND f.cust_group_code = y.cust_group_code) customer FROM (SELECT term_code_cnt, term_code FROM (SELECT COUNT (b.term_code) term_code_cnt, b.term_code FROM pr_diagnosis_enc_dtl b, pr_encounter d WHERE b.patient_id = d.patient_id AND b.encounter_id = d.encounter_id AND b.status != 'E' AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy' ) AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND b.term_code BETWEEN NVL ('"+termcodeFrom+"', '!') AND NVL ('"+termcodeTo+"', '~') AND d.facility_id = '"+P_facility_id+"' AND EXISTS (SELECT 'Y' FROM mr_pmb_code x WHERE x.term_code = b.term_code) AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy' ) AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND ('"+visitType1+"' = 'IP' AND d.patient_class IN ('IP', 'DC') OR ('"+visitType2+"' = 'OP' AND d.patient_class = 'OP') OR ('"+visitType3+"' = 'EM' AND d.patient_class = 'EM') OR ( ( '"+visitType1+"' IS NULL AND '"+visitType2+"' IS NULL AND '"+visitType3+"' IS NULL ) AND d.patient_class IN ('IP', 'DC', 'EM', 'OP') ) ) AND NOT EXISTS ( SELECT 'Y' FROM pr_support_diagnosis x WHERE x.patient_id = b.patient_id AND x.term_set_id = b.term_set_id AND x.term_code = b.term_code) GROUP BY b.term_code UNION SELECT COUNT (c.term_code) term_code_cnt, c.term_code FROM pr_diagnosis_enc_dtl b, pr_support_diagnosis c, pr_encounter d WHERE b.patient_id = c.patient_id AND b.term_set_id = c.term_set_id AND b.term_code = c.term_code AND b.patient_id = c.patient_id AND b.occur_srl_no = c.occur_srl_no AND b.patient_id = d.patient_id AND b.encounter_id = d.encounter_id AND b.status != 'E' AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy' ) AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND b.term_code BETWEEN NVL ('"+termcodeFrom+"', '!') AND NVL ('"+termcodeTo+"', '~') AND d.facility_id = '"+P_facility_id+"' AND EXISTS ( SELECT 'Y' FROM mr_pmb_code x WHERE x.term_code = b.term_code AND x.term_support_code = c.supp_term_code) AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy' ) AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND (b.facility_id, b.patient_id, b.encounter_id, c.term_code ) NOT IN ( SELECT b.facility_id, b.patient_id, b.encounter_id, c.term_code FROM pr_diagnosis_enc_dtl b, pr_support_diagnosis c, pr_encounter d WHERE b.patient_id = c.patient_id AND b.term_set_id = c.term_set_id AND b.term_code = c.term_code AND b.patient_id = c.patient_id AND b.occur_srl_no = c.occur_srl_no AND b.patient_id = d.patient_id AND b.encounter_id = d.encounter_id AND NOT EXISTS ( SELECT 'Y' FROM mr_pmb_code x WHERE x.term_code = b.term_code AND x.term_support_code = c.supp_term_code) AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy' ) AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) )) AND ('"+visitType1+"' = 'IP' AND d.patient_class IN ('IP', 'DC') OR ('"+visitType2+"' = 'OP' AND d.patient_class = 'OP') OR ('"+visitType3+"' = 'EM' AND d.patient_class = 'EM') OR ( ( '"+visitType1+"' IS NULL AND '"+visitType2+"' IS NULL AND '"+visitType3+"' IS NULL ) AND d.patient_class IN ('IP', 'DC', 'EM', 'OP') ) ) GROUP BY c.term_code ORDER BY term_code_cnt DESC) WHERE ROWNUM <= 10) a, pr_diagnosis_enc_dtl b, mp_patient c, pr_encounter d, bl_visit_fin_dtls f WHERE a.term_code = b.term_code AND b.patient_id = c.patient_id AND b.patient_id = d.patient_id AND b.encounter_id = d.encounter_id AND b.patient_id = f.patient_id AND b.encounter_id = f.encounter_id AND b.facility_id = d.facility_id AND b.facility_id = f.operating_facility_id AND c.patient_id = d.patient_id AND c.patient_id = f.patient_id AND d.patient_id = f.patient_id AND d.encounter_id = f.encounter_id AND d.facility_id = f.operating_facility_id AND d.visit_status != 99 AND b.status != 'E' AND c.patient_id BETWEEN NVL ('"+patientIDFrom+"', '!') AND NVL ('"+patientIDTO+"', '~') AND TRUNC (d.visit_adm_date_time) BETWEEN TO_DATE ('"+visitAdmDateFrom+"', 'mm/yyyy' ) AND LAST_DAY (TO_DATE ('"+visitAdmDateTo+"', 'mm/yyyy' ) ) AND f.blng_grp_id BETWEEN NVL ('"+billingGroupFrom+"', '!') AND NVL ('"+billingGroupTo+"', '~') AND NVL (f.cust_code, 'X') BETWEEN NVL ('"+customerFrom+"', '!') AND NVL ('"+customerTo+"', '~') AND b.term_code BETWEEN NVL ('"+termcodeFrom+"', '!') AND NVL ('"+termcodeTo+"', '~') AND d.facility_id = '"+P_facility_id+"' AND ( ('"+visitType2+"' = 'OP' AND d.patient_class = 'OP') OR ('"+visitType3+"' = 'EM' AND d.patient_class = 'EM') OR ( ( '"+visitType1+"' IS NULL AND '"+visitType2+"' IS NULL AND '"+visitType3+"' IS NULL ) AND d.patient_class IN ('OP', 'EM', 'IP', 'DC') ) ) ORDER BY term_code_cnt DESC, term_code ASC, patient_id ASC";
			}
			
      

			stmt =  conn.createStatement();
			rset =  stmt.executeQuery(sql);
			
			while(rset!=null && rset.next()) {
			row = sheet.createRow(rowCount);
			int indexrow2 = 0;

			HSSFCell c1 = row.createCell(indexrow2++);	
				c1.setCellValue(checkForNull(rset.getString("PATIENT_ID")));
				c1.setCellStyle(style1);

			HSSFCell c2 = row.createCell(indexrow2++);	
				c2.setCellValue(checkForNull(rset.getString("age")));
				c2.setCellStyle(style1);

			HSSFCell c3 = row.createCell(indexrow2++);	
				c3.setCellValue(checkForNull(rset.getString("SEX")));
				c3.setCellStyle(style1);

			HSSFCell c4 = row.createCell(indexrow2++);	
				c4.setCellValue(checkForNull(rset.getString("nat_id")));
				c4.setCellStyle(style1);

            HSSFCell c5 = row.createCell(indexrow2++);	
				c5.setCellValue(checkForNull(rset.getString("opd")));
				c5.setCellStyle(style1);
			
			HSSFCell c6 = row.createCell(indexrow2++);	
				c6.setCellValue(checkForNull(rset.getString("visit_date")));
				c6.setCellStyle(style1);

			HSSFCell c7 = row.createCell(indexrow2++);	
				c7.setCellValue(checkForNull(rset.getString("ipd")));
				c7.setCellStyle(style1);

			HSSFCell c8 = row.createCell(indexrow2++);	
				c8.setCellValue(checkForNull(rset.getString("adm_date")));
				c8.setCellStyle(style1);

			HSSFCell c9 = row.createCell(indexrow2++);	
				c9.setCellValue(checkForNull(rset.getString("discharge_date")));
				c9.setCellStyle(style1);

			HSSFCell c10 = row.createCell(indexrow2++);	
				c10.setCellValue(checkForNull(rset.getString("lenght_of_stay")));
				c10.setCellStyle(style1);

			HSSFCell c11 = row.createCell(indexrow2++);	
				c11.setCellValue(checkForNull(rset.getString("episode_number")));
				c11.setCellStyle(style1);

			HSSFCell c12 = row.createCell(indexrow2++);	
				c12.setCellValue(checkForNull(rset.getString("BLNG_GRP_ID")));
				c12.setCellStyle(style1);

			HSSFCell c13 = row.createCell(indexrow2++);	
				c13.setCellValue(checkForNull(rset.getString("customer")));
				c13.setCellStyle(style1);

            if(reportType.equals("3"))
				{
					HSSFCell c14 = row.createCell(indexrow2++);	
					c14.setCellValue("");
					c14.setCellStyle(style1);
				}
				else if(reportType.equals("1"))
				{
					HSSFCell c14 = row.createCell(indexrow2++);	
					c14.setCellValue(checkForNull(rset.getString("term_code_pmb")));
					c14.setCellStyle(style1);
				}
				else{
					HSSFCell c14 = row.createCell(indexrow2++);	
					c14.setCellValue(checkForNull(rset.getString("term_code")));
					c14.setCellStyle(style1);
				}


				rowCount++;
			}
			
            workbook.write(response.getOutputStream());
			if(stmt !=null) stmt.close(); //Added for checkstyle
			if(rset !=null) rset.close();  //Added for checkstyle

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				ConnectionManager.returnConnection(conn, request);
		}

	}//end of doPost

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

}//end of class
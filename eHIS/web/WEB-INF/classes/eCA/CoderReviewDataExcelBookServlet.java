/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	?				?					created 
20/08/2020    	IN073540		Chdnrashekar Raju		      								AAKH-CRF-0122.3
16/03/2021		15950		Nijitha S											Common-ICN-0030
09/10/2023     51003           Krishna Pranay    10/10/2023       Ramesh Goli        COMMON-ICN-0178
------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;  
import java.sql.*;
import java.util.*;

import eCommon.Common.* ;
import javax.servlet.* ;
import webbeans.eCommon.ConnectionManager; 
import eCA.Common.CaAdapter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.ehis.persist.PersistenceHelper;

public class CoderReviewDataExcelBookServlet  extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet
{

	private ServletContext sc = null;
	private HSSFCellStyle celStyle = null;
	private HSSFCellStyle headerCelStyle = null;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		sc = config.getServletContext();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			doPost(request,response);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			writeBook(request, response);


		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public List<String>  getExcelResults(String patient_id,String from_date,String to_date,String Clin_id) throws Exception {
		
		Connection connection	= null;
		//ArrayList  reviewResult = new ArrayList();//51003
		PreparedStatement pStatment = null;
		ResultSet resultSet = null;
		String sql="";
		List<String> retObj = new ArrayList<String>();
		
		System.err.println("Clin_id@@==="+Clin_id);
		String cust_code= "",pat_id ="",encounter_id="",patient_class="",visit_adm_date_time="",patient_name="",attend_practitioner_id="",short_name="",location_name="",blng_grp_id="",policy_type_code="",policy_number="",policy_start_date="",policy_expiry_date="",bill_doc_type_code="",bill_doc_number="",bill_doc_date="",visit_created_by="",newoldchk="",coder_screen_remarks="";
		
		sql = " SELECT A.PATIENT_ID,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.VISIT_TYPE,C.REMARKS,C.ENCOUNTER_ID ENC_ID,C.ASSIGNED_PRACTITIONER_ID CODER_ID, (select short_name from am_practitioner where practitioner_id =C.ASSIGNED_PRACTITIONER_ID) CODER_DESC,A.CUST_CODE,A.VISIT_ADMN_DATE,A.PATIENT_NAME,A.PRACTITIONER_ID,A.PRACTITIONER_NAME,A.CLINIC_SPLTY_NAME,A.BLNG_GRP_ID,A.POLICY_TYPE_CODE,A.POLICY_NUMBER,A.POLICY_START_DATE,A.POLICY_EXPIRY_DATE,BILL_DOC_TYPE_CODE,BILL_DOC_NUMBER,BILL_DOC_DATE,VISIT_CREATED_BY FROM bl_coder_visit_sheet_vw A, CA_CODER_STATUS C WHERE  A.PATIENT_ID =C.PATIENT_ID(+) AND   A.ENCOUNTER_ID =C.ENCOUNTER_ID(+)  AND A.PATIENT_CLASS =C.PATIENT_CLASS(+) AND A.DISCHARGE_DATE_TIME BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')+1 AND ( C.STATUS NOT IN ('CO') OR C.STATUS IS NULL) AND  ? = (select practitioner_id from am_practitioner where SUPERVISOR_YN = 'Y' AND practitioner_id=?)";

		
		if(!patient_id .equals(""))
			sql =sql + " and a.patient_id = ? ";
		sql =sql + " ORDER BY DISCHARGE_DATE_TIME  DESC ";
      try{
		    connection			= ConnectionManager.getConnection();
			pStatment = connection.prepareStatement(sql);
		
			
			pStatment.setString(1, from_date); 
			pStatment.setString(2, to_date); 
			pStatment.setString(3, Clin_id); 
			pStatment.setString(4, Clin_id); 
			if(!patient_id .equals(""))
				pStatment.setString(5, patient_id); 

			resultSet = pStatment.executeQuery();

			while (resultSet !=null && resultSet.next() )
			{
				cust_code                  = resultSet.getString("CUST_CODE")==null?"":resultSet.getString("CUST_CODE");//0
				pat_id                     = resultSet.getString("PATIENT_ID")==null?"":resultSet.getString("PATIENT_ID");//1
				encounter_id               = resultSet.getString("ENCOUNTER_ID")==null?"":resultSet.getString("ENCOUNTER_ID");//2
			    patient_class              = resultSet.getString("PATIENT_CLASS")==null?"":resultSet.getString("PATIENT_CLASS");//3
                visit_adm_date_time        = resultSet.getString("VISIT_ADMN_DATE")==null?"":resultSet.getString("VISIT_ADMN_DATE");//4
				patient_name               = resultSet.getString("PATIENT_NAME")==null?"":resultSet.getString("PATIENT_NAME");//5
				attend_practitioner_id     = resultSet.getString("PRACTITIONER_ID")==null?"":resultSet.getString("PRACTITIONER_ID");//6
                short_name                 = resultSet.getString("PRACTITIONER_NAME")==null?"":resultSet.getString("PRACTITIONER_NAME");//7
				location_name              = resultSet.getString("CLINIC_SPLTY_NAME")==null?"":resultSet.getString("CLINIC_SPLTY_NAME");//8
				blng_grp_id                = resultSet.getString("BLNG_GRP_ID")==null?"":resultSet.getString("BLNG_GRP_ID");//9
				policy_type_code           = resultSet.getString("POLICY_TYPE_CODE")==null?"":resultSet.getString("POLICY_TYPE_CODE");//10
			    policy_number              = resultSet.getString("POLICY_NUMBER")==null?"":resultSet.getString("POLICY_NUMBER");//11
				policy_start_date          = resultSet.getString("POLICY_START_DATE")==null?"":resultSet.getString("POLICY_START_DATE");//12
				policy_expiry_date         = resultSet.getString("POLICY_EXPIRY_DATE")==null?"":resultSet.getString("POLICY_EXPIRY_DATE");//13
				bill_doc_type_code         = resultSet.getString("BILL_DOC_TYPE_CODE")==null?"":resultSet.getString("BILL_DOC_TYPE_CODE");//14
				bill_doc_number            = resultSet.getString("BILL_DOC_NUMBER")==null?"":resultSet.getString("BILL_DOC_NUMBER");//15
				bill_doc_date              = resultSet.getString("BILL_DOC_DATE")==null?"":resultSet.getString("BILL_DOC_DATE");//16
				visit_created_by	       = resultSet.getString("VISIT_CREATED_BY")==null?"":resultSet.getString("VISIT_CREATED_BY");//17
				newoldchk                  = resultSet.getString("VISIT_TYPE")==null?"":resultSet.getString("VISIT_TYPE");//18
				coder_screen_remarks       = resultSet.getString("REMARKS")==null?"":resultSet.getString("REMARKS");//19
				
				
				retObj.add(pat_id+"`~"+patient_name+"`~"+encounter_id+"`~"+patient_class+"`~"+visit_adm_date_time+"`~"+attend_practitioner_id+"`~"+short_name+"`~"+location_name+"`~"+cust_code+"`~"+blng_grp_id+"`~"+policy_type_code+"`~"+policy_number+"`~"+policy_start_date+"`~"+policy_expiry_date+"`~"+bill_doc_type_code+"`~"+bill_doc_number+"`~"+bill_doc_date+"`~"+visit_created_by+"`~"+coder_screen_remarks+"`~"+newoldchk);
				
			}
		if(resultSet !=null) resultSet.close();
		if(pStatment != null ) pStatment.close();

		}
		catch(Exception e){
			e.printStackTrace();
		
		}
		finally{
			if(resultSet != null) resultSet.close();
			if(pStatment != null) pStatment.close();
			ConnectionManager.returnConnection(connection);	//15950 Fix
		}
      
	return retObj;
}

	public void writeBook(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

			HttpSession session = request.getSession(false);
			String patient_id =request.getParameter("patient_id") == null?"":request.getParameter("patient_id");
			String from_date =request.getParameter("from_date") == null?"":request.getParameter("from_date");
			String to_date =request.getParameter("to_date") == null?"":request.getParameter("to_date");
			String Clin_id=(String)session.getValue("ca_practitioner_id");
			System.err.println("Clin_id@@====="+Clin_id);
			List<String> resObj = getExcelResults(patient_id,from_date,to_date,Clin_id);
			
			if (resObj != null)
			{
				write(resObj, request, response); 
			}
			else
		    {
			    throw new Exception("coderexcel.java , resObj can not be null.");
		    }
	}

	private void write(List<String> resObj,HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			//Integer totalColumns = 19;			
			HSSFWorkbook dataBook = new HSSFWorkbook();
			HSSFFont font =  dataBook.createFont();
			font.setColor(HSSFColor.BLACK.index);
			celStyle = dataBook.createCellStyle();
			celStyle.setFont(font);
			celStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			setStyle(celStyle);
			String sheetName = "CoderReviewData";

			HSSFSheet sheet = dataBook.createSheet(sheetName);
			sheet.createFreezePane(0, 1);
			//sheet.protectSheet("isfot");
			HSSFRow headerRow =  sheet.createRow(0);
			setRowHeaderCellStyle(dataBook);

			getCellWithDataType(sheetName, dataBook, headerRow, "PATIENT_ID", 0, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "PATIENT_NAME", 1, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "ENCOUNTER_ID", 2, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "PATIENT_CLASS", 3, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "VISIT_ADM_DATE_TIME", 4, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "ATTEND_PRACTITIONER_ID", 5, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "SHORT_NAME", 6, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "LOCATION_NAME", 7, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "CUST_CODE", 8, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "BLNG_GRP_ID", 9, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "POLICY_TYPE_CODE", 10, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "POLICY_NUMBER", 11, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "POLICY_START_DATE", 12, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "POLICY_EXPIRY_DATE", 13, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "BILL_DOC_TYPE_CODE", 14, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "BILL_DOC_NUMBER", 15, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "BILL_DOC_DATE", 16, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "VISIT_CREATED_BY", 17, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "CODER_SCREEN_REMARKS", 18, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "NEWOLDCHK", 19, true);
			
			HSSFRow rowData = null;
			int rowCount = 1;
			for(String str : resObj)
			{
				rowData =  sheet.createRow(rowCount);
				String []st = str.split("`~");
				System.err.println("rowCount@@==="+rowCount+"st[15]==="+st[15]+"st[18]"+st[18]+"19=="+st[19]);
				
					//Integer totalColumns_ = 19;
					getCellWithDataType(sheetName, dataBook, rowData, st[0], 0, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[1], 1, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[2], 2, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[3], 3, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[4], 4, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[5], 5, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[6], 6, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[7], 7, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[8], 8, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[9], 9, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[10], 10, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[11], 11, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[12], 12, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[13], 13, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[14], 14, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[15], 15, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[16], 16, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[17], 17, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[18], 18, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[19], 19, false);


					System.err.println("rowCount@@==="+rowCount);
					
				rowCount++;
				System.err.println("rowCount@@after==="+rowCount);
			}
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition","attachment; filename=\"CoderReviewData.xls" + "\"");
			ServletOutputStream sOut = response.getOutputStream();
			dataBook.write(sOut);
			sOut.flush();
			sOut.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private void setStyle(HSSFCellStyle celStyle)
	{
		celStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		celStyle.setRightBorderColor(HSSFColor.BLACK.index);
		celStyle.setTopBorderColor(HSSFColor.BLACK.index);
		celStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		celStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		celStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		celStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		celStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		celStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		celStyle.setLocked(false);
	}

	private void setRowHeaderCellStyle(HSSFWorkbook dataBook)
	{
		HSSFFont font = dataBook.createFont();
		headerCelStyle = dataBook.createCellStyle();
		font.setColor(HSSFColor.WHITE.index);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeight((short)215);
		headerCelStyle.setFont(font);
		headerCelStyle.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
		headerCelStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		headerCelStyle.setRightBorderColor(HSSFColor.BLACK.index);
		headerCelStyle.setTopBorderColor(HSSFColor.BLACK.index);
		headerCelStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		headerCelStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		headerCelStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		headerCelStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		headerCelStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		headerCelStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		headerCelStyle.setLocked(true);

	}

	private HSSFCellStyle getRowHeaderCellStyle()
	{
		return headerCelStyle;
	}



	private  void getCellWithDataType(String sheetName, HSSFWorkbook dataBook, HSSFRow row, String colVal, int cellNo, boolean isHeader)
	{
		HSSFSheet sheet = dataBook.getSheet(sheetName);
		int width = 7000;
		sheet.setColumnWidth(cellNo, width);
		HSSFCell cel = row.createCell(cellNo);

		if(isHeader)
		{
			cel.setCellType(HSSFCell.CELL_TYPE_STRING);
			cel.setCellValue(colVal);
			cel.setCellStyle(getRowHeaderCellStyle());
		}
		else
		{
			cel.setCellValue(colVal);

		}
	}

}
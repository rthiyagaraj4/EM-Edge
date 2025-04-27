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
18/11/2015    	IN057467		 	Ramesh G		      								Query template data should also allow date field to be included for query.	
------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;  //IN057467

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

public class QueryTemplateDataExcelBookServlet  extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet
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

	public void writeBook(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

			HttpSession session = request.getSession(false);
			QueryTemplateDataFunctionBean qryDataBean = (QueryTemplateDataFunctionBean)PersistenceHelper.getObjectFromBean("qryDataBean","eCA.QueryTemplateDataFunctionBean",session);
			List<String> resObj = qryDataBean.getQueryResults();
			Map<String,String> dateCompMap = (HashMap<String,String>)qryDataBean.getDateCompWithDesc();	 //IN057467
			if (resObj != null)
			{
				write(resObj, dateCompMap, request, response); //IN057467
			}
			else
		    {
			    throw new Exception("QueryTemplateDataExcelBookServlet.java , resObj can not be null.");
		    }
	}

	private void write(List<String> resObj,Map<String,String> dateCompMap,HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			Set<String> datecompKey = null;
			Integer totalColumns = 8;			
			HSSFWorkbook dataBook = new HSSFWorkbook();
			HSSFFont font =  dataBook.createFont();
			font.setColor(HSSFColor.BLACK.index);
			celStyle = dataBook.createCellStyle();
			celStyle.setFont(font);
			celStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			setStyle(celStyle);
			String sheetName = "QueryTemplateData";

			HSSFSheet sheet = dataBook.createSheet(sheetName);
			sheet.createFreezePane(0, 1);
			//sheet.protectSheet("isfot");
			HSSFRow headerRow =  sheet.createRow(0);
			setRowHeaderCellStyle(dataBook);

			getCellWithDataType(sheetName, dataBook, headerRow, "Patient Id", 0, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "Patient Name", 1, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "Gender", 2, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "Age", 3, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "DOB", 4, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "Patient class", 5, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "Encounter ID", 6, true);
			getCellWithDataType(sheetName, dataBook, headerRow, "Number of Occurrences", 7, true);
			//IN057467 Start.
			if(dateCompMap!=null){
				if(dateCompMap.keySet().size()>0){
					datecompKey = dateCompMap.keySet();
					for (String key : datecompKey)
					{	
						getCellWithDataType(sheetName, dataBook, headerRow, (String)dateCompMap.get(key), totalColumns, true);
						totalColumns++;
					}
				}
			}
			//IN057467 End.
			HSSFRow rowData = null;
			int rowCount = 1;
			for(String str : resObj)
			{
				rowData =  sheet.createRow(rowCount);
				String []st = str.split("`~");
				//IN057467 Start.
				//for(int i = 0; i < st.length; i++)
				//{
					//getCellWithDataType(sheetName, dataBook, rowData, st[i], i, false);
					Integer totalColumns_ = 8;
					getCellWithDataType(sheetName, dataBook, rowData, st[0], 0, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[1], 1, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[2], 2, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[3], 3, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[4], 4, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[5], 5, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[6], 6, false);
					getCellWithDataType(sheetName, dataBook, rowData, st[7], 7, false);
					if(dateCompMap!=null){
						for (String key : datecompKey)
						{							
							if(key.equals(st[9])){							
								getCellWithDataType(sheetName, dataBook, rowData, st[8], totalColumns_, false);
							}else{
								getCellWithDataType(sheetName, dataBook, rowData, "", totalColumns_, false);
							}
							totalColumns_++;
						}
					}
				//}
				//IN057467 end.
				rowCount++;
			}
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition","attachment; filename=\"QueryTemplateData.xls" + "\"");
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

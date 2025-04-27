/*
	Developed by  : Ravindranath.
	Created on    : 15/02/2010
*/
package HL7Engine.OutboundProcess;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import HL7Engine.Common.Common;
import HL7Engine.Common.CommonUtil;

public class ExcelTransactions extends Thread
{
	Common common = Common.getInstance();
	CommonUtil commonUtil = new CommonUtil();
	OutboundClientDBInteraction clientDB;
	OutboundClientParameters clientParameters;

	public ExcelTransactions(OutboundClientDBInteraction clientDB)
	{
		this.clientDB = clientDB;
		clientParameters = clientDB.clientParameters;
	}

	public void createHeader(String fileName, List hdrList)
	{
		FileOutputStream fout = null;
		try
		{
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			HSSFCellStyle cs = wb.createCellStyle();
			HSSFFont font = wb.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			cs.setFont(font);

			HSSFRow row = sheet.createRow((short)0);
			HSSFCell cell = row.createCell((short)0);

			int maxCols = hdrList.size();
			
			for(int i = 0; i < maxCols; i++)
			{				
				cell.setCellValue((String)hdrList.get(i));
				cell.setCellStyle(cs);
				cell = row.createCell((short)i+1);
			}
			
			fout = new FileOutputStream(fileName);			
			wb.write(fout);			
			fout.flush();
		}
		catch(Exception exp)
		{			
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp)+"\n" ) ;
		}
		finally
		{
			try {
				if(fout != null) fout.close();
			}catch(Exception exp) { }
		}		
	}

	public void appendRows(String fileName, List recList)
	{
		FileOutputStream fout = null;
		FileInputStream fis = null;

		try
		{
			fis = new FileInputStream(fileName);
			POIFSFileSystem poiFileSys = new POIFSFileSystem(fis);
			HSSFWorkbook wb = new HSSFWorkbook(poiFileSys);
			HSSFSheet sheet = wb.getSheetAt(0);
			
			int rowCount = recList.size();
			ArrayList currentRecord = null;

		//	HSSFRow row = null;
		//	HSSFCell cell = null;		

			for (int i = 0; i < rowCount; i++)
			{
				currentRecord = (ArrayList)recList.get(i);
				int colCount = currentRecord.size();
				HSSFRow row = sheet.createRow(sheet.getLastRowNum()+1);

				for (int j = 0; j < colCount; j++)
				{
					HSSFCell cell = row.createCell((short)j);
					cell.setCellValue((String)currentRecord.get(j));
				}
			}

			fout = new FileOutputStream(fileName);
			wb.write(fout);
			fout.flush();
		}
		catch(Exception exp)
		{			
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp)+"\n" ) ;
		}
		finally
		{
			try {
				if(fout != null) fout.close();
				if(fis != null) fis.close();
			}catch(Exception exp) { }
		}
	}
}

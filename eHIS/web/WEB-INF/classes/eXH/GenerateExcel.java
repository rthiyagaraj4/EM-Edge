/***************************************************************************************************************
 * Author   :	Ravindranath  
 * Desc     :	Servlet used to generate excel file for the notifications that have to delivered/processed 
 ***************************************************************************************************************/
package eXH;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import webbeans.eCommon.ConnectionManager;

/**
 * Servlet used to generate excel file for the notifications that have to delivered/processed. 
 */
public class GenerateExcel extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		try
		{
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Notifications");			

			HSSFRow row = null;
			HSSFCell cell = null;
			HSSFCellStyle cs = wb.createCellStyle();
			HSSFFont font = wb.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			cs.setFont(font);

			try
			{
				int cellNumber = 0;
				int rowNumber = 0;
				List<List<String>> notificationsList = (List<List<String>>)request.getAttribute("notificationsList");
				List<String> headerList = (List<String>) request.getAttribute("notificationsHeader");

				row = sheet.createRow((short)rowNumber);
				
				cell = row.createCell((short)cellNumber);
				cell.setCellValue("Total Records = " + notificationsList.size());
				cell.setCellStyle(cs);
				
				row = sheet.createRow((short)++rowNumber);
				cellNumber = 0;

				for(String key : headerList) {
					cell = row.createCell((short)cellNumber);
					cell.setCellValue(key);
					cell.setCellStyle(cs);
					cellNumber++;
				}

				for(List<String> notification : notificationsList) {
					row = sheet.createRow((short)++rowNumber);
					cellNumber = 0;

					for(String fieldValue : notification) {
						row.createCell((short)cellNumber++).setCellValue(fieldValue);
					}
				}
				
				if(notificationsList.size() > 0) {
					response.setContentType("application/vnd.ms-excel");
					response.setHeader("Content-Disposition", "attachment; filename=Notifications.xls");
//					FileOutputStream fileOut = new FileOutputStream(filePath+"eXH/InboundEvents.xls");
					ServletOutputStream op = response.getOutputStream();

					wb.write(op);			
				//	fileOut.close();
					op.flush();
					op.close();
				//	response.sendRedirect("http://localhost:8899/eHIS/eXH/workbook.xls");

				/*	File f = new File(filePath+"eXH/InboundEvents.xls");
					int length1 = 0;
					ServletOutputStream op = response.getOutputStream();				

					byte[] bbuf = new byte[99999];
					DataInputStream in = new DataInputStream(new FileInputStream(f));

					while ((in != null) && ((length1 = in.read(bbuf)) != -1))
					{
						op.write(bbuf,0,length1);
					}

					in.close();
					op.flush();
					op.close();
				*/
				}
				else {
					PrintWriter out = response.getWriter();
					out.write("<SCRIPT>alert('" + XHUtil.getLocaleMessage("en", "XH1021", "XH") + "')</SCRIPT>");
					out.flush();
				}
			}
			catch(Exception exp) {
				exp.printStackTrace(System.err);
			}
		}
		catch(Exception exp) {
			exp.printStackTrace(System.err);
		}

	}

	public String getStrClobData(Clob clobData)
	{		
		StringBuffer sbClobData	= new StringBuffer();
		try
		{
			if(clobData!=null)
			{
				sbClobData.append(clobData.getSubString(1,(int)clobData.length()));
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return sbClobData.toString();
	}
}
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddressList;

import webbeans.eCommon.ConnectionManager;

/**
 * Servlet used to generate excel file for the inbound/outbound events. 
 */
public class XHElementLayerExportResultxls extends HttpServlet
{
	

	  private static final String[] organisations = {"Control", "Data","Both"}; 
	  private static final String[] enables = {"Yes", "No"}; 	  
  


	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		try
		{	
		 String standard_code=XHDBAdapter.checkNull(request.getParameter("Standardcode_combo"));
			String segment_type=XHDBAdapter.checkNull(request.getParameter("segment_type"));

			String standname="";
			String segmentname="";
			if(standard_code.equals(""))
			{
				standname="ALL";
			}
			else
			{
			  standname=standard_code;
			}

			if(segment_type.equals(""))
			{
			  segmentname="ALL";
			}
			else
			{
			  segmentname=segment_type;
			}
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=ElementLayer"+standname+"_"+segmentname+".xls");

													  
		//	Properties p = (Properties) session.getValue("jdbc");	
		//	String locale  = p.getProperty("LOCALE");										
		    HSSFDataValidation organisationValidation = null; 
			CellRangeAddressList organisationCellAddressList = null; 
			DVConstraint organisationConstraint = null; 

			HSSFDataValidation enableValidation = null; 
			CellRangeAddressList enableCellAddressList = null;
			DVConstraint enbleConstraint = null; 
		  

			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("ElementLayer"+standname+"_"+segmentname);			  

			// Create a row and put some cells in it. Rows are 0 based.
			HSSFRow row = null;
			HSSFCellStyle cs = wb.createCellStyle();
			HSSFFont font = wb.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			cs.setFont(font);
						
			Connection connection = null;
			Statement stmt = null;
			Statement coustmt=null;
			ResultSet cours = null;
			ResultSet rs = null;
			int totalcount=0;
			String sqlQry = null;
			String sqlCount=null;
			try
			{
				connection = ConnectionManager.getConnection();
				sqlCount="select count(*) from (SELECT   a.element_id, a.element_name, NVL (a.in_use_yn, 'N'),NVL (a.facility_based_yn, 'N'), a.standard_type, a.parent_element_id,a.component_level, NVL (a.field_type, 'S'), POSITION, a.control_yn,'N', a.element_seq, a.element_desc, a.segment_type, a.standard_code FROM xh_element_crossref a WHERE  a.segment_type =NVL ('', a.segment_type) AND DECODE (a.standard_type, NULL, 'XX', a.standard_type) =NVL ('', DECODE (a.standard_type, NULL, 'XX', a.standard_type)) AND a.element_id IN (SELECT element_id FROM xh_appl_element) UNION ALL SELECT   a.element_id, a.element_name, NVL (a.in_use_yn, 'N'),NVL (a.facility_based_yn, 'N'), a.standard_type, a.parent_element_id,a.component_level, NVL (a.field_type, 'S'), POSITION, a.control_yn,'C', a.element_seq, a.element_desc, a.segment_type, a.standard_code FROM xh_element_crossref a WHERE a.segment_type =NVL ('', a.segment_type) AND DECODE (a.standard_type, NULL, 'XX', a.standard_type) =NVL ('',DECODE (a.standard_type, NULL, 'XX', a.standard_type)) AND a.element_id NOT IN (SELECT element_id FROM xh_appl_element) ORDER BY element_seq ASC)";
				sqlQry="SELECT   a.element_id, a.element_name, NVL (a.in_use_yn, 'N'),NVL (a.facility_based_yn, 'N'), a.standard_type,a.parent_element_id,a.component_level, NVL (a.field_type, 'S'), POSITION, a.control_yn,'N', a.element_seq, a.element_desc, a.segment_type,a.STANDARD_CODE FROM xh_element_crossref a WHERE  /*a.element_id = b.element_id AND b.segment_type = c.segment_type AND*/  a.segment_type = NVL ('"+segment_type+"', a.segment_type) AND DECODE (a.standard_type, NULL, 'XX', a.standard_type) =NVL ('"+standard_code+"', DECODE (a.standard_type, NULL, 'XX', a.standard_type)) AND a.element_id IN (SELECT element_id FROM xh_appl_element) UNION ALL SELECT   a.element_id, a.element_name, NVL (a.in_use_yn, 'N'),NVL (a.facility_based_yn, 'N'), a.standard_type,a.parent_element_id,a.component_level, NVL (a.field_type, 'S'), POSITION, a.control_yn,'C', a.element_seq,a.element_desc, a.segment_type,a.STANDARD_CODE FROM xh_element_crossref a WHERE /*b.segment_type = a.segment_type(+) --a.element_id = b.element_id  AND  b.segment_type = c.segment_type	 */  a.segment_type = NVL ('"+segment_type+"', a.segment_type)  AND DECODE (a.standard_type, NULL, 'XX', a.standard_type) =NVL ('"+standard_code+"', DECODE (a.standard_type, NULL, 'XX', a.standard_type))     AND a.element_id NOT IN (SELECT element_id FROM xh_appl_element) ORDER BY element_seq ASC";
				coustmt= connection.createStatement();
			    cours=coustmt.executeQuery(sqlCount);
				while(cours.next())
				{
				  totalcount=cours.getInt(1);
				}

				  cours.close();
				   coustmt.close();
				stmt = connection.createStatement();
				rs = stmt.executeQuery(sqlQry);	 

				row = sheet.createRow((short)0);
				HSSFCell cell = row.createCell((short)0);	   
				cell.setCellValue("ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)1);
								
				cell.setCellValue("NAME");
				cell.setCellStyle(cs);
				cell = row.createCell((short)2);

				cell.setCellValue("Show Description");
				cell.setCellStyle(cs);
				cell = row.createCell((short)3);

				cell.setCellValue("Standard Type");
				cell.setCellStyle(cs);
				cell = row.createCell((short)4);

				cell.setCellValue("Field");
				cell.setCellStyle(cs);
				cell = row.createCell((short)5);

				cell.setCellValue("Nature");
				cell.setCellStyle(cs);
				cell = row.createCell((short)6);
				cell.setCellValue("Enabled");
				cell.setCellStyle(cs);
			
			organisationConstraint = DVConstraint.createExplicitListConstraint(organisations);		  
			organisationCellAddressList = new CellRangeAddressList(1, totalcount, 5, 5);
			organisationValidation = new HSSFDataValidation(organisationCellAddressList,organisationConstraint);  
			organisationValidation.setSuppressDropDownArrow(false); 
			sheet.addValidationData(organisationValidation); 

			enbleConstraint = DVConstraint.createExplicitListConstraint(enables);		  
			enableCellAddressList = new CellRangeAddressList(1, totalcount, 6, 6);
			enableValidation = new HSSFDataValidation(enableCellAddressList,enbleConstraint);  
			enableValidation.setSuppressDropDownArrow(false); 
			sheet.addValidationData(enableValidation); 

																								   
				int rowCount = 1;
				while(rs.next())
				{				
					row = sheet.createRow((short)rowCount++);
					row.createCell((short)0).setCellValue(rs.getString(1));
					row.createCell((short)1).setCellValue(rs.getString(2));
					row.createCell((short)2).setCellValue(rs.getString(13));
					row.createCell((short)3).setCellValue(rs.getString(5));
					row.createCell((short)4).setCellValue(rs.getString(8));
					if(XHDBAdapter.checkNull(rs.getString(10)).equals("Y"))
					{
					  row.createCell((short)5).setCellValue("Control");
					}

					if(XHDBAdapter.checkNull(rs.getString(10)).equals("N"))
					{
					  row.createCell((short)5).setCellValue("Data");
					}

					if(XHDBAdapter.checkNull(rs.getString(10)).equals("X"))
					{
					  row.createCell((short)5).setCellValue("Both");
					}


					if(XHDBAdapter.checkNull(rs.getString(3)).equals("Y"))
					{
					  row.createCell((short)6).setCellValue("Yes");
					}
					else
					{
					 row.createCell((short)6).setCellValue("No");
					}
										
				}					
				
			
				ServletOutputStream op = response.getOutputStream();

				wb.write(op);			
			
				op.flush();
				op.close();
			
		
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
			}
			finally
			{
				try
				{
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(connection != null) connection.close();
				}
				catch(Exception exp)
				{
					exp.printStackTrace(System.err);
				}
			}
		}
		catch(Exception exp)
		{
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
}//end of class 					   

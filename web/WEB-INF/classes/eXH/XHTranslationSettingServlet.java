/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXH.*;
import java.text.*;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;																			 	  
import org.apache.poi.hssf.model.*;
import org.apache.poi.hssf.usermodel.*;

/**
 * Servlet used to generate excel file for the inbound/outbound events. 
 */								  
public class XHTranslationSettingServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		try
		{		
			
			String Trans_table_d="";					
			String module_id=request.getParameter("module_id")==null?"":request.getParameter("module_id");
//			System.out.println("module_id XHTranslationSettingServlet.java:"+module_id);
			String masterName=request.getParameter("master_name")==null?"":request.getParameter("master_name");
//			System.out.println("masterName XHTranslationSettingServlet.java:"+masterName);
			String language=request.getParameter("language")==null?"":request.getParameter("language");
			String language_direction=request.getParameter("language_direction")==null?"":request.getParameter("language_direction");
			String appl=request.getParameter("application")==null?"":request.getParameter("application");
//			System.out.println("appl XHTranslationSettingServlet.java :"+appl);
			 int tot=4;
			String display=request.getParameter("display")==null?"":request.getParameter("display");
			String searchText=request.getParameter("searchText")==null?"":request.getParameter("searchText");
	        String searchText1=searchText; 
			String Searchbymod=request.getParameter("Searchbymod")==null?"":request.getParameter("Searchbymod");
		   	String SearchbyFunct=request.getParameter("SearchbyFunct")==null?"":request.getParameter("SearchbyFunct");
		   	String start_ends_contains=request.getParameter("start_ends_contains")==null?"":request.getParameter("start_ends_contains");
	  		String outbound_yn = "X";
			String searchpk2=request.getParameter("searchpk2")==null?"":request.getParameter("searchpk2");
			String searchpk2Val = searchpk2;
			String searchpk3=request.getParameter("searchpk3")==null?"":request.getParameter("searchpk3");
			String searchpk3Val = searchpk3;
			String sqlQuery=request.getParameter("sqlQuery")==null?"":request.getParameter("sqlQuery");
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet(module_id+"_"+masterName);			
			String sqlQueryorginal="";									   
			HSSFRow row = null;											    
			HSSFCellStyle cs = wb.createCellStyle();
			HSSFFont font = wb.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			cs.setFont(font);
			String[] qryarr=null;				
			Connection connection = null;
			Statement stmt = null;
			ResultSet rs = null;
			Statement constmt=null;
			ResultSet conrs=null;
			String Trans_tab_id="";								    
			//ArrayList
			String sqlQry = null;
			String comType = null;
		//	HttpSession session = request.getSession(false);				  
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename="+module_id+"_"+masterName+".xls");

			  HSSFCellStyle style = wb.createCellStyle();
			    HSSFCellStyle style1 = wb.createCellStyle();
			  HSSFCellStyle style2 = wb.createCellStyle();
			  HSSFCellStyle style3 = wb.createCellStyle();	    
			  HSSFCellStyle style4 = wb.createCellStyle();

			 int totdkey=7;
										    

			try	
			{					    
				
//			  System.out.println("sqlQuery XHTranslationSettingServlet.java :"+sqlQuery);
			  connection = ConnectionManager.getConnection();
			  String sqlQueryTrans_Id="select TRANS_TABLE_ID from xh_mapping  where  MASTER_TABLE_ID='"+masterName+"' order by SRL_NO ";
//			  System.out.println(sqlQueryTrans_Id);

			  constmt = connection.createStatement();
			  conrs = constmt.executeQuery(sqlQueryTrans_Id);
			  if(conrs.next())
			  {
			 	Trans_table_d=conrs.getString(1).toUpperCase();
			  }

				if(sqlQuery.indexOf("UNION")!=-1)
				{
					qryarr=sqlQuery.split("UNION");
				}
				else if(sqlQuery.indexOf("union")!=-1)
				{
					  qryarr=sqlQuery.split("union");
				}

		//		System.out.println("spliting qryarr :"+qryarr[1]);

				if(qryarr[1].indexOf("order")!=-1)								 
				{												    
				  int orderpos= qryarr[1].toString().indexOf("order");
				 sqlQueryorginal=qryarr[1].substring(0,orderpos);
				 
				}
		//	   System.out.println("sqlQueryorginal :"+sqlQueryorginal);
				row = sheet.createRow((short)0);
				  if(Trans_table_d.indexOf("skey")!=-1||Trans_table_d.indexOf("SKEY")!=-1||Trans_table_d.indexOf("Skey")!=-1)
				{
				}
				else if(Trans_table_d.indexOf("DKEY")!=-1||Trans_table_d.indexOf("dkey")!=-1)
				{

				}
				else
				{
					 sqlQueryorginal=sqlQueryorginal.replaceAll("from","FROM");
					  sqlQueryorginal=sqlQueryorginal.replaceAll("Select","SELECT");
					  sqlQueryorginal=sqlQueryorginal.replaceAll("select","SELECT");
					 int fromposi=sqlQueryorginal.indexOf("FROM");
					 int selectposi=sqlQueryorginal.indexOf("SELECT");
							String fieldscolu= sqlQueryorginal.substring((selectposi+7),fromposi);

						sqlQueryorginal=sqlQueryorginal.replaceAll(fieldscolu," * ");	  

			//		   System.out.println("All Processing Over 142:"+sqlQueryorginal);

				}
				HSSFCell cell1=null;
				HSSFCell cell2=null;
					HSSFCell cell3=null;
				stmt = connection.createStatement();
				rs = stmt.executeQuery(sqlQueryorginal);
				int rowCount = 1;
				row = sheet.createRow((short)rowCount++);
				row.createCell((short)0).setCellValue("APPLICATION ID");
				row.createCell((short)1).setCellValue(appl);  
				row = sheet.createRow((short)rowCount++);
				row.createCell((short)0).setCellValue("Module ID");
				row.createCell((short)1).setCellValue(module_id);  
				row = sheet.createRow((short)rowCount++);
				row.createCell((short)0).setCellValue("Master Name");
				row.createCell((short)1).setCellValue(masterName);
				row = sheet.createRow((short)rowCount++);
				row.createCell((short)0).setCellValue("");
				row.createCell((short)1).setCellValue("");  
				row = sheet.createRow((short)rowCount++);
				row.createCell((short)0).setCellValue("");
				row.createCell((short)1).setCellValue("");
				 //rowCount++;
				 HSSFCell cell = row.createCell((short)0);	
				 if(Trans_table_d.indexOf("skey")!=-1||Trans_table_d.indexOf("SKEY")!=-1||Trans_table_d.indexOf("Skey")!=-1)
				{
				 cell.setCellValue("PK_VALUE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)1);	   
				cell.setCellValue("EXT_PK_VALUE");
				style2.setFillBackgroundColor(HSSFColor.AQUA.index);
				style2.setFillPattern(HSSFCellStyle.BIG_SPOTS);
				style2.setFillForegroundColor(HSSFColor.ORANGE.index);
				style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				cell.setCellStyle(style2);													 
				cell = row.createCell((short)2);
				cell.setCellValue("DESC2_VALUE");
				style3.setFillBackgroundColor(HSSFColor.AQUA.index);
				style3.setFillPattern(HSSFCellStyle.BIG_SPOTS);
				style3.setFillForegroundColor(HSSFColor.ORANGE.index);
				style3.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				cell.setCellStyle(style3);	 
				while(rs!=null && rs.next())
				{
					 if(tot%4==0)
					{
					row = sheet.createRow((short)rowCount++);
					row.createCell((short)0).setCellValue(rs.getString(3));
					tot++;
					}
						      
					if(tot%4==1)
					{
					    cell1 =row.createCell((short)1);	
						style.setFillBackgroundColor(HSSFColor.AQUA.index);
						style.setFillPattern(HSSFCellStyle.BIG_SPOTS);
						style.setFillForegroundColor(HSSFColor.ORANGE.index);
						style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);	
					    cell1.setCellValue(rs.getString(4));   
					    tot++;
									   
					}
					
					if(tot%4==2)
					{
					 cell2 =row.createCell((short)2);
					 style1.setFillBackgroundColor(HSSFColor.AQUA.index);
				 	 style1.setFillPattern(HSSFCellStyle.BIG_SPOTS);
					 style1.setFillForegroundColor(HSSFColor.ORANGE.index);
					 style1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);	    
					 cell2.setCellValue(rs.getString(5));
					 tot=4;
					}				   
					
					cell1.setCellStyle(style);
					cell2.setCellStyle(style2);	   		  
																							   
				}


				}
				 else if(Trans_table_d.indexOf("DKEY")!=-1||Trans_table_d.indexOf("dkey")!=-1)
				{
				cell.setCellValue("PK1_VALUE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)1);
				cell.setCellValue("PK2_VALUE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)2);												  
				cell.setCellValue("EXT_PK1_VALUE");
				 style1.setFillBackgroundColor(HSSFColor.AQUA.index);
				 	 style1.setFillPattern(HSSFCellStyle.BIG_SPOTS);
					 style1.setFillForegroundColor(HSSFColor.ORANGE.index);
					 style1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);	
				cell.setCellStyle(style1);
				cell = row.createCell((short)3);
				cell.setCellValue("EXT_PK2_VALUE");
				 	 style1.setFillBackgroundColor(HSSFColor.AQUA.index);
				 	 style1.setFillPattern(HSSFCellStyle.BIG_SPOTS);
					 style1.setFillForegroundColor(HSSFColor.ORANGE.index);
					 style1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);	
				cell.setCellStyle(style1);
				cell = row.createCell((short)4);
				cell.setCellValue("DESC2_VALUE");
			     style1.setFillBackgroundColor(HSSFColor.AQUA.index);
				 style1.setFillPattern(HSSFCellStyle.BIG_SPOTS);
				 style1.setFillForegroundColor(HSSFColor.ORANGE.index);
				 style1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);	
				cell.setCellStyle(style1);
				cell = row.createCell((short)5);
				while(rs!=null && rs.next())
				{
					row = sheet.createRow((short)rowCount++);
					row.createCell((short)0).setCellValue(rs.getString(3));
					row.createCell((short)1).setCellValue(rs.getString(4));
					 if(totdkey%5==2)
					{

						 cell1 =row.createCell((short)2);	
						style.setFillBackgroundColor(HSSFColor.AQUA.index);
						style.setFillPattern(HSSFCellStyle.BIG_SPOTS);
						style.setFillForegroundColor(HSSFColor.ORANGE.index);
						style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);	
					    cell1.setCellValue(rs.getString(5));   
				
						totdkey++;
					}

					if(totdkey%5==3)
					{
					  cell2 =row.createCell((short)3);	
						style.setFillBackgroundColor(HSSFColor.AQUA.index);
						style.setFillPattern(HSSFCellStyle.BIG_SPOTS);
						style.setFillForegroundColor(HSSFColor.ORANGE.index);
						style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);	
					    cell2.setCellValue(rs.getString(6)); 

					 totdkey++;
					}

					if(totdkey%5==4)
					{
						cell3=row.createCell((short)4);
						style.setFillBackgroundColor(HSSFColor.AQUA.index);
						style.setFillPattern(HSSFCellStyle.BIG_SPOTS);
						style.setFillForegroundColor(HSSFColor.ORANGE.index);
						style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);	
						cell3.setCellValue(rs.getString(7)); 
						totdkey=7;
					}
 					cell1.setCellStyle(style);
					cell2.setCellStyle(style);
					cell3.setCellStyle(style);
				}
				
			}  	
			else 				     
			{
				  ResultSetMetaData rsmd=rs.getMetaData();
				   int colCount=rsmd.getColumnCount();
					for(int c=1;c<=colCount;c++)
					{
						cell.setCellValue(rsmd.getColumnName(c));
						cell.setCellStyle(cs);				 
						cell = row.createCell((short)(c));
					}
					cell.setCellValue("Option");
					cell.setCellStyle(cs);
					cell = row.createCell((short)(colCount+1));		  
					while(rs!=null && rs.next())
					{
						row = sheet.createRow((short)rowCount++);
						for(int k=1;k<=colCount;k++)						 
						{  
							if(rsmd.getColumnName(k).indexOf("DATE")!=-1)
							{
								 String queryDate =rs.getString(k).toString().trim();
								 String[] dateform=queryDate.split(" ");
								String[] datemonyear=dateform[0].split("-");
								String[] timeform=dateform[0].split(":");
							// System.out.println(timeform[0]+":"+timeform[1]);

							//				System.out.println(dateform[1]);
								String dateformat1=datemonyear[2]+"/"+datemonyear[1]+"/"+datemonyear[0];
							
								 row.createCell((short)(k-1)).setCellValue(dateformat1);
							}
							else																	   
							{
							  row.createCell((short)(k-1)).setCellValue(rs.getString(k));
							}
						//	row.createCell((short)(k-1)).setCellValue(rs.getString(k));
						}
						 cell1=row.createCell((short)((colCount)));
						 cell1.setCellValue("U");
					     style.setLocked(true);
						 cell1.setCellStyle(style);		   
							  
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
					if(constmt!=null)constmt.close();
					if(conrs!=null)conrs.close();
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

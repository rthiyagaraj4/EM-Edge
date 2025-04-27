/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXH.*;
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

//import eCA.DCRDMLTable.DCRColumn;														 




public class XHTranslationSettingExcelUploadServlet  extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet
{

	private String incdNo = "";
	private String loginUser = "";
	private String baseModule = "";
	private String actionKey = "";
	private String tblName = "";
	private String dataOwnerModule = "";
	private File newFile = null;
	private ServletContext sc = null;
	private HttpSession session = null;


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
			session = request.getSession();
				  newFile=new File(request.getParameter("upload_text"));
	

			
		//	session.removeAttribute("dcrTblUpload");	 
			//readBook(request, response);
			read(request, response);
		}
		catch (Exception e)
		{
			//session.removeAttribute("dcrTblUpload");
			session.setAttribute("DFLT_XLS_ERROR","DCR00025 - Invalid file");
			e.printStackTrace();
		}
		finally
		{
			if(newFile != null &&  newFile.exists())
			{
				newFile.delete();
			}
		}
	}

	public void readBook(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		
		// Create a new file upload handler
		   DiskFileUpload upload = new DiskFileUpload();
		   // parse request
		   boolean isMultipart = DiskFileUpload.isMultipartContent(request);

		   if(isMultipart)
		   {
			   List<FileItem> fileItems = upload.parseRequest(request);
			   Iterator<FileItem> itr = fileItems.iterator();
			   FileItem fileItm = null;
			   while(itr.hasNext())
			   {
				   fileItm = itr.next();
				   if(fileItm.isFormField())
				   {
					  String fldName = fileItm.getFieldName();
					  if(fldName.equals("baseModule"))
					  {
						  baseModule = fileItm.getString();
					  }
					  else if(fldName.equals("dataOwnerModule"))
					  {
						  dataOwnerModule = fileItm.getString();
					  }else if(fldName.equals("tblName"))
					  {
						  tblName = fileItm.getString();
					  }
					  else if(fldName.equals("incdNo"))
					  {
						  incdNo = fileItm.getString();
					  }
					  else if(fldName.equals("dcrNo"))
					  {
						 // dcrNo = fileItm.getString();
					  }
					  else if(fldName.equals("actionKey"))
					  {
						  actionKey = fileItm.getString();
					  }
						  else if(fldName.equals("login_user"))
					  {
						  loginUser = fileItm.getString();
					  }
				   }
				   else
				   {
						File dircreate ;
						String path = sc.getRealPath("/");
						Properties pFileSep	= System.getProperties();
						String strFileSep	= (String) pFileSep.getProperty("file.separator");
						StringBuffer repFolder = new StringBuffer();
						repFolder.append(path);
						repFolder.append("eCA");
						repFolder.append(strFileSep);
						repFolder.append("DCRXLS");
						String dirName = repFolder.toString();
						dircreate = new File(dirName);
						boolean isDir = false;
						if(!dircreate.exists())
						{
							isDir = dircreate.mkdirs();
						}

						repFolder.append(strFileSep);
						String file_to_save = "TempXLS"+loginUser+".xls";
						repFolder.append(file_to_save);

						String filename	=	repFolder.toString();
						newFile	= new File(filename);
						boolean isF = false;
						if(!newFile.exists())
						{
							isF = newFile.createNewFile();
						}
					   fileItm.write(newFile);
				   }
			   }
		   }


		   if(actionKey != null && !actionKey.equals(""))
		   {
			   if(actionKey.equals("import"))
			   {
				   read(request, response);
			   }
		   }
		   else
		   {
			   throw new Exception("actionKey can not be null.");
		   }
	}

	private HSSFCellStyle getRowStyle(String dmlType)
	{
		HSSFCellStyle rowStyle = new HSSFWorkbook().createCellStyle();
		if(dmlType.equals("D"))
		{
			rowStyle.setFillBackgroundColor(HSSFColor.RED.index);
			rowStyle.setFillForegroundColor(HSSFColor.WHITE.index);
			rowStyle.setFillPattern(HSSFCellStyle.BIG_SPOTS);
		}
		else if(dmlType.equals("I"))
		{
			rowStyle.setFillBackgroundColor(HSSFColor.YELLOW.index);
			rowStyle.setFillForegroundColor(HSSFColor.WHITE.index);
			rowStyle.setFillPattern(HSSFCellStyle.BORDER_THIN);
		}
		else if(dmlType.equals("M"))
		{
			rowStyle.setFillBackgroundColor(HSSFColor.BLUE.index);
			rowStyle.setFillForegroundColor(HSSFColor.WHITE.index);
			rowStyle.setFillPattern(HSSFCellStyle.BORDER_THIN);
		}

		return rowStyle;
	}

	/*private  void getCellWithDataType(String tblName, HSSFWorkbook dataBook,
		HSSFRow row, String colVal, String colNm, int cellNo, boolean isHeader, String dataType)
	{
		HSSFCellStyle celStyle = dataBook.createCellStyle();

		HSSFSheet sheet = dataBook.getSheet(tblName);
		int width = 4000;
		if(colVal.length() >= 15)
			width = 7000;
		sheet.setColumnWidth(cellNo, width);
		celStyle.setFillBackgroundColor(HSSFColor.ORANGE.index);
		HSSFFont font = dataBook.createFont();
		font.setColor(HSSFColor.BLUE.index);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeight((short)215);
		celStyle.setFont(font);
		//row.setRowStyle(celStyle1);

		HSSFCell cel = row.createCell(cellNo);
		cel.setAsActiveCell();
		if(isHeader)
		{
			cel.setCellStyle(celStyle);
			cel.setCellType(HSSFCell.CELL_TYPE_STRING);
			cel.setCellValue(colVal);
		}
		else
		{
			if (!dataType.equals(DCRStringConstants.number))
			{
				cel.setCellType(HSSFCell.CELL_TYPE_STRING);
				cel.setCellValue(colVal);
			}
			else
			{
				cel.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				if(!colVal.equals(""))
				{
					cel.setCellValue(Integer.parseInt(colVal));
				}
				else
				{
					cel.setCellValue(colVal);
				}
			}
		}
		HSSFRichTextString rt = new HSSFRichTextString(colNm);
		HSSFPatriarch patr = sheet.createDrawingPatriarch();
		HSSFComment cmt = patr.createComment(new HSSFClientAnchor(0, 0, 0, 0,
			(short)4, 2, (short) 6, 5));
		cmt.setString(rt);
		cel.setCellComment(cmt);
	}	*/

	public void read(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
	String mode="U";
	Connection connection = null;
	Statement stmt = null;
	ResultSet rs=null;
	Statement stmtUpdate = null;
	 	MessageManager mm=new MessageManager();
	//ResultSet rsUpdate=null;

	String status="0";  
    try
	{
		if(connection==null) connection = ConnectionManager.getConnection();
//		if(details_hm!=null) details_hm.clear();      
     
	  int result=0;
			int colCount=0;
			 int rowcount=6;
			 String message="";
			HSSFCell cell   =null;
			HSSFRow row  =null;														    
			String Trans_table_d="";		
			String Applicationid="";
			String moduleId="";
			String Tableid="";
			String module_id=request.getParameter("module_id")==null?"":request.getParameter("module_id");
			String masterName=request.getParameter("master_name")==null?"":request.getParameter("master_name");
		   	String language=request.getParameter("language")==null?"":request.getParameter("language");
			String language_direction=request.getParameter("language_direction")==null?"":request.getParameter("language_direction");
			String appl=request.getParameter("application")==null?"":request.getParameter("application");
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
			InputStream  inp = new FileInputStream(newFile);
			String Application_id="";
			String Module_id="";
			String Master_tab_id="";
			HSSFWorkbook wb     = new HSSFWorkbook(new POIFSFileSystem(inp));
			HSSFSheet sheet = wb.getSheetAt(0);
				int totalRow= sheet.getLastRowNum();        
				row     = sheet.getRow(1);        // third row
				cell   = row.getCell((short)1);  // fourth cell
				Applicationid=cell.getStringCellValue();
			    row     = sheet.getRow(2); 
			    cell   = row.getCell((short)1); 
				moduleId=cell.getStringCellValue();
				row     = sheet.getRow(3); 
			    cell   = row.getCell((short)1); 
				Tableid=cell.getStringCellValue();
				stmtUpdate=connection.createStatement();
			   String sqlQueryTrans_Id="select TRANS_TABLE_ID from xh_mapping  where  MASTER_TABLE_ID='"+masterName+"' order by SRL_NO "; 
			  stmt = connection.createStatement();
			  rs =	stmt.executeQuery(sqlQueryTrans_Id);
			  if(rs.next())
			  {
			 	Trans_table_d=rs.getString(1).toUpperCase();
			  }


				 if(Trans_table_d.indexOf("skey")!=-1||Trans_table_d.indexOf("SKEY")!=-1||Trans_table_d.indexOf("Skey")!=-1)
				{
					 for(int i=6;i<=totalRow;i++)
					{
									   
						HSSFRow rowSK1  =sheet.getRow(i); 
						String sqlUpdateQuery="Update XH_OTH_APPL_DATA_SKEY SET DESC2_VALUE='"+rowSK1.getCell((short)(colCount+2)).getStringCellValue()+"', EXT_PK_ID='"+rowSK1.getCell((short)(colCount+1)).getStringCellValue()+"' where TABLE_ID='"+Tableid+"' and APPLICATION_ID='"+Applicationid+"' and PK_VALUE='"+rowSK1.getCell((short)colCount).getStringCellValue()+"' ";
					    result=stmtUpdate.executeUpdate(sqlUpdateQuery);
						 if(result==1)
						{
						   status="0";
						}
						else
						{
							status="1";	 
						}
				}
					if("0".equals(status))											  
				{
					connection.commit();
					 final java.util.Hashtable mesg = mm.getMessage("en", "XH1001", "XH") ;
					//final java.util.Hashtable mesg = mm.getMessage(con, "XH1001") ;
					message = ((String) mesg.get("message"));
				}
				 else
				{
				  connection.rollback();
				   final java.util.Hashtable mesg = mm.getMessage("en", "XH1000", "XH") ;
//				  final java.util.Hashtable mesg = mm.getMessage(con, "XH1000") ;
				  message = ((String) mesg.get("message")); 
				}
				}

				else if(Trans_table_d.indexOf("DKEY")!=-1||Trans_table_d.indexOf("dkey")!=-1)
				{
				   
					
					 for(int i=6;i<=totalRow;i++)
					{
						
						HSSFRow rowPK1  =sheet.getRow(i); 
						String sqlUpdateQuery="Update XH_OTH_APPL_DATA_DKEY SET DESC2_VALUE='"+rowPK1.getCell((short)(colCount+4)).getStringCellValue()+"', EXT_PK1_VALUE='"+rowPK1.getCell((short)(colCount+2)).getStringCellValue()+"', EXT_PK2_VALUE='"+rowPK1.getCell((short)(colCount+3)).getStringCellValue()+"' where TABLE_ID='"+Tableid+"' and APPLICATION_ID='"+Applicationid+"' and PK1_VALUE='"+rowPK1.getCell((short)colCount).getStringCellValue()+"' and PK2_VALUE='"+rowPK1.getCell((short)colCount+1).getStringCellValue()+"'";
						result=stmtUpdate.executeUpdate(sqlUpdateQuery);
							   if(result==1)
						{
						   status="0";
						}												    
						else
						{
							status="1";	 
						}
						
					}
						 if("0".equals(status))											  
						{
							connection.commit();
							 final java.util.Hashtable mesg = mm.getMessage("en", "XH1001", "XH") ;
							message = ((String) mesg.get("message"));
						}
						 else
						{
						  connection.rollback();
						   final java.util.Hashtable mesg = mm.getMessage("en", "XH1000", "XH") ;
						  message = ((String) mesg.get("message")); 
						}
				}
				else
				{
					//Connection connection = null;
					CallableStatement ostmt = null; 
				    ostmt = connection.prepareCall("{ call xhdevapi.GET_UDPT_STATEMENT(?,?,?) }" ); 	   
					ostmt.setString(1,Trans_table_d);
					ostmt.registerOutParameter(2,java.sql.Types.VARCHAR);
					ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
					ostmt.execute();
					String sqlInsertOthersQuery=ostmt.getString(2);		 
					String sqlUpdateOthersQuery=ostmt.getString(3);
					int columCount=sheet.getRow(6).getLastCellNum();
					 ArrayList arrL=new ArrayList();
					 for(int co=0;co<columCount;co++)												    
					{																 
					   HSSFRow rowCOL  =sheet.getRow(5);
					   arrL.add(co,rowCOL.getCell((short)co).getStringCellValue());
					}
				    for(int i=6;i<=totalRow;i++)
					{
							 HSSFRow rowOther  =sheet.getRow(i); 
							  String option_yn="";
							  try
						{
							if(rowOther.getCell((short)(arrL.size()-1)).getStringCellValue()!=null || !rowOther.getCell((short)(arrL.size()-1)).getStringCellValue().equals(""))
							{
											option_yn= XHDBAdapter.checkNull(rowOther.getCell((short)(arrL.size()-1)).getStringCellValue()).equals("")?"":XHDBAdapter.checkNull(rowOther.getCell((short)(arrL.size()-1)).getStringCellValue());
							}
							else	    
							{
							     option_yn="I";
							}
																		  
						}		  															    
						catch(Exception ex)
						{
							System.out.println("  XHTranslationSettingExcelUploadServlet.java exception "+ex);
						}
							 if(option_yn.equals("U")) 
							{												   
								 mode="U";
								  for(int col=0;col<arrL.size();col++)								   
								{
									 if(((String)arrL.get(col)).indexOf("DATE")!=-1)
									{
									  	sqlUpdateOthersQuery=sqlUpdateOthersQuery.replaceAll("X_"+(String)arrL.get(col),"TO_DATE('"+rowOther.getCell((short)(col)).getStringCellValue()+"','DD/MM/YYYY')");     
  
									}
									else
									{
									  sqlUpdateOthersQuery=sqlUpdateOthersQuery.replaceAll("X_"+(String)arrL.get(col),"'"+rowOther.getCell((short)(col)).getStringCellValue()+"'");     
									  sqlUpdateOthersQuery=sqlUpdateOthersQuery.replaceAll("e_"+(String)arrL.get(col),"'"+rowOther.getCell((short)(col)).getStringCellValue()+"'");     
									}
												   
								}	

								sqlUpdateOthersQuery=sqlUpdateOthersQuery.substring(0,sqlUpdateOthersQuery.length());
  							    result=stmtUpdate.executeUpdate(sqlUpdateOthersQuery);	
								    if(result==1)
									{												   
									   status="0";
									}												    
									else
									{
										status="1";	 
									}
								 if("0".equals(status))											  
								{
									connection.commit();
									 final java.util.Hashtable mesg = mm.getMessage("en", "XH1001", "XH") ;
									message = ((String) mesg.get("message"));
								}
								 else
								{
								  connection.rollback();
								   final java.util.Hashtable mesg = mm.getMessage("en", "XH1000", "XH") ;
								  message = ((String) mesg.get("message")); 
								}
							}
							else
							{


								  mode="I";
								  for(int col=0;col<arrL.size();col++)								   
								{

									  try
									{
										   if(((String)arrL.get(col)).indexOf("DATE")!=-1)
										{
											sqlInsertOthersQuery=sqlInsertOthersQuery.replaceAll("X_"+(String)arrL.get(col),"TO_DATE('"+rowOther.getCell((short)(col)).getStringCellValue()+"','DD/MM/YYYY')");     
	  
										}
										else
										{
										  sqlInsertOthersQuery=sqlInsertOthersQuery.replaceAll("X_"+(String)arrL.get(col),"'"+rowOther.getCell((short)(col)).getStringCellValue()+"'");     
										  sqlInsertOthersQuery=sqlInsertOthersQuery.replaceAll("E_"+(String)arrL.get(col),"'"+rowOther.getCell((short)(col)).getStringCellValue()+"'");     
										}

											sqlInsertOthersQuery=sqlInsertOthersQuery.substring(0,sqlInsertOthersQuery.length());
									}
									catch(Exception e)
									{
										System.out.println("exception e"+e);
									}



								}

							   
								  result=stmtUpdate.executeUpdate(sqlInsertOthersQuery);	
								  
						   
								    if(result==1)
									{
									   status="0";
									}												    
									else
									{
										status="1";	 
									}
								   if("0".equals(status))											  
								   {
									connection.commit();
									 final java.util.Hashtable mesg = mm.getMessage("en", "XH1001", "XH") ;
									message = ((String) mesg.get("message"));
								   }
								   else
								{
								  connection.rollback();
								   final java.util.Hashtable mesg = mm.getMessage("en", "XH1000", "XH") ;
								  message = ((String) mesg.get("message")); 
								}
							} 
						  
					
						
							
					}
					
				}
				
					
				 RequestDispatcher reqDis =	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayTransSettingExcelResult.jsp?&message="+message+"&module_id="+module_id+"&master_name="+masterName+"&language="+language+"&language_direction="+language_direction+"&application="+appl+"&display="+display+"&searchText="+searchText+"&Searchbymod="+Searchbymod+"&SearchbyFunct="+SearchbyFunct+"&start_ends_contains="+start_ends_contains+"&searchpk2="+searchpk2+"&searchpk3="+searchpk3);
			     reqDis.forward(request,response);
				 }
      catch(Exception exp)
      {																																																																																																																												 

		System.out.println("Error in calling getconnection method of XHTranslationSettingExcelUploadServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		
        
      }
		finally
		{
		  if(connection!=null) connection.close();	  
		  if(stmtUpdate != null) stmtUpdate.close();
		  if(stmt != null) stmt.close();
		  if(rs!=null) rs.close();
	
		}
	}

	/*public boolean isRowEmpty(CommonCollectionUtils<String, String> rowMap, ArrayList<String> pkCols)
	{
		if(rowMap != null  && pkCols != null)
		{
			String val = "";
			for(String colName : pkCols)
			{
				val = rowMap.get(colName);
			}
			if(val!= null)
			{
				return (val.equals("")?true:false);
			}
		}
		return  true;
	}  */
}														  

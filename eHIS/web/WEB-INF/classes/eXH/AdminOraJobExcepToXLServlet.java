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
																					 
import org.apache.poi.hssf.model.*;															  
import org.apache.poi.hssf.usermodel.*;

/**
 * Servlet used to generate excel file for the inbound/outbound events. 
 */
public class AdminOraJobExcepToXLServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		try
		{								
		/*	HttpSession session = request.getSession(false);						
			Properties p = (Properties) session.getValue("jdbc");	
			String locale  = p.getProperty("LOCALE");													
		*/
			String locale = "en";
			HttpSession session=request.getSession(false); 				
			Connection connection = null;
			Statement stmt = null;
			ResultSet rs = null;
			CallableStatement ostmt = null;
			String sqlQry = null;
			  
			try
			{
				String procID = (String)request.getParameter("proc_id");
				String moduleID = procID.substring(0,2);							  
				//String tableName = moduleID + "_proc_msg";
				String fromDate = (String)request.getParameter("fromDate");
				String toDate = (String)request.getParameter("toDate");
				String facilityID = (String)request.getParameter("facilityID");			 
				String criteriaYN = (String)request.getParameter("flag");
				String action = (String)request.getParameter("action");
				String functionID=XHDBAdapter.checkNull((String)request.getParameter("functionID"));
				String rule = XHDBAdapter.checkNull((String)request.getParameter("rule"));
				String status="";							  
		//	   System.out.println(" rule :"+rule);
				sqlQry = "SELECT OPERATING_FACILITY_ID, PROC_ID, FAILED_PROC_ID, MODULE_ID, MSG_NUM, APP_MSG, ERR_MSG, MSG_DATE_TIME, APP_KEY FROM XF_PROC_MSG";																								   				

			/*	String proc_id = XHDBAdapter.checkNullNoTrim(request.getParameter("proc_id"));
				boolean flag = false;	
				String whereClause = " ";
				String tableNameSuffix = "";
			
				System.out.println("tableName "+tableName);
				System.out.println("(AdminOraJobExcepToXLServlet.jsp) proc_id: "+procID);
				System.out.println("(AdminOraJobExcepToXLServlet.jsp) moduleID: "+moduleID);
				System.out.println("(AdminOraJobExcepToXLServlet.jsp) fromDate: "+fromDate);
				System.out.println("(AdminOraJobExcepToXLServlet.jsp) toDate: "+toDate);
				System.out.println("(AdminOraJobExcepToXLServlet.jsp) facilityID: "+facilityID);
				System.out.println("(AdminOraJobExcepToXLServlet.jsp) criteriaYN: "+criteriaYN);
				System.out.println("(AdminOraJobExcepToXLServlet.jsp) action: "+action);
			*/
				if("Y".equalsIgnoreCase(criteriaYN))
				{
					if("result".equalsIgnoreCase(action))
					{
//						sqlQry = sqlQry+" WHERE OPERATING_FACILITY_ID = NVL('"+facilityID+"',OPERATING_FACILITY_ID) AND  failed_proc_id = '"+procID+"' AND  MSG_DATE_TIME BETWEEN NVL(to_date('"+fromDate+"','DD/MM/YYYY HH24:MI'),MSG_DATE_TIME) AND NVL(to_date('"+toDate+"','DD/MM/YYYY HH24:MI'),MSG_DATE_TIME)";
						sqlQry = sqlQry+" WHERE OPERATING_FACILITY_ID = NVL('"+facilityID+"',OPERATING_FACILITY_ID) AND  proc_id = '"+procID+"' AND  MSG_DATE_TIME BETWEEN NVL(to_date('"+fromDate+"','DD/MM/YYYY HH24:MI'),MSG_DATE_TIME) AND NVL(to_date('"+toDate+"','DD/MM/YYYY HH24:MI'),MSG_DATE_TIME)";
					}
					
				}
				else				   
				{
															    		   
					 if("result".equalsIgnoreCase(action))
					{
//						sqlQry =sqlQry+" WHERE failed_proc_id = '"+procID+"'";	    
						sqlQry =sqlQry+" WHERE proc_id = '"+procID+"'";	    
					}
				}

//				System.out.println("DsqlQry "+sqlQry);

				connection = ConnectionManager.getConnection();
				stmt = connection.createStatement();		    

				if("result".equalsIgnoreCase(action))
				{
				
					response.setContentType("application/vnd.ms-excel");
					response.setHeader("Content-Disposition", "attachment; filename=ProcessExceptions.xls");
					
					HSSFWorkbook wb = new HSSFWorkbook();
					HSSFSheet sheet = wb.createSheet("Administer Data Process");			

					// Create a row and put some cells in it. Rows are 0 based.
					HSSFRow row = null;
					HSSFCellStyle cs = wb.createCellStyle();
					HSSFFont font = wb.createFont();													    
					font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
					cs.setFont(font);

					rs = stmt.executeQuery(sqlQry);

					row = sheet.createRow((short)0);
					HSSFCell cell = row.createCell((short)0);
					
				//	row.setRowStyle(cs);
					
					cell.setCellValue("PROC_ID");
					cell.setCellStyle(cs);
					cell = row.createCell((short)1);
									
					cell.setCellValue("OPERATING_FACILITY_ID");
					cell.setCellStyle(cs);
					cell = row.createCell((short)2);

					cell.setCellValue("FAILED_PROC_ID");
					cell.setCellStyle(cs);
					cell = row.createCell((short)3);

					cell.setCellValue("MODULE_ID");			     
					cell.setCellStyle(cs);
					cell = row.createCell((short)4);

					cell.setCellValue("MSG_NUM");
					cell.setCellStyle(cs);
					cell = row.createCell((short)5);

					cell.setCellValue("APP_MSG");
					cell.setCellStyle(cs);
					cell = row.createCell((short)6);

					cell.setCellValue("ERR_MSG");
					cell.setCellStyle(cs);
					cell = row.createCell((short)7);

					cell.setCellValue("MSG_DATE_TIME");
					cell.setCellStyle(cs);
					cell = row.createCell((short)8);

					cell.setCellValue("APP_KEY");
					cell.setCellStyle(cs);
					cell = row.createCell((short)9);

					int rowCount = 1;
					while(rs.next())
					{				
						row = sheet.createRow((short)rowCount++);
						row.createCell((short)0).setCellValue(rs.getString("PROC_ID"));
						row.createCell((short)1).setCellValue(rs.getString("OPERATING_FACILITY_ID"));
						row.createCell((short)2).setCellValue(rs.getString("FAILED_PROC_ID"));
						row.createCell((short)3).setCellValue(rs.getString("MODULE_ID"));
						row.createCell((short)4).setCellValue(rs.getString("MSG_NUM"));
						row.createCell((short)5).setCellValue(rs.getString("APP_MSG"));
						row.createCell((short)6).setCellValue(rs.getString("ERR_MSG"));										
						row.createCell((short)7).setCellValue(rs.getString("MSG_DATE_TIME"));		  							
						row.createCell((short)8).setCellValue(rs.getString("APP_KEY"));					
					}						
					
					ServletOutputStream op = response.getOutputStream();

					wb.write(op);			
					op.flush();					  
					op.close();
				}
				else
				{
				 try{

					ostmt = connection.prepareCall("{ CALL  XFGUI.Xf_Purge_Exception_Records(?,?,?,?,?,?,?)}" ); 
					ostmt.setString(1,facilityID);
//					System.out.println(" AdminOraJobExcepToXLServlet.java facilityID :"+facilityID);
					ostmt.setString(2,procID);
//					System.out.println(" AdminOraJobExcepToXLServlet.java procID :"+procID);
					ostmt.setString(3,moduleID);									  
//					System.out.println(" AdminOraJobExcepToXLServlet.java moduleID :"+moduleID);	 
					ostmt.setString(4,fromDate);
//					System.out.println(" AdminOraJobExcepToXLServlet.java fromDate :"+fromDate);
					ostmt.setString(5,toDate);  													    
//					System.out.println(" AdminOraJobExcepToXLServlet.java toDate :"+toDate);
					ostmt.setString(6,""); 
//					System.out.println(" AdminOraJobExcepToXLServlet.java service :");	
					ostmt.registerOutParameter(7,java.sql.Types.VARCHAR);
					ostmt.execute();		 									 
//					System.out.println(" AdminOraJobExcepToXLServlet.java service2 :");								    
					status = ostmt.getString(7); 			 								    
//						System.out.println("AdminOraJobExcepToXLServlet status: "+status);
																					
					 									  
					//int i = stmt.executeUpdate(sqlQry);	
					String msg = "";
					MessageManager mm = new MessageManager();
					
					if(status.equals("0"))
					{
						connection.commit();
						java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;						
						msg = ((String) mesg.get("message"));
						mesg.clear();
					}								  
					else
					{
						connection.rollback();
						java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;						
						msg = ((String) mesg.get("message"));
						mesg.clear();
					}

					//PrintWriter out = response.getWriter();									    
				//	out.write("<SCRIPT>alert('"+msg+"')</SCRIPT>");
				//	out.flush();	
					if("purge".equalsIgnoreCase(action) || rule.equals(""))
					{
					   RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResultAdminProcess.jsp?message="+msg+"&functionID="+functionID);
					   reqDis.forward(request,response);	
					}
												  
					   
					   if("purge".equalsIgnoreCase(action) || rule.equals("I"))
					{
						    RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResultAdminProcess.jsp?message="+msg+"&functionID="+functionID+"&proc_id="+procID+"&rule="+rule);  
						   reqDis.forward(request,response);
					}																	 
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
			finally
			{
				try
				{
						if(ostmt!=null)ostmt.close();	

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
}//end of class 

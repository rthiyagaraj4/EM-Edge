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
public class GenerateQueryEventsToXLServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		try
		{								
		//	HttpSession session = request.getSession(false);
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=QueryEvents.xls");

			
		//	Properties p = (Properties) session.getValue("jdbc");	
		//	String locale  = p.getProperty("LOCALE");										

			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Query Events");			

			// Create a row and put some cells in it. Rows are 0 based.
			HSSFRow row = null;
			HSSFCellStyle cs = wb.createCellStyle();
			HSSFFont font = wb.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			cs.setFont(font);
							
			Connection connection = null;
			Statement stmt = null;
			ResultSet rs = null;

			String sqlQry = null;
			String comType = null;

			try
			{
				comType = request.getParameter("comm_mode");

                sqlQry = "SELECT A.APPLICATION_ID,B.APPLICATION_NAME,A.FACILITY_ID, B.FACILITY_NAME,A.QUERY_ID,C.MESSAGE_ID,TO_CHAR(A.QUERY_DATE,'DD/MM/YYYY HH:MI:SS'),A.QUERY_TYPE,C.MESSAGE_STATUS,A.ADDED_BY_ID,TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY HH:MI:SS'),A.MODIFIED_BY_ID,TO_CHAR(A.MODIFIED_DATE,'DD/MM/YYYY HH:MI:SS'),A.ADDED_AT_WS_NO,A.ADDED_FACILITY_ID,A.MODIFIED_AT_WS_NO,A.MODIFIED_FACILITY_ID,A.QUERY_PRIORITY,A.PROCESS_ID, A.STATUS_TEXT,A.EVENT_TYPE,A.ACCESSION_NUMBER,A.SITE_ID,TO_CHAR(A.LAST_PROC_START_TIME,'DD/MM/YYYY HH:MI:SS'),TO_CHAR(A.LAST_PROC_END_TIME,'DD/MM/YYYY HH:MI:SS'),A.QUERY_STATUS,A.PROTOCOL_LINK_ID,A.APP_MSG, A.ERR_MSG FROM XH_APPLICATION_LANG_VW B,xh_application_message c,";
										
			//	String action_type	= XHDBAdapter.checkNull(request.getParameter("action_type"));
				String msg_status = XHDBAdapter.checkNullNoTrim(request.getParameter("msg_status"));
                String qry_id1	= XHDBAdapter.checkNull(request.getParameter("qry_id1")); 
                String qry_id2	= XHDBAdapter.checkNull(request.getParameter("qry_id2"));
								String qmsg_id1	= XHDBAdapter.checkNull(request.getParameter("qmsg_id1")); 
				String qmsg_id2	= XHDBAdapter.checkNull(request.getParameter("qmsg_id2"));  
				
				
			
			//	String tabValue = XHDBAdapter.checkNull(request.getParameter("tabValue"));
				
			//	String msg_date = XHDBAdapter.checkNull(request.getParameter("msg_date"));
				String eventtype = XHDBAdapter.checkNull(request.getParameter("eventtype"));
				String qfacility = XHDBAdapter.checkNull(request.getParameter("qfacility"));
				String qapplname = XHDBAdapter.checkNull(request.getParameter("qapplname"));	
			//	String interface_module = XHDBAdapter.checkNull(request.getParameter("interface_module"));	
				
				String eventStatus= XHDBAdapter.checkNull(request.getParameter("qstatus"));
				String qmsg_dt1= XHDBAdapter.checkNull(request.getParameter("qmsg_dt1"));
               String qmsg_dt2= XHDBAdapter.checkNull(request.getParameter("qmsg_dt2"));
				String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));	
				String protocol_link_id = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));	
			//	String pmode = XHDBAdapter.checkNull(request.getParameter("pmode"));

					
				String whereClause = " WHERE ";
				String tableNameSuffix = "";

				//facility	
				whereClause =" WHERE "+
		  " A.APPLICATION_ID=NVL('"+qapplname+"',A.APPLICATION_ID) AND "+
          " A.FACILITY_ID=NVL('"+qfacility+"',A.FACILITY_ID) "+
          " AND DECODE(A.QUERY_STATUS,NULL,'XX',A.QUERY_STATUS) =NVL('"+eventStatus+"',DECODE(A.QUERY_STATUS,NULL,'XX',A.QUERY_STATUS)) "+
         // " QUERY_STATUS=NVL('#qstatus',QUERY_STATUS) "+
		  " AND TO_DATE(A.QUERY_DATE) BETWEEN TO_DATE(NVL('"+qmsg_dt1+"',TO_CHAR(A.QUERY_DATE,'dd/mm/yyyy')),'dd/mm/yyyy') AND TO_DATE(NVL('"+qmsg_dt2+"',TO_CHAR(A.QUERY_DATE,'dd/mm/yyyy')),'dd/mm/yyyy') and A.APPLICATION_ID=B.APPLICATION_ID AND A.QUERY_ID=c.QUERY_ID ";  
		  if((qry_id1 != null) && (!(qry_id1.equals(""))))			
			{
				whereClause =whereClause +"AND A.QUERY_ID BETWEEN"+ 	
									"  nvl('#qry_id1',A.QUERY_ID) AND nvl('#qry_id2',A.QUERY_ID)";
			} 
  
		//msg_id2
	if((qry_id1 != null) && (!(qry_id1.equals(""))))			
	{
		if((qry_id1 != null) && (!(qry_id1.equals("")))) {}
		else
		{
			whereClause = whereClause +"AND A.QUERY_ID <"+ 	
								"  nvl('#qry_id2',A.QUERY_ID)";
		}
	} 

	if((qry_id2 != null) && (!(qry_id1.equals(""))))			
	{
		if((qry_id1 != null) && (!(qry_id1.equals("")))) {}
		else
		{
			whereClause = whereClause +" A.QUERY_ID BETWEEN"+ 	
							"  nvl('#qry_id2',A.QUERY_ID)";
		}
	
	} 




    if((protocol_link_id != null) && (!(protocol_link_id.equals(""))))			
	{
		whereClause = whereClause + " AND A.protocol_link_id = nvl('#protocol_link_id',A.protocol_link_id) ";
	}
	if((protocol_link_id != null) && (!protocol_link_id.equals("")) )
	{
		whereClause = whereClause + " A.protocol_link_id = nvl('#protocol_link_id',A.protocol_link_id) ";
	}
    if((qmsg_id1 != null) && (!(qmsg_id1.equals(""))))			
	{
		whereClause =whereClause +"AND c.message_id BETWEEN"+ 	
							"  nvl('#qmsg_id1',c.message_id) AND nvl('#qmsg_id2',c.message_id)";
	} 

	

	//msg_id2
	if((qmsg_id1 != null) && (!(qmsg_id1.equals(""))))			
	{
		if((qmsg_id1 != null) && (!(qmsg_id1.equals("")))) {}
		else
		{
			whereClause = whereClause +"AND c.message_id <"+ 	
								"  nvl('#qmsg_id2',c.message_id)";
		}
	} 

	if((qmsg_id2 != null) && (!(qmsg_id2.equals(""))))			
	{
		if((qmsg_id1 != null) && (!(qmsg_id1.equals("")))) {}
		else
		{
			whereClause = whereClause +" c.message_id BETWEEN"+ 	
							"  nvl('#qmsg_id2',c.message_id)";
		}
	
	} 

	//msg_dt
	if((eventtype != null) && (!(eventtype.equals(""))))			
	{
		whereClause =whereClause + " AND EVENT_TYPE = NVL('#eventtype',EVENT_TYPE)";
	} 

	if((eventtype != null) && (!(eventtype.equals(""))))			
	{
		whereClause =whereClause + " EVENT_TYPE = NVL('#eventtype',EVENT_TYPE)";
		
	} 

 if((msg_status != null) && (!(msg_status.equals(""))))			
	{
		if(msg_status.equals(" "))
		{
			whereClause =whereClause +" AND C.MESSAGE_STATUS IS NULL ";
		}
		else
		{
			whereClause =whereClause +" AND C.MESSAGE_STATUS = NVL('#msg_status',C.MESSAGE_STATUS)";
		}
	} 




	if((msg_status != null) && (!(msg_status.equals(""))))			
	{
		if(msg_status.equals(" "))
		{
			whereClause =whereClause +" C.MESSAGE_STATUS IS NULL ";
		}
		else
		{
			whereClause =whereClause +" C.MESSAGE_STATUS = NVL('#msg_status',C.MESSAGE_STATUS)";
		}
	
	}

	whereClause=whereClause+" ORDER BY 1,2"; 


 if(purge_status != null && !purge_status.equals(""))
	{
		//tableNameSuffix = sub_module+"_"+purge_status+"_QRY_MSG_VW A";
	}
	else 
	{
		tableNameSuffix = "XH_APPLICATION_QRY_MSG_VW A";
	}

				sqlQry = sqlQry+tableNameSuffix+whereClause;

	//			System.out.println("Query:: "+sqlQry);

				connection = ConnectionManager.getConnection();
				stmt = connection.createStatement();
				rs = stmt.executeQuery(sqlQry);

				row = sheet.createRow((short)0);
				HSSFCell cell = row.createCell((short)0);
				
			//	row.setRowStyle(cs);
				cell.setCellValue("APPLICATION_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)1);
									
				cell.setCellValue("APPLICATION_NAME");
				cell.setCellStyle(cs);
				cell = row.createCell((short)2);

				cell.setCellValue("FACILITY_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)3);

				cell.setCellValue("FACILITY_NAME");
				cell.setCellStyle(cs);
				cell = row.createCell((short)4);
                cell.setCellValue("QUERY_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)5);
				cell.setCellValue("MESSAGE_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)6);

				cell.setCellValue("QUERY_DATE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)7);

				cell.setCellValue("QUERY_TYPE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)8);

				cell.setCellValue("MESSAGE_STATUS");
				cell.setCellStyle(cs);
				cell = row.createCell((short)9);

				cell.setCellValue("ADDED_BY_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)10);

				cell.setCellValue("ADDED_DATE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)11);

				cell.setCellValue("MODIFIED_BY_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)12);

				cell.setCellValue("MODIFIED_DATE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)13);

				cell.setCellValue("ADDED_AT_WS_NO");
				cell.setCellStyle(cs);
				cell = row.createCell((short)14);

				cell.setCellValue("ADDED_FACILITY_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)15);

				cell.setCellValue("MODIFIED_FACILITY_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)16);

				cell.setCellValue("MODIFIED_AT_WS_NO");
				cell.setCellStyle(cs);
				cell = row.createCell((short)17);

				cell.setCellValue("QUERY_PRIORITY");
				cell.setCellStyle(cs);
				cell = row.createCell((short)18);

				cell.setCellValue("PROCESS_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)19);

				cell.setCellValue("STATUS_TEXT");
				cell.setCellStyle(cs);
				cell = row.createCell((short)20);

				cell.setCellValue("EVENT_TYPE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)21);

				cell.setCellValue("ACCESSION_NUM");
				cell.setCellStyle(cs);
				cell = row.createCell((short)22);

				cell.setCellValue("SITE_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)23);

				cell.setCellValue("LAST_PROC_START_DATE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)24);

                cell.setCellValue("LAST_PROC_END_DATE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)25);
				cell.setCellValue("EVENT_STATUS");
				cell.setCellStyle(cs);
				cell = row.createCell((short)26);
                cell.setCellValue("PROTOCOL_LINK_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)27); 
								
               cell.setCellValue("APP_MSG");
				cell.setCellStyle(cs);
				cell = row.createCell((short)28);

				cell.setCellValue("ERR_MSG");
				cell.setCellStyle(cs);
				cell = row.createCell((short)29);

				
				
				int rowCount = 1;
				while(rs.next())
				{				
					row = sheet.createRow((short)rowCount++);
					row.createCell((short)0).setCellValue(rs.getString(1));
					row.createCell((short)1).setCellValue(rs.getString(2));
					row.createCell((short)2).setCellValue(rs.getString(3));
					row.createCell((short)3).setCellValue(rs.getString(4));
					row.createCell((short)4).setCellValue(rs.getString(5));
					row.createCell((short)5).setCellValue(rs.getString(6));
					row.createCell((short)6).setCellValue(rs.getString(7));										
					row.createCell((short)7).setCellValue(rs.getString(8));									
					row.createCell((short)8).setCellValue(rs.getString(9));					
					row.createCell((short)9).setCellValue(rs.getString(10));
					row.createCell((short)10).setCellValue(rs.getString(11));
					row.createCell((short)11).setCellValue(rs.getString(12));
					row.createCell((short)12).setCellValue(rs.getString(13));
					row.createCell((short)13).setCellValue(rs.getString(14));
					row.createCell((short)14).setCellValue(rs.getString(15));
					row.createCell((short)15).setCellValue(rs.getString(16));
					row.createCell((short)16).setCellValue(rs.getString(17));
					row.createCell((short)17).setCellValue(rs.getString(18));
					row.createCell((short)18).setCellValue(rs.getString(19));
					row.createCell((short)19).setCellValue(rs.getString(20));
					row.createCell((short)20).setCellValue(rs.getString(21));
					row.createCell((short)21).setCellValue(rs.getString(22));
					row.createCell((short)22).setCellValue(rs.getString(23));
					row.createCell((short)23).setCellValue(rs.getString(24));
					row.createCell((short)24).setCellValue(rs.getString(25));
					row.createCell((short)25).setCellValue(rs.getString(26));
					row.createCell((short)26).setCellValue(rs.getString(27));
					row.createCell((short)27).setCellValue(rs.getString(28));										
					row.createCell((short)28).setCellValue(rs.getString(29));				
					
				}						
				
			//	FileOutputStream fileOut = new FileOutputStream(filePath+"eXH/InboundEvents.xls");
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

	
}//end of class 

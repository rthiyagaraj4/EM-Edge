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
public class GenerateOutboundEventsToXLServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		try
		{								
		//	HttpSession session = request.getSession(false);
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=OutboundEvents.xls");

			
		//	Properties p = (Properties) session.getValue("jdbc");	
		//	String locale  = p.getProperty("LOCALE");										

			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Outbound Events");			

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

				sqlQry = "SELECT APPLICATION_ID,application_name,To_number(MESSAGE_ID) MESSAGE_ID,"+
						"TO_CHAR(MESSAGE_DATE,'DD/MM/YYYY HH24:MI:SS') MESSAGE_DATE,EVENT_TYPE,PATIENT_ID,MERGED_PATIENT_ID,"+
						"FACILITY_NAME,FACILITY_ID,EPISODE_TYPE,To_number(EPISODE_ID) EPISODE_ID,to_number(VISIT_ID) VISIT_ID,"+
						"ACCESSION_NUM,EXT_ACCESSION_NUM,ACTION_TYPE,TO_CHAR(LAST_PROC_DATE,'DD/MM/YYYY HH24:MI:SS') LAST_PROC_DATE,"+
						"EVENT_STATUS,NOT_REQ_REASON,ADDED_BY_ID,TO_CHAR(ADDED_DATE,'DD/MM/YYYY HH24:MI:SS') ADDED_DATE,ADDED_AT_WS_NO,"+
						"MODIFIED_BY_ID,TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY HH24:MI:SS') MODIFIED_DATE,MODIFIED_AT_WS_NO,MESSAGE_STATUS,PROTOCOL_LINK_ID, "+
						"MESSAGE_STATUS_DESC,ADDED_FACILITY_ID,MODIFIED_FACILITY_ID,OUTBOUND_COMM_MODE,SOLICITED_YN,ERR_MSG, "+
						"SYS_DEF_MESSAGE_TEXT,MESSAGE_TEXT,MESSAGE_LENGTH,LAST_COMM_START_TIME,LAST_COMM_END_TIME,LAST_COMM_RETRIES,"+
						"QUERY_ID,STATUS_TEXT,OUTBOUND_FILE_NAME FROM ";
										
			//	String action_type	= XHDBAdapter.checkNull(request.getParameter("action_type"));
				String msg_status = XHDBAdapter.checkNullNoTrim(request.getParameter("msg_status"));
				String facility = XHDBAdapter.checkNull(request.getParameter("facility")); 
				String msg_id1	= XHDBAdapter.checkNull(request.getParameter("msg_id1")); 
				String msg_id2	= XHDBAdapter.checkNull(request.getParameter("msg_id2"));  
				String msg_dt1	= XHDBAdapter.checkNull(request.getParameter("msg_dt1")); 
				String msg_dt2	= XHDBAdapter.checkNull(request.getParameter("msg_dt2")); 
				String orderBy	= XHDBAdapter.checkNull(request.getParameter("orderBy"));
				String order = XHDBAdapter.checkNull(request.getParameter("order"));
			//	String tabValue = XHDBAdapter.checkNull(request.getParameter("tabValue"));
				String pat_id = XHDBAdapter.checkNull(request.getParameter("pat_id"));
				String merg_pat_id	= XHDBAdapter.checkNull(request.getParameter("merg_pat_id"));
				String episode_type = XHDBAdapter.checkNull(request.getParameter("episode_type"));
				String episode_id = XHDBAdapter.checkNull(request.getParameter("episode_id"));
				String visit_id = XHDBAdapter.checkNull(request.getParameter("visit_id"));
				String action_typ = XHDBAdapter.checkNull(request.getParameter("action_typ"));
				String last_processed_date	= XHDBAdapter.checkNull(request.getParameter("last_processed_date"));
				String not_req_rsn	= XHDBAdapter.checkNull(request.getParameter("not_req_rsn"));
				String addid = XHDBAdapter.checkNull(request.getParameter("addid"));
				String addeddate = XHDBAdapter.checkNull(request.getParameter("addeddate"));
				String addedwsno = XHDBAdapter.checkNull(request.getParameter("addedwsno"));
				String modfid = XHDBAdapter.checkNull(request.getParameter("modfid"));
				String modifieddate = XHDBAdapter.checkNull(request.getParameter("modifieddate"));	
				String modifiedwsno = XHDBAdapter.checkNull(request.getParameter("modifiedwsno"));
			//	String msg_date = XHDBAdapter.checkNull(request.getParameter("msg_date"));
				String eventtype = XHDBAdapter.checkNull(request.getParameter("eventtype"));
				String applnname = XHDBAdapter.checkNull(request.getParameter("applnname"));	
			//	String interface_module = XHDBAdapter.checkNull(request.getParameter("interface_module"));	
				String sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module"));	
				String eventStatus= XHDBAdapter.checkNull(request.getParameter("event_status"));
				String externalAccNoFrom = XHDBAdapter.checkNull(request.getParameter("externalAccNoFrom"));
				String externalAccNoTo = XHDBAdapter.checkNull(request.getParameter("externalAccNoTo"));
				String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));	
				String protocol_link_ID = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));	
			//	String pmode = XHDBAdapter.checkNull(request.getParameter("pmode"));

				boolean flag = false;	
				String whereClause = " WHERE ";
				String tableNameSuffix = "";

				//facility	
				if((facility != null ) && (!(facility.equals(""))))			
				{
					whereClause =whereClause + " FACILITY_ID = NVL('"+facility+"',FACILITY_ID)";
					flag=true;
				} 

				//application_id
				if((flag==true) && (applnname != null) && (!(applnname.equals(""))))			
				{
					whereClause =whereClause + " AND APPLICATION_ID = NVL('"+applnname+"',APPLICATION_ID)";
				} 

				if((flag==false) && (applnname != null) && (!(applnname.equals(""))))			
				{
					whereClause =whereClause + " APPLICATION_ID = NVL('"+applnname+"',APPLICATION_ID)";
					flag=true;
				} 

				//eventtype
				if((flag==true) && (eventtype != null) && (!(eventtype.equals(""))))			
				{
					whereClause =whereClause + " AND EVENT_TYPE = NVL('"+eventtype+"',EVENT_TYPE)";
				} 

				if((flag==false) && (eventtype != null) && (!(eventtype.equals(""))))			
				{
					whereClause =whereClause + " EVENT_TYPE = NVL('"+eventtype+"',EVENT_TYPE)";
					flag=true;
				} 

				//eventStatus
				if((flag==true) && (eventStatus != null) && (!eventStatus.trim().equals("") ) )			
				{
					whereClause =whereClause + " AND EVENT_STATUS = NVL('"+eventStatus+"',EVENT_STATUS)";
				} 

				if((flag==false) && (eventStatus != null) && (!eventStatus.trim().equals("")))			
				{
					whereClause =whereClause + " EVENT_STATUS = NVL('"+eventStatus+"',EVENT_STATUS)";
					flag=true;
				} 

				//msgstatus
				if((flag==true) && (msg_status != null) && (!msg_status.equals("")))			
				{
					if(msg_status.equals(" "))
						whereClause =whereClause +" AND MESSAGE_STATUS IS NULL ";
					else
						whereClause =whereClause +" AND MESSAGE_STATUS = "+"NVL('"+msg_status+"',MESSAGE_STATUS)";
				} 

				if((flag==false) && (msg_status != null) && (!msg_status.equals("")))			
				{
					if(msg_status.equals(" "))
						whereClause =whereClause +" MESSAGE_STATUS IS NULL ";
					else
						whereClause =whereClause +" MESSAGE_STATUS = "+						
										"NVL('"+msg_status+"',MESSAGE_STATUS)";
					flag=true;
				} 

				//msg_id
				if((flag==true) && (msg_id1 != null) && (!(msg_id1.equals(""))))			
				{
					whereClause =whereClause +"AND TO_NUMBER(message_id) BETWEEN"+ 	
										"  nvl('"+msg_id1+"',message_id) AND nvl('"+msg_id2+"',message_id)";
				} 

				if((flag==false) && (msg_id1 != null) && (!(msg_id1.equals(""))))			
				{
					whereClause =whereClause +" TO_NUMBER(message_id) BETWEEN"+ 	
										"  nvl('"+msg_id1+"',message_id) AND nvl('"+msg_id2+"',message_id)";
					flag=true;
				} 

				//msg_dt
				if((flag==true) && (msg_dt1 != null) && (!(msg_dt1.equals(""))))			
				{
					whereClause =whereClause +" AND TO_DATE(MESSAGE_DATE) BETWEEN  "+  	
										"TO_DATE(NVL('"+msg_dt1+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')"+
										" AND TO_DATE(NVL('"+msg_dt2+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
				} 

				if((flag==false) && (msg_dt1 != null) && (!(msg_dt1.equals(""))))			
				{
					whereClause =whereClause +"  TO_DATE(MESSAGE_DATE) BETWEEN  "+  	
										" TO_DATE(NVL('"+msg_dt1+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')"+
										" AND "+ "TO_DATE(NVL('"+msg_dt2+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
					flag=true;
				} 

				//patient_id
				if((flag==true) && (pat_id != null) && (!(pat_id.equals(""))))			
				{
					whereClause =whereClause +" AND  PATIENT_ID= NVL('"+pat_id+"' ,PATIENT_ID)";
				} 

				if((flag==false) && (pat_id != null) && (!(pat_id.equals(""))))		
				{
					whereClause =whereClause +" PATIENT_ID= NVL('"+pat_id+"' ,PATIENT_ID)";
					flag=true;
				} 

				//merge_patient_id
				if((flag==true) && (merg_pat_id != null) && (!(merg_pat_id.equals(""))))			
				{
					whereClause =whereClause +"AND (NVL(MERGED_PATIENT_ID,  'X' ) = NVL('"+merg_pat_id+"','X') OR  "+ 
										"MERGED_PATIENT_ID = NVL('"+merg_pat_id+"',MERGED_PATIENT_ID))";
				} 
				if((flag==false) && (merg_pat_id != null) && (!(merg_pat_id.equals(""))))			
				{
					whereClause =whereClause +" (NVL(MERGED_PATIENT_ID,  'X' ) = NVL('"+merg_pat_id+"','X') OR  "+ 
										"MERGED_PATIENT_ID = NVL('"+merg_pat_id+"',MERGED_PATIENT_ID))";
					flag=true;
				} 

				//episode_type
				if((flag==true) && (episode_type != null) && (!(episode_type.equals(""))))			
				{
					whereClause =whereClause +"AND EPISODE_TYPE= NVL('"+episode_type+"' ,EPISODE_TYPE)";
				} 

				if((flag==false) && (episode_type != null) && (!(episode_type.equals(""))))			
				{
					whereClause =whereClause +" EPISODE_TYPE= NVL('"+episode_type+"' ,EPISODE_TYPE)";
				} 

				//episode_id
				if((flag==true) && (episode_id != null) && (!(episode_id.equals(""))))			
				{
					whereClause =whereClause +" AND EPISODE_ID = NVL('"+episode_id+"',EPISODE_ID)";
				} 

				if((flag==false) && (episode_id != null) && (!(episode_id.equals(""))))			
				{
					whereClause =whereClause +" EPISODE_ID = NVL('"+episode_id+"',EPISODE_ID)";
					flag=true;
				} 

				//visit_id
				if((flag==true) && (visit_id != null) && (!(visit_id.equals(""))))			
				{
					whereClause =whereClause +"  AND VISIT_ID= NVL('"+visit_id+"' ,VISIT_ID)";
				} 

				if((flag==false) && (visit_id != null) && (!(visit_id.equals(""))))			
				{
					whereClause = whereClause +" VISIT_ID= NVL('"+visit_id+"' ,VISIT_ID)";
					flag=true;
				} 

				//action type
				if(action_typ != null)
				{
					action_typ=action_typ.trim();	
				}
				if((flag==true) && (action_typ != null) && (!(action_typ.equals(""))))		
				{
					whereClause = whereClause +"  AND ACTION_TYPE = NVL('"+action_typ+"',ACTION_TYPE) ";
				} 

				if((flag==false) && (action_typ != null) && (!(action_typ.equals(""))))		
				{
					whereClause = whereClause +" ACTION_TYPE = NVL('"+action_typ+"',ACTION_TYPE) ";
					flag=true;
				} 
				if((flag==true) && (last_processed_date != null) && (!(last_processed_date.equals(""))))			
				{
					whereClause = whereClause + " AND TO_CHAR(LAST_PROC_DATE,'dd/mm/yyyy')"+ 		
										"=NVL('"+last_processed_date+"',TO_CHAR(message_date,'dd/mm/yyyy'))";
				} 

				if((flag==false) && (last_processed_date != null) && (!(last_processed_date.equals(""))))			
				{
					whereClause = whereClause + " TO_CHAR(LAST_PROC_DATE,'dd/mm/yyyy')"+ 		
										"=NVL('"+last_processed_date+"',TO_CHAR(message_date,'dd/mm/yyyy'))";
					flag=true;
				} 

				//not_required_reason
				if((flag==true) && (not_req_rsn != null) && (!(not_req_rsn.equals(""))))			
				{
					whereClause = whereClause +" AND   NOT_REQ_REASON= NVL('"+not_req_rsn+"'"+ 		 	
										",NOT_REQ_REASON)";
				} 

				if((flag==false) && (not_req_rsn != null) && (!(not_req_rsn.equals(""))))			
				{
					whereClause = whereClause +" NOT_REQ_REASON= NVL('"+not_req_rsn+"'"+ 		 	
										",NOT_REQ_REASON) ";
					flag=true;
				}  

				//addid   
				if((flag==true) && (addid != null) && (!(addid.equals(""))))			
				{
					whereClause = whereClause +" AND (ADDED_BY_ID= NVL('"+addid+"',ADDED_BY_ID))";
				} 

				if((flag==false) && (addid != null) && (!(addid.equals(""))))			
				{
					whereClause = whereClause +" (ADDED_BY_ID= NVL('"+addid+"',ADDED_BY_ID))"; 		 	
					flag=true;
				}  

				//addeddate
				if((flag==true) && (addeddate != null) && (!(addeddate.equals(""))))			
				{
					whereClause = whereClause +" AND  TO_CHAR(ADDED_DATE,'dd/mm/yyyy')"+ 	
										"=NVL('"+addeddate+"',TO_CHAR(ADDED_DATE,'dd/mm/yyyy'))";
				} 

				if((flag==false) && (addeddate != null) && (!(addeddate.equals(""))))			
				{
					whereClause = whereClause +" TO_CHAR(ADDED_DATE,'dd/mm/yyyy') =NVL('"+addeddate+"e',TO_CHAR(ADDED_DATE,'dd/mm/yyyy'))"; 		 	
					flag=true;
				}  

				//addedwsno
				if((flag==true) && (addedwsno != null) && (!(addedwsno.equals(""))))			
				{
					whereClause = whereClause +" AND ADDED_AT_WS_NO"+ 			         
										"=NVL('"+addedwsno+"',ADDED_AT_WS_NO)";
				} 

				if((flag==false) && (addedwsno != null) && (!(addedwsno.equals(""))))			
				{
					whereClause = whereClause +" ADDED_AT_WS_NO"+
											"=NVL('"+addedwsno+"',ADDED_AT_WS_NO)";
					flag=true;
				}  

				//modfied id
				if((flag==true) && (modfid != null) && (!(modfid.equals(""))))			
				{
					whereClause =whereClause +" AND MODIFIED_BY_ID=NVL('"+modfid+"',MODIFIED_BY_ID)";
				} 
				if((flag==false) && (modfid != null) && (!(modfid.equals(""))))			
				{
					whereClause =whereClause +" MODIFIED_BY_ID=NVL('"+modfid+"',MODIFIED_BY_ID)";
					flag=true;
				}  
				//modifieddate
				if((flag==true) && (modifieddate != null) && (!(modifieddate.equals(""))))			
				{
					whereClause =whereClause +" AND TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy')"+ 
										"=NVL('"+modifieddate+"',TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy'))";
				} 
				if((flag==false) && (modifieddate != null) && (!(modifieddate.equals(""))))			
				{
					whereClause =whereClause +" TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy')"+ 
										"=NVL('"+modifieddate+"',TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy'))";
					flag=true;
				}  

				// modifiedwsno
				if((flag==true) && (modifiedwsno != null) && (!(modifiedwsno.equals(""))))			
				{
					whereClause =whereClause +" AND MODIFIED_AT_WS_NO"+ 
										"=NVL('"+modifiedwsno+"',MODIFIED_AT_WS_NO)";
				} 

				if((flag==false) && (modifiedwsno != null) && (!(modifiedwsno.equals(""))))			
				{
					whereClause =whereClause +"  MODIFIED_AT_WS_NO=NVL('"+modifiedwsno+"',MODIFIED_AT_WS_NO)";
					flag=true;
				} 
				//External accession number From attribute
				if((flag==true) && (externalAccNoFrom != null) && (!(externalAccNoFrom.equals(""))))			
				{
					if((externalAccNoTo != null) && (!(externalAccNoTo.equals(""))))
					{
						whereClause = whereClause + " AND EXT_ACCESSION_NUM BETWEEN '"+externalAccNoFrom+"' AND '"+externalAccNoFrom+"'";
					}
					else
					{
						whereClause = whereClause + " AND EXT_ACCESSION_NUM >= '"+externalAccNoFrom+"'";
					}
				}
				if((flag == false) && (externalAccNoFrom != null) && (!externalAccNoFrom.equals("")) )
				{
					if((externalAccNoTo != null) && (!(externalAccNoTo.equals(""))))
					{
						whereClause = whereClause + " EXT_ACCESSION_NUM BETWEEN '"+externalAccNoFrom+"' AND '"+externalAccNoFrom+"'";
					}
					else
					{
						whereClause = whereClause + " EXT_ACCESSION_NUM >= '"+externalAccNoFrom+"'";
					}
					flag = true;
				}

				//External accession number To attribute
				if((flag==true) && (externalAccNoTo != null) && (!(externalAccNoTo.equals("")))
									&& ((externalAccNoFrom == null) || (externalAccNoFrom.equals(""))))			
				{
					whereClause = whereClause + " AND EXT_ACCESSION_NUM <= '"+externalAccNoTo+"'";		
				}
				if((flag == false) && (externalAccNoFrom != null) && (!externalAccNoFrom.equals(""))
									&& ((externalAccNoFrom == null) || (externalAccNoFrom.equals(""))))
				{
					whereClause = whereClause + " EXT_ACCESSION_NUM <= '"+externalAccNoFrom+"'";
					flag = true;
				}

				//Protocol link id
				if((flag==true) && (protocol_link_ID != null) && (!(protocol_link_ID.equals(""))))			
				{
					whereClause = whereClause + " AND PROTOCOL_LINK_ID='"+protocol_link_ID+"'";
				}
				if((flag == false) && (protocol_link_ID != null) && (!protocol_link_ID.equals("")) )
				{
					whereClause = whereClause + " PROTOCOL_LINK_ID='"+protocol_link_ID+"'";
					flag = true;
				}
				if(whereClause.length() <= 7)
				{
					whereClause = "";
				}

				else
				{
					whereClause = whereClause + " ORDER BY " + orderBy;
				}								
				
				if((order != null) && (order.equals("A")))
				{
					order="D";
				}
				else
				{
					order="A";
				}				

				// Constructing the table or view name to be used for querying records.
				if(purge_status != null && !purge_status.equals(""))
				{
					tableNameSuffix = sub_module + "_" + purge_status + "_APPL_MESSAGE_XL_VW";
				}
				else
				{
					tableNameSuffix = sub_module + "_EVENT_APPL_MESSAGE_XL_VW";
				}

				sqlQry = sqlQry + tableNameSuffix + whereClause;				

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

				cell.setCellValue("MESSAGE_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)5);

				cell.setCellValue("MESSAGE_DATE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)6);

				cell.setCellValue("MESSAGE_STATUS_DESC");
				cell.setCellStyle(cs);
				cell = row.createCell((short)7);

				cell.setCellValue("MESSAGE_STATUS");
				cell.setCellStyle(cs);
				cell = row.createCell((short)8);

				cell.setCellValue("ADDED_BY_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)9);

				cell.setCellValue("ADDED_DATE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)10);

				cell.setCellValue("MODIFIED_BY_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)11);

				cell.setCellValue("MODIFIED_DATE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)12);

				cell.setCellValue("ADDED_AT_WS_NO");
				cell.setCellStyle(cs);
				cell = row.createCell((short)13);

				cell.setCellValue("ADDED_FACILITY_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)14);

				cell.setCellValue("MODIFIED_FACILITY_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)15);

				cell.setCellValue("MODIFIED_AT_WS_NO");
				cell.setCellStyle(cs);
				cell = row.createCell((short)16);

				cell.setCellValue("PATIENT_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)17);

				cell.setCellValue("MERGED_PATIENT_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)18);

				cell.setCellValue("EPISODE_TYPE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)19);

				cell.setCellValue("EPISODE_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)20);

				cell.setCellValue("VISIT_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)21);

				cell.setCellValue("ACCESSION_NUM");
				cell.setCellStyle(cs);
				cell = row.createCell((short)22);

				cell.setCellValue("ACTION_TYPE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)23);

				cell.setCellValue("LAST_PROC_DATE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)24);

				cell.setCellValue("EVENT_STATUS");
				cell.setCellStyle(cs);
				cell = row.createCell((short)25);

				cell.setCellValue("NOT_REQ_REASON");
				cell.setCellStyle(cs);
				cell = row.createCell((short)26);

				cell.setCellValue("EXT_ACCESSION_NUM");
				cell.setCellStyle(cs);
				cell = row.createCell((short)27);

				cell.setCellValue("EVENT_TYPE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)28);

				cell.setCellValue("PROTOCOL_LINK_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)29);

				cell.setCellValue("OUTBOUND_COMM_MODE");
				cell.setCellStyle(cs);
				cell = row.createCell((short)30);

				cell.setCellValue("SOLICITED_YN");
				cell.setCellStyle(cs);
				cell = row.createCell((short)31);

				cell.setCellValue("ERR_MSG");
				cell.setCellStyle(cs);
				cell = row.createCell((short)32);

				cell.setCellValue("SYS_DEF_MESSAGE_TEXT");
				cell.setCellStyle(cs);
				cell = row.createCell((short)33);

				cell.setCellValue("MESSAGE_TEXT");
				cell.setCellStyle(cs);
				cell = row.createCell((short)34);

				cell.setCellValue("MESSAGE_LENGTH");
				cell.setCellStyle(cs);
				cell = row.createCell((short)35);

				cell.setCellValue("LAST_COMM_START_TIME");
				cell.setCellStyle(cs);
				cell = row.createCell((short)36);

				cell.setCellValue("LAST_COMM_END_TIME");
				cell.setCellStyle(cs);
				cell = row.createCell((short)37);

				cell.setCellValue("LAST_COMM_RETRIES");
				cell.setCellStyle(cs);
				cell = row.createCell((short)38);

				cell.setCellValue("QUERY_ID");
				cell.setCellStyle(cs);
				cell = row.createCell((short)39);

				cell.setCellValue("STATUS_TEXT");
				cell.setCellStyle(cs);
				cell = row.createCell((short)40);

				cell.setCellValue("OUTBOUND_FILE_NAME");
				cell.setCellStyle(cs);
				
				int rowCount = 1;
				while(rs.next())
				{				
					row = sheet.createRow((short)rowCount++);
					row.createCell((short)0).setCellValue(rs.getString("APPLICATION_ID"));
					row.createCell((short)1).setCellValue(rs.getString("APPLICATION_NAME"));
					row.createCell((short)2).setCellValue(rs.getString("FACILITY_ID"));
					row.createCell((short)3).setCellValue(rs.getString("FACILITY_NAME"));
					row.createCell((short)4).setCellValue(rs.getString("MESSAGE_ID"));
					row.createCell((short)5).setCellValue(rs.getString("MESSAGE_DATE"));
					row.createCell((short)6).setCellValue(rs.getString("MESSAGE_STATUS_DESC"));										
					row.createCell((short)7).setCellValue(rs.getString("MESSAGE_STATUS"));									
					row.createCell((short)8).setCellValue(rs.getString("ADDED_BY_ID"));					
					row.createCell((short)9).setCellValue(rs.getString("ADDED_DATE"));
					row.createCell((short)10).setCellValue(rs.getString("MODIFIED_BY_ID"));
					row.createCell((short)11).setCellValue(rs.getString("MODIFIED_DATE"));
					row.createCell((short)12).setCellValue(rs.getString("ADDED_AT_WS_NO"));
					row.createCell((short)13).setCellValue(rs.getString("ADDED_FACILITY_ID"));
					row.createCell((short)14).setCellValue(rs.getString("MODIFIED_FACILITY_ID"));
					row.createCell((short)15).setCellValue(rs.getString("MODIFIED_AT_WS_NO"));
					row.createCell((short)16).setCellValue(rs.getString("PATIENT_ID"));
					row.createCell((short)17).setCellValue(rs.getString("MERGED_PATIENT_ID"));
					row.createCell((short)18).setCellValue(rs.getString("EPISODE_TYPE"));
					row.createCell((short)19).setCellValue(rs.getString("EPISODE_ID"));
					row.createCell((short)20).setCellValue(rs.getString("VISIT_ID"));
					row.createCell((short)21).setCellValue(rs.getString("ACCESSION_NUM"));
					row.createCell((short)22).setCellValue(rs.getString("ACTION_TYPE"));
					row.createCell((short)23).setCellValue(rs.getString("LAST_PROC_DATE"));
					row.createCell((short)24).setCellValue(rs.getString("EVENT_STATUS"));
					row.createCell((short)25).setCellValue(rs.getString("NOT_REQ_REASON"));
					row.createCell((short)26).setCellValue(rs.getString("EXT_ACCESSION_NUM"));
					row.createCell((short)27).setCellValue(rs.getString("EVENT_TYPE"));										
					row.createCell((short)28).setCellValue(rs.getString("PROTOCOL_LINK_ID"));				
					row.createCell((short)29).setCellValue(rs.getString("OUTBOUND_COMM_MODE"));
					row.createCell((short)30).setCellValue(rs.getString("SOLICITED_YN"));
					row.createCell((short)31).setCellValue(rs.getString("ERR_MSG"));
					row.createCell((short)32).setCellValue(rs.getString("SYS_DEF_MESSAGE_TEXT"));
					row.createCell((short)33).setCellValue(rs.getString("MESSAGE_TEXT"));
					row.createCell((short)34).setCellValue(rs.getString("MESSAGE_LENGTH"));
					row.createCell((short)35).setCellValue(rs.getString("LAST_COMM_START_TIME"));
					row.createCell((short)36).setCellValue(rs.getString("LAST_COMM_END_TIME"));
					row.createCell((short)37).setCellValue(rs.getString("LAST_COMM_RETRIES"));
					row.createCell((short)38).setCellValue(rs.getString("QUERY_ID"));
					row.createCell((short)39).setCellValue(rs.getString("STATUS_TEXT"));
					row.createCell((short)40).setCellValue(rs.getString("OUTBOUND_FILE_NAME"));
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
				System.out.println("(GenerateOutboundEventsToXLServlet:Query) "+sqlQry);
				exp.printStackTrace(System.err);
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

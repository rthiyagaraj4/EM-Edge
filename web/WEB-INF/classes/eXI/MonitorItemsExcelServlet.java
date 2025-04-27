/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXI;
 
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
public class MonitorItemsExcelServlet extends HttpServlet
{ 
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{		
		try
		{
			HttpSession session = request.getSession(false);
			Properties p = (Properties) session.getValue("jdbc");
			String locale = p.getProperty("LOCALE");
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("SAP Monitoring");			

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
			String tableName = null;
			String functionID = null;
			String queueType = null;
			String dateFrom = "";
			String dateTo = "";

			try
			{
				MonitorItemsBean monitorItemsBean = new MonitorItemsBean();

				dateFrom = XHDBAdapter.checkNull(request.getParameter("dateFrom"));
				dateTo = XHDBAdapter.checkNull(request.getParameter("dateTo"));
				functionID = XHDBAdapter.checkNull(request.getParameter("functionID"));
				queueType = XHDBAdapter.checkNull(request.getParameter("queueType"));
				tableName = monitorItemsBean.getFuncTableName(functionID, queueType);

				String whrClause = "";
				String temp = "";
				StringBuilder whrClauseBuilder = new StringBuilder();
				boolean isCriteriaAdded = false;
				int rowCount = 1;

				ArrayList<String> tableIndColList = (ArrayList)MonitorItemsBean.getIndexColList(functionID, p);
				ArrayList<String> tabColumnList = (ArrayList)MonitorItemsBean.getTabColList(tableName, p);

				if(tableIndColList != null && (tableIndColList.size() > 0))
				{
					for(String colName: tableIndColList)
					{
						temp = XHDBAdapter.checkNull(request.getParameter(colName));
						if(temp != null && !temp.equals(""))
						{
							if(isCriteriaAdded) whrClauseBuilder.append(" AND ");
							else whrClauseBuilder.append(" WHERE ");
							whrClauseBuilder.append(colName + " LIKE '" + temp + "%'");
							isCriteriaAdded = true;
						}
					}

					if(dateFrom != null & !dateFrom.equals(""))
					{
						if(isCriteriaAdded) whrClauseBuilder.append(" AND ");
						else whrClauseBuilder.append(" WHERE ");
						if(dateTo != null & !dateTo.equals(""))
						{
							whrClauseBuilder.append("TO_DATE(TO_CHAR(trx_date,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE('"+dateFrom+"','dd/mm/yyyy') AND TO_DATE('"+dateTo+"','dd/mm/yyyy')");
						}
						else
						{
							whrClauseBuilder.append("TO_DATE(TO_CHAR(trx_date,'dd/mm/yyyy'),'dd/mm/yyyy') >= TO_DATE('"+dateFrom+"','dd/mm/yyyy')");
						}
					}
					else if(dateTo != null & !dateTo.equals(""))
					{
						if(isCriteriaAdded) whrClauseBuilder.append(" AND ");
						else whrClauseBuilder.append(" WHERE ");
						whrClauseBuilder.append("TO_DATE(TO_CHAR(trx_date,'dd/mm/yyyy'),'dd/mm/yyyy') <= TO_DATE('"+dateTo+"','dd/mm/yyyy')");
					}

					whrClause = whrClauseBuilder.toString();				

					boolean tempIsIndCol = false;
					for(Iterator<String> it = tabColumnList.iterator(); it.hasNext(); )
					{
						String currentColName = it.next();
						for(String colName: tableIndColList)
						{
							if(currentColName.equals(colName))
							{
								it.remove();
								tempIsIndCol = true;
								break;
							}
						}
						if(tempIsIndCol)
						{
							tempIsIndCol = false;
							continue;
						}
					}

					sqlQry = "SELECT * FROM " + tableName + whrClause;					

					connection = ConnectionManager.getConnection();
					stmt = connection.createStatement();
					rs = stmt.executeQuery(sqlQry);

					row = sheet.createRow((short)0);
					HSSFCell cell = row.createCell((short)0);
					short i = 1;

					for(String colName: tableIndColList)
					{
						cell.setCellValue(colName);
						cell.setCellStyle(cs);
						cell = row.createCell(i++);
					}

					for(String colName: tabColumnList)
					{
						cell.setCellValue(colName);
						cell.setCellStyle(cs);
						cell = row.createCell(i++);
					}
														
					while(rs.next())
					{				
						i = 0;
						row = sheet.createRow((short)rowCount++);					

						for(String colName: tableIndColList)
						{
							row.createCell(i).setCellValue(rs.getString(colName));
							i++;
						}

						for(String colName: tabColumnList)
						{
							row.createCell(i).setCellValue(rs.getString(colName));
							i++;
						}
					}
					
					if(rowCount > 1)
					{
						response.setContentType("application/vnd.ms-excel");
						response.setHeader("Content-Disposition", "attachment; filename=SAP_Monitoring.xls");
						ServletOutputStream op = response.getOutputStream();

						wb.write(op);			
						op.flush();
						op.close();
					}
				}

				if(rowCount <= 1)
				{
					PrintWriter outStream = response.getWriter();
					MessageManager messageManager = new MessageManager();					
					final java.util.Hashtable msgList = messageManager.getMessage(locale, "XH1021", "XH") ;
					String message = ((String) msgList.get("message"));
					outStream.println("<script>alert('"+message+"');</script>");
					msgList.clear();
				}
			}
			catch(Exception exp)
			{
				System.out.println("Exception : "+exp);
				System.out.println("(GenerateOutboundEventsToXLServlet:Query) "+sqlQry);
				System.out.println("(GenerateOutboundEventsToXLServlet:functionID) "+functionID);
				System.out.println("(GenerateOutboundEventsToXLServlet:queueType) "+queueType);
				exp.printStackTrace(System.err);
			}
			finally
			{
				try
				{
					XHUtil.closeDBResources(rs, stmt, connection);
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

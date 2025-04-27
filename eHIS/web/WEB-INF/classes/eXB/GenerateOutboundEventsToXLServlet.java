/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXB;
 
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
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
			HttpSession session = request.getSession(false);
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=OutboundEvents.xls");

			
		//	Properties p = (Properties) session.getValue("jdbc");	
		//	String locale  = p.getProperty("LOCALE");										
			 ArrayList rec = null;
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
			Pattern Regex=null;
			try
			{
				//	String msg_date = XBDBAdapter.checkNull(request.getParameter("msg_date"));
				String eventtype = XBDBAdapter.checkNull(request.getParameter("eventtype"));
				//	String pmode = XBDBAdapter.checkNull(request.getParameter("pmode"));
				String QryCols = java.net.URLDecoder.decode(XBDBAdapter.checkNull(request.getParameter("QryCols")));	
//					System.out.println("GenerateOutboundEventsToXLServlet.java QryCols : "+QryCols);
				String DataLinestr = java.net.URLDecoder.decode(XBDBAdapter.checkNull(request.getParameter("DataLinestr")));	
//					System.out.println("GenerateOutboundEventsToXLServlet.java DataLinestr : "+DataLinestr);
				String whereClause = java.net.URLDecoder.decode(XBDBAdapter.checkNull(request.getParameter("whereClause")));	
//					System.out.println("GenerateOutboundEventsToXLServlet.java whereClause : "+whereClause);						
				String orderBy = XBDBAdapter.checkNull(request.getParameter("orderBy"));	
//					System.out.println("GenerateOutboundEventsToXLServlet.java orderBy : "+orderBy);					
				String msgIdsList = XBDBAdapter.checkNull(request.getParameter("msgIdsList"));	
				if(msgIdsList.equals(""))
				{
					msgIdsList="";

				}
				else
				{
					msgIdsList=msgIdsList+",";
				}
				 System.out.println(" GenerateOutboundEventsToXLServlet msgIdsList : "+msgIdsList);		 			
				try{
					 Regex = Pattern.compile("\\,",Pattern.MULTILINE);
			//						System.out.println("ViewEventseBillDtlsResultPage.jsp Regex :"+Regex);
					}
				catch(Exception e){
					System.out.println("GenerateOutboundEventsToXLServlet.java erorr"+e);
					}	

//				sqlQry = "Select "+QryCols+" FROM XB_EVENT_APPL_MESSAGE_XL_VW WHERE EVENT_TYPE = NVL('"+eventtype+"',EVENT_TYPE)  "+whereClause+"  ORDER BY "+orderBy; 		 

				

				

				connection = ConnectionManager.getConnection();

			//	request.setAttribute("action_attr","R");
		XHElectronicBillsControllerBean xhBean=XHElectronicBillsControllerBean.getBean(XHElectronicBillsControllerBean.strBeanName,request,session);
        xhBean.action(request,connection);	    
		TreeMap tm=xhBean.treempselect;   
		  ArrayList b1=new ArrayList();     
		Set set = tm.entrySet(); 
		Iterator it = set.iterator(); 
		Map.Entry me = null;
		while(it.hasNext()) { 
					me = (Map.Entry)it.next(); 		    	 
				    b1.add(me.getValue());
			}   			    
												 
					  String mesglist="";

					for(int K=0;K<b1.size();K++)
					{
							rec = (ArrayList)b1.get(K); 


						mesglist=mesglist+"'"+rec.get(3)+"'"+",";	 
					}
					
					b1.clear();
					me = null;

				   mesglist=msgIdsList+mesglist;
				   mesglist=mesglist.substring(0,(mesglist.length()-1));
				  System.out.println(" GenerateOutboundEventsToXLServlet mesglist : "+mesglist);

				   sqlQry = "Select "+QryCols+" FROM XB_EVENT_APPL_MESSAGE_XL_VW WHERE EVENT_TYPE = NVL('"+eventtype+"',EVENT_TYPE)  "+whereClause+" AND MESSAGE_ID IN ("+mesglist+")"+"  ORDER BY "+orderBy; 
			      System.out.println(" GenerateOutboundEventsToXLServlet sqlQry : "+sqlQry);
				stmt = connection.createStatement();
				rs = stmt.executeQuery(sqlQry);

				row = sheet.createRow((short)0);
				HSSFCell cell = row.createCell((short)0);
				
			//	row.setRowStyle(cs);

				String[] array=Regex.split(DataLinestr);
			
				for(int i=0,j=1;i<array.length;i++,j++)
				{
					cell.setCellValue(array[i]);
					cell.setCellStyle(cs);
					cell = row.createCell((short)j);
				}
			
				int rowCount = 1;
				String ColName = "";
				while(rs.next())
				{				
					row = sheet.createRow((short)rowCount++);
					for(int i=0;i<array.length;i++)
					{
//						System.out.println("i , array[i]  : "+i+" " +array[i]);
						ColName = array[i].trim();
//						System.out.println("rs.getString(ColName) : "+rs.getString(ColName));
						row.createCell((short)i).setCellValue(rs.getString(ColName));
					}		
				}		// End of rs.next();			 	
				
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

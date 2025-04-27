/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.Date.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.MessageManager;

//import java.net.URLEncoder;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class FlowSheetCompDetailServlet extends javax.servlet.http.HttpServlet
{
	
	private String getMessage(String locale, String messageId, String moduleId)
		{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
		}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
        out = res.getWriter();
		java.util.Properties p;
		Connection          con = null;
		PreparedStatement pstmt = null,pstmtDelete=null;
		String flow_sheet_id = "";
		String hist_rec_type = "";
		String event_code = "";
		String event_code_type = "";
		String facilityId		="";
		String client_ip_address	= "";
		String addedById			= "";
		String addedDate			= "";
		String addedAtWorkstation	= "";
		String addedFacilityId		= "";
		String modifiedById			= "";
		String modifiedAtWorkstation= "";
		int count = 0;
		HttpSession session;
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
		session = req.getSession(false);
		webbeans.eCommon.RecordSet recordSet = (webbeans.eCommon.RecordSet)session.getValue("FlowSheetBean");
		p = (Properties)session.getValue("jdbc") ;
		String locale		= (String) p.getProperty("LOCALE");
		facilityId = (String)session.getValue( "facility_id" ) ;

		client_ip_address = p.getProperty("client_ip_address");
	
		addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		addedDate = dateFormat.format( new java.util.Date() ) ;
			
		addedFacilityId		= (facilityId == null)?"":facilityId;  
		addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 
		
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;      
	try
	{

			con = ConnectionManager.getConnection(req);

			flow_sheet_id=(req.getParameter("flow_sheet_id")==null)?"":req.getParameter("flow_sheet_id");

					
			if(addedById == null)
			addedById="";

			if(addedDate == null)
			addedDate="";

			if(facilityId == null )
			facilityId="";

			if(addedFacilityId == null )
			addedFacilityId="";

			if(addedAtWorkstation == null)
			addedAtWorkstation="";

			if(modifiedById == null)
			modifiedById="";

			if(modifiedAtWorkstation == null || modifiedAtWorkstation.equals("null") )
			modifiedAtWorkstation="";
		
			pstmtDelete = con.prepareStatement("delete from ca_flow_sheet_item where FLOW_SHEET_ID=?");
			pstmtDelete.setString(1,flow_sheet_id);
			pstmtDelete.executeUpdate();
			if(pstmtDelete !=null) pstmtDelete.close();



			String insertsql = "insert into ca_flow_sheet_item (FLOW_SHEET_ID,HIST_REC_TYPE,EVENT_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO,ORDER_SEQ_NO,EVENT_CODE_TYPE) values (?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?)";
			
			pstmt = con.prepareStatement(insertsql);
			int cnt = 0;
			//record = (ArrayList)FlowSheetRecord.getAllRecord();
			String code="";
			//String desc="";
			
			count=recordSet.getSize();
			
			int srlno=1;
			
			for(int k =0;k<count;k+=2)
			{
							                   
					code = (String)recordSet.getObject(k+1).toString();
					StringTokenizer st1 = new StringTokenizer(code,"|");
					while(st1.hasMoreTokens())
					{
						
						
						hist_rec_type	=st1.nextToken();
						event_code		=st1.nextToken();
						st1.nextToken();			
                        event_code_type = st1.nextToken();

						
						
						pstmt.setString (1,flow_sheet_id);
						pstmt.setString (2,hist_rec_type);
						pstmt.setString (3,event_code);
						pstmt.setString (4,addedById);
						pstmt.setString (5,addedFacilityId);
						pstmt.setString (6,addedAtWorkstation);
						pstmt.setString (7,modifiedById);
						pstmt.setString (8,addedFacilityId);
						pstmt.setString (9,modifiedAtWorkstation);
						pstmt.setInt(10,srlno);
						pstmt.setString (11,event_code_type);
						
						pstmt.addBatch();
						cnt++;
						
					}
					
			srlno++;	
			}
			int [] nUpdcount = pstmt.executeBatch();

			boolean flag=true;	
			String error_value	= "0" ;
			String error		= getMessage(locale, "FAILED_TRANSACTION","CA");
			if(nUpdcount.length == -3 || nUpdcount.length < cnt)
				{
					flag = false;
					con.rollback();		
				}
			else
				{
					con.commit();
					error_value = "1" ;
					error		 = getMessage(locale, "RECORD_INSERTED","CA");
				}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );
					
}

	catch ( Exception e )
	{
		try{
				con.rollback();
			}catch(Exception ex){
			
			}
		//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
		e.printStackTrace();
	}
									
	

	finally
		{
			try{
				
						if(pstmt!=null) 
						pstmt.close();
						if(con!=null)ConnectionManager.returnConnection(con, req);
			    
				}
			catch(Exception ei)
			{ 
				//out.println(ei.toString()); common-icn-0181
				ei.printStackTrace();
			}
		}
	}
}




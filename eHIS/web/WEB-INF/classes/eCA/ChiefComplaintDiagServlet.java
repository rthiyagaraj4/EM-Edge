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
import java.io.IOException;
import java.io.PrintWriter;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;


public class ChiefComplaintDiagServlet extends javax.servlet.http.HttpServlet 
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");	
		PrintWriter out = null;
        out = res.getWriter();
		java.util.Properties p;
		RecordDiagnosis Record;
		Connection          con = null;
		PreparedStatement pstmt = null,pstmtDelete=null;

		String facilityId		="";
		String client_ip_address	= "";
		String addedById			= "";
		String addedDate			= "";
		String addedAtWorkstation	= "";
		String addedFacilityId		= "";
		String modifiedById			= "";
		String modifiedAtWorkstation= "";
		String complaint_id = "";
		String term_set_id = "";
		String term_code = "";
		
		//String key="";
		int count=0;
		String error_value	= "" ;
		String error		= "";
		ArrayList record = new ArrayList();

		boolean bCommitFlag = true;
		
		HttpSession session;
		session			= req.getSession(false);
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
		
		p					= (Properties) session.getValue("jdbc") ;
		String locale		= (String) p.getProperty("LOCALE");
		facilityId			= (String) session.getValue("facility_id") ;
		client_ip_address	= (String) p.getProperty("client_ip_address");
		addedById			= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		
		Record				= (RecordDiagnosis)session.getValue("RecordDiagnosisBeannew");

		addedDate			= dateFormat.format( new java.util.Date() ) ;
		addedFacilityId		= (facilityId == null)?"":facilityId;  
		addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 

		modifiedById		= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;      

		try
		{
			con = ConnectionManager.getConnection(req);
			complaint_id = (req.getParameter("complaint_id")==null)?"":req.getParameter("complaint_id");
			term_set_id = (req.getParameter("term_set_id")==null)?"":req.getParameter("term_set_id");
			term_code = (req.getParameter("term_code")==null)?"":req.getParameter("term_code");

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

			if(modifiedAtWorkstation == null )
				modifiedAtWorkstation="";
		
			pstmtDelete = con.prepareStatement("delete from CA_CHIEF_COMP_TERM_CODE where COMPLAINT_ID=?");
			pstmtDelete.setString(1,complaint_id);
			pstmtDelete.executeUpdate();
			
			if(pstmtDelete !=null) 
				pstmtDelete.close();
		
			String insertsql = "insert into CA_CHIEF_COMP_TERM_CODE (COMPLAINT_ID,TERM_SET_ID,TERM_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
		
			pstmt	=	con.prepareStatement(insertsql);
			
			record = (ArrayList)Record.getAllRecord();
			String recordval = "",description="",code="",termset_desc = "";
			count=record.size();

			for(int k=0;k<count;k++)
			{
				recordval =(String)record.get(k);

				StringTokenizer st = new StringTokenizer(recordval,"~");

				while(st.hasMoreTokens())
				{
					term_set_id         = st.nextToken();
					term_code           = st.nextToken();
					description         = st.nextToken();
					code                = st.nextToken();
					termset_desc        = st.nextToken();
					

					pstmt.setString	(1,complaint_id);
					pstmt.setString	(2,code);
					pstmt.setString	(3,term_set_id);
					pstmt.setString	(4,addedById);
					pstmt.setString	(5,addedAtWorkstation);
					pstmt.setString	(6,addedFacilityId);
					pstmt.setString	(7,modifiedById);
					pstmt.setString	(8,modifiedAtWorkstation);
					pstmt.setString	(9,addedFacilityId);
					pstmt.addBatch();
				}
			}	
	       
			int [] nUpdCount = pstmt.executeBatch();			

			if(nUpdCount.length == -3 || nUpdCount.length < count)
				bCommitFlag = false;

			if(bCommitFlag)
			{
				con.commit();
				error_value = "1" ;
				error = getMessage(locale, "RECORD_INSERTED","CA");
			}
			else
			{
				con.rollback();					
				error_value	= "0" ;
			    error = getMessage(locale, "FAILED_TRANSACTION","CA");
			}	
			
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pstmt!=null) 
					pstmt.close();
			
				if(con != null) ConnectionManager.returnConnection(con, req);
			}
			
			catch(Exception ei){
				//out.println(ei.toString()); //common-icn-0181
				ei.printStackTrace();//COMMON-ICN-0181
				}
		}
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
}

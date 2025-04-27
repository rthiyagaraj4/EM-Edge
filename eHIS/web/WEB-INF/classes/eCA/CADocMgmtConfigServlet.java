 /*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	?				?					created
19/03/2020 	IN070345  		Ramesh Goli											MO-CRF-20147.1	
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;


public class CADocMgmtConfigServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
req= new XSSRequestWrapper(req); //MOHE-SCF-0153
res.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
res.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		PrintWriter out = null;

		try
		{
			out = res.getWriter();
			insertDocMgmtConfigDetails(req, res, out);
		}
		catch(Exception e)
		{
			out.println("Exception in Main Block : "+e.toString());
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req, res);

			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/ecis.css'></link> <script src='../../eCommon/js/common.js' language='javascript'></script> <script language='javascript' src='../eMP/js/ActiveInactive.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");

		} catch(Exception e){	
		}
	}

	private void insertDocMgmtConfigDetails(HttpServletRequest req, HttpServletResponse res, PrintWriter out)	{

		java.util.Properties p;
		String facilityId				= "" ;
		String errorMsg					= "";
		String error_value				= "";
		String client_ip_address		= "";
		String addedById				= "";
		String modifiedById				= "";
		String addedAtWorkstation		= "";
		String modifiedAtWorkstation	= "";
		Connection con				= null;
		PreparedStatement pstmt		= null;
		
		HttpSession session			= req.getSession(false);

		p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		
		client_ip_address	= p.getProperty("client_ip_address");
		String locale 					= (String) p.getProperty("LOCALE");
		facilityId			= (String) session.getValue( "facility_id" ) ;
		addedById 			= p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
		addedAtWorkstation 	= client_ip_address != null ? client_ip_address : "";
		modifiedById		= p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
		modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
	
		System.out.println("		facilityId------------------>"+facilityId);
		System.out.println("		addedById------------------>"+addedById);
		System.out.println("		addedAtWorkstation------------------>"+addedAtWorkstation);
		System.out.println("		modifiedById------------------>"+modifiedById);
		System.out.println("		modifiedAtWorkstation------------------>"+modifiedAtWorkstation);
		
		int totalInsert=0;
		int totalDocuments = Integer.parseInt(req.getParameter("totaldocuments")==null?"0":(String)req.getParameter("totaldocuments"));
		String selectedFacilityId=req.getParameter("facilityId")==null?"0":(String)req.getParameter("facilityId");
		System.out.println("		totalDocuments------------------>"+totalDocuments);
		System.out.println("		selectedFacilityId------------------>"+selectedFacilityId);
		try
		{
			con = ConnectionManager.getConnection(req);
			
			pstmt = con.prepareStatement("DELETE  FROM CA_FUNCITON_DOC_CONFIG_DTL WHERE FACILITY_ID= ? ");
			pstmt.setString(1, selectedFacilityId);
			pstmt.executeUpdate(); 			
			if(pstmt!=null)pstmt.close();
			
			pstmt = con.prepareStatement("INSERT INTO CA_FUNCITON_DOC_CONFIG_DTL (FACILITY_ID, DOC_SUB_FUNCTION_ID, DOC_STORED_TYPE, DOC_STORED_PATH, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ");
			
			for(int i=0;i<totalDocuments;i++){
				String docSubFuncitonId = req.getParameter("docSubFuncitonId"+i)==null?"":(String)req.getParameter("docSubFuncitonId"+i);
				String docStoredType = req.getParameter("docStoredType"+i)==null?"D":(String)req.getParameter("docStoredType"+i);
				String docSharedPath = req.getParameter("docSharedPathValue"+i)==null?"":(String)req.getParameter("docSharedPathValue"+i);
				
				System.out.println("		docSubFuncitonId------------------>"+docSubFuncitonId);
				System.out.println("		docStoredType------------------>"+docStoredType);
				System.out.println("		docSharedPath------------------>"+docSharedPath);
				
				pstmt.setString(1, selectedFacilityId);
				pstmt.setString(2, docSubFuncitonId);
				pstmt.setString(3, docStoredType);
				pstmt.setString(4, docSharedPath);
				pstmt.setString(5, addedById);
				pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
				pstmt.setString(7, facilityId);
				pstmt.setString(8, addedAtWorkstation);
				pstmt.setString(9, modifiedById);
				pstmt.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
				pstmt.setString(11, facilityId);
				pstmt.setString(12, modifiedAtWorkstation);
				
				totalInsert=totalInsert+pstmt.executeUpdate();
				System.out.println("			----------------------->"+totalInsert);
			}
			System.out.println(totalInsert+"<----------------------->"+totalDocuments);
			
			//int[] totalInsert= pstmt.executeBatch();
			
			if(totalInsert == totalDocuments){
				errorMsg=getMessage(locale, "RECORD_INSERTED","CA");
				error_value = "1" ;
				con.commit();
			}else{			
				errorMsg = getMessage(locale, "FAILED_OPERATION","CA");			
				error_value = "0" ;
				con.rollback();
			}
			
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg ,"UTF-8") + "&err_value=" + error_value );
		}
		catch ( Exception e )
		{
			//out.println("Exception occured at Insert Block  : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex){
				ex.printStackTrace();
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

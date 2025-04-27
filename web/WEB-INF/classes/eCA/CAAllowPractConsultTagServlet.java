/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date           	Edit History    	Name        		Rev.Date		Rev.Name		         Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
10/04/2024  50627    Twinkle Shah    10/04/2024		Ramesh Goli        ML-MMOH-CRF-2106
14/06/2024    62519   Krishna Pranay     20/06/2024     Ramesh Goli      COMMON-ICN-0289
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import webbeans.eCommon.*;


public class CAAllowPractConsultTagServlet extends javax.servlet.http.HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private String addedAtWorkstation;   //62519  


	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{		
		PrintWriter out = null;
		try
		{	req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			out = res.getWriter();
			insert(req, res, out);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}
	
	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		HttpSession session;
		session = req.getSession(false);
		
		java.util.Properties p;
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String facilityId = (String) session.getValue( "facility_id" ) ;
		String addedByWsNo = p.getProperty("client_ip_address");
		String addedById			= p.getProperty( "login_user" ) ;
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		ResultSet rs= null;
		
		int selectedRecCount =0;		
		int[] arr = null;
		int totalRecCount =0;
		 int delRecord=0;
		String totalRecord =req.getParameter("totalRecord");
		try
		{
			con=ConnectionManager.getConnection(req);
			if(!"".equals(totalRecord) )
				totalRecCount= Integer.parseInt(totalRecord);			
		    for(int i=0;i<totalRecCount;i++){
		    	
			String pract_consult_tag_yn =req.getParameter("pract_consult_tag_yn"+i)==null?"N":req.getParameter("pract_consult_tag_yn"+i);
			String 	exist_pract_tag_yn =req.getParameter("exist_pract_tag_yn"+i)==null?"N":req.getParameter("exist_pract_tag_yn"+i);
			
			if("Y".equals(pract_consult_tag_yn) || "Y".equals(exist_pract_tag_yn) || ("Y".equals(exist_pract_tag_yn) && "N".equals(pract_consult_tag_yn))){
			pstmt  = con.prepareStatement("DELETE FROM CA_PRACT_CONSULTA_TAG WHERE PRACT_TYPE=?");
			pstmt.setString(1, ((String)req.getParameter("pract_type"+i)));
			delRecord=pstmt.executeUpdate();
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
			}
		    }
			pstmt1 = con.prepareStatement("INSERT INTO CA_PRACT_CONSULTA_TAG(PRACT_TYPE,PRACT_CONSULT_TAG_YN ,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES ( ?,?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)");		
	         
			for(int i=0;i<totalRecCount;i++){	
			 String pract_consult_tag_yn=req.getParameter("pract_consult_tag_yn"+i)==null?"N":(String)req.getParameter("pract_consult_tag_yn"+i);
				if("Y".equals(pract_consult_tag_yn)){
				pstmt1.setString(1, ((String)req.getParameter("pract_type"+i)));
				pstmt1.setString(2, pract_consult_tag_yn);
				pstmt1.setString(3, addedById);
    			pstmt1.setString(4, addedByWsNo);
    			pstmt1.setString(5, facilityId);
    			pstmt1.setString(6, addedById);
    			pstmt1.setString(7, addedByWsNo);
    			pstmt1.setString(8, facilityId); 
		        pstmt1.addBatch();
	    	    selectedRecCount++;		
			}
			}
			if(selectedRecCount>0){
   			 arr = pstmt1.executeBatch();
			}
			if(pstmt1!=null)pstmt1.close();
			
			if(delRecord >0 || selectedRecCount >0)
			{
			con.commit();	
			String error = getMessage(locale, "RECORD_INSERTED","CA") ;	
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value=1");
			}
			else
			{
				con.rollback();
				String error = getMessage(locale, "NO_CHANGE_TO_SAVE","Common") ;	
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value=0");
			}
			
		}
		catch ( Exception e ){
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();		
		    String error = getMessage(locale, "FAILED_TRANSACTION","CA") ;
			out.println(error);
		}finally{
			try{
				if(con!=null) ConnectionManager.returnConnection(con,req);		
			}catch(Exception e){}
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

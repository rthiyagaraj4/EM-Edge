/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date           	Edit History    	Name        		Rev.Date		Rev.Name		         Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
16/05/2022     29147      krishna pranay       17/05/2023     Ramesh Goli              MO-CRF-20183

----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eOR;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import webbeans.eCommon.*;


public class RestrictPlacingOrderServlet extends javax.servlet.http.HttpServlet
{
	private String addedAtWorkstation;


	public void init(ServletConfig config) throws ServletException
	{
		System.out.println("Enter into init method");
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		System.out.println("Enter into post post");
		
		PrintWriter out = null;
		try
		{	req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			out = res.getWriter();
			
			insert(req, res, out);
		
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}
	
	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
	System.out.println("Enter into get method");
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}
	
	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		System.out.println("entered insert method ########");
		HttpSession session;
		session = req.getSession(false);
		
		java.util.Properties p;
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String facilityId = (String) session.getValue( "facility_id" ) ;
		String addedByWsNo = p.getProperty("client_ip_address");
		String addedById			= p.getProperty( "login_user" ) ;
		String modifiedById			= addedById ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= facilityId ;
		String modifiedAtWorkstation = addedAtWorkstation ;
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		ResultSet rs= null;
		
		int selectedRecCount =0;		
		int[] arr = null;
		int totalRecCount =0;
		 
		String totalRecord =req.getParameter("totalRecord");
		
		try
		{
			con=ConnectionManager.getConnection(req);
			if(!"".equals(totalRecord) )
				totalRecCount= Integer.parseInt(totalRecord);
		for(int i=0;i<totalRecCount;i++){
			String order_category  =((String)req.getParameter("order_category"+i));		
			pstmt  = con.prepareStatement(" DELETE FROM OR_ORDER_REST_SLF_FAMI_MEMB WHERE ORDER_CATEGORY=?   ");
			pstmt.setString(1, ((String)req.getParameter("order_category"+i)));
			int countDelRec = pstmt.executeUpdate();

			if(pstmt!=null)
				pstmt.close();
			System.out.println("---------------------->114");
			pstmt  = con.prepareStatement(" SELECT NVL(MAX(ORDER_CATEGORY),0)+1 RCOUNT FROM OR_ORDER_REST_SLF_FAMI_MEMB WHERE ORDER_CATEGORY=?");
			pstmt.setString(1, ((String)req.getParameter("order_category"+i)));
			rs = pstmt.executeQuery();
			}
			if(rs!=null)
				rs.close();			    	
	    	if(pstmt!=null)
	    		pstmt.close();
	    	System.out.println("---------------------->126");
			pstmt1 = con.prepareStatement("INSERT INTO OR_ORDER_REST_SLF_FAMI_MEMB(ORDER_CATEGORY,REST_ORDER_SELF_YN,REST_ORDER_FAMILY_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES ( ?,?, ?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)");		
	          for(int i=0;i<totalRecCount;i++){	
			 String rest_order_self_yn=req.getParameter("rest_order_self_yn"+i)==null?"N":(String)req.getParameter("rest_order_self_yn"+i);
			  System.out.println("rest_order_self_yn------>"+rest_order_self_yn);
		     String rest_order_family_yn=req.getParameter("rest_order_family_yn"+i)==null?"N":(String)req.getParameter("rest_order_family_yn"+i);
			 System.out.println("rest_order_family_yn------>"+rest_order_family_yn);
				pstmt1.setString(1, ((String)req.getParameter("order_category"+i)));
				pstmt1.setString(2, rest_order_self_yn);
				pstmt1.setString(3, rest_order_family_yn);
				pstmt1.setString(4, addedById);
    			pstmt1.setString(5, addedByWsNo);
    			pstmt1.setString(6, facilityId);
    			pstmt1.setString(7, addedById);
    			pstmt1.setString(8, addedByWsNo);
    			pstmt1.setString(9, facilityId); 
		            pstmt1.addBatch();
	    			selectedRecCount++;		
			}
			if(selectedRecCount>0){
   			 arr = pstmt1.executeBatch();
			}
		
			if(pstmt1!=null)
				pstmt1.close();
					
				
			con.commit();			
			String error = getMessage(locale, "RECORD_INSERTED","CA") ;	
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value=1");
			
	
		}
		catch ( Exception e ){
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
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

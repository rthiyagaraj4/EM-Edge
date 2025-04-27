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
Date       	Edit History    	Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
18/08/2022	29035				Ramesh G											ML-MMOH-CRF-1763
09/10/2023     51003           Krishna Pranay    10/10/2023       Ramesh Goli        COMMON-ICN-0178
--------------------------------------------------------------------------------------------------------------
*/ 

package eCA;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;


public class MultiLocForPractServlet extends javax.servlet.http.HttpServlet
{
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
		
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		ResultSet rs= null;
		
		int srl_no = 1;
		int selectedRecCount =0;		
		int[] arr = null;
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");//51003
		
		
		try
		{
			con=ConnectionManager.getConnection(req);
			
			String practitionerId =req.getParameter("practitionerId");
			String locationType =req.getParameter("locationType");
			String totalRecord =req.getParameter("totalRecord"); 
			System.out.println("-------------practitionerId--------->"+practitionerId);
			System.out.println("-------------locationType--------->"+locationType);
			System.out.println("-------------totalRecord--------->"+totalRecord);
			int totalRecCount =0;
			if(!"".equals(totalRecord))
				totalRecCount= Integer.parseInt(totalRecord);
			
			pstmt  = con.prepareStatement(" DELETE FROM CA_PRACT_BY_LOCN WHERE PRACTITIONER_ID=?  AND FACILITY_ID=? AND LOCN_TYPE=? ");
			pstmt.setString(1, practitionerId);
			pstmt.setString(2, facilityId);
			pstmt.setString(3, locationType);
		//	int countDelRec = pstmt.executeUpdate();//51003
			 pstmt.executeUpdate();
			 
			if(pstmt!=null)
				pstmt.close();
			System.out.println("---------------------->114");
			pstmt  = con.prepareStatement(" SELECT NVL(MAX(SRL_NO),0)+1 RCOUNT FROM CA_PRACT_BY_LOCN WHERE PRACTITIONER_ID=?");
			pstmt.setString(1, practitionerId);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				srl_no=rs.getInt("RCOUNT");
			}
			System.out.println("---------------srl_no------->114------>"+srl_no);
			if(rs!=null)
				rs.close();			    	
	    	if(pstmt!=null)
	    		pstmt.close();
	    	System.out.println("---------------------->126");
			pstmt1 = con.prepareStatement("INSERT INTO CA_PRACT_BY_LOCN(PRACTITIONER_ID,SRL_NO,FACILITY_ID,LOCN_TYPE,LOCN_CODE,EFF_FROM_DATE,EFF_TO_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,sysdate,?,?,?,sysdate,?,?)");
    		
			for(int i=0;i<totalRecCount;i++){
				System.out.println("---------------------->"+req.getParameter("locCheck"+i));
				if("Y".equals((String)req.getParameter("locCheck"+i))){
					String effFromDate=req.getParameter("eff_from_date"+i)==null?"":(String)req.getParameter("eff_from_date"+i);
					String effToDate=req.getParameter("eff_to_date"+i)==null?"":(String)req.getParameter("eff_to_date"+i);
					
					System.out.println("----------------effFromDate--1--->"+effFromDate);
					System.out.println("---------------effToDate----2--->"+effToDate);
					
					if(!"".equals(effFromDate))
						effFromDate = com.ehis.util.DateUtils.convertDate(effFromDate,"DMY",locale,"en");

					System.out.println("---------------###############################----4--->");
					
					if(!"".equals(effToDate))
						effToDate = com.ehis.util.DateUtils.convertDate(effToDate,"DMY",locale,"en");
					
					System.out.println("----------------effFromDate--3--->"+effFromDate);
					System.out.println("---------------effToDate----4--->"+effToDate);
					
					pstmt1.setString(1, practitionerId);
	    			pstmt1.setInt(2, srl_no);
	    			pstmt1.setString(3, facilityId);
	    			pstmt1.setString(4, locationType);
	    			pstmt1.setString(5, ((String)req.getParameter("locCode"+i)));
	    			
	    			pstmt1.setString(6, effFromDate);
	    			pstmt1.setString(7, effToDate);
	    			pstmt1.setString(8, addedById);
	    			pstmt1.setString(9, addedByWsNo);
	    			pstmt1.setString(10, facilityId);
	    			pstmt1.setString(11, addedById);
	    			pstmt1.setString(12, addedByWsNo);
	    			pstmt1.setString(13, facilityId); 
	    			pstmt1.addBatch();
	    			srl_no++;
	    			selectedRecCount++;
				}				
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

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eQA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;


public class QAIndicatorsForDisciplineServlet extends javax.servlet.http.HttpServlet
{


	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config); 
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		
		String mode=req.getParameter("mode")==null?"":req.getParameter("mode");
		if(mode.equals("U"))
		{
			
		}
		else
		{
		try
		{HttpSession session = req.getSession(false);	
        
		Connection con=null;
		   
		java.util.Properties p = null;
		
		   
		con = ConnectionManager.getConnection(req); 
		   
		PreparedStatement delete_pstmt=null;
		   
		PreparedStatement insert_pstmt=null;
		   
        //java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
		   
		
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		   
		String client_ip_address = p.getProperty("client_ip_address");
		   
		
		String facility_id = (String)session.getValue("facility_id") ;
		String addedById			= p.getProperty( "login_user" ) ;
		String addedFacilityId		= facility_id ;
		String addedAtWorkstation	=client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;
		String dispid = req.getParameter("dispid")==null ? "" : req.getParameter("dispid");
        ResultSet rs=null;
 	    int serialNo=0;
        
		PreparedStatement select_pstmt=null;

		HashMap hash=(HashMap)session.getAttribute("hashIndicator");
         
		ArrayList arr =(ArrayList)session.getAttribute("arrayKeys");
		 
		String strKey = "";
		String strValue = "";
		int count = req.getParameter("n")==null ? 0 : Integer.parseInt(req.getParameter("n"));
		String removedValue = "";
          
		for (int index=0;index < count ;index ++)
		{
			if(hash != null)

			{
				strKey =( req.getParameter("strKey"+index)==null )? "" : req.getParameter("strKey"+index);
				
				if(!strKey.equals(""))
				{
					//if(!hash.containsKey(strKey))
				//	{
							
						strValue = (req.getParameter("strValue"+index)==null )? "" : req.getParameter("strValue"+index);
						hash.put(strKey,strValue);
						
				//	}
				}
			}
			removedValue = ( req.getParameter("removedValue"+index)==null )? "" : req.getParameter("removedValue"+index);
			if(hash != null)
			{
				if(!removedValue.equals(""))
				{
					if(hash.containsKey(removedValue))
					{
						hash.remove(removedValue);
					}
				}
			}

		}

		try
		{
		if(arr != null && hash != null)
		{
		String qind = "";
		for(int i=0;i<arr.size();i++)
			{
	     
		StringTokenizer subTkn= new StringTokenizer((String)arr.get(i),"~");
		while(subTkn.hasMoreTokens())
			{
			
			dispid=subTkn.nextToken();
			qind=subTkn.nextToken();
         
		delete_pstmt=con.prepareStatement("delete from QA_QIND_DISCIPLINE_CLIND where QIND_DISCIPLINE_ID= ? and QIND_CLIND_ID=?");
		delete_pstmt.setString(1,dispid);
		delete_pstmt.setString(2,qind);
		delete_pstmt.executeUpdate();
		con.commit();
		if (delete_pstmt != null) delete_pstmt.close();
		{
		}
		if(hash.get(arr.get(i))!=null)
		{
				select_pstmt=con.prepareStatement("select Max(QIND_SLNO) MXSLNO  from QA_QIND_DISCIPLINE_CLIND where   QIND_DISCIPLINE_ID=?");
				select_pstmt.setString(1,dispid);
				 rs=select_pstmt.executeQuery();

				rs.next();
				serialNo=rs.getInt("MXSLNO");
				if(rs!=null)rs.close();
				if(select_pstmt!=null)select_pstmt.close();
				
				insert_pstmt=con.prepareStatement("insert into QA_QIND_DISCIPLINE_CLIND (QIND_DISCIPLINE_ID,QIND_SLNO,QIND_CLIND_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");

				insert_pstmt.setString(1,dispid) ;
				insert_pstmt.setInt(2,serialNo+1);
				insert_pstmt.setString(3,qind);
				insert_pstmt.setString(4,addedById);
				insert_pstmt.setString(5,addedAtWorkstation);
				insert_pstmt.setString(6,addedFacilityId);
				insert_pstmt.setString(7,addedById);
				insert_pstmt.setString(8,modifiedAtWorkstation);
				insert_pstmt.setString(9,addedFacilityId);
				insert_pstmt.executeUpdate();
		 if (insert_pstmt != null) insert_pstmt.close();
		}

		
		}
			//do deletion
		
		
		
		}
	   	   }     
		
		session.removeAttribute("hashIndicator");
	    session.removeAttribute("arrayKeys");
		String error="APP-SM0001 Operation Completed Successfully ....";
		String error_value= "1";
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );  
		hash.clear();
		arr.clear();
		}
		catch(Exception e)
		{
			
		     String error="";
		      String error_value= "0";
			session.removeAttribute("hashIndicator");
	session.removeAttribute("arrayKeys");
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );  
		}
		finally
			{
			if(insert_pstmt!=null) insert_pstmt.close();
			if(delete_pstmt!=null) delete_pstmt.close();
			ConnectionManager.returnConnection(con,req);
			}
		
		
		
		}
		catch(Exception e)
		{
		     String error="";
		      String error_value= "0";
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );  
		}
		
		

		}		
		
}
}
		

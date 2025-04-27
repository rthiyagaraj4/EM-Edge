/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMO;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
//import eCommon.SingleTabHandler.*;

public class BlockBedServlet extends HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	String facilityId;
	HttpSession session;
	Properties p;
	String client_ip_address;
	
	String mode;
	String area_code;            
	String bed_no;        
	String blocked_until="";
	String  remarks="";
	String releasedata1="";
	String error_value="";
	Connection conn  = null;
    PreparedStatement pstmt=null;   
    ResultSet rs=null;   
	String locale="";
		//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	 public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
		try	{

			session 						= req.getSession(true);
			this.facilityId = (String) session.getValue( "facility_id" ) ;
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			conn = ConnectionManager.getConnection(p);

			locale = p.getProperty("LOCALE");

		    this.client_ip_address = p.getProperty("client_ip_address");
    		area_code 			=  req.getParameter("area_code");
			area_code 			= (area_code == null)?"":area_code;
			
			bed_no				=  req.getParameter("bed_no");
			bed_no				= (bed_no == null)?"":bed_no;
			
			remarks				=  req.getParameter("remarks");
			remarks				= (remarks == null)?"":remarks;
			
			blocked_until    	=  req.getParameter("blocked_until");
			blocked_until		= (blocked_until == null)?"":blocked_until;
            
            
			releasedata1		=  req.getParameter("releasedata1");
			releasedata1		= (releasedata1 == null)?"":releasedata1;
			

			blocked_until=DateUtils.convertDate(blocked_until,"DMYHM",locale,"en");

			mode 				=  req.getParameter("function");
			mode 				= (mode == null)?"":mode;
			if(mode.equalsIgnoreCase("blockbed"))
		     BlockBed(res);
            else
		     RevokeBed(res);

		}catch(Exception e){
						out.println(e.toString());
			}
	}

 private void  BlockBed(HttpServletResponse res){
  try{          int blockcount=0;
				String addedById			= p.getProperty( "login_user" ) ;
		//		String addedDate			= dateFormat.format( new java.util.Date() ) ;
				//String modifiedById			= addedById ;
				//String modifiedDate			= addedDate ;
				String addedFacilityId		= facilityId;
				String modifiedFacilityId	= addedFacilityId ;
				String addedAtWorkstation	=client_ip_address;
				String modifiedAtWorkstation= addedAtWorkstation ;
			//	java.sql.Date added_date1	= java.sql.Date.valueOf( addedDate ) ;
			//	java.sql.Date added_date	= new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			//	java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
			//	java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 
			
        pstmt=conn.prepareStatement("select count(*)cnt from mo_bed_for_area where area_code=? and bed_no=? and facility_id = ? and occupying_patient_id is null and (blocked_yn='N' OR (BLOCKED_YN='Y' AND BLOCKED_UPTO <= SYSDATE))");
		pstmt.setString(1,area_code);
		pstmt.setString(2,bed_no);
		pstmt.setString(3,facilityId);
		rs=pstmt.executeQuery();
		if(rs.next())
	    {
	    blockcount=rs.getInt("cnt");
	    }
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(blockcount==0)
		{conn.rollback();
		 java.util.Hashtable message = MessageManager.getMessage(locale,"VAC_BED_SEL","MO");
         res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode((String) message.get("message"),"UTF-8") + "&err_value=");
		 message.clear();
		}else
	  {
				
				pstmt=conn.prepareStatement("update mo_bed_for_area set BLOCKED_YN=?, BLOCKED_UPTO=to_date(?,'dd/mm/yyyy hh24:mi'), REASON_FOR_BLOCKING=?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where area_code=? and bed_no=? and facility_id = ?");
			
				pstmt.setString(1,"Y");
				pstmt.setString(2,blocked_until);
				pstmt.setString(3,remarks);
				pstmt.setString(4,addedById);
				pstmt.setString(5,modifiedAtWorkstation);
				pstmt.setString(6,modifiedFacilityId);
				pstmt.setString(7,area_code);
				pstmt.setString(8,bed_no);
				pstmt.setString(9,facilityId);
               int cnt=pstmt.executeUpdate();
			   String error_value="";
				if ( cnt>0)
				   {    
						conn.commit();
						
					    error_value= "1";
		         
 	    
				  java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;

				  res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode((String) message.get("message"),"UTF-8") + "&err_value=" + error_value );

				//  res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("APP-SM0002 Operation Completed Successfully ...." ) + "&err_value=" + error_value );
	        	   
				   }
		     	   else
		     	   {conn.rollback();
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("Error in Updation" ) + "&err_value=" + error_value );
		     	   }

		  
		     
	       if(pstmt!=null)pstmt.close();
	  
	  }
		   }catch ( Exception e )
      {
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      } try 
			{
				if (conn != null) 
					ConnectionManager.returnConnection(conn,p);
				
			}
			catch (Exception ee) 
			{
				ee.printStackTrace();
				
			}

  } // End of the insertParameter

 private void  RevokeBed(HttpServletResponse res){

  try{
        
				String addedById			= p.getProperty( "login_user" ) ;
			//	String addedDate			= dateFormat.format( new java.util.Date() ) ;
				//String modifiedById			= addedById ;
				//String modifiedDate			= addedDate ;
				String addedFacilityId		= facilityId;
				String modifiedFacilityId	= addedFacilityId ;
				String addedAtWorkstation	=client_ip_address;
				String modifiedAtWorkstation= addedAtWorkstation ;				

			
			//	java.sql.Date added_date1	= java.sql.Date.valueOf( addedDate ) ;
			//	java.sql.Date added_date	= new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			//	java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
			//	java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 
		        pstmt=conn.prepareStatement("update mo_bed_for_area set BLOCKED_YN='N', BLOCKED_UPTO=NULL, REASON_FOR_BLOCKING=NULL, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where area_code=? and bed_no=? and facility_id = ? and blocked_yn='Y' and BLOCKED_UPTO > SYSDATE");
			
				StringTokenizer  strToken1= new StringTokenizer(releasedata1,"~");
				int cnt=0;
				if(strToken1!=null)
	            {while(strToken1.hasMoreElements())
		          {
					StringTokenizer  strToken2= new StringTokenizer(strToken1.nextToken(),"|");
	                while(strToken2.hasMoreElements())     
					{
					 area_code=(String)strToken2.nextElement();
					
					 bed_no=(String)strToken2.nextElement();

					 
				

			         pstmt.setString(1,addedById);
				     pstmt.setString(2,modifiedAtWorkstation);
				     pstmt.setString(3,modifiedFacilityId);
				     pstmt.setString(4,area_code);
				     pstmt.setString(5,bed_no);
				     pstmt.setString(6,facilityId);
                     cnt=pstmt.executeUpdate();
									
					}
				  
				  }
				if(pstmt!=null)pstmt.close();
				}
				
			   
				if ( cnt>0)
				   {    conn.commit();

					    error_value= "1";

				 java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;

				  res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode((String) message.get("message"),"UTF-8") + "&err_value=" + error_value );

				//	res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("APP-SM0002 Operation Completed Successfully ...." ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {    conn.rollback();
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("Error" ) + "&err_value=" + error_value );
		     	   }
		 
	  }catch ( Exception e )
      {
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }finally
	 {
	 try 
			{
				if (conn != null) 
					ConnectionManager.returnConnection(conn,p);
				
			}
			catch (Exception ee) 
			{
				ee.printStackTrace();
				
			}
	 }
  } // End of the modifyParameter
} // End of the Class

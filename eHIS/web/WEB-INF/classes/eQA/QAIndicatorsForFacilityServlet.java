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


public class QAIndicatorsForFacilityServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
		String mode=req.getParameter("mode")==null?"":req.getParameter("mode");
		PreparedStatement delete_pstmt=null;
		PreparedStatement insert_pstmt=null;
		String addedDate		= dateFormat.format(new java.util.Date()) ;
		java.util.HashMap results=null;
		String modifiedFacilityId="";
		if(mode.equals("U"))
		{
			
		try{
		HttpSession session = req.getSession(false);	
    	//Connection con=null;
		java.util.Properties p = null;
		//con = ConnectionManager.getConnection(req); 
		
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String client_ip_address = p.getProperty("client_ip_address");
		String facility_id = (String)session.getValue("facility_id") ;
		String addedById			= p.getProperty( "login_user" ) ;
		
		String addedFacilityId		= facility_id ;
		 modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	=client_ip_address;
		java.sql.Date added_date1	= java.sql.Date.valueOf( addedDate ) ;
		java.sql.Date added_date	= new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
		boolean inserted;
	   
		String modifiedAtWorkstation= addedAtWorkstation ;
		String fac = req.getParameter("operating_facility_id")==null ? "" : req.getParameter("operating_facility_id");
		
		String qind = req.getParameter("qind")==null ? "" : req.getParameter("qind");
		
		String period = req.getParameter("period")==null ? "" : req.getParameter("period");
		
		String gender = req.getParameter("gender")==null ? "N" : req.getParameter("gender");
		
		String age = req.getParameter("age")==null ? "" : req.getParameter("age");


            HashMap tabdata=new HashMap();
			tabdata.put("OPERATING_FACILITY_ID",fac);
			tabdata.put("QIND_CLIND_ID",qind);
			tabdata.put("DFLT_REP_PERIODICITY",period);
			tabdata.put("DFLT_BD_BY_GENDER_YN",gender);
			tabdata.put("DFLT_BD_AGE_RANGE_ID",age);
			

			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",added_date);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			tabdata.put("ADDED_FACILITY_ID", facility_id);
			tabdata.put("MODIFIED_BY_ID",addedById);
			tabdata.put("MODIFIED_DATE",added_date);
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
				
			HashMap condflds=new HashMap();
			condflds.put("OPERATING_FACILITY_ID",fac); 
			condflds.put("QIND_CLIND_ID",qind); 

			//InitialContext context = new InitialContext();
			//Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			//final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			//final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
			//final java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"QA_QIND_FACILITY_CLIND");

			String tabname="QA_QIND_FACILITY_CLIND";
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tabname;
			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tabname.getClass();
		    results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			   if ( inserted )
			   {
					error_value= "1";
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			   }
			   else
			   {
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			   }
		     
			 tabdata.clear();
			 condflds.clear();
			 results.clear();
			 }catch(Exception e)
                {
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
	            }
		}
		else
		{
		try
		{HttpSession session = req.getSession(false);	
        
		Connection con=null;
		   
		java.util.Properties p = null;
		con = ConnectionManager.getConnection(req); 
	    //java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String client_ip_address = p.getProperty("client_ip_address");
		String facility_id = (String)session.getValue("facility_id") ;
		String addedById			= p.getProperty( "login_user" ) ;
		//String addedDate		= dateFormat.format(new java.util.Date()) ;
		String addedFacilityId		= facility_id ;
		 modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	=client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;
		String fac = req.getParameter("fac_id")==null ? "" : req.getParameter("fac_id");
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
			
			 fac=subTkn.nextToken();
			qind=subTkn.nextToken();
          delete_pstmt=con.prepareStatement("delete from QA_QIND_FACILITY_CLIND where OPERATING_FACILITY_ID= ? and QIND_CLIND_ID=?");
		delete_pstmt.setString(1,fac);
		delete_pstmt.setString(2,qind);
		delete_pstmt.executeUpdate();
		con.commit();
		if(delete_pstmt!=null)delete_pstmt.close();
			if(hash.get(arr.get(i))!=null)
				{
                StringTokenizer subTkn1= new StringTokenizer((String)hash.get(arr.get(i)),"||");
				
				String val1=subTkn1.nextToken();
	            
				String val2=subTkn1.nextToken();
				String val3=subTkn1.nextToken();

				 if(val1.equals("X"))val1="";
				if(val2.equals("X"))val2="";
				if(val3.equals("X"))val3="";
               

                

				insert_pstmt=con.prepareStatement("insert into QA_QIND_FACILITY_CLIND (OPERATING_FACILITY_ID,QIND_CLIND_ID,DFLT_REP_PERIODICITY,DFLT_BD_BY_GENDER_YN,DFLT_BD_AGE_RANGE_ID,EFF_FROM_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,?,?,?,?,SYSDATE+1,?,SYSDATE,?,?,?,SYSDATE,?,?)");
			    insert_pstmt.setString(1,fac ) ;
                insert_pstmt.setString(2,qind);
				insert_pstmt.setString(3,val1);
				insert_pstmt.setString(4,val3);
				insert_pstmt.setString(5,val2);
				insert_pstmt.setString(6,addedById);
				insert_pstmt.setString(7,addedAtWorkstation);
				insert_pstmt.setString(8,addedFacilityId);
				insert_pstmt.setString(9,addedById);
				insert_pstmt.setString(10,modifiedAtWorkstation);
				insert_pstmt.setString(11,addedFacilityId);

				insert_pstmt.executeUpdate();
				
				}
			
			if(insert_pstmt!=null)insert_pstmt.close();
			//do deletion
		}
		
		
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

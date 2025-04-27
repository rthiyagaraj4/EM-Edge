/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eSM.RecordTrans.*;
public class RecordTransServlet extends javax.servlet.http.HttpServlet{

PrintWriter out;
java.util.Properties p; 

String client_ip_address ;
String facility_id;

public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		HttpSession session		= req.getSession(true);
		this.p			  		= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facility_id  		= (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");

	try {
			res.setContentType("text/html");
			
			this.out = res.getWriter();
			insert(req, res);
		}catch (Exception e)
			{
				out.println(e.toString());
			}
    }

private void insert(HttpServletRequest req, HttpServletResponse res)	{
           
			Connection		con = ConnectionManager.getConnection(req);
			String			sql1 = null;;
			String			pk_value = "";
			Statement		stmt =null;
			ResultSet		rs1 =null;
			ArrayList		columnid=new ArrayList();
			ArrayList		columnvalue=new ArrayList();
			ArrayList		column_srl_no=new ArrayList();
			String addedFacilityId=facility_id;
			String addedAtWorkstation=client_ip_address;
			try{
						stmt=con.createStatement();
						sql1="select column_id,to_char(column_srl_no) column_srl_no,column_display,column_width,column_prompt,column_pk_yn from sm_record_trans_dtl where table_id= '"+(req.getParameter("tableid")== null ?"":req.getParameter("tableid"))+"'";
						String pk_yn = "";
						rs1=stmt.executeQuery(sql1) ;
				        
						if(rs1!=null)
					    {
					      while(rs1.next())
					  	   {
							pk_yn =rs1.getString("column_pk_yn");
						   if (pk_yn.equalsIgnoreCase("Y"))
                             {
                               pk_value = pk_value+req.getParameter(rs1.getString("column_id"));     
						      }
  						  else
						   {   
						    if (rs1.getString("column_display").equalsIgnoreCase("N"))
						    {
                              
							  columnid.add(rs1.getString("column_id"));
							  columnvalue.add(req.getParameter(rs1.getString("column_id")));
							  column_srl_no.add(rs1.getString("column_srl_no"));
						     }
						  }
						}
					}

				boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecordTransManager",RecordTransHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					HashMap argMap=new HashMap();
					argMap.put("p",p);
					argMap.put("tableid",req.getParameter("tableid")== null ?"":req.getParameter("tableid"));
					argMap.put("module_id",req.getParameter("module_id")== null ?"":req.getParameter("module_id"));
					argMap.put("lang_id",req.getParameter("lang_id")== null ?"":req.getParameter("lang_id"));
					argMap.put("pk_value",pk_value);
					argMap.put("columnid",columnid);
					argMap.put("column_srl_no",column_srl_no);
					argMap.put("columnvalue",columnvalue);
					argMap.put("mode",req.getParameter("mode")== null ?"":req.getParameter("mode"));
					argMap.put("addedFacilityId",addedFacilityId);
					argMap.put("addedAtWorkstation",addedAtWorkstation);
					


					Object argArray[] = new Object[1];
					
					argArray[0] = argMap;

					Class [] paramArray = new Class[1];
					paramArray[0] = argMap.getClass();

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertUpdateRecordTrans",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				
				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;
               
				if ( inserted ) 
				 {	
				  error_value = "1" ;
			      res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			     }
			  else {
			   error = (String) results.get("error") ;
			    res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
		
		}
			argMap.clear();
			results.clear();
			columnid.clear();
			columnvalue.clear();
        	column_srl_no.clear();

			} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			}
            finally {
                try{
					if  (stmt != null)  stmt.close();
					if  (rs1 != null)  rs1.close();
					if  (con != null)  ConnectionManager.returnConnection(con,req);
				}catch(Exception e){}
                }

}
}

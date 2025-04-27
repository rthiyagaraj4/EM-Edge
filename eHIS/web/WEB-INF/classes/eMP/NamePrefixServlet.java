/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Last Modified Date Time 9/22/2005 11:23 AM 

 * @filename NamePrefixServlet.java
 *
 * @version 3.0 modified on 2/19/2005
 *	
 *****/

package eMP; 

import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import com.ehis.eslp.ServiceLocator;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;

import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0187

/**
 * @todo Class data members should be moved to method level scope
 */
public class NamePrefixServlet extends HttpServlet   
{

	PrintWriter out;
	Properties p;

	String namePrefix;
	String prefixSex ;
	String effectiveDateFrom ;
	String effectiveDateTo ;
	String effectiveStatus ;
	String name_prefix_loc_lang;
	String facilityId;
	String client_ip_address ;
	String locale			= "" ;
	
   	/**
	 * @todo Synchronization can be removed once variables are moved to method level
	 */
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
												        throws ServletException,IOException    {
        
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187
		req = new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187 END 
		HttpSession session = req.getSession(false);
        this.facilityId = (String)session.getValue("facility_id") ;      
        this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");

        try{
            this.out = res.getWriter();
            String operation = req.getParameter("function");

            if ( operation.equals("insert") )
                insertNamePrefix(req, res);
            if ( operation.equals("modify"))
                    modifyNamePrefix(req, res);
        }catch (Exception e){
          //  out.println(e.toString());
			e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
								    throws ServletException,IOException{
		try
		{
			
			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			

			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/NamePrefix.js'></script></head><iframe name='commontoolbarFrame'	src='"+source+"' frameborder='0' scrolling='no' style='height:8vh;width:100vw' noresize></iframe> <iframe name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder='0' style='height:83vh;width:100vw'></iframe> <iframe name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder='0' noresize scrolling='auto' style='height:9vh;width:100vw'></iframe></html> ");
		}
		catch(Exception e)	{	}

    }

    private void modifyNamePrefix(HttpServletRequest req, HttpServletResponse res){
        try{
            namePrefix      = req.getParameter("name_prefix");
            prefixSex       = req.getParameter("prefix_sex");
            
            effectiveStatus = req.getParameter("eff_status");
            name_prefix_loc_lang = req.getParameter("prefix_in_oth_lang")==null?"":req.getParameter("prefix_in_oth_lang");					
		
            //InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( name_prefix_loc_lang.getBytes()), "windows-1256" ) ;
            //name_prefix_loc_lang = (new BufferedReader(reader)).readLine() ;
			
            if ( name_prefix_loc_lang == null || name_prefix_loc_lang.equals("null"))
                name_prefix_loc_lang = "";

            if ( effectiveStatus == null )
                effectiveStatus="D";

            if( prefixSex.equals("All"))         // changed by Afruddin for ML-MMOH-CRF-1520 US0001 ON 4.05.2020
                prefixSex="B";
            else if (prefixSex.equals("Male"))
                prefixSex="M";
            else if (prefixSex.equals("Female"))
                prefixSex="F";
            else if (prefixSex.equals("Unknown")) // Added by Afruddin for ML-MMOH-CRF-1520 US0001 ON 4.05.2020
                prefixSex="U";                     // Added by Afruddin for ML-MMOH-CRF-1520 US0001 ON 4.05.2020

            String addedById = p.getProperty( "login_user" ) ;

            String modifiedById = addedById ;

            String modifiedFacilityId = facilityId ;
            String addedAtWorkstation=client_ip_address;
            String modifiedAtWorkstation = addedAtWorkstation ;


            HashMap tabdata=new HashMap();

            tabdata.put("prefix_sex",prefixSex);
            tabdata.put("eff_status",effectiveStatus);
            tabdata.put("name_prefix_loc_lang",name_prefix_loc_lang);
            tabdata.put("modified_by_id",modifiedById);
            tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
            tabdata.put("modified_facility_id",modifiedFacilityId);
            tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

            HashMap condflds=new HashMap();
            condflds.put("name_prefix",namePrefix);
			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = "MP_NAME_PREFIX";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			tabdata.clear();
			condflds.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
            String error = (String) results.get("error") ;
            String error_value = "0" ;
			results.clear();
            if ( inserted ){
                 error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
            }else{
                
                 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error, "UTF-8") );
            }
			
          }catch ( Exception e ){
            //out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
            //out.println( "Values sent are : <br>" ) ;
            //out.println( namePrefix + " "+prefixSex + " "+ effectiveDateFrom+" "+ effectiveDateTo + " "+ effectiveStatus+"  "+name_prefix_loc_lang );
			e.printStackTrace();
        }
    }

    private void insertNamePrefix(HttpServletRequest req, HttpServletResponse res){
        try{
            namePrefix      = req.getParameter("name_prefix");
            prefixSex       = req.getParameter("prefix_sex");
           
            effectiveStatus = req.getParameter("eff_status");
            name_prefix_loc_lang = req.getParameter("prefix_in_oth_lang")==null?"":req.getParameter("prefix_in_oth_lang");

           //InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( name_prefix_loc_lang.getBytes()), "windows-1256" ) ;
          // name_prefix_loc_lang = (new BufferedReader(reader)).readLine() ;
            if ( effectiveStatus == null )
                    effectiveStatus="D";

            if ( name_prefix_loc_lang == null || name_prefix_loc_lang.equals("null"))
                name_prefix_loc_lang = "";

            String addedById = p.getProperty( "login_user" ) ;

            String modifiedById = addedById ;

            String addedFacilityId=facilityId;
            String modifiedFacilityId = addedFacilityId ;
            String addedAtWorkstation=client_ip_address;
            String modifiedAtWorkstation = addedAtWorkstation ;

			Connection con = null;
            ResultSet rs = null ;
            PreparedStatement pstmt=null;
			try
			{
				con = ConnectionManager.getConnection(req);
				pstmt=con.prepareStatement("Select 'x' from mp_name_prefix where upper(name_prefix) = upper(?)" );
				pstmt.setString(1,namePrefix);
				rs = pstmt.executeQuery() ;
				if (!rs.next())
				{
					HashMap tabdata=new HashMap();
					tabdata.put("name_prefix",namePrefix);
					tabdata.put("prefix_sex",prefixSex);
					tabdata.put("eff_status",effectiveStatus);
					tabdata.put("name_prefix_loc_lang",name_prefix_loc_lang);

					tabdata.put("added_by_id",addedById);
					tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("added_facility_id", facilityId);
					tabdata.put("added_at_ws_no",addedAtWorkstation);
					tabdata.put("modified_by_id",modifiedById);
					tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("modified_facility_id",modifiedFacilityId);
					tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

					String dupflds[]={"name_prefix"};

					boolean local_ejbs = isLocalEJB();
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

					Object argArray[] = new Object[4];
					argArray[0] = p;
					argArray[1] = tabdata;
					argArray[2] = dupflds;
					argArray[3] = "MP_NAME_PREFIX";

					Class [] paramArray = new Class[4];
					paramArray[0] = p.getClass(); ;
					paramArray[1] = tabdata.getClass();
					paramArray[2] = dupflds.getClass();
					paramArray[3] = String.class;
					
					java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

					tabdata.clear();					

					boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

					String error = (String) results.get("error") ;
					String error_value = "0" ;
					results.clear();	
					if ( inserted )
					{
						 error_value = "1" ;
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
					}
					else
					{
						 
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8") );
					}
				}
				else
				{
					String error_value="0";
					MessageManager mm = new MessageManager();
					final java.util.Hashtable message = mm.getMessage( locale,"CODE_ALREADY_EXISTS","Common" ) ;
					String msg =  (String) message.get("message");
					message.clear();
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg , "UTF-8") + "&err_value=" + error_value );
				}
			}
			catch(Exception e)
			{
				//out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
				e.printStackTrace();
			}
			finally
			{
				if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con,req);
			}
          }catch ( Exception e ){
           // out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
           // out.println( namePrefix + " "+prefixSex + " "+ effectiveDateFrom+" "+ effectiveDateTo + " "+ effectiveStatus+"  "+name_prefix_loc_lang );
			e.printStackTrace();
        }
    }
	boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				return true;
		else
				return false;
	}
}

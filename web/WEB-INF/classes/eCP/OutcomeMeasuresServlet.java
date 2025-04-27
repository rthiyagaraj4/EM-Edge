/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import eCommon.Common.*;
import eCommon.SingleTabHandler.*;
import webbeans.eCommon.*;

public class OutcomeMeasuresServlet extends HttpServlet 
{
	//private ServletConfig config = null;
	PrintWriter out = null;
	HttpSession session = null;
	String facility_id = "";
	Properties p = new Properties();
	String client_ip_address = "";
	boolean inserted= false;
    boolean delete= false;
	String outcome_code="";
	String id="";
	String desc="";
	String score="";
	String seq_no="";
	String mode="";
	String added_by_id = "";
	
	String added_at_ws_no = "";
	
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;	

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{

			res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
			this.out = res.getWriter();
		try	{

			session = req.getSession(false);
			this.facility_id = (String) session.getAttribute( "facility_id" ) ;
			this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
			this.client_ip_address = p.getProperty("client_ip_address");

		outcome_code=req.getParameter("outcome_code")==null ? "":req.getParameter("outcome_code");
		id=req.getParameter("id")==null ? "":req.getParameter("id");
		desc=req.getParameter("Desc")==null ? "":req.getParameter("Desc");
		score=req.getParameter("score")==null ? "":req.getParameter("score");
		seq_no=req.getParameter("seq_no")==null ? "":req.getParameter("seq_no");
		mode=req.getParameter("mode")==null?"":req.getParameter("mode");
		//System.err.println("mode "+mode);
		if(mode.equals("1"))
			insertOperation(req, res);
		else if(mode.equals("2"))
			modifyOperation(req,res);
		else if(mode.equals("3"))
			deleteOperation(res);

			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void insertOperation(HttpServletRequest req,HttpServletResponse res)
     throws Exception
	{
//		System.err.println("inside insert");
				
		try{

			String addeddate = dateFormat.format( new java.util.Date() ) ;
			facility_id = (String) session.getAttribute( "facility_id" ) ;
			added_by_id 	= p.getProperty( "login_user" ) ;

			added_at_ws_no	= client_ip_address;
					

		HashMap tabData=new HashMap();

		tabData.put("OUTCOME_CODE",outcome_code);
		tabData.put("OUTCOME_MSR_ID",id);
		tabData.put("OUTCOME_MSR_DESC",desc);
		tabData.put("CUT_OFF_SCORE",score);
		tabData.put("DISP_SEQ_NO",seq_no);
		tabData.put("ADDED_BY_ID", added_by_id);
        tabData.put("ADDED_DATE", addeddate);
        tabData.put("ADDED_AT_WS_NO",  client_ip_address);
		tabData.put("ADDED_FACILITY_ID",  facility_id);
		tabData.put("MODIFIED_BY_ID", added_by_id);
        tabData.put("MODIFIED_DATE", addeddate);
		tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
		tabData.put("MODIFIED_FACILITY_ID", facility_id);
		
		// String dupflds[]={"OUTCOME_MSR_ID"};
	//	String dupflds[]={"OUTCOME_MSR_ID"};
	//	System.err.println("tabData in servlet "+tabData);
	String dupflds[]={"OUTCOME_CODE","OUTCOME_MSR_ID"};

try{
				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[4];
				String table_name="CP_OUTCOME_MSR";
				argArray[0] =p;
				argArray[1] =tabData;
				argArray[2] =dupflds;
				argArray[3] =table_name;
				Class [] paramArray = new Class[4];
				paramArray[0] =p.getClass();
				paramArray[1] =tabData.getClass();
				paramArray[2] =dupflds.getClass();
				paramArray[3] =table_name.getClass();
				HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
//				System.err.println("results in servlet "+results);
				String error_value=(String)results.get("error");
				String err_num="";
				if ( inserted )
				 {
					// error_value = "APP-SM0002 Operation Completed Successfully...";
					 err_num="1";
	 				   res.sendRedirect("../eCP/jsp/OutcomeMeasuresFrame.jsp?err_num=" + err_num + "&err_value=" + error_value+"&mode=1&outcome_code="+outcome_code );
	        	   }
		     	   else
		     	   {
					 //  if(error_value.equals("APP-SM0095 Record Already Exists...<br>
					   err_num="2";
					 //  error_value = "Exception Occured while Insertion..";
   						out.println("<script>alert('"+error_value+"');</script>");
						out.println("<script>window.close();</script>");

		     	   }
		     }catch(Exception e)
                {
                  e.printStackTrace();
				  System.err.println("error in servlet "+e);
	            }
	  }catch ( Exception e )
      {
		e.printStackTrace();
      }

  } // End of the insertParameter

	//End of Insert

	public void modifyOperation(HttpServletRequest req,HttpServletResponse res)
		throws Exception
	{
//			System.err.println("inside update");
		try{
			String addeddate = dateFormat.format( new java.util.Date() ) ;
		facility_id = (String) session.getAttribute( "facility_id" ); 
		added_by_id 	= p.getProperty( "login_user" ) ;
		added_at_ws_no	= client_ip_address;
		
		HashMap tabData=new HashMap();

		tabData.put("OUTCOME_CODE",outcome_code);
		tabData.put("OUTCOME_MSR_ID",id);
		tabData.put("OUTCOME_MSR_DESC",desc);
		tabData.put("CUT_OFF_SCORE",score);
		tabData.put("DISP_SEQ_NO",seq_no);
		tabData.put("MODIFIED_BY_ID", added_by_id);
        tabData.put("MODIFIED_DATE", addeddate);
		tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
		tabData.put("MODIFIED_FACILITY_ID", facility_id);

		HashMap condflds=new HashMap();
		condflds.put("OUTCOME_CODE",outcome_code);	
		condflds.put("OUTCOME_MSR_ID",id);
		try{
				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[4];
				String table_name="CP_OUTCOME_MSR";
				argArray[0] =p;
				argArray[1] =tabData;
				argArray[2] =condflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				paramArray[0] =p.getClass();
				paramArray[1] =tabData.getClass();
				paramArray[2] =condflds.getClass();
				paramArray[3] =table_name.getClass();
				
				HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error_value=(String)results.get("error");
				String err_num="";

				if ( inserted )
				 {
					 //error_value = "APP-SM0002 Operation Completed Successfully...";
					 err_num="1";
  					 res.sendRedirect("../eCP/jsp/OutcomeMeasuresFrame.jsp?err_num=" + err_num + "&err_value=" + error_value+"&mode=1&outcome_code="+outcome_code );
	        	   }
		     	   else
		     	   {
					   err_num="2";
					//   error_value = "Exception Occured while Insertion..";
						out.println("<script>alert('"+error_value+"');</script>");
						out.println("<script>window.close();</script>");
		     	   }
				   
		     }catch(Exception e)
                {
                  e.printStackTrace();
	            }
	  }catch ( Exception e )
      {
		e.printStackTrace();
      }
  } // End of the modifyParameter
		
	private void deleteOperation(HttpServletResponse res){

//			System.err.println("inside delete");
			//String addeddate = dateFormat.format( new java.util.Date() ) ;
			facility_id = (String) session.getAttribute( "facility_id" ); 
			added_by_id 	= p.getProperty( "login_user" ) ;
			added_at_ws_no	= client_ip_address;
		
			HashMap tabData=new HashMap();

			tabData.put("OUTCOME_CODE",outcome_code);
			tabData.put("OUTCOME_MSR_ID",id);
			tabData.put("OUTCOME_MSR_DESC",desc);
			tabData.put("CUT_OFF_SCORE",score);
			tabData.put("DISP_SEQ_NO",seq_no);
			
		      try{
			
			/*InitialContext initialcontext = new InitialContext();
			Object obj = initialcontext.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singletabhandlermanagerhome = (SingleTabHandlerManagerHome)PortableRemoteObject.narrow(obj, eCommon.SingleTabHandler.SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singletabhandlermanagerremote = singletabhandlermanagerhome.create();
			final java.util.HashMap results = singletabhandlermanagerremote.delete(p, hashtable, "rs_parameter");
			*/
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[3];
			String table_name="CP_OUTCOME_MSR";
			argArray[0] =p;
			argArray[1] =tabData;
			argArray[2] =table_name;

			Class [] paramArray = new Class[3];
			paramArray[0] =p.getClass();
			paramArray[1] =tabData.getClass();
			paramArray[2] =table_name.getClass();
			
			HashMap results = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			delete = ((Boolean)results.get("status")).booleanValue();
			String error_value=(String)results.get("error");
			String err_num="";
			
			if(delete){
				// error_value = "APP-SM0002 Operation Completed Successfully...";
				 err_num="1";
				 res.sendRedirect("../eCP/jsp/OutcomeMeasuresFrame.jsp?err_num=" + err_num + "&err_value=" + error_value+"&mode=1&outcome_code="+outcome_code );

			}else{
				   err_num="2";
				//   error_value = "Exception Occured while Insertion..";
				   out.println("<script>alert('"+error_value+"');</script>");
				   out.println("<script>window.close();</script>");

		}
			  }

        catch(Exception exception){
            out.println("<h3> Exception raise by Servlet ...So Record Not Deleted foll: Error Received : " + exception.toString());
            out.println("Values sent are : <br>");
        }
    }

}

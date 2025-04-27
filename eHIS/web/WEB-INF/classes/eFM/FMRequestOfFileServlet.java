/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.URLEncoder;
import eFM.FMRequestOfFile.* ;
import webbeans.eCommon.*;





public class FMRequestOfFileServlet extends javax.servlet.http.HttpServlet	
{
	PrintWriter out;
	java.util.Properties p;
    Connection	connection	=	null;
	HttpSession session     =null;
	ResultSet	rs			=	null;
	Statement stmt			=	null;	
	
	String p_req_facility		= "";
	String p_req_location		= "";
	String p_req_name			= "";
	String p_enter_fcy			= "";
	String p_req_narration		= "";
	String p_file_nos			= "";
	String p_rem_recnum			= "";
	String p_file_type_code		= "";
	String p_requesting_from	= "";
	String p_volume_nos			= "";
	String p_patient_id			= "";
	String p_doc_folder_id		= "";
	String p_doc_type_code		= "";
	String p_file_required_on		= "";
	String client_ip_address	= "";
	String locale			= "" ;
	String print_req_slip="";
	String curr_facility_id="";
	String login_user_id="";
	String sql="";
	String  sys_date="";
	String  rec_cnt="";
    String p_patient_id1="";
	String p_from_date="";
	String p_to_date="";
	String p_iss_fs_locn="";
	String req_no="";
	String dest_locn_code="";
	boolean inserted =false;	
	java.util.HashMap hashmap = null;
	/* Below line(s) added by Venkatesh.s against ML-MMOH-CRF-0393 */
	String remarks_for_borrow="";
	/*end ML-MMOH-CRF-0393 */

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
	//	this.p					= (java.util.Properties) session.getValue( "jdbc" );
		//locale = p.getProperty("LOCALE");
		//	this.client_ip_address	= p.getProperty("client_ip_address");
       	try 
		{
			this.out = res.getWriter();
		String operation = req.getParameter("functionval");
		
			  if(operation.equals("insert"))
				insertRequestOfFile(req, res, locale);
		}catch (Exception e){out.println(e.toString());
	          e.printStackTrace();
           }
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
 		throws javax.servlet.ServletException,IOException
	{
		try	
		{		
			
			this.out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link></head><frameset rows='60,*,50'><frame name='commontoolbarFrame'	src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=Name Prefix' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}catch(Exception e){out.println("Exception in doGet method :"+e.toString());
		e.printStackTrace();
		}
	}

	private void insertRequestOfFile(HttpServletRequest req, HttpServletResponse res, String locale)	
	{
		try
		{			 
		
			 
			 connection			=	ConnectionManager.getConnection(req);			
			 session		= req.getSession(false);
		    this.p					= (java.util.Properties) session.getValue( "jdbc" );
		locale = p.getProperty("LOCALE");
		this.client_ip_address	= p.getProperty("client_ip_address");
			
			curr_facility_id	=	(String) session.getValue("facility_id");
			login_user_id		=	(String) session.getValue("login_user");
			p_req_facility		= req.getParameter("p_req_facility")==null?"":req.getParameter("p_req_facility");
			p_req_location		= req.getParameter("p_req_location")==null?"":req.getParameter("p_req_location");
			p_req_name			= req.getParameter("p_req_name")==null?"":req.getParameter("p_req_name");
			p_enter_fcy			= req.getParameter("p_req_to_facility")==null?"":req.getParameter("p_req_to_facility");
			p_req_narration		= req.getParameter("p_req_narration")==null?"":req.getParameter("p_req_narration");
			p_file_nos			= req.getParameter("p_file_nos")==null?"":req.getParameter("p_file_nos");
			p_rem_recnum		= req.getParameter("p_rem_recnum")==null?"":req.getParameter("p_rem_recnum");
						
			p_patient_id		= req.getParameter("p_patient_id")==null?"":req.getParameter("p_patient_id");
			p_volume_nos		= req.getParameter("p_volume_nos")==null?"":req.getParameter("p_volume_nos");
			p_file_type_code	= req.getParameter("p_file_type_code")==null?"":req.getParameter("p_file_type_code");
			p_requesting_from	= req.getParameter("requesting_code")==null?"":req.getParameter("requesting_code");
			p_doc_folder_id		= req.getParameter("p_doc_folder_id")==null?"":req.getParameter("p_doc_folder_id");
			p_doc_type_code		= req.getParameter("p_doc_type_code")==null?"":req.getParameter("p_doc_type_code");
			p_file_required_on		= req.getParameter("p_file_required_on")==null?"":req.getParameter("p_file_required_on");
            print_req_slip     = req.getParameter("print_req_slip")==null?"N":req.getParameter("print_req_slip");
			rec_cnt                          =req.getParameter("tot_count")==null?"":req.getParameter("tot_count");		
			dest_locn_code	   = req.getParameter("perm_fs_locn_code")==null?"":req.getParameter("perm_fs_locn_code");
			/* Below line(s) added by Venkatesh.s against ML-MMOH-CRF-0393 */
			remarks_for_borrow			   = req.getParameter("reason")==null?"":req.getParameter("reason");
			/*end ML-MMOH-CRF-0393 */
			String first_token="";
			String next_token="";
			boolean existsdiffpatid=false; 
						
			if (rec_cnt==null ) rec_cnt ="0";
			int recCount=0;
			if(rec_cnt!="")	
			{
			 recCount =Integer.parseInt(rec_cnt);
			}
			if(recCount==1)
			{
			 p_patient_id1=p_patient_id;
			}else{
				StringTokenizer pat_token = new StringTokenizer(p_patient_id,"|");//Added by S.Sathish for IN018357 on Friday, January 22, 2010
				int count	= pat_token.countTokens();
				for(int j=0;j<count;j++)
				{
					if(j==0){
						first_token=pat_token.nextToken();
					}
					else
					{
						next_token=pat_token.nextToken();
						if(!first_token.equals(next_token))
							existsdiffpatid=true;
					}
				}
				if(existsdiffpatid)
					 p_patient_id1="";
				else
					p_patient_id1=first_token;//Ends here for IN018357
			}

			
			hashmap = new HashMap();
			hashmap.put("p_req_facility"	, p_req_facility);
			hashmap.put("p_req_location"	, p_req_location);
			hashmap.put("p_req_name"		, p_req_name);
			hashmap.put("p_enter_fcy"		, p_enter_fcy);
			hashmap.put("p_req_narration"	, p_req_narration);
			hashmap.put("p_file_nos"		, p_file_nos);
			hashmap.put("client_ip_address"	, client_ip_address);
			hashmap.put("p_rem_recnum"		, p_rem_recnum);
			hashmap.put("p_file_type_code"	, p_file_type_code);
			hashmap.put("p_requesting_from"	, p_requesting_from);
			hashmap.put("p_volume_nos"		, p_volume_nos);
			hashmap.put("p_patient_id"		, p_patient_id);
			hashmap.put("p_doc_folder_id"	, p_doc_folder_id);
			hashmap.put("p_doc_type_code"	, p_doc_type_code);
			hashmap.put("p_file_required_on"	, p_file_required_on);
			hashmap.put("locale"	, locale);
			/* Below line(s) added by Venkatesh.s against ML-MMOH-CRF-0393 */
			hashmap.put("remarks_for_borrow"	, remarks_for_borrow);
          /*end ML-MMOH-CRF-0393 */
			sql = "select TO_CHAR(SYSDATE,'DD/MM/YYYY')sys_date from dual" ;
			stmt = connection.createStatement();
			rs	 = stmt.executeQuery(sql);
			while(rs.next())
			{
			sys_date = rs.getString("sys_date");
			} if(rs != null) rs.close();	
			
			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
						
			Object home	  = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMRequestOfFile",RequestOfFileHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = hashmap;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = hashmap.getClass();
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertRequestOfFile",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						
		    inserted	=	(((Boolean) results.get("status")).booleanValue()) ;
			String error = (String) results.get("error") ;
			       req_no =(String) results.get("p_req_no");
			    
					
			results.clear();
        	 if(inserted)
			{
				//error_value = "1";		
				if (print_req_slip.equals("Y"))
				{
					p_from_date=sys_date;
					p_to_date=sys_date;  
					doOnlineReportsSec(sys_date,p_req_name,login_user_id,p_enter_fcy,locale,p_patient_id1);
				}
			} 
			else
			{
				out.println("<script>alert('"+error+"');parent.parent.document.getElementById('dialog_tag').close();</script>");
			}
			
		//	out.println("<Script>parent.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+ java.net.URLEncoder.encode( error_msg,"UTF-8" )+"&err_value="+error_value+"';</script>");
		out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+"\"</script><body class='message'></html>");
		if(stmt!=null)  stmt.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace() ;
		}
	 finally
		{			
			ConnectionManager.returnConnection(connection,req);		
		}
	
	}
    
private void doOnlineReportsSec( String p_appt_date, String p_iss_no, String p_user_name, String p_facility_id, String locale , String Patient_Id)
        throws ServletException, IOException, SQLException
    {	
			
		String dest_locn_type="F";
	    StringBuffer sqlString=new StringBuffer();
         sql = " select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'FM' AND REPORT_ID = 'FMFLRQSL' and language_id='"+locale+"'" ;   
        String repParamNames = "p_call_from,P_req_no,p_facility_id";
        String repParamValues = "REQUEST_FILE_LIST"+ "," +req_no+ "," +p_facility_id;
        sqlString = sqlString.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
        sqlString.append( "</head><body class='message'>");
		sqlString.append("<script language = 'JavaScript'>");
        sqlString.append("async function toCallShowModelDia(){ var message = 'APP-SM0002 Operation Completed Successfully';");
        sqlString.append( "  var dialogHeight    = '50vh' ;");  
        sqlString.append(" var dialogWidth = '60vw' ;");
        sqlString.append( "var dialogTop = '65';");
        sqlString.append( "  var arguments =   ''; ");
        sqlString.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?step=1&p_called_from=FM_REQ_FILE&sqlString=" + URLEncoder.encode(sql) + "&reportParamNames=" + repParamNames + "&reportParamValues=" +repParamValues+ "&p_enter_fcy=" +p_enter_fcy+ "&dest_locn_type=" +dest_locn_type +"&perm_fs_locn_code=" +dest_locn_code+" &Patient_ID="+Patient_Id+"';");
		sqlString.append( " var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;';");
        sqlString.append( "  retVal            =   await window.showModalDialog(getUrl,arguments,features); ");	
		sqlString.append( "parent.parent.document.getElementById('dialog_tag').close(); } toCallShowModelDia();</script>");		
        out.println(sqlString.toString());
		sqlString.setLength(0);
        
	
	
	}





}

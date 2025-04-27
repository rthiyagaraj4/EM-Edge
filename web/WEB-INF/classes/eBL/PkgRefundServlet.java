/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.lang.reflect.Method;
import java.net.*;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;
import java.util.StringTokenizer;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import eBL.*;	 
import com.ehis.persist.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.ArrayList ;
import eCommon.Common.*;
import com.ehis.eslp.ServiceLocator;




public class PkgRefundServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	HashMap results;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String slmt_ind="",adm_rec_flag="";
	String locale = "";
	
	HttpSession session;
	String mode="";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{	
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = this.p.getProperty("client_ip_address");
		login_user = this.p.getProperty( "login_user" ) ;
		locale = this.p.getProperty("LOCALE") ;
	//	System.out.println("Check in Servlet 1:"+req.getParameter("mode"));
	//System.out.println("Check in Servlet 1:");
		try
		{
			this.out = res.getWriter();			
			//String operation = req.getParameter("mode");			//unused variable
			insertData(req, res);
					
			
		}
		catch(Exception e)
		{
			out.println(e.toString());
			System.out.println("main ex"+e.toString());
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		doPost(req,res);
	}


	private HashMap populateTabData(HttpServletRequest req, HttpServletResponse res){
		//System.out.println("inside Pooulatedatesdsda");	
		HashMap tabdata=new HashMap();
		boolean service_refunded=false;
		String patient_id=checkForNull(req.getParameter("patient_id"));	
		String pkg_code=checkForNull(req.getParameter("pkg_code"));	
		String pkg_desc=checkForNull(req.getParameter("pkg_desc"));	
		String pkg_seq_no=checkForNull(req.getParameter("pkg_seq_no"));	
				
		String bean_id		= "PkgRefundBean" ;
		String bean_name	= "eBL.PkgRefundBean";
		PkgRefundBean bean			= (PkgRefundBean)PersistenceHelper.getBeanObject( bean_id, bean_name, req ) ;			
		
		ArrayList  pkg_srv_dtls=bean.getPkgSrvDtls();		
		//System.out.println("in PkgRefundServlet,pkg_srv_dtls="+pkg_srv_dtls.toString());
		HashMap  excl_srv_dtls=bean.getExclSrvDtls();		
		//System.out.println("in PkgRefundServlet,excl_srv_dtls="+excl_srv_dtls.toString());
		/** chk if refund is appliced to atleast one service**************/
		String[] srv_record=new String[13];
		if(pkg_srv_dtls!=null && pkg_srv_dtls.size()>0){
			for(int i=0;i<pkg_srv_dtls.size();i++)
			{
				srv_record=(String[])pkg_srv_dtls.get(i);
				if( !srv_record[10].equals("Y") &&  srv_record[12].equals("Y")){
					service_refunded=true;	
					break;
				}
			}
		}
		srv_record=null;
		String[] excl_record=new String[13];
		ArrayList excl_srv=new ArrayList();
		if(!service_refunded){
			Set<String> excl_srv_set=(Set<String>)excl_srv_dtls.keySet();
			//System.out.println("excl_srv_set="+excl_srv_set.toString());
			Iterator<String> excl_srv_it=excl_srv_set.iterator();
			String mapKey="";
			while(excl_srv_it.hasNext()){
				mapKey=excl_srv_it.next();			
				excl_srv=(ArrayList)excl_srv_dtls.get(mapKey);	
				if(excl_srv!=null && excl_srv.size()>0){
					for(int i=0;i<excl_srv.size();i++)
					{
						excl_record=(String[])excl_srv.get(i);
						if(!excl_record[10].equals("Y") &&  excl_record[12].equals("Y")){
							service_refunded=true;	
							break;
						}
							
					}
				}
			}
		}
		if(service_refunded){
			tabdata.put("facility_id",facilityId);
			tabdata.put("patient_id",patient_id);		
			tabdata.put("pkg_code",pkg_code);
			tabdata.put("pkg_desc",pkg_desc);
			tabdata.put("pkg_seq_no",pkg_seq_no);
			tabdata.put("client_ip_address",client_ip_address);
			tabdata.put("login_user",login_user);
			tabdata.put("locale",locale);	
			tabdata.put("pkg_srv_dtls",(ArrayList)pkg_srv_dtls);		
			tabdata.put("excl_srv_dtls",(HashMap)excl_srv_dtls);
		}
		tabdata.put("service_refunded",new Boolean(service_refunded) );
		//System.out.println("populateTabData Called tabdata:"+tabdata);
		return tabdata;
		
	}

	private void insertData(HttpServletRequest req,HttpServletResponse res)
	{
		try 
		{	
			HashMap tabdata=new HashMap();
			//java.util.Locale loc = new java.util.Locale(locale);	//unused variable	
			tabdata = populateTabData(req,res);	
			boolean service_refunded = (((Boolean) tabdata.get("service_refunded")).booleanValue());
			boolean inserted =false;
			String error = "";
			//String message ="";
			String sys_error = "";
			//System.out.println("tabdata="+tabdata.toString());
			//System.out.println("service_refunded="+service_refunded);
			String p_from_bill_doc_type = "";
			String p_from_bill_doc_num ="";
			String p_to_bill_doc_type = "";
			String p_to_bill_doc_num ="";
			if(service_refunded){
				boolean local_ejbs = false;
		
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
					local_ejbs = true;
			
				Object home =ServiceLocator.getInstance().getHome("java:comp/env/PkgRefund",eBL.PkgRefund.PkgRefundLocalHome.class, local_ejbs);	
			

				Object busObj = (home.getClass().getMethod("create",null)).invoke(home, null);
				Object argArray[] = new Object[2];					
				argArray[0] = p;
				argArray[1] = tabdata;		

				Class[] paramArray = new Class[2];

				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();	
				
				

				java.util.HashMap results = (java.util.HashMap) (busObj.getClass().getMethod("insert", paramArray)).invoke(busObj, argArray);	
				(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
				//System.out.println("ejb results :"+results);

				inserted = (((Boolean) results.get("status")).booleanValue());
				//System.out.println("ejb inserted :"+inserted);
				error = (String) results.get("error");
				//System.out.println("ejb error :"+error);
			//	message = (String) results.get("message");
			//	System.out.println("ejb message :"+message);
				sys_error = (String) results.get("sys_error");
				//System.out.println("ejb sys_error :"+sys_error);
				p_from_bill_doc_type = (String) results.get("p_from_bill_doc_type");
				p_from_bill_doc_num = (String) results.get("p_from_bill_doc_num");
				p_to_bill_doc_type = (String) results.get("p_to_bill_doc_type");
				p_to_bill_doc_num = (String) results.get("p_to_bill_doc_num");
			}else{
				inserted=false;
				Hashtable messageHashtable=MessageManager.getMessage(locale,"BL8676","BL");				
				error=(String)messageHashtable.get("message");
			}
			String error_value="0";
			
			//System.out.println("ejb p_from_bill_doc_type :"+p_from_bill_doc_type);
			//System.out.println("ejb p_from_bill_doc_num :"+p_from_bill_doc_num);
			//System.out.println("ejb p_to_bill_doc_type :"+p_to_bill_doc_type);
			//System.out.println("ejb p_to_bill_doc_num :"+p_to_bill_doc_num);
		//	out.println("<script>parent.frames(1).frames(0).document.frmPkgDefHeader.strPackageSeqno.value='"+strPackageSeqno+"';</script>");
			if(inserted)
			{
					
				error_value = "1" ;						
				/*Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String success_msg=(String)messageHashtable.get("message");	*/	

				out.println("<script language='javascript' src='../js/PkgRefund.js'></script> ");
				out.println("<script language='JavaScript'>parent.frames(1).frames(0).onSuccess1('"+p_from_bill_doc_type+"','"+p_from_bill_doc_num+"','"+p_to_bill_doc_type+"','"+p_to_bill_doc_num+"'); </script>");
				out.println("Script> parent.messageFrame.location.href='../eCommon/jsp/error.jsp </script>");
		
			}
			else
			{				
				if(!error.equals(""))
				{
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error.toString(),"UTF-8" ) +"&err_value="+error_value);
				}
				/*else if(!message.equals(""))
				{
					
					Hashtable messageHashtable=new Hashtable();
					String msg="";
					
					if(message.indexOf("|") != (-1)){
						StringTokenizer	msgIds=new StringTokenizer(message,"|");
						while(msgIds.hasMoreTokens())
						{
							messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
							msg+=(String)messageHashtable.get("message")+"<br>";													
						}
						
					}else{								
						messageHashtable=MessageManager.getMessage(locale,message,"BL");
						msg+=(String)messageHashtable.get("message");
					
					}		

					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) +"&err_value="+error_value);
				}*/
				else if(!sys_error.equals(""))
				{						
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( sys_error.toString(),"UTF-8" ) +"&err_value="+error_value);
				}
			} 
			

			 
		} 
		catch (Exception e) 
		{
			//con.rollback();
			System.out.println("exception in main=" + e.toString());
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "
							+ e.toString() );
			out.println("Values sent are : <br>");
		} 

	}
	private String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String str,String defaultVal){
		return (!checkForNull(str).equals(""))?str:defaultVal;
	}

	private boolean isLocalEJB(){
		ServletContext servletcontext = getServletConfig().getServletContext();
		if ((servletcontext.getInitParameter("LOCAL_EJBS")!=null) &&(servletcontext.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
			return false;
	}
}

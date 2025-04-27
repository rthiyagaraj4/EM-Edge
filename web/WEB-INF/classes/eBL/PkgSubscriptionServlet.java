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




public class PkgSubscriptionServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	HashMap results;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String slmt_ind="",adm_rec_flag="";
	String locale = "";
	HashMap tabdata=null;
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
		try
		{
			this.out = res.getWriter();			
		//	String operation = req.getParameter("mode");	//unused variable		
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
		String packageCode="";String packageDesc="";String fromDate="";	String toDate="";
		String pkgAmt="";	String episodeType="";	
		String addlCharge="";//Added V171212-Gayathri/MMS-DM-CRF-0118
		//String encounterId="";		
		String blng_class_code="",blng_class_desc="";
		String blng_grp_code="",blng_grp_desc=""; //Added By Shikha For GHL-CRF-0520.1
		String payerGrpCode="",payerGrpDesc="";
		String payerCode="",payerDesc="";
		String strOPYN="",strEMYN="",strIPYN="",strDCYN="";
		int tot_rec=1;
		//Added Newly by muthu against 33044
		String practitioner_id		= "";
		String practitioner_name = "";
		//Added Newly by muthu against 33044
		String patientId=checkForNull(req.getParameter("patientId"));		
		String totalRecords=req.getParameter("total_records");
			if ((totalRecords == null) ||(totalRecords.equals("")) ) totalRecords="1";
		//System.out.println("inside Pooulatedatesdsda totalRecords"+totalRecords);
		tot_rec=Integer.parseInt(totalRecords);

		String siteSpec="";
		siteSpec=req.getParameter("site_spec");
		System.out.println("site spec "+siteSpec);

		
//System.out.println("inside Pooulatedate");
		tabdata.put("FACILITY_ID",facilityId);
		tabdata.put("patientId",patientId);	
		tabdata.put("client_ip_address",client_ip_address);
		tabdata.put("login_user",login_user);
		tabdata.put("locale",locale);	
		
		for(int i=0;i<tot_rec;i++)
		{
		 //System.out.println("inside Pooulatedate loop");
		 packageCode=checkForNull(req.getParameter("packageCode_"+i));
		 packageDesc=checkForNull(req.getParameter("packageDesc_"+i));
		 fromDate=checkForNull(req.getParameter("fromDate_"+i));
		 if(siteSpec.equals("true"))
		 {
		 fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMYHMS","en",locale);
		 }
		 else
		 {
			 fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMY","en",locale); 
		 }
		 toDate=checkForNull(req.getParameter("toDate_"+i));
		 if(siteSpec.equals("true"))
		 {
			 toDate = com.ehis.util.DateUtils.convertDate(toDate,"DMYHMS","en",locale);
		 }
		 else
		 {
			 toDate = com.ehis.util.DateUtils.convertDate(toDate,"DMY","en",locale); 
		 }
		 pkgAmt=checkForNull(req.getParameter("pkgAmt_"+i));
		 addlCharge=checkForNull(req.getParameter("addl_charge_"+i)); ////Added V171212-Gayathri/MMS-DM-CRF-0118
		 episodeType=checkForNull(req.getParameter("episodeType_"+i));
		 //encounterId=checkForNull(req.getParameter("encounterId_"+i));
		 blng_class_code=checkForNull(req.getParameter("blng_class_code"+i));
		 blng_class_desc=checkForNull(req.getParameter("blng_class_desc"+i));
		 blng_grp_code=checkForNull(req.getParameter("blngGrpCode_"+i)); //Added By Shikha For GHL-CRF-0520.1		 
		 blng_grp_desc=checkForNull(req.getParameter("blngGrpDesc_"+i)); //Added By Shikha For GHL-CRF-0520.1
		 payerGrpCode=checkForNull(req.getParameter("payerGrpCode_"+i));
		 payerGrpDesc=checkForNull(req.getParameter("payerGrpDesc_"+i));
		 payerCode=checkForNull(req.getParameter("payerCode_"+i));
		 payerDesc=checkForNull(req.getParameter("payerDesc_"+i));

	//Added Newly by muthu against 33044
		practitioner_id	=checkForNull(req.getParameter("practitioner_id"+i));
		practitioner_name =checkForNull(req.getParameter("practitioner_name"+i));
	//Added Newly by muthu against 33044
		 
		 strOPYN=checkForNull(req.getParameter("strOPYN_"+i));
		 strEMYN=checkForNull(req.getParameter("strEMYN_"+i));
		 strIPYN=checkForNull(req.getParameter("strIPYN_"+i));
		 strDCYN=checkForNull(req.getParameter("strDCYN_"+i));
		if(packageCode!=null && !(packageCode.equals("")))
			{
		 //System.out.println("inside Pooulatedate loop"+patientId);
			tabdata.put("packageCode"+i,packageCode);
			tabdata.put("packageDesc"+i,packageDesc);
			tabdata.put("fromDate"+i,fromDate);
			tabdata.put("toDate"+i,toDate);
			tabdata.put("pkgAmt"+i,pkgAmt);
			tabdata.put("addlCharge"+i,addlCharge);//Added V171212-Gayathri/MMS-DM-CRF-0118
			tabdata.put("episodeType"+i,episodeType);
			//tabdata.put("encounterId"+i,encounterId);
			tabdata.put("blng_class_code"+i,blng_class_code);
			tabdata.put("blng_class_desc"+i,blng_class_desc);
			tabdata.put("blng_grp_code"+i,blng_grp_code); //Added By Shikha For GHL-CRF-0520.1
			tabdata.put("blng_grp_desc"+i,blng_grp_desc); //Added By Shikha For GHL-CRF-0520.1
			tabdata.put("payerGrpCode"+i,payerGrpCode);
			tabdata.put("payerGrpDesc"+i,payerGrpDesc);
			tabdata.put("payerCode"+i,payerCode);
			tabdata.put("payerDesc"+i,payerDesc);


			//Added Newly by muthu against 33044
			tabdata.put("practitioner_id"+i,practitioner_id);
			tabdata.put("practitioner_name"+i,practitioner_name);
			//Added Newly by muthu against 33044

			tabdata.put("strOPYN"+i,strOPYN);
			tabdata.put("strEMYN"+i,strEMYN);
			tabdata.put("strIPYN"+i,strIPYN);
			tabdata.put("strDCYN"+i,strDCYN);
			tabdata.put("totalRecords",totalRecords);
			}
					
		}
		/*  Karthik added for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  - Starts*/
		tabdata.put("packageSubscriptionAssociationEncounters",session.getAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS"));		
		tabdata.put("functionId",checkForNull(req.getParameter("function_id")));	
		tabdata.put("siteParam",checkForNull(req.getParameter("siteParam")));			
		/*  Karthik added for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  - Ends*/
		tabdata.put("packageAssociationExistingPackages",session.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG"));		
		//System.out.println("populateTabData Called tabdata:"+tabdata);
		return tabdata;
		
	}

	private void insertData(HttpServletRequest req,HttpServletResponse res)
	{
		try 
		{	
			int reqId = 0;
			tabdata=new HashMap();
		//	java.util.Locale loc = new java.util.Locale(locale);//unused variable		
			tabdata = populateTabData(req,res);			
			System.err.println("tabdata :: PkgSubscriptionServlet.java"+tabdata);
			boolean local_ejbs = false;
			//System.out.println("ejb call 0");
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;
			//System.out.println("ejb call 1");
			Object home =ServiceLocator.getInstance().getHome("java:comp/env/PkgSubscription",eBL.PkgSubscription.PkgSubscriptionLocalHome.class, local_ejbs);	
			//System.out.println("ejb call 2");

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home, null);
			//System.out.println("ejb call 3");

			Object argArray[] = new Object[2];

			//System.out.println("ejb call 4");
					
			argArray[0] = p;
			argArray[1] = tabdata;
			
			
			//System.out.println("ejb call 5");
			Class[] paramArray = new Class[2];

			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();	
			
			

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass().getMethod("insert", paramArray)).invoke(busObj, argArray);	
			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
			//System.out.println("ejb results :"+results);

			boolean inserted = (((Boolean) results.get("status")).booleanValue());
			//System.out.println("ejb inserted :"+inserted);
			String error = (String) results.get("error");
			//System.out.println("ejb error :"+error);
			String message = (String) results.get("message");
			//System.out.println("ejb message :"+message);
			String sys_error = (String) results.get("sys_error");
			//System.out.println("ejb sys_error :"+sys_error);
			String error_value="0";
			String strPackageSeqno = (String) results.get("strPackageSeqno");
			
			//Added for Request ID
			if(results.containsKey("requestId")){
				try{
					reqId = (Integer) results.get("requestId");
				}
				catch(Exception e){
					reqId = 0;
					System.err.println("The Exception in getting Req Id->"+e);
				}
				results.remove("requestId");
			}
			//Added for Request ID
			//System.out.println("ejb packageSeqno :"+strPackageSeqno);
			out.println("<script>parent.frames[1].frames[0].document.frmPkgDefHeader.strPackageSeqno.value='"+strPackageSeqno+"';</script>");
			if(inserted)
			{
				//out.println("<script>alert('success')</script>");				
				//out.println("<script>window.close();</script>");				
				error_value = "1" ;		
				
				Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				//String success_msg=(String)messageHashtable.get("message");		//unused variable
				out.println("<script language='javascript' src='../../eCommon/js/jquery.js'></script> ");
				out.println("<script language='javascript' src='../js/PkgSubs.js'></script> ");
				out.println("<script language='JavaScript'>parent.messageFrame.location.href='../eCommon/jsp/error.jsp' ; console.log('parent.frames[1].frames[0]----'+parent.parent.frames[1].frames[0]);console.log('parent.frames[1]----'+parent.parent.frames[1]);parent.frames[1].frames[0].onSuccess1('"+reqId+"'); </script>");			

		
			}
			else
			{				
				if(!sys_error.equals(""))
				{
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( sys_error.toString(),"UTF-8" ) +"&err_value="+error_value);
				}
				else if(!message.equals(""))
				{
					
					Hashtable messageHashtable=new Hashtable();
					String msg="";
					
					if(message.indexOf("|") != (-1)){
						StringTokenizer	msgIds=new StringTokenizer(message,"|");
						while(msgIds.hasMoreTokens())
						{
							messageHashtable=MessageManager.getMessage(locale,msgIds.nextToken(),"BL");
							msg=msg+(String)messageHashtable.get("message")+"<br>";													
						}
						
					}else{								
						messageHashtable=MessageManager.getMessage(locale,message,"BL");
						msg=msg+(String)messageHashtable.get("message");
					
					}		

					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) +"&err_value="+error_value);
				}
				else if(!error.equals(""))
				{						
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
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

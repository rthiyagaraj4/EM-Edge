/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
  /*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           NandhiniM
 */
package eBL;

import java.lang.reflect.Method;
import java.net.URLEncoder;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;

public class MultiPkgDiscServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	HashMap results;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String locale="en";	
	HttpSession session;
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
		//String locale = this.p.getProperty("LOCALE") ;

		Connection connection = null;
		CallableStatement callIns = null;
		CallableStatement callUpd = null;

		try
		{
		 connection   =   ConnectionManager.getConnection(p);

		 callIns = connection.prepareCall("{ call blpackage.insertmultipkgdiscount  (?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?,?)}");

		 callUpd = connection.prepareCall("{ call blpackage.updatemultipkgdiscount  (?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,sysdate,?,?,?,?,?)}");
		

		this.out = res.getWriter();
		String operation = req.getParameter("mode");
		if ( operation.equals("insert"))   insert(req, res,callIns);
		if ( operation.equals("modify"))    modify(req, res,callUpd);
			connection.commit();
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(connection !=null)  ConnectionManager.returnConnection(connection);
			//Added against V210416
			try{
			if(callIns!=null) callIns.close();
			}
			catch(Exception e)
			{
				System.err.println("Exception in doPost"+e);
				e.printStackTrace();
			}//Added against V210416
		}
	}


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		doPost(req,res);
	}


	private void modify(HttpServletRequest req, HttpServletResponse res,CallableStatement callUpd)
	{
		try{
			String operatingfacilityid=checkForNull(req.getParameter("facility_id"));	
			String blnggrpid=checkForNull(req.getParameter("billingGrpCode"));		
			String custgrpcode=checkForNull(req.getParameter("payergrpCode"));
			String custcode = checkForNull(req.getParameter("payerCode"));
			String policytypecode = checkForNull(req.getParameter("policyTypeCode"));
			//String validFrom = checkForNull(req.getParameter("fromDate_"));
			String validFrom = checkForNull(req.getParameter("fromDateHid"));//Added V190528-Dhananjay/MMS-DM-CRF-130/70574
			String validTo = checkForNull(req.getParameter("toDate_"));
			String applicableTo = checkForNull(req.getParameter("applicalbleTo"));
			String multiPkgDisc = checkForNull(req.getParameter("multipkgdisc"));
			String multiPkgDiscYN = checkForNull(req.getParameter("MultiPkgDiscYN"));
			String pkgCustDiscYN = checkForNull(req.getParameter("PkgCustDiscYN"));
			String pkgAdDiscYN = checkForNull(req.getParameter("PkgAdDiscYN"));
			
			if("".equals(multiPkgDiscYN) ){
				multiPkgDiscYN = "N";
			}
			if("".equals(pkgCustDiscYN) ){
				pkgCustDiscYN = "N";
			}
			if("".equals(pkgAdDiscYN) ){
				pkgAdDiscYN = "N";
			}
			
			String languageid = checkForNull(req.getParameter("locale"));
			String addedbyid = login_user;
			String addedfacilityid	= facilityId;
			String addedwsno	= client_ip_address;		
			
			validFrom = com.ehis.util.DateUtils.convertDate((String)validFrom,"DMY",locale,"en");
			validTo = com.ehis.util.DateUtils.convertDate((String)validTo,"DMY",locale,"en");
			
		
			callUpd.setString(1,operatingfacilityid);
			callUpd.setString(2,blnggrpid);
			callUpd.setString(3,custgrpcode);
			callUpd.setString(4,custcode);
			callUpd.setString(5,policytypecode);
			callUpd.setString(6,validFrom);
			callUpd.setString(7,validTo);
			callUpd.setString(8,applicableTo);
			callUpd.setString(9,multiPkgDisc);
			callUpd.setString(10,multiPkgDiscYN);
			callUpd.setString(11,pkgCustDiscYN);
			callUpd.setString(12,pkgAdDiscYN);
			callUpd.setString(13,addedbyid);
			callUpd.setString(14,addedwsno);
			callUpd.setString(15,addedfacilityid);			

			callUpd.registerOutParameter(16,java.sql.Types.VARCHAR);       	
			callUpd.registerOutParameter(17,java.sql.Types.VARCHAR); 	
			callUpd.registerOutParameter(18,java.sql.Types.VARCHAR); 	

			callUpd.execute();
			String str_error_level		=	callUpd.getString(16);
			String str_sysmesage_id	=	callUpd.getString(17);					
			String str_error_text		=	callUpd.getString(18);
			
			str_sysmesage_id=str_sysmesage_id==null?"":str_sysmesage_id;
			str_error_level=str_error_level==null?"":str_error_level;
			str_error_text=str_error_text==null?"":str_error_text;
			String msg="";
			 if(!str_sysmesage_id.equals(""))
			 {
				Hashtable messageHashtable=new Hashtable();				
				StringTokenizer message_st = new StringTokenizer(str_sysmesage_id,"|");
				while(message_st.hasMoreTokens())
				{
					String sysMessageId = message_st.nextToken();
					messageHashtable=MessageManager.getMessage(locale,sysMessageId,"BL");
					msg=msg+(String)messageHashtable.get("message")+"<br>";
				}	   
			 }
			 if(!("".equals(str_error_level) && "".equals(str_error_text))){
				 msg=msg+str_error_text;
			 }
			
			 if(!("".equals(msg))){
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) +"&err_value=2");
			 }
			 else			
			{
				Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String success_msg=(String)messageHashtable.get("message");
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value=1");
			}		 
			System.err.println("MultiPkgDiscServlet inside Modify  after redirect");
		}
		catch ( Exception e ){
			out.println(" Exception raised ...So Record Not updatedFoll: Error Received : "+e.toString());
			//out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();
		}
		//Added against V210416
		finally{
				
				try{
					if(callUpd!=null) callUpd.close();
			}
			catch(Exception e)
			{
				System.err.println("exception in modify"+e);
				e.printStackTrace();
			}//Added against V210416
				
			}
	}

	private void insert(HttpServletRequest req, HttpServletResponse res,CallableStatement callIns)
	{
		try{
				System.err.println("MultiPkgDiscServlet inside");
				String operatingfacilityid=checkForNull(req.getParameter("facility"));		
				String blnggrpid=checkForNull(req.getParameter("billingGrpCode"));				
				String custgrpcode=checkForNull(req.getParameter("payergrpCode"));
				String custcode = checkForNull(req.getParameter("payerCode"));
				String policytypecode = checkForNull(req.getParameter("policyTypeCode"));
				String validFrom = checkForNull(req.getParameter("fromDate_"));
				String validTo = checkForNull(req.getParameter("toDate_"));
				String applicableTo = checkForNull(req.getParameter("applicalbleTo"));
				String multiPkgDisc = checkForNull(req.getParameter("multipkgdisc"));
				String multiPkgDiscYN = checkForNull(req.getParameter("MultiPkgDiscYN"));
				String pkgCustDiscYN = checkForNull(req.getParameter("PkgCustDiscYN"));
				String pkgAdDiscYN = checkForNull(req.getParameter("PkgAdDiscYN"));
				System.err.println("234, callIns, operatingfacilityid==>"+operatingfacilityid);
				System.err.println("234, callIns, blnggrpid==>"+blnggrpid);
				System.err.println("234, callIns, custgrpcode==>"+custgrpcode);
				System.err.println("234, callIns, custcode==>"+custcode);
				System.err.println("234, callIns, policytypecode==>"+policytypecode);
				System.err.println("234, callIns, validFrom==>"+validFrom);
				System.err.println("234, callIns, validTo==>"+validTo);
				System.err.println("234, callIns, applicableTo==>"+applicableTo);
				System.err.println("234, callIns, multiPkgDisc==>"+multiPkgDisc);			
				
				if("".equals(multiPkgDiscYN) ){
					multiPkgDiscYN = "N";
				}
				if("".equals(pkgCustDiscYN) ){
					pkgCustDiscYN = "N";
				}
				if("".equals(pkgAdDiscYN) ){
					pkgAdDiscYN = "N";
				}

				System.err.println("234, callIns, multiPkgDiscYN==>"+multiPkgDiscYN);
				System.err.println("234, callIns, pkgCustDiscYN==>"+pkgCustDiscYN);
				System.err.println("234, callIns, pkgAdDiscYN==>"+pkgAdDiscYN);

				validFrom = com.ehis.util.DateUtils.convertDate((String)validFrom,"DMY",locale,"en");
				validTo = com.ehis.util.DateUtils.convertDate((String)validTo,"DMY",locale,"en");
							
				String addedbyid = login_user;
				String addedfacilityid	= facilityId;
				String addedwsno	= client_ip_address;
				
				System.err.println("265,addedbyid/addedfacilityid/addedwsno/status"+addedbyid+"/"+addedfacilityid+"/"+addedwsno+"/");
				System.err.println("265,facid/billid/cuscod/patclas/polcod/cusgrcod/lang/add_fac/priorityno>>>>"+operatingfacilityid+"/"+blnggrpid+"/"+custcode+"/"+custgrpcode+"/"+policytypecode+"/"+validFrom+"/"+validTo+"/"+applicableTo+"/"+multiPkgDisc+"/"+multiPkgDiscYN+"/"+pkgCustDiscYN+"/"+pkgAdDiscYN);
								
				callIns.setString(1,operatingfacilityid);
				callIns.setString(2,blnggrpid);
				callIns.setString(3,custgrpcode);
				callIns.setString(4,custcode);
				callIns.setString(5,policytypecode);
				callIns.setString(6,validFrom);
				callIns.setString(7,validTo);
				callIns.setString(8,applicableTo);
				callIns.setString(9,multiPkgDisc);
				callIns.setString(10,multiPkgDiscYN);
				callIns.setString(11,pkgCustDiscYN);
				callIns.setString(12,pkgAdDiscYN);
				callIns.setString(13,addedbyid);
				callIns.setString(14,addedbyid);
				callIns.setString(15,addedwsno);
				callIns.setString(16,addedfacilityid);
				callIns.setString(17,addedwsno);
				callIns.setString(18,addedfacilityid);			

				callIns.registerOutParameter(19,java.sql.Types.VARCHAR);       	
				callIns.registerOutParameter(20,java.sql.Types.VARCHAR); 	
				callIns.registerOutParameter(21,java.sql.Types.VARCHAR); 	

				System.err.println("MultiPkgDiscServlet inside Insert before execute");		
				callIns.execute();
				System.err.println("MultiPkgDiscServlet inside Insert after execute");

				String str_error_level		=	callIns.getString(19);
				String str_sysmesage_id	=	callIns.getString(20);					
				String str_error_text		=	callIns.getString(21);
				System.err.println("298, callUpd, str_error_level==>"+str_error_level);
				System.err.println("298, callUpd, str_sysmesage_id==>"+str_sysmesage_id);
				System.err.println("298, callUpd, str_error_text==>"+str_error_text);
				
				str_sysmesage_id=str_sysmesage_id==null?"":str_sysmesage_id;
				str_error_level=str_error_level==null?"":str_error_level;
				str_error_text=str_error_text==null?"":str_error_text;

				String msg="";				
				 if(!str_sysmesage_id.equals(""))
				 {					
					Hashtable messageHashtable=new Hashtable();
					
					StringTokenizer message_st = new StringTokenizer(str_sysmesage_id,"|");
					while(message_st.hasMoreTokens())
					{
						String sysMessageId = message_st.nextToken();
						messageHashtable=MessageManager.getMessage(locale,sysMessageId,"BL");
						msg=msg+(String)messageHashtable.get("message")+"<br>";
					}
				 }
				 if(!("".equals(str_error_level) && "".equals(str_error_text))){
					 msg=msg+str_error_text;
				 }
				
				 if(!("".equals(msg))){
					 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) +"&err_value=2");
				 }
				else
				{				
					Hashtable messageHashtable=new Hashtable();
					messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
					String success_msg=(String)messageHashtable.get("message");
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value=1");
				}		
				System.err.println("MultiPkgDiscServlet  inside insert  after sendRedirect");
		}
		catch ( Exception e ){
			out.println(" Exception raised ...So Record Not insertedFoll: Error Received : "+e.toString());
			//out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();
		}
	}

	private String checkForNull(String str){
		System.out.println("inside null check");
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String str,String defaultVal){
		System.out.println("inside null check");
		return (!checkForNull(str).equals(""))?str:defaultVal;
	}
}

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.RecordSet;
import eIP.IPOnlineReport.*;
import eCommon.SingleTabHandler.*;
import java.net.URLEncoder;



public class IPOnlineReportServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	String facilityId ;
	String client_ip_address ;
	String transfer_yn		= "N";

	webbeans.eCommon.RecordSet OnlineReportRecordSet;
	HashMap hashData = new HashMap();
	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
{
	session				= req.getSession(false);
	this.p				= (java.util.Properties) session.getValue( "jdbc" ) ;
	this.facilityId		= (String) session.getValue( "facility_id" ) ;
	client_ip_address   = p.getProperty("client_ip_address");
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	try
	{
		this.out = res.getWriter();
		Hashtable htRecord = new Hashtable();
String operation = req.getParameter("operation");
String SelectYNStr				=	checkForNull(req.getParameter("SelectYNStr"));
String SelectYNStrBkg			=	checkForNull(req.getParameter("SelectYNStrBkg"));
String SelectYNStrConf			=	checkForNull(req.getParameter("SelectYNStrConf"));
String SelectYNStrBed			=	checkForNull(req.getParameter("SelectYNStrBed"));
String SelectYNStrWoBed			=	checkForNull(req.getParameter("SelectYNStrWoBed"));
String SelectYNStrDischarge		=	checkForNull(req.getParameter("SelectYNStrDischarge"));
String SelectYNStrTransReqest		=checkForNull(req.getParameter("SelectYNStrTransReqest"));
String SelectYNStrPrint_on_discharge =checkForNull(req.getParameter("SelectYNStrPrint_on_discharge"));
	
		
		OnlineReportRecordSet	=	(RecordSet)session.getValue("IPOnlineReportRecordSet");
		if(!(SelectYNStr.equals("")))
		{
			StringTokenizer stoken_code = new StringTokenizer(SelectYNStr,"~");

			int count_code		=	stoken_code.countTokens();
			for(int i=0;i<count_code;i++)
			{

				String sel_code		=	stoken_code.nextToken();
				String index_val	=	sel_code.substring(9);
                int index			=	Integer.parseInt(index_val);
                String booking_yn=getCheckedData(SelectYNStrBkg,"select_booking_yn",index);
				String transfer_confirmation_yn=getCheckedData(SelectYNStrConf,"select_transferConfirmation_yn",index);
				String admission_with_yn=getCheckedData(SelectYNStrBed,"select_admissionWithBed_yn",index);
				String admission_without_yn=getCheckedData(SelectYNStrWoBed,"select_admissionWithoutBed_yn",index);
				String discharge_yn=getCheckedData(SelectYNStrDischarge,"select_discharge_yn",index);
			    String print_on_transfer_request_yn=getCheckedData(SelectYNStrTransReqest,"select_transferrequest_yn",index);
				String print_on_disch_adv_yn=getCheckedData(SelectYNStrPrint_on_discharge,"print_on_disch_adv_yn",index);
			    String associate_yn=getCheckedData(SelectYNStr,"select_yn",index);

                if(booking_yn ==null)booking_yn="N";
				if(associate_yn ==null)associate_yn="N";

				if(transfer_confirmation_yn==null)transfer_confirmation_yn="N";
				if(admission_with_yn ==null)admission_with_yn="N";
				if(admission_without_yn ==null)admission_without_yn="N";
				if(discharge_yn ==null)discharge_yn="N";
				if(print_on_disch_adv_yn ==null)print_on_disch_adv_yn="N";
				if(print_on_transfer_request_yn ==null)print_on_transfer_request_yn="N";

				htRecord = (java.util.Hashtable) OnlineReportRecordSet.getObject(index);
              	htRecord.put("associate_yn"	,associate_yn);
				htRecord.put("booking_yn" , booking_yn);
				htRecord.put("transferConfirmation_yn" , transfer_confirmation_yn);
				htRecord.put("admissionWithBed_yn" , admission_with_yn);
				htRecord.put("admissionWithoutBed_yn" ,admission_without_yn);
				htRecord.put("discharge_yn" , discharge_yn);
				htRecord.put("print_on_disch_adv_yn" , print_on_disch_adv_yn);
				htRecord.put("print_on_transfer_request_yn" , print_on_transfer_request_yn);
                

				OnlineReportRecordSet.setObject((index),htRecord);
			}
		}

		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		boolean local_ejbs = false;

		hashData.put("facilityId",facilityId); 
		hashData.put("client_ip_address",client_ip_address); 
		hashData.put("nursing_unit_code",checkForNull(req.getParameter("nursing_unit_code"))); 
		hashData.put("operation",operation); 
		//hashData.put("isRecordSelected_YN",isRecordSelected_YN); 

		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPOnlineReport",IPOnlineReportHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[3];
		argArray[0] = p;
		argArray[1] = OnlineReportRecordSet;
		argArray[2] = hashData;

		Class [] paramArray = new Class[3];
		paramArray[0] = p.getClass();
		paramArray[1] = OnlineReportRecordSet.getClass();
		paramArray[2] = hashData.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("InsDelIPOnlineReport",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error		= (String) results.get("error") ;
		String error_value			= "";

		if(inserted)
		{
			error_value="1";
			out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&err_value=" + error_value + "\"</script><body class='message'></html>");
		}
		else
		{
			error_value="0";
			out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&err_value=" + error_value + "\"</script><body class='message'></html>");
		}

		htRecord.clear();
		results.clear();

	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally{
		try
		{
			OnlineReportRecordSet.clearAll();	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
{
	try
	{
		doPost(req, res);
	}
	catch(Exception e)	{e.printStackTrace();	}
}


public String getCheckedData(String SelectBKG, String name,int i)
{
	String temp="N";
	int len=0;
	if(name != null)
		len=name.length();

	StringTokenizer stoken_code = new StringTokenizer(SelectBKG,"~");


	int count_bkg		=	stoken_code.countTokens();
	int index_bkgInt=0;
	for(int j=0;j<count_bkg;j++)
	{
		String sel_code		=	stoken_code.nextToken();
		String index_bkg	=	sel_code.substring(len);
		if(index_bkg!=null)
		 index_bkgInt		=	Integer.parseInt(index_bkg);

		if(i == index_bkgInt)
		{
			temp = "Y";
			break;
		}
	}
	return temp;
}

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForDefault(String inputString, String Default)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? Default : inputString);
	}

}

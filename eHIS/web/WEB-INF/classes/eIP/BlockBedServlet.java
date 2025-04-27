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
import java.sql.PreparedStatement;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.rmi.*;
import java.text.*;
import webbeans.eCommon.*;
import eIP.IPBlockBed.* ;
import com.ehis.util.*;

public class BlockBedServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	String facilityId;
	String client_ip_address ;
	String auto_gen_yn;

	String req_nursing_unit_code;
	String req_bed_no;

	String blocked_from_date_time;
	String blocked_until_date_time;
	String blocking_remarks;
	String bed_booking_ref_no;

	Connection con			=  null;
	Statement stmt_proc     =  null;
	ResultSet rs_proc		=  null;
	String locale			= "" ;
	Hashtable retHash		=  null;
	String messageDate		=  "";
	StringBuffer stringBuffer = new StringBuffer("");

	HttpSession session;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.out				= res.getWriter();
		session					= req.getSession(false);
		this.p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId			= (String) session.getValue("facility_id") ;
		client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");
		try
		{
			insertBLockBed(req, res);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	private void insertBLockBed(HttpServletRequest request, HttpServletResponse res)
	{
		String overriddenStatus	=	"";
		StringBuffer sql_proc = new StringBuffer();		
		try
		{

			bed_booking_ref_no = checkForNull(request.getParameter("blocking_ref_no"));

			if(bed_booking_ref_no.equals(""))
				auto_gen_yn="N";
			else
				auto_gen_yn="Y";
			req_nursing_unit_code		=	checkForNull(request.getParameter("nursing_unit"));
			req_bed_no					=	checkForNull(request.getParameter("bed_no"));
			blocked_from_date_time		=	checkForNull(request.getParameter("from_date"));
			blocked_until_date_time		=	checkForNull(request.getParameter("until_date"));
			
			blocking_remarks			=	checkForNull(request.getParameter("remarks"));
			con							=	ConnectionManager.getConnection(request);
			blocking_remarks			=	singleToDoubleQuotes(blocking_remarks);
			
			blocked_from_date_time = DateUtils.convertDate(blocked_from_date_time,"DMYHM",locale,"en");
			blocked_until_date_time = DateUtils.convertDate(blocked_until_date_time,"DMYHM",locale,"en");

			
			

			retHash						=	new Hashtable();
			if(!checkSystemDateGreater(blocked_from_date_time))
			{
					MessageManager msg		=	new MessageManager();
					retHash					=	msg.getMessage(locale,"FROM_DATE_LESS_SYSDATE","SM");
					messageDate				=	(String)retHash.get("message");
					String error_value		=	"0";
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( messageDate,"UTF-8" ) + "&err_value=" + error_value);
					return;
			}
			else
			{
				boolean result = true;
				try
				{

					stringBuffer.delete(0,stringBuffer.length());
					stringBuffer.append("select OCCUPYING_PATIENT_ID from ip_nursing_unit_bed where facility_id = '"+facilityId+"' and NURSING_UNIT_CODE = '"+req_nursing_unit_code+"' and bed_no= '"+req_bed_no+"'");

					if(rs_proc != null) rs_proc.close();
					if(stmt_proc != null) stmt_proc.close();
					stmt_proc = con.createStatement();
					rs_proc   = stmt_proc.executeQuery(stringBuffer.toString());
			
					String Occuppying_pat_id = "";

					if(rs_proc !=null && rs_proc.next())
					{
						Occuppying_pat_id	= checkForNull(rs_proc.getString("OCCUPYING_PATIENT_ID"));
					}

					if(!(Occuppying_pat_id.equals("")||(Occuppying_pat_id == null)))
					{
						MessageManager msg		=	new MessageManager();
						retHash					=	msg.getMessage(locale,"OCCUPIED_BED","IP");
						messageDate				=	(String)retHash.get("message");
						String error_value		=	"0";
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( messageDate,"UTF-8" ) + "&err_value=" + error_value);
						result = false;
						return;
					}
				}
			catch(Exception e)
			{
				e.printStackTrace(System.out);
				result = false;
			}
			
			if(result)
			{
				sql_proc.append("select block_bed_status('"+ facilityId +"','" +req_nursing_unit_code+"','"+req_bed_no+"','"+blocked_from_date_time+"','"+blocked_until_date_time+"') from dual");

				if(rs_proc != null) rs_proc.close();
				if(stmt_proc != null) stmt_proc.close();

				stmt_proc = con.createStatement();
				rs_proc   = stmt_proc.executeQuery(sql_proc.toString());
				if(rs_proc != null)
				while(rs_proc.next())
					overriddenStatus	=	rs_proc.getString(1);
				//sql_proc.append("overriddenStatus::"+overriddenStatus);
				if(overriddenStatus == null)	overriddenStatus="";

			
				if(overriddenStatus.equals("T"))
				{
					MessageManager msg= new MessageManager();
					retHash = msg.getMessage(locale,"OVERLAP_BLOCK_TIME","IP");
					String message		= (String)retHash.get("message");
					String error_value	=	"0";
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( message,"UTF-8" ) + "&err_value=" + error_value);
					return;
				}
				else if(overriddenStatus.equals("F"))
				{

					java.util.HashMap hashData = new java.util.HashMap();
					
					hashData.put("facilityId",facilityId);
					hashData.put("auto_gen_yn",auto_gen_yn);
					hashData.put("blocking_type",checkForNull(request.getParameter("blocktype")));
					hashData.put("bed_booking_ref_no",checkForNull(request.getParameter("blocking_ref_no")));
					hashData.put("req_nursing_unit_code",req_nursing_unit_code);
					hashData.put("req_bed_no",req_bed_no);
					hashData.put("req_room_no",checkForNull(request.getParameter("room_no")));
					hashData.put("req_bed_class_code",checkForNull(request.getParameter("bed_class")));
					hashData.put("req_bed_type_code",checkForNull(request.getParameter("bed_type")));
					hashData.put("blocked_from_date_time",blocked_from_date_time);
					hashData.put("blocked_until_date_time",blocked_until_date_time);
					hashData.put("blocking_remarks",blocking_remarks);
					hashData.put("override_yn",checkForNull(request.getParameter("override"),"N"));
					hashData.put("client_ip_address",client_ip_address);

					boolean local_ejbs = false;
					
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPBlockBed",IPBlockBedHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					
					Object argArray[] = new Object[2];
					argArray[0] = p;
					argArray[1] = hashData;
					
					Class [] paramArray = new Class[2];
					paramArray[0] = p.getClass();
					paramArray[1] = hashData.getClass();
				
					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertIPBooking",paramArray)).invoke(busObj,argArray);

					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

					String error = (String) results.get("error") ;
					String error_value = "0";
					if ( inserted )
					{
						 error_value = "1" ;
 	 					 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=" + error_value);
					}
					else
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=" + error_value);

					hashData.clear();
					results.clear();
				}
				if (stmt_proc!=null) stmt_proc.close();
				if (rs_proc!=null) rs_proc.close();
			}
			}
		
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			if(con != null)      ConnectionManager.returnConnection(con,request);
		}
	}
	public String singleToDoubleQuotes(String strDB)throws Exception
	{
		/*String strModified="";
		try
		{
			if((strDB != null) ||(strDB !=""))
			{
				StringBuffer stringbuffer = new StringBuffer(strDB);
				int i = 0;
				for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
				{
					i = strDB.indexOf('\'', i);
					stringbuffer.insert(i + j, "'");
					i++;
				}
				strModified=stringbuffer.toString();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		return strModified;
		*/
		if(strDB == null) strDB = "" ;
		 return strDB.replaceAll("'","''");
	}
	public boolean checkSystemDateGreater(String from_date) throws Exception
	{
		try
		{
			StringTokenizer tok1=new StringTokenizer(from_date," ");
			from_date = tok1.nextToken();
			String from_time = tok1.nextToken();
			StringTokenizer tok=new StringTokenizer(from_date,"/");
			String a[]=new String [3];
			for(int i=0;tok.hasMoreTokens();i++)
				a[i]= tok.nextToken();
			int yr = Integer.parseInt(a[2]);
			int mon = Integer.parseInt(a[1])-1;
			int dt=Integer.parseInt(a[0]);
			tok1=null;
			tok1=new StringTokenizer(from_time,":");
			String a1[]=new String [2];
			for(int i=0;tok1.hasMoreTokens();i++)
			a1[i]= tok1.nextToken();
			int hr = Integer.parseInt(a1[0]);
			int min = Integer.parseInt(a1[1])+1;
			GregorianCalendar currentdate = new GregorianCalendar();
			GregorianCalendar userdate = new GregorianCalendar(yr,mon,dt,hr,min);
			if(userdate.after(currentdate) || userdate.equals(currentdate))
			return true;
			else
			return false;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}

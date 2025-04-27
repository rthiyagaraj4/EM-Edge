/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

import eCommon.SingleTabHandler.*;

public class PractRelationServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
			req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = null;

		try
		{
			out = res.getWriter();

			String operation = req.getParameter("mode");

			if ( operation.equals("insert") )   insert(req, res, out);
			if ( operation.equals("modify"))    modify(req, res, out);
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
	
		try
		{
			out = res.getWriter();
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}

	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		Connection con=null;
		ResultSet rs= null;
		PreparedStatement stmt=null;

		String relation_id = "";
		String relation_name = "";
		String enabled = "" ;
		String pract_reln_seq = "" ;
		String direct_yn = "" ;
		String expiry_based = "" ;
		String expiry_rule = "" ;
		String expiry_period = "";
		
		String ip_admit = "" ;
		String ip_attend = "";
		String op_attend  = "";
		String ae_attend = "";
		String nm_attend = "";
		String dc_attend = "";
		String reln_attend = "";
		String ip_default = "";
		String op_default = "";
		String ae_default = "";
		String nm_default = "";
		String dc_default = "";
		String ip_admit_default = "";
		String referal_default = "";

		String facilityId ;
		String client_ip_address ;

		StringBuffer sql=new StringBuffer();

		HttpSession session;
		session = req.getSession(false);

		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		
		facilityId			= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= p.getProperty("client_ip_address");
		
		String locale		= (String) p.getProperty("LOCALE");
		
		try
		{
			relation_id			=	req.getParameter("relation_id1");
			pract_reln_seq		=	req.getParameter("pract_reln_seq");
			//relation_name		=	req.getParameter("relation_name1");
			relation_name		=	req.getParameter("relation_name");
			enabled					=	req.getParameter("enabled") == null ? "D" : req.getParameter("enabled");
			String addedById				=	p.getProperty( "login_user" ) ;
			String modifiedById				=	addedById ;
			String addedFacilityId			=	facilityId;
			String modifiedFacilityId		=	addedFacilityId ;
			String addedAtWorkstation		=	client_ip_address;
			String modifiedAtWorkstation	=	addedAtWorkstation ;

			ip_admit			= req.getParameter("ip_admit1");
			ip_attend			= req.getParameter("ip_attend1");
			op_attend			= req.getParameter("op_attend1");
			ae_attend			= req.getParameter("ae_attend1");
			dc_attend			= req.getParameter("dc_attend1");
			nm_attend			= req.getParameter("nm_attend1");
			reln_attend			= req.getParameter("reln_attend1");
			ip_admit_default	= req.getParameter("ip_admit_dflt");
			ip_default			= req.getParameter("ip_attend_dflt");
			op_default			= req.getParameter("op_attend_dflt");
			ae_default			= req.getParameter("ae_attend_dflt");
			dc_default			= req.getParameter("dc_attend_dflt");
			nm_default			= req.getParameter("nm_attend_dflt");
			referal_default		= req.getParameter("reln_attend_dflt");
			direct_yn			= req.getParameter("direct_yn1");
			expiry_based		= req.getParameter("expiry_based1");
			expiry_rule			= req.getParameter("expiry_rule1");
			expiry_period		= req.getParameter("expiry_period");

			if(pract_reln_seq ==null) pract_reln_seq ="";
			if(ip_admit == null || ip_admit.equals("")) ip_admit="N";
			if(ip_attend==null) ip_attend="N";
			if(op_attend==null) op_attend="N";
			if(ae_attend==null) ae_attend="N";
			if(dc_attend==null) dc_attend="N";
			if(nm_attend==null) nm_attend="N";
			if(reln_attend==null) reln_attend="N";
			if(ip_admit_default == null || ip_admit_default.equals("")) ip_admit_default="N";
			if(ip_default==null) ip_default="N";
			if(op_default==null) op_default="N";
			if(ae_default==null) ae_default="N";
			if(dc_default==null) dc_default="N";
			if(referal_default==null) referal_default="N";
			if(direct_yn==null) direct_yn="N";
			if(expiry_based==null) expiry_based="N";
			if(expiry_rule==null) expiry_rule="";
			if(expiry_period==null) expiry_period="";
			//if(enabled == null )enabled="D";
			
			int count=0;
			int count1=0;
			int count2=0;
			int count3=0;
			int count4=0;
			int count5=0;
			int count6=0;
			int count7=0; 

			try
			{
				con=ConnectionManager.getConnection(req);
				
				if(sql.length() > 0) 
					sql.delete(0,sql.length());

				sql.append("select count(*) from ca_pract_reln  where PRACT_RELN_SEQ = ? ");
					
				stmt=con.prepareStatement(sql.toString());
				stmt.setString(1,pract_reln_seq);
				rs=stmt.executeQuery();
				rs.next();
				count=rs.getInt(1);

				if ( count > 1 )  
				{
					String error = getMessage(locale, "DUPLICATE_SEQUENCE_NUMBER","CA");
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") );
					return ;
				}

				if(sql.length() > 0) 
					sql.delete(0,sql.length());

				if(ip_admit_default.equals("Y"))
				{	
					if(rs != null)rs.close();
					if(stmt != null)stmt.close();

					sql.append(" select count(*) from   ca_pract_reln ");
					sql.append(" where  pract_reln_id!=? and dflt_ip_admit_phys_yn ='Y' ");
					sql.append(" and lifetime_or_encntr = 'E' ");
					
					stmt=con.prepareStatement(sql.toString());
					stmt.setString	( 1, relation_id ) ;
					rs=stmt.executeQuery();
					rs.next();
					count1=rs.getInt(1);
				}
				
				if(sql.length() > 0) 
					sql.delete(0,sql.length());

				if (ip_default.equals("Y"))
				{	
					if(rs != null)rs.close();
					if(stmt != null)stmt.close();
				
					sql.append(" select count(*) from   ca_pract_reln ");
					sql.append(" where  pract_reln_id!=? and dflt_ip_attend_phys_yn ='Y' ");
					sql.append(" and lifetime_or_encntr = 'E' ");
					
					stmt=con.prepareStatement(sql.toString());
					stmt.setString	( 1, relation_id ) ;
					rs=stmt.executeQuery();
					rs.next();
					count2=rs.getInt(1);
				}  
				
				if(sql.length() > 0) 
					sql.delete(0,sql.length());

				if (op_default.equals("Y"))
				{	
					if(rs != null)rs.close();
					if(stmt != null)stmt.close();
				
					sql.append(" select count(*) from   ca_pract_reln ");
					sql.append(" where pract_reln_id!=? and  dflt_op_attend_phys_yn ='Y' ");
					sql.append(" and lifetime_or_encntr = 'E' ");
					
					stmt=con.prepareStatement(sql.toString());
					stmt.setString	( 1, relation_id ) ;
					rs=stmt.executeQuery();
					rs.next();
					count3=rs.getInt(1);
				} 
				
				if(sql.length() > 0) 
					sql.delete(0,sql.length());

				if (ae_default.equals("Y"))
				{	
					if(rs != null)rs.close();
					if(stmt != null)stmt.close();
				
					sql.append(" select count(*) from   ca_pract_reln ");
					sql.append(" where pract_reln_id!=? and  dflt_ae_attend_phys_yn ='Y' ");
					sql.append(" and lifetime_or_encntr = 'E' ");
					
					stmt=con.prepareStatement(sql.toString());
					stmt.setString	( 1, relation_id ) ;
					rs=stmt.executeQuery();
					rs.next();
					count4=rs.getInt(1);
				} 
				
				if(sql.length() > 0) 
					sql.delete(0,sql.length());

				if (nm_default.equals("Y"))
				{	
					if(rs != null)rs.close();
					if(stmt != null)stmt.close();

					sql.append(" select count(*) from   ca_pract_reln ");
					sql.append(" where pract_reln_id!=? and  dflt_attend_nurse_reln_yn ='Y' ");
					sql.append(" and lifetime_or_encntr = 'E' ");
					
					stmt=con.prepareStatement(sql.toString());
					stmt.setString	( 1, relation_id ) ;
					rs=stmt.executeQuery();
					rs.next();
					count5=rs.getInt(1);
				} 
				
				if(sql.length() > 0) 
					sql.delete(0,sql.length());

				if (dc_default.equals("Y"))
				{	
					if(rs != null)rs.close();
					if(stmt != null)stmt.close();
				
					sql.append(" select count(*) from   ca_pract_reln ");
					sql.append(" where pract_reln_id!=? and  dflt_dc_attend_phys_yn ='Y' ");
					sql.append(" and lifetime_or_encntr = 'E' ");
					
					stmt=con.prepareStatement(sql.toString());
					stmt.setString	( 1, relation_id ) ;
					rs=stmt.executeQuery();
					rs.next();
					count6=rs.getInt(1);
				} 
				
				if(sql.length() > 0) 
					sql.delete(0,sql.length());

				if (referal_default.equals("Y"))
				{	
					if(rs != null)rs.close();
					if(stmt != null)stmt.close();
				
					sql.append(" select count(*) from   ca_pract_reln ");
					sql.append(" where pract_reln_id !=? and  dflt_referal_reln_yn ='Y' ");
					sql.append(" and lifetime_or_encntr = 'E' ");
					
					stmt=con.prepareStatement(sql.toString());
					stmt.setString	( 1, relation_id ) ;
					rs=stmt.executeQuery();
					rs.next();
					count7=rs.getInt(1);
				} 

				if ( count1>0 || count2>0 || count3>0 || count4>0 || count5>0 || count6>0 || count7>0)  
				{
					String error = getMessage(locale, "CODE_ALREADY_EXISTS","Common");
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") );
					return ;
				}
				else
				{
					HashMap tabdata=new HashMap();
					
					tabdata.put("PRACT_RELN_ID",relation_id); 
					tabdata.put("PRACT_RELN_NAME",relation_name);
					tabdata.put("EFF_STATUS",enabled);
					tabdata.put("IP_ADMIT_PHYS_YN",ip_admit);
					tabdata.put("IP_ATTEND_PHYS_YN",ip_attend);
					tabdata.put("OP_ATTEND_PHYS_YN",op_attend);
					tabdata.put("AE_ATTEND_PHYS_YN",ae_attend);
					tabdata.put("DC_ATTEND_PHYS_YN",dc_attend);
					tabdata.put("ATTEND_NURSE_RELN_YN",nm_attend);
					tabdata.put("REFERAL_RELN_YN",reln_attend);
					
					if(!pract_reln_seq.equals(""))
						tabdata.put("PRACT_RELN_SEQ",new Integer(Integer.parseInt(pract_reln_seq)));

					tabdata.put("EXPIRY_BASED_YN",expiry_based);
					tabdata.put("EXPIRY_RULE",expiry_rule);
					
					if(!expiry_period.equals(""))
						tabdata.put("EXPIRY_PERIOD",new Integer(Integer.parseInt(expiry_period)));

					tabdata.put("DIRECT_YN",direct_yn);
					tabdata.put("DFLT_IP_ADMIT_PHYS_YN",ip_admit_default);
					tabdata.put("DFLT_IP_ATTEND_PHYS_YN",ip_default);
					tabdata.put("DFLT_OP_ATTEND_PHYS_YN",op_default);
					tabdata.put("DFLT_AE_ATTEND_PHYS_YN",ae_default);
					tabdata.put("DFLT_DC_ATTEND_PHYS_YN",dc_default);
					tabdata.put("DFLT_REFERAL_RELN_YN",referal_default);
					tabdata.put("DFLT_ATTEND_NURSE_RELN_YN",nm_default);
					tabdata.put("MODIFIED_BY_ID",modifiedById);
					tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
					tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
					
					HashMap condflds=new HashMap();
					condflds.put("PRACT_RELN_ID",relation_id);

					String tabname= "CA_PRACT_RELN";
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
										
					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					argArray = null;
					paramArray = null;
					tabdata.clear();
					condflds.clear();

					boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

					String error = (String) results.get("error") ;
					String error_value = "0" ;

					if ( inserted )
						 error_value = "1" ;

					results.clear();
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
				}
			
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
		}
		catch( Exception ei)
		{
			//out.println("Exception @ Modify PractRelation"+ei.toString());//common-icn-0181
			ei.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,req);
		}
	}
	catch ( Exception e )
	{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
			out.println( "Values sent are : <br>" ) ;
			out.println( relation_id+" "+relation_name+" "+enabled );
	}
}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}

	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		Connection con=null;
		ResultSet rs= null;
		PreparedStatement stmt=null;

		String relation_id = "";
		String relation_name = "";
		String enabled = "" ;
		String pract_reln_seq = "" ;
		String relationship_type = "" ;
		String direct_yn = "" ;
		String expiry_based = "" ;
		String expiry_rule = "" ;
		String expiry_period = "";
		
		String ip_admit = "" ;
		String ip_attend = "";
		String op_attend  = "";
		String ae_attend = "";
		String nm_attend = "";
		String dc_attend = "";
		String reln_attend = "";
		String ip_default = "";
		String op_default = "";
		String ae_default = "";
		String nm_default = "";
		String dc_default = "";
		String ip_admit_default = "";
		String referal_default = "";
		String facilityId ;
		String client_ip_address ;

		StringBuffer sql=new StringBuffer();

		HttpSession session;
		session = req.getSession(false);

		p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId			= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= p.getProperty("client_ip_address");
		String locale		= (String) p.getProperty("LOCALE");
		
		try
		{
			relation_id				=	req.getParameter("relation_id");
			relation_name			=	req.getParameter("relation_name");
			enabled					=	req.getParameter("enabled") == null ? "D" : req.getParameter("enabled");
			pract_reln_seq			=	req.getParameter("pract_reln_seq");
			relationship_type		=	req.getParameter("nature");
			direct_yn				=	req.getParameter("direct_yn");
			expiry_based			=	req.getParameter("expiry_based1");
			expiry_rule				=	req.getParameter("expiry_rule");
			expiry_period			=	req.getParameter("expiry_period");
			ip_admit				=	req.getParameter("ip_admit1");
			ip_attend				=	req.getParameter("ip_attend1");
			op_attend				=	req.getParameter("op_attend1");
			ae_attend				=	req.getParameter("ae_attend1");
			dc_attend				=	req.getParameter("dc_attend1");
			nm_attend				=	req.getParameter("nm_attend1");
			reln_attend				=	req.getParameter("reln_attend1");
			ip_admit_default		=	req.getParameter("ip_admit_dflt");
			ip_default				=	req.getParameter("ip_attend_dflt");
			op_default				=	req.getParameter("op_attend_dflt");
			ae_default				=	req.getParameter("ae_attend_dflt");
			dc_default				=	req.getParameter("dc_attend_dflt");
			nm_default				=	req.getParameter("nm_attend_dflt");
			referal_default			=	req.getParameter("reln_attend_dflt");

			if(pract_reln_seq ==null) pract_reln_seq ="";
			if(direct_yn==null) direct_yn="N";
			if(expiry_based==null) expiry_based="N";
			if(expiry_rule==null) expiry_rule="";
			if(expiry_period==null) expiry_period="";
			if(ip_admit == null || ip_admit.equals("")) ip_admit="N";
			if(ip_attend==null || ip_attend.equals("")) ip_attend="N";
			if(op_attend==null || op_attend.equals("")) op_attend="N";
			if(ae_attend==null || ae_attend.equals("")) ae_attend="N";
			if(dc_attend==null || dc_attend.equals("")) dc_attend="N";
			if(nm_attend==null || nm_attend.equals("")) nm_attend="N";
			if(reln_attend==null || reln_attend.equals("")) reln_attend="N";
			if(ip_admit_default == null || ip_admit_default.equals("")) ip_admit_default="N";
			if(ip_default==null || ip_default.equals("")) ip_default="N";
			if(op_default==null || op_default.equals("")) op_default="N";
			if(ae_default==null || ae_default.equals("")) ae_default="N";
			if(dc_default==null || dc_default.equals("")) dc_default="N";
			if(referal_default==null || referal_default.equals("")) referal_default="N";

			int count=0;
			int count1=0;
			int count2=0;
			int count3=0;
			int count4=0;
			int count5=0;
			int count6=0;
			int count7=0; 

			try
			{
				
				con=ConnectionManager.getConnection(req);

				if(sql.length() > 0) sql.delete(0,sql.length());

				sql.append("select count(*) from ca_pract_reln  where PRACT_RELN_SEQ = ? ");
					
				stmt=con.prepareStatement(sql.toString());
				stmt.setString(1,pract_reln_seq);
				rs=stmt.executeQuery();
				rs.next();
				count=rs.getInt(1);

				if ( count > 0 )  
				{
					String error = getMessage(locale, "DUPLICATE_SEQUENCE_NUMBER","CA");
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") );
					return ;
				}

				if(sql.length() > 0) sql.delete(0,sql.length());
				
				if(ip_admit_default.equals("Y"))
				{	
					if(rs != null)rs.close();
					if(stmt != null)stmt.close();
					
					sql.append(" select count(*) from   ca_pract_reln ");
					sql.append(" where  dflt_ip_admit_phys_yn ='Y' ");
					sql.append(" and lifetime_or_encntr = 'E' ");
					
					stmt=con.prepareStatement(sql.toString());
					rs=stmt.executeQuery();
					rs.next();
					count1=rs.getInt(1);
				}
				
				if(sql.length() > 0) sql.delete(0,sql.length());
				
				if (ip_default.equals("Y"))
				{
					if(rs != null)rs.close();
					if(stmt != null)stmt.close();

					sql.append(" select count(*) from   ca_pract_reln ");
					sql.append(" where  dflt_ip_attend_phys_yn ='Y' ");
					sql.append(" and lifetime_or_encntr = 'E' ");
					
					stmt=con.prepareStatement(sql.toString());
					rs=stmt.executeQuery(sql.toString());
					rs.next();
					count2=rs.getInt(1);
				}   
				
				if(sql.length() > 0) sql.delete(0,sql.length());
				
				if (op_default.equals("Y"))
				{	
					if(rs != null)rs.close();
					if(stmt != null)stmt.close();

					sql.append(" select count(*) from   ca_pract_reln ");
					sql.append(" where  dflt_op_attend_phys_yn ='Y' ");
					sql.append(" and lifetime_or_encntr = 'E' ");
					
					stmt=con.prepareStatement(sql.toString());
					rs=stmt.executeQuery(sql.toString());
					rs.next();
					count3=rs.getInt(1);
				} 
				
				if(sql.length() > 0) sql.delete(0,sql.length());
				
				if (ae_default.equals("Y"))
				{	
					if(rs != null)rs.close();
					if(stmt != null)stmt.close();
					
					sql.append(" select count(*) from   ca_pract_reln ");
					sql.append(" where  dflt_ae_attend_phys_yn ='Y' ");
					sql.append(" and lifetime_or_encntr = 'E' ");
					
					stmt=con.prepareStatement(sql.toString());
					rs=stmt.executeQuery(sql.toString());
					rs.next();
					count4=rs.getInt(1);
				} 
				
				if(sql.length() > 0) sql.delete(0,sql.length());
				
				if (nm_default.equals("Y"))
				{	
					if(rs != null)rs.close();
					if(stmt != null)stmt.close();
					
					sql.append(" select count(*) from   ca_pract_reln ");
					sql.append(" where  dflt_attend_nurse_reln_yn ='Y' ");
					sql.append(" and lifetime_or_encntr = 'E' ");
					
					stmt=con.prepareStatement(sql.toString());
					rs=stmt.executeQuery(sql.toString());
					rs.next();
					count5=rs.getInt(1);
				} 
				
				if(sql.length() > 0) sql.delete(0,sql.length());
				
				if (dc_default.equals("Y"))
				{	
					if(rs != null)rs.close();
					if(stmt != null)stmt.close();
					
					sql.append(" select count(*) from   ca_pract_reln ");
					sql.append(" where  dflt_dc_attend_phys_yn ='Y' ");
					sql.append(" and lifetime_or_encntr = 'E' ");
					
					stmt=con.prepareStatement(sql.toString());
					rs=stmt.executeQuery(sql.toString());
					rs.next();
					count6=rs.getInt(1);
				} 
				
				if(sql.length() > 0) sql.delete(0,sql.length());
				
				if (referal_default.equals("Y"))
				{	
					if(rs != null)rs.close();
					if(stmt != null)stmt.close();
					
					sql.append(" select count(*) from   ca_pract_reln ");
					sql.append(" where  dflt_referal_reln_yn ='Y' ");
					sql.append(" and lifetime_or_encntr = 'E' ");
					
					stmt=con.prepareStatement(sql.toString());
					rs=stmt.executeQuery(sql.toString());
					rs.next();
					count7=rs.getInt(1);
				} 

				if ( count1>0 || count2>0 || count3>0 || count4>0 || count5>0 || count6>0 || count7>0)  
				{
					String error = getMessage(locale, "CODE_ALREADY_EXISTS","Common");
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") );
					return ;
				}
				else
				{
					String addedById = p.getProperty( "login_user" ) ;
					String modifiedById = addedById ;
					String addedFacilityId=facilityId;
					String modifiedFacilityId = addedFacilityId ;
					String addedAtWorkstation=client_ip_address;
					String modifiedAtWorkstation = addedAtWorkstation ;

					HashMap tabdata=new HashMap();

					tabdata.put("pract_reln_id",relation_id);
					tabdata.put("lifetime_or_encntr",relationship_type);
					tabdata.put("pract_reln_name",relation_name);
					tabdata.put("eff_status",enabled);
					
					if(!pract_reln_seq.equals(""))
						tabdata.put("pract_reln_seq",new Integer(Integer.parseInt(pract_reln_seq)));

					tabdata.put("expiry_based_yn",expiry_based);
					tabdata.put("expiry_rule",expiry_rule);
					
					if(!expiry_period.equals(""))
						tabdata.put("expiry_period",new Integer(Integer.parseInt(expiry_period)));
					
					tabdata.put("direct_yn",direct_yn);
					tabdata.put("ip_admit_phys_yn",ip_admit);
					tabdata.put("ip_attend_phys_yn",ip_attend);
					tabdata.put("op_attend_phys_yn",op_attend);
					tabdata.put("ae_attend_phys_yn",ae_attend);
					tabdata.put("dc_attend_phys_yn",dc_attend);
					tabdata.put("attend_nurse_reln_yn",nm_attend);
					tabdata.put("referal_reln_yn",reln_attend);
					tabdata.put("DFLT_IP_ADMIT_PHYS_YN",ip_admit_default);
					tabdata.put("DFLT_IP_ATTEND_PHYS_YN",ip_default);
					tabdata.put("DFLT_OP_ATTEND_PHYS_YN",op_default);
					tabdata.put("DFLT_AE_ATTEND_PHYS_YN",ae_default);
					tabdata.put("DFLT_DC_ATTEND_PHYS_YN",dc_default);
					tabdata.put("DFLT_REFERAL_RELN_YN",referal_default);
					tabdata.put("DFLT_ATTEND_NURSE_RELN_YN",nm_default);
					tabdata.put("added_by_id",addedById);
					tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("added_facility_id", facilityId);
					tabdata.put("added_at_ws_no",addedAtWorkstation);
					tabdata.put("modified_by_id",modifiedById);
					tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("modified_facility_id",modifiedFacilityId);
					tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
					

					String dupflds[]={"pract_reln_id"};
					String tabname= "ca_pract_reln";
					boolean local_ejbs = false;
			
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
					Object argArray[] = new Object[4];
					argArray[0] = p;
					argArray[1] = tabdata;
					argArray[2] = dupflds;
					argArray[3] = tabname;

					Class [] paramArray = new Class[4];
					paramArray[0] = p.getClass();
					paramArray[1] = tabdata.getClass();
					paramArray[2] = dupflds.getClass();
					paramArray[3] = tabname.getClass();

					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						argArray = null;
						paramArray = null;
						tabdata.clear();
		
					boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

					String error = (String) results.get("error") ;
					String error_value = "0" ;
					
					if ( inserted )
						 error_value = "1" ;
					
					results.clear();
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
				}
				
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}
			catch( Exception e)
			{
				e.printStackTrace();
				//out.println("Exception:  "+e.toString());//common-icn-0181
				
			}
			finally
			{
				if(con != null) ConnectionManager.returnConnection(con,req);
			}
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
			out.println( "Values sent are : <br>" ) ;
			out.println( relation_id+" "+relation_name+" "+enabled+" "+pract_reln_seq+" "+relationship_type+" "+direct_yn+" "+ip_admit+" "+ip_attend+" "+op_attend+" "+expiry_based+" "+expiry_rule+" "+expiry_period );
		}
	}
}

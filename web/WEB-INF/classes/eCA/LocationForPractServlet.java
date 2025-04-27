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
import eCommon.XSSRequestWrapper;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;


public class LocationForPractServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{	req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
req= new XSSRequestWrapper(req); //MOHE-SCF-0153
res.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
res.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			out = res.getWriter();
			String operation = req.getParameter("mode")== null ? "insert" : req.getParameter("mode");
			if ( operation.equals("insert") )   insert(req, res, out);
			if ( operation.equals("modify"))    modify(req, res, out);
			if ( operation.equals("delete"))    delete(req, res, out);


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
	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		Connection con=null;

		String practitioner_id = "";
		String srl_no = "";
		String locn_type = "" ;
		String locn_code = ""	 ;
		String eff_from_date = "" ;
		String eff_to_date = "" ;
		StringBuffer sql=new StringBuffer();
		String facilityId ;
		String client_ip_address ;
		ResultSet rs= null;
		PreparedStatement pstmt =null;
		HttpSession session;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		try
		{
			con=ConnectionManager.getConnection(req);
			String strInsert  = "";
			practitioner_id =req.getParameter("practitioner_id");
			locn_type =req.getParameter("locn_type");
			if(locn_type==null) locn_type="";
			locn_code = req.getParameter("locn_code");

			if(locn_code==null) locn_code="";
			eff_from_date = req.getParameter("eff_from_date");
			if(eff_from_date ==null) 
				eff_from_date ="";

			eff_to_date = req.getParameter("eff_to_date");
			
			if(eff_to_date==null) 
				eff_to_date="";
			
			eff_from_date		=		com.ehis.util.DateUtils.convertDate(eff_from_date,"DMY",locale,"en");
			eff_to_date			=		com.ehis.util.DateUtils.convertDate(eff_to_date,"DMY",locale,"en");
			/************************************************/	
			
			int count=0;
			int count1=0;
			try{

			
			if(locn_type.equals("Z") || locn_type.equals("P"))
			{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" SELECT COUNT(1) FROM CA_PRACT_BY_LOCN ");
					sql.append(" WHERE FACILITY_ID = ?  ");
					sql.append(" AND PRACTITIONER_ID = ? ");
					
					sql.append(" AND ( nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate))  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  OR ");
					sql.append(" to_date(nvl(?,'31/12/3000'),'dd/mm/yyyy')  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))");
					sql.append(" OR nvl(EFF_FROM_DATE,trunc(sysdate)) BETWEEN nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate)) AND nvl(to_date(?,'dd/mm/yyyy'),to_date('31/12/3000','dd/mm/yyyy')) )");
					
					//stmt=con.createStatement();
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,facilityId);
					pstmt.setString(2,practitioner_id);
					pstmt.setString(3,eff_from_date);
					pstmt.setString(4,eff_to_date);
					pstmt.setString(5,eff_from_date);
					pstmt.setString(6,eff_to_date);

					//rs=stmt.executeQuery(sql);
					rs=pstmt.executeQuery();
					if(rs!=null)
					{
						while(rs.next())
						{
							count=rs.getInt(1);
						}
					}
					if(rs!=null) rs.close();
					if(pstmt !=null) pstmt.close();
					if(count!=0)
					{
						String error="";
						try
						{
							error = getMessage(locale,"LOCN_USER_SPEC_LOCN","CA");	
						}
						catch(Exception e)
						{
							res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(e.toString(),"UTF-8" ) + "&err_value=0");
						}
                          res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=0");
                        /*error="This user already has some specific location settings";
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) );*/
					}
				}
			/*else if(locn_type.equals("P"))
				{
					sql=" SELECT COUNT(1) FROM CA_PRACT_BY_LOCN ";
					sql+=" WHERE FACILITY_ID = '"+facilityId+"' ";
					sql+=" AND LOCN_TYPE in ('Z','N','C','X','Y') ";
					sql+=" AND PRACTiTIONER_ID = '"+practitioner_id+"' ";
					sql+=" AND (to_date('"+eff_from_date+"','dd/mm/yyyy')  BETWEEN EFF_FROM_DATE AND nvl(EFF_TO_DATE,to_date('31/12/5000','dd/mm/yyyy')) OR ";
					sql+=" nvl(to_date('"+eff_to_date+"','dd/mm/yyyy'),sysdate)  BETWEEN EFF_FROM_DATE AND nvl(EFF_TO_DATE,to_date('31/12/5000','dd/mm/yyyy')) ) ";

					stmt=con.createStatement();
					rs=stmt.executeQuery(sql);
					if(rs!=null)
					{
						while(rs.next())
						{
							count=rs.getInt(1);
						}
					}
					if(count!=0)
					{
						String error="";
						try
						{
							error = getErrorMessage(con,"LOCN_USER_SPEC_LOCN");
						}
						catch(Exception e)
						{
							res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( e.toString() ) + "&err_value=0");
						}
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=0");

						//String error="Higher privilege setting exists for this user";
						//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) );
					}
				}*/
				else if(locn_type.equals("X"))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" SELECT COUNT(1) FROM CA_PRACT_BY_LOCN ");
					sql.append(" WHERE FACILITY_ID = ? ");
					sql.append(" AND LOCN_TYPE in ( 'Z' ,'C') ");
					sql.append(" AND PRACTITIONER_ID = ? ");
					sql.append(" AND ( nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate))  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  OR ");
					sql.append(" to_date(nvl(?,'31/12/3000'),'dd/mm/yyyy')  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  ");
					sql.append(" OR nvl(EFF_FROM_DATE,trunc(sysdate)) BETWEEN nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate)) AND nvl(to_date(?,'dd/mm/yyyy'),to_date('31/12/3000','dd/mm/yyyy')) )");
					//out.println(sql);
					//stmt=con.createStatement();
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,facilityId);
					pstmt.setString(2,practitioner_id);
					pstmt.setString(3,eff_from_date);
					pstmt.setString(4,eff_to_date);
					pstmt.setString(5,eff_from_date);
					pstmt.setString(6,eff_to_date);

					rs=pstmt.executeQuery();
					//rs=stmt.executeQuery(sql);
					if(rs!=null)
					{
						while(rs.next())
						{
							count=rs.getInt(1);
						}
					}
					if(rs!=null) rs.close();
					if(pstmt !=null) pstmt.close();
					//out.println("count here"+count);
					if(count!=0)
					{
						String error="";
						try
						{
							  error = getMessage(locale,"CLINIC_USER_HIGHER_EXIST","CA");
						}
						catch(Exception e)
						{
							 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( e.toString() ,"UTF-8") + "&err_value=0");
						}
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=0");

						/*error="Specific clinic/higher privilege setting exists for this user";
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) );*/
					}
				}
				else if(locn_type.equals("Y"))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" SELECT COUNT(1) FROM CA_PRACT_BY_LOCN ");
					sql.append(" WHERE FACILITY_ID = ? ");
					sql.append(" AND LOCN_TYPE in ( 'Z' ,'W')");
					sql.append(" AND PRACTITIONER_ID = ? ");
					sql.append(" AND ( nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate))  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  OR ");
					sql.append(" to_date(nvl(?,'31/12/3000'),'dd/mm/yyyy')  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  ");
					sql.append(" OR nvl(EFF_FROM_DATE,trunc(sysdate)) BETWEEN nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate)) AND nvl(to_date(?,'dd/mm/yyyy'),to_date('31/12/3000','dd/mm/yyyy')) )");
					//out.println(sql);

					//stmt=con.createStatement();
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,facilityId);
					pstmt.setString(2,practitioner_id);
					pstmt.setString(3,eff_from_date);
					pstmt.setString(4, eff_to_date);
					pstmt.setString(5,eff_from_date);
					pstmt.setString(6,eff_to_date);

					rs=pstmt.executeQuery();
					//rs=stmt.executeQuery(sql);
					if(rs!=null)
					{
						while(rs.next())
						{
							count=rs.getInt(1);
						}
					}
					if(rs!=null) rs.close();
					if(pstmt !=null) pstmt.close();
					if(count!=0)
					{
						String error="";
						try
						{
							error = getMessage(locale,"NUNIT_USER_HIGHER_EXIST","CA");
						}
						catch(Exception e)
						{
							 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( e.toString(),"UTF-8" ) + "&err_value=0");
						}
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=0");

						/*error="Specific Nursing Unit/higher privilege setting exists for this user";
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) );*/
					}
				}
				else if(locn_type.equals("W"))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" SELECT COUNT(1) FROM CA_PRACT_BY_LOCN ");
					sql.append(" WHERE FACILITY_ID = ?  ");
					sql.append(" AND LOCN_TYPE in ( 'P','Z' ,'Y') ");
					sql.append(" AND PRACTITIONER_ID =? ");
					sql.append(" AND ( nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate))  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  OR ");
					sql.append(" to_date(nvl(?,'31/12/3000'),'dd/mm/yyyy')  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  ");
					sql.append(" OR nvl(EFF_FROM_DATE,trunc(sysdate)) BETWEEN nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate)) AND nvl(to_date(?,'dd/mm/yyyy'),to_date('31/12/3000','dd/mm/yyyy')) )");
					//out.println(sql);
					//stmt=con.createStatement();
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,facilityId);
					pstmt.setString(2,practitioner_id);
					pstmt.setString(3,eff_from_date);
					pstmt.setString(4,eff_to_date);
					pstmt.setString(5,eff_from_date);
					pstmt.setString(6,eff_to_date);
					//rs=stmt.executeQuery(sql);
					rs=pstmt.executeQuery();

					if(rs!=null)
					{
						while(rs.next())
						{
							count=rs.getInt(1);
						}
					}
					if(rs!=null) rs.close();
					if(pstmt !=null) pstmt.close();
					if(count!=0)
					{
						String error="";
						try
						{
							error = getMessage(locale,"LOCN_USER_HIGHER_EXIST","CA");						
						}
						catch(Exception e)
						{
							 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( e.toString() ,"UTF-8") + "&err_value=0");
						}
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=0");

						/*error="Higher privilege setting exists for this user";
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) );*/
					}
				}
				else if(locn_type.equals("C"))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" SELECT COUNT(1) FROM CA_PRACT_BY_LOCN ");
					sql.append(" WHERE FACILITY_ID = ? ");
					sql.append(" AND LOCN_TYPE in ('P','Z' ,'X') ");
					sql.append(" AND PRACTITIONER_ID = ? ");
					sql.append(" AND ( nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate))  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  OR ");
					sql.append(" to_date(nvl(?,'31/12/3000'),'dd/mm/yyyy')  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  ");
					sql.append(" OR nvl(EFF_FROM_DATE,trunc(sysdate)) BETWEEN nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate)) AND nvl(to_date(?,'dd/mm/yyyy'),to_date('31/12/3000','dd/mm/yyyy')) )");
					//out.println(sql);
					//stmt=con.createStatement();
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,facilityId);
					pstmt.setString(2,practitioner_id);
					pstmt.setString(3,eff_from_date);
					pstmt.setString(4,eff_to_date);
					pstmt.setString(5,eff_from_date);
					pstmt.setString(6,eff_to_date);

					rs=pstmt.executeQuery();
					//rs=stmt.executeQuery(sql);
					if(rs!=null)
					{
						while(rs.next())
						{
							count=rs.getInt(1);
						}
					}
					if(rs!=null) rs.close();
					if(pstmt !=null) pstmt.close();
					if(count!=0)
					{
						String error="";
						try
						{
							error = getMessage(locale,"LOCN_USER_HIGHER_EXIST","CA");
						}
						catch(Exception e)
						{
							 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( e.toString() ,"UTF-8") + "&err_value=0");
						}
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=0");

						/*error="Higher privilege setting exists for  this user";
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) );*/
					}
				}


				if(count==0)
				{
					if(locn_type.equals("Z") || locn_type.equals("P") || locn_type.equals("X") || locn_type.equals("Y"))
					{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" SELECT COUNT(1) FROM CA_PRACT_BY_LOCN ");
					sql.append(" WHERE FACILITY_ID = ? ");
					sql.append(" AND LOCN_TYPE=? ");
					sql.append(" AND PRACTITIONER_ID = ?  ");
					sql.append(" AND ( nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate))  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  OR ");
					sql.append(" to_date(nvl(?,'31/12/3000'),'dd/mm/yyyy')  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy')) ");
					sql.append(" OR nvl(EFF_FROM_DATE,trunc(sysdate)) BETWEEN nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate)) AND nvl(to_date(?,'dd/mm/yyyy'),to_date('31/12/3000','dd/mm/yyyy')) )");
					//out.println(sql);
					//stmt=con.createStatement();
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,facilityId);
					pstmt.setString(2,locn_type);
					pstmt.setString(3,practitioner_id);
					pstmt.setString(4,eff_from_date);
					pstmt.setString(5,eff_to_date);
					pstmt.setString(6,eff_from_date);
					pstmt.setString(7,eff_to_date);

					rs=pstmt.executeQuery();
					//rs=stmt.executeQuery(sql);
					if(rs!=null)
					{
						while(rs.next())
						{
							count1=rs.getInt(1);
						}
					}
					if(rs!=null) rs.close();
					if(pstmt !=null) pstmt.close();
					if(count1!=0)
					{
						String error="";
						try
						{
							error = getMessage(locale,"LOCN_USER_SETTING_EXIST","CA");
						}
						catch(Exception e)
						{
							 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( e.toString(),"UTF-8" ) + "&err_value=0");
						}
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=0");

					/*error="This setting already exists for this user";
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) );*/
					}
				}
				else
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" SELECT COUNT(1) FROM CA_PRACT_BY_LOCN ");
					sql.append(" WHERE FACILITY_ID = ? ");
					sql.append(" AND LOCN_TYPE=? ");
					sql.append(" AND locn_code=? ");
					sql.append(" AND PRACTITIONER_ID = ? ");
					sql.append(" AND ( nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate))  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  OR ");
					sql.append(" to_date(nvl(?,'31/12/3000'),'dd/mm/yyyy')  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  ");
					sql.append(" OR nvl(EFF_FROM_DATE,trunc(sysdate)) BETWEEN nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate)) AND nvl(to_date(?,'dd/mm/yyyy'),to_date('31/12/3000','dd/mm/yyyy')) )");
					//out.println(sql);
					//stmt=con.createStatement();
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,facilityId);
					pstmt.setString(2,locn_type);
					pstmt.setString(3,locn_code);
					pstmt.setString(4,practitioner_id);
					pstmt.setString(5,eff_from_date);
					pstmt.setString(6,eff_to_date);
					pstmt.setString(7,eff_from_date);
					pstmt.setString(8,eff_to_date);

					rs=pstmt.executeQuery();
					//rs=stmt.executeQuery(sql);
					if(rs!=null)
					{
						while(rs.next())
						{
							count1=rs.getInt(1);
						}
					}
					if(rs!=null) rs.close();
					if(pstmt !=null) pstmt.close();
					if(count1!=0)
					{
						String error="";
						try
						{
							error = getMessage(locale,"LOCN_USER_SETTING_EXIST","CA");
						}
						catch(Exception e)
						{
							 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( e.toString(),"UTF-8" ) + "&err_value=0");
						}
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=0");

						/*error="This setting already exists for this user";
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) );*/
					}
				}
			}
		}catch( Exception e){}
			

			//out.println("count"+count+"/"+"count1"+count1);
	if(count==0 && count1==0)
	{
		//Statement stmt_s=null;
		PreparedStatement pstmt_s=null;
		ResultSet rs_s=null;
		try{
			// Serial Number Generation
			//String	sql_s=" select nvl(max(srl_no),0)+1 from ca_pract_by_locn where practitioner_id = '"+practitioner_id+"' ";//common-icn-0180
			String	sql_s=" select nvl(max(srl_no),0)+1 from ca_pract_by_locn where practitioner_id = ? ";//common-icn-0180
			pstmt_s=con.prepareStatement(sql_s);
			pstmt_s.setString(1, practitioner_id);//common-icn-0180
			//stmt_s=con.createStatement();
			rs_s=pstmt_s.executeQuery();
			//rs_s=stmt_s.executeQuery(sql_s);
			if(rs_s!=null)
			{
				while(rs_s.next())
				{
					srl_no=rs_s.getString(1);
				}
			}

			//out.println("srl_no"+sql_s+"!"+srl_no);
		}catch(Exception e){
			//out.println(e);//common-icn-0181
			e.printStackTrace();
		}
		finally
		{
			//ConnectionManager.returnConnection(con,req);
			//if(stmt_s!=null) stmt_s.close();
			if(pstmt_s!=null) pstmt_s.close();
			
			if(rs_s!=null) rs_s.close();
		}
			//out.println("srl_no"+srl_no);
			String addedById = p.getProperty( "login_user" ) ;
			//String addedDate = dateFormat.format( new java.util.Date() ) ;

			String modifiedById = addedById ;
			//String modifiedDate = addedDate ;

			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			//java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
			//java.sql.Date modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;

			//java.sql.Date added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
		//	java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;

			//java.sql.Date eff_from_date2=null;
		//	java.sql.Date eff_to_date2=null;

			strInsert = "insert into ca_pract_by_locn(PRACTITIONER_ID,SRL_NO,FACILITY_ID,LOCN_TYPE,LOCN_CODE              ,EFF_FROM_DATE,EFF_TO_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID      ,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,sysdate,?,?,?,sysdate,?,?)";

			PreparedStatement pstmtInsert = con.prepareStatement(strInsert) ;
			pstmtInsert.setString(1,practitioner_id);
			pstmtInsert.setInt(2,Integer.parseInt(srl_no));
			pstmtInsert.setString(3,facilityId);
			pstmtInsert.setString(4,locn_type);
			pstmtInsert.setString(5,locn_code);
			pstmtInsert.setString(6,eff_from_date);
			pstmtInsert.setString(7,eff_to_date);
			pstmtInsert.setString(8,addedById);
			pstmtInsert.setString(9,addedAtWorkstation);
			pstmtInsert.setString(10,facilityId);
			pstmtInsert.setString(11,modifiedById);
			pstmtInsert.setString(12,modifiedAtWorkstation);
			pstmtInsert.setString(13,modifiedFacilityId);

			String error = "" ;
			String error_value = "0" ;
			if(pstmtInsert.executeUpdate() > 0) 
			{
				 con.commit();
				 error_value = "1" ;
				 error = getMessage(locale, "RECORD_INSERTED","CA") ;	
				 
			}
			else
			{
				 con.rollback();
				 error_value = "0";
				 error = getMessage(locale, "FAILED_TRANSACTION","CA") ;
			}		
			if(pstmtInsert!=null) pstmtInsert.close();
			
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
			
			
/*
				Hashtable tabdata=new Hashtable();

				tabdata.put("practitioner_id",practitioner_id);
				tabdata.put("srl_no",new Integer(Integer.parseInt(srl_no)));
				tabdata.put("facility_id",facilityId);
				tabdata.put("locn_type",locn_type);
				tabdata.put("locn_code",locn_code);
				if(!eff_from_date.equals(""))
					tabdata.put("eff_from_date",eff_from_date2);
				else
					tabdata.put("eff_from_date",sysDate);
						
				if(!eff_to_date.equals(""))
					tabdata.put("eff_to_date",eff_to_date2);

				tabdata.put("added_by_id",addedById);
				tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("added_facility_id", facilityId);
				tabdata.put("added_at_ws_no",addedAtWorkstation);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

				String dupflds[]={"practitioner_id","srl_no"};

			Context context =  new InitialContext(  ) ;
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome)PortableRemoteObject.narrow(homeObject,  SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"ca_pract_by_locn");
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
			 error_value = "1" ;
			}
			else
			{
			 error = (String) results.get("error") ;
			}

			error = (String) results.get("error") ;
    		 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) +"&err_value="+error_value);
*/			
		}//if count/count1
	
	}
	catch ( Exception e )
	{
		//out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
		e.printStackTrace();
		out.println( "Values sent are : <br>" ) ;
		out.println( practitioner_id+" "+facilityId+" "+locn_type+" "+locn_code+" "+eff_from_date+" "+eff_to_date );
	}

	finally{
		try{
			if(con!=null) ConnectionManager.returnConnection(con,req);		
		}catch(Exception e){}
	}
}

	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		Connection con=null;

		String practitioner_id = "";
		String srl_no = "";
		String locn_type = "" ;
		String locn_code = ""	 ;
		String eff_from_date = "" ;
		String eff_to_date = "" ;
		StringBuffer sql=new StringBuffer();
		String facilityId ;
		String client_ip_address ;
		HttpSession session;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		try
		{
			con=ConnectionManager.getConnection(req);

			practitioner_id =req.getParameter("practitioner_id");
			if(practitioner_id==null) practitioner_id="";
			locn_type =req.getParameter("locn_type1");
			if(locn_type==null) locn_type="";
			locn_code = req.getParameter("locn_code1");
			if(locn_code==null) locn_code="";
			eff_from_date = req.getParameter("eff_from_date");
			if(eff_from_date ==null) eff_from_date ="";
			eff_to_date = req.getParameter("eff_to_date");
			if(eff_to_date==null) eff_to_date="";
			srl_no = req.getParameter("srl_no");
			if(srl_no==null) srl_no="";


			eff_from_date		=		com.ehis.util.DateUtils.convertDate(eff_from_date,"DMY",locale,"en");
			eff_to_date			=		com.ehis.util.DateUtils.convertDate(eff_to_date,"DMY",locale,"en");

			//out.println("here");
			/****************added by Ankur*****************/
			//currentDate=req.getParameter("to_date");
			/*if(!currentDate.equals(""))
			{
				StringTokenizer st1 = new StringTokenizer(currentDate,"/");
				String d11="";
				String d12="";
				String d13="";

				while(st1.hasMoreTokens())
				{
					d11=st1.nextToken();
					d12=st1.nextToken();
					d13=st1.nextToken();
				}
				String s1=d13+"-"+d12+"-"+d11;
				java.sql.Date currdate1 = java.sql.Date.valueOf(s1);
			//	sysDate = new java.sql.Date(currdate1.parse(currdate1.toLocaleString())-(currdate1.getTimezoneOffset()*60*1000) ) ;
			}*/

			//checking from date is greater then to date 
/*
			String d111="";
			String d22="";
			String d33="";
			String s6="";
			java.sql.Date dt1=null;
			if(!eff_from_date.equals(""))
			{
				StringTokenizer st4 = new StringTokenizer(eff_from_date,"/");
				while(st4.hasMoreTokens())
				{
					d111=st4.nextToken();
					d22=st4.nextToken();
					d33=st4.nextToken();
				}
				s6=d33+"-"+d22+"-"+d111;
				dt1=java.sql.Date.valueOf(s6);
			
				if(!eff_to_date.equals(""))
				{
					StringTokenizer st5 = new StringTokenizer(eff_to_date,"/");
					while(st5.hasMoreTokens())
					{
						d111=st5.nextToken();
						d22=st5.nextToken();
						d33=st5.nextToken();
					}
					s6=d33+"-"+d22+"-"+d111;
					java.sql.Date dt2=java.sql.Date.valueOf(s6);
					if(dt1.compareTo(dt2)>0)
					{
						String error1 =getMessage(locale,"TO_DT_GR_EQ_FM_DT","CA");
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error1,"UTF-8"));
						return;
					}
				}
			}
*/
			
			
			/************************************************/	

			//String sql="";
			ResultSet rs= null;
			//Statement stmt=null;
			PreparedStatement pstmt=null;
			int count=0;
			//int count1=0;
		//	int count2=0;

			try{

			//con=ConnectionManager.getConnection(req);

			if(locn_type.equals("Z"))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" SELECT COUNT(1) FROM CA_PRACT_BY_LOCN ");
					sql.append(" WHERE FACILITY_ID = ? ");
					sql.append(" AND PRACTITIONER_ID = ? ");
					sql.append(" AND ( nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate))  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  OR ");
					sql.append(" to_date(nvl(?,'31/12/3000'),'dd/mm/yyyy')  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  ");
					sql.append(" OR nvl(EFF_FROM_DATE,trunc(sysdate)) BETWEEN nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate)) AND nvl(to_date(?,'dd/mm/yyyy'),to_date('31/12/3000','dd/mm/yyyy')) )");
					sql.append(" and srl_no!=? ");
					//sql=" SELECT COUNT(1) FROM CA_PRACT_BY_LOCN WHERE FACILITY_ID='"+facilityId+"' AND PRACTITIONER_ID='"+practitioner_id+"' AND ( nvl(to_date('"+eff_from_date+"','dd/mm/yyyy'),trunc(sysdate))  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  OR to_date(nvl('"+eff_to_date+"','31/12/3000'),'dd/mm/yyyy')  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  OR nvl(EFF_FROM_DATE,trunc(sysdate)) BETWEEN nvl(to_date('"+eff_from_date+"','dd/mm/yyyy'),trunc(sysdate)) AND nvl(to_date('"+eff_to_date+"','dd/mm/yyyy'),to_date('31/12/3000','dd/mm/yyyy'))) and srl_no!='"+srl_no+"' ";
					//stmt=con.createStatement();
					
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,facilityId);
					pstmt.setString(2,practitioner_id);
					pstmt.setString(3,eff_from_date);
					pstmt.setString(4,eff_to_date);
					pstmt.setString(5,eff_from_date);
					pstmt.setString(6,eff_to_date);
					pstmt.setString(7,srl_no);

					rs=pstmt.executeQuery();
					//rs=stmt.executeQuery(sql);
					if(rs!=null)
					{
						while(rs.next())
						{
							count=rs.getInt(1);
						}
					}
					if(rs!=null) rs.close();
					if(pstmt !=null) pstmt.close();
					if(count!=0)
					{
						String error = getMessage(locale, "LOCN_USER_SPEC_LOCN","CA");
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") );
					}
				}
			else if(locn_type.equals("P"))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" SELECT COUNT(1) FROM CA_PRACT_BY_LOCN ");
					sql.append(" WHERE FACILITY_ID = ? ");
					sql.append(" AND LOCN_TYPE = 'Z' ");
					sql.append(" AND PRACTITIONER_ID = ? ");
					sql.append(" AND ( nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate))  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  OR ");
					sql.append(" to_date(nvl(?,'31/12/3000'),'dd/mm/yyyy')  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  ");
					sql.append(" OR nvl(EFF_FROM_DATE,trunc(sysdate)) BETWEEN nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate)) AND nvl(to_date(?,'dd/mm/yyyy'),to_date('31/12/3000','dd/mm/yyyy')) )");
					sql.append(" and srl_no!=? ");

					//stmt=con.createStatement();
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,facilityId);
					pstmt.setString(2,practitioner_id);
					pstmt.setString(3,eff_from_date);
					pstmt.setString(4,eff_to_date);
					pstmt.setString(5,eff_from_date);
					pstmt.setString(6,eff_to_date);
					pstmt.setString(7,srl_no);

					rs=pstmt.executeQuery();
					//rs=stmt.executeQuery(sql);
					if(rs!=null)
					{
						while(rs.next())
						{
							count=rs.getInt(1);
						}
					}
					if(rs!=null) rs.close();
					if(pstmt !=null) pstmt.close();
					if(count!=0)
					{
						String error = getMessage(locale, "HIGH_PRI_EXIST","CA");
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") );
					}
				}
				else if(locn_type.equals("X"))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" SELECT COUNT(1) FROM CA_PRACT_BY_LOCN ");
					sql.append(" WHERE FACILITY_ID = ? ");
					sql.append(" AND LOCN_TYPE in ( 'Z' ,'C') ");
					sql.append(" AND PRACTITIONER_ID = ? ");
					sql.append(" AND ( nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate))  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  OR ");
					sql.append(" to_date(nvl(?,'31/12/3000'),'dd/mm/yyyy')  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  ");
					sql.append(" OR nvl(EFF_FROM_DATE,trunc(sysdate)) BETWEEN nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate)) AND nvl(to_date(?,'dd/mm/yyyy'),to_date('31/12/3000','dd/mm/yyyy')) )");
					sql.append(" and srl_no!=? ");

					//stmt=con.createStatement();
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,facilityId);
					pstmt.setString(2,practitioner_id);
					pstmt.setString(3,eff_from_date);
					pstmt.setString(4,eff_to_date);
					pstmt.setString(5,eff_from_date);
					pstmt.setString(6,eff_to_date);
					pstmt.setString(7,srl_no);

					rs=pstmt.executeQuery();
					//rs=stmt.executeQuery(sql);
					if(rs!=null)
					{
						while(rs.next())
						{
							count=rs.getInt(1);
						}
					}
					if(rs!=null) rs.close();
					if(pstmt !=null) pstmt.close();
					if(count!=0)
					{
						String error = getMessage(locale, "CLINIC_USER_HIGHER_EXIST","CA");
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") );
					}
				}
				else if(locn_type.equals("Y"))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" SELECT COUNT(1) FROM CA_PRACT_BY_LOCN ");
					sql.append(" WHERE FACILITY_ID = ? ");
					sql.append(" AND LOCN_TYPE in ( 'Z' ,'W') ");
					sql.append(" AND PRACTITIONER_ID = ? ");
					sql.append(" AND ( nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate))  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  OR ");
					sql.append(" to_date(nvl(?,'31/12/3000'),'dd/mm/yyyy')  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  ");
					sql.append(" OR nvl(EFF_FROM_DATE,trunc(sysdate)) BETWEEN nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate)) AND nvl(to_date(?,'dd/mm/yyyy'),to_date('31/12/3000','dd/mm/yyyy')) )");
					sql.append(" and srl_no!=? ");

					//stmt=con.createStatement();
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,facilityId);
					pstmt.setString(2,practitioner_id);
					pstmt.setString(3,eff_from_date);
					pstmt.setString(4,eff_to_date);
					pstmt.setString(5,eff_from_date);
					pstmt.setString(6,eff_to_date);
					pstmt.setString(7,srl_no);

					rs=pstmt.executeQuery();
					//rs=stmt.executeQuery(sql);
					if(rs!=null)
					{
						while(rs.next())
						{
							count=rs.getInt(1);
						}
					}
					if(rs!=null) rs.close();
					if(pstmt !=null) pstmt.close();
					if(count!=0)
					{
						
						String error = getMessage(locale,"NUNIT_USER_HIGHER_EXIST","CA");
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") );
					}
				}
				else if(locn_type.equals("W"))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" SELECT COUNT(1) FROM CA_PRACT_BY_LOCN ");
					sql.append(" WHERE FACILITY_ID = ? ");
					sql.append(" AND LOCN_TYPE in ( 'Z' ,'Y') ");
					sql.append(" AND PRACTITIONER_ID = ? ");
					sql.append(" AND ( nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate))  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  OR ");
					sql.append(" to_date(nvl(?,'31/12/3000'),'dd/mm/yyyy')  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  ");
					sql.append(" OR nvl(EFF_FROM_DATE,trunc(sysdate)) BETWEEN nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate)) AND nvl(to_date(?,'dd/mm/yyyy'),to_date('31/12/3000','dd/mm/yyyy')) )");
					sql.append(" and srl_no!=? ");

					//stmt=con.createStatement();
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,facilityId);
					pstmt.setString(2,practitioner_id);
					pstmt.setString(3,eff_from_date);
					pstmt.setString(4,eff_to_date);
					pstmt.setString(5,eff_from_date);
					pstmt.setString(6,eff_to_date);
					pstmt.setString(7,srl_no);

					rs=pstmt.executeQuery(sql.toString());
					//rs=stmt.executeQuery(sql);
					if(rs!=null)
					{
						while(rs.next())
						{
							count=rs.getInt(1);
						}
					}
					if(rs!=null) rs.close();
					if(pstmt !=null) pstmt.close();
					if(count!=0)
					{
						String error= getMessage(locale, "HIGH_PRI_EXIST","CA") ;	
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") );
					}
				}
				else if(locn_type.equals("C"))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" SELECT COUNT(1) FROM CA_PRACT_BY_LOCN ");
					sql.append(" WHERE FACILITY_ID = ? ");
					sql.append(" AND LOCN_TYPE in ( 'Z' ,'X') ");
					sql.append(" AND PRACTITIONER_ID = ? ");
					sql.append(" AND ( nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate))  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  OR ");
					sql.append(" to_date(nvl(?,'31/12/3000'),'dd/mm/yyyy')  BETWEEN nvl(EFF_FROM_DATE,trunc(sysdate)) AND nvl(EFF_TO_DATE,to_date('31/12/3000','dd/mm/yyyy'))  ");
					sql.append(" OR nvl(EFF_FROM_DATE,trunc(sysdate)) BETWEEN nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate)) AND nvl(to_date(?,'dd/mm/yyyy'),to_date('31/12/3000','dd/mm/yyyy')) )");
					sql.append(" and srl_no!=? ");

					//stmt=con.createStatement();
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,facilityId);
					pstmt.setString(2,practitioner_id);
					pstmt.setString(3,eff_from_date);
					pstmt.setString(4,eff_from_date);
					pstmt.setString(5,eff_from_date);
					pstmt.setString(6,eff_to_date);
					pstmt.setString(7,srl_no);
	
					rs=pstmt.executeQuery();
					//rs=stmt.executeQuery(sql);
					if(rs!=null)
					{
						while(rs.next())
						{
							count=rs.getInt(1);
						}
					}
					if(rs!=null) rs.close();
					if(pstmt !=null) pstmt.close();
					if(count!=0)
					{
						String error= getMessage(locale, "HIGH_PRI_EXIST","CA") ;
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") );
					}
				}
/*				if(count==0)
				{
					if(locn_type.equals("Z") || locn_type.equals("P") || locn_type.equals("X") || locn_type.equals("Y"))
					{
					sql=" SELECT COUNT(1) FROM CA_PRACT_BY_LOCN ";
					sql+=" WHERE FACILITY_ID = '"+facilityId+"' ";
					sql+=" AND LOCN_TYPE='"+locn_type+"' ";
					sql+=" AND PRACTiTIONER_ID = '"+practitioner_id+"' ";
					sql+=" AND (to_date('"+eff_from_date+"','dd/mm/yyyy')  BETWEEN EFF_FROM_DATE AND EFF_TO_DATE OR ";
					sql+=" to_date('"+eff_to_date+"','dd/mm/yyyy') BETWEEN EFF_FROM_DATE AND EFF_TO_DATE) ";

					stmt=con.createStatement();
					rs=stmt.executeQuery(sql);
					if(rs!=null)
					{
						while(rs.next())
						{
							count1=rs.getInt(1);
						}
					}
					if(count1!=0)
					{
						String error="This setting already exists for this user";
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) );
					}
				}
				else
				{
					sql=" SELECT COUNT(1) FROM CA_PRACT_BY_LOCN ";
					sql+=" WHERE FACILITY_ID = '"+facilityId+"' ";
					sql+=" AND LOCN_TYPE='"+locn_type+"' ";
					sql+=" AND locn_code='"+locn_code+"' ";
					sql+=" AND PRACTiTIONER_ID = '"+practitioner_id+"' ";
					sql+=" AND (to_date('"+eff_from_date+"','dd/mm/yyyy')  BETWEEN EFF_FROM_DATE AND EFF_TO_DATE OR ";
					sql+=" to_date('"+eff_to_date+"','dd/mm/yyyy') BETWEEN EFF_FROM_DATE AND EFF_TO_DATE) ";

					stmt=con.createStatement();
					rs=stmt.executeQuery(sql);
					if(rs!=null)
					{
						while(rs.next())
						{
							count1=rs.getInt(1);
						}
					}
					if(count1!=0)
					{
						String error="This setting already exists for this user";
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) );
					}
				}
			}*/
		}catch( Exception e){}
				
	if(count==0 )
	{
			String addedById = p.getProperty( "login_user" ) ;
			//String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			//String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

		//	java.sql.Date eff_from_date2=null;
		//	java.sql.Date eff_to_date2=null;

			/*if(!eff_from_date.equals(""))
			{
				StringTokenizer st = new StringTokenizer(eff_from_date,"/");
				String d1="";
				String d2="";
				String d3="";
				while(st.hasMoreTokens())
				{
					d1=st.nextToken();
					d2=st.nextToken();
					d3=st.nextToken();
				}
				String s=d3+"-"+d2+"-"+d1;
				java.sql.Date eff_from_date1 = java.sql.Date.valueOf(s);
				eff_from_date2 = new java.sql.Date(eff_from_date1.parse(eff_from_date1.toLocaleString())-(eff_from_date1.getTimezoneOffset()*60*1000) ) ;
			}
			java.sql.Date eff_date_to2 =null;

			if(!eff_to_date.equals(""))
			{
				StringTokenizer st1 = new StringTokenizer(eff_to_date,"/");
				String d11="";
				String d12="";
				String d13="";

				while(st1.hasMoreTokens())
				{
					d11=st1.nextToken();
					d12=st1.nextToken();
					d13=st1.nextToken();
				}
				//out.println("here11");
				String s1=d13+"-"+d12+"-"+d11;
				java.sql.Date eff_to_date1 = java.sql.Date.valueOf(s1);
				//out.println("here12");
				eff_to_date2 = new java.sql.Date(eff_to_date1.parse(eff_to_date1.toLocaleString())-(eff_to_date1.getTimezoneOffset()*60*1000) ) ;
				//out.println("here113");
			}

			Hashtable tabdata=new Hashtable();

//				tabdata.put("facility_id",facilityId);
//				tabdata.put("locn_type",locn_type);
//				tabdata.put("locn_code",locn_code);
				if(!eff_from_date.equals(""))
					tabdata.put("eff_from_date",eff_from_date2);
				else
					tabdata.put("eff_from_date",sysDate);

				if(!eff_to_date.equals(""))
					tabdata.put("eff_to_date",eff_to_date2);
				else
					tabdata.put("eff_to_date","");

				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

				Hashtable condflds=new Hashtable();
				condflds.put("practitioner_id",practitioner_id);//out.println("srl_no"+srl_no);
				condflds.put("srl_no",new Integer(Integer.parseInt(srl_no)));
				//out.println("srl_no"+srl_no);
			Context context =  new InitialContext(  ) ;
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome)PortableRemoteObject.narrow(homeObject,
  SingleTabHandlerManagerHome.class);

			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"ca_pract_by_locn");
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
						String error_value = "0" ;
						if ( inserted )
						{
						 error_value = "1" ;
						}
						else
						{
						 error = (String) results.get("error") ;

						}
       	error = (String) results.get("error") ;
    		 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) +"&err_value="+error_value);
*/

	//added By Parimala
		String updateSQL = " update ca_pract_by_locn set eff_from_date=to_date(?,'dd/mm/yyyy'), eff_to_date=to_date(?,'dd/mm/yyyy'), modified_by_id =?,modified_date=sysdate,modified_facility_id=?,modified_at_ws_no=? where practitioner_id =? and srl_no = ? " ;

		PreparedStatement pstmt1 = con.prepareStatement(updateSQL) ;
		pstmt1.setString(1,eff_from_date) ;
		pstmt1.setString(2,eff_to_date) ;
		pstmt1.setString(3,modifiedById) ;
		pstmt1.setString(4,modifiedFacilityId) ;
		pstmt1.setString(5,modifiedAtWorkstation) ;
		pstmt1.setString(6,practitioner_id) ;
		pstmt1.setInt(7,Integer.parseInt(srl_no) ) ;

		String error = "" ;
		String error_value = "0" ;
		if(pstmt1.executeUpdate() > 0) 
			{
				con.commit();
				error_value = "1" ;
				error = getMessage(locale, "RECORD_INSERTED","CA") ;	
			}
		else
			{
				con.rollback();
				error_value = "0";
				error = getMessage(locale, "FAILED_TRANSACTION","CA") ;
			}	
			
			if(pstmt1!=null) pstmt1.close();
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		
			//if(pstmt !=null)	{ pstmt.close(); pstmt = null; }
	//Ends Here


	}//if (count/count1
		}
		catch ( Exception e )
		{
			 e.printStackTrace();//COMMON-ICN-0181
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			//out.println( "Values sent are : <br>" ) ;//common-icn-0181
			out.println( practitioner_id+" "+facilityId+" "+locn_type+" "+locn_code+" "+eff_from_date+" "+eff_to_date );
		}
		finally
		{
			if(con != null)ConnectionManager.returnConnection(con,req);			
		}
	}
// from here

	private void delete(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		Connection con=null;

		String practitioner_id = "";
		String srl_no = "";
		String facilityId ;
		String client_ip_address ;
		HttpSession session;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		try
		{
			con=ConnectionManager.getConnection(req);
			practitioner_id =req.getParameter("practitioner_id1");
			srl_no = req.getParameter("srl_no");
			if(srl_no==null) srl_no="";
			
			String strDelete ="delete from ca_pract_by_locn where practitioner_id =? and srl_no = ? " ;

			PreparedStatement pstmtDelete = con.prepareStatement(strDelete) ;
			pstmtDelete.setString(1,practitioner_id);
			pstmtDelete.setInt(2,Integer.parseInt(srl_no));
			int couDel=pstmtDelete.executeUpdate();
			String error = "" ;
			String error_value = "0" ;
			if( couDel> 0) 
				{
					 error_value = "1" ;
					 error = getMessage(locale, "RECORD_INSERTED","CA") ;
					 con.commit();
				}
			else
				{
					con.rollback();
					error_value = "0";
					error = getMessage(locale, "FAILED_TRANSACTION","CA") ;
				}		

			if(pstmtDelete!=null) pstmtDelete.close();

			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(con != null)ConnectionManager.returnConnection(con,req);			
		}
	}
	// till here

	private String getMessage(String locale, String messageId, String moduleId)
	{
        java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
        return(mesg) ;
    }
}

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;
import eCommon.SingleTabHandler.*;
import java.io.*;
import java.net.URLEncoder;
import java.sql.*;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;

public class OrderCatalogForReportServlet extends javax.servlet.http.HttpServlet 
{
	java.util.Properties p;
	HttpSession session;
	PrintWriter out;
	String facilityId									= "";
	String group_code								= "";
	String report_id									= "";
	String sub_group_code						= "";
	String maxrecord								= "";
	String tab_list_no								= "";
	String order_catalog_code				= "";
	String mast_table_name_reference	= "";
	String text									= "";	
	String error								= "";
	String err_value							= "";
	String client_ip_address			= "";
	String inc									= "";
	String addedById						= "";
	String modifiedById					= "";
	String modifiedAtWorkstation	= "";
	String modifiedFacilityId			= "";
	String addedFacilityId				= "";
	String addedAtWorkstation		= "";
	String tab_list						= "";
	String ord_cat						= "";
	String function_name				= "";
	String locale							= "";
	int text1								= 0;	
	int cnt									= 0;
	boolean status;
	Connection con								= null;
	Statement	stmt								= null;
	PreparedStatement pstmt				= null;
	PreparedStatement preStatement	= null;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		session							= request.getSession(false);
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		this.p							= (java.util.Properties) session.getValue( "jdbc" ) ;
		report_id						= checkForNull(request.getParameter("report_id"));
		group_code						= checkForNull(request.getParameter("group_code"));
		sub_group_code					= checkForNull(request.getParameter("sub_group_code"));
		mast_table_name_reference		= checkForNull(request.getParameter("mast_table_name_reference"));
		maxrecord						= checkForNull(request.getParameter("maxrecord1"));
		this.facilityId					= checkForNull((String) session.getValue( "facility_id")) ;
		client_ip_address				= p.getProperty("client_ip_address");
		 locale							= p.getProperty("LOCALE");	
		group_code						= group_code.trim();
		sub_group_code					= sub_group_code.trim();
		maxrecord						= maxrecord.trim();
	
		mast_table_name_reference		= mast_table_name_reference.trim();
		function_name					= request.getParameter("function_name1");
		if(function_name==null || function_name.equals("null"))
		function_name="";


		      
		if(function_name.equals("tabulation"))
		insertTabulation(request,response);
		else
		insertSsorder(request,response);
	}

   /**  
     *  @author Shyamprasad
 	 *  Function for SSOrderCatalog Reports PER SS-RA101,PER SS-RA201,PER SS-RA206,PER SS-203
   **/
	private void insertSsorder(HttpServletRequest request, HttpServletResponse response)
	{
		int count						=0;
		count=Integer.parseInt(maxrecord);
		try
		{
			this.out					= response.getWriter();
			con							= ConnectionManager.getConnection(request);
			stmt						= con.createStatement();
			con.setAutoCommit(false);
			addedById					= p.getProperty( "login_user" ) ;
			modifiedById				= addedById ;
			addedFacilityId				= facilityId;
			modifiedFacilityId			= addedFacilityId ;
			addedAtWorkstation			= client_ip_address;
			modifiedAtWorkstation		= addedAtWorkstation ;
			String level_code3			= checkForNull(request.getParameter("level_code"));
			String sql22="";
			int i=1;
			try
			{

				for(i=1;i<count;i++)
				{
					order_catalog_code = checkForNull(request.getParameter("order_catalog_code"+i));
					text               = checkForNull(request.getParameter("text"+i));
					inc                = checkForNull(request.getParameter("inc"+i));
					ord_cat            = checkForNull(request.getParameter("ord_cat"+i));					
		
			
					if(inc.equals("") || inc.equals("N"))
					{
						if(report_id.equals("MRBRADEX") || report_id.equals("MRBLABRG"))
						{
							sql22 ="delete from mr_report_mapping where report_id=?  and mast_table_name_reference='OC' and mast_code=?  and GROUP_CODE=?  and SUB_GROUP_CODE=?";
							preStatement		=	con.prepareStatement(sql22);
							preStatement.setString(1, report_id);
							preStatement.setString(2, order_catalog_code);
							preStatement.setString(3, group_code);
							preStatement.setString(4, sub_group_code);
						}
						else
						{
							if(preStatement!=null)preStatement.close();
							sql22 ="delete from mr_report_mapping where report_id=?  and mast_table_name_reference=? and mast_code=?  and GROUP_CODE=?";
						
							preStatement		=	con.prepareStatement(sql22);
							preStatement.setString(1, report_id);
							preStatement.setString(2, mast_table_name_reference);
							preStatement.setString(3, order_catalog_code);
							preStatement.setString(4, group_code);
						}
						int res=preStatement.executeUpdate();
						if (res > 0) status = true;
						if(preStatement!=null)preStatement.close();
					}


					if(inc.equals("Y") && ((!(text.equals(""))) || report_id.equals("MRIPCSMH") || report_id.equals("MRBBAT3A") || report_id.equals("MRBBAT3B") || report_id.equals("MRBBAT3C")))
					{
						if(!report_id.equals("MRIPCSMH") &&  !report_id.equals("MRBBAT3A") && !report_id.equals("MRBBAT3B") && !report_id.equals("MRBBAT3C"))
							text1        =Integer.parseInt(text);
						if(report_id.equals("MRBRADEX") || report_id.equals("MRBLABRG"))
						{
							sql22 ="delete from mr_report_mapping where report_id=?  and mast_table_name_reference='OC' and mast_code=?  and GROUP_CODE=?  and SUB_GROUP_CODE=?";
							preStatement		=	con.prepareStatement(sql22);
							preStatement.setString(1, report_id);
							preStatement.setString(2, order_catalog_code);
							preStatement.setString(3, group_code);
							preStatement.setString(4, sub_group_code);
						}
						else
						{
							if(preStatement!=null)preStatement.close();
							sql22 ="delete from mr_report_mapping where report_id=?  and mast_table_name_reference=? and mast_code=?  and GROUP_CODE=?";
							preStatement		=	con.prepareStatement(sql22);
							preStatement.setString(1, report_id);
							preStatement.setString(2, mast_table_name_reference);
							preStatement.setString(3, order_catalog_code);
							preStatement.setString(4, group_code);
						}
//						int result=preStatement.executeUpdate();
						if(preStatement!=null)preStatement.close();
						
						
						boolean isInsert	= chkRecordExists(report_id,mast_table_name_reference,order_catalog_code,group_code,con);//Added By Dharma
				
						if(isInsert){
							String sp    ="insert into mr_report_mapping (report_id, group_code, mast_table_name_reference, mast_code, sub_group_code, report_desc, order_by_srl_no, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, level3_code ) values (?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?)";
							pstmt = con.prepareStatement(sp);
							pstmt.setString(1, report_id);
							pstmt.setString(2, group_code);
							pstmt.setString(3, mast_table_name_reference);
							pstmt.setString(4, order_catalog_code);
							pstmt.setString(5, sub_group_code);
							pstmt.setString(6, ord_cat);
							pstmt.setInt(7, text1);
							pstmt.setString(8, addedById);
							pstmt.setString(9, addedAtWorkstation);
							pstmt.setString(10, addedFacilityId);
							pstmt.setString(11, modifiedById);
							pstmt.setString(12, modifiedAtWorkstation);
							pstmt.setString(13, modifiedFacilityId);
							pstmt.setString(14, level_code3);
							
							cnt=pstmt.executeUpdate();
							if(pstmt != null)	pstmt.close();
							

							if(cnt>0)
								status=true;
							else
								status=false;
						}
						else
						{
						String update   = "update mr_report_mapping set order_by_srl_no = ? where report_id = ? and group_code = ? and mast_table_name_reference = ? and  mast_code = ?";
							pstmt = con.prepareStatement(update);
							pstmt.setInt(1, text1);
							pstmt.setString(2, report_id);
							pstmt.setString(3, group_code);
							pstmt.setString(4, mast_table_name_reference);
							pstmt.setString(5, order_catalog_code);
							
							cnt=pstmt.executeUpdate();
							if(pstmt != null)	pstmt.close();
							

							if(cnt>0)
								status=true;
							else
								status=false;
						}
					}
					else {}
				}
			}
			catch(Exception x)
			{
				/* out.println("Exceptioina at line 150"+x.getMessage()); */
				x.printStackTrace();
				status=false;
				con.rollback();
				error=x.getMessage();
			}
			if(status)
			{
				err_value="1";
				con.commit();
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				error = (String)hashtable1.get("message");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8")+"&err_value="+err_value);
			}
			else
			{
				err_value="0";
				con.rollback();
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8")+"&err_value="+err_value);	 	 
			}
			if(stmt!=null) stmt.close();
		}
		catch ( Exception e )
		{
			/*  out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString()); */
			 try
			 {
				 con.rollback();
			 }
			 catch(Exception eee)
			 {
				/* out.println("Exception raise by servlet"+eee.toString()); */
				eee.printStackTrace();
			 }
			e.printStackTrace();
	  }
      finally
	  {
	   	     if( con != null ) ConnectionManager.returnConnection(con,request);
	  }      
	}

	/**  
		 *  @author Shyamprasad
		 *  Function for Tabulation Reports and Other Reports
	 **/
	private void insertTabulation(HttpServletRequest request, HttpServletResponse response)
	{    
		int count = 0;
		count=Integer.parseInt(maxrecord);
		try
		{
			this.out					= response.getWriter();
			String level_code3			= checkForNull(request.getParameter("level_code"));
			level_code3					=level_code3.trim();
			con							= ConnectionManager.getConnection(request);
			stmt						= con.createStatement();
			con.setAutoCommit(false);
			addedById					= p.getProperty( "login_user" ) ;
			modifiedById				= addedById ;
			addedFacilityId				= facilityId;
			modifiedFacilityId			= addedFacilityId ;
			addedAtWorkstation			= client_ip_address;
			modifiedAtWorkstation		= addedAtWorkstation ;
			int i=1;
			try
			{
				String sql350="";
				for(i=1;i<count;i++)
				{
					tab_list_no			= checkForNull(request.getParameter("tab_list_no"+i));
					text                = checkForNull(request.getParameter("text"+i));
					inc                 = checkForNull(request.getParameter("inc"+i));
					tab_list            = checkForNull(request.getParameter("tab_list"+i));
					
					if(inc.equals("") || inc.equals("N"))
					{
						//String sql22="";
						//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
						if(report_id.equals("MRIPCSMB") || report_id.equals("MRDCCSMB") || report_id.equals("MROPCSMB"))
						{  //Above line Modified for this CRF PER-RH-0206
							sql350 ="delete from mr_report_mapping where report_id=?  and mast_table_name_reference='TL' and mast_code=?  and GROUP_CODE=?  and SUB_GROUP_CODE=? and LEVEL3_CODE=?";
							preStatement		=	con.prepareStatement(sql350);
							preStatement.setString(1, report_id);
							preStatement.setString(2, tab_list_no);
							preStatement.setString(3, group_code);
							preStatement.setString(4, sub_group_code);
							preStatement.setString(5, level_code3);
						}
						else if(report_id.equals("MRBPD207") && mast_table_name_reference.equals("BC") )
						{
							sql350 ="delete from mr_report_mapping where report_id=?  and mast_code=?  and GROUP_CODE=?  and SUB_GROUP_CODE=? ";
							preStatement		=	con.prepareStatement(sql350);
							preStatement.setString(1, report_id);
							preStatement.setString(2, tab_list_no);
							preStatement.setString(3, group_code);
							preStatement.setString(4, sub_group_code);
						}
						else
						{	
							if(preStatement!=null)preStatement.close();
							sql350 ="delete from mr_report_mapping where report_id=?  and mast_table_name_reference=? and mast_code=?  and GROUP_CODE=?  ";
							preStatement		=	con.prepareStatement(sql350);
							preStatement.setString(1, report_id);
							preStatement.setString(2, mast_table_name_reference);
							preStatement.setString(3, tab_list_no);
							preStatement.setString(4, group_code);
						}
						cnt = preStatement.executeUpdate();
						if(cnt>0)
							status=true;
						if(preStatement!=null)preStatement.close();
					}
					if(inc.equals("Y") && !(text.equals("")))
					{   //Below line Modified for this CRF PER-RH-0206 
						//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
						if(report_id.equals("MRIPCSMB") || report_id.equals("MRDCCSMB") || report_id.equals("MROPCSMB"))
						{
	  						if(preStatement!=null)preStatement.close();
							sql350 ="delete from mr_report_mapping where report_id=?  and mast_table_name_reference='TL' and mast_code=?  and GROUP_CODE=?  and SUB_GROUP_CODE=? and LEVEL3_CODE=?";
							preStatement		=	con.prepareStatement(sql350);
							preStatement.setString(1, report_id);
							preStatement.setString(2, tab_list_no);
							preStatement.setString(3, group_code);
							preStatement.setString(4, sub_group_code);
							preStatement.setString(5, level_code3);
						}
						else if(report_id.equals("MRBPD207") && mast_table_name_reference.equals("BC") )
						{
							sql350 ="delete from mr_report_mapping where report_id=?  and mast_code=?  and GROUP_CODE=?  and SUB_GROUP_CODE=? ";
							preStatement		=	con.prepareStatement(sql350);
							preStatement.setString(1, report_id);
							preStatement.setString(2, tab_list_no);
							preStatement.setString(3, group_code);
							preStatement.setString(4, sub_group_code);
						}
						else
						{
	  						if(preStatement!=null)preStatement.close();
							sql350 ="delete from mr_report_mapping where report_id=?  and mast_table_name_reference=? and mast_code=?  and GROUP_CODE=? ";
							preStatement		=	con.prepareStatement(sql350);
							preStatement.setString(1, report_id);
							preStatement.setString(2, mast_table_name_reference);
							preStatement.setString(3, tab_list_no);
							preStatement.setString(4, group_code);
						}
						preStatement.executeUpdate();
						if(preStatement!=null)preStatement.close();
						//float text_tab        =Float.parseFloat(text);
						String sp = "insert into mr_report_mapping (report_id, group_code, mast_table_name_reference, mast_code, sub_group_code, report_desc, order_by_srl_no, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, level3_code) values  (?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?)";
						pstmt = con.prepareStatement(sp);
						pstmt.setString(1, report_id);
						pstmt.setString(2, group_code);
						pstmt.setString(3, mast_table_name_reference);
						pstmt.setString(4, tab_list_no);
						pstmt.setString(5, sub_group_code);
						pstmt.setString(6, tab_list);
						pstmt.setString(7, text);						
						pstmt.setString(8, addedById);
						pstmt.setString(9, addedAtWorkstation);
						pstmt.setString(10, addedFacilityId);
						pstmt.setString(11, modifiedById);
						pstmt.setString(12, modifiedAtWorkstation);
						pstmt.setString(13, modifiedFacilityId);
						pstmt.setString(14, level_code3);
						cnt=pstmt.executeUpdate();
						if(pstmt != null)	pstmt.close();
						if(cnt>0)
							status=true;
						else
							status=false;
					}
				}
			}
			catch(Exception x){
				/* out.println("Exceptioina at line 150"+x.getMessage()); */
				status=false;
				con.rollback();
				error=x.getMessage();
				x.printStackTrace();
			}
			if(status){
				err_value="1";
				con.commit();
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				error = (String)hashtable1.get("message");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error)+"&err_value="+err_value);
				if ( hashtable1 != null ) hashtable1.clear();
			}else{
				err_value="0";
				con.rollback();
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error)+"&err_value="+err_value);	 	 
			}
			if(stmt!=null) stmt.close();
		}
		catch ( Exception e )
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString()); */
			try
			{
				con.rollback();
			}
			catch(Exception eee)
			{
				/* out.println("Exception raise by servlet"+eee.toString()); */
				eee.printStackTrace();
				
			}
			e.printStackTrace();
		}
		  finally
		  {
				 if( con != null ) ConnectionManager.returnConnection(con,request);
		  }    
	}
	public static String checkForNull(String inputString)
	{
		return( ( (inputString == null) || (inputString.equals("null") ) ) ? "" : inputString);
	}

	/*Below method added by Dharma*/
	public static boolean chkRecordExists(String report_id,String mast_table_name_reference,String order_catalog_code,String group_code,Connection con){
		boolean returnValue	= true;
		String SQL="select GROUP_CODE from mr_report_mapping where report_id=?  and mast_table_name_reference=? and mast_code=?  and GROUP_CODE=?";
		PreparedStatement pstmt	=null;
		ResultSet  rs=null;
		try{
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1,report_id);
			pstmt.setString(2,mast_table_name_reference);
			pstmt.setString(3,order_catalog_code);
			pstmt.setString(4,group_code);
			rs=pstmt.executeQuery();
			if(rs.next()){
				returnValue	= false;
			}
					
		}catch(Exception ex){
			//System.err.println("Exception in chkRecordExists - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return returnValue;
	}
}

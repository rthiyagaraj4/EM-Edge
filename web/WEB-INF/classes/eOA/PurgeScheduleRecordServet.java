/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA;

import javax.naming.*;
import javax.rmi.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.rmi.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.ArrayList;




public class PurgeScheduleRecordServet extends javax.servlet.http.HttpServlet	{
PrintWriter out;
java.util.Properties p;
Connection  con =null;

String facilityId;
String client_ip_address ;


String locn_type ;
String locn_code ;
String resc_type ;
String resc_code ;
String from_date;
String to_date;
String time_table_type;


public void init(ServletConfig config) throws ServletException	{
	super.init(config);
}

public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException{


	HttpSession session = req.getSession(false);
	this.facilityId = (String)session.getValue("facility_id") ;


	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.client_ip_address = p.getProperty("client_ip_address");

	try {
		this.out = res.getWriter();
		String operation = req.getParameter("function_name");

		if ( operation.equals("delete") )
			deleteSchrecords(req, res);
		

	}catch (Exception e)	{
		//out.println(e.toString());
		e.printStackTrace();
	}
}

private void deleteSchrecords(HttpServletRequest req, HttpServletResponse res)	{
	try {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		//String locale = p.getProperty("LOCALE");
		boolean deletable = true;
		String sql="";
		String sql1="";
		String sql2="";
		String sql3="";
		
		ResultSet rs=null;
		Statement stmt= null;
		PreparedStatement pstmt = null;
		StringBuffer sb  = new StringBuffer();
		java.util.ArrayList rowid1=new java.util.ArrayList();
		java.util.ArrayList rowid2=new java.util.ArrayList();
		java.util.ArrayList rowid3=new java.util.ArrayList();
		//StringBuffer sbMessage = new StringBuffer("");
		//boolean result = false;
		int reslt=0;
		int rw1=0;
		int i=0;
		int count=0;
		locn_type =req.getParameter("location_type") ==null?"":req.getParameter("location_type"); 
		locn_code =req.getParameter("location_code") ==null?"":req.getParameter("location_code");
		resc_type =req.getParameter("resourceType") ==null?"":req.getParameter("resourceType");
		resc_code =req.getParameter("practitioner") ==null?"":req.getParameter("practitioner");
		from_date =req.getParameter("eff_from") ==null?"":req.getParameter("eff_from");
		to_date =req.getParameter("eff_to") ==null?"":req.getParameter("eff_to");
		time_table_type =req.getParameter("time_table_type") ==null?"":req.getParameter("time_table_type");



	con= ConnectionManager.getConnection(p);
	//Below Query modified by Kamatchi S for security issue against COMMON-ICN-0165
	//sql1="select rowid from oa_clinic_schedule where facility_id='"+facilityId+"' and clinic_code='"+locn_code+"' and clinic_date BETWEEN to_date('"+from_date+"', 'dd/mm/yyyy') and to_date('"+to_date+"', 'dd/mm/yyyy') +0.999 and  nvl(practitioner_id,'X') =nvl('"+resc_code+"','X') and care_locn_type_ind='"+locn_type+"'  and resource_class='"+resc_type+"'";
	sql1="select rowid from oa_clinic_schedule where facility_id= ? and clinic_code= ? and clinic_date BETWEEN to_date(?, 'dd/mm/yyyy') and to_date(?, 'dd/mm/yyyy') +0.999 and  nvl(practitioner_id,'X') =nvl(?,'X') and care_locn_type_ind= ?  and resource_class= ? ";
		 //stmt = con.createStatement() ;
		 //rs =stmt.executeQuery(sql1);
		 pstmt   = con.prepareStatement(sql1);
		 pstmt.setString    (    1,    facilityId      );
		 pstmt.setString    (    2,    locn_code        );
		 pstmt.setString    (    3,    from_date        );
		 pstmt.setString    (    4,    to_date        );
		 pstmt.setString    (    5,    resc_code        );
		 pstmt.setString    (    6,    locn_type        );
		 pstmt.setString    (    7,    resc_type        );
		 rs	= pstmt.executeQuery();
		i=0;
		while(rs.next())
		{
		rowid1.add(i,rs.getString("rowid"));
		i++;
		}

		if(rs!=null) rs.close();

	//Below Query modified by Kamatchi S for security issue against COMMON-ICN-0165
	//sql2=" select rowid from oa_clinic_schedule_slot_slab where facility_id='"+facilityId+"' and clinic_code='"+locn_code+"' and clinic_date BETWEEN to_date('"+from_date+"', 'dd/mm/yyyy') and to_date('"+to_date+"', 'dd/mm/yyyy') +0.999 and  nvl(practitioner_id,'X') =nvl('"+resc_code+"','X') and care_locn_type_ind='"+locn_type+"'  and resource_class='"+resc_type+"'";
	sql2=" select rowid from oa_clinic_schedule_slot_slab where facility_id=? and clinic_code= ? and clinic_date BETWEEN to_date(?, 'dd/mm/yyyy') and to_date(?, 'dd/mm/yyyy') +0.999 and  nvl(practitioner_id,'X') =nvl(?,'X') and care_locn_type_ind=?  and resource_class=?";
		
		//Below Lines modified by Kamatchi S for security issue against COMMON-ICN-0165
		if (pstmt!=null) pstmt.close();

		//stmt = con.createStatement() ;
		 //rs =stmt.executeQuery(sql2);
		pstmt   = con.prepareStatement(sql2);
		pstmt.setString    (    1,    facilityId        );
		pstmt.setString    (    2,    locn_code        );
		pstmt.setString    (    3,    from_date        );
		pstmt.setString    (    4,    to_date        );
		pstmt.setString    (    5,    resc_code        );
		pstmt.setString    (    6,    locn_type        );
		pstmt.setString    (    7,    resc_type        );
		rs = pstmt.executeQuery();
		
		i=0;
		while(rs.next())
		{
		rowid2.add(i,rs.getString("rowid"));
		i++;
		}

		if(rs!=null) rs.close();



	//sql3=" select rowid from oa_clinic_schedule_break where facility_id='"+facilityId+"' and clinic_code='"+locn_code+"' and clinic_date BETWEEN to_date('"+from_date+"', 'dd/mm/yyyy') and to_date('"+to_date+"', 'dd/mm/yyyy') +0.999 and  nvl(practitioner_id,'X') =nvl('"+resc_code+"','X') and care_locn_type_ind='"+locn_type+"'  and resource_class='"+resc_type+"'";
	sql3=" select rowid from oa_clinic_schedule_break where facility_id=? and clinic_code=? and clinic_date BETWEEN to_date(?, 'dd/mm/yyyy') and to_date(?, 'dd/mm/yyyy') +0.999 and  nvl(practitioner_id,'X') =nvl(?,'X') and care_locn_type_ind=?  and resource_class=? ";

		//stmt = con.createStatement() ;
		//Below Lines modified by Kamatchi S for security issue against COMMON-ICN-0165
		if (pstmt!=null) pstmt.close();
		//stmt = con.createStatement() ;
		 //rs =stmt.executeQuery(sql3);
		pstmt   = con.prepareStatement(sql3);
		pstmt.setString    (    1,    facilityId        );
		pstmt.setString    (    2,    locn_code        );
		pstmt.setString    (    3,    from_date        );
		pstmt.setString    (    4,    to_date        );
		pstmt.setString    (    5,    resc_code        );
		pstmt.setString    (    6,    locn_type        );
		pstmt.setString    (    7,    resc_type        );
		//for security issue against COMMON-ICN-0165 end
		rs = pstmt.executeQuery();
		
		 i=0;
		while(rs.next())
		{
		rowid3.add(i,rs.getString("rowid"));
		i++;
		}

		if(rs!=null) rs.close();


	

		if((rowid1.size()>rowid2.size())&&(rowid1.size()>rowid3.size()))
		{
			rw1=rowid1.size();
		}
		else if((rowid2.size()>rowid1.size())&&(rowid2.size()>rowid3.size()))
		{
			rw1=rowid2.size();
		}
		else
		rw1=rowid3.size();


		boolean isLessThanRecord=false;
		for (i=0;i<rw1;i++)
		{
			isLessThanRecord=false;
		
	
//	sql="delete from oa_clinic_schedule where facility_id='"+facilityId+"' and clinic_code='"+locn_code+"' and clinic_date BETWEEN to_date('"+from_date+"', 'dd/mm/yyyy') and to_date('"+to_date+"', 'dd/mm/yyyy') +0.999 and  nvl(practitioner_id,'X') =nvl('"+resc_code+"','X') and care_locn_type_ind='"+locn_type+"'  and resource_class='"+resc_type+"'";
				 
				 if(i<rowid1.size())
				{
				//Below Query commented for security issue against COMMON-ICN-0165 By Kamatchi S 
				//sql="delete from oa_clinic_schedule where rowid='"+rowid1.get(i)+"'";	
				sql="delete from oa_clinic_schedule where rowid=?";	
							 
				//Below Lines modified by Kamatchi S for security issue against COMMON-ICN-0165
				 if (pstmt!=null) pstmt.close();			 
				 pstmt = con.prepareStatement(sql) ;
				 pstmt.setString    (    1, String.valueOf(rowid1.get(i)));
				 reslt =pstmt.executeUpdate();

					if(reslt !=0){
						deletable = true;
					}else{
						deletable = false;
						sb.append("Delete OA_CLINIC_SCHEDULE has failed");
					}
				}//end if

				if(i<rowid2.size())
				{
				if (deletable)
				{
					if(time_table_type.equals("1") || time_table_type.equals("2"))
				{
			//		 sql=" delete from oa_clinic_schedule_slot_slab where facility_id='"+facilityId+"' and clinic_code='"+locn_code+"' and clinic_date BETWEEN to_date('"+from_date+"', 'dd/mm/yyyy') and to_date('"+to_date+"', 'dd/mm/yyyy') +0.999  and  nvl(practitioner_id,'X') =nvl('"+resc_code+"','X') and care_locn_type_ind='"+locn_type+"'  and resource_class='"+resc_type+"'";
			//Below Lines modified by Kamatchi S for security issue against COMMON-ICN-0165
			//sql="delete from oa_clinic_schedule_slot_slab where rowid='"+rowid2.get(i)+"'";
			sql="delete from oa_clinic_schedule_slot_slab where rowid=?";


						if (pstmt!=null) pstmt.close();
						pstmt = con.prepareStatement(sql) ;
						pstmt.setString    (    1,    String.valueOf(rowid2.get(i)) );
						reslt =pstmt.executeUpdate();
						if(reslt !=0){
							deletable = true;
						}else{
							deletable = false;
							sb.append("Delete OA_CLINIC_SCHEDULE_Slot_slab has failed");
						}
			}
				}
			}//end if

			if(i<rowid3.size())
			{
			if (deletable)
				{
		//		 sql=" delete from oa_clinic_schedule_break where facility_id='"+facilityId+"' and clinic_code='"+locn_code+"' and clinic_date BETWEEN to_date('"+from_date+"', 'dd/mm/yyyy') and to_date('"+to_date+"', 'dd/mm/yyyy') +0.999 and  nvl(practitioner_id,'X') =nvl('"+resc_code+"','X') and care_locn_type_ind='"+locn_type+"'  and resource_class='"+resc_type+"'";
		//Below Lines modified by Kamatchi S for security issue against COMMON-ICN-0165
		//sql="delete from oa_clinic_schedule_break where rowid='"+rowid3.get(i)+"'";
				sql="delete from oa_clinic_schedule_break where rowid=?";

				if (pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(sql) ;
				pstmt.setString    (    1,   String.valueOf(rowid3.get(i)) );
				reslt =pstmt.executeUpdate();
				if (pstmt!=null) pstmt.close();

				}	
		}//end if

		count++;
			
			if(count>=200 && deletable)
			{
			con.commit();
			count=0;
			deletable = true;
			isLessThanRecord=true;
			}
			else if(!deletable)
			{
				con.rollback();
				count=0;
				deletable=false;
				break;
			}

		}

		if(stmt!=null)stmt.close();

		if (pstmt!=null) pstmt.close(); 

		if((!isLessThanRecord) && deletable==true)
		{

			con.commit();
		}

			

			if ( deletable )
			{
			//	con.commit();
				out.println("<script>parent.onsuccess('true')</script>");
			}
			else
			{
				//con.rollback();
				out.println("<script>parent.onsuccess('false')</script>");
				
			}

			
			


	} catch ( Exception e ) {
		//Commented by Kamatchi S for security issue against COMMON-ICN-0165
		//out.println(e.getMessage());
		//out.println(e.toString());
		e.printStackTrace();
	}finally
		{
		ConnectionManager.returnConnection(con,p);
		}
	
}
}

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

public class ReportGroupMasterServlet extends HttpServlet{
	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
//	private ServletConfig config=null;
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id = "";
	String modified_at_ws_no = "";
	String modified_facility_id = "";
	String client_ip_address = "";
	String Groupcode = "";
    String Groupname ="";
    String Report_Id ="" ;
    String master ="" ;
    String serial_no ="";
	String print_desc ="" ;
	String Group_type ="" ;
	String Main_Group ="" ;
	String sql ="" ;
	String eMR_err_msg ="" ;
	String level3_code="";
	String group_type_new="";
	Connection con;
	//Statement stmt=null;
	PreparedStatement stmt=null;
	ResultSet rs=null; 
	String locale = "";

	int maxRecord = 0;

	public void init(ServletConfig config)throws ServletException{
		super.init(config);
//		this.config = config;
	}
	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException{
		this.out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try{ 
			con = ConnectionManager.getConnection(request);
			con.setAutoCommit(false);
			session		= request.getSession(false);
			this.prop	= (java.util.Properties)session.getValue("jdbc");
			this.added_facility_id	 =	(String)session.getValue("facility_id");
			client_ip_address			 =	this.prop.getProperty("client_ip_address");
			locale							 =	this.prop.getProperty("LOCALE");
			modified_by_id			 = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
			modified_facility_id		 = (this.added_facility_id==null)?"":this.added_facility_id;
			modified_at_ws_no		 = (client_ip_address==null)?"":client_ip_address;
			String s = request.getParameter("function");  
			if(s.equals("insert"))
				insert(request);
			if(s.equals("modify"))
				modify(request);
		}catch(Exception e){}
		finally{
			  if( con != null ) ConnectionManager.returnConnection(con,request);
		}
	}//end of doPost() 

	public synchronized void doGet(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException,IOException{
		try{
			this.out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			doPost(request,response);
		}catch(Exception e){
			//out.println("Exception in doGet() of ReportGroupMasterServlet.java"+e);
			e.printStackTrace();
		}
	}//end of doGet()

	//***********Start of modify************************
	private void modify(HttpServletRequest request){
		try{
			boolean status=true;
			String error = "";
			added_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
			added_facility_id = (this.added_facility_id == null)?"":this.added_facility_id; 
			added_at_ws_no = (client_ip_address == null)?"":client_ip_address; 
			group_type_new = request.getParameter("group_type_new")!= null ? request.getParameter("group_type_new") : "";
			Groupcode = request.getParameter("group_code")!= null ? request.getParameter("group_code") : "";
			Groupname = request.getParameter("group_name")!= null ? request.getParameter("group_name") : "";
			Report_Id = request.getParameter("Report_Id_hid")!= null ? request.getParameter("Report_Id_hid") : "";
			String newstatus=request.getParameter("newstatus");
			Group_type = request.getParameter("Group_type")!= null ? request.getParameter("Group_type") : "M";
			Main_Group = request.getParameter("Main_Group_hid")!= null ? request.getParameter("Main_Group_hid") : "";
			String  no_of_bes = request.getParameter("no_of_bes")!= null ? request.getParameter("no_of_bes") : "";
			String  no_of_bes_0 = request.getParameter("no_of_bes_0")!= null ? request.getParameter("no_of_bes_0") : "";
			String  no_of_bes_1 = request.getParameter("no_of_bes_1")!= null ? request.getParameter("no_of_bes_1") : "";
			

		    //Below line modified for this CRF PER-PD-209A
			if(Report_Id.equals("MRBRADEX") || Report_Id.equals("MRBLABRG") || Report_Id.equals("MROPCSMB") || Report_Id.equals("MRIPCSMB") || Report_Id.equals("MRIPCSBD") || Report_Id.equals("MRIPCSOBD") || Report_Id.equals("OPBMTMOR") || Report_Id.equals("IPBMRMOT") || Report_Id.equals("IPBEXCDT") || Report_Id.equals("MRBPD207")){
				Group_type = request.getParameter("Group_type_hid")!= null ? request.getParameter("Group_type_hid") : "M";
				Main_Group = request.getParameter("Main_Group_hid")!= null ? request.getParameter("Main_Group_hid") : "";
			}
			master = request.getParameter("type_hid")!= null ? request.getParameter("type_hid"): "";
			serial_no = request.getParameter("serial_no")!= null ? request.getParameter("serial_no") : "";
			print_desc = request.getParameter("prn_desc")!= null ? request.getParameter("prn_desc") : "";

			if(newstatus.equals("Y")){
				status = true;
			}else{
			    sql="select count(*) total from mr_report_grouping where order_by_srl_no= ? ";
				stmt=con.prepareStatement(sql);
				
				stmt.setString(1, serial_no);
							
				
				rs = stmt.executeQuery();
				rs.next();
				maxRecord = rs.getInt("total");
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if (maxRecord>0){
						String sql1="select report_id,subgroup_code,mast_table_name_reference,LEVEL3_CODE,GROUP_CATEGORY,GROUP_TYPE from MR_REPORT_GROUPING where order_by_srl_no= ?";
						stmt=con.prepareStatement(sql1);
				
						stmt.setString(1, serial_no);
						rs=stmt.executeQuery();
					while(rs.next()){
						String rep_id=rs.getString("report_id");
						String table_reference=rs.getString("mast_table_name_reference");
						String GROUP_CATEGORY1= rs.getString("GROUP_CATEGORY");
						String subgroup_code1= rs.getString("subgroup_code");
						String level3_code1= rs.getString("LEVEL3_CODE");
						String group_type1= rs.getString("GROUP_TYPE");
						
						//Below line modified for this CRF PER-PD-209A

						if(( Report_Id.equals("MRBRADEX") || Report_Id.equals("MRIPCSBD") || Report_Id.equals("MRBLABRG") || Report_Id.equals("MROPCSMB") || Report_Id.equals("MRIPCSMB") || Report_Id.equals("MRIPCSOBD") || Report_Id.equals("OPBMTMOR") || Report_Id.equals("IPBMRMOT") || Report_Id.equals("IPBEXCDT")) && GROUP_CATEGORY1.equals("S")){
							if(Report_Id.equals(rep_id) && master.equals(table_reference) && subgroup_code1.equals(Main_Group) && Group_type.equals(GROUP_CATEGORY1)){
								eMR_err_msg = request.getParameter("err_msg")!= null ? request.getParameter("err_msg") : "";
								error = eMR_err_msg;
								status=false;
							}
						}
						/////////Newly added on 25/08/2005//////
						else if((Report_Id.equals("MROPCSMB") || Report_Id.equals("MRIPCSMB")) && GROUP_CATEGORY1.equals("G")){
							if(Report_Id.equals(rep_id) && master.equals(table_reference) && subgroup_code1.equals(Main_Group)  && Group_type.equals(GROUP_CATEGORY1) && level3_code.equals(level3_code1)){
								eMR_err_msg = request.getParameter("err_msg")!= null ? request.getParameter("err_msg") : "";
								error = eMR_err_msg;
								status=false;
							}
					    }else if((Report_Id.equals("MRBBAT3A")) && table_reference.equals("NS")){
							if(Report_Id.equals(rep_id) && master.equals(table_reference)  && Group_type.equals(GROUP_CATEGORY1) && group_type_new.equals(group_type1)){
								eMR_err_msg = request.getParameter("err_msg")!= null ? request.getParameter("err_msg") : "";
								error = eMR_err_msg;
								status=false;
							}
						}else{
							if(Report_Id.equals(rep_id) && master.equals(table_reference) && Group_type.equals(GROUP_CATEGORY1)){
								eMR_err_msg = request.getParameter("err_msg")!= null ? request.getParameter("err_msg") : "";
								error = eMR_err_msg;
								status=false;
							}
						}
					} 
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				}
			}
			if(status){
				try{
					 sql="update mr_report_grouping set group_desc = ? ,order_by_srl_no=? ,print_desc_yn =?,modified_date=sysdate,modified_by_id =? ,modified_at_ws_no =?,modified_facility_id =?, no_of_beds_for_splty=?,no_of_oper_beds_for_splty=?,no_of_ofcl_beds_for_splty=?  where group_code =? and report_id =? and mast_table_name_reference =? and group_category = ?";
					 stmt=con.prepareStatement(sql);
				
				     stmt.setString(1, Groupname);
				     stmt.setString(2, serial_no);
				     stmt.setString(3, print_desc);
				     stmt.setString(4, modified_by_id);
				     stmt.setString(5, modified_at_ws_no);
				     stmt.setString(6, modified_facility_id);
				     stmt.setString(7, no_of_bes);
				     stmt.setString(8, no_of_bes_1);
				     stmt.setString(9, no_of_bes_0);
				     stmt.setString(10, Groupcode);
				     stmt.setString(11, Report_Id);
				     stmt.setString(12, master);
				     stmt.setString(13, Group_type);
					 
					 
					 int iii = 0;
					 try{
						iii=stmt.executeUpdate();
					 }catch(Exception e){
						 e.printStackTrace();
					 }
                     if(stmt!=null) stmt.close();
					if (iii>0){
						con.commit();
						java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
						String msg = (String) message.get("message");
						error=msg;
						//error_value= "1";
						out.println("<html><script>parent.frames[3].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" )+"&err_value=1"+"\";</script><body class='message'></html>");
						//response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
					}else{
						error="Transaction Failed ...";
						out.println(error);
					}
				}catch(Exception exp){
					con.rollback();
					//out.println("Exception From Servlet ...So Record Not modified"+exp);
					exp.printStackTrace();
				}
			}else{
				out.println("<html><script>parent.frames[3].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" )+"&err_value=0"+"\";</script><body class='message'></html>");
			}
		}catch(Exception e){
			//out.println("<h3> Exception raised by Servlet ...So Record Not modified </h3> Foll: Error Received 1: "+e.toString());
			e.printStackTrace();
		}
	}
	//***********Start of Insert************************

	private void insert(HttpServletRequest request){
		try{
			String error="";
			boolean status=true;
			boolean newstatus=true;
			added_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
			added_facility_id = (this.added_facility_id == null)?"":this.added_facility_id; 
			added_at_ws_no = (client_ip_address == null)?"":client_ip_address; 
            group_type_new = request.getParameter("group_type_new")!= null ? request.getParameter("group_type_new") : "";
			Groupcode = request.getParameter("group_code")!= null ? request.getParameter("group_code") : "";
			Groupname = request.getParameter("group_name")!= null ? request.getParameter("group_name") : "";
			Report_Id = request.getParameter("Report_Id")!= null ? request.getParameter("Report_Id") : "";
			Group_type = request.getParameter("Group_type")!= null ? request.getParameter("Group_type") : "M";
			Main_Group = request.getParameter("Main_Group")!= null ? request.getParameter("Main_Group") : "";
			String range = request.getParameter("range")!= null ? request.getParameter("range") : "";
			String no_of_bes = request.getParameter("no_of_bes")!= null ? request.getParameter("no_of_bes") : "";
			String no_of_bes_0 = request.getParameter("no_of_bes_0")!= null ? request.getParameter("no_of_bes_0") : "";
			String no_of_bes_1 = request.getParameter("no_of_bes_1")!= null ? request.getParameter("no_of_bes_1") : "";
			
			 

			level3_code = request.getParameter("LEVEL3_CODE_INSERT")!= null ? request.getParameter("LEVEL3_CODE_INSERT") : "";
			//Below line modified for this CRF PER-PD-209A
			if(Report_Id.equals("MRBRADEX") || Report_Id.equals("MRBLABRG") || Report_Id.equals("MRIPCSBD") || Report_Id.equals("MRIPCSOBD")){
				Group_type = request.getParameter("Group_type")!= null ? request.getParameter("Group_type") : "M";
				Main_Group = request.getParameter("Main_Group")!= null ? request.getParameter("Main_Group") : "";
			}
			master = request.getParameter("type")!= null ? request.getParameter("type") : "";
			serial_no = request.getParameter("serial_no")!= null ? request.getParameter("serial_no") : "";
			print_desc = request.getParameter("prn_desc")!= null ? request.getParameter("prn_desc") : "";
			String sqldupchk="select * from mr_report_grouping";
			stmt=con.prepareStatement(sqldupchk);
			rs = stmt.executeQuery();
			while(rs.next()){
				if(Groupcode.equals(rs.getString("group_code")) && Report_Id.equals(rs.getString("report_id")) && master.equals(rs.getString("mast_table_name_reference")) )
				{
					error="APP-MR0001 Code already Exists";
					newstatus=false;
				}
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(newstatus){
				sql="select count(*) total from mr_report_grouping where order_by_srl_no=?";
				stmt=con.prepareStatement(sql);
				
				stmt.setString(1, serial_no);
								
				rs = stmt.executeQuery();
				rs.next();
				maxRecord = rs.getInt("total");
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				String sql1="";
				if (maxRecord > 0){
					sql1="select order_by_srl_no,report_id,LEVEL3_CODE, mast_table_name_reference, group_category,subgroup_code,group_type from mr_report_grouping where MAST_TABLE_NAME_REFERENCE=? and REPORT_ID= ? and order_by_srl_no = ?";
					stmt=con.prepareStatement(sql1);
				
						stmt.setString(1, master);
						stmt.setString(2, Report_Id);
						stmt.setString(3, serial_no);
						rs=stmt.executeQuery();
					while(rs.next())
					{
						String rep_id=rs.getString("report_id");
						String table_reference=rs.getString("mast_table_name_reference");
						String GROUP_CATEGORY1= rs.getString("group_category");
						String subgroup_code1= rs.getString("subgroup_code");
						String level3_code1= rs.getString("LEVEL3_CODE");
						String group_type1= rs.getString("group_type");
						//Below line modified for this CRF PER-PD-209A
						if((Report_Id.equals("MRBRADEX") || Report_Id.equals("MRBLABRG") || Report_Id.equals("MRIPCSOBD") || Report_Id.equals("MRIPCSBD") || Report_Id.equals("MRBPD207"))  && GROUP_CATEGORY1.equals("S"))
						{
							if(Report_Id.equals(rep_id) && master.equals(table_reference) && subgroup_code1.equals(Main_Group)  && Group_type.equals(GROUP_CATEGORY1) )
							{
								eMR_err_msg = request.getParameter("err_msg")!= null ? request.getParameter("err_msg") : "";
								error = eMR_err_msg;
								status=false;
							}
						}
						/////////////Newly added on 25/08/2005 ////////////////////
						else if((Report_Id.equals("MRIPCSMB")) && GROUP_CATEGORY1.equals("G"))
						{
							
							if(Report_Id.equals(rep_id) && master.equals(table_reference) && subgroup_code1.equals(Main_Group)  && Group_type.equals(GROUP_CATEGORY1) && level3_code.equals(level3_code1))
							{
								eMR_err_msg = request.getParameter("err_msg")!= null ? request.getParameter("err_msg") : "";
								error = eMR_err_msg;
								status=false;
							}
						}
						else if((Report_Id.equals("MRBBAT3A")) && table_reference.equals("NS"))
						{
							
							if(Report_Id.equals(rep_id) && master.equals(table_reference)  && Group_type.equals(GROUP_CATEGORY1) && group_type_new.equals(group_type1))
							{
								eMR_err_msg = request.getParameter("err_msg")!= null ? request.getParameter("err_msg") : "";
								error = eMR_err_msg;
								status=false;
							}
						}
						////////////////end////////////////
						else{
							if(Report_Id.equals(rep_id) && master.equals(table_reference) && Group_type.equals(GROUP_CATEGORY1)){
								eMR_err_msg = request.getParameter("err_msg")!= null ? request.getParameter("err_msg") : "";
								error = eMR_err_msg;
								status=false;
							}
						}
					} 
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				}
				if (status){
					try{
						String sp = "insert into mr_report_grouping (group_code, group_desc, report_id, group_category, subgroup_code, mast_table_name_reference, order_by_srl_no, print_desc_yn, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, level3_code, level3_range, group_type,no_of_beds_for_splty,no_of_oper_beds_for_splty,no_of_ofcl_beds_for_splty) values (?, ?,?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?, ?, ?,?,?,?)";
						PreparedStatement pstmt = null; 
						pstmt = con.prepareStatement(sp);
						pstmt.setString(1,Groupcode);
						pstmt.setString(2,Groupname);
						pstmt.setString(3,Report_Id);
						pstmt.setString(4,Group_type);
						pstmt.setString(5,Main_Group);
						pstmt.setString(6,master);
						pstmt.setString(7,serial_no);
						pstmt.setString(8,print_desc);
						pstmt.setString(9,added_by_id);
						pstmt.setString(10,added_at_ws_no);
						pstmt.setString(11,added_facility_id);
						pstmt.setString(12,modified_by_id);
						pstmt.setString(13,modified_at_ws_no);
						pstmt.setString(14,modified_facility_id);
						pstmt.setString(15,level3_code);
						pstmt.setString(16,range);
						pstmt.setString(17,group_type_new);
						pstmt.setString(18,no_of_bes);
						pstmt.setString(19,no_of_bes_1);
						pstmt.setString(20,no_of_bes_0);
						int iii=pstmt.executeUpdate();
						if(pstmt!=null) pstmt.close();
						if (iii>0){
							con.commit();
							java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
							String msg = (String) message.get("message");
							error=msg;
							out.println("<html><script>parent.frames[3].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" )+"&err_value=1"+"\";</script><body class='message'></html>");
						}else{
							out.println("<html><script>parent.frames[3].location.href ='../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error, "UTF-8" )+"&err_value=0';</script><body class='message'></html>");
						}
					}catch(Exception exp){
						con.rollback();
						//out.println("From Servlet--Calling EJB:"+exp);
						exp.printStackTrace();
					}
				}else{
					out.println("<html><script>parent.frames[3].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" )+"&err_value=0"+"\";</script><body class='message'></html>");
				}
			}else{
				 out.println("<html><script>parent.frames[3].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" )+"&err_value=0"+"\";</script><body class='message'></html>");
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}catch(Exception e){
			//out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received 2: "+e.toString());
			
			e.printStackTrace();
		}
		//end of catch
	}//end of insert
}

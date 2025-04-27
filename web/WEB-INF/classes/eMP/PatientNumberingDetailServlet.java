/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eCommon.SingleTabHandler.*;
import webbeans.eCommon.*;

public class PatientNumberingDetailServlet extends javax.servlet.http.HttpServlet	
{
PrintWriter out;
java.util.Properties p;

String patSerGrpCode ;
String siteOrFacility ;
String siteOrFacilityId ;
String start_srl_no;
String max_srl_no;
String usedStatus;
String mrSectionCode ;
String separateFileNoYn;
String createFileAtRegnYn;
String client_ip_address ;
String record_srl_no = "";

String pat_no_ctrl= "";
String result_value= "";
String facilityId="";
String readonly_flag="";
String locale ="";

String gen_pid_using_alt_id1_rule_yn="";

long maxRecord;

public void init(ServletConfig config) throws ServletException	{
	super.init(config);
	}
public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");	
	
	HttpSession session = req.getSession(false);
	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;

	client_ip_address = p.getProperty("client_ip_address");

	try {
		this.out = res.getWriter();
		String operation = req.getParameter("function");
		this.facilityId = (String) session.getAttribute( "facility_id" ) ;
		locale = p.getProperty("LOCALE");

	if ( operation.equals("insert") )
		insertPatientNumberDetail(req, res);
	if ( operation.equals("modify"))
			modifyPatientNumberDetail(req, res);
	}
	catch (Exception e)	{
		out.println(e.toString());
		}
	}
public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
			Connection con = null;
	try	{
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	this.out = res.getWriter();



	Statement stmt;
	ResultSet rs;

	con = ConnectionManager.getConnection(req);
	stmt = con.createStatement();

	rs = stmt.executeQuery("select patient_no_ctrl from mp_param");

	if ( rs.next()  ) {
					String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
					String params = req.getQueryString() ;
					String source = url + params ;
					out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/PatientNumberingDetail.js'></script></head><iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe> <iframe name='f_query_add_mod' id='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:40vh;width:100vw'></iframe> <iframe name='result' id='result_det' src='../eCommon/html/blank.html' frameborder=0 scrolling='auto' style='height:45vh;width:100vw'></iframe> <iframe name='messageFrame' id='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe></html> ");
		}
		else
		{
			java.util.Hashtable message = MessageManager.getMessage( locale, "MP_PARAM_NOT_FOUND","MP" ) ;
			String msg = (String) message.get("message");
			out.println("<script>alert('"+msg+"')</script>");
			out.println("<script>document.location.href='../eCommon/jsp/dmenu.jsp';</script>");
			message.clear();

		//out.println("<Script language='JavaScript'>alert(parent.getMessage('MP_PARAM_NOT_FOUND','MP'));</Script>");
		}

		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();

	}
	catch(Exception e)	{	}
	finally
		{
			if (con!= null) ConnectionManager.returnConnection(con,req);
		}
	}
private void modifyPatientNumberDetail(HttpServletRequest req, HttpServletResponse res)	{
	Connection con = null;
	try {
		
		//String locale = p.getProperty("LOCALE");
		con = ConnectionManager.getConnection(req);
		//Statement pstmt2=con.createStatement();
		Statement pstmt3=con.createStatement();
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt4 = null;
		//Statement pstmt4=con.createStatement();
		//ResultSet rs3;
		int res1 =0;
		int res2=0;
		String Sql="";
		String sql2="";
		String sql2_del="";


		patSerGrpCode = req.getParameter("pat_ser_grp_code");
		siteOrFacility = req.getParameter("site_or_facility");
		siteOrFacilityId = req.getParameter("site_or_facility_id");
		usedStatus="N";
		start_srl_no= req.getParameter("start_srl_no");
		max_srl_no = req.getParameter("max_srl_no");
		mrSectionCode = req.getParameter("mr_section_code");
		separateFileNoYn= req.getParameter("separate_file_no_yn");
		
		record_srl_no = req.getParameter("record_srl_no");

		pat_no_ctrl= req.getParameter("pat_no_ctrl");
		result_value= req.getParameter("result_value");
		gen_pid_using_alt_id1_rule_yn = req.getParameter("gen_pid_using_alt_id1_rule_yn");
		readonly_flag= req.getParameter("readonly_flag");



		if (siteOrFacility == null)
			siteOrFacility = "";
		if (siteOrFacilityId == null)
			siteOrFacilityId = "";
		if (start_srl_no == null)
			start_srl_no = "";
		if (max_srl_no == null)
			max_srl_no = "";



			
		if ( separateFileNoYn == null )
				separateFileNoYn ="N";
		if ( createFileAtRegnYn == null )
				createFileAtRegnYn ="N";

	
	String addedById = p.getProperty( "login_user" ) ;
	String modifiedById = addedById ;
	String addedAtWorkstation=client_ip_address;
	String modifiedAtWorkstation = addedAtWorkstation ;
	/*Added by lakshmanan for security issue ID 174131244 on 21-08-2023 start */
	java.util.HashMap psthashmap		=	new java.util.HashMap() ;
	int psthmcount=0;
	/*Added by lakshmanan for security issue ID 174131244 on 21-08-2023 end */
	
							
		if(!readonly_flag.equals("Y"))
		{			

		if(!pat_no_ctrl.equals("Z"))
		{

		Sql="Update MP_PAT_SER_FACILITY set SITE_OR_FACILITY =?,SITE_OR_FACILITY_ID=?,RECORD_SRL_NO=? ,PAT_SER_GRP_CODE=?,START_SRL_NO=? ,MAX_SRL_NO=? ,MR_SECTION_CODE=? ,SEPARATE_FILE_NO_YN=? ,MODIFIED_BY_ID=? ,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=? where RECORD_SRL_NO = ?  and PAT_SER_GRP_CODE = ? ";
			psthashmap.put(++psthmcount,siteOrFacility);
			psthashmap.put(++psthmcount,siteOrFacilityId);
			psthashmap.put(++psthmcount,record_srl_no);
			psthashmap.put(++psthmcount,patSerGrpCode);
			psthashmap.put(++psthmcount,start_srl_no);
			psthashmap.put(++psthmcount,max_srl_no);
			psthashmap.put(++psthmcount,mrSectionCode);
			psthashmap.put(++psthmcount,separateFileNoYn);
			psthashmap.put(++psthmcount,modifiedById);
			psthashmap.put(++psthmcount,modifiedAtWorkstation);
			psthashmap.put(++psthmcount,record_srl_no);
			psthashmap.put(++psthmcount,patSerGrpCode);
		

		}
		else
		{
				 
		Sql="Update MP_PAT_SER_FACILITY set SITE_OR_FACILITY =? ,SITE_OR_FACILITY_ID=? ,RECORD_SRL_NO=? ,PAT_SER_GRP_CODE=? ,START_SRL_NO=? ,MAX_SRL_NO=? ,SEPARATE_FILE_NO_YN=? ,MODIFIED_BY_ID=? ,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=? where RECORD_SRL_NO = ?  and PAT_SER_GRP_CODE =? ";
		psthashmap.put(++psthmcount,siteOrFacility);
		psthashmap.put(++psthmcount,siteOrFacilityId);
		psthashmap.put(++psthmcount,record_srl_no);
		psthashmap.put(++psthmcount,patSerGrpCode);
		psthashmap.put(++psthmcount,start_srl_no);
		psthashmap.put(++psthmcount,max_srl_no);
		psthashmap.put(++psthmcount,separateFileNoYn);
		psthashmap.put(++psthmcount,modifiedById);
		psthashmap.put(++psthmcount,modifiedAtWorkstation);
		psthashmap.put(++psthmcount,record_srl_no);
		psthashmap.put(++psthmcount,patSerGrpCode);

		}

			
			pstmt1 = con.prepareStatement(Sql);	
			int pstcount=1;
			while ( pstcount<=psthashmap.size()) {
			pstmt1.setString(pstcount,String.valueOf(psthashmap.get(pstcount)));
			pstcount++;
			}
			psthashmap.clear();
			psthmcount=0;
			res1 = pstmt1.executeUpdate(); 
			res1 = 1;
		}
		else
		{
			res1 = 1;
		}	
		

		if(pat_no_ctrl.equals("Z") || gen_pid_using_alt_id1_rule_yn.equals("Y"))
		{
			if(result_value.equals(""))
			{
			res2 =1;
			}else
			{
					StringTokenizer sec_final_value1=new StringTokenizer(result_value,"~");
					while(sec_final_value1.hasMoreTokens()){
						String sec_sel_str1=sec_final_value1.nextToken();
					StringTokenizer sec_sel_st2 = new StringTokenizer(sec_sel_str1,"$");

					while(sec_sel_st2.hasMoreTokens()){
						String Facility1=sec_sel_st2.nextToken();
						sec_sel_st2.nextToken();
						String mrSectionCode1=sec_sel_st2.nextToken();
						String checked=sec_sel_st2.nextToken();
						
					
						


						if(checked.equals("E"))
						{

						sql2_del="delete from MR_SEC_FOR_PAT_SER_GRP where PAT_SER_GRP_CODE=? and FACILITY_ID=? ";
						
						pstmt4=con.prepareStatement(sql2_del);
						pstmt4.setString(1,patSerGrpCode );
						pstmt4.setString(2,Facility1 );
						pstmt4.executeUpdate(); 
						if(pstmt4!=null)pstmt4.close();//Added for Checkstyle issue DEC23

						sql2="insert into MR_SEC_FOR_PAT_SER_GRP(PAT_SER_GRP_CODE,FACILITY_ID,MR_SECTION_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,?,?,?,sysdate,?,?,?,sysdate,?,?)";

						//sql2="Update MR_SEC_FOR_PAT_SER_GRP set PAT_SER_GRP_CODE='"+patSerGrpCode+"',FACILITY_ID='"+Facility1+"',MR_SECTION_CODE='"+mrSectionCode1+"',MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"' where PAT_SER_GRP_CODE = '"+patSerGrpCode+"' and FACILITY_ID='"+Facility1+"'";
						psthashmap.put(++psthmcount,patSerGrpCode);
						psthashmap.put(++psthmcount,Facility1);
						psthashmap.put(++psthmcount,mrSectionCode1);
						psthashmap.put(++psthmcount,addedById);
						psthashmap.put(++psthmcount,addedAtWorkstation);
						psthashmap.put(++psthmcount,facilityId);
						psthashmap.put(++psthmcount,modifiedById);
						psthashmap.put(++psthmcount,modifiedAtWorkstation);
						psthashmap.put(++psthmcount,facilityId);
						
						}else
						{
						sql2="delete from MR_SEC_FOR_PAT_SER_GRP where PAT_SER_GRP_CODE=? and FACILITY_ID=? ";
						psthashmap.put(++psthmcount,patSerGrpCode);
						psthashmap.put(++psthmcount,Facility1);
						}
						pstmt4=con.prepareStatement(sql2);
						int pstcount=1;
						while ( pstcount<=psthashmap.size()) {
						pstmt4.setString(pstcount,String.valueOf(psthashmap.get(pstcount)));
						pstcount++;
						}
						psthashmap.clear();
						psthmcount=0;
						res2 = pstmt4.executeUpdate(); 
					}
						
						
					}	
			}

		}


	boolean inserted=false;
	String error_value = "0" ;



	if(pat_no_ctrl.equals("Z"))
		{
		if(res1 !=0 && res2!=0)
		inserted = true;
		else
		inserted = false;
		}
		else
		{
		if(res1 !=0)
		inserted = true;
		else
		inserted = false;

		}

	
	if ( inserted ) 
		{
		error_value = "1" ;
		con.commit();  
	
		out.println("<script>parent.onSuccess('true');</script>");
		}
		else
		{
			con.rollback();
		
		out.println("<script>parent.onSuccess('false');</script>");
		}
		
		if (pstmt1 != null) pstmt1.close();
		if (pstmt3 != null) pstmt3.close();
		if (pstmt4 != null) pstmt4.close();

		//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") );

	} catch ( Exception e ) {
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 169544675 on 14-08-2023
	}finally
	{
		
		ConnectionManager.returnConnection(con,req);
		
	}
}


private void insertPatientNumberDetail(HttpServletRequest req, HttpServletResponse res)	{
			Connection con = null;
	try {
		//String locale = p.getProperty("LOCALE");
		con = ConnectionManager.getConnection(req);
		Statement pstmt2=con.createStatement();
		//Statement pstmt3=con.createStatement();
		//Statement pstmt4=con.createStatement();
		/*Added by lakshmanan for security issue ID 169517110 on 21-08-2023 start */
		PreparedStatement pstmt3=null;
		PreparedStatement pstmt4=null;
		java.util.HashMap psthashmap		=	new java.util.HashMap() ;
		int psthmcount=0;
		/*Added by lakshmanan for security issue ID 169517110 on 21-08-2023 end */
		
		int res1 =0;
		int res2=0;
		String Sql="";
		String sql2="";
		String sql2_del="";
		//String Sql_del="";
		ResultSet rs1=pstmt2.executeQuery("select max(record_srl_no) as total from mp_pat_ser_facility");
		rs1.next();
		maxRecord = rs1.getLong("total");
		
		maxRecord=maxRecord+1;
         if(pstmt2!=null)pstmt2.close();
		 if(rs1!=null)rs1.close();
		
		
		
		patSerGrpCode = req.getParameter("pat_ser_grp_code");
		siteOrFacility = req.getParameter("site_or_facility");
		siteOrFacilityId = req.getParameter("site_or_facility_id");
		usedStatus="N";
		start_srl_no= req.getParameter("start_srl_no");
		max_srl_no = req.getParameter("max_srl_no");
		mrSectionCode = req.getParameter("mr_section_code");
		separateFileNoYn= req.getParameter("separate_file_no_yn");

		pat_no_ctrl= req.getParameter("pat_no_ctrl");
		result_value= req.getParameter("result_value");
		readonly_flag= req.getParameter("readonly_flag");

		gen_pid_using_alt_id1_rule_yn = req.getParameter("gen_pid_using_alt_id1_rule_yn");
		

		
		if (siteOrFacility == null)
			siteOrFacility = "";
		if (siteOrFacilityId == null)
			siteOrFacilityId = "";
		if (start_srl_no == null)
			start_srl_no = "";
		if (max_srl_no == null)
			max_srl_no = "";

		
		
		if ( separateFileNoYn == null )
				separateFileNoYn ="N";
		if ( createFileAtRegnYn == null )
				createFileAtRegnYn ="N";

		

	
	String addedById = p.getProperty( "login_user" ) ;

	String modifiedById = addedById ;

	String addedAtWorkstation=client_ip_address;
	String modifiedAtWorkstation = addedAtWorkstation ;

	//java.sql.Timestamp added_date= new  java.sql.Timestamp(System.currentTimeMillis());
	//java.sql.Timestamp modified_date = new  java.sql.Timestamp(System.currentTimeMillis());


		if(!readonly_flag.equals("Y"))
		{

		if(!pat_no_ctrl.equals("Z"))
		{
		 Sql="insert into MP_PAT_SER_FACILITY(SITE_OR_FACILITY,SITE_OR_FACILITY_ID,RECORD_SRL_NO,PAT_SER_GRP_CODE,START_SRL_NO,MAX_SRL_NO,USED_STATUS,MR_SECTION_CODE,SEPARATE_FILE_NO_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO) values (?,?,?,?,?,?,?,?,?,?,sysdate,?,?,sysdate,?)";
		 psthashmap.put(++psthmcount,siteOrFacility);
		 psthashmap.put(++psthmcount,siteOrFacilityId);
		 psthashmap.put(++psthmcount,maxRecord);
		 psthashmap.put(++psthmcount,patSerGrpCode);
		 psthashmap.put(++psthmcount,start_srl_no);
		 psthashmap.put(++psthmcount,max_srl_no);
		 psthashmap.put(++psthmcount,usedStatus);
		 psthashmap.put(++psthmcount,mrSectionCode);
		 psthashmap.put(++psthmcount,separateFileNoYn);
		 psthashmap.put(++psthmcount,addedById);
		 psthashmap.put(++psthmcount,addedAtWorkstation);
		 psthashmap.put(++psthmcount,modifiedById);
		 psthashmap.put(++psthmcount,modifiedAtWorkstation);

		}
		else
		{
		
		 Sql="insert into MP_PAT_SER_FACILITY(SITE_OR_FACILITY,SITE_OR_FACILITY_ID,RECORD_SRL_NO,PAT_SER_GRP_CODE,START_SRL_NO,MAX_SRL_NO,USED_STATUS,SEPARATE_FILE_NO_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO) values (?,?,?,?,?,?,?,?,?,sysdate,?,?,sysdate,?)";
		 psthashmap.put(++psthmcount,siteOrFacility);
		 psthashmap.put(++psthmcount,siteOrFacilityId);
		 psthashmap.put(++psthmcount,maxRecord);
		 psthashmap.put(++psthmcount,patSerGrpCode);
		 psthashmap.put(++psthmcount,start_srl_no);
		 psthashmap.put(++psthmcount,max_srl_no);
		 psthashmap.put(++psthmcount,usedStatus);
		 psthashmap.put(++psthmcount,separateFileNoYn);
		 psthashmap.put(++psthmcount,addedById);
		 psthashmap.put(++psthmcount,addedAtWorkstation);
		 psthashmap.put(++psthmcount,modifiedById);
		 psthashmap.put(++psthmcount,modifiedAtWorkstation);

		}
			pstmt3 = con.prepareStatement(Sql);
			int pstcount=1;
			while ( pstcount<=psthashmap.size()) {
			pstmt3.setString(pstcount,String.valueOf(psthashmap.get(pstcount)));
			pstcount++;
			}
			psthashmap.clear();
			psthmcount=0;
			res1 = pstmt3.executeUpdate(); 
				
		}
		else
		{
			res1 = 1;
			
		}

		if(pat_no_ctrl.equals("Z") || gen_pid_using_alt_id1_rule_yn.equals("Y"))
		{
			if(result_value.equals(""))
			{
			res2 =1;
			}else
			{
					
					StringTokenizer sec_final_value1=new StringTokenizer(result_value,"~");
					while(sec_final_value1.hasMoreTokens()){
						String sec_sel_str1=sec_final_value1.nextToken();
					StringTokenizer sec_sel_st2 = new StringTokenizer(sec_sel_str1,"$");

					while(sec_sel_st2.hasMoreTokens()){
						String Facility1=sec_sel_st2.nextToken();
						sec_sel_st2.nextToken();
						String mrSectionCode1=sec_sel_st2.nextToken();
						String checked=sec_sel_st2.nextToken();
						
						if(checked.equals("E"))
						{

						sql2_del="delete from MR_SEC_FOR_PAT_SER_GRP where PAT_SER_GRP_CODE=? and FACILITY_ID=? ";
						
						pstmt4=con.prepareStatement(sql2_del);
						pstmt4.setString(1,patSerGrpCode );
						pstmt4.setString(2,Facility1 );
						pstmt4.executeUpdate(); 
						//pstmt4.executeUpdate(sql2_del);
						if(pstmt4!=null) pstmt4.close();//Added for Checkstyle Issue DEC23

						sql2="insert into MR_SEC_FOR_PAT_SER_GRP(PAT_SER_GRP_CODE,FACILITY_ID,MR_SECTION_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
						psthashmap.put(++psthmcount,patSerGrpCode);
						psthashmap.put(++psthmcount,Facility1);
						psthashmap.put(++psthmcount,mrSectionCode1);
						psthashmap.put(++psthmcount,addedById);
						psthashmap.put(++psthmcount,addedAtWorkstation);
						psthashmap.put(++psthmcount,facilityId);
						psthashmap.put(++psthmcount,modifiedById);
						psthashmap.put(++psthmcount,modifiedAtWorkstation);
						psthashmap.put(++psthmcount,facilityId);

						}else
						{
						sql2="delete from MR_SEC_FOR_PAT_SER_GRP where PAT_SER_GRP_CODE=? and FACILITY_ID=? ";
						psthashmap.put(++psthmcount,patSerGrpCode);
						psthashmap.put(++psthmcount,Facility1);
						
						}
						pstmt4 = con.prepareStatement(sql2);
						int pstcount=1;
						while ( pstcount<=psthashmap.size()) {
							pstmt4.setString(pstcount,String.valueOf(psthashmap.get(pstcount)));
							pstcount++;
						}
						psthashmap.clear();
						psthmcount=0;
						res2 = pstmt4.executeUpdate(); 
						if(pstmt4 != null) pstmt4.close();//Added for Checkstyle Issue DEC23
					}
						
						
					}	
			}

		}



	boolean inserted=false;
	String error_value = "0" ;


	if(pat_no_ctrl.equals("Z"))
		{
		if(res1 !=0 && res2!=0)
		inserted = true;
		else
		inserted = false;
		}
		else
		{
		if(res1 !=0)
		inserted = true;
		else
		inserted = false;

		}


	if ( inserted ) 
		{
		error_value = "1" ;
		con.commit();  
	
		out.println("<script>parent.onSuccess('true');</script>");
		}
		else
		{
			con.rollback();
			out.println("<script>parent.onSuccess('false');</script>");
		}

		if (pstmt3 != null) pstmt3.close();
		if (pstmt4 != null) pstmt4.close();


	} catch ( Exception e ) {
		//out.println(e.getMessage());
		//out.println(e.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 169514276 on 14-08-2023
		}
	finally
	{
		
		ConnectionManager.returnConnection(con,req);
		
	}
	}
/*	boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				return true;
		else
				return false;
	} */
}

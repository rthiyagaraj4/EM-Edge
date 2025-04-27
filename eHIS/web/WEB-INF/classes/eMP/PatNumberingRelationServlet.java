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

public class PatNumberingRelationServlet extends javax.servlet.http.HttpServlet	
{
	PrintWriter out;
	java.util.Properties p;
	String client_ip_address	= "";
	String facilityId			= "";
	PreparedStatement pstmt		= null;
	String added_facility_id	= "";
	String modified_facility_id = "";
	String added_by_id			= "";
	String modified_by_id		= "";
	String modified_at_ws_no	= "";
	String added_at_ws_no		= "";
	String locale				= "";


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
		//String operation = req.getParameter("function");
		this.facilityId = (String) session.getAttribute( "facility_id" ) ;
		added_facility_id = (String) session.getValue( "facility_id" ) ;
		modified_facility_id=added_facility_id;
		added_by_id	= (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
		locale = p.getProperty("LOCALE");
		modified_by_id = added_by_id;
		added_at_ws_no = client_ip_address;
		modified_at_ws_no = client_ip_address ;


	//if ( operation.equals("insert") )
		insertPatientNumberDetail(req, res);
	//if ( operation.equals("modify"))
			//modifyPatientNumberDetail(req, res);
	}
	catch (Exception e)	{
		out.println(e.toString());
		}
	}
/*public void doGet(HttpServletRequest req, HttpServletResponse res)
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
					out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/PatientNumberingDetail.js'></script></head><frameset rows='42,*,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0 scrolling='no'> <frame name='result' id='result_det' src='../eCommon/html/blank.html' frameborder=0 scrolling='auto'> <frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		else
		{

		out.println("<Script language='JavaScript'>alert(parent.getMessage('MP_PARAM_NOT_FOUND','MP'));</Script>");
		}

		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();

	}
	catch(Exception e)	{	}
	finally
		{
			if (con!= null) ConnectionManager.returnConnection(con,req);
		}
	}*/
/*private void modifyPatientNumberDetail(HttpServletRequest req, HttpServletResponse res)	{
	Connection con = null;
	try {
		
		//String locale = p.getProperty("LOCALE");
		con = ConnectionManager.getConnection(req);
		//Statement pstmt2=con.createStatement();
		Statement pstmt3=con.createStatement();
		Statement pstmt4=con.createStatement();
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




					
					

		if(!pat_no_ctrl.equals("Z"))
		{

		Sql="Update MP_PAT_SER_FACILITY set SITE_OR_FACILITY ='"+siteOrFacility+"',SITE_OR_FACILITY_ID='"+siteOrFacilityId+"',RECORD_SRL_NO='"+record_srl_no+"',PAT_SER_GRP_CODE='"+patSerGrpCode+"',START_SRL_NO='"+start_srl_no+"',MAX_SRL_NO='"+max_srl_no+"',USED_STATUS='"+usedStatus+"',MR_SECTION_CODE='"+mrSectionCode+"',SEPARATE_FILE_NO_YN='"+separateFileNoYn+"',MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"' where RECORD_SRL_NO = '"+record_srl_no+"'  and PAT_SER_GRP_CODE = '"+patSerGrpCode+"'";
		
		

		}
		else
		{
				 
		Sql="Update MP_PAT_SER_FACILITY set SITE_OR_FACILITY ='"+siteOrFacility+"',SITE_OR_FACILITY_ID='"+siteOrFacilityId+"',RECORD_SRL_NO='"+record_srl_no+"',PAT_SER_GRP_CODE='"+patSerGrpCode+"',START_SRL_NO='"+start_srl_no+"',MAX_SRL_NO='"+max_srl_no+"',USED_STATUS='"+usedStatus+"',SEPARATE_FILE_NO_YN='"+separateFileNoYn+"',MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"' where RECORD_SRL_NO = '"+record_srl_no+"'  and PAT_SER_GRP_CODE = '"+patSerGrpCode+"'";
		

		}


			res1 = pstmt3.executeUpdate(Sql); 
				
		

		if(pat_no_ctrl.equals("Z") || (siteOrFacilityId==""))
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

						sql2_del="delete from MR_SEC_FOR_PAT_SER_GRP where PAT_SER_GRP_CODE='"+patSerGrpCode+"' and FACILITY_ID='"+Facility1+"' ";

						pstmt4.executeUpdate(sql2_del); 
						

						sql2="insert into MR_SEC_FOR_PAT_SER_GRP(PAT_SER_GRP_CODE,FACILITY_ID,MR_SECTION_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values ('"+patSerGrpCode+"','"+Facility1+"','"+mrSectionCode1+"','"+addedById+"',sysdate,'"+addedAtWorkstation+"','"+facilityId+"','"+modifiedById+"',sysdate,'"+modifiedAtWorkstation+"','"+facilityId+"')";

						//sql2="Update MR_SEC_FOR_PAT_SER_GRP set PAT_SER_GRP_CODE='"+patSerGrpCode+"',FACILITY_ID='"+Facility1+"',MR_SECTION_CODE='"+mrSectionCode1+"',MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"' where PAT_SER_GRP_CODE = '"+patSerGrpCode+"' and FACILITY_ID='"+Facility1+"'";

						
						
						}else
						{
						sql2="delete from MR_SEC_FOR_PAT_SER_GRP where PAT_SER_GRP_CODE='"+patSerGrpCode+"' and FACILITY_ID='"+Facility1+"' ";

						}

						res2 = pstmt4.executeUpdate(sql2); 
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

		//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") );

	} catch ( Exception e ) {
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
	}finally
	{
		
		ConnectionManager.returnConnection(con,req);
		
	}
}*/


private void insertPatientNumberDetail(HttpServletRequest req, HttpServletResponse res)	{
	Connection con = null;
	try {
		
		con = ConnectionManager.getConnection(req);
		String combined_rel_level_code = "";
		String prefix_or_suffix_length = "";
		int prefix_or_suffix_length_num_val = 0;
		String prefix1 = "";
		int prefix1_num_val = 0;
		String prefix2 = "";
		int prefix2_num_val = 0;
		String prefix3 = "";
		int prefix3_num_val = 0;
		String sex_indicator = "";
		String maxRecord = "";
		int maxRecordInt = 0;
		String pat_ser_grp_code = "";
		boolean isatLeastOneNumberingSelected = false;
		boolean result			= false;
		String msg="";
		String error_val="";
		
		

		maxRecord = req.getParameter("maxRecord1");

		if(maxRecord!=null && !maxRecord.equals(""))
			maxRecordInt = Integer.parseInt(maxRecord);

		pat_ser_grp_code =  req.getParameter("pat_ser_grp_code");

		pstmt = con.prepareStatement("INSERT INTO MP_REL_FOR_PAT_SER_GRP(PAT_SER_GRP_CODE, RELATIONSHIP_LEVEL_LENGTH,COMBINED_REL_LEVEL_CODE, SEX_IND,PREFIX1, PREFIX2,PREFIX3,ADDED_BY_ID,added_date, added_at_ws_no,added_facility_id, modified_by_id,modified_date, modified_at_ws_no,modified_facility_id) VALUES (?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");

		//pstmt = con.prepareStatement("INSERT INTO MP_REL_FOR_PAT_SER_GRP(PAT_SER_GRP_CODE, COMBINED_REL_LEVEL_CODE, SEX_IND,PREFIX1, PREFIX2,PREFIX3,ADDED_BY_ID,added_date, added_at_ws_no,added_facility_id, modified_by_id,modified_date, modified_at_ws_no,modified_facility_id) VALUES (?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");

		for(int i=0;i<maxRecordInt;i++)
		{
			String isSelect_YN = req.getParameter("select"+i);


			if(isSelect_YN!=null && isSelect_YN.equals("Y"))
			{
				combined_rel_level_code = req.getParameter("combined_rel_level_code"+i);
				prefix_or_suffix_length = req.getParameter("prefix_or_suffix_length"+i);
				if(prefix_or_suffix_length!=null && !prefix_or_suffix_length.equals(""))
					prefix_or_suffix_length_num_val = Integer.parseInt(prefix_or_suffix_length);
				else
					prefix_or_suffix_length_num_val = 0;
				


				prefix1 = req.getParameter("prefix1"+i);
				if(prefix1!=null && !prefix1.equals(""))
					prefix1_num_val = Integer.parseInt(prefix1);
				else
					prefix1_num_val = 0;

				prefix2 = req.getParameter("prefix2"+i);
				if(prefix2!=null && !prefix2.equals(""))
					prefix2_num_val = Integer.parseInt(prefix2);	
				
				
				prefix3 = req.getParameter("prefix3"+i);
				if(prefix3!=null && !prefix3.equals(""))
					prefix3_num_val = Integer.parseInt(prefix3);
				
				sex_indicator = checkForNull(req.getParameter("sex_indicator"+i));



				 /*pstmt.setString(1,pat_ser_grp_code);
				 pstmt.setInt(2,prefix_or_suffix_length_num_val);
				 pstmt.setString(3,combined_rel_level_code);
				 pstmt.setString(4,sex_indicator);
				 pstmt.setInt(5,prefix1_num_val);
				 pstmt.setInt(6,prefix2_num_val);
				 if(prefix3!=null && !prefix3.equals(""))
					 pstmt.setInt(7,prefix3_num_val);
				 else
					  pstmt.setString(7,null);
				
				 pstmt.setString(8,added_by_id);
				 pstmt.setString(9,added_at_ws_no);
				 pstmt.setString(10,added_facility_id);
				 pstmt.setString(11,modified_by_id);
				 pstmt.setString(12,modified_at_ws_no);
				 pstmt.setString(13,modified_facility_id);		*/		


				 pstmt.setString(1,pat_ser_grp_code);
				 pstmt.setInt(2,prefix_or_suffix_length_num_val);				
				 pstmt.setString(3,combined_rel_level_code);
				 pstmt.setString(4,sex_indicator);
				 pstmt.setInt(5,prefix1_num_val);

				 if(prefix2!=null && !prefix2.equals(""))
					 pstmt.setInt(6,prefix2_num_val);
				 else
					  pstmt.setString(6,null);

				 if(prefix3!=null && !prefix3.equals(""))
					 pstmt.setInt(7,prefix3_num_val);
				 else
					  pstmt.setString(7,null);
				
				 pstmt.setString(8,added_by_id);
				 pstmt.setString(9,added_at_ws_no);
				 pstmt.setString(10,added_facility_id);
				 pstmt.setString(11,modified_by_id);
				 pstmt.setString(12,modified_at_ws_no);
				 pstmt.setString(13,modified_facility_id);	
				 pstmt.addBatch();
				 isatLeastOneNumberingSelected = true;
			}		
		}

		if(isatLeastOneNumberingSelected)
			{
				int result_update[] = pstmt.executeBatch();
				if(result_update!=null && result_update.length>0)
					result	= true;
				else
					result	= false;
			}


			if(result)
			{
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
					msg = (String) message.get("message");
					error_val="1";

			}
			else if(!isatLeastOneNumberingSelected)
			{
				con.rollback();
				java.util.Hashtable message = MessageManager.getMessage( locale, "ATLEAST_ONE_SELECTED","Common" ) ;
				msg = (String) message.get("message");
				error_val="0";
			}
			else
			{
					con.rollback();
					java.util.Hashtable message = MessageManager.getMessage( locale, "ERROR_INSERTING","SM" ) ;
					msg = (String) message.get("message");
					error_val="0";
			}
			
			
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode(msg, "UTF-8") + "&err_value=" + error_val);

		if (pstmt != null) pstmt.close();
		

	} catch ( Exception e ) {
		/* out.println(e.getMessage());
		out.println(e.toString()); */
		e.printStackTrace();
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


	public String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
		public String checkForNull(String inputString, String Defaultstr)
	{
		return((inputString == null) ? Defaultstr : inputString);
	}
}

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
	Developed By       :  NANDA KUMAR R.
	Module Name 	   :  eCIS/dr
	Function Name	   : Enter Duplicates
	Function ID		   :

*/
package eDR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;

public class EnterDuplicatesServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;
	HttpSession session;
	
	Connection con						= null;
	PreparedStatement InsertSQLPstmt    = null;
	PreparedStatement InsertSQLPstmt1   = null;
	PreparedStatement UpdateSQLPstmt    = null;
	PreparedStatement DeleteSQLPstmt    = null;
	PreparedStatement SelectSQLPstmt    = null;
	PreparedStatement pstmt				= null;
	PreparedStatement pstmt1			= null;
	PreparedStatement pstmt2			= null;
	Statement stmt						= null;
	ResultSet rs						= null;
	ResultSet messageResultset          = null;

	int rsinserthdr						= 0;
	int rsinsertdtl						= 0;
	int rsupdatedtl						= 0;
	int rsdeletedtl						= 0;

	String client_ip_address			= "";
	String facilityId					= "";
    String mode							= "";
	String addedById					= "";
	String modifiedById					= "";
	String addedFacilityId				= "";
	String modifiedFacilityId			= "";
	String addedAtWorkstation			= "";
	String modifiedAtWorkstation		= "";
	String p_string_val					= "";
	String p_delete_string				= "";
	String dupgroupid					= "";
	String p_pat_count					= "";
	String sqlinsert					= "";
	String sqlinsert1					= "";
	String sqlinsert2					= "";
	String sqlinsert3					= "";
	String sqlupdate					= "";
	String sqldelete					= "";
	String group_id						= "";
	String patient_id                      = "";
	String dup_id                      = "";
	String remarks                     = "";
	StringBuffer InsertSQL				= null;
	StringBuffer InsertSQLDtl			= null;
    String    patient_id1= "";
	String count  ="";
	String sqlselect="";
	
	 String  patientid[] ;
	
	String val="";
	int p_pat=0;
	public void init(ServletConfig config) throws ServletException
	{
			super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");

		session					= req.getSession(false);
    	this.facilityId			= (String) session.getValue("facility_id" ) ;
		this.p					= (Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address  = p.getProperty("client_ip_address");
		
		try
		{
			con  = ConnectionManager.getConnection(req);
			stmt = con.createStatement();			

			this.out					= res.getWriter();
			mode						= req.getParameter("mode");
		   
			p_delete_string				= req.getParameter("delete_string");
			dupgroupid					= req.getParameter("dupgroupid");
			if(dupgroupid.equals("")) dupgroupid="000000";	
			p_pat_count					= req.getParameter("p_pat_count");
			p_pat=Integer.parseInt(p_pat_count); 
			patientid = new String[p_pat];
			
		    for(int j=1;j<=p_pat;j++)
			{
			 val=Integer.toString(j); 
		    patientid[j-1] =req.getParameter("patient_id"+val);
			}
			count                         = req.getParameter("count");
			addedById					= p.getProperty( "login_user" ) ;
			patient_id                    =req.getParameter("patient_id");
			dup_id                         =req.getParameter("dup_ind");
			remarks                      =req.getParameter("remarks");
			modifiedById				= addedById ;
			addedFacilityId				= facilityId;
			modifiedFacilityId	        = addedFacilityId ;
			addedAtWorkstation	        = client_ip_address;
			modifiedAtWorkstation       = addedAtWorkstation ;
             p_string_val                     =req.getParameter("p_string_value");
			//assigning N to check box variables

			if(mode.equals("insert"))			insertEnterDuplicatesServlet(res);
			else if(mode.equals("update"))		modifyEnterDuplicatesServlet(res);
			else if(mode.equals("delete"))		deleteEnterDuplicatesServlet(res);

			if(messageResultset!=null) messageResultset.close();
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();

		}catch(Exception e){out.println(e.toString());e.printStackTrace();}
		// Added on 19/07/2003 for closing ResultSet & Statements which are not closed Properly.
		finally
		{
			ConnectionManager.returnConnection(con,req);
		}
	// End of Addition on 19/07/2003 for closing ResultSet & Statements which are not closed properly.
	}//do post
	private synchronized void insertEnterDuplicatesServlet(HttpServletResponse res)
	{
		try
		{
			String locale = p.getProperty("LOCALE");
			
             InsertSQL	 = new StringBuffer();
			InsertSQLDtl = new StringBuffer();

			con.setAutoCommit(false);
 			StringTokenizer token  =  new StringTokenizer(p_string_val,"~");
			StringTokenizer token1 = new StringTokenizer(p_string_val,"~");
			

			StringTokenizer splittedtoken ;
			StringTokenizer splittedtoken1 ;
			
			String tokenvalue				= "";
			String tokenvalue1				= "";
			String p_patient_id				= "";
			String p_dup_indicator			= "";
			String p_remarks				= "";
			String p_first_name				= "";
			String p_second_name			= "";
			String p_third_name				= "";
			String p_family_name			= "";
			String p_patient_name			= "";
			String p_sex					= "";
			String p_date_of_birth			= "";
			String p_pat_ser_grp_code		= "";
			String p_national_id_no			= "";
			String p_nationality_code		= "";
			String p_res_area_code			= "";
			String p_contact1_no			= "";
			String p_contact2_no			= "";
			String p_regn_facility_id		= "";
		  	String p_mp_patient_added_date	= "";
			//String p_file_location			= "";
			 String p_file_facility_id		= "";
			 String p_file_mr_section_code	= "";
			 String p_file_no				= "";
			 String p_current_patient		= "";
			 String p_record_fnd				= "";
			 String p_previous_patient		= "first";
			 String p_alt_id1_no				= "";
			 String p_alt_id2_no				= "";
			 String p_alt_id3_no				= "";
			 String p_alt_id4_no				= "";
             String first_name_loc_lang="";
	         String second_name_loc_lang="";
	         String third_name_loc_lang="";
	         String family_name_loc_lang="";
	         String patient_name_loc_lang="";
	         String name_prefix_loc_lang="";
	         String name_suffix_loc_lang="";
	         String name_suffix="";
	         String name_prefix="";


		//	String p_message_code			= "RECORD_INSERTED";

			int p_pat_counter				= 0;
			boolean p_proceed				= true;
			
			//sqlinsert = "select 'x' rec_fnd from dr_dup_group_dtls where patient_id = ? ";
			sqlinsert = "select 'x' rec_fnd from dr_dup_group_vw2 where patient_id = ? and group_status = 'I' AND marked_for_merge_yn = 'N'";
			pstmt = con.prepareStatement(sqlinsert);

			sqlinsert1 = "select 'x' rec_fnd from dr_not_dup_patients where (patient_id1 = ? and patient_id2 = ? ) or (patient_id1 = ? and patient_id2 = ? ) ";
			pstmt1 = con.prepareStatement(sqlinsert1);

			sqlinsert2 = "select 'x' rec_fnd from dr_dup_group_dtls where patient_id = ? ";
			pstmt2 = con.prepareStatement(sqlinsert2);

			while(token1.hasMoreTokens())
			{

				tokenvalue1      = token1.nextToken();
				splittedtoken1=new StringTokenizer(tokenvalue1,"`");
				
				while(splittedtoken1.hasMoreTokens())
				{
					p_pat_counter++;
					p_patient_id		=	splittedtoken1.nextToken();
					p_dup_indicator		=	splittedtoken1.nextToken();
					p_remarks			=	splittedtoken1.nextToken();

					if(p_previous_patient.equals("first"))
					{
						p_previous_patient = p_patient_id;
						
			//////////////////////////////////////////////////////////////////////////////

						pstmt.setString(1,p_previous_patient);
						rs = pstmt.executeQuery();
						
						while(rs != null && rs.next())
						{
							p_record_fnd = rs.getString("rec_fnd") ;
						} if(rs != null) rs.close();

			//////////////////////////////////////////////////////////////////////////////

						if (p_record_fnd.equals("x"))
						{
							p_proceed =false;
							//p_message_code = "NON_DUPLICATES";

							//java.util.Hashtable message = MessageManager.getMessage(locale, "NON_DUPLICATES", "DR");
							//java.util.Hashtable message = MessageManager.getMessage(locale, "PATIENT_POSSIBLE_DUPLICATES", "DR");
							java.util.Hashtable message = MessageManager.getMessage(locale, "MERGE_DUPLICATES_EXISTS", "DR");
							String error = ((String) message.get("message"));

							res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=1 " );

							break;
						}
						else
						{
							p_proceed=true;
						}
					}
					else
					{
						p_current_patient = p_patient_id ;	
	
			//////////////////////////////////////////////////////////////////////////////	
			
						pstmt1.setString(1,p_previous_patient);
						pstmt1.setString(2,p_current_patient);
						pstmt1.setString(4,p_previous_patient);
						pstmt1.setString(3,p_current_patient);

						rs = pstmt1.executeQuery();
					
						while(rs != null && rs.next())
						{	
							p_record_fnd = rs.getString("rec_fnd");	
						} if(rs != null) rs.close();	

			//////////////////////////////////////////////////////////////////////////////

						if (p_record_fnd.equals("x"))
						{
							p_proceed = false;
							//p_message_code = "NON_DUPLICATES";

							java.util.Hashtable message = MessageManager.getMessage(locale, "EXCLUDE_DUPLICATE_RECORD", "DR");
							String error = ((String) message.get("message"));

							res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=1 " );

							break;
						}
						else
						{
							p_proceed = true;

			//////////////////////////////////////////////////////////////////////////////

							pstmt2.setString(1,p_current_patient);
							rs = pstmt2.executeQuery();

							while(rs != null && rs.next())
							{
								p_record_fnd = rs.getString("rec_fnd") ;
							} if(rs != null) rs.close();	

			//////////////////////////////////////////////////////////////////////////////

							if (p_record_fnd.equals("x"))
							{
								p_proceed = false;
								//p_message_code = "NON_DUPLICATES";
				
								java.util.Hashtable message = MessageManager.getMessage(locale, "NON_DUPLICATES", "DR");
								String error = ((String) message.get("message"));

								res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=1 " );


								break;
							}
							else
							{
								p_proceed = true;
							}
						}
					}
				}
				if (p_proceed==false)
				{
					//p_string_buffer.append("<BR>GOING OUT OF MAIN LOOP" );
					break;
				}
			}
			if(p_proceed == true)
			{
				
				sqlinsert = "select DR_DUP_GROUP_HDR_SEQ1.nextval next_group_id from dual";
				rs = stmt.executeQuery(sqlinsert);
				while (rs.next())
				{
					group_id = rs.getString("next_group_id");
				} if(rs != null) rs.close();	

				sqlinsert = "";
				
				InsertSQL.append("insert into dr_dup_group_hdr ");
				InsertSQL.append("(dup_group_id,");
				InsertSQL.append("pat_count,");
				InsertSQL.append("group_created_date,");
				InsertSQL.append("group_status,");
				InsertSQL.append("status_upd_date,");
				InsertSQL.append("system_gen_yn,");
				InsertSQL.append("marked_for_merge_yn,");
				InsertSQL.append("added_by_id,");
				InsertSQL.append("added_date,");
				InsertSQL.append("added_at_ws_no,");
				InsertSQL.append("added_facility_id,");
				InsertSQL.append("modified_by_id,");
				InsertSQL.append("modified_date,");
				InsertSQL.append("modified_at_ws_no,");
				InsertSQL.append("modified_facility_id) ");
				InsertSQL.append("values(?,?,sysdate,'I',null,'N','N',?,sysdate,?,?,?,sysdate,?,?)");	
				
				InsertSQLPstmt = con.prepareStatement(InsertSQL.toString());
				
				InsertSQLPstmt.setString(1,group_id);
				InsertSQLPstmt.setString(2,p_pat_count);
				InsertSQLPstmt.setString(3,addedById);
				InsertSQLPstmt.setString(4,addedAtWorkstation);
				InsertSQLPstmt.setString(5,addedFacilityId);
				InsertSQLPstmt.setString(6,modifiedById);
				InsertSQLPstmt.setString(7,modifiedAtWorkstation);
				InsertSQLPstmt.setString(8,modifiedFacilityId);
				
				rsinserthdr = InsertSQLPstmt.executeUpdate();
				
				if(rsinserthdr > 0)
				{
					sqlinsert3 = "select a.patient_id,a.first_name,a.first_name_loc_lang,a.second_name,a.second_name_loc_lang,a.third_name,a.third_name_loc_lang,a.family_name,a.family_name_loc_lang,a.patient_name,a.patient_name_loc_lang,a.name_prefix_loc_lang,a.name_suffix_loc_lang,a.name_prefix,a.name_suffix,a.sex,to_char(a.date_of_birth,'dd/mm/rrrr hh24:mi:ss') date_of_birth ,a.pat_ser_grp_code,a.national_id_no,a.nationality_code,a.res_area_code,a.contact1_no,a.contact2_no,a.regn_facility_id,to_char(a.added_date,'dd/mm/rrrr')patient_added_date,Substr(a.Patient_Id,5,1)||Substr(a.Patient_Id,7,2) file_location,b.facility_id,b.mr_section_code,b.file_no,a.alt_id1_no,a.alt_id2_no,a.alt_id3_no,a.alt_id4_no from mp_patient a,mr_pat_file_index b where a.patient_id=b.patient_id(+)  and a.patient_id = ?";
					SelectSQLPstmt = con.prepareStatement(sqlinsert3);

					InsertSQLDtl.append("insert into dr_dup_group_dtls ");				
					InsertSQLDtl.append("(dup_group_id,");
					InsertSQLDtl.append("patient_id,");
					InsertSQLDtl.append("dup_indicator,");
					InsertSQLDtl.append("sug_valid_pat_flag,");
					InsertSQLDtl.append("remarks,");
					InsertSQLDtl.append("first_name,");
					InsertSQLDtl.append("second_name,");
					InsertSQLDtl.append("third_name,");
					InsertSQLDtl.append("family_name,");
					InsertSQLDtl.append("patient_name,");
					InsertSQLDtl.append("sex,");
					InsertSQLDtl.append("date_of_birth,");
					InsertSQLDtl.append("pat_ser_grp_code,");
					InsertSQLDtl.append("national_id_no,");
					InsertSQLDtl.append("nationality_code,");
					InsertSQLDtl.append("res_area_code,");
					InsertSQLDtl.append("contact1_no,");
					InsertSQLDtl.append("contact2_no,");
					InsertSQLDtl.append("regn_facility_id,");
					InsertSQLDtl.append("mp_patient_added_date,");
					InsertSQLDtl.append("file_location,");
					InsertSQLDtl.append("file_facility_id,");
					InsertSQLDtl.append("file_mr_section_code,");
					InsertSQLDtl.append("file_no,");
					InsertSQLDtl.append("added_by_id,");
					InsertSQLDtl.append("added_date,");
					InsertSQLDtl.append("added_at_ws_no,");
					InsertSQLDtl.append("added_facility_id,");
					InsertSQLDtl.append("modified_by_id,");
					InsertSQLDtl.append("modified_date,");
					InsertSQLDtl.append("modified_at_ws_no,");
					InsertSQLDtl.append("modified_facility_id, alt_id1_no, alt_id2_no, alt_id3_no, alt_id4_no,");
					InsertSQLDtl.append("first_name_loc_lang,");
				    InsertSQLDtl.append("second_name_loc_lang,");
					InsertSQLDtl.append("third_name_loc_lang,");
					InsertSQLDtl.append("family_name_loc_lang,");
					InsertSQLDtl.append("patient_name_loc_lang,");
					InsertSQLDtl.append("name_prefix_loc_lang,");
					InsertSQLDtl.append("name_suffix_loc_lang,");
					InsertSQLDtl.append("name_prefix,");
					InsertSQLDtl.append("name_suffix) ");
					InsertSQLDtl.append("values (?,?,?,'N',?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi:ss'),?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi:ss'),?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					InsertSQLPstmt1 = con.prepareStatement(InsertSQLDtl.toString());

					while(token.hasMoreTokens())
				    {
						tokenvalue      = token.nextToken();
						splittedtoken=new StringTokenizer(tokenvalue,"`");

						while (splittedtoken.hasMoreTokens())
						{
							p_pat_counter++;
							p_patient_id		=	splittedtoken.nextToken();
							p_dup_indicator		=	splittedtoken.nextToken();
							p_remarks			=	splittedtoken.nextToken();

			////////////////////////////////////////////////////////////////////////////////
							
							SelectSQLPstmt.setString(1,p_patient_id);
							rs = SelectSQLPstmt.executeQuery();
					
							while(rs != null && rs.next())
							{
								p_first_name			= rs.getString("first_name") ;
								p_second_name			= rs.getString("second_name") ;
								p_third_name			= rs.getString("third_name") ;
								p_family_name			= rs.getString("family_name") ;
								p_patient_name			= rs.getString("patient_name") ;
								p_sex					= rs.getString("sex") ;
								p_date_of_birth			= rs.getString("date_of_birth") ;
								p_pat_ser_grp_code		= rs.getString("pat_ser_grp_code") ;
								p_national_id_no		= rs.getString("national_id_no") ;
								p_nationality_code		= rs.getString("nationality_code") ;
								p_res_area_code			= rs.getString("res_area_code") ;
								p_contact1_no			= rs.getString("contact1_no") ;
								p_contact2_no			= rs.getString("contact2_no") ;
								p_regn_facility_id		= rs.getString("regn_facility_id") ;
								p_mp_patient_added_date	= rs.getString("patient_added_date") ;
								//p_file_location			= rs.getString("file_location") ;
								p_file_facility_id		= rs.getString("facility_id") ;
								p_file_mr_section_code	= rs.getString("mr_section_code") ;
								p_file_no				= rs.getString("file_no") ;
								p_alt_id1_no			= rs.getString("alt_id1_no");
								p_alt_id2_no			= rs.getString("alt_id2_no");
								p_alt_id3_no			= rs.getString("alt_id3_no");
								p_alt_id4_no			= rs.getString("alt_id4_no");								
                               first_name_loc_lang = rs.getString("first_name_loc_lang");			
                               second_name_loc_lang = rs.getString("second_name_loc_lang");		
							   third_name_loc_lang = rs.getString("third_name_loc_lang");		
							   family_name_loc_lang = rs.getString("family_name_loc_lang");		
							   patient_name_loc_lang = rs.getString("patient_name_loc_lang");		
							   name_prefix_loc_lang= rs.getString("name_prefix_loc_lang");		
							   name_suffix_loc_lang = rs.getString("name_suffix_loc_lang");		
							   name_prefix = rs.getString("name_prefix");		
							   name_suffix = rs.getString("name_suffix");		
							
							} if(rs != null) rs.close();	
		
				////////////////////////////////////////////////////////////////////////////////

							if(p_file_facility_id == null || p_file_facility_id.equals("null"))
							{
								p_file_facility_id = "";
							}
							if(p_file_mr_section_code == null || p_file_mr_section_code.equals("null"))
							{
								p_file_mr_section_code = "";
							}
							if(p_file_no == null || p_file_no.equals("null")) p_file_no = "";
								
							
				///////////////////////////////////////////////////////////////////////////////		
				
							InsertSQLPstmt1.setString(1,group_id);
							InsertSQLPstmt1.setString(2,p_patient_id);
							InsertSQLPstmt1.setString(3,p_dup_indicator);
							InsertSQLPstmt1.setString(4,p_remarks);
							InsertSQLPstmt1.setString(5,p_first_name);
							InsertSQLPstmt1.setString(6,p_second_name);
							InsertSQLPstmt1.setString(7,p_third_name);
							InsertSQLPstmt1.setString(8,p_family_name);
							InsertSQLPstmt1.setString(9,p_patient_name);
							InsertSQLPstmt1.setString(10,p_sex);
							InsertSQLPstmt1.setString(11,p_date_of_birth);
							InsertSQLPstmt1.setString(12,p_pat_ser_grp_code);
							InsertSQLPstmt1.setString(13,p_national_id_no);
							InsertSQLPstmt1.setString(14,p_nationality_code);
							InsertSQLPstmt1.setString(15,p_res_area_code);
							InsertSQLPstmt1.setString(16,p_contact1_no);
							InsertSQLPstmt1.setString(17,p_contact2_no);
							InsertSQLPstmt1.setString(18,p_regn_facility_id);
							InsertSQLPstmt1.setString(19,p_mp_patient_added_date);
							InsertSQLPstmt1.setString(20,p_file_facility_id);
							InsertSQLPstmt1.setString(21,p_file_facility_id);
							InsertSQLPstmt1.setString(22,p_file_mr_section_code);
							InsertSQLPstmt1.setString(23,p_file_no);
							InsertSQLPstmt1.setString(24,addedById);
							InsertSQLPstmt1.setString(25,addedAtWorkstation);
							InsertSQLPstmt1.setString(26,addedFacilityId);
							InsertSQLPstmt1.setString(27,modifiedById);
							InsertSQLPstmt1.setString(28,modifiedAtWorkstation);
							InsertSQLPstmt1.setString(29,modifiedFacilityId);
							InsertSQLPstmt1.setString(30,p_alt_id1_no);
							InsertSQLPstmt1.setString(31,p_alt_id2_no);
							InsertSQLPstmt1.setString(32,p_alt_id3_no);
							InsertSQLPstmt1.setString(33,p_alt_id4_no);
                             InsertSQLPstmt1.setString(34,first_name_loc_lang);
							InsertSQLPstmt1.setString(35,second_name_loc_lang);
							InsertSQLPstmt1.setString(36,third_name_loc_lang);
							InsertSQLPstmt1.setString(37,family_name_loc_lang);
							InsertSQLPstmt1.setString(38,patient_name_loc_lang);
							InsertSQLPstmt1.setString(39,name_prefix_loc_lang);
							InsertSQLPstmt1.setString(40,name_suffix_loc_lang);
							InsertSQLPstmt1.setString(41,name_prefix);
							InsertSQLPstmt1.setString(42,name_suffix);
							rsinsertdtl = InsertSQLPstmt1.executeUpdate();

				///////////////////////////////////////////////////////////////////////////////
		
						}
					} 
				}
			}
			if(p_proceed == true && rsinserthdr > 0 && rsinsertdtl > 0)
			{
				con.commit();

			/*	String message	= "";
				String msg		= "select GET_ERROR_MESSAGE('"+p_message_code+"') from dual";
				messageResultset = stmt.executeQuery(msg);
				if(messageResultset != null)
				{
					if(messageResultset.next())
					{
						message = messageResultset.getString(1);
					}
				} if(messageResultset != null) messageResultset.close();	*/

				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
				String error = ((String) message.get("message"));

				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=1 " );
			}
			else
			{
				con.rollback();

		/*	String message	 = "";
				String msg		 = "select GET_ERROR_MESSAGE('"+p_message_code+"') FROM dual";
				messageResultset = stmt.executeQuery(msg);
				if(messageResultset != null)
				{
					if(messageResultset.next())
					{
						message=messageResultset.getString(1);
					}
				} if(messageResultset != null) messageResultset.close();	

				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(""+message+"") + "&err_value=0");*/
			}

			if((InsertSQL != null) && (InsertSQL.length() > 0))
			{
				InsertSQL.delete(0,InsertSQL.length());
			}
			if((InsertSQLDtl != null) && (InsertSQLDtl.length() >0))
			{
				InsertSQLDtl.delete(0,InsertSQLDtl.length());
			}

			if(pstmt  != null) pstmt.close();
			if(pstmt1  != null) pstmt1.close();
			if(pstmt2  != null) pstmt2.close();
			if(InsertSQLPstmt  != null) InsertSQLPstmt.close();
			if(InsertSQLPstmt1 != null) InsertSQLPstmt1.close();
			if(SelectSQLPstmt  != null) SelectSQLPstmt.close(); 

		}catch(Exception e)
		{
			out.println("Exception raise by Servlet in insertEnterDuplicatesServlet method : "+e.toString());
			e.printStackTrace();
		}
	}//method
	private synchronized void modifyEnterDuplicatesServlet(HttpServletResponse res)
	{   
		try
		{
					
			String locale = p.getProperty("LOCALE");
			

			con.setAutoCommit(false);

			StringBuffer UpdateSQL = null;
			UpdateSQL = new StringBuffer();
			
			StringTokenizer token1			= new StringTokenizer(p_string_val,"~");
			StringTokenizer token2			= new StringTokenizer(p_delete_string,"~");
            		
			String tokenvalue1				= "";
			String tokenvalue2				= "";

			StringTokenizer splittedtoken1	;
			StringTokenizer splittedtoken2	;

			String p_patient_id				= "";
			String p_dup_indicator			= "";
			String p_remarks				= "";

			int p_count						= 0;
			
			sqlupdate = "";
		  
		   // int  dupgroup_id=Integer.parseInt(dupgroupid);
			
			sqlupdate = "update dr_dup_group_hdr set pat_count ="+p_pat_count+" ,modified_by_id = '"+modifiedById+"',modified_date = sysdate, modified_at_ws_no = '"+modifiedAtWorkstation+"', modified_facility_id = '"+modifiedFacilityId+"' where dup_group_id = "+dupgroupid+" ";
		
			stmt.executeUpdate(sqlupdate);

			sqlupdate		= "";
			sqlupdate		= "delete from dr_dup_group_dtls where patient_id = ? ";
			DeleteSQLPstmt	= con.prepareStatement(sqlupdate);

			
			while(token2.hasMoreTokens())
			{
				tokenvalue2      = token2.nextToken();
				
				splittedtoken2=new StringTokenizer(tokenvalue2,"`");
				
				while(splittedtoken2.hasMoreTokens())
				{
					p_count++;
					p_patient_id		=	splittedtoken2.nextToken();
					p_dup_indicator		=	splittedtoken2.nextToken();
					p_remarks			=	splittedtoken2.nextToken();					

		////////////////////////////////////////////////////////////////////////
					
					DeleteSQLPstmt.setString(1,p_patient_id);
					DeleteSQLPstmt.executeUpdate();

		////////////////////////////////////////////////////////////////////////
				
				
				}
			} 

			p_patient_id	= "";
			p_dup_indicator = "";
			p_remarks		= "";

			UpdateSQL.append("UPDATE dr_dup_group_dtls SET dup_indicator = ?, remarks = ?, modified_by_id = ?,modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ? WHERE patient_id = ?");
			 
		
			UpdateSQLPstmt =con.prepareStatement(UpdateSQL.toString());

			while(token1.hasMoreTokens())
			{
				tokenvalue1		= token1.nextToken();
				splittedtoken1	= new StringTokenizer(tokenvalue1,"`");

				while(splittedtoken1.hasMoreTokens())
				{					
					
					p_patient_id		=	splittedtoken1.nextToken();
					p_dup_indicator		=	splittedtoken1.nextToken();
					p_remarks			=	splittedtoken1.nextToken();
		   		
		////////////////////////////////////////////////////////////////////////							
					UpdateSQLPstmt.setString(1,p_dup_indicator);
					UpdateSQLPstmt.setString(2,p_remarks);
					UpdateSQLPstmt.setString(3,modifiedById);
					UpdateSQLPstmt.setString(4,modifiedAtWorkstation);
					UpdateSQLPstmt.setString(5,modifiedFacilityId);
					UpdateSQLPstmt.setString(6,p_patient_id);
                 	rsupdatedtl = UpdateSQLPstmt.executeUpdate();

		////////////////////////////////////////////////////////////////////////
					
				}
			}
			
			if(rsupdatedtl >= 0)
			{
				con.commit();

			/*	String code		= "";
				String message	= "";

				String msg = "select message_id, message_text_sysdef from sm_message where message_ref = 'RECORD_MODIFIED'";
				messageResultset = stmt.executeQuery(msg);
				if(messageResultset != null)
				{
					if(messageResultset.next())
					{
						code	= messageResultset.getString("message_id");
						message	= messageResultset.getString("message_text_sysdef");
					}
				} if(messageResultset != null) messageResultset.close(); */

				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_MODIFIED", "SM");
				String error = ((String) message.get("message"));

				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8" ) + "&err_value=1 " );
			}
			else
			{
				con.rollback();
			//	res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("Transaction Failed ") + "&err_value=0 " );
			}

			if((UpdateSQL != null) && (UpdateSQL.length() > 0))
			{
				UpdateSQL.delete(0,UpdateSQL.length());
			}

			
			if(stmt != null) stmt.close(); 
			if(DeleteSQLPstmt != null) DeleteSQLPstmt.close();
			if(UpdateSQLPstmt != null) UpdateSQLPstmt.close();

		}catch(Exception e)
		{
			out.println("Exception raise by Servlet in modifyEnterDuplicatesServlet method :"+e.toString());
			e.printStackTrace();
		}
	}//method
	private synchronized void deleteEnterDuplicatesServlet(HttpServletResponse res)
	{
		try
		{
			String locale = p.getProperty("LOCALE");
			con.setAutoCommit(false);
						
			sqlupdate = "";	 	
			
			for(int k=1;k<=p_pat;k++)
			{
			patient_id= patientid[k-1];
			
			sqldelete	= "delete dr_dup_group_dtls where patient_id ='"+patient_id+"' ";
			rsdeletedtl	= stmt.executeUpdate(sqldelete);
			}
			sqldelete = "";
			
			sqlselect="select * from  dr_dup_group_dtls where   dup_group_id= "+dupgroupid+" ";
			rs = stmt.executeQuery(sqlselect);
			if(!rs.next())
			{
			if(rsdeletedtl >0)
			{
				
				sqldelete	= "delete dr_dup_group_hdr where dup_group_id= "+dupgroupid+" ";
				stmt.executeUpdate(sqldelete);
			}
			}
			if(rs != null) rs.close();
			 if(rsdeletedtl >= 0)
			 {
				con.commit();

			/*	String code		= "";
				String message	= "";
				String msg		= "select message_id, message_text_sysdef from sm_message where message_ref = 'RECORD_DELETED'";
				messageResultset = stmt.executeQuery(msg);
				if(messageResultset != null)
				{
					if(messageResultset.next())
					{
						code	= messageResultset.getString("message_id");
						message	= messageResultset.getString("message_text_sysdef");
					}
				} if(messageResultset != null) messageResultset.close();  */

				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_DELETED", "SM");
				String error = ((String) message.get("message"));

				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=1 " );
			}
			else
			{
				con.rollback();
			//	res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("Transaction Failed ") + "&err_value=0 " );
			}

			if(stmt != null) stmt.close();
		}catch(Exception e)
		{
			out.println("<h3> Exception raise by Servlet in deleteEnterDuplicatesServlet method : "+e.toString());
			e.printStackTrace();
		}
	}//method
}//class

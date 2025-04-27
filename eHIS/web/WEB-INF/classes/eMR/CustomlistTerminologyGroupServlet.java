/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

public class CustomlistTerminologyGroupServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	String added_facility_id = "";
	String modified_facility_id = "";
	String client_ip_address = "";
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	String locale = "";
	Connection con = null;
	String added_by_id = "";
	String modified_by_id = "";
	String added_at_ws_no = "";
	String modified_at_ws_no = "";

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{	
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		added_facility_id = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");
		String function			= req.getParameter("function_name")==null?"":req.getParameter("function_name");
		modified_facility_id=added_facility_id;
		added_by_id	= (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
		modified_by_id = added_by_id;
		added_at_ws_no = client_ip_address;
		modified_at_ws_no = client_ip_address ;
		
		try
		{			
			this.out = res.getWriter();
			
			if(function.equalsIgnoreCase("insert"))
			{
				insertPractitionerSpeciality(req,res);
			}

			else if(function.equalsIgnoreCase("modify"))
			{
				updatePractitionerSpeciality(req,res);
			}
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			
			e.printStackTrace();
		}
	}

	private void insertPractitionerSpeciality(HttpServletRequest req, HttpServletResponse res)
	{
		
		String term_set_id		= req.getParameter("term_set_id")==null?"":req.getParameter("term_set_id");
		String term_grp_id		= req.getParameter("term_grp_id")==null?"":req.getParameter("term_grp_id");
		String index_type		= req.getParameter("index_type")==null?"":req.getParameter("index_type");
		//String max_record		= req.getParameter("max_record")==null?"":req.getParameter("max_record");
		//String eff_status		= req.getParameter("eff_status")==null?"":req.getParameter("eff_status");
		String from				=	(req.getParameter("from")==null)	?	"0"	:	req.getParameter("from");
        String to				=	(req.getParameter("to")==null)		?	"0"	:	req.getParameter("to");
		String checkedOnes		= "";
		RecordSet	 PractitionerSpeciality	=	null;
		//int total_record = 0;
		PreparedStatement pstmt = null;
		String msg="";
		String error_val="";
		boolean isatLeastOnePractSpecialitySelected = false;
		boolean result			= false;
		//if(max_record!=null && !max_record.equals(""))
			//total_record = Integer.parseInt(max_record);
		//if(eff_status==null || eff_status.equals(""))
	//eff_status = "D" ;
		try
		{	

			PractitionerSpeciality	=	(webbeans.eCommon.RecordSet)	session.getAttribute("PractitionerSpeciality");
			if(from != null && to != null)
			{
					from	=	from.trim();
					to		=	to.trim();
					
					for( int i=(Integer.parseInt(from)); i<=(Integer.parseInt(to)); i++)
					{
						if(req.getParameter(("chk"+i)) != null)
						{
							checkedOnes = req.getParameter(("chk"+i));
							if(!(PractitionerSpeciality.containsObject(checkedOnes)))
								PractitionerSpeciality.putObject(checkedOnes);
						}

						String removeCode = checkForNull(req.getParameter("removeCode"+(i)));
						if(removeCode.equals("Y"))
						{
							String nu_pract_Code = req.getParameter("Code"+(i));
							if((PractitionerSpeciality.containsObject(nu_pract_Code)))
							{
								int removeCodeIndex = PractitionerSpeciality.indexOfObject(nu_pract_Code);
									PractitionerSpeciality.removeObject(removeCodeIndex);
							}
						}


					}
			}
			con = ConnectionManager.getConnection(req);
			pstmt = con.prepareStatement("INSERT INTO MR_CUSTOM_LIST_TERM_GROUP_DTL(term_group_id, term_set_id,INDEX_TYPE, SPECIALITY_CODE,PRACTITIONER_ID, added_by_id,added_date, added_at_ws_no,added_facility_id, modified_by_id,modified_date, modified_at_ws_no,modified_facility_id) VALUES (?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");

			for(int i=0;i< PractitionerSpeciality.getSize();i++)
			{
				//if(req.getParameter("chk"+i)!=null && req.getParameter("chk"+i).equals("checked"))
				//{
					pstmt.setString(1,term_grp_id);
					pstmt.setString(2,term_set_id);
					pstmt.setString(3,index_type);
					if(index_type.equals("S"))
					{
						//pstmt.setString(4,req.getParameter("code"+i));
						pstmt.setString(4,(String)PractitionerSpeciality.getObject(i));
						pstmt.setString(5,"");
					}
					else
					{
						pstmt.setString(4,"");
						pstmt.setString(5,(String)PractitionerSpeciality.getObject(i));
						//pstmt.setString(5,req.getParameter("code"+i));						
					}
					//pstmt.setString(6,eff_status);
					pstmt.setString(6,added_by_id);
					pstmt.setString(7,added_at_ws_no);
					pstmt.setString(8,added_facility_id);
					pstmt.setString(9,modified_by_id);
					pstmt.setString(10,modified_at_ws_no);
					pstmt.setString(11,modified_facility_id);				
					pstmt.addBatch();
					isatLeastOnePractSpecialitySelected = true;
			}
			
			
				
			if(isatLeastOnePractSpecialitySelected)
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
			else if(!isatLeastOnePractSpecialitySelected)
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

			
		}
		catch(Exception e)
		{
			try
			{
				//out.println("Error while inserting the values=="+e.toString());
				e.printStackTrace();
				con.rollback();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=1&err_value=Error while inserting the values");
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}
		finally
		{
			try
			{
				if(pstmt != null)pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con,req);
							
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
	}
	private void updatePractitionerSpeciality(HttpServletRequest req, HttpServletResponse res)
	{

		String term_set_id		= req.getParameter("term_set_id")==null?"":req.getParameter("term_set_id");
		String term_grp_id		= req.getParameter("term_grp_id")==null?"":req.getParameter("term_grp_id");
		String index_type		= req.getParameter("index_type")==null?"":req.getParameter("index_type");
		//String max_record		= req.getParameter("max_record")==null?"":req.getParameter("max_record");
		//String eff_status		= req.getParameter("eff_status")==null?"":req.getParameter("eff_status");
		String from				=	(req.getParameter("from")==null)	?	"0"	:	req.getParameter("from");
        String to				=	(req.getParameter("to")==null)		?	"0"	:	req.getParameter("to");
		String checkedOnes		= "";
		RecordSet	 PractitionerSpeciality	=	null;
		//int total_record = 0;
		boolean isRecordDeleted = false ;
		boolean isatLeastOnePractSpecialitySelected = false;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1=null; //Added by Shanmukh for ARYU-SCF-0115 on 7th-June-2018
		ResultSet rs=null;//Added by Shanmukh for ARYU-SCF-0115 on 7th-June-2018
		String msg="";
		String error_val="";
		
		//if(max_record!=null && !max_record.equals(""))
			//total_record = Integer.parseInt(max_record);
		//if(eff_status==null || eff_status.equals(""))
			//eff_status = "D" ;
		try
		{	

			PractitionerSpeciality	=	(webbeans.eCommon.RecordSet)	session.getAttribute("PractitionerSpeciality");
			
			//Added by Shanmukh for ARYU-SCF-0115 on 7th-June-2018---- start---- 
			con = ConnectionManager.getConnection(req);
			
			try{
				
			if(index_type.equals("S")) 
			pstmt1=con.prepareStatement("SELECT SPECIALITY_CODE FROM mr_custom_list_term_group_dtl WHERE term_group_id = ? AND term_set_id = ? AND index_type = ?");
		
			else
			pstmt1=con.prepareStatement("SELECT   a.practitioner_id FROM am_practitioner a, mr_custom_list_term_group_dtl b   WHERE a.practitioner_id = b.practitioner_id  AND b.term_group_id = ? AND b.term_set_id = ? AND b.index_type = ? ORDER BY a.practitioner_name");
			
			
			pstmt1.setString(1,term_grp_id);
			pstmt1.setString(2,term_set_id);
			pstmt1.setString(3,index_type);
			
			
			rs = pstmt1.executeQuery();
			String pr_name="";
			while(rs!=null && rs.next())
			{
				
				if(index_type.equals("S")) 
					pr_name=rs.getString("speciality_code");
				else
				pr_name = rs.getString("practitioner_id");
				if(!PractitionerSpeciality.containsObject(pr_name))
					PractitionerSpeciality.putObject(pr_name);
			}
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				
				try
				{
					if(pstmt1 != null)pstmt1.close();
					
					if(rs!=null) rs.close();
								
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
			
			if(from != null && to != null)
			{
					from	=	from.trim();
					to		=	to.trim();
					
					for( int i=(Integer.parseInt(from)); i<=(Integer.parseInt(to)); i++)
					{
						if(req.getParameter(("chk"+i)) != null)
						{
							checkedOnes = req.getParameter(("chk"+i));
							if(!(PractitionerSpeciality.containsObject(checkedOnes)))
								PractitionerSpeciality.putObject(checkedOnes);
						}
						String removeCode = checkForNull(req.getParameter("removeCode"+(i)));
						if(removeCode.equals("Y"))
						{
							String nu_pract_Code = req.getParameter("Code"+(i));
							if((PractitionerSpeciality.containsObject(nu_pract_Code)))
							{
								int removeCodeIndex = PractitionerSpeciality.indexOfObject(nu_pract_Code);
									PractitionerSpeciality.removeObject(removeCodeIndex);
							}
						}
					}
			}

			

			pstmt = con.prepareStatement("delete from MR_CUSTOM_LIST_TERM_GROUP_DTL where  TERM_GROUP_ID=?  and TERM_SET_ID=? and INDEX_TYPE = ?");
			
			pstmt.setString(1,term_grp_id);
			pstmt.setString(2,term_set_id);
			pstmt.setString(3,index_type);
			
	        int result = pstmt.executeUpdate();
	        if(pstmt != null) pstmt.close();

            if(result > 0)
                isRecordDeleted = true;
            else
                isRecordDeleted = false;
			if(isRecordDeleted)
			{
					pstmt = con.prepareStatement("INSERT INTO MR_CUSTOM_LIST_TERM_GROUP_DTL(term_group_id, term_set_id,INDEX_TYPE, SPECIALITY_CODE,PRACTITIONER_ID, added_by_id,added_date, added_at_ws_no,added_facility_id, modified_by_id,modified_date, modified_at_ws_no,modified_facility_id) VALUES (?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");

					for(int i=0;i< PractitionerSpeciality.getSize();i++)
					{
						//if(req.getParameter("chk"+i)!=null && req.getParameter("chk"+i).equals("checked"))
						//{
							pstmt.setString(1,term_grp_id);
							pstmt.setString(2,term_set_id);
							pstmt.setString(3,index_type);
							if(index_type.equals("S"))
							{
								//pstmt.setString(4,req.getParameter("code"+i));
								pstmt.setString(4,(String)PractitionerSpeciality.getObject(i));
								pstmt.setString(5,"");
							}
							else
							{
								pstmt.setString(4,"");
								pstmt.setString(5,(String)PractitionerSpeciality.getObject(i));
								//pstmt.setString(5,req.getParameter("code"+i));						
							}
							//pstmt.setString(6,eff_status);
							pstmt.setString(6,added_by_id);
							pstmt.setString(7,added_at_ws_no);
							pstmt.setString(8,added_facility_id);
							pstmt.setString(9,modified_by_id);
							pstmt.setString(10,modified_at_ws_no);
							pstmt.setString(11,modified_facility_id);				
							pstmt.addBatch();
							isatLeastOnePractSpecialitySelected = true;
					}
					

					
					if(isatLeastOnePractSpecialitySelected)
					{
						int result_update[]  = pstmt.executeBatch();
						if( result_update!=null && result_update.length>0)
							isRecordDeleted	=	true;
						else
							isRecordDeleted	=	false;
					}			
				//int result_update[] = pstmt.executeBatch();

					
			}
		
	
			if( isRecordDeleted)
			{
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
					msg = (String) message.get("message");
					error_val="1";

			}
			else
			{
					con.rollback();
					java.util.Hashtable message = MessageManager.getMessage( locale, "ERROR_IN_UPDATING","SM" ) ;
					msg = (String) message.get("message");
					error_val="0";
			}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode(msg, "UTF-8") + "&err_value=" + error_val);
			
			


		}
		catch(Exception e)
		{
			try
			{
				//out.println("Error while updating the values=="+e.toString());
				e.printStackTrace();
				con.rollback();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=1&err_value=Error while inserting the values");
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}
		finally
		{
			try
			{
				if(pstmt != null)pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con,req);
							
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String Default)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? Default : inputString);
	}


}

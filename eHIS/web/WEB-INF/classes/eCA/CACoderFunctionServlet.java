/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name        	Rev.Date 		Rev.by 					Description
--------------------------------------------------------------------------------------------------------------

20/08/2020  	  IN073540              Chandrashekar Raju			                              AAKH-CRF-0122.3
16/03/2022       41064             krishna pranay             16/03/2023     Ramesh Goli              AAKH-CRF-0172
 21/03/2023     42761        krishna Pranay      21/03/2023     Ramesh Goli        COMMON-ICN-0125

--------------------------------------------------------------------------------------------------------------
*/
package eCA ;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager; 


public class CACoderFunctionServlet extends javax.servlet.http.HttpServlet	
{

public void init(ServletConfig config) throws ServletException	
{
	super.init(config);
}

public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
{
      String called_from =  "";
	  String mode         = "";
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		
		try
		{
			called_from							= req.getParameter("called_from") == null?"":req.getParameter("called_from");
			mode							    = req.getParameter("mode") == null?"":req.getParameter("mode");
			out = res.getWriter();
			if(called_from.equals("CODER_SEARCH") && mode.equals("insert"))
			    insertCoderStatus(req, res);
			else if(called_from.equals("CODER_SEARCH") && mode.equals("update"))
				 updateCoderStatus(req, res);
			else if(called_from.equals("PENDING_QUERY"))
				updatePendingRecordsStatus(req, res);
			else if(called_from.equals("CODER_ASSIGN"))
				insertOrUpdateAssignCoder(req, res);

		} 
		catch(Exception e) 
		{
			//out.println(e.toString());//common-icn-0181
			e.printStackTrace();
		}
}

public String getSysdateTime()
{
		String date = "";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Connection con = null;
		try
		{
			con = ConnectionManager.getConnection();
			String sql = "select to_char(sysdate,'dd/mm/yyyy hh24:mi' ) from dual ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				date = rs.getString(1);
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}
		catch(Exception ee)
		{
			ee.printStackTrace();			
		}
		finally
		{
			if(con != null)
			{
				ConnectionManager.returnConnection(con);
			}
		}
		return date;
	}


private void insertCoderStatus(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
{
		PrintWriter out;
		
		java.util.Properties p;
		Connection con				= null;
		PreparedStatement pstmt		= null;
		//CallableStatement cstmt = null ;//42761
		ResultSet rs				= null;
		Hashtable tabdata;
		
		String errorMsg				= "";
	//	String error_value			= "";//42761
		
		String facilityId			= "" ;
		String client_ip_address	= "";
		String locale				= "";
		String mode					= "";
		String status               = "";
		String prev_status          ="";
		String remarks              = "";
		String patient_id           = "";
		String encounter_id         = "";
		String patient_class        = "";
	//	String completed_by         ="";//42761
	//	String complete_date        = "";//42761
	//	String condflds[]={};//42761
		boolean insert = false;
		String errVal			= "0";

	//	HashMap dupflds=new HashMap();//42761
	//	java.util.HashMap results = new HashMap();//42761
		HttpSession session				= req.getSession(false);
		p								= (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address				= (String) p.getProperty("client_ip_address");
		locale							= (String) p.getProperty("LOCALE");
		facilityId						= (String) session.getValue( "facility_id" ) ;
		String addedById			= p.getProperty( "login_user" ) ;
		String modifiedById			= addedById ;
    	String addedFacilityId		= facilityId;
		String modifiedFacilityId	= facilityId ;
		String addedAtWorkstation	= client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		String addedDate = new java.text.SimpleDateFormat( "yyyy-MM-dd" ).format( new java.util.Date() ) ;
		System.err.println("addedDate@@@====="+addedDate);
		//String modifiedDate			= addedDate ;//42761
		String proceed_yn ="N";
					
		mode							= req.getParameter("mode") == null?"":req.getParameter("mode");
		patient_id                      = req.getParameter("patient_id") == null?"":req.getParameter("patient_id");
		encounter_id                    = req.getParameter("encounter_id") == null?"":req.getParameter("encounter_id");
		remarks                         = req.getParameter("remarks") == null?"":req.getParameter("remarks");
		status                          = req.getParameter("status") == null?"":req.getParameter("status");
		prev_status                     = req.getParameter("prev_status") == null?"":req.getParameter("prev_status");
		patient_class                   = req.getParameter("patient_class") == null?"":req.getParameter("patient_class");

	//	java.sql.Date added_date	= java.sql.Date.valueOf( addedDate );//42761
		
		if(status.equals(""))
			status ="NW";

		
		
		out = res.getWriter();
		
		
		try
			{
				con = ConnectionManager.getConnection(req);
				if(status.equals("CO")){
					pstmt = con.prepareStatement("select bl_coders.chk_unbilled_rec(?,?)proceed_yn from dual");
				    pstmt.setString(1,facilityId);
				    pstmt.setString(2,encounter_id);
				
				rs = pstmt.executeQuery();
				if(rs != null && rs.next())
				{
					proceed_yn = rs.getString("proceed_yn")==null?"":rs.getString("proceed_yn");
					
				}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					
				}
				System.err.println("proceed_yn@@@======"+proceed_yn);
				if(proceed_yn.equals("N")){

				String sqlCheck = "select 1 from CA_CODER_STATUS where patient_id = ? and encounter_id = ? ";
				pstmt = con.prepareStatement(sqlCheck);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,encounter_id);
				
				
				rs = pstmt.executeQuery();
				if(rs != null && rs.next())
				{
					tabdata = MessageManager.getMessage(locale,"CODE_ALREADY_EXISTS","COMMON");
					errorMsg= (String) tabdata.get("message");
					errVal = "0";
				}
				else
				{
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();

			//	String insert_sql ="INSERT INTO CA_CODER_STATUS (PATIENT_ID, ENCOUNTER_ID,PATIENT_CLASS,FACILITY_ID,STATUS,PREV_STATUS,REMARKS,COMPLETED_BY,COMPLETE_DATE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,##COMP_DATE##,?,SYSDATE,?,?,?,SYSDATE,?,?)";
				String insert_sql ="INSERT INTO CA_CODER_STATUS (PATIENT_ID, ENCOUNTER_ID,PATIENT_CLASS,FACILITY_ID,STATUS,PREV_STATUS,REMARKS,COMPLETED_BY,COMPLETE_DATE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,SUPERVISOR_BY,SUPERVISOR_DATE) VALUES (?,?,?,?,?,?,?,?,##COMP_DATE##,?,SYSDATE,?,?,?,SYSDATE,?,?,?,##SUP_DATE##)";//41064
                 
				  if(status.equals("CO")){
                       insert_sql = insert_sql.replace("##COMP_DATE##","SYSDATE");
				  }else{
					 insert_sql = insert_sql.replace("##COMP_DATE##","?");
				  }
				  //41064 start
				  if(status.equals("SC")){
                      insert_sql = insert_sql.replace("##SUP_DATE##","SYSDATE");
				  }else{
					 insert_sql = insert_sql.replace("##SUP_DATE##","?");
				  }
				  

					pstmt = con.prepareStatement(insert_sql.toString());


					pstmt.setString(1,patient_id);
					pstmt.setString(2,encounter_id);
					pstmt.setString(3,patient_class);
					pstmt.setString(4,facilityId);
					pstmt.setString(5,status);
					pstmt.setString(6,prev_status);
					pstmt.setString(7,remarks);
					if(status.equals("CO")){
					pstmt.setString(8,addedById);
					pstmt.setString(9,addedById);
					pstmt.setString(10,addedAtWorkstation);
					pstmt.setString(11,addedFacilityId);
					pstmt.setString(12,modifiedById);
					pstmt.setString(13,modifiedAtWorkstation);
					pstmt.setString(14,modifiedFacilityId);
					pstmt.setString(15,"");
					pstmt.setString(16,"");
					}else if(status.equals("SC")){
				    pstmt.setString(8,"");
					pstmt.setString(9,"");
					pstmt.setString(10,addedById);
					pstmt.setString(11,addedAtWorkstation);
					pstmt.setString(12,addedFacilityId);
					pstmt.setString(13,modifiedById);
					pstmt.setString(14,modifiedAtWorkstation);
					pstmt.setString(15,modifiedFacilityId);
	                pstmt.setString(16,modifiedById);
					}else{
					pstmt.setString(8,"");
					pstmt.setString(9,"");
					pstmt.setString(10,addedById);
					pstmt.setString(11,addedAtWorkstation);
					pstmt.setString(12,addedFacilityId);
					pstmt.setString(13,modifiedById);
					pstmt.setString(14,modifiedAtWorkstation);
					pstmt.setString(15,modifiedFacilityId);
                    pstmt.setString(16,"");
					pstmt.setString(17,"");
				//	41064 end
					}
					
					
					int count = pstmt.executeUpdate();
                        if(count >0){
							insert =true;
						}
							if(pstmt != null) pstmt.close();
							if(insert)
							{
								con.commit();
								tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
								errorMsg= (String) tabdata.get("message");
								errVal = "1";
							}
							else
							{
								con.rollback();
								tabdata = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
								errorMsg= (String) tabdata.get("message");
								errVal = "0";
							}
						
				  }
				} 
				if (proceed_yn.equals("Y"))
				{
                      errorMsg ="THERE ARE SOME UNBILLED/PENDING RECORDS EXISTS,CAN NOT PROCCED";
					  errVal ="0";
				}
				res.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
				
			}
			catch (Exception ee)
			{
				

				ee.printStackTrace();
			}
			finally
	 		{
				
				if(con != null)
					ConnectionManager.returnConnection(con,req);
				

			}
		}

		private void updateCoderStatus(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
{
		PrintWriter out;
		
		java.util.Properties p;
		Connection con				= null;
		PreparedStatement pstmt		= null;
		ResultSet rs				= null;
		Hashtable tabdata;
		
		String errorMsg				= "";
	//	String error_value			= "";//42761
		
		String facilityId			= "" ;
		String client_ip_address	= "";
		String locale				= "";
		String mode					= "";
		String status               = "";
		String prev_status          ="";
		String completed_by         ="";
		String complete_date        = "";
		String supervisor_by         ="";//41064
		String supervisor_date        = "";//41064
		String remarks              = "";
		String patient_id           = "";
		String encounter_id         = "";
	//	String condflds[]={};//42761
		boolean update = false;
		String errVal			= "0";
		String proceed_yn ="N";
		

//		HashMap dupflds=new HashMap();//42761
	//	java.util.HashMap results = new HashMap();//42761
		HttpSession session				= req.getSession(false);
		p								= (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address				= (String) p.getProperty("client_ip_address");
		locale							= (String) p.getProperty("LOCALE");
		facilityId						= (String) session.getValue( "facility_id" ) ;
		String addedById			= p.getProperty( "login_user" ) ;
		String modifiedById			= addedById ;
    //	String addedFacilityId		= facilityId;////42761
		String modifiedFacilityId	= facilityId ;
		String addedAtWorkstation	= client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
	    String modifiedDate			= new java.text.SimpleDateFormat( "yyyy-MM-dd" ).format( new java.util.Date() ) ;
	//	java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;//42761
		
					
		mode							= req.getParameter("mode") == null?"":req.getParameter("mode");
		patient_id                      = req.getParameter("patient_id") == null?"":req.getParameter("patient_id");
		encounter_id                    = req.getParameter("encounter_id") == null?"":req.getParameter("encounter_id");
		remarks                         = req.getParameter("remarks") == null?"":req.getParameter("remarks");
		status                          = req.getParameter("status") == null?"":req.getParameter("status");
		prev_status                     = req.getParameter("prev_status") == null?"":req.getParameter("prev_status");
		if(status.equals(""))
			status ="NW";
		
        if(status.equals("CO"))
	    {
           completed_by = addedById;
		   complete_date =getSysdateTime();
	    }
        //41064 start
        if(status.equals("SC"))
	    {
           supervisor_by = addedById;
		   supervisor_date =getSysdateTime();
	    }
		//41064 end
		
		out = res.getWriter();
		
		try
			{
				con = ConnectionManager.getConnection(req);
              System.err.println("status@@====="+status);
				if(status.equals("CO")){
					pstmt = con.prepareStatement("select bl_coders.chk_unbilled_rec(?,?)proceed_yn from dual");
				    pstmt.setString(1,facilityId);
				    pstmt.setString(2,encounter_id);
					System.err.println("facilityId @@====="+facilityId+"encounter_id@@==="+encounter_id);
				
				rs = pstmt.executeQuery();
				if(rs != null && rs.next())
				{
					proceed_yn = rs.getString("proceed_yn")==null?"":rs.getString("proceed_yn");
					
				}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					
				}
				System.err.println("proceed_yn@@@======"+proceed_yn+"facilityId==="+facilityId+"encounter_id=="+encounter_id);
				if(proceed_yn.equals("N")){

				

				//	String uppdate_sql ="UPDATE CA_CODER_STATUS SET REMARKS =?,STATUS =?,PREV_STATUS =?,COMPLETED_BY =?,COMPLETE_DATE =##COMP_DATE##,MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?  WHERE PATIENT_ID =? AND ENCOUNTER_ID =? ";
					String  uppdate_sql ="UPDATE CA_CODER_STATUS SET REMARKS =?,STATUS =?,PREV_STATUS =?,COMPLETED_BY =?,COMPLETE_DATE =##COMP_DATE##,MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? ,SUPERVISOR_BY =?,SUPERVISOR_DATE =##SUP_DATE## WHERE PATIENT_ID =? AND ENCOUNTER_ID =? ";//41064
					
					if(status.equals("CO"))
                       uppdate_sql = uppdate_sql.replace("##COMP_DATE##","SYSDATE");
					else
						uppdate_sql = uppdate_sql.replace("##COMP_DATE##","?");
					//41064 start
					if(status.equals("SC"))
	                       uppdate_sql = uppdate_sql.replace("##SUP_DATE##","SYSDATE");
						else
							uppdate_sql = uppdate_sql.replace("##SUP_DATE##","?");

					pstmt = con.prepareStatement(uppdate_sql.toString());
					
					pstmt.setString(1,remarks);
					pstmt.setString(2,status);
					pstmt.setString(3,prev_status);	
					if(status.equals("CO")){
					pstmt.setString(4,modifiedById);
					pstmt.setString(5,modifiedById);
					pstmt.setString(6,modifiedAtWorkstation);
					pstmt.setString(7,modifiedFacilityId);
                    pstmt.setString(8,"");
                    pstmt.setString(9,"");
					pstmt.setString(10,patient_id);
					pstmt.setString(11,encounter_id);
					}else	if(status.equals("SC")){
					pstmt.setString(4,"");
					pstmt.setString(5,"");
					pstmt.setString(6,modifiedById);
					pstmt.setString(7,modifiedAtWorkstation);
					pstmt.setString(8,modifiedFacilityId);
	                pstmt.setString(9,supervisor_by);
					pstmt.setString(10,patient_id);
				    pstmt.setString(11,encounter_id);
					}else{	
					pstmt.setString(4,"");
					pstmt.setString(5,"");
					pstmt.setString(6,modifiedById);
					pstmt.setString(7,modifiedAtWorkstation);
					pstmt.setString(8,modifiedFacilityId);
                    pstmt.setString(9,"");
                    pstmt.setString(10,"");
					pstmt.setString(11,patient_id);
					pstmt.setString(12,encounter_id);
				//	41064 end
					}
					
					
					int count = pstmt.executeUpdate();
                        if(count >0){
							update =true;
						}
							if(pstmt != null) pstmt.close();
							if(update)
							{
								con.commit();
								tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
								errorMsg= (String) tabdata.get("message");
								errVal = "1";
							}
							else
							{
								con.rollback();
								tabdata = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
								errorMsg= (String) tabdata.get("message");
								errVal = "0";
							}
						res.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
				}else{
				
				if (proceed_yn.equals("Y"))
				{
                      errorMsg ="THERE ARE SOME UNBILLED/PENDING RECORDS EXISTS,CAN NOT PROCCED";
					  errVal ="0";
				}
				res.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
				}
									
				
            }catch (Exception ee)
			{
				

				ee.printStackTrace();
			}
			finally
	 		{
				
				if(con != null)
					ConnectionManager.returnConnection(con,req);
				

			}
		}

private void updatePendingRecordsStatus(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
{
		PrintWriter out;
		
		java.util.Properties p;
		Connection con				= null;
		PreparedStatement pstmt		= null;
		ResultSet rs				= null;
		Hashtable tabdata;
		
		String errorMsg				= "";
		//String error_value			= "";////42761
		
		String facilityId			= "" ;
		String client_ip_address	= "";
		String locale				= "";
		String select_yn               = "";
		String prev_status          ="";
		String patient_id           = "";
		String encounter_id         = "";
		String call_from     ="";
		//String condflds[]={};//42761
		boolean update = false;
		String errVal			= "0";
		

	//	HashMap dupflds=new HashMap();//42761
	//	java.util.HashMap results = new HashMap();//42761
		HttpSession session				= req.getSession(false);
		p								= (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address				= (String) p.getProperty("client_ip_address");
		locale							= (String) p.getProperty("LOCALE");
		facilityId						= (String) session.getValue( "facility_id" ) ;
		String addedById			= p.getProperty( "login_user" ) ;
		String modifiedById			= addedById ;
    //	String addedFacilityId		= facilityId;////42761
		String modifiedFacilityId	= facilityId ;
		String addedAtWorkstation	= client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		String row_count ="";
		int count =0;


		call_from  = req.getParameter("function_id") == null?"":req.getParameter("function_id");
		row_count  = req.getParameter("row_count") == null?"":req.getParameter("row_count");
		
		if(row_count!= null)
				count = Integer.parseInt(row_count);

		
		if(call_from.equals("DQ"))
			prev_status ="DQ";
		else
			prev_status ="SQ";
		
		
		out = res.getWriter();

		
		try
			{
				con = ConnectionManager.getConnection(req);

				

					String uppdate_sql ="UPDATE CA_CODER_STATUS SET  STATUS =?,PREV_STATUS =?,MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?  WHERE PATIENT_ID =? AND ENCOUNTER_ID =? ";
					pstmt = con.prepareStatement(uppdate_sql.toString());

					for(int i=0;i<=count;i++){

                    patient_id = req.getParameter("patient_id_"+i) == null?"":req.getParameter("patient_id_"+i);
					encounter_id = req.getParameter("encounter_id_"+i) == null?"":req.getParameter("encounter_id_"+i);
					select_yn = req.getParameter("select_"+i) == null?"":req.getParameter("select_"+i);
					
					if(select_yn.equals("Y")){
					
					pstmt.setString(1,"NW");
					pstmt.setString(2,prev_status);
					pstmt.setString(3,modifiedById);
					pstmt.setString(4,modifiedAtWorkstation);
					pstmt.setString(5,modifiedFacilityId);
					pstmt.setString(6,patient_id);
					pstmt.setString(7,encounter_id);
					pstmt.addBatch();
					}
					
				}
					int[] batch_result = pstmt.executeBatch();
                       for (int i=0;i<batch_result.length;i++ ) {
								if (batch_result[i]<0  && batch_result[i] != -2) {
									pstmt.cancel();
									update =false;
									throw new Exception("Other Medication insertion Failed");
								}
								else{
									update = true;
								}
							}
							if(pstmt != null) pstmt.close();
							if(update)
							{
								con.commit();
								tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
								errorMsg= (String) tabdata.get("message");
								errVal = "1";
							}
							else
							{
								con.rollback();
								tabdata = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
								errorMsg= (String) tabdata.get("message");
								errVal = "0";
							}
						res.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
									
				
            }catch (Exception ee)
			{
				

				ee.printStackTrace();
			}
			finally
	 		{
				
				if(con != null)
					ConnectionManager.returnConnection(con,req);
				

			}
		}

private void insertOrUpdateAssignCoder(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
{
		PrintWriter out;
		
		java.util.Properties p;
		Connection con				= null;
		PreparedStatement pstmt		= null;
	//	CallableStatement cstmt = null ;//42761
		ResultSet rs				= null;
		Hashtable tabdata;
		
		String errorMsg				= "";
	//	String error_value			= "";//42761
		
		String facilityId			= "" ;
		String client_ip_address	= "";
		String locale				= "";
		String mode					= "";
	//	String status               = "";//42761
		String patient_id           = "";
		String encounter_id         = "";
		String patient_class        = "";
		String coder_id             = "";
		String select_yn            = "";
		String row_count            = "";
	//	String condflds[]={};//42761
		boolean insert = false;
		boolean update = false;
		String errVal			= "0";
		int count =0;

	//	HashMap dupflds=new HashMap();//42761
	//	java.util.HashMap results = new HashMap();//42761
		HttpSession session				= req.getSession(false);
		p								= (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address				= (String) p.getProperty("client_ip_address");
		locale							= (String) p.getProperty("LOCALE");
		facilityId						= (String) session.getValue( "facility_id" ) ;
		String addedById			= p.getProperty( "login_user" ) ;
		String modifiedById			= addedById ;
    	String addedFacilityId		= facilityId;
		String modifiedFacilityId	= facilityId ;
		String addedAtWorkstation	= client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		String addedDate			= new java.text.SimpleDateFormat( "yyyy-MM-dd" ).format( new java.util.Date() ) ;
		String modifiedDate			= addedDate ;
		ArrayList insertCoder  =new ArrayList();
		ArrayList updateCoder  =new ArrayList();
					
		
		
	//	java.sql.Date added_date	= java.sql.Date.valueOf( addedDate ) ;//42761
	//	java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;//42761
		row_count  = req.getParameter("row_count") == null?"":req.getParameter("row_count");
		
		if(row_count!= null)
				count = Integer.parseInt(row_count);
		String uppdate_sql ="UPDATE CA_CODER_STATUS SET ASSIGNED_PRACTITIONER_ID =?,MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?  WHERE PATIENT_ID =? AND ENCOUNTER_ID =? ";

		
		
		out = res.getWriter();
		
		
		try
			{
				con = ConnectionManager.getConnection(req);
				for(int i=0;i<=count;i++){
				    patient_id = req.getParameter("patient_id_"+i) == null?"":req.getParameter("patient_id_"+i);
					encounter_id = req.getParameter("encounter_id_"+i) == null?"":req.getParameter("encounter_id_"+i);
					select_yn = req.getParameter("select_"+i) == null?"":req.getParameter("select_"+i);
					coder_id = req.getParameter("rl_coder_id_"+i) == null?"":req.getParameter("rl_coder_id_"+i);
					patient_class = req.getParameter("patient_class_"+i) == null?"":req.getParameter("patient_class_"+i);
					mode = req.getParameter("mode_"+i) == null?"":req.getParameter("mode_"+i);
					
					if(select_yn.equals("Y")){
						if(mode.equals("I")){
                            insertCoder.add(patient_id);
							insertCoder.add(encounter_id);
							insertCoder.add(patient_class);
							insertCoder.add(facilityId);
							insertCoder.add("NW");
							insertCoder.add(coder_id);
							insertCoder.add(addedById);
							insertCoder.add(addedAtWorkstation);
							insertCoder.add(addedFacilityId);
							insertCoder.add(modifiedById);
							insertCoder.add(modifiedAtWorkstation);
							insertCoder.add(modifiedFacilityId);
						}else if (mode.equals("U"))
						{
							updateCoder.add(patient_id);
							updateCoder.add(encounter_id);
							updateCoder.add(coder_id);
							updateCoder.add(modifiedById);
							updateCoder.add(modifiedAtWorkstation);
							updateCoder.add(modifiedFacilityId);
						}

					}
				}
				
             if(updateCoder.size()>0){
					
					pstmt = con.prepareStatement(uppdate_sql.toString());
					for(int k =0;k<updateCoder.size();k+=6){

					pstmt.setString(1,(String)updateCoder.get(k+2));
					pstmt.setString(2,(String)updateCoder.get(k+3));
					pstmt.setString(3,(String)updateCoder.get(k+4));
					pstmt.setString(4,(String)updateCoder.get(k+5));
					pstmt.setString(5,(String)updateCoder.get(k));
					pstmt.setString(6,(String)updateCoder.get(k+1));

					pstmt.addBatch();
					
				}
					int[] batch_result = pstmt.executeBatch();
                       for (int i=0;i<batch_result.length;i++ ) {
								if (batch_result[i]<0  && batch_result[i] != -2) {
									pstmt.cancel();
									update =false;
									throw new Exception(" Coder updation Failed");
								}
								else{
									update = true;
								}
							}
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							
			   }else
				   update =true;
			if(update){
  				if(insertCoder.size()>0)
				{
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();

					String insert_sql ="INSERT INTO CA_CODER_STATUS (PATIENT_ID, ENCOUNTER_ID,PATIENT_CLASS,FACILITY_ID,STATUS,ASSIGNED_PRACTITIONER_ID,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
					pstmt = con.prepareStatement(insert_sql.toString());

              
                for(int m =0;m<insertCoder.size();m+=12){
                  
					pstmt.setString(1,(String)insertCoder.get(m));
					pstmt.setString(2,(String)insertCoder.get(m+1));
					pstmt.setString(3,(String)insertCoder.get(m+2));
					pstmt.setString(4,(String)insertCoder.get(m+3));
					pstmt.setString(5,(String)insertCoder.get(m+4));
					pstmt.setString(6,(String)insertCoder.get(m+5));
					pstmt.setString(7,(String)insertCoder.get(m+6));
					pstmt.setString(8,(String)insertCoder.get(m+7));
					pstmt.setString(9,(String)insertCoder.get(m+8));
					pstmt.setString(10,(String)insertCoder.get(m+9));
					pstmt.setString(11,(String)insertCoder.get(m+10));
					pstmt.setString(12,(String)insertCoder.get(m+11));
					pstmt.addBatch();
					}
					
					int[] batch_result = pstmt.executeBatch();
                       for (int j=0;j<batch_result.length;j++ ) {
								if (batch_result[j]<0  && batch_result[j] != -2) {
									pstmt.cancel();
									update =false;
									throw new Exception(" Coder insertion Failed");
								}
								else{
									insert = true;
								}
							}
							if(pstmt != null) pstmt.close();
							if(insert)
							{
								con.commit();
								tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
								errorMsg= (String) tabdata.get("message");
								errVal = "1";
							}
							else
							{
								con.rollback();
								tabdata = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
								errorMsg= (String) tabdata.get("message");
								errVal = "0";
							}
						
				  }else{
					            con.commit();
								tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
								errorMsg= (String) tabdata.get("message");
								errVal = "1";
								res.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
				  }
				  res.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
				}else{
					            con.rollback();
								tabdata = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
								errorMsg= (String) tabdata.get("message");
								errVal = "0";
				  res.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
				}
				
				
				
			}
			catch (Exception ee)
			{
				

				ee.printStackTrace();
			}
			finally
	 		{
				
				if(con != null)
					ConnectionManager.returnConnection(con,req);
				

			}
		}		
}

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        Rev.Date	Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
26/11/2014	IN050580			Nijitha 								MO-CRF-20080
27/07/2016	IN059747			Karthi L								JD-CRF-0199
18/03/2020	IN071264		 	Nijitha S	18/03/2020	Ramesh G	    GHL-CRF-0604			
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;
import java.io.*;

import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;


public class ReviewNotesResponseServlet extends javax.servlet.http.HttpServlet 
{
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession	 session = null;
		Connection	con = null;
		PrintWriter out = null;

		try
		{
			out = res.getWriter();
			session = req.getSession(false);			
			con	=	ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			insertRecord(req,res,session,con,out);
		}
		catch (Exception e)	
		{
			if(con!=null) ConnectionManager.returnConnection(con, req);
			//out.println("In post "+e);//common-icn-0181
			e.printStackTrace();
		}		
	}

	private void insertRecord(HttpServletRequest req, HttpServletResponse res, HttpSession session, Connection con,PrintWriter out)	
	{
		PreparedStatement	pstmt	=	null;
		Properties p = (java.util.Properties) session.getValue("jdbc") ;
		String	locale	= (String) p.getProperty("LOCALE");
		StringTokenizer st			=	null,	st1					=	null; 
		boolean	transaction_success	=	false;
		int		insert_result		=	0,		update_result		=	0;  

		String	privilegetype		=	"",		accessionnum		=	"";
		String	clinicianid			=	"",		notetypedesc		=	"";
		String	login_user_id		=	"",		login_at_ws_no		=	"";
		String	final_values		=	"",		facility_id			=	"";
		//String	l_authorized_by_id	=	"",		temp				=	"";		
		String	sql					=	"";
		String  remarks				=   "";
		String  requestedbyid		=   "";
		String  requested_to	=	"" ;
		String  requested_to1	=	"" ;
		StringBuffer query = null;
		String notes_amend_status 	= "N"; //JD-CRF-0199 [IN059747] 
		String order_id				= ""; //JD-CRF-0199 [IN059747]
		ArrayList notesResultList 	= null; //JD-CRF-0199 [IN059747]
		String	 patient_id =	"";//IN071264
		String	 encounter_id =	"";//IN071264
		String note_type ="";//IN071264
		try
		{
			final_values	=	req.getParameter("final_values")==null?"":req.getParameter("final_values");
			facility_id		=	req.getParameter("facility_id")==null?"":req.getParameter("facility_id");
			remarks         =   req.getParameter("remarks")==null?"":req.getParameter("remarks");
			requested_to1 = req.getParameter("requested_to");
		    if(requested_to1==null)
			requested_to1 = "P";
			
			login_at_ws_no	=	req.getRemoteAddr();
			login_user_id	=	(String)	session.getValue("login_user");
			
			transaction_success		= true;
			st						=	new StringTokenizer(final_values,"#");
			String	temp ="";
			String amend_result_note_yn = getAmendNoteParam(con); //JD-CRF-0199 [IN059747]
			
			CAClinicalNotesAutoSaveBean autoSaveBean = new CAClinicalNotesAutoSaveBean();
			while(st.hasMoreTokens())
			{
				
			    temp				=	st.nextToken();
				st1					=	new StringTokenizer(temp,"~");
				while(st1.hasMoreTokens())
				{
					privilegetype		=	st1.nextToken();
					accessionnum		=	st1.nextToken();
					clinicianid			=	st1.nextToken();
					facility_id			=	st1.nextToken();
					notetypedesc		=	st1.nextToken();
					requestedbyid		=	st1.nextToken();
					requested_to		=	st1.nextToken();
					//IN071264 Starts
					patient_id			=	st1.nextToken();
					encounter_id		=	st1.nextToken();
					note_type			=	st1.nextToken();
					//IN071264 Ends
					
				//	l_authorized_by_id	=	login_user_id;

					//sb.append(privilegetype+"  "+accessionnum+"  "+clinicianid+"  "+facility_id+"  "+forwardeduserid);
					// update ca_encntr_note_audit_log
					//Shaiju st
					
					query = new StringBuffer();
					query.append( " Update ca_encntr_note_audit_log ");
					query.append( " Set action_date_time = SYSDATE, ");
					query.append( " action_status='CO',action_by_id=?, ");//action_by_id=nvl(action_by_id,?)
					query.append( " modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, ");
					query.append( " modified_facility_id = ? ");
					query.append( " Where action_status = 'RQ' ");
					query.append( " And action_type	in ('RV','RS','FS') ");
					if(requested_to.equals("S"))
					{
						query.append( " AND ACTION_BY_GROUP_CODE = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id = ? ) ");
					}
					else
						query.append( " And action_by_id	= ? ");

					query.append( " And facility_id	= ? ");
					query.append( " And accession_num	= ? ");
						
					//Shaiju en
					
					
					/*sql = " Update ca_encntr_note_audit_log "+
							" Set action_date_time = SYSDATE, "+
							" action_status='CO', "+
							" modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, "+
							" modified_facility_id = ? "+
							" Where action_status = 'RQ' "+
							" And action_type	= 'RV' "+
							" And action_by_id	= ? "+
							" And facility_id	= ? "+
							" And accession_num	= ? ";  */
					//sb.append(sql);
					//pstmt = con.prepareStatement( sql );

					pstmt = con.prepareStatement( query.toString() );
					
					pstmt.setString	(	1,	clinicianid	);
					pstmt.setString	(	2,	login_user_id	);
					pstmt.setString	(	3,	login_at_ws_no	);
					pstmt.setString	(	4,	facility_id		);
					pstmt.setString	(	5,	clinicianid		);
					pstmt.setString	(	6,	facility_id		);
					pstmt.setString	(	7,	accessionnum	);

					update_result  =  pstmt.executeUpdate() ;
					
					if(pstmt!=null) pstmt.close();

					if(update_result > 0 )
					{
						transaction_success = true;
					}
					else
					{
						sql = "insert into ca_encntr_note_audit_log "+
								" (FACILITY_ID "+          
								" ,ACCESSION_NUM "+                  
								" ,ACTION_DATE_TIME "+               
								" ,ACTION_TYPE "+                    
								" ,ACTION_STATUS "+  
								" ,ACTION_BY_ID "+   
								" ,ADDED_BY_ID "+   
								" ,ADDED_DATE "+   
								" ,ADDED_AT_WS_NO "+   
								" ,ADDED_FACILITY_ID "+   
								" ,MODIFIED_BY_ID "+   
								" ,MODIFIED_DATE "+   
								" ,MODIFIED_AT_WS_NO "+   
								" ,MODIFIED_FACILITY_ID "+   
								" ) values ( "+
								" ? , ?, SYSDATE, 'RV', 'CO', ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? ) ";

						//sb.append(sql);
						pstmt = con.prepareStatement( sql );

						pstmt.setString	(	1,	facility_id		);
						pstmt.setString	(	2,	accessionnum	);
						pstmt.setString	(	3,	clinicianid		);
						pstmt.setString	(	4,	login_user_id	);
						pstmt.setString	(	5,	login_at_ws_no	);
						pstmt.setString	(	6,	facility_id		);
						pstmt.setString	(	7,	login_user_id	);
						pstmt.setString	(	8,	login_at_ws_no	);
						pstmt.setString	(	9,	facility_id		);

						insert_result  =  pstmt.executeUpdate() ;
						
						if(pstmt!=null) pstmt.close();

						if(insert_result !=0 )
							transaction_success = true;
						else
							transaction_success = false;
					} // end of else
					//JD-CRF-0199 [IN059747] - Start
					if(transaction_success){
						if("Y".equals(amend_result_note_yn)){
							notesResultList = getNoteResultDataClob(accessionnum, facility_id, con);
							Iterator iterator = notesResultList.iterator();
							while(iterator.hasNext()){
								order_id = (String)iterator.next();
							}
							if(order_id != null && order_id != "") {
								notes_amend_status = insertResultDataClob(notesResultList, con);
								if("Y".equals(notes_amend_status)){
									notesResultList.add(accessionnum);
									notesResultList.add(login_user_id);
									notesResultList.add(facility_id);
									updateEncHistoryNotes(notesResultList, con);
								}
							}	
						}	
					}
					//JD-CRF-0199 [IN059747] - End
					autoSaveBean.removedatafromsectionTemp(patient_id, encounter_id, note_type, login_user_id, con);//IN071264
				} // end of while(st1.hasMoreTokens())
				
				//taking care of one more entry in the table for the send back response
				if(transaction_success)
				{
					sql = "insert into ca_encntr_note_audit_log "+
								" (FACILITY_ID "+          
								" ,ACCESSION_NUM "+                  
								" ,ACTION_DATE_TIME "+               
								" ,ACTION_TYPE "+                    
								" ,ACTION_STATUS "+
								" ,ACTION_BY_ID "+
								" ,REQUEST_DATE_TIME "+
								" ,REQUEST_BY_ID "+
								" ,ACTION_COMMENT "+
								" ,ADDED_BY_ID "+   
								" ,ADDED_DATE "+   
								" ,ADDED_AT_WS_NO "+   
								" ,ADDED_FACILITY_ID "+   
								" ,MODIFIED_BY_ID "+   
								" ,MODIFIED_DATE "+   
								" ,MODIFIED_AT_WS_NO "+   
								" ,MODIFIED_FACILITY_ID ,ACTION_BY_TYPE "+   
								" ) values ( "+
								" ? , ?, SYSDATE, 'RS', 'RQ', ?, sysdate,?, ? ,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?,'P' ) ";

						//sb.append(sql);
						pstmt = con.prepareStatement( sql );

						pstmt.setString	(	1,	facility_id		);
						pstmt.setString	(	2,	accessionnum	);
						pstmt.setString	(	3,	requestedbyid	);
						pstmt.setString	(	4,	clinicianid		);
						pstmt.setString	(	5,	remarks			);
						pstmt.setString	(	6,	login_user_id 	);
						pstmt.setString	(	7,	login_at_ws_no	);
						pstmt.setString	(	8,	facility_id		);
						pstmt.setString	(	9,	login_user_id	);
						pstmt.setString	(	10,	login_at_ws_no	);
						pstmt.setString	(	11,	facility_id		);

						insert_result  =  pstmt.executeUpdate() ;
						
						if(pstmt!=null) pstmt.close();

						if(insert_result !=0 )
							transaction_success = true;
						else
							transaction_success = false;
            
						
				}
				//------ends here---------
			}
			
			String error = "";

			out.println("<html><link rel='stylesheet' type='text/css' href='../eCommon/html/IeStyle.css'></link>");
			out.println("<BODY CLASS='MESSAGE'>");			
			if(transaction_success)
			{
				error = getMessage(locale, "RECORD_INSERTED","CA");
				out.println(error);
				con.commit();	
				//out.println("<script>top.content.workAreaFrame.ReviewNotesCriteriaFrame.onSuccess()</script>");	
				/*if(requested_to1.equals("P") || requested_to1.equals("S") || requested_to1.equals("A"))
				{	*/			
					out.println("<script language=\"javascript\">");
					out.println("if(top.content.workAreaFrame.refferalTrackingNotesRefferedFrom!=undefined && top.content.workAreaFrame.refferalTrackingNotesRefferedFrom!=null ){");
					out.println("top.content.workAreaFrame.refferalTrackingNotesRefferedFrom.onSuccess()");
					out.println("}");
					out.println("else{");
					out.println("top.content.workAreaFrame.ReviewNotesCriteriaFrame.onSuccess()");
					out.println("}");//IN050580			
					out.println("</script>");

			//	}
			/*else
				{
				   	out.println("<script>top.content.workAreaFrame.content.workAreaFrame.ReviewNotesCriteriaFrame.onSuccess()</script>");	
					
					
				}*/
			}
			else
			{
				error = getMessage(locale, "FAILED_TRANSACTION","CA");
				out.println(error);
			}
			
			out.println("</BODY></html>");
		}
		catch ( Exception e )
		{
			try 
			{
				con.rollback();
			}catch(Exception ee)
			{}
			e.printStackTrace();
			out.println("<html><link rel='stylesheet' type='text/css' href='../eCommon/html/IeStyle.css'></link>");
			out.println("<BODY CLASS='MESSAGE'>");
			//out.println(e);//common-icn-0181
			out.println("</BODY></html>");
		}
		finally 
		{
			try 
			{
				if(pstmt!=null) pstmt.close();
				if(con!=null) { ConnectionManager.returnConnection(con,p); }
			}
			catch (Exception e) {
				
			}
		} 
	}
	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
	//JD-CRF-0199 [IN059747] - Start
	public String getAmendNoteParam(Connection con) throws Exception {
		String amend_result_note_yn = "N";
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String selectSql = "select amend_result_note_yn from ca_note_param where module_id = 'CA'";
		try {
			pstmt = con.prepareStatement(selectSql);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				amend_result_note_yn = resultSet.getString("amend_result_note_yn");
			}
		} catch(Exception ex){
			System.err.println(" Exception in ReviewNotesResponseServlet.java =>  " + ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			try{
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
			} catch(Exception ex){
				System.err.println(" Exception in ReviewNotesResponseServlet.java =>  " + ex.getMessage());
				ex.printStackTrace();
			}
		}
		return amend_result_note_yn;
	}
	public ArrayList getNoteResultDataClob(String accession_num, String facility_id, Connection con) throws Exception {
		String result_data = "";
		PreparedStatement pstmt_clob =  null;
		ResultSet rset_clob = null;
		ArrayList notes_list = null;
		String note_content_clob = "select note_type, contr_mod_accession_num, note_content from ca_encntr_note where accession_num = ? and facility_id = ?";
		try
		{
			pstmt_clob = con.prepareStatement(note_content_clob);
			pstmt_clob.setString(1,accession_num);
			pstmt_clob.setString(2,facility_id);
			
			rset_clob=pstmt_clob.executeQuery();
			notes_list = new ArrayList();
			while(rset_clob!=null && rset_clob.next())
			{
				notes_list.add(rset_clob.getString("contr_mod_accession_num"));
				java.sql.Clob clb = (java.sql.Clob) rset_clob.getClob("NOTE_CONTENT");
				result_data = clb.getSubString(1,( (int)clb.length() ));
				notes_list.add(result_data);
			}
		} catch ( Exception ee ) {
			System.err.println(" Exception in ReviewNotesResponseServlet.java => " + ee.getMessage());
			ee.printStackTrace() ;
		} finally {
			try {
				if(rset_clob != null)
					rset_clob.close();
				if(pstmt_clob != null)
					pstmt_clob.close();
					
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return notes_list;
	}
	public String insertResultDataClob(ArrayList notes_result_list, Connection con) throws Exception{
		String order_id = "";
		String result_data = "";
		String insert_status = "N";
		String update_sql = "select result_data from or_result_detail where  order_id=? for update";
		ResultSet rset_clob = null;
		PreparedStatement pstmt_clob = null;
		try
		{
			Iterator iterator = notes_result_list.iterator();
			while(iterator.hasNext()){
				order_id = (String)iterator.next();
				result_data = (String)iterator.next();
			}
			pstmt_clob = con.prepareStatement(update_sql);
			pstmt_clob.setString(1,order_id);
			rset_clob=pstmt_clob.executeQuery();
			if(result_data!=null)
			{
				if(rset_clob!=null) {
					while(rset_clob.next()) {
						java.sql.Clob clb = (java.sql.Clob) rset_clob.getClob("result_data"); 
						BufferedWriter bw = new BufferedWriter(clb.setCharacterStream(0));
						bw.write(result_data,0,result_data.length());
						bw.flush();
						bw.close();
						insert_status = "Y";
					}
				}
			}
			
		} catch ( Exception ee ) {
			ee.printStackTrace() ;
		} finally {
			try {
				if(rset_clob != null)
					rset_clob.close();
				if(pstmt_clob != null)
					pstmt_clob.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return insert_status;
	}
	public String updateEncHistoryNotes(ArrayList notes_result_list, Connection con) throws Exception {
		String update_status 				= "N";
		String order_id 					= "";
		String result_data 					= "";
		String specimen_no 					= "";
		String accession_num				= "";
		String modified_by_id  				= "";
		String modified_fac_id 				= "";
		String modified_at_ws_no 			= "";
		String get_accession_no_sql			= "SELECT order_type_code||'!'||order_id||'!'||report_srl_no||'!'||line_srl_no||'!'||srl_no ACCESSION_NUM from or_result_detail where LINKED_NOTE_ACCESSION_NUM = ?";
		String update_sql 					= "select hist_data from cr_encounter_detail_txt where  accession_num = ? for update";
		String update_crencntr_log			= "update cr_encounter_detail set modified_by_id = ?, modified_date = SYSDATE, modified_facility_id = ? where accession_num = ?";
		PreparedStatement pstmt_specno		= null;
		ResultSet rset_specno				= null;
		PreparedStatement pstmt_clob 		= null;
		ResultSet rset_clob 				= null;
		PreparedStatement pstmt_crencntr	= null;
		try{
			Iterator iterator = notes_result_list.iterator();
			while(iterator.hasNext()){
				order_id 			= (String)iterator.next();
				result_data 		= (String)iterator.next();
				accession_num		= (String)iterator.next();
				modified_by_id 		= (String)iterator.next();
				modified_fac_id 	= (String)iterator.next();
			}
			pstmt_specno = con.prepareStatement(get_accession_no_sql);
			pstmt_specno.setString(1, accession_num);
			rset_specno = pstmt_specno.executeQuery();
			while(rset_specno.next()){
				specimen_no = rset_specno.getString("ACCESSION_NUM");
			}
			pstmt_clob = con.prepareStatement(update_sql);
			pstmt_clob.setString(1,specimen_no); 
			rset_clob=pstmt_clob.executeQuery();
			if(result_data!=null)
			{
				if(rset_clob!=null) {
					while(rset_clob.next()) {
						java.sql.Clob clb = (java.sql.Clob) rset_clob.getClob("hist_data"); 
						BufferedWriter bw = new BufferedWriter(clb.setCharacterStream(0));
						bw.write(result_data,0,result_data.length());
						bw.flush();
						bw.close();
						update_status = "Y";
					}
				}
			}
			if("Y".equals(update_status)) {
				pstmt_crencntr = con.prepareStatement(update_crencntr_log);
				pstmt_crencntr.setString(1, modified_by_id);
				pstmt_crencntr.setString(2, modified_fac_id);
				pstmt_crencntr.setString(3, specimen_no);
				pstmt_crencntr.executeUpdate();
			}
		}catch(Exception ex){
			System.err.println(" Exception in ReviewNotesResponseServlet.java => " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if(rset_specno != null)
					rset_specno.close();
				if(pstmt_specno != null)
					pstmt_specno.close();
				if(rset_clob != null)
					rset_clob.close();
				if(pstmt_clob != null)
					pstmt_clob.close();
				if(pstmt_crencntr != null)
					pstmt_crencntr.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return update_status;
	}
	//JD-CRF-0199 [IN059747] - End
}

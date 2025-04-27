/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
---------------------------------------------------------------------------------------------------------
Date       	Edit History     	Name        	Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------
27/07/2016	IN059747			Karthi L											JD-CRF-0199
18/03/2020	IN071264		Nijitha S	    18/03/2020	Ramesh G	    GHL-CRF-0604
---------------------------------------------------------------------------------------------------------
*/
package eCA.ReviewNotes;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import java.util.*;
import javax.naming.*;
import java.io.*;
import javax.rmi.*;

import eCA.CAClinicalNotesAutoSaveBean;//IN071264
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="ReviewNotes"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ReviewNotes"
*	local-jndi-name="ReviewNotes"
*	impl-class-name="eCA.ReviewNotes.ReviewNotesManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.ReviewNotes.ReviewNotesLocal"
*	remote-class="eCA.ReviewNotes.ReviewNotesRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.ReviewNotes.ReviewNotesLocalHome"
*	remote-class="eCA.ReviewNotes.ReviewNotesHome"
*	generate= "local,remote"
*
*
*/


public class ReviewNotesManager implements SessionBean 
{
	SessionContext		ctx		=	null;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	
	public void setSessionContext( SessionContext context ) 
	{ 
		this.ctx=context;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertReviewNotes(
										java.util.Properties p,
										java.util.HashMap htReviewNotesProp
										) 
	{
		Connection			con		=	null;
		PreparedStatement	pstmt	=	null;
		StringBuffer		sb		=	null; 

		java.util.HashMap results = new java.util.HashMap() ;

		String	accessionnum		=	"",			clinicianid			=	"";
		String	login_user_id		=	"",			login_at_ws_no		=	"";
		String	final_values		=	"",			facility_id			=	"";
		String	temp				=	"",			locale              =   "";
		String  error1				=   "";
		String  requested_to		=	"" ;
		String  requested_by_id		=	"" ;

		StringBuffer	sql	= new StringBuffer();
		StringTokenizer st			=	null,	st1					=	null; 

		boolean	transaction_success	=	true;
		int		update_result		=	0;  
		
		String notes_amend_status 	= "N"; //JD-CRF-0199 [IN059747] 
		String order_id				= ""; //JD-CRF-0199 [IN059747]
		ArrayList notesResultList 	= null; //JD-CRF-0199 [IN059747]
		//IN071264 Starts
		String patient_id="";
		String encounter_id="";
		String note_type="";
		CAClinicalNotesAutoSaveBean autoSaveBean = new CAClinicalNotesAutoSaveBean();
		//IN071264 Ends
		try
		{
			con						=	ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			String amend_result_note_yn ="N";
			try
			{
				amend_result_note_yn = getAmendNoteParam(con); //JD-CRF-0199 [IN059747]
			}catch(Exception e){
				e.printStackTrace();
			}
			try
			{
				sb						=	new StringBuffer(""); 

				final_values			=	(String)	htReviewNotesProp.get	("final_values");
				facility_id				=	(String)	htReviewNotesProp.get	("facility_id");
				login_user_id			=	(String)	htReviewNotesProp.get	("login_user_id");
				login_at_ws_no			=	(String)	htReviewNotesProp.get	("login_at_ws_no");
				locale					=	(String)	htReviewNotesProp.get	("locale");

				st						=	new StringTokenizer(final_values,"#");
		
				while(st.hasMoreTokens())
				{
					temp				=	st.nextToken();
					st1					=	new StringTokenizer(temp,"~");
				
					while(st1.hasMoreTokens()) ////3  CN07 cer  GW  notr cer2  s
					{
						st1.nextToken();

						accessionnum		=	st1.nextToken();
						clinicianid			=	st1.nextToken();
						facility_id			=	st1.nextToken();
		
						st1.nextToken();
						requested_by_id		=	st1.nextToken();
						requested_to		= 	st1.nextToken();
						//IN071264 Starts
						patient_id			=	st1.nextToken();
						encounter_id		=	st1.nextToken();
						note_type			=	st1.nextToken();
						//IN071264 Ends
					
						sql.append( " Update ca_encntr_note_audit_log ");
						sql.append( " Set action_date_time = SYSDATE, ");
						sql.append( " action_status='CO',action_by_id= ? , ");
						sql.append( " modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, ");
						sql.append( " modified_facility_id = ? ");
						sql.append( " Where action_status = 'RQ' ");
						sql.append( " And action_type	in ('RV','RS','FS') ");
						//sql.append( " And action_by_id	= ? ");
						//Shaiju st
						if(requested_to.equals("S"))
						{
							sql.append( " AND ACTION_BY_GROUP_CODE = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id = ? ) ");
						}
						else
						sql.append( " And action_by_id	= ? ");
						
						//Shaiju en
						sql.append( " And facility_id	= ? ");
						sql.append( " And accession_num	= ? ");
						sql.append( " And request_by_id	= ? ");

						pstmt = con.prepareStatement( sql.toString() );
						
						pstmt.setString	(	1,	clinicianid	);
						pstmt.setString	(	2,	login_user_id	);
						pstmt.setString	(	3,	login_at_ws_no	);
						pstmt.setString	(	4,	facility_id		);
						pstmt.setString	(	5,	clinicianid		);
						pstmt.setString	(	6,	facility_id		);
						pstmt.setString	(	7,	accessionnum	);
						pstmt.setString	(	8,	requested_by_id	);

						update_result  =  pstmt.executeUpdate() ;
						pstmt.clearParameters();
					
						if(pstmt!=null) pstmt.close();

						if(update_result > 0 && requested_to.equals("P"))
							transaction_success = true;
						else
						{	
							CallableStatement csAuditLog = null;
							String strOutput = "N";

							try
							{
								csAuditLog = con.prepareCall("{call CA_NOTE_AUDIT_LOG(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

								csAuditLog.setString	(	1,	facility_id				);	
								csAuditLog.setString	(	2,	accessionnum			);
								csAuditLog.setString	(	3,	"SYSDATE"			);
								csAuditLog.setString	(	4,	"RV"				);
								csAuditLog.setString	(	5,	"CO"			);
								csAuditLog.setString	(	6,	clinicianid			);
								csAuditLog.setString	(	7,	login_user_id			);
								csAuditLog.setString	(	8,	login_at_ws_no			);
								csAuditLog.setString	(	9,	facility_id				);
								csAuditLog.setString	(	10,	login_user_id			);
								csAuditLog.setString	(	11,	login_at_ws_no			);
								csAuditLog.setString	(	12,	facility_id				);
								csAuditLog.setString	(	13,	null			);
								csAuditLog.setString	(	14,	null		);
								csAuditLog.setString	(	15,	null);
								csAuditLog.registerOutParameter	(	16,	Types.VARCHAR);
							
								csAuditLog.execute();

								strOutput = csAuditLog.getString(16);
								csAuditLog.clearParameters();
							}
							catch (Exception eAuditLog)
							{
								eAuditLog.printStackTrace();
								sb.append("<br>Exception@Inserting Audit Log @ Review Notes "+eAuditLog);
							}
							finally
							{
								try
								{	
									if (csAuditLog != null) csAuditLog.close();	
								}
								catch (Exception eee)	{}
							}

							if(strOutput.equals("N"))
							{
								transaction_success = false;
								break;
							}
						} 

						sql.setLength(0);
						//JD-CRF-0199 [IN059747] - Start
						if(transaction_success){
							if("Y".equals(amend_result_note_yn)){
								try{
									notesResultList = getNoteResultDataClob(accessionnum, facility_id, con);
								}catch(Exception e1){
									e1.printStackTrace();
								}
								Iterator iterator = notesResultList.iterator();
								while(iterator.hasNext()){
									order_id = (String)iterator.next();
								}
								System.out.println(" 224. ReviewNotesManager.java => order_id - " + order_id);
								if(order_id != null && order_id != "") {
									try{
										notes_amend_status = insertResultDataClob(notesResultList, con);
									}catch(Exception e1){
										e1.printStackTrace();
									}
									System.out.println(" 227. ReviewNotesManager.java => notes_amend_status - " + notes_amend_status);
									if("Y".equals(notes_amend_status)){
										notesResultList.add(accessionnum);
										notesResultList.add(login_user_id);
										notesResultList.add(facility_id);
										try{
											updateEncHistoryNotes(notesResultList, con);
										}catch(Exception e1){
											e1.printStackTrace();
										}
									}
								}	
							}	
						}
						//JD-CRF-0199 [IN059747] - End
						autoSaveBean.removedatafromsectionTemp(patient_id, encounter_id, note_type, login_user_id, con);//IN071264
					} 

					if(!transaction_success)
						break;
				} 

				if(transaction_success)
				{
					error1 = getMessage(locale,"RECORD_INSERTED","CA");
					con.commit();
				}
				else	
				{
					error1 = getMessage(locale,"FAILED_TRANSACTION","CA");
					con.rollback();
				}

				sb.append( error1 );
			} 
			catch(Exception e)
			{
				transaction_success=false;

				try
				{
					con.rollback();
				}
				catch(Exception ce)
				{
												
				}
			
				sb.append(e);
			}
			finally
			{
				htReviewNotesProp.clear();
			}
		} 
		catch(Exception ee)
		{
			ee.printStackTrace() ;
		}
		finally
		{
			if(con!=null) { ConnectionManager.returnConnection(con,p); }
		}

		results.put( "status", new Boolean(transaction_success) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
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
		//String modified_at_ws_no 			= ""; //CheckStyle
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
			System.out.println(" 426. ReviewNotesManager.java => " );
			while(iterator.hasNext()){
				order_id 			= (String)iterator.next();
				result_data 		= (String)iterator.next();
				accession_num		= (String)iterator.next();
				modified_by_id 		= (String)iterator.next();
				modified_fac_id 	= (String)iterator.next();
				System.out.println(" 432. ReviewNotesManager.java => specimen_no - " + order_id);
			}
			pstmt_specno = con.prepareStatement(get_accession_no_sql);
			pstmt_specno.setString(1, accession_num);
			rset_specno = pstmt_specno.executeQuery();
			while(rset_specno.next()){
				specimen_no = rset_specno.getString("ACCESSION_NUM");
			}
			System.out.println(" 440. ReviewNotesManager.java => specimen_no - " + specimen_no);
			System.out.println(" 441. ReviewNotesManager.java => result_data - " + result_data);
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


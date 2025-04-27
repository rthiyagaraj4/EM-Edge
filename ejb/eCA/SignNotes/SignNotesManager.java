/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
08/11/2016	IN060975		Raja S												MO-CRF-20114
18/03/2020	IN071264		Nijitha S	    18/03/2020	Ramesh G	    GHL-CRF-0604
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA.SignNotes;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import java.util.*;
import javax.naming.*;
import java.io.*;
import javax.rmi.*;

import eCA.CAClinicalNotesAutoSaveBean;	//IN071264
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="SignNotes"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="SignNotes"
*	local-jndi-name="SignNotes"
*	impl-class-name="eCA.SignNotes.SignNotesManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.SignNotes.SignNotesLocal"
*	remote-class="eCA.SignNotes.SignNotesRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.SignNotes.SignNotesLocalHome"
*	remote-class="eCA.SignNotes.SignNotesHome"
*	generate= "local,remote"
*
*
*/

public class SignNotesManager implements SessionBean 
{
	SessionContext		ctx			=	null;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) { this.ctx=context;}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertSignNotes(
									java.util.Properties p,
									java.util.HashMap htSignNotesProp
									) 
	{

		Connection			con				=	null;
		PreparedStatement	pstmt			=	null;
		PreparedStatement	privilage_stmt	=	null;

		ResultSet privilage_rs				=	null;
		ResultSet			rs				=	null;
		
		StringBuffer		sb				=	null;
		StringBuffer 		sql				=	new StringBuffer();		

		java.util.HashMap results	=	new java.util.HashMap() ;

		String	privilegetype		=	"",		accessionnum			=	"";
		String	requestbyid			=	"",		facility_id				=	"";
		String	forwardeduserid		=	"",		temp					=	"";
		String	l_event_status		=	"",		l_event_caption			=	"";
		String	l_authorized_by_id	=	"",		final_values			=	"";
		String	login_user_id		=	"",		login_at_ws_no			=	"";
		String  clinician_id		=	"",		qry_for_privilagetype	=	"";
		String  resp_id				=	"",		locale					=	"";
		String  error1				=	"";

		StringTokenizer st			=	null,	st1					=	null; 

		boolean	transaction_success	=	true,	result				=	true ;
		int		update_result		=	0;  
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
			
			try
			{
				sb						=	new StringBuffer(""); 

				final_values			=	(String)	htSignNotesProp.get	("final_values");
				facility_id				=	(String)	htSignNotesProp.get	("facility_id");
				login_user_id			=	(String)	htSignNotesProp.get	("login_user_id");
				login_at_ws_no			=	(String)	htSignNotesProp.get	("login_at_ws_no");
				clinician_id			=	(String)	htSignNotesProp.get	("ca_practitioner_id");
				resp_id			        =	(String)	htSignNotesProp.get	("respid");
				locale			        =	(String)	htSignNotesProp.get	("locale");

				transaction_success		=	true;

				st						=	new StringTokenizer(final_values,"#");
				
				while(st.hasMoreTokens())
				{
					temp				=	st.nextToken();
					st1					=	new StringTokenizer(temp,"~");
				
					while(st1.hasMoreTokens())
					{
						privilegetype		=	st1.nextToken();
						accessionnum		=	st1.nextToken();
						requestbyid			=	st1.nextToken();
						facility_id			=	st1.nextToken();

						st1.nextToken();
						//IN071264 Starts
						patient_id			=	st1.nextToken();
						encounter_id		=	st1.nextToken();
						note_type			=	st1.nextToken();
						//IN071264 Ends
						forwardeduserid		=	st1.nextToken();
						l_authorized_by_id	=	clinician_id;
						
						//if(privilegetype == null || privilegetype.equals(""))  //IN054161
						if(privilegetype == null || privilegetype.equals("") || privilegetype.equals("null")) //IN054161
						{
							//qry_for_privilagetype = "select privilege_type from ca_note_type_for_resp where resp_id = ? and note_type = (select note_type from ca_encntr_note where facility_id=? and accession_num=? ) ";
							qry_for_privilagetype = "select max(privilege_type) from  ca_note_type_for_resp where resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and note_type = (select note_type from ca_encntr_note where facility_id=? and accession_num=?) and privilege_type!='5' ";
							privilage_stmt = con.prepareStatement(qry_for_privilagetype);
							
							privilage_stmt.setString(1,login_user_id);
							privilage_stmt.setString(2,facility_id);
							privilage_stmt.setString(3,accessionnum);
							
							privilage_rs = privilage_stmt.executeQuery();

							if(privilage_rs.next())
								privilegetype = privilage_rs.getString(1)==null?"1":privilage_rs.getString(1);
							
							if(privilage_rs!=null)
								privilage_rs.close();
							if(privilage_stmt!=null)
								privilage_stmt.close();
						}

						if(privilegetype.equals("2") || privilegetype.equals("3") || privilegetype.equals("4") || privilegetype.equals("1"))
						{
							// update ca_encntr_note_audit_log
							if(sql.length() > 0) sql.delete(0,sql.length());

							sql.append(" update ca_encntr_note_audit_log ");
							sql.append(" set action_status = 'CO', action_date_time = SYSDATE, ");
							sql.append(" modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, ");
							sql.append(" modified_facility_id	= ?, ");
							sql.append(" PRIVILEGE_TYPE			= ?  ");
							sql.append(" where facility_id		= ? ");
							sql.append(" and accession_num		= ? ");
							sql.append(" and action_by_id		= ? ");
							sql.append(" and action_type		= 'SN' ");
														
							pstmt	=	con.prepareStatement( sql.toString() );
							
							pstmt.setString	(	1,	login_user_id	);
							pstmt.setString	(	2,	login_at_ws_no	);
							pstmt.setString	(	3,	facility_id		);
							pstmt.setString	(	4,	privilegetype		);
							pstmt.setString	(	5,	facility_id		);
							pstmt.setString	(	6,	accessionnum	);
							pstmt.setString	(	7,	requestbyid		);
							

							update_result  =  pstmt.executeUpdate() ;
							
							if(pstmt!=null) pstmt.close();

							if(update_result > 0 )
								transaction_success	= true;
							else
								transaction_success = false;
							//IN060975 Starts
							if(transaction_success)
							{
								CallableStatement	cspreAmend	=	null; 
								String		strOutput1				=	"N";
								try
								{
									cspreAmend					=	con.prepareCall("{call CA_NOTE_AUDIT_PREAMEND(?,?,?,?,?)}");
									cspreAmend.setString (1,facility_id);
									cspreAmend.setString (2,accessionnum);
									cspreAmend.setString (3,"");
									cspreAmend.registerOutParameter (4,Types.VARCHAR);
									cspreAmend.setString (5,"SN");
									cspreAmend.execute();
									strOutput1 = cspreAmend.getString(4);
								}
								catch (Exception ee2)
								{
									ee2.printStackTrace();
									sb.append("<br>Exception@update preimage - 210: "+ee2);
								}
								finally
								{
									if(cspreAmend!=null) cspreAmend.close();
								}
								if(strOutput1.equals("Y"))
									transaction_success	= true;
								else
									transaction_success = false;
							}
							//IN060975 Ends
							
						}

						if(privilegetype.equals("2") || privilegetype.equals("1") )
						{
							if (privilegetype.equals("1"))
							{
								l_event_status  = "2";
								l_event_caption = "Transcibed";

								ResultSet rsSqlUsrID=null;
								String SqlUsrID = "select PERFORMED_BY_ID from ca_encntr_note where facility_id = ? and accession_num = ?";
								
								try
								{
									pstmt = con.prepareStatement( SqlUsrID );
									pstmt.setString	(	1,	facility_id		);
									pstmt.setString	(	2,	accessionnum	);
									rsSqlUsrID = pstmt.executeQuery() ;

									if(rsSqlUsrID.next())
									{
										forwardeduserid = rsSqlUsrID.getString("PERFORMED_BY_ID");
										if(forwardeduserid == null || forwardeduserid.equals("null")) forwardeduserid = "";
									}

									if(rsSqlUsrID!=null) rsSqlUsrID.close();
									if(pstmt!=null) pstmt.close();

								}
								catch(Exception expUsrID)
								{
									sb.append("Err in SqlUsrID :"+expUsrID);
								}
							}
							else if (privilegetype.equals("2"))
							{
								l_event_status = "3";
								l_event_caption = "Unauthorized";
							}
							
						if(sql.length() > 0) sql.delete(0,sql.length());

						CallableStatement csAuditLog = null;
						String strOutput = "N";

						try
						{
							csAuditLog = con.prepareCall("{call CA_NOTE_AUDIT_LOG(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

							csAuditLog.setString	(	1,	facility_id				);	
							csAuditLog.setString	(	2,	accessionnum			);
							csAuditLog.setString	(	3,	null			);
							csAuditLog.setString	(	4,	"SN"				);
							csAuditLog.setString	(	5,	"RQ"			);
							csAuditLog.setString	(	6,	forwardeduserid			);
							csAuditLog.setString	(	7,	login_user_id			);
							csAuditLog.setString	(	8,	login_at_ws_no			);
							csAuditLog.setString	(	9,	facility_id				);
							csAuditLog.setString	(	10,	login_user_id			);
							csAuditLog.setString	(	11,	login_at_ws_no			);
							csAuditLog.setString	(	12,	facility_id				);
							csAuditLog.setString	(	13,	requestbyid			);
							csAuditLog.setString	(	14,	"SYSDATE"		);
							csAuditLog.setString	(	15,	"");
							csAuditLog.registerOutParameter	(	16,	Types.VARCHAR);
							
							csAuditLog.execute();

							strOutput = csAuditLog.getString(16);
							csAuditLog.clearParameters();
						}
						catch (Exception eAuditLog)
						{
							eAuditLog.printStackTrace();
							sb.append("<br>Exception@Inserting Audit Log @ sign Notes "+eAuditLog);
						}
						finally
						{
							try
							{	
								if (csAuditLog != null) csAuditLog.close();	
							}
							catch (Exception eee)	{}
						}

						if(strOutput.equals("Y"))
							transaction_success = true;
						else
							transaction_success = false;
					}
					else if(privilegetype.equals("3") || privilegetype.equals("4"))
					{
						l_event_status = "4";
						l_event_caption = "Authorized";

					//added for log

						if(update_result==0)
						{
						CallableStatement csAuditLog1 = null;
						String strOutput = "N";

						try
						{
							csAuditLog1 = con.prepareCall("{call CA_NOTE_AUDIT_LOG(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

							csAuditLog1.setString	(	1,	facility_id				);	
							csAuditLog1.setString	(	2,	accessionnum			);
							csAuditLog1.setString	(	3,	"SYSDATE"			);
							csAuditLog1.setString	(	4,	"SN"				);
							csAuditLog1.setString	(	5,	"CO"			);
							csAuditLog1.setString	(	6,	clinician_id			);
							csAuditLog1.setString	(	7,	login_user_id			);
							csAuditLog1.setString	(	8,	login_at_ws_no			);
							csAuditLog1.setString	(	9,	facility_id				);
							csAuditLog1.setString	(	10,	login_user_id			);
							csAuditLog1.setString	(	11,	login_at_ws_no			);
							csAuditLog1.setString	(	12,	facility_id				);
							csAuditLog1.setString	(	13,	null			);
							csAuditLog1.setString	(	14,	null		);
							csAuditLog1.setString	(	15,	"");
							csAuditLog1.registerOutParameter	(	16,	Types.VARCHAR);
							csAuditLog1.setString	(	17,	privilegetype			);
							
							csAuditLog1.execute();

							strOutput = csAuditLog1.getString(16);
							csAuditLog1.clearParameters();
						}
						catch (Exception eAuditLog)
						{
							eAuditLog.printStackTrace();
							sb.append("<br>Exception@Inserting Audit Log @ sign Notes "+eAuditLog);
						}
						finally
						{
							try
							{	
								if (csAuditLog1 != null) csAuditLog1.close();	
							}
							catch (Exception eee)	{}
						}

						if(strOutput.equals("Y"))
							transaction_success = true;
						else
							transaction_success = false;


						}

					//log change ends.

					}
					if(transaction_success)
					{
					// update ca_encntr_note
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append( " update ca_encntr_note ");
					sql.append(" set authorized_by_id = ? ");
					sql.append(" , authorized_date_time = sysdate ");
					sql.append(" , event_status_caption = ? ");
					sql.append(" , event_status = ?, modified_by_id = ? ");
					sql.append(" , modified_date = sysdate, modified_at_ws_no = ? ");
					sql.append(" , modified_facility_id = ? ");
					sql.append(" where facility_id = ? ");
					sql.append(" and accession_num = ? ");
					//sb.append(sql);
					pstmt	=	con.prepareStatement ( sql.toString() );

					pstmt.setString	(	1,	l_authorized_by_id	);
					pstmt.setString	(	2,	l_event_caption		);
					pstmt.setString	(	3,	l_event_status		);
					pstmt.setString	(	4,	login_user_id		);
					pstmt.setString	(	5,	login_at_ws_no		);
					pstmt.setString	(	6,	facility_id			);
					pstmt.setString	(	7,	facility_id			);
					pstmt.setString	(	8,	accessionnum		);

					update_result  =  pstmt.executeUpdate() ;

					if(pstmt!=null) pstmt.close();

					if(update_result > 0 )
						transaction_success = true;
					else
						transaction_success = false;
					}
					autoSaveBean.removedatafromsectionTemp(patient_id, encounter_id, note_type, login_user_id, con);//IN071264
				}
			}
			
			if(rs!=null)	 rs.close();
			if(pstmt!=null) pstmt.close();
		}
		catch(Exception e)
		{
			transaction_success=false;

			try
			{
				con.rollback();
			}
			catch(Exception ce){}
			sb.append(e);
		}
		finally
		{
			htSignNotesProp.clear();
		}
		try
		{
			if(transaction_success)
			{
				error1 = getMessage(locale,"RECORD_INSERTED","CA");
				sb.append( error1 );
				con.commit();
				result=true;
			}
			else	
			{
				con.rollback();
				result=false;
			}
		}
		catch(Exception e)
		{
			error1 = getMessage(locale,"FAILED_TRANSACTION","CA");
			
			sb.append(error1);
			
			try
			{
				con.rollback();
			}
			catch(Exception ce){}
		}
		finally 
		{
			try 
			{
				
				if(con!=null) { ConnectionManager.returnConnection(con,p); }
			}
			catch (Exception e) 
			{
				sb.append("Close stmts"+e);
			}
		}//FINALLY
		}
		catch(Exception ee)
		{
			ee.printStackTrace() ;
		}
		finally
		{
			if(con!=null) { ConnectionManager.returnConnection(con,p); }
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	} // end insertSignNotes

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}

}

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/ 
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           created
18/01/2013		IN037372		Ramesh G		Oracle 11g Weblogic compilation.
06/03/2013		IN038280		Nijitha S		System is not displaying the Facility ID in the Reference number generated for the note type with uploaded file. 
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name			Rev.Date   		Rev.By 			Description
--------------------------------------------------------------------------------------------------------------------------------
19/05/2020		IN070345		Ramesh Goli		19/05/2020		Ramesh G		MO-CRF-20147.1
--------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import com.ehis.util.BundleMessage;
import org.apache.commons.fileupload.*;

import com.ehis.persist.PersistenceHelper;
import eCA.RecClinicalNotesMultiFileUploadBean.NoteDoc;


public class RecClinicalNotesFileUploadSectionsServlet extends HttpServlet
{
	HttpSession			session = null;
	java.io.PrintWriter  out       = null;
	java.util.Properties p          = null;

			Connection con									=	null;
			PreparedStatement pstAccNum		    =	null;
			PreparedStatement pstInsEnctrNote		=	null;
			PreparedStatement pstUpdtEnctrNote		=	null;
			PreparedStatement pstEnctrDtlObj		=	null;
			PreparedStatement pstEnctrDtlBlobObj		=	null;
			PreparedStatement pstEnctrNoteAudLog		=	null;
			PreparedStatement pstUpdtEnctrDtlObj		=	null;

			ResultSet		rsAccNum 					=	null;
			ResultSet		rsEnctrDtlObj					=	null;
			ResultSet		rsInsEnctrNote 				=	null;
			ResultSet		rsUpdtEnctrNote 			=	null;
			ResultSet		rsEnctrDtlBlobObj			=	null;
			ResultSet		rsEnctrNoteAudLog		=	null;
			ResultSet		rsUpdtEnctrDtlObj		=	null;

			java.util.HashMap	results		= new java.util.HashMap();

			String facilityId						= "";
			String client_ip_address			= "";
			String addedById					= "";
			String modifiedById				= "";
			String addedFacilityId				= "";
			String modifiedFacilityId			= "";
			String addedAtWorkstation	= "";
			String modifiedAtWorkstation	= "";

			String login_user_id			= "", clinician_id = "", clinician_name ="";
			String resp_name				= "",resp_id = "" ;

			String operation_mode				= "";
			String accession_num				= "";
			String performed_by_id				= "";
			String privilege_type					= "";
			String function_id						= "";
			String field_ref							= "";
			String window_close					= "";
			String patient_id						= "";
			String episode_type					= "";
			String encounter_id					= "";
			String patient_class					= "";
			String event_type_caption			= "";
			String note_type						= "";
			String service_code					= "";
			String event_class						= "";
			String note_type_security_level = "";
			String event_date_caption			= "";
			String event_date_time				= "";
			String event_perf_by_caption	= "";
			String event_title_caption			= "";
			String event_title_desc				= "";
			String note_content					= "";
			String event_auth_by_caption	= "";
			String authorized_by_id				= "";
			String authorized_date_time		= "";
			String event_status_caption		= "";
			String event_status					= "";
			String encntr_date						= "";
			String contr_mod_accession_num = "";
			String serv_facl_spec_yn			= "";
			String visit_adm_date				= "";
			String amendment_type			= "";
			String appl_task_id					= "";
			String security_level					= "";
			String login_at_ws_no				= "";
			String remarks							= "";
			String forwarded_clinician_id		= "";
			String uploadremarks					= "";
			String change_file_ref				= "";
			String doc_type							= "";
			String strOutput				=	"N" ;



			int record_count						= 0;
			int colIndex								= 0;
			int insert_result							= 0;
			int insert_blob_result					= 0;
			int update_blob_result				= 0;
			int blob_doc_size						= 0;
			int size 						=0;
			int delete_result = 0;

			StringTokenizer str_doc_type = null;

			String error_msg = "";
			String name							= "";
			String value							= "";
			DiskFileUpload upload			=	null;
			List items								= null;
			Iterator iter							= null;
			java.io.InputStream instream            = null;
			FileItem  fileItem         = null;
			String docName ="";
			String docType ="";
			String called_from = "";
			long docSize = 0;

			boolean isMultipart    = false;
			FileItem Item				= null;

			//StringBuffer docs	= new StringBuffer();
			StringBuffer strbuf		= new StringBuffer();
			boolean commit_flag					=	true;
			boolean res								= false;

			MessageManager		msgmngr						=	null;
			java.util.Hashtable		message						=	null;
			String locale							= "";

		public void init(ServletConfig cfg) throws ServletException
		{
			super.init(cfg);
		}

		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
		{
			out = response.getWriter();

			try
			{
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");

				session   = request.getSession(false);

				p						=(Properties) session.getValue("jdbc");
				locale = (String) p.getProperty("LOCALE");
				facilityId = (String) session.getValue( "facility_id" ) ;
				client_ip_address = this.p.getProperty("client_ip_address");
				addedById           = p.getProperty( "login_user" ) ;
				modifiedById					 = addedById ;
				addedFacilityId				 =facilityId;
				modifiedFacilityId			 = addedFacilityId ;
				addedAtWorkstation	     =client_ip_address;
				modifiedAtWorkstation   = addedAtWorkstation ;
				login_at_ws_no				=	request.getRemoteAddr();

				login_user_id		=	(String)		session.getValue("login_user");
				resp_name		=	(String)		session.getValue("resp_name");
				clinician_id			=	(String)		session.getValue("ca_practitioner_id");
				clinician_name	=	(String)  	session.getValue("practitioner_name");
				resp_id				=	(String)		session.getValue("responsibility_id");

				con=ConnectionManager.getConnection(request);

				try
				{
					isMultipart   =  FileUpload.isMultipartContent(request);
					if(isMultipart)
					{
						upload = new DiskFileUpload();
	//					upload.setSizeMax(1024*1024*1024*10);

						items = upload.parseRequest(request);
						iter = items.iterator();
						while(iter.hasNext()){
							Item = (FileItem) iter.next();

							if(Item.isFormField()){

								String name = Item.getFieldName();
								String value = Item.getString();

								if(name.equals("operation_mode"))
									operation_mode	= checkForNull(value);
								else
								if(name.equals("accession_num"))
									accession_num	= checkForNull(value);
								else
								if(name.equals("performed_by_id"))
									performed_by_id	= checkForNull(value);
								else
								if(name.equals("privilege_type"))
									privilege_type	= checkForNull(value);
								else
								if(name.equals("function_id"))
									function_id	= checkForNull(value);
								else
								if(name.equals("field_ref"))
									field_ref	= checkForNull(value);
								else
								if(name.equals("window_close"))
									window_close	= checkForNull(value);
								else
								if(name.equals("patient_id"))
									patient_id	= checkForNull(value);
								else
								if(name.equals("episode_type"))
									episode_type	= checkForNull(value);
								else
								if(name.equals("encounter_id"))
									encounter_id	= checkForNull(value);
								else
								if(name.equals("patient_class"))
									patient_class	= checkForNull(value);
								else
								if(name.equals("event_type_caption"))
									event_type_caption	= checkForNull(value);
								else
								if(name.equals("note_type"))
									note_type	= checkForNull(value);
								else
								if(name.equals("service_code"))
									service_code	= checkForNull(value);
								else
								if(name.equals("event_class"))
									event_class	= checkForNull(value);
								else
								if(name.equals("note_type_security_level"))
									note_type_security_level	= checkForNull(value);
								else
								if(name.equals("event_date_caption"))
									event_date_caption	= checkForNull(value);
								else
								if(name.equals("event_date_time"))
								{
									event_date_time	= checkForNull(value);
									event_date_time = com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM",locale,"en");
								}
								else
								if(name.equals("event_perf_by_caption"))
									event_perf_by_caption	= checkForNull(value);
								else
								if(name.equals("event_title_caption"))
									event_title_caption	= checkForNull(value);
								else
								if(name.equals("event_title_desc"))
									event_title_desc	= checkForNull(value);
								else
								if(name.equals("note_content"))
									note_content	= checkForNull(value);
								else
								if(name.equals("event_auth_by_caption"))
									event_title_desc	= checkForNull(value);
								else
								if(name.equals("authorized_by_id"))
									authorized_by_id	= checkForNull(value);
								else
								if(name.equals("authorized_date_time"))
									authorized_date_time	= checkForNull(value);
								else
								if(name.equals("authorized_by_id"))
									authorized_by_id	= checkForNull(value);
								else
								if(name.equals("event_status_caption"))
									event_status_caption	= checkForNull(value);
								else
								if(name.equals("authorized_date_time"))
									authorized_date_time	= checkForNull(value);
								else
								if(name.equals("event_status"))
									event_status	= checkForNull(value);
								else
								if(name.equals("encntr_date"))
									encntr_date	= checkForNull(value);
								else
								if(name.equals("visit_adm_date"))
									visit_adm_date	= checkForNull(value);
								else
								if(name.equals("amendment_type"))
									amendment_type	= checkForNull(value);
								else
								if(name.equals("contr_mod_accession_num"))
									contr_mod_accession_num = checkForNull(value);
								else
								if(name.equals("forwarded_clinician_id"))
									forwarded_clinician_id = checkForNull(value);
								else
								if(name.equals("uploadremarks"))
									uploadremarks = checkForNull(value);
								else
								if(name.equals("change_file_ref"))
									change_file_ref = checkForNull(value);
								else
								if(name.equals("doc_type"))
									doc_type = checkForNull(value);
								else if (name.equals("called_from"))
									called_from = checkForNull(value);
								
								name=null;
								value=null;
							}
							else
							{
								fileItem = Item;
								docName = Item.getName();
								docType = Item.getContentType();
								docSize = Item.getSize();

								//instream = Item.getInputStream();
							}
						}
					}// end of multipart req
					else
					{
						operation_mode = checkForNull(request.getParameter("operation_mode"));
						accession_num = checkForNull(request.getParameter("accession_num"));
					}

					
				//	int docs	 =	 (int)docSize;
				}
				catch(Exception e)
				{
						e.printStackTrace();
						
				}
					NotesFileUpload(request,response);


				// added on 3/14/2006
				upload	=	null;
				items	= null;
				iter	= null;
				instream  = null;

				fileItem.delete();
				fileItem = null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//out.println("Exception @ Servlet - main:2"+e.toString());//common-icn-0181
		}
		finally
		{
			out = null;
			if(con!=null)	ConnectionManager.returnConnection(con, request);
			con = null;
		}

	}

	public void NotesFileUpload(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, java.io.IOException
	{
			String error_value	= "" ;
			StringBuffer error	= new StringBuffer();
			java.util.HashMap	uploadresults		= new java.util.HashMap();
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			//String note_linked_file_limit_unit = "";//Common-ICN-0092  
		//	int note_linked_file_limit = 0;//Common-ICN-0092  
		//	double paramsize = 0;//Common-ICN-0092  
			boolean record_status = false;
			ArrayList doc_arr = new ArrayList();

		try
		{

			if(!docName.equals(""))
			{
				try
				{
					String qry_doc_type = "select distinct OBJ_TYPE from ca_appl_linked_obj_type where APPLICABLE_YN = 'Y'";
					pstmt = con.prepareStatement(qry_doc_type);
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						doc_arr.add(rs.getString("OBJ_TYPE"));
					}

					for(int i =0; i<doc_arr.size(); i++)
					{
							if(docType.equals(doc_arr.get(i)))
							{
								record_status = true;
								break;
							}
							else
								record_status = false;
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					record_status = false;
					error.append("<br>Exception @ RecClinicalNotesSectionsFileUpload while checking for the doc type"+e);
				}
				finally
				{
					if(rs!=null)
						rs.close();
					if(pstmt!=null)
						pstmt.close();
				}

				if(record_status == false)
				{
					record_status = false;
					error_value	= "0" ;
					error.append(getMessage(locale,"FILE_NOT_SUPPORTED","CA"));
				}
			}


			if((docName.equals("") && record_status== false) || (!docName.equals("") && record_status== true))
			{
				/* 
				try
				{
					String docsize_note_param = "select NOTE_LINKED_FILE_LIMIT , NOTE_LINKED_FILE_LIMIT_UNIT from CA_NOTE_PARAM";
					pstmt = con.prepareStatement(docsize_note_param);
					rs = pstmt.executeQuery();
	
					while(rs.next())
					{
						note_linked_file_limit = rs.getInt("note_linked_file_limit");
						note_linked_file_limit_unit = rs.getString("note_linked_file_limit_unit");
					}
	
					if(note_linked_file_limit_unit.equalsIgnoreCase("K") || note_linked_file_limit_unit.equalsIgnoreCase("KB"))
					{
							paramsize = note_linked_file_limit * 1024;
					}
					if(note_linked_file_limit_unit.equalsIgnoreCase("M") || note_linked_file_limit_unit.equalsIgnoreCase("MB"))
					{
							paramsize = note_linked_file_limit *1024 *1000;
					}
					if(note_linked_file_limit_unit.equalsIgnoreCase("G") || note_linked_file_limit_unit.equalsIgnoreCase("GB"))
					{
							paramsize = note_linked_file_limit *1024 *1000 * 1000;
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					record_status = false;
					error.append("<br>Exception @ RecClinicalNotesSectionsFileUpload"+e);
				}
				finally
				{
					if(rs!=null)
						rs.close();
					if(pstmt!=null)
						pstmt.close();
	
				}
				*/
	
				/*if(docSize > paramsize || docSize > ((1024 *1000 * 1000) * 2))
				{
					record_status = false;
					error_value	= "0" ;
					error.append(getMessage(locale,"FILE_SIZE_NOT_SUPPORTED","CA"));
	
				}
				else
				{*/

				if(operation_mode.equals("Record") &&  accession_num.equals(""))
				{
					uploadresults =	recordNoteSectionsFileUpload(request,response);
				}
				else if(operation_mode.equals("Record") && (!accession_num.equals("")))
				{
					uploadresults = UpdateRecClinicalNotesFileUpload(request,response);
				}

				record_status		=	((Boolean)uploadresults.get("status")).booleanValue();
				accession_num = (String)uploadresults.get("accession_num");

				if(record_status)
				{
					error_value			= "1" ;
					error.append(getMessage(locale,"RECORD_INSERTED","CA"));
					//error.append("APP-SM0002 Operation Completed Successfully ....");
					//error.append(uploadresults.get("error"));
				}
				else
				{
					error_value	= "0" ;
					error.append(getMessage(locale,"FAILED_TRANSACTION","CA"));
					//error.append("APP-SM0000 Transaction Failes ....");
					error.append(uploadresults.get("error"));
				}
				if(uploadresults!=null)
					uploadresults.clear();
			//}

		}
		//response.sendRedirect("../eCA/jsp/RecClinicalNotesFileUploadSectionsError.jsp?err_num=" + java.net.URLEncoder.encode( error.toString(),"UTF-8" ) +"&err_value="+error_value+"&operation_mode="+operation_mode+"&accession_num="+accession_num);
		response.sendRedirect("../eCA/jsp/RecClinicalNotesFileUploadSectionsError.jsp?err_num=" + java.net.URLEncoder.encode( error.toString(),"UTF-8" ) +"&err_value="+error_value+"&operation_mode="+operation_mode+"&accession_num="+accession_num+"&called_from="+called_from);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("Exception @ NotesFileUpload "+e.toString());
		}

	}

public java.util.HashMap recordNoteSectionsFileUpload(HttpServletRequest request, HttpServletResponse response ) throws FileUploadException, java.io.IOException
{
		//int docs	 =	 (int)docSize;
		MessageManager		msgmngr						=	null;
		java.util.Hashtable		message						=	null;
		//StringBuffer strbuf		=	new StringBuffer();
		java.util.HashMap	results		= new java.util.HashMap();
		java.util.HashMap<String, String>	resultsDetails		= new java.util.HashMap<String, String>(); //IN070345
		commit_flag = true;
		try
		{
			strbuf.delete(0,strbuf.length());
			msgmngr							=	new MessageManager();

			if(operation_mode.equals("Record"))
			{
				authorized_by_id		=	"";
				authorized_date_time	=	"";
				event_status			=	"1";
			}

			con.setAutoCommit(false);
			try
			{
				if(accession_num.equals(""))
				{
				//IN038280  Start.
				String includeFacilityAccessioNum="N";
				try
				{
					String query_logic_accession_num = "select 'Y' from OR_PAT_APPLICABLE_FUNC where function_id = 'MULTI_FACILITY_ORDER_ID'";
					pstAccNum	=	con.prepareStatement(query_logic_accession_num);
					rsAccNum		=	pstAccNum.executeQuery();

					if(rsAccNum.next())
						includeFacilityAccessioNum	=	rsAccNum.getString(1);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					commit_flag = false;
					strbuf.append("<br>Exception@EJB : Generating accession Number "+e);
				}
				finally
				{
					if(rsAccNum!=null) rsAccNum.close();
					if(pstAccNum!=null)	pstAccNum.close();
				}
					try
					{
						//String query_accession_num =  "select 'CN'||to_char(sysdate,'YY')||'$'||lpad(ca_note_type_seq.nextval,16,'0') accession_num from dual ";
						String query_accession_num="";
					if("N".equals(includeFacilityAccessioNum))
						query_accession_num =  "select 'CN'||to_char(sysdate,'YY')||'$'||lpad(ca_note_type_seq.nextval,16,'0') accession_num from dual ";
					else if("Y".equals(includeFacilityAccessioNum))
						query_accession_num =  "SELECT 'CN'||'"+facilityId+"'||to_char(sysdate,'YY')||'$'||lpad(ca_note_type_seq.nextval,14,'0') accession_num FROM DUAL ";
				//IN038280 End.
						pstAccNum	=	con.prepareStatement(query_accession_num);
						rsAccNum		=	pstAccNum.executeQuery();


						if(rsAccNum.next())
							accession_num	=	rsAccNum.getString("accession_num");
					}
					catch(Exception e)
					{
							e.printStackTrace();
							commit_flag = false;
							strbuf.append("<br>Exception @ RecClinicalNotesFileUploadSectionsServlet.java : Getting accession Number "+e);
					}
					finally
					{
						if(rsAccNum!=null)
							rsAccNum.close();
						if(pstAccNum!=null)
							pstAccNum.close();
					}
					try
					{
						String insert_ca_encntr_note = "";

						if(authorized_date_time.equals("SYSDATE"))
						{
							insert_ca_encntr_note = "insert into ca_encntr_note ( facility_id, accession_num, patient_id, patient_class, encounter_id, event_type_caption, note_type, service_code, event_class, security_level, event_date_caption, event_date_time, event_perf_by_caption, performed_by_id, event_title_caption, event_title_desc, note_content, event_auth_by_caption, authorized_by_id, authorized_date_time, event_status_caption, event_status,last_amended_by_id, last_amended_date_time, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, encntr_date,contr_mod_accession_num ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/yyyy HH24:MI'), ?, ?, ?, ?, empty_clob(), ?, ?, sysdate, ?, ?, ?,SYSDATE,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, to_date(?,'dd/mm/yyyy HH24:MI'),? ) ";

						}
						else
						{
							insert_ca_encntr_note = "insert into ca_encntr_note ( facility_id, accession_num, patient_id, patient_class, encounter_id, event_type_caption, note_type, service_code, event_class, security_level, event_date_caption, event_date_time, event_perf_by_caption, performed_by_id, event_title_caption, event_title_desc, note_content, event_auth_by_caption, authorized_by_id, authorized_date_time, event_status_caption, event_status,last_amended_by_id, last_amended_date_time, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, encntr_date,contr_mod_accession_num ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/yyyy HH24:MI'), ?, ?, ?, ?, empty_clob(), ?, ?, to_date(?,'dd/mm/yyyy HH24:MI'), ?, ?, ?,SYSDATE,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, to_date(?,'dd/mm/yyyy HH24:MI'),? ) ";

						}

						colIndex	=	0;

						pstInsEnctrNote		=	con.prepareStatement(insert_ca_encntr_note);

						pstInsEnctrNote.setString	(  ++colIndex,	facilityId			);
						pstInsEnctrNote.setString	(  ++colIndex,	accession_num	);
						pstInsEnctrNote.setString	(  ++colIndex,	patient_id			);
						pstInsEnctrNote.setString	(  ++colIndex,	patient_class		);

						if(encounter_id.equals(""))
							pstInsEnctrNote.setNull	(  ++colIndex,	Types.NUMERIC	);
						else
							pstInsEnctrNote.setLong	(  ++colIndex,	Long.parseLong(encounter_id)	);

						pstInsEnctrNote.setString	(  ++colIndex,	event_type_caption		);
						pstInsEnctrNote.setString	(  ++colIndex,	note_type				);
						pstInsEnctrNote.setString	(  ++colIndex,	service_code			);
						pstInsEnctrNote.setString	(  ++colIndex,	event_class				);
						pstInsEnctrNote.setString	(  ++colIndex,	security_level			);
						pstInsEnctrNote.setString	(  ++colIndex,	event_date_caption		);
						pstInsEnctrNote.setString	(  ++colIndex,	event_date_time			);
						pstInsEnctrNote.setString	(  ++colIndex,	event_perf_by_caption	);
						pstInsEnctrNote.setString	(  ++colIndex,	performed_by_id			);
						pstInsEnctrNote.setString	(  ++colIndex,	event_title_caption		);
						pstInsEnctrNote.setString	(  ++colIndex,	event_title_desc		);
						pstInsEnctrNote.setString	(  ++colIndex,	event_auth_by_caption	);

						if(authorized_by_id.equals(""))
							pstInsEnctrNote.setNull	(++colIndex,	Types.VARCHAR		);
						else
							pstInsEnctrNote.setString	( ++colIndex,	authorized_by_id	);

						if(!authorized_date_time.equals("SYSDATE"))
						{
							pstInsEnctrNote.setString	( ++colIndex,	authorized_date_time	);
						}

						pstInsEnctrNote.setString	( ++colIndex,	event_status_caption	);
						pstInsEnctrNote.setString	( ++colIndex,	event_status			);

						if(authorized_by_id.equals(""))
							pstInsEnctrNote.setNull	(++colIndex,	Types.VARCHAR		);
						else
							pstInsEnctrNote.setString	( ++colIndex,	authorized_by_id	);

						pstInsEnctrNote.setString	( ++colIndex,	login_user_id			);
						pstInsEnctrNote.setString	( ++colIndex,	login_at_ws_no			);
						pstInsEnctrNote.setString	( ++colIndex,	facilityId				);
						pstInsEnctrNote.setString	( ++colIndex,	login_user_id			);
						pstInsEnctrNote.setString	( ++colIndex,	login_at_ws_no			);
						pstInsEnctrNote.setString	( ++colIndex,	facilityId				);
						pstInsEnctrNote.setString	( ++colIndex,	encntr_date				);
						pstInsEnctrNote.setString	( ++colIndex,	contr_mod_accession_num	);

						insert_result = pstInsEnctrNote.executeUpdate();

						if( insert_result <= 0 )
							commit_flag = false;
						else
						{
							CallableStatement csDocref = con.prepareCall("{call CA_GET_NOTE_DOC_REF(?)}");
							csDocref.setString(1,accession_num);
							csDocref.execute();
							strOutput = insertAuditLog(con,facilityId,accession_num,"SYSDATE","PR","CO",performed_by_id,login_user_id,login_at_ws_no,null,null,null);

							if( !strOutput.equals("Y"))
							{
								commit_flag = false;
							}
							if(csDocref!=null)
							{
								csDocref.close();
							}

						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						commit_flag = false;
						strbuf.append("<br>Exception@ RecClinicalNotesFileUploadManager Ejb - Inserting note header "+e);
					}
					finally
					{
						if(pstInsEnctrNote!=null)
							pstInsEnctrNote.close();
					}

					if( insert_result > 0)
					{
						try
						{
							/*
								Added by Kishore kumar N, for CRF 499 & 500

								to accept multi file upload.
							*/
							RecClinicalNotesMultiFileUploadBean fBean = (RecClinicalNotesMultiFileUploadBean) PersistenceHelper.getObjectFromBean("MULTIFILEUPLOADBEAN", "eCA.RecClinicalNotesMultiFileUploadBean", session);
							//IN070345 Start.
							//commit_flag = fBean.insertDocToDB(con, accession_num, note_type);
							resultsDetails = fBean.insertDocToDB(con, accession_num, note_type,locale);
							if("Y".equals(resultsDetails.get("ERROR"))){
								commit_flag= false;
							}
							//IN070345 End.
							if(commit_flag)
							{
								fBean.clear();
							}


							/*
								ends here.
							*/




							/*String insert_enctr_dtl_obj = "insert into CR_ENCOUNTER_DETAIL_OBJ ( HIST_REC_TYPE, CONTR_SYS_ID, ACCESSION_NUM, CONTR_SYS_EVENT_CODE, EVENT_TITLE, HIST_DATA,OBJTYPE ) values ('CLNT','CA' ,?,?,?,empty_blob(),?)";

							pstEnctrDtlObj = con.prepareStatement(insert_enctr_dtl_obj);
							pstEnctrDtlObj.setString(1,accession_num);
							pstEnctrDtlObj.setString(2,note_type);
							pstEnctrDtlObj.setString(3,uploadremarks);
							pstEnctrDtlObj.setString(4,docType);
							insert_blob_result = pstEnctrDtlObj.executeUpdate();

							oracle.sql.BLOB hist_blob = null;
							java.io.OutputStream blobOutputStream = null;

							if(insert_blob_result > 0)
							{
								try
								{
									String update_enctr_dtl_obj = "select HIST_DATA from CR_ENCOUNTER_DETAIL_OBJ where HIST_REC_TYPE=? AND CONTR_SYS_ID=? AND ACCESSION_NUM = ? and  CONTR_SYS_EVENT_CODE = ? for update";

									pstUpdtEnctrDtlObj = con.prepareStatement(update_enctr_dtl_obj);
									pstUpdtEnctrDtlObj.setString(1,"CLNT");
									pstUpdtEnctrDtlObj.setString(2,"CA");
									pstUpdtEnctrDtlObj.setString(3,accession_num);
									pstUpdtEnctrDtlObj.setString(4,note_type);
									rsUpdtEnctrDtlObj = pstUpdtEnctrDtlObj.executeQuery();

									while(rsUpdtEnctrDtlObj.next())
									{
										hist_blob	=	(oracle.sql.BLOB)rsUpdtEnctrDtlObj.getBlob(1);
										blobOutputStream = ((oracle.sql.BLOB)hist_blob).getBinaryOutputStream();
										size = fileItem.get().length;
										blobOutputStream.write(fileItem.get(),0,docs);
										blobOutputStream.close();
										commit_flag = true;
									}

									if(rsUpdtEnctrDtlObj!=null)
										rsUpdtEnctrDtlObj.close();
									if(pstUpdtEnctrDtlObj!=null)
										pstUpdtEnctrDtlObj.close();
								}
								catch(Exception e)
								{
										e.printStackTrace();
										commit_flag = false;
										strbuf.append("<br>Exception@ RecClinicalNotesFileUploadServlet - Inserting blob histdata 11111"+e);
								}

							}*/
						// updating ca_encntr_note table field EXT_IMAGE_APPL_ID
						
							try
								{
								if(commit_flag)
								{
									String update_sql = "update ca_encntr_note set EXT_IMAGE_APPL_ID='DOCUL' WHERE FACILITY_ID=? and ACCESSION_NUM=?";
									pstInsEnctrNote = con.prepareStatement(update_sql);
									pstInsEnctrNote.setString(1,facilityId);
									pstInsEnctrNote.setString(2,accession_num);
									insert_result = 	pstInsEnctrNote.executeUpdate();
								}

								if(pstInsEnctrNote!=null)
									pstInsEnctrNote.close();
	
								if(insert_result > 0)
									commit_flag = true;
								else
									commit_flag = false;
							}
							catch(Exception e)
							{
									e.printStackTrace();
									commit_flag = false;
									strbuf.append("<br>Exception@ RecClinicalNotesFileUploadSectionsServlet - updating  EXT_IMAGE_APPL_ID"+e.getMessage());
									System.err.println("<br>Exception@ RecClinicalNotesFileUploadSectionsServlet - updating  EXT_IMAGE_APPL_ID"+e.getMessage());
							}
						
						}
						catch(Exception e)
						{
							e.printStackTrace();
							commit_flag = false;
							strbuf.append("<br>Exception@ RecClinicalNotesFileUploadSectionsServlet --868-->  "+e.getMessage());
							System.err.println("<br>Exception@ RecClinicalNotesFileUploadSectionsServlet --868-->  "+e.getMessage());
						}
						finally
						{
							if(pstEnctrDtlObj!=null)
								pstEnctrDtlObj.close();
						}

					}
				}
				}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				strbuf.append("<br>Exception @ RecClinicalNotesFileUploadSectionsServlet: ---883----> : "+e.getMessage());
				System.err.println("<br>Exception @ RecClinicalNotesFileUploadSectionsServlet: ---883----> : "+e.getMessage());
			}

			if(commit_flag && operation_mode.equals("Record"))
			{
				try
				{
					boolean proc_result = false;
					proc_result = caBuildNotes(facilityId, accession_num,con);
					if(!(proc_result))	commit_flag	= false;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					commit_flag = false;
					strbuf.append("<br>Exception @ RecClinicalNotesFileUploadSectionsServlet - while accessing cabuildnotes(): "+e.getMessage());
					System.err.println("<br>Exception @ RecClinicalNotesFileUploadSectionsServlet - while accessing cabuildnotes(): "+e.getMessage());
				}

			} // end of if(commit_flag)*/

			}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
			//	out.println("<br>Exception @ RecClinicalNotesFileUploadSectionsServlet --910---> : "+e.getMessage());//COMMON-ICN-0181
				System.err.println("<br>Exception @ RecClinicalNotesFileUploadSectionsServlet --910---> : "+e.getMessage());
			}
			finally
			{
				try
				{
					if(commit_flag)
					{
						res = true ;
						message = msgmngr.getMessage( locale, "RECORD_INSERTED","CA" ) ;
						strbuf.append( (String) message.get("message") ) ;
						con.commit();
					} // if(commit_flag)
					else
					{
						con.rollback();
						strbuf.append((String)resultsDetails.get("ERROR_MSG")); //IN070345
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					strbuf.append("<br>Exception@ record:"+e);
					try
					{
						con.rollback();
					}
					catch(Exception e1) {
						e1.printStackTrace();
						strbuf.append("<br>Exception@ record while rolling back:"+e1);
					}
				}
			}

		results.put( "status", new Boolean(res) ) ;
		results.put( "error", strbuf.toString() ) ;
		results.put( "accession_num", accession_num ) ;
		if(message!=null)
			message.clear();
		return results ;
	}



/*
public java.util.HashMap recordNoteSectionsFileUpload(HttpServletRequest request, HttpServletResponse response ) throws FileUploadException, java.io.IOException
{
		int docs	 =	 (int)docSize;
		MessageManager		msgmngr						=	null;
		java.util.Hashtable		message						=	null;
		//StringBuffer strbuf		=	new StringBuffer();
		java.util.HashMap	results		= new java.util.HashMap();

		try
		{
			strbuf.delete(0,strbuf.length());
			msgmngr							=	new MessageManager();

			if(operation_mode.equals("Record"))
			{
				authorized_by_id		=	"";
				authorized_date_time	=	"";
				event_status			=	"1";
			}

			con.setAutoCommit(false);
			try
			{
				if(accession_num.equals(""))
				{
					try
					{
						String query_accession_num =  "select 'CN'||to_char(sysdate,'YY')||'$'||lpad(ca_note_type_seq.nextval,16,'0') accession_num from dual ";
						pstAccNum	=	con.prepareStatement(query_accession_num);
						rsAccNum		=	pstAccNum.executeQuery();


						if(rsAccNum.next())
							accession_num	=	rsAccNum.getString("accession_num");
					}
					catch(Exception e)
					{
							e.printStackTrace();
							commit_flag = false;
							strbuf.append("<br>Exception @ RecClinicalNotesFileUploadManager EJB : Getting accession Number "+e);
					}
					finally
					{
						if(rsAccNum!=null)
							rsAccNum.close();
						if(pstAccNum!=null)
							pstAccNum.close();
					}
					try
					{
						String insert_ca_encntr_note = "";

						if(authorized_date_time.equals("SYSDATE"))
						{
							insert_ca_encntr_note = "insert into ca_encntr_note ( facility_id, accession_num, patient_id, patient_class, encounter_id, event_type_caption, note_type, service_code, event_class, security_level, event_date_caption, event_date_time, event_perf_by_caption, performed_by_id, event_title_caption, event_title_desc, note_content, event_auth_by_caption, authorized_by_id, authorized_date_time, event_status_caption, event_status,last_amended_by_id, last_amended_date_time, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, encntr_date,contr_mod_accession_num ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/yyyy HH24:MI'), ?, ?, ?, ?, empty_clob(), ?, ?, sysdate, ?, ?, ?,SYSDATE,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, to_date(?,'dd/mm/yyyy HH24:MI'),? ) ";

						}
						else
						{
							insert_ca_encntr_note = "insert into ca_encntr_note ( facility_id, accession_num, patient_id, patient_class, encounter_id, event_type_caption, note_type, service_code, event_class, security_level, event_date_caption, event_date_time, event_perf_by_caption, performed_by_id, event_title_caption, event_title_desc, note_content, event_auth_by_caption, authorized_by_id, authorized_date_time, event_status_caption, event_status,last_amended_by_id, last_amended_date_time, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, encntr_date,contr_mod_accession_num ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/yyyy HH24:MI'), ?, ?, ?, ?, empty_clob(), ?, ?, to_date(?,'dd/mm/yyyy HH24:MI'), ?, ?, ?,SYSDATE,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, to_date(?,'dd/mm/yyyy HH24:MI'),? ) ";

						}

						colIndex	=	0;

						pstInsEnctrNote		=	con.prepareStatement(insert_ca_encntr_note);

						pstInsEnctrNote.setString	(  ++colIndex,	facilityId			);
						pstInsEnctrNote.setString	(  ++colIndex,	accession_num	);
						pstInsEnctrNote.setString	(  ++colIndex,	patient_id			);
						pstInsEnctrNote.setString	(  ++colIndex,	patient_class		);

						if(encounter_id.equals(""))
							pstInsEnctrNote.setNull	(  ++colIndex,	Types.NUMERIC	);
						else
							pstInsEnctrNote.setLong	(  ++colIndex,	Long.parseLong(encounter_id)	);

						pstInsEnctrNote.setString	(  ++colIndex,	event_type_caption		);
						pstInsEnctrNote.setString	(  ++colIndex,	note_type				);
						pstInsEnctrNote.setString	(  ++colIndex,	service_code			);
						pstInsEnctrNote.setString	(  ++colIndex,	event_class				);
						pstInsEnctrNote.setString	(  ++colIndex,	security_level			);
						pstInsEnctrNote.setString	(  ++colIndex,	event_date_caption		);
						pstInsEnctrNote.setString	(  ++colIndex,	event_date_time			);
						pstInsEnctrNote.setString	(  ++colIndex,	event_perf_by_caption	);
						pstInsEnctrNote.setString	(  ++colIndex,	performed_by_id			);
						pstInsEnctrNote.setString	(  ++colIndex,	event_title_caption		);
						pstInsEnctrNote.setString	(  ++colIndex,	event_title_desc		);
						pstInsEnctrNote.setString	(  ++colIndex,	event_auth_by_caption	);

						if(authorized_by_id.equals(""))
							pstInsEnctrNote.setNull	(++colIndex,	Types.VARCHAR		);
						else
							pstInsEnctrNote.setString	( ++colIndex,	authorized_by_id	);

						if(!authorized_date_time.equals("SYSDATE"))
						{
							pstInsEnctrNote.setString	( ++colIndex,	authorized_date_time	);
						}

						pstInsEnctrNote.setString	( ++colIndex,	event_status_caption	);
						pstInsEnctrNote.setString	( ++colIndex,	event_status			);

						if(authorized_by_id.equals(""))
							pstInsEnctrNote.setNull	(++colIndex,	Types.VARCHAR		);
						else
							pstInsEnctrNote.setString	( ++colIndex,	authorized_by_id	);

						pstInsEnctrNote.setString	( ++colIndex,	login_user_id			);
						pstInsEnctrNote.setString	( ++colIndex,	login_at_ws_no			);
						pstInsEnctrNote.setString	( ++colIndex,	facilityId				);
						pstInsEnctrNote.setString	( ++colIndex,	login_user_id			);
						pstInsEnctrNote.setString	( ++colIndex,	login_at_ws_no			);
						pstInsEnctrNote.setString	( ++colIndex,	facilityId				);
						pstInsEnctrNote.setString	( ++colIndex,	encntr_date				);
						pstInsEnctrNote.setString	( ++colIndex,	contr_mod_accession_num	);

						insert_result = pstInsEnctrNote.executeUpdate();

						if( insert_result <= 0 )
							commit_flag = false;
						else
						{
							CallableStatement csDocref = con.prepareCall("{call CA_GET_NOTE_DOC_REF(?)}");
							csDocref.setString(1,accession_num);
							csDocref.execute();

							strOutput = insertAuditLog(con,facilityId,accession_num,"SYSDATE","PR","CO",performed_by_id,login_user_id,login_at_ws_no,null,null,null);

							if( !strOutput.equals("Y"))
							{
								commit_flag = false;
							}
							if(csDocref!=null)
							{
								csDocref.close();
							}

						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						commit_flag = false;
						strbuf.append("<br>Exception@ RecClinicalNotesFileUploadManager Ejb - Inserting note header "+e);
					}
					finally
					{
						if(pstInsEnctrNote!=null)
							pstInsEnctrNote.close();
					}

					if( insert_result > 0)
					{
						try
						{
							String insert_enctr_dtl_obj = "insert into CR_ENCOUNTER_DETAIL_OBJ ( HIST_REC_TYPE, CONTR_SYS_ID, ACCESSION_NUM, CONTR_SYS_EVENT_CODE, EVENT_TITLE, HIST_DATA,OBJTYPE ) values ('CLNT','CA' ,?,?,?,empty_blob(),?)";

							pstEnctrDtlObj = con.prepareStatement(insert_enctr_dtl_obj);
							pstEnctrDtlObj.setString(1,accession_num);
							pstEnctrDtlObj.setString(2,note_type);
							pstEnctrDtlObj.setString(3,uploadremarks);
							pstEnctrDtlObj.setString(4,docType);
							insert_blob_result = pstEnctrDtlObj.executeUpdate();

							oracle.sql.BLOB hist_blob = null;
							java.io.OutputStream blobOutputStream = null;

							if(insert_blob_result > 0)
							{
								try
								{
									String update_enctr_dtl_obj = "select HIST_DATA from CR_ENCOUNTER_DETAIL_OBJ where HIST_REC_TYPE=? AND CONTR_SYS_ID=? AND ACCESSION_NUM = ? and  CONTR_SYS_EVENT_CODE = ? for update";

									pstUpdtEnctrDtlObj = con.prepareStatement(update_enctr_dtl_obj);
									pstUpdtEnctrDtlObj.setString(1,"CLNT");
									pstUpdtEnctrDtlObj.setString(2,"CA");
									pstUpdtEnctrDtlObj.setString(3,accession_num);
									pstUpdtEnctrDtlObj.setString(4,note_type);
									rsUpdtEnctrDtlObj = pstUpdtEnctrDtlObj.executeQuery();

									while(rsUpdtEnctrDtlObj.next())
									{
										hist_blob	=	(oracle.sql.BLOB)rsUpdtEnctrDtlObj.getBlob(1);
										blobOutputStream = ((oracle.sql.BLOB)hist_blob).getBinaryOutputStream();
										size = fileItem.get().length;
										blobOutputStream.write(fileItem.get(),0,docs);
										blobOutputStream.close();
										commit_flag = true;
									}

									if(rsUpdtEnctrDtlObj!=null)
										rsUpdtEnctrDtlObj.close();
									if(pstUpdtEnctrDtlObj!=null)
										pstUpdtEnctrDtlObj.close();
								}
								catch(Exception e)
								{
										e.printStackTrace();
										commit_flag = false;
										strbuf.append("<br>Exception@ RecClinicalNotesFileUploadServlet - Inserting blob histdata 11111"+e);
								}

							}
						// updating ca_encntr_note table field EXT_IMAGE_APPL_ID

						try
							{
							if(insert_blob_result > 0)
							{
								String update_sql = "update ca_encntr_note set EXT_IMAGE_APPL_ID='DOCUL' WHERE FACILITY_ID=? and ACCESSION_NUM=?";
								pstInsEnctrNote = con.prepareStatement(update_sql);
								pstInsEnctrNote.setString(1,facilityId);
								pstInsEnctrNote.setString(2,accession_num);
								insert_result = 	pstInsEnctrNote.executeUpdate();

							}

							if(pstInsEnctrNote!=null)
								pstInsEnctrNote.close();

							if(insert_result > 0)
								commit_flag = true;
							else
								commit_flag = false;
							}
							catch(Exception e)
							{
									e.printStackTrace();
									commit_flag = false;
									strbuf.append("<br>Exception@ RecClinicalNotesFileUploadSectionsServlet - updating  EXT_IMAGE_APPL_ID"+e);
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							commit_flag = false;
							strbuf.append("<br>Exception@ RecClinicalNotesFileUploadServlet - Inserting blob histdata "+e);
						}
						finally
						{
							if(pstEnctrDtlObj!=null)
								pstEnctrDtlObj.close();
						}

					}
				}
				}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				strbuf.append("<br>Exception @ RecClinicalNotesFileUploadManager: main : "+e);
			}

			if(commit_flag && operation_mode.equals("Record"))
			{
				try
				{
					boolean proc_result = false;
					proc_result = caBuildNotes(facilityId, accession_num,con);
					if(!(proc_result))	commit_flag	= false;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					commit_flag = false;
					strbuf.append("<br>Exception @ RecClinicalNotesFileUploadServlet - while accessing cabuildnotes(): "+e);
				}

			} // end of if(commit_flag) *//*

			}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				out.println("<br>Exception @ RecClinicalNotesFileUploadServlet - while accessing cabuildnotes(): "+e);
			}
			finally
			{
				try
				{
					if(commit_flag)
					{
						res = true ;
						message = msgmngr.getMessage( locale, "RECORD_INSERTED","CA" ) ;
						strbuf.append( (String) message.get("message") ) ;
						con.commit();
					} // if(commit_flag)
					else
					{
						con.rollback();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					strbuf.append("<br>Exception@ record:"+e);
					try
					{
						con.rollback();
					}
					catch(Exception e1) {
						e1.printStackTrace();
						strbuf.append("<br>Exception@ record while rolling back:"+e1);
					}
				}
			}

		results.put( "status", new Boolean(res) ) ;
		results.put( "error", strbuf.toString() ) ;
		results.put( "accession_num", accession_num ) ;
		if(message!=null)
			message.clear();
		return results ;
	}*/

	private boolean caBuildNotes(String facilityId, String accessionNum,Connection con)
	{
			StringBuffer noteContent = new StringBuffer();
			String noteTitle	 = "";
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			java.util.Locale loc = new java.util.Locale(this.locale);

			//java.util.ResourceBundle ca_labels		= java.util.ResourceBundle.getBundle( "eCA.resources.Labels",loc);
			java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
			String strTempSel = common_labels.getString("Common.Med/AncService.label");


			try
			{
				//constructing the heading for the note

				String header_qry = "SELECT a.Event_type_caption,a.Event_date_caption,a.Event_title_caption, 		replace(c.Note_type_desc,'''','') note_type_desc, TO_CHAR(a.Event_date_time,'dd/mm/yyyy hh24:mi') event_date_time ,a.Event_title_desc, replace(b.Short_desc,'''','') service_desc,(Select replace(practitioner_name,'''','') from am_practitioner where practitioner_id = a.performed_by_id) phy_prov_name, a.Event_perf_by_caption event_pref_by_caption,a.event_class,a.event_status_caption,DECODE( a.event_status,'1','In Progress','2','Transcribed','3','Unauthorized','4','Authorized','5','Modified') event_status_desc FROM Ca_encntr_note a, Am_service b, Ca_note_type c WHERE a.service_code = b.service_code AND a.note_type = c.note_type AND a.facility_id = ? AND a.Accession_num = ?";

				pstmt = con.prepareStatement(header_qry);

				pstmt.setString(1,facilityId);
				pstmt.setString(2,accessionNum);

				rs = pstmt.executeQuery();

				if(rs.next())
				{
					noteTitle = rs.getString("event_title_desc")==null?"":rs.getString("event_title_desc");
					event_title_caption = rs.getString("event_title_caption")==null?"":rs.getString("event_title_caption");

					noteContent.append("<HTML><HEAD><TITLE></TITLE> </HEAD><BODY><table border=0 cellspacing=0 width=auto width='100%' style=\"font-family:Verdana;font-size:9pt\"><tr><td width=10% nowrap> <B>  "+rs.getString("event_type_caption")+"  </B></td><td width=70% nowrap><b> &nbsp;: </b> "+ rs.getString("note_type_desc")+" </td><td width=10% align=right nowrap><b> "+strTempSel+" </B></td><td width=10% nowrap> <b> &nbsp;: </b>  "+rs.getString("service_desc") +"</td></tr><tr><td width=10% nowrap> <B>   "+rs.getString("event_date_caption")+"   </B></td><td width=70% nowrap><b> &nbsp;: </b>  "+rs.getString("event_date_time")+" </td><td width=10% align=right nowrap><b> "+rs.getString("event_pref_by_caption")+" </B></td><td width=10% nowrap> <b> &nbsp;: </b>  "+rs.getString("phy_prov_name")+" </td></tr>");

					if(!noteTitle.equals(""))
						noteContent.append("<tr><td width=10%> <B>   "+event_title_caption+"  </B></td><td width=90% colspan=3><b> &nbsp;: </b>  "+noteTitle+" </td></tr></table><br><hr>");
					else
						noteContent.append("</table><br><hr>");

						noteContent.append("</BODY></HTML>");
				}

			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				//out.println("Exception @ RecClinicalNotesFileUploadServlet while constructing notes content "+ex.toString());//common-icn-0181
			}
			finally
			{
				try
				{
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
				}
				catch(Exception ex5)
				{
					ex5.printStackTrace();
					//out.println("Exception @ RecClinicalNotesFileUploadServlet while constructing notes content 1"+ex5.toString());//common-icn-0181
				}
			}

			//updating the notes table
		//Web logic Conversion -- [IN037372] Start
			//oracle.sql.CLOB clobNotesContent = null;
			java.sql.Clob  clobNotesContent = null;
		//Web logic Conversion -- [IN037372] End.
		//	java.io.Writer notesContentWriter =	null;//Common-ICN-0092 
			java.io.BufferedWriter	notesContentBufferedWriter	= null;

			String updateSql = "UPDATE Ca_encntr_note SET Note_content = empty_clob()  WHERE facility_id = ? AND Accession_num = ? ";

			try
			{
				pstmt = con.prepareStatement(updateSql);
				pstmt.setString(1,facilityId);
				pstmt.setString(2,accessionNum);
				pstmt.executeUpdate();
			}
			catch (Exception ex1)
			{
				ex1.printStackTrace();
				//out.println("Exception @ RecClinicalNotesFileUploadServlet while updating notes content "+ex1.toString());//common-icn-0181

			}
			finally
			{
				try
				{
					if (pstmt != null)
						pstmt.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					//out.println("Exception @ RecClinicalNotesFileUploadServlet updating 33 "+ex.toString());//common-icn-0181
				}
			}

			String selectSql = "select Note_content from Ca_encntr_note where facility_id = ? AND Accession_num = ? for update";
			try
			{
				pstmt = con.prepareStatement(selectSql);

				pstmt.setString(1,facilityId);
				pstmt.setString(2,accessionNum);

				rs = pstmt.executeQuery();

				if(rs.next())
				{
				//Web logic Conversion -- [IN037372] Start.
					//clobNotesContent	= (oracle.sql.CLOB) rs.getObject("Note_content");
					//notesContentWriter	= ((oracle.sql.CLOB)	clobNotesContent).getCharacterOutputStream();	
					//notesContentBufferedWriter = new java.io.BufferedWriter(notesContentWriter);		
					
					clobNotesContent 	= rs.getClob("Note_content");
					notesContentBufferedWriter = new java.io.BufferedWriter(clobNotesContent.setCharacterStream(0));
				//Web logic Conversion -- [IN037372] End.
					notesContentBufferedWriter.write(noteContent.toString(),0,noteContent.length());		
					notesContentBufferedWriter.flush();
					notesContentBufferedWriter.close();
					return true;
				}
			}
			catch (Exception ex3)
			{
				ex3.printStackTrace();
				//out.println("Exception @ RecClinicalNotesFileUploadServlet while inserting notes content "+ex3.toString());//common-icn-0181
				return false;
			}
			finally
			{
				try
				{
					if (rs != null)
							rs.close();
					if (pstmt != null)
						pstmt.close();
				}
				catch(Exception ex4)
				{
					ex4.printStackTrace();
					//out.println("Exception @ RecClinicalNotesFileUploadServlet while inserting notes content 1"+ex4.toString());//common-icn-0181
				}
				finally
				{
					noteContent = null;
				}
			}
			return true;
	}

		public java.util.HashMap UpdateRecClinicalNotesFileUpload (	HttpServletRequest request, HttpServletResponse response) throws FileUploadException, java.io.IOException
	{
		MessageManager		msgmngr						=	null;
		java.util.Hashtable		message						=	null;
		java.util.HashMap	results		= new java.util.HashMap();
		java.util.HashMap<String, String>	resultsDetails		= new java.util.HashMap<String, String>(); //IN070345
		commit_flag = true;
		try
		{
			strbuf.delete(0,strbuf.length());
			msgmngr							=	new MessageManager();

			try
			{
				String query_str = "select count(*) count from cr_encounter_detail_obj where  HIST_REC_TYPE=? AND CONTR_SYS_ID=? AND ACCESSION_NUM = ? and  CONTR_SYS_EVENT_CODE = ? ";
				pstEnctrDtlObj = con.prepareStatement(query_str);
				pstEnctrDtlObj.setString(1,"CLNT");
				pstEnctrDtlObj.setString(2,"CA");
				pstEnctrDtlObj.setString(3,accession_num);
				pstEnctrDtlObj.setString(4,note_type);
				rsEnctrDtlObj = pstEnctrDtlObj.executeQuery();

				while(rsEnctrDtlObj.next())
				{
					record_count = rsEnctrDtlObj.getInt("count");
				}
			}
			catch(Exception e)
			{
					e.printStackTrace();
					commit_flag = false;
					strbuf.append("<br>Exception@ RecClinicalNotesFileUploadServlet - while getting the count "+e);
			}
			finally
			{
				if(rsEnctrDtlObj!=null)
					rsEnctrDtlObj.close();
				if(pstEnctrDtlObj!=null)
					pstEnctrDtlObj.close();
			}

					try
					{

						if(record_count > 0 && change_file_ref.equals("N"))
						{
							/*String insert_enctr_dtl_obj = "update CR_ENCOUNTER_DETAIL_OBJ  set EVENT_TITLE = ? where HIST_REC_TYPE=? AND CONTR_SYS_ID=? AND ACCESSION_NUM = ? and  CONTR_SYS_EVENT_CODE = ? ";

								pstEnctrDtlObj = con.prepareStatement(insert_enctr_dtl_obj);
								pstEnctrDtlObj.setString(1,uploadremarks);
								pstEnctrDtlObj.setString(2,"CLNT");
								pstEnctrDtlObj.setString(3,"CA");
								pstEnctrDtlObj.setString(4,accession_num);
							    pstEnctrDtlObj.setString(5,note_type);


								insert_blob_result	 = pstEnctrDtlObj.executeUpdate();

								if(pstEnctrDtlObj!=null)
									pstEnctrDtlObj.close();*/

									/*
									Added by Kishore kumar N, for CRF 499 & 500

									to accept multi file upload.
								*/
									RecClinicalNotesMultiFileUploadBean fBean = (RecClinicalNotesMultiFileUploadBean) PersistenceHelper.getObjectFromBean("MULTIFILEUPLOADBEAN", "eCA.RecClinicalNotesMultiFileUploadBean", session);
									//IN070345 Start.
									//commit_flag = fBean.insertDocToDB(con, accession_num, note_type);
									resultsDetails = fBean.insertDocToDB(con, accession_num, note_type,locale);
									if("Y".equals(resultsDetails.get("ERROR"))){
										commit_flag= false;
									}
									//IN070345 End.
									if(commit_flag)
									{
										fBean.clear();
									}


								/*
									ends here.
								*/
						}
						else
						{

							/*
								Added by Kishore kumar N, for CRF 499 & 500

								to accept multi file upload.
							*/
							RecClinicalNotesMultiFileUploadBean fBean = (RecClinicalNotesMultiFileUploadBean) PersistenceHelper.getObjectFromBean("MULTIFILEUPLOADBEAN", "eCA.RecClinicalNotesMultiFileUploadBean", session);
							//IN070345 Start.
							//commit_flag = fBean.insertDocToDB(con, accession_num, note_type);
							resultsDetails = fBean.insertDocToDB(con, accession_num, note_type,locale);
							if("Y".equals(resultsDetails.get("ERROR"))){
								commit_flag= false;
							}
							//IN070345 End.
							if(commit_flag)
							{
								fBean.clear();
							}


							/*
								ends here.
							*/



							/*if(record_count > 0 && change_file_ref.equals("Y"))
							{
								String insert_enctr_dtl_obj = "update CR_ENCOUNTER_DETAIL_OBJ  set EVENT_TITLE = ?, HIST_DATA = empty_blob(),OBJTYPE = ? where HIST_REC_TYPE=? AND CONTR_SYS_ID=? AND  CONTR_SYS_EVENT_CODE = ? and ACCESSION_NUM = ?";

								pstEnctrDtlObj = con.prepareStatement(insert_enctr_dtl_obj);
								pstEnctrDtlObj.setString(1,uploadremarks);
								pstEnctrDtlObj.setString(2,docType);								pstEnctrDtlObj.setString(3,"CLNT");
								pstEnctrDtlObj.setString(4,"CA");
								pstEnctrDtlObj.setString(5,note_type);
								pstEnctrDtlObj.setString(6,accession_num);

								insert_blob_result	 = pstEnctrDtlObj.executeUpdate();

								if(insert_blob_result > 0)
									commit_flag = true;
								else
									commit_flag = false;

								if(pstEnctrDtlObj!=null)
									pstEnctrDtlObj.close();
							}
							else
							{

									String insert_enctr_dtl_obj = "insert into CR_ENCOUNTER_DETAIL_OBJ ( HIST_REC_TYPE, CONTR_SYS_ID, ACCESSION_NUM, CONTR_SYS_EVENT_CODE, EVENT_TITLE, HIST_DATA,OBJTYPE ) values ('CLNT','CA' ,?,?,?,empty_blob(),?)";

									pstEnctrDtlObj = con.prepareStatement(insert_enctr_dtl_obj);
									pstEnctrDtlObj.setString(1,accession_num);
									pstEnctrDtlObj.setString(2,note_type);
									pstEnctrDtlObj.setString(3,uploadremarks);
									pstEnctrDtlObj.setString(4,docType);
									insert_blob_result = pstEnctrDtlObj.executeUpdate();

								}
								if(pstEnctrDtlObj!=null)
									pstEnctrDtlObj.close();
								if(insert_blob_result > 0)
								{

										oracle.sql.BLOB hist_blob = null;
										java.io.OutputStream blobOutputStream = null;

										String update_enctr_dtl_obj = "select HIST_DATA from CR_ENCOUNTER_DETAIL_OBJ where HIST_REC_TYPE=? AND CONTR_SYS_ID=? AND ACCESSION_NUM = ? and  CONTR_SYS_EVENT_CODE = ? for update";

										pstUpdtEnctrDtlObj = con.prepareStatement(update_enctr_dtl_obj);
										pstUpdtEnctrDtlObj.setString(1,"CLNT");
										pstUpdtEnctrDtlObj.setString(2,"CA");
										pstUpdtEnctrDtlObj.setString(3,accession_num);
										pstUpdtEnctrDtlObj.setString(4,note_type);
										rsUpdtEnctrDtlObj = pstUpdtEnctrDtlObj.executeQuery();

										while(rsUpdtEnctrDtlObj.next())
										{
											hist_blob	=	(oracle.sql.BLOB)rsUpdtEnctrDtlObj.getBlob(1);
											blobOutputStream = ((oracle.sql.BLOB)hist_blob).getBinaryOutputStream();
											int size = fileItem.get().length;
											blobOutputStream.write(fileItem.get(),0,size);
											blobOutputStream.close();
											commit_flag = true;
										}

										if(rsUpdtEnctrDtlObj!=null)
											rsUpdtEnctrDtlObj.close();
										if(pstUpdtEnctrDtlObj!=null)
											pstUpdtEnctrDtlObj.close();

						}
						else
							commit_flag = false; */
					
					
						// updating ca_encntr_note table field EXT_IMAGE_APPL_ID
						try
						{
							if(commit_flag)
							{
								String update_sql = "update ca_encntr_note set EXT_IMAGE_APPL_ID='DOCUL' WHERE FACILITY_ID=? and ACCESSION_NUM=?";
								pstInsEnctrNote = con.prepareStatement(update_sql);
								pstInsEnctrNote.setString(1,facilityId);
								pstInsEnctrNote.setString(2,accession_num);
								insert_result = 	pstInsEnctrNote.executeUpdate();
							}
								if(pstInsEnctrNote!=null)
									pstInsEnctrNote.close();

								if(insert_result > 0)
									commit_flag = true;
								else
									commit_flag = false;
						}
						catch(Exception e)
						{
								e.printStackTrace();
								commit_flag = false;
								strbuf.append("<br>Exception@ RecClinicalNotesFileUploadServlet 1676 - updating  EXT_IMAGE_APPL_ID"+e);
								System.err.println("<br>Exception@ RecClinicalNotesFileUploadServlet 1676 - updating  EXT_IMAGE_APPL_ID"+e.getMessage());
						}
					}

				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				strbuf.append("<br>Exception@ RecClinicalNotesFileUploadServlet  1686- Inserting blob histdata "+e);
				System.err.println("<br>Exception@ RecClinicalNotesFileUploadServlet  1686 - Inserting blob histdata "+e.getMessage());
			}
			finally
			{
				if(pstEnctrDtlObj!=null)
					pstEnctrDtlObj.close();
			}


			}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				//out.println("<br>Exception @ RecClinicalNotesFileUploadServlet - while accessing cabuildnotes(): "+e);//common-icn-0181
			}
			finally
			{
				try
				{
					if(commit_flag)
					{
						res = true ;
						message = msgmngr.getMessage( locale,"RECORD_INSERTED","CA" ) ;
						strbuf.append( (String) message.get("message") ) ;
						con.commit();
					} // if(commit_flag)
					else
					{
						con.rollback();
						strbuf.append((String)resultsDetails.get("ERROR_MSG"));//IN070345
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					strbuf.append("<br>Exception@ record:"+e);
					try
					{
						con.rollback();
					}
					catch(Exception e1) {
						e1.printStackTrace();
						strbuf.append("<br>Exception@ record while rolling back:"+e1);
					}
				}
			}

		results.put( "status", new Boolean(res) ) ;
		results.put( "error", strbuf.toString() ) ;
		results.put( "accession_num", accession_num ) ;
		if(message!=null)
			message.clear();
		return results ;
	}

	/*public java.util.HashMap UpdateRecClinicalNotesFileUpload (	HttpServletRequest request, HttpServletResponse response) throws FileUploadException, java.io.IOException
	{
		MessageManager		msgmngr						=	null;
		java.util.Hashtable		message						=	null;
		java.util.HashMap	results		= new java.util.HashMap();

		try
		{
			strbuf.delete(0,strbuf.length());
			msgmngr							=	new MessageManager();

			try
			{
				String query_str = "select count(*) count from cr_encounter_detail_obj where  HIST_REC_TYPE=? AND CONTR_SYS_ID=? AND ACCESSION_NUM = ? and  CONTR_SYS_EVENT_CODE = ? ";
				pstEnctrDtlObj = con.prepareStatement(query_str);
				pstEnctrDtlObj.setString(1,"CLNT");
				pstEnctrDtlObj.setString(2,"CA");
				pstEnctrDtlObj.setString(3,accession_num);
				pstEnctrDtlObj.setString(4,note_type);
				rsEnctrDtlObj = pstEnctrDtlObj.executeQuery();

				while(rsEnctrDtlObj.next())
				{
					record_count = rsEnctrDtlObj.getInt("count");
				}
			}
			catch(Exception e)
			{
					e.printStackTrace();
					commit_flag = false;
					strbuf.append("<br>Exception@ RecClinicalNotesFileUploadServlet - while getting the count "+e);
			}
			finally
			{
				if(rsEnctrDtlObj!=null)
					rsEnctrDtlObj.close();
				if(pstEnctrDtlObj!=null)
					pstEnctrDtlObj.close();
			}

					try
					{
						if(record_count > 0 && change_file_ref.equals("N"))
						{
							String insert_enctr_dtl_obj = "update CR_ENCOUNTER_DETAIL_OBJ  set EVENT_TITLE = ? where HIST_REC_TYPE=? AND CONTR_SYS_ID=? AND ACCESSION_NUM = ? and  CONTR_SYS_EVENT_CODE = ? ";

								pstEnctrDtlObj = con.prepareStatement(insert_enctr_dtl_obj);
								pstEnctrDtlObj.setString(1,uploadremarks);
								pstEnctrDtlObj.setString(2,"CLNT");									pstEnctrDtlObj.setString(3,"CA");
								pstEnctrDtlObj.setString(4,accession_num);
							    pstEnctrDtlObj.setString(5,note_type);


								insert_blob_result	 = pstEnctrDtlObj.executeUpdate();

								if(pstEnctrDtlObj!=null)
									pstEnctrDtlObj.close();

						}
						else
						{
							if(record_count > 0 && change_file_ref.equals("Y"))
							{
								String insert_enctr_dtl_obj = "update CR_ENCOUNTER_DETAIL_OBJ  set EVENT_TITLE = ?, HIST_DATA = empty_blob(),OBJTYPE = ? where HIST_REC_TYPE=? AND CONTR_SYS_ID=? AND  CONTR_SYS_EVENT_CODE = ? and ACCESSION_NUM = ?";

								pstEnctrDtlObj = con.prepareStatement(insert_enctr_dtl_obj);
								pstEnctrDtlObj.setString(1,uploadremarks);
								pstEnctrDtlObj.setString(2,docType);								pstEnctrDtlObj.setString(3,"CLNT");
								pstEnctrDtlObj.setString(4,"CA");
								pstEnctrDtlObj.setString(5,note_type);
								pstEnctrDtlObj.setString(6,accession_num);

								insert_blob_result	 = pstEnctrDtlObj.executeUpdate();

								if(insert_blob_result > 0)
									commit_flag = true;
								else
									commit_flag = false;

								if(pstEnctrDtlObj!=null)
									pstEnctrDtlObj.close();
							}
							else
							{

									String insert_enctr_dtl_obj = "insert into CR_ENCOUNTER_DETAIL_OBJ ( HIST_REC_TYPE, CONTR_SYS_ID, ACCESSION_NUM, CONTR_SYS_EVENT_CODE, EVENT_TITLE, HIST_DATA,OBJTYPE ) values ('CLNT','CA' ,?,?,?,empty_blob(),?)";

									pstEnctrDtlObj = con.prepareStatement(insert_enctr_dtl_obj);
									pstEnctrDtlObj.setString(1,accession_num);
									pstEnctrDtlObj.setString(2,note_type);
									pstEnctrDtlObj.setString(3,uploadremarks);
									pstEnctrDtlObj.setString(4,docType);
									insert_blob_result = pstEnctrDtlObj.executeUpdate();

								}
								if(pstEnctrDtlObj!=null)
									pstEnctrDtlObj.close();
								if(insert_blob_result > 0)
								{

										oracle.sql.BLOB hist_blob = null;
										java.io.OutputStream blobOutputStream = null;

										String update_enctr_dtl_obj = "select HIST_DATA from CR_ENCOUNTER_DETAIL_OBJ where HIST_REC_TYPE=? AND CONTR_SYS_ID=? AND ACCESSION_NUM = ? and  CONTR_SYS_EVENT_CODE = ? for update";

										pstUpdtEnctrDtlObj = con.prepareStatement(update_enctr_dtl_obj);
										pstUpdtEnctrDtlObj.setString(1,"CLNT");
										pstUpdtEnctrDtlObj.setString(2,"CA");
										pstUpdtEnctrDtlObj.setString(3,accession_num);
										pstUpdtEnctrDtlObj.setString(4,note_type);
										rsUpdtEnctrDtlObj = pstUpdtEnctrDtlObj.executeQuery();

										while(rsUpdtEnctrDtlObj.next())
										{
											hist_blob	=	(oracle.sql.BLOB)rsUpdtEnctrDtlObj.getBlob(1);
											blobOutputStream = ((oracle.sql.BLOB)hist_blob).getBinaryOutputStream();
											int size = fileItem.get().length;
											blobOutputStream.write(fileItem.get(),0,size);
											blobOutputStream.close();
											commit_flag = true;
										}

										if(rsUpdtEnctrDtlObj!=null)
											rsUpdtEnctrDtlObj.close();
										if(pstUpdtEnctrDtlObj!=null)
											pstUpdtEnctrDtlObj.close();

								}
								else
									commit_flag = false;

							if(commit_flag)
							{
								// updating ca_encntr_note table field EXT_IMAGE_APPL_ID
								try
								{
										String update_sql = "update ca_encntr_note set EXT_IMAGE_APPL_ID='DOCUL' WHERE FACILITY_ID=? and ACCESSION_NUM=?";
										pstInsEnctrNote = con.prepareStatement(update_sql);
										pstInsEnctrNote.setString(1,facilityId);
										pstInsEnctrNote.setString(2,accession_num);
										insert_result = 	pstInsEnctrNote.executeUpdate();

										if(pstInsEnctrNote!=null)
											pstInsEnctrNote.close();

										if(insert_result > 0)
											commit_flag = true;
										else
											commit_flag = false;
								}
								catch(Exception e)
								{
										e.printStackTrace();
										commit_flag = false;
										strbuf.append("<br>Exception@ RecClinicalNotesFileUploadServlet - updating  EXT_IMAGE_APPL_ID"+e);
								}
							}

							}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						commit_flag = false;
						strbuf.append("<br>Exception@ RecClinicalNotesFileUploadServlet - Inserting blob histdata "+e);
					}
					finally
					{
						if(pstEnctrDtlObj!=null)
							pstEnctrDtlObj.close();
					}


			}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				out.println("<br>Exception @ RecClinicalNotesFileUploadServlet - while accessing cabuildnotes(): "+e);
			}
			finally
			{
				try
				{
					if(commit_flag)
					{
						res = true ;
						message = msgmngr.getMessage( locale,"RECORD_INSERTED","CA" ) ;
						strbuf.append( (String) message.get("message") ) ;
						con.commit();
					} // if(commit_flag)
					else
					{
						con.rollback();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					strbuf.append("<br>Exception@ record:"+e);
					try
					{
						con.rollback();
					}
					catch(Exception e1) {
						e1.printStackTrace();
						strbuf.append("<br>Exception@ record while rolling back:"+e1);
					}
				}
			}

		results.put( "status", new Boolean(res) ) ;
		results.put( "error", strbuf.toString() ) ;
		results.put( "accession_num", accession_num ) ;
		if(message!=null)
			message.clear();
		return results ;
	}

	*/
	private String insertAuditLog(Connection con, String facility_id, String accession_num, String event_date_time, String action_type, String action_status,String performed_by_id, String login_user_id, String login_at_ws_no, String request_by_id,String request_datetime,String action_comment)
	{
		CallableStatement csAuditLog = null;
		String strOutput = "N";
		

		try
		{
			csAuditLog = con.prepareCall("{call CA_NOTE_AUDIT_LOG(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			csAuditLog.setString	(	1,	facility_id				);
			csAuditLog.setString	(	2,	accession_num			);
			csAuditLog.setString	(	3,	event_date_time			);
			csAuditLog.setString	(	4,	action_type				);
			csAuditLog.setString	(	5,	action_status			);
			csAuditLog.setString	(	6,	performed_by_id			);
			csAuditLog.setString	(	7,	login_user_id			);
			csAuditLog.setString	(	8,	login_at_ws_no			);
			csAuditLog.setString	(	9,	facility_id				);
			csAuditLog.setString	(	10,	login_user_id			);
			csAuditLog.setString	(	11,	login_at_ws_no			);
			csAuditLog.setString	(	12,	facility_id				);
			csAuditLog.setString	(	13,	request_by_id			);
			csAuditLog.setString	(	14,	request_datetime		);
			csAuditLog.setString	(	15,	action_comment			);
			csAuditLog.registerOutParameter	(	16,	Types.VARCHAR);

			csAuditLog.execute();

			strOutput = csAuditLog.getString(16);
			csAuditLog.clearParameters();
		}
		catch (Exception eAuditLog)
		{
			eAuditLog.printStackTrace();
			//sb.append("<br>Exception@Inserting Audit Log "+eAuditLog);
		}
		finally
		{
			try
			{
				if (csAuditLog != null) csAuditLog.close();
			}
			catch (Exception eee)	{}
		}

		return strOutput;
	}


	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	 }
}

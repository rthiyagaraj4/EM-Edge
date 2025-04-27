/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM.FMRequestOfFile;

import javax.ejb.* ;

import java.sql.*;
import java.rmi.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import webbeans.eCommon.*;
import com.ehis.util.*;

/**
*
* @ejb.bean
*	name="FMRequestOfFile"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FMRequestOfFile"
*	local-jndi-name="FMRequestOfFile"
*	impl-class-name="eFM.FMRequestOfFile.RequestOfFileManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eFM.FMRequestOfFile.RequestOfFileLocal"
*	remote-class="eFM.FMRequestOfFile.RequestOfFileRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eFM.FMRequestOfFile.RequestOfFileLocalHome"
*	remote-class="eFM.FMRequestOfFile.RequestOfFileHome"
*	generate= "local,remote"
*
*
*/

public class RequestOfFileManager implements SessionBean 
{

	Connection con ;
	PreparedStatement pstmt ;
	PreparedStatement pstmt1 ;	
	
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;		

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext ctx ) {}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/



	public java.util.HashMap insertRequestOfFile(
							java.util.Properties p,
							java.util.HashMap hashmap
						 ) 
	{

		java.util.HashMap results = new java.util.HashMap() ;

		boolean result		= false ;		

		int ins_req_hdr		= 0;
		int ins_req_dtl		= 0;

		String sql						= "";
		String sql1						= "";
		String sql2						= "";
		String p_file_no				= "" ;
		String p_facility_id			= "";
		String p_req_no					= "";
		String p_curr_fs_locn_code		= "";
		String p_curr_file_status		= "";
		String p_curr_facility_id		= "";
		String p_req_to_facility_id		= "";
		String p_req_to_fs_locn_code	= "";

		String p_doc_folderid = "";
		String p_doc_typecode = "";

		String p_volume_no			= "";
		String parient_file_type	= "";
		String patient_id			= "";
		String file_required_on			= "";

		String p_req_facility_id		= "";
		String p_req_location			= "";
		String p_req_name				= "";
//		String p_enter_fcy				= "";
		String p_req_narration			= "";
		String p_file_nos				= "";
		String addedAtWorkstation		= "";
		String p_rem_recnum				= "";
		String p_file_type_code			= "";
		String p_requesting_from		= "";
		String p_volume_nos				= "";
		String p_patient_id				= "";
		String p_doc_folder_id			= "";
		String p_doc_type_code			= "";
		String p_file_required_on			= "";
		String locale			= "";
		 /*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
		String remarks_for_borrow			= "";
		 /* end ML-MMOH-CRF-0393-IN057159  */

		 p_req_facility_id		= (String) hashmap.get("p_req_facility");
		 p_req_location			= (String) hashmap.get("p_req_location");
		 p_req_name				= (String) hashmap.get("p_req_name");
	//	 p_enter_fcy			= (String) hashmap.get("p_enter_fcy");
		 p_req_narration		= (String) hashmap.get("p_req_narration");
		 p_file_nos				= (String) hashmap.get("p_file_nos");
		 addedAtWorkstation		= (String) hashmap.get("client_ip_address");
		 p_rem_recnum			= (String) hashmap.get("p_rem_recnum");
		 p_file_type_code		= (String) hashmap.get("p_file_type_code");
		 p_requesting_from		= (String) hashmap.get("p_requesting_from");
		 p_volume_nos			= (String) hashmap.get("p_volume_nos");
		 p_patient_id			= (String) hashmap.get("p_patient_id");
		 p_doc_folder_id		= (String) hashmap.get("p_doc_folder_id");
	     p_doc_type_code		= (String) hashmap.get("p_doc_type_code");
		 p_file_required_on		= (String) hashmap.get("p_file_required_on");
		 locale					= (String) hashmap.get("locale");
		  /*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
		 remarks_for_borrow		= (String) hashmap.get("remarks_for_borrow");
		 /* end ML-MMOH-CRF-0393-IN057159  */
		StringBuffer sb = new StringBuffer( "" ) ;
		con				= ConnectionManager.getConnection(p);
		Statement stmt	= null;
		ResultSet rs	= null;
		
		StringTokenizer token	= new StringTokenizer(p_file_nos,",");
		StringTokenizer token1;
		String tokenvalue	= "";		
		

		String remarks[]	= null;
		//StringTokenizer st	= new StringTokenizer(p_rem_recnum,"¡");
		StringTokenizer st	= new StringTokenizer(p_rem_recnum,"~");
		remarks				= new String[st.countTokens()];

		for(int i=0; i<remarks.length; i++) 
		{
			remarks[i] = st.nextToken();
		}
		try
		{
			stmt=con.createStatement();
			
			String addedById			 = p.getProperty( "login_user" ) ;
			String modifiedById			 = addedById ;			
			String modifiedAtWorkstation = addedAtWorkstation ;

			sql1 = "select '"+p_req_facility_id+"' || FM_REQ_HDR_SEQ1.nextval p_req_no from dual" ;
			rs	 = stmt.executeQuery(sql1);
			while(rs.next())
			{
				p_req_no = rs.getString("p_req_no");
			} if(rs != null) rs.close();
			 /*Below line(s) REMARKS added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
			sql		= "INSERT INTO FM_REQ_HDR (REQ_NO,REQ_FACILITY_ID,REQ_FS_LOCN_CODE,REQ_USER_ID,NARRATION_CODE,ISS_COMPLETED_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID, REQUESTING_FROM,REMARKS) VALUES(?,?,?,?,?,'N',?,SYSDATE,?,?,?,SYSDATE,?,?,?,?)" ;
			pstmt   = con.prepareStatement( sql );

			pstmt.setString	( 1, p_req_no) ;
			pstmt.setString	( 2, p_req_facility_id) ;
			pstmt.setString	( 3, p_req_location) ;
			pstmt.setString	( 4, p_req_name) ;
			pstmt.setString	( 5, p_req_narration) ;
			pstmt.setString ( 6, addedById ) ;
			pstmt.setString	( 7, addedAtWorkstation ) ;
			pstmt.setString	( 8, p_req_facility_id ) ;
			pstmt.setString	( 9, modifiedById ) ;
			pstmt.setString	( 10,modifiedAtWorkstation) ;
			pstmt.setString	( 11,p_req_facility_id) ;
			pstmt.setString	( 12,p_requesting_from) ;
			 /*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
			pstmt.setString	( 13,remarks_for_borrow) ;
			/* end ML-MMOH-CRF-0393-IN057159  */
			ins_req_hdr = pstmt.executeUpdate() ;
			pstmt.close();

			StringTokenizer token2				= null;
			StringTokenizer file_type_token		= null;
			StringTokenizer patient_id_token	= null;
			StringTokenizer doc_id_token		= null;
			StringTokenizer doc_type_token		= null;
			StringTokenizer file_required_on_token		= null;

			if(ins_req_hdr != 0)
			{
				int count = 0;
				token2			 = new StringTokenizer(p_volume_nos,"|");
				file_type_token	 = new StringTokenizer(p_file_type_code,"|");
				patient_id_token = new StringTokenizer(p_patient_id,"|");
				doc_id_token	 = new StringTokenizer(p_doc_folder_id,",");
				doc_type_token	 = new StringTokenizer(p_doc_type_code,",");
				file_required_on_token	 = new StringTokenizer(p_file_required_on,"|");

				sql1 = "SELECT a.curr_facility_id curr_facility_id,a.curr_fs_locn_code curr_fs_locn_code,a.curr_file_status curr_file_status,a.facility_id facility_id, a.perm_fs_locn_code fs_locn_code FROM FM_CURR_LOCN a WHERE a.facility_id=? AND a.file_no=? AND a.volume_no=? ";
				pstmt1 = con.prepareStatement(sql1);
				
				sql2   = " INSERT INTO FM_REQ_DTL (REQ_NO,FILE_NO,ISS_YN,CURR_FILE_STATUS, CURR_FS_LOCN_CODE,CURR_FACILITY_ID,REQ_TO_FACILITY_ID,REQ_TO_FS_LOCN_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,REMARKS,FILE_TYPE_CODE, VOLUME_NO, PATIENT_ID,DOC_FOLDER_ID,DOC_TYPE_CODE,FILE_REQUIRED_ON) VALUES(?,?,'N',?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy HH24:mi'))" ;
				pstmt = con.prepareStatement( sql2 );

				while(token.hasMoreTokens())
				{
					tokenvalue  = token.nextToken();
					token1		= new StringTokenizer(tokenvalue,"`");					
					
					while (token1.hasMoreTokens())
					{
						p_file_no			= token1.nextToken();
						p_facility_id		= token1.nextToken();
						p_volume_no			= "";
						parient_file_type	= "";
						patient_id			= "";
						file_required_on		= ""; 

						if (token2.hasMoreTokens())
							p_volume_no = token2.nextToken();
						if (file_type_token.hasMoreTokens())
							parient_file_type = file_type_token.nextToken();
						if (patient_id_token.hasMoreTokens())
							patient_id = patient_id_token.nextToken();
						if (doc_id_token.hasMoreTokens())
							p_doc_folderid = doc_id_token.nextToken();
						if (doc_type_token.hasMoreTokens())
							p_doc_typecode = doc_type_token.nextToken();
						if (file_required_on_token.hasMoreTokens())
							file_required_on = file_required_on_token.nextToken();
						if ((p_volume_no==null)||(p_volume_no.equals("null"))) p_volume_no = "";
						if ((parient_file_type==null)||(parient_file_type.equals("null"))) parient_file_type = "";
						if ((patient_id==null)||(patient_id.equals("null"))) patient_id = "";
						if ((p_doc_folderid==null)||(p_doc_folderid.equals("null"))) p_doc_folderid = "";
						if ((p_doc_typecode==null)||(p_doc_typecode.equals("null"))) p_doc_typecode = "";
						if ((file_required_on==null)||(file_required_on.equals("null"))) file_required_on = "";
			///////////////////////////////////////////////////////////////////////

						pstmt1.setString(1,p_facility_id);
						pstmt1.setString(2,p_file_no);
						pstmt1.setString(3,p_volume_no);
						rs	 = pstmt1.executeQuery();

						while(rs.next())
						{
							p_curr_facility_id		= rs.getString("curr_facility_id");
							p_curr_fs_locn_code		= rs.getString("curr_fs_locn_code");
							p_curr_file_status		= rs.getString("curr_file_status");
							p_req_to_facility_id	= rs.getString("facility_id");
							p_req_to_fs_locn_code	= rs.getString("fs_locn_code");
						} if(rs != null) rs.close();

			//////////////////////////////////////////////////////////////////////					
						pstmt.setString	( 1, p_req_no) ;
						pstmt.setString	( 2, p_file_no) ;
						pstmt.setString	( 3, p_curr_file_status) ;
						pstmt.setString	( 4, p_curr_fs_locn_code) ;
						pstmt.setString	( 5, p_curr_facility_id) ;
						pstmt.setString	( 6, p_req_to_facility_id) ;
						pstmt.setString	( 7, p_req_to_fs_locn_code) ;
						pstmt.setString ( 8, addedById ) ;
						pstmt.setString	( 9, addedAtWorkstation ) ;
						pstmt.setString	( 10, p_req_facility_id ) ;
						pstmt.setString	( 11, modifiedById ) ;
						pstmt.setString	( 12,modifiedAtWorkstation) ;
						pstmt.setString	( 13,p_req_facility_id) ;						
						String req_rem = "";
					//	if(!remarks[count].equals(":|:"))
						if(!remarks[count].equals("#"))
							req_rem = remarks[count];
						pstmt.setString	( 14,req_rem) ;
						pstmt.setString	( 15,parient_file_type) ;
						pstmt.setString	( 16,p_volume_no) ;
						pstmt.setString	( 17,patient_id) ;
						pstmt.setString	( 18,p_doc_folderid) ;
						pstmt.setString	( 19,p_doc_typecode) ;
							if (file_required_on.equals("#"))
						{
							pstmt.setString	( 20,"") ;
						}
						else
						{
							if(!locale.equals("en"))
							{
							file_required_on= DateUtils.convertDate(file_required_on,"DMYHM",locale,"en");
							}
							pstmt.setString	( 20,file_required_on) ;
						}
						ins_req_dtl = pstmt.executeUpdate() ;

			//////////////////////////////////////////////////////////////////////

					}
					count++;
				}
			}
			
			if(ins_req_dtl != 0)
			{
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED , "SM" ) ;
				sb.append( (String) message.get("message") ) ;
				con.commit();
				message.clear();
			}
			hashmap.clear();
			if(rs!=null)  rs.close();
			if(stmt!=null)  stmt.close();
			if(pstmt!=null)  pstmt.close();
			if(pstmt1!=null)  pstmt1.close();
		}
		catch(Exception e)
		{
			sb.append( e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
			try
			{
				con.rollback();
			}catch (Exception ce){
			sb.append( "While Rollback:" + ce.getMessage() + "<br>" ) ;
			}
		}
		finally
		{
			ConnectionManager.returnConnection(con,p);
		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "p_req_no",p_req_no) ;
		return results ;
	}
}

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM.FMReceiveFileAtMRD;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.rmi.RemoteException;
import java.util.*;
import webbeans.eCommon.*;




/**
*
* @ejb.bean
*	name="FMReceiveFileAtMRD"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FMReceiveFileAtMRD"
*	local-jndi-name="FMReceiveFileAtMRD"
*	impl-class-name="eFM.FMReceiveFileAtMRD.ReceiveFileAtMRDManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eFM.FMReceiveFileAtMRD.ReceiveFileAtMRDLocal"
*	remote-class="eFM.FMReceiveFileAtMRD.ReceiveFileAtMRDRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eFM.FMReceiveFileAtMRD.ReceiveFileAtMRDLocalHome"
*	remote-class="eFM.FMReceiveFileAtMRD.ReceiveFileAtMRDHome"
*	generate= "local,remote"
*
*
*/

public class ReceiveFileAtMRDManager implements SessionBean 
{

	Connection con					= null;
	PreparedStatement pstmt			= null;
	PreparedStatement pstmt3		= null;
	PreparedStatement pstmt4		= null;
	PreparedStatement pstmt6		= null;
	PreparedStatement pstmt7		= null;
	PreparedStatement pstmt8		= null;
	
	public final String RECORD_INSERTED	= "RECORD_INSERTED";
	
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext ctx ) {}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	

	public java.util.HashMap insertReceiveFileAtMRD(	
			java.util.Properties p,
			java.util.HashMap hashmap
			) 
	{
		con				= ConnectionManager.getConnection(p);
		Statement stmt	= null;
		ResultSet rs1	= null;
		ResultSet rs2	= null;

		java.util.HashMap results = new java.util.HashMap() ;

		boolean result		= false ;
	
		int ins_req_hdr = 0;
		int ins_req_dtl = 0;
		int upd_req_dtl = 0;
		
		String fm_parameter					= "";
		String file_stat					= "";
		String accept_out_intransit_yn		= "";
		String sql							= "";
		String sql3							= "";
		String sql4							= "";
		String sql6							= "";
		String sql7							= "";
		String p_file_no					= "";
		String p_volume_no					= "";
		String file_type_code				= "";
		String curr_file_status				= "";
		String p_fs_locn_code				= "";
		String p_curr_file_status			= "";
		//String p_deceased_yn				= "";
		String last_movement_date_time		= "";
		String curr_locn_id					= "";
		//String p_return_date_time			= "";
		String p_returned_by				= "";					         
		String p_narration					= "";
		String p_file_nos					= "";
		String p_facility_id				= "";
		String addedAtWorkstation			= "";
		String mrd_receipt_remarks			= "";
		String src_facility_id    = "";
		String src_fs_locn_code   = "";
		String src_locn_identity  = "";
		String src_user_id        = "";
		String dest_facility_id   = "";
		String dest_locn_identity = "";
		String src_mr_locn_yn = "";
		String patient_id = "";
		String p_outst_facility="";
		String pat_id="";
			String flagvalue="false";
				int count = 0;
		//String dflt_archive_fs_locn_code	= "";
		String locale					= p.getProperty("LOCALE");
		StringBuffer sb	= new StringBuffer("");
		
		try
		{
			//p_return_date_time			= (String) hashmap.get("p_return_date_time");
			//p_outst_facility			= (String) hashmap.get("p_outst_facility");
			p_returned_by				= (String) hashmap.get("p_returned_by");
			p_narration					= (String) hashmap.get("p_narration");
			p_file_nos					= (String) hashmap.get("p_file_nos");
			p_facility_id					= (String) hashmap.get("facilityId");
			addedAtWorkstation			= (String) hashmap.get("client_ip_address");
			mrd_receipt_remarks			= (String) hashmap.get("mrd_receipt_remarks");
			//dflt_archive_fs_locn_code	= (String) hashmap.get("dflt_archive_fs_locn_code");
			file_stat = (String) hashmap.get("file_stat");			
				  
          
			StringTokenizer token	= new StringTokenizer(p_file_nos,"|");
			//StringTokenizer stringtokenizer1 = new StringTokenizer(mrd_receipt_remarks, "¡");
			StringTokenizer stringtokenizer1 = new StringTokenizer(mrd_receipt_remarks, "~");
			
			
			String receipt[]	= null;
			receipt				= new String[stringtokenizer1.countTokens()];
			for(int m = 0; m < receipt.length; m++)
			{
				receipt[m] = stringtokenizer1.nextToken();
			}
		
			stmt = con.createStatement();

			String addedById				= p.getProperty( "login_user" ) ;
			String modifiedById				= addedById ;
			String modifiedAtWorkstation	= addedAtWorkstation ;		
    		String outerToken = "";
			StringTokenizer innerToken = null;

			fm_parameter="select accept_out_intransit_yn from fm_parameter where facility_id='"+p_facility_id+"'";
			pstmt8=con.prepareStatement(fm_parameter);
			
			rs2 = pstmt8.executeQuery();

			if(rs2.next())
			{
				accept_out_intransit_yn=rs2.getString("accept_out_intransit_yn");
			}
			if(accept_out_intransit_yn == null)
				accept_out_intransit_yn="N";
		
			
			/*
			if(file_stat.equals("R"))
			{
				sql = "SELECT a.facility_id, TO_CHAR(a.last_movement_date_time, 'dd/mm/rrrr hh24:mi') last_movement_date_time, a.file_type_code,  a.curr_locn_id, a.perm_fs_locn_code fs_locn_code, d.deceased_yn FROM fm_curr_locn a, fm_storage_locn b, fm_storage_locn c, mp_patient d WHERE a.curr_facility_id = ? AND a.curr_file_status = 'R' AND  a.file_no = ? AND a.volume_no = ? AND a.curr_facility_id = b.facility_id AND a.curr_fs_locn_code = b.fs_locn_code AND a.facility_id = c.facility_id AND a.perm_fs_locn_code = c.fs_locn_code and a.patient_id = d.patient_id" ;
				pstmt = con.prepareStatement(sql);
			}
			else
			{
				*/
				sql = "SELECT a.facility_id , TO_CHAR(a.last_movement_date_time, 'dd/mm/rrrr hh24:mi') last_movement_date_time   , a.file_type_code , a.curr_locn_id , a.perm_fs_locn_code fs_locn_code  ,a.curr_facility_id  src_facility_id ,a.curr_fs_locn_code  src_fs_locn_code ,a.curr_fs_locn_identity  src_locn_identity ,a.curr_holder_user_id src_user_id  , a.facility_id dest_facility_id , a.curr_file_status curr_file_status, b.locn_identity  dest_locn_identity ,a.mr_locn_yn src_mr_locn_yn,a.patient_id FROM fm_curr_locn a , fm_storage_locn b , fm_storage_locn c WHERE  a.patient_id = ? and a.curr_facility_id = ?  AND (a.curr_file_status = 'O' OR a.curr_file_status = 'T' OR a.curr_file_status ='E' OR a.curr_file_status = 'R') AND a.file_no = ? AND a.volume_no = ? AND a.curr_facility_id = b.facility_id AND a.curr_fs_locn_code = b.fs_locn_code AND a.facility_id = c.facility_id AND a.perm_fs_locn_code = c.fs_locn_code " ;
				pstmt = con.prepareStatement(sql);
					
			//}
		           

			sql3 ="DELETE FROM fm_transit_file WHERE facility_id = ? AND file_no = ? AND volume_no = ? and patient_id=? ";
			pstmt3 = con.prepareStatement(sql3);

			/*
			
			if(file_stat.equals("R"))
			{
				sql4 = " UPDATE fm_movement_log SET rec_date_time = sysdate, dest_mr_locn_yn = 'Y', dest_user_id = ?, narration_code = ?, mrd_receipt_remarks = ?, modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ?  WHERE facility_id = ? AND file_no = ? AND volume_no = ? AND TO_CHAR(sent_date_time, 'DD/MM/RRRR HH24:MI') = ? ";
				pstmt4 = con.prepareStatement(sql4);
			}
			else
			{
				sql4 = "INSERT INTO fm_movement_log (facility_id, file_no, sent_date_time, patient_id, src_facility_id, src_fs_locn_code, src_locn_identity, src_user_id, dest_facility_id, rec_date_time, dest_fs_locn_code, dest_locn_identity,  dest_user_id, narration_code, movement_narration, movement_type, src_mr_locn_yn, dest_mr_locn_yn, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,mrd_receipt_remarks, file_type_code, volume_no,SRC_LOCN_ID) VALUES (?, ?, sysdate, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, '', 'T', ?, 'Y', ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?, ?, ?,?) ";
				pstmt4 = con.prepareStatement(sql4);
			}

			*/			

            /*Blow query modified for this CRF HSA-CRF-0306.1*/			

			sql6 = "UPDATE FM_CURR_LOCN SET CURR_FILE_STATUS=?,CURR_FS_LOCN_CODE=?,NARRATION_CODE=?,CURR_FACILITY_ID=?,LAST_MOVEMENT_DATE_TIME=SYSDATE,RETURN_DATE_TIME='',ISS_DATE_TIME='',MR_LOCN_YN='Y',MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,PREV_FACILITY_ID=CURR_FACILITY_ID,PREV_FS_LOCN_CODE=CURR_FS_LOCN_CODE,CURR_FS_LOCN_IDENTITY='D', REQ_REMARKS ='',REMARKS=null, PREV_LOCN_ID =?, CURR_LOCN_ID = '', return_date_manual_yn='N', transfer_rdd_yn='N' WHERE FACILITY_ID = ? AND FILE_NO = ? AND VOLUME_NO = ? ";
			pstmt6 = con.prepareStatement(sql6);

			sql7 = "Update FM_REQ_DTL SET CURR_FACILITY_ID = ?, CURR_FS_LOCN_CODE = ?, CURR_FILE_STATUS = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?, FILE_TYPE_CODE = ? Where FILE_NO = ? AND REQ_TO_FACILITY_ID = ? AND ISS_YN = 'N'";
			pstmt7 = con.prepareStatement(sql7);
			
		
		
			while(token.hasMoreTokens())
			{
				p_curr_file_status		= "I";
				outerToken	= token.nextToken();
				innerToken	= new StringTokenizer(outerToken, "$$"); 
				while(innerToken.hasMoreTokens())
				{
					p_file_no	= innerToken.nextToken();
					if(innerToken.hasMoreTokens())
					p_volume_no = innerToken.nextToken();
				   if(innerToken.hasMoreTokens())
					p_outst_facility = innerToken.nextToken();
					 if(innerToken.hasMoreTokens())
					pat_id = innerToken.nextToken();
						
				
				}				
		/////////////////////////////////////////////////////////////////////////////
					
				pstmt.setString(1,pat_id);			
				pstmt.setString(2,p_outst_facility);
				pstmt.setString(3,p_file_no);
				pstmt.setString(4,p_volume_no);
				
				rs1 = pstmt.executeQuery();
			
				//if(file_stat.equals("R"))
				//{
					while(rs1 !=null && rs1.next())
					{
						curr_file_status = rs1.getString("curr_file_status")== null?"":rs1.getString("curr_file_status");

						file_type_code			= rs1.getString("file_type_code");
						last_movement_date_time	= rs1.getString("last_movement_date_time");
						curr_locn_id			= rs1.getString("curr_locn_id");
						p_facility_id			= rs1.getString("facility_id");
						p_fs_locn_code			= rs1.getString("fs_locn_code");
						//if(!curr_file_status.equals("R")) {

							src_facility_id = rs1.getString("src_facility_id");
							src_fs_locn_code = rs1.getString("src_fs_locn_code");
							src_locn_identity = rs1.getString("src_locn_identity");
							src_user_id = rs1.getString("src_user_id");
							dest_facility_id = rs1.getString("dest_facility_id");
							dest_locn_identity = rs1.getString("dest_locn_identity");
							src_mr_locn_yn = rs1.getString("src_mr_locn_yn");
							patient_id = rs1.getString("patient_id");

							if(src_facility_id==null)
								src_facility_id="";	
							if(src_fs_locn_code==null)
								src_fs_locn_code="";
							if(src_locn_identity== null)
								src_locn_identity="";
							if(src_user_id==null)
								src_user_id="";
							if(dest_facility_id == null)
								dest_facility_id="";
							if(dest_locn_identity == null)
								dest_locn_identity="";
							if(src_mr_locn_yn == null)
								src_mr_locn_yn="";
							if(patient_id==null)
								patient_id="";
						//}			


						//p_deceased_yn			= rs1.getString("deceased_yn");
					
					}
				/*
				}
				else
				{
					while(rs1 !=null && rs1.next())
					{
						file_type_code			= rs1.getString("file_type_code");
						last_movement_date_time	= rs1.getString("last_movement_date_time");
						curr_locn_id			= rs1.getString("curr_locn_id");
						p_facility_id			= rs1.getString("facility_id");
						p_fs_locn_code			= rs1.getString("fs_locn_code");
						src_facility_id = rs1.getString("src_facility_id");
						src_fs_locn_code = rs1.getString("src_fs_locn_code");
						src_locn_identity = rs1.getString("src_locn_identity");
						src_user_id = rs1.getString("src_user_id");
						dest_facility_id = rs1.getString("dest_facility_id");
						dest_locn_identity = rs1.getString("dest_locn_identity");
						src_mr_locn_yn = rs1.getString("src_mr_locn_yn");
						patient_id = rs1.getString("patient_id");
	
					} 
						if(src_facility_id==null)
							src_facility_id="";	
						if(src_fs_locn_code==null)
							src_fs_locn_code="";
						if(src_locn_identity== null)
							src_locn_identity="";
						if(src_user_id==null)
							src_user_id="";
						if(dest_facility_id == null)
							dest_facility_id="";
						if(dest_locn_identity == null)
							dest_locn_identity="";
						if(src_mr_locn_yn == null)
							src_mr_locn_yn="";
						if(patient_id==null)
							patient_id="";

				}
				*/
				if(rs1 != null) rs1.close(); 
			
			//	if(file_stat.equals("R"))
				//if(file_stat.equals("R") || file_stat.equals("T"))
			//Incident NO-29472	 ---start by Srinivas Y
		System.out.println("patient_id--->"+patient_id);				
		System.out.println("p_facility_id--->"+p_facility_id);				
		System.out.println("p_volume_no--->"+p_volume_no);				
		System.out.println("p_file_no--->"+p_file_no);				
		System.out.println("curr_file_status--->"+curr_file_status);	
		//Incident NO-29472--ends by Srinivas Y
				if(!patient_id.equals("") && !p_facility_id.equals(""))
				{
				if(curr_file_status.equals("R") || curr_file_status.equals("T") || curr_file_status.equals("E"))
				{
					
					pstmt3.setString	( 1, p_facility_id ) ;
					pstmt3.setString	( 2, p_file_no ) ;
					pstmt3.setString	( 3, p_volume_no ) ;
				   pstmt3.setString	( 4, pat_id) ;
			     	ins_req_hdr = pstmt3.executeUpdate() ;
					//Incident NO-29472---start by Srinivas Y
					System.out.println("ins_req_hdr-->"+ins_req_hdr);
					System.out.println("ReceiveFileAtMRDManager---p_file_no-->"+p_file_no);
					System.out.println("ReceiveFileAtMRDManager---p_volume_no-->"+p_volume_no);
					System.out.println("ReceiveFileAtMRDManager---pat_id-->"+pat_id);
			        System.out.println("ReceiveFileAtMRDManager---sql3-->"+sql3); 
			       //Incident NO-29472----ends by Srinivas Y
					sql4 = " UPDATE fm_movement_log SET rec_date_time = sysdate, dest_mr_locn_yn = 'Y', dest_user_id = ?, narration_code = ?, mrd_receipt_remarks = ?, modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ?  WHERE facility_id = ? AND file_no = ? AND volume_no = ? AND TO_CHAR(sent_date_time, 'DD/MM/RRRR HH24:MI') = ? ";
			
					pstmt4 = con.prepareStatement(sql4);
				   	 flagvalue="true";
							
				}
				else
				{
					 // since in this case there wont be any file in  fm_transit_file table. manually making value of ins_req_hdr as 1
					 ins_req_hdr=1;

					 sql4 = "INSERT INTO fm_movement_log (facility_id, file_no, sent_date_time, patient_id, src_facility_id, src_fs_locn_code, src_locn_identity, src_user_id, dest_facility_id, rec_date_time, dest_fs_locn_code, dest_locn_identity,  dest_user_id, narration_code, movement_narration, movement_type, src_mr_locn_yn, dest_mr_locn_yn, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,mrd_receipt_remarks, file_type_code, volume_no,SRC_LOCN_ID) VALUES (?, ?, sysdate, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, '', 'T', ?, 'Y', ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?, ?, ?,?) ";

					 pstmt4 = con.prepareStatement(sql4);
					 	flagvalue="true";
				}
						
				} else {

             flagvalue="false";
					}
		
		/////////////////////////////////////////////////////////////////////////////
			System.out.println("ins_req_hdr--111->"+ins_req_hdr); //IncidentNO-29472						
				if(ins_req_hdr > 0)
				{
					
					ins_req_hdr = 0;
					
					String ret_rem = "";
					if(!receipt[count].equals(":|:") && !receipt[count].equals("#"))
					 ret_rem = receipt[count];
		/////////////////////////////////////////////////////////////////////////////

                     System.out.println("curr_file_status 111--->"+curr_file_status);							
					//if(file_stat.equals("R"))
					if(curr_file_status.equals("R") || curr_file_status.equals("T") || curr_file_status.equals("E"))
					{				
						pstmt4.setString( 1, p_returned_by ) ;
						pstmt4.setString( 2, p_narration ) ;
						pstmt4.setString( 3, ret_rem ) ;
						pstmt4.setString( 4, modifiedById ) ;
						pstmt4.setString( 5, modifiedAtWorkstation ) ;
						pstmt4.setString( 6, p_facility_id ) ;
						pstmt4.setString( 7, p_facility_id ) ;
						pstmt4.setString( 8, p_file_no ) ;
						pstmt4.setString( 9, p_volume_no ) ;
						pstmt4.setString( 10, last_movement_date_time ) ;
						}
					else
					{

						pstmt4.setString( 1, p_facility_id ) ;
						pstmt4.setString( 2, p_file_no ) ;
						pstmt4.setString( 3, patient_id ) ;
						pstmt4.setString( 4, src_facility_id ) ;
						pstmt4.setString( 5, src_fs_locn_code ) ;
						pstmt4.setString( 6, src_locn_identity ) ;
						pstmt4.setString( 7, src_user_id ) ;
						pstmt4.setString( 8, dest_facility_id ) ;
						pstmt4.setString( 9, p_fs_locn_code ) ;
						pstmt4.setString( 10, "D" ) ;
						pstmt4.setString( 11, p_returned_by ) ;
						pstmt4.setString( 12, p_narration ) ;
						pstmt4.setString( 13, src_mr_locn_yn ) ;
						pstmt4.setString( 14, addedById ) ;
						pstmt4.setString( 15, modifiedAtWorkstation ) ;
						pstmt4.setString( 16, p_facility_id ) ;
						pstmt4.setString( 17, addedById ) ;
						pstmt4.setString( 18,  modifiedAtWorkstation) ;
						pstmt4.setString( 19,  p_facility_id) ;
						pstmt4.setString( 20,  ret_rem) ;
						pstmt4.setString( 21,  file_type_code) ;
						pstmt4.setString( 22,  p_volume_no) ;
						pstmt4.setString( 23,  curr_locn_id) ;
					}
					 
					 
				
					ins_req_hdr = pstmt4.executeUpdate() ;						
				System.out.println("ins_req_hdr---222--->"+ins_req_hdr);//Incident NO-29472	
				if(pstmt4!=null) pstmt4.close();
		/////////////////////////////////////////////////////////////////////////////
					if(ins_req_hdr > 0 )
					{
						/*if(p_deceased_yn.equals("Y"))
						{
							p_fs_locn_code = dflt_archive_fs_locn_code;	
							p_curr_file_status = "A";
						}*/						
		////////////////////////////////////////////////////////////////////////////////
            							
						pstmt6.setString	( 1, p_curr_file_status) ;
						pstmt6.setString	( 2, p_fs_locn_code ) ;
						pstmt6.setString	( 3, p_narration ) ;
						pstmt6.setString	( 4, p_facility_id ) ;
						pstmt6.setString	( 5, modifiedById ) ;
						pstmt6.setString	( 6, modifiedAtWorkstation ) ;
						pstmt6.setString	( 7, p_facility_id ) ;
						pstmt6.setString	( 8, curr_locn_id ) ;
						pstmt6.setString	( 9, p_facility_id ) ;
						pstmt6.setString	( 10, p_file_no ) ;
						pstmt6.setString	( 11, p_volume_no ) ;
						
						ins_req_dtl = pstmt6.executeUpdate() ;
						//Incident NO-29472 --start by Srinivas Y
						System.out.println("ins_req_dtl--->"+ins_req_dtl);
						System.out.println("p_file_no--->"+p_file_no);
						System.out.println("p_volume_no--->"+p_volume_no);
						System.out.println("p_curr_file_status 333--->"+p_curr_file_status);
                        System.out.println("ReceiveFileAtMRDManager---sql6--->"+sql6);
						//Incident NO-29472	--ends	by Srinivas Y		

		/////////////////////////////////////////////////////////////////////////////

						pstmt7.setString	( 1, p_facility_id ) ;
						pstmt7.setString	( 2, p_fs_locn_code ) ;
						pstmt7.setString	( 3, p_curr_file_status ) ;
						pstmt7.setString	( 4, modifiedById ) ;
						pstmt7.setString	( 5, modifiedAtWorkstation ) ;
						pstmt7.setString	( 6, p_facility_id ) ;
						pstmt7.setString	( 7, file_type_code ) ;
						pstmt7.setString	( 8, p_file_no ) ;
						pstmt7.setString	( 9, p_facility_id ) ;
						
						upd_req_dtl = pstmt7.executeUpdate() ;	
				System.out.println("upd_req_dtl 444--->"+upd_req_dtl);	//Incident NO-29472	
							
					
		/////////////////////////////////////////////////////////////////////////////	
		
					}
				}
									
				count++;
				
			}
		
               System.out.println("count --->"+count);	//Incident NO-29472
               System.out.println("flagvalue --->"+flagvalue);	//Incident NO-29472
			
		    	
			if(count ==1 && flagvalue.equals("false")  ) {

             	result = false ;
				java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_ALREADY_MODI","FM");
				sb.append( (String) message.get("message")) ;
				con.commit();
				message.clear();
			} 
			else {
								
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale, RECORD_INSERTED, "SM" ) ;
				sb.append( (String) message.get("message") ) ;
				con.commit();
				message.clear();
			} 
				
			hashmap.clear();
			if(rs1   !=null)    rs1.close();
			if(rs2   !=null)    rs2.close();
			if(stmt !=null)    stmt.close();
			if(pstmt !=null)   pstmt.close();
			if(pstmt3 !=null)  pstmt3.close();
			if(pstmt4 !=null)  pstmt4.close();
			if(pstmt6 !=null)  pstmt6.close();
			if(pstmt7 !=null)  pstmt7.close();
			if(pstmt8 !=null)  pstmt8.close();
		}catch(Exception e)
		{	
			sb.append("Exception in Main Try Block e :" + e.getMessage() + "<br>" ) ;
			e.printStackTrace();
			try
			{
				con.rollback();
			}catch(Exception ce){
				sb.append("Exception while Rollback :"+ ce.getMessage());	ce.printStackTrace();			
				}
		}
		finally
		{
			ConnectionManager.returnConnection(con,p);		
		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
}

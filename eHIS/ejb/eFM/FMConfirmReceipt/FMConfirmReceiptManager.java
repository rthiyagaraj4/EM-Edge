/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM.FMConfirmReceipt;

import javax.ejb.* ;

import java.sql.*;
import java.rmi.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import webbeans.eCommon.*;
import eCommon.Common.*;

/**
*
* @ejb.bean
*	name="FMConfirmReceipt"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="FMConfirmReceipt"
*	local-jndi-name="FMConfirmReceipt"
*	impl-class-name="eFM.FMConfirmReceipt.FMConfirmReceiptManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eFM.FMConfirmReceipt.FMConfirmReceiptLocal"
*	remote-class="eFM.FMConfirmReceipt.FMConfirmReceiptRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eFM.FMConfirmReceipt.FMConfirmReceiptLocalHome"
*	remote-class="eFM.FMConfirmReceipt.FMConfirmReceiptHome"
*	generate= "local,remote"
*
*
*/

public class FMConfirmReceiptManager implements SessionBean
{
	Connection con ;
	PreparedStatement pstmt1 ;
	PreparedStatement pstmt2 ;
	PreparedStatement pstmt3 ;
	PreparedStatement pstmt4 ;
	PreparedStatement pstmt5 ;
	ResultSet rset			= null;
	PreparedStatement pstmt=null;
	
	//Added for this CRF HSA-CRF-0306.1	
	CallableStatement cstmt = null;
	boolean siteSpecific=false;
		
	PreparedStatement pstmt6=null ;
	ResultSet movementtyperset = null;
	
	PreparedStatement pstmt7 = null; 
	
	//End HSA-CRF-0306.1	
	

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

	public java.util.HashMap createConfirmReceipt(
							java.util.Properties p,
							java.util.HashMap htconfirmReceipt
						 ) 
		{
		StringBuffer sb = new StringBuffer( "" ) ;
		java.util.HashMap results = new java.util.HashMap() ;

		boolean result = false ;		
		int upd_move_dtl	= 0;
		int upd_curr_locn	= 0;
		int del_transit		= 0;
	
		String sql1   ="";
		String sql2   ="";
		String sql3   ="";
		String sql4   ="";
		String sql5   ="";
		String p_iss_locn_code  = "";
		String p_rec_locn_code  = "";
		String p_rec_locn_iden  = "";
		String p_rec_name       = "";
		String p_file_no        = "";
		String p_volume_no      = "";
		String p_curr_file_stat = "";
		String login_facility_id   = "";
		String login_user_id       = "";
		String addedAtWorkstation  = "";
		String file_nos			   = "";
		String volume_nos   	   = "";
		String issue_locns	       = "";		
		String locale	       = "";	
		String sender_facility = "";
		String p_sender_facility=""; 
		String p_curr_locn_id="",p_fs_curr_locn_id=""; //Added for this CRF HSA-CRF-0306.1
		String p_patientid="", p_patient_id=""; //Added for this CRF HSA-CRF-0306.1
		
		String sql6   =""; //Added for this CRF HSA-CRF-0306.1
		String file_movement_type="";//Added for this CRF HSA-CRF-0306.1
		String sql7     = ""; //Added for this CRF HSA-CRF-0306.1
		
		String mySql="";
		String permanent_file_area_yn="";
        String perm_fs_locn_code="";
		con = ConnectionManager.getConnection(p);
	
		try
		{
			login_facility_id	= (String) htconfirmReceipt.get ( "login_facility_id" );
			login_user_id		= (String) htconfirmReceipt.get ( "login_user_id" );
			addedAtWorkstation	= (String) htconfirmReceipt.get ( "addedAtWorkstation" );
			file_nos			= (String) htconfirmReceipt.get ( "file_nos" );
			volume_nos			= (String) htconfirmReceipt.get ( "volume_nos" );
			issue_locns			= (String) htconfirmReceipt.get ( "issue_locns" );
			p_rec_locn_code		= (String) htconfirmReceipt.get ( "rec_locn_code" );
			p_rec_locn_iden		= (String) htconfirmReceipt.get ( "rec_locn_iden" );
			p_rec_name			= (String) htconfirmReceipt.get ( "rec_user_id" );			
			locale			= (String) htconfirmReceipt.get ( "locale" );	
			sender_facility     = (String) htconfirmReceipt.get ( "sender_facility" );
			
			p_curr_locn_id = (String) htconfirmReceipt.get ( "fs_curr_locn_id" );
			p_patientid = (String) htconfirmReceipt.get ( "patientid" );
			
			
			siteSpecific=CommonBean.isSiteSpecific(con,"FM","CURRENT_FS_LOCATION"); //Added for this CRF HSA-CRF-0306

			mySql = "SELECT permanent_file_area_yn from fm_storage_locn where FS_LOCN_CODE = '"+p_rec_locn_code+"'";
		
			pstmt = con.prepareStatement(mySql);
			rset = pstmt.executeQuery();
			if(rset != null && rset.next())  {
				permanent_file_area_yn	= rset.getString("permanent_file_area_yn");			
			}
			if(rset!=null)	rset.close();		
			if(pstmt!=null)  pstmt.close();
			

		//	if(p_rec_locn_iden.equals("D") && permanent_file_area_yn.equals("Y") )p_curr_file_stat = "I";
		//	else 
			StringTokenizer token  =new StringTokenizer(file_nos,"|");
			StringTokenizer token1 =new StringTokenizer(issue_locns,"|");
			StringTokenizer token3 =new StringTokenizer(volume_nos,"|");
			StringTokenizer token4 =new StringTokenizer(sender_facility,"|");
			
			StringTokenizer token5=new StringTokenizer(p_curr_locn_id,"|");//Added for this CRF HSA-CRF-0306.1
			StringTokenizer token6=new StringTokenizer(p_patientid,"|");//Added for this CRF HSA-CRF-0306.1 

			sql4 = "Update FM_REQ_DTL SET CURR_FACILITY_ID = ?, CURR_FS_LOCN_CODE = ?, CURR_FILE_STATUS = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? Where FILE_NO = ? AND CURR_FACILITY_ID = ? AND ISS_YN = 'N' AND VOLUME_NO = ? ";
			pstmt4 = con.prepareStatement(sql4);

			sql1 = "Update FM_CURR_LOCN SET CURR_FILE_STATUS = ?, CURR_FS_LOCN_CODE = ?, CURR_FS_LOCN_IDENTITY = ?, CURR_HOLDER_USER_ID = ?,  LAST_MOVEMENT_DATE_TIME = SYSDATE, PREV_FACILITY_ID = ?, PREV_FS_LOCN_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?  ,CURR_FACILITY_ID = ? Where  FILE_NO = ? AND VOLUME_NO = ?";
			pstmt1 = con.prepareStatement(sql1);

			sql2 = "Update FM_MOVEMENT_LOG SET REC_DATE_TIME = SYSDATE, DEST_USER_ID = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? Where DEST_FACILITY_ID = ? and FILE_NO = ? AND REC_DATE_TIME IS NULL AND VOLUME_NO = ? ";
			pstmt2 = con.prepareStatement(sql2);

			sql3 = "DELETE FROM FM_TRANSIT_FILE WHERE DEST_FACILITY_ID = ? AND FILE_NO = ? AND VOLUME_NO = ?";
			pstmt3 = con.prepareStatement(sql3);
           sql5 = "SELECT PERM_FS_LOCN_CODE FROM FM_CURR_LOCN Where  FILE_NO = ? AND VOLUME_NO = ? ";
			pstmt5 = con.prepareStatement(sql5);
			
			//Added for this CRF HSA-CRF-0306.1
	sql6 ="select movement_type from fm_movement_log where facility_id =? AND  FILE_NO=? AND VOLUME_NO =? AND SENT_DATE_TIME IN (SELECT MAX (SENT_DATE_TIME)  FROM fm_movement_log WHERE facility_id =? and  FILE_NO=? AND VOLUME_NO =?)";
	pstmt6 = con.prepareStatement(sql6);
	
	
		//Added for this CRF HSA-CRF-0306.1
			sql7 = "Update FM_CURR_LOCN SET  REC_RETURN_DATE_TIME=SYSDATE, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? Where Facility_id = ? AND File_no = ? AND VOLUME_NO = ?";
			pstmt7 = con.prepareStatement( sql7 );
			
			
			while(token.hasMoreTokens())
			{
				p_file_no        = token.nextToken();
				p_iss_locn_code  = token1.nextToken();
				p_volume_no      = token3.nextToken();
				p_sender_facility= token4.nextToken();				
				p_fs_curr_locn_id = token5.nextToken(); //Added for this CRF HSA-CRF-0306.1
                p_patient_id = token6.nextToken(); //Added for this CRF HSA-CRF-0306.1				
				
				if(p_file_no == null || p_file_no.equals("null")) p_file_no = "";
				if(p_volume_no == null || p_volume_no.equals("null")) p_volume_no = "";
				if(p_sender_facility == null || p_sender_facility.equals("null")) p_sender_facility = "";
				
				if(p_fs_curr_locn_id == null || p_fs_curr_locn_id.equals("null")) p_fs_curr_locn_id = ""; //Added for this CRF HSA-CRF-0306.1
                if(p_patient_id == null || p_patient_id.equals("null")) p_patient_id = ""; //Added for this CRF HSA-CRF-0306.1 				

               // pstmt5.setString ( 1, login_facility_id) ;
				pstmt5.setString ( 1, p_file_no) ;
				pstmt5.setString ( 2, p_volume_no) ;
				rset = pstmt5.executeQuery();
			   if(rset != null && rset.next())  {
				perm_fs_locn_code	= rset.getString("PERM_FS_LOCN_CODE");			
			   }
			   if(rset!=null)	rset.close();	
	      			 
			 if(p_rec_locn_code.equals(perm_fs_locn_code))
				{
				p_curr_file_stat="I";
				
				} else{
                 p_curr_file_stat = "O";
				
				}
		
		/////////////////////////////////////////////////////////////
				pstmt4.setString ( 1, login_facility_id) ;
				pstmt4.setString ( 2, p_rec_locn_code) ;
				pstmt4.setString ( 3, p_curr_file_stat) ;
				pstmt4.setString ( 4, login_user_id ) ;
				pstmt4.setString ( 5, addedAtWorkstation) ;
				pstmt4.setString ( 6, login_facility_id) ;
				pstmt4.setString ( 7, p_file_no) ;
				pstmt4.setString ( 8, login_facility_id) ;
				pstmt4.setString ( 9, p_volume_no) ;
				
				pstmt4.executeUpdate() ;

		/////////////////////////////////////////////////////////////			
				pstmt1.setString ( 1, p_curr_file_stat) ;
				pstmt1.setString ( 2, p_rec_locn_code) ;
				pstmt1.setString ( 3, p_rec_locn_iden) ;
				pstmt1.setString ( 4, p_rec_name) ;
				pstmt1.setString ( 5, p_sender_facility) ;
				pstmt1.setString ( 6, p_iss_locn_code) ;
				pstmt1.setString ( 7, login_user_id ) ;
				pstmt1.setString ( 8, addedAtWorkstation) ;
				pstmt1.setString ( 9, login_facility_id) ;
				pstmt1.setString ( 10, login_facility_id) ;
				pstmt1.setString ( 11, p_file_no) ;
				pstmt1.setString ( 12, p_volume_no) ;
				
				upd_curr_locn = pstmt1.executeUpdate() ;
				//Incident NO-29472	starts by Srinivas Y
				System.out.println("upd_curr_locn------------"+upd_curr_locn);
				System.out.println("FMConfirmReceiptManager-----p_curr_file_stat-------"+p_curr_file_stat);
				System.out.println("FMConfirmReceiptManager-----p_file_no-------"+p_file_no);
				System.out.println("FMConfirmReceiptManager------p_volume_no------"+p_volume_no);
                System.out.println("FMConfirmReceiptManager------sql1------"+sql1);
				//Incident NO-29472 ends by Srinivas Y
		/////////////////////////////////////////////////////////////				
				pstmt2.setString	( 1, p_rec_name ) ;
				pstmt2.setString	( 2, login_user_id ) ;
				pstmt2.setString	( 3, addedAtWorkstation ) ;
				pstmt2.setString	( 4, login_facility_id ) ;
				pstmt2.setString	( 5, login_facility_id) ;
				pstmt2.setString	( 6, p_file_no) ;
				pstmt2.setString	( 7, p_volume_no) ;
				
				upd_move_dtl = pstmt2.executeUpdate() ;

		/////////////////////////////////////////////////////////////				
				pstmt3.setString ( 1, login_facility_id) ;
				pstmt3.setString ( 2, p_file_no) ;
				pstmt3.setString ( 3, p_volume_no) ;

				del_transit = pstmt3.executeUpdate() ;
				//Incident NO-29472  starts by Srinivas Y
				System.out.println("del_transit------"+del_transit);
				System.out.println("FMConfirmReceiptManager----sql3------"+sql3);
				System.out.println("FMConfirmReceiptManager-----p_file_no-------"+p_file_no);
				System.out.println("FMConfirmReceiptManager------p_volume_no------"+p_volume_no);
				//Incident NO-29472  ends by Srinivas Y
		/////////////////////////////////////////////////////////////	
        
            	/*Below line added for this  HSA-CRF-0306.1*/				
							
			
			 System.err.println("FMConfirmReceiptManager.javaFMConfirmReceiptManager.java siteSpecific===>"+siteSpecific);
			 System.err.println("FMConfirmReceiptManager.javaFMConfirmReceiptManager.java p_rec_locn_code===>"+p_rec_locn_code);
			 System.err.println("FMConfirmReceiptManager.javaFMConfirmReceiptManager.java p_sender_facility===>"+p_sender_facility);
			 System.err.println("FMConfirmReceiptManager.javaFMConfirmReceiptManager.java p_patient_id===>"+p_patient_id);
			 System.err.println("FMConfirmReceiptManager.javaFMConfirmReceiptManager.java p_fs_curr_locn_id===>"+p_fs_curr_locn_id);
			 
               if(siteSpecific){ 
					con.commit();	

                pstmt6.setString ( 1, login_facility_id) ;
				pstmt6.setString ( 2, p_file_no) ;
				pstmt6.setString ( 3, p_volume_no) ;
				pstmt6.setString ( 4, login_facility_id) ;
				pstmt6.setString ( 5, p_file_no) ;
				pstmt6.setString ( 6, p_volume_no) ;
				movementtyperset = pstmt6.executeQuery();
			   if(movementtyperset != null && movementtyperset.next())  {
				file_movement_type	= movementtyperset.getString("movement_type")==null?"":movementtyperset.getString("movement_type");			
			   }
			   if(movementtyperset!=null)	movementtyperset.close();	                    
				
                System.err.println("file_movement_type===>"+file_movement_type);
                if(!file_movement_type.equals("I")){				
					/*	pstmt7.setString ( 1, login_user_id) ;
						pstmt7.setString ( 2, addedAtWorkstation) ;
						pstmt7.setString ( 3, login_facility_id) ;   		
						pstmt7.setString ( 4, login_facility_id) ;
						pstmt7.setString ( 5, p_file_no);
						pstmt7.setString ( 6, p_volume_no);					
       				    int fs_curr_locn_update=pstmt7.executeUpdate();	
						con.commit();						
					   System.err.println("FMConfirmReceiptManager.java  fs_curr_locn_update===>"+fs_curr_locn_update);
					   */
						
                 	cstmt = con.prepareCall("{call sm_day_return_date_proc(?,?,?,?,?,?,?,?)}");				
				    cstmt.setString(1, p_rec_locn_code);
                    cstmt.setString(2, p_sender_facility);
                    cstmt.setString(3, "TRANSFER_FILE");
                    cstmt.setString(4, "");
                    cstmt.setString(5, p_patient_id);
                    cstmt.setString(6, p_fs_curr_locn_id); 
                    cstmt.setString(7, ""); 					
				    cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				    cstmt.execute();					
				    String errmsg=cstmt.getString(8);
                    
					System.err.println("FMConfirmReceiptManager.java  errmsg===>"+errmsg);					
				  
				   }
				}				
				//End HSA-CRF-0306.1        

                if(cstmt != null)cstmt.close(); //Added for checkstyle
		
			}


			if( upd_curr_locn != 0  && upd_move_dtl != 0 && del_transit != 0)
			{
				result = true;
				java.util.Hashtable message = MessageManager.getMessage(locale, RECORD_INSERTED,"SM");
				sb.append((String) message.get("message"));
				con.commit();
				message.clear();
			}else
			{
				con.rollback();
			  //	result = false;
			   result = true;
				java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_ALREADY_MODI","FM");
				sb.append((String) message.get("message"));
				con.commit();
				message.clear();
			}
			htconfirmReceipt.clear();
			if(pstmt1!=null)  pstmt1.close();
			if(pstmt2!=null)  pstmt2.close();
			if(pstmt3!=null)  pstmt3.close();
			if(pstmt4!=null)  pstmt4.close();
		    if(pstmt5!=null)  pstmt5.close();
			if(pstmt6!=null)  pstmt6.close();
			if(pstmt7!=null)  pstmt7.close(); //Added for checkstyle
		}
		catch(Exception e)
		{
			sb.append("Main Catch :"+e.getMessage() + "<br>" ) ;
			e.printStackTrace() ;
			try
				{
					con.rollback();
				}
				catch (Exception ce){sb.append("Catch :"+ce.getMessage() + "<br>" ) ;}
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

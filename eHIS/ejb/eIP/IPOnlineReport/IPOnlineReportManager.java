/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP.IPOnlineReport;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ; 
import java.util.*;
import webbeans.eCommon.*;
import webbeans.eCommon.RecordSet;
/**
*
* @ejb.bean
*	name="IPOnlineReport"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPOnlineReport"
*	local-jndi-name="IPOnlineReport"
*	impl-class-name="eIP.IPOnlineReport.IPOnlineReportManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPOnlineReport.IPOnlineReportLocal"
*	remote-class="eIP.IPOnlineReport.IPOnlineReportRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPOnlineReport.IPOnlineReportLocalHome"
*	remote-class="eIP.IPOnlineReport.IPOnlineReportHome"
*	generate= "local,remote"
*
*
*/
public class IPOnlineReportManager implements SessionBean
{
	Connection con ;  
	PreparedStatement pstmt_ins_del	=	null ;
	
	SessionContext ctx;

	public void ejbCreate(){}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context)
	{
		this.ctx=context;
	}

	/**
	This method is used to --------------
	@author - 
	@version - V3
	@param1 - java.util.Properties
	@param2 - webbeans.eCommon.RecordSet
	@param3 - java.util.HashMap
	@return - java.util.HashMap

	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/



	public java.util.HashMap InsDelIPOnlineReport(
								java.util.Properties p,
								webbeans.eCommon.RecordSet IPOnlineReportRecordSet,
								java.util.HashMap hashData
					 ) 
	{
	
		String addedFacilityId		= (String)hashData.get("facilityId");
		String addedAtWorkstation	= (String)hashData.get("client_ip_address"); 
		String nursing_unit_code	= (String)hashData.get("nursing_unit_code"); 
		String operation			= (String)hashData.get("operation"); 
	//	String isRecordSelected_YN	= (String)hashData.get("isRecordSelected_YN"); 
		hashData.clear();
		StringBuffer sb				= new StringBuffer( "" ) ;
		java.util.HashMap results	= new java.util.HashMap() ;
		boolean result				= false ;
		String added_by_id			= p.getProperty( "login_user" ) ;
		String module_id			= "";
		String code					= "";
		String chk1					= "";
		String chk2					= "";
		String chk3					= "";
		String chk4					= "";
		String chk5					= "";
		String chk6					= "";
		String chk7					= "";
		String valid				= "";
		String associate_yn			= "";
		StringBuffer operation_sql_insert = new StringBuffer();
		//StringBuffer operation_sql_modify = new StringBuffer();
		StringBuffer operation_sql_delete = new StringBuffer();
		//int operation_count=0;
		int operation_count1=0;
		String locale = p.getProperty("LOCALE");
		Hashtable htRecord	=	new Hashtable();

		try 
		{
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);

			operation_sql_insert.append("Insert into IP_ONLINE_REPORT(FACILITY_ID,NURSING_UNIT_CODE,MODULE_ID,REPORT_ID,PRINT_ON_BOOKING_YN, PRINT_ON_ADMISSION_YN,PRINT_ON_TRANSFER_REQUEST_YN, PRINT_ON_CONFORM_TRANSFER_YN,PRINT_ON_BED_ASSIGNED_YN, PRINT_ON_DISCHARGE_YN,PRINT_ON_DISCH_ADV_YN,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE,MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
						
			//operation_sql_insert.append("Insert into IP_ONLINE_REPORT(FACILITY_ID,NURSING_UNIT_CODE,MODULE_ID,REPORT_ID,PRINT_ON_BOOKING_YN, PRINT_ON_ADMISSION_YN,PRINT_ON_TRANSFER_REQUEST_YN, PRINT_ON_CONFORM_TRANSFER_YN,PRINT_ON_BED_ASSIGNED_YN, PRINT_ON_DISCHARGE_YN,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE,MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");   
  

			//operation_sql_delete.append("Delete from IP_ONLINE_REPORT where FACILITY_ID=? and  Report_ID = ? and  NURSING_UNIT_CODE=? and  MODULE_ID=?");	

			operation_sql_delete.append("Delete from IP_ONLINE_REPORT where FACILITY_ID=? and   NURSING_UNIT_CODE=? and  MODULE_ID=?");	


				int row_count	=	IPOnlineReportRecordSet.getSize();
			for(int i=0; i<row_count; i++)
			{
			  try
				{
					htRecord	=(java.util.Hashtable)IPOnlineReportRecordSet.getObject(i);
					module_id	=	(String)htRecord.get("module_id");
				}catch(Exception ex)
				{
					
					ex.printStackTrace();
				}
			  
			  try
				{
				if(pstmt_ins_del!=null) pstmt_ins_del.close();
				pstmt_ins_del	=con.prepareStatement(operation_sql_delete.toString());
				pstmt_ins_del.setString	(1,	addedFacilityId );
				pstmt_ins_del.setString	(2,	nursing_unit_code );
				pstmt_ins_del.setString	(3, module_id );
				operation_count1 = pstmt_ins_del.executeUpdate() ;
				if(pstmt_ins_del!=null) pstmt_ins_del.close();
				
				}
				catch (Exception ex)
				{
					
					ex.printStackTrace();
				}
			}
	
			for(int k=0; k<row_count; k++)
			{
				try
				{
					htRecord	=(java.util.Hashtable)IPOnlineReportRecordSet.getObject(k);
					valid		=	(String)htRecord.get("valid");
					associate_yn=	(String)htRecord.get("associate_yn");
				}catch(Exception ex)
				{
					
					ex.printStackTrace();
				}


				if(associate_yn.equals("Y") || valid.equals("Y"))
				{
					code		=	(String)htRecord.get("code");
					module_id	=	(String)htRecord.get("module_id");
					chk1		=	(String)htRecord.get("booking_yn");
					chk2		=	(String)htRecord.get("admissionWithBed_yn");
					chk3		=	(String)htRecord.get("print_on_transfer_request_yn");
					chk4		=	(String)htRecord.get("transferConfirmation_yn");
					chk5		=	(String)htRecord.get("admissionWithoutBed_yn");
					chk6		=	(String)htRecord.get("discharge_yn");
					chk7		=	(String)htRecord.get("print_on_disch_adv_yn");

					if(chk1==null)chk1="N";
					if(chk2==null)chk2="N";
					if(chk3==null)chk3="N";
					if(chk4==null)chk4="N";
					if(chk5==null)chk5="N";
					if(chk6==null)chk6="N";
					if(chk7==null)chk7="N";
					
					if(!chk1.equals("Y"))chk1="N";
					if(!chk2.equals("Y"))chk2="N";
					if(!chk3.equals("Y"))chk3="N";
					if(!chk4.equals("Y"))chk4="N";
					if(!chk5.equals("Y"))chk5="N";
					if(!chk6.equals("Y"))chk6="N";
					if(!chk7.equals("Y"))chk7="N";

					/**
					Valid  associate_yn -->Operation
					================================
					 Y			Y		-->Update
					 Y			N		-->Delete
					 N			Y		-->Insert
					 N			N		-->NOP
					*/

					if(valid== null)										valid		 = "";
					if(associate_yn== null)									associate_yn = "";

					/*if(valid.equals("Y") && associate_yn.equals("N"))		operation    = "delete";
					else if(valid.equals("N")  && associate_yn.equals("Y")) operation	 = "insert";
					else if(valid.equals("Y") && associate_yn.equals("Y"))  operation	 = "modify";
					*/
					operation	 = "insert";
					try
					{
					if(operation.equals("insert"))
					{
						

if ( chk1.equals("N")&&chk2.equals("N")&&chk3.equals("N")&&chk4.equals("N")&&chk5.equals("N")&&chk6.equals("N")&&chk7.equals("N") )

						{ }
else{
						pstmt_ins_del	=	con.prepareStatement(operation_sql_insert.toString());
						pstmt_ins_del.setString	(1,	addedFacilityId );
						pstmt_ins_del.setString	(2,	nursing_unit_code );
						/*
						if(code.equals("FMFLRQSL"))
							pstmt_ins_del.setString	(3, "FM" );
						else
							pstmt_ins_del.setString	(3, "IP" );
						*/
						pstmt_ins_del.setString	(3, module_id);
						pstmt_ins_del.setString	(4, code);
						pstmt_ins_del.setString	(5, chk1);
						pstmt_ins_del.setString	(6, chk2);
						pstmt_ins_del.setString	(7, chk3);
						pstmt_ins_del.setString	(8, chk4);
						pstmt_ins_del.setString	(9, chk5);
						pstmt_ins_del.setString	(10, chk6);
						pstmt_ins_del.setString	(11, chk7);
						pstmt_ins_del.setString	(12, added_by_id);
						pstmt_ins_del.setString	(13, addedAtWorkstation);
						pstmt_ins_del.setString	(14, addedFacilityId);
						pstmt_ins_del.setString	(15, added_by_id);
						pstmt_ins_del.setString	(16, addedAtWorkstation);
						pstmt_ins_del.setString	(17, addedFacilityId);

						operation_count1 = pstmt_ins_del.executeUpdate() ;
						if(pstmt_ins_del!=null) pstmt_ins_del.close();
}
						/*if(operation_count1 > 0)
						{
							result = true ;
							con.commit();
							java.util.Hashtable message = MessageManager.getMessage( con, "RECORD_MODIFIED") ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
						else
						{
							result = false ;
							con.rollback();
						}
						htRecord.clear();*/

					}
					/*else if(operation.equals("modify"))
					{
						//if(pstmt_ins_del!=null) pstmt_ins_del.close();
						pstmt_ins_del	=con.prepareStatement(operation_sql_modify.toString());
						
						pstmt_ins_del.setString	(1,	addedFacilityId );
						pstmt_ins_del.setString	(2,	nursing_unit_code );
						pstmt_ins_del.setString	(3, module_id );
						pstmt_ins_del.setString	(4, code);
						pstmt_ins_del.setString	(5, chk1);
						pstmt_ins_del.setString	(6, chk2);
						pstmt_ins_del.setString	(7, chk3);
						pstmt_ins_del.setString	(8, chk4);
						pstmt_ins_del.setString	(9, chk5);
						pstmt_ins_del.setString	(10,chk6);
						pstmt_ins_del.setString	(11, added_by_id);
						pstmt_ins_del.setString	(12, addedAtWorkstation);
						pstmt_ins_del.setString	(13, addedFacilityId);
						pstmt_ins_del.setString	(14, added_by_id);
						pstmt_ins_del.setString	(15, addedAtWorkstation);
						pstmt_ins_del.setString	(16, addedFacilityId);
						pstmt_ins_del.setString	(17,nursing_unit_code );
						pstmt_ins_del.setString	(18, code);
						pstmt_ins_del.setString	(19,addedFacilityId );
						pstmt_ins_del.setString	(20, module_id );
					
					}
					else if(operation.equals("delete"))
					{
						pstmt_ins_del	=con.prepareStatement(operation_sql_delete.toString());
						pstmt_ins_del.setString	(1,	addedFacilityId );
						pstmt_ins_del.setString	(2, code );
						pstmt_ins_del.setString	(3,	nursing_unit_code );
						pstmt_ins_del.setString	(4, module_id );
					}

					try
					{
						operation_count = pstmt_ins_del.executeUpdate() ;
					//if (pstmt_ins_del != null ) pstmt_ins_del.close();
					*/
					}
					
					catch(SQLException e)
					{ 
						
						
						e.printStackTrace();
					}
				}
			}
			if(operation_count1 > 0)
			{ 
				result = true ;
				con.commit();
				//java.util.Hashtable message = MessageManager.getMessage( con, "RECORD_MODIFIED") ;
				Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
				sb.append( (String) message.get("message") ) ;
				message.clear();
			}
			else
			{
				result = false ;
				con.rollback();
				
			}
			//htRecord.clear();
			}catch(Exception e)
		     {

				       e.printStackTrace();

			sb.append(e.toString());
			if ( con != null )
			{
				try
				{
					con.rollback();
				}
				catch( Exception ce ) {}
			}
		}
		finally
		{
			try
			{
				if(pstmt_ins_del !=	null) pstmt_ins_del.close();
			}
			catch(Exception e) {}
				if(con!=null) ConnectionManager.returnConnection(con, p);
		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
}

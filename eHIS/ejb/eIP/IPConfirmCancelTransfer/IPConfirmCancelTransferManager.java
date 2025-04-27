/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
This ejb is used to confirm the cancel of transfer.
@author - 
@version - V3
*/
package eIP.IPConfirmCancelTransfer;
import java.rmi.*;
import javax.ejb.*;
import java.sql.*;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="IPConfirmCancelTransfer"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPConfirmCancelTransfer"
*	local-jndi-name="IPConfirmCancelTransfer"
*	impl-class-name="eIP.IPConfirmCancelTransfer.IPConfirmCancelTransferManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPConfirmCancelTransfer.IPConfirmCancelTransferLocal"
*	remote-class="eIP.IPConfirmCancelTransfer.IPConfirmCancelTransferRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPConfirmCancelTransfer.IPConfirmCancelTransferLocalHome"
*	remote-class="eIP.IPConfirmCancelTransfer.IPConfirmCancelTransferHome"
*	generate= "local,remote"
*
*
*/
public class IPConfirmCancelTransferManager implements SessionBean 
{

	StringBuffer strBuffer			= new StringBuffer();

	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){ this.ctx=context;}

	/*
	This method is used to confirm the cancel of transfer.
	@author - 
	@version - V3
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap insertIPConfirmCancelTransfer(java.util.Properties p,java.util.HashMap hashData ) 
	{
		Connection con					= null;
		PreparedStatement pstmt			= null ;
		ResultSet rset					= null;
		Statement stmt					= null;
		ResultSet srs					= null;
		CallableStatement cstmt			= null;
		String facilityId				= (String)hashData.get("facilityId");
		String patientid				= (String)hashData.get("patientid");
		String encounter_id				= (String)hashData.get("encounter_id");
		String tospecialitycode			= (String)hashData.get("tospecialitycode");
		String tobedclass				= (String)hashData.get("tobedclass");
		String tonursingunitcode		= (String)hashData.get("tonursingunitcode");
		String tobedno					= (String)hashData.get("tobedno");
		String tobedtype				= (String)hashData.get("tobedtype");
		String toroomno					= (String)hashData.get("toroomno");
		String to_dailycharge			= (String)hashData.get("todailycharge");
		String  fr_dailycharge			= (String)hashData.get("frdailycharge");
		String confirmorcancel			= (String)hashData.get("confirmorcancel");
		String bookingrefno				= (String)hashData.get("bookingrefno");
		String patientgender			= (String)hashData.get("patientgender");
		String addedAtWorkstation		= (String)hashData.get("client_ip_address");
		String to_practitioner_id		= (String)hashData.get("to_practitioner_id");
		String to_service_code			= (String)hashData.get("to_service_code");
		String authorized_practid		= (String)hashData.get("authorized_practid");
		String reason_for_cancelation	= (String)hashData.get("reason_for_cancelation");
		String block_bed_period			= (String)hashData.get("block_bed_period");
		String override					= (String)hashData.get("override");
		String blocking_remarks			= (String)hashData.get("blocking_remarks");
		//Maheshwaran added for the GHL-CRF-0362
		//Start
		String confirmValue = "N";
		String toservice			= (String)hashData.get("toservice");
		String tonursing_unit			= (String)hashData.get("tonursing_unit");
		String tosub_service			= (String)hashData.get("tosub_service");
		String toSplcode			= (String)hashData.get("toSplcode");
		String topractid			= (String)hashData.get("topractid");
		String team_id			= (String)hashData.get("team_id");
		String ipparam_bed_yn			= (String)hashData.get("ipparam_bed_yn");
		String bed_change			= (String)hashData.get("bed_change");
		String bl_operational				= (String)hashData.get("bl_operational");
		String billing_group_id			= (String)hashData.get("billing_group_id");
		String oper_stn_bed_class_yn		= (String)hashData.get("oper_stn_bed_class_yn");
		if(!bed_change.equals("Y"))
			bed_change = "N";
		//End
		java.util.HashMap results		= new java.util.HashMap() ;
		String locale = p.getProperty("LOCALE");

		if(!to_dailycharge.equals(""))
		{
			//todailycharge = Integer.parseInt(to_dailycharge);
		}
		if(!fr_dailycharge.equals(""))
		{
			//frdailycharge = Integer.parseInt(fr_dailycharge);
		}
		boolean result = false ;

		StringBuffer sb = new StringBuffer("");
		results.put( "error", "no error" ) ;
		String addedById			= p.getProperty( "login_user" ) ;

		// MOD#07	Introduced new variable strBLMessage
		String strBLMessage			= "";
		String strBLSpecialMessage  = "";
		String blocked_until_date = "";
		StringBuffer str_block_period = new StringBuffer();
		if(sb.length()>0)
		 sb.setLength(0);

		try
		{
			int res = 0;
			int count = 0;
			int bed_srlno = 0;
			con		= ConnectionManager.getConnection(p);
//			String status="";
			try
			{
		
				if(confirmorcancel.equals("Confirm"))
				{
					try
					{
						/*if(status.equals("1"))
						{
							result=false;
							sb.append("Confirm Transfer already done <br>") ;
						}
						else
							result=true;*/
						if (!(tobedno.equals("") || tobedno == null ) )
						{
							// Check the bed validity and sex indicators
							result = true ;
							StringBuffer bed_chk = new StringBuffer();
							bed_chk.append("Select  sex_spec_ind,Occupying_Patient_Id, bed_type_code, specialty_code from ip_nursing_unit_bed WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode+"' And bed_no='"+tobedno+"' ");
							stmt = con.createStatement();
							srs  = stmt.executeQuery(bed_chk.toString());
							if(!srs.next())
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale, "INVALID_BED","Common" ) ;
								sb.append( (String) message.get("message") ) ;
								message.clear();
							}
							else
							{
								String occupyingpatientid	= srs.getString("Occupying_Patient_Id") == null ? "" : srs.getString("Occupying_Patient_Id") ;
								String sex_spec_ind			= srs.getString("sex_spec_ind") == null ? "" : srs.getString("sex_spec_ind") ;
								tobedtype					= srs.getString("bed_type_code")  == null ? "" : srs.getString("bed_type_code");
								String splty_code			= srs.getString("specialty_code")==null ? "" : srs.getString("specialty_code");

								if (!(occupyingpatientid.equals("") || occupyingpatientid.equals(patientid)))
								{
									result = false;
									java.util.Hashtable message = MessageManager.getMessage( locale,"OCCUPIED_BED","IP" ) ;
									sb.append( (String) message.get("message") ) ;
									message.clear();
								}
								else if (!splty_code.equals("") && !splty_code.equals(tospecialitycode)) //Added 		for specialty to bed validation
								{
									result = false;
									java.util.Hashtable message = MessageManager.getMessage( locale,"BED_SPLTY_INVALID" ,"IP") ;
									sb.append( (String) message.get("message") ) ;
									message.clear();
								}
								else if (!sex_spec_ind.equals("") && !sex_spec_ind.equals(patientgender)) //Added 		for gender to bed validation
								{
									result = false;
									java.util.Hashtable message = MessageManager.getMessage( locale,"AGE_GENDER_NOT_ALLOWED","IP" ) ;
									sb.append( (String) message.get("message") ) ;
									message.clear();
								}
							}
							if (srs != null) srs.close();
							if (stmt != null) stmt.close();
						}
					}catch(Exception e)
					{
						result = false;
						sb.append("Exception in checking valid bed "+e.toString());
					}
						/*Friday, May 14, 2010 update will done through IP_GET_BOOKING_SRL_NO.GET_IP_BED_BKG_SRL_NO on ip_bed_booking_srl_ctrl*/
						if(result)
						{
							try
							{
								str_block_period.append("select to_char((sysdate+'"+block_bed_period+"'/24),'dd/mm/rrrr hh24:mi') a from dual");
						
								pstmt = con.prepareStatement(str_block_period.toString());
								try{rset  = pstmt.executeQuery();}
								catch(SQLException sqle)
								{
									sqle.printStackTrace();
								}
								if(rset!=null)
								{
									while(rset.next())
									{
										blocked_until_date = checkForNull(rset.getString("a"));//Maheshwaran added checkForNull for GHL-CRF-0362
									}
								}
								if (rset != null )  rset.close();
								if (pstmt != null ) pstmt.close();
								if(!blocked_until_date.equals(""))
								{
									try
									{
										cstmt=con.prepareCall("{call IP_GET_BOOKING_SRL_NO.GET_IP_BED_BKG_SRL_NO(?,?,?,?,?,?)}");
										cstmt.setString(1,facilityId);
										cstmt.setString(2,"T");
										cstmt.setString(3,"Y");
										cstmt.setString(4,addedAtWorkstation);
										cstmt.setString(5,addedById);
										cstmt.registerOutParameter(6,java.sql.Types.NUMERIC);
										cstmt.execute();
										bed_srlno=cstmt.getInt(6);
										/*Added by Thamizh selvi on 1st Dec 2017 against AYH-SCF-0007 Start*/
										if(bed_srlno < 1){
											java.util.Hashtable message = MessageManager.getMessage( locale, "BED_BKG_SRL_CTRL_NOT_DEFINED","IP" ) ;
											sb.append( (String) message.get("message") ) ;
											result = false;
										}/*End*/
										if(cstmt != null) cstmt.close();
									}
									catch (Exception e1)
									{
										result = false;
										e1.printStackTrace();
									}
								}
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
						}
						/**/
						if(result)
						{
						   //Added Audit column
						   //Maheshwaran added some columns in the below query for GHL-CRF-0362
							strBuffer.delete(0, strBuffer.length());
							strBuffer.append("update IP_TRANSFER_REQUEST set ");
							strBuffer.append(" REQ_NURSING_UNIT_CODE = ?,REQ_SERVICE_CODE=?,REQ_SUBSERVICE_CODE=?,REQ_SPECIALTY_CODE=?,REQ_PRACTITIONER_ID=? , " );
							strBuffer.append(" REQ_TEAM_ID= ?,CONFIRMATION_DATE_TIME = sysdate, CONFIRMED_BY_ID = ?, ");
							strBuffer.append("TFR_REQ_STATUS = '1',TFR_REQ_ACCEPTED_YN ='Y', REQ_BED_CLASS_CODE = ? , REQ_BED_TYPE_CODE=?,REQ_BED_NO = ? , ");
							strBuffer.append("req_room_no = ?, modified_by_id = ?, modified_at_ws_no = ?, ");
							//11/18/2008 CRF 3698 SRR20056-CRF-0228
							strBuffer.append("BLOCKING_TYPE_CODE = ? , ");
							//
							strBuffer.append("modified_date = sysdate, MODIFIED_FACILITY_ID=?  where TFR_REQ_REF_NO = ?");
							strBuffer.append(" and  facility_id = ? and encounter_id = ?");
							pstmt = con.prepareStatement(strBuffer.toString());
							//Maheshwaran added for GHL-CRF-0362
							pstmt.setString	( 1, tonursing_unit ) ;
							pstmt.setString	( 2, toservice ) ;
							pstmt.setString	( 3, tosub_service ) ;
							pstmt.setString	( 4, toSplcode ) ;
							pstmt.setString	( 5, topractid ) ;
							pstmt.setString	( 6, team_id ) ;
							//End
							pstmt.setString	( 7, addedById.trim() ) ;
							pstmt.setString	( 8, tobedclass ) ;
							pstmt.setString	( 9, tobedtype ) ;
							pstmt.setString	( 10, tobedno ) ;
							pstmt.setString	( 11, toroomno ) ;
							pstmt.setString	( 12, addedById ) ;
							pstmt.setString	( 13, addedAtWorkstation ) ;
							//11/18/2008 CRF 3698 SRR20056-CRF-0228
							pstmt.setString	( 14, blocking_remarks ) ;
							//
							pstmt.setString	( 15, facilityId.trim() ) ; //Added Audit column
							pstmt.setString	( 16, bookingrefno.trim() ) ;
							pstmt.setString	( 17, facilityId.trim() ) ;
							pstmt.setString	( 18,encounter_id);
							res = pstmt.executeUpdate() ;
							if (pstmt != null ) pstmt.close();

						if(res>0 )  result = true; 
						else		result = false;

						if(result)
						{
							/*Friday, May 14, 2010 , update will done through IP_GET_BOOKING_SRL_NO.GET_IP_BED_BKG_SRL_NO at line no 192*/
							/*
							String blocked_until_date = "";
							StringBuffer str_block_period = new StringBuffer();
							str_block_period.append("select to_char((sysdate+'"+block_bed_period+"'/24),'dd/mm/rrrr hh24:mi') a from dual");
					
							pstmt = con.prepareStatement(str_block_period.toString());
							try{rset  = pstmt.executeQuery();}
							catch(SQLException sqle)
							{
							}
							if(rset!=null)
							{
								while(rset.next())
								{
									blocked_until_date = rset.getString("a");
								}
							}
							if (rset != null )  rset.close();
							if (pstmt != null ) pstmt.close();
							*/
							//Maheshwaran modified if condition for GHL-CRF-0362
							//if(blocked_until_date != null)
							if(!blocked_until_date.equals(""))
							{
								/*Friday, May 14, 2010 , update will done through IP_GET_BOOKING_SRL_NO.GET_IP_BED_BKG_SRL_NO at line no 192*/
								/*
								int bed_srlno = 0;
								strBuffer.delete(0, strBuffer.length());
								strBuffer.append("select NEXT_BOOKING_SRL_NO srl_no from "); strBuffer.append("IP_BED_BOOKING_SRL_CTRL where facility_id = '"+facilityId+"' and BOOKING_TYPE = 'T' ");
								stmt   = con.createStatement();
								srs    = stmt.executeQuery(strBuffer.toString());

								if(srs.next())
								{
									bed_srlno = srs.getInt("srl_no");
								}
								strBuffer.delete(0, strBuffer.length());
								strBuffer.delete(0, strBuffer.length());
								strBuffer.append(" Update IP_BED_BOOKING_SRL_CTRL set "); strBuffer.append("NEXT_BOOKING_SRL_NO=NEXT_BOOKING_SRL_NO+1 ");
								strBuffer.append(" WHERE  facility_id= '"+facilityId+"' and BOOKING_TYPE = 'T' ");
								pstmt = con.prepareStatement( strBuffer.toString());
								pstmt.executeUpdate();
								//int u = pstmt.executeUpdate();
								if(pstmt != null)	pstmt.close();
								*/
								try
								{
									strBuffer.delete(0, strBuffer.length());
									strBuffer.append("INSERT INTO ip_bed_booking (");
									strBuffer.append("FACILITY_ID, BOOKING_TYPE, BED_BOOKING_REF_NO, ENCOUNTER_ID, ");
									strBuffer.append("PATIENT_ID, BLOCKED_FROM_DATE_TIME, BLOCKED_UNTIL_DATE_TIME,");
									strBuffer.append("ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,");
									strBuffer.append("MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,");
									strBuffer.append("REQ_NURSING_UNIT_CODE, REQ_SERVICE_CODE, REQ_BED_NO, REQ_ROOM_NO,");
									strBuffer.append("REQ_BED_CLASS_CODE, REQ_BED_TYPE_CODE, REQ_PRACTITIONER_ID, ");
									strBuffer.append("REQ_SPECIALTY_CODE,BOOKED_BY_ID, BOOKING_DATE_TIME, BOOKING_STATUS,OVERRIDE_YN) values (");
									strBuffer.append("?,?,?,?,?,sysdate,to_date(?,'dd/mm/rrrr hh24:mi'),?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?)");
									
									if(pstmt != null)	pstmt.close();
									pstmt = con.prepareStatement( strBuffer.toString() );
									pstmt.setString	( 1, facilityId ) ;
									pstmt.setString	( 2, "T" ) ;
									pstmt.setInt	( 3, bed_srlno);
									pstmt.setString	( 4, encounter_id);
									pstmt.setString	( 5, patientid);
									pstmt.setString	( 6, blocked_until_date);
									pstmt.setString	( 7, addedById);
									pstmt.setString	( 8, addedAtWorkstation);
									pstmt.setString	( 9, facilityId);
									pstmt.setString	( 10, addedById);
									pstmt.setString	( 11, addedAtWorkstation);
									pstmt.setString	( 12, facilityId);
									pstmt.setString	( 13, tonursingunitcode);
									pstmt.setString	( 14, to_service_code);
									pstmt.setString	( 15, tobedno);
									pstmt.setString	( 16, toroomno);
									pstmt.setString	( 17, tobedclass);
									pstmt.setString	( 18, tobedtype);
									pstmt.setString	( 19, to_practitioner_id);
									pstmt.setString	( 20, tospecialitycode);
									pstmt.setString	( 21, addedById);
									pstmt.setString	( 22, "0");
									pstmt.setString	( 23, override);
									res = 0;
									try
									{
									   res = pstmt.executeUpdate() ;
									
									}catch(SQLException ex)
									{
									sb.append("Exception in updating ip_bed_booking :"+ex.toString());//Maheshwaran added for GHL-CRF-0362
										ex.printStackTrace();
									}

									result = (res >0) ? true : false;
									
									 if(pstmt != null)		pstmt.close() ;

								}catch(Exception se)
								{
									result = false;
									sb.append("Exception in updating ip_bed_booking :"+se.toString());
								}
							}
						}
					}


					if(result)
					{
						count = 0;
						try
						{   //Added Audit column
							if(strBuffer.length() > 0)	strBuffer.delete(0, strBuffer.length());
							strBuffer.append("  update IP_OPEN_ENCOUNTER set ");
							strBuffer.append("  TFR_REQ_STATUS = '1', ");
							strBuffer.append(" modified_by_id = ?, ");
							strBuffer.append(" modified_at_ws_no = ?, modified_date = sysdate, MODIFIED_FACILITY_ID=? ");
							strBuffer.append(" where ");
							strBuffer.append(" facility_id = ? and encounter_id = ?");
							pstmt = con.prepareStatement(strBuffer.toString());
							pstmt.setString(1, addedById);
							pstmt.setString(2, addedAtWorkstation);
							pstmt.setString(3, facilityId);//Added audit column
							pstmt.setString(4, facilityId); 
							pstmt.setString(5, encounter_id);
							count = pstmt.executeUpdate();
							if(count > 0)
								result = true;
							else
								result = false;

							if(pstmt != null) pstmt.close();
						}catch(Exception ex)
						{
							result = false;
							sb.append("error while updating into ip_open_encounter : " + ex.getMessage());
						}
					}
				}				
				else
				{
					/*
					 @Change: Added new columns authorized_practid,CANCEL_REASON_CODE
					 @Modified By: kishore on date 4/28/2004. 
					 @Reason: new Emal Enhancement.
					*/
					/*if(status.equals("2"))
					{
						result=false;
						sb.append("Cancle Transfer already done<br>") ;
					}
						else
							result=true;*/
                   // if(result){
				    //Added audit column
					strBuffer.delete(0, strBuffer.length());
					strBuffer.append(" update IP_TRANSFER_REQUEST set cancellation_date_time = sysdate, ");
					strBuffer.append(" cancelled_by_id = ?, TFR_REQ_STATUS = '2',TFR_REQ_ACCEPTED_YN ='N', modified_by_id = ?, ");
					strBuffer.append(" modified_at_ws_no = ?, modified_date = sysdate, ");
					strBuffer.append("CANCEL_REASON_CODE = ? , AUTH_PRACTITIONER_ID=?, MODIFIED_FACILITY_ID=? where ");
					strBuffer.append("TFR_REQ_REF_NO = ? and facility_id = ? and encounter_id = ? ");

					pstmt = con.prepareStatement(strBuffer.toString());

					pstmt.setString	( 1, addedById ) ;
					pstmt.setString	( 2, addedById ) ;
					pstmt.setString	( 3, addedAtWorkstation ) ;
					pstmt.setString	( 4, reason_for_cancelation);
					pstmt.setString	( 5, authorized_practid);
					pstmt.setString	( 6, facilityId ) ; //Added audit column
					pstmt.setString	( 7, bookingrefno);
					pstmt.setString	( 8, facilityId ) ;
					pstmt.setString	( 9,encounter_id);
					res = pstmt.executeUpdate() ;
					if(res>0 )  result = true; else result = false;
				
					if(pstmt != null)		pstmt.close() ;	
					

			if(result)
			{
				count = 0;
				try
				{  //Added audit column
					if(strBuffer.length() > 0)	strBuffer.delete(0, strBuffer.length());
					strBuffer.append("  update IP_OPEN_ENCOUNTER set ");
					strBuffer.append("  TFR_REQ_STATUS = '', ");
					strBuffer.append(" modified_by_id = ?, ");
					strBuffer.append(" modified_at_ws_no = ?, modified_date = sysdate, MODIFIED_FACILITY_ID=? ");
					strBuffer.append(" where ");
					strBuffer.append(" facility_id = ? and encounter_id = ?");
					pstmt = con.prepareStatement(strBuffer.toString());
					pstmt.setString(1, addedById);
					pstmt.setString(2, addedAtWorkstation);
					pstmt.setString(3, facilityId); //Added audit column
					pstmt.setString(4, facilityId);
					pstmt.setString(5, encounter_id);
					count = pstmt.executeUpdate();
					if(count > 0)
						result = true;
					else
						result = false;

					if(pstmt != null) pstmt.close();
				
				}catch(Exception ex)
				{
					result = false;
					sb.append("error while updating into ip_open_encounter : " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		}
			
			}catch(SQLException e1)
			{
				result = false;
				sb.append("Exception in updating IP_TRANSFER_REQUEST : " + e1);
				e1.printStackTrace();
			}
			//Maheshwaran added for GHL-CRF-0362
			//Start
				String insert_val="";
					if(bl_operational.equals("Y"))
						{	
						 insert_val="0";
							try
							{
							if(srs!=null) srs.close();
							if(stmt!=null) stmt.close();
							String blSql= " select BL_CHECK_ELIGIBILITY_LEVEL('"+billing_group_id+"','"+tobedtype+"') from dual ";
							stmt = con.createStatement();
							srs = stmt.executeQuery(blSql);
							System.err.println("344,blSql  : "+blSql);
							if(srs != null && srs.next())
							{
								confirmValue = srs.getString(1);
							}
							if(srs!=null) srs.close();
							if(stmt!=null) stmt.close();
							}
						catch (Exception e)
							{ 
							result=false;
							e.printStackTrace() ;	
							}
						}						
					if(ipparam_bed_yn.equals("Y") && oper_stn_bed_class_yn.equals("N") && bed_change.equals("Y") && confirmValue.equals("Y"))
						{
							insert_val = "0";
						}
					else
						{
							insert_val = "1";
						}	
				//End
			if(result)
			{
				try
				{ 
				//Maheshwaran added for GHL-CRF-0362
				//start
					if(insert_val.equals("1")&&(confirmorcancel.equals("Confirm")))
						{				
						strBuffer.delete(0, strBuffer.length());
						strBuffer.append("update IP_BED_CLASS_REQUEST set ");
						strBuffer.append(" REQ_NURSING_UNIT_CODE = ?,REQ_BED_CLASS_CODE= ?,REQ_BED_TYPE_CODE = ?");
						strBuffer.append(",REQ_ROOM_NO=?,REQ_BED_NO= ?, TO_NURSING_UNIT_CODE = ?,");
						strBuffer.append(" TO_SERVICE_CODE= ?,TO_SUBSERVICE_CODE = ?"	);
						strBuffer.append(" ,TO_BED_CLASS_CODE= ?, TO_BED_TYPE_CODE = ?" );
						strBuffer.append(" ,TO_ROOM_NO= ?,	 TO_BED_NO = ?" );
						strBuffer.append(" ,TO_SPECIALTY_CODE= ?,	TO_PRACTITIONER_ID = ?" );
						strBuffer.append(" ,TO_TEAM_ID= ? ,request_status =? , modified_by_id = ?, ");
						strBuffer.append(" modified_at_ws_no = ?, modified_date = sysdate, MODIFIED_FACILITY_ID=? ");		
						strBuffer.append(" where FACILITY_ID=? and ENCOUNTER_ID=? and SRL_NO=?");
						pstmt = con.prepareStatement(strBuffer.toString());
						pstmt.setString	( 1, tonursing_unit ) ;
						pstmt.setString	( 2, tobedclass ) ;
						pstmt.setString	( 3, tobedtype ) ;			
						pstmt.setString	( 4, toroomno ) ;
						pstmt.setString	( 5, tobedno ) ;
						pstmt.setString	( 6, tonursing_unit ) ;
						pstmt.setString	( 7, toservice ) ;
						pstmt.setString	( 8, tosub_service ) ;
						pstmt.setString	( 9, tobedclass ) ;
						pstmt.setString	( 10, tobedtype ) ;			
						pstmt.setString	( 11, toroomno ) ;
						pstmt.setString	( 12, tobedno ) ;
						pstmt.setString	( 13, toSplcode ) ;
						pstmt.setString	( 14, topractid ) ;
						pstmt.setString	( 15, team_id ) ;
						pstmt.setString	( 16, insert_val ) ;
						pstmt.setString(17, addedById);
						pstmt.setString(18, addedAtWorkstation);
						pstmt.setString(19, facilityId); //Added
						pstmt.setString	( 20, facilityId.trim() ) ; //Added Audit column
						pstmt.setString	( 21, encounter_id ) ;
						pstmt.setString	( 22, bookingrefno.trim() ) ;
						res=pstmt.executeUpdate() ;
						}
					else
						{
						//End
						//Added audit column
					StringBuffer stringbuffer1 = new StringBuffer();
					if(stringbuffer1.length() > 0)
						stringbuffer1.delete(0, stringbuffer1.length());
					stringbuffer1.append(" update IP_BED_CLASS_REQUEST set ");
					stringbuffer1.append(" request_status = '9', ");
					stringbuffer1.append(" modified_by_id = ?, ");
					stringbuffer1.append(" modified_at_ws_no = ?, modified_date = sysdate, MODIFIED_FACILITY_ID=? ");
					stringbuffer1.append(" where ");
					stringbuffer1.append(" REQUEST_STATUS = '0' and facility_id = ? and ENCOUNTER_ID = ? ");
					pstmt = con.prepareStatement(stringbuffer1.toString());
					pstmt.setString(1, addedById);
					pstmt.setString(2, addedAtWorkstation);
					pstmt.setString(3, facilityId); //Added audit column
					pstmt.setString(4, facilityId);
					pstmt.setString(5, encounter_id);
						res=pstmt.executeUpdate();
						if (pstmt != null ) pstmt.close();
						}
				}
				catch(SQLException sqlexception1)
				{
					sb.append("Exception in IP_BED_CLASS_REQUEST : " + sqlexception1);
					sqlexception1.printStackTrace();
				}
			}

			if (result)
			{
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
				sb.append( (String) message.get("message") ) ;
				con.commit();
				message.clear();				
			}
			
		}catch (SQLException e ) 
		{
			sb.append( e.getMessage()  ) ;
			e.printStackTrace() ;
			try
			{
				con.rollback();
			}
			catch(Exception e1){}
		}
		finally 
		{
			try
			{
				  if(pstmt != null)		pstmt.close();
				  if(rset != null)		rset.close();
				  if(stmt != null)		stmt.close();
				  if(srs != null)		srs.close();
			 }
			 catch(Exception ce){}
			if(con != null) ConnectionManager.returnConnection(con,p);
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		

		// MOD#09 Added new parameter BL Message
		if ( (strBLMessage == null) || (strBLMessage.equals("")))
		{
			strBLMessage = " ";	
		}
		if ( (strBLSpecialMessage == null) || (strBLSpecialMessage.equals("")))
		{
			strBLSpecialMessage = " ";	
		}
		results.put( "bl_message",strBLMessage);
		results.put( "bl_special_message",strBLSpecialMessage);
		// End of MOD#09 

		hashData.clear();
		
		return results ;
	}//end insert
	//Maheshwaran added for GHL-CRF-0362
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
} // end session bean

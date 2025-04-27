
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP.IPAmendBooking;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.Properties;
import java.util.*;
import java.sql.* ;
import javax.naming.*;
import javax.transaction.*;
import blbkin.*;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="IPAmendBooking"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPAmendBooking"
*	local-jndi-name="IPAmendBooking"
*	impl-class-name="eIP.IPAmendBooking.IPAmendBookingManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPAmendBooking.IPAmendBookingLocal"
*	remote-class="eIP.IPAmendBooking.IPAmendBookingRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPAmendBooking.IPAmendBookingLocalHome"
*	remote-class="eIP.IPAmendBooking.IPAmendBookingHome"
*	generate= "local,remote"
*
*
*/
public class IPAmendBookingManager implements SessionBean 
{
	Connection con 		 		= null;
	PreparedStatement pstmt2	= null;
	ResultSet rset 				= null;
	PreparedStatement pstmt1	= null;
	Statement Stmt 				= null;
//	int l_female_bkngs	= 0 ;
//	int l_unknow_bkngs	= 0 ;
//	int l_male_bkngs	= 0 ;
	//int res1 = 0;
	//int res2 = 0;
	int n_res = 0;
    java.util.HashMap	results = new java.util.HashMap() ;

	boolean result			   = true ;
	StringBuffer messageBuffer = null;
	//public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;

	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove(){}
	public void ejbActivate(){}
	public void ejbPassivate(){}

	public void setSessionContext(SessionContext context){this.ctx=context;}
/**
* @ejb.interface-method
*	 view-type="both"
*/

	public java.util.HashMap  insertIPAmendBooking(Properties p,java.util.HashMap hashData)
	{
		String facilityId			= (String)hashData.get("facilityId");
		String remarks				= (String)hashData.get("remarks");
		String bkg_lst_ref_no		= (String)hashData.get("bkg_lst_ref_no");
	//	String gender				= (String)hashData.get("gender");
		String modifiedAtWorkstation= (String)hashData.get("addedAtWorkstation");
		
		String isBlInstalled	= (String)hashData.get("isBlInstalled");
		String iscapture_fin_dtls_yn	= (String)hashData.get("iscapture_fin_dtls_yn");
		TreeMap patInstructions=(java.util.TreeMap)hashData.get("patInstructions");//included for the CRF - RUT - CRF -013 23396
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		String smartCardFunc ="";//(String)hashData.get("smartCardFunc");
		String biometric_reason=(String)hashData.get("biometric_reason");
		String patient_id =(String)hashData.get("patient_id");
		String nursing_unit=(String)hashData.get("nursing_unit");
		//Ends
		
		result			   = true ;
		messageBuffer = new StringBuffer("");
		if (messageBuffer.toString().length()>0)
			messageBuffer.delete(0, messageBuffer.length());
		try
		{
			con					= ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			smartCardFunc	= eCommon.Common.CommonBean.isSiteSpecificforBiometric(con);//added by Himanshu Saxena for AAKH-CRF-0175 as on 23-08-2023 
			String modifiedById				= p.getProperty( "login_user" ) ;
			String locale = p.getProperty("LOCALE");
			String referral_id				= "";
			StringBuffer	sbSql			= new StringBuffer();
						
//			if(gender.equals("Male")) 
//				l_male_bkngs   = 1;
//			else 
//				if(gender.equals("Female")) 
//				l_female_bkngs = 1;
//			else
//				l_unknow_bkngs = 1;
			
			try
			{
				sbSql.append("select booking_status, referral_id from ip_booking_list where facility_id = '"+facilityId+"' and bkg_lst_ref_no = '"+bkg_lst_ref_no+"' ");
				if(pstmt1!=null) pstmt1.close();
				if(rset!=null) rset.close();
				pstmt1 = con.prepareStatement(sbSql.toString());
				rset = pstmt1.executeQuery();
				if(rset!=null && rset.next())
				{
					String bookingStatus	 = rset.getString("booking_status");
					if(bookingStatus.equals("9"))
					{
						result		= false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"CANCELLED_BOOKING","IP");
						messageBuffer.append((String) message.get("message"));
						message.clear();
					}

					referral_id = rset.getString("referral_id");
					if(referral_id == null) referral_id="";
				}
				if(pstmt1!=null) pstmt1.close();
					if(rset!=null) rset.close();
			}
			catch(Exception e1)
			{ 
				messageBuffer.append("Error while selecting referral id from ip_booking_list..."+e1);
			}
			
			if(result && !(remarks.equals("")||remarks.equals("null")))
			{
				
				try
				{
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append("update ip_booking_list set" );
					sbSql.append(" cancellation_date_time = sysdate,  ");
					sbSql.append(" cancelled_by_id =?,");
					sbSql.append(" cancel_reason_code =?,");
					sbSql.append(" booking_status='9' ,");
					sbSql.append(" modified_by_id	= ?,  " );
					sbSql.append(" modified_date		= sysdate,  " );
					sbSql.append(" modified_facility_id	= ?, " );
					sbSql.append(" modified_at_ws_no = ? , ");
					//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
					//Start
					sbSql.append(" ORDER_ID = '' , ");
					sbSql.append(" ORDER_LINE_NO = '' , ");
					sbSql.append(" OPER_CODE = '' , ");
					sbSql.append(" OPER_SHORT_DESC = '' , ");
					sbSql.append(" PREF_SURG_DATE = ''  ");
					//End
					sbSql.append("  where facility_id= ? and bkg_lst_ref_no=?" );
			
					pstmt1 = con.prepareStatement( sbSql.toString() );
					pstmt1.setString( 1, modifiedById ) ;
					pstmt1.setString( 2, remarks ) ;
					pstmt1.setString( 3, modifiedById ) ;
					pstmt1.setString( 4, facilityId ) ;
					pstmt1.setString( 5, modifiedAtWorkstation ) ;
					pstmt1.setString( 6, facilityId);
					pstmt1.setString( 7, bkg_lst_ref_no);
					n_res = pstmt1.executeUpdate() ;

					if (pstmt1 != null)
					{
						pstmt1.close();
					}
					if(n_res > 0) 
						result = true;
					if (result)
						{//included for the CRF - RUT - CRF -013 23396
						if (patInstructions!=null && !(patInstructions.isEmpty())){
							String deleteSql="delete from ip_bkg_pat_instructions where facility_id='"+facilityId+"' and bkg_ref_no='"+bkg_lst_ref_no+"'";
							pstmt1=con.prepareStatement(deleteSql);
							pstmt1.executeUpdate();

							String patInsSql ="insert into ip_bkg_pat_instructions(facility_id, bkg_ref_no, instruction_id, instruction_desc, display_order, added_by_id, added_date,added_facility_id, added_at_ws_no, modified_by_id, modified_date,modified_facility_id, modified_at_ws_no)values(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
							pstmt1=con.prepareStatement(patInsSql);
							//int recCount=patInstructions.size();
							int executableCount=0;
							Iterator it=patInstructions.keySet().iterator();
							while(it.hasNext()){
								Integer key=(Integer)it.next();
								String instId="";
								String instDesc="";
								String checkYN="";
								String mapValue=(String)patInstructions.get(key);
								StringTokenizer token1=new StringTokenizer(mapValue, "||");
								
								while (token1.hasMoreTokens()){
									instId=token1.nextToken();
									instDesc=token1.nextToken();
									if(instDesc.equals("*!*")){
										instDesc="";
									}
									checkYN=token1.nextToken();
								}
								if(checkYN.equals("Y")){
									executableCount=executableCount+1;
									pstmt1.setString	( 1, facilityId ) ;
									pstmt1.setString	( 2, bkg_lst_ref_no ) ;
									pstmt1.setString	( 3, instId ) ;
									pstmt1.setString	( 4, instDesc ) ;
									pstmt1.setInt	( 5, executableCount ) ;
									pstmt1.setString ( 6, modifiedById );
									pstmt1.setString	( 7, facilityId ) ;
									pstmt1.setString	( 8, modifiedAtWorkstation  ) ;
									pstmt1.setString	( 9, modifiedById  ) ;
									pstmt1.setString	( 10, facilityId  ) ;
									pstmt1.setString	( 11, modifiedAtWorkstation  ) ;
									pstmt1.addBatch();
								}
								
							}
							if(executableCount >0){
								int resultArr[]=pstmt1.executeBatch();
								n_res=resultArr.length;
							}
						}

					}
					if (n_res != 0)
					{
						result=true;
					}
					else
					{
						result = false;
						messageBuffer.append("Error while updating ip_booking_list");
					}
				}
				catch(Exception e11)
				{ 
					messageBuffer.append("Error while updating ip_booking_list..."+e11);
				}
				finally
				{
					try
					{
						if(pstmt1!=null) pstmt1.close();
					}
					catch(Exception e) { }
				}
			}


			// MOD#04 The new hashtable is introduced to pass the variable to the billing bean

					if(result && isBlInstalled!=null && isBlInstalled.equals("Y") && iscapture_fin_dtls_yn!=null && iscapture_fin_dtls_yn.equals("Y"))
						{
							try
							{
										
								
										Hashtable hashtableBill = new Hashtable();

										hashtableBill.put("facilityId",facilityId+"");
										hashtableBill.put("bookingrefno",bkg_lst_ref_no+"");
										hashtableBill.put("patientclass","IP");
										hashtableBill.put("addedAtWorkstation",modifiedAtWorkstation+"");
										hashtableBill.put("P_MODE","I");
										hashtableBill.put("P_EPISODE_TYPE","I");
										hashtableBill.put("modifiedAtWorkstation",modifiedAtWorkstation+"");
										hashtableBill.put("function_id","CANCELBOOKING"+"");
										hashtableBill.put("module_id","IP");
										hashtableBill.put("locale",locale);
									
									
										

										BLCancelBooking blcancelBookPat = new BLCancelBooking();
										Hashtable resultsBL = blcancelBookPat.billPatientService(p, con,hashtableBill);
										boolean boolRes = ((Boolean)(resultsBL.get("status"))).booleanValue();
										


										result = boolRes;
										String strBLMessage = "";
										if (boolRes == false)
										{
											result  = false;
											strBLMessage = (String) resultsBL.get("error");
											
											if (strBLMessage != null || !strBLMessage.equalsIgnoreCase("null"))
											{
													messageBuffer.append(strBLMessage);													
													
												
											}	
										}

										resultsBL.clear();
										hashtableBill.clear();

										if (boolRes == true)
										{
											/*strBLMessage = (String) resultsBL.get("message");
											if (strBLMessage != null )
											{
												if (!strBLMessage.equalsIgnoreCase("null"))
												{
													sb.append("<u>"+strBLMessage+"</u><br>");
												}
											}*/
										}

						


							}
							catch (Exception exceptionBL)
							{
								result	  = false;
								messageBuffer.append("BILLING UPDATION :"+exceptionBL.toString());
								exceptionBL.printStackTrace();
								
							}
						}// End of Billing Interface



			if(result)
			{
				
				// Check is there any bed blocked for this booking reference no
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append( " Select * from ip_bed_booking where facility_id= '"+facilityId+"' and booking_type='L' and bed_booking_ref_no= '"+bkg_lst_ref_no+"'");   
				
				Stmt=con.createStatement();
				rset = Stmt.executeQuery(sbSql.toString());
				if(rset.next())
				{
					// Update ip_bed_booking if it was blocked by this booking ref no
					try
					{

						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append("update ip_bed_booking set" );
						sbSql.append(" cancellation_date_time = sysdate,  " );
						sbSql.append(" cancelled_by_id = ?,");
						sbSql.append(" booking_status='9' ,");
						sbSql.append(" modified_by_id	= ?,  " );
						sbSql.append(" modified_date		= sysdate, " );
						sbSql.append(" modified_facility_id	= ? , " );
						sbSql.append(" modified_at_ws_no = ? where facility_id= ? and booking_type='L' and bed_booking_ref_no= ?"  );

						pstmt2 = con.prepareStatement( sbSql.toString() );
						pstmt2.setString( 1, modifiedById ) ;
						pstmt2.setString( 2, modifiedById ) ;
						pstmt2.setString( 3, facilityId ) ;
						pstmt2.setString( 4, modifiedAtWorkstation ) ;
						pstmt2.setString( 5, facilityId ) ;
						pstmt2.setString( 6, bkg_lst_ref_no ) ;
						n_res = pstmt2.executeUpdate() ;

						if(n_res > 0)
							result = true;
						else
						{
							result = false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_UPDATING","IP");
							String msgVal = ((String) message.get("message"));
							msgVal = msgVal.substring(0,msgVal.length()-4);
							messageBuffer.append("Error while updating ip_bed_booking");
							message.clear();
						}
				}
					catch(Exception e1)
					{ 
						e1.printStackTrace() ;
						messageBuffer.append("Error while updating ip_bed_booking..."+e1);
					}
					finally
					{
						try
						{
							if(pstmt2!=null) pstmt2.close();
						}
						catch(Exception e) { }
					}
				}
			}
			if(result)
			{
				if(!referral_id.equals(""))
				{
					try
					{
						
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append(" Update pr_referral_register set ");
						sbSql.append(" STATUS = 'O', referred_in_func=null ,  ");
						sbSql.append(" modified_by_id	= ?,  " );
						sbSql.append(" modified_date		= sysdate,  " );
						sbSql.append(" modified_facility_id	= ?, " );
						sbSql.append(" modified_at_ws_no = ? ");
						sbSql.append("  where REFERRAL_ID= ? ");
						pstmt1 = con.prepareStatement( sbSql.toString() );
						pstmt1.setString( 1, modifiedById ) ;
						pstmt1.setString( 2, facilityId ) ;
						pstmt1.setString( 3, modifiedAtWorkstation ) ;
						pstmt1.setString( 4, referral_id ) ;
						n_res= pstmt1.executeUpdate();
						if(n_res>0) 
							 result=true;
						else
						{
							result						= false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_WHILE_UPDATING","IP");
							String msgVal				= ((String) message.get("message"));
							msgVal						= msgVal.substring(0,msgVal.length()-4);
							messageBuffer.append(msgVal);
							messageBuffer.append(" PR_REFERRAL_REGISTER ");
							message.clear();
						}
					}
					catch(Exception e1)
					{ 
						e1.printStackTrace() ;
						messageBuffer.append("Error while updating pr_referral_register..."+e1);
					}
					finally
					{
						try
						{
							if(pstmt1!=null) pstmt1.close();
						}
						catch(Exception e) { }
					}
				}
			}
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
			//Starts
			try 
				{					   
				if(result && smartCardFunc.equals("01") && !biometric_reason.equals(""))
					{						
					String status=eCommon.Common.CommonBean.insertReasonforBiometric(con,facilityId,"IP_CANCEL_BOOKING",patient_id,bkg_lst_ref_no,nursing_unit,biometric_reason,modifiedAtWorkstation,modifiedById);
					if(status.equals("S"))
						{
						result	= true;	
						}
					else {
						result	= false;
						}	
					} 
				}
			catch(Exception e)
				{
				result	= false;
				e.printStackTrace();
				}
			//Ends
			if (result)
			{
					
					java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
					String msgVal				= ((String) message.get("message"));
					messageBuffer.append(msgVal);
					message.clear();
					con.commit();
			}
			else
			{
				result = false ;
				con.rollback();
				
			}

		}catch(Exception e)
		{
			e.printStackTrace() ;
			try
			{
				con.rollback();
			}
			catch(Exception e1)
			{
				e.printStackTrace() ;
			}
		}
		finally
		{
			 try{
				 if(pstmt2!=null) pstmt2.close();
				 if(rset!=null) rset.close();
				 if(pstmt1!=null) pstmt1.close();
				 if(Stmt!=null) Stmt.close();
				 }catch(Exception e)
			 {}
			 if(con!=null) ConnectionManager.returnConnection(con,p);
		}
		results.put( "status", new Boolean(result) ) ;

		if (messageBuffer.toString() == null)
			messageBuffer.delete(0, messageBuffer.length());

		results.put( "error", messageBuffer.toString() ) ;
		
		hashData.clear();
		return results ;

	}//E.o.Insert
}// E.O.Session Bean

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
This ejb is used to admit the patients.
@author - 
@version - V3
*/

package eIP.IPCancelTransfer;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import javax.naming.*;

import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="IPCancelTransfer"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPCancelTransfer"
*	local-jndi-name="IPCancelTransfer"
*	impl-class-name="eIP.IPCancelTransfer.IPCancelTransferManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPCancelTransfer.IPCancelTransferLocal"
*	remote-class="eIP.IPCancelTransfer.IPCancelTransferRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPCancelTransfer.IPCancelTransferLocalHome"
*	remote-class="eIP.IPCancelTransfer.IPCancelTransferHome"
*	generate= "local,remote"
*
*
*/
public class IPCancelTransferManager implements SessionBean {

Connection con 			= null;
PreparedStatement pstmt = null;
ResultSet rs1 			= null;
ResultSet srs 			= null;
Statement stmt 			= null;
Statement stmt1			= null;

SessionContext ctx;

public void ejbCreate(){}
public void ejbRemove() {}
public void ejbActivate() {}
public void ejbPassivate() {}
public void setSessionContext (SessionContext context){ this.ctx = context;}

			//String nursingunittype		 = "";
			//String tobedtype			 = "";
			String L_current_gender		 = "*";
			String patientgender		 = "";
			//boolean insertable			 = false;
			//String auto_rec_ward_yn		 = "";
			//String fm_install_yn		 = "";
			//String transfter_file_yn	 = "";
			//String auto_file_transfer_yn = "";
			//String fm_fs_locn_code		 = "";
			//String fm_locn_identity	     = "";
			//String file_no				 = "";
			//String practtype			 = "";
			String strInserted			 = "";
			String dateofbirth			 = "";

	public java.util.HashMap ValidateIPCancelTransfer(
			java.util.Properties p,
			String facilityId,
			String patientid,
			String frnursingunitcode,
			String frspecialitycode,
			String frbedno,
			String frroomno
				)
		{
		java.util.HashMap results = new java.util.HashMap() ;
		boolean result			  = true ;

		StringBuffer sb  = new StringBuffer("");
		StringBuffer sql = new StringBuffer("");
			String locale = p.getProperty("LOCALE");
		//String sql = "";

		try
		{
				con = ConnectionManager.getConnection(p);
				L_current_gender = "*";		

				
				if(result)
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" SELECT age_group_code FROM ip_nursing_unit WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+frnursingunitcode+"'");
					
					stmt = con.createStatement();
					srs  = stmt.executeQuery(sql.toString());

					if (srs.next())
					{
						String agegrpcode = srs.getString(1) == null ? "" : srs.getString(1);
						if(!agegrpcode.equals(""))
						{
							//String ageGrpCodesql =  "";
							if(sql.length() > 0) sql.delete(0,sql.length());	
							sql.append(" Select '1' from am_age_group Where age_group_code='"+agegrpcode+"'  And NVL(GENDER,'"+patientgender+"')= '"+patientgender+"' AND  trunc(SYSDATE)- to_date('"+dateofbirth+"','dd/mm/rrrr') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE ");
							if(srs!=null) srs.close();
							if(stmt!=null) stmt.close();

							stmt = con.createStatement();
							srs  = stmt.executeQuery(sql.toString());
							if(!srs.next())
							 {
								result = false;
								java.util.Hashtable message = MessageManager.getMessage(locale, "AGE_GENDER_NOT_ALLOWED","IP" ) ;
								sb.append( (String) message.get("message") ) ;
							 }
							}
					}
					if(srs!=null) srs.close();
					if(stmt!=null) stmt.close();

				}
				if(result)
				{
					if (!(frbedno.equals("") || frbedno == null ))
					{
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append(" Select  sex_spec_ind,Occupying_Patient_Id, bed_type_code, specialty_code from ip_nursing_unit_bed WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+frnursingunitcode+"' And bed_no='"+frbedno+"' ");
						stmt = con.createStatement();
						srs	 = stmt.executeQuery(sql.toString());
						if(!srs.next())
						{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage(locale,"INVALID_BED","Common" ) ;
								sb.append( (String) message.get("message") ) ;
						}
						else
						{
							String occupyingpatientid	= srs.getString("Occupying_Patient_Id") == null ? "" : srs.getString("Occupying_Patient_Id") ;
							String sex_spec_ind			= srs.getString("sex_spec_ind") == null ? "" : srs.getString("sex_spec_ind") ;
							//tobedtype					= srs.getString("bed_type_code")  == null ? "" : srs.getString("bed_type_code");
							String splty_code			= srs.getString("specialty_code")==null ? "" : srs.getString("specialty_code");

							if (!(occupyingpatientid.equals("") || occupyingpatientid.equals(patientid)))
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage(locale,"OCCUPIED_BED","IP") ;
								sb.append( (String) message.get("message") ) ;
							}
							else if (!splty_code.equals("") && !splty_code.equals(frspecialitycode)) //Added 		for specialty to bed validation
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage(locale,"BED_SPLTY_INVALID","IP" ) ;
								sb.append( (String) message.get("message") ) ;
							}
							else if (!sex_spec_ind.equals("") && !sex_spec_ind.equals(patientgender)) //Added 		for gender to bed validation
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage( locale,"AGE_GENDER_NOT_ALLOWED","IP" ) ;
								sb.append( (String) message.get("message") ) ;
							}
						}
						if(srs!=null) srs.close();
						if(stmt!=null) stmt.close();
					}
				}

				 if(result)
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" Select booking_type,override_yn from ip_bed_booking WHERE facility_id='"+facilityId+"' and req_nursing_unit_code='"+frnursingunitcode+"' "+
					" and req_bed_no='"+frbedno+"' and booking_status='0' and sysdate between blocked_from_date_time and blocked_until_date_time ");
					stmt = con.createStatement();
					srs = stmt.executeQuery(sql.toString());
					if(srs.next())
					{
						String bookingtype = srs.getString(1) == null ? "" : srs.getString(1);
						String overrideyn  = srs.getString(2) == null ? "" : srs.getString(2);

						if(overrideyn.equals("N"))
						{
							if (bookingtype.equals("L"))
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage(locale,"NON_OVERRIDEABLE_BKG","IP" ) ;
								sb.append( (String) message.get("message") ) ;
							}
							else
							{
								result = false;
								java.util.Hashtable message = MessageManager.getMessage(locale,"BLOCKED_BED" ,"IP") ;
								sb.append( (String) message.get("message") ) ;
							}
					   }
					   else
					   {
							if (bookingtype.equals("L"))
							{
								result = true;
								java.util.Hashtable message = MessageManager.getMessage(locale,"OVERRIDEABLE_BKG" ,"IP") ;
								sb.append( (String) message.get("message") ) ;
							}
							else
							{
								result = true;
								java.util.Hashtable message = MessageManager.getMessage( locale, "OVERRIDEABLE_BLOCKING","IP" ) ;
								sb.append( (String) message.get("message") ) ;
							}
						}
					}
					if(srs!=null) srs.close();
					if(stmt!=null) stmt.close();
				}

				if(result)
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" select a.occ_male_bed_count,a.occ_female_bed_count,a.occ_unknown_bed_count from ip_nursing_unit_room a, ip_nursing_unit b where a.facility_id='"+facilityId+"' and   a. nursing_unit_code='"+frnursingunitcode+"' and  a.room_no='"+frroomno+"' and  b.facility_id=a.facility_id and  b.nursing_unit_code=a.nursing_unit_code and b.check_same_sex_in_room_yn='Y' ");
		
					stmt = con.createStatement();
					srs = stmt.executeQuery(sql.toString());

					if(srs.next())
					{
						int malebedcount  = srs.getInt(1);
						int femalebedcount = srs.getInt(2);
						int unknownbedcount = srs.getInt(3);

						if(malebedcount > 0) 	{L_current_gender = "M";}
						else if(femalebedcount > 0) {L_current_gender = "F";}
						else if(unknownbedcount > 0) {L_current_gender = "U";}
						else L_current_gender = "*";

						if (!L_current_gender.equals("*") && !L_current_gender.equals(patientgender))
						{
							result = false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"IN_ROOM_ONLY_SAME_GENDER","IP" ) ;
							sb.append( (String) message.get("message") ) ;
						}
					}
					if(srs!=null) srs.close();
					if(stmt!=null) stmt.close();
				}
		}catch(Exception e)
		{
			result  = false;
			sb.append( e.getMessage() +" Error in CancelIPTransfer " ) ;
			e.printStackTrace() ;
			try{
				con.rollback();
			}catch(Exception e1){}
		}
		finally
		{
			try
			{
				if(pstmt != null)	pstmt.close();
			 }catch(Exception ce){}
                if(con != null)      ConnectionManager.returnConnection(con,p);
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;

   } // end ipCancelTransfer

	/*
	This method is used to cancel the transfer.
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

public java.util.HashMap updateIPCancelTransfer(
					java.util.Properties p,	java.util.HashMap hashData  ) 
		{
			String facilityId			 = (String)hashData.get("strFacilityId");	
			String patientid			 = (String)hashData.get("strPatientId");
			String srlno				 = (String)hashData.get("strSrlNo");
			String encounterid			 = (String)hashData.get("strEncounterId");
			String frnursingunitcode	 = (String)hashData.get("strFrNursingUnitCode");
			String tonursingunitcode	 = (String)hashData.get("strToNursingUnitCode");
			//String topractitionerid		 = (String)hashData.get("strToPractitionerid");
			String frspecialitycode		 = (String)	hashData.get("strFrSpecialityCode");
			//String frbedclass			 = (String)hashData.get("strFrBedClass");
			String frbedno				 = (String)hashData.get("strFrBedNo");
			String tobedno				 = (String)hashData.get("strToBedNo");
			String frroomno				 = (String)hashData.get("strFrRoomNo");
			String toroomno				 = (String)hashData.get("strToRoomNo");
			String modifiedAtWorkstation = (String)hashData.get("client_ip_address");
			String cancelreasoncode		 = (String)hashData.get("strCancelReasonCode");

			patientgender				 = (String)hashData.get("patientgender");
			dateofbirth					 = (String)hashData.get("dateofbirth");

			String modifiedById			 = p.getProperty( "login_user" ) ;
			java.util.HashMap results	 = new java.util.HashMap() ;
			boolean result				 = false ;

			StringBuffer sb = new StringBuffer("");
		    results.put( "error", "no error" ) ;
			//String sql = "";
			StringBuffer sql = new StringBuffer("");
			String locale = p.getProperty("LOCALE");
			int rs;
			String ext_num					= "";

			java.util.HashMap ret = ValidateIPCancelTransfer(p,
									facilityId,patientid,frnursingunitcode,frspecialitycode,
									frbedno,frroomno);
			boolean retval = ((Boolean)ret.get("status")).booleanValue();
			String errval  = ((String)ret.get("error"));
			sb.append(errval);

			if(retval)
			{
				if(frroomno == null || frroomno.equals("") || frroomno.equals("null"))
				{
					try
					{
					//String sqlRoom = "";
					if(sql.length() > 0) sql.delete(0,sql.length());				
					sql.append(" Select ROOM_NO from ip_nursing_unit_bed WHERE facility_id='"+facilityId+"' and nursing_unit_code ='" +frnursingunitcode+"' And bed_no='"+frbedno+"' ");
					stmt1 = con.createStatement();
					rs1   = stmt1.executeQuery(sql.toString());

						if(rs1.next())
						{
							frroomno = rs1.getString("ROOM_NO");
							if(frroomno == null)	frroomno = "";
						}
						if(rs1 != null)		rs1.close();
					}catch(Exception e1)
					{
						sb.append(" Exception:"+e1.getMessage()  ) ;	
						e1.printStackTrace();
					}
				}

				if(frroomno == null || frroomno.equals("null") || frroomno.equals(""))
				{
					result = false;
					sb.append("  Room number is Null  ");
				}
				sb.append((String)ret.get("error"));

			try
				{
					con = ConnectionManager.getConnection(p);
					con.setAutoCommit(false);

					
					
					if(!(frroomno == null || frroomno.equals("") || frroomno.equals("null")))
					{
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append("select EXT_NUM from am_facility_room where OPERATING_FACILITY_ID='"+facilityId+"'  and ROOM_NUM='"+frroomno+"' ");
						
						if(rs1!=null) rs1.close();
						pstmt = con.prepareStatement( sql.toString() );
						rs1 = pstmt.executeQuery();

						if(rs1.next())
						{
							ext_num = rs1.getString("EXT_NUM") == null ? "" : rs1.getString("ext_num");
						}

						if(pstmt!=null) pstmt.close();
						if(rs1!=null) rs1.close();			
				
					}		
					

					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" update pr_encounter set assign_care_locn_code = '"+frnursingunitcode+"', assign_room_num= '"+frroomno+"' , assign_bed_num = '"+frbedno+"',  modified_by_id = '"+modifiedById+"', modified_date = sysdate, modified_at_ws_no = '"+modifiedAtWorkstation+"', modified_facility_id = '"+facilityId+"',ROOM_TEL_EXT_NUM='"+ext_num+"'   where facility_id= '"+facilityId+"' and encounter_id = "+encounterid+" ");
					pstmt = con.prepareStatement( sql.toString() );
					rs = pstmt.executeUpdate() ;
					sb.append(sql.toString());
					if(rs > 0)
					{
						result = true;
					}
					else
					{
						 result = false;
                         sb.append(" Error in updating bedno,roomno ....");
                         con.rollback();
					}
					if(pstmt!=null) pstmt.close();

					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("update ip_adt_trn set cancel_reason_code= '"+cancelreasoncode+"', adt_trn_status=9 , modified_by_id='"+modifiedById+"', modified_date=sysdate, modified_at_ws_no='"+modifiedAtWorkstation+"' , modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and encounter_id="+encounterid+" and srl_no="+srlno+" ");
					pstmt = con.prepareStatement( sql.toString() );
					sb.append(sql.toString());
					rs = pstmt.executeUpdate() ;
					if(rs > 0)
					{
						result = true;
					}
					else
					{
						 result = false;
                         sb.append(" Error in updating UPDATE IP_ADT_TRN");
                         con.rollback();
					}
					if(pstmt!=null) pstmt.close();

					int L_male_count    = 0;
					int L_female_count  = 0;
					int L_unknown_count = 0;

					if(patientgender.equals("M")) L_male_count = 1;
					if(patientgender.equals("F")) L_female_count = 1;
					if(patientgender.equals("U")) L_unknown_count = 1;
				
					if(!frroomno.equals(toroomno))
					{   /*Added Audit column*/
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append(" update ip_nursing_unit_room set  occ_male_bed_count = occ_male_bed_count+"+L_male_count+", occ_female_bed_count = occ_female_bed_count+"+L_female_count+",  occ_unknown_bed_count = occ_unknown_bed_count+"+L_unknown_count+", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '"+ facilityId +"', modified_at_ws_no = '"+ modifiedAtWorkstation +"' where facility_id='"+facilityId+"' and nursing_unit_code ='"+frnursingunitcode+"' and room_no = '"+frroomno+"' ");
						sb.append(sql.toString());
						
						pstmt = con.prepareStatement(sql.toString());
						int res3 = pstmt.executeUpdate() ;
						if(res3 > 0)
						{
						result = true;
						}
						else
						{
						 result = false;
                         sb.append(" Error in updating Uip_nursing_unit_room");
                         con.rollback();
						}
						if(pstmt!=null) pstmt.close();	
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append(" update ip_nursing_unit_room set  occ_male_bed_count = occ_male_bed_count-"+L_male_count+", occ_female_bed_count = occ_female_bed_count-"+L_female_count+",  occ_unknown_bed_count = occ_unknown_bed_count-"+L_unknown_count+", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '"+ facilityId +"', modified_at_ws_no = '"+ modifiedAtWorkstation +"' where facility_id='"+facilityId+"' and nursing_unit_code = '"+tonursingunitcode+"' and room_no = '"+toroomno+"' ");
						sb.append(sql.toString());
						 /*Added Audit column*/
						
						res3 = pstmt.executeUpdate() ;
						if(res3 > 0)
						{
						result = true;
						}
						else
						{
						 result = false;
                         sb.append(" Error in updating ip_nursing_unit_room");
                         con.rollback();
						}
					}

					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("update ip_nursing_unit_bed set occupying_patient_id='"+patientid+"' , current_status='O'  ");
					//updating audit columns
					sql.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
					sql.append( facilityId +"', modified_at_ws_no = '"+ modifiedAtWorkstation +"'");
					sql.append(" where facility_id='"+facilityId+"' and nursing_unit_code='"+frnursingunitcode+"' and bed_no='"+frbedno+"' ");
					sb.append(sql.toString());
					
					pstmt = con.prepareStatement(sql.toString());
					
					rs = pstmt.executeUpdate() ;
					if(rs > 0)
						{
						result = true;
						}
						else
						{
						 result = false;
                         sb.append(" Error in updating ip_nursing_unit_bed");
                         con.rollback();
						}
					if(pstmt!=null) pstmt.close();

					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("update ip_nursing_unit_bed set occupying_patient_id='' , current_status='A' ");
					//updating audit columns
					sql.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
					sql.append( facilityId +"', modified_at_ws_no = '"+ modifiedAtWorkstation +"'");
					sql.append(" where facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode+"' and bed_no='"+tobedno+"' ");
					sb.append(sql.toString());
					pstmt = con.prepareStatement(sql.toString());

					rs = pstmt.executeUpdate() ;
					 sb.append("rs="+rs);
					if(rs > 0)
						{
						 result = true;
						 con.commit();
						java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED","SM" ) ;
						strInserted =  (String) message.get("message")  ;
						}
						else
						{
						 result = false;
                         sb.append(" Error in updating ip_nursing_unit_bed");
                         con.rollback();
						}
				}
					catch ( Exception e ) {
					sb.append( e.getMessage()  ) ;
					e.printStackTrace() ;
					try
					{
						con.rollback();						
					}catch(Exception e1){}
				}
				finally 
				{
					try
					{
						if(rs1 != null)		rs1.close();
						if(stmt1 != null)	stmt1.close();
						if(pstmt != null)	pstmt.close() ;
					}catch(Exception ce){}
					if(con != null)      ConnectionManager.returnConnection(con,p);
				}
			}			
			results.put( "status", new Boolean(result) ) ;
			results.put("message",strInserted);
			results.put( "error", sb.toString() ) ;
			return results ;
		}
} // end session bean

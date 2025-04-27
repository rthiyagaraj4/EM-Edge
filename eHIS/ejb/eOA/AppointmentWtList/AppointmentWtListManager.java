/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA.AppointmentWtList;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;
/**
*
* @ejb.bean
*	name="AppointmentWtList"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AppointmentWtList"
*	local-jndi-name="AppointmentWtList"
*	impl-class-name="eOA.AppointmentWtList.AppointmentWtListManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOA.AppointmentWtList.AppointmentWtListManagerLocal"
*	remote-class="eOA.AppointmentWtList.AppointmentWtListManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOA.AppointmentWtList.AppointmentWtListManagerLocalHome"
*	remote-class="eOA.AppointmentWtList.AppointmentWtListManagerHome"
*	generate= "local,remote"
*
*
*/


public class AppointmentWtListManager implements SessionBean {

	Connection con =null;
	CallableStatement clblstmt=null;
	String tmpp1="",tmpp2="",tmpp3="",tmpp4="";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/mm/yyyy" ) ;
	PreparedStatement pstmt1=null;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;
	SessionContext ctx;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx=context;}
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap insertAppointmentWtList(
							java.util.Properties p,
							java.util.HashMap passObjects
					) 
		{
		
		

		
		java.util.Hashtable message=new java.util.Hashtable(); 
		String facilityId=(String) passObjects.get("addedFacilityId");


		String cliniccode=(String) passObjects.get("cliniccode");
		String practitionerid=(String) passObjects.get("practitionerid");
		String apptdatetime=(String) passObjects.get("apptdatetime");
		


		String patientid=(String) passObjects.get("patientid");


		String prefix=(String) passObjects.get("prefix");
		String firstname=(String) passObjects.get("firstname");
		String secondname=(String) passObjects.get("secondname");
		String thirdname=(String) passObjects.get("thirdname");
		String familyname=(String) passObjects.get("familyname");
		String suffix=(String) passObjects.get("suffix");
		String patientname=(String) passObjects.get("patientname");
		String gender=(String) passObjects.get("gender");
		String dateofbirth=(String) passObjects.get("dateofbirth");

		String patient_name_long=(String)passObjects.get("patient_name_long");
		String patient_name_loc_lang_long=(String)passObjects.get("patient_name_loc_lang_long");
		
		String nationalidno=(String) passObjects.get("nationalidno");


		String altid1no=(String) passObjects.get("altid1no");
		String restelno=(String) passObjects.get("restelno");
		String othtelno=(String) passObjects.get("othtelno");
		String emailid=(String) passObjects.get("emailid");
		String nationality_code=(String) passObjects.get("nationality_code");
		String addedAtWorkstation=(String) passObjects.get("addedAtWorkstation");
		String priority=(String) passObjects.get("priority");
		String altid1typ=(String) passObjects.get("altid1typ");
		String altid1expdt=(String) passObjects.get("altid1expdt");
		String altid2no=(String) passObjects.get("altid2no");
		String altid2typ=(String) passObjects.get("altid2typ");
		String altid2expdt=(String) passObjects.get("altid2expdt");
		String altid3no=(String) passObjects.get("altid3no");
		String altid3typ=(String) passObjects.get("altid3typ");
		String altid3expdt=(String) passObjects.get("altid3expdt");
		String altid4no=(String) passObjects.get("altid4no");
		String altid4typ=(String) passObjects.get("altid4typ");
		String altid4expdt=(String) passObjects.get("altid4expdt");
		String Othaltid1=(String) passObjects.get("Othaltid1");
		String Othaltid1typ=(String) passObjects.get("Othaltid1typ");
		String ethnicGrp=(String) passObjects.get("ethnicGrp");
		String birthPlace=(String) passObjects.get("birthPlace");
		String residency=(String) passObjects.get("residency");
		String status=(String) passObjects.get("status");
		String ethnicSbGrp=(String) passObjects.get("ethnicSbGrp");
		String res_addr1=(String) passObjects.get("res_addr1");
		String res_addr2=(String) passObjects.get("res_addr2");
		String res_addr3=(String) passObjects.get("res_addr3");
		String res_addr4=(String) passObjects.get("res_addr4");
		String res_town=(String) passObjects.get("res_town");
		String res_area=(String) passObjects.get("res_area");
		String res_postal=(String) passObjects.get("res_postal");
		String res_region=(String) passObjects.get("res_region");
		String res_country=(String) passObjects.get("res_country");
		String mail_addr1=(String) passObjects.get("mail_addr1");
		String mail_addr2=(String) passObjects.get("mail_addr2");
		String mail_addr3=(String) passObjects.get("mail_addr3");
		String mail_addr4=(String) passObjects.get("mail_addr4");
		String mail_town=(String) passObjects.get("mail_town");
		String mail_area=(String) passObjects.get("mail_area");
		String mail_postal=(String) passObjects.get("mail_postal");
		String mail_region=(String) passObjects.get("mail_region"); 
		String mail_country=(String) passObjects.get("mail_country");
		String birthPlace_desc=(String) passObjects.get("birthPlace_desc");
		String clinic_type=(String) passObjects.get("clinic_type");
		String res_class=(String) passObjects.get("res_class");
		String speciality=(String) passObjects.get("specality");
		String wtlt_category=(String) passObjects.get("wtlt_category");
		String walst_category_code=(String)passObjects.get("walst_category_code");
		String name_prefix_oth_lang=(String) passObjects.get("name_prefix_oth_lang");
		String first_name_oth_lang=(String) passObjects.get("first_name_oth_lang");
		String second_name_oth_lang=(String) passObjects.get("second_name_oth_lang");
		String third_name_oth_lang=(String) passObjects.get("third_name_oth_lang");
		String family_name_oth_lang=(String) passObjects.get("family_name_oth_lang");
		String name_suffix_oth_lang=(String) passObjects.get("name_suffix_oth_lang");
		String patient_name_local_lang=(String) passObjects.get("patient_name_local_lang");
		String reason_create_waitlist=(String) passObjects.get("reason_create_waitlist");
		String fromfacilityid=(String) passObjects.get("fromfacilityid");
		String fromencounterid=(String) (passObjects.get("fromencounterid")==null?"":passObjects.get("fromencounterid"));
		String wait_list_ref_no=(String) (passObjects.get("wait_list_ref_no")==null?"":passObjects.get("wait_list_ref_no"));
		String rd_waitlist_yn=(String) (passObjects.get("rd_waitlist_yn")==null?"N":passObjects.get("rd_waitlist_yn"));
		String multi_speciality_yn=(String) (passObjects.get("multi_speciality_yn")==null?"N":passObjects.get("multi_speciality_yn"));//Added for the CRf - Bru-HIMS-CRF-0198
		//String web_request_yn=(String) (passObjects.get("web_request_yn")==null?"N":passObjects.get("web_request_yn"));
		 
		 /*Below Line Commented and Added for this CRF [Bru-HIMS-CRF-0166]*/
		String apptreffno=(String) (passObjects.get("apptreffno")==null?"":passObjects.get("apptreffno"));
		String rescheduleflag=(String) (passObjects.get("rescheduleflag")==null?"":passObjects.get("rescheduleflag"));
		
		/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
		String altAddrLine1		= checkForNull((String)passObjects.get("altAddrLine1"));
		String altAddrLine2		= checkForNull((String)passObjects.get("altAddrLine2"));
		String altAddrLine3		= checkForNull((String)passObjects.get("altAddrLine3"));
		String altAddrLine4		= checkForNull((String)passObjects.get("altAddrLine4"));
		String altAreaCode		= checkForNull((String)passObjects.get("altAreaCode"));
		String altTownCode		= checkForNull((String)passObjects.get("altTownCode"));
		String altPostalCode	= checkForNull((String)passObjects.get("altPostalCode"));
		String altRegionCode	= checkForNull((String)passObjects.get("altRegionCode"));
		String altCountryCode	= checkForNull((String)passObjects.get("altCountryCode"));
		/*End*/
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		String smartCardFunc=checkForNull((String) passObjects.get("smartCardFunc"));
		String biometric_reason=checkForNull((String) passObjects.get("biometric_reason"));
		//Ends
		String remarks_create_waitlist	= checkForNull((String)passObjects.get("remarks_create_waitlist")); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

		String locale = p.getProperty("LOCALE");
		if(fromfacilityid.equals("null"))
			fromfacilityid="";
		if(fromencounterid.equals("null"))
			fromencounterid="";	
		if(wait_list_ref_no.equals("null"))
			wait_list_ref_no=""; 



		boolean result = false ;
		java.util.HashMap results1 = new java.util.HashMap() ;
		java.lang.StringBuffer sb = new java.lang.StringBuffer( "" ) ;


		String addedById = p.getProperty( "login_user" ) ;

		try{
			con = ConnectionManager.getConnection(p);	
			con.setAutoCommit(false);
		    smartCardFunc	= eCommon.Common.CommonBean.isSiteSpecificforBiometric(con);//added by Himanshu Saxena for AAKH-CRF-0175 as on 23-08-2023 
			//clblstmt=con.prepareCall("{call INSERT_PR_WAIT_LIST( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			clblstmt=con.prepareCall("{call INSERT_PR_WAIT_LIST( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//Modified by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601

			if(altid1expdt.equals("N"))
				tmpp1="";
			else
				tmpp1=altid1expdt;

			if(altid2expdt.equals("N"))
				tmpp2="";
			else
				tmpp2=altid2expdt;

			if(altid3expdt.equals("N"))
				tmpp3="";
			else
				tmpp3=altid3expdt;

			if(altid4expdt.equals("N"))
			{
				tmpp4="";
			}else
			{
				tmpp4=altid4expdt;
			}
			
			clblstmt.setString( 1,facilityId);
			clblstmt.setString( 2,apptdatetime);
			clblstmt.setString( 3,priority);
			clblstmt.setString( 4,speciality);
			clblstmt.setString( 5,cliniccode);
			clblstmt.setString( 6,res_class);
			clblstmt.setString( 7,practitionerid);
			clblstmt.setString( 8,"");
			clblstmt.setString( 9,patientid);
			clblstmt.setString( 10,nationalidno);
			clblstmt.setString( 11,altid1typ);

			clblstmt.setString( 12,altid1no);
			clblstmt.setString( 13,tmpp1);
			clblstmt.setString( 14,altid2typ);
			clblstmt.setString( 15,altid2no);
			clblstmt.setString( 16,tmpp2);
			clblstmt.setString( 17,altid3typ);
			clblstmt.setString( 18,altid3no);
			clblstmt.setString( 19,tmpp3);
			clblstmt.setString( 20,altid4typ);
			clblstmt.setString( 21,altid4no);
			clblstmt.setString( 22,tmpp4);
			clblstmt.setString( 23,Othaltid1typ);
			clblstmt.setString( 24,Othaltid1);
			clblstmt.setString( 25,prefix);
			clblstmt.setString( 26,firstname);
			clblstmt.setString( 27,secondname);
			clblstmt.setString( 28,thirdname);
			clblstmt.setString( 29,familyname);
			clblstmt.setString( 30,suffix);			
			clblstmt.setString( 31,patientname);
			clblstmt.setString( 32,gender);

			clblstmt.setString( 33,dateofbirth);

			clblstmt.setString( 34,nationality_code);
			clblstmt.setString( 35,ethnicGrp);
			clblstmt.setString( 36,ethnicSbGrp);
			clblstmt.setString( 37,residency);
			clblstmt.setString( 38,status);
			clblstmt.setString( 39,res_addr1);
			clblstmt.setString( 40,res_addr2);
			clblstmt.setString( 41,res_addr3);
			clblstmt.setString( 42,res_addr4);
			clblstmt.setString( 43,res_area);
			clblstmt.setString( 44,res_town);
			clblstmt.setString( 45,res_region);
			clblstmt.setString( 46,res_postal);
			clblstmt.setString( 47,res_country);
			clblstmt.setString( 48,restelno);
			clblstmt.setString( 49,othtelno);
			clblstmt.setString( 50,emailid);

			clblstmt.setString( 51,mail_addr1);
			clblstmt.setString( 52,mail_addr2);
			clblstmt.setString( 53,mail_addr3);
			clblstmt.setString( 54,mail_addr4);
			clblstmt.setString( 55,mail_area);
			clblstmt.setString( 56,mail_town);
			clblstmt.setString( 57,mail_region);
			clblstmt.setString( 58,mail_postal);
			clblstmt.setString( 59,mail_country);
			clblstmt.setString( 60,"O");
			clblstmt.setString( 61,addedById);
			clblstmt.setString( 62,addedAtWorkstation);
			clblstmt.setString( 63,facilityId);

			clblstmt.setString( 64,addedById);
			clblstmt.setString( 65,addedAtWorkstation);
			clblstmt.setString( 66,facilityId);
			clblstmt.setString( 67,clinic_type);

			clblstmt.setString( 68,birthPlace);
			clblstmt.setString( 69,birthPlace_desc);
			clblstmt.setString( 70,wtlt_category);
			clblstmt.setString( 71,walst_category_code);
			clblstmt.setString( 72,name_prefix_oth_lang);
			clblstmt.setString( 73,first_name_oth_lang);
			clblstmt.setString( 74,second_name_oth_lang);
			clblstmt.setString( 75,third_name_oth_lang);
			clblstmt.setString( 76,family_name_oth_lang);
			clblstmt.setString( 77,name_suffix_oth_lang);
			clblstmt.setString( 78,patient_name_local_lang);
			clblstmt.setString( 79,reason_create_waitlist);
			clblstmt.setString( 80,fromfacilityid);
			clblstmt.setString( 81,fromencounterid);	
			clblstmt.setString( 82,wait_list_ref_no);
			clblstmt.setString ( 83,patient_name_loc_lang_long);
			clblstmt.setString ( 84,patient_name_long );
			clblstmt.setString ( 85,rd_waitlist_yn );
			clblstmt.setString ( 86,multi_speciality_yn );//Added for the CRF - Bru-HIMS-CRF-0198
			/*Added by Thamizh selvi on 5th Jan 2018 against ML-MMOH-CRF-0601 Start*/
			clblstmt.setString ( 87,altAddrLine1 );
			clblstmt.setString ( 88,altAddrLine2 );
			clblstmt.setString ( 89,altAddrLine3 );
			clblstmt.setString ( 90,altAddrLine4 );
			clblstmt.setString ( 91,altAreaCode );
			clblstmt.setString ( 92,altTownCode );
			clblstmt.setString ( 93,altRegionCode );
			clblstmt.setString ( 94,altPostalCode );
			clblstmt.setString ( 95,altCountryCode );
			/*End*/
			clblstmt.registerOutParameter(96 ,Types.VARCHAR );
			clblstmt.registerOutParameter(97 ,Types.VARCHAR );
			//clblstmt.setString( 84,wait_list_ref_no);

			clblstmt.setString( 98,remarks_create_waitlist); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
             
			clblstmt.execute() ; 
			String err_message=clblstmt.getString( 96 ); 
			String appt_no=clblstmt.getString( 97 ); 
			if(appt_no==null) appt_no="";
			if(err_message==null) err_message="";
			if(err_message.equals("")){
			if(rescheduleflag.equals("Y")){			
			//Updating audit columns::
            String update="update oa_appt_del_tr set NEW_WAIT_LIST_NO='"+appt_no+"', MODIFIED_BY_ID='"+addedById+"',MODIFIED_AT_WS_NO='"+addedAtWorkstation+"', MODIFIED_DATE=sysdate, MODIFIED_FACILITY_ID='"+facilityId+"' where facility_id='"+facilityId+"' and APPT_REF_NO='"+apptreffno+"' and APPT_STATUS ='C'";	 			
			pstmt1=con.prepareStatement(update);
			pstmt1.executeUpdate();
			}

			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
			//Starts
			try 
				{
								
				if(smartCardFunc.equals("01") && !biometric_reason.equals(""))
					{
					String status1=eCommon.Common.CommonBean.insertReasonforBiometric(con,facilityId,"OA_CREATE_WAITLIST",patientid,appt_no,cliniccode,biometric_reason,addedAtWorkstation,addedById);
					
					if(status1.equals("S"))
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
			
			con.commit();
					
				result=true;
				 message = MessageManager.getMessage(locale,"WAITLIST_CREATED","OA" ) ;
				String xxx=(String) message.get("message");
				
				int len=xxx.length();
				String error_val=xxx.substring(0,len-1);
				error_val=error_val+appt_no;
				 error_val=xxx.replace("$",appt_no);
					//String error_val="Your Appointment request has been logged. Your request number is "+appt_no+", kindly retain this number for further communication.";
				sb.append(error_val);
				//sb.append( " With Wait List Number :"+appt_no);
			}else{
				con.rollback();
				result=false;				
				sb.append(err_message) ;

			}
			if(clblstmt!= null) clblstmt.close() ;
			if(pstmt1 !=null) pstmt1.close();
		}catch ( Exception e ) {
			e.printStackTrace();
			result=false;
			sb.append(e.getMessage() + "<br>" ) ;
		}finally{
			if (con != null) ConnectionManager.returnConnection(con,p);
		}
		results1.put( "status", new Boolean(result) ) ;
		results1.put( "error", sb.toString() ) ;
		sb.setLength(0);
		passObjects.clear();
		message.clear();
		return results1 ;		
   }//Method

/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap invitationWaitList(
							java.util.Properties p,
							java.util.HashMap passObjects
					) 
		{

		Integer count=(Integer)passObjects.get("count");
		// Getting facility id for updating audit columns::
		String facilityId=(String)passObjects.get("facilityId");
		
		 int totalCount			= count.intValue();
		// p = (java.util.Properties) session.getValue("jdbc") ;
		String	client_ip_address = p.getProperty("client_ip_address");
		//String addedDate = dateFormat.format( new java.util.Date() ) ;
		String addedById = p.getProperty( "login_user" ) ;
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		String smartCardFunc=(String) passObjects.get("smartCardFunc");
		String biometric_reason=(String) passObjects.get("biometric_reason");
		String clinic_type=(String) passObjects.get("clinic_type");	
		String patient_id=(String) passObjects.get("patient_id");
		
		//Ends
		String wait_list_no_main="";
		String wait_list_date_val="";
		String status_val="";
		String sql="";
		boolean result = false ;
		int rset1=0;
		
		java.util.HashMap results1 = new java.util.HashMap() ;
		java.lang.StringBuffer sb = new java.lang.StringBuffer( "" ) ;

					try
				{
					con = ConnectionManager.getConnection(p);	
					con.setAutoCommit(false);
					smartCardFunc	= eCommon.Common.CommonBean.isSiteSpecificforBiometric(con);//added by Himanshu Saxena for AAKH-CRF-0175 as on 23-08-2023 
					ResultSet rs=null;
					/*
						Statement stmtsd=null;
						stmtsd=con.createStatement();
						String sys_date="";					
						String sql2="select to_char(sysdate,'dd/mm/yyyy') sys_dt,to_char(sysdate,'hh24:mi')systm from dual";
						rs=stmtsd.executeQuery(sql2);
						while(rs.next())
						{
							sys_date=rs.getString("sys_dt");
							sys_time=rs.getString("systm");
						}
						if(rs !=null) rs.close();
					*/

				for (int i=0;i<totalCount;i++ )
				{
					wait_list_no_main=(String)passObjects.get("waitlistnum"+i);
					wait_list_date_val=(String)passObjects.get("inviteddate"+i);
					status_val=(String)passObjects.get("status"+i);
					if(status_val.equals("I"))
					{
						//Updating audit columns::
						 sql="update pr_wait_list set WAIT_LIST_STATUS='"+status_val+"',INVITED_DATE_TIME=to_date('"+wait_list_date_val+"','dd/mm/yyyy'),MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=trunc(sysdate) ,MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID='"+facilityId+"', INVITATION_NUMBER=(select abs(dbms_random.random) from dual) where WAIT_LIST_NO='"+wait_list_no_main+"'";
					}else
					{
						//Updating audit columns::
						 sql="update pr_wait_list set WAIT_LIST_STATUS='"+status_val+"',INVITED_DATE_TIME=to_date('"+wait_list_date_val+"','dd/mm/yyyy') ,INVITATION_NUMBER ='',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=trunc(sysdate),MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID='"+facilityId+"' where WAIT_LIST_NO='"+wait_list_no_main+"'";
						
					}
					pstmt1=con.prepareStatement(sql);
					rset1=pstmt1.executeUpdate();
					//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
					//Starts
					try 
						{
						if(rset1!=0 && smartCardFunc.equals("01") && !biometric_reason.equals(""))
							{
							String status1=eCommon.Common.CommonBean.insertReasonforBiometric(con,facilityId,"OA_INVITE_WAITLIST",patient_id,wait_list_no_main,clinic_type,biometric_reason,client_ip_address,addedById);
							if(status1.equals("S"))
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
					if(!result && rset1==0) { 
						con.rollback();
						result=false;
					} else {
						con.commit();
						result=true;
						sb.append( "Operation Completed :") ;
					}
					if(pstmt1 !=null) pstmt1.close();

				}
	if(rs !=null) rs.close();
	//if(stmtsd !=null) stmtsd.close();

			}
			catch (Exception e) {					
					e.printStackTrace();
			}finally {
			if (con != null) ConnectionManager.returnConnection(con,p);
			}
			
		results1.put( "status", new Boolean(result) ) ;
		results1.put( "error", sb.toString() ) ;
		sb.setLength(0);
		passObjects.clear();
		return results1 ;
		}//Method

 public static String checkForNull(String inputString){
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
 }

}

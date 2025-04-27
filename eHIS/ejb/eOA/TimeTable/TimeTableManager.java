/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
	Modified & Developed by 	:	R.Nanda Kumar
	Created on 					:	24/02/2001
	Module						:	OA
	Function					:	Appointments - Time Table. This is the actual implementation of the
									functions defined in the remote.
*/


package eOA.TimeTable;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.*;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="TimeTable"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TimeTable"
*	local-jndi-name="TimeTable"
*	impl-class-name="eOA.TimeTable.TimeTableManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOA.TimeTable.TimeTableLocal"
*	remote-class="eOA.TimeTable.TimeTableRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOA.TimeTable.TimeTableLocalHome"
*	remote-class="eOA.TimeTable.TimeTableHome"
*	generate= "local,remote"
*
*
*/

public class TimeTableManager implements SessionBean
{
    Connection con =null;
    PreparedStatement pstmt =null;
	CallableStatement callablestatement=null,callablestatement_alloc=null,callableSt=null;
	public final String RECORD_INSERTED 	= "RECORD_INSERTED" ;
    public final String RECORD_DELETED 		= "RECORD_DELETED" ;
   	SessionContext ctx;
	public void ejbCreate()  {}
    public void ejbRemove() {}
    public void ejbActivate() {}
    public void ejbPassivate() {}
    public void setSessionContext( SessionContext context ) { this.ctx=context;}
/**
* @ejb.interface-method
*	 view-type="both"
*/	
	public java.util.HashMap insertTimeTableforAll(java.util.Properties p,
			java.util.HashMap passObjects
		) 
	{

		System.out.println("TimeTableManager insertTimeTableforAll :"+passObjects.toString());
		String facilityId=(String) passObjects.get("addedFacilityId");
		String p_clinic_code =(String) passObjects.get("p_clinic_code");
		String p_day_no =(String) passObjects.get("p_day_no");
		String p_practitioner_id =(String) passObjects.get("p_practitioner_id");
		String p_time_table_type =(String) passObjects.get("p_time_table_type");
		String p_remarks =(String) passObjects.get("p_remarks");
		String p_start_time =(String) passObjects.get("p_start_time");
		String p_end_time =(String) passObjects.get("p_end_time");
		String p_time_per_patient =(String) passObjects.get("p_time_per_patient");
		String p_max_patients_per_day =(String) passObjects.get("p_max_patients_per_day");
		String p_time_per_slab =(String) passObjects.get("p_time_per_slab");
		String p_max_patients_per_slab =(String) passObjects.get("p_max_patients_per_slab");
		String p_max_first_visits =(String) passObjects.get("p_max_first_visits");
		String p_max_over_bookings =(String) passObjects.get("p_max_over_bookings");
		String b_max_slots_for_first_visit=(String) passObjects.get("b_max_slots_for_first_visit");
		String p_phys_roster_reqd_yn =(String) passObjects.get("p_phys_roster_reqd_yn");
		String p_alcn_criteria=(String) passObjects.get("p_alcn_criteria");
		String b_max_slots_per_day =(String) passObjects.get("b_max_slots_per_day");
		String b_max_other_visits =(String) passObjects.get("b_max_other_visits");
		String p_resource_type=(String) passObjects.get("p_resource_type");
		String p_forced_allowed_yn =(String) passObjects.get("p_forced_allowed_yn");
		
			/*if(p_forced_allowed_yn==null || p_forced_allowed_yn.equals("")){
				p_forced_allowed_yn="N";
			}else{
				p_forced_allowed_yn="Y";
			}*/

		String p_no_forced_booking =(String) passObjects.get("p_no_forced_booking");
		String p_no_global_ref=(String) passObjects.get("p_no_global_ref");
		String addedAtWorkstation=(String) passObjects.get("addedAtWorkstation");
		String p_break_time_1_from=(String) passObjects.get("p_break_time_1_from");
		String p_break_time_1_to=(String) passObjects.get("p_break_time_1_to");
		String p_break_time_2_from=(String) passObjects.get("p_break_time_2_from");
		String p_break_time_2_to=(String) passObjects.get("p_break_time_2_to");
		String p_break_time_3_from=(String) passObjects.get("p_break_time_3_from");
		String p_break_time_3_to=(String) passObjects.get("p_break_time_3_to");
		String p_break_time_4_from=(String) passObjects.get("p_break_time_4_from");
		String p_break_time_4_to=(String) passObjects.get("p_break_time_4_to");
		String p_break_time_5_from=(String) passObjects.get("p_break_time_5_from");
		String p_break_time_5_to=(String) passObjects.get("p_break_time_5_to");
		String final_string=(String) passObjects.get("final_string");
		String alcn_basis=(String) passObjects.get("alcn_basis");
		String location_type=(String) passObjects.get("location");
		String max_new_patients=(String) passObjects.get("max_new_patients");
		String max_old_patients=(String) passObjects.get("max_old_patients");
		String schedule_extend_yn=(String) passObjects.get("schedule_extend_yn");//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
		
		//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
		String ext_all_slots_yn = (String)passObjects.get("ext_all_slots_yn");
		String ext_start_slots = (String)passObjects.get("ext_start_slots");
		String ext_mid_slots = (String)passObjects.get("ext_mid_slots");
		String ext_end_slots = (String)passObjects.get("ext_end_slots");

		String locale = p.getProperty("LOCALE");

			


		b_max_slots_for_first_visit="0";
		java.util.HashMap results = new java.util.HashMap() ;
	    boolean result = false ;
		StringBuffer sb = new StringBuffer( "" ) ;
	    String addedById = p.getProperty( "login_user" ) ;
	   	String modifiedAtWorkstation = addedAtWorkstation ;
		int p_max_patients=Integer.parseInt(p_max_patients_per_day);
	    try
	    {

				
				con = ConnectionManager.getConnection(p);
				con.setAutoCommit( false );
				callablestatement = con.prepareCall("{call OA_CREATE_TIME_TABLES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				callablestatement.setString(1,facilityId);

                callablestatement.setString(2,p_clinic_code );

                callablestatement.setString(3,p_day_no );

                callablestatement.setString(4,p_practitioner_id );

                callablestatement.setString(5,p_time_table_type );

                callablestatement.setString(6,p_remarks );

                callablestatement.setString(7,p_start_time );

                callablestatement.setString(8,p_end_time );

                callablestatement.setString(9,p_time_per_patient );
				callablestatement.setString(10,p_max_patients_per_day );
                callablestatement.setString(11,p_time_per_slab);
                callablestatement.setString(12,p_max_patients_per_slab);
                callablestatement.setString(13,p_max_first_visits );
				callablestatement.setString(14,p_max_over_bookings );
				callablestatement.setString(15,b_max_slots_for_first_visit );
				callablestatement.setString(16,b_max_slots_per_day );
				callablestatement.setString(17,b_max_other_visits );
				callablestatement.setString(18,p_alcn_criteria );
				callablestatement.setString(19,p_phys_roster_reqd_yn );
				callablestatement.setString(20,p_break_time_1_from );
				callablestatement.setString(21,p_break_time_1_to);
				callablestatement.setString(22,p_break_time_2_from );
				callablestatement.setString(23,p_break_time_2_to );
				callablestatement.setString(24,p_break_time_3_from );
				callablestatement.setString(25,p_break_time_3_to );
				callablestatement.setString(26,p_break_time_4_from );
				callablestatement.setString(27,p_break_time_4_to );
				callablestatement.setString(28,p_break_time_5_from );
				callablestatement.setString(29,p_break_time_5_to );
				callablestatement.setString(30,addedById);
				callablestatement.setString(31,addedAtWorkstation);
				callablestatement.setString(32,p_resource_type ) ;
				callablestatement.setString(33,p_forced_allowed_yn ) ;
				callablestatement.setString(34,p_no_forced_booking ) ;
				callablestatement.setString(35,p_no_global_ref ) ;
				callablestatement.setString(36,location_type ) ;
				callablestatement.setString(37,p_resource_type ) ;
                callablestatement.registerOutParameter(38,Types.VARCHAR);
                callablestatement.setInt(39,Integer.parseInt(max_new_patients));
                callablestatement.setInt(40,Integer.parseInt(max_old_patients));
				callablestatement.setString(41,schedule_extend_yn ) ;
				callablestatement.setString(42,ext_all_slots_yn ) ;
				callablestatement.setString(43,ext_start_slots ) ;
				callablestatement.setString(44,ext_mid_slots ) ;
				callablestatement.setString(45,ext_end_slots ) ;
                callablestatement.execute();
				String result_proc = callablestatement.getString(38);
			
			if(result_proc!=null && result_proc.equals("SUCCESS"))
            {
			  if(final_string!=null && !(final_string.equals("")))
			   {
				    callablestatement_alloc = con.prepareCall("{call oa_allocate_clinics(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					callablestatement_alloc.setString(1,facilityId);
					callablestatement_alloc.setString(2,p_clinic_code );
					callablestatement_alloc.setString(3,p_day_no );
					callablestatement_alloc.setString(4,p_practitioner_id );
					callablestatement_alloc.setInt(5,p_max_patients);
					callablestatement_alloc.setString(6,p_alcn_criteria );
					callablestatement_alloc.setString(7,alcn_basis );
					callablestatement_alloc.setString(8,final_string );
					callablestatement_alloc.setString(9,addedById );
					callablestatement_alloc.setString(10,modifiedAtWorkstation );
					callablestatement_alloc.setString(11,location_type ) ;
					callablestatement_alloc.setString(12,p_resource_type ) ;
					callablestatement_alloc.registerOutParameter(13,Types.VARCHAR);
					callablestatement_alloc.execute();
					String result_proc_alloc = callablestatement_alloc.getString(13);


					if(result_proc_alloc!=null && result_proc_alloc.equals("SUCCESS"))
					{
					result=true;
					java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
					sb.append( (String) message.get("message") ) ;
					con.commit();
					message.clear();
					}else{
					  result=false;
					  con.rollback();
					  sb.append(result_proc_alloc);
					}
				}else{
					result=true;
					java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
					sb.append( (String) message.get("message") ) ;
					con.commit();
					message.clear();
					}
			}else{
			  result=false;
			  con.rollback();
			  sb.append(result_proc);
			}
		if(callablestatement_alloc!=null) callablestatement_alloc.close();
		if(callablestatement!=null) callablestatement.close();	
		if(callableSt!=null) callableSt.close();
		passObjects.clear();
		}catch(Exception exception){
			sb.append("Error from EJB  :"+exception.toString());
			exception.printStackTrace();
		}
		finally
		{
		   	ConnectionManager.returnConnection(con,p);
		}
		results.put( "status", new Boolean(result) ) ;
	    results.put( "error", sb.toString() ) ;
		sb.setLength(0);
	    return results ;
	}//method
/**
* @ejb.interface-method
*	 view-type="both"
*/
public java.util.HashMap deleteTimeTable(java.util.Properties p,
					java.util.HashMap passObjects
		) 
	    {
		String facilityId=(String) passObjects.get("addedFacilityId");
		String p_clinic_code =(String) passObjects.get("p_clinic_code");
		String p_day_no =(String) passObjects.get("p_day_no");
		String p_practitioner_id =(String) passObjects.get("p_practitioner_id");
		String locationType=(String) passObjects.get("location");
		String resourceClass=(String) passObjects.get("p_resource_type");
		PreparedStatement SrlNo_pstmt =null;
		PreparedStatement TransRecord_pstmt =null;
		ResultSet maxSrlRset=null;
		String maxSrlnoStr=null;
		int MaxSrlNo=0;

		
		
		String locale = p.getProperty("LOCALE");
		

	    java.util.HashMap results = new java.util.HashMap() ;
	    boolean result = false ;
	    StringBuffer sb = new StringBuffer( "" ) ;
		String addedById = p.getProperty( "login_user" ) ;
		String select_trans_recordSQL		= " Select nvl(max(srl_no),0)+1 max from oa_trans_record where facility_id=? ";
		String insert_trans_recordSQL		= " Insert into oa_trans_record (facility_id,srl_no,trans_code,trans_date_time, trans_eff_by_id,  from_date_entered,to_date_entered,  clinic_code,from_practitioner_id,from_day_no,remarks,reason_code,care_locn_type_ind,resource_class)  values (?,?,?,sysdate,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?) " ;
	try
	{
		String sql = "";
		int res	  = 0  ;int res1=0;int res2=0;
		con = ConnectionManager.getConnection(p);
		con.setAutoCommit( false );
		SrlNo_pstmt=con.prepareStatement(select_trans_recordSQL);
		TransRecord_pstmt=con.prepareStatement(insert_trans_recordSQL);
		sql  = "delete from OA_CLINIC_ALCN where facility_id = ? and clinic_code = ? and day_no = ? and nvl(practitioner_id,'X')=nvl(?,'X') and care_locn_type_ind = ? and resource_class = ?" ;
		pstmt = con.prepareStatement( sql );
		pstmt.setString ( 1, facilityId );
		pstmt.setString ( 2, p_clinic_code );
		pstmt.setString	( 3, p_day_no ) ;
		pstmt.setString ( 4, p_practitioner_id ) ;
		pstmt.setString ( 5, locationType );
		pstmt.setString ( 6, resourceClass );
		res = pstmt.executeUpdate() ;
		pstmt.close() ;

		sql  = "delete from OA_CLINIC_TIME_TABLE where facility_id = ? and clinic_code = ? and day_no = ? and nvl(practitioner_id,'X')=nvl(?,'X') and care_locn_type_ind = ? and resource_class = ?" ;
		pstmt = con.prepareStatement( sql );
		pstmt.setString ( 1, facilityId );
		pstmt.setString ( 2, p_clinic_code );
		pstmt.setString	( 3, p_day_no ) ;
		pstmt.setString ( 4, p_practitioner_id ) ;
		pstmt.setString ( 5, locationType );
		pstmt.setString ( 6, resourceClass );
		res1 = pstmt.executeUpdate() ;
		pstmt.close() ;
		sql  = "delete from OA_CLINIC_BREAK where facility_id = ? and clinic_code = ? and day_no = ?  and nvl(practitioner_id,'X')=nvl(?,'X') and care_locn_type_ind = ? and resource_class = ?" ;
		pstmt = con.prepareStatement( sql );
		pstmt.setString ( 1, facilityId );
		pstmt.setString ( 2, p_clinic_code );
		pstmt.setString	( 3, p_day_no ) ;
		pstmt.setString ( 4, p_practitioner_id ) ;
		pstmt.setString ( 5, locationType );
		pstmt.setString ( 6, resourceClass );
		res2 = pstmt.executeUpdate() ;
		if(pstmt!=null) pstmt.close() ;

		SrlNo_pstmt.setString( 1, facilityId ) ;
		maxSrlRset=SrlNo_pstmt.executeQuery();
		if(maxSrlRset.next()){
			maxSrlnoStr = maxSrlRset.getString("max");
			MaxSrlNo = Integer.parseInt(maxSrlnoStr);
		}
		if(maxSrlRset!=null)maxSrlRset.close(); 
		TransRecord_pstmt.setString (1, facilityId);
		TransRecord_pstmt.setInt	 ( 2,MaxSrlNo ) ;
		TransRecord_pstmt.setString (3, "TD" ) ;
		TransRecord_pstmt.setString (4, addedById );
		TransRecord_pstmt.setString (5, "" ) ;
		TransRecord_pstmt.setString (6, "");
		TransRecord_pstmt.setString (7, p_clinic_code ) ;
		TransRecord_pstmt.setString (8, p_practitioner_id) ;
		TransRecord_pstmt.setString (9, p_day_no ) ;
		TransRecord_pstmt.setString (10, "" ) ;
		TransRecord_pstmt.setString (11, "" ) ;
		TransRecord_pstmt.setString (12, locationType ) ;
		TransRecord_pstmt.setString (13, resourceClass ) ;
		TransRecord_pstmt.executeUpdate() ;

		if ( res != 0  || res1 != 0 || res2 != 0)
		{
			result = true ;
			con.commit();
			java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_DELETED","SM" ) ;
			sb.append( (String) message.get("message") ) ;
			message.clear();
		}
		if(pstmt!= null) pstmt.close() ;
		passObjects.clear();
	}catch ( Exception e ){
		sb.append( e.getMessage() + "<br>" ) ;
		e.printStackTrace();
		try {
				con.rollback() ;
			} catch ( Exception ce ) {
			ce.printStackTrace();}
	}finally{
		ConnectionManager.returnConnection(con,p);
	}
	try{
		if(maxSrlRset!=null)maxSrlRset.close();
		if(SrlNo_pstmt!=null)SrlNo_pstmt.close();
		if(TransRecord_pstmt!=null)TransRecord_pstmt.close();
	}catch(Exception ex){
		ex.printStackTrace();
	}
	    results.put( "status", new Boolean(result) ) ;
	    results.put( "error", sb.toString() ) ;
		sb.setLength(0);
	    return results ;
  }//Method
/**
* @ejb.interface-method
*	 view-type="both"
*/
  public java.util.HashMap copyTimeTable(java.util.Properties p,
			java.util.HashMap passObjects
		) 
	{

		System.out.println("TimeTableManager insertTimeTableforAll :"+passObjects.toString());
		String facilityId=(String) passObjects.get("addedFacilityId");
		String p_clinic_code =(String) passObjects.get("p_clinic_code");
		String p_day_no =(String) passObjects.get("p_day_no");
	//	String p_practitioner_id =(String) passObjects.get("p_practitioner_id");
		String p_time_table_type =(String) passObjects.get("p_time_table_type");
		String p_remarks =(String) passObjects.get("p_remarks");
		String p_start_time =(String) passObjects.get("p_start_time");
		String p_end_time =(String) passObjects.get("p_end_time");
		String p_time_per_patient =(String) passObjects.get("p_time_per_patient");
		String p_max_patients_per_day =(String) passObjects.get("p_max_patients_per_day");
		String p_time_per_slab =(String) passObjects.get("p_time_per_slab");
		String p_max_patients_per_slab =(String) passObjects.get("p_max_patients_per_slab");
		String p_max_first_visits =(String) passObjects.get("p_max_first_visits");
		String p_max_over_bookings =(String) passObjects.get("p_max_over_bookings");
		String b_max_slots_for_first_visit=(String) passObjects.get("b_max_slots_for_first_visit");
		String p_phys_roster_reqd_yn =(String) passObjects.get("p_phys_roster_reqd_yn");
		String p_alcn_criteria=(String) passObjects.get("p_alcn_criteria");
		String b_max_slots_per_day =(String) passObjects.get("b_max_slots_per_day");
		String b_max_other_visits =(String) passObjects.get("b_max_other_visits");
		String p_resource_type=(String) passObjects.get("p_resource_type");
		String p_forced_allowed_yn =(String) passObjects.get("p_forced_allowed_yn");
		String p_no_forced_booking =(String) passObjects.get("p_no_forced_booking");
		String p_no_global_ref=(String) passObjects.get("p_no_global_ref");
		String addedAtWorkstation=(String) passObjects.get("addedAtWorkstation");
		String p_break_time_1_from=(String) passObjects.get("p_break_time_1_from");
		String p_break_time_1_to=(String) passObjects.get("p_break_time_1_to");
		String p_break_time_2_from=(String) passObjects.get("p_break_time_2_from");
		String p_break_time_2_to=(String) passObjects.get("p_break_time_2_to");
		String p_break_time_3_from=(String) passObjects.get("p_break_time_3_from");
		String p_break_time_3_to=(String) passObjects.get("p_break_time_3_to");
		String p_break_time_4_from=(String) passObjects.get("p_break_time_4_from");
		String p_break_time_4_to=(String) passObjects.get("p_break_time_4_to");
		String p_break_time_5_from=(String) passObjects.get("p_break_time_5_from");
		String p_break_time_5_to=(String) passObjects.get("p_break_time_5_to");
		//String final_string=(String) passObjects.get("final_string"); //Commented for checkstyle
		//String alcn_basis=(String) passObjects.get("alcn_basis"); //Commented for checkstyle
		String location_type=(String) passObjects.get("location");
		String max_new_patients=(String) passObjects.get("max_new_patients");
		String max_old_patients=(String) passObjects.get("max_old_patients");
		String finalPractList=(String) passObjects.get("finalPractList");
		String schedule_extend_yn=(String) passObjects.get("schedule_extend_yn");//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
		
		//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
		String ext_all_slots_yn = (String)passObjects.get("ext_all_slots_yn");
		String ext_start_slots = (String)passObjects.get("ext_start_slots");
		String ext_mid_slots = (String)passObjects.get("ext_mid_slots");
		String ext_end_slots = (String)passObjects.get("ext_end_slots");

		String result_proc = "";
		String p_practitioner_id = "";
System.err.println("finalPractList--->"+finalPractList);
		String locale = p.getProperty("LOCALE");
		b_max_slots_for_first_visit="0";
		java.util.HashMap results = new java.util.HashMap() ;
	    boolean result = false ;
		StringBuffer sb = new StringBuffer( "" ) ;
	    String addedById = p.getProperty( "login_user" ) ;
	   	//String modifiedAtWorkstation = addedAtWorkstation ; //Commented for checkstyle
		//int p_max_patients=Integer.parseInt(p_max_patients_per_day); //Commented for checkstyle

	    try
	    {
			con = ConnectionManager.getConnection(p);
		
			ArrayList msg=new ArrayList();
			java.util.StringTokenizer practidList =new java.util.StringTokenizer (finalPractList,"|") ;
			
			while (practidList.hasMoreTokens())
			{
				p_practitioner_id = practidList.nextToken() ;
			

				con.setAutoCommit( false );
				System.err.println("Before p_practitioner_id--->"+p_practitioner_id)				;
			//	callablestatement = con.prepareCall("{call OA_INSERT_CLINIC_REC(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				callablestatement = con.prepareCall("{call OA_CREATE_TIME_TABLES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				System.err.println("After p_practitioner_id--->"+p_practitioner_id);
				callablestatement.setString(1,facilityId);
                callablestatement.setString(2,p_clinic_code );
                callablestatement.setString(3,p_day_no );
                callablestatement.setString(4,p_practitioner_id );
                callablestatement.setString(5,p_time_table_type );
                callablestatement.setString(6,p_remarks );
                callablestatement.setString(7,p_start_time );
                callablestatement.setString(8,p_end_time );
                callablestatement.setString(9,p_time_per_patient );
				callablestatement.setString(10,p_max_patients_per_day );
                callablestatement.setString(11,p_time_per_slab);
                callablestatement.setString(12,p_max_patients_per_slab);
                callablestatement.setString(13,p_max_first_visits );
				callablestatement.setString(14,p_max_over_bookings );
				callablestatement.setString(15,b_max_slots_for_first_visit );
				callablestatement.setString(16,b_max_slots_per_day );

				callablestatement.setString(17,b_max_other_visits );
				callablestatement.setString(18,p_alcn_criteria );
				callablestatement.setString(19,p_phys_roster_reqd_yn );
				callablestatement.setString(20,p_break_time_1_from );
				callablestatement.setString(21,p_break_time_1_to);
				callablestatement.setString(22,p_break_time_2_from );
				callablestatement.setString(23,p_break_time_2_to );
				callablestatement.setString(24,p_break_time_3_from );
				callablestatement.setString(25,p_break_time_3_to );
				callablestatement.setString(26,p_break_time_4_from );
				callablestatement.setString(27,p_break_time_4_to );
				callablestatement.setString(28,p_break_time_5_from );
				callablestatement.setString(29,p_break_time_5_to );
				callablestatement.setString(30,addedById);
				callablestatement.setString(31,addedAtWorkstation);
				callablestatement.setString(32,p_resource_type ) ;
				callablestatement.setString(33,p_forced_allowed_yn ) ;
				callablestatement.setString(34,p_no_forced_booking ) ;
				callablestatement.setString(35,p_no_global_ref ) ;
				callablestatement.setString(36,location_type ) ;
				callablestatement.setString(37,p_resource_type ) ;
                callablestatement.registerOutParameter(38,Types.VARCHAR);
                callablestatement.setInt(39,Integer.parseInt(max_new_patients));
                callablestatement.setInt(40,Integer.parseInt(max_old_patients));
				callablestatement.setString(41,schedule_extend_yn ) ;
				callablestatement.setString(42,ext_all_slots_yn ) ;
				callablestatement.setString(43,ext_start_slots ) ;
				callablestatement.setString(44,ext_mid_slots ) ;
				callablestatement.setString(45,ext_end_slots ) ;
                callablestatement.execute();
				result_proc = callablestatement.getString(38);

				if(result_proc!=null){
					result_proc=result_proc.trim();
					msg.add(result_proc);
				}
				System.err.println("Before result_proc--->"+result_proc);
				if(result_proc!=null && result_proc.equals("SUCCESS")){	
					con.commit();
				}else{
					 con.rollback();
				}
				if(callablestatement!=null) callablestatement.close(); //Added for checkstyle	
			}
				System.err.println("after result_proc--->"+result_proc);						
		
		for(int m=0;m<msg.size();m++){

			if(((String)msg.get(m)).equals("SUCCESS")){
				result_proc=(String)msg.get(m);
				break;
			}else{
				result_proc=(String)msg.get(m);
			}
		}
	System.err.println("result_proc--->"+result_proc)		;
			if(result_proc!=null && result_proc.equals("SUCCESS")){			
					result=true;
					java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
					sb.append( (String) message.get("message") ) ;
					//con.commit();
					message.clear();
					
			 }else{
					result=false;
					// con.rollback();
					java.util.Hashtable message = MessageManager.getMessage( locale,"TIMETABLE_NOT_CREATED","OA" ) ;
					sb.append( (String) message.get("message") ) ;
					//con.commit();
					message.clear();
					sb.append(result_proc);
				}
		if(callablestatement_alloc!=null) callablestatement_alloc.close();
		//if(callablestatement!=null) callablestatement.close(); //Commented for checkstyle	
		if(callableSt!=null) callableSt.close();
		passObjects.clear();
		}catch(Exception exception){
			sb.append("Error from EJB  :"+exception.toString());
			exception.printStackTrace();
		}
		finally
		{
		   	ConnectionManager.returnConnection(con,p);
		}
		results.put( "status", new Boolean(result) ) ;
	    results.put( "error", sb.toString() ) ;
		sb.setLength(0);
	    return results ;
	}

}

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA.BlockAppointment;

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
*	name="BlockAppointment"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="BlockAppointment"
*	local-jndi-name="BlockAppointment"
*	impl-class-name="eOA.BlockAppointment.BlockAppointmentManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eOA.BlockAppointment.BlockAppointmentManagerLocal"
*	remote-class="eOA.BlockAppointment.BlockAppointmentManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOA.BlockAppointment.BlockAppointmentManagerLocalHome"
*	remote-class="eOA.BlockAppointment.BlockAppointmentManagerHome"
*	generate= "local,remote"
*
*
*/

public class BlockAppointmentManager implements SessionBean {
	public final String BLOCK_SLOT_ALREADY_EXISTS = "BLOCK_SLOT_ALREADY_EXISTS" ;
	public final String BLOCK_APPT_OVERLAP_EXISTS="BLOCK_APPT_OVERLAP_EXISTS";
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_DELETED = "RECORD_DELETED" ;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {} ;
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap insertBlockAppointment(java.util.Properties p,
							java.util.HashMap passObjects
						 )

	{
	Connection con =null;
	PreparedStatement pstmt =null,pstmt2=null,pstmt3=null,pstmt4=null,pstmt7=null,pstmt8=null,pstmt9=null,pstmt14=null,pstmt15=null,pstmt_diff=null,pstmt8_new=null;
	//Statement stmtoa_param=null;
	//ResultSet rs_oaparam=null;
	ResultSet rs8=null;
	ResultSet rs7=null;
	//ResultSet rs_diff=null;
	ResultSet rs=null;
	ResultSet rs2=null;
	ResultSet rs3=null;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	String maxnum="";
	//System.out.println("insertBlockAppointment :"+passObjects.toString());
	String	location=(String) passObjects.get("location");
	String practitioner=(String) passObjects.get("practitioner");
	String block_date=(String) passObjects.get("block_date");
	String block_from_time=(String) passObjects.get("block_from_time");
	String block_to_time=(String) passObjects.get("block_to_time");
	String reason_for_block=(String) passObjects.get("reason_for_block");
	String reason_for_block1=(String) passObjects.get("reason_for_block1");
	String time_per_patient=(String) passObjects.get("time_per_patient");
	String facilityId=(String) passObjects.get("facilityId");
	String	addedAtWorkstation=(String) passObjects.get("client_ip_address");
	String 	first_visits_value=(String) passObjects.get("first_visits_value");
	String 	other_visits_value=(String) passObjects.get("other_visits_value");
	String locn_type=(String) passObjects.get("locn_type");
	String  resource=(String) passObjects.get("resource");
	String  time_table_type=(String) passObjects.get("time_table_type");
	String  max_patients_per_slab=(String) passObjects.get("max_patients_per_slab");
	String  final_count=(String) passObjects.get("final_count");
	String 	insertdetail = (String) passObjects.get("insertdetail");
	String finalvalues = (String) passObjects.get("finalvalues");
	String locale = p.getProperty("LOCALE");
	String Slot_fully_blocked=(String) passObjects.get("Slot_fully_blocked");
	String visit_limit_rule="";
	String remarks_for_block = (String) passObjects.get("remarks_for_block"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

	java.util.HashMap results = new java.util.HashMap() ;
	boolean result = false ;
	boolean insertable = true ;
	String sql7=	"select round(to_number(((to_date('"+block_to_time+"' ,'hh24:mi')- to_date('"+block_from_time+"','hh24:mi')) * 24 * 60)/ ((to_date('"+time_per_patient+"' ,'hh24:mi')- to_date('00:00','hh24:mi')) * 24 * 60 ))) xxx,(select visit_limit_rule from oa_param where module_id='OA')visit_limit_rule from dual";
	//String ot_diff = "select round(to_number(((to_date('"+block_to_time+"' ,'hh24:mi')- to_date('"+block_from_time+"','hh24:mi')) * 24 * 60)/ ((to_date('"+time_per_patient+"' ,'hh24:mi')- to_date('00:00','hh24:mi')) * 24 * 60 ))) xxx from dual";

	//System.out.println("sql7 ==>"+sql7);
	StringBuffer sb = new StringBuffer( "" ) ;
	String up_date="",update2="";
	String sql="select nvl(max(srl_no),0)+1 maxnum from oa_block_appt where facility_id='"+facilityId+"' and clinic_code='"+location+"'";
	//String oa_param_sql="select visit_limit_rule from oa_param where module_id='OA'";
	String sql2="Insert into oa_block_appt(facility_id, clinic_code, block_date, srl_no, practitioner_id, effective_from_date_time, effective_to_date_time, reason_for_block, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, first_visits_blocked, other_visits_blocked,care_locn_type_ind,resource_class,remarks_for_block) values (?, ? ,to_date(?,'dd/mm/yyyy') , to_number(?) ,? ,to_date(?,'hh24:mi'), to_date(?,'hh24:mi'),? ,? ,? ,? ,? ,? ,?, ? ,?,?,?,?,?,?) ";
	String addedDate = dateFormat.format( new java.util.Date() ) ;
	String addedById = p.getProperty( "login_user" ) ;
	java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
	try{

		con = ConnectionManager.getConnection(p);
		//pstmt7 = con.prepareStatement( oa_param_sql ) ;
		//rs7 = pstmt7.executeQuery() ;
		//rs7.next();
		//String visit_limit_rule=rs7.getString("visit_limit_rule");
		String duplicateSql="";


		if(!time_table_type.equals("2")){
			if(practitioner.equals("")){
				duplicateSql="select 1 from oa_block_appt where facility_id='"+facilityId+"' and clinic_code='"+location+"' and practitioner_id is null and block_date =to_date('"+block_date+"','dd/mm/yyyy') and effective_from_date_time >= to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+block_from_time+"','dd/mm/yyyy hh24:mi') and effective_from_date_time+(to_date(to_char(effective_to_date_time,'dd/mm/yyyy')||'"+block_to_time+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+block_from_time+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(effective_to_date_time,'dd/mm/yyyy')||'"+block_to_time+"','dd/mm/yyyy hh24:mi')-to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+block_from_time+"','dd/mm/yyyy hh24:mi'))*1+to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+block_from_time+"','dd/mm/yyyy hh24:mi') and care_locn_type_ind = '"+locn_type+"' and resource_class='"+resource+"' ";
			}else{
				duplicateSql="select 1 from oa_block_appt where facility_id='"+facilityId+"' and clinic_code='"+location+"' and practitioner_id = '"+practitioner+"' and block_date =to_date('"+block_date+"','dd/mm/yyyy') and effective_from_date_time >= to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+block_from_time+"','dd/mm/yyyy hh24:mi') and effective_from_date_time+(to_date(to_char(effective_to_date_time,'dd/mm/yyyy')||'"+block_to_time+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+block_from_time+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(effective_to_date_time,'dd/mm/yyyy')||'"+block_to_time+"','dd/mm/yyyy hh24:mi')-to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+block_from_time+"','dd/mm/yyyy hh24:mi'))*1+to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+block_from_time+"','dd/mm/yyyy hh24:mi') and care_locn_type_ind = '"+locn_type+"' and resource_class='"+resource+"' ";
			}
		}else{
			if(practitioner.equals("")){
				duplicateSql="select 1 from oa_block_appt where facility_id='"+facilityId+"' and clinic_code='"+location+"' and practitioner_id is null and block_date= to_date('"+block_date+"','dd/mm/yyyy') and       ((TO_CHAR(effective_from_date_time,'HH24:MI') BETWEEN '"+block_from_time+"' AND '"+block_to_time+"' ) and (TO_CHAR(effective_from_date_time,'HH24:MI') BETWEEN '"+block_from_time+"' AND '"+block_to_time+"' )) and care_locn_type_ind = '"+locn_type+"' and resource_class='"+resource+"' AND OTHER_VISITS_BLOCKED='"+final_count+"'";
			}else{
				duplicateSql="select 1 from oa_block_appt where facility_id='"+facilityId+"' and clinic_code='"+location+"' and  practitioner_id = '"+practitioner+"' and block_date= to_date('"+block_date+"','dd/mm/yyyy') and       ((TO_CHAR(effective_from_date_time,'HH24:MI') BETWEEN '"+block_from_time+"' AND '"+block_to_time+"' ) and (TO_CHAR(effective_from_date_time,'HH24:MI') BETWEEN '"+block_from_time+"' AND '"+block_to_time+"' )) and care_locn_type_ind = '"+locn_type+"' and resource_class='"+resource+"' AND OTHER_VISITS_BLOCKED='"+final_count+"'";
			}


		}


		String duplicateSql2="";
		if(practitioner.equals("")){
			duplicateSql2="select 1 total from oa_appt where facility_id='"+facilityId+"' and clinic_code='"+location+"' and appt_date=to_date('"+block_date+"','dd/mm/yyyy') and practitioner_id is null and appt_slab_from_time >= to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+block_from_time+"','dd/mm/yyyy hh24:mi') and appt_slab_from_time+(to_date(to_char(appt_slab_to_time,'dd/mm/yyyy')||'"+block_to_time+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+block_from_time+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(appt_slab_to_time,'dd/mm/yyyy')||'"+block_to_time+"','dd/mm/yyyy hh24:mi')-to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+block_from_time+"','dd/mm/yyyy hh24:mi'))*1+to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+block_from_time+"','dd/mm/yyyy hh24:mi') and care_locn_type_ind = '"+locn_type+"' and resource_class='"+resource+"' ";
		}else{
			duplicateSql2="select 1 total from oa_appt where facility_id='"+facilityId+"' and clinic_code='"+location+"' and appt_date=to_date('"+block_date+"','dd/mm/yyyy') and practitioner_id = '"+practitioner+"' and appt_slab_from_time >= to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+block_from_time+"','dd/mm/yyyy hh24:mi') and appt_slab_from_time+(to_date(to_char(appt_slab_to_time,'dd/mm/yyyy')||'"+block_to_time+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+block_from_time+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(appt_slab_to_time,'dd/mm/yyyy')||'"+block_to_time+"','dd/mm/yyyy hh24:mi')-to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+block_from_time+"','dd/mm/yyyy hh24:mi'))*1+to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+block_from_time+"','dd/mm/yyyy hh24:mi') and care_locn_type_ind = '"+locn_type+"' and resource_class='"+resource+"' ";
		}
		if(time_table_type.equals("2")){
			//sql7=	"select (round(to_number(((to_date('"+block_to_time+"' ,'hh24:mi')- to_date('"+block_from_time+"','hh24:mi')) * 24 * 60)/ ((to_date('"+time_per_patient+"' ,'hh24:mi')- to_date('00:00','hh24:mi')) * 24 * 60 )))*Ineteger.parseInt("+max_patients_per_slab+")) xxx,(select visit_limit_rule from oa_param where module_id='OA')visit_limit_rule from dual";
		}
		if (pstmt7!=null) pstmt7.close();
		if (rs7!=null) rs7.close();
		pstmt7 = con.prepareStatement( sql7 ) ;
		///pstmt_diff=con.prepareStatement( ot_diff ) ;
		pstmt = con.prepareStatement( duplicateSql ) ;
		pstmt2 = con.prepareStatement( duplicateSql2 ) ;
		pstmt4= con.prepareStatement(sql);

		rs7 = pstmt7.executeQuery() ;
		//System.out.println("sql7 ==>"+sql7);
		rs7.next();
		int diff=rs7.getInt("xxx");
		visit_limit_rule=rs7.getString("visit_limit_rule");
		if(pstmt7 !=null) pstmt7.close();
		//rs_diff=pstmt_diff.executeQuery() ;
		//rs_diff.next();
		//int diff1=rs_diff.getInt("xxx");
		int diff1=diff;
		//System.out.println("diff value "+diff);

		if(time_table_type.equals("2")){
			diff=diff * Integer.parseInt(max_patients_per_slab);
		}else{
			diff=diff;
		}
		if(first_visits_value.equals("")&&other_visits_value.equals("")){
			other_visits_value = (new Integer(diff)).toString();
		}
		if (visit_limit_rule.equals("N") || visit_limit_rule=="N"){
			if(time_table_type.equals("1")){
				if(Slot_fully_blocked.equals("Y")){
					if(practitioner.equals("")){
						up_date="update oa_clinic_schedule set SCHEDULE_STATUS = 'B',REASON_CODE='"+reason_for_block+"', REMARKS='"+remarks_for_block+"', total_slots_booked=nvl(total_slots_booked,0)+nvl('"+diff+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+diff1+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and clinic_code='"+location+"' and clinic_date=to_date('"+block_date+"','dd/mm/yyyy') and  practitioner_id is null";
					}else{
						up_date="update oa_clinic_schedule set SCHEDULE_STATUS = 'B',REASON_CODE='"+reason_for_block+"', REMARKS='"+remarks_for_block+"', total_slots_booked=nvl(total_slots_booked,0)+nvl('"+diff+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+diff1+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and clinic_code='"+location+"' and clinic_date=to_date('"+block_date+"','dd/mm/yyyy') and  practitioner_id = '"+practitioner+"'";
					}
				}else{
					if(practitioner.equals("")){
						up_date="update oa_clinic_schedule set  total_slots_booked=nvl(total_slots_booked,0)+nvl(		'"+diff+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+diff1+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and clinic_code='"+location+"' and clinic_date=to_date('"+block_date+"','dd/mm/yyyy') and  practitioner_id is null";
					}else{
						up_date="update oa_clinic_schedule set  total_slots_booked=nvl(total_slots_booked,0)+nvl(		'"+diff+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+diff1+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and clinic_code='"+location+"' and clinic_date=to_date('"+block_date+"','dd/mm/yyyy') and  practitioner_id = '"+practitioner+"'";
					}				
				}
			}else if(time_table_type.equals("2")){
				if(practitioner.equals("")){
					//up_date="update oa_clinic_schedule set  total_slots_booked=nvl(total_slots_booked,0)+nvl(		'"+final_count+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+final_count+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and clinic_code='"+location+"' and clinic_date=to_date('"+block_date+"','dd/mm/yyyy') and practitioner_id is null";
					up_date="update oa_clinic_schedule set  total_slots_booked=nvl(total_slots_booked,0)+nvl(		'"+diff+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+diff+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and clinic_code='"+location+"' and clinic_date=to_date('"+block_date+"','dd/mm/yyyy') and practitioner_id is null";
				}else{
					//up_date="update oa_clinic_schedule set  total_slots_booked=nvl(total_slots_booked,0)+nvl(		'"+final_count+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+final_count+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and clinic_code='"+location+"' and clinic_date=to_date('"+block_date+"','dd/mm/yyyy') and practitioner_id = '"+practitioner+"'";
					up_date="update oa_clinic_schedule set  total_slots_booked=nvl(total_slots_booked,0)+nvl(		'"+diff+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+diff+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and clinic_code='"+location+"' and clinic_date=to_date('"+block_date+"','dd/mm/yyyy') and practitioner_id = '"+practitioner+"'";
				}				
			}
		}else{
			if(time_table_type.equals("1")){
				if(Slot_fully_blocked.equals("Y")){
					if(practitioner.equals("")){
						up_date="update oa_clinic_schedule set  SCHEDULE_STATUS = 'B',REASON_CODE='"+reason_for_block+"', REMARKS='"+remarks_for_block+"', total_slots_booked=nvl(total_slots_booked,0)+nvl( '"+diff+"',0) , total_first_visits_blocked=nvl(total_first_visits_blocked,0)+nvl( '"+first_visits_value+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+other_visits_value+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"' where facility_id='"+facilityId+"' and clinic_code='"+location+"' and clinic_date=to_date('"+block_date+"','dd/mm/yyyy')  and practitioner_id is null";
					}else{
						up_date="update oa_clinic_schedule set  SCHEDULE_STATUS = 'B',REASON_CODE='"+reason_for_block+"', REMARKS='"+remarks_for_block+"', total_slots_booked=nvl(total_slots_booked,0)+nvl( '"+diff+"',0) , total_first_visits_blocked=nvl(total_first_visits_blocked,0)+nvl( '"+first_visits_value+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+other_visits_value+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"' where facility_id='"+facilityId+"' and clinic_code='"+location+"' and clinic_date=to_date('"+block_date+"','dd/mm/yyyy')  and practitioner_id = '"+practitioner+"'";
					}					 
				}else{
					if(practitioner.equals("")){
						up_date="update oa_clinic_schedule set  total_slots_booked=nvl(total_slots_booked,0)+nvl( '"+diff+"',0) , total_first_visits_blocked=nvl(total_first_visits_blocked,0)+nvl( '"+first_visits_value+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+other_visits_value+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"' where facility_id='"+facilityId+"' and clinic_code='"+location+"' and clinic_date=to_date('"+block_date+"','dd/mm/yyyy')  and practitioner_id is null";
					}else{
						up_date="update oa_clinic_schedule set  total_slots_booked=nvl(total_slots_booked,0)+nvl( '"+diff+"',0) , total_first_visits_blocked=nvl(total_first_visits_blocked,0)+nvl( '"+first_visits_value+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+other_visits_value+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"' where facility_id='"+facilityId+"' and clinic_code='"+location+"' and clinic_date=to_date('"+block_date+"','dd/mm/yyyy')  and practitioner_id = '"+practitioner+"'";
					}					
				}
			}else{
				if(practitioner.equals("")){
					//up_date="update oa_clinic_schedule set  total_slots_booked=nvl(total_slots_booked,0)+nvl('"+final_count+"',0) , total_first_visits_blocked=nvl(total_first_visits_blocked,0)+nvl( '"+first_visits_value+"',0), total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+other_visits_value+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and clinic_code='"+location+"' and clinic_date=to_date('"+block_date+"','dd/mm/yyyy') and practitioner_id is null and care_locn_type_ind = '"+locn_type+"' and resource_class='"+resource+"'";
					up_date="update oa_clinic_schedule set  total_slots_booked=nvl(total_slots_booked,0)+nvl('"+diff+"',0) , total_first_visits_blocked=nvl(total_first_visits_blocked,0)+nvl( '"+first_visits_value+"',0), total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+other_visits_value+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and clinic_code='"+location+"' and clinic_date=to_date('"+block_date+"','dd/mm/yyyy') and practitioner_id is null and care_locn_type_ind = '"+locn_type+"' and resource_class='"+resource+"'";
				}else{
					//up_date="update oa_clinic_schedule set  total_slots_booked=nvl(total_slots_booked,0)+nvl('"+final_count+"',0), total_first_visits_blocked=nvl(total_first_visits_blocked,0)+nvl( '"+first_visits_value+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+other_visits_value+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and clinic_code='"+location+"' and clinic_date=to_date('"+block_date+"','dd/mm/yyyy') and practitioner_id = '"+practitioner+"' and care_locn_type_ind = '"+locn_type+"' and resource_class='"+resource+"'";
					up_date="update oa_clinic_schedule set  total_slots_booked=nvl(total_slots_booked,0)+nvl('"+diff+"',0), total_first_visits_blocked=nvl(total_first_visits_blocked,0)+nvl( '"+first_visits_value+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+other_visits_value+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and clinic_code='"+location+"' and clinic_date=to_date('"+block_date+"','dd/mm/yyyy') and practitioner_id = '"+practitioner+"' and care_locn_type_ind = '"+locn_type+"' and resource_class='"+resource+"'";
				}				
			}
		}
		if(time_table_type.equals("1")){
			if(practitioner.equals("")){
				update2="update OA_CLINIC_SCHEDULE_SLOT_SLAB  set  SCHEDULE_STATUS = 'B' ,MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+addedAtWorkstation+"',MODIFIED_FACILITY_ID='"+facilityId+"' WHERE FACILITY_ID='"+facilityId+"' and CLINIC_CODE='"+location+"' and CLINIC_DATE=to_date('"+block_date+"','dd/mm/yyyy')  and  PRACTITIONER_ID is null and CARE_LOCN_TYPE_IND = '"+locn_type+"' and RESOURCE_CLASS='"+resource+"' and       ((TO_CHAR(SLOT_SLAB_START_TIME,'HH24:MI') BETWEEN '"+block_from_time+"' AND '"+block_to_time+"' ) and (TO_CHAR(SLOT_SLAB_END_TIME,'HH24:MI') BETWEEN '"+block_from_time+"' AND '"+block_to_time+"' )) and schedule_status is null";
			}else{
				update2="update OA_CLINIC_SCHEDULE_SLOT_SLAB  set  SCHEDULE_STATUS = 'B' ,MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+addedAtWorkstation+"',MODIFIED_FACILITY_ID='"+facilityId+"' WHERE FACILITY_ID='"+facilityId+"' and CLINIC_CODE='"+location+"' and CLINIC_DATE=to_date('"+block_date+"','dd/mm/yyyy')  and  PRACTITIONER_ID = '"+practitioner+"' and CARE_LOCN_TYPE_IND = '"+locn_type+"' and RESOURCE_CLASS='"+resource+"' and       ((TO_CHAR(SLOT_SLAB_START_TIME,'HH24:MI') BETWEEN '"+block_from_time+"' AND '"+block_to_time+"' ) and (TO_CHAR(SLOT_SLAB_END_TIME,'HH24:MI') BETWEEN '"+block_from_time+"' AND '"+block_to_time+"' )) and schedule_status is null";
			}			
		}else{
			if(practitioner.equals("")){
				update2="update OA_CLINIC_SCHEDULE_SLOT_SLAB  set  SCHEDULE_STATUS = 'B' ,MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+addedAtWorkstation+"',MODIFIED_FACILITY_ID='"+facilityId+"' WHERE FACILITY_ID='"+facilityId+"' and CLINIC_CODE='"+location+"' and CLINIC_DATE=to_date('"+block_date+"','dd/mm/yyyy')  and PRACTITIONER_ID is null and CARE_LOCN_TYPE_IND = '"+locn_type+"' and RESOURCE_CLASS='"+resource+"' and       ((TO_CHAR(SLOT_SLAB_START_TIME,'HH24:MI') BETWEEN '"+block_from_time+"' AND '"+block_to_time+"' ) and (TO_CHAR(SLOT_SLAB_END_TIME,'HH24:MI') BETWEEN '"+block_from_time+"' AND '"+block_to_time+"' )) and schedule_status is null and  ROWNUM <='"+final_count+"'";
			}else{
				update2="update OA_CLINIC_SCHEDULE_SLOT_SLAB  set  SCHEDULE_STATUS = 'B' ,MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+addedAtWorkstation+"',MODIFIED_FACILITY_ID='"+facilityId+"' WHERE FACILITY_ID='"+facilityId+"' and CLINIC_CODE='"+location+"' and CLINIC_DATE=to_date('"+block_date+"','dd/mm/yyyy')  and  PRACTITIONER_ID = '"+practitioner+"' and CARE_LOCN_TYPE_IND = '"+locn_type+"' and RESOURCE_CLASS='"+resource+"' and       ((TO_CHAR(SLOT_SLAB_START_TIME,'HH24:MI') BETWEEN '"+block_from_time+"' AND '"+block_to_time+"' ) and (TO_CHAR(SLOT_SLAB_END_TIME,'HH24:MI') BETWEEN '"+block_from_time+"' AND '"+block_to_time+"' )) and schedule_status is null and  ROWNUM <='"+final_count+"'";
			}			
		}
		rs = pstmt.executeQuery() ;
		//System.out.println("duplicateSql up_date at insertBlockAppointment==>"+duplicateSql);
		rs2 = pstmt2.executeQuery() ;
		//System.out.println("duplicateSql2 insertBlockAppointment==>"+duplicateSql2);
		rs3 = pstmt4.executeQuery() ;
		//System.out.println("sql insertBlockAppointment==>"+sql);
		while(rs3.next()){
			maxnum=rs3.getString("maxnum");
		}
		if(time_table_type.equals("1"))
		{
		if ( rs.next() ){
			insertable = false ;
			java.util.Hashtable message = MessageManager.getMessage( locale,"BLOCK_SLOT_ALREADY_EXISTS","OA" ) ;
			sb.append( (String) message.get("message") ) ;
		}
		}
		if( rs2.next())	{
			insertable = false ;
			java.util.Hashtable message = MessageManager.getMessage( locale,"BLOCK_APPT_OVERLAP_EXISTS","OA" ) ;
			sb.append( (String) message.get("message") ) ;
		}
		if(pstmt !=null) pstmt.close();
		if ( insertable ){
			String sql25="select nvl(max(srl_no),0)+1 maxnum from OA_TRANS_RECORD  where facility_id='"+facilityId+"' ";
			pstmt14= con.prepareStatement(sql25);
			//System.out.println("sql25 insertBlockAppointment==>"+sql25);
			rs8 = pstmt14.executeQuery() ;
			String maxnum2="";
			while(rs8.next()){
				maxnum2=rs8.getString("maxnum");
			}
			String sql20="Insert into oa_trans_record (facility_id,srl_no,trans_code,trans_date_time,trans_eff_by_id,clinic_code,care_locn_type_ind,resource_class,from_date_entered, to_date_entered, from_practitioner_id, to_practitioner_id,remarks, reason_code) values (?,to_number(?),'BS',sysdate,?,?,?,?,to_date(?,'DD/MM/YYYY'),to_date(?,'DD/MM/YYYY'),?,?,?,?)";
			//System.out.println("sql20 insertBlockAppointment==>"+sql20);
			pstmt15 = con.prepareStatement( sql20);
			pstmt15.setString	( 1, facilityId) ;
			pstmt15.setString	( 2, maxnum2) ;
			//pstmt15.setString	(3, block_date) ; for 15560Re-open (venkat s 27.10.09)
			pstmt15.setString	(3, addedById) ;
			pstmt15.setString	(4, location) ;
			pstmt15.setString	(5, locn_type) ;
			pstmt15.setString	(6, resource) ;
			pstmt15.setString	(7, block_date) ;
			pstmt15.setString	(8, block_date) ;
			pstmt15.setString	(9, practitioner) ;
			pstmt15.setString	(10, practitioner) ;
			pstmt15.setString	(11, reason_for_block1) ;
			pstmt15.setString	(12, reason_for_block) ;

			int res30 = pstmt15.executeUpdate() ;
			pstmt3 = con.prepareStatement( sql2 );
			//System.out.println("sql2 insertBlockAppointment==>"+sql2);
			pstmt3.setString	( 1, facilityId) ;
			pstmt3.setString	( 2, location) ;
			pstmt3.setString	( 3, block_date ) ;
			pstmt3.setString	( 4, maxnum ) ;
			pstmt3.setString	( 5, practitioner ) ;
			pstmt3.setString	(6, block_from_time);
			pstmt3.setString	(7,block_to_time);
			pstmt3.setString	(8,reason_for_block);
			pstmt3.setString	( 9, addedById ) ;
			pstmt3.setDate		( 10, added_date ) ;
			pstmt3.setString	( 11, addedById ) ;
			pstmt3.setString	 (12,facilityId);
			pstmt3.setString	( 13, addedById ) ;
			pstmt3.setDate		( 14, added_date ) ;
			pstmt3.setString	( 15, addedAtWorkstation ) ;
			pstmt3.setString	(16,facilityId);
			//commenetd as whether time table type is slot/slab we'll consider both first visits or other visits
			/* if(time_table_type.equals("1"))
			{
			pstmt3.setString (17,first_visits_value);
			pstmt3.setString (18,other_visits_value);
			}else
			{
			pstmt3.setString (17,"0");
			pstmt3.setString (18,final_count);
			}*/
			//new logic is added so that it will work for both time tables slot and slab

			pstmt3.setString (17,first_visits_value);
			pstmt3.setString (18,other_visits_value);
			pstmt3.setString (19,locn_type);
			pstmt3.setString (20,resource);
			pstmt3.setString (21,remarks_for_block); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

			pstmt8=con.prepareStatement(up_date);
			//System.out.println("other_visits_value insertBlockAppointment==>"+other_visits_value);
			//System.out.println("up_date insertBlockAppointment==>"+up_date);
			//System.out.println("update2 insertBlockAppointment==>"+update2);

			pstmt9=con.prepareStatement(update2);
		    pstmt9.executeUpdate();

			int res = pstmt3.executeUpdate() ;
			int res1=pstmt8.executeUpdate();
			boolean dtlinsert = true;
			//Added on 12/31/2008
			if(insertdetail.equals("Y"))
				{
						StringTokenizer st = new StringTokenizer(finalvalues,"#");
						while(st.hasMoreTokens())
						{
							String str = st.nextToken();
							StringTokenizer st1 = new StringTokenizer(str,"`");
							while(st1.hasMoreTokens())
							{
								String finalslots = st1.nextToken();
								finalslots="";
								String alcncriteria = st1.nextToken();
								String alcncatgcode = st1.nextToken();
								String blockslots = st1.nextToken();

								String dtlsql = " Insert into OA_BLOCK_APPT_DTL ( "+
											"  FACILITY_ID  "+
											" ,CLINIC_CODE   "+
											" ,BLOCK_DATE  "+
											" ,SRL_NO    "+
											" ,EFFECTIVE_FROM_DATE_TIME "+
											" ,EFFECTIVE_TO_DATE_TIME   "+
											" ,PRACTITIONER_ID  "+
											" ,ALCN_CRITERIA    "+
											" ,ALCN_CATG_CODE     "+
											" ,BLOCKED_SLOTS   "+
											" ,ADDED_BY_ID     "+
											" ,ADDED_DATE   "+
											" ,ADDED_AT_WS_NO        "+
											" ,ADDED_FACILITY_ID    "+
											" ,MODIFIED_BY_ID   "+
											" ,MODIFIED_DATE    "+
											" ,MODIFIED_AT_WS_NO   "+
											" ,MODIFIED_FACILITY_ID    "+
											" ) Values ( "+
											"  '"+facilityId+"', "+
											"  '"+location+"', "+
											"  to_date('"+block_date+"','dd/mm/yyyy') , "+
											"  to_number('"+maxnum+"'), "+
											"  to_date('"+block_from_time+"','hh24:mi'), "+
											"  to_date('"+block_to_time+"','hh24:mi'), "+
											"  '"+practitioner+"', "+
											"  '"+alcncriteria+"', "+
											"  '"+alcncatgcode+"', "+
											"  '"+blockslots+"', "+
											"  '"+addedById+"', sysdate,'"+addedAtWorkstation+"','"+facilityId+"', "+
											"  '"+addedById+"', sysdate,'"+addedAtWorkstation+"','"+facilityId+"' "+
											" ) ";


								pstmt8=con.prepareStatement(dtlsql);
								int res8=pstmt8.executeUpdate();
								if(res8 ==0)
									dtlinsert = false;

								String updatedtl=" " ;
								if(practitioner.equals("")){
									updatedtl="update oa_clinic_schedule_dtl set TOTAL_BOOKED_PATIENTS= nvl(TOTAL_BOOKED_PATIENTS,0)+nvl(to_number(?),0), TOTAL_BLOCKED_SLOTS=nvl(TOTAL_BLOCKED_SLOTS,0)+nvl(to_number(?),0) , modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?, modified_facility_id=?  where facility_id=? and clinic_code=? and clinic_date=to_date(?,'dd/mm/yyyy') and ALCN_CRITERIA = ? and alcn_catg_code =  ? and practitioner_id is null " ;
								}else{
									updatedtl="update oa_clinic_schedule_dtl set TOTAL_BOOKED_PATIENTS= nvl(TOTAL_BOOKED_PATIENTS,0)+nvl(to_number(?),0), TOTAL_BLOCKED_SLOTS=nvl(TOTAL_BLOCKED_SLOTS,0)+nvl(to_number(?),0) , modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?, modified_facility_id=?  where facility_id=? and clinic_code=? and clinic_date=to_date(?,'dd/mm/yyyy') and ALCN_CRITERIA = ? and alcn_catg_code =  ? and practitioner_id = ?" ;
								}

								pstmt8=con.prepareStatement(updatedtl);
								pstmt8.setString(1,blockslots);
								pstmt8.setString(2,blockslots);
								pstmt8.setString(3,addedById);
								pstmt8.setString(4,addedAtWorkstation);
								pstmt8.setString(5,facilityId);
								pstmt8.setString(6,facilityId);
								pstmt8.setString(7,location);
								pstmt8.setString(8,block_date);
								pstmt8.setString(9,alcncriteria);
								pstmt8.setString(10,alcncatgcode);
								if(!practitioner.equals("")){
									pstmt8.setString(11,practitioner);
								}

								int res9=pstmt8.executeUpdate();
								if(res9 ==0)
									dtlinsert = false;
							}
						}
				}
			//Added on 12/31/2008
			if ( res != 0 && res1 !=0 && res30 !=0 ){
				if(dtlinsert==false){
					result = false ;
					sb.append("Error inserting detail record");
					con.rollback();
				}else{
					result = true ;
					java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
					sb.append( (String) message.get("message") ) ;
					//System.out.println("before commit");
					con.commit() ;
					//con.rollback();
				}
			}
		}
		if (rs8 !=null) rs8.close() ;
		if (rs !=null) rs.close() ;
		if (rs7 !=null) rs7.close() ;
		if (rs2 !=null) rs2.close() ;
		if (rs3 !=null) rs3.close() ;
		if (pstmt_diff!=null) pstmt_diff.close();
		if (pstmt7 !=null) pstmt7.close() ;
		if (pstmt !=null) pstmt.close() ;
		if (pstmt2 !=null) pstmt2.close() ;
		if (pstmt3 !=null) pstmt3.close() ;
		if (pstmt4 !=null) pstmt4.close() ;
		if (pstmt8 !=null) pstmt8.close() ;
		if (pstmt9 !=null) pstmt9.close() ;
		if (pstmt14 !=null) pstmt14.close() ;
		if (pstmt15 !=null) pstmt15.close() ;
		if (pstmt8_new !=null) pstmt8_new.close() ;

	}catch ( Exception e ) {
		e.printStackTrace();
		try {
			con.rollback() ;
		} catch ( Exception ce ) {
			sb.append( ce.toString() + "<br>" ) ;
			ce.printStackTrace();
		}
		sb.append( e.toString() + "<br>" ) ;
		e.printStackTrace() ;
	} finally {

		if (con != null) ConnectionManager.returnConnection(con,p);
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
public java.util.HashMap deleteBlockAppointment(java.util.Properties p,
												java.util.HashMap passObjects
												){
	Connection con =null;
	PreparedStatement pstmt=null,pstmt2=null,pstmt3=null,pstmt4=null,pstmt7=null,pstmt8=null,pstmt9=null,pstmt14=null,pstmt15=null;
	//pstmt_diff=null,pstmt8_new=null; checklist violation
	Statement stmtoa_param=null;
	ResultSet rs_oaparam=null;
	ResultSet rs8=null;
	ResultSet rs7=null;
	//ResultSet rs_diff=null;
	ResultSet rs=null;
	ResultSet rs2=null;
	ResultSet rs3=null;
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ; checklist violation
	String clinic_code=(String) passObjects.get("clinic_code");
	String pract_id=(String) passObjects.get("pract_id");
	String date=(String) passObjects.get("date");
	String from_time=(String) passObjects.get("from_time");
	String to_time=(String) passObjects.get("to_time");
	String facilityId=(String) passObjects.get("facilityId");
	String srl_no=(String) passObjects.get("srl_no");
	String addedAtWorkstation=(String) passObjects.get("client_ip_address");
	String 	first_visits_value=((String) passObjects.get("first_visits_value")==""?"0":(String) passObjects.get("first_visits_value"));
	String 	alcncriteria=(String) passObjects.get("alcncriteria");

	String 	other_visits_value=((String) passObjects.get("other_visits_value")==""?"0":(String) passObjects.get("other_visits_value"));
	String locn_type=(String) passObjects.get("locn_type");
	String  resource=(String) passObjects.get("resource");
	int first_visits=(Integer.parseInt(first_visits_value));
	int other_visits=(Integer.parseInt(other_visits_value));



	String  time_table_type="";
	String locale = p.getProperty("LOCALE");
	java.util.HashMap results = new java.util.HashMap() ;
	boolean result = false ;
	String update2 ="";
	String addedById = p.getProperty( "login_user" ) ;
	StringBuffer sb = new StringBuffer( "" ) ;
	int srl_no3=Integer.parseInt(srl_no);
	int diff=0;
	int res_oa_clic=0;
	String sql1="";
	String sql_time_table_type="";
	//System.out.println("passObjects at deleteBlockAppointment ==>"+passObjects.toString());
	if(pract_id.equals("")){
		sql_time_table_type="select time_table_type from oa_clinic_schedule where facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and clinic_date = TO_DATE('"+date+"','DD/MM/YYYY') and practitioner_id is null";
	}else{
		sql_time_table_type="select time_table_type from oa_clinic_schedule where facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and clinic_date = TO_DATE('"+date+"','DD/MM/YYYY') and  practitioner_id = '"+pract_id+"'";
	}
	try{
		con = ConnectionManager.getConnection(p);
		stmtoa_param =con.createStatement();
		rs3=stmtoa_param.executeQuery(sql_time_table_type);
		if(rs3 !=null && rs3.next()){
			time_table_type=rs3.getString("time_table_type");
			if(time_table_type ==null) time_table_type="";
		}
		if(time_table_type.equals("1")){
			if(pract_id.equals("")){
				sql1="Select round((select to_number((to_date(to_char(effective_to_date_time,'hh24:mi'),'hh24:mi')- to_date(to_char(effective_from_date_time,'hh24:mi'),'hh24:mi'))*24*60) from oa_block_appt where facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and care_locn_type_ind ='"+locn_type+"' and resource_class = '"+resource+"' and Block_date =to_date('"+date+"','DD/MM/YYYY') and SRL_NO="+srl_no3+") / (select to_number((to_date(to_char(TIME_PER_PATIENT,'hh24:mi'),'hh24:mi')- to_date('00:00','hh24:mi'))*24*60) from oa_clinic_schedule WHERE facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and clinic_date = TO_DATE('"+date+"','DD/MM/YYYY') and practitioner_id is null)) Block_diff from duaL";
			}else{
				sql1="Select round((select to_number((to_date(to_char(effective_to_date_time,'hh24:mi'),'hh24:mi')- to_date(to_char(effective_from_date_time,'hh24:mi'),'hh24:mi'))*24*60) from oa_block_appt where facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and care_locn_type_ind ='"+locn_type+"' and resource_class = '"+resource+"' and Block_date =to_date('"+date+"','DD/MM/YYYY') and SRL_NO="+srl_no3+") / (select to_number((to_date(to_char(TIME_PER_PATIENT,'hh24:mi'),'hh24:mi')- to_date('00:00','hh24:mi'))*24*60) from oa_clinic_schedule WHERE facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and clinic_date = TO_DATE('"+date+"','DD/MM/YYYY') and practitioner_id = '"+pract_id+"')) Block_diff from duaL";
			}
		}
		if(time_table_type.equals("1")){
			pstmt = con.prepareStatement( sql1 );
			//System.out.println("sql1 ==>"+sql1);
			rs=pstmt.executeQuery();
			rs.next();
			diff=rs.getInt("Block_diff");
			String time_per_pat_sql="";
			if(pract_id.equals("")){
				time_per_pat_sql="select to_number((to_date(to_char(TIME_PER_PATIENT,'hh24:mi'),'hh24:mi')- to_date('00:00','hh24:mi'))*24*60) time_per_pat from oa_clinic_schedule WHERE facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and clinic_date = TO_DATE('"+date+"','DD/MM/YYYY') and practitioner_id is null";
			}else{
				time_per_pat_sql="select to_number((to_date(to_char(TIME_PER_PATIENT,'hh24:mi'),'hh24:mi')- to_date('00:00','hh24:mi'))*24*60) time_per_pat from oa_clinic_schedule WHERE facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and clinic_date = TO_DATE('"+date+"','DD/MM/YYYY') and practitioner_id = '"+pract_id+"'";
			}
			pstmt = con.prepareStatement( time_per_pat_sql );
			//System.out.println("time_per_pat_sql ==>"+time_per_pat_sql);
			rs=pstmt.executeQuery();
			rs.next();
			int time_per_pat=0;
			time_per_pat=rs.getInt("time_per_pat");
			String no_of_slts="";
			if(pract_id.equals("")){
				no_of_slts="SELECT SUM(to_number((to_date(to_char(BREAK_END_TIME,'hh24:mi'),'hh24:mi')- to_date(to_char(BREAK_START_TIME,'hh24:mi'),'hh24:mi'))*24*60))/"+time_per_pat+" no_of_slots_break FROM OA_CLINIC_SCHEDULE_BREAK WHERE facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and clinic_date = TO_DATE('"+date+"','DD/MM/YYYY') and practitioner_id is null and (to_date(to_char(BREAK_START_TIME,'hh24:mi'),'hh24:mi')) between (to_date('"+from_time+"','hh24:mi')) and (to_date('"+to_time+"','hh24:mi')) and (to_date(to_char(BREAK_END_TIME,'hh24:mi'),'hh24:mi')) between (to_date('"+from_time+"','hh24:mi')) and (to_date('"+to_time+"','hh24:mi'))";				
			}else{
				no_of_slts="SELECT SUM(to_number((to_date(to_char(BREAK_END_TIME,'hh24:mi'),'hh24:mi')- to_date(to_char(BREAK_START_TIME,'hh24:mi'),'hh24:mi'))*24*60))/"+time_per_pat+" no_of_slots_break FROM OA_CLINIC_SCHEDULE_BREAK WHERE facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and clinic_date = TO_DATE('"+date+"','DD/MM/YYYY') and practitioner_id = '"+pract_id+"' and (to_date(to_char(BREAK_START_TIME,'hh24:mi'),'hh24:mi')) between (to_date('"+from_time+"','hh24:mi')) and (to_date('"+to_time+"','hh24:mi')) and (to_date(to_char(BREAK_END_TIME,'hh24:mi'),'hh24:mi')) between (to_date('"+from_time+"','hh24:mi')) and (to_date('"+to_time+"','hh24:mi'))";
			}
			pstmt = con.prepareStatement( no_of_slts );
			//System.out.println("no_of_slts ==>"+no_of_slts);
			rs=pstmt.executeQuery();
			rs.next();
			int no_of_slots_break=1;
			no_of_slots_break=rs.getInt("no_of_slots_break");
			diff=diff-no_of_slots_break;
		}
		String up_date="";
		String visit_limit_rule="";
		String oa_param_sql="select visit_limit_rule from oa_param where module_id='OA'";
		rs_oaparam=stmtoa_param.executeQuery(oa_param_sql);
		if(rs_oaparam !=null && rs_oaparam.next()){
			visit_limit_rule=rs_oaparam.getString("visit_limit_rule");
		}
		if(time_table_type.equals("1")){
			if (visit_limit_rule.equals("N") || visit_limit_rule=="N"){				
				if(pract_id.equals("")){
					up_date="update oa_clinic_schedule set SCHEDULE_STATUS = null, total_slots_booked=nvl(total_slots_booked,0)-nvl( '"+diff+"',0) ,  total_other_visits_blocked=nvl(total_other_visits_blocked,0)-nvl( '"+diff+"',0) , modified_by_id='"+addedById+"' ,modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"' where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+date+"','dd/mm/yyyy') and  practitioner_id is null and care_locn_type_ind ='"+locn_type+"' and resource_class='"+resource+"' ";
				}else{
					up_date="update oa_clinic_schedule set SCHEDULE_STATUS = null, total_slots_booked=nvl(total_slots_booked,0)-nvl( '"+diff+"',0) ,  total_other_visits_blocked=nvl(total_other_visits_blocked,0)-nvl( '"+diff+"',0) , modified_by_id='"+addedById+"' ,modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"' where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+date+"','dd/mm/yyyy') and practitioner_id = '"+pract_id+"' and care_locn_type_ind ='"+locn_type+"' and resource_class='"+resource+"' ";
				}
			}else{				
				if(pract_id.equals("")){
					up_date="update oa_clinic_schedule set  SCHEDULE_STATUS =null, total_slots_booked=nvl(total_slots_booked,0)-nvl( '"+diff+"',0) , total_first_visits_blocked=nvl(total_first_visits_blocked,0)-nvl( '"+first_visits_value+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)-nvl( '"+other_visits_value+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+date+"','dd/mm/yyyy') and  practitioner_id is null and care_locn_type_ind ='"+locn_type+"' and resource_class='"+resource+"' ";
				}else{
					up_date="update oa_clinic_schedule set  SCHEDULE_STATUS =null, total_slots_booked=nvl(total_slots_booked,0)-nvl( '"+diff+"',0) , total_first_visits_blocked=nvl(total_first_visits_blocked,0)-nvl( '"+first_visits_value+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)-nvl( '"+other_visits_value+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+date+"','dd/mm/yyyy') and practitioner_id = '"+pract_id+"' and care_locn_type_ind ='"+locn_type+"' and resource_class='"+resource+"' ";
				}
			}
		}else{			
			if(pract_id.equals("")){
				up_date="update oa_clinic_schedule set  SCHEDULE_STATUS =null, total_slots_booked=nvl(total_slots_booked,0)-nvl( '"+(first_visits+other_visits)+"',0) ,total_first_visits_blocked=nvl(total_first_visits_blocked,0)-nvl( '"+first_visits_value+"',0) ,  total_other_visits_blocked=nvl(total_other_visits_blocked,0)-nvl( '"+other_visits_value+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+date+"','dd/mm/yyyy') and practitioner_id is null and care_locn_type_ind ='"+locn_type+"' and resource_class='"+resource+"' ";
			}else{
				up_date="update oa_clinic_schedule set  SCHEDULE_STATUS =null, total_slots_booked=nvl(total_slots_booked,0)-nvl( '"+(first_visits+other_visits)+"',0) ,  total_other_visits_blocked=nvl(total_other_visits_blocked,0)-nvl( '"+other_visits_value+"',0) ,total_first_visits_blocked=nvl(total_first_visits_blocked,0)-nvl( '"+first_visits_value+"',0) , modified_by_id='"+addedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+date+"','dd/mm/yyyy') and practitioner_id= '"+pract_id+"' and care_locn_type_ind ='"+locn_type+"' and resource_class='"+resource+"' ";
			}
		}
		//System.out.println("up_date ==>"+up_date);
		pstmt8=con.prepareStatement(up_date);
		pstmt8.executeUpdate() ;
		if(time_table_type.equals("1")){
			if(pract_id.equals("")){
				update2="update OA_CLINIC_SCHEDULE_SLOT_SLAB  set  SCHEDULE_STATUS =null ,MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+addedAtWorkstation+"',MODIFIED_FACILITY_ID='"+facilityId+"' WHERE FACILITY_ID='"+facilityId+"' and CLINIC_CODE='"+clinic_code+"' and CLINIC_DATE=to_date('"+date+"','dd/mm/yyyy')  and PRACTITIONER_ID is null and CARE_LOCN_TYPE_IND = '"+locn_type+"' and RESOURCE_CLASS='"+resource+"' and to_date(to_char(SLOT_SLAB_START_TIME,'hh24:mi'),'hh24:mi') >=to_date('"+from_time+"','hh24:mi') and to_date(to_char(SLOT_SLAB_END_TIME,'hh24:mi'),'hh24:mi')  <=to_date('"+to_time+"','hh24:mi') and schedule_status !='X'";
			}else{
				update2="update OA_CLINIC_SCHEDULE_SLOT_SLAB  set  SCHEDULE_STATUS =null ,MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+addedAtWorkstation+"',MODIFIED_FACILITY_ID='"+facilityId+"' WHERE FACILITY_ID='"+facilityId+"' and CLINIC_CODE='"+clinic_code+"' and CLINIC_DATE=to_date('"+date+"','dd/mm/yyyy')  and PRACTITIONER_ID = '"+pract_id+"' and CARE_LOCN_TYPE_IND = '"+locn_type+"' and RESOURCE_CLASS='"+resource+"' and to_date(to_char(SLOT_SLAB_START_TIME,'hh24:mi'),'hh24:mi') >=to_date('"+from_time+"','hh24:mi') and to_date(to_char(SLOT_SLAB_END_TIME,'hh24:mi'),'hh24:mi')  <=to_date('"+to_time+"','hh24:mi') and schedule_status !='X'";
			}
		}else{			
			if(pract_id.equals("")){
				update2="update OA_CLINIC_SCHEDULE_SLOT_SLAB  set  SCHEDULE_STATUS =null ,MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+addedAtWorkstation+"',MODIFIED_FACILITY_ID='"+facilityId+"' WHERE FACILITY_ID='"+facilityId+"' and CLINIC_CODE='"+clinic_code+"' and CLINIC_DATE=to_date('"+date+"','dd/mm/yyyy')  and PRACTITIONER_ID is null and CARE_LOCN_TYPE_IND = '"+locn_type+"' and RESOURCE_CLASS='"+resource+"' and to_date(to_char(SLOT_SLAB_START_TIME,'hh24:mi'),'hh24:mi') >=to_date('"+from_time+"','hh24:mi') and to_date(to_char(SLOT_SLAB_END_TIME,'hh24:mi'),'hh24:mi')  <=to_date('"+to_time+"','hh24:mi') and schedule_status !='X' and ROWNUM <='"+(first_visits+other_visits)+"' ";
			}else{
				update2="update OA_CLINIC_SCHEDULE_SLOT_SLAB  set  SCHEDULE_STATUS =null ,MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+addedAtWorkstation+"',MODIFIED_FACILITY_ID='"+facilityId+"' WHERE FACILITY_ID='"+facilityId+"' and CLINIC_CODE='"+clinic_code+"' and CLINIC_DATE=to_date('"+date+"','dd/mm/yyyy')  and  PRACTITIONER_ID = '"+pract_id+"' and CARE_LOCN_TYPE_IND = '"+locn_type+"' and RESOURCE_CLASS='"+resource+"' and to_date(to_char(SLOT_SLAB_START_TIME,'hh24:mi'),'hh24:mi') >=to_date('"+from_time+"','hh24:mi') and to_date(to_char(SLOT_SLAB_END_TIME,'hh24:mi'),'hh24:mi')  <=to_date('"+to_time+"','hh24:mi') and schedule_status !='X' and ROWNUM <='"+(first_visits+other_visits)+"' ";
			}
		}

		//System.out.println("update2 ==>"+update2);
		pstmt9=con.prepareStatement(update2);
		res_oa_clic=pstmt9.executeUpdate() ;

		String del = "delete from oa_block_appt  where facility_id ='"+facilityId+"' and clinic_code='"+clinic_code+"' and block_date=to_date('"+date+"','DD/MM/YYYY') and srl_no='"+srl_no+"' and CARE_LOCN_TYPE_IND ='"+locn_type+"' and RESOURCE_CLASS ='"+resource+"'";
		pstmt3=con.prepareStatement(del);
		int res = pstmt3.executeUpdate() ;
		//Added by 12/31/2008
		// delete from dtl table

			if(!alcncriteria.equals(""))
				{
				String selectsql = "select * from OA_BLOCK_APPT_DTL  where facility_id ='"+facilityId+"' and clinic_code='"+clinic_code+"' and block_date=to_date('"+date+"','DD/MM/YYYY') and srl_no="+srl_no+" and ALCN_CRITERIA='"+alcncriteria+"'";
				pstmt3=con.prepareStatement(selectsql);
				rs = pstmt3.executeQuery();
				while (rs!=null && rs.next())
				{

					String alcncatcode = rs.getString("ALCN_CATG_CODE");
					int totalslotsblocked = rs.getInt("BLOCKED_SLOTS");


					/*String updatesql="update oa_clinic_schedule_dtl set  TOTAL_BLOCKED_SLOTS=nvl(TOTAL_BLOCKED_SLOTS,0)-nvl( '"+totalslotsblocked+"',0) "+
							" ,modified_by_id='"+addedById+"' "+
							" ,modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"' "+
							" where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+date+"','dd/mm/yyyy') "+
							" and nvl(practitioner_id,'X')=nvl('"+pract_id+"' ,'X') and ALCN_CRITERIA = '"+alcncriteria+"' and ALCN_CATG_CODE = '"+alcncatcode+"' ";*/
							//this query changed by sreelatha on 30/04/2005
							String updatesql="";
							if(pract_id.equals("")){
								updatesql="update oa_clinic_schedule_dtl set TOTAL_BOOKED_PATIENTS= nvl(TOTAL_BOOKED_PATIENTS,0)-nvl(to_number('"+totalslotsblocked+"'),0), TOTAL_BLOCKED_SLOTS=nvl(TOTAL_BLOCKED_SLOTS,0)-nvl( '"+totalslotsblocked+"',0),modified_by_id='"+addedById+"' "+" ,modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"' where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+date+"','dd/mm/yyyy') and practitioner_id is null and ALCN_CRITERIA = '"+alcncriteria+"' and ALCN_CATG_CODE = '"+alcncatcode+"' ";
							}else{
								updatesql="update oa_clinic_schedule_dtl set TOTAL_BOOKED_PATIENTS= nvl(TOTAL_BOOKED_PATIENTS,0)-nvl(to_number('"+totalslotsblocked+"'),0), TOTAL_BLOCKED_SLOTS=nvl(TOTAL_BLOCKED_SLOTS,0)-nvl( '"+totalslotsblocked+"',0),modified_by_id='"+addedById+"' "+" ,modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"' where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+date+"','dd/mm/yyyy') and practitioner_id = '"+pract_id+"' and ALCN_CRITERIA = '"+alcncriteria+"' and ALCN_CATG_CODE = '"+alcncatcode+"' ";
							}
					pstmt4 = con.prepareStatement(updatesql);
					//int res4 = pstmt4.executeUpdate();
					pstmt4.executeUpdate();
				}



				String deldtl = "delete from OA_BLOCK_APPT_DTL  where facility_id ='"+facilityId+"' and clinic_code='"+clinic_code+"' and block_date=to_date('"+date+"','DD/MM/YYYY') and srl_no="+srl_no+" and ALCN_CRITERIA='"+alcncriteria+"'";


				pstmt3=con.prepareStatement(deldtl);
				//int resdtl = pstmt3.executeUpdate() ;
				pstmt3.executeUpdate() ;
			}
		//Added by 12/31/2008
		String sql5="select nvl(max(srl_no),0)+1 maxnum from OA_TRANS_RECORD  where facility_id='"+facilityId+"' ";
		pstmt4= con.prepareStatement(sql5);
		rs3 = pstmt4.executeQuery() ;
		String maxnum1="";
		while(rs3.next()){
			maxnum1=rs3.getString(1);
		}
		int maxnum=Integer.parseInt(maxnum1);


			String sql20="Insert into oa_trans_record (facility_id,trans_code,trans_date_time,trans_eff_by_id,clinic_code,care_locn_type_ind,resource_class,from_date_entered, to_date_entered, from_practitioner_id, to_practitioner_id,srl_no) values (?,'LS',sysdate,?,?,?,?,to_date(?,'DD/MM/YYYY'),to_date(?,'DD/MM/YYYY'),?,?,?)";
			pstmt7 = con.prepareStatement( sql20);
			pstmt7.setString	(1, facilityId) ;
			pstmt7.setString	(2, addedById) ;
			pstmt7.setString	(3, clinic_code) ;
			pstmt7.setString	(4, locn_type) ;
			pstmt7.setString	(5, resource) ;
			pstmt7.setString	(6, date) ;
			pstmt7.setString	(7, date) ;
			pstmt7.setString	(8, pract_id) ;
			pstmt7.setString	(9, pract_id) ;
			pstmt7.setInt		(10, maxnum) ;


/*
		String sql20="Insert into oa_trans_record (facility_id,srl_no,trans_code,trans_date_time,trans_eff_by_id,clinic_code,care_locn_type_ind,resource_class) values (?, ? ,'LS' ,to_date(?,'DD/MM/YYYY') , ?  ,?,?,?)";
		pstmt7 = con.prepareStatement( sql20);
		pstmt7.setString	( 1, facilityId) ;
		pstmt7.setInt		( 2, maxnum) ;
		pstmt7.setString	(3, date) ;
		pstmt7.setString	(4, addedById) ;
		pstmt7.setString	(5, clinic_code) ;
		pstmt7.setString	(6, locn_type) ;
		pstmt7.setString	(7, resource) ;
		*/
		int res10 = pstmt7.executeUpdate() ;
		if ( res != 0 && res10 !=0) {
			result = true ;
			java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_DELETED","SM" ) ;
			sb.append( (String) message.get("message") ) ;
			//System.out.println("Before commit is tolled back");
			con.commit() ;
		}else{
			sb.append( "error during deletion" ) ;
			con.rollback() ;
		}
		if (rs8 !=null) rs8.close() ;
		if (rs !=null) rs.close() ;
		if (rs7 !=null) rs7.close() ;
		if (rs2 !=null) rs2.close() ;
		if (rs3 !=null) rs3.close() ;
		if (stmtoa_param!=null) stmtoa_param.close();
		if (pstmt !=null) pstmt.close() ;
		if (pstmt !=null) pstmt.close() ;
		if (pstmt2 !=null) pstmt2.close() ;
		if (pstmt3 !=null) pstmt3.close() ;
		if (pstmt4 !=null) pstmt4.close() ;
		if (pstmt7 !=null) pstmt7.close() ;
		if (pstmt8 !=null) pstmt8.close() ;
		if (pstmt14 !=null) pstmt14.close() ;
		if (pstmt15 !=null) pstmt15.close() ;
	}catch ( Exception e ){
		e.printStackTrace();
		try{
			con.rollback() ;
		}catch ( Exception ce ) {
			ce.printStackTrace();
		}
		sb.append( e.toString() + "<br>" ) ;
	}finally{
		if (con != null) ConnectionManager.returnConnection(con,p);
	}
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	sb.setLength(0);
	return results ;
} // method

} //class

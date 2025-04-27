/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA.BlockLiftCancelSch;

import java.rmi.* ;
import javax.ejb.* ;

import java.sql.* ;
import java.util.* ;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
*
* @ejb.bean
*	name="BlockLiftCancelSch"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="BlockLiftCancelSch"
*	local-jndi-name="BlockLiftCancelSch"
*	impl-class-name="eOA.BlockLiftCancelSch.BlockLiftCancelSchManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eOA.BlockLiftCancelSch.BlockLiftCancelSchManagerLocal"
*	remote-class="eOA.BlockLiftCancelSch.BlockLiftCancelSchManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOA.BlockLiftCancelSch.BlockLiftCancelSchManagerLocalHome"
*	remote-class="eOA.BlockLiftCancelSch.BlockLiftCancelSchManagerHome"
*	generate= "local,remote"
*
*
*/
public class BlockLiftCancelSchManager implements SessionBean {

	//Connection con ;// Commented for KDAH-SCF-0704
	PreparedStatement pstmt=null,pstmt1=null,pstmt2=null,pstmt3=null,pstmt4=null,pstmt5=null,pstmt7=null,pstmt8=null,pstmt9=null,pstmt_inst;
	PreparedStatement pstmt_sql_upd_oa_clinic_schedule_slot_slab=null,pstmt_sql_oa_block_appt =null,pstmt2_sql2_oa_block_appt=null,oa_block_appt_dtl=null,pstmt_oa_clinic_schedule_dtl=null,pstmt_oa_clinic_schedule=null,pstmt_oa_trans_record=null,pstmt2_oa_block_appt_dtl=null,pstmt1_oa_block_appt=null;
	ResultSet rs=null,rs1=null,rset=null,rset2 = null,rs_sl=null;
	Statement stmt=null;
	String locn = "",pract ="",dat = "",day="",str="",ethnic_grp_cd="",ethnic_subgrp_cd="",citizen_yn="",legal_yn="",birth_place_code="",forced_appt_yn="",global_appt_yn="",res_town="",res_area="",res_region="",res_country="",mail_addr1="",mail_addr2="",mail_addr3="",mail_addr4="",mail_town="",mail_area="",mail_postal="",mail_region="",mail_country="",appt_ref_nos="",sl = "",srl_no1="";
	int res = 0,srlno = 0,sel_del_1=0,sel_del_2=0,sel_del_3=0,sel_del_4=0,sel_del_5=0;
	String blk_schdl_with_appt_yn="N";//JD-CRF-0168 changes
	boolean sql_operation=false;
	SessionContext ctx;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public void ejbCreate()  {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) { this.ctx=context;}

///////////////////////////////////////////////BlockSch///////////////////////
/**
* @ejb.interface-method
*	 view-type="both"
*/
	public java.util.HashMap BlockSch(
							java.util.Properties p,
							java.util.HashMap passObjects
						 )
		{

	Connection con =null;// Added for KDAH-SCF-0704
	int n=((Integer) passObjects.get("n1")).intValue();
	int s=((Integer) passObjects.get("s1")).intValue();
	String finalvals=(String) passObjects.get("finalvals1");
	String reason=(String) passObjects.get("reason");
	String fid=(String) passObjects.get("fid");
	String facilityId=(String) passObjects.get("facilityId");
	String	  addedAtWorkstation=(String) passObjects.get("client_ip_address");
	String location_Type=(String) passObjects.get("location_Type");
	String resource_Type=(String) passObjects.get("resource_Type");
	String bulk_blocking_yn=(String) passObjects.get("bulk_blocking_yn");
	String visit_limit_rule=(String) passObjects.get("visit_limit_rule");
	String blk_time_from=(String) passObjects.get("blk_time_from");
	String blk_time_to=(String) passObjects.get("blk_time_to");
	String blk_schdl_with_appt_yn=(String) passObjects.get("blk_schdl_with_appt_yn");//JD-CRF-0168 changes
	String other_remarks = (String) passObjects.get("other_remarks"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	StringTokenizer st1;
	//String max_patients_per_day=(String) passObjects.get("max_patients_per_day");
	String locale = p.getProperty("LOCALE");
	String modifiedById = p.getProperty( "login_user" ) ;
	String time_table_type="";
	String noSlots_Blocked="";
	String noFirst_VistsBlocked="";
	String noFirst_Vists_ToBe_Blocked="";
	String noOther_VistsBlocked="";
	String noOther_Vists_ToBe_Blocked="";
	PreparedStatement blk_pstmt0=null,blk_pstmt1=null,blk_pstmt2=null,blk_pstmt3=null,blk_pstmt4=null,updatebolckapptpstmt=null;
	ResultSet blk_rs1=null;
	String block_time_from="";
	String block_time_to="";
	boolean bulk_falg=true;
	int recordCount=0;
	int tokenCount=0;
	String deleteBlockSchYN="";
	String blk_trans_record="Insert into oa_trans_record (facility_id,srl_no,trans_code,trans_date_time,trans_eff_by_id,clinic_code,care_locn_type_ind,resource_class,from_date_entered, to_date_entered,from_practitioner_id,REASON_CODE) values (?,to_number(?),'BS',sysdate,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?)";

	java.util.HashMap results = new java.util.HashMap() ;
	boolean result = false ;
	int other_visits_blocked =0,first_visits_blocked =0,total_slots_booked =0;
	StringBuffer sb = new StringBuffer( "" ) ;
	String sql1_oa_block_appt="";
	String sql_oa_trans_record  = "Select nvl(max(srl_no),0)+1 max from oa_trans_record where facility_id=? ";

	String block_time_sql="SELECT to_char(min(slot_slab_start_time),'hh24:mi') block_from_time,to_char(max(slot_slab_end_time),'hh24:mi') block_to_time  FROM oa_clinic_schedule_slot_slab WHERE facility_id = ? AND clinic_code = ? AND clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND NVL (practitioner_id, 'X') = NVL (?, 'X') AND care_locn_type_ind = ? AND resource_class = ? AND TO_DATE (TO_CHAR (slot_slab_start_time, 'hh24:mi'), 'hh24:mi') BETWEEN TO_DATE (?, 'hh24:mi') AND TO_DATE (?, 'hh24:mi') AND TO_DATE (TO_CHAR (slot_slab_end_time, 'hh24:mi'), 'hh24:mi') BETWEEN TO_DATE (?, 'hh24:mi') AND TO_DATE (?, 'hh24:mi')  AND schedule_status IS NULL";
	String upadteBlockAptSQL="delete from oa_block_appt where FACILITY_ID=? and clinic_code=? and trunc(BLOCK_DATE)=to_date(?,'dd/mm/yyyy') and nvl(practitioner_id,'X')= nvl(?,'X')";
	try{


		con = ConnectionManager.getConnection(p);
		String sql_oa_appt = "  select appt_ref_no  from oa_appt where facility_id = ? and clinic_code = ? and appt_date = to_date(?,'dd/mm/yyyy') and Nvl(practitioner_id,'X') =Nvl(?,'X') and care_locn_type_ind= ? and resource_class = ? ";
		pstmt = con.prepareStatement( sql_oa_appt ) ;
		updatebolckapptpstmt = con.prepareStatement( upadteBlockAptSQL ) ;
		//commented the following as per to update slot_slab table with null values for schedule_status
		//String sql_upd_oa_clinic_schedule_slot_slab="Update oa_clinic_schedule_slot_slab Set  schedule_status='B' Where Facility_id=? and Clinic_code=?  and Clinic_date=to_date(?,'dd/mm/yyyy') and Nvl(practitioner_id,'X') !=Nvl(?,'X' ) and resource_class !=? and  pri_appt_ref_no in (?)" ;
		String sql_upd_oa_clinic_schedule_slot_slab_01="Update oa_clinic_schedule_slot_slab Set  schedule_status='' Where Facility_id=? and Clinic_code=?  and Clinic_date=to_date(?,'dd/mm/yyyy') and practitioner_id is null and schedule_status='B'" ;
		String sql_upd_oa_clinic_schedule_slot_slab_02="Update oa_clinic_schedule_slot_slab Set  schedule_status='' Where Facility_id=? and Clinic_code=?  and Clinic_date=to_date(?,'dd/mm/yyyy') and practitioner_id = ? and schedule_status='B'" ;
		
		String sql_oa_block_appt = "  select sum(nvl(first_visits_blocked,0)) fvb,sum(nvl(other_visits_blocked,0)) ovb   from oa_block_appt where facility_id = ? and clinic_code = ? and  Block_date = to_date(?,'dd/mm/yyyy') and Nvl(practitioner_id,'X') =Nvl(?,'X') and care_locn_type_ind= ? and resource_class = ? ";
		pstmt_sql_oa_block_appt = con.prepareStatement( sql_oa_block_appt ) ;

		//String sql1_oa_block_appt="select nvl(max(srl_no),0)+1 maxnum from oa_block_appt where facility_id=? and clinic_code=?";
		//pstmt1_oa_block_appt = con.prepareStatement( sql1_oa_block_appt) ;

		String sql2_oa_block_appt="Insert into oa_block_appt(facility_id, clinic_code, block_date, srl_no, practitioner_id, effective_from_date_time, effective_to_date_time, reason_for_block, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, first_visits_blocked, other_visits_blocked,care_locn_type_ind,resource_class,remarks_for_block) values (?, ? ,to_date(?,'dd/mm/yyyy') , to_number(?) ,? ,to_date(?,'hh24:mi'), to_date(?,'hh24:mi'),? ,? ,sysdate ,? ,? ,? ,sysdate, ? ,?,?,?,?,?,?) "; //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

		pstmt2_sql2_oa_block_appt = con.prepareStatement( sql2_oa_block_appt) ;



		//String sql2_oa_block_appt = " Delete from oa_block_appt where facility_id=? and Clinic_code=?and Block_date=to_date(?,'dd/mm/yyyy')and nvl(Practitioner_id,'X')=nvl(?,'X') and care_locn_type_ind= ? and resource_class = ? " ;
		//pstmt2_sql2_oa_block_appt = con.prepareStatement( sql2_oa_block_appt) ;
		/*	String sql2_oa_block_appt_dtl = " Delete from oa_block_appt_dtl where facility_id=? and Clinic_code=?and Block_date=to_date(?,'dd/mm/yyyy')  and nvl(Practitioner_id,'X')=nvl(?,'X') and care_locn_type_ind= ? and resource_class = ? " ;
		pstmt2_oa_block_appt_dtl = con.prepareStatement( sql2_oa_block_appt_dtl) ;
		String sql_oa_clinic_schedule_dtl = "  Update oa_clinic_schedule_dtl Set  total_blocked_slots =0 , total_booked_patients   = nvl(total_booked_patients,0) - NVL(total_blocked_slots,0) Where Facility_id=? and Clinic_code=?   and Clinic_date=to_date(?,'dd/mm/yyyy') and Nvl(practitioner_id,'X') =Nvl(?,'X' ) and care_locn_type_ind= ? and resource_class = ?" ;
		pstmt_oa_clinic_schedule_dtl = con.prepareStatement( sql_oa_clinic_schedule_dtl );*/
		//Changes for JD-CRF-0168
		String sql_oa_clinic_schedule ="";
		if(blk_schdl_with_appt_yn.equals("N")){
			sql_oa_clinic_schedule = "  Update oa_clinic_schedule Set  schedule_status='B' , total_slots_booked=?,  total_first_visits_blocked=?,  total_other_visits_blocked =?,  remarks =? , reason_code =? ,  modified_by_id =? , modified_date = sysdate,  modified_at_ws_no = ?, modified_facility_id = ?  Where Facility_id=? and Clinic_code=?  and Clinic_date=to_date(?,'dd/mm/yyyy') and Nvl(practitioner_id,'X') =Nvl(?,'X' ) and care_locn_type_ind= ? and resource_class = ?" ;
		}
		else{
			sql_oa_clinic_schedule = "  Update oa_clinic_schedule Set  schedule_status='B' ,  remarks =? , reason_code =? ,  modified_by_id =? , modified_date = sysdate,  modified_at_ws_no = ?, modified_facility_id = ?  Where Facility_id=? and Clinic_code=?  and Clinic_date=to_date(?,'dd/mm/yyyy') and Nvl(practitioner_id,'X') =Nvl(?,'X' ) and care_locn_type_ind= ? and resource_class = ?" ;
		}


		pstmt_oa_clinic_schedule = con.prepareStatement( sql_oa_clinic_schedule );
		pstmt_oa_trans_record=con.prepareStatement(sql_oa_trans_record);
		String sql1_ins_oa_trans_record = " Insert into oa_trans_record  (facility_id,srl_no,trans_code,trans_date_time, trans_eff_by_id,  from_date_entered,to_date_entered, clinic_code,from_practitioner_id,from_day_no,remarks,reason_code,care_locn_type_ind,resource_class)  values (?,?,?,sysdate,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?) " ;
		pstmt1 = con.prepareStatement( sql1_ins_oa_trans_record );

		StringTokenizer st = new StringTokenizer(finalvals,"-");

		tokenCount=st.countTokens();
		mainwhile: while(st.hasMoreTokens())
		{
			str = st.nextToken();

			st1 = new StringTokenizer(str,"|");

			while(st1.hasMoreTokens())
			{
				locn = st1.nextToken();
				pract = st1.nextToken();
				if(pract=="X" || pract.equals("X")) pract="";
				dat = st1.nextToken();
				day = st1.nextToken();
				st1.nextToken();
				//deleteBlockSchYN=st1.nextToken();
				if(bulk_blocking_yn.equals("Y")){
					time_table_type=st1.nextToken();//time table type
					noSlots_Blocked=st1.nextToken();//total visits to be blocked
					noFirst_VistsBlocked=st1.nextToken();//total first  visits blocked
					noFirst_Vists_ToBe_Blocked=st1.nextToken();//total first  visits to be  blocked
					noOther_VistsBlocked=st1.nextToken();//total first  other visits blocked
					noOther_Vists_ToBe_Blocked=st1.nextToken();//total first  other visits to be  blocked
					String oa_clinic_sch_update="";

					sql1_oa_block_appt="select nvl(max(srl_no),0)+1 maxnum from oa_block_appt where facility_id=? and clinic_code=?";

					//if(visit_limit_rule.equals("N") || time_table_type.equals("2")){
					if(visit_limit_rule.equals("N")){
						oa_clinic_sch_update="update oa_clinic_schedule set  total_slots_booked=nvl(total_slots_booked,0)+nvl(		'"+noOther_Vists_ToBe_Blocked+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+noOther_Vists_ToBe_Blocked+"',0) , modified_by_id='"+modifiedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"'  where facility_id='"+facilityId+"' and clinic_code='"+locn+"' and clinic_date=to_date('"+dat+"','dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl('"+pract+"' ,'X')";
					}else{
						oa_clinic_sch_update="update oa_clinic_schedule set  total_slots_booked=nvl(total_slots_booked,0)+nvl( '"+(Integer.parseInt(noFirst_Vists_ToBe_Blocked)+Integer.parseInt(noOther_Vists_ToBe_Blocked))+"',0) , total_first_visits_blocked=nvl(total_first_visits_blocked,0)+nvl( '"+noFirst_Vists_ToBe_Blocked+"',0) , total_other_visits_blocked=nvl(total_other_visits_blocked,0)+nvl( '"+noOther_Vists_ToBe_Blocked+"',0) , modified_by_id='"+modifiedById+"',modified_date=sysdate,modified_at_ws_no='"+addedAtWorkstation+"', modified_facility_id='"+facilityId+"' where facility_id='"+facilityId+"' and clinic_code='"+locn+"' and clinic_date=to_date('"+dat+"','dd/mm/yyyy')  and nvl(practitioner_id,'X')=nvl('"+pract+"' ,'X')";
					}
					try{
						blk_pstmt0=con.prepareStatement(block_time_sql);
						blk_pstmt0.setString(1,facilityId);
						blk_pstmt0.setString(2,locn);
						blk_pstmt0.setString(3,dat);
						blk_pstmt0.setString(4,pract);
						blk_pstmt0.setString(5,location_Type);
						blk_pstmt0.setString(6,resource_Type);
						blk_pstmt0.setString(7,blk_time_from);
						blk_pstmt0.setString(8,blk_time_to);
						blk_pstmt0.setString(9,blk_time_from);
						blk_pstmt0.setString(10,blk_time_to);
						if(blk_rs1!=null)blk_rs1.close();
						blk_rs1=blk_pstmt0.executeQuery();
						if(blk_rs1!=null && blk_rs1.next()){
							block_time_from=blk_rs1.getString("block_from_time");
							block_time_to=blk_rs1.getString("block_to_time");
						}
						String oa_clinic_sch_slt_slb_update="update OA_CLINIC_SCHEDULE_SLOT_SLAB  set  SCHEDULE_STATUS = 'B' ,MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+addedAtWorkstation+"',MODIFIED_FACILITY_ID='"+facilityId+"' WHERE FACILITY_ID='"+facilityId+"' and CLINIC_CODE='"+locn+"' and CLINIC_DATE=to_date('"+dat+"','dd/mm/yyyy')  and nvl(PRACTITIONER_ID,'X')=nvl('"+pract+"' ,'X') and CARE_LOCN_TYPE_IND = '"+location_Type+"' and RESOURCE_CLASS='"+resource_Type+"' AND to_date(to_char(SLOT_SLAB_START_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+block_time_from+"','hh24:mi') and to_date('"+block_time_to+"','hh24:mi') AND to_date(to_char(SLOT_SLAB_END_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+block_time_from+"','hh24:mi') and to_date('"+block_time_to+"','hh24:mi') and schedule_status is null";
						//System.out.println("oa_clinic_sch_slt_slb_update ==>"+oa_clinic_sch_slt_slb_update);
						if(blk_rs1!=null)blk_rs1.close();
						if(blk_pstmt0!=null)blk_pstmt0.close();
						blk_pstmt0=con.prepareStatement(sql1_oa_block_appt);//getting serial number from oa_block_appt
						blk_pstmt0.setString(1,facilityId);
						blk_pstmt0.setString(2,locn);
						blk_rs1=blk_pstmt0.executeQuery();
						String block_appt_srl_no="";
						String trans_srl_no="";
						if(blk_rs1!=null && blk_rs1.next()){
							block_appt_srl_no = blk_rs1.getString("maxnum");
							if(block_appt_srl_no==null)block_appt_srl_no="";
						}
						if(blk_rs1!=null)blk_rs1.close();
						if(blk_pstmt0!=null)blk_pstmt0.close();
						blk_pstmt0=con.prepareStatement(sql_oa_trans_record);//for getting serial number from oa_trans_record
						blk_pstmt0.setString(1,facilityId);
						blk_rs1=blk_pstmt0.executeQuery();
						if(blk_rs1!=null && blk_rs1.next()){
							trans_srl_no = blk_rs1.getString("max");
							if(trans_srl_no==null)trans_srl_no="";
						}
						blk_pstmt1=con.prepareStatement(oa_clinic_sch_update);//update oa_clinic_schedule
						int blk_sch_slt_slb_res=0;
						int blk_sch_res=0;
						int block_appt_res=0;
						int blk_trns_res=0;
						blk_sch_res=blk_pstmt1.executeUpdate();
						if(blk_sch_res > 0){
							bulk_falg=true;
						}else{
							bulk_falg=false;
						}
						if(bulk_falg){
							blk_pstmt2=con.prepareStatement(oa_clinic_sch_slt_slb_update);//update oa_clinic_schedule_slot_slab
							blk_sch_slt_slb_res=blk_pstmt2.executeUpdate();
							if(blk_sch_slt_slb_res>0){
								bulk_falg=true;
							}else{
								bulk_falg=false;
							}
						}
						if(bulk_falg){
							blk_pstmt3=con.prepareStatement(sql2_oa_block_appt);
							blk_pstmt3.setString( 1, facilityId ) ;
							blk_pstmt3.setString( 2, locn ) ;
							blk_pstmt3.setString( 3, dat ) ;
							blk_pstmt3.setString( 4, block_appt_srl_no ) ;
							blk_pstmt3.setString( 5, pract ) ;
							blk_pstmt3.setString( 6, block_time_from ) ;
							blk_pstmt3.setString( 7, block_time_to ) ;
							blk_pstmt3.setString( 8, reason ) ;
							blk_pstmt3.setString( 9, modifiedById ) ;
							blk_pstmt3.setString( 10, addedAtWorkstation ) ;
							blk_pstmt3.setString(11,facilityId);
							blk_pstmt3.setString( 12, modifiedById ) ;
							blk_pstmt3.setString( 13, addedAtWorkstation ) ;
							blk_pstmt3.setString(14,facilityId);
							blk_pstmt3.setInt( 15, Integer.parseInt(noFirst_Vists_ToBe_Blocked)) ;
							blk_pstmt3.setInt( 16, Integer.parseInt(noOther_Vists_ToBe_Blocked)) ;
							blk_pstmt3.setString( 17, location_Type ) ;
							blk_pstmt3.setString( 18, resource_Type ) ;
							blk_pstmt3.setString( 19, other_remarks ) ; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
							block_appt_res=blk_pstmt3.executeUpdate();
							if(block_appt_res>0){
								bulk_falg=true;
							}else{
								bulk_falg=false;
							}
						}
						if(bulk_falg){
							blk_pstmt4=con.prepareStatement(blk_trans_record);
							blk_pstmt4.setString	( 1, facilityId) ;
							blk_pstmt4.setString	( 2, trans_srl_no) ;
							//blk_pstmt4.setString	(3, dat) ;
							blk_pstmt4.setString	(3, modifiedById) ;
							blk_pstmt4.setString	(4, locn) ;
							blk_pstmt4.setString	(5, location_Type) ;
							blk_pstmt4.setString	(6, resource_Type) ;
							blk_pstmt4.setString	(7, dat) ;
							blk_pstmt4.setString	(8, dat) ;
							if(pract==null){
								blk_pstmt4.setString	(9, "") ;
							}else{
								blk_pstmt4.setString	(9, pract) ;
							}
							blk_pstmt4.setString	(10, reason) ;
							blk_trns_res=blk_pstmt4.executeUpdate();
							if(blk_trns_res>0){
								bulk_falg=true;
							}else{
								bulk_falg=false;
							}
						}
						if(bulk_falg){
							recordCount++;
						}else{
							recordCount--;
						}
					}catch(Exception blk_ex){
						blk_ex.printStackTrace();
						recordCount--;

					}
				}else{
					deleteBlockSchYN=st1.nextToken();
					/*pstmt.setString( 1, facilityId ) ;
					pstmt.setString( 2, locn ) ;
					pstmt.setString( 3, dat ) ;
					pstmt.setString( 4, pract ) ;
					pstmt.setString( 5, location_Type ) ;
					pstmt.setString( 6, resource_Type ) ;
					rs = pstmt.executeQuery() ;
					if(rs != null){
						while(rs.next()){
							appt_ref_nos=appt_ref_nos+"'"+rs.getString("appt_ref_no")+"',";
						}
					}*/
					if(deleteBlockSchYN.equals("Y") && !time_table_type.equals("3")){
						updatebolckapptpstmt.setString(1,facilityId);
						updatebolckapptpstmt.setString(2, locn);
						updatebolckapptpstmt.setString(3, dat );
						updatebolckapptpstmt.setString(4, pract);
						updatebolckapptpstmt.executeUpdate();
						//if(updatebolckapptpstmt!=null)updatebolckapptpstmt.close(); //Commented by Dharma on Aug 11th 2015 against ML-BRU-SCF-1625 [IN:056117]
						if(pract.equals("")){
							pstmt_sql_upd_oa_clinic_schedule_slot_slab = con.prepareStatement( sql_upd_oa_clinic_schedule_slot_slab_01);
						}else{
							pstmt_sql_upd_oa_clinic_schedule_slot_slab = con.prepareStatement( sql_upd_oa_clinic_schedule_slot_slab_02);
						}
						pstmt_sql_upd_oa_clinic_schedule_slot_slab.setString( 1, facilityId ) ;
						pstmt_sql_upd_oa_clinic_schedule_slot_slab.setString( 2, locn ) ;
						pstmt_sql_upd_oa_clinic_schedule_slot_slab.setString( 3, dat ) ;
						if(!pract.equals("")){
							pstmt_sql_upd_oa_clinic_schedule_slot_slab.setString( 4, pract ) ;
						}
						res = pstmt_sql_upd_oa_clinic_schedule_slot_slab.executeUpdate() ;
					}

					/*if(appt_ref_nos.length() > 1){
						appt_ref_nos=appt_ref_nos.substring(0,appt_ref_nos.length()-1);
					}*/
					/*if(appt_ref_nos.length() > 1){
						pstmt_sql_upd_oa_clinic_schedule_slot_slab.setString( 1, facilityId ) ;
						pstmt_sql_upd_oa_clinic_schedule_slot_slab.setString( 2, locn ) ;
						pstmt_sql_upd_oa_clinic_schedule_slot_slab.setString( 3, dat ) ;
						pstmt_sql_upd_oa_clinic_schedule_slot_slab.setString( 4, pract ) ;
						pstmt_sql_upd_oa_clinic_schedule_slot_slab.setString( 5, resource_Type ) ;
						pstmt_sql_upd_oa_clinic_schedule_slot_slab.setString( 6, appt_ref_nos ) ;

						res = pstmt_sql_upd_oa_clinic_schedule_slot_slab.executeUpdate() ;
					}*/



					/*pstmt_sql_oa_block_appt.setString( 1, facilityId ) ;
					pstmt_sql_oa_block_appt.setString( 2, locn ) ;
					pstmt_sql_oa_block_appt.setString( 3, dat ) ;
					pstmt_sql_oa_block_appt.setString( 4, pract ) ;
					pstmt_sql_oa_block_appt.setString( 5, location_Type ) ;
					pstmt_sql_oa_block_appt.setString( 6, resource_Type ) ;
					rs = pstmt_sql_oa_block_appt.executeQuery() ;
					if(rs != null)
					{
						if(rs.next()){
							first_visits_blocked = rs.getInt("fvb");
							other_visits_blocked = rs.getInt("ovb");
						}
					}

					sql1_oa_block_appt="select nvl(max(srl_no),0)+1 maxnum from oa_block_appt where facility_id='"+facilityId+"' and clinic_code='"+locn+"'";

					pstmt1_oa_block_appt = con.prepareStatement( sql1_oa_block_appt) ;
					rs_sl = pstmt1_oa_block_appt.executeQuery() ;
					if(rs_sl !=null){
					while (rs_sl.next())
					{
						srl_no1 = rs_sl.getString("maxnum");
						if(srl_no1 ==null) srl_no1="";
					}
					}


					pstmt2_sql2_oa_block_appt.setString( 1, facilityId ) ;
					pstmt2_sql2_oa_block_appt.setString( 2, locn ) ;
					pstmt2_sql2_oa_block_appt.setString( 3, dat ) ;
					pstmt2_sql2_oa_block_appt.setString( 4, srl_no1 ) ;
					pstmt2_sql2_oa_block_appt.setString( 5, pract ) ;
					pstmt2_sql2_oa_block_appt.setString( 6, start_time ) ;
					pstmt2_sql2_oa_block_appt.setString( 7, end_time ) ;
					pstmt2_sql2_oa_block_appt.setString( 8, reason ) ;
					pstmt2_sql2_oa_block_appt.setString	( 9, modifiedById ) ;
					pstmt2_sql2_oa_block_appt.setString	( 10, addedAtWorkstation ) ;
					pstmt2_sql2_oa_block_appt.setString (11,facilityId);
					pstmt2_sql2_oa_block_appt.setString	( 12, modifiedById ) ;
					pstmt2_sql2_oa_block_appt.setString	( 13, addedAtWorkstation ) ;
					pstmt2_sql2_oa_block_appt.setString (14,facilityId);
					pstmt2_sql2_oa_block_appt.setInt( 15, first_visits_blocked ) ;
					pstmt2_sql2_oa_block_appt.setInt( 16, other_visits_blocked ) ;
					pstmt2_sql2_oa_block_appt.setString( 17, location_Type ) ;
					pstmt2_sql2_oa_block_appt.setString( 18, resource_Type ) ;
					res = pstmt2_sql2_oa_block_appt.executeUpdate() ;*/


					total_slots_booked = first_visits_blocked+other_visits_blocked;
					//JD-CRF-0168 changes
					if(blk_schdl_with_appt_yn.equals("N")){	
						pstmt_oa_clinic_schedule.setString(1, "0");
						pstmt_oa_clinic_schedule.setInt(2, 0);
						pstmt_oa_clinic_schedule.setInt(3, 0);
						//pstmt_oa_clinic_schedule.setString( 4, "") ;
						pstmt_oa_clinic_schedule.setString( 4, other_remarks) ; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
						pstmt_oa_clinic_schedule.setString( 5, reason ) ;
						pstmt_oa_clinic_schedule.setString( 6, modifiedById ) ;
						pstmt_oa_clinic_schedule.setString( 7, addedAtWorkstation ) ;
						pstmt_oa_clinic_schedule.setString(8,facilityId);
						pstmt_oa_clinic_schedule.setString(9,facilityId);
						pstmt_oa_clinic_schedule.setString( 10, locn ) ;
						pstmt_oa_clinic_schedule.setString( 11, dat ) ;
						pstmt_oa_clinic_schedule.setString( 12, pract ) ;
						pstmt_oa_clinic_schedule.setString( 13, location_Type ) ;
						pstmt_oa_clinic_schedule.setString( 14, resource_Type ) ;
					}else{
						//pstmt_oa_clinic_schedule.setString( 1, "") ;
						pstmt_oa_clinic_schedule.setString( 1, other_remarks) ; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
						pstmt_oa_clinic_schedule.setString( 2, reason ) ;
						pstmt_oa_clinic_schedule.setString( 3, modifiedById ) ;
						pstmt_oa_clinic_schedule.setString( 4, addedAtWorkstation ) ;
						pstmt_oa_clinic_schedule.setString(5,facilityId);
						pstmt_oa_clinic_schedule.setString(6,facilityId);
						pstmt_oa_clinic_schedule.setString( 7, locn ) ;
						pstmt_oa_clinic_schedule.setString( 8, dat ) ;
						pstmt_oa_clinic_schedule.setString( 9, pract ) ;
						pstmt_oa_clinic_schedule.setString( 10, location_Type ) ;
						pstmt_oa_clinic_schedule.setString( 11, resource_Type ) ;
					}



					res = pstmt_oa_clinic_schedule.executeUpdate() ;
					if(n > s){
						pstmt_oa_trans_record.setString( 1, facilityId ) ;
						rset=pstmt_oa_trans_record.executeQuery();
						if(rset.next())
						sl = rset.getString("max");
						srlno = Integer.parseInt(sl);
						pstmt1.setString(1, facilityId);
						pstmt1.setInt	( 2, srlno ) ;
						pstmt1.setString	( 3, "BC" ) ;
						pstmt1.setString	( 4,fid );
						pstmt1.setString	( 5, dat ) ;
						pstmt1.setString (6,dat);
						pstmt1.setString( 7, locn ) ;
						pstmt1.setString( 8, pract ) ;
						pstmt1.setString( 9, day ) ;
						pstmt1.setString( 10, "" ) ;
						pstmt1.setString( 11, reason) ;
						pstmt1.setString( 12, location_Type ) ;
						pstmt1.setString( 13, resource_Type ) ;
						pstmt1.executeUpdate() ;
					}

					if ( res != 0 )
					{
						sql_operation = true ;
					}else{
						sql_operation = true ;
					}
				}
			}//inner while
		}//outer while
		if(bulk_blocking_yn.equals("Y")){
			if(recordCount==tokenCount){
				sql_operation=true;
			}else{
				sql_operation=false;
			}
		}
		if(sql_operation){
			result=true;
			java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
			sb.append( (String) message.get("message") ) ;
			con.commit();
			//con.rollback() ;
			message.clear();
		}else{
			con.rollback() ;
			sb.append("In schedule Block Transaction failed:" ) ;
		}
		if (rs !=null) rs.close() ;
		if (rs1 !=null) rs1.close() ;
		if (rset !=null) rset.close() ;
		if (pstmt !=null) pstmt.close() ;
		if (pstmt1 !=null) pstmt1.close() ;
		if (pstmt_sql_upd_oa_clinic_schedule_slot_slab!=null)  pstmt_sql_upd_oa_clinic_schedule_slot_slab.close();
		if (pstmt_sql_oa_block_appt!=null)  pstmt_sql_oa_block_appt.close();
		if (pstmt2_sql2_oa_block_appt!=null)  pstmt2_sql2_oa_block_appt.close();
		if (oa_block_appt_dtl!=null)  oa_block_appt_dtl.close();
		if (pstmt_oa_clinic_schedule_dtl!=null)  pstmt_oa_clinic_schedule_dtl.close();
		if (pstmt_oa_clinic_schedule!=null)  pstmt_oa_clinic_schedule.close();
		if (pstmt_oa_trans_record!=null)  pstmt_oa_trans_record.close();
		if (pstmt2_oa_block_appt_dtl!=null)  pstmt2_oa_block_appt_dtl.close();
		if (stmt !=null) stmt.close() ;
		if (updatebolckapptpstmt !=null) updatebolckapptpstmt.close() ;
		passObjects.clear();
	}catch ( Exception e ) {
		e.printStackTrace();
		sb.append("In schedule Block Transaction failed:" + e ) ;
		try {
			con.rollback() ;
		} catch ( Exception ce ) {
			ce.printStackTrace();
		}
	} finally {
		if (con != null)
		{
			ConnectionManager.returnConnection(con,p);
		}
	}
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	sb.setLength(0);
	return results ;
} // method

///////////////////////////////////////////////BlockSch Ends ///////////////////////
/**
* @ejb.interface-method
*	 view-type="both"
*/
public java.util.HashMap LiftSch(java.util.Properties p,
							java.util.HashMap passObjects
						 )
		{

	Connection con =null;// Added for KDAH-SCF-0704
	int n=((Integer) passObjects.get("n1")).intValue();
	int s=((Integer) passObjects.get("s1")).intValue();
	String finalvals=(String) passObjects.get("finalvals1");
	String reason=(String) passObjects.get("reason");
	String reason_desc="";
	String fid=(String) passObjects.get("fid");
	String facilityId=(String) passObjects.get("facilityId");
	String	  addedAtWorkstation=(String) passObjects.get("client_ip_address");
	String location_Type=(String) passObjects.get("location_Type");
	String resource_Type=(String) passObjects.get("resource_Type");
	String start_time=(String) passObjects.get("start_time");
	String end_time=(String) passObjects.get("end_time");
	String blk_schdl_with_appt_yn=(String) passObjects.get("blk_schdl_with_appt_yn");//JD-CRF-0168 changes
	String other_remarks = (String) passObjects.get("other_remarks"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	String locale = p.getProperty("LOCALE");
	PreparedStatement pstmt6=null;//JD-CRF-0168 changes



	java.util.HashMap results = new java.util.HashMap() ;
	boolean result = false ;
	java.sql.Date modified_date =null;
	StringBuffer sb = new StringBuffer( "" ) ;
	try{
		con = ConnectionManager.getConnection(p);
		stmt=con.createStatement();

		String sql_oa_appt = "select appt_ref_no  from oa_appt where facility_id = ? and clinic_code = ? and appt_date = to_date(?,'dd/mm/yyyy') and Nvl(practitioner_id,'X') =Nvl(?,'X') and care_locn_type_ind= ? and resource_class = ? ";
		pstmt = con.prepareStatement( sql_oa_appt ) ;
		String sql_oa_clinic_schedule_slot_slab_01="Update oa_clinic_schedule_slot_slab Set  schedule_status=null Where Facility_id=? and Clinic_code=? and Clinic_date=to_date(?,'dd/mm/yyyy') and resource_class =? and practitioner_id is null and to_date(to_char(SLOT_SLAB_START_TIME,'hh24:mi'),'hh24:mi') >=to_date('"+start_time+"','hh24:mi') and to_date(to_char(SLOT_SLAB_END_TIME,'hh24:mi'),'hh24:mi')  <=to_date('"+end_time+"','hh24:mi') and schedule_status='B'" ;
		String sql_oa_clinic_schedule_slot_slab_02="Update oa_clinic_schedule_slot_slab Set  schedule_status=null Where Facility_id=? and Clinic_code=? and Clinic_date=to_date(?,'dd/mm/yyyy') and resource_class =? and practitioner_id = ? and to_date(to_char(SLOT_SLAB_START_TIME,'hh24:mi'),'hh24:mi') >=to_date('"+start_time+"','hh24:mi') and to_date(to_char(SLOT_SLAB_END_TIME,'hh24:mi'),'hh24:mi')  <=to_date('"+end_time+"','hh24:mi') and schedule_status='B'" ;
		//JD-CRF-0168 changes
		String sql_oa_clinic_schedule="";

		//Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		if(blk_schdl_with_appt_yn.equals("N"))
			sql_oa_clinic_schedule = "  Update oa_clinic_schedule Set  schedule_status=null , remarks ='"+other_remarks+"' , reason_code ='"+reason+"' ,  modified_by_id =? , modified_date = ?, modified_at_ws_no = ?, modified_facility_id = ? ,total_slots_booked=0,  total_first_visits_blocked=0,  total_other_visits_blocked =0 Where Facility_id=? and Clinic_code=?  and Clinic_date=to_date(?,'dd/mm/yyyy') and Nvl(practitioner_id,'X') =Nvl(?,'X' ) and 			care_locn_type_ind= ? and resource_class = ? " ;
		else
		    sql_oa_clinic_schedule = "  Update oa_clinic_schedule Set  schedule_status=null , remarks ='"+other_remarks+"' , reason_code ='"+reason+"' ,  modified_by_id =? , modified_date = ?, modified_at_ws_no = ?, modified_facility_id = ? , total_first_visits_blocked=0,  total_other_visits_blocked =0,total_slots_booked=?  Where Facility_id=? and Clinic_code=?  and Clinic_date=to_date(?,'dd/mm/yyyy') and Nvl(practitioner_id,'X') =Nvl(?,'X' ) and 			care_locn_type_ind= ? and resource_class = ? " ;

		pstmt3 = con.prepareStatement( sql_oa_clinic_schedule );
		String sql_oa_trans_record  = " Select nvl(max(srl_no),0)+1 max from oa_trans_record where facility_id=? ";
		pstmt4=con.prepareStatement(sql_oa_trans_record);
		String sql1_oa_trans_record = " Insert into oa_trans_record (facility_id,srl_no,trans_code,trans_date_time, trans_eff_by_id,  from_date_entered,to_date_entered,  clinic_code,from_practitioner_id,from_day_no,remarks,reason_code,care_locn_type_ind,resource_class) values (?,?,?,sysdate,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?) " ;
		pstmt5 = con.prepareStatement( sql1_oa_trans_record );
		
		//JD-CRF-0168 changes
		String sql_oa_clinic_Schedule_blocked_slots="select total_slots_booked-(nvl(TOTAL_FIRST_VISITS_BLOCKED,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0)) total_slots_booked from oa_clinic_schedule where Facility_id=? and Clinic_code=?  and Clinic_date=to_date(?,'dd/mm/yyyy') and Nvl(practitioner_id,'X') =Nvl(?,'X' ) and 			care_locn_type_ind= ? and resource_class = ?  ";
		pstmt6 = con.prepareStatement(sql_oa_clinic_Schedule_blocked_slots);




		//String del = "delete from oa_block_appt  where facility_id =? and clinic_code=? and block_date=to_date(?,'DD/MM/YYYY') and srl_no=? and CARE_LOCN_TYPE_IND =? and RESOURCE_CLASS =?";
		String del = "delete from oa_block_appt  where facility_id =? and clinic_code=? and block_date=to_date(?,'DD/MM/YYYY') and nvl(practitioner_id,'X')= nvl(?,'X') and CARE_LOCN_TYPE_IND =? and RESOURCE_CLASS =?";

		pstmt8=con.prepareStatement(del);
		//int res_del = pstmt8.executeUpdate() ;





		StringTokenizer st = new StringTokenizer(finalvals,"-");
		mainwhile: while(st.hasMoreTokens())
		{
			str = st.nextToken();
			StringTokenizer st1 = new StringTokenizer(str,"|");
			while(st1.hasMoreTokens())
			{
				locn = st1.nextToken();
				pract = st1.nextToken();
				/*Modified By Dharma on 22nd Jan 2015 against ML-BRU-SCF-1455 [IN:052324] Start*/
				//if(pract =="X" && pract.equals("X")) pract="";
				if(pract =="X" || pract.equals("X")) pract="";
				/*Modified By Dharma on 22nd Jan 2015 against ML-BRU-SCF-1455 [IN:052324] End*/
				dat = st1.nextToken();
				day = st1.nextToken();
				st1.nextToken();
				pstmt.setString( 1, facilityId ) ;
				pstmt.setString( 2, locn ) ;
				pstmt.setString( 3, dat ) ;
				pstmt.setString( 4, pract ) ;
				pstmt.setString( 5, location_Type ) ;
				pstmt.setString( 6, resource_Type ) ;
				rs = pstmt.executeQuery() ;
				String appt_ref_nos="";
				if(rs != null){
					while(rs.next()){
						appt_ref_nos=appt_ref_nos+"'"+rs.getString("appt_ref_no")+"',";
					}
				}

				if(appt_ref_nos.length() > 1){
					appt_ref_nos=appt_ref_nos.substring(0,appt_ref_nos.length()-1);
				}


				String modifiedById = p.getProperty( "login_user" ) ;
				String modifiedDate = dateFormat.format( new java.util.Date() ) ;
				 modified_date = java.sql.Date.valueOf( modifiedDate ) ;
				String modifiedAtWorkstation = addedAtWorkstation ;
				//JD-CRF-0168 changes
				if(blk_schdl_with_appt_yn.equals("N")){

				pstmt3.setString	( 1, modifiedById ) ;
				pstmt3.setDate	( 2, modified_date ) ;
				pstmt3.setString	( 3, modifiedAtWorkstation ) ;
				pstmt3.setString (4,facilityId);
				pstmt3.setString (5,facilityId);
				pstmt3.setString( 6, locn ) ;
				pstmt3.setString( 7, dat ) ;
				pstmt3.setString( 8, pract ) ;
				pstmt3.setString( 9, location_Type ) ;
				pstmt3.setString( 10, resource_Type ) ;
				int res = pstmt3.executeUpdate() ;
				}else{
					String total_blocked_visits="";
					pstmt6.setString(1,facilityId);
					pstmt6.setString(2,locn);
					pstmt6.setString(3,dat);
					pstmt6.setString(4,pract);
					pstmt6.setString(5,location_Type);
					pstmt6.setString(6,resource_Type);
					
					ResultSet rs6=pstmt6.executeQuery();
					while(rs6.next()){
						total_blocked_visits=rs6.getString("total_slots_booked");
					}
					
					pstmt3.setString	( 1, modifiedById ) ;
					pstmt3.setDate	( 2, modified_date ) ;
					pstmt3.setString	( 3, modifiedAtWorkstation ) ;
					pstmt3.setString (4,facilityId);
					pstmt3.setString (5,total_blocked_visits);
					pstmt3.setString (6,facilityId);
					pstmt3.setString( 7, locn ) ;
					pstmt3.setString( 8, dat ) ;
					pstmt3.setString( 9, pract ) ;
					pstmt3.setString( 10, location_Type ) ;
					pstmt3.setString( 11, resource_Type ) ;
					int res = pstmt3.executeUpdate() ;
				}
				if(pract.equals("")){
					pstmt2 = con.prepareStatement( sql_oa_clinic_schedule_slot_slab_01);
				}else{
					pstmt2 = con.prepareStatement( sql_oa_clinic_schedule_slot_slab_02);
				}

					pstmt2.setString( 1, facilityId ) ;
					pstmt2.setString( 2, locn ) ;
					pstmt2.setString( 3, dat ) ;
					pstmt2.setString( 4, resource_Type ) ;
					if(!pract.equals("")){
						pstmt2.setString( 5, pract ) ;
					}
					//pstmt2.setString( 6, appt_ref_nos ) ;
					res = pstmt2.executeUpdate() ;
					if(n > s)
				{
					String sl = "";
					int srlno = 0;
					pstmt4.setString( 1,facilityId);
					rset=pstmt4.executeQuery();
					if(rset.next())
						sl = rset.getString("max");
					srlno = Integer.parseInt(sl);
					pstmt5.setString(1, facilityId);
					pstmt5.setInt	( 2, srlno ) ;
					pstmt5.setString	( 3, "BL" ) ;
					pstmt5.setString	( 4,fid );
					pstmt5.setString	( 5, dat ) ;
					pstmt5.setString (6,dat);
					pstmt5.setString(7, locn ) ;
					pstmt5.setString( 8, pract ) ;
					pstmt5.setString( 9, day ) ;
					pstmt5.setString( 10, reason_desc) ;
					pstmt5.setString( 11, reason) ;
					pstmt5.setString( 12, location_Type ) ;
					pstmt5.setString( 13, resource_Type ) ;
					pstmt5.executeUpdate() ;
				}


				/*String get_slno="select srl_no from oa_block_appt  where facility_id ='"+facilityId+"' and clinic_code='"+locn+"' and block_date=to_date('"+dat+"','DD/MM/YYYY')";

				rs_sl=stmt.executeQuery(get_slno);
				if(rs_sl !=null){
				while (rs_sl.next())
				{
					srl_no1 = rs_sl.getString("srl_no");
					if(srl_no1 ==null) srl_no1="";
				}
				}*/


				if (rs_sl !=null) rs_sl.close() ;
				pstmt8.setString( 1, facilityId ) ;
				pstmt8.setString( 2, locn ) ;
				pstmt8.setString( 3, dat ) ;
				//pstmt8.setString( 4, srl_no1 ) ;
				pstmt8.setString( 4, pract ) ;
				pstmt8.setString( 5, location_Type ) ;
				pstmt8.setString( 6, resource_Type ) ;
				pstmt8.executeUpdate() ;



				if ( res != 0 )
				{
					sql_operation = true ;
				}else{
					sql_operation = true ;
				}
			}//inner while
		}//outer while
		if(sql_operation){
			result=true;
			java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
			sb.append( (String) message.get("message") ) ;
			con.commit();
			message.clear();
		}else{
			con.rollback() ;
			}
		if (rs !=null) rs.close() ;
		if (rs1 !=null) rs1.close() ;
		if (rset !=null) rset.close() ;
		if (pstmt !=null) pstmt.close() ;
		if (pstmt2 !=null) pstmt2.close() ;
		if (pstmt3 !=null) pstmt3.close() ;
		if (pstmt4 !=null) pstmt4.close() ;
		if (pstmt1 !=null) pstmt1.close() ;
		if (pstmt5 !=null) pstmt5.close() ;
		if (stmt !=null) stmt.close() ;
		if (pstmt8 !=null) pstmt8.close() ;
		if (pstmt6 !=null) pstmt6.close() ;// Added for KDAH-SCF-0704
		passObjects.clear();
	}catch ( Exception e ) {
		e.printStackTrace();
		try {
			con.rollback() ;
		}catch ( Exception ce ) {
			ce.printStackTrace();
		}
		e.printStackTrace() ;
	}finally {
		  if (con != null)
		 {
			ConnectionManager.returnConnection(con,p);
		}
	}
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	return results ;
}
///////////////////////////////////////////////Lifting Sch Ends Here//////////////////////
/**
* @ejb.interface-method
*	 view-type="both"
*/
public java.util.HashMap CancelSch(
							java.util.Properties p,
						java.util.HashMap passObjects
						 )
		{

	Connection con =null;// Added for KDAH-SCF-0704
	int n=((Integer) passObjects.get("n1")).intValue();
	int s=((Integer) passObjects.get("s1")).intValue();
	String finalvals=(String) passObjects.get("finalvals1");
	String reason=(String) passObjects.get("reason");
	String fid=(String) passObjects.get("fid");
	String facilityId=(String) passObjects.get("facilityId");
	String	  addedAtWorkstation=(String) passObjects.get("client_ip_address");
	String location_Type=(String) passObjects.get("location_Type");
	String resource_Type=(String) passObjects.get("resource_Type");
	String other_remarks = (String) passObjects.get("other_remarks"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	String locale = p.getProperty("LOCALE");
	String service_code="";
	java.util.HashMap results = new java.util.HashMap() ;
	boolean result = false ;
	Statement a_stmt=null,b_stmt=null;
	PreparedStatement a_pstmt=null,b_pstmt=null,c_pstmt=null,d_pstmt=null,e_pstmt=null,f_pstmt=null,g_pstmt=null,h_pstmt=null,i_pstmt=null,j_pstmt=null,k_pstmt=null,l_pstmt=null,m_pstmt=null,r_pstmt=null,op_pstmt=null;
	ResultSet a_rs=null,b_rs=null,c_rs=null,rSsrl=null,rs_srl=null,op_rs=null;
	String facility="",apptrefno="",cliniccode="",practitionerid="",apptdate="",appttime="",apptslabfromtime="",apptslabtotime="",apptduration="",apptslots="",patientid="",nameprefix="",firstname="",secondname="",thirdname="",familyname="",namesuffix="",patientname="",gender="",dateofbirth="",restelno="",othcontactno="",emailid="",nationalidno="",altid1no="",resaddrline1="",resaddrline2="",resaddrline3="",resaddrline4="",postalcode="",countrycode="",appttypecode="",overbookedyn="",referralId="",contactreasoncode="",modeofcontact="",apptremarks="",inpatientyn="",encounterid="",primary_yn="",speciality_code="";
	String name_prefix_loc_lang ="";
	String	first_name_loc_lang="";
	String	second_name_loc_lang="";
	String	third_name_loc_lang="";
	String	name_suffix_loc_lang="";
	String	family_name_loc_lang="";
	String	patient_name_loc_lang="";
	String  sec_res_id="";
	String  appt_ref_no="";
	String  trans_exceed_reason_code="";
	/*Added by Thamizh selvi on 23rd May 2017 for ML-MMOH-CRF-0610 Start*/
	String  appt_added_by_id="";
	String  appt_added_date="";
	/*End*/
	int res5 =0;
	StringBuffer sb = new StringBuffer( "" ) ;
	try{
		con = ConnectionManager.getConnection(p);
				stmt=con.createStatement();
		String addedDate = dateFormat.format( new java.util.Date() ) ;
		String modifiedById = p.getProperty( "login_user" ) ;
		String modifiedDate = dateFormat.format( new java.util.Date() ) ;
		java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;
		String modifiedAtWorkstation = addedAtWorkstation ;
		java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
		String sql_oa_appt_vw = "  select appt_ref_no,VISIT_TYPE_IND  from oa_appt,op_visit_type where oa_appt.facility_id = ? and clinic_code = ? and appt_date = to_date(?,'dd/mm/yyyy') and Nvl(practitioner_id,'X') =Nvl(?,'X') and care_locn_type_ind= ? and resource_class = ? and oa_appt.APPT_TYPE_CODE=op_visit_type.VISIT_TYPE_CODE and oa_appt.FACILITY_ID=op_visit_type.FACILITY_ID";
		a_pstmt = con.prepareStatement( sql_oa_appt_vw ) ;

		String SqlSt_oa_resource_for_appt ="select facility_id,appt_ref_no,resource_class,resource_id,resource_type,to_char(appt_date,'dd/mm/yyyy') appt_date ,to_char(appt_time,'dd/mm/yyyy HH24:mi') appt_time,to_char(appt_slab_from_time,'dd/mm/yyyy HH24:mi') appt_slab_from_time,to_char(appt_slab_to_time,'dd/mm/yyyy HH24:mi') appt_slab_to_time,to_char(appt_duration,'dd/mm/yyyy HH24:mi') appt_duration,appt_slots,booking_type from oa_resource_for_appt where facility_id=? and appt_ref_no =? ";
		b_pstmt=con.prepareStatement(SqlSt_oa_resource_for_appt);

		String SqlUp_oa_clinic_schedule="update oa_clinic_schedule set  total_slots_booked  = nvl(total_slots_booked,0)-"+1+",total_first_visit=nvl(total_first_visit,0)-decode(?,'F',"+1+",0), TOTAL_FIRST_VISIT_SLOTS_BOOKED=nvl(TOTAL_FIRST_VISIT_SLOTS_BOOKED,0)-decode(?,'F',"+1+",0),total_follow_up=nvl(total_follow_up,0)-decode(?,'L',"+1+",0),total_routine=nvl(total_routine,0)-decode(?,'R',"+1+",0),total_series=nvl(total_series,0)-decode('"+1+"','S',"+1+",0),total_consult=nvl(total_consult,0)-decode(?,'C',"+1+",0),total_emergency=nvl(total_emergency,0)-decode(?,'E',"+1+",0) where facility_id = ? and clinic_code=?  and clinic_date= to_date(?,'DD/MM/YYYY') and nvl(practitioner_id,'X')=nvl(?,'X') and care_locn_type_ind=? and resource_class=? and primary_resource_yn=? ";
		c_pstmt= con.prepareStatement(SqlUp_oa_clinic_schedule);

		String SQl_oa_resource_for_appt_del_tr = "select nvl(max(srl_no),0)+1 maxno from oa_resource_for_appt_del_tr where facility_id=? and appt_ref_no = ?";
		d_pstmt = con.prepareStatement( SQl_oa_resource_for_appt_del_tr );

		String sql_oa_resource_for_appt_del_tr ="insert into oa_resource_for_appt_del_tr (facility_id,appt_ref_no,srl_no,resource_class,resource_id,resource_type,appt_date,appt_time,appt_slab_from_time,appt_slab_to_time,appt_duration,appt_slots,booking_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values (?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),?,?, ?, sysdate, ?, ?, ?, sysdate,?,?)";
		e_pstmt = con.prepareStatement( sql_oa_resource_for_appt_del_tr );

		String sqldel_oa_resource_for_appt="delete from oa_resource_for_appt where facility_id=? and appt_ref_no=?";
		f_pstmt = con.prepareStatement(sqldel_oa_resource_for_appt);


		String sql_oa_appt =  " select facility_id, appt_ref_no, clinic_code, practitioner_id, to_char(appt_date,'dd/mm/yyyy') appt_date,  to_char(appt_time,'dd/mm/yyyy HH24:MI') appt_time,  to_char(appt_slab_from_time,'dd/mm/yyyy hh24:mi') appt_slab_from_time,to_char(appt_slab_to_time,'dd/mm/yyyy hh24:mi') appt_slab_to_time,  to_char(appt_duration,'dd/mm/yyyy hh24:mi') appt_duration, appt_slots, patient_id,name_prefix, first_name, second_name,third_name,family_name, name_suffix, patient_name, gender,to_char(date_of_birth,'dd/mm/yyyy') date_of_birth, res_tel_no,oth_contact_no, email_id,national_id_no, alt_id1_no, res_addr_line1, res_addr_line2,res_addr_line3,res_addr_line4, postal_code,country_code, appt_type_code, overbooked_yn,referral_id, contact_reason_code, mode_of_contact, appt_remarks, appt_status, inpatient_yn,  encounter_id,ETHNIC_GROUP_CODE,FORCED_APPT_YN,CITIZEN_YN,LEGAL_YN,BIRTH_PLACE_CODE,RACE_CODE,GLOBAL_APPT_YN,RES_AREA_CODE,RES_TOWN_CODE,RES_REGION_CODE,RES_COUNTRY_CODE,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_AREA_CODE,MAIL_TOWN_CODE,MAIL_REGION_CODE,MAIL_POSTAL_CODE,MAIL_COUNTRY_CODE,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,SERVICE_CODE,trans_exceed_reason_code,added_by_id,to_char (added_date,'dd/mm/yyyy hh24:mi:ss') added_date  from oa_appt where facility_id = ? and clinic_code = ? and nvl(practitioner_id,'X') =nvl(?,'X')and appt_date=to_date(?,'dd/mm/yyyy')and care_locn_type_ind= ? and resource_class = ? ";//Modified by Thamizh selvi on 23rd May 2017 for ML-MMOH-CRF-0610 --added_by_id & added_date
		g_pstmt = con.prepareStatement( sql_oa_appt ) ;

		final String sql2_max_srl_no ="select nvl(max(srlno),0)+1 maxno from oa_appt_del_tr where facility_id=? and appt_ref_no=?";
		h_pstmt =con.prepareStatement(sql2_max_srl_no);

		String sql_op_clinic  = "select speciality_code from op_clinic where  facility_id= '"+facilityId+"' and clinic_code=?";
		op_pstmt = con.prepareStatement(sql_op_clinic) ;

		String sqlins_oa_appt_del_tr = " insert into oa_appt_del_tr( facility_id,appt_ref_no ,srlno,clinic_code ,practitioner_id ,appt_date ,appt_tr_date,appt_time ,appt_slab_from_time ,appt_slab_to_time,appt_duration,appt_slots ,patient_id  ,name_prefix,first_name  ,second_name,third_name,family_name,name_suffix ,patient_name ,gender ,date_of_birth ,res_tel_no,oth_contact_no ,email_id ,national_id_no  ,alt_id1_no,res_addr_line1 ,res_addr_line2 ,res_addr_line3,res_addr_line4 ,postal_code   ,country_code,appt_type_code,overbooked_yn,referral_id,contact_reason_code,mode_of_contact   ,appt_remarks,appt_status,inpatient_yn,encounter_id  ,added_by_id ,added_date,added_at_ws_no,added_facility_id ,modified_by_id,modified_date,modified_at_ws_no   ,modified_facility_id,ETHNIC_GROUP_CODE,FORCED_APPT_YN,CITIZEN_YN,LEGAL_YN,BIRTH_PLACE_CODE,RACE_CODE,GLOBAL_APPT_YN,RES_AREA_CODE,RES_TOWN_CODE,RES_REGION_CODE,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_AREA_CODE,MAIL_TOWN_CODE,MAIL_REGION_CODE,MAIL_POSTAL_CODE,MAIL_COUNTRY_CODE,RES_COUNTRY_CODE,care_locn_type_ind,resource_class,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,SPECIALITY_CODE,SERVICE_CODE,trans_exceed_reason_code,appt_booked_by_id,appt_booked_date,cancel_schedule_remarks) values(?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),to_number(?),?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_number(?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?)";//Modified by Thamizh selvi on 23rd May 2017 for ML-MMOH-CRF-0610 --appt_booked_by_id,appt_booked_date //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		i_pstmt = con.prepareStatement( sqlins_oa_appt_del_tr ) ;


		String sqlsel_oa_appt = "select APPT_REF_NO  from oa_appt where facility_id = ? and clinic_code =? and nvl(practitioner_id,'X') =nvl(?,'X') and appt_date = to_date(?,'dd/mm/yyyy') and care_locn_type_ind= ? and resource_class =?  ";
		r_pstmt = con.prepareStatement(sqlsel_oa_appt);

		String sqldel_oa_resource_for_appt1 = "delete from oa_resource_for_appt where facility_id = ? and APPT_REF_NO =? ";
		k_pstmt= con.prepareStatement( sqldel_oa_resource_for_appt1) ;

		String sqldel_oa_clinic_schedule_slot_slab = "Update oa_clinic_schedule_slot_slab set PRI_APPT_REF_NO ='',SCHEDULE_STATUS='' where facility_id = ?  and PRI_APPT_REF_NO = ? " ;
		l_pstmt = con.prepareStatement( sqldel_oa_clinic_schedule_slot_slab) ;

		String sql2_oa_appt = " delete from oa_appt where facility_id = ?  and clinic_code = ? and nvl(practitioner_id,'X') =nvl(?,'X') and appt_date =to_date(?,'dd/mm/yyyy') and care_locn_type_ind= ? and resource_class = ? " ;
		pstmt2 = con.prepareStatement(sql2_oa_appt) ;

		String sqldel_oa_clinic_slot_slab = "delete from OA_CLINIC_SCHEDULE_SLOT_SLAB where facility_id = ?and clinic_code = ? and nvl(practitioner_id,'X') =nvl(?,'X') and clinic_date = to_date(?,'dd/mm/yyyy') ";
		pstmt7  =con.prepareStatement(sqldel_oa_clinic_slot_slab);


		String sql3_del_oa_clinic_schedule = " delete from oa_clinic_schedule where facility_id = ? and clinic_code = ? and nvl(practitioner_id,'X') =nvl(?,'X') and clinic_date = to_date(?,'dd/mm/yyyy')" ;
		pstmt3 = con.prepareStatement( sql3_del_oa_clinic_schedule) ;

		/*String sqldel_oa_clinic_schedule_dtl = " delete from oa_clinic_schedule_dtl where facility_id = ?  and clinic_code = ? and nvl(practitioner_id,'X') =nvl(?,'X') and clinic_date = to_date(?,'dd/mm/yyyy') and care_locn_type_ind= ? and resource_class = ? " ;
		m_pstmt = con.prepareStatement( sqldel_oa_clinic_schedule_dtl) ;*/

		String sqldel_oa_clinic_schedule_break = " delete from oa_clinic_schedule_break where facility_id = ? and clinic_code = ? and nvl(practitioner_id,'X') =nvl(?,'X') and clinic_date =to_date(?,'dd/mm/yyyy')  " ;
		pstmt4 = con.prepareStatement( sqldel_oa_clinic_schedule_break) ;

		String sql_del_oa_block_appt = " delete from oa_block_appt where facility_id = ? and clinic_code = ?  and nvl(practitioner_id,'X') =nvl(?,'X') and block_date =to_date(?,'dd/mm/yyyy')  " ;
		pstmt5 = con.prepareStatement( sql_del_oa_block_appt) ;


		String sql_oa_trans_record  = " Select nvl(max(srl_no),0)+1 max from oa_trans_record where facility_id=? ";
		pstmt9 = con.prepareStatement(sql_oa_trans_record);




		String sql_ins_oa_trans_record = " Insert into oa_trans_record (facility_id,srl_no,trans_code,trans_date_time, trans_eff_by_id,  from_date_entered,to_date_entered,  clinic_code,from_practitioner_id,from_day_no,remarks,reason_code,care_locn_type_ind,resource_class)  values (?,?,?,sysdate,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?) " ;
		j_pstmt = con.prepareStatement( sql_ins_oa_trans_record );





		StringTokenizer st = new StringTokenizer(finalvals,"-");
		mainwhile: while(st.hasMoreTokens())
		{
			str = st.nextToken();
			StringTokenizer st1 = new StringTokenizer(str,"|");
			while(st1.hasMoreTokens())
			{
				locn = st1.nextToken();
				pract = st1.nextToken();
	
				/*Modified By Dharma on 22nd Jan 2015 against ML-BRU-SCF-1455 [IN:052324] Start*/
				//if(pract =="X" && pract.equals("X")) pract="";
				if(pract =="X" || pract.equals("X")) pract="";
				/*Modified By Dharma on 22nd Jan 2015 against ML-BRU-SCF-1455 [IN:052324] End*/
				dat = st1.nextToken();
				day = st1.nextToken();
				primary_yn= st1.nextToken();
				if(primary_yn.equals("Y")){
					a_pstmt.setString( 1, facilityId ) ;
					a_pstmt.setString( 2, locn ) ;
					a_pstmt.setString( 3, dat ) ;
					a_pstmt.setString( 4, pract ) ;
					a_pstmt.setString( 5, location_Type ) ;
					a_pstmt.setString( 6, resource_Type ) ;
					a_rs = a_pstmt.executeQuery() ;

					String appt_ref_nos="";
					String visitind="";
					if(a_rs != null){
						while(a_rs.next()){
							appt_ref_nos=a_rs.getString("appt_ref_no");
							visitind=a_rs.getString("VISIT_TYPE_IND");
							if(appt_ref_nos==null) appt_ref_nos="";
							if(visitind==null) visitind="";
							if(! appt_ref_nos.equals("")){
								b_pstmt.setString( 1, facilityId ) ;
								b_pstmt.setString( 2, appt_ref_nos ) ;
								b_rs=b_pstmt.executeQuery();
								if(b_rs != null ) {
									int srl_no = 0;
									while (b_rs.next()) {
										String sec_facility_id1=b_rs.getString("facility_id");
										String sec_resource_class1=b_rs.getString("resource_class");
										String sec_resource_id1=b_rs.getString("resource_id");
										if(sec_resource_id1==null) sec_resource_id1="";
										String sec_resource_type1=b_rs.getString("resource_type");
										if(sec_resource_type1==null) sec_resource_type1="";
										String sec_appt_date1=b_rs.getString("appt_date");
										String sec_appt_time1=b_rs.getString("appt_time");
										String sec_appt_slab_from_time1=b_rs.getString("appt_slab_from_time");
										String sec_appt_slab_to_time1=b_rs.getString("appt_slab_to_time");
										String sec_appt_duration1=b_rs.getString("appt_duration");
										String sec_appt_slots1=b_rs.getString("appt_slots");
										String sec_booking_type1=b_rs.getString("booking_type");
										if(sec_appt_slots1==null) sec_appt_slots1="";
										c_pstmt.setString( 1, visitind ) ;
										c_pstmt.setString( 2, visitind ) ;
										c_pstmt.setString( 3, visitind ) ;
										c_pstmt.setString( 4, visitind ) ;
										c_pstmt.setString( 5, visitind ) ;
										c_pstmt.setString( 6, visitind ) ;
										c_pstmt.setString( 7, facilityId ) ;
										c_pstmt.setString( 8, locn ) ;
										c_pstmt.setString( 9, sec_appt_date1 ) ;
										c_pstmt.setString( 10, sec_resource_id1 ) ;
										c_pstmt.setString( 11, location_Type ) ;
										c_pstmt.setString( 12, sec_resource_class1 ) ;
										c_pstmt.setString( 13, "N" ) ;
										c_pstmt.executeUpdate();
										srl_no = 0;
										//ResultSet rSsrl=null;
										d_pstmt.setString	( 1, facilityId ) ;
										d_pstmt.setString	( 2, appt_ref_nos ) ;
										rSsrl = d_pstmt.executeQuery();
										if(rSsrl!=null&&rSsrl.next()){
										 srl_no = rSsrl.getInt("maxno");
										}
										if (rSsrl!=null) rSsrl.close();
										e_pstmt.setString( 1, sec_facility_id1 ) ;
										e_pstmt.setString( 2, appt_ref_nos ) ;
										e_pstmt.setInt( 3, srl_no ) ;
										e_pstmt.setString( 4, sec_resource_class1 ) ;
										e_pstmt.setString( 5, sec_resource_id1 ) ;
										e_pstmt.setString( 6, sec_resource_type1 ) ;
										e_pstmt.setString( 7, sec_appt_date1 ) ;
										e_pstmt.setString( 8, sec_appt_time1 ) ;
										e_pstmt.setString( 9, sec_appt_slab_from_time1 ) ;
										e_pstmt.setString( 10, sec_appt_slab_to_time1 ) ;
										e_pstmt.setString( 11, sec_appt_duration1 ) ;
										e_pstmt.setString( 12, sec_appt_slots1 ) ;
										e_pstmt.setString( 13, sec_booking_type1) ;
										e_pstmt.setString( 14, modifiedById ) ;
										e_pstmt.setString( 15, addedAtWorkstation ) ;
										e_pstmt.setString( 16, facilityId ) ;
										e_pstmt.setString( 17, modifiedById) ;
										e_pstmt.setString( 18, addedAtWorkstation ) ;
										e_pstmt.setString( 19, facilityId ) ;
										e_pstmt.executeUpdate() ;
									} // while
								} // if null

							} // null appt ref no
						} // loop appt ref
					}/// null apptref rs
				}// // if primary
				g_pstmt.setString( 1, facilityId ) ;
				g_pstmt.setString( 2, locn ) ;
				g_pstmt.setString( 3, pract ) ;
				g_pstmt.setString( 4, dat ) ;
				g_pstmt.setString( 5, location_Type ) ;
				g_pstmt.setString( 6, resource_Type ) ;
				c_rs = g_pstmt.executeQuery() ;

				if(c_rs != null){
					while(c_rs.next()){

						facility = c_rs.getString("facility_id");
						apptrefno = c_rs.getString("appt_ref_no");
						cliniccode = c_rs.getString("clinic_code");
						practitionerid = c_rs.getString("practitioner_id");
					if(practitionerid == null || practitionerid.equals("")) practitionerid = "";
						apptdate = c_rs.getString("appt_date");
						appttime = c_rs.getString("appt_time");
					if(appttime == null || appttime.equals("")) appttime = "";

						apptslabfromtime = c_rs.getString("appt_slab_from_time");
					if(apptslabfromtime == null || apptslabfromtime.equals("")) apptslabfromtime = "";
							apptslabtotime = c_rs.getString("appt_slab_to_time");
					if(apptslabtotime == null || apptslabtotime.equals("")) apptslabtotime = "";
						apptduration = c_rs.getString("appt_duration");
					if(apptduration == null || apptduration.equals("")) apptduration = "";
						apptslots = c_rs.getString("appt_slots");
					if(apptslots == null || apptslots.equals("")) apptslots = "";
					patientid = c_rs.getString("patient_id");
						if(patientid == null || patientid.equals(""))
										patientid = "";
						nameprefix = c_rs.getString("name_prefix");
						if(nameprefix == null || nameprefix.equals(""))
										nameprefix = "";

						firstname = c_rs.getString("first_name");
						if(firstname == null || firstname.equals(""))
										firstname = "";

						secondname = c_rs.getString("second_name");
						if(secondname == null || secondname.equals(""))
										secondname = "";

						thirdname = c_rs.getString("third_name");
						if(thirdname == null || thirdname.equals(""))
										thirdname = "";

						familyname = c_rs.getString("family_name");
						if(familyname == null || familyname.equals(""))
										familyname = "";

						namesuffix = c_rs.getString("name_suffix");
						if(namesuffix == null || namesuffix.equals(""))
										namesuffix = "";

						patientname = c_rs.getString("patient_name");
						gender = c_rs.getString("gender");
						dateofbirth = c_rs.getString("date_of_birth");
						if(dateofbirth == null || dateofbirth.equals(""))
													dateofbirth = "";

						restelno = c_rs.getString("res_tel_no");
						if(restelno == null || restelno.equals(""))
													restelno = "";

						othcontactno = c_rs.getString("oth_contact_no");
						if(othcontactno == null || othcontactno.equals(""))
													othcontactno = "";

						emailid = c_rs.getString("email_id");
						if(emailid == null || emailid.equals(""))
													emailid = "";

						nationalidno = c_rs.getString("national_id_no");
						if(nationalidno == null || nationalidno.equals(""))
													nationalidno = "";

						altid1no = c_rs.getString("alt_id1_no");
						if(altid1no == null || altid1no.equals(""))
													altid1no = "";

						resaddrline1 = c_rs.getString("res_addr_line1");
						if(resaddrline1 == null || resaddrline1.equals(""))
													resaddrline1 = "";

						resaddrline2 = c_rs.getString("res_addr_line2");
						if(resaddrline2 == null || resaddrline2.equals(""))
													resaddrline2 = "";

						resaddrline3 = c_rs.getString("res_addr_line3");
						if(resaddrline3 == null || resaddrline3.equals(""))
													resaddrline3 = "";

						resaddrline4 = c_rs.getString("res_addr_line4");
						if(resaddrline4 == null || resaddrline4.equals(""))
													resaddrline4 = "";

						postalcode = c_rs.getString("postal_code");
						if(postalcode == null || postalcode.equals(""))
													postalcode = "";

						countrycode = c_rs.getString("country_code");
						if(countrycode == null || countrycode.equals(""))
													countrycode = "";

						appttypecode = c_rs.getString("appt_type_code");
						overbookedyn= c_rs.getString("overbooked_yn");

						referralId= c_rs.getString("referral_id");
						if(referralId == null || referralId.equals(""))
																referralId = "";

						contactreasoncode = c_rs.getString("contact_reason_code");
						modeofcontact = c_rs.getString("mode_of_contact");
						if(modeofcontact == null || modeofcontact.equals(""))
																modeofcontact = "";

						apptremarks = c_rs.getString("appt_remarks");
						if(apptremarks == null || apptremarks.equals(""))
																apptremarks = "";

						inpatientyn = c_rs.getString("inpatient_yn");
						encounterid = c_rs.getString("encounter_id");
						if(encounterid == null || encounterid.equals(""))
																encounterid = "";

									ethnic_grp_cd=c_rs.getString("ETHNIC_GROUP_CODE");
							if(ethnic_grp_cd==null) ethnic_grp_cd="";
						ethnic_subgrp_cd=c_rs.getString("RACE_CODE");
							if(ethnic_subgrp_cd==null) ethnic_subgrp_cd="";
						citizen_yn=c_rs.getString("CITIZEN_YN");
							if(citizen_yn==null) citizen_yn="N";
						legal_yn=c_rs.getString("LEGAL_YN");
							if(legal_yn==null) legal_yn="N";
						birth_place_code=c_rs.getString("BIRTH_PLACE_CODE");
							if(birth_place_code==null) birth_place_code="";

						forced_appt_yn=c_rs.getString("FORCED_APPT_YN");
							if(forced_appt_yn==null) forced_appt_yn="N";
						global_appt_yn=c_rs.getString("GLOBAL_APPT_YN");
							if(global_appt_yn==null) global_appt_yn="N";

						res_town=c_rs.getString("RES_TOWN_CODE");
						if(res_town==null) res_town="";
						res_area=c_rs.getString("RES_AREA_CODE");
						if(res_area==null) res_area="";
						res_region=c_rs.getString("RES_REGION_CODE");
						if(res_region==null) res_region="";
						res_country=c_rs.getString("RES_COUNTRY_CODE");
						if(res_country==null) res_country="";
						mail_addr1=c_rs.getString("MAIL_ADDR_LINE1");
						if(mail_addr1==null) mail_addr1="";
						mail_addr2=c_rs.getString("MAIL_ADDR_LINE2");
						if(mail_addr2==null) mail_addr2="";
						mail_addr3=c_rs.getString("MAIL_ADDR_LINE3");
						if(mail_addr3==null) mail_addr3="";
						mail_addr4=c_rs.getString("MAIL_ADDR_LINE4");
						if(mail_addr4==null) mail_addr4="";
						mail_town=c_rs.getString("MAIL_TOWN_CODE");
						if(mail_town==null) mail_town="";
						mail_area=c_rs.getString("MAIL_AREA_CODE");
						if(mail_area==null) mail_area="";
						mail_postal=c_rs.getString("MAIL_POSTAL_CODE");
						if(mail_postal==null) mail_postal="";
						mail_region=c_rs.getString("MAIL_REGION_CODE");
						if(mail_region==null) mail_region="";
						mail_country=c_rs.getString("MAIL_COUNTRY_CODE");
						if(mail_country==null) mail_country="";
						service_code=c_rs.getString("SERVICE_CODE");
						if(service_code==null) service_code="";
						name_prefix_loc_lang=c_rs.getString("NAME_PREFIX_LOC_LANG")==null?"":c_rs.getString("NAME_PREFIX_LOC_LANG");


						first_name_loc_lang=c_rs.getString("FIRST_NAME_LOC_LANG")==null?"":c_rs.getString("FIRST_NAME_LOC_LANG");


						second_name_loc_lang=c_rs.getString("SECOND_NAME_LOC_LANG")==null?"":c_rs.getString("SECOND_NAME_LOC_LANG");


						third_name_loc_lang=c_rs.getString("THIRD_NAME_LOC_LANG")==null?"":c_rs.getString("THIRD_NAME_LOC_LANG");


						name_suffix_loc_lang=c_rs.getString("NAME_SUFFIX_LOC_LANG")==null?"":c_rs.getString("NAME_SUFFIX_LOC_LANG");
						family_name_loc_lang=c_rs.getString("FAMILY_NAME_LOC_LANG")==null?"":c_rs.getString("FAMILY_NAME_LOC_LANG");
						patient_name_loc_lang=c_rs.getString("PATIENT_NAME_LOC_LANG")==null?"":c_rs.getString("PATIENT_NAME_LOC_LANG");
						trans_exceed_reason_code=c_rs.getString("trans_exceed_reason_code")==null?"":c_rs.getString("trans_exceed_reason_code");
						/*Added by Thamizh selvi on 23rd May 2017 for ML-MMOH-CRF-0610 Start*/
						appt_added_by_id=c_rs.getString("added_by_id")==null?"":c_rs.getString("added_by_id");
						appt_added_date=c_rs.getString("added_date")==null?"":c_rs.getString("added_date");
						/*End*/
						int srl_no = 0;
						h_pstmt.setString(1, facility) ;
						h_pstmt.setString(2, apptrefno);
						rs_srl=h_pstmt.executeQuery();
						if (rs_srl.next() && rs_srl != null ) {
						srl_no=rs_srl.getInt("maxno");
						}

						op_pstmt.setString( 1, cliniccode  ) ;
						op_rs   = op_pstmt.executeQuery();
						if(op_rs!=null && op_rs.next())
						{
						speciality_code=op_rs.getString("speciality_code");
						if(speciality_code ==null) speciality_code="";
						}

						i_pstmt.setString( 1, facility ) ;
						i_pstmt.setString( 2, apptrefno  ) ;
						i_pstmt.setInt( 3, srl_no  ) ;
						i_pstmt.setString( 4, cliniccode  ) ;
						i_pstmt.setString( 5, practitionerid  ) ;
						i_pstmt.setString( 6, apptdate  ) ;
						i_pstmt.setString( 7, ""  ) ;
						i_pstmt.setString( 8, appttime  ) ;
						i_pstmt.setString( 9, apptslabfromtime  ) ;
						i_pstmt.setString( 10, apptslabtotime  ) ;
						i_pstmt.setString( 11, apptduration  ) ;
						i_pstmt.setString( 12, apptslots  ) ;
						i_pstmt.setString( 13, patientid  ) ;
						i_pstmt.setString( 14, nameprefix  ) ;
						i_pstmt.setString( 15, firstname  ) ;
						i_pstmt.setString( 16, secondname  ) ;
						i_pstmt.setString( 17, thirdname  ) ;
						i_pstmt.setString( 18, familyname  ) ;
						i_pstmt.setString( 19, namesuffix  ) ;
						i_pstmt.setString( 20, patientname  ) ;
						i_pstmt.setString( 21, gender  ) ;
						i_pstmt.setString( 22, dateofbirth  ) ;
						i_pstmt.setString( 23, restelno  ) ;
						i_pstmt.setString( 24, othcontactno  ) ;
						i_pstmt.setString( 25, emailid  ) ;
						i_pstmt.setString( 26, nationalidno  ) ;
						i_pstmt.setString( 27, altid1no  ) ;
						i_pstmt.setString( 28, resaddrline1  ) ;
						i_pstmt.setString( 29, resaddrline2  ) ;
						i_pstmt.setString( 30, resaddrline3  ) ;
						i_pstmt.setString( 31, resaddrline4  ) ;
						i_pstmt.setString( 32, postalcode  ) ;
						i_pstmt.setString( 33, countrycode  ) ;
						i_pstmt.setString( 34, appttypecode  ) ;
						i_pstmt.setString( 35, overbookedyn  ) ;
						i_pstmt.setString( 36, referralId  ) ;
						i_pstmt.setString( 37, contactreasoncode  ) ;
						i_pstmt.setString( 38, modeofcontact  ) ;
						i_pstmt.setString( 39, apptremarks  ) ;
						i_pstmt.setString( 40, "S" ) ;
						i_pstmt.setString( 41, inpatientyn  ) ;
						i_pstmt.setString( 42, encounterid ) ;
						i_pstmt.setString( 43, modifiedById ) ;
						i_pstmt.setDate( 44, added_date ) ;
						i_pstmt.setString( 45, addedAtWorkstation ) ;
						i_pstmt.setString( 46, facilityId ) ;
						i_pstmt.setString( 47, modifiedById ) ;
						i_pstmt.setDate( 48,  modified_date) ;
						i_pstmt.setString( 49, modifiedAtWorkstation ) ;
						i_pstmt.setString( 50, facilityId ) ;
						i_pstmt.setString	( 51, ethnic_grp_cd ) ;
						i_pstmt.setString	( 52, forced_appt_yn ) ;
						i_pstmt.setString	( 53, citizen_yn ) ;
						i_pstmt.setString	( 54, legal_yn ) ;
						i_pstmt.setString	( 55, birth_place_code ) ;
						i_pstmt.setString	( 56, ethnic_subgrp_cd ) ;
						i_pstmt.setString	( 57, global_appt_yn ) ;
						i_pstmt.setString	( 58, res_area ) ;
						i_pstmt.setString	( 59, res_town ) ;
						i_pstmt.setString	( 60, res_region ) ;
						i_pstmt.setString	( 61, mail_addr1 ) ;
						i_pstmt.setString	( 62, mail_addr2 ) ;
						i_pstmt.setString	( 63, mail_addr3 ) ;
						i_pstmt.setString	( 64, mail_addr4 ) ;
						i_pstmt.setString	( 65, mail_area ) ;
						i_pstmt.setString	( 66, mail_town ) ;
						i_pstmt.setString	( 67, mail_region ) ;
						i_pstmt.setString	( 68, mail_postal ) ;
						i_pstmt.setString	( 69, mail_country ) ;
						i_pstmt.setString	( 70, res_country ) ;
						i_pstmt.setString	( 71, location_Type ) ;
						i_pstmt.setString	( 72, resource_Type ) ;
						i_pstmt.setString	( 73, name_prefix_loc_lang ) ;
						i_pstmt.setString	( 74, first_name_loc_lang ) ;
						i_pstmt.setString	( 75, second_name_loc_lang ) ;
						i_pstmt.setString	( 76, third_name_loc_lang ) ;
						i_pstmt.setString	( 77, name_suffix_loc_lang ) ;
						i_pstmt.setString	( 78, family_name_loc_lang ) ;
						i_pstmt.setString	( 79, patient_name_loc_lang ) ;
						i_pstmt.setString	( 80, speciality_code ) ;
						i_pstmt.setString	( 81, service_code ) ;
						i_pstmt.setString	( 82, trans_exceed_reason_code ) ;
						/*Added by Thamizh selvi on 23rd May 2017 for ML-MMOH-CRF-0610 Start*/
						i_pstmt.setString	( 83, appt_added_by_id ) ;
						i_pstmt.setString	( 84, appt_added_date ) ;
						/*End*/
						i_pstmt.setString	( 85, other_remarks ) ; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
						i_pstmt.executeUpdate() ;

					}
				}
				String prisecappt="select RESOURCE_ID , appt_ref_no from oa_resource_for_appt where facility_id='"+facilityId+"' AND appt_ref_no in (select pri_appt_ref_no from oa_clinic_schedule_slot_slab where facility_id='"+facilityId+"' and CLINIC_CODE='"+locn+"' and  CLINIC_DATE=to_date('"+dat+"','dd/mm/yyyy') and nvl(PRACTITIONER_ID,'X')=nvl('"+pract+"','X'))";
		rs=stmt.executeQuery(prisecappt);

		if(rs !=null){
			while (rs.next())
			{
				sec_res_id = rs.getString("RESOURCE_ID");
				if(sec_res_id ==null) sec_res_id="";
				appt_ref_no= rs.getString("appt_ref_no");
				if(appt_ref_no ==null) appt_ref_no="";

		if(!sec_res_id.equals(""))
			{


		pstmt3.setString(1,facilityId);
		pstmt3.setString(2,locn);
		pstmt3.setString(3,sec_res_id);
		pstmt3.setString(4,dat);

		sel_del_1= pstmt3.executeUpdate();


		pstmt4.setString(1,facilityId);
		pstmt4.setString(2,locn);
		pstmt4.setString(3,sec_res_id);
		pstmt4.setString(4,dat);

		sel_del_2= pstmt4.executeUpdate();



		pstmt5.setString(1,facilityId);
		pstmt5.setString(2,locn);
		pstmt5.setString(3,pract);
		pstmt5.setString(4,dat);

		sel_del_3= pstmt5.executeUpdate();

		pstmt7.setString(1,facilityId);
		pstmt7.setString(2,locn);
		pstmt7.setString(3,sec_res_id);
		pstmt7.setString(4,dat);

		sel_del_4= pstmt7.executeUpdate();


		f_pstmt.setString( 1, facilityId ) ;
		f_pstmt.setString( 2, appt_ref_no ) ;
		sel_del_5= f_pstmt.executeUpdate() ;

			}
			}
		}
				r_pstmt.setString	( 1, facilityId ) ;
				r_pstmt.setString	( 2, locn ) ;
				r_pstmt.setString	( 3, pract ) ;
				r_pstmt.setString	( 4, dat ) ;
				r_pstmt.setString	( 5, location_Type ) ;
				r_pstmt.setString	( 6, resource_Type ) ;
				rset2 =r_pstmt.executeQuery();
				String apptno = "";
			if(rset2 !=null){
				while(rset2.next()){
						apptno = rset2.getString("APPT_REF_NO");
						k_pstmt.setString( 1, facilityId ) ;
						k_pstmt.setString( 2, apptno ) ;
						k_pstmt.executeUpdate() ;
						l_pstmt.setString( 1, facilityId ) ;
						l_pstmt.setString( 2, apptno ) ;
						l_pstmt.executeUpdate() ;
					}
				}
				/*deleting from patient instructions Starts*/
				pstmt_inst=con.prepareStatement("delete from oa_appt_pat_instructions where facility_id=? and appt_ref_no in(select appt_ref_no from oa_appt where facility_id = ?  and clinic_code = ? and nvl(practitioner_id,'X') =nvl(?,'X') and appt_date =to_date(?,'dd/mm/yyyy') and care_locn_type_ind= ? and resource_class = ? )");
				pstmt_inst.setString(1,facilityId);
				pstmt_inst.setString(2,facilityId);
				pstmt_inst.setString(3,locn);
				pstmt_inst.setString(4,pract);
				pstmt_inst.setString(5,dat);
				pstmt_inst.setString(6,location_Type);
				pstmt_inst.setString(7,resource_Type);
				pstmt_inst.executeUpdate() ;
				pstmt_inst=con.prepareStatement("delete from oa_appt_proc_instructions where facility_id=? and appt_ref_no in(select appt_ref_no from oa_appt where facility_id = ?  and clinic_code = ? and nvl(practitioner_id,'X') =nvl(?,'X') and appt_date =to_date(?,'dd/mm/yyyy') and care_locn_type_ind= ? and resource_class = ? )");
				pstmt_inst.setString(1,facilityId);
				pstmt_inst.setString(2,facilityId);
				pstmt_inst.setString(3,locn);
				pstmt_inst.setString(4,pract);
				pstmt_inst.setString(5,dat);
				pstmt_inst.setString(6,location_Type);
				pstmt_inst.setString(7,resource_Type);
				pstmt_inst.executeUpdate() ;
				/*deleting from patient instructions ends*/
				pstmt2.setString( 1, facilityId ) ;
				pstmt2.setString( 2, locn ) ;
				pstmt2.setString( 3, pract ) ;
				pstmt2.setString( 4, dat ) ;
				pstmt2.setString( 5, location_Type ) ;
				pstmt2.setString( 6, resource_Type ) ;
				pstmt2.executeUpdate() ;

				pstmt7.setString(1 , facilityId);
				pstmt7.setString(2 , locn);
				pstmt7.setString(3 , pract);
				pstmt7.setString(4 , dat);

				pstmt7.executeUpdate() ;

				pstmt3.setString( 1, facilityId ) ;
				pstmt3.setString( 2, locn ) ;
				pstmt3.setString( 3, pract ) ;
				pstmt3.setString( 4, dat ) ;
				pstmt3.executeUpdate() ;

				/*m_pstmt.setString( 1, facilityId ) ;
				m_pstmt.setString( 2, locn ) ;
				m_pstmt.setString( 3, pract ) ;
				m_pstmt.setString( 4, dat ) ;
				m_pstmt.setString( 5, location_Type ) ;
				m_pstmt.setString( 6, resource_Type ) ;
				m_pstmt.executeUpdate() ;*/

				pstmt4.setString( 1, facilityId ) ;
				pstmt4.setString( 2, locn ) ;
				pstmt4.setString( 3, pract ) ;
				pstmt4.setString( 4, dat ) ;
				pstmt4.executeUpdate() ;

				pstmt5.setString( 1, facilityId ) ;
				pstmt5.setString( 2, locn ) ;
				pstmt5.setString( 3, pract ) ;
				pstmt5.setString( 4, dat ) ;

				 res5 = pstmt5.executeUpdate() ;

					if(n > s){
					String sl = "";
					int srlno = 0;
					pstmt9.setString( 1, facilityId ) ;
					rset=pstmt9.executeQuery();
					if(rset.next())
						sl = rset.getString("max");
					srlno = Integer.parseInt(sl);

					j_pstmt.setString(1, facilityId);
					j_pstmt.setInt	( 2, srlno ) ;
					j_pstmt.setString	( 3, "SC" ) ;
					j_pstmt.setString	( 4,fid );
					j_pstmt.setString	( 5, dat ) ;
					j_pstmt.setString (6,dat);
					j_pstmt.setString( 7, locn ) ;
					j_pstmt.setString( 8, pract ) ;
					j_pstmt.setString( 9, day ) ;
					j_pstmt.setString( 10, "" ) ;
					j_pstmt.setString( 11, reason ) ;
					j_pstmt.setString( 12, location_Type ) ;
					j_pstmt.setString( 13, resource_Type ) ;
				    j_pstmt.executeUpdate() ;
				}
				if ( res5 != 0 ){
					sql_operation = true ;
				}else{
					sql_operation = true ;
				}
			}//inner while

		}//outer while

		if(sql_operation){
			result=true;
			java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
			sb.append( (String) message.get("message") ) ;
			con.commit();
			message.clear();
		}else{
			con.rollback() ;
			sb.append("Transaction failed");
		}
		passObjects.clear();
		if (rs !=null) rs.close() ;
		if (rs1 !=null) rs1.close() ;
		if (rset !=null) rset.close() ;
		if (a_rs!=null) a_rs.close();
		if (b_rs!=null) b_rs.close();
		if (c_rs!=null) c_rs.close();
		if (pstmt !=null) pstmt.close() ;
		if (pstmt2 !=null) pstmt2.close() ;
		if (pstmt3 !=null) pstmt3.close() ;
		if (pstmt4 !=null) pstmt4.close() ;
		if (pstmt5 !=null) pstmt5.close() ;
		if (pstmt7 !=null) pstmt7.close();
		if (pstmt7 !=null) pstmt5.close() ;
		if (a_stmt !=null) a_stmt.close() ;
		if (b_stmt !=null) b_stmt.close() ;
		if (r_pstmt !=null) r_pstmt.close();
		if (a_pstmt !=null) a_pstmt.close() ;
		if (b_pstmt !=null) b_pstmt.close() ;
		if (c_pstmt !=null) c_pstmt.close() ;
		if (d_pstmt !=null) d_pstmt.close() ;
		if (e_pstmt !=null) e_pstmt.close() ;
		if (f_pstmt !=null) f_pstmt.close() ;
		if (g_pstmt !=null) g_pstmt.close() ;
		if (h_pstmt !=null) h_pstmt.close() ;
		if (i_pstmt !=null) i_pstmt.close() ;
		if (j_pstmt !=null) j_pstmt.close() ;
		if (k_pstmt !=null) k_pstmt.close() ;
		if (l_pstmt !=null) l_pstmt.close() ;
		if (m_pstmt !=null) m_pstmt.close() ;
		if (pstmt9 !=null) pstmt9.close();
		if (op_pstmt !=null) op_pstmt.close();
		if (pstmt_inst !=null) pstmt_inst.close();
		if (stmt !=null) stmt.close();
	}catch ( Exception e ) {
		e.printStackTrace();
		String errorMsg=e.toString();
		String errorMsg1="";
		Pattern pattern = Pattern.compile("ORA-00060");
		Pattern pattern1= Pattern.compile("ORA-00001");
		Matcher matcher = pattern.matcher(errorMsg);
		String oraError="";
		while (matcher.find()){
			errorMsg1=matcher.group();
			oraError="Schedule Cancelled by other user. Cannot Proceed.";
			sb.append( oraError + "<br>" ) ;
		}
		if(errorMsg1==""){
			Matcher matcher1 = pattern1.matcher(errorMsg);
			while (matcher1.find()){
				errorMsg1=matcher1.group();
				oraError="Schedule Cancelled by another user. Cannot Proceed.";
				sb.append( oraError + "<br>" ) ;
			}
		}else{
			sb.append( e.getMessage() + "<br>" ) ;
		}
		try {
			con.rollback() ;
		} catch ( Exception ce ) {
			ce.printStackTrace();
		}
		//sb.append( e.getMessage() + "<br>" ) ;
		e.printStackTrace() ;
	}  finally {
		if (con != null)
		{
			ConnectionManager.returnConnection(con,p);
		}
	}
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	sb.setLength(0);
	return results ;
}

/**
* @ejb.interface-method
*	 view-type="both"
*/
public java.util.HashMap OAtransRec(
						java.util.Properties p,
						java.util.HashMap passObjects
						 )
		{
		Connection con =null;// Added for KDAH-SCF-0704
		String finalvals=(String) passObjects.get("finalvals1");
		String efffrom=(String) passObjects.get("efffrom");
		String effto=(String) passObjects.get("effto");
		String reason=(String) passObjects.get("reason");
		String action=(String) passObjects.get("action");
		String fid=(String) passObjects.get("fid");
		String facilityId=(String) passObjects.get("facilityId");
		String location_Type=(String) passObjects.get("location_Type");
		String resource_Type=(String) passObjects.get("resource_Type");
		String locale = p.getProperty("LOCALE");

		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		String transcode = " ";
		StringBuffer sb = new StringBuffer( "" ) ;
		try
		{
		con = ConnectionManager.getConnection(p);
		stmt=con.createStatement();

		if(action.equals("B"))
			transcode = "BC";
		else if(action.equals("L"))
			transcode = "BL";
		else if(action.equals("C"))
			transcode = "SC";
		//String sl = "";
		//int srlno = 0;
		StringTokenizer st = new StringTokenizer(finalvals,"-");

		String sql1 = " Insert into oa_trans_record (facility_id,srl_no,trans_code,trans_date_time, trans_eff_by_id,  from_date_entered,to_date_entered, clinic_code,from_practitioner_id,from_day_no,remarks,reason_code,care_locn_type_ind,resource_class)  values (?,?,?,sysdate,'"+fid+"',to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?) " ;
		pstmt1 = con.prepareStatement( sql1 );
		StringTokenizer st1=null;
		mainwhile: while(st.hasMoreTokens())
		{
			str = st.nextToken();
			st1 = new StringTokenizer(str,"|");
			while(st1.hasMoreTokens())
			{

				locn = st1.nextToken();
				pract = st1.nextToken();
	
		
				/*Modified By Dharma on 22nd Jan 2015 against ML-BRU-SCF-1455 [IN:052324] Start*/
				//if(pract =="X" && pract.equals("X")) pract="";
				if(pract =="X" || pract.equals("X")) pract="";
				/*Modified By Dharma on 22nd Jan 2015 against ML-BRU-SCF-1455 [IN:052324] End*/


				dat = st1.nextToken();
				day = st1.nextToken();
				st1.nextToken();
				if(action.equals("B"))
				{
					st1.nextToken();
				} else
				{
				}


				String sql  = " Select nvl(max(srl_no),0)+1 max from oa_trans_record where facility_id='"+facilityId+"' ";
				rset=stmt.executeQuery(sql);

				if(rset.next())
					sl = rset.getString("max");
				  srlno = Integer.parseInt(sl);
					pstmt1.setString(1, facilityId);
					pstmt1.setInt	( 2, srlno ) ;
					pstmt1.setString	( 3, transcode ) ;
					pstmt1.setString	( 4, efffrom ) ;
					pstmt1.setString (5,effto);
					pstmt1.setString( 6, locn ) ;
					pstmt1.setString( 7, pract ) ;
					pstmt1.setString( 8, day ) ;
					pstmt1.setString( 9, "" ) ;
					pstmt1.setString( 10, reason ) ;
					pstmt1.setString( 11, location_Type ) ;
					pstmt1.setString( 12, resource_Type ) ;
					pstmt1.executeUpdate() ;
				int res = 0;
				if ( res != 0 )
				{
				sql_operation = true ;
				}else{
				sql_operation = true ;
				//break mainwhile;
				}
			}//inner while



		}//outer while
				if (rset!=null) rset.close();
				if (stmt!=null) stmt.close();
			if(sql_operation){
			result=true;
			java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
			sb.append( (String) message.get("message") ) ;
			con.commit();
			message.clear();
			}
			if(rset !=null) rset.close();
			if(pstmt1!=null) pstmt1.close() ;
			if(stmt !=null) stmt.close();
			passObjects.clear();
	}catch ( Exception e ) {
		e.printStackTrace();
				try {
						con.rollback() ;
					} catch ( Exception ce ) {
						ce.printStackTrace();
					}
				sb.append( e.getMessage() + "<br>" ) ;
				e.printStackTrace() ;
			}
		  finally {
			  if (con != null)
			  {
			  try {
					ConnectionManager.returnConnection(con,p);
		       		} catch (Exception ee) {
						ee.printStackTrace();
					}
		      	   }
			}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
}

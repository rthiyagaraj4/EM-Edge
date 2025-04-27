/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA.ChangePractitionerforGenSch;

import java.sql.*;
import java.rmi.*;
import javax.ejb.*;
import javax.naming.*;
import java.net.*;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="ChangePractitionerforGenSch"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ChangePractitionerforGenSch"
*	local-jndi-name="ChangePractitionerforGenSch"
*	impl-class-name="eOA.ChangePractitionerforGenSch.ChangePractitionerforGenSchManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOA.ChangePractitionerforGenSch.ChangePractitionerforGenSchManagerLocal"
*	remote-class="eOA.ChangePractitionerforGenSch.ChangePractitionerforGenSchManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOA.ChangePractitionerforGenSch.ChangePractitionerforGenSchManagerLocalHome"
*	remote-class="eOA.ChangePractitionerforGenSch.ChangePractitionerforGenSchManagerHome"
*	generate= "local,remote"
*
*
*/
public class ChangePractitionerforGenSchManager implements SessionBean  {

  Connection con;
  SessionContext sessCtx;
  public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;
  java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
  public void ejbCreate() {}
  public void ejbRemove() {}
  public void ejbActivate() {}
  public void ejbPassivate() {}
  public void setSessionContext( SessionContext context ) {sessCtx = context;}
/**
* @ejb.interface-method
*	 view-type="both"
*/
  public java.util.HashMap updateChgPractitioner( 
	  java.util.Properties p,							
	  java.util.HashMap passObjects

	) 
	  
  {

	String facilityId=(String) passObjects.get("facilityId");
	String client_ip_address=(String) passObjects.get("client_ip_address");
	Integer L_fetched_count_big=(Integer) passObjects.get("L_fetched_count_big");
	Integer L_selected_count_big=(Integer) passObjects.get("L_selected_count_big");
	String L_clinic_id=(String) passObjects.get("L_clinic_id");
	String dateDetail[]=(String[]) passObjects.get("dateDetail");
	String fromPract=(String) passObjects.get("fromPract");
	String toPract=(String) passObjects.get("toPract");
	String remarks=(String) passObjects.get("remarks");	
	String fromDate=(String) passObjects.get("fromDate");
	String toDate=(String) passObjects.get("toDate");
	String reason=(String) passObjects.get("reason");
	String locationType=(String) passObjects.get("locationType");
	String resourceType=(String) passObjects.get("resourceType"); 
	String resource_value=(String) passObjects.get("resource_value");
	String locale = p.getProperty("LOCALE");
	

	java.util.HashMap results = new java.util.HashMap() ;
	int L_fetched_count=L_fetched_count_big.intValue();
	int L_selected_count=L_selected_count_big.intValue();
	StringBuffer sb = new StringBuffer( "" ) ;
	boolean result = false ;
	boolean updated = true;
	Statement stmt=null,stmt_new=null;
	ResultSet rs1=null,rs2=null; 
	PreparedStatement pstmt=null,pstmt1=null,pstmt2=null,pstmt3=null,pstmt4=null,pstmt5=null,pstmt99=null,pstmt6=null,pstmtse=null;
	int rs=0, maxno = 0;
	String sql = "",sql1 = "",sql2 = "",sql3 = "",sql4 = "",sql5 = "",sql6 = "",sql7 = "",sql8 = "",str1="",res_typ="",spr_app_no="",pr_appt_no="",sec_res_update="";
	String addedDate = dateFormat.format( new java.util.Date() ) ;
	String addedById = p.getProperty( "login_user" ) ;
	String Modified_by_id = addedById ;
	String modifiedDate = addedDate ;
	String Modified_at_ws_no = client_ip_address ;
	String Modified_facility_id = facilityId;
	java.sql.Date Modified_date = java.sql.Date.valueOf( modifiedDate ) ;
	try {
		con = ConnectionManager.getConnection(p);
		con.setAutoCommit( false );
		stmt = con.createStatement();
		stmt_new = con.createStatement();
			if(resourceType.equals("P")){
				str1  = "select am_practitioner.pract_type res_type from am_practitioner,am_pract_type where nvl(practitioner_id,'x')=nvl('"+toPract+"','x') and am_pract_type.pract_type=am_practitioner.pract_type " ;
			}else if(resourceType.equals("R")){
				str1  = "select room_type res_type from am_facility_room,am_care_locn_type where nvl(room_num,'x')=nvl('"+toPract+"','x') and OPERATING_FACILITY_ID='"+facilityId+"' and am_facility_room.room_type=am_care_locn_type.CARE_LOCN_TYPE_IND" ;
			}else{
				str1  = "select am_resource.resource_type res_type from am_resource,am_resource_type where nvl(resource_id,'x')=nvl('"+toPract+"','x') and facility_id= '"+facilityId+"' and am_resource.resource_Class='"+resourceType+"' and am_resource.resource_type=am_resource_type.resource_type" ;
			}
			rs1=stmt.executeQuery(str1);
			if(rs1 !=null && rs1.next())
			res_typ = rs1.getString("res_type") ;

			sql = "update oa_appt set practitioner_id =?, modified_by_id =?, modified_date =?, modified_at_ws_no =?, modified_facility_id =? where facility_id = ? and clinic_code =? and practitioner_id =? and appt_date = to_date(?,'dd/mm/yyyy') and care_locn_type_ind= ? and resource_class = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,toPract);
			pstmt.setString(2,Modified_by_id);
			pstmt.setDate(3,Modified_date);
			pstmt.setString(4,Modified_at_ws_no);
			pstmt.setString(5,Modified_facility_id);
			pstmt.setString(6,facilityId);
			pstmt.setString(7,L_clinic_id);
			pstmt.setString(8,fromPract);
			pstmt.setString(10,locationType);
			pstmt.setString(11,resourceType);

			sql1 = "update oa_clinic_schedule_break set practitioner_id =?, modified_by_id =?, modified_date =?,modified_at_ws_no =?, modified_facility_id =? where facility_id = ? and clinic_code =? and practitioner_id =? and clinic_date = to_date(?,'dd/mm/yyyy') and care_locn_type_ind= ? and resource_class = ?";
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1,toPract);
			pstmt1.setString(2,Modified_by_id);
			pstmt1.setDate(3,Modified_date);
			pstmt1.setString(4,Modified_at_ws_no);
			pstmt1.setString(5,Modified_facility_id);
			pstmt1.setString(6,facilityId);
			pstmt1.setString(7,L_clinic_id);
			pstmt1.setString(8,fromPract);
			pstmt1.setString(10,locationType);
			pstmt1.setString(11,resourceType);
			
			sql2 = "update oa_block_appt set practitioner_id =?, modified_by_id =?, modified_date =?,modified_at_ws_no =?, modified_facility_id =? where facility_id = ? and clinic_code =? and practitioner_id =? and block_date = to_date(?,'dd/mm/yyyy') and care_locn_type_ind= ? and resource_class = ?";
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setString(1,toPract);
			pstmt2.setString(2,Modified_by_id);
			pstmt2.setDate(3,Modified_date);
			pstmt2.setString(4,Modified_at_ws_no);
			pstmt2.setString(5,Modified_facility_id);
			pstmt2.setString(6,facilityId);
			pstmt2.setString(7,L_clinic_id);
			pstmt2.setString(8,fromPract);
			pstmt2.setString(10,locationType);
			pstmt2.setString(11,resourceType);
		
			sql3 = "update oa_clinic_schedule set practitioner_id =?, modified_by_id =?, modified_date =?,modified_at_ws_no =?, modified_facility_id =? where facility_id = ? and clinic_code =? and practitioner_id =? and clinic_date = to_date(?,'dd/mm/yyyy')  and care_locn_type_ind= ? and resource_class = ?";
			pstmt3 = con.prepareStatement(sql3);
			pstmt3.setString(1,toPract);
			pstmt3.setString(2,Modified_by_id);
			pstmt3.setDate(3,Modified_date);
			pstmt3.setString(4,Modified_at_ws_no);
			pstmt3.setString(5,Modified_facility_id);
			pstmt3.setString(6,facilityId);
			pstmt3.setString(7,L_clinic_id);
			pstmt3.setString(8,fromPract);
			pstmt3.setString(10,locationType);
			pstmt3.setString(11,resourceType);

			/*String sql99 = "update oa_clinic_schedule_dtl set practitioner_id =?, modified_by_id =?, modified_date =?, modified_at_ws_no =?, modified_facility_id =? where facility_id = ? and clinic_code =? and practitioner_id =? and clinic_date = to_date(?,'dd/mm/yyyy')  and care_locn_type_ind= ? and resource_class = ?";
			pstmt99 = con.prepareStatement(sql99);
			pstmt99.setString(1,toPract);
			pstmt99.setString(2,Modified_by_id);
			pstmt99.setDate(3,Modified_date);
			pstmt99.setString(4,Modified_at_ws_no);
			pstmt99.setString(5,Modified_facility_id);
			pstmt99.setString(6,facilityId);
			pstmt99.setString(7,L_clinic_id);
			pstmt99.setString(8,fromPract);
			pstmt99.setString(10,locationType);
			pstmt99.setString(11,resourceType);*/
			
			sql8 = "update OA_CLINIC_SCHEDULE_SLOT_SLAB set practitioner_id =?, modified_by_id =?, modified_date =?, modified_at_ws_no =?, modified_facility_id =? where facility_id = ? and clinic_code =? and nvl(practitioner_id,'X') =nvl(?,'X') and clinic_date = to_date(?,'dd/mm/yyyy')  and care_locn_type_ind= ? and resource_class = ?";
           	pstmt6 = con.prepareStatement(sql8);
			pstmt6.setString(1,toPract);
			pstmt6.setString(2,Modified_by_id);
			pstmt6.setDate(3,Modified_date);
			pstmt6.setString(4,Modified_at_ws_no);
			pstmt6.setString(5,Modified_facility_id);
			pstmt6.setString(6,facilityId);
			pstmt6.setString(7,L_clinic_id);
			pstmt6.setString(8,fromPract);
			pstmt6.setString(10,locationType);
			pstmt6.setString(11,resourceType);

			sql4 = "insert into oa_trans_record (facility_id, srl_no, trans_code, trans_date_time, trans_eff_by_id, from_date_entered, to_date_entered, clinic_code, from_practitioner_id, to_practitioner_id, remarks,reason_code,care_locn_type_ind,resource_class ) values(?, ?, 'CP', sysdate, ?, to_date(?,'dd/mm/yyyy'), to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?,?,?,? )";
			pstmt4 = con.prepareStatement(sql4);
			pstmt4.setString(1,facilityId);
			pstmt4.setString(3,addedById);
			pstmt4.setString(6,L_clinic_id);
			pstmt4.setString(7,fromPract);
			pstmt4.setString(8,toPract);
			pstmt4.setString(9, remarks);
			pstmt4.setString(10, reason);
            pstmt4.setString(11, locationType);
			pstmt4.setString(12, resourceType);

			sql5 = "insert into oa_trans_record (facility_id, srl_no, trans_code, trans_date_time, trans_eff_by_id, from_date_entered,to_date_entered, clinic_code, from_practitioner_id, to_practitioner_id, remarks,reason_code,care_locn_type_ind,resource_class) values(?, ?, 'CP', sysdate,?, to_date(?,'dd/mm/yyyy'), to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?,?,?,? )";
			pstmt5 = con.prepareStatement(sql5);
			pstmt5.setString(1,facilityId);
			pstmt5.setString(3,addedById);
			pstmt5.setString(4,fromDate);
			pstmt5.setString(5,toDate);
			pstmt5.setString(6,L_clinic_id);
			pstmt5.setString(7,fromPract);
			pstmt5.setString(8,toPract);
			pstmt5.setString(9,remarks);
			pstmt5.setString(10,reason);
			pstmt5.setString(11, locationType);
			pstmt5.setString(12, resourceType);
        	for ( int i=0; i<L_selected_count; i++) {
				pstmt.setString(9,dateDetail[i]);
				if(resource_value.equals("N")){
					spr_app_no = "select PRI_APPT_REF_NO  from  oa_clinic_schedule_slot_slab	where CLINIC_DATE =to_date('"+dateDetail[i]+"','dd/mm/yyyy') and facility_id ='"+facilityId+"' and  care_locn_type_ind='"+locationType+"' and resource_class = '"+resourceType+"'  and clinic_code='"+L_clinic_id+"' and nvl(PRACTITIONER_ID,'')=nvl('"+fromPract+"','') and PRI_APPT_REF_NO is not null";
					rs2=stmt.executeQuery(spr_app_no);
					if(rs2 !=null && rs2.next()){
						pr_appt_no=rs2.getString("PRI_APPT_REF_NO") ;
						if(pr_appt_no ==null) pr_appt_no="";
					}
					if (rs2 !=null) rs2.close();
					
					if(pr_appt_no !=""){
						sec_res_update="update OA_RESOURCE_FOR_APPT set RESOURCE_TYPE='"+res_typ+"' , RESOURCE_ID='"+toPract+"' where trunc(APPT_DATE) =to_date('"+dateDetail[i]+"','dd/mm/yyyy') and facility_id ='"+facilityId+"' and resource_class = '"+resourceType+"' and  APPT_REF_NO='"+pr_appt_no+"'";
						pstmtse = con.prepareStatement(sec_res_update);
						pstmtse.executeUpdate();
					}
				}

				if (pstmtse !=null) pstmtse.close();
				rs = pstmt.executeUpdate();
				pstmt2.setString(9,dateDetail[i]);
				rs = pstmt2.executeUpdate();
				pstmt3.setString(9,dateDetail[i]);
				rs = pstmt3.executeUpdate();
				//pstmt99.setString(9,dateDetail[i]);
				//rs = pstmt99.executeUpdate();
				pstmt1.setString(9,dateDetail[i]);
				rs = pstmt1.executeUpdate();
				pstmt6.setString(9,dateDetail[i]);
				rs =pstmt6.executeUpdate();
				if (L_fetched_count > L_selected_count) {
				if (rs != 0){
				rs1 = null;
				sql6 = "select nvl(max(srl_no)+1,1) next_no from oa_trans_record where facility_id = '"+facilityId+"'";
				if (rs1!=null) rs1.close();
				rs1 = stmt.executeQuery(sql6);
				rs1.next();
				maxno = rs1.getInt("next_no");

				rs1.close();
				stmt_new.close();

				pstmt4.setInt(2,maxno);
				pstmt4.setString(4,dateDetail[i]);
				pstmt4.setString(5,dateDetail[i]);
				rs = pstmt4.executeUpdate();
			  }
			}//if condition
		}//for loop
		   if (L_fetched_count == L_selected_count) {
				if (updated) {
					rs1 = null;
					sql7 = "select nvl(max(srl_no)+1,1) next_no from oa_trans_record where facility_id = '"+facilityId+"'";
					stmt = con.createStatement();
					rs1 = stmt.executeQuery(sql7);
					rs1.next();
					maxno = rs1.getInt("next_no");
					stmt.close();
					rs1.close();
					pstmt5.setInt(2,maxno);
					rs = pstmt5.executeUpdate();
    			}
			}//if condition
			if (updated) {
				result = true ;
				java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_MODIFIED","SM" ) ;
				sb.append( (String) message.get("message") ) ;
				con.commit();
				message.clear();
			}else {
				result = false ;
				try {
					con.rollback() ;
				} catch ( Exception ce ) {
					 ce.printStackTrace();
				}
				sb.append("Transaction is rolled back.") ;
			}
			if (rs1 !=null) rs1.close() ;
			if (rs2 !=null) rs2.close() ;
  		    if (stmt !=null) stmt.close() ;
			
		    if (pstmt != null) pstmt.close();
		    if (pstmt1 != null) pstmt1.close();
		    if (pstmt2 != null) pstmt2.close();
		    if (pstmt3 != null) pstmt3.close();
		    if (pstmt4 != null) pstmt4.close();
		    if (pstmt5 != null) pstmt5.close();
		    if (pstmt99 != null) pstmt99.close();
			if (stmt_new !=null) stmt_new.close();
			if (pstmt != null) pstmt.close();
			if (pstmt1 != null) pstmt1.close();
			if (pstmt6 !=null) pstmt6.close();
			if (pstmtse !=null) pstmtse.close();
			passObjects.clear();
     }catch ( Exception e ){
		sb.append("Transaction Context is rolledback as Exception is raise by EJB");
		e.printStackTrace();
		}finally{
	    if (con != null) ConnectionManager.returnConnection(con,p);
	}
	 results.put( "status", new Boolean(result) ) ;
	 results.put( "error", sb.toString() ) ;
	 sb.setLength(0);
	 return results ;
  } //FUNCTION
} //CLASS

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS.RSWorkplaceRequirement ;

import java.rmi.* ;
import java.sql.* ;
import java.util.* ;
import javax.ejb.* ;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="RSWorkplaceRequirement"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RSWorkplaceRequirement"
*	local-jndi-name="RSWorkplaceRequirement"
*	impl-class-name="eRS.RSWorkplaceRequirement.RSWorkplaceRequirementManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eRS.RSWorkplaceRequirement.RSWorkplaceRequirementLocal"
*	remote-class="eRS.RSWorkplaceRequirement.RSWorkplaceRequirementRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eRS.RSWorkplaceRequirement.RSWorkplaceRequirementLocalHome"
*	remote-class="eRS.RSWorkplaceRequirement.RSWorkplaceRequirementHome"
*	generate= "local,remote"
*
*
*/

public class RSWorkplaceRequirementManager implements SessionBean {

	Connection connection = null;
	StringBuffer traceVal	= new StringBuffer();

	PreparedStatement pstmt_insert_dtl=null;
	PreparedStatement pstmt_insert =null;
	PreparedStatement pstmt_update = null;
	PreparedStatement pstmt_select = null;
	PreparedStatement pstmt_select_reqid = null;
	PreparedStatement pstmt_modify_dtl = null;
	ResultSet res_select = null;
	ResultSet res_select_reqid = null;	
	
	String login_by_id	="";
	String login_at_ws_no="";
	String login_facility_id	="";
	String modified_by_id	="";
	String modified_facility_id	="";
	String modified_at_ws_no	 ="";
	String locale	 ="";

	public RSWorkplaceRequirementManager(){}

	public void ejbCreate() throws CreateException{}

	public void ejbRemove(){}

	public void ejbActivate(){}

	public void ejbPassivate(){}

    public void setSessionContext(SessionContext sessioncontext){
	}
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert(HashMap tabData, HashMap sqlMap){

		StringBuffer messages = new StringBuffer() ;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
        Properties prop				=	(Properties)tabData.get("properties");
		int req_inserted		= 0;
		int[] reqDtl_inserted	= null;
		int totalRecords=Integer.parseInt((String)tabData.get("totalRecords")==null?"0":(String)tabData.get("totalRecords"));
		String facility_id			= (String) tabData.get("facility_id")==null?"":(String) tabData.get("facility_id");
		String workplace_code	= (String) tabData.get("workplace_code")==null?"":(String) tabData.get("workplace_code") ;
		String reqd_desc		= (String) tabData.get("reqd_desc")==null?"":(String) tabData.get("reqd_desc") ;
		String requirement_id		= (String) tabData.get("requirement_id")==null?"": (String) tabData.get("requirement_id") ;
		String frm_dt			= (String) tabData.get( "frm_dt")==null?"":(String) tabData.get( "frm_dt");
		String to_dt			= (String) tabData.get( "to_dt")==null?"":(String) tabData.get( "to_dt");
		String wrk_cycle_basis="";
		String reqd_type="";
		if(frm_dt.equals("") && to_dt.equals(""))
			reqd_type="C";
		else 
			reqd_type="V";	

		login_by_id			= (String )tabData.get("added_by_id");
		login_at_ws_no		= (String )tabData.get("added_at_ws_no");
		login_facility_id	= (String )tabData.get("added_facility_id");
		modified_by_id		= (String )tabData.get("added_by_id");
		modified_at_ws_no	= (String )tabData.get("added_at_ws_no");
		modified_facility_id= (String )tabData.get("added_facility_id");
		locale= (String )tabData.get("locale");

		try{
			//connection = getConnection((Properties)tabData.get( "properties" ) );
            connection = ConnectionManager.getConnection(prop);
			connection.setAutoCommit( false );

			String SELECT_WRK_CYCLE = (String )sqlMap.get("SELECT_WRK_CYCLE_BASIS");
			pstmt_select = connection.prepareStatement(SELECT_WRK_CYCLE);

			pstmt_select.setString( 1,facility_id.trim());
			pstmt_select.setString( 2,facility_id.trim());
			res_select = pstmt_select.executeQuery() ;

			while ( res_select != null && res_select.next() ) {
				wrk_cycle_basis=res_select.getString("work_cycle_basis");
			}
			if(pstmt_select !=null)
				pstmt_select.close();
			if(res_select != null)
				res_select.close();
			String SELECT_REQD_ID	= "SELECT rs_workplace_req_seq.NEXTVAL req_id FROM dual";
			pstmt_select_reqid	= connection.prepareStatement(SELECT_REQD_ID);
			res_select_reqid	= pstmt_select_reqid.executeQuery();
				
			while ( res_select_reqid != null && res_select_reqid.next() ) {
				requirement_id=res_select_reqid.getString("req_id");
			}
			if(pstmt_select_reqid !=null)
				pstmt_select_reqid.close();
			if(res_select_reqid != null)
				res_select_reqid.close();			

			String INSERT_RS_WRKPLACE_REQD = (String )sqlMap.get("INSERT_RS_WRKPLACE_REQD");
			pstmt_insert = connection.prepareStatement(INSERT_RS_WRKPLACE_REQD);

			pstmt_insert.setString( 1,facility_id);
			pstmt_insert.setString( 2,workplace_code);
			pstmt_insert.setString( 3,requirement_id);
			pstmt_insert.setString( 4,frm_dt);
			pstmt_insert.setString( 5,to_dt);
			pstmt_insert.setString( 6,reqd_desc);
			pstmt_insert.setString( 7,wrk_cycle_basis);
			pstmt_insert.setString( 8,login_by_id);
			pstmt_insert.setString( 9,login_at_ws_no);
			pstmt_insert.setString( 10,login_facility_id);
			pstmt_insert.setString( 11,modified_by_id);
			pstmt_insert.setString( 12,modified_at_ws_no);
			pstmt_insert.setString( 13,modified_facility_id);
			pstmt_insert.setString( 14,reqd_type.trim());

			req_inserted = pstmt_insert.executeUpdate() ;
			if(pstmt_insert !=null)
				pstmt_insert.close();
			
			if(req_inserted > 0){

				String INSERT_RS_WRKPLACE_REQD_DTL = (String )sqlMap.get("INSERT_RS_WRKPLACE_REQD_DTL");
				pstmt_insert_dtl=connection.prepareStatement(INSERT_RS_WRKPLACE_REQD_DTL);
				for(int i=0;i<totalRecords;i++){

					HashMap TabDataTemp = (HashMap )tabData.get("InsertData"+i);
					String shift_code			= (String)TabDataTemp.get("shift_code")==null?"":(String)TabDataTemp.get("shift_code");
					String position_code		= (String)TabDataTemp.get("position_code")==null?"":(String)TabDataTemp.get("position_code");
					String fr_wday_min			= (String)TabDataTemp.get("fr_wday_min")==null?"":(String)TabDataTemp.get("fr_wday_min");
					String fr_wday_opt			= (String)TabDataTemp.get("fr_wday_opt")==null?"":(String)TabDataTemp.get("fr_wday_opt");
					String fr_wday_max			= (String)TabDataTemp.get("fr_wday_max")==null?"":(String)TabDataTemp.get("fr_wday_max");
					String fr_nwday_min			= (String)TabDataTemp.get("fr_nwday_min")==null?"":(String)TabDataTemp.get("fr_nwday_min");
					String fr_nwday_opt			= (String)TabDataTemp.get("fr_nwday_opt")==null?"":(String)TabDataTemp.get("fr_nwday_opt");
					String fr_nwday_max			= (String)TabDataTemp.get("fr_nwday_max")==null?"":(String)TabDataTemp.get("fr_nwday_max");
					String fr_hday_min			= (String)TabDataTemp.get("fr_hday_min")==null?"":(String)TabDataTemp.get("fr_hday_min");
					String fr_hday_opt			= (String) TabDataTemp.get("fr_hday_opt")==null?"":(String)TabDataTemp.get("fr_hday_opt");
					String fr_hday_max			= (String) TabDataTemp.get( "fr_hday_max" )==null?"":(String)TabDataTemp.get("fr_hday_max");
					String fr_sbr_staff_wday	= (String) TabDataTemp.get( "fr_sbr_staff_wday" )==null?"":(String)TabDataTemp.get("fr_sbr_staff_wday");
					String fr_sbr_bed_wday		= (String) TabDataTemp.get( "fr_sbr_bed_wday" )==null?"":(String)TabDataTemp.get("fr_sbr_bed_wday");
					String fr_sbr_staff_nwday	= (String) TabDataTemp.get( "fr_sbr_staff_nwday" )==null?"":(String)TabDataTemp.get("fr_sbr_staff_nwday");
					String fr_sbr_bed_nwday		= (String) TabDataTemp.get( "fr_sbr_bed_nwday" )==null?"":(String)TabDataTemp.get("fr_sbr_bed_nwday");
					String fr_sbr_staff_hday	= (String) TabDataTemp.get( "fr_sbr_staff_hday" )==null?"":(String)TabDataTemp.get("fr_sbr_staff_hday");
					String fr_sbr_bed_hday		= (String) TabDataTemp.get( "fr_sbr_bed_hday" )==null?"":(String)TabDataTemp.get("fr_sbr_bed_hday");
					String vr_spr_staff_wday	= (String) TabDataTemp.get( "vr_spr_staff_wday" )==null?"":(String)TabDataTemp.get("vr_spr_staff_wday");
					String vr_spr_patient_wday	= (String) TabDataTemp.get( "vr_spr_patient_wday" )==null?"":(String)TabDataTemp.get("vr_spr_patient_wday");
					String vr_spr_staff_nwday	= (String) TabDataTemp.get( "vr_spr_staff_nwday" )==null?"":(String)TabDataTemp.get("vr_spr_staff_nwday");
					String vr_spr_patient_nwday	= (String) TabDataTemp.get( "vr_spr_patient_nwday" )==null?"":(String)TabDataTemp.get("vr_spr_staff_hday");
					String vr_spr_staff_hday	= (String) TabDataTemp.get( "vr_spr_staff_hday" )==null?"":(String)TabDataTemp.get("vr_spr_staff_hday");
					String vr_spr_patient_hwday = (String) TabDataTemp.get( "vr_spr_patient_hwday" )==null?"":(String)TabDataTemp.get("vr_spr_patient_hwday");
					String vr_fte_wday			= (String) TabDataTemp.get( "vr_fte_wday" )==null?"":(String)TabDataTemp.get("vr_fte_wday");
					String vr_fte_hours_wday	= (String) TabDataTemp.get( "vr_fte_hours_wday" )==null?"":(String)TabDataTemp.get("vr_fte_hours_wday");
					String vr_fte_nwday			= (String) TabDataTemp.get( "vr_fte_nwday" )==null?"":(String)TabDataTemp.get("vr_fte_nwday");
					String vr_fte_hours_nwday	= (String) TabDataTemp.get( "vr_fte_hours_nwday" )==null?"":(String)TabDataTemp.get("vr_fte_hours_nwday");
					String vr_fte_hday			= (String) TabDataTemp.get( "vr_fte_hday" )==null?"":(String)TabDataTemp.get("vr_fte_hday");
					String vr_fte_hours_hday	= (String) TabDataTemp.get( "vr_fte_hours_hday" )==null?"":(String)TabDataTemp.get("vr_fte_hours_hday");

					pstmt_insert_dtl.setString( 1,facility_id.trim());
					pstmt_insert_dtl.setString( 2,workplace_code.trim());
					pstmt_insert_dtl.setString( 3,requirement_id.trim());
					pstmt_insert_dtl.setString( 4,shift_code.trim());
					pstmt_insert_dtl.setString( 5,position_code.trim());
					pstmt_insert_dtl.setString( 6,fr_wday_min.trim());
					pstmt_insert_dtl.setString( 7,fr_wday_opt.trim());
					pstmt_insert_dtl.setString( 8,fr_wday_max.trim());
					pstmt_insert_dtl.setString( 9,fr_nwday_min.trim());
					pstmt_insert_dtl.setString( 10,fr_nwday_opt.trim());
					pstmt_insert_dtl.setString( 11,fr_nwday_max.trim());
					pstmt_insert_dtl.setString( 12,fr_hday_min.trim());
					pstmt_insert_dtl.setString( 13,fr_hday_opt.trim());
					pstmt_insert_dtl.setString( 14,fr_hday_max.trim());
					pstmt_insert_dtl.setString( 15,fr_sbr_staff_wday.trim());
					pstmt_insert_dtl.setString( 16,fr_sbr_bed_wday.trim());
					pstmt_insert_dtl.setString( 17,fr_sbr_staff_nwday.trim());
					pstmt_insert_dtl.setString( 18,fr_sbr_bed_nwday.trim());
					pstmt_insert_dtl.setString( 19,fr_sbr_staff_hday.trim());
					pstmt_insert_dtl.setString( 20,fr_sbr_bed_hday.trim());
					pstmt_insert_dtl.setString( 21,vr_spr_staff_wday.trim());
					pstmt_insert_dtl.setString( 22,vr_spr_patient_wday.trim());
					pstmt_insert_dtl.setString( 23,vr_spr_staff_nwday.trim());
					pstmt_insert_dtl.setString( 24,vr_spr_patient_nwday.trim());
					pstmt_insert_dtl.setString( 25,vr_spr_staff_hday.trim());
					pstmt_insert_dtl.setString( 26,vr_spr_patient_hwday.trim());
					pstmt_insert_dtl.setString( 27,vr_fte_wday.trim());
					pstmt_insert_dtl.setString( 28,vr_fte_hours_wday.trim());
					pstmt_insert_dtl.setString( 29,vr_fte_nwday.trim());
					pstmt_insert_dtl.setString( 30,vr_fte_hours_nwday.trim());
					pstmt_insert_dtl.setString( 31,vr_fte_hday.trim());
					pstmt_insert_dtl.setString( 32,vr_fte_hours_hday.trim());
					pstmt_insert_dtl.setString( 33,login_by_id.trim());
					pstmt_insert_dtl.setString( 34,login_at_ws_no.trim());
					pstmt_insert_dtl.setString( 35,login_facility_id.trim());
					pstmt_insert_dtl.setString( 36,modified_by_id.trim());
					pstmt_insert_dtl.setString( 37,modified_at_ws_no.trim());
					pstmt_insert_dtl.setString( 38,modified_facility_id.trim());

					pstmt_insert_dtl.addBatch() ;
				}

				reqDtl_inserted=pstmt_insert_dtl.executeBatch();

				if(pstmt_insert_dtl != null)
					pstmt_insert_dtl.close();
			}

			if (reqDtl_inserted ==null) {
				connection.rollback();
				retMap.put( "result", new Boolean( true ) ) ;
				Hashtable massageMap = MessageManager.getMessage(connection, "ERROR_IN_INSERTING_INTO");
				messages.append((String)massageMap.get("message"));
			}else{
				connection.commit() ;
				retMap.put( "result", new Boolean( true ) ) ;
				Hashtable massageMap = MessageManager.getMessage(locale, "RECORD_INSERTED","RS");
				messages.append((String)massageMap.get("message"));
			}
		}catch( Exception e ) {
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		}finally {
			try {
				if ( pstmt_select != null ) {
					pstmt_select.close() ;
				}if ( pstmt_insert_dtl != null ) {
					pstmt_insert_dtl.close() ;
				}if ( pstmt_insert != null ) {
					pstmt_insert.close() ;
				}if ( pstmt_select_reqid != null ) {
					pstmt_select_reqid.close() ;
				}if(connection != null) {
					//closeConnection(connection,(Properties)tabData.get( "properties" ));
					ConnectionManager.returnConnection(connection,prop);
				}
			}catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		retMap.put( "message", messages.toString() ) ;
		retMap.put( "traceVal",traceVal.toString());
		retMap.put( "invalidCode" , "");
		return retMap;	
	}// end of insert	

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
public HashMap modify(HashMap tabData, HashMap sqlMap )  {
		HashMap retMap = new HashMap();
		try{
				String frm_dt			= (String) tabData.get("frm_dt")==null?"":(String) tabData.get("frm_dt") ;
				String to_dt			= (String) tabData.get("to_dt")==null?"":(String) tabData.get("to_dt") ;
				String reqd_type		="";
				if(frm_dt.equals("") && to_dt.equals(""))
					reqd_type="C";
				else 
					reqd_type="V";
	
				if(reqd_type.equals("C"))
					retMap	 =	 constantReqModify(tabData, sqlMap);
				else
					retMap	 =	 varyingReqModify(tabData, sqlMap);

			}catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		return retMap;	
	}// end of modify

/**********************************************************************/
	private HashMap constantReqModify(HashMap tabData, HashMap sqlMap)throws Exception{

		StringBuffer messages = new StringBuffer() ;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		int req_modified		= 0;
		int req_inserted		= 0;
		int[] reqDtl_inserted	= null;
        Properties prop				=	(Properties)tabData.get("properties");

		int totalRecords=Integer.parseInt((String)tabData.get("totalRecords")==null?"0":(String)tabData.get("totalRecords"));
		String facility_id			= (String) tabData.get("facility_id")==null?"":(String) tabData.get("facility_id");
		String workplace_code	= (String) tabData.get("workplace_code")==null?"":(String) tabData.get("workplace_code") ;
		String reqd_desc		= (String) tabData.get("reqd_desc")==null?"":(String) tabData.get("reqd_desc") ;
		String requirement_id		= (String) tabData.get("requirement_id")==null?"": (String) tabData.get("requirement_id") ;
		String frm_dt			= (String) tabData.get( "frm_dt")==null?"":(String) tabData.get( "frm_dt");
		String to_dt			= (String) tabData.get( "to_dt")==null?"":(String) tabData.get( "to_dt");
		String wrk_cycle_basis="";
		String reqd_type="C";

		login_by_id			= (String )tabData.get("added_by_id");
		login_at_ws_no		= (String )tabData.get("added_at_ws_no");
		login_facility_id	= (String )tabData.get("added_facility_id");
		modified_by_id		= (String )tabData.get("added_by_id");
		modified_at_ws_no	= (String )tabData.get("added_at_ws_no");
		modified_facility_id= (String )tabData.get("added_facility_id");
		locale= (String )tabData.get("locale");

		try{
			//connection = getConnection((Properties)tabData.get( "properties" ) );
            connection = ConnectionManager.getConnection(prop);
			connection.setAutoCommit( false );

			String MODIFY_RS_WRKPLACE_REQD	=	(String)sqlMap.get("MODIFY_RS_WRKPLACE_REQD");

			pstmt_update=connection.prepareStatement(MODIFY_RS_WRKPLACE_REQD);
			pstmt_update.setString( 1,modified_by_id);
			pstmt_update.setString( 2,modified_at_ws_no);
			pstmt_update.setString( 3,modified_facility_id);
			pstmt_update.setString( 4,facility_id);
			pstmt_update.setString( 5,workplace_code);
			pstmt_update.setString( 6,requirement_id);

			req_modified=pstmt_update.executeUpdate();
			if(pstmt_update != null)
				pstmt_update.close();

			if(req_modified>0){
				String SELECT_WRK_CYCLE = (String )sqlMap.get("SELECT_WRK_CYCLE_BASIS");
				pstmt_select = connection.prepareStatement(SELECT_WRK_CYCLE);

				pstmt_select.setString( 1,facility_id.trim());
				pstmt_select.setString( 2,facility_id.trim());
				res_select = pstmt_select.executeQuery() ;

				while ( res_select != null && res_select.next() ) {
					wrk_cycle_basis=res_select.getString("work_cycle_basis");
				}
				if(pstmt_select !=null)
					pstmt_select.close();
				if(res_select != null)
					res_select.close();
				String SELECT_REQD_ID	= "SELECT rs_workplace_req_seq.NEXTVAL req_id FROM dual";
				pstmt_select_reqid	= connection.prepareStatement(SELECT_REQD_ID);
				res_select_reqid	= pstmt_select_reqid.executeQuery();
					
				while ( res_select_reqid != null && res_select_reqid.next() ) {
					requirement_id=res_select_reqid.getString("req_id");
				}
				if(pstmt_select_reqid !=null)
					pstmt_select_reqid.close();
				if(res_select_reqid != null)
					res_select_reqid.close();
				

				String INSERT_RS_WRKPLACE_REQD = (String )sqlMap.get("INSERT_RS_WRKPLACE_REQD");
				pstmt_insert = connection.prepareStatement(INSERT_RS_WRKPLACE_REQD);

				pstmt_insert.setString( 1,facility_id);
				pstmt_insert.setString( 2,workplace_code);
				pstmt_insert.setString( 3,requirement_id);
				pstmt_insert.setString( 4,frm_dt);
				pstmt_insert.setString( 5,to_dt);
				pstmt_insert.setString( 6,reqd_desc);
				pstmt_insert.setString( 7,wrk_cycle_basis);
				pstmt_insert.setString( 8,login_by_id);
				pstmt_insert.setString( 9,login_at_ws_no);
				pstmt_insert.setString( 10,login_facility_id);
				pstmt_insert.setString( 11,modified_by_id);
				pstmt_insert.setString( 12,modified_at_ws_no);
				pstmt_insert.setString( 13,modified_facility_id);
				pstmt_insert.setString( 14,reqd_type.trim());

				req_inserted = pstmt_insert.executeUpdate() ;
				if(pstmt_insert !=null)
					pstmt_insert.close();
			}
			if(req_inserted > 0){

				String INSERT_RS_WRKPLACE_REQD_DTL = (String )sqlMap.get("INSERT_RS_WRKPLACE_REQD_DTL");
				pstmt_insert_dtl=connection.prepareStatement(INSERT_RS_WRKPLACE_REQD_DTL);
				for(int i=0;i<totalRecords;i++){

					HashMap TabDataTemp = (HashMap )tabData.get("InsertData"+i);
					String shift_code			= (String)TabDataTemp.get("shift_code")==null?"":(String)TabDataTemp.get("shift_code");
					String position_code		= (String)TabDataTemp.get("position_code")==null?"":(String)TabDataTemp.get("position_code");
					String fr_wday_min			= (String)TabDataTemp.get("fr_wday_min")==null?"":(String)TabDataTemp.get("fr_wday_min");
					String fr_wday_opt			= (String)TabDataTemp.get("fr_wday_opt")==null?"":(String)TabDataTemp.get("fr_wday_opt");
					String fr_wday_max			= (String)TabDataTemp.get("fr_wday_max")==null?"":(String)TabDataTemp.get("fr_wday_max");
					String fr_nwday_min			= (String)TabDataTemp.get("fr_nwday_min")==null?"":(String)TabDataTemp.get("fr_nwday_min");
					String fr_nwday_opt			= (String)TabDataTemp.get("fr_nwday_opt")==null?"":(String)TabDataTemp.get("fr_nwday_opt");
					String fr_nwday_max			= (String)TabDataTemp.get("fr_nwday_max")==null?"":(String)TabDataTemp.get("fr_nwday_max");
					String fr_hday_min			= (String)TabDataTemp.get("fr_hday_min")==null?"":(String)TabDataTemp.get("fr_hday_min");
					String fr_hday_opt			= (String) TabDataTemp.get("fr_hday_opt")==null?"":(String)TabDataTemp.get("fr_hday_opt");
					String fr_hday_max			= (String) TabDataTemp.get( "fr_hday_max" )==null?"":(String)TabDataTemp.get("fr_hday_max");
					String fr_sbr_staff_wday	= (String) TabDataTemp.get( "fr_sbr_staff_wday" )==null?"":(String)TabDataTemp.get("fr_sbr_staff_wday");
					String fr_sbr_bed_wday		= (String) TabDataTemp.get( "fr_sbr_bed_wday" )==null?"":(String)TabDataTemp.get("fr_sbr_bed_wday");
					String fr_sbr_staff_nwday	= (String) TabDataTemp.get( "fr_sbr_staff_nwday" )==null?"":(String)TabDataTemp.get("fr_sbr_staff_nwday");
					String fr_sbr_bed_nwday		= (String) TabDataTemp.get( "fr_sbr_bed_nwday" )==null?"":(String)TabDataTemp.get("fr_sbr_bed_nwday");
					String fr_sbr_staff_hday	= (String) TabDataTemp.get( "fr_sbr_staff_hday" )==null?"":(String)TabDataTemp.get("fr_sbr_staff_hday");
					String fr_sbr_bed_hday		= (String) TabDataTemp.get( "fr_sbr_bed_hday" )==null?"":(String)TabDataTemp.get("fr_sbr_bed_hday");
					String vr_spr_staff_wday	= (String) TabDataTemp.get( "vr_spr_staff_wday" )==null?"":(String)TabDataTemp.get("vr_spr_staff_wday");
					String vr_spr_patient_wday	= (String) TabDataTemp.get( "vr_spr_patient_wday" )==null?"":(String)TabDataTemp.get("vr_spr_patient_wday");
					String vr_spr_staff_nwday	= (String) TabDataTemp.get( "vr_spr_staff_nwday" )==null?"":(String)TabDataTemp.get("vr_spr_staff_nwday");
					String vr_spr_patient_nwday	= (String) TabDataTemp.get( "vr_spr_patient_nwday" )==null?"":(String)TabDataTemp.get("vr_spr_staff_hday");
					String vr_spr_staff_hday	= (String) TabDataTemp.get( "vr_spr_staff_hday" )==null?"":(String)TabDataTemp.get("vr_spr_staff_hday");
					String vr_spr_patient_hwday = (String) TabDataTemp.get( "vr_spr_patient_hwday" )==null?"":(String)TabDataTemp.get("vr_spr_patient_hwday");
					String vr_fte_wday			= (String) TabDataTemp.get( "vr_fte_wday" )==null?"":(String)TabDataTemp.get("vr_fte_wday");
					String vr_fte_hours_wday	= (String) TabDataTemp.get( "vr_fte_hours_wday" )==null?"":(String)TabDataTemp.get("vr_fte_hours_wday");
					String vr_fte_nwday			= (String) TabDataTemp.get( "vr_fte_nwday" )==null?"":(String)TabDataTemp.get("vr_fte_nwday");
					String vr_fte_hours_nwday	= (String) TabDataTemp.get( "vr_fte_hours_nwday" )==null?"":(String)TabDataTemp.get("vr_fte_hours_nwday");
					String vr_fte_hday			= (String) TabDataTemp.get( "vr_fte_hday" )==null?"":(String)TabDataTemp.get("vr_fte_hday");
					String vr_fte_hours_hday	= (String) TabDataTemp.get( "vr_fte_hours_hday" )==null?"":(String)TabDataTemp.get("vr_fte_hours_hday");

					pstmt_insert_dtl.setString( 1,facility_id.trim());
					pstmt_insert_dtl.setString( 2,workplace_code.trim());
					pstmt_insert_dtl.setString( 3,requirement_id.trim());
					pstmt_insert_dtl.setString( 4,shift_code.trim());
					pstmt_insert_dtl.setString( 5,position_code.trim());
					pstmt_insert_dtl.setString( 6,fr_wday_min.trim());
					pstmt_insert_dtl.setString( 7,fr_wday_opt.trim());
					pstmt_insert_dtl.setString( 8,fr_wday_max.trim());
					pstmt_insert_dtl.setString( 9,fr_nwday_min.trim());
					pstmt_insert_dtl.setString( 10,fr_nwday_opt.trim());
					pstmt_insert_dtl.setString( 11,fr_nwday_max.trim());
					pstmt_insert_dtl.setString( 12,fr_hday_min.trim());
					pstmt_insert_dtl.setString( 13,fr_hday_opt.trim());
					pstmt_insert_dtl.setString( 14,fr_hday_max.trim());
					pstmt_insert_dtl.setString( 15,fr_sbr_staff_wday.trim());
					pstmt_insert_dtl.setString( 16,fr_sbr_bed_wday.trim());
					pstmt_insert_dtl.setString( 17,fr_sbr_staff_nwday.trim());
					pstmt_insert_dtl.setString( 18,fr_sbr_bed_nwday.trim());
					pstmt_insert_dtl.setString( 19,fr_sbr_staff_hday.trim());
					pstmt_insert_dtl.setString( 20,fr_sbr_bed_hday.trim());
					pstmt_insert_dtl.setString( 21,vr_spr_staff_wday.trim());
					pstmt_insert_dtl.setString( 22,vr_spr_patient_wday.trim());
					pstmt_insert_dtl.setString( 23,vr_spr_staff_nwday.trim());
					pstmt_insert_dtl.setString( 24,vr_spr_patient_nwday.trim());
					pstmt_insert_dtl.setString( 25,vr_spr_staff_hday.trim());
					pstmt_insert_dtl.setString( 26,vr_spr_patient_hwday.trim());
					pstmt_insert_dtl.setString( 27,vr_fte_wday.trim());
					pstmt_insert_dtl.setString( 28,vr_fte_hours_wday.trim());
					pstmt_insert_dtl.setString( 29,vr_fte_nwday.trim());
					pstmt_insert_dtl.setString( 30,vr_fte_hours_nwday.trim());
					pstmt_insert_dtl.setString( 31,vr_fte_hday.trim());
					pstmt_insert_dtl.setString( 32,vr_fte_hours_hday.trim());
					pstmt_insert_dtl.setString( 33,login_by_id.trim());
					pstmt_insert_dtl.setString( 34,login_at_ws_no.trim());
					pstmt_insert_dtl.setString( 35,login_facility_id.trim());
					pstmt_insert_dtl.setString( 36,modified_by_id.trim());
					pstmt_insert_dtl.setString( 37,modified_at_ws_no.trim());
					pstmt_insert_dtl.setString( 38,modified_facility_id.trim());

					pstmt_insert_dtl.addBatch() ;
				}

				reqDtl_inserted=pstmt_insert_dtl.executeBatch();

				if(pstmt_insert_dtl != null)
					pstmt_insert_dtl.close();
			}

			if (reqDtl_inserted ==null) {
				connection.rollback();
				retMap.put( "result", new Boolean( true ) ) ;
				Hashtable massageMap = MessageManager.getMessage(connection, "ERROR_IN_UPDATING");
				messages.append((String)massageMap.get("message"));
			}else{
				connection.commit() ;
				retMap.put( "result", new Boolean( true ) ) ;
				Hashtable massageMap = MessageManager.getMessage(locale, "RECORD_MODIFIED","RS");
				messages.append((String)massageMap.get("message"));
			}
		}catch( Exception e ) {
				traceVal.append("Exception if any -- "+e);
				messages.append( e.getMessage() ) ;
				e.printStackTrace() ;
		}finally {
			try {
				if ( pstmt_select != null )
					pstmt_select.close() ;
				if ( pstmt_insert_dtl != null )
					pstmt_insert_dtl.close() ;
				if ( pstmt_insert != null )
					pstmt_insert.close() ;
				if ( pstmt_select_reqid != null )
					pstmt_select_reqid.close() ;
				if ( pstmt_modify_dtl != null )
					pstmt_modify_dtl.close() ;
				if(connection != null)
					//closeConnection(connection,(Properties)tabData.get( "properties" ));
					ConnectionManager.returnConnection(connection,prop);
				
			}catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		retMap.put( "message", messages.toString() ) ;
		retMap.put( "traceVal",traceVal.toString());
		retMap.put( "invalidCode" , "");
		return retMap;	
	}
/*************************************************************************/
	private HashMap varyingReqModify(HashMap tabData, HashMap sqlMap)throws Exception{

		StringBuffer messages = new StringBuffer() ;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		int[] reqDtl_modified	= null;
		int[] reqDtl_inserted	= null;
        Properties prop				=	(Properties)tabData.get("properties");

		int totalRecords=Integer.parseInt((String)tabData.get("totalRecords")==null?"0":(String)tabData.get("totalRecords"));
		String facility_id			= (String) tabData.get("facility_id")==null?"":(String) tabData.get("facility_id");
		String workplace_code	= (String) tabData.get("workplace_code")==null?"":(String) tabData.get("workplace_code") ;
		String requirement_id		= (String) tabData.get("requirement_id")==null?"": (String) tabData.get("requirement_id") ;

		login_by_id			= (String )tabData.get("added_by_id");
		login_at_ws_no		= (String )tabData.get("added_at_ws_no");
		login_facility_id	= (String )tabData.get("added_facility_id");
		modified_by_id		= (String )tabData.get("added_by_id");
		modified_at_ws_no	= (String )tabData.get("added_at_ws_no");
		modified_facility_id= (String )tabData.get("added_facility_id");

		try{
			//connection = getConnection((Properties)tabData.get( "properties" ) );
            connection = ConnectionManager.getConnection(prop);
			connection.setAutoCommit( false );

			String INSERT_RS_WRKPLACE_REQD_DTL = (String )sqlMap.get("INSERT_RS_WRKPLACE_REQD_DTL");
			String MODIFY_RS_WRKPLACE_REQD_DTL = (String )sqlMap.get("MODIFY_RS_WRKPLACE_REQD_DTL");
			pstmt_insert_dtl=connection.prepareStatement(INSERT_RS_WRKPLACE_REQD_DTL);
			pstmt_modify_dtl=connection.prepareStatement(MODIFY_RS_WRKPLACE_REQD_DTL);

				for(int i=0;i<totalRecords;i++){

					HashMap TabDataTemp = (HashMap )tabData.get("InsertData"+i);
					String db_action = (String)TabDataTemp.get("db_action")==null?"":(String)TabDataTemp.get("db_action");

					if(db_action.equalsIgnoreCase("I")){

					String shift_code			= (String)TabDataTemp.get("shift_code")==null?"":(String)TabDataTemp.get("shift_code");
					String position_code		= (String)TabDataTemp.get("position_code")==null?"":(String)TabDataTemp.get("position_code");
					String fr_wday_min			= (String)TabDataTemp.get("fr_wday_min")==null?"":(String)TabDataTemp.get("fr_wday_min");
					String fr_wday_opt			= (String)TabDataTemp.get("fr_wday_opt")==null?"":(String)TabDataTemp.get("fr_wday_opt");
					String fr_wday_max			= (String)TabDataTemp.get("fr_wday_max")==null?"":(String)TabDataTemp.get("fr_wday_max");
					String fr_nwday_min			= (String)TabDataTemp.get("fr_nwday_min")==null?"":(String)TabDataTemp.get("fr_nwday_min");
					String fr_nwday_opt			= (String)TabDataTemp.get("fr_nwday_opt")==null?"":(String)TabDataTemp.get("fr_nwday_opt");
					String fr_nwday_max			= (String)TabDataTemp.get("fr_nwday_max")==null?"":(String)TabDataTemp.get("fr_nwday_max");
					String fr_hday_min			= (String)TabDataTemp.get("fr_hday_min")==null?"":(String)TabDataTemp.get("fr_hday_min");
					String fr_hday_opt			= (String) TabDataTemp.get("fr_hday_opt")==null?"":(String)TabDataTemp.get("fr_hday_opt");
					String fr_hday_max			= (String) TabDataTemp.get( "fr_hday_max" )==null?"":(String)TabDataTemp.get("fr_hday_max");
					String fr_sbr_staff_wday	= (String) TabDataTemp.get( "fr_sbr_staff_wday" )==null?"":(String)TabDataTemp.get("fr_sbr_staff_wday");
					String fr_sbr_bed_wday		= (String) TabDataTemp.get( "fr_sbr_bed_wday" )==null?"":(String)TabDataTemp.get("fr_sbr_bed_wday");
					String fr_sbr_staff_nwday	= (String) TabDataTemp.get( "fr_sbr_staff_nwday" )==null?"":(String)TabDataTemp.get("fr_sbr_staff_nwday");
					String fr_sbr_bed_nwday		= (String) TabDataTemp.get( "fr_sbr_bed_nwday" )==null?"":(String)TabDataTemp.get("fr_sbr_bed_nwday");
					String fr_sbr_staff_hday	= (String) TabDataTemp.get( "fr_sbr_staff_hday" )==null?"":(String)TabDataTemp.get("fr_sbr_staff_hday");
					String fr_sbr_bed_hday		= (String) TabDataTemp.get( "fr_sbr_bed_hday" )==null?"":(String)TabDataTemp.get("fr_sbr_bed_hday");
					String vr_spr_staff_wday	= (String) TabDataTemp.get( "vr_spr_staff_wday" )==null?"":(String)TabDataTemp.get("vr_spr_staff_wday");
					String vr_spr_patient_wday	= (String) TabDataTemp.get( "vr_spr_patient_wday" )==null?"":(String)TabDataTemp.get("vr_spr_patient_wday");
					String vr_spr_staff_nwday	= (String) TabDataTemp.get( "vr_spr_staff_nwday" )==null?"":(String)TabDataTemp.get("vr_spr_staff_nwday");
					String vr_spr_patient_nwday	= (String) TabDataTemp.get( "vr_spr_patient_nwday" )==null?"":(String)TabDataTemp.get("vr_spr_staff_hday");
					String vr_spr_staff_hday	= (String) TabDataTemp.get( "vr_spr_staff_hday" )==null?"":(String)TabDataTemp.get("vr_spr_staff_hday");
					String vr_spr_patient_hwday = (String) TabDataTemp.get( "vr_spr_patient_hwday" )==null?"":(String)TabDataTemp.get("vr_spr_patient_hwday");
					String vr_fte_wday			= (String) TabDataTemp.get( "vr_fte_wday" )==null?"":(String)TabDataTemp.get("vr_fte_wday");
					String vr_fte_hours_wday	= (String) TabDataTemp.get( "vr_fte_hours_wday" )==null?"":(String)TabDataTemp.get("vr_fte_hours_wday");
					String vr_fte_nwday			= (String) TabDataTemp.get( "vr_fte_nwday" )==null?"":(String)TabDataTemp.get("vr_fte_nwday");
					String vr_fte_hours_nwday	= (String) TabDataTemp.get( "vr_fte_hours_nwday" )==null?"":(String)TabDataTemp.get("vr_fte_hours_nwday");
					String vr_fte_hday			= (String) TabDataTemp.get( "vr_fte_hday" )==null?"":(String)TabDataTemp.get("vr_fte_hday");
					String vr_fte_hours_hday	= (String) TabDataTemp.get( "vr_fte_hours_hday" )==null?"":(String)TabDataTemp.get("vr_fte_hours_hday");

						pstmt_insert_dtl.setString( 1,facility_id.trim());
						pstmt_insert_dtl.setString( 2,workplace_code.trim());
						pstmt_insert_dtl.setString( 3,requirement_id.trim());
						pstmt_insert_dtl.setString( 4,shift_code.trim());
						pstmt_insert_dtl.setString( 5,position_code.trim());
						pstmt_insert_dtl.setString( 6,fr_wday_min.trim());
						pstmt_insert_dtl.setString( 7,fr_wday_opt.trim());
						pstmt_insert_dtl.setString( 8,fr_wday_max.trim());
						pstmt_insert_dtl.setString( 9,fr_nwday_min.trim());
						pstmt_insert_dtl.setString( 10,fr_nwday_opt.trim());
						pstmt_insert_dtl.setString( 11,fr_nwday_max.trim());
						pstmt_insert_dtl.setString( 12,fr_hday_min.trim());
						pstmt_insert_dtl.setString( 13,fr_hday_opt.trim());
						pstmt_insert_dtl.setString( 14,fr_hday_max.trim());
						pstmt_insert_dtl.setString( 15,fr_sbr_staff_wday.trim());
						pstmt_insert_dtl.setString( 16,fr_sbr_bed_wday.trim());
						pstmt_insert_dtl.setString( 17,fr_sbr_staff_nwday.trim());
						pstmt_insert_dtl.setString( 18,fr_sbr_bed_nwday.trim());
						pstmt_insert_dtl.setString( 19,fr_sbr_staff_hday.trim());
						pstmt_insert_dtl.setString( 20,fr_sbr_bed_hday.trim());
						pstmt_insert_dtl.setString( 21,vr_spr_staff_wday.trim());
						pstmt_insert_dtl.setString( 22,vr_spr_patient_wday.trim());
						pstmt_insert_dtl.setString( 23,vr_spr_staff_nwday.trim());
						pstmt_insert_dtl.setString( 24,vr_spr_patient_nwday.trim());
						pstmt_insert_dtl.setString( 25,vr_spr_staff_hday.trim());
						pstmt_insert_dtl.setString( 26,vr_spr_patient_hwday.trim());
						pstmt_insert_dtl.setString( 27,vr_fte_wday.trim());
						pstmt_insert_dtl.setString( 28,vr_fte_hours_wday.trim());
						pstmt_insert_dtl.setString( 29,vr_fte_nwday.trim());
						pstmt_insert_dtl.setString( 30,vr_fte_hours_nwday.trim());
						pstmt_insert_dtl.setString( 31,vr_fte_hday.trim());
						pstmt_insert_dtl.setString( 32,vr_fte_hours_hday.trim());
						pstmt_insert_dtl.setString( 33,login_by_id.trim());
						pstmt_insert_dtl.setString( 34,login_at_ws_no.trim());
						pstmt_insert_dtl.setString( 35,login_facility_id.trim());
						pstmt_insert_dtl.setString( 36,modified_by_id.trim());
						pstmt_insert_dtl.setString( 37,modified_at_ws_no.trim());
						pstmt_insert_dtl.setString( 38,modified_facility_id.trim());

						pstmt_insert_dtl.addBatch() ;
				}
				else if (db_action.equalsIgnoreCase("U")){

					String shift_code			= (String) TabDataTemp.get( "shift_code" ) ;
					String position_code		= (String) TabDataTemp.get( "position_code" ) ;
					String fr_wday_min			= (String) TabDataTemp.get( "fr_wday_min" ) ;
					String fr_wday_opt			= (String) TabDataTemp.get( "fr_wday_opt" ) ;
					String fr_wday_max			= (String) TabDataTemp.get( "fr_wday_max" ) ;
					String fr_nwday_min			= (String) TabDataTemp.get( "fr_nwday_min" ) ;
					String fr_nwday_opt			= (String) TabDataTemp.get( "fr_nwday_opt" ) ;
					String fr_nwday_max			= (String) TabDataTemp.get( "fr_nwday_max" ) ;
					String fr_hday_min			= (String) TabDataTemp.get( "fr_hday_min" ) ;
					String fr_hday_opt			= (String) TabDataTemp.get( "fr_hday_opt" ) ;
					String fr_hday_max			= (String) TabDataTemp.get( "fr_hday_max" ) ;
					String fr_sbr_staff_wday	= (String) TabDataTemp.get( "fr_sbr_staff_wday" ) ;
					String fr_sbr_bed_wday		= (String) TabDataTemp.get( "fr_sbr_bed_wday" ) ;
					String fr_sbr_staff_nwday	= (String) TabDataTemp.get( "fr_sbr_staff_nwday" ) ;
					String fr_sbr_bed_nwday		= (String) TabDataTemp.get( "fr_sbr_bed_nwday" ) ;
					String fr_sbr_staff_hday	= (String) TabDataTemp.get( "fr_sbr_staff_hday" ) ;
					String fr_sbr_bed_hday		= (String) TabDataTemp.get( "fr_sbr_bed_hday" ) ;
					String vr_spr_staff_wday	= (String) TabDataTemp.get( "vr_spr_staff_wday" ) ;
					String vr_spr_patient_wday	= (String) TabDataTemp.get( "vr_spr_patient_wday" ) ;
					String vr_spr_staff_nwday	= (String) TabDataTemp.get( "vr_spr_staff_nwday" ) ;
					String vr_spr_patient_nwday	= (String) TabDataTemp.get( "vr_spr_patient_nwday" ) ;
					String vr_spr_staff_hday	= (String) TabDataTemp.get( "vr_spr_staff_hday" ) ;
					String vr_spr_patient_hwday = (String) TabDataTemp.get( "vr_spr_patient_hwday" ) ;
					String vr_fte_wday			= (String) TabDataTemp.get( "vr_fte_wday" ) ;
					String vr_fte_hours_wday	= (String) TabDataTemp.get( "vr_fte_hours_wday" ) ;
					String vr_fte_nwday			= (String) TabDataTemp.get( "vr_fte_nwday" ) ;
					String vr_fte_hours_nwday	= (String) TabDataTemp.get( "vr_fte_hours_nwday" ) ;
					String vr_fte_hday			= (String) TabDataTemp.get( "vr_fte_hday" ) ;
					String vr_fte_hours_hday	= (String) TabDataTemp.get( "vr_fte_hours_hday" ) ;

					pstmt_modify_dtl.setString( 1,fr_wday_min.trim());
					pstmt_modify_dtl.setString( 2,fr_wday_opt.trim());
					pstmt_modify_dtl.setString( 3,fr_wday_max.trim());
					pstmt_modify_dtl.setString( 4,fr_nwday_min.trim());
					pstmt_modify_dtl.setString( 5,fr_nwday_opt.trim());
					pstmt_modify_dtl.setString( 6,fr_nwday_max.trim());
					pstmt_modify_dtl.setString( 7,fr_hday_min.trim());
					pstmt_modify_dtl.setString( 8,fr_hday_opt.trim());
					pstmt_modify_dtl.setString( 9,fr_hday_max.trim());
					pstmt_modify_dtl.setString( 10,fr_sbr_staff_wday.trim());
					pstmt_modify_dtl.setString( 11,fr_sbr_bed_wday.trim());
					pstmt_modify_dtl.setString( 12,fr_sbr_staff_nwday.trim());
					pstmt_modify_dtl.setString( 13,fr_sbr_bed_nwday.trim());
					pstmt_modify_dtl.setString( 14,fr_sbr_staff_hday.trim());
					pstmt_modify_dtl.setString( 15,fr_sbr_bed_hday.trim());
					pstmt_modify_dtl.setString( 16,vr_spr_staff_wday.trim());
					pstmt_modify_dtl.setString( 17,vr_spr_patient_wday.trim());
					pstmt_modify_dtl.setString( 18,vr_spr_staff_nwday.trim());
					pstmt_modify_dtl.setString( 19,vr_spr_patient_nwday.trim());
					pstmt_modify_dtl.setString( 20,vr_spr_staff_hday.trim());
					pstmt_modify_dtl.setString( 21,vr_spr_patient_hwday.trim());
					pstmt_modify_dtl.setString( 22,vr_fte_wday.trim());
					pstmt_modify_dtl.setString( 23,vr_fte_hours_wday.trim());
					pstmt_modify_dtl.setString( 24,vr_fte_nwday.trim());
					pstmt_modify_dtl.setString( 25,vr_fte_hours_nwday.trim());
					pstmt_modify_dtl.setString( 26,vr_fte_hday.trim());
					pstmt_modify_dtl.setString( 27,vr_fte_hours_hday.trim());
					pstmt_modify_dtl.setString( 28,modified_by_id.trim());
					pstmt_modify_dtl.setString( 29,modified_at_ws_no.trim());
					pstmt_modify_dtl.setString( 30,modified_facility_id.trim());

					pstmt_modify_dtl.setString( 31,facility_id.trim());
					pstmt_modify_dtl.setString( 32,workplace_code.trim());
					pstmt_modify_dtl.setString( 33,requirement_id.trim());
					pstmt_modify_dtl.setString( 34,position_code.trim());
					pstmt_modify_dtl.setString( 35,shift_code.trim());

					pstmt_modify_dtl.addBatch() ;
				}	
			}

				reqDtl_inserted=pstmt_insert_dtl.executeBatch();
				reqDtl_modified=pstmt_modify_dtl.executeBatch();

			if(pstmt_insert_dtl != null)
				pstmt_insert_dtl.close();
			if(pstmt_modify_dtl != null)
				pstmt_modify_dtl.close();

			if ((reqDtl_inserted ==null)||(reqDtl_modified == null)) {
				connection.rollback();
				retMap.put( "result", new Boolean( true ) ) ;
				Hashtable massageMap = MessageManager.getMessage(connection, "ERROR_IN_UPDATING");
				messages.append((String)massageMap.get("message"));
			}else{
				connection.commit() ;
				retMap.put( "result", new Boolean( true ) ) ;
				Hashtable massageMap = MessageManager.getMessage(locale, "RECORD_MODIFIED","RS");
				messages.append((String)massageMap.get("message"));
			}
		}catch( Exception e ) {
				traceVal.append("Exception if any -- "+e);
				messages.append( e.getMessage() ) ;
				e.printStackTrace() ;
		}finally {
			try {
				if ( pstmt_insert_dtl != null )
					pstmt_insert_dtl.close() ;
				if ( pstmt_modify_dtl != null )
					pstmt_modify_dtl.close() ;
				if(connection != null)
					//closeConnection(connection,(Properties)tabData.get( "properties" ));				
					ConnectionManager.returnConnection(connection,prop);
			}catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		retMap.put( "message", messages.toString() ) ;
		retMap.put( "traceVal",traceVal.toString());
		retMap.put( "invalidCode" , "");
		return retMap;	
	}
}//end of class

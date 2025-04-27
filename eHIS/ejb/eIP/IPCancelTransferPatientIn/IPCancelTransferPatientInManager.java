/*
This ejb is used to cancel the Transfer Patient In and Emergency transfer(ie, bed transfer done between different nursing unit)
@author - Thamizh selvi 
@version - V1
*/
package eIP.IPCancelTransferPatientIn;
import blipin.*;
import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import java.util.* ;
import webbeans.eCommon.*;
import eCommon.Common.*;
import com.ehis.util.*;
/**
*
* @ejb.bean
*	name="IPCancelTransferPatientIn"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPCancelTransferPatientIn"
*	local-jndi-name="IPCancelTransferPatientIn"
*	impl-class-name="eIP.IPCancelTransferPatientIn.IPCancelTransferPatientInManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPCancelTransferPatientIn.IPCancelTransferPatientInLocal"
*	remote-class="eIP.IPCancelTransferPatientIn.IPCancelTransferPatientInRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPCancelTransferPatientIn.IPCancelTransferPatientInLocalHome"
*	remote-class="eIP.IPCancelTransferPatientIn.IPCancelTransferPatientInHome"
*	generate= "local,remote"
*
*
*/
public class IPCancelTransferPatientInManager implements SessionBean 
{

	Connection con = null;
	PreparedStatement preparedStatement = null ;
	PreparedStatement pstmt = null ;
	ResultSet rs=null;
	long encounterid;

	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){ this.ctx=context;}

	/**
	This method is used to cancel patient bed transfer done between different nursing unit (applicable to Transfer Patient In and Emergency Transfer).
	@author - Thamizh selvi
	@version - V1
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/

public java.util.HashMap insertCancelTransferPatientIn(java.util.Properties p,java.util.HashMap hashData) 
{
	String locale = p.getProperty("LOCALE");

	String  addedAtWorkstation	= (String)hashData.get("client_ip_address");
	String  facilityId			= (String)hashData.get("facilityId");
	String  patientid			= (String)hashData.get("patientid");
	String  encounter_id		= (String)hashData.get("encounterid");
	String  cancel_reason		= (String)hashData.get("cancel_reason");
	String  srlNo				= (String)hashData.get("srlNo");

	String  trf_type			= (String)hashData.get("trf_type");
	String  frm_serv_code		= (String)hashData.get("frm_serv_code");
	String  frm_bed_cls_code	= (String)hashData.get("frm_bed_cls_code");
	String  frm_bed_type_code	= (String)hashData.get("frm_bed_cls_type");
	String  frm_pract			= (String)hashData.get("frm_pract");
	String  frm_spec_code		= (String)hashData.get("frm_spec_code");
	String  frm_sub_serv_code	= (String)hashData.get("frm_sub_serv_code");

	String  frmNursCode			= (String)hashData.get("frmNursCode");
	String  toNursCode			= (String)hashData.get("toNursCode");
	String  toBedNo				= (String)hashData.get("toBedNo");
	String  frmRoomNo			= (String)hashData.get("frmRoomNo");
	String  toRoomNo			= (String)hashData.get("toRoomNo");
	String  frmBedNo			= (String)hashData.get("frmBedNo");
	String  tfrReqRefNo			= (String)hashData.get("tfrReqRefNo");

	String  modifiedDate			= (String)hashData.get("modifiedDate");

	String  modified_date_curr			="";
	String ext_num						="";
	String patientgender				="";
	String deactivate_pseudo_bed_yn		="";
	String transfer_wo_delink_yn		="";
	String pseudo_bed_yn				="";
	String  locn_type					="";
	String chkForBabyBed				="N";
	String mothers_patient_id			="";
	String trn_date_time				="";
	int babyCount						=0;
	int transferBabyCount				=0;
		
	ArrayList<String> babyBedNo=new ArrayList<String>();
	ArrayList<String> babyPatientId=new ArrayList<String>();

	java.util.HashMap results	= new java.util.HashMap() ;
	boolean result = true ;

	StringBuffer sb = new StringBuffer("");
	results.put( "error", "no error" ) ;
	String addedById = p.getProperty( "login_user" ) ;
	StringBuffer sbSql = new StringBuffer();
	if(sb.length()>0)
		 sb.setLength(0);

	String transfer_type = null;
	if(trf_type.equals("R") || trf_type.equals("O"))
		transfer_type = "PI";
	else if (trf_type.equals("I"))
		transfer_type = "ET";

	try
	{
		encounterid		= Long.parseLong(encounter_id);
		int	res			= 0; 
		con				= ConnectionManager.getConnection(p);
		String status="";
		
		con.setAutoCommit(false);

		if(result)
		{
			try
			{
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append("select to_char(modified_date,'dd/mm/rrrr hh24:mi:ss') modified_date_curr from ip_open_encounter where facility_id = ? and encounter_id = ? ");
				pstmt = con.prepareStatement(sbSql.toString());
				pstmt.setString ( 1, facilityId ) ;
				pstmt.setString ( 2, encounter_id);
				rs = pstmt.executeQuery() ;
						
				if(rs.next())
				{
					modified_date_curr = rs.getString("modified_date_curr");
					if(modified_date_curr == null)	modified_date_curr = "";
				}

				if (modified_date_curr.equals(modifiedDate))
				{
					result = true;
				}
				else
				{
					result = false;
					java.util.Hashtable message = MessageManager.getMessage(locale,"ENC_ALREADY_MODIFIED","IP");
					sb.append((String) message.get("message") ) ;
					message.clear();
				}

				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
				}
			catch (Exception e)
			{
				result = false;
				e.printStackTrace();
			}
		}
		
		if (result)
		{
			if(!(toRoomNo == null || toRoomNo.equals("") || toRoomNo.equals("null")))
				{
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append("select EXT_NUM from am_facility_room where OPERATING_FACILITY_ID='"+facilityId+"'  and ROOM_NUM='"+toRoomNo+"' ");
								
						pstmt = con.prepareStatement( sbSql.toString() );
						rs	= pstmt.executeQuery();

						if(rs.next())
						{
							ext_num = (rs.getString("EXT_NUM") == null) ? "" : rs.getString("ext_num");
						}

						if(pstmt!=null) pstmt.close();
						if(rs!=null) rs.close();
						
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append("select locn_type from ip_nursing_unit where facility_id='"+facilityId+"' and nursing_unit_code='"+frmNursCode+"'");
							
						pstmt = con.prepareStatement( sbSql.toString() );
						rs	= pstmt.executeQuery();

						if(rs.next())
						{
							locn_type = (rs.getString("locn_type") == null) ? "" : rs.getString("locn_type");
						}

						if(pstmt!=null) pstmt.close();
						if(rs!=null) rs.close();
						
				} 
		}

		/*For Emergency Transfer*/
		if(transfer_type.equals("ET"))
		{
			try
			{

				if(result)
				{
						sbSql.delete(0, sbSql.length());

						sbSql.append(" update pr_encounter set ");
						sbSql.append(" attend_practitioner_id = ? , specialty_code=?, assign_care_locn_type=?, ");
						sbSql.append(" assign_care_locn_code=?, assign_room_num=? , assign_bed_num = ?, SUBSERVICE_CODE = ?, SERVICE_CODE = ?, assign_bed_class_code = ?,ASSIGN_BED_TYPE_CODE=?,PAT_CURR_LOCN_TYPE=?,PAT_CURR_LOCN_CODE=?,PAT_TRN_TIME=sysdate, ROOM_TEL_EXT_NUM = ?  , MODIFIED_AT_WS_NO = ? , MODIFIED_BY_ID = ? , MODIFIED_DATE = sysdate , MODIFIED_FACILITY_ID = ? ");
						
						sbSql.append(" where facility_id=? and encounter_id = ? ");
							

						pstmt = con.prepareStatement( sbSql.toString());
						pstmt.setString	( 1, frm_pract ) ;
						pstmt.setString	( 2, frm_spec_code ) ;
						pstmt.setString	( 3, locn_type ) ;
						pstmt.setString	( 4, frmNursCode ) ;
						pstmt.setString	( 5, frmRoomNo ) ;
						pstmt.setString	( 6, frmBedNo ) ;
						pstmt.setString	( 7, frm_sub_serv_code ) ;
						pstmt.setString	( 8, frm_serv_code ) ;
						pstmt.setString	( 9, frm_bed_cls_code ) ;
						pstmt.setString	( 10, frm_bed_type_code ) ;
						pstmt.setString	( 11, locn_type ) ;
						pstmt.setString	( 12, frmNursCode ) ;
						pstmt.setString	( 13, ext_num ) ;
							
						pstmt.setString	( 14, addedAtWorkstation ) ;
						pstmt.setString	( 15, addedById ) ;
						pstmt.setString	( 16, facilityId ) ;
						pstmt.setString	(17, facilityId ) ;
						pstmt.setLong	(18, encounterid ) ; 
						
						try
						{
							int res1 = pstmt.executeUpdate() ;
							if(res1>0 )  result = true; else result = false;
							if(pstmt!=null)pstmt.close();
							
						}catch(Exception ex)
						{
							result = false;
							ex.printStackTrace();
							sb.append("Exception while updating pr_encounter table : " + ex);
						}
				}
				
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
				result = false;
				sb.append("SQL Exception while updating pr_encounter: " + e1);
			}
			
		}
		
		/*For Transfer Patient In*/
		else if (transfer_type.equals("PI"))
		{
			
			String informed_yn			= null;
			String informed_to			= null;
			String informed_name		= null;
			String informed_date_time	= null;
			String bed_booking_ref_no	= null;
			String reservedYn			= null;

			if (result)
			{
				if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
				sbSql.append(" select reserved_yn from ip_adt_trn where facility_id='"+facilityId+"' and encounter_id='"+encounterid+"' and srl_no = ("+srlNo+" - 1)");

				try
				{
					if(rs !=null) rs.close();if(pstmt != null)pstmt.close();
					pstmt = con.prepareStatement( sbSql.toString() );
					rs = pstmt.executeQuery() ;
					if(rs!=null && rs.next())
					{
						reservedYn			= rs.getString("reserved_yn");
					}
									
					if(rs !=null) rs.close();
					if(pstmt !=null) pstmt.close();
				}
				catch(SQLException ex)
				{
					result = false;
					sb.append("Exception while getting value for reservedYn from ip_adt_trn  :"+ex.toString());
					ex.printStackTrace();
				}

			}


			if (result)	
			{
				if(reservedYn.equals("Y"))
				{

					if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
					sbSql.append(" select bed_booking_ref_no from ip_bed_booking where facility_id='"+facilityId+"' and booking_type='N' and encounter_id='"+encounterid+"' and req_nursing_unit_code ='"+frmNursCode+"' and req_room_no='"+frmRoomNo+"' and req_bed_no ='"+frmBedNo+"' and booking_date_time = ( select max(booking_date_time) from ip_bed_booking where facility_id='"+facilityId+"' and encounter_id='"+encounterid+"' and booking_type='N' and req_nursing_unit_code ='"+frmNursCode+"' and req_room_no='"+frmRoomNo+"' and req_bed_no ='"+frmBedNo+"' ) ");

					try
					{
						if(rs !=null) rs.close();if(pstmt != null)pstmt.close();
						pstmt = con.prepareStatement( sbSql.toString() );
						rs = pstmt.executeQuery() ;
						if(rs!=null && rs.next())
						{
							bed_booking_ref_no		= rs.getString("bed_booking_ref_no");
						}
										
						if(rs !=null) rs.close();
						if(pstmt !=null) pstmt.close();
					}
					catch(SQLException ex)
					{
						result = false;
						sb.append("Exception while getting value for bed_booking_ref_no from ip_bed_booking for reserve bed :"+ex.toString());
						ex.printStackTrace();
					}

					
					if (bed_booking_ref_no != null)
					{
						sbSql.delete(0, sbSql.length());
						sbSql.append("  delete from ip_bed_booking where facility_id='"+facilityId+"' and booking_type='N' and bed_booking_ref_no='"+bed_booking_ref_no+"' ");
						
						pstmt = con.prepareStatement(sbSql.toString());
						try
						{
							res = pstmt.executeUpdate() ;

							if(res>0)
								result = true;
							else
							{
								result = false;
								sb.append("Error while deleting ip_bed_booking");
							}
							if(pstmt!=null)pstmt.close();	
						}
						catch(Exception ex)
						{
							result = false;
							sb.append("Exception while deleting record in ip_bed_booking  :"+ex.toString());
							ex.printStackTrace();
						}
					}
					
					sbSql.delete(0, sbSql.length());
					sbSql.append(" delete from ip_reserved_bed_dtl where facility_id='"+facilityId+"' and encounter_id='"+encounterid+"' and srl_no=("+srlNo+" - 1) ");
					
					pstmt = con.prepareStatement(sbSql.toString());
										
					try
					{
						res = pstmt.executeUpdate() ;

						if(res>0)
							result = true;
						else
						{
							result = false;
							sb.append("Error while deleting ip_reserved_bed_dtl");
						}
						if(pstmt!=null)pstmt.close();	
					}
					catch(Exception ex)
					{
						result = false;
						sb.append("Exception while deleting record in ip_reserved_bed_dtl  :"+ex.toString());
						ex.printStackTrace();
					}

				}

				else
				{
					if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
					sbSql.append(" select bed_booking_ref_no from ip_bed_booking where facility_id='"+facilityId+"' and booking_type='T' and req_nursing_unit_code ='"+frmNursCode+"' and req_room_no='"+frmRoomNo+"' and req_bed_no ='"+frmBedNo+"' and booking_date_time = (select max(booking_date_time) from ip_bed_booking where facility_id='"+facilityId+"' and booking_type='T' and req_nursing_unit_code ='"+frmNursCode+"' and req_room_no='"+frmRoomNo+"' and req_bed_no ='"+frmBedNo+"') ");

					try
					{
						if(rs !=null) rs.close();if(pstmt != null)pstmt.close();
						pstmt = con.prepareStatement( sbSql.toString() );
						rs = pstmt.executeQuery() ;
						if(rs!=null && rs.next())
						{
							bed_booking_ref_no		= rs.getString("bed_booking_ref_no");
						}
										
						if(rs !=null) rs.close();
						if(pstmt !=null) pstmt.close();
					}
					catch(SQLException ex)
					{
						result = false;
						sb.append("Exception while getting value for bed_booking_ref_no from ip_bed_booking  :"+ex.toString());
						ex.printStackTrace();
					}


					if (bed_booking_ref_no != null)
					{
						sbSql.delete(0, sbSql.length());
						sbSql.append("  delete from ip_bed_booking where facility_id='"+facilityId+"' and booking_type='T' and bed_booking_ref_no='"+bed_booking_ref_no+"' ");
						
						pstmt = con.prepareStatement(sbSql.toString());
						try
						{
							res = pstmt.executeUpdate() ;

							if(res>0)
								result = true;
							else
							{
								result = false;
								sb.append("Error while deleting ip_bed_booking");
							}
							if(pstmt!=null)pstmt.close();	
						}
						catch(Exception ex)
						{
							result = false;
							sb.append("Exception while deleting record in ip_bed_booking  :"+ex.toString());
							ex.printStackTrace();
						}
					}
				}
				
			}

			if (result)
			{
				if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
				sbSql.append("select informed_to,informed_name,to_char(informed_date_time,'dd/mm/yyyy hh:mi:ss AM') informed_date_time from ip_adt_trn where facility_id ='"+facilityId+"' and encounter_id='"+encounterid+"' and srl_no = (select max(srl_no)-1 from ip_adt_trn where facility_id ='"+facilityId+"' and encounter_id='"+encounterid+"')");

				try
				{
					if(rs !=null) rs.close();if(pstmt != null)pstmt.close();
					pstmt = con.prepareStatement( sbSql.toString() );
					rs = pstmt.executeQuery() ;
					if(rs!=null && rs.next())
					{
						informed_to			= rs.getString("informed_to");
						informed_name		= rs.getString("informed_name");
						informed_date_time	= rs.getString("informed_date_time");
					}
									
					if(rs !=null) rs.close();
					if(pstmt !=null) pstmt.close();
				}
				catch(SQLException ex)
				{
					result = false;
					sb.append("Exception while getting details from ip_adt_trn  :"+ex.toString());
					ex.printStackTrace();
				}

				sbSql.delete(0, sbSql.length());
				sbSql.append(" update pr_encounter set ");
				sbSql.append(" attend_practitioner_id = ? , specialty_code=?, assign_care_locn_type=?, ");
				sbSql.append(" assign_care_locn_code=?, assign_room_num=? , assign_bed_num = ?, SUBSERVICE_CODE = ?, SERVICE_CODE = ?, INFORMED_TO = ?, INFORMED_NAME = ?, INFORMED_DATE_TIME= to_date(?, 'dd/mm/rrrr hh:mi:ss AM'), assign_bed_class_code = ?,ASSIGN_BED_TYPE_CODE=?,PAT_CURR_LOCN_TYPE=?,PAT_CURR_LOCN_CODE=?,PAT_TRN_TIME=sysdate, ROOM_TEL_EXT_NUM = ?  ");//pat_trn_time
				
				if(reservedYn.equals("Y"))
					sbSql.append(" , RESERVED_NURS_UNIT_CODE = null , RESERVED_ROOM_NO= null, RESERVED_BED_NO=null ");
		
				sbSql.append(" , modified_by_id = ? , modified_date = sysdate, modified_at_ws_no=? ,modified_facility_id = ? ");
				sbSql.append(" where facility_id=? and encounter_id = ? ");

				pstmt = con.prepareStatement( sbSql.toString());
				pstmt.setString	( 1, frm_pract ) ;
				pstmt.setString	( 2, frm_spec_code ) ;
				pstmt.setString	( 3, locn_type ) ;
				pstmt.setString	( 4, frmNursCode ) ;
				pstmt.setString	( 5, frmRoomNo ) ;
				pstmt.setString	( 6, frmBedNo ) ;
				pstmt.setString	( 7, frm_sub_serv_code ) ;
				pstmt.setString	( 8, frm_serv_code ) ;
				
				pstmt.setString	( 9, informed_to ) ;
				pstmt.setString	( 10, informed_name ) ;
				pstmt.setString	( 11, informed_date_time ) ;
				
				pstmt.setString	( 12, frm_bed_cls_code ) ;
				pstmt.setString	( 13, frm_bed_type_code ) ;
				pstmt.setString	( 14, locn_type ) ;
				pstmt.setString	( 15, frmNursCode ) ;
				pstmt.setString	( 16, ext_num ) ;
				
				pstmt.setString	(17, addedById ) ;
				pstmt.setString	(18, addedAtWorkstation ) ;
				pstmt.setString	(19, facilityId ) ;
				pstmt.setString	(20, facilityId ) ;
				pstmt.setLong	(21, encounterid ) ;

				try
				{
					res=0;
					res = pstmt.executeUpdate() ;
					if(res>0 )  result = true; else result = false;
					if(pstmt!=null)pstmt.close();

				}catch(Exception ex)
				{
					result = false;
					ex.printStackTrace();
				}
			}
			
			if(result)
			{
				if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
				sbSql.append("select Count(*) count from pr_porterage_details where facility_id='"+facilityId+"' and encounter_id='"+encounterid+"'  and adt_srl_no='"+srlNo+"'");

				int count = 0;
				try
				{
					if(rs !=null) rs.close();if(pstmt != null)pstmt.close();
					pstmt = con.prepareStatement( sbSql.toString() );
					rs = pstmt.executeQuery() ;
					if(rs!=null && rs.next())
					{
						count = rs.getInt("count"); 
					}
									
					if(rs !=null) rs.close();
					if(pstmt !=null) pstmt.close();
				}
				catch(SQLException ex)
				{
					result = false;
					sb.append("Exception while taking count from pr_porterage_details  :"+ex.toString());
					ex.printStackTrace();
				}
				
				if (count > 0)
				{
					if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
					sbSql.append(" delete from pr_porterage_details where facility_id=? and encounter_id=?  and adt_srl_no=? ");

					res = 0;
					pstmt = con.prepareStatement(sbSql.toString());
					pstmt.setString	( 1, facilityId) ;
					pstmt.setLong	( 2, encounterid);
					pstmt.setString	( 3, srlNo);
													
					try{	
						res = pstmt.executeUpdate() ;
						if(res>0)
							result = true;
						else
						{
							result = false;
							sb.append("Error while deleting pr_porterage_details");
						}
						if(pstmt!=null)pstmt.close();
									
					}
					catch(Exception exc)
					{
						result = false;
						exc.printStackTrace();
						sb.append("error while updating into pr_porterage_details " +exc.getMessage());
					}
				}
			}


			if(result)
			{
				int count = 0;
				try
				{
					if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
					if(pstmt != null) pstmt.close();
					
					sbSql.append(" update IP_OPEN_ENCOUNTER set ");
					sbSql.append(" TFR_REQ_STATUS = '', ");
					sbSql.append(" modified_by_id = ?, ");
					sbSql.append(" modified_at_ws_no = ?, modified_date = sysdate, ROOM_TEL_EXT_NUM = ?,modified_facility_id = ? ");
					sbSql.append(" where ");
					sbSql.append(" facility_id = ? and encounter_id = ?");
					
					pstmt = con.prepareStatement(sbSql.toString());
					pstmt.setString(1, addedById);
					pstmt.setString(2, addedAtWorkstation);
					pstmt.setString(3, ext_num);
					pstmt.setString(4, facilityId); 
					pstmt.setString(5, facilityId);
					pstmt.setLong(6, encounterid);
					
					count = pstmt.executeUpdate();
					if(count > 0)
						result = true;
					else
						result = false;
					if(pstmt != null)
							pstmt.close();

				}catch(Exception ex)
				{
					result = false;
					sb.append("error while updating into ip_open_encounter " + ex.getMessage());
					ex.printStackTrace(System.out);
				}
			}

			if(result)
			{
				
				if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
				sbSql.append(" delete from ip_transfer_request where facility_id=? and encounter_id=?  and tfr_req_ref_no=? ");

				res = 0;
				pstmt = con.prepareStatement(sbSql.toString());
				pstmt.setString	( 1, facilityId) ;
				pstmt.setLong	( 2, encounterid);
				pstmt.setString	( 3, tfrReqRefNo);
													
				try{	
					res = pstmt.executeUpdate() ;
					if(res>0)
						result = true;
					else
						result = false;
					if(pstmt!=null)pstmt.close();
				}
				catch(Exception ex)
				{
					result = false;
					sb.append("error while updating into ip_transfer_request " + ex.getMessage());
					ex.printStackTrace(System.out);
				}
			}	

			
				
		}

		/*common for both PatientIn and Emergency transfer*/
		
		try
		{
			if(result)
			{					  							 
			
				sbSql.delete(0, sbSql.length());
				sbSql.append(" update ip_nursing_unit set num_of_beds_occupied = num_of_beds_occupied +1, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' where facility_id = ? and nursing_unit_code = ? ");
				pstmt = con.prepareStatement(sbSql.toString());
									
				pstmt.setString	( 1, facilityId);
				pstmt.setString	( 2, frmNursCode ) ;

				int res2 = pstmt.executeUpdate() ;
				if(pstmt != null)pstmt.close();
				
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									 
				sbSql.append(" update ip_nursing_unit set num_of_beds_occupied = num_of_beds_occupied -1, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' where facility_id = ? and nursing_unit_code = ? ");
				pstmt = con.prepareStatement(sbSql.toString());
									
				pstmt.setString	( 1, facilityId);
				pstmt.setString	( 2, toNursCode) ;
				
				res2 = pstmt.executeUpdate() ;
				if(res2>0 )  result = true; else result = false;
				if(pstmt != null)	pstmt.close();

			}
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
			result = false;
			sb.append("Exception while updating ip_nursing_unit table : " + e1);
		}
		
		

		try
		{
			if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
			sbSql.append(" select sex from mp_patient where patient_id = '"+patientid+"' ");
			pstmt = con.prepareStatement(sbSql.toString());
			rs  = pstmt.executeQuery();
			if(rs.next())
			{
				patientgender = rs.getString("sex") == null ? "" : rs.getString("sex");
			}
			if(rs !=null) rs.close(); 
			if(pstmt !=null) pstmt.close();

			int L_male_count = 0;
			int L_female_count = 0;
			int L_unknown_count = 0;

			if(patientgender.equals("M")) L_male_count = 1;
			if(patientgender.equals("F")) L_female_count = 1;
			if(patientgender.equals("U")) L_unknown_count = 1;
			
			if(!frmRoomNo.equals(toRoomNo))
			{
				if(result)
				{

					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					
					sbSql.append(" update ip_nursing_unit_room set occ_male_bed_count=occ_male_bed_count+?,occ_female_bed_count=occ_female_bed_count+?,occ_unknown_bed_count=occ_unknown_bed_count+?,modified_by_id = ? , modified_date = sysdate ,modified_at_ws_no = ? , modified_facility_id = ?  where facility_id=? and nursing_unit_code = ? and room_no = ? ");

					pstmt = con.prepareStatement(sbSql.toString());

					pstmt.setInt	( 1, L_male_count ) ;
					pstmt.setInt	( 2, L_female_count);
					pstmt.setInt	( 3, L_unknown_count);									
					
					pstmt.setString	( 4, addedById);
					pstmt.setString	( 5, addedAtWorkstation);
					pstmt.setString	( 6, facilityId);
										
					pstmt.setString	( 7, facilityId);
					pstmt.setString	( 8, frmNursCode ) ;
					pstmt.setString	( 9, frmRoomNo ) ;
					int res3 = pstmt.executeUpdate() ;
					if(res3>0 )  result = true; else result = false;

				}
				if(pstmt != null)pstmt.close();

				if(result)
				{
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
												
							
					sbSql.append(" update ip_nursing_unit_room set occ_male_bed_count = occ_male_bed_count-?, occ_female_bed_count = occ_female_bed_count-?, occ_unknown_bed_count = occ_unknown_bed_count-?,modified_by_id = ? , modified_date = sysdate ,modified_at_ws_no = ? , modified_facility_id = ?  where facility_id=? and nursing_unit_code = ? and room_no = ? ");
					pstmt = con.prepareStatement(sbSql.toString());

					pstmt.setInt	( 1, L_male_count ) ;
					pstmt.setInt	( 2, L_female_count);
					pstmt.setInt	( 3, L_unknown_count);										
							
					pstmt.setString	( 4, addedById);
					pstmt.setString	( 5, addedAtWorkstation);
					pstmt.setString	( 6, facilityId);
												
					pstmt.setString	( 7, facilityId);
					pstmt.setString	( 8, toNursCode ) ;
					pstmt.setString	( 9, toRoomNo ) ;
					int ress3=0;

					ress3 = pstmt.executeUpdate();
					if(ress3>0 )  result = true; else result = false;
					if(pstmt != null)pstmt.close();
					
				}

			}
		
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
			result = false;
			sb.append("Exception while updating ip_nursing_unit_room table : " + e1);
		}


		try
		{
			
			if(result)
			{	

				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append("select transfer_wo_delink_yn,deactivate_pseudo_bed_yn from ip_param where FACILITY_ID='"+facilityId+"' ");
							
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
				pstmt = con.prepareStatement( sbSql.toString() );
				rs	= pstmt.executeQuery();

				if(rs.next())
				{
					transfer_wo_delink_yn = (rs.getString("transfer_wo_delink_yn") == null) ? "" : rs.getString("transfer_wo_delink_yn");
					deactivate_pseudo_bed_yn = (rs.getString("deactivate_pseudo_bed_yn") == null) ? "" : rs.getString("deactivate_pseudo_bed_yn");
				}

				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
				
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append("select mothers_patient_id from ip_nursing_unit_bed where facility_id='"+facilityId+"' and nursing_unit_code = '"+toNursCode+"' and main_bed_no = '"+toBedNo+"' ");
							
				pstmt = con.prepareStatement( sbSql.toString() );
				rs	= pstmt.executeQuery();

				if(rs.next())
				{
					mothers_patient_id = (rs.getString("mothers_patient_id") == null) ? "" : rs.getString("mothers_patient_id");
				}

				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();

				if( !mothers_patient_id.equals("") && mothers_patient_id.equals(patientid) )
					chkForBabyBed = "Y";
				
				if(chkForBabyBed.equals("Y") && transfer_wo_delink_yn.equals("Y")){ 
									
					if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
									
					sbSql.append("SELECT OCCUPYING_PATIENT_ID FROM ip_nursing_unit_bed WHERE facility_id = ? AND nursing_unit_code = ? AND mothers_patient_id = ?");
					pstmt = con.prepareStatement(sbSql.toString());
					pstmt.setString	( 1, facilityId ) ;
					pstmt.setString	( 2, toNursCode );
					pstmt.setString	( 3, patientid) ;
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						babyPatientId.add(rs.getString("OCCUPYING_PATIENT_ID"));
						babyCount++;
					}
					if(rs !=null) rs.close(); if(pstmt !=null) pstmt.close();

								
					if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
					
					sbSql.append("SELECT bed_no FROM ip_nursing_unit_bed WHERE facility_id = ? AND nursing_unit_code = ? AND main_bed_no = ? AND current_status = 'A' order by bed_no asc");
									
					pstmt = con.prepareStatement(sbSql.toString());
					pstmt.setString	( 1, facilityId ) ;
					pstmt.setString	( 2, frmNursCode);
					pstmt.setString	( 3, frmBedNo) ;
					
					rs = pstmt.executeQuery();
					
					while(rs.next() && transferBabyCount<babyCount)
					{
						babyBedNo.add(rs.getString("bed_no")) ;
						transferBabyCount++;
					}
					
					if(rs !=null) rs.close(); if(pstmt !=null) pstmt.close();
					
				}
								
				if(result)
				{
					 
					sbSql.delete(0,sbSql.length());
					sbSql.append(" update ip_nursing_unit_bed set ");
					sbSql.append("occupying_patient_id = ? ");
					sbSql.append(", occupied_until_date_time = ? ");	
					sbSql.append(", current_status = 'A', modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ?");
					sbSql.append(" where facility_id = ? and nursing_unit_code = ? and"); 
					sbSql.append(" bed_no = ? ");
					
					pstmt = con.prepareStatement(sbSql.toString());
					pstmt.setString	( 1, null ) ;
					pstmt.setString	( 2, null ) ;
					pstmt.setString	( 3, facilityId);
					pstmt.setString	( 4, addedById) ;
					pstmt.setString	( 5, addedAtWorkstation) ;
					pstmt.setString	( 6, facilityId);		
					pstmt.setString	( 7, toNursCode ) ;
					pstmt.setString	( 8, toBedNo ) ;
					
					int rres4 = pstmt.executeUpdate() ;
					if(rres4>0 )  result = true; else result = false;
					if(pstmt!=null)pstmt.close();

					if(chkForBabyBed.equals("Y") && result)
					{  
						rres4=0;
						if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
						sbSql.append(" update ip_nursing_unit_bed set ");
						sbSql.append(" occupying_patient_id = ?, occupied_until_date_time = ?, mothers_patient_id = ?, mothers_encounter_id = ?, current_status = 'A', modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
						sbSql.append(" where facility_id=? and nursing_unit_code = ? and main_bed_no = ?");
						
						pstmt = con.prepareStatement(sbSql.toString());
						pstmt.setString	( 1, null ) ;
						pstmt.setString	( 2, null ) ;
						pstmt.setString	( 3, null ) ;
						pstmt.setString	( 4, null ) ;
						pstmt.setString	( 5, facilityId);
						pstmt.setString	( 6, addedById) ;
						pstmt.setString	( 7, addedAtWorkstation) ;
						pstmt.setString	( 8, facilityId);		
						pstmt.setString	( 9, toNursCode ) ;
						pstmt.setString	( 10, toBedNo ) ;
						
						rres4 = pstmt.executeUpdate() ;
						if(rres4>0 )  result = true; else result = false;
						if(pstmt!=null)pstmt.close();

					}
				}
				if(result)
				{

					if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
					sbSql.append(" Select pseudo_bed_yn from ip_nursing_unit_bed WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+frmNursCode+"' And bed_no='"+frmBedNo+"' ");
					pstmt = con.prepareStatement(sbSql.toString());
					rs = pstmt.executeQuery();
									
					if(rs.next())
					{
						pseudo_bed_yn = rs.getString("pseudo_bed_yn") == null ? "" : rs.getString("pseudo_bed_yn") ;
					}
					if(rs != null)rs.close();

					sbSql.delete(0,sbSql.length());
					sbSql.append(" update ip_nursing_unit_bed set ");
					sbSql.append(" occupying_patient_id = ?, current_status='O' ");
					sbSql.append(", modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
									
					if(deactivate_pseudo_bed_yn.equals("Y") && pseudo_bed_yn.equals("Y"))
							sbSql.append(", psuedo_bed_status = 'U'");
					sbSql.append(" where  facility_id = ? and nursing_unit_code = ? and"); 
					sbSql.append(" bed_no = ? and occupying_patient_id is null and current_status='A' ");
								
					pstmt = con.prepareStatement(sbSql.toString());
								  
					pstmt.setString	( 1, patientid ) ;
					pstmt.setString	( 2, facilityId);
					pstmt.setString	( 3, addedById) ;
					pstmt.setString	( 4, addedAtWorkstation) ;
									
					pstmt.setString	( 5, facilityId);
					pstmt.setString	( 6, frmNursCode ) ;
					pstmt.setString	( 7, frmBedNo ) ;
					int res4 = pstmt.executeUpdate() ;
			
					if(res4>0 ){ 
						result = true;
					}else{ 
						result = false;
					}
				}

				if(pstmt != null)pstmt.close();
								
				if(chkForBabyBed.equals("Y") && result && transfer_wo_delink_yn.equals("Y")){
				try {
					for(int bcount=0;bcount<babyPatientId.size();bcount++){
											
						if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
											
						sbSql.append(" update ip_nursing_unit_bed set ");
						sbSql.append(" mothers_patient_id=?,mothers_encounter_id=?,current_status='O',occupying_patient_id = ?,modified_date=sysdate,modified_facility_id=?,modified_by_id=?,modified_at_ws_no=? ");
						sbSql.append(" where facility_id=? and nursing_unit_code =?  and main_bed_no=? and bed_no=?");
											
						pstmt=con.prepareStatement(sbSql.toString());
											
						pstmt.setString	( 1, patientid); //Mother Patient id
						pstmt.setString	( 2, encounter_id); // Mother Encounter id
						pstmt.setString	( 3, babyPatientId.get(bcount)); // Baby Patient Id
						pstmt.setString	( 4, facilityId);
						pstmt.setString	( 5, addedById) ;
						pstmt.setString	( 6, addedAtWorkstation);
						pstmt.setString	( 7, facilityId);
						pstmt.setString	( 8, frmNursCode);//Mother Nursing nuit
						pstmt.setString	( 9, frmBedNo);  //Mother bed no
						pstmt.setString	( 10, babyBedNo.get(bcount));  //Baby bed no
						int res4 = pstmt.executeUpdate() ;
						if(pstmt !=null) pstmt.close();
							if(res4 > 0) result = true; else result = false;
						}
				} catch (Exception ex) {
					result = false;
					sb.append("Exception in updating ip_nursing_unit_bed while updating the source baby beds : "+ex.toString());
					ex.printStackTrace();
				}	
				}
	
			}
		}
		catch (SQLException ex)
		{
			result = false;
			sb.append("Exception while updating ip_nursing_unit_bed table :"+ex.toString());
			ex.printStackTrace();
		}
		
		if(chkForBabyBed.equals("Y") && result && transfer_wo_delink_yn.equals("Y")){
			if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								
			try {
				sbSql.append(" update ip_open_encounter set ");
				sbSql.append("BABY_DELINKED_YN='N' ");
				sbSql.append(", modified_by_id = ? ,modified_at_ws_no = ?, modified_date = sysdate,modified_facility_id = ? ");
				sbSql.append(" where facility_id=? and ENCOUNTER_ID = ?");
				pstmt = con.prepareStatement(sbSql.toString());
				pstmt.setString	( 1, addedById) ;
				pstmt.setString	( 2, addedAtWorkstation);
				pstmt.setString	( 3, facilityId);
				pstmt.setString	( 4, facilityId);
				pstmt.setString	( 5, encounter_id); //mother encounter id
				int res4 = pstmt.executeUpdate() ;
				if(pstmt !=null) pstmt.close();
					if(res4 > 0) result = true; else result = false;
			} catch (Exception ex) {
				result = false;
				sb.append("Exception in updating ip_open_encounter while relinking the mother and baby bed : "+ex.toString());
				ex.printStackTrace();
			}
		}
		
		try
		{
			if(result)
			{
				if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
			
				sbSql.append("  update IP_ADT_TRN set trn_to_date_time = null ");
				
				/*if(is_reserved_bed_checked!=null && is_reserved_bed_checked.equals("Y") && confirm_yn!=null && confirm_yn.equals("N"))*/

				sbSql.append("  , RESERVED_YN = 'N' ");

				sbSql.append(", modified_by_id = '" + addedById  + "', modified_date = sysdate, modified_facility_id = '");
				sbSql.append( facilityId +"', modified_at_ws_no = '"+ addedAtWorkstation +"'");
				sbSql.append("  where srl_no = ("+srlNo+" - 1) and facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' ");

				if(pstmt !=null) pstmt.close();
				pstmt = con.prepareStatement(sbSql.toString());
				pstmt.executeUpdate();
				if(pstmt !=null) pstmt.close();
			}
		}catch(Exception ex)
		{
			result = false;
			sb.append("Exception in updating IP_ADT_TRN trn_to_date_time :"+ex.toString());
			ex.printStackTrace();
		}
						
		try
		{
			if (result)
			{
				if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
				sbSql.append(" select TO_CHAR(trn_date_time,'dd/mm/yyyy hh:mi:ss AM') trn_date_time from ip_adt_trn where facility_id='"+facilityId+"' and encounter_id='"+encounterid+"' and srl_no ='"+srlNo+"' ");

				try
				{
					if(rs !=null) rs.close();if(pstmt != null)pstmt.close();
					pstmt = con.prepareStatement( sbSql.toString() );
					rs = pstmt.executeQuery() ;
					if(rs!=null && rs.next())
					{
						trn_date_time			= rs.getString("trn_date_time");
					}
									
					if(rs !=null) rs.close();
					if(pstmt !=null) pstmt.close();
				}
				catch(SQLException ex)
				{
					result = false;
					sb.append("Exception while getting details from ip_adt_trn  :"+ex.toString());
					ex.printStackTrace();
				}

			}
			if(result)
			{					  							 
			
				sbSql.delete(0, sbSql.length());
				sbSql.append(" delete from ip_adt_trn where facility_id=? and encounter_id=? and srl_no=? ");
				
				pstmt = con.prepareStatement(sbSql.toString());
									
				pstmt.setString	( 1, facilityId);
				pstmt.setLong	( 2, encounterid) ;
				pstmt.setString	( 3, srlNo) ;

				res = pstmt.executeUpdate() ;

				if(res>0)
					result = true;
				else
				{
					result = false;
					sb.append("Error while deleting ip_adt_trn");
				}
				if(pstmt!=null)pstmt.close();
				

				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									 
				sbSql.append(" update ip_cncl_trn_log set cancel_trf_reason=?, trf_cancelled_by_id=? where facility_id=? and encounter_id=? and trn_date_time=TO_DATE (?, 'dd/mm/yyyy hh:mi:ss AM') ");
				pstmt = con.prepareStatement(sbSql.toString());
									
				pstmt.setString	( 1, cancel_reason);
				pstmt.setString	( 2, addedById);
				pstmt.setString	( 3, facilityId);
				pstmt.setLong	( 4, encounterid);
				pstmt.setString	( 5, trn_date_time);
				
				res = pstmt.executeUpdate() ;

				if(res>0 )  result = true; else result = false;
				if(pstmt != null)	pstmt.close();
			}
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
			result = false;
			sb.append("Exception while deleting ip_adt_trn and updating ip_cncl_trn_log table : " + e1);
		}
	

		if (result)
		{
			if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());

			sbSql.append(" select install_yn from sm_module where module_id = 'FM' ");
			String fm_install_yn="";
			String transfer_file_yn="";
			String auto_rec_ward_yn="";
			String auto_file_transfer_yn="";
			String fm_fs_locn_code="";
			String to_fs_locn_code="";
			String fm_locn_identity="";
			String file_no="";
			String curr_file_status="";
			String volume_no="";
			String iss_date_time="";
			String prev_sent_date_time="";
			String prev_src_fs_locn_code="";
			String prev_src_facility_id="";
			String perm_fs_locn_code="";
			String ret_date="";
			String duration_type="";
			String rec_date_time="";
			String src_locn_identity="";
			String src_user_id="";
			String src_fs_locn_code="";
			String src_facility_id="";

			int no_of_dh_to_return_ip=0;
			int parameter_hours		= 0;
							

			pstmt = con.prepareStatement(sbSql.toString());
			rs   = pstmt.executeQuery();
			if (rs!=null && rs.next())
				fm_install_yn = rs.getString(1);
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if (fm_install_yn.equals("Y"))
			{
				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append("Select auto_rec_ward_yn, transfer_file_yn from fm_parameter  where facility_id =?");
				pstmt = con.prepareStatement(sbSql.toString());
				pstmt.setString	( 1, facilityId ) ;
				rs = pstmt.executeQuery() ;
				if (rs!=null && rs.next()){
					auto_rec_ward_yn  = rs.getString(1);
					transfer_file_yn = rs.getString(2);
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();

				if (transfer_file_yn.equals("Y"))
				{
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					sbSql.append("Select a.auto_file_transfer_yn, a.fs_locn_code, b.locn_identity, b.duration_type, b.no_of_dh_to_return_ip from ip_nursing_unit a, fm_storage_locn b where a.facility_id = b.facility_id and a.fs_locn_code = b.fs_locn_code and a.facility_id =? and a.nursing_unit_code=? ");
					try
					{
						pstmt = con.prepareStatement(sbSql.toString());
						pstmt.setString	( 1, facilityId ) ;
						pstmt.setString	( 2, frmNursCode ) ;
										
						rs = pstmt.executeQuery();

						if (rs!=null && rs.next()){
							auto_file_transfer_yn = rs.getString(1);
							fm_fs_locn_code		  = rs.getString(2);
							fm_locn_identity	  = rs.getString(3);
							duration_type		  = rs.getString(4);
							no_of_dh_to_return_ip = Integer.parseInt(rs.getString(5)==null?"0":rs.getString(5));
							if (fm_fs_locn_code==null) fm_fs_locn_code="";

							if(duration_type.equals("D"))
							{
								parameter_hours = no_of_dh_to_return_ip * 24;
							}
							else
							{
								parameter_hours = no_of_dh_to_return_ip;	
							}
						}
										
					}
					catch(Exception exc)
					{
						result = false;
						exc.printStackTrace();
					}

					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();

										
					if (auto_file_transfer_yn.equals("Y")&&fm_fs_locn_code!=""){
						
						if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
						sbSql.append("Select a.fs_locn_code from ip_nursing_unit a, fm_storage_locn b where a.facility_id = b.facility_id and a.fs_locn_code = b.fs_locn_code and a.facility_id =? and a.nursing_unit_code=? ");
						
						try
						{
							pstmt = con.prepareStatement(sbSql.toString());
							pstmt.setString	( 1, facilityId ) ;
							pstmt.setString	( 2, toNursCode ) ;

							rs = pstmt.executeQuery() ;
							if (rs!=null && rs.next()){
								to_fs_locn_code  = rs.getString(1);
						}
						}
						catch(Exception exc)
						{
							result = false;
							exc.printStackTrace();
						}
						
						if(rs!=null)rs.close();
						if(pstmt!=null)pstmt.close();
						
						
						if (to_fs_locn_code!="")
						{
							if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.append("select  a.file_no, a.volume_no, to_char(a.iss_date_time,'dd/mm/yyyy hh:mi:ss AM') iss_date_time, a.perm_fs_locn_code from  fm_curr_locn a, fm_storage_locn b, fm_narration c where a.facility_id = ? and a.patient_id = ? and a.volume_status='A' and a.curr_file_status = 'O' and a.curr_fs_locn_code = ?  and a.facility_id = b.facility_id and a.curr_fs_locn_code = b.fs_locn_code and b.narration_code = c.narration_code (+) and a.curr_locn_id = ? ");													
							
							pstmt = con.prepareStatement(sbSql.toString());
							pstmt.setString	( 1, facilityId ) ;
							pstmt.setString	( 2, patientid) ;
							pstmt.setString	( 3, to_fs_locn_code ) ;
							pstmt.setString	( 4, toNursCode ) ;

							rs = pstmt.executeQuery() ;
			
							if (rs!=null && rs.next()){

								file_no			= rs.getString(1);
								volume_no		= rs.getString(2);
								iss_date_time	= rs.getString(3);
								perm_fs_locn_code	= rs.getString(4);
								if (file_no==null) file_no="";

							}
							if(rs!=null)rs.close();
							if(pstmt!=null)pstmt.close();

							if(fm_fs_locn_code.equals(perm_fs_locn_code))
								curr_file_status = "I";
							else 
								curr_file_status = "O";

							if(!file_no.equals(""))
							{
								if ((volume_no==null) ||(volume_no.equals("")))
									volume_no="1";

								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.append(" SELECT src_facility_id, src_fs_locn_code, src_locn_identity,src_user_id, to_char(rec_date_time,'dd/mm/yyyy hh:mi:ss AM') rec_date_time FROM fm_movement_log WHERE sent_date_time = (SELECT MAX (sent_date_time) FROM fm_movement_log WHERE facility_id = ? AND file_no = ?) ");

								try{

									pstmt = con.prepareStatement(sbSql.toString());
									pstmt.setString	( 1, facilityId) ;
									pstmt.setString	( 2, file_no);
									//pstmt.setString	( 3, volume_no);
									//pstmt.setString	( 4, iss_date_time) ;
									rs = pstmt.executeQuery() ;

									if (rs!=null && rs.next()){
										src_facility_id			= rs.getString(1);
										src_fs_locn_code		= rs.getString(2);
										src_locn_identity		= rs.getString(3);
										src_user_id				= rs.getString(4);
										rec_date_time			= rs.getString(5);
										if (file_no==null) file_no="";

									}
									if(rs!=null)rs.close();
									if(pstmt!=null)pstmt.close();

									if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									sbSql.append("SELECT to_char(sent_date_time,'dd/mm/yyyy hh:mi:ss AM') sent_date_time, src_facility_id, src_fs_locn_code FROM fm_movement_log WHERE sent_date_time = (SELECT MAX (sent_date_time) FROM fm_movement_log WHERE facility_id = ? AND file_no = ? AND volume_no = ? and dest_facility_id=? AND dest_fs_locn_code = ?)");

									res = 0;
									pstmt = con.prepareStatement(sbSql.toString());
									pstmt.setString	( 1, facilityId) ;
									pstmt.setString	( 2, file_no);
									pstmt.setString	( 3, volume_no);
									pstmt.setString	( 4, src_facility_id) ;
									pstmt.setString	( 5, src_fs_locn_code) ;

									rs = pstmt.executeQuery() ;
									if (rs!=null && rs.next()){
										prev_sent_date_time		= rs.getString(1);//to get the from location's file issue date
										prev_src_facility_id	= rs.getString(2);
										prev_src_fs_locn_code	= rs.getString(3);
									}
									if(rs!=null)rs.close();
									if(pstmt!=null)pstmt.close();
										
								}
								catch(Exception exc)
								{
									result =false;
									exc.printStackTrace();
									sb.append(exc.getMessage());
								}
								
								
								if(prev_sent_date_time.equals(""))
									prev_sent_date_time = iss_date_time;

								if(parameter_hours==0)
									ret_date=null;
								else
								{
									if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									sbSql.append("Select to_char(to_date(?,'dd/mm/yyyy hh:mi:ss AM')+"+(parameter_hours)+"/24,'dd/mm/yyyy hh:mi:ss AM') from dual ");
									pstmt = con.prepareStatement(sbSql.toString());
									pstmt.setString	(1, prev_sent_date_time) ;
									try
									{
										rs = pstmt.executeQuery() ;
										if (rs!=null && rs.next()){
											ret_date  = rs.getString(1);
									}
									}
									catch(Exception exc)
									{
										result = false;//noted
										exc.printStackTrace();
									}
									
									if(rs!=null)rs.close();
									if(pstmt!=null)pstmt.close();
								}
								

								if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
								sbSql.append("Select count(*) count FROM fm_movement_log WHERE facility_id = ? AND file_no = ? AND volume_no = ? AND sent_date_time= TO_DATE (?, 'dd/mm/yyyy hh:mi:ss AM') ");	
										
								int fmMovemntLogcount = 0;
								try
								{
								
									pstmt = con.prepareStatement(sbSql.toString());
									pstmt.setString	( 1, facilityId) ;
									pstmt.setString	( 2, file_no);
									pstmt.setString	( 3, volume_no);
									pstmt.setString	( 4, iss_date_time) ;
									
									rs = pstmt.executeQuery() ;
									if (rs!=null && rs.next()){
										fmMovemntLogcount  = rs.getInt(1);
									}	
								}
								catch(Exception exc)
								{
									result = false;
									exc.printStackTrace();
									sb.append(exc.getMessage());
								}
								if(rs!=null)rs.close();
								if(pstmt!=null)pstmt.close();

								if (fmMovemntLogcount > 0)
								{
									if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									sbSql.append("Delete FROM fm_movement_log WHERE facility_id = ? AND file_no = ? AND volume_no = ? AND sent_date_time= TO_DATE (?, 'dd/mm/yyyy hh:mi:ss AM') ");	
											
									try{
										
										res = 0;
										pstmt = con.prepareStatement(sbSql.toString());
										pstmt.setString	( 1, facilityId) ;
										pstmt.setString	( 2, file_no);
										pstmt.setString	( 3, volume_no);
										pstmt.setString	( 4, iss_date_time) ;
										
										res = pstmt.executeUpdate() ;
														
										if(res>0)
											result = true;
										else
										{
											result = false;
											sb.append("Error while deleting fm_movement_log");
										}
										if(pstmt!=null)pstmt.close();
											
									}
									catch(Exception exc)
									{
										result = false;
										exc.printStackTrace();
										sb.append(exc.getMessage());
									}
								}
										
			                    boolean siteSpecific=CommonBean.isSiteSpecific(con,"FM","CURRENT_FS_LOCATION");

								if (result && !siteSpecific){


									if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
									sbSql.append("update fm_curr_locn set iss_date_time=to_date(?,'dd/mm/yyyy hh:mi:ss AM'), curr_facility_id =?, curr_file_status=?, curr_fs_locn_code=?, curr_fs_locn_identity=?, curr_holder_user_id=?, last_movement_date_time=to_date(?,'dd/mm/yyyy hh:mi:ss AM'), return_date_time=to_date(?,'dd/mm/yyyy hh:mi:ss AM'),");
													
													 
									/*if (!(curr_file_status.equals("O")))*/
										sbSql.append("prev_facility_id=?,prev_fs_locn_code=?,");

									sbSql.append("mr_locn_yn='Y', modified_by_id=?, modified_date=sysdate, modified_at_ws_no=?, modified_facility_id = ? , curr_locn_id = ? where facility_id = ? and file_no =? and volume_no=?");
									
									try
									{
										pstmt = con.prepareStatement(sbSql.toString());
										int inc=1;
										res = 0;
										pstmt.setString	( inc++, prev_sent_date_time) ;//previous sent_date_time
										pstmt.setString	( inc++,  src_facility_id) ;

										pstmt.setString	( inc++,  curr_file_status);//
										pstmt.setString	( inc++,  src_fs_locn_code) ;
										pstmt.setString	( inc++,  src_locn_identity) ;
										pstmt.setString	( inc++,  src_user_id) ;
										pstmt.setString	( inc++,  rec_date_time) ;
										pstmt.setString	( inc++,  ret_date) ;//   
														
											
										//if (!curr_file_status.equals("O")){
											pstmt.setString	( inc++,  prev_src_facility_id) ;
											pstmt.setString	( inc++,  prev_src_fs_locn_code) ;
										//}
														
										pstmt.setString	( inc++, addedById) ;
										pstmt.setString	( inc++, addedAtWorkstation) ;
										pstmt.setString	( inc++, facilityId) ;
										pstmt.setString	( inc++, frmNursCode) ;										
										pstmt.setString	( inc++, facilityId) ;
										pstmt.setString	( inc++, file_no) ;
												
										pstmt.setString	( inc++, volume_no) ;
										
										res = pstmt.executeUpdate() ;
										if(res>0 )  
											result = true; 
										else 
											result = false;
											
									}
									catch(Exception exc)
									{
										result = false;
										exc.printStackTrace();
										sb.append(exc.getMessage());
									}
									if(pstmt!=null)pstmt.close();
								}
									
								if (result)
								{
									int count=0;
									try {
										
										if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
										sbSql.append("Select count(*) count from fm_transit_file where facility_id=? and file_no=? and volume_no=? ");
														
										try
										{
											pstmt = con.prepareStatement(sbSql.toString());
											pstmt.setString	( 1,  facilityId) ;
											pstmt.setString	( 2,  file_no);
											pstmt.setString	( 3,  volume_no);

											rs = pstmt.executeQuery() ;

											if (rs!=null && rs.next()){
												count  = rs.getInt("count");
											}
										}
										catch(Exception exc)
										{
											result = false;
											exc.printStackTrace();
										}
										
										if(rs!=null)rs.close();
										if(pstmt!=null)pstmt.close();

								
										
										if (count > 0)
										{
											if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());	
														
											sbSql.append("delete from fm_transit_file where facility_id=? and file_no=? and volume_no=?");
											pstmt = con.prepareStatement(sbSql.toString());

											res = 0;
											pstmt.setString	( 1,  facilityId) ;
											pstmt.setString	( 2,  file_no);
											pstmt.setString	( 3,  volume_no);
															
											try{
												res = pstmt.executeUpdate() ;
											}
											catch(Exception exc)
											{
												result = false;
												exc.printStackTrace();
												sb.append(exc.getMessage());
											}
											if(res>0 )  result = true; else result = false;	
											if(pstmt!=null)pstmt.close();
										}
										
									}catch(Exception e2)
									{
										result = false;
										e2.printStackTrace();
										sb.append(e2.getMessage());
									}
								}
							}
						}


					}
				}
			}
						
		}	

		if(result) 
		{  
			result = true ;
			java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED","SM" ) ;
			sb.append( (String) message.get("message") ) ;
			message.clear();
			con.commit();
		}
	
	}catch ( Exception e ) 
	{
		result = false;
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
		   
		 }catch(Exception ce){}
		 if(con != null) ConnectionManager.returnConnection(con,p);
	}
		
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;

	hashData.clear();
	return results ;

}// end insert
} // end session bean


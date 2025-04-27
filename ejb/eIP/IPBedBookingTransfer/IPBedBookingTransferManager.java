/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used for booking bed transfer.
@version - V3
*/
package eIP.IPBedBookingTransfer; 
import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="IPBedBookingTransfer"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPBedBookingTransfer"
*	local-jndi-name="IPBedBookingTransfer"
*	impl-class-name="eIP.IPBedBookingTransfer.IPBedBookingTransferManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPBedBookingTransfer.IPBedBookingTransferLocal"
*	remote-class="eIP.IPBedBookingTransfer.IPBedBookingTransferRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPBedBookingTransfer.IPBedBookingTransferLocalHome"
*	remote-class="eIP.IPBedBookingTransfer.IPBedBookingTransferHome"
*	generate= "local,remote"
*
*
*/
public class IPBedBookingTransferManager implements SessionBean 
{
	SessionContext ctx;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context)
	{ 
		this.ctx=context;
	}

	
/**
* @ejb.interface-method
*	 view-type="both"
*/

	public java.util.HashMap ValidateIPBedBookingTransfer(java.util.Properties p, String facilityId, String tonursingunitcode)
	{	
		//Connection con				= null;
		Connection con2				= null;
		PreparedStatement pstmt		= null ;
		Statement stmt				= null;
		ResultSet 			 srs	= null;
		StringBuffer sb				= new StringBuffer("");
		StringBuffer strBuffer		= new StringBuffer();
		//String encounterid			= "";
		//String insert_val			= "";
		String patientgender		= "";
		String dateofbirth			= "";
		String locale				= "";
		//boolean report_val			= false;
		java.util.HashMap results	= new java.util.HashMap() ;
		boolean result				= true ;
		try
		{
			locale					= p.getProperty("LOCALE");
			con2					= ConnectionManager.getConnection(p);
			con2.setAutoCommit(false);
			strBuffer.delete(0, strBuffer.length());
			strBuffer.append(" SELECT age_group_code,locn_type FROM ip_nursing_unit WHERE "); strBuffer.append("facility_id='"+facilityId+"' and nursing_unit_code='"+tonursingunitcode+"' ");

			stmt = con2.createStatement();
			srs  = stmt.executeQuery(strBuffer.toString());
			if (srs.next())
			{
				String agegrpcode = srs.getString(1) == null ? "" : srs.getString(1);
				if(!agegrpcode.equals(""))
				{
					strBuffer.delete(0, strBuffer.length());
					strBuffer.append("Select '1' from am_age_group Where age_group_code='"+agegrpcode+"' ");
					strBuffer.append("And NVL(GENDER,'"+patientgender+"')= '"+patientgender+"' AND ");
					strBuffer.append("trunc(SYSDATE)- to_date('"+dateofbirth+"','dd/mm/rrrr') BETWEEN ");
					strBuffer.append("DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE ");
					stmt = con2.createStatement();
					srs  = stmt.executeQuery(strBuffer.toString());
					if(!srs.next())
					{
						result = false;
						sb     = new StringBuffer("");
						sb.delete(0, sb.length());
						java.util.Hashtable message = MessageManager.getMessage( locale, "AGE_GENDER_NOT_ALLOWED","IP" ) ;
						sb.append( (String) message.get("message") ) ;
						message.clear();
					}
				}
			}
			if(srs!=null) srs.close();
			if(stmt!=null) stmt.close();
		}
		catch(Exception e)
		{
			result  = false;
			sb.append( e.getMessage() +" Error in ValidateIPBedBookingTransfer " ) ;
			e.printStackTrace() ;
			try
			{
				con2.rollback();
			}catch(Exception e1){}
		}
		finally
		{
			try
			{	
				if(pstmt  != null)	pstmt.close();
				if(stmt   != null)	stmt.close();
				if(srs    != null)	srs.close();
			}catch(Exception ce)
			{
				ce.printStackTrace() ;	
			}
			ConnectionManager.returnConnection(con2,p);
		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString()) ;
		sb.delete(0, sb.length());
		return results ;
	}//end ValidateBedBookingTransfer

	/**
	This method is used to book a bed transfer.
	@version - V3
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/

	public java.util.HashMap insertIPBedBookingTransfer(java.util.Properties p, java.util.HashMap hashData) 
	{
		Connection con				= null;
		//Connection con2				= null;
		PreparedStatement pstmt		= null ;
		Statement stmt				= null;
		ResultSet 			 srs	= null;
		boolean report_val			= false;
		String insert_val			= "";
		String encounterid			= "";
		String patientgender		= "";
		String dateofbirth			= "";
		String facilityId			= "";
		String patientid			= "";
		String eid					= "";
		String transferdate			= "";
		String transfertype			= "";
		String topractitionerid		= "";
		String tospecialitycode		= "";
		String frpractitionerid		= "";
		String frspecialitycode		= "";
		String tonursingunitcode	= "";
		String toservicecode		= "";
		String frservicecode		= "";
		String frsubservcode		= "";
		String frbedtype			= "";
		String frbedclass			= "";
		String frroomno				= "";
		String frbedno				= "";
		String priority				= "";
		String pref_date_time		= "";
		String sub_service			= "";
		String med_team_id			= "";
		String frteamid				= "";
		String transfer_req_type	= "";
		String exp_date_time		= "";
		String ipparam_bed_yn		= "";
		String tobedtype			= "";
		String tobedclass			= "";
		String billing_group_id		= "";
		String bl_operational		= "";
		String toroomno				= "";
		String tobedno				= "";
		String cancel_code			= "";
		String blocking_type_code	= "";
		String bed_blk_period		= "";
		String blk_remark			= "";
		String frnursingunitcode	= "";
		String mother_bed_status	= "";
		String bed_change			= "";
		String oper_stn_bed_class_yn= "";
		String modified_bed_type_code = "";
		String transfer_req_status	= "";
		String addedAtWorkstation	= "";
		String locale				= "";
		String reason_for_reserved_bed	= "";
		String reqRadioBtn			  = ""; //Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
		StringBuffer sb				= new StringBuffer("");
		StringBuffer strBuffer		= new StringBuffer();
		facilityId					= (String)hashData.get("facilityId");
		patientid					= (String)hashData.get("patientid");
		eid							= (String)hashData.get("encounterid");
		transferdate				= (String)hashData.get("transferdate");
		transfertype				= (String)hashData.get("transfertype");
		topractitionerid			= (String)hashData.get("topractitionerid");
		tospecialitycode			= (String)hashData.get("tospecialitycode");
		frpractitionerid			= (String)hashData.get("frpractitionerid");
		frspecialitycode			= (String)hashData.get("frspecialitycode");
		tonursingunitcode			= (String)hashData.get("tonursingunitcode");
		toservicecode				= (String)hashData.get("toservicecode");
		frservicecode				= (String)hashData.get("frservicecode");
		frsubservcode				= (String)hashData.get("frsub_service");
		frbedtype					= (String)hashData.get("frbedtype");
		frbedclass					= (String)hashData.get("frbedclass");
		frroomno					= (String)hashData.get("frroomno");
		frbedno						= (String)hashData.get("frbedno");
		priority					= (String)hashData.get("priority");
		pref_date_time				= (String)hashData.get("pref_date_time");
		sub_service					= (String)hashData.get("sub_service");
		med_team_id					= (String)hashData.get("med_team_id");
		frteamid					= (String)hashData.get("frteamid");
		transfer_req_type			= (String)hashData.get("transfer_req_type");
		exp_date_time				= (String)hashData.get("expired_date_time");
		ipparam_bed_yn				= (String)hashData.get("ipparam_bed_yn");
		tobedtype					= (String)hashData.get("totypecode");
		tobedclass					= (String)hashData.get("tobedclass");
		billing_group_id			= (String)hashData.get("billing_group_id");
		bl_operational				= (String)hashData.get("bl_operational");
		patientgender				= (String)hashData.get("patientgender");
		dateofbirth					= (String)hashData.get("dateofbirth");

		frnursingunitcode			= (String)hashData.get("frnursingunitcode");
		mother_bed_status			= (String)hashData.get("mother_bed_status");
		bed_change					= (String)hashData.get("bed_change");
		oper_stn_bed_class_yn		= (String)hashData.get("oper_stn_bed_class_yn");
		modified_bed_type_code		= (String)hashData.get("modified_bed_type_code");
		transfer_req_status			= (String)hashData.get("transfer_req_status");
		addedAtWorkstation			= (String)hashData.get("client_ip_address");

		reqRadioBtn					= checkForNull((String)hashData.get("reqRadioBtn"));//Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866
		locale						= p.getProperty("LOCALE");
		/*
		10/9/2008  code
		*/
		//String is_reserved_bed_checked			= (String)hashData.get("is_reserved_bed_checked");
		reason_for_reserved_bed		= (String)hashData.get("reason_for_reserved_bed");
		
		//String res_bed_no						= (String)hashData.get("res_bed_no");
		//String res_room_no						= (String)hashData.get("res_room_no");
		//String res_nursing_unit					= (String)hashData.get("res_nursing_unit");
		
		//String reserve_bed_no					= (String)hashData.get("reserve_bed_no");
		//String reserve_nurs_unit_code			= (String)hashData.get("reserve_nurs_unit_code");
		//String reserve_room_no					= (String)hashData.get("reserve_room_no");
		/**/
		if(!bed_change.equals("Y"))
			bed_change = "N";
		java.util.HashMap results = new java.util.HashMap() ;
		encounterid		= eid;
		boolean result  = false ;
		Statement stmt3 = null;
		ResultSet rset2 = null;
		int Count1		= 0;
		String confirmValue = "N";
		//int srlno   = 0;

		strBuffer.delete(0, strBuffer.length());
		strBuffer.append("select count(*) encounterno from ip_transfer_request ");
		strBuffer.append(" where facility_id = '"+facilityId+"' and ");
		strBuffer.append("encounter_id = ");
		strBuffer.append("'"+encounterid+"'");
		strBuffer.append(" and tfr_req_status ");
		strBuffer.append(" NOT IN ( '2', '4', '9') and (PRIORITY_EXP_DATE is null or PRIORITY_EXP_DATE >= sysdate )");

		try
		{	
			con   = ConnectionManager.getConnection(p);
			try
			{	
				stmt3 = con.createStatement();
				rset2 = stmt3.executeQuery(strBuffer.toString());
				if(rset2 != null && rset2.next())
				{	
					Count1=rset2.getInt("encounterno");
				}
				if(rset2!=null) rset2.close();
				if(stmt3!=null) stmt3.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace() ;	
			}

			if (Count1 >0)
			{
				sb = new StringBuffer("");
				result = false;
				java.util.Hashtable message = MessageManager.getMessage( locale, "MORETHAN_ONE_BED_BOOK","IP" );
				sb.append( (String) message.get("message") );
				results.put( "status", new Boolean(result) ) ;
				results.put( "error", sb.toString() ) ;
				message.clear();
				return results;
			}
			else
			{
				sb               = new StringBuffer("");
				String addedById = p.getProperty( "login_user");
				int res			 = 0;

				HashMap ret = ValidateIPBedBookingTransfer(p, facilityId, tonursingunitcode	);

				boolean retval=((Boolean)ret.get("status")).booleanValue();
				sb.append((String)ret.get("error"));
				if(retval)
				{
					try
					{
						String bookingrefno = "";
						 insert_val = "0";
						if(bl_operational.equals("Y"))
						{	
							try
							{
								if(srs!=null) srs.close();
								if(stmt!=null) stmt.close();
								String blSql= " select BL_CHECK_ELIGIBILITY_LEVEL('"+billing_group_id+"','"+tobedtype+"') from dual ";
								stmt = con.createStatement();
								srs = stmt.executeQuery(blSql);
								if(srs != null && srs.next())
								{
									confirmValue = srs.getString(1);
								}
								if(srs!=null) srs.close();
								if(stmt!=null) stmt.close();
							}catch (Exception e)
							{ 
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

						if(retval)
						{
							StringBuffer sbSql = new StringBuffer();
							strBuffer.delete(0, strBuffer.length());
							strBuffer.append("select NVL(max(tfr_req_ref_no),0)+1 GEN_BOOKING_SRL_YN from "); 
							strBuffer.append("IP_TRANSFER_REQUEST where ");
							strBuffer.append("facility_id = '"+facilityId+"' and encounter_id= ");
							strBuffer.append(encounterid);
							stmt   = con.createStatement();
							srs = stmt.executeQuery(strBuffer.toString());
							if(srs.next())
							{
								bookingrefno = srs.getString("GEN_BOOKING_SRL_YN");
							}
							result = true;
							//Inserting into IP_BED_CLASS_REQUEST by kishore on 9/4/2004
							if(srs!=null) srs.close();
							if(stmt!=null) stmt.close();
							if(ipparam_bed_yn.equals("Y") && bed_change.equals("Y"))
							{
								int srl_no = 0;
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								sbSql.append("select nvl(MAX(srl_no),0)+1 srl_no from IP_BED_CLASS_REQUEST where facility_id = '"+facilityId+"' and encounter_id = "+encounterid+" ");
								stmt   = con.createStatement();
								srs    = stmt.executeQuery(sbSql.toString());
								if(srs.next())
								{
									srl_no = srs.getInt("srl_no");
								}
								int reset = 0;
								//insert into table ip_bed_class_request....with status is '0'
								if(sbSql.length() > 0 ) sbSql.delete(0,sbSql.length());
								sbSql.append("  insert into IP_BED_CLASS_REQUEST ");
								sbSql.append(" (facility_id,encounter_id,srl_no,patient_id,trn_type ");
								sbSql.append(" ,TRANSFER_TYPE_CODE,REQUEST_DATE,REQ_NURSING_UNIT_CODE,REQ_BED_CLASS_CODE,REQ_BED_TYPE_CODE  ");
								sbSql.append(",REQ_ROOM_NO,REQ_BED_NO,FR_NURSING_UNIT_CODE,FR_SERVICE_CODE,FR_SUBSERVICE_CODE ");
								sbSql.append(" ,FR_BED_CLASS_CODE,FR_BED_TYPE_CODE,FR_ROOM_NO ");
								sbSql.append(" ,FR_BED_NO,fr_specialty_code ");
								sbSql.append(" ,FR_PRACTITIONER_ID, FR_TEAM_ID, TO_NURSING_UNIT_CODE,");
								sbSql.append(" TO_SERVICE_CODE,TO_SUBSERVICE_CODE "	);
								sbSql.append(" ,TO_BED_CLASS_CODE, TO_BED_TYPE_CODE " );
								sbSql.append(" ,TO_ROOM_NO,	 TO_BED_NO " );
								sbSql.append(" ,TO_SPECIALTY_CODE,	TO_PRACTITIONER_ID " );
								sbSql.append(" ,TO_TEAM_ID, REQUEST_STATUS, CONF_CANC_DATE_TIME,CANCEL_REASON_CODE,BLOCKING_TYPE_CODE,BLOCKING_PERIOD,BLOCKING_REMARKS,ADDED_BY_ID,ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,DELINK_BABY_YN) values ( ?, ?, ?, ?, ?, ?,to_date(?,'dd/mm/rrrr hh24:MI'),?,?,?, ?, ?, ?,?, ?,?, ?, ?, ?, ?, ?,?,?, ?, ?,?, ?, ?,?, ?, ?,?,?,to_date(?,'dd/mm/rrrr hh24:MI'),?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)" );
								pstmt = con.prepareStatement( sbSql.toString() );
								pstmt.setString	( 1, facilityId ) ;
								pstmt.setString	( 2, encounterid ) ;
								pstmt.setInt	( 3, srl_no ) ;
								pstmt.setString	( 4, patientid);
								pstmt.setString	( 5, "RT" ) ;
								pstmt.setString	( 6, transfertype ) ;
								pstmt.setString	( 7, transferdate ) ;
								pstmt.setString	( 8, tonursingunitcode ) ;
								pstmt.setString	( 9, tobedclass ) ;
								pstmt.setString	( 10, tobedtype ) ;
								pstmt.setString	( 11, toroomno ) ;
								pstmt.setString	( 12, tobedno ) ;
								pstmt.setString	( 13, frnursingunitcode ) ;
								pstmt.setString	( 14, frservicecode);
								pstmt.setString	( 15, frsubservcode);
								pstmt.setString	( 16, frbedclass ) ;
								pstmt.setString	( 17, frbedtype ) ;
								pstmt.setString	( 18, frroomno ) ;
								pstmt.setString	( 19, frbedno ) ;
								pstmt.setString	( 20, frspecialitycode ) ;
								pstmt.setString	( 21, frpractitionerid ) ;
								pstmt.setString	( 22, frteamid ) ;
								pstmt.setString	( 23, tonursingunitcode ) ;
								pstmt.setString	( 24, toservicecode ) ;
								pstmt.setString	( 25, sub_service ) ;
								pstmt.setString	( 26, tobedclass ) ;
								pstmt.setString	( 27, tobedtype ) ;
								pstmt.setString	( 28, toroomno ) ;
								pstmt.setString	( 29, tobedno ) ;
								pstmt.setString	( 30, tospecialitycode ) ;
								pstmt.setString	( 31, topractitionerid ) ;
								pstmt.setString	( 32, med_team_id ) ;
								pstmt.setString	( 33, insert_val );
								pstmt.setString	( 34, transferdate ) ;// Sysdate....
								pstmt.setString	( 35, cancel_code ) ;
								
								pstmt.setString	( 36, blocking_type_code ) ;
								/*11/11/2008 CRF 3698 SRR20056-CRF-0228 */
								//pstmt.setString	( 36, reason_for_reserved_bed ) ;

								pstmt.setString	( 37, bed_blk_period ) ;
								pstmt.setString	( 38, blk_remark ) ;
								pstmt.setString	( 39, addedById);  //Added by date - sysdate
								pstmt.setString	( 40, addedAtWorkstation ) ;
								pstmt.setString	( 41, facilityId ) ;    //Modified date- Sysdate
								pstmt.setString	( 42, addedById ) ;
								pstmt.setString	( 43, addedAtWorkstation ) ;
								pstmt.setString	( 44, facilityId ) ;
								pstmt.setString	( 45, mother_bed_status ) ;
								try
								{
									
									reset = pstmt.executeUpdate() ;
								}
								catch(Exception ex)
								{
									ex.printStackTrace() ;	
								}
								if(reset > 0) {
									result = true; 
								    report_val=true;
								    }
								else 
									result = false;
								if(pstmt != null)		pstmt.close();
								if(srs != null)		srs.close(); //Added for checkstyle
							}

							if( result)
							{
								/*	@Coded by kishore on 4/23/2004
								@inserting DATA into table name IP_TRANSFER_REQUEST from ip_bed_booking
								@param: All parameters from request for Transfer jsp page
								*/
	
								strBuffer.delete(0, strBuffer.length());
								strBuffer.append("INSERT INTO IP_TRANSFER_REQUEST  (FACILITY_ID, ENCOUNTER_ID,TFR_REQ_REF_NO,");
								strBuffer.append("PATIENT_ID, TFR_REQ_DATE_TIME, TFR_REQ_TYPE,TFR_REQ_REASON, PREF_DATE_TIME, ");
								strBuffer.append("PRIORITY_CODE, REQ_NURSING_UNIT_CODE, REQ_SERVICE_CODE, REQ_SUBSERVICE_CODE,");
								strBuffer.append( " REQ_SPECIALTY_CODE, ");
								strBuffer.append("REQ_PRACTITIONER_ID, REQ_TEAM_ID, TFR_REQ_STATUS,TFR_REQ_ACCEPTED_YN, ADDED_BY_ID,");
								strBuffer.append("ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID,MODIFIED_DATE, ");
								strBuffer.append("MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, PRIORITY_EXP_DATE,");

								if(ipparam_bed_yn.equals("Y"))
									strBuffer.append("BED_CLASS_REQ_STATUS,");
								//11/14/2008
								//if(is_reserved_bed_checked.equals("Y"))
								//strBuffer.append("BLOCKING_TYPE_CODE = '"+reason_for_reserved_bed+"', ");
								//
								strBuffer.append("REQ_BED_CLASS_CODE,REQ_BED_TYPE_CODE,DELINK_BABY_YN,REQ_BED_TYPE_CODE_BY_DEFN,BLOCKING_TYPE_CODE) ");
								
								strBuffer.append(" values (?,?,?,?,to_date('"+transferdate+"','dd/mm/rrrr hh24:mi'),");
								strBuffer.append(" ?,?,to_date('"+pref_date_time+"', 'dd/mm/rrrr hh24:mi'),?,?,?,?,");
								strBuffer.append(" ?,?,?,?,'N',?,sysdate,?,?,?,sysdate,?,?,to_date('"+exp_date_time+"', 'dd/mm/rrrr hh24:mi'),");
		
								if(ipparam_bed_yn.equals("Y"))
									strBuffer.append("?,");
								

								strBuffer.append("?,?,?,?,?)");
								

								pstmt = con.prepareStatement(strBuffer.toString());
								pstmt.setString	( 1, facilityId ) ;
								pstmt.setString	( 2, encounterid) ;
								pstmt.setString	( 3, bookingrefno ) ;
								pstmt.setString	( 4, patientid ) ;
								pstmt.setString	( 5, transfer_req_type ) ;
								pstmt.setString	( 6, transfertype ) ;
								pstmt.setString	( 7, priority ) ;
								pstmt.setString	( 8, tonursingunitcode ) ;
								pstmt.setString	( 9, toservicecode ) ;
								pstmt.setString	( 10, sub_service ) ;
								pstmt.setString	( 11, tospecialitycode ) ;
								pstmt.setString ( 12, topractitionerid);
								pstmt.setString	( 13, med_team_id ) ;
								pstmt.setString	( 14, transfer_req_status) ;
								pstmt.setString	( 15, addedById ) ;
								pstmt.setString	( 16, addedAtWorkstation) ;
								pstmt.setString	( 17, facilityId ) ;
								pstmt.setString ( 18, addedById );
								pstmt.setString	( 19, addedAtWorkstation ) ;
								pstmt.setString	( 20, facilityId ) ;
								
								if(ipparam_bed_yn.equals("Y"))
								{

									pstmt.setString	( 21, insert_val);
									pstmt.setString	( 22, tobedclass );
									pstmt.setString	( 23, tobedtype );
									pstmt.setString	( 24, mother_bed_status );
									pstmt.setString	( 25, modified_bed_type_code );
									pstmt.setString	( 26, reason_for_reserved_bed );
								}
								else
								{

									pstmt.setString	( 21, tobedclass );
									pstmt.setString	( 22, tobedtype );
									pstmt.setString	( 23, mother_bed_status );
									pstmt.setString	( 24, modified_bed_type_code );
									pstmt.setString	( 25, reason_for_reserved_bed );
								}
								
								try
								{
									
									res = pstmt.executeUpdate();
								}
								catch(SQLException exp)
								{
									result = false ;
									exp.printStackTrace() ;	
								}	
								if(res > 0) 
									result = true; 
								else 
									result = false;
							}
						}
						if(res != 0 && result)
						{
							res = 0;
							try
							{   /*Added audit column in the query*/
								if(strBuffer.length() > 0) strBuffer.delete(0, strBuffer.length());
								if(pstmt != null) pstmt.close();
								strBuffer.append(" update IP_OPEN_ENCOUNTER set ");
								strBuffer.append(" TFR_REQ_STATUS = '"+transfer_req_status+"', ");
								
								strBuffer.append(" modified_by_id = ?, ");
								strBuffer.append(" modified_at_ws_no = ?, modified_date = sysdate, MODIFIED_FACILITY_ID=? ");
								strBuffer.append(" where ");
								strBuffer.append(" facility_id = ? and encounter_id = ?");
								

								pstmt = con.prepareStatement(strBuffer.toString());
								pstmt.setString(1, addedById);
								pstmt.setString(2, addedAtWorkstation);
								pstmt.setString(3, facilityId);
								pstmt.setString(4, facilityId);
								pstmt.setString(5, encounterid);
								res = pstmt.executeUpdate();
								if(res > 0)
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
						
						/*Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866 Start*/
						if(res != 0 && result && !reqRadioBtn.equals(""))
						{
							res = 0;
							try
							{  
								int srlNo = 0;
								if(pstmt != null) pstmt.close();
								if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
								strBuffer.append("select nvl(MAX(srl_no),0)+1 srl_no from ip_confirm_bed_cls where facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' ");
								
								pstmt	= con.prepareStatement(strBuffer.toString());
								srs		= pstmt.executeQuery();
								
								if(srs.next()){
									srlNo = srs.getInt("srl_no");
								}
								
								if(pstmt != null) pstmt.close();
								int insRes = 0;
								if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
								
								strBuffer.append("  insert into ip_confirm_bed_cls ");
								strBuffer.append(" (facility_id, encounter_id, srl_no, patient_id, trn_type, tfr_req_ref_no, bl_charging_req_type ");
								strBuffer.append(" , fr_nursing_unit_code, fr_bed_class_code, fr_room_no, fr_bed_no ");
								strBuffer.append(" , fr_practitioner_id, fr_specialty_code, to_nursing_unit_code, to_bed_class_code, to_room_no, to_bed_no");
								strBuffer.append(" , to_practitioner_id, to_specialty_code, confirmed_date_time, confirmed_by_id " );
								strBuffer.append(" , added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?)" );
								
								int i =1;
								pstmt = con.prepareStatement( strBuffer.toString() );
								pstmt.setString	( i++, facilityId ) ;
								pstmt.setString	( i++, encounterid ) ;
								pstmt.setInt	( i++, srlNo ) ;
								pstmt.setString	( i++, patientid);
								pstmt.setString	( i++, "RT" ) ;
								pstmt.setString	( i++, bookingrefno );
								pstmt.setString	( i++, reqRadioBtn );
								pstmt.setString	( i++, frnursingunitcode ) ;
								pstmt.setString	( i++, frbedclass ) ;
								pstmt.setString	( i++, frroomno ) ;
								pstmt.setString	( i++, frbedno ) ;
								pstmt.setString	( i++, frpractitionerid ) ;
								pstmt.setString	( i++, frspecialitycode ) ;
								pstmt.setString	( i++, tonursingunitcode ) ;
								pstmt.setString	( i++, tobedclass ) ;
								pstmt.setString	( i++, toroomno ) ;
								pstmt.setString	( i++, tobedno ) ;
								pstmt.setString	( i++, topractitionerid ) ;
								pstmt.setString	( i++, tospecialitycode ) ;
								pstmt.setString	( i++, addedById ) ;
								pstmt.setString	( i++, addedById);  
								pstmt.setString	( i++, addedAtWorkstation ) ;
								pstmt.setString	( i++, facilityId ) ;   
								pstmt.setString	( i++, addedById ) ;
								pstmt.setString	( i++, addedAtWorkstation ) ;
								pstmt.setString	( i++, facilityId ) ;
								
								try{
									insRes = pstmt.executeUpdate() ;
								}
								catch(Exception ex){
									ex.printStackTrace() ;	
								}
								if(insRes > 0)
									result = true; 
								else 
									result = false;
								if(pstmt != null) pstmt.close();
								res = insRes;

							}catch(Exception ex)
							{
								result = false;
								sb.append("Error while inserting into ip_confirm_bed_cls " + ex.getMessage());
								ex.printStackTrace(System.out);
							} 
						}
						/*End*/
						
						if ( res != 0 && retval )
						{
							result = true ;
							java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
							con.commit();
						}
						else
						{
							sb.append("Error while Transfer for request ");
							con.rollback();
						}
					}
					catch ( SQLException exp ) 
					{
						exp.printStackTrace() ;	
						sb.append( exp.getMessage()  ) ;
						exp.printStackTrace() ;
						try
						{
							con.rollback();
						}
						catch(SQLException e1)
						{
							e1.printStackTrace() ;	
						}
					}
					finally 
					{
						try
						{
							if(srs != null)		srs.close();
							if(rset2 != null)	rset2.close();
							if(pstmt != null)	pstmt.close() ;
							if(stmt != null)	stmt.close();
							if(stmt3 != null)	stmt3.close();
						}catch(Exception ce)
						{
							ce.printStackTrace() ;	
						}
					}
				} // end if ValidateBedBookingTransfer	
				ret.clear();
			}
		}catch(Exception e)
		{
			
			e.printStackTrace(System.out);
		}
		finally 
		{
			if(con!=null) ConnectionManager.returnConnection(con,p);
		}
		 if( report_val  && (insert_val.equals("0") ) ) 
			   insert_val="0";  
	   else 
			   insert_val="1"; 
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "insert_val", insert_val ) ;
		return results ;
	}//end insert

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
}// end session bean

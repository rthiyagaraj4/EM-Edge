/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved. 
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used to transfers the patients in.
@version - V3
*/
package eIP.IPTransferPatientOut;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="IPTransferPatientOut"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPTransferPatientOut"
*	local-jndi-name="IPTransferPatientOut"
*	impl-class-name="eIP.IPTransferPatientOut.IPTransferPatientOutManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPTransferPatientOut.IPTransferPatientOutLocal"
*	remote-class="eIP.IPTransferPatientOut.IPTransferPatientOutRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPTransferPatientOut.IPTransferPatientOutLocalHome"
*	remote-class="eIP.IPTransferPatientOut.IPTransferPatientOutHome"
*	generate= "local,remote"
*
*
*/
public class IPTransferPatientOutManager implements SessionBean 
{

	SessionContext ctx;
	public void ejbCreate()  {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){this.ctx=context;}
  
	
	/**
	This method is used to --transfer the patient out.
	@version - V3
	@param1 - java.util.Properties
	@param2 - String
	@param3 - String
	@param4 - String
	@param5 - String
	@param6 - String
	@return - java.util.HashMap
	*/

	public HashMap ValidateIPTransferPatientOut(
				Properties p,
				String facilityId,
				String tonursingunitcode,
				String patientgender,
				String dateofbirth
				)
	{
		HashMap results					= new HashMap() ;
		boolean result					= true ;
		Connection connection2			= null;
		Statement stmt					= null;
		ResultSet srs					= null;

		StringBuffer stringBuffer		= new StringBuffer("");
		StringBuffer sqlBuffer			= new StringBuffer("");
		
		String locale					= "";
		
		try
		{   
			locale = p.getProperty("LOCALE");
			connection2 = ConnectionManager.getConnection(p);
			connection2.setAutoCommit(false);
			
			if (sqlBuffer.length() > 0)
				sqlBuffer.delete(0, sqlBuffer.length());
			sqlBuffer.append(" SELECT age_group_code,locn_type FROM ip_nursing_unit WHERE facility_id ='");
			sqlBuffer.append(facilityId);
			sqlBuffer.append("' and nursing_unit_code='");
			sqlBuffer.append(tonursingunitcode);
			sqlBuffer.append("' ");

			stmt=connection2.createStatement();
			srs = stmt.executeQuery(sqlBuffer.toString());

			if (srs.next())
			{
				String agegrpcode	= checkForNull(srs.getString(1)); 

				if(!agegrpcode.equals(""))
				{
					if (sqlBuffer.length() > 0)
						sqlBuffer.delete(0, sqlBuffer.length());
					sqlBuffer.append(" Select '1' from am_age_group Where age_group_code = '");
					sqlBuffer.append(agegrpcode);
					sqlBuffer.append("'  And NVL(GENDER,'");
					sqlBuffer.append(patientgender);
					sqlBuffer.append("')= '");
					sqlBuffer.append(patientgender);
					sqlBuffer.append("' AND  trunc(SYSDATE)- to_date('");
					sqlBuffer.append(dateofbirth);
					sqlBuffer.append("','dd/mm/rrrr') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE ");
					stmt=connection2.createStatement();
					srs = stmt.executeQuery(sqlBuffer.toString());

					if(!srs.next())
					 {
						result			= false;
						stringBuffer	= new StringBuffer("");
						//MessageManager mm = new MessageManager();
				    //      final java.util.Hashtable mesg = mm.getMessage(locale, "GENDER_MISMATCH", "MP") ;
					//				          String msg1=(String)mesg.get("message");
						Hashtable message = MessageManager.getMessage(locale,"AGE_GENDER_NOT_ALLOWED","IP" ) ;
						stringBuffer.append( (String) message.get("message") ) ;message.clear();
					 }
					 if(srs != null) srs.close(); if(stmt != null) stmt.close();
				}
			}
		}
		catch(Exception e)
		{
			result  = false;
			e.printStackTrace() ;
			try{
				connection2.rollback();
			}catch(Exception e1){}
		}
		finally
		{
			if(connection2 != null) ConnectionManager.returnConnection(connection2,p);
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", stringBuffer.toString() ) ;
		return results ;


   } // end ValidateBedBookingTransfer


/**
* @ejb.interface-method
*	 view-type="both"
*/

	public HashMap insertIPTransferPatientOut(	Properties p,HashMap hashData) 
	{
		boolean result					= false;
		Connection connection			= null;
		//Connection connection2			= null;
		PreparedStatement pstmt			= null;
		ResultSet rset					= null;
		Statement stmt					= null;
		ResultSet srs					= null;
		String locale					= "";
		locale							= p.getProperty("LOCALE");
		StringBuffer stringBuffer		= new StringBuffer("");
		StringBuffer sqlBuffer			= new StringBuffer("");
		StringBuffer strBuffer			= new StringBuffer("");
		long encounterid				= 0;
		String addedAtWorkstation		= "";
		String Mode_of_Tran_desc		= ""; 
		String acc_per1_desc			= "";
		String acc_per2_desc			= "";
		String acc_per3_desc			= "";
		String acc_per4_desc			= "";
		String acc_per5_desc			= "";
		String acc_per6_desc			= "";
		String acc_per7_desc			= "";
		String equip1_desc				= "";
		String equip2_desc				= "";
		String equip3_desc				= "";
		String equip4_desc				= "";
		String equip5_desc				= "";
		String equip6_desc				= "";
		String equip7_desc				= "";
		String bld_med1_desc			= "";
		String bld_med2_desc			= "";
		String bld_med3_desc			= "";
		String bld_med4_desc			= "";
		String bld_med5_desc			= "";
		String bld_med6_desc			= "";
		String bld_med7_desc			= "";
		String bld_med8_desc			= "";
		String bld_med9_desc			= "";
		String bld_med10_desc			= "";
		String rec_doc1_desc			= "";
		String rec_doc2_desc			= "";
		String rec_doc3_desc			= "";
		String rec_doc4_desc			= "";
		String rec_doc5_desc			= "";
		String pat_bel1_desc			= "";
		String pat_bel2_desc			= "";
		String pat_bel3_desc			= "";
		String pat_bel4_desc			= "";
		String pat_bel5_desc			= "";
		String pat_bel6_desc			= "";
		String pat_bel7_desc			= "";
		String pat_bel8_desc			= "";
		String pat_bel9_desc			= "";
		String pat_bel10_desc			= "";
		String  facilityId				= "";
		String  patientid				= "";
		String  encounter_id			= "";
		String	transferdate			= "";
		String	transfertype			= "";
		String	priority				= "";
		String	tonursingunitcode		= "";
		String	toservicecode			= "";
		String	sub_service				= "";
		String 	tospecialitycode		= "";
		String	topractitionerid		= "";
		String  med_team_id				= "";
		String	informed_yn				= "";
		String	informed_name			= "";
		String	informed_dt				= "";
		String  auth_dt					= "";
		String	porterage_det			= "";
		String  book_conf_yn			= "";
		String  informed_to				= "";
		String  book_ref_no				= "";
		String  client_ip_address		= "";
		String  practitioner_id			= "";
		String  bed_block_periond		= "";
		String  block_type_code			= "";
		String  bed_block_remark		= "";
		String tobedclass				= "";
		String tobedtype				= "";
		String frbedclass				= "";
		String frbedtype				= "";
		String cancel_code				= "";
		String toroomno					= "";
		String tobedno					= "";
		String frnursingunitcode		= "";
		String frservicecode			= "";
		String frsubservcode			= "";
		String frroomno					= "";
		String frbedno					= "";
		String 	frspecialitycode		= "";
		String	frpractitionerid		= "";
		String	frteamid				= "";
		String	change_bed_class_yn		= "";
		String	ipparam_bed_yn			= "";
		String	mother_bed_status		= "";
		String	dateofbirth				= "";
		String	gender					= "";
		String	bed_class_chk			= "";
		String	billing_group_id		= "";
		String bl_operational			= "";
		String reason_for_reserved_bed	= "";
		String modified_bed_type_code	= "";
		String	bed_change				= "";
		String addedById				= "";
		String modifiedById				= "";
		String modifiedAtWorkstation	= "";
		String autoCnrmTfrReq			= "";//Added by Thamizh selvi on 11th May 2017 for ML-MMOH-CRF-0617	
		//int srlno						= 0;
		facilityId						= (String)hashData.get("facilityId");
		patientid						= (String)hashData.get("patientid");
		encounter_id					= (String)hashData.get("encounterid");
		transferdate					= (String)hashData.get("transferdate");
		transfertype					= (String)hashData.get("transfertype");
		priority						= (String)hashData.get("priority");
		tonursingunitcode				= (String)hashData.get("tonursingunitcode");
		toservicecode					= (String)hashData.get("toservicecode");
		sub_service						= (String)hashData.get("sub_service");
		tospecialitycode				= (String)hashData.get("tospecialitycode");
		topractitionerid				= (String)hashData.get("topractitionerid");
		med_team_id						= (String)hashData.get("med_team_id");
		informed_yn						= (String)hashData.get("informed_yn");
		informed_name					= (String)hashData.get("informed_name");
		informed_dt						= (String)hashData.get("informed_dt");
		auth_dt							= (String)hashData.get("auth_dt");
		porterage_det					= (String)hashData.get("porterage_det");
		book_conf_yn					= (String)hashData.get("book_conf_yn");
		informed_to						= (String)hashData.get("informed_to");
		book_ref_no						= (String)hashData.get("book_ref_no");
		client_ip_address				= (String)hashData.get("client_ip_address");
		practitioner_id					= (String)hashData.get("practitioner_id");
		bed_block_periond				= (String)hashData.get("bed_block_periond");
		block_type_code					= (String)hashData.get("block_type_code");
		bed_block_remark				= (String)hashData.get("bed_block_remark");
		tobedclass						= (String)hashData.get("tobedclass");
		tobedtype						= (String)hashData.get("tobedtype");
		/*Added by Thamizh selvi on 11th May 2017 for ML-MMOH-CRF-0617 Start*/
		autoCnrmTfrReq					= (String)hashData.get("autoCnrmTfrReq");
		if(autoCnrmTfrReq.equals("Y"))
		{
			toroomno						= (String)hashData.get("toroomno");
			tobedno							= (String)hashData.get("tobedno");
		}/*End*/

		frbedclass						= (String)hashData.get("frbedclass");
		frbedtype						= (String)hashData.get("frbedtype");
		frnursingunitcode				= (String)hashData.get("frnursingunitcode");
		frservicecode					= (String)hashData.get("frservicecode");
		frsubservcode					= (String)hashData.get("frsubservcode");
		frroomno						= (String)hashData.get("frroomno");
		frbedno							= (String)hashData.get("frbedno");
		frspecialitycode				= (String)hashData.get("frspecialitycode");
		frpractitionerid				= (String)hashData.get("frpractitionerid");
		frteamid						= (String)hashData.get("frteamid");
		ipparam_bed_yn					= (String)hashData.get("ipparam_bed_yn");
		mother_bed_status				= (String)hashData.get("mother_bed_status");
		if(mother_bed_status == null ||mother_bed_status.equals("")) mother_bed_status = "N";
		dateofbirth						= (String)hashData.get("dateofbirth");
		gender							= (String)hashData.get("gender");
		bed_class_chk					= (String)hashData.get("bed_class_chk");
		billing_group_id				= (String)hashData.get("billing_group_id");
		bl_operational					= (String)hashData.get("bl_operational");
		reason_for_reserved_bed			= (String)hashData.get("reason_for_reserved_bed");
	
		modified_bed_type_code			= (String)hashData.get("modified_bed_type_code");
		bed_change						= (String)hashData.get("bed_change");
		if(!bed_change.equals("Y"))
			bed_change="N";

		HashMap results					= new HashMap() ;

		boolean isRecordCommited		= false;

		String sqlTest					=  "";
		Statement stmt3					= null;
		ResultSet rset2					= null;
		int Count1						= 0;
		addedById						= p.getProperty( "login_user" ) ;
		modifiedById					= addedById ;
		modifiedAtWorkstation			= client_ip_address;
		addedAtWorkstation				= client_ip_address;
		encounterid						= Long.parseLong(encounter_id);


		try
		{
			connection  = ConnectionManager.getConnection(p);
			if(!porterage_det.equals(""))
			{
				StringTokenizer strtoken = new StringTokenizer(porterage_det,"^^");
				while(strtoken.hasMoreTokens())
				{
					Mode_of_Tran_desc	= checkForNull(strtoken.nextToken()); 
					acc_per1_desc		= checkForNull(strtoken.nextToken());
					acc_per2_desc		= checkForNull(strtoken.nextToken());
					acc_per3_desc		= checkForNull(strtoken.nextToken());
					acc_per4_desc		= checkForNull(strtoken.nextToken());
					acc_per5_desc		= checkForNull(strtoken.nextToken());
					acc_per6_desc		= checkForNull(strtoken.nextToken());
					acc_per7_desc		= checkForNull(strtoken.nextToken()); 
					equip1_desc			= checkForNull(strtoken.nextToken());
					equip2_desc			= checkForNull(strtoken.nextToken());
					equip3_desc			= checkForNull(strtoken.nextToken()); 
					equip4_desc			= checkForNull(strtoken.nextToken()); 
					equip5_desc			= checkForNull(strtoken.nextToken());
					equip6_desc			= checkForNull(strtoken.nextToken());
					equip7_desc			= checkForNull(strtoken.nextToken());
					bld_med1_desc		= checkForNull(strtoken.nextToken());
					bld_med2_desc		= checkForNull(strtoken.nextToken());
					bld_med3_desc		= checkForNull(strtoken.nextToken());
					bld_med4_desc		= checkForNull(strtoken.nextToken());
					bld_med5_desc		= checkForNull(strtoken.nextToken());
					bld_med6_desc		= checkForNull(strtoken.nextToken());
					bld_med7_desc		= checkForNull(strtoken.nextToken());
					bld_med8_desc		= checkForNull(strtoken.nextToken());
					bld_med9_desc		= checkForNull(strtoken.nextToken());
					bld_med10_desc		= checkForNull(strtoken.nextToken());
					rec_doc1_desc		= checkForNull(strtoken.nextToken());
					rec_doc2_desc		= checkForNull(strtoken.nextToken());
					rec_doc3_desc		= checkForNull(strtoken.nextToken());
					rec_doc4_desc		= checkForNull(strtoken.nextToken()); 
					rec_doc5_desc		= checkForNull(strtoken.nextToken());
					pat_bel1_desc		= checkForNull(strtoken.nextToken()); 
					pat_bel2_desc		= checkForNull(strtoken.nextToken()); 
					pat_bel3_desc		= checkForNull(strtoken.nextToken());
					pat_bel4_desc		= checkForNull(strtoken.nextToken());
					pat_bel5_desc		= checkForNull(strtoken.nextToken());
					pat_bel6_desc		= checkForNull(strtoken.nextToken());
					pat_bel7_desc		= checkForNull(strtoken.nextToken()); 
					pat_bel8_desc		= checkForNull(strtoken.nextToken());
					pat_bel9_desc		= checkForNull(strtoken.nextToken());
					pat_bel10_desc		= checkForNull(strtoken.nextToken());
				}
			}
			int count = 0;
			try
			{
				if(strBuffer.length() > 0)	strBuffer.delete(0, strBuffer.length());
				strBuffer.append("  update IP_OPEN_ENCOUNTER set ");
				strBuffer.append("  TFR_REQ_STATUS = '3', ");
				
				strBuffer.append(" modified_by_id = ?, ");
				strBuffer.append(" modified_at_ws_no = ?, modified_date = sysdate ");
				strBuffer.append(" where ");
				strBuffer.append(" facility_id = ? and encounter_id = ?");
				pstmt = connection.prepareStatement(strBuffer.toString());
				pstmt.setString(1, addedById);
				pstmt.setString(2, addedAtWorkstation);
				pstmt.setString(3, facilityId);
				pstmt.setString(4, encounter_id);
				count = pstmt.executeUpdate();
				if(count > 0)
					result = true;
				else
					result = false;
				if(pstmt != null) pstmt.close();

			}catch(Exception ex)
			{
				result = false;
				stringBuffer.append("error while updating into ip_open_encounter : " + ex.getMessage());
			}
			try
			{
				if(srs!=null) srs.close();
				if(stmt!=null) stmt.close();

				String  operstnsql= "SELECT  a.BED_CLASS_CHANGE_YN BED_CLASS_CHANGE_YN FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+addedById+"' AND trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate))";

				stmt = connection.createStatement();
				srs = stmt.executeQuery(operstnsql);
				if(srs != null && srs.next())
				{
					change_bed_class_yn = srs.getString("BED_CLASS_CHANGE_YN");
				}

				if(change_bed_class_yn.equals("")||change_bed_class_yn==null)
					change_bed_class_yn="N";

				if(srs!=null) srs.close();
				if(stmt!=null) stmt.close();

			}catch (Exception e)
			{ 
				result = false;
				e.printStackTrace();
			}
			
			if(book_conf_yn.equals("1") && result)
			{
				try
				{
					if (sqlBuffer.length() > 0)
						sqlBuffer.delete(0, sqlBuffer.length());
					sqlBuffer.append("Update IP_TRANSFER_REQUEST set TFR_REQ_STATUS = ?, ");
					sqlBuffer.append("MODE_OF_TRANSPORT = ?, ACCOMP_PERSON1 = ?, ACCOMP_PERSON2 = ?, ");
					sqlBuffer.append("ACCOMP_PERSON3 = ?, ACCOMP_PERSON4 = ?, ACCOMP_PERSON5 = ?, ");
					sqlBuffer.append("ACCOMP_PERSON6 = ?, ACCOMP_PERSON7 = ?, EQUIPMENT1 = ?, ");
					sqlBuffer.append("EQUIPMENT2 = ?, EQUIPMENT3 = ?, EQUIPMENT4 = ?, EQUIPMENT5 = ?, ");
					sqlBuffer.append("EQUIPMENT6 = ?, EQUIPMENT7 = ?, BLOOD_AND_MEDICATION1 = ?, ");
					sqlBuffer.append("BLOOD_AND_MEDICATION2 = ?, BLOOD_AND_MEDICATION3 = ?, ");
					sqlBuffer.append("BLOOD_AND_MEDICATION4 = ?, BLOOD_AND_MEDICATION5 = ?, ");
					sqlBuffer.append("BLOOD_AND_MEDICATION6 = ?, BLOOD_AND_MEDICATION7 = ?, ");
					sqlBuffer.append("BLOOD_AND_MEDICATION8 = ?, BLOOD_AND_MEDICATION9 = ?, ");
					sqlBuffer.append("BLOOD_AND_MEDICATION10 = ?, RECORDS_AND_DOCUMENTS1 = ?, ");
					sqlBuffer.append("RECORDS_AND_DOCUMENTS2 = ?, RECORDS_AND_DOCUMENTS3 = ?, ");
					sqlBuffer.append("RECORDS_AND_DOCUMENTS4 = ?, RECORDS_AND_DOCUMENTS5 = ?, ");
					sqlBuffer.append("PATIENT_BELONGINGS1 = ?, PATIENT_BELONGINGS2 = ?, ");
					sqlBuffer.append("PATIENT_BELONGINGS3 = ?, PATIENT_BELONGINGS4 = ?, ");
					sqlBuffer.append("PATIENT_BELONGINGS5 = ?, PATIENT_BELONGINGS6 = ?, ");
					sqlBuffer.append("PATIENT_BELONGINGS7 = ?, PATIENT_BELONGINGS8 = ?, ");
					sqlBuffer.append("PATIENT_BELONGINGS9 = ?, PATIENT_BELONGINGS10 = ?, ");
					sqlBuffer.append("INFORMED_YN = ?, INFORMED_TO = ?, INFORMED_NAME = ?, ");
					sqlBuffer.append("INFORMED_DATE_TIME = to_date('");
					sqlBuffer.append(informed_dt);
					sqlBuffer.append("', 'dd/mm/rrrr hh24:mi'),");
					sqlBuffer.append("AUTH_TRF_DATE_TIME = to_date('");
					sqlBuffer.append(auth_dt);
					sqlBuffer.append("', 'dd/mm/rrrr hh24:mi'), AUTH_PRACTITIONER_ID = ?, ");
					/*Added by Thamizh selvi on 11th May 2017 for ML-MMOH-CRF-0617 Start*/
					if(autoCnrmTfrReq.equals("Y"))
						sqlBuffer.append("REQ_ROOM_NO = ?, REQ_BED_NO = ?, ");
					/*End*/
					sqlBuffer.append("bed_blk_period_hrs = '");
					sqlBuffer.append(bed_block_periond);
					sqlBuffer.append("', BLOCKING_TYPE_CODE = '");
					// 11/18/2008 CRF 3698 SRR20056-CRF-0228
					
					
					//if((reason_for_reserved_bed==null || reason_for_reserved_bed.equals(""))) //commented this incident [IN:047142]
						sqlBuffer.append(block_type_code);
					//else //commented this incident [IN:047142]
						//sqlBuffer.append(reason_for_reserved_bed);
					
							
					sqlBuffer.append("', BLOCKING_REMARKS = '");
					sqlBuffer.append(bed_block_remark);
					
					/*Below line added for this SCF GHL-SCF-794 [IN:047142]*/
					sqlBuffer.append("', RESERVE_REASON_CODE = '");
					sqlBuffer.append(reason_for_reserved_bed);
					//End GHL-SCF-794 [IN:047142]
					
					sqlBuffer.append("' where FACILITY_ID = '");
					sqlBuffer.append(facilityId);
					sqlBuffer.append("' and ENCOUNTER_ID = ");
					sqlBuffer.append(encounterid);
					sqlBuffer.append(" and TFR_REQ_REF_NO = ");
					sqlBuffer.append(book_ref_no);

					pstmt= connection.prepareStatement(sqlBuffer.toString());
					pstmt.setString	( 1,"3") ;
					pstmt.setString	( 2, Mode_of_Tran_desc ) ;
					pstmt.setString	( 3, acc_per1_desc);
					pstmt.setString	( 4, acc_per2_desc);
					pstmt.setString	( 5, acc_per3_desc);
					pstmt.setString	( 6, acc_per4_desc);
					pstmt.setString	( 7, acc_per5_desc);
					pstmt.setString	( 8, acc_per6_desc);
					pstmt.setString	( 9, acc_per7_desc);
					pstmt.setString	( 10, equip1_desc);
					pstmt.setString	( 11, equip2_desc);
					pstmt.setString	( 12, equip3_desc);
					pstmt.setString	( 13, equip4_desc);
					pstmt.setString	( 14, equip5_desc);
					pstmt.setString	( 15, equip6_desc);
					pstmt.setString	( 16, equip7_desc);
					pstmt.setString	( 17, bld_med1_desc);
					pstmt.setString	( 18, bld_med2_desc);
					pstmt.setString	( 19, bld_med3_desc);
					pstmt.setString	( 20, bld_med4_desc);
					pstmt.setString	( 21, bld_med5_desc);
					pstmt.setString	( 22, bld_med6_desc);
					pstmt.setString	( 23, bld_med7_desc);
					pstmt.setString	( 24, bld_med8_desc);
					pstmt.setString	( 25, bld_med9_desc);
					pstmt.setString	( 26, bld_med10_desc);
					pstmt.setString	( 27, rec_doc1_desc);
					pstmt.setString	( 28, rec_doc2_desc);
					pstmt.setString	( 29, rec_doc3_desc);
					pstmt.setString	( 30, rec_doc4_desc);
					pstmt.setString	( 31, rec_doc5_desc);
					pstmt.setString	( 32, pat_bel1_desc);
					pstmt.setString	( 33, pat_bel2_desc);
					pstmt.setString	( 34, pat_bel3_desc);
					pstmt.setString	( 35, pat_bel4_desc);
					pstmt.setString	( 36, pat_bel5_desc);
					pstmt.setString	( 37, pat_bel6_desc);
					pstmt.setString	( 38, pat_bel7_desc);
					pstmt.setString	( 39, pat_bel8_desc);
					pstmt.setString	( 40, pat_bel9_desc);
					pstmt.setString	( 41, pat_bel10_desc);
					pstmt.setString	( 42, informed_yn);
					pstmt.setString	( 43, informed_to);			
					pstmt.setString	( 44, informed_name);
					pstmt.setString	( 45, practitioner_id);
					/*Added by Thamizh selvi on 11th May 2017 for ML-MMOH-CRF-0617 Start*/
					if(autoCnrmTfrReq.equals("Y"))
					{
						pstmt.setString	( 46, toroomno);
						pstmt.setString	( 47, tobedno);
					}/*End*/
					int nRset = pstmt.executeUpdate();
					if(nRset>0)
					{
						result = true;
						stringBuffer	= new StringBuffer("");						
						Hashtable message = MessageManager.getMessage(locale, "RECORD_MODIFIED","SM" ) ;
						stringBuffer.append( (String) message.get("message") ) ;
						isRecordCommited = true;
						message.clear();
						connection.commit();

					}
					else
					{
						result = false;
						stringBuffer.append("Error while Transfering Patient Out");
						connection.rollback();
					}

					if(pstmt!=null) pstmt.close();
				}
				catch(SQLException ec)
				{
					ec.printStackTrace();
					stringBuffer.append( ec.getMessage()  ) ;
				}
				finally 
				{
					try
					{
					  if(pstmt != null)		pstmt.close() ;
					}catch(Exception ce){}
						 if(connection != null)      ConnectionManager.returnConnection(connection,p);
				}
			}
			else if(result)
			{
				sqlTest = " select count(*) cnt from IP_TRANSFER_REQUEST where encounter_id = '"+encounterid+"' and facility_id = '"+facilityId+"' and TFR_REQ_STATUS = 3 ";		
				try
				{	
					stmt3 = connection.createStatement();
					rset2 = stmt3.executeQuery(sqlTest);

					if(rset2 != null && rset2.next())
					{	
						Count1=rset2.getInt("cnt");
					}
					if(rset2!=null)rset2.close();
					if(stmt3!=null)stmt3.close();
				
				}catch(SQLException e)
				{
				}
				
				if (Count1 >0)
				{
					stringBuffer = new StringBuffer("");
					result = false;

					Hashtable message = MessageManager.getMessage( locale, "MORETHAN_ONE_BED_BOOK" ,"IP");

					stringBuffer.append( (String) message.get("message") );message.clear();
					results.put( "status", new Boolean(result) ) ;
					results.put( "error", stringBuffer.toString() ) ;
					return results;
				}
				else
				{
					stringBuffer = new StringBuffer("");
					results.put( "error", "no error");
					int res = 0;

					HashMap ret=ValidateIPTransferPatientOut(p,
					facilityId,
					tonursingunitcode,
					gender,
					dateofbirth
					);

					boolean retval=((Boolean)ret.get("status")).booleanValue();

					stringBuffer = new StringBuffer("");
					stringBuffer.append((String)ret.get("error"));
					
					if(!retval)
					{
						result = false;
					}
					else
					{
						try
						{
							String trfReqRefNo = "";

							if(retval)
							{
								//Inserting into IP_BED_CLASS_REQUEST by kishore on 9/4/2004
								//bed_change  = check box in front end.
								//change_bed_class_yn = Operation station value...
								//ipparam_bed_yn = IP param value...

								if(ipparam_bed_yn.equals("Y")&& bed_change.equals("Y"))
								{ 
									int srl_no = 0;
									if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
									strBuffer.append("select nvl(MAX(srl_no),0)+1 srl_no from IP_BED_CLASS_REQUEST where facility_id = '"+facilityId+"' and encounter_id = "+encounterid+" ");
									stmt   = connection.createStatement();
									srs = stmt.executeQuery(strBuffer.toString());
									if(srs.next())
									{
										srl_no = srs.getInt("srl_no");
									}
									int reset = 0;

									//insert into table ip_bed_class_request....with status is '0'
									if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
									strBuffer.append("  insert into IP_BED_CLASS_REQUEST ");
									strBuffer.append(" (facility_id,encounter_id,srl_no,patient_id,trn_type ");
									strBuffer.append(" ,TRANSFER_TYPE_CODE,REQUEST_DATE,REQ_NURSING_UNIT_CODE,REQ_BED_CLASS_CODE,REQ_BED_TYPE_CODE  ");
									strBuffer.append(",REQ_ROOM_NO,REQ_BED_NO,FR_NURSING_UNIT_CODE,FR_SERVICE_CODE,FR_SUBSERVICE_CODE ");
									strBuffer.append(" ,FR_BED_CLASS_CODE,FR_BED_TYPE_CODE,FR_ROOM_NO ");
									strBuffer.append(" ,FR_BED_NO,fr_specialty_code ");
									strBuffer.append(" ,FR_PRACTITIONER_ID, FR_TEAM_ID, TO_NURSING_UNIT_CODE,");
									strBuffer.append(" TO_SERVICE_CODE,TO_SUBSERVICE_CODE "	);
									strBuffer.append(" ,TO_BED_CLASS_CODE, TO_BED_TYPE_CODE " );
									strBuffer.append(" ,TO_ROOM_NO,	 TO_BED_NO " );
									strBuffer.append(" ,TO_SPECIALTY_CODE,	TO_PRACTITIONER_ID " );
									strBuffer.append(" ,TO_TEAM_ID, REQUEST_STATUS, CONF_CANC_DATE_TIME,CANCEL_REASON_CODE,BLOCKING_TYPE_CODE,BLOCKING_PERIOD,BLOCKING_REMARKS,ADDED_BY_ID,ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,DELINK_BABY_YN ");
									strBuffer.append(") values ( ?, ?, ?, ?, ?, ?,to_date(?,'dd/mm/rrrr hh24:MI'),?,?,?, ?, ?, ?,?, ?,?, ?, ?, ?, ?, ?,?,?, ?, ?,?, ?, ?,?, ?, ?,?,?,to_date(?,'dd/mm/rrrr hh24:MI'),?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)" );

									pstmt = connection.prepareStatement( strBuffer.toString() );
									pstmt.setString	( 1, facilityId ) ;
									pstmt.setLong	( 2, encounterid ) ;
									pstmt.setInt	( 3, srl_no ) ;
									pstmt.setString	( 4, patientid);
									pstmt.setString	( 5, "TO" ) ;
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
									if(change_bed_class_yn.equals("Y"))
										pstmt.setString	( 33, "1" );
									else if(change_bed_class_yn.equals("N"))
									{
										if(bl_operational.equals("Y"))
										{
											try
											{
												if(srs!=null) srs.close();
												if(stmt!=null) stmt.close();

												String blSql= " select BL_CHECK_ELIGIBILITY_LEVEL('"+billing_group_id+"','"+tobedtype+"') from dual ";
												stmt = connection.createStatement();
												srs = stmt.executeQuery(blSql);
												if(srs != null && srs.next())
												{
													bed_class_chk = srs.getString(1);
												}
												
												if(bed_class_chk.equals("")||bed_class_chk==null)
													bed_class_chk="N";

												if(srs!=null) srs.close();
												if(stmt!=null) stmt.close();

											}catch (Exception e)
											{ 
												e.printStackTrace();
											}
										}

										if(bed_class_chk.equals("Y"))
											pstmt.setString	( 33, "0" );
										else if(bed_class_chk.equals("N"))
											pstmt.setString	( 33, "1" );
									}

									pstmt.setString	( 34, transferdate ) ;
									pstmt.setString	( 35, cancel_code ) ;
									pstmt.setString	( 36, block_type_code ) ;
									pstmt.setString	( 37, bed_block_periond ) ;
									pstmt.setString	( 38, bed_block_remark ) ;
									pstmt.setString	( 39, addedById);  //Added by date - sysdate
									pstmt.setString	( 40, addedAtWorkstation ) ;
									pstmt.setString	( 41, facilityId ) ;    //Modified date- Sysdate
									pstmt.setString	( 42, modifiedById ) ;
									pstmt.setString	( 43, modifiedAtWorkstation ) ;
									pstmt.setString	( 44, facilityId ) ;
									pstmt.setString	( 45, mother_bed_status ) ;
									try
									{
										reset = pstmt.executeUpdate() ;
									}
									catch(Exception ex)
									{
										ex.printStackTrace();
										result = false;
									}
									if(reset > 0) result = true; else result = false;
								}
								else
								{
									result = true;
								}
								if (pstmt != null)	pstmt.close();

								if(result)
								{
									StringBuffer trf_number = new StringBuffer();
									trf_number.append("select nvl(max(tfr_req_ref_no),0)+1 srl_no from ip_transfer_request where facility_id = '"+facilityId+"' and encounter_id ="+encounterid+" ");
									if (srs != null)	srs.close();
									if (stmt != null)	stmt.close();

									stmt  = connection.createStatement();
									srs  = stmt.executeQuery(trf_number.toString());
									if (srs != null)
									if (srs.next())
									trfReqRefNo = (srs.getString("srl_no") == null) ? "" : srs.getString("srl_no"); 

									if (trfReqRefNo.equals(""))
									{
										trfReqRefNo = "0";
									}
									if(mother_bed_status.equals("")||mother_bed_status==null)
									mother_bed_status="N";
									strBuffer.delete(0, strBuffer.length());
									strBuffer.append(" INSERT INTO IP_TRANSFER_REQUEST ");
									strBuffer.append(" (FACILITY_ID, TFR_REQ_REF_NO, ENCOUNTER_ID ,PATIENT_ID, ");
									strBuffer.append("  TFR_REQ_DATE_TIME,PREF_DATE_TIME, TFR_REQ_REASON, REQ_NURSING_UNIT_CODE,");
									strBuffer.append(" REQ_BED_TYPE_CODE, ");
									strBuffer.append(" REQ_PRACTITIONER_ID,REQ_SPECIALTY_CODE, ");
									strBuffer.append(" TFR_REQ_STATUS, ");
									strBuffer.append(" ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, ");
									strBuffer.append(" MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO ,MODIFIED_FACILITY_ID, REQ_SERVICE_CODE, PRIORITY_CODE, REQ_SUBSERVICE_CODE, REQ_TEAM_ID, MODE_OF_TRANSPORT ,"); 
									strBuffer.append("ACCOMP_PERSON1,");
									strBuffer.append("ACCOMP_PERSON2,"); 
									strBuffer.append("ACCOMP_PERSON3,");
									strBuffer.append("ACCOMP_PERSON4,");
									strBuffer.append("ACCOMP_PERSON5,");
									strBuffer.append("ACCOMP_PERSON6,");
									strBuffer.append("ACCOMP_PERSON7,");
									strBuffer.append("EQUIPMENT1,");
									strBuffer.append("EQUIPMENT2,"); 
									strBuffer.append("EQUIPMENT3,");
									strBuffer.append("EQUIPMENT4,"); 
									strBuffer.append("EQUIPMENT5,");
									strBuffer.append("EQUIPMENT6,");
									strBuffer.append("EQUIPMENT7,");
									strBuffer.append("BLOOD_AND_MEDICATION1,"); 
									strBuffer.append("BLOOD_AND_MEDICATION2,"); 
									strBuffer.append("BLOOD_AND_MEDICATION3,"); 
									strBuffer.append("BLOOD_AND_MEDICATION4,"); 
									strBuffer.append("BLOOD_AND_MEDICATION5,"); 
									strBuffer.append("BLOOD_AND_MEDICATION6,");
									strBuffer.append("BLOOD_AND_MEDICATION7,");
									strBuffer.append("BLOOD_AND_MEDICATION8,"); 
									strBuffer.append("BLOOD_AND_MEDICATION9,"); 
									strBuffer.append("BLOOD_AND_MEDICATION10,"); 
									strBuffer.append("RECORDS_AND_DOCUMENTS1,"); 
									strBuffer.append("RECORDS_AND_DOCUMENTS2,");
									strBuffer.append("RECORDS_AND_DOCUMENTS3,"); 
									strBuffer.append("RECORDS_AND_DOCUMENTS4,");
									strBuffer.append("RECORDS_AND_DOCUMENTS5,");
									strBuffer.append("PATIENT_BELONGINGS1,");
									strBuffer.append("PATIENT_BELONGINGS2,"); 
									strBuffer.append("PATIENT_BELONGINGS3,"); 
									strBuffer.append("PATIENT_BELONGINGS4,"); 
									strBuffer.append("PATIENT_BELONGINGS5,"); 
									strBuffer.append("PATIENT_BELONGINGS6,"); 
									strBuffer.append("PATIENT_BELONGINGS7,"); 
									strBuffer.append("PATIENT_BELONGINGS8,"); 
									strBuffer.append("PATIENT_BELONGINGS9,"); 
									strBuffer.append("PATIENT_BELONGINGS10,"); 
									strBuffer.append("INFORMED_YN,"); 
									strBuffer.append("INFORMED_TO,");
									strBuffer.append("INFORMED_NAME,"); 
									strBuffer.append("INFORMED_DATE_TIME,");
									strBuffer.append("AUTH_TRF_DATE_TIME, AUTH_PRACTITIONER_ID, TFR_REQ_TYPE, bed_blk_period_hrs,BLOCKING_TYPE_CODE,BLOCKING_REMARKS,REQ_BED_CLASS_CODE,DELINK_BABY_YN,REQ_BED_TYPE_CODE_BY_DEFN,RESERVE_REASON_CODE "); /*Above line modified for this SCF GHL-SCF-794 [IN:047142]*/
									if(ipparam_bed_yn.equals("Y"))
									strBuffer.append(",BED_CLASS_REQ_STATUS ");
									/*Added by Thamizh selvi on 11th May 2017 for ML-MMOH-CRF-0617 Start*/
									if(autoCnrmTfrReq.equals("Y"))
										strBuffer.append(",REQ_ROOM_NO, REQ_BED_NO ");
									/*End*/
									strBuffer.append(")");
									strBuffer.append(" values ( ?, ?, ?, ?,sysdate,");
									strBuffer.append(" to_date('"+transferdate+"','dd/mm/rrrr hh24:mi'), ?, ?, ");
									strBuffer.append(" ?, ");
									strBuffer.append(" ?, ?,");
									strBuffer.append("  '3', ");
									strBuffer.append(" ?, sysdate, ?, ?, ");
									strBuffer.append(" ?, sysdate, ?, ?, ?, ?, ?, ?, "+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date('"+informed_dt+"', 'dd/mm/rrrr hh24:mi'), to_date('"+auth_dt+"', 'dd/mm/rrrr hh24:mi'), ? , 'TO', '"+bed_block_periond+"','"+block_type_code+"','"+bed_block_remark+"',?,?,?	,'"+reason_for_reserved_bed+"'");
									if(ipparam_bed_yn.equals("Y"))
									strBuffer.append(",? ");
									/*Added by Thamizh selvi on 11th May 2017 for ML-MMOH-CRF-0617 Start*/
									if(autoCnrmTfrReq.equals("Y"))
										strBuffer.append(",?,? ");
									/*End*/
									strBuffer.append(" ) ");

									pstmt = connection.prepareStatement( strBuffer.toString());

									try
									{
										pstmt.setString	( 1, facilityId ) ;
										pstmt.setString	( 2, trfReqRefNo ) ;
										pstmt.setLong	( 3, encounterid) ;
										pstmt.setString	( 4, patientid ) ;
										pstmt.setString	( 5, transfertype ) ;
										pstmt.setString	( 6, tonursingunitcode ) ;
										pstmt.setString	( 7, tobedtype ) ;
										pstmt.setString	( 8, topractitionerid ) ;
										pstmt.setString	( 9, tospecialitycode ) ;
										pstmt.setString	( 10, addedById ) ;
										pstmt.setString	( 11, addedAtWorkstation ) ;
										pstmt.setString	( 12, facilityId ) ;
										pstmt.setString	( 13, modifiedById ) ;
										pstmt.setString	( 14, modifiedAtWorkstation ) ;
										pstmt.setString	( 15, facilityId ) ;
										pstmt.setString ( 16, toservicecode);
										pstmt.setString ( 17, priority);
										pstmt.setString ( 18, sub_service);
										pstmt.setString ( 19, med_team_id);
										pstmt.setString	( 20, Mode_of_Tran_desc ) ;
										pstmt.setString	( 21, acc_per1_desc);
										pstmt.setString	( 22, acc_per2_desc);
										pstmt.setString	( 23, acc_per3_desc);
										pstmt.setString	( 24, acc_per4_desc);
										pstmt.setString	( 25, acc_per5_desc);
										pstmt.setString	( 26, acc_per6_desc);
										pstmt.setString	( 27, acc_per7_desc);
										pstmt.setString	( 28, equip1_desc);
										pstmt.setString	( 29, equip2_desc);
										pstmt.setString	( 30, equip3_desc);
										pstmt.setString	( 31, equip4_desc);
										pstmt.setString	( 32, equip5_desc);
										pstmt.setString	( 33, equip6_desc);
										pstmt.setString	( 34, equip7_desc);
										pstmt.setString	( 35, bld_med1_desc);
										pstmt.setString	( 36, bld_med2_desc);
										pstmt.setString	( 37, bld_med3_desc);
										pstmt.setString	( 38, bld_med4_desc);
										pstmt.setString	( 39, bld_med5_desc);
										pstmt.setString	( 40, bld_med6_desc);
										pstmt.setString	( 41, bld_med7_desc);
										pstmt.setString	( 42, bld_med8_desc);
										pstmt.setString	( 43, bld_med9_desc);
										pstmt.setString	( 44, bld_med10_desc);
										pstmt.setString	( 45, rec_doc1_desc);
										pstmt.setString	( 46, rec_doc2_desc);
										pstmt.setString	( 47, rec_doc3_desc);
										pstmt.setString	( 48, rec_doc4_desc);
										pstmt.setString	( 49, rec_doc5_desc);
										pstmt.setString	( 50, pat_bel1_desc);
										pstmt.setString	( 51, pat_bel2_desc);
										pstmt.setString	( 52, pat_bel3_desc);
										pstmt.setString	( 53, pat_bel4_desc);
										pstmt.setString	( 54, pat_bel5_desc);
										pstmt.setString	( 55, pat_bel6_desc);
										pstmt.setString	( 56, pat_bel7_desc);
										pstmt.setString	( 57, pat_bel8_desc);
										pstmt.setString	( 58, pat_bel9_desc);
										pstmt.setString	( 59, pat_bel10_desc);
										pstmt.setString	( 60, informed_yn);
										pstmt.setString	( 61, informed_to);	
										pstmt.setString	( 62, informed_name);
										pstmt.setString	( 63, practitioner_id);
										pstmt.setString	( 64, tobedclass ) ;
										pstmt.setString	( 65, mother_bed_status ) ;
										pstmt.setString	( 66, modified_bed_type_code );
										int k = 0;
										if(ipparam_bed_yn.equals("Y"))
										{
											/*
											if(bed_change.equals("N"))
												pstmt.setString	( 67, "1" ) ;
											else if(change_bed_class_yn.equals("Y"))
												pstmt.setString	( 67, "1" ) ;
											else
												pstmt.setString	( 67, "0" ) ;
											*/
											/*Thursday, February 04, 2010 SRR20056-SCF-4172-IN018866-Issue 1 , to update BED_CLASS_REQ_STATUS as '0' when AM->Operator Station ->bed class change value is N & request for bed class in Transfer Out is checked and BL_CHECK_ELIGIBILITY_LEVEL is Y */

											if(bed_change.equals("Y") && change_bed_class_yn.equals("N") && bed_class_chk.equals("Y"))
												pstmt.setString	( 67, "0" ) ;
											else
												pstmt.setString	( 67, "1" ) ;
											k++;

										}
										/*Added by Thamizh selvi on 11th May 2017 for ML-MMOH-CRF-0617 Start*/
										if(autoCnrmTfrReq.equals("Y"))
										{
											if(k == 1)
											{
												pstmt.setString	( 68, toroomno );
												pstmt.setString	( 69, tobedno );
											}
											else
											{
												pstmt.setString	( 67, toroomno );
												pstmt.setString	( 68, tobedno );
											}
										}
										/*End*/
										try
										{
											res = pstmt.executeUpdate() ;
										}
										catch(Exception exp)
										{
											
											exp.printStackTrace(System.out);
										}

									}catch(Exception exp)
									{
									exp.printStackTrace();
									}
								}
							}	

							if ( res != 0 && retval )
							{
								result = true ;

								if(!isRecordCommited)
								{
									Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED","SM");
									stringBuffer.append((String) message.get("message"));
									message.clear();
								}
								connection.commit();
							}
							else
							{
								stringBuffer.append("Error while Transfering Patient Out");
								connection.rollback();
							}
						}catch ( SQLException e ) 
						{
							e.printStackTrace();
							stringBuffer.append( e.getMessage() ) ;
							e.printStackTrace() ;
							try
							{
								connection.rollback();
							}catch(Exception e1){}
						}
						finally 
						{
							try
							{
								if(rset != null) rset.close();
								if(srs != null)	 srs.close();
								if(rset2 != null) rset2.close();
								if(stmt3 != null) stmt3.close();
								if(pstmt != null) pstmt.close() ;
								if(stmt != null) stmt.close();
							}
							catch(Exception ce){}
								if(connection != null) ConnectionManager.returnConnection(connection,p);
						}
				} // end if ValidateTransferPatientOut
				ret.clear();
			}
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	try
	{
		if(!result)
		{
			stringBuffer.append("Error while Transfering Patient Out");
			connection.rollback();
		}
	}catch ( SQLException e ) 
	{
		e.printStackTrace();
		stringBuffer.append( e.getMessage() ) ;
		e.printStackTrace() ;
		try
		{
			connection.rollback();
			
		}catch(Exception e1)
		{

		}
	}
	finally 
	{
		try
		{
			if(rset != null) rset.close();
			if(srs != null)	 srs.close();
			if(rset2 != null) rset2.close();
			if(stmt3 != null) stmt3.close();
			if(pstmt != null) pstmt.close() ;
			if(stmt != null) stmt.close();
		}
		catch(Exception ce){}
		if(connection != null) ConnectionManager.returnConnection(connection,p);
	}
	results.put( "status", new Boolean(result));
	results.put( "error", stringBuffer.toString());
	return results;

}//end insert
	
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
} // end session bean

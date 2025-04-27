/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used to transfer the practitioner.
@author - 
@version - V3
*/

package eIP.IPTransferPractitioner;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;

import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="IPTransferPractitioner"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPTransferPractitioner"
*	local-jndi-name="IPTransferPractitioner"
*	impl-class-name="eIP.IPTransferPractitioner.IPTransferPractitionerManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPTransferPractitioner.IPTransferPractitionerLocal"
*	remote-class="eIP.IPTransferPractitioner.IPTransferPractitionerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPTransferPractitioner.IPTransferPractitionerLocalHome"
*	remote-class="eIP.IPTransferPractitioner.IPTransferPractitionerHome"
*	generate= "local,remote"
*
*
*/
public class IPTransferPractitionerManager implements SessionBean 
{
	Connection con 			= null;
	PreparedStatement pstmt = null;
	Statement stmt 			= null;
	Statement stmt1 		= null;
	ResultSet srs 			= null;
	long   encounterid;
	StringBuffer strBuffer = new StringBuffer();

	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){ this.ctx = context;}

	public HashMap ValidateIPTransferPractitioner(
													Properties p,
													String facilityId,
													String topractitionerid,
													String tospecialitycode,
													String nursingunitcode		
												)
	{

		HashMap results = new HashMap() ;
		boolean result  = true ;
		String locale = p.getProperty("LOCALE");
		StringBuffer sb = new StringBuffer("");

		try
		{
			con = ConnectionManager.getConnection(p);
			if(result)
			{	
				try
				{
					//Check for Valid nursing Unit - Practitioner Admission Rights
					strBuffer.delete(0, strBuffer.length());
					strBuffer.append(" Select '1' from ip_nursing_unit_for_pract where "); strBuffer.append("facility_id='"+facilityId+"' and "); strBuffer.append("nursing_unit_code='"+nursingunitcode+"' and "); strBuffer.append("practitioner_id='"+topractitionerid+"' ");
					stmt=con.createStatement();
					srs = stmt.executeQuery(strBuffer.toString());
					if(!srs.next())
					{
						result = false;
						Hashtable message = MessageManager.getMessage( locale, "PRACT_ADMN_RIGHTS_DENIED" ,"IP") ;
						sb.append( (String) message.get("message") ) ;
						message.clear();
						srs.close();
						stmt.close();
					}
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					result = false;
					sb.append("Exception in checking Practitioner Admission Rights "+e.toString());
				}
			}

			if(result)
			{
				try
				{
					//Check for Valid nursing Unit - Speciality Admission Rights
					strBuffer.delete(0, strBuffer.length());
					strBuffer.append(" Select '1' from ip_nurs_unit_for_specialty where "); strBuffer.append("facility_id='"+facilityId+"' and "); strBuffer.append("nursing_unit_code='"+nursingunitcode+"' and "); strBuffer.append("specialty_code='"+tospecialitycode+"' ");

					stmt=con.createStatement();
					srs = stmt.executeQuery(strBuffer.toString());
					if(!srs.next())
					{
						result = false;
						Hashtable message = MessageManager.getMessage( locale, "SPLTY_ADMN_RIGHTS_DENIED" ,"IP") ;
						sb.append( (String) message.get("message") ) ;
						message.clear();
					}
				}
				catch(Exception e)
				{
					result = false;
					sb.append("Exception in checking Speciality Admission Rights "+e.toString());
				}
			}
			
		}catch(Exception e)
		{
			result  = false;
			sb.append( e.getMessage() +" Error in ValidateIPTransferPractitioner " ) ;
			e.printStackTrace() ;
			
			try
			{	
				if(con != null) con.rollback();
			}catch(Exception e1)
			{
				sb.append("error in rollback :"+e1.toString());
			}
		}
		finally
		{
			try
			{
				if(con != null)     ConnectionManager.returnConnection(con,p);
				if(stmt != null)	stmt.close();
				if(srs != null)		srs.close();
			}catch(Exception ce)
			{ 
				sb.append("error in closing db objects : "+ce.toString());
			}
		}

			results.put( "status", new Boolean(result) ) ;
			results.put( "error", sb.toString() ) ;
			return results ;
		} // end ValidateEmergencyTransfer

		/**
		This method is used to transfer the practitioner. 
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

		public HashMap insertIPTransferPractitioner(Properties p,ArrayList arrayList) 
		{
			Iterator iterator=arrayList.iterator();
			Connection con1 			= null;
			int listSize=arrayList.size();
			int listCounter=0;
			boolean result  = false ;
			boolean check=true;
			PreparedStatement pr_pstmt = null;
			PreparedStatement srl_pstmt = null;
			PreparedStatement ip_pstmt = null;
			StringBuffer sb = new StringBuffer("");
			HashMap results = new HashMap() ;
			HashMap hashData=new HashMap();
			String locale = p.getProperty("LOCALE");
			int res=0;
			try{
			con1 = ConnectionManager.getConnection(p);
			con1.setAutoCommit(false);

			while(iterator.hasNext()){
			listCounter=listCounter+1;
			if(check){
			hashData=(HashMap)iterator.next();
			String facilityId		= (String)hashData.get("facilityId");
			String patientid		= (String)hashData.get("patientid");
			String encounter_id		= (String)hashData.get("encounterid");
//			String transferdate		= (String)hashData.get("transferdate");
			String transfertype		= (String)hashData.get("transfertype");
			String frpractitionerid = (String)hashData.get("frpractitionerid");
			String frspecialitycode = (String)hashData.get("frspecialitycode");
			String frteamid			= (String)hashData.get("frteamid");
			String topractitionerid = (String)hashData.get("topractitionerid");
			String tospecialitycode = (String)hashData.get("tospecialitycode");
			String toteamid			= (String)hashData.get("toteamid");
			String nursingunitcode	= (String)hashData.get("nursingunitcode");
			String fmservicecode	= (String)hashData.get("fmservicecode");
			String toservicecode	= (String)hashData.get("toservicecode");
			String bedclass			= (String)hashData.get("bedclass");
			String bedtype			= (String)hashData.get("bedtype");
			String bedno			= (String)hashData.get("bedno");
			String roomno			= (String)hashData.get("roomno");
			String client_ip_address= (String)hashData.get("client_ip_address");
			String admission_date	= (String)hashData.get("admission_date");
			String patient_class	= (String)hashData.get("patient_class");

			String fr_bed_type_code_prv = null;
			String fr_bed_type_code_by_def_prv = null;
			String to_bed_type_code_by_def_prv = null;
			String to_bed_type_code_prv = null;

			hashData.clear();
			results.put( "error", "no error" ) ;
			encounterid			= Long.parseLong(encounter_id);
			String modifiedById	= p.getProperty( "login_user" ) ;
			StringBuffer sql	= new StringBuffer("");	
			int rs ;

			HashMap ret = ValidateIPTransferPractitioner(
									p,
									facilityId,
									topractitionerid,
									tospecialitycode,
									nursingunitcode
									);
			boolean retval=((Boolean)ret.get("status")).booleanValue();
			sb.append((String)ret.get("error"));
			ret.clear();
			if(retval){
			try{
			if(roomno == null || roomno.equals("") || roomno.equals("null"))
			{
				try
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" Select ROOM_NO from ip_nursing_unit_bed WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunitcode+"' And bed_no='"+bedno+"' ");
				
					stmt1 = con1.createStatement();
					srs = stmt1.executeQuery(sql.toString());

					if(srs.next())
					{
						roomno = srs.getString("ROOM_NO");
						if(roomno == null)	roomno = "";
						srs.close();
						stmt1.close();
					}
				}
				catch(Exception e1)
				{	
					result = false;
					check = false;
					sb.append("Exception in selecting room_no :"+e1.getMessage()) ;	
				}
			}


			try
			{
				strBuffer.delete(0, strBuffer.length());
				strBuffer.append(" update pr_encounter set ");
				strBuffer.append(" attend_practitioner_id = ?, specialty_code = ?, team_id = ?, service_code = ?,");
				strBuffer.append("	modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, ");
				strBuffer.append(" modified_facility_id = ?  where facility_id= ? and encounter_id = ? ");

				pr_pstmt = con1.prepareStatement( strBuffer.toString() );
				pr_pstmt.setString	( 1, topractitionerid ) ;
				pr_pstmt.setString	( 2, tospecialitycode ) ;
				pr_pstmt.setString	( 3, toteamid ) ;
				pr_pstmt.setString	( 4, toservicecode ) ;
				pr_pstmt.setString	( 5, modifiedById ) ;
				pr_pstmt.setString	( 6, client_ip_address ) ;
				pr_pstmt.setString	( 7, facilityId ) ;
				pr_pstmt.setString	( 8, facilityId ) ;
				pr_pstmt.setLong	( 9, encounterid ) ;
				rs = pr_pstmt.executeUpdate() ;	
				
				if(rs > 0){
					result = true;
					check = true;
				}
				else{
					result = false;
					check = false;
				}
				if(pr_pstmt != null) pr_pstmt.close() ;
			}catch(SQLException e)
			{
				
				result = false;
				check = false;
				sb.append("Exception in updating pr_encounter table "+e.toString());
			}

			try{
				 int srlno = 0;
				 if(sql.length() > 0) sql.delete(0,sql.length());	
				 //sql.append("select MAX(srl_no)+1 srl_no from ip_adt_trn where facility_id = '"+facilityId+"' and encounter_id = "+encounterid+" ");
				 /*Tuesday, September 29, 2009 SRR20056-SCF-3405.1 IN014928*/
				 sql.append("select srl_no, fr_bed_type_code, fr_bed_type_code_by_defn, to_bed_type_code_by_defn, to_bed_type_code from ip_adt_trn	where facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' and srl_no = (select max (srl_no) from ip_adt_trn where facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"')");
				 stmt   = con1.createStatement();
				 srs = stmt.executeQuery(sql.toString());
				 if(srs.next())
				 {
					   srlno = srs.getInt("srl_no")+1;
					   fr_bed_type_code_prv = srs.getString("fr_bed_type_code");
					   fr_bed_type_code_by_def_prv = srs.getString("fr_bed_type_code_by_defn");
					   to_bed_type_code_by_def_prv = srs.getString("to_bed_type_code_by_defn");
					   to_bed_type_code_prv = srs.getString("to_bed_type_code");
				 }
				 if(stmt!=null)stmt.close();
				 if(srs!=null)srs.close();

			try{
				int srl=0;

				if(srlno > 0 && result){
				if(strBuffer.length() > 0 ) strBuffer.delete(0,strBuffer.length());
				strBuffer.append("  update IP_ADT_TRN set trn_to_date_time = sysdate ");
				//updating audit columns
				strBuffer.append(", modified_by_id = '" + modifiedById  + "', modified_date = sysdate, modified_facility_id = '");
				strBuffer.append( facilityId +"', modified_at_ws_no = '"+ client_ip_address +"'");
				strBuffer.append(" where srl_no = ("+srlno+" - 1) and facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' ");
				srl_pstmt = con1.prepareStatement(strBuffer.toString());
				srl=srl_pstmt.executeUpdate();
				}
				if(srl_pstmt != null) srl_pstmt.close() ;

			}catch(Exception ex){
				 if(stmt!=null)stmt.close();
            	 if(srs!=null)srs.close();
 				result = false;
				check = false;
				sb.append("Exception in updating IP_ADT_TRN Srl_No :"+ex.toString());
			}

			if(result){
				res=0;
				strBuffer.delete(0, strBuffer.length());
				strBuffer.append("  insert into IP_ADT_TRN ");
				strBuffer.append(" (facility_id,encounter_id,srl_no,patient_id,trn_type ");
				strBuffer.append(" ,trn_code,trn_date_time,to_nursing_unit,to_room_no,to_bed_no ");
				strBuffer.append(" ,to_bed_class_code,to_bed_type_code ");
				strBuffer.append(" ,to_bed_type_code_by_defn ");
				strBuffer.append(" ,to_practitioner_id,to_specialty_code ");
				strBuffer.append(" ,fr_nursing_unit_code,fr_room_no,fr_bed_no ");
				strBuffer.append(" ,fr_bed_class_code,fr_bed_type_code ");
				strBuffer.append(" ,fr_bed_type_code_by_defn ");
				strBuffer.append(" ,fr_practitioner_id,fr_specialty_code ");
				strBuffer.append(" ,emergency_trn_yn, practitioner_tfr_yn,added_by_id, added_date   "	);
				strBuffer.append(" ,added_facility_id, added_at_ws_no ,modified_by_id, modified_date " );
				strBuffer.append(" ,modified_facility_id, modified_at_ws_no ,from_pract_team_id , ");
				strBuffer.append(" to_pract_team_id,fr_service_code,to_service_code, tfr_type, patient_class, admission_date_time " );
				strBuffer.append(" ) values ( ?, ?, ?, ?, ?, ?, sysdate,?,?,?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?,?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:MI'))");

				ip_pstmt = con1.prepareStatement( strBuffer.toString() );
				ip_pstmt.setString	( 1, facilityId ) ;
				ip_pstmt.setLong	( 2, encounterid ) ;
				ip_pstmt.setInt	( 3, srlno ) ;
				ip_pstmt.setString	( 4, patientid);
				ip_pstmt.setString	( 5, "T" ) ;
				ip_pstmt.setString	( 6, transfertype ) ;
				ip_pstmt.setString	( 7, nursingunitcode ) ;
				ip_pstmt.setString	( 8, roomno ) ;
				ip_pstmt.setString	( 9, bedno ) ;
				ip_pstmt.setString	( 10, bedclass ) ;
				//ip_pstmt.setString	( 11, bedtype ) ;
				/*Tuesday, September 29, 2009 SRR20056-SCF-3405.1 IN014928*/
				if ( !to_bed_type_code_prv.equals(to_bed_type_code_by_def_prv) )
				{
					ip_pstmt.setString	( 11, to_bed_type_code_prv ) ;
					ip_pstmt.setString	( 12, to_bed_type_code_by_def_prv ) ;
				}
				else
				{
					ip_pstmt.setString( 11, bedtype ) ;
					ip_pstmt.setString( 12, bedtype ) ;
				}
				ip_pstmt.setString	( 13, topractitionerid ) ;
				ip_pstmt.setString	( 14, tospecialitycode ) ;
				ip_pstmt.setString	( 15, nursingunitcode ) ;
				ip_pstmt.setString	( 16, roomno ) ;
				ip_pstmt.setString	( 17, bedno ) ;
				ip_pstmt.setString	( 18, bedclass ) ;
				//ip_pstmt.setString	( 18, bedtype ) ;
				/*Tuesday, September 29, 2009 SRR20056-SCF-3405.1 IN014928*/
				ip_pstmt.setString	( 19, to_bed_type_code_prv ) ;
				ip_pstmt.setString	( 20, to_bed_type_code_by_def_prv ) ;
				ip_pstmt.setString	( 21, frpractitionerid ) ;
				ip_pstmt.setString	( 22, frspecialitycode ) ;
				ip_pstmt.setString	( 23, "N" ) ;
				ip_pstmt.setString	( 24, "Y" ) ;
				ip_pstmt.setString	( 25, modifiedById);
				ip_pstmt.setString	( 26, facilityId ) ;
				ip_pstmt.setString	( 27, client_ip_address ) ;
				ip_pstmt.setString	( 28, modifiedById ) ;
				ip_pstmt.setString	( 29, facilityId ) ;
				ip_pstmt.setString	( 30, client_ip_address ) ;
				ip_pstmt.setString	( 31, frteamid ) ;
				ip_pstmt.setString	( 32, toteamid ) ;
				ip_pstmt.setString	( 33, fmservicecode);
				ip_pstmt.setString	( 34, toservicecode ) ;
				ip_pstmt.setString	( 35, "P" ) ;
				ip_pstmt.setString	( 36, patient_class );
				ip_pstmt.setString	( 37, admission_date );
				res = ip_pstmt.executeUpdate() ;
				if(ip_pstmt != null) ip_pstmt.close() ;
				}
			}catch(Exception e){
				e.printStackTrace();
				result = false;
				check = false;
				sb.append("Exception in updating ip_adt_trn table "+e.toString());
			}
			ret.clear();
			}catch(Exception e){
				check = false;
				result=false;
			}
			 }else {
				result=false;
				check = false;
			}
			
			}//end of check
			if(!check){
				break;
			}
			hashData.clear();
		
	}// end of while
	if(result && listCounter==listSize){
			result = true ;
			Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
			sb.append( (String) message.get("message") ) ;
			con1.commit();
	}else{
			con1.rollback();
	}
	hashData.clear();

}catch(Exception e){
	// First try block
}
		finally 
		{
			try
			{
				if(pstmt != null) pstmt.close() ;
				if(pr_pstmt != null) pr_pstmt.close() ;
				if(srl_pstmt != null) srl_pstmt.close() ;
				if(ip_pstmt != null) ip_pstmt.close() ;
				if(stmt != null) stmt.close();
				if(stmt1 != null) stmt1.close();
				if(srs != null)	 srs.close();
			}catch(SQLException ce)
			{
				ce.printStackTrace();
				sb.append("error in closing db objects "+ce.toString());
			}
			
			if(con != null)
				ConnectionManager.returnConnection(con,p);
			if(con1 != null)
				ConnectionManager.returnConnection(con1,p);
			
		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}//end insert
} // end session bean


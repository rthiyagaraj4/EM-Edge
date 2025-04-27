/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used record referral details for patients.
@author - 
@version - V3
*/

package eIP.IPReferralPatientDetails;
import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="IPReferralPatientDetails"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPReferralPatientDetails"
*	local-jndi-name="IPReferralPatientDetails"
*	impl-class-name="eIP.IPReferralPatientDetails.IPReferralPatientDetailsManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPReferralPatientDetails.IPReferralPatientDetailsLocal"
*	remote-class="eIP.IPReferralPatientDetails.IPReferralPatientDetailsRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPReferralPatientDetails.IPReferralPatientDetailsLocalHome"
*	remote-class="eIP.IPReferralPatientDetails.IPReferralPatientDetailsHome"
*	generate= "local,remote"
*
*
*/
public class IPReferralPatientDetailsManager implements SessionBean 
{
	Connection con				= null;
	PreparedStatement pstmt 	= null ;
	ResultSet rset 				= null;
	Statement stmt 				= null;
	ResultSet srs 				= null;
	int		n_rset				= 0;
	String locale				= "";
	SessionContext ctx;
	public void ejbCreate(){}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){ this.ctx=context;}

	/**
	This method is used to insert referral details for the inpatient.
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

	public java.util.HashMap insertIPReferralPatientDetails(java.util.Properties p,java.util.HashMap hashData) 
	{
		String facilityId			= (String) hashData.get("facilityId");
		String patientid			= (String) hashData.get("patientid");
		String eid					= (String) hashData.get("encounterid");
		String addedAtWorkstation	= (String) hashData.get("client_ip_address");
		String practitionerid		= (String) hashData.get("practitionerid");
		String nursingunitcode		= (String) hashData.get("nursingunitcode");
	//	String referred				= (String) hashData.get("referred");
		String referral_type		= (String) hashData.get("referral_type");
		String referred_to			= (String) hashData.get("referred_to");
		String preferred_date		= (String) hashData.get("preferred_date");
		String location0			= (String) hashData.get("location0");
		String location1			= (String) hashData.get("location1");
		String practitioner			= (String) hashData.get("practitioner");
	//	String practitioner1		= (String) hashData.get("practitioner1");
		String ReferralNotes		= (String) hashData.get("ReferralNotes");
	//	String hcare_setting_type_desc=(String)hashData.get("hcare_setting_type_desc");
		String hcare_setting_type	= (String) hashData.get("hcare_setting_type");
		//String open_to_all_pract_yn	= (String) hashData.get("open_to_all_pract_yn");
		String location1_desc		= (String) hashData.get("location1_desc");
		String practitioner_name	= (String) hashData.get("practitioner_name");
		String from_hcare_setting_type_code= (String) hashData.get("from_hcare_setting_type_code");
		String service				= (String) hashData.get("service");	
		String specialitycode		= (String) hashData.get("specialitycode");
		String priority_type		= (String) hashData.get("priority_type");
		String fromspecialty_code	= (String) hashData.get("fromspecialty_code");
		String fromservice_code		= (String) hashData.get("fromservice_code");
		String Bedside				= (String) hashData.get("Bedside");
		String BedSideDate			= (String) hashData.get("BedSideDate");
		String call_function		= (String) hashData.get("call_function");
		String referral_reason_code	= (String) hashData.get("referral_reason_code");
		String referral_id			= (String) hashData.get("referral_id");
		hashData.clear();

		long   encounterid			= Long.parseLong(eid);
		java.util.HashMap results	= new java.util.HashMap() ;
		boolean result				= false ;
		StringBuffer messageBuffer	= new StringBuffer("");
		StringBuffer sqlBuffer		= new StringBuffer("");
		String addedById			= p.getProperty( "login_user" ) ;
	
		try
		{
			con						= ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			locale					= p.getProperty("LOCALE");

			if(call_function.equals("ReferralPatientDetails"))
			{
				String patient_id="";
				String name_prefix="";
				String first_name="";
				String second_name="";
				String third_name="";
				String family_name="";
				String name_suffix="";
				String patient_name="";
				String sex="";
				String date_of_birth="";
				String nationality_code="";
				String contact1_no="";
				String contact2_no="";
				String addr1_line1="";
				String addr1_line2="";
				String addr1_line3="";
				String addr1_line4="";
				String current_year="";
					   
				try
				{
					sqlBuffer.append(" Select '"+facilityId+"' || to_char(year_num) ");
					sqlBuffer.append(" || lpad(to_char(Next_Referral_num),8,'0')  ref_id");
					sqlBuffer.append(" From am_ref_id_num_for_fcy ");
					sqlBuffer.append(" where facility_id = '"+facilityId+"' ");
					sqlBuffer.append(" and year_num = to_number(to_char(sysdate,'rrrr'))");
					
					stmt=con.createStatement();
					srs=stmt.executeQuery(sqlBuffer.toString());

					if(srs!=null)
					{
						if(srs.next())
						 	referral_id=srs.getString("ref_id");
						else
						{
							if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
							sqlBuffer.append(" Insert into am_ref_id_num_for_fcy ");
							sqlBuffer.append(" ( ");
							sqlBuffer.append(" facility_id,year_num,next_referral_num, ");
							sqlBuffer.append(" added_by_id,added_date,added_at_ws_no,added_facility_id, ");
							sqlBuffer.append(" modified_by_id,modified_date,modified_at_ws_no,modified_facility_id ");
							sqlBuffer.append(" ) ");
							sqlBuffer.append(" values ");
							sqlBuffer.append(" (   '"+facilityId+"', ");
							sqlBuffer.append(" to_number(to_char(sysdate,’yyyy’)), ");
							sqlBuffer.append(" 1, ");
							sqlBuffer.append(" '"+addedById+"', ");
							sqlBuffer.append(" ,sysdate ");
							sqlBuffer.append(" ,'"+addedAtWorkstation+"' ");
							sqlBuffer.append(" ,'"+facilityId+"' ");
							sqlBuffer.append(" ,'"+addedById+"' ");
							sqlBuffer.append(" ,sysdate ");
							sqlBuffer.append(" ,'"+addedAtWorkstation+"' ");
							sqlBuffer.append(" ,'"+facilityId+"' ");
							sqlBuffer.append(" ) ");

							pstmt	= con.prepareStatement( sqlBuffer.toString() ) ;
							n_rset	= pstmt.executeUpdate();
							if(n_rset!=0) result=true;
							else result=false;
							if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
							sqlBuffer.append("select to_char(sysdate,'rrrr') from dual");
							
							stmt	= con.createStatement();
							rset	= stmt.executeQuery(sqlBuffer.toString());
							if(rset!=null)
							{
								while(rset.next())
								{
									current_year=rset.getString(1);
								}
							}
							referral_id= facilityId + current_year + "00000001";
						}
					}
					else
						result=false;
					if(srs !=null)	srs.close();
					if(rset !=null)	rset.close();
					if(stmt!=null)	stmt.close();
					if(pstmt!=null) pstmt.close();
				}
				catch(Exception e)
				{	
					messageBuffer.append("Error while Inserting into am_ref_id_num_for_fcy "+e.toString());
					e.printStackTrace();
					try{
							con.rollback();
							result=false;
						}catch(Exception roll){}
				}

				if(!referral_id.equals(""))
				{
					try
					{
						if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
						sqlBuffer.append(" Select patient_id,name_prefix, first_name,second_name, ");
						sqlBuffer.append(" third_name,family_name,name_suffix,  patient_name, sex, ");
						sqlBuffer.append(" nationality_code,to_char(date_of_birth,'dd/mm/rrrr') bdate , ");
						sqlBuffer.append(" contact1_no,  contact2_no ");
						sqlBuffer.append(" from MP_PATIENT ");
						sqlBuffer.append(" where Patient_id = '"+patientid+"' ");
						stmt=con.createStatement();
						rset=stmt.executeQuery(sqlBuffer.toString());
						if(rset!=null)
						{
							while(rset.next())
							{
								patient_id		= checkForNull(rset.getString("patient_id"));
								name_prefix		= checkForNull(rset.getString("name_prefix"));
								first_name		= checkForNull(rset.getString("first_name"));
								second_name		= checkForNull(rset.getString("second_name"));
								third_name		= checkForNull(rset.getString("third_name"));
								family_name		= checkForNull(rset.getString("family_name"));
								name_suffix		= checkForNull(rset.getString("name_suffix"));
								patient_name	= checkForNull(rset.getString("patient_name"));
								sex				= checkForNull(rset.getString("sex"));
								date_of_birth	= checkForNull(rset.getString("bdate"));
								nationality_code= checkForNull(rset.getString("nationality_code"));
								contact1_no		= checkForNull(rset.getString("contact1_no"));
								contact2_no		= checkForNull(rset.getString("contact2_no"));

							}
						}
						if(rset !=null)	rset.close();
						if(stmt!=null)	stmt.close();
					}catch(Exception e)
					{
						try
						{
							con.rollback();
							result=false;
						}
						catch(Exception roll){}
						messageBuffer.append("Error while selecting from MP_PATIENT"+e.toString());
						e.printStackTrace();
					}
					
				}   // if referral_id
				if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
				sqlBuffer.append(" update pr_encounter set disp_referral_id = '"+referral_id+"', ");
				sqlBuffer.append(" modified_by_id='"+addedById+"',modified_date=sysdate , ");
				sqlBuffer.append(" modified_facility_id='"+facilityId+"',modified_at_ws_no='"+addedAtWorkstation+"' ");
				sqlBuffer.append(" where facility_id = '"+facilityId+"' and encounter_id = "+encounterid+"");

				stmt = con.createStatement();
				stmt.executeUpdate(sqlBuffer.toString());

				// inserting into pr_referral_register

				String to_ref_type		= "";
				String to_facility_id	= "";
				String to_ref_code		= "";

				to_ref_code				=	referred_to;
				to_ref_type				=	referral_type;
				if(to_ref_type.equals("L") || to_ref_type.equals("E"))
					to_ref_code			=   "";

				to_facility_id			=	referred_to;
				if(to_ref_type.equals("X"))
					to_facility_id		= "";

				if(stmt != null) stmt.close();

				try
				{
					if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
					sqlBuffer.append(" Insert into pr_referral_register ");
					sqlBuffer.append("( ");
					sqlBuffer.append(" referral_id,  ");
					sqlBuffer.append("referral_date,  ");
					sqlBuffer.append(" preferred_treatment_date,   ");  
					sqlBuffer.append(" from_ref_type,  ");
					sqlBuffer.append(" from_facility_id,  ");
					sqlBuffer.append(" from_hcare_setting_type,    "); 
					sqlBuffer.append(" from_locn_type, ");
					sqlBuffer.append(" from_locn_code, ");
					sqlBuffer.append(" from_pract_id,    ");
					sqlBuffer.append(" from_encounter_id, ");
					sqlBuffer.append(" patient_id, ");
					sqlBuffer.append(" name_prefix, ");  
					sqlBuffer.append(" first_name, ");
					sqlBuffer.append(" second_name, ");  
					sqlBuffer.append(" third_name, ");
					sqlBuffer.append(" family_name, ");
					sqlBuffer.append(" name_suffix, ");
					sqlBuffer.append(" patient_name, ");
					sqlBuffer.append(" sex, ");
					sqlBuffer.append(" date_of_birth,     ");
					sqlBuffer.append(" nationality_code,   ");
					sqlBuffer.append(" addr_line1,  ");
					sqlBuffer.append(" addr_line2, ");
					sqlBuffer.append(" addr_line3, ");
					sqlBuffer.append(" addr_line4, ");
					sqlBuffer.append(" contact1_no, ");
					sqlBuffer.append(" contact2_no, ");
					//Referred To details
					sqlBuffer.append("to_ref_type, ");
					sqlBuffer.append("to_facility_id, ");
					sqlBuffer.append("to_ref_code, ");
					sqlBuffer.append("to_hcare_setting_type,      ");
					sqlBuffer.append("to_locn_type, ");
					sqlBuffer.append("to_locn_code, ");
					sqlBuffer.append("to_locn_desc, ");
					sqlBuffer.append("to_pract_id, ");
					sqlBuffer.append("to_pract_name, ");
					sqlBuffer.append("ref_notes, ");
					sqlBuffer.append("status, ");
					sqlBuffer.append("added_by_id,             ");
					sqlBuffer.append("added_date,              ");
					sqlBuffer.append("added_at_ws_no,         ");
					sqlBuffer.append("added_facility_id,       ");
					sqlBuffer.append("modified_by_id,          ");
					sqlBuffer.append("modified_date,           ");
					sqlBuffer.append("modified_at_ws_no,      ");
					sqlBuffer.append("modified_facility_id,referral_priority,to_speciality_code,to_service_code,from_speciality_code,from_service_code,BEDSIDE_REFERRAL_YN,referral_reason_code ");
					sqlBuffer.append(") ");
					sqlBuffer.append("values ( ");
					// Referred From Details
					sqlBuffer.append(" '"+referral_id+"', ");
					sqlBuffer.append("sysdate, "); 
					sqlBuffer.append(" to_date('"+preferred_date+"','dd/mm/rrrr hh24:mi') ,");    
					sqlBuffer.append(" 'L', ");// changed from E to L on 13 Sep 2004
					sqlBuffer.append(" '"+facilityId+"', "); 
					sqlBuffer.append(" '"+from_hcare_setting_type_code+"', ");     
					sqlBuffer.append(" 'N', ");
					sqlBuffer.append(" '"+nursingunitcode+"', ");
					sqlBuffer.append(" '"+practitionerid+"',    ");
					sqlBuffer.append(" '"+encounterid+"', ");

				// Patient Details
					sqlBuffer.append(" '"+patient_id+"' , ");
					sqlBuffer.append(" '"+name_prefix+"', "); 
					sqlBuffer.append(" '"+first_name+"' , ");
					sqlBuffer.append(" '"+second_name+"',  ");
					sqlBuffer.append(" '"+third_name+"', ");
					sqlBuffer.append(" '"+family_name+"', ");
					sqlBuffer.append(" '"+name_suffix+"' , ");
					sqlBuffer.append(" '"+patient_name+"', ");
					sqlBuffer.append(" '"+sex+"' , ");
					sqlBuffer.append(" to_date('"+date_of_birth+"','dd/mm/rrrr'),  ");    
					sqlBuffer.append(" '"+nationality_code+"',    ");
					sqlBuffer.append(" '"+addr1_line1+"', "); 
					sqlBuffer.append(" '"+addr1_line2+"', ");
					sqlBuffer.append(" '"+addr1_line3+"', ");
					sqlBuffer.append(" '"+addr1_line4+"', ");
					sqlBuffer.append(" '"+contact1_no+"', ");
					sqlBuffer.append(" '"+contact2_no+"', ");
					sqlBuffer.append(" '"+to_ref_type+"', ");
					sqlBuffer.append(" '"+to_facility_id+"', ");
					sqlBuffer.append(" '"+to_ref_code+"', ");
					sqlBuffer.append(" '"+hcare_setting_type+"' , ");
					sqlBuffer.append(" '"+location0+"', ");				//	 --null if referral type = 'X'
					sqlBuffer.append(" '"+location1+"', ");				//   --null if referral type = 'X'
					sqlBuffer.append(" '"+location1_desc+"',     ");	//   --null if referral type = 'E'
					sqlBuffer.append(" '"+practitioner+"' , ");			//   --null if referral type = 'X'
					sqlBuffer.append(" '"+practitioner_name+"', ");		//	 --null if referral type = 'E'
					sqlBuffer.append(" '"+ReferralNotes+"', ");
					sqlBuffer.append("decode('"+referral_type+"','X','C','O')  , ");
					sqlBuffer.append(" '"+addedById+"' ,");
					sqlBuffer.append(" sysdate , ");
					sqlBuffer.append(" '"+addedAtWorkstation+"' , ");
					sqlBuffer.append(" '"+facilityId+"' , ");
					sqlBuffer.append(" '"+addedById+"' ,");
					sqlBuffer.append("  sysdate , ");
					sqlBuffer.append(" '"+addedAtWorkstation+"' ,");
					sqlBuffer.append(" '"+facilityId+"','"+priority_type+"','"+specialitycode+"', '"+service+"', '"+fromspecialty_code+"' , '"+fromservice_code+"','"+Bedside+"','"+referral_reason_code+"' " );
					sqlBuffer.append(") ");
						
					pstmt=con.prepareStatement(sqlBuffer.toString());
					n_rset=pstmt.executeUpdate();
					if(n_rset!=0) result=true;
					else result=false;
					if(pstmt != null) pstmt.close();
				}
				catch(Exception e)
				{
					try
					{
						con.rollback();
						result=false;
					}
					catch(Exception roll){}
					messageBuffer.append("Error while Inserting into pr_referral_register "+e.toString());
					e.printStackTrace();
				}
				try
				{
					if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
					//Added Audit column
					sqlBuffer.append(" Update am_ref_id_num_for_fcy set next_referral_num = next_referral_num + 1, MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"' where facility_id = '"+facilityId+"' and year_num = to_number(to_char(sysdate,'rrrr'))  ");
					pstmt=con.prepareStatement(sqlBuffer.toString());
					n_rset=pstmt.executeUpdate();
					if(n_rset>0)
						result=true;
					else
						result=false;
					if(pstmt != null) pstmt.close();
				}
				catch(Exception e)
				{
					try
					{
						con.rollback();
						result=false;
					}
					catch(Exception roll){}
					messageBuffer.append("Error While Updating am_ref_id_num_for_fcy "+e.toString());
					e.printStackTrace();
				}

				if (result )
				{
					result = true ;
					java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED","SM");
					messageBuffer.append( (String) message.get("message") ) ;
					message.clear();
					con.commit();
				}
				else
				{
					messageBuffer.append("Transaction Failed.") ;
					con.rollback();
				}
			}
			else if(call_function.equals("BedSideReferral"))
			{
				int count = 0;
				try
				{
					if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());
					sqlBuffer.append("update PR_REFERRAL_REGISTER set BEDSIDE_REF_SEEN_DATE =to_date('"+BedSideDate+"','dd/mm/rrrr hh24:mi'), modified_by_id = '"+addedById+"', ");
					sqlBuffer.append(" modified_date = sysdate, modified_at_ws_no= '"+addedAtWorkstation+"',"); sqlBuffer.append(" modified_facility_id = '"+facilityId+"' where ADDED_FACILITY_ID = '"+facilityId+"' and "); 
					sqlBuffer.append(" FROM_ENCOUNTER_ID= '"+encounterid+"' and BEDSIDE_REFERRAL_YN = 'Y' and REFERRAL_ID='"+referral_id+"' ");

					stmt	= con.createStatement();
					count	= stmt.executeUpdate(sqlBuffer.toString());

					if(count>0)
						result=true;
					else
						result=false;
					if(stmt!=null) stmt.close();
				}
				catch(Exception e)
				{
					con.rollback();
					result=false;
					messageBuffer.append("Error while updating PR_REFERRAL_REGISTER in BedSideReferral "+e.toString());
					e.printStackTrace();
				}
										
				if (result)
				{
					result = true ;
					java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED","SM");
					messageBuffer.append( (String) message.get("message") ) ;
					message.clear();
					con.commit();
				}
				else
				{
					messageBuffer.append("Transaction Failed.") ;
					con.rollback();
				}
			}/// End.of Else bed side
		}
		catch ( Exception e )
		{
			messageBuffer.append( e.getMessage()  ) ;
			e.printStackTrace() ;
			try{
					con.rollback();
			   }catch(Exception e1){}
		}
		finally
		{
			try{
				 if(srs != null)	srs.close();
				 if(rset != null)	rset.close();
				 if(pstmt != null)	pstmt.close() ;
				 if(stmt != null)	stmt.close();
				
				}catch(Exception ce){}

				if(con != null)      ConnectionManager.returnConnection(con,p);
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", messageBuffer.toString() ) ;
		results.put( "referralid", referral_id ) ;
		return results ;
	}//e.o.insert

	/**
	This method is used check if the fields have null values.
	@author - 
	@version - V3
	@param1 - String
	@return - String
	*/

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	
}//e.o.bean



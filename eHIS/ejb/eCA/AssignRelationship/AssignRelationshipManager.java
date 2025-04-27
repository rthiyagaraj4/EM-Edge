/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA.AssignRelationship;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="AssignRelationship"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AssignRelationship"
*	local-jndi-name="AssignRelationship"
*	impl-class-name=eCA.AssignRelationship.AssignRelationshipManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.AssignRelationship.AssignRelationshipLocal"
*	remote-class="eCA.AssignRelationship.AssignRelationshipRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.AssignRelationship.AssignRelationshipLocalHome"
*	remote-class="eCA.AssignRelationship.AssignRelationshipHome"
*	generate= "local,remote"
*
*
*/

public class AssignRelationshipManager implements SessionBean 
{
	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext(SessionContext sessionContext) 
	{
		this.ctx = sessionContext;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertAssignRelationship
								(
									java.util.Properties p,
									java.util.HashMap htAssignRelationship
								)	
	{
		Connection			con		=	null;
		PreparedStatement	pstmt	=	null;
		ResultSet			rs		=	null;
		CallableStatement cs = null;

		java.util.HashMap results =	new java.util.HashMap() ;
		StringBuffer		sb		=	new StringBuffer( "" ) ;

		 String resp_id = "";
		 //visit_id = "",login_user_id = "",
		//String ecis_jdbc_driver	= "", ecis_jdbc_user = "", ecis_jdbc_password = "";
		String patient_id = "", facility_id = "", episode_id = "";
		String  phys_prov_reln_id = "", begin_date_time = "",fromOpenChart_yn="";
		String end_date_time = "",   query_check_duplicate = "";
		String patient_class="",status="01",added_facility_id="",practitioner_id="",addedAtWorkstation="",remarks="";
		String locale = "";
		String error1 = "";
		StringBuffer insert_assign_relationship =new StringBuffer();
		boolean result = false, commit_flag = true ;
		int insert_result = 0;

		try
		{
			patient_id			=	(String) htAssignRelationship.get ( "patient_id"		);
			facility_id			=	(String) htAssignRelationship.get ( "facility_id"		);
			//episode_type		=	(String) htAssignRelationship.get ( "episode_type"		);
			episode_id			=	(String) htAssignRelationship.get ( "episode_id"		);
			//visit_id			=	(String) htAssignRelationship.get ( "visit_id"			);
			//phys_prov_id		=	(String) htAssignRelationship.get ( "phys_prov_id"		);
			phys_prov_reln_id	=	(String) htAssignRelationship.get ( "phys_prov_reln_id" );
			begin_date_time		=	(String) htAssignRelationship.get ( "begin_date_time"	);
			end_date_time		=	(String) htAssignRelationship.get ( "end_date_time"		);
			resp_id				=	(String) htAssignRelationship.get ( "resp_id"			);
			//login_user_id		=	(String) htAssignRelationship.get ( "login_user_id"		);
			
			patient_class		=	(String) htAssignRelationship.get ( "patient_class"	);
			practitioner_id		=	(String) htAssignRelationship.get ( "practitioner_id");
			added_facility_id	=	(String) htAssignRelationship.get ( "added_facility_id");
			addedAtWorkstation	=	(String) htAssignRelationship.get ( "added_at_ws_no");
			fromOpenChart_yn	=	(String) htAssignRelationship.get ( "fromOpenChart_yn");
			locale				=	(String) htAssignRelationship.get ( "locale");
			remarks				=	(String) htAssignRelationship.get ( "remarks");


			String added_by_id = p.getProperty( "login_user" ) ;
			String modified_by_id = added_by_id ;
			String modified_facility_id = added_facility_id ;
			String modified_at_ws_no = addedAtWorkstation ;


			//ecis_jdbc_driver	=	p.getProperty("ecis_jdbc_driver");
			//ecis_jdbc_dns 		=	p.getProperty("ecis_jdbc_dns");
			//ecis_jdbc_user		=	p.getProperty("ecis_jdbc_user");
			//ecis_jdbc_password	=	p.getProperty("ecis_jdbc_password");


			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);

			query_check_duplicate = "select 1 from ca_encntr_pract_reln where patient_id = ? and facility_id = ?  and to_char(NVL(encounter_id,0)) = NVL(?,'0')  and practitioner_id = ? and status='01' and sysdate between begin_date_time and nvl(end_date_time, sysdate) ";

			pstmt	=	con.prepareStatement(query_check_duplicate);

			pstmt.setString(1,patient_id);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,episode_id);
			pstmt.setString(4,practitioner_id);
			if (episode_id.equals("0"))
			{
				episode_id="";
			}

			rs	=	pstmt.executeQuery();

			if(rs!=null && rs.next())
			{
				commit_flag = false;
			
				error1 = getMessage(locale,"ACTIVE_RELN_PRESENT","CA");		
				sb.append( error1 ) ;
				
			}
			else
			{
				if (pstmt!=null) pstmt.close();
				if(insert_assign_relationship.length() > 0) insert_assign_relationship.delete(0,insert_assign_relationship.length());	
				insert_assign_relationship.append("insert into ca_encntr_pract_reln( " );
				insert_assign_relationship.append(" patient_id, ");
				insert_assign_relationship.append(" facility_id,");
				insert_assign_relationship.append(" patient_class, ");
				insert_assign_relationship.append(" encounter_id, ");
				insert_assign_relationship.append(" practitioner_id,");
				insert_assign_relationship.append(" begin_date_time, ");
				insert_assign_relationship.append(" end_date_time, ");
				insert_assign_relationship.append(" direct_yn, ");
				insert_assign_relationship.append(" status, ");
				insert_assign_relationship.append(" added_by_id, ");
				insert_assign_relationship.append(" added_date, ");
				insert_assign_relationship.append(" added_at_ws_no,");
				insert_assign_relationship.append(" ADDED_FACILITY_ID, ");
				insert_assign_relationship.append(" modified_by_id, ");
				insert_assign_relationship.append(" modified_date, ");
				insert_assign_relationship.append(" MODIFIED_AT_WS_NO, ");
				insert_assign_relationship.append(" MODIFIED_FACILITY_ID,  ");
				insert_assign_relationship.append(" PRACT_RELN_ID , ");
				insert_assign_relationship.append("remarks)  ");
				insert_assign_relationship.append(" values ");
				insert_assign_relationship.append("(?, ?, ?, ?, ?, to_date(?, 'dd/mm/yyyy HH24:MI'), to_date(?, 'dd/mm/yyyy HH24:MI'), 'Y', ?, ?, sysdate, ?,?,?,sysdate,?,?,?,?)");

				
				pstmt	=	con.prepareStatement(insert_assign_relationship.toString());

						pstmt.setString( 1,patient_id );      
						pstmt.setString( 2,facility_id);      
						pstmt.setString( 3,patient_class );   
						pstmt.setString( 4,episode_id );    
						//pstmt.setString( 5,phys_prov_id );    
						pstmt.setString( 5,practitioner_id);  
						pstmt.setString( 6,begin_date_time ); 
						pstmt.setString( 7,end_date_time );   

						pstmt.setString( 8,status );          
						pstmt.setString( 9,added_by_id );     
						pstmt.setString( 10,addedAtWorkstation);   
						pstmt.setString( 11,added_facility_id);
						pstmt.setString( 12,modified_by_id );  
						pstmt.setString( 13,modified_at_ws_no);
						pstmt.setString( 14,modified_facility_id);
						pstmt.setString( 15,phys_prov_reln_id);
						pstmt.setString( 16,remarks);

				insert_result = pstmt.executeUpdate();

				if (fromOpenChart_yn.equals("Y"))
				{
					//added
					cs = con.prepareCall("{call MAINTAIN_RECENT_LIST (?,?,?,sysdate,?,?,?,null) }" );

					cs.setString(1, added_facility_id);
					cs.setString(2, added_by_id);
					cs.setString(3, patient_id);
					cs.setString  (4, episode_id);
					cs.setString(5, resp_id);
					cs.setString(6, phys_prov_reln_id);
					cs.execute();
					con.commit();
					if(cs!=null) cs.close();
					//additon end

				}
				if(insert_result<=0)
				{
					commit_flag = false;
				}
			} // end of else
		}
		catch(Exception e)
		{
			commit_flag = false;
			sb.append("Exception@EJB1:"+e);
		}
		finally
		{
			try
			{
				htAssignRelationship.clear();
				if(commit_flag)
				{
					result = true ;
					error1 = getMessage(locale,"RECORD_INSERTED","CA");
					sb.append( error1 ) ;
					con.commit();
				} // if(commit_flag)
				else
				{
					con.rollback();
				}
			}
			catch(Exception e)
			{
				commit_flag = false;
				sb.append("Exception@EJB2:"+e);
				try
				{
					con.rollback();
				}
				catch(Exception e1) {e1.printStackTrace();}
			}
			finally
			{	try{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(con!=null) ConnectionManager.returnConnection(con,p);
				}catch(Exception eClose){eClose.printStackTrace();}
			}
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	} // end of method insertAssignRelationship

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap updateAssignRelationship
								(
									java.util.Properties p,
									java.util.HashMap htAssignRelationship
								)	
	{
		Connection			con		=	null;
		PreparedStatement	pstmt	=	null;

		java.util.HashMap results =	new java.util.HashMap() ;
		StringBuffer		sb		=	new StringBuffer( "" ) ;

		//String ecis_jdbc_driver	= "", ecis_jdbc_dns = "", ecis_jdbc_user = "", ecis_jdbc_password = "",episode_id = "";
		String patient_id = "", facility_id = "",  added_date="";
		//String episode_type = "",patient_class="",status="";
		//String insert_assign_relationship = "",phys_prov_id = "",visit_id = "",begin_date_time = "" , query_check_duplicate = "" ,resp_id = "",addedById="";
		String  phys_prov_reln_id = "";
		String end_date_time = "",  login_user_id = "";
		String added_facility_id="",practitioner_id="",addedAtWorkstation="";
		String error1 = "";
		String locale = "";

		boolean result = false, commit_flag = true ;
		int insert_result = 0;

		String strUpdateSql = "update CA_ENCNTR_PRACT_RELN set END_DATE_TIME=to_date(?,'dd/mm/yyyy hh24:mi:ss'),MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where FACILITY_ID = ? and PATIENT_ID=? and PRACT_RELN_ID=? and PRACTITIONER_ID=? and ADDED_DATE=to_date(?,'dd/mm/yyyy hh24:mi:ss')";

		try
		{
			patient_id			=	(String) htAssignRelationship.get ( "patient_id"		);
			facility_id			=	(String) htAssignRelationship.get ( "facility_id"		);
			//phys_prov_id		=	(String) htAssignRelationship.get ( "phys_prov_id"		);
			phys_prov_reln_id	=	(String) htAssignRelationship.get ( "phys_prov_reln_id" );
			end_date_time		=	(String) htAssignRelationship.get ( "end_date_time"		);
			//resp_id				=	(String) htAssignRelationship.get ( "resp_id"			);
			login_user_id		=	(String) htAssignRelationship.get ( "login_user_id"		);		
			practitioner_id		=	(String)	htAssignRelationship.get ( "practitioner_id");
			added_facility_id	=	(String) htAssignRelationship.get ( "added_facility_id");
			addedAtWorkstation	=	(String) htAssignRelationship.get ( "added_at_ws_no");
			added_date			=	(String) htAssignRelationship.get ( "added_date");
			locale			=	(String) htAssignRelationship.get ( "locale");


			//String added_by_id = p.getProperty( "login_user" ) ;
			//String modified_by_id = added_by_id ;
			//String modified_facility_id = added_facility_id ;
			//String modified_at_ws_no = addedAtWorkstation ;


			//ecis_jdbc_driver	=	p.getProperty("ecis_jdbc_driver");
			//ecis_jdbc_dns 		=	p.getProperty("ecis_jdbc_dns");
			//ecis_jdbc_user		=	p.getProperty("ecis_jdbc_user");
			//ecis_jdbc_password	=	p.getProperty("ecis_jdbc_password");


			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(strUpdateSql);

			pstmt.setString(1,end_date_time);
			pstmt.setString(2,login_user_id);
			pstmt.setString(3,addedAtWorkstation);
			pstmt.setString(4,added_facility_id);
			pstmt.setString(5,facility_id);
			pstmt.setString(6,patient_id);
			pstmt.setString(7,phys_prov_reln_id);
			pstmt.setString(8,practitioner_id);
			pstmt.setString(9,added_date);

			insert_result = pstmt.executeUpdate();

			if(insert_result<=0){
				commit_flag = false;
			}
		}
		catch(Exception e)
		{
			commit_flag = false;
			sb.append("Exception@EJB1:"+e);
			e.printStackTrace();
		}
		finally
		{
			try
			{
				htAssignRelationship.clear();
				if(commit_flag)
				{
					result = true ;
					error1 = getMessage(locale,"RECORD_INSERTED","CA");
					sb.append( error1 );
					con.commit();
				} // if(commit_flag)
				else
				{
					con.rollback();
					sb.append("APP-CA0009 Operation Failed");
				}
			}
			catch(Exception e)
			{
				commit_flag = false;
				sb.append("Exception@EJB2:"+e);
				try
				{
					con.rollback();
				}
				catch(Exception e1) {e1.printStackTrace();}
			}
			finally
			{	try{
					if(pstmt!=null) pstmt.close();
					if(con!=null) ConnectionManager.returnConnection(con,p);
				}catch(Exception eClose){eClose.printStackTrace();}
			}

		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;

		return results ;
	} // end of method updateAssignRelationship
	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
} // end of class AssignRelationshipManager 


/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS.RSStaffProfileSetup ;

import java.rmi.* ;
import java.sql.* ;
import java.util.* ;
import javax.ejb.* ;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="RSStaffProfileSetup"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RSStaffProfileSetup"
*	local-jndi-name="RSStaffProfileSetup"
*	impl-class-name="eRS.RSStaffProfileSetup.RSStaffProfileSetupManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eRS.RSStaffProfileSetup.RSStaffProfileSetupLocal"
*	remote-class="eRS.RSStaffProfileSetup.RSStaffProfileSetupRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eRS.RSStaffProfileSetup.RSStaffProfileSetupLocalHome"
*	remote-class="eRS.RSStaffProfileSetup.RSStaffProfileSetupHome"
*	generate= "local,remote"
*
*
*/


public class RSStaffProfileSetupManager implements SessionBean {

	Connection connection = null;
	PreparedStatement pstmt_insert=null;
	PreparedStatement pstmt_update = null;

	String funcValue			="";
	String login_by_id			="";
	String login_at_ws_no		="";
	String login_facility_id	="";
	String modified_by_id		="";
	String modified_facility_id	="";
	String modified_at_ws_no	="";
	String locale				="";
	public RSStaffProfileSetupManager(){}

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
public HashMap insert(HashMap tabData, HashMap sqlMap) {

		HashMap TabData= tabData;
		HashMap SqlMap= sqlMap;
		HashMap retMap = new HashMap();
		try{

			funcValue			= (String )tabData.get("funcValue");
			if(funcValue.equalsIgnoreCase("Skill"))
				retMap=insertSkill(TabData,SqlMap);
			else if (funcValue.equalsIgnoreCase("training"))
				retMap=insertTraining(TabData,SqlMap);
			else if (funcValue.equalsIgnoreCase("license"))
				retMap=insertLicensure(TabData,SqlMap);
			else if (funcValue.equalsIgnoreCase("expr"))
				retMap=insertExperience(TabData,SqlMap);

		}catch(Exception ex){
				ex.printStackTrace();
		}
		return retMap;
	}

public HashMap insertSkill(HashMap tabData, HashMap sqlMap) {

		HashMap TabData= tabData;
		HashMap SqlMap= sqlMap;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;
		Properties prop	=	(Properties)tabData.get( "properties" );
		int counter = 0;
		int inserted_staff_profile = 0;
		try{

			//connection = getConnection((Properties)tabData.get( "properties" ) );
            connection = ConnectionManager.getConnection(prop);
			inserted_staff_profile= insertStaffProfile(TabData,SqlMap,connection);

			if(inserted_staff_profile > 0){

				HashMap TabDataTemp = (HashMap )tabData.get("InsertData");
				String roleType		= (String) TabDataTemp.get( "role_type" ) ;
				String staffID		= (String) TabDataTemp.get( "staff_id" ) ;
				String skillcode	= (String) TabDataTemp.get( "skill_code" ) ;
				String prof_level	= (String) TabDataTemp.get( "proficiency_level" ) ;

				login_by_id			= (String )TabDataTemp.get("added_by_id");
				login_at_ws_no		= (String )TabDataTemp.get("added_at_ws_no");
				login_facility_id	= (String )TabDataTemp.get("added_facility_id");
				modified_by_id		= (String )TabDataTemp.get("modified_by_id");
				modified_at_ws_no	= (String )TabDataTemp.get("modified_at_ws_no");
				modified_facility_id= (String )TabDataTemp.get("modified_facility_id");
				locale= (String )TabDataTemp.get("locale");

				String SQL_RS_STAFF_INSERT = (String )sqlMap.get("InsertSql");			
				pstmt_insert=connection.prepareStatement(SQL_RS_STAFF_INSERT);

				pstmt_insert.setString( 1, roleType) ;
				pstmt_insert.setString( 2, staffID) ;
				pstmt_insert.setString( 3, skillcode) ;
				pstmt_insert.setString( 4, prof_level) ;
				pstmt_insert.setString( 5, login_by_id) ;
				pstmt_insert.setString( 6, login_at_ws_no) ;
				pstmt_insert.setString( 7, login_facility_id) ;
				pstmt_insert.setString( 8, login_by_id) ;
				pstmt_insert.setString( 9, login_at_ws_no) ;
				pstmt_insert.setString( 10, login_facility_id) ;

				counter = pstmt_insert.executeUpdate() ;
				if(pstmt_insert != null)
					pstmt_insert.close();

				if (counter < 0) {
					connection.rollback();
					Hashtable massageMap = MessageManager.getMessage(connection, "ERROR_IN_INSERTING_INTO");
					messages.append((String)massageMap.get("message"));
				}else if (counter >= 0) {
					connection.commit() ;
					retMap.put( "result", new Boolean( true ) ) ;
					Hashtable massageMap = MessageManager.getMessage(locale, "RECORD_INSERTED","RS");
					messages.append((String)massageMap.get("message"));
				}
			}
		}catch( Exception e ) {
				messages.append( e.getMessage() ) ;
				e.printStackTrace() ;
		}finally {
				try {
					if ( pstmt_insert != null )
						pstmt_insert.close() ;
					if(connection != null)
						//closeConnection(connection,(Properties)tabData.get( "properties" ));
						ConnectionManager.returnConnection(connection,prop);
				}catch ( Exception fe ) {
					fe.printStackTrace() ;
				}
		}
		retMap.put( "message", messages.toString() ) ;
		return retMap;
	}
public HashMap insertTraining(HashMap tabData, HashMap sqlMap) {

		HashMap TabData= tabData;
		HashMap SqlMap= sqlMap;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;
		Properties prop	=	(Properties)tabData.get( "properties" );
		int counter = 0;
		int inserted_staff_profile = 0;
		try{
			//connection = getConnection((Properties)tabData.get( "properties" ) );
            connection = ConnectionManager.getConnection(prop);
			inserted_staff_profile= insertStaffProfile(TabData,SqlMap,connection);

			if(inserted_staff_profile > 0){
				HashMap TabDataTemp = (HashMap )tabData.get("InsertData");

				String roleType			= (String) TabDataTemp.get( "role_type" ) ;
				String staffID			= (String) TabDataTemp.get( "staff_id" ) ;
				String frm_dt			= (String) TabDataTemp.get( "frm_dt" ) ;
				String to_dt			= (String) TabDataTemp.get( "to_dt" ) ;
				String training_code	= (String) TabDataTemp.get( "training_code" ) ;
				String fac_type			= (String) TabDataTemp.get( "fac_type" ) ;
				String fac_id			= (String) TabDataTemp.get( "fac_id" ) ;
				String fac_name			= (String) TabDataTemp.get( "fac_name" ) ;
				String cert				= (String) TabDataTemp.get( "cert" ) ;
				String remarks			= (String) TabDataTemp.get( "remarks" ) ;

				login_by_id			= (String )TabDataTemp.get("added_by_id");
				login_at_ws_no		= (String )TabDataTemp.get("added_at_ws_no");
				login_facility_id	= (String )TabDataTemp.get("added_facility_id");
				modified_by_id		= (String )TabDataTemp.get("modified_by_id");
				modified_at_ws_no	= (String )TabDataTemp.get("modified_at_ws_no");
				modified_facility_id= (String )TabDataTemp.get("modified_facility_id");
				locale= (String )TabDataTemp.get("locale");

				String SQL_RS_TRAINING_INSERT = (String )sqlMap.get("InsertSql");
				pstmt_insert=connection.prepareStatement(SQL_RS_TRAINING_INSERT);

				pstmt_insert.setString( 1, roleType) ;
				pstmt_insert.setString( 2, staffID) ;
				pstmt_insert.setString( 3, training_code) ;
				pstmt_insert.setString( 4, fac_type) ;
				pstmt_insert.setString( 5, fac_id) ;
				pstmt_insert.setString( 6, fac_name) ;
				pstmt_insert.setString( 7, frm_dt) ;
				pstmt_insert.setString( 8, to_dt) ;
				pstmt_insert.setString( 9, cert) ;
				pstmt_insert.setString( 10, remarks) ;
				pstmt_insert.setString( 11, login_by_id) ;
				pstmt_insert.setString( 12, login_at_ws_no) ;
				pstmt_insert.setString( 13, login_facility_id) ;
				pstmt_insert.setString( 14, login_by_id) ;
				pstmt_insert.setString( 15, login_at_ws_no) ;
				pstmt_insert.setString( 16, login_facility_id) ;

				counter = pstmt_insert.executeUpdate() ;
				if(pstmt_insert != null)
					pstmt_insert.close();

				if (counter < 0) {

					connection.rollback();
					Hashtable massageMap = MessageManager.getMessage(connection, "ERROR_IN_INSERTING_INTO");
					messages.append((String)massageMap.get("message"));
				} else if (counter >= 0) {

					connection.commit() ;
					retMap.put( "result", new Boolean( true ) ) ;
					Hashtable massageMap = MessageManager.getMessage(locale, "RECORD_INSERTED","RS");
					messages.append((String)massageMap.get("message"));
				}
			}
		}catch( Exception e ) {
				messages.append( e.getMessage() ) ;
				e.printStackTrace() ;
		}finally {
			try {
				if ( pstmt_insert != null )
					pstmt_insert.close() ;
				if(connection != null) 
					//closeConnection(connection,(Properties)tabData.get( "properties" ));
					ConnectionManager.returnConnection(connection,prop);

			}catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		retMap.put( "message", messages.toString() ) ;
		return retMap;
}

	
public HashMap insertLicensure(HashMap tabData, HashMap sqlMap) {
		HashMap TabData= tabData;
		HashMap SqlMap= sqlMap;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;
		Properties prop	=	(Properties)tabData.get( "properties" );
		int counter = 0;
		int inserted_staff_profile = 0;
		try{
			//connection = getConnection((Properties)tabData.get( "properties" ) );
            connection = ConnectionManager.getConnection(prop);
			inserted_staff_profile= insertStaffProfile(TabData,SqlMap,connection);

			if(inserted_staff_profile > 0){	
				HashMap TabDataTemp = (HashMap )tabData.get("InsertData");

				String roleType			= (String) TabDataTemp.get( "role_type" ) ;
				String staffID			= (String) TabDataTemp.get( "staff_id" ) ;
				String license_code		= (String) TabDataTemp.get( "license_code" ) ;
				String license_id		= (String) TabDataTemp.get( "license_id" ) ;
				String issue_dt			= (String) TabDataTemp.get( "issue_dt" ) ;
				String valid_dt			= (String) TabDataTemp.get( "valid_dt" ) ;
				String facility_type	= (String) TabDataTemp.get( "facility_type" ) ;
				String fac_id			= (String) TabDataTemp.get( "fac_id" ) ;
				String facility_name	= (String) TabDataTemp.get( "facility_name" ) ;
				String remarks			= (String) TabDataTemp.get( "remarks" ) ;
				
				login_by_id			= (String )TabDataTemp.get("added_by_id");
				login_at_ws_no		= (String )TabDataTemp.get("added_at_ws_no");
				login_facility_id	= (String )TabDataTemp.get("added_facility_id");
				modified_by_id		= (String )TabDataTemp.get("modified_by_id");
				modified_at_ws_no	= (String )TabDataTemp.get("modified_at_ws_no");
				modified_facility_id= (String )TabDataTemp.get("modified_facility_id");
				locale= (String )TabDataTemp.get("locale");

				String SQL_RS_LICENSURE_INSERT = (String )sqlMap.get("InsertSql");
				pstmt_insert=connection.prepareStatement(SQL_RS_LICENSURE_INSERT);
		
				pstmt_insert.setString( 1, roleType) ;
				pstmt_insert.setString( 2, staffID) ;
				pstmt_insert.setString( 3, license_code) ;
				pstmt_insert.setString( 4, license_id) ;
				pstmt_insert.setString( 5, issue_dt) ;
				pstmt_insert.setString( 6, valid_dt) ;
				pstmt_insert.setString( 7, facility_type) ;
				pstmt_insert.setString( 8, fac_id) ;
				pstmt_insert.setString( 9, facility_name) ;
				pstmt_insert.setString( 10, remarks) ;
				pstmt_insert.setString( 11, login_by_id) ;
				pstmt_insert.setString( 12, login_at_ws_no) ;
				pstmt_insert.setString( 13, login_facility_id) ;
				pstmt_insert.setString( 14, login_by_id) ;
				pstmt_insert.setString( 15, login_at_ws_no) ;
				pstmt_insert.setString( 16, login_facility_id) ;

				counter = pstmt_insert.executeUpdate() ;
				if(pstmt_insert != null)
					pstmt_insert.close();

				if (counter < 0) {
					connection.rollback();
					Hashtable massageMap = MessageManager.getMessage(connection, "ERROR_IN_INSERTING_INTO");
					messages.append((String)massageMap.get("message"));
				} else if (counter >= 0) {
					connection.commit() ;
					retMap.put( "result", new Boolean( true ) ) ;
					Hashtable massageMap = MessageManager.getMessage(locale, "RECORD_INSERTED","RS");
					messages.append((String)massageMap.get("message"));
				}
			}
		}catch( Exception e ) {
				messages.append( e.getMessage() ) ;
				e.printStackTrace() ;
		}finally {
			try {

				if ( pstmt_insert != null )
					pstmt_insert.close() ;
				if(connection != null)
					//closeConnection(connection,(Properties)tabData.get( "properties" ));
					ConnectionManager.returnConnection(connection,prop);

			}catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		retMap.put( "message", messages.toString() ) ;
		return retMap;
}

	public HashMap insertExperience(HashMap tabData, HashMap sqlMap) {

		
		HashMap TabData= tabData;
		HashMap SqlMap= sqlMap;
		PreparedStatement pstmt_select_srl_no= null;
		PreparedStatement pstmt_curr_position= null;
		ResultSet resultSet 		= null;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;
		Properties prop	=	(Properties)tabData.get( "properties" );
		int counter = 0;
		int inserted_staff_profile = 0;
		int modified_staff_profile=0;
		String srlNo="";
	
		try{
			//connection = getConnection((Properties)tabData.get( "properties" ) );
            connection = ConnectionManager.getConnection(prop);
			inserted_staff_profile= insertStaffProfile(TabData,SqlMap,connection);

			if(inserted_staff_profile > 0){	
			   
			    HashMap TabDataTemp = (HashMap )tabData.get("InsertData");
				
				String roleType			= (String) TabDataTemp.get( "role_type" ) ;
				String staffID			= (String) TabDataTemp.get( "staff_id" ) ;
				String position_code	= (String) TabDataTemp.get( "position_code" ) ;
				String facility_type	= (String) TabDataTemp.get( "facility_type" ) ;
				String facility_id		= (String) TabDataTemp.get( "facility_id" ) ;
				String facility_name	= (String) TabDataTemp.get( "facility_name" ) ;
				String from_date		= (String) TabDataTemp.get( "from_date" ) ;
				String to_date			= (String) TabDataTemp.get( "to_date" ) ;
				String locn_type		= (String) TabDataTemp.get( "locn_type" ) ;
				String workplace_code	= (String) TabDataTemp.get( "workplace_code" ) ;
				String workplace_name	= (String) TabDataTemp.get( "workplace_name" ) ;
				String fte				= (String) TabDataTemp.get( "fte" ) ;
				String grade_code		= (String) TabDataTemp.get( "grade_code" ) ;
				String remarks			= (String) TabDataTemp.get( "remarks" ) ;
				
				login_by_id			= (String )TabDataTemp.get("added_by_id");
				login_at_ws_no		= (String )TabDataTemp.get("added_at_ws_no");
				login_facility_id	= (String )TabDataTemp.get("added_facility_id");
				modified_by_id		= (String )TabDataTemp.get("modified_by_id");
				modified_at_ws_no	= (String )TabDataTemp.get("modified_at_ws_no");
				modified_facility_id= (String )TabDataTemp.get("modified_facility_id");
				locale= (String )TabDataTemp.get("locale");
				String SQL_RS_SELECT_SRLNO = (String )sqlMap.get("select_serialNo");
				String SQL_RS_EXPR_INSERT = (String )sqlMap.get("InsertSql");
			
					int curr_pos=0;
					String SQL_RS_CURRENT_POSITION = (String )sqlMap.get("check_current_position");
					pstmt_curr_position = connection.prepareStatement(SQL_RS_CURRENT_POSITION);
					pstmt_curr_position.setString( 1,roleType.trim());
					pstmt_curr_position.setString( 2,staffID.trim());
					pstmt_curr_position.setString( 3,from_date.trim());
					pstmt_curr_position.setString( 4,to_date.trim());

				   resultSet = pstmt_curr_position.executeQuery() ;
				   while ( resultSet != null && resultSet.next() ) {
						curr_pos=Integer.parseInt(resultSet.getString("count"));
						
					}
					if(resultSet != null)
						resultSet.close();
					if(curr_pos>0){
						connection.rollback();
						messages.append("Cannot enter multiple Current Positions...");
						modified_staff_profile=-1;
					}
				else{
					if(to_date.equals("")||to_date == null)
					modified_staff_profile=modifyStaffProfile(TabData,sqlMap,connection);
					if(modified_staff_profile >= 0){
						pstmt_select_srl_no = connection.prepareStatement(SQL_RS_SELECT_SRLNO);
						pstmt_select_srl_no.setString( 1,roleType.trim());
						pstmt_select_srl_no.setString( 2,staffID.trim());
						resultSet = pstmt_select_srl_no.executeQuery() ;

						while ( resultSet != null && resultSet.next() ) {
							srlNo=resultSet.getString("srlNo");
							
						}
						if(resultSet != null)
							resultSet.close();

						pstmt_insert=connection.prepareStatement(SQL_RS_EXPR_INSERT);
				
						pstmt_insert.setString( 1, roleType) ;
						pstmt_insert.setString( 2, staffID) ;
						pstmt_insert.setString( 3, srlNo) ;
						pstmt_insert.setString( 4, position_code) ;
						pstmt_insert.setString( 5, facility_type) ;
						pstmt_insert.setString( 6, facility_id) ;
						pstmt_insert.setString( 7, facility_name) ;
						pstmt_insert.setString( 8, from_date) ;
						pstmt_insert.setString( 9, to_date) ;
						pstmt_insert.setString( 10, locn_type) ;
						pstmt_insert.setString( 11, workplace_code) ;
						pstmt_insert.setString( 12, workplace_name) ;
						pstmt_insert.setString( 13, grade_code) ;
						pstmt_insert.setString( 14, fte) ;
						pstmt_insert.setString( 15, remarks) ;
						pstmt_insert.setString( 16, login_by_id) ;
						pstmt_insert.setString( 17, login_at_ws_no) ;
						pstmt_insert.setString( 18, login_facility_id) ;
						pstmt_insert.setString( 19, login_by_id) ;
						pstmt_insert.setString( 20, login_at_ws_no) ;
						pstmt_insert.setString( 21, login_facility_id) ;

					   
						counter = pstmt_insert.executeUpdate() ;
						if(pstmt_insert != null)
							pstmt_insert.close();

						if (counter < 0) {
							connection.rollback();
							Hashtable massageMap = MessageManager.getMessage(connection, "ERROR_IN_INSERTING_INTO");
							messages.append((String)massageMap.get("message"));
						} else if (counter >= 0) {
							connection.commit() ;
							retMap.put( "result", new Boolean( true ) ) ;
							Hashtable massageMap = MessageManager.getMessage(locale, "RECORD_INSERTED","RS");
							messages.append((String)massageMap.get("message"));
						}
					}
				}
			}
		}catch( Exception e ) {
				messages.append( e.getMessage() ) ;
				e.printStackTrace() ;
		}finally {
			try {

				if ( pstmt_insert != null )
					pstmt_insert.close() ;
				if ( pstmt_select_srl_no != null )
					pstmt_select_srl_no.close() ;
				if(connection != null) 
					//closeConnection(connection,(Properties)tabData.get( "properties" ));
					ConnectionManager.returnConnection(connection,prop);

			}catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		retMap.put( "message", messages.toString() ) ;
			
		return retMap;
}
private int insertStaffProfile(HashMap tabData, HashMap sqlMap,Connection connection) {

	StringBuffer messages = new StringBuffer() ;
	PreparedStatement pstmt_count_staff_profile = null;
	PreparedStatement pstmt_insert_staff_profile= null;
	ResultSet resultSet 		= null;
	String count				="";
	int result=0;

	HashMap tabDataTemp = (HashMap )tabData.get("InsertData");

	try {
			String roleType		= (String) tabDataTemp.get( "role_type" ) ;
			String staff_type			= (String) tabDataTemp.get( "staff_type" ) ;
			String staffID		= (String) tabDataTemp.get( "staff_id" ) ;
			String eff_status	= "E";	
			login_by_id			= (String )tabDataTemp.get("added_by_id");
			login_at_ws_no		= (String )tabDataTemp.get("added_at_ws_no");
			login_facility_id	= (String )tabDataTemp.get("added_facility_id");
			modified_by_id		= (String )tabDataTemp.get("modified_by_id");
			modified_at_ws_no	= (String )tabDataTemp.get("modified_at_ws_no");
			modified_facility_id= (String )tabDataTemp.get("modified_facility_id");
	
			final String Sql = "SELECT COUNT(*)cnt FROM rs_staff_profile WHERE role_type=? AND staff_id=?";
			pstmt_count_staff_profile = connection.prepareStatement(Sql);
			pstmt_count_staff_profile.setString( 1,roleType.trim());
			pstmt_count_staff_profile.setString( 2,staffID.trim());

			resultSet = pstmt_count_staff_profile.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				count=resultSet.getString("cnt");
			}
			if(resultSet != null)
				resultSet.close();

			int cnt=Integer.parseInt(count);
			if(cnt<=0){ 
					
				String INSERT_STAFF_PROFILE = (String )sqlMap.get("Insert_Staff_Profile");
		
				pstmt_insert_staff_profile = connection.prepareStatement(INSERT_STAFF_PROFILE);

				pstmt_insert_staff_profile.setString( 1,roleType.trim());
				pstmt_insert_staff_profile.setString( 2,staffID.trim());
				pstmt_insert_staff_profile.setString( 3,eff_status.trim());
				pstmt_insert_staff_profile.setString( 4,staff_type.trim());
				pstmt_insert_staff_profile.setString( 5,login_by_id.trim());
				pstmt_insert_staff_profile.setString( 6,login_at_ws_no.trim());
				pstmt_insert_staff_profile.setString( 7,login_facility_id.trim());
				pstmt_insert_staff_profile.setString( 8,login_by_id.trim());
				pstmt_insert_staff_profile.setString( 9,login_at_ws_no.trim());
				pstmt_insert_staff_profile.setString( 10,login_facility_id.trim());

				result=  pstmt_insert_staff_profile.executeUpdate() ;
				if(pstmt_insert_staff_profile != null)
					pstmt_insert_staff_profile.close();
				}else
					result=1;						
			}catch( Exception e ) {
				result = -1;
				messages.append( e.getMessage() ) ;
				e.printStackTrace() ;
			}finally {
			try {
				if ( pstmt_count_staff_profile != null )
					pstmt_count_staff_profile.close() ;
				if ( pstmt_insert_staff_profile != null )
					pstmt_insert_staff_profile.close() ;
			}catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return result;
	}//end of insertStaffProfile

private int modifyStaffProfile(HashMap tabData,HashMap sqlMap, Connection connection) {

	StringBuffer messages = new StringBuffer() ;
	PreparedStatement pstmt_count_staff_profile = null;
	PreparedStatement pstmt_insert_staff_profile= null;
	int result=0;

	HashMap tabDataTemp = (HashMap )tabData.get("InsertData");

	try {
			String role_type		= (String) tabDataTemp.get( "role_type" ) ;
			String staffID		= (String) tabDataTemp.get( "staff_id" ) ;
			String grade_code	=(String) tabDataTemp.get( "grade_code" ) ;
			String position_code	=(String) tabDataTemp.get( "position_code" ) ;
			login_by_id			= (String )tabDataTemp.get("added_by_id");
			login_at_ws_no		= (String )tabDataTemp.get("added_at_ws_no");
			login_facility_id	= (String )tabDataTemp.get("added_facility_id");
			modified_by_id		= (String )tabDataTemp.get("modified_by_id");
			modified_at_ws_no	= (String )tabDataTemp.get("modified_at_ws_no");
			modified_facility_id= (String )tabDataTemp.get("modified_facility_id");
	
				
				String MODIFY_STAFF_PROFILE = (String )sqlMap.get("modify_staffProfile");
		
				pstmt_insert_staff_profile = connection.prepareStatement(MODIFY_STAFF_PROFILE);

				pstmt_insert_staff_profile.setString( 1,grade_code.trim());
				pstmt_insert_staff_profile.setString( 2,position_code.trim());
				pstmt_insert_staff_profile.setString( 3,login_by_id.trim());
				pstmt_insert_staff_profile.setString( 4,login_at_ws_no.trim());
				pstmt_insert_staff_profile.setString( 5,login_facility_id.trim());
				pstmt_insert_staff_profile.setString( 6,role_type.trim());
				pstmt_insert_staff_profile.setString( 7,staffID.trim());

				result=  pstmt_insert_staff_profile.executeUpdate() ;
				if(pstmt_insert_staff_profile != null)
					pstmt_insert_staff_profile.close();
			}catch( Exception e ) {
				result = -1;
				messages.append( e.getMessage() ) ;
				e.printStackTrace() ;
			}finally {
			try {
				if ( pstmt_count_staff_profile != null )
					pstmt_count_staff_profile.close() ;
				if ( pstmt_insert_staff_profile != null )
					pstmt_insert_staff_profile.close() ;
			}catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		
		return result;
	}
	 
	 /**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify(HashMap tabData, HashMap sqlMap ) {
		HashMap retMap = new HashMap();
		HashMap TabData= tabData;
		HashMap SqlMap= sqlMap;
		try{
			funcValue			= (String )tabData.get("funcValue");
			if(funcValue.equalsIgnoreCase("Skill"))
				retMap=modifySkill(TabData,SqlMap);
			else if(funcValue.equalsIgnoreCase("training"))
				retMap=modifyTraining(TabData,SqlMap);
			else if(funcValue.equalsIgnoreCase("license"))
				retMap=modifyLicensure(TabData,SqlMap);
			else if(funcValue.equalsIgnoreCase("expr"))
				retMap=modifyExperience(TabData,SqlMap);
			
		}catch(Exception ex){
				ex.printStackTrace();
		}
		return retMap;
	}


	public HashMap modifySkill(HashMap tabData, HashMap sqlMap) {

		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;
		Properties prop	=	(Properties)tabData.get( "properties" );
		int counter = 0;

		try{

			HashMap tabDataTemp = (HashMap )tabData.get("ModifyData");
			String task			= (String )tabDataTemp.get("task");
			//connection = getConnection((Properties)tabData.get( "properties" ) );
            connection = ConnectionManager.getConnection(prop);

			if(task.equalsIgnoreCase("rec")){

				String roleType		= (String) tabDataTemp.get( "role_type" ) ;
				String staffID		= (String) tabDataTemp.get( "staff_id" ) ;
				String skillcode	= (String) tabDataTemp.get( "skill_code" ) ;
				String prof_level	= (String) tabDataTemp.get( "proficiency_level" ) ;

				modified_by_id		= (String )tabDataTemp.get("modified_by_id");
				modified_at_ws_no	= (String )tabDataTemp.get("modified_at_ws_no");
				modified_facility_id= (String )tabDataTemp.get("modified_facility_id");
				locale= (String )tabDataTemp.get("locale");

				String SQL_RS_STAFF_PROFILE_MODIFY = (String )sqlMap.get("ModifySql");

				pstmt_update=connection.prepareStatement(SQL_RS_STAFF_PROFILE_MODIFY);
				
				pstmt_update.setString( 1, roleType) ;
				pstmt_update.setString( 2, staffID) ;
				pstmt_update.setString( 3, skillcode) ;
				pstmt_update.setString( 4, prof_level) ;
				pstmt_update.setString( 5, modified_by_id) ;
				pstmt_update.setString( 6, modified_at_ws_no) ;
				pstmt_update.setString( 7, modified_facility_id) ;

				pstmt_update.setString( 8, roleType) ;
				pstmt_update.setString( 9, staffID) ;
				pstmt_update.setString( 10, skillcode) ;

				counter = pstmt_update.executeUpdate() ;

			}else if(task.equalsIgnoreCase("del")){

				String roleType		= (String) tabDataTemp.get( "role_type" ) ;
				String staffID		= (String) tabDataTemp.get( "staff_id" ) ;
				String skillcode	= (String) tabDataTemp.get( "skill_code" ) ;

				String SQL_RS_STAFF_PROFILE_DELETE = (String )sqlMap.get("DelSql");

				pstmt_update=connection.prepareStatement(SQL_RS_STAFF_PROFILE_DELETE);
			
				pstmt_update.setString( 1, roleType) ;
				pstmt_update.setString( 2, staffID) ;
				pstmt_update.setString( 3, skillcode) ;

				counter = pstmt_update.executeUpdate() ;
				if(pstmt_update != null)
					pstmt_update.close();
			}//end of if- else condtn
		
			if (counter < 0) {
				connection.rollback();
				Hashtable massageMap = MessageManager.getMessage(connection, "ERROR_IN_UPDATING");
				messages.append((String)massageMap.get("message"));
			} else if (counter >= 0) {
				connection.commit() ;
				retMap.put( "result", new Boolean( true ) ) ;
				Hashtable massageMap = MessageManager.getMessage(locale,"RECORD_MODIFIED","RS");
				messages.append((String)massageMap.get("message"));
			}
		}catch( Exception e ) {
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		}finally {
			try {
				if ( pstmt_update != null )
					pstmt_update.close() ;
				if(connection != null) 
					//closeConnection(connection,(Properties)tabData.get( "properties" ));
					ConnectionManager.returnConnection(connection,prop);

			}catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		retMap.put( "message", messages.toString() ) ;
		return retMap;
	}//END OF MODIFYSKILL

public HashMap modifyTraining(HashMap tabData, HashMap sqlMap) {

		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;
		Properties prop	=	(Properties)tabData.get( "properties" );
		int counter = 0;

		try{

			HashMap tabDataTemp = (HashMap )tabData.get("ModifyData");
			String task			= (String )tabDataTemp.get("task");
			//connection = getConnection((Properties)tabData.get( "properties" ) );
            connection = ConnectionManager.getConnection(prop);

			if(task.equalsIgnoreCase("rec")){
				String roleType		= (String) tabDataTemp.get( "role_type" ) ;
				String staffID		= (String) tabDataTemp.get( "staff_id" ) ;
				String trng_code	= (String) tabDataTemp.get( "training_code" ) ;
				String cert			= (String) tabDataTemp.get( "cert" ) ;
				String remarks		= (String) tabDataTemp.get( "remarks" ) ;

				modified_by_id		= (String )tabDataTemp.get("modified_by_id");
				modified_at_ws_no	= (String )tabDataTemp.get("modified_at_ws_no");
				modified_facility_id= (String )tabDataTemp.get("modified_facility_id");
				locale= (String )tabDataTemp.get("locale");

				String SQL_RS_TRAINING_PROFILE_MODIFY = (String )sqlMap.get("ModifySql");

				pstmt_update=connection.prepareStatement(SQL_RS_TRAINING_PROFILE_MODIFY);
				
				pstmt_update.setString( 1, cert) ;
				pstmt_update.setString( 2, remarks) ;
				pstmt_update.setString( 3, modified_by_id) ;
				pstmt_update.setString( 4, modified_at_ws_no) ;
				pstmt_update.setString( 5, modified_facility_id) ;

				pstmt_update.setString( 6, roleType) ;
				pstmt_update.setString( 7, staffID) ;
				pstmt_update.setString( 8, trng_code) ;

				counter = pstmt_update.executeUpdate() ;
				if(pstmt_update != null)
					pstmt_update.close();
			}else if(task.equalsIgnoreCase("del")){
				String roleType		= (String) tabDataTemp.get( "role_type" ) ;
				String staffID		= (String) tabDataTemp.get( "staff_id" ) ;
				String trng_code	= (String) tabDataTemp.get( "training_code" ) ;

				String SQL_RS_TRAINING_PROFILE_DELETE = (String )sqlMap.get("DelSql");

				pstmt_update=connection.prepareStatement(SQL_RS_TRAINING_PROFILE_DELETE);
			
				pstmt_update.setString( 1, roleType) ;
				pstmt_update.setString( 2, staffID) ;
				pstmt_update.setString( 3, trng_code) ;

				counter = pstmt_update.executeUpdate() ;
				if(pstmt_update != null)
					pstmt_update.close();
			}//end of if- else condtn
			if (counter < 0) {
                connection.rollback();
				Hashtable massageMap = MessageManager.getMessage(connection, "ERROR_IN_UPDATING");
				messages.append((String)massageMap.get("message"));
			} else if (counter >= 0) {
				connection.commit() ;
				retMap.put( "result", new Boolean( true ) ) ;
				Hashtable massageMap = MessageManager.getMessage(locale,"RECORD_MODIFIED","RS");
				messages.append((String)massageMap.get("message"));
			}
		}catch( Exception e ) {
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		}finally {
			try {
				if ( pstmt_update != null ) {
					pstmt_update.close() ;
				}
						
				if(connection != null) {
					//closeConnection(connection,(Properties)tabData.get( "properties" ));
					ConnectionManager.returnConnection(connection,prop);
				}
			}catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		retMap.put( "message", messages.toString() ) ;
		return retMap;
	}//END OF MODIFYTRAINING

	public HashMap modifyLicensure(HashMap tabData, HashMap sqlMap) {

		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;
		Properties prop	=	(Properties)tabData.get( "properties" );
		int counter = 0;

		try{
			HashMap tabDataTemp = (HashMap )tabData.get("ModifyData");
			String task			= (String )tabDataTemp.get("task");
			//connection = getConnection((Properties)tabData.get( "properties" ) );
            connection = ConnectionManager.getConnection(prop);

			if(task.equalsIgnoreCase("rec")){
				String roleType		= (String) tabDataTemp.get( "role_type" ) ;
				String staffID		= (String) tabDataTemp.get( "staff_id" ) ;
				String license_code	= (String) tabDataTemp.get( "license_code" ) ;
				String remarks		= (String) tabDataTemp.get( "remarks" ) ;

				modified_by_id		= (String )tabDataTemp.get("modified_by_id");
				modified_at_ws_no	= (String )tabDataTemp.get("modified_at_ws_no");
				modified_facility_id= (String )tabDataTemp.get("modified_facility_id");
				locale= (String )tabDataTemp.get("locale");

				String SQL_RS_LICENSURE_PROFILE_MODIFY = (String )sqlMap.get("ModifySql");
				pstmt_update=connection.prepareStatement(SQL_RS_LICENSURE_PROFILE_MODIFY);
				
				pstmt_update.setString( 1, remarks) ;
				pstmt_update.setString( 2, modified_by_id) ;
				pstmt_update.setString( 3, modified_at_ws_no) ;
				pstmt_update.setString( 4, modified_facility_id) ;

				pstmt_update.setString( 5, roleType) ;
				pstmt_update.setString( 6, staffID) ;
				pstmt_update.setString( 7, license_code) ;

				counter = pstmt_update.executeUpdate() ;
				if(pstmt_update != null)
					pstmt_update.close();

			}else if(task.equalsIgnoreCase("del")){
					
				String roleType		= (String) tabDataTemp.get( "role_type" ) ;
				String staffID		= (String) tabDataTemp.get( "staff_id" ) ;
				String license_code	= (String) tabDataTemp.get( "license_code" ) ;

				String SQL_RS_LICENSURE_PROFILE_DELETE = (String )sqlMap.get("DelSql");
				pstmt_update=connection.prepareStatement(SQL_RS_LICENSURE_PROFILE_DELETE);
			
				pstmt_update.setString( 1, roleType) ;
				pstmt_update.setString( 2, staffID) ;
				pstmt_update.setString( 3, license_code) ;

				counter = pstmt_update.executeUpdate() ;
				if(pstmt_update != null)
					pstmt_update.close();
			}//end of if- else condtn
			if (counter < 0) {
				connection.rollback();
				Hashtable massageMap = MessageManager.getMessage(connection, "ERROR_IN_UPDATING");
				messages.append((String)massageMap.get("message"));
			} else if (counter >= 0) {
				connection.commit() ;
				retMap.put( "result", new Boolean( true ) ) ;
				Hashtable massageMap = MessageManager.getMessage(locale, "RECORD_MODIFIED","RS");
				messages.append((String)massageMap.get("message"));
			}
		}catch( Exception e ) {
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		}finally {
			try {
				if ( pstmt_update != null )
					pstmt_update.close() ;
				if(connection != null) 
					//closeConnection(connection,(Properties)tabData.get( "properties" ));
					ConnectionManager.returnConnection(connection,prop);
			}catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		retMap.put( "message", messages.toString() ) ;
		return retMap;
	}//END OF MODIFYlICENSURE

public HashMap modifyExperience(HashMap tabData, HashMap sqlMap) {

		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;
		Properties prop	=	(Properties)tabData.get( "properties" );
		int counter = 0;

		try{

			HashMap tabDataTemp = (HashMap )tabData.get("ModifyData");
			String task			= (String )tabDataTemp.get("task");
			//connection = getConnection((Properties)tabData.get( "properties" ) );
            connection = ConnectionManager.getConnection(prop);

				if(task.equalsIgnoreCase("rec")){
					String to_date			= (String) tabDataTemp.get( "to_date" )==null?"":(String) tabDataTemp.get( "to_date" );
					String roleType		= (String) tabDataTemp.get( "role_type" ) ;
					String staffID		= (String) tabDataTemp.get( "staff_id" ) ;
					String serial_no	= (String) tabDataTemp.get( "serial_no" ) ;
					String remarks		= (String) tabDataTemp.get( "remarks" ) ;
					String fte			= (String) tabDataTemp.get( "fte" ) ;

					modified_by_id		= (String )tabDataTemp.get("modified_by_id");
					modified_at_ws_no	= (String )tabDataTemp.get("modified_at_ws_no");
					modified_facility_id= (String )tabDataTemp.get("modified_facility_id");
					locale= (String )tabDataTemp.get("locale");

					String SQL_RS_EXPERIENCE_PROFILE_MODIFY = (String )sqlMap.get("ModifySql");
					pstmt_update=connection.prepareStatement(SQL_RS_EXPERIENCE_PROFILE_MODIFY);
					
					pstmt_update.setString( 1, to_date) ;
					pstmt_update.setString( 2, fte) ;
					pstmt_update.setString( 3, remarks) ;
					pstmt_update.setString( 4, modified_by_id) ;
					pstmt_update.setString( 5, modified_at_ws_no) ;
					pstmt_update.setString( 6, modified_facility_id) ;

					pstmt_update.setString( 7, roleType) ;
					pstmt_update.setString( 8, staffID) ;
					pstmt_update.setString( 9, serial_no) ;
					counter = pstmt_update.executeUpdate() ;
					if(pstmt_update != null)
						pstmt_update.close();

				}else if(task.equalsIgnoreCase("del")){

					String roleType		= (String) tabDataTemp.get( "role_type" ) ;
					String staffID		= (String) tabDataTemp.get( "staff_id" ) ;
					String serial_no	= (String) tabDataTemp.get( "serial_no" ) ;
				   	String SQL_RS_EXPR_PROFILE_DELETE = (String )sqlMap.get("DelSql");

					pstmt_update=connection.prepareStatement(SQL_RS_EXPR_PROFILE_DELETE);
				
					pstmt_update.setString( 1, roleType) ;
					pstmt_update.setString( 2, staffID) ;
					pstmt_update.setString( 3, serial_no) ;
					counter = pstmt_update.executeUpdate() ;
					if(pstmt_update != null)
						pstmt_update.close();
				}//end of if- else condtn

				if (counter < 0) {
					connection.rollback();
					Hashtable massageMap = MessageManager.getMessage(connection, "ERROR_IN_UPDATING");
					messages.append((String)massageMap.get("message"));
				} else if (counter >= 0) {
					connection.commit() ;
					retMap.put( "result", new Boolean( true ) ) ;
					Hashtable massageMap = MessageManager.getMessage(locale, "RECORD_MODIFIED","RS");
					messages.append((String)massageMap.get("message"));
			}
		}catch( Exception e ) {
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		}finally {
			try {
				if ( pstmt_update != null )
					pstmt_update.close() ;
				if(connection != null)
					//closeConnection(connection,(Properties)tabData.get( "properties" ));
					ConnectionManager.returnConnection(connection,prop);
			}catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		retMap.put( "message", messages.toString() ) ;
		return retMap;
	}//END OF MODIFYEXPERIENCE

}

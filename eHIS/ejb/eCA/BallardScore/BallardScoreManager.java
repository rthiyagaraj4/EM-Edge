/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
-------------------------------------------------------------------------------------------------------
?             100            ?          created
2
-------------------------------------------------------------------------------------------------------
*/
package eCA.BallardScore;
import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

/**
*
* @ejb.bean
*	name="BallardScore"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="BallardScore"
*	local-jndi-name="BallardScore"
*	impl-class-name="eCA.BallardScore.BallardScoreManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.BallardScore.BallardScoreLocal"
*	remote-class="eCA.BallardScore.BallardScoreRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.BallardScore.BallardScoreLocalHome"
*	remote-class="eCA.BallardScore.BallardScoreHome"
*	generate= "local,remote"
*
*
*/

public class BallardScoreManager implements SessionBean{
	Connection con;
	//PreparedStatement stmt;
	PreparedStatement pslPrepStmt,pstmt,pstmt1;
	CallableStatement cs;
	ResultSet rs,rs1;
	SessionContext ctx;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext(SessionContext sessioncontext) 
	{
			this.ctx = sessioncontext;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insertBallardScore(Properties p,HashMap hashRecords,String locale)
	{	
		boolean bool = false;
		try
		{			
			String bcode 	= "";
			int bScore	= 0;
			String practitionerId = hashRecords.get("practitionerId")==null ? "" :(String)	hashRecords.get("practitionerId");
			String facilityId =hashRecords.get("facilityId")==null ? "" :(String)	hashRecords.get("facilityId") ;
			String patientId = hashRecords.get("patientId")==null ? "" :(String)hashRecords.get("patientId");
			String encounterId = hashRecords.get("encounterId")==null ? "" :(String)hashRecords.get("encounterId");
			int count = hashRecords.get("count") == null ? 0 : ((Integer)hashRecords.get("count")).intValue();
			String addedById   = p.getProperty( "login_user" )==null ? "" :p.getProperty( "login_user" ) ;			
			String addedAtWSNo = p.getProperty("client_ip_address") ==null ? "" : p.getProperty("client_ip_address");			
			con = ConnectionManager.getConnection(p);			
			String sql = "INSERT INTO CA_BALLARD_SCORE_DTL (BALLARD_SCORE_CODE,PATIENT_ID,EVENT_DATE_TIME, ENCOUNTER_ID, BALLARD_SCORE_VALUE,PRACTITIONER_ID, FACILITY_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,SYSDATE,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";			
			
			pstmt = con.prepareStatement("DELETE FROM CA_BALLARD_SCORE_DTL WHERE PATIENT_ID=? ");
			pstmt.setString(1,patientId);
			pstmt.executeUpdate();
			if (pstmt != null)pstmt.close();
				
			pstmt1 = con.prepareStatement(sql);
			for(int i=0;i<count;i++){					
				bcode 	= hashRecords.get("BCode"+i)==null ? "":(String)hashRecords.get("BCode"+i) ;
				bScore 	= hashRecords.get("BValue"+i)==null ? 0: ((Integer)hashRecords.get("BValue"+i)).intValue();						

				pstmt1.setString(1,bcode);
				pstmt1.setString(2,patientId);
				pstmt1.setString(3,encounterId);
				pstmt1.setInt(4,bScore);
				pstmt1.setString(5,practitionerId);
				pstmt1.setString(6,facilityId);
				pstmt1.setString(7,addedById);
				pstmt1.setString(8,addedAtWSNo);						
				pstmt1.setString(9,facilityId);
				pstmt1.setString(10,addedById);
				pstmt1.setString(11,addedAtWSNo);
				pstmt1.setString(12,facilityId);
				pstmt1.addBatch();
			}
					
			int [] rows = pstmt1.executeBatch();		

			if(rows.length == count)
				bool  = true;

			if(pstmt1 != null) pstmt1.close();

			if(bool){
				con.commit();			
			}else {
				con.rollback();
			}
		} catch(Exception ee){
			try {
				con.rollback();
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}								
			ee.printStackTrace();
			hashRecords.put("results",new Boolean(bool));
			return hashRecords;				
		} finally{
			try{
				if(pstmt != null) pstmt.close();
				if(pstmt1 != null) pstmt1.close();
				if(cs != null) cs.close();
				if(con != null) ConnectionManager.returnConnection(con);
			}catch(Exception ee){
				ee.printStackTrace();
			}
		}
		hashRecords.put("results",new Boolean(bool));
		return hashRecords;
	}

	
	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
} 

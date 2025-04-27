/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This File is saved on 18/10/2005.

package eCP.AssessmentBasedTerminologyCode;

import java.sql.*;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Properties;
import java.util.ArrayList;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
/**
*
* @ejb.bean
*	name="AssessmentBasedTerminologyCode"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AssessmentBasedTerminologyCode"
*	local-jndi-name="AssessmentBasedTerminologyCode"
*	impl-class-name="eCP.AssessmentBasedTerminologyCode.AssessmentBasedTerminologyCodeManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.AssessmentBasedTerminologyCode.AssessmentBasedTerminologyCodeLocal"
*	remote-class="eCP.AssessmentBasedTerminologyCode.AssessmentBasedTerminologyCodeRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.AssessmentBasedTerminologyCode.AssessmentBasedTerminologyCodeLocalHome"
*	remote-class="eCP.AssessmentBasedTerminologyCode.AssessmentBasedTerminologyCodeHome"
*	generate= "local,remote"
*
*
*/
public class AssessmentBasedTerminologyCodeManager
    implements SessionBean
{

	Connection con;
	PreparedStatement pstmt1;
	Statement stmt;
	StringBuffer stringbuffer = new StringBuffer();

    public AssessmentBasedTerminologyCodeManager()
    {
       
    }

    public void ejbCreate()
        throws  CreateException
    {
    }

    public void ejbRemove()
    {
    }

    public void ejbActivate()
    {
    }

    public void ejbPassivate()
    {
    }

    public void setSessionContext(SessionContext sessioncontext)
    {
    }
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
    public HashMap AddModify(Properties properties, HashMap hashtable)
    {
		System.err.println("entering into manager --->");
		stringbuffer = new StringBuffer();
		String msg="";
		HashMap map=new HashMap();
		int insertResult=0;
		ArrayList TerminologyCode			 =		new ArrayList();
		HashMap HeaderValues				=	new HashMap();

		HeaderValues=(HashMap)hashtable.get("HV");
		TerminologyCode=(ArrayList)hashtable.get("TC");
		System.err.println("TerminologyCode in EJB ---- 92--" +TerminologyCode);


		String assessmentCategoryCode=(String)HeaderValues.get("ASSESSMENTCODE");
		String terminologySetId=(String)HeaderValues.get("TERMSETID");
		String type=(String)HeaderValues.get("TYPE");
		String classificationLevels=(String)HeaderValues.get("CLASSIFICATIONLEVEL");
		int classificationLevel=Integer.parseInt(classificationLevels);
		String added_by_id=(String)HeaderValues.get("ADDED_BY_ID");
		String added_facility_id=(String)HeaderValues.get("ADDED_FACILITY_ID");
		String added_at_ws_no =(String)HeaderValues.get("ADDED_AT_WS_NO");
		String locale=(String)HeaderValues.get("locale")==null?"en":(String)HeaderValues.get("locale");
		msg="RECORD_INSERTED";
		System.err.println("assessmentCategoryCode in EJB-->" +assessmentCategoryCode);
		System.err.println("terminologySetId in EJB-->" +terminologySetId);
		System.err.println("type in EJB-->" +type);
		System.err.println("classificationLevels in EJB-->" +classificationLevels);
		System.err.println("classificationLevel in EJB-->" +classificationLevel);
		System.err.println("added_by_id in EJB-->" +added_by_id);
		System.err.println("added_facility_id in EJB-->" +added_facility_id);
		System.err.println("added_at_ws_no in EJB-->" +added_at_ws_no);
		System.err.println("locale in EJB-->" +locale);
		
		String Insert_Query="INSERT INTO CP_TRGD_TERM_CODE_AT_ASSMT(ASSESS_CATG_CODE, TERM_SET_ID, TERM_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
		String Delete_Query="DELETE FROM CP_TRGD_TERM_CODE_AT_ASSMT WHERE ASSESS_CATG_CODE = '"+assessmentCategoryCode+"' AND TERM_SET_ID = '"+terminologySetId+"' AND (TERM_SET_ID,TERM_CODE) IN (SELECT TERM_SET_ID,TERM_CODE FROM MR_TERM_CODE WHERE TERM_SET_ID = '"+terminologySetId+"'  AND CODE_LEVEL = '"+classificationLevel+"'AND ( ('"+type+"'='PR' AND PROCEDURE_YN='Y') OR ('"+type+"'='DX' AND DIAGNOSIS_YN='Y')))";

		try
        {
			
			con = ConnectionManager.getConnection(properties);
			con.setAutoCommit(false);
			stmt=con.createStatement();
			int	delresult=stmt.executeUpdate(Delete_Query);
			System.err.println("delresult in bean--->" +delresult);
			if(stmt!=null) 
			{
				stmt.close();
			   // stmt = null;
			}

            pstmt1 = con.prepareStatement(Insert_Query);
			String termCode = "";
			System.err.println("TerminologyCode.size() in EJB:" +TerminologyCode.size());
			if(delresult==0){
				System.err.println("checking if delrec=0 in EJB");
				   map.clear();
					map.put( "status", new Boolean( true) ) ;
					Hashtable hashtable2 = MessageManager.getMessage(locale, msg,"CP");
		            stringbuffer.append((String)hashtable2.get("message"));
					map.put("error",stringbuffer.toString());
					hashtable.clear();
					con.rollback();
					throw new Exception("Error : CP_LIBRARY");

			}
			else if(delresult>=1 && TerminologyCode.size()>0){
				System.err.println("entering into if condition in EJB");

				 for(int i=0;i<TerminologyCode.size();i++){
					 System.err.println("entering into for loop in EJB");

					termCode=(String)TerminologyCode.get(i);
					pstmt1.setString(1,assessmentCategoryCode);
					pstmt1.setString(2,terminologySetId);
					pstmt1.setString(3,termCode);
					pstmt1.setString(4,added_by_id);
					pstmt1.setString(5,added_at_ws_no);
					pstmt1.setString(6,added_facility_id);
					pstmt1.setString(7,added_by_id);
					pstmt1.setString(8,added_at_ws_no);
					pstmt1.setString(9,added_facility_id);
					pstmt1.addBatch();

				}

				int result1[]=pstmt1.executeBatch();
				System.err.println("result1[]--->" +result1);
					for(int i=0;i<result1.length;i++){
						if(result1[i]<0 && result1[i]!=-2){
							System.err.println("entering into result<0 in EJB----------->");
						insertResult=0;
						System.err.println("insertResult in EJB in if condition---->" +insertResult);
						break;
					}
					else{
						insertResult=1;
						}
					}
			}

			if(insertResult==1)
			{
				System.err.println("insertResult --- in --EJB--" +insertResult);
					map.clear();
					map.put( "status", new Boolean( true) ) ;
					Hashtable hashtable2 = MessageManager.getMessage(locale, msg,"CP");
		            stringbuffer.append((String)hashtable2.get("message"));
					map.put("error",stringbuffer.toString());
					con.commit();
					hashtable.clear();

			}/*else if(delresult>=0){
					System.err.println("delresult --- in --EJB--" +delresult);
				    map.clear();
					map.put( "status", new Boolean( true) ) ;
					Hashtable hashtable2 = MessageManager.getMessage(locale, msg,"CP");
		            stringbuffer.append((String)hashtable2.get("message"));
					map.put("error",stringbuffer.toString());
					con.commit();
					hashtable.clear();
			}
			else{
				System.err.println("entering in Last else in EJB 187");
				    map.clear();
					map.put( "status", new Boolean( false) ) ;
					Hashtable hashtable2 = MessageManager.getMessage(locale, msg,"CP");
					System.err.println("hashtable2 in EJB" +hashtable2);
					stringbuffer.append((String)hashtable2.get("message"));
					map.put("error",stringbuffer.toString());
					hashtable.clear();
					con.rollback();
					throw new Exception("Error : CP_LIBRARY");
			}*/

			 if(con != null)
			{
					if(stmt!=null) 
					{
						stmt.close();
					}
					if(pstmt1 !=null)
					{
						pstmt1.close();
					}
			         if(con != null)
				            ConnectionManager.returnConnection(con, properties);
			}
		}catch(Exception exception){
				stringbuffer.append("Error in main try " + exception.getMessage());
				System.err.println(exception.toString());
				exception.printStackTrace();
		}
	    finally{
		    if(con != null)
			    try{
					if(stmt!=null) 
					{
						stmt.close();
						//stmt = null;
					}
					if(pstmt1 !=null)
					{
						pstmt1.close();
						//pstmt1 = null;
					}
			         if(con != null)
				            ConnectionManager.returnConnection(con, properties);
					}catch(Exception exception2) {
						System.err.println(exception2.toString());
					}
        }

				return map;
	}

}

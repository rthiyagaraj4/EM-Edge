/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This File is saved on 18/10/2005.
package eCP.TerminologyCodeForCaseType;

import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
/**
*
* @ejb.bean
*	name="TerminologyCodeForCaseType"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TerminologyCodeForCaseType"
*	local-jndi-name="TerminologyCodeForCaseType"
*	impl-class-name="eCP.TerminologyCodeForCaseType.TerminologyCodeForCaseTypeManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.TerminologyCodeForCaseType.TerminologyCodeForCaseTypeLocal"
*	remote-class="eCP.TerminologyCodeForCaseType.TerminologyCodeForCaseTypeRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.TerminologyCodeForCaseType.TerminologyCodeForCaseTypeLocalHome"
*	remote-class="eCP.TerminologyCodeForCaseType.TerminologyCodeForCaseTypeHome"
*	generate= "local,remote"
*
*
*/

public class TerminologyCodeForCaseTypeManager
    implements SessionBean
{

	Connection con;
	PreparedStatement pstmt1;
	Statement stmt;
	StringBuffer stringbuffer = new StringBuffer();

    public TerminologyCodeForCaseTypeManager()
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
   public HashMap AddModify(Properties properties, HashMap tabData)
    {
		stringbuffer = new StringBuffer();
		String msg="";
		HashMap map=new HashMap();
		int insertResult=0;
		ArrayList TermCode_Dtl			 =		new ArrayList();
		String term_set_id = (String)tabData.get("term_set_id")==null?"":(String)tabData.get("term_set_id");
        String case_type_code = (String)tabData.get("case_type_code")==null?"":(String)tabData.get("case_type_code");
		String added_by_id=(String)tabData.get("ADDED_BY_ID")==null?"":(String)tabData.get("ADDED_BY_ID");
		String added_facility_id=(String)tabData.get("ADDED_FACILITY_ID")==null?"":(String)tabData.get("ADDED_FACILITY_ID");
		String added_at_ws_no =(String)tabData.get("ADDED_AT_WS_NO")==null?"":(String)tabData.get("ADDED_AT_WS_NO");
		String TotalRecords=(String)tabData.get("TotalRecords")==null?"0":(String)tabData.get("TotalRecords");
		String locale=(String)tabData.get("locale")==null?"en":(String)tabData.get("locale");
		int total_records=Integer.parseInt(TotalRecords);
		String term_code="";
		String mandatory_yn="";
        String actual_yn = "";
        String potential_yn ="";
        String wellness_yn = "";
					
		msg="RECORD_INSERTED";
		 
		
		String Insert_Query="INSERT INTO cp_term_code_for_case_type VALUES (?, ?, ?, ?, ?, ?, ?, ?,  SYSDATE, ?, ?, ?, SYSDATE, ?, ? )";
		String Delete_Query="Delete from cp_term_code_for_case_type where term_set_id = '"+term_set_id+"'and case_type_code='"+case_type_code+"' and (term_set_id,term_code) in (select term_set_id,term_code from mr_term_code where term_set_id = '"+term_set_id+"')  ";
		try
        {
			
			con = ConnectionManager.getConnection(properties);
			con.setAutoCommit(false);

			stmt=con.createStatement();
			int	delresult=stmt.executeUpdate(Delete_Query);
			if(stmt!=null) 
			{
				stmt.close();
				//stmt = null;
			}

			if(delresult>=0 && total_records>0){
				pstmt1 = con.prepareStatement(Insert_Query);
				for(int i=0;i<total_records;i++){
					TermCode_Dtl=(ArrayList)tabData.get("select"+i);
					term_code=(String)TermCode_Dtl.get(0);
					mandatory_yn=(String)TermCode_Dtl.get(1);
					actual_yn=(String)TermCode_Dtl.get(2);
					potential_yn=(String)TermCode_Dtl.get(3);
					wellness_yn=(String)TermCode_Dtl.get(4);
					pstmt1.setString(1, case_type_code);
					pstmt1.setString(2, term_set_id);
					pstmt1.setString(3, term_code);
					pstmt1.setString(4, actual_yn);
					pstmt1.setString(5, potential_yn);
					pstmt1.setString(6, wellness_yn);
					pstmt1.setString(7, mandatory_yn);
					pstmt1.setString(8,added_by_id);
					pstmt1.setString(9,added_at_ws_no);
					pstmt1.setString(10,added_facility_id);
					pstmt1.setString(11,added_by_id);
					pstmt1.setString(12,added_at_ws_no);
					pstmt1.setString(13,added_facility_id);
					pstmt1.addBatch();
				}
				int result1[]=pstmt1.executeBatch();
					for(int i=0;i<result1.length;i++){
						if(result1[i]<0 && result1[i]!=-2){
						insertResult=0;
						break;
					}
					else{
						insertResult=1;
						}
					}
			}
			if(insertResult==1)
			{
					map.clear();
					map.put( "status", new Boolean( true) ) ;
					Hashtable hashtable2 = MessageManager.getMessage(locale, msg,"CP");
		            stringbuffer.append((String)hashtable2.get("message"));
					map.put("error",stringbuffer.toString());
					con.commit();
					}
			else if(delresult>=0){

				map.clear();
					map.put( "status", new Boolean( true) ) ;
					Hashtable hashtable2 = MessageManager.getMessage(locale, msg,"CP");
		            stringbuffer.append((String)hashtable2.get("message"));
					map.put("error",stringbuffer.toString());
					con.commit();

			}else{
				map.clear();
					map.put( "status", new Boolean( false) ) ;
					Hashtable hashtable2 = MessageManager.getMessage(locale, msg,"CP");
					stringbuffer.append((String)hashtable2.get("message"));
					map.put("error",stringbuffer.toString());
					con.rollback();
					throw new Exception("Error : CP_LIBRARY");
			}
			if(pstmt1!=null) 
					pstmt1.close();
			 if(con != null)
				            ConnectionManager.returnConnection(con, properties);
		}catch(Exception exception){
			map.put( "status", new Boolean( false) ) ;
			map.put( "error", exception ) ;
				stringbuffer.append("Error in main try " + exception.getMessage());
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
					if(pstmt1!=null) 
					{
						pstmt1.close();
						//pstmt1 = null;
					}
			         if(con != null)
				            ConnectionManager.returnConnection(con, properties);
					}catch(Exception exception2) { System.err.println(exception2.toString());}
        }
				return map;
	}

}

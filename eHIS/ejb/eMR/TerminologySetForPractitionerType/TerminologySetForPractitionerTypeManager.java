/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR.TerminologySetForPractitionerType;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.*;


/**
*
* @ejb.bean
*	name="TerminologySetForPractitionerType"  
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TerminologySetForPractitionerType"
*	local-jndi-name="TerminologySetForPractitionerType"
*	impl-class-name="eMR.TerminologySetForPractitionerType.TerminologySetForPractitionerTypeManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMR.TerminologySetForPractitionerType.TerminologySetForPractitionerTypeLocal"
*	remote-class="eMR.TerminologySetForPractitionerType.TerminologySetForPractitionerTypeRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMR.TerminologySetForPractitionerType.TerminologySetForPractitionerTypeLocalHome"
*	remote-class="eMR.TerminologySetForPractitionerType.TerminologySetForPractitionerTypeHome"
*	generate= "local,remote"
*
*
*/

public class TerminologySetForPractitionerTypeManager implements SessionBean{
	Connection connection					= null;

	StringBuffer traceVal						= new StringBuffer();

	PreparedStatement pstmt_insert		=null;
	PreparedStatement pstmt_delete		= null;
	
	String pract_type		="";
	String term_set_id	 ="";
	String added_by_id="";
	String added_at_ws_no="";
	String added_facility_id	="";
	String modified_by_id	="";
	String modified_facility_id	="";
	String modified_at_ws_no	 ="";
	int total_records;

	public TerminologySetForPractitionerTypeManager(){}

	public void ejbCreate(){}

	public void ejbRemove(){}

	public void ejbActivate(){}

	public void ejbPassivate(){}

    public void setSessionContext(SessionContext sessioncontext)
	{
	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap modify(Properties ppts,HashMap tabData) {

		//Properties ppts = null;
		HashMap retMap = new HashMap();
		retMap.put( "result", new Boolean( false ) ) ;
		StringBuffer messages = new StringBuffer() ;
		RecordSet	TerminologySetForPractitionerType1	=	null;
		int[] resCnt = null;
		term_set_id				=	(String)tabData.get("term_set_id");
		added_by_id				=	(String)tabData.get("added_by_id");
		added_at_ws_no		=	(String)tabData.get("added_at_ws_no");
		added_facility_id		=	(String)tabData.get("added_facility_id");
		ppts								=	(Properties)tabData.get("properties");
		String locale			=	ppts.getProperty("LOCALE");
		modified_by_id			=	added_by_id;
		modified_at_ws_no	=	added_at_ws_no;
		modified_facility_id	=	added_facility_id;
		TerminologySetForPractitionerType1	=	(webbeans.eCommon.RecordSet)tabData.get("recordSet");

		
        total_records = Integer.parseInt((String)tabData.get("total_records")==null?"0":	(String)tabData.get("total_records"));
        boolean delete_flag = false;
        boolean insert_flag = true;
        try
        {
            connection = ConnectionManager.getConnection(ppts);
            connection.setAutoCommit(false);
            String sql_delete = "";
            int delet = 0;
            sql_delete = "delete from mr_term_set_for_pract_type where term_set_id=?";
            pstmt_delete = connection.prepareStatement(sql_delete);
			pstmt_delete.setString(1,term_set_id);

			delet = pstmt_delete.executeUpdate();
			pstmt_delete.close();

            if(delet>= 0)
                delete_flag = true;
            else
                delete_flag = false;

			String sql_insert = "insert into mr_term_set_for_pract_type (pract_type,term_set_id,added_by_id, added_date, added_at_ws_no,added_facility_id,modified_by_id, modified_date, modified_at_ws_no,modified_facility_id,dflt_term_set_yn) values(?,?,?,sysdate,?,?,?,sysdate,?,?,?)";
			pstmt_insert = connection.prepareStatement(sql_insert);

            for(int k = 0; k <total_records; k++){

                pract_type = (String)tabData.get("select" + k)==null?"":(String)tabData.get("select" + k);
                pstmt_insert.setString(1, pract_type);
                pstmt_insert.setString(2, term_set_id);
                pstmt_insert.setString(3, added_by_id);
                pstmt_insert.setString(4, added_at_ws_no);
                pstmt_insert.setString(5, added_facility_id);
                pstmt_insert.setString(6, modified_by_id);
                pstmt_insert.setString(7, modified_at_ws_no);
                pstmt_insert.setString(8, modified_facility_id);
				if(!(TerminologySetForPractitionerType1.containsObject(pract_type))){
					pstmt_insert.setString(9, "N");
				}else{
					pstmt_insert.setString(9, "Y");
				}
				pstmt_insert.addBatch();
			}
			if(delete_flag)
				resCnt = pstmt_insert.executeBatch();
			if((resCnt != null)&&(delete_flag))
				insert_flag = true;
			else
				insert_flag = false;

            if(insert_flag){
                connection.commit();
 				
				retMap.put( "flag" , "" );
				Hashtable massageMap = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				messages.append((String)massageMap.get("message"));
				if ( massageMap != null ) massageMap.clear();
			}
			else
			{
				connection.rollback();
				retMap.put( "result", new Boolean( false ) ) ;
				retMap.put( "flag" , "" );
				Hashtable massageMap = MessageManager.getMessage(locale, "ERROR_INSERTING","SM");
				messages.append((String)massageMap.get("message"));
				if ( massageMap != null ) massageMap.clear();
			}
        }
        catch(Exception e){
		try{
			connection.rollback();
			retMap.put( "result", new Boolean( false ) ) ;
			retMap.put( "flag" , "" );
			traceVal.append(e.getMessage());
            Hashtable massageMap = MessageManager.getMessage(locale, "ERROR_INSERTING","SM");
            messages.append((String)massageMap.get("message"));
			if ( massageMap != null ) massageMap.clear();
		}catch(Exception ex)	{
			ex.printStackTrace();
		}
	}
	finally{

		try{
		if(pstmt_insert != null) 
			pstmt_insert.close();
		if(pstmt_delete != null)
			pstmt_delete.close();

		if(connection != null) {
			ConnectionManager.returnConnection(connection,ppts);
		}
		}catch(Exception ey)
		{
			ey.printStackTrace();
		}
	}

	//retMap.put( "message", messages.toString() ) ;
	//retMap.put( "result", new Boolean( true ) ) ;
	retMap.put("status", new Boolean(insert_flag));
    retMap.put("error", messages.toString());

	//retMap.put( "traceVal",traceVal.toString());
	//retMap.put( "invalidCode" , "");
	return retMap;

    }
}

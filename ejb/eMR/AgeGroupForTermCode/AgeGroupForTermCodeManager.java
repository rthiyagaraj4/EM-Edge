/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR.AgeGroupForTermCode;

import java.rmi.RemoteException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

/**
*
* @ejb.bean
*	name="AgeGroupForTermCode"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AgeGroupForTermCode"
*	local-jndi-name="AgeGroupForTermCode"
*	impl-class-name="eMR.AgeGroupForTermCode.AgeGroupForTermCodeManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMR.AgeGroupForTermCode.AgeGroupForTermCodeLocal"
*	remote-class="eMR.AgeGroupForTermCode.AgeGroupForTermCodeRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMR.AgeGroupForTermCode.AgeGroupForTermCodeLocalHome"
*	remote-class="eMR.AgeGroupForTermCode.AgeGroupForTermCodeHome"
*	generate= "local,remote"
*
*
*/

public class AgeGroupForTermCodeManager
    implements SessionBean
{

	Connection con;
    PreparedStatement pstmt;
	PreparedStatement pstmt1;
	Statement stmt;
	//ResultSet rs;
	SessionContext ctx;
	StringBuffer stringbuffer = new StringBuffer();

    public AgeGroupForTermCodeManager()
    {
    }

    public void ejbCreate()
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
        ctx =sessioncontext;
    }

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

   public HashMap AddModify(Properties properties, HashMap hmap)
   {
		stringbuffer = new StringBuffer();
		String msg="";
		HashMap map=new HashMap();
		int insertResult=0;
		ArrayList TerminologyCode	=	new ArrayList();
		HashMap HeaderValues		=	new HashMap();
		TerminologyCode=(ArrayList)hmap.get("TerminologyCode");
		String term_set_id = (String)hmap.get("term_set_id");
        String age_group_code = (String)hmap.get("age_group_code");
        String added_by_id=(String)hmap.get("ADDED_BY_ID");
		String added_facility_id=(String)hmap.get("ADDED_FACILITY_ID");
		String added_at_ws_no =(String)hmap.get("ADDED_AT_WS_NO");
		String locale = properties.getProperty("LOCALE");
		msg="RECORD_INSERTED";
		String Insert_Query="INSERT INTO mr_age_grp_for_term_code VALUES (?, ?, ?, ?,SYSDATE, ?, ?, ?, SYSDATE, ?, ? )";
		String Delete_Query="Delete from mr_age_grp_for_term_code where term_set_id = '"+term_set_id+"'and age_group_code='"+age_group_code+"' and (term_set_id,term_code) in (select term_set_id,term_code from mr_term_code where term_set_id = '"+term_set_id+"')  ";
		try
        {
			
			con = ConnectionManager.getConnection(properties);
			
			stmt=con.createStatement();
			int	delresult=stmt.executeUpdate(Delete_Query);
/*			con.commit();
			if(con!=null)con=null;*/
			if(stmt!=null)stmt.close();
			if(!TerminologyCode.equals("")){
	//			con = ConnectionManager.getConnection(properties);
				con.setAutoCommit(false);
			if(delresult>=0 && TerminologyCode.size()>0){

					pstmt1 = con.prepareStatement(Insert_Query);
				 for(int i=0;i<TerminologyCode.size();i++){

				  String term_code=(String)TerminologyCode.get(i);
					pstmt1.setString(1, term_set_id);
					pstmt1.setString(2, term_code);
					pstmt1.setString(3, age_group_code);
					pstmt1.setString(4,added_by_id);
					pstmt1.setString(5,added_at_ws_no);
					pstmt1.setString(6,added_facility_id);
					pstmt1.setString(7,added_by_id);
					pstmt1.setString(8,added_at_ws_no);
					pstmt1.setString(9,added_facility_id);
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
		}


			if(insertResult==1)
			{
					map.clear();
					map.put( "status", new Boolean( true) ) ;
					Hashtable hashtable2 = MessageManager.getMessage(locale, msg,"SM");
		            stringbuffer.append((String)hashtable2.get("message"));
					map.put("error",stringbuffer.toString());
					con.commit();
					hmap.clear();
					if ( hashtable2 != null ) hashtable2.clear();
			}else if(delresult>=0){
				map.clear();
					map.put( "status", new Boolean( true) ) ;
					Hashtable hashtable2 = MessageManager.getMessage(locale, msg,"SM");
		            stringbuffer.append((String)hashtable2.get("message"));
					map.put("error",stringbuffer.toString());
					con.commit();
					hmap.clear();
					if ( hashtable2 != null ) hashtable2.clear();
			}else{
				map.clear();
					map.put( "status", new Boolean( false) ) ;
					Hashtable hashtable2 = MessageManager.getMessage(locale, msg,"SM");
					stringbuffer.append((String)hashtable2.get("message"));
					map.put("error",stringbuffer.toString());
					hmap.clear();
					con.rollback();
					if ( hashtable2 != null ) hashtable2.clear();
					throw new Exception("Error : CP_LIBRARY");
			}

		}catch(Exception exception){
			map.put( "status", new Boolean( false) ) ;
				stringbuffer.append("Error in main try " + exception.getMessage());
				exception.printStackTrace();

		}
	    finally{
			    try{
					if(pstmt != null)
						pstmt.close();
					if(pstmt1 !=null)
						pstmt1.close();
			         if(con != null)
				            ConnectionManager.returnConnection(con, properties);
					}catch(Exception exception2) { }
        }
				if ( TerminologyCode != null) TerminologyCode.clear();
				if ( HeaderValues != null) HeaderValues.clear();
				return map;
	}

}

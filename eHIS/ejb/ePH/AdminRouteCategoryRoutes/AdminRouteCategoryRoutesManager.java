/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.AdminRouteCategoryRoutes;

import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import ePH.Common.PhEJBSessionAdapter ;
/**
*
* @ejb.bean
*	name="AdminRouteCategoryRoutes"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AdminRouteCategoryRoutes"
*	local-jndi-name="AdminRouteCategoryRoutes"
*	impl-class-name="ePH.AdminRouteCategoryRoutes.AdminRouteCategoryRoutesManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.AdminRouteCategoryRoutes.AdminRouteCategoryRoutesLocal"
*	remote-class="ePH.AdminRouteCategoryRoutes.AdminRouteCategoryRoutesRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.AdminRouteCategoryRoutes.AdminRouteCategoryRoutesLocalHome"
*	remote-class="ePH.AdminRouteCategoryRoutes.AdminRouteCategoryRoutesHome"
*	generate= "local,remote"
*
*
*/

public class AdminRouteCategoryRoutesManager extends PhEJBSessionAdapter //  implements SessionBean
{

	Connection con;
	PreparedStatement pstmt1;
	Statement stmt;
	StringBuffer stringbuffer = new StringBuffer();

    public AdminRouteCategoryRoutesManager()
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
        String admin_route_categ_code = (String)tabData.get("admin_route_categ_code")==null?"":(String)tabData.get("admin_route_categ_code");
		String added_by_id=(String)tabData.get("ADDED_BY_ID")==null?"":(String)tabData.get("ADDED_BY_ID");
		String added_facility_id=(String)tabData.get("ADDED_FACILITY_ID")==null?"":(String)tabData.get("ADDED_FACILITY_ID");
		String added_at_ws_no =(String)tabData.get("ADDED_AT_WS_NO")==null?"":(String)tabData.get("ADDED_AT_WS_NO");
		String TotalRecords=(String)tabData.get("TotalRecords")==null?"0":(String)tabData.get("TotalRecords");
		//String locale=(String)tabData.get("locale")==null?"en":(String)tabData.get("locale"); //Commented for COMMON-ICN-0048
		int total_records=Integer.parseInt(TotalRecords);
		String route_code="";
		
					
		msg="RECORD_INSERTED";
		 
		
		String Insert_Query="INSERT INTO ph_admin_route_catg_dtl VALUES (?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )";
		String Delete_Query="Delete from ph_admin_route_catg_dtl where ADMIN_ROUTE_CATG_CODE = '"+admin_route_categ_code+"'";
		try
        {
			
			con = getConnection(properties);
			con.setAutoCommit(false);

			stmt=con.createStatement();
			int	delresult=stmt.executeUpdate(Delete_Query);
			closeStatement(stmt);
			
			if(delresult>=0 && total_records>0){
				pstmt1 = con.prepareStatement(Insert_Query);
				for(int i=0;i<total_records;i++){
					TermCode_Dtl=(ArrayList)tabData.get("select"+i);
					route_code=(String)TermCode_Dtl.get(0);
					pstmt1.setString(1, admin_route_categ_code);
					pstmt1.setString(2, route_code);
					pstmt1.setString(3,added_by_id);
					pstmt1.setString(4,added_at_ws_no);
					pstmt1.setString(5,added_facility_id);
					pstmt1.setString(6,added_by_id);
					pstmt1.setString(7,added_at_ws_no);
					pstmt1.setString(8,added_facility_id);
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
				map.put( "result", new Boolean( true) ) ;				
				map.put("msgid",msg);
				con.commit();
			}
			else if(delresult>=0){
				map.clear();				
				map.put( "result", new Boolean( true) ) ;				
				map.put("msgid",msg);
				con.commit();
			}else{
				map.clear();
				msg="TRANSACTION_FAILED";				
				map.put( "result", new Boolean( false) );				
				map.put("msgid",msg);
				con.rollback();
				throw new Exception("Error : PH_ADMIN_ROUTE");
			}

			if(pstmt1!=null) 
				closeStatement(pstmt1);

			 if(con != null)
				closeConnection(con, properties);
		}catch(Exception exception){			
			msg="TRANSACTION_FAILED";
			map.put( "result", new Boolean(false));
			map.put("msgid",msg);			
			exception.printStackTrace();
		}
	    finally{
		    if(con != null)
			    try{
					if(stmt!=null) 
						closeStatement(stmt);

					if(pstmt1!=null) 
						closeStatement(pstmt1);
						
					if(con != null)
							closeConnection(con, properties);
				}
				catch(Exception exception2){
					exception2.printStackTrace();
				}
        }
		return map;
	}

}

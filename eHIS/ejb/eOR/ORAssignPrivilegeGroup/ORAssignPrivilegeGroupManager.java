/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORAssignPrivilegeGroup;

import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import javax.ejb.* ;
import eOR.Common.* ;
/**
*
* @ejb.bean
*	name="ORAssignPrivilegeGroup"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORAssignPrivilegeGroup"
*	local-jndi-name="ORAssignPrivilegeGroup"
*	impl-class-name="eOR.ORAssignPrivilegeGroup.ORAssignPrivilegeGroupManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eOR.ORAssignPrivilegeGroup.ORAssignPrivilegeGroupLocal"
*	remote-class="eOR.ORAssignPrivilegeGroup.ORAssignPrivilegeGroupRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORAssignPrivilegeGroup.ORAssignPrivilegeGroupLocalHome"
*	remote-class="eOR.ORAssignPrivilegeGroup.ORAssignPrivilegeGroupHome"
*	generate= "local,remote"
*
*
*/

public class ORAssignPrivilegeGroupManager extends OrEJBSessionAdapter {
	StringBuffer traceVal = new StringBuffer() ;
    Connection connection = null ;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt_del = null ;
	PreparedStatement pstmt_update = null ;
/**
* @ejb.interface-method
*	 view-type="both"
*/

    public HashMap insert( HashMap tabDataParam, HashMap sqlMap ){
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		boolean insert_flag = false ;
		boolean delete_flag = false ;
		String dtl_grp_by_code= "",prev_grp_code="";
		String login_by_id				= "";
		String login_at_ws_no			= "";
		String login_facility_id		= "";
		int [] insertCounts ;
		int [] deleteCounts ;
		String SQL_OR_ASSIGN_PRIVILEGE_GROUP_INSERT = (String) sqlMap.get("SQL_OR_ASSIGN_PRIVILEGE_GROUP_INSERT");
		String SQL_OR_ASSIGN_PRIVILEGE_GROUP_DELETE = (String) sqlMap.get("SQL_OR_ASSIGN_PRIVILEGE_GROUP_DELETE");
		
		ArrayList deleteArrList	= new ArrayList();
		ArrayList insertArrList = new ArrayList();
		Hashtable HashHdrData			= new Hashtable();
		insertArrList			= (ArrayList)tabDataParam.get("insertArrList");
		deleteArrList			= (ArrayList)tabDataParam.get("deleteArrList");
		HashHdrData				= (Hashtable)tabDataParam.get("MultiHashData");
		dtl_grp_by_code			= (String)HashHdrData.get("dtl_grp_by_code");
		prev_grp_code			= (String)HashHdrData.get("prev_grp_code");
		login_by_id				= (String)HashHdrData.get("login_by_id");
		login_at_ws_no			= (String)HashHdrData.get("login_at_ws_no");
		login_facility_id		= (String)HashHdrData.get("login_facility_id");

		try
		{
			connection = getConnection((Properties)tabDataParam.get("properties")) ;
		}
		catch(Exception Exp)
		{
			Exp.printStackTrace();
			throw new EJBException( Exp.getMessage() ) ;
		}

		try
		{
			pstmt_del	= connection.prepareStatement(SQL_OR_ASSIGN_PRIVILEGE_GROUP_DELETE);
			 if(insertArrList.size() >0)
				insert_flag = false;
			else
				insert_flag = true;

			if(deleteArrList.size() >0)
				delete_flag = false;
			else
				delete_flag = true;

			if(insertArrList.size() >0)
			{
				pstmt = connection.prepareStatement(SQL_OR_ASSIGN_PRIVILEGE_GROUP_INSERT);
				HashMap tabData  = null;

				for(int k=0; k < insertArrList.size(); k++)
				{
					tabData  = (HashMap)insertArrList.get(k);
					if (tabData != null)
					{
						pstmt.setString(1 ,prev_grp_code)	 ;
						pstmt.setString(2 ,dtl_grp_by_code);
						pstmt.setString(3 ,(String)tabData.get("code"));
						pstmt.setString(4 ,login_by_id);
						pstmt.setString(5 ,login_at_ws_no);
						pstmt.setString(6 ,login_facility_id);
						pstmt.setString(7 ,login_by_id);
						pstmt.setString(8 ,login_at_ws_no);
						pstmt.setString(9 ,login_facility_id);
						pstmt.addBatch();
					}
				}
				insertCounts = pstmt.executeBatch();

				for (int i=0;i<insertCounts.length ;i++ )
				{
					if(insertCounts[i]<0  && insertCounts[i] != -2 )
					{
						insert_flag = false;
						break;
					}
					else
					{
						insert_flag = true;
					}
				}
			}

			if(insert_flag && deleteArrList.size() >0 )
			{
				
				HashMap delMapData  = null;

				for(int k=0; k < deleteArrList.size(); k++)
				{
					delMapData  = (HashMap)deleteArrList.get(k);
					if(delMapData != null )
					{
						pstmt_del.setString(1, prev_grp_code);
						pstmt_del.setString(2, (String)delMapData.get("code"));
						pstmt_del.addBatch();
					}
				}

			    deleteCounts = pstmt_del.executeBatch();
				
				for (int i=0;i<deleteCounts.length ;i++ )
				{
					if(deleteCounts[i]<0  && deleteCounts[i] != -2 )
					{
						delete_flag=false;
						break;
					}
					else
					{
						delete_flag=true;
					}
				}
		    }
	
			if(insert_flag && delete_flag)
			{
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append( "RECORD_INSERTED" ) ;
			}
			else
			{
				connection.rollback();
				map.put( "result", new Boolean( false ) ) ;
				throw new EJBException("Insert/Update Failed");
			}

		}
		catch(Exception e)
		{
			/*added by kishore kumar N On Aug-21-09 */
			e.printStackTrace();
			/*ends here. */
			traceVal.append(e.getMessage());
			map.put( "traceVal", traceVal.toString() ) ;
		}
		finally
		{
		   try
		   {
				closeStatement( pstmt ) ;
				closeStatement( pstmt_del ) ;
				closeConnection( connection, (Properties)tabDataParam.get( "properties" ) );
			}
			catch ( Exception fe )
			{
				fe.printStackTrace() ;
				traceVal.append(fe.getMessage());
				map.put( "traceVal", traceVal.toString() ) ;
			}
		}
		map.put( "message", messages.toString() ) ;
		map.put( "traceVal", traceVal.toString() ) ;
		return map ;
	}

/**
* @ejb.interface-method
*	 view-type="both"
*/
 public HashMap modify( HashMap tabDataParam, HashMap sqlMap ) {
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
        boolean update_flag = false ;
		String prev_group_code	= "";
		String resp_pract_code	= "";
        String login_by_id			    = "";
		String login_at_ws_no			= "";
		String login_facility_id			= "";
		String applevel			= "";
		String insertrec		= "";
		int updateCounts ;
		int insertCounts ;
		String SQL_OR_PRIVILEGE_GROUP_CODE_UPDATE = (String) sqlMap.get("SQL_OR_PRIVILEGE_GROUP_CODE_UPDATE");
		String SQL_OR_ASSIGN_PRIVILEGE_GROUP_INSERT = (String) sqlMap.get("SQL_OR_ASSIGN_PRIVILEGE_GROUP_INSERT");
		 Hashtable HashHdrData			= new Hashtable();
		 HashHdrData				= (Hashtable)tabDataParam.get("MultiHashData");
		 prev_group_code			= (String)HashHdrData.get("prev_group_code");
		 resp_pract_code			= (String)HashHdrData.get("resp_pract_code");
		 applevel			= (String)HashHdrData.get("applevel");
		 insertrec			= (String)HashHdrData.get("insertrec");
		 login_by_id				= (String)HashHdrData.get("login_by_id");
		 login_at_ws_no			= (String)HashHdrData.get("login_at_ws_no");
		 login_facility_id		= (String)HashHdrData.get("login_facility_id");

		try
		{
			connection				= getConnection((Properties)tabDataParam.get("properties")) ;
		}catch(Exception Exp){
			throw new EJBException( Exp.getMessage() ) ;
		}
       try{		 if(insertrec.equals("Y"))
		            {
					pstmt					= connection.prepareStatement(SQL_OR_ASSIGN_PRIVILEGE_GROUP_INSERT);
					pstmt.setString(1 ,prev_group_code)	 ;
					pstmt.setString(2 ,applevel);
					pstmt.setString(3 ,resp_pract_code);
					pstmt.setString(4 ,login_by_id);
					pstmt.setString(5 ,login_at_ws_no);
					pstmt.setString(6 ,login_facility_id);
					pstmt.setString(7 ,login_by_id);
					pstmt.setString(8 ,login_at_ws_no);
					pstmt.setString(9 ,login_facility_id);
                    insertCounts = pstmt.executeUpdate();
					if(insertCounts<0  && insertCounts != -2 )
					 update_flag=false;
					 else
					  update_flag=true;
					}
					else
		            {
				    pstmt_update					= connection.prepareStatement(SQL_OR_PRIVILEGE_GROUP_CODE_UPDATE);
				    pstmt_update.setString(1 ,prev_group_code);
					pstmt_update.setString(2 ,resp_pract_code);
				    updateCounts = pstmt_update.executeUpdate();
			       if(updateCounts<0  && updateCounts != -2 ){
						update_flag=false;
						}
					else{
					update_flag=true;
					}
					}
		if(update_flag ){
			connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_MODIFIED" ) ;
		}
		else{
			connection.rollback();
			map.put( "result", new Boolean( false ) ) ;
			throw new EJBException("Insert/Update Failed");
		}

	}
	catch(Exception e){
	traceVal.append(e.getMessage());
	map.put( "traceVal", traceVal.toString() ) ;
	}
	finally{
	   try {
		    closeStatement( pstmt ) ;
			closeStatement( pstmt_update ) ;
			closeConnection( connection, (Properties)tabDataParam.get( "properties" ) );
		}catch ( Exception fe ) {
			fe.printStackTrace() ;
			traceVal.append(fe.getMessage());
			map.put( "traceVal", traceVal.toString() ) ;
		}
	}
	map.put( "message", messages.toString() ) ;
	map.put( "traceVal", traceVal.toString() ) ;
	return map ;
	}
/**
* @ejb.interface-method
*	 view-type="both"
*/
     public HashMap delete( HashMap tabDataParam, HashMap sqlMap ) {
		//StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "") ;
		return map ;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public String savePrevilegeGrpsForUser(ArrayList<String> previGrpLst, HashMap<String, String> map, Properties properties, String groupBy)
	{
		Connection con = null ;
		PreparedStatement insPst = null;
		PreparedStatement delPst= null;
		if ( previGrpLst != null && map != null && properties != null && groupBy != null)
		{
			try
			{
				con = getConnection(properties);
				con.setAutoCommit(false);
				if(groupBy.equals("PR"))
				{
					delPst = con.prepareStatement(map.get("SQL_OR_ASSIGN_PRIVILEGE_TO_PRACTITIONER_DELETE"));
					delPst.setString(1, map.get("user"));
					delPst.setString(2, map.get("appLevel"));
					delPst.executeUpdate();
					delPst.close();
				}
				else if(groupBy.equals("PG") && map.get("user").equals("*ALL"))
				{
					delPst = con.prepareStatement(map.get("SQL_OR_PRIVILEGE_GROUP_ALL_DELETE"));
					delPst.setString(1, previGrpLst.get(0));
					delPst.setString(2, map.get("appLevel"));
					delPst.executeUpdate();
					delPst.close();
				}
				String prevGrpInsQry = map.get("SQL_OR_ASSIGN_PRIVILEGE_GROUP_INSERT");
				insPst = con.prepareStatement(prevGrpInsQry);
				for(String previlegeCode : previGrpLst)
				{
					insPst.setString(1, previlegeCode);
					insPst.setString(2, map.get("appLevel"));
					insPst.setString(3, map.get("user"));
					insPst.setString(4, map.get("addedId"));
					insPst.setString(5, map.get("addedAtWsNo"));
					insPst.setString(6, map.get("addedFac"));
					insPst.setString(7, map.get("modifiedId"));
					insPst.setString(8, map.get("modifiedAtWsNo"));
					insPst.setString(9, map.get("modifiedFac"));
					insPst.executeUpdate();
				}
				insPst.close();
				con.commit();
				return "SUCCESS";
			}
			catch (Exception e)
			{
				e.printStackTrace();
				try
				{
					con.rollback();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
				return e.getMessage();
			}
			finally
			{
				try
				{
					con.close();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		}
		return "FAIL";
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public String removePrivilegeForAllusers(String prgId, String appLevel, String qry, Properties properties)
	{
		Connection con = null ;
		if (appLevel != null && prgId != null && qry != null && properties != null)
		{
			try
			{
				con = getConnection(properties);
				con.setAutoCommit(false);
				PreparedStatement delPst = con.prepareStatement(qry);
				delPst.setString(1, prgId);
				delPst.setString(2, appLevel);
				delPst.executeUpdate();
				delPst.close();
				con.commit();
				return "SUCCESS";
			}
			catch (Exception e)
			{
				e.printStackTrace();
				try
				{
					con.rollback();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
				return e.getMessage();
			}
			finally
			{
				try
				{
					con.close();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		}
		return "FAIL";
	}
}///End of Class

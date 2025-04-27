/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.ORPrivilegeGroup ;


import java.rmi.* ;
import java.util.* ;
import java.sql.* ;
import eOR.Common.* ;
import javax.ejb.* ;

import webbeans.eCommon.*;

import eCommon.Common.*;

/**
*
* @ejb.bean
*	name="ORPrivilegeGroup"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ORPrivilegeGroup"
*	local-jndi-name="ORPrivilegeGroup"
*	impl-class-name="eOR.ORPrivilegeGroup.ORPrivilegeGroupManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOR.ORPrivilegeGroup.ORPrivilegeGroupLocal"
*	remote-class="eOR.ORPrivilegeGroup.ORPrivilegeGroupRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOR.ORPrivilegeGroup.ORPrivilegeGroupLocalHome"
*	remote-class="eOR.ORPrivilegeGroup.ORPrivilegeGroupHome"
*	generate= "local,remote"
*
*
*/

public class ORPrivilegeGroupManager extends OrEJBSessionAdapter {

/**
* @ejb.interface-method
*	 view-type="both"
*/
		 
public HashMap insert(HashMap tabDataParam , HashMap sqlMap ) {
	System.out.println("tabDataParam in insert"+tabDataParam);
		String login_by_id = "";
		String login_at_ws_no = "";
		String login_facility_id = "";
		boolean atleastonce=false;
		boolean F_or=false;
		boolean F_vw=false;
		boolean F_au=false;
		boolean F_sa=false;
		boolean F_cs=false;
		boolean F_rr=false;
		boolean F_cn=false;
		boolean F_rc=false;
	 	StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;
		Connection connection = null ;
		PreparedStatement pstmt_group = null ;
		PreparedStatement pstmt_rights = null ;
		HashMap privilegeHeaderStr=null;
		HashMap category=null;
		HashMap ordertype=null;
		HashMap catalog=null;
		
		ResultSet rs =null;
	//	int counter = 0;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "insert" ) ;
		//boolean flag = true ;

		HashMap tabDataMultiple = null ;
		Properties pt = null ;
	try {
		 pt = (Properties)tabDataParam.get( "properties" ) ;
		 tabDataMultiple = (HashMap)tabDataParam.get("tabData");
		 String SQL_OR_PRIVILEGE_GROUP_INSERT	   =(String)sqlMap.get("SQL_OR_PRIVILEGE_GROUP_INSERT");
		 String SQL_OR_PRIVILEGE_GROUP_DUP	   =(String)sqlMap.get("SQL_OR_PRIVILEGE_GROUP_DUP");
		 String SQL_OR_PRIVILEGE_GROUP_INSERT_ACCESS_RIGHTS =(String)sqlMap.get("SQL_OR_PRIVILEGE_GROUP_INSERT_ACCESS_RIGHTS");
		connection = getConnection(pt) ;
		privilegeHeaderStr=(HashMap)tabDataMultiple.get("privilegeHeaderStr");
		category=(HashMap)tabDataMultiple.get("category");
		int category_reccount = category.size();
		ordertype=(HashMap)tabDataMultiple.get("ordertype");
		int ordertype_reccount = ordertype.size();
		catalog=(HashMap)tabDataMultiple.get("catalog");
		int catalog_reccount = catalog.size();
		 System.out.println("tabDataMultiple"+tabDataMultiple);
		 System.out.println("privilegeHeaderStr"+privilegeHeaderStr);
		 System.out.println("category"+category);
		 String arrChkDup[]  =  new String[1] ;
		 String Privilege_id =((((String)privilegeHeaderStr.get("Privilege_id")).equals("null"))||((String)privilegeHeaderStr.get("Privilege_id")==null))?"":((String)privilegeHeaderStr.get("Privilege_id")).trim();
		  String Privilege_desc =((((String)privilegeHeaderStr.get("Privilege_long_desc")).equals("null"))||((String)privilegeHeaderStr.get("Privilege_long_desc")==null))?"":((String)privilegeHeaderStr.get("Privilege_long_desc"));
		  String eff_status_yn =((((String)privilegeHeaderStr.get("eff_status_yn")).equals("null"))||((String)privilegeHeaderStr.get("eff_status_yn")==null))?"":((String)privilegeHeaderStr.get("eff_status_yn"));
		  login_at_ws_no =((((String)tabDataMultiple.get("login_at_ws_no")).equals("null"))||((String)tabDataMultiple.get("login_at_ws_no")==null))?"":((String)tabDataMultiple.get("login_at_ws_no"));
		  login_by_id =((((String)tabDataMultiple.get("login_by_id")).equals("null"))||((String)tabDataMultiple.get("login_by_id")==null))?"":((String)tabDataMultiple.get("login_by_id"));
		  login_facility_id =((((String)tabDataMultiple.get("login_facility_id")).equals("null"))||((String)tabDataMultiple.get("login_facility_id")==null))?"":((String)tabDataMultiple.get("login_facility_id"));
		arrChkDup[0] = Privilege_id ;
		boolean duplicate = chkDuplicate(SQL_OR_PRIVILEGE_GROUP_DUP,connection,arrChkDup);
		//System.out.println("Privilege_id----"+Privilege_id);
		//System.out.println("duplicate----"+duplicate);
		if(duplicate)
		{
		  String msg  =	 "CODE_ALREADY_EXISTS";
		  map.put( "message", msg ) ;
          map.put( "flag", "Duplicate") ;
		  map.put( "traceVal", "dup loop records" ) ;
		  connection.rollback();
		  return map ;
		}
		pstmt_group = connection.prepareStatement(SQL_OR_PRIVILEGE_GROUP_INSERT);
		pstmt_rights = connection.prepareStatement(SQL_OR_PRIVILEGE_GROUP_INSERT_ACCESS_RIGHTS);
		pstmt_group.setString(1,Privilege_id);
		pstmt_group.setString(2,Privilege_desc);
		pstmt_group.setString(3,login_by_id);
		pstmt_group.setString(4,login_at_ws_no);
		pstmt_group.setString(5,login_facility_id);
		pstmt_group.setString(6,login_by_id);
		pstmt_group.setString(7,login_at_ws_no);
		pstmt_group.setString(8,login_facility_id);
		pstmt_group.setString(9,eff_status_yn);

		

			 //System.out.println("category_reccount----"+category_reccount);
		if(category_reccount>0)
		{
			Set s;
			Iterator it;
			s = category.entrySet();
			it = s.iterator();
			while (it.hasNext()){
				String temp_category=it.next().toString();
				//System.out.println("temp_category----"+temp_category);
				String[] hashvalue=temp_category.split("=");
				//System.out.println("hashvalue----"+hashvalue[0]+"==="+hashvalue[1]);
				String[] values=hashvalue[0].split("!!");
				//System.out.println("values----"+values[0]+"==="+values[1]);
				String Priv_type=values[0];
				String memb_id=values[1];
				String memb_ref="C";
				String Acc_priv=hashvalue[1];
				if(!(Acc_priv.equals("defaultSelect")))
				{
				atleastonce=true;
				pstmt_rights.setString(1 ,Privilege_id);
				pstmt_rights.setString(2 ,Priv_type);
				pstmt_rights.setString(3 ,memb_ref);
				pstmt_rights.setString(4 ,memb_id);
				pstmt_rights.setString(5 ,Acc_priv);
				pstmt_rights.setString(6,login_by_id);
				pstmt_rights.setString(7,login_at_ws_no);
				pstmt_rights.setString(8,login_facility_id);
				pstmt_rights.setString(9,login_by_id);
				pstmt_rights.setString(10,login_at_ws_no);
				pstmt_rights.setString(11,login_facility_id);
				pstmt_rights.addBatch();
				if(Priv_type.equals("OR"))
					F_or=true;
				else if(Priv_type.equals("VW"))
					F_vw=true;
				else if(Priv_type.equals("AU"))
					F_au=true;
				else if(Priv_type.equals("SA"))
					F_sa=true;
				else if(Priv_type.equals("CS"))
					F_cs=true;
				else if(Priv_type.equals("RR"))
					F_rr=true;
				else if(Priv_type.equals("CN"))
					F_cn=true;
				else if(Priv_type.equals("RC"))
					F_rc=true;
				}

			}
		}
		if(ordertype_reccount>0)
		{
			Set s;
			Iterator it;
			s = ordertype.entrySet();
			it = s.iterator();
			while (it.hasNext()){
				String temp_ordertype=it.next().toString();
				String[] hashvalue=temp_ordertype.split("=");
				String[] values=hashvalue[0].split("!!");
				String Priv_type=values[0];
				String memb_id=values[2];
				String memb_ref="T";
				String Acc_priv=hashvalue[1];
				if(!(Acc_priv.equals("defaultSelect")))
				{
				atleastonce=true;
				pstmt_rights.setString(1 ,Privilege_id);
				pstmt_rights.setString(2 ,Priv_type);
				pstmt_rights.setString(3 ,memb_ref);
				pstmt_rights.setString(4 ,memb_id);
				pstmt_rights.setString(5 ,Acc_priv);
				pstmt_rights.setString(6,login_by_id);
				pstmt_rights.setString(7,login_at_ws_no);
				pstmt_rights.setString(8,login_facility_id);
				pstmt_rights.setString(9,login_by_id);
				pstmt_rights.setString(10,login_at_ws_no);
				pstmt_rights.setString(11,login_facility_id);
				pstmt_rights.addBatch();
				if(Priv_type.equals("OR"))
					F_or=true;
				else if(Priv_type.equals("VW"))
					F_vw=true;
				else if(Priv_type.equals("AU"))
					F_au=true;
				else if(Priv_type.equals("SA"))
					F_sa=true;
				else if(Priv_type.equals("CS"))
					F_cs=true;
				else if(Priv_type.equals("RR"))
					F_rr=true;
				else if(Priv_type.equals("CN"))
					F_cn=true;
				else if(Priv_type.equals("RC"))
					F_rc=true;
				}

			}
		}
	if(catalog_reccount>0)
		{
			Set s;
			Iterator it;
			s = catalog.entrySet();
			it = s.iterator();
			while (it.hasNext()){
				String temp_catalog=it.next().toString();
				String[] hashvalue=temp_catalog.split("=");
				String[] values=hashvalue[0].split("!!");
				String Priv_type=values[0];
				String memb_id=values[3];
				String memb_ref="I";
				String Acc_priv=hashvalue[1];
				if(!(Acc_priv.equals("defaultSelect")))
				{
				atleastonce=true;
				pstmt_rights.setString(1 ,Privilege_id);
				pstmt_rights.setString(2 ,Priv_type);
				pstmt_rights.setString(3 ,memb_ref);
				pstmt_rights.setString(4 ,memb_id);
				pstmt_rights.setString(5 ,Acc_priv);
				pstmt_rights.setString(6,login_by_id);
				pstmt_rights.setString(7,login_at_ws_no);
				pstmt_rights.setString(8,login_facility_id);
				pstmt_rights.setString(9,login_by_id);
				pstmt_rights.setString(10,login_at_ws_no);
				pstmt_rights.setString(11,login_facility_id);
				pstmt_rights.addBatch();
				if(Priv_type.equals("OR"))
					F_or=true;
				else if(Priv_type.equals("VW"))
					F_vw=true;
				else if(Priv_type.equals("AU"))
					F_au=true;
				else if(Priv_type.equals("SA"))
					F_sa=true;
				else if(Priv_type.equals("CS"))
					F_cs=true;
				else if(Priv_type.equals("RR"))
					F_rr=true;
				else if(Priv_type.equals("CN"))
					F_cn=true;
				else if(Priv_type.equals("RC"))
					F_rc=true;
				}

			}
		}
		
		if(!atleastonce)
		{
		  String msg  = "ATLEAST_ONE_SELECTED";
		  map.put( "message", msg ) ;
          map.put( "flag", "Blank") ;
		  map.put( "traceVal", "blank records" ) ;
		  connection.rollback();
		  return map ;
		}

		int [] updatedCounts ;
		try{
				 pstmt_group.execute();
 				 updatedCounts = pstmt_rights.executeBatch();
				
 		 }catch(Exception e){
 					connection.rollback();
					e.printStackTrace();
					traceVal.append(e.getMessage());
					map.put( "traceVal", traceVal.toString() ) ;
					return map ;
		}

 			boolean updated = false	;
			if((updatedCounts.length > 0)){
				updated= true ;
			}else if((updatedCounts.length == (-3))){
				updated= false ;
			}
 			if (updated){
 						//connection.commit();
						boolean status_flg = false;
						 if(F_or)
							 status_flg = executeProcedure(connection,Privilege_id,"OR");
						 else if(F_vw)
							status_flg =	 executeProcedure(connection,Privilege_id,"VW");
						 else if(F_au)
							status_flg =	 executeProcedure(connection,Privilege_id,"AU");
						 else if(F_sa)
							status_flg =	 executeProcedure(connection,Privilege_id,"SA");
						 else if(F_cs)
							status_flg =	 executeProcedure(connection,Privilege_id,"CS");
						 else if(F_rr)
							status_flg =	 executeProcedure(connection,Privilege_id,"RR");
						 else if(F_cn)
							status_flg =	executeProcedure(connection,Privilege_id,"CN");
						 else if(F_rc)
							status_flg =	 executeProcedure(connection,Privilege_id,"RC");
						 if(status_flg)
						{
							connection.commit();
							map.put( "result", new Boolean( true ) ) ;
							messages.append( "RECORD_INSERTED" ) ;
						}
						else
						{
							connection.rollback();
							map.put( "result", new Boolean( false ) ) ;
							messages.append( "Insert Failed") ;
						}
			}else{
						connection.rollback();
						map.put( "result", new Boolean( false ) ) ;
						messages.append( "Insert Failed" ) ;
			}

		 }catch( Exception e ){
				try {
 						connection.rollback();
				} catch ( Exception ee ) {
						messages.append(ee.getMessage() ) ;
				}

				messages.append( e.getMessage() ) ;
 				e.printStackTrace() ;
    		  } finally{
	            	try {
						closeResultSet( rs);
						closeStatement( pstmt_group ) ;
						closeStatement( pstmt_rights ) ;
						
						 closeConnection( connection ,pt);

        			} catch ( Exception fe ) {
		     			System.err.println( fe.getMessage() ) ;
					   	fe.printStackTrace() ;
			        }
	    	    }
 			map.put( "message", messages.toString() ) ;
			map.put( "traceVal", traceVal.toString() ) ;
			//System.out.println("=====map===="+map+"==========map.get(message)===="+map.get( "message" ));
  			return map ;
	
  }//End of Insert Method

/****************************************************************************/
	/**
* @ejb.interface-method
*	 view-type="both"
*/
/*Modified by Uma on 8/18/2009 for PMG20089-641 to post the privileges to catalog,category and order type*/
	private boolean executeProcedure(Connection connection,String Privilege_ID,String Type) throws Exception
	{
		String p_error_message = "";
		CallableStatement cstmt 	= null;
		try{
			System.out.println("Privilege_ID 392"+Privilege_ID);
			System.out.println("Type 393"+Type);
			//cstmt			= connection.prepareCall("{ "+OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_CREATE_PROCEDURE")+" }");
			cstmt			= connection.prepareCall("{ "+OrRepositoryExt.getOrKeyValue("SQL_OR_POST_ORD_PRIV_REC")+" }");
			cstmt.setString(1, Privilege_ID);						 // P_PRIV_GRP_ID
			cstmt.setString(2, Type);						 // P_PRIV_TYPE
			cstmt.registerOutParameter( 3,  Types.VARCHAR ) ; 	// P_ERROR_MSG
			cstmt.execute();
			p_error_message	= cstmt.getString(3);  // message
			if(p_error_message!=null && p_error_message!="null" && !p_error_message.equals(""))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch ( Exception e )	
		{
			System.err.println( "When executing the create procedure" +e) ;
			e.printStackTrace() ;
			connection.rollback();
			throw e ;
		} 
		finally 
		{
			try
			{
				closeStatement( cstmt);
			} catch(Exception exec)
			{
				exec.printStackTrace();
			}
		} 
	}

/************************MODIFY*****************************/


	/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap modify( HashMap tabDataParam, HashMap sqlMap ) 
	{
		System.out.println("tabDataParam in modify"+tabDataParam);
		//System.out.println("sqlMap in modify"+sqlMap);
		String login_by_id = "";
		String login_at_ws_no = "";
		String login_facility_id = "";
		boolean F_or=false;
		boolean F_vw=false;
		boolean F_au=false;
		boolean F_sa=false;
		boolean F_cs=false;
		boolean F_rr=false;
		boolean F_cn=false;
		boolean F_rc=false;
		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;
		Connection connection = null ;
		PreparedStatement pstmt_insert = null ;
		PreparedStatement pstmt_update = null ;
		PreparedStatement pstmt_delete = null ;
		PreparedStatement pstmt_available = null ;
		PreparedStatement pstmt_update_eff = null ;
		PreparedStatement pstmt_update_desc = null ;
		HashMap privilegeHeaderStr=null;
		HashMap category=null;
		HashMap ordertype=null;
		HashMap catalog=null;
		int recordDetail = 0;
		
		ResultSet rs =null;
		//	int counter = 0;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "insert" ) ;
		//boolean flag = true ;

		HashMap tabDataMultiple = null ;
		Properties pt = null ;
	try {
		 pt = (Properties)tabDataParam.get( "properties" ) ;
		 tabDataMultiple = (HashMap)tabDataParam.get("tabData");
		 String SQL_OR_PRIVILEGE_GROUP_INSERT_ACCESS_RIGHTS	   =(String)sqlMap.get("SQL_OR_PRIVILEGE_GROUP_INSERT_ACCESS_RIGHTS");
		 String SQL_OR_PRIVILEGE_GROUP_DELETE	   =(String)sqlMap.get("SQL_OR_PRIVILEGE_GROUP_DELETE");
		 String SQL_OR_PRIVILEGE_GROUP_UPDATE =(String)sqlMap.get("SQL_OR_PRIVILEGE_GROUP_UPDATE");
		 String SQL_OR_PRIVILEGE_GROUP_UPDATE_EFF_STATUS =(String)sqlMap.get("SQL_OR_PRIVILEGE_GROUP_UPDATE_EFF_STATUS");
		 String SQL_OR_PRIVILEGE_GROUP_AVAILABLE =(String)sqlMap.get("SQL_OR_PRIVILEGE_GROUP_AVAILABLE");
		 String SQL_OR_PRIVILEGE_GROUP_STATUS =(String)sqlMap.get("SQL_OR_PRIVILEGE_GROUP_STATUS");
		 connection = getConnection(pt) ;
		privilegeHeaderStr=(HashMap)tabDataMultiple.get("privilegeHeaderStr");
		category=(HashMap)tabDataMultiple.get("category");
		int category_reccount = category.size();
		ordertype=(HashMap)tabDataMultiple.get("ordertype");
		int ordertype_reccount = ordertype.size();
		catalog=(HashMap)tabDataMultiple.get("catalog");
		int catalog_reccount = catalog.size();
		//System.out.println("tabDataMultiple in modify"+tabDataMultiple);
		System.out.println("privilegeHeaderStr in modify"+privilegeHeaderStr);
		//System.out.println("ordertype in modify"+ordertype);
		//System.out.println("ordertype_reccount in modify"+ordertype_reccount);
		  String Privilege_id =((((String)privilegeHeaderStr.get("Privilege_id")).equals("null"))||(((String)privilegeHeaderStr.get("Privilege_id"))==null))?"":((String)privilegeHeaderStr.get("Privilege_id")).trim();
		  String eff_status_yn =((((String)privilegeHeaderStr.get("eff_status_yn")).equals("null"))||(((String)privilegeHeaderStr.get("eff_status_yn"))==null))?"":((String)privilegeHeaderStr.get("eff_status_yn")).trim();
		  String eff_status_yn_temp =((((String)privilegeHeaderStr.get("eff_status_yn_temp")).equals("null"))||(((String)privilegeHeaderStr.get("eff_status_yn_temp"))==null))?"D":((String)privilegeHeaderStr.get("eff_status_yn_temp")).trim();
		//System.out.println("eff_status_yn----"+eff_status_yn);
		//System.out.println("eff_status_yn_temp----"+eff_status_yn_temp);
		  login_at_ws_no =((((String)tabDataMultiple.get("login_at_ws_no")).equals("null"))||(((String)tabDataMultiple.get("login_at_ws_no"))==null))?"":((String)tabDataMultiple.get("login_at_ws_no"));
		  login_by_id =((((String)tabDataMultiple.get("login_by_id")).equals("null"))||(((String)tabDataMultiple.get("login_by_id"))==null))?"":((String)tabDataMultiple.get("login_by_id"));
		  login_facility_id =((((String)tabDataMultiple.get("login_facility_id")).equals("null"))||(((String)tabDataMultiple.get("login_facility_id"))==null))?"":((String)tabDataMultiple.get("login_facility_id"));
		  String Privilege_long_desc =((((String)privilegeHeaderStr.get("Privilege_long_desc")).equals("null"))||(((String)privilegeHeaderStr.get("Privilege_long_desc"))==null))?"":((String)privilegeHeaderStr.get("Privilege_long_desc"));
		  String Privilege_long_desc_temp =((((String)privilegeHeaderStr.get("Privilege_long_desc_temp")).equals("null"))||(((String)privilegeHeaderStr.get("Privilege_long_desc_temp"))==null))?"":((String)privilegeHeaderStr.get("Privilege_long_desc_temp"));
		  pstmt_insert = connection.prepareStatement(SQL_OR_PRIVILEGE_GROUP_INSERT_ACCESS_RIGHTS);
		  pstmt_update = connection.prepareStatement(SQL_OR_PRIVILEGE_GROUP_UPDATE);
		  pstmt_update_desc = connection.prepareStatement("UPDATE OR_PRIV_GROUP SET PRIV_GRP_DESC=? WHERE PRIV_GRP_ID =?");
		  pstmt_update_eff = connection.prepareStatement(SQL_OR_PRIVILEGE_GROUP_UPDATE_EFF_STATUS);
		  pstmt_delete = connection.prepareStatement(SQL_OR_PRIVILEGE_GROUP_DELETE);
		  pstmt_available = connection.prepareStatement(SQL_OR_PRIVILEGE_GROUP_AVAILABLE);

		// System.out.println("Privilege_long_desc=="+Privilege_long_desc+"==");
		 //System.out.println("Privilege_long_desc_temp=="+Privilege_long_desc_temp+"==");
		  if(!eff_status_yn_temp.equals(eff_status_yn))
		{
			  pstmt_update_eff.setString(1,eff_status_yn);
			  pstmt_update_eff.setString(2,Privilege_id);
			  System.out.println("515");
		
		}
		if(!Privilege_long_desc_temp.equals(Privilege_long_desc))
		{
			  pstmt_update_desc.setString(1,Privilege_long_desc);
			  pstmt_update_desc.setString(2,Privilege_id);
			  System.out.println("522");		
		}
			 //System.out.println("category_reccount----"+category_reccount);
		if(category_reccount>0)
		{
			Set s;
			Iterator it;
			s = category.entrySet();
			it = s.iterator();
			while (it.hasNext()){
				String temp_category=it.next().toString();
				//System.out.println("temp_category----"+temp_category);
				String[] hashvalue=temp_category.split("=");
				//System.out.println("hashvalue----"+hashvalue[0]+"==="+hashvalue[1]);
				String[] values=hashvalue[0].split("!!");
				//System.out.println("values----"+values[0]+"==="+values[1]);
				String Priv_type=values[0];
				String memb_id=values[1];
				String memb_ref="C";
				String Acc_priv=hashvalue[1];
				String arrChkAvailable[]  =  new String[4] ;
				arrChkAvailable[0]=Privilege_id;
				arrChkAvailable[1]=Priv_type;
				arrChkAvailable[2]=memb_ref;
				arrChkAvailable[3]=memb_id;
				String arrChkStatus[]  =  new String[5] ;
				arrChkStatus[0]=Privilege_id;
				arrChkStatus[1]=Priv_type;
				arrChkStatus[2]=memb_ref;
				arrChkStatus[3]=memb_id;
				arrChkStatus[4]=Acc_priv;
				//System.out.println("=Privilege_id="+Privilege_id+"=Priv_type="+Priv_type+"=memb_ref="+memb_ref+"=memb_id="+memb_id+"=Acc_priv="+Acc_priv);
				if(!checkStatus(arrChkStatus,connection,SQL_OR_PRIVILEGE_GROUP_STATUS))
				{
				if(checkRecordsAvailable(arrChkAvailable,connection,SQL_OR_PRIVILEGE_GROUP_AVAILABLE))
				{
				//System.out.println("coming here...");
				if(!(Acc_priv.equals("defaultSelect")))
				{
				pstmt_update.setString(1 ,Acc_priv);
				pstmt_update.setString(2,login_by_id);
				pstmt_update.setString(3,login_at_ws_no);
				pstmt_update.setString(4,login_facility_id);
				pstmt_update.setString(5,Privilege_id);
				pstmt_update.setString(6,Priv_type);
				pstmt_update.setString(7,memb_ref);
				pstmt_update.setString(8,memb_id);
				//System.out.println("here.."+pstmt_update);
				pstmt_update.addBatch();
				if(Priv_type.equals("OR"))
					F_or=true;
				else if(Priv_type.equals("VW"))
					F_vw=true;
				else if(Priv_type.equals("AU"))
					F_au=true;
				else if(Priv_type.equals("SA"))
					F_sa=true;
				else if(Priv_type.equals("CS"))
					F_cs=true;
				else if(Priv_type.equals("RR"))
					F_rr=true;
				else if(Priv_type.equals("CN"))
					F_cn=true;
				else if(Priv_type.equals("RC"))
					F_rc=true;
				}
				else if(Acc_priv.equals("defaultSelect"))
				{
				/*String arrdelete[]  =  new String[4] ;
				arrdelete[0]=Privilege_id;
				arrdelete[1]=Priv_type;
				arrdelete[2]=memb_ref;
				arrdelete[3]=memb_id;*/
				pstmt_delete.setString(1 ,Privilege_id);
				pstmt_delete.setString(2 ,Priv_type);
				pstmt_delete.setString(3 ,memb_ref);
				pstmt_delete.setString(4 ,memb_id);
				pstmt_delete.addBatch();
				if(Priv_type.equals("OR"))
					F_or=true;
				else if(Priv_type.equals("VW"))
					F_vw=true;
				else if(Priv_type.equals("AU"))
					F_au=true;
				else if(Priv_type.equals("SA"))
					F_sa=true;
				else if(Priv_type.equals("CS"))
					F_cs=true;
				else if(Priv_type.equals("RR"))
					F_rr=true;
				else if(Priv_type.equals("CN"))
					F_cn=true;
				else if(Priv_type.equals("RC"))
					F_rc=true;
				/*if(delete(arrdelete,connection,SQL_OR_PRIVILEGE_GROUP_DELETE))
					{
					delete_count++;
					}*/
				}
				}
				else if(!(Acc_priv.equals("defaultSelect")))
				{
				pstmt_insert.setString(1 ,Privilege_id);
				pstmt_insert.setString(2 ,Priv_type);
				pstmt_insert.setString(3 ,memb_ref);
				pstmt_insert.setString(4 ,memb_id);
				pstmt_insert.setString(5 ,Acc_priv);
				pstmt_insert.setString(6,login_by_id);
				pstmt_insert.setString(7,login_at_ws_no);
				pstmt_insert.setString(8,login_facility_id);
				pstmt_insert.setString(9,login_by_id);
				pstmt_insert.setString(10,login_at_ws_no);
				pstmt_insert.setString(11,login_facility_id);
				pstmt_insert.addBatch();
				if(Priv_type.equals("OR"))
					F_or=true;
				else if(Priv_type.equals("VW"))
					F_vw=true;
				else if(Priv_type.equals("AU"))
					F_au=true;
				else if(Priv_type.equals("SA"))
					F_sa=true;
				else if(Priv_type.equals("CS"))
					F_cs=true;
				else if(Priv_type.equals("RR"))
					F_rr=true;
				else if(Priv_type.equals("CN"))
					F_cn=true;
				else if(Priv_type.equals("RC"))
					F_rc=true;
				}

			}
			}
		}
		if(ordertype_reccount>0)
		{
			Set s;
			Iterator it;
			s = ordertype.entrySet();
			it = s.iterator();
			while (it.hasNext()){
				String temp_ordertype=it.next().toString();
				String[] hashvalue=temp_ordertype.split("=");
				String[] values=hashvalue[0].split("!!");
				String Priv_type=values[0];
				String memb_id=values[2];
				String memb_ref="T";
				String Acc_priv=hashvalue[1];
				String arrChkAvailable[]  =  new String[4] ;
				arrChkAvailable[0]=Privilege_id;
				arrChkAvailable[1]=Priv_type;
				arrChkAvailable[2]=memb_ref;
				arrChkAvailable[3]=memb_id;
				//System.out.println("Acc_priv----"+Acc_priv);
				String arrChkStatus[]  =  new String[5] ;
				arrChkStatus[0]=Privilege_id;
				arrChkStatus[1]=Priv_type;
				arrChkStatus[2]=memb_ref;
				arrChkStatus[3]=memb_id;
				arrChkStatus[4]=Acc_priv;
				if(!checkStatus(arrChkStatus,connection,SQL_OR_PRIVILEGE_GROUP_STATUS))
				{
				if(checkRecordsAvailable(arrChkAvailable,connection,SQL_OR_PRIVILEGE_GROUP_AVAILABLE))
				{
				//System.out.println("Acc_priv----"+Acc_priv);
				if(!(Acc_priv.equals("defaultSelect")))
				{
				pstmt_update.setString(1 ,Acc_priv);
				pstmt_update.setString(2,login_by_id);
				pstmt_update.setString(3,login_at_ws_no);
				pstmt_update.setString(4,login_facility_id);
				pstmt_update.setString(5 ,Privilege_id);
				pstmt_update.setString(6 ,Priv_type);
				pstmt_update.setString(7 ,memb_ref);
				pstmt_update.setString(8 ,memb_id);
				pstmt_update.addBatch();
				if(Priv_type.equals("OR"))
					F_or=true;
				else if(Priv_type.equals("VW"))
					F_vw=true;
				else if(Priv_type.equals("AU"))
					F_au=true;
				else if(Priv_type.equals("SA"))
					F_sa=true;
				else if(Priv_type.equals("CS"))
					F_cs=true;
				else if(Priv_type.equals("RR"))
					F_rr=true;
				else if(Priv_type.equals("CN"))
					F_cn=true;
				else if(Priv_type.equals("RC"))
					F_rc=true;
				}
				else if(Acc_priv.equals("defaultSelect"))
				{
					//System.out.println("coming here...");
				/*String arrdelete[]  =  new String[4] ;
				arrdelete[0]=Privilege_id;
				arrdelete[1]=Priv_type;
				arrdelete[2]=memb_ref;
				arrdelete[3]=memb_id;*/
				pstmt_delete.setString(1 ,Privilege_id);
				pstmt_delete.setString(2 ,Priv_type);
				pstmt_delete.setString(3 ,memb_ref);
				pstmt_delete.setString(4 ,memb_id);
				pstmt_delete.addBatch();
				if(Priv_type.equals("OR"))
					F_or=true;
				else if(Priv_type.equals("VW"))
					F_vw=true;
				else if(Priv_type.equals("AU"))
					F_au=true;
				else if(Priv_type.equals("SA"))
					F_sa=true;
				else if(Priv_type.equals("CS"))
					F_cs=true;
				else if(Priv_type.equals("RR"))
					F_rr=true;
				else if(Priv_type.equals("CN"))
					F_cn=true;
				else if(Priv_type.equals("RC"))
					F_rc=true;
				/*if(delete(arrdelete,connection,SQL_OR_PRIVILEGE_GROUP_DELETE))
					{
					delete_count++;
					}*/
				}
				}
				else if(!(Acc_priv.equals("defaultSelect")))
				{
				pstmt_insert.setString(1 ,Privilege_id);
				pstmt_insert.setString(2 ,Priv_type);
				pstmt_insert.setString(3 ,memb_ref);
				pstmt_insert.setString(4 ,memb_id);
				pstmt_insert.setString(5 ,Acc_priv);
				pstmt_insert.setString(6,login_by_id);
				pstmt_insert.setString(7,login_at_ws_no);
				pstmt_insert.setString(8,login_facility_id);
				pstmt_insert.setString(9,login_by_id);
				pstmt_insert.setString(10,login_at_ws_no);
				pstmt_insert.setString(11,login_facility_id);
				pstmt_insert.addBatch();
				if(Priv_type.equals("OR"))
					F_or=true;
				else if(Priv_type.equals("VW"))
					F_vw=true;
				else if(Priv_type.equals("AU"))
					F_au=true;
				else if(Priv_type.equals("SA"))
					F_sa=true;
				else if(Priv_type.equals("CS"))
					F_cs=true;
				else if(Priv_type.equals("RR"))
					F_rr=true;
				else if(Priv_type.equals("CN"))
					F_cn=true;
				else if(Priv_type.equals("RC"))
					F_rc=true;
				}

			}
			}
		}
	if(catalog_reccount>0)
		{
			Set s;
			Iterator it;
			s = catalog.entrySet();
			it = s.iterator();
			while (it.hasNext()){
				String temp_catalog=it.next().toString();
				String[] hashvalue=temp_catalog.split("=");
				String[] values=hashvalue[0].split("!!");
				String Priv_type=values[0];
				String memb_id=values[3];
				String memb_ref="I";
				String Acc_priv=hashvalue[1];
				//System.out.println("Priv_type"+Priv_type+"memb_id"+memb_id+"memb_ref"+memb_ref+"Acc_priv"+Acc_priv);
				String arrChkAvailable[]  =  new String[4] ;
				arrChkAvailable[0]=Privilege_id;
				arrChkAvailable[1]=Priv_type;
				arrChkAvailable[2]=memb_ref;
				arrChkAvailable[3]=memb_id;
				String arrChkStatus[]  =  new String[5] ;
				arrChkStatus[0]=Privilege_id;
				arrChkStatus[1]=Priv_type;
				arrChkStatus[2]=memb_ref;
				arrChkStatus[3]=memb_id;
				arrChkStatus[4]=Acc_priv;
				
				if(!checkStatus(arrChkStatus,connection,SQL_OR_PRIVILEGE_GROUP_STATUS))
				{
				if(checkRecordsAvailable(arrChkAvailable,connection,SQL_OR_PRIVILEGE_GROUP_AVAILABLE))
				{

				if(!(Acc_priv.equals("defaultSelect")))
				{
				pstmt_update.setString(1 ,Acc_priv);
				pstmt_update.setString(2,login_by_id);
				pstmt_update.setString(3,login_at_ws_no);
				pstmt_update.setString(4,login_facility_id);
				pstmt_update.setString(5 ,Privilege_id);
				pstmt_update.setString(6 ,Priv_type);
				pstmt_update.setString(7 ,memb_ref);
				pstmt_update.setString(8 ,memb_id);
				pstmt_update.addBatch();
				if(Priv_type.equals("OR"))
					F_or=true;
				else if(Priv_type.equals("VW"))
					F_vw=true;
				else if(Priv_type.equals("AU"))
					F_au=true;
				else if(Priv_type.equals("SA"))
					F_sa=true;
				else if(Priv_type.equals("CS"))
					F_cs=true;
				else if(Priv_type.equals("RR"))
					F_rr=true;
				else if(Priv_type.equals("CN"))
					F_cn=true;
				else if(Priv_type.equals("RC"))
					F_rc=true;
				}
				else if(Acc_priv.equals("defaultSelect"))
				{
					//System.out.println("coming here..");

				/* String arrdelete[]  =  new String[4] ;
				arrdelete[0]=Privilege_id;
				arrdelete[1]=Priv_type;
				arrdelete[2]=memb_ref;
				arrdelete[3]=memb_id;*/
				pstmt_delete.setString(1 ,Privilege_id);
				pstmt_delete.setString(2 ,Priv_type);
				pstmt_delete.setString(3 ,memb_ref);
				pstmt_delete.setString(4 ,memb_id);
				pstmt_delete.addBatch();
				if(Priv_type.equals("OR"))
					F_or=true;
				else if(Priv_type.equals("VW"))
					F_vw=true;
				else if(Priv_type.equals("AU"))
					F_au=true;
				else if(Priv_type.equals("SA"))
					F_sa=true;
				else if(Priv_type.equals("CS"))
					F_cs=true;
				else if(Priv_type.equals("RR"))
					F_rr=true;
				else if(Priv_type.equals("CN"))
					F_cn=true;
				else if(Priv_type.equals("RC"))
					F_rc=true;
				/*if(delete(arrdelete,connection,SQL_OR_PRIVILEGE_GROUP_DELETE))
					{
					delete_count++;
					}*/
				}
				}
				else if(!(Acc_priv.equals("defaultSelect")))
				{
				pstmt_insert.setString(1 ,Privilege_id);
				pstmt_insert.setString(2 ,Priv_type);
				pstmt_insert.setString(3 ,memb_ref);
				pstmt_insert.setString(4 ,memb_id);
				pstmt_insert.setString(5 ,Acc_priv);
				pstmt_insert.setString(6,login_by_id);
				pstmt_insert.setString(7,login_at_ws_no);
				pstmt_insert.setString(8,login_facility_id);
				pstmt_insert.setString(9,login_by_id);
				pstmt_insert.setString(10,login_at_ws_no);
				pstmt_insert.setString(11,login_facility_id);
				pstmt_insert.addBatch();
				if(Priv_type.equals("OR"))
					F_or=true;
				else if(Priv_type.equals("VW"))
					F_vw=true;
				else if(Priv_type.equals("AU"))
					F_au=true;
				else if(Priv_type.equals("SA"))
					F_sa=true;
				else if(Priv_type.equals("CS"))
					F_cs=true;
				else if(Priv_type.equals("RR"))
					F_rr=true;
				else if(Priv_type.equals("CN"))
					F_cn=true;
				else if(Priv_type.equals("RC"))
					F_rc=true;
				}

			}
			}
		}
		
		int [] updatedCounts1 ;
		int [] updatedCounts2 ;
		int [] updatedCounts3 ;
		try
		{
				updatedCounts1 = pstmt_insert.executeBatch();
				updatedCounts2 = pstmt_delete.executeBatch();
				updatedCounts3 = pstmt_update.executeBatch();
				//System.out.println("914");
				 if(!eff_status_yn_temp.equals(eff_status_yn))
				{
					 System.out.println("929");
					pstmt_update_eff.executeUpdate();
				}
				if(!Privilege_long_desc_temp.equals(Privilege_long_desc))
				{
					 System.out.println("934");
					pstmt_update_desc.executeUpdate();
				}
 		 }catch(Exception e){
 					connection.rollback();
					e.printStackTrace();
					traceVal.append(e.getMessage());
					String msg  = "Update Failed";
					map.put( "message", msg ) ;
					map.put( "traceVal", traceVal.toString() ) ;
					return map ;
		}

 			boolean updated = false	;
			 /*if(!eff_status_yn_temp.equals(eff_status_yn))
			{
				updated=true;
			}*/
			//System.out.println("updated 937"+updated);
			//System.out.println("updatedCounts1.length 937"+updatedCounts1.length);
			//System.out.println("updatedCounts2.length 937"+updatedCounts2.length);
			//System.out.println("updatedCounts3.length 937"+updatedCounts3.length);
			if((updatedCounts1.length > 0) || (updatedCounts2.length > 0) || (updatedCounts3.length > 0))
			{
				recordDetail++;
				updated= true ;
			}else if((updatedCounts1.length == (-3)) || (updatedCounts2.length == (-3)) || (updatedCounts3.length == (-3)))
			{
				updated= false ;
			}
			if(!eff_status_yn_temp.equals(eff_status_yn))
			{
				updated=true;
			}
			if(!Privilege_long_desc_temp.equals(Privilege_long_desc))
			{
				updated=true;
			}
			//System.out.println("updated 952"+updated);
 			if (updated)
			{
 						//connection.commit();
						boolean status_flg = false;
						if(recordDetail==0)
						{
							status_flg = executeProcedure(connection,Privilege_id,"");
						}
						else
						{
							 if(F_or)
								status_flg = executeProcedure(connection,Privilege_id,"OR");
							 else if(F_vw)
								status_flg =	 executeProcedure(connection,Privilege_id,"VW");
							 else if(F_au)
								status_flg =	 executeProcedure(connection,Privilege_id,"AU");
							 else if(F_sa)
								status_flg =	 executeProcedure(connection,Privilege_id,"SA");
							 else if(F_cs)
								status_flg =	 executeProcedure(connection,Privilege_id,"CS");
							 else if(F_rr)
								status_flg =	 executeProcedure(connection,Privilege_id,"RR");
							 else if(F_cn)
								status_flg =	executeProcedure(connection,Privilege_id,"CN");
							 else if(F_rc)
								status_flg =	 executeProcedure(connection,Privilege_id,"RC");
						}						
						 if(status_flg)
						{
							connection.commit();
							map.put( "result", new Boolean( true ) ) ;
							messages.append( "RECORD_MODIFIED" ) ;
						}
						else
						{
							connection.rollback();
							map.put( "result", new Boolean( false ) ) ;
							messages.append( "Insert Failed" ) ;
						}
			}
			else
			{
					connection.rollback();
					map.put( "result", new Boolean( false ) ) ;
					messages.append( "NO_CHANGE_TO_SAVE" ) ;
			}
		 }catch( Exception e ){
				try {
 						connection.rollback();
				} catch ( Exception ee ) {
						messages.append(ee.getMessage() ) ;
				}

				messages.append( e.getMessage() ) ;
 				e.printStackTrace() ;
    		  } finally{
	            	try {
						closeResultSet( rs);
						closeStatement( pstmt_insert ) ;
						closeStatement( pstmt_update ) ;
						closeStatement( pstmt_delete ) ;
						closeStatement( pstmt_available ) ;
						closeStatement( pstmt_update_eff ) ;
						closeStatement( pstmt_update_desc) ;
						
						 closeConnection( connection ,pt);

        			} catch ( Exception fe ) {
		     			System.err.println( fe.getMessage() ) ;
					   	fe.printStackTrace() ;
			        }
	    	    }
 			map.put( "message", messages.toString() ) ;
			map.put( "traceVal", traceVal.toString() ) ;
			//System.out.println("=====map===="+map+"==========map.get(message)===="+map.get( "message" ));
  			return map ;
	
	}

	private boolean checkRecordsAvailable(String arr[],Connection con,String sql) throws Exception
	{
	StringBuffer messages = new StringBuffer() ;
	StringBuffer traceVal = new StringBuffer() ;
	PreparedStatement pstmt = con.prepareStatement(sql);
	ResultSet rs	         = null ;
	boolean availFlag = false ;
	try{
		
		int size				= arr.length ;
		for(int i =0 ; i < size ; i++){
			pstmt.setString(i+1,arr[i]);
			//System.out.println("arr[i]..."+arr[i]);
		}
		rs = pstmt.executeQuery();

		int count = 0;

		if(rs.next())
		{
			count = rs.getInt(1);
		}
		//System.out.println("count..."+count);

		if(count > 0)
		availFlag = true ;
		}catch(Exception e){
				traceVal.append(e);
				messages.append(e.getMessage());
				throw e;
	 }
	 finally{
		 try{
			closeResultSet( rs);
			closeStatement( pstmt ) ;
		 }catch(Exception ee){ee.printStackTrace();}
	 }
	 //System.out.println("while retuening .."+availFlag);
	 return availFlag;
	}

	private boolean checkStatus(String arr[],Connection con,String sql) throws Exception
	{
	StringBuffer messages = new StringBuffer() ;
	StringBuffer traceVal = new StringBuffer() ;
	PreparedStatement pstmt = con.prepareStatement(sql);
	ResultSet rs	         = null ;
	boolean availFlag = false ;
	try{
		
		int size				= arr.length ;
		for(int i =0 ; i < size ; i++){
			pstmt.setString(i+1,arr[i]);
			//System.out.println("arr[i]..."+arr[i]);
		}
		rs = pstmt.executeQuery();

		int count = 0;

		if(rs.next())
		{
			count = rs.getInt(1);
		}
		//System.out.println("count..."+count);

		if(count > 0)
		availFlag = true ;
		}catch(Exception e){
				traceVal.append(e);
				messages.append(e.getMessage());
				throw e;
	 }
	 finally{
		 try{
			closeResultSet( rs);
			closeStatement( pstmt ) ;
		 }catch(Exception ee){ee.printStackTrace();}
	 }
	 //System.out.println("while retuening .."+availFlag);
	 return availFlag;
	}
/*******************this method give range of duplicates******************/
private boolean chkDuplicate(String sql,Connection con , String arr[]) throws Exception{
	StringBuffer messages = new StringBuffer() ;
	StringBuffer traceVal = new StringBuffer() ;
	PreparedStatement pstmt = con.prepareStatement(sql);
	ResultSet rs	         = null ;
try{
		boolean dupFlag = false ;
		int size				= arr.length ;
		for(int i =0 ; i < size ; i++){
			pstmt.setString(i+1,arr[i]);
		}
		rs = pstmt.executeQuery();

		int count = 0;

		if(rs.next())
		{
			count = rs.getInt(1);
		}

		if(count > 0)
		dupFlag = true ;
		return dupFlag;
		}catch(Exception e){
				traceVal.append(e);
				messages.append(e.getMessage());
				throw e;
	 }
	 finally{
		 try{
			closeResultSet( rs);
			closeStatement( pstmt ) ;
		 }catch(Exception ee){ee.printStackTrace();}
	 }

}//End of dulicate chk

/**
* @ejb.interface-method
*	 view-type="both"
*/
public boolean delete( String arr[],Connection con ,String sql) throws Exception

{
	//System.out.println("coming here...in delete...");
	PreparedStatement pstmt = con.prepareStatement(sql);
	ResultSet rs	         = null ;
	StringBuffer messages = new StringBuffer() ;
	boolean updated=false;
 	try {
		 int size				= arr.length ;
		for(int i =0 ; i < size ; i++){
			pstmt.setString(i+1,arr[i]);
		}
		
 		int res_del  = pstmt.executeUpdate();

		if( res_del >0)
			updated= true ;
		else if( res_del <= 0){
			updated= false ;
		}

	/*	if (updated){
 			connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_DELETED" ) ;
			}else{
				connection.rollback();
				messages.append( "Delete Failed" ) ;
			}*/
	}catch( Exception e ){
				try {
						con.rollback();
						e.printStackTrace();
				} catch ( Exception ee ) {
						messages.append(ee.getMessage() ) ;
				}

				messages.append( e.getMessage() ) ;
	 			e.printStackTrace() ;
    		  } finally{
	            	try {
						 closeResultSet( rs);
						 closeStatement(pstmt) ;
						} catch ( Exception fe ) {
		     			System.err.println( fe.getMessage() ) ;
					   	fe.printStackTrace() ;
			        }
	    	    }

			return updated ;

	}
}//End of class



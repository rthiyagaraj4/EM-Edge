/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import eBL.Common.* ;
import java.io.*;
import java.util.*;
import java.sql.* ;

import javax.naming.*;
import javax.rmi.*;

import eCommon.Common.*;

public class PkgUserAccessBean extends eBL.Common.BlAdapter implements java.io.Serializable {


	protected String user_id 	= "" ;
	protected String user_name = "";
	protected String user_grp_id			= "" ;
	protected String user_grp_name	= "" ;
	protected String mode	= "" ;
	protected String function_id	= "" ;
	protected String language_id	= "" ;
	protected String facility_id	= "" ;

	public void setUserId(String user_id){
		this.user_id = user_id ;
	}
	public String getUserId(){
		return user_id;
	}
	
	public void setUserName(String user_name){
		this.user_name = user_name ;
	}
	public String getUserName(){
		return user_name;
	}
	
	public void setUserGrpId(String user_grp_id){
		this.user_grp_id = user_grp_id ;
	}	
	public String getUserGrpId(){
		return user_grp_id;
	}
	
	public void setUserGrpName(String user_grp_name){
		this.user_grp_name = user_grp_name;
	}
	public String getUserGrpName(){
		return user_grp_name;
	}
	
	public void setMode(String mode){
		this.mode=mode;
	}
	public String getMode(){
		return this.mode;
	}
	
	public void setFunctionId(String function_id){
		this.function_id=function_id;
	}
	public String getFunctionId(){
		return this.function_id;
	}
	
	public void setLanguageId(String language_id){
		this.language_id=language_id;
	}
	public String getLanguageId(){
		return this.language_id;
	}
	public void setFacilityId(String facility_id){
		this.facility_id=facility_id;
	}
	public String getFacilityId(){
		return this.facility_id;
	}

	public void clear() {
		user_id 	= "" ;
		user_name			= "" ;
		user_grp_id			= "" ;
		user_grp_name			= "" ;
		mode="";
		function_id="";
		language_id="";
		facility_id="";
		
		super.clear() ;
	}
	public String[]  loadDataForUpdate() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] record = new String[9];

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( "select  a.appl_user_name user_name, c.short_desc user_group_name,b.package_creation package_creation ,b.package_approval package_approval ,b.package_transfer package_transfer ,b.package_discount package_discount ,b.package_refund package_refund,b.package_cancel package_cancel,b.package_adhoc_refund package_adhoc_refund from sm_appl_user_lang_vw a, bl_user b, bl_user_group_lang_vw c where a.appl_user_id=b.bl_user_id and b.user_group_id=c.user_group_id and b.operating_facility_id=? and a.language_id=? and c.language_id=?  and b.bl_user_id=? and b.user_group_id=?" ) ;
/*System.out.println("facility_id="+this.facility_id);
System.out.println("language_id="+this.language_id);
System.out.println("user_id="+this.user_id);
System.out.println("user_grp_id="+this.user_grp_id);*/
			pstmt.setString( 1, this.facility_id ) ;
			pstmt.setString( 2, this.language_id ) ;
			pstmt.setString( 3, this.language_id ) ;
			pstmt.setString( 4, this.user_id ) ;
			pstmt.setString( 5, this.user_grp_id) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				record[0] = checkForNull(resultSet.getString( "user_name" ),"")  ;
				record[1] = checkForNull(resultSet.getString( "user_group_name" ),"")  ;
				record[2] = checkForNull(resultSet.getString( "package_creation" ),"N")  ;
				record[3] = checkForNull(resultSet.getString( "package_approval" ),"N")  ;
				record[4] = checkForNull(resultSet.getString( "package_transfer" ),"N")  ;
				record[5] = checkForNull(resultSet.getString( "package_discount" ),"N")  ;
				record[6] = checkForNull(resultSet.getString( "package_refund" ),"N")  ;
				record[7] = checkForNull(resultSet.getString( "package_cancel" ),"N")  ;
				record[8] = checkForNull(resultSet.getString( "package_adhoc_refund" ),"N")  ;
				
			/*		System.out.println("record[0]="+record[0]);
					System.out.println("record[1]="+record[1]);
					System.out.println("record[2]="+record[2]);
					System.out.println("record[3]="+record[3]);
					System.out.println("record[4]="+record[4]);
					System.out.println("record[5]="+record[5]);
					System.out.println("record[6]="+record[6]);
					System.out.println("record[7]="+record[7]);*/
					
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}

		return record;
	}



}

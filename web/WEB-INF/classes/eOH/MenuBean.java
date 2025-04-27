/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
	Developer		: Sridevi Joshi
	Completed On	: 10/05/07
	Modified On		: 07/06/07 
*/

package eOH ;

import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import eOH.Common.OHAdapter;
import eCommon.Common.CommonRepository;
import java.util.Properties;

public class MenuBean extends OHAdapter implements Serializable{
		String	 locale	= "";
		Properties	p = this.properties;

	public MenuBean() {
        try {
			doCommon();
		}catch(Exception e) {}
	}
	public void doCommon() throws Exception {
		locale	= (String) p.getProperty("LOCALE");
	}
	public ArrayList getMenuItems(String tab_name, String site_type){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		ArrayList arr_list = new ArrayList();
		
		locale = getProperties().getProperty("LOCALE");
		try{
			connection			= getConnection() ;
			if((!(tab_name.equals(""))) && (!(tab_name.equals(null)))){
				if(tab_name.equals("DC")){
					/*
					//if(site_type.equals("CROWN") || site_type.equals("ROOT")){
						//sql = "SELECT A.CONDITION_CODE,A.CONDITION_DESC,A.CONDITION_TYPE,B.CONDITION_TYPE_DESC FROM OH_CONDITION_LANG_VW A, OH_CONDITION_TYPE_LANG_VW B WHERE A.CONDITION_TYPE = B.CONDITION_TYPE AND A.LANGUAGE_ID = B.LANGUAGE_ID AND A.CONDITION_TYPE IN (SELECT C.CONDITION_TYPE FROM OH_CONDITION_APPL_SITE_TYPE C WHERE C.SITE_TYPE = ?) AND A.LANGUAGE_ID = ? ORDER BY 2";

						sql = "SELECT A.CONDITION_CODE,A.CONDITION_DESC,A.CONDITION_TYPE FROM OH_CONDITION_LANG_VW A WHERE A.CONDITION_TYPE IN (SELECT C.CONDITION_TYPE FROM OH_CONDITION_APPL_SITE_TYPE C WHERE C.SITE_TYPE = ?) AND A.LANGUAGE_ID = ? ORDER BY 2";
						pstmt = connection.prepareStatement(sql) ;
						pstmt.setString(1,site_type);
						pstmt.setString(2,locale);
					//}
					//else{
						//sql = "SELECT CONDITION_CODE,CONDITION_DESC,CONDITION_TYPE FROM OH_CONDITION WHERE CONDITION_TYPE IN (SELECT CONDITION_TYPE FROM OH_CONDITION_APPL_SITE_TYPE WHERE SITE_TYPE IN ('TOOTH','THRNG','QUAD','ARCH'))";
						//pstmt = connection.prepareStatement(sql) ;
					//}
					
					resultSet = pstmt.executeQuery();
					while(resultSet!=null && resultSet.next()){
						code = resultSet.getString("CONDITION_CODE");
						desc = resultSet.getString("CONDITION_DESC");
						type_code = resultSet.getString("CONDITION_TYPE");
						//type_desc = resultSet.getString("CONDITION_TYPE_DESC");
						arr_list.add(code);
						arr_list.add(desc);
						arr_list.add(type_code);
						//arr_list.add(type_desc);
					}
					*/

					pstmt = connection.prepareStatement("SELECT CONDITION_TYPE_DESC,CONDITION_TYPE FROM OH_CONDITION_TYPE_LANG_VW WHERE CONDITION_TYPE IN (SELECT C.CONDITION_TYPE FROM OH_CONDITION_APPL_SITE_TYPE C WHERE C.SITE_TYPE = ?) AND LANGUAGE_ID = ? ORDER BY 1");
					pstmt.setString(1,site_type);
					pstmt.setString(2,locale);
					resultSet = pstmt.executeQuery();
					while(resultSet!= null && resultSet.next()){
						//function_type_desc_list.append(URLEncoder.encode(rst.getString("CONDITION_TYPE_DESC")));
						arr_list.add(resultSet.getString("CONDITION_TYPE"));
						arr_list.add(resultSet.getString("CONDITION_TYPE_DESC"));
					}
					if(resultSet!=null) resultSet.close();
					if(pstmt!=null) pstmt.close();
				}
				if(tab_name.equals("ET") || tab_name.equals("T")){
					/*
					//if(site_type.equals("CROWN") || site_type.equals("ROOT")){
						sql = "SELECT A.TRMT_CODE, A.TRMT_DESC, B.TRMT_CATEGORY_TYPE, B.TRMT_CATEGORY_CODE FROM OH_TREATMENT_LANG_VW A, OH_TREATMENT_CATEGORY B, OH_TREATMENT_APPL_SITE_TYPE C WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE AND A.LANGUAGE_ID = ? AND B.TRMT_CATEGORY_TYPE = C.TREATMENT_CATEGORY_TYPE AND C.SITE_TYPE = ? ORDER BY 2";
						pstmt = connection.prepareStatement(sql) ;
						pstmt.setString(1,locale);
						pstmt.setString(2,site_type);
					//}
					//else{
						//sql = "SELECT CONDITION_CODE,CONDITION_DESC,CONDITION_TYPE FROM OH_CONDITION WHERE CONDITION_TYPE IN (SELECT CONDITION_TYPE FROM OH_CONDITION_APPL_SITE_TYPE WHERE SITE_TYPE IN ('TOOTH','THRNG','QUAD','ARCH'))";
						//pstmt = connection.prepareStatement(sql) ;
					//}
					
					resultSet = pstmt.executeQuery();
					while(resultSet!=null && resultSet.next()){
						code = resultSet.getString("TRMT_CODE");
						desc = resultSet.getString("TRMT_DESC");
						type_code = resultSet.getString("TRMT_CATEGORY_TYPE");
						cat_code = resultSet.getString("TRMT_CATEGORY_CODE");
						arr_list.add(code);
						arr_list.add(desc);
						arr_list.add(type_code);
						arr_list.add(cat_code);
					}
					*/
					pstmt = connection.prepareStatement("SELECT TRMT_CATEGORY_TYPE_DESC,TRMT_CATEGORY_TYPE FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW WHERE TRMT_CATEGORY_TYPE IN (SELECT C.TREATMENT_CATEGORY_TYPE FROM OH_TREATMENT_APPL_SITE_TYPE C WHERE C.SITE_TYPE = ?) AND LANGUAGE_ID = ? ORDER BY 1");
					pstmt.setString(1,site_type);
					pstmt.setString(2,locale);
					resultSet = pstmt.executeQuery();
					while(resultSet!= null && resultSet.next()){
						//function_type_desc_list.append(URLEncoder.encode(rst.getString("TRMT_CATEGORY_TYPE_DESC")));
						arr_list.add(resultSet.getString("TRMT_CATEGORY_TYPE"));
						arr_list.add(resultSet.getString("TRMT_CATEGORY_TYPE_DESC"));
					}
				}
			}
		}catch ( Exception e ) {
				e.printStackTrace() ;
			}finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				 }catch(Exception es){es.printStackTrace();}
			}
		return arr_list;
	}
/*
	public ArrayList getMenuItems(String site_type){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		ArrayList arr_list = new ArrayList();
		String sql = "";
		String code = "";
		String desc = "";
		String type = "";
		locale = getProperties().getProperty("LOCALE");
		try{
			connection	= getConnection() ;
			//sql = "SELECT CONDITION_CODE,CONDITION_DESC,CONDITION_TYPE FROM OH_CONDITION_LANG_VW WHERE CONDITION_TYPE IN (SELECT CONDITION_TYPE FROM OH_CONDITION_APPL_SITE_TYPE WHERE SITE_TYPE = ?) AND LANGUAGE_ID = ?";
			sql = "SELECT A.TRMT_CODE, A.TRMT_DESC, B.TRMT_CATEGORY_TYPE, B.TRMT_CATEGORY_CODE FROM OH_TREATMENT_LANG_VW A, OH_TREATMENT_CATEGORY B, OH_TREATMENT_APPL_SITE_TYPE C WHERE A.TRMT_CATEGORY_CODE = B.TRMT_CATEGORY_CODE AND A.LANGUAGE_ID = ? AND B.TRMT_CATEGORY_TYPE = C.TREATMENT_CATEGORY_TYPE AND C.SITE_TYPE = ? ORDER BY 2";
			pstmt = connection.prepareStatement(sql) ;
			pstmt.setString(1,site_type);
			pstmt.setString(2,locale);
		
			resultSet = pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				code = resultSet.getString("CONDITION_CODE");
				desc = resultSet.getString("CONDITION_DESC");
				type = resultSet.getString("CONDITION_TYPE");
				arr_list.add(code);
				arr_list.add(desc);
				arr_list.add(type);
			}
		}catch ( Exception e ) {
				e.printStackTrace() ;
			}finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				 }catch(Exception es){es.printStackTrace();}
			}
		return arr_list;
	}

*/
}


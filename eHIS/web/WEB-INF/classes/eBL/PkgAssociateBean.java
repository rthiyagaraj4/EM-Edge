/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;
import java.io.*;
import java.util.*;
import java.sql.*;
import eBL.Common.*;
import webbeans.eCommon.*;
import eCommon.Common.CommonAdapter;

public class PkgAssociateBean extends BlAdapter implements Serializable
{
	protected ArrayList associatedPkgs=new ArrayList();//pkg_code~~pkg_short_desc~~pkg_seq_no
	public PkgAssociateBean()
	{	
		//System.out.println("Bean Initialized");
	}
	public void clearBean(){
		associatedPkgs=new ArrayList();
	}
	public void setAssociatedPkgs(ArrayList associatedPkgs ){
		this.associatedPkgs=associatedPkgs;
	}
	public ArrayList getAssociatedPkgs(){
		return this.associatedPkgs;
	}
	public HashMap validate() throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." );
		return map;
	}	
	public String subsOpenPkgsExists(String facility_id,String language_id,String patient_id,String visit_admin_date) throws Exception 	{
		Connection connection 		= null;		
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		String exists="N";
		String sqlStr="";	
		int count=0;
		try{
			connection = getConnection();	
			sqlStr="SELECT  count(*) count  FROM bl_package_sub_hdr a, bl_package_lang_vw b  WHERE a.operating_facility_id =?   AND a.operating_facility_id = b.operating_facility_id    AND a.package_code = b.package_code   AND b.language_id =?   AND a.patient_id = ?   AND to_date(?,'dd/mm/yyyy') BETWEEN trunc(a.EFF_FROM_DATE) AND trunc(NVL(a.eff_to_date,SYSDATE))   AND a.status = 'O' order by a.package_seq_no";
			pstmt=connection.prepareStatement(sqlStr);					
			pstmt.setString(1,facility_id);
			pstmt.setString(2,language_id);
			pstmt.setString(3,patient_id);
			pstmt.setString(4,visit_admin_date);
			rs							= pstmt.executeQuery();
			while (rs.next()){
				
				count=rs.getInt("count");
				if(count>0)
				exists="Y";
					
			}
		}catch(Exception e){
				System.out.println("Exception in subsOpenPkgsExists() of PkgAssociateBean.java="+e);
				e.printStackTrace();
		}finally{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
		}
		return exists;
	}	
	public boolean pkgDefinedValidPatClass(String facility_id, String episode_type,String packageCode)throws Exception
	{
		Connection connection 		= null;		
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;		
		String sqlStr="SELECT   count(*) from bl_package where operating_facility_id ='"+facility_id+"' and package_code =";		
		
	
		int count =0;
		try{
			connection = getConnection();
						 
				sqlStr="SELECT   count(*) from bl_package where operating_facility_id ='"+facility_id+"' and package_code ='"+packageCode+"'";
				  if(episode_type.equals("OP"))				  
					 sqlStr = sqlStr + " and  OP_YN= 'Y' ";
				  if(episode_type.equals("EM"))				  
						 sqlStr = sqlStr + " and  EM_YN= 'Y' ";
				  if(episode_type.equals("IP"))				  
						 sqlStr = sqlStr + " and  IP_YN= 'Y' ";
				  if(episode_type.equals("DC"))				  
						 sqlStr = sqlStr + " and  DC_YN= 'Y' ";	  
							
			pstmt=connection.prepareStatement(sqlStr);					
		
			rs					= pstmt.executeQuery();
			while (rs.next()){				
				 count = Integer.parseInt(rs.getString(1));
				  
				   if(count == 0 )  return false;
				}
		
		
	}catch(Exception e){
			System.out.println("Exception in subscribedOpenPkgs() of PkgAssociateBean.java="+e);
			e.printStackTrace();
	}finally{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(connection!=null) ConnectionManager.returnConnection(connection);
	}
		
		return true;
		
	}
	public ArrayList subscribedOpenPkgs(String facility_id,String language_id,String patient_id,String visit_admin_date) throws Exception 	{
		Connection connection 		= null;		
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		ArrayList subscribedOpenPkgs=new ArrayList();
		String sqlStr="";	
		try{
			connection = getConnection();	
			sqlStr="SELECT   a.package_code package_code, a.package_seq_no, to_char(a.eff_from_date,'dd/mm/yyyy HH24:MI:SS') eff_from_date, to_char(a.eff_to_date,'dd/mm/yyyy HH24:MI:SS') eff_to_date, b.short_desc short_desc,PACKAGE_AMT FROM bl_package_sub_hdr a, bl_package_lang_vw b  WHERE a.operating_facility_id =?   AND a.operating_facility_id = b.operating_facility_id    AND a.package_code = b.package_code   AND b.language_id =?   AND a.patient_id = ?   AND to_date(?,'dd/mm/yyyy') BETWEEN trunc(a.EFF_FROM_DATE) AND trunc(NVL(a.eff_to_date,SYSDATE))   AND a.status = 'O' order by a.package_seq_no";
			pstmt=connection.prepareStatement(sqlStr);					
			pstmt.setString(1,facility_id);
			pstmt.setString(2,language_id);
			pstmt.setString(3,patient_id);
			pstmt.setString(4,visit_admin_date);
			rs							= pstmt.executeQuery();
			while (rs.next()){
				String[] record = new String[6];
				record[0]=checkForNull(rs.getString("package_seq_no"));
				record[1]=checkForNull(rs.getString("package_code"));
				record[2]=checkForNull(rs.getString("short_desc"));
				record[3]=checkForNull(rs.getString("eff_from_date"));
				record[4]=checkForNull(rs.getString("eff_to_date"));
				record[5]=checkForNull(rs.getString("PACKAGE_AMT"));
			//	record[3]=checkForNull(rs.getString("associated_yn"));
				subscribedOpenPkgs.add(record) ;
					
			}
		}catch(Exception e){
				System.out.println("Exception in subscribedOpenPkgs() of PkgAssociateBean.java="+e);
				e.printStackTrace();
		}finally{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
		}
		return subscribedOpenPkgs;
	}	
	
}

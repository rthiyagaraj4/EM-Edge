/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PkgAssociationExistingPackagesBean{
	
	String existingPkgCode;
	String existingPkgSeqNo;
	String existingPkgEpiType;
	String existingPkgFrmDte;
	String existingPkgBlngClassCode;
	

		public String getExistingPkgBlngClassCode() {
		return existingPkgBlngClassCode;
	}
	public void setExistingPkgBlngClassCode(String existingPkgBlngClassCode) {
		this.existingPkgBlngClassCode = existingPkgBlngClassCode;
	}


	public String getExistingPkgFrmDte() {
		return existingPkgFrmDte;
	}
	public void setExistingPkgFrmDte(String existingPkgFrmDte) {
		this.existingPkgFrmDte = existingPkgFrmDte;
	}
	public String getExistingPkgCode() {
		return existingPkgCode;
	}
	public void setExistingPkgCode(String existingPkgCode) {
		this.existingPkgCode = existingPkgCode;
	}
	public String getExistingPkgSeqNo() {
		return existingPkgSeqNo;
	}
	public void setExistingPkgSeqNo(String existingPkgSeqNo) {
		this.existingPkgSeqNo = existingPkgSeqNo;
	}
	public String getExistingPkgEpiType() {
		return existingPkgEpiType;
	}
	public void setExistingPkgEpiType(String existingPkgEpiType) {
		this.existingPkgEpiType = existingPkgEpiType;
	}
		
	@Override
	public String toString() {
		return "PkgAssociationExistingPackagesBean [existingPkgCode="
				+ existingPkgCode + ", existingPkgSeqNo=" + existingPkgSeqNo
				+ ", existingPkgEpiType=" + existingPkgEpiType
				+ ", existingPkgFrmDte=" + existingPkgFrmDte 
				+ ",existingPkgBlngClassCode=" + existingPkgBlngClassCode + "]";
	}
	
	public String getEpisodeTypeForPackage(Connection con,String packageCode) throws SQLException{
		PreparedStatement pstmt=null;
		ResultSet rst = null; 
		String finalEpisodeType="";
			try{
				pstmt = con.prepareStatement( " select OP_YN,EM_YN,IP_YN,DC_YN from  bl_package where PACKAGE_CODE=?");
				pstmt.setString(1,packageCode);
				rst = pstmt.executeQuery();	
				String strOPYN  =   "";
				String strEMYN  =   "";
				String strIPYN  =   "";
				String strDCYN  =   "";

				
				while(rst.next())
				{
					strOPYN  =  rst.getString(1);
					strEMYN  =  rst.getString(2);
					strIPYN  =  rst.getString(3);
					strDCYN  =  rst.getString(4);
				}
			
				if(strOPYN==null) strOPYN="";
				if(strEMYN==null) strEMYN="";	
				if(strIPYN==null) strIPYN="";
				if(strDCYN==null) strDCYN="";
				
				if(strOPYN.equals("Y")){				
						finalEpisodeType="OP";	
				}
				if(strEMYN.equals("Y")){
					if(finalEpisodeType.equals("")) {
						finalEpisodeType="EM";
					}else{
						finalEpisodeType=finalEpisodeType+"/EM";	
					}
				}
				if(strIPYN.equals("Y"))
				{	
					if(finalEpisodeType.equals("")) {
						finalEpisodeType="IP";
					}else{
						finalEpisodeType=finalEpisodeType+"/IP";	
					}		
				}
				if(strDCYN.equals("Y"))
				{				
					if(finalEpisodeType.equals("")) {
						finalEpisodeType="DC";
					}else{
						finalEpisodeType=finalEpisodeType+"/DC";	
					}
				}
			
			}catch(Exception e)
			{
					System.out.println("Exception no. of decimal :"+e);
					e.printStackTrace();
			}
			finally{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
			}
	return finalEpisodeType;
	}
	

	
	
	
	
}

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
  /*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           NandhiniM
 */
package eBL;
import java.io.*;
import java.util.*;
import java.sql.*;
import eBL.Common.*;
import webbeans.eCommon.*;
import eCommon.Common.CommonAdapter;


public class PkgAdhocDiscountBean extends BlAdapter implements Serializable
{
	protected ArrayList packageSeqNoList	= new ArrayList();
	protected HashMap adhocDiscountDtls		= new HashMap();
	public PkgAdhocDiscountBean()
	{	
		//System.out.println("Bean Initialized");
	}

	public HashMap validate() throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." );
		return map;
	}

	public void  setAdhocDiscountDtls(HashMap  adhocDiscountDtls)
	{ 
		this.adhocDiscountDtls = adhocDiscountDtls;
	}
	public HashMap getAdhocDiscountDtls()
	{ 
		return this.adhocDiscountDtls ; 
	}

	public void  setPackageSeqNoList(ArrayList  packageSeqNoList)
	{ 
		this.packageSeqNoList = packageSeqNoList;
	}

	
	public ArrayList getPackageSeqNoList()
	{ 
		return this.packageSeqNoList ; 
	}


	public void clearBean()
	{
		//System.out.println("Bean Cleared");
		if(adhocDiscountDtls != null)
			adhocDiscountDtls.clear();
		if(packageSeqNoList != null)
			packageSeqNoList.clear();
	}
		
	public void setDBValues(String operating_facility_id,String patientId, String packageSeqNo, String packageCode,String language_id) throws Exception
	{
		Connection connection 		= null;		
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;		
		String sqlStr="";		
	/*	System.out.println("in bean, operating_facility_id="+operating_facility_id);
		System.out.println("in bean, patientId="+patientId);
		System.out.println("in bean, packageSeqNo="+packageSeqNo);
		System.out.println("in bean, packageCode="+packageCode);
		System.out.println("in bean, language_id="+language_id);*/
		ArrayList enconterDtls	= new ArrayList();
		ArrayList dtls			= null ;
		//sqlStr ="select A.ENCOUNTER_ID, A.BLNG_GRP_ID, A.CUST_GROUP_CODE, B.SHORT_NAME GROUP_NAME, A.CUST_CODE, B.SHORT_NAME CUST_NAME, A.PRIORITY, A.POLICY_TYPE_CODE, A.POLICY_NUMBER, A.APPROVED_AMT,A.EPISODE_TYPE, A.VISIT_ID,A.APPT_BOOK_REF_NUM, A.ACCT_SEQ_NO, A.EPISODE_ID, A.ADHOC_DISCOUNT, A.ADHOC_DISCOUNT_TYPE  from bl_encounter_payer_for_pkg A, AR_CUSTOMER_LANG_VW B where A.operating_facility_id = ? AND   A.PATIENT_ID = ? and   A.package_seq_no = ? and   A.package_code = ? AND   A.CUST_CODE = B.CUST_CODE AND   A.CUST_GROUP_CODE = B.CUST_GROUP_CODE AND   B.LANGUAGE_ID = ?";
       //	sqlStr ="select blpackage.get_discount_for_cust (A.operating_facility_id, A.PATIENT_ID, A.package_seq_no,A.CUST_GROUP_CODE,A.CUST_CODE) discount_as_per_setup, A.ENCOUNTER_ID, A.BLNG_GRP_ID, A.CUST_GROUP_CODE, B.SHORT_NAME GROUP_NAME, A.CUST_CODE, B.SHORT_NAME CUST_NAME, A.PRIORITY, A.POLICY_TYPE_CODE, A.POLICY_NUMBER, A.APPROVED_AMT,A.EPISODE_TYPE, A.VISIT_ID,A.APPT_BOOK_REF_NUM, A.ACCT_SEQ_NO, A.EPISODE_ID, A.ADHOC_DISCOUNT, A.ADHOC_DISCOUNT_TYPE  from bl_encounter_payer_for_pkg A, AR_CUSTOMER_LANG_VW B where A.operating_facility_id = ? AND   A.PATIENT_ID = ? and   A.package_seq_no = ? and   A.package_code = ? AND   A.CUST_CODE = B.CUST_CODE  AND   A.CUST_GROUP_CODE = B.CUST_GROUP_CODE AND   B.LANGUAGE_ID = ? union all select null, null,null,null,null,a.patient_id, b.patient_name ,null,null,null,null,null,null,null,null,null,a.ADHOC_DISC_TO_PATIENT, a.ADHOC_DISC_TYPE_TO_PATIENT from bl_package_sub_hdr a, mp_patient b where A.operating_facility_id = ?  AND   A.PATIENT_ID = ?  and   A.package_seq_no = ?  and   A.package_code = ?  and a.patient_id=b.patient_id"; 		
      //	sqlStr ="SELECT a.cust_group_code cust_group_code, b.short_desc cust_group_desc,DECODE (a.cust_code, NULL, 'Patient ID : ' || ? ||' '|| d.patient_name, a.cust_code) cust_code,c.short_name cust_desc,blpackage.get_discount_for_cust (a.operating_facility_id, a.patient_id, a.package_seq_no, a.cust_group_code, a.cust_code ) discount_as_per_setup, a.discount_type discount_type, a.discount discount, 'U' to_update FROM bl_package_adhoc_discount a,  ar_cust_group_lang_vw b, ar_customer_lang_vw c, mp_patient d WHERE a.operating_facility_id = ? AND a.patient_id = ?  AND a.package_seq_no = ?  AND a.package_code = ? AND (NVL(a.cust_group_code, '#'), NVL (a.cust_code, '#')) NOT IN (SELECT d.cust_group_code, d.cust_code FROM bl_encounter_payer_priority d, bl_package_encounter_dtls e WHERE d.operating_facility_id = e.operating_facility_id              AND d.episode_type = e.episode_type AND d.episode_id = e.encounter_id AND d.patient_id = ? AND (   (d.episode_type IN ('O', 'E') AND d.visit_id = e.visit_id )  OR (d.episode_type IN ('I', 'D')) ) AND e.package_code = ? AND e.package_seq_no = ?) AND a.cust_group_code = b.cust_group_code(+)  AND a.cust_code = c.cust_code(+) AND b.language_id(+) = ?  AND c.language_id(+) = ? and a.patient_id =d.patient_id union all SELECT null cust_group_code, null cust_group_desc, 'Patient ID : ' || ?|| ' '|| b.patient_name cust_code, null cust_desc, null discount_as_per_setup, a.discount_type discount_type, a.discount discount, 'U' to_update  FROM bl_package_adhoc_discount a ,mp_patient b WHERE a.operating_facility_id = ?   AND a.patient_id = ?   AND a.package_seq_no = ?   AND a.package_code = ?   and a.cust_group_code is null   and a.cust_code is null and a.patient_id=b.patient_id UNION ALL SELECT a.cust_group_code, c.short_desc cust_group_desc, a.cust_code,  d.short_name cust_desc, blpackage.get_discount_for_cust  (a.operating_facility_id, a.patient_id,                             b.package_seq_no, a.cust_group_code, a.cust_code ) discount_as_per_setup, NULL discount_type, NULL discount, 'I'  FROM bl_encounter_payer_priority a,bl_package_encounter_dtls b, ar_cust_group_lang_vw c,ar_customer_lang_vw d WHERE a.operating_facility_id = b.operating_facility_id AND a.episode_type = b.episode_type  AND a.episode_id = b.encounter_id   AND a.patient_id = ?   AND (   (a.episode_type IN ('O', 'E') AND a.visit_id = b.visit_id) OR (a.episode_type IN ('I', 'D')))   AND b.package_code = ?  AND b.package_seq_no = ?   AND a.cust_group_code IS NOT NULL   AND a.cust_code IS NOT NULL   AND a.cust_group_code = c.cust_group_code(+)   AND a.cust_code = d.cust_code(+)   AND c.language_id(+) = ?   AND d.language_id(+) = ? AND (a.cust_group_code, a.cust_code) NOT IN (SELECT cust_group_code, cust_code FROM bl_package_adhoc_discount  WHERE operating_facility_id = ?  AND patient_id = ? AND package_seq_no = ? AND package_code = ?) UNION ALL SELECT NULL cust_group_code, NULL cust_group_desc, 'Patient ID : ' || ?||' '|| b.patient_name cust_code, NULL cust_desc,       NULL discount_as_per_setup, NULL discount_type, NULL discount, 'I'  FROM DUAL a,mp_patient b WHERE NOT EXISTS (SELECT 1 FROM bl_package_adhoc_discount  WHERE operating_facility_id = ?  AND patient_id = ? AND package_seq_no = ?  AND package_code = ? AND cust_code IS NULL  AND cust_group_code IS NULL) and b.patient_id=?"; 		
      	//sqlStr ="SELECT a.cust_group_code cust_group_code, b.short_desc cust_group_desc, DECODE (a.cust_code,NULL, 'Patient ID : ' || ? || ' ' || d.patient_name, a.cust_code)  cust_code,c.short_name cust_desc,blpackage.get_discount_for_cust(a.operating_facility_id, a.patient_id, a.package_seq_no,  a.cust_group_code, a.cust_code) discount_as_per_setup,       a.discount_type discount_type, a.discount discount, 'U' to_update  FROM bl_package_adhoc_discount a,       ar_cust_group_lang_vw b, ar_customer_lang_vw c, mp_patient d WHERE a.operating_facility_id = ?   AND a.patient_id = ?   AND a.package_seq_no = ?   AND a.package_code = ?   AND a.cust_group_code = b.cust_group_code(+)   AND a.cust_code = c.cust_code(+)   AND b.language_id(+) = ?   AND c.language_id(+) = ?   AND a.patient_id = d.patient_id UNION ALL SELECT a.cust_group_code, c.short_desc cust_group_desc, a.cust_code, d.short_name cust_desc, blpackage.get_discount_for_cust (a.operating_facility_id,a.patient_id, b.package_seq_no,  a.cust_group_code,  a.cust_code ) discount_as_per_setup,NULL discount_type, NULL discount, 'I'  FROM bl_encounter_payer_priority a, bl_package_encounter_dtls b, ar_cust_group_lang_vw c,  ar_customer_lang_vw d WHERE a.operating_facility_id = b.operating_facility_id   AND a.episode_type = b.episode_type   AND a.episode_id = b.encounter_id   AND a.patient_id = ?   AND (   (a.episode_type IN ('O', 'E') AND a.visit_id = b.visit_id)  OR (a.episode_type IN ('I', 'D')))   AND b.package_code = ?   AND b.package_seq_no = ?   AND a.cust_group_code IS NOT NULL   AND a.cust_code IS NOT NULL   AND a.cust_group_code = c.cust_group_code(+)   AND a.cust_code = d.cust_code(+)   AND c.language_id(+) = ?   AND d.language_id(+) = ?   AND (a.cust_group_code, a.cust_code) NOT IN (SELECT cust_group_code, cust_code FROM bl_package_adhoc_discount WHERE operating_facility_id = ?  AND patient_id = ? AND package_seq_no = ?      AND package_code = ?) UNION ALL SELECT NULL cust_group_code, NULL cust_group_desc, 'Patient ID : ' || ? || ' ' || b.patient_name cust_code, NULL cust_desc, NULL discount_as_per_setup, NULL discount_type, NULL discount, 'I'  FROM DUAL a, mp_patient b WHERE NOT EXISTS (SELECT 1  FROM bl_package_adhoc_discount  WHERE operating_facility_id = ?  AND patient_id = ? AND package_seq_no = ?  AND package_code = ?   AND cust_code IS NULL  AND cust_group_code IS NULL)   AND b.patient_id = ?"; 		
      	sqlStr ="SELECT a.DISC_REASON_CODE disc_reason_code,A.DISC_REASON_DESC disc_reason_desc,a.cust_group_code cust_group_code, b.short_desc cust_group_desc, DECODE (a.cust_code, NULL, 'Patient ID : ' || ? || ' ' || d.patient_name, a.cust_code ) cust_code, c.short_name cust_desc, blpackage.get_discount_for_cust (a.operating_facility_id,a.patient_id,a.package_seq_no,a.cust_group_code, a.cust_code) discount_as_per_setup,a.discount_type discount_type, a.discount discount, 'U' to_update  FROM bl_package_adhoc_discount a,ar_cust_group_lang_vw b,ar_customer_lang_vw c,mp_patient d WHERE a.operating_facility_id = ? AND a.patient_id = ?   AND a.package_seq_no = ?   AND a.package_code = ?   AND a.cust_group_code = b.cust_group_code(+)   AND a.cust_code = c.cust_code(+)   AND b.language_id(+) = ?   AND c.language_id(+) = ?   AND a.patient_id = d.patient_id UNION ALL SELECT NULL disc_reason_code,NULL disc_reason_desc,a.cust_group_code, c.short_desc cust_group_desc, a.cust_code,d.short_name cust_desc,blpackage.get_discount_for_cust(a.operating_facility_id,a.patient_id,b.package_seq_no,a.cust_group_code,a.cust_code) discount_as_per_setup,NULL discount_type, NULL discount, 'I'  FROM bl_encounter_payer_priority a,bl_package_encounter_dtls b,ar_cust_group_lang_vw c,ar_customer_lang_vw d WHERE a.operating_facility_id = b.operating_facility_id   AND a.episode_type = b.episode_type   AND a.episode_id = b.encounter_id   AND a.patient_id = ?   AND ((a.episode_type IN ('O', 'E') AND a.visit_id = b.visit_id) OR (a.episode_type IN ('I', 'D'))) AND ((a.episode_type IN ('O', 'E') and a.acct_seq_no = (select e.cur_acct_seq_no from bl_visit_fin_dtls e where e.patient_id= a.patient_id and e.episode_id= a.episode_id and e.episode_type = a.episode_type and e.visit_id=a.visit_id and e.operating_facility_id=a.operating_facility_id)) or   (a.episode_type IN ('I', 'D') and a.acct_seq_no = (select e.cur_acct_seq_no from bl_episode_fin_dtls e where e.patient_id= a.patient_id and e.episode_id= a.episode_id and e.episode_type = a.episode_type and e.operating_facility_id=a.operating_facility_id)))   AND b.package_code = ?   AND b.package_seq_no = ?   AND a.cust_group_code IS NOT NULL   AND a.cust_code IS NOT NULL   AND a.cust_group_code = c.cust_group_code   AND a.cust_code = d.cust_code   AND c.language_id = ?   AND d.language_id = ?   AND (a.cust_group_code, a.cust_code) NOT IN (SELECT cust_group_code, cust_code FROM bl_package_adhoc_discount WHERE operating_facility_id = ?             AND patient_id = ? AND package_seq_no = ? AND package_code = ? AND CUST_CODE IS NOT NULL) UNION ALL SELECT NULL disc_reason_code,NULL disc_reason_desc,NULL cust_group_code, NULL cust_group_desc,'Patient ID : ' || ? || ' ' || b.patient_name cust_code,NULL cust_desc, NULL discount_as_per_setup, NULL discount_type,       NULL discount, 'I'  FROM  mp_patient b WHERE NOT EXISTS (SELECT 1 FROM bl_package_adhoc_discount WHERE operating_facility_id = ? AND patient_id = ? AND package_seq_no = ? AND package_code = ? AND cust_code IS NULL AND cust_group_code IS NULL) AND b.patient_id = ? ORDER BY CUST_GROUP_CODE,CUST_CODE"; 		
		try		
		{
			/*if(!(packageSeqNoList.contains(packageSeqNo)))
				packageSeqNoList.add(packageSeqNoList);
			setPackageSeqNoList(packageSeqNoList);	*/

			connection = getConnection();			
			pstmt=connection.prepareStatement(sqlStr);	
		/*	pstmt.setString(1,operating_facility_id);
			pstmt.setString(2,patientId);
			pstmt.setString(3,packageSeqNo);
			pstmt.setString(4,packageCode);
			pstmt.setString(5,language_id);
			pstmt.setString(6,operating_facility_id);
			pstmt.setString(7,patientId);
			pstmt.setString(8,packageSeqNo);
			pstmt.setString(9,packageCode);*/
			pstmt.setString(1,patientId);
			pstmt.setString(2,operating_facility_id);
			pstmt.setString(3,patientId);
			pstmt.setString(4,packageSeqNo);
			pstmt.setString(5,packageCode);
			pstmt.setString(6,language_id);
			pstmt.setString(7,language_id);			
			pstmt.setString(8,patientId);
			pstmt.setString(9,packageCode);	
			pstmt.setString(10,packageSeqNo);			
			pstmt.setString(11,language_id);
			pstmt.setString(12,language_id);		
			pstmt.setString(13,operating_facility_id);
			pstmt.setString(14,patientId);
			pstmt.setString(15,packageSeqNo);
			pstmt.setString(16,packageCode);
			pstmt.setString(17,patientId);		
			pstmt.setString(18,operating_facility_id);
			pstmt.setString(19,patientId);
			pstmt.setString(20,packageSeqNo);
			pstmt.setString(21,packageCode);			
			pstmt.setString(22,patientId);
//System.out.println("packageSeqNo BEAN :"+packageSeqNo);

			rs = pstmt.executeQuery();
			while (rs.next())
			{
				dtls	= new ArrayList();
				/*dtls.add((String)rs.getString("ENCOUNTER_ID"));
				dtls.add((String)rs.getString("BLNG_GRP_ID"));
				dtls.add((String)rs.getString("CUST_GROUP_CODE"));
				dtls.add((String)rs.getString("GROUP_NAME"));
				dtls.add((String)rs.getString("CUST_CODE"));
				dtls.add((String)rs.getString("CUST_NAME"));
				dtls.add((String)rs.getString("PRIORITY"));
				dtls.add((String)rs.getString("POLICY_TYPE_CODE"));
				dtls.add((String)rs.getString("POLICY_NUMBER"));
				dtls.add((String)rs.getString("APPROVED_AMT"));
				dtls.add((String)rs.getString("discount_as_per_setup"));
				dtls.add((String)rs.getString("EPISODE_TYPE")); dtls.add((String)rs.getString("VISIT_ID"));
				dtls.add((String)rs.getString("APPT_BOOK_REF_NUM")); dtls.add((String)rs.getString("ACCT_SEQ_NO"));
				dtls.add((String)rs.getString("EPISODE_ID"));  
				dtls.add((String)rs.getString("ADHOC_DISCOUNT"));
				dtls.add((String)rs.getString("ADHOC_DISCOUNT_TYPE"));*/
//				System.out.println("rs.getString BEAN " +rs.getString("disc_reason_desc") );								
				dtls.add((String)rs.getString("cust_group_code"));
				dtls.add((String)rs.getString("cust_group_desc"));
				dtls.add((String)rs.getString("cust_code"));
				dtls.add((String)rs.getString("cust_desc"));
				dtls.add((String)rs.getString("discount_as_per_setup"));
				dtls.add((String)rs.getString("discount_type"));
				dtls.add((String)rs.getString("discount"));
				dtls.add((String)rs.getString("to_update"));				
				dtls.add(packageCode);
				dtls.add((String)rs.getString("disc_reason_code"));
				dtls.add((String)rs.getString("disc_reason_desc"));
				dtls.add("N");//Added for Delete option added in PackageAdhocDiscount function
				enconterDtls.add(dtls);
			}
			if(enconterDtls.size()>0)
			{
				adhocDiscountDtls.put(packageSeqNo,enconterDtls);
				setAdhocDiscountDtls(adhocDiscountDtls);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception from Package MAin :"+e);
			e.printStackTrace();
		}
		finally
		{
			if(connection!=null) ConnectionManager.returnConnection(connection);
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();
		}
	}
	public String getNoOfDecimal() throws Exception
	{
		Connection connection 		= getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		String noofdecimal = "";
		try
		{
			String sql = "select nvl(no_of_decimal,2) noofdecimal from  sm_acc_entity_param";
			pstmt=connection.prepareStatement(sql);	
			rs = pstmt.executeQuery();
			if (rs.next())
				noofdecimal = rs.getString("noofdecimal");
		}
		catch(Exception e)
		{
			System.out.println("Exception from getNoOfDecimal :"+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
		}
		return noofdecimal ;

	}
	
	//Added by Rajesh V for MMS-DM-SCF-0461
	public boolean getSiteSpecDisableRow(String functionalityId){
		boolean disableExclAdhocDisc = false;
		Connection con = null;
		try{
			con = ConnectionManager.getConnection();
			disableExclAdhocDisc = eCommon.Common.CommonBean.isSiteSpecific(con, "BL",functionalityId);
		}
		catch(Exception e){
			System.err.println("Exception in getSiteSpecDisableRow ->"+e);
			e.printStackTrace();
		}
		finally{
			if(con != null){
				ConnectionManager.returnConnection(con);
			}
		}
		return disableExclAdhocDisc;
	}
	
	public String disableRowYN(String facilityId, String patientId, String pkgSeqNo, String pkgCode, String custGroupCode, String custCode){
		String disableYN = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement("Select bl_ins_pack_exc_yn(?,?,?,?,?,?)  from dual ");
			pstmt.setString(1, facilityId);
			pstmt.setString(2, patientId);
			pstmt.setString(3, pkgSeqNo);
			pstmt.setString(4, pkgCode);
			pstmt.setString(5, custGroupCode);
			pstmt.setString(6, custCode);
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()){
				disableYN = rs.getString(1);
			}
		}
		catch(Exception e){
			System.err.println("Exception in getSiteSpecDisableRow ->"+e);
			e.printStackTrace();
		}
		finally{
			if(con != null){
				ConnectionManager.returnConnection(con);
			}
			//Added against V210416 Starts
			try{
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in disableRowYN:"+e);
		}
		//Added against V210416 Ends
		return disableYN;
	}
	}
	//Added by Rajesh V for MMS-DM-SCF-0461
}

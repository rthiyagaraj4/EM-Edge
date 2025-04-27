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

public class PkgSrvsToNonPkgSvsBean extends BlAdapter implements Serializable
{
	protected ArrayList packageSeqNoList	= new ArrayList();
	protected HashMap srvsToNonPkgSvsDtls		= new HashMap();
	public PkgSrvsToNonPkgSvsBean()
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

	public void  setSrvsToNonPkgSvsDtls(HashMap  srvsToNonPkgSvsDtls)
	{ 
		this.srvsToNonPkgSvsDtls = srvsToNonPkgSvsDtls;
	}
	public HashMap getSrvsToNonPkgSvsDtls()
	{ 
		return this.srvsToNonPkgSvsDtls ; 
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
		if(srvsToNonPkgSvsDtls != null)
			srvsToNonPkgSvsDtls.clear();
		if(packageSeqNoList != null)
			packageSeqNoList.clear();
	}
		
	public void setDBValues(String operating_facility_id,String patientId, String packageSeqNo, String language_id) throws Exception
	{
		Connection connection 		= null;		
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;		
		String sqlStr="";		
		//System.out.println("in bean, operating_facility_id="+operating_facility_id);
		//System.out.println("in bean, patientId="+patientId);
		//System.out.println("in bean, packageSeqNo="+packageSeqNo);
		//System.out.println("in bean, language_id="+language_id);
		ArrayList srvDetails	= new ArrayList();
		ArrayList dtls			= null ;
       	sqlStr ="select	a.trx_doc_ref ,a.trx_doc_ref_line_num ,a.blng_serv_code	,c.short_desc ,TO_CHAR (a.service_date,'dd/mm/yyyy') service_date ,a.serv_qty  Qty ,a.base_charge_amt	Amount , sum(decode(nvl(b.package_trx_yn,'N'),'Y',	nvl(b.org_net_charge_amt,0),0)) Exempt_in_package, sum(decode(nvl(b.package_trx_yn,'N'),'Y',	nvl(b.payer_package_cov_amt,0),0)) Payers_Package_coverage, sum(decode(nvl(b.package_trx_yn,'N'),'Y',	decode(nvl(b.cust_group_code,'#'),'#', decode(nvl(b.cust_code,'#'),'#',nvl(b.org_net_charge_amt,0),0),0),0)) Patient_payable from bl_patient_charges_folio a, bl_package_folio b,  bl_blng_serv_lang_vw c where a.trx_status is null and nvl(a.package_trx_yn,'N')='Y' and a.operating_facility_id=b.operating_facility_id and a.trx_doc_ref=b.trx_doc_ref and a.trx_doc_ref_line_num=b.trx_doc_ref_line_num and a.trx_doc_ref_seq_num=b.trx_doc_ref_seq_num and b.trx_status is null and nvl(b.package_trx_yn,'N')='Y'	and a.blng_serv_code=c.blng_serv_code and c.language_id=? and a.operating_facility_id=?	and a.package_seq_no=? and a.patient_id=? group by a.trx_doc_ref,a.trx_doc_ref_line_num	,a.blng_serv_code ,c.short_desc ,TO_CHAR (a.service_date, 'dd/mm/yyyy') ,a.serv_qty ,a.base_charge_amt"; 		
		try		{

			connection = getConnection();			
			pstmt=connection.prepareStatement(sqlStr);	
			pstmt.setString(1,language_id);
			pstmt.setString(2,operating_facility_id);
			pstmt.setString(3,packageSeqNo);
			pstmt.setString(4,patientId);
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				dtls	= new ArrayList();
				dtls.add((String)rs.getString("trx_doc_ref"));
				dtls.add((String)rs.getString("trx_doc_ref_line_num"));
				dtls.add((String)rs.getString("blng_serv_code"));
				dtls.add((String)rs.getString("short_desc"));
				dtls.add((String)rs.getString("service_date"));
				dtls.add((String)rs.getString("Qty"));
				dtls.add((String)rs.getString("Amount"));
				dtls.add((String)rs.getString("Exempt_in_package"));
				dtls.add((String)rs.getString("Payers_Package_coverage"));
				dtls.add((String)rs.getString("Patient_payable"));
				srvDetails.add(dtls);

			}
			if(srvDetails.size()>0)
			{
				srvsToNonPkgSvsDtls.put(packageSeqNo,srvDetails);
				setSrvsToNonPkgSvsDtls(srvsToNonPkgSvsDtls);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception from PkgSrvsToNonPkgSvsBean :"+e);
			e.printStackTrace();
		}
		finally
		{
			if(connection!=null) ConnectionManager.returnConnection(connection);
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();
		}
	}
}

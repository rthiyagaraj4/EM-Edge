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

public class PkgApprovalBean extends BlAdapter implements Serializable
{
	protected HashMap payerDtls=new HashMap();	
	protected ArrayList details=new ArrayList();	

/*			String mapKey=blng_grp_code+"~~"+payer_grp_code+"~~"+payer_code+"~~"+policy_type_code+"~~"+policy_no+"~~"+policy_eff_frm_date;
			HashMap payerDtls=(HashMap)bean.getPayerDtls();
	ArrayList payer=(ArrayList)payerDtls.get(mapKey);
		HashMap hdrDtls=	(HashMap)payer.get(0);//contains Hdr dtls
		HashMap authDtls=	(HashMap)payer.get(1);// contains Credit_auth_ref dtls key is appr_seq_no
		HashMap pkgApprovals=	(HashMap)payer.get(2);// contains pkg approvals for each appr_seq_no
		authDtls ==>;appr_seq_no as key, value is a record[] => appr_seq_no(String),credit_auth_ref(String),credit_auth_date(String),credit_auth_amt(String),credit_apprd_days(String),pkg_approval_yn(String),pol_validity_chk_date(String)
		pkgApprovals; // appr_seq_no is key and Arraylist =>each value is a String[]=>pkg_seq_no(String),pkg_code(String),pkg_desc(String), appv_amt(String)
	*/
		public void setPayerDtls(HashMap payerDtls){
		this.payerDtls=payerDtls;// Payer as key, value is a ArrayList =>0- hdr values(ArrayList),1 -authDtls(HashMap) ,2 - pkgApprovals(HashMap) 
	}
	public HashMap getPayerDtls(){
		return this.payerDtls;
	}
	
	public void saveDetails(String key){
		if( this.payerDtls!=null &&  this.payerDtls.size()>0 &&  this.payerDtls.containsKey(key))
			this.payerDtls.remove(key);
		this.payerDtls.put(key,this.details);	
	}
	public ArrayList getDetails(){
		return this.details;
	}
	public void setDetails(ArrayList details){
		 this.details=details;
	}
	public PkgApprovalBean()
	{	
		//System.out.println("Bean Initialized");
	}
	public void clearBean(){
		payerDtls=new HashMap();
		
		details=new ArrayList();
	}
	
	/*public String getPkgDesc(String facility_id,String locale,String patient_id,String encounter_date_aft_trunc,String pkg_code,String pkg_seq_no) throws Exception {
		Connection connection 		= null;		
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		String pkg_desc="";
		String sqlStr="";
		try{
			connection = getConnection();	
			sqlStr="SELECT   b.short_desc description  FROM bl_package_sub_hdr a, bl_package_lang_vw b   WHERE a.operating_facility_id =?   AND a.operating_facility_id = b.operating_facility_id    AND a.package_code = b.package_code   AND b.language_id =?   AND a.patient_id = ?   AND to_date(?,'dd/mm/yyyy') BETWEEN trunc(a.EFF_FROM_DATE) AND trunc(NVL(a.eff_to_date,SYSDATE))  and a.package_code=? and a.package_seq_no=? AND a.status = 'O' ";
			pstmt=connection.prepareStatement(sqlStr);					
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locale);
			pstmt.setString(3,patient_id);
			pstmt.setString(4,encounter_date_aft_trunc);
			pstmt.setString(5,pkg_code);
			pstmt.setString(6,pkg_seq_no);
			rs							= pstmt.executeQuery();
			while (rs.next()){
				pkg_desc=checkForNull(rs.getString("description"),"");
			}
		}catch(Exception e){
			System.out.println("Exception e="+e);
			e.printStackTrace();
		}
		return pkg_desc;
	}*/
	public void setDBApprvlsToBean(String facility_id,String episode_type,String patient_id,String blng_grp_code,String payer_grp_code,String payer_code,String priority,String policy_type_code,String policy_no,String policy_eff_frm_date,String credit_auth_ref,String credit_auth_date,String credit_apprd_amt,String credit_apprd_days)  throws Exception 
	{
		Connection connection 		= null;		
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		String mapKey="";
		try
		{		
			//  set database values of appraval dtls  in the PkgApprovalBean.
			mapKey=blng_grp_code.trim()+"~~"+payer_grp_code.trim()+"~~"+payer_code.trim()+"~~"+priority.trim()+"~~"+policy_type_code.trim()+"~~"+policy_no.trim()+"~~"+policy_eff_frm_date.trim();
//			System.err.println("mapKey="+mapKey);
			String appr_seq_no="";
			String pkgApprv_credit_auth_ref="";
			String pkgApprv_credit_auth_date="";
			String pkgApprv_credit_apprd_amt="";
			String pkgApprv_credit_apprd_days="";
			String pkgApprv_pkg_dtls_yn="";
			HashMap payerDetaills=(HashMap)getPayerDtls();
//			System.err.println("payerDtls.size() before seting dbvalues="+payerDetaills.size());
//			System.err.println("payerDetaills before seting dbvalues="+payerDetaills);
			ArrayList payer=new ArrayList();
			HashMap hdrDtls=new HashMap();
			HashMap authDtls=new HashMap();
			HashMap pkgApprovals=new HashMap();
			
			ArrayList	creditAuthDtls=new ArrayList();
					
			if(payerDetaills==null || payerDetaills.size()==0 || !payerDetaills.containsKey(mapKey))
			{
//				System.err.println("iNSIDE IF Loop");
				connection = getConnection();	

				//System.out.println("@@@@@@@@@@@22");
				//pstmt = connection.prepareStatement("select  distinct a.credit_auth_ref,to_char(a.credit_auth_date,'DD/MM/YYYY'),a.approved_amt,a.approved_days,(select 'Y' from bl_encnt_payer_pkg_approval b where b.operating_facility_id = ? and b.episode_type = ? and b.patient_id = ? and b.blng_grp_id=? and  nvl(b.cust_group_code,'#')=nvl(?,'#')  and  nvl(b.cust_code,'#')=nvl(?,'#')  and b.priority =? and b.policy_type_code=?  and b.policy_number =?  and b.credit_auth_ref= a.credit_auth_ref and rownum=1) Package_approvals_yn  from bl_encounter_payer_approval a where  a.operating_facility_id =? and a.episode_type = ? and a.patient_id = ? and  a.blng_grp_id=? and  nvl(a.cust_group_code,'#')=nvl(?,'#') and  nvl(a.cust_code,'#')=nvl(?,'#') and a.priority  =? and a.policy_type_code=? and a.policy_number =?"); 
				//pstmt = connection.prepareStatement("select  distinct a.credit_auth_ref,to_char(a.credit_auth_date,'DD/MM/YYYY'),a.approved_amt,a.approved_days,'N' Package_approvals_yn  from bl_encounter_payer_approval a where  a.operating_facility_id =? and a.episode_type = ? and a.patient_id = ? and  a.blng_grp_id=? and  nvl(a.cust_group_code,'#')=nvl(?,'#') and  nvl(a.cust_code,'#')=nvl(?,'#') and a.priority  =? and a.policy_type_code=? and a.policy_number =? and to_char(a.effective_from,'DD/MM/YYYY')=?"); 
				pstmt = connection.prepareStatement("select  distinct a.appr_seq_no,a.credit_auth_ref,to_char(a.credit_auth_date,'DD/MM/YYYY'),a.approved_amt,a.approved_days,'N' Package_approvals_yn  from bl_encounter_payer_approval a where  a.operating_facility_id =? and a.episode_type = ? and a.patient_id = ? and  a.blng_grp_id=? and  nvl(a.cust_group_code,'#')=nvl(?,'#') and  nvl(a.cust_code,'#')=nvl(?,'#') and a.priority  =? and a.policy_type_code=? and a.policy_number =? and to_char(a.effective_from,'DD/MM/YYYY')=?");  // IN 20964
				//pstmt1 = connection.prepareStatement("select distinct a.PACKAGE_SEQ_NO ,a.PACKAGE_CODE,b.short_desc,a.APPROVED_AMT  from bl_encnt_payer_pkg_approval a,bl_package b where  a.operating_facility_id  =  ? and  a.episode_type =?  and a.patient_id= ?  and a.blng_grp_id =? and nvl(a.cust_group_code,'#') =nvl(?,'#') and nvl(a.cust_code,'#') =nvl(?,'#') and a.priority =? and a.policy_type_code =? and  a.policy_number =? and a.CREDIT_AUTH_REf=? and a.package_code=b.package_code and  a.operating_facility_id=b.operating_facility_id"); 
				pstmt.setString(1,facility_id);
				pstmt.setString(2,episode_type);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,blng_grp_code);
				pstmt.setString(5,payer_grp_code);
				pstmt.setString(6,payer_code);
				pstmt.setString(7,priority);
				pstmt.setString(8,policy_type_code);
				pstmt.setString(9,policy_no);		
				pstmt.setString(10,policy_eff_frm_date);		
				/*pstmt.setString(10,facility_id);
				pstmt.setString(11,episode_type);
				pstmt.setString(12,patient_id);
				pstmt.setString(13,blng_grp_code);
				pstmt.setString(14,payer_grp_code);
				pstmt.setString(15,payer_code);
				pstmt.setString(16,priority);
				pstmt.setString(17,policy_type_code);
				pstmt.setString(18,policy_no);	*/					
				rs=pstmt.executeQuery();
				if( rs != null ) 
				{
					while(rs.next())
					{
//						System.err.println("When Data Found");
						creditAuthDtls=new ArrayList();
						appr_seq_no=rs.getString(1)==null?"":rs.getString(1);// IN 20964
						pkgApprv_credit_auth_ref=rs.getString(2)==null?"":rs.getString(2);
						pkgApprv_credit_auth_date=rs.getString(3)==null?"":rs.getString(3);
						pkgApprv_credit_apprd_amt=rs.getString(4)==null?"":rs.getString(4);
						pkgApprv_credit_apprd_days=rs.getString(5)==null?"":rs.getString(5);
						pkgApprv_pkg_dtls_yn=rs.getString(6)==null?"N":rs.getString(6);
						//System.out.println("pkgApprv_credit_auth_ref="+pkgApprv_credit_auth_ref);
						
						creditAuthDtls.add(appr_seq_no);
						creditAuthDtls.add(pkgApprv_credit_auth_ref);
						creditAuthDtls.add(pkgApprv_credit_auth_date);
						creditAuthDtls.add(pkgApprv_credit_apprd_amt);
						creditAuthDtls.add(pkgApprv_credit_apprd_days);
						creditAuthDtls.add(pkgApprv_pkg_dtls_yn);
						creditAuthDtls.add("");
//						System.err.println("creditAuthDtls from query exec="+creditAuthDtls.toString());
					
						/*if(!pkgApprv_credit_auth_ref.equals("") && !pkgApprv_credit_apprd_amt.equals(""))
							authDtls.put(pkgApprv_credit_auth_ref,creditAuthDtls);	*/// IN 20964
							authDtls.put(appr_seq_no,creditAuthDtls);	// IN 20964
						//System.out.println(" after authDtls="+authDtls.toString());
						//System.out.println(" pkgApprv_pkg_dtls_yn="+pkgApprv_pkg_dtls_yn);
						/**********get pkg approvals for each credit_auth_Ref******start*******/		
						/*if(!pkgApprv_credit_auth_ref.equals("") && pkgApprv_pkg_dtls_yn.equals("Y")){							
							creditPkgApprovals=new ArrayList();													
							pstmt1.setString(1,facility_id);
							pstmt1.setString(2,episode_type);
							pstmt1.setString(3,patient_id);
							pstmt1.setString(4,blng_grp_code);
							pstmt1.setString(5,payer_grp_code);
							pstmt1.setString(6,payer_code);
							pstmt1.setString(7,priority);
							pstmt1.setString(8,policy_type_code);
							pstmt1.setString(9,policy_no);		
							pstmt1.setString(10,pkgApprv_credit_auth_ref);		
						
							rs1=pstmt1.executeQuery();
							if( rs1 != null ) 
							{
								while(rs1.next())
								{
									record=new ArrayList();
									record.add(rs1.getString(1)==null?"":rs1.getString(1));
									record.add(rs1.getString(2)==null?"":rs1.getString(2));
									record.add(rs1.getString(3)==null?"":rs1.getString(3));
									record.add(rs1.getString(4)==null?"":rs1.getString(4));	
									//System.out.println(" before creditPkgApprovals="+creditPkgApprovals.toString());							
									creditPkgApprovals.add(record);
									System.out.println(" after creditPkgApprovals="+creditPkgApprovals.toString());	
									record=null;	
								}
							}
								
							pkgApprovals.put(pkgApprv_credit_auth_ref,creditPkgApprovals);
						}	*/	
						/**********get pkg approvals for each credit_auth_Ref******end*******/						
					}
				}
				if(authDtls==null || authDtls.size()==0)
				{
//					System.err.println("When authDtls is NULL");
					creditAuthDtls=new ArrayList();
					creditAuthDtls.add("1");// IN 20964
					creditAuthDtls.add(credit_auth_ref);
					creditAuthDtls.add(credit_auth_date);
					creditAuthDtls.add(credit_apprd_amt);
					creditAuthDtls.add(credit_apprd_days);
					creditAuthDtls.add("N");
					creditAuthDtls.add("");
//					System.err.println("creditAuthDtls when query has no data="+creditAuthDtls.toString());
					//System.out.println(" before authDtls="+authDtls.toString());
					/*if(!credit_auth_ref.equals(""))
						authDtls.put(credit_auth_ref,creditAuthDtls);	*/// IN 20964
						authDtls.put("1",creditAuthDtls);// IN 20964
				}

				hdrDtls.put("blng_grp_code",blng_grp_code);
				hdrDtls.put("ins_cust_group_code",payer_grp_code);
				hdrDtls.put("cust_3",payer_code);
				hdrDtls.put("priority",priority);
				hdrDtls.put("policy_type_code",policy_type_code);
				hdrDtls.put("policy_no",policy_no);	
				hdrDtls.put("policy_eff_frm_date",policy_eff_frm_date);	
						
				payer.add(hdrDtls);
				payer.add(authDtls);
				payer.add(pkgApprovals);
				//System.out.println("payer="+payer.toString());
				//System.out.println(" before payerDetaills="+payerDetaills.toString());
				payerDetaills.put(mapKey,payer);
				//System.out.println(" AFTER payerDetaills="+payerDetaills.toString());
				//System.out.println(" BEFORE BEAN VALUES="+getPayerDtls().toString());
				setPayerDtls(payerDetaills);
					
				//System.out.println(" after payerDetaills="+getPayerDtls().toString());
				//if (rs1 != null)   rs1.close();
				//if(pstmt1!=null) pstmt1.close();
				if (rs != null)   rs.close();
				if(pstmt!=null) pstmt.close();
					
			}		
		}
		catch(Exception e)
		{
			System.out.println("in PkgApprovalBean.java,Exception while seting db values to bean="+e);
			e.printStackTrace();			
		}
		finally
		{
			if (rs != null)   rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) closeConnection(connection);
		}
	}
	
	public ArrayList getApprvdPkgsList()  throws Exception {
		String apprvd_pkg_seq_no="";
		String apprvd_pkg_code="";
		String apprvd_pkg_desc="";
		String appr_seq_no="";// IN 20964
		//String apprvd_credit_auth_ref="";//unused variable.
		String apprvd_pkg_dtls_yn="";
		String mapKey="";		
		ArrayList payer=new ArrayList();
		//Set<String> 	credit_auth_ref_set;	
		HashMap hdrDtls=new HashMap();
		HashMap authDtls=new HashMap();
		HashMap pkgApprovals=new HashMap();
		ArrayList creditPkgApprovals=new ArrayList();
		ArrayList record=new ArrayList();
		ArrayList pkgApprvRecord=new ArrayList();
		Set<String> PkgDtlsSet;
		ArrayList apprvdPkgsList=new ArrayList();
		Set<String> authDtlsSet;	
		Iterator<String> authIt;
		String authKey="";
		try{
				HashMap payerDtls=(HashMap)getPayerDtls();
				if(payerDtls!=null && payerDtls.size()>0){
					PkgDtlsSet=(Set<String>)payerDtls.keySet();
					//System.out.println("PkgDtlsSet="+PkgDtlsSet.toString());
					Iterator<String> pkgIt=PkgDtlsSet.iterator();
					while(pkgIt.hasNext()){			
						mapKey=pkgIt.next();			
						payer=(ArrayList)payerDtls.get(mapKey);	
						//System.out.println("payer="+payer.toString());	
						//System.out.println("mapKey="+mapKey);				
						if(payer!=null && payer.size()>0){
							hdrDtls=	(HashMap)payer.get(0);
							authDtls=	(HashMap)payer.get(1);
							pkgApprovals=	(HashMap)payer.get(2);
							//System.out.println("authDtls="+authDtls.toString());				
							//System.out.println("pkgApprovals="+pkgApprovals.toString());
							authDtlsSet=(Set<String>)authDtls.keySet();
							//System.out.println("authDtlsSet="+authDtlsSet.toString());
							authIt=authDtlsSet.iterator();							
							if(authDtls!=null && authDtls.size()>0){
								while(authIt.hasNext()){
									record=new ArrayList();
									authKey=(String)authIt.next();
									record=(ArrayList)authDtls.get(authKey);
									appr_seq_no=(String)record.get(0);// IN 20964
									/*apprvd_credit_auth_ref=(String)record.get(0);
									apprvd_pkg_dtls_yn=(String)record.get(4);	*/	//IN 20964			
									apprvd_pkg_dtls_yn=(String)record.get(5);	//IN 20964				
									//System.out.println("apprvd_credit_auth_ref="+apprvd_credit_auth_ref);		
									//System.out.println("apprvd_pkg_dtls_yn="+apprvd_pkg_dtls_yn);						
									if(apprvd_pkg_dtls_yn.equals("Y")){
										creditPkgApprovals=new ArrayList();
										//if(pkgApprovals!=null && pkgApprovals.size()>0 && pkgApprovals.containsKey(apprvd_credit_auth_ref)){//IN 20964
										if(pkgApprovals!=null && pkgApprovals.size()>0 && pkgApprovals.containsKey(appr_seq_no)){//IN 20964
											//creditPkgApprovals=(ArrayList)pkgApprovals.get(apprvd_credit_auth_ref);// individual pkg approvals			//IN 20964		
											creditPkgApprovals=(ArrayList)pkgApprovals.get(appr_seq_no);// individual pkg approvals		//key chnage			
											//System.out.println("creditPkgApprovals="+creditPkgApprovals.toString());	
											if(creditPkgApprovals!=null && creditPkgApprovals.size()>0){
												for(int k=0;k<creditPkgApprovals.size();k++){								
													pkgApprvRecord=new ArrayList();
													pkgApprvRecord=(ArrayList)creditPkgApprovals.get(k);
													apprvd_pkg_seq_no=(String)pkgApprvRecord.get(0);
													apprvd_pkg_code=(String)pkgApprvRecord.get(1);
													apprvd_pkg_desc=(String)pkgApprvRecord.get(2);		
													if(!apprvdPkgsList.contains(""+apprvd_pkg_code+"~~"+apprvd_pkg_desc+"~~"+apprvd_pkg_seq_no)){
														apprvdPkgsList.add(""+apprvd_pkg_code+"~~"+apprvd_pkg_desc+"~~"+apprvd_pkg_seq_no);
													}	
																								
												}
											}
										}
									}								
								}//
							}//						
						}//					
					}//
				}				
			
			}catch(Exception e){
				System.out.println("Exception in getApprvdPkgsList() of PkgApprovalBean.java="+e);
				e.printStackTrace();
			}	
			return		apprvdPkgsList	;
		}
		
		public ArrayList getPayerCopy(ArrayList payer) throws Exception{
			ArrayList payerCopy=new ArrayList();
			try{
					//System.out.println("in getPayerCopy(),payer="+payer.toString());
		ArrayList record=new ArrayList();	
		HashMap hdrDtls=(HashMap)payer.get(0);		
		HashMap authSrc=(HashMap)payer.get(1);
		HashMap authDes=new HashMap();
		Set<String> authDtlsSet=(Set<String>)authSrc.keySet();
		Iterator<String> authIt=authDtlsSet.iterator();
		String authKey="";	
	
		while( authIt.hasNext()){
			record=new ArrayList();		
			authKey=(String)authIt.next();	
			record=(ArrayList)authSrc.get(authKey);
			authDes.put(authKey,(ArrayList)(record.clone()));
		}	

		HashMap pkbApprvSrc=(HashMap)payer.get(2);
		HashMap pkbApprvDes=new HashMap();
		Set<String> pkbApprvSet=(Set<String>)pkbApprvSrc.keySet();
		Iterator<String> pkbApprvIt=pkbApprvSet.iterator();
		String pkbApprvKey="";		
		
		while( pkbApprvIt.hasNext()){
			pkbApprvKey=(String)pkbApprvIt.next();	
			record=new ArrayList();
			record=(ArrayList)pkbApprvSrc.get(pkbApprvKey);
			pkbApprvDes.put(pkbApprvKey,(ArrayList)(record.clone()));
		}	
	
		 payerCopy=new ArrayList();		
		payerCopy.add(0,(HashMap)(hdrDtls.clone()));
		payerCopy.add(1,(HashMap)(authDes.clone()));
		payerCopy.add(2,(HashMap)(pkbApprvDes.clone()));
		//System.out.println("payer="+payer.toString());
		//System.out.println("payerCopy="+payerCopy.toString());
			
				
			}catch(Exception e){
				System.out.println("Exception in PkgApprovalBean.java,getPayerCopy()="+e);
				e.printStackTrace();
			
			}
	
			return payerCopy;
		
		}
		public String getBlPkgYN(String facility_id) throws Exception {
		Connection connection 		= null;		
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		String package_enabled_yn="";
		String sqlStr="";
		try{
			connection = getConnection();	
			sqlStr="SELECT bl_package_enabled_yn(?) package_enabled_yn from dual";
			pstmt=connection.prepareStatement(sqlStr);					
			pstmt.setString(1,facility_id);
			rs							= pstmt.executeQuery();
			while (rs.next()){
				package_enabled_yn = rs.getString("package_enabled_yn");		
				if(package_enabled_yn==null || !package_enabled_yn.equals("Y")) package_enabled_yn="N";		
			}
		}catch(Exception e){
			System.out.println("Exception e="+e);
			e.printStackTrace();
		}
		finally{
					if (rs != null)   rs.close();
					if(pstmt!=null) pstmt.close();
					if(connection!=null) closeConnection(connection);
				}
		return package_enabled_yn;
	}

}

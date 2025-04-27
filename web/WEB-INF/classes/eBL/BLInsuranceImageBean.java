/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved. 
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /**
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           Mohana Priya K
2			V230406								ML-BRU-SCF-2221				   Mohana Priya K
 */
package eBL;

import java.io.*;
import java.util.*;
import java.sql.*;
import eBL.Common.*;
import webbeans.eCommon.*;
import eCommon.Common.CommonAdapter;
import javax.servlet.http.HttpSession;
//import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.fileupload.*;
import javax.servlet.http.HttpServletRequest;
//import org.apache.commons.io.FileUtils;

import com.ehis.persist.PersistenceHelper;

public class BLInsuranceImageBean extends BlAdapter implements Serializable {

	// ADDED FOR GHL_0550_CRF STARTS-->
	public HttpSession session;
	static String changeBlgName = "";
	public HashMap hasInsuranceImageValues = new HashMap();
	HashMap hasInsuranceDBImageValues = new HashMap();
	HashSet unionKeys;
	//private int rowCount; //commented V210416
	boolean siteSpecUploadDocAll = false;

	// ADDED FOR GHL_0550_CRF ENDSS-->

	public BLInsuranceImageBean() {
		System.out.println("Bean Initialized");
	}

	public HashMap validate() throws Exception {
		HashMap map = new HashMap();
		map.put("result", new Boolean(true));
		map.put("message", "success..");
		return map;
	}

	public void insertInsuranceDBvalues(String patientId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		ResultSet rs = null;

		Blob pat_ins_blob = null;
		int rowCount = 0;
		BLInsuranceImage bimg;
		int index;
		String blng_grp_id = "";
		boolean siteSpecUploadDocAll = false;
		System.out.println("enter into insertInsuranceDBvalues");
		try {
			pat_ins_blob = null;
			conn = ConnectionManager.getConnection();//V230406
			siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(
					conn, "BL", "BL_UPLOAD_DOC_ALL");//Added V191028-Aravindh/GHL-CRF-0550
		if (siteSpecUploadDocAll) {
				/*
				 * String sql =
				 * "insert into bl_pat_ins_documents(patient_id,cust_group_code, cust_code, policy_type_code, policy_number, policy_eff_from, policy_eff_to,ins_image) values (?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?)"
				 * ;
				 * 
				 * String sql1 =
				 * "delete from bl_pat_ins_documents where patient_id =?  and  cust_group_code = ?  and cust_code = ?  and policy_type_code = ?  and policy_number = ?  and  policy_eff_from = to_date(?,'dd/mm/yyyy')  and  policy_eff_to =to_date(?,'dd/mm/yyyy')"
				 * ;
				 * 
				 * String sql3 =
				 * "update bl_pat_ins_documents set  ins_image = ?  where patient_id =?  and  cust_group_code = ?  and cust_code = ?  and policy_type_code = ?  and policy_number = ?  and  policy_eff_from = to_date(?,'dd/mm/yyyy')  and  policy_eff_to =to_date(?,'dd/mm/yyyy')"
				 * ;
				 */
			// in sql episode_type, episode_id,visit_id,encounter_id,operating_facility_id Added by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
			String sql = "insert into bl_pat_ins_documents(patient_id,cust_group_code, cust_code, policy_type_code, policy_number, policy_eff_from, policy_eff_to,ins_image,DB_SHAREPATH_FLAG,DOC_FILE_PATH,BLNG_GRP_ID,DOC_TYPE,DOC_REMARKS,CREDIT_AUTH_NO,CREDIT_AUTH_DATE,CONTENT_TYPE,PATIENT_CLASS,EPISODE_TYPE,EPISODE_ID,VISIT_ID,ENCOUNTER_ID,OPERATING_FACILITY_ID) values (?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?)";// GHL-CRF-0550

			String sql1 = "delete from bl_pat_ins_documents where patient_id =?  and rowid = ? ";// GHL-CRF-0550

			String sql3 = "update bl_pat_ins_documents set  ins_image = ?,DB_SHAREPATH_FLAG = ?,DOC_FILE_PATH = ?,DOC_REMARKS = ?,CREDIT_AUTH_NO =?,CREDIT_AUTH_DATE = to_date(?,'dd/mm/yyyy')  where patient_id =? and rowid = ?";//GHL-CRF-0550 palaninarayanan
		  		
			//String sql3 = "update bl_pat_ins_documents set  ins_image = ?,DB_SHAREPATH_FLAG = ?,DOC_FILE_PATH = ?,DOC_REMARKS = ? where patient_id =?  and  NVL(cust_group_code,'X') = ?  and NVL(cust_code,'X') = ?  and NVL(policy_type_code,'X') = ?  and NVL(policy_number,'X') = ?  and rowid = ?";// GHL-CRF-0550

			String sql4 = "select count(*) from  bl_pat_ins_documents   where patient_id =?  and  cust_group_code = ?  and cust_code = ?  and policy_type_code = ?  and policy_number = ?";

			String sql5 = "select BLNG_GRP_ID from BL_BLNG_GRP where SHORT_DESC=?";
			//Added GHL_0550_CRF

			pstmt = conn.prepareStatement(sql);
			pstmt1 = conn.prepareStatement(sql1);
			pstmt2 = conn.prepareStatement(sql3);
			pstmt4 = conn.prepareStatement(sql4);
			pstmt5 = conn.prepareStatement(sql5);

			Object ob[] = (hasInsuranceImageValues.keySet()).toArray();
			Arrays.sort(ob); // Added V190612 DHANANAJAY/IN70646

			for (index = 0; index < ob.length; index++) {
				bimg = (BLInsuranceImage) hasInsuranceImageValues.get(""
						+ ob[index]);

				// ADDED FOR GHL_0550_CRF STARTS-->

				pstmt5.setString(1, bimg.getBillingGroup());
				rs = pstmt5.executeQuery();
				if (rs.next()) {
					blng_grp_id = rs.getString(1);
					bimg.setBillingGroup(blng_grp_id);
				}
				String addOrUpdate = bimg.getClicked_button();
				if (addOrUpdate == null)
					addOrUpdate = "";
				System.out.println(addOrUpdate);

				// ADDED FOR GHL_0550_CRF ENDS-->

				if (bimg != null) {

					pstmt4.setString(1, patientId);
					pstmt4.setString(2, bimg.getPayerGroupCode());
					pstmt4.setString(3, bimg.getPayerCode());
					pstmt4.setString(4, bimg.getPolicyCode());
					pstmt4.setString(5, bimg.getPolicyNo());

					rs = pstmt4.executeQuery();
					if (rs.next()) {
						rowCount = java.lang.Integer.parseInt(rs
								.getString(1));
					}

					if ((rowCount >= 0) && (bimg.getCancelMod() == false)
							&& (addOrUpdate.equals("addBut"))) {
						System.out.println(" Insert Inside+ " + bimg);

						pstmt.setString(1, patientId);
						pstmt.setString(2, bimg.getPayerGroupCode());
						pstmt.setString(3, bimg.getPayerCode());
						pstmt.setString(4, bimg.getPolicyCode());
						pstmt.setString(5, bimg.getPolicyNo());
						pstmt.setString(6, bimg.getStartDate());
						pstmt.setString(7, bimg.getEndDate());

						Integer checkshareOrDB = bimg.getDbSharePathFlag();
						System.out.println(checkshareOrDB);
						if (checkshareOrDB == null) {
							checkshareOrDB = 0;
						}

							System.err.println("checkshareOrDB BLInsuranceImageBean  "+checkshareOrDB);
							System.err.println("Bimg.getImgae BLInsuranceImageBean  "+bimg.getImage());
						if (checkshareOrDB == 0 && bimg.getImage() != null) {
							System.err.println("Bimg.getImgae inside If BLInsuranceImageBean  "+bimg.getImage());
							pstmt.setBinaryStream(
									8,
									new ByteArrayInputStream(bimg
											.getImage()),
									bimg.getImage().length);

						} else {
							pstmt.setNull(8, java.sql.Types.BLOB);
						}
						if (checkshareOrDB == 0)
							pstmt.setInt(9, checkshareOrDB);
						if (checkshareOrDB == 0
								&& bimg.getImageFilePath() != null) {
							pstmt.setString(10, bimg.getImageFilePath());
						} else {
							pstmt.setString(10, null);
						}
						if (bimg.getBillingGroup() != null) {
							pstmt.setString(11, bimg.getBillingGroup()); // 10
						} else {
							pstmt.setString(11, null);
						}

						if (bimg.getDocType() != null) {
							pstmt.setString(12, bimg.getDocType());
						} else {
							pstmt.setString(12, null);
						}
						if (bimg.getDocRemarks() != null) {
							pstmt.setString(13, bimg.getDocRemarks());
						} else {
							pstmt.setString(13, null);
						}
						if (bimg.getCreditAuthNo() != null) {
							pstmt.setString(14, bimg.getCreditAuthNo());
						} else {
							pstmt.setString(14, null);
						}
						if (bimg.getCreditAuthDate() != null) {
							pstmt.setString(15, bimg.getCreditAuthDate());
						} else {
							pstmt.setString(15, null);
						}
						if (bimg.getContentType() != null) {
							pstmt.setString(16, bimg.getContentType());
						} else {
							pstmt.setString(16, null);
						}
						if (bimg.getStrModuleId() != null) {
							pstmt.setString(17, bimg.getStrModuleId());
						} else {
							pstmt.setString(17, "X");
						}

						// Added by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
						if (bimg.getepisodeType() != null) {
							pstmt.setString(18, bimg.getepisodeType());
						} else {
							pstmt.setString(18, null);
						}
						pstmt.setInt(19, bimg.getepisodeId());
						pstmt.setInt(20, bimg.getvisitId());						
						pstmt.setInt(21, bimg.getencounterId());							
						if (bimg.getfacilityId() != null) {
							pstmt.setString(22, bimg.getfacilityId());
						} else {
							pstmt.setString(22, null);
						}
						// Added by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
						System.err.println("bimg.getStrModuleId()====>"+bimg.getStrModuleId());
						System.err.println("checkshareOrDB====>"+checkshareOrDB);
						System.err.println("bimg.getImage()====>"+bimg.getImage());
						if (bimg.getStrModuleId() != null && checkshareOrDB == 0 && bimg.getImage() != null) //Added Against GHL-CRF-0550.1
						pstmt.executeUpdate();
					} else if ((rowCount >= 0)
							&& (bimg.getCancelMod() == true)
							&& (addOrUpdate.equals("Remove"))) {

						System.out.println(" Delete Inside " + bimg);

						pstmt1.setString(1, patientId);
						pstmt1.setString(2, bimg.getRowid());
						pstmt1.executeUpdate();
					} else if (rowCount >= 0
							&& addOrUpdate.equals("updateBut")) {
						System.out.println(" Update Inside " + bimg);

						Integer checkshareOrDB = bimg.getDbSharePathFlag();
						if (checkshareOrDB == null) {
							checkshareOrDB = 0;
						}

						if (checkshareOrDB == 0) {
							pstmt2.setBinaryStream(
									1,
									new ByteArrayInputStream(bimg
											.getImage()),
									bimg.getImage().length);
						} else {
							pstmt2.setNull(1, java.sql.Types.BLOB);
						}
						pstmt2.setInt(2, checkshareOrDB);
						if (checkshareOrDB == 1) {
							pstmt2.setString(3, bimg.getImageFilePath());
						} else {
							pstmt2.setString(3, null);
						}
						if (bimg.getDocRemarks() != null
								&& bimg.getDocRemarks() != "") {
							pstmt2.setString(4, bimg.getDocRemarks());
						} else {
							pstmt2.setString(4, null);
						}

						
						if( bimg.getCreditAuthNo()!=null && bimg.getCreditAuthNo()!=""){
							System.out.println("t"+bimg.getCreditAuthNo());
							pstmt2.setString(5, bimg.getCreditAuthNo());
							}else{
								pstmt2.setString(5,null);
							}
							if(bimg.getCreditAuthDate()!=null&& bimg.getCreditAuthDate()!=""){
								System.out.println("t"+bimg.getCreditAuthNo());
								pstmt2.setString(6, bimg.getCreditAuthDate());
							}else{
								pstmt2.setString(6,null);
							}

						System.out.println(patientId);
						
						pstmt2.setString(7,patientId);
						/*if(bimg.getPayerGroupCode()!=null && bimg.getPayerGroupCode()!=""){
						pstmt2.setString(8,bimg.getPayerGroupCode());
						}
						else{
							pstmt2.setString(8,"X");
						}
						if(bimg.getPayerCode()!=null && bimg.getPayerCode()!=""){
						pstmt2.setString(9,bimg.getPayerCode());
						}
						else
						{
							pstmt2.setString(9,"X");
						}
						if(bimg.getPolicyCode()!=null && bimg.getPolicyCode()!=""){
						pstmt2.setString(10,bimg.getPolicyCode());
						}
						else
						{
							pstmt2.setString(10,"X");
						}
						if(bimg.getPolicyNo()!=null && bimg.getPolicyNo()!=""){
						pstmt2.setString(11,bimg.getPolicyNo());
						}
						else
						{
							pstmt2.setString(11,"X");
						}
						if( bimg.getCreditAuthNo()!=null){
							pstmt.setString(12, bimg.getCreditAuthNo());
							}else{
								pstmt.setString(12,null);
							}
							if(bimg.getCreditAuthDate()!=null){
							pstmt.setString(13, bimg.getCreditAuthDate());
							}else{
								pstmt.setString(13,null);
							}*/

						pstmt2.setString(8,bimg.getRowid());
						System.out.println("t"+bimg.getRowid());
						
						pstmt2.executeUpdate();
				}
			}		 
			}
		}
		//ADDED  FOR  GHL_0550_CRF   ENDS-->
		else{
				pat_ins_blob = null;
				//conn = ConnectionManager.getConnection(); //V230406-ML-BRU-SCF-2221
				String sql = "insert into bl_pat_ins_documents(patient_id,cust_group_code, cust_code, policy_type_code, policy_number, policy_eff_from, policy_eff_to,ins_image,DB_SHAREPATH_FLAG,DOC_FILE_PATH) values (?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?)";

				String sql1 = "delete from bl_pat_ins_documents where patient_id =?  and  cust_group_code = ?  and cust_code = ?  and policy_type_code = ?  and policy_number = ?  ";

				String sql3 = "update bl_pat_ins_documents set  ins_image = ?,DB_SHAREPATH_FLAG = ?,DOC_FILE_PATH = ?  where patient_id =?  and  cust_group_code = ?  and cust_code = ?  and policy_type_code = ?  and policy_number = ?";

				String sql4 = "select count(*) from  bl_pat_ins_documents   where patient_id =?  and  cust_group_code = ?  and cust_code = ?  and policy_type_code = ?  and policy_number = ?";

				pstmt = conn.prepareStatement(sql);
				pstmt1 = conn.prepareStatement(sql1);
				pstmt2 = conn.prepareStatement(sql3);
				pstmt4 = conn.prepareStatement(sql4);

				Object ob[] = (hasInsuranceImageValues.keySet()).toArray();
				Arrays.sort(ob); // Added V190612 DHANANAJAY/IN70646

				for (index = 0; index < ob.length; index++) {
					bimg = (BLInsuranceImage) hasInsuranceImageValues.get(""
							+ ob[index]);
					if (bimg != null) {
						pstmt4.setString(1, patientId);
						pstmt4.setString(2, bimg.getPayerGroupCode());
						pstmt4.setString(3, bimg.getPayerCode());
						pstmt4.setString(4, bimg.getPolicyCode());
						pstmt4.setString(5, bimg.getPolicyNo());

						rs = pstmt4.executeQuery();
						if (rs.next()) {
							rowCount = java.lang.Integer.parseInt(rs.getString(1));
						}
						if ((rowCount == 0) && (bimg.getCancelMod() == false)) {
							System.out.println("Insert Inside"+bimg);
							pstmt.setString(1, patientId);
							pstmt.setString(2, bimg.getPayerGroupCode());
							pstmt.setString(3, bimg.getPayerCode());
							pstmt.setString(4, bimg.getPolicyCode());
							pstmt.setString(5, bimg.getPolicyNo());
							pstmt.setString(6, bimg.getStartDate());
							pstmt.setString(7, bimg.getEndDate());

							Integer checkshareOrDB = bimg.getDbSharePathFlag();
							if (checkshareOrDB == null) {
								checkshareOrDB = 0;
							}

							if (checkshareOrDB == 0 ) {
								pstmt.setBinaryStream(
										8,
										new ByteArrayInputStream(bimg
												.getImage()),
										bimg.getImage().length);
							} else {
								pstmt.setNull(8, java.sql.Types.BLOB);
							}
							pstmt.setInt(9, checkshareOrDB);
							if (checkshareOrDB == 1) {
								pstmt.setString(10, bimg.getImageFilePath());
							} else {
								pstmt.setString(10, null);
							}
							pstmt.executeUpdate();
						} else if ((rowCount > 0)
								&& (bimg.getCancelMod() == true)) {

							System.err.println(" Delete Inside " + bimg);
							pstmt1.setString(1, patientId);
							pstmt1.setString(2, bimg.getPayerGroupCode());
							pstmt1.setString(3, bimg.getPayerCode());
							pstmt1.setString(4, bimg.getPolicyCode());
							pstmt1.setString(5, bimg.getPolicyNo());
							// pstmt1.setString(6,bimg.getStartDate());
							// pstmt1.setString(7,bimg.getEndDate());
							pstmt1.executeUpdate();
						} else if (rowCount > 0) {
							System.err.println("Update Inside"+bimg);
							Integer checkshareOrDB = bimg.getDbSharePathFlag();
							if (checkshareOrDB == null) {
								checkshareOrDB = 0;
							}

							if (checkshareOrDB == 0) {
								pstmt2.setBinaryStream(
										1,
										new ByteArrayInputStream(bimg
												.getImage()),
										bimg.getImage().length);
							} else {
								pstmt2.setNull(1, java.sql.Types.BLOB);
							}
							pstmt2.setInt(2, checkshareOrDB);
							if (checkshareOrDB == 1) {
								pstmt2.setString(3, bimg.getImageFilePath());
							} else {
								pstmt2.setString(3, null);
							}
							pstmt2.setString(4, patientId);
							pstmt2.setString(5, bimg.getPayerGroupCode());
							pstmt2.setString(6, bimg.getPayerCode());
							pstmt2.setString(7, bimg.getPolicyCode());
							pstmt2.setString(8, bimg.getPolicyNo());
							// pstmt2.setString(7,bimg.getStartDate());
							// pstmt2.setString(8,bimg.getEndDate());
							pstmt2.executeUpdate();
						}
					}
				}
			}
		} catch (Exception ee) {
			System.out.println("Exception  " + ee);
			ee.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null) {
					pstmt.close();
				}
				if (pstmt1 != null) {
					pstmt1.close();
				}
				if (pstmt2 != null) {
					pstmt2.close();
				}
				if (pstmt4 != null) {
					pstmt4.close();
				}
				if (pstmt5 != null) {
					pstmt5.close();
				}
				if (conn != null) {
					conn.commit();
					ConnectionManager.returnConnection(conn);
				}
				hasInsuranceImageValues.clear();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//ADDED  FOR  GHL_0550_CRF   STARTS-->

public void loadInsuranceDBvalues(String patientId,String strModuleId,String patView,String strepisodeid,String strvisit_id)
	{	
		Connection conn = null;
		

		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		String sql ="";
		String sql1 ="";
		String sql2 ="";
		String sql3 ="";
		ResultSet res = null;
		ResultSet res1 = null;
		ResultSet res2 = null;
		Blob pat_ins_blob;
		int rowCount = 0;
		BLInsuranceImage bimg;
	//	boolean flage = true; //commented V210416
	//	byte[] pat_ins_bytes; //commented V210416
		String smtind = "";
		//Added for GHL-0550
		
		if(strvisit_id==null)
		strvisit_id="";		
		
		//String blng_grp_id = null; //commented V210416
		String bl_grp_name = "";
		try {
			conn = ConnectionManager.getConnection();//V230406
		if(patView.equals("N"))
		{
				sql2 = "select short_desc from bl_blng_grp a,bl_pat_ins_documents b where a.blng_grp_id= b.blng_grp_id  and patient_id = ? ";
				sql1 = "select settlement_ind from bl_blng_grp where blng_grp_id=(select  blng_grp_id from bl_pat_ins_documents where patient_id =? and  rownum=1)";
			if (!strModuleId.equals("MP")) {
				sql="SELECT a.cust_group_code, a.cust_code, a.policy_type_code, a.policy_number, TO_CHAR (a.policy_eff_from, 'dd/mm/yyyy'),TO_CHAR (a.policy_eff_to, 'dd/mm/yyyy'), a.ins_image,NVL (a.db_sharepath_flag, 0) db_sharepath_flag, a.doc_file_path,a.blng_grp_id, a.doc_type, a.doc_remarks, a.credit_auth_no,TO_CHAR (a.credit_auth_date, 'dd/mm/yyyy'),b.short_desc,a.rowid  FROM bl_pat_ins_documents a , bl_blng_grp b WHERE  a.blng_grp_id= b.blng_grp_id  and a.patient_id = ? and a.patient_class=? ";
			} else {
				sql = "SELECT a.cust_group_code, a.cust_code, a.policy_type_code, a.policy_number, TO_CHAR (a.policy_eff_from, 'dd/mm/yyyy'),TO_CHAR (a.policy_eff_to, 'dd/mm/yyyy'), a.ins_image,NVL (a.db_sharepath_flag, 0) db_sharepath_flag, a.doc_file_path,a.blng_grp_id, a.doc_type, a.doc_remarks, a.credit_auth_no,TO_CHAR (a.credit_auth_date, 'dd/mm/yyyy'),b.short_desc,a.rowid  FROM bl_pat_ins_documents a , bl_blng_grp b WHERE  a.blng_grp_id= b.blng_grp_id  and a.patient_id = ?";
			}
			// Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes - END--->
			pstmt = conn.prepareStatement(sql);
			pstmt1 = conn.prepareStatement(sql1);
			pstmt2 = conn.prepareStatement(sql2);
			pstmt1.setString(1, patientId);
			pstmt2.setString(1, patientId);
			if (!strModuleId.equals("MP")) {
				pstmt.setString(1, patientId);
				pstmt.setString(2, strModuleId);
			} else {
				pstmt.setString(1, patientId);
			}
			res1 = pstmt1.executeQuery();
			res2 = pstmt2.executeQuery();
			while (res1.next()) {
				smtind = res1.getString(1);
			}
			while (res2.next()) {
				bl_grp_name = res2.getString(1);
			}
			res = pstmt.executeQuery();
		}
		else
		{
		//9994 start
			if((!strepisodeid.equals(""))&&(!strvisit_id.equals("")))
			{
				sql3="SELECT a.cust_group_code, a.cust_code, a.policy_type_code, a.policy_number, TO_CHAR (a.policy_eff_from, 'dd/mm/yyyy'),TO_CHAR (a.policy_eff_to, 'dd/mm/yyyy'), a.ins_image,NVL (a.db_sharepath_flag, 0) db_sharepath_flag, a.doc_file_path,a.blng_grp_id, a.doc_type, a.doc_remarks, a.credit_auth_no,TO_CHAR (a.credit_auth_date, 'dd/mm/yyyy'),b.short_desc,a.rowid  FROM bl_pat_ins_documents a , bl_blng_grp b WHERE  a.blng_grp_id= b.blng_grp_id  and a.patient_id = ? and a.episode_id = ? and a.visit_id = ?";
				pstmt3=conn.prepareStatement(sql3);
				pstmt3.setString(1,patientId);
				pstmt3.setString(2,strepisodeid);
				pstmt3.setString(3,strvisit_id);
				res =  pstmt3.executeQuery();
			}
			else if((!strepisodeid.equals(""))&&(strvisit_id.equals("")))
			{
				sql3="SELECT a.cust_group_code, a.cust_code, a.policy_type_code, a.policy_number, TO_CHAR (a.policy_eff_from, 'dd/mm/yyyy'),TO_CHAR (a.policy_eff_to, 'dd/mm/yyyy'), a.ins_image,NVL (a.db_sharepath_flag, 0) db_sharepath_flag, a.doc_file_path,a.blng_grp_id, a.doc_type, a.doc_remarks, a.credit_auth_no,TO_CHAR (a.credit_auth_date, 'dd/mm/yyyy'),b.short_desc,a.rowid  FROM bl_pat_ins_documents a , bl_blng_grp b WHERE  a.blng_grp_id= b.blng_grp_id  and a.patient_id = ? and a.episode_id = ?";
				pstmt3=conn.prepareStatement(sql3);
				pstmt3.setString(1,patientId);
				pstmt3.setString(2,strepisodeid);
				res =  pstmt3.executeQuery();
			}
			else 
			{
				sql3="SELECT a.cust_group_code, a.cust_code, a.policy_type_code, a.policy_number, TO_CHAR (a.policy_eff_from, 'dd/mm/yyyy'),TO_CHAR (a.policy_eff_to, 'dd/mm/yyyy'), a.ins_image,NVL (a.db_sharepath_flag, 0) db_sharepath_flag, a.doc_file_path,a.blng_grp_id, a.doc_type, a.doc_remarks, a.credit_auth_no,TO_CHAR (a.credit_auth_date, 'dd/mm/yyyy'),b.short_desc,a.rowid  FROM bl_pat_ins_documents a , bl_blng_grp b WHERE  a.blng_grp_id= b.blng_grp_id  and a.patient_id = ?";
				pstmt3=conn.prepareStatement(sql3);
				pstmt3.setString(1,patientId);
				res =  pstmt3.executeQuery();
			}
		}
		//9994 end
		// Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes - END--->
		
	while(res!=null && res.next()) {				
		bimg = new BLInsuranceImage();
		bimg.setPayerGroupCode(checkNull(res.getString(1)));
		bimg.setPayerCode(checkNull(res.getString(2)));
		bimg.setPolicyCode(checkNull(res.getString(3)));
		bimg.setPolicyNo(checkNull(res.getString(4)));
		bimg.setStartDate(checkNull(res.getString(5)));
		bimg.setEndDate(checkNull(res.getString(6)));
		//pat_ins_blob = res.getBlob(7);
		pat_ins_blob = res.getBlob(7);
		//pat_ins_bytes =res.getBytes(7);
		
		Integer checkshareOrDB=res.getInt(8);
		if(checkshareOrDB==null || checkshareOrDB==0){			
			if(pat_ins_blob!=null)
			{
				System.out.println("enter image test1");
				InputStream in = pat_ins_blob.getBinaryStream();
				int len = (int)pat_ins_blob.length();				
				
				byte[] by = new byte[(int) len];
				//by=	pat_ins_blob.getBytes(1, len);
				
				//by=pat_ins_blob.getBytes(1, len);
				in.read(by, 0, (int) len);
				bimg.setImage(by);
				//bimg.setBlobData(pat_ins_blob);
				//bimg.setBlobdata(pat_ins_blob);
			}		
		} else if(checkshareOrDB==1){
			String filePath=res.getString(9);
			if(filePath!=null && !filePath.equals("")){
				bimg.setImage(BLHelper.imagePathToBytes(filePath));
			}
		}
			bimg.setDbMod(true);
			//bimg.setBillingGroup(res.getString(10));		
			//blng_grp_id=res.getString(10);
			bimg.setDocType(checkNull(res.getString(11)));
			bimg.setDocRemarks(checkNull(res.getString(12)));
			bimg.setCreditAuthNo(checkNull(res.getString(13)));
			bimg.setCreditAuthDate(checkNull(res.getString(14)));
			bimg.setBillingGroup(checkNull(res.getString(15)));
			bimg.setRowid(checkNull(res.getString(16)));
		
		//if(blng_grp_id.equals("CASH"))
		/*if(smtind.equals("C"))
		{*/
			
		// Added 03-feb-20 palaniNarayanan/GHL-CRF-0550 changes - START--->
		
			if(rowCount==0)
				hasInsuranceImageValues.put(""+bimg.getIndex_cash(),bimg);
			else
				hasInsuranceImageValues.put(""+bimg.getIndex_cash()+rowCount,bimg);
			System.out.println("load Insurance database...mindex... "+bimg.getIndex_cash()+rowCount);
			rowCount++;
		
			// Added 03-feb-20 palaniNarayanan/GHL-CRF-0550 changes - END--->
			
			/*}
		else if(smtind.equals("X"))
		{
		
			System.out.println("index value "+bimg.getIndex());	
			if(rowCount==0)
				hasInsuranceImageValues.put(""+bimg.getIndex(),bimg);
			else
				hasInsuranceImageValues.put(""+bimg.getIndex()+rowCount,bimg);
				System.out.println("load Insurance database...mindex... "+bimg.getIndex()+rowCount);
				rowCount++;
		}
		*/
		}
			hasInsuranceDBImageValues.putAll(hasInsuranceImageValues);		
		}		
		catch(Exception ee)
		{
			System.out.println("Exception loadInsuranceDBvalues "+ee);
			ee.printStackTrace();
		}
		finally
		{
			try {
				if (res != null){
					res.close();
					}
				if (pstmt != null){
					pstmt.close();
					}
				if (pstmt1 != null){
					pstmt1.close(); //Added for V210416
				}
				if (pstmt2 != null) {
					pstmt2.close(); //Added for V210416
				}
				if (conn != null){
					ConnectionManager.returnConnection(conn);
					}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//ADDED  FOR  GHL_0550_CRF   ENDS-->

public void loadInsuranceDBvalues(String patientId)
{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	Blob pat_ins_blob ;
	int rowCount=0;
	BLInsuranceImage bimg;
	
	try
		{
			System.out.println("LoadInsuranceDbvalues getting called  patientId "+patientId);

			String sql = "SELECT CUST_GROUP_CODE, CUST_CODE, POLICY_TYPE_CODE, POLICY_NUMBER, to_char(POLICY_EFF_FROM,'dd/mm/yyyy'), to_char(POLICY_EFF_TO,'dd/mm/yyyy'),INS_IMAGE,NVL(DB_SHAREPATH_FLAG,0) DB_SHAREPATH_FLAG,DOC_FILE_PATH	FROM BL_PAT_INS_DOCUMENTS  WHERE PATIENT_ID = ?  ";
			conn=ConnectionManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,patientId);
			res =  pstmt.executeQuery();
	
		 while(res!=null && res.next()) {				
			bimg = new BLInsuranceImage();
			bimg.setPayerGroupCode(checkNull(res.getString(1)));
			bimg.setPayerCode(checkNull(res.getString(2)));
			bimg.setPolicyCode(checkNull(res.getString(3)));
			bimg.setPolicyNo(checkNull(res.getString(4)));
			bimg.setStartDate(checkNull(res.getString(5)));
			bimg.setEndDate(checkNull(res.getString(6)));
			pat_ins_blob = res.getBlob(7);

			Integer checkshareOrDB=res.getInt(8);
			if(checkshareOrDB==null || checkshareOrDB==0){				
				InputStream in = pat_ins_blob.getBinaryStream();
				long len = pat_ins_blob.length();
				byte[] by = new byte[(int) len];
				in.read(by, 0, (int) len);
				bimg.setImage(by);
			} else if(checkshareOrDB==1){
				String filePath=res.getString(9);
				if(filePath!=null && !filePath.equals("")){
					bimg.setImage(BLHelper.imagePathToBytes(filePath));
				}
			}
			bimg.setDbMod(true);	
			System.out.println("index value "+bimg.getIndex());		
			hasInsuranceImageValues.put(""+bimg.getIndex(),bimg);
			rowCount++;
			}	
		}
		catch(Exception ee)
		{
			System.out.println("Exception loadInsuranceDBvalues "+ee);
			ee.printStackTrace();
		}
		finally
		{
			try {
				if (res != null) {
					res.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					ConnectionManager.returnConnection(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// ADDED FOR GHL_0550_CRF STARTS-->

	public void loadInsuranceDBImage(String PATIENT_ID, String CUST_GROUP_CODE,
			String CUST_CODE, String POLICY_TYPE_CODE, String POLICY_NUMBER,
			String START_DATE, String END_DATE, String billingGroup,
			String creditAuthRef, String creditAuthDate) {
		Connection conn = null;
		

		PreparedStatement pstmt = null;
		ResultSet res = null;
		PreparedStatement pstmt1 = null;
		ResultSet res1 = null;
		String smtind = "";
		Blob pat_ins_blob;
		//int rowCount = 0; //commented V210416
		BLInsuranceImage bimg;

		try {
			conn = ConnectionManager.getConnection();//V230406
			siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(
					conn, "BL", "BL_UPLOAD_DOC_ALL");// Added V191028-Aravindh/GHL-CRF-0550
			if (siteSpecUploadDocAll) {
				String sql1 = "select SETTLEMENT_IND from BL_BLNG_GRP where SHORT_DESC='"
						+ billingGroup + "'";
				pstmt1 = conn.prepareStatement(sql1);

				res1 = pstmt1.executeQuery();
				while (res1.next()) {
					smtind = res1.getString(1);
				}
				System.err.println("loadInsuranceDBImage" + ":" + PATIENT_ID
						+ ":" + CUST_GROUP_CODE + ":" + CUST_CODE + ":"
						+ POLICY_TYPE_CODE + ":" + POLICY_NUMBER);

				String sql = "SELECT INS_IMAGE,NVL(DB_SHAREPATH_FLAG,0) DB_SHAREPATH_FLAG,DOC_FILE_PATH  FROM BL_PAT_INS_DOCUMENTS WHERE PATIENT_ID = ? and CUST_GROUP_CODE = ? and CUST_CODE = ? and POLICY_TYPE_CODE = ?  and POLICY_NUMBER = ?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, PATIENT_ID);
				pstmt.setString(2, CUST_GROUP_CODE);
				pstmt.setString(3, CUST_CODE);
				pstmt.setString(4, POLICY_TYPE_CODE);
				pstmt.setString(5, POLICY_NUMBER);

				bimg = new BLInsuranceImage();
				bimg.setPayerGroupCode(checkNull(CUST_GROUP_CODE));
				bimg.setPayerCode(checkNull(CUST_CODE));
				bimg.setPolicyCode(checkNull(POLICY_TYPE_CODE));
				bimg.setPolicyNo(checkNull(POLICY_NUMBER));
				bimg.setStartDate(checkNull(START_DATE));
				bimg.setEndDate(checkNull(END_DATE));
				bimg.setBillingGroup(checkNull(billingGroup));//Added V191118-Aravindh/GHL-CRF-0550
				bimg.setCreditAuthNo(checkNull(creditAuthRef));
				bimg.setCreditAuthDate(checkNull(creditAuthDate));
				res = pstmt.executeQuery();

				while (res != null && res.next()) {
					pat_ins_blob = res.getBlob(1);
					System.err.println("pat_ins_blob  "+pat_ins_blob);
					Integer checkshareOrDB = res.getInt(2);
					if (checkshareOrDB == null || checkshareOrDB == 0) {
						InputStream in = pat_ins_blob.getBinaryStream();
						long len = pat_ins_blob.length();
						byte[] by = new byte[(int) len];
						in.read(by, 0, (int) len);
						bimg.setImage(by);
					} else if (checkshareOrDB == 1) {
						String filePath = res.getString(3);
						if (filePath != null && !filePath.equals("")) {
							bimg.setImage(BLHelper.imagePathToBytes(filePath));
						}
					}
					bimg.setDbMod(true);
					System.out.println("index value " + bimg.getIndex());
				}
				hasInsuranceImageValues.put("" + bimg.getIndex_cash(), bimg);
			}
		}
		catch (Exception ee) {
			System.out.println("Exception loadInsuranceDBvalues " + ee);
			ee.printStackTrace();
		} finally {
			try {
					if (res != null) {
						res.close();
					}
					if (res1 != null) {
						res1.close();
					}
				/*	if (res2 != null) {
						res2.close();
					} */
					if (pstmt != null) {
						pstmt.close();
					}
					if (pstmt1 != null) {
						pstmt1.close();
					}
					if (conn != null) {
						ConnectionManager.returnConnection(conn);
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// ADDED FOR GHL_0550_CRF ENDS-->
	public void loadInsuranceDBImage(String PATIENT_ID, String CUST_GROUP_CODE,
			String CUST_CODE, String POLICY_TYPE_CODE, String POLICY_NUMBER,
			String START_DATE, String END_DATE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		Blob pat_ins_blob;
	//	int rowCount = 0;//commented V210416
		BLInsuranceImage bimg;

		try {

			System.out.println("loadInsuranceDBImage" + ":" + PATIENT_ID + ":"
					+ CUST_GROUP_CODE + ":" + CUST_CODE + ":"
					+ POLICY_TYPE_CODE + ":" + POLICY_NUMBER);

			String sql = "SELECT INS_IMAGE,NVL(DB_SHAREPATH_FLAG,0) DB_SHAREPATH_FLAG,DOC_FILE_PATH  FROM BL_PAT_INS_DOCUMENTS WHERE PATIENT_ID = ? and CUST_GROUP_CODE = ? and CUST_CODE = ? and POLICY_TYPE_CODE = ?  and POLICY_NUMBER = ?";
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, PATIENT_ID);
			pstmt.setString(2, CUST_GROUP_CODE);
			pstmt.setString(3, CUST_CODE);
			pstmt.setString(4, POLICY_TYPE_CODE);
			pstmt.setString(5, POLICY_NUMBER);

			bimg = new BLInsuranceImage();
			bimg.setPayerGroupCode(checkNull(CUST_GROUP_CODE));
			bimg.setPayerCode(checkNull(CUST_CODE));
			bimg.setPolicyCode(checkNull(POLICY_TYPE_CODE));
			bimg.setPolicyNo(checkNull(POLICY_NUMBER));
			bimg.setStartDate(checkNull(START_DATE));
			bimg.setEndDate(checkNull(END_DATE));
			res = pstmt.executeQuery();

			while (res != null && res.next()) {
				pat_ins_blob = res.getBlob(1);

				Integer checkshareOrDB = res.getInt(2);
				if (checkshareOrDB == null || checkshareOrDB == 0) {
					InputStream in = pat_ins_blob.getBinaryStream();
					long len = pat_ins_blob.length();
					byte[] by = new byte[(int) len];
					in.read(by, 0, (int) len);
					bimg.setImage(by);
				} else if (checkshareOrDB == 1) {
					String filePath = res.getString(3);
					if (filePath != null && !filePath.equals("")) {
						bimg.setImage(BLHelper.imagePathToBytes(filePath));
					}
				}
				bimg.setDbMod(true);
				System.out.println("index value " + bimg.getIndex());
			}
			hasInsuranceImageValues.put("" + bimg.getIndex(), bimg);
		} catch (Exception ee) {
			System.out.println("Exception loadInsuranceDBvalues " + ee);
			ee.printStackTrace();
		} finally {
			try {
					if (res != null) {
						res.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						ConnectionManager.returnConnection(conn);
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	boolean compareInsObject(BLInsuranceImage obj) {
		int index;
		BLInsuranceImage blInsuranceImage;
		for (index = 0; index < hasInsuranceImageValues.size(); index++) {
			blInsuranceImage = (BLInsuranceImage) hasInsuranceImageValues
					.get("" + index);
			if (blInsuranceImage.getPayerGroupCode().equals(
					obj.getPayerGroupCode())
					&& blInsuranceImage.getPayerCode().equals(
							obj.getPayerCode())
					&& blInsuranceImage.getPolicyCode().equals(
							obj.getPolicyCode())
					&& blInsuranceImage.getPolicyNo().equals(obj.getPolicyNo())
					&& blInsuranceImage.getStartDate().equals(
							obj.getStartDate())
					&& blInsuranceImage.getEndDate().equals(obj.getEndDate()))
				return true;
		}
		return false;
	}

	public boolean setInsuranceValues(String payerGroupCode,String payerCode,String policyCode,String policyNo,String startDate,String endDate, String billingGroup,String creditAuthRef,String creditAuthDate)
		{

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String smtind = "";
		String index = "";
		BLInsuranceImage bimg = new BLInsuranceImage();
		bimg.setPayerGroupCode(checkNull(payerGroupCode));
		bimg.setPayerCode(checkNull(payerCode));
		bimg.setPolicyCode(checkNull(policyCode));
		bimg.setPolicyNo(checkNull(policyNo));
		bimg.setStartDate(checkNull(startDate));
		bimg.setEndDate(checkNull(endDate));
		bimg.setBillingGroup(checkNull(billingGroup));// Added
														// V191114-Aravindh/GHL-CRF-0550
		bimg.setCreditAuthNo(checkNull(creditAuthRef));
		bimg.setCreditAuthDate(checkNull(creditAuthDate));
		bimg.setClicked_button("addBut");

		try {
			conn = ConnectionManager.getConnection();
			String sql = "select SETTLEMENT_IND from BL_BLNG_GRP where SHORT_DESC='"
					+ billingGroup + "'";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				smtind = rs.getString(1);
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.commit();
					ConnectionManager.returnConnection(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		/*index = "" + payerGroupCode + payerCode + policyCode + policyNo
				+ startDate + endDate//existing code.. palani changed as ^^^111

		if (hasInsuranceImageValues.containsKey("" + index) == false) {
			hasInsuranceImageValues.put("" + index, bimg);
		}*/
		if(smtind.equals("X"))
		index = policyNo+"_0"; // Added GHL-CRF-0550.1
		else	//Other Billing Group
		index = "^^^1110"; 
		System.err.println("Index before hasInsuranceDBImageValues.put,00000000===>"+index);
		if (hasInsuranceImageValues.containsKey(""+index) == false) {
			hasInsuranceImageValues.put(""+index, bimg); //May 12 2020
			System.err.println("....clicked button" + bimg.getClicked_button());
		}		
		System.err.println("testing..1.." + hasInsuranceImageValues.size());
		return true;
	}

	public void setInsuranceValues(String payerGroupCode, String payerCode,
			String policyCode, String policyNo, String startDate, String endDate) {

		String index;
		BLInsuranceImage bimg = new BLInsuranceImage();
		bimg.setPayerGroupCode(checkNull(payerGroupCode));
		bimg.setPayerCode(checkNull(payerCode));
		bimg.setPolicyCode(checkNull(policyCode));
		bimg.setPolicyNo(checkNull(policyNo));
		bimg.setStartDate(checkNull(startDate));
		bimg.setEndDate(checkNull(endDate));

		index = "" + payerGroupCode + payerCode + policyCode + policyNo
				+ startDate + endDate;

		if (hasInsuranceImageValues.containsKey("" + index) == false) {
			hasInsuranceImageValues.put("" + index, bimg);
		}
	}

	// ADDED FOR GHL_0550_CRF STARTS-->

	public void cancelItem_ghl(String index) {

		System.err.println("BLInsuranceImageBean    cancelItem = " + index);
		System.err.println("BLInsuranceImageBean   before size "
				+ hasInsuranceImageValues.size());
		BLInsuranceImage blInsuranceImage;
		if (hasInsuranceImageValues.containsKey("" + index)) {
			System.err.println("BLInsuranceImageBean    cancelItem = inside ");
			blInsuranceImage = (BLInsuranceImage) hasInsuranceImageValues
					.get("" + index);
			blInsuranceImage.setCancelMod(true);
			blInsuranceImage.setClicked_button("Remove");
			System.err.println("rowid==>>" + blInsuranceImage.getRowid());
			hasInsuranceImageValues.put("" + index, blInsuranceImage);
		}
		System.err.println("BLInsuranceImageBean   after size "
				+ hasInsuranceImageValues.size());
	}

	public void cancelItem(String index) {
		System.out.println("BLInsuranceImageBean    cancelItem = " + index);
		System.out.println("BLInsuranceImageBean   before size "
				+ hasInsuranceImageValues.size());
		BLInsuranceImage blInsuranceImage;
		if (hasInsuranceImageValues.containsKey("" + index)) {
			System.out.println("BLInsuranceImageBean    cancelItem = inside ");
			blInsuranceImage = (BLInsuranceImage) hasInsuranceImageValues
					.get("" + index);
			blInsuranceImage.setCancelMod(true);
			hasInsuranceImageValues.put("" + index, blInsuranceImage);
		}
		System.out.println("BLInsuranceImageBean   after size "
				+ hasInsuranceImageValues.size());
	}

	public int getSize() {
		return hasInsuranceImageValues.size();
	}

	//Added by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020 for episodeType, episodeId, visitId, encounterId, facilityId
	public void setInsuranceValidation(String blngGrpCode,
			String payerGroupCode, String payerCode, String policyCode,
			String policyNo, String startDate, String endDate, FileItem img,
			String strCancel, String docType, String docRemarks,
			String creditAuthDate, String creditAuthNo, String index,
			String clicked_button, String strModuleId, String episodeType,
			int encounterId, int episodeId, int visitId, String facilityId)
			throws IOException {
		BLInsuranceImage bimg = new BLInsuranceImage();
		boolean stCancel = false;

		if (strCancel.equals("Y"))
			stCancel = true;
		if (hasInsuranceImageValues.containsKey("" + index)) {
			

			bimg = (BLInsuranceImage) hasInsuranceImageValues.get("" + index);
			bimg.setBillingGroup(checkNull(blngGrpCode));
			bimg.setPayerGroupCode(checkNull(payerGroupCode));
			bimg.setPayerCode(checkNull(payerCode));
			bimg.setPolicyCode(checkNull(policyCode));
			bimg.setPolicyNo(checkNull(policyNo));
			bimg.setStartDate(checkNull(startDate));
			bimg.setEndDate(checkNull(endDate));

			if (img != null)
				bimg.setImage(img.get());
			bimg.setImageFilePath(img.getName());
			bimg.setCancelMod(stCancel);

			bimg.setDocType(checkNull(docType));
			bimg.setDocRemarks(checkNull(docRemarks));
			bimg.setCreditAuthDate(checkNull(creditAuthDate));
			bimg.setCreditAuthNo(checkNull(creditAuthNo));
			bimg.setContentType(checkNull(img.getContentType()));

			bimg.setmIndex(checkNull("" + index));
			bimg.setClicked_button(checkNull(clicked_button));
			bimg.setRowid(bimg.getRowid());
			System.out.println("818 rowid===>>" + bimg.getRowid());
			System.out.println("setValue Here 1" + payerGroupCode + "  "
					+ payerCode + " " + clicked_button);
		} else {
			bimg = new BLInsuranceImage();
			bimg.setBillingGroup(checkNull(blngGrpCode));
			bimg.setPayerGroupCode(checkNull(payerGroupCode));
			bimg.setPayerCode(checkNull(payerCode));
			bimg.setPolicyCode(checkNull(policyCode));
			bimg.setPolicyNo(checkNull(policyNo));
			bimg.setStartDate(checkNull(startDate));
			bimg.setEndDate(checkNull(endDate));

			bimg.setDbMod(false);
			bimg.setImage(img.get());
			bimg.setImageFilePath(img.getName());
			System.out.println(">>>>>>>" + img.getName());

			bimg.setCancelMod(stCancel);

			bimg.setDocType(checkNull(docType));
			bimg.setDocRemarks(checkNull(docRemarks));
			bimg.setCreditAuthDate(checkNull(creditAuthDate));
			bimg.setCreditAuthNo(checkNull(creditAuthNo));
			bimg.setmIndex(checkNull("" + index));
			//bimg.setmIndex(checkNull(""+checkrow+""+index));//12-May-20
			//System.out.println(">>>>>>>"+""+checkrow+""+index);
			bimg.setClicked_button(checkNull(clicked_button));
			bimg.setStrModuleId(checkNull(strModuleId));

			bimg.setContentType(checkNull(img.getContentType()));
			// Added by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
			bimg.setepisodeType(checkNull(episodeType));
			bimg.setencounterId(encounterId);
			bimg.setepisodeId(episodeId);
			bimg.setvisitId(visitId);
			bimg.setfacilityId(facilityId);

			System.err.println("shikha in setbean 1051=" + episodeType + "="
					+ encounterId + "=" + episodeId + "=" + visitId + "="
					+ facilityId);
			// Added by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
		}
		//if (hasInsuranceImageValues.containsKey(index) == false) {
			hasInsuranceImageValues.put(index, bimg); //May 12 2020
			System.err.println("..bean..clicked button   " + bimg.getClicked_button());
		//}
	}

	public void setInsuranceValidation(String payerGroupCode, String payerCode,
			String policyCode, String policyNo, String startDate,
			String endDate, FileItem img, String strCancel, String index) {
		BLInsuranceImage bimg = new BLInsuranceImage();
		boolean stCancel = false;

		if (strCancel.equals("Y"))
			stCancel = true;

		if (hasInsuranceImageValues.containsKey("" + index)) {
			bimg = (BLInsuranceImage) hasInsuranceImageValues.get("" + index);
			bimg.setPayerGroupCode(checkNull(payerGroupCode));
			bimg.setPayerCode(checkNull(payerCode));
			bimg.setPolicyCode(checkNull(policyCode));
			bimg.setPolicyNo(checkNull(policyNo));
			bimg.setStartDate(checkNull(startDate));
			bimg.setEndDate(checkNull(endDate));
			bimg.setCancelMod(stCancel);
			if (img != null)
				bimg.setImage(img.get());
			System.out.println("setValue Here 1" + payerGroupCode + "  "
					+ payerCode);
		} else {
			bimg = new BLInsuranceImage();
			bimg.setPayerGroupCode(checkNull(payerGroupCode));
			bimg.setPayerCode(checkNull(payerCode));
			bimg.setPolicyCode(checkNull(policyCode));
			bimg.setPolicyNo(checkNull(policyNo));
			bimg.setStartDate(checkNull(startDate));
			bimg.setEndDate(checkNull(endDate));
			bimg.setCancelMod(stCancel);
			bimg.setDbMod(false);
			bimg.setImage(img.get());
			System.out.println("setValue Here" + payerGroupCode + "  "
					+ payerCode);
		}
		hasInsuranceImageValues.put("" + index, bimg);
	}

	public void setInsuranceImage(String index, FileItem img) {
		BLInsuranceImage bimg;
		if (hasInsuranceImageValues.containsKey(index)) {
			bimg = (BLInsuranceImage) hasInsuranceImageValues.get("" + index);
			bimg.setImage(img.get());
			System.out.println("setValue Here 1");
		} else {
			bimg = new BLInsuranceImage();
			bimg.setImage(img.get());
			System.out.println("setValue Here ");
		}
		hasInsuranceImageValues.put("" + index, bimg);
		System.out.println("Image Loaded");
	}

	public HashMap getInsuranceImageValues() {
		return hasInsuranceImageValues;
	}

	/* Karthik added the below code to handle Session Record retain */

	public void setInsuranceImageValues(HashMap hasInsuranceImageValues) {
		this.hasInsuranceImageValues = hasInsuranceImageValues;
	}

	public void deleteInsuranceImageRecord(String key) {
		this.hasInsuranceImageValues.remove(key);
	}

	/* Karthik added the below code to handle Session Record retain */

	public void clearBean() {
		if (hasInsuranceImageValues != null) {
			hasInsuranceImageValues.clear();
		} else {
			hasInsuranceImageValues = new java.util.HashMap();
		}
	}
	
	public void clearBean_changeBlg()
	{
		if( hasInsuranceImageValues != null )
	 	{
	 		hasInsuranceImageValues.clear();
	 	}
			}

	public String checkNull(String inputString) {
		if (inputString == null || inputString.equals("")
				|| inputString.equalsIgnoreCase("null"))
			inputString = "";
		return inputString;
	}
}
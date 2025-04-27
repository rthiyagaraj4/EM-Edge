/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

import eCommon.Common.CommonAdapter;
import eST.Common.StAdapter;
import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
public class SRRCertificateForReimbursementBean extends StAdapter implements Serializable
{
			protected ArrayList active_CertiforReimbursements		= null ; 
				  	protected ArrayList selList = null;


	public SRRCertificateForReimbursementBean() {
		try {
			doCommon() ;
			selList = new ArrayList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void doCommon() throws Exception {
	}
		public void clear() {
		super.clear() ;
		selList = new ArrayList();
		selList.clear() ;

	}
	public void setCertiforReimbursementRecds(ArrayList active_CertiforReimbursement)	{
		this.active_CertiforReimbursements	=	(ArrayList)active_CertiforReimbursement.clone();
	}
	public ArrayList getCertiforReimbursementRecds()	{
		return this.active_CertiforReimbursements;
	}


	public ArrayList getCertiforReimbursementList(String patient_id,String adr_reported_date_from,String adr_reported_date_to,String sale_doc_no_from,String sale_doc_no_to,String store_code,String doc_type_code,String facility_id,String user_name,String locale)throws Exception{

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();

     		try {

			ArrayList arrList = getSelectedValue();
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT DISTINCT hdr.doc_type_code, hdr.doc_no,TO_CHAR (hdr.doc_date, 'dd/mm/yyyy') doc_date, hdr.store_code,fms.short_desc fm_store_desc, hdr.patient_id,NVL(hdr.ENCOUNTER_ID,'') encounter_id, DECODE(SAL_TRN_TYPE,'X', hdr.PATIENT_NAME, mp.patient_name) patient_name FROM ST_SAL_HDR hdr, mm_store_lang_vw fms, sy_doc_type_master_lang_vw sy,ST_USER_ACCESS_FOR_STORE uaca,mp_patient mp WHERE  hdr.store_code = fms.store_code AND hdr.patient_id=mp.patient_id AND uaca.store_code = hdr.store_code AND hdr.finalized_yn = 'Y' AND hdr.module_id = 'ST' AND uaca.sal_allowed_yn = 'Y' AND hdr.doc_type_code LIKE UPPER(?) AND TO_CHAR(hdr.doc_no) BETWEEN TO_CHAR(NVL(?,'!')) AND TO_CHAR(NVL(?,'~')) AND trunc(hdr.doc_date) BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'dd/mm/yyyy') AND TO_DATE (NVL (?, TO_CHAR (SYSDATE, 'DD/MM/YYYY')),'dd/mm/yyyy') AND hdr.store_code =? AND uaca.user_id =? AND hdr.facility_id =? AND hdr.PATIENT_ID LIKE UPPER (?) AND sy.language_id = fms.language_id AND sy.language_id =? order by doc_date desc,doc_no desc");

			pstmt.setString(1,doc_type_code.trim());
			pstmt.setString(2,sale_doc_no_from.trim());
			pstmt.setString(3,sale_doc_no_to.trim());
			pstmt.setString(4,adr_reported_date_from.trim());
			pstmt.setString(5,adr_reported_date_to.trim());
			pstmt.setString(6,store_code.trim());
		    pstmt.setString(7,user_name.trim());
			pstmt.setString(8,facility_id.trim());
			pstmt.setString(9,patient_id.trim());
			pstmt.setString(10,locale.trim());
			resultSet = pstmt.executeQuery() ;
			while ( resultSet.next() ) {
			String arr[] = new String[9];	
			arr[0]=resultSet.getString("doc_date");
			if(!locale.equals("en")){
			arr[0]=com.ehis.util.DateUtils.convertDate(resultSet.getString("doc_date"),"DMY","en",locale); //Removed HM format against inc#38120
			}
			arr[1]=resultSet.getString("fm_store_desc");
			arr[2]=resultSet.getString("doc_no");
			arr[3]=resultSet.getString("patient_id");
			arr[4]=resultSet.getString("patient_name");
			arr[5]=resultSet.getString("encounter_id");
			if(arrList != null && arrList.contains(resultSet.getString("doc_no")))
			arr[6]="Y";
			else
			arr[6]="N";
			records.add(arr);
			}

		setCertiforReimbursementRecds(records);	

		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;

		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
			es.printStackTrace() ;
			}
		}

		return records;
	}
/*   CertificateforReimbursement desc returns ends here    */

public void setSelectedValue (String doc_no){
	
	if (selList == null)
		selList = new ArrayList();

	if(!selList.contains(doc_no))
	{
		selList.add(doc_no);
		ArrayList getList = this.active_CertiforReimbursements;	
		for(int i=0;i<getList.size();i++)
		{
			String [] record= (String[])getList.get(i);
			if(record[2].equals(doc_no)){
				record[6] = "Y";
			}
         }
	}

}
public void removeValue(String doc_no){
	
	if(selList != null && selList.contains(doc_no))
	{
		selList.remove(doc_no);
		ArrayList getList = this.active_CertiforReimbursements;	
		for(int i=0;i<getList.size();i++)
		{
			String [] record= (String[])getList.get(i);
			if(record[2].equals(doc_no)){
				record[6] = "N";
			}
		}
	}

}


public ArrayList getSelectedValue(){
	
	return this.selList;

}


}

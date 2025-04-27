/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;

import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
/*import javax.rmi.PortableRemoteObject ;
import javax.naming.InitialContext ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
//import ePH.DispenseLocation.*;

public class TDMGuidLinesView extends PhAdapter implements Serializable {

	protected String drug_desc			="";
	protected String order_id			="";
	ArrayList selectdtls	= new ArrayList();

public TDMGuidLinesView() {
		try {
			doCommon() ;
		}
		catch(Exception e) 
		{
	      System.err.println("Exception in constructor"+e.toString());
		  e.printStackTrace();
		}
	}

private void doCommon() throws Exception {
	}

public String getDrugDesc(String drug_code,String locale) throws Exception {
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( "SELECT DRUG_DESC FROM PH_DRUG_LANG_VW WHERE DRUG_CODE = ? AND LANGUAGE_ID = ?" );
			pstmt.setString( 1, drug_code.trim() ) ;
			pstmt.setString( 2, locale.trim() ) ;
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				drug_desc   		=	resultSet.getString("DRUG_DESC" );
				}			          
		 }
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		} return  drug_desc;
	}


public ArrayList getOrderIds(String drug_code,String pat_id) throws Exception {
		
		ArrayList ordids = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( "select order_id from or_order_line where order_Catalog_Code = ? and order_id in (select order_id from or_order where patient_id = ? and order_type_code = 'TDM' and parent_order_id =order_id)" );
			pstmt.setString( 1, drug_code.trim() ) ;
			pstmt.setString( 2, pat_id.trim() ) ;
			resultSet = pstmt.executeQuery() ;
			 while (resultSet != null && resultSet.next()) {
				ordids.add(resultSet.getString("order_id")==null?"":resultSet.getString("order_id"));

				}	
				
		 }
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		} return  ordids;
	}





public ArrayList getPatOrderDet(String pat_id,String order_id,String drug_code)
	{
        ArrayList result = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( "SELECT  B.DRUG_CODE,A.DRUG_DESC,D.FORM_DESC,C.FREQ_DESC,TO_CHAR(B.START_DATE,'DD/MM/YYYY HH24:MI') START_DATE,TO_CHAR(B.END_DATE,'DD/MM/YYYY HH24:MI') END_DATE,(select order_id from or_order where parent_order_id = ? AND ROWNUM <=1 ) TDM_ORDER_ID,(select route_desc from ph_route where route_code = b.route_code) route_desc  FROM PH_DRUG A, PH_PATIENT_DRUG_PROFILE B, AM_FREQUENCY C, PH_FORM D WHERE B.PATIENT_ID = ? AND ORIG_ORDER_ID = ? AND B.DRUG_CODE = ? AND A.DRUG_CODE=B.DRUG_CODE AND B.FORM_CODE=D.FORM_CODE AND A.APPL_TO_TDM_YN='Y' AND B.FREQ_CODE=C.FREQ_CODE " );
			pstmt.setString( 1, order_id.trim() ) ;
			pstmt.setString( 2, pat_id.trim() ) ;
			pstmt.setString( 3, order_id.trim() ) ;
			pstmt.setString( 4, drug_code.trim() ) ;
			resultSet = pstmt.executeQuery() ;
			  while (resultSet != null && resultSet.next()) {
				  result.add(resultSet.getString("DRUG_CODE")==null?"":resultSet.getString("DRUG_CODE"));
				  result.add(resultSet.getString("DRUG_DESC")==null?"":resultSet.getString("DRUG_DESC"));
				  result.add(resultSet.getString("FORM_DESC")==null?"":resultSet.getString("FORM_DESC"));
				  result.add(resultSet.getString("FREQ_DESC")==null?"":resultSet.getString("FREQ_DESC"));
				  result.add(resultSet.getString("START_DATE")==null?"":resultSet.getString("START_DATE"));
				  result.add(resultSet.getString("END_DATE")==null?"":resultSet.getString("END_DATE"));
                  result.add(resultSet.getString("TDM_ORDER_ID")==null?"":resultSet.getString("TDM_ORDER_ID"));
                  result.add(resultSet.getString("route_desc")==null?"":resultSet.getString("route_desc"));
			  }
		 }
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
			return result;
		}
	}

public ArrayList getTdmOrdId(String order_id)
{
        ArrayList result = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( "select order_id from or_order where parent_order_id = ? " );
			pstmt.setString( 1, order_id.trim() ) ;
			resultSet = pstmt.executeQuery() ;
			  while (resultSet != null && resultSet.next()) {
				  
                  result.add(resultSet.getString("order_id")==null?"":resultSet.getString("order_id"));
			  }
		 }
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
			return result;
		}
	}

public ArrayList getTdmOrderDet(String order_id)
	{
        ArrayList result = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( "Select to_char(ord_Date_time,'DD/MM/YYYY HH24:MI') ORD_DATE_TIME,(select practitioner_name from am_practitioner where practitioner_id = b.ord_pract_id) Ord_pract_name,(select REASON_DESC from PH_MEDN_TRN_REASON where APPL_TRN_TYPE = 'TD' and REASON_CODE = A.REASON_FOR_REQ_CODE) Reason_Request_desc,SMOKER_YN,ALCOHLIC_YN,PREGNANT_YN,REMARKS ,(select short_desc from or_order_Status_code where order_Status_code = b.order_Status) order_status_Desc ,OR_ORDER_STATUS_POPUPMENU ('RESULT_HYPER_LINK',b.ORDER_ID,b.ORDER_TYPE_CODE) RESULT_HYPER_LINK from or_order_line_tdm a,or_order b where a.order_id = b.order_id and a.order_id = ? " );
			pstmt.setString( 1, order_id.trim() ) ;
			resultSet = pstmt.executeQuery() ;
			  while (resultSet != null && resultSet.next()) {
				result.add(resultSet.getString("ORD_DATE_TIME")==null?"":resultSet.getString("ORD_DATE_TIME"));
				result.add(resultSet.getString("Ord_pract_name")==null?"":resultSet.getString("Ord_pract_name"));
				result.add(resultSet.getString("Reason_Request_desc")==null?"":resultSet.getString("Reason_Request_desc"));
				result.add(resultSet.getString("SMOKER_YN")==null?"":resultSet.getString("SMOKER_YN"));
				result.add(resultSet.getString("ALCOHLIC_YN")==null?"":resultSet.getString("ALCOHLIC_YN"));
                result.add(resultSet.getString("PREGNANT_YN")==null?"":resultSet.getString("PREGNANT_YN"));
				result.add(resultSet.getString("REMARKS")==null?"":resultSet.getString("REMARKS"));
				result.add(resultSet.getString("order_status_Desc")==null?"":resultSet.getString("order_status_Desc"));
				result.add(resultSet.getString("RESULT_HYPER_LINK")==null?"":resultSet.getString("RESULT_HYPER_LINK"));
			  }
		 }
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
			return result;
		}
	}



public ArrayList getAdminDetails(String ord_id,String pat_id,String drug_code, String date)
	{
        ArrayList result = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( "SELECT decode(a.administered_yn,'Y','Yes','No') administered_yn ,f.short_desc,b.admin_drug_code,TO_CHAR (a.admin_date_time, 'DD/MM/YYYY HH24:MI') admin_time,a.admin_by,d.practitioner_name,e.drug_desc,b.admin_dosage_qty,b.admin_dosage_uom_code, a.admin_remarks,'Batch Id:'|| NVL (b.batch_id, '--') || ' Expiry Date:' || NVL (TO_CHAR (b.expiry_date, 'dd/mm/yyyy'), '--') || ' Trade Name:'|| NVL ((SELECT short_name FROM am_trade_name WHERE trade_id = b.trade_id), '--') batch_details FROM ph_medn_admin_dtl b,or_order c,am_practitioner d, ph_medn_admin a,ph_drug e,ip_nursing_unit f WHERE f.facility_id = a.facility_id AND f.nursing_unit_code = a.admin_nursing_unit_code AND a.facility_id = b.facility_id AND a.encounter_id = b.encounter_id AND a.sch_date_time = b.sch_date_time AND a.ord_drug_code = b.ord_drug_code AND a.order_id = b.order_id AND a.order_id = c.order_id AND c.ord_pract_id = d.practitioner_id AND e.drug_code = b.admin_drug_code AND a.patient_id = ? AND a.order_id = ? AND a.sch_date_time = to_Date( ? ,'DD/MM/YYYY HH24:MI') AND a.ord_drug_code = ? " );
			pstmt.setString( 1, pat_id.trim() ) ;
			pstmt.setString( 2, ord_id.trim() ) ;
		
			pstmt.setString( 3, date.trim() ) ;
			pstmt.setString( 4, drug_code.trim() ) ;
			resultSet = pstmt.executeQuery() ;
			  while (resultSet != null && resultSet.next()) {
			    result.add(resultSet.getString("administered_yn")==null?"":resultSet.getString("administered_yn"));
				result.add(resultSet.getString("short_desc")==null?"":resultSet.getString("short_desc"));
				result.add(resultSet.getString("admin_drug_code")==null?"":resultSet.getString("admin_drug_code"));
				result.add(resultSet.getString("admin_time")==null?"":resultSet.getString("admin_time"));
				result.add(resultSet.getString("admin_by")==null?"":resultSet.getString("admin_by"));
				result.add(resultSet.getString("practitioner_name")==null?"":resultSet.getString("practitioner_name"));
				result.add(resultSet.getString("drug_desc")==null?"":resultSet.getString("drug_desc"));
				result.add(resultSet.getString("admin_dosage_qty")==null?"":resultSet.getString("admin_dosage_qty"));
				result.add(resultSet.getString("admin_dosage_uom_code")==null?"":resultSet.getString("admin_dosage_uom_code"));
				result.add(resultSet.getString("admin_remarks")==null?"":resultSet.getString("admin_remarks"));
				result.add(resultSet.getString("batch_details")==null?"":resultSet.getString("batch_details"));

			  }
		 }
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
			return result;
		}
	}


public void setDetails(String order_id,String pat_id,String drg_cde,String date){
		selectdtls.clear();
		selectdtls.add(order_id);
		selectdtls.add(pat_id);
		selectdtls.add(drg_cde);
		selectdtls.add(date);			
	}
public ArrayList getDetails(){
		return selectdtls;
	}


public ArrayList showDosLabDet(String order_id,String pat_id,String ord_id)
	{
	    ArrayList result = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( "Select to_char(SCH_DOSE_DATE_TIME,'DD/MM/YYYY HH24:MI') sch_dose_date_time,(SELECT SCH_DOSAGE_QTY || '  ' || SCH_DOSAGE_UOM_CODE FROM  PH_MEDN_ADMIN A WHERE  PATIENT_ID = ?  AND  A.ORDER_ID = ? AND  ORDER_LINE_NUM='1' and rownum <=1)  DOSAGE, decode(a.sampling_type,'E','Extended','P','Peak','T','Trough','R','Random')  sampling_type_desc , decode(a.sampling_time_ind,'A','After Dose','B','Before Dose',Null) sampling_time_ind , NVL(a.SAMPLING_DURN,'') || ' '||  NVL(decode(a.SAMPLING_DURN_TYPE,'M','Minutes','D','Days','H','Hours'),'') SAMPLING_TIME_DURN_TYPE, a.order_Catalog_Code order_Catalog_Code, b.short_Desc short_Desc, (select to_char(SPECIMEN_COLLECT_DATE_TIME,'DD/MM/YYYY HH24:MI') from or_ordeR_line_lb where order_id = lb_order_id and order_line_num = 1) Specimen_collection_Date,lb_order_id ,(select short_desc from or_order e,or_order_status_code f where e.order_id = a.lb_order_id and f.order_Status_Code = e.order_Status) Lb_Order_Status, OR_ORDER_STATUS_POPUPMENU ('RESULT_HYPER_LINK',a.lb_ORDER_ID,b.ORDER_TYPE_CODE) RESULT_HYPER_LINK,(SELECT admin_by FROM ph_medn_admin WHERE patient_id = ? AND order_id = ? AND order_line_num = '1' AND sch_date_time = a.sch_dose_date_time) dose_details,(select to_char(ord_Date_time,'DD/MM/YYYY HH24:MI') from or_order where order_id = a.lb_order_id) Specimen_scheduled_at from or_order_line_tdm_dtl a,or_ordeR_catalog b  where a.order_id = ? and a.order_Catalog_code = b.order_catalog_Code order by 1" );
			pstmt.setString( 1, pat_id.trim() ) ;
			pstmt.setString( 2, order_id.trim() ) ;
			pstmt.setString( 3, pat_id.trim() ) ;
			pstmt.setString( 4, order_id.trim() ) ;
			pstmt.setString( 5, ord_id.trim() ) ;
			resultSet = pstmt.executeQuery() ;
			  while (resultSet != null && resultSet.next()) {
				 result.add(resultSet.getString("sch_dose_date_time")==null?"":resultSet.getString("sch_dose_date_time"));
				 result.add(resultSet.getString("DOSAGE")==null?"":resultSet.getString("DOSAGE"));
				 result.add(resultSet.getString("sampling_type_desc")==null?"":resultSet.getString("sampling_type_desc"));
				 result.add(resultSet.getString("sampling_time_ind")==null?"":resultSet.getString("sampling_time_ind"));
				 result.add(resultSet.getString("SAMPLING_TIME_DURN_TYPE")==null?"":resultSet.getString("SAMPLING_TIME_DURN_TYPE"));
				 result.add(resultSet.getString("order_Catalog_Code")==null?"":resultSet.getString("order_Catalog_Code"));
                 result.add(resultSet.getString("short_Desc")==null?"":resultSet.getString("short_Desc"));
			    result.add(resultSet.getString("Specimen_collection_Date")==null?"":resultSet.getString("Specimen_collection_Date"));
				result.add(resultSet.getString("lb_order_id")==null?"":resultSet.getString("lb_order_id"));
				result.add(resultSet.getString("Lb_Order_Status")==null?"":resultSet.getString("Lb_Order_Status"));
				result.add(resultSet.getString("RESULT_HYPER_LINK")==null?"":resultSet.getString("RESULT_HYPER_LINK"));
				result.add(resultSet.getString("dose_details")==null?"":resultSet.getString("dose_details"));
				result.add(resultSet.getString("Specimen_scheduled_at")==null?"":resultSet.getString("Specimen_scheduled_at"));
			  }
		 }
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
			return result;
		}
	}
public ArrayList getSamplingData(String drug_code,String pat_id, String locale) throws Exception {
	
		ArrayList result = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( "SELECT  STEADY_STATE_DURN || ' '|| decode(a.STEADY_STATE_DURN_TYPE,'M','Minutes','D','Days','H','Hours') STEADY_STATE_DURN_TYPE,decode(a.sampling_type,'E','Extended','P','Peak','T','Trough','R','Random')  sampling_type_desc , NVL(a.SAMPLING_TIME,'') || ' '||  NVL(decode(a.SAMPLING_TIME_DURN_TYPE,'M','Minutes','D','Days','H','Hours'),'') SAMPLING_TIME_DURN_TYPE, E.short_desc Lab_Order_desc,tdm_attr_remarks TDM_ATTR_REMARKS, decode(a.sampling_type,'T',1,'P',2,'R',3,'E',4)  sampling_type_seq FROM  PH_TDM_ATTR  A, AM_AGE_GROUP B, MP_PATIENT C,PH_TDM_ATTR_DTL D,OR_ORDER_CATALOG_LANG_VW E WHERE  a.DRUG_CODE= ? AND c.patient_id = ? AND trunc(sysdate - c.date_of_birth) BETWEEN  decode(b.age_unit,'D',b.MIN_AGE,'M',b.MIN_AGE*30,'Y',MIN_AGE*360) AND decode(b.age_unit_max,'D',b.MAX_AGE,'M',b.MAX_AGE*30,'Y',MAX_AGE*360) AND ( b.GENDER is null OR b.GENDER = c.sex ) AND b.age_group_code = a.age_group_code and E.ORDER_CATALOG_CODE = D.ORDER_CATALOG_CODE  AND D.DRUG_CODE = A.DRUG_CODE AND D.AGE_GROUP_CODE = A.AGE_GROUP_CODE  AND D.SAMPLING_TYPE = A.SAMPLING_TYPE AND E.LANGUAGE_ID=? order by sampling_type_seq" );
			pstmt.setString( 1, drug_code.trim() ) ;
			pstmt.setString( 2, pat_id.trim() ) ;
			pstmt.setString( 3, locale ) ;

			resultSet = pstmt.executeQuery() ;
			 while (resultSet != null && resultSet.next()) {
				 result.add(resultSet.getString("STEADY_STATE_DURN_TYPE")==null?"":resultSet.getString("STEADY_STATE_DURN_TYPE"));
				 result.add(resultSet.getString("sampling_type_desc")==null?"":resultSet.getString("sampling_type_desc"));
				 result.add(resultSet.getString("SAMPLING_TIME_DURN_TYPE")==null?"":resultSet.getString("SAMPLING_TIME_DURN_TYPE"));
				 result.add(resultSet.getString("Lab_Order_desc")==null?"":resultSet.getString("Lab_Order_desc"));
                 result.add(resultSet.getString("TDM_ATTR_REMARKS")==null?"":resultSet.getString("TDM_ATTR_REMARKS"));
                 result.add(resultSet.getString("sampling_type_seq")==null?"":resultSet.getString("sampling_type_seq"));
				 
           	  }
		 }
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
			return result;
		}
	}

}

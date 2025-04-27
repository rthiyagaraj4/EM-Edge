/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
03/04/2013    IN039096       Chowminya G    Services not getting listed though more than one quantity defined in the package during successive encounters
20/19/2013    IN039096.1     Chowminya G    Services not getting listed though more than one quantity defined in the package during successive encounters
18/11/2020	  8090	 Nijitha S		SH-ICN-0002 
09/10/2023     51003           Krishna Pranay    10/10/2023       Ramesh Goli        COMMON-ICN-0178

-----------------------------------------------------------------------
*/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import javax.servlet.*;
import javax.servlet.http.*;
import eOR.Common.* ;
import eCommon.Common.*;
import webbeans.eCommon.*;

import eOR.ORCancelDiscontinueOrder.*;

public class FutureOrder extends eOR.Common.OrAdapter implements java.io.Serializable {

	protected String order_type_code = "";
	protected String ord_consent_reqd_yn = "";
	protected String total_records = "";
	protected String pract_id = "";
	protected String security_level = "";
	protected HashMap all_final_values = new HashMap();
	protected Hashtable allValues = new Hashtable();
	public TreeMap FutureOrder    = new TreeMap();
	int cnt = 0;
	int no_of_occurance = 0;
	StringBuffer traceVals = new StringBuffer();
	eOR.OrderEntryBillingQueryBean  orderEntryBillBean = null;
	public void setMode(String mode){					this.mode = mode;	}
	public void setTotalRecs(String total_records){	this.total_records = total_records;	}
	public void setPractId(String pract_id){			this.pract_id = pract_id;	}
	public void setSecurityLevel(String security_level){this.security_level = security_level;	}

	public void setFinalValues(HashMap all_final_values){this.all_final_values = all_final_values;	}
	
	public void setOrderEntryBillBean(eOR.OrderEntryBillingQueryBean  orderEntryBillBean)
	{
		this.orderEntryBillBean=orderEntryBillBean;
    }
	
	public Object getOrderEntryBillBean()
	{

       return this.orderEntryBillBean;
	}
  /* public void clearBillBean() {
    orderEntryBillBean.clearBean();
  } */
	public String getMode(){				return mode;	}
	public String getTotalRecs(){			return total_records;	}
	public String getSecurityLevel(){		return security_level;	}

	public HashMap getFinalValues(){		return all_final_values;	}
	public Hashtable getAllValues() {
        return allValues;
    }

	public void clear() {
		order_type_code 			    = "";
		ord_consent_reqd_yn 			= "";
		total_records					= "";
		pract_id						= "";
		security_level					= "";
		FutureOrder						= new TreeMap();
 		//orderEntryBillBean			= new OrderEntryBillingQueryBean();


		super.clear();
 }

/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/

	public ArrayList getFutureOrderDetails(String facility_id,int start, int end,String patient_id,String called_from,String order_id,String encounter_id) throws Exception {
		
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList FutureOrder = new ArrayList() ;

 		int total_records			= 0;

		try {
				
			connection			= getConnection() ;
			if(called_from.equalsIgnoreCase("ExistingOrder"))
			{
				//pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_EXISTING_ORDER_LINK")  ) ;
				//pstmt = connection.prepareStatement( "SELECT   a.order_id order_id,a.order_category,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')  order_category_short_desc,b.Priority Priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, b.order_line_num order_line_num,b.bill_yn bill_yn,b.order_qty order_qty,TO_CHAR(start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,c.CONTR_MOD_ID contr_mod_id,a.patient_id, encounter_id, TO_CHAR(a.ORD_DATE_TIME,'DD/MM/YYYY HH24:MI') order_date_time, OR_GET_DESC.OR_ORDER_CATALOG(b.ORDER_CATALOG_CODE,?,2)  order_detail,b.ORDER_CATALOG_CODE catalog_code,SOURCE_TYPE,SOURCE_CODE,b.Priority,b.ORDER_TYPE_CODE ,                                  a.ORD_PRACT_ID ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ORD_PRACT_ID,?,'1')  ORDERING_PRACT_NAME,ORDER_STATUS,OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc,  a.ord_consent_reqd_yn, sex,date_of_birth, GET_AGE(DATE_OF_BIRTH) age,nvl(a.cont_order_ind,'DO')   cont_order_ind, a.ord_appr_reqd_yn, ord_appr_by_user_id, a.ord_consent_reqd_yn, ord_consent_by_id,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description, b.billing_package_ref billing_package_ref FROM or_order a, or_ordeR_line b,or_order_catalog c,mp_patient d  WHERE  a.ordeR_id =b.ordER_id  and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE and a.patient_id=d.patient_id and ordering_facility_id = (?)  and a.patient_id=(?) and a.encounter_id!= ? and a.order_id=?  /*OR_CHECK_UNBILL_ORD_EXISTS_YN(a.patient_id, ordering_facility_id,a.order_id,b.order_line_num)='Y'*/ and OR_LIST_FUTURE_ORD_WRT_BILL_YN (a.patient_id,a.ordering_facility_id,a.order_id,b.order_line_num)='Y' and  decode(b.billing_package_ref,null,b.future_order_yn,(select across_encounter_yn from bl_package_sub_hdr where package_seq_no = b.billing_package_ref))='Y'/*and (b.future_order_yn='Y' or b.billing_package_ref is not null)*/ and  nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR') and ORDER_line_STATUS IN ( SELECT ORDER_STATUS_CODE   FROM OR_ORDER_STATUS_CODE  WHERE ORDER_STATUS_TYPE <'20')  order by encounter_id,a.order_id,a.ORD_DATE_TIME desc"  ) ; //IN039096//IN039096.1
				//pstmt = connection.prepareStatement( "SELECT   a.order_id order_id,a.order_category,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')  order_category_short_desc,b.Priority Priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, b.order_line_num order_line_num,decode(b.billing_package_ref,null,b.bill_yn,'N') bill_yn,b.order_qty order_qty,TO_CHAR(start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,c.CONTR_MOD_ID contr_mod_id,a.patient_id, encounter_id, TO_CHAR(a.ORD_DATE_TIME,'DD/MM/YYYY HH24:MI') order_date_time, OR_GET_DESC.OR_ORDER_CATALOG(b.ORDER_CATALOG_CODE,?,2)  order_detail,b.ORDER_CATALOG_CODE catalog_code,SOURCE_TYPE,SOURCE_CODE,b.Priority,b.ORDER_TYPE_CODE ,                                  a.ORD_PRACT_ID ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ORD_PRACT_ID,?,'1')  ORDERING_PRACT_NAME,ORDER_STATUS,OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc,  a.ord_consent_reqd_yn, sex,date_of_birth, GET_AGE(DATE_OF_BIRTH) age,nvl(a.cont_order_ind,'DO')   cont_order_ind, a.ord_appr_reqd_yn, ord_appr_by_user_id, a.ord_consent_reqd_yn, ord_consent_by_id,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description, b.billing_package_ref billing_package_ref FROM or_order a, or_ordeR_line b,or_order_catalog c,mp_patient d  WHERE  a.ordeR_id =b.ordER_id  and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE and a.patient_id=d.patient_id and ordering_facility_id = (?)  and a.patient_id=(?) and a.encounter_id!= ? and a.order_id=?  /*OR_CHECK_UNBILL_ORD_EXISTS_YN(a.patient_id, ordering_facility_id,a.order_id,b.order_line_num)='Y'*/ and OR_LIST_FUTURE_ORD_WRT_BILL_YN (a.patient_id,a.ordering_facility_id,a.order_id,b.order_line_num)='Y' and  decode(b.billing_package_ref,null,b.future_order_yn,(select across_encounter_yn from bl_package_sub_hdr where package_seq_no = b.billing_package_ref))='Y'/*and (b.future_order_yn='Y' or b.billing_package_ref is not null)*/ and  nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR') and ORDER_line_STATUS IN ( SELECT ORDER_STATUS_CODE   FROM OR_ORDER_STATUS_CODE  WHERE ORDER_STATUS_TYPE <'20')  order by encounter_id,a.order_id,a.ORD_DATE_TIME desc"  ) ; //IN039096//IN039096.1//8090
				pstmt = connection.prepareStatement( "SELECT   a.order_id order_id,a.order_category,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')  order_category_short_desc,b.Priority Priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, b.order_line_num order_line_num,decode(b.billing_package_ref,null,b.bill_yn,'N') bill_yn,b.order_qty order_qty,TO_CHAR(start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,c.CONTR_MOD_ID contr_mod_id,a.patient_id, encounter_id, TO_CHAR(a.ORD_DATE_TIME,'DD/MM/YYYY HH24:MI') order_date_time, OR_GET_DESC.OR_ORDER_CATALOG(b.ORDER_CATALOG_CODE,?,2)  order_detail,b.ORDER_CATALOG_CODE catalog_code,SOURCE_TYPE,SOURCE_CODE,b.Priority,b.ORDER_TYPE_CODE ,                                  a.ORD_PRACT_ID ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ORD_PRACT_ID,?,'1')  ORDERING_PRACT_NAME,ORDER_STATUS,OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc,  a.ord_consent_reqd_yn, sex,date_of_birth, GET_AGE(DATE_OF_BIRTH) age,nvl(a.cont_order_ind,'DO')   cont_order_ind, a.ord_appr_reqd_yn, ord_appr_by_user_id, a.ord_consent_reqd_yn, ord_consent_by_id,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description, b.billing_package_ref billing_package_ref,b.fpp_yn,b.fpp_category FROM or_order a, or_ordeR_line b,or_order_catalog c,mp_patient d  WHERE  a.ordeR_id =b.ordER_id  and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE and a.patient_id=d.patient_id and ordering_facility_id = (?)  and a.patient_id=(?) and a.encounter_id!= ? and a.order_id=?  /*OR_CHECK_UNBILL_ORD_EXISTS_YN(a.patient_id, ordering_facility_id,a.order_id,b.order_line_num)='Y'*/ and OR_LIST_FUTURE_ORD_WRT_BILL_YN (a.patient_id,a.ordering_facility_id,a.order_id,b.order_line_num)='Y' and  decode(b.billing_package_ref,null,b.future_order_yn,(select across_encounter_yn from bl_package_sub_hdr where package_seq_no = b.billing_package_ref))='Y'/*and (b.future_order_yn='Y' or b.billing_package_ref is not null)*/ and  nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR') and ORDER_line_STATUS IN ( SELECT ORDER_STATUS_CODE   FROM OR_ORDER_STATUS_CODE  WHERE ORDER_STATUS_TYPE <'20')  order by encounter_id,a.order_id,a.ORD_DATE_TIME desc"  ) ; //IN039096//IN039096.1//8090
			}
			else
			{
				//pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_LINK")  ) ;
				/*Added by Uma on 1/19/2010 for IN017420*/
				//pstmt = connection.prepareStatement( "SELECT   a.order_id order_id,a.order_category,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')  order_category_short_desc,b.Priority Priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, b.order_line_num order_line_num,decode(b.billing_package_ref,null,b.bill_yn,'N') bill_yn,b.order_qty order_qty,TO_CHAR(start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,c.CONTR_MOD_ID contr_mod_id,a.patient_id, encounter_id, TO_CHAR(a.ORD_DATE_TIME,'DD/MM/YYYY HH24:MI') order_date_time, OR_GET_DESC.OR_ORDER_CATALOG(b.ORDER_CATALOG_CODE,?,2)  order_detail,b.ORDER_CATALOG_CODE catalog_code,SOURCE_TYPE,SOURCE_CODE,b.Priority,b.ORDER_TYPE_CODE ,                                  a.ORD_PRACT_ID ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ORD_PRACT_ID,?,'1')  ORDERING_PRACT_NAME,ORDER_STATUS,OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc,  a.ord_consent_reqd_yn, sex,date_of_birth, GET_AGE(DATE_OF_BIRTH) age,nvl(a.cont_order_ind,'DO')   cont_order_ind, a.ord_appr_reqd_yn, ord_appr_by_user_id, a.ord_consent_reqd_yn, ord_consent_by_id,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description, b.billing_package_ref FROM or_order a, or_ordeR_line b,or_order_catalog c,mp_patient d  WHERE  a.ordeR_id =b.ordER_id  and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE and a.patient_id=d.patient_id and ordering_facility_id = (?)  and a.patient_id=(?)  /*OR_CHECK_UNBILL_ORD_EXISTS_YN(a.patient_id, ordering_facility_id,a.order_id,b.order_line_num)='Y'*/ and OR_LIST_FUTURE_ORD_WRT_BILL_YN (a.patient_id,a.ordering_facility_id,a.order_id,b.order_line_num)='Y' and /*(b.future_order_yn='Y' or b.billing_package_ref is not null)*/  decode(b.billing_package_ref,null,b.future_order_yn,(select across_encounter_yn from bl_package_sub_hdr where package_seq_no = b.billing_package_ref))='Y' and  nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR') and ORDER_STATUS IN ( SELECT ORDER_STATUS_CODE   FROM OR_ORDER_STATUS_CODE  WHERE ORDER_STATUS_TYPE <'20') and a.encounter_id != ? order by encounter_id,a.order_id,a.ORD_DATE_TIME desc") ;
				//pstmt = connection.prepareStatement( "SELECT   a.order_id order_id,a.order_category,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')  order_category_short_desc,b.Priority Priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, b.order_line_num order_line_num,decode(b.billing_package_ref,null,b.bill_yn,'N') bill_yn,b.order_qty order_qty,TO_CHAR(start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,c.CONTR_MOD_ID contr_mod_id,a.patient_id, encounter_id, TO_CHAR(a.ORD_DATE_TIME,'DD/MM/YYYY HH24:MI') order_date_time, OR_GET_DESC.OR_ORDER_CATALOG(b.ORDER_CATALOG_CODE,?,2)  order_detail,b.ORDER_CATALOG_CODE catalog_code,SOURCE_TYPE,SOURCE_CODE,b.Priority,b.ORDER_TYPE_CODE ,                                  a.ORD_PRACT_ID ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ORD_PRACT_ID,?,'1')  ORDERING_PRACT_NAME,ORDER_STATUS,OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc,  a.ord_consent_reqd_yn, sex,date_of_birth, GET_AGE(DATE_OF_BIRTH) age,nvl(a.cont_order_ind,'DO')   cont_order_ind, a.ord_appr_reqd_yn, ord_appr_by_user_id, a.ord_consent_reqd_yn, ord_consent_by_id,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description, b.billing_package_ref billing_package_ref FROM or_order a, or_ordeR_line b,or_order_catalog c,mp_patient d  WHERE  a.ordeR_id =b.ordER_id  and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE and a.patient_id=d.patient_id and ordering_facility_id = (?)  and a.patient_id=(?)  /*OR_CHECK_UNBILL_ORD_EXISTS_YN(a.patient_id, ordering_facility_id,a.order_id,b.order_line_num)='Y'*/ and OR_LIST_FUTURE_ORD_WRT_BILL_YN (a.patient_id,a.ordering_facility_id,a.order_id,b.order_line_num)='Y' and /*(b.future_order_yn='Y' or b.billing_package_ref is not null)*/  decode(b.billing_package_ref,null,b.future_order_yn,(select across_encounter_yn from bl_package_sub_hdr where package_seq_no = b.billing_package_ref))='Y' and  nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR') and ORDER_STATUS IN ( SELECT ORDER_STATUS_CODE   FROM OR_ORDER_STATUS_CODE  WHERE ORDER_STATUS_TYPE <'20') and a.encounter_id != ? order by encounter_id,a.order_id,a.ORD_DATE_TIME desc") ;//8090
				pstmt = connection.prepareStatement( "SELECT   a.order_id order_id,a.order_category,OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')  order_category_short_desc,b.Priority Priority_desc,AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, b.order_line_num order_line_num,decode(b.billing_package_ref,null,b.bill_yn,'N') bill_yn,b.order_qty order_qty,TO_CHAR(start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,c.CONTR_MOD_ID contr_mod_id,a.patient_id, encounter_id, TO_CHAR(a.ORD_DATE_TIME,'DD/MM/YYYY HH24:MI') order_date_time, OR_GET_DESC.OR_ORDER_CATALOG(b.ORDER_CATALOG_CODE,?,2)  order_detail,b.ORDER_CATALOG_CODE catalog_code,SOURCE_TYPE,SOURCE_CODE,b.Priority,b.ORDER_TYPE_CODE ,                                  a.ORD_PRACT_ID ord_pract_id, AM_GET_DESC.AM_PRACTITIONER(a.ORD_PRACT_ID,?,'1')  ORDERING_PRACT_NAME,ORDER_STATUS,OR_GET_DESC.OR_ORDER_STATUS_CODE(order_line_status,?,'2') order_status_short_desc,  a.ord_consent_reqd_yn, sex,date_of_birth, GET_AGE(DATE_OF_BIRTH) age,nvl(a.cont_order_ind,'DO')   cont_order_ind, a.ord_appr_reqd_yn, ord_appr_by_user_id, a.ord_consent_reqd_yn, ord_consent_by_id,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description, b.billing_package_ref billing_package_ref,b.fpp_yn,b.fpp_category FROM or_order a, or_ordeR_line b,or_order_catalog c,mp_patient d  WHERE  a.ordeR_id =b.ordER_id  and b.ORDER_CATALOG_CODE=c.ORDER_CATALOG_CODE and a.patient_id=d.patient_id and ordering_facility_id = (?)  and a.patient_id=(?)  /*OR_CHECK_UNBILL_ORD_EXISTS_YN(a.patient_id, ordering_facility_id,a.order_id,b.order_line_num)='Y'*/ and OR_LIST_FUTURE_ORD_WRT_BILL_YN (a.patient_id,a.ordering_facility_id,a.order_id,b.order_line_num)='Y' and /*(b.future_order_yn='Y' or b.billing_package_ref is not null)*/  decode(b.billing_package_ref,null,b.future_order_yn,(select across_encounter_yn from bl_package_sub_hdr where package_seq_no = b.billing_package_ref))='Y' and  nvl(a.cont_order_ind,'DO') in ('DO','DR','CO','CR') and ORDER_STATUS IN ( SELECT ORDER_STATUS_CODE   FROM OR_ORDER_STATUS_CODE  WHERE ORDER_STATUS_TYPE <'20') and a.encounter_id != ? order by encounter_id,a.order_id,a.ORD_DATE_TIME desc") ;//8090
				//IN039096
				/*Ends Here*/
			}
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, language_id);
			pstmt.setString( 3, language_id);
			pstmt.setString( 4, language_id);
			pstmt.setString( 5, language_id);
			pstmt.setString( 6, language_id);
			pstmt.setString( 7, language_id);
			pstmt.setString( 8, facility_id) ;		// OR_PRIVILEGE_BY_ORDER 
			pstmt.setString( 9, patient_id) ;		// OR_PRIVILEGE_BY_ORDER 
			pstmt.setString( 10, encounter_id) ;		// Encounter_id 
			if(called_from.equalsIgnoreCase("ExistingOrder"))
			{
				pstmt.setString(11, order_id) ;	
			}
							
			resultSet = pstmt.executeQuery() ;
			if(start > 0)
					for(int i=0;(i<start-1 && resultSet.next());i++);
				while ( start <= end && resultSet!=null && resultSet.next()) 
				{
				 		//String[] record = new String[34];		//IN039096 changed 33 to 34	//8090
						String[] record = new String[36];	//8090
						record[0] = checkForNull(resultSet.getString( "order_category" ),"")   ;
						record[1] = checkForNull(resultSet.getString( "order_category_short_desc" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "Priority_desc" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "patient_class_short_desc" ),"")  ;
						record[4] = checkForNull(resultSet.getString( "patient_class" ),"")  ;
						record[5] = checkForNull(resultSet.getString( "order_line_num" ),"")  ;
						record[6] = checkForNull(resultSet.getString( "patient_id" ),"")  ;
						record[7] = checkForNull(resultSet.getString( "encounter_id" ),"")  ;
						record[8] = checkForNull(resultSet.getString( "order_date_time" ),"")  ;
						record[9] = checkForNull(resultSet.getString( "order_detail" ),"")  ;
						record[10] = checkForNull(resultSet.getString( "Priority" ),"")  ;
						record[11] = checkForNull(resultSet.getString( "source_type" ),"")  ;
						record[12] = checkForNull(resultSet.getString( "source_code" ),"")  ;
						record[13] = checkForNull(resultSet.getString( "order_type_code" ),"")  ;
						record[14] = checkForNull(resultSet.getString( "order_status" ),"")  ;
						record[15] = checkForNull(resultSet.getString( "ord_consent_reqd_yn" ),"")  ;
						record[16] = checkForNull(resultSet.getString( "ord_pract_id" ),"")  ;
						record[17] = checkForNull(resultSet.getString( "date_of_birth" ),"")  ;
						record[18] = checkForNull(resultSet.getString( "sex" ),"")  ;
						record[19] = checkForNull(resultSet.getString( "age" ),"")  ;
						record[20] = checkForNull(resultSet.getString( "cont_order_ind" ),"")  ;
						record[21] = checkForNull(resultSet.getString( "ord_appr_reqd_yn" ),"")  ;
						record[22] = checkForNull(resultSet.getString( "ord_appr_by_user_id" ),"")  ;
						record[23] = checkForNull(resultSet.getString( "ord_consent_reqd_yn" ),"")  ;
						record[24] = checkForNull(resultSet.getString( "ord_consent_by_id" ),"")  ;
						record[25] = checkForNull(resultSet.getString( "order_id" ),"");
						record[26] = checkForNull(resultSet.getString( "bill_yn" ),"");
						record[27] = checkForNull(resultSet.getString( "catalog_code" ),"");
						record[28] = checkForNull(resultSet.getString( "order_qty" ),"");
						record[29] = checkForNull(resultSet.getString( "contr_mod_id" ),"");
						record[30] = checkForNull(resultSet.getString( "start_date_time" ),"");
						record[31] = checkForNull(resultSet.getString( "location_description" ),"");
						//record[32] = checkForNull(resultSet.getString( "unbilled_yn" ),"");
						record[32] = checkForNull(resultSet.getString( "billing_package_ref" ),"");//IN039096.1
						record[33] = checkForNull(resultSet.getString( "fpp_yn" ),"");//8090
						record[34] = checkForNull(resultSet.getString( "fpp_category" ),"");//8090
						record[35] = String.valueOf(total_records);//IN039096.1//8090
						FutureOrder.add(record) ;
						start++;
 				}
				if (resultSet.next())
				{					
					String[] templist = (String[])FutureOrder.get(0);					
					templist[templist.length - 1] = ""+(end+7);
					FutureOrder.set(0,templist);
				}
			//}
		 
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return FutureOrder;
	}

	public void setAll( Hashtable recordSet ) {
		allValues = recordSet;
				
		if(recordSet.containsKey("security_level")){
			setSecurityLevel((String)recordSet.get("security_level"));
		}
		if(recordSet.containsKey("total_recs")){
			setTotalRecs((String)recordSet.get("total_recs"));
		}
		if(recordSet.containsKey("practitioner_id")){
			setPractId((String)recordSet.get("practitioner_id"));
		}
		this.mode = (String)recordSet.get( "mode" );
	
	}

	public HashMap insert()
	{


		HashMap map = new HashMap() ;

        map.put( "result", new Boolean( false ) ) ;
		try
		{
			map = Future_Order();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			map.put( "message", e.getMessage() ) ;
		}

		return map;
	}

public HashMap Future_Order() throws Exception 
{
		HashMap map = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;
		ResultSet resultSet 			= null;
		
		HashMap updt_map1 = new HashMap();
		HashMap sqlMap = new HashMap() ;
		HashMap future_detail	 = new HashMap() ;

		String which_page = "";
		String linerecord="";
		String catalogcode="";
		String patientid="";
		String encounterid="";
		String orderid="";
	//	String temp_order_id = "";  //COMMON-ICN-0122
		String order_line_num = "";
		
		

		int int_total_records = Integer.parseInt(total_records);

		try 
		{
			connection = getConnection() ;
			try
			{	
				sqlMap.put("SQL_OR_FUTURE_ORDER_UPDATE",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_UPDATE") );
				sqlMap.put("SQL_OR_FUTURE_ORDER_LINE_UPDATE",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_LINE_UPDATE") );
				sqlMap.put("SQL_OR_FUTURE_ORDER_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_STATUS") );
				sqlMap.put("SQL_OR_FUTURE_ORDER_REG_COMPLETE",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_REG_COMPLETE") );
				sqlMap.put("SQL_OR_FUTURE_ORDER_SELECT",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_SELECT") );
				sqlMap.put("SQL_OR_BL_WITHOUT_ORDER_CATALOG",OrRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_BILL_ORDER_CATALOG_LINE",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_ORDER_CATALOG_LINE") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE") );
				sqlMap.put("SQL_OR_FUTURE_ORDER_NEW_ORDER",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_NEW_ORDER") );
				sqlMap.put("SQL_OR_FUTURE_ORDER_CANCEL_LINE",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_CANCEL_LINE") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS") );
				sqlMap.put("SQL_OR_ORDER_GET_STATUS_CODE",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_GET_STATUS_CODE") );
				sqlMap.put("SQL_OR_FUTURE_ORDER_UPDATE_ORDER_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_FUTURE_ORDER_UPDATE_ORDER_STATUS") );

			}
			catch(Exception e)
			{
				e.printStackTrace();
				map.put( "message", e.getMessage() ) ;
			}

			for(int i=0; i<int_total_records; i++)
			{
				if(allValues.containsKey("chk"+i))
				{
					if(((String)allValues.get("chk"+i)).equalsIgnoreCase("on"))
					{
						orderid=(String)allValues.get("ord_id"+i);
						/*if(!orderid.equals(temp_order_id))
						{
							no_of_occurance = 0;
							no_of_occurance++;
							temp_order_id = orderid;

							order_line_num = "";
							if(!order_line_num.equals(""))
								order_line_num = order_line_num + "|" +(String)allValues.get("order_line_num"+i);
							else
								order_line_num = (String)allValues.get("order_line_num"+i);
						}
						else
						{
							no_of_occurance++;
							if(!order_line_num.equals(""))
								order_line_num = order_line_num + "|" +(String)allValues.get("order_line_num"+i);
							else
								order_line_num = (String)allValues.get("order_line_num"+i);

						}*/
							
						pstmt1 = connection.prepareStatement( (String)sqlMap.get("SQL_OR_FUTURE_ORDER_SELECT")) ;
						pstmt1.setString(1,(String)allValues.get("ord_id"+i));
						resultSet=pstmt1.executeQuery();
						while(resultSet!=null && resultSet.next())
						{
							linerecord=resultSet.getString("order_line_num");
							catalogcode=resultSet.getString("order_catalog_code");
							patientid=resultSet.getString("patient_id");
							encounterid=resultSet.getString("encounter_id");
							//future_detail.put("billing_revise_dtls"+(String)allValues.get("ord_id"+i)+linerecord,orderEntryBillBean.getOrderBillDtls(((String)allValues.get("p_patient_id"))+((String)allValues.get("p_encounter_id"))+catalogcode));
						}
						closeStatement( pstmt1) ;
						closeResultSet( resultSet ) ;
						
						if(!FutureOrder.containsKey((((String)allValues.get("ord_id"+i))+(String)allValues.get("order_line_num"+i))))
						{
							future_detail = new HashMap();
							future_detail.put("order_id",(String)allValues.get("ord_id"+i));		
							future_detail.put("order_id"+orderid,no_of_occurance);		
							future_detail.put("billing_revise_dtls"+orderid+(String)allValues.get("order_line_num"+i),orderEntryBillBean.getOrderBillDtls(((String)allValues.get("p_patient_id"))+((String)allValues.get("p_encounter_id"))+(String)allValues.get("catalog_code"+i)));
							future_detail.put("servicepanelind",(String)allValues.get("servicepanelind"+i));
							future_detail.put("servicepanelcode",(String)allValues.get("servicepanelcode"+i));
							future_detail.put("incl_excl_action",(String)allValues.get("incl_excl_action"+i));
							future_detail.put("incl_excl_action_reason",(String)allValues.get("incl_excl_action_reason"+i));
							future_detail.put("bill_yn",(String)allValues.get("bill_yn"+i));					   
							future_detail.put("contr_mod_id",(String)allValues.get("contr_mod_id"+i));					   
							future_detail.put("order_line_num",(String)allValues.get("order_line_num"+i));			   
							future_detail.put("catalog_code",(String)allValues.get("catalog_code"+i));			   
							future_detail.put("catalog_desc",(String)allValues.get("catalog_desc"+i));			   
							future_detail.put("ord_pract_id",(String)allValues.get("ord_pract_id"+i));					   
							future_detail.put("quantity",(String)allValues.get("quantity"+i));					   
							future_detail.put("start_date_time",(String)allValues.get("start_date_time"+i));				   
							future_detail.put("order_line_num"+orderid,order_line_num);		
							future_detail.put("billing_package_ref",allValues.get("billing_package_ref"+i));//IN039096	
							FutureOrder.put((orderid+(String)allValues.get("order_line_num"+i)),future_detail);
							cnt++;
						}
					}
					else
					{
						if(FutureOrder.containsKey(((String)allValues.get("ord_id"+i))+((String)allValues.get("order_line_num"+i))))
						{
							FutureOrder.remove(((String)allValues.get("ord_id"+i))+((String)allValues.get("order_line_num"+i)));
						}
					}
				}
			}
			updt_map1.put("source","future_order");
			updt_map1.put( "totalCount"		  , ""+cnt);
			updt_map1.put( "locale"		  , ""+language_id);
			updt_map1.put("future_value",FutureOrder);
			updt_map1.put("which_page",which_page);
			updt_map1.put( "login_by_id",login_by_id ) ;
			updt_map1.put( "login_at_ws_no",login_at_ws_no ) ;
			updt_map1.put( "login_facility_id",login_facility_id ) ;
			updt_map1.put( "p_patient_class",(String)allValues.get("p_patient_class") ) ;
			updt_map1.put( "p_patient_id",(String)allValues.get("p_patient_id")) ;
			updt_map1.put( "p_episode_id",(String)allValues.get("p_episode_id")) ;
			updt_map1.put( "p_episode_visit_num",(String)allValues.get("p_episode_visit_num")) ;
			updt_map1.put( "p_source_type",(String)allValues.get("p_source_type")) ;
			updt_map1.put( "p_source_code",(String)allValues.get("p_source_code")) ;
			updt_map1.put( "p_encounter_id",(String)allValues.get("p_encounter_id")) ;

			
			try 
			{
				updt_map1.put( "properties", getProperties() );
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_CANCEL_DISCONTINUE_JNDI"), ORCancelDiscontinueOrderHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= updt_map1;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= updt_map1.getClass();
					paramArray[1]	= sqlMap.getClass();
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				argArray	= null;
				paramArray	= null;
				if(((Boolean) map.get( "result" )).booleanValue())
				{
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}
				else
				{
					map.put( "message",  (String) map.get( "message" )) ;
				}
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);

			} 
			catch(Exception e) 
			{
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} 
			finally 
			{
				clear();			
			}
		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeStatement( pstmt ) ;
			closeStatement( pstmt1) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection);
		}
		map.put("traceVal", traceVals.toString());
		return map;
	}

	public HashMap validate() throws Exception 
	{
		//Connection connection 		= null;
		//PreparedStatement pstmt 	= null;
		//ResultSet resultSet 		= null;

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;

		return map ;
	}

	public ArrayList getPlaceOrderDefault(String order_catalog_code,String patient_class) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList PlaceOrderDefault = new ArrayList() ;
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_DEFAULT"));
				pstmt.setString(1, language_id);
				pstmt.setString(2, language_id);
				pstmt.setString(3, checkForNull(order_catalog_code.trim(),""));
				pstmt.setString(4, checkForNull(patient_class.trim(),""));
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )			// Only one record per code
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[10];
						record[0] = checkForNull(resultSet.getString( "freq_code" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "durn_value" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "durn_type" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "max_durn_value" ),"")  ;
						record[4] = checkForNull(resultSet.getString( "max_durn_type" ),"")  ;
						record[5] = checkForNull(resultSet.getString( "chk_for_max_durn_action" ),"")  ;
						record[6] = checkForNull(resultSet.getString( "prompt_msg" ),"")  ;
						record[7] = checkForNull(resultSet.getString( "item_narration" ),"")  ;
						record[8] = checkForNull(resultSet.getString( "qty_value" ),"")  ;
						record[9] = checkForNull(resultSet.getString( "qty_uom" ),"")  ;
						PlaceOrderDefault.add(record) ;
					}
				}
			}catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return PlaceOrderDefault;
	}	 // End of the getPlaceOrderDefault

	public synchronized boolean  doSync(Hashtable request) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;
		ResultSet resultSet 			= null;
		try
		{
			HashMap future_detail	 = new HashMap() ;
			//COMMON-ICN-0122  Start
			//String which_page = ""; 
			//String linerecord="";
			//String catalogcode="";
			//String patientid="";
			//String encounterid="";
			//COMMON-ICN-0122 End.
			String orderid="";
		//	String temp_order_id = "";//51003
			String order_line_num = "";
			allValues = request;
			if(request.containsKey("total_recs"))
			{
				setTotalRecs((String)request.get("total_recs"));
			}
			int int_total_records = Integer.parseInt(total_records);
			for(int i=0; i<int_total_records; i++)
			{
				if(allValues.containsKey("chk"+i))
				{
					orderid=(String)allValues.get("ord_id"+i);
					if(((String)allValues.get("chk"+i)).equalsIgnoreCase("on"))
					{
						
						order_line_num = (String)allValues.get("order_line_num"+i);							
						
						if(!FutureOrder.containsKey(((orderid)+((String)allValues.get("order_line_num"+i)))))
						{
							future_detail = new HashMap();
							future_detail.put("order_id",(String)allValues.get("ord_id"+i));		
							//future_detail.put("order_id"+orderid,no_of_occurance);
							future_detail.put("billing_revise_dtls"+orderid+(String)allValues.get("order_line_num"+i),orderEntryBillBean.getOrderBillDtls(((String)allValues.get("p_patient_id"))+((String)allValues.get("p_encounter_id"))+(String)allValues.get("catalog_code"+i)));
							future_detail.put("servicepanelind",(String)allValues.get("servicepanelind"+i));
							future_detail.put("servicepanelcode",(String)allValues.get("servicepanelcode"+i));
							future_detail.put("incl_excl_action",(String)allValues.get("incl_excl_action"+i));
							future_detail.put("incl_excl_action_reason",(String)allValues.get("incl_excl_action_reason"+i));
							future_detail.put("bill_yn",(String)allValues.get("bill_yn"+i));					   
							future_detail.put("contr_mod_id",(String)allValues.get("contr_mod_id"+i));					   
							future_detail.put("order_line_num",(String)allValues.get("order_line_num"+i));			   
							future_detail.put("catalog_code",(String)allValues.get("catalog_code"+i));			   
							future_detail.put("catalog_desc",(String)allValues.get("catalog_desc"+i));			   
							future_detail.put("ord_pract_id",(String)allValues.get("ord_pract_id"+i));					   
							future_detail.put("quantity",(String)allValues.get("quantity"+i));					   
							future_detail.put("start_date_time",(String)allValues.get("start_date_time"+i));				   
							//future_detail.put("order_line_num"+orderid,order_line_num);		
							FutureOrder.put((orderid)+((String)allValues.get("order_line_num"+i)),future_detail);
							cnt++;
						}
					}
					else
					{
						if(FutureOrder.containsKey((allValues.get("ord_id"+i))+((String)allValues.get("order_line_num"+i))))
						{
							FutureOrder.remove((allValues.get("ord_id"+i))+((String)allValues.get("order_line_num"+i)));
						}
					}
				}
			}
			return true;
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		finally
		{
			closeStatement( pstmt ) ;
			closeStatement( pstmt1) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection);
		}
	}

	public TreeMap getFutureOrder()
	{
		return FutureOrder;
	}

}

 /*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
25/01/2019    	IN068673    	DineshT         25/01/2019    	Ramesh G      	ML-MMOH-CRF-1263
-------------------------------------------------------------------------------------------------------------------------------------
*/
package ePH;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import javax.servlet.*;
import javax.servlet.http.*;

import ePH.Common.* ;
import eCommon.Common.*;
import webbeans.eCommon.*;
 
public class QuotaLimitApprovalOrders extends ePH.Common.PhAdapter implements java.io.Serializable {
	
	//protected  String speciality_qry = "AND (speciality_code IN (SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = ? UNION ALL SELECT speciality_code FROM am_pract_specialities WHERE facility_id = ? AND practitioner_id = ?) OR ((SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = ord_practitioner_id) = (SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = ?))) ";
	protected  String speciality_qry = "AND speciality_code=? ";
	public String getQuotaLimitApprovalYN(Properties properties, String practitioner_id, String resp_id) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String  quotaLimitAppr_yn= "N";

		try {
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement( "SELECT 'Y' QUOTALIMITYN  FROM OR_REVIEW_USER_CATEGORIES WHERE (PRACTITIONER_ID = ? OR RESP_ID =?) AND QUOTA_LIMIT_YN ='Y'  AND ROWNUM=1") ;
			pstmt.setString( 1, practitioner_id.trim() ) ;
			pstmt.setString( 2, resp_id) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				quotaLimitAppr_yn = resultSet.getString( "QUOTALIMITYN" )  ;
			}

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return quotaLimitAppr_yn;
	}
	public ArrayList getStatusByPriority(Properties properties, String ord_facility, String source_type, String source_code, String practitioner_id, String resp_id, String patientId, String period_from, String period_to, String functionID,String specilityCode) throws Exception {


		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		String sql="";
		

		int srlno =1;
		try {
			if(source_type.equals(" ")) source_type = null;
			if(source_code.equals(" ")) source_code = null;		
			if(patientId.equals(""))	patientId	= null;//IN032329
			if(period_from==null || period_from.equals(" ")) period_from = "";
			if(period_to==null || period_to.equals(" ")) period_to = "";
		
			
			if (!language_id.equals("en")){
				period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
				period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
			}
	
			
			connection			= ConnectionManager.getConnection(properties) ;
			sql="SELECT nvl(a.PRIORITY,'R') PRIORITY,COUNT (*) no_of_rec FROM OR_ORDER_PEND_STATUS_LOG a WHERE a.PEND_STATUS_IND=? and ORDERING_FACILITY_ID=? and substr(a.order_id,1,2)!='CS' and  nvl(a.SOURCE_TYPE,'XX')=NVL(decode((?),'W','N',(?)), nvl(a.source_TYPE,'XX')) AND nvl(a.SOURCE_code,'XX') =NVL((?), nvl(a.source_CODE,'XX')) and a.ORDER_DATE between TO_DATE(?,'dd/mm/yyyy') AND  TO_DATE(?,'dd/mm/yyyy')+.99999   ##FILTER4$$  ##FILTER$$  ##FILTER2$$ Group by nvl(a.PRIORITY,'R') order by decode(nvl(a.PRIORITY,'R'),'S','1','U','2','R','3') ";//IN068673
			if(patientId==null)
			{
				
					//sql=sql.replace("##FILTER4$$"," and (a.source_type != 'R' AND (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N',locn_type),locn_code  FROM ca_pract_by_locn_detail WHERE  facility_id = (?) and practitioner_id = (?)) OR a.source_type = 'R' ) ");//IN068673
					sql=sql.replace("##FILTER4$$"," and (a.source_type != 'R' AND (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N',locn_type),locn_code  FROM ca_pract_by_locn_view WHERE  facility_id = (?) and practitioner_id = (?)) OR a.source_type = 'R' ) ");//IN068673
		
			}
			else 
			{
				
					sql=sql.replace("##FILTER4$$"," and a.patient_id = ? and (a.source_type != 'R' AND (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N',locn_type),locn_code  FROM ca_pract_by_locn_view WHERE  facility_id = (?) and practitioner_id = (?)) OR a.source_type = 'R' ) ");
				//IN068673, ends
			}
			
			if(!"".equals(specilityCode))
				sql=sql.replace("##FILTER$$", speciality_qry);
			else
				sql=sql.replace("##FILTER$$", "");
			
			sql=sql.replace("##FILTER2$$"," AND a.order_category in (SELECT order_category  FROM or_review_user_categories  WHERE (practitioner_id = ?  or resp_id = ?) AND QUOTA_LIMIT_YN = 'Y')  ");
			
			
			pstmt = connection.prepareStatement(sql);
			System.out.println("sql--------->"+sql);
			
			pstmt.setString( srlno++, functionID );			
			pstmt.setString( srlno++, ord_facility.trim() );			
			pstmt.setString( srlno++, source_type );			
			pstmt.setString( srlno++, source_type );			
			pstmt.setString( srlno++, source_code );			
			pstmt.setString( srlno++, period_from) ;			
			pstmt.setString( srlno++, period_to) ;
			System.out.println("--------->"+functionID);
			System.out.println("--------->"+ord_facility.trim() );
			System.out.println("--------->"+source_type);
			System.out.println("--------->"+source_type);
			System.out.println("--------->"+source_code);
			System.out.println("--------->"+period_from);
			System.out.println("--------->"+period_to);
			if(patientId==null)
			{			
					pstmt.setString( srlno++, ord_facility.trim()) ;
					pstmt.setString( srlno++, practitioner_id.trim() ) ;		
					System.out.println("--------->"+ord_facility.trim());
					System.out.println("--------->"+practitioner_id.trim());
			}
			else
			{			
					pstmt.setString( srlno++, patientId) ;
					pstmt.setString( srlno++, ord_facility.trim()) ;
					pstmt.setString( srlno++, practitioner_id.trim() ) ;		
					System.out.println("--------->"+patientId);
					System.out.println("--------->"+ord_facility.trim());
					System.out.println("--------->"+practitioner_id.trim());
			}
			/*
			pstmt.setString( srlno++, practitioner_id.trim() );
			pstmt.setString( srlno++, ord_facility.trim() );
			pstmt.setString( srlno++, practitioner_id.trim() );
			pstmt.setString( srlno++, practitioner_id.trim() );
			*/
			if(!"".equals(specilityCode))
				pstmt.setString( srlno++, specilityCode.trim() );
			pstmt.setString( srlno++, practitioner_id.trim() ) ;
			pstmt.setString( srlno++, resp_id.trim() ) ;
			
			resultSet = pstmt.executeQuery() ;
			int abc=0;
			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[4];
				record[0] = resultSet.getString( "PRIORITY" )  ;
				record[1] = resultSet.getString( "no_of_rec" )  ;
				record[2] = resultSet.getString( "PRIORITY" )  ;
				abc++;	
				OrderCat.add(record) ;
			}


		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return OrderCat;
	}
	
	public ArrayList	getStatusByDetail( String ord_facility, String source_type, String source_code, String practitioner_id, String resp_id, String priority, String ord_cat, String order_by, String patientId, String period_from, String period_to, int start, int end,String functionID,String specilityCode) throws Exception {


		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		String sql="";
		//String priv_appl_yn = "N";
		//priv_appl_yn = (String)getPrivAuthoriseYn();
		int reccount = 0;
		
 		

		try {
			
			
			if(source_type.equals(" ")) source_type = null;
			if(source_code.equals(" ")) source_code = null;
			if(priority.equals(" ")) priority = null;
			//priority = "";
			if(ord_cat.equals(" ")) ord_cat = null;
			if(order_by.equals(" ")) order_by = null;
			//if(patientId==null || patientId.equals(" ")) patientId = "";//IN032329
			if(patientId.equals(""))	patientId	= null;//IN032329
			if(period_from==null || period_from.equals(" ")) period_from = "";
			if(period_to==null || period_to.equals(" ")) period_to = "";
			
			if (!language_id.equals("en")){
			period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
			period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
			}
			/* Thai date validations end 14/02/2007*/
			connection			= getConnection() ;
			sql = "SELECT   a.order_category order_category,         or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.priority priority_desc,am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,a.order_id order_id,a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR ( ORDER_DATE,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id, a.order_type, ?) order_detail,DECODE (?,'en', patient_name,NVL (patient_name_loc_lang, patient_name)) patient_name, a.source_type source_type, a.source_code source_code, a.priority priority, a.order_type order_type,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner (a.ord_pract_id,?,'1') ordering_pract_name,sex, date_of_birth,get_age (date_of_birth) age,NVL (a.cont_order_ind, 'DO') cont_order_ind,c.ord_appr_reqd_yn ord_appr_reqd_yn, c.ord_appr_by_user_id ord_appr_by_user_id,c.ord_consent_reqd_yn ord_consent_reqd_yn, c.ord_consent_by_id ord_consent_by_id,c.ORDER_STATUS ORDER_STATUS,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,AM_GET_DESC.AM_speciality(speciality_code,?,'2') speciality_desc,speciality_code  speciality_code,c.order_set_id order_set_id,or_get_appl_task_access_rights ('AMEND_ORDER' ,?,?,     ?,?,c.order_id) AMEND_ORDER_YN,or_get_appl_task_access_rights ('CANCEL_ORDER' ,?,?,?,?,c.order_id) CANCEL_ORDER_YN,C.DISCHARGE_IND,C.ORDERING_FACILITY_ID,c.ORD_PRACT_ID,c.ORD_AUTH_REQD_YN FROM OR_ORDER_PEND_STATUS_LOG a, mp_patient b, or_order c WHERE a.order_id=c.order_id and a.patient_id=c.patient_id and a.PEND_STATUS_IND=?  and a.patient_id=b.patient_id and a.patient_id = NVL (?, a.patient_id) AND a.ordering_facility_id = (?)  AND NVL (a.source_type, 'XX') = NVL (DECODE ((?), 'W', 'N', (?)), NVL (a.source_type, 'XX'))  AND NVL (a.source_code, 'XX') = NVL ((?), NVL (a.source_code, 'XX')) AND NVL (a.priority, 'R') = NVL ((?), NVL (a.priority, 'R')) and a.order_category =nvl((?),a.order_category) ##FILTER4$$  and substr(a.order_id,1,2)!='CS' AND NVL (a.cont_order_ind, 'DO') IN ('CO', 'DO', 'CR', 'DR') AND  ORDER_DATE  BETWEEN TO_DATE (NVL ((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.999 ##FILTER$$  ##FILTER2$$ ORDER BY ORDER_DATE ";//IN041644
			
			if(patientId==null)
			{
					sql=sql.replace("##FILTER4$$"," AND (a.source_type IS NOT NULL and a.source_type!='R' AND (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N',locn_type),locn_code  FROM ca_pract_by_locn_view WHERE facility_id = ? and practitioner_id = (?) ) OR a.source_type = 'R' OR a.source_type IS NULL ) ");//IN068673
			
			}
			else 
			{
					sql=sql.replace("##FILTER4$$"," and a.patient_id = ? AND (a.source_type IS NOT NULL and a.source_type!='R' AND (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N',locn_type),locn_code  FROM ca_pract_by_locn_view WHERE facility_id = ? and practitioner_id = (?) ) OR a.source_type = 'R' OR a.source_type IS NULL ) ");
				
			}
			if(!"".equals(specilityCode))
				sql=sql.replace("##FILTER$$",speciality_qry); 
			else
				sql=sql.replace("##FILTER$$",""); 
			
			sql=sql.replace("##FILTER2$$"," AND a.order_category in (SELECT order_category  FROM or_review_user_categories  WHERE (practitioner_id = ?  or resp_id = ?) AND QUOTA_LIMIT_YN = 'Y')  ");
		
				
			System.out.println("------------------->"+sql);
			pstmt = connection.prepareStatement(sql);

pstmt.setString(++reccount, language_id);
pstmt.setString(++reccount, language_id);
pstmt.setString(++reccount, language_id);
pstmt.setString(++reccount, language_id);
pstmt.setString(++reccount, language_id);
pstmt.setString(++reccount, language_id);
pstmt.setString(++reccount, language_id);			
pstmt.setString(++reccount, language_id);
System.out.println("------------------->"+language_id+"<-----");
System.out.println("------------------->"+language_id+"<-----");
System.out.println("------------------->"+language_id+"<-----");
System.out.println("------------------->"+language_id+"<-----");
System.out.println("------------------->"+language_id+"<-----");
System.out.println("------------------->"+language_id+"<-----");
System.out.println("------------------->"+language_id+"<-----");
System.out.println("------------------->"+language_id+"<-----");			
pstmt.setString(++reccount, resp_id.trim());
pstmt.setString(++reccount, "");
pstmt.setString(++reccount, ord_facility);
pstmt.setString(++reccount, practitioner_id.trim());
System.out.println("------------------->"+ resp_id.trim()+"<-----");
System.out.println("------------------->"+""+"<-----");
System.out.println("------------------->"+ord_facility+"<-----");
System.out.println("------------------->"+practitioner_id.trim()+"<-----");
pstmt.setString(++reccount, resp_id.trim());
pstmt.setString(++reccount, "");
pstmt.setString(++reccount, ord_facility);
pstmt.setString(++reccount, practitioner_id.trim());
System.out.println("------------------->"+ resp_id.trim()+"<-----");
System.out.println("------------------->"+""+"<-----");
System.out.println("------------------->"+ord_facility+"<-----");
System.out.println("------------------->"+practitioner_id.trim()+"<-----");
pstmt.setString(++reccount, functionID);
pstmt.setString(++reccount, patientId);
pstmt.setString(++reccount, ord_facility ) ;
pstmt.setString(++reccount, source_type ) ;
pstmt.setString(++reccount, source_type ) ;
pstmt.setString(++reccount, source_code) ;
pstmt.setString(++reccount, priority) ;
pstmt.setString(++reccount, ord_cat) ;
System.out.println("------------------->"+functionID+"<-----");
System.out.println("------------------->"+patientId+"<-----");
System.out.println("------------------->"+ord_facility+"<-----");
System.out.println("------------------->"+source_type+"<-----");
System.out.println("------------------->"+source_type+"<-----");
System.out.println("------------------->"+source_type+"<-----");
System.out.println("------------------->"+priority+"<-----");
System.out.println("------------------->"+ord_cat+"<-----");
if(patientId==null)
{	
pstmt.setString( ++reccount, ord_facility);
pstmt.setString( ++reccount, practitioner_id.trim() ) ;
System.out.println("------------------->"+ord_facility+"<-----");
System.out.println("------------------->"+ practitioner_id.trim()+"<-----");			
}
else
{	
pstmt.setString( ++reccount, patientId);
pstmt.setString( ++reccount, ord_facility);
pstmt.setString( ++reccount, practitioner_id.trim() ) ;
System.out.println("------------------->"+patientId+"<-----");
System.out.println("------------------->"+ord_facility+"<-----");
System.out.println("------------------->"+practitioner_id.trim()+"<-----");
	
}

pstmt.setString(++reccount, period_from);
pstmt.setString(++reccount, period_to);
System.out.println("------------------->"+period_from+"<-----");
System.out.println("------------------->"+period_to+"<-----");
/*
pstmt.setString(++reccount, practitioner_id.trim() );
pstmt.setString( ++reccount, ord_facility.trim() );
pstmt.setString( ++reccount, practitioner_id.trim() );
pstmt.setString( ++reccount, practitioner_id.trim() );
System.out.println("------------------->"+practitioner_id.trim()+"<-----");
System.out.println("------------------->"+ ord_facility.trim()+"<-----");
System.out.println("------------------->"+practitioner_id.trim()+"<-----");
System.out.println("------------------->"+practitioner_id.trim()+"<-----");
*/
if(!"".equals(specilityCode)){
	pstmt.setString( ++reccount, specilityCode.trim() );
	System.out.println("------------------->"+specilityCode.trim()+"<-----");
}
pstmt.setString( ++reccount, practitioner_id.trim() ) ;
pstmt.setString( ++reccount, resp_id.trim() ) ;
System.out.println("------------------->"+practitioner_id.trim()+"<-----");
System.out.println("------------------->"+resp_id.trim()+"<-----");	
	
//pstmt.setString(++reccount, order_by) ;
//pstmt.setString(++reccount, order_by) ;
System.out.println("------------------->"+order_by+"<-----");
System.out.println("------------------->"+order_by+"<-----");
			resultSet = pstmt.executeQuery() ;

			
				if(start > 0)
					for(int i=0;(i<start-1 && resultSet.next());i++){System.out.println("-----------forloop-->");};
					System.out.println(start+"------------------------------------>"+end);
					System.out.println("------------------------------------>"+resultSet);
				while ( start <= end && resultSet!=null && resultSet.next()) {
					System.out.println("---------------------->"+start);
  				 		//String[] record = new String[37]; //27156 //IN041644
					String[] record = new String[40]; //IN041644
						record[0] = checkForNull(resultSet.getString( "order_category" ),"")   ;
						record[1] = checkForNull(resultSet.getString( "order_category_short_desc" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "Priority_desc" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "patient_class_short_desc" ),"")  ;
						record[4] = checkForNull(resultSet.getString( "patient_class" ),"")  ;
						record[5] = checkForNull(resultSet.getString( "location_description" ),"")  ;
						record[6] = checkForNull(resultSet.getString( "order_id" ),"")  ;
						record[7] = checkForNull(resultSet.getString( "patient_id" ),"")  ;
						record[8] = checkForNull(resultSet.getString( "encounter_id" ),"")  ;
						record[9] = checkForNull(resultSet.getString( "order_date_time" ),"")  ;
						record[10] = checkForNull(resultSet.getString( "order_detail" ),"")  ;
						record[11] = checkForNull(resultSet.getString( "PATIENT_NAME" ),"")  ;
						record[12] = checkForNull(resultSet.getString( "ORDERING_PRACT_NAME" ),"")  ;
						record[13] = checkForNull(resultSet.getString( "Priority" ),"")  ;
						record[14] = checkForNull(resultSet.getString( "source_type" ),"")  ;
						record[15] = checkForNull(resultSet.getString( "source_code" ),"")  ;
						record[16] = checkForNull(resultSet.getString( "order_type" ),"")  ;
						record[17] = checkForNull(resultSet.getString( "order_status" ),"")  ;
						record[18] = checkForNull(resultSet.getString( "ord_consent_reqd_yn" ),"")  ;
						record[19] = checkForNull(resultSet.getString( "patient_class" ),"")  ;
						record[20] = checkForNull(resultSet.getString( "source_type" ),"")  ;
						record[21] = checkForNull(resultSet.getString( "date_of_birth" ),"")  ;
						record[22] = checkForNull(resultSet.getString( "sex" ),"")  ;
						record[23] = checkForNull(resultSet.getString( "age" ),"")  ;
						record[24] = checkForNull(resultSet.getString( "cont_order_ind" ),"")  ;
						record[25] = checkForNull(resultSet.getString( "ord_appr_reqd_yn" ),"")  ;
						record[26] = checkForNull(resultSet.getString( "ord_appr_by_user_id" ),"")  ;
						record[27] = checkForNull(resultSet.getString( "ord_consent_reqd_yn" ),"")  ;
						record[28] = checkForNull(resultSet.getString( "ord_consent_by_id" ),"")  ;
						//record[29] = checkForNull(resultSet.getString( "privilege_yn" ),"");
						record[29] = checkForNull(resultSet.getString( "speciality_desc" ),"");
						record[30] = checkForNull(resultSet.getString( "speciality_code" ),"");
						record[31] = checkForNull(resultSet.getString( "order_set_id" ),"");
						record[34] = checkForNull(resultSet.getString( "AMEND_ORDER_YN" ),"X");
						record[35] = checkForNull(resultSet.getString( "CANCEL_ORDER_YN" ),"X");
						record[36] = checkForNull(resultSet.getString( "DISCHARGE_IND" ),""); //27156
						//IN041644 Starts
						record[37] = checkForNull(resultSet.getString( "ORDERING_FACILITY_ID" ),""); 
						record[38] = checkForNull(resultSet.getString( "ORD_PRACT_ID" ),""); 
						record[39] = checkForNull(resultSet.getString( "ORD_AUTH_REQD_YN" ),""); 
						//IN041644 Ends
						//record[30] = String.valueOf(total_records);

						OrderCat.add(record) ;
						start++;
 				}
				if (resultSet.next())
				{
					String[] templist = (String[])OrderCat.get(0);
					templist[33] = ""+(end+7);
					OrderCat.set(0,templist);
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
		System.out.println("----------------------------------------------------->"+OrderCat.size());
		return OrderCat;
	}
	public String getPractSpecCode(String pract_id) throws Exception
	{
			Connection connection	= null;
			PreparedStatement pstmt = null; 
			ResultSet rs			= null;
			String pract_spec_code="";
			try
			  {
				connection  = getConnection();
				pstmt = connection.prepareStatement("select primary_speciality_code pract_spec_code from am_practitioner where practitioner_id=?");
				pstmt.setString(1,(String)pract_id);
				rs	  =pstmt.executeQuery();
				while(rs != null && rs.next())
				{
					pract_spec_code = rs.getString("pract_spec_code");
				}
			}
			catch(Exception e){
					e.printStackTrace() ;
					throw e ;
					}finally {
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}

			return pract_spec_code;

	}
}	
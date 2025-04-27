/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
10/01/2018  IN061893		Kamalakannan G  10/01/2018  Ramesh G 		ML-MMOH-CRF-0545
21/03/2018	IN067069		Kamalakannan G  21/03/2018  Ramesh G 		OR-ML-MMOH-CRF-0545/08
-------------------------------------------------------------------------------------------------------------------------------------
*/
package eOR;
import java.io.* ;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.* ;
import java.sql.*;

import javax.rmi.* ;
import javax.naming.* ;

import eOR.Common.* ;
import eCommon.Common.*;
import eCommon.SingleTableHandler.SingleTableHandlerHome;
import eOR.ORCancelDiscontinueOrder.ORCancelDiscontinueOrderHome;
import eOR.ORSpecimenOrder.*;

import javax.servlet.*;
import javax.servlet.http.*;
public class RejectOrder extends eOR.Common.OrAdapter implements java.io.Serializable {
	protected ArrayList reviewedOrdersdetail	=  null;
	protected ArrayList tabdata	=  new ArrayList();
	
	private   String  checkNull(String args)
	{
		return args==null ||args.equals("")?"":args.trim();
	}
	public void setAll( Hashtable recordSet ) {
		tabdata.clear();
		try{
			int pageRecCnt = (Integer.parseInt((String)recordSet.get("count")));
				for(int index=0;index<pageRecCnt;index++){
				reviewedOrdersdetail	=  new ArrayList();
				if(recordSet.get("select"+(index)).equals("Y")){
					reviewedOrdersdetail.add((String) recordSet.get("order_id"+(index)));
					reviewedOrdersdetail.add(((String)login_by_id).trim());
					reviewedOrdersdetail.add(((String)login_by_id).trim());
					reviewedOrdersdetail.add(((String)login_at_ws_no).trim());
					reviewedOrdersdetail.add(((String)login_facility_id).trim());
					reviewedOrdersdetail.add(((String)login_by_id).trim());
					reviewedOrdersdetail.add(((String)login_at_ws_no).trim());
					reviewedOrdersdetail.add(((String)login_facility_id).trim());
					reviewedOrdersdetail.add((String) recordSet.get("OrderLineNumber"+(index)));
					tabdata.add(reviewedOrdersdetail);
				}
			}
		}catch(Exception e){e.printStackTrace();}
	}
	
	public HashMap insert(){
		HashMap tabDataParam = new HashMap();
		HashMap sqlMap = new HashMap();
		
		try{
			sqlMap.put("InsertSQL",(String)OrRepositoryExt.getOrKeyValue("SQL_REJ_ORD_LB_RD_REVIEWED_INSERT"));
			}

			catch(Exception e){
				System.err.println("exception in insert of ReplaceableOrderableBean.java="+e);
				e.printStackTrace();
			}
		tabDataParam.put("InsertData",tabdata);
		tabDataParam.put("properties",getProperties());
		return getResult(tabDataParam,sqlMap);
	}
	private  HashMap getResult(HashMap tabData , HashMap sqlMap )
	{

		String traceVal = "";
		HashMap map  = new HashMap() ;
	    map.put( "result", new Boolean( false ) ) ;
	    map.put( "flag", "true" ) ;

		try
		{
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
	    	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[]	= new Object[2];
				argArray[0]		= tabData;
				argArray[1]		= sqlMap;
				System.out.println("argArray[0]-->"+argArray[0]);
				System.out.println("argArray[1]-->"+argArray[1]);
	 		Class [] paramArray = new Class[2];
	 		 	paramArray[0]	= tabData.getClass();
				paramArray[1]	= sqlMap.getClass();
			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE") ) ) 
			{
				map = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);	
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) 
			{
				map = (java.util.HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);	
				
			}
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
					argArray	= null;
					paramArray	= null;
			String message = (String)map.get("msgid");
			boolean result = ((Boolean) map.get("result")).booleanValue() ;
		    if( result ) 
			{
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"SM") ) ;
			}
	        else
			{
				map.put( "result", new Boolean( false ) ) ;
	            if( message.equals( "CODE_ALREADY_EXISTS" ) )
				{
					map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common")) ;
					map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				}
	            else
					map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common")) ;
	        }
			return map;

		}catch(Exception e)
		{
			System.out.println( "Error Calling EJB :" + e ) ;
			map.put( "message", e.getMessage() );
			e.printStackTrace() ;
			return map ;
		}
		finally
		{
			clear();
			map.put("traceVal",traceVal);
			System.out.println(map.get("traceVal"));
		 }

	}	
	
	public ArrayList getRejectedOrderResult(String patient_id,String from_date,String to_date,String ordcat,String ca_practitioner_id,String practitioner_type,String status,int startIndex,int endIndex) throws Exception
	{
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		int start = startIndex;
		int end = endIndex;
		int cnt =0;
		ArrayList rejectedOrdersList	= new ArrayList() ;
		if(patient_id.equals(" ") || patient_id.equals("null")) patient_id = "";
		if(from_date.equals(" ") || from_date.equals("null")) from_date = "";
		if(to_date.equals(" ") || to_date.equals("null")) to_date = "";
		if (!language_id.equals("en"))
		{
			from_date=com.ehis.util.DateUtils.convertDate(from_date,"DMYHM",language_id,"en");
			to_date=com.ehis.util.DateUtils.convertDate(to_date,"DMYHM",language_id,"en");
		}
		try{
			connection = getConnection();
			String sql   = "";
			
			//sql="SELECT a.order_type_code order_type_code, b.order_id order_id,a.patient_id patient_id, a.encounter_id encounter_id,or_get_order_catalog (a.order_id,a.order_type_code,?,?,b.order_line_num)catalog_desc,accession_num, a.ord_cosign_reqd_yn ord_cosign_reqd_yn,get_age (c.date_of_birth) age, c.sex sex,DECODE (?,?, c.patient_name,NVL (c.patient_name_loc_lang, c.patient_name)) patient_name,b.order_catalog_code order_catalog_code,a.ordering_facility_id ordering_facility_id, am_get_desc.AM_PRACTITIONER(b.CAN_PRACT_ID,'en','1') rej_pract_name,b.can_line_reason reject_reason, to_char(b.can_date_time,'DD/MM/YYYY HH24:MI') reject_date_time, am_get_desc.am_practitioner (b.can_pract_id,'en','1') rej_pract_name,b.can_pract_id, attend_practitioner_id,a.ord_pract_id,b.order_line_num order_line_num,a.source_type,a.source_code,b.ADDED_MODULE_ID FROM or_order a, or_order_line b, mp_patient c,pr_encounter d WHERE a.patient_id = c.patient_id AND a.order_id = b.order_id AND b.start_date_time BETWEEN TO_DATE (?,'dd/mm/yyyy hh24:mi')AND TO_DATE (?,'dd/mm/yyyy hh24:mi') &&ORDCAT## AND b.order_line_status = ? AND 'N' = NVL ((SELECT 'Y' FROM rej_ord_lb_rd_reviewed WHERE order_id = a.order_id and order_line_num = b.order_line_num), 'N') AND a.encounter_id = d.encounter_id AND EXISTS (SELECT locn_code FROM ca_pract_by_locn_view WHERE facility_id = a.ordering_facility_id AND practitioner_id = ? AND LOCN_TYPE = DECODE(a.source_type,'N','W',a.source_type) AND locn_code = a.source_code)&&PATIENTID## ORDER BY reject_date_time DESC";// commented for IN067069
			sql="SELECT a.order_type_code order_type_code, b.order_id order_id,a.patient_id patient_id, a.encounter_id encounter_id,or_get_order_catalog (a.order_id,a.order_type_code,?,?,b.order_line_num,'','REJ_ORDERS_RD_LB')catalog_desc,accession_num, a.ord_cosign_reqd_yn ord_cosign_reqd_yn,get_age (c.date_of_birth) age, c.sex sex,DECODE (?,?, c.patient_name,NVL (c.patient_name_loc_lang, c.patient_name)) patient_name,b.order_catalog_code order_catalog_code,a.ordering_facility_id ordering_facility_id, am_get_desc.AM_PRACTITIONER(b.CAN_PRACT_ID,'en','1') rej_pract_name,b.can_line_reason reject_reason, to_char(b.can_date_time,'DD/MM/YYYY HH24:MI') reject_date_time, am_get_desc.am_practitioner (b.can_pract_id,'en','1') rej_pract_name,b.can_pract_id, attend_practitioner_id,a.ord_pract_id,b.order_line_num order_line_num,a.source_type,a.source_code,b.ADDED_MODULE_ID FROM or_order a, or_order_line b, mp_patient c,pr_encounter d WHERE a.patient_id = c.patient_id AND a.order_id = b.order_id AND b.can_date_time BETWEEN TO_DATE (?,'dd/mm/yyyy hh24:mi')AND TO_DATE (?,'dd/mm/yyyy hh24:mi') &&ORDCAT## AND b.order_line_status = ? AND 'N' = NVL ((SELECT 'Y' FROM rej_ord_lb_rd_reviewed WHERE order_id = a.order_id and order_line_num = b.order_line_num), 'N') AND a.encounter_id = d.encounter_id AND EXISTS (SELECT locn_code FROM ca_pract_by_locn_view WHERE facility_id = a.ordering_facility_id AND practitioner_id = ? AND LOCN_TYPE = DECODE(a.source_type,'N','W',a.source_type) AND locn_code = a.source_code)&&PATIENTID## ORDER BY reject_date_time DESC";//IN067069 added filter in orderdesc for direct rejection
			if(!ordcat.equals(""))
				{
					sql = sql.replace("&&ORDCAT##" , " AND b.order_category = ? ");		// PER0409
				}
				else
				{
					sql = sql.replace("&&ORDCAT##" , " ");
				}
			
			if(!patient_id.equals(""))
				{
					sql = sql.replace("&&PATIENTID##" , " AND a.patient_id = ? ");		// PER0409
				}
				else
				{
					sql = sql.replace("&&PATIENTID##" , " ");
				}
			pstmt = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , checkNull(practitioner_type) ) ; 
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , language_id);
			pstmt.setString( ++cnt , checkNull(from_date)) ; 
			pstmt.setString( ++cnt , checkNull(to_date) ) ;
			pstmt.setString( ++cnt , checkNull(ordcat));
			pstmt.setString( ++cnt , checkNull(status));
			pstmt.setString( ++cnt , checkNull(ca_practitioner_id));


			if(!patient_id.equals(""))
			{
				pstmt.setString( ++cnt , checkNull(patient_id) ) ;  
			}
			resultSet = pstmt.executeQuery();
			if(resultSet!=null) {		
			
			if(start > 0)
				for(int i=0;(i<start-1 && resultSet.next());i++);

			while(start <= end && resultSet != null && resultSet.next() ) 
			{
						ArrayList table_rows = new ArrayList();
				/*0*/		table_rows.add(checkForNull(resultSet.getString( "ORDER_TYPE_CODE" )));
				/*1*/		table_rows.add(checkForNull(resultSet.getString( "ORDER_ID" )));
				/*2*/		table_rows.add(checkForNull(resultSet.getString( "PATIENT_ID" )));
				/*3*/		table_rows.add(checkForNull(resultSet.getString( "ENCOUNTER_ID" )));
				/*4*/		table_rows.add(checkForNull(resultSet.getString( "catalog_desc" )));
				/*5*/		table_rows.add(checkForNull(resultSet.getString( "accession_num" )));
				/*6*/		table_rows.add(checkForNull(resultSet.getString( "ORD_COSIGN_REQD_YN" )));
				/*7*/		table_rows.add(checkForNull(resultSet.getString( "age" )));
				/*8*/		table_rows.add(checkForNull(resultSet.getString( "sex" )));
				/*9*/		table_rows.add(checkForNull(resultSet.getString( "PATIENT_NAME" )));
				/*10*/		table_rows.add(checkForNull(resultSet.getString( "ORDER_TYPE_CODE" )));
				/*11*/		table_rows.add(checkForNull(resultSet.getString( "ordering_facility_id" )));
				/*12*/		table_rows.add(checkForNull(resultSet.getString( "REJECT_REASON" )));
				/*13*/		table_rows.add(checkForNull(resultSet.getString( "REJECT_DATE_TIME" )));
				/*14*/		table_rows.add(checkForNull(resultSet.getString( "rej_pract_name" )));
				/*15*/  	table_rows.add(checkForNull(resultSet.getString( "can_pract_id" )));
				/*16*/		table_rows.add(checkForNull(resultSet.getString( "attend_practitioner_id" )));
				/*17*/		table_rows.add(checkForNull(resultSet.getString( "ord_pract_id" )));
				/*18*/		table_rows.add(checkForNull(resultSet.getString( "order_line_num" )));
				/*19*/		table_rows.add(checkForNull(resultSet.getString( "source_type" )));
				/*20*/		table_rows.add(checkForNull(resultSet.getString( "source_code" )));
				rejectedOrdersList.add(table_rows);
				start++;
			}
			if (resultSet.next())
			{
				ArrayList templist = (ArrayList) rejectedOrdersList.get(0);
				templist.add(""+(end+10));
				rejectedOrdersList.set(0,templist);
			}
		}
		}
		catch( Exception e )	
		{
				System.err.println( "Error loading values from database SEARCH" ) ;
				e.printStackTrace() ;				
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return rejectedOrdersList;
	}
}

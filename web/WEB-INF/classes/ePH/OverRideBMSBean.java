/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
//import javax.rmi.PortableRemoteObject ;
//import javax.naming.InitialContext ;
import ePH.OverRideBMS.*;

public class OverRideBMSBean extends PhAdapter implements Serializable {

protected HashMap record_status	=	new HashMap();
protected ArrayList all_records	=	new ArrayList();

    public OverRideBMSBean() {
        try {
            doCommon();
        }
        catch(Exception e) {
		e.printStackTrace() ;
		}
    }

	public void clear() {
		super.clear() ;
		record_status	=	new HashMap();
		all_records	=	new ArrayList();
		
	}

	public HashMap getRecordStatus() {
		return this.record_status;
	}

	private void doCommon() throws Exception {
	}


	
	public void setAll( Hashtable recordSet )
		{

		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
    }


	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	public HashMap modify() {
		
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "in modify.." ) ;
		map.put( "flag", "0" ) ;

		//OverRideBMSHome   home=null;
		//OverRideBMSRemote remote=null;
		try {
			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties());
			tabData.put( "facility_id", login_facility_id.trim() );
			tabData.put( "login_by_id", login_by_id.trim() );
			tabData.put( "login_at_ws_no",login_at_ws_no.trim());
			tabData.put( "all_records",all_records);
			tabData.put( "record_status",record_status);

			HashMap sqlMap = new HashMap() ;
			sqlMap.put("SQL_PH_OVERRIDE_BMS_SELECT2",PhRepository.getPhKeyValue("SQL_PH_OVERRIDE_BMS_SELECT2"));
			sqlMap.put("SQL_PH_OVERRIDE_BMS_UPDATE1",PhRepository.getPhKeyValue("SQL_PH_OVERRIDE_BMS_UPDATE1"));
			sqlMap.put("SQL_PH_OVERRIDE_BMS_UPDATE2",PhRepository.getPhKeyValue("SQL_PH_OVERRIDE_BMS_UPDATE2"));			
			sqlMap.put("SQL_OR_ORDER_LINE_PH_UPDATE3",PhRepository.getPhKeyValue("SQL_OR_ORDER_LINE_PH_UPDATE3"));			
			sqlMap.put("SQL_PH_RELEASE_BATCHES_SELECT8",PhRepository.getPhKeyValue("SQL_PH_RELEASE_BATCHES_SELECT8"));						
			sqlMap.put("SQL_PH_OVERRIDE_BMS_UPDATE3",PhRepository.getPhKeyValue("SQL_PH_OVERRIDE_BMS_UPDATE3"));
			
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_OVERRIDE_BMS") ) ;

			home  = (OverRideBMSHome) PortableRemoteObject.narrow( object, OverRideBMSHome.class ) ;
			remote = home.create() ;

			HashMap result = remote.modify( tabData, sqlMap ) ;*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_OVERRIDE_BMS" ),OverRideBMSHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);


				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); ;
				paramArray[1] = sqlMap.getClass();

				HashMap result = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
//map.put( "message", getMessage(getLanguageId(),(String) map.get( "message" ),"PH") ) ;

			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
				//map.put( "message", getMessage((String) result.get( "msgid" )) ) ;
				map.put("flag","0");
			}
			else
			{
				map.put( "message", result.get("msgid") ) ;
				map.put("flag","0");
			}

		} catch(Exception e){
			e.printStackTrace() ;
		}

		return map;
	}

	public ArrayList getDispLocns() {
		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		ArrayList dispLocns			= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_WS_TS_SELECT_DISP_LOCN" )) ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2,getLanguageId());
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				dispLocns.add(resultSet.getString("DISP_LOCN_CODE"));
				dispLocns.add(resultSet.getString("SHORT_DESC"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
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
		return dispLocns;
	}

	public String getPatientIDLength(){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pat_txt_length	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT1") ) ;
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				pat_txt_length	=	checkForNull(resultSet.getString("PATIENT_ID_LENGTH"));
			}						
		}catch(Exception e){
				pat_txt_length	=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return pat_txt_length;	
	}

public ArrayList getDispDetails(String order_id,String ord_line_no){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	drug_desc		=	null ;
		String	disp_qty		=	null ;
		String  disp_uom		=	null ;
		ArrayList result		=	new ArrayList();
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_OVERRIDE_BMS_SELECT3") ) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,ord_line_no);
				pstmt.setString(3,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				drug_desc		=	checkForNull(resultSet.getString("DRUG_DESC"));
				disp_qty		=	checkForNull(resultSet.getString("DISP_QTY"));
				disp_uom		=	checkForNull(resultSet.getString("DISP_UOM_CODE"));

				result.add(drug_desc);		
				result.add(disp_qty);
				result.add(disp_uom);
			}						
		}catch(Exception e){
			e.printStackTrace() ;
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return result;	
}

public String getPresStrength(String drug_code,String pres_qty) {
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pres_strength	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_OVERRIDE_BMS_SELECT4") ) ;
			pstmt.setString(1,drug_code);
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				pres_strength	=	Integer.parseInt(checkForNull(resultSet.getString("STRENGTH_VALUE")))*Integer.parseInt(pres_qty)+" ";
				pres_strength	= pres_strength +	checkForNull(resultSet.getString("STRENGTH_UOM"));
			}						
		}catch(Exception e){
				pres_strength	=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){es.printStackTrace();
			}
		}
		return pres_strength;	
}

//---------------------------------OverRideBMS Reason------------------------------------------------

public ArrayList getReasonCode() 
	 {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList ReasonCode = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_MEDN_TRN_REASON_SELECT1" )) ;

		/*	pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_WS_TS_SELECT_DISP_LOCN" )) ;

			pstmt = connection.prepareStatement("SELECT reason_code,reason_desc FROM ph_medn_trn_reason WHERE appl_trn_type='CO' AND eff_status='E' order by reason_desc" ) ;
		*/
			
    		pstmt.setString(1, getLanguageId());
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				HashMap rec		=	new HashMap();
				String code,desc;
                code					=	resultSet.getString("reason_code");
				desc					=	resultSet.getString("reason_desc");
				rec.put("code",code);
				rec.put("desc",desc);
				ReasonCode.add(rec);

			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
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
   
		return ReasonCode;
	}


	public ArrayList getBMSRecords(String dt_from, String dt_to,String disp_locn,String from,String to,String disp_code){



		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;   
		ResultSet resultSet_2		=	null;
		ArrayList result			=	new ArrayList();
//changed during PE By Naveen
		/*String	patient_id		=	"";
		String	patient_name		=	"";
		String	order_qty			=	"";
		String  order_uom			=	"";
		String	short_desc			=	"";
		String	disp_qty			=	"";
		String	bal_qty				=	"";
		String	delivered_by		=	"";
		String  order_id			=	"";
		String  order_line_no		=	"";
		String  qty_uom				=	"";
		String	alternate			=	"";
		String	drug_code			=	"";
		String in_formulary_yn		=	"";
		String bal_uom				=	"";*/
		
		

			
		String prevnextlink			= "";
		int query_result_size		= 10;
		int start					= 0 ;
		int end						= 0 ;

		if ( from == null || from.equals(""))
		
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;
		

		if ( to == null || to.equals(""))
			end =query_result_size;
		else

			end = Integer.parseInt( to ) ;
		
		long count=0;
		long i = 0;


		try{
			connection			= getConnection() ;
			//pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_OVERRIDE_BMS_SELECT1") ) ; Commented for incident num:25007
			//Modified Query for getting Patient name and drug name  into thai regarding  incident num 25007==By Sandhya
			//pstmt				= connection.prepareStatement("SELECT   a.order_id, b.order_catalog_code, d.in_formulary_yn,b.order_line_num, a.patient_id, nvl(decode(?,'en',C.PATIENT_NAME,C.PATIENT_NAME_LOC_LANG),C.patient_name)PATIENT_NAME,d.drug_desc, b.order_qty, b.order_uom,(SELECT SUM (disp_qty) FROM ph_disp_dtl  WHERE order_id = a.order_id AND order_line_no = b.order_line_num  AND pres_drug_code = disp_drug_code and REISSUE_REASON_CODE is null) disp_qty,(SELECT MAX (disp_uom_code) FROM ph_disp_dtl  WHERE order_id = b.order_id  AND order_line_no = b.order_line_num  AND pres_drug_code = disp_drug_code) disp_qty_uom,(SELECT SUM (disp_qty) FROM ph_disp_dtl  WHERE order_id = b.order_id  AND order_line_no = b.order_line_num  AND pres_drug_code != disp_drug_code and REISSUE_REASON_CODE is null) alternate, (SELECT bms_qty FROM or_order_line_ph  WHERE order_id = b.order_id  AND order_line_num = b.order_line_num) bal_qty, (SELECT TO_CHAR (sm_convert_date(added_date,?), 'dd/mm/yyyy')  || ' ' || dispensed_by  FROM ph_disp_hdr  WHERE order_id = a.order_id  AND ROWID = (SELECT MAX (ROWID)  FROM ph_disp_hdr  WHERE order_id = a.order_id)) delivered_by , d.stock_uom bal_uom FROM or_order a, or_order_line b, mp_patient c, ph_drug_lang_vw d  WHERE a.order_id = b.order_id  AND b.order_catalog_code = d.drug_code  AND a.patient_id = c.patient_id  AND b.order_line_status NOT IN ('DF', 'IP', 'AL', 'CN', 'DC')  AND b.order_line_status = 'DP'  AND a.order_category = 'PH'  AND TO_DATE (b.modified_date, 'DD/MM/RRRR')  BETWEEN TO_DATE (?, 'DD/MM/RRRR')  AND TO_DATE (?, 'DD/MM/RRRR')  AND a.ordering_facility_id = ?  AND a.performing_deptloc_code = ? AND d.LANGUAGE_ID= ? ORDER BY b.modified_date DESC") ;
//Modified Above Query for getting dispenser name into thai regarding incident num:25317on 2/DEC/2010===By Sandhya
			pstmt				= connection.prepareStatement("SELECT   a.order_id, b.order_catalog_code, d.in_formulary_yn,b.order_line_num, a.patient_id, nvl(decode(?,'en',C.PATIENT_NAME,C.PATIENT_NAME_LOC_LANG),C.patient_name)PATIENT_NAME,d.drug_desc, b.order_qty, b.order_uom,(SELECT SUM (disp_qty) FROM ph_disp_dtl  WHERE order_id = a.order_id AND order_line_no = b.order_line_num  AND pres_drug_code = disp_drug_code and REISSUE_REASON_CODE is null) disp_qty,(SELECT MAX (disp_uom_code) FROM ph_disp_dtl  WHERE order_id = b.order_id  AND order_line_no = b.order_line_num  AND pres_drug_code = disp_drug_code) disp_qty_uom,(SELECT SUM (disp_qty) FROM ph_disp_dtl  WHERE order_id = b.order_id  AND order_line_no = b.order_line_num  AND pres_drug_code != disp_drug_code and REISSUE_REASON_CODE is null) alternate, (SELECT bms_qty FROM or_order_line_ph  WHERE order_id = b.order_id  AND order_line_num = b.order_line_num) bal_qty, (SELECT SM_CONVERT_DATE_2T(added_date,?) || ' ' || (select  APPL_USER_NAME from sm_appl_user_lang_vw where APPL_USER_ID =dispensed_by and    LANGUAGE_ID=?)dispensed_by  FROM ph_disp_hdr  WHERE order_id = a.order_id  AND ROWID = (SELECT MAX (ROWID)  FROM ph_disp_hdr  WHERE order_id = a.order_id)) delivered_by , d.stock_uom bal_uom FROM or_order a, or_order_line b, mp_patient c, ph_drug_lang_vw d  WHERE a.order_id = b.order_id  AND b.order_catalog_code = d.drug_code  AND a.patient_id = c.patient_id  AND b.order_line_status NOT IN ('DF', 'IP', 'AL', 'CN', 'DC')  AND b.order_line_status = 'DP'  AND a.order_category = 'PH'  AND TO_DATE (b.modified_date, 'DD/MM/RRRR')  BETWEEN TO_DATE (?, 'DD/MM/RRRR')  AND TO_DATE (?, 'DD/MM/RRRR')  AND a.ordering_facility_id = ?  AND a.performing_deptloc_code = ? AND d.LANGUAGE_ID= ? ORDER BY b.modified_date DESC") ;
			
			pstmt.setString(1,getLanguageId());			
			pstmt.setString(2,getLanguageId());			
			pstmt.setString(3,getLanguageId());			
			pstmt.setString(4,dt_from);
			pstmt.setString(5,dt_to);
			pstmt.setString(6,login_facility_id.trim());			
			pstmt.setString(7,disp_code);
			pstmt.setString(8,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			
			result.add("link");
			
			while( resultSet != null && resultSet.next() && i <= end+1 ) {
				
					if( start != 1 && (i+1) < start ) {
						i++;
						continue;
					}
					else i++;
					count++ ;
			
					if(i<=end) {
						//order_id			=	checkForNull(resultSet.getString("ORDER_ID"));
						//order_line_no		=	checkForNull(resultSet.getString("ORDER_LINE_NUM"));
						//patient_id			=	checkForNull(resultSet.getString("PATIENT_ID"));
						//patient_name		=	checkForNull(resultSet.getString("PATIENT_NAME"));
						//order_qty			=	checkForNull(resultSet.getString("ORDER_QTY"));
						//order_uom			=	checkForNull(resultSet.getString("ORDER_UOM"));
						//short_desc			=	checkForNull(resultSet.getString("CATALOG_DESC"));
						//disp_qty			=	checkForNull(resultSet.getString("DISP_QTY"));
						//alternate			=	checkForNull(resultSet.getString("ALTERNATE"));
						//bal_qty				=	checkForNull(resultSet.getString("BAL_QTY"));
						//qty_uom				=	checkForNull(resultSet.getString("DISP_QTY_UOM"));
						//delivered_by		=	checkForNull(resultSet.getString("DELIVERED_BY"));
						//drug_code			=	checkForNull(resultSet.getString("ORDER_CATALOG_CODE"));
						//in_formulary_yn		=	checkForNull(resultSet.getString("IN_FORMULARY_YN"));
						//bal_uom				=	checkForNull(resultSet.getString("BAL_UOM"));
					
						
						result.add(checkForNull(resultSet.getString("ORDER_ID")));
						result.add(checkForNull(resultSet.getString("ORDER_LINE_NUM")));
						result.add(checkForNull(resultSet.getString("PATIENT_ID")));
						result.add(checkForNull(resultSet.getString("PATIENT_NAME")));
						result.add(checkForNull(resultSet.getString("DRUG_DESC")));  //Getting from PH_DRUG_LANG_VW
						result.add(checkForNull(resultSet.getString("ORDER_QTY")));
						result.add(checkForNull(resultSet.getString("ORDER_UOM")));
						result.add(checkForNull(resultSet.getString("DISP_QTY")));
						result.add(checkForNull(resultSet.getString("ALTERNATE")));
						result.add(checkForNull(resultSet.getString("BAL_QTY")));
						result.add(checkForNull(resultSet.getString("DISP_QTY_UOM")));
						result.add(checkForNull(resultSet.getString("DELIVERED_BY")));
						result.add(checkForNull(resultSet.getString("ORDER_CATALOG_CODE")));
						result.add(checkForNull(resultSet.getString("IN_FORMULARY_YN")));
						result.add(checkForNull(resultSet.getString("BAL_UOM")));
						
						
					}
				}			
			
			if( start != 1 )
					prevnextlink = prevnextlink + "<td align='right'><a href=\"javascript:storeCheckedRecords();javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 10 )
					prevnextlink = prevnextlink + "<td align='right'><a href=\"javascript:storeCheckedRecords();javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"')\">Next</a>" ;

			if(result!=null)	{
				    result.set(0,prevnextlink);
								 
			}
			

			if(record_status.size()==0) 
				{
					
				resultSet_2	= pstmt.executeQuery();

				
				
				if(resultSet_2 != null )
				{

				while(resultSet_2.next())
					{
					
				/*	record_status.put(checkForNull(resultSet_2.getString("ORDER_ID"))+checkForNull(resultSet_2.getString("ORDER_LINE_NUM")),"Y");
*/
					all_records.add(checkForNull(resultSet_2.getString("ORDER_ID")));
					all_records.add(checkForNull(resultSet_2.getString("ORDER_LINE_NUM")));

				   }
			  }
			}

		}catch(Exception e){
				e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet_2 ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return result;	
	}

	public int getNoOfDecimals() 
	{
		Connection oConnection		    = null;
		ResultSet oResultSet			= null;
		Statement oStatement			= null;
		int  iNoOfDecimals              = 0; 
		
		try 
		{
			oConnection	= getConnection() ;
			oStatement	= oConnection.createStatement();

			oResultSet	= oStatement.executeQuery(" select NO_OF_DECIMALS from st_acc_entity_param");

			if(oResultSet!=null && oResultSet.next())
			{
				iNoOfDecimals = oResultSet.getString("NO_OF_DECIMALS")==null?0:Integer.parseInt(oResultSet.getString("NO_OF_DECIMALS"));
			}
		}catch ( Exception e ) 
		{
			e.printStackTrace() ;
		}
		finally 
		{
			try
			{
				closeResultSet( oResultSet ) ;
				closeStatement( oStatement ) ;
				closeConnection( oConnection ); 
			}
			catch ( Exception e ) 
			{
				e.printStackTrace() ;
			}
		}
		return iNoOfDecimals;
	}

}

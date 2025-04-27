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

public class PhRepMARLabelBean extends PhAdapter implements Serializable {
	ArrayList alOrdersList = new ArrayList();
	HashMap hmPrintList = new HashMap();

	public PhRepMARLabelBean() {
		try {
			doCommon();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void clear() {
		alOrdersList = new ArrayList();
		hmPrintList = new HashMap();
		super.clear() ;
	}

	private void doCommon() throws Exception {
	}

	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}
	// setAll method to set all the values
	public void setAll(Hashtable recordSet){
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
	}

	public HashMap modify() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put("flag","0");
		return map;
	}
	public ArrayList getOrdersList( ){
		return this.alOrdersList;
	}
	public void setOrdersList(ArrayList alOrdersList){
		this.alOrdersList= alOrdersList;
	}
	public void setPrintList(HashMap hmPrintList){
		this.hmPrintList= hmPrintList;
	}
	public HashMap getPrintList( ){
		return this.hmPrintList;
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
		}
		catch(Exception e){
				pat_txt_length	=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return pat_txt_length;	
	} 

	public HashMap getOrderTypePHParam() throws Exception {
        try{
            HashMap hashmap = fetchRecord("SELECT IV_DRUG_FLUID_CONTINUOUS_LG, IV_WITHOUT_ADDITIVES_LG,IV_DRUG_FLUID_INTERMITTENT_LG FROM PH_PARAM_LANG_VW WHERE LANGUAGE_ID = ? ",getLanguageId());
            return hashmap;
        }
        catch(Exception exception){
            exception.printStackTrace();
			throw exception;
        }
    }

	public ArrayList getPatientDetails(String patientid){
        Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList result		= new ArrayList();
        try {
            connection = getConnection() ;

			String sql=PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT8") ;
			pstmt = connection.prepareStatement( sql) ;
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,patientid);
            resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) {
				result.add(resultSet.getString("PATIENT_NAME"));
				result.add(resultSet.getString("SEX"));
				result.add(resultSet.getString("AGE"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			result.add(e.toString());
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
		return result;
	}

	public ArrayList getResult(String patient_id,String disp_date,String source_type,String p_fm_locn_code,String p_to_locn_code,String order_type,String from,String to){		  
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;
		String prevnextlink			= "";

		long i = 0;
		int query_result_size		= 10;
		int start = 1 ;
		int end = 0 ;
		long count=0;

		if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

	     if ( to == null || to.equals(""))
		   end =query_result_size;
		 else
		   end = Integer.parseInt( to ) ;

        alOrdersList =new ArrayList();
		//String p_report_id = "", iv_prep_yn="";  Removed for IN063877
		StringBuffer sql= new StringBuffer();
		try {
			connection = getConnection() ;
			sql.append("SELECT a.patient_id, NVL (DECODE (?, 'en', pat.patient_name, pat.patient_name_loc_lang),  pat.patient_name ) patient_name, b.order_id,d.DRUG_DESC,to_char(b.ORD_DATE_TIME,'dd/mm/yyyy hh24:mi') ORD_DATE_TIME, source_type, (CASE WHEN (a.source_type = 'C' OR a.source_type = 'E') THEN (SELECT short_desc  FROM op_clinic_lang_vw WHERE facility_id = a.ordering_facility_id  AND clinic_code = a.source_code AND language_id = 'en') ELSE (SELECT short_desc FROM ip_nursing_unit_lang_vw WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.source_code       AND language_id = 'en') END) short_desc,   b.order_line_num, b.ORDER_CATALOG_CODE, a.iv_prep_yn, a.iv_prep_yn   FROM or_order a, or_order_line b, or_order_line_ph c, ph_drug_lang_vw d, mp_patient pat  WHERE a.patient_id = pat.patient_id AND a.order_id = b.order_id  AND b.order_id = c.order_id AND b.order_line_num = c.order_line_num AND b.order_catalog_code = d.drug_code AND d.language_id = ? AND b.order_line_status NOT IN ('CN', 'DC', 'HC', 'HD')  AND c.build_mar_yn = 'Y' ");

			if(!disp_date.equals(""))
				sql.append("  AND trunc(a.ord_date_time) = TO_DATE (?, 'dd/mm/yyyy') ");

			if( !source_type.equals("")){
				if( source_type.equals("C")){
					sql.append(" AND decode(a.source_type, null, 'X', a.source_type) IN ('C', 'E','X') ");
					sql.append(" AND a.source_code BETWEEN NVL (?,'!') AND NVL ( ?,'~') ");
				}
				else if(source_type.equals("N")){
					sql.append(" AND a.source_type in ('N','D') ");
					sql.append(" AND a.source_code BETWEEN NVL (?,'!') AND NVL ( ?,'~') ");
				}
			}

			if(!patient_id.equals(""))
				sql.append("  AND pat.patient_id = ? ");

			if(order_type.equals("A"))
				sql.append("  AND (a.iv_prep_yn IN ('1','3','5') OR a.iv_prep_yn IS NULL) ");

			else if(order_type.equals("N"))
				sql.append("  AND a.iv_prep_yn IS NULL ");

			else if(order_type.equals("WA"))
				sql.append("  AND a.iv_prep_yn ='1' ");

			else if(order_type.equals("WO"))
				sql.append("  AND a.iv_prep_yn = '5' ");
			else if(order_type.equals("I"))
				sql.append("  AND a.iv_prep_yn ='3' ");

			sql.append(" ORDER BY  a.patient_id, a.order_id desc,  b.order_line_num");
			pstmt = connection.prepareStatement(sql.toString());
			int icount=1;
			pstmt.setString(icount++,getLanguageId());
			pstmt.setString(icount++,getLanguageId());
			if(!disp_date.equals(""))
				pstmt.setString(icount++,disp_date);
			
			if( !source_type.equals("")) {
				pstmt.setString(icount++,p_fm_locn_code);
				pstmt.setString(icount++,p_to_locn_code);
			}
			if(!patient_id.equals(""))
				pstmt.setString(icount++,patient_id.trim());
			
			resultSet = pstmt.executeQuery() ;
			alOrdersList.add("link"); //0
			while ( resultSet != null && resultSet.next() && i <= end+1) {
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
					count++ ;
				if(i<=end) {
				
					alOrdersList.add(checkForNull(resultSet.getString("patient_id"),"")); //1
					alOrdersList.add(checkForNull(resultSet.getString("patient_name"),"")); //2
					alOrdersList.add(checkForNull(resultSet.getString("order_id"),""));
					alOrdersList.add(checkForNull(resultSet.getString("order_line_num"),""));//4
				
					alOrdersList.add(checkForNull(resultSet.getString("DRUG_DESC"),""));
					alOrdersList.add(checkForNull(resultSet.getString("ORD_DATE_TIME"),""));
					alOrdersList.add(checkForNull(resultSet.getString("source_type"),"")); 
					alOrdersList.add(checkForNull(resultSet.getString("short_desc"),"")); 
					
					alOrdersList.add(checkForNull(resultSet.getString("ORDER_CATALOG_CODE"),""));//9
					alOrdersList.add(checkForNull(resultSet.getString("iv_prep_yn"),"")); //10
					
				/*	iv_prep_yn = checkForNull(resultSet.getString("iv_prep_yn"),"");

					if(iv_prep_yn.equals(""))
						p_report_id = "PHPRMARLBL";
					else if (iv_prep_yn.equals("1"))
						p_report_id = "PHPRMARWALBL";
					else if(iv_prep_yn.equals("3"))
						p_report_id = "PHPRMARINTLBL";
					else if (iv_prep_yn.equals("5"))
						p_report_id = "PHPRMARWOALBL";
				
					alDrugDispList.add(checkForNull(resultSet.getString("order_id"),""));
					alDrugDispList.add(checkForNull(resultSet.getString("order_line_num"),""));
					alDrugDispList.add("Y");
					alDrugDispList.add(p_report_id);*/
				}
			}
			
			//setDrugDispList(alDrugDispList);
			if( start != 1 )
				prevnextlink = prevnextlink + "<td align='right' id='Navigation'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 10 ){
				prevnextlink = prevnextlink + "<td align='right' id='Navigation'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"')\">Next</a>" ;
			}
			if(alOrdersList!=null)	{					
				alOrdersList.set(0,prevnextlink);				
			}
		}
		catch ( Exception e ) {
			System.err.println("getResult====sql===>"+sql);
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return alOrdersList;
	}

	public Boolean getMarLabelPrintyn(){
		String mar_label_print_yn = "N";
		try{
			mar_label_print_yn = (String)fetchRecord("select PRINT_MAR_LABEL_YN from ph_facility_param where facility_id= ?", getLoginFacilityId()).get("PRINT_MAR_LABEL_YN");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(mar_label_print_yn,"N").equals("Y");
	} 
}

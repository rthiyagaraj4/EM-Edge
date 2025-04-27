/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //saved on 29/10/2005 
package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;


public class QueryPresVsDispDrugsBean extends PhAdapter implements Serializable {

protected long total_patients	=	0;
protected long total_orders		=	0;
protected double total_dispensed	=	0;
protected double total_returned	=	0;
protected double total_ordered	=	0;
protected String billingYN		=	"";

    public QueryPresVsDispDrugsBean() {
        try {
            doCommon();
        }
        catch(Exception e) {
			e.printStackTrace();
		}
    }

	public void clear() {
		super.clear() ;
	}

	private void doCommon() throws Exception {
	}

	
	public void setAll( Hashtable recordSet ) {
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;

	}

	public void setTotalOrdered(double total_ordered) {
		this.total_ordered	=	total_ordered;
	}

	public double getTotalOrdered(){
		return this.total_ordered;
	}

	public void setTotalPatients(long total_patients) {
			this.total_patients	=	total_patients;
	}

	public long getTotalPatients(){
		return this.total_patients;
	}

	public void setTotalOrders(long total_orders) {
		this.total_orders = total_orders;
	}

	public long getTotalOrders(){
		return this.total_orders;
	}

	public void setTotalDispensed(double total_dispensed) {
		this.total_dispensed	= total_dispensed;
	}

	public double getTotalDispensed(){
		return this.total_dispensed;
	}

	public void setTotalReturned(double total_returned) {
		this.total_returned = total_returned;
	}

	public double getTotalReturned() {
		return this.total_returned;
	}
	//Added for CRF 430
	public double getTotalPending() {//Added for CRF 430 to get total Pending Quantity
		double quantity;
		quantity=total_ordered-total_dispensed;;
		return quantity>0?quantity:0;
	}
	public double getTotalExcess() {//Added for CRF 430 to get total Excess Quantity
		double quantity;
		quantity=total_dispensed-total_ordered;
		return quantity>0?quantity:0;
	}
    public void setBillingYN(String billingYN) {
		this.billingYN	= billingYN;
	}

	public String getBillingYN(){
		return this.billingYN;
	}

	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	public HashMap modify() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		return map;
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

	public ArrayList getPatientClass(){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT1") ) ;
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
					records.add(resultSet.getString("PATIENT_CLASS"));
					records.add(resultSet.getString("SHORT_DESC"));
			}						
		}
		catch(Exception e){
				records.add(e.toString());
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
		return records;	
	}

	public String isOrInstalled(){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String str="N";

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_OR_INSTALLED") ) ;
			resultSet	= pstmt.executeQuery(); 
			while( resultSet.next() ) {
				str="Y";
			}
		}
		catch(Exception e){
				str="Error";
				e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){es.printStackTrace();
			}
		}
		return str;	
	}

	public ArrayList getDispLocn(String type,String code){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String disp_locn_code	=	"";
		String disp_locn_desc	=	"";
		ArrayList	records		=	new ArrayList();
		try{
			connection			= getConnection() ;
			if (type.equals("N")){
				pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_NURSINGUNIT_DISP_LOCN") ) ;
			}
			else if (type.equals("C")){
				pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_CLINIC_DISP_LOCN") ) ;
			}
			pstmt.setString(1,code);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				disp_locn_code		=	resultSet.getString("DISP_LOCN_CODE");
				disp_locn_desc		=	resultSet.getString("LONG_DESC");
				records.add(disp_locn_code);
				records.add(disp_locn_desc);
			}
		}
		catch(Exception e){
			records.add(e.toString());
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
		return records;	

	}
	//Added for CRF 430 to get all DISPENCE LOCATION for that facility
	public ArrayList getAllDispLocn(){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		//String disp_locn_code	=	"";
		//String disp_locn_desc	=	"";
		ArrayList	records		=	new ArrayList();
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REPORT_DISP_LOCATION") ) ;
			//pstmt				= connection.prepareStatement("SELECT DISP_LOCN_CODE, SHORT_DESC FROM PH_DISP_LOCN_LANG_VW PH_DISP_LOCN WHERE EFF_STATUS='E' and facility_id =? AND LANGUAGE_ID = ? ORDER BY SHORT_DESC");
		
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			HashMap hashmap;
			while( resultSet != null && resultSet.next() ) {
				hashmap = new HashMap();
				hashmap.put("code", CommonAdapter.checkForNull(resultSet.getString("disp_locn_code")));
				hashmap.put("desc", CommonAdapter.checkForNull(resultSet.getString("short_desc")));
				records.add(hashmap);
			}
		}
		catch(Exception e){
			records.add(e.toString());
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
		return records;	
	}

	//Added for CRF 430 to get all Billing Group for that facility
	 public ArrayList getAllBillingGroup(){
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();
     
        try {
            connection = getConnection();
            //preparedstatement = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_REPORT_DISP_LOCATION"));
            pstmt = connection.prepareStatement("Select blng_grp_id,short_desc from bl_blng_grp_lang_vw WHERE LANGUAGE_ID = ? ORDER BY short_desc");
			
	       //pstmt.setString(1,login_facility_id);
		   pstmt.setString(1,getLanguageId());
            HashMap hashmap;
            for(resultset = pstmt.executeQuery();resultset != null && resultset.next(); ){
                hashmap = new HashMap();
                hashmap.put("code", CommonAdapter.checkForNull(resultset.getString(1)));
                hashmap.put("desc", CommonAdapter.checkForNull(resultset.getString(2)));
				arraylist.add(hashmap);
			}

        }
        catch(Exception exception){
            exception.printStackTrace();
			arraylist.add(exception.toString());
           
        }
        finally  {
            try {
                closeResultSet(resultset);
                closeStatement(pstmt);
                closeConnection(connection);
            }
            catch(Exception exception2) {
                exception2.printStackTrace();
            }
        }
        return arraylist;
    }

	public ArrayList getPatientDetails(String id){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_DISP_DRUG_BY_PATIENT_SELECT2") ) ;
			pstmt.setString(1,id);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
					records.add(resultSet.getString("PATIENT_NAME"));
				records.add(resultSet.getString("AGE"));
				records.add(resultSet.getString("GENDER"));
			}
		}
		catch(Exception e){
			records.add(e.toString());
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
		return records;	
	}
	//last 2 parameter(disploc_code,billinggroup_code)  added for  CRF 430
	public ArrayList getDispensedDetails(String route_code,String drug_code,String fm_date, String to_date,String from, String to,String disploc_code, String billinggroup_code,String trade_code) {
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		//PreparedStatement pstmt_1	=	null ;
		PreparedStatement pstmt_2	=	null ;
		PreparedStatement pstmt_3	=	null ;//SKR-SCF-1250
		ResultSet resultSet			=	null ; 
		//ResultSet resultSet_1		=	null ;  
		ResultSet resultSet_2		=	null ;  
		ResultSet resultSet_3		=	null ;//SKR-SCF-1250  
		ArrayList	records		=	new ArrayList();
		String prevnextlink		= "";
		int query_result_size	= 14;
		int start				= 0 ;
		int end					= 0 ;
		ArrayList patients		= new ArrayList();
		ArrayList orders		= new ArrayList();
		double cnt_dispqty		=	0;
		String disp_qty			=	"";
		String ret_qty			=	"";
		long cnt_retqty			=	0;
		String token_no			=	"";
		String daily_seq_num	=	"";
		//SKR-SCF-1250  - start
		String doc_type_code	=   "";
		String doc_no			=   "";
		String sec_key_main	    =   "";
		String blng_grp_id		=   "";
		String patient_id		= "";
		StringBuilder stbSql1 = new StringBuilder();
		boolean flag     = true;
		String blng_grp_id_arr = ""; //SKR-SCF-1250
		String disp_drug_code  = "";//SKR-SCF-1250
		//SKR-SCF-1250  - end
		String patient_class = "";
		StringBuilder stbSql = new StringBuilder();

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
		int z=0;


		try{
			connection			= getConnection() ;

			//pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_DRUG_SELECT1")) ;
			//pstmt_1				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_DRUG_SELECT2"));
			//pstmt_2				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_DRUG_SELECT3"));
		
		 
			if(billingYN.equals("Y")){
				stbSql1.append("select (select short_desc||'~'||blng_grp_id from bl_blng_grp_lang_vw where blng_grp_id = j.blng_grp_id and language_id = ?) blng_grp_id from bl_patient_charges_interface i,bl_patient_charges_folio j  where   i.operating_facility_id=j.operating_facility_id and i.patient_id = j.patient_id and i.episode_type=j.episode_type and i.episode_id=j.episode_id and nvl(i.visit_id,0)=nvl(j.visit_id,0) and i.patient_id=? and i.sec_key_main = ? and i.SERV_ITEM_CODE=?   AND i.sec_key_module_id='PH' AND NVL (i.trx_doc_ref, 'X') = NVL (j.trx_doc_ref, 'X') AND i.trx_doc_ref_line_num = j.trx_doc_ref_line_num and j.TRX_DOC_REF_SEQ_NUM = 0");
				//added for SKR-SCF-1250
				/*pstmt				= connection.prepareStatement("SELECT  f.route_desc, g.route_code, c.patient_id, a.disp_no,a.disp_qty,a.order_id, TO_CHAR (a.added_date, 'dd/mm/RRRR hh24:mi') added_date,b.drug_desc,TO_CHAR (c.ord_date_time, 'dd/mm/RRRR hh24:mi') ord_date_time,d.practitioner_name,ph_order_source (c.source_code,c.patient_class,c.ordering_facility_id,c.source_type,b.language_id) SOURCE,c.patient_id,e.patient_name || ' ,  '|| get_age (e.date_of_birth)|| ',  '|| DECODE (e.sex, 'M', 'male', 'F', 'female', 'unknown') patientdetails,a.order_line_no, b.drug_desc, b.pres_base_uom, b.stock_uom,a.returned_qty,(SELECT c.short_desc FROM bl_patient_charges_interface a, bl_patient_charges_folio b, bl_blng_grp_lang_vw c WHERE a.operating_facility_id = b.operating_facility_id AND a.trx_doc_ref = b.trx_doc_ref AND a.trx_doc_ref_line_num = b.trx_doc_ref_line_num AND a.sec_key_module_id IN ('PH') AND (a.sec_key_main, a.sec_key_line_no) IN ( SELECT DISTINCT doc_type_code || '-' || doc_no,doc_srl_no FROM st_sal_dtl WHERE doc_type_code = h.doc_type AND facility_id = h.facility_id AND doc_no = h.doc_no and doc_srl_no =1 AND ROWNUM < 2) AND b.blng_grp_id = c.blng_grp_id AND language_id = ? AND ROWNUM < 2) blng_grp_id, TOKEN_SERIAL_NO token_no, DAILY_SEQ_NUM,(select i.SHORT_DESC from PH_DISP_LOCN_LANG_VW i where  i.DISP_LOCN_CODE = c.performing_deptloc_code AND i.language_id = ?) disp_desc FROM ph_disp_dtl a, ph_drug_lang_vw b, or_order c, am_practitioner_lang_vw d, mp_patient e,ph_route_lang_vw f,  or_order_line g,ph_disp_hdr h WHERE c.order_id = g.order_id  AND a.disp_drug_code = b.drug_code AND a.order_id = c.order_id AND g.order_catalog_code = a.pres_drug_code AND a.order_line_no = g.order_line_num AND c.ord_pract_id = d.practitioner_id(+) AND c.patient_id = e.patient_id AND c.order_category = 'PH'  AND a.disp_drug_code = ? AND a.added_date BETWEEN TO_DATE (?, 'DD/MM/YYYY')AND TO_DATE (?, 'DD/MM/YYYY') + 0.99999 AND c.patient_id = h.patient_id AND c.patient_class = h.patient_class AND a.disp_no = h.disp_no AND a.facility_id = h.facility_id AND g.route_code = f.route_code AND g.route_code LIKE NVL (?, '%') AND b.language_id = f.language_id AND b.language_id = ? AND d.language_id(+) = ? AND c.performing_deptloc_code = NVL (?, c.performing_deptloc_code) AND doc_no = (SELECT DISTINCT doc_no FROM st_sal_dtl  WHERE (doc_type_code || '-' || doc_no, doc_srl_no) IN (  SELECT a.sec_key_main, a.sec_key_line_no FROM bl_patient_charges_interface a,  bl_patient_charges_folio b WHERE a.operating_facility_id = b.operating_facility_id AND a.trx_doc_ref = b.trx_doc_ref AND a.trx_doc_ref_line_num = b.trx_doc_ref_line_num AND a.sec_key_module_id IN ('PH') AND b.blng_grp_id = NVL (?, b.blng_grp_id)) AND doc_type_code = h.doc_type AND facility_id = h.facility_id AND doc_no = h.doc_no  AND doc_srl_no = 1  and rownum < 2 )ORDER BY disp_desc,g.route_code, c.added_date DESC");*/

				//Removed AND i.sec_key_line_no = 1 regarding incident nnum:26128==10/FEB/2011
				// ADDED Distinct and c.added_date for SKR-SCF-0324 & SRR20056-SCF-7947
				//stbSql.append("SELECT distinct f.route_desc,f.route_color, g.route_code, c.patient_id, a.disp_no, a.disp_qty,a.order_id, TO_CHAR (a.added_date, 'dd/mm/RRRR hh24:mi') added_date,b.drug_desc,TO_CHAR (c.ord_date_time, 'dd/mm/RRRR hh24:mi') ord_date_time,d.practitioner_name,ph_order_source (c.source_code,c.patient_class,c.ordering_facility_id,c.source_type,b.language_id) SOURCE,c.patient_id,nvl( decode(?,'en',e.patient_name, PATIENT_NAME_LOC_LANG),e.patient_name)  || ' ,  '|| get_age (e.date_of_birth) || ',  '|| DECODE (e.sex, 'M', 'male', 'F', 'female', 'unknown') patientdetails,a.order_line_no, b.drug_desc, b.pres_base_uom, b.stock_uom,a.returned_qty , (select short_desc from bl_blng_grp_lang_vw where blng_grp_id = j.blng_grp_id and language_id = ?) blng_grp_id, h.token_serial_no token_no, ('IP'|| lpad(daily_seq_num,'5','0') ) daily_seq_num,c.patient_class,(SELECT disp.short_desc FROM ph_disp_locn_lang_vw disp WHERE disp.disp_locn_code = c.performing_deptloc_code and disp.FACILITY_ID = c.PERFORMING_FACILITY_ID AND disp.language_id = ?) disp_desc, c.added_date FROM ph_disp_hdr h,ph_disp_dtl a,ph_drug_lang_vw b,or_order c,am_practitioner_lang_vw d,mp_patient e,ph_route_lang_vw f,or_order_line g,bl_patient_charges_interface i,bl_patient_charges_folio j ,ph_disp_drug_batch m WHERE a.disp_no = h.disp_no AND c.order_id = g.order_id and a.facility_id=m.facility_id and a.DISP_LOCN_CODE =m.store_code and a.DISP_NO =m.DISP_NO and a.SRL_NO =m.SRL_NO AND a.disp_drug_code = b.drug_code AND a.order_id = c.order_id AND g.order_catalog_code = a.pres_drug_code AND a.order_line_no = g.order_line_num AND c.ord_pract_id = d.practitioner_id(+) AND c.patient_id = e.patient_id AND c.order_category = 'PH' ");
				stbSql.append("SELECT distinct f.route_desc,f.route_color, g.route_code, c.patient_id, a.disp_no, a.disp_qty,a.order_id, TO_CHAR (a.added_date, 'dd/mm/RRRR hh24:mi') added_date,b.drug_desc,TO_CHAR (c.ord_date_time, 'dd/mm/RRRR hh24:mi') ord_date_time,d.practitioner_name,ph_order_source (c.source_code,c.patient_class,c.ordering_facility_id,c.source_type,b.language_id) SOURCE,c.patient_id,nvl( decode(?,'en',e.patient_name, PATIENT_NAME_LOC_LANG),e.patient_name)  || ' ,  '|| get_age (e.date_of_birth) || ',  '|| DECODE (e.sex, 'M', 'male', 'F', 'female', 'unknown') patientdetails,a.order_line_no, b.drug_desc, b.pres_base_uom, b.stock_uom,a.returned_qty , h.token_serial_no token_no, ('IP'|| lpad(daily_seq_num,'5','0') ) daily_seq_num,c.patient_class,(SELECT disp.short_desc FROM ph_disp_locn_lang_vw disp WHERE disp.disp_locn_code = c.performing_deptloc_code and disp.FACILITY_ID = c.PERFORMING_FACILITY_ID AND disp.language_id = ?) disp_desc, c.added_date,doc_no,doc_type,h.patient_id,a.disp_drug_code FROM ph_disp_hdr h,ph_disp_dtl a,ph_drug_lang_vw b,or_order c,am_practitioner_lang_vw d,mp_patient e,ph_route_lang_vw f,or_order_line g,ph_disp_drug_batch m WHERE a.disp_no = h.disp_no AND c.order_id = g.order_id and a.facility_id=m.facility_id and a.DISP_LOCN_CODE =m.store_code and a.DISP_NO =m.DISP_NO and a.SRL_NO =m.SRL_NO AND a.disp_drug_code = b.drug_code AND a.order_id = c.order_id AND g.order_catalog_code = a.pres_drug_code AND a.order_line_no = g.order_line_num AND c.ord_pract_id = d.practitioner_id(+) AND c.patient_id = e.patient_id AND c.order_category = 'PH'");
				//modified for SKR-SCF-1250
				if(!drug_code.equals(""))
					stbSql.append(" AND a.disp_drug_code = ?");
				if(trade_code!=null && !trade_code.equals("")) // trade_code!=null added for SKR-SCF-1261
					stbSql.append(" AND m.trade_id = ?");
				stbSql.append(" AND a.added_date BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY') + 0.99999 AND c.patient_id = h.patient_id AND c.patient_class = h.patient_class AND a.facility_id = h.facility_id AND g.route_code = f.route_code ");
				if(route_code!=null && !route_code.equals("")) // route_code!=null added for SKR-SCF-1261
					stbSql.append(" AND g.route_code = ? "); //modified route_code LIKE for 71095
//				stbSql.append(" AND b.language_id = f.language_id AND b.language_id = ? AND d.language_id(+) = ? AND h.facility_id = i.operating_facility_id(+) AND (h.DOC_TYPE||'-'||h.doc_no)  = i.sec_key_main(+)  AND nvl(i.operating_facility_id,'X') = nvl(j.operating_facility_id,'X') AND nvl(i.trx_doc_ref,'X') = nvl(j.trx_doc_ref,'X')  AND i.trx_doc_ref_line_num = j.trx_doc_ref_line_num(+)  AND i.sec_key_module_id(+) IN ('PH') and j.TRX_DOC_REF_SEQ_NUM(+) = 0 ");
				//modified for SKR-SCF-1250
				stbSql.append(" AND b.language_id = f.language_id AND b.language_id = ? AND d.language_id(+) = ?");
				
				if(disploc_code!=null && !disploc_code.equals("all")) // disploc_code!=null added for SKR-SCF-1261
					stbSql.append(" AND c.performing_deptloc_code = ? ");
				//if(!billinggroup_code.equals("all")){ //commented for SKR-SCF-1250
				//	stbSql.append(" AND j.blng_grp_id = ? ");
				
				stbSql.append("  ORDER BY disp_desc, g.route_code, c.added_date DESC");
	//			System.err.println("stbSql with billing==>"+stbSql);
				pstmt	= connection.prepareStatement(stbSql.toString()); //Query modified to get patient name in Thai for IN26128 --01/02/2011-- priya // ph_disp_locn_lang_vw i to disp and h.facility id to  c.PERFORMING_FACILITY_ID modified for SCF No : 0892 Inc No:[40991] 
				//Seting in parameter
				pstmt_3 = connection.prepareStatement(stbSql1.toString());//added for SKR-SCF-1250
				pstmt.setString(++z,getLanguageId());
				pstmt.setString(++z,getLanguageId());
			//	pstmt.setString(++z,getLanguageId());//commented for SKR-SCF-1250
				if(!drug_code.equals(""))
					pstmt.setString(++z,drug_code);
				if(!trade_code.equals(""))
					pstmt.setString(++z,trade_code);
				pstmt.setString(++z,fm_date);
				pstmt.setString(++z,to_date);
				if(!route_code.equals(""))
					pstmt.setString(++z,route_code);
				pstmt.setString(++z,getLanguageId());
				pstmt.setString(++z,getLanguageId());
				if(!disploc_code.equals("all"))
					pstmt.setString(++z,disploc_code);
				//if(!billinggroup_code.equals("all")) //commented for SKR-SCF-1250
				//	pstmt.setString(++z,billinggroup_code);
			}
			else{//if billing is off
				// ADDED Distinct and c.added_date for SKR-SCF-0324 & SRR20056-SCF-7947
				/*pstmt				= connection.prepareStatement("SELECT   f.route_desc, g.route_code, c.patient_id, a.disp_no, a.disp_qty,a.order_id, TO_CHAR (a.added_date, 'dd/mm/RRRR hh24:mi') added_date,b.drug_desc,TO_CHAR (c.ord_date_time, 'dd/mm/RRRR hh24:mi') ord_date_time,d.practitioner_name,ph_order_source (c.source_code,c.patient_class,c.ordering_facility_id,c.source_type,b.language_id) SOURCE,c.patient_id,e.patient_name|| ' ,  '|| get_age (e.date_of_birth)|| ',  '|| DECODE (e.sex, 'M', 'male', 'F', 'female', 'unknown') patientdetails,a.order_line_no, b.drug_desc, b.pres_base_uom, b.stock_uom,a.returned_qty	, TOKEN_SERIAL_NO token_no, DAILY_SEQ_NUM,(select i.SHORT_DESC from PH_DISP_LOCN_LANG_VW i where  i.DISP_LOCN_CODE = c.performing_deptloc_code AND i.language_id = ?) disp_desc FROM ph_disp_dtl a,ph_drug_lang_vw b,or_order c,am_practitioner_lang_vw d,mp_patient e,ph_route_lang_vw f,or_order_line g,ph_disp_hdr h	 WHERE c.order_id = g.order_id AND a.order_id = c.order_id AND a.disp_drug_code = b.drug_code AND g.order_catalog_code = a.pres_drug_code AND a.order_line_no = g.order_line_num AND c.ord_pract_id = d.practitioner_id(+) AND c.patient_id = e.patient_id AND c.patient_id = h.patient_id AND c.patient_class = h.patient_class AND a.disp_no = h.disp_no and a.FACILITY_ID =h.FACILITY_ID AND c.order_category = 'PH' AND a.disp_drug_code = ? AND a.added_date BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY')+ 0.99999 AND g.route_code = f.route_code AND g.route_code  LIKE NVL (?, '%') AND b.language_id = f.language_id AND b.language_id = ? AND d.language_id(+) = ? AND c.performing_deptloc_code = NVL (?, c.performing_deptloc_code) ORDER BY disp_desc, g.route_code, c.added_date DESC");*/
				stbSql = new StringBuilder();
				stbSql.append("SELECT distinct  f.route_desc,f.route_color, g.route_code, c.patient_id, a.disp_no, a.disp_qty,a.order_id, TO_CHAR (a.added_date, 'dd/mm/RRRR hh24:mi') added_date,b.drug_desc,TO_CHAR (c.ord_date_time, 'dd/mm/RRRR hh24:mi') ord_date_time,d.practitioner_name,ph_order_source (c.source_code,c.patient_class,c.ordering_facility_id,c.source_type,b.language_id) SOURCE,c.patient_id,nvl( decode(?,'en',e.patient_name, PATIENT_NAME_LOC_LANG),e.patient_name)  || ' ,  '|| get_age (e.date_of_birth) || ',  '|| DECODE (e.sex, 'M', 'male', 'F', 'female', 'unknown') patientdetails,a.order_line_no, b.drug_desc, b.pres_base_uom, b.stock_uom,a.returned_qty, TOKEN_SERIAL_NO token_no, ('IP'|| lpad(daily_seq_num,'5','0') ) daily_seq_num,c.patient_class,(SELECT disp.short_desc FROM ph_disp_locn_lang_vw disp WHERE disp.disp_locn_code = c.performing_deptloc_code AND disp.FACILITY_ID = c.PERFORMING_FACILITY_ID AND disp.language_id = ?) disp_desc, c.added_date FROM ph_disp_hdr h, ph_disp_dtl a,ph_drug_lang_vw b,or_order c,am_practitioner_lang_vw d,mp_patient e,ph_route_lang_vw f,or_order_line g,ph_disp_drug_batch m WHERE a.disp_no = h.disp_no AND a.facility_id = h.facility_id and a.facility_id=m.facility_id and a.DISP_LOCN_CODE =m.store_code and a.DISP_NO =m.DISP_NO and a.SRL_NO =m.SRL_NO AND a.order_id = c.order_id AND c.order_id = g.order_id  AND a.disp_drug_code = b.drug_code AND g.order_catalog_code = a.pres_drug_code AND a.order_line_no = g.order_line_num AND c.ord_pract_id = d.practitioner_id(+) AND c.patient_id = e.patient_id AND c.patient_id = h.patient_id AND c.patient_class = h.patient_class AND c.order_category = 'PH'  ");
				if(!drug_code.equals(""))
					stbSql.append(" AND a.disp_drug_code = ?");
				if(!trade_code.equals(""))
					stbSql.append(" AND m.trade_id = ?");
				stbSql.append(" AND a.added_date BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY') + 0.99999 AND g.route_code = f.route_code ");
				if(!route_code.equals(""))
					stbSql.append(" AND g.route_code = ? ");//modified route_code LIKE for 71095
				stbSql.append(" AND b.language_id = f.language_id AND b.language_id = ? AND d.language_id(+) = ? ");
				if(!disploc_code.equals("all"))
					stbSql.append(" AND c.performing_deptloc_code = ? ");
				stbSql.append(" ORDER BY disp_desc, g.route_code, c.added_date DESC");  //Query modified to get patient name in Thai for IN26128 --01/02/2011-- priya // ph_disp_locn_lang_vw i to disp and h.facility id to  c.PERFORMING_FACILITY_ID modified for SCF No : 0892 Inc No:[40991] , Query Modified for Invalid Idntifier Exception for HSA-SCF-0065[IN 050153]
				//Seting in parameter
			//	System.out.println("stbSql without billing"+stbSql);
				pstmt	= connection.prepareStatement(stbSql.toString());
				pstmt.setString(++z,getLanguageId());
				pstmt.setString(++z,getLanguageId());
				if(!drug_code.equals(""))
					pstmt.setString(++z,drug_code);
				if(!trade_code.equals(""))
					pstmt.setString(++z,trade_code);
				pstmt.setString(++z,fm_date);
				pstmt.setString(++z,to_date);
				if(!route_code.equals(""))
					pstmt.setString(++z,route_code);
				pstmt.setString(++z,getLanguageId());
				pstmt.setString(++z,getLanguageId());
				if(!disploc_code.equals("all"))
					pstmt.setString(++z,disploc_code);
			}
			resultSet	= pstmt.executeQuery(); 
			records.add("");
			while( resultSet != null && resultSet.next() && i <= end+1) {

			/*if( start != 1 && (i+1) < start ) { // commented and moved to down for SKR-SCF-1261 
					i++;
					continue;
				}
				else i++;
					count++ ;

				if(i<=end) { */
				//SKR-SCF-1250 - start
					flag = true;
					blng_grp_id = ""; //SKR-SCF-1261
					if(billingYN.equals("Y")){
						blng_grp_id_arr = "";
						blng_grp_id = "";
						disp_drug_code = "";
						flag = true; //SKR-SCF-1261
//						records.add(checkForNull(resultSet.getString("blng_grp_id")));//16//added for CRF 430
						doc_no = resultSet.getString("DOC_NO");
						doc_type_code = resultSet.getString("DOC_TYPE");
						sec_key_main  = doc_type_code+"-"+doc_no ;
						patient_id    = resultSet.getString("PATIENT_ID");
						disp_drug_code = resultSet.getString("disp_drug_code");//SKR-SCF-1250
					if(drug_code==null || drug_code.equals(""))
							drug_code = disp_drug_code;

						pstmt_3.setString(1,getLanguageId());
						pstmt_3.setString(2,patient_id);
						pstmt_3.setString(3,sec_key_main);
						pstmt_3.setString(4,drug_code);
						resultSet_3	= pstmt_3.executeQuery(); 
						if(resultSet_3!=null && resultSet_3.next()){
							blng_grp_id_arr = resultSet_3.getString("blng_grp_id");
							if(blng_grp_id_arr!=null && !blng_grp_id_arr.equals("")){
								blng_grp_id = blng_grp_id_arr.split("~")[1];
							}
						}
System.err.println("QueryPresVsDispDrugsBean.java====blng_grp_id===526===>"+blng_grp_id+"==billinggroup_code====>"+billinggroup_code);
						if(!billinggroup_code.equals("all")){
						if(blng_grp_id.equals(""))
							flag = false;
						else{
							if(billinggroup_code.equals(blng_grp_id)){
								flag = true;
							}
							else
								flag=false;
						}

						blng_grp_id = blng_grp_id_arr.split("~")[0];
						}
						if(blng_grp_id_arr!=null && !blng_grp_id_arr.equals("")){//blng_grp_id_arr addedf or SKR-SCF-1261
							blng_grp_id = blng_grp_id_arr.split("~")[0];
						}
					}
					if(flag){ 				//SKR-SCF-1250 - end
					if( start != 1 && (i+1) < start ) { //SKR-SCF-1261 - start
					i++;
					continue;
					}
					else i++;
					count++ ;

					if(i<=end) { //SKR-SCF-1261 - end
					records.add(resultSet.getString("PATIENTDETAILS"));//1
					records.add(resultSet.getString("DISP_QTY"));//2
					records.add(resultSet.getString("DISP_NO"));//3
					records.add(resultSet.getString("ADDED_DATE"));//4
					records.add(resultSet.getString("ORDER_ID"));//5
					records.add(resultSet.getString("ORD_DATE_TIME"));//6
					records.add(resultSet.getString("PRACTITIONER_NAME"));//7
					records.add(resultSet.getString("SOURCE"));//8
					records.add(resultSet.getString("ORDER_LINE_NO"));//9
					records.add(resultSet.getString("DRUG_DESC"));//10
					records.add(resultSet.getString("DISP_QTY"));//11
					records.add(resultSet.getString("PRES_BASE_UOM"));//12
					records.add(resultSet.getString("STOCK_UOM"));//13
					records.add(resultSet.getString("ROUTE_CODE"));//14
					records.add(resultSet.getString("ROUTE_DESC"));//15
					if(billingYN.equals("Y")){
//						records.add(checkForNull(resultSet.getString("blng_grp_id")));//16//added for CRF 430
										//SKR-SCF-1250 - start
						records.add(blng_grp_id);

					closeResultSet( resultSet_3 ) ;
				//SKR-SCF-1250 - end
					}
					else{
						records.add("");
					}
					daily_seq_num=checkForNull(resultSet.getString("daily_seq_num"));
					token_no=checkForNull(resultSet.getString("token_no"));
					patient_class=checkForNull(resultSet.getString("patient_class"));
					if( daily_seq_num.equals("") && token_no.equals("")){
						records.add(" ");
					}
					else if(patient_class.equals("OP")){
						records.add(token_no);
					}
					else if(patient_class.equals("IP")){
						if( daily_seq_num.equals("") || patient_class.equals(daily_seq_num)){
							records.add(" ");
						}
						else{
							records.add(daily_seq_num);//17
						}
					}
					else{
						records.add(" ");
					}
					records.add(resultSet.getString("disp_desc"));//18
					records.add(checkForNull(resultSet.getString("route_color")));//19  added for CRF RUT-CRF-0034.1[IN:037389]
					records.add(checkForNull(resultSet.getString("PATIENT_ID"))); // 20 patiend id added for SCF No : 0892 Inc No:[40991] 
				}
				}
			}
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next()) {
				if(!patients.contains(resultSet.getString("PATIENT_ID"))) {
					patients.add(resultSet.getString("PATIENT_ID"));
				}

				if(!orders.contains(resultSet.getString("ORDER_ID"))) {
					orders.add(resultSet.getString("ORDER_ID"));
				}
				//	pstmt_1.setString(1,resultSet.getString("DISP_NO"));
				//	pstmt_1.setString(2,login_facility_id);
				//	resultSet_1	=	pstmt_1.executeQuery();
				//	if(resultSet_1!=null && resultSet_1.next()) {
				if( (resultSet.getString("DISP_QTY")==null) || (resultSet.getString("DISP_QTY").equals(""))) {
					disp_qty	=	"0";
				}
				else {
					disp_qty	=	resultSet.getString("DISP_QTY");
				}

				if( (resultSet.getString("returned_qty")==null) || (resultSet.getString("returned_qty").equals(""))) {
					ret_qty	=	"0";
				}
				else {
					ret_qty	=	resultSet.getString("returned_qty");
				}

				cnt_dispqty += Double.parseDouble(disp_qty);  //changed on 12/jan/2010 for decimal value.
				cnt_retqty  += Double.parseDouble(ret_qty);	
				//	}
			}
			//pstmt_2				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_DRUG_SELECT3"));
			stbSql = new StringBuilder();
			z=0;
			stbSql.append("SELECT COUNT (order_id) TOTALORDERS, SUM (order_qty) TOTALORDERED   FROM (SELECT DISTINCT a.order_id, d.order_qty FROM ph_disp_dtl a, ph_drug b, or_order c, or_order_line d,ph_disp_hdr h,ph_disp_drug_batch m WHERE a.disp_drug_code = b.drug_code AND a.order_id = c.order_id   and a.facility_id=m.facility_id and a.DISP_LOCN_CODE =m.store_code and a.DISP_NO =m.DISP_NO and a.SRL_NO =m.SRL_NO  AND d.order_catalog_code = a.pres_drug_code AND a.order_line_no = d.order_line_num   AND c.order_category = 'PH' AND c.order_id = d.order_id ");
			if(!drug_code.equals(""))
				stbSql.append(" AND a.disp_drug_code = ?");
			if(!trade_code.equals(""))
				stbSql.append(" AND m.trade_id = ?");
			stbSql.append(" AND a.added_date BETWEEN TO_DATE (?,'DD/MM/YYYY') AND   TO_DATE (?,'DD/MM/YYYY') + 0.99999 ");
			if(!route_code.equals(""))
				stbSql.append(" AND d.route_code LIKE ? ");
			if(!disploc_code.equals("all"))
				stbSql.append(" AND c.performing_deptloc_code = ? ");
			if(billingYN.equals("Y")){
				stbSql.append(" AND c.patient_id = h.patient_id AND c.patient_class = h.patient_class AND a.disp_no = h.disp_no and a.FACILITY_ID =h.FACILITY_ID AND doc_no =NVL((SELECT DISTINCT doc_no FROM st_sal_dtl WHERE (doc_type_code || '-' || doc_no) IN (SELECT a.sec_key_main FROM bl_patient_charges_interface a, bl_patient_charges_folio b WHERE a.operating_facility_id = b.operating_facility_id AND a.trx_doc_ref = b.trx_doc_ref AND a.trx_doc_ref_line_num =b.trx_doc_ref_line_num AND a.sec_key_module_id IN ('PH') ");
				if(!billinggroup_code.equals("all"))
					stbSql.append(" AND b.blng_grp_id = ? ");
				stbSql.append(" ) AND doc_type_code = h.doc_type AND facility_id = h.facility_id AND doc_no = h.doc_no  AND doc_srl_no = 1  and rownum < 2),doc_no) ");
			}
			stbSql.append(" ) ");
			pstmt_2	= connection.prepareStatement(stbSql.toString());
			if(!drug_code.equals(""))
				pstmt_2.setString(++z,drug_code);
			if(!trade_code.equals(""))
				pstmt_2.setString(++z,trade_code);
			pstmt_2.setString(++z,fm_date);
			pstmt_2.setString(++z,to_date);
			if(!route_code.equals(""))
				pstmt_2.setString(++z,route_code);
			if(!disploc_code.equals("all"))
				pstmt_2.setString(++z,disploc_code);
			if(billingYN.equals("Y") && !billinggroup_code.equals("all"))
				pstmt_2.setString(++z,billinggroup_code);
			resultSet_2	=	pstmt_2.executeQuery();

			if(resultSet_2!=null && resultSet_2.next()) {
				setTotalOrdered(Double.parseDouble(checkForNull(resultSet_2.getString("TOTALORDERED"), "0")));
				setTotalOrders(Integer.parseInt(resultSet_2.getString("TOTALORDERS")));
			}
			setTotalPatients(patients.size());
			setTotalDispensed(cnt_dispqty);
			setTotalReturned(cnt_retqty);
			if( start != 1 )
				prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
				prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"')\">Next</a>" ;

			if(records!=null)	{
				records.set(0,prevnextlink);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet_2 ) ;
				closeStatement( pstmt_2 ) ;
				closeStatement( pstmt_3 ) ; //common-icn-0029
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return records;	
	}

	//code added to check  Billing interface on or of CRE 430
	public String checkforbillinginterface()throws Exception{
		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		ResultSet resultSet			    = null;	
		String bl_interface_yn					= "N";
		try{
			connection = getConnection() ;
			pstmt_select = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT2")) ;
			pstmt_select.setString(1,login_facility_id);
			resultSet				= pstmt_select.executeQuery();
			if (resultSet.next() ) {
				bl_interface_yn=resultSet.getString("BL_INTERFACE_YN");
				if(bl_interface_yn==null){
					bl_interface_yn="N";
				}
			}
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
		finally{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt_select ) ;
			closeConnection( connection );
		}
		return bl_interface_yn;
	}

	public ArrayList getRouteCodes(){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_DISP_DRUG_BY_PATIENT_SELECT5") ) ;
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery();	

			while( resultSet != null && resultSet.next() ) {
				records.add(resultSet.getString("ROUTE_CODE"));
				records.add(resultSet.getString("ROUTE_DESC"));	
				records.add(checkForNull(resultSet.getString("ROUTE_COLOR")));//added for CRF RUT-CRF-0034.1[IN:037389]
			}
		}
		catch(Exception e){
			records.add(e.toString());
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
		return records;	
	}

	//getting system date
	public String getSysdate(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sys_date				= "";
		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54");
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				sys_date	=	resultSet.getString("SYS_DATE");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
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
		return sys_date;
	}

	public ArrayList getRouteCodesForDrug(String drugCode){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_DISP_DRUG_BY_PATIENT_SELECT6") ) ;
			pstmt.setString(1,drugCode);
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				records.add(resultSet.getString("ROUTE_CODE"));
				records.add(resultSet.getString("ROUTE_DESC"));	
				records.add(checkForNull(resultSet.getString("ROUTE_COLOR")));// added for CRF RUT-CRF-0034.1[IN:037389]	
			}
			closeResultSet( resultSet ) ;
		}
		catch(Exception e){
				records.add(e.toString());
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
		return records;	
	}

	public int getNoOfDecimals() {
		Connection oConnection		    = null;
		ResultSet oResultSet			= null;
		Statement oStatement			= null;
		int  iNoOfDecimals              = 0; 
		
		try {
			oConnection	= getConnection() ;
			oStatement	= oConnection.createStatement();
			oResultSet	= oStatement.executeQuery(" select NO_OF_DECIMALS from st_acc_entity_param");
			if(oResultSet!=null && oResultSet.next()){
				iNoOfDecimals = oResultSet.getString("NO_OF_DECIMALS")==null?0:Integer.parseInt(oResultSet.getString("NO_OF_DECIMALS"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oStatement ) ;
				closeConnection( oConnection ); 
			}
			catch ( Exception e ) {
				e.printStackTrace() ;
			}
		}
		return iNoOfDecimals;
	}
}

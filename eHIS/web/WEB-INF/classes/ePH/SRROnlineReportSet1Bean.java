/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //saved on 18.12.2009
package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;

public class SRROnlineReportSet1Bean extends PhAdapter implements Serializable {
	protected ArrayList active_orders		                = null ; 
	protected ArrayList Drug_active_orders		                = null ; 
	private String order_date				                = null ; 
	protected ArrayList active_CertiforReimbursements		= null ; 
	protected ArrayList active_DispLabelRecds		        = null ; 
	protected ArrayList active_MedicationListRecds		    = null ; 
	protected ArrayList active_DispenseSheetListRecds		= null ; 
	protected ArrayList selList = null;
	protected ArrayList selList_disp = null;
	protected ArrayList selList_med = null;
	protected HashMap selMap   = null;

	public SRROnlineReportSet1Bean() {
		try {
			doCommon() ;
			selList = new ArrayList();
			selList_disp = new ArrayList();
			selList_med = new ArrayList();
			selMap = new HashMap();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void doCommon() throws Exception {
	}

	public void setActiveOrders(ArrayList active_order)	{
		this.active_orders	=	(ArrayList)active_order.clone();
	}
	public ArrayList getActiveOrders()	{
		return this.active_orders;
	} 		
   public void setDrugActiveOrders(ArrayList Drug_active_order)	{
		this.Drug_active_orders	=	(ArrayList)Drug_active_order.clone();
	}
	public ArrayList getDrugActiveOrders()	{
		return this.Drug_active_orders;
	} 	

	public void setCertiforReimbursementRecds(ArrayList active_CertiforReimbursement)	{
		this.active_CertiforReimbursements	=	(ArrayList)active_CertiforReimbursement.clone();
	}

	public ArrayList getCertiforReimbursementRecds()	{
		return this.active_CertiforReimbursements;
	}
    
	public void setDispLabelRecds(ArrayList active_DispLabel)	{
		this.active_DispLabelRecds	=	(ArrayList)active_DispLabel.clone();
	}

	public ArrayList getDispLabelRecds()	{
		return this.active_DispLabelRecds;
	} 
	public void setMedicationListRecds(ArrayList active_MedicationList)	{
		this.active_MedicationListRecds	= (ArrayList)active_MedicationList.clone();
	}

	public ArrayList getMedicationListRecds()	{
		return this.active_MedicationListRecds;
	}

	public void setDispenseSheetListRecds(ArrayList active_DispenseSheetList)	{
	
		this.active_DispenseSheetListRecds	= active_DispenseSheetList;
	}

	public ArrayList getDispenseSheetListRecds()	{
		return this.active_DispenseSheetListRecds;

	}

     
	 //setting the order date for Current Rx
	public void setOrderDate(String order_date)	{
		this.order_date	=	order_date;
	}
	public String getOrderDate(){
		return this.order_date;
	}
	public void clear() {
		super.clear() ;
		selList = new ArrayList();
		selMap.clear();
		selList.clear();
		selList_disp.clear();
		selList_med.clear();

	}
	
	// This method is used to retrieve the data depending on the query criteria
	public ArrayList getNarcoTypeApprovalList(String patient_id,String ord_date_time_from,String ord_date_time_to,String p_encounter,String pract_code,String p_fr_pre,String p_to_pre,String locn_type,String locn_code,String p_facility_id,String locale,String drug_code,String p_narcotics,String from,String to)throws Exception{

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;
		long count=0;
		long i = 0;

		if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;
     		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( "SELECT TO_CHAR (a.ord_date_time, 'dd/mm/yyyy hh24:mi') ord_date_time, a.patient_id, encounter_id, a.trn_group_ref, patient_name, drug_desc, e.narco_no FROM or_order a,mp_patient b,or_order_line c, ph_drug_lang_vw d,or_order_line_ph e WHERE a.patient_id = b.patient_id and a.ORDER_CATEGORY ='PH' AND a.order_id = c.order_id AND c.order_id = e.order_id AND c.order_line_num = e.order_line_num AND c.order_catalog_code = d.drug_code  /* AND drug_class = 'N'  */ AND d.language_id = ? and a.trn_group_ref between nvl(?,a.trn_group_ref) and nvl(?,a.trn_group_ref) /* nvl('PHOP00000043895',a.order_id) */ and a.patient_id=nvl(?,a.patient_id ) and trunc(a.ord_date_time) BETWEEN TO_DATE(?,'DD/MM/YYYY') AND  TO_DATE(?,'DD/MM/YYYY') and e.narco_no =nvl(?,narco_no) and a.encounter_id =nvl(?,a.encounter_id)and a.ORD_PRACT_ID =nvl(?,a.ORD_PRACT_ID) and SOURCE_TYPE =nvl(?,SOURCE_TYPE) and SOURCE_CODE =nvl(?,SOURCE_CODE) and c.order_catalog_code =nvl(?,c.order_catalog_code) ORDER BY a.ord_date_time DESC ");

			//Modified Query For getting Patient name into specified language regarding incident nums:25064 on 01/DEC/2010===By Sandhya
			pstmt = connection.prepareStatement( "SELECT TO_CHAR (a.ord_date_time, 'dd/mm/yyyy hh24:mi') ord_date_time, a.patient_id, encounter_id, a.trn_group_ref, nvl( decode(?,'en',b.patient_name, patient_name_loc_lang),patient_name) patient_name, drug_desc, e.narco_no FROM or_order a,mp_patient b,or_order_line c, ph_drug_lang_vw d,or_order_line_ph e WHERE a.patient_id = b.patient_id and a.ORDER_CATEGORY ='PH' AND a.order_id = c.order_id AND c.order_id = e.order_id AND c.order_line_num = e.order_line_num AND c.order_catalog_code = d.drug_code  /* AND drug_class = 'N'  */ AND d.language_id = ? and a.trn_group_ref between nvl(?,a.trn_group_ref) and nvl(?,a.trn_group_ref) /* nvl('PHOP00000043895',a.order_id) */ and a.patient_id=nvl(?,a.patient_id ) and trunc(a.ord_date_time) BETWEEN TO_DATE(?,'DD/MM/YYYY') AND  TO_DATE(?,'DD/MM/YYYY') and e.narco_no =nvl(?,narco_no) and a.encounter_id =nvl(?,a.encounter_id)and a.ORD_PRACT_ID =nvl(?,a.ORD_PRACT_ID) and SOURCE_TYPE =nvl(?,SOURCE_TYPE) and SOURCE_CODE =nvl(?,SOURCE_CODE) and c.order_catalog_code =nvl(?,c.order_catalog_code) ORDER BY a.ord_date_time DESC ");

			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,p_fr_pre);
			pstmt.setString(4,p_to_pre);
			pstmt.setString(5,patient_id);
			pstmt.setString(6,ord_date_time_from);
			pstmt.setString(7,ord_date_time_to);
		    pstmt.setString(8,p_narcotics);
			pstmt.setString(9,p_encounter);
			pstmt.setString(10,pract_code);
			pstmt.setString(11,locn_type);
			pstmt.setString(12,locn_code);
			pstmt.setString(13,drug_code);

			resultSet = pstmt.executeQuery() ;
			records.add("link");
			while ( resultSet.next() && i <= end+1 ){
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
					if(i <= end ) {
			
				String arr[] = new String[12];	
				arr[0]=resultSet.getString("ord_date_time");
				arr[1]=resultSet.getString("narco_no");
				arr[2]=resultSet.getString("drug_desc");
				arr[3]=resultSet.getString("patient_id");
				arr[4]=resultSet.getString("patient_name");
				arr[5]=resultSet.getString("trn_group_ref");
				arr[6]=resultSet.getString("encounter_id");
               	records.add(arr);
				}

			}
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(p_fr_pre)+"','"+(p_to_pre)+"','"+(ord_date_time_from)+"','"+ord_date_time_to+"','"+(p_encounter)+"','"+(pract_code)+"','"+(p_narcotics)+"','"+locn_type+"','"+locn_code+"','"+drug_code+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(p_fr_pre)+"','"+(p_to_pre)+"','"+(ord_date_time_from)+"','"+ord_date_time_to+"','"+(p_encounter)+"','"+(pract_code)+"','"+(p_narcotics)+"','"+locn_type+"','"+locn_code+"','"+drug_code+"')\">Next</a>" ;
				
			records.set(0,prevnextlink);
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
/*   NarcoTypeList desc returns ends here    */

// This method is used to retrieve the data depending on the query criteria
	public ArrayList getTokenList(String p_token_no,String p_token_series_code,String p_patient_id,String prescription_id,String p_disp_locn_code,String p_disp_date_from,String p_disp_date_to,String encounter_id,String pract_code,String locn_type,String locn_code,String p_facility_id,String locale,String p_langue,String from,String to)throws Exception{

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;
		long count=0;
		long i = 0;

          	if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;
		try{

	     	connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT distinct trn_group_ref prescription_id,a.patient_id, a.encounter_id, nvl( decode(?,'en',b.patient_name, patient_name_loc_lang),patient_name) patient_name, short_desc disp_locn,TO_CHAR(ord_date_time, 'dd/mm/yyyy') order_date,d.token_serial_no token_no,TO_CHAR(e.QUEUE_DATE,'dd/mm/yyyy') QUEUE_DATE,e.disp_locn_code,e.token_series_code,a.order_id FROM or_order a, mp_patient b, ph_disp_locn_lang_vw c, ph_ord_for_disp_queue d, ph_disp_queue e WHERE a.patient_id = b.patient_id AND a.performing_deptloc_code = c.disp_locn_code AND c.language_id = ? AND c.facility_id = ? AND d.facility_id = ? AND d.disp_locn_code = a.performing_deptloc_code AND d.queue_shift = '*ALL' AND a.order_id = d.order_id AND d.facility_id = e.facility_id AND d.disp_locn_code = e.disp_locn_code AND d.queue_date = e.queue_date AND d.queue_shift = e.queue_shift AND d.token_series_code = e.token_series_code AND d.token_serial_no = e.token_serial_no AND d.token_series_code = NVL(?, d.token_series_code) AND d.token_serial_no = NVL(?, d.token_serial_no) AND d.disp_locn_code = NVL(?, d.disp_locn_code) AND a.trn_group_ref = NVL(?, a.trn_group_ref) AND trunc(a.ord_date_time) BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY') AND a.patient_id = NVL(?, a.patient_id) AND a.encounter_id = NVL(?, a.encounter_id) AND a.ord_pract_id = NVL(?, a.ord_pract_id) AND a.source_type = NVL(?, a.source_type) AND a.source_code = NVL(?, a.source_code) and e.token_status not in('DF','DP') order by to_date(order_date,'DD/MM/YYYY') desc, to_number(d.token_serial_no) DESC");

			pstmt.setString(1,p_langue.trim());
			pstmt.setString(2,p_langue.trim());
			pstmt.setString(3,p_facility_id.trim());
			pstmt.setString(4,p_facility_id.trim());
			pstmt.setString(5,p_token_series_code.trim());
			pstmt.setString(6,p_token_no.trim());
			pstmt.setString(7,p_disp_locn_code.trim());
			pstmt.setString(8,prescription_id.trim());
			pstmt.setString(9,p_disp_date_from.trim());
			pstmt.setString(10,p_disp_date_to.trim());
		    pstmt.setString(11,p_patient_id.trim());
			pstmt.setString(12,encounter_id.trim());
			pstmt.setString(13,pract_code.trim());
			pstmt.setString(14,locn_type.trim());
			pstmt.setString(15,locn_code.trim());
			resultSet = pstmt.executeQuery() ;
			records.add("link");
			while ( resultSet.next() && i <= end+1 ){


				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
			
					if(i <= end ) {
			
				String arr[] = new String[12];	
				arr[0]=resultSet.getString("PRESCRIPTION_ID");
				arr[1]=resultSet.getString("PATIENT_ID");
				arr[2]=resultSet.getString("ENCOUNTER_ID");
				arr[3]=resultSet.getString("PATIENT_NAME");
				arr[4]=resultSet.getString("DISP_LOCN");
				arr[5]=resultSet.getString("ORDER_DATE");
				arr[6]=resultSet.getString("TOKEN_NO");
				arr[7]=resultSet.getString("QUEUE_DATE");
				arr[8]=resultSet.getString("DISP_LOCN_CODE");
				arr[9]=resultSet.getString("TOKEN_SERIES_CODE");
				arr[10]=resultSet.getString("ORDER_ID");
               	records.add(arr);
				}
			}

			if( start != 1 )
				prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(p_token_no)+"','"+(p_token_series_code)+"','"+(p_patient_id)+"','"+(p_disp_date_from)+"','"+p_disp_date_to+"','"+(encounter_id)+"','"+(pract_code)+"','"+(p_disp_locn_code)+"','"+locn_type+"','"+locn_code+"','"+prescription_id+"','"+p_langue+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
				prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(p_token_no)+"','"+(p_token_series_code)+"','"+(p_patient_id)+"','"+(p_disp_date_from)+"','"+p_disp_date_to+"','"+(encounter_id)+"','"+(pract_code)+"','"+(p_disp_locn_code)+"','"+locn_type+"','"+locn_code+"','"+prescription_id+"','"+p_langue+"')\">Next</a>" ;
				
			records.set(0,prevnextlink);  
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;
		}
        finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return records;  
	}

/*   TokenList desc returns ends here    */

	public ArrayList getBalMednSheetList(String  patient_id,String adr_reported_date_from,String adr_reported_date_to,String prescription_id,String p_token_no,String p_encounter,String pract_code,String p_facility_id,String p_disp_locn_code,String locn_type,String locn_code,String locale,String from,String to)throws Exception{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;
		long count=0;
		long i = 0;
		if ( from == null || from.equals(""))
		start = 1 ;
		else
		start = Integer.parseInt( from  ) ;
		if ( to == null || to.equals(""))
		end =query_result_size;
		else
		end = Integer.parseInt( to ) ;

	    try{
	     	connection = getConnection() ;
	
		pstmt = connection.prepareStatement("SELECT DISTINCT trn_group_ref prescription_id, a.patient_id, a.encounter_id,nvl( decode(?,'en',b.patient_name, patient_name_loc_lang),patient_name) patient_name, TO_CHAR (f.disp_date_time, 'dd/mm/yyyy') disp_date_time,practitioner_name,f.token_serial_no token_daily_seq_no,f.disp_locn_code FROM or_order a,mp_patient b,ph_disp_locn_lang_vw c,(SELECT 'D' stage, order_id, token_serial_no, patient_class, patient_id, facility_id,disp_date_time disp_date_time, disp_locn_code,DISP_NO FROM ph_disp_hdr UNION ALL SELECT 'F' stage, order_id, token_serial_no, patient_class,patient_id, facility_id,dispensed_date_time disp_date_time, disp_locn_code,to_char(DISP_tmp_NO) FROM ph_disp_hdr_tmp) f,(select to_char(DISP_TMP_NO) disp_no,facility_id from ph_disp_dtl_tmp where BMS_QTY>0 union all select  disp_no disp_no,facility_id from ph_disp_dtl disp,or_order_line order_line where disp.ORDER_ID =order_line.ORDER_ID and disp.ORDER_LINE_NO =order_line.ORDER_LINE_NUM and order_line_status ='DP')h,am_practitioner_lang_vw g WHERE a.patient_id = b.patient_id AND a.performing_deptloc_code = c.disp_locn_code AND a.order_id = f.order_id AND a.performing_deptloc_code = f.disp_locn_code AND a.ord_pract_id = g.practitioner_id and f. DISP_NO =h.DISP_NO and f.facility_id =h.facility_id AND g.language_id = ? AND f.facility_id = ? AND c.language_id = ? AND c.facility_id = ?  AND TRUNC (f.disp_date_time) BETWEEN TO_DATE (?,'DD/MM/YYYY') AND TO_DATE (?,'DD/MM/YYYY') + 0.99999 AND a.trn_group_ref = NVL (?, a.trn_group_ref) AND  a.patient_id = NVL (?, a.patient_id) AND NVL (f.token_serial_no, '999999') =NVL (?, NVL (f.token_serial_no, '999999')) and a.patient_class in('OP','XT')AND a.encounter_id = NVL ( ? , a.encounter_id)AND a.source_type =  NVL (?, a.source_type) AND a.source_code = NVL (? , a.source_code) AND a.ord_pract_id = NVL ( ? , a.ord_pract_id) AND f.disp_locn_code = NVL (?, f.disp_locn_code)  ORDER BY disp_date_time DESC, to_number(token_daily_seq_no) desc");

            pstmt.setString(1,locale.trim());
            pstmt.setString(2,locale.trim());
			pstmt.setString(3,p_facility_id.trim());
			pstmt.setString(4,locale.trim());
			pstmt.setString(5,p_facility_id.trim());
			pstmt.setString(6,adr_reported_date_from.trim());
			pstmt.setString(7,adr_reported_date_to.trim());
			pstmt.setString(8,prescription_id.trim());
			pstmt.setString(9,patient_id.trim());
			pstmt.setString(10,p_token_no.trim());
			pstmt.setString(11,p_encounter.trim());
			pstmt.setString(12,locn_type.trim());
			pstmt.setString(13,locn_code.trim());
			pstmt.setString(14,pract_code.trim());
			pstmt.setString(15,p_disp_locn_code.trim());
			
			resultSet = pstmt.executeQuery() ;

			records.add("link");
			while ( resultSet.next() && i <= end+1 ){
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
					if(i <= end ) { 
			
				String arr[] = new String[10];	
				arr[0]=resultSet.getString("disp_date_time");
				arr[1]=resultSet.getString("token_daily_seq_no");
				//arr[2]=resultSet.getString("FILL_PROC_ID");
				arr[2]=resultSet.getString("patient_id");
				arr[3]=resultSet.getString("patient_name");
				arr[4]=resultSet.getString("prescription_id");
				arr[5]=resultSet.getString("encounter_id");
				arr[6]=resultSet.getString("practitioner_name");
				arr[7]=resultSet.getString("disp_locn_code");
			//	arr[9]=p_langue.trim();
               	records.add(arr);
				}
			}
		   if( start != 1 )
			prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(adr_reported_date_from)+"','"+(adr_reported_date_to)+"','"+(prescription_id)+"','"+p_token_no+"','"+(p_encounter)+"','"+(pract_code)+"','"+(p_facility_id)+"','"+p_disp_locn_code+"','"+locn_type+"','"+locn_code+"','"+locale+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
			prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(adr_reported_date_from)+"','"+(adr_reported_date_to)+"','"+(prescription_id)+"','"+p_token_no+"','"+(p_encounter)+"','"+(pract_code)+"','"+(p_facility_id)+"','"+p_disp_locn_code+"','"+locn_type+"','"+locn_code+"','"+locale+"')\">Next</a>" ;
				
			records.set(0,prevnextlink);  
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;
           }
        finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return records;
	}

	public ArrayList getAllPresBasedOnQuery(String patient_id,String orig_order_id,String order_date_from,String order_date_to,String encounter_id,String pract_code,String locn_type,String locn_code,String facility_id,String from,String to,String order_type,String p_token_no)throws Exception{
	
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		//String orderby="";
		
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;

	/*	if(ord_by.equals("DESCEND"))
			orderby=" DESC";
		else
			orderby=""; */
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
		String sql="";

		try {
			connection = getConnection() ;
			
			//sql="SELECT  distinct  c.trn_group_ref ,a.patient_id, nvl(decode(?,'en',b.patient_name,PATIENT_NAME_LOC_LANG),b.patient_name)patient_name, c.trn_group_ref orig_order_id,a.encounter_id, a.locn_type, a.pres_practitioner_id,TO_CHAR (a.start_date, 'DD/MM/YYYY') start_date,TO_CHAR (a.added_date, 'DD/MM/YYYY') added_date,a.added_date ord_date, b.national_id_no, c.order_status,d.practitioner_name, a.patient_class, a.locn_code, e.short_desc disp_locn_desc, c.iv_prep_yn FROM ph_patient_drug_profile a,mp_patient b, or_order c, am_practitioner_lang_vw d, ph_disp_locn_lang_vw e , (SELECT  order_id, token_serial_no,daily_seq_num FROM ph_disp_hdr where patient_id = ?  and facility_id= ? UNION ALL SELECT  order_id, token_serial_no, daily_seq_num FROM ph_disp_hdr_tmp where patient_id = ? and facility_id= ? ) f WHERE a.patient_id = b.patient_id AND a.patient_id = c.patient_id AND a.orig_order_id = c.order_id and c.order_id =f.order_id(+) AND a.orig_order_line_no ='1' /* AND A.ORIG_ORDER_ID = NVL('',A.ORIG_ORDER_ID)  */ AND c.trn_group_ref = NVL (?, c.trn_group_ref)AND a.added_date BETWEEN TO_DATE (NVL (?, '01/01/1472'), 'DD/MM/RRRR')AND TO_DATE (NVL (?, '31/12/5000'), 'DD/MM/RRRR') + 0.99999 AND a.patient_id = NVL (?, a.patient_id) AND a.encounter_id = NVL (?, a.encounter_id) AND a.pres_practitioner_id = NVL (?, a.pres_practitioner_id) AND a.pres_practitioner_id = d.practitioner_id AND a.locn_type = NVL (?, a.locn_type) AND a.locn_code = NVL (?, a.locn_code)  AND a.facility_id = ? AND e.facility_id = a.facility_id AND e.disp_locn_code = c.performing_deptloc_code AND d.language_id = e.language_id AND d.language_id = ? AND NVL (f.daily_seq_num, 'X') = DECODE (c.patient_class,'IP', NVL (?, NVL (f.daily_seq_num, 'X')),NVL (f.daily_seq_num, 'X'))AND NVL (f.token_serial_no, '99')=  DECODE (a.patient_class,'OP', NVL (?,NVL (f.token_serial_no, '99')),NVL (f.token_serial_no, '99'))";
			sql="SELECT  distinct  c.trn_group_ref ,a.patient_id, nvl(decode(?,'en',b.patient_name,PATIENT_NAME_LOC_LANG),b.patient_name)patient_name, c.trn_group_ref orig_order_id,a.encounter_id, a.locn_type, a.pres_practitioner_id,TO_CHAR (a.start_date, 'DD/MM/YYYY') start_date,TO_CHAR (a.added_date, 'DD/MM/YYYY') added_date,a.added_date ord_date, b.national_id_no, c.order_status,d.practitioner_name, a.patient_class, a.locn_code, e.short_desc disp_locn_desc, c.iv_prep_yn FROM ph_patient_drug_profile a,mp_patient b, or_order c, am_practitioner_lang_vw d, ph_disp_locn_lang_vw e , (SELECT  order_id, token_serial_no,daily_seq_num FROM ph_disp_hdr where patient_id = ?   UNION ALL SELECT  order_id, token_serial_no, daily_seq_num FROM ph_disp_hdr_tmp where patient_id = ?  ) f WHERE a.patient_id = b.patient_id AND a.patient_id = c.patient_id AND a.orig_order_id = c.order_id and c.order_id =f.order_id(+) AND a.orig_order_line_no ='1' /* AND A.ORIG_ORDER_ID = NVL('',A.ORIG_ORDER_ID)  */ AND c.trn_group_ref = NVL (?, c.trn_group_ref)AND a.added_date BETWEEN TO_DATE (NVL (?, '01/01/1472'), 'DD/MM/RRRR')AND TO_DATE (NVL (?, '31/12/5000'), 'DD/MM/RRRR') + 0.99999 AND  c.patient_id = NVL (?, c.patient_id)   AND a.encounter_id = NVL (?, a.encounter_id) AND a.pres_practitioner_id = NVL (?, a.pres_practitioner_id) AND a.pres_practitioner_id = d.practitioner_id AND a.locn_type = NVL (?, a.locn_type) AND a.locn_code = NVL (?, a.locn_code)  and a.facility_id  =c.ordering_facility_id   AND e.facility_id  = c.performing_facility_id AND e.disp_locn_code = c.performing_deptloc_code AND d.language_id = e.language_id AND d.language_id = ? AND NVL (f.daily_seq_num, 'X') = DECODE (c.patient_class,'IP', NVL (?, NVL (f.daily_seq_num, 'X')),NVL (f.daily_seq_num, 'X'))AND NVL (f.token_serial_no, '99')=  DECODE (a.patient_class,'OP', NVL (?,NVL (f.token_serial_no, '99')),NVL (f.token_serial_no, '99'))";
			
			if(order_type.equals("All")){
				pstmt = connection.prepareStatement( sql +" AND (C.IV_PREP_YN IN ('0','1','2','3','4','5','6','7','8','9') OR C.IV_PREP_YN IS NULL) ORDER BY c.trn_group_ref DESC");
			}
			else if(order_type.equals("")){
				pstmt = connection.prepareStatement( sql +" AND C.IV_PREP_YN IS NULL ORDER BY c.trn_group_ref DESC");
			}
			else {
				pstmt = connection.prepareStatement( sql +" AND C.IV_PREP_YN=? ORDER BY c.trn_group_ref DESC");
			}

			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,patient_id.trim());
			//pstmt.setString(3,facility_id.trim());
			pstmt.setString(3,patient_id.trim());
			//pstmt.setString(5,facility_id.trim());
			pstmt.setString(4,orig_order_id.trim());
			pstmt.setString(5,order_date_from.trim());
			pstmt.setString(6,order_date_to.trim());
			pstmt.setString(7,patient_id.trim());
			pstmt.setString(8,encounter_id.trim());
			pstmt.setString(9,pract_code.trim());
			pstmt.setString(10,locn_type.trim());
			pstmt.setString(11,locn_code.trim());
			//pstmt.setString(14,facility_id.trim());
			pstmt.setString(12,getLanguageId());
			pstmt.setString(13,p_token_no.trim());
			pstmt.setString(14,p_token_no.trim());  

			if(!(order_type.equals("All")) && !(order_type.equals("")))	{
    			pstmt.setString(15,order_type);
			}

			resultSet = pstmt.executeQuery() ;
			records.add("link");
			while ( resultSet.next() && i <= end+1 ){
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
				if(i <= end ) {
				String arr[] = new String[12];	
				arr[0]=resultSet.getString("ORIG_ORDER_ID");
				arr[1]=resultSet.getString("ADDED_DATE");
				arr[2]=resultSet.getString("START_DATE");
				arr[3]=resultSet.getString("PATIENT_ID");
				arr[4]=resultSet.getString("PATIENT_NAME");
				arr[5]=resultSet.getString("ENCOUNTER_ID");
				arr[6]=resultSet.getString("PRACTITIONER_NAME");
				arr[7]=resultSet.getString("ORDER_STATUS");
				arr[8]=resultSet.getString("PATIENT_CLASS");
				arr[9]=resultSet.getString("LOCN_CODE");
				arr[10]=resultSet.getString("DISP_LOCN_DESC");
				arr[11]=resultSet.getString("IV_PREP_YN")==null?"":resultSet.getString("IV_PREP_YN");
               	records.add(arr);
				}
			}
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(orig_order_id)+"','"+(order_date_from)+"','"+order_date_to+"','"+(encounter_id)+"','"+(pract_code)+"','"+(order_type)+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(orig_order_id)+"','"+(order_date_from)+"','"+order_date_to+"','"+(encounter_id)+"','"+(pract_code)+"','"+(order_type)+"')\">Next</a>" ;
				
			records.set(0,prevnextlink);
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
				es.printStackTrace();
			}
		}
		return records;
	}

	public ArrayList getIVLegends() throws Exception{
	   Connection connection			= null ;
        PreparedStatement pstmt			= null ;
        ResultSet resultSet				= null;
		ArrayList iv_legends			= new ArrayList();

        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT127") ) ;
		    pstmt.setString(1,getLanguageId());
					
		    resultSet = pstmt.executeQuery() ;
           while( resultSet.next() ) {
                  iv_legends.add("1");
                  iv_legends.add(resultSet.getString("iv_drug_fluid_continuous_dir"));
				  iv_legends.add("2");
			      iv_legends.add(resultSet.getString("iv_drug_fluid_continuous_adm"));
				  iv_legends.add("3");
				  iv_legends.add(resultSet.getString("IV_DRUG_FLUID_INTERMITTENT_dir"));
				  iv_legends.add("4");
			      iv_legends.add(resultSet.getString("IV_DRUG_FLUID_INTERMITTENT_adm"));
				  iv_legends.add("5");
				  iv_legends.add(resultSet.getString("IV_WITHOUT_ADDITIVES_LG")); 
			} 	
        }
        catch ( Exception e ) {
            System.err.println( "Error while while getting IV LEGENDS " ) ;
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
				es.printStackTrace();
			}
        }
		return iv_legends;
	}


//getting HomeMecdicationYn
	public int getHomeMecdicationYn(String encounter_id,String facility_id){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "";
		encounter_id = encounter_id.trim();
		int rec_count=0;
		try{
			connection = getConnection() ;
			sql_query           = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT11");
			pstmt				= connection.prepareStatement(sql_query) ;

			if(encounter_id == "" || encounter_id == null ||encounter_id.equals("DUMMYENCOUNTERID"))
				encounter_id = "0";
			//double enc_id=Long.parseLong(encounter_id);
			pstmt.setString(1,encounter_id);
			pstmt.setString(2,facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				rec_count=resultSet.getInt(1);
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
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
				es.printStackTrace() ;
			}
		}
		return rec_count;
	}
//getDrugLabelActiveOrders
	public ArrayList getPatientActiveOrders(String patient_id,String patient_class,String p_order_date,String orderid,String p_disp_locn_code,String facility_id,String locale,String p_token_dly_seq_no,String p_langue)	{

		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
	//	String sql_str				=	"";
		String	start_date			=	"";
		String	end_date			=	"";
		String	drug_desc			=	"";
		String	strength			=	"";
		String	split_dose_prev		=	"";
		String	strength_uom_desc	=	"";
		String	form_desc			=	"";
		String	practitioner_name	=	"";
		String	facility_name		=	"";
		String	diag_text			=	"";
		String location				=	"";
		String order_id				=	"";
		String order_line_no		=	"";
		String freq_code			=	"";
		String freq_desc			=	"";
		String allergy_reason		=	"";
		String dosage_reason		=	"";
		String duplicate_reason		=	"";
		String discont_date_time	=	"";
	//	String perf_locn			=	"";
		String iv_prep_yn			=   "";
		String discharge_ind		=	"";
		String in_formulary_yn		=	"";
		String dosage				=	"";
		String dosage_uom_code		=	"";
	//	String append_qry			=	"";
	//	String per_facility_name	=	"";
	//	String locale               =   "";
			   order_date		    =   "";

		String  pres_practitioner_id=	"";
		String	drug_code	        =	"";
		String	trn_group_ref	    =	"";
		String	disp_no	            =	"";
		String	srl_no	            =	"";
		String	prescribed_qty       =  "";
		String	pref_locn       =  "";
		String sliding_scale_yn = "";
		String drug_yn = "";
		String order_line_status = "";   // Added for SKR-SCF-0589[Inc:34387]


		ArrayList activeOrders	= new ArrayList();
		HashMap	record			= null;

		
		try{
		
			connection			= getConnection() ;
            //pstmt = connection.prepareStatement("SELECT a.discont_date_time, a.patient_id, a.allergy_override_reason, a.dosage_limit_override_reason, a.duplicate_drug_override_reason, a.orig_order_id, a.orig_order_line_no, c.in_formulary_yn, a.dosage, a.dosage_uom_code, a.split_dose_preview, a.freq_code, g.freq_desc, a.pres_practitioner_id, b.practitioner_name, h.discharge_ind, a.drug_code, c.drug_desc, a.strength, c.strength_uom, c.form_code, TO_CHAR (a.start_date, 'DD/MM/YYYY hh24:mi') start_date, TO_CHAR (a.end_date, 'DD/MM/YYYY hh24:mi') end_date, a.dosage,  a.dosage_uom_code, a.prescribed_qty, a.diag_text, d.facility_name,  a.patient_class, DECODE (a.patient_class,'IP', f.long_desc, 'EA', f.long_desc, e.long_desc ) LOCATION, h.iv_prep_yn,h.TRN_GROUP_REF,i.DISP_NO,j.srl_no,k.SHORT_DESC pref_locn,l.SLIDING_SCALE_YN SLIDING_SCALE_YN,c.drug_yn  FROM ph_patient_drug_profile a,am_practitioner_lang_vw b, sm_facility_param_lang_vw d,op_clinic_lang_vw e, ip_nursing_unit_lang_vw f,   ph_drug_lang_vw c, am_frequency_lang_vw g,or_order h,(SELECT 'D' stage, order_id, token_serial_no, patient_class,daily_seq_num, patient_id, facility_id,disp_date_time disp_date_time, disp_locn_code, fill_proc_id,DISP_NO DISP_NO FROM ph_disp_hdr where patient_id = ? and disp_locn_code = ? and facility_id=? UNION ALL SELECT 'F' stage, order_id, token_serial_no, patient_class,daily_seq_num, patient_id, facility_id, dispensed_date_time disp_date_time, disp_locn_code, fill_proc_id,to_char(disp_tmp_no) DISP_NO FROM ph_disp_hdr_tmp where patient_id = ? and disp_locn_code = ? and facility_id=? ) i, (SELECT disp_no disp_no, srl_no srl_no, order_id, order_line_no,disp_drug_code FROM ph_disp_dtl where disp_locn_code = ? and facility_id= ? UNION ALL SELECT TO_CHAR (disp_tmp_no) disp_no, dtl_serial_num srl_no, order_id,order_line_no,disp_drug_code FROM ph_disp_dtl_tmp where disp_locn_code = ? and facility_id= ? ) j ,ph_disp_locn_lang_vw k, or_order_line_ph l WHERE a.patient_id = ? AND a.pres_practitioner_id = b.practitioner_id(+) AND a.facility_id = d.facility_id AND a.facility_id = e.facility_id(+) AND a.locn_code = e.clinic_code(+) AND a.facility_id = f.facility_id(+) AND a.locn_code = f.nursing_unit_code(+) AND j.disp_drug_code = c.drug_code AND a.freq_code = g.freq_code AND a.orig_order_id = h.order_id AND a.patient_id = h.patient_id AND a.discont_date_time IS NULL AND a.on_hold_date_time IS NULL AND a.cancel_yn = 'N' AND a.stop_yn = 'N' AND c.language_id = d.language_id AND c.language_id = g.language_id AND c.language_id = ? AND b.language_id(+) = ?  AND e.language_id(+) = ? AND f.language_id(+) = ? AND h.order_id = i.order_id  AND h.trn_group_ref = ?  AND i.facility_id = ?   AND TRUNC (i.disp_date_time) = TO_DATE ( ? ,'DD/MM/YYYY ')  AND  i.disp_locn_code = ? AND NVL (i.daily_seq_num, 'X') = DECODE (a.patient_class,'IP', NVL (?, NVL (i.daily_seq_num, 'X')),NVL (i.daily_seq_num, 'X') ) AND NVL (i.token_serial_no, '999999') = DECODE (a.patient_class,'OP', NVL (?, NVL (i.token_serial_no, '999999')),NVL (i.token_serial_no, '999999')) and a.orig_order_id =j.order_id and a.orig_order_line_no =j.order_line_no and i.disp_no =j.disp_no AND k.DISP_LOCN_CODE = H.PERFORMING_DEPTLOC_CODE and k.language_id =? and a.orig_order_id = l.order_id and A.ORIG_ORDER_LINE_NO =l.ORDER_LINE_NUM ORDER BY A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");  Commented and added ORDER_LINE_STATUS for SKR-SCF-0589[Inc:34387]
			pstmt = connection.prepareStatement("SELECT a.discont_date_time, a.patient_id, a.allergy_override_reason, a.dosage_limit_override_reason, a.duplicate_drug_override_reason, a.orig_order_id, a.orig_order_line_no, c.in_formulary_yn, a.dosage, a.dosage_uom_code, a.split_dose_preview, a.freq_code, g.freq_desc, a.pres_practitioner_id, b.practitioner_name, h.discharge_ind, a.drug_code, c.drug_desc, a.strength, c.strength_uom, c.form_code, TO_CHAR (a.start_date, 'DD/MM/YYYY hh24:mi') start_date, TO_CHAR (a.end_date, 'DD/MM/YYYY hh24:mi') end_date, a.dosage,  a.dosage_uom_code, a.prescribed_qty, a.diag_text, d.facility_name,  a.patient_class, DECODE (a.patient_class,'IP', f.long_desc, 'EA', f.long_desc, e.long_desc ) LOCATION, h.iv_prep_yn,h.TRN_GROUP_REF,i.DISP_NO,j.srl_no,k.SHORT_DESC pref_locn,l.SLIDING_SCALE_YN SLIDING_SCALE_YN,c.drug_yn,m.order_line_status  FROM ph_patient_drug_profile a,am_practitioner_lang_vw b, sm_facility_param_lang_vw d,op_clinic_lang_vw e, ip_nursing_unit_lang_vw f,   ph_drug_lang_vw c, am_frequency_lang_vw g,or_order h,(SELECT 'D' stage, order_id, token_serial_no, patient_class,daily_seq_num, patient_id, facility_id,disp_date_time disp_date_time, disp_locn_code, fill_proc_id,DISP_NO DISP_NO FROM ph_disp_hdr where patient_id = ? and disp_locn_code = ? and facility_id=? UNION ALL SELECT 'F' stage, order_id, token_serial_no, patient_class,daily_seq_num, patient_id, facility_id, dispensed_date_time disp_date_time, disp_locn_code, fill_proc_id,to_char(disp_tmp_no) DISP_NO FROM ph_disp_hdr_tmp where patient_id = ? and disp_locn_code = ? and facility_id=? ) i, (SELECT disp_no disp_no, srl_no srl_no, order_id, order_line_no,disp_drug_code FROM ph_disp_dtl where disp_locn_code = ? and facility_id= ? UNION ALL SELECT TO_CHAR (disp_tmp_no) disp_no, dtl_serial_num srl_no, order_id,order_line_no,disp_drug_code FROM ph_disp_dtl_tmp where disp_locn_code = ? and facility_id= ? ) j ,ph_disp_locn_lang_vw k, or_order_line_ph l,or_order_line m WHERE a.patient_id = ? AND a.pres_practitioner_id = b.practitioner_id(+) AND a.facility_id = d.facility_id AND a.facility_id = e.facility_id(+) AND a.locn_code = e.clinic_code(+) AND a.facility_id = f.facility_id(+) AND a.locn_code = f.nursing_unit_code(+) AND j.disp_drug_code = c.drug_code AND a.freq_code = g.freq_code AND a.orig_order_id = h.order_id AND a.patient_id = h.patient_id AND a.discont_date_time IS NULL AND a.on_hold_date_time IS NULL AND a.cancel_yn = 'N' AND a.stop_yn = 'N' AND c.language_id = d.language_id AND c.language_id = g.language_id AND c.language_id = ? AND b.language_id(+) = ?  AND e.language_id(+) = ? AND f.language_id(+) = ? AND h.order_id = i.order_id  AND h.trn_group_ref = ?  AND i.facility_id = ?   AND TRUNC (i.disp_date_time) = TO_DATE ( ? ,'DD/MM/YYYY ')  AND  i.disp_locn_code = ? AND NVL (i.daily_seq_num, 'X') = DECODE (a.patient_class,'IP', NVL (?, NVL (i.daily_seq_num, 'X')),NVL (i.daily_seq_num, 'X') ) AND NVL (i.token_serial_no, '999999') = DECODE (a.patient_class,'OP', NVL (?, NVL (i.token_serial_no, '999999')),NVL (i.token_serial_no, '999999')) and a.orig_order_id =j.order_id and a.orig_order_line_no =j.order_line_no and i.disp_no =j.disp_no AND k.DISP_LOCN_CODE = H.PERFORMING_DEPTLOC_CODE and k.language_id =? and a.orig_order_id = l.order_id and A.ORIG_ORDER_LINE_NO =l.ORDER_LINE_NUM and m.order_id=l.order_id and m.order_line_num=l.order_line_num ORDER BY A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");
			// query modified for IN25905 to get drug_yn value --14-01-2011-- priya

			pstmt.setString(1,patient_id);
			pstmt.setString(2,p_disp_locn_code);
			pstmt.setString(3,facility_id.trim());
			pstmt.setString(4,patient_id);
			pstmt.setString(5,p_disp_locn_code);
			pstmt.setString(6,facility_id.trim());
			pstmt.setString(7,p_disp_locn_code);
			pstmt.setString(8,facility_id.trim());
			pstmt.setString(9,p_disp_locn_code);
			pstmt.setString(10,facility_id.trim());
			pstmt.setString(11,patient_id);
			pstmt.setString(12,p_langue.trim()); // 'locale' changed to p_langue for SRR20056-SCF-7214 IN2727
			pstmt.setString(13,p_langue.trim()); // 'locale' changed to p_langue for SRR20056-SCF-7214 IN2727
			pstmt.setString(14,p_langue.trim()); // 'locale' changed to p_langue for SRR20056-SCF-7214 IN2727
			pstmt.setString(15,p_langue.trim()); // 'locale' changed to p_langue for SRR20056-SCF-7214 IN2727
			pstmt.setString(16,orderid);
			pstmt.setString(17,facility_id.trim());
			pstmt.setString(18,p_order_date);
			pstmt.setString(19,p_disp_locn_code);
			pstmt.setString(20,p_token_dly_seq_no);
			pstmt.setString(21,p_token_dly_seq_no);
			pstmt.setString(22,p_langue.trim()); // 'locale' changed to p_langue for SRR20056-SCF-7214 IN2727

			resultSet	= pstmt.executeQuery();
			int cnt =0;
				while ( resultSet != null && resultSet.next() ) {
				record	=	new HashMap();
				start_date			=	resultSet.getString("START_DATE");
				end_date			=	resultSet.getString("END_DATE");
				drug_desc			=	resultSet.getString("DRUG_DESC");
				strength			=	resultSet.getString("STRENGTH");
				split_dose_prev		=	resultSet.getString("SPLIT_DOSE_PREVIEW");
				strength_uom_desc	=	resultSet.getString("STRENGTH_UOM");
				form_desc			=	resultSet.getString("FORM_CODE");
				practitioner_name	=	resultSet.getString("PRACTITIONER_NAME");
				facility_name		=	resultSet.getString("FACILITY_NAME");
				diag_text			=	resultSet.getString("DIAG_TEXT");
				location			=	resultSet.getString("LOCATION");
				order_id			=	resultSet.getString("ORIG_ORDER_ID")+"#"+cnt;
				order_line_no		=	resultSet.getString("ORIG_ORDER_LINE_NO");
				freq_code			=	resultSet.getString("FREQ_CODE");
				freq_desc			=	resultSet.getString("FREQ_DESC");
				allergy_reason		=	resultSet.getString("ALLERGY_OVERRIDE_REASON");
				dosage_reason		=	resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON");
				duplicate_reason	=	resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON");
				discont_date_time	=	resultSet.getString("DISCONT_DATE_TIME");
				patient_id	        =	resultSet.getString("PATIENT_ID");
				pres_practitioner_id=	resultSet.getString("PRES_PRACTITIONER_ID");
				drug_code	        =	resultSet.getString("drug_code");
				patient_class	    =	resultSet.getString("patient_class");
				trn_group_ref	    =	resultSet.getString("TRN_GROUP_REF");
				disp_no	            =	resultSet.getString("DISP_NO");
				srl_no	            =	resultSet.getString("SRL_NO");
				prescribed_qty	    =	resultSet.getString("PRESCRIBED_QTY");
				iv_prep_yn			=   resultSet.getString("IV_PREP_YN");
				discharge_ind		=   resultSet.getString("DISCHARGE_IND");
				in_formulary_yn		=	resultSet.getString("IN_FORMULARY_YN");
				dosage				=	resultSet.getString("DOSAGE");
				pref_locn			=	resultSet.getString("PREF_LOCN");
				sliding_scale_yn	 =  resultSet.getString("SLIDING_SCALE_YN");
				drug_yn				=		resultSet.getString("DRUG_YN");		
				order_line_status	=	resultSet.getString("ORDER_LINE_STATUS");  //Added for SKR-SCF-0589[Inc:34387]

				if(dosage != null && dosage != "" && Float.parseFloat(dosage) < 1)
					dosage = Float.parseFloat(dosage)+"";
				dosage_uom_code		=	resultSet.getString("DOSAGE_UOM_CODE");

				if(!locale.equals("en")){
					start_date = com.ehis.util.DateUtils.convertDate(start_date, "DMYHM","en",locale);
					end_date = com.ehis.util.DateUtils.convertDate(end_date, "DMYHM","en",locale);
					discont_date_time = com.ehis.util.DateUtils.convertDate(discont_date_time, "DMYHM","en",locale);
				}

				record.put("start_date",start_date);
				record.put("end_date",end_date);
				record.put("drug_desc",drug_desc);
				record.put("strength",strength);
				record.put("split_dose_prev",split_dose_prev);
				record.put("strength_uom_desc",strength_uom_desc);
				record.put("form_desc",form_desc);
				record.put("practitioner_name",practitioner_name);
				record.put("facility_name",facility_name);
				record.put("diag_text",diag_text);
				record.put("location",location);
				record.put("order_id",order_id);
				record.put("order_line_no",order_line_no);
				record.put("freq_code",freq_code);
				record.put("freq_desc",freq_desc);
				record.put("allergy_reason",allergy_reason);
				record.put("dosage_reason",dosage_reason);
				record.put("duplicate_reason",duplicate_reason);
				record.put("discont_date_time",discont_date_time);
				record.put("patient_id",patient_id);
				record.put("pres_practitioner_id",pres_practitioner_id);
				record.put("drug_code",drug_code);
				record.put("patient_class",patient_class);
				record.put("trn_group_ref",trn_group_ref);
				record.put("disp_no",disp_no);
				record.put("srl_no",srl_no);
				record.put("prescribed_qty",prescribed_qty);
				record.put("iv_prep_yn",iv_prep_yn);
				record.put("discharge_ind",discharge_ind);
				record.put("in_formulary_yn",in_formulary_yn);
				record.put("dosage",dosage);
				record.put("dosage_uom_code",dosage_uom_code);
				record.put("flag","N");
				record.put("p_order_date",p_order_date);
				record.put("p_langue",p_langue);
				record.put("p_token_dly_seq_no",p_token_dly_seq_no.trim());
				record.put("pref_locn",pref_locn.trim());
				record.put("sliding_scale_yn",sliding_scale_yn);
				record.put("drug_yn",drug_yn);
				record.put("order_line_status",order_line_status);  // Added for SKR-SCF-0589[Inc:34387]
				activeOrders.add(record);
				 cnt++;

			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
			setActiveOrders(activeOrders);
		}
		catch(Exception e){
			activeOrders.add(e.toString());
			e.printStackTrace();
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

		return activeOrders;
	}


	
public ArrayList getTokenSeriesList(String facility_id,String disp_locn_code) {
		ArrayList TokenSerieslist = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TOKEN_SERIES_GEN_SELECT1" )) ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,disp_locn_code);
			pstmt.setString(3,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					TokenSerieslist.add( resultSet.getString( "TOKEN_SERIES_CODE" ) ) ;
					TokenSerieslist.add( resultSet.getString( "DESCRIPTION" ) );
				}
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

		return TokenSerieslist;
	}

	/*  Dispense Location starts where disp_locn_type = 'P' */

public ArrayList getDispLocationList() {
		ArrayList displocationlist = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_COMN_SELECT2" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,getLanguageId());
	

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					displocationlist.add( resultSet.getString( "DISP_LOCN_CODE" ) ) ;
					displocationlist.add( resultSet.getString( "SHORT_DESC" ) );
				}
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

		return displocationlist;
	}
public String getPatientIDLength()
{
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pat_txt_length	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT1") ) ;
			resultSet			= pstmt.executeQuery(); 
			
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
	  public Hashtable getStatusDesc() throws Exception{
		Hashtable result = new Hashtable();
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
		  pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT3") ) ;
		   // pstmt = connection.prepareStatement("SELECT ORDER_STATUS_CODE,LONG_DESC FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE IN ('OS','RG','DP','DF')") ;
		    pstmt.setString(1,getLanguageId());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				result.put(resultSet.getString("ORDER_STATUS_CODE"),resultSet.getString("LONG_DESC"));  
			}
        }
        catch ( Exception e ) {
            System.err.println( "Error loading values from database" ) ;
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		return result;
	}

	// This getDispLocationList1 calling from worksheet chart jsp

public ArrayList getDispLocation() {
		ArrayList displocation = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_COMN_SELECT3" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					displocation.add( resultSet.getString( "DISP_LOCN_CODE" ) ) ;
					displocation.add( resultSet.getString( "SHORT_DESC" ) );
				}
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

		return displocation;
	}

// upto this section



// This method is used to retrieve the data depending on the query criteria
	public ArrayList getCertiforReimbursementList(String patient_id,String adr_reported_date_from,String adr_reported_date_to,String p_encounter,String p_fr_pre,String p_to_pre,String token_no_from,String token_no_to,String p_disp_locn_code,String locn_type,String locn_code,String p_facility_id,String locale)throws Exception{

	

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();

     		try {

			ArrayList arrList = getSelectedValue();
			connection = getConnection() ;
			//pstmt = connection.prepareStatement("SELECT DISTINCT trn_group_ref prescription_id, a.patient_id, a.encounter_id,b.patient_name, c.short_desc disp_locn,TO_CHAR (f.disp_date_time, 'dd/mm/yyyy') disp_date_time, practitioner_name,DECODE (a.patient_class,'OP', token_serial_no,'XT', token_serial_no,'IP', daily_seq_num) token_daily_seq_no,c.disp_locn_code FROM or_order a, mp_patient b, ph_disp_locn_lang_vw c,(SELECT 'D' stage, order_id, token_serial_no, patient_class,daily_seq_num, patient_id, facility_id,disp_date_time disp_date_time, disp_locn_code FROM ph_disp_hdr UNION ALL SELECT 'F' stage, order_id, token_serial_no, patient_class,daily_seq_num, patient_id, facility_id,dispensed_date_time disp_date_time, disp_locn_code FROM ph_disp_hdr_tmp) f,am_practitioner_lang_vw g,(select order_id,disp_drug_code from ph_disp_dtl_tmp union all select order_id,disp_drug_code from ph_disp_dtl) h,mm_item i WHERE a.patient_id = b.patient_id AND a.performing_deptloc_code = c.disp_locn_code AND a.order_id = f.order_id AND a.performing_deptloc_code = f.disp_locn_code  AND a.ord_pract_id = g.practitioner_id and a.order_id =h.order_id and h.disp_drug_code= i.item_code and i.ESSENTIAL_ITEM_YN ='N' AND g.language_id = ? AND f.facility_id = ? AND c.language_id = ? AND c.facility_id = ? AND TRUNC (f.disp_date_time) BETWEEN TO_DATE (?, 'DD/MM/YYYY')AND TO_DATE (?, 'DD/MM/YYYY')+ 0.99999 AND a.trn_group_ref BETWEEN NVL (?, a.trn_group_ref)AND NVL (?, a.trn_group_ref) AND nvl(f.token_serial_no,'999999') BETWEEN NVL (?, nvl(f.token_serial_no,'999999') )AND NVL (?, nvl(f.token_serial_no,'999999') ) AND a.patient_id = NVL (?, a.patient_id) AND a.encounter_id = NVL (?, a.encounter_id) AND a.source_type = NVL (?, a.source_type) AND a.source_code = NVL (?, a.source_code) AND f.disp_locn_code = NVL (?, f.disp_locn_code) ORDER BY to_date(disp_date_time,'DD/MM/YYYY')  DESC,to_number(token_daily_seq_no) desc");

			//Modified Above Query For getting Patient name into specified language regarding incident num:25079 on 2/Dec/2010===By Sandhya

			pstmt = connection.prepareStatement("SELECT DISTINCT trn_group_ref prescription_id, a.patient_id, a.encounter_id,nvl(decode(?,'en',b.patient_name,PATIENT_NAME_LOC_LANG),b.patient_name)patient_name, c.short_desc disp_locn,TO_CHAR (f.disp_date_time, 'dd/mm/yyyy') disp_date_time, practitioner_name,DECODE (a.patient_class,'OP', token_serial_no,'XT', token_serial_no,'IP', daily_seq_num) token_daily_seq_no,c.disp_locn_code FROM or_order a, mp_patient b, ph_disp_locn_lang_vw c,(SELECT 'D' stage, order_id, token_serial_no, patient_class,daily_seq_num, patient_id, facility_id,disp_date_time disp_date_time, disp_locn_code,CERT_REIMB_NO FROM ph_disp_hdr UNION ALL SELECT 'F' stage, order_id, token_serial_no, patient_class,daily_seq_num, patient_id, facility_id,dispensed_date_time disp_date_time, disp_locn_code,CERT_REIMB_NO FROM ph_disp_hdr_tmp) f,am_practitioner_lang_vw g,(select order_id,disp_drug_code,CERT_REIMB_APPL_YN from ph_disp_dtl_tmp union all select order_id,disp_drug_code,CERT_REIMB_APPL_YN from ph_disp_dtl) h,mm_item i WHERE a.patient_id = b.patient_id AND a.performing_deptloc_code = c.disp_locn_code AND a.order_id = f.order_id AND a.performing_deptloc_code = f.disp_locn_code  AND a.ord_pract_id = g.practitioner_id and a.order_id =h.order_id and h.disp_drug_code= i.item_code and i.ESSENTIAL_ITEM_YN ='N' AND g.language_id = ? AND f.facility_id = ? AND c.language_id = ? AND c.facility_id = ? AND TRUNC (f.disp_date_time) BETWEEN TO_DATE (?, 'DD/MM/YYYY')AND TO_DATE (?, 'DD/MM/YYYY')+ 0.99999 AND a.trn_group_ref BETWEEN NVL (?, a.trn_group_ref)AND NVL (?, a.trn_group_ref) AND nvl(f.token_serial_no,'999999') BETWEEN NVL (?, nvl(f.token_serial_no,'999999') )AND NVL (?, nvl(f.token_serial_no,'999999') ) AND a.patient_id = NVL (?, a.patient_id) AND a.encounter_id = NVL (?, a.encounter_id) AND a.source_type = NVL (?, a.source_type) AND a.source_code = NVL (?, a.source_code) AND f.disp_locn_code = NVL (?, f.disp_locn_code) AND CERT_REIMB_APPL_YN = 'Y' and f.CERT_REIMB_NO is not null and i.ESSENTIAL_ITEM_YN ='N' ORDER BY to_date(disp_date_time,'DD/MM/YYYY')  DESC,to_number(token_daily_seq_no) desc");

			pstmt.setString(1,locale.trim());
			pstmt.setString(2,locale.trim());
			pstmt.setString(3,p_facility_id.trim());
			pstmt.setString(4,locale.trim());
			pstmt.setString(5,p_facility_id.trim());
			pstmt.setString(6,adr_reported_date_from.trim());
			pstmt.setString(7,adr_reported_date_to.trim());
			pstmt.setString(8,p_fr_pre.trim());
			pstmt.setString(9,p_to_pre.trim());
			pstmt.setString(10,token_no_from.trim());
			pstmt.setString(11,token_no_to.trim());
			pstmt.setString(12,patient_id.trim());
			pstmt.setString(13,p_encounter.trim());
			pstmt.setString(14,locn_type.trim());
			pstmt.setString(15,locn_code.trim());
			pstmt.setString(16,p_disp_locn_code.trim());
			resultSet = pstmt.executeQuery() ;
            int cunt=0;
			while ( resultSet.next() ) {
			
				String arr[] = new String[9];	
				arr[0]=resultSet.getString("disp_date_time");
				arr[1]=resultSet.getString("disp_locn");
				arr[2]=CommonBean.checkForNull(resultSet.getString("token_daily_seq_no"));
				arr[3]=resultSet.getString("patient_id");
				arr[4]=resultSet.getString("patient_name");
				//arr[5]=resultSet.getString("prescription_id");
				String pre_id =resultSet.getString("prescription_id")+"#"+cunt;
				arr[5]=pre_id;
				arr[6]=resultSet.getString("encounter_id");
				if (arrList != null && arrList.contains(pre_id))
					arr[7]="Y";
				else
					arr[7]="N";

				arr[8]=resultSet.getString("disp_locn_code");
				 
               	records.add(arr);
				cunt++;
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



// This method is used to retrieve the data depending on the query criteria
	public ArrayList getDispLabelList(String patient_id,String adr_reported_date_from,String adr_reported_date_to,String p_encounter,String p_token_no_from,String p_token_no_to,String p_disp_locn_code,String locn_type,String locn_code,String p_facility_id,String locale,String p_fill_id,String p_langue,String p_printall_yn,String prescription_id,String pract_code,String from,String to)throws Exception{

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;
		long count=0;
		long i = 0;

         if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;  
     		try {

		
			connection = getConnection() ; 
			//Below query b.patient name is changed by Archana Dhal related to IN025078
			pstmt = connection.prepareStatement("SELECT DISTINCT trn_group_ref prescription_id, a.patient_id, a.encounter_id, nvl( decode(?,'en',b.patient_name, patient_name_loc_lang),patient_name) patient_name, short_desc disp_locn,TO_CHAR (f.disp_date_time, 'dd/mm/yyyy') disp_date_time,practitioner_name, DECODE (a.patient_class, 'OP', TO_CHAR (f.token_serial_no), 'XT', TO_CHAR (f.token_serial_no), 'IP', f.daily_seq_num) token_daily_seq_no,f.fill_proc_id,a.iv_prep_yn,a.patient_class FROM or_order a, mp_patient b,ph_disp_locn_lang_vw c,(SELECT 'D' stage, order_id, token_serial_no, patient_class,daily_seq_num, patient_id, facility_id,disp_date_time disp_date_time, disp_locn_code, fill_proc_id FROM ph_disp_hdr  UNION ALL SELECT 'F' stage, order_id, token_serial_no, patient_class, daily_seq_num, patient_id, facility_id,dispensed_date_time disp_date_time, disp_locn_code,fill_proc_id FROM ph_disp_hdr_tmp )  f, am_practitioner_lang_vw g WHERE a.patient_id = b.patient_id AND a.performing_deptloc_code = c.disp_locn_code AND a.order_id = f.order_id AND a.performing_deptloc_code = f.disp_locn_code AND a.ord_pract_id = g.practitioner_id AND g.language_id = ? AND f.facility_id = ? AND c.language_id = ? AND c.facility_id = ? AND TRUNC (f.disp_date_time) BETWEEN TO_DATE (?,'DD/MM/YYYY')AND TO_DATE (?,'DD/MM/YYYY') AND (a.iv_prep_yn IS NULL OR a.iv_prep_yn NOT IN ('2', '4','6', '8', '0')) AND a.trn_group_ref = NVL (?, a.trn_group_ref) AND a.patient_id = NVL (?, a.patient_id) AND a.encounter_id = NVL (?, a.encounter_id) AND a.source_type = NVL (?, a.source_type) AND a.source_code = NVL (?, a.source_code) AND a.ord_pract_id = NVL (?, a.ord_pract_id) AND NVL (f.fill_proc_id, '999999') = NVL (?, NVL (f.fill_proc_id, '999999')) AND f.disp_locn_code = NVL (?, f.disp_locn_code) AND NVL (f.daily_seq_num, 'X') BETWEEN DECODE (a.patient_class,'IP', NVL (?, NVL (f.daily_seq_num, 'X')), NVL (f.daily_seq_num, 'X'))AND DECODE (a.patient_class,'IP', NVL (?, NVL (f.daily_seq_num, 'X')),NVL(f.daily_seq_num, 'X'))AND NVL (f.token_serial_no, '99')BETWEEN DECODE (a.patient_class,'OP', NVL (?,NVL (f.token_serial_no, '99')),NVL (f.token_serial_no, '99'))AND DECODE (a.patient_class,'OP', NVL (?,NVL (f.token_serial_no, '99')),NVL (f.token_serial_no, '99'))ORDER BY to_Date(disp_date_time,'dd/mm/yyyy')  DESC, to_number(token_daily_seq_no) desc");//a.iv_prep_yn (1,3,5),a.patient_class  Added for SKR-SCF-0589[Inc:34387]

// SRR20056-SCF-7214 IN2727 2.2.	By thai login, if select language as “English” the report should be printed by English format but currently It’s not. - Subbu
			pstmt.setString(1,p_langue.trim());   // 'locale' changed to p_langue for SRR20056-SCF-7214 IN2727
			pstmt.setString(2,p_langue.trim());		// 'locale' changed to p_langue for SRR20056-SCF-7214 IN2727
			pstmt.setString(3,p_facility_id.trim());
			pstmt.setString(4,p_langue.trim());		// 'locale' changed to p_langue for SRR20056-SCF-7214 IN2727
			pstmt.setString(5,p_facility_id.trim());
			pstmt.setString(6,adr_reported_date_from.trim());
			pstmt.setString(7,adr_reported_date_to.trim());
			pstmt.setString(8,prescription_id.trim());
			pstmt.setString(9,patient_id.trim());
			pstmt.setString(10,p_encounter.trim());
			pstmt.setString(11,locn_type.trim());
			pstmt.setString(12,locn_code.trim());
			pstmt.setString(13,pract_code.trim());
			pstmt.setString(14,p_fill_id.trim());
			pstmt.setString(15,p_disp_locn_code.trim());
			pstmt.setString(16,p_token_no_from.trim());
			pstmt.setString(17,p_token_no_to.trim());
			pstmt.setString(18,p_token_no_from.trim());
			pstmt.setString(19,p_token_no_to.trim());
			resultSet = pstmt.executeQuery() ;


			records.add("link");
			while ( resultSet.next() && i <= end+1 ){
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
					if(i <= end ) { 

		
			
				String arr[] = new String[12];//Increased Str[] size from 10 to 12 for SKR-SCF-0589[Inc:34387]
				arr[0]=resultSet.getString("disp_date_time");
				arr[1]=checkForNull(resultSet.getString("token_daily_seq_no"),"");
				arr[2]=resultSet.getString("FILL_PROC_ID");
				arr[3]=resultSet.getString("patient_id");
				arr[4]=resultSet.getString("patient_name");
				arr[5]=resultSet.getString("prescription_id");
				arr[6]=resultSet.getString("encounter_id");
				arr[7]=resultSet.getString("practitioner_name");
				arr[8]=p_disp_locn_code.trim();
				arr[9]=p_langue.trim();								// 'locale' changed to p_langue for SRR20056-SCF-7214 IN2727
				arr[10]=resultSet.getString("iv_prep_yn");			// Added for SKR-SCF-0589[Inc:34387]
				arr[11]=CommonBean.checkForNull(resultSet.getString("patient_class"));			// Added for SKR-SCF-0589[Inc:34387]
               	records.add(arr);
				}
			}
			
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(p_token_no_from)+"','"+(p_token_no_to)+"','"+(adr_reported_date_from)+"','"+adr_reported_date_to+"','"+(p_encounter)+"','"+(p_disp_locn_code)+"','"+(pract_code)+"','"+(prescription_id)+"','"+(p_fill_id)+"','"+locn_type+"','"+locn_code+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(p_token_no_from)+"','"+(p_token_no_to)+"','"+(adr_reported_date_from)+"','"+adr_reported_date_to+"','"+(p_encounter)+"','"+(p_disp_locn_code)+"','"+(pract_code)+"','"+(prescription_id)+"','"+(p_fill_id)+"','"+locn_type+"','"+locn_code+"')\">Next</a>" ;
				
			records.set(0,prevnextlink);   

		setDispLabelRecds(records);	

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
/*   DispLabelQueryResult desc returns ends here    */

	public void setSelectedValue (String pre_id){
		
		if (selList == null)
			selList = new ArrayList();

		if(!selList.contains(pre_id)){
			selList.add(pre_id);
			ArrayList getList = this.active_CertiforReimbursements;	
			for(int i=0;i<getList.size();i++){
				String [] record= (String[])getList.get(i);
				if(record[5].equals(pre_id)){
					record[7] = "Y";
				}
			}
		}
	}

	public void removeValue(String pre_id){
		
		if(selList != null && selList.contains(pre_id)){
			selList.remove(pre_id);
			ArrayList getList = this.active_CertiforReimbursements;	
			for(int i=0;i<getList.size();i++){
				String [] record= (String[])getList.get(i);
				if(record[5].equals(pre_id)){
					record[7] = "N";
				}
			}
		}
	}

	public ArrayList getSelectedValue(){
		return this.selList;
	}

	public void setAllSelectedValue(String order_id,String order_line_no,String client_ip_address,String login_user,String facility){
		try{
		//selMap = new HashMap();

		if(selMap == null)
				selMap = new HashMap();

			ArrayList	record =	new ArrayList();
			String mapKay = order_id+"~"+order_line_no;
				
			record.add(order_id);
			record.add(order_line_no);
			record.add(client_ip_address);
			record.add(login_user);
			record.add(facility);
			selMap.put(mapKay,record);
		}
		catch(Exception e) {
			e.printStackTrace();

		}
	}
	public HashMap getAllSelectedValue(){
		return this.selMap;
	}
	public void removeValue_pre(String index){
		if (selMap != null){
			if(index.equals("ALL"))
				selMap.clear();
			else{
				selMap.remove(index);
			}
		}
	}

	// This method is used to retrieve the data depending on the query criteria
	public ArrayList MedicationList(String patient_id,String fr_dispdate,String to_dispdate,String p_encounter,String p_fr_pre,String p_tokfr,String p_tokto,String p_disp_locn_code,String locn_type,String p_locn_code,String p_fill_id,String p_facility_id,String locale)throws Exception{
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();

     	try {
			ArrayList arrList = getSelectedValue_med();
			connection = getConnection() ;
			//pstmt = connection.prepareStatement("SELECT DISTINCT trn_group_ref prescription_id, a.patient_id, a.encounter_id, b.patient_name, short_desc disp_locn,TO_CHAR (f.disp_date_time, 'dd/mm/yyyy') disp_date_time,practitioner_name, DECODE (a.patient_class, 'OP', TO_CHAR (f.token_serial_no), 'XT', TO_CHAR (f.token_serial_no), 'IP', f.daily_seq_num) token_daily_seq_no,f.fill_proc_id,f.disp_locn_code FROM or_order a, mp_patient b,ph_disp_locn_lang_vw c,(SELECT 'D' stage, order_id, token_serial_no, patient_class,daily_seq_num, patient_id, facility_id,disp_date_time disp_date_time, disp_locn_code, fill_proc_id FROM ph_disp_hdr  UNION ALL SELECT 'F' stage, order_id, token_serial_no, patient_class, daily_seq_num, patient_id, facility_id, dispensed_date_time disp_date_time, disp_locn_code,fill_proc_id FROM ph_disp_hdr_tmp )  f, am_practitioner_lang_vw g WHERE a.patient_id = b.patient_id AND a.performing_deptloc_code = c.disp_locn_code AND a.order_id = f.order_id AND a.performing_deptloc_code = f.disp_locn_code AND a.ord_pract_id = g.practitioner_id AND g.language_id = ? AND f.facility_id = ? AND c.language_id = ? AND c.facility_id = ? AND TRUNC (f.disp_date_time) BETWEEN TO_DATE (?,'DD/MM/YYYY')AND TO_DATE (?,'DD/MM/YYYY')AND a.trn_group_ref = NVL (?, a.trn_group_ref) AND a.patient_id = NVL (?, a.patient_id) AND a.encounter_id = NVL (?, a.encounter_id) AND a.source_type = NVL (?, a.source_type) AND a.source_code = NVL (?, a.source_code) AND /* a.ord_pract_id = NVL (?, a.ord_pract_id) AND  */ NVL (f.fill_proc_id, '999999') = NVL (?, NVL (f.fill_proc_id, '999999')) AND f.disp_locn_code = NVL (?, f.disp_locn_code) AND NVL (f.daily_seq_num, 'X') BETWEEN DECODE (a.patient_class,'IP', NVL (?, NVL (f.daily_seq_num, 'X')), NVL (f.daily_seq_num, 'X'))AND DECODE (a.patient_class,'IP', NVL (?, NVL (f.daily_seq_num, 'X')),NVL(f.daily_seq_num, 'X'))AND NVL (f.token_serial_no, '99')BETWEEN DECODE (a.patient_class,'OP', NVL (?,NVL (f.token_serial_no, '99')),NVL (f.token_serial_no, '99'))AND DECODE (a.patient_class,'OP', NVL (?,NVL (f.token_serial_no, '99')),NVL (f.token_serial_no, '99'))ORDER BY to_Date(disp_date_time,'DD/MM/YYYY') DESC,to_number(token_daily_seq_no) desc");

//Modified Above Query For getting Patient name into specified language regarding incident num:25076 on 2/Dec/2010===By Sandhya
			pstmt = connection.prepareStatement("SELECT DISTINCT trn_group_ref prescription_id, a.patient_id, a.encounter_id, nvl(decode(?,'en',b.patient_name,PATIENT_NAME_LOC_LANG),b.patient_name)patient_name, short_desc disp_locn,TO_CHAR (f.disp_date_time, 'dd/mm/yyyy') disp_date_time,practitioner_name, DECODE (a.patient_class, 'OP', TO_CHAR (f.token_serial_no), 'XT', TO_CHAR (f.token_serial_no), 'IP', f.daily_seq_num) token_daily_seq_no,f.fill_proc_id,f.disp_locn_code FROM or_order a, mp_patient b,ph_disp_locn_lang_vw c,(SELECT 'D' stage, order_id, token_serial_no, patient_class,daily_seq_num, patient_id, facility_id,disp_date_time disp_date_time, disp_locn_code, fill_proc_id FROM ph_disp_hdr  UNION ALL SELECT 'F' stage, order_id, token_serial_no, patient_class, daily_seq_num, patient_id, facility_id, dispensed_date_time disp_date_time, disp_locn_code,fill_proc_id FROM ph_disp_hdr_tmp )  f, am_practitioner_lang_vw g WHERE a.patient_id = b.patient_id AND a.performing_deptloc_code = c.disp_locn_code AND a.order_id = f.order_id AND a.performing_deptloc_code = f.disp_locn_code AND a.ord_pract_id = g.practitioner_id AND g.language_id = ? AND f.facility_id = ? AND c.language_id = ? AND c.facility_id = ? AND TRUNC (f.disp_date_time) BETWEEN TO_DATE (?,'DD/MM/YYYY')AND TO_DATE (?,'DD/MM/YYYY')AND a.trn_group_ref = NVL (?, a.trn_group_ref) AND a.patient_id = NVL (?, a.patient_id) AND a.encounter_id = NVL (?, a.encounter_id) AND a.source_type = NVL (?, a.source_type) AND a.source_code = NVL (?, a.source_code) AND /* a.ord_pract_id = NVL (?, a.ord_pract_id) AND  */ NVL (f.fill_proc_id, '999999') = NVL (?, NVL (f.fill_proc_id, '999999')) AND f.disp_locn_code = NVL (?, f.disp_locn_code) AND NVL (f.daily_seq_num, 'X') BETWEEN DECODE (a.patient_class,'IP', NVL (?, NVL (f.daily_seq_num, 'X')), NVL (f.daily_seq_num, 'X'))AND DECODE (a.patient_class,'IP', NVL (?, NVL (f.daily_seq_num, 'X')),NVL(f.daily_seq_num, 'X'))AND NVL (f.token_serial_no, '99')BETWEEN DECODE (a.patient_class,'OP', NVL (?,NVL (f.token_serial_no, '99')),NVL (f.token_serial_no, '99'))AND DECODE (a.patient_class,'OP', NVL (?,NVL (f.token_serial_no, '99')),NVL (f.token_serial_no, '99'))ORDER BY to_Date(disp_date_time,'DD/MM/YYYY') DESC,to_number(token_daily_seq_no) desc");
			pstmt.setString(1,locale.trim());
			pstmt.setString(2,locale.trim());
			pstmt.setString(3,p_facility_id.trim());
			pstmt.setString(4,locale.trim());
			pstmt.setString(5,p_facility_id.trim());
			pstmt.setString(6,fr_dispdate.trim());
			pstmt.setString(7,to_dispdate.trim());
			pstmt.setString(8,p_fr_pre.trim());
			pstmt.setString(9,patient_id.trim());
			pstmt.setString(10,p_encounter.trim());
			pstmt.setString(11,locn_type.trim());
			pstmt.setString(12,p_locn_code.trim());
	//		pstmt.setString(12,pract_code.trim());
			pstmt.setString(13,p_fill_id.trim());
			pstmt.setString(14,p_disp_locn_code.trim());
			pstmt.setString(15,p_tokfr.trim());
			pstmt.setString(16,p_tokto.trim());
			pstmt.setString(17,p_tokfr.trim());
			pstmt.setString(18,p_tokto.trim());
			resultSet = pstmt.executeQuery() ;

			//resultSet = pstmt.executeQuery() ;
            int cunt=0;
			while ( resultSet.next() ) {
			
		    	String arr[] = new String[10];	
				arr[0]=resultSet.getString("disp_date_time");
				arr[1]=resultSet.getString("token_daily_seq_no");
				arr[2]=resultSet.getString("FILL_PROC_ID");
				arr[3]=resultSet.getString("patient_id");
				arr[4]=resultSet.getString("patient_name");
				String pre_id =resultSet.getString("prescription_id")+"#"+cunt;
				arr[5]=pre_id;
				if(arrList != null && arrList.contains(pre_id))
				arr[9]="Y";
				else
				arr[9]="N";
				arr[6]=resultSet.getString("encounter_id");
				arr[7]=resultSet.getString("practitioner_name");
				arr[8]=resultSet.getString("disp_locn_code");
				//arr[8]=p_disp_locn_code.trim();
				
               	records.add(arr);
				cunt++;
			}
			setMedicationListRecds(records);	
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

	public void setSelectedValue_med (String pre_id){
		if (selList_med == null)
				selList_med = new ArrayList();
		if(!selList_med.contains(pre_id)){  
			
			
			selList_med.add(pre_id);
		
			//ArrayList getList_med = this.active_MedicationListRecds; //Commented by sandhya on 7/sept/2010  for the incident num:23670
			ArrayList getList_med = getDispenseSheetListRecds(); 
			if(getList_med==null){
				 getList_med = getMedicationListRecds();
			}
			//ArrayList getList_med = getMedicationListRecds();
			if(getList_med != null){
				for(int i=0;i<getList_med.size();i++){
					String [] record= (String[])getList_med.get(i);
					if(record[5].equals(pre_id)){
						record[9] = "Y";
					}
				}
			}
		}
	}

	public void removeValue_med(String pre_id){
	
		ArrayList getList_med = null;
		if(selList_med != null && selList_med.contains(pre_id)){
			selList_med.remove(pre_id);
			//ArrayList getList_med = this.active_MedicationListRecds;	//commented by sandhya fotr the incident num:23670 in spira on 7/sep/2010
			getList_med =getDispenseSheetListRecds();	
			if(getList_med==null) {    //Handled Null for getting Medication list Records on 27/sept/2010
					getList_med =getMedicationListRecds();
			}
			
			for(int i=0;i<getList_med.size();i++){
				String [] record= (String[])getList_med.get(i);
				if(record[5].equals(pre_id)){
					record[9] = "N";
				}
			}

		}
		else{
			selList_med.remove(pre_id);
			getList_med = this.active_MedicationListRecds;
		}
	}

	public ArrayList getSelectedValue_med(){
		return this.selList_med;
	}

	// This method is used to retrieve the data depending on the query criteria
	public ArrayList DispenseSheetList(String patient_id,String fr_dispdate,String to_dispdate,String p_encounter,String p_fr_pre,String p_tokfr,String p_tokto,String p_disp_locn_code,String locn_type,String p_locn_code,String p_fill_id,String p_facility_id,String locale)throws Exception{

	
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();

     		try {

			ArrayList arrList = getSelectedValue_disp();
			connection = getConnection() ;
			//pstmt = connection.prepareStatement("SELECT DISTINCT trn_group_ref prescription_id, a.patient_id, a.encounter_id, b.patient_name, short_desc disp_locn,TO_CHAR (f.disp_date_time, 'dd/mm/yyyy') disp_date_time,practitioner_name, DECODE (a.patient_class, 'OP', TO_CHAR (f.token_serial_no), 'XT', TO_CHAR (f.token_serial_no), 'IP', f.daily_seq_num) token_daily_seq_no,f.fill_proc_id,f.disp_locn_code FROM or_order a, mp_patient b,ph_disp_locn_lang_vw c,(SELECT 'D' stage, order_id, token_serial_no, patient_class,daily_seq_num, patient_id, facility_id,disp_date_time disp_date_time, disp_locn_code, fill_proc_id FROM ph_disp_hdr  UNION ALL SELECT 'F' stage, order_id, token_serial_no, patient_class, daily_seq_num, patient_id, facility_id,dispensed_date_time disp_date_time, disp_locn_code,fill_proc_id FROM ph_disp_hdr_tmp )  f, am_practitioner_lang_vw g WHERE a.patient_id = b.patient_id AND a.performing_deptloc_code = c.disp_locn_code AND a.order_id = f.order_id AND a.performing_deptloc_code = f.disp_locn_code AND a.ord_pract_id = g.practitioner_id AND g.language_id = ? AND f.facility_id = ? AND c.language_id = ? AND c.facility_id = ? AND TRUNC (f.disp_date_time) BETWEEN TO_DATE (?,'DD/MM/YYYY')AND TO_DATE (?,'DD/MM/YYYY')AND a.trn_group_ref = NVL (?, a.trn_group_ref) AND a.patient_id = NVL (?, a.patient_id) AND a.encounter_id = NVL (?, a.encounter_id) AND a.source_type = NVL (?, a.source_type) AND a.source_code = NVL (?, a.source_code) AND /* a.ord_pract_id = NVL (?, a.ord_pract_id) AND  */ NVL (f.fill_proc_id, '999999') = NVL (?, NVL (f.fill_proc_id, '999999')) AND f.disp_locn_code = NVL (?, f.disp_locn_code) AND NVL (f.daily_seq_num, 'X') BETWEEN DECODE (a.patient_class,'IP', NVL (?, NVL (f.daily_seq_num, 'X')), NVL (f.daily_seq_num, 'X'))AND DECODE (a.patient_class,'IP', NVL (?, NVL (f.daily_seq_num, 'X')),NVL(f.daily_seq_num, 'X'))AND NVL (f.token_serial_no, '99')BETWEEN DECODE (a.patient_class,'OP', NVL (?,NVL (f.token_serial_no, '99')),NVL (f.token_serial_no, '99'))AND DECODE (a.patient_class,'OP', NVL (?,NVL (f.token_serial_no, '99')),NVL (f.token_serial_no, '99'))ORDER BY to_date(disp_date_time,'DD/MM/YYYY') desc,to_number(token_daily_seq_no) DESC");
//Modified Query For getting Patient name into specified language regarding incident nums:25081,25078 on 30/NOV/2010===By Sandhya 
			pstmt = connection.prepareStatement("SELECT DISTINCT trn_group_ref prescription_id, a.patient_id, a.encounter_id, nvl(decode(?,'en',b.patient_name,PATIENT_NAME_LOC_LANG),b.patient_name)patient_name, short_desc disp_locn,TO_CHAR (f.disp_date_time, 'dd/mm/yyyy') disp_date_time,practitioner_name, DECODE (a.patient_class, 'OP', TO_CHAR (f.token_serial_no), 'XT', TO_CHAR (f.token_serial_no), 'IP', f.daily_seq_num) token_daily_seq_no,f.fill_proc_id,f.disp_locn_code FROM or_order a, mp_patient b,ph_disp_locn_lang_vw c,(SELECT 'D' stage, order_id, token_serial_no, patient_class,daily_seq_num, patient_id, facility_id,disp_date_time disp_date_time, disp_locn_code, fill_proc_id FROM ph_disp_hdr  UNION ALL SELECT 'F' stage, order_id, token_serial_no, patient_class, daily_seq_num, patient_id, facility_id,dispensed_date_time disp_date_time, disp_locn_code,fill_proc_id FROM ph_disp_hdr_tmp )  f, am_practitioner_lang_vw g WHERE a.patient_id = b.patient_id AND a.performing_deptloc_code = c.disp_locn_code AND a.order_id = f.order_id AND a.performing_deptloc_code = f.disp_locn_code AND a.ord_pract_id = g.practitioner_id AND g.language_id = ? AND f.facility_id = ? AND c.language_id = ? AND c.facility_id = ? AND TRUNC (f.disp_date_time) BETWEEN TO_DATE (?,'DD/MM/YYYY')AND TO_DATE (?,'DD/MM/YYYY')AND a.trn_group_ref = NVL (?, a.trn_group_ref) AND a.patient_id = NVL (?, a.patient_id) AND a.encounter_id = NVL (?, a.encounter_id) AND a.source_type = NVL (?, a.source_type) AND a.source_code = NVL (?, a.source_code) AND /* a.ord_pract_id = NVL (?, a.ord_pract_id) AND  */ NVL (f.fill_proc_id, '999999') = NVL (?, NVL (f.fill_proc_id, '999999')) AND f.disp_locn_code = NVL (?, f.disp_locn_code) AND NVL (f.daily_seq_num, 'X') BETWEEN DECODE (a.patient_class,'IP', NVL (?, NVL (f.daily_seq_num, 'X')), NVL (f.daily_seq_num, 'X'))AND DECODE (a.patient_class,'IP', NVL (?, NVL (f.daily_seq_num, 'X')),NVL(f.daily_seq_num, 'X'))AND NVL (f.token_serial_no, '99')BETWEEN DECODE (a.patient_class,'OP', NVL (?,NVL (f.token_serial_no, '99')),NVL (f.token_serial_no, '99'))AND DECODE (a.patient_class,'OP', NVL (?,NVL (f.token_serial_no, '99')),NVL (f.token_serial_no, '99'))ORDER BY to_date(disp_date_time,'DD/MM/YYYY') desc,to_number(token_daily_seq_no) DESC");

			pstmt.setString(1,locale.trim());
			pstmt.setString(2,locale.trim());
			pstmt.setString(3,p_facility_id.trim());
			pstmt.setString(4,locale.trim());
			pstmt.setString(5,p_facility_id.trim());
			pstmt.setString(6,fr_dispdate.trim());
			pstmt.setString(7,to_dispdate.trim());
			pstmt.setString(8,p_fr_pre.trim());
			pstmt.setString(9,patient_id.trim());
			pstmt.setString(10,p_encounter.trim());
			pstmt.setString(11,locn_type.trim());
			pstmt.setString(12,p_locn_code.trim());
	//		pstmt.setString(12,pract_code.trim());
			pstmt.setString(13,p_fill_id.trim());
			pstmt.setString(14,p_disp_locn_code.trim());
			pstmt.setString(15,p_tokfr.trim());
			pstmt.setString(16,p_tokto.trim());
			pstmt.setString(17,p_tokfr.trim());
			pstmt.setString(18,p_tokto.trim());
			
			resultSet = pstmt.executeQuery() ;

			resultSet = pstmt.executeQuery() ;
            int cunt=0;
			while ( resultSet.next() ) {
			
		    	String arr[] = new String[10];	
				arr[0]=resultSet.getString("disp_date_time");
				arr[1]=resultSet.getString("token_daily_seq_no");
				if( (resultSet.getString("FILL_PROC_ID")==null) || (resultSet.getString("FILL_PROC_ID").equals(""))) {
					arr[2]	=	"";
				} else {
					arr[2]=resultSet.getString("FILL_PROC_ID");
				}
				
				arr[3]=resultSet.getString("patient_id");
				arr[4]=resultSet.getString("patient_name");
				String pre_id =resultSet.getString("prescription_id")+"#"+cunt;
				arr[5]=pre_id;
				if(arrList != null && arrList.contains(pre_id))
				arr[9]="Y";
				else
				arr[9]="N";
				arr[6]=resultSet.getString("encounter_id");
				arr[7]=resultSet.getString("practitioner_name");
				arr[8]=resultSet.getString("disp_locn_code");
				//arr[8]=p_disp_locn_code.trim();
				
				
               	records.add(arr);
				cunt++;
			}
			setDispenseSheetListRecds(records);	
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
/*   DispenseSheetList desc returns ends here    */

	public void setSelectedValue_disp(String pre_id){

		if (selList_disp == null)
			selList_disp = new ArrayList();

		if(!selList_disp.contains(pre_id)){
			selList_disp.add(pre_id);
			ArrayList getList_disp = this.active_DispenseSheetListRecds;
			for(int i=0;i<getList_disp.size();i++){
				String [] record= (String[])getList_disp.get(i);
				
					if(record[5].equals(pre_id)){
					record[9] = "Y";
				}
			}
		}
	}

	public void removeValue_disp(String pre_id){
		if(selList_disp != null && selList_disp.contains(pre_id)){
			selList_disp.remove(pre_id);
			ArrayList getList_disp = this.active_DispenseSheetListRecds;	

			for(int i=0;i<getList_disp.size();i++){
				String [] record= (String[])getList_disp.get(i);
				if(record[5].equals(pre_id)){
					record[9] = "N";
				}
			}
		}
	}

	public ArrayList getSelectedValue_disp(){
		return this.selList_disp;
	}
////getPatientActiveOrders
	public ArrayList getDrugLabelActiveOrders(String patient_id,String orderid,String facility_id,String locale){

		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
	//	String sql_str				=	"";
		String	start_date			=	"";
		String	end_date			=	"";
		String	drug_desc			=	"";
		String	strength			=	"";
		String	split_dose_prev		=	"";
		String	strength_uom_desc	=	"";
		String	form_desc			=	"";
		String	practitioner_name	=	"";
		String	facility_name		=	"";
		String	diag_text			=	"";
		String location				=	"";
		String order_id				=	"";
		String order_line_no		=	"";
		String freq_code			=	"";
		String freq_desc			=	"";
		String allergy_reason		=	"";
		String dosage_reason		=	"";
		String duplicate_reason		=	"";
		String discont_date_time	=	"";
	//	String perf_locn			=	"";
		String iv_prep_yn			=   "";
		String discharge_ind		=	"";
		String in_formulary_yn		=	"";
		String dosage				=	"";
		String dosage_uom_code		=	"";
	//	String append_qry			=	"";
	//	String per_facility_name	=	"";
	//	String locale               =   "";
			   order_date		    =   "";

		String  pres_practitioner_id=	"";
		String	drug_code	        =	"";
		String	trn_group_ref	    =	"";
		//String	disp_no	            =	"";
	//	String	srl_no	            =	"";
		String	prescribed_qty      =  "";
		String	pref_locn           =  "";
		String	patient_class       =  "";
		String drug_yn		=		"";

		ArrayList activeOrders	= new ArrayList();
		HashMap	record			= null;
		
		try{
		
			connection			= getConnection() ;
            pstmt = connection.prepareStatement("SELECT a.discont_date_time, a.patient_id, a.allergy_override_reason,a.dosage_limit_override_reason, a.duplicate_drug_override_reason,a.orig_order_id, a.orig_order_line_no, c.in_formulary_yn, a.dosage,a.dosage_uom_code, a.split_dose_preview, a.freq_code, g.freq_desc,a.pres_practitioner_id, b.practitioner_name, h.discharge_ind,a.drug_code, c.drug_desc, a.strength, c.strength_uom, c.form_code,TO_CHAR (a.start_date, 'DD/MM/YYYY hh24:mi') start_date,TO_CHAR (a.end_date, 'DD/MM/YYYY hh24:mi') end_date, a.dosage,a.dosage_uom_code, a.prescribed_qty, a.diag_text, d.facility_name,a.patient_class, DECODE (a.patient_class,'IP', f.long_desc,'EA', f.long_desc,e.long_desc)LOCATION,h.iv_prep_yn, h.trn_group_ref, k.short_desc pref_locn, c.drug_yn FROM ph_patient_drug_profile a,am_practitioner_lang_vw b,sm_facility_param_lang_vw d,op_clinic_lang_vw e,ip_nursing_unit_lang_vw f,or_order h,(SELECT in_formulary_yn, drug_desc,drug_code, strength_uom, form_code, drug_yn FROM ph_drug_lang_vw WHERE language_id = ? UNION SELECT 'N' in_formulary_yn, NVL (short_name, long_name) drug_desc,tpn_regimen_code drug_code, '' strength_uom,'' form_code, 'Y' drug_yn FROM ph_tpn_regimen_lang_vw WHERE language_id =?) c,am_frequency_lang_vw g,ph_disp_locn_lang_vw k WHERE a.patient_id = ? AND a.pres_practitioner_id = b.practitioner_id(+) AND a.facility_id = d.facility_id AND a.facility_id = e.facility_id(+) AND a.locn_code = e.clinic_code(+) AND a.facility_id = f.facility_id(+) AND a.locn_code = f.nursing_unit_code(+) AND a.drug_code = c.drug_code AND a.freq_code = g.freq_code AND a.orig_order_id = h.order_id AND a.patient_id = h.patient_id AND a.discont_date_time IS NULL AND a.on_hold_date_time IS NULL AND a.cancel_yn = 'N' AND a.stop_yn = 'N' AND d.language_id = ? AND g.language_id = ? AND b.language_id(+) = ? AND e.language_id(+) = ? AND f.language_id(+) = ? AND h.trn_group_ref = ? AND k.disp_locn_code = h.performing_deptloc_code AND k.language_id = ? ORDER BY a.orig_order_id, a.orig_order_line_no");
			// query modified for IN25904 to get drug_yn value --14-01-2011-- priya

			pstmt.setString(1,locale.trim());
			pstmt.setString(2,locale.trim());
			pstmt.setString(3,patient_id.trim());
			pstmt.setString(4,locale.trim());
			pstmt.setString(5,locale.trim());
			pstmt.setString(6,locale.trim());
			pstmt.setString(7,locale.trim());
			pstmt.setString(8,locale.trim());
			pstmt.setString(9,orderid.trim());
			pstmt.setString(10,locale.trim());

			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				record	=	new HashMap();
				start_date			=	resultSet.getString("START_DATE");
				end_date			=	resultSet.getString("END_DATE");
				drug_desc			=	resultSet.getString("DRUG_DESC");
				strength			=	resultSet.getString("STRENGTH");
				split_dose_prev		=	resultSet.getString("SPLIT_DOSE_PREVIEW");
				strength_uom_desc	=	resultSet.getString("STRENGTH_UOM");
				form_desc			=	resultSet.getString("FORM_CODE");
				practitioner_name	=	resultSet.getString("PRACTITIONER_NAME");
				facility_name		=	resultSet.getString("FACILITY_NAME");
				diag_text			=	resultSet.getString("DIAG_TEXT");
				location			=	resultSet.getString("LOCATION");
				order_id			=	resultSet.getString("ORIG_ORDER_ID");
				order_line_no		=	resultSet.getString("ORIG_ORDER_LINE_NO");
				freq_code			=	resultSet.getString("FREQ_CODE");
				freq_desc			=	resultSet.getString("FREQ_DESC");
				allergy_reason		=	resultSet.getString("ALLERGY_OVERRIDE_REASON");
				dosage_reason		=	resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON");
				duplicate_reason	=	resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON");
				discont_date_time	=	resultSet.getString("DISCONT_DATE_TIME");
				patient_id	        =	resultSet.getString("PATIENT_ID");
				pres_practitioner_id=	resultSet.getString("PRES_PRACTITIONER_ID");
				drug_code	        =	resultSet.getString("drug_code");
				patient_class	    =	resultSet.getString("patient_class");
				trn_group_ref	    =	resultSet.getString("TRN_GROUP_REF");
				//disp_no	            =	resultSet.getString("DISP_NO");
				//srl_no	            =	resultSet.getString("SRL_NO");
				prescribed_qty	    =	resultSet.getString("PRESCRIBED_QTY");
				iv_prep_yn			=   resultSet.getString("IV_PREP_YN");
				discharge_ind		=   resultSet.getString("DISCHARGE_IND");
				in_formulary_yn		=	resultSet.getString("IN_FORMULARY_YN");
				dosage				=	resultSet.getString("DOSAGE");
				pref_locn			=	resultSet.getString("PREF_LOCN");
				drug_yn				=	resultSet.getString("DRUG_YN");
							
				if(dosage != null && dosage != "" && Float.parseFloat(dosage) < 1)
					dosage = Float.parseFloat(dosage)+"";
				dosage_uom_code		=	resultSet.getString("DOSAGE_UOM_CODE");


				if(!locale.equals("en")){
					start_date = com.ehis.util.DateUtils.convertDate(start_date, "DMYHM","en",locale);
					end_date = com.ehis.util.DateUtils.convertDate(end_date, "DMYHM","en",locale);
					discont_date_time = com.ehis.util.DateUtils.convertDate(discont_date_time, "DMYHM","en",locale);

				}

				record.put("start_date",start_date);
				record.put("end_date",end_date);
				record.put("drug_desc",drug_desc);
				record.put("strength",strength);
				record.put("split_dose_prev",split_dose_prev);
				record.put("strength_uom_desc",strength_uom_desc);
				record.put("form_desc",form_desc);
				record.put("practitioner_name",practitioner_name);
				record.put("facility_name",facility_name);
				record.put("diag_text",diag_text);
				record.put("location",location);
				record.put("order_id",order_id);
				record.put("order_line_no",order_line_no);
				record.put("freq_code",freq_code);
				record.put("freq_desc",freq_desc);
				record.put("allergy_reason",allergy_reason);
				record.put("dosage_reason",dosage_reason);
				record.put("duplicate_reason",duplicate_reason);
				record.put("discont_date_time",discont_date_time);
				record.put("patient_id",patient_id);
				record.put("pres_practitioner_id",pres_practitioner_id);
				record.put("drug_code",drug_code);
				record.put("patient_class",patient_class);
				record.put("trn_group_ref",trn_group_ref);
			//	record.put("disp_no",disp_no);
			//	record.put("srl_no",srl_no);
				record.put("prescribed_qty",prescribed_qty);
				record.put("iv_prep_yn",iv_prep_yn);
				record.put("discharge_ind",discharge_ind);
				record.put("in_formulary_yn",in_formulary_yn);
				record.put("dosage",dosage);
				record.put("dosage_uom_code",dosage_uom_code);
				record.put("flag","N");
				record.put("pref_locn",pref_locn.trim());
				record.put("orderid",orderid.trim());
				record.put("drug_yn",drug_yn);
				activeOrders.add(record);
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
			setDrugActiveOrders(activeOrders);
		}
		catch(Exception e){
			activeOrders.add(e.toString());
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

		return activeOrders;
	}


	public HashMap  insert(HashMap selMap) throws Exception{
       
		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
	//	PreparedStatement pstmt1	= null ;  Removed for IN063877
        HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
			//	int[] rowsInserted_dtl					  = new int[100];
		try{
			connection			= getConnection() ;
			String sql_delete ="Delete from PH_PRINT_PRES_RECORDS where ADDED_AT_WS_NO =? and ADDED_FACILITY_ID =? ";
			pstmt				= connection.prepareStatement(sql_delete);
			if (selMap != null && selMap.size() > 0){
				Set<String> keySet = selMap.keySet();
				for(String key : keySet){ 
					ArrayList arrList = (ArrayList)selMap.get(key);
					if (arrList != null && arrList.size() > 0){

						pstmt.setString(1,((String)arrList.get(2)).trim());
						pstmt.setString(2,((String)arrList.get(4)).trim());
						pstmt.executeUpdate();
					}						
				}
			}
			closeStatement( pstmt ) ;
			pstmt=connection.prepareStatement("insert into PH_PRINT_PRES_RECORDS (ORDER_ID,ORDER_LINE_NO,ADDED_AT_WS_NO,ADDED_DATE,ADDED_BY_ID,ADDED_FACILITY_ID) VALUES(?,?,?,SYSDATE,?,?)");
			if (selMap != null && selMap.size() > 0){
				Set<String> keySet = selMap.keySet();
				for(String key : keySet){ 
					ArrayList arrList = (ArrayList)selMap.get(key);
					if (arrList != null && arrList.size() > 0){
						pstmt.setString(1,(String) arrList.get(0));
						pstmt.setString(2,(String) arrList.get(1));
						pstmt.setString(3,(String) arrList.get(2));
						pstmt.setString(4,(String) arrList.get(3));
						pstmt.setString(5,(String) arrList.get(4));
						pstmt.addBatch();

					}						
				}
			}

			int[] rowsInserted			= pstmt.executeBatch();
			closeStatement( pstmt ) ;

			for (int i=0; i<rowsInserted.length; i++) {
				if (rowsInserted[i] < 0 && rowsInserted[i] != -2) {
					connection.rollback();
				}
				else  {
					map.put( "result", new Boolean( true ) ) ;	
					map.put( "message", getMessage(getLanguageId(),"RECORD_INSERTED","PH") ) ;
				}
			}
			connection.commit();
			selMap.clear();  
		  
		}
		catch(Exception e){
			map.put( "result", new Boolean( false ) ) ; 
			map.put( "message", "exp : insert method :"+e.getMessage()) ;
			map.put("flag","0");
			e.printStackTrace() ;
			try{
				connection.rollback();
			}
			catch(Exception ee){
				ee.printStackTrace() ;
			}
		}
		finally{
			try{
				connection.commit();
                closeStatement( pstmt ) ;
                closeConnection( connection );
			}
			catch(Exception e) {
				e.printStackTrace() ;
			}
		}
		return map;
	}

	public void setSelectedValue_drug(String pre_id){
		ArrayList active_orders		=	new ArrayList();		
		active_orders	=	this.active_orders;
		for (int i=0; i<active_orders.size(); i++) {
			HashMap record	=	(HashMap)	active_orders.get(i);
		  	String  order_id=(String) record.get("order_id");
			if(order_id.equals(pre_id)){
			   record.put("flag","Y");
			}
		}
	}

	public void removeValue_drug(String pre_id){
		ArrayList active_orders		=	new ArrayList();		
		active_orders	=	this.active_orders;
		for (int i=0; i<active_orders.size(); i++) {
			HashMap record	=	(HashMap)	active_orders.get(i);
		  	String  order_id=(String) record.get("order_id");
     		if(order_id.equals(pre_id)){
				record.put("flag","N");
			}
		}
	}
}

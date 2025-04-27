/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*---------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		         Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
22/11/2023      51468           Hariharan          23/11/2023        ramesh goli         ML-MMOH-CRF-1994					
---------------------------------------------------------------------------------------------------------------------------------------------------------*/
 //saved on 02.11.2005 
package ePH ;
import java.io.* ; 
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ; 
import eCommon.Common.* ;

public class PrintPrescriptionReportBean extends PhAdapter implements Serializable {

	public PrintPrescriptionReportBean() {
		try {
			doCommon();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	} 
	protected ArrayList selectedDispNos = null;//Added for Bru-HIMS-CRF-415 [IN:045556]
	protected String CDROrdersYN = "N";//Added for 57362 ML-MMOH-CRF-0347

	public ArrayList getSelectedDispNos(){ //Added for Bru-HIMS-CRF-415 [IN:045556] -start
		return this.selectedDispNos;
	}
	public void setSelectedDispNos(ArrayList selectedDispNos){
		this.selectedDispNos = selectedDispNos;
	} //Added for Bru-HIMS-CRF-415 [IN:045556] -end

	public String getCDROrdersYN(){ //Added for 57362 ML-MMOH-CRF-0347 -start
		return this.CDROrdersYN;
	}
	public void setCDROrdersYN(String CDROrdersYN){
		this.CDROrdersYN = CDROrdersYN;
	} //Added for 57362 ML-MMOH-CRF-0347-end

	public void clear() {
		super.clear() ;
		selectedDispNos = null;//Added for Bru-HIMS-CRF-415 [IN:045556]
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

	/************ getOrderTypeFormdd7() starts******************/
	public ArrayList getOrderTypeFormdd7() throws Exception{	
		Connection connection			= null ;
        PreparedStatement pstmt			= null ;
        ResultSet resultSet				= null;
		ArrayList order_type_formdd7	= new ArrayList();

        try {
			connection = getConnection() ;
		    //pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT157") ) ;
		    pstmt = connection.prepareStatement("SELECT  ORDER_TYPE_CODE, SHORT_DESC FROM OR_ORDER_TYPE WHERE ORDER_TYPE_CODE IN (SELECT ORDER_TYPE_CODE FROM PH_ORDER_TYPE_FOR_DRUG_CLASS WHERE DRUG_CLASS = 'N')") ;
		    resultSet = pstmt.executeQuery() ;
			while( resultSet.next() ) {
				order_type_formdd7.add(resultSet.getString("ORDER_TYPE_CODE") );
				order_type_formdd7.add(resultSet.getString("SHORT_DESC") );
			} 
        }
        catch ( Exception e ) {
            System.err.println( "Error while while getting ORDER TYPE " ) ;
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
		return order_type_formdd7;
	} //End of getOrderTypeFormdd7 arrlist.

	/*
		This function is used to get the Country Code and Description							
	*/
	public ArrayList getNationalityDetails()throws Exception{
		ArrayList result = new ArrayList();
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT11") ) ;
		    pstmt.setString(1,getLanguageId());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				result.add(resultSet.getString("COUNTRY_CODE"));
				result.add(resultSet.getString("SHORT_NAME"));
			}
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
            catch(Exception es) { es.printStackTrace();}
        }
		return result;
	}

	//*********** getNationID() starts*****************//
	public String getNationID() throws Exception{
		//System.err.println("Entering in togetNationID--- ");
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String national_id		= "";
		try {
            connection	= getConnection() ;
           // pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT21")) ;
			 pstmt		= connection.prepareStatement(" select nat_id_prompt from mp_param") ;
			//pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				national_id = checkForNull(resultSet.getString("NAT_ID_PROMPT"));
				//System.err.println("national_id---- in bean----" +national_id);
			}
		}catch ( Exception e ) {
			System.err.println( e ) ;
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
		}
		return national_id;
	} //Ends
	/*
		This function is used to get the health card number of the patient
	*/
	public ArrayList getNationalityHealthCardNo(String patient_id) throws Exception{
		ArrayList result = new ArrayList();
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT13") ) ;
			pstmt.setString(1,patient_id.trim());
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,getLanguageId());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				result.add(resultSet.getString("NATIONALITY_DESC"));
				result.add(resultSet.getString("NAT_ID_NO"));
			}
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
            catch(Exception es) {es.printStackTrace();}
        }
		return result;
	}
	// This method is used to retrieve the data depending on the query criteria
	public ArrayList getAllPresBasedOnQuery(String patient_id,String orig_order_id,String order_date_from,String order_date_to,String encounter_id,String pres_practitioner_id,String locn_type,String locn_code,String facility_id,String from,String to,String order_type,String ord_by)throws Exception{
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String orderby="";
		
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;

		if(ord_by.equals("DESCEND"))
			orderby=" DESC";
		else
			orderby="";
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
			//sql=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT"); Commented for ML-BRU-SCF-1181[Inc : 45506]
			//Added below sql for ML-BRU-SCF-1181[Inc : 45506] -Start
			//sql="SELECT distinct(a.orig_order_id) orig_order_id, A.PATIENT_ID,B.PATIENT_NAME,A.ENCOUNTER_ID,A.LOCN_TYPE,A.PRES_PRACTITIONER_ID,TO_CHAR(A.START_DATE,'DD/MM/YYYY ') START_DATE,TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY ') ADDED_DATE, A.ADDED_DATE ORD_DATE, B.NATIONAL_ID_NO,C.ORDER_STATUS,D.PRACTITIONER_NAME,A.PATIENT_CLASS, A.LOCN_CODE , e.SHORT_DESC disp_locn_desc, C.IV_PREP_YN, c.ORDER_SET_ID FROM PH_PATIENT_DRUG_PROFILE A,MP_PATIENT B,OR_ORDER C,AM_PRACTITIONER_LANG_VW D,ph_disp_locn_lang_vw e WHERE A.PATIENT_ID = B.PATIENT_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.ORIG_ORDER_ID = C.ORDER_ID AND A.ORIG_ORDER_LINE_NO='1' AND A.ORIG_ORDER_ID = NVL(?,A.ORIG_ORDER_ID) AND A.ADDED_DATE BETWEEN TO_DATE(NVL(?,'01/01/1472'),'DD/MM/RRRR') AND   TO_DATE(NVL(?,'31/12/5000'),'DD/MM/RRRR') + 0.99999 AND A.PATIENT_ID = ? AND A.ENCOUNTER_ID = NVL(?,A.ENCOUNTER_ID) AND A.PRES_PRACTITIONER_ID = NVL(?,A.PRES_PRACTITIONER_ID) AND A.PRES_PRACTITIONER_ID = D.PRACTITIONER_ID  AND A.LOCN_TYPE = NVL(?,A.LOCN_TYPE) AND A.LOCN_CODE = NVL(?,A.LOCN_CODE) AND A.FACILITY_ID=? AND e.FACILITY_ID=C.PERFORMING_FACILITY_ID AND e.DISP_LOCN_CODE=c.PERFORMING_DEPTLOC_CODE AND e.LANGUAGE_ID =? AND     d.LANGUAGE_ID = ?"; // AND d.LANGUAGE_ID = e.LANGUAGE_ID commented for MOHE-SCF-0213 -  and added  AND e.language_id = :p_language_id /NMC-JD-CRF-0207
			//sql="SELECT distinct(a.orig_order_id) orig_order_id, A.PATIENT_ID,B.PATIENT_NAME,A.ENCOUNTER_ID,A.LOCN_TYPE,A.PRES_PRACTITIONER_ID,TO_CHAR(A.START_DATE,'DD/MM/YYYY ') START_DATE,TO_CHAR (c.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,c.ord_date_time ORD_DATE,B.NATIONAL_ID_NO,C.ORDER_STATUS,D.PRACTITIONER_NAME,A.PATIENT_CLASS, A.LOCN_CODE , e.SHORT_DESC disp_locn_desc, C.IV_PREP_YN, c.ORDER_SET_ID FROM PH_PATIENT_DRUG_PROFILE A,MP_PATIENT B,OR_ORDER C,AM_PRACTITIONER_LANG_VW D,ph_disp_locn_lang_vw e WHERE A.PATIENT_ID = B.PATIENT_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.ORIG_ORDER_ID = C.ORDER_ID AND A.ORIG_ORDER_LINE_NO='1' AND A.ORIG_ORDER_ID = NVL(?,A.ORIG_ORDER_ID) AND A.ADDED_DATE BETWEEN TO_DATE(NVL(?,'01/01/1472'),'DD/MM/RRRR') AND   TO_DATE(NVL(?,'31/12/5000'),'DD/MM/RRRR') + 0.99999 AND A.PATIENT_ID = ? AND A.ENCOUNTER_ID = NVL(?,A.ENCOUNTER_ID) AND A.PRES_PRACTITIONER_ID = NVL(?,A.PRES_PRACTITIONER_ID) AND A.PRES_PRACTITIONER_ID = D.PRACTITIONER_ID  AND A.LOCN_TYPE = NVL(?,A.LOCN_TYPE) AND A.LOCN_CODE = NVL(?,A.LOCN_CODE) AND A.FACILITY_ID=? AND e.FACILITY_ID=C.PERFORMING_FACILITY_ID AND e.DISP_LOCN_CODE=c.PERFORMING_DEPTLOC_CODE AND e.LANGUAGE_ID =? AND     d.LANGUAGE_ID = ?"; // AND d.LANGUAGE_ID = e.LANGUAGE_ID commented for MOHE-SCF-0213 -  and added  AND e.language_id = :p_language_id   //NMC-JD-CRF-0207//ML-MMOH-CRF-1994
			
			//Added below sql for ML-BRU-SCF-1181 [Inc : 45506]- End 
			
			//Modified the query for 52625
			sql = "SELECT distinct(a.orig_order_id) orig_order_id, A.PATIENT_ID,B.PATIENT_NAME,A.ENCOUNTER_ID,A.LOCN_TYPE,A.PRES_PRACTITIONER_ID,TO_CHAR(A.START_DATE,'DD/MM/YYYY ') START_DATE,TO_CHAR (c.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time,c.ord_date_time ORD_DATE,B.NATIONAL_ID_NO,C.ORDER_STATUS,D.PRACTITIONER_NAME,A.PATIENT_CLASS, A.LOCN_CODE , ( select e.short_desc  from ph_disp_locn_lang_vw e where e.disp_locn_code = c.performing_deptloc_code AND e.language_id = ?) disp_locn_desc, C.IV_PREP_YN, c.ORDER_SET_ID FROM PH_PATIENT_DRUG_PROFILE A,MP_PATIENT B,OR_ORDER C,AM_PRACTITIONER_LANG_VW D,ph_disp_locn_lang_vw e WHERE A.PATIENT_ID = B.PATIENT_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.ORIG_ORDER_ID = C.ORDER_ID AND A.ORIG_ORDER_LINE_NO='1' AND A.ORIG_ORDER_ID = NVL(?,A.ORIG_ORDER_ID) AND A.ADDED_DATE BETWEEN TO_DATE(NVL(?,'01/01/1472'),'DD/MM/RRRR') AND   TO_DATE(NVL(?,'31/12/5000'),'DD/MM/RRRR') + 0.99999 AND A.PATIENT_ID = ? AND (? IS NULL OR (? IS NOT NULL AND A.ENCOUNTER_ID=? )) AND A.PRES_PRACTITIONER_ID = NVL(?,A.PRES_PRACTITIONER_ID) AND A.PRES_PRACTITIONER_ID = D.PRACTITIONER_ID  AND A.LOCN_TYPE = NVL(?,A.LOCN_TYPE) AND (? IS NULL OR (? IS NOT NULL AND A.LOCN_CODE=? )) AND A.FACILITY_ID=? AND  d.LANGUAGE_ID = ?"; // AND d.LANGUAGE_ID = e.LANGUAGE_ID commented for MOHE-SCF-0213 -  and added  AND e.language_id = :p_language_id   //NMC-JD-CRF-0207//ML-MMOH-CRF-1994
			
			//Added below sql for ML-BRU-SCF-1181 [Inc : 45506]- End
			if(order_type.equals("All")){
				pstmt = connection.prepareStatement( sql +" AND (C.IV_PREP_YN IN ('0','1','2','3','4','5','6','7','8','9') OR C.IV_PREP_YN IS NULL) ORDER BY ORD_DATE"+orderby);
			}
			else if(order_type.equals("")){
				pstmt = connection.prepareStatement( sql +" AND C.IV_PREP_YN IS NULL ORDER BY ORD_DATE"+orderby);
			}
			else if(order_type.equals("C")){ //added for 57362 ML-MMOH-CRF-0347
				pstmt = connection.prepareStatement( sql +" AND C.IV_PREP_YN in ('0', '9') ORDER BY ORD_DATE"+orderby);
			}
			else {
				pstmt = connection.prepareStatement( sql +" AND C.IV_PREP_YN=? ORDER BY ORD_DATE"+orderby);
			}
			pstmt.setString(1, getLanguageId());//ML-MMOH-CRF-1994--ADDED
			pstmt.setString(2,orig_order_id.trim());
			pstmt.setString(3,order_date_from.trim());
			pstmt.setString(4,order_date_to.trim());
			pstmt.setString(5,patient_id.trim());
			pstmt.setString(6,encounter_id.trim()); //Extra parameters added for 52625
			pstmt.setString(7,encounter_id.trim()); //Extra parameters added for 52625
			pstmt.setString(8,encounter_id.trim()); 
			pstmt.setString(9,pres_practitioner_id.trim());
			pstmt.setString(10,locn_type.trim());
			pstmt.setString(11,locn_code.trim()); //Extra parameters added for 52625
			pstmt.setString(12,locn_code.trim()); //Extra parameters added for 52625
			pstmt.setString(13,locn_code.trim());
			pstmt.setString(14,facility_id.trim());
			pstmt.setString(15, getLanguageId());
			//pstmt.setString(11, getLanguageId()); //added for MOHE-SCF-0213//ML-MMOH-CRF-1994---COMMENTED

			if(!(order_type.equals("All")) && !(order_type.equals("")) && (!"C".equals(order_type)) ){
    			pstmt.setString(16,order_type);
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
					String arr[] = new String[13];	//changed to 13 for 57362 ML-MMOH-CRF-0347
					arr[0]=resultSet.getString("ORIG_ORDER_ID");
					arr[1]=resultSet.getString("order_date_time");
					arr[2]=resultSet.getString("START_DATE");
					arr[3]=resultSet.getString("PATIENT_ID");
					arr[4]=resultSet.getString("PATIENT_NAME");
					arr[5]=resultSet.getString("ENCOUNTER_ID")==null?"":resultSet.getString("ENCOUNTER_ID");//added for 52625--ML-MMOH-CRF-1994
					arr[6]=resultSet.getString("PRACTITIONER_NAME");
					arr[7]=resultSet.getString("ORDER_STATUS");
					arr[8]=resultSet.getString("PATIENT_CLASS");
					arr[9]=resultSet.getString("LOCN_CODE");
					arr[10]=resultSet.getString("DISP_LOCN_DESC")==null?"":resultSet.getString("DISP_LOCN_DESC");//ML-MMOH-CRF-1994
					//System.out.println("DISP_LOCN_DESC-----"+arr[10]);
					arr[11]=resultSet.getString("IV_PREP_YN")==null?"":resultSet.getString("IV_PREP_YN");
					arr[12]=resultSet.getString("ORDER_SET_ID")==null?"":resultSet.getString("ORDER_SET_ID"); //added for 57362 ML-MMOH-CRF-0347
					records.add(arr);
				}

			}
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(orig_order_id)+"','"+(order_date_from)+"','"+order_date_to+"','"+(encounter_id)+"','"+(pres_practitioner_id)+"','"+(order_type)+"','"+ord_by+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(orig_order_id)+"','"+(order_date_from)+"','"+order_date_to+"','"+(encounter_id)+"','"+(pres_practitioner_id)+"','"+(order_type)+"','"+ord_by+"')\">Next</a>" ;
				
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

	public ArrayList getAllIVPresBasedOnQuery(String patient_id,String orig_order_id,String order_date_from,String order_date_to,String encounter_id,String pres_practitioner_id,String locn_type,String locn_code,String iv_type,String facility_id,String from,String to)throws Exception{
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;


		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		String append_str			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;

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
		
		try {
			connection = getConnection() ; 
			if(iv_type.equals("1")) {
				append_str		= "AND C.IV_PREP_YN IN ('1') ORDER BY START_DATE DESC";
			} else if(iv_type.equals("2")) {
				append_str		= "AND C.IV_PREP_YN IN ('2') ORDER BY START_DATE DESC";
			}else if(iv_type.equals("3")) {
				append_str		= "AND C.IV_PREP_YN IN ('3') ORDER BY START_DATE DESC";
			}else if(iv_type.equals("4")) {
				append_str		= "AND C.IV_PREP_YN IN ('4') ORDER BY START_DATE DESC";
			}else if(iv_type.equals("5")) {
				append_str		= "AND C.IV_PREP_YN IN ('5') ORDER BY START_DATE DESC";
			}else if(iv_type.equals("6")) {
				append_str		= "AND C.IV_PREP_YN IN ('6') ORDER BY START_DATE DESC";
			}else if(iv_type.equals("7")) {
				append_str		= "AND C.IV_PREP_YN IN ('7') ORDER BY START_DATE DESC";
			}else if(iv_type.equals("8")) {
				append_str		= "AND C.IV_PREP_YN IN ('8') ORDER BY START_DATE DESC";
			}else if(iv_type.equals("0")){
				append_str		= "AND C.IV_PREP_YN IN ('0') ORDER BY START_DATE DESC";
			}else if(iv_type.equals("9")){
				append_str		= "AND C.IV_PREP_YN IN ('9') ORDER BY START_DATE DESC";
			}
             
			
			if(iv_type.equals("7") || iv_type.equals("8")){
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRINT_TPN_PRESCRIPTIONS_SELECT") + append_str);
			}else if(iv_type.equals("6"))
			{
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRINT_COMPOUND_PRESCRIPTIONS_SELECT") + append_str);
			}
			else{
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRINT_IV_PRESCRIPTIONS_SELECT") + append_str);
			}
			pstmt.setString(1,orig_order_id.trim());
			pstmt.setString(2,order_date_from.trim());
			pstmt.setString(3,order_date_to.trim());
			pstmt.setString(4,patient_id.trim());
			pstmt.setString(5,encounter_id.trim());
			pstmt.setString(6,pres_practitioner_id.trim());
			pstmt.setString(7,locn_type.trim());
			pstmt.setString(8,locn_code.trim());
			pstmt.setString(9,facility_id.trim());
			pstmt.setString(10,getLanguageId());
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
				String arr[] = new String[11];	
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
				arr[10]=resultSet.getString("disp_locn_desc");
				records.add(arr);
				}
			}
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(orig_order_id)+"','"+(order_date_from)+"','"+order_date_to+"','"+(encounter_id)+"','"+(pres_practitioner_id)+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(orig_order_id)+"','"+(order_date_from)+"','"+order_date_to+"','"+(encounter_id)+"','"+(pres_practitioner_id)+"')\">Next</a>" ;
				
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

// Dispensing Sheet query result
	// This method is used to retrieve the data depending on the query criteria
	public ArrayList getDispenseReport(String patient_id,String disp_no,String facility_id,String from,String to)throws Exception{
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;

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
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRINT_DISP_SHEET_SELECT1") );
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_no.trim());
			pstmt.setString(3,patient_id.trim());
			pstmt.setString(4,getLanguageId().trim());
			pstmt.setString(5,getLanguageId().trim());
			pstmt.setString(6,getLanguageId().trim());
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
					records.add(checkForNull(resultSet.getString("DISP_NO")));
					records.add(checkForNull(resultSet.getString("PATIENT_ID")));
					records.add(checkForNull(resultSet.getString("DISP_DATE_TIME")));
					records.add(checkForNull(resultSet.getString("SHORT_DESC")));
					records.add(checkForNull(resultSet.getString("SOURCE")));
				}
			}
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(disp_no)+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(disp_no)+"')\">Next</a>" ;
				
			records.set(0,prevnextlink);
		}
		catch ( Exception e ){
			System.err.println( "Error loading dispensing result" ) ;
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

	public ArrayList getDispenseLabelReport(String patient_id,String disp_no,String facility_id,String from,String to)throws Exception{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String customer_id="";
		
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;

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
		try {
			connection = getConnection() ;
           pstmt = connection.prepareStatement( "SELECT CUSTOMER_ID FROM SM_SITE_PARAM WHERE SITE_ID = 'DS'" );
		   resultSet = pstmt.executeQuery() ;
		   if(resultSet.next()){
				customer_id = resultSet.getString("CUSTOMER_ID")==null?"":resultSet.getString("CUSTOMER_ID");
			}
			closeResultSet( resultSet ) ;//common-icn-0029
			closeStatement( pstmt ) ; //common-icn-0029
			
            if(customer_id.equals("MOD")){
				pstmt = connection.prepareStatement("SELECT A.DISP_NO DISP_NO,A.PATIENT_ID,to_char(A.ADDED_DATE,'dd/mm/yyyy hh24:mi') DISP_DATE_TIME, A.DISP_LOCN_CODE,B.SHORT_DESC,A.PATIENT_CLASS,DECODE( A.PATIENT_CLASS,  'IP',  C.LONG_DESC,  'EA',  D.LONG_DESC,  D.LONG_DESC ) SOURCE FROM PH_DISP_HDR A,PH_DISP_LOCN_LANG_VW B,IP_NURSING_UNIT_LANG_VW C, OP_CLINIC_LANG_VW D,OR_ORDER E WHERE B.FACILITY_ID = A.FACILITY_ID AND A.FACILITY_ID = C.FACILITY_ID(+)  AND A.FACILITY_ID = D.FACILITY_ID(+)  AND B.DISP_LOCN_CODE = A.DISP_LOCN_CODE AND A.ORDER_ID = E.ORDER_ID AND E.ORDER_STATUS = DECODE(REF_FACILITY_ID,NULL,'DP',decode(e.patient_class,'XT','DP','DF','DD','DE')) AND A.LOCN_CODE = C.NURSING_UNIT_CODE(+) AND A.LOCN_CODE = D.CLINIC_CODE(+) AND A.FACILITY_ID=? AND A.DISP_NO = NVL(?,A.DISP_NO) AND A.PATIENT_ID = NVL(?,A.PATIENT_ID) AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID(+) = ? AND D.LANGUAGE_ID(+) = ?  union all SELECT   to_char(a.disp_tmp_no )DISP_NO, a.patient_id, TO_CHAR (a.ADDED_DATE, 'dd/mm/yyyy hh24:mi') disp_date_time, a.disp_locn_code, b.short_desc, a.patient_class, DECODE (a.patient_class, 'IP', c.long_desc,'EA', d.long_desc,  d.long_desc )SOURCE FROM ph_disp_hdr_tmp a,  ph_disp_locn_lang_vw b,    ip_nursing_unit_lang_vw c,   op_clinic_lang_vw d, or_order e  WHERE b.facility_id = a.facility_id      AND a.facility_id = c.facility_id(+)  AND a.facility_id =  d.facility_id(+) AND b.disp_locn_code = a.disp_locn_code      AND a.order_id = e.order_id    AND a.locn_code = c.nursing_unit_code(+) AND a.locn_code = d.clinic_code(+)AND a.facility_id = ? AND a.disp_tmp_no = NVL (?,A.disp_tmp_no)  AND a.patient_id = NVL (?, a.patient_id)  AND b.language_id = ?  AND c.language_id(+) = ?  AND d.language_id(+) = ? and (select count(*) from ph_disp_dtl_tmp where ORDER_ID =a.order_id and BMS_QTY>0)>0 ORDER BY DISP_DATE_TIME DESC");//DISP_DATE_TIME changed to ADDED_DATE for Bru-HIMS-CRF-415 [IN:045556]//,'DD','DE' ADSDED FOR MMS-KH-CRF-0014
			}
			else{//op added for jd-crf-0221
				//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRINT_DISP_SHEET_SELECT1") );			
				pstmt = connection.prepareStatement( "SELECT A.DISP_NO,A.PATIENT_ID,to_char(A.added_date,'dd/mm/yyyy hh24:mi') DISP_DATE_TIME, A.DISP_LOCN_CODE,B.SHORT_DESC,A.PATIENT_CLASS,/*DECODE( A.PATIENT_CLASS,  'IP',  C.LONG_DESC,  'EA',  D.LONG_DESC,  D.LONG_DESC ) SOURCE */ ph_order_source (E.source_code, E.patient_class, E.ordering_facility_id, E.source_type, b.language_id ) SOURCE FROM PH_DISP_HDR A,PH_DISP_LOCN_LANG_VW B,IP_NURSING_UNIT_LANG_VW C, OP_CLINIC_LANG_VW D,OR_ORDER E WHERE B.FACILITY_ID = A.FACILITY_ID AND A.FACILITY_ID = C.FACILITY_ID(+)  AND A.FACILITY_ID = D.FACILITY_ID(+)  AND B.DISP_LOCN_CODE = A.DISP_LOCN_CODE AND A.ORDER_ID = E.ORDER_ID AND E.ORDER_STATUS = DECODE(REF_FACILITY_ID,NULL,'DP',decode(e.patient_class,'XT','DP','DF','DD','DE','OP')) AND A.LOCN_CODE = C.NURSING_UNIT_CODE(+) AND A.LOCN_CODE = D.CLINIC_CODE(+) AND A.FACILITY_ID=? AND A.DISP_NO = NVL(?,A.DISP_NO) AND A.PATIENT_ID = NVL(?,A.PATIENT_ID) AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID(+) = ? AND D.LANGUAGE_ID(+) = ?  AND a.disp_no||a.facility_id in (select disp_no||facility_id from ph_disp_dtl where facility_id=a.facility_id and disp_no = a.disp_no ) ORDER BY A.DISP_DATE_TIME DESC" );		//,'DD','DE' ADSDED FOR MMS-KH-CRF-0014	and ph_order_source added for SKR-SCF-1402
			}
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_no.trim());
			pstmt.setString(3,patient_id.trim());
			pstmt.setString(4,getLanguageId().trim());
			pstmt.setString(5,getLanguageId().trim());
			pstmt.setString(6,getLanguageId().trim());
			if(customer_id.equals("MOD")){
				pstmt.setString(7,facility_id.trim());
				pstmt.setString(8,disp_no.trim());
				pstmt.setString(9,patient_id.trim());
				pstmt.setString(10,getLanguageId().trim());
				pstmt.setString(11,getLanguageId().trim());
				pstmt.setString(12,getLanguageId().trim());
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
					records.add(checkForNull(resultSet.getString("DISP_NO")));
					records.add(checkForNull(resultSet.getString("PATIENT_ID")));
					records.add(checkForNull(resultSet.getString("DISP_DATE_TIME")));
					records.add(checkForNull(resultSet.getString("SHORT_DESC")));
					records.add(checkForNull(resultSet.getString("SOURCE")));
				}
			}
			if( start != 1 )
				prevnextlink += "<td class='WHITE' align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(disp_no)+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
			prevnextlink += "<td class='WHITE' align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(disp_no)+"')\">Next</a>" ;
			
			records.set(0,prevnextlink);
		}
		catch ( Exception e ){
			System.err.println( "Error loading dispensing result" ) ;
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
	/********** getPatientIDLength()  starts**********/
	public String getPatientIDLength(){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pat_txt_length	=	null ;

		try{
			connection			= getConnection() ;
			//pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT1") ) ;
			pstmt				= connection.prepareStatement("SELECT PATIENT_ID_LENGTH FROM MP_PARAM WHERE MODULE_ID='MP' ") ;
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				pat_txt_length	=	checkForNull(resultSet.getString("PATIENT_ID_LENGTH"));
				//System.err.println("pat_txt_length----> in bean----->" +pat_txt_length);
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
				es.printStackTrace();
			}
		}
		return pat_txt_length;	
	} //Ends

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
			//System.err.println("getLanguageId----->" +getLanguageId());
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
	
	public ArrayList getPatientLine(String patient_id,String order_id) throws Exception{
	
		ArrayList result = new ArrayList();
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT4") ) ;
			pstmt.setString(1,patient_id.trim());
			pstmt.setString(2,order_id.trim());
		    resultSet = pstmt.executeQuery() ;
            if ( resultSet != null && resultSet.next() ) {
				result.add(resultSet.getString("ORIG_ORDER_ID"));  
				result.add(resultSet.getString("PATIENT_ID"));  
				result.add(resultSet.getString("PATIENT_NAME"));  
				result.add(resultSet.getString("SEX"));  
				result.add(resultSet.getString("AGE"));  
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
            catch(Exception es) {es.printStackTrace();}
        }
		return result;
	}
	public ArrayList getAllExtPresBasedOnQuery(String patient_id,String orig_order_id,String order_date_from,String order_date_to,String from,String to,String ord_by)throws Exception{
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String orderby="";
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;
		if(ord_by.equals("DESCEND"))
			orderby=" DESC";
		else
			orderby="";
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
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REP_EXT_PRESCRIPTIONS_SELECT")+orderby);
			//pstmt = connection.prepareStatement( "SELECT A.PATIENT_ID,B.PATIENT_NAME,A.ORIG_ORDER_ID ORIG_ORDER_ID,A.ENCOUNTER_ID,A.LOCN_TYPE,A.PRES_PRACTITIONER_ID,TO_CHAR(A.START_DATE,'DD/MM/YYYY') START_DATE,TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') ADDED_DATE,A.ADDED_DATE ORD_DATE,B.NATIONAL_ID_NO,C.ORDER_STATUS,D.PRACTITIONER_NAME,A.PATIENT_CLASS, A.LOCN_CODE ,e.SHORT_DESC FROM PH_PATIENT_DRUG_PROFILE A,MP_PATIENT B,OR_ORDER C,AM_PRACTITIONER_LANG_VW D ,ph_disp_locn_lang_vw e WHERE A.FACILITY_ID=C.ORDERING_FACILITY_ID AND A.PATIENT_ID  = B.PATIENT_ID  AND A.PATIENT_ID    = C.PATIENT_ID  AND A.ORIG_ORDER_ID = C.ORDER_ID  AND A.ORIG_ORDER_ID = NVL(?,A.ORIG_ORDER_ID)  AND A.ADDED_DATE BETWEEN TO_DATE(NVL(?,'01/01/1472 00:00'),'DD/MM/RRRR hh24:mi')  AND  TO_DATE(NVL(?,'31/12/5000 23:59'),'DD/MM/RRRR hh24:mi')  AND C.PATIENT_CLASS = 'XT'  AND  A.PATIENT_ID = NVL(?,A.PATIENT_ID)  AND A.PRES_PRACTITIONER_ID = D.PRACTITIONER_ID AND A.FACILITY_ID=? and c.PERFORMING_DEPTLOC_CODE=e.disp_locn_code and a.FACILITY_ID=e.FACILITY_ID and D.LANGUAGE_ID = E.LANGUAGE_ID AND D.LANGUAGE_ID = ? ORDER BY ORD_DATE"+orderby);
			pstmt.setString(1,getLanguageId());////ML-MMOH-CRF-1994
			pstmt.setString(2,orig_order_id.trim());
			pstmt.setString(3,order_date_from.trim());
			pstmt.setString(4,order_date_to.trim());
			pstmt.setString(5,patient_id.trim());
			pstmt.setString(6,login_facility_id.trim());
			pstmt.setString(7,getLanguageId());
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
				//String arr[] = new String[11]; commented for ml-mmoh-crf-0510	
				String arr[] = new String[13];	
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
				arr[10]=resultSet.getString("SHORT_DESC")==null?"":resultSet.getString("SHORT_DESC");////ML-MMOH-CRF-1994
				//C.REF_SENT_PRACT_ID,A.ADDED_BY_ID Added for ml-mmoh-crf-0510
				arr[11]=(resultSet.getString("REF_SENT_PRACT_ID"));
				arr[12]=(resultSet.getString("ADDED_BY_ID"));
				records.add(arr);
				}
			}
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(orig_order_id)+"','"+(order_date_from)+"','"+order_date_to+"','"+ord_by+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(orig_order_id)+"','"+(order_date_from)+"','"+order_date_to+"','"+ord_by+"')\">Next</a>" ;
				
			records.set(0,prevnextlink);
		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){es.printStackTrace();
			}
		}
		return records;
	}
	public ArrayList getNursingUnit() throws Exception{
	
		ArrayList result = new ArrayList();
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_NUR_UNIT_SELECT") ) ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,getLanguageId());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				result.add(resultSet.getString("NURSING_UNIT_CODE"));
				result.add(resultSet.getString("LONG_DESC"));
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
            catch(Exception es) {es.printStackTrace();}
        }
		return result;
	}
	public ArrayList getPatientDrugOnQuery(String patient_id,String locn_code,String from,String to,String locale,String locn_type)throws Exception{
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;

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
		
		try {
			connection = getConnection() ; 
			if("N".equals(locn_type))
				pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PATIENT_DRUG_CHART_REP_SELECT"));
			else
				pstmt = connection.prepareStatement("SELECT a.patient_id, b.patient_name, a.assign_care_locn_code nursing_unit_code,c.long_desc short_desc,TO_CHAR (a.visit_adm_date_time,'DD/MM/YYYY hh24:mi') admission_date_time,' ' room_num, ' ' bed_num FROM pr_encounter a, mp_patient b, op_clinic_lang_vw c  WHERE a.patient_id = b.patient_id AND a.facility_id = c.facility_id AND a.pat_curr_locn_code = c.clinic_code AND a.patient_id = NVL (?, a.patient_id) AND a.pat_curr_locn_code = NVL (?, a.pat_curr_locn_code) AND a.facility_id = ? AND c.language_id = ? AND a.patient_class in('OP', 'EM')");
			pstmt.setString(1,patient_id.trim());
			pstmt.setString(2,locn_code.trim());  
			pstmt.setString(3,login_facility_id.trim());
			pstmt.setString(4,locale);
			resultSet = pstmt.executeQuery();
			records.add("link");
			while ( resultSet.next() && i <= end+1 ){
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
				if(i <= end ) {
					String arr[] = new String[8];	
					arr[0]=resultSet.getString("PATIENT_ID");
					arr[1]=resultSet.getString("PATIENT_NAME");
					arr[2]=resultSet.getString("NURSING_UNIT_CODE");
					arr[3]=resultSet.getString("SHORT_DESC");
					arr[4]=resultSet.getString("ADMISSION_DATE_TIME");
					arr[5]=resultSet.getString("ROOM_NUM");
					arr[6]=resultSet.getString("BED_NUM");
					records.add(arr);
				}
			}
			if( start != 1 )
				prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(locn_code)+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
				prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(locn_code)+"')\">Next</a>" ;
			records.set(0,prevnextlink);
		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
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
	/********************** getAllFormdd7 func starts ************************/

	public ArrayList getAllFormdd7(String patient_id,String orig_order_id,String order_date_from,String order_date_to,String encounter_id,String pres_practitioner_id,String locn_type,String locn_code,String facility_id,String from,String to,String narcotic_type,String order_by)throws Exception{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;
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
		try {
			connection = getConnection() ;
            StringBuffer sql_str = new StringBuffer();
            //sql_str =sql_str.append(PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT"));
			sql_str =sql_str.append("SELECT A.PATIENT_ID,B.PATIENT_NAME,A.ORIG_ORDER_ID,A.ENCOUNTER_ID,A.LOCN_TYPE,A.PRES_PRACTITIONER_ID,TO_CHAR(A.START_DATE,'DD/MM/YYYY') START_DATE,TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') ADDED_DATE,B.NATIONAL_ID_NO,C.ORDER_STATUS,D.PRACTITIONER_NAME,A.PATIENT_CLASS, A.LOCN_CODE , e.SHORT_DESC disp_locn_desc, C.IV_PREP_YN FROM PH_PATIENT_DRUG_PROFILE A,MP_PATIENT B,OR_ORDER C,AM_PRACTITIONER D,ph_disp_locn e WHERE A.PATIENT_ID = B.PATIENT_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.ORIG_ORDER_ID = C.ORDER_ID AND A.ORIG_ORDER_LINE_NO='1' AND C.ORD_DATE_TIME BETWEEN TO_DATE(NVL(?,'01/01/1472'),'DD/MM/RRRR') AND   TO_DATE(NVL(?,'31/12/5000'),'DD/MM/RRRR') + 0.99999 AND NVL(A.ENCOUNTER_ID,0) = NVL(?,nvl(A.ENCOUNTER_ID,0)) AND A.PRES_PRACTITIONER_ID = NVL(?,A.PRES_PRACTITIONER_ID) AND A.PRES_PRACTITIONER_ID = D.PRACTITIONER_ID  AND A.LOCN_TYPE = NVL(?,A.LOCN_TYPE) AND A.LOCN_CODE = NVL(?,A.LOCN_CODE) AND A.FACILITY_ID=? AND e.FACILITY_ID=A.FACILITY_ID AND e.DISP_LOCN_CODE=c.PERFORMING_DEPTLOC_CODE ");
			if(patient_id.equals("")){
                 sql_str =sql_str.append(" AND A.ORIG_ORDER_ID = ? ");
			}
			else {
				 sql_str =sql_str.append(" AND A.PATIENT_ID = ?  ");
			}
			if(narcotic_type.equals("All")){
				//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT") +" AND C.ORDER_TYPE_CODE IN (SELECT ORDER_TYPE_CODE FROM PH_ORDER_TYPE_FOR_DRUG_CLASS WHERE DRUG_CLASS = 'N') ");
				sql_str =sql_str.append(" AND C.ORDER_TYPE_CODE IN (SELECT ORDER_TYPE_CODE FROM PH_ORDER_TYPE_FOR_DRUG_CLASS WHERE DRUG_CLASS = 'N')");
			}
			else {
				//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT") +" AND C.ORDER_TYPE_CODE IN (SELECT ORDER_TYPE_CODE FROM PH_ORDER_TYPE_FOR_DRUG_CLASS WHERE DRUG_CLASS = 'N' AND ORDER_TYPE_CODE = ?) ");
				sql_str =sql_str.append(" AND C.ORDER_TYPE_CODE IN (SELECT ORDER_TYPE_CODE FROM PH_ORDER_TYPE_FOR_DRUG_CLASS WHERE DRUG_CLASS = 'N' AND ORDER_TYPE_CODE = ?)");
			}
			if(order_by.equals("D")){
				sql_str =sql_str.append(" ORDER BY C.ORD_DATE_TIME DESC");
			}
            pstmt = connection.prepareStatement(sql_str.toString());
			//pstmt.setString(1,orig_order_id.trim());
			pstmt.setString(1,order_date_from.trim());
			pstmt.setString(2,order_date_to.trim());
			//pstmt.setString(4,patient_id.trim());
			pstmt.setString(3,encounter_id.trim());
			pstmt.setString(4,pres_practitioner_id.trim());
			pstmt.setString(5,locn_type.trim());
			pstmt.setString(6,locn_code.trim());
			pstmt.setString(7,facility_id.trim());
          
			if(patient_id.equals(""))
			    pstmt.setString(8,orig_order_id.trim());
			else
				pstmt.setString(8,patient_id.trim());
                
			if(!(narcotic_type.equals("All"))){
    			pstmt.setString(9,narcotic_type);
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
				prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(orig_order_id)+"','"+(order_date_from)+"','"+order_date_to+"','"+(encounter_id)+"','"+(pres_practitioner_id)+"','"+(narcotic_type)+"','"+(order_by)+"')\">Previous&nbsp;&nbsp;</a>" ;
			if( count > 14 )
				prevnextlink +=  "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(orig_order_id)+"','"+(order_date_from)+"','"+order_date_to+"','"+(encounter_id)+"','"+(pres_practitioner_id)+"','"+(narcotic_type)+"','"+(order_by)+"')\">Next</a>" ;
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
	public void getDefltValues(){	//added for 57362 ML-MMOH-CRF-0347
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String crit_field_id = "";
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "SELECT CRIT_FIELD_ID, CRIT_FIELD_VAL  FROM PH_DISP_MEDN_DFLT WHERE FACILITY_ID = DECODE (?, FACILITY_ID, FACILITY_ID, '*A')   AND CRIT_FIELD_ID IN( 'CDR_ORDERS_YN') ") ;
			pstmt.setString(1,login_facility_id.trim());
            resultSet	= pstmt.executeQuery() ;
			if(resultSet!=null){
				while(resultSet.next()){
					crit_field_id = checkForNull(resultSet.getString("CRIT_FIELD_ID"));
					if(crit_field_id.equals("CDR_ORDERS_YN"))
						setCDROrdersYN(checkForNull(resultSet.getString("CRIT_FIELD_VAL"),"N"));
				}
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
			catch ( Exception es ) {
				es.printStackTrace() ;
			}
		}
	}

	public ArrayList getFacilitys() {
		ArrayList facilities = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ORDER_ROUTING_SELECT1" )) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					facilities.add( resultSet.getString( "FACILITY_ID" ) ) ;
					facilities.add( resultSet.getString( "FACILITY_NAME" ) );
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
			catch(Exception es) {es.printStackTrace(); }
		}

		return facilities;
	}

	public ArrayList getRefillOrders(String patient_id,String order_id,String order_date_from,String order_date_to,String facility_id,String locn_code,String from,String to,String locale )throws Exception{
		
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;

		
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
		//String sql=""; //commented for common-icn-0048

		
		try {
			connection = getConnection() ;
			
			pstmt		= connection.prepareStatement("SELECT B.ORDER_ID, B.ORDER_LINE_NUM,D.DRUG_DESC, TO_CHAR(B.START_DATE_TIME,'DD/MM/YYYY HH24:MI') START_DATE_TIME,TO_CHAR(B.END_DATE_TIME,'DD/MM/YYYY HH24:MI') END_DATE_TIME, C.PRACTITIONER_NAME,E.SHORT_DESC DISP_LOCN,b.ORDER_CATALOG_CODE FROM OR_ORDER A, OR_ORDER_LINE B, AM_PRACTITIONER_LANG_VW C,PH_DRUG_LANG_VW D,PH_DISP_LOCN E WHERE A.PATIENT_ID = ? AND A.ORDER_ID = NVL (?, A.ORDER_ID) AND A.ORDER_ID = B.ORDER_ID AND A.SOURCE_CODE = NVL (?, A.SOURCE_CODE) AND A.PERFORMING_FACILITY_ID = NVL (?, A.PERFORMING_FACILITY_ID) AND A.ORD_DATE_TIME BETWEEN TO_DATE (NVL (?, '01/01/1472'), 'DD/MM/RRRR') AND   TO_DATE (NVL (?, '31/12/5000'),'DD/MM/RRRR') + 0.99999 AND A.ORDER_CATEGORY ='PH' AND A.ORDER_CATEGORY =B.ORDER_CATEGORY AND B.ORDER_CATALOG_CODE =D.DRUG_CODE AND A.PERFORMING_DEPTLOC_CODE = E.DISP_LOCN_CODE AND A.CHILD_ORDER_YN = 'Y' AND A.PARENT_ORDER_ID IS NOT NULL AND B.ORDER_LINE_STATUS <> 'DF' AND A.ORD_PRACT_ID = C.PRACTITIONER_ID AND C.LANGUAGE_ID =? AND D.LANGUAGE_ID =? ORDER BY ORDER_ID,ORDER_LINE_NUM"); //LONG_DESC changed to SHORT_DESC for MOHE-CRF-0069	 and B.ORDER_LINE_STATUS <> 'DF' added for IN19600		
  
			pstmt.setString(1,patient_id.trim());
			pstmt.setString(2,order_id.trim());
			pstmt.setString(3,locn_code.trim());
			pstmt.setString(4,facility_id.trim());
			pstmt.setString(5,order_date_from.trim());
			pstmt.setString(6,order_date_to.trim());
			pstmt.setString(7,locale.trim());
			pstmt.setString(8,locale.trim());
			
            
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
					String arr[] = new String[8];	
					arr[0]=resultSet.getString("ORDER_ID");
					arr[1]=resultSet.getString("ORDER_LINE_NUM");
					arr[2]=resultSet.getString("DRUG_DESC");
					arr[3]=resultSet.getString("START_DATE_TIME");
					arr[4]=resultSet.getString("END_DATE_TIME");
					arr[5]=resultSet.getString("PRACTITIONER_NAME");
					arr[6]=resultSet.getString("DISP_LOCN");
					arr[7]=resultSet.getString("ORDER_CATALOG_CODE");
					records.add(arr);
				}

			}
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(order_id)+"','"+(order_date_from)+"','"+order_date_to+"','"+(facility_id)+"','"+(locn_code)+"','"+(locale)+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(order_id)+"','"+(order_date_from)+"','"+order_date_to+"','"+(facility_id)+"','"+(locn_code)+"','"+(locale)+"')\">Next</a>" ;
				
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

}
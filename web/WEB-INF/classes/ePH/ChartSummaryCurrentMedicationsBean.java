/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //This file is saved on 10/01/2006.
 /*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

13/7/2023      TFS-46322    hariharan                    Ramesh goil            COMMON-ICN-0310
--------------------------------------------------------------------------------------------------------------------
*/
package ePH;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;

public class ChartSummaryCurrentMedicationsBean extends PhAdapter implements Serializable {

	String pre_allocation_yn="";//Added for NMC-JD-CRF-0126
	 public ChartSummaryCurrentMedicationsBean(){
        try{
            doCommon();
        }
        catch(Exception e){
		   e.printStackTrace();
		}
    }
	
	private void doCommon() throws Exception {
	}

	//Validate Method
	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

   public void setPreallocYN(String pre_alloc_yn){ 
		this.pre_allocation_yn = pre_alloc_yn;
	}
	public String getPreallocYN(){
		return this.pre_allocation_yn;
	}
	public HashMap getCurrentMedicationDetails(String patient_id, String ord_id, String allow_renew_from_chart_summ_yn, String single_cont_renew_hrs_behind, String single_cont_renew_hrs_ahead,String called_from,String ReqDb,String enc_id1){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        PreparedStatement pstmt1    = null ;
		PreparedStatement pstmt2    = null ;//NMC-JD-CRF-0126
        ResultSet resultSet         = null ;
        ResultSet resultSet1        = null ;
		ResultSet resultSet2        = null ;//NMC-JD-CRF-0126
		String order_id				= "";
		String drug_name			= "";
		String drug_duration		= "";
		String start_date			= "";
		String end_date				= "";
		String IV_Prep_yn			= "";
		int count					= 1;
		String renew_yn				= "" ;//Added for Bru-HIMS-CRF-400
		String or_order_line ="";//Added for Bru-HIMS-CRF-400
		HashMap Order_Group=new HashMap();
		StringBuilder sbSql = new StringBuilder();
		String sbSql1  ="";//Added for MMS-DM-CRF-115.4
		if(ReqDb.equals("null"))
			ReqDb="";

		try{
			connection				= getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_CHART_SUMM_CURR_MEDNS_SELECT1") );
			pstmt2 = connection.prepareStatement("SELECT GENERIC_NAME,STRENGTH_VALUE,STRENGTH_UOM_DESC,STOCK_UOM_DESC,NVL(DRUG_SEARCH_BY,'G') DRUG_SEARCH_BY,ph_get_desc.ph_form (form_code, lang1, '1')form_desc FROM PH_DRUG_VW_LANG_VW WHERE DRUG_CODE=? AND LANG1 = ?");
			//boolean stock_uom_app = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","GROUP_BY_STOCK_UOM");//NMC-JD-CRF-0126 COMMON-ICN-0310
			if(resultSet != null) resultSet = null;
			resultSet = pstmt.executeQuery();

			if(resultSet.next()){
				closeResultSet(resultSet1);
				if(called_from.equals("CDR")){//Added for MMS-DM-CRF-115.4
					 if(ord_id.equals("")){
						 sbSql.append("SELECT b.order_id, a.orig_order_line_no ORDER_LINE_NUM, a.drug_code drug_code,DECODE (drug_yn,'Y', (SELECT form_desc FROM ph_form_lang_vw ##REQDB## WHERE form_code = (select form_code from ph_drug_lang_vw ##REQDB## where drug_code = a.drug_code and drug_yn = 'Y' and language_id = ?) AND language_id = ?),'')||' '|| (select drug_desc from ph_drug_lang_vw ##REQDB## where drug_code = a.drug_code and drug_yn = 'Y' and language_id = ?)|| ' ' || DECODE ((select sliding_scale_yn from or_order_line_ph ##REQDB## where order_id = a.orig_order_id and order_line_num= a.orig_order_line_no),'Y', 'Sliding Scale',RTRIM(RTRIM (TO_CHAR (a.dosage,'9999999999999990.999999999999'),'0'),'.')|| ' '|| ph_get_uom_display ##REQDB##(?, a.dosage_uom_code, ?))|| ' '|| DECODE (drug_yn,'Y', DECODE (a.split_yn, 'Y', '(Divided)', (select freq_desc from am_frequency_lang_vw ##REQDB## where freq_code = a.freq_code and language_id = ?)),'')|| DECODE (drug_yn, 'Y', ' * ', '')|| DECODE (drug_yn, 'Y', a.DURATION, '')|| ' '|| (select durn_desc drug_name from am_duration_type_lang_vw ##REQDB## where durn_type = a.durn_type and language_id = ?) drug_name ,DECODE (drug_yn,'Y', TO_CHAR (a.start_date, 'dd/mm/yyyy'),'') start_date,DECODE (drug_yn,'Y', TO_CHAR (a.end_date, 'dd/mm/yyyy'),'') end_date,b.iv_prep_yn,(CASE WHEN (? = 'Y' AND a.end_date BETWEEN (SYSDATE - ? / 24) AND (SYSDATE + ? / 24)) THEN 'Y' ELSE 'N' END ) renew_yn FROM ph_patient_drug_profile ##REQDB##  a, or_order ##REQDB## b, ph_drug ##REQDB## d WHERE a.patient_id = ? AND a.orig_order_id = NVL (?, a.orig_order_id) AND b.order_id = a.orig_order_id and A.DRUG_CODE    = d.drug_code AND " );
						 if(!ReqDb.equals("")) // Added for MMS-DM-CRF-115.4
                              sbSql.append( " a.encounter_id = ? and a.encounter_id=b.encounter_id and ");
						if(allow_renew_from_chart_summ_yn.equals("Y"))
							sbSql.append( " ( TRUNC (NVL (a.end_date,SYSDATE)) >= TRUNC (SYSDATE) OR (NVL (a.end_date,SYSDATE)) >= (SYSDATE - (?/24)) ) ");
						else
							sbSql.append( " TRUNC (NVL (a.end_date,SYSDATE)) >= TRUNC (SYSDATE) ");
						sbSql.append(" AND a.discont_date_time IS NULL AND a.on_hold_date_time IS NULL AND cancel_yn = 'N' AND cancel_date_time IS NULL and drug_yn='Y' ORDER BY ord_date_time, orig_order_id, orig_order_line_no");
					 }else{
						 sbSql.append("SELECT b.order_id, a.orig_order_line_no ORDER_LINE_NUM, a.drug_code drug_code,DECODE (drug_yn,'Y',(SELECT form_desc FROM ph_form_lang_vw ##REQDB## WHERE form_code = (select form_code from ph_drug_lang_vw ##REQDB## where drug_code = a.drug_code and drug_yn = 'Y' and language_id = ?) AND language_id = ?),'')|| ' '|| (select drug_desc from ph_drug_lang_vw ##REQDB## where drug_code = a.drug_code and drug_yn = 'Y' and language_id = ?)|| ' '|| DECODE ((select sliding_scale_yn from or_order_line_ph ##REQDB## where order_id = a.orig_order_id and order_line_num= a.orig_order_line_no),'Y', 'Sliding Scale',RTRIM(RTRIM (TO_CHAR (a.dosage,'9999999999999990.999999999999'),'0'),'.')|| ' '|| ph_get_uom_display ##REQDB## (?, a.dosage_uom_code, ?))|| ' '|| DECODE (drug_yn,'Y', DECODE (a.split_yn, 'Y', '(Divided)', (select freq_desc from am_frequency_lang_vw ##REQDB## where freq_code = a.freq_code and language_id = ?)),'')|| DECODE (drug_yn, 'Y', ' * ', '')|| DECODE (drug_yn, 'Y', a.DURATION, '')|| ' '|| DECODE (drug_yn, 'Y', (select durn_desc drug_name from am_duration_type_lang_vw ##REQDB## where durn_type = a.durn_type and language_id = ?), '') drug_name,DECODE (drug_yn,'Y', TO_CHAR (a.start_date, 'dd/mm/yyyy'),'') start_date,DECODE (drug_yn,'Y', TO_CHAR (a.end_date, 'dd/mm/yyyy'),'') end_date,b.iv_prep_yn,(CASE WHEN (? = 'Y' AND a.end_date BETWEEN (SYSDATE - ? / 24) AND (SYSDATE + ? / 24)) THEN 'Y' ELSE 'N' END ) renew_yn FROM ph_patient_drug_profile ##REQDB## a,or_order ##REQDB## b, ph_drug ##REQDB## d WHERE a.patient_id = ? AND a.orig_order_id = NVL (?, a.orig_order_id) AND b.order_id = a.orig_order_id and A.DRUG_CODE    = d.drug_code AND ");
						 if(!ReqDb.equals(""))// Added for MMS-DM-CRF-115.4
                              sbSql.append( " a.encounter_id = ? and a.encounter_id=b.encounter_id and ");
						if(allow_renew_from_chart_summ_yn.equals("Y"))
							sbSql.append( " ( TRUNC (NVL (a.end_date,SYSDATE)) >= TRUNC (SYSDATE) OR (NVL (a.end_date,SYSDATE)) >= (SYSDATE - (?/24)) ) ");
						else
							sbSql.append( " TRUNC (NVL (a.end_date,SYSDATE)) >= TRUNC (SYSDATE) ");
						sbSql.append(" AND a.discont_date_time IS NULL AND a.on_hold_date_time IS NULL AND cancel_yn = 'N' AND cancel_date_time  IS NULL and drug_yn='Y' ORDER BY ord_date_time, orig_order_id, orig_order_line_no");
					 }
				}else{//Adding end for MMS-DM-CRF-115.4
				if(ord_id.equals("")){
				    //pstmt1 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_CHART_SUMM_CURR_MEDNS_SELECT2") );
					//pstmt1 = connection.prepareStatement("SELECT   b.order_id,decode(DRUG_YN, 'Y',e.form_code,'') || ' ' || e.drug_desc || ' ' || a.dosage || ' ' || ph_get_uom_display ('"+login_facility_id+"', a.dosage_uom_code) || ' ' || decode(DRUG_YN, 'Y',d.freq_desc,'') || decode(DRUG_YN, 'Y',' * ','') || decode(DRUG_YN, 'Y', a.DURATION,'') || ' ' || c.durn_desc drug_name,decode(DRUG_YN, 'Y', TO_CHAR (a.start_date, 'dd/mm/yy'),'')|| decode(DRUG_YN, 'Y', '-','')|| decode(DRUG_YN, 'Y', TO_CHAR (a.end_date, 'dd/mm/yy'),'') drug_duration,b.iv_prep_yn FROM ph_patient_drug_profile a,or_order b,am_duration_type c,am_frequency d,ph_drug_lang_vw e,ph_generic_name f WHERE a.patient_id = ? AND  e.language_id=? AND a.orig_order_id = NVL (?, a.orig_order_id) AND b.order_id = a.orig_order_id AND TRUNC (NVL (a.end_date,SYSDATE)) >= TRUNC (SYSDATE) AND a.discont_date_time IS NULL AND a.on_hold_date_time IS NULL AND d.freq_code(+) = a.freq_code AND e.drug_code = a.drug_code AND f.generic_id = a.generic_id AND c.durn_type(+) =a.durn_type AND cancel_yn = 'N' AND cancel_date_time IS NULL and e.drug_yn='Y' ORDER BY ord_date_time, orig_order_id, orig_order_line_no"); //Modified query on 15-dec-09
					//Queries modified -- uom,freq_desc and durn desc taken from lang_vw for IN25058 --27/12/2010-- priya
					sbSql.append("SELECT b.order_id, a.orig_order_line_no ORDER_LINE_NUM, a.drug_code drug_code,DECODE (drug_yn,'Y', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = (select form_code from ph_drug_lang_vw where drug_code = a.drug_code and drug_yn = 'Y' and language_id = ?) AND language_id = ?),'')||' '|| (select drug_desc from ph_drug_lang_vw where drug_code = a.drug_code and drug_yn = 'Y' and language_id = ?)|| ' ' || DECODE ((select sliding_scale_yn from or_order_line_ph where order_id = a.orig_order_id and order_line_num= a.orig_order_line_no),'Y', 'Sliding Scale',RTRIM(RTRIM (TO_CHAR (a.dosage,'9999999999999990.999999999999'),'0'),'.')|| ' '|| ph_get_uom_display (?, a.dosage_uom_code, ?))|| ' '|| DECODE (drug_yn,'Y', DECODE (a.split_yn, 'Y', '(Divided)', (select freq_desc from am_frequency_lang_vw where freq_code = a.freq_code and language_id = ?)),'')|| DECODE (drug_yn, 'Y', ' * ', '')|| DECODE (drug_yn, 'Y', a.DURATION, '')|| ' '|| (select durn_desc drug_name from am_duration_type_lang_vw where durn_type = a.durn_type and language_id = ?) drug_name ,DECODE (drug_yn,'Y', TO_CHAR (a.start_date, 'dd/mm/yyyy'),'') start_date,DECODE (drug_yn,'Y', TO_CHAR (a.end_date, 'dd/mm/yyyy'),'') end_date,b.iv_prep_yn,(CASE WHEN (? = 'Y' AND a.end_date BETWEEN (SYSDATE - ? / 24) AND (SYSDATE + ? / 24)) THEN 'Y' ELSE 'N' END ) renew_yn FROM ph_patient_drug_profile a, or_order b, ph_drug d WHERE a.patient_id = ? AND a.orig_order_id = NVL (?, a.orig_order_id) AND b.order_id = a.orig_order_id and A.DRUG_CODE    = d.drug_code AND " );
					if(allow_renew_from_chart_summ_yn.equals("Y"))
						sbSql.append( " ( TRUNC (NVL (a.end_date,SYSDATE)) >= TRUNC (SYSDATE) OR (NVL (a.end_date,SYSDATE)) >= (SYSDATE - (?/24)) ) ");
					else
						sbSql.append( " TRUNC (NVL (a.end_date,SYSDATE)) >= TRUNC (SYSDATE) ");
					sbSql.append(" AND a.discont_date_time IS NULL AND a.on_hold_date_time IS NULL AND cancel_yn = 'N' AND cancel_date_time IS NULL and drug_yn='Y' ORDER BY ord_date_time, orig_order_id, orig_order_line_no"); //Modified query on 15-dec-09 -- e.form_code replaced with ( select form_desc from PH_FORM_LANG_VW where form_code=e.form_code and language_id=?) form ML-BRU-SCF-0417 (issue 3)
				}
				else{
				    //pstmt1 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_CHART_SUMM_CURR_MEDNS_SELECT2A") );
					//pstmt1 = connection.prepareStatement("SELECT b.order_id,e.form_code||' '||e.DRUG_DESC||' '||a.dosage ||' '||PH_GET_UOM_DISPLAY('"+login_facility_id+"',a.dosage_uom_code)||' '||d.FREQ_DESC||' * '||a.DURATION  ||' '||c.DURN_DESC drug_name,to_char(a.start_date,'dd/mm/yy')||'-'||to_char(a.end_date,'dd/mm/yy') drug_duration, b.iv_prep_yn FROM ph_patient_drug_profile a,or_order b,am_duration_type c,am_frequency d, ph_drug e ,ph_generic_name f WHERE a.patient_id = ? AND A.ORIG_ORDER_ID = NVL(?,A.ORIG_ORDER_ID) AND B.ORDER_ID = A.ORIG_ORDER_ID  AND a.discont_date_time IS NULL AND a.on_hold_date_time IS NULL AND d.freq_code(+)=a.FREQ_CODE AND e.DRUG_CODE=a.DRUG_CODE  and f.GENERIC_ID=a.GENERIC_ID AND c.durn_type(+)=d.INTERVAL_DURN_TYPE and cancel_yn='N' and cancel_date_time is null ORDER BY ord_date_time,orig_order_id,orig_order_line_no");
					sbSql.append("SELECT b.order_id, a.orig_order_line_no ORDER_LINE_NUM, a.drug_code drug_code,DECODE (drug_yn,'Y',(SELECT form_desc FROM ph_form_lang_vw WHERE form_code = (select form_code from ph_drug_lang_vw where drug_code = a.drug_code and drug_yn = 'Y' and language_id = ?) AND language_id = ?),'')|| ' '|| (select drug_desc from ph_drug_lang_vw where drug_code = a.drug_code and drug_yn = 'Y' and language_id = ?)|| ' '|| DECODE ((select sliding_scale_yn from or_order_line_ph where order_id = a.orig_order_id and order_line_num= a.orig_order_line_no),'Y', 'Sliding Scale',RTRIM(RTRIM (TO_CHAR (a.dosage,'9999999999999990.999999999999'),'0'),'.')|| ' '|| ph_get_uom_display (?, a.dosage_uom_code, ?))|| ' '|| DECODE (drug_yn,'Y', DECODE (a.split_yn, 'Y', '(Divided)', (select freq_desc from am_frequency_lang_vw where freq_code = a.freq_code and language_id = ?)),'')|| DECODE (drug_yn, 'Y', ' * ', '')|| DECODE (drug_yn, 'Y', a.DURATION, '')|| ' '|| DECODE (drug_yn, 'Y', (select durn_desc drug_name from am_duration_type_lang_vw where durn_type = a.durn_type and language_id = ?), '') drug_name,DECODE (drug_yn,'Y', TO_CHAR (a.start_date, 'dd/mm/yyyy'),'') start_date,DECODE (drug_yn,'Y', TO_CHAR (a.end_date, 'dd/mm/yyyy'),'') end_date,b.iv_prep_yn,(CASE WHEN (? = 'Y' AND a.end_date BETWEEN (SYSDATE - ? / 24) AND (SYSDATE + ? / 24)) THEN 'Y' ELSE 'N' END ) renew_yn FROM ph_patient_drug_profile a,or_order b, ph_drug d WHERE a.patient_id = ? AND a.orig_order_id = NVL (?, a.orig_order_id) AND b.order_id = a.orig_order_id and A.DRUG_CODE    = d.drug_code AND ");
					if(allow_renew_from_chart_summ_yn.equals("Y"))
						sbSql.append( " ( TRUNC (NVL (a.end_date,SYSDATE)) >= TRUNC (SYSDATE) OR (NVL (a.end_date,SYSDATE)) >= (SYSDATE - (?/24)) ) ");
					else
						sbSql.append( " TRUNC (NVL (a.end_date,SYSDATE)) >= TRUNC (SYSDATE) ");
					sbSql.append(" AND a.discont_date_time IS NULL AND a.on_hold_date_time IS NULL AND cancel_yn = 'N' AND cancel_date_time  IS NULL and drug_yn='Y' ORDER BY ord_date_time, orig_order_id, orig_order_line_no"); //Modified query on 15-dec-09   -- e.form_code replaced with ( select form_desc from PH_FORM_LANG_VW where form_code=e.form_code and language_id=?) form ML-BRU-SCF-0417 (issue 3),( case when (? ='Y' and a.end_date between (sysdate- ?/24) and (sysdate+?/24) ) then 'Y' else 'N' end ) renew_yn  Added for Bru-HIMS-CRF-400
				}
				}
				sbSql1 =sbSql.toString();//Added for MMS-DM-CRF-115.4
				if(called_from.equals("CDR")){//Added for MMS-DM-CRF-115.4
					sbSql1=sbSql1.replaceAll("##REQDB##",ReqDb);//Added for MMS-DM-CRF-115.4
				}//Added for MMS-DM-CRF-115.4
				int icount=0;
				pstmt1 = connection.prepareStatement(sbSql1);//MODIFIED for MMS-DM-CRF-115.4
				pstmt1.setString(++icount,language_id);
				pstmt1.setString(++icount,language_id);
				pstmt1.setString(++icount,language_id);
				pstmt1.setString(++icount,login_facility_id);
				pstmt1.setString(++icount,language_id);
				pstmt1.setString(++icount,language_id);
				pstmt1.setString(++icount,language_id);
				pstmt1.setString(++icount,allow_renew_from_chart_summ_yn);//Added for Bru-HIMS-CRF-400
				pstmt1.setString(++icount,single_cont_renew_hrs_behind);//Added for Bru-HIMS-CRF-400
				pstmt1.setString(++icount,single_cont_renew_hrs_ahead);//Added for Bru-HIMS-CRF-400
				pstmt1.setString(++icount,patient_id);
				pstmt1.setString(++icount,ord_id);
			if(called_from.equals("CDR") && !ReqDb.equals(""))// Added for MMS-DM-CRF-115.4
				pstmt1.setString(++icount,enc_id1);
				if(allow_renew_from_chart_summ_yn.equals("Y"))
					pstmt1.setString(++icount,single_cont_renew_hrs_behind);

				resultSet1 = pstmt1.executeQuery();
				
				//String drug_code = "";  //NMC-JD-CRF-0126 COMMON-ICN-0310
				//String drug_search_by = ""; //NMC-JD-CRF-0126  COMMON-ICN-0310
				while(resultSet1.next()){
					order_id		=	resultSet1.getString("order_id");
					drug_name		=	resultSet1.getString("drug_name");
					start_date	=	checkForNull(resultSet1.getString("start_date"));
					end_date	=	checkForNull(resultSet1.getString("end_date"));
					or_order_line = checkForNull(resultSet1.getString("ORDER_LINE_NUM"));	//Added for Bru-HIMS-CRF-400				
					if(!start_date.equals("")){
						start_date = com.ehis.util.DateUtils.convertDate(start_date,"DMY","en",getLanguageId());
					}
					if(!end_date.equals("")){
						end_date = com.ehis.util.DateUtils.convertDate(end_date,"DMY","en",getLanguageId());
					}
					
					//drug_duration	= start_date +" - "+ end_date;	
					if(start_date.length()==10)
						start_date  = (start_date.substring(0,6)+start_date.substring(8));

					if(end_date.length()==10)
						end_date  = (end_date.substring(0,6)+end_date.substring(8));
					//NMC-JD-CRF-0126 - start
				/*	if(getPreallocYN().equals("Y")){

					drug_code = checkForNull(resultSet1.getString("DRUG_CODE"));
					
					pstmt2.setString(1,drug_code);
					pstmt2.setString(2,language_id);
					resultSet2 = pstmt2.executeQuery();
					
					if(resultSet2!=null && resultSet2.next()){
						drug_search_by = resultSet2.getString("DRUG_SEARCH_BY")==null?"":resultSet2.getString("DRUG_SEARCH_BY");
						if(drug_search_by.equals("G")){
						drug_name=(resultSet2.getString("GENERIC_NAME")==null ? "":resultSet2.getString("GENERIC_NAME"))+" "+(resultSet2.getString("STRENGTH_VALUE")==null ? "":resultSet2.getString("STRENGTH_VALUE"))+" "+(resultSet2.getString("STRENGTH_UOM_DESC")==null ? "":resultSet2.getString("STRENGTH_UOM_DESC"))+" "+(resultSet2.getString("FORM_DESC")==null ? "":resultSet2.getString("FORM_DESC"));
						}
					}
					closeResultSet( resultSet2 ) ;
					}*/
					//NMC-JD-CRF-0126 - end

					drug_duration	= start_date +" - "+ end_date;	
					IV_Prep_yn		=	resultSet1.getString("IV_Prep_yn")==null?"":resultSet1.getString("IV_Prep_yn");
					renew_yn		= resultSet1.getString("renew_yn")==null?"":resultSet1.getString("renew_yn");
					Order_Group.put("order_id"+count,order_id);
					Order_Group.put("drug_name"+count,drug_name);
					Order_Group.put("drug_duration"+count,drug_duration);
					Order_Group.put("IV_Prep_yn"+count,IV_Prep_yn);
					Order_Group.put("RENEW_YN"+count,renew_yn);
					Order_Group.put("or_order_line"+count,or_order_line);//Added for  Bru-HIMS-CRF-400 [IN:044502]
					Order_Group.put("DRUG_CODE"+count,checkForNull(resultSet1.getString("DRUG_CODE")));//Added for  Bru-HIMS-CRF-400 [IN:044502]
    				count++;
				} 
			}
			closeResultSet( resultSet ) ;
			closeResultSet( resultSet1 ) ;
			closeResultSet( resultSet2 ) ;
			closeStatement( pstmt ) ;
			closeStatement( pstmt1 ) ;
			closeStatement( pstmt2 ) ;

			Order_Group.put("count",String.valueOf(count)); 
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally{
			try{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
        }
		return Order_Group;
	}

	public ArrayList getIVLegends(){
        Connection connection       = null ;
        PreparedStatement pstmt     = null ;
		ResultSet rset              = null ;
		ArrayList legends=new ArrayList();
		try{
			connection=getConnection();

			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_CHART_SUMM_CURR_MEDNS_SELECT3") );
			rset=pstmt.executeQuery();
			
			if(rset!=null){
				while(rset.next()){
					legends.add(rset.getString("IV_DRUG_FLUID_CONTINUOUS_LG"));
					legends.add(rset.getString("IV_DRUG_FLUID_INTERMITTENT_LG"));
					legends.add(rset.getString("IV_WITHOUT_ADDITIVES_LG"));
				}
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( rset ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
      return legends;
	}

  public HashMap getPeriodChk(String facility_id){//Added for Bru-HIMS-CRF-400-Start
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		HashMap   PeriodChk		= new HashMap();
		String pre_alloc_yn ="";//Added for NMC-JD-CRF-0126

		try {

            connection	= getConnection() ;
          	pstmt		= connection.prepareStatement( "SELECT (case when( b.single_cont_renew_hrs_behind is null or b.single_cont_renew_hrs_ahead is null) then 'N'else  a.allow_renew_from_chart_summ_yn end) allow_renew_from_chart_summ_yn, b.single_cont_renew_hrs_behind,b.single_cont_renew_hrs_ahead,a.PRE_ALLOC_APPL FROM ph_facility_param a, or_param_by_facility b WHERE A.FACILITY_ID=? AND b.operating_facility_id = a.facility_id ") ;//PRE_ALLOC_APPL Added for NMC-JD-CRF-0126
			pstmt.setString(1,facility_id);			
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				PeriodChk.put("ALLOW_RENEW_FROM_CHART_SUMM_YN",resultSet.getString("ALLOW_RENEW_FROM_CHART_SUMM_YN"));
				PeriodChk.put("SINGLE_CONT_RENEW_HRS_BEHIND",resultSet.getString("SINGLE_CONT_RENEW_HRS_BEHIND"));
				PeriodChk.put("SINGLE_CONT_RENEW_HRS_AHEAD",resultSet.getString("SINGLE_CONT_RENEW_HRS_AHEAD"));
				pre_alloc_yn =resultSet.getString("PRE_ALLOC_APPL")==null?"N":resultSet.getString("PRE_ALLOC_APPL");//Added for NMC-JD-CRF-0126
				setPreallocYN(pre_alloc_yn);//Added for NMC-JD-CRF-0126
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
		return PeriodChk;
   }//Added for Bru-HIMS-CRF-400-End
} 

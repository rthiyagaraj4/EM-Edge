/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
02/11/2011	  IN29375		Menaka	     CA >> Record consent
										 Function pending consent is show code of clinic but system should be show the clinic name same as register order function
08/06/2012	  IN032329		Menaka V	 Not able to record the consent functions once a patient is picked up from the “Referral
										 List” in CA . 
24/09/2012    IN034904      Chowminya G  CRF-CA- Bru-HIMS-CRF-121/03-The Order is not Cancelled after we Record Refusal										 
24/09/2012    IN035550     	Chowminya G  CRF-CA- Bru-HIMS-CRF-121/07-When a single Order is cancelled from the List,order is not displayed - reopen
18/01/2013	  IN037372		Ramesh G	 Oracle 11g Weblogic compilation.
16/03/2013    IN037783		Chowminya G	 Special character in the Consent Form in OR
22/07/2013    IN041421      Chowminya G  Special characters - While record consent "Internal Server Error" is displayed
01/08/2013    IN042027		Chowminya G  Catalog Name Does Not Display In Refusal Form For Catalogs Which Does Not Have A Consent Attached
20/08/2013	  IN038797	   Karthi L		To include the field (Filter) of "Speciality" in the function of "Pending Consent" in Practitioner's homepage
11/09/2013	  IN043054	   Karthi L		Search for consents by Practitioner’s Primary Speciality level, find that the Consent are not listed
21/10/2015	  IN057196	   	Ramesh G	Recording Of Consent Form
01/08/2016	  IN060107	  Krishna Gowtham	ML-MMOH-SCF-0390
--------------------------------------------------------------------------------------------------------
*/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

import eCommon.Common.*;
import eOR.Common.* ;
import webbeans.eCommon.*;

import eOR.ORConsentOrder.*;

public class ConsentOrders extends eOR.Common.OrAdapter implements java.io.Serializable {

	protected String order_type_code = "";
	protected String total_records = "";
	//protected String pract_id = "";
	protected String security_level = "";
	
	protected Hashtable allValues = new Hashtable();
//	protected Hashtable printValues = new Hashtable();
	protected HashMap consentDetail = new HashMap();
	protected HashMap consentFrmId = new HashMap();//added for multi consent on 5/4/2007
	protected HashMap patientDetail = new HashMap();
//	protected ArrayList persistence_details		= new ArrayList();
 
	StringBuffer traceVals = new StringBuffer();
	String key=null;
	String value=null;
	private LinkedHashMap consents_update			= new LinkedHashMap();
	private LinkedHashMap consents_modify			= new LinkedHashMap();
	private LinkedHashMap consents_details			= new LinkedHashMap();
	private LinkedHashMap consent_order_line_num			= new LinkedHashMap();
	String total_rec_avail=null;
	String ord_catalog_code=null;
	String total_consents_req=null;
	String befOrder=null;
	String befRegn=null;
	String variable_stage=null;
	String consent_form_id=null;
	String consent_form_stage=null;
	String default_chk=null;
	String seq_num=null;
	

//    HttpServletRequest request 				= null;
//	HttpServletResponse response 			= null;

	public void setMode(String mode){					this.mode = mode;	}
	public void setTotalRecs(String total_records){	this.total_records = total_records;	}
	//public void setPractId(String pract_id){			this.pract_id = pract_id;	}

/*    public void setRequestResponse(HttpServletRequest request, HttpServletResponse response){
			this.request = request;
			this.response = response;
	}
*/
	public void setConsentDetail(HashMap consentDetail){
		this.consentDetail = consentDetail;
	}

	public void setPatientDetail(HashMap patientDetail){
		this.patientDetail = patientDetail;
	}
	//added for multi consent on 5/4/2007
	public void setConsentFormId(String index,String form_id){
		this.consentFrmId.put(index,form_id);
	}//5/4/2007
/*	public void setDetails(ArrayList persistence_details){
			this.persistence_details=persistence_details;
	}
*/
	public String getMode(){					return mode;	}
	public String getTotalRecs(){				return total_records;	}
    public Hashtable getAllValues() {
        return allValues;
    }
	public HashMap getConsentDetail(){				return this.consentDetail;	}
	public HashMap getPatientDetail(){				return this.patientDetail;	}
	//added for multi consent 5/4/2007
	public HashMap getConsentFormId(){			return this.consentFrmId;	}

	//5/4/2007
//	public ArrayList getDetails(){		return persistence_details;	}
	public boolean setModifyValues(String key, String value)
	{
		String[] keyValues=key.split("!!");
		String[] Values=value.split("!!");
		String hash_value=null;
		boolean flag=false;
		boolean dupilcate=false;
		Set s;
		Iterator it;
		s = consents_modify.entrySet();
		it = s.iterator();
		while (it.hasNext()){
			
			String temp_value=it.next().toString();
			String[] hashValues=temp_value.split("=");
			String[] keyValues1=hashValues[0].split("!!");
			String[] Values1=hashValues[1].split("!!");
			if(key.equals(hashValues[0]))
			{
			flag=true;
			hash_value=hashValues[0];
			}
			
		if(!(keyValues1[1].equals(keyValues[1])) && (Values[0].equals(Values1[0]) && keyValues1[0].equals(keyValues[0])))
			{
				dupilcate=true;
			}
			
		}
	
	if(flag && !dupilcate)
		{
		consents_modify.remove(hash_value);
		consents_modify.put(key,value);
		}
	else if(!dupilcate)
		{
		consents_modify.put(key,value);
		}
		return dupilcate;

	}
 
	
/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/
	public void clearHasp()
	{
		consents_modify.clear();
		consents_update.clear();
		consents_details.clear();
		consent_order_line_num.clear();
	}
	public ArrayList getLocation(Properties properties, String location_type, String practitioner_id, String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
				connection			= ConnectionManager.getConnection(properties) ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCATION") ) ;
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, language_id);
				pstmt.setString( 3, practitioner_id.trim() ) ;
				pstmt.setString( 4, location_type.trim() ) ;
				pstmt.setString( 5, facility_id.trim() ) ;
				pstmt.setString( 6, language_id);
				pstmt.setString( 7, location_type.trim() ) ;

				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
					String[] record = new String[2];
					record[0] = resultSet.getString( "locn_code" )  ;
					record[1] = resultSet.getString( "locn_short_desc" )  ;

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



/**
	This will populate all the Status list by priority
	@return		:	ArrayList
*/

	public ArrayList getStatusByPriority(Properties properties, String source_type, String source_code, String practitioner_id, String patientId, String period_from, String period_to) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			if(source_type.equals(" ")) source_type = null;
			if(source_code.equals(" ")) source_code = null;
			if(patientId.equals(" ")) patientId	= "";
			if(period_from.equals(" ")) period_from	= "";
			if(period_to.equals(" ")) period_to	= "";
			/* Thai date validations start 16/02/2007*/
			if (!language_id.equals("en"))
			{
				period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
				period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
			}
			/* Thai date validations end 16/02/2007*/
			connection			= ConnectionManager.getConnection(properties) ;
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_SELECT_STATUS_PRIORITY") ) ;
				pstmt = connection.prepareStatement("select PRIORITY||'<font color=black><b> ('||count(*)||')' priorty , count(*) totalCount , PRIORITY  PRIORITY_desc,nvl(PRIORITY,'R') PRIORITY from or_order A  WHERE nvl(a.SOURCE_TYPE,'XX')=NVL(decode((?),'W','N','D','N','E','C',(?)),nvl(a.source_TYPE,'XX')) AND nvl(a.SOURCE_code,'XX') =NVL((?),nvl(a.source_CODE,'XX')) And ( a.source_type !='R' and (a.source_type,a.source_CODE) IN (SELECT DECODE(LOCN_TYPE,'W','N',LOCN_TYPE),locn_code FROM ca_pract_by_locn_view WHERE practitioner_id=(?)) or  a.source_type ='R') and a.patient_id = nvl(?,patient_id) and a.ORD_DATE_TIME  between to_date(nvl((?),'01/01/1000'),'dd/mm/yyyy') and  to_date(nvl((?),'31/12/9999'),'dd/mm/yyyy')+.999 AND (a.ORDER_STATUS =  (select order_status_code from  or_order_status_code where ORDER_STATUS_Type ='00') OR exists (select 'Y' from or_order_line where order_id = a.order_id and ORD_CONSENT_STATUS = 'P' and rownum <=1)  )  and  nvl(a.cont_order_ind,'DO') in ('CO','DO','CR','DR') Group by PRIORITY order by decode(PRIORITY,'S','1','U','2','R','3') ") ;
			pstmt.setString( 1, source_type ) ;
			pstmt.setString( 2, source_type ) ;
			pstmt.setString( 3, source_code) ;
			pstmt.setString( 4, practitioner_id.trim() ) ;
			pstmt.setString( 5, patientId) ;
			pstmt.setString( 6, period_from) ;
			pstmt.setString( 7, period_to) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[4];
				record[0] = resultSet.getString( "priorty" )  ;
				record[1] = resultSet.getString( "totalCount" )  ;
				record[2] = resultSet.getString( "priority_desc" )  ;
				record[3] = resultSet.getString( "priority" )  ;				
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

 	//public ArrayList getStatusByPriority(Properties properties, String ord_facility, String source_type, String source_code, String practitioner_id, String patientId, String period_from, String period_to) throws Exception  // BRU-HIMS-CRF-359 [IN038797]
	//IN057196 Start.
	//public ArrayList getStatusByPriority(Properties properties, String ord_facility, String source_type, String source_code, String practitioner_id, String patientId, String period_from, String period_to, String speciality_code) throws Exception // BRU-HIMS-CRF-359 [IN038797]
	public ArrayList getStatusByPriority(Properties properties, String ord_facility, String source_type, String source_code, String practitioner_id, String patientId, String period_from, String period_to, String speciality_code, String consentRec_order_id) throws Exception
	//IN057196 End.
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		String sqlstr =""; 
		String patient_class =""; 
		consentRec_order_id = checkForNull(consentRec_order_id,"" )  ; //IN057196
		StringBuffer sqlquery = new StringBuffer();
		try 
		{
			if(source_type.equals(" ")) source_type = null;
			if(source_code.equals(" ")) source_code = null;
			if(patientId.equals(" ")) patientId	= "";
			if(period_from.equals(" ")) period_from	= "";
			if(period_to.equals(" ")) period_to	= "";
			if(speciality_code == null) speciality_code = ""; // added for Bru-HIMS-CRF-359 [IN:038797]
			if(source_type!=null && source_type.equalsIgnoreCase("C"))
			{
			   patient_class	= "OP";
			}
			else if(source_type!=null && source_type.equalsIgnoreCase("D"))
			{
			   patient_class	= "DC";
			}
			else if(source_type!=null && source_type.equalsIgnoreCase("E"))
			{
			   patient_class	= "EM";
			}
			else if(source_type!=null && source_type.equalsIgnoreCase("W"))
			{
			   patient_class	= "IP";
			}
			else if(source_type!=null && source_type.equalsIgnoreCase("R"))
			{
			   patient_class	= "XT";
			}
			
			int indexid =1;
			/* Thai date validations start 16/02/2007*/
			if (!language_id.equals("en"))
			{
				period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
				period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
			}
			/* Thai date validations end 16/02/2007*/
			connection			= ConnectionManager.getConnection(properties) ;
			//sqlstr = OrRepository.getOrKeyValue("SQL_OR_ORDER_SELECT_STATUS_PRIORITY1");
			//IN032329 Starts
			//sqlstr = "SELECT nvl(a.PRIORITY,'R') PRIORITY,COUNT (*) no_of_rec FROM OR_ORDER_PEND_STATUS_LOG a WHERE a.PEND_STATUS_IND=? and ORDERING_FACILITY_ID=?  and a.ORDER_DATE between TO_DATE(?,'dd/mm/yyyy') AND  TO_DATE(?,'dd/mm/yyyy')+.99999  #PATITENT_COND# #SOURCE_TYPE_COND1#  #SOURCE_CODE_COND1# AND (a.source_type != 'R' AND (decode(a.source_type,'W','N','E','C',a.source_type), a.source_code) IN (SELECT decode(locn_type,'W','N',locn_type),locn_code  FROM ca_pract_by_locn_detail WHERE  facility_id = ? and practitioner_id = ?  #SOURCE_CODE_COND2# ) OR a.source_type = 'R' ) Group by nvl(a.PRIORITY,'R') order by decode(nvl(a.PRIORITY,'R'),'S','1','U','2','R','3')";
			// BRU-HIMS-CRF-359 [IN038797] - Start
			//sqlstr = "SELECT nvl(a.PRIORITY,'R') PRIORITY,COUNT (*) no_of_rec FROM OR_ORDER_PEND_STATUS_LOG a WHERE a.PEND_STATUS_IND=? and ORDERING_FACILITY_ID=?  and a.ORDER_DATE between TO_DATE(?,'dd/mm/yyyy') AND  TO_DATE(?,'dd/mm/yyyy')+.99999  #PATITENT_COND# #SOURCE_TYPE_COND1#  #SOURCE_CODE_COND1# ##FILTER$$ Group by nvl(a.PRIORITY,'R') order by decode(nvl(a.PRIORITY,'R'),'S','1','U','2','R','3')"; // commented for BRU-HIMS-CRF-359 [IN038797]
			
			sqlquery.append("SELECT nvl(a.PRIORITY,'R') PRIORITY,COUNT (*) no_of_rec FROM OR_ORDER_PEND_STATUS_LOG a WHERE ");
			
			if(!speciality_code.equals("") ){
				 sqlquery.append(" speciality_code = ? and ");
			}
			//IN057196 Stat.
			if(!consentRec_order_id.equals("") ){
				 sqlquery.append(" a.order_id = ? and ");
			}
			//IN057196 End.
			sqlquery.append("a.PEND_STATUS_IND=? and ORDERING_FACILITY_ID=?  and a.ORDER_DATE between TO_DATE(?,'dd/mm/yyyy') AND  TO_DATE(?,'dd/mm/yyyy')+.99999  #PATITENT_COND# #SOURCE_TYPE_COND1#  #SOURCE_CODE_COND1# ##FILTER$$ Group by nvl(a.PRIORITY,'R') order by decode(nvl(a.PRIORITY,'R'),'S','1','U','2','R','3')");
			sqlstr = sqlquery.toString();
			//BRU-HIMS-CRF-359 [IN038797] - End
			//if(patientId==null)
			if(patientId==null || patientId.equals(""))
			{
				sqlstr=sqlstr.replace("##FILTER$$"," AND (a.source_type != 'R' AND (decode(a.source_type,'W','N','E','C',a.source_type), a.source_code) IN (SELECT decode(locn_type,'W','N',locn_type),locn_code  FROM ca_pract_by_locn_detail WHERE  facility_id = ? and practitioner_id = ?  #SOURCE_CODE_COND2# ) OR a.source_type = 'R' ) ");
			}
			else 
			{
				sqlstr=sqlstr.replace("##FILTER$$"," and a.patient_id = ?  ");
			}
			//IN032329 Ends
			if (!patientId.equals(""))
			{
				sqlstr = sqlstr.replace("#PATITENT_COND#"    ," and a.patient_id = ? ");	
			}
			else
			{
				sqlstr = sqlstr.replace("#PATITENT_COND#"    ," ");
			}
			if (!source_type.equals("")&& source_type!=null)
			{
				sqlstr = sqlstr.replace("#SOURCE_TYPE_COND1#"," and a.patient_class=? AND a.SOURCE_TYPE = decode(?,'W','N','D','N','E','C',a.source_type) ");
				//sqlstr = sqlstr.replace("#SOURCE_TYPE_COND2#"," AND locn_type = decode(?,'W','N',?) ");
			}
			else
			{
				sqlstr = sqlstr.replace("#SOURCE_TYPE_COND1#"    ," ");
				//sqlstr = sqlstr.replace("#SOURCE_TYPE_COND2#"    ," ");
			}

			if (!source_code.equals("") && source_code!=null)
			{
				sqlstr = sqlstr.replace("#SOURCE_CODE_COND1#"," AND a.SOURCE_code=?  ");	
				sqlstr = sqlstr.replace("#SOURCE_CODE_COND2#"," AND locn_code=? ");	
			}
			else
			{
				sqlstr = sqlstr.replace("#SOURCE_CODE_COND1#"    ," ");
				sqlstr = sqlstr.replace("#SOURCE_CODE_COND2#"    ," ");
			}
			pstmt = connection.prepareStatement( sqlstr ) ; /*fine tuned*/
			//BRU-HIMS-CRF-359 [IN038797] - Start
			if(!speciality_code.equals("")) {
				pstmt.setString( indexid++, speciality_code );
			}
			// End
			//IN057196 Start.
			if(!consentRec_order_id.equals("") ){
				pstmt.setString( indexid++, consentRec_order_id );
			}
			//IN057196 End.
			pstmt.setString( indexid++, "PC" );
			pstmt.setString( indexid++, ord_facility );
			pstmt.setString( indexid++, period_from) ;
			pstmt.setString( indexid++, period_to) ;

			if (!patientId.equals(""))
			{
				pstmt.setString( indexid++, patientId );
			}
			
			//pstmt.setString( indexid++, source_type );

			if (!source_type.equals("")&& source_type!=null)
			{
				pstmt.setString( indexid++, patient_class) ;
				pstmt.setString( indexid++, source_type );
				//pstmt.setString( indexid++, source_type );
			}

			if (!source_code.equals("") && source_code!=null)
			{
				pstmt.setString( indexid++, source_code );
			}
			//IN032329 starts
			//pstmt.setString( indexid++, ord_facility) ;
			//pstmt.setString( indexid++, practitioner_id.trim() ) ;
			/*if (!source_type.equals("")&& source_type!=null)
			{
				pstmt.setString( indexid++, source_type );
				pstmt.setString( indexid++, source_type );
			}*/

			/*if (!source_code.equals("") && source_code!=null)
			{
				pstmt.setString( indexid++, source_code );
			}*/
			//if(patientId==null)
			if(patientId==null || patientId.equals(""))
			{
				pstmt.setString( indexid++, ord_facility.trim()) ;
				pstmt.setString( indexid++, practitioner_id.trim() ) ;
				if (!source_code.equals("") && source_code!=null)
				{
					pstmt.setString( indexid++, source_code );
				}
			}
			else
			{			
				pstmt.setString( indexid++, patientId) ;
			}
			//IN032329 ends
			
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				String[] record = new String[2];
				record[0] = resultSet.getString( "PRIORITY" )  ;
				record[1] = resultSet.getString( "no_of_rec" )  ;
				//record[2] = resultSet.getString( "priority_desc" )  ;
				//record[3] = resultSet.getString( "priority" )  ;				
				OrderCat.add(record) ;
			}

		} 
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return OrderCat;
	}


/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/

	//public ArrayList getStatusByCategory(Properties properties, String ord_facility, String source_type, String source_code, String practitioner_id, String patientId, String period_from, String period_to) throws Exception // BRU-HIMS-CRF-359 [IN038797]
	//IN057196 Start.
	//public ArrayList getStatusByCategory(Properties properties, String ord_facility, String source_type, String source_code, String practitioner_id, String patientId, String period_from, String period_to, String speciality_code) throws Exception // BRU-HIMS-CRF-359 [IN038797]
	public ArrayList getStatusByCategory(Properties properties, String ord_facility, String source_type, String source_code, String practitioner_id, String patientId, String period_from, String period_to, String speciality_code, String consentRec_order_id) throws Exception 
	//IN057196 End.
	{
		
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		String sqlstr =""; 
		String patient_class =""; 
		StringBuffer sqlquery = new StringBuffer(); 	// added for for Bru-HIMS-CRF-359 [IN:038797]
		int indexid =1;
		consentRec_order_id = checkForNull(consentRec_order_id,"" )  ; //IN057196
		try 
		{
			if(source_type.equals(" ")) source_type = null;
			if(source_code.equals(" ")) source_code = null;
			if(patientId==null || patientId.equals(" ")) patientId	= "";
			if(period_from==null || period_from.equals(" ")) period_from	= "";
			if(period_to==null || period_to.equals(" ")) period_to	= "";
			if(speciality_code == null) speciality_code = ""; // added for Bru-HIMS-CRF-359 [IN:038797]
			if(source_type!=null && source_type.equalsIgnoreCase("C"))
			{
			   patient_class	= "OP";
			}
			else if(source_type!=null && source_type.equalsIgnoreCase("D"))
			{
			   patient_class	= "DC";
			}
			else if(source_type!=null && source_type.equalsIgnoreCase("E"))
			{
			   patient_class	= "EM";
			}
			else if(source_type!=null && source_type.equalsIgnoreCase("W"))
			{
			   patient_class	= "IP";
			}
			else if(source_type!=null && source_type.equalsIgnoreCase("R"))
			{
			   patient_class	= "XT";
			}

			/* Thai date validations start 16/02/2007*/
			if (!language_id.equals("en")){
				period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
				period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
			}
			/* Thai date validations end 16/02/2007*/

			connection			= ConnectionManager.getConnection(properties) ;
			//sqlstr =OrRepository.getOrKeyValue("SQL_OR_ORDER_SELECT_STATUS_CATEGORY");
			//IN032329 Starts
			//sqlstr ="SELECT OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') short_description,COUNT (*) no_of_rec, a.order_category ord_cat FROM OR_ORDER_PEND_STATUS_LOG a WHERE a.PEND_STATUS_IND=? and ORDERING_FACILITY_ID=?  and a.ORDER_DATE between TO_DATE(?,'dd/mm/yyyy') AND  TO_DATE(?,'dd/mm/yyyy')+.99999 #PATITENT_COND# #SOURCE_TYPE_COND1#  #SOURCE_CODE_COND1# AND (a.source_type != 'R' AND (decode(a.source_type,'W','N','D','N','E','C',a.source_type), a.source_code) IN (SELECT decode(locn_type,'W','N',locn_type),locn_code  FROM ca_pract_by_locn_detail WHERE  facility_id = ? and practitioner_id = ?   #SOURCE_CODE_COND2# ) OR a.source_type = 'R' ) Group by  a.order_category Order by 1";
			
			//sqlstr ="SELECT OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') short_description,COUNT (*) no_of_rec, a.order_category ord_cat FROM OR_ORDER_PEND_STATUS_LOG a WHERE a.PEND_STATUS_IND=? and ORDERING_FACILITY_ID=?  and a.ORDER_DATE between TO_DATE(?,'dd/mm/yyyy') AND  TO_DATE(?,'dd/mm/yyyy')+.99999 #PATITENT_COND# #SOURCE_TYPE_COND1#  #SOURCE_CODE_COND1# ##FILTER$$ Group by  a.order_category Order by 1"; 	// modified for for Bru-HIMS-CRF-359 [IN:038797]
			
			sqlquery.append("SELECT OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2') short_description,COUNT (*) no_of_rec, a.order_category ord_cat FROM OR_ORDER_PEND_STATUS_LOG a WHERE a.PEND_STATUS_IND=? and ORDERING_FACILITY_ID=?  and a.ORDER_DATE between TO_DATE(?,'dd/mm/yyyy') AND  TO_DATE(?,'dd/mm/yyyy')+.99999 #PATITENT_COND# #SOURCE_TYPE_COND1#  #SOURCE_CODE_COND1# ##FILTER$$"); 	// modified for for Bru-HIMS-CRF-359 [IN:038797]
			// modified for for Bru-HIMS-CRF-359 [IN:038797] - Start
			if(!speciality_code.equals("")){
				sqlquery.append(" and SPECIALITY_CODE =? ");
			}			
			//IN057196 Start.
			if(!consentRec_order_id.equals("")){
				sqlquery.append(" and a.order_id =? ");
			}
			//IN057196 End.
			sqlquery.append("Group by  a.order_category Order by 1");
			sqlstr = sqlquery.toString();
			// End
			//if(patientId==null)
			if(patientId==null || patientId.equals(""))
			{
				sqlstr=sqlstr.replace("##FILTER$$"," AND (a.source_type != 'R' AND (decode(a.source_type,'W','N','D','N','E','C',a.source_type), a.source_code) IN (SELECT decode(locn_type,'W','N',locn_type),locn_code  FROM ca_pract_by_locn_detail WHERE  facility_id = ? and practitioner_id = ?   #SOURCE_CODE_COND2# ) OR a.source_type = 'R' ) ");
			}
			else 
			{
				sqlstr=sqlstr.replace("##FILTER$$"," and a.patient_id = ?  ");
			}
			//IN032329 ends	
			if (!patientId.equals(""))
			{
				sqlstr=sqlstr.replace("#PATITENT_COND#"    ," and a.patient_id = ? ");	
			}
			else
			{
				sqlstr=sqlstr.replace("#PATITENT_COND#"    ,"");
			}
			if (!source_type.equals("")&& source_type!=null)
			{
				//sqlstr=sqlstr.replace("#SOURCE_TYPE_COND1#"," and a.patient_class=? AND a.SOURCE_TYPE = decode(?,'W','N','D','N','E','C',?) ");
				sqlstr=sqlstr.replace("#SOURCE_TYPE_COND1#"," and a.patient_class=? AND a.SOURCE_TYPE = decode(?,'W','N','D','N','E','C',a.source_type) ");
				//sqlstr=sqlstr.replace("#SOURCE_TYPE_COND2#"," AND locn_type = decode(?,'W','N',?) ");
			}
			else
			{
				sqlstr=sqlstr.replace("#SOURCE_TYPE_COND1#"    ,"");
				//sqlstr=sqlstr.replace("#SOURCE_TYPE_COND2#"    ,"");
			}
			if (!source_code.equals("") && source_code!=null)
			{
				sqlstr=sqlstr.replace("#SOURCE_CODE_COND1#"," AND a.SOURCE_code=?  ");	
				sqlstr=sqlstr.replace("#SOURCE_CODE_COND2#"," AND locn_code=? ");	
			}
			else
			{
				sqlstr=sqlstr.replace("#SOURCE_CODE_COND1#"    ,"");
				sqlstr=sqlstr.replace("#SOURCE_CODE_COND2#"    ,"");
			}
			pstmt = connection.prepareStatement( sqlstr ) ;
			pstmt.setString( indexid++, language_id);
			pstmt.setString( indexid++, "PC" );
			pstmt.setString( indexid++, ord_facility );
			pstmt.setString( indexid++, period_from) ;
			pstmt.setString( indexid++, period_to) ;
			if (!patientId.equals(""))
			{
				pstmt.setString( indexid++, patientId );
			}
			
			//pstmt.setString( indexid++, source_type );

			if (!source_type.equals("")&& source_type!=null)
			{
				pstmt.setString( indexid++, patient_class) ;
				pstmt.setString( indexid++, source_type );
				//pstmt.setString( indexid++, source_type );
			}
			
			if (!source_code.equals("") && source_code!=null)
			{
				pstmt.setString( indexid++, source_code );
			}
			
			//IN032329 Starts
			//pstmt.setString( indexid++, ord_facility) ;
			//pstmt.setString( indexid++, practitioner_id.trim() ) ;
			
			/*if (!source_type.equals("")&& source_type!=null)
			{
				pstmt.setString( indexid++, source_type );
				pstmt.setString( indexid++, source_type );
			}*/
			/*if (!source_code.equals("") && source_code!=null)
			{
				pstmt.setString( indexid++, source_code );
			}*/
			//if(patientId==null)
			if(patientId==null || patientId.equals(""))
			{
				pstmt.setString( indexid++, ord_facility.trim()) ;
				pstmt.setString( indexid++, practitioner_id.trim() ) ;
				if (!source_code.equals("") && source_code!=null)
				{
					pstmt.setString( indexid++, source_code );
				}
			}
			else
			{			
				pstmt.setString( indexid++, patientId) ;
			}
			//IN032329 Ends
				// added for Bru-HIMS-CRF-359 [IN:038797] - Start
			if(!speciality_code.equals("")){
				pstmt.setString( indexid++, speciality_code) ;
			}
			// End
			//IN057196 Start.
			if(!consentRec_order_id.equals("")){
				pstmt.setString( indexid++, consentRec_order_id) ;
			}
			//IN057196 End.
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[3];
				//record[0] = resultSet.getString( "short_desc" )  ;
				
				//record[2] = resultSet.getString( "num" )  ;
				record[0] = resultSet.getString( "short_description" )  ;
				record[1] = resultSet.getString( "no_of_rec" )  ;
				record[2] = resultSet.getString( "ord_cat" )  ;

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


/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/

	//public ArrayList getStatusByDetail(String ord_facility, String source_type, String source_code, String practitioner_id, String priority, String ord_cat, String order_by, String patientId, String period_from, String period_to, int start, int end,String practitioner_type) throws Exception // commented for Bru-HIMS-CRF-359 [IN:038797]
	// IN057196 Start.
	//public ArrayList getStatusByDetail(String ord_facility, String source_type, String source_code, String practitioner_id, String priority, String ord_cat, String order_by, String patientId, String period_from, String period_to, int start, int end,String practitioner_type,String specialty_code) throws Exception // modified for Bru-HIMS-CRF-359 [IN:038797]
	public ArrayList getStatusByDetail(String ord_facility, String source_type, String source_code, String practitioner_id, String priority, String ord_cat, String order_by, String patientId, String period_from, String period_to, int start, int end,String practitioner_type,String specialty_code, String consentRec_order_id) throws Exception
	// IN057196 End.
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCat			= new ArrayList() ;
 		String sqlstr = ""; 
 		String patient_class = ""; 
		int indexid =1;
		StringBuffer sqlquery = new StringBuffer();
		consentRec_order_id = checkForNull(consentRec_order_id,"" )  ; //IN057196
		try 
		{
			if(source_type==null) source_type = "";
			if(source_code==null) source_code = "";
			if(patientId==null || patientId.equals(" ")) patientId ="";
			if(priority==null) priority = "";
			if(ord_cat==null) ord_cat = "";
			if(order_by==null) order_by = "";
			if(period_from==null) period_from = "";
			if(period_to==null) period_to = "";
			if(practitioner_type==null) practitioner_type = "";
			if(specialty_code == null) specialty_code = ""; // added for Bru-HIMS-CRF-359 [IN:038797]
			if(source_type!=null && source_type.equalsIgnoreCase("C"))
			{
			   patient_class	= "OP";
			}
			else if(source_type!=null && source_type.equalsIgnoreCase("D"))
			{
			   patient_class	= "DC";
			}
			else if(source_type!=null && source_type.equalsIgnoreCase("E"))
			{
			   patient_class	= "EM";
			}
			else if(source_type!=null && source_type.equalsIgnoreCase("W"))
			{
			   patient_class	= "IP";
			}
			else if(source_type!=null && source_type.equalsIgnoreCase("R"))
			{
			   patient_class	= "XT";
			}
			
			if (!language_id.equals("en"))
			{
				period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");	
				period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
			}
			
			connection = getConnection() ;
			//IN29375 Starts
			//sqlstr =OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_SELECT_STATUS_DTL");
			//IN032329 Starts
			//sqlstr="SELECT  a.order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.priority priority_desc,am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class,a.SOURCE_TYPE,a.SOURCE_CODE,a.order_id,a.patient_id,a.encounter_id,TO_CHAR (a.ORDER_DATE, 'DD/MM/YYYY HH24:MI') order_date_time,decode(b.added_module_id,'RD','$$RD##'||'::'||b.reason_for_addition||'::')||f.catalog_synonym||DECODE (a.order_category, 'PH', ((SELECT DECODE (am_get_desc.am_trade_name (trade_code, ?, '1'),NULL, '','[' ||am_get_desc.am_trade_name (trade_code, ?, '1') || ']') trade_name  FROM or_order_line_ph WHERE order_id = b.order_id AND order_line_num = b.order_line_num))  || DECODE(b.order_type_code,'MS', '',('<br />'|| RTRIM (RTRIM (TO_CHAR (b.qty_value, '9999999999999990.999999999999'), '0'), '.')|| ' ' || PH_GET_UOM_DISPLAY(d.ordering_facility_id,b.qty_unit,?)|| ' '||(decode(b.freq_code,null,'',am_get_desc.am_frequency (b.freq_code, ?, '1'))||decode(b.durn_value,null,'',' * ' || b.durn_value|| ' ' || am_get_desc.am_duration_type (b.durn_type, ?, '1')|| '<br />')|| '['|| TO_CHAR (b.start_date_time, 'dd/mm/yyyy')|| decode(b.end_date_time,null,'','-') || TO_CHAR(b.end_date_time, 'dd/mm/yyyy') || ']' ))),'')  order_detail,DECODE (?,'en', c.patient_name,NVL (c.patient_name_loc_lang, c.patient_name)) patient_name,c.sex,get_age(c.date_of_birth) age, a.ORDER_TYPE order_type_code,a.ORD_PRACT_ID,am_get_desc.am_practitioner (a.ORD_PRACT_ID,?,'1') ordering_pract_name,b.order_line_status,or_get_desc.or_order_status_code(b.order_line_status,?,'2') order_status_short_desc,b.order_catalog_code,b.order_line_num,nvl(a.cont_order_ind,'DO') cont_order_ind, b.ord_appr_reqd_yn,b.ord_consent_reqd_yn,b.ord_auth_reqd_yn,b.appt_reqd_yn,d.ord_appr_by_user_id,d.ord_auth_by_pract_id,d.ORDER_STATUS,d.ord_consent_by_id,d.order_set_id order_set_id,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description FROM OR_ORDER_PEND_STATUS_LOG a, or_order_line b, mp_patient c, or_order d,or_catalog_synonym_lang_vw f  WHERE b.order_id = a.order_id   and b.order_catalog_code=f.order_catalog_code   AND f.language_id = ? AND catalog_synonym_type = or_get_synonym_type (?, b.order_catalog_code) and d.order_id = a.order_id  AND a.order_line_num=b.order_line_num  and c.patient_id=a.patient_id AND a.PEND_STATUS_IND='PC' #PATITENT_COND#  AND a.ordering_facility_id = ? #SOURCE_TYPE_COND1# #SOURCE_CODE_COND1# AND NVL (a.priority, 'R') = NVL ((?), NVL (a.priority, 'R')) #ORD_CATEG# AND (a.source_type != 'R' AND (decode(a.source_type,'W','N','D','N','E','C',a.source_type), a.source_code) IN (SELECT decode(locn_type,'W','N',locn_type),locn_code  FROM ca_pract_by_locn_detail WHERE facility_id = ? and practitioner_id = ?   #SOURCE_CODE_COND2# ) OR a.source_type = 'R' ) AND a.ORDER_DATE BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .9999 and  nvl(a.cont_order_ind,'DO') in ('CO','DO','CR','DR') ORDER BY a.patient_id,DECODE ((?),'P', DECODE (a.priority, 'S', '1', 'U', '2', 'R', '3'),'O', a.order_category),DECODE ((?),'O', DECODE (a.priority,'S', '1','U', '2','R', '3',a.order_date))"; //IN29375 Ends
			//added for Bru-HIMS-CRF-359 [IN:038797]
			if(!specialty_code.equals("")){
				
				sqlquery.append(" select * from ( ");
			}
			
	//		sqlstr="SELECT  a.order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.priority priority_desc,am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class,a.SOURCE_TYPE,a.SOURCE_CODE,a.order_id,a.patient_id,a.encounter_id,TO_CHAR (a.ORDER_DATE, 'DD/MM/YYYY HH24:MI') order_date_time,/*decode(b.added_module_id,'RD','$$RD##'||'::'||b.reason_for_addition||'::')||f.catalog_synonym||DECODE (a.order_category, 'PH', ((SELECT DECODE (am_get_desc.am_trade_name (trade_code, ?, '1'),NULL, '','[' ||am_get_desc.am_trade_name (trade_code, ?, '1') || ']') trade_name  FROM or_order_line_ph WHERE order_id = b.order_id AND order_line_num = b.order_line_num))  || DECODE(b.order_type_code,'MS', '',('<br />'|| RTRIM (RTRIM (TO_CHAR (b.qty_value, '9999999999999990.999999999999'), '0'), '.')|| ' ' || PH_GET_UOM_DISPLAY(d.ordering_facility_id,b.qty_unit,?)|| ' '||(decode(b.freq_code,null,'',am_get_desc.am_frequency (b.freq_code, ?, '1'))||decode(b.durn_value,null,'',' * ' || b.durn_value|| ' ' || am_get_desc.am_duration_type (b.durn_type, ?, '1')|| '<br />')|| '['|| TO_CHAR (b.start_date_time, 'dd/mm/yyyy')|| decode(b.end_date_time,null,'','-') || TO_CHAR(b.end_date_time, 'dd/mm/yyyy') || ']' ))),'') */OR_GET_ORDER_CATALOG(d.ORDER_ID,d.ORDER_TYPE_CODE) order_detail,DECODE (?,'en', c.patient_name,NVL (c.patient_name_loc_lang, c.patient_name)) patient_name,c.sex,get_age(c.date_of_birth) age, a.ORDER_TYPE order_type_code,a.ORD_PRACT_ID,am_get_desc.am_practitioner (a.ORD_PRACT_ID,?,'1') ordering_pract_name,b.order_line_status,or_get_desc.or_order_status_code(b.order_line_status,?,'2') order_status_short_desc,b.order_catalog_code,b.order_line_num,nvl(a.cont_order_ind,'DO') cont_order_ind, b.ord_appr_reqd_yn,b.ord_consent_reqd_yn,b.ord_auth_reqd_yn,b.appt_reqd_yn,d.ord_appr_by_user_id,d.ord_auth_by_pract_id,d.ORDER_STATUS,d.ord_consent_by_id,d.order_set_id order_set_id,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description FROM OR_ORDER_PEND_STATUS_LOG a, or_order_line b, mp_patient c, or_order d,or_catalog_synonym_lang_vw f  WHERE b.order_id = a.order_id   and b.order_catalog_code=f.order_catalog_code   AND f.language_id = ? AND catalog_synonym_type = or_get_synonym_type (?, b.order_catalog_code) and d.order_id = a.order_id  AND a.order_line_num=b.order_line_num  and c.patient_id=a.patient_id AND a.PEND_STATUS_IND='PC' #PATITENT_COND#  AND a.ordering_facility_id = ? #SOURCE_TYPE_COND1# #SOURCE_CODE_COND1# AND NVL (a.priority, 'R') = NVL ((?), NVL (a.priority, 'R')) #ORD_CATEG# ##FILTER$$ AND a.ORDER_DATE BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .9999 and  nvl(a.cont_order_ind,'DO') in ('CO','DO','CR','DR') ORDER BY a.patient_id,DECODE ((?),'P', DECODE (a.priority, 'S', '1', 'U', '2', 'R', '3'),'O', a.order_category),DECODE ((?),'O', DECODE (a.priority,'S', '1','U', '2','R', '3',a.order_date))";//IN030298
			//if(patientId==null)
				sqlquery.append("SELECT  a.order_category,or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.priority priority_desc,am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class,a.SOURCE_TYPE,a.SOURCE_CODE,a.order_id,a.patient_id,a.encounter_id,TO_CHAR (a.ORDER_DATE, 'DD/MM/YYYY HH24:MI') order_date_time,/*decode(b.added_module_id,'RD','$$RD##'||'::'||b.reason_for_addition||'::')||f.catalog_synonym||DECODE (a.order_category, 'PH', ((SELECT DECODE (am_get_desc.am_trade_name (trade_code, ?, '1'),NULL, '','[' ||am_get_desc.am_trade_name (trade_code, ?, '1') || ']') trade_name  FROM or_order_line_ph WHERE order_id = b.order_id AND order_line_num = b.order_line_num))  || DECODE(b.order_type_code,'MS', '',('<br />'|| RTRIM (RTRIM (TO_CHAR (b.qty_value, '9999999999999990.999999999999'), '0'), '.')|| ' ' || PH_GET_UOM_DISPLAY(d.ordering_facility_id,b.qty_unit,?)|| ' '||(decode(b.freq_code,null,'',am_get_desc.am_frequency (b.freq_code, ?, '1'))||decode(b.durn_value,null,'',' * ' || b.durn_value|| ' ' || am_get_desc.am_duration_type (b.durn_type, ?, '1')|| '<br />')|| '['|| TO_CHAR (b.start_date_time, 'dd/mm/yyyy')|| decode(b.end_date_time,null,'','-') || TO_CHAR(b.end_date_time, 'dd/mm/yyyy') || ']' ))),'') */OR_GET_ORDER_CATALOG(d.ORDER_ID,d.ORDER_TYPE_CODE) order_detail,DECODE (?,'en', c.patient_name,NVL (c.patient_name_loc_lang, c.patient_name)) patient_name,c.sex,get_age(c.date_of_birth) age, a.ORDER_TYPE order_type_code,a.ORD_PRACT_ID,am_get_desc.am_practitioner (a.ORD_PRACT_ID,?,'1') ordering_pract_name,b.order_line_status,or_get_desc.or_order_status_code(b.order_line_status,?,'2') order_status_short_desc,b.order_catalog_code,b.order_line_num,nvl(a.cont_order_ind,'DO') cont_order_ind, b.ord_appr_reqd_yn,b.ord_consent_reqd_yn,b.ord_auth_reqd_yn,b.appt_reqd_yn,d.ord_appr_by_user_id,d.ord_auth_by_pract_id,d.ORDER_STATUS,d.ord_consent_by_id,d.order_set_id order_set_id,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description "); // modified for added for Bru-HIMS-CRF-359 [IN:038797]
			// modified for for Bru-HIMS-CRF-359 [IN:038797]
			if(!specialty_code.equals("")){
				//sqlquery.append(",(SELECT SPECIALTY_CODE FROM pr_encounter WHERE encounter_id = a.encounter_id and SPECIALTY_CODE in(select SPECIALITY_CODE from am_pract_specialities where practitioner_id = ? and facility_id=?)) SPECIALTY_CODE");
				//sqlquery.append(",(SELECT SPECIALTY_CODE FROM pr_encounter WHERE encounter_id = a.encounter_id and SPECIALTY_CODE in((select SPECIALITY_CODE from am_pract_specialities where practitioner_id = ? and facility_id=?) union (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE practitioner_id = ?))) SPECIALTY_CODE");// commented for  IN042789
				//sqlquery.append(",(SELECT SPECIALTY_CODE FROM pr_encounter WHERE encounter_id = a.encounter_id) SPECIALTY_CODE"); // modified for IN042789 // commented for IN043054
				sqlquery.append(",(SELECT   SPECIALTY_CODE FROM pr_encounter WHERE encounter_id = a.encounter_id AND facility_id = ? ) SPECIALITY_CODE1,(SELECT PRIMARY_SPECIALITY_CODE FROM  AM_PRACTITIONER WHERE   practitioner_id = D.PERFORMING_PRACT_ID) SPECIALITY_CODE2");//IN043054
			}
			//IN057196 Start.
			//sqlquery.append("  FROM OR_ORDER_PEND_STATUS_LOG a, or_order_line b, mp_patient c, or_order d,or_catalog_synonym_lang_vw f  WHERE b.order_id = a.order_id   and b.order_catalog_code=f.order_catalog_code  AND f.language_id = ? AND catalog_synonym_type = or_get_synonym_type (?, b.order_catalog_code) and d.order_id = a.order_id  AND a.order_line_num=b.order_line_num  and c.patient_id=a.patient_id AND a.PEND_STATUS_IND='PC' #PATITENT_COND#  AND a.ordering_facility_id = ? #SOURCE_TYPE_COND1# #SOURCE_CODE_COND1# AND NVL (a.priority, 'R') = NVL ((?), NVL (a.priority, 'R')) #ORD_CATEG# ##FILTER$$ AND a.ORDER_DATE BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .9999 and  nvl(a.cont_order_ind,'DO') in ('CO','DO','CR','DR') ORDER BY a.patient_id,DECODE ((?),'P', DECODE (a.priority, 'S', '1', 'U', '2', 'R', '3'),'O', a.order_category),DECODE ((?),'O', DECODE (a.priority,'S', '1','U', '2','R', '3',a.order_date))");
			sqlquery.append("  FROM OR_ORDER_PEND_STATUS_LOG a, or_order_line b, mp_patient c, or_order d,or_catalog_synonym_lang_vw f  WHERE b.order_id = a.order_id   and b.order_catalog_code=f.order_catalog_code ");
			if (!consentRec_order_id.equals("")){
				sqlquery.append("  AND a.order_id=? ");
			}
			sqlquery.append("  AND f.language_id = ? AND catalog_synonym_type = or_get_synonym_type (?, b.order_catalog_code) and d.order_id = a.order_id  AND a.order_line_num=b.order_line_num  and c.patient_id=a.patient_id AND a.PEND_STATUS_IND='PC' #PATITENT_COND#  AND a.ordering_facility_id = ? #SOURCE_TYPE_COND1# #SOURCE_CODE_COND1# AND NVL (a.priority, 'R') = NVL ((?), NVL (a.priority, 'R')) #ORD_CATEG# ##FILTER$$ AND a.ORDER_DATE BETWEEN TO_DATE (NVL ((?), '01/01/1000'),'dd/mm/yyyy') AND   TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .9999 and  nvl(a.cont_order_ind,'DO') in ('CO','DO','CR','DR') ORDER BY a.patient_id,DECODE ((?),'P', DECODE (a.priority, 'S', '1', 'U', '2', 'R', '3'),'O', a.order_category),DECODE ((?),'O', DECODE (a.priority,'S', '1','U', '2','R', '3',a.order_date))");
			//IN057196 End.
			sqlstr = sqlquery.toString();
			// Bru-HIMS-CRF-359 [IN:038797] - End
			if(patientId==null || patientId.equals(""))
			{
				sqlstr=sqlstr.replace("##FILTER$$"," AND (a.source_type != 'R' AND (decode(a.source_type,'W','N','D','N','E','C',a.source_type), a.source_code) IN (SELECT decode(locn_type,'W','N',locn_type),locn_code  FROM ca_pract_by_locn_detail WHERE facility_id = ? and practitioner_id = ?   #SOURCE_CODE_COND2# ) OR a.source_type = 'R' )");
			}
			else 
			{
				sqlstr=sqlstr.replace("##FILTER$$"," and a.patient_id = ?  ");
			}
			//IN032329 Ends
			if (!patientId.equals(""))
			{
				sqlstr=sqlstr.replace("#PATITENT_COND#"    ," and a.patient_id = ? ");	
			}
			else
			{
				sqlstr=sqlstr.replace("#PATITENT_COND#"    ,"");
			}
			if (!source_type.equals("")&& source_type!=null)
			{
				//sqlstr=sqlstr.replace("#SOURCE_TYPE_COND1#"," and a.patient_class=? AND a.SOURCE_TYPE = decode(?,'W','N','D','N','E','C',?) ");
				sqlstr=sqlstr.replace("#SOURCE_TYPE_COND1#"," and a.patient_class=? AND a.SOURCE_TYPE = decode(?,'W','N','D','N','E','C',a.source_type) ");
				//sqlstr=sqlstr.replace("#SOURCE_TYPE_COND2#"," AND locn_type = decode(?,'W','N',?) ");
			}
			else
			{
				sqlstr=sqlstr.replace("#SOURCE_TYPE_COND1#"    ,"");
				//sqlstr=sqlstr.replace("#SOURCE_TYPE_COND2#"    ,"");
			}
			if (!source_code.equals("") && source_code!=null)
			{
				sqlstr=sqlstr.replace("#SOURCE_CODE_COND1#"," AND a.SOURCE_code=?  ");	
				sqlstr=sqlstr.replace("#SOURCE_CODE_COND2#"," AND locn_code=? ");	
			}
			else
			{
				sqlstr=sqlstr.replace("#SOURCE_CODE_COND1#"    ,"");
				sqlstr=sqlstr.replace("#SOURCE_CODE_COND2#"    ,"");
			}
			if (!ord_cat.equals("") && ord_cat!=null && !ord_cat.equals(" "))
			{
				sqlstr=sqlstr.replace("#ORD_CATEG#"    ," AND a.order_category = ? ");	
			}
			else
			{
				sqlstr=sqlstr.replace("#ORD_CATEG#"    ,"");
			}
			// modified for for Bru-HIMS-CRF-359 [IN:038797]
			sqlquery = new StringBuffer(sqlstr);
			if(!specialty_code.equals("")){
				//sqlquery.append(") where SPECIALTY_CODE =? "); commented for //IN043054
				sqlquery.append(") where SPECIALITY_CODE1 = ? or SPECIALITY_CODE2 = ? "); // IN043054
			}
			pstmt = connection.prepareStatement( sqlquery.toString() ) ; 	// modified for for Bru-HIMS-CRF-359 [IN:038797]
			pstmt.setString( indexid++, language_id);
			pstmt.setString( indexid++, language_id);
			/*Menaka Starts
			pstmt.setString( indexid++, language_id);
			pstmt.setString( indexid++, language_id);
			pstmt.setString( indexid++, language_id);
			pstmt.setString( indexid++, language_id);
			pstmt.setString( indexid++, language_id);
			Menaka Ends */
			pstmt.setString( indexid++, language_id);
			pstmt.setString( indexid++, language_id);
			pstmt.setString( indexid++, language_id);
			pstmt.setString( indexid++, language_id);
			pstmt.setString( indexid++, language_id);//IN29375
				// modified for for Bru-HIMS-CRF-359 [IN:038797] - Start
		/*	if(!specialty_code.equals("")){
				pstmt.setString( indexid++, practitioner_id.trim());
				pstmt.setString( indexid++, ord_facility);
				pstmt.setString( indexid++, practitioner_id.trim());
			} */ // commented for IN042789
			// End
			if(!specialty_code.equals("")){ // IN043054
				pstmt.setString( indexid++, ord_facility);
			}	
			//IN057196 Start.
			if (!consentRec_order_id.equals("")){
				pstmt.setString( indexid++, consentRec_order_id);

			}
			//IN057196 End.
			pstmt.setString( indexid++, language_id);//IN29375
			pstmt.setString( indexid++, practitioner_type);		
			if (!patientId.equals(""))
			{
				pstmt.setString( indexid++, patientId);
			}		
		
			pstmt.setString( indexid++, ord_facility ) ;
			if (!source_type.equals("")&& source_type!=null)
			{
				pstmt.setString( indexid++, patient_class) ;
				pstmt.setString( indexid++, source_type) ;
				//pstmt.setString( indexid++, source_type) ;
			}
			if (!source_code.equals("") && source_code!=null)
			{
				pstmt.setString( indexid++, source_code) ;
			}
			pstmt.setString( indexid++, priority.trim()) ;
			if (!ord_cat.equals("") && ord_cat!=null && !ord_cat.equals(" "))
			{
				pstmt.setString( indexid++, ord_cat) ;
			}
			//IN032329 Starts
			//pstmt.setString( indexid++, ord_facility ) ;
			//pstmt.setString( indexid++, practitioner_id.trim() ) ;

			/*if (!source_type.equals("")&& source_type!=null)
			{
				pstmt.setString( indexid++, source_type) ;
				pstmt.setString( indexid++, source_type) ;
			}*/
			/*if (!source_code.equals("") && source_code!=null)
			{
				pstmt.setString( indexid++, source_code) ;
			}*/
			//if(patientId==null)
			if(patientId==null || patientId.equals(""))
			{
				pstmt.setString( indexid++, ord_facility.trim()) ;
				pstmt.setString( indexid++, practitioner_id.trim() ) ;
				if (!source_code.equals("") && source_code!=null)
				{
					pstmt.setString( indexid++, source_code) ;
				}
			}
			else
			{			
				pstmt.setString( indexid++, patientId) ;
			}
			//IN032329 Ends
			pstmt.setString( indexid++, period_from) ;
			pstmt.setString( indexid++, period_to) ;
			pstmt.setString( indexid++, order_by) ;
			pstmt.setString( indexid++, order_by) ;
			// modified for for Bru-HIMS-CRF-359 [IN:038797] - Start
			if(!specialty_code.equals("")){
				pstmt.setString(indexid++, specialty_code );
				pstmt.setString(indexid++, specialty_code ); // IN043054
			}
			// End
			resultSet = pstmt.executeQuery() ;

			if(resultSet!=null) 
			{
				/*resultSet.last(); //move to the last
				total_records = resultSet.getRow();
			}

			if(resultSet!=null && total_records > 0){
					resultSet.beforeFirst()  ;*/
			if(start > 0)
				for(int i=0;(i<start-1 && resultSet.next());i++);
					//if(start!=0 && start!=1)
	 					//resultSet.absolute(start-1); 
				
				while ( start <= end && resultSet!=null && resultSet.next()) {
 					String[] record = new String[31];//IN29375
					record[0] = resultSet.getString( "order_category" )  ;
					record[1] = resultSet.getString( "order_category_short_desc" )  ;
					record[2] = resultSet.getString( "Priority_desc" )  ;
					record[3] = resultSet.getString( "patient_class_short_desc" )  ;
					record[4] = resultSet.getString( "patient_class" )  ;
					//record[5] = resultSet.getString( "location_details" )  ;
					record[5] = resultSet.getString( "order_id" )  ;
					record[6] = resultSet.getString( "patient_id" )  ;
					record[7] = resultSet.getString( "encounter_id" )  ;
					record[8] = resultSet.getString( "order_date_time" )  ;
					record[9] = resultSet.getString( "order_detail" )  ;
					//record[11] = resultSet.getString( "patient_details" )  ;
					//record[12] = resultSet.getString( "encounter_dtls" )  ;
					//record[13] = resultSet.getString( "Priority" )  ;
					record[10] = resultSet.getString( "source_type" )  ;
					record[11] = resultSet.getString( "source_code" )  ;
					record[12] = resultSet.getString( "order_type_code" )  ;
					record[13] = resultSet.getString( "order_status" )  ;
					//record[18] = resultSet.getString( "ord_consent_reqd_yn" )  ;
					record[14] = resultSet.getString( "cont_order_ind" )  ;
					record[15] = resultSet.getString( "ord_appr_reqd_yn" )  ;
					record[16] = resultSet.getString( "ord_appr_by_user_id" )  ;
					record[17] = resultSet.getString( "ord_consent_reqd_yn" )  ;
					record[18] = resultSet.getString( "ord_consent_by_id" )  ;
					record[19] = resultSet.getString( "sex" )  ;
					record[20] = resultSet.getString( "patient_name" )  ;
					record[21] = resultSet.getString( "ORDERING_PRACT_NAME" )  ;
					record[22] = resultSet.getString( "ord_auth_reqd_yn" )  ;
					record[23] = resultSet.getString( "ord_auth_by_pract_id" )  ;
					record[24] = resultSet.getString( "order_catalog_code" )  ;
					record[25] = resultSet.getString( "order_line_num" )  ;
					record[26] = checkForNull(resultSet.getString( "appt_reqd_yn" ),"N")  ;
					record[27] = resultSet.getString( "age" )  ;
					record[28] = resultSet.getString( "order_set_id" )  ;
					record[29] = resultSet.getString( "location_description" )  ;//IN29375
					// Pass the total Number of Records
					
					//record[28] = String.valueOf(total_records);

					OrderCat.add(record) ;
					start++;
				 }
				 if (resultSet.next())
				 {
					String[] templist = (String[])OrderCat.get(0);
					templist[30] = ""+(end+7);//IN29375
					
					OrderCat.set(0,templist);
				 }	
			  }
 		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		
		return OrderCat;
	}


/***************************************************************************/
/************added by Suresh.S 17-06-04 returns an id as string used as*******/
/***********parameter to b passed to getConsentDetails function***************/
/***************************************************************************/
//added for multi consent on 5/4/2007
public ArrayList getFormId(String ord_id,String order_line_num,String consent_form_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderId = new ArrayList() ;
 
		 
			try {
			if(ord_id.equals(" ")) ord_id = null;


			connection = getConnection() ;
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_SELECT_CONSENT_FORM_ID") ) ;
			//pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_SELECT_CONSENT_FORM_ID") ) ;//--[IN034888]
			//pstmt = connection.prepareStatement("select b.order_catalog_code order_catalog_code,or_get_desc.OR_ORDER_CATALOG(b.order_catalog_code,?,'2')  order_catalog_desc,c.consent_format consent_format ,or_get_desc.OR_CONSENT_FORM(c.CONSENT_FORM_ID,?,'1') consent_form_label from or_order_line a,or_order_catalog b, or_consent_form c where  a.order_id= ? and  /*a.order_line_num= ? and*/ c.consent_form_id= ? and  b.order_catalog_code =a.order_catalog_code ") ; //Commentted - [IN035550]
			pstmt = connection.prepareStatement("select b.order_catalog_code order_catalog_code,or_get_desc.OR_ORDER_CATALOG(b.order_catalog_code,?,'2')  order_catalog_desc,c.consent_format consent_format ,or_get_desc.OR_CONSENT_FORM(c.CONSENT_FORM_ID,?,'1') consent_form_label from or_order_line a,or_order_catalog b, or_consent_form c where  a.order_id= ? and  /*a.order_line_num= ? and*/ c.consent_form_id= ? and  b.order_catalog_code =a.order_catalog_code AND a.order_line_status != (select order_status_code from  or_order_status_code where ORDER_STATUS_Type ='99')") ;
			
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, language_id);
			pstmt.setString( 3,ord_id );
			//pstmt.setString( 4,order_line_num );//--[IN034888]
			pstmt.setString( 4,consent_form_id );

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next()  ) {
				String[] record = new String[5];
				//OrderId = resultSet.getString( "CONSENT_FORM_ID" )  ;
				//OrderId = resultSet.getString( "consent_form_id" )  ;
				
				//record[0] = resultSet.getString( "consent_form_id" )  ;
				record[0] = consent_form_id  ;
				record[1] = resultSet.getString( "order_catalog_code" )  ;
				record[2] = resultSet.getString( "order_catalog_desc" )  ;
				record[3] = resultSet.getString( "consent_format" )  ;
				record[4] = resultSet.getString( "consent_form_label" )  ;
				
				OrderId.add(record) ;
				}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return OrderId;
 	}//end of 5/4/2007
public ArrayList getFormId(String ord_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderId = new ArrayList() ;
 
		 
			try {
			if(ord_id.equals(" ")) ord_id = null;


			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_SELECT_CONSENT_FORM_ID") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, language_id);
			pstmt.setString( 3,ord_id );

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next()  ) {
				String[] record = new String[5];
				//OrderId = resultSet.getString( "CONSENT_FORM_ID" )  ;
				//OrderId = resultSet.getString( "consent_form_id" )  ;
				
				record[0] = resultSet.getString( "consent_form_id" )  ;
				record[1] = resultSet.getString( "order_catalog_code" )  ;
				record[2] = resultSet.getString( "order_catalog_desc" )  ;
				record[3] = resultSet.getString( "consent_format" )  ;
				record[4] = resultSet.getString( "consent_form_label" )  ;
				
				OrderId.add(record) ;
				}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return OrderId;
 	}
 
/*************************************************************************************/
/**********added by Suresh.S 17/06/2004 retreives a clob details frm the db***********/
/*********and returns as a string. used for viewing consentnotes(hyperlink************/
/*************************************************************************************/

public String getConsentDetail(String ConsentFormId,String index, String consent_format, String pat_id, String facility_id, String encntr_id, String ord_id) throws Exception {
	//String catalog_code, 
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		PreparedStatement pstmt_template= null;
		ResultSet resultSet 			= null;
		ResultSet resultSet_template	= null;
		String ConsentDet = "" ;
		int index_int = Integer.parseInt(index);
	//	StringBuffer consent_dd = new StringBuffer();//IN037783  // Common-ICN-0092  
		//oracle.sql.CLOB			clob_notes_content	= null; //IN037372
		java.sql.Clob			clob_notes_content	= null;  //IN037372
		//java.io.Reader			content_reader		= null;
		//java.io.BufferedReader	bf_content_reader	= null;
   		if(consent_format==null) consent_format="P";
		if(pat_id==null)  pat_id		= ""; else pat_id = pat_id.trim();
		if(encntr_id==null)  encntr_id	= ""; else encntr_id = encntr_id.trim();
		if(ord_id==null)  ord_id	= ""; else ord_id = ord_id.trim();


try {
			connection = getConnection() ;
	//commented for multi consent on 5/4/2007
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_SELECT_CONSENT_FORM_CONTENT") ) ;
			//pstmt = connection.prepareStatement( ("select CONSENT_FORM_CONTENT from or_consent_form  where Consent_form_id = (?) ") ) ;

			pstmt.setString( 1, ConsentFormId);

			resultSet = pstmt.executeQuery() ;

			if(resultSet.next()){
				//Web logic Conversion -- [IN037372] Start.
				//clob_notes_content	=	(oracle.sql.CLOB) resultSet.getObject("CONSENT_FORM_CONTENT");
				clob_notes_content	=	(java.sql.Clob) resultSet.getObject("CONSENT_FORM_CONTENT");
				//Web logic Conversion -- [IN037372] End.
				if(clob_notes_content!=null && clob_notes_content.length() > 0){
					ConsentDet = clob_notes_content.getSubString(1,( (int)clob_notes_content.length() ));
				}
  
			if(ConsentDet!=null && !ConsentDet.equals("") && consent_format.equals("E")) {
				// Call a method which will replace the particular records
				// IN030473 Start.
				//ConsentDet		= getMnemonicDetails(pat_id, facility_id, encntr_id, ord_id,  consent_format,  ConsentDet); 
				//ConsentDet		= getMnemonicDetails(pat_id, facility_id, encntr_id, ord_id,  consent_format,  ConsentDet,"");
				ConsentDet		= getMnemonicDetails(pat_id, facility_id, encntr_id, ord_id,  consent_format,  ConsentDet,"","");//IN042027
				
				ConsentDet 		= URLDecoder.decode(ConsentDet,"UTF-8");//IN041421
				ConsentDet 		= ConsentDet.replace("^", "%");//IN041421
				// IN030473 End.
				//IN037783 - Start IN041421 - commented
				/*if(ConsentDet.indexOf("||")!=-1)
				{
					StringTokenizer stoken = new StringTokenizer(ConsentDet,"||");
					String update_value = "";
					while(stoken.hasMoreTokens()) 
					{
						if(!update_value.equals(""))
						{
							consent_dd.append("%");
						}
						update_value		=	 stoken.nextToken();
						consent_dd.append(update_value);
						ConsentDet = consent_dd.toString();
					}
				}*/
				//IN037783 - End
				
				
			}

				/*if(clob_notes_content!=null){

					try
						{
							content_reader	= ((oracle.sql.CLOB) clob_notes_content).getCharacterStream();
							bf_content_reader = new java.io.BufferedReader(content_reader);

							char[] arr_notes_content = new char[(int)clob_notes_content.length()];

							bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());

							//ConsentDet = new String(arr_notes_content);
							ConsentDet = arr_notes_content.toString();

							bf_content_reader.close();
						}
							catch(Exception e)
							{
							}
				}//end of clob   */

				
				consentDetail.put(index_int+ConsentFormId,ConsentDet); 
			}//end of if

		} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {

				closeResultSet( resultSet ) ;
				closeResultSet( resultSet_template ) ;
				
				closeStatement( pstmt ) ;
				closeStatement( pstmt_template ) ;

				closeConnection(connection);
			}

		return ConsentDet; 
	}


/***********************************************************************************/

public ArrayList getRelationData() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList RelnCode = new ArrayList() ;

		try {
			connection = getConnection() ;
			//commented for multi consent 5/4/2007
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_RELATIONSHIP_SELECT") ) ;
			//pstmt = connection.prepareStatement( ("SELECT MP_GET_DESC.MP_RELATIONSHIP(relationship_code,?,'2') short_desc, relationship_code FROM mp_relationship WHERE eff_status='E' ORDER BY short_desc") ) ;
			pstmt.setString( 1, language_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "short_desc" )  ;
				record[1] = resultSet.getString( "relationship_code" )  ;

				RelnCode.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return RelnCode;
	}

public HashMap insert(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		try{
			if(allValues.containsKey("function_from") && ((String)allValues.get("function_from")).equals("EXISTING_MULTI_CONSENT"))
			{
			map = ExistingMulticonsentOrder();
			}
 			else if(allValues.containsKey("function_from") && ((String)allValues.get("function_from")).equals("MULTI_CONSENT")){
				map = MulticonsentOrder();
			}else{
 				map = consentOrder();
					}
		}catch(Exception e){
			e.printStackTrace() ;
		}
		System.out.println("map = > "+map);
		return map;
}

 

/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/

public HashMap ExistingMulticonsentOrder() throws Exception
	{
		HashMap record = new HashMap() ;
		HashMap sqlMap = new HashMap();
		record.put( "result", new Boolean( false ) ) ;
		HashMap recordStoreParam = new HashMap() ;
		
		recordStoreParam.put("consents_details"		,consents_details);
		recordStoreParam.put("consent_order_line_num"		,consent_order_line_num);
		recordStoreParam.put("consents_update"	,consents_update);
		recordStoreParam.put("consents_modify"	,consents_modify);
		recordStoreParam.put("login_by_id"		,login_by_id) ;
		recordStoreParam.put("login_at_ws_no"	,login_at_ws_no ) ;
		recordStoreParam.put("login_facility_id",login_facility_id ) ;
		recordStoreParam.put("function_from","EXISTING_MULTI_CONSENT") ;
		sqlMap.put("SQL_OR_MULTI_CONSENT_FORM_DRAFT_INSERT"			,OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_FORM_DRAFT_INSERT"));
		sqlMap.put("SQL_OR_MULTI_CONSENT_FORM_DRAFT_MODIFY"			,OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_FORM_DRAFT_MODIFY"));
		sqlMap.put("SQL_OR_MULTI_CONSENT_FORM_DRAFT_DELETE_FORM"			,OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_FORM_DRAFT_DELETE_FORM"));
		sqlMap.put("SQL_OR_MULTI_CONSENT_FORM_DRAFT_AVAILABLE"			,OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_FORM_DRAFT_AVAILABLE"));
		HashMap map =  new HashMap() ;
		try{
			 Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_CONSENT_ORDER_JNDI"), ORConsentOrderHome.class, getLocalEJB());
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			//HashMap tabDataParam =  new HashMap() ;
			recordStoreParam.put( "properties", getProperties() );
			//tabDataParam.put( "tabData",     record );
			Object argArray[]	= new Object[2];
			argArray[0]		= recordStoreParam;
			argArray[1]		= sqlMap;
			Class [] paramArray = new Class[2];
			paramArray[0]	= recordStoreParam.getClass();
			paramArray[1]	= sqlMap.getClass();	
			map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
			 
			  argArray		= null;
			  paramArray	= null;
			if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
				}

	  //return map;

	 }catch(Exception e){
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		
	}
	return map ;
	
	}

	public HashMap consentOrder() throws Exception {
		//HashMap map = new HashMap() ;//commented for multi consent 5/4/2007
		//StringBuffer tmpBuff	= new StringBuffer();
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;
	//	PreparedStatement pstmt_srl 	= null;
		ResultSet resultSet 			= null;
		ResultSet resultSet1 			= null;

		HashMap updt_map1 = new HashMap();
		HashMap sqlMap = new HashMap() ;
		//added for multi consent on 5/4/2007
		HashMap updtmap = new HashMap();
		ArrayList arrangedList= new ArrayList();
		ArrayList temp_link_sort= new ArrayList();
		ArrayList temp_sort= new ArrayList();
		//end of 5/4/2007
		String regn_reqd_yn			= "";
		String order_status_code 	= "";
		String order_id 			= "";
		String order_line_num		= "";//added for multi consent on 5/4/2007
		String cont_order_ind 		= "";
	//	String ord_consent_by_id 	= "";
	//	String ord_consent_reqd_yn	= "";
		String ord_appr_by_user_id  = "";
		String ord_appr_reqd_yn     = "";

	    String pat_id = "";
	//	String srl_no = "";
		String pat_name = "";
		String Consent_detail = "";
		String practioner_id = "";
		String dat_time = "";
		String remarks  = "";
		String check="";
		String pat_class="";
		String ord_id="";
		String encount_id="";
		String ord_catalog_desc="";
		String facility_id="";
		String relation="";
	//	HashMap Catalog = new HashMap();
		String order_category = "";
		//String lab_install_yn	= "";changed on 7/18/2007 for lab_install_yn by uma 
		String rd_install_yn    = "";
		String ord_auth_reqd_yn      = "";
		String ord_auth_by_pract_id    = "";
		String labchk="";
		String[] record1 = null;
		String order_set_id="";
		String order_set_bill_yn="";

	//	int result = 0;
		int count = 0;
		int cnt=0;
		HashMap patientDetails = new HashMap();
		ArrayList patient_info= null;
		traceVals.append("total recs rt :  >"+total_records);
		int int_total_records = Integer.parseInt(total_records);
		try {
			//lab_install_yn = getFacilityModuleInstallYn("RL");changed on 7/18/2007 for lab_install by uma 
			rd_install_yn  = getFacilityModuleInstallYn("RD");

			connection = getConnection() ;
			for(int i=0; i<int_total_records; i++){
				check	=	((String)allValues.get("chk"+i));//traceVals.append("--Chk value :  >"+allValues.get("chk"+i));
 				if(check.equalsIgnoreCase("y")){
                     allValues.put("chk"+i,"Y");
					order_type_code 		= (String)allValues.get("ord_typ_code"+i);
					order_id				= (String)allValues.get("ord_id"+i);
					order_line_num			= (String)allValues.get("ord_line_num"+i);//added for multi consent on 5/4/2007

					cont_order_ind			= (String)allValues.get("cont_order_ind"+i);
					//cont_order_ind = "DO";
				//	ord_consent_by_id = (String)allValues.get("ord_consent_by_id"+i);
				//	ord_consent_reqd_yn = (String)allValues.get("ord_consent_reqd_yn"+i);
					ord_appr_by_user_id = (String)allValues.get("ord_appr_by_user_id"+i);
					ord_appr_reqd_yn = (String)allValues.get("ord_appr_reqd_yn"+i);
					
					order_set_id = (((String)allValues.get("order_set_id"+i))==null?"":((String)allValues.get("order_set_id"+i)));
					order_set_bill_yn=(((String)getOrderSetDetails(order_set_id))==null?"":((String)getOrderSetDetails(order_set_id)));

/*****************************************************************************************/
					facility_id=(String)allValues.get("facility_id");
					pat_id=(String)allValues.get("pat_id"+i);
					Consent_detail = "";
	
					/*if(consentCatalog.containsKey(i)){
						if(consentDetail.containsKey(""+i)){
						Consent_detail =(String)consentDetail.get(""+i);
 					}
					else 
						Catalog="";
					*/

					//pat_name =(String)allValues.get("pat_name"+i);
					//practioner_id =(String)allValues.get("pract_id");
					//dat_time =(String)allValues.get("dat_time"+i);
					//remarks =(String)allValues.get("remarks"+i);
					pat_class =(String)allValues.get("pat_class"+i);
					ord_id =(String)allValues.get("ord_id"+i);
					encount_id =(String)allValues.get("encount_id"+i);
					ord_catalog_desc=(String)allValues.get("ord_catalog_desc"+i);
					if(ord_catalog_desc.length() > 60)
						ord_catalog_desc=ord_catalog_desc.substring(0 , 60);
					//relation=(String)allValues.get("relation"+i);

					pat_name   = ""; relation = ""; dat_time = ""; remarks = ""; practioner_id = "";
					// HashMap will contain an internal hashmap with the index as key and it will have an array list
					// with the respective order patient_name,practitioner_name,relation,curr_sys_date,
					// remarks,practitioner_id,practitioner_id
					patientDetails = (HashMap)getPatientDetail();  // Take from the bean
					if(patientDetails!=null && patientDetails.size()!=0)
					{
						//added for multi consent on 5/4/2007
						if(checkForNull((String)allValues.get("link_ref"+i)).equals("C") && !checkForNull((String)allValues.get("link_ref_no"+i)).equals(""))
							patient_info		= (ArrayList)patientDetails.get(((Integer.parseInt((String)allValues.get("link_ref_no"+i))-1)+""));  //i--> is the index	//end of 5/4/2007					
						else
						patient_info		= (ArrayList)patientDetails.get(String.valueOf(i));  //i--> is the index
						if(patient_info!=null && patient_info.size()>0) {
							pat_name			= (String)patient_info.get(0);	//patient_name
					 		//practitioner_name	= (String)patient_info.get(1); 
							relation			= (String)patient_info.get(2); 
							dat_time			= (String)patient_info.get(3);	//curr_sys_date
							if(!language_id.equals("en"))
							{
								dat_time = com.ehis.util.DateUtils.convertDate(dat_time,"DMYHM",language_id,"en");
							}
							remarks				= (String)patient_info.get(4); 
							practioner_id 		= (String)patient_info.get(5);  //practitioner_id
							//self				= (String)patient_info.get(6); 
						}  
					}
 				/*	pstmt_srl = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_SRL_NO ") ) ;

					pstmt_srl.setString( 1, pat_id ) ;
						resultSet = pstmt_srl.executeQuery() ;

						while ( resultSet != null && resultSet.next() ) {
						srl_no= resultSet.getString( "SRL_NO" )  ;
					}
				*/
/*****************************************************************************************/

					//if((ord_consent_by_id.equals("") || ord_consent_by_id == null) && ord_consent_reqd_yn.equals("Y")){
						ord_auth_reqd_yn=(String)allValues.get("ord_auth_reqd_yn"+i);
						ord_auth_by_pract_id=(String)allValues.get("ord_auth_by_pract_id"+i);
					if((ord_auth_by_pract_id.equals("null") || ord_auth_by_pract_id == null) && (ord_auth_reqd_yn!=null && ord_auth_reqd_yn.equals("Y")) ){
						//pstmt = connection.prepareStatement( ("SELECT order_status_code  FROM or_order_status_code WHERE order_status_type ='03'") ) ;
						pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_AUTHORIZE") ) ;

					}else if((ord_appr_by_user_id.equals("null") || ord_appr_by_user_id == null) && (ord_appr_reqd_yn!=null && ord_appr_reqd_yn.equals("Y")) ){
						//connection = getConnection() ;
						//pstmt = connection.prepareStatement( ("SELECT order_status_code  FROM or_order_status_code WHERE order_status_type ='05'") ) ;
						pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_SPL_APPRVL") ) ;

					}else{
						//connection = getConnection() ;
						//pstmt = connection.prepareStatement( ("SELECT regn_reqd_yn FROM or_order_type WHERE order_type_code =(?)") ) ;
						pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_REGN_REQD_YN_CHK") ) ;

						pstmt.setString( 1, order_type_code ) ;
						try{
						resultSet = pstmt.executeQuery() ;
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}


						if ( resultSet != null && resultSet.next() ) {
							regn_reqd_yn= resultSet.getString( "regn_reqd_yn" )  ;
						}
						traceVals.append("regn_reqd_yn >"+regn_reqd_yn);

						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;
				pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_SELECT_OTH_DTLS") ) ;
				pstmt1.setString( 1, checkForNull(order_id) );
         
				resultSet1 = pstmt1.executeQuery() ;
				if( resultSet1 != null && resultSet1.next() ) { 
						 record1 = new String[1];// Only One record
						record1[0]=resultSet1.getString( "ORDER_CATALOG_CODE" )  ;
				}
						closeResultSet( resultSet1 ) ;
						closeStatement( pstmt1 ) ;
						//=============================
						labchk=checkForNull(getmoduleRL(record1[0],order_category,(String)allValues.get("ord_typ_code"+i),login_facility_id),"");
						 if(regn_reqd_yn.equals("Y")) {
							 //if ( (lab_install_yn.equals("Y") && order_category.equals("LB") ) || (rd_install_yn.equals("Y") && order_category.equals("RD")) )  { changed on 7/18/2007 for lab_install_yn by uma    
							 if ( (labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") ) || (rd_install_yn.equals("Y") && order_category.equals("RD")) )  { 
								//pstmt = connection.prepareStatement( ("SELECT order_status_Code FROM or_order_status_code WHERE order_status_type ='10'") ) ;
								pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_REGN_REQD_YN_NO") ) ;

							 } else {
								//pstmt = connection.prepareStatement(   ("SELECT order_status_Code  FROM or_order_status_code WHERE order_status_type ='25'") ) ;
								pstmt = connection.prepareStatement(   OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_REGN_REQD_YN_YES") ) ;

							 }	
						}else {		// if(regn_reqd_yn.equals("N")){
								//pstmt = connection.prepareStatement( ("SELECT order_status_Code FROM or_order_status_code WHERE order_status_type ='10'") ) ;
								pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_REGN_REQD_YN_NO") ) ;
						}
 					}
					try{
					resultSet = pstmt.executeQuery() ;
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}

					while ( resultSet != null && resultSet.next() ) {
						order_status_code= resultSet.getString( "order_status_code" )  ;
					}

					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;

					traceVals.append("order_status_code >"+order_status_code);
					traceVals.append("security_level >"+security_level);
					//=============================
					String[] updt_data = new String[5];

					updt_data[0] = (String)order_status_code;
					updt_data[1] = (String)order_id;
				

					traceVals.append("updt_data length in YES Loop >"+updt_data.length);
					updtmap.put("data"+count ,updt_data);
					updtmap.put("cont_order_ind"+count ,cont_order_ind);

					count++;

					String[] updt_data1 = new String[6];

					updt_data1[0] = (String)order_status_code;
					updt_data1[1] = (String)order_id;
					updt_data1[2] = (String)ord_appr_reqd_yn;
					updt_data1[3] = (String)ord_auth_reqd_yn;
					updt_data1[4] = (String)order_set_id;
					updt_data1[5] = (String)order_set_bill_yn;

					updtmap.put("lineData"+cnt,updt_data1);

/*these datas r used to insert in to refusal orderable table, datas obtained frm modal*/

					String[] updt_refusal = new String[24];  //datas frm modal widow

					updt_refusal[0] = checkForNull((String)pat_id);
					updt_refusal[1] = (String)facility_id;
					updt_refusal[2] = checkForNull((String)encount_id);
					if(updt_refusal[2]==null || updt_refusal[2].equals("null"))
						updt_refusal[2] = "";
					updt_refusal[3] = (String)pat_class;
					updt_refusal[4] = (String)ord_id;
					updt_refusal[5] = (String)pat_name;
					updt_refusal[6] = (String)Consent_detail;
					updt_refusal[7] = (String)practioner_id;
					updt_refusal[8] = (String)dat_time;
					updt_refusal[9] = (String)remarks;
					updt_refusal[10] = (String)ord_catalog_desc;
					updt_refusal[11] = (String)relation;
					updt_refusal[12] = checkForNull(order_type_code);
					updt_refusal[13] = checkForNull((String)allValues.get("priority"+i));
					updt_refusal[14] = checkForNull((String)allValues.get("location_type"+i));
					updt_refusal[15] = checkForNull((String)allValues.get("location_code"+i));
					updt_refusal[16] = checkForNull((String)allValues.get("consent_form_list"+i));
					updt_refusal[17] = checkForNull((String)allValues.get("link_ref"+i));
					updt_refusal[18] = checkForNull((String)allValues.get("link_ref_no"+i));
					updt_refusal[19] = checkForNull((String)allValues.get("link_ref_det"+i));
					updt_refusal[20] = (String)order_line_num;
					updt_refusal[21] = checkForNull((String)regn_reqd_yn,"N");
					updt_refusal[22] = checkForNull((String)allValues.get("appt_reqd_yn"+i));
					updt_refusal[23] = checkForNull((String)allValues.get("consent_stage"+i));

					updtmap.put("consent_data"+cnt,updt_refusal);
					updtmap.put("consentDetail"+cnt,consentDetail);
					if(updt_refusal[17].equals("C") && !updt_refusal[18].equals(""))
						updtmap.put("consentDetailIndex"+cnt,((Integer.parseInt(updt_refusal[18])-1)+""));
					else
						updtmap.put("consentDetailIndex"+cnt,String.valueOf(i));
					updtmap.put("consentFrmId"+cnt, consentFrmId);
					updtmap.put(""+cnt,""+i);
					if(updt_refusal[17].equals("C") && !updt_refusal[18].equals("")){
						temp_link_sort.add(""+cnt);
						arrangedList.add(updtmap);
					}else{
						temp_sort.add(""+cnt);
						arrangedList.add(0,updtmap);
					}
					traceVals.append("====updt_map1 >"+updt_map1.toString());

					cnt++;
				}//end of if condition

			}//end of for loop
			ArrayList sortList = new ArrayList();
			for(int x=0;x<temp_sort.size();x++)
				sortList.add((String)temp_sort.get(x));
			for(int x=0;x<temp_link_sort.size();x++)
				sortList.add((String)temp_link_sort.get(x));
			
			traceVals.append("====count >"+count);
			traceVals.append("====cnt >"+cnt);
			
			updt_map1.put("traverse_list",sortList);
			updt_map1.put("DataMap",arrangedList);
			updt_map1.put("totalCount",""+count);
			updt_map1.put("lineCount",""+cnt);
			updt_map1.put( "login_by_id",login_by_id ) ;
			updt_map1.put( "login_at_ws_no",login_at_ws_no ) ;
        	updt_map1.put( "login_facility_id",login_facility_id ) ;
			
			//=============================
			try{
						sqlMap.put("SQL_OR_CONSENT_ORDER_CANCEL_WITH_CONSENT_REQD",OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_CANCEL_WITH_CONSENT_REQD") );
						sqlMap.put("SQL_OR_CONSENT_ORDER_UPDATE_ORDER_LINE",OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_UPDATE_ORDER_LINE") );

						sqlMap.put("SQL_OR_CONSENT_ORDER_CANCEL_WITH_CONSENT_REQD_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_CANCEL_WITH_CONSENT_REQD_FREQ_EXPLN") );
						sqlMap.put("SQL_OR_CONSENT_ORDER_UPDATE_ORDER_LINE_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_UPDATE_ORDER_LINE_FREQ_EXPLN") );
						sqlMap.put("SQL_OR_ORDER_COMPLETE_STATUS",OrRepository.getOrKeyValue("SQL_OR_ORDER_COMPLETE_STATUS") );
						sqlMap.put("SQL_OR_BL_WITHOUT_ORDER_CATALOG",OrRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG") );
						sqlMap.put("SQL_OR_BL_CHECK_ORDERABLE_BILLED",OrRepositoryExt.getOrKeyValue("SQL_OR_BL_CHECK_ORDERABLE_BILLED") );
						sqlMap.put("SQL_OR_ORDER_ENTRY_GET_BILL_FOR_FACILITY",OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_BILL_FOR_FACILITY") );

						sqlMap.put("SQL_OR_CONSENT_ORDER_INSERT_OR_REFUSAL_ORDERABLE",OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_INSERT_OR_REFUSAL_ORDERABLE") );
						
						sqlMap.put("SQL_OR_CONSENT_ORDER_WITH_CONSENT_STAGE",OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_WITH_CONSENT_STAGE") );
						sqlMap.put("SQL_OR_CONSENT_ORDER_UPDATE_CONSENT_BY_ID",OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_UPDATE_CONSENT_BY_ID") );
						sqlMap.put("SQL_OR_CONSENT_ORDER_UPDATE_CONSENT_STATUS",OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_UPDATE_CONSENT_STATUS") );

						sqlMap.put("SQL_OR_REFUSAL_ORDER_ORDER_DTLS_SELECT",OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_ORDER_DTLS_SELECT") );

						sqlMap.put("SQL_OR_REFUSAL_ORDER_SRL_NO",OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_SRL_NO") );

						sqlMap.put("SQL_OR_CONSENT_ORDER_SELECT_OR_REFUSAL_ORDERABLE_CLOB",OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_SELECT_OR_REFUSAL_ORDERABLE_CLOB") );

						sqlMap.put("SQL_OR_CONSENT_ORDER_UPDATE_ORDER_LINE_FREQ_EXPLN_STAGE",OrRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_ORDER_UPDATE_ORDER_LINE_FREQ_EXPLN_STAGE") );

			//added for multi consent on 5/4/2007
			sqlMap.put("SQL_OR_MULTI_CONSENT_SEQ_NO",OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_SEQ_NO") );
				sqlMap.put("SQL_OR_MULTI_CONSENT_REF_HDR_INSERT",OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_REF_HDR_INSERT") );
				sqlMap.put("SQL_OR_MULTI_CONSENT_REF_DTL_INSERT",OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_REF_DTL_INSERT") );
				sqlMap.put("SQL_OR_MULTI_CONSENT_CLOB_UPDATE",OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_CLOB_UPDATE") );
				sqlMap.put("SQL_OR_MULTI_CONSENT_WITH_CONSENT_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_WITH_CONSENT_STATUS") );
				sqlMap.put("SQL_OR_MULTI_CONSENT_GET_STAGE",OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_GET_STAGE") );
				sqlMap.put("SQL_OR_MULTI_CONSENT_GET_STAGE2",OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_GET_STAGE2") );
				
				sqlMap.put("SQL_OR_MULTI_CONSENT_ORDER_LINE_CONSENT_STAGE_UPDATE",OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_ORDER_LINE_CONSENT_STAGE_UPDATE") );
				sqlMap.put("SQL_OR_CONSENT_ORDER_UPDATE_ORDER_LINE_STAGE",OrRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_ORDER_UPDATE_ORDER_LINE_STAGE") );
				sqlMap.put("SQL_OR_CONSENT_RECORD_EXISTING_CONSENT",OrRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_RECORD_EXISTING_CONSENT") );
				sqlMap.put("SQL_OR_ORDER_STATUS_CODE_FOR_STATUS_TYPE",OrRepository.getOrKeyValue("SQL_OR_ORDER_STATUS_CODE_FOR_STATUS_TYPE") );
				sqlMap.put("SQL_OR_ORDER_GET_STATUS_CODE",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_GET_STATUS_CODE") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS") );
				
				}catch(Exception e){
				e.printStackTrace();
			}
				

					} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			patientDetails.clear();
			if(patient_info != null)
				patient_info.clear();
			//updt_map1.clear();
			//sqlMap.clear();
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
//			closeStatement( pstmt_srl ) ;
			closeConnection(connection) ;
		}

		
		return getResult(updt_map1,sqlMap);
	}//end of 5/4/2007
//changed for multi consent 5/4/2007	
public HashMap getResult(HashMap updt_map1,HashMap sqlMap){
		HashMap map = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();
			try {
					updt_map1.put( "properties", getProperties() );

					/*InitialContext context = new InitialContext() ;
					Object object = context.lookup( OrRepository.getOrKeyValue("OR_CONSENT_ORDER_JNDI") ) ;
					home  = (ORConsentOrderHome) PortableRemoteObject.narrow( object, ORConsentOrderHome.class ) ;
					
					remote = home.create() ;
					map = remote.insert( updt_map1, sqlMap ) ;*/

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_CONSENT_ORDER_JNDI"), ORConsentOrderHome.class, getLocalEJB());
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

					if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
					}
					map.put("traceVal", (String)tmpBuff.toString());
					tmpBuff.setLength(0);
  				//	boolean map_result = ((Boolean)map.get( "result" )).booleanValue();

/*					if (map.containsKey("printValues")) {
						printValues	= (Hashtable)map.get("printValues");
					}
*/
					/*if(map_result){
    					traceVals.append("<><>map result is true<><>");
    					traceVals.append("requset"+(request == null));
    					java.util.Properties props = null;

    					if(request == null)
    						traceVals.append("====request isnull> after the methoid");
    					else
    					{
//    						traceVals.append("====map> getting session ");
//    						HttpSession session = request.getSession(false);
//    						traceVals.append("====map> got session: " + session );
    					}

    					OnLinePrinting online_print = new OnLinePrinting(request,response);
    					//traceVals.append("==== online_print obj ?>?>?>" + online_print);
    					HashMap tmp_map = (HashMap)online_print.callOnlinePrint(allValues);
    					//traceVals.append("====map> after the methoid");
    					String tmp_vals = (String)tmp_map.get("traceVal");
    					//traceVals.append("====tmp_vals >"+tmp_vals);
    				}*/

			} catch(Exception e) {
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			if(((Boolean)map.get( "result" )).booleanValue()) {
				if(updt_map1.containsKey("DataMap")){
					clear();
					clearHash();
				}
			}
		}
				
		return map;

	}
// end of 5/4/2007

//returns current date n time
/*Removed while Thai date validations 16/02/2007 start*/
/*public ArrayList getSysDateTime() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList  currentDate		= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME1") ) ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate.add(resultSet.getString("curr_date"))  ;
				currentDate.add(resultSet.getString("last_week_date"))  ;
				currentDate.add(resultSet.getString("sys_date_time"))  ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}

		return currentDate;
	}*/
	/*Removed while Thai date validations 16/02/2007 end*/




/*
public HashMap updateValues(Connection connection, HashMap tabData, HashMap sqlMap){
	PreparedStatement pstmt 	= null;
	HashMap map = new HashMap() ;

	traceVals.append("====rconnection * >"+connection);
	int count =0;
	int cnt=0;

	count = Integer.parseInt((String)tabData.get("totalCount"));
	cnt 	= Integer.parseInt((String)tabData.get("lineCount"));

	traceVals.append("====count *>"+count);
	String[] updt_vals = new String[5];
	int result = 0;
	try{
	for(int i=0; i<count; i++){
		traceVals.append("i value => "+i);
		updt_vals = (String[])tabData.get("data"+i);
		traceVals.append("updt_vals length => "+updt_vals.length);


		pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_CANCEL_WITH_CONSENT_REQD") ) ;

		pstmt.setString( 1, updt_vals[0] ) ;
		pstmt.setString( 2, updt_vals[1] ) ;
		pstmt.setString( 3, updt_vals[1] ) ;


		pstmt.executeUpdate();

		updt_vals = (String[])tabData.get("lineData"+i);

		pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_UPDATE_ORDER_LINE") ) ;

		pstmt.setString( 1, updt_vals[0] ) ;
		pstmt.setString( 2, updt_vals[1] ) ;

		result = pstmt.executeUpdate();
		traceVals.append("result=> "+result);
	}

	if ( result< 1 ) {
		connection.rollback();
		map.put( "message", "Operation failure ..." ) ;

	} else  {
		connection.commit() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "Operation Completed Successfully..." ) ;
		//messages.append( "RECORD_MODIFIED" ) ;
		//messages.append( "Operation Completed Successfully..." ) ;
	}
	}catch(Exception e){

	}
	return map;
}
*/
/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/
// added for multi consent on 5/4/2007
public HashMap MulticonsentOrder() throws Exception {
		HashMap consent_detail	 = new HashMap() ;
		HashMap updt_map1		 = new HashMap() ;
		HashMap sqlMap			 = new HashMap() ;
		int int_total_records	 = Integer.parseInt(total_records);
		try {
			String check		 = "";
			int cnt				 = 0;
			
			sqlMap.put("SQL_OR_MULTI_CONSENT_FORM_DRAFT_DELETE", OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_FORM_DRAFT_DELETE"));
			sqlMap.put("SQL_OR_MULTI_CONSENT_FORM_DRAFT_INSERT", OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_FORM_DRAFT_INSERT"));
			sqlMap.put("SQL_OR_ASSOCIATE_CONSENT", OrRepositoryExt.getOrKeyValue("SQL_OR_ASSOCIATE_CONSENT") );
			
			for(int i=0; i<int_total_records; i++){
			
				if(allValues.containsKey("consent_chk"+i)){
					check	=	((String)allValues.get("consent_chk"+i));
					if(check.equalsIgnoreCase("on")){
						consent_detail.put("consent_form_id"+cnt,(String)allValues.get("consent_form_id"+i));
						consent_detail.put("consent_stage"+cnt,(String)allValues.get("consent_stage"+i));
						consent_detail.put("form_confirmed"+cnt,(String)allValues.get("form_confirmed"+i));

						cnt++;
					}
				}else{
					if((String)allValues.get("consent_form_id"+i) != null && !((String)allValues.get("consent_form_id"+i)).equals("")){
						consent_detail.put("consent_form_id"+cnt,(String)allValues.get("consent_form_id"+i));
						consent_detail.put("consent_stage"+cnt,(String)allValues.get("consent_stage"+i));
						cnt++;
					}
				}
			}
			updt_map1.put( "totalCount"		  , ""+cnt);
			updt_map1.put( "order_id"		  , (String)allValues.get("order_id"));
			updt_map1.put( "order_line_num"	  , (String)allValues.get("order_line_num"));
			updt_map1.put( "multi_consent_dtl", consent_detail);
			updt_map1.put( "login_by_id"	  , login_by_id ) ;
			updt_map1.put( "login_at_ws_no"	  , login_at_ws_no ) ;
        	updt_map1.put( "login_facility_id", login_facility_id ) ;

		}catch(Exception e){
			e.printStackTrace();
		}
		

		return getResult(updt_map1,sqlMap);
		
}//added for multi consent on 5/4/2007
	
public void setAll( Hashtable recordSet ) {

		String order_id=null;
		String order_line_num=null;
		String tot_catalogs_avail="0";
		String ord_catalog_code="";
		String viewBy="";

			allValues = recordSet;
			allValues.put("order_entry","ConsentOrder");
			if(allValues.containsKey("function_from") && ((String)allValues.get("function_from")).equals("EXISTING_MULTI_CONSENT") && ((String)allValues.get("viewBy")).equals("line"))
			{
				total_rec_avail = (String)allValues.get("total_consents_available");
				total_consents_req = (String)allValues.get("total_consents_req");
				ord_catalog_code = (String)allValues.get("ord_catalog_code");
				order_id = (String)allValues.get("order_id");
				order_line_num = (String)allValues.get("order_line_num");
				befOrder = (String)allValues.get("befOrder");
				befRegn = (String)allValues.get("befRegn");
				viewBy = (String)allValues.get("viewBy");
				consents_details.put("total_rec_avail",total_rec_avail);
				consents_details.put("total_consents_req",total_consents_req);
				consents_details.put("ord_catalog_code",ord_catalog_code);
				consents_details.put("befOrder",befOrder);
				consents_details.put("befRegn",befRegn);
				consents_details.put("order_id",order_id);
				consents_details.put("order_line_num",order_line_num);
				consents_details.put("viewBy",viewBy);				
			}
			else if(allValues.containsKey("function_from") && ((String)allValues.get("function_from")).equals("EXISTING_MULTI_CONSENT") && ((String)allValues.get("viewBy")).equals("header"))
			{
				
				order_id = (String)allValues.get("order_id");
				tot_catalogs_avail = (String)allValues.get("tot_catalogs_avail");
				viewBy = (String)allValues.get("viewBy");
				for(int i=0;i<Integer.parseInt(tot_catalogs_avail);i++)
				{
				if(allValues.containsKey("ord_catalog_code"+i) && allValues.containsKey("order_line_num"+i))
				{
				ord_catalog_code = (String)allValues.get("ord_catalog_code"+i);
				order_line_num = (String)allValues.get("order_line_num"+i);
				consent_order_line_num.put(ord_catalog_code,order_line_num);
				}
				}
				consents_details.put("order_id",order_id);
				consents_details.put("tot_catalogs_avail",tot_catalogs_avail);
				consents_details.put("viewBy",viewBy);
			}
			else
	{

			/* Thai date validations start 16/02/2007*/
		if(recordSet.containsKey("period_from"))
	 {
		if (!language_id.equals("en")){
		String period_from = (String)allValues.get("period_from");
		String period_to = (String)allValues.get("period_to");	
		
		
		if (period_from.equals(" ") || period_from.equals("null")) period_from="";
		if (period_to.equals(" ") || period_to.equals("null")) period_to="";

		period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
		period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
		allValues.put("period_from",period_from);
		allValues.put("period_to",period_to);
		}
	}
		/* Thai date validations end 16/02/2007*/
			if(recordSet.containsKey("total_recs")){
				setTotalRecs((String)recordSet.get("total_recs"));
			}
/*			if(recordSet.containsKey("practitioner_id")){
				setPractId((String)recordSet.get("practitioner_id"));
			}
*/
			this.mode = (String)recordSet.get( "mode" );
			//this.request = (javax.servlet.http.HttpServletRequest)recordSet.get("HttpRequest") ;
		    //this.response = (javax.servlet.http.HttpServletResponse)recordSet.get("HttpResponse") ;
	}
}

 // To check whether the module has been installed or not, sm_modules_facility.operational_yn(Difft table referred)  if installed it return as 'Y' otherwise 'N'
		public String getFacilityModuleInstallYn(String module_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String module_install_yn	= "N";
		try{

				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
				pstmt.setString(1, module_id);
				pstmt.setString(2, login_facility_id); // pass the facility_id
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )    // Only one record for the module_id
				{
					while(resultSet.next())
					{
						module_install_yn = checkForNull(resultSet.getString( "operational_yn" ),"N")  ;
					}
				}	// if there is no record, then also it should return as 'N'
			}catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return module_install_yn;
	} // End of getFacilityModuleInstallYn


	public String fingurePrintYN()throws Exception{
	   String fingurePrnYN 				= "" ;
    	Connection connection		= null;
    	PreparedStatement pstmt 	= null;
    	ResultSet resultSet 		= null;

    	try {
    		connection = getConnection() ;
    		pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORIZE_FINGURE_PRN_SELECT") ) ;
    		resultSet = pstmt.executeQuery() ;

    		while ( resultSet != null && resultSet.next() ){
    			fingurePrnYN = resultSet.getString( "fing_prn_auth_order" )  ;
    		}
    	} catch ( Exception e )	{

    		e.printStackTrace() ;
    		throw e ;
    	} finally {
    			closeResultSet( resultSet ) ;
    			closeStatement( pstmt ) ;
    			closeConnection(connection);
				
    	}
    	return fingurePrnYN ;
	}


	public Hashtable getPrintDetails(String order_id,String patient_class,String location_type,String location_code) {
		ResultSet resultSet1 		= null;
		ResultSet resultSet2 		= null;
		PreparedStatement pstmt1	= null;
		PreparedStatement pstmt2	= null;
		Connection connection 		= null;
		Hashtable hashtable 		= new Hashtable();
		try {
			connection 					= getConnection();
			//Select order_line_status,order_id,order_line_num,order_type_code,priority from or_order_line where order_id = (?)
			pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_PRINT1") ) ;
			//select 'X' from or_order_status_code where order_status_type='00' and order_status_code = ? <replace with resultSet.getString(1)>
			pstmt2 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CONSENT_ORDER_PRINT2") ) ;

			int i = 0;
			pstmt1.clearParameters();
			pstmt1.setString(1,order_id);
			resultSet1 = pstmt1.executeQuery();
			if (resultSet1 != null) {
				while(resultSet1.next()) {
					pstmt2.clearParameters();
					pstmt2.setString(1,resultSet1.getString("order_line_status"));
					resultSet2 = pstmt1.executeQuery();

					if (resultSet2 != null) {
						while(resultSet2.next()) {
							hashtable.put("order_id"+i,resultSet1.getString("order_id"));
							hashtable.put("order_line_num"+i,resultSet1.getString("order_line_num"));
							hashtable.put("order_type_code"+i,resultSet1.getString("order_type_code"));
							hashtable.put("patient_class"+i,patient_class);
							hashtable.put("priority"+i,resultSet1.getString("priority"));
							hashtable.put("location_type"+i,location_type);
							hashtable.put("location_code"+i,location_code);
							hashtable.put("facility_id"+i,login_facility_id);
							i++;
						}
					}
					closeResultSet( resultSet2 ) ;
				}
			}
			hashtable.put("total_records",""+i);
		} catch (Exception e) {
			e.printStackTrace() ;
		}finally{
			try{
				closeResultSet( resultSet2 ) ;
			closeResultSet( resultSet1) ;
			closeStatement( pstmt2 ) ;
			closeStatement( pstmt1 ) ;
			closeConnection(connection) ;}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		return hashtable;
	}

 
	// A bean is called internally which will call the on line print routine
	/*public void callOnLinePrinting(Hashtable stored_print_values) throws Exception {

		//OnLinePrinting online_print = new OnLinePrinting(request,response);
		OnLinePrinting online_print = new OnLinePrinting(request, response);
		// one parameter is to print the order form , another paramater is to print the consent forms
		online_print.callConsentFormOnlinePrint(stored_print_values); //Pass the Hashtable print_values (Stored in generateUniqueIds() )
	} // End of callOnLinePrinting*/
	
	/*public java.util.Hashtable getPrintValues() {
		return printValues;
	}

	public void setPrintValues(java.util.Hashtable value) {
		printValues = value;
	}
	*/

public void clear() {
			order_type_code = "";
			total_records = "";
 			security_level = "";
	//		persistence_details = null;
		 	super.clear() ;
			clearHash();
}

public void clearHash(){
	consentDetail.clear();
	patientDetail.clear();
	consentFrmId.clear();//added for multi consent 5/4/2007
}
/***
 *Method called before trasaction where validations should take place.
 * @return      HashMap containing the error information.
 * @throws Exception
*/
    public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;
		if(!allValues.containsKey("function_from")){//added for multi consent on 5/4/2007
		String order_id = "";
		String order_line_num = "";//added for multi consent on 5/4/2007
		String valid_operational_yn = "";

		int int_total_records = Integer.parseInt(total_records);
		for(int i=0; i<int_total_records; i++){
			
			if(((String)allValues.get("chk"+i)).equalsIgnoreCase("Y")){
				//order_type_code 		= (String)allValues.get("ord_typ_code"+i);
				order_id				= (String)allValues.get("ord_id"+i);
				order_line_num			= (String)allValues.get("ord_line_num"+i);//added for multi consent on 5/4/2007
				valid_operational_yn	= getOperationalStatus("CONSENT_ORDER", order_id , order_line_num);				
			if(valid_operational_yn.equals("N")){
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", getMessage(language_id, "OR_STATUS_CHANGED","OR") ) ;
				map.put( "invalidCode", ""+i ) ;
				
				break;
			}
			
		}
			}
		}
        return map ;
    }


//For Multiful consent the code is added from here  on  04/05/07
public ArrayList MultiListConsentsHeader(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList multi_consents	= new ArrayList() ;
		String[] records	= null;
		try{
			connection		= getConnection();
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_CATALOG_HEADER") ) ;
				
			pstmt.setString(1, order_id.trim() ) ;
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				records = new String[5];
				records[0] = resultSet.getString( "order_line_num" )  ;
				records[1] = resultSet.getString( "order_catalog_code" )  ;
				records[2] = resultSet.getString( "catalog_synonym" )  ;
				records[3] = checkForNull(resultSet.getString( "num_of_consent_req_bo" ),"0")  ;
				records[4] = checkForNull(resultSet.getString( "num_of_consent_req_br" ),"0")  ;				
				multi_consents.add(records) ;
			}
		}
		 catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return multi_consents;
      }
	 /*********SRR20056-SCF-2009  Id:  3736 *****start***05/06/2008****/

	  public String[] MultiListConsentsLine(String order_id,String order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		
		String[] records = new String[4];
		try{
			connection		= getConnection();
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_CATALOG_LINE") ) ;
			pstmt.setString(1, order_id.trim() ) ;
			pstmt.setString(2, order_line_num.trim() ) ;
			resultSet = pstmt.executeQuery() ;
			
			while ( resultSet != null && resultSet.next() ) {				
				records[0] = resultSet.getString( "order_catalog_code" )  ;
				records[1] = resultSet.getString( "catalog_synonym" )  ;
				records[2] = checkForNull(resultSet.getString( "num_of_consent_req_bo" ),"0")  ;
				records[3] = checkForNull(resultSet.getString( "num_of_consent_req_br" ),"0")  ;
			}
		}
		 catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return records;
      }
	/*********SRR20056-SCF-2009  Id:  3736 *****end***05/06/2008****/

/*for multiple-Fixed consent from list*/
	public ArrayList MultiListConsents(String order_catalog_code,String order_id,String order_line_num, String pract_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList multi_consents	= new ArrayList() ;
		String[] consent_records	= null;
		String key=null;
		String value=null;

		try {
			
			connection		= getConnection();
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_FORM_LINK") ) ;
			//pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SELECT   A.ORDER_CATALOG_CODE ORDER_CATALOG_CODE,A.CONSENT_FORM_ID CONSENT_FORM_ID, A.CONSENT_STAGE CONSENT_STAGE,DFLT_SELECT_YN, ORDER_SEQUNCE, NVL(NUM_OF_CONSENT_REQ_BO,0)NUM_OF_CONSENT_REQ_BO,NVL(NUM_OF_CONSENT_REQ_BR,0) NUM_OF_CONSENT_REQ_BR,CONSENT_FORM_LIST, CONSENT_FORM_LABEL,(SELECT d.CONSENT_STAGE  FROM  OR_ORDER_LINE_CONSENT_DRAFT D WHERE D.ORDER_ID=? AND D.ORDER_LINE_NUM=? AND D.CONSENT_FORM_ID = A.CONSENT_FORM_ID) CONFIRMED_YN, (SELECT CONSENT_REF_ID FROM OR_CONSENT_REF_DTL e WHERE e.order_id = ? AND e.order_line_num =? AND e.form_id = a.consent_form_id AND e.TYPE = 'C' AND ROWNUM <= 1) recorded_yn, C.indexed_yn ELIGIBLE_YN FROM OR_CATALOG_CONSENT_DTL A, OR_ORDER_CATALOG B, OR_CONSENT_FORM C WHERE A.ORDER_CATALOG_CODE = ? AND A.ORDER_CATALOG_CODE = B.ORDER_CATALOG_CODE AND A.CONSENT_FORM_ID = C.CONSENT_FORM_ID ORDER BY CONSENT_STAGE, ORDER_SEQUNCE ") ) ;
			pstmt.setString( 1, language_id ) ;
			pstmt.setString( 2, order_id.trim() ) ;
			pstmt.setString( 3, order_line_num.trim() ) ;
			pstmt.setString( 4, order_id.trim() ) ;
			pstmt.setString( 5, order_line_num.trim() ) ;
			pstmt.setString( 6, order_catalog_code.trim() ) ;
			

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				consent_records = new String[13];
				consent_records[0] = resultSet.getString( "ORDER_CATALOG_CODE" )  ;
				consent_records[1] = resultSet.getString( "CONSENT_FORM_ID" )  ;
				consent_records[2] = resultSet.getString( "CONSENT_FORM_LABEL" )  ;
				consent_records[3] = checkForNull(resultSet.getString( "CONSENT_STAGE" ),"")  ;
				consent_records[4] = checkForNull(resultSet.getString( "DFLT_SELECT_YN" ),"N")  ;
				consent_records[5] = checkForNull(resultSet.getString( "ORDER_SEQUNCE" ),"0" )  ;
				consent_records[6] = checkForNull(resultSet.getString( "CONSENT_FORM_LIST" ),"V" )  ;
				consent_records[7] = checkForNull(resultSet.getString( "NUM_OF_CONSENT_REQ_BO" ),"0");
				consent_records[8] = checkForNull(resultSet.getString( "NUM_OF_CONSENT_REQ_BR" ),"0");
				consent_records[9] = checkForNull(resultSet.getString( "CONFIRMED_YN" ),"N" )  ;
				if(checkForNull(resultSet.getString( "CONFIRMED_YN" ),"" ).equals("")){
					consent_records[9] = "N"   ;
				}else{
					consent_records[9] = "Y"  ;
					consent_records[3] = checkForNull(resultSet.getString( "CONFIRMED_YN" ),"" );
				}
				
				if(checkForNull(resultSet.getString( "RECORDED_YN" ),"" ).equals("")){
					consent_records[10] = "N"   ;
				}else
					consent_records[10] = "Y"  ;
				consent_records[11] = checkForNull(resultSet.getString( "RECORDED_YN" ),"" )  ; //CONSENT_REF_ID
				consent_records[12] = canRecordConsent(checkForNull(resultSet.getString( "ELIGIBLE_YN" ),"N" ),consent_records[1], pract_id)  ; //ELIGIBLE_YN
				key=consent_records[0]+"!!"+consent_records[5];
				value=consent_records[1]+"!!"+consent_records[3]+"!!"+consent_records[4];
				consents_update.put(key,value);
				multi_consents.add(consent_records) ;
				
			}
			consent_records = null;

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		
		return multi_consents;
	}

	public ArrayList MultiListConsentsdtl(String order_catalog_code,String order_id,String order_line_num, String pract_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList multi_consents	= new ArrayList() ;
		String[] consent_records	= null;
		String key=null;
		String value=null;

		try {
			
			connection		= getConnection();
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_FORM_LINK_DTL") ) ;
			//pstmt = connection.prepareStatement("SELECT d.CONSENT_FORM_ID CONSENT_FORM_ID,B.ORDER_CATALOG_CODE ORDER_CATALOG_CODE,D.CONSENT_STAGE CONSENT_STAGE,NVL(e.NUM_OF_CONSENT_REQ_BO,0)NUM_OF_CONSENT_REQ_BO,NVL(e.NUM_OF_CONSENT_REQ_BR,0) NUM_OF_CONSENT_REQ_BR,CONSENT_FORM_LIST,or_get_desc.OR_CONSENT_FORM(d.CONSENT_FORM_ID,?,'1') CONSENT_FORM_LABEL,(SELECT d.CONSENT_STAGE  FROM  OR_ORDER_LINE_CONSENT_DRAFT D WHERE D.ORDER_ID=? AND D.ORDER_LINE_NUM=? and D.CONSENT_FORM_ID = c.CONSENT_FORM_ID) CONFIRMED_YN,(SELECT CONSENT_REF_ID FROM OR_CONSENT_REF_DTL F WHERE F.order_id = E.ORDER_ID AND F.order_line_num =E.order_line_num AND F.form_id =D.consent_form_id AND F.TYPE = 'C' AND ROWNUM <= 1) recorded_yn, C.indexed_yn ELIGIBLE_YN FROM OR_ORDER_CATALOG B,OR_CONSENT_FORM C,OR_ORDER_LINE_CONSENT_DRAFT  D,OR_ORDER_LINE E WHERE E.ORDER_ID	=? AND E.ORDER_LINE_NUM	=? AND D.ORDER_ID	=E.ORDER_ID AND D.ORDER_LINE_NUM	=E.ORDER_LINE_NUM AND D.CONSENT_FORM_ID = c.CONSENT_FORM_ID AND b.order_catalog_code=?") ;
			pstmt.setString( 1, language_id ) ;
			pstmt.setString( 2, order_id.trim() ) ;
			pstmt.setString( 3, order_line_num.trim() ) ;
			pstmt.setString( 4, order_id.trim() ) ;
			pstmt.setString( 5, order_line_num.trim() ) ;
			pstmt.setString( 6, order_catalog_code.trim() ) ;
			

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				consent_records = new String[13];
				consent_records[0] = resultSet.getString( "ORDER_CATALOG_CODE" )  ;
				consent_records[1] = resultSet.getString( "CONSENT_FORM_ID" )  ;
				consent_records[2] = resultSet.getString( "CONSENT_FORM_LABEL" )  ;
				consent_records[3] = checkForNull(resultSet.getString( "CONSENT_STAGE" ),"")  ;
				consent_records[4] = "";//checkForNull(resultSet.getString( "DFLT_SELECT_YN" ),"N")  ;
				consent_records[5] ="";//checkForNull(resultSet.getString( "ORDER_SEQUNCE" ),"0" )  ;
				consent_records[6] = checkForNull(resultSet.getString( "CONSENT_FORM_LIST" ),"V" )  ;
				consent_records[7] = checkForNull(resultSet.getString( "NUM_OF_CONSENT_REQ_BO" ),"0");
				consent_records[8] = checkForNull(resultSet.getString( "NUM_OF_CONSENT_REQ_BR" ),"0");
				consent_records[9] = checkForNull(resultSet.getString( "CONFIRMED_YN" ),"N" )  ;
				if(checkForNull(resultSet.getString( "CONFIRMED_YN" ),"" ).equals("")){
					consent_records[9] = "N"   ;
				}else{
					consent_records[9] = "Y"  ;
					consent_records[3] = checkForNull(resultSet.getString( "CONFIRMED_YN" ),"" );
				}
				
				if(checkForNull(resultSet.getString( "RECORDED_YN" ),"" ).equals("")){
					consent_records[10] = "N"   ;
				}else
					consent_records[10] = "Y"  ;
				consent_records[11] = checkForNull(resultSet.getString( "RECORDED_YN" ),"" )  ; //CONSENT_REF_ID
				consent_records[12] = canRecordConsent(checkForNull(resultSet.getString( "ELIGIBLE_YN" ),"N" ),consent_records[1], pract_id)  ; //ELIGIBLE_YN
				key=consent_records[0]+"!!"+consent_records[5];
				value=consent_records[1]+"!!"+consent_records[3]+"!!"+consent_records[4];
				consents_update.put(key,value);
				multi_consents.add(consent_records) ;				
			}
			consent_records = null;

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
	
		return multi_consents;
	}
	public ArrayList MultiListConsentsForNew(String order_catalog_code,String order_id,String order_line_num, String pract_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList multi_consents	= new ArrayList() ;
		String[] consent_records	= null;
		String key=null;
		String value=null;
		int i=1;
		try{
			connection		= getConnection();
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_FORM_LINK_FOR_NEW") ) ;
			pstmt.setString( 1, language_id ) ;
			pstmt.setString( 2, order_id.trim() ) ;
			pstmt.setString( 3, order_line_num.trim() ) ;
			pstmt.setString( 4, order_id.trim() ) ;
			pstmt.setString( 5, order_line_num.trim() ) ;
			pstmt.setString( 6, language_id) ;
			pstmt.setString( 7, order_id.trim()  ) ;
			pstmt.setString( 8, order_line_num.trim() ) ;
			pstmt.setString( 9, order_catalog_code.trim() ) ;
			pstmt.setString( 10, order_id.trim() ) ;
			pstmt.setString( 11, order_line_num.trim() ) ;
			pstmt.setString( 12, language_id ) ;
			pstmt.setString( 13, order_id.trim() ) ;
			pstmt.setString( 14, order_line_num.trim() ) ;
			pstmt.setString( 15, order_catalog_code.trim() ) ;
			pstmt.setString( 16, order_id.trim() ) ;
			pstmt.setString( 17, order_line_num.trim() ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
			consent_records = new String[11];
			consent_records[0] = checkForNull(order_catalog_code,"");
			consent_records[1] = checkForNull(resultSet.getString( "consent_form_id" ),"")  ;
			consent_records[2] = checkForNull(resultSet.getString( "CONSENT_FORM_LABEL" ),"")  ;
			consent_records[3] = checkForNull(resultSet.getString( "consent_stage" ),"")  ;
			consent_records[4] = checkForNull(resultSet.getString( "DFLT_SELECT_YN" ));
			consent_records[5] = ""+i;
			consent_records[6] = checkForNull(getConsentList(order_catalog_code,connection),"");
			consent_records[7] = checkForNull(resultSet.getString( "NUM_OF_CONSENT_REQ_BO" ),"0");
			consent_records[8] = checkForNull(resultSet.getString( "NUM_OF_CONSENT_REQ_BR" ),"0");
			consent_records[9] = checkForNull(resultSet.getString( "PRSENT_IN_DRAFT_YN" ),"");
			if(checkForNull(resultSet.getString( "RECORD_YN" ),"" ).equals("")){
					consent_records[10] = "N"   ;
				}else
					consent_records[10] = "Y"  ;
			key=consent_records[0]+"!!"+consent_records[5];
			value=consent_records[1]+"!!"+consent_records[3]+"!!"+consent_records[4];
			consents_update.put(key,value);
			multi_consents.add(consent_records) ;
			i++;
			}
		}
		catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return multi_consents;
	}
	/*********SRR20056-SCF-2009  Id:  3736 *****start***05/06/2008****/
		public ArrayList multiConsentDraftValues(String order_catalog_code,String order_id,String order_line_num) throws Exception {
			
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList multi_consents	= new ArrayList() ;
		String[] consent_records	= null;
		String key=null;
		String value=null;
		int i=1;
		try{
			connection		= getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_FORM_DRAFT_VALUES")) ;
			pstmt.setString( 1, language_id ) ;
			pstmt.setString( 2, order_id.trim() ) ;
			pstmt.setString( 3, order_line_num.trim() ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
			consent_records = new String[11];
			consent_records[0] = checkForNull(order_catalog_code,"");
			consent_records[1] = checkForNull(resultSet.getString( "consent_form_id" ),"")  ;
			consent_records[2] = checkForNull(resultSet.getString( "CONSENT_FORM_LABEL" ),"")  ;
			consent_records[3] = checkForNull(resultSet.getString( "consent_stage" ),"")  ;
			consent_records[4] = "Y";
			consent_records[5] = ""+i;
			consent_records[6] = checkForNull(getConsentList(order_catalog_code,connection),"");
			consent_records[7] = checkForNull(resultSet.getString( "NUM_OF_CONSENT_REQ_BO" ),"0");
			consent_records[8] = checkForNull(resultSet.getString( "NUM_OF_CONSENT_REQ_BR" ),"0");
			consent_records[9] = "Y";
			if(checkForNull(resultSet.getString( "RECORD_YN" ),"" ).equals("")){
					consent_records[10] = "N"   ;
				}else
					consent_records[10] = "Y"  ;
			key=consent_records[0]+"!!"+consent_records[5];
			value=consent_records[1]+"!!"+consent_records[3]+"!!"+consent_records[4];
			consents_update.put(key,value);
			multi_consents.add(consent_records) ;
			i++;
			}
		}
		catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return multi_consents;
	}

	/*********SRR20056-SCF-2009  Id:  3736 *****end***05/06/2008****/
/*for Variable consent form list*/
	public String getConsentList(String order_catalog_code,Connection connection) throws Exception
	{
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String Consent_list=null;
		try
		{
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_FORM_LIST") ) ;
			pstmt.setString( 1, order_catalog_code ) ;
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				Consent_list=resultSet.getString( "CONSENT_FORM_LIST" )  ;
			}
		}
		catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		return Consent_list;
	}
	public ArrayList MultiListConsentsNotAssociated(String order_catalog_code,String order_id,String order_line_num, String pract_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList multi_consents_na	= new ArrayList() ;
		String[] consent_records	= null;
		try {
			
			connection		= getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_FORM_NOT_ASSOCIATED_LINK") ) ;
			//pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SELECT   B.ORDER_CATALOG_CODE ORDER_CATALOG_CODE,D.CONSENT_FORM_ID CONSENT_FORM_ID,nvl(D.CONSENT_STAGE,b.consent_stage) CONSENT_STAGE,'Y' DFLT_SELECT_YN,'1' ORDER_SEQUNCE,NVL (NUM_OF_CONSENT_REQ_BO, 0) NUM_OF_CONSENT_REQ_BO,NVL (NUM_OF_CONSENT_REQ_BR, 0) NUM_OF_CONSENT_REQ_BR,CONSENT_FORM_LIST, CONSENT_FORM_LABEL,'Y' CONFIRMED_YN,(SELECT CONSENT_REF_ID FROM OR_CONSENT_REF_DTL E WHERE E.ORDER_ID = ? AND E.ORDER_LINE_NUM = ? AND E.FORM_ID = C.CONSENT_FORM_ID AND E.TYPE = 'C' AND ROWNUM <= 1) RECORDED_YN, C.indexed_yn ELIGIBLE_YN FROM OR_ORDER_CATALOG B, OR_CONSENT_FORM C, OR_ORDER_LINE_CONSENT_DRAFT D WHERE B.ORDER_CATALOG_CODE = ? AND D.ORDER_ID = ? AND D.ORDER_LINE_NUM = ? AND D.CONSENT_FORM_ID = C.CONSENT_FORM_ID ORDER BY CONSENT_STAGE, ORDER_SEQUNCE") ) ;
			pstmt.setString( 1, language_id ) ;
			pstmt.setString( 2, order_id.trim() ) ;
			pstmt.setString( 3, order_line_num.trim() ) ;
			pstmt.setString( 4, order_catalog_code.trim() ) ;
			pstmt.setString( 5, order_id.trim() ) ;
			pstmt.setString( 6, order_line_num.trim() ) ;
			
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				consent_records = new String[13];
				consent_records[0] = resultSet.getString( "ORDER_CATALOG_CODE" )  ;
				consent_records[1] = resultSet.getString( "CONSENT_FORM_ID" )  ;
				consent_records[2] = resultSet.getString( "CONSENT_FORM_LABEL" )  ;
				consent_records[3] = checkForNull(resultSet.getString( "CONSENT_STAGE" ),"")  ;
				consent_records[4] = checkForNull(resultSet.getString( "DFLT_SELECT_YN" ),"")  ;
				consent_records[5] = checkForNull(resultSet.getString( "ORDER_SEQUNCE" ),"0" )  ;
				consent_records[6] = checkForNull(resultSet.getString( "CONSENT_FORM_LIST" ),"V" )  ;
				consent_records[7] = checkForNull(resultSet.getString( "NUM_OF_CONSENT_REQ_BO" ),"0" )  ;
				consent_records[8] = checkForNull(resultSet.getString( "NUM_OF_CONSENT_REQ_BR" ),"0" )  ;
				consent_records[9] = checkForNull(resultSet.getString( "CONFIRMED_YN" ),"N" )  ;
				if(checkForNull(resultSet.getString( "RECORDED_YN" ),"" ).equals("")){
					consent_records[10] = "N"   ;
				}else
					consent_records[10] = "Y"  ;
				//consent_records[10] = checkForNull(resultSet.getString( "RECORDED_YN" ),"N" )  ;
				consent_records[11] = checkForNull(resultSet.getString( "RECORDED_YN" ),"" )  ; //CONSENT_REF_ID
				consent_records[12] = canRecordConsent(checkForNull(resultSet.getString( "ELIGIBLE_YN" ),"N" ),consent_records[1], pract_id )  ; //ELIGIBLE_YN
				
				
				multi_consents_na.add(consent_records) ;
			}
			consent_records = null;

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return multi_consents_na;
	}
/*For single-Fixed*/
	public String[] MultiListDtls(String order_catalog_code, String pract_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String[] consent_list_records	= null;
			consent_list_records = new String[7];
		try {
			connection		= getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_LIST_DTLS") ) ;
			//pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SELECT a.CONSENT_FORM_LIST, NVL(a.NUM_OF_CONSENT_REQ_BO,0)NUM_OF_CONSENT_REQ_BO, NVL(a.NUM_OF_CONSENT_REQ_BR,0) NUM_OF_CONSENT_REQ_BR ,a.CONSENT_REQD_YN,a.CONSENT_FORM_ID CONSENT_FORM_ID,DECODE(a.CONSENT_STAGE,'A','Release','R','Registration') CONSENT_STAGE,b.consent_form_label consent_form_label, b.indexed_yn indexed_yn FROM OR_ORDER_CATALOG A, OR_CONSENT_FORM b  WHERE b.consent_form_id(+) = a.consent_form_id and ORDER_CATALOG_CODE = ? ") ) ;
			pstmt.setString( 1, language_id ) ;
            pstmt.setString( 2, order_catalog_code.trim() ) ;
			

			resultSet = pstmt.executeQuery() ;
		
			while ( resultSet != null && resultSet.next() ) {
				consent_list_records[0] = checkForNull(resultSet.getString( "CONSENT_FORM_LIST" ),"" )  ;
				consent_list_records[1] = checkForNull(resultSet.getString( "NUM_OF_CONSENT_REQ_BO" ),"0" )  ;
				consent_list_records[2] = checkForNull(resultSet.getString( "NUM_OF_CONSENT_REQ_BR" ),"0" )  ;
				consent_list_records[3] = checkForNull(resultSet.getString( "CONSENT_FORM_ID" ),"" )  ;
				consent_list_records[4] = checkForNull(resultSet.getString( "CONSENT_STAGE" ),"" )  ;
				consent_list_records[5] = checkForNull(resultSet.getString( "CONSENT_FORM_LABEL" ),"" )  ;
				consent_list_records[6] = canRecordConsent(checkForNull(resultSet.getString( "INDEXED_YN" ),"N" ),consent_list_records[3], pract_id )  ; //ELIGIBLE_YN
			}
			
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return consent_list_records;
	}

	public String getConsentDetails(String order_id, String order_line_num, String consent_ref_id,String consent_form_id) throws Exception {
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
 		ResultSet resultSet 			= null;
		String consentDetails			= "";
 
		java.sql.Clob	clob_details	= null;
     try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_FORM_RECORDED_CONTENT") ) ;
			pstmt.setString( 1, consent_ref_id);
			pstmt.setString( 2, order_id);
			pstmt.setString( 3, order_line_num);
			pstmt.setString( 4, consent_form_id);

			resultSet = pstmt.executeQuery() ;

			if(resultSet.next()){
				clob_details	=	(java.sql.Clob) resultSet.getClob(1); //FORM_CONTENT
				if(clob_details!=null && clob_details.length() > 0){
					consentDetails = clob_details.getSubString(1,( (int)clob_details.length() ));
				}
			}
	}catch (Exception e) {
            e.printStackTrace();
	} finally {
		clob_details =null ;
		closeResultSet(resultSet);
		closeStatement(pstmt);
		closeConnection(connection);
	}
		return consentDetails;
	}
	public ArrayList LinkExistingConsent(String patient_id, String encounter_id, String facility_id,String consent_form_id,String period_from, String period_to, int start, int end) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCat			= new ArrayList() ;
 		//int encnter_id				= 0;
		try {
			if(period_from==null || period_from.equals(" ")) period_from	= "";
			if(period_to==null || period_to.equals(" ")) period_to	= "";

			/* Thai date validations start 5/7/2007*/
			if (!language_id.equals("en")){
		period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
		period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
			}//5/7/2007
			if(encounter_id == null || encounter_id.equals(""))
				encounter_id = "0";
			
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_LINK_EXISTING_CONSENT")) ;
			pstmt.setString( 1, patient_id);
			pstmt.setLong( 2, Long.parseLong(encounter_id)) ;
			pstmt.setLong( 3, Long.parseLong(encounter_id)) ;
			pstmt.setString( 4, facility_id) ;
			pstmt.setString( 5, consent_form_id) ;
			pstmt.setString( 6, period_from) ;
			pstmt.setString( 7, period_to) ;
					
			resultSet = pstmt.executeQuery() ;

			if(resultSet!=null) {
				if(start > 0)
					for(int i=0;(i<start-1 && resultSet.next());i++);
				//String[] record = null;
				while ( start <= end && resultSet.next()) {
 					String[] record	  = new String[8];
					record[0] = resultSet.getString( "consent_ref_id" )  ;
					record[1] = resultSet.getString( "order_id" )  ;
					record[2] = resultSet.getString( "order_line_num" )  ;
					record[3] = resultSet.getString( "form_id" )  ;
					record[4] = resultSet.getString( "order_catalog_code" )  ;
					record[5] = resultSet.getString( "order_catalog_desc" )  ;
					record[6] = resultSet.getString( "taken_date_time" )  ;
					
					OrderCat.add(record) ;
					start++;
				 }
				// record = null;
				 if (resultSet.next())
				 {
					String[] templist = (String[])OrderCat.get(0);
					templist[7] = ""+(end+7);
					
					OrderCat.set(0,templist);
					//templist = null;
				 }	
			  }
 		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		
		return OrderCat;
	}
	public String canRecordConsent(String indexed_yn,String consent_form_id,String pract_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String perform				= "Y" ;
 		
		try {
			
			if(indexed_yn != null && indexed_yn.equals("Y") && !consent_form_id.equals("")){
				
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_PRACT_PERFORM_CONSENT")) ;
				pstmt.setString( 1, pract_id);
				pstmt.setString( 2, consent_form_id.trim());
				resultSet = pstmt.executeQuery() ;

				if (resultSet != null && resultSet.next()) {
					int count = resultSet.getInt( 1 )  ;    // COUNT
					if (count > 0)
						perform = "Y";
					else
						perform = "N";

				}
			}
			
			 
 		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		
		return perform;
	}

	public ArrayList getConsents(String order_id,String order_line_num,String form_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String[] record				= null;
		ArrayList ConsentDtls		= new ArrayList();

		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_REPRINT_CONSENT_FOR_EXISTING_ORDER") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, order_id);
			pstmt.setString( 3, order_line_num);
			pstmt.setString( 4, form_id);

			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) 
			{
				record	  = new String[5];
				record[0] = resultSet.getString("consent_ref_id");
				record[1] = resultSet.getString("Added_by_id");
				record[2] = resultSet.getString("Added_date");
				record[3] = resultSet.getString("MODIFIED_BY_ID");
				record[4] = resultSet.getString("modified_date");
				ConsentDtls.add(record)  ;
			}
		} catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		} finally 
		{
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}
		return ConsentDtls;
	}

public String getOrderSetDetails(String order_id) throws Exception 
{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String record = "N" ;
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_BILL_DETAILS") ) ;
				pstmt.setString( 1,order_id.trim());
				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) 
				{
					record = resultSet.getString("bill_yn")  ;
				}
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

			}

		return record;
	}


	public String getConsentDescription(String consent_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String description = "" ;
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_CONSENT_DESC") ) ;				
				pstmt.setString( 1,consent_id.trim());
				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) 
				{
					description = resultSet.getString("consent_form_label")  ;
				}
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

			}

		return description;
	}
	//--[IN034904] - Start
	public String getOrderLineNum(String order_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String linenum = "" ;
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( "Select max(order_line_num) orderlin from or_order_line where order_id = ? " ) ;				
				pstmt.setString( 1,order_id.trim());
				resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) 
				{
					linenum = resultSet.getString("orderlin")  ;
				}
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

			}

		return linenum;
	}
	//--[IN034904] - End
	//IN060107 Start
	public int getTimeInterval() throws Exception {
		String selectSql = "";
		int time_interval = 0;
		Connection connection 			= null;
        PreparedStatement pStatement	= null;
        ResultSet resultSet				= null;
		try{
			selectSql = "SELECT NOTE_PRINT_TIME_INTERVAL FROM CA_NOTE_PARAM";
			connection = getConnection();
			pStatement = connection.prepareStatement(selectSql);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()) {
				time_interval			= Integer.parseInt(resultSet.getString("NOTE_PRINT_TIME_INTERVAL") == null ? "0" : (String)resultSet.getString("NOTE_PRINT_TIME_INTERVAL"));
			}
		} catch(Exception ex) {
			System.out.println(" 2924. Exception in ConsentFormat.java " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if(resultSet != null)  resultSet.close();
			if(pStatement != null) pStatement.close();
			if(connection != null) connection.close();
		}
		return time_interval;
	}
	//IN060107 End
}



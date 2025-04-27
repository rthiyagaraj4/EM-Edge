/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //saved on 02.11.2005
package ePH ;

//import java.io.Serializable ;
import java.io.* ;
import java.util.*;
import java.sql.*;
import ePH.Common.* ;
import eCommon.Common.* ;


public class SRRPHDrugUsageByPractBean extends PhAdapter implements Serializable {
	
	protected String billingYN		=	""; 
	public 	ArrayList reimbursementList = null; 
	
	public SRRPHDrugUsageByPractBean() {
		try {
			doCommon() ;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception {
	}

	public void clear() {
		super.clear() ;
	}
	//setters and getters for Billing when billing setup is on.....
	public void setBillingYN(String billingYN) {
		this.billingYN	= billingYN;
	}

	public String getBillingYN(){
		return this.billingYN;
	}

	public void setReimbursementList(ArrayList reimbursementList){
		this.reimbursementList = reimbursementList;
	}
	public ArrayList getReimbursementList() {
		return reimbursementList;
	}


	public String getMednOrList() {
		String  med_or_yn		= "";
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;


		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_MEDN_ORD_STAT_PRACT_SELECT" )) ;

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				if ( resultSet.next() ) {
					med_or_yn	= resultSet.getString( "INSTALL_YN" ) ;
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

		return med_or_yn;
    }
 	/* Over-ridden Adapter methods end here */


public ArrayList getMednFacilityList() {
		ArrayList facilityList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;


		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DRUG_DIAGNOSIS1" )) ;
			pstmt.setString(1,login_by_id);
			pstmt.setString(2,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					facilityList.add( resultSet.getString( "FACILITY_ID" ) ) ;
					facilityList.add( resultSet.getString( "FACILITY_NAME" ) );
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

		return facilityList;
	}
/*   Facility desc returns ends here    */

/*  Getting sysdate & time ,sysdate & time  + 1 and sydate concate with 23:59  */


public ArrayList getMednDateList() {
		ArrayList dateList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;


		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_MEDN_ADMN_DATE_SELECT1" )) ;
			
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					dateList.add( resultSet.getString( "IN_DATE" ) ) ;
					dateList.add( resultSet.getString( "EN_DATE" ) );
					dateList.add( resultSet.getString( "AD_DATE" ) );
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

		return dateList;
	}

public ArrayList getTitle(){

		ArrayList jobList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;


		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DRUG_PRACTITIONER_JOB_TITLE" )) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					jobList.add( resultSet.getString( "PRACT_TYPE" ) ) ;
					jobList.add( resultSet.getString( "DESC_SYSDEF" ) ) ;
					
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

		return jobList;
}
/* public ArrayList getAllBillingGroup()
    {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();
     
        try
        {
            connection = getConnection();
            //preparedstatement = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_REPORT_DISP_LOCATION"));
            pstmt = connection.prepareStatement("Select blng_grp_id,short_desc from bl_blng_grp_lang_vw WHERE LANGUAGE_ID = ? ORDER BY short_desc");
			
	       //pstmt.setString(1,login_facility_id);
		   pstmt.setString(1,getLanguageId());
            HashMap hashmap;
            for(resultset = pstmt.executeQuery();resultset != null && resultset.next(); )
            {
                hashmap = new HashMap();
                hashmap.put("code", CommonAdapter.checkForNull(resultset.getString(1)));
                hashmap.put("desc", CommonAdapter.checkForNull(resultset.getString(2)));
				arraylist.add(hashmap);
			}

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
			arraylist.add(exception.toString());
           
        }
        finally
        {
            try
            {
                closeResultSet(resultset);
                closeStatement(pstmt);
                closeConnection(connection);
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
        return arraylist;
    }*/

	//code added to check  Billing interface on 28/12/09
public String checkforbillinginterface()throws Exception{
	//System.out.println("Inside Billing Interface======>" );
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
		}catch(Exception exception){
			
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
	/*Code starts for the EDLCLASSIFICATIONLIST VALUES */
public ArrayList getEDLClassficationList(){
	//System.out.println("inside bean getEDLClassficationList");
	  Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		//ArrayList ItemclassArraylist =		new ArrayList();
		ArrayList EDLClassArraylist =		new ArrayList();
		
		try {
			connection	 = getConnection() ;
			//pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TERM_SET_SELECT1" )) ;
			//pstmt			 = connection.prepareStatement("SELECT ITEM_CLASS_CODE,SHORT_DESC from MM_ITEM_CLASS_LANG_VW WHERE LANGUAGE_ID=? order by short_desc" ) ;
			pstmt			 = connection.prepareStatement("SELECT edl_code,substr(PATH,3) edl_desc FROM (SELECT description,eff_status,edl_code, LEVEL l_level,SYS_CONNECT_BY_PATH (description, '->') PATH, parent_code FROM (SELECT *      FROM ph_edl_classifications)START WITH parent_code IS NULL CONNECT BY PRIOR edl_code = parent_code) where edl_code NOT IN (SELECT DISTINCT parent_code FROM ph_edl_classifications WHERE parent_code IS NOT NULL) order by edl_desc") ;
			//pstmt.setString(1,getLanguageId());
			resultSet      = pstmt.executeQuery() ;
			while (resultSet.next()) {
				//HashMap rec		=	new HashMap();
				String code,desc;
				code					=	resultSet.getString("EDL_CODE");
				desc					=	resultSet.getString("EDL_DESC");
				EDLClassArraylist.add(code);
				EDLClassArraylist.add(desc);
				//EDLClassArraylist.add(rec);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			//System.out.println("in final");
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		//return ItemclassArraylist;
		return EDLClassArraylist;
	  }  //Code ends for the Itemclasslist

	   public ArrayList getDispLocnList(String facility_id,String disp_locn_type){

		ArrayList dispLocnList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			//String disp_locn_sql = PhRepository.getPhKeyValue("SQL_PH_REPORT_DISP_LOCATION");
			String disp_locn_sql ="SELECT DISP_LOCN_CODE, SHORT_DESC FROM PH_DISP_LOCN_LANG_VW PH_DISP_LOCN WHERE EFF_STATUS='E' and facility_id =NVL(?,facility_id) AND LANGUAGE_ID = ? and disp_locn_type =nvl(?,disp_locn_type) ORDER BY SHORT_DESC";
			connection = getConnection() ;
			pstmt = connection.prepareStatement(disp_locn_sql) ;
			pstmt.setString(1, facility_id);
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,disp_locn_type);

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					dispLocnList.add( resultSet.getString( "disp_locn_code" ) ) ;
					dispLocnList.add( resultSet.getString( "short_desc" ) );
				}
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading DispLocn List from database" ) ;
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
		return dispLocnList;
	}
	public ArrayList getDispLocnList(String facility_id){

		ArrayList dispLocnList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			//String disp_locn_sql = PhRepository.getPhKeyValue("SQL_PH_REPORT_DISP_LOCATION");
			String disp_locn_sql ="SELECT DISP_LOCN_CODE, SHORT_DESC FROM PH_DISP_LOCN_LANG_VW PH_DISP_LOCN WHERE EFF_STATUS='E' and facility_id =NVL(?,facility_id) AND LANGUAGE_ID = ? ORDER BY SHORT_DESC";
			connection = getConnection() ;
			pstmt = connection.prepareStatement(disp_locn_sql) ;
			pstmt.setString(1, facility_id);
			pstmt.setString(2,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					dispLocnList.add( resultSet.getString( "disp_locn_code" ) ) ;
					dispLocnList.add( resultSet.getString( "short_desc" ) );
				}
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading DispLocn List from database" ) ;
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
		return dispLocnList;
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
                  iv_legends.add("IVAD");
                  iv_legends.add(resultSet.getString("iv_drug_fluid_continuous_dir"));
				  iv_legends.add("IVAA");
			      iv_legends.add(resultSet.getString("iv_drug_fluid_continuous_adm"));
				  iv_legends.add("IVID");
				  iv_legends.add(resultSet.getString("IV_DRUG_FLUID_INTERMITTENT_dir"));
				  iv_legends.add("IVIA");
			      iv_legends.add(resultSet.getString("IV_DRUG_FLUID_INTERMITTENT_adm"));
				  iv_legends.add("IVWA");
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

	public ArrayList getEventTypeList(String hypersensitivity){

		ArrayList eventTypeList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			
			String event_type_sql ="Select a.long_desc  ,a.ADV_EVENT_TYPE_CODE from MR_ADV_EVENT_TYPE_LANG_VW a , MR_ADV_EVENT_TYPE_DETAIL b where a.ADV_EVENT_TYPE_CODE=b.ADV_EVENT_TYPE_CODE and language_id = ? and a.eff_status='E' and b.ADV_EVENT_TYPE_IND = ?  ";
			connection = getConnection() ;
			pstmt = connection.prepareStatement(event_type_sql) ;
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,hypersensitivity);

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					eventTypeList.add( resultSet.getString( "ADV_EVENT_TYPE_CODE" ) ) ;
					eventTypeList.add( resultSet.getString( "long_desc" ) );
				}
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading Event types  from database" ) ;
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
		return eventTypeList;
	}
public ArrayList searchReimbursementList(String p_search_by,String p_report_type,String p_bill_date,String p_receipt_date,String p_bill_number,String p_bill_number1,String p_receipt_number,String p_receipt_number1,String p_privilege,String p_payer,String p_patient_id){

		 
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String sqlQry = "";
		int i=0;
		try {
			if (p_search_by.equals("B"))
			{
				//Null cOndition for patien name is checked  in both the query on 12/1/2010 by Archanan Dhal related to incident no. IN0 23829 
				// sqlQry ="SELECT to_char(A.DOC_DATE,'dd/mm/yyyy') DOC_DATE, A.DOC_TYPE_CODE, A.DOC_NUM, null TOKEN,  B.PATIENT_ID ,nvl(DECODE(?,'en',B.PATIENT_NAME,B.PATIENT_NAME_LOC_LANG),PATIENT_NAME)PATIENT_NAME FROM BL_BILL_HDR A,MP_PATIENT B WHERE A.OPERATING_FACILITY_ID = 'HS' AND A.PATIENT_ID =B.PATIENT_ID AND   NVL(a.bill_status,'X') != 'C' AND A.EPISODE_TYPE = ? AND  trunc(DOC_DATE)= nvl(to_date(?,'dd/mm/yyyy'),trunc(DOC_DATE))  AND A.DOC_TYPE_CODE = nvl(?,A.DOC_TYPE_CODE) AND A.DOC_NUM = nvl(?,A.DOC_NUM) AND A.BLNG_GRP_ID = nvl(?,A.BLNG_GRP_ID) AND nvl(a.cust_code,'X') = decode (?,null,'X', a.cust_code) and b.patient_id = nvl(?,b.patient_id) ORDER BY DOC_DATE";

//Modified Query by sandhya regarding incident num:23829-reopen on 10/DEC/2010
				// sqlQry ="SELECT to_char(A.DOC_DATE,'dd/mm/yyyy') DOC_DATE, A.DOC_TYPE_CODE, A.DOC_NUM, null TOKEN,  B.PATIENT_ID ,DECODE(?,'en',B.PATIENT_NAME,nvl(B.PATIENT_NAME_LOC_LANG,B.PATIENT_NAME)) PATIENT_NAME  FROM BL_BILL_HDR A,MP_PATIENT B WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID =B.PATIENT_ID AND   NVL(a.bill_status,'X') != 'C' AND A.EPISODE_TYPE = ? AND  trunc(DOC_DATE)= nvl(to_date(?,'dd/mm/yyyy'),trunc(DOC_DATE))  AND A.DOC_TYPE_CODE = nvl(?,A.DOC_TYPE_CODE) AND A.DOC_NUM = nvl(?,A.DOC_NUM) AND A.BLNG_GRP_ID = nvl(?,A.BLNG_GRP_ID) AND nvl(a.cust_code,'X') = decode (?,null,'X', a.cust_code) and b.patient_id = nvl(?,b.patient_id) ORDER BY DOC_DATE";

//modified for 23829
               sqlQry ="SELECT A.DOC_NUM,to_char(A.DOC_DATE,'dd/mm/yyyy') DOC_DATE, A.DOC_TYPE_CODE,  c.TOKEN_SERIAL_NO TOKEN,B.PATIENT_ID ,DECODE('"+getLanguageId()+"','en',B.PATIENT_NAME,nvl(B.PATIENT_NAME_LOC_LANG,B.PATIENT_NAME)) PATIENT_NAME FROM BL_BILL_HDR A,MP_PATIENT B ,BL_PATIENT_CHARGES_FOLIO C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID =B.PATIENT_ID AND A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID AND a.DOC_NUM = c.bill_doc_num AND a.DOC_TYPE_CODE =c. bill_doc_type_code AND A.PATIENT_ID = c.PATIENT_ID  	 AND c.MODULE_ID='PH' AND   NVL(a.bill_status,'X') != 'C' AND A.EPISODE_TYPE = ? AND  trunc(a.DOC_DATE)= nvl(to_date(?,'dd/mm/yyyy'),trunc(a.DOC_DATE)) AND A.DOC_TYPE_CODE = nvl(?,A.DOC_TYPE_CODE) AND A.DOC_NUM = nvl(?,A.DOC_NUM) AND A.BLNG_GRP_ID = nvl(?,A.BLNG_GRP_ID) AND nvl(a.cust_code,'X') = decode (?,null,'X', a.cust_code) and b.patient_id = nvl(?,b.patient_id) group by to_char(A.DOC_DATE,'dd/mm/yyyy'), A.DOC_TYPE_CODE, A.DOC_NUM, c.TOKEN_SERIAL_NO ,  B.PATIENT_ID, DECODE('"+getLanguageId()+"','en',B.PATIENT_NAME,nvl(B.PATIENT_NAME_LOC_LANG,B.PATIENT_NAME)) ORDER BY DOC_DATE  ";


			}
			else{
			//sqlQry = "SELECT to_char(A.DOC_DATE,'dd/mm/yyyy') DOC_DATE, A.DOC_TYPE_CODE, A.DOC_NUMBER, null TOKEN,  B.PATIENT_ID ,DECODE(?,'en',B.PATIENT_NAME,nvl(B.PATIENT_NAME_LOC_LANG,B.PATIENT_NAME)) PATIENT_NAME  FROM BL_RECEIPT_REFUND_HDR A,MP_PATIENT B WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID =B.PATIENT_ID  AND NVL(A.CANCELLED_IND,'N') = 'N' AND A.EPISODE_TYPE = ? AND  trunc(DOC_DATE)= nvl(to_date(?,'dd/mm/yyyy'),trunc(DOC_DATE))  AND A.DOC_TYPE_CODE = nvl(?,A.DOC_TYPE_CODE) AND A.DOC_NUMBER = nvl(?,A.DOC_NUMBER)  AND NVL(a.customer_code,'X') = DECODE (?,NULL,'X', a.customer_code) and b.patient_id = nvl(?,b.patient_id) ORDER BY DOC_DATE";
			sqlQry = "SELECT TO_CHAR (a.doc_date, 'dd/mm/yyyy') doc_date, a.doc_type_code,a.doc_number, c.token_serial_no token, b.patient_id, DECODE ('"+getLanguageId()+"','en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name FROM bl_receipt_refund_hdr a, mp_patient b,bl_patient_charges_folio c WHERE a.operating_facility_id = ? AND a.patient_id = b.patient_id AND NVL (a.cancelled_ind, 'N') = 'N' AND a.episode_type = ? AND TRUNC (a.doc_date) =NVL (TO_DATE (?, 'dd/mm/yyyy'), TRUNC (a.doc_date)) AND a.doc_type_code = NVL (?,  a.doc_type_code) AND a.doc_number = NVL (?, a.doc_number) AND NVL (a.customer_code, 'X') = DECODE (?, NULL, 'X', a.customer_code)AND b.patient_id = NVL (?, b.patient_id) AND a.operating_facility_id = c.operating_facility_id AND a.BILL_DOC_NUMBER = c.BILL_DOC_NUM AND a.BILL_DOC_TYPE_CODE = c.BILL_DOC_TYPE_CODE  AND a.patient_id = c.patient_id AND c.module_id = 'PH' GROUP BY TO_CHAR (a.doc_date, 'dd/mm/yyyy'),a.doc_type_code,a.doc_number,c.token_serial_no,b.patient_id,DECODE ('"+getLanguageId()+"','en',b.patient_name, NVL (b.patient_name_loc_lang, b.patient_name))ORDER BY doc_date";
			}
			
			connection = getConnection() ;
			pstmt = connection.prepareStatement(sqlQry) ;
			//pstmt.setString(1,getLanguageId());
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,p_report_type);
			
			if (p_search_by.equals("B"))
			{
				pstmt.setString(3,p_bill_date);
				pstmt.setString(4,p_bill_number);
				pstmt.setString(5,p_bill_number1);
				pstmt.setString(6,p_privilege);
				pstmt.setString(7,p_payer);		
				pstmt.setString(8,p_patient_id);
				//pstmt.setString(10,getLanguageId());
				
			}
			else{
				 pstmt.setString(3,p_receipt_date);
				pstmt.setString(4,p_receipt_number);
				pstmt.setString(5,p_receipt_number1);				
				pstmt.setString(6,p_payer);		
				pstmt.setString(7,p_patient_id);
				//pstmt.setString(9,getLanguageId());
				
			}
			
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
					reimbursementList =new ArrayList();
				while ( resultSet.next() ) {				
					HashMap reimbursementMap	 = new HashMap();
					reimbursementMap.put("doc_date",resultSet.getString("DOC_DATE"));
					reimbursementMap.put("doctype_code",resultSet.getString("DOC_TYPE_CODE"));
					if (p_search_by.equals("B"))
					{
						reimbursementMap.put("doc_num",resultSet.getString("DOC_NUM"));

					}
					else{
							reimbursementMap.put("doc_num",resultSet.getString("DOC_NUMBER"));
					}
					
					reimbursementMap.put("token",resultSet.getString("TOKEN") == null ? "" :resultSet.getString("TOKEN"));
					reimbursementMap.put("patient_id",resultSet.getString("PATIENT_ID"));
					reimbursementMap.put("patient_name",resultSet.getString("PATIENT_NAME"));
					reimbursementMap.put("check","N");
					reimbursementList.add(i,reimbursementMap);
					i++;
					
				}
			}

		
		}
		catch ( Exception e ) {
			System.err.println( "Error loading Event types  from database" ) ;
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
		return reimbursementList;
	}
	
}
//Adding patiend-id lookup for the function clinical alert report---

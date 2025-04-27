/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//Saved on 10.05.2012
package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;

public class MedicationPlanReport extends PhAdapter implements Serializable {

public MedicationPlanReport() {
		try {
			doCommon();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void doCommon() throws Exception {
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
			sql=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT");
			//sql="SELECT A.PATIENT_ID,B.PATIENT_NAME,A.ORIG_ORDER_ID,A.ENCOUNTER_ID,A.LOCN_TYPE,A.PRES_PRACTITIONER_ID,TO_CHAR(A.START_DATE,'DD/MM/YYYY') START_DATE,TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') ADDED_DATE, A.ADDED_DATE ORD_DATE, B.NATIONAL_ID_NO,C.ORDER_STATUS,D.PRACTITIONER_NAME,A.PATIENT_CLASS, A.LOCN_CODE , e.SHORT_DESC disp_locn_desc, C.IV_PREP_YN FROM PH_PATIENT_DRUG_PROFILE A,MP_PATIENT B,OR_ORDER C,AM_PRACTITIONER_LANG_VW D,ph_disp_locn_lang_vw e WHERE A.PATIENT_ID = B.PATIENT_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.ORIG_ORDER_ID = C.ORDER_ID AND A.ORIG_ORDER_LINE_NO='1' AND A.ORIG_ORDER_ID = NVL(?,A.ORIG_ORDER_ID) AND A.ADDED_DATE BETWEEN TO_DATE(NVL(?,'01/01/1472'),'DD/MM/RRRR') AND   TO_DATE(NVL(?,'31/12/5000'),'DD/MM/RRRR') + 0.99999 AND A.PATIENT_ID = NVL(?,A.PATIENT_ID) AND A.ENCOUNTER_ID = NVL(?,A.ENCOUNTER_ID) AND A.PRES_PRACTITIONER_ID = NVL(?,A.PRES_PRACTITIONER_ID) AND A.PRES_PRACTITIONER_ID = D.PRACTITIONER_ID  AND A.LOCN_TYPE = NVL(?,A.LOCN_TYPE) AND A.LOCN_CODE = NVL(?,A.LOCN_CODE) AND A.FACILITY_ID=? AND e.FACILITY_ID=A.FACILITY_ID AND e.DISP_LOCN_CODE=c.PERFORMING_DEPTLOC_CODE AND d.LANGUAGE_ID = e.LANGUAGE_ID AND d.LANGUAGE_ID = ?";
			if(order_type.equals("All"))
			{
			pstmt = connection.prepareStatement( sql +" AND (C.IV_PREP_YN IN ('0','1','2','3','4','5','6','7','8','9') OR C.IV_PREP_YN IS NULL) ORDER BY ORD_DATE"+orderby);
			}
			else if(order_type.equals(""))
			{
			pstmt = connection.prepareStatement( sql +" AND C.IV_PREP_YN IS NULL ORDER BY ORD_DATE"+orderby);
			}
			else 
			{
			pstmt = connection.prepareStatement( sql +" AND C.IV_PREP_YN=? ORDER BY ORD_DATE"+orderby);
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
			pstmt.setString(10, getLanguageId());

			if(!(order_type.equals("All")) && !(order_type.equals("")))
			{
    			pstmt.setString(11,order_type);
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

}

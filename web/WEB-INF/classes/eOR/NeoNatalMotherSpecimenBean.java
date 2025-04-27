/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date           	Edit History    	Name        		Rev.Date		Rev.Name		         Description
07/09/2023	  31792	   Ranjith P R		08/09/2023		RAMESH G		ML-MMOH-CRF-1913
----------------------------------------------------------------------------------------------------------------------------------------------------------


----------------------------------------------------------------------------------------------------------------------------------------------------------
*/  
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import eOR.Common.* ;
import webbeans.eCommon.*;
import eCommon.Common.*;

// 31792 starts

public class NeoNatalMotherSpecimenBean extends OrAdapter implements java.io.Serializable {
	
	public ArrayList NeoNatalMotherSpecimenDetails(Properties properties,String p_order_id,String p_order_line_num,String order_category,String p_performing_facility_id,String accession_num,String history_type,String specimen_num) throws Exception	
	{
		System.out.println("---->calling java");//rpr
		Connection connection 		= null;
		java.sql.CallableStatement bloodCstmt 	= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  patientName ="";
		String patient_id="";
		String mother_specimen_num="";
		ArrayList details				= new ArrayList();
		String locale = (String) properties.getProperty("LOCALE");
					try
					{	
						connection				= ConnectionManager.getConnection(properties) ;
						p_order_id 	= (p_order_id == null) ? null:p_order_id;
						
						pstmt = connection.prepareStatement("SELECT   SPECIMEN_NO,PATIENT_ID,MP_GET_DESC.MP_PATIENT(PATIENT_ID,'1') PatientName FROM RL_NEONATE_MOTHER_SPECIMENS WHERE  NN_SPECIMEN_NO = ? AND OPERATING_FACILITY_ID = ? AND NVL (NN_SPECIMEN_NO_YN, 'N') <> 'Y' AND NVL (CANCELLED_YN, 'N') <> 'Y'");
						pstmt.setString(1, specimen_num);
						pstmt.setString(2, p_performing_facility_id);
						
					//	System.out.println("---------specimen_num-------->"+specimen_num);
					//	System.out.println("---------p_performing_facility_id-------->"+p_performing_facility_id);
						resultSet = pstmt.executeQuery() ; 

						while ( resultSet != null && resultSet.next() ) {
							patientName= resultSet.getString("PatientName")==null?"":(String)resultSet.getString("PatientName")  ;
							patient_id= resultSet.getString("PATIENT_ID")  ;
							mother_specimen_num=resultSet.getString("SPECIMEN_NO")  ;
						}
						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;
				
						
						order_category				= (order_category == null) ? null:order_category;
						p_performing_facility_id			= (p_performing_facility_id == null) ? null:p_performing_facility_id;
						accession_num			= (accession_num == null) ? null:accession_num;
						history_type			= (history_type == null) ? null:history_type;
						bloodCstmt	=	connection.prepareCall("{call or_get_neonate_spec_dtls(?,?,?,?,?,?,?)}");	
						
						bloodCstmt.setString (1,p_order_id);
					//	System.out.println("p_order_id---->"+p_order_id+"<----------");//rpr
						bloodCstmt.setString(2,order_category);
					//	System.out.println("p_order_category---->"+order_category+"<----------");//rpr
						bloodCstmt.setString(3,p_performing_facility_id);
						//System.out.println("p_performing_facility_id---->"+p_performing_facility_id+"<----------");//rpr
						bloodCstmt.setString(4,accession_num); 
					//	System.out.println("p_accession_num---->"+accession_num+"<----------");//rpr
						bloodCstmt.setString(5,history_type);
					//	System.out.println("history_type---->"+history_type+"<----------");//rpr
						bloodCstmt.registerOutParameter(6, java.sql.Types.VARCHAR);					
						bloodCstmt.registerOutParameter(7, java.sql.Types.VARCHAR); 
				
						bloodCstmt.execute();
						String bloodGroup=bloodCstmt.getString(6);
						String rhesusCode=bloodCstmt.getString(7);
					//	System.out.println("p_blood_group---->"+bloodGroup);//rpr
						//System.out.println("p_rhesus_code---->"+rhesusCode);//rpr 
						details.add(bloodGroup); 					
						details.add(rhesusCode);		
						//System.out.println("---------------->"+patientName+"<---------------");
						if("".equals(patientName)){
							
							pstmt = connection.prepareStatement("SELECT DECODE (?, 'en',  SHORT_NAME ,  NVL(SHORT_NAME_LOC_LANG,SHORT_NAME )) PatientName FROM RL_PATIENT_MAST WHERE PATIENT_ID=? ");
							pstmt.setString(1, locale);
							pstmt.setString(2, patient_id);
							
							//System.out.println("---------patient_id-------->"+patient_id);
							
							resultSet = pstmt.executeQuery() ; 

							while ( resultSet != null && resultSet.next() ) {
								patientName= resultSet.getString("PatientName")==null?"":(String)resultSet.getString("PatientName")  ;							
							}
							//System.out.println("---------patientName-------->"+patientName);
							closeResultSet( resultSet ) ;
							closeStatement( pstmt ) ;
							
						}
						details.add(patientName);
						details.add(mother_specimen_num);
						details.add(patient_id); 
						
						
				}	
				catch(Exception e){
					e.printStackTrace();		
				}
					finally{
						closeStatement( bloodCstmt ) ;
						ConnectionManager.returnConnection(connection, properties);
						
				}
		return details ;

		}
	
public ArrayList GetMotherAntibodyDetails(Properties properties, String patient_id, String language_id, String p_order_id) throws Exception
	{
	    System.out.println("---->123");
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		//String antibody_code			="";
		ArrayList   resultData = new ArrayList();
		try 
		{
			connection			= ConnectionManager.getConnection() ;
			pstmt = connection.prepareStatement("SELECT a.ANTIBODY_CODE ANTIBODY_CODE, SHORT_DESC SHORT_DESC, LAST_REPORTED_DATE FROM (SELECT A.ANTIBODY_CODE ANTIBODY_CODE,A.PATIENT_ID PATIENT_ID, A.LAST_REPORTED_DATE FROM BT_PATIENT_ANTIBODY A UNION SELECT DISTINCT C.ANTIBODY_CODE ANTIBODY_CODE,B.PATIENT_ID PATIENT_ID, C.LAST_REPORTED_DATE FROM BD_DONOR_MAST_DTLS B, BT_DONOR_ANTIBODY C WHERE B.DONOR_ID = C.DONOR_ID ) a,BT_ANTIBODY_CODE_MAST_LANG_VW b  WHERE a.ANTIBODY_CODE = b.ANTIBODY_CODE AND b.language_id = ? AND PATIENT_ID = ? ORDER BY LAST_REPORTED_DATE DESC");
			/*
			pstmt = connection.prepareStatement("SELECT A.ANTIBODY_CODE ANTIBODY_CODE,A.PATIENT_ID PATIENT_ID,B.SHORT_DESC SHORT_DESC FROM BT_PATIENT_ANTIBODY A ,BT_ANTIBODY_CODE_MAST_LANG_VW B,or_order d, or_order_line e WHERE a.patient_id =? and  b.ANTIBODY_CODE=a.ANTIBODY_CODE and  b.language_id =? and d.patient_id=a.patient_id and d.order_id=e.order_id and e.order_id = ? UNION  SELECT DISTINCT C.ANTIBODY_CODE ANTIBODY_CODE,B.PATIENT_ID PATIENT_ID, A.SHORT_DESC SHORT_DESC FROM BD_DONOR_MAST_DTLS B, BT_DONOR_ANTIBODY C ,BT_ANTIBODY_CODE_MAST_LANG_VW A,or_order d, or_order_line e WHERE B.DONOR_ID = C.DONOR_ID AND B.PATIENT_ID = ? and  A.ANTIBODY_CODE=c.ANTIBODY_CODE and  a.language_id = ? and d.patient_id=b.patient_id and d.order_id=e.order_id and e.order_id = ?");
			pstmt.setString( 1, patient_id);
			System.out.println("patient_id---107--->"+patient_id);//rpr
			pstmt.setString( 2, language_id);
			System.out.println("language_id---109--->"+language_id);//rpr
			pstmt.setString( 3, p_order_id);
			System.out.println("p_order_id---111--->"+p_order_id);//rpr
			pstmt.setString( 4, patient_id);
			System.out.println("patient_id---113--->"+patient_id);//rpr
			pstmt.setString( 5, language_id);
			System.out.println("language_id---115--->"+language_id);//rpr
			pstmt.setString( 6, p_order_id);
			System.out.println("p_order_id---117--->"+p_order_id);//rpr
			*/
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, patient_id);
			
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				HashMap  RecordData = new HashMap();
				
				RecordData.put("ANTIBODY_CODE",resultSet.getString("ANTIBODY_CODE")==null?"":resultSet.getString("ANTIBODY_CODE"));
				System.out.println("---ANTIBODY_CODE----124--->"+resultSet.getString("ANTIBODY_CODE"));
				RecordData.put("SHORT_DESC",resultSet.getString("SHORT_DESC")==null?"":resultSet.getString("SHORT_DESC"));
				RecordData.put("RESULT_DATE",resultSet.getString("LAST_REPORTED_DATE")==null?"":resultSet.getString("LAST_REPORTED_DATE"));
				
				
				resultData.add(RecordData);
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
			ConnectionManager.returnConnection(connection,properties);
		}

		return resultData;	
	}
	}
//31792 ends

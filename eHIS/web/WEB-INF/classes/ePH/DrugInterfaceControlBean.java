/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;

public class DrugInterfaceControlBean extends PhAdapter{
	String drug_db_product_id;
	String drug_db_interface_yn;
	String drug_db_dosecheck_yn;
	String drug_db_duptherapy_yn;
	String drug_db_interact_check_yn;
	String drug_db_contraind_check_yn;
	String drug_db_allergy_check_yn;
	String drug_db_license_yn="N";
	String overlap_period_for_ip; //CRF-20085.1
	String overlap_period_for_op;//CRF-20085.1


	public DrugInterfaceControlBean(){
		drug_db_product_id = "";
		drug_db_interface_yn="";          
		drug_db_dosecheck_yn="";        
		drug_db_duptherapy_yn="";       
		drug_db_interact_check_yn="";  
		drug_db_contraind_check_yn="";
		drug_db_allergy_check_yn="";    
		overlap_period_for_ip = ""; //CRF-20085.1
		overlap_period_for_op = "";//CRF-20085.1
	}

	private void loadChecks( String facility_id){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
        PreparedStatement pstmt_1     = null ;//added for  [IN:060651]
        ResultSet resultSet_1         = null ;//added for  [IN:060651]
		String sql_query			= "";
		String sql_query_1 			= "";//added for  [IN:060651]
		if(facility_id == null )
			facility_id="";
		try{
			connection = getConnection() ;
			//sql_query        = PhRepository.getPhKeyValue("SQL_PH_EXT_PROD_LINK_SELECT13");
			//sql_query        = "SELECT DRUG_DB_INTERFACE_YN, DRUG_DB_DOSECHECK_YN, DRUG_DB_DUPTHERAPY_YN, DRUG_DB_INTERACT_CHECK_YN, DRUG_DB_CONTRAIND_CHECK_YN, DRUG_DB_ALLERGY_CHECK_YN FROM PH_PARAM WHERE MODULE_ID=? AND drug_db_interface_name IS NOT NULL";
			drug_db_license_yn = PhDrugDatabaseInterfaceLicense.getLicense();
//System.err.println("@@@DRUGINTERFACECONTROLBEAN drug_db_license_yn="+drug_db_license_yn);
			if(drug_db_license_yn != null && drug_db_license_yn.equals("Y")){
				sql_query = "SELECT a.drug_db_interface_yn,a.drug_db_product_id, a.drug_db_dosecheck_yn,  a.drug_db_duptherapy_yn, a.drug_db_interact_check_yn, a.drug_db_contraind_check_yn, a.drug_db_allergy_check_yn,OVERLAP_PERIOD_FOR_IP,OVERLAP_PERIOD_FOR_OP FROM ph_facility_param a, ph_param b WHERE a.facility_id=? AND b.drug_db_interface_yn='Y'";
				sql_query_1 = "SELECT a.drug_db_interface_yn,a.drug_db_product_id, a.drug_db_dosecheck_yn,  a.drug_db_duptherapy_yn, a.drug_db_interact_check_yn, a.drug_db_contraind_check_yn, a.drug_db_allergy_check_yn,OVERLAP_PERIOD_FOR_IP,OVERLAP_PERIOD_FOR_OP FROM ph_facility_param a, ph_param b WHERE a.facility_id=? ";//added for  [IN:060651]
				
				pstmt				= connection.prepareStatement(sql_query) ;
				//pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_EXT_PROD_LINK_SELECT14")) ;
				pstmt.setString(1,facility_id);
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null){//added for  [IN:060651]//modified resultSet.next() to resultSet!=null for ML-MMOH-SCF-0469
				while( resultSet.next()){
					drug_db_interface_yn=resultSet.getString("drug_db_interface_yn")==null?"N":resultSet.getString("drug_db_interface_yn");   
					drug_db_product_id=resultSet.getString("drug_db_product_id")==null?"":resultSet.getString("drug_db_product_id");         
					drug_db_dosecheck_yn=resultSet.getString("drug_db_dosecheck_yn")==null?"N":resultSet.getString("drug_db_dosecheck_yn");
					drug_db_duptherapy_yn=resultSet.getString("drug_db_duptherapy_yn")==null?"N":resultSet.getString("drug_db_duptherapy_yn");
					drug_db_interact_check_yn=resultSet.getString("drug_db_interact_check_yn")==null?"N":resultSet.getString("drug_db_interact_check_yn");
					drug_db_contraind_check_yn=resultSet.getString("drug_db_contraind_check_yn")==null?"N":resultSet.getString("drug_db_contraind_check_yn");
					drug_db_allergy_check_yn=resultSet.getString("drug_db_allergy_check_yn")==null?"N":resultSet.getString("drug_db_allergy_check_yn");
					overlap_period_for_ip=resultSet.getString("OVERLAP_PERIOD_FOR_IP")==null?"":resultSet.getString("OVERLAP_PERIOD_FOR_IP"); //CRF-20085.1
					overlap_period_for_op=resultSet.getString("OVERLAP_PERIOD_FOR_OP")==null?"":resultSet.getString("OVERLAP_PERIOD_FOR_OP");//CRF-20085.1
				}
				}else{//added for  [IN:060651]
					pstmt_1				= connection.prepareStatement(sql_query_1) ;
					pstmt_1.setString(1,facility_id);
					resultSet_1			= pstmt_1.executeQuery();
					while(resultSet_1!=null && resultSet_1.next()){
						
						overlap_period_for_ip=resultSet_1.getString("OVERLAP_PERIOD_FOR_IP")==null?"":resultSet_1.getString("OVERLAP_PERIOD_FOR_IP"); //CRF-20085.1
						overlap_period_for_op=resultSet_1.getString("OVERLAP_PERIOD_FOR_OP")==null?"":resultSet_1.getString("OVERLAP_PERIOD_FOR_OP");//CRF-20085.1
					}
				}//added for  [IN:060651]
			}
			else{
				drug_db_product_id = "";
				drug_db_interface_yn="N";          
				drug_db_dosecheck_yn="N";        
				drug_db_duptherapy_yn="N";       
				drug_db_interact_check_yn="N";  
				drug_db_contraind_check_yn="N";
				drug_db_allergy_check_yn="N";    
			}
		}catch(Exception es){
			es.printStackTrace() ;
		}
		finally{
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeResultSet(resultSet_1);//added for  [IN:060651]
				closeStatement(pstmt_1);//added for  [IN:060651]
				closeConnection( connection );
			}
			catch(Exception es){
			es.printStackTrace() ;
			}
		}
	}
	public String getOverlapPeriodForOP(String facility_id){
		if(overlap_period_for_op.equals("")){
			loadChecks(facility_id);
		}
		return overlap_period_for_op;
	} 
	public String getOverlapPeriodForIP(String facility_id){
		if(overlap_period_for_ip.equals("")){
			loadChecks(facility_id);
		}
		return overlap_period_for_ip;
	} 

	public String getDrugDBInterface_yn(String facility_id){

		if(drug_db_interface_yn.equals("")){
			loadChecks(facility_id);
		}
		if(drug_db_interface_yn.equals(""))
			drug_db_interface_yn="N";
		return drug_db_interface_yn;
/*		if(drug_db_interface_yn.equalsIgnoreCase("Y"))
			return true;
		else
			return false;*/
	}      
	
	public String getDrugDBDosecheck_yn(String facility_id){
		if(drug_db_interface_yn.equals("") || (drug_db_dosecheck_yn.equals(""))){
			loadChecks(facility_id);
		}
		if(drug_db_interface_yn.equalsIgnoreCase("Y") && drug_db_dosecheck_yn.equalsIgnoreCase("Y"))
			return drug_db_dosecheck_yn;
		else
			return "N";
	}   
	
	public String getDrugDBDuptherapy_yn(String facility_id){
		if(drug_db_interface_yn.equals("") || (drug_db_duptherapy_yn.equals(""))){
			loadChecks(facility_id);
		}
		if(drug_db_interface_yn.equalsIgnoreCase("Y") && drug_db_duptherapy_yn.equalsIgnoreCase("Y"))
			return drug_db_duptherapy_yn;
		else
			return "N";
	}    
	
	public String getDrugDBInteract_check_yn(String facility_id){
		if(drug_db_interface_yn.equals("") || (drug_db_interact_check_yn.equals(""))){
			loadChecks(facility_id);
		}
		if(drug_db_interface_yn.equalsIgnoreCase("Y") && drug_db_interact_check_yn.equalsIgnoreCase("Y"))
			return drug_db_interact_check_yn;
		else
			return "N";
	}  

	public String getDrugDBContraind_check_yn(String facility_id){
		if(drug_db_interface_yn.equals("") || (drug_db_contraind_check_yn.equals(""))){
			loadChecks(facility_id);
		}
		if(drug_db_interface_yn.equalsIgnoreCase("Y") && drug_db_contraind_check_yn.equalsIgnoreCase("Y"))
			return drug_db_contraind_check_yn;
		else
			return "N";
	}

	public String getDrugDBAllergy_check_yn(String facility_id){
		if(drug_db_interface_yn.equals("") || (drug_db_allergy_check_yn.equals(""))){
			loadChecks(facility_id);
		}
		if(drug_db_interface_yn.equalsIgnoreCase("Y") && drug_db_allergy_check_yn.equalsIgnoreCase("Y"))
			return drug_db_allergy_check_yn;
		else
			return "N";
	}

	public String getDrugDBProductID(String facility_id){
		loadChecks(facility_id);
		if(drug_db_interface_yn.equalsIgnoreCase("Y"))
			return drug_db_product_id;
		else
			return "";
	}

	//Added for SRR20056-SCF-7354
	public String[] drugDBALLChecksYN(String facility_id){
		String[] sDrugDBAllChecks;
		if(drug_db_interface_yn.equals(""))
			loadChecks(facility_id);

		if(drug_db_interface_yn.equalsIgnoreCase("Y"))
			sDrugDBAllChecks = new String[] { drug_db_interface_yn, drug_db_product_id, drug_db_dosecheck_yn, drug_db_duptherapy_yn, drug_db_interact_check_yn,  drug_db_contraind_check_yn, drug_db_allergy_check_yn};
		else 
			sDrugDBAllChecks = null;

		return sDrugDBAllChecks;
	}
	//SRR20056-SCF-7354

	public void clear(){
		drug_db_product_id="";
		drug_db_interface_yn="";          
		drug_db_dosecheck_yn="";        
		drug_db_duptherapy_yn="";       
		drug_db_interact_check_yn="";  
		drug_db_contraind_check_yn="";
		drug_db_allergy_check_yn="";    
	}
}

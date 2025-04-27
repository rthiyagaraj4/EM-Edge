/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //saved on 08/11/2005
/*
	Developed by	: A.S.Raghunath
	Module/Function : Patient Id Display Bean written for Dispense Queue Management(Transaction)
*/

package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.rmi.* ;
import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;

public class PatientIdDisplayBean extends PhAdapter implements Serializable {


	protected String VFCount = "";		// Verification
	protected String ROCount = "";		// Review Orders
	protected String FLCount = "";		// Filling
	protected String ALCount = "";		// Allocation
	protected String RACount = "";		// Review Allocation
	protected String BRCount = "";		// Bill And Receipt
	protected String DLCount = "";		// Delivery


	public PatientIdDisplayBean() {
		try {
			doCommon();
		}
		catch(Exception e) {e.printStackTrace();}
	}

	String debug="";
	/* Over-ridden Adapter methods start here */


	public void clear() {
		super.clear() ;
	}


	// set methods

	public void setVFCount(String VFCount){
		this.VFCount = VFCount;
	}
	public void setROCount(String ROCount){
		this.ROCount = ROCount;
	}
	public void setALCount(String ALCount){
		this.ALCount = ALCount;
	}
	public void setFLCount(String FLCount){
		this.FLCount = FLCount;
	}
	public void setRACount(String RACount){
		this.RACount = RACount;
	}
	public void setBRCount(String BRCount){
		this.BRCount = BRCount;
	}
	public void setDLCount(String DLCount){
		this.DLCount = DLCount;
	}

	// get methods
	public String getVFCount(){
		return VFCount;
	}
	public String getROCount(){
		return ROCount;
	}
	public String getALCount(){
		return ALCount;
	}
	public String getFLCount(){
		return FLCount;
	}
	public String getRACount(){
		return RACount;
	}
	public String getBRCount(){
		return BRCount;
	}
	public String getDLCount(){
		return DLCount;
	}
	public String getDebug(){
		return this.debug;
	}

	private void doCommon() throws Exception {
	}

	/* Over-ridden Adapter methods end here */


	// Method for getting the patient details
	public Hashtable getPatientDetails(String strSQL,ArrayList whereClause,ArrayList legend ,String AllStages,String Dependency,String FillAlloc,String function_id){


		ArrayList arrListStatus =  new ArrayList();


		//If the function id is 'PH_VERIFY_PRESCRIPTIONS'....10,25,50....

		String order_status_type = "";

		order_status_type = getStatusCodes(AllStages,Dependency,FillAlloc,function_id);
		order_status_type = order_status_type.substring(0,order_status_type.length()-1);

		StringTokenizer st_order_status_type = new StringTokenizer(order_status_type,",");
		String strAppend = "(";
		int k=1;
		while (st_order_status_type.hasMoreTokens()){
			String type = (st_order_status_type.nextToken()).trim();
			if (k==1){
				strAppend += " G.ORDER_STATUS_TYPE= '"+type+"' ";
			}else{
				strAppend += " OR G.ORDER_STATUS_TYPE= '"+type+"' ";
			}
			k++;
		}
		strAppend += ")";

		Hashtable hm = new Hashtable();
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String SQLGroupClause		=  "AND "+strAppend+" AND C.ORDER_LINE_STATUS = G.ORDER_STATUS_CODE AND C.ORDER_ID = A.ORDER_ID GROUP BY  A.PRIORITY, A.PATIENT_ID,A.PATIENT_CLASS,D.PATIENT_NAME,A.ENCOUNTER_ID,D.SEX, D.DATE_OF_BIRTH,E.COUNTRY_CODE,E.SHORT_NAME  ORDER BY A.PATIENT_ID,A.PRIORITY DESC";
		try{
			connection = getConnection() ;
			pstmt	   = connection.prepareStatement(PhRepository.getPhKeyValue( strSQL.trim() )+SQLGroupClause) ;
			pstmt.setString(1,AllStages.trim());
			pstmt.setString(2,Dependency.trim());
			int j=3;
			for (int i=0;i< whereClause.size(); i++){
				String param="";
				if(whereClause.get(i)!=null){
					param = (String)whereClause.get(i);
				}
				pstmt.setString(j++,param.trim());
			}
			resultSet = pstmt.executeQuery();
		    int no_of_pres= 0;
			debug = "";
			while(resultSet.next()){
			   String patient_id= resultSet.getString("PATIENT_ID");
			   ArrayList arrlist =new ArrayList();
			   int legendLen = legend.size();
			   for (int i=0;i<legendLen-1 ; i++){
				    String strLegend = ((String)legend.get(i)).trim();
					arrlist.add(resultSet.getString(strLegend));
			   }
		   	   if (hm.containsKey(patient_id)){
					no_of_pres += resultSet.getInt("TOTAL_PRES");
					arrlist.add("U");
			   }else{
				    arrlist.add(resultSet.getString(((String)legend.get(legendLen-1)).trim()));
					no_of_pres = resultSet.getInt("TOTAL_PRES");
			   }

			   arrListStatus.add(resultSet.getString("STATUS"));

			   arrlist.add(no_of_pres+"");
			   hm.put(patient_id,arrlist);
			}
		}catch ( Exception e ) {
                e.printStackTrace() ;
		} finally {
              try{
                   closeResultSet( resultSet ) ;
                   closeStatement( pstmt ) ;
                   closeConnection( connection );
              }catch(Exception es){
			  es.printStackTrace() ;
			  }
        }
		setStatusCounts(arrListStatus);
		return hm;
	}

	public void setStatusCounts(ArrayList arrListStatus){
		int VF=0,RO=0,AL=0,RA=0,FL=0,DL=0,BR=0;
		debug = "";
		debug += arrListStatus.size();
		for (int i=0;i<arrListStatus.size() ;i++ ){
			StringTokenizer st = new StringTokenizer ((String)arrListStatus.get(i),":");
			while (st.hasMoreTokens()){
				String stage = (st.nextToken()).trim();
				if ((stage).equals("VF")){
					VF = VF+1;
				}else if ((stage).equals("RO")){
					RO = RO+1;
				}else if ((stage).equals("AL")){
					AL = AL+1;
				}else if ((stage).equals("RA")){
					RA = RA+1;
				}else if ((stage).equals("BR")){
					BR = BR+1;
				}else if ((stage).equals("DL")){
					DL = DL+1;
				}else if ((stage).equals("FL")){
					FL = FL+1;
				}
			}			
		}
		setVFCount(VF+"");
		setROCount(RO+"");
		setALCount(AL+"");
		setRACount(RA+"");
		setBRCount(BR+"");
		setDLCount(DL+"");
		setFLCount(FL+"");
	}

	/*
		This method is to get the status codes depending on the stages,dependecies and function_id
	*/
	public String getStatusCodes(String AllStages,String Dependency,String FillAlloc,String function_id){
		String status_codes = "";
		StringTokenizer stAllStages		= new StringTokenizer(AllStages ,":");
		StringTokenizer stDependency	= new StringTokenizer(Dependency,":");
		while (stAllStages.hasMoreTokens()){
			String stage = stAllStages.nextToken();
			if (stDependency.hasMoreTokens()){
				String dependency = stDependency.nextToken();
				/*
					VF	-	Verification
					AL	-	Allocation
					FL	-	Filling
					RO	-	Review Orders
					RA	-	Review Allocation
					BR	-	Billing And Receipt
					DL	-	Delivery
				*/

				//Verification
				if (stage.equals("VF") && (dependency.equals("I"))){
					if (!function_id.equals("PH_VERIFY_PRESCRIPTIONS")){
						status_codes += " 35,10,25, ";
					}else{
						status_codes += " 10,25,";
					}
				}else if (stage.equals("VF") && !(dependency.equals("I"))){
					status_codes += getDispStagesBasedOnDependency(dependency,FillAlloc);
				}
				//Allocation
				else if (stage.equals("AL")&& (dependency.equals("I"))){
					if (FillAlloc.equals("F")){
						status_codes += " 30,";
					}else{
						status_codes += " 30,35,";
					}
				}else if (stage.equals("AL")&& !(dependency.equals("I"))){
					if (!function_id.equals("PH_VERIFY_PRESCRIPTIONS")){
						status_codes += getDispStagesBasedOnDependency(dependency,FillAlloc);
					}else{
						status_codes += " 10,25,";
					}
				}
				//Filling
				else if (stage.equals("FL")&& (dependency.equals("I"))){
					if (FillAlloc.equals("F")){
						status_codes += " 10,25,";
					}else{
						status_codes += " 30,36,";
					}
				}else if (stage.equals("FL")&& !(dependency.equals("I"))){
					status_codes += getDispStagesBasedOnDependency(dependency,FillAlloc);
				}
				//Review Orders
				else if (stage.equals("RO")&& (dependency.equals("I"))){
					status_codes += " 50,";
				}else if (stage.equals("RO")&& !(dependency.equals("I"))){
					status_codes += getDispStagesBasedOnDependency(dependency,FillAlloc);
				}
				//Review Allocation
				else if (stage.equals("RA")&& (dependency.equals("I"))){
					status_codes += " 36,";
				}else if (stage.equals("RA")&& !(dependency.equals("I"))){
					status_codes += getDispStagesBasedOnDependency(dependency,FillAlloc);
				}
				//Billing / Receipt
				else if (stage.equals("BR")&&(dependency.equals("I"))){
					status_codes += " 35,36,";
				}else if (stage.equals("BR")&&!(dependency.equals("I"))){
					status_codes += getDispStagesBasedOnDependency(dependency,FillAlloc);
				}
				//Delivery and Independent
				else if (stage.equals("DL")&&(dependency.equals("I"))){
					status_codes += " 38,";
				}else if (stage.equals("DL")&&!(dependency.equals("I"))){
					status_codes += getDispStagesBasedOnDependency(dependency,FillAlloc);
				}
			}
		}
		return status_codes;
	}

	// This method will be called if dispense stage is not independent(i.e., combined...)
	public String getDispStagesBasedOnDependency(String dependency,String FillAlloc){
		StringTokenizer st = new StringTokenizer(dependency,"$");
		String status_codes="";
		while(st.hasMoreTokens()){
			String stage =  st.nextToken();
			//Verification
			if (stage.equals("VF") ){
				status_codes += " 35,10,25,";
			}
			//Allocation
			else if (stage.equals("AL")){
				if (FillAlloc.equals("F")){
					status_codes += " 30,";
				}else{
					status_codes += " 30,35,";
				}
			}
			//Filling
			else if (stage.equals("FL")){
				status_codes += " 30,36,";
			}
			//Review Orders
			else if (stage.equals("RO")){
				status_codes += " 50,";
			}
			//Review Allocation
			else if (stage.equals("RA")){
				status_codes += " 36,";
			}
			//Billing / Receipt
			else if (stage.equals("BR")){
				status_codes += " 35,36";
			}
			//Delivery
			else if (stage.equals("DL")){
				status_codes += " 38,";
			}
		}
		return status_codes;
	}

// Overloaded method for getting the patient details depending on the dispense stage
public Hashtable getPatientDetails(String strSQL,ArrayList whereClause,ArrayList legend, char disp_stage){

		Hashtable hm = new Hashtable();
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String SQLClause			= null;
		String SQLGroupClause		= "  AND C.ORDER_LINE_STATUS = G.ORDER_STATUS_CODE AND A.ORDER_STATUS = G.ORDER_STATUS_CODE AND C.ORDER_ID = A.ORDER_ID GROUP BY A.PATIENT_ID,D.PATIENT_NAME,A.ENCOUNTER_ID,D.SEX, D.DATE_OF_BIRTH,E.COUNTRY_CODE,E.SHORT_NAME ORDER BY A.PATIENT_ID";

		switch(disp_stage){
			case '0':{
				//case:Review Allocation
				//SQLClause = " AND A.ORDER_STATUS = 'AL' AND G.ORDER_STATUS_CODE = A.ORDER_STATUS";
				SQLClause = " AND G.ORDER_STATUS_TYPE = '36' AND A.ORDER_STATUS = G.ORDER_STATUS_CODE";
				break;
			}
			case '1':{
				//case:Review Orders on Hold
				//SQLClause = " AND (A.ORDER_STATUS = 'HD' OR C.ORDER_LINE_STATUS = 'HD') AND G.ORDER_STATUS_CODE = A.ORDER_STATUS";
				SQLClause = " AND (G.ORDER_STATUS_TYPE = '50') AND G.ORDER_STATUS_CODE = A.ORDER_STATUS AND G.ORDER_STATUS_CODE = C.ORDER_LINE_STATUS";
				break;
			}
			case '2':{
				//case:filling
				//SQLClause =" AND A.ORDER_STATUS = (CASE WHEN (J.DISP_FILL_STAGE = 'B' AND J.DISP_VERF_STAGE = 'F') THEN 'VF' WHEN (J.DISP_FILL_STAGE = 'B' AND J.DISP_VERF_STAGE = 'C' AND J.DISP_REGN_REQD_YN ='Y') THEN 'RG' WHEN (J.DISP_FILL_STAGE = 'B' AND J.DISP_VERF_STAGE = 'C' AND J.DISP_REGN_REQD_YN ='N') THEN 'OS' WHEN (J.DISP_FILL_STAGE = 'A' AND J.DISP_CASH_COLL_STAGE = 'X') THEN 'AL' WHEN (J.DISP_FILL_STAGE = 'A' AND J.DISP_CASH_COLL_STAGE = 'C') THEN 'BL' WHEN (J.DISP_FILL_STAGE = 'A' AND J.DISP_CASH_COLL_STAGE = 'A' AND C.BILL_YN = 'N') THEN 'AL' END) AND G.ORDER_STATUS_CODE = A.ORDER_STATUS";
				SQLClause =" AND G.ORDER_STATUS_TYPE = (CASE WHEN (J.DISP_FILL_STAGE = 'B' AND J.DISP_VERF_STAGE = 'F') THEN '30' WHEN (J.DISP_FILL_STAGE = 'B' AND J.DISP_VERF_STAGE = 'C' AND J.DISP_REGN_REQD_YN ='Y') THEN '25' WHEN (J.DISP_FILL_STAGE = 'B' AND J.DISP_VERF_STAGE = 'C' AND J.DISP_REGN_REQD_YN ='N') THEN '10' WHEN (J.DISP_FILL_STAGE = 'A' AND J.DISP_CASH_COLL_STAGE = 'X') THEN '36' WHEN (J.DISP_FILL_STAGE = 'A' AND J.DISP_CASH_COLL_STAGE = 'C') THEN '38' WHEN (J.DISP_FILL_STAGE = 'A' AND J.DISP_CASH_COLL_STAGE = 'A' AND C.BILL_YN = 'N') THEN '36' END) AND A.ORDER_STATUS = G.ORDER_STATUS_CODE";
				break;

			}
			case '3':{
				//case: allocation
				debug += "In ALlocation ";
				//SQLClause = " AND A.ORDER_STATUS = (CASE WHEN (J.DISP_FILL_STAGE = 'X' AND J.DISP_VERF_STAGE = 'B') THEN 'VF' WHEN (J.DISP_FILL_STAGE = 'X' AND J.DISP_VERF_STAGE = 'C' AND J.DISP_REGN_REQD_YN = 'Y') THEN 'RG' WHEN (J.DISP_FILL_STAGE = 'X' AND J.DISP_VERF_STAGE = 'C' AND J.DISP_REGN_REQD_YN = 'N') THEN 'OS' WHEN (J.DISP_FILL_STAGE = 'B' AND (J.DISP_VERF_STAGE = 'F' OR  J.DISP_VERF_STAGE = 'C')) THEN 'IP' WHEN (J.DISP_FILL_STAGE = 'A' AND J.DISP_VERF_STAGE = 'B') THEN 'VF' WHEN (J.DISP_FILL_STAGE = 'A' AND J.DISP_VERF_STAGE = 'C' AND J.DISP_REGN_REQD_YN = 'Y') THEN 'RG' WHEN (J.DISP_FILL_STAGE = 'A' AND J.DISP_VERF_STAGE = 'C' AND J.DISP_REGN_REQD_YN = 'N') THEN 'OS' END) AND G.ORDER_STATUS_CODE = A.ORDER_STATUS";
				SQLClause = " AND G.ORDER_STATUS_TYPE = (CASE WHEN (J.DISP_FILL_STAGE = 'X' AND J.DISP_VERF_STAGE = 'B') THEN '30' WHEN (J.DISP_FILL_STAGE = 'X' AND J.DISP_VERF_STAGE = 'C' AND J.DISP_REGN_REQD_YN = 'Y') THEN '25' WHEN (J.DISP_FILL_STAGE = 'X' AND J.DISP_VERF_STAGE = 'C' AND J.DISP_REGN_REQD_YN = 'N') THEN '10' WHEN (J.DISP_FILL_STAGE = 'B' AND (J.DISP_VERF_STAGE = 'F' OR  J.DISP_VERF_STAGE = 'C')) THEN '35' WHEN (J.DISP_FILL_STAGE = 'A' AND J.DISP_VERF_STAGE = 'B') THEN '30' WHEN (J.DISP_FILL_STAGE = 'A' AND J.DISP_VERF_STAGE = 'C' AND J.DISP_REGN_REQD_YN = 'Y') THEN '25' WHEN (J.DISP_FILL_STAGE = 'A' AND J.DISP_VERF_STAGE = 'C' AND J.DISP_REGN_REQD_YN = 'N') THEN '10' END) AND A.ORDER_STATUS = G.ORDER_STATUS_CODE";
				break;
			}
			case '4':{
				// case:verification
				debug += "In Verification ";
				//SQLClause = " AND A.ORDER_STATUS = (CASE WHEN (J.DISP_REGN_REQD_YN ='Y') THEN 'RG' WHEN (J.DISP_REGN_REQD_YN ='N') THEN 'OS' END) AND G.ORDER_STATUS_CODE = A.ORDER_STATUS";
				 SQLClause = " AND G.ORDER_STATUS_TYPE = (CASE WHEN (J.DISP_REGN_REQD_YN ='Y') THEN '25' WHEN (J.DISP_REGN_REQD_YN ='N') THEN '10' END) AND A.ORDER_STATUS = G.ORDER_STATUS_CODE";
				break;
			}
			case '5':{
				//case:Billing/Receipt
				//SQLClause = " AND A.ORDER_STATUS = 'AL' AND G.ORDER_STATUS_CODE = A.ORDER_STATUS";
				SQLClause = " AND G.ORDER_STATUS_TYPE = '36' AND A.ORDER_STATUS=G.ORDER_STATUS_CODE";
				break;
			}
			case '6':{
				//case:Delivery
				//SQLClause = " AND A.ORDER_STATUS = (CASE WHEN (J.DISP_FILL_STAGE ='B' OR J.DISP_FILL_STAGE ='X') AND J.DISP_CASH_COLL_STAGE = 'X' THEN 'AL' WHEN (J.DISP_FILL_STAGE ='B' OR J.DISP_FILL_STAGE ='X') AND J.DISP_CASH_COLL_STAGE = 'C' THEN 'BL' WHEN (J.DISP_FILL_STAGE ='B' OR J.DISP_FILL_STAGE ='X') AND J.DISP_CASH_COLL_STAGE = 'A' AND C.BILL_YN = 'N' THEN 'AL' WHEN J.DISP_FILL_STAGE ='A' THEN 'IP' END) AND G.ORDER_STATUS_CODE = A.ORDER_STATUS";
				SQLClause = " AND G.ORDER_STATUS_TYPE = (CASE WHEN (J.DISP_FILL_STAGE ='B' OR J.DISP_FILL_STAGE ='X') AND J.DISP_CASH_COLL_STAGE = 'X' THEN '36' WHEN (J.DISP_FILL_STAGE ='B' OR J.DISP_FILL_STAGE ='X') AND J.DISP_CASH_COLL_STAGE = 'C' THEN '38' WHEN (J.DISP_FILL_STAGE ='B' OR J.DISP_FILL_STAGE ='X') AND J.DISP_CASH_COLL_STAGE = 'A' AND C.BILL_YN = 'N' THEN '36' WHEN J.DISP_FILL_STAGE ='A' THEN '35' END) AND G.ORDER_STATUS_CODE = A.ORDER_STATUS";
				break;
			}
		}

		try{
			strSQL = PhRepository.getPhKeyValue(strSQL.trim())+SQLClause+SQLGroupClause;

			debug += strSQL;

			connection = getConnection() ;
			pstmt	   = connection.prepareStatement(strSQL) ;
			for (int i=0;i< whereClause.size(); i++){
				String param="";
				if(whereClause.get(i)!=null){
					param = (String)whereClause.get(i);
				}
				debug += "In WHERE:::"+param.trim();
				pstmt.setString(i+1,param.trim());
			}
			resultSet = pstmt.executeQuery();

			while(resultSet.next()){

			   debug += "inside while...";
			   String patient_id= resultSet.getString("PATIENT_ID");
			   String no_of_pres= resultSet.getString("TOTAL_PRES");
			   ArrayList arrlist =new ArrayList();
			   for (int i=0;i<legend.size() ; i++){
				    debug += "inside for...";
				    String strLegend = ((String)legend.get(i)).trim();
					arrlist.add(resultSet.getString(strLegend));
			   }
			   arrlist.add(no_of_pres);
			   hm.put(patient_id,arrlist);
			}

		}catch ( Exception e ) {
                e.printStackTrace() ;
		} finally {
              try{
                   closeResultSet( resultSet ) ;
                   closeStatement( pstmt ) ;
                   closeConnection( connection );
              }catch(Exception es){
			  es.printStackTrace() ;
			  }
        }
		return hm;
	}
	public ArrayList buildDrugRelatedSQL(String disp_locn_code){
		ArrayList result = new ArrayList();
		String general_drug		= "";
		String narcotic_drug	= "";
		String controlled_drug	= "";
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
		try{
			connection	= getConnection() ;
		    pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT16") ) ;
			pstmt.setString(1,login_by_id);
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3,disp_locn_code.trim());
            resultSet	= pstmt.executeQuery() ;

			if (resultSet.next()){
				general_drug	=	resultSet.getString("DISP_AUTH_REQD_DRUG_YN");
				narcotic_drug	=	resultSet.getString("DISP_NARCOTIC_YN");
				controlled_drug =	resultSet.getString("DISP_CONTROLLED_DRUG_YN");
			}
		}catch(Exception e){
			e.printStackTrace() ;
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

		if (general_drug.equals("Y")){
			result.add("G");
		}
		if (narcotic_drug.equals("Y")){
			result.add("N");
		}
		if (controlled_drug.equals("Y")){
			result.add("C");
		}
		return result;
	}
} //end of class

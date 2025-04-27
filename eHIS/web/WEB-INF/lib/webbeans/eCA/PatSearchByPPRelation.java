/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.eCA;

import java.sql.*;
import java.util.*;

public class PatSearchByPPRelation implements java.io.Serializable {

	ArrayList arrlist = new ArrayList ();

	public PatSearchByPPRelation(){}

	public String setLevelHeader(Connection con,String practId, String facilityId, Hashtable qryStrHash){
		Statement stmt  = null ;
        ResultSet rset  = null ;
		String isError = "";
		String sqlQuery	= "";
		String IPsqlQuery="";
		String OPsqlQuery="";
		try{

			/**Read*/
			String LoctionType  	= (String)qryStrHash.get("LoctionType");
			String RelationshipCode	= (String)qryStrHash.get("RelationshipCode");
			String PatientId   		= (String)qryStrHash.get("PatientId");
			String QueueId   		= (String)qryStrHash.get("QueueId");
			String FromDate	    	= (String)qryStrHash.get("FromDate");
			String ToDate		    = (String)qryStrHash.get("ToDate");
			stmt = con.createStatement ()  ;

            if(arrlist.size()>0)
				arrlist.clear();

					
			//IPsqlQuery = "select LOCN_TYPE,LOCN_CODE,LOCN_SHORT_DESC from ca_pract_by_locn_view o "+
			IPsqlQuery = "select 'I' episode_type,PRACT_RELN_ID,PRACT_RELN_NAME||decode(LIFETIME_OR_ENCNTR,'L','*') PRACT_RELN_NAME from ca_pract_reln O WHERE 1=1 ";
			if (!RelationshipCode.equals("Z"))
			{
				IPsqlQuery+=" AND  PRACT_RELN_ID='"+RelationshipCode+"' ";
				
			}
			IPsqlQuery+=" AND EXISTS (SELECT  1 FROM CA_ENCNTR_PRACT_RELN I WHERE  I.PRACT_RELN_ID= O.PRACT_RELN_ID AND facility_id='"+facilityId+"' "+
			" and I.PRACTITIONER_ID='"+practId+"' AND "+
			" SYSDATE BETWEEN BEGIN_DATE_TIME AND NVL(END_DATE_TIME,SYSDATE)"+
			" AND ROWNUM<2 AND PATIENT_CLASS NOT IN ('OP','EM') ";
			IPsqlQuery += " and ( (TO_DATE(nvl('"+FromDate+"','01/01/1900'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (TO_DATE(nvl('"+ToDate+"','01/01/5999'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (trunc(BEGIN_DATE_TIME) between TO_DATE(nvl('"+FromDate+"','01/01/1900'),'DD/MM/YYYY') and TO_DATE(nvl('"+ToDate+"','01/01/5999'),'DD/MM/YYYY')) )";
			if(!PatientId.equals(""))
			{
				IPsqlQuery+=" and PATIENT_ID='"+PatientId+"' "; 
			}
			if(!QueueId.equals(""))
			{
				IPsqlQuery+=" and PATIENT_ID=(select patient_id from mp_patient where                      ALT_ID1_NO='"+QueueId+ "')";
			}
			IPsqlQuery+=" )";
			OPsqlQuery = "select 'O' episode_type,PRACT_RELN_ID,PRACT_RELN_NAME||decode(LIFETIME_OR_ENCNTR,'L','*') PRACT_RELN_NAME from ca_pract_reln O WHERE 1=1 ";
			if (!RelationshipCode.equals("Z"))
			{
				OPsqlQuery+=" AND  PRACT_RELN_ID='"+RelationshipCode+"' ";
			}
			OPsqlQuery+=" AND EXISTS (SELECT  1 FROM CA_ENCNTR_PRACT_RELN I WHERE  I.PRACT_RELN_ID= O.PRACT_RELN_ID AND facility_id='"+facilityId+"' "+
			" and I.PRACTITIONER_ID='"+practId+"' AND "+
			" SYSDATE BETWEEN BEGIN_DATE_TIME AND NVL(END_DATE_TIME,SYSDATE)"+
			" AND ROWNUM<2 AND PATIENT_CLASS IN ('OP','EM') ";
			OPsqlQuery += " and ( (TO_DATE(nvl('"+FromDate+"','01/01/1900'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (TO_DATE(nvl('"+ToDate+"','01/01/5999'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (trunc(BEGIN_DATE_TIME) between TO_DATE(nvl('"+FromDate+"','01/01/1900'),'DD/MM/YYYY') and TO_DATE(nvl('"+ToDate+"','01/01/5999'),'DD/MM/YYYY')) )";
			if(!PatientId.equals(""))
			{
				OPsqlQuery+=" and PATIENT_ID='"+PatientId+"' "; 
			}
			if(!QueueId.equals(""))
			{
				OPsqlQuery+=" and PATIENT_ID=(select patient_id from mp_patient where                      ALT_ID1_NO='"+QueueId+ "')";
			}
			OPsqlQuery+=" )";
			if(	LoctionType.equals("Z"))
				sqlQuery=IPsqlQuery+" union all "+OPsqlQuery;
			else if (LoctionType.equals("I"))
				sqlQuery=IPsqlQuery;
			else if (LoctionType.equals("O"))
				sqlQuery=OPsqlQuery;

			rset = stmt.executeQuery(sqlQuery);

			if( rset!=null ){

				 while( rset.next()){

					Hashtable hash = new Hashtable () ;

					hash.put ( "LOCN_TYPE"		,( rset.getString ( "episode_type" )		==null ?"" :rset.getString ( "episode_type" )));
					hash.put ( "LOCN_CODE"		,( rset.getString ( "PRACT_RELN_ID" )		==null ?"" :rset.getString ( "PRACT_RELN_ID" )));
					hash.put ( "LOCN_SHORT_DESC",( rset.getString ( "PRACT_RELN_NAME" ) ==null ?"" :rset.getString ( "PRACT_RELN_NAME" )));

					arrlist.add( hash );
				 }
			}
		}
		catch( Exception e ) { isError += e.toString() +"<br>"+ sqlQuery; }
		//added by dhanaraj on 31/10/2003 closing changed to finally block
		finally{
			try{
				if(rset!=null)  rset.close();
				if(stmt!=null)  stmt.close();
			}
			catch ( Exception e ) {}
		}

		//isError = sqlQuery;

        return isError ;
    }//end of setLevelHeader

	public boolean isFirstLevel(){
		boolean isData = false;

		if(arrlist.size()>0)
			isData = true;

		return 	isData;
	}

	public String getFirstLevel(){
		String outpatient	= "N";
		String inpatient	= "N";
		String combinedType ="";
		if(isFirstLevel()){
			for (int i=0; i<arrlist.size(); i++){
		         Hashtable dat = (Hashtable) arrlist.get(i) ;
			     if (dat.get( "LOCN_TYPE" ).equals("O")){
					outpatient	= "Y";
				}else if(dat.get( "LOCN_TYPE" ).equals("I")){
					inpatient	= "Y";
				}
			}
			combinedType = outpatient + inpatient;
		}
		return combinedType;
	}

	public ArrayList getSecondLevel(String patientType){
		ArrayList returnArray = new ArrayList();
		if(arrlist.size()>0){
			for (int i=0; i<arrlist.size(); i++){
		         Hashtable dat = (Hashtable) arrlist.get(i) ;
				 if(patientType.equals("O")){
					if(dat.get( "LOCN_TYPE" ).equals("O")){
						Hashtable opHash	 = new Hashtable();
						opHash.put("LOCN_SHORT_DESC",dat.get( "LOCN_SHORT_DESC" ) );
						opHash.put("LOCN_CODE",dat.get( "LOCN_CODE" ) );
						returnArray.add(opHash);
						}
					}else if(patientType.equals("I")){
						if(dat.get( "LOCN_TYPE" ).equals("I")){
							Hashtable ipHash	 = new Hashtable();
							ipHash.put("LOCN_SHORT_DESC",dat.get( "LOCN_SHORT_DESC" ) );
							ipHash.put("LOCN_CODE",dat.get( "LOCN_CODE" ) );
							returnArray.add(ipHash);
						}
					}
				}//end of for
			}//end of if
		return returnArray;
	}

}//end of class

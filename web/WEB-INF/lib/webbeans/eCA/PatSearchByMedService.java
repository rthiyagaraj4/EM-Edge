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

public class PatSearchByMedService implements java.io.Serializable {

	ArrayList arrlist = new ArrayList ();

	public PatSearchByMedService(){}

	public String setLevelHeader(Connection con,String practId, String facilityId, Hashtable qryStrHash){
		Statement stmt  = null ;
        ResultSet rset  = null ;
		String isError = "";
		String sqlQuery	= "";
		String IPsqlQuery	= "";
		String OPsqlQuery	= "";
		try{

			String LoctionType		  = (String)qryStrHash.get("LoctionType");
			String LoctionCode		  = (String)qryStrHash.get("LoctionCode");
			String ViewList		      = (String)qryStrHash.get("ViewList");
			String NoOfDays		      = (String)qryStrHash.get("NoOfDays");
			String PatientId		  = (String)qryStrHash.get("PatientId");
			String QueueId			  = (String)qryStrHash.get("QueueId");
			String QueueStatus		  = (String)qryStrHash.get("QueueStatus");
			String UnSheduled		  = (String)qryStrHash.get("UnSheduled");
			String PastVisit		  = (String)qryStrHash.get("PastVisit");
			String OPFromDate		  = (String)qryStrHash.get("FromDate1");
			String Discharge		  = (String)qryStrHash.get("Discharge");
			String IPFromDate		  = (String)qryStrHash.get("FromDate2");
			String SortOrder		  = (String)qryStrHash.get("SortOrder");
			String GroByEpisode		  = (String)qryStrHash.get("GroByEpisode");
			String GroupByMedService  = (String)qryStrHash.get("GroupByMedService");
			String CheckedOut		  = (String)qryStrHash.get("checked_out");
			if(QueueStatus.equals("00"))
				QueueStatus="";

			stmt = con.createStatement ()  ;

            if(arrlist.size()>0)
				arrlist.clear();

IPsqlQuery = "select DISTINCT 'I' patient_class, service_code, SERVICE_SHORT_DESC short_desc  "+      
			" from CA_PRACT_BY_SPLTY_LOCN_VIEW o "+
			" where facility_id='"+facilityId+"' "+
			" and practitioner_id='"+practId+"' "+
			" and Locn_type='W' ";
			if (!(LoctionCode.equals("ALL")))
			{
				IPsqlQuery +=" and o.service_code='"+LoctionCode+"' ";
			}
			IPsqlQuery +=" and exists "+
			" ( select 1 from CA_IP_ACTIVE_EPISODE_VW a "+
			" where a.service_code=o.service_code "+
			" and a.facility_id =o.facility_id ";

			if (ViewList.equals("S"))
				IPsqlQuery +=" and a.CUR_PHYSICIAN_ID='"+practId+"' ";

			IPsqlQuery +=" and a.patient_id = nvl('"+PatientId+"',a.patient_id) "+
			" and NVL(a.alt_id1_no,'X') = nvl('"+QueueId+"',NVL(a.alt_id1_no,'X')) ";
			if (ViewList.equals("A")){
				IPsqlQuery += " and ADMISSION_DATE_TIME between trunc(sysdate)-nvl('"+NoOfDays+"',1) and sysdate ";
			}

			IPsqlQuery +=" and (a.discharge_date_time is null ";
			if (!IPFromDate.equals(""))
				IPsqlQuery +=" or trunc(a.discharge_date_time)>= to_date('"+IPFromDate+"','dd/mm/yyyy')) ";
			else
				IPsqlQuery +=" ) ";
			IPsqlQuery +="  and rownum<2	) ";

			OPsqlQuery = "select DISTINCT  'O' patient_class, service_code, SERVICE_SHORT_DESC short_desc  "+       
			" from CA_PRACT_BY_SPLTY_LOCN_VIEW o  "+
			" where facility_id='"+facilityId+"'"+
			" and practitioner_id='"+practId+"' "+
			" and Locn_type='C' ";
			if (!(LoctionCode.equals("ALL")))
			{
				OPsqlQuery +=" and service_code='"+LoctionCode+"' ";
			}
			OPsqlQuery += " and exists "+
			" (	select 1 from CA_OP_EPISODE_VW a "+
			" where a.SERVICE_CODE=o.SERVICE_CODE "+
			" and a.facility_id =o.facility_id ";

			if (ViewList.equals("S"))
				OPsqlQuery +="  and a.PHYSICIAN_ID   ='"+practId+"' ";

			OPsqlQuery += "and a.patient_id = nvl('"+PatientId+"',a.patient_id) "+
			" and NVL(a.alt_id1_no,'X') = nvl('"+QueueId+"',NVL(a.alt_id1_no,'X')) "+
			" and queue_status >= nvl(DISP_IN_CA_QUEUE_AFTER,queue_status) "+
			" and a.queue_status = nvl('"+QueueStatus+"',a.queue_status)  " ;
			if (!(UnSheduled.equals("Y")))
					OPsqlQuery +=" and ACTUAL_PHYSICIAN_ID != '*ALL' " ;

			if(CheckedOut.equals("Y"))
			{
				OPsqlQuery +=" and nvl(visit_episode_status,'01') not in ('08','09') " +
						" and adm_visit_date between ";
			}
			else
			{
				OPsqlQuery +=" and nvl(visit_episode_status,'01') not in ('07','08','09') " +
						" and adm_visit_date between ";
			}
			if (PastVisit.equals("N")||PastVisit.equals(""))
				OPsqlQuery +="	trunc(sysdate) " ;
			else
			    OPsqlQuery += " nvl(to_date('"+OPFromDate+"','dd/mm/yyyy'),trunc(sysdate)) ";

			OPsqlQuery +=" and trunc(sysdate)+1 " +
			" and episode_type='O' and rownum<2)";

			if(	LoctionType.equals("Z"))
				sqlQuery=IPsqlQuery+" union all "+OPsqlQuery;
			else if (LoctionType.equals("I"))
				sqlQuery=IPsqlQuery;
			else if (LoctionType.equals("O"))
				sqlQuery=OPsqlQuery;

	/*
		by Rajan
				sqlQuery="";
				if (!LoctionType.equals("I"))
				{
					OPsqlQuery = "SELECT 'O' patient_class, service_code, short_desc FROM am_service "+
					" WHERE MEDICAL_YN ='Y' AND eff_status!= 'D' ";
					if (!LoctionCode.equals("ALL"))
 					 	OPsqlQuery +=" and   service_code='"+LoctionCode+"' ";
				}
				//if (LoctionType.equals("Z") )
				//	sqlQuery +="   UNION ALL  ";
				if (!LoctionType.equals("O"))
				{
					IPsqlQuery +=
					" SELECT 'I' patient_class, service_code,short_desc FROM am_service "+
									" WHERE MEDICAL_YN ='Y' AND eff_status!='D' ";
					if (!LoctionCode.equals("ALL"))
 					 	IPsqlQuery +=" and   service_code='"+LoctionCode+"' ";
 			
				}


				if(	LoctionType.equals("Z"))
					sqlQuery=IPsqlQuery+" union all "+OPsqlQuery;
				else if (LoctionType.equals("I"))
					sqlQuery=IPsqlQuery;
				else if (LoctionType.equals("O"))
					sqlQuery=OPsqlQuery;

by rajan ends
*/
				sqlQuery += " ORDER BY 3 ";

			rset = stmt.executeQuery(sqlQuery);

			if( rset!=null ){
				 while( rset.next()){
					Hashtable hash = new Hashtable () ;
					hash.put ( "LOCN_TYPE",( rset.getString ( "PATIENT_CLASS" ) ==null ?"" :rset.getString ( "PATIENT_CLASS" )));
					hash.put ( "LOCN_CODE",( rset.getString ( "SERVICE_CODE" ) ==null ?"" :rset.getString ( "SERVICE_CODE" )));
					hash.put ( "LOCN_SHORT_DESC",( rset.getString ( "SHORT_DESC" ) ==null ?"" :rset.getString ( "SHORT_DESC" )));
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

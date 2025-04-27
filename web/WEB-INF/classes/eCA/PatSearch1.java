/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;
import java.sql.*;
import java.util.*;

public class PatSearch1 implements java.io.Serializable 
{
	ArrayList arrlist = new ArrayList ();
	HashSet patClassSet = new HashSet();
	public PatSearch1(){}
	
	public synchronized String setLevelHeader(Connection con,String practId, String facilityId, HashMap qryStrHash, String search_type,String locale)
	{
		PreparedStatement stmt  = null ;        
		//String isError = "";
		StringBuffer isError = new StringBuffer();
		StringBuffer sqlQuery	= new StringBuffer();
		String field1 = "";
		String field2 = "";
		String field3 = "";
		if(search_type.equals("ByLocation"))
		{
			field1 = "PATIENT_CLASS";
			field2 = "LOCN_CODE";
			field3 = "LOCN_SHORT_DESC";

			StringBuffer IPsqlQuery = new StringBuffer();
			StringBuffer OPsqlQuery = new StringBuffer();
			String LoctionType="";
			int count_bound_vars = 0;
			try
			{
				LoctionType		= (String)qryStrHash.get("LoctionType");
				String LoctionCode 		= (String)qryStrHash.get("LoctionCode"); 
				String ViewList   			= (String)qryStrHash.get("ViewList");
				String adm_fromdate = (String)qryStrHash.get("adm_fromdate");
				String adm_todate		= (String)qryStrHash.get("adm_todate");
				String PatientId   			= (String)qryStrHash.get("PatientId");
				String QueueId   			= (String)qryStrHash.get("QueueId");
				String nationID				= (String)qryStrHash.get("nationID");
				String QueueStatus   	= (String)qryStrHash.get("QueueStatus");
				if (QueueStatus.equals("~~"))
				{
					QueueStatus = "";
				} 
				QueueStatus=QueueStatus.replace('~','\'');
				String UnSheduled   	= (String)qryStrHash.get("UnSheduled");
				String PastVisit   			= (String)qryStrHash.get("PastVisit");
				String OPFromDate	   	= (String)qryStrHash.get("FromDate1");
				String OPToDate	   		= (String)qryStrHash.get("ToDate1");
				String Discharge			= (String)qryStrHash.get("Discharge");
				String IPFromDate		= (String)qryStrHash.get("FromDate2");
				String IPToDate			= (String)qryStrHash.get("ToDate2");
				String CheckedOut		= (String)qryStrHash.get("checked_out");
//				qryStrHash.clear();
	//			stmt = con.createStatement ();
				if(arrlist.size()>0)	
					arrlist.clear();
				if(patClassSet.size()>0)	
					patClassSet.clear();	
				IPsqlQuery.append("select patient_class ,LOCN_CODE,IP_GET_DESC.IP_NURSING_UNIT(?,locn_code,?,'1')  LOCN_SHORT_DESC from ca_pract_by_locn_view o where facility_id=? and practitioner_id=? and Locn_type='W' ");


				if (LoctionType.equals("IP") || LoctionType.equals("DC"))
				{
					IPsqlQuery.append(" AND PATIENT_CLASS=? ");
					if (!LoctionCode.equals("*ALL"))
						IPsqlQuery.append(" AND LOCN_CODE=? ");
									
				}
				IPsqlQuery.append(" AND EXISTS  ( SELECT 1 FROM PR_ENCOUNTER A  WHERE A.ASSIGN_CARE_LOCN_CODE=O.LOCN_CODE  AND A.FACILITY_ID =O.FACILITY_ID AND A.PATIENT_CLASS =O.PATIENT_CLASS ");			
				if (!nationID.equals(""))
					IPsqlQuery.append("  AND A.PATIENT_ID IN (SELECT PATIENT_ID FROM MP_PATIENT WHERE NATIONAL_ID_NO   =? ) ");	

				if (ViewList.equals("S"))
					IPsqlQuery.append(" AND A.ATTEND_PRACTITIONER_ID=? ");
				if (!PatientId.equals(""))
				{
					IPsqlQuery.append(" AND A.PATIENT_ID=? ");
				}
				 if (!QueueId.equals(""))
				 {
					 IPsqlQuery.append(" AND A.PATIENT_ID IN (SELECT PATIENT_ID FROM MP_PATIENT WHERE ALT_ID1_NO   =? )");
				 }
				 if (!adm_fromdate.equals(""))
					IPsqlQuery.append(" AND A.VISIT_ADM_DATE_TIME  >= TO_DATE(?,'DD/MM/YYYY') ");				
				if (!adm_todate.equals(""))
					IPsqlQuery.append(" AND A.VISIT_ADM_DATE_TIME  <= TO_DATE(?,'DD/MM/YYYY')+.9999 ");

				IPsqlQuery.append(" AND (A.ADT_STATUS IN ('01','02') ");
				if (Discharge.equals("Y"))
				{
					IPsqlQuery.append(" OR ( A.ADT_STATUS ='08'   ");
					if (!IPFromDate.equals(""))
						IPsqlQuery.append(" AND  A.DISCHARGE_DATE_TIME >= TO_DATE(?,'DD/MM/YYYY') ");
					if (!IPToDate.equals(""))
						IPsqlQuery.append(" AND A.DISCHARGE_DATE_TIME <= TO_DATE(?,'DD/MM/YYYY')+.9999 ");	
					IPsqlQuery.append("  )");
				}			
				IPsqlQuery.append("   )	) ");


	//OutPatient Query
					OPsqlQuery.append("select patient_class , LOCN_CODE,OP_GET_DESC.OP_CLINIC(?,locn_code,?,'1') LOCN_SHORT_DESC from ca_pract_by_locn_view o  where facility_id=? and practitioner_id=?  and Locn_type='C' ");
				if (LoctionType.equals("OP")||LoctionType.equals("EM"))
				{
					OPsqlQuery.append(" AND PATIENT_CLASS=? " );
					if (!LoctionCode.equals("*ALL"))
						OPsqlQuery.append(" AND LOCN_CODE=? ");
				}
				OPsqlQuery.append(" AND EXISTS  (	SELECT 1 FROM CA_OP_EPISODE_VW A  WHERE A.LOCN_CODE=O.LOCN_CODE  AND A.FACILITY_ID =O.FACILITY_ID  AND A.PATIENT_CLASS =O.PATIENT_CLASS ");
				if (!nationID.equals(""))
					OPsqlQuery.append("  and a.NATIONAL_ID_NO   =? ");	 	
				if (ViewList.equals("S"))
					OPsqlQuery.append("  and a.PHYSICIAN_ID   =? ");

				if (!PatientId.equals(""))
				{
					OPsqlQuery.append(" AND A.PATIENT_ID=? ");
				}
							
				if (!QueueId.equals(""))
				 {
					 OPsqlQuery.append(" AND A.PATIENT_ID IN (SELECT PATIENT_ID FROM MP_PATIENT WHERE ALT_ID1_NO   =? )");
				 }  
				OPsqlQuery.append(" AND A.QUEUE_STATUS >= NVL(DISP_IN_CA_QUEUE_AFTER, QUEUE_STATUS) ");
				if (QueueStatus.equals("")) 	
					OPsqlQuery.append(" AND A.QUEUE_STATUS IN (NULL)  ") ;
				else	
					OPsqlQuery.append(" AND A.QUEUE_STATUS IN (" + QueueStatus + ")  " );
				if(!(UnSheduled.equals("Y")))
					OPsqlQuery.append(" AND A.ACTUAL_PHYSICIAN_ID != '*ALL'  "); 
				else if(UnSheduled.equals("Y")) 
					OPsqlQuery.append(" AND 'Y' = DECODE(NVL(A.ACTUAL_PHYSICIAN_ID, '*ALL'), '*ALL', CA_GET_UNASSIGN_LOCN_APPL(A.FACILITY_ID, A.UNASSIGN_PATIENT_YN,?, A.LOCN_TYPE, A.LOCN_CODE,A.PATIENT_CLASS),'Y')  ");

				if(CheckedOut.equals("Y"))
					OPsqlQuery.append(" AND VISIT_EPISODE_STATUS IN ('00','01','02','03','04','05','06','07') ");
				else
					OPsqlQuery.append(" AND VISIT_EPISODE_STATUS IN ('00','01','02','03','04','05','06') ");

				if (PastVisit.equals("N")||PastVisit.equals(""))
					OPsqlQuery.append("	AND ADM_VISIT_DATE BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE)+1 ") ;
				else
				{
					if (!OPFromDate.equals(""))
						OPsqlQuery.append(" AND ADM_VISIT_DATE >= TO_DATE(?,'DD/MM/YYYY') ");
					else
						OPsqlQuery.append(" AND ADM_VISIT_DATE >= TRUNC(SYSDATE) ");
					if (!OPToDate.equals(""))
						OPsqlQuery.append( " AND ADM_VISIT_DATE <= TO_DATE(?,'DD/MM/YYYY')+.9999 ");
				}
				OPsqlQuery.append("  )  ");

				if(	LoctionType.equals("Z"))
					sqlQuery.append(IPsqlQuery.toString() + " UNION ALL " + OPsqlQuery.toString()+" ORDER BY 3 ");
				else if (LoctionType.equals("IP")||LoctionType.equals("DC"))
					sqlQuery.append(IPsqlQuery.toString()+" ORDER BY 3 ");
				else if (LoctionType.equals("OP")||LoctionType.equals("EM"))
					sqlQuery.append(OPsqlQuery.toString()+" ORDER BY 3 ");

				if( stmt != null) stmt.close();

				stmt = con.prepareStatement(sqlQuery.toString());


				if ( LoctionType.equals("IP")||LoctionType.equals("DC")||LoctionType.equals("Z")  )
				{
					//stmt.setString(++count_bound_vars, facilityId);
					//stmt.setString(++count_bound_vars, locale);
					stmt.setString(++count_bound_vars, facilityId);
					stmt.setString(++count_bound_vars, locale);

					stmt.setString(++count_bound_vars, facilityId);

					stmt.setString(++count_bound_vars, practId);			

					if (LoctionType.equals("IP") || LoctionType.equals("DC"))
					{
						stmt.setString(++count_bound_vars, LoctionType);	

						if (!LoctionCode.equals("*ALL"))
						{
							stmt.setString(++count_bound_vars, LoctionCode);				

						}
					}			
					if (!nationID.equals(""))
					{
						stmt.setString(++count_bound_vars, nationID);

					}

					if (ViewList.equals("S"))
					{
						stmt.setString(++count_bound_vars, practId);

					}
					if (!PatientId.equals(""))
					{
						stmt.setString(++count_bound_vars, PatientId);
					}

					if (!QueueId.equals(""))
		    		 {
						stmt.setString(++count_bound_vars, QueueId);			
					 }

					if (!adm_fromdate.equals(""))
					{
						stmt.setString(++count_bound_vars, adm_fromdate);			

					}
					if (!adm_todate.equals(""))
					{
						stmt.setString(++count_bound_vars, adm_todate);

					}
					if (Discharge.equals("Y"))
					{
					
						if (!IPFromDate.equals(""))
						{
							stmt.setString(++count_bound_vars, IPFromDate);

						}
						if (!IPToDate.equals(""))
						{
							stmt.setString(++count_bound_vars, IPToDate);

						}
					}	
				}
				//OutPatient Query

				if ( LoctionType.equals("OP")||LoctionType.equals("EM")||LoctionType.equals("Z"))
				{
					//stmt.setString(++count_bound_vars, facilityId);
					//stmt.setString(++count_bound_vars, locale);
					stmt.setString(++count_bound_vars, facilityId);
					stmt.setString(++count_bound_vars, locale);
					stmt.setString(++count_bound_vars, facilityId);

					stmt.setString(++count_bound_vars, practId);


					if (LoctionType.equals("OP")||LoctionType.equals("EM"))
					{
						stmt.setString(++count_bound_vars, LoctionType);

						if (!LoctionCode.equals("*ALL"))
						{
							stmt.setString(++count_bound_vars, LoctionCode);

						}
					}
					if (!nationID.equals(""))
					{
						stmt.setString(++count_bound_vars, nationID);

					}
					if (ViewList.equals("S"))
					{
						stmt.setString(++count_bound_vars, practId);

					}
					if (!PatientId.equals(""))
					{
						stmt.setString(++count_bound_vars, PatientId);
					}

					if (!QueueId.equals(""))
	  			    {
						stmt.setString(++count_bound_vars, QueueId);
					}
				
					if(UnSheduled.equals("Y")) 
						stmt.setString(++count_bound_vars, practId);
					
					if (PastVisit.equals("Y"))
					{
						if (!OPFromDate.equals(""))
							stmt.setString(++count_bound_vars, OPFromDate);					
						if (!OPToDate.equals(""))
							stmt.setString(++count_bound_vars, OPToDate);					
					}
				}
			}
			catch( Exception e ) 
			{
				isError.append(e.toString() +"<br>"+ sqlQuery.toString()); 
				e.printStackTrace();
			}
		}
		else if(search_type.equals("ByPPRelation"))
		{			
			field1 = "PATIENT_CLASS";
			field2 = "PRACT_RELN_ID";
			field3 = "PRACT_RELN_NAME";

			StringBuffer IPsqlQuery = new StringBuffer();  // for IPPatient
			StringBuffer OPsqlQuery = new StringBuffer();  //for OutPatient
			StringBuffer IPsqlQuery1 = new StringBuffer(); // for DayCare
			StringBuffer OPsqlQuery1 = new StringBuffer();  // for Emergency
			int count_bound_vars = 0;

			try
			{
				String LoctionType  	= (String)qryStrHash.get("LoctionType");
				String RelationshipCode	= (String)qryStrHash.get("RelationshipCode");
				String PatientId   		= (String)qryStrHash.get("PatientId");
				String QueueId   		= (String)qryStrHash.get("QueueId");
				String FromDate	    	= (String)qryStrHash.get("FromDate");
				String ToDate		    = (String)qryStrHash.get("ToDate");
				
				if(arrlist.size()>0)
					arrlist.clear();
				if(patClassSet.size()>0)	
					patClassSet.clear();
				IPsqlQuery.append("select 'IP' PATIENT_CLASS,PRACT_RELN_ID,CA_GET_DESC.CA_PRACT_RELN(o.pract_reln_id,?,'1')||decode(LIFETIME_OR_ENCNTR,'L','*') PRACT_RELN_NAME from ca_pract_reln O WHERE  ");
				IPsqlQuery.append("  EXISTS (SELECT  1 FROM CA_ENCNTR_PRACT_RELN I WHERE  I.PRACT_RELN_ID= O.PRACT_RELN_ID AND facility_id=?  and I.PRACTITIONER_ID=? AND  SYSDATE BETWEEN BEGIN_DATE_TIME AND NVL(END_DATE_TIME,SYSDATE) AND PATIENT_CLASS ='IP' ");


				IPsqlQuery.append(" and ( (TO_DATE(nvl(?,'01/01/1900'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (TO_DATE(nvl(?,'01/01/5999'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (trunc(BEGIN_DATE_TIME) between TO_DATE(nvl(?,'01/01/1900'),'DD/MM/YYYY') and TO_DATE(nvl(?,'01/01/5999'),'DD/MM/YYYY')) )");
				if(!PatientId.equals(""))
					IPsqlQuery.append(" AND PATIENT_ID=? "); 
				if(!QueueId.equals(""))
					IPsqlQuery.append(" aND PATIENT_ID=(SELECT PATIENT_ID FROM MP_PATIENT WHERE ALT_ID1_NO=?)");
				IPsqlQuery.append(" )");
				if (!RelationshipCode.equals("ALL"))
					IPsqlQuery.append(" AND  PRACT_RELN_ID=? ");

				// IPsqlQuery for DC (Day Care) 
				IPsqlQuery1.append("select 'DC' PATIENT_CLASS,PRACT_RELN_ID,CA_GET_DESC.CA_PRACT_RELN(o.pract_reln_id,?,'1')||decode(LIFETIME_OR_ENCNTR,'L','*') PRACT_RELN_NAME from ca_pract_reln O WHERE ");
				IPsqlQuery1.append(" EXISTS (SELECT  1 FROM CA_ENCNTR_PRACT_RELN I WHERE  I.PRACT_RELN_ID= O.PRACT_RELN_ID AND FACILITY_ID=?  AND I.PRACTITIONER_ID=? AND  SYSDATE BETWEEN BEGIN_DATE_TIME AND NVL(END_DATE_TIME,SYSDATE) AND PATIENT_CLASS ='DC' ");

				IPsqlQuery1.append(" AND ( (TO_DATE(NVL(?,'01/01/1900'),'DD/MM/YYYY') BETWEEN TRUNC(BEGIN_DATE_TIME) AND TRUNC(END_DATE_TIME)) OR (TO_DATE(NVL(?,'01/01/5999'),'DD/MM/YYYY') BETWEEN TRUNC(BEGIN_DATE_TIME) AND TRUNC(END_DATE_TIME)) OR (TRUNC(BEGIN_DATE_TIME) BETWEEN TO_DATE(NVL(?,'01/01/1900'),'DD/MM/YYYY') AND TO_DATE(NVL(?,'01/01/5999'),'DD/MM/YYYY')) )");
				if(!PatientId.equals(""))
					IPsqlQuery1.append(" AND PATIENT_ID=? "); 
				if(!QueueId.equals(""))
					IPsqlQuery1.append(" AND PATIENT_ID=(SELECT PATIENT_ID FROM MP_PATIENT WHERE ALT_ID1_NO=?)");
				IPsqlQuery1.append(" )");
				if (!RelationshipCode.equals("ALL"))
					IPsqlQuery1.append(" AND  PRACT_RELN_ID=? ");

				// OPsqlquery for OP (OutPatient)
				OPsqlQuery.append("SELECT 'OP' PATIENT_CLASS,PRACT_RELN_ID,CA_GET_DESC.CA_PRACT_RELN(o.pract_reln_id,?,'1')||DECODE(LIFETIME_OR_ENCNTR,'L','*') PRACT_RELN_NAME FROM CA_PRACT_RELN O WHERE ");
						
				OPsqlQuery.append(" EXISTS (SELECT  1 FROM CA_ENCNTR_PRACT_RELN I WHERE  I.PRACT_RELN_ID= O.PRACT_RELN_ID AND FACILITY_ID=? AND I.PRACTITIONER_ID=? AND  SYSDATE BETWEEN BEGIN_DATE_TIME AND NVL(END_DATE_TIME,SYSDATE)  AND PATIENT_CLASS='OP' ");

				OPsqlQuery.append(" AND ( (TO_DATE(NVL(?,'01/01/1900'),'DD/MM/YYYY') BETWEEN TRUNC(BEGIN_DATE_TIME) AND TRUNC(END_DATE_TIME)) OR (TO_DATE(NVL(?,'01/01/5999'),'DD/MM/YYYY') BETWEEN TRUNC(BEGIN_DATE_TIME) AND TRUNC(END_DATE_TIME)) OR (TRUNC(BEGIN_DATE_TIME) BETWEEN TO_DATE(NVL(?,'01/01/1900'),'DD/MM/YYYY') AND TO_DATE(NVL(?,'01/01/5999'),'DD/MM/YYYY')) )");
				if(!PatientId.equals(""))
					OPsqlQuery.append(" AND PATIENT_ID=? ");
				if(!QueueId.equals(""))
					OPsqlQuery.append(" AND PATIENT_ID=(SELECT PATIENT_ID FROM MP_PATIENT WHERE ALT_ID1_NO=?) ");
				OPsqlQuery.append(" )");
				if (!RelationshipCode.equals("ALL"))
					OPsqlQuery.append(" AND  PRACT_RELN_ID=? ");
				// OPsqlquery for EM (Emergency)
				OPsqlQuery1.append("SELECT 'EM' PATIENT_CLASS,PRACT_RELN_ID,CA_GET_DESC.CA_PRACT_RELN(o.pract_reln_id,?,'1')||DECODE(LIFETIME_OR_ENCNTR,'L','*') PRACT_RELN_NAME FROM CA_PRACT_RELN O WHERE ");

				OPsqlQuery1.append(" EXISTS (SELECT  1 FROM CA_ENCNTR_PRACT_RELN I WHERE  I.PRACT_RELN_ID= O.PRACT_RELN_ID AND facility_id=?  and I.PRACTITIONER_ID=? AND  SYSDATE BETWEEN BEGIN_DATE_TIME AND NVL(END_DATE_TIME,SYSDATE) AND PATIENT_CLASS ='EM' ");

				OPsqlQuery1.append(" AND ( (TO_DATE(NVL(?,'01/01/1900'),'DD/MM/YYYY') BETWEEN TRUNC(BEGIN_DATE_TIME) AND TRUNC(END_DATE_TIME)) OR (TO_DATE(NVL(?,'01/01/5999'),'DD/MM/YYYY') BETWEEN TRUNC(BEGIN_DATE_TIME) AND TRUNC(END_DATE_TIME)) OR (TRUNC(BEGIN_DATE_TIME) BETWEEN TO_DATE(NVL(?,'01/01/1900'),'DD/MM/YYYY') AND TO_DATE(NVL(?,'01/01/5999'),'DD/MM/YYYY')) )");

				if(!PatientId.equals(""))
					OPsqlQuery1.append(" AND PATIENT_ID=? "); 
				if(!QueueId.equals(""))
					OPsqlQuery1.append(" AND PATIENT_ID=(SELECT PATIENT_ID FROM MP_PATIENT WHERE ALT_ID1_NO=?)");
				OPsqlQuery1.append(" )");
				if (!RelationshipCode.equals("ALL"))
					OPsqlQuery1.append(" AND  PRACT_RELN_ID=? ");

				if(	LoctionType.equals("Z"))
					sqlQuery.append(IPsqlQuery.append(" UNION ALL " + OPsqlQuery.toString() + " UNION ALL " + IPsqlQuery1.toString() + " UNION ALL " + OPsqlQuery1.toString()).toString());
				else if (LoctionType.equals("IP"))
					sqlQuery.append(IPsqlQuery.toString());
				else if (LoctionType.equals("OP"))
					sqlQuery.append(OPsqlQuery.toString());
				else if (LoctionType.equals("DC"))
					sqlQuery.append(IPsqlQuery1.toString());
				else if (LoctionType.equals("EM"))
					sqlQuery.append(OPsqlQuery1.toString());

				if( stmt != null) stmt.close();

				stmt = con.prepareStatement (sqlQuery.toString())  ;

				if ( (LoctionType.equals("IP")||(LoctionType.equals("Z"))) )
				{
					stmt.setString( ++count_bound_vars, locale);					
					stmt.setString( ++count_bound_vars, facilityId);
					stmt.setString( ++count_bound_vars, practId);
					stmt.setString( ++count_bound_vars, FromDate);
					stmt.setString( ++count_bound_vars, ToDate);
					stmt.setString( ++count_bound_vars, FromDate);
					stmt.setString( ++count_bound_vars, ToDate);

					if(!PatientId.equals(""))
						stmt.setString( ++count_bound_vars, PatientId);

					if(!QueueId.equals(""))
						stmt.setString( ++count_bound_vars, QueueId);
					
					if (!RelationshipCode.equals("ALL"))
						stmt.setString( ++count_bound_vars, RelationshipCode);
				}
				if ( (LoctionType.equals("DC")||(LoctionType.equals("Z"))) )
				{
					stmt.setString( ++count_bound_vars, locale);					
					stmt.setString( ++count_bound_vars, facilityId);
					stmt.setString( ++count_bound_vars, practId);			
					stmt.setString( ++count_bound_vars, FromDate);			
					stmt.setString( ++count_bound_vars, ToDate);			
					stmt.setString( ++count_bound_vars, FromDate);			
					stmt.setString( ++count_bound_vars, ToDate);			
					
					if(!PatientId.equals(""))
						stmt.setString( ++count_bound_vars, PatientId);			
					
					if(!QueueId.equals(""))
						stmt.setString( ++count_bound_vars, QueueId);
					
					if (!RelationshipCode.equals("ALL"))
						stmt.setString( ++count_bound_vars, RelationshipCode);
				}
				if ( (LoctionType.equals("OP")||(LoctionType.equals("Z"))))
				{
					stmt.setString( ++count_bound_vars, locale);	
					stmt.setString( ++count_bound_vars, facilityId);
					stmt.setString( ++count_bound_vars, practId);
					stmt.setString( ++count_bound_vars, FromDate);			
					stmt.setString( ++count_bound_vars, ToDate);			
					stmt.setString( ++count_bound_vars, FromDate);			
					stmt.setString( ++count_bound_vars, ToDate);			

					if(!PatientId.equals(""))
						stmt.setString( ++count_bound_vars, PatientId);			

					if(!QueueId.equals(""))
						stmt.setString( ++count_bound_vars, QueueId);

					if (!RelationshipCode.equals("ALL"))
						stmt.setString( ++count_bound_vars, RelationshipCode);
				}
				if ( (LoctionType.equals("EM")||(LoctionType.equals("Z"))))
				{
					stmt.setString( ++count_bound_vars, locale);		
					stmt.setString( ++count_bound_vars, facilityId);
					stmt.setString( ++count_bound_vars, practId);			
					stmt.setString( ++count_bound_vars, FromDate);			
					stmt.setString( ++count_bound_vars, ToDate);			
					stmt.setString( ++count_bound_vars, FromDate);			
					stmt.setString( ++count_bound_vars, ToDate);			

					if(!PatientId.equals(""))
						stmt.setString( ++count_bound_vars, PatientId);			

					if(!QueueId.equals(""))
						stmt.setString( ++count_bound_vars, QueueId);

					if (!RelationshipCode.equals("ALL"))
						stmt.setString( ++count_bound_vars, RelationshipCode);
				}
			}
			catch( Exception e ) 
			{ 
				
				isError.append(e.toString() +"<br>"+ sqlQuery.toString()); 
				e.printStackTrace();
			}

		}
		else if(search_type.equals("ByService"))
		{				
			field1 = "PATIENT_CLASS";
			field2 = "SERVICE_CODE";
			field3 = "SHORT_DESC";

			StringBuffer OPsqlQuery	= new StringBuffer();
			int count_bound_vars = 0;

			try
			{
				String LoctionType		  = (String)qryStrHash.get("LoctionType");
				String LoctionCode		  = (String)qryStrHash.get("LoctionCode");
				String ViewList				  = (String)qryStrHash.get("ViewList");
				String nationID				  = (String)qryStrHash.get("nationID");
				String adm_fromdate	  = (String)qryStrHash.get("adm_fromdate");
				String adm_todate		  = (String)qryStrHash.get("adm_todate");			
				String PatientId				  = (String)qryStrHash.get("PatientId");
				String QueueId			      = (String)qryStrHash.get("QueueId");
				String QueueStatus		  = (String)qryStrHash.get("QueueStatus");			
				if (QueueStatus.equals("~~"))
					QueueStatus = "";
				QueueStatus=QueueStatus.replace('~','\'');
				String UnSheduled		  = (String)qryStrHash.get("UnSheduled");
				String PastVisit		  = (String)qryStrHash.get("PastVisit");
				String OPFromDate		  = (String)qryStrHash.get("FromDate1");
				String OPToDate	   		= (String)qryStrHash.get("ToDate1");
				String Discharge		  = (String)qryStrHash.get("Discharge");
				String IPFromDate		  = (String)qryStrHash.get("FromDate2");
				String IPToDate	   		= (String)qryStrHash.get("ToDate2");			
				String CheckedOut		  = (String)qryStrHash.get("checked_out");

				if(arrlist.size()>0)		
					arrlist.clear();
				if(patClassSet.size()>0)	
					patClassSet.clear();
				//IP SQL Query			
				
				sqlQuery.append("SELECT patient_class, service_code, am_get_desc.am_service (o.service_code, ?, '2') short_desc FROM ca_pract_by_splty_locn_view o WHERE facility_id = ? AND practitioner_id = ? AND ( ");
				//IPsqlQuery.append("SELECT  DISTINCT PATIENT_CLASS, SERVICE_CODE, AM_GET_DESC.AM_SERVICE(O.SERVICE_CODE,?,'2') SHORT_DESC  FROM CA_PRACT_BY_SPLTY_LOCN_VIEW O  WHERE FACILITY_ID=?  AND PRACTITIONER_ID=?   ");
		
				if (LoctionType.equals("IP") || LoctionType.equals("DC")||LoctionType.equals("Z"))
				{
					//IPsqlQuery.append(" AND O.PATIENT_CLASS=? ");
					sqlQuery.append("(  patient_class = ?  AND EXISTS ( SELECT 1 FROM pr_encounter a WHERE a.service_code = o.service_code AND a.facility_id = o.facility_id AND a.patient_class = o.patient_class AND ))");
								
					if (!nationID.equals(""))
					sqlQuery.append("  AND A.PATIENT_ID IN (SELECT PATIENT_ID FROM MP_PATIENT WHERE NATIONAL_ID_NO   =? )");

					if (ViewList.equals("S"))
					sqlQuery.append(" AND A.ATTEND_PRACTITIONER_ID=? ");

					if (!PatientId.equals(""))
					{
						sqlQuery.append(" AND A.PATIENT_ID=? ");
					}
					 
					if (!QueueId.equals(""))
					{
						 sqlQuery.append(" AND A.PATIENT_ID IN (SELECT PATIENT_ID FROM MP_PATIENT WHERE ALT_ID1_NO   =? )");
					}

					if (!adm_fromdate.equals(""))
					sqlQuery.append(" AND A.VISIT_ADM_DATE_TIME >= TO_DATE(?,'DD/MM/YYYY') ");
				
					if (!adm_todate.equals(""))
					sqlQuery.append(" AND A.VISIT_ADM_DATE_TIME <= TO_DATE(?,'DD/MM/YYYY')+.9999 ");

					if (Discharge.equals("Y"))				
						{
							sqlQuery.append(" AND ( ADT_STATUS  IN ('01','07') OR ( ADT_STATUS  IN ('08')  ");
							if (!IPFromDate.equals(""))
								sqlQuery.append(" AND  DISCHARGE_DATE_TIME >= TO_DATE(?,'DD/MM/YYYY') ");
							if (!IPToDate.equals(""))
								sqlQuery.append(" AND DISCHARGE_DATE_TIME <= TO_DATE(?,'DD/MM/YYYY')+.9999 ");	
							sqlQuery.append(" ) )) ");
						}
					else
						sqlQuery.append(" AND  ADT_STATUS  IN ('01','07') )	 ") ;
				
					}
				
							
				if(LoctionType.equals("Z"))
				{
					sqlQuery.append("OR");
				}
				if(LoctionType.equals("OP")||LoctionType.equals("EM")|| LoctionType.equals("Z"))
				{
					sqlQuery.append("( patient_class = ? AND EXISTS ( SELECT 1 FROM ca_op_episode_vw a WHERE a.service_code = o.service_code AND a.facility_id = o.facility_id AND a.patient_class = o.patient_class AND a.physician_id = ? AND a.queue_status >= NVL(disp_in_ca_queue_after, queue_status) AND a.queue_status IN('01', '02', '03', '04', '05', '06') AND a.actual_physician_id != '*ALL' AND a.visit_episode_status BETWEEN '00' AND '06' AND a.adm_visit_date BETWEEN TRUNC (SYSDATE)AND TRUNC (SYSDATE) + 1))" );

					if (!nationID.equals(""))
					sqlQuery.append("  AND A.NATIONAL_ID_NO   =? ");	 
				
				if (ViewList.equals("S"))
					sqlQuery.append("  AND A.PHYSICIAN_ID   =? ");
				if (!PatientId.equals(""))
				{
					sqlQuery.append(" AND A.PATIENT_ID = ? ");
				}
				
				if (!QueueId.equals(""))
				{
					sqlQuery.append(" AND A.ALT_ID1_NO = ? ");
				}

				sqlQuery.append(" AND A.QUEUE_STATUS >= NVL(DISP_IN_CA_QUEUE_AFTER,QUEUE_STATUS) ");

				if (QueueStatus.equals("")) 	
					sqlQuery.append(" AND A.QUEUE_STATUS IN ( NULL )  " );
				else
					sqlQuery.append(" AND A.QUEUE_STATUS IN (" + QueueStatus + ")  ") ;

				
				if(!(UnSheduled.equals("Y")))
					sqlQuery.append(" and a.ACTUAL_PHYSICIAN_ID != '*ALL'  "); 
				else 
					sqlQuery.append(" AND 'Y' = DECODE(A.ACTUAL_PHYSICIAN_ID, '*ALL', CA_GET_UNASSIGN_LOCN_APPL(A.FACILITY_ID, A.UNASSIGN_PATIENT_YN, ?, A.LOCN_TYPE, A.LOCN_CODE, A.PATIENT_CLASS),'Y')  ");

				if(CheckedOut.equals("Y"))
					sqlQuery.append(" AND A.VISIT_EPISODE_STATUS BETWEEN '00' AND '07' " );
				else
					sqlQuery.append(" AND  A.VISIT_EPISODE_STATUS BETWEEN '00' AND '06' " );

				if (PastVisit.equals("N")||PastVisit.equals(""))
					sqlQuery.append("	AND A.ADM_VISIT_DATE BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE)+1 " );
				else
				{
					if (!OPFromDate.equals(""))
						sqlQuery.append( " AND ADM_VISIT_DATE >= TO_DATE(?,'DD/MM/YYYY') ");
					if (!OPToDate.equals(""))
						sqlQuery.append(" AND ADM_VISIT_DATE <= TO_DATE(?,'DD/MM/YYYY')+.9999 ");
				}

				}

				sqlQuery.append(")");
				
				if (!LoctionCode.equals("ALL"))
				{
					sqlQuery.append(" AND O.SERVICE_CODE=? ");
				}
				 sqlQuery.append(" ORDER BY 3 ");
				 
				
				//IPsqlQuery.append(" AND EXISTS  ( SELECT 1 FROM PR_ENCOUNTER A  WHERE A.SERVICE_CODE=O.SERVICE_CODE  AND A.FACILITY_ID =O.FACILITY_ID  AND A.PATIENT_CLASS =O.PATIENT_CLASS ");

			//	if (!nationID.equals(""))
			//		IPsqlQuery.append("  AND A.PATIENT_ID IN (SELECT PATIENT_ID FROM MP_PATIENT WHERE NATIONAL_ID_NO   =? )");	 			

				//if (ViewList.equals("S"))
					//IPsqlQuery.append(" AND A.ATTEND_PRACTITIONER_ID=? ");
				
				/*if (!PatientId.equals(""))
				{
					IPsqlQuery.append(" AND A.PATIENT_ID=? ");
				}
					 
				 if (!QueueId.equals(""))
				 {
					 IPsqlQuery.append(" AND A.PATIENT_ID IN (SELECT PATIENT_ID FROM MP_PATIENT WHERE ALT_ID1_NO   =? )");
				 }
				*/
				//if (!adm_fromdate.equals(""))
				//	IPsqlQuery.append(" AND A.VISIT_ADM_DATE_TIME >= TO_DATE(?,'DD/MM/YYYY') ");
				
				//if (!adm_todate.equals(""))
				//	IPsqlQuery.append(" AND A.VISIT_ADM_DATE_TIME <= TO_DATE(?,'DD/MM/YYYY')+.9999 ");
				
				//IPsqlQuery.append(" and (a.discharge_date_time is null ");
			/*	if (Discharge.equals("Y"))				
				{
					IPsqlQuery.append(" AND ( ADT_STATUS  IN ('01','07') OR ( ADT_STATUS  IN ('08')  ");
					if (!IPFromDate.equals(""))
						IPsqlQuery.append(" AND  DISCHARGE_DATE_TIME >= TO_DATE(?,'DD/MM/YYYY') ");
					if (!IPToDate.equals(""))
						IPsqlQuery.append(" AND DISCHARGE_DATE_TIME <= TO_DATE(?,'DD/MM/YYYY')+.9999 ");	
					IPsqlQuery.append(" ) )) ");
				}
				else
					IPsqlQuery.append(" AND  ADT_STATUS  IN ('01','07') )	 ") ;

			*/
				//OP SQL Query
				OPsqlQuery.append(" SELECT  DISTINCT O.PATIENT_CLASS, O.SERVICE_CODE, AM_GET_DESC.AM_SERVICE(O.SERVICE_CODE,?,'2') SHORT_DESC   FROM CA_PRACT_BY_SPLTY_LOCN_VIEW O   WHERE O.FACILITY_ID=? AND O.PRACTITIONER_ID=?   ");

				if (LoctionType.equals("OP")||LoctionType.equals("EM"))
				{
					OPsqlQuery.append(" AND O.PATIENT_CLASS=? ");
				
				}
				if (!LoctionCode.equals("ALL"))
						OPsqlQuery.append(" AND O.SERVICE_CODE=? ");
				
				OPsqlQuery.append(" AND EXISTS  (	SELECT 1 FROM CA_OP_EPISODE_VW A  WHERE A.SERVICE_CODE=O.SERVICE_CODE  AND A.FACILITY_ID =O.FACILITY_ID  AND A.PATIENT_CLASS =O.PATIENT_CLASS ");

				if (!nationID.equals(""))
					OPsqlQuery.append("  AND A.NATIONAL_ID_NO   =? ");	 
				
				if (ViewList.equals("S"))
					OPsqlQuery.append("  AND A.PHYSICIAN_ID   =? ");
				if (!PatientId.equals(""))
				{
					OPsqlQuery.append(" AND A.PATIENT_ID = ? ");
				}
				
				if (!QueueId.equals(""))
				{
					OPsqlQuery.append(" AND A.ALT_ID1_NO = ? ");
				}

				OPsqlQuery.append(" AND A.QUEUE_STATUS >= NVL(DISP_IN_CA_QUEUE_AFTER,QUEUE_STATUS) ");

				if (QueueStatus.equals("")) 	
					OPsqlQuery.append(" AND A.QUEUE_STATUS IN ( NULL )  " );
				else
					OPsqlQuery.append(" AND A.QUEUE_STATUS IN (" + QueueStatus + ")  ") ;

				
				if(!(UnSheduled.equals("Y")))
					OPsqlQuery.append(" and a.ACTUAL_PHYSICIAN_ID != '*ALL'  "); 
				else 
					OPsqlQuery.append(" AND 'Y' = DECODE(A.ACTUAL_PHYSICIAN_ID, '*ALL', CA_GET_UNASSIGN_LOCN_APPL(A.FACILITY_ID, A.UNASSIGN_PATIENT_YN, ?, A.LOCN_TYPE, A.LOCN_CODE, A.PATIENT_CLASS),'Y')  ");

				if(CheckedOut.equals("Y"))
					OPsqlQuery.append(" AND A.VISIT_EPISODE_STATUS BETWEEN '00' AND '07' " );
				else
					OPsqlQuery.append(" AND  A.VISIT_EPISODE_STATUS BETWEEN '00' AND '06' " );

				if (PastVisit.equals("N")||PastVisit.equals(""))
					OPsqlQuery.append("	AND A.ADM_VISIT_DATE BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE)+1 " );
				else
				{
					if (!OPFromDate.equals(""))
						OPsqlQuery.append( " AND ADM_VISIT_DATE >= TO_DATE(?,'DD/MM/YYYY') ");
					if (!OPToDate.equals(""))
						OPsqlQuery.append(" AND ADM_VISIT_DATE <= TO_DATE(?,'DD/MM/YYYY')+.9999 ");
				}
				OPsqlQuery.append(" ) ");

			/*	if(	LoctionType.equals("Z"))
					sqlQuery.append(IPsqlQuery.toString()+" UNION ALL "+OPsqlQuery.toString()+"  ORDER BY 3 ");
				else if (LoctionType.equals("IP")||LoctionType.equals("DC"))
					sqlQuery.append(IPsqlQuery.toString()+"  ORDER BY 3");
				else if (LoctionType.equals("OP")||LoctionType.equals("EM"))
					sqlQuery.append(OPsqlQuery.toString()+"  ORDER BY 3");
			*/

				if(stmt != null) stmt.close();

				
				stmt = con.prepareStatement (sqlQuery.toString())  ;

					
				if ( (LoctionType.equals("IP")||LoctionType.equals("DC")||(LoctionType.equals("Z"))))
				{

					stmt.setString(++count_bound_vars, locale);
					stmt.setString(++count_bound_vars, facilityId);

					stmt.setString(++count_bound_vars, practId);

			
					if (LoctionType.equals("IP") || LoctionType.equals("DC"))
					{
						stmt.setString(++count_bound_vars, LoctionType);

					}
					if (!(LoctionCode.equals("ALL")))
					{
							stmt.setString(++count_bound_vars, LoctionCode);

					}

					if (!nationID.equals(""))
					{
						stmt.setString(++count_bound_vars, nationID);

					}
				

					if (ViewList.equals("S"))
					{
						stmt.setString(++count_bound_vars, practId);

					}
					if (!PatientId.equals(""))
					{
						stmt.setString(++count_bound_vars, PatientId);
					}

					 if (!QueueId.equals(""))
					{
						stmt.setString(++count_bound_vars, QueueId);
					}


					if (!adm_fromdate.equals(""))
					{
						stmt.setString(++count_bound_vars, adm_fromdate);

					}
					
					if (!adm_todate.equals(""))
					{					
						stmt.setString(++count_bound_vars, adm_todate);

					}
					if (Discharge.equals("Y"))
					{
						if (!IPFromDate.equals(""))
						{
							stmt.setString(++count_bound_vars, IPFromDate);

						}
						if (!IPToDate.equals(""))
						{
							stmt.setString(++count_bound_vars, IPToDate);	

						}
					}
				}
				if ( LoctionType.equals("OP")||LoctionType.equals("EM")|| LoctionType.equals("Z"))
				{


		//OP SQL Query
					stmt.setString(++count_bound_vars, locale);
					stmt.setString(++count_bound_vars, facilityId);

					stmt.setString(++count_bound_vars, practId);


					if (LoctionType.equals("OP")||LoctionType.equals("EM"))
					{
						stmt.setString(++count_bound_vars, LoctionType);

						
					}
					if (!LoctionCode.equals("ALL"))
					{
							stmt.setString(++count_bound_vars, LoctionCode);

					}					
					if (!nationID.equals(""))
					{
						stmt.setString(++count_bound_vars, nationID);

					}
					
					if (ViewList.equals("S"))
					{
						stmt.setString(++count_bound_vars, practId);

					}
					if (!PatientId.equals(""))
					{
						stmt.setString(++count_bound_vars, PatientId);
					}

					if (!QueueId.equals(""))
					{
						stmt.setString(++count_bound_vars, QueueId);
					}

					
					if(UnSheduled.equals("Y")) 
					{
						stmt.setString(++count_bound_vars, practId);

					}


					if (PastVisit.equals("Y"))
					{
						if (!OPFromDate.equals(""))
						{
							stmt.setString(++count_bound_vars, OPFromDate);

						}
						if (!OPToDate.equals(""))
						{
							stmt.setString(++count_bound_vars, OPToDate);

						}
					}
				}				
			}
			catch( Exception e ) 
			{ 

				isError.append(e.toString() +"<br>"+ sqlQuery.toString()); 
				e.printStackTrace();
			}			
		}
		HashMap hash = null;
		try
		{
			ResultSet rset  = null ;
			//HashMap hash = null;
			rset = stmt.executeQuery();
			while( rset.next())
			{
				hash = new HashMap();
				hash.put ( "PATIENT_CLASS",( rset.getString ( field1 )==null?"" :rset.getString ( field1 )));
				hash.put ( "LOCN_CODE",( rset.getString ( field2 )		==null ?"" :rset.getString ( field2 )));
				hash.put ( "LOCN_SHORT_DESC",( rset.getString ( field3 ) ==null ?"" :rset.getString ( field3 )));
				patClassSet.add(rset.getString("PATIENT_CLASS"));
				arrlist.add( hash );
			}	
			//if(hash != null) hash.clear();
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			isError.append(e.toString() +"<br>"+ sqlQuery.toString()); 
			e.printStackTrace();
		}
		//if(hash != null) hash.clear();
		//if(qryStrHash != null) qryStrHash.clear();
		return isError.toString();
    }
	public boolean isFirstLevel()
	{
		boolean isData = false;
		if(patClassSet.size()>0)
			isData = true;
		return 	isData;
	}

	public HashSet getFirstLevel()
	{
		return patClassSet; 
	}

	public ArrayList getSecondLevel(String patientType)
	{
		ArrayList returnArray = new ArrayList();
		HashMap dat = null;
		HashMap opHash = null;
		if(arrlist.size()>0)
		{
			for (int i=0; i<arrlist.size(); i++)
			{
				dat = (HashMap) arrlist.get(i) ;
				if(dat.get( "PATIENT_CLASS" ).equals(patientType))
				{
					opHash	 = new HashMap();
					opHash.put("LOCN_SHORT_DESC",dat.get( "LOCN_SHORT_DESC" ) );
					opHash.put("LOCN_CODE",dat.get( "LOCN_CODE" ) );
					returnArray.add(opHash);
				}
			}
			//if(dat != null) dat.clear();
			//if(opHash != null) opHash.clear();
		}
		//if(dat != null) dat.clear();
	return returnArray;
	}
}

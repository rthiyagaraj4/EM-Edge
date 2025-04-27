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

public class PatSearch implements java.io.Serializable 
{
	ArrayList arrlist = new ArrayList ();
	HashSet patClassSet = new HashSet();
	public PatSearch(){}

	public synchronized String setLevelHeader(Connection con,String practId, String facilityId, HashMap qryStrHash, String search_type,String locale)
	{
		PreparedStatement stmt  = null ;
        ResultSet rset  = null ;
		String isError = "Success";
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
				LoctionType			= (String)qryStrHash.get("LoctionType");
				String LoctionCode 	= (String)qryStrHash.get("LoctionCode"); 
				String ViewList   	= (String)qryStrHash.get("ViewList");
				String adm_fromdate = (String)qryStrHash.get("adm_fromdate");
				String adm_todate	= (String)qryStrHash.get("adm_todate");
				String PatientId   	= (String)qryStrHash.get("PatientId");
				String QueueId   	= (String)qryStrHash.get("QueueId");
				String nationID		= (String)qryStrHash.get("nationID");
				String QueueStatus  = (String)qryStrHash.get("QueueStatus");

				if (QueueStatus.equals("~~"))
					QueueStatus = "";

				QueueStatus=QueueStatus.replace('~','\'');
				
				String UnSheduled   	= (String)qryStrHash.get("UnSheduled");
				String PastVisit   		= (String)qryStrHash.get("PastVisit");
				String OPFromDate	   	= (String)qryStrHash.get("FromDate1");
				String OPToDate	   		= (String)qryStrHash.get("ToDate1");
				String Discharge		= (String)qryStrHash.get("Discharge");
				String IPFromDate		= (String)qryStrHash.get("FromDate2");
				String IPToDate			= (String)qryStrHash.get("ToDate2");
				String CheckedOut		= (String)qryStrHash.get("checked_out");

				if(arrlist.size()>0)	
					arrlist.clear();
				if(patClassSet.size()>0)	
					patClassSet.clear();				

				IPsqlQuery.append("select patient_class ,LOCN_CODE,DECODE(locn_type,'C',OP_GET_DESC.OP_CLINIC(?,locn_code,?,'2'),'W',IP_GET_DESC.IP_NURSING_UNIT(?,locn_code,?,'2') )  LOCN_SHORT_DESC from ca_pract_by_locn_view o where facility_id=? and practitioner_id=? and Locn_type='W' ");

				if (LoctionType.equals("IP") || LoctionType.equals("DC"))
				{
					IPsqlQuery.append(" and patient_class=? ");

					if (!LoctionCode.equals("*ALL"))
						IPsqlQuery.append(" and locn_code=? ");
					
				}
				IPsqlQuery.append(" and exists  ( select 1 from CA_IP_ACTIVE_EPISODE_VW a  where a.CUR_WARD_CODE=o.locn_code  and a.facility_id =o.facility_id and a.patient_class =o.patient_class ");			
				if (!nationID.equals(""))
					IPsqlQuery.append("  and a.NATIONAL_ID_NO   =? ");	

				if (ViewList.equals("S"))
					IPsqlQuery.append(" and a.CUR_PHYSICIAN_ID=? ");
				IPsqlQuery.append(" and a.patient_id = nvl(?,a.patient_id)  and NVL(a.alt_id1_no,'X') = nvl(?, NVL(a.alt_id1_no, 'X')) ");
				if (!adm_fromdate.equals(""))
					IPsqlQuery.append(" and ADMISSION_DATE_TIME >= to_date(?,'dd/mm/yyyy') ");				
				if (!adm_todate.equals(""))
					IPsqlQuery.append(" and ADMISSION_DATE_TIME <= to_date(?,'dd/mm/yyyy')+.9999 ");
				IPsqlQuery.append(" and (a.discharge_date_time is null ");
				if (Discharge.equals("N")||Discharge.equals(""))
					IPsqlQuery.append("	) ");
				else
				{
					IPsqlQuery.append(" or ( a.discharge_date_time is not null  ");
					if (!IPFromDate.equals(""))
						IPsqlQuery.append(" and  discharge_date_time >= to_date(?,'dd/mm/yyyy') ");
					if (!IPToDate.equals(""))
						IPsqlQuery.append(" and discharge_date_time <= to_date(?,'dd/mm/yyyy')+.9999 ");	
					IPsqlQuery.append(" ) )");
				}			
				IPsqlQuery.append("   and rownum<2	) ");


	//OutPatient Query
				OPsqlQuery.append("select patient_class , LOCN_CODE,DECODE(locn_type,'C',OP_GET_DESC.OP_CLINIC(?,locn_code,?,'2'),'W',IP_GET_DESC.IP_NURSING_UNIT(?,locn_code,?,'2') ) LOCN_SHORT_DESC from ca_pract_by_locn_view o  where facility_id=? and practitioner_id=?  and Locn_type='C' ");
				if (LoctionType.equals("OP")||LoctionType.equals("EM"))
				{
					OPsqlQuery.append(" and patient_class=?" );
					if (!LoctionCode.equals("*ALL"))
						OPsqlQuery.append(" and locn_code=? ");
				}
				OPsqlQuery.append(" and exists  (	select 1 from CA_OP_EPISODE_VW a  where a.locn_CODE=o.locn_code  and a.facility_id =o.facility_id  and a.patient_class =o.patient_class ");
				if (!nationID.equals(""))
					OPsqlQuery.append("  and a.NATIONAL_ID_NO   =? ");	 	
				if (ViewList.equals("S"))
					OPsqlQuery.append("  and a.PHYSICIAN_ID   =? ");
				OPsqlQuery.append("and a.patient_id = nvl(?,a.patient_id)  and NVL(a.alt_id1_no,'X') = nvl(?, NVL(a.alt_id1_no, 'X'))  and queue_status >= nvl(DISP_IN_CA_QUEUE_AFTER, queue_status) ");
				if (QueueStatus.equals("")) 	
					OPsqlQuery.append(" and a.queue_status in (null)  ") ;
				else	
					OPsqlQuery.append(" and a.queue_status in (" + QueueStatus + ")  " );
				if(!(UnSheduled.equals("Y")))
					OPsqlQuery.append(" and ACTUAL_PHYSICIAN_ID != '*ALL'  "); 
				else if(UnSheduled.equals("Y")) 
					OPsqlQuery.append(" and 'Y' = decode(nvl(ACTUAL_PHYSICIAN_ID, '*ALL'), '*ALL', CA_GET_UNASSIGN_LOCN_APPL(a.facility_id, a.UNASSIGN_PATIENT_YN,?, a.locn_type, a.locn_code,a.patient_class),'Y')  ");

				if(CheckedOut.equals("Y"))
					OPsqlQuery.append(" and nvl(visit_episode_status,'01') not in ('08','09')  ");
				else
					OPsqlQuery.append(" and nvl(visit_episode_status,'01') not in ('07','08','09') ");

				if (PastVisit.equals("N")||PastVisit.equals(""))
					OPsqlQuery.append("	and adm_visit_date between trunc(sysdate) and trunc(sysdate)+1 ") ;
				else
				{
					if (!OPFromDate.equals(""))
						OPsqlQuery.append(" and adm_visit_date >= to_date(?,'dd/mm/yyyy') ");
					else
						OPsqlQuery.append(" and adm_visit_date >= trunc(sysdate) ");
					if (!OPToDate.equals(""))
						OPsqlQuery.append( " and adm_visit_date <= to_date(?,'dd/mm/yyyy')+.9999 ");
				}
				OPsqlQuery.append(" and episode_type='O' and rownum<2) order by 3 ");

				if(	LoctionType.equals("Z"))
					sqlQuery.append(IPsqlQuery.toString() + " union all " + OPsqlQuery.toString());
				else if (LoctionType.equals("IP")||LoctionType.equals("DC"))
					sqlQuery.append(IPsqlQuery.toString());
				else if (LoctionType.equals("OP")||LoctionType.equals("EM"))
					sqlQuery.append(OPsqlQuery.toString());

				stmt = con.prepareStatement(sqlQuery.toString());

				if ( (LoctionType.equals("IP")||LoctionType.equals("DC")||(LoctionType.equals("Z"))) && !((LoctionType.equals("OP")||LoctionType.equals("EM")))   )
				{
					stmt.setString(++count_bound_vars, facilityId);
					stmt.setString(++count_bound_vars, locale);
					stmt.setString(++count_bound_vars, facilityId);
					stmt.setString(++count_bound_vars, locale);
					stmt.setString(++count_bound_vars, facilityId);

					stmt.setString(++count_bound_vars, practId);			

					if (LoctionType.equals("IP") || LoctionType.equals("DC"))
					{
						stmt.setString(++count_bound_vars, LoctionType);	

						if (!LoctionCode.equals("*ALL"))
							stmt.setString(++count_bound_vars, LoctionCode);				
					}			
					if (!nationID.equals(""))
						stmt.setString(++count_bound_vars, nationID);

					if (ViewList.equals("S"))
						stmt.setString(++count_bound_vars, practId);

					stmt.setString(++count_bound_vars, PatientId);
					stmt.setString(++count_bound_vars, QueueId);			

					if (!adm_fromdate.equals(""))
						stmt.setString(++count_bound_vars, adm_fromdate);			

					if (!adm_todate.equals(""))
						stmt.setString(++count_bound_vars, adm_todate);
					
					if (Discharge.equals("N")||Discharge.equals(""))
					{
					}
					else
					{
					
						if (!IPFromDate.equals(""))
						{
							stmt.setString(++count_bound_vars, IPFromDate);
							System.out.println(count_bound_vars + "--" + IPFromDate);
						}
						if (!IPToDate.equals(""))
						{
							stmt.setString(++count_bound_vars, IPToDate);
							System.out.println(count_bound_vars + "--" + IPToDate);
						}
					}	
				}
				//OutPatient Query

				if ( (LoctionType.equals("OP")||LoctionType.equals("EM")||(LoctionType.equals("Z"))) && !((LoctionType.equals("IP")||LoctionType.equals("DC")))   )
				{
					stmt.setString(++count_bound_vars, facilityId);
					stmt.setString(++count_bound_vars, locale);
					stmt.setString(++count_bound_vars, facilityId);
					stmt.setString(++count_bound_vars, locale);
					stmt.setString(++count_bound_vars, facilityId);
					stmt.setString(++count_bound_vars, practId);

					if (LoctionType.equals("OP")||LoctionType.equals("EM"))
					{
						stmt.setString(++count_bound_vars, LoctionType);
						if (!LoctionCode.equals("*ALL"))
							stmt.setString(++count_bound_vars, LoctionCode);
					}
					
					if (!nationID.equals(""))
						stmt.setString(++count_bound_vars, nationID);
					
					if (ViewList.equals("S"))
						stmt.setString(++count_bound_vars, practId);

					stmt.setString(++count_bound_vars, PatientId);
					stmt.setString(++count_bound_vars, QueueId);

					if(UnSheduled.equals("Y")) 
						stmt.setString(++count_bound_vars, practId);
					
					if (PastVisit.equals("N")||PastVisit.equals(""))
					{
					}
					else
					{
						if (!OPFromDate.equals(""))
							stmt.setString(++count_bound_vars, OPFromDate);					
						if (!OPToDate.equals(""))
							stmt.setString(++count_bound_vars, OPToDate);					
					}
				}

			/*	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("CheckedOut =>"+CheckedOut);
				System.out.println("facilityId =>"+facilityId);
				System.out.println("practId =>"+practId);
				System.out.println("LoctionType =>"+LoctionType);
				System.out.println("LoctionCode =>"+LoctionCode);
				System.out.println("QueueStatus =>"+QueueStatus);
				System.out.println("PastVisit =>"+PastVisit);
				System.out.println("OPFromDate =>"+OPFromDate);
				System.out.println("OPToDate =>"+OPToDate);
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("sqlQuery ByLocation =>"+sqlQuery.toString());*/

				rset = stmt.executeQuery();
			}
			catch( Exception e ) 
			{
				isError += e.toString() +"<br>"+ sqlQuery.toString() ; 
				e.printStackTrace(System.err);
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
				IPsqlQuery.append("select 'IP' PATIENT_CLASS,PRACT_RELN_ID,PRACT_RELN_NAME||decode(LIFETIME_OR_ENCNTR,'L','*') PRACT_RELN_NAME from ca_pract_reln O WHERE 1=1 ");
				if (!RelationshipCode.equals("ALL"))
					IPsqlQuery.append(" AND  PRACT_RELN_ID=? ");
				IPsqlQuery.append(" AND EXISTS (SELECT  1 FROM CA_ENCNTR_PRACT_RELN I WHERE  I.PRACT_RELN_ID= O.PRACT_RELN_ID AND facility_id=?  and I.PRACTITIONER_ID=? AND  SYSDATE BETWEEN BEGIN_DATE_TIME AND NVL(END_DATE_TIME,SYSDATE) AND ROWNUM<2 AND PATIENT_CLASS IN ('IP') ");

				IPsqlQuery.append(" and ( (TO_DATE(nvl(?,'01/01/1900'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (TO_DATE(nvl(?,'01/01/5999'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (trunc(BEGIN_DATE_TIME) between TO_DATE(nvl(?,'01/01/1900'),'DD/MM/YYYY') and TO_DATE(nvl(?,'01/01/5999'),'DD/MM/YYYY')) )");
				if(!PatientId.equals(""))
					IPsqlQuery.append(" and PATIENT_ID=? "); 
				if(!QueueId.equals(""))
					IPsqlQuery.append(" and PATIENT_ID=(select patient_id from mp_patient where ALT_ID1_NO=?)");
				IPsqlQuery.append(" )");
				// IPsqlQuery for DC (Day Care) 
				IPsqlQuery1.append("select 'DC' PATIENT_CLASS,PRACT_RELN_ID,PRACT_RELN_NAME||decode(LIFETIME_OR_ENCNTR,'L','*') PRACT_RELN_NAME from ca_pract_reln O WHERE 1=1 ");
				if (!RelationshipCode.equals("ALL"))
					IPsqlQuery1.append(" AND  PRACT_RELN_ID=? ");
				IPsqlQuery1.append(" AND EXISTS (SELECT  1 FROM CA_ENCNTR_PRACT_RELN I WHERE  I.PRACT_RELN_ID= O.PRACT_RELN_ID AND facility_id=?  and I.PRACTITIONER_ID=? AND  SYSDATE BETWEEN BEGIN_DATE_TIME AND NVL(END_DATE_TIME,SYSDATE) AND ROWNUM<2 AND PATIENT_CLASS IN ('DC') ");

				IPsqlQuery1.append(" and ( (TO_DATE(nvl(?,'01/01/1900'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (TO_DATE(nvl(?,'01/01/5999'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (trunc(BEGIN_DATE_TIME) between TO_DATE(nvl(?,'01/01/1900'),'DD/MM/YYYY') and TO_DATE(nvl(?,'01/01/5999'),'DD/MM/YYYY')) )");
				if(!PatientId.equals(""))
					IPsqlQuery1.append(" and PATIENT_ID=? "); 
				if(!QueueId.equals(""))
					IPsqlQuery1.append(" and PATIENT_ID=(select patient_id from mp_patient where ALT_ID1_NO=?)");
				IPsqlQuery1.append(" )");
				// OPsqlquery for OP (OutPatient)
				OPsqlQuery.append("select 'OP' PATIENT_CLASS,PRACT_RELN_ID,PRACT_RELN_NAME||decode(LIFETIME_OR_ENCNTR,'L','*') PRACT_RELN_NAME from ca_pract_reln O WHERE 1=1 ");
				
				if (!RelationshipCode.equals("ALL"))
					OPsqlQuery.append(" AND  PRACT_RELN_ID=? ");
				OPsqlQuery.append(" AND EXISTS (SELECT  1 FROM CA_ENCNTR_PRACT_RELN I WHERE  I.PRACT_RELN_ID= O.PRACT_RELN_ID AND facility_id=? and I.PRACTITIONER_ID=? AND  SYSDATE BETWEEN BEGIN_DATE_TIME AND NVL(END_DATE_TIME,SYSDATE) AND ROWNUM<2 AND PATIENT_CLASS IN ('OP') ");

				OPsqlQuery.append(" and ( (TO_DATE(nvl(?,'01/01/1900'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (TO_DATE(nvl(?,'01/01/5999'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (trunc(BEGIN_DATE_TIME) between TO_DATE(nvl(?,'01/01/1900'),'DD/MM/YYYY') and TO_DATE(nvl(?,'01/01/5999'),'DD/MM/YYYY')) )");
				if(!PatientId.equals(""))
					OPsqlQuery.append(" and PATIENT_ID=? ");
				if(!QueueId.equals(""))
					OPsqlQuery.append(" and PATIENT_ID=(select patient_id from mp_patient where ALT_ID1_NO=?)");
				OPsqlQuery.append(" )");
				// OPsqlquery for EM (Emergency)
				OPsqlQuery1.append("select 'EM' PATIENT_CLASS,PRACT_RELN_ID,PRACT_RELN_NAME||decode(LIFETIME_OR_ENCNTR,'L','*') PRACT_RELN_NAME from ca_pract_reln O WHERE 1=1 ");

				if (!RelationshipCode.equals("ALL"))
					OPsqlQuery1.append(" AND  PRACT_RELN_ID=? ");

				OPsqlQuery1.append(" AND EXISTS (SELECT  1 FROM CA_ENCNTR_PRACT_RELN I WHERE  I.PRACT_RELN_ID= O.PRACT_RELN_ID AND facility_id=?  and I.PRACTITIONER_ID=? AND  SYSDATE BETWEEN BEGIN_DATE_TIME AND NVL(END_DATE_TIME,SYSDATE) AND ROWNUM<2 AND PATIENT_CLASS IN ('EM') ");

				OPsqlQuery1.append(" and ( (TO_DATE(nvl(?,'01/01/1900'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (TO_DATE(nvl(?,'01/01/5999'),'DD/MM/YYYY') between trunc(BEGIN_DATE_TIME) and trunc(END_DATE_TIME)) or (trunc(BEGIN_DATE_TIME) between TO_DATE(nvl(?,'01/01/1900'),'DD/MM/YYYY') and TO_DATE(nvl(?,'01/01/5999'),'DD/MM/YYYY')) )");

				if(!PatientId.equals(""))
					OPsqlQuery1.append(" and PATIENT_ID=? "); 
				if(!QueueId.equals(""))
					OPsqlQuery1.append(" and PATIENT_ID=(select patient_id from mp_patient where ALT_ID1_NO=?)");
				OPsqlQuery1.append(" )");


				if(	LoctionType.equals("Z"))
					sqlQuery.append(IPsqlQuery.append(" union all " + OPsqlQuery.toString() + " union all " + IPsqlQuery1.toString() + " union all " + OPsqlQuery1.toString()).toString());
				else if (LoctionType.equals("IP"))
					sqlQuery.append(IPsqlQuery.toString());
				else if (LoctionType.equals("OP"))
					sqlQuery.append(OPsqlQuery.toString());
				else if (LoctionType.equals("DC"))
					sqlQuery.append(IPsqlQuery1.toString());
				else if (LoctionType.equals("EM"))
					sqlQuery.append(OPsqlQuery1.toString());
				stmt = con.prepareStatement (sqlQuery.toString())  ;
				//System.err.println(sqlQuery.toString());
				System.err.println("LoctionType=" + LoctionType);
				if ( (LoctionType.equals("IP")||(LoctionType.equals("Z"))) )
				{
					if (!RelationshipCode.equals("ALL"))
					{
						stmt.setString( ++count_bound_vars, RelationshipCode);
						System.err.println(count_bound_vars + "==" + RelationshipCode); 
					}
					stmt.setString( ++count_bound_vars, facilityId);
					System.err.println(count_bound_vars + "==" + facilityId); 
					stmt.setString( ++count_bound_vars, practId);
					System.err.println(count_bound_vars + "==" + practId); 
					stmt.setString( ++count_bound_vars, FromDate);
					System.err.println(count_bound_vars + "==" + FromDate); 
					stmt.setString( ++count_bound_vars, ToDate);
					System.err.println(count_bound_vars + "==" + ToDate); 
					stmt.setString( ++count_bound_vars, FromDate);
					System.err.println(count_bound_vars + "==" + FromDate); 
					stmt.setString( ++count_bound_vars, ToDate);
					System.err.println(count_bound_vars + "==" + ToDate); 

					if(!PatientId.equals(""))
					{
						stmt.setString( ++count_bound_vars, PatientId);
						//System.err.println(count_bound_vars + "==" + PatientId); 
					}
					if(!QueueId.equals(""))
					{
						stmt.setString( ++count_bound_vars, QueueId);
						//System.err.println(count_bound_vars + "==" + QueueId); 
					}
				}
				if ( (LoctionType.equals("DC")||(LoctionType.equals("Z"))) )
				{
				
					if (!RelationshipCode.equals("ALL"))
					{
						stmt.setString( ++count_bound_vars, RelationshipCode);
						//System.err.println(count_bound_vars + "==" + RelationshipCode); 
					}
					stmt.setString( ++count_bound_vars, facilityId);
					//System.err.println(count_bound_vars + "==" + facilityId); 
					stmt.setString( ++count_bound_vars, practId);			
					//System.err.println(count_bound_vars + "==" + practId); 
					stmt.setString( ++count_bound_vars, FromDate);			
					//System.err.println(count_bound_vars + "==" + FromDate); 
					stmt.setString( ++count_bound_vars, ToDate);			
					//System.err.println(count_bound_vars + "==" + ToDate); 
					stmt.setString( ++count_bound_vars, FromDate);			
					//System.err.println(count_bound_vars + "==" + FromDate); 
					stmt.setString( ++count_bound_vars, ToDate);			
					//System.err.println(count_bound_vars + "==" + ToDate); 
					
					if(!PatientId.equals(""))
					{
						stmt.setString( ++count_bound_vars, PatientId);			
						//System.err.println(count_bound_vars + "==" + PatientId); 
					}
					if(!QueueId.equals(""))
					{
						stmt.setString( ++count_bound_vars, QueueId);
						//System.err.println(count_bound_vars + "==" + QueueId); 
					}
				}
				if ( (LoctionType.equals("OP")||(LoctionType.equals("Z"))))
				{
					if (!RelationshipCode.equals("ALL"))
					{
						stmt.setString( ++count_bound_vars, RelationshipCode);
						//System.err.println(count_bound_vars + "==" + RelationshipCode); 
					}
					stmt.setString( ++count_bound_vars, facilityId);
					//System.err.println(count_bound_vars + "==" + facilityId); 
					stmt.setString( ++count_bound_vars, practId);
					//System.err.println(count_bound_vars + "==" + practId); 
					stmt.setString( ++count_bound_vars, FromDate);			
					//System.err.println(count_bound_vars + "==" + FromDate); 
					stmt.setString( ++count_bound_vars, ToDate);			
					//System.err.println(count_bound_vars + "==" + ToDate); 
					stmt.setString( ++count_bound_vars, FromDate);			
					//System.err.println(count_bound_vars + "==" + FromDate); 
					stmt.setString( ++count_bound_vars, ToDate);			
					//System.err.println(count_bound_vars + "==" + ToDate); 
					if(!PatientId.equals(""))
					{
						stmt.setString( ++count_bound_vars, PatientId);			
						//System.err.println(count_bound_vars + "==" + PatientId); 
					}
					if(!QueueId.equals(""))
					{
						stmt.setString( ++count_bound_vars, QueueId);
						//System.err.println(count_bound_vars + "==" + QueueId); 
					}
				}
				if ( (LoctionType.equals("EM")||(LoctionType.equals("Z"))))
				{
					if (!RelationshipCode.equals("ALL"))
					{
						stmt.setString( ++count_bound_vars, RelationshipCode);
						//System.err.println(count_bound_vars + "==" + RelationshipCode); 
					}
					stmt.setString( ++count_bound_vars, facilityId);
					//System.err.println(count_bound_vars + "==" + facilityId); 
					stmt.setString( ++count_bound_vars, practId);			
					//System.err.println(count_bound_vars + "==" + practId); 
					stmt.setString( ++count_bound_vars, FromDate);			
					//System.err.println(count_bound_vars + "==" + FromDate); 
					stmt.setString( ++count_bound_vars, ToDate);			
					//System.err.println(count_bound_vars + "==" + ToDate); 
					stmt.setString( ++count_bound_vars, FromDate);			
					//System.err.println(count_bound_vars + "==" + FromDate); 
					stmt.setString( ++count_bound_vars, ToDate);			
					//System.err.println(count_bound_vars + "==" + ToDate); 
					if(!PatientId.equals(""))
					{
						stmt.setString( ++count_bound_vars, PatientId);			
						//System.err.println(count_bound_vars + "==" + PatientId); 
					}
					if(!QueueId.equals(""))
					{
						stmt.setString( ++count_bound_vars, QueueId);
						//System.err.println(count_bound_vars + "==" + QueueId); 
					}
				}

				/*System.out.println("**************************to check with Bean**********(eCA)************************");
				System.out.println("LoctionType =>"+LoctionType);
				System.out.println("RelationshipCode =>"+RelationshipCode);
				System.out.println("PatientId =>"+PatientId);
				System.out.println("QueueId =>"+QueueId);
				System.out.println("FromDate =>"+FromDate);
				System.out.println("ToDate =>"+ToDate);
				System.out.println("sqlQuery =>"+sqlQuery.toString());
				System.out.println("**************************Ends Here ********************************************************");
				*/
				rset = stmt.executeQuery();
			}
			catch( Exception e ) 
			{ 
				System.out.println("Error in PatSearch Bean =>"+e.toString());
				isError += e.toString() +"<br>"+ sqlQuery.toString(); 
				e.printStackTrace(System.err);
			}

		}
		else if(search_type.equals("ByService"))
		{				
			field1 = "PATIENT_CLASS";
			field2 = "SERVICE_CODE";
			field3 = "SHORT_DESC";
			//System.out.println(field3);
			StringBuffer IPsqlQuery	= new StringBuffer();
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
				IPsqlQuery.append("select  DISTINCT patient_class, service_code, AM_GET_DESC.AM_SERVICE(O.SERVICE_CODE,?,'2')  short_desc  from CA_PRACT_BY_SPLTY_LOCN_VIEW o  where facility_id=?  and practitioner_id=?  and Locn_type='W' ");
		
				if (LoctionType.equals("IP") || LoctionType.equals("DC"))
				{
					IPsqlQuery.append(" and patient_class=? ");
					if (!(LoctionCode.equals("ALL")))
						IPsqlQuery.append(" and o.service_code=? ");
				}else if(LoctionType.equals("Z") && (!LoctionCode.equals("ALL")))
					IPsqlQuery.append(" and o.service_code=? ");
				IPsqlQuery.append(" and exists  ( select 1 from CA_IP_ACTIVE_EPISODE_VW a  where a.service_code=o.service_code  and a.facility_id =o.facility_id  and a.patient_class =o.patient_class ");

				if (!nationID.equals(""))
					IPsqlQuery.append("  and a.NATIONAL_ID_NO   =? ");	 			

				if (ViewList.equals("S"))
					IPsqlQuery.append(" and a.CUR_PHYSICIAN_ID=? ");

				IPsqlQuery.append(" and a.patient_id = nvl(?,a.patient_id) and NVL(a.alt_id1_no,'X') = nvl(?,NVL(a.alt_id1_no,'X')) ");

				if (!adm_fromdate.equals(""))
					IPsqlQuery.append(" and ADMISSION_DATE_TIME >= to_date(?,'dd/mm/yyyy') ");
				
				if (!adm_todate.equals(""))
					IPsqlQuery.append(" and ADMISSION_DATE_TIME <= to_date(?,'dd/mm/yyyy')+.9999 ");
				
				IPsqlQuery.append(" and (a.discharge_date_time is null ");
				if (Discharge.equals("N")||Discharge.equals(""))
					IPsqlQuery.append("	) ") ;
				else
				{
					IPsqlQuery.append(" or ( a.discharge_date_time is not null  ");
					if (!IPFromDate.equals(""))
						IPsqlQuery.append(" and  discharge_date_time >= to_date(?,'dd/mm/yyyy') ");
					if (!IPToDate.equals(""))
						IPsqlQuery.append(" and discharge_date_time <= to_date(?,'dd/mm/yyyy')+.9999 ");	
					IPsqlQuery.append(" ) )");
				}
				IPsqlQuery.append("   and rownum<2	) ");
				//OP SQL Query
				OPsqlQuery.append("select  DISTINCT patient_class, service_code,  AM_GET_DESC.AM_SERVICE(O.SERVICE_CODE,?,'2')  short_desc   from CA_PRACT_BY_SPLTY_LOCN_VIEW o   where facility_id=? and practitioner_id=?  and Locn_type='C' ");

				if (LoctionType.equals("OP")||LoctionType.equals("EM"))
				{
					OPsqlQuery.append(" and patient_class=?");
					if (!LoctionCode.equals("ALL"))
						OPsqlQuery.append(" and service_code=? ");
				}
				else if(LoctionType.equals("Z") && (!LoctionCode.equals("ALL")))
					OPsqlQuery.append(" and o.service_code=? "); 
				
				OPsqlQuery.append(" and exists  (	select 1 from CA_OP_EPISODE_VW a  where a.SERVICE_CODE=o.SERVICE_CODE  and a.facility_id =o.facility_id  and a.patient_class =o.patient_class ");

				if (!nationID.equals(""))
					OPsqlQuery.append("  and a.NATIONAL_ID_NO   =? ");	 
				
				if (ViewList.equals("S"))
					OPsqlQuery.append("  and a.PHYSICIAN_ID   =? ");

				OPsqlQuery.append("and a.patient_id = nvl(?,a.patient_id)  and NVL(a.alt_id1_no,'X') = nvl(?,NVL(a.alt_id1_no,'X'))  and queue_status >= nvl(DISP_IN_CA_QUEUE_AFTER,queue_status) ");

				if (QueueStatus.equals("")) 	
					OPsqlQuery.append(" and a.queue_status in ( null )  " );
				else
					OPsqlQuery.append(" and a.queue_status in (" + QueueStatus + ")  ") ;

				
				if(!(UnSheduled.equals("Y")))
					OPsqlQuery.append(" and ACTUAL_PHYSICIAN_ID != '*ALL'  "); 
				else if(UnSheduled.equals("Y")) 
					OPsqlQuery.append(" and 'Y' = decode(ACTUAL_PHYSICIAN_ID, '*ALL', CA_GET_UNASSIGN_LOCN_APPL(a.facility_id, a.UNASSIGN_PATIENT_YN, ?, a.locn_type, a.locn_code, a.patient_class),'Y')  ");

				if(CheckedOut.equals("Y"))
					OPsqlQuery.append(" and nvl(visit_episode_status,'01') not in ('08','09') " );
				else
					OPsqlQuery.append(" and nvl(visit_episode_status,'01') not in ('07','08','09') " );

				if (PastVisit.equals("N")||PastVisit.equals(""))
					OPsqlQuery.append("	and adm_visit_date between trunc(sysdate) and trunc(sysdate)+1 " );
				else
				{
					if (!OPFromDate.equals(""))
						OPsqlQuery.append( " and adm_visit_date >= to_date(?,'dd/mm/yyyy') ");
					if (!OPToDate.equals(""))
						OPsqlQuery.append(" and adm_visit_date <= to_date(?,'dd/mm/yyyy')+.9999 ");
				}
				OPsqlQuery.append(" and episode_type='O' and rownum<2) order by 3 ");

				if(	LoctionType.equals("Z"))
					sqlQuery.append(IPsqlQuery.toString()+" union all "+OPsqlQuery.toString());
				else if (LoctionType.equals("IP")||LoctionType.equals("DC"))
					sqlQuery.append(IPsqlQuery.toString());
				else if (LoctionType.equals("OP")||LoctionType.equals("EM"))
					sqlQuery.append(OPsqlQuery.toString());
				stmt = con.prepareStatement (sqlQuery.toString())  ;

				/*System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~Check for Med Service~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("LoctionType =>"+LoctionType);
				System.out.println("LoctionCode =>"+LoctionCode);
				System.out.println("ViewList =>"+ViewList);
				System.out.println("PatientId =>"+PatientId);
				System.out.println("QueueId =>"+QueueId);
				System.out.println("QueueStatus =>"+QueueStatus);
				System.out.println("UnSheduled =>"+UnSheduled);
				System.out.println("PastVisit =>"+PastVisit);
				System.out.println("OPFromDate =>"+OPFromDate);
				System.out.println("IPFromDate =>"+IPFromDate);
				System.out.println("sqlQuery =>"+sqlQuery.toString());
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~End of Checking~~~~~~~~~~~~~~~~~~~~~~~~~~");*/
				System.out.println("sqlQuery =>"+sqlQuery.toString());		
				if ( (LoctionType.equals("IP")||LoctionType.equals("DC")||(LoctionType.equals("Z"))))
				{
					//System.err.println("by med service 1");
					stmt.setString(++count_bound_vars, locale);
					stmt.setString(++count_bound_vars, facilityId);
					System.err.println(count_bound_vars  + "==" + facilityId);
					stmt.setString(++count_bound_vars, practId);
					System.err.println(count_bound_vars  + "==" + practId);
			
					if (LoctionType.equals("IP") || LoctionType.equals("DC"))
					{
						stmt.setString(++count_bound_vars, LoctionType);
						System.err.println(count_bound_vars  + "==" + LoctionType);
						if (!(LoctionCode.equals("ALL")))
						{
							stmt.setString(++count_bound_vars, LoctionCode);
							System.err.println(count_bound_vars  + "==" + LoctionCode);
						}
					}
					else if(LoctionType.equals("Z") && (!LoctionCode.equals("ALL")))
					{
						stmt.setString(++count_bound_vars, LoctionCode);
						System.err.println(count_bound_vars  + "==" + LoctionCode);
					}

					if (!nationID.equals(""))
					{
						stmt.setString(++count_bound_vars, nationID);
						System.err.println(count_bound_vars  + "==" + nationID);
					}
				

					if (ViewList.equals("S"))
					{
						stmt.setString(++count_bound_vars, practId);
						System.err.println(count_bound_vars  + "==" + practId);
					}
					stmt.setString(++count_bound_vars, PatientId);
					System.err.println(count_bound_vars  + "==" + PatientId);
					stmt.setString(++count_bound_vars, QueueId);
					System.err.println(count_bound_vars  + "==" + QueueId);

					if (!adm_fromdate.equals(""))
					{
						stmt.setString(++count_bound_vars, adm_fromdate);
						System.err.println(count_bound_vars  + "==" + adm_fromdate);
					}
					
					if (!adm_todate.equals(""))
					{					
						stmt.setString(++count_bound_vars, adm_todate);
						System.err.println(count_bound_vars  + "==" + adm_todate);
					}
					if (Discharge.equals("N")||Discharge.equals(""))
					{					
					}
					else
					{
						if (!IPFromDate.equals(""))
						{
							stmt.setString(++count_bound_vars, IPFromDate);
							System.err.println(count_bound_vars  + "==" + IPFromDate);
						}
						if (!IPToDate.equals(""))
						{
							stmt.setString(++count_bound_vars, IPToDate);	
							System.err.println(count_bound_vars  + "==" + IPToDate);
						}
					}
				}
				if ( (LoctionType.equals("OP")||LoctionType.equals("EM")||(LoctionType.equals("Z"))) )
				{
					System.err.println("by med service 2");

		//OP SQL Query
							stmt.setString(++count_bound_vars, locale);
					stmt.setString(++count_bound_vars, facilityId);
					System.err.println(count_bound_vars  + "==" + facilityId);
					stmt.setString(++count_bound_vars, practId);
					System.err.println(count_bound_vars  + "==" + practId);

					if (LoctionType.equals("OP")||LoctionType.equals("EM"))
					{
						stmt.setString(++count_bound_vars, LoctionType);
						System.err.println(count_bound_vars  + "==" + LoctionType);
						if (!LoctionCode.equals("ALL"))
						{
							stmt.setString(++count_bound_vars, LoctionCode);
							System.err.println(count_bound_vars  + "==" + LoctionCode);
						}
					}
					else if(LoctionType.equals("Z") && (!LoctionCode.equals("ALL")))
					{
						stmt.setString(++count_bound_vars, LoctionCode); 
						System.err.println(count_bound_vars  + "==" + LoctionCode);
					}
					
					if (!nationID.equals(""))
					{
						stmt.setString(++count_bound_vars, nationID);
						System.err.println(count_bound_vars  + "==" + nationID);
					}
					
					if (ViewList.equals("S"))
					{
						stmt.setString(++count_bound_vars, practId);
						System.err.println(count_bound_vars  + "==" + practId);
					}
					stmt.setString(++count_bound_vars, PatientId);
					System.err.println(count_bound_vars  + "==" + PatientId);
					stmt.setString(++count_bound_vars, QueueId);
					System.err.println(count_bound_vars  + "==" + QueueId);

					
					if (QueueStatus.equals("")) 	
					{}
					else
	//					stmt.setString(++count_bound_vars, QueueStatus);
				
					if(!(UnSheduled.equals("Y")))
					{}
					else if(UnSheduled.equals("Y")) 
					{
						stmt.setString(++count_bound_vars, practId);
						System.err.println(count_bound_vars  + "==" + practId);
					}


					if (PastVisit.equals("N")||PastVisit.equals(""))
					{}
					else
					{
						if (!OPFromDate.equals(""))
						{
							stmt.setString(++count_bound_vars, OPFromDate);
							System.err.println(count_bound_vars  + "==" + OPFromDate);
						}
						if (!OPToDate.equals(""))
						{
							stmt.setString(++count_bound_vars, OPToDate);
							System.err.println(count_bound_vars  + "==" + OPToDate);
						}
					}
				}
				rset = stmt.executeQuery();
			}
			catch( Exception e ) 
			{ 
				System.out.println("Exception in ByService portion" + e);
				isError += e.toString() +"<br>"+ sqlQuery.toString(); 
				e.printStackTrace(System.err);
			}
			
		}
		try
		{
			if(rset!=null)
			{
				while( rset.next())
				{
					HashMap hash = new HashMap();
					hash.put ( "PATIENT_CLASS",( rset.getString ( field1 )==null?"" :rset.getString ( field1 )));
					hash.put ( "LOCN_CODE",( rset.getString ( field2 )		==null ?"" :rset.getString ( field2 )));
					hash.put ( "LOCN_SHORT_DESC",( rset.getString ( field3 ) ==null ?"" :rset.getString ( field3 )));
					patClassSet.add(rset.getString("PATIENT_CLASS"));
					arrlist.add( hash );
				 }
			}
		}
		catch(Exception e)
		{
			isError += e.toString() +"<br>"+ sqlQuery.toString() ; 
			e.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(rset!=null)  
					rset.close();
				if(stmt!=null)  
					stmt.close();
			}
			catch (Exception e)
			{}
		}
		
        return isError ;
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
		if(arrlist.size()>0)
		{
			for (int i=0; i<arrlist.size(); i++)
			{
				HashMap dat = (HashMap) arrlist.get(i) ;
				if(dat.get( "PATIENT_CLASS" ).equals(patientType))
				{
					HashMap opHash	 = new HashMap();
					opHash.put("LOCN_SHORT_DESC",dat.get( "LOCN_SHORT_DESC" ) );
					opHash.put("LOCN_CODE",dat.get( "LOCN_CODE" ) );
					returnArray.add(opHash);
				}
			}
		}
	return returnArray;
	}
}

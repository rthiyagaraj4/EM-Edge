/* 
---------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------
28/06/2018		IN065341	Prakash C	29/06/2018		Ramesh G			MMS-DM-CRF-0115
09/12/2019		IN071583	Ramesh G	09/12/2019		Ramesh G			PMG2019-GHL-CRF-0002
---------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.*;
import java.util.*;
import java.sql.* ;

import javax.naming.*;
import javax.rmi.*;
import eCA.Common.* ;
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;
import eCA.Common.CaAdapter;
import eOR.Common.* ;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;


public class CentralizedBean extends CaAdapter implements Serializable{
	
	public ArrayList getFacilityDetails(Connection con,String patient_id,String national_id,String alternate_id) throws Exception
	{
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		
		if(patient_id.equals(" ") || patient_id.equals("null")) patient_id = "";
		if(national_id.equals(" ") || national_id.equals("null")) national_id = "";
		if(alternate_id.equals(" ") || alternate_id.equals("null")) alternate_id = "";
		String sql = "";
		
		ArrayList facilityDetails	= new ArrayList() ;
		try 
		{
				sql = "BEGIN ? :=  EM_CDR_PTNT_CNT(?,?,?); end;";
				OracleCallableStatement cstmt = (OracleCallableStatement)con.prepareCall(sql);
				cstmt.registerOutParameter(1, OracleTypes.CURSOR);
				cstmt.setString(2,national_id);
				cstmt.setString(3,alternate_id);
				cstmt.setString(4,patient_id); //IN071583
				cstmt.execute();
				resultSet = (ResultSet)cstmt.getObject(1);
				
				for(int i = 0;  resultSet.next(); i++ ){
				  	String record[] = new String[5];
				    record[0] = checkForNull(resultSet.getString( "facility_id" ),"");
				    record[1] = checkForNull(resultSet.getString( "facility_name" ),"") ;
					record[2] = checkForNull(resultSet.getString( "patient_id" ),"") ;
					record[3] = checkForNull(resultSet.getString( "DB_sid" ),"") ;
					record[4] = checkForNull(resultSet.getString( "encntr_cnt" ),"") ;
					facilityDetails.add(record)  ;
				}	
		} catch( Exception e )	{
			System.err.println( "Error loading values from database FACILITY" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		return facilityDetails;
	}

	public ArrayList getDefaultCDRDateRange(Connection con,String resp_id,String RepDb) throws Exception
	{
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		
		String sql="";
		if(resp_id.equals(" ") || resp_id.equals("null")) resp_id = "";
		if(RepDb.equals(" ") || RepDb.equals("null")) RepDb = "";
		ArrayList CDRDateDetails	= new ArrayList() ;
		try 
		{
				sql="SELECT TO_CHAR ((SYSDATE - (NVL (CENTRALSED_DEFAULT_DAYS, 7))),'dd/mm/yyyy ') CENTRALSED_DEFAULT_DAYS,TO_CHAR (SYSDATE ,'dd/mm/yyyy ') CURRENT_DATE FROM CA_PARAM##REPDB## WHERE MODULE_ID = ?";	
				
				sql=sql.replaceAll("##REPDB##",RepDb);
				pstmt = con.prepareStatement(sql ) ;
				pstmt.setString( 1, resp_id );

				resultSet = pstmt.executeQuery() ;
				if( resultSet != null && resultSet.next() ) 
				{ 
					CDRDateDetails.add(resultSet.getString( "CENTRALSED_DEFAULT_DAYS" ))  ;
					CDRDateDetails.add(resultSet.getString( "CURRENT_DATE" ))  ;
				}
			} 
			catch( Exception e )	
			{
				System.err.println( "Error loading values from database getDefaultCDRDateRange" ) ;
				e.printStackTrace() ;
				throw e ;
			} 
			finally 
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			return CDRDateDetails;
	}


	public ArrayList getAllEncounters(Connection con,String patient_id,String facility_id,String from_date,String to_date,String RepDb) throws Exception
		{
			PreparedStatement pstmt 	= null;	
			ResultSet rs=null;
	
			String result = "";
			StringBuffer sql = new StringBuffer();
			if(patient_id.equals("") || patient_id==null) patient_id = "";
			if(facility_id.equals("") || facility_id==null) facility_id = "";
			if(from_date.equals("") || from_date==null) from_date = "";
			if(to_date.equals("") || to_date==null) to_date = "";
			if(RepDb.equals("") || RepDb==null) RepDb = "";
			ArrayList ResultDetail	= new ArrayList() ;
			try
			{
				 sql.append("SELECT a.patient_id,a.facility_id,a.encounter_id encounter_id,am_get_desc.am_patient_class##REPDB## (a.patient_class,?,'2') episode_type_desc,TO_CHAR (a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date,TO_CHAR (a.discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date_time,NVL(am_get_desc.am_practitioner##REPDB## (a.attend_practitioner_id,?, '2'),'') phy_prov_name,am_get_desc.am_service##REPDB## (a.service_code,?, '2') speciality,a.patient_class,REPLACE (REPLACE (DECODE ('en','en', b.patient_name, NVL ( b.patient_name_loc_lang,  b.patient_name)), '''',''), '''','') patient_name,to_number(to_char(visit_adm_date_time,'YYYYMMDDHH24MISS')) RR FROM pr_encounter ##REPDB## a, mp_patient ##REPDB## b WHERE a.patient_id = b.patient_id AND a.patient_id = ? AND ((A.patient_class IN ('IP', 'DC') AND a.adt_status not in ('00','09')) OR (A.patient_class IN ('OP','EM') AND a.visit_status not in ('01','02','99')))  AND a.visit_adm_date_time BETWEEN TO_DATE (?, 'dd/mm/yyyy')AND (TO_DATE (?, 'dd/mm/yyyy') + 0.99999) AND a.facility_id = ? order by RR desc");
				 
				result=sql.toString();
				result=result.replaceAll("##REPDB##",RepDb);
				pstmt = con.prepareStatement(result,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				
				pstmt.setString( 1 , language_id);
				pstmt.setString( 2 , language_id);
				pstmt.setString( 3 , language_id);
				pstmt.setString( 4 , patient_id);
				pstmt.setString( 5 , from_date);
				pstmt.setString( 6 , to_date);
				pstmt.setString( 7 , facility_id);
				
				rs	= pstmt.executeQuery();
				
				while(rs.next())
					{
							ArrayList SearchResult	= new ArrayList() ;
					/*0*/	SearchResult.add(rs.getString( "patient_id"));		//patient id
					/*1*/	SearchResult.add(rs.getString( "encounter_id"));	// encounter id
					/*2*/	SearchResult.add(rs.getString( "episode_type_desc")); //patient_class
					/*3*/	SearchResult.add(rs.getString( "visit_adm_date")); //visit_adm_date
					/*4*/	SearchResult.add(rs.getString( "discharge_date_time")); //visit_end_date
					/*5*/	SearchResult.add(rs.getString( "phy_prov_name"));	//attend_pract
					/*6*/	SearchResult.add(rs.getString( "speciality"));	// Med service
					/*7*/	SearchResult.add(rs.getString( "patient_class"));	// patient_class_id
					/*8*/	SearchResult.add(rs.getString( "facility_id"));	// facility_id
					/*9*/	SearchResult.add(rs.getString( "patient_name"));	// patient_name
							ResultDetail.add(SearchResult);
					}
			}	
			catch(Exception e){
				e.printStackTrace();		
			}
			finally
			{
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();

			}	
			return ResultDetail;
		}
		
	public void executeCDR(Connection con,String patient_id,String encounter_id,String RepDb,String table_name) throws Exception	
	{
		
		if(patient_id.equals("") || patient_id==null) patient_id = "";
		if(encounter_id.equals("") || encounter_id==null) encounter_id = "";
		if(RepDb.equals("") || RepDb==null) RepDb = "";
		
		CallableStatement	CDRTemp	=	null;
		String db_name="";
		if(!RepDb.equals("")){
			 db_name=RepDb.substring(1,RepDb.length());
		}			try
					{	
						
						long encounter = Long.parseLong(encounter_id);
						
						CDRTemp	=	con.prepareCall("{call Proc_Get_Clob_Data_CDR(?,?,?,?)}");
							
						CDRTemp.setString (1,patient_id);
						CDRTemp.setLong(2,encounter);
						CDRTemp.setString (3,db_name);
						CDRTemp.setString(4,table_name);
						CDRTemp.execute();
				}	
				catch(Exception e){
					e.printStackTrace();		
				}
				finally
				{
					if(CDRTemp != null)	CDRTemp.close();	
				}
		}		
}	

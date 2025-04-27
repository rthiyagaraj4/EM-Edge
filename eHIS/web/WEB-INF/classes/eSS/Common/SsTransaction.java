/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS.Common ;

import java.io.Serializable;
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.ArrayList;
import webbeans.eCommon.*;
import java.util.*;
public class SsTransaction extends eSS.Common.SsAdapter implements Serializable {
	private String accEntityId = "";
	//Frequently used transaction functions

	public String getAccEntityId (){
		return this.accEntityId;
	}

	public void setAccEntityId(String accEntityId) {
		this.accEntityId = accEntityId;
	}

	public boolean isDocNoAutoGenYN(String doc_type_code) throws Exception{
		return checkForNull((String)fetchRecord(eSS.Common.SsRepository.getSsKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"),doc_type_code).get("DOC_NUM_GEN_FLAG")).equals("Y");
	}
	
	// Return type changed from boolean to int on 17/1/2003
	// 0 - Process/1 - Doc Date should Not be > /2 - Doc Date should Not be <
	/*
		
	
	*/
	public int isValidDocDate(String doc_date)throws Exception{
		Connection connection = null;
		CallableStatement	callableStatement = null;
		int isValidDocDate = -1;
		try{
			connection = getConnection();
			callableStatement	= connection.prepareCall("{ call SS_VALIDATE_DOC_DATE(?,to_date(?,'dd/MM/yyyy'),?) }");
			callableStatement.setString(1, login_facility_id);
			callableStatement.setString(2, doc_date);
			callableStatement.registerOutParameter(3, Types.INTEGER);
			callableStatement.execute();
			isValidDocDate = callableStatement.getInt(3);
			//System.err.println("isValidDocDate----->"+isValidDocDate);
		}
		catch(Exception exception){
			throw exception;
		}
		finally{
			closeStatement(callableStatement);
			closeConnection(connection);
		}
		return isValidDocDate;
	}

	public String fetchNextDocNo(String doc_type_code) throws Exception{
		HashMap hmNextDocNo = fetchRecord(eSS.Common.SsRepository.getSsKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"), doc_type_code);
		//System.err.println(hmNextDocNo);
		return (String) hmNextDocNo.get("NEXT_DOC_NO");
	}

	public double getItemUnitCost(String item_code) throws Exception{
		return Double.parseDouble(fetchRecord(eSS.Common.SsRepository.getSsKeyValue("SQL_MM_ITEM_SELECT_UNIT_COST"), item_code).get("UNIT_COST").toString());
	}

	public String getDoc_type_code_ListOptions(String trn_type, String defaultDoc_type_code){
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_TRN_DOC_TYPE_SELECT_LIST"),alParameters), defaultDoc_type_code);
	}

	public String getPatientName(String stPatient_id) throws Exception{
		HashMap hmRecord = fetchRecord(eSS.Common.SsRepository.getSsKeyValue("SQL_MP_PATIENT_SELECT_SINGLE"), stPatient_id);
		return (String) hmRecord.get("PATIENT_NAME");
	}

	public String getGroupDescription(String group_code) throws Exception{
		HashMap hmRecord	=	fetchRecord(getSsRepositoryValue("SQL_SS_GROUP_SELECT_SINGLE"),group_code);
		return hmRecord.get("SHORT_DESC").toString();
	}

/*	
	public long getSterilizationCost(String stGroup_code) throws Exception{
		String sql=getSsRepositoryValue("SQL_SS_STERILIZATION_COST_SELECT_COST"); 
		return Long.parseLong( fetchRecord(sql, stGroup_code).get("STERILE_COST").toString());
	}
*/	
	
	public boolean hasGLParameter() throws Exception{
		boolean glParam = false;
		Connection connection = null;
		PreparedStatement preparedStatement	= null;
		ResultSet resultSet = null;
		String sql = (String)eSS.Common.SsRepository.getSsKeyValue("SQL_SS_ACC_ENTITY_PARAM_GL_SELECT");
		try{
			String gl_interface_yn = "";
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,getAccEntityId());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				gl_interface_yn = resultSet.getString(1);
			}
			glParam = gl_interface_yn.equals("Y");
			//System.err.println("glParam--->"+glParam);
		}
		catch(Exception exception){
			exception.printStackTrace();;
		}
		finally{
			closeStatement(preparedStatement);
			closeConnection(connection);
			closeResultSet(resultSet);
		}
		return glParam;
	}
	
	//Added by Martin on Thursday, April 17, 2003 11:39:12 AM
	public boolean isInternalRequest(String module_id, String report_id) {
		boolean bResult=false;
		try {
			String sql = (String)eSS.Common.SsRepository.getSsKeyValue("SQL_SM_REPORT_SELECT_INTERNAL_REQUEST");
			String param[] = { module_id,report_id};
			bResult=((HashMap)fetchRecord (sql, param)).get("INTERNAL_REQUEST_YN").toString().equals("Y");
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		return bResult;
	}

	public String getReportParameter( HashMap hmReportParameter){
		StringBuffer sbParameter	=	new StringBuffer();
        for(Iterator iterator = hmReportParameter.keySet().iterator(); iterator.hasNext();) {
            String ssKey = (String)iterator.next();
            String ssValue = (String)hmReportParameter.get(ssKey);
			sbParameter.append(ssKey);
			sbParameter.append("=");
			sbParameter.append(ssValue);
			sbParameter.append("+");
		}
		sbParameter.deleteCharAt(sbParameter.length()-1);
		return sbParameter.toString();
	}

	public String getURLString(HashMap hmParameters) {
        Connection connection = null;
		CallableStatement callableStatement = null;
        StringBuffer sbURL = new StringBuffer();

		try {
			HashMap hmReportParameter	=	(HashMap)hmParameters.get("report_parameter");
			String ssReport_server = checkForNull((String)hmParameters.get("report_server"));
            String ssReport_connect_string = checkForNull((String)hmParameters.get("report_connect_string"));
            String ssExecutable_name = "";
            String ssServer = "";
            String ssCopies = "";
//            String stReport_mode = "";
            String ssQueue_name = "";
//            String stReport_tool = "";
//            String stStatus = "";
            String ssMessage = "";
            String ssModule_id = (String)hmReportParameter.get("p_module_id");
            String ssReport_id = (String)hmReportParameter.get("p_report_id");
            String ssLocation_type = (String)hmParameters.get("location_type");
            String ssLocation_code = (String)hmParameters.get("location_code");
            String ssFacility_id = (String)hmReportParameter.get("p_facility_id");
            Properties properties = getProperties();
            String ssClient_ip_address = checkForNull(properties.getProperty("client_ip_address"));
            String ssReport_option = "P";
            String ss_app_server_ip = "";

			connection = getConnection();
            
			callableStatement = connection.prepareCall("{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }");
            callableStatement.setString(1, ssModule_id);
            callableStatement.setString(2, ssReport_id);
            callableStatement.setString(3, ssLocation_type);
            callableStatement.setString(4, ssLocation_code);
            callableStatement.setString(5, ssFacility_id);
            callableStatement.setString(6, ssClient_ip_address);
            callableStatement.setString(7, ssReport_option);
            callableStatement.registerOutParameter(8, Types.VARCHAR);
            callableStatement.registerOutParameter(9, Types.VARCHAR);
            callableStatement.registerOutParameter(10, Types.VARCHAR);
            callableStatement.registerOutParameter(11, Types.VARCHAR);
            callableStatement.registerOutParameter(12, Types.VARCHAR);
            callableStatement.registerOutParameter(13, Types.VARCHAR);
            callableStatement.registerOutParameter(14, Types.VARCHAR);
            callableStatement.registerOutParameter(15, Types.VARCHAR);
            callableStatement.registerOutParameter(16, Types.VARCHAR);
            callableStatement.execute();
            ssExecutable_name = callableStatement.getString(8);
            ssServer = callableStatement.getString(9);
            ssCopies = callableStatement.getString(10);
//            stReport_mode = callableStatement.getString(11);
            ssQueue_name = callableStatement.getString(12);
//            stReport_tool = callableStatement.getString(13);
//            stStatus = callableStatement.getString(14);
           ssMessage = callableStatement.getString(15);
            ss_app_server_ip = callableStatement.getString(16);
            ssReport_server = "http://" + ss_app_server_ip + ssReport_server;
			
			if(ssQueue_name.startsWith("\\\\\\\\")) {
                String s20 = ssQueue_name.substring(4);
                int i = s20.indexOf("\\\\");
                String s21 = s20.substring(0, i);
                String s22 = s20.substring(i + 2);
                String s24 = "\\\\" + s21 + "\\" + s22;
                ssQueue_name = s24;
            }

			sbURL.append(ssReport_server);
			sbURL.append("?report=");
			sbURL.append(ssExecutable_name);
			sbURL.append("+userid=");
			sbURL.append(ssReport_connect_string);
			sbURL.append("+server=");
			sbURL.append(ssServer);
			sbURL.append("+desname=");
			sbURL.append(ssQueue_name);
			sbURL.append("+copies=");
			sbURL.append(ssCopies);
			sbURL.append("+destype=printer+recursive_load=no+");
			sbURL.append(getReportParameter((HashMap) hmParameters.get("report_parameter")));
       }
        catch(Exception exception) {
            exception.printStackTrace();
        }
        finally {
            try { 
				if(callableStatement != null)
					callableStatement.close();
				if(connection != null)
					closeConnection(connection);
			}
            catch (Exception exception) {
            	exception.printStackTrace();
            }
        }
		return sbURL.toString();
    }
/*methods for invoking online report thread ends.*/


       public HashMap getSysdateMinusdays() throws Exception{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		HashMap SysdateMinusdays = new HashMap();

	
		try{
			 SysdateMinusdays = fetchRecord("SELECT TO_CHAR(SYSDATE,'DD/MM/RRRR')SYSTEMDATE , TO_CHAR(SYSDATE-7,'DD/MM/RRRR') SYSDATEMINUS7 FROM DUAL");
		   }

		catch(Exception e){
			e.printStackTrace();
		}
		finally {
                      try{
							closeResultSet(resultSet);
							closeStatement(pstmt);
							closeConnection(connection);
                         }
					  catch(Exception es){
				             es.printStackTrace();
                         }
		}
		return SysdateMinusdays;
	}

	 //Added by Sakti #Inc no:48848 on 30/04/2014
   	//Starts
   	public HashMap getDurationforStartDate() throws Exception{
   	 
   			  HashMap DurationforStartDate = new HashMap();
   		try{	 
   			DurationforStartDate =    fetchRecord("SELECT  NVL(DURN_FOR_START_DATE,0)DURN_FOR_START_DATE, TO_CHAR(SYSDATE,'DD/MM/YYYY')SYSTEMDATE ,TO_CHAR(SYSDATE-NVL(DURN_FOR_START_DATE,0), 'DD/MM/YYYY') DURATIONFORSTARTDATE   FROM  SS_FACILITY_PARAM   WHERE FACILITY_ID = ? ",getLoginFacilityId());	  	
   		   }catch(Exception e){
   			e.printStackTrace();
   		  }
   		  return DurationforStartDate;
   		
   	  }
   //ends

   public boolean isSiteSpecific(String moduleId, String functionalityId){//Adding start for TH-KW-CRF-0030
		boolean site=false;
	    Connection con	= null;  
        try{
        	con =			getConnection();		
        	site = eCommon.Common.CommonBean.isSiteSpecific(con,moduleId,functionalityId);	
		}
        catch(Exception e){
            e.printStackTrace();
        }
		finally{
			try{
			closeConnection(con);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return site;
   }
   public String getSysdate(){//getting system date
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sys_date				= "";

		try{
			connection				= getConnection() ;
			String str_qry			= "SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY hh24:mi') TODAY_DATE_TIME FROM DUAL";
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				sys_date=resultSet.getString(1);
			}
		}
		catch ( Exception e ) {
			sys_date= sys_date+e.toString();
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return sys_date;
	}

   public String getExpiryDate(String group_code) throws Exception {
        Connection connection = null;
		PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		PreparedStatement pstmt1 = null;
        ResultSet resultSet1 = null;
		PreparedStatement pstmt2 = null;
        ResultSet resultSet2 = null;
		String sql ="";
		String sel_sql ="";
		String expiry_date="";
		String sterilize_reqd_yn="N";
		String durn_value ="0";
		String durn_type ="D";
try{

			connection = getConnection() ;

			sel_sql ="SELECT STERILIZE_REQD_YN,STERILE_LIFE DURATION , STERILE_LIFE_UNIT DURATION_TYPE FROM SS_GROUP A,SS_STERILIZATION_TYPE B WHERE A.DEF_STERILE_TYPE = STERILE_TYPE AND A.GROUP_CODE =?";
             pstmt1				= connection.prepareStatement(sel_sql) ;
			 System.err.println("group_code@@@=="+group_code);
			 pstmt1.setString(1,group_code);
			 resultSet1			= pstmt1.executeQuery();
			 if(resultSet1!=null && resultSet1.next()){
				sterilize_reqd_yn=resultSet1.getString("STERILIZE_REQD_YN")==null?"N":resultSet1.getString("STERILIZE_REQD_YN");
				durn_value=resultSet1.getString("DURATION")==null?"0":resultSet1.getString("DURATION");
				durn_type=resultSet1.getString("DURATION_TYPE")==null?"D":resultSet1.getString("DURATION_TYPE");
			}
		System.err.println("sterilize_reqd_yn=="+sterilize_reqd_yn+"durn_value=="+durn_value+"durn_type=="+durn_type);
			if(sterilize_reqd_yn.equals("N")){
				pstmt2				= connection.prepareStatement("SELECT NVL(DFLT_STERILE_LIFE,0) DURATION FROM SS_ACC_ENTITY_PARAM");
			    resultSet2			= pstmt2.executeQuery();
			 if(resultSet2!=null && resultSet2.next()){
				durn_value=resultSet2.getString("DURATION")==null?"0":resultSet2.getString("DURATION");
				durn_type="L";
				 System.err.println("durn_value from entity param==="+durn_value+"durn_type=="+durn_type);
			   }
			}
   
			sql ="SELECT TO_CHAR((CASE WHEN 'D' = ? THEN (TO_DATE(SYSDATE, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?) WHEN 'W' = ? THEN (TO_DATE(SYSDATE, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?)*7 WHEN 'L' = ? THEN (TO_DATE(SYSDATE, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?)*30 WHEN 'Y' = ? THEN (TO_DATE(SYSDATE, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?)*365 WHEN 'H' = ? THEN (TO_DATE(SYSDATE, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?)/24  WHEN 'M' = ? THEN (TO_DATE(SYSDATE, 'DD/MM/RRRR HH24:MI')) + TO_NUMBER(?)/(24*60)END), 'DD/MM/RRRR HH24:MI') END_DATE FROM DUAL ";
				
			pstmt				= connection.prepareStatement(sql) ;
			pstmt.setString(1,durn_type);
			pstmt.setString(2,durn_value);
			pstmt.setString(3,durn_type);
			pstmt.setString(4,durn_value);
			pstmt.setString(5,durn_type);
			pstmt.setString(6,durn_value);
			pstmt.setString(7,durn_type);
			pstmt.setString(8,durn_value);
			pstmt.setString(9,durn_type);
			pstmt.setString(10,durn_value);
			pstmt.setString(11,durn_type);
			pstmt.setString(12,durn_value);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				expiry_date=resultSet.getString("END_DATE")==null?"":resultSet.getString("END_DATE");
			}
			if(expiry_date.equals(""))
                 expiry_date =getSysdate();
				
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeResultSet( resultSet2 ) ;
				closeStatement( pstmt2 ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return expiry_date;
	}//Adding end for TH-KW-CRF-0030
}

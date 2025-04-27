/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import eCommon.Common.CommonBean;
import eOT.Common.OTAdapter;


public class AT_AnaesthesiaHistoryBean extends OTAdapter implements Serializable{

	String	locale=null;
	Properties	p	=	null;
	public ArrayList getUntowardEvtsDtls(String oper_num){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		String sql="SELECT B.SHORT_DESC DESCRP,A.ACTION_REMARKS ACT_REM,A.GEN_REMARKS GEN_REM FROM OT_POST_OPER_UNTOWARD A,OT_UNUSUAL_OCCUR_CODE B WHERE  A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND  A.UNUSUAL_OCCUR_CODE = B.UNUSUAL_OCCUR_CODE";
		ArrayList list = new ArrayList();
		HashMap map = null;
		try{
			connection = getConnection();
			if(pstmt!=null) pstmt.close();
			if(resultSet!=null) resultSet.close();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,oper_num);
			resultSet= pstmt.executeQuery();
			while(resultSet.next()){	
				map = new HashMap();
				map.put("untoward_event", resultSet.getString("DESCRP"));
				map.put("action_remarks",CommonBean.checkForNull(resultSet.getString("ACT_REM")));
				map.put("general_remarks",CommonBean.checkForNull(resultSet.getString("GEN_REM")));
				list.add(map);
			}						
		}catch (Exception e){
			  System.err.println("Err Msg in  loadUntowardEvents() : "+e.getMessage());
		}
		finally{
		  try{
                closeResultSet(resultSet) ;
                closeStatement(pstmt) ;
                closeConnection(connection);
		  }catch(Exception e){}
		}
		return list;
	 }

	 public ArrayList getPersonnelDtls(String anaesthesia_srl_no){
		Connection connection = null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		ResultSet resultSet  = null;
		ResultSet rset  = null;
		String personnel_sql = "SELECT B.ROLE_DESC,C.PRACTITIONER_NAME,A.PRACTITIONER_ID FROM  AT_PERSONNEL A, OT_ROLES_LANG_VW B, AM_PRACTITIONER_LANG_VW C WHERE C.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID='"+locale+"' AND A.OPERATING_FACILITY_ID =? AND A.ANAESTHESIA_SERIAL_NUM =? AND	 A.PRACT_TYPE = B.ROLE_TYPE AND A.PRACTITIONER_ID = C.PRACTITIONER_ID AND A.ROLE_ID=B.ROLE_ID";
		String positional_desc="SELECT B.POSITION_DESC FROM AM_PRACTITIONER_LANG_VW A,AM_POSITION B WHERE A.LANGUAGE_ID='"+locale+"' AND  PRACTITIONER_ID = ? AND  A.POSITION_CODE=B.POSITION_CODE(+)";
		ArrayList list = new ArrayList();
		String position_desc = "";
		try{
			connection = getConnection();
			if(pstmt!=null) pstmt.close();
			if(resultSet!=null) resultSet.close();
			if(rset!=null) rset.close();	//Added Against Common-ICN-0031
			pstmt = connection.prepareStatement(personnel_sql);
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,anaesthesia_srl_no);
			resultSet= pstmt.executeQuery();
			while(resultSet.next()){	
				HashMap map = new HashMap();
				map.put("role",resultSet.getString(1));
				map.put("surgeon",resultSet.getString(2));
				pstmt1 = connection.prepareStatement(positional_desc);
				pstmt1.setString(1,resultSet.getString(3));
				rset= pstmt1.executeQuery();
				while(rset.next()){	
					
					position_desc = CommonBean.checkForNull(rset.getString(1));
				}
				if(pstmt1!=null) pstmt1.close(); //Common-ICN-0053
				if(rset!=null) rset.close();
				map.put("position",position_desc);
				list.add(map);
			}
			if(pstmt!=null) pstmt.close();
			if(resultSet!=null) resultSet.close();
		}catch (Exception e){
			  
			  System.err.println("Err Msg in  loadPersonnelDetails : "+e.getMessage());
		}
		finally{
		  try{
                closeResultSet(rset) ;
                closeResultSet(resultSet) ;
                closeStatement(pstmt) ;
                closeConnection(connection);
		  }catch(Exception e){}
		  return list;
		}
	 }

	public ArrayList getPreMorbidDtls(String anaesthesia_srl_no){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		String premorbid_sql = "SELECT B.LONG_DESC,A.REMARKS  FROM  AT_RECORD_PREOP_PREMORBID A, AT_PREMORBID_MAST B WHERE A.OPERATING_FACILITY_ID =? AND A.ANAESTHESIA_SERIAL_NUM =? AND	 A.PREMORBID_CODE = B.PREMORBID_CODE";
		ArrayList list = new ArrayList();
		try{
			connection = getConnection();
			if(pstmt!=null) pstmt.close();
			if(resultSet!=null) resultSet.close();
			pstmt = connection.prepareStatement(premorbid_sql);
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,anaesthesia_srl_no);
			resultSet= pstmt.executeQuery();
			while(resultSet.next()){	
				HashMap map = new HashMap();
				map.put("premorbid",CommonBean.checkForNull(resultSet.getString(1)));
				map.put("remarks",CommonBean.checkForNull(resultSet.getString(2)));
				list.add(map);
			}
			if(pstmt!=null) pstmt.close();
			if(resultSet!=null) resultSet.close();
		}catch (Exception e){
			  System.err.println("Err Msg in getPreMorbidDtls() "+e.getMessage());
		}
		finally{
		  try{
                closeResultSet(resultSet) ;
                closeStatement(pstmt) ;
                closeConnection(connection);
		  }catch(Exception e){}
		  return list;
		}
	 }

	 public HashMap getBMIDtls(String anaesthesia_srl_no){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		String BMI = "";
		String BMIDesc = "";
		String anaesthesia="";
		String anaesthesia_code=""; 
		

		String bmi_sql = "SELECT  HEIGHT HEIGHT1,WEIGHT WEIGHT1,BSA BSA1,BMI BMI1,ANAESTHESIA_CODE ANAESTHESIA_CODE1,TO_CHAR(START_TIME,'DD/MM/YYYY HH24:MI') START_TIME1,TO_CHAR(END_TIME,'DD/MM/YYYY HH24:MI') END_TIME1,TO_CHAR(RECOVERY_START_TIME,'DD/MM/YYYY HH24:MI') REC_STA_TIME,  TO_CHAR(RECOVERY_END_TIME,'DD/MM/YYYY HH24:MI') REC_END_TIME FROM AT_ANAESTHESIA_RECORD_HDR WHERE OPERATING_FACILITY_ID =?  AND ANAESTHESIA_SERIAL_NUM=?";

		String bmi_desc_sql ="SELECT STATUS_DESC  STATUS_DESC1 from AT_BMI_ANALYSIS WHERE ? BETWEEN MIN_VALUE AND MAX_VALUE";
		
		String anaesthesia_desc_sql="SELECT SHORT_DESC SHORT_DESC1 FROM AM_ANAESTHESIA WHERE ANAESTHESIA_CODE=?";

		HashMap map = new HashMap();
		try{
				
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			map.put("properties", p);
			connection = getConnection();
			if(pstmt!=null) pstmt.close();
			if(resultSet!=null) resultSet.close();
			pstmt = connection.prepareStatement(bmi_sql);
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,anaesthesia_srl_no);
			resultSet= pstmt.executeQuery();
			while(resultSet.next()){	
				map.put("height",CommonBean.checkForNull(resultSet.getString("HEIGHT1")));
				map.put("weight",CommonBean.checkForNull(resultSet.getString("WEIGHT1")));
				map.put("bsa",CommonBean.checkForNull(resultSet.getString("BSA1")));
				BMI  = CommonBean.checkForNull(resultSet.getString("BMI1"));
				anaesthesia_code = CommonBean.checkForNull(resultSet.getString("ANAESTHESIA_CODE1"));
				map.put("start_time_anes",CommonBean.checkForNull(resultSet.getString("START_TIME1")));
				map.put("end_time_anes",CommonBean.checkForNull(resultSet.getString("END_TIME1")));
				map.put("start_time_rec",CommonBean.checkForNull(resultSet.getString("REC_STA_TIME")));
				map.put("end_time_rec",CommonBean.checkForNull(resultSet.getString("REC_END_TIME")));
			}
			if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
			if(resultSet!=null) resultSet.close();	//Added Against Common-ICN-0031
			if(anaesthesia_code.intern()!=""){
				pstmt = connection.prepareStatement(anaesthesia_desc_sql);
				pstmt.setString(1,anaesthesia_code);
				resultSet= pstmt.executeQuery();
				while(resultSet.next()){	
					anaesthesia = resultSet.getString(1);

				}
			}
			
			if(BMI.intern()!=""){
				pstmt = connection.prepareStatement(bmi_desc_sql);
				pstmt.setString(1,BMI);
				resultSet= pstmt.executeQuery();
				while(resultSet.next()){	
					//map.put("bmi",resultSet.getString(1));
					BMIDesc = resultSet.getString(1);
				 }
			}
			if(pstmt!=null) pstmt.close();
			if(resultSet!=null) resultSet.close();
			map.put("bmi",BMIDesc);
			map.put("anaesthesia",anaesthesia);
		}catch (Exception e){
			  System.err.println("Err Msg in getBMIDtls() "+e.getMessage());
		}
		finally{
		  try{
                closeResultSet(resultSet) ;
                closeStatement(pstmt) ;
                closeConnection(connection);
		  }catch(Exception e){}
		  return map;
		}
	 }

}

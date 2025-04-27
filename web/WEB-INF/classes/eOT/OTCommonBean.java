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
import eOT.Common.OTAdapter;
import eOT.Common.OTRepository;
import eCommon.Common.CommonBean;
import java.util.Properties;
import com.ehis.util.DateUtils;
import java.util.*;
import java.io.*;
import java.sql.* ;
import org.json.simple.*;

public class OTCommonBean extends OTAdapter implements Serializable {
	HashMap operation_dtls = null;
	String notes_speciality_code = "";
	Properties	p = this.properties;
	String	locale	= "";

	public OTCommonBean() {
        try {
			doCommon();
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
		}catch(Exception e) {}
	}
	public void doCommon() throws Exception {}

	public void clear(){
		operation_dtls = null;
	}

	public void setSpecialityCodeForNotes(String speciality_code){
		this.notes_speciality_code = speciality_code;
	}
	public String getSpecialityCodeForNotes(){
		return this.notes_speciality_code;
	}

	public String getSysDateTime(){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		String curr_date		= "";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				curr_date = resultSet.getString("CURRENT_DATE");
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return curr_date;
	}
	public ArrayList getOTStatusColors(){
		ArrayList result = new ArrayList();
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_SELECT1")) ;
			pstmt.setString(1,locale);
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				result.add(resultSet.getString("STATUS_CODE"));
				result.add(resultSet.getString("STATUS_DESC"));
				result.add(resultSet.getString("COLOR_IND"));
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){}
        }
		return result;
	}

	//getNoteTypes

	public ArrayList getNoteTypes(){
		ArrayList result = new ArrayList();
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_SELECT14")) ;
			pstmt.setString(1, this.notes_speciality_code);
			pstmt.setString(2, "10");
			pstmt.setString(3, locale);
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				result.add(resultSet.getString("NOTE_TYPE"));
				result.add(resultSet.getString("NOTE_TYPE_DESC"));
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){}
        }
		return result;
	}

	//getPatientDtlsCodes

public ArrayList getPatientDtlCodes(String oper_num){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		ArrayList patient_id_list = new ArrayList();
		try{
			connection = getConnection();
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_SELECT2")) ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, oper_num);
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){

				patient_id_list.add(resultSet.getString(1)); //0 patient_id
				patient_id_list.add(resultSet.getString(2)); //1 episode_id
				patient_id_list.add(resultSet.getString(3)); //2 encounter_id
				patient_id_list.add(resultSet.getString(4)); //3 ward_code
				patient_id_list.add(resultSet.getString(5)); //4 oper_room_code
				patient_id_list.add(resultSet.getString(6)); //5 booking_num
				patient_id_list.add(resultSet.getString(7)); //6 surgeon_code
				patient_id_list.add(resultSet.getString(8)); //7 anesthetist_code
				patient_id_list.add(resultSet.getString(9)); //8 documentation_level
				patient_id_list.add(resultSet.getString(10)); //9 patient_class
				patient_id_list.add(resultSet.getString(11)); //10 episode_type
				patient_id_list.add(resultSet.getString(12)); //11 ref_source_type
				patient_id_list.add(resultSet.getString(13)); //12 ref_source_code
				patient_id_list.add(resultSet.getString(14)); //13 post_oper_diag
				patient_id_list.add(resultSet.getString(15)); //14 ANESTHESIA_CODE
				patient_id_list.add(resultSet.getString(16)); //15 SPECIALITY_CODE
				patient_id_list.add(resultSet.getString(17)); //16 PRE_OPER_DIAG
				patient_id_list.add(resultSet.getString(18)); //17 RECOVERY_START_TIME
				patient_id_list.add(resultSet.getString(19)); //18 RECOVERY_END_TIME
				patient_id_list.add(resultSet.getString(20));//19 TRFR_TO
				patient_id_list.add(resultSet.getString(21));//20 TRFR_WARD_CODE
				patient_id_list.add(resultSet.getString(22));//21 EXTUBATED_OR_INTUBATED
				patient_id_list.add(resultSet.getString(23));//22 OPER_DATE
				patient_id_list.add(resultSet.getString(24));//23 visit_id
				patient_id_list.add(resultSet.getString(25));//24 recovery_room_code(for chkoutrecoveryroom)

				
							
			}
		}catch (Exception e){
		 e.printStackTrace();
		}finally{
			    try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}catch(Exception e){}
		}
		return patient_id_list;
   }


   public String getAgeInYrs(String dob){
	    Connection connection = null;
		PreparedStatement pstmt=null;
		String age="";
		ResultSet resultSet  = null;
		//String SQL="SELECT to_char(TO_NUMBER(SYSDATE-TO_DATE(?,'DD/MM/YYYY'))/365,'990') from dual";
		//String SQL="SELECT ROUND(MONTHS_BETWEEN(SYSDATE,TO_DATE(?,'DD/MM/YYYY'))/12) AGE FROM DUAL";
		//String SQL="SELECT MONTHS_BETWEEN(TO_DATE('02/01/2002','DD/MM/YYYY'),TO_DATE('01/01/2002','DD/MM/YYYY')  AGE FROM DUAL";
		try{
			connection = getConnection();
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_SELECT15")) ;
			pstmt.setString(1,dob) ;
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){
		       age = resultSet.getString(1);
			}
		}catch (Exception e){
		 e.printStackTrace();
		}
		finally{
		  try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
		  }catch(Exception e){}
		}
		return age+"Yrs";
 }


  //getPatientDtls
   public ArrayList getPatientDtls(String patient_id){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ArrayList patient_id_list = new ArrayList();
		ResultSet resultSet  = null;
		try{
			connection = getConnection();
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_SELECT3")) ;
			pstmt.setString(1, patient_id);
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){
				patient_id_list.add(resultSet.getString(1)); // 0 shortName
				patient_id_list.add(resultSet.getString(2)); // 1 dateOfBirth
				patient_id_list.add(resultSet.getString(3)); // 2 sex
				patient_id_list.add(resultSet.getString(4)); // 3 race Code
			}
		}catch (Exception e){
		 e.printStackTrace();
		}finally{
			    try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}catch(Exception e){}
		}
		return patient_id_list;
   }

 public String getSurgeonDesc(String surgeonCode){
		Connection connection = null;
		PreparedStatement pstmt=null;
		String surgeonDesc="";
		ResultSet resultSet  = null;
		try{
			connection = getConnection();
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_SELECT4")) ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, surgeonCode);
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){
		        surgeonDesc = resultSet.getString(1);
			}
		}catch (Exception e){
		 e.printStackTrace();
		}
		finally{
		  try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
		  }catch(Exception e){}
		}
		return surgeonDesc;
 }

 public String getAnaesthetistDesc(String anaesthetistCode){
		Connection connection = null;
		PreparedStatement pstmt=null;
		String anaesthetistDesc="";
		ResultSet resultSet  = null;
		try{

			//Modified by DhanasekarV against the issue IN024357 on Date 20/10/2010
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection = getConnection();
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_SELECT5")) ;
			pstmt.setString(1, locale);
			//pstmt.setString(1, login_facility_id);
			pstmt.setString(2, anaesthetistCode);
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){
		        anaesthetistDesc = resultSet.getString(1);
			}
		}catch (Exception e){
		 e.printStackTrace();
		}
		finally{
		  try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
		  }catch(Exception e){}
		}
		return anaesthetistDesc;
 }

 public void loadOperationDtls(String oper_num){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		HashMap result = null;
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection = getConnection();
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_SELECT6")) ;
			pstmt.setString(1,locale);
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3, oper_num);
			resultSet= pstmt.executeQuery();
			int index = 0;
			if(operation_dtls==null)
				operation_dtls = new HashMap();
			else{
				operation_dtls = null;
				operation_dtls = new HashMap();
			}
			while(resultSet.next()){				
				index++;
				result = new HashMap();
				result.put("operation_code",resultSet.getString("OPER_CODE")); //1 OPER_CODE
				result.put("operation_desc",resultSet.getString("OPER_DESC")); //1 OPER_CODE MMS-QH-CRF-0199
				result.put("side_applicable",resultSet.getString("RIGHT_LEFT_FLAG")); //4 
				result.put("remarks",resultSet.getString("OPER_REMARKS")); //2 OPER_REMARKS		
				result.put("oper_line_num",resultSet.getString("OPR_LN_NUM")); 
				result.put("order_id",resultSet.getString("ORD_ID")); 
				result.put("oper_line_status",resultSet.getString("OPER_LINE_STATUS")); //new added for CRF 224 BY Suma on 24/04/09
				result.put("cancel_remarks",resultSet.getString("CANCEL_REMARKS")); //new added for CRF 224 BY Suma on 24/04/09
				operation_dtls.put(index+"",result);			
			}			
		}catch (Exception e){
		 e.printStackTrace();
		}
		finally{
		  try{
                closeResultSet(resultSet) ;
                closeStatement(pstmt) ;
                closeConnection(connection);
		  }catch(Exception e){}
		}
 }


 public String getBookingStartTime(String booking_num){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet = null;
		String start_time="";
		try{
			connection = getConnection();
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_SELECT7")) ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, booking_num);
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){
		        start_time = resultSet.getString(1);
			}
		}catch (Exception e){
		 e.printStackTrace();
		}
		finally{
		  try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
		  }catch(Exception e){}
		}
		return start_time;
 }

 public ArrayList getNursingUnitCode(String patient_id,String encounter_id){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		ArrayList nursing_unit_list = new ArrayList();
		try{
			connection = getConnection();
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_SELECT8")) ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, encounter_id);
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){
				nursing_unit_list.add(resultSet.getString(1)); // 0 assign_care_locn_type
				nursing_unit_list.add(resultSet.getString(2)); // 1 assign_care_locn_code
				nursing_unit_list.add(resultSet.getString(3)); // 2 speciality_code
			}
		}catch (Exception e){
		 e.printStackTrace();
		}
		finally{
		  try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
		  }catch(Exception e){}
		}

		return nursing_unit_list;
 }
 public String getTheatreDesc(String oper_room_code){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		String oper_room_desc="";
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection = getConnection();
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_SELECT9")) ;
			pstmt.setString(1, locale);
			pstmt.setString(2, oper_room_code);
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){
		        oper_room_desc = resultSet.getString(1);
			}
		}catch (Exception e){
		 e.printStackTrace();
		}
		finally{
		  try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
		  }catch(Exception e){}
		}
		return oper_room_desc;
 }

 //newly added method on 10/04/2005 
 //if it is null  disable the record vital otherwise enable record vital button in Holding area 

 public String getDISCR_MSR_ID(String speciality_code){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		String DISCR_MSR_ID="";
		try{
			connection = getConnection();
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_SELECT13")) ;
			pstmt.setString(1,speciality_code);
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){
			  DISCR_MSR_ID = resultSet.getString(1);
			}
		}catch (Exception e){
		 e.printStackTrace();
		}
		finally{
		  try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
		  }catch(Exception e){}
		}
		return DISCR_MSR_ID;
 }

 public String getAnaesthesiaDesc(String anaesthesiaCode){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		String anaesthesiaDesc="";
		try{
			connection = getConnection();
			pstmt	   = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHEKIN_SELECT5")) ;
			pstmt.setString(1,anaesthesiaCode);
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){
				anaesthesiaDesc = resultSet.getString(1);
			}
		}catch (Exception e){
		 e.printStackTrace();
		}
		finally{
		  try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		  }catch(Exception e){}
		}
		return anaesthesiaDesc;
	}

 public String getSpecialityDesc(String speciality_code){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		String specialityDesc="";
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection = getConnection();
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_SELECT10")) ;
			pstmt.setString(1,speciality_code);
			pstmt.setString(2,locale);
			resultSet  = pstmt.executeQuery();
			while(resultSet.next()){
			  specialityDesc = resultSet.getString(1);
			}
		}catch (Exception e){
		 e.printStackTrace();
		}
		finally{
		  try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
		  }catch(Exception e){}
		}
		return specialityDesc;
 }
 public String getNursingUnitDesc(String care_location_code){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet  = null;
	String nursing_unit_desc="";
	try{
		p=getProperties();
		locale	= (String) p.getProperty("LOCALE");
		connection = getConnection();
		pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_SELECT11")) ;
		pstmt.setString(1,login_facility_id);
		pstmt.setString(2,care_location_code);
		pstmt.setString(3,locale);
		resultSet  = pstmt.executeQuery();
		while(resultSet.next()){
		  nursing_unit_desc = resultSet.getString(1);
		}
	}catch (Exception e){
		 e.printStackTrace();
	}
	finally{
	  try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
	  }catch(Exception e){}
	}
	return nursing_unit_desc;
 }

	public void loadBookingDtls(String booking_num){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet = null;
		HashMap result = null;
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection = getConnection();
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_SELECT12")) ;
			pstmt.setString(1,locale);
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3, booking_num);
			resultSet = pstmt.executeQuery();
			int index = 0;
			if(operation_dtls==null)
				operation_dtls = new HashMap();
			while(resultSet.next()){				
				index++;
				result = new HashMap();
				result.put("line_num",resultSet.getString("LINE_NUM")); //0 LINE_NUM
				result.put("operation_code",resultSet.getString("OPER_CODE")); //1 OPER_CODE
				result.put("operation_desc",resultSet.getString("SHORT_DESC")); //2 OPER_DESC
				result.put("side_applicable",resultSet.getString("APPL_RIGHT_LEFT_FLAG")); //3 APPL_RIGHT_LEFT_FLAG
				result.put("remarks",resultSet.getString("OPER_REMARKS")); //4 OPER_REMARKS				
				operation_dtls.put(index+"",result);
			}
		}catch (Exception e){
		 e.printStackTrace();
		}
		finally{
		  try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		  }catch(Exception e){}
		}
	}
	
	public void recordOperationDtls(HashMap hmap){
		if(operation_dtls==null)
			operation_dtls = new HashMap();
		int rowId = (operation_dtls.size())+1;
		operation_dtls.put(rowId+"",hmap);
	}

	public HashMap getOperationDtls(){
		if (operation_dtls==null)
			return new HashMap();
		else
			return operation_dtls;
	}

    public void updateOperationDtls(String key, HashMap hmap){
		if(operation_dtls.containsKey(key))
		operation_dtls.put(key,hmap);

	}

	public void removeOperationDtls(String key){
		HashMap temp_map = new HashMap();
		int count = 0;
		for(int i=1;i<=operation_dtls.size();i++){
			if(i!=Integer.parseInt(key)){
				count++;
				temp_map.put(count+"",operation_dtls.get(i+""));
			}
		}
		operation_dtls = temp_map;
	}
	
	//Added against MO-CRF-20086-US1 starts Here
	public ArrayList getORCategoryType(){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet  = null;
		ArrayList result = new ArrayList();
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection = getConnection();
			//connection = getConnection();		//Commented Against Common-ICN-0031
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_OR_CATEGORY_TYPE")) ;
			pstmt.setString(1,locale);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()){				
				result.add(resultSet.getString("ALPHANUM_VALUE"));
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				closeResultSet(resultSet) ;
                closeStatement(pstmt) ;
                closeConnection(connection);			
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		System.err.println("getORCategoryType->result-->"+result);
		return result;
	}	
	
	//Added Against TH-KW-CRF-0126 Starts	
	public ArrayList getInsuranceDesc(String patient_id,String episode_id,String visit_id,String patient_class,String facilityid,String orderId){
		CallableStatement callableStatement =   null;
		Connection connection				=   null;
		ResultSet resultSet		= null;	
		/* Array facilityArray						=	null;
		Array moduleArray						=	null;
		Array orderArray						=	null;
		Array orderLineArray					=	null;
		Array statusArray						=	null; */
		
		Array facilityArray = null;
		Array moduleArray = null;
		Array orderArray = null;
		Array orderLineArray = null;
		Array statusArray =null;
		
		String insuranceOrCash                         ="";
		String order_id                         ="";
		String order_line_no                = "";
		String status                           ="";
		 String insurance_status_desc ="";
		 String [] temp_order;
		 String order ="";
		 ArrayList result = new ArrayList();
		 try{
		  connection = getConnection();
		callableStatement	= connection.prepareCall("{ call blinstransactions.get_approval_status_enc_ot(?,?,?,?,?,?,?,?,?,?,?,?) }"); 
					 System.err.println("OT Bean login_facility_id=="+facilityid+"patient_id=="+patient_id+"patient_class"+patient_class+"episode_id=="+episode_id+"visit_id=="+visit_id);
					callableStatement.setString(1, facilityid);
					callableStatement.setString(2, patient_id);
					callableStatement.setString(3, patient_class);
					callableStatement.setString(4, episode_id);
					callableStatement.setString(5, visit_id);
					callableStatement.registerOutParameter(6, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");  
			        callableStatement.registerOutParameter(7, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			        callableStatement.registerOutParameter(8, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
        			callableStatement.registerOutParameter(9, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER"); 
		        	callableStatement.registerOutParameter(10, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR1");
					callableStatement.registerOutParameter(11, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
					callableStatement.registerOutParameter(12,  Types.VARCHAR);
					callableStatement.execute();
					 facilityArray						=	callableStatement.getArray (6); 
		             moduleArray						=	callableStatement.getArray (7); 
		             orderArray						    =	callableStatement.getArray (8); 
		             orderLineArray					    =	callableStatement.getArray (9); 
		             statusArray						=	callableStatement.getArray (10); 
					 insuranceOrCash	=	(String)(callableStatement.getString(12));
					Object[] facilityValues                 =   (Object[]) facilityArray.getArray(); 
					Object[] moduleValues                   =   (Object[]) moduleArray.getArray(); 
					Object[] orderValues                    =   (Object[]) orderArray.getArray(); 
					Object[] oderLineValues                 =   (Object[]) orderLineArray.getArray(); 
					Object[] statusValues                   =   (Object[]) statusArray.getArray();
					System.err.println("facilityValues : "+facilityValues);
					System.err.println("moduleValues : "+moduleValues);
					System.err.println("orderValues : "+orderValues);
					System.err.println("oderLineValues : "+oderLineValues);
					System.err.println("statusValues : "+statusValues);
					System.err.println("insuranceOrCash : "+insuranceOrCash);
				if(facilityValues!=null)
	               {
					   System.err.println("-----Not Null----------");
					   System.err.println("facilityValues.length : "+facilityValues.length);
					   System.err.println("moduleValues.length : "+moduleValues.length);
					   System.err.println("oderLineValues.length : "+oderLineValues.length);
					   System.err.println("statusValues.length : "+statusValues.length);
	            	 for (int i=0; i < facilityValues.length; i++)                 
		              {
						  System.err.println("-----If--------- ");
						 String module_id = (String)moduleValues[i];
						 System.err.println("module_id===>"+module_id);
						 if(module_id.equals("OR") || module_id.equals("OT")){
							 order_id = (String)orderValues[i];
							 System.err.println("orderId===>"+orderId);
							 System.err.println("order_id===>"+order_id);
							 if(orderId.equals(order_id))
							 {
								 System.err.println("IF----------------");
							 order_line_no = String.valueOf(oderLineValues[i]);
							 System.err.println("order_line_no===>"+order_line_no);
							 status = (String)statusValues[i];
							System.err.println("status===>"+status);
							if(status.equals("P"))
								insurance_status_desc = "Pending";
							else if(status.equals("A"))
								insurance_status_desc = "Approved";
							else if(status.equals("R"))
								insurance_status_desc = "Rejected";
							else if(status.equals("H"))
								insurance_status_desc = "Hold";
							else if(status.equals("C"))
								insurance_status_desc = "Clarification";
							else if(status.equals("S"))
								insurance_status_desc = "Sent to Insurance";
							else if(status.equals("PR"))
								insurance_status_desc = "Partially Rejected";
									 System.err.println("order_id=="+order_id+"order_line_no=="+order_line_no+"insurance_status_desc==="+insurance_status_desc);
							// result.add(order_id+order_line_no);
							 result.add(order_id);
							 result.add(order_line_no);
							 result.add(insurance_status_desc);
							 result.add(insuranceOrCash);
                            System.err.println("----------------------------------------p_id=="+patient_id+"e_no=="+episode_id+"insurance_status_desc==="+insurance_status_desc);
                            System.err.println("result : "+result);
							 }
						 }
					  }
				   }
					
					}
	  catch (Exception e) {
		e.printStackTrace();
	  }
	  finally{
		  try{	
				closeStatement(callableStatement); //CheckStyle issue 19-05-2023
				closeConnection( connection );		
			}
			catch(Exception e){
				e.printStackTrace();
			}		   
	  }
	  return result;
	}
	  
	  public String getPatientPayment(String facilityId, String moduleID, String keyMain, String keyLineNo){
		Connection connection   = null ;
		CallableStatement callPayment = null;
        String paymentStatus		= "";
		try{
			System.err.println("----------------------------------------facilityId=="+facilityId+"moduleID=="+moduleID+"keyMain==="+keyMain+"keyLineNo====>"+keyLineNo);
                            
			connection			= getConnection() ;
			String paymentStatusQuery="{?=call BLINSTRANSACTIONS.get_payment_status_for_ot(?,?,?,?)}";
		
			callPayment= connection.prepareCall(paymentStatusQuery);
			callPayment.registerOutParameter(1,java.sql.Types.VARCHAR);
			callPayment.setString(2,facilityId);
			callPayment.setString(3,moduleID);
			callPayment.setString(4,keyMain);
			callPayment.setString(5,keyLineNo);
			callPayment.execute();
			paymentStatus=callPayment.getString(1);
			System.err.println("paymentStatus :"+paymentStatus);
			connection.commit();
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
				closeStatement( callPayment ); //CheckStyle issue 19-05-2023
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return paymentStatus;
	} 
	 //Added Against TH-KW-CRF-0126 Ends 
	 //Added Against ML-MMOH-CRF-1939-US1...starts
		 public String getIncludeFpp(String facility_id){
			Connection connection = null;
			PreparedStatement pstmt=null;
			ResultSet resultSet  = null;
			String Include_Fpp_yn = "";
			try{
				String sql = " SELECT INCLUDE_FPP_YN FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID ='"+facility_id+"' ";
				connection = getConnection();
				pstmt = connection.prepareStatement(sql) ;
				resultSet=pstmt.executeQuery();
			    while(resultSet.next()){
				Include_Fpp_yn = checkForNull(resultSet.getString(1));
			    }			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					closeResultSet(resultSet) ;
	                closeStatement(pstmt) ;
	                closeConnection(connection);			
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			System.err.println("getIncludeFpp->Include_Fpp_yn-->"+Include_Fpp_yn);
			return Include_Fpp_yn;
		}
	//Added Against ML-MMOH-CRF-1939-US1...ends	
	//Added Against ML-MMOH-CRF-1939-US2 and US3...starts
		 public String getFPPDetails(Connection con,String facilityId,String episodeType,String encounter_id) throws Exception{
				
				CallableStatement callStmt = null;
				//ResultSet rs 				= null;  //audit log 19-09-2022
				//String sql					= ""; //audit log 19-09-2022
				String isFPPPatientYN		= "";
				try{
					//long encounter_id = Long.parseLong(encounter_id);
					callStmt = con.prepareCall("{? = call blcommon.fpp_patient_yn(?,?,?,?)}");
					callStmt.registerOutParameter(1,java.sql.Types.VARCHAR);

					callStmt.setString(2, facilityId);
					callStmt.setString(3, episodeType);
					callStmt.setString(4, encounter_id);
					callStmt.registerOutParameter(5,java.sql.Types.VARCHAR);

					callStmt.execute();
					isFPPPatientYN 		= callStmt.getString(1);
				}catch(Exception ex){
					ex.printStackTrace();
				}finally{
					try{
						
						if(callStmt!=null)callStmt.close();
					}catch(Exception ex){
						System.err.println("Exception in getFPPDetails method  - "+ex.getMessage());
						ex.printStackTrace();
					}
				}
				return isFPPPatientYN;
			} 

public String getPatientEncounterDetails(Connection con, String facility_id, String encounter_id) throws Exception{
				PreparedStatement pstmt	= null;
				ResultSet rs 			= null;
				String sql					= "";
				String patient_class		= "";
				String episode_Type			= "";
				try{
					sql = "SELECT patient_class FROM pr_encounter WHERE facility_id = ? AND encounter_id = ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,encounter_id);
					rs = pstmt.executeQuery();

					if(rs!=null && rs.next()){

							patient_class = rs.getString("patient_class");

					}
				if(patient_class.equals("IP"))
						episode_Type="I";
				else if(patient_class.equals("DC"))
						episode_Type="D";
				else if(patient_class.equals("OP"))
						episode_Type="O";
				else if(patient_class.equals("EM"))
						episode_Type="E";
				else
						episode_Type="";	
				}catch(Exception ex){
					ex.printStackTrace();
				}finally{
					try{
						if(rs!=null)rs.close();
						if(pstmt!=null)pstmt.close();
					}catch(Exception ex){
						System.err.println("Exception in getPatientEncounterDetails - "+ex.getMessage());
						ex.printStackTrace();
					}
				}
				return episode_Type;
			}
	//Added Against ML-MMOH-CRF-1939-US2 and US3...ends
	public Integer getFppIcon(){
	PreparedStatement pstmt	= null;
	ResultSet rs 			= null;
	Connection conn = null;
	String sql="";
	int count = 0; 
	try{
	    conn = getConnection();
		sql="select count(*) from mp_pat_banner_dtl where ELMT_REF = 'FPP_ICON'";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			count = rs.getInt(1);
		}
	   }catch(Exception e){
			System.err.println(e);		
		}finally{		
			try{
				closeResultSet(rs); //CheckStyle issue 19-05-2023
                closeStatement(pstmt) ;
                closeConnection(conn);			
			}catch(Exception e){
				e.printStackTrace();
			}
		}	    
        return count;
    }		 

	public boolean getBillFlag(String facility_id){
		
	Connection conn  = null ;
	CallableStatement cstmt = null;
	String bl_installed="";
	String err_text = "";
	String bl_interface="";
	boolean bill_flag = false;
	try{
		conn = getConnection();
		//for checking whether the Billing module is installed or not
		//ORDERING_FACILITY_ID,FACILITY_ID ,P_BL_INSTALLED,P_BL_INTERFACED ,P_ERROR_FLAG,P_ERROR_CODE, P_ERROR_MESG
		cstmt=conn.prepareCall("{call OT_BL_CHECK_INSTALL(?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,facility_id );
		cstmt.setString(2,facility_id );
		cstmt.registerOutParameter(3,Types.VARCHAR);
		cstmt.registerOutParameter(4,Types.VARCHAR);
		cstmt.registerOutParameter(5,Types.VARCHAR);
		cstmt.registerOutParameter(6,Types.VARCHAR);
		cstmt.registerOutParameter(7,Types.VARCHAR);
		cstmt.registerOutParameter(8,Types.VARCHAR);//LANG_ERR_MESG_ID
		cstmt.execute();
		if(!checkForNull(cstmt.getString(5)).equals("Y")){
			bl_installed=cstmt.getString(3);
			bl_interface=cstmt.getString(4);
			bill_flag = ( bl_installed.equals("Y") && bl_interface.equals("Y") )?true:false;
		}else
		{
			//err_text = cstmt.getString(7);
			err_text = cstmt.getString(8);
		}
	}catch(Exception e){
		e.printStackTrace();
	    	System.err.println("Error PreOperativeChkListDtlsFrames.jsp:"+e);
   }finally{
		try{
			closeStatement(cstmt) ;
            closeConnection(conn);
		}catch(Exception e){
			e.printStackTrace();
		    System.err.println("Finally Block OTCommonBean.java:"+e);
		}
    }
	return bill_flag;
	}
	//Added Against ML-MMOH-CRF-1939-US1...ends

 /*Added by Arthi for ML-MMOH-CRF-1936*/
    public static JSONArray getSurNurMandatoryYN(Connection con, String facilityid) throws Exception{
			
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		JSONArray arrJSON		= new JSONArray();
		JSONObject jsonObj = new JSONObject();

		try{

			sql = "SELECT anes_proc_start_end_time_yn, anes_start_end_time_yn, surgery_start_end_time_yn, preparation_start_end_time_yn, record_surgeon_notes_yn, record_nursing_notes_yn FROM ot_param_for_facility where OPERATING_FACILITY_ID ='"+facilityid+"' ";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs!=null && rs.next()){

				String anes_proc_start_end_time_yn = rs.getString("anes_proc_start_end_time_yn")==null?"":rs.getString("anes_proc_start_end_time_yn");
				String anes_start_end_time_yn = rs.getString("anes_start_end_time_yn")==null?"":rs.getString("anes_start_end_time_yn");
				String surgery_start_end_time_yn = rs.getString("surgery_start_end_time_yn")==null?"":rs.getString("surgery_start_end_time_yn");
				String preparation_start_end_time_yn = rs.getString("preparation_start_end_time_yn")==null?"":rs.getString("preparation_start_end_time_yn");
				String record_surgeon_notes_yn = rs.getString("record_surgeon_notes_yn")==null?"":rs.getString("record_surgeon_notes_yn");
				String record_nursing_notes_yn = rs.getString("record_nursing_notes_yn")==null?"":rs.getString("record_nursing_notes_yn");

				jsonObj.put("anes_proc_start_end_time_yn",anes_proc_start_end_time_yn);
				jsonObj.put("anes_start_end_time_yn",anes_start_end_time_yn);
				jsonObj.put("surgery_start_end_time_yn",surgery_start_end_time_yn);
				jsonObj.put("preparation_start_end_time_yn",preparation_start_end_time_yn);
				jsonObj.put("record_surgeon_notes_yn",record_surgeon_notes_yn);
				jsonObj.put("record_nursing_notes_yn",record_nursing_notes_yn);
				arrJSON.add(jsonObj);
			}

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getSurNurMandatoryYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return arrJSON;
	}

	public static int getTimeandDtlTabCnt(Connection con, String oper_num, String facilityid) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rset 			= null;
		int timedtl_cnt			= 0;

		try
		{
			String sql = "SELECT COUNT (*) timedtl_cnt FROM ot_post_oper_dtl2 WHERE oper_num = '"+oper_num+"' AND operating_facility_id = '"+facilityid+"' AND (  anest_proc_start_time || anest_proc_end_time || anest_start_time || anest_end_time || prep_start_time || prep_end_time || surg_start_time ||  surg_end_time) IS NOT NULL";

			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while(rset!=null && rset.next())
			{
				timedtl_cnt = rset.getInt("timedtl_cnt");
			}	
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try
			{
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getTimeandDtlTabCnt - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return timedtl_cnt;
	}
   /*End ML-MMOH-CRF-1936*/
	
	public String getUpdateNoteCheckboxValue(String facility_id){
		Connection connection = null;
			PreparedStatement pstmt=null;
			ResultSet resultSet  = null;
			String Update_Notes = "";
			try{
				String sql = " SELECT ALLOW_TO_UPDATE FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID ='"+facility_id+"' ";
				connection = getConnection();
				pstmt = connection.prepareStatement(sql) ;
				resultSet=pstmt.executeQuery();
			    while(resultSet.next()){
				Update_Notes = checkForNull(resultSet.getString(1));
			    }			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					closeResultSet(resultSet) ;
	                closeStatement(pstmt) ;
	                closeConnection(connection);			
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			System.err.println("Update_Notes-->"+Update_Notes);
			return Update_Notes;
	}
}

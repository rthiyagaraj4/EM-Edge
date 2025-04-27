/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
import java.sql.Types;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import eCommon.Common.CommonBean;
import eOT.Common.OTAdapter;
import eOT.Common.OTRepository;
import java.util.Hashtable;
import java.util.ArrayList;
import java.io.Serializable;
import eOT.CheckIn.CheckInHome;
import eOT.CheckIn.CheckInRemote;
import javax.rmi.PortableRemoteObject ;
import javax.naming.InitialContext ;
import java.util.Properties;
import com.ehis.util.DateUtils;

public class CheckInBean extends OTAdapter implements Serializable {
	HashMap checkin_hdr = null;
	HashMap post_oper_dtls = null;
	Properties	p = this.properties;
	String	locale	= "";

public CheckInBean() {
	try {
		doCommon();
	}catch(Exception e) {}
}

public void doCommon() throws Exception {
	locale	= (String) p.getProperty("LOCALE");
}

public void clear(){
	super.clear();
	post_oper_dtls = null;
	checkin_hdr=null;
}
		
public void setAll(Hashtable hash){

	locale = getProperties().getProperty("LOCALE");
	if(checkin_hdr == null)
		checkin_hdr = new HashMap();
	mode = (String)hash.get("mode");	
	String pre_oper_diag=(String)hash.get("diagnosis");
	String trim_pre_oper_diag=pre_oper_diag.replace("\"","");
	checkin_hdr.put("slate_user_id",(String)hash.get("slate_user_id"));
	checkin_hdr.put("patient_class",(String)hash.get("patient_class"));
	//checkin_hdr.put("surgery_date",(String)hash.get("surgery_date"));
	checkin_hdr.put("surgery_date",DateUtils.convertDate((String)hash.get("surgery_date"),"DMY",locale,"en"));
	checkin_hdr.put("order_id",CommonBean.checkForNull((String)hash.get("order_id"),""));
	checkin_hdr.put("booking_no",(String)hash.get("booking_no"));
	checkin_hdr.put("waitlist_no",CommonBean.checkForNull((String)hash.get("waitlist_no"),""));
	checkin_hdr.put("patient_id",(String)hash.get("patient_id"));
	checkin_hdr.put("episode_type",(String)hash.get("episode_type"));
	checkin_hdr.put("encounter_id",(String)hash.get("encounter_id"));
	checkin_hdr.put("episode_id",(String)hash.get("episode_id"));
	checkin_hdr.put("nature_type",(String)hash.get("nature_type"));
	checkin_hdr.put("nature_code",(String)hash.get("nature_code"));
	checkin_hdr.put("speciality_code",(String)hash.get("speciality_code"));
	checkin_hdr.put("operation_status",(String)hash.get("operation_status"));
	checkin_hdr.put("surgeon_code",(String)hash.get("surgeon_code"));
	checkin_hdr.put("anesthetist_code",(String)hash.get("anesthetist_code"));
	checkin_hdr.put("anaesthesia_code",(String)hash.get("anaesthesia_code"));
	checkin_hdr.put("oper_room_code",(String)hash.get("oper_room_code"));
	checkin_hdr.put("order_type_code",(String)hash.get("order_type_code"));
	//checkin_hdr.put("pre_oper_diag",(String)hash.get("diagnosis"));
	checkin_hdr.put("pre_oper_diag",trim_pre_oper_diag);
	checkin_hdr.put("source_code",(String)hash.get("source_code"));
	checkin_hdr.put("source_type",(String)hash.get("source_type"));
	checkin_hdr.put("check_in_time",(String)hash.get("check_in_time"));
	checkin_hdr.put("all_speciality_code",(String)hash.get("all_speciality_code"));
	checkin_hdr.put("visit_id",(String)hash.get("visit_id"));
	checkin_hdr.put("called_from",(String)hash.get("called_from"));
	checkin_hdr.put("asst_surgeon_code1",(String)hash.get("asst_surgeon_code1")); //Newly added by rajesh on 30/08
	checkin_hdr.put("asst_surgeon_code2",(String)hash.get("asst_surgeon_code2")); //Newly added by rajesh on 30/08
	checkin_hdr.put("anaes_review1",(String)hash.get("anaes_review1"));//Added by sanjay for Anaesthesia Required Checkbox against IN032063	
	checkin_hdr.put("checkinBookingFlag",(String)hash.get("checkinBookingFlag"));//186
}

public HashMap validate() throws Exception {
	HashMap map = new HashMap() ;
	String message = "";
	// Keep here all the Database Validations/Alerts/Warnings before commiting the transaction.
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", message ) ;
	return map;
}
public HashMap insert(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) );

	ArrayList mandatory_flds	=	new ArrayList();
	mandatory_flds.add(login_by_id);
	mandatory_flds.add(login_at_ws_no);
	mandatory_flds.add(login_facility_id);

	HashMap tabData	= new HashMap();
	HashMap sqlMap	= new HashMap();
	String	called_from	= (String)checkin_hdr.get("called_from");
	try {
			tabData.put("properties", getProperties());
			tabData.put("mandatory_flds",mandatory_flds);
			tabData.put("checkin_hdr",checkin_hdr);
			tabData.put("post_oper_dtls",post_oper_dtls);
			tabData.put("patient_class",(String)checkin_hdr.get("patient_class"));
			tabData.put("booking_no",(String)checkin_hdr.get("booking_no"));			
		if(called_from!=null && called_from.equals("OT_SLATE"))
			tabData.put("user_id_to_insert",(String)checkin_hdr.get("slate_user_id"));
		else 
			tabData.put("user_id_to_insert",login_by_id);
			sqlMap.put( "SQL_OT_POST_OPER_HDR_INSERT", OTRepository.getOTKeyValue("SQL_OT_POST_OPER_HDR_INSERT") );
			sqlMap.put( "SQL_OT_POST_OPER_DTLS_INSERT", OTRepository.getOTKeyValue("SQL_OT_POST_OPER_DTLS_INSERT") );
			sqlMap.put( "SQL_OT_COMMON_QRY_SELECT1", OTRepository.getOTKeyValue("SQL_OT_COMMON_QRY_SELECT1") ); // to get the episode_type
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OTRepository.getOTKeyValue("JNDI_OT_CHECKIN"),CheckInHome.class,getLocalEJB());
			//Get the remote object by invoking create method on the home object using reflection
			Object busObj =	(home.getClass().getMethod("create",null)).invoke(home,null);
			//Create an object array, which will be passed as argument to the method call
			Object argArray[]  = new Object[2];
				   argArray[0] = tabData;
				   argArray[1] = sqlMap;

			//Create a class array, containing the class types of the arguments passed
			Class [] paramArray	   = new Class[2];
					 paramArray[0] = tabData.getClass();
					 paramArray[1] = sqlMap.getClass();

			//Invoke the business method on the EJB using the argument array, class	array and reflection
			HashMap result =(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			//Call to remove the EJB
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			//Nullify the class and the object arrays
			argArray = null;
			paramArray = null;

			//Now Clean up the containers passed to the EJB
			tabData.clear();
			sqlMap.clear();
		
		if( ((Boolean) result.get( "result" )).booleanValue() )	{
			map.put("flag","1");
			map.put("result", new Boolean(true) ) ;
			map.put("message", getMessage((String) result.get( "msgid" )) ) ;
			clear();
		}else {
			map.put("flag","0");
			map.put( "result",new Boolean(false)) ;
			map.put( "message",(String) result.get( "msgid" )  ) ;
		}
		post_oper_dtls = null;
		checkin_hdr=null;
	}
	catch(Exception e) {
		map.put("message",e.toString());
		e.printStackTrace() ;
	}
	finally {
		clear();
		post_oper_dtls = null;
		checkin_hdr=null;
		try {}
		catch( Exception ee ){
		ee.printStackTrace() ;
			map.put( "message", ee.getMessage() ) ;
		}
	}
	return map ;
}

public void recordOperationDtls(HashMap hmap){
	if(post_oper_dtls==null)
		post_oper_dtls = new HashMap();
	int rowId = (post_oper_dtls.size())+1;
	post_oper_dtls.put(rowId+"",hmap);
}

public HashMap getOperationDtls()
{
	if (post_oper_dtls==null)
		return new HashMap();
	else
		return post_oper_dtls;
}

public void updateOperationDtls(String key, HashMap hmap){
	if(post_oper_dtls.containsKey(key))
	post_oper_dtls.put(key,hmap);

}

public void removeOperationDtls(String key){
	HashMap temp_map = new HashMap();
	int count = 0;
	for(int i=1;i<=post_oper_dtls.size();i++){
		if(i!=Integer.parseInt(key)){
			count++;
			temp_map.put(count+"",post_oper_dtls.get(i+""));
		}
	}
	post_oper_dtls = temp_map;
}

// Start of methods invoked in JSP files
 public String getPatientId(String booking_num){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet   = null;
	String patientId="";
	try{
		connection = getConnection();
		pstmt	   = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_COMMON_QRY_SELECT2")) ;
		pstmt.setString(1, login_facility_id);
		pstmt.setString(2, booking_num);
		resultSet  = pstmt.executeQuery();
		while(resultSet.next()){
			patientId = resultSet.getString(1);
		}
	}
	catch (Exception e){
		e.printStackTrace() ;
	}
	finally{
	  try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
	  }catch(Exception e){}
	}
	return patientId;
}

public ArrayList getPatientDtls(String patient_id){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet  = null;
	ArrayList patient_id_list = new ArrayList();

	try{
		connection = getConnection();
		pstmt	   = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHEKIN_SELECT1")) ;
		pstmt.setString(1, patient_id);
		resultSet  = pstmt.executeQuery();
		while(resultSet.next()){
			patient_id_list.add(resultSet.getString(1)); // shortName
			patient_id_list.add(resultSet.getString(2)); // dateOfBirth
			patient_id_list.add(resultSet.getString(3)); // sex
			patient_id_list.add(resultSet.getString(4)); // race Code
		}
	}
	catch (Exception e){
		e.printStackTrace() ;
	}finally{
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception e){}
	}
	return patient_id_list;
}

public ArrayList getCheckInDtlsBasedOnBooking(String bookingNo){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet = null;
	ArrayList checkin_list_arr = new ArrayList();
	String 	locale	= (String) p.getProperty("LOCALE");
	try{
		connection = getConnection();		
		pstmt  = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHEKIN_SELECT2")) ;
		pstmt.setString(1, locale);
		pstmt.setString(2, locale);
		pstmt.setString(3, login_facility_id);
		pstmt.setString(4, bookingNo);  
		resultSet  = pstmt.executeQuery();
		while(resultSet.next()){				
			checkin_list_arr.add(bookingNo);//0 BOOKING NO
			checkin_list_arr.add(resultSet.getString("BOOKING_DATE"));//1 BOOKING_DATE
			checkin_list_arr.add(resultSet.getString("WAITLIST_NUM"));//2 WAITLIST_NUM
			checkin_list_arr.add(resultSet.getString("ORDER_ID"));//3 ORDER_ID
			checkin_list_arr.add(resultSet.getString("NATURE_CODE"));//4 NATURE_CODE
			checkin_list_arr.add(resultSet.getString("NATURE_TYPE"));//5 NATURE_TYPE
			checkin_list_arr.add(resultSet.getString("PATIENT_CLASS"));//6 PATIENT_CLASS
			checkin_list_arr.add(resultSet.getString("EPISODE_TYPE"));//7 EPISODE_TYPE
			checkin_list_arr.add(resultSet.getString("ENCOUNTER_ID"));//8 ENCOUNTER_ID
			checkin_list_arr.add(resultSet.getString("EPISODE_ID"));//9 EPISODE_ID
			checkin_list_arr.add(resultSet.getString("VISIT_ID"));//10 VISIT_ID
			checkin_list_arr.add(resultSet.getString("TEAM_DOCTOR_CODE"));//11 TEAM_DOCTOR_CODE
			checkin_list_arr.add(resultSet.getString("ANAESTHESIA_CODE"));//12 ANAESTHESIA_CODE
			checkin_list_arr.add(resultSet.getString("ANAESTHETIST1_CODE"));//13ANAESTHETIST1_CODE
			checkin_list_arr.add(resultSet.getString("SPECIALITY_CODE"));//14 SPECIALITY_CODE
			checkin_list_arr.add(resultSet.getString("SOURCE_CODE"));//15 SOURCE_CODE
			checkin_list_arr.add(resultSet.getString("SOURCE_TYPE"));//16 SOURCE_TYPE
			checkin_list_arr.add(resultSet.getString("OPER_ROOM_CODE"));//17 OPER_ROOM_CODE
			checkin_list_arr.add(resultSet.getString("ORDER_TYPE_CODE"));//18 ORDER_TYPE_CODE
			checkin_list_arr.add(resultSet.getString("PATIENT_ID"));//19  PATIENT_ID
			checkin_list_arr.add(resultSet.getString("PRE_OPER_DIAG"));//20  PRE_OPER_DIAG
			checkin_list_arr.add(resultSet.getString("ASST_SURGEON_DESC"));//21  ASST_SURGEON_DESC							
			checkin_list_arr.add(resultSet.getString("ASST_SURGEON_CODE"));//22  ASST_SURGEON_CODE
			checkin_list_arr.add(resultSet.getString("ASST_SURGEON_DESC_2"));//23  ASST_SURGEON_DESC							
			checkin_list_arr.add(resultSet.getString("ASST_SURGEON_CODE_2"));//24  ASST_SURGEON_CODE
		}		
	}catch (Exception e){
		e.printStackTrace();
	}finally{
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception e){}
	}
	return checkin_list_arr;
}

public ArrayList getCheckInDtlsBasedOnOrder(String order_id)
{
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet = null;
	ArrayList checkin_list_arr = new ArrayList();
	try
	{
		connection = getConnection();
		pstmt  = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHEKIN_SELECT11")) ;
		pstmt.setString(1,order_id); 
		resultSet  = pstmt.executeQuery();
		while(resultSet.next())
		{	
			checkin_list_arr.add(order_id);//0 order_id
			checkin_list_arr.add(resultSet.getString("ORDER_TYPE_CODE"));//1 ORDER_TYPE_CODE 
			checkin_list_arr.add(resultSet.getString("PATIENT_ID"));//2 PATIENT_ID		
			checkin_list_arr.add(resultSet.getString("EPISODE_TYPE"));//3 EPISODE_TYPE			
			checkin_list_arr.add(resultSet.getString("PATIENT_CLASS"));//4 PATIENT_CLASS
			checkin_list_arr.add(resultSet.getString("EPISODE_ID"));//5 EPISODE_ID
			checkin_list_arr.add(resultSet.getString("ENCOUNTER_ID"));//6 ENCOUNTER_ID
			checkin_list_arr.add(resultSet.getString("VISIT_ID"));//7 VISIT_ID
			checkin_list_arr.add(resultSet.getString("ORDER_DATE_TIME"));//8 ORDER_DATE_TIME
			checkin_list_arr.add(resultSet.getString("NATURE_TYPE"));//9 NATURE_TYPE
			checkin_list_arr.add(resultSet.getString("NATURE_CODE"));//10NATURE_CODE
			checkin_list_arr.add(resultSet.getString("SOURCE_TYPE"));//11 SOURCE_TYPE
			checkin_list_arr.add(resultSet.getString("SOURCE_CODE"));//12 SOURCE_CODE(WARD_CODE)
			// not needed here  because we got from parameter 
			checkin_list_arr.add(resultSet.getString("ANAESTHETIST_CODE"));//13ANAESTHETIST_CODE
			checkin_list_arr.add(resultSet.getString("ANAESTHESIA_CODE"));//14 ANAESTHESIA_CODE
			checkin_list_arr.add(resultSet.getString("SPECIALITY_CODE"));//15 SPECIALITY_CODE
			checkin_list_arr.add(resultSet.getString("PRE_OPER_DIAG"));//16  PRE_OPER_DIAG
			checkin_list_arr.add(resultSet.getString("PERFORMING_TEAM_SURGEON"));//17 SURGEON_CODE
		}
	}
	catch (Exception e)
	{
		e.printStackTrace() ;
	}
	finally
	{
		try
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	return checkin_list_arr;
}

public String getSpecialityCodeWhenNull(String order_type_code){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet  = null;
	String specialtyCode="";
	try{
		connection = getConnection();
		pstmt	   = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHEKIN_SELECT13")) ;
		pstmt.setString(1, order_type_code); 
		resultSet  = pstmt.executeQuery();
		while(resultSet.next()){
			specialtyCode = resultSet.getString("SPECIALITY_CODE");
		}
	}catch (Exception e){
		e.printStackTrace() ;
	}
	finally{
	  try{
		closeResultSet( resultSet ) ;
		closeStatement( pstmt ) ;
		closeConnection( connection );
	  }catch(Exception e){}
	}
	return specialtyCode;
}

public String getPreOperativeDiagnosis(String order_id){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet  = null;
	String diagnosis="";
	Clob clob_notes_content = null;
	try{
		connection = getConnection();
		pstmt   = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHEKIN_SELECT14"));
		pstmt.setString(1,order_id);
		resultSet=pstmt.executeQuery();
		while( resultSet.next() ){
			clob_notes_content	= resultSet.getClob(1);//ORDER_COMMENT
			if(clob_notes_content!=null){
				diagnosis = clob_notes_content.getSubString(1,500).trim();
			}
		}
		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
		  try{
			closeResultSet( resultSet );
			closeStatement( pstmt );
			closeConnection( connection );
		  }catch(Exception e){
			e.printStackTrace();
		  }
		}
	return CommonBean.checkForNull(diagnosis);
}

public String getSpecialtyCode(String patientId, String encounterId){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet  = null;
	String specialtyCode="";
	try{
		connection = getConnection();
		pstmt	   = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHEKIN_SELECT3")) ;
		pstmt.setString(1, login_facility_id);
		pstmt.setString(2, patientId);
		pstmt.setString(3, encounterId);
		resultSet  = pstmt.executeQuery();
		while(resultSet.next()){
			specialtyCode = resultSet.getString(1);
		}
	}catch (Exception e){
		e.printStackTrace();
	}
	finally{
	  try{
		closeResultSet( resultSet );
		closeStatement( pstmt );
		closeConnection( connection );
	  }catch(Exception e){}
	}
	return specialtyCode;
}

public String getSurgeonDesc(String surgeonCode){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet   = null;
	String surgeonDesc="";
	locale	= (String) p.getProperty("LOCALE");
	try{
		connection = getConnection();
		pstmt	   = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHEKIN_SELECT4")) ;
		pstmt.setString(1, locale);
		pstmt.setString(2, surgeonCode);
		resultSet  = pstmt.executeQuery();
		while(resultSet.next()){
			surgeonDesc = resultSet.getString(1);
		}
	}catch (Exception e){
		e.printStackTrace();
	}finally{
	  try{
		closeResultSet( resultSet );
		closeStatement( pstmt );
		closeConnection( connection );
	  }catch(Exception e){}
	}
	return surgeonDesc;
}

public String getAnaesthetistDesc(String anaesthetistCode){
	locale	= (String) p.getProperty("LOCALE");
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet  = null;
	String anaesthetistDesc="";
	try{
		connection = getConnection();
		pstmt	   = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHEKIN_SELECT4"));
		//pstmt.setString(1, login_facility_id);
		pstmt.setString(1, locale);
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
		closeResultSet( resultSet );
		closeStatement( pstmt );
		closeConnection( connection );
	  }catch(Exception e){}
	}
	return anaesthetistDesc;
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
		closeResultSet( resultSet );
		closeStatement( pstmt );
		closeConnection( connection );
	  }catch(Exception e){
		  e.printStackTrace() ;
	  }
	}
	return anaesthesiaDesc;
}

public String getSpecialityDesc(String specialityCode){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet  = null;
	String specialityDesc="";
	try{
		p=getProperties();
		locale	= (String) p.getProperty("LOCALE");
		connection = getConnection();
		pstmt	   = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHEKIN_SELECT6")) ;
		pstmt.setString(1,specialityCode);
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
		closeResultSet( resultSet );
		closeStatement( pstmt );
		closeConnection( connection );
	  }catch(Exception e){
		e.printStackTrace() ;
	  }
	}
	return specialityDesc;
}

public String getWardDesc(String wardCode){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet  = null;
	String nursingUnitDesc="";
	try{
		p=getProperties();
		locale	= (String) p.getProperty("LOCALE");
		connection = getConnection();
		pstmt	   = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHEKIN_SELECT7")) ;
		pstmt.setString(1,wardCode);
		pstmt.setString(2,locale);
		pstmt.setString(3,login_facility_id);
		resultSet  = pstmt.executeQuery();
		while(resultSet.next()){
			nursingUnitDesc = resultSet.getString(1);
		}
	}catch (Exception e){
		e.printStackTrace();
	}
	finally{
	  try{
		closeResultSet( resultSet ) ;
		closeStatement( pstmt );
		closeConnection( connection );
	  }catch(Exception e){
		e.printStackTrace() ;
	  }
	}
	return nursingUnitDesc;
}

//get Encounter,Ward,speciality,practionerId
public ArrayList getPatientWardDtls(String patient_id){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet= null;
	ArrayList result = new ArrayList();
	try{
		connection = getConnection();
		pstmt	   = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHEKIN_SELECT8")) ;

		pstmt.setString(1, patient_id);
		pstmt.setString(2, login_facility_id);
		pstmt.setString(3, patient_id);
		pstmt.setString(4, login_facility_id);
		resultSet= pstmt.executeQuery();

		while(resultSet.next()){
			result.add(resultSet.getString("ENCOUNTER_ID"));
			result.add(resultSet.getString("WARD_CODE"));
			result.add(resultSet.getString("SPECIALITY_CODE"));
			result.add(resultSet.getString("PRACTITIONER_ID"));
			result.add(resultSet.getString("SOURCE_TYPE"));
		}
	}catch (Exception e){
		e.printStackTrace();
	}
	finally{
	  try{
		closeResultSet( resultSet );
		closeStatement( pstmt );
		closeConnection( connection );
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	}
	return result;
}

public HashMap getSurgeryTypeDtls(){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet = null;
	HashMap map = new HashMap();
	HashMap tempmap = null;
	try{
		p=getProperties();
		locale	= (String) p.getProperty("LOCALE");
		connection = getConnection();
		pstmt	   = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHEKIN_SELECT9")) ;
		pstmt.setString(1,locale);
		resultSet  = pstmt.executeQuery();
		int rowId = 1;
		while(resultSet.next()){
			tempmap = new HashMap();
			tempmap.put("short_desc",resultSet.getString("SHORT_DESC"));
			tempmap.put("nature_code",resultSet.getString("NATURE_CODE"));
			tempmap.put("nature_type",resultSet.getString("NATURE_TYPE"));
			map.put(rowId+"",tempmap);
			++rowId;
		}
	}
	catch (Exception e){
		e.printStackTrace();
	}
	finally{
	  try{
		closeResultSet( resultSet );
		closeStatement( pstmt );
		closeConnection( connection );
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	}
	return map;
}

public String getSysDate(){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet=null;
	String date="";
	try{
		connection = getConnection();
		pstmt	   = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		resultSet  = pstmt.executeQuery();
		while(resultSet.next()){
			date = DateUtils.convertDate(resultSet.getString("CURRENT_DATE"),"DMY","en",locale);
		}
	}catch (Exception e){
		e.printStackTrace();
	}
	finally{
	  try{
		closeResultSet( resultSet );
		closeStatement( pstmt );
		closeConnection( connection );
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	}
	return date;
}

public String getSysDateTime(){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet=null;
	String date_time="";
	try{
		connection = getConnection();
		pstmt	   = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		resultSet  = pstmt.executeQuery();
		while(resultSet.next()){
		   // date_time = DateUtils.convertDate(resultSet.getString("DATE_TIME"),"DMYHM","en",locale);
		   date_time = resultSet.getString("DATE_TIME");
		  }
	}catch (Exception e){
		e.printStackTrace();
	}
	finally{
	  try{
		closeResultSet( resultSet );
		closeStatement( pstmt );
		closeConnection( connection );
	  }catch(Exception e){
		e.printStackTrace();
	  }
	}
	return date_time;
}

public String getStatus(){
	Connection connection = null;
	CallableStatement cstmt=null;
	String operationStatus="";
	try{
		connection = getConnection();
		cstmt = connection.prepareCall("{call OT_COMMON_FUNCTIONS.OT_FUNC_STATUS(?,?)}");
		cstmt.setString(1,"01");
		cstmt.registerOutParameter(2,Types.VARCHAR);
		cstmt.execute();
		operationStatus = cstmt.getString(2);
	}
	catch (Exception e){
		e.printStackTrace();
	}
	finally{
	  try{
		closeStatement( cstmt );
		closeConnection( connection );
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	}
	return operationStatus;
}

public String getOperationNum(String episode_type){
	Connection connection = null;
	CallableStatement cstmt=null;
	String operation_num="";
	try{
		 connection = getConnection();
		 cstmt=connection.prepareCall("{call OT_COMMON_FUNCTIONS.OT_NEXT_OPER_NO(?,?,?,?)}");
		 cstmt.setString(1,login_facility_id);
		 cstmt.setString(2,episode_type);
		 cstmt.registerOutParameter(3,Types.VARCHAR);
		 cstmt.registerOutParameter(4,Types.VARCHAR);
		 cstmt.execute();
		 operation_num = cstmt.getString(3);
	}
	catch (Exception e){
		e.printStackTrace();
	}
	finally{
	  try{
		closeStatement( cstmt );
		closeConnection( connection );
	  }catch(Exception e){
		  e.printStackTrace();
	}
	}
	return operation_num;
}

public void loadBookingDtlsBasedOnBooking(String booking_num){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet = null;
	HashMap result = null;
	try{
		p=getProperties();
		locale	= (String) p.getProperty("LOCALE");
		connection = getConnection();
		pstmt	   = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHEKIN_SELECT10")) ;
		pstmt.setString(1,locale);
		pstmt.setString(2,login_facility_id);
		pstmt.setString(3, booking_num);
		resultSet= pstmt.executeQuery();
		int index = 0;
		if(post_oper_dtls==null)
			post_oper_dtls = new HashMap();
		while(resultSet.next()){
			index++;
			result = new HashMap();
			result.put("line_num",nullSafe(resultSet.getString("LINE_NUM"))); //0 LINE_NUM
			result.put("operation_code",nullSafe(resultSet.getString("OPER_CODE"))); //1 OPER_CODE
			result.put("operation_desc",nullSafe(resultSet.getString("OPER_DESC"))); //2 OPER_DESC MMS-QH-CRF-0199
			result.put("side_applicable",nullSafe(resultSet.getString("APPL_RIGHT_LEFT_FLAG"))); //3 APPL_RIGHT_LEFT_FLAG
			result.put("side_applicable_desc",nullSafe(resultSet.getString("APPL_RIGHT_LEFT_FLAG_DESC"))); //4 APPL_RIGHT_LEFT_FLAG_DESC
			result.put("remarks",nullSafe(resultSet.getString("OPER_REMARKS"))); //4 OPER_REMARKS
			result.put("speciality_code",nullSafe(resultSet.getString("SPECIALITY_CODE"))); //5 SPECIALITY_CODE
			result.put("order_id",nullSafe(resultSet.getString("ORDER_ID"))); //6 order_id
			result.put("order_type_code",nullSafe(resultSet.getString("ORDER_TYPE_CODE"))); //7 ORDER_TYPE_CODE
			result.put("order_line_num",nullSafe(resultSet.getString("ORDER_LINE_NUM"))); //8 ORDER_LINE_NUM
			result.put("fpp_category",nullSafe(resultSet.getString("FPP_CATEGORY"))); //9 FPP_CATEGORY Modified Against ML-MMOH-CRF-1939-US04
			//ORDER_ID,ORDER_TYPE_CODE,ORDER_LINE_NUM
			post_oper_dtls.put(index+"",result);
		}
	}catch (Exception e){
		e.printStackTrace();
	}
	finally{
	  try{
		closeResultSet( resultSet );
		closeStatement( pstmt );
		closeConnection( connection );
	  }catch(Exception e){
		  e.printStackTrace();
	}
	}
}

public void loadBookingDtlsBasedOnOrder(String order_id)
{
	//System.err.println("853, ====order_id===="+order_id);
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet = null;
	HashMap result = null;
	String[] orderIds = null;
	int index = 0;
	try
	{
		p=getProperties();
		locale	= (String) p.getProperty("LOCALE");
		connection = getConnection();
		if(order_id != null && order_id.contains(","))
			orderIds = order_id.split(",");
		else
		{
			orderIds = new String[1];
			orderIds[0] = order_id;
		}
		pstmt	   = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_CHEKIN_SELECT12")) ;
		for(int i=0; i<orderIds.length; i++)
		{
			order_id = orderIds[i];
			//System.err.println("876, ====order_id======"+order_id);
			pstmt.setString(1, locale);
			pstmt.setString(2, order_id);
			resultSet= pstmt.executeQuery();
		if(post_oper_dtls==null)
			post_oper_dtls = new HashMap();
			while(resultSet.next())
			{
				index++;
				result = new HashMap();
				result.put("order_line_num",nullSafe(resultSet.getString("ORDER_LINE_NO"))); //0 LINE_NUM
				result.put("operation_code",nullSafe(resultSet.getString("OPER_CODE"))); //1 OPER_CODE
				result.put("operation_desc",nullSafe(resultSet.getString("OPER_DESC"))); //2 OPER_DESC MMS-QH-CRF-0199
				result.put("side_applicable",nullSafe(resultSet.getString("APPL_RIGHT_LEFT_FLAG"))); //3 APPL_RIGHT_LEFT_FLAG
				result.put("side_applicable_desc",nullSafe(resultSet.getString("APPL_RIGHT_LEFT_FLAG_DESC")));
				result.put("remarks",nullSafe(resultSet.getString("OPER_REMARKS"))); //4 OPER_REMARKS
				result.put("speciality_code",nullSafe(resultSet.getString("SPECIALITY_CODE"))); //5 SPECIALITY_CODE
				result.put("order_id",nullSafe(resultSet.getString("ORDER_ID"))); //6 order_id
				result.put("order_type_code",nullSafe(resultSet.getString("ORDER_TYPE_CODE"))); //7 ORDER_TYPE_CODE
				post_oper_dtls.put(index+"",result);
		}
		if(resultSet!=null) resultSet.close(); //Common-ICN-0054
		}
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
	  try
	  {
		closeResultSet( resultSet );
		closeStatement( pstmt );
		closeConnection( connection );
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	}
}

// newly added method for theatredesc field on 09/04/2005
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
			closeResultSet( resultSet );
			closeStatement( pstmt );
			closeConnection( connection );
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	}
	return oper_room_desc;
}


// End of Methods invoked in JSP files
// methods for verify checklist button, added by bshankar
public ArrayList getOperChecklists(String booking_num, String oper_num, String speciality_code,String order_id){
	Connection connection = null;
	CallableStatement cstmt=null;
	ArrayList result=new ArrayList();
	try{

		 if(booking_num!=null && !booking_num.equals("null") && !booking_num.equals(""))
			 order_id = "";
		 connection = getConnection();
		 cstmt=connection.prepareCall("{call OT_OPER_CHECKLISTS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,null,null,?)}");
		 cstmt.setString(1,login_facility_id);
		 cstmt.setString(2,"P");// V_PRE_OR_POST ="Pre" for checkin,checkoutfromward & holdingarea
		 cstmt.setString(3,order_id);
		 cstmt.setString(4,booking_num);
		 cstmt.setString(5,oper_num);
		 cstmt.setString(6,speciality_code);
		 cstmt.registerOutParameter(7,Types.VARCHAR); // concatenated Checklist String
		 cstmt.registerOutParameter(8,Types.VARCHAR); // V_NO_OF_VERIFICATIONS
		 cstmt.registerOutParameter(9,Types.VARCHAR); // role_1
		 cstmt.registerOutParameter(10,Types.VARCHAR); // role_2
		 cstmt.registerOutParameter(11,Types.VARCHAR); // role_3
		 cstmt.registerOutParameter(12,Types.VARCHAR); // role_4
		 cstmt.registerOutParameter(13,Types.VARCHAR); //STATUS
		 cstmt.registerOutParameter(14,Types.VARCHAR); // Error text
		 cstmt.registerOutParameter(15,Types.VARCHAR); // Lang Error text
		 cstmt.execute();
		 result.add(cstmt.getString(7));  //checklist string
		 result.add(cstmt.getString(8));  // no_of_verifications
		 result.add(cstmt.getString(9));  // role_id_1
		 result.add(cstmt.getString(10));  // role_id_2
		 result.add(cstmt.getString(11)); // role_id_3
		 result.add(cstmt.getString(12)); // role_id_4
	}
	catch (Exception e){
		e.printStackTrace();
	}
	finally{
	  try{
		closeStatement( cstmt );
		closeConnection( connection );
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	}
	return result;
}

public ArrayList getUserInfo(String booking_num, String oper_num, String current_level, String order_id){
	Connection connection   = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet     = null;
	ArrayList result=new ArrayList();
	try{
		if(booking_num==null)			booking_num="";
		if(booking_num.equals("null"))	booking_num="";

		if(oper_num==null)				oper_num="";
		if(oper_num.equals("null"))		oper_num="";

		if(order_id==null)				order_id="";
		if(order_id.equals("null"))		order_id="";

		if(!booking_num.equals("")){
			order_id = "";
			oper_num = "";
		}else if(!order_id.equals("")){
			booking_num = "";
			oper_num = "";
		}

		connection	= getConnection() ;
		pstmt		= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_VERIFY_CHECKLIST_SELECT6")) ;
		pstmt.setString(1,login_facility_id);
		pstmt.setString(2,booking_num);
		pstmt.setString(3,oper_num);
		pstmt.setString(4,order_id);
		resultSet	= pstmt.executeQuery();
		while(resultSet!=null && resultSet.next()){
			result.add(resultSet.getString("PRE_OP_CHKLST_USR2_ID"));
			result.add(resultSet.getString("PRE_OP_CHKLST_USR2_COMPL_YN"));
		}
	}catch ( Exception e ) {
		e.printStackTrace();
	}finally {
		try{
			closeResultSet( resultSet );
			closeStatement( pstmt );
			closeConnection( connection );
		 }catch(Exception es){
			 es.printStackTrace();
		 }
	}
	return result;
}

 public String getCheckListReqdYNFlag(String function_id){
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet  = null;
	String check_for_check_list_compl="";
	try{
		p=getProperties();
		locale	= (String) p.getProperty("LOCALE");
		connection = getConnection();
		pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_VERIFY_CHECKLIST_SELECT7")) ;
		pstmt.setString(1,locale);
		pstmt.setString(2,function_id);
		resultSet  = pstmt.executeQuery();
		while(resultSet.next()){
			check_for_check_list_compl = resultSet.getString("CHECK_FOR_CHECK_LIST_COMPL");
		}
	}catch (Exception e){
		e.printStackTrace() ;
	}
	finally{
	  try{
			closeResultSet( resultSet );
			closeStatement( pstmt );
			closeConnection( connection );
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	}
	return check_for_check_list_compl;
}
// end of verify checklist button methiods.

//This method is used for loading billing related parameters thro' OT-SLATE OR PENDING_ORDERS
public HashMap getHdrParams(String called_from,String booking_num){
	HashMap map = new HashMap(7);
	Connection connection  = null;
	PreparedStatement pstmt= null;
	ResultSet rst = null;
	String SQL = "";
	//System.err.println("1070, getHdrParams");
	
	if( "OT_SLATE".equals(called_from) ){
		SQL = "SELECT PATIENT_ID,EPISODE_TYPE,EPISODE_ID,VISIT_ID,TO_CHAR(BOOKING_DATE,'DD-MON-YYYY'),ENCOUNTER_ID,TEAM_DOCTOR_CODE,PATIENT_CLASS FROM OT_BOOKING_HDR WHERE BOOKING_NUM=? AND OPERATING_FACILITY_ID=?";//KDAH-SCF-0520
		//System.err.println("1073, SQL==>"+SQL);
	}else if("BOOKING".equals(called_from) ){
		SQL = "SELECT PATIENT_ID,EPISODE_TYPE,EPISODE_ID,VISIT_ID,TO_CHAR(ORDER_DATE_TIME,'DD-MON-YYYY'),ENCOUNTER_ID,PHYSICIAN_ID,PATIENT_CLASS FROM OT_PENDING_ORDER WHERE ORDER_ID=? AND PERFORMING_FACILITY_ID";//KDAH-SCF-0520
		//System.err.println("1075, SQL==>"+SQL);
	}
	try{
		connection	= getConnection() ;
		pstmt=connection.prepareStatement(SQL);
		pstmt.setString(1,booking_num);//called from OT-MENU-->booking_num BOOKING-->order_id
		pstmt.setString(2,login_facility_id);//KDAH-SCF-0520
		rst = pstmt.executeQuery();
		while(rst.next()){
			map.put("patient_id",rst.getString(1));
			map.put("episode_type",rst.getString(2));
			map.put("episode_id",CommonBean.checkForNull(rst.getString(3)));
			map.put("visit_id",CommonBean.checkForNull(rst.getString(4),"1"));
			map.put("service_date",rst.getString(5));
			map.put("encounter_id",rst.getString(6));
			map.put("pract_staff_id",rst.getString(7));
			map.put("patient_class",rst.getString(8));
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		 try{
			closeResultSet( rst );
			closeStatement( pstmt );
			closeConnection( connection );
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}
	return map;
}

public String  getCatalogCode(String oper_code)
{
	Connection connection  = null ;
	PreparedStatement pstmt= null ;
	ResultSet rst = null;
	String SQL = "SELECT ORDER_CATALOG_CODE FROM OT_OPER_MAST WHERE OPER_CODE =?";
	String catalog_code = "";
	try
	{
		connection	= getConnection() ;
		pstmt=connection.prepareStatement(SQL);
		pstmt.setString(1,oper_code);
		rst = pstmt.executeQuery();
		while(rst.next())
		{
			catalog_code = rst.getString(1);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		 try
		 {
			closeResultSet( rst );
			closeStatement( pstmt );
			closeConnection( connection );
		 }
		 catch(Exception e)
		 {
			e.printStackTrace();
		 }
	}
	return catalog_code;
}


private String nullSafe(String s){
	return s!= null && s.intern()!="null" ? s : "";
}

public ArrayList getDetsForOrderIds(OtCommonGettersSetters getDets)
{
	//System.err.println("1151, getDetsForOrderIds==>");
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;
	StringBuffer getDetsForOrderIdsBuffer = new StringBuffer();
	int setIndex = 0;
	ArrayList getDetsForOrderIdsList = new ArrayList();
	OtCommonGettersSetters setDetails = new OtCommonGettersSetters();
	locale = getProperties().getProperty("LOCALE");
	//String patientId = getDets.getPatientId(); //Common-ICN-0055
	String orderIds = getDets.getOrderId();

	getDetsForOrderIdsBuffer.append("	SELECT DISTINCT a.patient_id patient_id,	");
	getDetsForOrderIdsBuffer.append("	(SELECT DECODE (?, 'en', NVL (patient_name, patient_name_loc_lang), 	");
	getDetsForOrderIdsBuffer.append("	NVL (patient_name_loc_lang, patient_name)) FROM mp_patient WHERE patient_id = a.patient_id) short_name,	");
	getDetsForOrderIdsBuffer.append("	a.sex sex, a.order_id order_id, a.speciality_code speciality_code, a.speciality_desc speciality_desc,	");
	getDetsForOrderIdsBuffer.append("	NVL (a.performing_team_surgeon, '') surgeon_code, NVL (a.team_surgeon_name, 'All Surgeons')surgeon_name, 	");
	getDetsForOrderIdsBuffer.append("	NVL (a.surgery_nature_desc, '') surgery_type,	");
	getDetsForOrderIdsBuffer.append("	A.ENCOUNTER_ID as ENCOUNTER_ID,	");//MMS-CRF-186
	getDetsForOrderIdsBuffer.append("	TO_CHAR(d.visit_adm_date_time,'DD/MM/YYYY HH:MI') AS encounterdatetime,	");//MMS-CRF-186
	getDetsForOrderIdsBuffer.append("	b.oper_code oper_code, b.short_desc oper_short_desc, b.long_desc oper_long_desc, TO_CHAR (a.order_date_time, 'dd/mm/yyyy') order_date_time,	");
	getDetsForOrderIdsBuffer.append("	TO_CHAR (a.pref_surg_date, 'dd/mm/yyyy') pref_surg_date, a.status status1, a.waitlist_num waitlist_num1,	");
	getDetsForOrderIdsBuffer.append("	a.physician_id physician_id,	");
	getDetsForOrderIdsBuffer.append("	DECODE (NVL (c.source_order_id, 'N'), 'N', 'N', 'Y') anesthesia_yn, a.patient_class patient_class	");
	getDetsForOrderIdsBuffer.append("	FROM ot_pending_orders_vw a, ot_oper_mast_lang_vw b, at_pending_orders c,pr_encounter d	");//MMS-CRF-186
	getDetsForOrderIdsBuffer.append("	WHERE a.language_id = ?	");
	getDetsForOrderIdsBuffer.append("	AND b.language_id = ?	");
	getDetsForOrderIdsBuffer.append("	AND a.performing_facility_id = ?		");
	getDetsForOrderIdsBuffer.append("	AND b.order_catalog_code IN (	");
	getDetsForOrderIdsBuffer.append("	SELECT order_catalog_code	");
	getDetsForOrderIdsBuffer.append("	FROM ot_pending_order_line	");
	getDetsForOrderIdsBuffer.append("	WHERE order_id = a.order_id	");
	getDetsForOrderIdsBuffer.append("	AND ROWNUM = 1)	");
//		getDetsForOrderIdsBuffer.append("	AND a.pref_surg_date BETWEEN TO_DATE (NVL (?, '01/01/1900') || '00:00', 'DD/MM/YYYY HH24:MI')	");
//		getDetsForOrderIdsBuffer.append("	AND TO_DATE(NVL (?, '01/01/3000') || '23:59', 'DD/MM/YYYY HH24:MI')	");
	getDetsForOrderIdsBuffer.append("	AND a.patient_id = ?	");
	getDetsForOrderIdsBuffer.append("	AND a.order_id in('"+	orderIds + "')	");
	getDetsForOrderIdsBuffer.append("	AND a.order_id = c.source_order_id(+)	");
	getDetsForOrderIdsBuffer.append("	AND a.patient_id = c.patient_id(+)	");
	getDetsForOrderIdsBuffer.append("	AND a.encounter_id = d.encounter_id	");//MMS-QH-CRF-186
//		getDetsForOrderIdsBuffer.append("	ORDER BY a.patient_id	");
	getDetsForOrderIdsBuffer.append("	ORDER BY a.patient_id,pref_surg_date,b.long_desc,a.speciality_desc	"); // IN 57504

	try
	{
		connection = getConnection();
		if(getDetsForOrderIdsList == null)
			return getDetsForOrderIdsList;
		//pstmt = new JDBCStatementLogger(connection, getDetsForOrderIdsBuffer.toString());
		pstmt=connection.prepareStatement(getDetsForOrderIdsBuffer.toString());
		
		pstmt.setString(++setIndex, locale);
		pstmt.setString(++setIndex, locale);
		pstmt.setString(++setIndex, locale);
		pstmt.setString(++setIndex, login_facility_id);
		//pstmt.setString(++setIndex, getDets.getFromTime());
		//pstmt.setString(++setIndex, getDets.getToTime());
		pstmt.setString(++setIndex, getDets.getPatientId());
		//JDBCStatementLogger.logQueryStringDetails("getDetsForOrderIds","CheckInBean", pstmt);
		resultSet = pstmt.executeQuery();
		//System.err.println("1215, getDetsForOrderIds");
		while(resultSet.next())
		{
			setDetails = new OtCommonGettersSetters();
			setDetails.setPatientId(resultSet.getString("patient_id"));
			setDetails.setPatientShortName(resultSet.getString("short_name"));
			setDetails.setOrderId(resultSet.getString("order_id"));
			setDetails.setSpecialityCode(resultSet.getString("speciality_code") == null ? "" : resultSet.getString("speciality_code"));
			setDetails.setSpecialityDesc(resultSet.getString("speciality_desc") == null ? "" : resultSet.getString("speciality_desc"));
			setDetails.setSurgeonCode(resultSet.getString("surgeon_code") == null ? "" : resultSet.getString("surgeon_code"));
			setDetails.setSurgeonName(resultSet.getString("surgeon_name") == null ? "" : resultSet.getString("surgeon_name"));
			setDetails.setSurgeryType(resultSet.getString("surgery_type") == null ? "" : resultSet.getString("surgery_type"));
			setDetails.setOperCode(resultSet.getString("oper_code"));
			setDetails.setOperLongDesc(resultSet.getString("oper_long_desc") == null ? "" : resultSet.getString("oper_long_desc"));
			setDetails.setOperShortDesc(resultSet.getString("oper_short_desc") == null ? "" : resultSet.getString("oper_short_desc"));
			setDetails.setAnesthesiaRequired(resultSet.getString("anesthesia_yn"));
			setDetails.setPatientClass(resultSet.getString("patient_class"));
			setDetails.setPreferSurgeryDate(resultSet.getString("pref_surg_date"));//MMS-QH-CRF-186
			setDetails.setEncounterId(resultSet.getString("ENCOUNTER_ID"));//MMS-QH-CRF-186
			setDetails.setEncounterDateTime(resultSet.getString("encounterdatetime"));//MMS-QH-CRF-186
			
			getDetsForOrderIdsList.add(setDetails);			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		 try
		 {
			closeResultSet( resultSet );
			closeStatement( pstmt );
			closeConnection( connection );
		 }
		 catch(Exception e)
		 {
			e.printStackTrace();
		 }
	}
	//System.err.println("========getDetsForOrderIdsList=========="+getDetsForOrderIdsList);
	return getDetsForOrderIdsList;
	}
}
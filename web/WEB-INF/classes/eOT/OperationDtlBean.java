/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;


/*
import eOT.Booking.*;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import javax.rmi.* ;
import javax.naming.* ;
*/
import java.util.HashMap;
import java.util.Hashtable;
import java.util.ArrayList;
import java.io.Serializable;
import eOT.Common.OTAdapter;
import eOT.Common.OTRepository;
import eOT.Booking.BookingHome;
import eOT.Booking.BookingRemote;
import javax.rmi.PortableRemoteObject;
import javax.naming.InitialContext;

public class OperationDtlBean extends OTAdapter implements Serializable{

	
	HashMap headerDtl = null;
	HashMap operation_map = null;
	String strFacilityId="";
	String strClientAddress="";
	String strBookingNum="";
	String login_user="";


	public OperationDtlBean() {
        try {
			doCommon();
		}catch(Exception e) {}
	}

	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		String message = "";
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", message ) ;
		return map;
	}


	

	public void doCommon() throws Exception {}

	public void setAll(Hashtable hmap)
	{
       String natureType1="";
 	   if(headerDtl == null)
 		   headerDtl = new HashMap();
       mode =""+hmap.get("mode");   
	    if(("Elective").equals(hmap.get("natureType")))
			natureType1="EL";
		else if(("Emergency").equals(hmap.get("natureType")))
			natureType1="EM";
	
		headerDtl.put("over_booking_case_yn",""+hmap.get("over_booking_case_yn"));
		headerDtl.put("booking_date",""+hmap.get("booking_date"));
		headerDtl.put("roomCode",""+hmap.get("roomCode"));
		headerDtl.put("roomDesc",""+hmap.get("roomDesc"));
		headerDtl.put("surgeonName",""+hmap.get("surgeonName"));
		headerDtl.put("surgeonCode",""+hmap.get("surgeonCode"));
		headerDtl.put("asst_surgeon_code",""+hmap.get("asst_surgeon_code")); //added asst_surgeon_code
		headerDtl.put("SPECIALITY_CODE",""+hmap.get("SPECIALITY_CODE"));
		headerDtl.put("SPECIALITY_DESC",""+hmap.get("SPECIALITY_DESC"));
		headerDtl.put("start_time",""+hmap.get("hidden_time"));
		headerDtl.put("patient_id",""+hmap.get("patient_id"));
		headerDtl.put("episode_id",""+hmap.get("episode_id"));
		headerDtl.put("episode_type",""+hmap.get("episode_type"));
		headerDtl.put("duration",""+hmap.get("duration"));
		headerDtl.put("REMARKS",""+hmap.get("REMARKS"));
		headerDtl.put("orderid",""+hmap.get("orderid"));
		headerDtl.put("visitid",""+hmap.get("visitid"));
		headerDtl.put("encounter_id",""+hmap.get("encounter_id"));
		if(("Elective").equals(hmap.get("natureType"))||("Emergency").equals(hmap.get("natureType")))
		headerDtl.put("natureType",""+natureType1);
		else
		headerDtl.put("natureType",""+hmap.get("natureType"));
		headerDtl.put("natureCode",""+hmap.get("natureCode"));
		headerDtl.put("sourceDesc",""+hmap.get("sourceDesc"));
		headerDtl.put("sourceType",""+hmap.get("sourceType"));
		headerDtl.put("waitlistyn",""+hmap.get("waitlistyn"));
		headerDtl.put("waitlistno",""+hmap.get("waitlistno"));
		headerDtl.put("pre_oper_diag",""+hmap.get("pre_oper_diag"));
		headerDtl.put("specilaity_collect",""+hmap.get("specilaity_collect"));
		// added by bshankar on 24/01/2006 against SCF-0831
		headerDtl.put("pref_date",""+hmap.get("pref_date"));		
		headerDtl.put("Anaesthetia_code",""+hmap.get("Anaesthetia_code"));
		headerDtl.put("Anaesthetiest_code",""+hmap.get("Anaesthetiest1_code"));
		headerDtl.put("Patient_position",""+hmap.get("Patient_position"));
		headerDtl.put("selSurgeonCode",""+hmap.get("selSurgeonCode")); // 051911 //51825
		headerDtl.put("anaes_review1",""+hmap.get("anaes_review1"));//Added by sanjay for Anaesthesia Required Checkbox against IN032063
		//186
		headerDtl.put("ammendBooking",""+hmap.get("ammendBooking"));
		headerDtl.put("selOrderIds",""+hmap.get("selOrderIds"));
		headerDtl.put("ammendFlag",""+hmap.get("ammendFlag"));
		headerDtl.put("selBookingNumber",""+hmap.get("selBookingNumber"));
		//186
	}

	//Added by lakshmi against performing facility change
	public void setFacilityId(String facility_id)
	{
		login_facility_id = facility_id;
	}
	public HashMap insert()
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;
		//BookingHome   home=null;
  		//BookingRemote remote=null;
		ArrayList mandatory_flds	=	new ArrayList();
		mandatory_flds.add(login_by_id);
		mandatory_flds.add(login_at_ws_no);
		mandatory_flds.add(login_facility_id);
		HashMap tabData	= new HashMap() ;
		HashMap sqlMap	= new HashMap() ;
		try 
		{
			tabData.put("properties", getProperties());
			tabData.put("mandatory_flds",mandatory_flds);
			tabData.put("booking_hdr",headerDtl);
			tabData.put("post_oper_dtls",operation_map);
			tabData.put("user_id_to_insert",login_by_id);
			sqlMap.put( "SQL_OT_BOOKING_DTLS_INSERT","");
			Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome(OTRepository.getOTKeyValue("JNDI_OT_BOOKING"),BookingHome.class,getLocalEJB());
			Object busObj =	(home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[]  = new Object[2];
	        argArray[0] = tabData;
			argArray[1] = sqlMap;
			Class [] paramArray	   = new Class[2];
			paramArray[0] = tabData.getClass();
			paramArray[1] = sqlMap.getClass();
			HashMap result =(java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			argArray = null;
			paramArray = null;
			tabData.clear();
			sqlMap.clear();
			if( "true".equals(result.get( "result" ).toString()) )	
			{
				map.put("flag",(String)result.get("flag"));
				map.put("result", new Boolean( true ) ) ;
				map.put("message", result.get( "msgid")) ;
				clear();
			}
			else
			{
				map.put("flag",(String)result.get("flag"));
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message",""+result.get("msgid")) ;
			}
		}
		catch(Exception e) {
			map.put("message",e.toString());
			e.printStackTrace() ;
		}
		finally {
			try {}
			catch( Exception ee ){
	        ee.printStackTrace() ;
				map.put( "message", ee.getMessage() ) ;
			}
		}
		return map ;
	}
	public void recordOperationDtls(HashMap hmap)
	{
		if(operation_map==null)
			operation_map = new HashMap();
		int rowId = (operation_map.size())+1;
		operation_map.put(rowId+"",hmap);
	}

	public HashMap getOperationDtls()
	{
		if (operation_map==null)
			return new HashMap();
		else
			return operation_map;
	}

    public void updateOperationDtls(String key, HashMap hmap){
		if(operation_map.containsKey(key))
		operation_map.put(key,hmap);
	
	}

	public void removeOperationDtls(String key)
		{
		HashMap temp_map = new HashMap();
		int count = 0;
		for(int i=1;i<=operation_map.size();i++){
			if(i!=Integer.parseInt(key)){
				count++;
				temp_map.put(count+"",operation_map.get(i+""));
			}
		}
		operation_map = temp_map;
	}



public void clear()
{
operation_map = null;
headerDtl=null;

}
}

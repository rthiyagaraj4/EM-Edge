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
import java.io.Serializable;
import eOT.Common.OTAdapter;
import eOT.Common.OTRepository;
import com.ehis.eslp.ServiceLocator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Properties;
import eOT.InstrumentCount.*;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

public class InstrumentCountBean extends OTAdapter implements Serializable {

	HashMap instr_set_map = null;
	HashMap all_set_item_map = null;
	ArrayList map_keys_list = null;
	public InstrumentCountBean() {
        try {
			doCommon();
		}catch(Exception e) {}
	}

	public void doCommon() throws Exception {
	}

	public void clear(){
		instr_set_map = null;
		all_set_item_map = null;
		map_keys_list = null;
	}

	public void removeSetDetails(String set_item_key){
		if(all_set_item_map!=null){
			if(all_set_item_map.containsKey(set_item_key)){
				this.all_set_item_map.remove(set_item_key);
			}
		}
	}
	public void storeSetDetails(String set_item_key, HashMap set_item_map){
		if(all_set_item_map==null)
			all_set_item_map=new HashMap();
		all_set_item_map.put(set_item_key,set_item_map);
	}
	public void storeMapKeys(String map_key){
		int found = 0;
		int i=0;
		if(map_keys_list==null)
			map_keys_list=new ArrayList();
		while(i<map_keys_list.size() && found==0){
			if(map_key.equals(""+map_keys_list.get(i)))
				found=1;
			i++;
		}
		if (found==0)
			map_keys_list.add(map_key);
	}
	public HashMap getSetDetails(){
		if(all_set_item_map==null)
			return new HashMap();
		return all_set_item_map;
	}
	public HashMap getSetDetails(String set_item_key){
		HashMap temp_map = new HashMap();
		if(all_set_item_map==null)
			return new HashMap();
		temp_map=(HashMap)all_set_item_map.get(set_item_key);
		return temp_map;
	}
	public String updateRecord(String patient_id, String booking_num, String oper_num,String bio_hazard_yn){
		String result  = "";
		HashMap tabData = new HashMap();
		try{
			String update_sql = OTRepository.getOTKeyValue("SQL_OT_INSTRUMENT_COUNT_UPDATE");
			String update_hdr_sql = OTRepository.getOTKeyValue("SQL_OT_INSTRUMENT_COUNT_UPDATE_HDR");			
			tabData.put("properties", getProperties());

			tabData.put("login_by_id", login_by_id);
			tabData.put("login_at_ws_no", login_at_ws_no);
			tabData.put("login_facility_id", login_facility_id);
			tabData.put("facility_id", login_facility_id);

			tabData.put("patient_id", patient_id);
			tabData.put("booking_num", booking_num);
			tabData.put("oper_num", oper_num);
			tabData.put("bio_hazard_yn", bio_hazard_yn);

			tabData.put("all_set_item_map", all_set_item_map);
			tabData.put("map_keys_list", map_keys_list);			
			
//			String msg = "";
			boolean local_ejbs=getLocalEJB();

			//Lookup the Home Object using the Service locator pattern
			Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome(OTRepository.getOTKeyValue("JNDI_OT_INSTRUMENT_COUNT"),InstrumentCountHome.class,local_ejbs);
			//Get the remote object by invoking create method on the home object using reflection
			Object busObj =	(home.getClass().getMethod("create",null)).invoke(home,null);

			//Create an object array, which will be passed as argument to the method call
			Object argArray[]  = new Object[3];
				   argArray[0] = tabData;				   
				   argArray[1] = update_sql;
				   argArray[2] = update_hdr_sql;

			//Create a class array, containing the class types of the arguments passed
			Class [] paramArray	   = new Class[3];
					 paramArray[0] = tabData.getClass();
					 paramArray[1] = update_sql.getClass();
					 paramArray[2] = update_hdr_sql.getClass();

			//Invoke the business method on the EJB using the argument array, class	array and reflection
			result =(String)(busObj.getClass().getMethod("executeTransaction",paramArray)).invoke(busObj,argArray);

			//Call to remove the EJB
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			//Nullify the class and the object arrays
			argArray = null;
			paramArray = null;

			//Now Clean up the containers passed to the EJB
			all_set_item_map.clear();		
			tabData.clear();
		}catch(Exception e){
			System.err.println("Err Msg in InstrumentCountBean "+e.getMessage());
		}		
		return result;
	}
}

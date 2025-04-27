/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT ;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.io.Serializable;
import eOT.Common.OTAdapter;
import java.util.Properties;
import com.ehis.util.DateUtils;
import eCommon.Common.CommonBean;

public class OTBillingBean extends OTAdapter implements Serializable
{
	HashMap storeBookingDetails = null;

public OTBillingBean() {
	try {
		doCommon();
	}catch(Exception e) {}
}

public void doCommon() throws Exception {}

public void clear(){}
	
public ArrayList getPanelIndicatorAndCode(String oper_code,String episode_type, String fpp_category){
		ArrayList list = new ArrayList(2);
		Connection connection  = null ;
		CallableStatement cstmt= null ;
		String catalog_code = getOrderCatalogCode(oper_code);
		//Added Against ML-MMOH-SCF-2008 Starts
		ArrayList fppList = new ArrayList(2);
		fppList = getFPPDetails(oper_code);
		String str = fppList.toString().replaceAll("\\[|\\]", "").replaceAll(", ",", ");
		String[] fppDetails = str.split(",");
		String fpp_yn = fppDetails[0].trim();
		//String fpp_category = fppDetails[1].trim();
		//Added Against ML-MMOH-SCF-2008 Ends
		try{
			connection	= getConnection() ;
			if(fpp_yn.equals("Y")) //Added Against ML-MMOH-SCF-2008
			{
			cstmt=connection.prepareCall("{call BL_PROC_FOR_EXT_SERVICE_MP.GET_ORDER_CATALOG_DTLS(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,"OR");//P_MODUlE_ID
			cstmt.setString(2,catalog_code);//catalog_code
			cstmt.setString(3,episode_type);//P_EPISODE_TYPE
			cstmt.registerOutParameter(4,Types.VARCHAR);//P_ORDER_CATALOG_CODE
			cstmt.registerOutParameter(5,Types.VARCHAR);//P_SERV_PANEL_IND	
			cstmt.registerOutParameter(6,Types.VARCHAR);//P_SERV_PANEL_CODE	
			cstmt.registerOutParameter(7,Types.VARCHAR);//P_CHARGING_STAGE	
			cstmt.registerOutParameter(8,Types.VARCHAR);//p_err_code	
			cstmt.registerOutParameter(9,Types.VARCHAR);//p_sys_message_id
			cstmt.registerOutParameter(10,Types.VARCHAR);//p_error_text
			cstmt.setString(11,"Y");//P_FPP_YN
			cstmt.setString(12,fpp_category);//P_APPL_CATG
			}
			else{
			cstmt=connection.prepareCall("{call BL_PROC_FOR_EXT_SERVICE_MP.GET_ORDER_CATALOG_DTLS(?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,"OR");//P_MODUlE_ID
			cstmt.setString(2,catalog_code);//catalog_code
			cstmt.setString(3,episode_type);//P_EPISODE_TYPE
			cstmt.registerOutParameter(4,Types.VARCHAR);//P_ORDER_CATALOG_CODE
			cstmt.registerOutParameter(5,Types.VARCHAR);//P_SERV_PANEL_IND	
			cstmt.registerOutParameter(6,Types.VARCHAR);//P_SERV_PANEL_CODE	
			cstmt.registerOutParameter(7,Types.VARCHAR);//P_CHARGING_STAGE	
			cstmt.registerOutParameter(8,Types.VARCHAR);//p_err_code	
			cstmt.registerOutParameter(9,Types.VARCHAR);//p_sys_message_id
			cstmt.registerOutParameter(10,12);//p_error_text
			}
			cstmt.execute();
			list.add(cstmt.getString(5));
			list.add(cstmt.getString(6));		
		}catch ( Exception e ) {
	        e.printStackTrace();
		}finally {
            try{
                closeStatement( cstmt );
                closeConnection( connection );
             }catch(Exception es){
				 es.printStackTrace();
			}
        }
		return  list;
	}

//This will be called only for Instruments/Equipments/Consumables/Implants
public ArrayList getServicePanelIndicator(String equip_type,String equip_code){
//Consumable --> C  Equipment   --> B CSSD   --> S Implant  --> I
	ArrayList list = new ArrayList(2);
	Connection connection  = null;
	CallableStatement cstmt= null;
	try{
		connection	= getConnection();
		cstmt=connection.prepareCall("{call BL_PROC_FOR_EXT_SERVICE_MP.GET_OT_USAGE_SERVICE_DTLS(?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,login_facility_id);//LOGIN_FACILITY_ID
		cstmt.setString(2,equip_type);//P_EQUIP_TYPE
		cstmt.setString(3,equip_code);//P_EQUIP_CODE
		cstmt.registerOutParameter(4,Types.VARCHAR);//P_SERV_PANEL_IND	
		cstmt.registerOutParameter(5,Types.VARCHAR);//P_SERV_PANEL_CODE	
		cstmt.registerOutParameter(6,Types.VARCHAR);//p_err_code  	
		cstmt.registerOutParameter(7,Types.VARCHAR);//p_sys_message_id
		cstmt.registerOutParameter(8,Types.VARCHAR);//p_error_text 
		cstmt.execute();
		list.add(cstmt.getString(4));
		list.add(cstmt.getString(5));
	}catch ( Exception e ) {
		e.printStackTrace();
	}finally {
		try{
			closeStatement( cstmt );
			closeConnection( connection );
		 }catch(Exception es){
			 es.printStackTrace();
		}
	}
	return  list;
	}

public HashMap getBillingInfo(HashMap map){
	Connection connection  = null ;
	CallableStatement cstmt= null ;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	String bill_episide_type=null;
	//System.err.println("111,getBillingInfo in map--->"+map);
	String order_catalog = getOrderCatalogCode((String) map.get("oper_code") );
	order_catalog = ("".equals(order_catalog))?(String) map.get("oper_code"):order_catalog;
	System.err.println("114,getBillingInfo in map--->"+map);
	//Added Against ML-MMOH-SCF-2008 Starts
	ArrayList fppList = new ArrayList(2);
	fppList = getFPPDetails((String) map.get("oper_code"));
	String str = fppList.toString().replaceAll("\\[|\\]", "").replaceAll(", ",", ");
	String[] fppDetails = str.split(",");
	String fpp_yn = fppDetails[0].trim();
	//String fpp_category = fppDetails[1].trim(); 
	//Added Against ML-MMOH-SCF-2008 Ends
//{episode_type=I, charged_yn=Y, oper_code=ORTH, acc_type=S, episode_id=10002544, patient_paid_amt=, order_id=OTIP00000006485, quantity=1, encounter_id=10002544, serv_panel_code=SUB_GS0001, serv_panel_ind=S, patient_payable=, bl_panel_str=<NR>SUB_GS0001#R# # #P#01#NOS# # #1#0, billed_yn=, pract_staff_id=01, visit_id=1, key_line_no=5, total_payable=, charge_based_yn=N, preapp_yn=, key=SI0708220011, incl_excl_ind=, oper_num=I070822001, service_date=21-AUG-2007, patient_id=SD00000866}
	try{
		connection	= getConnection() ;
		//Episide Type is changed to Bill Episide Type
		if(rst!=null) rst.close();
		if(pstmt!=null)pstmt.close();
		
		String patient_class_b=(String)map.get("patient_class");
		String episode_type_b=(String)map.get("episode_type");
		
		String sql_bl_episode_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class_b+"' ";
		pstmt = connection.prepareStatement(sql_bl_episode_type);
		rst = pstmt.executeQuery();
		while(rst.next()){
			bill_episide_type=CommonBean.checkForNull(rst.getString(1));		
		}
		if(bill_episide_type.equals("")){
			bill_episide_type=episode_type_b;
		}
		if(fpp_yn.equals("Y"))  //Added Against ML-MMOH-SCF-2008
			{
		cstmt=connection.prepareCall("{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,login_facility_id);				    //P_FACILITY_ID	
		System.err.println("172,login_facility_id="+login_facility_id);
		cstmt.setString(2,(String)map.get("module_id"));							    //P_MODULE_ID		    
		System.err.println("172,module_id="+(String)map.get("module_id"));
		cstmt.setString(3,(String)map.get("key"));//P_KEY	--->( ORDER_ID )		     
		System.err.println("172,key="+(String)map.get("key"));
		cstmt.setString(4,(String)map.get("key_line_no"));
		System.err.println("172,key_line_no="+(String)map.get("key_line_no"));
		cstmt.setString(5,bill_episide_type);//P_EPISODE_TYPE
		System.err.println("172,bill_episide_type="+bill_episide_type);
		cstmt.setString(6,(String)map.get("patient_id"));	    //P_PATIENT_ID	
		System.err.println("172,patient_id="+(String)map.get("patient_id"));
		cstmt.setString(7,(String)map.get("episode_id"));	    //P_EPISODE_ID		 
		System.err.println("172,episode_id="+(String)map.get("episode_id"));
		cstmt.setString(8,(String)map.get("visit_id"));
		//P_VISIT_ID		
		System.err.println("172,visit_id="+(String)map.get("visit_id"));
		cstmt.setString(9,(String)map.get("encounter_id"));//P_DUMMY1
		System.err.println("172,encounter_id="+(String)map.get("encounter_id"));
		cstmt.setString(10,null);//ACCT_SEQ_NUMBER
		cstmt.setString(11,order_catalog);//P_ITEM_CODE	
		System.err.println("172,order_catalog="+order_catalog);
		cstmt.setString(12,CommonBean.checkForNull((String)map.get("serv_panel_ind")));  //P_SERV_PANEL_IND	 
		System.err.println("172,serv_panel_ind="+(String)map.get("serv_panel_ind"));
		cstmt.setString(13,CommonBean.checkForNull((String)map.get("serv_panel_code"))); //P_SERV_PANEL_CODE	  	
		System.err.println("172,serv_panel_code="+(String)map.get("serv_panel_code"));
		cstmt.setString(14,CommonBean.checkForNull((String) map.get("quantity")));			//P_SERV_QTY
		System.err.println("172,quantity="+(String)map.get("quantity"));
		cstmt.setString(15,null);								//P_CHARGE_BASED_AMT	  
		cstmt.setString(16,"P");								//P_PRACT_STAFF_IND	  
		cstmt.setString(17,CommonBean.checkForNull((String)map.get("pract_staff_id")));
		//P_PRACT_STAFF_ID	  
		System.err.println("172,pract_staff_id="+(String)map.get("pract_staff_id"));
		System.err.println("-------------Fpp--------------");
		cstmt.registerOutParameter(18,Types.VARCHAR);//P_STR		      
		cstmt.registerOutParameter(19,Types.VARCHAR);//P_CHARGE_BASED_YN  
		cstmt.registerOutParameter(20,Types.FLOAT);	//P_TOT_AMT		      
		cstmt.registerOutParameter(21,Types.FLOAT);	//P_PAT_PAYABLE_AMT	  
		cstmt.registerOutParameter(22,Types.VARCHAR);//P_EXCL_INCL_IND	  
		cstmt.registerOutParameter(23,Types.VARCHAR);//P_PREAPP_YN	      
		cstmt.setString(24,null);//P_EXCL_INCL_ACTION_IND
		cstmt.setString(25,null);//P_ACTION_REASON_CODE	
		cstmt.registerOutParameter(26,Types.FLOAT);//P_PAT_PAID_AMT		  
		cstmt.registerOutParameter(27,Types.VARCHAR);//P_CHARGED_YN		  
		cstmt.registerOutParameter(28,Types.VARCHAR);//P_PAT_BILLED_YN	  
		cstmt.setString(29,CommonBean.checkForNull((String)map.get("locale")));//P_LANGUAGE_ID	  
		cstmt.registerOutParameter(30,Types.VARCHAR);//P_ERROR_LEVEL  
		cstmt.registerOutParameter(31,Types.VARCHAR);//P_SYS_MESSAGE_ID	  
		cstmt.registerOutParameter(32,Types.VARCHAR);//P_ERROR_TEXT
		cstmt.setString(33,"Y");//FPP_YN
		System.err.println("172,fpp_category="+(String)map.get("fpp_category"));
		cstmt.setString(34,CommonBean.checkForNull((String)map.get("fpp_category")));  //ML-MMOH-CRF-1939-US005
			}
			else
		{
			cstmt=connection.prepareCall("{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,login_facility_id);				    //P_FACILITY_ID	
		System.err.println("172,login_facility_id="+login_facility_id);
		cstmt.setString(2,CommonBean.checkForNull((String)map.get("module_id")));							    //P_MODULE_ID		    
		System.err.println("172,module_id="+(String)map.get("module_id"));
		cstmt.setString(3,CommonBean.checkForNull((String)map.get("key")));//P_KEY	--->( ORDER_ID )		     
		System.err.println("172,key="+(String)map.get("key"));
		cstmt.setString(4,CommonBean.checkForNull((String)map.get("key_line_no")));
		System.err.println("172,key_line_no="+(String)map.get("key_line_no"));
		cstmt.setString(5,bill_episide_type);//P_EPISODE_TYPE
		System.err.println("172,bill_episide_type="+bill_episide_type);
		cstmt.setString(6,CommonBean.checkForNull((String)map.get("patient_id")));	    //P_PATIENT_ID	
		System.err.println("172,patient_id="+(String)map.get("patient_id"));
		cstmt.setString(7,CommonBean.checkForNull((String)map.get("episode_id")));	    //P_EPISODE_ID		 
		System.err.println("172,episode_id="+(String)map.get("episode_id"));
		cstmt.setString(8,CommonBean.checkForNull((String)map.get("visit_id")));
		//P_VISIT_ID		
		System.err.println("172,visit_id="+(String)map.get("visit_id"));
		cstmt.setString(9,CommonBean.checkForNull((String)map.get("encounter_id")));//P_DUMMY1
		System.err.println("172,encounter_id="+(String)map.get("encounter_id"));
		cstmt.setString(10,null);//ACCT_SEQ_NUMBER
		cstmt.setString(11,order_catalog);//P_ITEM_CODE	
		System.err.println("172,order_catalog="+order_catalog);
		cstmt.setString(12,CommonBean.checkForNull((String)map.get("serv_panel_ind")));  //P_SERV_PANEL_IND	 
		System.err.println("172,serv_panel_ind="+(String)map.get("serv_panel_ind"));
		cstmt.setString(13,CommonBean.checkForNull((String)map.get("serv_panel_code"))); //P_SERV_PANEL_CODE	  	
		System.err.println("172,serv_panel_code="+(String)map.get("serv_panel_code"));
		cstmt.setString(14,CommonBean.checkForNull((String) map.get("quantity")));			//P_SERV_QTY
		System.err.println("172,quantity="+(String)map.get("quantity"));
		cstmt.setString(15,null);								//P_CHARGE_BASED_AMT	  
		cstmt.setString(16,"P");								//P_PRACT_STAFF_IND	  
		cstmt.setString(17,CommonBean.checkForNull((String)map.get("pract_staff_id")));
		//P_PRACT_STAFF_ID	  
		System.err.println("172,pract_staff_id="+(String)map.get("pract_staff_id"));
		cstmt.registerOutParameter(18,Types.VARCHAR);//P_STR		      
		cstmt.registerOutParameter(19,Types.VARCHAR);//P_CHARGE_BASED_YN  
		cstmt.registerOutParameter(20,Types.FLOAT);	//P_TOT_AMT		      
		cstmt.registerOutParameter(21,Types.FLOAT);	//P_PAT_PAYABLE_AMT	  
		cstmt.registerOutParameter(22,Types.VARCHAR);//P_EXCL_INCL_IND	  
		cstmt.registerOutParameter(23,Types.VARCHAR);//P_PREAPP_YN	      
		cstmt.setString(24,null);//P_EXCL_INCL_ACTION_IND
		cstmt.setString(25,null);//P_ACTION_REASON_CODE	
		cstmt.registerOutParameter(26,Types.FLOAT);//P_PAT_PAID_AMT		  
		cstmt.registerOutParameter(27,Types.VARCHAR);//P_CHARGED_YN		  
		cstmt.registerOutParameter(28,Types.VARCHAR);//P_PAT_BILLED_YN	  
		cstmt.setString(29,(String)map.get("locale"));//P_LANGUAGE_ID	  
		cstmt.registerOutParameter(30,Types.VARCHAR);//P_ERROR_LEVEL  
		cstmt.registerOutParameter(31,Types.VARCHAR);//P_SYS_MESSAGE_ID	  
		cstmt.registerOutParameter(32,Types.VARCHAR);//P_ERROR_TEXT
		}
		cstmt.execute();
		map.put("quantity"         ,(String) map.get("quantity"));
		map.put("bl_panel_str"     , CommonBean.checkForNull(cstmt.getString(18)));
		System.err.println("172, 18==> "+CommonBean.checkForNull(cstmt.getString(18)));
		map.put("charge_based_yn"     , CommonBean.checkForNull(cstmt.getString(19)));
		System.err.println("172, 19==> "+CommonBean.checkForNull(cstmt.getString(19)));
		map.put("total_payable"    , CommonBean.checkForNull(cstmt.getString(20)));
		System.err.println("172, 20==> "+CommonBean.checkForNull(cstmt.getString(20)));
		map.put("patient_payable"  , CommonBean.checkForNull(cstmt.getString(21)));
		System.err.println("172, 21==> "+CommonBean.checkForNull(cstmt.getString(21)));
		map.put("incl_excl_ind" , CommonBean.checkForNull(cstmt.getString(22)));
		System.err.println("172, 22==> "+CommonBean.checkForNull(cstmt.getString(22)));
		map.put("preapp_yn"        , CommonBean.checkForNull(cstmt.getString(23)));
		System.err.println("172, 23==> "+CommonBean.checkForNull(cstmt.getString(23)));
		map.put("patient_paid_amt" , CommonBean.checkForNull(cstmt.getString(26)));
		System.err.println("172, 26==> "+CommonBean.checkForNull(cstmt.getString(26)));
		map.put("charged_yn"       , CommonBean.checkForNull(cstmt.getString(27)));
		System.err.println("172, 27==> "+CommonBean.checkForNull(cstmt.getString(27)));
		map.put("billed_yn"       , CommonBean.checkForNull(cstmt.getString(28)));
		System.err.println("172, 28==> "+CommonBean.checkForNull(cstmt.getString(28)));
		map.put("err_id"       , CommonBean.checkForNull(cstmt.getString(31)));
		System.err.println("172, 31==> "+CommonBean.checkForNull(cstmt.getString(31)));
		map.put("err_text"       , CommonBean.checkForNull(cstmt.getString(32)));
		System.err.println("172, 32==> "+CommonBean.checkForNull(cstmt.getString(32)));
		map.put("order_catalog",order_catalog);	
		System.err.println("172, order_catalog==>"+order_catalog);
		System.err.println("getBillingInfo out map--->"+map);
	}catch ( Exception e ) {
		e.printStackTrace();
	}finally {
		try{
			closeStatement( cstmt );
			closeConnection( connection );
			if(rst!=null) rst.close();
		 }catch(Exception es){
			 es.printStackTrace();
			}
	}
	return  map;
}

public String getOrderId(String oper_num){
	//S-->for Surgeon
	//N-->for Nursing
	String SQL = "SELECT ORDER_ID FROM OT_POST_OPER_HDR WHERE OPER_NUM = ? AND OPERATING_FACILITY_ID=? ";//KDAH-SCF-0520
	Connection connection  = null;
	PreparedStatement pstmt= null;
	ResultSet rst = null;
	String result="";
	
	try{
		connection	= getConnection();
		pstmt=connection.prepareStatement(SQL);
		pstmt.setString(1,oper_num);//order_id
		pstmt.setString(2,login_facility_id);//facility_id//KDAH-SCF-0520
		rst = pstmt.executeQuery();
		while(rst.next()){
			result = rst.getString(1);
		}
	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally {
		try{
			closeStatement( pstmt );
			closeConnection( connection );
			if(pstmt!=null) pstmt.close();
			if(rst!=null) rst.close();
		 }catch(Exception es){
			 es.printStackTrace();
		}
	}
	return  result;
}

public HashMap getBillingParams(HashMap map,String stage){
	//S-->for Surgeon,booking,checki-in stages
	//N-->for RecordNursingStages
	String SQL = "SELECT PATIENT_ID,EPISODE_TYPE,EPISODE_ID,VISIT_ID,(SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') FROM DUAL) SERV_DATE,ENCOUNTER_ID,SURGEON_CODE,PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE ORDER_ID=? AND OPERATING_FACILITY_ID=?";//KDAH-SCF-0520
	Connection connection  = null ;
	PreparedStatement pstmt= null ;
	ResultSet rst = null;
	ArrayList list = new ArrayList(2);
	String order_id ="";
	String bill_episide_type ="";
	String episode_type ="";
	String patient_class ="";
	String module_id = (String) map.get("module_id");
	String pract_staff_id = (String) map.get("pract_staff_id");
	if(("null").equals(pract_staff_id) || pract_staff_id==null)
	pract_staff_id="";
	try{
		connection	= getConnection();
		pstmt=connection.prepareStatement(SQL);
		if("S".equals(stage)){
		if("OR".equals(module_id)){
				pstmt.setString(1,(String) map.get("key"));//order_id  
				pstmt.setString(2,login_facility_id);//KDAH-SCF-0520
			}
		else{
				order_id = getOrderId((String) map.get("oper_num"));
				pstmt.setString(1,order_id);//order_id
				pstmt.setString(2,login_facility_id);//KDAH-SCF-0520
				//System.err.println("261, order_id==>"+order_id);
			}				
		}else{
				order_id = getOrderId((String) map.get("oper_num"));
				pstmt.setString(1,order_id);//order_id
				pstmt.setString(2,login_facility_id);//KDAH-SCF-0520
				//System.err.println("267, order_id==>"+order_id);		
		}

		rst = pstmt.executeQuery();
		while(rst.next()){
		map.put("patient_id",rst.getString(1));
		episode_type = rst.getString(2);
		map.put("episode_id",CommonBean.checkForNull(rst.getString(3)));
		map.put("visit_id",CommonBean.checkForNull(rst.getString(4)));
		map.put("service_date",rst.getString(5));
		map.put("encounter_id",rst.getString(6));
		if(!("").equals(pract_staff_id))
			map.put("pract_staff_id",pract_staff_id);
		else
			map.put("pract_staff_id",rst.getString(7));
			patient_class=rst.getString(8);
		}
		map.put("patient_class",patient_class);
		if(rst!=null) rst.close();
		if(pstmt!=null)pstmt.close();
		String patient_class_b=patient_class;
		String episode_type_b=episode_type;
		String sql_bl_episode_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class_b+"' ";
		pstmt = connection.prepareStatement(sql_bl_episode_type);
		rst = pstmt.executeQuery();
		while(rst.next()){
			bill_episide_type=CommonBean.checkForNull(rst.getString(1));		
		}
		if(bill_episide_type.equals("")){
			bill_episide_type=episode_type_b;
		}
		map.put("episode_type",bill_episide_type);

		if("HB".equals(stage) || "RR".equals(stage) || "OR".equals(stage)){
			//for getting service indicator & panel code for Room
			list = getPanelIndicatorAndCode((String) map.get("oper_code"),(String) map.get("episode_type"),(String) map.get("fpp_category")); //FPP_CATEGORY added for ML-MMOH-CRF-1939-US005
			map.put("serv_panel_ind","S");
			map.put("serv_panel_code",map.get("service_code"));
			map = getBillingInfo(map);
			System.err.println("303,map=="+map);
		}else if("S".equals(stage) || "O".equals(stage)){
			//for getting service panel indicator & panel code for Operations
			list = getPanelIndicatorAndCode((String) map.get("oper_code"),(String) map.get("episode_type"),(String) map.get("fpp_category"));	//FPP_CATEGORY added for ML-MMOH-CRF-1939-US004
			map.put("serv_panel_ind",list.get(0));
			map.put("serv_panel_code",list.get(1));
			map = getBillingInfo(map);
			System.err.println("310,map=="+map);
		}else{
			//for getting service panel indicator & panel code for surgical Accessories
			list = getServicePanelIndicator((String) map.get("acc_type"),(String) map.get("oper_code"));
			map.put("order_id",getOrderId((String) map.get("oper_num")));
			String oper_code = (String) map.get("oper_code");
			map.put("serv_panel_ind",list.get(0));
			map.put("serv_panel_code",list.get(1));
			map=getSurgicalBillingInfo(map,oper_code); // Here oper_code will be the acc_code
			System.err.println("320,map=="+map);
		}		
	}catch ( Exception e ){
		e.printStackTrace();
	}finally {
		try{
			closeStatement( pstmt );
			closeConnection( connection );
			if(rst!=null) rst.close();
		 }catch(Exception es){
			 es.printStackTrace();
		}
	}
	return  map;
}

public HashMap getBillingParamsForAdmin(HashMap map,String stage, HashMap map_reqd_dtls){
	//S-->for Surgeon,booking,checki-in stages
	//N-->for RecordNursingStages
	String patient_id =(String) map_reqd_dtls.get("patient_id");
	String bill_episide_type =(String) map_reqd_dtls.get("bl_episode_type");
	String patient_class =(String) map_reqd_dtls.get("patient_class");
	String episode_id =(String) map_reqd_dtls.get("episode_id");
	String visit_id =(String) map_reqd_dtls.get("visit_id");
	String service_date =(String) map_reqd_dtls.get("serv_date");
	String encounter_id =(String) map_reqd_dtls.get("encounter_id");
	String pract_staff_id1 =(String) map_reqd_dtls.get("pract_staff_id");
	String order_id =(String) map_reqd_dtls.get("order_id");
	String pract_staff_id = (String) map.get("pract_staff_id");
	if(("null").equals(pract_staff_id) || pract_staff_id==null)
	pract_staff_id="";

	if(("null").equals(pract_staff_id1) || pract_staff_id1==null)
	pract_staff_id1="";

	try{
		map.put("patient_id",patient_id);
		map.put("episode_id",episode_id);
		map.put("visit_id",visit_id);
		map.put("service_date",service_date);
		map.put("encounter_id",encounter_id);
		if(!("").equals(pract_staff_id))
		map.put("pract_staff_id",pract_staff_id);
		else
		map.put("pract_staff_id",pract_staff_id1);
		map.put("patient_class",patient_class);
		map.put("episode_type",bill_episide_type);

		if("HB".equals(stage) || "RR".equals(stage) || "OR".equals(stage)){
			//for getting service indicator & panel code for Room
			map.put("serv_panel_ind","S");
			map.put("serv_panel_code",map.get("service_code"));
			map = getBillingInfoForAdmin(map);
		}else if("S".equals(stage) || "O".equals(stage)){
			//for getting service panel indicator & panel code for Operations
			list = getPanelIndicatorAndCode((String) map.get("oper_code"),(String) map.get("episode_type"),(String) map.get("fpp_category"));	//FPP_CATEGORY added for ML-MMOH-CRF-1939-US004
			map.put("serv_panel_ind",list.get(0));
			map.put("serv_panel_code",list.get(1));
			map = getBillingInfoForAdmin(map);
		}else{
			//for getting service panel indicator & panel code for surgical Accessories
			list = getServicePanelIndicator((String) map.get("acc_type"),(String) map.get("oper_code"));
			map.put("order_id",order_id);
			String oper_code = (String) map.get("oper_code");
			map.put("serv_panel_ind",list.get(0));
			map.put("serv_panel_code",list.get(1));
			map=getSurgicalBillingInfoForAdmin(map,oper_code); // Here oper_code will be the acc_code
		}	
}catch ( Exception e ) {
		e.printStackTrace();
	}
	return  map;
}

public HashMap getBillingInfoForAdmin(HashMap map)
{
	Connection connection  = null ;
	CallableStatement cstmt= null ;
	String order_catalog = getOrderCatalogCode((String) map.get("oper_code") );
	System.err.println("412, getBillingInfoForAdmin order_catalog==>"+order_catalog);
	order_catalog = ("".equals(order_catalog))?(String) map.get("oper_code"):order_catalog;
	System.err.println("413, getBillingInfoForAdmin order_catalog==>"+order_catalog);
	try{
		connection	= getConnection() ;
		System.err.println("order_catalog === 405 "+order_catalog);
		//Added Against ML-MMOH-SCF-2008 Starts
	 ArrayList fppList = new ArrayList(2);
	fppList = getFPPDetails((String) map.get("oper_code"));
	String str = fppList.toString().replaceAll("\\[|\\]", "").replaceAll(", ",", ");
	String[] fppDetails = str.split(",");
	String fpp_yn = fppDetails[0].trim();
	//String fpp_category = fppDetails[1].trim(); 
		String bill_episide_type=(String)map.get("episode_type");
		if(fpp_yn.equals("Y"))  //Added Against ML-MMOH-CRF-1939-US004
			{
		cstmt=connection.prepareCall("{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,login_facility_id);   //P_FACILITY_ID	
		cstmt.setString(2,(String)map.get("module_id"));   //P_MODULE_ID	
		cstmt.setString(3,(String)map.get("key"));//P_KEY--->( ORDER_ID )
		cstmt.setString(4,(String)map.get("key_line_no"));
		cstmt.setString(5,bill_episide_type);//P_EPISODE_TYPE
		cstmt.setString(6,(String)map.get("patient_id")); //P_PATIENT_ID
		cstmt.setString(7,(String)map.get("episode_id")); //P_EPISODE_ID	
		cstmt.setString(8,(String)map.get("visit_id"));	  //P_VISIT_ID
		cstmt.setString(9,(String)map.get("encounter_id")); //P_DUMMY1
		cstmt.setString(10,null); //ACCT_SEQ_NUMBER 
		cstmt.setString(11,order_catalog); //P_ITEM_CODE	
		cstmt.setString(12,(String)map.get("serv_panel_ind")); //P_SERV_PANEL_IND	
		cstmt.setString(13,(String)map.get("serv_panel_code")); //P_SERV_PANEL_CODE	 
		cstmt.setString(14,(String) map.get("quantity"));//P_SERV_QTY      
		cstmt.setString(15,null); //P_CHARGE_BASED_AMT
		cstmt.setString(16,"P"); //P_PRACT_STAFF_IND	 
		cstmt.setString(17,(String)map.get("pract_staff_id"));	//P_PRACT_STAFF_ID	 
		cstmt.registerOutParameter(18,Types.VARCHAR); //P_STR	
		cstmt.registerOutParameter(19,Types.VARCHAR); //P_CHARGE_BASED_YN	
		cstmt.registerOutParameter(20,Types.FLOAT);	//P_TOT_AMT	
		cstmt.registerOutParameter(21,Types.FLOAT);	//P_PAT_PAYABLE_AMT	 
		cstmt.registerOutParameter(22,Types.VARCHAR); //P_EXCL_INCL_IND	
		cstmt.registerOutParameter(23,Types.VARCHAR); //P_PREAPP_YN	
		cstmt.setString(24,null); //P_EXCL_INCL_ACTION_IND
		cstmt.setString(25,null); //P_ACTION_REASON_CODE	
		cstmt.registerOutParameter(26,Types.FLOAT);	//P_PAT_PAID_AMT
		cstmt.registerOutParameter(27,Types.VARCHAR); //P_CHARGED_YN	
		cstmt.registerOutParameter(28,Types.VARCHAR); //P_PAT_BILLED_YN
		cstmt.setString(29,(String)map.get("locale")); //P_LANGUAGE_ID	
		cstmt.registerOutParameter(30,Types.VARCHAR); //P_ERROR_LEVEL
		cstmt.registerOutParameter(31,Types.VARCHAR); //P_SYS_MESSAGE_ID	
		cstmt.registerOutParameter(32,Types.VARCHAR); //P_ERROR_TEXT	
		cstmt.setString(33,"Y");//FPP_YN
		System.err.println("172,fpp_category="+(String)map.get("fpp_category"));
		cstmt.setString(34,(String)map.get("fpp_category"));  //ML-MMOH-CRF-1939-US005
			}
		else
		{
			cstmt=connection.prepareCall("{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,login_facility_id);   //P_FACILITY_ID	
		cstmt.setString(2,(String)map.get("module_id"));   //P_MODULE_ID	
		cstmt.setString(3,(String)map.get("key"));//P_KEY--->( ORDER_ID )
		cstmt.setString(4,(String)map.get("key_line_no"));
		cstmt.setString(5,bill_episide_type);//P_EPISODE_TYPE
		cstmt.setString(6,(String)map.get("patient_id")); //P_PATIENT_ID
		cstmt.setString(7,(String)map.get("episode_id")); //P_EPISODE_ID	
		cstmt.setString(8,(String)map.get("visit_id"));	  //P_VISIT_ID
		cstmt.setString(9,(String)map.get("encounter_id")); //P_DUMMY1
		cstmt.setString(10,null); //ACCT_SEQ_NUMBER 
		cstmt.setString(11,order_catalog); //P_ITEM_CODE	
		cstmt.setString(12,(String)map.get("serv_panel_ind")); //P_SERV_PANEL_IND	
		cstmt.setString(13,(String)map.get("serv_panel_code")); //P_SERV_PANEL_CODE	 
		cstmt.setString(14,(String) map.get("quantity"));//P_SERV_QTY      
		cstmt.setString(15,null); //P_CHARGE_BASED_AMT
		cstmt.setString(16,"P"); //P_PRACT_STAFF_IND	 
		cstmt.setString(17,(String)map.get("pract_staff_id"));	//P_PRACT_STAFF_ID	 
		cstmt.registerOutParameter(18,Types.VARCHAR); //P_STR	
		cstmt.registerOutParameter(19,Types.VARCHAR); //P_CHARGE_BASED_YN	
		cstmt.registerOutParameter(20,Types.FLOAT);	//P_TOT_AMT	
		cstmt.registerOutParameter(21,Types.FLOAT);	//P_PAT_PAYABLE_AMT	 
		cstmt.registerOutParameter(22,Types.VARCHAR); //P_EXCL_INCL_IND	
		cstmt.registerOutParameter(23,Types.VARCHAR); //P_PREAPP_YN	
		cstmt.setString(24,null); //P_EXCL_INCL_ACTION_IND
		cstmt.setString(25,null); //P_ACTION_REASON_CODE	
		cstmt.registerOutParameter(26,Types.FLOAT);	//P_PAT_PAID_AMT
		cstmt.registerOutParameter(27,Types.VARCHAR); //P_CHARGED_YN	
		cstmt.registerOutParameter(28,Types.VARCHAR); //P_PAT_BILLED_YN
		cstmt.setString(29,(String)map.get("locale")); //P_LANGUAGE_ID	
		cstmt.registerOutParameter(30,Types.VARCHAR); //P_ERROR_LEVEL
		cstmt.registerOutParameter(31,Types.VARCHAR); //P_SYS_MESSAGE_ID	
		cstmt.registerOutParameter(32,Types.VARCHAR); //P_ERROR_TEXT
		}
		cstmt.execute();
	map.put("quantity",(String) map.get("quantity"));
	map.put("bl_panel_str", CommonBean.checkForNull(cstmt.getString(18)));
	/*System.err.println("459,module_id===="+(String)map.get("module_id"));
	System.err.println("459,key===="+(String)map.get("key"));
	System.err.println("459,key_line_no===="+(String)map.get("key_line_no"));
	System.err.println("459,patient_id===="+(String)map.get("patient_id"));
	System.err.println("459,episode_id===="+(String)map.get("episode_id"));
	System.err.println("459,visit_id===="+(String)map.get("visit_id"));
	System.err.println("459,encounter_id===="+(String)map.get("encounter_id"));
	System.err.println("459,serv_panel_ind===="+(String)map.get("serv_panel_ind"));
	System.err.println("459,serv_panel_code===="+(String)map.get("serv_panel_code"));
	System.err.println("459,quantity===="+(String)map.get("quantity"));
	System.err.println("459,pract_staff_id===="+(String)map.get("pract_staff_id"));
	System.err.println("459,locale===="+(String)map.get("locale"));
	System.err.println("459,18 in OTBIllingBean===="+CommonBean.checkForNull(cstmt.getString(18)));
	System.err.println("459,20 in OTBIllingBean===="+CommonBean.checkForNull(cstmt.getString(20)));
	System.err.println("459,21 in OTBIllingBean===="+CommonBean.checkForNull(cstmt.getString(21)));
	System.err.println("459,22 in OTBIllingBean===="+CommonBean.checkForNull(cstmt.getString(22)));
	System.err.println("459,23 in OTBIllingBean===="+CommonBean.checkForNull(cstmt.getString(23)));
	System.err.println("459,26 in OTBIllingBean===="+CommonBean.checkForNull(cstmt.getString(26)));
	System.err.println("459,27 in OTBIllingBean===="+CommonBean.checkForNull(cstmt.getString(27)));
	System.err.println("459,28 in OTBIllingBean===="+CommonBean.checkForNull(cstmt.getString(28)));
	System.err.println("459,31 in OTBIllingBean===="+CommonBean.checkForNull(cstmt.getString(31)));
	System.err.println("459,32 in OTBIllingBean===="+CommonBean.checkForNull(cstmt.getString(32)));*/
	map.put("charge_based_yn"     , CommonBean.checkForNull(cstmt.getString(19)));
	map.put("total_payable"    , CommonBean.checkForNull(cstmt.getString(20)));
	map.put("patient_payable"  , CommonBean.checkForNull(cstmt.getString(21)));
	map.put("incl_excl_ind" , CommonBean.checkForNull(cstmt.getString(22)));
	map.put("preapp_yn"        , CommonBean.checkForNull(cstmt.getString(23)));
	map.put("patient_paid_amt" , CommonBean.checkForNull(cstmt.getString(26)));
	map.put("charged_yn"       , CommonBean.checkForNull(cstmt.getString(27)));
	map.put("billed_yn"       , CommonBean.checkForNull(cstmt.getString(28)));
	map.put("err_id"       , CommonBean.checkForNull(cstmt.getString(31)));
	map.put("err_text"       , CommonBean.checkForNull(cstmt.getString(32)));
	map.put("order_catalog",order_catalog);
	}catch ( Exception e ) {
		e.printStackTrace();
	}finally {
		try{
			closeStatement( cstmt );
			closeConnection( connection );
		 }catch(Exception es){
			 es.printStackTrace();
			}
	}
	return  map;
}

public HashMap getSurgicalBillingInfoForAdmin(HashMap map,String order_catalog){
	Connection connection  = null ;
	CallableStatement cstmt= null ;
	try{
		System.err.println("491, InfoForAdmin map === "+map);
		connection	= getConnection() ;
		String bill_episide_type=(String)map.get("episode_type");
		
		cstmt=connection.prepareCall("{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	
		cstmt.setString(1,login_facility_id); //P_FACILITY_ID		  
		cstmt.setString(2,"OT"); //P_MODULE_ID		      
		cstmt.setString(3,(String)map.get("key")); //P_KEY --->(ORDER_ID)  
		cstmt.setString(4,(String)map.get("key_line_no"));
		cstmt.setString(5,bill_episide_type); //P_EPISODE_TYPE		  
		cstmt.setString(6,(String)map.get("patient_id")); //P_PATIENT_ID  
		cstmt.setString(7,(String)map.get("episode_id")); //P_EPISODE_ID  
		cstmt.setString(8,(String)map.get("visit_id")); //P_VISIT_ID      
		cstmt.setString(9,(String)map.get("encounter_id")); //P_DUMMY1   
		cstmt.setString(10,null); //ACCT_SEQ_NUMBER 
		cstmt.setString(11,order_catalog); //P_ITEM_CODE		      
		cstmt.setString(12,(String)map.get("serv_panel_ind"));  //P_SERV_PANEL_IND	  
		cstmt.setString(13,(String)map.get("serv_panel_code")); //P_SERV_PANEL_CODE	  
		cstmt.setString(14,(String) map.get("quantity") ); //P_SERV_QTY    
		cstmt.setString(15,null); //P_CHARGE_BASED_AMT	  
		cstmt.setString(16,"P"); //P_PRACT_STAFF_IND	  
		cstmt.setString(17,(String)map.get("pract_staff_id"));	//P_PRACT_STAFF_ID	  
		cstmt.registerOutParameter(18,Types.VARCHAR); //P_STR  
		cstmt.registerOutParameter(19,Types.VARCHAR); //P_CHARGE_BASED_YN  
		cstmt.registerOutParameter(20,Types.FLOAT);	//P_TOT_AMT		      
		cstmt.registerOutParameter(21,Types.FLOAT);	//P_PAT_PAYABLE_AMT	  
		cstmt.registerOutParameter(22,Types.VARCHAR); //P_EXCL_INCL_IND  
		cstmt.registerOutParameter(23,Types.VARCHAR); //P_PREAPP_YN   
		cstmt.setString(24,null); //P_EXCL_INCL_ACTION_IND
		cstmt.setString(25,null); //P_ACTION_REASON_CODE	
		cstmt.registerOutParameter(26,Types.FLOAT); //P_PAT_PAID_AMT
		cstmt.registerOutParameter(27,Types.VARCHAR); //P_CHARGED_YN  
		cstmt.registerOutParameter(28,Types.VARCHAR); //P_PAT_BILLED_YN  
		cstmt.setString(29,(String)map.get("locale")); //P_LANGUAGE_ID  
		cstmt.registerOutParameter(30,Types.VARCHAR); //P_ERROR_LEVEL  
		cstmt.registerOutParameter(31,Types.VARCHAR); //P_SYS_MESSAGE_ID 
		cstmt.registerOutParameter(32,Types.VARCHAR); //P_ERROR_TEXT	
		cstmt.execute();
	map.put("quantity",(String) map.get("quantity"));
	map.put("bl_panel_str",CommonBean.checkForNull(cstmt.getString(18)));
	//System.err.println("531, bl_panel_str in OTBIllingBean "+CommonBean.checkForNull(cstmt.getString(18)));
	map.put("charge_based_yn"     , CommonBean.checkForNull(cstmt.getString(19)));
	map.put("total_payable"    , CommonBean.checkForNull(cstmt.getString(20)));
	map.put("patient_payable"  , CommonBean.checkForNull(cstmt.getString(21)));
	map.put("incl_excl_ind" , CommonBean.checkForNull(cstmt.getString(22)));
	map.put("preapp_yn"        , CommonBean.checkForNull(cstmt.getString(23)));
	map.put("patient_paid_amt" , CommonBean.checkForNull(cstmt.getString(26)));
	map.put("charged_yn"       , CommonBean.checkForNull(cstmt.getString(27)));
	map.put("billed_yn"       , CommonBean.checkForNull(cstmt.getString(28)));
	map.put("err_id"       , CommonBean.checkForNull(cstmt.getString(31)));
	map.put("err_text"       , CommonBean.checkForNull(cstmt.getString(32)));
	map.put("order_catalog",order_catalog);

	System.err.println("545, after InfoForAdmin map === "+map);
	}catch ( Exception e ){
		e.printStackTrace();
	}finally {
		try{
			closeStatement( cstmt );
			closeConnection( connection );
		 }catch(Exception es){
			 es.printStackTrace();
		}
	}
	return  map;
}

public HashMap getCheckInBillingParams(HashMap map,String stage)
{
	//S-->for Surgeon,booking,checki-in stages
	//N-->for RecordNursingStages
	String called_from=(String) map.get("called_from");
	String SQL="";
	
	if("BOOKING".equals(called_from)|| "OR".equals(called_from))
	{
		 SQL = "SELECT PATIENT_ID,EPISODE_TYPE,EPISODE_ID,VISIT_ID,(SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') FROM DUAL) SERV_DATE,ENCOUNTER_ID,PHYSICIAN_ID SURGEON_CODE,PATIENT_CLASS FROM OT_PENDING_ORDER WHERE ORDER_ID=? AND PERFORMING_FACILITY_ID=?";//KDAH-SCF-0520
	 	//System.err.println("569, BillingParams SQL === "+SQL);
	}else{
		SQL = "SELECT PATIENT_ID,EPISODE_TYPE,EPISODE_ID,VISIT_ID,(SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') FROM DUAL) SERV_DATE,ENCOUNTER_ID,TEAM_DOCTOR_CODE SURGEON_CODE,PATIENT_CLASS FROM OT_BOOKING_HDR WHERE ORDER_ID=? AND OPERATING_FACILITY_ID=?";//KDAH-SCF-0520
	 	//System.err.println("572, BillingParams SQL === "+SQL);
	}
	Connection connection  = null ;
	PreparedStatement pstmt= null ;
	ResultSet rst = null;
	ArrayList list = new ArrayList(2);
	String order_id ="";
	String episode_type ="";
	String patient_class ="";
	String bl_episode_type ="";
	String module_id = (String) map.get("module_id");
	try{
		connection	= getConnection();
		pstmt=connection.prepareStatement(SQL);
		if("S".equals(stage)){
			if("OR".equals(module_id))
			{
				pstmt.setString(1,(String) map.get("key"));//order_id
				pstmt.setString(2,login_facility_id);//KDAH-SCF-0520
			}
			else{
				order_id = getOrderId((String) map.get("oper_num"));
				pstmt.setString(1,order_id);//order_id
				pstmt.setString(2,login_facility_id);//KDAH-SCF-0520
			}				
			}else
			{
				 order_id = getOrderId((String) map.get("oper_num"));
				 pstmt.setString(1,order_id);//order_id
				 pstmt.setString(2,login_facility_id);//KDAH-SCF-0520
			}
		rst = pstmt.executeQuery();
		while(rst.next()){
			map.put("patient_id",rst.getString("PATIENT_ID"));
			episode_type=rst.getString("EPISODE_TYPE");
			map.put("episode_id",CommonBean.checkForNull(rst.getString("EPISODE_ID")));
			map.put("visit_id",CommonBean.checkForNull(rst.getString("VISIT_ID"),"1"));
			map.put("service_date",rst.getString("SERV_DATE"));
			map.put("encounter_id",rst.getString("ENCOUNTER_ID"));
			map.put("pract_staff_id",rst.getString("SURGEON_CODE"));
			patient_class=rst.getString("PATIENT_CLASS");
			map.put("patient_class",patient_class);
		}
		if(pstmt !=null) pstmt.close();
		if(rst !=null) rst.close();
		
		String sql_bl_episode_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";
		pstmt = connection.prepareStatement(sql_bl_episode_type);
		rst = pstmt.executeQuery();
		while(rst.next()){
			bl_episode_type=CommonBean.checkForNull(rst.getString(1));	
		}
		map.put("episode_type",bl_episode_type);			
		if("S".equals(stage) || "O".equals(stage)){
			//for getting service panel indicator & panel code for Operations
			list = getPanelIndicatorAndCode((String) map.get("oper_code"),(String) map.get("episode_type"),(String) map.get("fpp_category"));	//FPP_CATEGORY added for ML-MMOH-CRF-1939-US005
			map.put("serv_panel_ind",list.get(0));
			map.put("serv_panel_code",list.get(1));
			map = getBillingInfo(map);
		}else{
			//for getting service panel indicator & panel code for surgical Accessories
			list = getServicePanelIndicator((String) map.get("acc_type"),(String) map.get("oper_code"));
			map.put("order_id",getOrderId((String) map.get("oper_num")));
			String oper_code = (String) map.get("oper_code");
			map.put("serv_panel_ind",list.get(0));
			map.put("serv_panel_code",list.get(1));
			map=getSurgicalBillingInfo(map,oper_code); // Here oper_code will be the acc_code
		}
}catch ( Exception e ) {
		e.printStackTrace();
	}finally {
		try{
			closeStatement( pstmt );
			closeConnection( connection );
			if(rst !=null) rst.close();
		 }catch(Exception es){
			 es.printStackTrace();
		}
	}
	return  map;
}
	
public HashMap getORBillingParams(String oper_num){
	//S-->for Surgeon
	//N-->for Nursing
	String SQL = "SELECT PATIENT_ID,EPISODE_TYPE,EPISODE_ID,VISIT_ID,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),ENCOUNTER_ID,PATIENT_CLASS,SURGEON_CODE FROM OT_POST_OPER_HDR WHERE ORDER_ID=? AND OPERATING_FACILITY_ID=?";//KDAH-SCF-0520
	Connection connection  = null ;
	PreparedStatement pstmt= null ;
	ResultSet rst = null;
	String order_id ="";
	HashMap map = new HashMap();
	try{
		connection	= getConnection() ;
		pstmt=connection.prepareStatement(SQL);
		order_id = getOrderId(oper_num);
		pstmt.setString(1,order_id);//order_id
		pstmt.setString(2,login_facility_id);//KDAH-SCF-0520
		rst = pstmt.executeQuery();
		while(rst.next()){
		map.put("patient_id",rst.getString(1));
		map.put("episode_type",rst.getString(2));
		map.put("episode_id",CommonBean.checkForNull(rst.getString(3)));
		map.put("visit_id",CommonBean.checkForNull(rst.getString(4),"1"));
		map.put("service_date",rst.getString(5));
		map.put("encounter_id",rst.getString(6));
		map.put("patient_class",rst.getString(7));
		map.put("pract_staff_id",rst.getString(8));
		}
	}catch ( Exception e ) {
		e.printStackTrace();
	}finally {
		try{
			closeStatement( pstmt );
			closeConnection( connection );
			if(rst!=null) rst.close();
		 }catch(Exception es){
			 es.printStackTrace();
		}
	}
	return  map;
}

public HashMap getORBillingParamsForAdmin(String oper_num, HashMap map_reqd_dtls){
	String patient_id =(String) map_reqd_dtls.get("patient_id");
	String episode_type =(String) map_reqd_dtls.get("episode_type");
	String patient_class =(String) map_reqd_dtls.get("patient_class");
	String episode_id =(String) map_reqd_dtls.get("episode_id");
	String visit_id =(String) map_reqd_dtls.get("visit_id");
	String service_date =(String) map_reqd_dtls.get("serv_date");
	String encounter_id =(String) map_reqd_dtls.get("encounter_id");
	String pract_staff_id1 =(String) map_reqd_dtls.get("pract_staff_id");
	HashMap map = new HashMap();	
	map.put("patient_id",patient_id);
	map.put("episode_type",episode_type);
	map.put("episode_id",episode_id);
	map.put("visit_id",visit_id);
	map.put("service_date",service_date);
	map.put("encounter_id",encounter_id);
	map.put("patient_class",patient_class);
	map.put("pract_staff_id",pract_staff_id1);
	return  map;
}	

public HashMap formatBillingDetails(ArrayList bill_dtls){
	HashMap bill_map = new HashMap();

	System.err.println("721, bill_dtls "+bill_dtls);
	if(bill_dtls!=null && bill_dtls.size()>0){
		String[] bill_info = (String[]) bill_dtls.get(0);
		bill_map.put("bl_panel_str",bill_info[0]);   //P_STR
		System.err.println("721, bl_panel_str in OTBIllingBean "+bill_info[0]);
		bill_map.put("charge_based_yn",bill_info[1]); //P_CHARGE_BASED_YN 
		bill_map.put("total_payable",bill_info[2]); //P_TOT_AMT
		bill_map.put("patient_payable",bill_info[3]); //P_PAT_PAYABLE_AMT
		bill_map.put("incl_excl_ind",bill_info[4]); //P_EXCL_INCL_IND
		bill_map.put("preapp_yn",bill_info[5]); //P_PREAPP_YN
		bill_map.put("patient_paid_amt",bill_info[6]); //P_PAT_PAID_AMT    
		bill_map.put("charged_yn",bill_info[7]); //P_CHARGED_YN        
		bill_map.put("pat_billed_yn",bill_info[8]); //P_PAT_BILLED_YN     
		bill_map.put("error_text",bill_info[9]); //ERROR_TEXT           
		bill_map.put("serv_panel_ind",bill_info[10]); //P_SERV_PANEL_IND
		bill_map.put("serv_panel_code",bill_info[11]); //P_SERV_PANEL_CODE 
		bill_map.put("service_panel_name",bill_info[12]);//P_SERV_PANELNAME
		bill_map.put("episode_type",bill_info[13]); //P_EPISODE_TYPE
		bill_map.put("episode_id",bill_info[14]); //P_EPISODE_ID
		bill_map.put("visit_id",bill_info[15]); //P_VISIT_ID        
		//other billing details
		bill_map.put("pract_staff_ind","P");   
		System.err.println("743, bill_map "+bill_map);				
}
	return bill_map;
}

public String getOrderCatalogCode(String oper_code){
	String SQL = "SELECT ORDER_CATALOG_CODE FROM OT_OPER_MAST WHERE OPER_CODE=?";
	Connection connection  = null;
	PreparedStatement pstmt= null;
	ResultSet rst = null;
	String result="";
	
	try{
		connection	= getConnection();
		pstmt=connection.prepareStatement(SQL);
		pstmt.setString(1,oper_code);
		//System.err.println("759, getOrderCatalogCode oper_code===>"+oper_code);
		rst = pstmt.executeQuery();
		while(rst.next()){
			result = rst.getString(1);
		}
	}catch ( Exception e ){
		e.printStackTrace();
	}finally {
		try{
			closeStatement( pstmt );
			closeConnection( connection );
			if(rst !=null) rst.close();
		 }catch(Exception es){
			 es.printStackTrace();
		}
	}
	//System.err.println("775, getOrderCatalogCode result===>"+result);
	return  result;
}

public ArrayList<String> getFPPDetails(String oper_code) //Added Against ML-MMOH-SCF-2008
{
	String SQL = "SELECT NVL (fpp_yn, 'N'), FPP_CATEGORY FROM or_order_catalog WHERE order_catalog_code=?";
	Connection connection  = null;
	PreparedStatement pstmt= null;
	ResultSet rst = null;
	String fpp_yn="";
	String fpp_category="";
	ArrayList fppList = new ArrayList(2);
	try{
		connection	= getConnection();
		pstmt=connection.prepareStatement(SQL);
		pstmt.setString(1,oper_code);
		//System.err.println("759, getOrderCatalogCode oper_code===>"+oper_code);
		rst = pstmt.executeQuery();
		while(rst.next()){
			fpp_yn = rst.getString(1);
			fpp_category = rst.getString(2);
		}
		fppList.add(fpp_yn);
		fppList.add(fpp_category);
	}catch ( Exception e ){
		e.printStackTrace();
	}finally {
		try{
			closeStatement( pstmt );
			closeConnection( connection );
			if(rst !=null) rst.close();
		 }catch(Exception es){
			 es.printStackTrace();
		}
	}
	//System.err.println("775, getOrderCatalogCode result===>"+result);
	return fppList;
}

public String billingPostedYN(String oper_num,String oper_line_num){
	String SQL = "SELECT 'X' FROM BL_PATIENT_CHARGES_INTERFACE WHERE OPERATING_FACILITY_ID = ?  AND SEC_KEY_MODULE_ID='OT' AND SEC_KEY_MAIN=? AND SEC_KEY_LINE_NO = ?";
	Connection connection  = null ;
	PreparedStatement pstmt= null ;
	ResultSet rst = null;
	String result="";
	
	try{
		connection	= getConnection();
		pstmt=connection.prepareStatement(SQL);
		pstmt.setString(1,login_facility_id);
		pstmt.setString(2,oper_num);
		pstmt.setString(3,oper_line_num);
		rst = pstmt.executeQuery();
		while(rst.next()){
			result = rst.getString(1);
		}
	}catch ( Exception e ) {
		e.printStackTrace();
	}finally {
		try{
			closeStatement( pstmt );
			closeConnection( connection );
		 }catch(Exception es){
			 es.printStackTrace();
		}
	}
	return  result;
}

public HashMap getSurgicalBillingInfo(HashMap map,String order_catalog){
	Connection connection  = null;
	CallableStatement cstmt= null;
	PreparedStatement pstmt= null;
	ResultSet rst= null;
	String bill_episide_type="";
	try{

		connection	= getConnection();
		if(rst!=null) rst.close();
		if(pstmt!=null)pstmt.close();
		String patient_class_b=(String)map.get("patient_class");
		String episode_type_b=(String)map.get("episode_type");
		String sql_bl_episode_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class_b+"' AND EPISODE_TYPE ='"+episode_type_b+"' ";
		pstmt = connection.prepareStatement(sql_bl_episode_type);
		rst = pstmt.executeQuery();
		while(rst.next()){
			bill_episide_type=CommonBean.checkForNull(rst.getString(1));	
		}
		if(bill_episide_type.equals("")){
			bill_episide_type=episode_type_b;
		}

		System.err.println("832, map SurgicalBillingInfo==="+map);
		cstmt=connection.prepareCall("{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,login_facility_id); //P_FACILITY_ID		  
		cstmt.setString(2,"OT"); //P_MODULE_ID		      
		cstmt.setString(3,(String)map.get("key")); //P_KEY--->(ORDER_ID)   
		cstmt.setString(4,(String)map.get("key_line_no"));
		cstmt.setString(5,bill_episide_type);//P_EPISODE_TYPE		  
		cstmt.setString(6,(String)map.get("patient_id")); //P_PATIENT_ID  
		cstmt.setString(7,(String)map.get("episode_id")); //P_EPISODE_ID  
		cstmt.setString(8,(String)map.get("visit_id"));	//P_VISIT_ID      
		cstmt.setString(9,(String)map.get("encounter_id"));	//P_DUMMY1    
		cstmt.setString(10,null); //ACCT_SEQ_NUMBER 
		cstmt.setString(11,order_catalog);	    //P_ITEM_CODE		      
		cstmt.setString(12,(String)map.get("serv_panel_ind")); //P_SERV_PANEL_IND	  
		cstmt.setString(13,(String)map.get("serv_panel_code")); //P_SERV_PANEL_CODE	  
		cstmt.setString(14,(String) map.get("quantity") ); //P_SERV_QTY    
		cstmt.setString(15,null); //P_CHARGE_BASED_AMT	  
		cstmt.setString(16,"P"); //P_PRACT_STAFF_IND	  
		cstmt.setString(17,(String)map.get("pract_staff_id"));	//P_PRACT_STAFF_ID	  
		cstmt.registerOutParameter(18,Types.VARCHAR); //P_STR		      
		cstmt.registerOutParameter(19,Types.VARCHAR); //P_CHARGE_BASED_YN  
		cstmt.registerOutParameter(20,Types.FLOAT);	//P_TOT_AMT		      
		cstmt.registerOutParameter(21,Types.FLOAT);	//P_PAT_PAYABLE_AMT	  
		cstmt.registerOutParameter(22,Types.VARCHAR); //P_EXCL_INCL_IND  
		cstmt.registerOutParameter(23,Types.VARCHAR); //P_PREAPP_YN	      
		cstmt.setString(24,null); //P_EXCL_INCL_ACTION_IND
		cstmt.setString(25,null); //P_ACTION_REASON_CODE	
		cstmt.registerOutParameter(26,Types.FLOAT);	//P_PAT_PAID_AMT  
		cstmt.registerOutParameter(27,Types.VARCHAR); //P_CHARGED_YN  
		cstmt.registerOutParameter(28,Types.VARCHAR); //P_PAT_BILLED_YN  
		cstmt.setString(29,(String)map.get("locale")); //P_LANGUAGE_ID  
		cstmt.registerOutParameter(30,Types.VARCHAR); //P_ERROR_LEVEL 
		cstmt.registerOutParameter(31,Types.VARCHAR); //P_SYS_MESSAGE_ID  
		cstmt.registerOutParameter(32,Types.VARCHAR); //P_ERROR_TEXT
		cstmt.execute();
	map.put("quantity",(String) map.get("quantity"));
	map.put("bl_panel_str", CommonBean.checkForNull(cstmt.getString(18)));
	System.err.println("869, bl_panel_str in OTBIllingBean "+CommonBean.checkForNull(cstmt.getString(18)));
	map.put("charge_based_yn"  , CommonBean.checkForNull(cstmt.getString(19)));
	map.put("total_payable"  , CommonBean.checkForNull(cstmt.getString(20)));
	map.put("patient_payable" , CommonBean.checkForNull(cstmt.getString(21)));
	map.put("incl_excl_ind" , CommonBean.checkForNull(cstmt.getString(22)));
	map.put("preapp_yn" , CommonBean.checkForNull(cstmt.getString(23)));
	map.put("patient_paid_amt" , CommonBean.checkForNull(cstmt.getString(26)));
	map.put("charged_yn" , CommonBean.checkForNull(cstmt.getString(27)));
	map.put("billed_yn" , CommonBean.checkForNull(cstmt.getString(28)));
	map.put("err_id"  , CommonBean.checkForNull(cstmt.getString(31)));
	map.put("err_text" , CommonBean.checkForNull(cstmt.getString(32)));
	map.put("order_catalog",order_catalog);

	System.err.println("882 after executing procedure==="+map);
	}catch ( Exception e ) {
		e.printStackTrace();
	}finally {
		try{
			closeStatement( cstmt );
			closeConnection( connection );
			if(rst!=null)   rst.close();
			if(pstmt!=null) pstmt.close();
		 }catch(Exception es){
			 es.printStackTrace();
		}
	}
	return  map;
}

public ArrayList getBookingDetails(OtCommonGettersSetters getDets, int chkBookingDays)
{
	Connection connection  = null;
	PreparedStatement pstmt = null;
	PreparedStatement getMaxTimePstmt = null;//186
	ResultSet rst = null;
	ResultSet getMaxTimeRs = null;//186
	ArrayList getBookingDates = null;
	OtCommonGettersSetters setBookingDets = null;
	StringBuffer getBookingDetailsBuffer = new StringBuffer();
	StringBuffer getMaxTimeBuffer = new StringBuffer();//186
	int setIndex = 0;
	
	getBookingDetailsBuffer.append("	SELECT  distinct a.booking_num, a.order_id,	");
	getBookingDetailsBuffer.append("	TO_CHAR (nvl(b.booking_date,a.booking_date), 'DD/MM/YYYY') booking_date,	");
	getBookingDetailsBuffer.append("	TO_CHAR (nvl(b.from_time,a.booking_start_time), 'HH24:MI') from_time1,	");
	getBookingDetailsBuffer.append("	TO_CHAR (NVL (a.booking_start_time,b.from_time), 'DD/MM/YYYY HH24:MI') from_date_time,	"); // IN 57374
	getBookingDetailsBuffer.append("	TO_CHAR (nvl(b.to_time,a.booking_end_time), 'HH24:MI') to_time,	");
	getBookingDetailsBuffer.append("	a.patient_id patient_id,	");
	getBookingDetailsBuffer.append("	DECODE (?, ?, e.patient_name, e.patient_name_loc_lang) patient_name,	");
	getBookingDetailsBuffer.append("	a.oper_room_code,	");
	getBookingDetailsBuffer.append("	(SELECT c.short_desc	");
	getBookingDetailsBuffer.append("	FROM ot_oper_room_lang_vw c	");
	getBookingDetailsBuffer.append("	WHERE c.oper_room_code = oper_room_code	");
	getBookingDetailsBuffer.append("	AND c.oper_room_code = a.oper_room_code	");
	getBookingDetailsBuffer.append("	AND c.language_id = ?) oper_room_desc,	");
	getBookingDetailsBuffer.append("	NVL (nvl(b.surgeon_code,team_doctor_code), '*ALL') surgeon_code,	");
	getBookingDetailsBuffer.append("	(SELECT practitioner_name	");
	getBookingDetailsBuffer.append("	FROM am_practitioner_lang_vw	");
	getBookingDetailsBuffer.append("	WHERE practitioner_id = nvl(b.surgeon_code,team_doctor_code)	");
	getBookingDetailsBuffer.append("	AND language_id = ?) surgeon_name,	");
	getBookingDetailsBuffer.append("	a.speciality_code speciality_code,	");
	getBookingDetailsBuffer.append("	(select Long_DESC  from am_speciality where SPECIALITY_CODE=a.SPECIALITY_CODE)speciality_desc,	");
	getBookingDetailsBuffer.append("	a.OVER_BOOKED_YN overbookedstatus,	");		
	getBookingDetailsBuffer.append("	c.oper_code,	");
	getBookingDetailsBuffer.append("	d.short_desc oper_desc,	");
	getBookingDetailsBuffer.append("	b.multiple_opers_yn multiple_opers_yn,	");
	getBookingDetailsBuffer.append("	b.status status, b.tool_tip_msg tool_tip_msg	");
	getBookingDetailsBuffer.append("	FROM ot_booking_hdr a,	");
	getBookingDetailsBuffer.append("	ot_booking_time_slots_vw b,	");
	getBookingDetailsBuffer.append("	ot_booking_dtls c,	");
	getBookingDetailsBuffer.append("	ot_oper_mast d,	");
	getBookingDetailsBuffer.append("	mp_patient e	");
	getBookingDetailsBuffer.append("	WHERE a.operating_facility_id = ?	");
	getBookingDetailsBuffer.append("	AND a.patient_id = b.patient_id(+)	");
	getBookingDetailsBuffer.append("	AND a.patient_id = ?	");
	getBookingDetailsBuffer.append("	AND a.BOOKING_NUM = b.BOOKING_NUM(+)	");
	getBookingDetailsBuffer.append("	AND a.oper_room_code = b.oper_room_code(+)	");
	getBookingDetailsBuffer.append("	AND a.booking_date = b.booking_date(+)	");	
	
	getBookingDetailsBuffer.append("	AND NVL (b.language_id, ?) = ?	");
	getBookingDetailsBuffer.append("	AND a.booking_num = c.booking_num	");
	getBookingDetailsBuffer.append("	AND c.oper_code = d.oper_code	");
	getBookingDetailsBuffer.append("	AND a.patient_id = e.patient_id	");
	getBookingDetailsBuffer.append("	AND a.BOOKING_STATUS != '9'	");
	getBookingDetailsBuffer.append("	AND c.line_num = 1	");
	getBookingDetailsBuffer.append("	AND (((SELECT COUNT (*) slots	");
	getBookingDetailsBuffer.append("	FROM ot_diary_schedule	");
	getBookingDetailsBuffer.append("	WHERE operating_facility_id = ?	");
	getBookingDetailsBuffer.append("	AND (b.booking_date > SYSDATE  AND b.booking_date < SYSDATE + ?)) > 0)	");
	getBookingDetailsBuffer.append("	OR	");
	getBookingDetailsBuffer.append("	((SELECT COUNT (*) slots	");
	getBookingDetailsBuffer.append("	FROM ot_diary_schedule	");
	getBookingDetailsBuffer.append("	WHERE operating_facility_id = ?	");//booking_start_time
	getBookingDetailsBuffer.append("	AND (a.booking_start_time > SYSDATE  AND a.booking_start_time < SYSDATE + ?)) > 0)	");//186
	getBookingDetailsBuffer.append("	)             	");
	getBookingDetailsBuffer.append("	AND ((b.booking_date > SYSDATE AND b.booking_date < SYSDATE + ?) OR (a.booking_start_time > SYSDATE AND a.booking_start_time < SYSDATE + ?))	");//186
	getBookingDetailsBuffer.append("	AND EXISTS (	");
	getBookingDetailsBuffer.append("	SELECT 1 AS booking_final	");
	getBookingDetailsBuffer.append("	FROM ot_queue b	");
	getBookingDetailsBuffer.append("	WHERE b.appt_ref_num = nvl(b.booking_num,a.booking_num)	");

	//Added by vikash on 27-Sept-15 starts
	getBookingDetailsBuffer.append("	AND b.booking_stage <	");
	getBookingDetailsBuffer.append("	(SELECT stage_code	");
	getBookingDetailsBuffer.append("	FROM ot_booking_fin_stages	");
	getBookingDetailsBuffer.append("	WHERE serial_no = (SELECT MAX (serial_no)	");
	getBookingDetailsBuffer.append("	FROM ot_booking_fin_stages)))	");	
	//Added by vikash on 27-Sept-15 ends
	
	//Added Against MMS-CRf-0186 For Getting OverBooking List End
	getMaxTimeBuffer.append("	SELECT   MAX (TO_CHAR (to_time, 'HH24:MI')) max_to_time	");
	getMaxTimeBuffer.append("	FROM ot_booking_time_slots_vw	");
	getMaxTimeBuffer.append("	WHERE oper_room_code = ?	");
	getMaxTimeBuffer.append("	AND operating_facility_id = ?	");
	getMaxTimeBuffer.append("	AND NVL (language_id, ?) = ?	");
	getMaxTimeBuffer.append("	AND (SELECT COUNT (*) slots	");
	getMaxTimeBuffer.append("	FROM ot_diary_schedule	");
	getMaxTimeBuffer.append("	WHERE operating_facility_id = ?	");
	getMaxTimeBuffer.append("	AND oper_room_code = ?	");
	getMaxTimeBuffer.append("	AND booking_date = TO_DATE (?, 'DD/MM/YYYY')	");
	getMaxTimeBuffer.append("	AND team_doctor_code = '*ALL') > 0	");
	getMaxTimeBuffer.append("	AND booking_date = TO_DATE (?, 'DD/MM/YYYY')	");
//186
	System.err.println("992, getBookingDetailsBuffer========"+ getBookingDetailsBuffer.toString());
	System.err.println("993, getMaxTimeBuffer========"+ getMaxTimeBuffer.toString());
	
	try
	{
		connection = getConnection();
		storeBookingDetails = new HashMap();
		getBookingDates = new ArrayList();
		if(connection == null)
			return getBookingDates;
		pstmt=connection.prepareStatement(getBookingDetailsBuffer.toString().trim());
		getMaxTimePstmt=connection.prepareStatement(getMaxTimeBuffer.toString().trim());	

		//newly added for MMS -CRF-186 OverBooking query Start
		pstmt.setString(++setIndex, getDets.getLanguageId());//1
		pstmt.setString(++setIndex, getDets.getLanguageId());//2
		pstmt.setString(++setIndex, getDets.getLanguageId());//3
		pstmt.setString(++setIndex, getDets.getLanguageId());//4
		pstmt.setString(++setIndex, login_facility_id);//5
		pstmt.setString(++setIndex, getDets.getPatientId());//6
		pstmt.setString(++setIndex, getDets.getLanguageId());//7
		pstmt.setString(++setIndex, getDets.getLanguageId());//8
		pstmt.setString(++setIndex, login_facility_id);//9
		pstmt.setInt(++setIndex, chkBookingDays);//10
		pstmt.setString(++setIndex, login_facility_id);//11
		pstmt.setInt(++setIndex, chkBookingDays);//12
		pstmt.setInt(++setIndex, chkBookingDays);//13
		pstmt.setInt(++setIndex, chkBookingDays);//14		
		
		//newly added for MMS-CRf-186 OverBooking Query End
		
		//JDBCStatementLogger.logQueryStringDetails("getBookingDetails","OTBillingBean", pstmt);//Testing
	rst = pstmt.executeQuery();
	while(rst.next())
	{
		setIndex = 0;//186
		setBookingDets = new OtCommonGettersSetters();
		setBookingDets.setBookingNum(rst.getString("booking_num"));//186
		setBookingDets.setBookingDate(rst.getString("booking_date"));
		setBookingDets.setFromTime(rst.getString("from_time1"));
		setBookingDets.setToTime(rst.getString("to_time"));
		setBookingDets.setFromDateTime(rst.getString("from_date_time"));
		setBookingDets.setPatientId(rst.getString("patient_id"));
		setBookingDets.setPatientShortName(rst.getString("patient_name"));
		setBookingDets.setSurgeonCode(rst.getString("surgeon_code"));//186
		setBookingDets.setSurgeonName(rst.getString("surgeon_name"));
		setBookingDets.setSpecialityCode(rst.getString("speciality_code"));
		setBookingDets.setSpecialityDesc(rst.getString("speciality_desc"));
		setBookingDets.setOperShortDesc(rst.getString("oper_desc"));
		setBookingDets.setOperRoomCode(rst.getString("oper_room_code"));
		setBookingDets.setOperRoomDesc(rst.getString("oper_room_desc"));
		setBookingDets.setOrderId(rst.getString("order_id"));
		setBookingDets.setOverBookedStatus(rst.getString("overbookedstatus"));//Added for OverBooked Cases Color Code			

		getMaxTimePstmt.setString(++setIndex, setBookingDets.getOperRoomCode());
		getMaxTimePstmt.setString(++setIndex, login_facility_id);
		getMaxTimePstmt.setString(++setIndex, getDets.getLanguageId());
		getMaxTimePstmt.setString(++setIndex, getDets.getLanguageId());
		getMaxTimePstmt.setString(++setIndex, login_facility_id);
		getMaxTimePstmt.setString(++setIndex, setBookingDets.getOperRoomCode());
		getMaxTimePstmt.setString(++setIndex, setBookingDets.getBookingDate());
		getMaxTimePstmt.setString(++setIndex, setBookingDets.getBookingDate());			
			
		getMaxTimeRs = getMaxTimePstmt.executeQuery();
		while(getMaxTimeRs.next())
			setBookingDets.setBookingTime(getMaxTimeRs.getString("max_to_time"));
		getBookingDates.add(setBookingDets);
		storeBookingDetails.put(rst.getString("booking_date"), setBookingDets);
		
		closeResultSet(getMaxTimeRs);		//Added Against Common-ICN-0054
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
			closeStatement(getMaxTimePstmt);	//Added Against Common-ICN-0031
			closeResultSet(getMaxTimeRs);		//Added Against Common-ICN-0031
			closeStatement(pstmt);
			closeConnection(connection);
			if(rst !=null)
				rst.close();
		 }
		 catch(Exception es)
		 {
			es.printStackTrace();
		 }
	}
	return getBookingDates;
}
}

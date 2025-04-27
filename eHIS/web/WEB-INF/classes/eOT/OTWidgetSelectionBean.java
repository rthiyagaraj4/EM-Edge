/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import eCommon.Common.CommonBean;
import java.util.Properties;
import eOT.Common.OTAdapter;
import eOT.Common.OTRepository;


public class OTWidgetSelectionBean extends OTAdapter implements Serializable {


	Properties	p = this.properties;
	String	locale	= "";

	
	public OTWidgetSelectionBean() {
		try {
			doCommon();
		}catch(Exception e) {}
	}
	public void doCommon() throws Exception {
		locale	= (String) p.getProperty("LOCALE");
	}

	public void clear(){
		super.clear();

	}

	public LinkedHashMap getSurgeryTypeDtls(){

		LinkedHashMap<String,String> facilityMap = new LinkedHashMap<String,String>();
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet = null;
		
		try{
				
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");

			connection = getConnection();
			pstmt	   = connection.prepareStatement("SELECT OPER_ROOM_CODE, LONG_DESC FROM OT_OPER_ROOM_LANG_VW WHERE OPERATING_FACILITY_ID  = ? AND LANGUAGE_ID = ? order by LONG_DESC ") ;//MMS-QH-CRF-0199

			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,locale);
						
			resultSet  = pstmt.executeQuery();

			while(resultSet.next()){

				facilityMap.put(resultSet.getString("OPER_ROOM_CODE"),resultSet.getString("LONG_DESC"));//MMS-QH-CRF-0199
			}
			
			if(pstmt!=null) pstmt.close();
			if(resultSet!=null) resultSet.close();
			
		}
		catch (Exception e){
			e.printStackTrace() ;
		}
		finally{
			try{
				 closeResultSet(resultSet) ;
	             closeStatement(pstmt) ;
	            closeConnection(connection);
			}catch(Exception e){
				System.err.println("Err From getSurgeryTypeDtls===== "+e.getMessage());
			}
		}
		System.out.println("facilityMap===="+facilityMap);

		return facilityMap;
	}

	public HashMap getWidgetDtls(){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet = null;
		String widget_selection_id="";
		int z = 0;
		HashMap getWidgetDtls = new HashMap();		
		ArrayList codesList = new ArrayList();
		try{

			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");

			connection = getConnection();
			pstmt	   = connection.prepareStatement("	select distinct WIDGET_SELECTION_ID from ot_widget_selection where FACILITY_ID=?	");
			pstmt.setString(1,login_facility_id);
			resultSet  = pstmt.executeQuery();
			if(resultSet.next()){
				widget_selection_id=resultSet.getString("WIDGET_SELECTION_ID");
			}
			if(pstmt!=null)pstmt.close();
			if(resultSet!=null) resultSet.close();
			
			pstmt	   = connection.prepareStatement("SELECT WIDGET_SELECTION_ID,FACILITY_ID,STAFF_ASSIGN_YN,AUTO_REFRESH_YN,REFRESH_INTERVAL,REFRESH_INTERVAL_TIME,OT_ROOM_CODE1,OT_ROOM_CODE2,OT_ROOM_CODE3,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID FROM ot_widget_selection where  FACILITY_ID=? and WIDGET_SELECTION_ID=? ") ;

			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,widget_selection_id);
			
			
			resultSet  = pstmt.executeQuery();

			while(resultSet.next())
			{
				if(z == 0)
				{
				getWidgetDtls.put("widget_selection_id",resultSet.getString("WIDGET_SELECTION_ID"));
				getWidgetDtls.put("facility_id",resultSet.getString("FACILITY_ID"));
				getWidgetDtls.put("staff_assign_yn",resultSet.getString("STAFF_ASSIGN_YN"));
				getWidgetDtls.put("auto_refresh_yn",resultSet.getString("AUTO_REFRESH_YN"));
				getWidgetDtls.put("refresh_interval",resultSet.getString("REFRESH_INTERVAL"));
				getWidgetDtls.put("refresh_interval_time",resultSet.getString("REFRESH_INTERVAL_TIME"));
//					getWidgetDtls.put("ot_room_code1",resultSet.getString("OT_ROOM_CODE1"));
				getWidgetDtls.put("ot_room_code2",resultSet.getString("OT_ROOM_CODE2"));
				getWidgetDtls.put("ot_room_code3",resultSet.getString("OT_ROOM_CODE3"));
			}
				codesList.add(resultSet.getString("OT_ROOM_CODE1"));
				z++;
			}
			getWidgetDtls.put("CODESLIST", codesList);
			if(pstmt!=null) pstmt.close();
			if(resultSet!=null) resultSet.close();
		}
		catch (Exception e){
			System.err.println("Err From OTWidgetSelectionBean "+e.getMessage());
			e.printStackTrace() ;
		}
		finally{
			try{
				 closeResultSet(resultSet) ;
	             closeStatement(pstmt) ;
	             closeConnection(connection);
			}catch(Exception e){

				System.err.println("Err From OTWidgetSelectionBean1 "+e.getMessage());
			}
		}
		
		return getWidgetDtls;
	}  


}

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import eCommon.Common.CommonBean;
import eOT.Common.OTAdapter;
import java.io.Serializable;
import java.util.Properties;


public class OTStaffAssignBean extends OTAdapter implements Serializable {


	Properties	p = this.properties;
	String	locale	= "";

	String strStaffShortName="";
	String strFromTime="";
	String strToTime="";
	String strRoleDesc="";
	String strRoomCode="";
	String strRoomDesc="";
	
	
	public String getStrRoomCode() {
		return strRoomCode;
	}
	public void setStrRoomCode(String strRoomCode) {
		this.strRoomCode = strRoomCode;
	}
	public String getStrRoomDesc() {
		return strRoomDesc;
	}
	public void setStrRoomDesc(String strRoomDesc) {
		this.strRoomDesc = strRoomDesc;
	}
	public String getStrStaffShortName() {
		return strStaffShortName;
	}
	public void setStrStaffShortName(String strStaffShortName) {
		this.strStaffShortName = strStaffShortName;
	}
	public String getStrFromTime() {
		return strFromTime;
	}
	public void setStrFromTime(String strFromTime) {
		this.strFromTime = strFromTime;
	}
	public String getStrToTime() {
		return strToTime;
	}
	public void setStrToTime(String strToTime) {
		this.strToTime = strToTime;
	}
	public String getStrRoleDesc() {
		return strRoleDesc;
	}
	public void setStrRoleDesc(String strRoleDesc) {
		this.strRoleDesc = strRoleDesc;
	}

	
	
	public OTStaffAssignBean() {
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
	
	
	public int getAssignedStaffDtlsAllCount(String frameName, String chkedValues)
	{
		int rowCount = 0;
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        StringBuffer strSql = new StringBuffer();;
		//int index	= 1; //Common-ICN-0055
		try{
			p = getProperties();
			locale = (String) p.getProperty("LOCALE");

			connection = getConnection();

			strSql.append(" SELECT COUNT (*)	");
			strSql.append(" FROM am_practitioner a, ot_staff_assignment b, ot_roles c	");
			strSql.append(" WHERE a.practitioner_id = b.staff_id	");
			strSql.append(" AND b.role_id = c.role_id	");
			strSql.append(" AND b.operating_facility_id = ?	");
			strSql.append(" AND show_widget_yn = 'Y'	");
			if(frameName != null && frameName.equalsIgnoreCase("All"))
				strSql.append(" AND b.oper_room_code = 'ALL'	");
			else if(frameName != null && frameName.equalsIgnoreCase("Room"))
			{
				if(chkedValues != null && chkedValues.trim().length() > 0)
				strSql.append(" AND b.oper_room_code in ("+ chkedValues +")	");
				else
					strSql.append(" AND b.oper_room_code != 'ALL'	");
			}
			strSql.append(" AND b.assignment_date = TO_CHAR (SYSDATE, 'DD/MM/YYYY')	");
			pstmt = connection.prepareStatement(strSql.toString());
			pstmt.setString(1, login_facility_id);
			resultSet = pstmt.executeQuery();

			while(resultSet!=null && resultSet.next())
			{
				rowCount = resultSet.getInt(1);
			}
		}
		catch ( Exception e ) 
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
            catch(Exception es)
            {
            	es.printStackTrace();
            }
        }
		return rowCount;
	
	}
	
	public Map<String, List<OTStaffAssignBean>> getAssignedStaffDtls(String frameName, String chkedValues, String from, String to) {
		//Added Against Common-ICN-0031
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet resultSet = null;
		//Added Against Common-ICN-0031
		OTStaffAssignBean getAssignedStaffdtl = null;
		List<OTStaffAssignBean> beanList = null;
		List roomCodesList = null;
		Map<String, List<OTStaffAssignBean>> map = new HashMap<String, List<OTStaffAssignBean>>();
		StringBuffer strSql = new StringBuffer(); 
		
		try {

			p = getProperties();
			locale = (String) p.getProperty("LOCALE");
			beanList = new ArrayList<OTStaffAssignBean>();
			roomCodesList = new ArrayList();

			connection = getConnection();
			//047845 start
			strSql.append(" SELECT   ROWNUM rn, a.short_name, b.oper_room_code, b.from_time, 	");
			if(frameName != null && frameName.equalsIgnoreCase("Room"))
				strSql.append(" short_desc, 	");
			strSql.append(" b.to_time, c.role_desc 	");
			strSql.append(" FROM am_practitioner a, 	");
			strSql.append(" ot_staff_assignment b, 	");
			strSql.append(" ot_roles c 	");
			if(frameName != null && frameName.equalsIgnoreCase("Room"))
				strSql.append(" ,ot_oper_room_lang_vw d 	");
			strSql.append(" WHERE a.practitioner_id = b.staff_id	");
			strSql.append(" AND b.operating_facility_id = ? 	");
			if(frameName != null && frameName.equalsIgnoreCase("Room"))
			{
				strSql.append(" AND d.language_id = ? 	");
				strSql.append(" AND d.oper_room_code = b.oper_room_code 	");
			}
			strSql.append(" AND b.role_id = c.role_id	");
			strSql.append(" AND show_widget_yn = 'Y'	");
			if(frameName != null && frameName.equalsIgnoreCase("Room"))
			{
				if(chkedValues != null && chkedValues.trim().length() > 0)
					strSql.append(" AND b.oper_room_code in ("+ chkedValues +")	");
				else
					strSql.append(" AND b.oper_room_code != 'ALL'	");
			}
			else if(frameName != null && frameName.equalsIgnoreCase("All"))
				strSql.append(" AND b.oper_room_code = 'ALL'	");
			strSql.append(" AND b.assignment_date = TO_CHAR (SYSDATE, 'DD/MM/YYYY')	");
			strSql.append(" ORDER BY oper_room_code, upper(short_name)	");
			pstmt = connection.prepareStatement(strSql.toString());
			pstmt.setString(1, login_facility_id);
			if(frameName != null && frameName.equalsIgnoreCase("Room"))
				pstmt.setString(2, locale);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) 
			{
				getAssignedStaffdtl = new OTStaffAssignBean();
				getAssignedStaffdtl.setStrStaffShortName(resultSet.getString("SHORT_NAME"));
				getAssignedStaffdtl.setStrFromTime(resultSet.getString("FROM_TIME"));
				getAssignedStaffdtl.setStrToTime(resultSet.getString("TO_TIME"));
				getAssignedStaffdtl.setStrRoleDesc(resultSet.getString("ROLE_DESC"));
				getAssignedStaffdtl.setStrRoomCode(resultSet.getString("OPER_ROOM_CODE"));
				if(frameName != null && frameName.equalsIgnoreCase("Room"))
					getAssignedStaffdtl.setStrRoomDesc(resultSet.getString("SHORT_DESC"));
				else 
					getAssignedStaffdtl.setStrRoomDesc("All");
				beanList.add(getAssignedStaffdtl);
				if(!roomCodesList.contains(getAssignedStaffdtl.getStrRoomCode()))
					roomCodesList.add(getAssignedStaffdtl.getStrRoomCode());
				map.put("STAFFDETAILS", beanList);
				map.put("ROOMCODES", roomCodesList);
			}
		} catch (Exception e) {
			System.err.println("Err From OT getAssignedStaffDtls  " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (resultSet != null)
					resultSet.close();
				if (connection != null)
					closeConnection( connection ); //Common-ICN-0052
					//connection.close();

			} catch (Exception e) {

				System.err.println("Err From OT getAssignedStaffDtls1 " + e.getMessage());
			}
		}
		//047845 end
		System.out.println("==============map==============OTStaffassignBean====================="+map);
		return map;
	}  
	
	
}

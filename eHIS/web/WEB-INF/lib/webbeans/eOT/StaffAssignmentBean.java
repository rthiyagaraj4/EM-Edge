/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.eOT;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import webbeans.eCommon.ConnectionManager;
import webbeans.eOT.StaffAssignmentTimeBean;
import webbeans.eOT.StaffAssignmentAuditTrailBean;
import eCommon.Common.CommonAdapter;
import eOT.Common.OTRepository;

public class StaffAssignmentBean  extends CommonAdapter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 851973833523064837L;

	private String operatingFacilityId;
	private List<StaffAssignmentTimeBean> timeBeanList;
	private List<StaffAssignmentTimeBean> updateTimeBeanList;
	private List<Integer> staffAssignmentIdDeleteList;
	private List<String> operRoomCodeList; 

	public List<StaffAssignmentTimeBean> getUpdateTimeBeanList() {
		return updateTimeBeanList;
	}

	public void setUpdateTimeBeanList(
			List<StaffAssignmentTimeBean> updateTimeBeanList) {
		this.updateTimeBeanList = updateTimeBeanList;
	}

	public String getOperatingFacilityId() {
		return operatingFacilityId;
	}

	public void setOperatingFacilityId(String operatingFacilityId) {
		this.operatingFacilityId = operatingFacilityId;
	}

	public List<StaffAssignmentTimeBean> getTimeList() {
		return timeBeanList;
	}

	public void setTimeList(List<StaffAssignmentTimeBean> timeBeanList) {
		this.timeBeanList = timeBeanList;
	}


	public List<Integer> getStaffAssignmentIdDeleteList() {
		return staffAssignmentIdDeleteList;
	}

	public void setStaffAssignmentIdDeleteList(
			List<Integer> staffAssignmentIdDeleteList) {
		this.staffAssignmentIdDeleteList = staffAssignmentIdDeleteList;
	}
	
	public List<String> getOperRoomCodeList() {
		return operRoomCodeList;
	}

	public void setOperRoomCodeList(
			List<String> operRoomCodeList) {
		this.operRoomCodeList = operRoomCodeList;
	}
	
	public Map<String,String> getCodeValueMap(String sql, List<String> condnList)
	{
		Map<String,String> codeDescMap = new LinkedHashMap<String,String>();
		
		java.sql.Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//String FETCH_SQL = "SELECT SHORT_DESC  DESCRIPTION, OPER_ROOM_CODE CODE FROM OT_OPER_ROOM_LANG_VW WHERE OPERATING_FACILITY_ID = ? AND LANGUAGE_ID=?";
		
		try
		{
			conn = ConnectionManager.getConnection();
			int index = 1;
			pstmt = conn.prepareStatement(sql);
			for(String condn : condnList)
			{
				pstmt.setString(index++, condn);
			}
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				codeDescMap.put(rs.getString("CODE"), rs.getString("DESCRIPTION"));
			}
			
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			try
			{
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				ConnectionManager.returnConnection(conn);
			}
			catch(Exception e)
			{
				
			}
			
			
		}
		return codeDescMap;
				
	}
	
	public Map<String, List<StaffAssignmentTimeBean>> fetchStaffAssignmentDetails(
			String fromDate, String toDate, String operRoomCode,
			String facilityid, String locale, Properties p)
	{
		Map<String, List<StaffAssignmentTimeBean>> dateBeanMap = new HashMap<String, List<StaffAssignmentTimeBean>>();
		List<StaffAssignmentTimeBean> timeBeanList = new ArrayList<StaffAssignmentTimeBean>();
		StaffAssignmentTimeBean timeBean = null;
		String key = null;
		java.sql.Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try
		{
			conn = ConnectionManager.getConnection(p);
			int index = 1;
			pstmt = conn.prepareStatement(OTRepository.getOTKeyValue("OT_STAFF_ASSIGNMENT_SELECT"));
			
			pstmt.setString(index++, fromDate);
			pstmt.setString(index++, toDate);
			pstmt.setString(index++, locale);
			pstmt.setString(index++, locale);
			pstmt.setString(index++, facilityid);
			pstmt.setString(index++, operRoomCode);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				key = rs.getString("ASSIGNMENT_DATE") + "~" + rs.getString("OPER_ROOM_CODE");
				
				
				timeBean = new StaffAssignmentTimeBean();
				timeBean.setRoleId(rs.getString("ROLE_ID"));
				timeBean.setRoleDesc(rs.getString("ROLE_DESC"));
				timeBean.setStaffId(rs.getString("STAFF_ID"));
				timeBean.setStaffName(rs.getString("STAFF_NAME"));
				timeBean.setShowWidgetYN(rs.getString("SHOW_WIDGET_YN"));
				timeBean.setFromTime(rs.getString("FROM_TIME"));
				timeBean.setToTime(rs.getString("TO_TIME"));
				timeBean.setStaffAssginmentId(rs.getInt("STAFF_ASSIGNMENT_ID"));
				
				timeBeanList = dateBeanMap.get(key);
				
				if(timeBeanList == null)
				{
					timeBeanList = new ArrayList<StaffAssignmentTimeBean>();
				}
				timeBeanList.add(timeBean);
				
				dateBeanMap.put(key, timeBeanList);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in Bean ; " + e);
		}
		finally
		{
			try
			{
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				ConnectionManager.returnConnection(conn, p);
			}
			catch(Exception e)
			{
				
			}
			
			
		}
		return dateBeanMap;
				
	}

	public Map<Integer, List<StaffAssignmentAuditTrailBean>> fetchAuditTrailDetails(
			String fromDate, String toDate, String operRoomCode,
			String facilityid, String locale, Properties p)
	{
		Map<Integer, List<StaffAssignmentAuditTrailBean>> auditTrailMap = new HashMap<Integer, List<StaffAssignmentAuditTrailBean>>();
		Map<Integer, List<StaffAssignmentTimeBean>> staffDetailsMap = null; 
		StaffAssignmentAuditTrailBean auditTrailBean = null;
		List<StaffAssignmentAuditTrailBean> auditTrailList = null;
		int key = 0;
		java.sql.Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try
		{
			conn = ConnectionManager.getConnection(p);
			/**
			 * Fetch STAFF Details from STAFF_ASSIGNMENT table
			 */
			staffDetailsMap = fetchAuditTrailStaffDetails(fromDate, toDate, operRoomCode, facilityid, locale, conn);
			
			
			/**
			 * Fetch Staff details History from OT_STAFF_ASSIGNMENT_HIST table
			 */
			fetchAuditTrailStaffHistDetails(fromDate, toDate, operRoomCode, facilityid, locale, staffDetailsMap, conn);
			
			/**
			 * Populate Audit Trail Details
			 *  
			 */
			StaffAssignmentTimeBean timeBean = null;
			for(Integer staffAssignmentId :  staffDetailsMap.keySet())
			{
				List<StaffAssignmentTimeBean> timeBeanList = staffDetailsMap.get(staffAssignmentId);
				
				int i = 0;
				while(i < timeBeanList.size())
				{
					
					auditTrailBean = new StaffAssignmentAuditTrailBean();
					
					timeBean = timeBeanList.get(i++);
					
					auditTrailBean.setNewFromTime(timeBean.getFromTime());
					auditTrailBean.setNewToTime(timeBean.getToTime());
					auditTrailBean.setNewShowWidgetYN(timeBean.getShowWidgetYN());
					
					
					
					if(i < timeBeanList.size())
					{
						timeBean = timeBeanList.get(i);
						
						auditTrailBean.setAssignmentDate(timeBean.getAssignmentDate());
						auditTrailBean.setOperRoomCode(timeBean.getOperRoomCode());
						auditTrailBean.setStaffId(timeBean.getStaffId());
						auditTrailBean.setStaffName(timeBean.getStaffName());
						auditTrailBean.setRoleId(timeBean.getRoleId());
						auditTrailBean.setRoleDesc(timeBean.getRoleDesc());
						auditTrailBean.setFromTime(timeBean.getFromTime());
						auditTrailBean.setToTime(timeBean.getToTime());
						auditTrailBean.setShowWidgetYN(timeBean.getShowWidgetYN());
						auditTrailBean.setModifiedBy(timeBean.getModifiedBy());
						auditTrailBean.setModifiedDate(timeBean.getModifiedDate());
						
						auditTrailList = auditTrailMap.get(staffAssignmentId);
						
						if(auditTrailList == null)
						{
							auditTrailList = new ArrayList<StaffAssignmentAuditTrailBean>();
						}
						auditTrailList.add(auditTrailBean);
						auditTrailMap.put(staffAssignmentId, auditTrailList);
					}
					
					
					
				}
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in Bean ; " + e);
		}
		finally
		{
			try
			{
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				ConnectionManager.returnConnection(conn, p);
			}
			catch(Exception e)
			{
				
			}
			
			
		}
		return auditTrailMap;
				
	}
	private Map<Integer, List<StaffAssignmentTimeBean>> fetchAuditTrailStaffDetails(
			String fromDate, String toDate, String operRoomCode,
			String facilityid, String locale, Connection conn)
	{
		Map<Integer, List<StaffAssignmentTimeBean>> dateBeanMap = new HashMap<Integer, List<StaffAssignmentTimeBean>>();
		List<StaffAssignmentTimeBean> timeBeanList = new ArrayList<StaffAssignmentTimeBean>();
		StaffAssignmentTimeBean timeBean = null;
		int key = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try
		{
			int index = 1;
			pstmt = conn.prepareStatement(OTRepository.getOTKeyValue("OT_STAFF_ASSIGNMENT_WITH_HIST_SELECT"));
			
			pstmt.setString(index++, fromDate);
			pstmt.setString(index++, toDate);
			pstmt.setString(index++, locale);
			pstmt.setString(index++, locale);
			pstmt.setString(index++, facilityid);
			pstmt.setString(index++, operRoomCode);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				key = rs.getInt("STAFF_ASSIGNMENT_ID");
				
				timeBean = new StaffAssignmentTimeBean();
				timeBean.setAssignmentDate(rs.getString("ASSIGNMENT_DATE"));
				timeBean.setOperRoomCode(rs.getString("OPER_ROOM_CODE"));
				timeBean.setRoleId(rs.getString("ROLE_ID"));
				timeBean.setRoleDesc(rs.getString("ROLE_DESC"));
				timeBean.setStaffId(rs.getString("STAFF_ID"));
				timeBean.setStaffName(rs.getString("STAFF_NAME"));
				timeBean.setFromTime(rs.getString("FROM_TIME"));
				timeBean.setToTime(rs.getString("TO_TIME"));
				timeBean.setStaffAssginmentId(rs.getInt("STAFF_ASSIGNMENT_ID"));
				timeBean.setModifiedBy(rs.getString("MODIFIED_BY_ID"));
				timeBean.setModifiedDate(rs.getString("MODIFIED_DATE"));
				
				timeBeanList = dateBeanMap.get(key);
				
				if(timeBeanList == null)
				{
					timeBeanList = new ArrayList<StaffAssignmentTimeBean>();
				}
				timeBeanList.add(timeBean);
				
				dateBeanMap.put(key, timeBeanList);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in Bean ; " + e);
		}
		finally
		{
			try
			{
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
			}
			catch(Exception e)
			{
				
			}
			
			
		}
		return dateBeanMap;
				
	}
	
	private void fetchAuditTrailStaffHistDetails(
			String fromDate, String toDate, String operRoomCode,
			String facilityid, String locale, Map<Integer, List<StaffAssignmentTimeBean>> dateBeanMap,  Connection conn)
	{
		List<StaffAssignmentTimeBean> timeBeanList = new ArrayList<StaffAssignmentTimeBean>();
		StaffAssignmentTimeBean timeBean = null;
		int key = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try
		{
			int index = 1;
			pstmt = conn.prepareStatement(OTRepository.getOTKeyValue("OT_STAFF_ASSIGNMENT_HIST_SELECT"));
			
			pstmt.setString(index++, fromDate);
			pstmt.setString(index++, toDate);
			pstmt.setString(index++, locale);
			pstmt.setString(index++, locale);
			pstmt.setString(index++, facilityid);
			pstmt.setString(index++, operRoomCode);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				key = rs.getInt("STAFF_ASSIGNMENT_ID");
				
				timeBean = new StaffAssignmentTimeBean();
				timeBean.setAssignmentDate(rs.getString("ASSIGNMENT_DATE"));
				timeBean.setOperRoomCode(rs.getString("OPER_ROOM_CODE"));
				timeBean.setRoleId(rs.getString("ROLE_ID"));
				timeBean.setRoleDesc(rs.getString("ROLE_DESC"));
				timeBean.setStaffId(rs.getString("STAFF_ID"));
				timeBean.setStaffName(rs.getString("STAFF_NAME"));
				timeBean.setFromTime(rs.getString("FROM_TIME"));
				timeBean.setToTime(rs.getString("TO_TIME"));
				timeBean.setStaffAssginmentId(rs.getInt("STAFF_ASSIGNMENT_ID"));
				timeBean.setStaffAssginmentHistId(rs.getInt("STAFF_ASSIGNMENT_HIST_ID"));
				timeBean.setModifiedBy(rs.getString("MODIFIED_BY_ID"));
				timeBean.setModifiedDate(rs.getString("MODIFIED_DATE"));
				
				timeBeanList = dateBeanMap.get(key);
				
				if(timeBeanList == null)
				{
					timeBeanList = new ArrayList<StaffAssignmentTimeBean>();
					
					//Create a dummy deleted Record
					StaffAssignmentTimeBean deletedBean = new StaffAssignmentTimeBean(); 
					timeBeanList.add(deletedBean);
					
				}
				timeBeanList.add(timeBean);
				
				dateBeanMap.put(key, timeBeanList);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in Bean ; " + e);
		}
		finally
		{
			try
			{
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
			}
			catch(Exception e)
			{
				
			}
			
		}
				
	}
	
}

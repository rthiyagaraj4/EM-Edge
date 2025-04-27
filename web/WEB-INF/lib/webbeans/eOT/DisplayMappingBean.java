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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import webbeans.eCommon.ConnectionManager;
import webbeans.eOT.DisplayMappingDtlBean;
import eOT.Common.OTAdapter;
import eOT.Common.OTRepository;

public class DisplayMappingBean extends OTAdapter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String operatingFacilityId;
	private String autoRefreshYN;
	private String refreshInterval;
	private String refreshIntervalTime;
	List<DisplayMappingDtlBean> dtlbeanList = null;
	List<String> deleteList = null;
	
	

	public DisplayMappingBean() 
	{
		
	}
	
	public String getOperatingFacilityId() {
		return operatingFacilityId;
	}


	public void setOperatingFacilityId(String operatingFacilityId) {
		this.operatingFacilityId = operatingFacilityId;
	}

	public String getAutoRefreshYN() {
		return autoRefreshYN;
	}


	public void setAutoRefreshYN(String autoRefreshYN) {
		this.autoRefreshYN = autoRefreshYN;
	}


	public String getRefreshInterval() {
		return refreshInterval;
	}


	public void setRefreshInterval(String refreshInterval) {
		this.refreshInterval = refreshInterval;
	}


	public String getRefreshIntervalTime() {
		return refreshIntervalTime;
	}


	public void setRefreshIntervalTime(String refreshIntervalTime) {
		this.refreshIntervalTime = refreshIntervalTime;
	}


	public List<String> getDeleteList() {
		return deleteList;
	}

	public void setDeleteList(List<String> deleteList) {
		this.deleteList = deleteList;
	}
	

	public List<DisplayMappingDtlBean> getDtlbeanList() {
		return dtlbeanList;
	}

	public void setDtlbeanList(List<DisplayMappingDtlBean> dtlbeanList) {
		this.dtlbeanList = dtlbeanList;
	}

	public DisplayMappingBean fetchDisplayMappingDetails(String facilityid,
			String locale, Properties p)
	{
		DisplayMappingBean displayMappingBean = null;
		DisplayMappingDtlBean displayMappingDtlBean = null;
		Map<String, DisplayMappingDtlBean> displayMappingMap = new LinkedHashMap<String, DisplayMappingDtlBean>(); 
		java.sql.Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String key = null;
		try
		{
			conn = ConnectionManager.getConnection(p);
			pstmt = conn.prepareStatement(OTRepository.getOTKeyValue("OT_DISPLAY_MAPPING_SELECT"));
			pstmt.setString(1, locale);
			pstmt.setString(2, facilityid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
					if(displayMappingBean == null)
					{
						displayMappingBean = new DisplayMappingBean();
						displayMappingBean.setAutoRefreshYN(rs.getString("AUTO_REFRESH_YN"));
						displayMappingBean.setRefreshInterval(rs.getString("REFRESH_INTERVAL"));
						displayMappingBean.setRefreshIntervalTime(rs.getInt("REFRESH_INTERVAL_TIME") + "");
					}
					
					key = rs.getString("DISPLAY_STATUS") + "~" + rs.getString("COLOR_CODE");
					displayMappingDtlBean = displayMappingMap.get(key);
					
					if(displayMappingDtlBean == null)
					{
						displayMappingDtlBean = new DisplayMappingDtlBean();
						displayMappingDtlBean.setDisplayStatus(rs.getString("DISPLAY_STATUS") );
						displayMappingDtlBean.setColorCode(rs.getString("COLOR_CODE"));
					}
					displayMappingDtlBean.addToStatusCodeList(rs.getString("STATUS_CODE"));
					displayMappingDtlBean.addToStatusDescList(rs.getString("STATUS_DESC"));
					displayMappingMap.put(key, displayMappingDtlBean);
			}
			if(displayMappingBean != null)
			{
				List<DisplayMappingDtlBean> dtlBeanList = new ArrayList<DisplayMappingDtlBean>();
				
				for(String mapKey : displayMappingMap.keySet())
				{
					dtlBeanList.add(displayMappingMap.get(mapKey));
				}
				displayMappingBean.setDtlbeanList(dtlBeanList);
			}
			else
			{
				displayMappingBean = new DisplayMappingBean();
				
				pstmt = conn.prepareStatement("SELECT REFRESH_INTERVAL, REFRESH_INTERVAL_TIME FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID = ?");
				
				pstmt.setString(1, facilityid);
				
				rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					displayMappingBean.setRefreshInterval(rs.getString("REFRESH_INTERVAL"));
					displayMappingBean.setRefreshIntervalTime(rs.getString("REFRESH_INTERVAL_TIME"));
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
		return displayMappingBean;
				
	}

	public Map<String, String> fetchOTSlateStatus(String facilityid,
			String locale, Properties p)
	{
		Map<String,String> otStatusMap = new LinkedHashMap<String,String>();
		java.sql.Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			conn = ConnectionManager.getConnection(p);
			pstmt = conn.prepareStatement(OTRepository.getOTKeyValue("OT_SLATE_STATUS_SELECT"));
			pstmt.setString(1, locale);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				otStatusMap.put(rs.getString("STATUS_CODE"), rs.getString("STATUS_DESC"));
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
		return otStatusMap;
				
	}

	public void setDeleteList(String deleteId)
	{
		String [] deleteIdArray = deleteId.split("~");
		this.deleteList = Arrays.asList(deleteIdArray);
	}
}

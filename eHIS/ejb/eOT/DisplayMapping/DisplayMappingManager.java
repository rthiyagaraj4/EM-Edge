/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.DisplayMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import webbeans.eCommon.ConnectionManager;
import webbeans.eOT.DisplayMappingBean;
import webbeans.eOT.DisplayMappingDtlBean;
import eOT.Common.OTRepository;

/**
*
* @ejb.bean
*	name="DisplayMapping"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DisplayMapping"
*	local-jndi-name="DisplayMapping"
*	impl-class-name="eOT.DisplayMapping.DisplayMappingManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eOT.DisplayMapping.DisplayMappingLocal"
*	remote-class="eOT.DisplayMapping.DisplayMappingRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOT.DisplayMapping.DisplayMappingLocalHome"
*	remote-class="eOT.DisplayMapping.DisplayMappingHome"
*	generate= "local,remote"
*
*
*/
public class DisplayMappingManager  implements  SessionBean {


	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {}

		

	public String save(Map tabData, Properties prop) 
	{
		Connection connection = null;
		String err_text = "RECORD_INSERTED";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			
			connection = ConnectionManager.getConnection(prop);
			
			//Check in Record exists
			DisplayMappingBean displayBean = (DisplayMappingBean)tabData.get("DISPLAY_MAPPING_BEAN");
			
			
				
			deleteDisplayMapping(displayBean, connection);
			
			
			if("RECORD_INSERTED".equals(err_text))
			{
				err_text = insertDisplayMapping(tabData, connection);
			}
			
			
			if("RECORD_INSERTED".equals(err_text))
			{
				err_text = updateFacilityParam(displayBean, connection);
			}
			
			if("RECORD_INSERTED".equals(err_text))
			{
				connection.commit();
			}
			else
			{
				connection.rollback();
				err_text = "ERROR";
			}
		}
		catch(Exception ee)
		{ 
			System.err.println("Exception in DisplayMappingManager insert :" + ee);
		}
	   finally
	   {
		  try
		  {
			  
			if(pstmt != null)
				pstmt.close();
			if(rs != null)
				rs.close();		
			if(connection!=null)
				ConnectionManager.returnConnection(connection,prop);

		  }
		  catch(Exception e)  {}
	    }
		return err_text;
	}
	private String insertDisplayMapping(Map tabData, Connection connection) 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String err_text = "RECORD_INSERTED";
		DisplayMappingBean displayBean = (DisplayMappingBean)tabData.get("DISPLAY_MAPPING_BEAN");
		int [] noOfRows = null; //Added Against AAKH-ICN-0008
		//int DisplayMappingID = 0;	//Commented Against AAKH-ICN-0008
		/*if(displayBean.getDtlbeanList() == null || displayBean.getDtlbeanList().size() == 0)
		{
			return "NO_DATA";
		}*/
			
		try
		{
			String displayMappingInsertSQL = OTRepository.getOTKeyValue("OT_DISPLAY_MAPPING_INSERT");
			
			
			pstmt = connection.prepareStatement(displayMappingInsertSQL) ;
			for(DisplayMappingDtlBean detailBean : displayBean.getDtlbeanList())
			{
				for(String code : detailBean.getStatusCodeList())
				{
					pstmt.setString(1,(String) tabData.get("facility_id"));
					pstmt.setString(2, detailBean.getDisplayStatus());
					pstmt.setString(3, detailBean.getColorCode());
					pstmt.setString(4,code);
					pstmt.setString(5,(String) tabData.get("login_user")); 
					pstmt.setString(6,(String) tabData.get("login_at_ws_no"));
					pstmt.setString(7,(String) tabData.get("facility_id"));
					pstmt.setString(8,(String) tabData.get("login_user")); 
					pstmt.setString(9,(String) tabData.get("login_at_ws_no"));
					pstmt.setString(10,(String) tabData.get("facility_id"));
					
					pstmt.addBatch();
				}
  		    }
			
			noOfRows = pstmt.executeBatch();
		}
		catch(Exception ee)
		{
			System.err.println("Exception in DisplayMappingManager insert :" + ee);
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
		return err_text;
	 }
	
	private String updateFacilityParam(DisplayMappingBean displayBean, Connection connection) 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String err_text = "";
		int rowsUpdated = 0; //Added Against AAKH-ICN-0008
		try
		{
			String displayMappingUpdateSQL = OTRepository.getOTKeyValue("OT_DISPLAY_MAPPING_PARAM_UPDATE");
			
			
			pstmt = connection.prepareStatement(displayMappingUpdateSQL) ;
			
			pstmt.setString(1,displayBean.getAutoRefreshYN());
			pstmt.setString(2,displayBean.getRefreshInterval());
			pstmt.setString(3,displayBean.getRefreshIntervalTime());
			pstmt.setString(4,displayBean.getOperatingFacilityId());
			
			rowsUpdated = pstmt.executeUpdate();

			err_text = "RECORD_INSERTED";
			
		}
		catch(Exception ee)
		{
			System.err.println("Exception in DisplayMappingManager update :" + ee);
			
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
		return err_text;
	 }

	
	private String deleteDisplayMapping(DisplayMappingBean displayBean, Connection connection) 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String err_text = "";
		int [] rowsDeleted = null; //Added Against AAKH-ICN-0008
		try
		{
			String displayMappingDeleteSQL = OTRepository.getOTKeyValue("OT_DISPLAY_MAPPING_DELETE");
			
			if(displayBean.getDeleteList() != null && displayBean.getDeleteList().size() > 0)
			{
				pstmt = connection.prepareStatement(displayMappingDeleteSQL) ;
			
				for(String displayStatus : displayBean.getDeleteList())
				{
					pstmt.setString(1, displayBean.getOperatingFacilityId());
					pstmt.setString(2, displayStatus);
					pstmt.addBatch();
				}
				rowsDeleted = pstmt.executeBatch();
			}
			
			err_text = "RECORD_INSERTED";
		}
		catch(Exception ee)
		{
			System.err.println("Exception in DisplayMappingManager insert :" + ee);
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
		return err_text;
	 }
	
	
}


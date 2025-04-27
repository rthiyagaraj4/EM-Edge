/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.StaffAssignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import webbeans.eCommon.ConnectionManager;
import webbeans.eOT.StaffAssignmentBean;
import webbeans.eOT.StaffAssignmentTimeBean;
import eOT.Common.OTRepository;

/**
*
* @ejb.bean
*	name="StaffAssignment"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="StaffAssignment"
*	local-jndi-name="StaffAssignment"
*	impl-class-name="eOT.StaffAssignment.StaffAssignmentManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eOT.StaffAssignment.StaffAssignmentLocal"
*	remote-class="eOT.StaffAssignment.StaffAssignmentRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOT.StaffAssignment.StaffAssignmentLocalHome"
*	remote-class="eOT.StaffAssignment.StaffAssignmentHome"
*	generate= "local,remote"
*
*
*/
public class StaffAssignmentManager  implements  SessionBean {


	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {}

		
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public String insert(Map tabData, Properties prop) 
	{
		Connection connection = null;
		String err_text = "RECORD_INSERTED";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			
			connection = ConnectionManager.getConnection(prop);
			
			//Check in Record exists
			StaffAssignmentBean staffBean = (StaffAssignmentBean)tabData.get("STAFF_ASSIGNMENT_BEAN");
			
			if(staffBean.getTimeList() != null && staffBean.getTimeList().size() > 0)
			{
				StaffAssignmentTimeBean timeBean = staffBean.getTimeList().get(0);
				
				
				pstmt = connection.prepareStatement(getOperRoomCodeWhereClause(staffBean.getOperRoomCodeList()));
				
				pstmt.setString(1, timeBean.getAssignmentDate());
				rs =  pstmt.executeQuery();
				rs.next(); 
				int recs = rs.getInt(1);
				if(recs > 0)
				{
					err_text = "RECORD_ALREADY_EXISTS";
					return err_text;
				}
				
			}
			
			err_text = insertStaffAssignment(tabData, connection);
			
			
			
			
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
			System.err.println("Exception in StaffAssignmentManager insert :" + ee);
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
	public String insertStaffAssignment(Map tabData, Connection connection) 
	{
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		String err_text = "RECORD_INSERTED";
		StaffAssignmentBean staffBean = (StaffAssignmentBean)tabData.get("STAFF_ASSIGNMENT_BEAN");
		int [] noOfRows = null; //Added Against AAKH-ICN-0008
		int staffAssignmentID = 0;
		if(staffBean.getTimeList() == null || staffBean.getTimeList().size() == 0)
		{
			return "NO_DATA";
		}
			
		try
		{
			String staffAssignmentInsertSQL = OTRepository.getOTKeyValue("OT_STAFF_ASSIGNMENT_INSERT");
			String staffAssignmentIDSeqQL = OTRepository.getOTKeyValue("OT_STAFF_ASSIGNMENT_SEQ_SELECT");
			
			
			pstmt1 = connection.prepareStatement(staffAssignmentInsertSQL) ;
			for(StaffAssignmentTimeBean timeBean : staffBean.getTimeList())
			{
				pstmt = connection.prepareStatement(staffAssignmentIDSeqQL) ;
				
				rs = pstmt.executeQuery();
				
				if(rs.next() )
				{
					staffAssignmentID = rs.getInt(1);
				}
				if(pstmt !=null) pstmt.close(); //Common-ICN-0053
				if(rs !=null) rs.close(); //Common-ICN-0054
				if(staffAssignmentID > 0)
				{
					
					pstmt1.setString(1,(String) tabData.get("facility_id"));
					pstmt1.setInt(2, staffAssignmentID);
					pstmt1.setString(3,timeBean.getAssignmentDate());
					pstmt1.setString(4,timeBean.getOperRoomCode());
					pstmt1.setString(5,timeBean.getStaffId());
					pstmt1.setString(6,timeBean.getRoleId());
					pstmt1.setString(7,timeBean.getShowWidgetYN()); 
					pstmt1.setString(8,timeBean.getFromTime());
					pstmt1.setString(9,timeBean.getToTime());
					pstmt1.setString(10,(String) tabData.get("login_user")); 
					pstmt1.setString(11,(String) tabData.get("login_at_ws_no"));
					pstmt1.setString(12,(String) tabData.get("facility_id"));
					pstmt1.setString(13,(String) tabData.get("login_user")); 
					pstmt1.setString(14,(String) tabData.get("login_at_ws_no"));
					pstmt1.setString(15,(String) tabData.get("facility_id"));
					
					pstmt1.addBatch();
					//pstmt.execute();
					
				}
				else
				{
					err_text = "NO_SEQ";
				}
			 }
			if("RECORD_INSERTED".equals(err_text))
			{
				noOfRows = pstmt1.executeBatch();
			}
			else
			{
				err_text = "ERROR";
			}
			
			
		}
		catch(Exception ee)
		{
			System.err.println("Exception in StaffAssignmentManager insert :" + ee);
		}
	   finally
	   {
		  try
		  {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(pstmt1 != null)	//Added Against AAKH-ICN-0008
				pstmt1.close();
		  }
		  catch(Exception e)
		  {
			  
		  }
	    }
		return err_text;
	 }
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public String update(Map tabData, Properties prop) 
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String err_text = "";
		int [] noOfRows = null; //Added Against AAKH-ICN-0008
		try
		{
			String staffAssignmentUpdateSQL = OTRepository.getOTKeyValue("OT_STAFF_ASSIGNMENT_UPDATE");
			StaffAssignmentBean staffBean = (StaffAssignmentBean)tabData.get("STAFF_ASSIGNMENT_BEAN");
			
			connection = ConnectionManager.getConnection(prop);
			//call insert for insertList
			if(staffBean != null && staffBean.getTimeList().size() > 0)
			{
				insertStaffAssignment(tabData, connection);
			}
			
			
			err_text = moveToStaffAssignmentHistory(getStaffIdListModified(staffBean), connection);
			if(!"RECORD_INSERTED".equals(err_text))
			{
				return err_text;
			}
			
			if(staffBean.getStaffAssignmentIdDeleteList() != null && staffBean.getStaffAssignmentIdDeleteList().size() > 0)
			{
				err_text = delete(staffBean.getStaffAssignmentIdDeleteList(), connection);
				
			
				if(!"RECORD_INSERTED".equals(err_text))
				{
					return err_text;
				}
			}
			
			pstmt = connection.prepareStatement(staffAssignmentUpdateSQL) ;
			
			
			for(StaffAssignmentTimeBean timeBean : staffBean.getUpdateTimeBeanList())
			{
				pstmt.setString(1,timeBean.getStaffId());
				pstmt.setString(2, timeBean.getRoleId());
				pstmt.setString(3,timeBean.getShowWidgetYN());
				pstmt.setString(4,timeBean.getFromTime());
				pstmt.setString(5,timeBean.getToTime());
				pstmt.setString(6,(String) tabData.get("login_user"));
				pstmt.setString(7,(String) tabData.get("login_at_ws_no")); 
				pstmt.setString(8,(String) tabData.get("facility_id")); 
				pstmt.setString(9,(String) tabData.get("facility_id"));
				pstmt.setString(10, timeBean.getAssignmentDate());
				pstmt.setString(11,timeBean.getOperRoomCode()); 
				pstmt.setInt(12,timeBean.getStaffAssginmentId());
				
				pstmt.addBatch();
			}
			
			
			noOfRows = pstmt.executeBatch();
			connection.commit();
			err_text = "RECORD_INSERTED";
			
		}
		catch(Exception ee)
		{
			System.err.println("Exception in StaffAssignmentManager update :" + ee);
			
		}
	   finally
	   {
		  try
		  {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(connection!=null)
				ConnectionManager.returnConnection(connection,prop);

		  }
		  catch(Exception e)
		  {
			  
		  }
	    }
		return err_text;
	 }

	private String moveToStaffAssignmentHistory(List<Integer> staffIdList, Connection connection) 
	{
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		String err_text = "";
		
		int [] resultArray = null; //Added Against AAKH-ICN-0008
		int staffAssignmentHistID = 0;
		try
		{
			String staffAssignmentInsertSQL = OTRepository.getOTKeyValue("OT_STAFF_ASSIGNMENT_HIST_INSERT");
			String staffAssignmentIDSeqQL = OTRepository.getOTKeyValue("OT_STAFF_ASSIGNMENT_HIST_SEQ_SELECT");
			pstmt = connection.prepareStatement(staffAssignmentInsertSQL) ;
			
			for(Integer staffId : staffIdList)
			{
				pstmt1 = connection.prepareStatement(staffAssignmentIDSeqQL) ;
				
				rs = pstmt1.executeQuery();
				
				if(rs.next() )
				{
					staffAssignmentHistID = rs.getInt(1);
				}
				if(pstmt1 !=null) pstmt1.close(); //Common-ICN-0053
				if(rs !=null) rs.close(); //Common-ICN-0054
				if(staffAssignmentHistID < 0)
				{
					return err_text;
					
				}
				pstmt.setInt(1, staffAssignmentHistID);
				pstmt.setInt(2,staffId);
				
				pstmt.addBatch();
			}
			resultArray = pstmt.executeBatch();
			err_text = "RECORD_INSERTED";			
		 }
		catch(Exception ee)
		{
			System.err.println("Exception in StaffAssignmentManager insert :" + ee);
		}
	   finally
	   {
		  try
		  {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(pstmt1 != null)
				pstmt1.close();
				
		  }
		  catch(Exception e)
		  {
			  
		  }
	    }
		return err_text;
	 }
	
	private String delete(List<Integer> staffIdList, Connection connection) 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String err_text = "";
		int [] resultArray = null; //Added Against AAKH-ICN-0008
		try
		{
			String staffAssignmentDeleteSQL = OTRepository.getOTKeyValue("OT_STAFF_ASSIGNMENT_DELETE");
			
			pstmt = connection.prepareStatement(staffAssignmentDeleteSQL) ;
			
			for(Integer staffId : staffIdList)
			{
				pstmt.setInt(1, staffId);
			
				pstmt.addBatch();
			}	
			resultArray = pstmt.executeBatch();
			err_text = "RECORD_INSERTED";
		}
		catch(Exception ee)
		{
			System.err.println("Exception in StaffAssignmentManager insert :" + ee);
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
	
	 private List<Integer> getStaffIdListModified(StaffAssignmentBean staffBean)
	 {
		 List<Integer> staffIdList = new ArrayList<Integer>();
		 
		 
		 for(StaffAssignmentTimeBean timeBean : staffBean.getUpdateTimeBeanList() )
		 {
			 staffIdList.add(timeBean.getStaffAssginmentId());
		 }
		 
		 if(staffBean.getStaffAssignmentIdDeleteList() != null && staffBean.getStaffAssignmentIdDeleteList().size() > 0)
		 {
			 staffIdList.addAll(staffBean.getStaffAssignmentIdDeleteList());
		 }
		 
		 return staffIdList;
	 }
	 
	 private String getOperRoomCodeWhereClause(List<String> operRoomCode)
	 {
		 StringBuffer operRoomBuffer = new StringBuffer("SELECT COUNT(*) FROM OT_STAFF_ASSIGNMENT WHERE ASSIGNMENT_DATE = ? AND OPER_ROOM_CODE IN (");
		 
		 for(int i = 0; i< operRoomCode.size(); i++)
		 {
			 operRoomBuffer.append("'" + operRoomCode.get(i) + "'");
			 
			 if((i + 1) < operRoomCode.size())
			 {
				 operRoomBuffer.append(" , "); 
			 }
		 }
		 operRoomBuffer.append(" ) "); 
		 return operRoomBuffer.toString();
	 }
}


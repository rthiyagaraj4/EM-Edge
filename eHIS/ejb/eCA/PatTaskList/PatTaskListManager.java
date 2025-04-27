/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA.PatTaskList;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;

/**
*
* @ejb.bean
*	name="PatTaskList"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PatTaskList"
*	local-jndi-name="PatTaskList"
*	impl-class-name="eCA.PatTaskList.PatTaskListManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.PatTaskList.PatTaskListLocal"
*	remote-class="eCA.PatTaskList.PatTaskListRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.PatTaskList.PatTaskListLocalHome"
*	remote-class="eCA.PatTaskList.PatTaskListHome"
*	generate= "local,remote"
*
*
*/

public class PatTaskListManager  implements SessionBean
{
	//SessionContext ctx;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext(SessionContext sessioncontext) 
	{
			sessioncontext = sessioncontext;
	}

		/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public  ArrayList insertTaskList(ArrayList arrayRecords) 
	{
		
		PreparedStatement ps=null;
		Connection con = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		Properties p = (Properties)arrayRecords.get(0);
		String facilityId  = checkForNull((String)arrayRecords.get(1));
		String addedById   = checkForNull(p.getProperty( "login_user" ));
		String addedAtWSNo = checkForNull(p.getProperty("client_ip_address"));
		String patientId=checkForNull((String)arrayRecords.get(2));
		String encounterId=checkForNull((String)arrayRecords.get(3));
		String taskType=checkForNull((String)arrayRecords.get(4));
		String taskCode=checkForNull((String)arrayRecords.get(5));
		String taskDesc=checkForNull((String)arrayRecords.get(6));
		String dateTime=checkForNull((String)arrayRecords.get(7));
		String practitonerId=checkForNull((String)arrayRecords.get(8));
		String remarks=checkForNull((String)arrayRecords.get(9));
		String priority=checkForNull((String)arrayRecords.get(10));
//		String locale=checkForNull((String)arrayRecords.get(11));
		int count=0;
		sql.append(" Insert into ca_pat_task_list  (PATIENT_ID, TASK_CODE, TASK_SRL_NO, TASK_TYPE, STATUS, STATUS_DATE, PERFORMED_BY_ID, PERFORMED_BY_ROLE_TYPE, PERFORMED_DATE, CONTR_SYS_ID, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, MD_CARE_PLAN_ID, CARE_PLAN_ID, FACILITY_ID, ENCOUNTER_ID, PRIORITY, TASK_DESC,SCHEDULE_DATETIME) values (?,?,CA_PAT_TASK_SEQ.NEXTVAL,?,'P',to_date(?,'dd/mm/yyyy hh24:mi'),?,'P',to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?,null,null,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'))");
		try
		{
			con = ConnectionManager.getConnection(p);
			ps  = con.prepareStatement(sql.toString());
			ps.setString(++count,patientId);
			ps.setString(++count,taskCode);
			ps.setString(++count,taskType);
			ps.setString(++count,dateTime);
			ps.setString(++count,practitonerId);
			ps.setString(++count,dateTime);
			ps.setString(++count,"CA");
			ps.setString(++count,remarks);
			ps.setString(++count,addedById);
			ps.setString(++count,addedAtWSNo);
			ps.setString(++count,facilityId);
			ps.setString(++count,addedById);
			ps.setString(++count,addedAtWSNo);
			ps.setString(++count,facilityId);
			ps.setString(++count,facilityId);
			ps.setString(++count,encounterId);
			ps.setString(++count,priority);
			ps.setString(++count,taskDesc);
			ps.setString(++count,dateTime);
			int inserted = ps.executeUpdate();
			arrayRecords.clear();
			if(ps != null) ps.close();
			ps = 	con.prepareStatement("select to_char(sysdate + 1,'dd/mm/yyyy hh24:mi') from dual ");
			rs = ps.executeQuery();
			while(rs.next())
			{
				 arrayRecords.add(checkForNull(rs.getString(1)));
			}
			if(rs!=null)rs.close();
			if(ps != null)ps.close();

			if(inserted == 1)
			{
				 arrayRecords.add(new Boolean(true));
			}
			else
			{
				 arrayRecords.add(new Boolean(false));
			}

			con.commit();

		}
		catch(Exception ee)
		{
			try
			{
				con.rollback();
			}
			catch(Exception eee){
			eee.printStackTrace() ;
			}
		}
		finally
		{
			try
			{
				if(con != null)
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e)
			{

			}
			
		}
		return arrayRecords;
	}
	private String checkForNull(String IntermediateString)	
	{
		if(IntermediateString == null ||IntermediateString.equals(""))
		IntermediateString="";

		return IntermediateString;
	}
}

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used to add the rooms for the nursing unit.
@author - 
@version - V3
*/
package eIP.IPNursUnitRoom;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.HashMap ;
import java.sql.* ;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="IPNursUnitRoom"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPNursUnitRoom"
*	local-jndi-name="IPNursUnitRoom"
*	impl-class-name="eIP.IPNursUnitRoom.IPNursUnitRoomManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPNursUnitRoom.IPNursUnitRoomManagerLocal"
*	remote-class="eIP.IPNursUnitRoom.IPNursUnitRoomManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPNursUnitRoom.IPNursUnitRoomManagerLocalHome"
*	remote-class="eIP.IPNursUnitRoom.IPNursUnitRoomManagerHome"
*	generate= "local,remote"
*
*
*/
public class IPNursUnitRoomManager implements SessionBean 
{
	Connection					con ;
	PreparedStatement			pstmt ;
	Statement			stmt ;
	ResultSet	rset = null;
	SessionContext ctx;
	String room_num = "";
	String valuesToDelete = "";

	public void ejbCreate(){}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx=context;}
	
	/**
	This method is used to add or modify the rooms for the nursing unit
	@author - 
	@version - V3
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/

public java.util.HashMap NursUnitAddModify(java.util.Properties p,java.util.HashMap tabdata )	
{
		String locale = p.getProperty("LOCALE");
		java.util.HashMap results		= new java.util.HashMap() ;
        String added_by_id				= (String)tabdata.get("modified_by_id");
        String client_ip_address		= (String)tabdata.get("modified_at_ws_no");
        String nursing_unit_code		= (String)tabdata.get("nursing_unit_code");
		String facility_id				= (String)tabdata.get("facilityId");
        Integer totCount				= (Integer)tabdata.get("totCount");
		String Update_yn				= (String)tabdata.get("Update_yn");
        String search_by				= (String)tabdata.get("search_by");
        String search_txt				= (String)tabdata.get("search_txt");
		int totalCount					= 0;
		totalCount					= totCount.intValue();
        boolean result					= true;
		StringBuffer sqlQuery			= new StringBuffer();
		StringBuffer messageBuffer		= new StringBuffer();
		int n_Records					= 0;
 
	try
	{
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
	
		if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
		sqlQuery.append(" Select ROOM_NO, ROOM_SHORT_DESC from ");
		sqlQuery.append(" IP_NURSING_UNIT_ROOM_VW ");
		sqlQuery.append(" WHERE FACILITY_ID='"+facility_id+"' ");
		sqlQuery.append(" AND NURSING_UNIT_CODE='"+nursing_unit_code+"' ");

		if(search_by.equals("ID"))
			sqlQuery.append(" and upper(ROOM_NO) like upper('"+search_txt+"%') ");
		else if(search_by.equals("DESC"))
			sqlQuery.append("  and upper(ROOM_SHORT_DESC) like upper('"+search_txt+"%') ");
		stmt=con.createStatement();
		rset = stmt.executeQuery(sqlQuery.toString());


		if(rset != null )
		{
			boolean first_time = true;
			while(rset.next())
			{
				room_num	= rset.getString("ROOM_NO");

				if(first_time)
				  valuesToDelete = "'"+room_num+"'" ;
				else
					valuesToDelete = valuesToDelete + ",'" +room_num +"'";

				first_time = false;
			}
		}

		if(rset != null) rset.close();
		if(stmt != null) stmt.close();

		if(valuesToDelete.equals(""))
		{
			valuesToDelete = "''";
		}

		if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
		sqlQuery.append(" delete IP_NURSING_UNIT_ROOM where facility_id=? and nursing_unit_code=? and nvl(no_of_beds,0) = 0 and ROOM_NO in ("+valuesToDelete+")");

		try
		{
			if(pstmt != null) pstmt.close();
			pstmt	=con.prepareStatement(sqlQuery.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,nursing_unit_code);
			n_Records	=	pstmt.executeUpdate();

			if(n_Records > 0) 
				result=true;
/*
			else 
				result=false;
*/				
		}catch(Exception ee)
		{
			result=false;
			messageBuffer.append("Error in delete IP_NURSING_UNIT_ROOM "+ee.getMessage());
			ee.printStackTrace();
		}




	for(int i=0;i<totalCount;i++)
	{
		String roomNum				= checkForNull((String)tabdata.get("chk"+i));
		String LevelIndicator		= checkForNull((String)tabdata.get("level"+i));
		String no_of_beds		= checkForNull((String)tabdata.get("no_of_beds"+i));

		if(!roomNum.equals("") && no_of_beds.equals("0"))
		{
			if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
			sqlQuery.append("Insert into IP_NURSING_UNIT_ROOM ");					sqlQuery.append("(FACILITY_ID, ");
			sqlQuery.append(" ROOM_NO, ");
			sqlQuery.append(" NURSING_UNIT_CODE, ");
			sqlQuery.append(" NO_OF_BEDS, ");
			sqlQuery.append(" EFF_STATUS, ");
			sqlQuery.append(" ADDED_BY_ID, ");
			sqlQuery.append(" ADDED_DATE, ");
			sqlQuery.append(" ADDED_AT_WS_NO, ");
			sqlQuery.append(" ADDED_FACILITY_ID, ");
			sqlQuery.append(" MODIFIED_BY_ID, ");
			sqlQuery.append(" MODIFIED_DATE, ");
			sqlQuery.append(" MODIFIED_AT_WS_NO, ");
			sqlQuery.append(" MODIFIED_FACILITY_ID, ");
			sqlQuery.append(" LEVEL_OF_CARE_CODE )");
			sqlQuery.append(" values ( ");
			sqlQuery.append(" ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?,? ) ");

			try
			{
				pstmt=con.prepareStatement(sqlQuery.toString());
				pstmt.setString(1,facility_id);
				pstmt.setString(2,roomNum);
				pstmt.setString(3,nursing_unit_code);
				pstmt.setInt(4,0);
				pstmt.setString(5,"E" );
				pstmt.setString (6, added_by_id);
				pstmt.setString(7, client_ip_address) ;
				pstmt.setString(8, facility_id  ) ;
				pstmt.setString(9, added_by_id ) ;
				pstmt.setString(10, client_ip_address) ;
				pstmt.setString(11, facility_id  ) ;
				pstmt.setString(12, LevelIndicator ) ;

				int res=pstmt.executeUpdate();

				if(res>0) 
					result=true;
				else 
					result=false;

			}catch(Exception ee)
			{
				result=false;
				messageBuffer.append("Error in insert IP_NURSING_UNIT_ROOM "+ee.getMessage());
				ee.printStackTrace();
			}
			finally
			{
				if(pstmt!=null) pstmt.close();
				clearValues(sqlQuery);
			}
		}


		if(Update_yn.equals("Y"))
		{
			if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
			sqlQuery.append("update IP_NURSING_UNIT_ROOM set LEVEL_OF_CARE_CODE = ?  where facility_id=? and nursing_unit_code=? and ROOM_NO=? ");
			try
			{
				pstmt	=con.prepareStatement(sqlQuery.toString());
				pstmt.setString(1,LevelIndicator);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,nursing_unit_code);
				pstmt.setString(4,roomNum);
				n_Records	=	pstmt.executeUpdate();
			}
			catch(Exception ee)
			{
				messageBuffer.append("Error in update IP_NURSING_UNIT_ROOM with eff_status = E "+ee.getMessage());
				ee.printStackTrace();
			}
			finally
			{
				if(pstmt!=null) pstmt.close();
				clearValues(sqlQuery);
			}
		}
	}
	tabdata.clear();
/*******************************************************/
/*******************************************************/

/*



			sqlQuery.append("update IP_NURSING_UNIT_ROOM set eff_status ='D'  where facility_id=? and nursing_unit_code=? ");
			try
			{
				pstmt	=con.prepareStatement(sqlQuery.toString());
				pstmt.setString(1,facility_id);
				pstmt.setString(2,nursing_unit_code);
				n_Records	=	pstmt.executeUpdate();
								
			}
			catch(Exception ee)
			{
				messageBuffer.append("Error in update IP_NURSING_UNIT_ROOM with eff_status = D  "+ee.getMessage());
			}
			finally
			{
				if(pstmt!=null) pstmt.close();
				clearValues(sqlQuery);
			}
			sqlQuery.append("delete IP_NURSING_UNIT_ROOM  where facility_id=? and nursing_unit_code=? and nvl(no_of_beds,0) = 0 ");
			try
			{
				pstmt	=con.prepareStatement(sqlQuery.toString());
				pstmt.setString(1,facility_id);
				pstmt.setString(2,nursing_unit_code);
				n_Records	=	pstmt.executeUpdate();
			}
			catch(Exception ee)
			{
				messageBuffer.append("Error in delete IP_NURSING_UNIT_ROOM "+ee.getMessage());
			}
			finally
			{
				if(pstmt!=null) pstmt.close();
				clearValues(sqlQuery);
			}
			
				for(int i=0;i<totalCount;i++)
				{
					String roomNum				= (String)tabdata.get("chk"+i);
					String LevelIndicator		= (String)tabdata.get("level"+i);
					sqlQuery.append("update IP_NURSING_UNIT_ROOM set eff_status ='E',LEVEL_OF_CARE_CODE = ?  where facility_id=? and nursing_unit_code=? and ROOM_NO=? ");
					try
					{
						pstmt	=con.prepareStatement(sqlQuery.toString());
						pstmt.setString(1,LevelIndicator);
						pstmt.setString(2,facility_id);
						pstmt.setString(3,nursing_unit_code);
						pstmt.setString(4,roomNum);
						n_Records	=	pstmt.executeUpdate();
					}
					catch(Exception ee)
					{
						messageBuffer.append("Error in update IP_NURSING_UNIT_ROOM with eff_status = E "+ee.getMessage());
					}
					finally
					{
						if(pstmt!=null) pstmt.close();
						clearValues(sqlQuery);
					}
				
					if(n_Records == 0)
					{
						sqlQuery.append("Insert into IP_NURSING_UNIT_ROOM ");					sqlQuery.append("(FACILITY_ID, ");
						sqlQuery.append(" ROOM_NO, ");
						sqlQuery.append(" NURSING_UNIT_CODE, ");
						sqlQuery.append(" NO_OF_BEDS, ");
						sqlQuery.append(" EFF_STATUS, ");
						sqlQuery.append(" ADDED_BY_ID, ");
						sqlQuery.append(" ADDED_DATE, ");
						sqlQuery.append(" ADDED_AT_WS_NO, ");
						sqlQuery.append(" ADDED_FACILITY_ID, ");
						sqlQuery.append(" MODIFIED_BY_ID, ");
						sqlQuery.append(" MODIFIED_DATE, ");
						sqlQuery.append(" MODIFIED_AT_WS_NO, ");
						sqlQuery.append(" MODIFIED_FACILITY_ID, ");
						sqlQuery.append(" LEVEL_OF_CARE_CODE )");
						sqlQuery.append(" values ( ");
						sqlQuery.append(" ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?,? ) ");
						try
						{
							pstmt=con.prepareStatement(sqlQuery.toString());
							pstmt.setString(1,facility_id);
							pstmt.setString(2,roomNum);
							pstmt.setString(3,nursing_unit_code);
							pstmt.setInt(4,0);
							pstmt.setString(5,"E" );
							pstmt.setString (6, added_by_id);
							pstmt.setString(7, client_ip_address) ;
							pstmt.setString(8, facility_id  ) ;
							pstmt.setString(9, added_by_id ) ;
							pstmt.setString(10, client_ip_address) ;
							pstmt.setString(11, facility_id  ) ;
							pstmt.setString(12, LevelIndicator ) ;

							int res=pstmt.executeUpdate();

							if(res>0) 
								result=true;
							else 
								result=false;
						}
						catch(Exception ee)
						{
							messageBuffer.append("Error in insert IP_NURSING_UNIT_ROOM "+ee.getMessage());
						}
						finally
						{
							if(pstmt!=null) pstmt.close();
							clearValues(sqlQuery);
						}
					}
					result=true;
				} // End of for

*/
			
			
			if(result)
			{
				con.commit();
				final java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED","SM") ;
				messageBuffer.append( (String) message.get("message") ) ;
				message.clear();
			}
			else
				con.rollback();
	
	}catch(Exception ee)
	{
		messageBuffer.append("Error in main try "+ee.getMessage());
		ee.printStackTrace();
	}
	finally
	{
		if (con != null)
		{
			try
			{
				if(pstmt!=null) pstmt.close();
			}
			catch (Exception ee) { messageBuffer.append("Closing Connections "+ee.getMessage());    }
				if( con != null ) ConnectionManager.returnConnection(con,p);
		}
	}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", messageBuffer.toString() ) ;
		return results ;
}
	/**
	This method is used to clear the stringbuffer data
	@author - Ranjani 
	@version - V3
	@param1 - StringBuffer
	@return - StringBuffer
	*/

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	public StringBuffer clearValues(StringBuffer sbSql)
	{
		if(sbSql.length() > 0) 
			sbSql.delete(0,sbSql.length());
		return sbSql;
	}
} 

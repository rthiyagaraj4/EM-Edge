/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.WidgetSelection;

import java.rmi.*;
import javax.naming.*;
import java.util.*;
import java.sql.*;
import javax.rmi.*;
import javax.ejb.*;
import javax.ejb.SessionBean.*;
import webbeans.eCommon.*;
import blbkin.*;

/**
 *
 * @ejb.bean
 *	name="WidgetSelection"
 *	type="Stateless"
 *	transaction-type="Bean"
 *	view-type="both"
 *	jndi-name="WidgetSelection"
 *	local-jndi-name="WidgetSelection"
 *	impl-class-name="eOT.WidgetSelection.WidgetSelectionManager"
 *
 *
 * @ejb.interface
 *	extends="javax.ejb.EJBObject"
 *	local-extends="javax.ejb.EJBLocalObject"
 *	local-class="eOT.WidgetSelection.WidgetSelectionLocal"
 *	remote-class="eOT.WidgetSelection.WidgetSelectionRemote"
 *	generate= "local,remote"
 *
 * @ejb.home
 *	extends="javax.ejb.EJBHome"
 *	local-extends="javax.ejb.EJBLocalHome"
 *	local-class="eOT.WidgetSelection.WidgetSelectionLocalHome"
 *	remote-class="eOT.WidgetSelection.WidgetSelectionHome"
 *	generate= "local,remote"
 *
 *
 */

public class WidgetSelectionManager implements  SessionBean{
	SessionContext ctx;
	HashMap stmt_hash = new HashMap();
	Connection con = null;
	String locale  = "";
	String transaction_err_msg="";
	String err_text ="";
	String updt_err_text="";
	//call back methods overriden
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext sessionContext ) {
		this.ctx = sessionContext;
	}

	/**
	 *Method to insert the data
	 *@param tabData
	 *@param sqlMap
	 *@param CommonData
	 *@param prop
	 *@return String holding the transaction details
	 */
	/**
	 * @ejb.interface-method
	 *	 view-type="both"
	 */
	public java.util.HashMap insertWidgetSelection ( Properties	jdbc_props, java.util.HashMap	 htAEManagePatient ) {
		locale         				=	(String) htAEManagePatient.get ( "locale"	);
		java.util.HashMap results		=	new java.util.HashMap() ;
		PreparedStatement	pstmt	=	null;
		PreparedStatement delPstmt	= null;
		PreparedStatement insertPstmt	= null;
		ResultSet rs = null;
		ResultSet delRs = null;
		ResultSet insertRs = null;
		StringBuffer sql = new StringBuffer();
		StringBuffer deleteBuffer = new StringBuffer();
		StringBuffer insertBuffer = new StringBuffer();
		int setIndex = 0;
		String facility_id	    	=	(String) htAEManagePatient.get ("facilityId");
		int widget_selection_id  =	0;
		//widget_selection_id = (String) htAEManagePatient.get ("widget_selection_id");

		String staff_assign_yn			=	(String) htAEManagePatient.get ( "staffass");
		String room1				=	(String) htAEManagePatient.get ("room1");
		//String room2				=	(String) htAEManagePatient.get ("room2"); //Commented Against AAKH-ICN-0008
		String room3				=	(String) htAEManagePatient.get ("room3");
		String auto_refresh_yn			=	(String) htAEManagePatient.get ( "refresh");		
		String refresh_interval			=	(String) htAEManagePatient.get ( "RefreshInterval");		
		String refresh_interval_time			=	(String) htAEManagePatient.get ( "Interval");
		
		String widget_selection_id1=	(String) htAEManagePatient.get ( "widget_selection_id");
		String facilityid=	(String) htAEManagePatient.get ( "facilityid");
		String roomCode = ""; //Added against 45877
		
		boolean result				=  false;
		int insertedCount =  0;
		ArrayList chkedRoomsList = new ArrayList(Arrays.asList(room1.split(",")));

		//	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		//locale= p.getProperty("LOCALE");

		String client_ip_address =jdbc_props.getProperty("client_ip_address");
		String addedById = jdbc_props.getProperty( "login_user" ) ;	                        				           
		String modifiedById = addedById ;
		String addedFacilityId=facility_id;
		String modifiedFacilityId = addedFacilityId ;
		String addedAtWorkstation=client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;	
		MessageManager mmm = new MessageManager();
		final java.util.Hashtable mesaag = mmm.getMessage(locale, "FAILED_TRANSACTION", "SM") ;
		String recordmsg  = ((String) mesaag.get("message"));

		try {
			//con	=	ConnectionManager.getConnection(jdbc_props);
			con = ConnectionManager.getConnection();
			//con.setAutoCommit(false);
			
			if(staff_assign_yn.equals("Y")	&& room3 !="")
			{
			  room3="";
			}
			
/*
			if(!widget_selection_id1.equals("") && !facilityid.equals(""))
			{
				System.out.println("137,ejb update if=====>");
				AEPatQ		=	new StringBuffer() ;
				AEPatQ.append("update ot_widget_selection set STAFF_ASSIGN_YN=?,AUTO_REFRESH_YN=?,REFRESH_INTERVAL=?,REFRESH_INTERVAL_TIME=?,OT_ROOM_CODE1=?,OT_ROOM_CODE2=?,OT_ROOM_CODE3=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where  FACILITY_ID=? and WIDGET_SELECTION_ID=?");
				System.out.println("AEPatQ==="+AEPatQ.toString());
				pstmt	=	con.prepareStatement(AEPatQ.toString());
				pstmt.setString(1,staff_assign_yn);
				pstmt.setString(2,auto_refresh_yn);
				pstmt.setInt(3,Integer.parseInt(refresh_interval));
				pstmt.setString(4,refresh_interval_time);
				pstmt.setString(5,room1);
				pstmt.setString(6,room2);
				pstmt.setString(7,room3);
				pstmt.setString(8,modifiedById);
				pstmt.setString(9,modifiedAtWorkstation);
				pstmt.setString(10,modifiedFacilityId);
				pstmt.setString(11,facilityid);
				pstmt.setInt(12,Integer.parseInt(widget_selection_id1));
				
				updateRec1	=	pstmt.executeUpdate();
				System.out.println("updateRec1===>"+updateRec1);
			}
			else
			{
				System.out.println("140,ejb insert else=====>");
			
			pstmt =con.prepareStatement("select OT_WIDGET_SELECT_NO_SEQ.nextval widget_selection_id from dual");
			rset=pstmt.executeQuery();
			if(rset.next())
				widget_selection_id = rset.getInt("widget_selection_id");

				System.out.println("widget_selection_id==="+widget_selection_id);
			AEPatQ		=	new StringBuffer() ;
			AEPatQ.append("insert into ot_widget_selection (WIDGET_SELECTION_ID,FACILITY_ID,STAFF_ASSIGN_YN,AUTO_REFRESH_YN,REFRESH_INTERVAL,REFRESH_INTERVAL_TIME,OT_ROOM_CODE1,OT_ROOM_CODE2,OT_ROOM_CODE3,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
				System.out.println("AEPatQ==="+AEPatQ.toString());
			pstmt	=	con.prepareStatement(AEPatQ.toString());
			pstmt.setInt(1,widget_selection_id);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,staff_assign_yn);
			pstmt.setString(4,auto_refresh_yn);
			pstmt.setInt(5,Integer.parseInt(refresh_interval));
			pstmt.setString(6,refresh_interval_time);
			pstmt.setString(7,room1);
			pstmt.setString(8,room2);
			pstmt.setString(9,room3);
			pstmt.setString(10,addedById);
			pstmt.setString(11,addedAtWorkstation);
			pstmt.setString(12,addedFacilityId);
			pstmt.setString(13,modifiedById);
			pstmt.setString(14,modifiedAtWorkstation);
			pstmt.setString(15,modifiedFacilityId);
			
			updateRec1	=	pstmt.executeUpdate();
				System.out.println("updateRec1===>"+updateRec1);
			}
*/
			if(!widget_selection_id1.equals("") && !facilityid.equals(""))
			{
				deleteBuffer.append("	DELETE FROM ot_widget_selection	");
				deleteBuffer.append("	WHERE widget_selection_id = ? AND facility_id = ?	");
				delPstmt = con.prepareStatement(deleteBuffer.toString());
				delPstmt.setString(++setIndex, widget_selection_id1);
				delPstmt.setString(++setIndex, facility_id);
			
				//delRs = delPstmt.executeQuery();//Against [IN:045877]
				delPstmt.executeUpdate();
			}
			else
			{
				sql.append("	select OT_WIDGET_SELECT_NO_SEQ.nextval widget_selection_id from dual	");
				pstmt = con.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();
				if(rs.next())
					widget_selection_id = rs.getInt("widget_selection_id");
			}
			insertBuffer.append("	INSERT INTO ot_widget_selection	");
			insertBuffer.append("	(widget_selection_id, facility_id, staff_assign_yn,	");
			insertBuffer.append("	auto_refresh_yn, refresh_interval, refresh_interval_time,	");
			insertBuffer.append("	ot_room_code1, added_by_id,	");
			insertBuffer.append("	added_date, added_at_ws_no, added_facility_id, modified_by_id,	");
			insertBuffer.append("	modified_date, modified_at_ws_no, modified_facility_id	");
			insertBuffer.append("	)	");
			insertBuffer.append("	VALUES (?, ?, ?,	");
			insertBuffer.append("	?, ?, ?,	");
			insertBuffer.append("	?, ?,	");
			insertBuffer.append("	SYSDATE, ?, ?, ?,	");
			insertBuffer.append("	SYSDATE, ?, ?	");
			insertBuffer.append("	)	");

			insertPstmt	= con.prepareStatement(insertBuffer.toString());

			for(int r=0; r<chkedRoomsList.size(); r++)
			{
				roomCode = (String)chkedRoomsList.get(r);  //Added against 45877
				setIndex = 0;
				if(!widget_selection_id1.equals("") && !facilityid.equals(""))
					insertPstmt.setInt(++setIndex, Integer.parseInt(widget_selection_id1));
				else
					insertPstmt.setInt(++setIndex, widget_selection_id);
				insertPstmt.setString(++setIndex, facility_id);
				insertPstmt.setString(++setIndex, staff_assign_yn);
				insertPstmt.setString(++setIndex, auto_refresh_yn);
				insertPstmt.setInt(++setIndex, Integer.parseInt(refresh_interval));
				insertPstmt.setString(++setIndex, refresh_interval_time);
				if(roomCode != null && roomCode.trim().length() > 0) //Added against 45877
					insertPstmt.setString(++setIndex, roomCode);
				else
					insertPstmt.setString(++setIndex, "0");
				insertPstmt.setString(++setIndex, addedById);
				insertPstmt.setString(++setIndex, addedAtWorkstation);
				insertPstmt.setString(++setIndex, addedFacilityId);
				insertPstmt.setString(++setIndex, modifiedById);
				insertPstmt.setString(++setIndex, modifiedAtWorkstation);
				insertPstmt.setString(++setIndex, modifiedFacilityId);

				insertedCount += insertPstmt.executeUpdate();
			}
			if(insertedCount == chkedRoomsList.size())
			{
				sql.delete(0, sql.length());
			result = true ;
			MessageManager mm = new MessageManager();
			final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED", "SM") ;
			String msg  = ((String) mesg.get("message"));
				sql.append(msg) ;
			mesg.clear();
			con.commit();
			}
			else 
			{
				sql.delete(0, sql.length());
			con.rollback();
				sql.append("<br>"+recordmsg);
			}
			results.put( "status", new Boolean(result) ) ;
			results.put( "error", sql.toString() ) ;
			htAEManagePatient.clear();

			if(pstmt!=null) pstmt.close();
			if(delPstmt!=null) delPstmt.close();
			if(insertPstmt!=null) insertPstmt.close();
			if(rs!=null) rs.close();
			if(delRs!=null) delRs.close();
			if(insertRs!=null) insertRs.close();
		}
		catch(Exception e)
		{
			System.err.println("insertWidgetSelection==>"+e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(con != null)
				ConnectionManager.returnConnection(con);
		}
		return results ;	
	}
}







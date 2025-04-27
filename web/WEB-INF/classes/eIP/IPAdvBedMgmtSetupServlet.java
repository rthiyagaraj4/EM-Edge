/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.http.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.rmi.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.*;
import eIP.advbedmgmt.GBMConstants;
import eIP.advbedmgmt.common.CommonHelper;
import eIP.advbedmgmt.setup.beddimension.BedDimensionConstants;
import eIP.advbedmgmt.setup.beddimension.bc.BedDimensionBC;
import eIP.advbedmgmt.setup.beddimension.request.SaveDimensionRequest;
import eIP.advbedmgmt.setup.beddimension.response.SaveDimensionResponse;

public class IPAdvBedMgmtSetupServlet extends javax.servlet.http.HttpServlet
{
	Properties prop;
	String client_ip_address ;
	HttpSession session;
	String modifiedById;
	String modifiedAtWorkstation;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		//String layOutDataInfo=req.getParameter("layOutDataInfo");
		//System.out.println("IPAdvBedMgmtSetupServlet layOutDataInfo:"+layOutDataInfo);
		String operation=req.getParameter("operation")==null?"":req.getParameter("operation");
		
		session			  = req.getSession(false);
		this.prop			  = (java.util.Properties) session.getValue( "jdbc" ) ;
		modifiedById			= prop.getProperty( "login_user" ) ;
		modifiedAtWorkstation 	= prop.getProperty("client_ip_address");
		
		//System.out.println("IPAdvBedMgmtSetupServlet operation:"+operation);
		try{
			if(operation.equals("floorLayout")){
				updateFloorLayout(req,res);	
			}else if(operation.equals("roomLayout")){
				updateFloorRoomLayout(req,res);
			}else if(operation.equals("delRoomFromLayout")){
				deleteRoomFromLayout(req,res);			
			}else if(operation.equals("roomBedLayout")){
				updateRoomBedLayout(req,res);			
			}else if(operation.equals("delBedFromLayout")){
				deleteBedFromLayout(req,res);			
			}else if(operation.equals("colorCoding")){
				setBedMgmtColorSetup(req,res);			
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void updateFloorLayout(HttpServletRequest req, HttpServletResponse res)throws Exception{
		Connection con				= null;
		PreparedStatement	pstmt	= null;
		ResultSet rSet      		= null;
		StringBuffer updateSQL		= new StringBuffer("");	
		//String updateSQL			= null;
		
		try{
			HttpSession session		=  req.getSession(false);
			String facility_id		= (String)session.getValue("facility_id") ;
			String nursingUnit 	= req.getParameter("nursingUnit")==null?"":req.getParameter("nursingUnit");
			String floorWidth 	= req.getParameter("floorWidth")==null?"":req.getParameter("floorWidth");
			String floorHeight 	= req.getParameter("floorHeight")==null?"":req.getParameter("floorHeight");
			updateSQL.append( "update ip_nursing_unit set floor_width=?,floor_height=? ");
			//updating audit columns
			updateSQL.append(", modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
			updateSQL.append(" where NURSING_UNIT_CODE=? and FACILITY_ID=?");
			con = ConnectionManager.getConnection(req);
			pstmt = con.prepareStatement(updateSQL.toString());			
			pstmt.setInt(1, Integer.parseInt(floorWidth));
			pstmt.setInt(2, Integer.parseInt(floorHeight));
			pstmt.setString	( 3, facility_id) ;
			pstmt.setString	( 4, modifiedById);
			pstmt.setString	( 5, modifiedAtWorkstation);
			
			pstmt.setString(6,nursingUnit);
			pstmt.setString(7,facility_id);
			pstmt.executeUpdate();
			con.commit();
		}catch(Exception ex){
			ex.printStackTrace();
			con.rollback();
		}finally{
			try{
				if(rSet!=null)rSet.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(con != null)  ConnectionManager.returnConnection(con,req);
		} 
	}
	private void updateFloorRoomLayout(HttpServletRequest req, HttpServletResponse res)throws Exception{
		Connection con				= null;
		PreparedStatement	pstmt	= null;
		ResultSet rSet      		= null;
		StringBuffer updateSQL		= new StringBuffer("");	
		//String updateSQL			= null;
		HttpSession session=req.getSession();
		String facility_id		= (String)session.getAttribute("facility_id");
		String nursingUnit=req.getParameter("nursingUnit")==null?"":req.getParameter("nursingUnit");		
		//System.out.println("IPAdvBedMgmtSetupServlet updateFloorRoomLayout nursingUnit:"+nursingUnit);
		//System.out.println("IPAdvBedMgmtSetupServlet updateFloorRoomLayout facility_id:"+facility_id);
		try{
			String layOutDataInfo=req.getParameter("layOutDataInfo")==null?"":req.getParameter("layOutDataInfo");
			updateSQL.append("update  ip_nursing_unit_room set ROOM_LEFT_POSITION=?,ROOM_TOP_POSITION=?,ROOM_WIDTH=?,ROOM_HEIGHT=?  ");
			//updating audit columns
			updateSQL.append(", modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
			updateSQL.append(" where FACILITY_ID=? and NURSING_UNIT_CODE =? and ROOM_NO=?");
			con = ConnectionManager.getConnection(req);
			pstmt = con.prepareStatement(updateSQL.toString());
			StringTokenizer tokens=new StringTokenizer(layOutDataInfo,"|");
			while(tokens.hasMoreTokens()){
				String roomToken = tokens.nextToken(); 
				StringTokenizer roomTokens=new StringTokenizer(roomToken,"~");
				while(roomTokens.hasMoreTokens()){
					String roomNo 		= roomTokens.nextToken(); 
					String roomLeftPos 	= roomTokens.nextToken(); 
					String roomTopPos = roomTokens.nextToken();
					String roomWidth    = roomTokens.nextToken();
					String roomHeighth  = roomTokens.nextToken();					
					pstmt.setInt(1, Integer.parseInt(roomLeftPos));
					pstmt.setInt(2, Integer.parseInt(roomTopPos));
					pstmt.setInt(3, Integer.parseInt(roomWidth));
					pstmt.setInt(4, Integer.parseInt(roomHeighth));
					pstmt.setString	( 5, facility_id) ;
					pstmt.setString	( 6, modifiedById);
					pstmt.setString	( 7, modifiedAtWorkstation);
					
					pstmt.setString(8,facility_id);
					pstmt.setString(9,nursingUnit);
					pstmt.setString(10,roomNo);
					//System.out.println("IPAdvBedMgmtSetupServlet updateFloorRoomLayout roomNo:"+roomNo);
					//pstmt.setString(2, "mkyong101");
					//pstmt.setString(3, "system");
					//pstmt.setTimestamp(4, getCurrentTimeStamp());
					pstmt.addBatch();
				}
			}
			pstmt.executeBatch();
			con.commit();			
		}catch(Exception ex){
			ex.printStackTrace();
			con.rollback();
		}finally{
			try{
				if(rSet!=null)rSet.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(con != null)  ConnectionManager.returnConnection(con,req);
		}
	}
	
	private void deleteRoomFromLayout(HttpServletRequest req, HttpServletResponse res)throws Exception{
		Connection con				= null;
		PreparedStatement	pstmt	= null;
		ResultSet rSet      		= null;
		//String updateSQL			=null;
		StringBuffer updateSQL		= new StringBuffer("");	
		//String updateSQL			= null;
		try{
			String roomNo=req.getParameter("roomNo")==null?"":req.getParameter("roomNo");
			String nursingUnit=req.getParameter("nursingUnit")==null?"":req.getParameter("nursingUnit");
			String facility_id=req.getParameter("facility_id")==null?"":req.getParameter("facility_id");
			//System.out.println("IPAdvBedMgmtSetupServlet deleteRoomFromLayout roomNo:"+roomNo);
			//System.out.println("IPAdvBedMgmtSetupServlet deleteRoomFromLayout nursingUnit:"+nursingUnit);
			//System.out.println("IPAdvBedMgmtSetupServlet deleteRoomFromLayout facility_id:"+facility_id);
			updateSQL.append("update  ip_nursing_unit_room set ROOM_LEFT_POSITION=null,ROOM_TOP_POSITION=null,ROOM_WIDTH=null,ROOM_HEIGHT=null ");
			//updating audit columns
			updateSQL.append(", modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
			updateSQL.append(" where FACILITY_ID=? and NURSING_UNIT_CODE =? and ROOM_NO=?");
			con = ConnectionManager.getConnection(req);
			pstmt = con.prepareStatement(updateSQL.toString());
			pstmt.setString	( 1, facility_id) ;
			pstmt.setString	( 2, modifiedById);
			pstmt.setString	( 3, modifiedAtWorkstation);
			
			pstmt.setString(4,facility_id);
			pstmt.setString(5,nursingUnit);
			pstmt.setString(6,roomNo);
			pstmt.executeUpdate();
			updateSQL.delete(0, updateSQL.length());
			updateSQL.append("update  ip_nursing_unit_bed set BED_LEFT_POSITION=null,BED_TOP_POSITION=null,BED_WIDTH=null,BED_HEIGHT=null  ");
			//updating audit columns
			updateSQL.append(", modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
			
			updateSQL.append(" where FACILITY_ID=? and NURSING_UNIT_CODE =? and ROOM_NO=?");
			pstmt = con.prepareStatement(updateSQL.toString());
			pstmt.setString	( 1, facility_id) ;
			pstmt.setString	( 2, modifiedById);
			pstmt.setString	( 3, modifiedAtWorkstation);
			
			pstmt.setString(4,facility_id);
			pstmt.setString(5,nursingUnit);
			pstmt.setString(6,roomNo);
			pstmt.executeUpdate();
			con.commit();
			//HashMap nursingUnitRoomDataMap=eIP.IPRoomBedMgmtBean.getNursingUnitRoomData(con,nursingUnit);
			//System.out.println("nursingUnitRoomDataMap :"+nursingUnitRoomDataMap.toString());
			if(rSet!=null)rSet.close();
			if(pstmt!=null)pstmt.close();
		}catch(Exception ex){
			ex.printStackTrace();
			con.rollback();
		}finally{
			try{
				if(rSet!=null)rSet.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(con != null)  ConnectionManager.returnConnection(con,req);
		}
	}
	
	private void updateRoomBedLayout(HttpServletRequest req, HttpServletResponse res)throws Exception{
		Connection con				= null;
		PreparedStatement	pstmt	= null;
		ResultSet rSet      		= null;
		StringBuffer updateSQL		= new StringBuffer("");	
		//String updateSQL			= null;
		try{
			String layOutDataInfo=req.getParameter("layOutDataInfo")==null?"":req.getParameter("layOutDataInfo");
			String nursingUnit=req.getParameter("nursingUnit")==null?"":req.getParameter("nursingUnit");
			HttpSession session=req.getSession();
			String facility_id		= (String)session.getAttribute("facility_id");
			//System.out.println("RoomBedLayOutMgmtServlet layOutDataInfo:"+layOutDataInfo);
			//System.out.println("RoomBedLayOutMgmtServlet nursingUnit:"+nursingUnit);
			//System.out.println("RoomBedLayOutMgmtServlet facility_id:"+facility_id);
			updateSQL.append("update  ip_nursing_unit_bed set BED_LEFT_POSITION=?,BED_TOP_POSITION=?,BED_WIDTH=?,BED_HEIGHT=?  ");
			//updating audit columns
			updateSQL.append(", modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
			updateSQL.append(" where FACILITY_ID=? and NURSING_UNIT_CODE =? AND BED_NO=?");
			con = ConnectionManager.getConnection(req);
			pstmt = con.prepareStatement(updateSQL.toString());
			StringTokenizer tokens=new StringTokenizer(layOutDataInfo,"|");
			while(tokens.hasMoreTokens()){
				String roomToken = tokens.nextToken(); 
				//System.out.println("roomToken :"+roomToken);
				StringTokenizer roomTokens=new StringTokenizer(roomToken,"~");
				while(roomTokens.hasMoreTokens()){
					String bedNo 		= roomTokens.nextToken(); 
					String bedLeftPos 	= roomTokens.nextToken(); 
					String bedTopPos = roomTokens.nextToken();
					String bedWidth    = roomTokens.nextToken();
					String bedHeigth  = roomTokens.nextToken();					
					pstmt.setDouble(1, Double.parseDouble(bedLeftPos));
					pstmt.setDouble(2, Double.parseDouble(bedTopPos));
					pstmt.setDouble(3, Double.parseDouble(bedWidth));
					pstmt.setDouble(4, Double.parseDouble(bedHeigth));
					pstmt.setString	( 5, facility_id) ;
					pstmt.setString	( 6, modifiedById);
					pstmt.setString	( 7, modifiedAtWorkstation);
					
					pstmt.setString(8,facility_id);
					pstmt.setString(9,nursingUnit);
					pstmt.setString(10,bedNo);
					pstmt.addBatch();
				}
			}
			pstmt.executeBatch();
			con.commit();			
		}catch(Exception ex){
			ex.printStackTrace();
			con.rollback();
		}finally{
			try{
				if(rSet!=null)rSet.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(con != null)  ConnectionManager.returnConnection(con,req);
		}
	}
	
	private void deleteBedFromLayout(HttpServletRequest req, HttpServletResponse res)throws Exception{
		Connection con				= null;
		PreparedStatement	pstmt	= null;
		ResultSet rSet      		= null;
		StringBuffer updateSQL		= new StringBuffer("");	
		//String updateSQL			= null;
		try{
			
			String facility_id=req.getParameter("facility_id")==null?"":req.getParameter("facility_id");
			String nursingUnit=req.getParameter("nursingUnit")==null?"":req.getParameter("nursingUnit");
			String roomNo=req.getParameter("roomNo")==null?"":req.getParameter("roomNo");
			String bedNo=req.getParameter("bedNo")==null?"":req.getParameter("bedNo");
			//System.out.println("RoomBedLayOutMgmtServlet deleteBedFromLayout facility_id:"+facility_id);
			//System.out.println("RoomBedLayOutMgmtServlet deleteBedFromLayout nursingUnit:"+nursingUnit);
			//System.out.println("RoomBedLayOutMgmtServlet deleteBedFromLayout roomNo:"+roomNo);
			//System.out.println("RoomBedLayOutMgmtServlet deleteBedFromLayout bedNo:"+bedNo);
			updateSQL.append("update ip_nursing_unit_bed set BED_LEFT_POSITION=null,BED_TOP_POSITION=null,BED_WIDTH=null,BED_HEIGHT=null  ");
			//updating audit columns
			updateSQL.append(", modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
			updateSQL.append(" where FACILITY_ID=? AND NURSING_UNIT_CODE =? AND ROOM_NO=? AND BED_NO=?");
			
			con = ConnectionManager.getConnection(req);
			pstmt = con.prepareStatement(updateSQL.toString());

			pstmt.setString	( 1, facility_id) ;
			pstmt.setString	( 2, modifiedById);
			pstmt.setString	( 3, modifiedAtWorkstation);
			
			pstmt.setString(4,facility_id);
			pstmt.setString(5,nursingUnit);
			pstmt.setString(6,roomNo);
			pstmt.setString(7,bedNo);
			pstmt.executeUpdate();
			con.commit();
		}catch(Exception ex){
			ex.printStackTrace();
			con.rollback();
		}finally{
			try{
				if(rSet!=null)rSet.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(con != null)  ConnectionManager.returnConnection(con,req);
		}
	}
	
	private void setBedMgmtColorSetup(HttpServletRequest req, HttpServletResponse res)throws javax.servlet.ServletException,IOException{
		//System.out.println("IPAdvBedMgmtSetupServlet setBedMgmtColorSetup:");
		Connection con				= null;
		PreparedStatement	pstmt	= null;
		PreparedStatement	pstmt2	= null;
		PreparedStatement	prep	= null;
		ResultSet rSet      		= null;
		String updateSQL			=null;
		HttpSession session=req.getSession();
		String facility_id		= (String)session.getAttribute("facility_id");
		java.util.Properties p;
		p				= (java.util.Properties) session.getValue( "jdbc" ) ;
		
		String bedDfltWidth=req.getParameter("bedDfltWidth")==null?"0":req.getParameter("bedDfltWidth");
		String bedDfltHeight=req.getParameter("bedDfltHeight")==null?"0":req.getParameter("bedDfltHeight");
		int bedWidth = CommonHelper.getIntegerValue(bedDfltWidth, BedDimensionConstants.DEFAULT_WIDTH);
		int bedHeight = CommonHelper.getIntegerValue(bedDfltHeight, BedDimensionConstants.DEFAULT_HEIGHT);
		
		// code modified to call the bc class
		ApplicationContext context = new ClassPathXmlApplicationContext(GBMConstants.SPRING_BEANS_XML_NAME);
		BedDimensionBC bcInst = (BedDimensionBC)context.getBean(BedDimensionConstants.BC_IDENTIFIER);
		SaveDimensionRequest saveDimRequest = new SaveDimensionRequest();
		saveDimRequest.setWidth(bedWidth);
		saveDimRequest.setHeight(bedHeight);
		SaveDimensionResponse saveDimResponse = bcInst.saveBedDimension(saveDimRequest);
		
		// for test purpose
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		String returnMesg = "";
		if(!saveDimResponse.isSuccessful()){
			returnMesg = saveDimResponse.getErrorMessage();
		}
		res.getWriter().write(returnMesg);
		
		try{
			String layOutDataInfo=req.getParameter("layOutDataInfo")==null?"":req.getParameter("layOutDataInfo");


			
			
			String room											= req.getParameter("room")==null?"":req.getParameter("room");
			String admittedBed									= req.getParameter("admittedBed")==null?"":req.getParameter("admittedBed");
			String admittedBedText								= req.getParameter("admittedBedText")==null?"":req.getParameter("admittedBedText");
			String admissionInitiatedBed						= req.getParameter("admissionInitiatedBed")==null?"":req.getParameter("admissionInitiatedBed");
			String admissionInitiatedBedText					= req.getParameter("admissionInitiatedBedText")==null?"":req.getParameter("admissionInitiatedBedText");
			String abscondBed									= req.getParameter("abscondBed")==null?"":req.getParameter("abscondBed");
			String abscondBedText								= req.getParameter("abscondBedText")==null?"":req.getParameter("abscondBedText");
			String blockedBed									= req.getParameter("blockedBed")==null?"":req.getParameter("blockedBed");
			String blockedBedText								= req.getParameter("blockedBedText")==null?"":req.getParameter("blockedBedText");
			String blockedOverrideableBed						= req.getParameter("blockedOverrideableBed")==null?"":req.getParameter("blockedOverrideableBed");
			String blockedOverrideableBedText					= req.getParameter("blockedOverrideableBedText")==null?"":req.getParameter("blockedOverrideableBedText");
			String bookedBed									= req.getParameter("bookedBed")==null?"":req.getParameter("bookedBed");
			String bookedBedText								= req.getParameter("bookedBedText")==null?"":req.getParameter("bookedBedText");
			String dischargedBed								= req.getParameter("dischargedBed")==null?"":req.getParameter("dischargedBed");
			String dischargedBedText							= req.getParameter("dischargedBedText")==null?"":req.getParameter("dischargedBedText");
			String dischargeInitiatedBed						= req.getParameter("dischargeInitiatedBed")==null?"":req.getParameter("dischargeInitiatedBed");
			String dischargeInitiatedBedText					= req.getParameter("dischargeInitiatedBedText")==null?"":req.getParameter("dischargeInitiatedBedText");
			String infantBed									= req.getParameter("infantBed")==null?"":req.getParameter("infantBed");
			String infantBedText								= req.getParameter("infantBedText")==null?"":req.getParameter("infantBedText");
			String leaveBed										= req.getParameter("leaveBed")==null?"":req.getParameter("leaveBed");
			String leaveBedText									= req.getParameter("leaveBedText")==null?"":req.getParameter("leaveBedText");
			String transferOutBed								= req.getParameter("transferOutBed")==null?"":req.getParameter("transferOutBed");
			String transferOutBedText							= req.getParameter("transferOutBedText")==null?"":req.getParameter("transferOutBedText");
			String transferInitBed								= req.getParameter("transferInitBed")==null?"":req.getParameter("transferInitBed");	
			String transferInitBedText							= req.getParameter("transferInitBedText")==null?"":req.getParameter("transferInitBedText");
			String vacantBed									= req.getParameter("vacantBed")==null?"":req.getParameter("vacantBed");
			String vacantBedText								= req.getParameter("vacantBedText")==null?"":req.getParameter("vacantBedText");
			String transferAcceptedBed							= req.getParameter("transferAcceptedBed")==null?"":req.getParameter("transferAcceptedBed");
			String transferAcceptedBedText						= req.getParameter("transferAcceptedBedText")==null?"":req.getParameter("transferAcceptedBedText");
		
 			String priority_code = checkForNull(req.getParameter("priority"));
			String addedById 			= p.getProperty( "login_user" ) ;
			String modifiedFacilityId		=	facility_id;
			String addedAtWorkstation	=	client_ip_address;
		
			con = ConnectionManager.getConnection(req);
			
			String sql	="update GBM_COLOR_CONFIG set BACKGNDCOLOR=?,TEXTCOLOR=? where STAT=?";
			prep =  con.prepareStatement(sql);
	
			prep.setString(1, admittedBed);
			prep.setString(2, admittedBedText);
			prep.setString(3, "ADMITTED");
			prep.addBatch();
		
			prep.setString(1, admissionInitiatedBed);
			prep.setString(2, admissionInitiatedBedText);
			prep.setString(3, "ADMISSION_INITIATED");
			prep.addBatch();

			prep.setString(1, abscondBed);
			prep.setString(2, abscondBedText);
			prep.setString(3, "ABSCOND");
			prep.addBatch();

			prep.setString(1, blockedBed);
			prep.setString(2, blockedBedText);
			prep.setString(3, "BLOCKED");
			prep.addBatch();
		
			prep.setString(1, blockedOverrideableBed);
			prep.setString(2, blockedOverrideableBedText);
			prep.setString(3, "BLOCKED_OVERRIDEABLE");
			prep.addBatch();

			prep.setString(1, bookedBed);
			prep.setString(2, bookedBedText);
			prep.setString(3, "BOOKED");
			prep.addBatch();
			
			prep.setString(1, dischargedBed);
			prep.setString(2, dischargedBedText);
			prep.setString(3, "DISCHARGED");
			prep.addBatch();
		
			prep.setString(1, dischargeInitiatedBed);
			prep.setString(2, dischargeInitiatedBedText);
			prep.setString(3, "DISCHARGE_INITIATED");
			prep.addBatch();

			prep.setString(1, infantBed);
			prep.setString(2, infantBedText);
			prep.setString(3, "INFANT");
			prep.addBatch();

			prep.setString(1, leaveBed);
			prep.setString(2, leaveBedText);
			prep.setString(3, "LEAVE");
			prep.addBatch();
		
			prep.setString(1, transferOutBed);
			prep.setString(2, transferOutBedText);
			prep.setString(3, "TRANSFER_OUT");
			prep.addBatch();

			prep.setString(1, transferInitBed);
			prep.setString(2, transferInitBedText);
			prep.setString(3, "TRANSFER_INIT");
			prep.addBatch();

			prep.setString(1, vacantBed);
			prep.setString(2, vacantBedText);
			prep.setString(3, "VACANT");
			prep.addBatch();
		
			prep.setString(1, transferAcceptedBed);
			prep.setString(2, transferAcceptedBedText);
			prep.setString(3, "TRANSFER_ACCEPTED");
			prep.addBatch();


			int[] no = prep.executeBatch();
			System.err.println("no.length==>"+no.length);
	

		
			String ip_adv_bed_configSQL="select * from ip_adv_bed_config";
			pstmt = con.prepareStatement(ip_adv_bed_configSQL);
			rSet=pstmt.executeQuery();
			if(rSet!=null && rSet.next()){
				//System.out.println("Data Exists:");
				updateSQL="update ip_adv_bed_config set BED_DFLT_WIDTH=?,BED_DFLT_HEIGHT=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?";
				System.err.println("updateSQL==>"+updateSQL);

				pstmt2 = con.prepareStatement(updateSQL);
				int index = 1;
				pstmt2.setString(index,bedDfltWidth);
				index++;
				pstmt2.setString(index,bedDfltHeight);
				index++;				
				pstmt2.setString(index,p.getProperty( "login_user" ));
				index++;
				pstmt2.setString(index,p.getProperty("client_ip_address"));
				index++;
				pstmt2.setString(index,facility_id);
				
		
				//int count=pstmt2.executeUpdate();
				pstmt2.executeUpdate();
				con.commit();
				//System.out.println("update count :"+count);
			}else{
				//System.out.println("Data does not Exists:");
				// modified the code to insert a record properly
				// previously only bed default width and height were
				// being inserted into the table - this is incorrect
				final String FUNC_ID = "GRAPHICAL_BED_MGMT";
				final int ROOM_DEFAULT_WIDTH = 160;
				final int ROOM_DEFAULT_HEIGHT = 120;
				
				String inerstSQL="insert into ip_adv_bed_config(BED_DFLT_WIDTH," +
						"BED_DFLT_HEIGHT,ROOM_DFLT_WIDTH,ROOM_DFLT_HEIGHT," +
						"FUNCTION_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO," +
						"ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE," +
						"MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)values(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
				pstmt2 = con.prepareStatement(inerstSQL);
				int index = 1;
				pstmt2.setString(index,bedDfltWidth);
				index++;
				pstmt2.setString(index,bedDfltHeight);
				index++;
				
				pstmt2.setInt(index, ROOM_DEFAULT_WIDTH);
				index++;
				pstmt2.setInt(index, ROOM_DEFAULT_HEIGHT);
				index++;
				
				pstmt2.setString(index, FUNC_ID);
				index++;
				
				String id = p.getProperty( "login_user" );
				String ws = p.getProperty("client_ip_address");
				
				// added audit columns
				pstmt2.setString(index, id);
				index++;
				pstmt2.setString(index, ws);
				index++;
				pstmt2.setString(index, facility_id);
				index++;
				
				// modified audit columns
				pstmt2.setString(index, id);
				index++;
				pstmt2.setString(index, ws);
				index++;
				pstmt2.setString(index, facility_id);
				index++;

				//int count=pstmt2.executeUpdate();
				pstmt2.executeUpdate();
				con.commit();
				//System.out.println("insert count :"+count);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			try{
				con.rollback();
			}catch(Exception e){
				e.printStackTrace();
			}
		}finally{
			try{
				if(rSet!=null)rSet.close();
				if(pstmt!=null)pstmt.close();
				if(pstmt2!=null)pstmt2.close();
				if(prep!=null)prep.close();;
			}catch(Exception e){
				e.printStackTrace();
			}
			if(con != null)  ConnectionManager.returnConnection(con,req);
		}
	}
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
} 

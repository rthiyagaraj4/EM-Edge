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
import javax.servlet.http.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.*;
//import org.json.simple.*;
 
public class IPAdvBedMgmtConfigBean implements Serializable{

	public static HashMap getFloorLayout(Connection con,String facility_id,String nursing_unit)throws Exception{
		Statement stmt 	= null;
		ResultSet rs 	= null;
		HashMap hashMap=new HashMap();
		try{
			String sql="select floor_width,floor_height,(select count(room_no) from ip_nursing_unit_room where facility_id='"+facility_id+"' and nursing_unit_code='"+nursing_unit+"'and ROOM_HEIGHT is not null and ROOM_WIDTH is not null)count,APPL_PATIENT_CLASS from ip_nursing_unit where facility_id='"+facility_id+"' and nursing_unit_code='"+nursing_unit+"'";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs!=null && rs.next()){
				int floor_width=rs.getInt("floor_width");
				int floor_height=rs.getInt("floor_height");
				int count=rs.getInt("count");
				hashMap.put("floor_width",Integer.toString(floor_width));
				hashMap.put("floor_height",Integer.toString(floor_height));
				hashMap.put("count",Integer.toString(count));
				hashMap.put("appl_patient_class",rs.getString("APPL_PATIENT_CLASS"));
			}
			if(rs!=null)rs.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		//System.out.println("hashMap :"+hashMap.toString());
		return hashMap;
	}


	public static HashMap getRoomBedSizeData(Connection con,String facility_id)throws Exception{
		Statement stmt 	= null;
		ResultSet rs 	= null;
		HashMap hashMap=new HashMap();
		try{
			//String sql="select BED_DFLT_WIDTH,BED_DFLT_HEIGHT,room_img_width,room_img_height from ip_adv_bed_config";
			String sql="select BED_DFLT_WIDTH,BED_DFLT_HEIGHT,ROOM_DFLT_WIDTH,ROOM_DFLT_HEIGHT from ip_adv_bed_config";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs!=null && rs.next()){
				int bed_img_width=rs.getInt("BED_DFLT_WIDTH");
				int bed_img_height=rs.getInt("BED_DFLT_HEIGHT");
				int room_dflt_width=rs.getInt("ROOM_DFLT_WIDTH");
				int room_dflt_height=rs.getInt("ROOM_DFLT_HEIGHT");
				//int room_img_width=rs.getInt("room_img_width");
				//int room_img_height=rs.getInt("room_img_height");
				hashMap.put("bed_img_width",Integer.toString(bed_img_width));
				hashMap.put("bed_img_height",Integer.toString(bed_img_height));
				hashMap.put("room_dflt_width",Integer.toString(room_dflt_width));
				hashMap.put("room_dflt_height",Integer.toString(room_dflt_height));
				//hashMap.put("room_img_width",Integer.toString(room_img_width));
				//hashMap.put("room_img_height",Integer.toString(room_img_height));
			}
			if(rs!=null)rs.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		//System.out.println("hashMap :"+hashMap.toString());
		return hashMap;
	}	
	public static HashMap getNursingUnitRoomData(Connection con,String facility_id,String nursingUnit)throws Exception{
		//System.out.println("IPAdvBedMgmtConfBean getNursingUnitRoomData:");
		//String ipNursingUnitRoomSql = "select ROOM_NO,ROOM_LEFT_POSITION,ROOM_TOP_POSITION,ROOM_HEIGHT,ROOM_WIDTH from ip_nursing_unit_room where facility_id='"+facility_id+"' and nursing_unit_code='"+nursingUnit+"'";
		String ipNursingUnitRoomSql = "select a.ROOM_NO,(select short_desc from am_facility_room where OPERATING_FACILITY_ID=a.facility_id and ROOM_NUM=a.room_no)room_name,a.ROOM_LEFT_POSITION,a.ROOM_TOP_POSITION,a.ROOM_HEIGHT,a.ROOM_WIDTH,(select count(bed_no) from ip_nursing_unit_bed b where b.FACILITY_ID=a.facility_id and b.NURSING_UNIT_CODE =a.NURSING_UNIT_CODE and b.ROOM_NO=a.room_no and b.BED_HEIGHT is not null and b.BED_WIDTH is not null)count from ip_nursing_unit_room a where a.facility_id='"+facility_id+"' and a.nursing_unit_code='"+nursingUnit+"'";
		ArrayList unassignedRoomList 	= new ArrayList();
		ArrayList assignedRoomList 		= new ArrayList();
		Statement stmt 	= null;
		ResultSet rs 	= null;
		//System.out.println("IPAdvBedMgmtConfBean getNursingUnitRoomData ipNursingUnitRoomSql:"+ipNursingUnitRoomSql);
		try{
			stmt=con.createStatement();
			rs=stmt.executeQuery(ipNursingUnitRoomSql);
			//int assignedRoomCount=0; 
			//int unAssignedRoomCount=0;			
			if(rs!=null){
				while(rs.next()){
					String roomNo=rs.getString("ROOM_NO");
					String roomName=rs.getString("room_name");
					String roomTopPos=rs.getString("ROOM_TOP_POSITION")==null?"0":rs.getString("ROOM_TOP_POSITION");
					String roomLeftPos=rs.getString("ROOM_LEFT_POSITION")==null?"0":rs.getString("ROOM_LEFT_POSITION");
					String roomWidth=rs.getString("ROOM_WIDTH")==null?"0":rs.getString("ROOM_WIDTH");
					String roomHeight=rs.getString("ROOM_HEIGHT")==null?"0":rs.getString("ROOM_HEIGHT");
					String count=rs.getString("count")==null?"0":rs.getString("count");
					if(roomHeight.equals("0")){
						HashMap unassignedMap = new HashMap();
						unassignedMap.put("roomNo",roomNo);
						unassignedMap.put("roomName",roomName);
						unassignedRoomList.add(unassignedMap);
					}else{
						HashMap assignedMap = new HashMap();
						assignedMap.put("roomNo",roomNo);
						assignedMap.put("roomName",roomName);
						assignedMap.put("roomTopPos",roomTopPos);
						assignedMap.put("roomLeftPos",roomLeftPos);
						assignedMap.put("roomWidth",roomWidth);
						assignedMap.put("roomHeight",roomHeight);
						assignedMap.put("bedCount",count);
						assignedRoomList.add(assignedMap);
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(stmt!=null)stmt.close();
				if(rs!=null)rs.close();
			}catch(Exception ex){
			}
		}
		HashMap nursingUnitRoomDataMap = new HashMap();
		nursingUnitRoomDataMap.put("unassignedRoomList",unassignedRoomList);
		nursingUnitRoomDataMap.put("assignedRoomList",assignedRoomList);
		return nursingUnitRoomDataMap;
	}
	
	public static HashMap getIPRoomBedData(Connection con,PreparedStatement pstmt,ResultSet rs,String nursingUnit,String room,String facility_id)throws Exception{
		//System.out.println("IPRoomBedMgmtBean getIPRoomBedData:");
		String ipRoomBedSql = "select BED_NO,BED_LEFT_POSITION,BED_TOP_POSITION,BED_HEIGHT,BED_WIDTH from ip_nursing_unit_bed where FACILITY_ID=? and NURSING_UNIT_CODE =? and ROOM_NO=? and MAIN_BED_NO is null";
		//System.out.println("IPRoomBedMgmtBean getIPRoomBedData nursingUnit:"+nursingUnit);
		//System.out.println("IPRoomBedMgmtBean getIPRoomBedData room:"+room);
		//System.out.println("IPRoomBedMgmtBean getIPRoomBedData facility_id:"+facility_id);
		ArrayList unassignedBedList 	= new ArrayList();
		ArrayList assignedBedList 		= new ArrayList();
		HashMap roomDtlsMap = new HashMap();
		try{
			pstmt = con.prepareStatement(ipRoomBedSql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,nursingUnit);
			pstmt.setString(3,room);
			rs=pstmt.executeQuery();
			//int assignedRoomCount=0;
			//int unAssignedRoomCount=0;			
			if(rs!=null){
				while(rs.next()){
					String bedNo=rs.getString("BED_NO");
					String bedTopPos=rs.getString("BED_TOP_POSITION")==null?"0":rs.getString("BED_TOP_POSITION");
					String bedLeftPos=rs.getString("BED_LEFT_POSITION")==null?"0":rs.getString("BED_LEFT_POSITION");
					String bedWidth=rs.getString("BED_WIDTH")==null?"0":rs.getString("BED_WIDTH");
					String bedHeight=rs.getString("BED_HEIGHT")==null?"0":rs.getString("BED_HEIGHT");
					if(bedWidth.equals("0")){
						HashMap unassignedMap = new HashMap();
						unassignedMap.put("bedNo",bedNo);
						unassignedBedList.add(unassignedMap);
					}else{
						HashMap assignedMap = new HashMap();
						assignedMap.put("bedNo",bedNo);
						assignedMap.put("bedTopPos",bedTopPos);
						assignedMap.put("bedLeftPos",bedLeftPos);
						assignedMap.put("bedWidth",bedWidth);
						assignedMap.put("bedHeight",bedHeight);
						assignedBedList.add(assignedMap);
					}
				}
			}
			String ipNursingUnitRoomSql = "select ROOM_NO,ROOM_LEFT_POSITION,ROOM_TOP_POSITION,ROOM_HEIGHT,ROOM_WIDTH from ip_nursing_unit_room where facility_id=? and nursing_unit_code=? and ROOM_NO=?";
			if(pstmt!=null)pstmt.close();
			pstmt = con.prepareStatement(ipNursingUnitRoomSql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,nursingUnit);
			pstmt.setString(3,room);
			if(rs!=null)rs.close();
			rs=pstmt.executeQuery();
			if(rs!=null && rs.next()){
				String roomNo=rs.getString("ROOM_NO");
				String roomName=rs.getString("ROOM_NO");
				String roomTopPos=rs.getString("ROOM_TOP_POSITION")==null?"0":rs.getString("ROOM_TOP_POSITION");
				String roomLeftPos=rs.getString("ROOM_LEFT_POSITION")==null?"0":rs.getString("ROOM_LEFT_POSITION");
				String roomWidth=rs.getString("ROOM_WIDTH")==null?"0":rs.getString("ROOM_WIDTH");
				String roomHeight=rs.getString("ROOM_HEIGHT")==null?"0":rs.getString("ROOM_HEIGHT");
				roomDtlsMap.put("roomNo",roomNo);
				roomDtlsMap.put("roomName",roomName);
				roomDtlsMap.put("roomTopPos",roomTopPos);
				roomDtlsMap.put("roomLeftPos",roomLeftPos);
				roomDtlsMap.put("roomWidth",roomWidth);
				roomDtlsMap.put("roomHeight",roomHeight);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		HashMap ipRoomBedDataMap = new HashMap();
		ipRoomBedDataMap.put("unassignedBedList",unassignedBedList);
		ipRoomBedDataMap.put("assignedBedList",assignedBedList);
		ipRoomBedDataMap.put("roomDtlsMap",roomDtlsMap);
		return ipRoomBedDataMap;
	}
	
	public static ArrayList getNursingUnitRoomBedSetupData(Connection con,Statement stmt,ResultSet rs,String nursingUnit,String facility_id)throws Exception{
		//System.out.println("IPRoomBedMgmtBean getNursingUnitRoomData:");
		String ipNursingUnitRoomSql = "select ROOM_NO,(select short_desc from am_facility_room where OPERATING_FACILITY_ID=facility_id and ROOM_NUM=room_no)room_name,ROOM_LEFT_POSITION,ROOM_TOP_POSITION,ROOM_HEIGHT,ROOM_WIDTH from ip_nursing_unit_room where facility_id='"+facility_id+"' and nursing_unit_code='"+nursingUnit+"' and ROOM_WIDTH is not null";
		String ipRoomBedSql = "select BED_NO,BED_LEFT_POSITION,BED_TOP_POSITION,BED_HEIGHT,BED_WIDTH from ip_nursing_unit_bed where FACILITY_ID=? and NURSING_UNIT_CODE =? and ROOM_NO=? and BED_LEFT_POSITION is not null";
		ResultSet 			bedRs		= null;
		PreparedStatement	bedPstmt	= null;
		ArrayList floorRoomBedList 	= new ArrayList();
		try{
			rs=stmt.executeQuery(ipNursingUnitRoomSql);
			//int assignedRoomCount=0;
			//int unAssignedRoomCount=0;			
			if(rs!=null){
				bedPstmt = con.prepareStatement(ipRoomBedSql);
				while(rs.next()){
					ArrayList roomBedsList = new ArrayList();
					String roomNo=rs.getString("ROOM_NO");
					String roomName=rs.getString("room_name");
					String roomTopPos=rs.getString("ROOM_TOP_POSITION")==null?"0":rs.getString("ROOM_TOP_POSITION");
					String roomLeftPos=rs.getString("ROOM_LEFT_POSITION")==null?"0":rs.getString("ROOM_LEFT_POSITION");
					String roomWidth=rs.getString("ROOM_WIDTH")==null?"0":rs.getString("ROOM_WIDTH");
					String roomHeight=rs.getString("ROOM_HEIGHT")==null?"0":rs.getString("ROOM_HEIGHT");
					bedPstmt.setString(1,facility_id);
					bedPstmt.setString(2,nursingUnit);
					bedPstmt.setString(3,roomNo);
					bedRs=bedPstmt.executeQuery();
					if(bedRs!=null){
						while(bedRs.next()){
							String bedNo=bedRs.getString("BED_NO");
							String bedTopPos=bedRs.getString("BED_TOP_POSITION")==null?"0":bedRs.getString("BED_TOP_POSITION");
							String bedLeftPos=bedRs.getString("BED_LEFT_POSITION")==null?"0":bedRs.getString("BED_LEFT_POSITION");
							String bedWidth=bedRs.getString("BED_WIDTH")==null?"0":bedRs.getString("BED_WIDTH");
							String bedHeight=bedRs.getString("BED_HEIGHT")==null?"0":bedRs.getString("BED_HEIGHT");
							HashMap roomBedsMap = new HashMap();
							roomBedsMap.put("bedNo",bedNo);
							roomBedsMap.put("bedTopPos",bedTopPos);
							roomBedsMap.put("bedLeftPos",bedLeftPos);
							roomBedsMap.put("bedWidth",bedWidth);
							roomBedsMap.put("bedHeight",bedHeight);
							roomBedsList.add(roomBedsMap);
						}
					}
					if(bedRs!=null)bedRs.close();					
					HashMap roomsMap = new HashMap();
					roomsMap.put("roomNo",roomNo);
					roomsMap.put("roomName",roomName);
					roomsMap.put("roomTopPos",roomTopPos);
					roomsMap.put("roomLeftPos",roomLeftPos);
					roomsMap.put("roomWidth",roomWidth);
					roomsMap.put("roomHeight",roomHeight);
					roomsMap.put("roomBedsList",roomBedsList);
					floorRoomBedList.add(roomsMap);
				}
				if(bedPstmt!=null)bedPstmt.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(bedRs!=null)bedRs.close();
				if(bedPstmt!=null)bedPstmt.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		//System.out.println("IPRoomBedMgmtBean getNursingUnitRoomBedData floorRoomBedList:"+floorRoomBedList.toString());
		return floorRoomBedList;
	}
	
	
	
	public static ArrayList getNursingUnitRoomBedData(Connection con,Statement stmt,ResultSet rs,String nursingUnit,String facility_id)throws Exception{
		//System.out.println("IPRoomBedMgmtBean getNursingUnitRoomData:");
		String ipNursingUnitRoomSql = "select ROOM_NO,ROOM_LEFT_POSITION,ROOM_TOP_POSITION,ROOM_HEIGHT,ROOM_WIDTH from ip_nursing_unit_room where nursing_unit_code='"+nursingUnit+"' and ROOM_WIDTH is not null";
		String ipRoomBedSql = "select BED_NO,BED_LEFT_POSITION,BED_TOP_POSITION,BED_HEIGHT,BED_WIDTH from ip_nursing_unit_bed where FACILITY_ID=? and NURSING_UNIT_CODE =? and ROOM_NO=? and BED_LEFT_POSITION is not null";
		ResultSet 			bedRs		= null;
		PreparedStatement	bedPstmt	= null;
		ArrayList floorRoomBedList 	= new ArrayList();
		try{
			
			rs=stmt.executeQuery(ipNursingUnitRoomSql);
			//int assignedRoomCount=0;
			//int unAssignedRoomCount=0;			
			if(rs!=null){
				bedPstmt = con.prepareStatement(ipRoomBedSql);
				while(rs.next()){
					ArrayList roomBedsList = new ArrayList();
					String roomNo=rs.getString("ROOM_NO");
					String roomName=rs.getString("ROOM_NO");
					String roomTopPos=rs.getString("ROOM_TOP_POSITION")==null?"0":rs.getString("ROOM_TOP_POSITION");
					String roomLeftPos=rs.getString("ROOM_LEFT_POSITION")==null?"0":rs.getString("ROOM_LEFT_POSITION");
					String roomWidth=rs.getString("ROOM_WIDTH")==null?"0":rs.getString("ROOM_WIDTH");
					String roomHeight=rs.getString("ROOM_HEIGHT")==null?"0":rs.getString("ROOM_HEIGHT");
					bedPstmt.setString(1,facility_id);
					bedPstmt.setString(2,nursingUnit);
					bedPstmt.setString(3,roomNo);
					bedRs=bedPstmt.executeQuery();
					if(bedRs!=null){
						while(bedRs.next()){
							String bedNo=bedRs.getString("BED_NO");
							String bedTopPos=bedRs.getString("BED_TOP_POSITION")==null?"0":bedRs.getString("BED_TOP_POSITION");
							String bedLeftPos=bedRs.getString("BED_LEFT_POSITION")==null?"0":bedRs.getString("BED_LEFT_POSITION");
							String bedWidth=bedRs.getString("BED_WIDTH")==null?"0":bedRs.getString("BED_WIDTH");
							String bedHeight=bedRs.getString("BED_HEIGHT")==null?"0":bedRs.getString("BED_HEIGHT");
							HashMap roomBedsMap = new HashMap();
							roomBedsMap.put("bedNo",bedNo);
							roomBedsMap.put("bedTopPos",bedTopPos);
							roomBedsMap.put("bedLeftPos",bedLeftPos);
							roomBedsMap.put("bedWidth",bedWidth);
							roomBedsMap.put("bedHeight",bedHeight);
							roomBedsList.add(roomBedsMap);
						}
					}
					if(bedRs!=null)bedRs.close();					
					HashMap roomsMap = new HashMap();
					roomsMap.put("roomNo",roomNo);
					roomsMap.put("roomName",roomName);
					roomsMap.put("roomTopPos",roomTopPos);
					roomsMap.put("roomLeftPos",roomLeftPos);
					roomsMap.put("roomWidth",roomWidth);
					roomsMap.put("roomHeight",roomHeight);
					roomsMap.put("roomBedsList",roomBedsList);
					floorRoomBedList.add(roomsMap);
				}
				if(bedPstmt!=null)bedPstmt.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(bedRs!=null)bedRs.close();
				if(bedPstmt!=null)bedPstmt.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		//System.out.println("IPRoomBedMgmtBean getNursingUnitRoomBedData floorRoomBedList:"+floorRoomBedList.toString());
		return floorRoomBedList;
	}
	
	public static HashMap getBedConfSetupData(Connection con)throws Exception{
		Statement stmt 	= null;
		ResultSet rs 	= null;
		HashMap <String,String>hashMap=new HashMap<String,String>();
		try{
			//String sql="select BED_DFLT_WIDTH,BED_DFLT_HEIGHT,room_img_width,room_img_height from ip_adv_bed_config";
			String ip_adv_bed_configSQL="select BED_DFLT_WIDTH,BED_DFLT_HEIGHT,VACANTBED_CLR,OCCUPIEDBED_CLR,VACANTPSEUDOBED_CLR,OCCUPIEDPSEUDOBED_CLR,BLKDNONOVRDBED_CLR,BLKDOVRDBED_CLR,reservedBed_clr,OCCDEPARTEDBED_CLR,BKDOVRDCONFIRMBED_CLR,BKDOVRDUNCONFIRMBED_CLR,BKDNONOVRDCONFIRMBED_CLR,BKDNONOVRDUNCONFIRMBED_CLR,VACANTBED_TEXT_CLR,OCCUPIEDBED_TEXT_CLR,VACANTPSEUDOBED_TEXT_CLR,OCCUPIEDPSEUDOBED_TEXT_CLR,BLKDNONOVRDBED_TEXT_CLR,BLKDOVRDBED_TEXT_CLR,RESERVEDBED_TEXT_CLR,OCCDEPARTEDBED_TEXT_CLR,BKDOVRDCONFIRMBED_TEXT_CLR,BKDOVRDUNCONFIRMBED_TEXT_CLR,BKDNONOVRDCONFIRMBED_TEXT_CLR,BKDNONOVRDUNCNFRMBED_TEXT_CLR,ROOM_CLR  from ip_adv_bed_config";
			stmt=con.createStatement();
			rs=stmt.executeQuery(ip_adv_bed_configSQL);
			if(rs!=null && rs.next()){
				hashMap.put("bed_img_width",rs.getString("BED_DFLT_WIDTH")==null?"140":rs.getString("BED_DFLT_WIDTH"));
				hashMap.put("bed_img_height",rs.getString("BED_DFLT_HEIGHT")==null?"60":rs.getString("BED_DFLT_HEIGHT"));
				hashMap.put("vacantBed_clr",rs.getString("VACANTBED_CLR")==null?"8bd69f":rs.getString("VACANTBED_CLR"));
				hashMap.put("occupiedBed_clr",rs.getString("OCCUPIEDBED_CLR")==null?"#8bd69f":rs.getString("OCCUPIEDBED_CLR"));
				hashMap.put("vacantPseudoBed_clr",rs.getString("VACANTPSEUDOBED_CLR")==null?"8bd69f":rs.getString("VACANTPSEUDOBED_CLR"));
				hashMap.put("occupiedPseudoBed_clr",rs.getString("OCCUPIEDPSEUDOBED_CLR")==null?"8bd69f":rs.getString("OCCUPIEDPSEUDOBED_CLR"));
				hashMap.put("blkdNonOverrideBed_clr",rs.getString("BLKDNONOVRDBED_CLR")==null?"8bd69f":rs.getString("BLKDNONOVRDBED_CLR"));
				hashMap.put("blkdOverrideBed_clr",rs.getString("BLKDOVRDBED_CLR")==null?"8bd69f":rs.getString("BLKDOVRDBED_CLR"));
				hashMap.put("reservedBed_clr",rs.getString("RESERVEDBED_CLR")==null?"8bd69f":rs.getString("RESERVEDBED_CLR"));
				hashMap.put("occDepartedBed_clr",rs.getString("OCCDEPARTEDBED_CLR")==null?"8bd69f":rs.getString("OCCDEPARTEDBED_CLR"));
				hashMap.put("bkdOverrideConfirmBed_clr",rs.getString("BKDOVRDCONFIRMBED_CLR")==null?"8bd69f":rs.getString("BKDOVRDCONFIRMBED_CLR"));
				hashMap.put("bkdOverrideUnConfirmBed_clr",rs.getString("BKDOVRDUNCONFIRMBED_CLR")==null?"8bd69f":rs.getString("BKDOVRDUNCONFIRMBED_CLR"));
				hashMap.put("bkdNonOverrideConfirmBed_clr",rs.getString("BKDNONOVRDCONFIRMBED_CLR")==null?"8bd69f":rs.getString("BKDNONOVRDCONFIRMBED_CLR"));
				hashMap.put("bkdNonOverrideUnConfirmBed_clr",rs.getString("BKDNONOVRDUNCONFIRMBED_CLR")==null?"8bd69f":rs.getString("BKDNONOVRDUNCONFIRMBED_CLR"));
				hashMap.put("vacantbed_text_clr",rs.getString("VACANTBED_TEXT_CLR")==null?"8bd69f":rs.getString("VACANTBED_TEXT_CLR"));
				hashMap.put("occupiedbed_text_clr",rs.getString("OCCUPIEDBED_TEXT_CLR")==null?"8bd69f":rs.getString("OCCUPIEDBED_TEXT_CLR"));
				hashMap.put("vacantpseudobed_text_clr",rs.getString("VACANTPSEUDOBED_TEXT_CLR")==null?"8bd69f":rs.getString("VACANTPSEUDOBED_TEXT_CLR"));
				hashMap.put("occupiedpseudobed_text_clr",rs.getString("OCCUPIEDPSEUDOBED_TEXT_CLR")==null?"8bd69f":rs.getString("OCCUPIEDPSEUDOBED_TEXT_CLR"));
				hashMap.put("blkdnonovrdbed_text_clr",rs.getString("BLKDNONOVRDBED_TEXT_CLR")==null?"8bd69f":rs.getString("BLKDNONOVRDBED_TEXT_CLR"));
				hashMap.put("blkdovrdbed_text_clr",rs.getString("BLKDOVRDBED_TEXT_CLR")==null?"8bd69f":rs.getString("BLKDOVRDBED_TEXT_CLR"));
				hashMap.put("reservedbed_text_clr",rs.getString("RESERVEDBED_TEXT_CLR")==null?"8bd69f":rs.getString("RESERVEDBED_TEXT_CLR"));
				hashMap.put("occdepartedbed_text_clr",rs.getString("OCCDEPARTEDBED_TEXT_CLR")==null?"8bd69f":rs.getString("OCCDEPARTEDBED_TEXT_CLR"));
				hashMap.put("bkdovrdconfirmbed_text_clr",rs.getString("BKDOVRDCONFIRMBED_TEXT_CLR")==null?"8bd69f":rs.getString("BKDOVRDCONFIRMBED_TEXT_CLR"));
				hashMap.put("bkdovrdunconfirmbed_text_clr",rs.getString("BKDOVRDUNCONFIRMBED_TEXT_CLR")==null?"8bd69f":rs.getString("BKDOVRDUNCONFIRMBED_TEXT_CLR"));
				hashMap.put("bkdnonovrdconfirmbed_text_clr",rs.getString("BKDNONOVRDCONFIRMBED_TEXT_CLR")==null?"8bd69f":rs.getString("BKDNONOVRDCONFIRMBED_TEXT_CLR"));
				hashMap.put("bkdnonovrduncnfrmbed_text_clr",rs.getString("BKDNONOVRDUNCNFRMBED_TEXT_CLR")==null?"8bd69f":rs.getString("BKDNONOVRDUNCNFRMBED_TEXT_CLR"));
				hashMap.put("room_clr",rs.getString("ROOM_CLR")==null?"8bd69f":rs.getString("ROOM_CLR"));
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		//System.out.println("hashMap :"+hashMap.toString());
		return hashMap;
	}
	
	
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}

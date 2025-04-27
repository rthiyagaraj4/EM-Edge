package eXH.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class XHJSONBuild {
	public static String l_debug_YN = "Y";
	static String l_field_separator = "$!^";
	/*public static void main(String[] args){
		String app_id="PRACTO";
		String event_type="OA24";
		String facility_id="KH";
		ConnectionManager.getDBDetails();
		String blkactionKey = "<REQTYPE>BLK$!^<URL>https://<hmsdomain>/doctors/block_slots$!^<APPLICATION_ID>PRACTO$!^<FACILITY_ID>KH$!^<EVENT_TYPE>OA24$!^<MESSAGE_ID>1$!^<PROTOCOL_LINK>KHPRACTPL1$!^"
				+"<ADDED_BY_ID>dflt$!^<ADDED_AT_WS_NO>dflt$!^<ADDED_FACILITY_ID>KH$!^<ADDED_DATE>YYYYMMDDHH24MISS$!^<key>atfo8z$!^<salt>w2psja8n2mhw5nw$!^"
				+"<signature>slotid$!^JSON<slot_id>asdasasdas$!^<reason>Doctor not available$!^<block_timings>[$!^<start_time>12319230192380198$!^<end_time>24232342342234$!^<block_timings>]";
		buildJson(app_id, event_type,facility_id,blkactionKey);
		
	}*/

	public static String buildJson(String app_id,String event_type,String facility_id,String actionkey) {
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		String l_key_string="",l_key_type="",l_json_string = "";
		JSONObject jsonObjString = new JSONObject();
		l_app_msg = " ::: Inside buildJson ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		l_app_msg = " ::: app_id ::: "+app_id+" ::: event_type ::: "+event_type+" ::: facility_id ::: "+facility_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		try
		{
			dbConn =  EMDataSource.getConnection();
			//dbConn =  EMDBConnectionPool.getConnection();
			query = "select KEY_TYPE, KEY_STRING from XH_JSON_PARAM_DTL "
					+ " where PARENT_NODE is NULL and APPLICATION_ID=? and EVENT_TYPE=?  and FACILITY_ID=? order by SEQ_NUM";
			
			l_app_msg = " :::query ::: "+query;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, app_id);
			pstmt.setString(2, event_type);
			pstmt.setString(3, facility_id);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				
			   l_key_type = rs.getString("KEY_TYPE");
			   l_key_string=rs.getString("KEY_STRING");
			   
			   l_app_msg = " ::: l_key_type ::: "+l_key_type+"::: l_key_string ::: "+l_key_string;
			   if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
				
			   if (l_key_type.equals("O")){
				  
				   jsonObjString.put(l_key_string, getObject(app_id,event_type,l_key_string,facility_id,actionkey));
				   
			   }
			   else if (l_key_type.equals("A")){
				  
				   jsonObjString.put(l_key_string,getArray(app_id,event_type,l_key_string,facility_id,actionkey));
				   
			   }
			   else{
				   l_field_value = FetchFieldValue(actionkey, "<"+l_key_string+">", null, l_field_separator, "ProcessRequest");
				   if(l_key_type.equals("N"))
					   jsonObjString.put(l_key_string,Integer.parseInt(l_field_value));
				   else
					   jsonObjString.put(l_key_string,l_field_value); 
			   }
			   
			}
			l_app_msg = " ::: jsonObjString ::: "+jsonObjString;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			
			l_json_string = jsonObjString.toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			l_json_string  = "Error in "+ l_app_msg + " : " +  e;
		}
		finally {
			//XHUtil.closeDBResources(rs, pstmt, dbConn);	
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}	
		return  l_json_string;
		
	}

	public static JSONArray getArray(String app_id, String event_type, String l_parent,String facility_id,String actionkey) {
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "",l_key_string= "", l_field_value = "";
		 JSONObject jsonObjString = new JSONObject();
		 JSONArray array =new JSONArray();
		String l_json_string = "[",l_key_type="";
		l_app_msg = " ::: Inside getArray ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			
		
		try
		{
			dbConn =  EMDataSource.getConnection();
			//dbConn =  EMDBConnectionPool.getConnection();
			query = "select KEY_TYPE,KEY_STRING from XH_JSON_PARAM_DTL where application_id=? and event_type=? and FACILITY_ID=? and Parent_node =?" ;

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, app_id);
			pstmt.setString(2, event_type);
			pstmt.setString(3, facility_id);
			pstmt.setString(4, l_parent);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_key_type = rs.getString("KEY_TYPE");
			   l_key_string=rs.getString("KEY_STRING");
			   
			   if (l_key_type.equals("O")){				  
				   jsonObjString.put(l_key_string, getObject(app_id,event_type,l_key_string,facility_id,actionkey));
				   l_app_msg = " ::: Inside jsonObjString O::: "+jsonObjString;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			   }
			   else if (l_key_type.equals("A")){
				   
				   jsonObjString.put(l_key_string, getArray(app_id,event_type,l_key_string,facility_id,actionkey));
				   l_app_msg = " ::: Inside jsonObjString A::: "+jsonObjString;
					if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			   }
				   
			   else
			  {	
			   l_field_value = FetchFieldValue(actionkey, "<"+l_key_string+">", null, l_field_separator, "ProcessRequest");
			   if(l_key_type.equals("N"))
				   jsonObjString.put(l_key_string,Integer.parseInt(l_field_value));
			   else
				   jsonObjString.put(l_key_string,l_field_value); 	
			  
			  }
			   l_app_msg = " ::: Inside jsonObjString::: "+jsonObjString;
				if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
			   
			   
			}
			array.add(jsonObjString);
			l_app_msg = " ::: Inside array::: "+array;
			if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		}
		catch(Exception e)
		{
			System.out.println( "Error in "+ l_app_msg + " : " +  e.getMessage());
		}
		finally {
			//XHUtil.closeDBResources(rs, pstmt, dbConn);	
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return array;
	}

	public static JSONObject getObject(String app_id, String event_type, String l_parent,String facility_id,String actionkey) {
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		String query = "";
		String l_app_msg = "", l_field_value = "";

		String l_key_type="",l_key_string ="";
		
		JSONObject jsonObjString = new JSONObject();
		l_app_msg = " ::: Inside GenerateTransIDMethod ::: ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);			
		
		try
		{
			dbConn =  EMDataSource.getConnection();
			//dbConn =  EMDBConnectionPool.getConnection();
			query = "select KEY_TYPE,KEY_STRING from XH_JSON_PARAM_DTL where application_id=? and event_type=?  and FACILITY_ID=? and Parent_node =?" ;

			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, app_id);
			pstmt.setString(2, event_type);
			pstmt.setString(3, facility_id);
			pstmt.setString(4, l_parent);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_key_type = rs.getString("KEY_TYPE");
			   l_key_string=rs.getString("KEY_STRING");
			   if (l_key_type.equals("O"))
			   {				   
				   jsonObjString.put(l_key_string, getObject(app_id,event_type,l_key_string,facility_id,actionkey));
			   }
			   else if (l_key_type.equals("A")){
				   jsonObjString.put(l_key_string, getArray(app_id,event_type,l_key_string,facility_id,actionkey));
			   }
			   else
			   {	
				   l_field_value = FetchFieldValue(actionkey, "<"+l_key_string+">", null, l_field_separator, "ProcessRequest");
				   if(l_key_type.equals("N"))
					   jsonObjString.put(l_key_string,Integer.parseInt(l_field_value));
				   else
					   jsonObjString.put(l_key_string,l_field_value); 
			   }
				   
			}
			
		}
		catch(Exception e)
		{
			System.out.println( "Error in "+ l_app_msg + " : " +  e.getMessage());
		}
		finally {
			//XHUtil.closeDBResources(rs, pstmt, dbConn);	
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		return jsonObjString;
		
	}
	public static String FetchFieldValue(String message, String identifier, String standardCode, String fieldSep, String procID){

		String l_app_msg = "", l_field_value = "";

		l_app_msg = " ::: Inside FetchFieldValue ::: ";
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Message : "+ message + " ::: Identifier : " + identifier + " ::: Standard Code : "+ standardCode;
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: Deriving Field Value..."+identifier;
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			if(standardCode != null && !(standardCode.length()>0))
			{

			}
			else
			{
				if (message.indexOf(identifier) >= 0 )
				{
					if (message.indexOf(fieldSep) >= 0)
					{
						l_field_value = message.substring(message.indexOf(identifier)+identifier.length());
						if (l_field_value.indexOf(fieldSep) >= 0)
						{						
							l_field_value = l_field_value.substring(0, l_field_value.indexOf(fieldSep));
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}		

		l_app_msg = " ::: l_field_value ::: "+l_field_value;
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		return l_field_value;
	}
	
}

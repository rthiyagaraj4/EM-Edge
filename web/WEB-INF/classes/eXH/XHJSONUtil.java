package eXH;
import java.sql.Clob;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.*;

public class XHJSONUtil {
	
	static JSONObject jsonObjString = new JSONObject();
	static JSONObject jsonObjMain = new JSONObject();
	
	public XHJSONUtil() {}

	/*
	

	public static void main(String[] args) throws Exception{
		String createJsonString = "", jsonObject = "";
		
		String requestObjString = "", retJsonString = "";

	
		createJsonString = createJsonRequestString("totalAmount", "0.01");
		createJsonString = createJsonRequestString("currencyCode", "INR");			
		createJsonString = createJsonRequestString("merchantGuid", "e300efeb-4063-460d-a704-a8bb55e11238");
		createJsonString = createJsonRequestString("merchantOrderId", "424");
		createJsonString = createJsonRequestString("industryType", "Retail");
		createJsonString = createJsonRequestString("posId", "123");
		createJsonString = createJsonRequestString("comment", "Hi");

				
		ClearJsonObjString("clear");
		
		createJsonString = createJsonRequestObject("request", createJsonString);	
		createJsonString = createJsonRequestString("metadata", "Testing Data");
		createJsonString = createJsonRequestString("platformName", "PayTM");
		createJsonString = createJsonRequestString("ipAddress", "127.0.0.1");
		createJsonString = createJsonRequestString("operationType", "WITHDRAW_MONEY");
		createJsonString = createJsonRequestString("channel", "POS");
		createJsonString = createJsonRequestString("version", "1");
		
		System.out.println("createJsonString ::: "+createJsonString);			
		
		requestObjString = getJsonChild(createJsonString, "request");
		
		System.out.println("requestObjString ::: "+requestObjString);		
		
	}

	Response Message
	{  
	   "type":null,
	   "requestGuid":null,
	   "orderId":"427",
	   "status":"SUCCESS",
	   "statusCode":"SUCCESS",
	   "statusMessage":"SUCCESS",
	   "response":{  
		  "userGuid":"413202568",
		  "pgTxnId":null,
		  "timestamp":1495794975785,
		  "cashBackStatus":null,
		  "cashBackMessage":null,
		  "state":null,
		  "heading":"",
		  "walletSysTransactionId":null,
		  "walletSystemTxnId":"10770471490",
		  "comment":"hi",
		  "posId":"123",
		  "txnAmount":0.01,
		  "merchantOrderId":"427",
		  "uniqueReferenceLabel":null,
		  "uniqueReferenceValue":null,
		  "pccCode":"508588"
	   },
	   "metadata":null
	}

	*/	
	
	
	public static String createJsonRequestString(String keyString, String keyValue){
		String jsonString = ""; 	
		
		jsonObjString.put(keyString, keyValue);		
		jsonString = jsonObjString.toJSONString();			
		return jsonString;
	}
		
	public static String createJsonRequestObject(String keyString, String keyValue){
		String jsonString = ""; 	
		
		JSONParser parser = new JSONParser();
		
		JSONObject jsonObject = null;		
		
        try {
        	
            Object obj = parser.parse(keyValue);

            jsonObject = (JSONObject) obj;                       

        } catch (ParseException e) {
            jsonString = "Error in createJsonRequestObject keyString : "+ keyString +" : keyValue : "+ keyValue +" - "+e.getMessage();
			return jsonString;
        }		

        jsonObjString.put(keyString, jsonObject);		
		jsonString = jsonObjString.toJSONString();	
		return jsonString;
	}	
	
	public static String createJsonObject(String keyString, String keyValue){
		String jsonString = ""; 	
		
		JSONObject jsonObjReq = new JSONObject();
		
		JSONParser parser = new JSONParser();
		
		JSONObject jsonObject = null;		
		
        try {        	
            Object obj = parser.parse(keyValue);

            jsonObject = (JSONObject) obj;                       

        } catch (ParseException e) {
        	jsonString = "Error in createJsonObject keyString : "+ keyString +" : keyValue : "+ keyValue +" - "+e.getMessage();
			return jsonString;
        }		

        jsonObjReq.put(keyString, jsonObject);		
		jsonString = jsonObjReq.toJSONString();	
		return jsonString;
	}
	
	public static String ClearJsonObjString(String value){
		jsonObjString = new JSONObject();  
		return value;
	}
	
	public static String getJsonChild(String jsonObj, String key){
		
		JSONParser parser = new JSONParser();
		
		String jsonString = ""; 
		
		Object obj = null, obj1 = null;

        try {
        	
            obj = parser.parse(jsonObj);
            JSONObject jsonObject = (JSONObject) obj;
            
            obj1 = jsonObject.get(key);
            JSONObject jsonObjectRequest = (JSONObject) obj1;
            
            jsonString = jsonObjectRequest.toJSONString();       


        } catch (ParseException e) {
        	jsonString = "Error in getJsonChild jsonObj : "+ jsonObj +" : Key : "+ key +" - "+e.getMessage();
			return jsonString;
        }		
	
		return jsonString;
	}
	
	public static String getJsonRequestString(String jsonObj, String key){
		
		JSONParser parser = new JSONParser();
		
		String jsonString = ""; 
		
		Object obj = null, obj1 = null;

        try {
        	
            obj = parser.parse(jsonObj);
			
            JSONObject jsonObject = (JSONObject) obj;        
			
            jsonString =  jsonObject.get(key) == null ? "" : (String) jsonObject.get(key).toString();       

        } catch (ParseException e) {
        	jsonString = "Error in getJsonRequestString jsonObj : "+ jsonObj +" : Key : "+ key +" - "+e.getMessage();
			return jsonString;
        }		
	
		return jsonString;
	}

	public static String createJsonObject(String message){
		String jsonString = ""; 	
		
		JSONParser parser = new JSONParser();
		
		JSONObject jsonObject = null;		
		
        try {        	
            Object obj = parser.parse(message);

            jsonObject = (JSONObject) obj;                       

        } catch (ParseException e) {
        	jsonString = "Error in createJsonObject message : "+ message +" - "+e.getMessage();
			return jsonString;
        }		

		jsonString = jsonObject.toJSONString();	
		return jsonString;
	}

	public static String getJsonArrayObjString(String jsonObj, String arrayObj, String key){
		
		JSONParser parser = new JSONParser();

		JSONArray array = null;
		
		String jsonString = ""; 
		
		Object obj = null, obj1 = null;

        try {
        	
            obj = parser.parse(jsonObj);
            JSONObject jsonObject = (JSONObject) obj;    
			
			array = (JSONArray)jsonObject.get(arrayObj);

			for (int i = 0; i < array.size(); i++) 
			{

				JSONObject jsonObjectRow = (JSONObject) array.get(i);
				jsonString = (String) jsonObjectRow.get(key).toString();
			}            

        } catch (ParseException e) {
        	jsonString = "Error in getJsonArrayObjString jsonObj : "+ jsonObj +" : arrayObj : "+ arrayObj +" : key : "+ key +" - "+e.getMessage();
			return jsonString;
        }		
	
		return jsonString;
	}

	public static String getJsonArrayObjString(String jsonObj, String keyStr){
		
		JSONParser parser = new JSONParser();

		JSONArray array = null;
		
		String jsonString = "", key = ""; 
		
		Object obj = null, obj1 = null;

        try {
        	
            obj = parser.parse(jsonObj);
            JSONObject jsonObject = (JSONObject) obj;  
			
			for(Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
				key = (String) iterator.next();
			}
			
			array = (JSONArray)jsonObject.get(key);

			for (int i = 0; i < array.size(); i++) 
			{

				JSONObject jsonObjectRow = (JSONObject) array.get(i);
				jsonString = (String) jsonObjectRow.get(keyStr);
			}            

        } catch (ParseException e) {
        	jsonString = "Error in getJsonArrayObjString jsonObj : "+ jsonObj +" : arrayObj : "+ key +" : keystr : "+ keyStr +" - "+e.getMessage();
			return jsonString;
        }		
	
		return jsonString;
	}

}

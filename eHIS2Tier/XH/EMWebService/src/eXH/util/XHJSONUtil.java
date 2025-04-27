package eXH.util;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class XHJSONUtil {
	
	static JSONObject jsonObjString = new JSONObject();
	static JSONObject jsonObjMain = new JSONObject();
	
	public XHJSONUtil() {}

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

        } catch (Exception e) {
            jsonString = " Error in createJsonRequestObject keyString : "+ keyString +" : keyValue : "+ keyValue +" - "+e.getMessage();
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

        } catch (Exception e) {
        	jsonString = " Error in createJsonObject keyString : "+ keyString +" : keyValue : "+ keyValue +" - "+e.getMessage();
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


        } catch (Exception e) {
        	jsonString = " Error in getJsonChild jsonObj : "+ jsonObj +" : Key : "+ key +" - "+e.getMessage();
			return jsonString;
        }		
	
		return jsonString;
	}
	
	public static String getJsonRequestString(String jsonObj, String key){		
		
		JSONParser parser = new JSONParser();
		
		String jsonString = ""; 
		
		Object obj = null;

        try {
        	
            obj = parser.parse(jsonObj);
            
            JSONObject jsonObject = (JSONObject) obj;        
            jsonString =  jsonObject.get(key) == null ? "" : (String) jsonObject.get(key).toString();
            

        } catch (Exception e) {
        	jsonString = " Error in getting the Key - "+ key +" Exception - "+e.getMessage();
        }		
	
		return jsonString;
	}
	
	public static boolean getJsonRequestString(String jsonObj, String key, String type){		
		
		JSONParser parser = new JSONParser();
		
		boolean jsonString = false; 
		
		Object obj = null;

        try {
        	
            obj = parser.parse(jsonObj);
            
            JSONObject jsonObject = (JSONObject) obj;        
            jsonString =  jsonObject.get(key) == null ? false : (Boolean) jsonObject.get(key);
            

        } catch (Exception e) {
        	jsonString = false;
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
            
    		jsonString = jsonObject.toJSONString();

        } catch (Exception e) {
        	jsonString = " Error in Parsing the input message - "+e.getMessage();
        }		
		return jsonString;
	}

	public static String getJsonArrayObjString(String jsonObj, String arrayObj, String key){
		
		JSONParser parser = new JSONParser();

		JSONArray array = null;
		
		String jsonString = ""; 	
		
		Object obj = null;

        try {
        	
            obj = parser.parse(jsonObj);
            JSONObject jsonObject = (JSONObject) obj;    
			
			array = (JSONArray)jsonObject.get(arrayObj);

			for (int i = 0; i < array.size(); i++) 
			{
				JSONObject jsonObjectRow = (JSONObject) array.get(i);
				jsonString = (String) jsonObjectRow.get(key).toString();			   
			}            

        } catch (Exception e) {
        	jsonString = " Error in getJsonArrayObjString jsonObj : "+ jsonObj +" : arrayObj : "+ arrayObj +" : key : "+ key +" - "+e.getMessage();
			return jsonString;
        }		
	
		return jsonString;
	}

	public static String getJsonArrayObjString(String jsonObj, String keyStr){
		
		JSONParser parser = new JSONParser();

		JSONArray array = null;
		
		String jsonString = "", key = ""; 
		
		Object obj = null;

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

        } catch (Exception e) {
        	jsonString = " Error in getJsonArrayObjString jsonObj : "+ jsonObj +" : arrayObj : "+ key +" : keystr : "+ keyStr +" - "+e.getMessage();
			return jsonString;
        }		
	
		return jsonString;
	}

}

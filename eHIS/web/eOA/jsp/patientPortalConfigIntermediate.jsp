
<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eDS.Common.JSONObject,eDS.Common.JSONArray" contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);
	JSONObject json = new JSONObject();
try{
	String locale					= (String)session.getAttribute("LOCALE");
	String facility_id				= (String) session.getValue( "facility_id" ) ;
	String action					= request.getParameter("action")==null?"":request.getParameter("action");
	String specialityCode			= request.getParameter("specialityCode")==null?"":request.getParameter("specialityCode");
	String pratitionerListsJsonArr	= "";
	String daysOfWeekJsonArr		= "";
	String availablePratitionerListsJsonArr		= "";
	String breakTimeListJsonArr		= "";
	int srlNo;
	int breakCnt					= 0;

	if(action.equals("getPratitionerList") && !specialityCode.equals("")){




		/*Displaying availble practioner list Start*/
		pratitionerListsJsonArr				= eOA.PatientPortalBean.getPratitionerList(conn,specialityCode,locale,facility_id);	
		JSONObject pratitionerListsObj		= new JSONObject(pratitionerListsJsonArr);
		JSONArray pratitionerListArray 		= pratitionerListsObj.getJSONArray("PratitionerList");
		int rowCnt							= pratitionerListsObj.getInt("PratitionerListCnt");
		/*Displaying availble practioner list Start*/

		/*Displaying Days list Start*/
		daysOfWeekJsonArr					= eOA.PatientPortalBean.getDaysOfWeek(conn);	
		JSONObject daysOfWeekObj			= new JSONObject(daysOfWeekJsonArr);
		JSONArray daysOfWeekArray 			= daysOfWeekObj.getJSONArray("daysList");
		/*Displaying Days list End*/

		/*Displaying Stored Practioner list Start*/
		availablePratitionerListsJsonArr				= eOA.PatientPortalBean.getAvailablePratitionerList(conn,specialityCode,locale,facility_id);	
		JSONObject availablePratitionerListsObj			= new JSONObject(availablePratitionerListsJsonArr);
		JSONArray availablePratitionerListArray 		= availablePratitionerListsObj.getJSONArray("AvailablePratitionerList");
		int  availableRowCnt							= availablePratitionerListsObj.getInt("AvailablePratitionerListCnt");
		String eff_status								= availablePratitionerListsObj.getString("eff_status");

	
		if(rowCnt > 0){

			String[] arrayClinciCode = new String[pratitionerListArray.length()];
			for(int i = 0 ; i < pratitionerListArray.length() ; i++){
				arrayClinciCode[i]		= pratitionerListArray.getJSONObject(i).getString("clinic_code");
			}

			Set<String> set = new HashSet<String>();
			String clinioc_codes	= "";
			Collections.addAll(set, arrayClinciCode);
			for (String c_code : set) {
				clinioc_codes	+= "'"+c_code+"',";
			}
			clinioc_codes = clinioc_codes.substring(0, clinioc_codes.length()-1);
			breakTimeListJsonArr				= eOA.PatientPortalBean.getBreakTiming(conn,clinioc_codes,locale,facility_id);	
			JSONObject breakTimeListsObj		= new JSONObject(breakTimeListJsonArr);
			JSONArray breakTimeListtArray 		= breakTimeListsObj.getJSONArray("BreakTimeList");
			breakCnt							= breakTimeListsObj.getInt("BreakTimeCount");

			if(breakCnt > 0){

				
				json.put("breakTimeLists", breakTimeListtArray.toString());
			}else{
				json.put("breakTimeLists", "");
			}
		}
		/*Displaying Stored Practioner list End*/
		if(rowCnt > 0){
			json.put("PratitionerList", pratitionerListArray.toString());
		}else{
			json.put("PratitionerList", "");
		}

		if(availableRowCnt > 0){
			json.put("StoredPratitionerList", availablePratitionerListArray.toString());
		}else{
			json.put("StoredPratitionerList", "");
		}

		

		json.put("rowCnt", rowCnt);
		json.put("availableRowCnt", availableRowCnt);
		json.put("eff_status", eff_status);
		json.put("breakTimeListCnt", breakCnt);
		json.put("daysList", daysOfWeekArray.toString());
		json.put("error","");
		out.print(json);

	}
	
}catch(Exception e) { 
	json.put("error", e);
	//out.print(json);
	e.printStackTrace();
}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
}                           
%>          
            
            

<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eCommon.Common.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj" scope="page" class="webbeans.eCommon.XMLStringParser"/> 
<%
	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);

try{
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String action = (String) hash.get("action")==null?"":(String) hash.get("action");
	
	 /*Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
	if(action.equals("getClaimantType")){

		String function_id = (String) hash.get("function_id");
		JSONArray ClaimantTypeJsonArr = new JSONArray();
		ClaimantTypeJsonArr = eMO.MOCommonBean.getClaimantType(conn,function_id);
		String ClaimantCodeDesc = "";
		
		for(int i = 0 ; i < ClaimantTypeJsonArr.size() ; i++) 
		{
		JSONObject json	= (JSONObject)ClaimantTypeJsonArr.get(i);
		String claimant_type_mstr_code = (String) json.get("claimant_type_mstr_code");
		String claimant_short_desc = (String) json.get("short_desc");
		
		if(ClaimantCodeDesc != ""){
				ClaimantCodeDesc = ClaimantCodeDesc+"##"+claimant_type_mstr_code+"~~"+claimant_short_desc;
			}else{
				ClaimantCodeDesc = claimant_type_mstr_code+"~~"+claimant_short_desc;
			}
		}
		
		out.println(ClaimantCodeDesc);
	} 
	//Added by Ashwin K for ML-MMOH-CRF-1891
	else if (action.equals("getMORegState")){ 
		String facilityId	= (String) hash.get("facilityId");
		String patient_id	= (String) hash.get("patient_id");
		
		String finalize_yn		= eMO.MOCommonBean.getMORegState(conn,facilityId,patient_id);	
		out.println("<finalize_yn>"+finalize_yn+"</finalize_yn>");
		
	} 
	//Ended by Ashwin K for ML-MMOH-CRF-1891
	
}catch(Exception e) { 
	e.printStackTrace();
	
}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
}                           
%>          
            
            

<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eCommon.Common.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %> 
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>


<%

Connection conn=null;
	conn=ConnectionManager.getConnection(request);
	
	
try{
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String action			=	(String) hash.get("action")==null?"":(String) hash.get("action");
	String facilityID				= (String)session.getAttribute("facility_id");
	String locale           = (String) session.getAttribute("LOCALE");
    
		
		if(action.equals("getBrowserType")) 
		{   
            String quicklink_ref	= (String) hash.get("quicklink_ref");
            String quicklink_type	= (String) hash.get("quicklink_type");
			JSONObject browserCheckJson	= new JSONObject();
			browserCheckJson = CommonBean.getBrowserCheck(conn,quicklink_ref);
			String browserCheck	= (String)browserCheckJson.get("browserCheck");
		    out.println(browserCheck);
			
		}	
		
	}
	catch(Exception e) { 
	e.printStackTrace();

}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
}                           
%>          


<!DOCTYPE html>
<%@page import="webbeans.eCommon.XMLStringParser"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
XMLStringParser parser = new XMLStringParser();
Hashtable hash = (Hashtable)parser.parseXMLString( request ) ;
hash = (Hashtable)hash.get("SEARCH") ;

String locale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	locale = (String)session.getAttribute("LOCALE");
else 
	locale = "en";
String responsibilityId = "";
responsibilityId = (String) hash.get("resp_ID")==null?"":(String) hash.get("resp_ID") ;
//final String MENUID = "CA";
//final String EFFSTATUS = "E";
//String query = "SELECT DISTINCT (COUNT (A.MENU_ID)) REC_COUNT FROM SM_RESP A, SM_MENU_HDR B, SM_MENU_DTL C WHERE A.MENU_ID = '"+MENUID+"' AND A.RESP_ID = '"+responsibilityId +"' AND A.EFF_STATUS = '"+EFFSTATUS+"'  AND NVL (A.EFF_DATE_TO, SYSDATE) >= SYSDATE  AND A.MENU_ID = B.MENU_ID  AND B.MENU_ID = C.MENU_ID  ORDER BY 1";
//String checkCAFuncAccess = "select count(*) from sm_menu_dtl where function_id='CLINICIAN_ACCESS' and menu_id not in (select menu_id from sm_menu_rstrn_resp where EXCL_RESTRICT_IND in ('R','E')) connect by menu_id = prior submenu_id start with menu_id in (select menu_id from sm_resp_lang_vw where resp_id='"+responsibilityId+"' and language_id = '"+locale+"')";
String checkCAFuncAccess = "select count(*) from sm_menu_dtl where function_id='CLINICIAN_ACCESS' connect by menu_id = prior submenu_id start with menu_id in (select menu_id from sm_resp_lang_vw where resp_id='"+responsibilityId+"' and language_id = '"+locale+"')";
ResultSet rs = null;
Statement stmt = null;
Connection conn = null;

int recordCount = 0;

try{ 
	conn = ConnectionManager.getConnection(request);
}catch(Exception ex){
	out.write(recordCount);
	return;
}

if(conn == null){
	out.write(recordCount);
	return;
}

try{
	
	stmt = conn.createStatement();	
	rs = stmt.executeQuery(checkCAFuncAccess);
	if(rs != null){
		Object countObj = null;
		while(rs.next()){
			countObj = rs.getObject(1);
		}
		if(countObj instanceof Number){
			recordCount = ((Number)countObj).intValue();
			out.write(""+recordCount);
		}
	}
	
	out.write(""+recordCount);
}catch(Exception ex){
	out.write(recordCount);
	return;
}finally{
	if(rs != null){
		try{
			rs.close();	
		}catch(Exception ex){
			// cannot do any thing
		}
	}
	if(stmt != null){
		try{
			stmt.close();	
		}catch(Exception ex){
			// cannot do any thing
		}
	}
	ConnectionManager.returnConnection(conn, request);
}

%>

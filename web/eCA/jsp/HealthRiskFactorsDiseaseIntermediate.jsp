<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
request.setCharacterEncoding("UTF-8");

Connection con=null;
PreparedStatement pstmt=null;
ResultSet rSet=null;

String sql			= "";
String module_id	= "";
String sub_code 	= "";
String sub_code1 	= "";
String mode 		= "";
String locale 		= "";
try {
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	locale 	= (String) p.getProperty("LOCALE");
		
	con =	ConnectionManager.getConnection(request);
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	
	String termSetID = (String)hash.get("termSetID");
	String termSetCode = (String)hash.get("diagProbCode");
	String risk_fact_id, risk_fact_desc, fact_mand_yn, risk_grp_type = "";
	
	
	sql = "select RISK_FACTOR, FACTOR_MAND_YN,RISK_GRP_TYPE risk_group_type ,case when RISK_GRP_TYPE = 'G' then  (select RISK_FACTOR_DESC from CA_GROUP_RISK_FACTOR_TYPE where  RISK_FACTOR_GROUP = RISK_FACTOR) when RISK_GRP_TYPE = 'I' then (select RISK_FACTOR_DESC from CA_RISK_FACTOR_TYPE where  RISK_FACTOR_TYPE = RISK_FACTOR) END risk_factor_desc from CA_DIAG_RISK_FACTOR  where TERM_SET_ID = ? and TERM_SET_CODE = ? order by risk_group_type asc";
	
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, termSetID);
	pstmt.setString(2,termSetCode);
	
	rSet	= pstmt.executeQuery() ;
	
	while(rSet.next()){	
		int rSize = rSet.getRow();  
		risk_fact_id = rSet.getString("RISK_FACTOR")==null?"":rSet.getString("RISK_FACTOR");
		risk_fact_desc = rSet.getString("risk_factor_desc")==null?"":rSet.getString("risk_factor_desc");
		fact_mand_yn = rSet.getString("FACTOR_MAND_YN")==null?"":rSet.getString("FACTOR_MAND_YN");
		risk_grp_type = rSet.getString("risk_group_type")==null?"":rSet.getString("risk_group_type");
		out.println( "setRiskFactorCodesForDisease(\""+risk_fact_id+"\",\""+risk_fact_desc+"\",\""+fact_mand_yn+"\",\""+risk_grp_type+"\",\""+rSize+"\");");
	}	
			
	
}catch(Exception e){
	e.printStackTrace() ;
}finally{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
} 

%>


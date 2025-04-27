
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             	100            		?           created	
29/08/2013		IN042884			Ramesh G    A Validations on Doctor Consultation should not start if there are Unbilled and unsettled for the current encounter.							
---------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
request.setCharacterEncoding("UTF-8");

Connection con = null;
CallableStatement billingCS = null;

try {

	con =	ConnectionManager.getConnection(request);
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	
	String facility_id = hash.get("facility_id")==null?"":(String)hash.get("facility_id");
	String p_patient_id = hash.get("p_patient_id")==null?"":(String)hash.get("p_patient_id");
	String p_episode_type = hash.get("p_episode_type")==null?"":(String)hash.get("p_episode_type");
	int p_episode_id		= Integer.parseInt(hash.get("p_episode_id")==null?"":(String)hash.get("p_episode_id"));
	int p_visit_id			= Integer.parseInt(hash.get("p_visit_id")==null?"":(String)hash.get("p_visit_id"));
	
	
		String billingSql =  "{call blcommonproc.get_unbilled_unsettled_amt(?,?,?,?,?,?,?)}";
		billingCS = con.prepareCall(billingSql);
		billingCS.setString(1, facility_id);
		billingCS.setString(2, p_patient_id);
		billingCS.setString(3, p_episode_type);
		billingCS.setInt(4, p_episode_id);
		billingCS.setInt(5, p_visit_id);
		billingCS.registerOutParameter( 6,java.sql.Types.INTEGER);
		billingCS.registerOutParameter( 7,java.sql.Types.INTEGER);
		 try{
				billingCS.execute();
				int p_unbilled_amt 	= billingCS.getInt(6);
				int p_unsettled_amt	= billingCS.getInt(7);
				out.println(p_unbilled_amt+"|"+p_unsettled_amt);
			} catch(Exception e1) {
				e1.printStackTrace();
			} finally{billingCS.close();}
}catch(Exception e){
	e.printStackTrace() ;
}finally{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
} 

%>

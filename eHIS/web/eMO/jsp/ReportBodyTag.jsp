<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
    request.setCharacterEncoding("UTF-8");
	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get("SEARCH") ;
	String facility_id = (String)hash.get("facility_id");
	String registration_no = (String)hash.get("registration_no");
	String report_id = "MOBLABEL";
	ecis.utils.OnlineReports onlineReports = new ecis.utils.OnlineReports();
	ecis.utils.OnlineReport report1 = new ecis.utils.OnlineReport(facility_id,"MO",report_id);
	report1.addParameter("P_FM_REGISTRATION_NO",registration_no);
	report1.addParameter("P_TO_REGISTRATION_NO",registration_no);
	report1.addParameter("p_facility_id",facility_id);
	onlineReports.add(report1);
	onlineReports.execute(request,response);
    hash.clear();	
%>

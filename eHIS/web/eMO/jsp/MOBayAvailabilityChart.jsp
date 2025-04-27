<!DOCTYPE html>
<%@ page import= "java.net.*,webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%        Connection con=null;
	      java.sql.Statement aestmt=null;
		  ResultSet aerset=null;
		  String oper_stn_id		="";
		  String area_code			="";
		  String bed_no				="";
		  String priority_zone		="";
		  String patient_id			="";
		  String where_condition	="";
		  String bed_classification ="";
		  String bed_status			="";
		  String select_check		="";
		  String  oper_stn			="";
		  String disable            ="";
		  
	try{
      	  request.setCharacterEncoding("UTF-8");
 	      String fid	= checkForNull((String)session.getValue("facility_id"));
		  String loginUser	= checkForNull((String)session.getValue("login_user"));
		  con=ConnectionManager.getConnection(request);
		  String aesql="select oper_stn_id from am_user_for_oper_stn where appl_user_id='"+loginUser+"' and facility_id='"+fid+"' ";
	      aestmt=con.createStatement();
		  aerset=aestmt.executeQuery(aesql);
		  if(aerset.next())
			oper_stn_id=checkForNull(aerset.getString(1));
		  if(aerset!=null)aerset.close();
		 if(aestmt!=null)aestmt.close();
			 
       
%>
<head>
<%
		
		 area_code			= checkForNull(request.getParameter("area_code"));
		 bed_no				= checkForNull(request.getParameter("bed_no"));
		 priority_zone		= checkForNull(request.getParameter("priority_zone"));
		 patient_id			= checkForNull(request.getParameter("patient_id"));
		 where_condition	= checkForNull(request.getParameter("where_condition"));
		 bed_classification	= checkForNull(request.getParameter("bed_classification"));
		 bed_status			= checkForNull(request.getParameter("bed_status"));
		 select_check		= checkForNull(request.getParameter("select_check"));
		 oper_stn			= checkForNull(request.getParameter("oper_stn_id"));
		 disable			= checkForNull(request.getParameter("disable"));
 
		if(oper_stn.equals(""))
		      oper_stn=oper_stn_id;
		     if(aerset!=null)aerset.close();
			 if(aestmt!=null)aestmt.close();
		 }catch(Exception e){
			 out.println("Exception in File MOBayAvailabilityChart.jsp"+e.toString());
	   }
	   finally{
			
			 ConnectionManager.returnConnection(con,request);
        }
	    
	
	%>
	<title><fmt:message key="eMO.BayTableAvailChart.label" bundle="${mo_labels}"/></title>
	<iframe name='processBar' id='processBar' frameborder=0  noresize  scrolling='no' style='height:5vh;width:99vw'></iframe>
	<iframe name='criteria0' id='criteria0' src='../../eMO/jsp/MOBayAvailabilityChartCriteria0.jsp?area_code=<%=java.net.URLEncoder.encode(area_code)%>&bed_no=<%=java.net.URLEncoder.encode(bed_no)%>&priority_zone=<%=java.net.URLEncoder.encode(priority_zone)%>&patient_id=<%=java.net.URLEncoder.encode(patient_id)%>&where_condition=<%=java.net.URLEncoder.encode(where_condition)%>&bed_classification=<%=java.net.URLEncoder.encode(bed_classification)%>&bed_status=<%=java.net.URLEncoder.encode(bed_status)%>&oper_stn_id=<%=java.net.URLEncoder.encode(oper_stn)%>&select_check=<%=java.net.URLEncoder.encode(select_check)%>&disable=<%=java.net.URLEncoder.encode(disable)%>'  frameborder=0 scrolling='no' frameborder=0 style='height:13vh;width:99vw'></iframe>
	<iframe name='result1' id='result1' src='../../eCommon/html/blank.html' frameborder=0  scrolling='auto' style='height:100vh;width:100vw'></iframe>
	<iframe name='status' id='status' src='../../eMO/jsp/MOCheckBoxStatus.jsp' frameborder=0 noresize scrolling='no' style='height:8vh;width:99vw'></iframe>
	<!-- <iframe name='dummy_frame' id='dummy_frame' src='../../eCommon/jsp/error.jsp&err_num=' frameborder=0  scrolling='auto' style='height:0vh;width:99vw'></iframe>-->
    <iframe name='dummy_frame' id='dummy_frame' src='../../eCommon/jsp/error.jsp?err_num=' frameborder=0  scrolling='auto' style='height:0vh;width:99vw'></iframe>
    
</html>

<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>


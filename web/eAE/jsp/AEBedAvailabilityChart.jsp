<!DOCTYPE html>
<html>
<%@ page import= "java.net.*,webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%    
		  request.setCharacterEncoding("UTF-8");
          Connection con=null;
          PreparedStatement pstmt			= null;
		  ResultSet aerset					=null;
		  //String oper_stn_id="";
		  String fid	= checkForNull((String)session.getValue("facility_id"));
		  String loginUser	= checkForNull((String)session.getValue("login_user"));
		  String oper_stn=checkForNull(request.getParameter("oper_stn_id"));

      if(oper_stn.equals("")) // Thursday, May 27, 2010 PE_EXE
		{
		try{ 
	         		 
		  con=ConnectionManager.getConnection(request);

		 // StringBuffer aesql = new StringBuffer();
		  pstmt = con.prepareStatement("select oper_stn_id from am_user_for_oper_stn where appl_user_id= ? and facility_id=  ? ");
		  pstmt.setString(1, loginUser);
		  pstmt.setString(2, fid);

		  aerset = pstmt.executeQuery();
		  if(aerset.next())
			oper_stn=aerset.getString(1);

		  if(aerset!=null)aerset.close();
		  if(pstmt!=null)pstmt.close();

       }catch(Exception e1){
	   }
	   finally{
			 
			 ConnectionManager.returnConnection(con,request);
        }
	} 
%>
<head>
<%
		String call_function		= checkForNull(request.getParameter("call_function"));
		String clinic_code			= checkForNull(request.getParameter("clinic_code"));
		String treatment_area		= checkForNull(request.getParameter("treatment_area"));
		String bed_no				= checkForNull(request.getParameter("bed_no"));
		String priority_zone		= checkForNull(request.getParameter("priority_zone"));
		String patient_id			= checkForNull(request.getParameter("patient_id"));
		String age					= checkForNull(request.getParameter("age"));
		String gender				= checkForNull(request.getParameter("gender"));
		String where_condition		= checkForNull(request.getParameter("where_condition"));
		String bed_classification	= checkForNull(request.getParameter("bed_classification"));
		String bed_status			= checkForNull(request.getParameter("bed_status"));
		String select_check			= checkForNull(request.getParameter("select_check"));
	%>
	<title><fmt:message key="eAE.BedBayAvailabilityChart.label" bundle="${ae_labels}"/></title>
	<iframe name='processBar' id='processBar' frameborder=0  noresize  scrolling='no' style='height:0vh;width:99vw'></iframe>
	<iframe name='criteria0' id='criteria0' src='../../eAE/jsp/AEBedAvailabilityChartCriteria0.jsp?call_function=<%=java.net.URLEncoder.encode(call_function)%>&clinic_code=<%=java.net.URLEncoder.encode(clinic_code)%>&treatment_area=<%=java.net.URLEncoder.encode(treatment_area)%>&bed_no=<%=java.net.URLEncoder.encode(bed_no)%>&priority_zone=<%=java.net.URLEncoder.encode(priority_zone)%>&patient_id=<%=java.net.URLEncoder.encode(patient_id)%>&age=<%=java.net.URLEncoder.encode(age)%>&gender=<%=java.net.URLEncoder.encode(gender)%>&where_condition=<%=java.net.URLEncoder.encode(where_condition)%>&bed_classification=<%=java.net.URLEncoder.encode(bed_classification)%>&bed_status=<%=java.net.URLEncoder.encode(bed_status)%>&oper_stn_id=<%=java.net.URLEncoder.encode(oper_stn)%>&select_check=<%=java.net.URLEncoder.encode(select_check)%>'  frameborder=0 scrolling='no' frameborder=0 style='height:16vh;width:99vw'></iframe>
	<iframe name='result1' id='result1' src='../../eCommon/html/blank.html' frameborder=0  scrolling='auto' style='height:65vh;width:99vw'></iframe>
	<iframe name='status' id='status' src='../../eAE/jsp/AECheckBoxStatus.jsp' frameborder=0 noresize scrolling='no' style='height:10vh;width:99vw'></iframe>
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


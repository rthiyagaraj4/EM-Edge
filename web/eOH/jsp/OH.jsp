<!DOCTYPE html>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%
	String chart_flag = request.getParameter("chart_flag"); // to be passed from the calling place, from CA
	String function_id = request.getParameter("function_id"); // Added by Suma for CRF703 to add message frame for Restorative charting.
	String title = request.getParameter("title");
	if(function_id ==null) function_id="";
	chart_flag=chart_flag==null?"R":chart_flag;
	chart_flag=chart_flag.equals("null")?"R":chart_flag;


	
/*
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	String params=request.getQueryString();
	String facility_id = (String)session.getValue("facility_id");
	String patient_id = request.getParameter("patient_id");
	String chart_flag = request.getParameter("chart_flag"); // to be passed from the calling place, from CA
	

	String chart_name = "";
	chart_flag=chart_flag==null?"R":chart_flag;
	chart_flag=chart_flag.equals("null")?"R":chart_flag;

	if(chart_flag.equals("R")){
		chart_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.RestorativeChart.Label","oh_labels"); 
	}else{
		chart_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.PeriodontalChart.Label","oh_labels"); 
	}
	*/
%>
<!-- <link rel='StyleSheet' href='../../eCommon/html/<%//=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script> -->
<%
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	String facility_id = (String)session.getValue("facility_id");
	String patient_id = request.getParameter("patient_id");

	String currentAgeOfPatient = "";
	String chart_type_for_alert = "";
	String oh_chart_level = "";
	String params = "";
	int patientAge = 0;
	int patientAgeDays = 0;
	int mixed_dentition_to_age_yrs = 0;
	int mixed_dentition_to_age_days = 0;
	
%>
<title><%=title%></title>
<%

	if(chart_flag.equals("R")){
		if(function_id.equals("OTH_LINK"))
		{ %>
		<iframe name="conditionDentalChartToolHeader" id="conditionDentalChartToolHeader" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/OHDentalChartToolHeader.jsp?<%=request.getQueryString()%>" style="height:6%;width:100vw"></iframe><iframe name="mainTabHeaderFrame" id="mainTabHeaderFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:4%;width:100vw"></iframe><iframe name="condTabDentalChartFrame" id="condTabDentalChartFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:100vh;width:100vw"></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize  style='height:5%;width:100vw'></iframe>
		<%}else{%>
		<iframe name="conditionDentalChartToolHeader" id="conditionDentalChartToolHeader" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/OHDentalChartToolHeader.jsp?<%=request.getQueryString()%>" style="height:6%;width:100vw"></iframe><iframe name="mainTabHeaderFrame" id="mainTabHeaderFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:4%;width:100vw"></iframe><iframe name="condTabDentalChartFrame" id="condTabDentalChartFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:100vh;width:100vw"></iframe>
		<%}%>
<%
	}
	else if(chart_flag.equals("P")){
		try{
		con = ConnectionManager.getConnection(request);

		pstmt = con.prepareStatement("SELECT CHART_LEVEL FROM OH_PARAM");
		rs = pstmt.executeQuery();

		while(rs != null && rs.next()){
			oh_chart_level = checkForNull(rs.getString("CHART_LEVEL"));
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		if(oh_chart_level.equals("E")){
			pstmt=con.prepareStatement("SELECT NVL(MIXED_DENTITION_TO_AGE_YRS,0) MIXED_DENTITION_TO_AGE_YRS, NVL(MIXED_DENTITION_TO_AGE_DAYS,0) MIXED_DENTITION_TO_AGE_DAYS,(SELECT MP_CALCULATE_AGE_YMD(DATE_OF_BIRTH,'YD') FROM MP_PATIENT WHERE PATIENT_ID=?) PATIENT_AGE FROM OH_PARAM");
			pstmt.setString(1,patient_id);
		}else{
			pstmt=con.prepareStatement("SELECT NVL(MIXED_DENTITION_TO_AGE_YRS,0) MIXED_DENTITION_TO_AGE_YRS, NVL(MIXED_DENTITION_TO_AGE_DAYS,0) MIXED_DENTITION_TO_AGE_DAYS,(SELECT MP_CALCULATE_AGE_YMD(DATE_OF_BIRTH,'YD') FROM MP_PATIENT WHERE PATIENT_ID=?) PATIENT_AGE FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,facility_id);
		}
		rs = pstmt.executeQuery();	

		while(rs.next()){
			mixed_dentition_to_age_yrs		= Integer.parseInt(rs.getString("MIXED_DENTITION_TO_AGE_YRS"));
			mixed_dentition_to_age_days		= Integer.parseInt(rs.getString("MIXED_DENTITION_TO_AGE_DAYS"));
			currentAgeOfPatient				= rs.getString("PATIENT_AGE");
		}

		// get the age in years.
		int patientAgeAtIndex = currentAgeOfPatient.indexOf("Y");
		if(patientAgeAtIndex == -1)
			patientAge = 0;
		else 
			patientAge = Integer.parseInt(currentAgeOfPatient.substring(0,patientAgeAtIndex));

		if(currentAgeOfPatient.indexOf("D") != -1){
			patientAgeDays = Integer.parseInt(currentAgeOfPatient.substring(currentAgeOfPatient.indexOf("Y")+2,currentAgeOfPatient.indexOf("D")));
		}

		if(patientAge > mixed_dentition_to_age_yrs ){
			chart_type_for_alert = "RA";
		}
		else if(patientAge == mixed_dentition_to_age_yrs ){
			if( patientAgeDays > mixed_dentition_to_age_days){
				chart_type_for_alert = "RA";
			}
			else{
				chart_type_for_alert = "";
			}
		}
		else{
			chart_type_for_alert = "";
		}

		params = request.getQueryString();
		params = params+"&chart_type_for_alert="+chart_type_for_alert+"&oh_chart_level="+oh_chart_level;

	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally {
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) 
				ConnectionManager.returnConnection(con,request);
		   }catch(Exception es){es.printStackTrace();}
	}
%>
		<!-- <frameset rows='6%,4%,*'> -->
		<frameset id="ohframeset" rows='0%,4%,12%,*'> 
			<frame name="perioChartMainDummyFrame" id="perioChartMainDummyFrame" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/PerioChartMain.jsp?<%=params%>">
			<frame name="periochartTabFrame" id="periochartTabFrame" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/PerioChartTabFrame.jsp?<%=params%>">> 
			<frame name="perioChartHeaderFrame" id="perioChartHeaderFrame" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/PerioChartHeader.jsp?<%=params%>">
			<!-- <frame name="periochartTabFrame" id="periochartTabFrame" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/PerioChartTabFrame.jsp?<%//=request.getQueryString()%>">>  -->
			<frame name="perioChartRecordFrame" id="perioChartRecordFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html"> 
		</frameset>
<%
	}
%>
</html>


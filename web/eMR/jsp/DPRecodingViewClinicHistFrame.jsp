<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap" %>
<% String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<% 
//ArrayList encounterLIst=null;
//ArrayList patientLIst=null;
Connection conn = ConnectionManager.getConnection(request);	
PreparedStatement pstmt		= null;
ResultSet rs				= null;

try{ 
	
	request.setCharacterEncoding("UTF-8"); 

	String facilityId		= (String)session.getValue("facility_id");
	//String loginUser		= (String) session.getValue( "login_user" );
	String	Pat_id	=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");
	String	encounter_id	=	(request.getParameter("encounter_id")==null)	?	""	:	request.getParameter("encounter_id");
	
	String pat_name="";
	String pat_gen="";
	String pat_age="";

	String sql2="select patient_name,get_age(DATE_OF_BIRTH) pat_age,decode(SEX,'M','Male','F','Female','U','UnKnown') gender from mp_patient where patient_id='"+Pat_id+"'";

	pstmt = conn.prepareStatement(sql2);
	rs = pstmt.executeQuery();	
		
	while(rs.next()){
		pat_name = rs.getString("patient_name");
		pat_age = rs.getString("pat_age");
		pat_gen = rs.getString("gender");

	}
		
		
	
	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();

	
	

%>

	<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	</head>
	<title><fmt:message key="eMR.ViewClinicalHistory.label" bundle="${mr_labels}"/>-<%=pat_name%>,<%=pat_age%>,<%=pat_gen%></title>
	<form name ='DPRecodingViewClinicHist' method='post'>

	
		<iframe name='PLINE' id='PLINE' src='../../eCommon/jsp/pline.jsp?Facility_Id=<%=facilityId%>&EncounterId=<%=encounter_id%>' noresize  frameborder=0 scrolling='no' style="width: 100vw; height: 9vh;"></iframe>

		<iframe name="FlowSheet" id="FlowSheet" frameborder="no" scrolling="auto" noresize src='../../eCA/jsp/FlowSheet.jsp?&patient_id=<%=Pat_id%>&encounter_id=<%=encounter_id%>&facilityId=<%=facilityId%>' name="criteria_f0"  scrolling="no" frameborder="0" noresize style="width: 99vw; height: 82vh;"></iframe>

		<iframe src="../../eCommon/jsp/error.jsp" name="messageFrame" id="messageFrame"  scrolling="no" frameborder="0" noresize style="width: 100vw; height: 5vh;">	</iframe>


	
	</form>

	</html>
<%
}catch(Exception e){
	//out.println(e.toString());
	e.printStackTrace();
}finally{
	if(conn != null) ConnectionManager.returnConnection(conn,request);

}


	%>


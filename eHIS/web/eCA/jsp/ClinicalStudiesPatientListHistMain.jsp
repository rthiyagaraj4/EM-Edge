<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title>Clinical Studies Patient List<!--<fmt:message key="eCA.PatientRelatedTreatments.label" bundle="${ca_labels}"/>--></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String validate = "N";
	String	facilityId 	= (String) session.getValue( "facility_id" )==null ? "" : (String) session.getValue( "facility_id" ) ;
	String  practitioner_id=(String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");	
	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String validateQuery="select 'Y' ACCESS_RIGHTS from CA_RES_STUDY_ALLOWED where FACILITY_ID=?  AND PRACTITIONER_ID=? AND TO_DATE (NVL(RES_FROM_DATE,SYSDATE), 'dd/mm/yyyy') <= TO_DATE (SYSDATE, 'dd/mm/yyyy') AND TO_DATE (NVL(RES_TO_DATE,SYSDATE), 'dd/mm/yyyy') >= TO_DATE (SYSDATE, 'dd/mm/yyyy')";
	try
	{
		con =  ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(validateQuery);
		pstmt.setString(1,facilityId);
		pstmt.setString(2,practitioner_id);
		rs = pstmt.executeQuery();
		
		if(rs.next()){
		  validate = rs.getString("ACCESS_RIGHTS");
        }
		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}catch(Exception e){		
		//out.println(e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally   
	{
		 if(pstmt!=null)pstmt.close();
		 if(rs!=null)rs.close();
		 if(con!=null)
			 ConnectionManager.returnConnection(con,request);
	}
	
	if("Y".equals(validate)){

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
</head>

<iframe name="ClinicalStudiesPatientListHistCriteriaFrame" id="ClinicalStudiesPatientListHistCriteriaFrame" frameborder="0" scrolling="no"  noresize src="../../eCA/jsp/ClinicalStudiesPatientListHistCriteria.jsp?<%=request.getQueryString()%>" style="height:36vh;width:100vw"></iframe>
	
		<iframe name="ClinicalStudiesPatientListHistResultFrame" id="ClinicalStudiesPatientListHistResultFrame" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:64vh;width:100vw"></iframe>


<% } else{%>
	<script>
		alert("You do not have access for this facility on this date.");
	</script>
<%}%>
</html>


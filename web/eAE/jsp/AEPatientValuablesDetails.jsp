<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<title> <fmt:message key="Common.PatientValuables.label" bundle="${common_labels}"/> </title>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  	<script language='javascript' src='../../eCommon/js/common.js'></script>
    <script language='javascript' src='../../eCommon/js/dchk.js'></script>
    <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language='javascript' src='../../eAE/js/AEAttendance.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body onKeyDown = 'lockKey()'>
<center>
<br>
<table border='0' cellpadding='5' cellspacing='0' width='90%'>
<%

	String	patient_id				=	"";
	String	facilityId			=	"";
	String encounter_id			    =	"";
	String patient_name	="";
	String valuable_details ="";
	String addedID ="";
	String addedDate = "";
	Connection con					=	null;
	PreparedStatement pstmt		=	null;
    ResultSet rset						=	null;

	try
	{
	    request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
        con =  ConnectionManager.getConnection(request);
		patient_id				=	(request.getParameter("Patient_ID")==null)				? "" : request.getParameter("Patient_ID");
		facilityId				=	(request.getParameter("facilityId")==null)				? "" : request.getParameter("facilityId");

		encounter_id				=	(request.getParameter("EncounterId")==null)				? "" : request.getParameter("EncounterId");

        try
		{
            String sqlFacility = "select A.PATIENT_ID,A.ENCOUNTER_ID,B.PATIENT_NAME,A.VALUABLE_DETAILS,A.ADDED_BY_ID, to_char(A.ADDED_DATE,'dd/mm/yyyy hh24:mi') ADD_DATE from PR_PATIENT_VALUABLES A, MP_PATIENT B where A.FACILITY_ID=? and A.PATIENT_ID=? and A.ENCOUNTER_ID=? and A.PATIENT_ID=B.PATIENT_ID";
         		  
		    pstmt = con.prepareStatement(sqlFacility);
            pstmt.setString(1,facilityId);
            pstmt.setString(2,patient_id);
            pstmt.setString(3,encounter_id);

            rset = pstmt.executeQuery();
         
		    if (rset!=null && rset.next())
		    {
				patient_name =rset.getString("PATIENT_NAME");
				valuable_details =rset.getString("VALUABLE_DETAILS");
				addedID =rset.getString("ADDED_BY_ID");
                addedDate =rset.getString("ADD_DATE") ;
            }		
            rset.close();
            pstmt.close();
        }catch(Exception e){}
		if((patient_name==null) || (patient_name.equals("null")) || (patient_name=="") || (patient_name.equals(""))) patient_name	= "";
		if((valuable_details==null) || (valuable_details.equals("null")) ||  (valuable_details=="") || (valuable_details.equals(""))) valuable_details	= "";

		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
    }
%>
   <tr>
		<td class=label width='5%' align='right' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td><td  align='left' class='QueryData'><%=patient_id%></td>
	</tr>
	<tr>
		<td class=label width='5%' align='right' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td><td  align='left' class='QueryData'><%=patient_name%></td>
	</tr>
   <tr>
		<td class=label width='5%' align='right' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td><td  align='left' class='QueryData'><%=encounter_id%></td>
	</tr>
	<tr>
		<td class=label colspan='2'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;<B><%=addedID%></B>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Recorded Date Time&nbsp;&nbsp;<B><%=addedDate%></B></td>
	</tr>
	<tr>
		<td class=label width='5%' align='right' nowrap><fmt:message key="eAE.ValuableDetails.label" bundle="${ae_labels}"/></td><td  align='left' class='QueryData'><%=valuable_details%></td>
	</tr>
</table>
<p>
		<input type='button' class='BUTTON' name='close' id='close' value='Close' onClick='cancelOperation()'>
<br>
</table>

</form>
</center>
</body>
</html>


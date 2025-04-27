<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="RecDiagnosisGetValidation.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
 <head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 <link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css">
 <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>


<script src='../js/RecDiagnosisEOC.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con      = null;
	Statement stmt		= null;
	ResultSet rs		= null;
	PreparedStatement pstmt	= null; 

	String Practitioner_Id	="";	String relationship_id	="";
	String Locn_Code	="";	String Locn_Type	="";
	String Patient_Id	="";	String Encounter_Id	="";
	String currentdate	="";	String facilityId ="";
	String dob = ""; String age = "";
	String sex = ""; 
	int SCount=0;

	String patient_class	=""; String diagnosis_desc	="";
	String diagnosis_code	="";
	String classValue = "";
	
try
{
		con = ConnectionManager.getConnection(request);
		
		Practitioner_Id	 =checkForNull(request.getParameter("Practitioner_Id"));	
		relationship_id	 = checkForNull(request.getParameter("relationship_id"));
		Locn_Code        = checkForNull(request.getParameter("Locn_Code"));			
		Locn_Type        = checkForNull(request.getParameter("Locn_Type"));
		Patient_Id			= checkForNull(request.getParameter("Patient_Id"));
		patient_class		= checkForNull(request.getParameter("patient_class"));
		Encounter_Id		= checkForNull(request.getParameter("Encounter_Id"));
		age					= checkForNull(request.getParameter("Age"));	
		dob					= checkForNull(request.getParameter("Dob"));	
		sex					= checkForNull(request.getParameter("Sex"));	
					
%>
	<form name='RecDaignosisEOC_form' id='RecDaignosisEOC_form'  action='../../servlet/eMR.RecDiagnosisEOCServlet' method='post' target='messageFrame'>
		<br>	
		<table border=0 align='center' cellspacing=0 cellpadding=0 width='100%'>
		<tr><th align='left' colspan='8' style='BACKGROUND-COLOR: #ffc5b5;COLOR:black' ><font='verdana'  size=2><fmt:message key="eMR.EpisodeOfCare.label" bundle="${mr_labels}"/></font></th></tr>
		<tr>
			<td class='label' align='right' width='5%'><!-- Episode ID -->&nbsp;</td>
			<td>
	<%
			String eoc_no="";
			stmt = con.createStatement();
			rs=stmt.executeQuery("select CP_CARE_PLAN_SEQ.nextval eocno from dual");
			if(rs.next())
				eoc_no = rs.getString("eocno");

			if(rs!=null)  rs.close();
			if(stmt!=null)  stmt.close();

	%>
			<input type="hidden" name="episode_id" id="episode_id"  maxlength="2" value='<%=eoc_no%>' size="2" tabIndex='5' >
			</td>
			<td class='label' align='right'><fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;</td>
			<td><input type='textbox' name="eposide_desc" id="eposide_desc"  value='' maxlength="30" size='50'></input>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></td>
	</tr>		
	</table>
	<!-- <br> -->
	<table border=1 align='center' cellspacing=0 cellpadding=0 width='100%'>
		<tr>
		<th align='left' width='55%'><fmt:message key="eMR.SelectDiagnosisProblem.label" bundle="${mr_labels}"/></th>
		<th width='8%'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></th>
		<th width='8%'><fmt:message key="Common.primary.label" bundle="${common_labels}"/>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></th>
		<th width='8%'><fmt:message key="Common.significant.label" bundle="${common_labels}"/></th>
	</tr>
	<%
		StringBuffer sql=new StringBuffer(); 
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append("select a.term_code,B.long_desc term_short_desc ");
		sql.append("from pr_diagnosis a, mr_term_code b,MR_TERM_SET c where a.CURR_ACCURACY_IND='C' and ");
		sql.append("a.term_code=b.term_code and a.term_set_id=b.term_set_id and c.term_set_id=b.term_set_id "); 
		sql.append(" and c.term_set_id=a.term_set_id and  a.CURR_ACCURACY_IND='C' and a.patient_id=? ");

		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,Patient_Id);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			diagnosis_desc = rs.getString("term_short_desc");
			diagnosis_code = rs.getString("term_code");
			
			classValue= ((SCount%2) == 0) ? "QRYEVEN" : "QRYODD";
			
			out.println("<tr>");
			out.println("<td align='left' class='"+classValue+"' width='56%'><font size=1>"+diagnosis_desc+"</font></td>");
			out.println("<td class='"+classValue+"' width='8%'><input type='checkbox' name='include"+SCount+"' id='include"+SCount+"' value='"+diagnosis_code+"' onclick=formvalidate(this);> &nbsp;&nbsp;</td>");
			out.println("<td class='"+classValue+"' width='8%'><input type='checkbox'  name='primary"+SCount+"' id='primary"+SCount+"' value='"+diagnosis_code+"' onclick=formvalidate(this);> &nbsp;&nbsp;</td>");
			out.println("<td class='"+classValue+"' width='8%'><input type='checkbox'  name='significant"+SCount+"' id='significant"+SCount+"' value='"+diagnosis_code+"' onclick=formvalidate(this);> &nbsp;&nbsp;</td>");
			out.println("</tr>");
			
		
			SCount++;
		}
		out.println("<input type='hidden' name='SCount' id='SCount' value='"+SCount+"'>");

		if(rs!=null)   rs.close();
		if(pstmt!=null)  pstmt.close();

	%>
	</table>
<input type="hidden" name = "Practitioner_Id" value ="<%=Practitioner_Id%>">
<input type="hidden" name = "relationship_id" value ="<%=relationship_id%>">
<input type="hidden" name = "Locn_Code" value ="<%=Locn_Code%>">
<input type="hidden" name = "Locn_Type" value ="<%=Locn_Type%>">
<input type="hidden" name = "Patient_Id" value ="<%=Patient_Id%>">
<input type="hidden" name = "Encounter_Id" value ="<%=Encounter_Id%>">
<input type="hidden" name = "currentdate" value ="<%=currentdate%>">
<input type="hidden" name = "dob" value ="<%=dob%>">
<input type="hidden" name = "age" value ="<%=age%>">
<input type="hidden" name = "sex" value ="<%=sex%>">
<input type="hidden" name = "facilityId" value ="<%=facilityId%>">
<input type='hidden' name='patient_class' id='patient_class' value='<%=patient_class%>'>

<input type='hidden' name='primary_yn' id='primary_yn' value=''>
<input type='hidden' name='significant_yn' id='significant_yn' value=''>
<input type='hidden' name='include_yn' id='include_yn' value=''>

</form>
<%
}
catch(Exception ex)
{
		//out.println("Exception at try block "+ex.toString());
		ex.printStackTrace();
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

%>
	</body>
</html>


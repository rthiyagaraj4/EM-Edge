<!DOCTYPE html>
<!--
	Module			:	eMR
	Function			:	MR Queries -> View Death Register
	Developed By 	:	Vinod Babu 
	Created On	 	:	12/05/2005
	Modified On		:	12/05/2005
-->

<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "java.util.*,java.sql.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); 
   String locale = (String)session.getAttribute("LOCALE"); 
   String p_facility_id		= (String) session.getValue( "facility_id" ) ;
   String patient_id= request.getParameter("patient_id");
   String isCalledFromCA = checkForNull(request.getParameter("CA")); 
   String CA = checkForNull(request.getParameter("CA")); 
   String encounter_id= request.getParameter("episode_id");


%>
<html>
<head>
<title><fmt:message key="eMR.DeathDetails.label" bundle="${mr_labels}"/></title>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection con=null;

		String patient_class = "";
		String encid = "";
		String sex = "";
		String practId = "";
		String pract_type = "";
		String specialty_code = "";
		String dob = "";
		String pat_curr_locn_code = "";
		String finalize_yn = "";
		String visit_adm_date = "";
		String call_from = "";

		con = ConnectionManager.getConnection(request);


	try{
		String sql2="select a.encounter_id, a.patient_id,decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, b.sex, a.attend_practitioner_id, a.patient_class, d.pract_type, a.specialty_code,  To_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth, a.pat_curr_locn_code,c.finalize_yn,to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date from PR_ENCOUNTER a, MP_PATIENT b, MR_DEATH_REGISTER_HDR c,  AM_PRACTITIONER d, AM_PRACT_TYPE e where b.patient_id  = a.patient_id  and a.encounter_id = c.encounter_id and a.facility_id = '"+p_facility_id+"' and a.facility_id =c.facility_id and d.practitioner_id = a.attend_practitioner_id and d.pract_type = e.pract_type and a.patient_id='"+patient_id+"' and a.encounter_id='"+encounter_id+"'";
				
		pstmt=con.prepareStatement(sql2);

		rs=pstmt.executeQuery();

		if ( rs != null && rs.next() )
		{
			encid = rs.getString("encounter_id");
			patient_class = rs.getString("patient_class");
			sex = rs.getString("sex");
			practId = rs.getString("attend_practitioner_id");
			pract_type = rs.getString("pract_type");
			specialty_code = rs.getString("specialty_code");
			dob = rs.getString("date_of_birth");
			pat_curr_locn_code = rs.getString("pat_curr_locn_code");
			finalize_yn = rs.getString("finalize_yn");
			visit_adm_date = rs.getString("visit_adm_date");
		
	
	//String patient_id=request.getParameter("patient_id");
	if (patient_id==null) patient_id="";
    	
	call_from=request.getParameter("call_from");
	if (call_from==null) call_from="";

	if  (!CA.equals("Y"))
	{
	%>
		<frameset rows="40%,*,7%,0%" border=0>
	<frame src="../../eMR/jsp/ViewDeathRegisterPatient.jsp?patient_id=<%=patient_id%>&CA=<%=CA%>" name="Header_frameq" scrolling='no' frameborder = '2' noresize>
	<frame src="../../eMR/jsp/ViewDeathRegisterDiag.jsp?call_from=<%=call_from%>&patient_id=<%=patient_id%>" name="DiagDetail_frame"  >

	<%
	} else{

	%>
		<frameset rows="*" border=0>
		<!-- <frame src="../../eMR/jsp/ViewDeathRegisterPatient.jsp?patient_id=<%=patient_id%>&CA=<%=CA%>" name="Header_frameq" scrolling='no' frameborder = '2' noresize> -->

		<frame name='Header_frameq' id='Header_frameq' 				src="../../eMR/jsp/ViewMDRFrames.jsp?CA=<%=isCalledFromCA%>&cause_of_death=Y&modal_yn=Y&Locn_Code=<%=pat_curr_locn_code%>&Sex=<%=sex%>&Dob=<%=dob%>&speciality_code=<%=specialty_code%>&patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&episode_id=<%=encounter_id%>&practitioner_id=<%=practId%>&practitioner_type=<%=pract_type%>&patient_class=<%=patient_class%>&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I&finalize_yn=<%=finalize_yn%>&visit_adm_date=<%=visit_adm_date%>" frameborder=0 scrolling='no'> 

	<frame src="../../eMR/jsp/ViewDeathRegisterDiag.jsp?call_from=<%=call_from%>&patient_id=<%=patient_id%>" name="DiagDetail_frame"  >

	<%
	}
	}
	else
	{

		if (CA.equals("Y"))
		{
			out.println("<script>alert(getMessage('DEATH_REG_NOT_APPL','CA')); document.location.href='../../eCommon/html/blank.html'</script>");
			if (CA.equals("Y"))%>
						<script>
							alert(getMessage('DEATH_REG_NOT_APPL','CA'));
						</script>
					<%
			else

%>
						<script>
							alert(getMessage('DEATH_REG_NOT_APPL','CA'));
						</script>
					<%	
		}
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();


	} catch(Exception e)
	{

	}
	finally { if(con != null) ConnectionManager.returnConnection(con,request); 	}
	%>
	<%
	if  (!CA.equals("Y"))
	{
	%>
	<frame src="../../eMR/jsp/recordDiag.jsp?call_from=<%=call_from%>" name="RecordDiag_frame" scrolling='no' frameborder = '1' noresize>
		<%
	}
	%>
	<frame src="../../eCommon/jsp/error.jsp" name="Dummy_frame" id="Dummy_frame" scrolling='no' noresize>
</frameset>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "&nbsp;" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


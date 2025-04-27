
<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,com.ehis.util.*, webbeans.eCommon.*" %>
<html>
	<head>
		<title>&nbsp;<fmt:message key="eIP.DischargeCheckList.label" bundle="${ip_labels}"/>&nbsp;</title>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
		<script src='../../eIP/js/DischargeCheckList.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

				
	</head>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con		= null;
	ResultSet rs 		= null;
	Statement stmt 		= null;

	try
	{
		con = ConnectionManager.getConnection(request);
		String facilityId		= (String)session.getValue("facility_id");
		String patient_id		= checkForNull(request.getParameter("patientId"));
		String encounter_id		= checkForNull(request.getParameter("encounterId"));
		String call_function	= checkForNull(request.getParameter("menu_id"));
		String disc_from_date	= checkForNull(request.getParameter("disc_from_date"));
		String disc_to_date		= checkForNull(request.getParameter("disc_to_date"));

		if((!disc_from_date.equals(""))&&(disc_from_date!=null))
			disc_from_date = disc_from_date;

		if((!disc_to_date.equals(""))&&(disc_to_date!=null))
			disc_to_date = disc_to_date;


		if(disc_from_date!=null && !disc_from_date.equals("") && disc_to_date!=null && !disc_to_date.equals("") && !call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
		{
				stmt = con.createStatement();
				rs = stmt.executeQuery(" SELECT 1 FROM IP_PATIENT_LAST_ENCOUNTER a, IP_PARAM b WHERE SYSDATE BETWEEN a.DISCHARGE_DATE_TIME AND DECODE(b.DISC_CHKLST_EXP_PER_UNIT,'D', a.DISCHARGE_DATE_TIME + b.DISC_CHKLST_EXP_PERIOD, 'H', a.DISCHARGE_DATE_TIME + b.DISC_CHKLST_EXP_PERIOD/24) AND a.facility_id = '"+facilityId+"' and a.ENCOUNTER_ID = '"+encounter_id+"' and a.facility_id = b.facility_id");
				if(!rs.next())
				{
				 out.println("<script>alert(getMessage('CHECKLIST_PARAM_EXCEEDED','IP'));window.close();</script>");
				}	
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		%>
				<iframe name='pline' id='pline' src="../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter_id%>&Facility_Id=<%=facilityId%>" frameborder=0 scrolling=no style='height:8vh; width:97vw'></iframe>
				
				<iframe name='DischargeCheckList_frame1' id='DischargeCheckList_frame1' src='../../eIP/jsp/DischargeCheckListMain.jsp?encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&call_function=<%=call_function%>' frameborder=0 scrolling='no' noresize style='height:4vh;width:97vw'></iframe>
					
				<iframe name='DischargeCheckList_frame2' id='DischargeCheckList_frame2' src='../../eIP/jsp/DischargeCheckListTab1Frames.jsp?encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&call_function=<%=call_function%>' frameborder=0 noresize style='height:70vh;width:97vw' scrolling='auto'></iframe>
				
				<iframe name='DischargeCheckList_frame3' id='DischargeCheckList_frame3' src='../../eIP/jsp/DischargeCheckListButton.jsp?call_function=<%=call_function%>&disable_print=Disabled' frameborder=0 scrolling='no' noresize style='height:9vh;width:97vw'></iframe>
				
				<iframe name='submitFrame' id='submitFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 scrolling=no noresize style='height:8vh;width:98vw'></iframe>
				
		<%
		}
		else
		{	
			if(call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
			{
			  stmt  = con.createStatement();
			  rs = stmt.executeQuery("select 1 from IP_DISCHARGE_CHECKLIST where facility_id='"+facilityId+"' and encounter_id = '"+encounter_id+"' ");

				if(rs.next())
				{
				}
				else
				{
			       out.println("<script>alert(getMessage('CHECKLIST_NOT_PREPARED','IP'));window.close();</script>");
				}
			}

			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();

			%>
		<iframe name='pline' id='pline' 			src="../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter_id%>&Facility_Id=<%=facilityId%>" frameborder='0' scrolling='no' style='height:8vh;width:97vw'></iframe>
		
		<iframe name='DischargeCheckList_frame1' id='DischargeCheckList_frame1' src='../../eIP/jsp/DischargeCheckListMain.jsp?encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&call_function=<%=call_function%>' frameborder=0 scrolling='no' noresize style='height:4vh;width:97vw'></iframe>
		
		<iframe name='DischargeCheckList_frame2' id='DischargeCheckList_frame2' src='../../eIP/jsp/DischargeCheckListTab1Frames.jsp?encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&call_function=<%=call_function%>' frameborder=0 noresize style='height:70vh;width:97vw' scrolling='auto'></iframe>
		
		<iframe name='DischargeCheckList_frame3' id='DischargeCheckList_frame3' src='../../eIP/jsp/DischargeCheckListButton.jsp?call_function=<%=call_function%>' frameborder=0 scrolling='no' noresize style='height:9vh;width:97vw'></iframe>
	
		<iframe name='submitFrame' id='submitFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 scrolling=no noresize style='height:8vh;width:98vw'></iframe>
		
	<%	}

		if(rs	!= null)    rs.close();
		if(stmt  != null)   stmt.close();	

	}catch(Exception e)
	{
		out.println("Exception in tryCatch : "+ e.toString());
	}	
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
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


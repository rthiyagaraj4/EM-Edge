<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<Script language='javascript' src='../../eMP/js/Form60.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con=null;


	try {
		con						=  ConnectionManager.getConnection(request);
		String reqPatientId		= checkForNull(request.getParameter("patientId"));
		String reqEncounterId	= checkForNull(request.getParameter("encounterId"));
		String reqEncounterType = checkForNull(request.getParameter("encounterType"));
		String isPanCardAvailableYN = checkForNull(request.getParameter("isPanCardAvailableYN"));
		int currentPageNo 	= 1;
		int recordsPerPage 	= 14;

		if(request.getParameter("currentPageNo") != null)
		currentPageNo = Integer.parseInt(request.getParameter("currentPageNo"));
		String loginFacilityId		=	(String)session.getAttribute("facility_id");
		//String locale			= (String) session.getValue( "LOCALE" ) ;


		/*JSONObject openEncounterListJsonObj			= new JSONObject();
		openEncounterListJsonObj					= eMP.MPForm60Bean.getOpenEncounterDetails(con,reqPatientId,reqEncounterId,reqEncounterType);
		
		int openEncounterListCount					= openEncounterListArray.size();*/

		JSONObject jsonObj  =  eMP.MPForm60Bean.getEncounterDetails(con,reqPatientId,reqEncounterId,reqEncounterType,currentPageNo,recordsPerPage,isPanCardAvailableYN,loginFacilityId);

		
		int curPageNo		= 0;
		curPageNo		= (Integer) jsonObj.get("currentPageNo");
			
		int noOfRecords		= 0;
		noOfRecords		= (Integer) jsonObj.get("noOfRecords");
	

		int noOfPages		= 0;
		noOfPages		= (Integer) jsonObj.get("noOfPages");

		int prevPageNo	= curPageNo - 1;		
		int nextPageNo	= curPageNo + 1;
		JSONArray encounterListArray 			= (JSONArray)jsonObj.get("encounterLists");
		int encounterListCount					= encounterListArray.size();
	 %>
		<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name="repForm" id="repForm" method="post" target='dummyform' >
			<%
				if(noOfRecords > 0){
			%>

			<table align='right'>
					<tr>
					<% if ( curPageNo > 1 ){ %>
						<td align ='right' id='prev'><A HREF="../../eMP/jsp/Form60SearchResults.jsp?patientId=<%=reqPatientId%>&encounterId=<%=reqEncounterId%>&encounterType=<%=reqEncounterType%>&isPanCardAvailableYN=<%=isPanCardAvailableYN%>&currentPageNo=<%=prevPageNo%>" text-decoration='none'" ><fmt:message key="Common.previous.label" bundle="${common_labels}" /></A></td>
					<%}
					if ( curPageNo >=1 && curPageNo != noOfPages ){%>
						<td align ='right' id='next'><A HREF="../../eMP/jsp/Form60SearchResults.jsp?patientId=<%=reqPatientId%>&encounterId=<%=reqEncounterId%>&encounterType=<%=reqEncounterType%>&isPanCardAvailableYN=<%=isPanCardAvailableYN%>&currentPageNo=<%=nextPageNo%>" text-decoration='none' "><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
					<%}%>
					</tr>
				</table>
				<br><br>
					<table cellspacing='0' cellpadding='0' align='center' width='100%' border='1' >

						<tr>
							<th width='2%' class="columnheadercenter" nowrap>&nbsp;</th>
							<th width='14%' class="columnheadercenter" align='center' nowrap>
								<fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/>&nbsp;
							</th>
							<th width='14%' class="columnheadercenter" align='center' nowrap>
								<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>&nbsp;
							</th>
							<th width='14%' class="columnheadercenter" align='center' nowrap>
								<fmt:message key="Common.encountertype.label" bundle="${common_labels}"/>&nbsp;
							</th>
							<th width='14%' class="columnheadercenter" align='center' nowrap>
								<fmt:message key="Common.status.label" bundle="${common_labels}"/>&nbsp;
							</th>
							<th width='14%' class="columnheadercenter" align='center' nowrap>
								<fmt:message key="Common.action.label" bundle="${common_labels}"/>&nbsp;
							</th>
						</tr>
						<%
							for(int i = 0 ; i < encounterListCount ; i++) {
								JSONObject encounterList	= (JSONObject)encounterListArray.get(i);
								String visitAdmDateTime			= (String) encounterList.get("visitAdmDateTime");
								String encounterId				= (String) encounterList.get("encounterID");
								String encounterType			= (String) encounterList.get("encounterType");
								String patientId				= (String) encounterList.get("patientId");
								String facilityId				= (String) encounterList.get("facilityId");
								String episodeId				= (String) encounterList.get("episodeId");
								String opEpisodeVisitNum		= (String) encounterList.get("opEpisodeVisitNum");
								String episodeType				= (String) encounterList.get("episodeType");
								String classVal					= "QRYODD";
								String status					= eMP.MPForm60Bean.getForm60StatusForEncounter(con,encounterId);
								String ackNO					= "";
								if(!status.equals("")){
									ackNO					= eMP.MPForm60Bean.getForm60AckNo(con,encounterId);
								}
								String statusStr				= status.equals("F")?"Finalized":(status.equals("D")?"Draft":"Create Form 60");
								
								int row	= i;
								if(row%2==0){
									classVal					= "QRYEVEN";
								}else{
									classVal					= "QRYODD";
								}
															
							%>
								<tr>
								
								<td nowrap class="<%=classVal%>"> <a href="javascript:showModalCurEnc('<%=encounterId%>','<%=patientId%>','<%=encounterType%>')">+</a></td>
									<td nowrap class="<%=classVal%>"> <%=visitAdmDateTime%></td>
									<td nowrap class="<%=classVal%>"> <%=encounterId%></td>
									<td nowrap class="<%=classVal%>"> <%=encounterType%></td>
									<td nowrap class="<%=classVal%>">
									<%if(!status.equals("F")){%>
										<a href="javascript:fnOpenForm60Window('<%=encounterId%>','<%=patientId%>','<%=status%>','<%=facilityId%>','<%=episodeId%>','<%=episodeType%>','<%=opEpisodeVisitNum%>')"> <%=statusStr%></a>
									<%}else{%>
										<a href="javascript:openReport('<%=encounterId%>','<%=patientId%>','<%=facilityId%>','<%=episodeId%>','<%=episodeType%>','<%=opEpisodeVisitNum%>')"> <%=statusStr%></a>
									<%}%>
									</td>
									<td nowrap class="<%=classVal%>"> <%if(!status.equals("")){%><a href="javascript:openReport('<%=encounterId%>','<%=patientId%>','<%=facilityId%>','<%=episodeId%>','<%=episodeType%>','<%=opEpisodeVisitNum%>')"><fmt:message key="Common.print.label" bundle="${common_labels}"/></a>&nbsp;<a href="javascript:fnCancelForm60('<%=facilityId%>','<%=episodeId%>','<%=episodeType%>','<%=opEpisodeVisitNum%>','<%=status%>','<%=encounterId%>','<%=ackNO%>')"> <fmt:message key="Common.cancel.label" bundle="${common_labels}"/></a><%}%>&nbsp;</td>

								</tr>	
						<%
							}
						%>
					</table>
				
			
			<%}else{%>
				<script>
					fnShowNoRecords();
				</script>
			<%}%>

			<input type='hidden' name='encounterId' id='encounterId' value=''>
			<input type='hidden' name='ACKNOWLEDG_NO_FORM60' id='ACKNOWLEDG_NO_FORM60' value=''>
			<input type='hidden' name='operation' id='operation' value=''>
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=  session.getValue( "login_user" ) %>">
			<input type="hidden" name="form60" id="form60" value="">
			<input type='hidden' name='p_encounter_id' id='p_encounter_id' value=''>
			<input type='hidden' name='p_facility_id' id='p_facility_id' value=''>
			<input type='hidden' name='p_patient_id' id='p_patient_id' value=''>
			<input type='hidden' name='p_module_id' id='p_module_id' value='MP'>
			<input type='hidden' name='p_report_id' id='p_report_id' value='MPFORM60'>
			<input type='hidden' name='p_episode_type' id='p_episode_type' value=''>
			<input type='hidden' name='p_episode_id' id='p_episode_id' value=''>
			<input type='hidden' name='p_visit_id' id='p_visit_id' value=''>
	


		</form>
		</body>
	<%
	} catch(Exception e){
		e.printStackTrace();
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


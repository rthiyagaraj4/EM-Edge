<!DOCTYPE html>
<%
/* 
-------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        	Rev.Date		Rev.Name	Description
-------------------------------------------------------------------------------------------------
26/10/2017		IN061892			Prakash C		31/10/2017		Ramesh G	ML-MMOH-CRF-0544
-------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.Common.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<% 
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eCA/js/CentralizedDB.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
</head>

<body onscroll='processScroll()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="Encounter_result" id="Encounter_result"  action='OpenChartWrapper.jsp' method="post" target="messageFrame"> 
	<%
		Connection con 		= null;
		int count=0;
		
		String bean_id = "ca_CentralizedBean" ;
		String bean_name = "eCA.CentralizedBean";
		CentralizedBean bean = (CentralizedBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(localeName);
		bean.clear() ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		
		String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String alternate_id=request.getParameter("alternate_id")==null?"":request.getParameter("alternate_id");
		String nationality_id=request.getParameter("nationality_id")==null?"":request.getParameter("nationality_id");
		String from_date=request.getParameter("from_date")==null?"":request.getParameter("from_date");
		String to_date=request.getParameter("to_date")==null?"":request.getParameter("to_date");
		String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
		String selFacility= request.getParameter("selfacility")==null?"":request.getParameter("selfacility");
		String RepDb ="";
		String patient_id_new="";
		String facility_id="";

		ArrayList searchData = new ArrayList() ;
		int totalRecordCount = 0;
		try
		{
		con = ConnectionManager.getConnection(request);
		
			ArrayList facilityDetails =(ArrayList)bean.getFacilityDetails(con,patient_id,nationality_id,alternate_id);
			for (int i=0;i<facilityDetails.size();i++) {
				String [] patientDet = (String[])facilityDetails.get(i);
				if(selFacility.equals(patientDet[0])){
					 RepDb= "@"+patientDet[3];
					 facility_id=patientDet[0];
					 patient_id_new=patientDet[2];
					 
					 searchData =(ArrayList)bean.getAllEncounters(con,patient_id_new,facility_id,from_date,to_date,RepDb);

					 totalRecordCount = searchData.size();
				}
		   }
			
			
			if (totalRecordCount!=0){		
	%>
	<table cellpadding='3'  class='grid' cellspacing=0 border='1' width="100%" height="" id="tableresult" >
				<tr> 
					<td class="columnheader" width='14%' style="text-align:center">
						<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
					
					<td class="columnheader" width='14%' style="text-align:center">
						<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
						
					<td class="columnheader" width='14%' style="text-align:center">
						<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
					
					<td class="columnheader" width='14%' style="text-align:center">
						<fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/>
					
					<td class="columnheader" width='14%' style="text-align:center">
						<fmt:message key="eCA.VisitAdmEndDate.label" bundle="${ca_labels}"/>
					
					<td class="columnheader" width='15%' style="text-align:center">
						<fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/>
					
					<td class="columnheader" width='15%' style="text-align:center">
						<fmt:message key="Common.MedicalService.label" bundle="${common_labels}"/>
					</td>
				</tr>
			<%
				for(int i=0;i<searchData.size();i++){
					ArrayList encounter_result=(ArrayList)searchData.get(i);
					
					String	pat_id = (String)encounter_result.get(0)==null?"":(String)encounter_result.get(0);
					String	enc_id 	= (String)encounter_result.get(1)==null?"":(String)encounter_result.get(1);
					String	pat_class = (String)encounter_result.get(2)==null?"":(String)encounter_result.get(2);
					String	visit_adm_date = (String)encounter_result.get(3)==null?"":(String)encounter_result.get(3);
					String	visit_end_date = (String)encounter_result.get(4)==null?"":(String)encounter_result.get(4);
					String	attnd_prac = (String)encounter_result.get(5)==null?"":(String)encounter_result.get(5);
					String	med_serv = (String)encounter_result.get(6)==null?"":(String)encounter_result.get(6);
					String	pat_class_id = (String)encounter_result.get(7)==null?"":(String)encounter_result.get(7);
					String	facility_id_new = (String)encounter_result.get(8)==null?"":(String)encounter_result.get(8);
					String	patient_name = (String)encounter_result.get(9)==null?"":(String)encounter_result.get(9);
					count++;
				%>
				<tr>
					<td class='gridData' name="pat_class<%=count%>" width='14%'><font size=1><%=pat_class%></td>
					<td class='gridData' name="pat_id<%=count%>"width='14%'><font size=1><%=patient_id_new%></td>
					<td class='gridData' width='14%'><a class='gridLink' href="#" name="encId'<%=count%>'" onclick="loadViewChartSummary('<%=count%>');"><%=enc_id%></a></td>
					<td class='gridData' name="visit_adm_date<%=count%>"width='14%'><font size=1><%=visit_adm_date%></td>
					<td class='gridData' name="visit_end_date<%=count%>" width='14%'><font size=1><%=visit_end_date%></td>
					<td class='gridData' name="attnd_prac<%=count%>" width='15%'><font size=1><%=attnd_prac%></td>
					<td class='gridData' name="med_serv<%=count%>"width='15%'><font size=1><%=med_serv%></td>
				</tr>
				<input type="hidden" id="patient_id"name="patient_id" value="<%=pat_id%>">
				<input type="hidden" id="patient_name"name="patient_name" value="<%=patient_name%>">
				<input type="hidden" id="facility_id"name="facility_id" value="<%=facility_id_new%>">
				<input type="hidden" id="called_from"name="called_from" value="<%=called_from%>">
				<input type="hidden" name="encounter_id<%=count%>" id="encounter_id<%=count%>" value="<%=enc_id%>">
				<input type="hidden" name="patient_class<%=count%>" id="patient_class<%=count%>" value="<%=pat_class_id%>">
				<input type="hidden" name="RepDb" id="RepDb" value="<%=RepDb%>">
				<%
			}
		}
		else{
		%>	<Script language=javascript>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%	
			}
		%>
</table>
<input type="hidden" name="enc_id" id="enc_id" value="">
<input type="hidden" name="pat_class" id="pat_class" value="">
<input type="hidden" name="facility_id" id="facility_id" value="">
</form>
<%	}	
			catch(Exception e){
				e.printStackTrace();		
			}
			finally
			{
				if(con != null)	con.close();		
			}
%>
</body>
</html>
	
	
	
	
	


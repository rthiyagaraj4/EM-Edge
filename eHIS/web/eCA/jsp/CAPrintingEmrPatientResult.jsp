<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
07/05/2019		ML-MMOH-CRF-1064	Kamalakannan G		07/05/2019		Ramesh Goli		IN066304
11/24/2023   32902        Twinkle Shah    	           Ramesh Goli             MMS-DM-CRF-0210	
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<% 
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css' />
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCA/js/CAPrintingEmrPatient.js'> </script>
<link rel="stylesheet" type="text/css"
	href="../../eCommon/html/CommonCalendar.css" />
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<!-- <style>
	.test{
		position:relative;
		display:block;
	}
</style> -->
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="nursing_plan_report" id="nursing_plan_report" method="post">
		<%
			
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			String bean_id					= "CAClinicalHistoryBean" ;
			String bean_name				= "eCA.CAClinicalHistoryBean";
			CAClinicalHistoryBean bean	= (CAClinicalHistoryBean)getBeanObject( bean_id, bean_name , request) ;
			String patient_id = request.getParameter("patientId")==null?"":request.getParameter("patientId");
			String date_from = request.getParameter("date_from")==null?"":request.getParameter("date_from");
			date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY","en",locale); 
			String date_to = request.getParameter("date_to")==null?"":request.getParameter("date_to");
			date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMY","en",locale);
	
			String facility_id = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
			String language_id = request.getParameter("language_id")==null?"":request.getParameter("language_id");
			ArrayList<ArrayList<String>> searchData=new ArrayList<ArrayList<String>>();
			searchData=bean.getCAPrintingEmrResult(patient_id,date_from,date_to,facility_id,language_id);
			//Start 32902
			String respAccess = request.getParameter("respAccess")==null?"N":request.getParameter("respAccess"); 
			if(respAccess.equals("Y")){
			%> <script>
				 alert(getMessage("AC_RSTR_PAT_LMT_AUT","CA")); 
				 parent.CAPrintingEmrPatientResult.location.href = "../../eCommon/html/blank.html";
				 parent.CAPrintingEmrPatientSubRes.location.href = "../../eCommon/html/blank.html";
				 </script>
			<% }  
			//32902 end
			if(searchData.size() == 0)
			{
			%>
				<script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"))
					parent.CAPrintingEmrPatientResult.location.href = "../../eCommon/html/blank.html";
					parent.CAPrintingEmrPatientSubRes.location.href = "../../eCommon/html/blank.html";
				</script>

			<%	}else{%>
				<div style="height:250px; overflow-y: scroll;">
					<table width="100%" class='grid'>
						<tr class='test'>
							<td class='COLUMNHEADERCENTER'><fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADERCENTER' width="8%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADERCENTER'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADERCENTER'>Visit start or Admission date/time</td>
							<td class='COLUMNHEADERCENTER'>Visit end or discharge date/time</td>
							<td class='COLUMNHEADERCENTER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
						</tr>
							
					<%
					for(int i=0;i<searchData.size();i++){
						ArrayList<String> resultInRow = new ArrayList();
						resultInRow=(ArrayList<String>)searchData.get(i);
						String encounter_id = resultInRow.get(1)==null?"":resultInRow.get(1);
						String patient_class = resultInRow.get(4)==null?"":resultInRow.get(4);
						String Visit_start = resultInRow.get(2)==null?"":resultInRow.get(2);
						String Visit_end = resultInRow.get(3)==null?"":resultInRow.get(3);
					%>	
						<tr>
							<td class='gridData'><%=i+1%></td>
							<td class='gridData'><%=encounter_id%></td>
							<td class='gridData'><%=patient_class%></td>
							<td class='gridData'><%=Visit_start%></td>
							<td class='gridData'><%=Visit_end%></td>
							<td class='gridData'><input type=radio name='<%=patient_id%>' id='<%=patient_id%>' value='<%=encounter_id%>' onClick="chkRadiobutton(this,'<%=date_from%>','<%=date_to%>')"></td>
						</tr>	
				<%}
				}%>
				</table>
			</div>
	</form>
</body>
</html>


<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
22/04/2024  50627    Twinkle Shah    22/04/2024		Ramesh Goli        ML-MMOH-CRF-2106
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.Common.*,java.util.*,eCA.*,eCommon.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<head>
<% 
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css' />
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script> 
<script language='javascript' src='../../eCA/js/ConsultationTagging.js'> </script>	
<style>
	.test{
		position:relative;
		display:block;
	}
</style>
</head>
<body OnMouseDown='CodeArrest()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="ConsultationTagResult" id="ConsultationTagResult">
<%
			String bean_id					= "ConsultationTaggingBean" ;
			String bean_name				= "eCA.ConsultationTaggingBean";
			ConsultationTaggingBean bean	= (ConsultationTaggingBean)getBeanObject( bean_id, bean_name , request) ;
			String patient_id = request.getParameter("patientId")==null?"":request.getParameter("patientId");	
			String facility_id = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
			String language_id = request.getParameter("language_id")==null?"":request.getParameter("language_id");
			String option_id = request.getParameter("option_id")==null?"":request.getParameter("option_id");			
			ArrayList<ArrayList<String>> searchData=new ArrayList<ArrayList<String>>();
			searchData=bean.getPatRecordConsultationTagging(patient_id,facility_id,language_id);
			if(searchData.size() == 0)
			{
			%>
				<script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common")) 
		            parent.ConsultationTagResult.location.href = "../../eCommon/html/blank.html";
					parent.ConsultationTagQuery2.location.href = "../../eCommon/html/blank.html";
					parent.messageFrame.location.href = "../../eCommon/html/blank.html";
				</script>

			<%	}else{%>					
 <div style="height:89px; overflow-y: scroll;">
 <table width="100%" class='grid'>
						<tr class='test'>
							<td class='COLUMNHEADERCENTER'><fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADERCENTER' width="14%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADERCENTER'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
							<td class='COLUMNHEADERCENTER'>Visit Start or Admission Date/Time</td>
							<td class='COLUMNHEADERCENTER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
						</tr>
							
					<%
					for(int i=0;i<searchData.size();i++){
						ArrayList<String> resultInRow = new ArrayList();
						resultInRow=(ArrayList<String>)searchData.get(i);
						String encounter_id = resultInRow.get(1)==null?"":resultInRow.get(1);
						String patient_class = resultInRow.get(4)==null?"":resultInRow.get(4);
						String visit_adm_date = resultInRow.get(2)==null?"":resultInRow.get(2);
						String speciality = resultInRow.get(3)==null?"":resultInRow.get(3);
					%>	
						<tr>
							<td class='gridData'><%=i+1%></td>
							<td class='gridData'><%=encounter_id%></td>
							<td class='gridData'><%=patient_class%></td> 
							<td class='gridData'><%=speciality%></td> 
							<td class='gridData'><%=visit_adm_date%></td>
							<td class='gridData'><input type=radio name='<%=patient_id%>' value='<%=encounter_id%>' onClick="chkRadiobutton(this,'<%=visit_adm_date%>')"></td>
						</tr>	
				<%}
				}%>
				</table>
			    </div>
				<input type='hidden' name='option_id' id='option_id' value=<%=option_id%>>
	</form>
</body>
</html>


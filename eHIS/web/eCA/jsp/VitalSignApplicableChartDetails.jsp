<!DOCTYPE html>
<%
/*	
--------------------------------------------------------------------------------------------------------------
 Date       	Edit History	Name       Rev.Date   	Rev.By    		Description
 --------------------------------------------------------------------------------------------------------------
 ?				?				?			?			?				?
 28/06/2020		IN072777		Ramesh G	01/07/2020	Ramesh Goli		AAKH-CRF-0097.2
 ---------------------------------------------------------------------------------------------------------------
 */ 
%>
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<% String sStyle = CommonBean.checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language="JavaScript" src="../../eCA/js/VitalSign.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
	</head>
	<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String bean_id="CAVitalSignBean";
       	String bean_name="eCA.CAVitalSignBean";
		String selectedDiscret = request.getParameter("selectedDiscret")==null?"":request.getParameter("selectedDiscret");
		ArrayList<String[]> chartDetails = new ArrayList<String[]>();  
		
	%>
    <body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>		
		<form name = 'VitalSignResultFormDetals'  method="post" target="messageFrame">
			<%
			try{
				eCA.CAVitalSignBean bean = (eCA.CAVitalSignBean)getBeanObject(bean_id,bean_name,request);
				
					chartDetails=bean.getAppChartDetails(selectedDiscret);  					
					%>
					<table cellspacing='0' cellpadding='0' align='center' width='100%' border='0' >
						<tr>
							<td class="columnheader"  width='67%'  nowrap>Chart Name</td>
							<td class='columnheader' width='33%' nowrap><fmt:message key="Common.selectall.label" bundle="${common_labels}"/>
								<input type=checkbox id='select_all' name='select_all' id='select_all' onClick='selectAllChart(this)'><BR>
							</td>
						</tr>	
						<tr><td colspan="2">
						<table cellspacing='0' id="applableChartDetails" cellpadding='0' align='center' width='100%' border='0' >
						<%
						for(int j=0;j<chartDetails.size();j++){
							String[] chartIdVal = chartDetails.get(j);
							String checkedVal = "";
							if("Y".equals(chartIdVal[2])){
								checkedVal="Checked";
							}
							
						%>
						<tr><td colspan='2'>
							<input type="checkbox" id="ChartID<%=j%>" Value="<%=chartIdVal[0] %>" <%=checkedVal%>/><%=chartIdVal[1] %>
						</td></tr>
						<%}%>	
						</table>
						</td></tr>
					</table>					 					
					<input type="hidden" name="totalCharts" id="totalCharts" id="totalCharts" value="<%=chartDetails.size()%>" />  
					<input type="hidden" name="selectedDiscret" id="selectedDiscret" id="selectedDiscret" value="<%=selectedDiscret%>" /> 
					<%
				
			}catch(Exception e){
				//out.println(e);//COMMON-ICN-0181
				e.printStackTrace();
			}
			%>
			
		</form>		
	</body>
</html>


<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
23/10/2018		IN067402		Prakash		10/09/2018		Ramesh Goli		ML-MMOH-CRF-0813.1
-------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page import="java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.Common.*,eCommon.XSSRequestWrapper"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<HTML>
<HEAD>
 <%
		String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCA/js/CATannerStaging.js' language='javascript'></script>
 </head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con		= null;
%>
<form name='CATannerAuditForm' id='CATannerAuditForm' method ='post' target='messageFrame'>
<%
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String date_from = request.getParameter("date_from")==null?"":request.getParameter("date_from");
String date_to = request.getParameter("date_to")==null?"":request.getParameter("date_to");
String sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");
System.out.println("sex---"+sex);

String recrd_date 	= "";
String pubicHair 		= "";
String pract_name = "";
String pubicHair1="";
String stageOfPuberty1="";

String login_practitioner_id	= (String) session.getValue("ca_practitioner_id");
java.util.Properties p 		= (java.util.Properties) session.getValue( "jdbc" ) ;
String locale 				= (String) p.getProperty("LOCALE");
String bean_id		= "@catannerStagingBean"+patient_id;
String bean_name	= "eCA.CATannerStagingBean";
eCA.CATannerStagingBean beanObj = (eCA.CATannerStagingBean)getObjectFromBean(bean_id,bean_name,session);
ArrayList searchData = (ArrayList)beanObj.getTannerStagingAuditDetails(request,login_practitioner_id,locale,patient_id,encounter_id,date_from,date_to); 
String view_history_yn  = request.getParameter("view_history_yn")==null?"N":request.getParameter("view_history_yn");		
int totalcount=searchData.size();
try{	
	if(totalcount!=0){
	 %>
		<table  class='grid' width="100%">
	
					<tr>
						<td class="COLUMNHEADER" width="10%" style="text-align:center">
							<fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/>
						</td>
						<td class="COLUMNHEADER" width="10%" style="text-align:center">
							<fmt:message key="Common.practitionername.label" bundle="${common_labels}"/>
						</td>
						<td class="COLUMNHEADER" width="15%" style="text-align:center">
							<fmt:message key="Common.recordeddatetime.label" bundle="${common_labels}"/>
						</td>
				<% if(view_history_yn.equals("Y")){ %>	
						<td class="COLUMNHEADER" width="10%" style="text-align:center">
							<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
						</td>
				<%} 		
				for(int i=0;i<searchData.size();i++){	
						ArrayList audit_result=(ArrayList)searchData.get(i);
						
						pract_name=(String)audit_result.get(0);
						pubicHair=(String)audit_result.get(1);
						
						String[]  pubicHair2=pubicHair.split("\\|");
						pubicHair1 = pubicHair2[0];
						stageOfPuberty1 = pubicHair2[1];	
						recrd_date =(String)audit_result.get(2);
						encounter_id =(String)audit_result.get(3);
						
						String slClassValue = "gridData";	
				%>
					</tr>
					<tr>
						<td style="text-align:center" nowrap class='<%=slClassValue%>'><%=i+1%> &nbsp;</td>
						<td style="text-align:center" class='<%=slClassValue%>'><%=pract_name%></td>
						<td style="text-align:center" class='<%=slClassValue%>'>			
							<a href='#' onclick="showResult('<%=pubicHair1%>','<%=stageOfPuberty1%>','<%=recrd_date%>');" id='showResult'><%=recrd_date%></a>
						</td>
				<% if(view_history_yn.equals("Y")){ %>	
						<td style="text-align:center" class='<%=slClassValue%>'><%=encounter_id%></td>
				<%}%> 		
					</tr>
		<%}%>	
				<input type=hidden id="pat_id" name="patient_id" id="patient_id" value="<%=patient_id%>">
				<input type=hidden id="enc_id" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
				<input type=hidden id="pat_sex" name="patient_sex" id="patient_sex" value="<%=sex%>">
				<input type=hidden id="recrd_date" name="recrd_date" id="recrd_date" value="<%=recrd_date%>">
				<input type=hidden id="pubicHair1" name="pubicHair1" id="pubicHair1" value="<%=pubicHair1%>">
				<input type=hidden id="stageOfPuberty1" name="stageOfPuberty1" id="stageOfPuberty1" value="<%=stageOfPuberty1%>">
		
		</table>
	<%}else{%>	
			<Script language=javascript>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				parent.TannerStagingDetails.location ="../../eCommon/html/blank.html";
				parent.TannerStagingFrame.location ="../../eCommon/html/blank.html"; 
				parent.TannerStagingPrintFrm.location ="../../eCommon/html/blank.html"; 
				//document.forms[0].print.disabled = true;
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}
	}
	catch(Exception e){
		e.printStackTrace();		
	}
	finally
	{
		if(con != null)	con.close();		
	}%>
	
					
</form>			
</body>
</html>


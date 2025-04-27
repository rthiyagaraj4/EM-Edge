<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
11/05/2018	IN063838		Ramesh G											ML-MMOH-CRF-0813
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String patient_id 	= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String sex 			= request.getParameter("Sex")==null?"":request.getParameter("Sex");
String age 			= request.getParameter("Age")==null?"":request.getParameter("Age");
Integer patientAge 	= 0;
String recordedScoreYN 	= "N"; 
String stageOfPuberty 	= "";
String pubicHair 		= "";
String recorded_date="";//IN069057

if (age != null && age.length() > 1) {
		if(age.indexOf('Y')!=-1)
			patientAge = Integer.parseInt(age.substring(0, age.indexOf('Y')));
    }

String bean_id		= "@catannerStagingBean"+patient_id;
String bean_name	= "eCA.CATannerStagingBean";
eCA.CATannerStagingBean beanObj = (eCA.CATannerStagingBean)getObjectFromBean(bean_id,bean_name,session);
//String tannerStagingDetails = beanObj.getTannerStagingScoreDetails(request,patient_id,encounter_id); IN069057
ArrayList tannerStagingDetails = (ArrayList)beanObj.getTannerStagingScoreDetails(request,patient_id,encounter_id);// IN069057
String tannerStagingDetailsValue="";
if(tannerStagingDetails.size()>0){
	recordedScoreYN ="Y";
//IN069057 starts	
	tannerStagingDetailsValue=(String)tannerStagingDetails.get(0);
	//String[] tannerStagingArray = tannerStagingDetails.split("\\|"); Commented for IN069057
	String[] tannerStagingArray = tannerStagingDetailsValue.split("\\|");
	pubicHair = tannerStagingArray[0];
	stageOfPuberty = tannerStagingArray[1];	
	recorded_date=(String)tannerStagingDetails.get(1);
//IN069057 ends	
}
 
%>
<html>
<head>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/json2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
function removeObjectsFromSession(){}
</script>
<%if(patientAge>=2 && patientAge<=18 && !sex.equals("U")){%>	
	<iframe name="TannerStagingFrame" id="TannerStagingFrame" frameborder="0" scrolling="yes" noresize src="../../eCA/jsp/blank.jsp" style="height:84vh; width:100vw;"></iframe>
	<iframe name="TannerStagingButtonFrame" id="TannerStagingButtonFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/CATannerStagingButton.jsp?patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&Sex=<%=sex%>&Age=<%=age%>&recordedScoreYN=<%=recordedScoreYN %>&stageOfPuberty=<%=stageOfPuberty%>&pubicHair=<%=pubicHair%>&recorded_date=<%=recorded_date%>" style="height:6%;width:100vw"></iframe><!--added recorded_date for IN069057-->		
	
<%}else{%>
	<body>
		<table width="100%" height="550px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="100%" align="center" valign="middle" valign="top">
					<table width="40%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<%if(sex.equals("U")){%>
							<td width="100%" style="text-align:center; vertical-align:top">
									This function is not applicable for this gender patient.
							<td>
							<%}else{%>
							<td width="100%" style="text-align:center; vertical-align:top">
									This function is applicable for age group between 2 to 18 years alone.
							<td>
							<%}%>
						</tr>
					</table>	
				<td>
			</tr>
		</table>
	</body>
<%}%>	
</html>


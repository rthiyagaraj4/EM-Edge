<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
--------------------------------------------------------------------------------------------------------------------
Date       Edit History     Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------
24/11/2014	IN052312		Karthi L						Ramesh			Autoclaving Unit Test Entry
--------------------------------------------------------------------------------------------------------------------
-->
<%--
	/**
	  *Developed by		:	Geetha CR
	  *Created on		:	
	  *Last Modified on	:	
	  *Module			:	
	  *Function			:	
	  */
--%>
<%@page  import=" eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>  
<jsp:useBean id="alAutoclaveWashingUnitTestList" scope="session" class="java.util.ArrayList"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String locale		=	(String)session.getAttribute("LOCALE");
	String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String mode						=	request.getParameter("mode");
%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eSS/js/AutoclaveWashingUnitTest.js"></script>	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<body onMouseDown="CodeArrest()">
<form name='formAutoclaveWashingUnitTestList' id='formAutoclaveWashingUnitTestList' >
	<table border='1' cellpadding='0' cellspacing='0' width='100%' >
<%
	try {
		String bean_id							=	 "autoclaveWashingUnitTestListBean";
		String bean_name						=	"eSS.AutoclaveWashingUnitTestListBean";
		AutoclaveWashingUnitTestListBean bean	=	 (AutoclaveWashingUnitTestListBean) getBeanObject( bean_id , bean_name, request ) ;  
		bean.setLoginFacilityId((String)session.getAttribute("facility_id"));
		
		String disabled							=	"";
		HashMap hmRecord						=	new HashMap();
		String className						=	"";
		String autoclave_wash_unit_code			=	request.getParameter("autoclave_wash_unit_code");
		String test_date						=	request.getParameter("test_date");
		//AAKH-CRF-0057 - IN052312 - Start
		String unit_type						=	request.getParameter("unit_type");
		//String mode						=	request.getParameter("mode");
		if(unit_type == null) unit_type = "";
		String biological_indicator				=	""; 
		String bms_pass_fail					=	""; 
		String room_temp						=	"";
		String relative_humidity				=	"";
		//AAKH-CRF-0057 - IN052312 - End
		if(!(autoclave_wash_unit_code==null) ){
				test_date						=	com.ehis.util.DateUtils.convertDate(test_date,"DMY",locale,"en");
				disabled						=	bean.isEntryCompleted(autoclave_wash_unit_code,test_date)?"disabled":disabled;
		}
		int i;
		//AAKH-CRF-0057 - IN052312 - Start
	%>
				<tr>
					<th class="columnheader" width='5%'>Del</th>
					<th class="columnheader" width='27%'><fmt:message key="Common.Test.label" bundle="${common_labels}"/></th>
					<th class="columnheader" width='12%'><fmt:message key="eSS.BatchID.label" bundle="${ss_labels}"/></th>
					<th class="columnheader" width='9%'><fmt:message key="eSS.TestResult.label" bundle="${ss_labels}"/></th>				
					<th class="columnheader" width='10%'><fmt:message key="eSS.ResultDate.label" bundle="${ss_labels}"/></th>
					
					<!-- AAKH-CRF-0057 - IN052312 - Start -->
					<% if(mode.equalsIgnoreCase("1") || mode.equalsIgnoreCase("2") && unit_type.equalsIgnoreCase("Autoclave")) {  %>
						<th class="columnheader" width='15%'><fmt:message key="eSS.RoomTemperature.label" bundle="${ss_labels}"/></th>
						<th class="columnheader" width='15%'><fmt:message key="eSS.RelativeHumidity.label" bundle="${ss_labels}"/></th>
						<th class="columnheader" width='10%'><fmt:message key="eSS.BiologicalIndicator.label" bundle="${ss_labels}"/></th>
						<th class="columnheader" width='10%'><fmt:message key="eSS.BMSPassFail.label" bundle="${ss_labels}"/></th>
					<% } %>
					<!-- AAKH-CRF-0057 - IN052312 - Fail -->
				</tr>
				
			<div>
	<% 	
		//AAKH-CRF-0057 - IN052312 - End
		for	(i	=0;	i<alAutoclaveWashingUnitTestList.size();i++){
			hmRecord		=	(HashMap)	alAutoclaveWashingUnitTestList.get(i);
			bean.initialize(hmRecord);
			className		=	((i%2)==0)?"QRYODD":"QRYEVEN";
			room_temp 				= bean.getRoom_temp();
			relative_humidity 		= bean.getRelative_humidity();
			biological_indicator 	= bean.getBiologic_indicator() ;
			bms_pass_fail			= bean.getBms_pass_fail();
			
			if(biological_indicator.equalsIgnoreCase("X") || biological_indicator.equals("") || biological_indicator == null){
				biological_indicator = "Not Applicable";
			} else if(biological_indicator.equalsIgnoreCase("Y")){
				biological_indicator = "Test Done";
			} else if(biological_indicator.equalsIgnoreCase("N")){
				biological_indicator = "Test Not Done";
			}
			if(bms_pass_fail.equalsIgnoreCase("X") || bms_pass_fail.equals("") || bms_pass_fail == null){
				bms_pass_fail = "Not Applicable";
			} else if(bms_pass_fail.equalsIgnoreCase("Y")){
				bms_pass_fail = "Pass";
			} else if(bms_pass_fail.equalsIgnoreCase("N")){
				bms_pass_fail = "Fail";
			}
			if(room_temp == null){
				room_temp = "";
			}
			if(relative_humidity == null){
				relative_humidity = "";
			}
		%>
		<!-- AAKH-CRF-0057 - IN052312 - Start -->
		<tr>
			<td  class="<%=className%>"  width='5%'><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" <%=disabled%>></td>
			<td  class="<%=className%>" width='27%'><%if(disabled.equals("")){ %><a href="javascript:listModify(<%=i%>,'<%=bean.getTest_code()%>','<%=bean.getUnit_type()%>');"><%}%><%=bean.getTestDescription()%></a></td>
			<td class="<%=className%>" width='12%' align=right><%=bean.getBatch_id()%></td>
			<%if (bean.getTest_result().equals("P")){%>
			<td class="<%=className%>" width='8%'><fmt:message key="eSS.Pass.label" bundle="${ss_labels}"/></td>
			<%}else{%>
			<td class="<%=className%>"  width='8%'><fmt:message key="eSS.Fail.label" bundle="${ss_labels}"/></td>
			<%}%>
			<td class="<%=className%>" width='10%'><%=com.ehis.util.DateUtils.convertDate(bean.getResult_date(),"DMY","en",locale)%></td>
			<% if(mode.equalsIgnoreCase("1") || mode.equalsIgnoreCase("2") && unit_type.equalsIgnoreCase("Autoclave")) {  %>
				<td class="<%=className%>" width='15%'><%= room_temp  %> &nbsp;</td>
				<td class="<%=className%>" width='15%'><%= relative_humidity %>&nbsp;</td>
				<td class="<%=className%>" width='10%'><%= biological_indicator %></td>
				<td class="<%=className%>" width='10%'><%= bms_pass_fail %></td>
			<% } %>
		</tr>
		<!-- AAKH-CRF-0057 - IN052312 - End -->
	<%
		}
	%>
		</div>
		</table>
		<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
	</form>
<%
		putObjectInBean(bean_id,bean,request);
	}
	catch(Exception ex) {
		System.out.println(" 149. AutoclaveWashingUnitTest.jsp " + ex.getMessage());
		ex.printStackTrace();
	}
%>
</body>
<script>
<% if(mode.equalsIgnoreCase("2")){%>
	parent.frameAutoclaveWashingUnitTestDetail.location.href='../../eSS/jsp/AutoclaveWashingUnitTestDetail.jsp?<%=request.getQueryString()%>';
<%}%>	
</script>
</html>


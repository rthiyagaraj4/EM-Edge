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
25/11/2014	IN052312		Karthi L						Ramesh			Autoclaving Unit Test Entry
--------------------------------------------------------------------------------------------------------------------
-->
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="alAutoclaveWashingUnitTestList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<%

	request.setCharacterEncoding("UTF-8");
	String sStyle			 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Geetha CR">
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	</head>
<%
	alAutoclaveWashingUnitTestList.clear();
	String autoclave_wash_unit_code	=	request.getParameter("autoclave_wash_unit_code");
	String test_date				=	request.getParameter("test_date");
	String unit_type				=	request.getParameter("unit_type");
	String mode				=	request.getParameter("mode");
	String bean_id					=	 "autoclaveWashingUnitTestListBean";
	String bean_name				=	"eSS.AutoclaveWashingUnitTestListBean";

	AutoclaveWashingUnitTestListBean bean = (AutoclaveWashingUnitTestListBean) getBeanObject( bean_id,  bean_name, request );  
	bean.clear();
	ArrayList alAutoclaveWashingUnitTestRecords	=	null;
	if(autoclave_wash_unit_code!=null){
		try{
			ArrayList alParameters = new ArrayList(3);
			alParameters.add(autoclave_wash_unit_code.trim());
			alParameters.add(test_date.trim());
			alParameters.add(unit_type.trim().substring(0,1));
			alAutoclaveWashingUnitTestRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_DTL_SELECT_MULTIPLE"),alParameters);

			for (int i=0;i<alAutoclaveWashingUnitTestRecords.size();i++){
				HashMap hmAutoclaveWashingUnitTestRecord=(HashMap)alAutoclaveWashingUnitTestRecords.get(i);
				hmAutoclaveWashingUnitTestRecord.put("test_code",		(String)hmAutoclaveWashingUnitTestRecord.get("TEST_CODE") );
				hmAutoclaveWashingUnitTestRecord.put("batch_id",	(String)hmAutoclaveWashingUnitTestRecord.get("BATCH_ID") );
				hmAutoclaveWashingUnitTestRecord.put("test_result",		(String)hmAutoclaveWashingUnitTestRecord.get("TEST_RESULT")  );
				hmAutoclaveWashingUnitTestRecord.put("test_date",		(String)hmAutoclaveWashingUnitTestRecord.get("TEST_DATE")  );
				hmAutoclaveWashingUnitTestRecord.put("result_date",		(String)hmAutoclaveWashingUnitTestRecord.get("RESULT_DATE")  );
				hmAutoclaveWashingUnitTestRecord.put("result_remarks",		(String)hmAutoclaveWashingUnitTestRecord.get("RESULT_REMARKS"));
				hmAutoclaveWashingUnitTestRecord.put("unit_type",		unit_type);
				//added for AAKH-CRF-0057 - IN052312 - Start	
				hmAutoclaveWashingUnitTestRecord.put("room_temp",		(String)hmAutoclaveWashingUnitTestRecord.get("ROOM_TEMP"));
				hmAutoclaveWashingUnitTestRecord.put("relative_humidity",		(String)hmAutoclaveWashingUnitTestRecord.get("RELATIVE_HUMIDITY"));
				hmAutoclaveWashingUnitTestRecord.put("biologic_indicator",		(String)hmAutoclaveWashingUnitTestRecord.get("BIOLOGICAL_IND_TEST_DONE"));
				hmAutoclaveWashingUnitTestRecord.put("bms_pass_fail",		(String)hmAutoclaveWashingUnitTestRecord.get("BMS_PASS_FAIL"));
				//added for AAKH-CRF-0057 - IN052312 - End
				hmAutoclaveWashingUnitTestRecord.put("mode",			eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
				hmAutoclaveWashingUnitTestRecord.remove("TEST_CODE") ;
				hmAutoclaveWashingUnitTestRecord.remove("BATCH_ID")  ;
				hmAutoclaveWashingUnitTestRecord.remove("TEST_RESULT");
				hmAutoclaveWashingUnitTestRecord.remove("TEST_DATE");
				//added for AAKH-CRF-0057 - IN052312 - Start	
				hmAutoclaveWashingUnitTestRecord.remove("ROOM_TEMP") ;
				hmAutoclaveWashingUnitTestRecord.remove("RELATIVE_HUMIDITY")  ;
				hmAutoclaveWashingUnitTestRecord.remove("BIOLOGICAL_IND_TEST_DONE");
				hmAutoclaveWashingUnitTestRecord.remove("BMS_PASS_FAIL");
				//added for AAKH-CRF-0057 - IN052312 - End	
				alAutoclaveWashingUnitTestList.add(hmAutoclaveWashingUnitTestRecord);
			}
		}
		catch(Exception exception){
			// out.print(exception);
			exception.printStackTrace(); // COMMON-ICN-0185
		}
	}
	putObjectInBean(bean_id,bean,request);
%>
	<frameset rows='100,*'  name='fsAutoclaveWashingUnitTest'>
		<frame name='frameAutoclaveWashingUnitTestHeader' src="../../eSS/jsp/AutoclaveWashingUnitTestHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
		<!--  <frameset cols="40%,*" >AAKH-CRF-0057 - IN052312 -->
		  <frameset cols="27%,*" name='fsAutoclaveWashingUnitTestDtl'> <!-- AAKH-CRF-0057 - IN052312 -->
<%
			if(mode.equals("1")){
%>
				<frame name='frameAutoclaveWashingUnitTestDetail' src="../../eSS/jsp/AutoclaveWashingUnitTestDetail.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
				<!-- <frameset rows="17,*">  AAKH-CRF-0057 - IN052312-->
				<!-- <frame name='frameAutoclaveWashingUnitTestListHeader' src='../../eSS/html/AutoclaveWashingUnitTestListHeader.html' nowrap frameborder=0 scrolling='no'  noresize> -->
<%
			}
			else{
%>
				<frame name='frameAutoclaveWashingUnitTestDetail' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no'   noresize>
<%
			}
%>
			<frame name='frameAutoclaveWashingUnitTestList'	src="../../eSS/jsp/AutoclaveWashingUnitTestList.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noresize>
		</frameset>

	</frameset>

</html>

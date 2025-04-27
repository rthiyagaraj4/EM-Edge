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
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<jsp:useBean id="alAutoclaveWashingUnitTestList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<%
	String locale			= (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Geetha">
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script> 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/AutoclaveWashingUnitTest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body>
<%
	try {
		String bean_id							=	"autoclaveWashingUnitTestListBean";
		String bean_name						=	"eSS.AutoclaveWashingUnitTestListBean";
		AutoclaveWashingUnitTestListBean bean	= (AutoclaveWashingUnitTestListBean) getBeanObject(bean_id,  bean_name, request );  
		bean.clear();
		bean.setLoginFacilityId((String)session.getAttribute("facility_id"));
		String disabled							=	"";
		String disabledMode						=	"";
		String codeDisabled						=	"";

		String autoclave_wash_unit_code			=	request.getParameter("autoclave_wash_unit_code");
		String test_date						=	request.getParameter("test_date");
		String unit_type						=	request.getParameter("unit_type");
		String test_code						=	bean.checkForNull(request.getParameter("test_code"));
		String method						=	bean.checkForNull(request.getParameter("met"));

		
		if(unit_type==null || unit_type.equals("Autoclave")) unit_type="A";
		if(unit_type.equals("Washing"))unit_type="W";
		String index							=	bean.checkForNull(request.getParameter("index"),"-1");
		String strButtonLegend					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
		String mode								=	index.equals("-1")? 	bean.getCommonRepositoryValue("MODE_INSERT"):bean.getCommonRepositoryValue("MODE_MODIFY");
		//AAKH-CRF-0057 - IN052312 - Start 
		String user_mode						= 	request.getParameter( "mode" ); 
		if(user_mode == null) user_mode = "";
		String modify_disabled					= "";
		
		if(mode.equals("2")){
			modify_disabled = "disabled";
		}
		//AAKH-CRF-0057 - IN052312 - End 
		if(!mode.equals(bean.getCommonRepositoryValue("MODE_MODIFY"))){
			disabledMode						=	"disabled" ; 
			bean.setTest_result("Pass");
		}
		if(mode.equals(bean.getCommonRepositoryValue("MODE_MODIFY"))){

			bean.initialize((HashMap)alAutoclaveWashingUnitTestList.get(Integer.parseInt(index)));
			strButtonLegend						=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
			codeDisabled						=	"disabled";
			
		}
			bean.setTest_code(test_code);
			bean.initSsParameter();
			
			bean.initResult_date();
			bean.setUnit_type(unit_type.trim());
			bean.setLanguageId(locale);
		if(!(autoclave_wash_unit_code==null)){
			 test_date		=	com.ehis.util.DateUtils.convertDate(test_date,"DMY",locale,"en");

			disabled=bean.isEntryCompleted(autoclave_wash_unit_code,test_date)?"disabled":"";
		}
		System.out.println("method===>"+method);
		/*if(method.equals("modify")){
			bean.clear();
		}*/
		

	%>
		<body onMouseDown="CodeArrest()" onload="enaDisableBIOBMS('<%=user_mode%>','<%=unit_type%>')" > <!-- AAKH-CRF-0057 - IN052312  -->
			<form name="formAutoclaveWashingUnitTestDetail" id="formAutoclaveWashingUnitTestDetail" >
				<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
				<tr>
				<td width='100%' height='100%' align='center' valign='top'>
				<table border="0" cellpadding="3" cellspacing="0" width='100%' align='center'>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="eSS.AutoclaveWashTest.label" bundle="${ss_labels}"/></td>
						<td class="label" >&nbsp;<select name="test_code" id="test_code"  <%if(unit_type.equalsIgnoreCase("A")){ %>onChange = 'loadWashTestCode();'<%} %> <%=disabled%><%=modify_disabled %>><%=bean.getTest_code_List(unit_type)%></select><%=bean.getMandatoryImageTag()%></td> <!-- AAKH-CRF-0057 - IN052312  -->
					</tr>
					<tr>
						<td class="label"><fmt:message key="eSS.BatchID.label" bundle="${ss_labels}"/></td>
						<td class="label">&nbsp;<input type='text' name="batch_id" id="batch_id" value="<%=bean.getBatch_id()%>" <%=disabled%> maxLength="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" size="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);" class="NUMBER" <%=codeDisabled%>><%=bean.getMandatoryImageTag()%></td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="eSS.TestResult.label" bundle="${ss_labels}"/></td>
						<td class="label">&nbsp;<select name="test_result" id="test_result" <%=disabled%> <%=disabledMode%>><%=bean.getTest_result_List()%></select></td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="eSS.ResultDate.label" bundle="${ss_labels}"/></td>
						<td class="label">&nbsp;<input type=text name="result_date" id="result_date" size=10 maxlength=10  onBlur="CheckDate(this);" <%=codeDisabled%> <%=disabled%> <%=disabledMode%> value="<%=com.ehis.util.DateUtils.convertDate(bean.getResult_date(),"DMY","en",locale)%>"><%=bean.getMandatoryImageTag()%></td>
					</tr>
					<!--  added for AAKH-CRF-0057 - IN052312 - Start -->
					<tr>
					<td class="label"><fmt:message key="eSS.RoomTemperature.label" bundle="${ss_labels}"/></td>
						<td class="label">&nbsp;<input type=text name="room_temp" id="room_temp" size=15 maxlength=15  onBlur="" <%=disabled%> value="<%=bean.getRoom_temp()== null?"":bean.getRoom_temp().trim()%>"</td>
					</tr>
					<tr>
					<td class="label"><fmt:message key="eSS.RelativeHumidity.label" bundle="${ss_labels}"/></td>
						<td class="label">&nbsp;<input type=text name="relative_humidity" id="relative_humidity" size=15 maxlength=15  onBlur="" <%=disabled%> value="<%=bean.getRelative_humidity()==null?"":bean.getRelative_humidity().trim()%>"</td>
					</tr>
					<%
					if(unit_type.equalsIgnoreCase("A")) {
						if((mode.equalsIgnoreCase("1")||mode.equalsIgnoreCase("2")) &&  (bean.getBiologic_indicator().equalsIgnoreCase("Y") || bean.getBiologic_indicator().equalsIgnoreCase("N"))) {
							System.out.println(" 133 Autoclavewashingunittestdetail.jsp" + bean.getBiologic_indicator());
							
					%>	
						<tr id = "bio_indicator_row_id" style='display:inline'>
							<td class="label" id = "bio_indicator_label"><fmt:message key="eSS.BiologicalIndicator.label" bundle="${ss_labels}"/></td>
							<td id = "bio_indicator_data">&nbsp;
								<select name='biologic_indicator_id' id='biologic_indicator_id' onchange = "modifyBioIndicator()" <%=disabled%>>
	<%-- 								<option value = "X" <%if( bean.getBiologic_indicator().equals("X")) {%>selected<% }%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option> --%>
									<option value = "Y" <%if( bean.getBiologic_indicator().equals("Y")) {%>selected <% } %>><fmt:message key="eSS.testdone.label" bundle="${ss_labels}"/></option>
									<option value = "N" <%if( bean.getBiologic_indicator().equals("N")) {%>selected <% } %>><fmt:message key="eSS.testnotdone.label" bundle="${ss_labels}"/></option>
									
								</select>
							</td>
							<input type='hidden' name="biologic_indicator" id="biologic_indicator"	value="<%=bean.getBiologic_indicator()%>">
						</tr>
					<%
						} else if((mode.equalsIgnoreCase("1")||mode.equalsIgnoreCase("2")) &&  (bean.getBiologic_indicator().equalsIgnoreCase("X") || bean.getBiologic_indicator().equals(""))) {
							System.out.println(" 159 Autoclavewashingunittestdetail.jsp" + bean.getBiologic_indicator());
							
					%>	
						<tr id = "bio_indicator_row_id" style='display:none'>
							<td class="label" id = "bio_indicator_label"><fmt:message key="eSS.BiologicalIndicator.label" bundle="${ss_labels}"/></td>
							<td id = "bio_indicator_data">&nbsp;
								<select name='biologic_indicator_id' id='biologic_indicator_id' onchange = "modifyBioIndicator()" <%=disabled%>>
	<%-- 								<option value = "X" <%if( bean.getBiologic_indicator().equals("X")) {%>selected<% }%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option> --%>
									<option value = "Y" <%if( bean.getBiologic_indicator().equals("Y")) {%>selected <% } %>><fmt:message key="eSS.testdone.label" bundle="${ss_labels}"/></option>
									<option value = "N" <%if( bean.getBiologic_indicator().equals("N")) {%>selected <% } %>><fmt:message key="eSS.testnotdone.label" bundle="${ss_labels}"/></option>
									
								</select>
							</td>
							<input type='hidden' name="biologic_indicator" id="biologic_indicator"	value="<%=bean.getBiologic_indicator()%>">
							</tr>
					<%
						} else {
							System.out.println(" 175 Autoclavewashingunittestdetail.jsp" + bean.getBiologic_indicator());
					%>	
						<tr id = "bio_indicator_row_id" style='display:none'>
							<td class="label" id = "bio_indicator_label"><fmt:message key="eSS.BiologicalIndicator.label" bundle="${ss_labels}"/></td>
							<td id = "bio_indicator_data">&nbsp;
								<select name='biologic_indicator_id' id='biologic_indicator_id' onchange = "modifyBioIndicator()" <%=disabled%>>
	<%-- 								<option value = "X" <%if( bean.getBiologic_indicator().equals("X")) {%>selected<% }%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option> --%>
									<option value = "Y" <%if( bean.getBiologic_indicator().equals("Y")) {%>selected <% } %>><fmt:message key="eSS.testdone.label" bundle="${ss_labels}"/></option>
									<option value = "N" <%if( bean.getBiologic_indicator().equals("N")) {%>selected <% } %>><fmt:message key="eSS.testnotdone.label" bundle="${ss_labels}"/></option>
									
								</select>
								
							</td>
								<input type='hidden' name="biologic_indicator" id="biologic_indicator"	value="<%=bean.getBiologic_indicator()%>">
					<% } %>

						</tr>
					<%
						 if((mode.equalsIgnoreCase("1")||mode.equalsIgnoreCase("2")) && ( bean.getBms_pass_fail().equalsIgnoreCase("Y") || bean.getBms_pass_fail().equalsIgnoreCase("N"))) {
								System.out.println("209. AutoclaveWashingUnitTestDetail -- > mode" + mode + " BMS PASS FAIL " + bean.getBms_pass_fail());
						%>	
							<tr id = "bms_passfail_row_id" style='display:inline'>
								<td class="label" id = "bms_passfail_row_data" ><fmt:message key="eSS.BMSPassFail.label" bundle="${ss_labels}"/></td>
							<td id = "bms_pass_fail">&nbsp;
								<select name='bms_pass_fail_id' id='bms_pass_fail_id'    onchange = "modifyBmsPassFail()" <%=disabled%>>
	<%-- 								<option value = "X" <%if( bean.getBms_pass_fail().equals("X")) {%>selected<% }%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option> --%>
									<option value = "Y" <%if( bean.getBms_pass_fail().equals("Y")) {%>selected<% }%>><fmt:message key="eSS.Pass.label" bundle="${ss_labels}"/></option>
									<option value = "N" <%if( bean.getBms_pass_fail().equals("N")) {%>selected<% }%>><fmt:message key="eSS.Fail.label" bundle="${ss_labels}"/></option>
								</select>
							</td>
							<input type='hidden' name="bms_pass_fail" id="bms_pass_fail"	value="<%=bean.getBms_pass_fail()%>">
							</tr>
						<%	
							} else if((mode.equalsIgnoreCase("1")||mode.equalsIgnoreCase("2")) && ( bean.getBms_pass_fail().equalsIgnoreCase("X") || bean.getBms_pass_fail().equals(""))) {
								System.out.println("223. AutoclaveWashingUnitTestDetail -- > mode" + mode + " BMS PASS FAIL " + bean.getBms_pass_fail());
						%>	
							<tr id = "bms_passfail_row_id" style='display:none'>
								<td class="label" id = "bms_passfail_row_data" ><fmt:message key="eSS.BMSPassFail.label" bundle="${ss_labels}"/></td>
							<td id = "bms_pass_fail">&nbsp;
								<select name='bms_pass_fail_id' id='bms_pass_fail_id'    onchange = "modifyBmsPassFail()" <%=disabled%>>
	<%-- 								<option value = "X" <%if( bean.getBms_pass_fail().equals("X")) {%>selected<% }%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option> --%>
									<option value = "Y" <%if( bean.getBms_pass_fail().equals("Y")) {%>selected<% }%>><fmt:message key="eSS.Pass.label" bundle="${ss_labels}"/></option>
									<option value = "N" <%if( bean.getBms_pass_fail().equals("N")) {%>selected<% }%>><fmt:message key="eSS.Fail.label" bundle="${ss_labels}"/></option>
								</select>
							</td>
							<input type='hidden' name="bms_pass_fail" id="bms_pass_fail"	value="<%=bean.getBms_pass_fail()%>">
							</tr>
						<%
							} else {
								System.out.println("237. AutoclaveWashingUnitTestDetail -- > mode" + mode + " BMS PASS FAIL " + bean.getBms_pass_fail());
						%>	
							<tr id = "bms_passfail_row_id" style='display:none'>
							<td class="label" id = "bms_passfail_row_data" ><fmt:message key="eSS.BMSPassFail.label" bundle="${ss_labels}"/></td>
							<td id = "bms_pass_fail">&nbsp;
								<select name='bms_pass_fail_id' id='bms_pass_fail_id'    onchange = "modifyBmsPassFail()" <%=disabled%>>
	<%-- 								<option value = "X" <%if( bean.getBms_pass_fail().equals("X")) {%>selected<% }%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option> --%>
									<option value = "Y" <%if( bean.getBms_pass_fail().equals("Y")) {%>selected<% }%>><fmt:message key="eSS.Pass.label" bundle="${ss_labels}"/></option>
									<option value = "N" <%if( bean.getBms_pass_fail().equals("N")) {%>selected<% }%>><fmt:message key="eSS.Fail.label" bundle="${ss_labels}"/></option>
								</select>
							</td>
							<input type='hidden' name="bms_pass_fail" id="bms_pass_fail"	value="<%=bean.getBms_pass_fail()%>">
						<% } %>
						</tr>
					<%
					}
					%>
					<!--  added for AAKH-CRF-0057 - IN052312 - End -->
					<tr>
						<td class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
						<td class="label">&nbsp;<textarea name="result_remarks"  id="result_remarks" cols=20 rows=4  onKeyPress="return setTextAreaMaxLength(this,200);" onBlur=" checkSetTextAreaMaxLength(result_remarks,200);" <%=disabled%>  ><%=bean.getResult_remarks()%></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>

					<tr>
						<td  class="label" colspan='2'>
							<input type='button' class='BUTTON' name="apply" id="apply" onClick="addToList();" value="<%=strButtonLegend%>" <%=disabled%>>
							<input type='button' class='BUTTON' name="cancel" id="cancel" onClick="document.location.href='../../eSS/jsp/AutoclaveWashingUnitTestDetail.jsp'" value="Cancel" <%=disabled%>>					
						</td>
					</tr>

					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
				</table>
				</td>
				</tr>
				</table>
				<input type='hidden' name="index" id="index"						 value="<%=index%>">
				<input type='hidden' name="mode" id="mode"						 value="<%=mode%>">
				<input type='hidden' name="locale" id="locale"						 value="<%=locale%>">
				<input type='hidden' name="unit_type" id="unit_type"					value="<%=unit_type%>">
				<input type="hidden" name="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE" id="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE")%>">
				<input type="hidden" name="SS_WRITE_OFF_REASON_LOOKUP" id="SS_WRITE_OFF_REASON_LOOKUP"	value="<%= bean.getSsRepositoryValue("SS_WRITE_OFF_REASON_LOOKUP")%>">
			</form>
	<%
		putObjectInBean(bean_id,bean,request);
	}
	catch(Exception ex) {
		System.out.println(" 256. AutoclaveWashingUnitTestDetail.jsp " + ex.getMessage());
		ex.printStackTrace();
	}	
%>
	</body>
</html>


<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History    	Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
24/02/2023	39764				SREENADH              Ramesh G	    PMG2022-MMS-CRF-0002
13/04/2023      43567           SREENADH.M            Ramesh.G      PMG2022-MMS-CRF-0002
--------------------------------------------------------------------------------------------------------------
*/ 
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/PhDrugCostlyRxByCustomer.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT> -->
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eOR/js/OrCommonLookup.js"></script> <!-- 39764 -->
	</head>
<%
	String bean_id				= "PHReportsBean" ;
	String bean_name			= "ePH.PHReportsBean";
	PHReportsBean bean	= (PHReportsBean)getBeanObject(bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	String sys_date=bean.getSysDate();
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	bean.setLoginFacilityId(p_facility_id);
	
	boolean  phGrpDescCodeSiteSpecificYN = bean.getSiteSalesReport(); // 39764 START

	ArrayList customerGrouplist = bean.getCustomerGroup();
	ArrayList displocation  = bean.getDispLocation();
	String Sysdate 				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);	
	String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	ArrayList customerList = bean.getCustomerBasedCustgrp("");
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formDrugCostlyRxByCriteria.p_doc_from_date.focus();">  
		<form name="formDrugCostlyRxByCriteria" id="formDrugCostlyRxByCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
		<!-- 	<table cellpadding="0" cellspacing="2" width="100%" align="center" border="0"> -->
			<table cellpadding="3" cellspacing="3"  width="100%" align="center" border="0"> <!-- 39764 -->
				<TH  colspan='10' height='4' ALIGN="Center"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr>	
				
				  <%if(phGrpDescCodeSiteSpecificYN){%>  <!--  39764 START -->
				    <td class="label" nowrap width='10%'><fmt:message key="ePH.CustomerGroup.label" bundle="${ph_labels}"/></td>
					<td width="20%" nowrap class='fields' style="text-align: left;">
					<input type="hidden" name='P_CUST_GRP_FRM_CODE' id='P_CUST_GRP_FRM_CODE' id='P_CUST_GRP_FRM_CODE' size="10" />
					<input type="text" name='CUST_GRP_FRM_CODE' id='CUST_GRP_FRM_CODE' id='CUST_GRP_FRM_CODE' size="10" onblur="" disabled>&nbsp;
					<input type="text" name='P_CUST_GRP_FRM_DESC' id='P_CUST_GRP_FRM_DESC' id='P_CUST_GRP_FRM_DESC' size="30" onblur="if(this.value!=''){ customerGroupCodeDescLookup(P_CUST_GRP_FRM_DESC,P_CUST_GRP_FRM_CODE,1,2);}else{fnClearCode(P_CUST_GRP_FRM_CODE,CUST_GRP_FRM_CODE);}">&nbsp;
					<input type="button" class="button" value='?' name="custGrpBtn" id="custGrpBtn" id="custGrpBtn" onClick="customerGroupCodeDescLookup(P_CUST_GRP_FRM_DESC,P_CUST_GRP_FRM_CODE,1,2);" ><img src='../../eCommon/images/mandatory.gif'>
					</td>
				
				 	<td class="label" width='10%' ><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
						<td width="20%" nowrap class='fields' style="text-align: left;">
						<input type="hidden" name='P_CUST_FRM_CODE' id='P_CUST_FRM_CODE' id='P_CUST_FRM_CODE' size="10"  value="**" />
						<!-- <input type="text" name='P_CUST_FRM_CODE' id='P_CUST_FRM_CODE' id='P_CUST_FRM_CODE' size="10" onblur="if(this.value!=''){ customerCodeNameLookup();} else{ fnClearCode(P_CUST_FRM_DESC);}" value="**">&nbsp; -->
						<input type="text" name='CUST_FRM_CODE' id='CUST_FRM_CODE' id='CUST_FRM_CODE' size="10" onblur="" value="**" disabled>&nbsp; <!-- 43567 -->
						<!-- <input type="text" name='P_CUST_FRM_DESC' id='P_CUST_FRM_DESC' id='P_CUST_FRM_DESC' size="30" onblur="if(this.value!=''){ customerCodeNameLookup(); } else{ fnClearCode(P_CUST_FRM_CODE);}" value="All Payer">&nbsp; -->
						<input type="text" name='P_CUST_FRM_DESC' id='P_CUST_FRM_DESC' id='P_CUST_FRM_DESC' size="30" onblur="if(this.value!=''){ customerCodeNameLookup(P_CUST_FRM_DESC,P_CUST_FRM_CODE,1,2); } else{ fnClearCode(P_CUST_FRM_CODE,CUST_FRM_CODE);}" value="All Payer">&nbsp; <!-- 43567 -->
						<!-- <input type="button" class="button" name="custBtn" id="custBtn" id='custBtn' value='?' onClick="customerCodeNameLookup()"><img src='../../eCommon/images/mandatory.gif'> -->	
						<input type="button" class="button" name="custBtn" id="custBtn" id='custBtn' value='?' onClick="customerCodeNameLookup(P_CUST_FRM_DESC,P_CUST_FRM_CODE,1,2)"><img src='../../eCommon/images/mandatory.gif'>	<!-- 43567 -->
					</td>
				<%}else{ %>    <!--  39764 END -->
								
					<td class="label" nowrap width='10%'><fmt:message key="ePH.CustomerGroup.label" bundle="${common_labels}"/></td>
					<td class='label' width='10%'>
					<select name="P_CUST_GRP_FRM_CODE" id="P_CUST_GRP_FRM_CODE" onChange="getCustomerBasedonCustgrp(this)" id="P_CUST_GRP_FRM_CODE">
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>	
<%
						for (int i=0;i<customerGrouplist.size();i+=2){
%>
							<OPTION  VALUE="<%= customerGrouplist.get(i) %>" ><%= customerGrouplist.get(i+1) %></OPTION>
<%               
						}
%>						
					</select>
					<input type="hidden" name='P_CUST_GRP_FRM_DESC' id='P_CUST_GRP_FRM_DESC' id='P_CUST_GRP_FRM_DESC' size="30" value="none"> <!--  39764 END -->
					</td>		
					<td  class="label" width='10%' ><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td><!--Added for MMS-QH-CRF-0106 [IN:039374] -->
					<td class='label'  width='15%' >
					<select name="P_CUST_FRM_CODE" id="P_CUST_FRM_CODE" onChange="" >
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>	
<%
						for (int i=0;i<customerList.size();i+=2){
%>
							<OPTION  VALUE="<%= customerList.get(i) %>" ><%= customerList.get(i+1) %></OPTION>
<%               
						}
%>
					</select>
					<input type="hidden" name='P_CUST_FRM_DESC' id='P_CUST_FRM_DESC' id='P_CUST_FRM_DESC' size="30" value="none"> <!-- 39764 -->
					</td>		
				 <%}%>	<!-- 39764 -->
				</tr>			
				<tr><td align="right" class="label" width='10%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
					<td class='label' align="left" width='10%'>
						<SELECT name="P_patient_class" id="P_patient_class" style="width:150px">
							<option value =""> <fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
							<option value ="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
							<option value ="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
							<option value ="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
							<option value ="XT"><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
							<option value ="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
						</select>
					</td>
					<td  class="label" width='10%' ><fmt:message key="ePH.DispenseLocation.label" bundle="${common_labels}"/></td><!--Added for MMS-QH-CRF-0106 [IN:039374] -->
					<td class='label'  width='15%' >
					<select name="p_loc" id="p_loc" onChange="" >
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
						for (int i=0;i<displocation.size();i+=2){
%>
							<OPTION  VALUE="<%= displocation.get(i) %>" ><%= displocation.get(i+1) %></OPTION>
<%               
						}
%>
					</select>
					</td> 
				</tr>
				<tr>
					<td class="label" width='10%'nowrap><fmt:message key="Common.fromdate.label" bundle="${ph_labels}"/></td>
					<td class='label'>
					<input type="text" name="p_doc_from_date" id="p_doc_from_date" value="<%=currentdate%>" maxlength="10" size="10" onKeyPress="return AllowDateFormat()" onBlur='checkDate(this,"DMY","<%=locale%>")'>
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_doc_from_date');"  onblur='p_doc_from_date.focus()'>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif">
					</td>
					</td>
					<td class="label" width='10%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class='label'><input type="text" name="p_doc_to_date" id="p_doc_to_date" value="<%=currentdate%>" maxlength="10" size="10" onKeyPress="return AllowDateFormat()" onBlur='checkDate(this,"DMY","<%=locale%>")'>
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_doc_to_date');"  onBlur='p_doc_to_date.focus()'>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif">
					</td>
				</tr>
			</table>
		    <INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden"  name="p_report_id" id="p_report_id" VALUE="PHRCSTMT">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<input type="hidden" name="p_mode" id="p_mode" value="VIEW"> 
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>"> 
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>"> 
			<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%=currentdate%>">
			<INPUT TYPE="hidden" name="p_sal_trn_type" id="p_sal_trn_type" VALUE="">
			<INPUT TYPE="hidden" name="P_CUST_TO_CODE" id="P_CUST_TO_CODE" VALUE="">
			<input type="hidden" name="SiteSpecificYN" id="SiteSpecificYN" value="<%=phGrpDescCodeSiteSpecificYN%>">  <!--  39764  -->
		</form>
	</body>
</html>


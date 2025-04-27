<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100               ?          		created
12/08/2014   HSA-CRF-0155[IN048487]   SureshKumar T    Pharmacy Management->PH Transaction->ReRoutePrescription-ExternalFacility
---------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <%--This file is saved on 04/06/2007 --%>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title><fmt:message key="ePH.ExternalFacilityDetail.label" bundle="${ph_labels}"/></title>
<%
        request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute		("PREFERRED_STYLE"):"IeStyle.css";
		String bean_id				= "ReRoutePrescriptionsBean";
		String bean_name			= "ePH.ReRoutePrescriptionsBean";
		ReRoutePrescriptionsBean bean		= (ReRoutePrescriptionsBean)getBeanObject( bean_id,bean_name,request);
		bean.setLanguageId(locale);
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/DateUtils.js"></SCRIPT>
		<script language="JavaScript" src="../../ePH/js/ReRoutePrescription.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="formExternalPrescriptionDetail" id="formExternalPrescriptionDetail">
<%
			//Search Criteria's from Query Criteria page
			ArrayList alBMSReasons = bean.getBMSReasons(locale);
			String SQL_PH_DISP_PRACT_REFERRAL_SELECT  = PhRepository.getPhKeyValue("SQL_PH_DISP_PRACT_REFERRAL_SELECT");
			String strNextCollectionDate="";
			String sysdate                  = bean.getTodaysDate();
			ArrayList facilitys				=	null;
			facilitys=(ArrayList)bean.getOtherRefFacility(); 
			String login_user	        = (String)session.getValue("login_user");
			String functional_role_id	=    bean.getFunctRollID(login_user);
			String Pract_name			=	 bean.getPractitionerName( functional_role_id);
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<tr>
				  <td  class="label" nowrap width='30%'><fmt:message key="Common.externalfacility.label" bundle="${common_labels}"/></td>
				  <td class = label width='70%'>
						<select name="ext_facility" id="ext_facility">
						<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
<%
						if(facilitys!=null && facilitys.size() > 0 ){
							for(int t=0;t<facilitys.size();t+=2){
%>
								<OPTION  VALUE='<%=facilitys.get(t)%>'><%=facilitys.get(t+1) %></OPTION>
<%
							}
						}
%>
						</select><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
					</td>
				</tr>
				<tr>
				    <td class="label" nowrap><fmt:message key="ePH.NextCollectionDate.label" bundle="${ph_labels}"/></td>
					<td class = label width='70%'><input type="text" name="next_collectiondate" id="next_collectiondate"  size="8" maxlength="10"  value="<%=strNextCollectionDate%>" onBlur="CheckDate(this);checkSysDate(sysdate,next_collectiondate);">&nbsp;<INPUT  TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif"  id=Calendar onclick="return showCalendar('next_collectiondate');" ><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
				</tr> 
				<tr>
					<td class="label" nowrap><fmt:message key="ePH.BalanceMedicationRemarks.label" bundle="${ph_labels}"/></td>
					<td class = label width='70%'>
						<select name="ExtbmsReason" id="ExtbmsReason" >
							<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
								if(alBMSReasons!=null && alBMSReasons.size()>0){
									  for(int indx=0; indx<alBMSReasons.size(); indx+=2){
%>
										   <option value="<%=(String)alBMSReasons.get(indx)%>" ><%=(String)alBMSReasons.get(indx+1)%></option>
<%
										}
									}
%>
						  </select>
					 </td>
				</tr>
				<tr>
					<td class="label"> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class = label ><textarea size="500" name="referral_remarks" cols="60" rows="2" onKeyPress="return checkMaxLimit(this,500);" onblur ="return checkReferelRemarksMaxLimit(this,500);"></textarea><IMG SRC="../../eCommon/images/mandatory.gif"></IMG>
					</td>
				</tr> 
				<tr >
					<td  class="label" nowrap><fmt:message key="ePH.ReferedBy.label" bundle="${ph_labels}"/></td>
					<td class = label ><input type="text" name="practioner_name" id="practioner_name" maxlength="40" size="20" value="<%=Pract_name%>" onchange="searchPractioner(this, 'ONCHANGE');" >&nbsp;<input type="button" class="button" value="?" name="practioner_search" id="practioner_search" onclick="searchPractioner(this, 'ONCLICK');"><img src="../../eCommon/images/mandatory.gif" ID="mand1" >
					&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.PrintExternalPrescription.label" bundle="${ph_labels}"/>
					<input type="hidden" name="practioner_id" id="practioner_id" value="<%=functional_role_id%>">
					<input type="checkbox" name="print_extr_pres" id="print_extr_pres" checked>
					</td>
				</tr>
				<tr>    
					<td  colspan="2" class="white" align="right"><input type="button" name="recordButton" id="recordButton" class="button" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="record(document.formExternalPrescriptionDetail);">&nbsp;&nbsp;<input type="button" class="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="reset_table(document.formExternalPrescriptionDetail)">&nbsp;<input  type="button" class="button" value='<fmt:message key="Common.cancel.label"  bundle="${common_labels}"/>' onClick="parent.window.close(false)"></td>
				</tr>
			</table>
			<input type="hidden" name="SQL_PH_DISP_PRACT_REFERRAL_SELECT" id="SQL_PH_DISP_PRACT_REFERRAL_SELECT" value="<%=SQL_PH_DISP_PRACT_REFERRAL_SELECT%>">
			<input type="hidden" name="sysdate" id="sysdate" value="<%=com.ehis.util.DateUtils.convertDate(bean.getTodaysDate(),"DMY","en",locale)%>">
		</form>
	</body>
<%
	
	putObjectInBean(bean_id,bean,request); 
%>
</html>


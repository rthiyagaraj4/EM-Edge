<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.*, ePH.*, ePH.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<html>
	<head>
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale	= (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhRepRefillLabel.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="PhRepRefillLabelCriteriaForm" id="PhRepRefillLabelCriteriaForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame" onload ="parent.frames[0].document.forms[0].run.disabled = true">
<%
		String bean_id		= "PHReportsBean" ; 
		String bean_name	= "ePH.PHReportsBean";
		PHReportsBean bean = (PHReportsBean)getBeanObject( bean_id,bean_name, request) ;
		bean.setLanguageId(locale);
        ArrayList facilityList      = bean.getFacilitys();

		//SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
		//java.util.Date date_time	 	= new java.util.Date();
		String Sysdate 				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		
		
		
%>
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="refillquerycriteriatable" >
		<TH COLSPAN="6"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr><td class='label' colspan='6' height='6'></td></tr>
			<tr>
			<td class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
					<td >&nbsp;<SELECT name="p_facility_code" id="p_facility_code" >
						<OPTION VALUE="" > <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
<%	
						if (facilityList.size() > 0 ){
							for (int i=0; i<facilityList.size(); i+=2) {
%>
								<OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>
<% 
							}
						}
%>
	
						</select>
					</td>
				<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td>&nbsp;
					<input type="text" name="p_patient_id" id="p_patient_id" size="20" value=""  maxlength="<%=bean.getPatientIDLength()%>" onKeyPress="changeToUpper()" ><!--  onblur="Duplicatecheck();" added for ML-BRU-SCF-0621[IN036565]-->
					<input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch(document.PhRepRefillLabelCriteriaForm.patient_id)"   >
					&nbsp;<img   src="../../eCommon/images/mandatory.gif"></img>
				</td>
           </tr>
           <tr>
				<td class="label"><fmt:message key="ePH.OrderDateTimeFrom.label" bundle="${ph_labels}"/></td>
				<td>&nbsp;
					<input type="text" name="p_from_date" id="p_from_date"  size="10" Onblur="if(CheckDateT(this))if(DateCheck(sysdate,p_from_date))validate_date(this,'TO_DATE_LESS_FROM')"><!--changed CheckDate to CheckDateT for Leap year calculation on 24/02/2012 -->
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_from_date');" >
				</td>
				<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td>&nbsp;
					<input type="text" name="p_to_date" id="p_to_date" size="10" Onblur="if(CheckDateT(this)) if(DateCheck(sysdate,p_to_date)) validate_date(this,'TO_DATE_LESS_FROM');"><!--changed CheckDate to CheckDateT for Leap year calculation on 24/02/2012 -->
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_to_date');"
					>
				</td>		
			</tr>
			<tr>
			<td class="label"><fmt:message key="ePH.PrescriptionNo.label" bundle="${ph_labels}"/></td>
				<td>&nbsp;
					<input type="text" name="order_id" id="order_id" maxlength="15" size="20" onKeyPress="changeToUpper()">

				</td>	
				
				<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<td>&nbsp;&nbsp;<input type="text" name="locn_name" id="locn_name" STYLE='overflow:visible;' ><!--size="20" maxlength="20" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
				<input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onclick="locationLookup(locn_name)" >
				<input type="hidden" name="p_locn_code" id="p_locn_code">
				</td>	
				
			</tr>
		
			<td class="label" colspan=4></td>
			<td colspan="2"> 
				<input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResults()" >
			</td>
		<tr>
		</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<input type="hidden" name="p_refill_order" id="p_refill_order" value="">
			<input type="hidden" name="p_report_id" id="p_report_id" value="PHPRREFLB">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="P_ORDER_CATALOG_CODE" id="P_ORDER_CATALOG_CODE" VALUE="">
			

		</form>
		<% putObjectInBean(bean_id,bean,request); %>
	</body>


</html>


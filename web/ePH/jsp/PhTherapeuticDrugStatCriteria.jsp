<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
30/01/2016	IN051707		Badmavathi B									Therapeutic Drug Monitoring Statistic
06/05/2021	TFS-15598       Prabha        06/05/2021 	 Manickavasagam J   MOHE-CRF-0074
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String p_user_name= (String) session.getValue( "login_user" ) ;	 //Added for MOHE-CRF-0074
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script LANGUAGE="javascript" src="../../ePH/js/PhTherapeuticDrugStat.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	
	//Added for MOHE-CRF-0074 - End
	
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "PHRepDispStatisByDispBean" ;
	String bean_name			= "ePH.PHRepDispStatisByDispBean";
	PHRepDispStatisByDispBean bean	= (PHRepDispStatisByDispBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	ArrayList facilityList       = bean.getMednFacilityList();
	String sql_ph_generic_name_select_lookup=PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_LOOKUP_TDM");
	String generic_code = bean.checkForNull((String) bean.fetchRecord(PhRepository.getPhKeyValue("SQL_GENERIC_ID_FAC_PARAM"),new String[]{p_facility_id}).get("DEF_GENERIC_ID"),"");
	String generic_name = bean.checkForNull((String) bean.fetchRecord(PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_FOR_ID"),new String[]{generic_code,locale}).get("GENERIC_NAME"),"");//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016
	
	String order_facility_id="" , order_facility_name=""; //Added for MOHE-CRF-0074
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheck(p_user_name,region_code); //Added for MOHE-CRF-0074
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhTherapeuticDrugStatCriteria.p_facility_code.focus();"> 
		<form name="formPhTherapeuticDrugStatCriteria" id="formPhTherapeuticDrugStatCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<TH COLSPAN="10" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				     <tr>
				     	<td align="left" class="label" width="15%" nowrap><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
					<td align="left" class="label" colspan='2'><SELECT name="p_facility_code" id="p_facility_code" >
						<OPTION VALUE="ALL"> <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
<%						

				if(region_check){ // MOHE-CRF-0074-Start
					   for (int i=0;i<region_code_check.size();i+=2){
							order_facility_id=(String)region_code_check.get(i);
							order_facility_name=(String)region_code_check.get(i+1);
%>
						<option value='<%=order_facility_id%>' ><%=order_facility_name%></option>
<%
							}
					}else{ //Added for MOHE-CRF-0074 - End
						if (facilityList.size() > 0 ){
							for (int i=0; i<facilityList.size(); i+=2) { 
%>
						<OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>
<% 							}
						}
					} //Added for MOHE-CRF-0074
%>
					</SELECT>
					   </td>
					   <td align="left" class="label" width="15%" nowrap><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td>
					   <td align="left" class="label"><input type="text" name="p_generic_name" id="p_generic_name" maxlength="40" size="40" value="<%=generic_name%>"><input type="button" class="button" value="?" name="p_generic_desc" id="p_generic_desc" onClick="callGenericSearch(document.formPhTherapeuticDrugStatCriteria.p_generic_name)"><!-- onfocus="callGenericSearch(document.formPhTherapeuticDrugStatCriteria.p_generic_name)" --><img src="../../eCommon/images/mandatory.gif"  align="center"><!-- Commenting onfocus for ML-MMOH-SCF-2380 --> 
					   </td>
					</tr>
				<td class=label >&nbsp;</td>
				<td class=label >&nbsp;</td>
				<tr>
					<td class="label" ><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
					<td COLSPAN="3" class="label"><input type="text" size="10" maxlength=10 name="p_dt_from" id="p_dt_from" OnBlur='CheckDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_dt_from');" ><img src="../../eCommon/images/mandatory.gif"  align="center"> &nbsp;&nbsp;
					<label class="label"><fmt:message key="Common.todate.label" bundle="${common_labels}"/></label> &nbsp;&nbsp;
					<input type="text" size="10" name="p_dt_to" id="p_dt_to"  maxlength=10 OnBlur='CheckDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_dt_to');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
				</tr>
			</table>
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRETDMS">
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE="">
			<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE="">
			<INPUT type="hidden" name="sql_ph_generic_name_select_lookup" id="sql_ph_generic_name_select_lookup" value="<%=sql_ph_generic_name_select_lookup%>">
			<INPUT type="hidden" name="P_GENERIC_CODE" id="P_GENERIC_CODE" value="<%=generic_code%>">  
		</form>
	</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>
<% //Added for MOHE-CRF-0074 - Start
}
catch(Exception e){
	e.printStackTrace();
}
finally{ 
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
}
%> <!-- Added for MOHE-CRF-0074 - End -->


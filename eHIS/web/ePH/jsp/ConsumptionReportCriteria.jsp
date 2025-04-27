<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*,java.text.*, ePH.*, ePH.Common.*" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/ItemSearch.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PHReports.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/ConsumptionReport.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT> -->
		<script LANGUAGE="javascript" src="../../ePH/js/PhCommon.js"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date date_time	 	= new java.util.Date();
	String Sysdate ="";
	Sysdate 				= dtSystemFormat.format(date_time); 
	Sysdate=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale);
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;

	//String sql_ph_reports_atc5_lookup=PhRepository.getPhKeyValue("SQL_PH_REPORTS_ATC5_LOOKUP");
	String sql_ph_reports_disp_lookup="SELECT A.DISP_LOCN_CODE CODE, A.SHORT_DESC DESCRIPTION FROM PH_DISP_LOCN_LANG_VW A WHERE  UPPER(A.DISP_LOCN_CODE) LIKE UPPER(?) AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND A.EFF_STATUS = 'E' AND LANGUAGE_ID = ";
	//	String sql_ph_reports_item_lookup="SELECT DISTINCT B.ITEM_CODE CODE, C.SHORT_DESC DESCRIPTION FROM PH_DISP_LOCN A, ST_ITEM_STORE B,MM_ITEM_LANG_VW C WHERE  UPPER(A.FACILITY_ID) LIKE UPPER(?) AND UPPER(A.DISP_LOCN_CODE)LIKE UPPER(?) AND UPPER(B.ITEM_CODE) LIKE UPPER(?) AND UPPER(C.SHORT_DESC) LIKE UPPER(?) AND B.STORE_CODE = A.STORE_CODE AND B.EFF_STATUS = 'E' AND C.LANGUAGE_ID = ";
	
	String bean_id = "PHReportsBean" ;//Added for MMS-QH-CRF-0106 [IN:039374] - Start
	String bean_name = "ePH.PHReportsBean";
	PHReportsBean bean = (PHReportsBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	bean.setLoginFacilityId(p_facility_id);
	ArrayList customerGrouplist = bean.getCustomerGroup();
	ArrayList customerlist = bean.getCustomer();//Added for MMS-QH-CRF-0106 [IN:039374] - End

%>
	<body onMouseDown="" onKeyDown="lockKey()">
	<!--<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhMednStatByPractCriteria.p_facility_code.focus();"> -->

		<form name="formConsumptionReportCriteria" id="formConsumptionReportCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"  >
			<table cellpadding="0" cellspacing="0" width="90%" align="center" border="0">
				<TH COLSPAN="8" align="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr>
					<td class="label" width='10%'><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
					<td class="label" width='15%'><input type="text"  maxlength="60" size="20" name="disp_loc_desc" id="disp_loc_desc">
						<input type="button"  class="button" value="?" onClick="searchCode(this);"  >&nbsp;<img name='mandatory'  src="../../eCommon/images/mandatory.gif"></td>
						<input type="hidden" name="p_disp_locn_code" id="p_disp_locn_code" value="">
					
					<td class="label" width='10%'><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/> </td><!--  Added for MMS-QH-CRF-0106 [IN:039374] -->
					<td class="label" width='15%' >
						<select name="p_patient_class" id="p_patient_class" onChange=" ">
							<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
							<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
							<option value="XT"><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
							<option value="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
							</select>
					</td>
					<td class='label' colspan='2' width='*'>&nbsp;</td>
				</tr>
				<tr>	
					<td class="label" width='10%'nowrap><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class="label" width='15%'><input type="text" size="10" maxlength=10 name="dt_from1" id="dt_from1" Onblur="if(CheckDateT(this))if(DateCheck(sysdate,dt_from1))validate_date(this,'TO_DATE_LESS_FROM')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"> 
					</td>
					<td class="label" width='10%'nowrap><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</td>
					<td class="label" width='15%'nowrap>
						<input type="text" size="10" name="dt_to1" id="dt_to1" Onblur="if(CheckDateT(this))if(DateCheck(sysdate,dt_to1))validate_date(this,'TO_DATE_LESS_FROM')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
					<td class='label' colspan='2' width='*'>&nbsp;</td>
					<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE=" ">
					<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE=" ">
				</tr>
				<tr>	
					<td class="label" ><fmt:message key="ePH.CustomerGroup.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td><!--  Added for MMS-QH-CRF-0106 [IN:039374] -->
					<td class='label' >
					<select name="p_fm_cust_group_code" id="p_fm_cust_group_code" onChange="" id="p_fm_cust_group_code">
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>	
<%
						for (int i=0;i<customerGrouplist.size();i+=2){
%>
							<OPTION  VALUE="<%= customerGrouplist.get(i) %>" id="<%=customerGrouplist.get(i)%>"><%= customerGrouplist.get(i+1) %></OPTION>
<%               
						}
%>
					</select>
					</td>
					<td class="label" ><fmt:message key="ePH.CustomerGroup.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td><!--  Added for MMS-QH-CRF-0106 [IN:039374] -->
					<td class='label' >
					<select name="p_to_cust_group_code" id="p_to_cust_group_code" onChange="" id="p_to_cust_group_code">
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>	
<%
						for (int i=0;i<customerGrouplist.size();i+=2){
%>
							<OPTION  VALUE="<%= customerGrouplist.get(i) %>" id="<%=customerGrouplist.get(i)%>"><%= customerGrouplist.get(i+1) %></OPTION>
<%              
						}
%>
					</select>
					</td>		
					<td  class="label" width='10%' ><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td><!--Added for MMS-QH-CRF-0106 [IN:039374] -->
					<td class='label'  width='15%' >
					<select name="p_cust_code" id="p_cust_code" onChange="" >
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
						for (int i=0;i<customerlist.size();i+=2){
%>
							<OPTION  VALUE="<%= customerlist.get(i) %>" id="<%=customerlist.get(i)%>"><%= customerlist.get(i+1) %></OPTION>
<%               
						}
%>
					</select>
					</td>			
				</tr>
				<tr>
					<td class="label"><fmt:message key="ePH.ItemRange.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td  id="drug_from" class="label">
					<input type="text" name="item_name" id="item_name"  maxlength="20" size="20" value="" ><input type="button" class="button" value="?"  name="drug_search" id="drug_search" onClick="itemsearch(this)" onClick="itemsearch(this)"></td>
					<input type="hidden" name="p_item_code_from" id="p_item_code_from" value="">
					<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td id="drug_to" class="label"><input type="text" name="titem_name" id="titem_name"  maxlength="20" size="20" value=""><input type="button" class="button" value="?" name="tdrug_search" id="tdrug_search" onClick="itemsearch1(this)"></td>
					<input type="hidden" name="p_item_code_to" id="p_item_code_to" value="">
					<td class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/> </td><!--  Added for [IN:45428] start -->
					<td class="label">
						<select name="reportType" id="reportType" onChange=" ">
							<option value="D" selected><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
							<option value="S"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
							
							</select>
					</td>
				</tr>
			</TABLE>
			<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="sql_ph_reports_disp_lookup" id="sql_ph_reports_disp_lookup" VALUE="<%=sql_ph_reports_disp_lookup%>">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<!-- <INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRDSITM">  PHITCONSSUM_MMS-->
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHITCONS">
			<INPUT TYPE="hidden" name="p_from_date" id="p_from_date" VALUE="">
			<INPUT TYPE="hidden" name="p_to_date" id="p_to_date" VALUE="">
			<INPUT TYPE="hidden" name="item_from" id="item_from" VALUE=""> <!-- Added code for [IN:45428] start  -->
			<INPUT TYPE="hidden" name="item_to" id="item_to" VALUE=""> <!-- Added code for [IN:45428]  end -->
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>"> <!-- added for MOHE-CRF-0107 -->
		</form>
	</body>
</html>


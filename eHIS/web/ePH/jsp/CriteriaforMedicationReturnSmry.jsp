<!DOCTYPE html>
 
<%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>


<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");


String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script> 
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../js/OrdVsDispDrugs.js"></script> 
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="formOrderDispDrugs" id="formOrderDispDrugs" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

	<%
		String	bean_id			=	"ADRReportBean" ;
		String	bean_name		=	"ePH.ADRReportBean";

   		ADRReportBean bean = (ADRReportBean)getBeanObject(bean_id,bean_name ,request) ;
		bean.setLanguageId(locale);

		String	bean_id1			=	"PHReportsBean" ;
		String	bean_name1		=	"ePH.PHReportsBean";

   		PHReportsBean bean1 = (PHReportsBean)getBeanObject(bean_id1,bean_name1 ,request) ;
		bean1.setLanguageId(locale);
	
		String sql_ph_drug_search_select2 =	PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2");

		SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	    java.util.Date date_time	 	= new java.util.Date();
	    String Sysdate 				= dtSystemFormat.format(date_time);
	    Sysdate 						=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale);
	%>

	<table cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" >
	      <th colspan="8"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
			<TR><TD colspan="8">&nbsp;</TD>

			<tr>			
						<td class="label"><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td>
						<td colspan="7" >&nbsp;&nbsp;<input type="text" name="p_from_dt1" id="p_from_dt1"  size="8"  value="" maxlength="10" onblur="CheckDateT(this);DateCheck('<%=Sysdate%>',p_from_dt1);validate_date(this)" ><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar' onclick="return showCalendar('p_from_dt1');" ><!--DateCheck And  validate_date functions added for BRUSIM Adhoc Testing-->
						

						<img src="../../eCommon/images/mandatory.gif" align="center"></img>
						<INPUT TYPE="hidden" name="p_from_dt" id="p_from_dt" VALUE=" ">

						&nbsp;<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>
						&nbsp;<input type="text" name="p_to_dt1" id="p_to_dt1"  size="8"  value="" maxlength="10" onblur="CheckDateT(this);DateCheck('<%=Sysdate%>',p_to_dt1);validate_date(this)"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar' onclick="return showCalendar('p_to_dt1');" ><!--DateCheck And  validate_date functions added for BRUSIM Adhoc Testing -->
								<img src="../../eCommon/images/mandatory.gif" align="center"></img>
								<INPUT TYPE="hidden" name="p_to_dt" id="p_to_dt" VALUE=" ">
						</td>
			</tr>
			<tr >
						<td class="label"><fmt:message key="ePH.ReturnedDrug.label" bundle="${ph_labels}"/></td>
						 <td colspan="7">&nbsp;&nbsp;<input type="text" 
						name="p_drug_name" id="p_drug_name" value="" maxlength="60" size="67" onblur="clearvalues()";><input type="button" class="button" value="?" name="p_drug_name_search" id="p_drug_name_search"  onClick="callDrugSearch(document.formOrderDispDrugs.p_drug_name, 1)"> 
							<input type="hidden" name="P_RET_DRUG" id="P_RET_DRUG" value="">  
							<input type="hidden" name="p_drug_code" id="p_drug_code" value="">  
							
						</td>	
			</tr>
			<tr >
						<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td colspan="7">&nbsp;&nbsp;<input type="text"  name="P_PAT_ID1" id="P_PAT_ID1" size=20 value=""  onKeyPress="return CheckForSpecChars(event)" maxlength="<%=bean.getPatientIDLength()%>" ><input type="button" name="patient_search" id="patient_search" value="?" class="button"                     onClick="callPatientLookup();">
						<input type="hidden" name="P_PAT_ID" id="P_PAT_ID" value="">
						</td>	
			</tr>		
		
			<tr >
						<td class="label"><fmt:message key="ePH.ReasonforReturn.label" bundle="${ph_labels}"/></td>
				        <td colspan="8">&nbsp;&nbsp;<select name="P_REASON_CODE" id="P_REASON_CODE" >
				    	<option value="">&nbsp;&nbsp;--<fmt:message key="ePH.ReasonforReturn.label" bundle="${ph_labels}"/>--&nbsp;&nbsp;</option>
					    <% ArrayList Reason=bean1.getReturnReasoncodes();
						  	if (Reason.size() > 0 )
				            for (int i=0; i<Reason.size(); i+=2) {
	                    %>
			            <OPTION VALUE="<%= Reason.get(i) %>"><%= Reason.get(i+1) %></OPTION>

	                <% 	} %>  

				        </select>
		        		
			</tr>
	<TR><TD colspan="8">&nbsp;</TD>
	</table>
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHPRMDRTSM">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
</form>
		<input type="hidden" name="sql_ph_drug_search_select2" id="sql_ph_drug_search_select2" value="<%=sql_ph_drug_search_select2%>">
		<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
		<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">

</html>
<%  
    putObjectInBean(bean_id,bean,request);
    putObjectInBean(bean_id1,bean1,request);
%>


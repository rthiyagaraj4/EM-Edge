<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
    <script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhRepPrintIVPrescription.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="frmPrescriptionQueryCriteria" id="frmPrescriptionQueryCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String bean_id		= "PrintPrescriptionReportBean" ;
	String bean_name	= "ePH.PrintPrescriptionReportBean";
	PrintPrescriptionReportBean bean = (PrintPrescriptionReportBean)getBeanObject( bean_id,bean_name, request) ;

	String patient_id	=	request.getParameter("patient_id");
	
	String status		= "";
	if(patient_id==null || patient_id.equals("null")) {
		patient_id	=	"";
	} else {
		status		=	"";
	}
	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date date_time	 	= new java.util.Date();
	String Sysdate 				= dtSystemFormat.format(date_time); 
	//code for loading iv legends based ph_param setup 9/27/2005
    ArrayList IVlegends = (ArrayList)bean.getIVLegends();
	String ivlegend_option  = "";	
	for(int i=0;i<=IVlegends.size()-2;i=i+2){		
            ivlegend_option		+=	"<option value='"+((String) IVlegends.get(i))+"'>"+((String) IVlegends.get(i+1))+"</option>"; 
		
	}
	
  //till here
%>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="prescriptionquerycriteriatable">
	<tr>
		<td align="right" class="label"><fmt:message key="ePH.PrescriptionNo.label" bundle="${ph_labels}"/></td>
		<td align="left" >&nbsp;
			<input type="text" name="order_id" id="order_id" maxlength="15" size="20" onKeyPress="changeToUpper()">
		</td>		
		<td align="right" class="label">Order Date From</td>
		<td align="left">&nbsp;
			<input type="text" class="DATE" value="" name="order_date_from" id="order_date_from"  size="10" onBlur="CheckDate(this);DateCheck(sysdate,order_date_from);validate_date(this,'TO_DATE_LESS_FROM')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('order_date_from');"
			onblur="document.forms[0].order_date_from.focus();"> 
		</td>
		<td align="right" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td align="left" >&nbsp;
			<input type="text" name="order_date_to" id="order_date_to" value="" class="DATE" size="10" onBlur="CheckDate(this);DateCheck(sysdate,order_date_to);validate_date(this,'TO_DATE_LESS_FROM')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('order_date_to');" 
			onblur="document.forms[0].order_date_to.focus();">
		</td>		
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;
			<input type="text" name="patient_id" id="patient_id" value="<%=patient_id%>" <%=status%>  maxlength="<%=bean.getPatientIDLength()%>" size="20" onKeyPress="changeToUpper()" >
			<input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()"  <%=status%>>
		</td>
		<td align="right" class="label"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;
			<input type="text" name="nationality" id="nationality" maxlength="20" size="20"  disabled>
		</td>
		<td align="right" class="label"><%=bean.getNationID()%></td>
		<td align="left">&nbsp;
			<input type="text" name="healthCardNo" id="healthCardNo" maxlength="20" size="20" disabled>
		</td>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;
			<input type="text" name="encounter_id" id="encounter_id" maxlength="20" size="20"  >
		</td>
		<td align="right" class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
		<td align="left" >&nbsp;
			<input type="text" name="practitioner_id" id="practitioner_id" maxlength="20" size="20"  >
		</td>
		<td align="right" class="label"><fmt:message key="ePH.IVType.label" bundle="${ph_labels}"/></td>
		<td align="left">&nbsp;
			<select name="iv_type" id="iv_type" >
			   <%=ivlegend_option%>
			</select><img id="mandatory"src="../../eCommon/images/mandatory.gif" ></img>
		</td>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;
			<select name="locn_type" id="locn_type" onChange="resetLocation()">
				<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		<td align="right" class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td align="left" >&nbsp;&nbsp;<input type="text" name="locn_name" id="locn_name" maxlength="20" size="20"  disabled><input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onClick="locationLookup(locn_name)"><input type="hidden" name="locn_code" id="locn_code">
		</td>		
		<td colspan="2" align="right"> 
			<input type="button" name="btnSearch" id="btnSearch" value="Search" class="button" onClick="showResults('<%=patient_id%>')">
		</td>
	</tr>
</table>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	

	<input type="hidden" name="p_order_id" id="p_order_id" value="">
	<input type="hidden" name="p_patclass" id="p_patclass" value="">
	<input type="hidden" name="p_locncode" id="p_locncode" value="">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHPRDPRESIVCONT">
	<INPUT TYPE="hidden" name="p_iv_prep_yn" id="p_iv_prep_yn" VALUE="">
	<INPUT TYPE="hidden" name="p_order_id1" id="p_order_id1" VALUE="">
					<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">

	<% putObjectInBean(bean_id,bean,request); %>
</form>

<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" 
value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">

</body>
<script>
 <% if(!patient_id.equals("")){ %>
 showResults()
 <%	}	%>
</script>
</html>


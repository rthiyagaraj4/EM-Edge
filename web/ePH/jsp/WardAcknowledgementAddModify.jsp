<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
25/03/2019	  	IN067953	        Devindra  											MMS-KH-CRF-0014 [IN:067953] 
28/01/2021	  	TFS:12662	        	Manickavasagam J  											MMS-KH-CRF-0039
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<html>
	<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    String locale			= (String)session.getAttribute("LOCALE");
	  	String login_user	=	(String)session.getValue("login_user");
		String facility_id   = (String)session.getValue( "facility_id" );

	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			<script language="JavaScript" src="../../eCommon/js/common.js"></script>
			<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
			<script language="JavaScript" src="../../ePH/js/WardAcknowledge.js"></script>
			<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
			<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
			<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
			<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			
		 </head>

		<!-- <body> -->
		<body onMouseDown="" onKeyDown="lockKey()">
<%
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
		String bean_id						= "WardAcknowledgeBean"+login_at_ws_no;
		String bean_name	= "ePH.WardAcknowledgeBean";
		
		WardAcknowledgeBean bean = (WardAcknowledgeBean)getBeanObject( bean_id,bean_name,request) ;
		
		String patientClass=CommonBean.checkForNull(request.getParameter("patientcat"));
		String sql_ph_reports_disp_lookup="SELECT A.DISP_LOCN_CODE CODE, A.SHORT_DESC DESCRIPTION FROM PH_DISP_LOCN_LANG_VW A WHERE  UPPER(A.DISP_LOCN_CODE) LIKE UPPER(?) AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND A.EFF_STATUS = 'E' AND LANGUAGE_ID = ";
		String sql_ph_bed_no="SELECT   bed_no CODE, bed_no description FROM ip_nursing_unit_bed WHERE NURSING_UNIT_CODE = '#' AND FACILITY_ID = '$'  and upper(bed_no) like upper(?) and upper(bed_no) like upper(?) AND eff_status = 'E'  ORDER BY 1";
		ArrayList from_and_to_date=bean.getFrom_and_To_date();//added for performance tuning start
		String todate=(String)from_and_to_date.get(0);
		String fromdate=(String)from_and_to_date.get(1);
%>

		<form name="FormWardAcknowlegmentQueryCriteria" id="FormWardAcknowlegmentQueryCriteria" >
			<table cellpadding='1' cellspacing='0' width="100%"  align="center" border="0" >

				<tr>
					<td  class="label" ><fmt:message key="ePH.DispensedFrom.label" bundle="${ph_labels}"/>&nbsp;</td>
					<td align="left" class="label" ><input type=text  name="ward_date_from" id="ward_date_from" size=16 maxlength="16" onBlur="CheckDateLeap(this,'DMYHM','<%=locale%>');" value="<%=fromdate%>">
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar2" onclick="return showCalendarValidate('ward_date_from');"><img align="center" src="../../eCommon/images/mandatory.gif"></img></td>
					<td align="left"class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;</td>
					<td><input type=text  name="ward_date_to" id="ward_date_to" size=16 maxlength="16" onBlur="CheckDateLeap(this,'DMYHM','<%=locale%>');" value="<%=todate%>">
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar3"  onclick="return showCalendarValidate('ward_date_to');">
					<img align="center" src="../../eCommon/images/mandatory.gif"></img></td>	
					<td colspan='3'>&nbsp;</td>
				</tr>
				<!-- FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility -->
				<tr>	
					<td  class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td align="left" class="label"><input type="text" name="patient_id" id="patient_id" size="20"  value='' maxlength="<%=bean.getPatientIDLength()%>" onKeyPress="changeToUpper()" >
					<INPUT TYPE="button" name="patient_button" id="patient_button" VALUE="?" CLASS="button"  onClick="callPatientSearch(document.FormWardAcknowlegmentQueryCriteria.patient_id)" ></td> <!-- <img align="center" src="../../eCommon/images/mandatory.gif"></img> removed for MMS-KH-CRF-0014 [IN:067953] -->
					<td  class="label" ><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></td>
					<td align="left" class="label"><input type="text" name="dispense_no" id="dispense_no" size="15"  maxlength="15" ></td>	
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
					<td align="left" class="label"><input type="text" name="dispense_location" id="dispense_location" size="30" maxlength="20" onBlur=""><INPUT TYPE="button" name="disp_locn_button" id="disp_locn_button" VALUE="?" CLASS="button"  onclick="locationLookup(dispense_location);" ></td>
					</td>
					
					<td  class="label" ><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
					<td align="left" class="label"><input type="text" name="order_id" id="order_id" size="15"  maxlength="15" ></td>	
					
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					<td align="left" class="label"><input type="text" name="nursing_unit" id="nursing_unit"  STYLE='overflow:visible;' onBlur=""><INPUT TYPE="button" name="nursunit_button" id="nursunit_button" VALUE="?" CLASS="button" onclick="locationLookup(nursing_unit)"></td><!--size="40" maxlength="30" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
					</td>
					
					<td  class="label" ><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
					<td align="left" class="label"><input type="text" name="bed_no" id="bed_no" size="15" maxlength="20" onBlur=""><input type="button" name="bed_search" id="bed_search" id ='bed_search' value="?" class="button"  onClick="locationLookup(bed_no)"></td>	
					
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
					<td align="left" class="label"><SELECT name="status" id="status" >
					<OPTION value="NA">Not Acknowledged</OPTION>
					<OPTION value="A">Acknowledged</OPTION>
					</SELECT>&nbsp;
					</td>
					<!-- added for MMS-KH-CRF-0039 -start-->
					<td  class="label" ><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
					<td align="left" class="label"><SELECT name="order_type" id="order_type" >
					<OPTION value="O" selected>Other Order Types</OPTION>
					<OPTION value="A">Admixture</OPTION>
					</SELECT>&nbsp;
					</td>
					<!-- added for MMS-KH-CRF-0039 -end-->
				</tr>
				<tr>
				<td  class="label" ><fmt:message key="ePH.WorksheetID.label" bundle="${ph_labels}"/></td>
					<td align="left" class="label"><input type="text" name="worksheet_id" id="worksheet_id" size="15"  maxlength="15" ></td>	
				<td  class="button" colspan="3" align="right">
					<input type="button" class="button"  name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'onclick="callResultPage();" >&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
		</table>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
		<input type="hidden" name="displocn_code" id="displocn_code" value='' >
		<input type='hidden' value='' name='nursing_unit_code' id='nursing_unit_code'>
		<input type='hidden' value='' name='bed_no_code' id='bed_no_code'>
		<input type="hidden" name="facility_id" id="facility_id" value=<%=facility_id%> >
		<input type="hidden" name="p_language_id" id="p_language_id" value=<%=locale%> >
		<input type="hidden" name="Ward_Date_From_hidden" id="Ward_Date_From_hidden" value='' >
		<input type="hidden" name="FormStore" id="FormStore" value="" >
		<input type="hidden" name="patientClass" id="patientClass" value=<%=patientClass%> >  
		<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">
		<INPUT TYPE="hidden" name="SQL_PH_REPORTS_DISP_LOOKUP" id="SQL_PH_REPORTS_DISP_LOOKUP" VALUE="<%=sql_ph_reports_disp_lookup%>">
		<INPUT TYPE="hidden" name="sql_ph_bed_no" id="sql_ph_bed_no" VALUE="<%=sql_ph_bed_no%>">
		<input type="hidden" name="systemdate" id="systemdate" value="<%=todate%>">
		<input type="hidden" name=onch value=""><!--Added for GHL-CRF-0399  [IN062299]-->
<% 
		putObjectInBean(bean_id,bean,request); 
%>
		</form>
	
	</body>
</html>


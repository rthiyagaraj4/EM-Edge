<!DOCTYPE html>
<%-- JSP Page specific attributes start  This file is saved on 04/06/2007  --%>

<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>

		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/DateUtils.js"></SCRIPT>
		<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="javascript" src="../../ePH/js/ReRoutePrescription.js"></script>
		<script LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<%
		String bean_id				= "ReRoutePrescriptionsBean";
		String bean_name			= "ePH.ReRoutePrescriptionsBean";
		ReRoutePrescriptionsBean bean		= (ReRoutePrescriptionsBean)getBeanObject( bean_id,bean_name,request);
		//String drug_code="";	
		//String drug_desc="";	
		String mode=request.getParameter("mode");
		String re_route_via_reg_ord = request.getParameter("re_route_via_reg_ord")==null?"": request.getParameter("re_route_via_reg_ord");
		String patient_id = request.getParameter("patient_id")==null?"": request.getParameter("patient_id");
		String disp_locn_code = request.getParameter("disp_locn_code")==null?"": request.getParameter("disp_locn_code");
		//bean.clear();
		
		bean.setMode(mode);
	   // bean.setLanguageId(locale);
		String facility_id   = (String)session.getValue( "facility_id" );
		String login_user	= (String)session.getValue("login_user");
		ArrayList disp_locn		=	bean.getDispLocnList(facility_id,login_user,locale);
%>
		<form name="formReRoutePrescriptions" id="formReRoutePrescriptions">
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<!-- the below fields are commented for Bru-HIMS-CRF-090 [IN:029956]
				<tr>
						<td align="right"  nowrap class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
						<td align="left"><select name="disp_locn" id="disp_locn">
						<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
						<% for(int i=0; i<disp_locn.size();  i+=2) { %>
						<option value="<%=(String)disp_locn.get(i)%>"><%=(String)disp_locn.get(i+1)%></option>
						<%	}	%>
						</select><img src="../../eCommon/images/mandatory.gif" align="center"></img> 
						</td>
					 <td  class="label"></td>
					 <td  class="label"></td>
				</tr>
				<tr>
					
					<td class="label"  align="left"><fmt:message key="Common.OrderDateFrom.label" bundle="${common_labels}"/></td>
					<!-- //showCalendar('dt_from',null,'hh:mm') changed to showCalendar('dt_from') for  SRR20056-SCF-7725
					<td align="left" ><input type="text" maxlength="16" size="16" name="dt_from" id="dt_from" OnBlur='ValidateFromDate(this)'><input type="image" SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('dt_from');document.formReRoutePrescriptions.dt_from.focus();
					return false;" ><img src="../../eCommon/images/mandatory.gif"  align="center">
					<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;&nbsp;<input type="text" maxlength="16" size="16" name="dt_to" id="dt_to" OnBlur='ValidateToDate(this)'><INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif"
					id=Calendar onclick="showCalendar('dt_to');document.formReRoutePrescriptions.dt_to.focus();
					return false;"><img src="../../eCommon/images/mandatory.gif" align="center"></td>
					<td class="label"></td>
					<td class="label"></td>
					
				</tr> -->
				<tr>
<% 
				if(re_route_via_reg_ord.equals("Y")){// if condition is  added for Bru-HIMS-CRF-090 [IN:029956]
%>
					<input type='button'  value='Apply' class='button' onclick="apply();">
<%
				}
%>
				</tr>
				<tr>
					 <td  class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> &nbsp;</td>
					 <td nowrap>
						<input type="text" name="patient_id" id="patient_id"  maxlength="<%=bean.getPatientIDLength()%>"  onBlur='callPatientLin(patient_id);checkValue(this);chkPatientID()'  onKeyPress="return CheckForSpecChars(event);changeToUpper()" value="<%=patient_id%>"><input valign='top' type='button' name='patient_search' id='patient_search' value='?' class='button'onClick="callPatientLookup();">&nbsp;<img src="../../eCommon/images/mandatory.gif">
						<input type="text" size ="30" name="patient_name" id="patient_name"  id="patient_detail" readonly>
					</td>
					<td  class="label"></td>	
					<td  class="label"></td>	
				</tr>
				<tr>
					 <td  class="label"  ><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
					<td><input type="text" maxlength="25" size="25" name="OrderId" id="OrderId" onKeyPress="return CheckForSpecChars(event)" value="" ></td>
					<td > 
					  <input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="callResultPage()">
					</td>
					<td  class="label"></td>
				</tr>
			</table>
			<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="re_route_via_reg_ord" id="re_route_via_reg_ord" value="<%=re_route_via_reg_ord%>"> <!-- added for Bru-HIMS-CRF-090 [IN:029956] -->
			<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>"> <!-- added for Bru-HIMS-CRF-090 [IN:029956] -->
		</form>
	</BODY>
<%
	if(!patient_id.equals("")){
%>
		<script>
			callPatientLin(document.formReRoutePrescriptions.patient_id);
			checkValue(this);
			chkPatientID();
			callResultPage();
		</script>
<%
	}
	putObjectInBean(bean_id,bean,request);
%>
</html>


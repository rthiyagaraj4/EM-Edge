<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
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
		String bean_id				= "NPBRequestApproveRejectBean";
		String bean_name			= "ePH.NPBRequestApproveRejectBean";
		NPBRequestApproveRejectBean bean		= (NPBRequestApproveRejectBean)getBeanObject( bean_id,bean_name,request);
		SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date_time	 	= new java.util.Date();
		String Sysdate 				= dtSystemFormat.format(date_time); 
		String SQL_SELECT_PRACT=PhRepository.getPhKeyValue("SQL_PH_DISP_LOCN_SELECT10");
		String homepage = request.getParameter("homepage")==null?"":request.getParameter("homepage") ; //Added for Bru-HIMS-CRF-073.1 [IN:047222]
		String status = request.getParameter("status")==null?"":request.getParameter("status") ; //Added for Bru-HIMS-CRF-073.1 [IN:047222]
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../js/NPBRequestApproveReject.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY onKeyDown = 'lockKey()' > 
		<form name='NPBRequestQueryCriteria' id='NPBRequestQueryCriteria'>
			<table cellpadding=0 cellspacing=0 width="100%" align="center" border='0'>
				<tr>
					<td class='label' width='15%'>
						<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
					</td>
					<td class='label' width='30%'>
						<input type="text" name="patient_id" id="patient_id" maxlength="<%=bean.getPatientIDLength()%>"  onKeyPress="changeToUpper()" value="" >
						<input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID"   onClick="callPatientSearch()">
					</td>
					<td class='label' width='15%'> 
						<fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/>
					</td>
					<td class='label' width='30%'>
						<input type="text" name="req_pract_name" id="req_pract_name" value="" readonly><input type="button" value="?" class="button" name="btnpractsearch" id="btnpractsearch"   onClick="searchPractioner()" >
						<input type='hidden' name='req_pract_id' id='req_pract_id' value=''/>
					</td>
					<td class='label' width='10%'>&nbsp;</td>
				</tr>
				<tr>
					<td class='label' width='15%'>
						<fmt:message key="Common.Drug.label" bundle="${common_labels}"/>
					</td>
					<td class='label' width='35%'>
						<input type="text" name="DrugName" id="DrugName" size="42"  maxlength="42" value=""> 
						<input type="button" name="DrugSearch" id="DrugSearch" value="?" class="button"  onClick="searchDrugName();" >&nbsp;
						<input type='hidden' name='DrugCode' id='DrugCode' value=''>
					</td>
					<td class='label' width='15%'> 
						<fmt:message key="Common.RequestStatus.label" bundle="${common_labels}"/>
					</td>
					<td class='label' width='35%'>
						<select name='reqStatus' id='reqStatus'>
							<option value='AL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<option value='R' selected><fmt:message key="Common.Requested.label" bundle="${common_labels}"/></option>
							<option value='A'><fmt:message key="ePH.Acknowledged.label" bundle="${ph_labels}"/></option>
							<option value='P'><fmt:message key="Common.Approved.label" bundle="${common_labels}"/></option>
							<option value='J'><fmt:message key="Common.Rejected.label" bundle="${common_labels}"/></option>
						</select>
					</td>
				</tr>
				<tr>
					<td class='label' width='15%'>
						<fmt:message key="Common.requesteddate.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>
					</td>
					<td class='label' width='35%'>
						<input type="text" maxlength="10" size="10" name="dt_from" id="dt_from" OnBlur='ValidateFromDate(this, "<%=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale)%>","<%=locale%>")' value='<%=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale)%>'><!--Replace SysDate to <%=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale) %> by manickam-->
						<IMG SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar' onclick="return showCalendar('dt_from');" >
						<img src="../../eCommon/images/mandatory.gif"  align="center">&nbsp;&nbsp;&nbsp;
						<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;&nbsp;
						<input type="text" maxlength="10" size="10" name="dt_to" id="dt_to" OnBlur='ValidateToDate(this,"<%=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale)%>","<%=locale%>")' value='<%=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale)%>'><!--Replace SysDate to <%=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale)%> by manickam-->
						<IMG SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar' onclick="return showCalendar('dt_to');" >
						<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
					<td class='label' colspan='3'>&nbsp;</td>
				</tr>
				<tr>
					<td class='label' colspan='4' style='text-align:right;' >&nbsp;</td> 
					<td class='label' width='10%' style='text-align:right;' > 
						<input type="button" name="btnSearchNPBReq" id="btnSearchNPBReq" value='<fmt:message key="Common.Refresh.label" bundle="${common_labels}"/>' class="button"  onClick="searchNPBReq();" >
					</td>
				</tr>
			</table>
			<input type='hidden' name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type='hidden' name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="SQL_SELECT_PRACT" id="SQL_SELECT_PRACT"	value="<%=SQL_SELECT_PRACT%>">
			<input type="hidden" name="locale" id="locale"	value="<%=locale%>">
			<input type="hidden" name="homepage" id="homepage"	value="<%=homepage%>">
		</form>
	</body>
<% 
	putObjectInBean(bean_id,bean,request); 
%>
	<script> // block added for Bru-HIMS-CRF-073.1 [IN:047222] 
<%
		if(!status.equals("") && !homepage.equals("")){
%>
			document.NPBRequestQueryCriteria.reqStatus.value='<%=status%>'
			document.NPBRequestQueryCriteria.btnSearchNPBReq.click();
<%
		}
%>
	</script>
</html>


<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<% 
	try{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String ReqType = request.getParameter("ReqType")==null?"N":request.getParameter("ReqType");
		String location_type = request.getParameter("location_type")==null?"":request.getParameter("location_type");
		String location_code = request.getParameter("location_code")==null?"":request.getParameter("location_code");
		String pract_id = request.getParameter("pract_id")==null?"":request.getParameter("pract_id");
		String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		SimpleDateFormat dtTimeSystemFormat = new SimpleDateFormat("dd/MM/yyyy HH:MM");
		SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date_time	 	= new java.util.Date();
		String SysdateTime 				= dtTimeSystemFormat.format(date_time); 
		String Sysdate 				= dtSystemFormat.format(date_time); 
		String locale = (String) session.getAttribute("LOCALE");
		String bean_id					= "@NPBRequestBean"+patient_id+encounter_id;
		String bean_name				= "ePH.NPBRequestBean";
		NPBRequestBean bean			= (NPBRequestBean)getBeanObject(bean_id,bean_name,request);
		bean.clear();
		String SQL_PH_SELECT_NPB_DRUG_LOOKUP = PhRepository.getPhKeyValue("SQL_PH_SELECT_NPB_DRUG_LOOKUP");
		bean.setLanguageId(locale);
		bean.loadNPBFormsList();
		ArrayList NPBFormList = bean.getNPBFormsList();
		ArrayList QuantityUOMList = bean.loadQuantityUOM();
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../js/NPBRequest.js"></script>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown = 'lockKey()'>
		<form name='NPBRequestDetail' id='NPBRequestDetail'>
			<br>
<%
			if(ReqType.equals("N")){
%>
				<table cellpadding=0 cellspacing=0 width="100%" align="center" border='0'>
					<tr >
						<td width='10%' nowrap class='label'>
							<fmt:message key="Common.Drug.label" bundle="${common_labels}"/>
						</td>
						<td width='25%' nowrap class='label'>
							<input type="text" name="DrugName" id="DrugName" size="42"  maxlength="42" value="" onblur="checkDrug();"> 
							<input type="button" name="DrugSearch" id="DrugSearch" value="?" class="button"  onClick="searchDrugNameCLP('N');" ><img  src="../../eCommon/images/mandatory.gif"></img>
							<input type='hidden' name='DrugCode' id='DrugCode' value=''>
						</td>
						<td width='10%' nowrap class='label'>
							<fmt:message key="Common.Request.label" bundle="${common_labels}"/> &nbsp;<fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>
						</td>
						<td width='25%' nowrap class='label'> 
							<input class='NUMBER' type="text" size="3" maxlength="3" name="reqQty" id="reqQty" value="" onKeyPress="return(ChkNumberInput(this,event,'0'))" > &nbsp;&nbsp;
							<select name="qty_desc" id="qty_desc" style="width:110;" >
								<option value="" selected >&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<%
							if(QuantityUOMList !=null && QuantityUOMList.size()>0){
								for(int i=0; i < QuantityUOMList.size(); i+=3){
%>
									<option value='<%=(String)QuantityUOMList.get(i)%>'><%=(String)QuantityUOMList.get(i+1)%></option>
<%
								}
							}
%>
							</select><!--<img  src="../../eCommon/images/mandatory.gif"></img>--> <!-- -Cmmented for ML-BRU-SCF-0367 [IN:034747]-->
						</td>
						<td width='10%' nowrap class='label'> <fmt:message key="ePH.ValidityPeriod.label" bundle="${ph_labels}"/>
						</td>
						<td width='20%' nowrap class='label'> 
							<input type="text" size="1" maxlength="3" name="validity" id="validity" class="NUMBER"  value="" onKeyPress="return(ChkNumberInput(this,event,'0'))" >
							<select name='ValidityDesc' id='ValidityDesc' >
								<option value='D' selected><fmt:message key="Common.Day(s).label" bundle="${common_labels}"/></option>
								<option value='W' ><fmt:message key="ePH.WEEKS.label" bundle="${ph_labels}"/></option>
								<option value='M' ><fmt:message key="ePH.MONTHS.label" bundle="${ph_labels}"/></option>
								<option value='Y' ><fmt:message key="ePH.years.label" bundle="${ph_labels}"/></option>
							</select>
						</td>
					</tr>
					<tr >
						<td width='10%' nowrap class='label'> <fmt:message key="ePH.RequestForm.label" bundle="${ph_labels}"/>
						</td>
						<td width='25%' nowrap class='label'>
							<select name="NPBForm" id="NPBForm" style="width:175;" onchange="EnableNBPFormLink(this)">
							<option value='' selected>&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
<%
							if(NPBFormList !=null && NPBFormList.size()>0){
								for(int i=0; i < NPBFormList.size(); i+=2){
%>
									<option value='<%=(String)NPBFormList.get(i)%>'><%=(String)NPBFormList.get(i+1)%></option>
<%
								}
							}
%>
							</select><img  src="../../eCommon/images/mandatory.gif"></img>&nbsp;
							<a  href="javascript:openNPBForm();" id="NBPFormLink"  style="font-size:9;visibility:hidden;" ><fmt:message key="ePH.NPBRequestForm.label" bundle="${ph_labels}"/></a>
						</td>
							<td width='10%' nowrap class='label'> <fmt:message key="Common.RequestDate.label" bundle="${common_labels}"/>
						</td>
						<td width='20%' nowrap class='label'> <input type="text" name="reqDate" id="reqDate" size="16"  maxlength="16" onblur="ValidateReqDate(this,'<%=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale)%>','<%=locale%>');" value="<%=com.ehis.util.DateUtils.convertDate(SysdateTime,"DMYHM","en",locale)%>" ><img SRC="../../eCommon/images/CommonCalendar.gif" name='reqDateImg' onclick="return showCalendar('reqDate',null,'HH:mm');"><img  src="../../eCommon/images/mandatory.gif"></img><!--Replace SysDate to <%=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale)%> and SysdateTime to <%=com.ehis.util.DateUtils.convertDate(SysdateTime,"DMYHM","en",locale)%> by manickam -->
						</td>
						<td colspan='2' nowrap class='label'> &nbsp;
						</td>
					</tr>
				</table>
				<br>
				<br>
				<table cellpadding=0 cellspacing=0 width="100%" align="center" border='0'>
					<tr>
						<td style='text-align:right;'>
							<input class='button' type='button' name='Confirm' id='Confirm' value='<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>' onclick='ConfirmRequset()'>
							<input class='button'  type='button' name='Cancel' id='Cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick='CancelRequset()'>
						</td>
					</tr>
				</table>
				<input type='hidden' name="mode" id="mode" value="1">
<%
			}
			else{
%>
				<table cellpadding=0 cellspacing=0 width="100%" align="center" border='0'>
					<tr>
						<td class='label' width='15%'>
							<fmt:message key="Common.Request.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>
						</td>
						<td class='label' width='30%'>
							<input type="text" maxlength="14" size="12" name="dt_from" id="dt_from" OnBlur='ValidateFromDate(this, "<%=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale)%>","<%=locale%>")' value='<%=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale)%>'>
							<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from');" ><img  src="../../eCommon/images/mandatory.gif"></img>
							<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;&nbsp;
							<input type="text" maxlength="14" size="12" name="dt_to" id="dt_to" OnBlur='ValidateToDate(this,"<%=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale)%>","<%=locale%>")' value='<%=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale)%>'><!--Replace SysDate to <%=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale)%>  by manickam -->
							<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to');" ><img  src="../../eCommon/images/mandatory.gif"></img>
						</td>
						<td width='15%' nowrap class='label'>
							<fmt:message key="Common.Drug.label" bundle="${common_labels}"/>
						</td>
						<td width='30%' nowrap class='label'>
							<input type="text" name="DrugName" id="DrugName" size="42"  maxlength="42" value=""> 
							<input type="button" name="DrugSearch" id="DrugSearch" value="?" class="button"  onClick="searchDrugNameCLP('E');" >
							<input type='hidden' name='DrugCode' id='DrugCode' value=''>
						</td>
						<td class='label' width='10%'>&nbsp;</td>
					</tr>
					<tr >
						<td class='label' width='15%'>
							<fmt:message key="ePH.NPBRequestForm.label" bundle="${ph_labels}"/>
						</td>
						<td class='label' width='30%'>
							<select name="NPBForm" id="NPBForm" style="width:175;" >
							<option value='' selected>&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
<%
							if(NPBFormList !=null && NPBFormList.size()>0){
								for(int i=0; i < NPBFormList.size(); i+=2){
%>
									<option value='<%=(String)NPBFormList.get(i)%>'><%=(String)NPBFormList.get(i+1)%></option>
<%
								}
							}
%>
							</select>
						</td>
						<td class='label' width='15%'> 
							<fmt:message key="Common.RequestStatus.label" bundle="${common_labels}"/>
						</td>
						<td class='label' style="width:175;">
							<select name='reqStatus' id='reqStatus' width='20'>
								<option value='AL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
								<option value='A'><fmt:message key="ePH.Acknowledged.label" bundle="${ph_labels}"/></option>
								<option value='P'><fmt:message key="Common.Approved.label" bundle="${common_labels}"/></option>
								<option value='C'><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></option>
								<option value='J'><fmt:message key="Common.Rejected.label" bundle="${common_labels}"/></option>
								<option value='R'><fmt:message key="Common.Requested.label" bundle="${common_labels}"/></option>
							</select>
						</td>
						<td class='label' width='10%'>&nbsp;</td>
					</tr>
					<tr>
						<td class='label' colspan='4' style='text-align:right;' >&nbsp;</td> 
						<td class='label' width='10%' style='text-align:right;' > 
							<input type="button" name="btnSearchNPBReq" id="btnSearchNPBReq" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button"  onClick="searchNPBReq();" >
						</td>
					</tr>
				</table>
				<input type='hidden' name="mode" id="mode" value="2">
<%
			}
%>
			<input type='hidden' name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type='hidden' name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type='hidden' name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type='hidden' name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
			<input type='hidden' name="location_type" id="location_type" value="<%=location_type%>">
			<input type='hidden' name="location_code" id="location_code" value="<%=location_code%>">
			<input type='hidden' name="pract_id" id="pract_id" value="<%=pract_id%>">
			<input type='hidden' name="locale" id="locale" value="<%=locale%>">
			<input type='hidden' name="SQL_PH_SELECT_NPB_DRUG_LOOKUP" id="SQL_PH_SELECT_NPB_DRUG_LOOKUP" value="<%=SQL_PH_SELECT_NPB_DRUG_LOOKUP%>">
		</form>
	</body>
<%
	putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html> 


<!DOCTYPE html>
<!--
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*  
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
06/05/2021		TFS-15598       Prabha          MOHE-CRF-0074
---------------------------------------------------------------------------------------------------------------
*/ --> 

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"
	import="java.util.*,ePH.*,ePH.Common.*,eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*,java.text.*,webbeans.eCommon.*"%>

<html>
<head>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String locale = (String) session.getAttribute("LOCALE");
	String p_user_name= (String) session.getValue( "login_user" ) ;	 //Added for MOHE-CRF-0074
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css'></link>
<link rel="stylesheet" type="text/css"
	href="../../eCommon/html/CommonCalendar.css"></link>
<!-- import the calendar script -->
<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script LANGUAGE="javascript"
	src="../../ePH/js/PhStatDrugInfoCriteria.js"></script>
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
<script LANGUAGE="javascript" src="../../ePH/js/PhCommon.js"></script>
<!-- 	<script LANGUAGE="javascript" src="../js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 -->
</head>

<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	
	//Added for MOHE-CRF-0074 - End
	
String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String mode = request.getParameter("mode") == null ? "" : request
			.getParameter("mode");
	String bean_id = "PhDrugInfoEnqBean";
	String bean_name = "ePH.PhDrugInfoEnqBean";
	PhDrugInfoEnqBean bean = (PhDrugInfoEnqBean) getBeanObject(bean_id,
			bean_name, request);
	bean.setLanguageId(locale);
	String Sysdate = "";
	String selOrderFcy = "";
	ArrayList facilities = null;
	bean.setMode(mode);
	facilities = bean.getFacilities();
	Sysdate = bean.getSysdate();
	ArrayList reqCatg = bean.getRequestCatg();
	HashMap InfoDtl = new HashMap();

	ArrayList InfoSourceDtl = new ArrayList();

	bean.setLanguageId(locale);
	InfoDtl = bean.getInfoSource();
	InfoSourceDtl = (ArrayList) InfoDtl.get("INFO_CAT_CODE");
	
	String order_facility_id="" , order_facility_name=""; //Added for MOHE-CRF-0074
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheckNew(region_code); //Added for MOHE-CRF-0074 //Modified for MOHE-CRF-0074

	%>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">

	<form name="formPhStatDrugInfoCriteria" id="formPhStatDrugInfoCriteria"
		ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">

		<table cellpadding="0" cellspacing="0" width="100%" align="center"
			border="0">
			<TH COLSPAN="4" ALIGN="left"><fmt:message
					key="Common.reportcritera.label" bundle="${common_labels}" /></TH>
			<tr>
				<td class="label"><fmt:message
						key="Common.FacilityName.label" bundle="${common_labels}" /></td>
				<td COLSPAN="3" align="left"><SELECT name="p_facility_code" id="p_facility_code">
						<OPTION VALUE="">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---
							<fmt:message key="Common.defaultSelect.label"
								bundle="${common_labels}" />
							---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</OPTION>
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
							if (facilities.size() > 0)
								for (int i = 0; i < facilities.size(); i += 2) {
						%>
						<OPTION VALUE="<%=facilities.get(i)%>"><%=facilities.get(i + 1)%></OPTION>

						<%
							}
						} //Added for MOHE-CRF-0074
						%>
				
			</tr>

			<tr>
				<td  class="label"><fmt:message
						key="Common.fromdate.label" bundle="${common_labels}" /></td>
				<td align="left"><input type="text" size="10"
					maxlength="10" name="p_dt_from" id="p_dt_from" OnBlur='CheckDate(this)'><INPUT
					TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif"
					id=Calendar onclick="return showCalendar('p_dt_from');">&nbsp;<img
					src="../../eCommon/images/mandatory.gif" align="center">
					&nbsp;&nbsp;
				</td>
				<td class="label"><fmt:message
						key="Common.todate.label" bundle="${common_labels}" />&nbsp;</td>
				<td><input type="text" size="10" maxlength="10"
					name="p_dt_to" id="p_dt_to" OnBlur='CheckDate(this)'><INPUT TYPE="image"
					SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar
					onclick="return showCalendar('p_dt_to');">&nbsp;<img
					src="../../eCommon/images/mandatory.gif" align="center"></td>
				<!--dt_from to p_dt_from AND dt_to to p_dt_to Added for DateConversion identification -->
			</tr>
			<tr>
				<td  class="label"><fmt:message
						key="ePH.ReportFor.label" bundle="${ph_labels}" /></td>
				<td align="left"><select name="report_for" id="report_for"
					onChange="parent.disableLocation(this.value)">
						<option value="DIE">
							<fmt:message key="ePH.DrugInformationEnquiry.label"
								bundle="${ph_labels}" />
							&nbsp;&nbsp;&nbsp;&nbsp;
						</option>
						<option value="ADR">
							<fmt:message key="ePH.AdverseDrugReaction.label"
								bundle="${ph_labels}" />
						</option>
				</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
				</td>
				<td  class="label"><fmt:message
						key="Common.ReportBy.label" bundle="${common_labels}" /></td>
				<td COLSPAN="3" align="left"> <select name="report_by" id="report_by"
					onChange="parent.disableLocation(this.value)">
						
						<option value="RC">
							<fmt:message key="ePH.Requestcategory.label"
								bundle="${ph_labels}" />
						</option>
						<option value="SR">
							<fmt:message key="ePH.SourceOfRequest.label"
								bundle="${ph_labels}" />
						</option>
						<option value="IS">
							<fmt:message key="ePH.InformationSource.label"
								bundle="${ph_labels}" />
						</option>
				</select><img src="../../eCommon/images/mandatory.gif" align="center"
					name="reportby_img"></td>
			</tr>
			<tr>
				<td  class="label"><fmt:message
						key="ePH.Requestcategory.label" bundle="${ph_labels}" />&nbsp;</td>
				<td  align="left" class="label">
				<SELECT size="6" name="req_catg" id="req_catg" multiple="multiple" ><OPTION
							value="">
							&nbsp;---
							<fmt:message key="Common.defaultSelect.label"
								bundle="${common_labels}" />
							---&nbsp;
						</OPTION>
						<%
							StringTokenizer st = null;
							selOrderFcy = "";
							String req_code = "";
							for (int i = 0; i < reqCatg.size(); i += 2) {
								req_code = (String) reqCatg.get(i);
								st = new StringTokenizer(req_code, "**");
								req_code = st.nextToken();
						%>
						<OPTION <%=selOrderFcy%> VALUE="<%=req_code%>"><%=reqCatg.get(i + 1)%></OPTION>
						<%
							}
						%>
				</select></td>
				
				<td  class="label"><fmt:message
						key="ePH.InformationSource.label" bundle="${ph_labels}" /></td>
				<td COLSPAN="3" align="left"><SELECT name="info_source_dtl" id="info_source_dtl" multiple="multiple" disabled="true">
						<OPTION VALUE="">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---
							<fmt:message key="Common.defaultSelect.label"
								bundle="${common_labels}" />
							---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</OPTION>
						<%
							if (InfoSourceDtl.size() > 0)
								for (int i = 0; i < InfoSourceDtl.size(); i += 2) {
						%>
						<OPTION VALUE="<%=InfoSourceDtl.get(i)%>"><%=InfoSourceDtl.get(i + 1)%></OPTION>

						<%
							}
						%>
				
			</tr>


			<tr>
				<td  class="label"><fmt:message
						key="ePH.SourceOfRequest.label" bundle="${ph_labels}" />&nbsp;&nbsp;</td>
				<td COLSPAN="3" align="left"><SELECT name="Source" id="Source" multiple="multiple"
					disabled="true">
						<OPTION value="">
							&nbsp;---
							<fmt:message key="Common.defaultSelect.label"
								bundle="${common_labels}" />
							---&nbsp;
						</OPTION>
						<OPTION value="WF">
							<fmt:message key="ePH.WithinFacility.label" bundle="${ph_labels}" />
							&nbsp;&nbsp;&nbsp;&nbsp;
						</OPTION>
						<OPTION value="OF">
							<fmt:message key="ePH.OtherEnterpriseFacility.label"
								bundle="${ph_labels}" />
							&nbsp;&nbsp;&nbsp;&nbsp;
						</OPTION>
						<OPTION value="EF"> 
							<fmt:message key="Common.externalfacility.label"
								bundle="${common_labels}" />
							&nbsp;&nbsp;&nbsp;&nbsp;
						</OPTION>
						<OPTION value="PC">
							<fmt:message key="ePH.Public.label" bundle="${ph_labels}" />
							&nbsp;&nbsp;&nbsp;&nbsp;
						</OPTION>&nbsp;
				</select>
				</td>
			
				
			</tr>
		</table>

		<INPUT TYPE="hidden" name="p_user_name" id="p_user_name"	VALUE="<%=session.getValue("login_user")%>">
		<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
		<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
		<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
		<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
		<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE="">
		<!--Added for DateConversion identification -->
		<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE="">
		
		<!--Added for DateConversion identification -->
		<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%=p_facility_id%>">
		<INPUT TYPE="hidden" name="p_where" id="p_where" VALUE="">
		

	</form>
	<%
		putObjectInBean(bean_id, bean, request);
	%>
</body>
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
</html>


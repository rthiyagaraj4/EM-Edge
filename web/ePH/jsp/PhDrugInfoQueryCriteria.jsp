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
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %> <!-- Modified for MOHE-CRF-0074 -->
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
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
		String facility_id   = (String)session.getValue( "facility_id" );//Added for MOHE-CRF-0074
		String login_user	=	(String)session.getValue("login_user"); //Added for MOHE-CRF-0074
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhDrugInfo.js"></script>   
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>	
<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	// Added for MOHE-CRF-0074 - END
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String bean_id			= "PhDrugInfoEnqBean" ;
	String bean_name		= "ePH.PhDrugInfoEnqBean";
	PhDrugInfoEnqBean bean = (PhDrugInfoEnqBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	String Sysdate="";
	ArrayList facilities = null;
	bean.setMode(mode) ;
	facilities = bean.getFacilities();
	Sysdate		=bean.getSysdate();
	ArrayList reqCatg	=bean.getRequestCatg();
	ArrayList practType	=bean.getPractType();
	Sysdate= bean.getSysDateWithoutTime();
	String selOrderFcy = "", ord_fac_code=""; //Moved from bottom for MOHE-CRF-0074
	String order_facility_id = "" , order_facility_name =""; //Added for MOHE-CRF-0074
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheck(login_user,region_code); //Added for MOHE-CRF-0074
	//	Sysdate=com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
		<form name="formDrugInfoQueryCriteria" id="formDrugInfoQueryCriteria" TARGET="messageFrame">
			<table cellpadding="0" cellspacing="0"  border="0" width="100%" align="center">
				<tr>
					<td class="COLUMNHEADERCENTER" colspan="4" height='12'> <fmt:message key="ePH.DrugInformationQueryCriteria.label" bundle="${ph_labels}"/> </td>
				</tr>
				<tr>
					<td class="label" width="18%" nowrap colspan='1'><fmt:message key="ePH.EnquiryDateFrom.label" bundle="${ph_labels}"/></td>
					<td class="label" width="32%"><input type='text'  name='enq_date_from' id='enq_date_from' size='8' value="" maxlength="10" Onblur="CheckDate(this);DateCheck(sysdate,enq_date_from);validate_date(this,'TO_DATE_LESS_FROM')">&nbsp;<IMG  SRC="../../eCommon/images/CommonCalendar.gif"  id="adrreportdate" onclick="return showCalendar('enq_date_from');"onblur="document.forms[0].enq_date_from.focus();">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;&nbsp;&nbsp;<label class='label'><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;<input type='text'  name='enq_date_to' id='enq_date_to' size='8' value="" maxlength="10" onblur="CheckDate(this);DateCheck(sysdate,enq_date_to);validate_date(this,'TO_DT_GR_EQ_FM_DT');">&nbsp;<IMG SRC="../../eCommon/images/CommonCalendar.gif"  id="adrreportdate1" onclick="return showCalendar('enq_date_to');"onblur="document.forms[0].enq_date_to.focus();">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>
					</td>
					<td class="label" width="18%" nowrap colspan='1'><fmt:message key="ePH.RespondDateFrom.label" bundle="${ph_labels}"/> </td>
					<td class="label" width="32%"><input type='text'  name='respond_date_from' id='respond_date_from' size='8' value="" maxlength="10" Onblur="CheckDate(this);DateCheck(sysdate,respond_date_from);validate_date(this,'TO_DATE_LESS_FROM1')">&nbsp;<IMG  SRC="../../eCommon/images/CommonCalendar.gif"  id="adrreportdate" onclick="return showCalendar('respond_date_from');"onblur="document.forms[0].respond_date_from.focus();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label class='label'><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;<input type='text'  name='respond_date_to' id='respond_date_to' size='8' value="" maxlength="10" onblur="CheckDate(this);DateCheck(sysdate,respond_date_to);validate_date(this,'TO_DT_GR_EQ_FM_DT1');">&nbsp;<IMG  SRC="../../eCommon/images/CommonCalendar.gif"  id="adrreportdate1" onclick="return showCalendar('respond_date_to');"onblur="document.forms[0].respond_date_to.focus();">
					</td>
				</tr>
				  <tr> 
					 <td class="label" ><fmt:message key="ePH.SourceOfRequest.label" bundle="${ph_labels}"/>&nbsp;</td> 
					 <td class="label" ><SELECT name="source" id="source" ><OPTION value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</OPTION>
<%
				//MOHE-CRF-0074-Start 
					if(region_check){ 
						for (int j=0;j<region_code_check.size();j+=2){
							order_facility_id=(String)region_code_check.get(j);
							order_facility_name=(String)region_code_check.get(j+1);
							if(facility_id.equals(order_facility_id))	{
%>
					<option value='<%=order_facility_id%>' selected><%=order_facility_name%></option>
<%
						}
						else{
%>
					<option value='<%=order_facility_id%>'><%=order_facility_name%></option>
<%
								}
							}
					}else{
					//String selOrderFcy = "", ord_fac_code=""; //Moved to top for MOHE-CRF-0074
					for (int i=0; i<facilities.size(); i += 2) {
						ord_fac_code = (String)facilities.get(i);
%>
						<OPTION <%= selOrderFcy %> VALUE="<%= ord_fac_code %>"><%= facilities.get(i+1) %></OPTION>
<%
					}	
					}	
%>
					<OPTION VALUE="*F"><fmt:message key="ePH.OtherthanMOHFacility.label" bundle="${ph_labels}"/></OPTION><OPTION VALUE="*P"><fmt:message key="ePH.Public.label" bundle="${ph_labels}"/></OPTION>
				</select>
				</td>
				 <TD class="label" ><fmt:message key="ePH.ModeofRequest.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
					<td class="label" ><SELECT name="request_mode" id="request_mode" >
					<OPTION value="">&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp</OPTION>
					<OPTION value="P"><fmt:message key="Common.InPerson.label" bundle="${common_labels}"/></OPTION>
					<OPTION value="T"><fmt:message key="Common.telephone.label" bundle="${common_labels}"/></OPTION>
					<OPTION value="E"><fmt:message key="ePH.E-Mail/Letter.label" bundle="${ph_labels}"/></OPTION>
					<OPTION value="F"><fmt:message key="ePH.Facsimile.label" bundle="${ph_labels}"/></OPTION>
					<OPTION value="R"> <fmt:message key="Common.referral.label" bundle="${common_labels}"/></OPTION>
					<OPTION value="S"><fmt:message key="Common.self.label" bundle="${common_labels}"/></OPTION>
					<OPTION value="O"><fmt:message key="Common.others.label" bundle="${common_labels}"/>
				 </select></td>
			  </tr>
			  <tr>
				<TD class="label"  nowrap ><fmt:message key="ePH.PriorityoftheRequest.label" bundle="${ph_labels}"/>&nbsp;
				</td>
				 <td class="label" ><SELECT name="priority" id="priority"  nowrap>
					<OPTION value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;</OPTION>
					<OPTION value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></OPTION>
					<OPTION value="I"><fmt:message key="ePH.Immediatewithin1to2hours.label" bundle="${ph_labels}"/></OPTION>
					<OPTION value="H"><fmt:message key="ePH.Within24Hours.label" bundle="${ph_labels}"/></OPTION>
					<OPTION value="W"><fmt:message key="ePH.Inaweekstime.label" bundle="${ph_labels}"/></OPTION>
					<OPTION value="O"><fmt:message key="Common.others.label" bundle="${common_labels}"/></OPTION>
				</select></td>
				 <td class="label" ><fmt:message key="ePH.EnquirerDesignation.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
				<td class="label" ><SELECT name="designation" id="designation" ><OPTION value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</OPTION>
<%
					selOrderFcy = "";
					String pract_type="";
					for (int i=0; i<practType.size(); i += 2) {
						pract_type = (String)practType.get(i);
%>
						<OPTION <%= selOrderFcy %> VALUE="<%= pract_type %>" ><%= practType.get(i+1) %></OPTION>
<%
					}	
%>
					<OPTION  value="O" ><fmt:message key="Common.others.label" bundle="${common_labels}"/></OPTION></select>
					</td>
			</tr>
			<tr>
				 <td class="label" ><fmt:message key="ePH.Requestcategory.label" bundle="${ph_labels}"/>&nbsp;
				 </td>
				 <td class="label"  ><SELECT name="req_catg" id="req_catg" ><OPTION value="">&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;</OPTION>
	<%				StringTokenizer st=null;
					selOrderFcy = "";
					String req_code ="";
					for (int i=0; i<reqCatg.size(); i += 2) {
						req_code = (String)reqCatg.get(i);
						st=new StringTokenizer(req_code,"**");
						req_code=st.nextToken();
%>
						<OPTION <%= selOrderFcy %> VALUE="<%= req_code %>" ><%= reqCatg.get(i+1) %></OPTION>
<%	
					}
%>
				</select></td>
				<TD class="label" nowrap ><fmt:message key="ePH.ResponseStatus.label" bundle="${ph_labels}"/>&nbsp;&nbsp;
				</td>
				<td class="label" ><SELECT name="response" id="response" onchange='callResponse(this)'>
					<OPTION value="*A">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.all.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</OPTION>
					<!-- <OPTION value="*A">All &nbsp;&nbsp;</OPTION> -->
					<OPTION value="P"><fmt:message key="Common.Pending.label" bundle="${common_labels}"/></OPTION>
					<OPTION value="R"><fmt:message key="ePH.Replied.label" bundle="${ph_labels}"/></OPTION></select></td>
				</tr>
				<tr>
					<TD class="label" nowrap ><fmt:message key="Common.VerificationStatus.label" bundle="${common_labels}"/>&nbsp;&nbsp;
					</td>
					<td class="label" ><SELECT name="verify" id="verify" onchange='callVerification(this)'>
						<OPTION value="*A">&nbsp;&nbsp;---<fmt:message key="Common.all.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</OPTION>
						<OPTION value="V"><fmt:message key="ePH.Verified.label" bundle="${ph_labels}"/></OPTION>
						<OPTION value="U"><fmt:message key="ePH.Un-Verified.label" bundle="${ph_labels}"/></OPTION>
					</select></td>	
				<TD class="label"  nowrap><fmt:message key="ePH.EnquiryNo.label" bundle="${ph_labels}"/>
				</td>
					<td class="label" ><input type='text' size='22' name='Enq_num' id='Enq_num' maxlength='20'>&nbsp;&nbsp;&nbsp;</td>	
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>  
					<td class="button" colspan='2'><input type="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResult()">&nbsp;&nbsp;&nbsp;</td>
				</tr>
			 </table>
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>"> 
			<input type="hidden" name="order_id" id="order_id" value="">
			<input type="hidden" name="order_line_no" id="order_line_no"	value="">
			<input type="hidden" name="drug_code" id="drug_code"	value="">
			<input type="hidden" name="p_drug_code" id="p_drug_code"	value="">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<input type="hidden" name="p_report_id" id="p_report_id" value="PHRADRREP">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_patient_id" id="p_patient_id" VALUE="">
			<INPUT TYPE="hidden" name="p_adr_no" id="p_adr_no" VALUE="">
			<INPUT TYPE="hidden" name="p_date_fm" id="p_date_fm" VALUE="">
			<INPUT TYPE="hidden" name="p_date_to" id="p_date_to" VALUE="">
			<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
	   </form>
	</body>
	<% putObjectInBean(bean_id,bean,request); 
}
// Added for MOHE-CRF-0074 - start
	catch(Exception e){
		e.printStackTrace();
	}
	finally{ 
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	}
%>  <!--  Added for MOHE-CRF-0074 - End -->
</html>


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
        request.setCharacterEncoding("UTF-8");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></script>
		<script LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></script>
			<script language="JavaScript" src="../../ePH/js/PhRepSalesAndReturnReport.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	
		<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</HEAD>
<%
	String locale			= (String)session.getAttribute("LOCALE");
	System.out.println("locale"+locale);
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "PHReportsBean" ;
	String bean_name			= "ePH.PHReportsBean";
	PHReportsBean bean	= (PHReportsBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	String sys_date      = bean.getSysDate();
	String from_date     = bean.getMonthRangeOfSysdate();
	String p_user_name      = (String) session.getValue( "login_user" ) ;
%>
	<body onMouseDown="" onKeyDown="lockKey()">

		<form name="formPhSaleOrReturnReportCriteria" id="formPhSaleOrReturnReportCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"  >
			<table cellpadding="0" cellspacing="0" width="90%" align="center" border="0">
				<th COLSPAN="8"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					<td colspan='3'>&nbsp;</td>
				</tr>
				<tr></tr>
				<tr>	
					<td class="label" width='15%'nowrap><fmt:message key="ePH.BillFromDate.label" bundle="${ph_labels}"/></td>
					<td class="label" width='15%'><input type="text" size="11" maxlength=10 name="p_period_fm" id="p_period_fm" value="<%=com.ehis.util.DateUtils.convertDate(from_date,"DMY","en",locale)%>" Onblur="CheckDateLeap(this,'DMY','<%=locale%>');"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_period_fm');" ><img src="../../eCommon/images/mandatory.gif"  align="center"></td>
					<td class="label" width='15%'nowrap><fmt:message key="ePH.BillToDate.label" bundle="${ph_labels}"/></td>
					<td class="label" width='15%'nowrap>
						<input type="text" size="11" name="p_period_t" id="p_period_t" value="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>" Onblur="CheckDateLeap(this,'DMY','<%=locale%>');"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_period_t');" ><img src="../../eCommon/images/mandatory.gif" align="center">
				    </td>
					<td class='label' colspan='2' width='*'></td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				
				
				<tr>
				<td class="label" width='15%' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class="label">
						<input type="text" name="p_patient_id" id="p_patient_id" value="" maxlength="<%=bean.getPatientIDLength()%>" size="20" onKeyPress="changeToUpper()" onchange="Duplicatecheck();" >
						<input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()">
				</td>
					
					 	<td class="label" align="left" width='15%' nowrap ><fmt:message key="ePH.EpisodeType.label" bundle="${ph_labels}"/></td>
				<%--	<td class="label" width='15%' >
						<select name="p_episode_type" id="p_episode_type" >
							
							<option value="I"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
							<option value="O"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
							<option value="D"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
							<option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
						</select>
					</td>--%>	
					<td colspan="3" class="label"><input type="checkbox" name="p_op_yn" id="p_op_yn" checked value="Y" onClick="assignValues(this)">
	                
	               <fmt:message key="ePH.op.label" bundle="${ph_labels}"/> <input type="checkbox" name="p_ip_yn" id="p_ip_yn" value="N"  onClick="assignValues(this)">	
	                <fmt:message key="ePH.ip.label" bundle="${ph_labels}"/> <input type="checkbox" name="p_dc_yn" id="p_dc_yn" value="N"  onClick="assignValues(this)">	
	             <fmt:message key="ePH.dc.label" bundle="${ph_labels}"/>  <input type="checkbox" name="p_em_yn" id="p_em_yn" value="N"  onClick="assignValues(this)">	
	                   <fmt:message key="ePH.em.label" bundle="${ph_labels}"/> <img src="../../eCommon/images/mandatory.gif"  align="center">  
					</td>
					
			   </tr>
			   		<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>					
					
					<td class="label" width='15%'><fmt:message key="ePH.BillTypes.label" bundle="${ph_labels}"/></td>
					<td class="label" width='15%' >
						<select name="p_settlement_ind" id="p_settlement_ind" >
						    <option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
							<option value="C"><fmt:message key="Common.Cash.label" bundle="${common_labels}"/></option>
							<option value="X"><fmt:message key="Common.Credit.label" bundle="${common_labels}"/></option>
								
							
							
						</select>
						
					</td>
					<td class="label" width='15%'><fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/></td>
					<td class="label" width='20%' >
						<select name="p_report_type" id="p_report_type" onchange='reportID(this);'>
							
						
							<option value="SAL"><fmt:message key="eST.Sales.label" bundle="${st_labels}"/></option>
							<option value="RET"><fmt:message key="eST.Sales.label" bundle="${st_labels}"/> <fmt:message key="Common.Outstanding.label" bundle="${common_labels}"/></option>
							<option value="BOTH"><fmt:message key="eST.Sales.label" bundle="${st_labels}"/> <fmt:message key="Common.and.label" bundle="${common_labels}"/> <fmt:message key="Common.Return.label" bundle="${common_labels}"/> / <fmt:message key="Common.Outstanding.label" bundle="${common_labels}"/></option>
						
						</select>
						
					</td>	
				</tr>
				
				<tr></tr>
				
			</table>
			<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= p_facility_id %>">
			<input type="hidden" name="p_user_name" id="p_user_name" value="<%= p_user_name %>">
			<input type="hidden" name="p_module_id" id="p_module_id" value="PH">
			<input type="hidden" name="p_from_date" id="p_from_date" value="">
			<input type="hidden" name="p_to_date" id="p_to_date" value="">
			<input type="hidden" name="p_report_id" id="p_report_id" value="">
			<input type="hidden" name="p_episode_type" id="p_episode_type" value="">
			<input type="hidden" name="sys_date" id="sys_date" value="<%=sys_date%>">
			
			
		</form>
	</body>
</html>


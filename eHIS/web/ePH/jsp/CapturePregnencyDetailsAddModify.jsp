<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<% 
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends

		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../js/CapturePregnencyDetail.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>	
		<body onMouseDown="CodeArrest" onKeyDown="lockKey()" >
			<form name="FormCapturePregnenyQueryResult" id="FormCapturePregnenyQueryResult" >
<%
			try{
				String bean_id		= "CapturePregnencyDetailBean";
				String bean_name	= "ePH.CapturePregnencyDetailBean";
				String p_facility_id		= (String) session.getValue( "facility_id" ) ;
				String patient_id = request.getParameter("patient_id");
				String encounter_id = request.getParameter("encounter_id");
				String from	= CommonBean.checkForNull(request.getParameter("from"));
				String to	= CommonBean.checkForNull(request.getParameter("to"));
				String user_id= (String) session.getValue("login_user");
				String user_id_name= (String) session.getValue("appl_user_name");
				String mode	= CommonRepository.getCommonKeyValue("MODE_INSERT"); 
				String locn_desc =""; 
				String locn_code =""; 
				String pract_name =""; 
				String admin_date ="",pregenant_yn="",lmp_date="",expd_delv_date="",actu_delv_date="",pregn_status_ind="",pract_id="",remarks=""; 
				String visible="";
				String srl_no="";
				String preg_week="";
				String trimster="";
				String disabled="";
				String practitioner_name="",practitioner_id="";
				ArrayList pregdetails				    =	null;
				//String sql_ph_medn_stat_pract_select1="SELECT DISTINCT A.PRACTITIONER_ID CODE,B.PRACTITIONER_NAME DESCRIPTION FROM AM_PRACT_FOR_FACILITY A,AM_PRACTITIONER_LANG_VW B,SM_FACILITY_FOR_USER C WHERE A.PRACTITIONER_ID=B.PRACTITIONER_ID  AND C.FACILITY_ID=A.FACILITY_ID  AND UPPER(APPL_USER_ID)LIKE UPPER(?) AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?)) AND UPPER(A.PRACTITIONER_ID) LIKE UPPER(?) AND UPPER(B.PRACTITIONER_NAME) LIKE UPPER(?)  AND B.LANGUAGE_ID = "; // Commented and added for CRF-PH- RUT-CRF-0063/09-Practitioner [IN:041141] 
				String sql_ph_medn_stat_pract_select1="Select a.practitioner_id code , b.practitioner_name description from AM_PRACT_FOR_FACILITY A, AM_PRACTITIONER_LANG_VW B where UPPER(b.practitioner_name) like upper(?) AND a.practitioner_id like upper(?) AND a.facility_id = '"+p_facility_id+"' AND B.PRACTITIONER_ID = A.PRACTITIONER_ID AND B.LANGUAGE_ID = '"+locale+"' ";
				CapturePregnencyDetailBean bean = (CapturePregnencyDetailBean)getBeanObject( bean_id,bean_name,request) ;
				bean.setLanguageId(locale);

				String sys_date  =bean.getSysDate();
				 int status_count =bean.getStatusCount(patient_id);
				 if(status_count==0){
					 mode	= CommonRepository.getCommonKeyValue("MODE_INSERT");
				}
				else{
					 mode	= CommonRepository.getCommonKeyValue("MODE_MODIFY");
					 visible="visibility:hidden";
				}
				ArrayList practDetails=bean.getFunctRollID(user_id);
				for(int i=0;i<practDetails.size();i+=2){
					practitioner_id=(String)practDetails.get(i);
					practitioner_name=(String)practDetails.get(i+1);
				}
%>
				<table  id="reultpage" cellpadding=0 cellspacing=0 width="90%" align="center" border="0" style=<%=visible%> >
					<tr><td colspan="2">&nbsp;</td></tr>
					<tr>
					  <td class="label" width='15%'><fmt:message key="ePH.Pregnant.label" bundle="${ph_labels}"/></td>
					  <td>
					  <input type="radio" name="pregnent_yn"   id="yes" value="Y"  onclick='assignValue();'><fmt:message key="Common.yes.label" bundle="${common_labels}"/>  
					  <input type="radio" name="pregnent_yn"    id="no"  value="N" checked onclick='assignValue();'><fmt:message key="Common.no.label" bundle="${common_labels}"/>&nbsp;&nbsp;
					  </td>
					</tr> 
					<tr>
					  <td class="label"><fmt:message key="ePH.Lmp.label" bundle="${ph_labels}" /></td>
						<td class="label"><input type="text" size="10" maxlength=10 name="lmp_date" id="lmp_date" disabled  OnBlur=" chk(this,'<%=DateUtils.convertDate(sys_date, "DMY","en",locale)%>','<%=locale%>',FormCapturePregnenyQueryResult.lmp_date.value);" ><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='LmpCalendar' disabled onclick="if(document.getElementById('yes').checked){ return showCalendar('lmp_date')}" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center" > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label id="trimster" style="font-weight:bold;font-size:12;color:red;" nowrap><b><%=trimster%></b></label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label id="preg_week" style="font-weight:bold;font-size:12;color:red;"><b><%=preg_week%></b></label>
						</td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="ePH.ExpectedDeliveryDate.label" bundle="${ph_labels}" /></td>
						<td class="label"><input type="text" size="10" maxlength=10 name="exp_date" id="exp_date" disabled  OnBlur=" checkdates(this,FormCapturePregnenyQueryResult.lmp_date.value) "><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=expCalendar  disabled onclick="if(document.getElementById('yes').checked){ return showCalendar('exp_date');}" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center" > </td>
					</tr>
					<tr>
						<td class="label" ><fmt:message key="ePH.ActualDeliveryDate.label" bundle="${ph_labels}" /></td>
						<td class="label"><input type="text" size="10" maxlength=10 name="act_del_date" id="act_del_date" disabled OnBlur=' checkdates(this,FormCapturePregnenyQueryResult.lmp_date.value)' ><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=ActCalendar  disabled onclick="if(document.getElementById('yes').checked){ return showCalendar('act_del_date');}"  ></td>
					</tr>
					<tr>
					  <td class="label" ><fmt:message key="Common.practitioner.label" bundle="${common_labels}" /></td>
						<td class="label">
							<input type="text" name="practitioner_name" id="practitioner_name" value="<%=practitioner_name%>" onchange="parent.searchPractitionerName();"><input type="button" class="button" value="?" name="btnPractitioner" id="btnPractitioner" onClick="parent.searchPractitionerName()"  >&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" ></IMG>
						</td>
					</tr>
					<tr>
						<td class="label" ><fmt:message key="Common.status.label" bundle="${common_labels}" /></td>
						<td class="label" width="60%">
						<select name="preg_status" id="preg_status" onchange="" >
							<option value="A" ><fmt:message key="Common.active.label" bundle="${common_labels}"/></option>
							<option value="C" ><fmt:message key="Common.close.label" bundle="${common_labels}"/></option>
						</select>
				   </td>
				   </tr>
					<tr>
						<td class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}" /></td>
						<td class="label" ><textarea size="2000" name="preg_remarks" cols="60" rows="7" onKeyPress="return checkMaxLimit(this,2000)" onblur ="return CheckRemMaxLen();"></textarea></td>
					</tr>
					<tr>
						<TD STYLE="bachground-color:white" class="button" colspan="2"  align='right'>
							<INPUT TYPE="button" CLASS="button" name="RECORD" id="RECORD" VALUE='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="apply()">&nbsp;
							<INPUT TYPE="button" CLASS="button" name="CANCEL" id="CANCEL" VALUE='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/> ' onClick="callCancel()">&nbsp;&nbsp;&nbsp;
						</TD>
					</tr>
			</table>
			<INPUT TYPE="hidden" name="practitioner_id" id="practitioner_id" VALUE="<%= practitioner_id %>">
			<INPUT TYPE="hidden" name="p_user_id" id="p_user_id" VALUE="<%= user_id %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= user_id_name %>">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= (String)session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>"> 
			<input type="hidden" name="sql_ph_medn_stat_pract_select1" id="sql_ph_medn_stat_pract_select1" value="<%=sql_ph_medn_stat_pract_select1%>">
			<INPUT TYPE="hidden" name="p_job_title" id="p_job_title" VALUE="">
			<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"			value="<%=bean_name%>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="visible" id="visible" value="<%=visible%>">
			<input type="hidden" name="srl_no" id="srl_no" value="<%=srl_no%>">
			<input type="hidden" name="from" id="from" value="">
			<input type="hidden" name="to" id="to" value="">
			<input type="hidden" name="pregn_status_ind" id="pregn_status_ind" value="<%=pregn_status_ind%>">
			<input type="hidden" name="disabled" id="disabled" value="<%=disabled%>">
<% 
			putObjectInBean(bean_id,bean,request); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
%>
		</form>
	</body>
</html>


<!DOCTYPE html>
 <%-- saved on 31/12/2009 --%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String p_user_name= (String) session.getValue( "login_user" ) ;
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	     
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script> 
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/SRRIPFillListUnallocDrugs.js"></SCRIPT>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</HEAD>
<%
	String bean_id				= "SRRPHRepDispStatisByDispBean" ;
	String bean_name			= "ePH.SRRPHRepDispStatisByDispBean";
	SRRPHRepDispStatisByDispBean bean	= (SRRPHRepDispStatisByDispBean)getBeanObject( bean_id, bean_name,request ) ;
	bean.setLanguageId(locale);
	String myLoginFacilityId = (String)session.getValue("facility_id");
	String login_at_ws_no		        = (String)bean.getLoginAtWsNo();
    String sys_date=bean.getSysDate();	
	String select_status = "";
	
	
	
	
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<FORM name="formSRRIPFillListUnallocDrugs" id="formSRRIPFillListUnallocDrugs" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
		<TABLE WIDTH="100%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
			
			<TR><TD>&nbsp;</TD></TR>
			<TR>
				<TD CLASS="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></TD>
				<TD><select name='p_disp_locn' id='p_disp_locn'>
							<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
<%
							ArrayList dispLocnList = bean.getDispLocnList(myLoginFacilityId);
							if(dispLocnList == null)
								dispLocnList = new ArrayList();
							for(int i=0; i<dispLocnList.size();i+=2){
%>
								<option value = <%= dispLocnList.get(i)%>><%= dispLocnList.get(i+1)%></option>
<%
								}
%>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
				</TD>

				<TD CLASS="label"><fmt:message key="ePH.FillProcessDate.label" bundle="${ph_labels}"/></TD>
				<td>&nbsp;&nbsp;<input type="text" size="12" maxlength=10 name="p_fill_proc_dt1" id="p_fill_proc_dt1" value="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>" OnBlur='if(CheckDate(this)) fillComboOptions(p_fill_proc_type,p_language_id);'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_fill_proc_dt1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
				<INPUT TYPE="hidden" name="p_fill_proc_dt" id="p_fill_proc_dt" VALUE=" ">
				</td>
	
			</TR>

			<tr>
						<td class="label"><fmt:message key="ePH.FillProcessType.label" bundle="${ph_labels}"/></td>
						<td><select name="p_fill_proc_type" id="p_fill_proc_type" onChange="fillComboOptions(this,p_language_id)">
								<option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;</option>
								<option value="I"><fmt:message key="ePH.Incremental.label" bundle="${ph_labels}"/></option>
								<option value="R"><fmt:message key="ePH.ROUTINE.label" bundle="${ph_labels}"/></option>
								</select>
						</td>
						<td class="label"><fmt:message key="ePH.FillProcessID.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;&nbsp;<select name="p_fill_proc_id" id="p_fill_proc_id" >
								<option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;</option>
								</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
						</td>
			</tr>

			<tr>
						<td class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
						<td>
<!--The Below onChange Event Added By SureshKumarT For The IncidentNo: SRR20056-SCF-7499 [IN: 027551]-->
						
							<select name="p_report_type" id="p_report_type" onChange='selectReport(this)'>
								<option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;</option>
								<option value="DT"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
								<option value="SM"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
							</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
						</td>
			</tr>

<TR>
<td colspan="6">&nbsp;</td>
</tr>
</table>

	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= myLoginFacilityId %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
	<INPUT TYPE="hidden" name="P_REPRINT" id="P_REPRINT" VALUE="Y">
	<INPUT TYPE="hidden" name="p_WS_NO" id="p_WS_NO" VALUE="<%=login_at_ws_no%>">
	<script>
	fillComboOptions(document.formSRRIPFillListUnallocDrugs.p_fill_proc_type,'<%=locale%>');
	
	</script>
</FORM>
<% putObjectInBean(bean_id,bean,request); %>
</BODY>
</HTML>


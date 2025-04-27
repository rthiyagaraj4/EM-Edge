<!DOCTYPE html>
 <%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>-->
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT>-->
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNRegimenMast.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY TOPMARGIN="0" onKeyDown="lockKey()" onMouseDown="CodeArrest()">

<%
	String bean_id		= "TPNRegimenMastBean";
	String bean_name	= "ePH.TPNRegimenMastBean";

	TPNRegimenMastBean bean		= (TPNRegimenMastBean)getBeanObject(bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	ArrayList schedule			= bean.loadSchedule(locale);
	ArrayList category			= bean.loadCategory(locale);
	HashMap labels				= bean.loadLabels(locale);
	ArrayList caution_label_1	= (ArrayList)labels.get("caution_label_1");
	
	ArrayList spl_instruction	= (ArrayList)labels.get("spl_instruction");
	String code					= "";
	String desc					= "";
	String schedule_id			= "";
	String prescribing_catg		= "";
	String infuse_over			= "";

	String authorize_yn			= "";
	String disp_via_pres		= "";
	String disp_against_damage	= "";
	String caution_1			= "";
	String spl_inst				= "";
	String patient_direction	= "";
	String authorize_status		= "";
	String authorize_val		= "N";
	String disp_via_pres_status	= "";
	String disp_via_pres_val	= "N";
	String disp_damage_status	= "";
	String disp_damage_val		= "B";
	HashMap	ordering_dispensing	= bean.getOrdDispensing();

	if(ordering_dispensing.size()!=0) {
		schedule_id			= (String)ordering_dispensing.get("schedule_id");
		prescribing_catg	= (String)ordering_dispensing.get("prescribing_catg");
		infuse_over			= (String)ordering_dispensing.get("infuse_over");
		authorize_yn		= (String)ordering_dispensing.get("authorize_yn");
		disp_via_pres		= (String)ordering_dispensing.get("disp_via_pres");
		disp_against_damage	= (String)ordering_dispensing.get("disp_against_damage");
		caution_1			= (String)ordering_dispensing.get("caution_label_1");
		spl_inst			= (String)ordering_dispensing.get("spl_instruction");
		patient_direction	= (String)ordering_dispensing.get("patient_direction");
	}

	if(authorize_yn.equals("Y")) {
		authorize_status	= "checked";
		authorize_val		= "Y";
	}

	if(disp_via_pres.equals("Y")) {
		disp_via_pres_status	= "checked";
		disp_via_pres_val		= "Y";
	}

	if(disp_against_damage.equals("Y")) {
		disp_damage_status	= "checked";
		disp_damage_val		= "Y";
	}
%>

<FORM name="TPNRegimenMastOrdDispForm" id="TPNRegimenMastOrdDispForm">
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
	<TR>
		<TH COLSPAN="4"><fmt:message key="ePH.OrderingRules.label" bundle="${ph_labels}"/></TH>
	</TR>
	<TR>
		<TD CLASS="label"><fmt:message key="ePH.ScheduleID.label" bundle="${ph_labels}"/></TD>
		<TD COLSPAN="3">&nbsp;
			<SELECT name="schedule_id" id="schedule_id" onChange="setScheduleID(this.value)">
				<OPTION value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>


<!--com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+(String)records.get( colCount)+".label","common_labels")*-->

<%
	for(int i=0;i<schedule.size();i+=2) { 
		code = (String)schedule.get(i);
		desc = (String)schedule.get(i+1);

		if(schedule_id.equals(code)) {
%>

				 <OPTION VALUE="<%=code%>" SELECTED><%=desc%></OPTION>

<%		}
		else {
%>

				<OPTION VALUE="<%=code%>"><%=desc%></OPTION>

<%		}
	}
%>

			</SELECT>
		</TD>
	</TR>
	<TR>
		<TD CLASS="label"><fmt:message key="ePH.PrescribingCategory.label" bundle="${ph_labels}"/></TD>
		<TD COLSPAN="3">&nbsp;
			<SELECT name="prescribing_catg" id="prescribing_catg">
				<OPTION value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>

<%
	for(int i=0;i<category.size();i+=2) {
		code	= (String)category.get(i);
		desc	= (String)category.get(i+1);

		if(prescribing_catg.equals(code)) {
%>

				<OPTION VALUE="<%=code%>" SELECTED><%=desc%></OPTION>

<%		}
		else {
%>

				<OPTION VALUE="<%=code%>"><%=desc%></OPTION>
<%		}
	}
%>
			</SELECT>
		</TD>
	</TR>
	<TR>
		<TD CLASS="label"><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/></TD>
		<TD COLSPAN="3">&nbsp;
			<INPUT TYPE="text" name="infuse_over" id="infuse_over" MAXLENGTH="5" SIZE="5" CLASS="number" VALUE="<%=infuse_over%>" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1')" onBlur="checkIsNotZero(this, 'Infusion Value');">&nbsp;
			<SELECT name="infuse_over_list" id="infuse_over_list">
				<OPTION VALUE="H" SELECTED><fmt:message key="Common.hours.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="M"><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/>/></OPTION>
			</SELECT>
		</TD>
	</TR>
	<TR>
		<TH COLSPAN="4"> <fmt:message key="ePH.DispensingRules.label" bundle="${ph_labels}"/></TH>
	</TR>
	<TR>
		<TD CLASS="label"><fmt:message key="ePH.AuthorizeonDispensing.label" bundle="${ph_labels}"/></TD>
		<TD>&nbsp;<INPUT TYPE="checkbox" name="authorize_yn" id="authorize_yn" onClick="assignValue(this)" VALUE="<%= authorize_val %>" <%=authorize_status%>></TD>
		<TD CLASS="label"><fmt:message key="ePH.DispenseViaPrescription.label" bundle="${ph_labels}"/></TD>
		<TD>&nbsp;<INPUT TYPE="checkbox" name="disp_via_pres" id="disp_via_pres" onClick="assignValue(this)" VALUE="<%= disp_damage_val %>" <%=disp_via_pres_status%>></TD>
	</TR>
	<TR>
		<TD CLASS="label"><fmt:message key="ePH.DispenseAgainstDamage.label" bundle="${ph_labels}"/></TD>
		<TD COLSPAN="3">&nbsp;<INPUT TYPE="checkbox" name="disp_against_damage" id="disp_against_damage" onClick="assignValue(this)" VALUE="<%= disp_via_pres_val %>" <%=disp_damage_status%>></TD>
	</TR>
	<TR>
		<TD CLASS="label"><fmt:message key="ePH.CautionLabel.label" bundle="${ph_labels}"/></TD>
		<TD COLSPAN="3">&nbsp;
			<SELECT name="caution_label_1" id="caution_label_1">
				<OPTION value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-----------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------------&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>

<%
	for(int i=0;i<caution_label_1.size();i+=2) {
		code = (String)caution_label_1.get(i);
		desc = (String)caution_label_1.get(i+1);

		if(caution_1.equals(code)) {
%>

				<OPTION VALUE="<%=code%>" SELECTED><%=desc%></OPTION>

<%
		}
		else {
%>

		 		<OPTION VALUE="<%=code%>"><%=desc%></OPTION>
<%		}
	}
%>

			</SELECT>
		</TD>
	</TR>
		
<%

%>
		
	<TR>
		<TD CLASS="label"><fmt:message key="ePH.SpecialInstruction.label" bundle="${ph_labels}"/></TD>
		<TD COLSPAN="3">&nbsp;
			<SELECT name="spl_instruction" id="spl_instruction">
				<OPTION value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-----------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------------&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>

<%
	for(int i=0;i<spl_instruction.size();i+=2) {
		code = (String)spl_instruction.get(i);
		desc = (String)spl_instruction.get(i+1);

		if(spl_inst.equals(code)) {
%>

				<OPTION VALUE="<%=code%>" SELECTED><%=desc%></OPTION>
<%
		}
		else {
%>

				<OPTION VALUE="<%=code%>"><%=desc%></OPTION>

<%
		}
	}
%>
			</SELECT>
		</TD>
	</TR>
	<TR>
		<TD CLASS="label"><fmt:message key="ePH.DirectionToPatient.label" bundle="${ph_labels}"/></TD>
		<TD COLSPAN="3">&nbsp;
			<INPUT TYPE="text" name="patient_direction" id="patient_direction" VALUE="<%=patient_direction%>" size="50" MAXLENGTH="40">
		</TD>
	</TR>
	</TABLE>
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
</FORM>
<% putObjectInBean(bean_id,bean,request); %>
</BODY>
</HTML>


<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String facility_id			= (String)session.getValue( "facility_id" );
	
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" SRC="../../eCommon/js/dchk.js"></script>
	<script language="javascript" SRC="../../eCommon/js/DateUtils.js"></script>

	<script language="javascript" src="../js/PhCommon.js"></script>
	 <script language="javascript" src="../js/DangOrderDispDrugs.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
	<FORM name="formDangOrderDispDrugs" id="formDangOrderDispDrugs" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
	<%
	String bean_id			= "PHRepDispStatisByDispBean";
	String bean_name		= "ePH.PHRepDispStatisByDispBean";

	HashMap p_dispense_locn=new HashMap();
	ArrayList displocn_code=new ArrayList();
	ArrayList displocn_desc=new ArrayList();

	String sql_ph_drug_search_select2 =	PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2");

	PHRepDispStatisByDispBean bean = (PHRepDispStatisByDispBean)getBeanObject( bean_id, bean_name,request) ;
	bean.setLanguageId(locale);

	p_dispense_locn=bean.populateDispenselocn(facility_id);
	displocn_code=(ArrayList)p_dispense_locn.get("code");
	displocn_desc=(ArrayList)p_dispense_locn.get("desc");
	%>

<TABLE cellpadding=0 cellspacing=0 width="80%"  align="center" border="0" >
<TR><TD colspan="8">&nbsp;</TD>
<TR >
				<TD class="label" colspan="1"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></TD>
				<TD colspan="3">&nbsp;&nbsp;<input type="text" name="p_drug_name" id="p_drug_name" maxlength="60" size="60" readonly ><input type="button" class="button" value="?" name="drug_name_search" id="drug_name_search" onclick="searchDrugName();">
				<input type="hidden" name="drug_code" id="drug_code" value="">
			</TD>	
</TR>
<TR>
		<TD CLASS="label"><fmt:message key="ePH.OrderLocationType.label" bundle="${ph_labels}"/></TD>
		<TD>&nbsp;&nbsp;<select name="p_order_locn_type" id="p_order_locn_type" onChange="clearOrderLocation()">
			<option value="">&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;</option>
			<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
			<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			</select><img src="../../eCommon/images/mandatory.gif" align="center"></img>
		</TD>
			<TD class="label"><fmt:message key="Common.OrderLocation.label" bundle="${common_labels}"/></TD>
				<TD colspan="3">&nbsp;&nbsp;<input type="text" name="p_order_locn_name" id="p_order_locn_name" readonly ><input type="button" class="button" value="?" name="order_locn_search" id="order_locn_search"  onClick="locationLookup(p_order_locn_name)"><input type="hidden" name="p_order_locn_code" id="p_order_locn_code"><img src="../../eCommon/images/mandatory.gif" align="center"></img>
		</TD>	
</TR>
<TR >
		<TD class="label" ><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></TD>
		<TD>&nbsp;
			<select name="p_disp_locn_code" id="p_disp_locn_code">
			<option value="">&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>  ---&nbsp;&nbsp;&nbsp;&nbsp;</option>
			<%
					for(int i=0;i<displocn_code.size();i++){
			%>
					<option  VALUE="<%=displocn_code.get(i)%>"><%=displocn_desc.get(i) %></option>
			<%
					}
			%>

			</select>
		</TD>
		<TD colspan="4"></TD>
</TR>
<TR>			
		<TD CLASS="label"> <fmt:message key="Common.from.label" bundle="${common_labels}"/></TD>
		<TD>&nbsp;&nbsp;<input type="text" name="p_from_date" id="p_from_date"  size="8"  value="" maxlength="10" onBlur="if(CheckDateT(this)) validateDate();"><IMG SRC="../../eCommon/images/CommonCalendar.gif"  id="Calendar" onclick="return showCalendar('p_from_date');"><img src="../../eCommon/images/mandatory.gif" align="center"></img><!--changed CheckDate to CheckDateT for Leap year calculation on 
24/02/2012 -->
		</TD>
		<TD class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></TD>
		<TD>&nbsp;&nbsp;<input type="text" name="p_to_date" id="p_to_date"  size="8"  value="" maxlength="10" onBlur="if(CheckDateT(this)) validateDate();"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar" onclick="return showCalendar('p_to_date');"> <!--changed CheckDate to CheckDateT for Leap year calculation on 
24/02/2012 -->
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
		</TD>
</TR>
<TR>
		<TD CLASS="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/></TD>
		<TD COLSPAN="3">&nbsp;&nbsp;<select name="p_report_by" id="p_report_by" onChange="initialize_date(this);">
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;</option>
		<option value="D" selected><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
		<option value="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
		<option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option>
		</select>
		</TD>
</TR>

<TR>
		<TD CLASS="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></TD>
		<TD COLSPAN="3">&nbsp;&nbsp;<select name="p_order_by" id="p_order_by" onChange="initialize_clase(this);"> 
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;</option>
		<option value="Drug"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
		<option value="Order"><fmt:message key="Common.OrderLocation.label" bundle="${common_labels}"/></option>
		</select>
		</TD>
</TR>
<TR><TD colspan="8">&nbsp;</TD>
</TABLE>
				<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
		<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
		<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
		<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHDANGORDDISP">
		<INPUT TYPE="hidden" name="CLAUSE" id="CLAUSE" VALUE=""> 
		<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>"> 
		<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">

</form>

<input type="hidden" name="sql_ph_drug_search_select2" id="sql_ph_drug_search_select2" value="<%=sql_ph_drug_search_select2%>">
		<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
		<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">

</html>
<%
putObjectInBean(bean_id,bean,request);
%>


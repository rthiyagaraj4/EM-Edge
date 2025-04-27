<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,ePH.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/PhPatTurnaroundTimeForm.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	</head>
<%
	String bean_id				= "PHReportsBean" ;
	String bean_name			= "ePH.PHReportsBean";
	PHReportsBean bean	= (PHReportsBean)getBeanObject(bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	String sys_date=bean.getSysDate();
	 ArrayList displocation  = bean.getDispLocation();
	 String Sysdate 				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);	
	 String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhDispLabelCriteria.p_disp_locn_code.focus();"> 
		<form name="formPhDispLabelCriteria" id="formPhDispLabelCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="3" cellspacing="0" width="100%" align="center" border="0">
				<tr>
				<td width="3%" class="label">&nbsp;</td>
			<td width="3%" class="label" nowrap ><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td width="20%" class="label">&nbsp;<SELECT name="p_disp_locn_code" id="p_disp_locn_code">
		   	<OPTION VALUE=" ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</OPTION>
			<%	 if (displocation.size() > 0 )
			for (int i=0; i<displocation.size(); i+=2) {
			%>
			<OPTION VALUE="<%= displocation.get(i) %>"><%= displocation.get(i+1) %></OPTION>

			<% 	} %> 
	  </SELECT>
	  &nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>	
				</tr>
				<tr>
				<td width="3%" class="label">&nbsp;</td>
			<td class="label" nowrap><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
		<%-- <input type="text" name="p_from_dt" id="p_from_dt" value="<%=currentdate%>" maxlength="10" size="10" onKeyPress="return AllowDateFormat()" onBlur="if(CheckDateT(this)){DateCheck(currentdate,p_from_dt)}"> --%>
		<input type="text" name="p_from_dt" id="p_from_dt" value="<%=currentdate%>" maxlength="10" size="10" onKeyPress="return AllowDateFormat()" onBlur='checkDate(this,"DMY","<%=locale%>")'> <!-- ML-BRU-SCF-2212 -->
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_from_dt');"  onblur='p_from_dt.focus()'>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif">
		</td>
		</td>
		<td width="10%" class="label"><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
		<td><%-- <input type="text" name="p_dt_to" id="p_dt_to" value="<%=currentdate%>" maxlength="10" size="10" onKeyPress="return AllowDateFormat()" onBlur="if(CheckDateT(this)){DateCheck(currentdate,p_dt_to)}"> --%>
		<input type="text" name="p_dt_to" id="p_dt_to" value="<%=currentdate%>" maxlength="10" size="10" onKeyPress="return AllowDateFormat()" onBlur='checkDate(this,"DMY","<%=locale%>")'><!-- ML-BRU-SCF-2212 -->
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_dt_to');"  onBlur='p_dt_to.focus()'>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"><!--from_dt to p_from_dt AND dt_to to p_dt_to Added for DateConversion identification -->
		</td>
				</tr>
			</table>
		   <INPUT TYPE="hidden" name="p_dispense_date" id="p_dispense_date" VALUE="<%=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",locale)%>">
		   <INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
		   <INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHPTRNTM">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<input type="hidden" name="p_mode" id="p_mode" value="VIEW"> 
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>"> 
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>"> 
			<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%=currentdate%>">
			<INPUT TYPE="hidden" name="from_dt" id="from_dt" VALUE=""><!--Added for DateConversion identification --> 
			<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE=""><!--Added for DateConversion identification -->
		</form>
	</body>
</html>


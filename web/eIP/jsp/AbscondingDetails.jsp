<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<HEAD> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
   String call_function	= checkForNull(request.getParameter("call_function"));
%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link> 
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../js/DischargeAdvice.js" language="JavaScript"></Script>
<%if(call_function.equals("Discharge_Patient"))%>
<script src="../js/DischargePatient.js" language="JavaScript"></Script>
<%if(call_function.equals("AMEND_LEAVE"))%>
<script src="../js/AmendInpatientLeave.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	String locale			= (String)session.getAttribute("LOCALE");
	String add_reported_to	= checkForNull(request.getParameter("add_reported"));
	String dis_val			= checkForNull(request.getParameter("dis_val"));
	String check_val		= checkForNull(request.getParameter("check_val"));
	String absconded_date	= checkForNull(request.getParameter("absconded_date"));
	String absconding_yn	= checkForNull(request.getParameter("absconding_yn"));
	String AbsDateTime		= checkForNull(request.getParameter("AbsDateTime"));
	String reported_to		= checkForNull(request.getParameter("reported_to"));
	if(call_function.equals("Discharge_Patient"))
		reported_to			= add_reported_to;

	String absconded_date_display = "";
	if(absconded_date == "" || absconded_date.equals("null"))
		absconded_date_display = "&nbsp;";
	else
		absconded_date_display = DateUtils.convertDate(absconded_date,"DMYHM","en",locale);
%>
<BODY onKeyDown="lockKey();setShift();">
	<%if(call_function.equals("AMEND_LEAVE"))
	{%>
	<table cellpadding=0 cellspacing=0 align=center width="100%" border=0>
	<tr >
	<td  class='label' width='25%'></td>
	<td  class='label' width='30%'></td>
	<td  class='label' width='20%'></td>
	<td  class='label' width='25%'></td>
	</tr>
	
	<TR>
		<TD class="label" nowrap id='Abscndng_lgd'><fmt:message key="eIP.Absconding.label" bundle="${ip_labels}"/></TD>
		<TD class = "fields" nowrap><input type="checkbox" name="Absconding_yn" id="Absconding_yn" id="AbsStatusID" value='Y'  <%=absconding_yn%> onchange = 'changeAbsStatus(this);' onclick='absChecked(this);'></td>
		<TD class='label' nowrap id='Dateofabs_lgd'><fmt:message key="eIP.AbscondingDate.label" bundle="${ip_labels}"/></TD>
		<TD class = "fields" nowrap>
		<input type ='text' name = 'AbsDate' value='<%=AbsDateTime%>' size = '16' id="AbsDateID"  maxlength ='16'  readonly onBlur="validateDate('AB',this)"><img  name='AbsDateImg' src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].AbsDateID.select();return showCalendar('AbsDateID',null,'hh:mm')" id = "calgif"/><img id = "absgif" src='../../eCommon/images/mandatory.gif'align='center'></img>	  	
		</TD> 
		<td >&nbsp;</td>
	</TR><tr>
		
		<td class='label' nowrap id='reported_to_lgd'><fmt:message key="eIP.ReportedTo.label" bundle="${ip_labels}"/></td>
		<td colspan='3' class='fields'><textarea  rows='2' style = "resize: none;"  cols='60' name='reported_to' onBlur='makeValidString(this)'><%=reported_to%></textarea></td>
		
	</tr>
</table>
<%
}else{
%> 
<table width='100%' cellpadding='0' cellspacing='0' BORDER='0'>		
<tr>
		<td class='label'  width='25%'><fmt:message key="eIP.Absconding.label" bundle="${ip_labels}"/></td>
		<td class='fields' width='30%'><input type="checkbox" value="Y"   name="absconding_yn" id="absconding_yn" <%=dis_val%> <%=check_val%> <%if(call_function.equals("Discharge_Advice")||call_function.equals("Discharge_Patient")){%>onchange = 'changeAbsStatus(this);' onclick='absChecked(this);' onblur='abs_focus(this)' <%}%> disabled='true' onkeydown="shift_tab();" tabindex = '18'> <!-- modified by mujafar for ML-MMOH-CRF-0659 -->
		</td>
		<td class='label' width='20%'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'><input type='text' name='absconding_date' id='absconding_date' value="<%=absconded_date_display%>" onKeyPress='return(ChkNumberInput1(this,event,2));' size='15' maxlength='16' onBlur="datefun(this);" onkeydown="shift_tab();" tabindex = '19'><img name="calImage" id="calImage" src="../../eCommon/images/CommonCalendar.gif" onClick=" if(! document.forms[0].absconding_date.disabled){return showCalendar('absconding_date',null,'hh:mm');}" tabindex=-1 disabled=true tabindex = '20'/><img src='../../eCommon/images/mandatory.gif' align='center' id='AbsImg' style="Visibility:'Hidden'"></img>
		</td>
		
		</tr>
			<tr>
	<td class='label' width='25%'><fmt:message key="eIP.InformedOthers.label" bundle="${ip_labels}"/></td>
	<td class='fields' colspan=3><TEXTAREA NAME="absconding_rep_to" style = "resize: none;"  readOnly ROWS="3" COLS="60" onBlur="checkForMaximum1(this.value);" onkeydown="shift_tab();" tabindex = '21'><%=reported_to%></TEXTAREA></td>
	</tr>
	</table>
<%
}
%>
</BODY>
</HTML>
<%!

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<%
	request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();
	String sensitive_disp = "";
	String notifiable_disp = "";
	String table_disp = "";

	int colspn = 0;
	int colspn_nt = 0;

	String age_group_appl_yn = request.getParameter("age_group_appl_yn")==null?"":request.getParameter("age_group_appl_yn");
	
	String sensitivity_appl_yn = request.getParameter("sensitivity_appl_yn")==null?"":request.getParameter("sensitivity_appl_yn");

	String notification_appl_yn = request.getParameter("notification_appl_yn")==null?"":request.getParameter("notification_appl_yn");

	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");

	if(sensitivity_appl_yn.equals("Y")){
		sensitive_disp = "display:visible";
		colspn_nt = 3;
	}
	else{
		sensitive_disp = "display:none";
		colspn_nt = 2;
	}
	
	if(notification_appl_yn.equals("Y")){
		notifiable_disp = "display:visible";
		colspn = 3;
	}
	else{
		notifiable_disp = "display:none";
		colspn = 2;
	}
	if(notification_appl_yn.equals("Y")&& sensitivity_appl_yn.equals("Y")){
		colspn_nt = 1;
		colspn = 1;
	}

	if(notification_appl_yn.equals("N") && sensitivity_appl_yn.equals("N"))
		table_disp = "display:none";
	else
		table_disp = "display:inline";

	
%>
<head>

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onKeyDown='lockKey()'>
<script>

	var radioval="D";
	function CallDescFrame()
	{
		var listval=document.forms[0].Search_criteria.options.value;
		var textbox=document.forms[0].Search_text.value;
		var sensitive_yn=document.forms[0].sensitive_yn.value;
		var notifiable = document.forms[0].opt_notifiable.value;

	parent.frames[1].location.href='TermCodeSearchCLResult.jsp?<%=queryString%>&Search_By='+radioval+'&Search_Criteria='+listval+'&sensitive_yn='+sensitive_yn+'&Search_Text='+textbox+'&opt_notifiable='+notifiable;
		document.TermCodeSearchCLCriteriaForm.Search.disabled = true;
	}

	function storeVal(currad)
	{
		radioval = currad.value
	}
	 
	function Change(obj)
	{
		if(obj.checked)
		   obj.value = 'Y';
		else
		   obj.value = 'N';
	}
</script>
<form name="TermCodeSearchCLCriteriaForm" id="TermCodeSearchCLCriteriaForm">
<table align=right border="0" width=100% cellspacing='0' cellpadding='0'>
<tr width='100'>
	<td colspan="1" class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick='storeVal(this)'>Description
		<input type="radio" name="search_by" id="search_by" class="label" value="C" onclick='storeVal(this)'>Code
	</td>
	<td class="label" colspan="1" align="left">
		<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>
		<select name="Search_criteria" id="Search_criteria">
		<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
		<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
		<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
		</select>
	</td>
</tr>
<tr style='<%=table_disp%>'>
	<td align="left" colspan="<%=colspn%>" class="label" style="<%=notifiable_disp%>">
		<B><fmt:message key="Common.RestrictTo.label" bundle="${common_labels}"/></B>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Notifiable
		<select name="opt_notifiable" id="opt_notifiable">
			<option value="" selected>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			<option value="Y"><fmt:message key="Common.Notifiable.label" bundle="${common_labels}"/></option>
			<option value="N" ><fmt:message key="eMR.NonNotifiable.label" bundle="${mr_labels}"/></option>
		</select>
	</td>
	<td class="label" colspan="<%=colspn_nt%>" align="left" style="<%=sensitive_disp%>">
		<%if(notification_appl_yn.equals("N")&& sensitivity_appl_yn.equals("Y")){%><B><fmt:message key="Common.RestrictTo.label" bundle="${common_labels}"/></B>&nbsp;&nbsp;&nbsp;<%}%>Sensitive&nbsp;&nbsp;
		<select name="sensitive_yn" id="sensitive_yn">
			<option value="" selected>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			<option value="Y"><fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/></option>
			<option value="N"><fmt:message key="eMR.NonSensitive.label" bundle="${mr_labels}"/></option>
		</select>
	</td>
	
</tr>
<tr>
	<td class='label'  colspan="1" align="left" ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>
		<input type="text"  name="Search_text" id="Search_text" value= '' width=30% align="left" size='20' maxlength='20'>
	</td>
	<td align='center' colspan="1" class='button'>
		<input type="button" width='6%' align="left" name="Search" id="Search" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="CallDescFrame(this)" class='button' >
	</td>
</tr>
</table>
	<input type='hidden' name='age_group_appl_yn' id='age_group_appl_yn' value='<%=age_group_appl_yn%>'></input>
	<input type='hidden' name='sensitivity_appl_yn' id='sensitivity_appl_yn' value='<%=sensitivity_appl_yn%>' ></input>
	<input type='hidden' name='notification_appl_yn' id='notification_appl_yn' value='<%=notification_appl_yn%>' ></input>
	<input type='hidden' name='term_set_id' id='term_set_id' value='<%=term_set_id%>' ></input>
</form>
</body>
</html>
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


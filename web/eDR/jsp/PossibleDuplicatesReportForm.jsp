<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<%
try
{
	request.setCharacterEncoding("UTF-8");
	String p_module_id	 = "DR";
	String p_report_id	 = "DRBPSDUP";

	String p_facility_id = (String) session.getValue( "facility_id" ) ;
	String p_user_name	 = (String) session.getValue( "login_user" ) ;

	String modal	= request.getParameter("modal");
	
	%>
<html>
<HEAD>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<script>
	function assignValue(obj)
	{
		if(obj.checked == true) document.getElementById("p_include_file").value = "Y";
		else document.getElementById("p_include_file").value = "N";
	}

	function modal_close_win()
	{
		parent.parent.close();
	}
	async function searchCode(obj,target)
	{
		
		var retVal			= new String();
		var dialogHeight	= "450px" ;
		var dialogWidth		= "700px" ;
		var status			= "no";
		var arguments		= "" ;
		var sql				= "";
		var search_code		= "";
		var search_desc		= "";
		var tit				= "";

		 if(obj.name == "patsergrp")
		{
			tit = encodeURIComponent(getLabel("Common.PatientSeriesGroup.label","Common"));
			sql="select pat_ser_grp_code, short_desc from mp_pat_ser_grp_lang_vw where language_id=`"+localeName+"`";
			search_code="pat_ser_grp_code";
			search_desc= "short_desc";
		}
	
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

		if(!(retVal == null))
		{
			target.value=retVal;
		}
		else target.focus();
	}

</script>
<BODY onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
	<br><br>
	<form name="repDRPossibleDuplicates" id="repDRPossibleDuplicates" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<%	if(modal != null && modal.equals("Y")) { %>
		<table border=0 cellpadding=0 cellspacing=0 width='80%' align='center' valign='top'>
			<tr>
				<td class="COMMON_TOOLBAR" width="" align='left'>
				<input type='button' onclick="parent.modal_run()"; value='<fmt:message key="Common.run.label" bundle="${common_labels}"/>' class='BUTTON'></input>
				<input type='button' onclick="modal_close_win()";  value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='BUTTON'></input>
				</td>
			</tr>
		</table>
	<% } %>
	<table width='80%' border=0 align='center' valign='top'>
			

		<th class='columnheader' style="text-align:left;"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
			 
		<tr>
			<td width="100%" class="Border" align='center'>
			<table width='70%' cellPadding="0" cellSpacing="0"  align='center' >
			  <tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td> 
				</tr>
			
				 <tr>
					<td width='20%' colspan=1></td>
					<td width='33%' class='querydata' style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>				
					<td width='33%' class='querydata' style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>	
					<td class='label' colspan=1></td>
				 </tr>
		
				<tr>
					<td width="33%" class='label' nowrap><fmt:message key="Common.PatientSeriesGroup.label" bundle="${common_labels}"/></td>
					<td class='fields' width="33%"><input type="text" name="p_series_from" id="p_series_from" size="2" maxlength="2"><input type='button' name='patsergrp' id='patsergrp' value='?' class='button' onclick='searchCode(this, 
					p_series_from)'>
					</td>			
					<td class='fields' width="33%"><input type="text" name="p_series_to" id="p_series_to" size="2" maxlength="2"><input type='button' name='patsergrp' id='patsergrp' value='?' class='button' onclick='searchCode(this, 
						p_series_to)'>
					</td>
				</tr>

				<tr><td class='label' colspan=4></td></tr>
             <tr><td colspan=4>&nbsp;</td></tr>
				<tr>
					<td width="33%" class="label"><fmt:message key="Common.filecreated.label" bundle="${common_labels}"/></td>
					<td  class='fields' width="33%">
					<select name='p_include_file' id='p_include_file' >
						<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
						<option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
					</select>
					</td>
					<td class='label' width="40%"></td>
				</tr>
				<tr><td colspan=4>&nbsp;</td></tr>
				<tr><td class='label' colspan=4></td></tr>
				<tr>
					<td class="label" width='33%' nowrap><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td class='fields' width='33%'>
						<select name='p_order_by' id='p_order_by' >
							<option value='1'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></option>
							<option value='2'><fmt:message key="Common.TerminalDigit.label" bundle="${common_labels}"/></option>
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
<input type="hidden" name="p_module_id" id="p_module_id" value="<%=p_module_id%>">
<input type="hidden" name="p_report_id" id="p_report_id" value="<%=p_report_id%>">
<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=p_user_name%>">
</form>
<%
}
catch(Exception e)
{
	out.println("Exception e :"+e.toString());
}
%>
</BODY>
</HTML>



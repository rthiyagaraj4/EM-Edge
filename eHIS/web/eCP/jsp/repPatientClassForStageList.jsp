<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<HTML>
<HEAD>
<%
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	<SCRIPT src="../../eCommon/js/ValidateControl.js" language="javascript"></SCRIPT>
	<SCRIPT src="../../eCommon/js/common.js" language="javascript"></SCRIPT>
	<SCRIPT src="../../eCP/js/repCpMasterList.js" language="javascript"></SCRIPT>
	<script>
<%
	String p_module_id		= "CP";
	String p_report_id		= "CPBPCSTG" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String p_resp_id			=	(String) session.getValue("responsibility_id");
%>
function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility=obj1.value;
			if(obj.name=="Stage")
			{
				tit="Stage"
				//sql="select clinic_code, short_desc from op_clinic ";
				sql="SELECT STAGE_CODE,SHORT_DESC FROM CP_STAGE";
				search_code="STAGE_CODE";
				search_desc= "SHORT_DESC"
			}
			
			if(obj.name=="Stage1")
			{
				tit="Stage"
				//sql="select clinic_code, short_desc from op_clinic where FACILITY_ID="+facility;
				sql="SELECT STAGE_CODE,SHORT_DESC FROM CP_STAGE";
				search_code="STAGE_CODE";
				search_desc= "SHORT_DESC"
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
			}
</SCRIPT>
</HEAD>
<BODY  OnMouseDown="CodeArrest()"  onKeyDown = 'lockKey()'>
	<FORM name="repPatclassforStageForm" id="repPatclassforStageForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<BR>
	<TABLE width='80%' align='center' valign='top'>
		<TH align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		<TR>
			<TD width="100%" class="Border" align='center'>
				<TABLE width='80%' cellPadding="0" cellSpacing="0"  align='center' >
					<TR>
						<TD align="center" width="25%">&nbsp;</TD>
						<TD class="label" width="30%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></TD>
						<TD class="label" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></TD>
					</TR>
					<TR>
						<TD class="label" align="right">Stage&nbsp;&nbsp;</TD>
						<TD>
							<input type=text  name='p_stage_from' id='p_stage_from' size="10" maxlength="10" align="center">
							<input type='button' name='Stage' id='Stage' value='?' class='button' onclick='searchCode(this, p_stage_from)'>
						</TD>
						<TD>
							<input type=text  name='p_stage_to' id='p_stage_to' size="10" maxlength="10" align="center">
							<input type='button' name='Stage1' id='Stage1' value='?' class='button' onclick='searchCode(this, p_stage_to)'>
						</TD>
					</TR>
					<TR>
						<TD colspan="3">&nbsp;</TD>
					</TR>
	</TABLE>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>"> 
 </form>
<BODY>
<HTML>


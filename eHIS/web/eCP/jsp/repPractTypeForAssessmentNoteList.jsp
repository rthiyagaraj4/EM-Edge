<!DOCTYPE html>
<!-- This JSP is used for Pract Type for assessment noe,Age group for assessment note,Assessment category foe assessment note,Assessment based term code,Assessment based dependency classification -->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<HTML>
<HEAD>
<%
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	<SCRIPT src="../../eCommon/js/ValidateControl.js" language="javascript"></SCRIPT>
	<SCRIPT src="../../eCommon/js/common.js" language="javascript"></SCRIPT>
	<SCRIPT src="../../eCP/js/repCpMasterList.js" language="javascript"></SCRIPT>
	
<%
	String p_module_id = "CP";
	String p_report_id = "" ;
	String mainValue = request.getParameter("mainValue");
	String p_facility_id = (String) session.getValue( "facility_id" ) ;
	String p_user_name = (String) session.getValue( "login_user" ) ;
	String p_resp_id = (String) session.getValue("responsibility_id");
	String displaylabel = "";
	String objname = "";
%>
<script>
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
	if(obj.name=="AssessNote")
	{
		tit="Assessment Note"
		sql="select ASSESS_NOTE_ID ,ASSESS_NOTE_DESC from cp_assess_note";
		search_code="ASSESS_NOTE_ID";
		search_desc= "ASSESS_NOTE_DESC"
	}
	if(obj.name=="AssessCatg")
	{
		tit="Assessment Category"
		sql="select ASSESS_CATG_CODE,SHORT_DESC from cp_assess_catg";
		search_code="ASSESS_CATG_CODE";
		search_desc= "SHORT_DESC"
	}
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);
	if (!(retVal == null))
		target.value=retVal;
	else
		target.focus();
}
</SCRIPT>
</HEAD>
<BODY  OnMouseDown="CodeArrest()"  onKeyDown = 'lockKey()'>
<FORM name="repPractTypeForAssessmentNoteList" id="repPractTypeForAssessmentNoteList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
	/*if(mainValue.equals("CP_TRGD_TERM_CODE_AT_ASSMT"))
	{
		displaylabel = "Assessment Category";
		objname = "AssessCatg";
		p_report_id = "CPBASBTC";
	}
	else
	{*/
		displaylabel = "Assessment Note";
		objname = "AssessNote";
		if(mainValue.equals("CP_ASSESS_NOTE_PRACT_TYPE"))
			p_report_id = "CPBPTANT";
		else if(mainValue.equals("CP_ASSESS_NOTE_AGE_GROUP"))
			p_report_id = "CPBAGANT";
		else if(mainValue.equals("CP_ASSESS_NOTE_ASSESS_CATG"))
			p_report_id = "CPBCGANT";
		else if(mainValue.equals("CP_TRGD_DEP_CLSFN_AT_ASSMT"))
			p_report_id = "CPBASBDC";
		else if(mainValue.equals("CP_ASSESS_CRIT"))
			p_report_id = "CPBACGCR";
		else if(mainValue.equals("CP_ASSESS_NUM_CRIT_SCORE"))
			p_report_id = "CPBACSCR";
		else if(mainValue.equals("CP_ASSESS_NOTE_SPLTY"))
			p_report_id = "CPBSPANT";
	//}
%>
<BR>
<TABLE width='80%' cellPadding="0" cellSpacing="0"  align='center' >
	<TH align='left'colspan='3'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<TR>
		<TD align="center" width="25%">&nbsp;</TD>
		<TD class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></TD>
		<TD class="label" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></TD>
	</TR>
	<TR>
		<TD class="label" align="right"><%=displaylabel%>&nbsp;</TD>
		<TD>
		<input type=text  name='p_Assess_note_from' id='p_Assess_note_from' size="10" maxlength="10" align="center">
		<input type='button' name='<%=objname%>' id='<%=objname%>' value='?' class='button' onclick='searchCode(this, p_Assess_note_from)'>
		</TD>
		<TD>
			<input type=text  name='p_Assess_note_to' id='p_Assess_note_to' size="10" maxlength="10" align="center">
			<input type='button' name='<%=objname%>' id='<%=objname%>' value='?' class='button' onclick='searchCode(this, p_Assess_note_to)'>
		</TD>
	</TR>
	<TR>
		<TD colspan="3">&nbsp;</TD>
	</TR>
	<TR>
		<TD align='right' width='30%' class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;</TD>
		<TD  width='20%' align="left" colspan='2'>
			<select name='p_order_by' id='p_order_by'>
			<option value="1"><fmt:message key="Common.code.label" bundle="${common_labels}"/>
			<option value="2"><fmt:message key="Common.description.label" bundle="${common_labels}"/>
			</select>
		</TD>
	</TR>
	<TR>
		<TD colspan="3">&nbsp;</TD>
	</TR>
</TABLE>
<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id"   value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id"   value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"	  value="<%= p_user_name %>">
<input type="hidden" name="p_resp_id" id="p_resp_id"	  value="<%= p_resp_id %>">
<!-- <input type="hidden" name="mode" id="mode"		  value="<%=objname%>"> -->
</form>
<BODY>
<HTML>


<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
	<%
	//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT src="../../eCommon/js/ValidateControl.js" language="javascript"></SCRIPT>
	<SCRIPT src="../../eCommon/js/common.js" language="javascript"></SCRIPT>
	<SCRIPT src="../../eCP/js/repCpMasterList.js" language="javascript"></SCRIPT>
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
			if(obj.name=="Stagetype")
			{
				tit="Stage "
				sql="select STAGE_CODE,SHORT_DESC from CP_STAGE";
				search_code="STAGE_CODE";
				search_desc= "SHORT_DESC"
			}
			
			if(obj.name=="Stagetype1")
			{
				tit="Stage "
				sql="select STAGE_CODE,SHORT_DESC from CP_STAGE";
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
	<FORM name="repStageListForm" id="repStageListForm">
	<BR>
	<TABLE width='80%' align='center' valign='top'>
		<TH align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		<TR>
			<TD width="100%" class="Border" align='center'>
				<TABLE width='80%' cellPadding="0" cellSpacing="0"  align='center' >
					<TR>
						<TD align="center" width="25%">&nbsp;</TD>
						<TD class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></TD>
						<TD class="label" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></TD>
					</TR>
					<TR>
						<TD class="label" align="right"><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></TD>
						<TD>
							<input type=text  name='p_stage_code_from' id='p_stage_code_from' size="4" maxlength="4" align="center">
							<input type='button' name='Stagetype' id='Stagetype' value='?' class='button' onclick='searchCode(this, p_stage_code_from)'>
						</TD>
						<TD>
							<input type=text  name='p_stage_code_to' id='p_stage_code_to' size="4" maxlength="4" align="center">
							<input type='button' name='Stagetype1' id='Stagetype1' value='?' class='button' onclick='searchCode(this, p_stage_code_to)'>
						</TD>
					</TR>
					<TR>
						<TD colspan="3">&nbsp;</TD>
					</TR>
					<TR>
						<TD align='right' width='30%' class="label"><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/> &nbsp;</TD>
						<TD  width='20%' align="left">
							<select name='p_nature' id='p_nature'>
								<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--
								<option value="PRA"><fmt:message key="eCP.PreAdmit.label" bundle="${cp_labels}"/>
								<option value="POA"><fmt:message key="eCP.PostAdmit.label" bundle="${cp_labels}"/>
								<option value="D"><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/>
								<option value="PD"><fmt:message key="eCP.PostDischarge.label" bundle="${cp_labels}"/>
							</select>
						</TD>
					</TR>
					<TR>
						<TD colspan="3">&nbsp;</TD>
					</TR>
					<TR>
						<TD align='right' width='30%' class="label"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/> &nbsp;</TD>
						<TD  width='20%' align="left">
							<select name='p_nature' id='p_nature'>
								<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
								<option value="E"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
								<option value="D"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/>
							</select>
						</TD>
					</TR>
					<TR>
						<TD colspan="3">&nbsp;</TD>
					</TR>
					<TR>
						<TD align='right' width='30%' class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;</TD>
						<TD  width='20%' align="left">
							<select name='p_order_by' id='p_order_by'>
								<option ><fmt:message key="Common.code.label" bundle="${common_labels}"/>
								<option ><fmt:message key="Common.description.label" bundle="${common_labels}"/>
							</select>
						</TD>
					</TR>
					<TR>
						<TD colspan="3">&nbsp;</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE>
	</FORM>
<BODY>
<HTML>


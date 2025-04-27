<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%		   	 
	//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT src="../../eCommon/js/ValidateControl.js" language="javascript"></SCRIPT>
	<SCRIPT src="../../eCommon/js/common.js" language="javascript"></SCRIPT>
	<SCRIPT src="../../eCP/js/repCpMasterList.js" language="javascript"></SCRIPT>
	<script>
function searchCode(obj,target)
	{
			var retVal = new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facility=obj1.value;
			if(obj.name=="assess_catg1")
			{
				tit="Assessment Category "
				//sql="select clinic_code, short_desc from op_clinic ";
				sql="select ASSESS_CATG_CODE,SHORT_DESC from CP_ASSESS_CATG_LANG_VW where language_id='"+locale+"'";
				search_code="ASSESS_CATG_CODE";
				search_desc= "SHORT_DESC";
			}
			
			if(obj.name=="assess_catg2")
			{
				tit="Assessment Category "
				//sql="select clinic_code, short_desc from op_clinic where FACILITY_ID="+facility;
				sql="select ASSESS_CATG_CODE,SHORT_DESC from CP_ASSESS_CATG_LANG_VW where language_id='"+locale+"'";
				search_code="ASSESS_CATG_CODE";
				search_desc= "SHORT_DESC";
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
	<FORM name="repAssessmentCategoryListForm" id="repAssessmentCategoryListForm">
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
						<TD class="label" align="right"><fmt:message key="eCP.AssessmentCategory.label" bundle="${cp_labels}"/></TD>
						<TD>
							<input type=text  name='p_assess_catg_code_from' id='p_assess_catg_code_from' size="10" maxlength="10" align="center">
							<input type='button' name='assess_catg1' id='assess_catg1' value='?' class='button' onclick='searchCode(this, p_assess_catg_code_from)'>
						</TD>
						<TD>
							<input type=text  name='p_assess_catg_code_to' id='p_assess_catg_code_to' size="10" maxlength="10" align="center">
							<input type='button' name='assess_catg2' id='assess_catg2' value='?' class='button' onclick='searchCode(this, p_assess_catg_code_to)'>
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


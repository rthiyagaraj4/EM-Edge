<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<HTML>
<HEAD>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	<SCRIPT src="../../eCommon/js/ValidateControl.js" language="javascript"></SCRIPT>
	<SCRIPT src="../../eCommon/js/common.js" language="javascript"></SCRIPT>
	<SCRIPT src="../../eCP/js/repCpMasterList.js" language="javascript"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	<%
	//This file is saved on 18/10/2005.
	String p_module_id		= "CP";
	String p_report_id		= "CPBAGTLT" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name	    = (String) session.getValue( "login_user" ) ;
	String p_resp_id		= (String) session.getValue("responsibility_id");
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
			if(obj.name=="agegrouptype")
			{
				tit="AgegroupForTermCode "
				//sql="select clinic_code, short_desc from op_clinic ";
				sql="SELECT age_group_code,long_desc FROM am_age_group";
				search_code="age_group_code";
				search_desc= "long_desc"
			}
			
			if(obj.name=="agegrouptype1")
			{
				tit="AgegroupForTermCode"
				//sql="select clinic_code, short_desc from op_clinic where FACILITY_ID="+facility;
				sql="SELECT age_group_code,long_desc FROM am_age_group";
				search_code="age_group_code";
				search_desc= "long_desc"
			}


			if(obj.name=="Terminologysettype")
			{
				tit="AgegroupForTermCode "
				//sql="select clinic_code, short_desc from op_clinic ";
				sql="select term_set_id,term_set_desc from mr_term_set";
				search_code="term_set_id";
				search_desc= "term_set_desc"
			}
			
			if(obj.name=="Terminologysettype1")
			{
				tit="AgegroupForTermCode"
				//sql="select clinic_code, short_desc from op_clinic where FACILITY_ID="+facility;
				sql="select term_set_id,term_set_desc from mr_term_set";
				search_code="term_set_id";
				search_desc= "term_set_desc"
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
<%
try
{
%>
<BODY  OnMouseDown="CodeArrest()"  onKeyDown = 'lockKey()'>
	<FORM name="repAgeGroupForTermCodeForm" id="repAgeGroupForTermCodeForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<BR>
	<TABLE width='80%' align='center' valign='top'>
		<TH align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	      <TR>
			<TD width="100%" class="Border" align='center'>
				<TABLE width='86%'cellPadding="0" cellSpacing="0"  align='center' >
	    
	             	<!-- <br> -->
		            <TR>
						<TD align="center" width="20">&nbsp;</TD>
						<TD class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></TD>
						<TD class="label" width="40%">&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></TD>
					    </TR>
					 <TR>
						<TD class="label" align="right" nowrap><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/>&nbsp;</TD>
						 <TD>
							<input type=text  name='p_agegroup_code_from' id='p_agegroup_code_from' size="10" maxlength="10" align="center">
							<input type='button' name='agegrouptype' id='agegrouptype' value='?' class='button' onclick='searchCode(this, p_agegroup_code_from)'>
						 </TD>
						<TD>
							<input type=text  name='p_agegroup_code_to' id='p_agegroup_code_to' size="10" maxlength="10" align="center">
							<input type='button' name='agegrouptype1' id='agegrouptype1' value='?' class='button' onclick='searchCode(this, p_agegroup_code_to)'>
						</TD>
					</TR>
			
		                <TR>
						<TD align="center" width="20">&nbsp;</TD>
						<TD class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></TD>
						<TD class="label" width="47%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></TD>
					    </TR>
					 <TR>
						<TD class="label" align="right" nowrap>Terminology Set&nbsp;</TD>
						<TD>
							<input type=text  name='p_TerminologySet_code_from' id='p_TerminologySet_code_from' size="10" maxlength="10" align="center">
							<input type='button' name='Terminologysettype' id='Terminologysettype' value='?' class='button' onclick='searchCode(this, p_TerminologySet_code_from)'>
						</TD>
						 <TD>
							<input type=text  name='p_TerminologySet_code_to' id='p_TerminologySet_code_to' size="10" maxlength="10" align="center">
							<input type='button' name='Terminologysettype1' id='Terminologysettype1' value='?' class='button' onclick='searchCode(this, p_TerminologySet_code_to)'>
						</TD>
					</TR>
						<TR>
						   <TD colspan="3">&nbsp;</TD>
						</TR>
					
				</TABLE>
			</TD>
		</TR>
	</TABLE>
      <input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
      <input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
      <input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
      <input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
      <input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
	</FORM>
</BODY>
	<%
}
catch(Exception exp)
{
	//out.println(exp.getMessage());//common-icn-0181
	exp.printStackTrace();
}
%>
</HTML>


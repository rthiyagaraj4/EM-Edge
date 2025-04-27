<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<HTML>
<HEAD>
<%
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCP/js/repCpMasterList.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/messages.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>	
<script>
function searchCode(target)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	argumentArray[0] = "select intervention_code code, short_desc description  from ca_intervention where eff_status = 'E' and upper(intervention_code) like upper(?) and upper(short_desc) like upper(?) order by short_desc";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = CommonLookup("Intervention", argumentArray );
	if(retVal != null && retVal != "" )  
	{
	target.value = retVal[0] ;
	}
	else
	{
	 target.value ="";
	}
}
</script>
<%
	String p_module_id		= "CP";
	String mainValue= request.getParameter("mainValue")==null?"":request.getParameter("mainValue");
	String p_report_id="";

	if(mainValue.equals("CA_INTERVENTION"))
	{
	    p_report_id		= "CPBINTVN" ;
	}
	else if(mainValue.equals("CA_PAT_CLASS_INTERVENTION"))
	{
		p_report_id     = "CPBPCILT";
	}
	else if(mainValue.equals("CA_INTERVENTION_FREQ"))
	{
		p_report_id     = "CPBFQINV";
	}

	String p_facility_id	= (String) session.getValue("facility_id") ;
	String p_user_name	    = (String) session.getValue("login_user") ;
	String p_resp_id		= (String) session.getValue("responsibility_id");
%>
</HEAD>
<body  OnMouseDown="CodeArrest()"  onKeyDown = 'lockKey()'>
<form name="repInterventionForm" id="repInterventionForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
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
						<TD class="label" align="right">Intervention Code&nbsp;</TD>
						<TD>
							<input type=text  name='p_from_intervention_code' id='p_from_intervention_code' size="10" maxlength="10" align="center"><input type='button' name='btn_intervention_from' id='btn_intervention_from' value='?' class='button' onclick='searchCode(p_from_intervention_code)'>
						</TD>
						<TD>
							<input type=text  name='p_to_intervention_code' id='p_to_intervention_code' size="10" maxlength="10" align="center"><input type='button' name='btn_intervention_to' id='btn_intervention_to' value='?' class='button' onclick='searchCode(p_to_intervention_code)'>					
						</TD>
					</TR>
					<TR>
						<TD colspan="3">&nbsp;</TD>
					</TR>
					<%
                      if(mainValue.equals("CA_INTERVENTION"))
					  {
					%>
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
                    <%
					  }
					%>
					<TR>
						<TD colspan="3">&nbsp;</TD>
					</TR>
					<TR>
						<TD align='right' width='30%' class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;</TD>
						<TD  width='20%' align="left">
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
			</TD>
		</TR>
	</TABLE>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
</form>
</body>
</html>


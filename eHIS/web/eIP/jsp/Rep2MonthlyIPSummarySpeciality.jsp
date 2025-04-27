<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBMCSNS" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
%>

<html>	
<HEAD>
<TITLE></TITLE>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/ValidateControl.js" language='JavaScript'></script>	
	<script src="../../eCommon/js/common.js" language='JavaScript'></script>
	<script src="../../eCommon/js/DateUtils.js" language='JavaScript'></script>
	<script src="../../eCommon/js/CommonCalendar.js" language='JavaScript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
  async function searchCode(obj,target)
		{
				var retVal = 	new String();
				var dialogHeight= "400px" ;
				var dialogWidth="900px";
				/* var dialogHeight= "28" ;
				var dialogWidth	= "43" ; */
				var status = "no";
				var arguments	= "" ;
				var sql="";
				var search_code="";
				var search_desc="";
				var tit="";
				var locale= "<%=locale%>"
	
				if(obj.name=="Speciality")
				{
					var tit=getLabel('Common.speciality.label','common');
					//sql="select speciality_code, short_desc from am_speciality";
					sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"`";
					search_code="speciality_code";
					search_desc= "short_desc";
				}
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
				retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
	
				if (!(retVal == null))
				{
					target.value=retVal;
				}
				else
					target.focus();
		}

	</script>

</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2MonthlyIPSummarySpecialityForm" id="Rep2MonthlyIPSummarySpecialityForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
    Connection con  =null; 
    String isSpltyNurUnitToEnableYNAppl="";
	try
    {
	con  =  ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);
    }
	 catch(Exception e){out.println(e);}
	 finally
	 {		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }

%>
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

	
				<tr>
					<td width='30%' class="label"><fmt:message key="eIP.CensusMonthYear.label" bundle="${ip_labels}"/>&nbsp;</td>
					<td class="fields" width='25%'  >
						<input type=text id="census_date" name='p_trn_date' id='p_trn_date' size="7" value='' maxlength="7" align="center" onblur='validDateObj(this,"MY",localeName);''><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('census_date','mm/y',null);">
						<img align='center' src='../../eMP/images/mandatory.gif'>
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td class="label">&nbsp;</td>
					<td class="label">&nbsp;</td>
				</tr>
				<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="CommonSpecialityLookup.jsp">
					<jsp:param name="speciality_code_Appl" value="p_fr_speciality"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_speciality"/>
					</jsp:include>
					</tr>
				<%}else{%>
				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>				
				<tr>
						<td width='30%' class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;</td>
						<td class="fields" width='20%'  >
							<input type=text  name='p_fr_speciality' id='p_fr_speciality' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_fr_speciality)'>
						</td>
						<td class="fields" width='40%'>
							<input type=text  name='p_to_speciality' id='p_to_speciality' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_to_speciality)'>
						</td>
				</tr><%}%>
				
				<tr>
					<td class="label">&nbsp;</td>
					<td class="label">&nbsp;</td>
				</tr>
				
		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">

	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
		

</form>
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


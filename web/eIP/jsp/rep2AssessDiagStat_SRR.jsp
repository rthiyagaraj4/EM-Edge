<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	Statement stmt			= null;
	ResultSet rset			= null;	
	Connection	con			= null;
	String p_module_id		= "IP" ;
	String p_report_id		= "IPRASDST" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id		= (String) session.getValue("responsibility_id");
	String locale			= (String) session.getAttribute("LOCALE");
%>
<html>
<HEAD>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<script>
		async function searchCode(obj,target)
		{
			var retVal = 	new String();
			var locale= "<%=locale%>"
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql		="";
			var search_code	="";
			var search_desc	="";
			var tit="";
			var allfacilityid	=	document.forms[0].p_all_facility_id.value;
			var locale	=	document.forms[0].locale.value;
			if(obj.name=="diagnosis_fm"  || obj.name=="diagnosis_to")
			{
				tit=getLabel('Common.diagnosis.label','common') 
			//	sql = "select distinct diag_code diag_code ,diag_desc from pr_problem where onset_facility_id=`"+allfacilityid+"` ";

			sql = "select distinct term_code,term_code_short_desc from pr_diagnosis where onset_facility_id=`"+allfacilityid+"` ";

			search_code = "term_code";
			search_desc = "term_code_short_desc";
			}		
			else if(obj.name=="nursing_unit_code_fm")
			{
				tit=getLabel("Common.nursingUnit.label","common");
				sql="select nursing_unit_code, short_desc from IP_NURSING_UNIT_lang_vw where facility_id=`"+allfacilityid+"` and  Language_id=`"+locale+"`";
				search_code="nursing_unit_code";
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

	function chkVal(obj)
	{

		if ( obj.value == "All" )
		{
				document.forms[0].nursing_unit_code_fm.disabled = true;
				document.forms[0].p_fr_nur_unit_code.value	= "";
				document.forms[0].p_fr_nur_unit_code.disabled = true;
				document.forms[0].p_fr_diag_code.disabled	 = true
				document.forms[0].p_to_diag_code.disabled	 = true
				document.forms[0].diagnosis_fm.disabled	= true
				document.forms[0].diagnosis_to.disabled		= true
		}
		else
		{
				document.forms[0].nursing_unit_code_fm.disabled = false;
				document.forms[0].p_fr_nur_unit_code.disabled = false;
				document.forms[0].p_fr_nur_unit_code.value	= "";
				document.forms[0].p_fr_diag_code.disabled	 = false
				document.forms[0].p_to_diag_code.disabled	 = false
				document.forms[0].diagnosis_fm.disabled	= false
				document.forms[0].diagnosis_to.disabled		= false
		}
				document.forms[0].p_fr_diag_code.value = ""
				document.forms[0].p_to_diag_code.value = ""
	}
	function chkWithSysDt(obj){
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
}
	</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="repAssesDiagStatForm" id="repAssesDiagStatForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>
   <th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
   <tr>
	<td width="100%" class="Border" align='center'>
	<table width='80%' cellPadding="0" cellSpacing="0"  align='center'>
	 <tr>		
	   	<td align='right' class="label" width='30%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/> &nbsp;</td>
		<td  align="left">				
	   	 	<select name='p_all_facility_id' id='p_all_facility_id' onchange ="chkVal(this)">			
			<%
						try
						{
							con		=	ConnectionManager.getConnection(request);
							stmt=con.createStatement();
							String fid;
							String fname;
							//String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";	
							
							String all_access = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels");

							String sql1 = "	select 'All' facility_id, '"+all_access+"' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"'  and p.language_id='"+locale+"'  and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2";	
							rset=stmt.executeQuery(sql1);
							if(rset!=null)
							{
							   while(rset.next())
							   {
								fid=rset.getString("facility_id");
								fname=rset.getString("facility_name");
								if(fid.equals("All"))
								out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
								else
								out.println("<option value='"+fid+ "' >"+fname+"</option>");
							   }
							}
						
%>			</select>
		</td>
		</tr>
		<tr>
			<td class="label" >&nbsp;</td>
			<td class="label">&nbsp;</td>
		</tr>
		<tr>
			<td class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type=text  disabled name='p_fr_nur_unit_code' id='p_fr_nur_unit_code' size="4" maxlength="4" align="center"><input type='button'  disabled name='nursing_unit_code_fm' id='nursing_unit_code_fm' value='?' class='button' onclick='searchCode(this, p_fr_nur_unit_code)'>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		</table>

		<table width='80%' cellPadding="0" cellSpacing="0"  align='center'>
		<tr>
			<td width='30%'>&nbsp;</td>	
			<td align="left" class="querydata" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td align="left" class="querydata"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td align='right'  class="label"><fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/> &nbsp;</td>
			<td class="fields" align='left'>
				<input type=text  disabled name='p_fr_diag_code' id='p_fr_diag_code' size="10" maxlength="10" align="center"><input type='button' disabled name='diagnosis_fm' id='diagnosis_fm' value='?' class='button' onclick='searchCode(this, p_fr_diag_code)'>
			</td>
			<td class="fields" align='left'>
				<input type=text  disabled  name='p_to_diag_code' id='p_to_diag_code' size="10"  maxlength="10" align="center"><input type='button' disabled name='diagnosis_to' id='diagnosis_to' value='?' class='button' onclick='searchCode(this, p_to_diag_code)'>
			</td>
		</tr>
		<tr>
			<td class="label" >&nbsp;</td>
			<td class="label">&nbsp;</td>
		</tr>

		<tr>
			<td align='right' class="label"><fmt:message key="Common.Period.label" bundle="${common_labels}"/> &nbsp;</td>
			<td class="fields" align='left'><input type=text id="p_date_from"  name='p_fr_date' id='p_fr_date' size="10" maxlength="10" align="center" onblur='if(validDateObj(this,"DMY","<%=localeName%>")){chkWithSysDt(this);}'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_from');"/></td>
			<td class="fields" align='left'><input type=text id="p_date_to"  name='p_to_date' id='p_to_date' size="10" maxlength="10" align="center" onblur='if(validDateObj(this,"DMY","<%=localeName%>")){chkWithSysDt(this);}'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_to');"/></td>
		</tr>
		<tr>
			<td class="label" >&nbsp;</td>
			<td class="label">&nbsp;</td>
		</tr>	
		<tr>
<td  class="label" ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td class="fields" align='left'>
<SELECT name="P_ORDER_BY" id="P_ORDER_BY">
<option value="1"><fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/></option>
<option	value="2"><fmt:message key="Common.DiagnosisDescription.label" bundle="${common_labels}"/></option>
</SELECT>
</td>
<td class="fields"  align='left'>
<SELECT name="P_ORDER_TYPE" id="P_ORDER_TYPE">
<option value="asc"><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
<option	value="desc"><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option>
</SELECT>
</td>
</tr>
		</table>
		</td>
	</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
<input type="hidden" name="locale" id="locale"				value="<%= locale %>">

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
<%}catch(Exception e)
						{
							out.println(e);
						}
						finally 
						{ 
							
							ConnectionManager.returnConnection(con,request);
						}
	%>

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


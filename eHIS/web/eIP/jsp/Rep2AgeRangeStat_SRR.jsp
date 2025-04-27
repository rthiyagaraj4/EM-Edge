<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBARSTA" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String p_resp_id			=	(String) session.getValue("responsibility_id");
	String locale = (String)session.getAttribute("LOCALE");

	Connection	con		=	null;
	Statement	stmt			=	null;
	ResultSet	rset			=	null;
%>
<html>
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
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
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var allfacilityid	=	document.forms[0].p_all_facility_id.value;
			
			if(obj.name=="age_range")
			{
				tit=getLabel('Common.AgeRange.label','Common');
				//sql="select range_id, short_desc from am_summ_range where eff_status = `E` "

				sql="select range_id, short_desc from am_summ_range_lang_vw where eff_status = `E` and language_id=`"+locale+"` "
				search_code="range_id";
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

		/*if ( obj.value == "All" )
		{
				document.forms[0].p_fm_age_range.disabled = true
				document.forms[0].age_range.disabled = true
				document.forms[0].mand_image1.style.visibility='hidden';
		}
		else
		{*/
				document.forms[0].p_fm_age_range.disabled = false
				document.forms[0].age_range.disabled = false
				document.forms[0].mand_image1.style.visibility='visible';
		//}

				document.forms[0].p_fm_age_range.value = ""
				document.forms[0].P_FR_TRN_DATE_TIME.value = ""
				document.forms[0].P_TO_TRN_DATE_TIME.value = ""
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

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()' onload='FocusFirstElement()'>
<br>
<br>
<form name="Rep2AgeRangeStatForm" id="Rep2AgeRangeStatForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>
		<td width="100%" class="Border" align='center'>
			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
			<!-- To Populate Facility List -->
				<tr>
					<td align="right" class="label" > <fmt:message key="Common.facility.label" bundle="${common_labels}"/> &nbsp;</td>
					<td > 
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

							String sql1 = "select 'All' facility_id, '"+all_access+"' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"'  and p.language_id='"+locale+"'  and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2";	

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
							if(rset!=null)rset.close();
							if(stmt!=null)stmt.close();
						}catch(Exception e)
						{
							out.println(e);
						}
						finally 
						{ 
							ConnectionManager.returnConnection(con,request);
						}
						%>	
						</select>
					</td>
				</tr>
				<tr><td colspan='2'>&nbsp;</td>
				<tr>
						<td align='right' class="label"><fmt:message key="Common.AgeRange.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
						<td >
							<input type=text  name='p_fm_age_range' id='p_fm_age_range' size="4" maxlength="4" align="center"><input type='button'  name='age_range' id='age_range' value='?' class='button' onclick='searchCode(this, p_fm_age_range)'><img src='../../eCommon/images/mandatory.gif' id='mand_image1' align='center'></img>
						</td>
				</tr>
				<tr><td colspan='2'>&nbsp;</td></tr>
				<tr>
				<td class="label">&nbsp;</td>
				<td class="querydata" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;</td>
				<td class="querydata" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			</tr>
				<tr>
						<td align='right' class="label"><fmt:message key="Common.admit.label" bundle="${common_labels}"/>  <fmt:message key="Common.date.label" bundle="${common_labels}"/> &nbsp;</td>
						<td>
							<input type=text id="adm_date_from"  name='P_FR_TRN_DATE_TIME' id='P_FR_TRN_DATE_TIME' size="10" maxlength="10" align="center" onblur='if(validDateObj(this,"DMY","<%=localeName%>")){chkWithSysDt(this);}'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('adm_date_from');"><img src='../../eCommon/images/mandatory.gif'align='center'></img>
						</td>
						<td>
							<input type=text id="adm_date_to"  name='P_TO_TRN_DATE_TIME' id='P_TO_TRN_DATE_TIME' size="10" maxlength="10" align="center" onblur='if(validDateObj(this,"DMY","<%=localeName%>")){chkWithSysDt(this);}'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('adm_date_to');"><img src='../../eCommon/images/mandatory.gif'align='center'></img>
						</td>
				</tr>
				<tr><td colspan='2'>&nbsp;</td>
		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
	<input type="hidden" name="p_resp_id" id="p_resp_id"		value="<%= p_resp_id %>">

	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
		

</form>
<script>
document.forms[0].p_all_facility_id.focus() ;
</script>
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


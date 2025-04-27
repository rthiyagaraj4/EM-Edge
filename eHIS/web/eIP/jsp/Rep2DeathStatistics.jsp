<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	Statement		stmt			= null ;
	ResultSet		rset 			= null ;
	Connection	con			= null;

	String p_module_id		= "IP" ;
	String p_report_id		= "IPBDTHST" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id		= (String) session.getValue("responsibility_id");
	String locale = (String)session.getAttribute("LOCALE");
	String isSpltyNurUnitToEnableYNAppl="";//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>
<script src="../../eCommon/js/DateUtils.js" language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var locale= "<%=locale%>"
			/* var dialogHeight= "28" ;
			var dialogWidth	= "43" ; */
			var dialogTop = "10px" ;
			var dialogHeight= "400px" ;
			var dialogWidth="900px";
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var allfacilityid	=	document.Rep2DeathStatistics.p_all_facility_id.value;
			if(obj.name=="nursing")
			{
				tit=getLabel('Common.nursingUnit.label','common');

				
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where language_id=`"+locale+"`";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}
			if(obj.name=="race")
            {
	         tit= getLabel('Common.race.label','common');
	         sql="select race_code, short_desc from mp_race_lang_vw where language_id=`"+localeName+"`";
	         search_code="race_code";
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


	function dateVal( obj )
	{
		if(obj.value !="")
		{
			if(!doDateTimeChk(obj))
			{
				obj.focus()
				alert( parent.parent.parent.frames[0].getMessage("INVALID_DATE_TIME","SM") )
			}
		}
	}

	
</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2DeathStatistics" id="Rep2DeathStatistics" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>
		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>	</th>
	<tr>
		<td width="100%" class="Border" align='center'>
			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
				<!-- To Populate Facility List -->
				<tr>
					<td align="right" class="label" > <fmt:message key="Common.facility.label" bundle="${common_labels}"/> &nbsp;</td>
					<td colspan ="3"> 
						<select name='p_all_facility_id' id='p_all_facility_id' >
							<%
							try
							{
								con		=	ConnectionManager.getConnection(request);
								isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
								stmt=con.createStatement();
								String fid ;
								String fname;
								//String sql1 = "select 'ALL' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";	
								
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
							{	out.println(e); e.printStackTrace();}
							finally { ConnectionManager.returnConnection(con,request); }
							%>	
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

<tr>
<td class="label" align="right"><fmt:message key="Common.race.label" bundle="${common_labels}"/> &nbsp;</td>
<td class="fields" ><input type="text" name="p_race_code" id="p_race_code" size="6" maxlength="6"><input type='button' name='race' id='race' value='?' class='button' onclick="searchCode(this, p_race_code,'N')"></td>
</tr>

				
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
		
		
				<!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
				<tr>
				<jsp:include page="CommonNursingUnitLookup.jsp">
				<jsp:param name="nursing_unit_code_Appl" value="p_fm_code"/>
				<jsp:param name="nursing_unit_to_code_Appl" value="p_to_code"/>
				</jsp:include>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				
				<%}else{%>
				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				

				<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='40%'>
							<input type=text  readonly name='p_fm_code' id='p_fm_code' size="4" maxlength="4" align="center"><input type='button'  name='nursing' id='nursing' value='?' class='button' onclick='searchCode(this, p_fm_code)'>
						</td>
						<td width='40%'> 
							<input type=text  readonly name='p_to_code' id='p_to_code' size="4" maxlength="4" align="center"><input type='button' name='nursing' id='nursing' value='?' class='button' onclick='searchCode(this, p_to_code )'>
				</tr>			
				<%}%>
				

				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

				<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.DeceasedDate.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='40%'>
							<input type=text id="adm_date_from" name='p_fm_date' id='p_fm_date' size="10" maxlength="10" align="center" onblur="validDateObj(this,'DMY','<%=localeName%>')"><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('adm_date_from');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
						<td width='40%'> 
							<input type=text id="adm_date_to" name='p_to_date' id='p_to_date' size="10" maxlength="10" align="center" onblur="validDateObj(this,'DMY','<%=localeName%>')"><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('adm_date_to');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
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
	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
	
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">
	<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
</form>
<script>
	document.forms[0].p_all_facility_id.focus();
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


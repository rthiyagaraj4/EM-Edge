<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.*, java.util.*,java.sql.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eMP/js/repRegnStatByNatEthGrpDtl.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	String p_module_id		= "MP" ;
	String p_report_id		= "MPBSTNEG" ;
	String p_facility_id1	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id		= (String)session.getValue("responsibility_id");
    Connection con = null;
	Statement stmt = null;
	ResultSet rset = null;
%>
<html>
<HEAD>
<script>
async function searchCode(obj,target)
{
			var retVal = 	new String();
			//var dialogHeight= "28" ;
			//var dialogWidth	= "43" ;
			var dialogHeight= "400px" ;
			var dialogTop = "10px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			
			if(obj.name=="nationality")
			{
				tit=getLabel('Common.NationalityCode.label','common');
				//sql="select distinct nationality_code,long_desc  from mp_country,mp_patient where nationality_code=country_code";
				sql="select country_code, long_desc from mp_country_lang_vw where language_id=`"+localeName+"`";
				//search_code="nationality_code";
				search_code="country_code";
				search_desc= "long_desc";
			}
			else if(obj.name=="ethnic")
			{
				tit=getLabel('eMP.EthnicityCode.label','MP');
				sql="select ethnic_group_code ,long_desc from MP_ETHNIC_GROUP_lang_vw  where language_id=`"+localeName+"`";
				search_code="ethnic_group_code";
				search_desc= "long_desc";
			}
			else if(obj.name=="race")
			{
				tit=getLabel('eMP.RaceCode.label','MP');
			
			
			sql="select  race_code ,long_desc from mp_race_lang_vw where language_id=`"+localeName+"`";
				search_code="race_code";
				search_desc= "long_desc";
			}
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+escape(sql)+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
</script>
</HEAD>

<BODY onLoad="Focusing('p_fm_regndate')" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repethnic" id="repethnic" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top' cellpadding='0'>
		<td class='columnheader'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
	<tr>
		<td width="100%" class="Border" align='center'>

				<table width='80%' cellPadding="3" cellSpacing="0"  align='center' >
				<tr>
						<td width='30%' >&nbsp;</td>
						<td  width='30%'> </td>
						<td width='40%'> </td>
				</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
					<td class='fields'><select name='facility_id' id='facility_id'>
					<%
					try
					{
					con = ConnectionManager.getConnection(request);
					stmt=con.createStatement();
					String fid;
					String fname;
					String sql1 = "SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  2 ";			
										
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

					}catch(Exception e)
					{
						out.println(e);
					}
					finally
					{
					if(rset	 != null)   rset.close();
					if(stmt != null)	stmt.close();
					if(con!=null) ConnectionManager.returnConnection(con,request);	
					}
					%>
				</select>
				</td></tr>
				<tr>
				<td >&nbsp;</td>
				<td class="querydata" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td> 
				<td class="querydata" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
    			<tr>
				<td class="label"><fmt:message key="Common.RegistrationDate.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text"  name="p_fm_regndate" id="p_fm_regndate" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_regndate');"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>

				<td class='fields'><input type="text" name="p_to_regndate" id="p_to_regndate" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_regndate');"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<tr> 
					<td class="label" nowrap><fmt:message key="Common.NationalityCode.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type=text  name='p_fm_nationality_code' id='p_fm_nationality_code' size="4" maxlength="4" ><input type='button' name='nationality' id='nationality' value='?' class='button' onclick='searchCode(this, p_fm_nationality_code)'>
					</td>
					<td class='fields'><input type=text  name='p_to_nationality_code' id='p_to_nationality_code' size="4" maxlength="4" ><input type='button' name='nationality' id='nationality' value='?' class='button' onclick='searchCode(this, p_to_nationality_code)'>
					</td>
				</tr>
				<tr> 
					<td class="label"><fmt:message key="eMP.RaceCode.label" bundle="${mp_labels}"/></td>
					<td class='fields'><input type=text  name='p_fm_race_code' id='p_fm_race_code' size="6" maxlength="6" ><input type='button' name='race' id='race' value='?' class='button' onclick='searchCode(this, p_fm_race_code)'>
					</td>
					<td class='fields'><input type=text  name='p_to_race_code' id='p_to_race_code' size="6" maxlength="6" ><input type='button' name='race' id='race' value='?' class='button' onclick='searchCode(this, p_to_race_code)'>
					</td>
				</tr>
			<tr> 
					<td class="label"><fmt:message key="eMP.EthnicityCode.label" bundle="${mp_labels}"/></td>
					<td class='fields'><input type=text  name='p_fm_ethnic_grp_code' id='p_fm_ethnic_grp_code' size="6" maxlength="6" ><input type='button' name='ethnic' id='ethnic' value='?' class='button' onclick='searchCode(this, p_fm_ethnic_grp_code)'>
					</td>
					<td class='fields'><input type=text  name='p_to_ethnic_grp_code' id='p_to_ethnic_grp_code' size="6" maxlength="6" ><input type='button' name='ethnic' id='ethnic' value='?' class='button' onclick='searchCode(this, p_to_ethnic_grp_code)'>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
		</table>
	</td>
</tr>
</table>
    <input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=p_facility_id1 %>">
	<input type="hidden" name="p_module_id" id="p_module_id" value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">
	<input type="hidden" name="p_resp_id" id="p_resp_id"	value="<%= p_resp_id %>">
<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
</form>
</BODY>
</HTML>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


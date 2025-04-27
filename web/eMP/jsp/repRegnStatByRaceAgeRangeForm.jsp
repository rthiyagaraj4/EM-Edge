<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%	
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");	
%>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></script>
<script src="../../eCommon/js/common.js" language="JavaScript"></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eMP/js/repRegnStatByRaceAgeRange.js" language="JavaScript"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function onChangeFacilityId()
{
    var facltyid = document.repRegnAgeRelgnStat.P_facilityid.value;
	var optlength = document.repRegnAgeRelgnStat.p_age_range_code.options.length;
	if(facltyid=='All')
	{
		document.repRegnAgeRelgnStat.p_age_range_code.disabled=true;
	}
	else
	{
				document.repRegnAgeRelgnStat.p_age_range_code.disabled=false;
	for (var i=0; i<optlength; i++)
	{
		document.repRegnAgeRelgnStat.p_age_range_code.options.remove("p_age_range_code");
	}
		var HTMLVal="<html><body onKeyDown='lockKey()'><form name='GetAgeRangeForm' id='GetAgeRangeForm' method='get' action='../../eMP/jsp/GetAgeRange.jsp'>"+
				"<input type='hidden' name='facility' id='facility' value='"+facltyid+"'>"+
		"</form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.messageFrame.document.GetAgeRangeForm.submit();
	}
}

async function searchCode(obj,target,Ar_installed)
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
if(obj.name=="race")
{
	tit=getLabel('Common.race.label','common');
	sql="select race_code, short_desc from mp_race_lang_vw where language_id=`"+localeName+"`";
	search_code="race_code";
	search_desc= "short_desc";
}
var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

if (!(retVal == null))
	target.value=retVal;
else
	target.focus();
}
//-->
</SCRIPT>

<%
String p_module_id	= "MP" ;
String p_report_id	= "MPBSTRAG" ;
String p_facility_id = (String) session.getAttribute( "facility_id" ) ;
String p_user_name	= (String) session.getAttribute( "login_user" ) ;
String p_resp_id = (String)session.getAttribute("responsibility_id");
Connection con = null;
PreparedStatement pstmt = null ;
ResultSet rs = null;
%>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
<center>
<form name="RaceAgeRange" id="RaceAgeRange" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR> 
<table border="0" width="60%" cellpadding='3' cellspacing='0'>
<tr>
	<td width='25%'>&nbsp;</td>
	<td width='25%'>&nbsp;</td>
	<td width='15%'>&nbsp;</td>
	<td width='35%'>&nbsp;</td>
</tr>
<tr>
	<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	<td class='fields'><select name='P_facilityid' id='P_facilityid'><!--  onChange='onChangeFacilityId()'> -->
	<%
	try
	{
	con = ConnectionManager.getConnection(request);
	Statement stmt=con.createStatement();
	String fid;
	String fname;
	//String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";					
	String sql1 = "SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  2 ";					

	ResultSet rset=stmt.executeQuery(sql1);
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
	if (rset != null) rset.close();
	if (stmt != null) stmt.close();
	}catch(Exception e)
	{
		out.println(e);
	}
	%>
	</select>
	</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
<tr>
	<td class="label" ><fmt:message key="Common.AgeRange.label" bundle="${common_labels}"/></td>
	<td colspan="3" class='fields'><select name="p_age_range_code" id="p_age_range_code" >
		<option value='' >-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>
		<%
			try
			{
				pstmt 	= con.prepareStatement( "select range_id, long_desc from am_summ_range_lang_vw where range_type='A' and language_id='"+localeName+"' and  trunc(sysdate) between nvl(trunc(eff_date_from),trunc(sysdate)) and nvl(trunc(eff_date_to),trunc(sysdate)) and eff_status ='E' order by 2");

				rs = pstmt.executeQuery() ;

				if( rs != null )
				{
					while( rs.next() )
					{
						String range_id 	= rs.getString( "range_id" ) ;
						String long_desc 	= rs.getString( "long_desc" ) ;
						out.println( "<option value='"+range_id+"' >"+long_desc+"</option>") ;
					}
				}
			}catch(Exception e) { out.println(e.toString());}
			finally
			{
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
	
		%>
		</select><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
			<td >&nbsp;</td>
			<td class="querydata" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td> 
			<td >&nbsp;</td>
			<td class="querydata" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>
<tr>
	<td class="label" ><fmt:message key="Common.RegistrationDate.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" id='regnagenatstatfrom' name="p_fm_regndate" id="p_fm_regndate" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regnagenatstatfrom');"><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class="label">&nbsp;</td>
	<td class='fields'><input type="text" id='regnagenatstatto' name="p_to_regndate" id="p_to_regndate" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regnagenatstatto');"><img src='../../eCommon/images/mandatory.gif'></img>

	</td>
</tr>
<tr>
	<td class="label" ><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="p_fm_race_code" id="p_fm_race_code" size="6" maxlength="6"><input type='button' name='race' id='race' value='?' class='button' onclick="searchCode(this, p_fm_race_code,'N')"></td>
	<td class="label" >&nbsp;</td>
	<td class='fields'><input type="text" name="p_to_race_code" id="p_to_race_code" size="6" maxlength="6"><input type='button' name='race' id='race' value='?' class='button' onclick="searchCode(this, p_to_race_code,'N')"></td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
</table>

<br>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
	<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
</form>

</center>
</body>
</html>

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


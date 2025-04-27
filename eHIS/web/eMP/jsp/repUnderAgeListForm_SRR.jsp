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
<Script src="../js/repUnderAgeList_SRR.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
 <% 
String p_module_id	= "MP" ;
String p_report_id	= "MPBUAMOT" ;
String p_facility_id = (String) session.getAttribute( "facility_id" ) ;
String p_user_name	= (String) session.getAttribute( "login_user" ) ;
String p_resp_id = (String)session.getAttribute("responsibility_id");
String locale = (String)session.getAttribute("LOCALE");
Connection con = null;
Statement stmt = null;
ResultSet rset = null;


%>
<script>
function setDate(Object){ 

       if(Object.value!="")
	{
	   if (isBeforeNow(Object.value,"DMY",localeName))
        {
          return true;
        }
        else
        {
			alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
			Object.value="";
            Object.focus();            
        }
    }
	}
</script>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
<center>
<form name="UnderAge" id="UnderAge" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR> 
<table border="0" width="70%" cellpadding='3' cellspacing='0'>
<tr>
	<td width='30%'>&nbsp;</td>
	<td width='30%'>&nbsp;</td>
	<td width='10%'>&nbsp;</td>
	<td width='30%'>&nbsp;</td>
</tr>
<tr>
<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class='fields'><select name='P_facilityid' id='P_facilityid'><!--  onChange='onChangeFacilityId()'> -->
<%
try
{
con = ConnectionManager.getConnection(request);
stmt=con.createStatement();
int mother_min_age=0;
int cutoff_age=0;
int j=1;
String fid;
String fname;
String groupby_sql;
String sql1 = "SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  2";

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
	if (rset != null) rset.close();
	if (stmt != null) stmt.close();

%>
</select>
</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
	<!-- <td class="label"><fmt:message key="eMP.BirthDateFrom.label" bundle="${mp_labels}"/>(<fmt:message key="Common.Mother.label" bundle="${common_labels}"/>)</td> -->
	<td class="label"><fmt:message key="Common.birthDate_fs.label" bundle="${common_labels}"/>(<fmt:message key="eMP.Baby.label" bundle="${mp_labels}"/>)&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>

	<td class='fields' ><input type="text" name="p_from_birth_date" id="p_from_birth_date" size="10" maxlength="10" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_from_birth_date');"><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	<td class='fields' ><input type="text" name="p_to_birth_date" id="p_to_birth_date" size="10" maxlength="10" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_to_birth_date');"><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
<td class="label"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.age.label" bundle="${common_labels}"/>(<fmt:message key="Common.Mother.label" bundle="${common_labels}"/>) </td>
<!-- <td class='fields'><select name='p_group_by_age' id='p_group_by_age'> -->
<td class='fields'><select name='p_grp_age_mom' id='p_grp_age_mom'>
<%
stmt=con.createStatement();

groupby_sql = "select nb_mother_min_age ,nb_mother_cutoff_age from mp_param";
rset=stmt.executeQuery(groupby_sql);
if(rset!=null)
{
   while(rset.next())
   {
	mother_min_age=rset.getInt("nb_mother_min_age");
	cutoff_age=rset.getInt("nb_mother_cutoff_age");
   }
}
if(mother_min_age==cutoff_age)
	out.println("<option value='"+cutoff_age+ "'>"+cutoff_age+"</option>");
else
{
	for(int i=cutoff_age;i<=mother_min_age-1;i++)
	{	
		out.println("<option value='"+i+ "'>"+i+"</option>");
		j++;
	}
}

	if (rset != null) rset.close();
	if (stmt != null) stmt.close();
		%>

</td>
</tr>
   
<%
}catch(Exception e){
	out.println(e);
}finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>



</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
	<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
	<input type="hidden" name="locale" id="locale"		value="<%=locale%>">
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


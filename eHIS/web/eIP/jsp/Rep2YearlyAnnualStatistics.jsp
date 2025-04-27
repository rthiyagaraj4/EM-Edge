<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
 
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBYRAST" ;
	String CurrentDate = "";
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String p_resp_id			=	(String) session.getValue("responsibility_id");
	String locale = (String)session.getAttribute("LOCALE");

	Connection	con		=	ConnectionManager.getConnection(request);
	Statement	stmt			=	null;
	Statement	stmt1			=	null;
	ResultSet	rset			=	null;
	ResultSet	rset1			=	null;
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eCommon/js/common.js" language="JavaScript"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
<script src="../../eCommon/js/DateUtils.js" language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

		function validate_date(obj) 
		{
			var from = convertDate(obj.value,'YY',localeName,'en');
			var to   = convertDate(document.forms[0].CurrentDate.value,'YY',localeName,'en');
			
				if(to < from) 
				{
					var invaldt = getMessage("CAN_NOT_GREAT_CURR_YR","IP") ;
					var stat_year=getLabel("Common.statistics.label","Common")+" "+getLabel("Common.year.label","Common");
					invaldt = invaldt.replace('$',stat_year);
					alert(invaldt);
					obj.focus();
					obj.select();
				}
			
		}

	function validDate(date, format, locale){
//alert(''+format)
	var dateFlag=true;
	var dateArr;
	var dateArr1;
	if(format=="YY"){
		if(date==0000){
			dateFlag=false;
		}
	}

	if(dateFlag){
		var xhr =  getXHR();
		var url = "../../eCommon/jsp/DateUtils.jsp?methodName=validDate&format="+format+"&locale="+locale+"&date="+date;
		xhr.open("POST", url, false);
		xhr.setRequestHeader("Content-Type","text/plain")
		xhr.send("");
		var xmlText = xhr.responseText
		if (TrimStr(xmlText) == "true"){
			dateFlag=true;
		}else{
			dateFlag=false;
		}
	}
	return dateFlag;
}

function validDateObj(date, format, locale){
	if (date.value != '')
	{
		if ( !validDate(date.value, format, locale) )
		{
			if(top.header != null)
				alert(top.header.getMessage("INVALID_DATE_FMT", "SM"));
			else
				alert(getMessage("INVALID_DATE_FMT", "SM"));

			date.select();
			date.focus();
			return false;
		}
		else
			return true;
	}
}
</script>
</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<br>
<br>
<form name="RepYearlyAnnualStatistics" id="RepYearlyAnnualStatistics" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<table width='80%' align='center' valign='top'>
		<th align='left'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
					<td  class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
					<td  class="fields"> 
							<select name='p_for_facility_id' id='p_for_facility_id' >
						<%
							try
							{
							stmt=con.createStatement();
							String fid;
							String fname;
							String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name,to_char(sysdate,'yyyy') CurrentDate from dual union select u.facility_id facility_id, p.facility_name facility_name,to_char(sysdate,'yyyy')CurrentDate from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";					
							rset=stmt.executeQuery(sql1);
							if(rset!=null)
							{
							   while(rset.next())
							   {
								fid=rset.getString("facility_id");
								fname=rset.getString("facility_name");
								CurrentDate=rset.getString("CurrentDate");
								CurrentDate = DateUtils.convertDate(CurrentDate,"YY","en",locale);
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
								if(rset != null)    rset.close();
								if(stmt != null)    stmt.close();
								if(rset1 != null)    rset1.close();
								if(stmt1 != null)    stmt1.close();
								ConnectionManager.returnConnection(con,request);
							}

						%>	
						</select>
					</td>
					<td width='40%'>&nbsp;</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
					<td  class="label"><fmt:message key="Common.statistics.label" bundle="${common_labels}"/> &nbsp;<fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
					<td  class="fields"><input type=text  name='p_trn_date' id='p_trn_date' size="4" maxlength="4" align="center" id='p_trn_date' onblur='validDateObj(this,"YY",localeName);validate_date(this);'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_trn_date','y',null)"><img align='center' src='../../eMP/images/mandatory.gif'>
					</td>
					<td >&nbsp;</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
	<input type="hidden" name="p_resp_id" id="p_resp_id"		value="<%= p_resp_id %>">
	<input type="hidden" name="CurrentDate" id="CurrentDate"		value="<%= CurrentDate %>">
		<%if(localeName.equals("en"))
	{%>
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>

</form>
<script>
	document.forms[0].p_for_facility_id.focus()
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


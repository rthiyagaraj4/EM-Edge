<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

 <%
    request.setCharacterEncoding("UTF-8");
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBDYSUM" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	Connection con = ConnectionManager.getConnection(request);
	Statement stmt=null;
	ResultSet rs =null;
	String str = "select to_char(sysdate,'dd/mm/yyyy') from dual";
	String CurrentDate="";
	String NationalityVal="";
	try{
		stmt=con.createStatement();
		rs = stmt.executeQuery(str);	
		while (rs.next())
			CurrentDate= rs.getString(1);	
		str = "Select country_code, long_desc from MP_COUNTRY  Order by 2";
		//latha
		if(rs!=null) rs.close();
		//end
		rs = stmt.executeQuery(str);
		if(rs!=null)
		{
		  while(rs.next())
					NationalityVal =  NationalityVal + "<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>";
	    }				
	}catch(Exception e)
	{}
	finally
	{
		if(stmt!=null) stmt.close();
		if(rs!=null)	rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
<html>	
<HEAD>
<TITLE></TITLE>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<script>
async	function searchCode(obj,target)
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
	
				//alert(obj.name)
				if(obj.name=="nursing_unit")
				{
					tit="Nursing Unit"
					sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`<%=p_facility_id%>`";
					search_code="nursing_unit_code";
					search_desc= "short_desc";
				}
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
				retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);
	
				if (!(retVal == null))
				{
					target.value=retVal;
				}
				else
					target.focus();
		}

		 function validate_date(obj) {
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

<BODY onMouseDown="CodeArrest();" onload="FocusFirstElement()" onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2DailyIPCensusSummaryForm" id="Rep2DailyIPCensusSummaryForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

	
				<tr>
					<td width='30%' class="label"><fmt:message key="eIP.CensusDate.label" bundle="${ip_labels}"/></td>
					<td width='20%' class="fields">
						<input type=text  name='census_date'  id="census_date"  onblur ="if(validDateObj(this,'DMY',localeName))validate_date(this)" size="10" maxlength="10" align="center" ><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('census_date');"><img align='center' src='../../eMP/images/mandatory.gif'>
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
	<tr>		
		<td  class="label" ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
		<td colspan ="3" class="fields"> 
				<select name='P_NATIONALITY_CODE' id='P_NATIONALITY_CODE'>
				<option value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----------</option>
				<%=NationalityVal%>
				</select><img src='../../eCommon/images/mandatory.gif'align='center'></img>
		</td>		
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>				
		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
	<input type="hidden" name="CurrentDate" id="CurrentDate"			value="<%= CurrentDate %>">

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


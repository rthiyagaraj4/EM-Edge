<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	Connection	con		=	null;
	String p_resp_id			=	(String) session.getValue("responsibility_id");
	Statement stmt;
	ResultSet rset;
%>
<html>	
<HEAD>
<TITLE></TITLE>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/CommonCalendar.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function mychange()
 {
	 if (document.getElementById("p_type").value=='M')
	 {
		document.getElementById("MY1").innerHTML=getLabel('eIP.CensusMonth.label','IP')+"&nbsp;";
		document.getElementById("MY").innerHTML = "<input type='text' name='p_trn_date' id='p_trn_date' maxlength='5' size='5' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_trn_date.select();return showCalendar('p_trn_date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("p_type").value=='Y')
	 {
		 document.getElementById("MY1").innerHTML=getLabel('Common.CensusYear.label','Common')+"&nbsp;";
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_trn_date' id='p_trn_date' maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_trn_date.select();return showCalendar('p_trn_date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }			
async function searchCode(obj,target)
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
	if(obj.name=="bed_class")
	{
		tit=getLabel('Common.BedClass.label','common')
		sql="select bed_class_code, short_desc from ip_bed_class";
		search_code="bed_class_code";
		search_desc= "short_desc";
	}
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
	if (!(retVal == null))
		target.value=retVal;
	else
		target.focus();
}
</script>

</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()' onLoad="mychange()">
<br>
<br>
<form name="Rep2MthYrlyCensusFacility" id="Rep2MthYrlyCensusFacility" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='70%' cellPadding="0" cellSpacing="0"  align='center' >

				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  >
						
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td align="left" class="label" > <fmt:message key="Common.facility.label" bundle="${common_labels}"/> &nbsp;</td>
					<td colspan ="3"> 
							<select name='p_all_facility_id' id='p_all_facility_id' >
						<%
							String fid="";
							String fname="";
							String sql1="";
							try
							{
								con		=	ConnectionManager.getConnection(request);
							 stmt=con.createStatement();
							 sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";					
							rset=stmt.executeQuery(sql1);
							if(rset!=null)
							{
							   while(rset.next())
							   {
								fid=rset.getString("facility_id");
								fname=rset.getString("facility_name");
								if(fid.equals("All"))
								{
								}
								else
								{
									out.println("<option value='"+fid+ "'  >"+fname+"</option>");
								}
							   }
							}
							if(rset!=null)rset.close();
							if(stmt!=null)stmt.close();
							}catch(Exception e)
							{
								//out.println(e);
								e.printStackTrace();
							}
							finally { 
									ConnectionManager.returnConnection(con,request);
									}


						%>					<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  >
						
					</td>
					<td colspan ='2'>
				</tr>		
				<tr>
					<td align='left' width='30%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%'>
						 <SELECT name="p_type" id="p_type" onchange='mychange()'>
						 <option value="M"><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
						 <option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
					 <td colspan ='3'> 
				</tr>
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;&nbsp;</td>
					<td width='25%'  ></td>
					<td colspan ='3'></td>
					<td colspan ='3'></td>
				</tr>
				<tr>
						<td align='left' id='MY1'class="label"> &nbsp; &nbsp;</td>
						<td align='left' id='MY' > &nbsp; </td><td> </td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='25%'  ></td>
					<td colspan ='3'></td>
					
				</tr>
					
					</td>
					<td colspan ='2'>
				</tr>
		</table>
	</td>
</tr>
</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="">
	<input type="hidden" name="p_resp_id" id="p_resp_id" 		value="<%=p_resp_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">
	<input type="hidden" name="p_date_fmt" id="p_date_fmt"	value="">
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


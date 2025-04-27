<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"   %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

 
<%

	String p_module_id		= "IP" ;
	String p_report_id		= "IPBDLSRL" ;
	String CurrentDate = "";
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String p_resp_id			=	(String) session.getValue("responsibility_id");
	//String locale = (String)session.getAttribute("LOCALE");
	Connection	con		=	ConnectionManager.getConnection(request);
	Statement	stmt			=	null;
	Statement	stmt1			=	null;
	ResultSet	rset			=	null;
	ResultSet	rset1			=	null;
%>

<html>

<HEAD>
<TITLE></TITLE>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";

			if(obj.name=="service")
			{
				tit="Service"
				sql="select service_code, short_desc from am_service ";
				search_code="service_code";
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
<BODY onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<br>
<br>
<form name="RepDailyServiceList" id="RepDailyServiceList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<table width='80%' align='center' valign='top'>
		<th align='left' colspan="3"> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	<tr>

		<td width="100%" class="Border" >
			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
				<tr>
					<td  class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
					<td colspan ="4"  class='fields'> 
							<select name='p_all_facility_id' id='p_all_facility_id' >
						<%
							try
							{
							stmt=con.createStatement();
							String fid;
							String fname;
							String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name,to_char(sysdate,'dd/mm/yyyy') CurrentDate from dual union select u.facility_id facility_id, p.facility_name facility_name,to_char(sysdate,'dd/mm/yyyy')CurrentDate from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";				
							rset=stmt.executeQuery(sql1);
							if(rset!=null)
							{
							   while(rset.next())
							   {
								fid=rset.getString("facility_id");
								fname=rset.getString("facility_name");
								CurrentDate=rset.getString("CurrentDate");
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
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
					<td  width='30%' class="label"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type=text id='p_trn_date'  name='p_trn_date' id='p_trn_date' size="10" maxlength="10"  onBlur="if(validDateObj(this,'DMY',localeName))validate_date(this)"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_trn_date');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>
					<td width='40%' class='fields'>&nbsp;</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
					<td  width="30%">&nbsp;</td>
					<td class="label" width="30%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="label" width="40%" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>

				<tr>
					<td width='30%' class="label"><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>
					<td width='30%'   class='fields'>
						<input type=text  name='p_fm_service_code' id='p_fm_service_code' size="4" maxlength="4" ><input type='button' name='service' id='service' value='?' class='button' onclick='searchCode(this, p_fm_service_code)'>
					</td>
					<td width='40%'  class='fields'> 
						<input type=text  name='p_to_service_code' id='p_to_service_code' size="4" maxlength="4" ><input type='button' name='service' id='service' value='?' class='button' onclick='searchCode(this, p_to_service_code)'>
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

	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
	<input type="hidden" name="p_resp_id" id="p_resp_id"		value="<%= p_resp_id %>">
	<input type="hidden" name="CurrentDate" id="CurrentDate"		value="<%= CurrentDate %>">

</form>
<script>
	document.forms[0].p_all_facility_id.focus()
</script>
</BODY>
</HTML>


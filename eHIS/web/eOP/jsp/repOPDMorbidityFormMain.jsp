<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<html>
<%
	request.setCharacterEncoding("UTF-8");

	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></script>
	<script src="../../eCommon/js/common.js" language="JavaScript"></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script src="../../eOP/js/repOPDMorbidityForm.js"></script>
	<script src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	String p_module_id		= "OP" ;
	String p_report_id		= "OPBMTMOR" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id				= (String)session.getValue("responsibility_id");	
	Connection con = null;
	Statement stmt = null;
	ResultSet rset = null;

%>
<center>

<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<center>
	<form name="repOPDMorbidity" id="repOPDMorbidity" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<BR><!--BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR-->

	<table cellpadding='0' border = '0' cellspacing='0' width='80%'>
<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</table>

<table cellpadding='2' border = '0' cellspacing='0' width='80%'>

		<tr>
				<td width='15%'>&nbsp;</td>
				<td width='20%'>&nbsp;</td>
				<td width='15%'>&nbsp;</td>
				<td width='20%'>&nbsp;</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.facility.label" 	 bundle="${common_labels}"/></td>				

			<td class='fields' colspan='2'><select name='p_facilityid' id='p_facilityid'>
<%
try
{
con = ConnectionManager.getConnection(request);
stmt=con.createStatement();
String fid;
String fname;
StringBuffer sql1 = new StringBuffer("SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  2");					

rset=stmt.executeQuery(sql1.toString());
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
}catch(Exception e){
	out.println(e);
}
finally
		{
			try
			{				
			if(con!=null) ConnectionManager.returnConnection(con,request);
			}
			catch(Exception e) { }
		}
%>
</select>
</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td width='33%'>&nbsp;</td>
<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>
		
			<tr>
			<td class="label" ><fmt:message key="Common.Visit.label" 	 bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.month.label" 	 bundle="${common_labels}"/></td>				

				<td class='fields'>
					<input type="text" id='visitdatefrom'  name="P_fr_visit_date" id="P_fr_visit_date" size="7" maxlength="7" onBlur="if(validDateObj(this,'MY',localeName)){chkWithSysDt(this);}"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('visitdatefrom','mm/y', null);"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				<td class='fields'>
					<input type="text" id='visitdateto' name="P_to_visit_date" id="P_to_visit_date" size="7" maxlength="7" onBlur="if(validDateObj(this,'MY',localeName)){chkWithSysDt(this);}"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('visitdateto','mm/y', null);"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>



			<tr>
				<td align="left" class="label"><fmt:message key="eMR.TabListNo.label" 	 bundle="${mr_labels}"/>
				</td>

				<td class='fields'>
					<input type="text" name="p_tab_list_fr" id="p_tab_list_fr" size="15" maxlength="20" onblur="getTablistData(document.forms[0].tab_list,this)" ><input type='button' name='tab_list' id='tab_list' value='?' class='button' onclick='searchCode(this, p_tab_list_fr)'>&nbsp;
				
				</td>
				<td class='fields'>
					<input type="text" name="p_tab_list_to" id="p_tab_list_to" size="15" maxlength="20" onblur="getTablistData(document.forms[0].tab_list,this)"  ><input type='button' name='tab_list' id='tab_list' value='?' class='button' onclick='searchCode(this, p_tab_list_to)'>&nbsp;
				
				</td>
			</tr>
		
		<!-- <tr>
				<td align="right" class="label" width="40%">
					ICD code From
				</td>

				<td align="left" width="17%">
					&nbsp;&nbsp;<input type="text" name="ICD_code_fm" id="ICD_code_fm" size="15" maxlength="20" ><input type='button' name='ICD_code' id='ICD_code' value='?' class='button' onclick='searchCode(this, ICD_code_fm)'>&nbsp;
				
				</td>
				<td align="left" width="3%" class="label">
					&nbsp;&nbsp;To&nbsp;&nbsp;
				</td>
				<td align="left" width="40%">
					<input type="text" name="ICD_code_to" id="ICD_code_to" size="15" maxlength="20" ><input type='button' name='ICD_code' id='ICD_code' value='?' class='button' onclick='searchCode(this, ICD_code_to)'>&nbsp;
				
				</td>
			</tr>
				<tr>
				 <td colspan=4>&nbsp;</td>
				 </tr> -->
		</table>

		<br>
		<input type="hidden" name="p_dtype" id="p_dtype"			value="M">		
		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
		<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
	</form>

</center>
</body>
</center>
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


<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String p_module_id		= "FM" ;
	String p_report_id		=  "" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<html>
<HEAD>
<TITLE></TITLE>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	request.setCharacterEncoding("UTF-8"); 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eFM/js/WorkLoadStatistics.js" language="javascript"></script>
<script language='javascript' src='../../eFM/js/checkSystemDate.js'></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onMouseDown="CodeArrest();" onLoad="document.forms[0].p_from_dest_id.focus()" onKeyDown = 'lockKey();'>
<br>
<br>
<form name="workLoadStatistics" id="workLoadStatistics" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
 <%
	Connection conn = ConnectionManager.getConnection(request);
	Statement stmt=null;
	ResultSet rset=null;
	String today ="";
	String sql = "select to_char(sysdate,'dd/mm/yyyy')today from dual";
	boolean workloadstatistic = false;
	
 
 try
 {	
	workloadstatistic =  eCommon.Common.CommonBean.isSiteSpecific(conn,"FM","WORKLOAD_STATISTIC");
	stmt = conn.createStatement();
	rset = stmt.executeQuery(sql);
	if (rset.next())
	{
	today = rset.getString("today");
	}
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
 }
 	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}
%>

			<table width='70%' cellPadding="2" cellSpacing="0"  align='center' >

			<tr>
					<td height="3" colspan="2" class='label'>&nbsp;</td>
					<td height="3" colspan="2" class='label'>&nbsp;</td>
			</tr>

			<tr>
					<td  class='label' width='20%'>&nbsp;</td>
					<td  class='querydata' width='20%'><b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b></td>
					<td  class='querydata' width='20%'><b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b></td>
			</tr>			
			
			<tr>
						<td class='label'><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
						<td	class='fields' ><input type='text' name='p_from_dest_id' id='p_from_dest_id' value='' onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);'  size="20"	tabIndex='1' maxlength="30" onBlur=''><input type='button' name='useridFromButton' id='useridFromButton' value='?' class='button' onclick='searchCode(this,p_from_dest_id)'>
						</td>
						<td class='fields'><input type='text' name='p_to_dest_id' id='p_to_dest_id' value='' onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);' size="20"	maxlength="30" tabIndex='2' onBlur=''><input type='button' name='useridToButton' id='useridToButton' value='?' class='button' onclick='searchCode(this,p_to_dest_id)'></td>
			</tr>
		
			<tr>
			<%
			/*below change added by Mano aganist ML-MMOH-CRF-0936*/
			if(workloadstatistic){%>
		            <td  class='label'><fmt:message key="Common.TransactionDate.label" bundle="${common_labels}"/></td>
			<%}else{%>			
			   <td  class='label'><fmt:message key="Common.issueddate.label" bundle="${common_labels}"/></td>
			<%}%>
					<td	class='fields' ><input type='text' id="date_from" tabIndex='3'
						name='p_from_date' id='p_from_date' value=''  size="10"	maxlength="10"
					  	onBlur="if(validDateObj(this,'DMY','<%=localeName%>')){setDate(this)};"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_from');"></td>
						<td class='fields'><input type='text' id="date_to" tabIndex='4'
						name='p_to_date' id='p_to_date' value=''  size="10"	maxlength="10" onBlur="if(validDateObj(this,'DMY','<%=localeName%>')){setDate(this)};"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_to');"></td>	
            			
			</tr>
			<%if(!workloadstatistic){%>
	
			<tr>
						<td  class='label'><fmt:message key="eFM.FSLocationCode.label" bundle="${fm_labels}"/></td>
						<td	class='fields' ><input type='text' 
						name='p_from_locn_id' id='p_from_locn_id' onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);'   value=''  size="10"	tabIndex='5' maxlength="8" onBlur=''><input type='button' name='fsLocationFromButton' id='fsLocationFromButton' value='?' class='button' onclick='searchCode(this,p_from_locn_id)'></td>
						<td class='fields' ><input type='text' 
						name='p_to_locn_id' id='p_to_locn_id' onKeyPress='return CheckForSpecChars(event)' value=''  onBlur='ChangeUpperCase(this);'   tabIndex='6' size="10"	maxlength="8" onBlur=''><input type='button' name='fsLocationToButton' id='fsLocationToButton' value='?' class='button' onclick='searchCode(this,p_to_locn_id)'></td>
			</tr>
			
			<tr>
						<td class='label'><fmt:message key="Common.ReasonCode.label" bundle="${common_labels}"/></td>
						<td	class='fields'><input type='text' name='p_from_narration_code' id='p_from_narration_code' onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);'  value=''  size="8"	 tabIndex='7' maxlength="8" onBlur=''><input type='button' name='narrationFromButton' id='narrationFromButton' value='?' class='button' onclick='searchCode(this,p_from_narration_code)'></td>
						<td class='fields'><input type='text' name='p_to_narration_code' id='p_to_narration_code' onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);'  value=''  size="8"	tabIndex='8' maxlength="8" onBlur=''><input type='button' name='narrationToButton' id='narrationToButton' value='?' class='button' onclick='searchCode(this, p_to_narration_code)'></td>

			</tr>

<!-- 					<tr><td  colspan="4" height="1" class='label'>&nbsp;</td></tr> 
			</table>
			
			
			<table width='95%' cellPadding="0" cellSpacing="0"  align='center' >-->
			<!--below changes added by Mano aganist ML-MMOH-CRF-0936-->
			<tr>
			    <td class='label'><fmt:message key="eFM.ReportOptionBy.label" bundle="${fm_labels}"/></td>
						<td class='fields' colspan='3' ><select name='p_report_option_by' id='p_report_option_by'  tabIndex='9'>
						<option value='U' ><fmt:message key="Common.user.label" bundle="${common_labels}"/></option>
						<option value='L' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></option>
						<option value='N' ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></option>
						<option value='B' ><fmt:message key="eFM.LocationReason.label" bundle="${fm_labels}"/></option>
						</select></td>
			<%} else{%>
			         <td class='label'><fmt:message key="eFM.ReportOptionBy.label" bundle="${fm_labels}"/></td>
					 <td class='fields' colspan='3' ><input type='radio' name='p_report_option' id='p_report_option' value='U' checked ><fmt:message key="Common.user.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type='radio' name='p_report_option' id='p_report_option' value='T' ><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></td>
						
			<%}%>			
			</tr>		

			<tr><td colspan="4" class='label'>&nbsp;</td></tr>
			</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%=p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%=p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=p_user_name %>">
	<input type="hidden" name="today" id="today"				value="<%=today%>">
	<input type="hidden" name="workloadstatistic" id="workloadstatistic"	value="<%=workloadstatistic%>">
	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
</form>
</BODY>
</HTML>


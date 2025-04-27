<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></script>
<script src="../../eCommon/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/messages.js" language="JavaScript"></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<Script src="../../eIP/js/repIntBetAdmandArr.js" language="JavaScript"></Script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>

<%
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBIBAAA" ;   
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id				= (String)session.getValue("responsibility_id");
	//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
	Connection con  =  null;
	String isSpltyNurUnitToEnableYNAppl="";
	try
    {
	con  =  ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);
	}catch(Exception e){out.println(e);e.printStackTrace();}
	 finally
	 {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }
	 //END
%>
<center>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name="repIntBetAdmandArrForm" id="repIntBetAdmandArrForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<BR>
<table width='90%' align='center' valign='top'>
   <th align='left'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	<tr>
		<td width="100%" class="Border" align='center'>
		<table width='80%' cellPadding="0" cellSpacing="0" align='center'  >
	
		<tr>
		<td align="center" width="20%">&nbsp;</td>
		<td class="label" width="40%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class="label" width="40%" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>	
<tr>
<td align='left' width='20%' class="label"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/>&nbsp;</td>
<td width='40%'  >
<input type='text' id="dis_date_from" maxlength='10' size='10' name='P_FR_DATE_TIME' id='P_FR_DATE_TIME'  value="" onBlur='validDateObj(this,"DMY","<%=localeName%>");DateCompare(this,P_TO_DATE_TIME,parent.frames[1],"Discharge Date");'><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.repIntBetAdmandArrForm.dis_date_from.focus();return showCalendar('dis_date_from');" />&nbsp;<img id="" src='../../eCommon/images/mandatory.gif' align='center'></img></tr>

<td width='40%'  >
 <input type='text' id="dis_date_to" value="" maxlength='10' size='10' name='P_TO_DATE_TIME' id='P_TO_DATE_TIME' onBlur='validDateObj(this,"DMY","<%=localeName%>");DateCompare(P_FR_DATE_TIME,this,parent.frames[1],"Discharge Date");'><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.repIntBetAdmandArrForm.dis_date_to.focus();return showCalendar('dis_date_to',null);"/>&nbsp;<img id="" src='../../eCommon/images/mandatory.gif' align='center'></img></td>

    <tr>
		<td>&nbsp;</td>
		<Td>&nbsp;</td>
	</tr><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
			<tr>
				<jsp:include page="CommonNursingUnitLookup.jsp">
				<jsp:param name="nursing_unit_code_Appl" value="P_FR_NURSING_UNIT"/>
				<jsp:param name="nursing_unit_to_code_Appl" value="P_TO_NURSING_UNIT"/>
				</jsp:include>
			
			</tr>
			
		<td>&nbsp;</td>
		<Td>&nbsp;</td>
		<td>&nbsp;</td>
			<tr>
				<jsp:include page="CommonSpecialityLookup.jsp">
				<jsp:param name="speciality_code_Appl" value="P_FR_SPEC_CODE"/>
				<jsp:param name="speciality_to_code_Appl" value="P_TO_SPEC_CODE"/>
				</jsp:include>
				
			</tr>
			
<%}else{%>
<tr>

						<td align='left' width='30%' class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='40%'  >
							<input type=text  name='P_FR_NURSING_UNIT' id='P_FR_NURSING_UNIT' size="6" maxlength="6" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode11(this, P_FR_NURSING_UNIT)'>&nbsp;
						</td>
						<td width='40%'> 
							<input type=text  name='P_TO_NURSING_UNIT' id='P_TO_NURSING_UNIT' size="6" maxlength="6" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode11(this, P_TO_NURSING_UNIT)'>&nbsp;
							
						</td>
				        </tr>
						<tr>
		<td>&nbsp;</td>
		<Td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
				

<tr>
<td width='40%' class="label" align='left' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td  width='20%' align='left'><input type="text" name="P_FR_SPEC_CODE" id="P_FR_SPEC_CODE" size="6" maxlength="6"><input type='button' name='specality' id='specality' value='?' class='button' onclick="searchCode(this, P_FR_SPEC_CODE,'N')"></td>
<td  width='40%' align='left'><input type="text" name="P_TO_SPEC_CODE" id="P_TO_SPEC_CODE" size="6" maxlength="6"><input type='button' name='specality' id='specality' value='?' class='button' onclick="searchCode(this, P_TO_SPEC_CODE,'N')"></td>
</tr>
<%}%>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td width='40%' class="label" align='left' nowrap><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td  width='20%' align='left'><input type="text" name="P_FR_SERV_CODE" id="P_FR_SERV_CODE" size="6" maxlength="6"><input type='button' name='Service' id='Service' value='?' class='button' onclick="searchCode(this,P_FR_SERV_CODE,'N')"></td>
<td  width='40%' align='left'><input type="text" name="P_TO_SERV_CODE" id="P_TO_SERV_CODE" size="6" maxlength="6"><input type='button' name='Service' id='Service' value='?' class='button' onclick="searchCode(this, P_TO_SERV_CODE,'N')"></td>
</tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
</table>
</table>
<%if(localeName.equals("en"))
{%>
<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
<%}
else if(localeName.equals("th"))
{%>
<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
<%}%>

<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>"> 
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
<input type="hidden" name="p_resp_id" id="p_resp_id"		value="<%= p_resp_id %>">
</form>
</center>
</body>
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


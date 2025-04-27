<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPDAOCUR" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>



async function searchgroupCode(obj,target){	

	var retVal = 	new String();
	var locale= "<%=localeName%>"
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit="";
	var argumentArray=new Array(8);
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;		
	if(target.value=="" && window.event.target == target)
		return;
	tit=getLabel('Common.Customer.label','common'+''+'Common.GroupCode.label','common');
	argumentArray[0]="select cust_group_code code, long_desc description from ar_cust_group_lang_vw where '1' like ? and language_id='"+locale+"' and upper(cust_group_code) like upper(nvl(?,cust_group_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";        
	argumentArray[1]=new Array("'1'");
	argumentArray[2]=new Array("1");
	argumentArray[3]=new Array(STRING);
	argumentArray[4]="2,3";
	argumentArray[5]=target.value;
	argumentArray[6]=CODE_DESC_LINK;
	argumentArray[7]=CODE_DESC;    
	var retVal= await CommonLookup(tit,argumentArray);
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
	if(arr[1]==undefined) 
	{
		arr[0]="";	
		arr[1]="";	
	}			 
	if(retVal==null || retVal=="")
		target.value="";
	else
		target.value = arr[0]; 
		//target.value=retVal[0];		
}
</script>

</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="RepDailyoccupancy" id="RepDailyoccupancy" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>
	<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	<tr>
		<td width="100%" class="Border" align='center'>
			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
			
			
				<tr>
					<td class="label" width="30%"><fmt:message key="Common.Customer.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.GroupCode.label" bundle="${common_labels}"/></td>
					<td class='fields' width="50%"><input type=text  name='P_CUSTOMER_GROUP' id='P_CUSTOMER_GROUP' size="4" maxlength="2" align="center" onBlur='searchgroupCode(P_CUSTOMER_GROUP, this)'><input type='button' name='company_group_id' id='company_group_id' value='?' class='button' onclick='searchgroupCode(this, P_CUSTOMER_GROUP)'>
				
					</td>
				</tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr> 		
				
				<tr>
					<td class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td class='fields'>
						<select name="p_order_by" id="p_order_by">
							<option value='1 DESC'><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></option>
							<option value='19'><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></option>
						</select>
					</td>
				</tr>
				<tr>
					<td class='label'>&nbsp;</td>
					<Td class='label'>&nbsp;</td>
				</tr> 
				</table>
				
	</td>
</tr>
</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=p_facility_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%=p_module_id%>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%=p_report_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=p_user_name%>">
	<input TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
	
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


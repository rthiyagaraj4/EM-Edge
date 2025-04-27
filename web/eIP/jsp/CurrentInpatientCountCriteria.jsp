<!DOCTYPE html>
<!--
	Developed by 	:	Chitra 
	Created on 	:	29/06/2001
	Module		:	ip
-->
 <%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,com.ehis.util.*" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");  %>
<%
	request.setCharacterEncoding("UTF-8") ;
	String locale			= (String)session.getAttribute("LOCALE");
	//String sStyle			= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
 	String facilityID		= (String)session.getValue("facility_id");
	String loginUser		= (String)session.getValue("login_user");
	String operstn			= checkForNull(request.getParameter("oper_stn_id"));
	String call_function						= checkForNull(request.getParameter("call_function"));
	String wherecondn						= checkForNull(request.getParameter("wherecondn"));
	
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script src="../../eCommon/js/CommonCalendar.js" language='javascript' ></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
		<!--<Script src="../../eIP/js/IPLookup.js" language="JavaScript"></Script> -->
		<Script src="../../eIP/js/IPPractitionerComponent.js" language="JavaScript"></Script>	
		<Script src="../../eIP/js/IPCountLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		function BeforeGetPractitioner(obj, target, details)
{
	if(details == 'from')
	{
		if(document.forms[0].from_practid_desc.value !="")
			getPractitionerLocal(obj, target, details);
		else
			document.forms[0].from_practid.value =""
	}
	else
	{
		if(document.forms[0].practid_desc.value !="")
			getPractitionerLocal(obj, target, details);
		else
			document.forms[0].practid.value =""
	}

}
function getPractitionerLocal(obj, target, details)
{
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";

	practName_FName=target.name;
	practName_FValue=target.value;
	if(details == 'from')
		practId_FName=document.forms[0].from_practid.name;
	else
		practId_FName=document.forms[0].practid.name;

	var facility_id		= "<%=facilityID%>";
	var locale			= "<%=locale%>";
		getPractitioner(obj, target, facility_id, "","","Q3");

}
function PractLookupRetVal(retVal,objName)
{ 
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		if(objName == "from_practid_desc")
		{
			document.forms[0].from_practid.value=arr[0];
			document.forms[0].from_practid_desc.value=arr[1];			
		}
		else if(objName=='cancel_pract')
		{
			document.forms[0].cancel_pract_id.value=arr[0];
			 document.forms[0].cancel_pract.value=arr[1];

		}	
		else
		{
			document.forms[0].practid.value=arr[0];
			document.forms[0].practid_desc.value=arr[1];			
		}
	}
	else
	{
		if(objName.name == "practid_desc")
		{
			document.forms[0].from_practid.value="";
			document.forms[0].from_practid_desc.value="";			
		}
		else if(objName=='cancel_pract'){
		
			document.forms[0].cancel_pract_id.value="";
			document.forms[0].cancel_pract.value="";
		}
		else
		{
			document.forms[0].practid.value="";
			document.forms[0].practid_desc.value="";			
		}
	}
}
function submitPage(nur)
{
 
var nursing_unit=document.ippatientcount.nursing_unit.value
var specialty=document.ippatientcount.Splcode.value  
var from_date=document.ippatientcount.from_date.value 
var to_date=document.ippatientcount.admn_date_to.value   
var practitioner=document.ippatientcount.practid.value 


parent.frames[2].location.href= "../../eIP/jsp/CurrentInpatientCountResult.jsp?nursing_unit="+nursing_unit+"&specialty="+specialty+"&from_date="+from_date+"&to_date="+to_date+"&practitioner="+practitioner;
}
function  clearAll()
{

parent.frames[2].location.href ='../../eCommon/html/blank.html';
}

		</script>
	</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()' onLoad='FocusFirstElement();'>
<form name='ippatientcount' id='ippatientcount' >
     	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
		 
		 <tr>
			<!-- Modified to COMMON LOOKUP START by Sridhar on 10/02/04-->
			<td nowrap class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			<td CLASS='fields' width='25%'><input type=text name="nursing_unit_desc" id="nursing_unit_desc"  size=15 maxlength='15' onblur="BeforeGetNursingUnit(this, '<%=facilityID%>','to');"><input type=hidden  name="nursing_unit" id="nursing_unit" size=15 ><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup' value='?' onClick="getNursingUnitValue(nursing_unit_desc, '<%=facilityID%>','to');" > </td>

		
			<input type="hidden" name="nurs_desc_hid" id="nurs_desc_hid" value=''>			

			<td nowrap class="label"><fmt:message key="eIP.AdmDateFrom.label" bundle="${common_labels}"/></td>
			<td  class='fields' width='25%' nowrap ><input type='text' id="admn_date_from" maxlength='10' size='10' name='from_date' id='from_date'  value="" onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].admn_date_from.focus();return showCalendar('admn_date_from');"> - <fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text' id="admn_date_to" value="" maxlength='10' size='10' name='to_date' id='to_date' onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].admn_date_to.focus();return showCalendar('admn_date_to');" ></td>
				
		</tr>
			
		<tr>
		    <td class='label'><fmt:message key="Common.speciality.label" bundle="${ip_labels}"/></td>
		  <td class='fields' width='25%'><input type="text" name="specialty_desc" id="specialty_desc" size=15 maxlength='15' onblur="BeforeGetSpecialtyValue(this, '<%=facilityID%>','to');"><input type="hidden" class="label" name="Splcode" id="Splcode" size=15 readonly><input type="button" class="button" name='from_specialty_lookup' id='from_specialty_lookup' value='?' onClick="getSpecialtyValue(specialty_desc, '<%=facilityID%>','to');"></td>
	<td  class='label' width='25%' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
<td class='fields' width='25%'  nowrap><input type='text' name='practid_desc' id='practid_desc' size="25" maxlength="30" onblur="BeforeGetPractitioner(document.forms[0].practid,practid_desc,'to');" value=""><input type='hidden' name='practid' id='practid' value="" size="15" maxlength="15" ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerLocal(document.forms[0].practid, practid_desc,'to');"></td>
		</tr>
		
		<%
			//String search = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels");
			//String clear  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels");
		%> 
		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
		<tr>
			<td width = "75%" class='white' >&nbsp;</td>
			<td width = "25%" class='white' align="right"><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAll()'>
		</tr> </table>

		
       </table>  
	   <input type='hidden' name='loginUser' id='loginUser' value="<%=loginUser%>" >
	   <input type='hidden' name='operstn' id='operstn' value="<%=operstn%>" >
	   	<input type='hidden' name='wherecondn' id='wherecondn' value="<%=wherecondn%>" >
			<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >	
				<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
</form>
 </body>
</html>
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


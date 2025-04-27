<!DOCTYPE html>
<!--
	MODULE	   : Inpatient Management...(IP) 
	Function   : Practioner for Nursing Unit
	Created On : 20th Aug 2002
	Created By : Prakash.S
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%	

	request.setCharacterEncoding("UTF-8");
	Connection con	=	null;
	Statement stmt	=	null;
	ResultSet rs	=	null;
	String operation=request.getParameter("operation");

	String query=request.getParameter("query");
		if(query==null)query="";

	
	String flag = request.getParameter("flag");
		if(flag == null) flag="";

	String Function		= request.getParameter("Function");
	String facility_id	=(String)session.getValue("facility_id");
    String locale			= (String)session.getAttribute("LOCALE");
	try
	{
		con=ConnectionManager.getConnection(request);
	%>
	<%
	request.setCharacterEncoding("UTF-8");
	//String url    = "../../eCommon/jsp/MstCodeToolbar.jsp?"; 
	//String params = request.getQueryString() ;
	//String source = url + params ;
	String function_id = request.getParameter("function_id");
%>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../js/NursUnitPract.js'></script>
	<script language='javascript' src='../js/IPPractitionerComponent.js'></script>
	<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function CheckForSpecChars_local(event)
{
	var strCheck = document.forms[0].strCheck.value;
    //var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function clear_result()
{
	
	parent.frames[2].location.href="../../eCommon/html/blank.html";
}

function enable_txt(obj)
{
	
	document.forms[0].search_txt.value = "";
 if(obj.value=="00")
 {
	document.forms[0].search_txt.value = "";
	document.forms[0].search_txt.disabled = true;
 }
 else
 {
	document.forms[0].search_txt.disabled = false;
		if(obj.value=="01")
			document.forms[0].strCheck.value = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*";
		else
			if(obj.value=="02")
				document.forms[0].strCheck.value = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ";
 }

// '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* '
}

function PopulateResult()
{
		
	
	var function_code=document.forms[0].function_code.value;
	var Function =document.forms[0].Function.value;
	var query =document.forms[0].query.value;
	var operation='<%=operation%>';
	if(function_code != "")
	{
		if(query=="IPOnlineReport")
		{	
			parent.frames[2].location.href ='../../eIP/jsp/IPOnlineReportResult.jsp?function_id=IP_ONLINE_REPORT&function_code='+function_code+'&operation='+operation+'&Function='+'<%=Function%>&fromSelect=fromSelect';
		}
		else
		{	
			var search_by = "";
			var search_txt = "";
			
			if(document.forms[0].search_txt!=null)
			{
			  search_by = document.forms[0].search_by.value;
			  search_txt = document.forms[0].search_txt.value;
			

			}
		    parent.frames[2].location.href='../../eIP/jsp/PractForNursUnitResult.jsp?function_id=<%=function_id%>&function_code='+function_code+'&operation='+operation+'&search_by='+search_by+'&search_txt='+search_txt+'&Function='+'<%=Function%>&fromSelect=fromSelect';
			parent.frames[3].location.href="PractforNursUnitDynamicValues.jsp"
			
		} 
	}
	else
	{
		var msg_id="";
		if(Function=="nurs")
		{
			msg_id=getLabel('Common.nursingUnit.label','common');
		}
		else if(Function=="pract") 
		{
			msg_id=getLabel('Common.practitioner.label','common');
		}

		var msg=getMessage("CAN_NOT_BE_BLANK","common");
		msg= msg.replace('$',msg_id);
		
		if(msg != "")
		{
			if(query=="IPOnlineReport")
			parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
			else
			parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
			return false;
		}
	}
}

// Modified to COMMON LOOKUP on 6 FEB 2004 by Sridhar 
async function Lookup(target_id,target)
{
		
	var facility_id = "<%=facility_id%>";
	var title="";
	var argumentArray=new Array(8);

	if(target_id.name == "function_code")
	{
		title=getLabel('Common.nursingUnit.label','common');

		argumentArray[0]="select NURSING_UNIT_CODE code, SHORT_DESC description from IP_NURSING_UNIT where locn_type = 'N' and FACILITY_ID ='"+facility_id+"' and EFF_STATUS = 'E' and upper(NURSING_UNIT_CODE) like upper(nvl(?,NURSING_UNIT_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC))";
							
		argumentArray[1]=new Array();
		argumentArray[2]=new Array();
		argumentArray[3]=new Array();
		argumentArray[4]="1,2";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
	}			

	var retVal= await CommonLookup(title,argumentArray);
	if(retVal ==null || retVal=="" || !retVal)
	{	
		target.value="";
		target_id.value="";
	}
	else
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target_id.value	=	arr[0];		
		target.value	=	arr[1];
		/* 
		target_id.value=retVal[0];
		target.value=retVal[1]; */
		
		document.forms[0].nurs_desc_hid.value = document.forms[0].function_code_desc.value
		PopulateValues(target_id);
	}
} 

</script>
</head>

<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name='Search_form' id='Search_form'>
  <table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>
	<tr>
		<td class='label' width="27%" ></td>
		<td class='label' colspan='3'></td>
	</tr>

	<tr>
	<% if(Function.equals("nurs"))	{	%>
		
		<td  class='label'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		<td align='left' class='fields' id=td5>
		<input type="text" name = "function_code_desc" size=15 maxlength=15 onblur="beforeGetNursingUnit(function_code,function_code_desc)" >
		<input type="button" class=button name='search_nurs_unit' id='search_nurs_unit' value='?' onclick="checkTxtVal(function_code,function_code_desc)"> 
		<img align='center' src='../../eCommon/images/mandatory.gif'></img></td>

		<input type=hidden name="nurs_desc_hid" id="nurs_desc_hid" value=''>
		<input type="hidden" name="function_code" id="function_code" size=4 maxlength=4 >

		<%} else if(Function.equals("pract")) {%>

		<td  class='label' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td align='left' class='fields' id=td5><input type="text" name="practitioner_name" id="practitioner_name" value="" size=15 maxlength=15 onBlur='beforeGetPractitioner(Pract_but,this,"<%=facility_id%>");'><input type="button" name="Pract_but" id="Pract_but" value="?" class="button" onClick='checkPractTxtVal(this,practitioner_name,"<%=facility_id%>")';><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
		<input type="hidden" name="pract_desc_hid" id="pract_desc_hid" value="">
		<input type="hidden" name="function_code" id="function_code" value="" size=4 maxlength=4>
<%}%>

	<td class='label' align=center>&nbsp;</td>
</tr>
</table>
	<table border='0' cellpadding='0' cellspacing='0' width='90%' align='center' id=tab style='visibility:hidden'>
	<%if(Function.equals("nurs")){%>
	<tr><td colspan='4' class='DEFAULTBLANKROW2PT'>&nbsp;</td></tr>
	<tr>
		<td class=label  id = lab1 width='27%' ><fmt:message key="eIP.NursingUnitType.label" bundle="${ip_labels}"/></td>
		<td  class='querydata' id = td1  width='23%'></td>
		<td class=label  id = lab2  width='27%' ><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
		<td  class='querydata' id = td2  width='23%'></td>
	</tr>
	<tr><td colspan='4' class='DEFAULTBLANKROW2PT'>&nbsp;</td></tr>
	<tr>
		<td class='label'  id=lab3  width='27%'><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/></td>
		<td class='querydata' id=td3 width='23%'></td>
		<td class='label'  id=lab4   width='27%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td class='querydata' id=td4 width='23%' ></td>
	</tr>

<!-- ragha -->
	<%if(!query.equals("IPOnlineReport")){%>

    <tr><td colspan='4' class='DEFAULTBLANKROW2PT'>&nbsp;</td></tr>
	<tr>
		<td class=label  id = lab1 width='27%' ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
		<td align=left colspan=3 class='fields' >
		<SELECT name="search_by" id="search_by" onchange="enable_txt(this)">
		<option value="00">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		<option value="01"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></option>
		<option value="02"><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></option>
		</SELECT>&nbsp;&nbsp;<INPUT TYPE="text" name="search_txt" id="search_txt" onKeyPress='return CheckForSpecChars_local(event)' disabled size=15 maxlength=15></td>
	</tr>

	<%}else{%>
		<tr><td colspan='4' class='DEFAULTBLANKROW2PT'>&nbsp;</td></tr>	
	<%}}else if(Function.equals("pract")){%>

	<tr><td colspan='4' class='DEFAULTBLANKROW2PT'>&nbsp;</td></tr>
	<tr>
		<td class=label  id=lab1  width='27%'><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td  class=label id=td1 width='23%'></td>
		<td class=label   id=lab2 width='27%'><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td  class=label id=td2  width='23%'></td>
	</tr>

	<!-- ragha -->
    <tr><td colspan='4' class='DEFAULTBLANKROW2PT'>&nbsp;</td></tr>
	<tr>
		<td class='label'  id = lab1 width='27%' ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
		<td align=left colspan=3 class='fields'>
		<SELECT name="search_by" id="search_by" onchange="enable_txt(this)">
		<option value="00">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		<option value="01"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/></option>
		<option value="02"><fmt:message key="eIP.NursingUnitDescription.label" bundle="${ip_labels}"/></option>
		</SELECT>&nbsp;&nbsp;<INPUT TYPE="text" name="search_txt" id="search_txt" onKeyPress='return CheckForSpecChars_local(event)' disabled size=15 maxlength=15></td>
	</tr>
	<%}%>
	<tr>
		<td class='label' colspan=3>&nbsp;</td>
		<td  class='fields' ><input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' name='search_button' onclick='PopulateResult()'>&nbsp;<input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' name='clear_button' onclick='clear_result()'></td>
	</tr>
<!--<tr><td colspan='4' class='DEFAULTBLANKROW2PT'>&nbsp;</td></tr>--> 
	</table>

	<input type=hidden name=operation id=operation value='<%=operation%>'>
	<input type=hidden name=facility_id id=facility_id value='<%=facility_id%>'>
	<input type=hidden name=Function id=Function value='<%=Function%>'>
	<input type=hidden name="function_name" id="function_name" value='<%=Function%>'>
	<input type=hidden name=query id=query value='<%=query%>'>
	<input type=hidden name=SelectYNStr id=SelectYNStr value="">
	<input type=hidden name=SelectYNStrBkg id=SelectYNStrBkg value="">
	<input type=hidden name=SelectYNStrReq id=SelectYNStrReq value="">
	<input type=hidden name=SelectYNStrConf id=SelectYNStrConf value="">
	<input type=hidden name=SelectYNStrBed id=SelectYNStrBed value="">
	<input type=hidden name=SelectYNStrWoBed id=SelectYNStrWoBed value="">
	<input type=hidden name=SelectYNStrDischarge id=SelectYNStrDischarge value="">
	<input type=hidden name=SelectYNStrTransReqest id=SelectYNStrTransReqest value="">
	<input type=hidden name=SelectYNStrPrint_on_discharge id=SelectYNStrPrint_on_discharge value=""> 
	<input type=hidden name=SelectYNStrCode id=SelectYNStrCode value="">
	<input type=hidden name=DeleteYNStr id=DeleteYNStr value="">
	<input type=hidden name=strCheck id=strCheck value="">
	<input type=hidden name=locale id=locale value='<%=locale%>'>
	
	</form>
<%
}
catch ( Exception e ){out.println(e.toString());}
finally{
		if ( stmt != null ) stmt.close() ;
		if ( rs != null ) rs.close() ;
		ConnectionManager.returnConnection(con,request);
	}
%>
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


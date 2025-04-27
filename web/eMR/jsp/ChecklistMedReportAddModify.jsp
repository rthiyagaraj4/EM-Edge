<!DOCTYPE html>
<!--Created by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.Statement,java.sql.PreparedStatement,org.json.simple.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
 
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../../eCommon/js/common.js' language='javascript'></script>
	<Script src='../../eMR/js/MRMaster.js' Language='JavaScript'></script>

<script>
function CheckForSpecChars(event){ 
 
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'; 
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

</script>



</head>

<body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>

<%	
   String facilityId = (String)session.getValue("facility_id");
   request.setCharacterEncoding("UTF-8"); 
   // requestor_type_code = CHK_LIST_CODE chk_list_code
   String chk_list_code="";
   String longdesc="";
   String shortdesc="";
   String effstatus="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   boolean status = false;
 

   Connection con=null;
%>
<%
try
{
	con=ConnectionManager.getConnection(request);
	
	chk_list_code=request.getParameter("chk_list_code");
	if(chk_list_code==null)
	{
		chk_list_code="";
		longdesc="";
		shortdesc="";
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		status=true;
		
	}else
	{
		JSONObject json	= eMR.MRCommonBean.getCheckListDetails(con, chk_list_code);
		chk_list_code  = (String) json.get("chk_list_code");
		longdesc  = (String) json.get("long_desc");
		shortdesc  = (String) json.get("short_desc");
		effstatus  = (String) json.get("eff_status");

			if(effstatus.equals("D")){
				otherTextAttribute="READONLY";
				checkBoxAttribute="";
			}else{
				otherTextAttribute="";
				checkBoxAttribute="CHECKED";
			}
		
		
		
		codeTextAttribute="READONLY";
		status=false;
		eventFunctionForCase="";
	}

%>

      	<form name='checkListForm' id='checkListForm' action='../../servlet/eMR.CheckListServlet' method='post' target='messageFrame'>
      	<div align='left'>
      	<BR><BR><BR><BR><BR><BR><BR><BR><BR><br>
      	<table border='0' cellpadding='5' cellspacing='0' width='auto' align='center'>
      	
      		<tr>
      		    <td  width='50%' class='label'><fmt:message key="eMR.CheckLists.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td width='50%' class='fields'>
      		    <input type='text' name='chk_list_code' id='chk_list_code' value="<%=chk_list_code%>" size='10' maxlength='10'  onkeypress="return CheckForSpecChars(event);" <%=codeTextAttribute%> >
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
			<!--Modify the Size and Maxlength for Long desc and short desc for ML-MMOH-SCF-1819-->
      		<tr>
      		    <td  class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>
      		    <input type='text' name='long_desc' id='long_desc' size='75' maxlength='100' value="<%=longdesc%>" <%=otherTextAttribute%>  onBlur="makeValidString(this);">
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
     		    <td  class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		    <td class='fields'>
		    <input type='text' name='short_desc' id='short_desc' size='50' maxlength='50' value="<%=shortdesc%>" <%=otherTextAttribute%>  onBlur="makeValidString(this);">
		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
			
      		<tr>
      		     <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class='fields'>
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="changeCheckList()"></td>
      		</tr>
			
      	</table>
      	</div>
    <%  if(status){%>

      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>
		
     	</form>
      	</body>
      	</html>

<%
}
catch(Exception e){
	//out.println("Exception @ RequestorTypeAddModify.jsp"+e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
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


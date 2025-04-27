<!DOCTYPE html>
<%@page import="eOT.*,eOT.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src="../../eOT/js/SwabCount.js" ></SCRIPT> 
	<script language="JavaScript" src="../../eOT/js/ExamsCheckList.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function windowClosing()
	{
		var txtremarks=document.forms[0].new_remarks.value;
		var size=document.forms[0].remarks_size.value;
		if(txtremarks.length > size)
		{
			var max_len = getMessage("MAX_LENGTH_DATA","OT");
			var max_len_msg_arr = max_len.split("#");
			var errors = max_len_msg_arr[0]+getLabel("Common.operation.label","Common")+max_len_msg_arr[1]+size+max_len_msg_arr[2];
			alert(errors)
			window.returnValue=txtremarks.substring(0,size-1);
		}
		else
		{
			window.returnValue=txtremarks;
			window.close();
		}
//	window.close();
}
/*
	function CheckForOHSpecChars(event)
	{
	var strCheck = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
 }
*/

	  function restrictSpecialChars(event)
	  {
			var strCheck = '~!@#$%^&*()+=`{}|[];:,_-/\\?<>"\'';
			var whichCode = (window.Event) ? event.which : event.keyCode;
			key = String.fromCharCode(whichCode);  
			if (strCheck.indexOf(key) != -1) 
			{
				window.event.keyCode = 27;
				return false;  
			}
			return true ;
	}

	
	</script>
<title><%=request.getParameter("remarks_title")%></title>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="ExamsCheckListRemarksForm" id="ExamsCheckListRemarksForm" >
<%
try{
	String rownum		= request.getParameter("rownum");
	String remarks_title		= request.getParameter("remarks_title");
	String old_remarks	= (String) session.getValue("old_remarks");
	String new_remarks	= request.getParameter("new_remarks");
	old_remarks=old_remarks==null?"":old_remarks;
	old_remarks=old_remarks.equalsIgnoreCase("null")?"":old_remarks;
	new_remarks=new_remarks==null?"":new_remarks;
	new_remarks=new_remarks.equalsIgnoreCase("null")?"":new_remarks;
	new_remarks=new_remarks.equalsIgnoreCase(" ")?"":new_remarks;
	String disabled = "";
	String readOnly = "";
	String checklist_completed_yn = request.getParameter("checklist_completed_yn");
	if(checklist_completed_yn.equals("Y")){
		disabled="disabled";
		readOnly = "readOnly";
	}
	String size	= request.getParameter("size");
	String swab_count_remarks	= request.getParameter("swab_count_remarks");
	swab_count_remarks=swab_count_remarks==null?"":swab_count_remarks;
	swab_count_remarks=swab_count_remarks.equalsIgnoreCase("null")?"":swab_count_remarks;
%>
<table cellpadding="3" cellspacing="0" width="100%" align="center" border="0">
<%
	if(swab_count_remarks.equals("NO_OLD_REMARKS")){
%>
	<tr>
		<td align="center">
			<input type="hidden" name="old_remarks" id="old_remarks" value="" >
		</td>
<%
	}else{
%>
	<tr>
		<td class="CAGROUPHEADING" colspan="5" align="left" ><fmt:message key="eOT.PreviousRemarks.Label" bundle="${ot_labels}"/></td>
	</tr>
	<tr>
		<td align="center">
			<textarea rows="10" cols="60" name="old_remarks" readOnly ><%=old_remarks%>
			</textarea>
		</td>
<%
	}
%>
	</tr>
	<tr>
		<td class="CAGROUPHEADING" colspan="5" align="left" ><fmt:message key="Common.EnterRemarks.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td class="fields">
			<textarea align="left" rows="10" cols="60" name="new_remarks" <%=readOnly%> onkeypress="restrictSpecialChars(event)"><%=new_remarks%></textarea>
		</td>
	</tr>

	<tr>
		<td class="button" colspan="4">
			 <input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button"  onClick="windowClosing();" <%=disabled%>>
			 <input  type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="button"  onClick="window.close();"> 
			
		</td>
				<input type='hidden' name='remarks_size' id='remarks_size' value="<%=size%>" >

	</tr>
</table>
</form>
</body>
</html>
<%
	}catch(Exception e){
		System.err.println("62: Caught Exception in Exams CheckList Remarks"+e);
	}finally{
	}
%>


<!DOCTYPE html>
<%
//"java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*"
%>
<%@page   import="eOT.*, eOT.Common.*, eCommon.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOT/js/VerifyCheckList.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
	<script>

function SpecialCharRestriction(event){
	var strCheck = "\"`'";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) != -1) return false;  // Not a valid key
	return true ;
}

	function windowClosing(){
		var txtremarks=document.forms[0].checklist_remarks.value;
		var size=document.forms[0].remarks_size.value;
		if(txtremarks.length > size){
			var max_len = getMessage("MAX_LENGTH_DATA","OT");
			var max_len_msg_arr = max_len.split("#");
			//APP-OT0025 # Remarks should not be more than # character
			var errors = max_len_msg_arr[0]+getLabel("Common.operation.label","Common")+max_len_msg_arr[1]+size+max_len_msg_arr[2];
			alert(errors)
			//window.returnValue=txtremarks.substring(0,size-1);
			let dialogBody = parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue = txtremarks.substring(0,size-1);
			//window.returnValue=encodeURIComponent(txtremarks.substring(0,size-1));
			//window.returnValue=txtremarks		
		}else{
			//window.returnValue=txtremarks;
			let dialogBody = parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue = txtremarks;
			//window.returnValue=encodeURIComponent(txtremarks);
			//window.close();
			const dialogTag = parent.document.getElementById('dialog_tag');    
			dialogTag.close();
		}
		//window.close();
		const dialogTag = parent.document.getElementById('dialog_tag');    
		dialogTag.close();
}
	function CheckForOHSpecChars(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
 }
</script> 
<style>
textarea {
  resize: none;
}
</style>
<title><%=request.getParameter("remarks_title")%></title>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="VerifyCheckListRemarksForm" id="VerifyCheckListRemarksForm" >
<%

	String row_num				= request.getParameter("row_num");

//	String previous_remarks		=  request.getParameter("previous_remarks");
//	String checklist_remarks	=  request.getParameter("checklist_remarks");


//modified by DhanasekarV against issue IN025412 on 8/12/2010
	String previous_remarks		=  ""+session.getValue("previous_remarks");
	String checklist_remarks	=  ""+session.getValue("checklist_remarks");
//end
	checklist_remarks=java.net.URLDecoder.decode(checklist_remarks,"UTF-8");
	previous_remarks =java.net.URLDecoder.decode(previous_remarks,"UTF-8");

	/*checklist_remarks=checklist_remarks==null?"":checklist_remarks;
	checklist_remarks=checklist_remarks.equalsIgnoreCase("null")?"":checklist_remarks;
	checklist_remarks=checklist_remarks.equalsIgnoreCase(" ")?"":checklist_remarks;*/

	if(previous_remarks.equals("null"))
		previous_remarks ="";
	if(checklist_remarks.equals("null"))
		checklist_remarks ="";	
	String disable_all	=  request.getParameter("disable_all");
	String size	=  request.getParameter("size");
	String readOnly = "";
	// Added for stage and no_of_verification access correction
	String checklist_stage		= request.getParameter("checklist_stage");
	String no_of_verifications		= request.getParameter("no_of_verifications");
	int no_of_verifications_int = Integer.parseInt(no_of_verifications);
	if( (checklist_stage.equals("C20") || checklist_stage.equals("C60")) &&  no_of_verifications_int<2){
		disable_all = "disabled";
	}else if( (checklist_stage.equals("C30") || checklist_stage.equals("C70")) && no_of_verifications_int<3){
		disable_all = "disabled";
	}else if( (checklist_stage.equals("C40") || checklist_stage.equals("C80")) && no_of_verifications_int<4){
		disable_all = "disabled";
	}
	// Added till here for stage and no_of_verification access correction
	if(disable_all.equals("disabled")) // disable_all parameter is coming from checkin function
		readOnly="readOnly";

%>
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="0">
	
	<tr>
		<td class="label"><B><fmt:message key="eOT.PreviousRemarks.Label" bundle="${ot_labels}"/></B></td>
		<td class="fields">
		<textarea rows="10" cols="60" name="previous_remarks"  id="previous_remarks" readOnly><%=previous_remarks%></textarea>
		</td>
	</tr>
	<tr>
		<td class="label"><B><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></B></td>
<!-- 	<td><textarea rows="10" cols="60" name="checklist_remarks" <%=readOnly%> > <%=checklist_remarks%></textarea>
 -->		
		<td class="fields">
		<textarea rows="10" cols="60" name="checklist_remarks"  id="checklist_remarks" onkeypress="return SpecialCharRestriction(event);" <%=readOnly%>><%=checklist_remarks%></textarea>
		</td>
	</tr>
	<tr align="center">
		<td width='25%'></td>
		<td width='25%'>
			<%

				if(disable_all.equals("disabled")){
			%>
					<input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" disabled>
			<%
				}else{
			%>
				<!-- <input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" 	onClick="storeCheckListRemarks('<%=row_num%>')"> -->
				<input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" 	onClick="windowClosing(); " >
			<%
				}
			%>
				<!-- <input  type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="button"  onClick="window.returnValue='';window.close();"> -->
				<input  type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="button"  onClick="const dialogTag = parent.document.getElementById('dialog_tag');dialogTag.close();">

		</td>
						<input type='hidden' name='remarks_size' id='remarks_size' value="<%=size%>" >

	</tr>
</table>
</form>
</body>
</html>


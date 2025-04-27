<!DOCTYPE html>

<%@page   import="eOT.*, eOT.Common.*, eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><%=java.net.URLDecoder.decode(request.getParameter("remarks_title"),"UTF-8")%></title>
</head>
<script>
function passvalue()
{
	var txtremarks=document.forms[0].new_remarks.value;
	var flag="";
    var size=document.forms[0].remarks_size.value;
	if(txtremarks.length > size){
			var max_len = getMessage("MAX_LENGTH_DATA","OT");
			var max_len_msg_arr = max_len.split("#");
			var errors = max_len_msg_arr[0]+getLabel("Common.operation.label","Common")+max_len_msg_arr[1]+size+max_len_msg_arr[2];
			alert(errors)
		    window.returnValue=txtremarks.substring(0,size-1);
		}else
	{
	window.returnValue=txtremarks;
	}

	window.close();
	
}
function checkForSpecCharsforID(event)
{   
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-.,=+ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); 
	if(event.keyCode<200)
	{
    if (strCheck.indexOf(key) == -1 && event.keyCode!=13) return false;
	}// Not a valid key
	return true ;
}
function CheckChars2(Obj){
        var str = Obj.value;
        var specCharsExist = false;
        for (u=0;u<str.length;u++){
            if (((str.charCodeAt(u)>=42) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)|| (str.charCodeAt(u)==32)|| (str.charCodeAt(u)==61) || (str.charCodeAt(u)==13) || (str.charCodeAt(u)==10) ||(str.charCodeAt(u)>200));
            else{
                specCharsExist = true;
                break;
            }
        }
        return specCharsExist;
    }
	function CheckChars1(obj)
	{  
		var specCharsExist=CheckChars2(obj);
	   if(specCharsExist==true) 
		{
		 alert(getMessage("APP-OT0162","OT"));
		  obj.focus();
	      return;
		}
	}

</script>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="InstrumentCountRemarksForm" id="InstrumentCountRemarksForm" >
<%
	String new_remarks	=  request.getParameter("new_remarks");
	String disable_yn	=  request.getParameter("disable_yn");
	String size="500";
	String readOnly = "";
	new_remarks=new_remarks==null?"":new_remarks;
	new_remarks=new_remarks.equals("null")?"":new_remarks;
	new_remarks = java.net.URLDecoder.decode(new_remarks,"UTF-8");
	if(new_remarks.equals("undefined") ){
			new_remarks = "";
		}
		
	if(disable_yn.equals("disabled"))
		readOnly="readOnly";
%>
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<td class="CAGROUPHEADING" colspan="4" nowrap>
		<fmt:message key="Common.EnterRemarks.label" bundle="${common_labels}"/>
		</td>
	</tr>
	<tr>
		<td class="label" width="25%" >
		<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class="fields" width="25%" colspan="3">
		<textarea rows="10" cols="60" name="new_remarks" <%=readOnly%> onkeypress="return checkForSpecCharsforID(event);" Onblur="return CheckChars1(this);"><%=new_remarks%></textarea>
		</td>
	</tr>
	<tr>
		<td class="fields" width="25%" colspan="4">
			<%
				if(disable_yn.equals("disabled")){
			%>
				
			
			<input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'	
			
			class="button" disabled>
			<%
				}else{
			%>
				<input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" onClick="passvalue();">
			<%
				}
			%>
				<input  type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'
				class="button"  onClick="window.returnValue='CL_REM';window.close();">

		</td>
	</tr>
			<input type='hidden' name='remarks_size' id='remarks_size' value="<%=size%>" >

</table>
</form>
</body>
</html>


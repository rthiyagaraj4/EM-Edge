<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	


<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<title><fmt:message key="Common.invitationlist.label" bundle="${common_labels}"/> </title>
<head>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
   
	
	<script>	
	function getBarcodeValue(evnt,inviteNo)
	{
	if(evnt.keyCode==13)
	{
		returnVal('O',inviteNo);
	}
	}
	
	
	function returnVal(val,val1)
	{
		if(val == "O")
		{
			
			var invite_no=document.forms[0].invite_no.value;
			
			if(invite_no == val1)
			{
				//parent.window.returnValue=document.forms[0].invite_no.value;
				let dialogBody = parent.parent.document.getElementById('dialog-body');
				dialogBody.contentWindow.returnValue = document.forms[0].invite_no.value;
				const dialogTag = parent.parent.document.getElementById('dialog_tag');    
				dialogTag.close();
				//window.close();
			}else
			{
				var error = getMessage("INVALID_VALUE",'COMMON');
				error = error.replace("#",getLabel('Common.invitationno.label','Common'));			
				alert(error);				
				document.forms[0].invite_no.focus();
				return false;
			}
		}
		else
		{
			//parent.window.returnValue="C";
			//window.close();
			let dialogBody = parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue = "C";
			const dialogTag = parent.document.getElementById('dialog_tag');    
            dialogTag.close();
		}
	}

	</script>


</head>
<%

  String invitation_no=request.getParameter("invite_no");
  if(invitation_no == null) invitation_no="";

%>

<body OnMouseDown='CodeArrest()' onload='FocusFirstElement();' onKeyDown = 'lockKey();' >
<center>

	<h3>&nbsp;</h3>

<form name='visittype_form' id='visittype_form' method='post' target='messageFrame'>
      
		<table align='center' width='90%' cellpadding='0' cellspacing='0'>
		<tr><td colspan='2'>&nbsp;</td></tr>
		<tr>
		<td align='right' width='25%' class='label' nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.invitationno.label" bundle="${common_labels}"/> </td>
		<td align='left' width='75%'>
		&nbsp;&nbsp;<input type='text' name='invite_no' id='invite_no' value='' size='15' maxlength='15' onKeyPress="getBarcodeValue(event,'<%=invitation_no%>');return CheckForSpecChars(event);">
		</td>
		</tr>

		<tr><td colspan='2'>&nbsp;</td></tr>
</table>
<br>
	<input type='button' name ='ok' class='BUTTON' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="returnVal('O','<%=invitation_no%>');"  class=button >&nbsp;&nbsp;&nbsp;&nbsp;
	<input type='button' class='BUTTON' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="returnVal('C');" >

</form>
</center>
</body>
</html>


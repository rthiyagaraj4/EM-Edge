<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<head>
<title>
	<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
</title>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eSM/js/FacilityforResponsibility.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>

<script>
	
	function closeWindow(val)
	{
		//parent.window.returnValue=document.getElementById('remarks').value;
		var retValue = document.getElementById('remarks').value;
         if(val == 'OK' )
		 {
			 //parent.window.returnValue=document.getElementById("remarks").value;
			retValue= document.getElementById('remarks').value;   
			
		 }
	   else
		{
			//parent.window.returnValue="";
			retValue = "";   
		}		
		    

		//parent.window.close();
			let dialogBody = parent.document.getElementById('dialog-body');
            dialogBody.contentWindow.returnValue = retValue;
			const dialogTag = parent.document.getElementById("dialog_tag"); 
			dialogTag.close();
	
	}
	function populateRemarks()
	{
		var text=parent.document.getElementById('dialog-body').contentWindow.dialogArguments;
		if(text == null || text =='null') text='';
		document.forms[0].remarks.value=text;
	}
	function chkMaxLength(Obj)
	{
		if(Obj.value.length >200)
			{
			alert(getMessage('REMARKS_NOT_EXCEED_200_CH','SM'));
			Obj.focus();
			}
	}
</script>
<body onLoad='populateRemarks()'  onKeyDown = 'lockKey()';>
	<form>
	<table border='0' cellpadding='0' cellspacing='0' align='center'  width='90%'>
	<tr><td>&nbsp;</td></tr>
	<tr>
		<td>
			<textarea  name='remarks' id='remarks' cols='50'  onBlur="makeValidString(this);chkMaxLength(this)"  onkeypress='checkMaxLimit(this, 200)' rows='4'></textarea>
		</td>
	</tr>
	<tr>
		<td align='center'>
			<input type='button' class='button' value=' <fmt:message key="Common.ok.label" bundle="${common_labels}"/> ' onClick='closeWindow("OK")' >
		</td>
	</tr>
	</table>
	</form>
</body>
</html>



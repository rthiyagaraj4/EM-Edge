<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String patient_id=request.getParameter("Patient_Id");
String FacilityID=(String)session.getValue("facility_id");
String old_fileno=request.getParameter("old_fileno");
String fileno=request.getParameter("file_no");
%>

<html>
<head><title><fmt:message key="Common.OldFileNo.label" bundle="${common_labels}"/> &nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<%=patient_id %></title>
<head>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	
	function allowAlphaNumeric(event){
		var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) == -1) return false;  
		return true ;
	}
 //added by N Munisekhar against  [IN:045249] 
     	function removeSpec()
	     {  
                var data = document.getElementById("txt1").value;
                for (var i = 0; i < data.length; i++)
                {  
				 if (!(((data.charCodeAt(i)>=48) && (data.charCodeAt(i)<=57))||((data.charCodeAt(i)>=65) && (data.charCodeAt(i)<=90))||((data.charCodeAt(i)>=97) && (data.charCodeAt(i)<=122))))
                    {    
					data=data.replace(/[!`@#$%^&*()+=\-\[\]';,.\/{}|\s":<>\\?~_]/g,'');
                    document.getElementById("txt1").value =data;                    
					return false; 
                    } 
                }
				return true;
         }
	
	

	function changeCase(Obj)
	{
		Obj.value =Obj.value.toUpperCase();
	}
	
	function callSubmit()
	{ 
		var continue_yn = "Y";
		var old_file_no=document.forms[0].old_file_no.value;
		var oldvalue=document.forms[0].oldvalue.value;
		if((old_file_no == '' && oldvalue== '') || !(old_file_no== '' && oldvalue==''))
		{	
			if(old_file_no==oldvalue)
		     {  
			    continue_yn = "N";
				error  = getMessage("NO_CHANGE_TO_SAVE","Common");
				alert(error);
				document.forms[0].old_file_no.focus();
			 }
		}
		
		if(continue_yn == "Y")
		{ 
		document.forms[0].submit();
		parent.document.getElementById("dialog_tag").close(); 
		}
	}
	
	
</script>
</head>

<body onKeyDown='lockKey()'>
<form name='updatefileno' id='updatefileno' method='post' action='../../servlet/eMR.UpdateFileNoServlet' target='messageFrame'>
<table>
 <tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>

</table>
<table border='0' cellpadding='5' cellspacing='0' align='center' width='auto'>
      
      		<tr>
      		    <td  class='label'><fmt:message key="Common.OldFileNo.label" bundle="${common_labels}"/>(<fmt:message key="Common.currentvalue.label" bundle="${common_labels}"/>)</td>
      		    <td class='fields'><B><%=old_fileno%></B></td>
      		</tr>
      		
      		
      		<tr>
      		    <td  class='label'><fmt:message key="Common.OldFileNo.label" bundle="${common_labels}"/>(<fmt:message key="Common.NewValue.label" bundle="${common_labels}"/>)</td>
      		    <td class='fields'>
      		    <input type='text' id='txt1' name='old_file_no' id='old_file_no' size='20' maxlength='20' value="" onKeyPress='return allowAlphaNumeric(event)' onBlur='changeCase(this);return removeSpec()'></td>
      		</tr>
 <tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
 
      		<tr>
      		<td>&nbsp;</td>
      		<td ><input type='Button' class='Button' name='save' id='save' value='<fmt:message key="Common.Save.label" bundle="${common_labels}"/>'  onClick='callSubmit()'>
      		&nbsp;&nbsp;<input type='Button' class='Button' name='cancel' id='cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='parent.document.getElementById("dialog_tag").close();'>
      		</td></tr>
  </table>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=FacilityID%>'>
<input type='hidden' name='fileno' id='fileno' value='<%=fileno%>'>
<input type='hidden' name='oldvalue' id='oldvalue' value='<%=old_fileno%>'>

</form>
</body>
</html>


<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head><title><fmt:message key="eIP.ConsentText.label" bundle="${ip_labels}"/></title>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	 
<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<script language="javascript">
  window.onbeforeunload = confirmExit; 
  function confirmExit()   {    
    window.returnValue =document.getElementById("txt_consent").value;
  }
  function imposeMaxLength(Event, Object, MaxLen)  {      
	  return (Object.value.length <= MaxLen)||(Event.keyCode == 8 ||Event.keyCode==46||(Event.keyCode>=35&&Event.keyCode<=40))
   }   
 function checkMaxLenDtls(obj,name){
	if (obj.value.length >3000)	{		
		var test = obj.value.substring(0,3000)		
		document.forms[0].txt_consent.value = obj.value.substring(0,3000)			
		var error = getMessage("REMARKS_CANNOT_EXCEED_TRUNC","IP");
		error = error.replace("$",name);
		error = error.replace("#","3000");
		alert(error);
		obj.focus();
	}
}
function loadPassedData(){
    var obj = window.dialogArguments;
	var consent = document.getElementById('txt_consent');
    consent.value = obj.data; 	
}
function passData(){
    var obj = window.dialogArguments;
    obj.returnvalue = document.getElementById('txt_consent').value;
	window.close()
}
function SplCharsChkForNameDrvn(event){   
    var strCheck ="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_&-< >+\,.:/:'()|"; 
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body onLoad="loadPassedData()" onunload="passData()">
   
    <form name="consenttxt1" id="consenttxt1" method="post">

    <%
	request.setCharacterEncoding("UTF-8");
	String contxtdtls = checkForNull(request.getParameter("consent_text_details"));	
//	String consenttxtdtls =	(String)session.getValue("consenttxtdtls");
	 
	%>
	  <table align="center">
	     <tr>		  		
		 <textarea name="txt_consent" cols="64" rows="27" id="txt_consent" onkeypress = "return SplCharsChkForNameDrvn(event);" onkeydown = "return imposeMaxLength(event,this, 2999);"onblur='makeValidString(this);return checkMaxLenDtls(this,"<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ConsentText.label","ip_labels")%>")'><%=contxtdtls%></textarea></td>
		 </tr>
	  <tr>
		 <td align="center" colspan="2">
  <input type="button" class = 'BUTTON' value ='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="passData()">
		 </td>
		 </tr>
	  </table>	
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


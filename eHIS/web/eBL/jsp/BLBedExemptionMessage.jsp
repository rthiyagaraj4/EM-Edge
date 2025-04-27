<!DOCTYPE html>

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
.getAttribute("PREFERRED_STYLE") : "IeStyle.css";  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language='javascript' src='../../eBL/js/BillReceipt.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>



<title>Exemption Message  </title>

<script>






function confirm(obj){
	var retVal="";
			
	if(obj == '1'){		
		retVal = "Y";
	}else{
		retVal = "N";
	}	
	
	parent.window.returnValue = retVal;	
	parent.window.close();
	
}

</script>
<%

//var exemptMessage=  getMessage('BL6280','BL');

String exemptMessage = request.getParameter("exemptMessage");
System.out.println("sugguuuu=========="+exemptMessage);
 %>

<table width='100%' >
<tr>
 <td class="LABEL" width="100%" align ="center">
<%=exemptMessage%></td>
	
</tr>
<tr>
</tr>

<tr>
	
	<td width="50%" align ="center">
	<input type='button' class='button' name='No' id='No' value='No'onclick="confirm('2')">
	<input type='button' class='button' name='Yes' id='Yes' value='Yes' onclick="confirm('1')">
	
	</td>
	
	
	
	
	
</tr>
</table>

<input type='hidden' name='exemptMessage' id='exemptMessage' value='<%=exemptMessage %>'>



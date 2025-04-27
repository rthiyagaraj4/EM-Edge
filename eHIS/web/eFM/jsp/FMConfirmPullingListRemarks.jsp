<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import= "java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eFM/js/FMConfirmPullingList.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<!--Below Line funtions Added for this incident [IN:036183]  -->
<script>
  function maxLength(field,maxChars)
 {
       if(field.value.length >= maxChars) {
          event.returnValue=false;		   
          return false;
       }
 }  

 function maxLengthPaste(field,maxChars)
 {
       event.returnValue=false;
       if((field.value.length +  window.clipboardData.getData("Text").length) > maxChars) {	 
	     var errors1 = getMessage('REMARKS_EXCEED_MAX_LEN','FM');
		   alert(errors1);	   
         return false;
       }
       event.returnValue=true;
 }

</script>
<!--End incident[IN:036183]-->
<title><fmt:message key="eFM.ConfirmPullingListRemarks.label" bundle="${fm_labels}"/></title>
</head>
<% 
	String p_remarks			=request.getParameter("p_remarks");
	if (p_remarks==null) p_remarks="";
%>	
<body onload=''  onKeyDown = 'lockKey()' onUnload ='closeWin()' style='background-color:#E2E3F0;'>
<table width='100%' border='0' cellspacing='0' cellpadding='0' align=center>
	<tr>
		<td class='label' width='10%'></td>
	</tr>
	<tr>
		<td  width='90%' class='fields'><textarea name="comments" rows="5" cols="60" onkeypress='return maxLength(this,"100");' onpaste='return maxLengthPaste(this,"100");' onBlur="makeValidString(this);"><%=p_remarks%></textarea></td>
	</tr>
</table>
	<center><input type='Button' class='Button' name='Ok' id='Ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick='doClose()'></center>	
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


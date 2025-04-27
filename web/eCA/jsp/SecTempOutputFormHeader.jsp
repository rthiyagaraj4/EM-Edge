<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../js/SecTempOutputForm.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
 /*  function putSometexttoClipBoardSection()
  {
	  var text = window.clipboardData.getData("Text");
	  if(text == "" || text == null)
	  {
		if(document.getElementById("clipTxtBtnID") != null)
		{
			var clipBoardVal=document.getElementById("clipTxtBtnID").createTextRange();
			clipBoardVal.select();
			clipBoardVal.execCommand("copy","","");
			clipBoardVal.execCommand("Unselect","","");
		}
	  }
  } */
  function putSometexttoClipBoardSection() {
	    if (navigator.clipboard) {
	        navigator.clipboard.readText()
	            .then(text => {
	                if (text === "" || text === null) {
	                    if (document.getElementById("clipTxtBtnID") !== null) {
	                        var clipBoardVal = document.getElementById("clipTxtBtnID");
	                        clipBoardVal.select();
	                        document.execCommand("copy");
	                    }
	                }
	            });
	    }
	}


</script>
</head>
<body  OnMouseDown="CodeArrest()" onload='FocusFirstElement();putSometexttoClipBoardSection()' onKeyDown="lockKey()">
<form name='SecTempOutputFormHeaderForm' id='SecTempOutputFormHeaderForm' method='post' action='../../servlet/eCA.SecTempOutputFormServlet' target="messageFrame">
<table  width='100%' border='0' cellspacing='0' cellpadding='3' align="center" >
<tr>
<td  class="label" width ='25%'><fmt:message key="Common.Section.label" bundle="${common_labels}"/>&nbsp;&nbsp;
<input type ="text" name ="sect_name" size ="30" value="" onBlur='populate(this);' ><input type="hidden" name ="section" value=""><input type="button" class='Button' name="section_button" id="section_button" title='search_code' value="?" onClick='populate(this);'><img src='../../eCommon/images/mandatory.gif' ></img>
<input name="contentType" id="contentType" type="hidden" value="">
<input name="mode" id="mode" type="hidden" value="">
<input name="clipTxtBtnName" id="clipTxtBtnName" id='clipTxtBtnID' type="hidden" value="Clip Text" style='display:none"'>
</td>
</tr>
</table>
</form>
</body>
</html>


<!DOCTYPE html>
<html> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>
<head>
<% 
  String  message = "";
  String  applicationid = "";
  String  nontabelementid = "";
  String  mode = "";
  message =request.getParameter("message");
  applicationid=(String)request.getAttribute("applicationid");
  nontabelementid =(String) request.getAttribute("nontabelementid"); 
  mode =(String) request.getAttribute("mode"); 
		 
%>
<script Language="JavaScript"  src="../eCommon/js/ValidateControl.js" ></script>
<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script language="JavaScript">
function callFirst()
{


    if( data_element_form.mode.value=='0')
	{
	data_element_form.action='../eXH/jsp/DataElementCrossRefNonTableValuesSetupqueryrecord.jsp';
	data_element_form.target="applnontablecodesearch";
data_element_form.submit();

	}
	else {

          data_element_form.action='../eXH/jsp/DataElementCrossRefNonTableValuesSetupqueryrecord.jsp';
	      data_element_form.target="applnontablecodesearch";
	      data_element_form.submit();
	    }
//		document.forms[0].nontabelementid.value

//alert(parent.frames[2].frames[1].frames[1].frames[0].name);
//parent.frames[2].frames[1].frames[1].frames[1].document.location.href='../../eXH/jsp/DataElementCrossRefNonTableValuesSetup.jsp?';
//applicationid='+parent.frames[2].frames[0].document.forms[0].application.value+'&nontabelementid='+parent.frames[2].frames[1].frames[0].document.forms[0].nontabelementid.value;



}
</script>



</head>
<BODY CLASS="MESSAGE" onLoad="callFirst();" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="data_element_form" id="data_element_form">
<input type="hidden" name="applicationid" id="applicationid" value='<%=applicationid%>'/>
<input type="hidden" name="nontabelementid" id="nontabelementid" value='<%=nontabelementid%>'/>
<input type="hidden" name="mode" id="mode" value='<%=mode%>'/>
<p align="left">
<%=message%>
</p>
</form>
</BODY>
</html>


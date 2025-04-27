<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String calledFrom=request.getParameter("calledFrom");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
   <script src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<script>
function closew()
  {
	  window.parent.close();
  }
function clearValues()
{
	parent.frames[2].clearValues();
}
function recordVal()
{
	parent.frames[2].recordVal();
}
</script>

<body onKeyDown='lockKey();'>
<%
		if(calledFrom.equals("AssPrForAutoCls"))
		{
			%>
			<table width="90%" cellspacing='0' cellpadding='0' align='center'>			
			<tr class='white'>
			<td align="right" class="white">
			<input type='button' class='button' name='record' id='record' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick='recordVal();'><input type="button" align='left' class='button' name="cancel" id="cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick='clearValues();'> 
			</td>
			</tr>
			</table>			
			<%
		}
		else {
%>
<div align='center'>
<table  cellpadding='0' cellspacing='0' >
			<tr>
			    <td >
					<input type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='closew()' class='button'>
				</td>
			</tr>
</table>
</div>

<%
						}

%>

</body>
</html>



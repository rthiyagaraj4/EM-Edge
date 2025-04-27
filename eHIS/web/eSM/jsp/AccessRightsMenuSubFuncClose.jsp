<!DOCTYPE html>
<%@ page import="java.sql.*, java.net.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<%
	    request.setCharacterEncoding("UTF-8");
        String sStyle	=      (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
function sendValues()
{
	var tot_recs = parent.frames[0].document.forms[0].Pval.value;
	var record_values = "";
	var j = 1;

	for(i = 1;i <= tot_recs;i++)
	{
		if(j == 1)
		{
			record_values = eval("parent.frames[0].document.forms[0].subfunctionid"+i+".value");
			record_values += "|"+eval("parent.frames[0].document.forms[0].subinc"+i+".value");
			record_values += "|"+eval("parent.frames[0].document.forms[0].subins"+i+".value");
			record_values += "|"+eval("parent.frames[0].document.forms[0].subupd"+i+".value");
			record_values += "|"+eval("parent.frames[0].document.forms[0].subdel"+i+".value");
			record_values += "|"+eval("parent.frames[0].document.forms[0].subqry"+i+".value");
			record_values += "|"+eval("parent.frames[0].document.forms[0].subprn"+i+".value");
			j++;
		}
		else
		{
			record_values += "$"+eval("parent.frames[0].document.forms[0].subfunctionid"+i+".value");
			record_values += "|"+eval("parent.frames[0].document.forms[0].subinc"+i+".value");
			record_values += "|"+eval("parent.frames[0].document.forms[0].subins"+i+".value");
			record_values += "|"+eval("parent.frames[0].document.forms[0].subupd"+i+".value");
			record_values += "|"+eval("parent.frames[0].document.forms[0].subdel"+i+".value");
			record_values += "|"+eval("parent.frames[0].document.forms[0].subqry"+i+".value");
			record_values += "|"+eval("parent.frames[0].document.forms[0].subprn"+i+".value");
		}
	}

	parent.window.returnValue = record_values;
	parent.window.close();
}
</script>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="SubFuncClose" id="SubFuncClose">
	<table width="100%" cellpadding='0' cellspacing='0' border='0'>
		<tr>
			<td width="100%" class="white">
				<input type="button" name="close" id="close" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class="button" onClick="sendValues()">&nbsp;
			</td>
		</tr>
	</table>
</form>
</body>
</html>


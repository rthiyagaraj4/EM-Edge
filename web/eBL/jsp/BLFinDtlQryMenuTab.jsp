<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script>
function tab_click2(objName,errorMsg)
{
	selectTab(objName);
	tab_click1(objName);
}

function tab_click1(objName)
{
	if(	objName=="pymtdet_tab")
	{
		parent.frames[2].document.getElementById("pymtdet_focus").scrollIntoView(true);
	}
	else if(objName=="adjdet_tab")
	{
		parent.frames[2].document.getElementById("adjdet_focus").scrollIntoView(true);
	}
	else if(objName=="exmtdet_tab")
	{
		parent.frames[2].document.getElementById("exmtdet_focus").scrollIntoView(true);
	}
	else if(objName=="remdet_tab")
	{
		parent.frames[2].document.getElementById("remdet_focus").scrollIntoView(true);
	}
	else if(objName=="writoffdet_tab")
	{
		parent.frames[2].document.getElementById("writoffdet_focus").scrollIntoView(true);
	}
}
</script>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>

	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script> 
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form >

<ul id="tablist" class="tablist">
	<script>prevTabObj='pymtdet_tab'</script>
	<li class="tablistitem" title="Payment Details">
		<a onclick="javascript:tab_click2('pymtdet_tab','')" id="pymtdet_tab" class="tabClicked"  >
			<span class="tabSpanclicked" id="pymtdet_tabspan">Payment Details</span>
		</a>
	</li>

	<li class="tablistitem" title="Adjustment Details">
		<a onclick="javascript:tab_click2('adjdet_tab','')" id="adjdet_tab" class="tabA"  >
			<span class="tabAspan" id="adjdet_tabspan">Adjustment Details</span>
		</a>
	</li>
		
	<li class="tablistitem" title="Exemption Details">
		<a onclick="javascript:tab_click2('exmtdet_tab','')" id="exmtdet_tab" class="tabA"  >
			<span class="tabAspan" id="exmtdet_tabspan">Exemption Details</span>
		</a>
	</li>

	<li class="tablistitem" title="Reminder Details">
		<a onclick="javascript:tab_click2('remdet_tab','')" id="remdet_tab" class="tabA"  >
			<span class="tabAspan" id="remdet_tabspan">Reminder Details</span>
		</a>
	</li>

	<li class="tablistitem" title="Write-off Details">
		<a onclick="javascript:tab_click2('writoffdet_tab','')" id="writoffdet_tab" class="tabA"  >
			<span class="tabAspan" id="writoffdet_tabspan">Write-off Details</span>
		</a>
	</li>
</ul>

</form>
</body>
</html>


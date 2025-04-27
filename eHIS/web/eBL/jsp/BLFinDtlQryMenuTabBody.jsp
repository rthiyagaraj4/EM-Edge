<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%

	String tab_chk="";

	try
	{
		tab_chk=request.getParameter("tab_chk");
		if(tab_chk==null) tab_chk="";
//		System.out.println("tab_chk:"+tab_chk);
	}
	catch(Exception eX)
	{
			out.println("Error= "+eX);
	}
%>

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
		document.getElementById("pymtdet_focus").scrollIntoView(true);
	}
	else if(objName=="adjdet_tab")
	{
		document.getElementById("adjdet_focus").scrollIntoView(true);
	}
	else if(objName=="exmtdet_tab")
	{
		document.getElementById("exmtdet_focus").scrollIntoView(true);
	}
	else if(objName=="remdet_tab")
	{
		document.getElementById("remdet_focus").scrollIntoView(true);
	}
	else if(objName=="writoffdet_tab")
	{
		document.getElementById("writoffdet_focus").scrollIntoView(true);
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




<body onSelect="codeArrestThruSelect()" onload='' onKeyPress='return ChkKey(event);'OnMouseDown="CodeArrest()"  onKeyDown='lockKey()'>
<form>

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
<a name='pymtdet_focus'> </a>
<table width='100%' cellpadding='0' cellspacing='1' border ='0' width='100%'>
	<tr>
		<td>Payment Detail</td>
	</tr>
</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>


<ul id="tablist" class="tablist">
	<script>prevTabObj='pymtdet_tab'</script>
	<li class="tablistitem" title="Payment Details">
		<a onclick="javascript:tab_click2('pymtdet_tab','')" id="pymtdet_tab" class="tabA"  >
			<span class="tabAspan" id="pymtdet_tabspan">Payment Details</span>
		</a>
	</li>

	<li class="tablistitem" title="Adjustment Details">
		<a onclick="javascript:tab_click2('adjdet_tab','')" id="adjdet_tab" class="tabClicked"  >
			<span class="tabSpanclicked" id="adjdet_tabspan">Adjustment Details</span>
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
<a name='adjdet_focus'> </a>
<table width='100%' cellpadding='0' cellspacing='1' border ='0' width='100%'>
<tr>
	<td >Adjustment Details</td>
</tr>
</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>


<ul id="tablist" class="tablist">
	<script>prevTabObj='pymtdet_tab'</script>
	<li class="tablistitem" title="Payment Details">
		<a onclick="javascript:tab_click2('pymtdet_tab','')" id="pymtdet_tab" class="tabA"  >
			<span class="tabAspan" id="pymtdet_tabspan">Payment Details</span>
		</a>
	</li>

	<li class="tablistitem" title="Adjustment Details">
		<a onclick="javascript:tab_click2('adjdet_tab','')" id="adjdet_tab" class="tabA"  >
			<span class="tabAspan" id="adjdet_tabspan">Adjustment Details</span>
		</a>
	</li>
		
	<li class="tablistitem" title="Exemption Details">
		<a onclick="javascript:tab_click2('exmtdet_tab','')" id="exmtdet_tab" class="tabClicked"  >
			<span class="tabSpanclicked" id="exmtdet_tabspan">Exemption Details</span>
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
<a name='exmtdet_focus'> </a>
<table width='100%' cellpadding='0' cellspacing='1' border ='0' width='100%'>
<tr>
	<td >Exemption Details</td>
</tr>
</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>


<ul id="tablist" class="tablist">
	<script>prevTabObj='pymtdet_tab'</script>
	<li class="tablistitem" title="Payment Details">
		<a onclick="javascript:tab_click2('pymtdet_tab','')" id="pymtdet_tab" class="tabA"  >
			<span class="tabAspan" id="pymtdet_tabspan">Payment Details</span>
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
		<a onclick="javascript:tab_click2('remdet_tab','')" id="remdet_tab" class="tabClicked"  >
			<span class="tabSpanclicked" id="remdet_tabspan">Reminder Details</span>
		</a>
	</li>

	<li class="tablistitem" title="Write-off Details">
		<a onclick="javascript:tab_click2('writoffdet_tab','')" id="writoffdet_tab" class="tabA"  >
			<span class="tabAspan" id="writoffdet_tabspan">Write-off Details</span>
		</a>
	</li>
</ul>
<a name='remdet_focus'> </a>
<table width='100%' cellpadding='0' cellspacing='1' border ='0' width='100%'>
<tr>
	<td >Reminder Details</td>
</tr>
</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>


<ul id="tablist" class="tablist">
	<script>prevTabObj='pymtdet_tab'</script>
	<li class="tablistitem" title="Payment Details">
		<a onclick="javascript:tab_click2('pymtdet_tab','')" id="pymtdet_tab" class="tabA"  >
			<span class="tabAspan" id="pymtdet_tabspan">Payment Details</span>
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
		<a onclick="javascript:tab_click2('writoffdet_tab','')" id="writoffdet_tab" class="tabClicked"  >
			<span class="tabSpanclicked" id="writoffdet_tabspan">Write-off Details</span>
		</a>
	</li>
</ul>
<a name='writoffdet_focus'> </a>
<table width='100%' cellpadding='0' cellspacing='1' border ='0' width='100%'>
<tr>
	<td >Write-off Detail</td>
</tr>
</table>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</form>
</body>

</html>


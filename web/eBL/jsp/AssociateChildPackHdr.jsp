<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
	<form name='ass_child_hdr' id='ass_child_hdr'>	
	<!-- <div id="tbl-container" STYLE="overflow: auto; width: 1020px; height: 355px;   padding:3px; margin: 0px"> -->
	<div id="tbl-container" STYLE="overflow-x:scroll; width: 100%;    padding:3px; margin: 0px">

	<table class='grid' width='100%' height='70%' id="ass_child_pack_hdr">
		<thead>
		
	<tr><td class='COLUMNHEADER'  colspan='12' align='LEFT'><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/>&nbsp;: &nbsp;&nbsp;,&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Customer.label" bundle="${common_labels}"/>&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;</td>
	</tr>
		
</thead>
</table>
</div>
</form>
</body>
</html>


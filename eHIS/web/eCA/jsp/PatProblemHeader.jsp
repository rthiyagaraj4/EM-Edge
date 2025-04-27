<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	<link rel='stylesheet' type='text/css' href='../../eCA/html/CAStyle.css'> -->
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
<STYLE>
	td.errorEvents
	{
		background-color: BROWN;
		border-style: dashed;
	}
	FONT.CRITICAL{
		background-color:RED;
	}
	FONT.NORMAL{
		background-color:GREEN;
	}
	FONT.HIGH{
		background-color:blue;
	}
	FONT.LOW{
		background-color:#F0FFFF;
	}
	FONT.CRITICALLOW{
		background-color:#D8BFD8;
	}
	FONT.CRITICALHIGH{
		background-color:YELLOW;
	}

	FONT.DELTAFAIL{
		background-color:#FFE4E1;
	}

</STYLE>
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<table border=0  cellpadding='3' cellspacing=0 width="100%">
	<tr>
		<td width="100%" align='left' class='oalabel'>&nbsp;<font CLASS='HIGH' size='1' >&nbsp;&nbsp;</font><font color='BLACK' size='1'>&nbsp;</font><font COLOR='BLACK' size='1'><b><fmt:message key="Common.CurrentEncounter.label" bundle="${common_labels}"/></b></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	</tr>
	</table>
</body>
</html>


<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
 request.setCharacterEncoding("UTF-8");
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="JavaScript" src="../../eCP/js/GCPGenerateCarePlan.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<STYLE>
	TD.GPLINKS {
	  BACKGROUND-COLOR: #FFFFF0 ;
	  COLOR: BLACK;
	  FONT-SIZE: 8PT ;
	  FONT-WEIGHT: normal;
	}
	FONT.LINKINSTATUS{
		COLOR: RED;
	}
	/*td.errorEvents
	{
		background-color: BROWN;
		border-style: dashed;
	}*/
	FONT.CRITICAL{
		background-color:RED;
	}
	FONT.NORMAL{
		background-color:GREEN;
	}
	FONT.HIGH{
		background-color:#10319C;
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
<form name="legend" id="legend">
<%

String links=request.getParameter("link");
//out.println("<script>alert('links::"+request.getQueryString()+"')</script>");
//	out.println("<script>alert('links::"+links+"')</script>");

%>	
	
	<table border=0  cellpadding=0 cellspacing=0 width="100%">
	<tr>
		<%if(links == null){%>
			<td width="90%" align='left' class='oalabel'> &nbsp;&nbsp;
			<B><font size='1'><fmt:message key="Common.priority.label" bundle="${common_labels}"/>:</font></B>&nbsp;&nbsp;&nbsp;&nbsp;
			<font CLASS='CRITICAL' size='1' >&nbsp;&nbsp;</font>&nbsp;
			<font size='1'><fmt:message key="Common.Critical.label" bundle="${common_labels}"/></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<font CLASS='CRITICALHIGH' size='1' >&nbsp;&nbsp;</font>&nbsp;
			<font size='1'><fmt:message key="Common.High.label" bundle="${common_labels}"/></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<font CLASS='NORMAL' size='1' >&nbsp;&nbsp;</font>&nbsp;
			<font size='1'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eCP.d.label" bundle="${cp_labels}"/>&nbsp;</font>&nbsp;
			<font size='1'><fmt:message key="Common.Differentials.label" bundle="${common_labels}"/></font></td>
		<%}else if(links.equals("Links")){%>
									
			<td align="left" class="GPLINKS" nowrap width='12%' id='diag'><b><a href="javascript:;" onclick="callDiagCaseScreen()"><font size='1' class="LINKINSTATUS" color=''>[<fmt:message key="eCP.DiagnosisCaseType.label" bundle="${cp_labels}"/>]</font></a>&nbsp;</b></td>
			<td align="left" class="GPLINKS" nowrap width='11%' id='lib'><b><a href="javascript:;" onclick="callLibraryScreen()"><font size='1' class="" color=''>[<fmt:message key="eCP.StandardCarePlan.label" bundle="${cp_labels}"/>]</font></a>&nbsp;</b></td>
			<td align="left" class="GPLINKS" nowrap width='9%' id='summ'><b><a href="javascript:;" onclick="callSummaryScreen()"><font size='1' color=''>[<fmt:message key="eCP.PlanSummary.label" bundle="${cp_labels}"/>]</font></a></b>
			<td align="left" class="GPLINKS" nowrap width='7%' id='detail'><b><a href="javascript:;" onclick="callDetailScreen()"><font size='1' color=''>[<fmt:message key="eCP.PlanDetail.label" bundle="${cp_labels}"/>]</font></a>&nbsp;</b></td>
			<td align="right" class="GPLINKS" width='25%'nowrap id='record'></td>		
			
		<%}%>
	</tr>
	</table>
</form>
</body>
</html>


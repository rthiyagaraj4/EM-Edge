<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
   <style>
	.Unprocessed{
		width: 10px;
		height: 12.5px;
		background: #52BD15;
	}
	.Unconfirmed{
		width: 10px;
		height: 12.5px;
		background: red;
	}

</style>
</head>

<BODY >
<table style="width: 20%;" align="right"> 
		<tr>
			<td style="width: 2%;">
				<span class='Unprocessed'>&nbsp;</span>
			<td style="width: 8%;" class='LABEL'>
				Unprocessed
			</td>		
			<td style="width: 2%;">
				<span class='Unconfirmed'>&nbsp;</span>
			<td style="width: 8%;" class='LABEL'>
			Unconfirmed
			</td>
		</tr>		
	</table>
</BODY>

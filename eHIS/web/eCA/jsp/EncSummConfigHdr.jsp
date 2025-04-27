<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
16/09/2013     		1   		Sethuraman      Created 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
	
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	{
		imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	}
	 //end
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<Script src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../js/EncSummConfig.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body class='CONTENT' OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
	<form name="HeaderForm" id="HeaderForm" >
		<center>
		<table border="0" cellpadding="3" cellspacing="0" width="100%" align="center"> 
			<tr>
				<td class="label" ><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type='hidden' name='summary' id='summary' value='' ><input type='text' name ='summaryCode' onBlur='getSummaryCode(this)' OnChange='resetValues();setValue()'>
					<input type ='button' class='button' name='summarySearch' id='summarySearch' value='?' onclick='resetValues();getSummaryCode(this)'>
						<img src="../../eCommon/images/mandatory.gif"></img>
					<td colspan = 2 align ='right'>
						<input type="button" name="search" id="search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="fetchRecords();"  class="button">
					</td>
			</tr>
			</center>
		</table>
		<%if(!imgUrl.equals("")){ %>
			 <img src='<%=imgUrl%>' width='100%' height='15'/> 
		<%}%>
		<input type='hidden' name='mode' id='mode' value='<%=mode %>'>
	    <input type='hidden' name='flag' id='flag' value='true'>
		<input type="hidden" name="selectYNStr" id="selectYNStr" value="">
		<input type="hidden" name="finalString" id="finalString" value="">
	</form>
</body>
</html>



<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Rev.Date	Rev.Name	Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
06/07/2011    101            Dinesh      Incident No: 27046, Remarks in the Charting 
17/03/2014	IN047648		 Vijayakumar K		17/03/2014	Chowminya G	Record Charts ->?Enter/Edit Remark webpage dialog?, 
--------------------------------------------------------------------------------------------------------
-->
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%@page contentType="text/html;charset=UTF-8" %> <!--101 -->
<%
request.setCharacterEncoding("UTF-8");//[101]
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085		
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String sentFrom = request.getParameter("sentFrom") == null ? "" : request.getParameter("sentFrom");
	String shortDesc = request.getParameter("shortDesc") == null ? "" : request.getParameter("shortDesc");
	String onBlurFunc = "";
	String readOnly = "";
	String title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Enter/Edit.label","common_labels");

	if(sentFrom.equals("viewComments"))
	{
		onBlurFunc = "";
		readOnly = " readOnly ";
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels");
	}
	else
	{
		onBlurFunc = " onblur='chkLength(this)' ";
		readOnly = "";
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Enter/Edit.label","common_labels");
	}

	String index = request.getParameter("index") == null ? "" : request.getParameter("index");
	String remarks = request.getParameter("remarks") == null ? "" : request.getParameter("remarks");	
%>
<html>
	<head>
		<title><%=title%> Remarks For <%=shortDesc%></title>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="javascript" src="../../eCA/js/ChartRecording.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<body>
		<form name='chartRecordingCommentsForm' id='chartRecordingCommentsForm'>
			<table>
				<tr>
					<td>
						<!-- IN047648 starts -->
						<!--<TEXTAREA NAME="textComments" ROWS="5" COLS="40" <% //=readOnly%> <% //=onBlurFunc%>><% //=remarks%></TEXTAREA>-->
						<TEXTAREA NAME="textComments" ROWS="5" COLS="45" <%=readOnly%> <%=onBlurFunc%>><%=remarks%></TEXTAREA>
						<!-- IN047648 ends -->
					</td>					
				</tr>
				<tr>
				<%if(sentFrom.equals("viewComments"))
				{%>
					<td align='right' height='30'>
						<input type='button' class='button' name='okBtn' id='okBtn' Value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick="window.close()">
					</td>
				<%}else {%>

					<td align='right' height='30'>
						<input type='button' class='button' name='okBtn' id='okBtn' Value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick="setRemarksField('<%=index%>')">
					</td>
				<%}%>
				</tr>
			</table>
		</form>
	</body>
</html>


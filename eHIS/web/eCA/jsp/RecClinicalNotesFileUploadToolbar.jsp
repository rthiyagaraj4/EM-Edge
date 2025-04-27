<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,java.io.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title></title>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCA/js/RecClinicalNotesFileUpload.js' ></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	String call_from = request.getParameter("call_from")==null?"":request.getParameter("call_from");
	String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String win_visibility = "";
	String visibility = "";
	//out.println("<script>alert('"+call_from+"')</script>");
	//out.println("<script>alert('"+request.getQueryString()+"')</script>");

	if(call_from.equals("window"))
	{
			win_visibility = "display";
			visibility = "display:none";
	}
	else
	{
			win_visibility = "display:none";
			visibility = "display";
	}
%>
</head>
	<body  class='CONTENT' onKeyDown="lockKey()" >

		<form name='RecClinicalNotesFileUploadToolbarForm' id='RecClinicalNotesFileUploadToolbarForm' >
		<table border='0' width='100%' cellpadding='3' cellspacing='0' align='center'>
			<tr style = "<%=visibility%>" >
				<td width='25%' ></td><td width='25%' ></td><td width='25%' ></td><td width='25%' >
				 <input type='button' class='button' name='clear' id='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearFileName("uploadFile_div", "<%=called_from%>")' ></input>
				 <input type='button' class='button' name='btnUploadFile' id='btnUploadFile' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>' onClick='checkFileExtn(this,"<%=called_from%>")' ></input>
				<!--  <input type='button' class='button' name='view' id='view' id='viewfileid' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")%>' onClick='ViewNotesFile()' ></input> -->
				 <input type='button' class='button' id='noterecord' name='record' id='record' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' onClick='RecordNotesFile()' ></input>
				 <input type='button' class='button' id='notesign' name='sign' id='sign' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sign.label","common_labels")%>' onClick='SignNotesFile()' ></input>
				</td>
			</tr>
			<tr style = "<%=win_visibility%>">
				<td width='100%' colspan = 4 align ='right'>
				<input type='button' class='button' name='clear' id='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearFileName("uploadFile_div")' ></input>
				 <input type='button' class='button' name='btnUploadFile' id='btnUploadFile' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>' onClick='checkFileExtn(this)' ></input>
				 <input type='button' class='button' id='noterecord_sec' name='record_sec' id='record_sec' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' onClick='checkFileExtn(this,"")' ></input>
				</td>
			</tr>
		</table>	
		</form>
	</body>
</html>


<!DOCTYPE html>
<!-- 
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------
14/03/2019	IN068778		Selvin M		14/03/2019		Ramesh G		TBMC-CRF-0011
---------------------------------------------------------------------------------------------------------------------
-->
<%@page import="java.util.*,java.sql.*,java.io.*,webbeans.eCommon.*,eOR.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title></title>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOR/js/ImageVideosFileUpload.js' ></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String call_from = request.getParameter("call_from")==null?"":request.getParameter("call_from");
	String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");

%>
</head>
	<body  class='CONTENT' onKeyDown="lockKey()" >
		<form name='ImageVideosFileUploadToolbarForm' id='ImageVideosFileUploadToolbarForm' >
		<table border='0' width='100%' cellpadding='3' cellspacing='0' align='center'>			
			<tr>
				<td width='100%' colspan = 4 align ='right'>				
				 <input type='button' class='button' name='btnUploadFile' id='btnUploadFile' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>' onClick='checkFileExtn(this)' ></input>
				 <input type='button' class='button' id='noterecord_sec' name='record_sec' id='record_sec' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' onClick='checkFileExtn(this,"")'></input>
				 <input type='button' class='button' name='clear' id='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'onClick='clearFileName("uploadFile_div")' ></input>
				</td>
			</tr>
		</table>	
		</form>
	</body>
</html>


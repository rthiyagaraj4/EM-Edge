<!DOCTYPE html>
<!-- 
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------
28/03/2019	IN068778		Selvin M		28/03/2019		Ramesh G		TBMC-CRF-0011
---------------------------------------------------------------------------------------------------------------------
-->

<%@page import="java.util.*,java.sql.*,java.io.*,webbeans.eCommon.*,eOR.Common.*,eOR.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
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
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
try{
	String call_from = request.getParameter("call_from")==null?"":request.getParameter("call_from");
	String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	ImageVideosMultiFileUploadBean fbean = (ImageVideosMultiFileUploadBean) getObjectFromBean("MULTIPLEFILEUPLOADBEAN", "eOR.ImageVideosMultiFileUploadBean", session);
		
	String fileChoosePath = fbean.getSharedPath();
	File dir = new File(fileChoosePath);
	String[] files = dir.list();	
	ArrayList<String> filesList = fbean.getUnlinkedVideoFiles();
	Boolean isRecordsAvailable = false; 
	int i = 0;
%>
</head>
	<body  class='CONTENT' onKeyDown="lockKey()" >
		<form name='ImageVideosDisplayForm' id='ImageVideosDisplayForm'>
		<table class = "grid" width='100%'>			
			<tr>
				 <td class='columnheadercenter' colspan='0' width='100%' ><fmt:message key="eCA.FileReference.label" bundle="${ca_labels}"/></td>
			</tr>			
			 <%
				for(String aFile : files){
					if(filesList.contains(aFile)){
						isRecordsAvailable = true;
					String extn = aFile.substring(aFile.lastIndexOf(".")+1, aFile.length()); //IN70150		
					if("mp4".equalsIgnoreCase(extn)){	
			%>	<tr>												
					<td class='gridData' width="100%" align='center'><a href='#' class='gridLink' onclick="setFilePath('<%=fileChoosePath%>','<%=i%>')"><%=aFile%></a></td>
					<input type = 'hidden' name = 'selectedFile<%=i%>' value = "<%=aFile%>"/>							
				</tr>							
				<%		
						i++;
						}
					}
				}
		
			if(!isRecordsAvailable)
				out.println("<script>alert(getMessage('NO_VIDEO_FILES_TO_LINK','OR'));window.close();</script>"); 
	%>				
		</table>
<%
}catch(Exception e){
	e.printStackTrace();
}
%>
</form>
</body>
</html>


<!DOCTYPE html>
<%@page import="java.util.*,java.sql.* ,java.io.*, webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<title><fmt:message key="eCA.Preview.label" bundle="${ca_labels}"/></title>
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
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>	
	<iframe id='RecClinicalNotesFileListFrame' name='RecClinicalNotesFileListFrame' id='RecClinicalNotesFileListFrame' src='../../eCA/jsp/RecClinicalNotesMultiFileList.jsp?<%=request.getQueryString()%>' frameborder='0' scrolling='no' noresize style='height:97.5vh;width:100vw'></iframe>	
		<iframe id='RecClinicalNotesShowFileFrame' name='RecClinicalNotesShowFileFrame' id='RecClinicalNotesShowFileFrame' src='../../eCA/jsp/blank.jsp' frameborder='0' scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
	
</html>


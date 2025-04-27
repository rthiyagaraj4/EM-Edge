<!DOCTYPE html>

<%@page import="java.util.*,java.sql.*,java.io.*,webbeans.eCommon.*,eCA.*,java.text.DecimalFormat,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

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
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCA/js/RecClinicalNotesFileUpload.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<body>
<%
	String resultFlag = request.getParameter("resultFlag")==null?"":request.getParameter("resultFlag");
	String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	if(!resultFlag.equals(""))
	{%>
		<SCRIPT LANGUAGE="JavaScript">
			reLoadFrames('<%=resultFlag%>','<%=called_from%>')
		</SCRIPT>	
	<%}
	RecClinicalNotesMultiFileUploadBean fbean = (RecClinicalNotesMultiFileUploadBean) getObjectFromBean("MULTIFILEUPLOADBEAN", "eCA.RecClinicalNotesMultiFileUploadBean", session);
	List<String> fileNameList = fbean.getDocNameList();
	String docRemarks = "";
//	boolean isSigned = fbean.isNoteDocSigned();
	String disabled = fbean.isNoteDocSigned()?"disabled":"";	
%>
	<form>
		<table class='grid' width='100%'>
			<tr style="text-align: left;">
				<th class='columnheadercenter' colspan='0' width='25%' ><fmt:message key="eCA.FileReference.label" bundle="${ca_labels}"/></th>
				<th class='columnheadercenter' colspan='0' width='25%' ><fmt:message key="eCA.Size.label" bundle="${ca_labels}"/></th>
				<th class='columnheadercenter' colspan='2'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
				<th class='columnheadercenter'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
			</tr>
			<tr>
				<%
					if(fileNameList != null)
					{
						String fileSizeUnit = fbean.getFileUnit();
						double docSize = 0;
						for(String fileName: fileNameList)
						{
							docRemarks = fbean.getFileSet().get(fileName).getDocRemarks();
							docSize = (double)fbean.getFileSet().get(fileName).getDocSize();
							if(fileSizeUnit.equals("M"))
							{
								docSize = (docSize/1024)/1024;
							}
							else if(fileSizeUnit.equals("K"))
							{
								docSize = docSize/1024;
							}	
							
							DecimalFormat dfToInteger = new DecimalFormat("#.####");
					%>
						<tr>
							<td class='gridData' width='25%'><%=fileName%></td>
							<td class='gridData' width='25%'><%=dfToInteger.format(docSize)%>&nbsp;<%=fileSizeUnit.equals("M")?"MB":"KB"%></td>
							<td class='gridData' width='65%' wrap><%=docRemarks%></td>
							<td class='gridNumericData' width='5%'><a href='#' class='gridLink' onclick="displayFile('<%=fileName%>')"><fmt:message key="Common.view.label" bundle="${common_labels}"/></a></td>
							<td class='gridData' width='5%'><input type='checkbox' name='1' id='1' checked  onclick="delteFile(this, '<%=fileName%>','<%=called_from%>')" name='<%=fileName%>' <%=disabled%>></td>
						</tr>
					<%
						}
					}
				%>
			</tr>
		</table>
	</form>
</body>


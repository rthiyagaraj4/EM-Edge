<!DOCTYPE html>
<!-- 
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------
14/03/2019	IN068778		Selvin M		14/03/2019		Ramesh G		TBMC-CRF-0011
---------------------------------------------------------------------------------------------------------------------
-->

<%@page import="java.util.*,java.sql.*,java.io.*,webbeans.eCommon.*,eOR.*,eOR.Common.*,java.text.DecimalFormat,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html> 
<title></title>
<head>
<%
try
{
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOR/js/ImageVideosFileUpload.js' ></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<body>
<%
	String query_String = request.getQueryString();
	String resultFlag = request.getParameter("resultFlag")==null?"":request.getParameter("resultFlag");
	String called_from = request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");	
	
	if(!resultFlag.equals(""))
	{%>
		<SCRIPT LANGUAGE="JavaScript">
			reLoadFrames('<%=resultFlag%>','<%=called_from%>')
		</SCRIPT>	
	<%}
	ImageVideosMultiFileUploadBean fbean = (ImageVideosMultiFileUploadBean) getObjectFromBean("MULTIPLEFILEUPLOADBEAN", "eOR.ImageVideosMultiFileUploadBean", session);
	List<String> fileNameList = fbean.getDocNameList();
	
	
	String docRemarks = "";
	String fileTypeName="";	
	String disabled = "";	
	String imageVideosFormat ="";
	Boolean isView = false;
	
	if(called_from.equalsIgnoreCase("View")){
		isView = true;
	}
	
	String fileChoosePath = fbean.getSharedPath();
%>
	<form>
		<table class='grid' width='100%'>
			<tr>
				 <td class='columnheadercenter' colspan='0' width='10%' ><fmt:message key="eOR.Sno.label" bundle="${or_labels}"/></td>
				<td class='columnheadercenter' colspan='0' width='20%' ><fmt:message key="Common.filetype.label" bundle="${common_labels}"/></td>
				<td class='columnheadercenter' colspan='0' width='25%' ><fmt:message key="eCA.FileReference.label" bundle="${ca_labels}"/></td>
				<td class='columnheadercenter' colspan='0' width='25%' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
				<td class='columnheadercenter' colspan='0' width='10%'><fmt:message key="Common.view.label" bundle="${common_labels}"/></td>
				<%
				if(!isView)
				{
				%>
				<td class='columnheadercenter' colspan='0' width='10%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
				<%
				}
				%>	
			</tr>
			<tr>
				<%
				String splName=""; //IN70150
				if(fileNameList != null)
				{
					int sno=0;
					int index = 0;
					for(String fileName: fileNameList)
					{							
						
						//fileTypeName=fbean.getFileSet().get(fileName).getFileType();
						fileTypeName=fbean.getFileSet().get(fileName).getDocType();
						fileTypeName = fileTypeName==null?"":fileTypeName;
						docRemarks = fbean.getFileSet().get(fileName).getDocRemarks();							
						
						sno++;
						index++;
						//IN70150 start	
						/*if(!fileTypeName.equals(""))
						{
							splName = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
							fileTypeName=splName.toUpperCase();
						}		*/
						if(!fileTypeName.equals("")){	
							
							String[] fileType = fileTypeName.split("/");
							
							fileTypeName = fileType[1];
							
							if(fileTypeName.equals("octet-stream"))
								fileTypeName = "MP4";
							else if(fileTypeName.equalsIgnoreCase("pdf"))
								fileTypeName = "Pdf";
							
						if(fileTypeName.equalsIgnoreCase("MP4"))						
							imageVideosFormat ="Movie.png";
						else if(fileTypeName.equalsIgnoreCase("Pdf"))
							imageVideosFormat ="Pdf.png";
						else
							imageVideosFormat ="Image.png";
						}
						//IN70150 end
				%>
					<tr>					
						<td class='gridData' width='20%'><%=sno%></td>			
						<td class='gridData' width='20%'><%=fileTypeName%></td>		
						<td class='gridData' width='20%'><%=fileName%></td>
						<td class='gridData' width='50%' wrap><%=docRemarks%></td>
						<td class='gridNumericData' width='5%'>	
						<%
						if(fileTypeName.equalsIgnoreCase("MP4")){
							File file = null;
							
							String filePath = fileChoosePath + fileName;
							
							file = new File(filePath);
						%>
							<a href="<%=file%>" class='gridLink' border=0 align='center' onclick='refreshViewPage()'><img src='../../eOR/images/<%=imageVideosFormat%>'></a>	
						<%}else{%>
							<a href='#' class='gridLink' onclick="displayFile('<%=fileName%>')"><img src='../../eOR/images/<%=imageVideosFormat%>'>
						</a></td>								
					<%}%>
						
						<%
						if(!isView)
						{
						%>
						<td class='gridData' width='5%'><input type='checkbox' name='1' id='1' checked onclick="deleteFile(this,'<%=called_from%>','<%=index%>')" name='<%=fileName%>'></td>
						<input type = 'hidden' name = 'selectedFile<%=index%>' value = "<%=fileName%>"/>	
						<%
						}
						%>
					</tr>
				<%
					}
				}				
				%>
			</tr>			
		</table>
	</form>
</body>
<%
}
catch(Exception e)
{
	e.printStackTrace();	
}
%>


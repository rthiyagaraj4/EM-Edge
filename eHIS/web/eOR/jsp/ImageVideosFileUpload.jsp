<!DOCTYPE html>
<!-- 
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------
14/03/2019	IN068778		Selvin M		14/03/2019		Ramesh G		TBMC-CRF-0011
---------------------------------------------------------------------------------------------------------------------
-->
<%@page import="java.util.*,java.sql.*,java.io.*,webbeans.eCommon.*,eOR.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
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
	String query_string = "";
	String accession_num = "";
	String note_type = "";
	String operation_mode				= "";
	String function_id						= "";
	String window_close					= "";
	String patient_id						= "";
	String episode_type					= "";
	String encounter_id					= "";
	String patient_class					= "";
	String uploadremarks					= "";
	String note_type_desc				= "";
	String change_mode						 ="";
	String display_file						 ="";
	String call_from						 ="";
	String call_mode						 ="";
	String called_from						 ="";	
	String isView			="";			
	int count = 0;

	call_from = request.getParameter("call_from")==null?"":request.getParameter("call_from");
	System.err.println("87,call_from==="+call_from);
	accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
	note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");	
	operation_mode = request.getParameter("operation_mode")==null?"":request.getParameter("operation_mode");	
	function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");	
	window_close = request.getParameter("window_close")==null?"":request.getParameter("window_close");	
	patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");	
	episode_type = request.getParameter("episode_type")==null?"":request.getParameter("episode_type");	
	encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");	
	patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");		
	query_string = request.getParameter("query_string")==null?"":request.getParameter("query_string");		
	called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");	
	String order_id = request.getParameter("p_order_id")==null?"":request.getParameter("p_order_id");
	String order_line_num = request.getParameter("p_order_line_num")==null?"":request.getParameter("p_order_line_num");	
	ImageVideosMultiFileUploadBean fbean = (ImageVideosMultiFileUploadBean) getObjectFromBean("MULTIPLEFILEUPLOADBEAN", "eOR.ImageVideosMultiFileUploadBean", session);
	String fileChoosePath = fbean.getSharedPath();
	System.out.println("FileUpload.jsp,73,order_id=>"+order_id+",order_line_num=>"+order_line_num+",fileChoosePath=>"+fileChoosePath);
	File dir = new File(fileChoosePath);
	String[] files = dir.list();
	fbean.insertIntoTemp(files);	
	
	if(operation_mode.equals("Update") || count > 0){
		change_mode = "display:none";
		display_file = "display:inline";
	}else{
		change_mode = "display:none";
		display_file = "display:inline";
	}
	
	if(called_from.equals("View")){
		isView = "display:none";
	}else{
		isView = "display:inline";
	}
	
	if(count > 0)
		call_mode = "update";
	else
		call_mode = "";
%>
</head>
	<body  class='CONTENT' onKeyDown="lockKey()">

		<form name='ImageVideosFileUploadForm' id='ImageVideosFileUploadForm'  action="../../servlet/eOR.ImageVideosFileUploadServlet" method='post' enctype='multipart/form-data' target='messageFrame'>
		<table border='0' width='90%' cellpadding='0' cellspacing='0' align='center'>
			<tr  id='filetype_id' style='<%=isView%>'>
				<!--<td class = 'label'  ><fmt:message key="Common.filetype.label" bundle="${common_labels}"/>&nbsp;</td>
				<td class = 'fields' >
				<select name='filetype' id='filetype' onChange="dispHide(this);">
				<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
				<option value='JPG'><fmt:message key="eOR.Jpg.label" bundle="${or_labels}"/></option> 
				<option value='GIF'><fmt:message key="eOR.Gif.label" bundle="${or_labels}"/></option>
				<option value='PDF'><fmt:message key="eOR.Pdf.label" bundle="${or_labels}"/></option>
				<option value='MP4'><fmt:message key="eOR.Mp4.label" bundle="${or_labels}"/></option> 
				</select>
				<img src='../../eCommon/images/mandatory.gif'></div>&nbsp;</td>
				</td>
				 -->
				<td class = 'fields'><input type='radio' name='filetype' id='filetype' id='filetype' value='D' checked onClick="dispHide(this);"/>Images\Documents <input type='radio' id='filetype' name='filetype' id='filetype' value='V' onClick="dispHide(this);"/>Mp4 Videos </td>
			</tr>
			<tr id='file_id' style='<%=isView%>'>
				<td class='label' id='fileref' >
				<fmt:message key="eCA.FileReference.label" bundle="${ca_labels}"/>&nbsp;
				</td>
				<td class='fields' id="uploadTd" style="visibility:visible">				
					<div id="uploadFile_div" style='visibility:visible'>
						<input type='file' name='fileupload' id='fileupload' id = 'fileuploadid' size='30' onMouseDown='return checkFilevalue(this)' onKeyDown='return checkFilevalue(this);' onKeyPress =' return checkFilevalue(this);'  onclick='disableBtns(this,"<%=called_from%>");'><img src='../../eCommon/images/mandatory.gif'>&nbsp;
					</div>				
					<span id='fileRefVideo' style='visibility:hidden'>		
						<input type='text' name='fileuploadname' id='fileuploadname' id = 'fileuploadname' value= "" size='30'>				
						<input type='button' class='button' name='btnUp' id='btnUp' value='?' onClick='disableBtns(this,"<%=called_from%>"); diagTypeSelect(this)' >
						</input>	
						<img src='../../eCommon/images/mandatory.gif'>&nbsp;
					</span>
					</td>		
			</tr>	
			<tr style='<%=isView%>'>
				<td class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;</td>
				<td class = 'fields' ><textarea name='uploadremarks' rows='3' cols='55' maxlength="200" onKeyPress='checkMaxLimit(this,200);' onBlur='checkMaxLimitnew(this,200);'></textarea></td>
			</tr>			
		</table>
		
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		<input type="hidden" name="operation_mode" id="operation_mode" value="<%=operation_mode%>">
		<input type="hidden" name="function_id" id="function_id"	value="<%=function_id%>">
		<input type="hidden" name="queryString" id="queryString" value="<%=query_string%>">
		<input type="hidden" name="call_from" id="call_from" value="<%=call_from%>">	
		<input type="hidden" name="call_mode" id="call_mode" value="<%=call_mode%>">	
		<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>">				
		<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">		
		<input type="hidden" name="order_line_num" id="order_line_num" value="<%=order_line_num%>">		
		<input type="hidden" name="previewMode" id="previewMode" value="">	
		</form>			
	</body>
	<%
}catch(Exception e){
	e.printStackTrace();	
}
	%>
</html>


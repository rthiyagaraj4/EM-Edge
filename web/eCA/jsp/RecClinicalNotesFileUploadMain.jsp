<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name			Rev.Date   		Rev.By 			Description
--------------------------------------------------------------------------------------------------------------------------------
	?			100				?				?				?				?
13/05/2020		IN070345		Ramesh Goli		13/05/2020		Ramesh G		MO-CRF-20147.1
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,java.sql.* ,java.io.*, webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<title><fmt:message key="eCA.FileUpload.label" bundle="${ca_labels}"/></title>
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


<%
	String query_String = request.getQueryString();
	String accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
	String note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	RecClinicalNotesMultiFileUploadBean fbean = (RecClinicalNotesMultiFileUploadBean) getObjectFromBean("MULTIFILEUPLOADBEAN", "eCA.RecClinicalNotesMultiFileUploadBean", session);
	fbean.clear();
	//IN070345 Start.
	String facility_id = (String) session.getValue("facility_id");

	fbean.setSharedPath(facility_id);
	//IN070345 End.
	StringBuffer fileReffNo	= new StringBuffer((String)session.getValue("ca_practitioner_id"));
	fileReffNo.append(patient_id);
	fileReffNo.append(encounter_id); 	
	fbean.checkAndLoadBean(accession_num, note_type);
	fbean.setFileReffNo(fileReffNo.toString());

	putObjectInBean("MULTIFILEUPLOADBEAN",fbean,session);
	query_String = "insertAuditLogYN=Y&"+query_String;
%>
</head>	
	
	 <%if(called_from.equals(""))
	   {
			
	 %>
		<iframe name='RecClinicalNotesFileUploadListFrame' id='RecClinicalNotesFileUploadListFrame' src='../../eCA/jsp/RecClinicalNotesFileUploadList.jsp' frameborder='0' scrolling='auto' noresize style='height:50vh;width:97vw'></iframe>	
			<iframe name='RecClinicalNotesFileUploadFrame' id='RecClinicalNotesFileUploadFrame' src='../../eCA/jsp/RecClinicalNotesFileUpload.jsp?<%=query_String%>' frameborder=0 scrolling=no noresize style='height:30vh;width:97vw'></iframe>
			<iframe name='RecClinicalNotesFileUploadToolbarFrame' id='RecClinicalNotesFileUploadToolbarFrame' src='../../eCA/jsp/RecClinicalNotesFileUploadToolbar.jsp?<%=query_String%>' frameborder=0 scrolling=no noresize style='height:6vh;width:97vw'></iframe>
			<iframe name="messageframe" id="messageframe" src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 scrolling="auto" noresize style='height:10vh;width:97vw'></iframe>
		
	<%}else{ %>
		<iframe name='RecClinicalNotesFileUploadListFrame' id='RecClinicalNotesFileUploadListFrame' src='../../eCA/jsp/RecClinicalNotesFileUploadList.jsp?<%=query_String%>' frameborder='01' scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>	
			<iframe name='RecClinicalNotesFileUploadFrame' id='RecClinicalNotesFileUploadFrame' src='../../eCA/jsp/RecClinicalNotesFileUpload.jsp?<%=query_String%>' frameborder=01 scrolling=no noresize style='height:30%;width:100vw'></iframe>			
		
	<%}%> 
</html>


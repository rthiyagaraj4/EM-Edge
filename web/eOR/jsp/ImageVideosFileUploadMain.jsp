<!DOCTYPE html>
<!-- 
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------
14/03/2019	IN068778		Selvin M		14/03/2019		Ramesh G		TBMC-CRF-0011
---------------------------------------------------------------------------------------------------------------------
-->

<%@page import="java.util.*,java.sql.* ,java.io.*, webbeans.eCommon.*,eOR.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
<%
	String query_String = request.getQueryString();
	String l_order_id = request.getParameter("p_order_id")==null?"":request.getParameter("p_order_id");
	String l_order_line_num = request.getParameter("p_order_line_num")==null?"":request.getParameter("p_order_line_num");
	String l_report_srl_no = request.getParameter("p_line_srl_num")==null?"":request.getParameter("p_line_srl_num");
	String l_parent_srl_no = request.getParameter("p_parent_srl_no")==null?"":request.getParameter("p_parent_srl_no");
	String l_order_type = request.getParameter("p_order_type_code")==null?"":request.getParameter("p_order_type_code");
	String l_patient_id = request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
	String l_encounter_id = request.getParameter("p_encounter_id")==null?"":request.getParameter("p_patient_id");
	String l_called_from = request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
	String l_discr_msr_panel_id = request.getParameter("p_discr_msr_panel_id")==null?"":request.getParameter("p_discr_msr_panel_id");
	String l_acc_no = request.getParameter("p_acc_no")==null?"":request.getParameter("p_acc_no");	
	String l_accession_num = l_order_type+"!"+l_order_id+"!"+l_parent_srl_no+"!"+l_order_line_num+"!"+l_report_srl_no;
	ImageVideosMultiFileUploadBean fbean = (ImageVideosMultiFileUploadBean) getObjectFromBean("MULTIPLEFILEUPLOADBEAN", "eOR.ImageVideosMultiFileUploadBean", session);	
	fbean.clear();
	fbean.setSharedPath();
	if(l_called_from.equals("RECORD"))
		fbean.checkAndLoadBean(l_order_id, l_order_line_num,l_accession_num,l_discr_msr_panel_id);
	else
		fbean.checkAndLoadBean(l_acc_no,l_discr_msr_panel_id,"VIEW");
		
	fbean.loadUnlinkedVideoFiles();
	
	putObjectInBean("MULTIPLEFILEUPLOADBEAN",fbean,session);	
%>
<title><%if("RECORD".equals(l_called_from)){%><fmt:message key="eCA.FileUpload.label" bundle="${ca_labels}"/><%}else {%><fmt:message key="eCA.ViewDocuments.label" bundle="${ca_labels}"/><%}%></title>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eOR/js/ImageVideosFileUpload.js' ></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>	
	 <%if(l_called_from.equals("RECORD"))
	   {
	 %>
		<iframe name='ImageVideosFileUploadListFrame' id='ImageVideosFileUploadListFrame' src='../../eOR/jsp/ImageVideosFileUploadList.jsp' frameborder='0' scrolling='yes' noresize style='height:20vh;width:100vw'></iframe>
			<iframe name='ImageVideosFileUploadFrame' id='ImageVideosFileUploadFrame' src='../../eOR/jsp/ImageVideosFileUpload.jsp?<%=query_String%>' frameborder=0 scrolling=no noresize style='height:20vh;width:100vw'></iframe>			
			<iframe name='ImageVideosFileUploadToolbarFrame' id='ImageVideosFileUploadToolbarFrame' src='../../eOR/jsp/ImageVideosFileUploadToolbar.jsp?<%=query_String%>' frameborder=0 scrolling=no noresize style='height:5vh;width:100vw'></iframe>
			<iframe name='ImageVideosFileUploadDisplayFrame' id='ImageVideosFileUploadDisplayFrame' src='../../eCommon/html/blank.html' frameborder='0' scrolling='auto' noresize style='height:50vh;width:100vw'></iframe>
			<iframe name="messageframe" id="messageframe" src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 scrolling="auto" noresize style='height:5vh;width:100vw'></iframe>
		
	<%}else{

	%>
		<iframe name='ImageVideosFileUploadListFrame' id='ImageVideosFileUploadListFrame' src='../../eOR/jsp/ImageVideosFileUploadList.jsp?<%=query_String%>' frameborder='0' scrolling='auto' noresize style='height:30vh;width:100vw'></iframe>	
			<iframe name='ImageVideosFileUploadDisplayFrame' id='ImageVideosFileUploadDisplayFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize style='height:70vh;width:100vw'></iframe>			
		
	<%}%> 
</html>


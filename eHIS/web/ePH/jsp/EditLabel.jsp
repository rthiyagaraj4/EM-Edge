<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>                                
<head>                                
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="javascript" src="../js/PhCommon.js"></script>
 	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script LANGUAGE="javascript" SRC="../../ePH/js/EditDispLabel.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></title>
</head>    
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
	String params = request.getQueryString() ;

	String url1 = "../../ePH/jsp/EditLabelHeader.jsp?" ;
	String source1 = url1 + params;

	String url2 = "../../ePH/jsp/EditLabelDetails.jsp?" ;
	String source2 = url2 + params ;

	String bean_id = "EditDispLabelBean" ;//Added for Bru-HIMS-CRF-414 [IN045554] -start
	String bean_name = "ePH.EditDispLabelBean";
	EditDispLabelBean bean = (EditDispLabelBean)getBeanObject( bean_id, bean_name, request ) ;
	String allow_edit_disp_label = bean.getAllowEditDispLabel();  
	if(allow_edit_disp_label.equals("Y"))
		source2 = "../../eCommon/html/blank.html";//Added for Bru-HIMS-CRF-414 [IN045554] -end
%>
		<iframe name="f_patient_details" id="f_patient_details" frameborder="0" scrolling="no" noresize src="<%=source1%>" style="height:13vh;width:95vw"></iframe>
		<iframe name="f_drug_details" id="f_drug_details"  frameborder="1" noresize scrolling="no" src="<%=source2%>" style="height:87vh;width:95vw"></iframe>
</html>	


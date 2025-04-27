<!DOCTYPE html>

  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	  request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
   <script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
	String	bean_id		=	"DispMedicationBean" ;
	String	bean_name	=	"ePH.DispMedicationBean";
	DispMedicationBean bean	= (DispMedicationBean)getBeanObject( bean_id, bean_name, request);	
	//bean.setLanguageId(locale);
	Hashtable ht_ws_allocate_batches = bean.getHTWSAllocateBatches();
	String worksheet_id = bean.getWorksheetID();
	if(worksheet_id==null){
		worksheet_id = "";
	}
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="frmDispMedicationWSPreviewDetails" id="frmDispMedicationWSPreviewDetails">
	<table cellpadding="0" cellspacing="0" border="1" id="wspreviewdetails" align="center">
		<tr>
			<!-- <td class="white" width="3%" align='right' style='background-color:#CC99CC;' id="alt_color_id">&nbsp;&nbsp;</td>
			<td class="white" align="left" style="border:none;" id="alt_legend_id"><label class="label" style="font-size:9;"><b>&nbsp;Alternate Drugs</b></label></td> -->
			<%
				if((ht_ws_allocate_batches.size()>0)|| ! worksheet_id.equals("")){
			%>
			<td class="white">
				<input type="button" name="btnPreview" id="btnPreview" class="button" value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>' onClick="previewSelectedBatches()">&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
			<%
				}
			%>
		</tr>	
	</table>
</form>
</body>
</html>
<%
//putObjectInBean(bean_id,bean,request);
%>


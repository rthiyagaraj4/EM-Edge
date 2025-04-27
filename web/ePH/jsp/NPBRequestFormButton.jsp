<!DOCTYPE html>
<%-- Mandatory declarations start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, ePH.* ,ePH.Common.*,eCommon.Common.*" %>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eOR.Editor.label" bundle="${or_labels}"/></title>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/NPBRequest.js"></script>
		<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name ="editorButtonForm">
<%	
		try{
			String mode			= request.getParameter("mode")==null?"1":request.getParameter("mode");
			String request_no			= request.getParameter("request_no")==null?"":request.getParameter("request_no");
			String index			= request.getParameter("index")==null?"0":request.getParameter("index");
			String patient_id			= request.getParameter("patient_id");
			String encounter_id			= request.getParameter("encounter_id");
			String bean_id					= "@NPBRequestBean"+patient_id+encounter_id;
			String bean_name				= "ePH.NPBRequestBean";
			String facility_id			= (String)session.getValue("facility_id");
			NPBRequestBean bean			= (NPBRequestBean)getBeanObject( bean_id, bean_name ,request) ;
			bean.setLanguageId(localeName);
			String consentDetail = "";
			String NPBReqFormId		= request.getParameter("NPBReqFormId");
			if(mode.equals("2"))
				consentDetail		= bean.getNPBRequestFormText(request_no);
			else
				consentDetail		= bean.getConsentDetail(NPBReqFormId,facility_id, patient_id, encounter_id);
			if(consentDetail==null || consentDetail.equals("<ADDRESS>&nbsp;</ADDRESS>"))	
				consentDetail ="";
 %>
			<table border="0" cellpadding="3" cellspacing="0" width="100%" id='NPBEditor'>
				<tr>
					<td class="label"><jsp:include page="EditorButton.jsp" ><jsp:param name="flush" value="true" />
									  </jsp:include>
					</td>
					<td class="label">
					<a class="gridLink" href="#" onClick="zoomWindow()">
						<img id="zoom" src="../../eOR/images/Maximize.gif" title='Zoom In'></img>
					</a>
					</td>
				</tr>
				<tr>
					<td colspan="3" class='fields'><textarea rows="0" cols="25" name="RTEText" style="display:none;"><%=consentDetail%></textarea></td>
				</tr>
				<script>setTimeout("setZoomEditorTemplate()",200);</script>
				<input type="hidden" name ="bean_id" value="<%=bean_id%>">
				<input type="hidden" name ="bean_name" value="<%=bean_name%>">
				<input type="hidden" name ="patient_id" value="<%=patient_id%>">
				<input type="hidden" name ="encounter_id" value="<%=encounter_id%>">
				<input type="hidden" name ="NPBReqFormId" value="<%=NPBReqFormId%>">
				<input type="hidden" name ="request_no" value="<%=request_no%>">
				<input type="hidden" name ="mode" value="<%=mode%>">
				<input type="hidden" name ="index" value="<%=index%>">
 			</table>
 		</form>
<%
		putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
 %>
   </body>
</html>


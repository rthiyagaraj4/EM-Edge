<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, java.net.*,ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
	
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<!--<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhMessages.js"></SCRIPT>-->
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/ReissueMed.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		source = URLEncoder.encode(source);
		String facility_id = (String) session.getValue( "facility_id" );
		String function_id = request.getParameter("function_id");
		String identityForSwitch = request.getParameter("identityForSwitch");
		String homepage = request.getParameter("homepage")==null?"":request.getParameter("homepage"); //Added for Bru-HIMS-CRF-073 [IN:029939]
		String store_code = request.getParameter("store_code")==null?"":request.getParameter("store_code"); //Added for Bru-HIMS-CRF-073 [IN:029939]
		String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class"); //Added for Bru-HIMS-CRF-073.1 [IN:047222]
		String bean_id = "ReissueMedBean" ;
		String bean_name = "ePH.ReissueMedBean";
		ReissueMedBean bean = (ReissueMedBean)getBeanObject( bean_id,bean_name,request) ;
		bean.setLanguageId(localeName);
		if(identityForSwitch == null){
			bean.clear();
		}

		ArrayList result = bean.checkToProceed(facility_id.trim(),"Reissue Medication");
		if(result.size()>0) {
			if(((String)result.get(0)).equals("NO DISPLAY-1")) {
%>
				<SCRIPT>alert(getMessage("PH_USER_NOT_A_PHARMACIST","PH"));</SCRIPT>
<%
			}
			else if(((String)result.get(0)).equals("NO DISPLAY-3")) {
%>
				<SCRIPT>alert(getMessage("PH_WS_NO_NOT_MAPPED","PH"));</SCRIPT>
<%
			}
			if(((String)result.get(0)).indexOf("NO DISPLAY")> -1){ //Added for Bru-HIMS-CRF-073 [IN:029939]
				if(homepage.equals("Y")){
%>
					<SCRIPT>//window.close();</SCRIPT> <!-- commented for Bru-HIMS-CRF-073.1 [IN:047222] -->
<%
				}
				else{
%>
					<SCRIPT>window.location.href ='../../eCommon/jsp/dmenu.jsp'</SCRIPT>
<%
				}
			}
			else {
				String disp_locn_dtl=(String)result.get(0);
       			//	disp_locn_dtl=java.net.URLEncoder.encode(disp_locn_dtl,"UTF-8"); 
%>
				<!-- <script>showLoginWindow(('<%=disp_locn_dtl%>'),'<%=function_id%>','<%=source%>');</script> commented for 26057--> 
				<script>showLoginWindow('','<%=function_id%>','<%=source%>','<%=homepage%>','<%=store_code%>','<%=patient_class%>');</script> <!-- //Added homepage, store_code for Bru-HIMS-CRF-073 [IN:029939] -->
<%
			}
	}
	putObjectInBean(bean_id,bean,request);
%>
</HTML>


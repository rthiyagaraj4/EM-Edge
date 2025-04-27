<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DispMedication.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	//String source = url + params ;

	String facility_id = (String) session.getValue( "facility_id" );
	String function_id = request.getParameter("function_id");
	String identityForSwitch = request.getParameter("identityForSwitch");
	String homepage = request.getParameter("homepage")==null?"":request.getParameter("homepage"); //Added for Bru-HIMS-CRF-073 [IN:029939]
	String store_code = request.getParameter("store_code")==null?"":request.getParameter("store_code"); //Added for Bru-HIMS-CRF-073 [IN:029939]
	String disp_locn_catg = request.getParameter("patient_class")==null?"":request.getParameter("patient_class"); //Added for Bru-HIMS-CRF-073.1 [IN:047222]

	String bean_id = "DispMedicationBean" ;
	String bean_name = "ePH.DispMedicationBean";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	if(identityForSwitch == null ){
		bean.clear();
		bean.setSource("");
	}
	String source			= bean.getSource(); //Added for Bru-HIMS-CRF-073 [IN:029939]
	if(source==null || source.equals("")) //Added for Bru-HIMS-CRF-073 [IN:029939]
		source = url + params+"&homepage="+homepage ;
	bean.setSource(source);
	//bean.setLoginAtWsNo( bean.getProperties().getProperty( "client_ip_address" ) ) ;
	ArrayList result = bean.checkToProceed(facility_id.trim(),"VerifyPrescriptions");
	if(result.size()>0) {
		if(((String)result.get(0)).equals("NO DISPLAY-1")) {
%>
			<SCRIPT>alert(getMessage("PH_USER_NOT_A_PHARMACIST","PH"));window.location.href ='../../eCommon/jsp/dmenu.jsp'</SCRIPT>
<%
		}
		else if(((String)result.get(0)).equals("NO DISPLAY-2")) {
%>
			<SCRIPT>alert(getMessage("PH_OR_NOT_INSTALLED","PH"));window.location.href ='../../eCommon/jsp/dmenu.jsp'</SCRIPT>
<%
		}
		else if(((String)result.get(0)).equals("NO DISPLAY-3")) {
%>
			<SCRIPT>alert(getMessage("PH_WS_NO_NOT_MAPPED","PH"));window.location.href ='../../eCommon/jsp/dmenu.jsp'</SCRIPT>
<%
		}
		else if(((String)result.get(0)).equals("NO DISPLAY-4")) {
%>
			<SCRIPT>alert(getMessage("PH_REG_REQ_ACK_REQ_NO","PH"));window.location.href ='../../eCommon/jsp/dmenu.jsp'</SCRIPT>
<%
		}
		if(((String)result.get(0)).indexOf("NO DISPLAY")> -1){ //Added for Bru-HIMS-CRF-073 [IN:029939]
			if(homepage.equals("Y")){ 
%>
				<SCRIPT>window.close();</SCRIPT>
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
              disp_locn_dtl=java.net.URLEncoder.encode(disp_locn_dtl,"UTF-8");
%>
			<!-- <script>showLoginWindowForVerifyPres('<%=disp_locn_dtl%>','<%=function_id%>')</script> --> <!-- Commented for 25860 -->
			<script>showLoginWindowForVerifyPres('','<%=function_id%>','<%=homepage%>','<%=store_code%>','<%=disp_locn_catg%>')</script>
<%
		}
	}
	putObjectInBean(bean_id,bean,request);
%>
</HTML>


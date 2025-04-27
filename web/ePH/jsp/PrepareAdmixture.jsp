<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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

	String bean_id = "DispMedicationBean" ;
	String bean_name = "ePH.DispMedicationBean";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	String source			= bean.getSource(); //Added for Bru-HIMS-CRF-073 [IN:029939]
	if(source==null || source.equals("")) //Added for Bru-HIMS-CRF-073 [IN:029939]
		source = url + params+"&homepage="+homepage ;

	if(identityForSwitch == null ){
		bean.clear();
	}
	bean.setSource(source);
	//bean.setLoginAtWsNo( bean.getProperties().getProperty( "client_ip_address" ) ) ;
	ArrayList result = bean.checkToProceed(facility_id.trim(),"DispMedication");//SAME FOR BOTH DISP MEDICATIONA AND PREPARE ADMIXTURE

	if(result.size()>0) {
		if(((String)result.get(0)).equals("NO DISPLAY-1")) {
%>
			<SCRIPT>
			alert(getMessage("PH_USER_NOT_A_PHARMACIST","PH"));
			</SCRIPT>
<%
		}
		else if(((String)result.get(0)).equals("NO DISPLAY-2")) {
%>
			<SCRIPT>alert(getMessage("PH_OR_NOT_INSTALLED","PH"));</SCRIPT>
<%
		}
		else if(((String)result.get(0)).equals("NO DISPLAY-3")) {
%>
			<SCRIPT>alert(getMessage("PH_WS_NO_NOT_MAPPED","PH"));</SCRIPT>
<%
		}
		else if(((String)result.get(0)).equals("NO DISPLAY-4")) {
%>
			<SCRIPT>alert(getMessage("PH_REG_REQ_ACK_REQ_NO","PH"));</SCRIPT>
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
%>
			<script>showLoginWindowForPrepareAdmixture('<%=result.get(0)%>','<%=function_id%>','<%=homepage%>','<%=store_code%>')</script> <!--//Added homepage,store_code  for Bru-HIMS-CRF-073 [IN:029939] -->
<%
		}
	}
	putObjectInBean(bean_id,bean,request); 
%>
</HTML>


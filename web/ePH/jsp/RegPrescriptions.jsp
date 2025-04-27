<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="JavaScript" src="../../ePH/js/RegPrescriptions.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String homepage = request.getParameter("homepage")==null?"":request.getParameter("homepage") ; //Added for Bru-HIMS-CRF-073.1 [IN:047222]
	String scope = request.getParameter("scope")==null?"":request.getParameter("scope") ;//Added for Bru-HIMS-CRF-073.1 [IN:047222]
	String store_code = request.getParameter("store_code")==null?"":request.getParameter("store_code"); //Added for Bru-HIMS-CRF-073 [IN:029939]

	String facility_id=(String) session.getValue( "facility_id" );
	String bean_id = "RegPrescriptionsBean" ;
	String bean_name = "ePH.RegPrescriptionsBean";
	RegPrescriptionsBean bean = (RegPrescriptionsBean)getBeanObject( bean_id,bean_name,request) ;
	bean.clear();
	bean.setLanguageId(locale);
	bean.setAutoCallReRoute();
//	bean.setLoginAtWsNo( bean.getProperties().getProperty( "client_ip_address" ) ) ;
/*
	The method  checkForTheDisplay will accept facility_id as input parameter.
	The method checkForTheDisplay will be used to check the following conditions
		1.		Whether the logged-in User is a Pharmacist or not. If not,It will return 'NO DISPLAY-1'
		2.		Whether the OR Module is installed or not. If not,It will return 'NO DISPLAY-2'
		3.		Whether the logged-in workstation no. maps with the ws_no in ph_ws_no_for_disp_locn or  
				not.If not,It will return 'NO DISPLAY-3' 
		4 & 5.	check for disp_regn_reqd_yn='Y/N' in PH_DISP_LOCN TABLE and ACK_YN='Y' in PH_DISP_RIGHTS 		TABLE for the generated disp_locn_code's (NO DISPLAY-4,NO DISPLAY-5)
***	
	Once it satiesfies all the above conditions that dispense location will be saved in the bean to display it in the query criteria.
*/
	ArrayList result = bean.checkForTheDisplay(facility_id.trim());
	if(result.size()>0){
		if(((String)result.get(0)).equals("NO DISPLAY-1")){
	%>
	
			<script>alert(getMessage("PH_USER_NOT_A_PHARMACIST","PH"));window.location.href ='../../eCommon/jsp/dmenu.jsp'</script>
	<%
		}
		else if(((String)result.get(0)).equals("NO DISPLAY-2")){
	%>
			<script>alert(getMessage("PH_OR_NOT_INSTALLED","PH"));window.location.href ='../../eCommon/jsp/dmenu.jsp'</script>
	<%
		}
		else if(((String)result.get(0)).equals("NO DISPLAY-3")){
	%>
			<script>alert(getMessage("PH_WS_NO_NOT_MAPPED","PH"));window.location.href ='../../eCommon/jsp/dmenu.jsp'</script>
	<%
		}
		else if(((String)result.get(0)).equals("NO DISPLAY-4")){
	%>
			<script>alert(getMessage("PH_REG_REQ_NO","PH"));window.location.href ='../../eCommon/jsp/dmenu.jsp'</script>
	<%
		}
		else if(((String)result.get(0)).equals("NO DISPLAY-5")){
	%>
			<script>alert(getMessage("PH_ACK_REQ_NO","PH"));window.location.href ='../../eCommon/jsp/dmenu.jsp'</script>
	<%
		}
		else{	
%>
			<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/RegPrescriptionsFrames.jsp?scope=<%=scope%>&homepage=<%=homepage%>&store_code=<%=store_code%>" style="height:83vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:9vh;width:100vw"></iframe>
<%
		}
	}
%>
<% putObjectInBean(bean_id,bean,request); %>

</html>


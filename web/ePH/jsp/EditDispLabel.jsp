<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
        request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		 <SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/EditDispLabel.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</HEAD>

<%
	String url				= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params			= request.getQueryString() ;
	String source			= url + params ;
	String facility_id		= (String) session.getValue( "facility_id" );
	//String function_id		= request.getParameter("function_id");
	String bean_id			= "EditDispLabelBean" ;
	String bean_name		= "ePH.EditDispLabelBean";
	EditDispLabelBean bean = (EditDispLabelBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	//bean.setSFunctionId(function_id);	
	ArrayList result = bean.checkToProceed(facility_id.trim());
	String homepage = request.getParameter("homepage")==null?"":request.getParameter("homepage"); //Added for Bru-HIMS-CRF-073 [IN:029939]
	String store_code = request.getParameter("store_code")==null?"":request.getParameter("store_code"); //Added for Bru-HIMS-CRF-073 [IN:029939]
	if(!homepage.equals("Y")) //if condition added for Bru-HIMS-CRF-073.1 [IN:047222]
		bean.setSource(source);
	
	if(result.size()>0) {
		if(((String)result.get(0)).equals("NO DISPLAY-1")){
%>
			<SCRIPT>alert(getMessage("PH_USER_NOT_A_PHARMACIST","PH"));</SCRIPT>
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
		else if(((String)result.get(0)).equals("NO DISPLAY-4")){
%>
			<SCRIPT>alert(getMessage("EDIT_LABEL_NOT_ALLOWED","PH"));</SCRIPT>
<%
		}
		if(((String)result.get(0)).indexOf("NO DISPLAY")> -1){//Added for Bru-HIMS-CRF-073 [IN:029939]
			if(homepage.equals("Y")){ 
%>
				<SCRIPT>//window.close();</SCRIPT> <!-- commented for  Bru-HIMS-CRF-073.1 [IN:047222] -->
<%
			}
			else{
%>
				<SCRIPT>window.location.href ='../../eCommon/jsp/dmenu.jsp'</SCRIPT>
<%
			}
		}
		else{
%>  
			<script>showLoginWindow('<%=homepage%>','<%=store_code%>')</script> 
<%
		}
	}
	putObjectInBean(bean_id,bean,request);
%>
</HTML>


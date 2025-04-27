<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/ReturnMedication.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String origpwd=request.getParameter("password");
	String patclass=request.getParameter("patclass");

	String source = url + params ;

%>
	<iframe name="commontoolbarFrame" id="commontoolbarFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%= source %>" style="height:6vh;width:100vw"></iframe>
	<iframe name="f_query_add_mod" id="f_query_add_mod" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:89vh;width:100vw"></iframe>
	<iframe name="messageFrame" id="messageFrame" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/jsp/error.jsp" style="height:5vh;width:100vw"></iframe>
<%
	java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
	String bean_id = "ReturnMedicationBean"+login_at_ws_no ;
	String bean_name = "ePH.ReturnMedicationBean";
	ReturnMedicationBean bean = (ReturnMedicationBean)getBeanObject( bean_id,bean_name,request) ; //added for Bru-HIMS-CRF-073.1 [IN:047222]
	String homepage = request.getParameter("homepage")==null?"":request.getParameter("homepage"); //Added for Bru-HIMS-CRF-073 [IN:029939]
	String store_code = request.getParameter("store_code")==null?"":request.getParameter("store_code"); //Added for Bru-HIMS-CRF-073 [IN:029939]
	String disp_locn_catg = request.getParameter("pat_class")==null?"":request.getParameter("pat_class"); //Added for Bru-HIMS-CRF-073.1 [IN:047222]
	String password="", userName="", userId="";
	if(homepage.equals("Y")){
		ArrayList userDetails=bean.getUserDetails();
		if (userDetails.size()>0){
			userName=java.net.URLEncoder.encode((String)userDetails.get(0),"UTF-8");
			password=java.net.URLEncoder.encode((String)userDetails.get(1),"UTF-8");
			userId=(String)userDetails.get(2);
		}
	} //added for Bru-HIMS-CRF-073.1 [IN:047222] -end

	if (bean.checkPharmacist()=="N"){
%>
		<script>alert(getMessage("PH_USER_NOT_A_PHARMACIST","PH"));window.location.href ='../../eCommon/jsp/dmenu.jsp'</script>
<%
	}
	else if (bean.checkPharmacist()=="Y"){
	//check if OR is installed or not
		if (bean.checkOR()=="N"){
%>
			<script>alert(getMessage("PH_OR_NOT_INSTALLED","PH"));window.location.href ='../../eCommon/jsp/dmenu.jsp'</script>
<%
		}
		else if (bean.checkOR()=="Y"){
			if (bean.checkRights()=="N"){
%>
				<script>alert(getMessage("PH_RET_MED_RIGHTS","PH"));window.location.href ='../../eCommon/jsp/dmenu.jsp'</script>
<%
			}
			else{
				if (origpwd==null ){
					out.println("<script>showLoginWindow('','','"+password+"','"+disp_locn_catg+"','"+homepage+"','"+store_code+"','"+userName+"','"+userId+"');</script>");
				}
				else{
					out.println("<script>showLoginWindow('','','"+origpwd+"','"+patclass+"','"+homepage+"','"+store_code+"');</script>");
				}
			}
		}
	}
	putObjectInBean(bean_id,bean,request); 
 %>
</HTML>


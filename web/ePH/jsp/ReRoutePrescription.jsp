<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>                                
	<head>                                
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../ePH/js/ReRoutePrescription.js"></script>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<title> <fmt:message key="ePH.ReroutePrescription.label" bundle="${ph_labels}"/></title>
	</head>                               
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String re_route_via_reg_ord = request.getParameter("re_route_via_reg_ord")==null?"N":request.getParameter("re_route_via_reg_ord");  // added  for Bru-HIMS-CRF-090 [IN:029956]
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");  // added  for Bru-HIMS-CRF-090 [IN:029956]
		String disp_locn_code = request.getParameter("disp_locn_code")==null?"":request.getParameter("disp_locn_code");  // added  for Bru-HIMS-CRF-090 [IN:029956]
		//the below if condition newly added for 33798
		if(re_route_via_reg_ord.equals("Y")){
			String doc_title= com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ReroutePrescription.label", "ph_labels");
%>		
		<script>
			window.document.title='<%=doc_title%>'
		</script>

<%		}
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;

		if(re_route_via_reg_ord.equals("N")){ //if condition is  added  for Bru-HIMS-CRF-090 [IN:029956]
%>	
			<!-- <frameset rows="8%,15%,60%,9%"> -->
				<iframe name="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:9vh;width:100vw"></iframe>
<%
		}
		else{
%>
			<!-- <frameset rows="15%,80%,9%"> -->
<%
		}
%>
		<iframe name="f_query_criteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/ReRoutePrescriptionsCireria.jsp?re_route_via_reg_ord=<%=re_route_via_reg_ord%>&patient_id=<%=patient_id%>&disp_locn_code=<%=disp_locn_code%>" style="height:14vh;width:100vw"></iframe> <!--re_route_via_reg_ord  added  for Bru-HIMS-CRF-090 [IN:029956]-->
		<iframe name="f_query_result" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:64vh;width:100vw"></iframe>
		<iframe name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:10vh;width:100vw"></iframe>
	<!-- </frameset> -->
</html>

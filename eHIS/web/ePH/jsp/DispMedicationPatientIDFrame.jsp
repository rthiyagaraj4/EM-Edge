<!DOCTYPE html>

  
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
		String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String params = request.getQueryString() ;

%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link> 

	<script language="JavaScript" src="../js/PhCommon.js"></script>
	 <script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

//	String bean_id = "DispMedicationBean" ;
//	String bean_name = "ePH.DispMedicationBean";
//	DispMedicationBean bean = (DispMedicationBean)mh.getBeanObject( bean_id, request, bean_name ) ;
	//ArrayList result = bean.getAllThePatientsBasedOnCriteria();
//	String disp_locn_catg = bean.getDispLocnCatg();
	String strRows= "22,5.5%,*";
//	out.println("to displeay the contents of the patient ==========");

/*	if(disp_locn_catg.equals("O")){
		if(result.size()>8){
			strRows = "25,*";
		}else{
			strRows = "0,*";
		}
	}
	if(disp_locn_catg.equals("I")){
		if(result.size()>9){
			strRows = "25,*";
		}else{
			strRows = "0,*";
		}
	}*/
%>

	<iframe name="patient_id_locator" id="patient_id_locator" frameborder="0" scrolling="no" noresize  src="../../ePH/jsp/DispMedicationPatientIDLocator.jsp?<%=params%>"style="height:6vh;width:100vw"></iframe>
	<iframe name="patient_id_pagination" id="patient_id_pagination" src="../../ePH/jsp/DispMedicationSearchToolbar.jsp" noresize  frameborder="no" marginheight="0" marginwidth="0"style="height:0vh;width:100vw"></iframe> <!-- Added for MMS-DM-CRF-0228 -->
	<iframe name="patient_id_display" id="patient_id_display" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationPatientIDDisplay.jsp?<%=params%>"style="height:75vh;width:100vw">	</iframe>
<!-- 	<iframe name="patient_id_color_indicator" id="patient_id_color_indicator" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DispMedicationPatientIDColorIndicator.jsp" ></iframe>	 -->

</html>


<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
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
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  topmargin="0">
<%
		String	bean_id			=	"QueryPatientDrugProfileBean" ;
		String	bean_name		=	"ePH.QueryPatientDrugProfileBean";
		String patient_id = request.getParameter("patient_id");

		QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id,bean_name, request) ;
		bean.setLanguageId(locale);
		ArrayList patientdetails = bean.getPatientDetails(patient_id);
		String patient_name = (String)patientdetails.get(0);
		String age				  = (String)patientdetails.get(1);
		String sex			   	  = (String)patientdetails.get(2);
		//added for [IN:036157] -start
		String deceased_yn = (String)patientdetails.get(3);
		String deceased_facility = (String)patientdetails.get(4);
		String deceased_enc_id = (String)patientdetails.get(5);
		String deceased_date = (String)patientdetails.get(6);
		String deceased_dtl=": ";
		if(!deceased_facility.equals(""))
			deceased_dtl += deceased_facility+" ,";
		if(!deceased_enc_id.equals(""))
			deceased_dtl += deceased_enc_id+" ,";
		if(!deceased_date.equals(""))
			deceased_dtl += deceased_date;
		//added for [IN:036157] -end
		if(sex.equalsIgnoreCase("female"))
			sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		else if(sex.equalsIgnoreCase("male"))
			sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		else if(sex.equalsIgnoreCase("unknown"))
			sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
%>
		<form name="frmPatientDetails" id="frmPatientDetails" >
			<table cellpadding="0" cellspacing="0" width="100%" align="left" border="0" id="patient_details" > 
				<tr>
					<th class="commontoolbarfunction"  >&nbsp;<%=patient_name%>&nbsp;,&nbsp;<%=sex%>&nbsp;,&nbsp;<%=age%>,&nbsp;<%=patient_id%>
<%
						//added for [IN:036157] -start
						if(deceased_yn.equals("Y")){
%>
							<img src='../../ePH/images/stop.gif'  height='15'  width='15' title='<fmt:message key="Common.deceased.label" bundle="${common_labels}"/> <%=deceased_dtl%>'>
<%
						}
						//added for [IN:036157] -End
%>
					</th>	
				</tr>
			</table>
		</form>
	</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>


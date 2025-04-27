<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,java.util.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String P_constr = request.getParameter("constr");
		String P_access_type="";
		String P_access_data="" ;
		String P_patient_type="" ;
		StringBuffer L_access_detail = new StringBuffer();
		StringTokenizer st = new StringTokenizer(P_constr,"/");

		while(st.hasMoreTokens())
		{
			P_access_type=st.nextToken();
			P_access_data=st.nextToken();
			P_patient_type=st.nextToken();				
		}
		L_access_detail = new StringBuffer();
		L_access_detail.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels"));
		L_access_detail.append(" - ");

		if (P_access_type.equals("V"))
		{			
			L_access_detail.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels"));
		}
		else
		{
			L_access_detail.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Enter/Edit.label","common_labels"));
		}

			if (P_access_data.equals("HR")){
			L_access_detail.append(" ");
			L_access_detail.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HighRisk.label","common_labels"));
		}
		else{
			L_access_detail.append(" ");
			L_access_detail.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SensitiveDiagnosis.label","common_labels"));
		}

		if (P_patient_type.equals("C")){
			L_access_detail.append(" ");
			L_access_detail.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ConsultingPatient.label","common_labels"));				
		}
	
	%>
		<title><%=L_access_detail.toString()%></title>
		<iframe src='AuthorizeMRAccess.jsp?<%=request.getQueryString()%>'></iframe>
	</head>
</html>


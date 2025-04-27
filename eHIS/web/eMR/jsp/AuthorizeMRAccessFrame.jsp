<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*" %>

<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String P_constr = request.getParameter("constr");
		String P_access_type="";
		String P_access_data="" ;
		String P_patient_type="" ;
		StringBuffer L_access_detail = new StringBuffer("");
		StringTokenizer st = new StringTokenizer(P_constr,"/");
		while(st.hasMoreTokens())
		{
				
				P_access_type=st.nextToken();
				P_access_data=st.nextToken();
				P_patient_type=st.nextToken();				
		}	

		
		if (P_access_type.equals("V")){
			L_access_detail.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels"));
			}
		else{
			L_access_detail.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Enter/Edit.label","common_labels"));
		}

			if (P_access_data.equals("HR")){
			L_access_detail.append(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HighRisk.label","common_labels")+" ") ;
		}
		else{
			L_access_detail.append(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SensitiveDiagnosis.label","common_labels")+" ") ;
		}

		if (P_patient_type.equals("C")){
				L_access_detail.append(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ConsultingPatient.label","common_labels")) ;
		}
		
	%>
		<!--<title>Password Authorization</title>-->
		<title><%=L_access_detail.toString()%></title>
		<iframe src='../../eMR/jsp/AuthorizeMRAccess.jsp?<%=request.getQueryString()%>'></iframe>
	</head>
</html>


<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title>
<fmt:message key="Common.AllergyDetails.label" bundle="${common_labels}"/>
</title>
<head>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../js/PatAllergy.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String rows = "";
			String P_patient_id = request.getParameter("patient_id");
			String modalYN = request.getParameter("modal_yn") == null ? "N" : request.getParameter("modal_yn");
			String P_encounter_id = request.getParameter("episode_id");
			String P_clinic_code = request.getParameter("location_code");			
			String query_string = request.getQueryString() == null? "" :request.getQueryString();
			query_string = query_string + "&Encounter_Id="+P_encounter_id +"&Clinic_Code=" +P_clinic_code +"&Patient_Id="+P_patient_id+"&modalYN="+modalYN;

			if(modalYN.equals("Y"))
				rows = "0%,33%,60%,7%,10%";
			else
				rows = "0%,40%,42%,10%";

	%>
		<frameset name="f1" rows='<%=rows%>'  framespacing=0 border=0>
				<frame name='title' id='title'  marginwidth=0 marginheight=0  frameborder=no src='' noresize></frame>
				<frame name ='query' marginwidth=0 marginheight=0 frameborder=no  noresize src='PaintPatAllegyResult.jsp?<%=query_string%>'  ></frame>
				<frame name ='add_modify' marginwidth=0 marginheight=0 frameborder=no noresize src='addModifyPatAllegy.jsp?<%=query_string%>' ></frame>
				<frame name ='tools'  marginwidth=0 marginheight=0 frameborder=no noresize  src='PatAllergyQueryTools.jsp?<%=query_string%>'  ></frame>
			<%
				if(modalYN.equals("Y"))
				{
			%>
				<frame name='messageFrame' id='messageFrame'  marginwidth=0 marginheight=0  frameborder=no src='../../eCommon/jsp/error.jsp' noresize  ></frame>
			<%
				}
			%>
		</frameset>

</html>


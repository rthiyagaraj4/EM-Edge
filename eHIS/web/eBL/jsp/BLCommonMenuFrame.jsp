<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%!
private String checkForNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}
%>
<%
String FacilityId = (String)session.getAttribute("facility_id");
String userId = (String) session.getValue("login_user");
String functionId= checkForNull(request.getParameter("functionId"));
functionId = "RS_LEAVE_DET";
String blng_grp_id= checkForNull(request.getParameter("blngGrpId"));
blng_grp_id = "CASH";
String payerGroup= checkForNull(request.getParameter("payerGroup"));
String payer= checkForNull(request.getParameter("payer"));
String episode_type= checkForNull(request.getParameter("episodeType"));
episode_type = "O";
String patient_id = checkForNull(request.getParameter("patientId"));


%>
<script>
function refresh(){
	parent.refresh();
}

function closeWindow(){
	parent.closeWindow();
}
</script>
</head>
	
	<%if("".equals(patient_id)){ %>
	<iframe name='BillingBanner' id='BillingBanner'	src='../../eBL/jsp/InvokeBanner.jsp?episodetype=<%=episode_type %>&custgroupcode=<%=payerGroup %>&custcode=<%=payer %>&userid=<%=userId %>&functionid=<%=functionId %>&blnggrpid=<%=blng_grp_id %>'  frameborder=0  noresize style='height:50vh;width:100vw'></iframe> 				
		<iframe name='BillingMenu' id='BillingMenu' 	frameborder='0'	src="../../eBL/jsp/BLToolbarDisplay.jsp?userid=<%=userId %>&functionid=<%=functionId %>"  scrolling='no' noresize style='height:50vh;width:100vw'></iframe>
	
	<%}else{ %>
	<iframe name='pline' id='pline' 		frameborder='0'	src="../../eCommon/jsp/pline.jsp?Patient_Id=<%=patient_id%>"  scrolling='no' noresize style='height:30vh;width:100vw'></iframe>
		<iframe name='BillingBanner' id='BillingBanner'	src='../../eBL/jsp/InvokeBanner.jsp?episodetype=<%=episode_type %>&custgroupcode=<%=payerGroup %>&custcode=<%=payer %>&userid=<%=userId %>&functionid=<%=functionId %>&blnggrpid=<%=blng_grp_id %>'  frameborder=0  noresize style='height:50vh;width:100vw'></iframe> 				
		<iframe name='BillingMenu' id='BillingMenu' 	frameborder='0'	src="../../eBL/jsp/BLToolbarDisplay.jsp?userid=<%=userId %>&functionid=<%=functionId %>"  scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
	
	<%} %>
		
</html>


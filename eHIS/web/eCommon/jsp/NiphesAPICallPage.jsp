<!DOCTYPE html>
<html>
<head> 
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/jquery.js'></script>  
</head>
<% 
String p_facility_id = request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
String p_patient_id = request.getParameter("p_patient_id") == null ? "" : request.getParameter("p_patient_id");
String p_physician_id = request.getParameter("p_physician_id") == null ? "" : request.getParameter("p_physician_id");
String p_url = request.getParameter("p_url") == null ? "https://nphiesr2.mouwasat.com:8999/api/sSo" : request.getParameter("p_url");
String p_dob = request.getParameter("p_dob") == null ? "" : request.getParameter("p_dob"); 
%>
<body onload = "parent.window.close();document.NphiesApi.submit();">
<form name='NphiesApi' id='NphiesApi' action="<%=p_url%>" method="post" target="_blank"
enctype="application/x-www-form-urlencoded" > 
<input type="hidden" name="FacilityId" id="FacilityId" value="<%=p_facility_id%>">
<input type="hidden" name="PatientId" id="PatientId" value="<%=p_patient_id%>">
<input type="hidden" name="PatientDob" id="PatientDob" value="<%=p_dob%>">
<input type="hidden" name="PractitionerId" id="PractitionerId" value="<%=p_physician_id%>">
<input type="hidden" name="p_url" id="p_url" value="<%=p_url%>">
</form>
<script>
</script>
</body>
</html>



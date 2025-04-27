<!DOCTYPE html>
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
<%  //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
    //Added Against MMS Vulnerability Issue - Ends
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? "IeStyle.css" : (String) session.getAttribute("PREFERRED_STYLE");
	//Added Against ML-ML-MMOH-CRF-1123-US3 Starts Here 
	//String alaCarte = (String) request.getParameter("alaCarte");
	//Added Against ML-ML-MMOH-CRF-1123-US3 Ends Here
%>
<script type="text/javascript" src="../../eDS/js/PlaceDietOrderPHIS.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>	<!--MMS-KH-CRF-0029.1-->
<title><fmt:message key="eOT.placeDietOrder.Label" bundle="${ot_labels}" /></title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<script>
	var jsonObj=window.dialogArguments;
	var patientsObj;
	var totalAge=0;
	var averageAge=0;
	var gender="";

	for(i=0;i<jsonObj.patients.length;i++) {
		obj=jsonObj.patients[i].patient;
		totalAge=parseInt(totalAge)+parseInt(obj.age);
		if(gender==null || gender=="") {
			gender="'"+obj.gender+"'";
		}
		else gender=gender+",'"+obj.gender+"'";
	}
	averageAge=parseInt(totalAge)/parseInt(jsonObj.patients.length);	
</script>
</head>
	<input type="hidden" name="MealItemsArray" id="MealItemsArray" value='' />
	<iframe name="test" id="test" id="test" src="../../eDS/jsp/placedietOrderSubmit.jsp?locationCode=<%=request.getParameter("locationCode")%> scrolling="no" frameborder="0" noresize="noresize"/ style="height:3vh;width:100vw"></iframe>
	<iframe name="mealMenu"  id="mealMenu" src="../../eDS/jsp/PlaceBulkDietOrderCUD.jsp?locationCode=<%=request.getParameter("locationCode")%>&patientIds=<%=request.getParameter("patientIds")%>&encounterIds=<%=request.getParameter("encounterIds")%>&Facility_Id=<%=(String)session.getValue("facility_id")%>&patientClass_bulk=<%=request.getParameter("patientClass_bulk")%>&alaCarte=<%=request.getParameter("alaCarte")%>" scrolling="no" noresize="noresize"/  style="height:90vh;width:100vw"></iframe>
	<!--ML-MMOH-CRF-0820 and Modified Against ML-MMOH-CRF-1123-US4 -->
	<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/MstCodeError.jsp" scrolling="no"/ style="height:7vh;width:100vw"></iframe>
</html>


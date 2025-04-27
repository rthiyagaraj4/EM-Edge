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
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
				.getAttribute("PREFERRED_STYLE") != "")) ? "IeStyle.css"
				: (String) session.getAttribute("PREFERRED_STYLE");
		//Added Against ML-ML-MMOH-CRF-1123-US3 Starts Here 
		//String alaCarte = (String) request.getParameter("alaCarte");
		//Added Against ML-ML-MMOH-CRF-1123-US3 Ends Here
		String encounterId = request.getParameter("encounterId");
	%>
	<title><fmt:message key="eOT.placeDietOrder.Label" bundle="${ot_labels}" /></title>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

</head>
	<input type="hidden" name="dateOfBirth" id="dateOfBirth" value='<%=request.getParameter("dateOfBirth")%>' />
	<input type="hidden" name="gender" id="gender" value='<%=request.getParameter("gender")%>' />
	<input type="hidden" name="MealItemsArray" id="MealItemsArray" value='' />
	<iframe name="test" id="test" src="../../eDS/jsp/placedietOrderSubmit.jsp?room=<%=request.getParameter("room")%>&bed=<%=request.getParameter("bed")%>&locationCode=<%=request.getParameter("locationCode")%>" scrolling="no" frameborder="0" noresize="noresize"/ style="height:3vh;width:99vw"></iframe>
	<iframe name="patientInfo" id="patientInfo" noresize="noresize" src="../../eCommon/jsp/pline.jsp?Patient_ID=<%=request.getParameter("patientId")%>&EncounterId=<%=request.getParameter("encounterId")%>&Facility_Id=<%=(String)session.getValue("facility_id")%>" frameborder="no" framespacing="0" frameborder="no" framespacing="0" scrolling="no" / style="height:7vh;width:99vw"></iframe>
	<iframe name="mealMenu" id="mealMenu"  src="../../eDS/jsp/PlaceDietOrderCUD.jsp?locationCode=<%=request.getParameter("locationCode")%>&Patient_ID=<%=request.getParameter("patientId")%>&encounterId=<%=encounterId%>&Facility_Id=<%=(String)session.getValue("facility_id")%>&patientClass=<%=request.getParameter("patientClass")%>&locationType=<%=request.getParameter("locationType")%>&flag=<%=request.getParameter("flag")%>&diffDays=<%=request.getParameter("diffDays")%>&isLos_gt7=<%=request.getParameter("isLos_gt7")%>&bed=<%=request.getParameter("bed")%>&alaCarte=<%=request.getParameter("alaCarte")%>" scrolling="yes" noresize="noresize"/ style="height:78vh;width:99vw"></iframe>
	<!--Modified Against ML-MMOH-CRF-0672 & (bed Added Against673) and ML-MMOH-CRF-1123 US3-->
	<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/MstCodeError.jsp" scrolling="no"/ style="height:7vh;width:99vw"></iframe>
</html>


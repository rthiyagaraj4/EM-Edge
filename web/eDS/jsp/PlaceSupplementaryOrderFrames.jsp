<!DOCTYPE html>
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
	<%
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? "IeStyle.css": (String) session.getAttribute("PREFERRED_STYLE");
	%>

	<title><fmt:message key="eDS.PlaceSupplementaryOrder.Label" bundle="${ds_labels}" /></title>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<%  
	    //Added Against MMS Vulnerability Issue - Starts
        request= new XSSRequestWrapper(request);
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Content-Type-Options", "nosniff");
	    //Added Against MMS Vulnerability Issue - Ends 
		String patientId=request.getParameter("patientId");
		String encounterId=request.getParameter("encounterId");
		String locationCode=request.getParameter("locationCode");
		String patientClass=request.getParameter("patientClass");
		String room=request.getParameter("room");
		String bed=request.getParameter("bed");
		String locationType=request.getParameter("locationType");
		String dateOfBirth=request.getParameter("dateOfBirth");
		String gender=request.getParameter("gender");
		System.err.println("PlaceSupplementaryOrderFrames.jsp");
		System.err.println("patientId"+patientId);
		System.err.println("encounterId"+encounterId);
		System.err.println("locationCode"+locationCode);
		System.err.println("patientClass"+patientClass);
		System.err.println("room"+room);
		System.err.println("bed"+bed);
		System.err.println("locationType"+locationType);
		System.err.println("dateOfBirth"+dateOfBirth);
		System.err.println("gender"+gender);
	%>
</head>
	<input type="hidden" name="dateOfBirth" id="dateOfBirth" value='<%=request.getParameter("dateOfBirth")%>' />
	<input type="hidden" name="gender" id="gender" value='<%=request.getParameter("gender")%>' />
	<input type="hidden" name="MealItemsArray" id="MealItemsArray" value='' />
	<iframe name="test"  id="test" src="../../eDS/jsp/PlaceSupplementaryOrderSubmit.jsp?room=<%=request.getParameter("room")%>&bed=<%=request.getParameter("bed")%>&locationCode=<%=request.getParameter("locationCode")%>" scrolling="no" frameborder="0" noresize="noresize"/ style="height:3vh;width:99vw"></iframe>
	<iframe name="patientInfo" id="patientInfo"  noresize="noresize" src="../../eCommon/jsp/pline.jsp?Patient_ID=<%=request.getParameter("patientId")%>&EncounterId=<%=request.getParameter("encounterId")%>&Facility_Id=<%=(String)session.getValue("facility_id")%>" frameborder="no" framespacing="0" frameborder="no" framespacing="0" scrolling="no" / style="height:6vh;width:99vw"></iframe>
	<iframe name ="placesupplementaryorder" id = "placesupplementaryorder" src="../../eDS/jsp/PlaceSupplementaryOrder.jsp?patientId=<%=patientId%>&encounterId=<%=encounterId%>&locationCode=<%=locationCode%>&patientClass=<%=patientClass%>&room=<%=room%>&bed=<%=bed%>&locationType=<%=locationType%>&dateOfBirth=<%=dateOfBirth%>&gender=<%=gender%>" frameborder="no" scrolling="no"/ style="height:79vh;width:99vw"></iframe>
	<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/MstCodeError.jsp" scrolling="no"/ style="height:7vh;width:99vw"></iframe>
</html>



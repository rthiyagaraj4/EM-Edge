<!DOCTYPE html>
<html>
<head>
<% 
	String title_desc	=	"Discontinue/Cancel Medication";
%>
<title><%=title_desc%></title>
</head>
<%
 String params = request.getQueryString() ;
 String disc_cancel_yn = request.getParameter("disc_cancel_flag");

%>
<iframe name="f_active_order_details" id="f_active_order_details" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/PrescriptionDiscCancelOrderDetails.jsp?<%=params%>" style="height:90vh;width:100vw"></iframe>
<iframe name="f_close_frame" id="f_close_frame" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionClose.jsp?called_from=diagnosis&disc_yn=Y&disc_cancel_flag="<%=disc_cancel_yn%> style="height:90vh;width:100vw"><!-- disc_yn added for Mo-CRF-20159-- style="height:10vh;width:100vw"></iframe>
</html>


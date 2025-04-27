<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<% request.setCharacterEncoding("UTF-8");%>
<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.Common.CommonBean" %>
<% 	
	//Connection connection  = null;
	//PreparedStatement pstmt=null;
	//ResultSet resultset =null;
	String booknum		= CommonBean.checkForNull(request.getParameter("booknum"));
	String surg	= CommonBean.checkForNull(request.getParameter("surg"));
	String spec	= CommonBean.checkForNull(request.getParameter("spec"));
	//String booking_no	= CommonBean.checkForNull(request.getParameter("booking_no"));	
%>
<title><fmt:message key="eOT.StatusDetails.Label" bundle="${ot_labels}"/></title>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<body>
<%
	String	classvalue="OTCLASS";
%>
<table border='0' cellpadding=3  cellspacing='0' align='center'  width='100%' border='1' >
<tr><td align='left' class='label'></td></tr>
<tr><td align='left' class='label'></td></tr>
<tr>
	<td align='left' ></td><td class="Label" align='center'width='10%'  nowrap style="font-size:10pt;font-weight:normal;" ><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></td><td class="<%=classvalue%>"><%=booknum%></td>
	</tr>
	<tr>
	<td align='left' ></td><td class="Label" align='center'width='10%'  nowrap style="font-size:10pt;font-weight:normal;" ><fmt:message key="Common.BookingDate.label" bundle="${common_labels}"/></td><td class="<%=classvalue%>"><%=surg%></td>
	</tr>
	<tr>
	<td align='left' ></td><td class="Label" align='center'width='10%'  nowrap style="font-size:10pt;font-weight:normal;" ><fmt:message key="eOT.BookingStartTime.Label" bundle="${common_labels}"/></td><td class="<%=classvalue%>" ><%=spec%></td>
	
</tr>
<tr><td align='left' class='label'></td></tr>
<tr><td align='left' class='label'></td></tr>
<tr><td align='left' class='label'></td></tr>

</table>

	<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</body>
</html>


<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.HashMap,java.util.ArrayList,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${sessionScope.LOCALE}" />
<c:set var="prefix" value="${'/eCommon/html/'}" /> 
<c:set var="sep" value="${'?'}" /> 
<c:set var="style" value="${prefix}${sessionScope.PREFERRED_STYLE}" /> 
<c:set var="locale" value="${sessionScope.LOCALE}" /> 

<html>
<head>
<link rel='StyleSheet' type='text/css'  href='<c:url value="${style}" />' />
</head>
<body >

<% 
	String patient_id = checkForNull(request.getParameter("patient_id"));
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String pat_dtls = "";
	String SQL = "select get_patient.get_line_detail(?,?) Pline FROM dual";
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(SQL);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,(String) pageContext.getAttribute("locale"));
		rst = pstmt.executeQuery();
		if(rst != null && rst.next()){
			pat_dtls = rst.getString(1);
		}
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("Err Msg From VerifyCheckListPatientDtls.jsp-->"+e);
	}finally{
		try{
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
	%>

	<form name="VerifyCheckListHeaderForm" id="VerifyCheckListHeaderForm" >
		<table cellpadding="3" cellspacing="0" width="100%" align="center" border="0">
			<tr>
			<c:set var="result" ><%=pat_dtls%></c:set>
			<c:forTokens var="row" items="${result}" delims="|" >
				<td class="PATIENTLINE1" ><c:out value="${row}" /></td>
			</c:forTokens>	
				
			</tr>
		</table>
	</form>
</body>
</html>


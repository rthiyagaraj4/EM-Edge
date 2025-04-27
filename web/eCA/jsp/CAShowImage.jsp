<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
	<head>
	<Title>View Image</title>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";		
		String imgName = request.getParameter("object_id")==null?"":request.getParameter("object_id");
		
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src='../../eCA/js/DCRTree.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()" onMouseDown="CodeArrest()">
		<form name='DcrRefForm' id='DcrRefForm'>
			<table align='center' border='0'  cellpadding='3' cellspacing='0' width='100%'>
				<tr>
					<td class='label'>
						<img src="../../eCA/images/<%=imgName%>" />
					</td>
				</tr>				
			</table>		
		</form>
	</body>
</html>


<!DOCTYPE html>
<%@ page import ="java.util.StringTokenizer" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<%
		String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


%>
<html>            
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<body >
		<form name="HdrCommonForm" id="HdrCommonForm">
			<table border='1' width="100%" cellpadding="3" cellspacing="0">
				<tr>
					<%
					request.setCharacterEncoding("UTF-8");
					String strHdrLegend=checkForNull(request.getParameter("legends"));
					String strLegendSize=checkForNull(request.getParameter("sizes"));
					String legends_arr[] = strHdrLegend.split(",");
					String sizes_arr[] = strLegendSize.split(",");
					int sizes = legends_arr.length;
					for(int i=0;i<sizes;i++){
					 out.println("<td class='COLUMNHEADER' width='"+sizes_arr[i]+"%' >"+legends_arr[i]+"</td>");
					}

					%>
				</tr>
			</table>
		</form>
	</body>
</html>


<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
   <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
   <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>  
		<form>
		<%
		request.setCharacterEncoding("UTF-8");
	     String	called_from_ca			= request.getParameter("called_from_ca");
         	if (called_from_ca==null) called_from_ca="";
		%>
			<table border='0' cellpadding='0' cellspacing='0' width='100%' >
			<tr>
			<td class=BODYCOLORFILLED align='right'>
			 <% if(called_from_ca .equals("Y")) {%>   
                 <input class=button type=button name=Close value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick="parent.window.close()" disabled>
             <%}else{%>
               	<input class=button type=button name=Close value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick="parent.window.close()">
              <%}%>
				</td>
			</table>
			</tr>
		</form>
	</body>
</html> 


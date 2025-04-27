<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*, java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%
	request.setCharacterEncoding("UTF-8");
   String called_from = request.getParameter("called_from");
   if(called_from==null)  called_from="";
		
%>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>

		<script language="javascript" src="../../eBL/js/PkgVisitAdhocDiscount.js"></script>
		<script language="javascript" src="../../eBL/js/PkgVisitDiscount.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
		
<body onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"   onSelect="codeArrestThruSelect();">
<form name='VisitAdhocBtnForm' id='VisitAdhocBtnForm' method='post' action=''   >	

	
	<table  cellpadding='3' cellspacing='0' width='100%'>	
		<tr>
		
	
			<td width="25%"  class='labels' align='right'>		
				<input type='button' class='button' onclick='callAuth()' name="auth_btn" id="auth_btn"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorization.label","common_labels")%>" >
				
				<% if(called_from.equals("discount_link")==true){ %> 
										<INPUT TYPE="button"  class="BUTTON" VALUE="    <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick="packageDiscountDetails('VISIT_REGISTRATION')" tabIndex='8'>					
				<% }else{ %>
					<INPUT TYPE="button"  class="BUTTON" VALUE="    <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick="apply()" tabIndex='8'>

					<%} %>
					<input type='button'  name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" class='button' onClick='cancel()'>
			</td>
		</tr>         
	</table> 

	
</form>	 
</body>
</html>


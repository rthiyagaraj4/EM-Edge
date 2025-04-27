<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title></title>
		<%
		request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/ViewOrder.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<script>
		function closew(){
			const dialogTag = parent.parent.document.getElementById("dialog_tag");
			dialogTag.close();
		}
		</script>
		</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
		<form name ='buttonForm' id='buttonForm'>
<%
		//String bean_id 				= request.getParameter("bean_id");
		//String bean_name 			= request.getParameter("bean_name");
		
		String mode					= request.getParameter( "mode" ) ;
		String OkDisabled		  =  "";
		String OkStyle			  =  "";
		if(mode.trim().equals("2")){
			 OkDisabled		  =  "disabled";	
			 OkStyle		  =  "display:none" ;
		}
%>
		<table border="0" cellpadding="3" cellspacing="0" width="8%" align='right'>
			<tr><td class='button'><input type="button" name="Ok" id="Ok" class="BUTTON" value ='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>'	<%=OkDisabled%> style="<%=OkStyle%>" onClick="parent.ok()"><input type="button" name="Close" id="Close" class="BUTTON" value ='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick="toCloseTopShowModal();"></td>   
    
			 </tr>
		</table>
		</form>
	</body>
</html>


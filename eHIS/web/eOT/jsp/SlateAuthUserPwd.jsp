<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=" import="java.util.*, eOT.*,eOT.Common.* , eCommon.Common.*" %>
<%@page  import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>
<%@page import="org.apache.commons.codec.binary.Base64"%> <!-- MMS-ME-SCF-0051-->
<html>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eOT/js/Slate.js"></script>
	<script language="javascript" src="../../eCommon/js/crypto-js.min.js"></script> <!-- MMS-ME-SCF-0051-->
	<!--Added by Gomathi for ML-MMOH-CRF-1844.2 US005-->
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script src='../../eXH/js/ExternalApplication.js' language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title>
		<fmt:message key="Common.login.label" bundle="${common_labels}"/>
	</title>
</head>
<%
	String login_user		= request.getParameter("login_user");
	String function_id		= request.getParameter("function_id");
	String function_name	= request.getParameter("function_name");
	
	String bean_id			= "@SlateBean";
	String bean_name		= "eOT.SlateBean";
	SlateBean bean= (SlateBean)mh.getBeanObject( bean_id, request, bean_name );
	//Added by Gomathi for ML-MMOH-CRF-1844.2 US005
	Connection con =null ;
	con = ConnectionManager.getConnection(request);
    	boolean isSSOIntegrationAppl = false;
	isSSOIntegrationAppl = CommonBean.isSiteSpecific(con, "SM", "SSO_INTEGRATION");
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="SlateUserPwdForm" id="SlateUserPwdForm" >
	<table  border='0' align="center" width='100%' cellpadding=3  cellspacing='0'>
		<tr>
			<td width='25%' class='label'><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
			<td width='25%' class='fields'>
			<input type='text' class='fields' name='user_id' id='user_id' value='' size='30' maxlength='30' onblur="this.value=this.value.toUpperCase();<%if(isSSOIntegrationAppl){%>checkADAndEMUserYN(this.value);<%}%>">
			</td><!-- ML-MMOH-SCF-1249 -->
		</tr>
		<tr>
			<td width='25%' class='label'><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
			<td width='25%' class='fields'>
			<input type='password'class='fields'  name='password' id='password' value='' size='30' maxlength='20'>
			</td>
		</tr>
		<tr>
		<td></td>
			<td width='25%'>
				<input type="button" class="button" name="btnOK" id="btnOK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="validateUserPwd()" ></input>

				<input type="button" class="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="window.returnValue='false';window.close()"></input>
			</td>

		</tr>
</table>	
		<input type="hidden" name="bean_id" id="bean_id"	value="<%=bean_id%>"   >
		<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>" >
		<input type="hidden" name="login_user" id="login_user"	value="<%=login_user%>">
		<input type="hidden" name="function_id" id="function_id"	value="<%=function_id%>">
		<input type="hidden" name="function_name" id="function_name"	value="<%=function_name%>">		
		<!--Added by Gomathi for ML-MMOH-CRF-1844.2 US005-->
	<input type='hidden' name='isSSOIntegrationAppl' id='isSSOIntegrationAppl' value=<%=isSSOIntegrationAppl%>>
	<input type='hidden' name='login_user_type' id='login_user_type' value="">
</form>
</body>
</html>



<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PharmacistHome.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<title><fmt:message key="Common.Store.label" bundle="${common_labels}"/></title>
	</HEAD>
<%
	String store_details	    =  "";
	String facility_id			= (String) session.getValue("facility_id");
	String identityForSwitch    = request.getParameter("identityForSwitch")==null?"":request.getParameter("identityForSwitch");

	String bean_id   = "PharmacistHomeBean" ;
	String bean_name = "ePH.PharmacistHomeBean";
	PharmacistHomeBean bean = (PharmacistHomeBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);

	String storeCode="";

	if(identityForSwitch.equals("Switch")){
		storeCode		= bean.getStore_code();
	}
%>
	<body onMouseDown="" onKeyDown="lockKey()" onload="">
		<form name="frmPharmacistHomeLogin" id="frmPharmacistHomeLogin">
			<table cellpadding="8" cellspacing="2" width="101%" align="center" border="0" >
				<tr><td colspan="4">&nbsp;</tr>				
				<tr>
					<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td >&nbsp;&nbsp;
						<select name="store" id="store" onChange="" >
						<%=bean.getStore_code_List(storeCode)%>
						</select>
						<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td>	
				</tr>
					<td  colspan="2" class="white" align="center">
						<input type="button" class="BUTTON" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="proceedLogin(event)">	
						<input type="button" class="BUTTON" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="goHome()">
					</td>	
				</tr>
			</TABLE>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		</form>
	</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>


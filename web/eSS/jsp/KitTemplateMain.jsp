<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.lang.*" contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title> 
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String bean_id		= "kitTemplateBean" ;
		String bean_name	= "eST.KitTemplateBean";
		String mode			= request.getParameter("mode");
		String kit_template_code = "";
		String kit_template_desc = "";
		String eff_status = "E";
		String disab = "";
		String cheked = "";
		KitTemplateBean bean = (KitTemplateBean)getBeanObject( "kitTemplateBean","eST.KitTemplateBean", request ) ;  
		bean.setLanguageId(locale);
		if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			kit_template_code	= request.getParameter("kit_template_code")==null?"":request.getParameter("kit_template_code");
			kit_template_desc	= request.getParameter("kit_template_desc")==null?"":request.getParameter("kit_template_desc");
			eff_status	= request.getParameter("eff_status");
			disab		= "disabled";
		}
			if(((String)eff_status).equals("E"))
				cheked  = "checked";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/KitTemplate.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()">
		<form name="KitTemplateMainform" id="KitTemplateMainform" >
			<table border=0 cellspacing=0 cellpadding=0 height="15%" width="100%"  align="center" >			    
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<tr>
				    
					<td  class=label><fmt:message key="eST.KitTemplateCode.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td><td class='fields'><input type=text name='kit_template_code' id='kit_template_code' size=20 maxlength=20 value="<%=kit_template_code%>"  onKeyPress="return CheckForSpecChars(event)" <%=disab%>><img src="../../eCommon/images/mandatory.gif" align="center"></img></td></tr>
                <tr>
				      <td class=label><fmt:message key="eST.KitTemplateDescription.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td><td class='fields'><input type=text name='kit_template_desc' id='kit_template_desc' size=40 maxlength=60 value="<%=kit_template_desc%>" <%=disab%>><img src="../../eCommon/images/mandatory.gif" align="center"></img></td></tr>
				<tr>
				      <td class=label><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><td class='fields'><input type='checkbox'  name="eff_statu" id="eff_statu"  value="" onclick="assignValue1(this);" <%=cheked%>></td></tr>
		 </table>
	<%
putObjectInBean(bean_id,bean,request);
%>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="eff_status" id="eff_status" value="<%=eff_status%>">
		</form>
	</body>
</html>


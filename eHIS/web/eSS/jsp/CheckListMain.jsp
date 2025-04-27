<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import="eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.lang.*" contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title> 
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String bean_id		= "checkListBean" ;
		String bean_name	= "eSS.CheckListBean";
		String mode			= request.getParameter("mode");
		String checklist_code = "";
		String checklist_desc = ""; 
		String eff_status = "E";
		String disab = "";
		String cheked = "";
		CheckListBean bean = (CheckListBean)getBeanObject( "checkListBean","eSS.CheckListBean", request ) ;  
		bean.setLanguageId(locale);
		if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			checklist_code	= request.getParameter("checklist_code")==null?"":request.getParameter("checklist_code");
			checklist_desc	= request.getParameter("checklist_desc")==null?"":request.getParameter("checklist_desc");
			eff_status	= request.getParameter("eff_status");
			disab		= "disabled";
		 bean.setMode_Temp("MODE_MODIFY");
		
		}
			if(((String)eff_status).equals("E"))
				cheked  = "checked";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eSS/js/CheckList.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<body onMouseDown="CodeArrest()">
		<form name="KitTemplateMainform" id="KitTemplateMainform" >
			<table border=0 cellspacing=2 cellpadding=0 height="15%" width="100%"  align="center" >			    
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<tr>
				    
					<td  class=label><!--<fmt:message key="eST.KitTemplateCode.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>-->CheckList Code
					<td class='fields'>
						<input type=text name='checklist_code' id='checklist_code' oninput='this.value = this.value.toUpperCase();' size=20 maxlength=20 value="<%=checklist_code%>"  onKeyPress="return CheckForSpecChars(event)" onBlur="CheckForSpecCharAlphaCode(this)" <%=disab%>>
						<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td>
				</tr>
                <tr>
				      <td class=label><!--<fmt:message key="eST.KitTemplateDescription.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>-->CheckList Description<td class='fields'><input type=text name='checklist_desc' id='checklist_desc' size=40 maxlength=60 value="<%=checklist_desc%>" ><img src="../../eCommon/images/mandatory.gif" align="center"></img></td></tr>
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


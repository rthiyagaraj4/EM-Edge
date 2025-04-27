<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="eSS.SurgeryTypeBean,java.util.HashMap,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	 request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");
	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/SurgeryType.js"></script>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 
</head>
<%
	String bean_id = "surgeryTypeBean";
	String bean_name = "eSS.SurgeryTypeBean";
	SurgeryTypeBean bean = (SurgeryTypeBean) getBeanObject( bean_id,bean_name,request );
	bean.setLanguageId(locale);
	
	String typed_text= request.getParameter( "typed_text" )==null?"":request.getParameter( "typed_text" ) ; 
		
		
	putObjectInBean("surgeryTypeBean",bean,request);

%>

<body onload='FocusFirstElement();' >
	<form name="OTSurgeryNameSearchCriteria_Form" id="OTSurgeryNameSearchCriteria_Form" >
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
			
			<th   colspan=6><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>
		<tr>
			<td>&nbsp;&nbsp;</td> 
			<td   class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/>
		</td>
		<td  class="fields"><input type="radio" name="search_by" id="search_by" class="label" value="C"    onclick="storeVal(this)"><fmt:message key="eSS.SurgeryName.label" bundle="${ss_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="D" onclick="storeVal(this)" checked><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		</tr>
		
        <tr>
		<td class="label">&nbsp;</td>
		<td class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
        <td class="fields"><input type="text" onBlur="makeValidString(this);allow_nochars(this);"  name="search_text" id="search_text" value="<%= typed_text%>" width="30%" align="left" size="40" maxlength="70" >
        </td>		
		<td align="left" nowrap><input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="searchVals(); " class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="reset();" class="button" >
        <input type=button class=button name="Close" id="Close" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  onclick="parent.parent.document.getElementById('dialog_tag').close();"></td>
        </td>
    </tr>
	
		
</center>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">


<script>
<%
if(!typed_text.equals("")){
	out.println("searchVals();");
}
%>
</script>
</form>

</body>
</html>


<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="eSS.PrepareGroupBean,java.util.HashMap,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
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
		<script language="javascript" src="../../eSS/js/PrepareGroup.js"></script>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 
</head>
<%
	String bean_id = "prepareGroupBean";
	String bean_name = "eSS.PrepareGroupBean";
	PrepareGroupBean bean = (PrepareGroupBean) getBeanObject( "prepareGroupBean","eSS.PrepareGroupBean",request );
	bean.setLanguageId(locale);
	
	String item_code= request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" ) ;
	String store_code= request.getParameter( "store_code" )==null?"":request.getParameter( "store_code" ) ;
	String click_type= request.getParameter( "click_type" )==null?"":request.getParameter( "click_type" ) ;
	String total_rec= request.getParameter( "total_rec" )==null?"":request.getParameter( "total_rec" ) ;
	String mode= request.getParameter( "mode" )==null?"":request.getParameter( "mode" ) ;
		


%>

<body onload='FocusFirstElement();' >
	<form name="GroupSearchCriteria_Form" id="GroupSearchCriteria_Form" >
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
			
			<th   colspan=6><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>
		<tr>
			<td>&nbsp;&nbsp;</td> 
			<td   class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/>
		</td>
		<td  class="fields"><input type="radio" name="search_by" id="search_by" class="label" value="C"    onclick="storeVal(this)"><fmt:message key="Common.code.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="D" onclick="storeVal(this)" checked><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		</tr>
		<tr>
		<td>&nbsp;&nbsp;</td>
			<td class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
			<td class="fields"><input type="text"   name="store_code" id="store_code" value="<%=store_code %>" width="30%" align="left" size="40" maxlength="70" disabled></td>	
        
		</tr>
		<tr>
		<td class="label">&nbsp;</td>
		<td class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
        <td class="fields"><input type="text" onBlur="makeValidString(this);allow_nochars(this);"  name="search_text" id="search_text"  width="30%" align="left" size="40" maxlength="70" > </td>

		<td class='label'><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>&nbsp;
			<select name="search_criteria" id="search_criteria">
				<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
				<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
				<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
			</select>
        </td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;</td>
			<td  class="label" ><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></td>
			<td><select name="group_type" id="group_type"><%=bean.getGroupTypes()%></select></td>
		
			<td align="left" nowrap><input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="searchVals(); " class="button" >
		        <input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="reset();" class="button" >
				<input type=button class=button name="Save" id="Save" value=' <fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  onclick="closeActionPerformed(this); ">
			<input type=button class=button name="Close" id="Close" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  onclick="closeWindow();"></td>
			</td>
		</tr>
						

		
</center>
</table>
<input type="hidden" name="facility_id" id="facility_id" value="<%=bean.getLoginFacilityId()%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="click_type" id="click_type" value="<%=click_type%>">
<input type="hidden" name="total_rec" id="total_rec" value="<%=total_rec%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">

<script>
<%if (!(store_code.equals(""))) {
	out.println("searchVals();");
}

putObjectInBean("prepareGroupBean",bean,request);
%>
</script>
</form>

</body>
</html>


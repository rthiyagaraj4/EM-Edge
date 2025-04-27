<!DOCTYPE html>
<%@page import="eMM.StoreGroupBean" contentType="text/html;charset=UTF-8"%>
<%@include file ="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<head>

<%	   
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="JavaScript" src ="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"> </script>
<script language="JavaScript" src="../js/StoreGroup.js"></script>
<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	 
</head>

<body onLoad="FocusFirstElement();" >

<%
String mode					=	"";
String bean_id				=	"";
String bean_name			=	"";
String facility_id			=	"";

mode				=	request.getParameter("mode");
bean_id				=	"storeGroupBean" ;
bean_name			=	"eMM.StoreGroupBean";
facility_id			=	(String) session.getAttribute("facility_id");
StoreGroupBean bean = (StoreGroupBean)getBeanObject( bean_id, bean_name, request );


bean.setLanguageId(locale);
bean.clear();
bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
bean.setMode(mode);

String strGroupCodeDisabled="";
String checked		=	"CHECKED";
String disabled		=	"";

if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) )
{
	bean.setStoreGroupCode(request.getParameter("store_group_code"));
	bean.setLoginFacilityId(facility_id);
	bean.loadData();
	if (bean.getStoreGroupEnabled().equals("E"))
	{
		checked = "CHECKED";
	}
	else
	{
		checked		=	"";
		disabled	=	" disabled ";
	}
	strGroupCodeDisabled=" disabled ";
}
%>

<form name = "formAddModifyStoreGroup">

<table border="0" align=CENTER cellpadding="0" cellspacing="0" width="95%"  style="background-color: #FFFFFF" valign="CENTER" height="75%">
	<tr>
		<td width='100%'  style="background-color: #FFFFFF">
			<table width="70%"  align=CENTER cellspacing="0" cellpadding="0" border="0" style="background-color: #FFFFFF"  >
				<tr height='30'>
					<td    class="label" width='30%'>
					<fmt:message key="eMM.StoreGroupCode.label" bundle="${mm_labels}"/>
					</td>
					<td class=fields colspan="3">&nbsp;&nbsp;
					<input type="text" name="store_group_code" id="store_group_code" value="<%=bean.getStoreGroupCode()%>" size="6" maxlength="4" onKeyPress="return CheckForSpecChars(event)" onBlur="convertToUpperCase(this);checkSpecialChars(this);" <%=strGroupCodeDisabled%> >
					<img src="../../eCommon/images/mandatory.gif" ></img>
					</td>
				</tr>
				<tr height='30' >
					<td   class="label">
					<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
					</td>
					<td class=fields  colspan="3">&nbsp;&nbsp;
					<input type="text" name="store_group_long_desc" id="store_group_long_desc" value="<%=bean.getStoreGroupLongDesc()%>" size="60" maxlength="60" onBlur="LTrim(this);RTrim(this);makeValidString( this ) ;" <%=disabled%>>
					<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td>
				</tr> 
				<tr height='30'>
					<td   class="label">
					<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
					</td>
					<td class=fields colspan="3">&nbsp;&nbsp;
					<input type="text" name="store_group_short_desc" id="store_group_short_desc" value="<%=bean.getStoreGroupShortDesc()%>" size="30" maxlength="30" onBlur="LTrim(this);RTrim(this);makeValidString( this ) ;" <%=disabled%>>
					<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td> 
				</tr>
				<tr height='30'>
					<td  class="label">
					<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
					</td>
					<td class=fields colspan="3" >&nbsp;
					<input type="checkbox" name="store_group_enabled" id="store_group_enabled" value="E" <%=checked%>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
</form>
 <%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>


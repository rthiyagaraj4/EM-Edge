<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
14/1/2019		IN069437			Shazana 							GHL-CRF-0548.1 
---------------------------------------------------------------------------------------------------------
*/
%> 
<%@page import="eMM.ItemTechNameBean" contentType="text/html;charset=UTF-8"%>
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
<script language="JavaScript" src="../../eMM/js/ItemTechName.js"></script>
<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>

</head>

<body onLoad="FocusFirstElement();" >

<%
String mode					=	"";
String bean_id				=	"";
String bean_name			=	"";
String facility_id			=	"";

mode				=	request.getParameter("mode");
bean_id				=	"ItemTechNameBean" ;
bean_name			=	"eMM.ItemTechNameBean";
facility_id			=	(String) session.getAttribute("facility_id");
ItemTechNameBean bean = (ItemTechNameBean)getBeanObject( bean_id, bean_name, request );


bean.setLanguageId(locale);
bean.clear();
bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
bean.setMode(mode);

String itemTechCodeDisabled="";
String itemTechCode_disable_field="";//added for IN069437
String checked		=	"CHECKED";
String disabled		=	"";
String Remarks="";

if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) )
{
	bean.setItemTechCode(request.getParameter("item_Tech_Code"));
	bean.setLoginFacilityId(facility_id);
	bean.loadData();

	Remarks=bean.getItemTechRemarks();
	if (bean.getItemTechNameEnabled().equals("Y"))
	{
		checked = "CHECKED";
	}
	else
	{
		checked		=	"";
		disabled	=	" disabled ";
		itemTechCodeDisabled=" disabled ";//added for IN069437
	}
	itemTechCode_disable_field=" disabled "; //added for IN069437
	//boolean itemTechCodecount = bean.getRecordCountForItemTechCode(bean.getItemTechCode());
}

%>

<form name = "formAddModifyItemTechName">

<table border="0" align=CENTER cellpadding="0" cellspacing="0" width="95%"  style="background-color: #FFFFFF" valign="CENTER" height="75%">
	<tr>
		<td width='100%'  style="background-color: #FFFFFF">
			<table width="70%"  align=CENTER cellspacing="0" cellpadding="0" border="0" style="background-color: #FFFFFF"  >
				<tr height='30'>
					<td    class="label" width='30%'>
					<fmt:message key="eMM.ItemTechCode.label" bundle="${mm_labels}"/>
					</td>
					<td class=fields colspan="3">&nbsp;&nbsp;
					<input type="text" name="Item_Tech_Name_code" id="Item_Tech_Name_code" value="<%=bean.getItemTechCode()%>" size="20" maxlength="20" onKeyPress="return CheckForSpecChars(event)" onBlur="checkSpecialChars(this);" <%=itemTechCode_disable_field%>> <!-- modified for IN069437-->
					<img src="../../eCommon/images/mandatory.gif" ></img>
					</td>
				</tr>
				<tr height='30' >
					<td   class="label">
					<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
					</td>
					<td class=fields colspan="3">&nbsp;&nbsp;
					<input type="text" name="Item_Tech_short_desc" id="Item_Tech_short_desc" value="<%=bean.getItemTechSHortDesc()%>" size="60" maxlength="60" <%=itemTechCodeDisabled%>> <!-- modified for IN069437-->
					<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td> 
				</tr>
				<tr height='30'> 
					<td   class="label">
					<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
					</td>
					<td class=fields  colspan="3">&nbsp;&nbsp;
					<input type="text" name="Item_Tech_long_desc" id="Item_Tech_long_desc" value="<%=bean.getItemTechLongDesc()%>" size="60" maxlength="60" <%=itemTechCodeDisabled%>> <!-- modified for IN069437-->
					<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td>
				</tr> 
				<tr height='30'>
					<td   class="label">
					<fmt:message key="eST.Remarks.label" bundle="${st_labels}"/>
					</td>
					<td class=fields colspan="3">&nbsp;&nbsp;
					<textarea name="Item_Tech_Remarks"  rows="2" cols="50"  onBlur="return checkLength()" <%=itemTechCodeDisabled%> ><%=Remarks%></textarea> <!-- modified for IN069437-->
					</td> 
				</tr>
				<tr height='30'>
					<td  class="label">
					<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
					</td>
					<td class=fields colspan="3" >&nbsp;
					<!-- <input type="checkbox" name="Item_Tech_enabled" id="Item_Tech_enabled" id="Item_Tech_enabled"  onclick="checkenabledisable()"     value="Y" <%=checked%>> -->
					<input type="checkbox" name="Item_Tech_enabled" id="Item_Tech_enabled" id="Item_Tech_enabled"       value="Y" <%=checked%>>
					
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
 <input type="hidden" name="checked1" id="checked1" id="checked1" value="<%=checked%>"> 
</form>
 <%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>


<!DOCTYPE html>
<!--  
---------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------
06/04/2017	IN063261		Manoj kumar KV								   		GHL-CRF-0444			
26/08/2019      IN071152	B Haribabu		                                                         AMRI-CRF-0408
---------------------------------------------------------------------------------------------------------
-->
<%@page import="java.util.ArrayList, eMM.StoreBean, eMM.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@include file ="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<head>
<%

		request.setCharacterEncoding("UTF-8");
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="JavaScript" src ="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"> </script>
	<script language="JavaScript" src="../../eMM/js/Store.js"></script>
	<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
	<!-- <script language="JavaScript" src="../js/MmMessages.js"></script>
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
 <style>
textarea {
  resize: none;
}
</style>

</head>
<body onLoad="FocusFirstElement();onloadshowCheck();" >
<%
String mode					=	"";
String bean_id				=	"";
String bean_name			=	"";
String disabled				=	"";
String checked				=	"";
//String readOnly				=	"";
String codeReadOnly			=	"";
String checked_external_yn	=	"";
String facility_id			=	"";
String external				=	"";
String disabled_1			=  "";
String interface_to_external_po_yn			 =		"";
String strStoreGroupCode = "";
ArrayList arr_lang=new ArrayList();
arr_lang.add(locale);
String hidden_style			= "visibility:visible";
ArrayList	arrValues		=	new ArrayList();
facility_id			=	(String) session.getAttribute("facility_id");
arrValues.add(facility_id);
mode				=	request.getParameter("mode");
bean_id				=	"storeBean" ;
bean_name			=	"eMM.StoreBean";
if ( mode == null || mode.equals("") )
		return ;
if ( !(mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( (String)CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
StoreBean bean = (StoreBean)getBeanObject(bean_id,bean_name,request);
 bean.setLanguageId(locale);
bean.clear();
bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
bean.setMode(mode);
MmUtils objMmUtils	=	new MmUtils( bean.getProperties() );
//bean.setMmFunctionId(MmInterface.getCommonKeyValue("MM_STORE")) );
if (bean.isARModuleInstalled().equals("Y") )
		{
		external= "Y";
		}
		else
		{
		external = "N";
		}

if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) )
{
	bean.setStoreCode(request.getParameter("store_code"));
	bean.setLoginFacilityId(facility_id);
	bean.loadData();
	bean.setSQLOperation(
		CommonRepository.getCommonKeyValue( "MODE_MODIFY"), MmRepository.getMmKeyValue( "SQL_MM_STORE_UPDATE"));
	if (bean.getEffStatus().equals("E"))
	{
		checked = "CHECKED";
	}
	else
	{
		checked		=	"";
	//	readOnly	=	" readOnly ";
		disabled	=	" disabled ";
	}
	codeReadOnly ="disabled";
	if(bean.getExternal().equals("Y"))
	{
		checked_external_yn	=	"CHECKED";
		disabled_1=" disabled ";
		hidden_style="visibility:hidden";

	}
}
else
{
	bean.setSQLOperation(CommonRepository.getCommonKeyValue( "MODE_INSERT"), MmRepository.getMmKeyValue( "SQL_MM_STORE_INSERT"));
	checked = "CHECKED";
}

interface_to_external_po_yn=bean.getInterface_to_external_po_yn((String)session.getAttribute("ACC_ENTITY_ID"));
strStoreGroupCode = bean.checkForNull(bean.getStoreGroup());
String strStoreGroupDisabled="";

if (strStoreGroupCode.equals("") || strStoreGroupCode.equals(null) || strStoreGroupCode.equalsIgnoreCase("null")){
   strStoreGroupDisabled = "";
}else{
   strStoreGroupDisabled = "disabled";
}
%>
<form name = "formMasterCode">
<table border="0" align=CENTER cellpadding="0" cellspacing="0" width="95%"  style="background-color: #FFFFFF" valign="CENTER" height="100%">
<tr>
	<td width='100%'  style="background-color: #FFFFFF">
<table width="95%"  align=CENTER cellspacing="0" cellpadding="0" border="0" style="background-color: #FFFFFF"  >
<!-- <tr>
	<td colspan="4">&nbsp;</td>
</tr> -->
<tr height='30'>
	<td    class="label" width='30%'><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
	<td class=fields colspan="3">&nbsp;&nbsp;<input type="text" name="store_code" id="store_code" value="<%=bean.getStoreCode()%>" size="6" maxlength="6" <%=disabled%> <%=codeReadOnly%> onKeyPress="return CheckForSpecChars(event)" onBlur="convertToUpperCase(this);checkSpecialChars(this);">
	<img src="../../eCommon/images/mandatory.gif" ></img></td>
</tr>
<tr height='30' >
	<td   class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td class=fields  colspan="3">&nbsp;&nbsp;<input type="text" name="long_desc" id="long_desc" value="<%=bean.getLongDesc()%>" size="30" maxlength="40" <%=disabled%> >
	<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
</tr>

<tr height='30'>
	<td   class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td class=fields colspan="3">&nbsp;&nbsp;<input type="text" name="short_desc" id="short_desc" value="<%=bean.getShortDesc()%>" size="15" maxlength="15" onBlur="makeValidString( this ) ;"  <%=disabled%> >
	<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>


</tr>

<tr height='30'>
	<td   class="label"><fmt:message key="Common.external.label" bundle="${common_labels}"/></td>
	<td  class=fields>&nbsp;<input type="checkbox" name="external_yn" id="external_yn"  <%=checked_external_yn%> value="Y" onClick="showCheck()" <%=disabled%>></td>

	<td  align='right' class='label' width='30%'><span id='span1' style="visibility:hidden"><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></span></td>
	<td class=fields nowrap>&nbsp;&nbsp;<select id="tb1" name='cust_code' id='cust_code' <%=disabled%> style="visibility:hidden" >
	<%= objMmUtils.getListOptions( MmRepository.getMmKeyValue("SQL_MM_STORE_CUST"),arr_lang,bean.getCustCode().trim(),locale) %>
	</select> <img src="../../eCommon/images/mandatory.gif" align="center" id='img1' style="visibility:hidden"></img>
	</td>
</tr>
<tr height='30'>
<%ArrayList al = new ArrayList();
al.add(locale);
%>
	<td   class="label" ><fmt:message key="Common.department.label" bundle="${common_labels}"/></td>
	<td  class="fields" colspan="3" nowrap>&nbsp;
	<select name='dept_code' id='dept_code'  <%=disabled%> <%=disabled_1%>>
	<%= objMmUtils.getListOptions(MmRepository.getMmKeyValue("SQL_MM_STORE_DEPT"), arrValues,bean.getDeptCode(),locale) %>
	</select>&nbsp;	<img align='center' id='span2'  src='../../eCommon/images/mandatory.gif' style=<%=hidden_style%> ></img> </td>
	<%if(interface_to_external_po_yn.equals("Y")){%>
	
	<td   class="label"><fmt:message key="eMM.PODepartment.label" bundle="${mm_labels}"/></td>
	<td  class=fields >&nbsp;
	<select name='PO_dept_code' id='PO_dept_code' <%=disabled%>>
	<%= objMmUtils.getListOptions("SELECT dept_code,SHORT_DESC FROM am_dept_lang_vw WHERE   eff_status='E'and language_id = ? ORDER BY short_desc",al,bean.checkForNull(bean.getPODeptCode()),locale) %>
	</select> </td>
	<%}else{%>
	<td  colspan=2 >&nbsp;</td>
	<%}%>
</tr>
<tr height='30'>
	<td  class="label">
	<fmt:message key="eMM.StoreGroup.label" bundle="${mm_labels}"/>
	</td>
	<td class=fields colspan="3" >&nbsp;
	<select name="store_group" id="store_group"  > <%=bean.getStoreGroupEnabled(strStoreGroupCode,strStoreGroupDisabled)%></select>
	</td>
</tr>
<tr height='30' >
	<td   class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>  
	<td class=fields  colspan="3">&nbsp;&nbsp;<textarea name="remarks" rows='5' cols='61' <%=disabled%> onKeyPress="checkMaxLimit(this,300);"  onpaste="checkMaxLengthPaste(this,300)"><%=bean.checkForNull(bean.getRemarks(),"")%> </textarea> <!-- Modified for IN:071152 end -->
	  </td>
</tr>
	<!--  Starts for GHL-CRF-0444 -->
	<tr height='30' >
	<td   class="label"><fmt:message key="eMM.DrugLicenseNo.label" bundle="${mm_labels}"/></td>
	<td class=fields  colspan="3">&nbsp;&nbsp;<input type="text" name="drug_license_no" id="drug_license_no" value="<%=bean.checkForNull(bean.getDrugLicenseNo(),"")%>" size="30" maxlength="30" <%=disabled%> >
	</tr>
	<!--  Ends for GHL-CRF-0444 -->
<tr height='30'>
	<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class=fields colspan="3" >&nbsp;<input type="checkbox" name="eff_status" id="eff_status" <%=checked%> value="E" ></td>
</tr>
<tr >
	<td colspan="4" ></td>
</tr>
<tr >
	<th align='left' colspan="4">&nbsp;<fmt:message key="eMM.StoreInchargeDetails.label" bundle="${mm_labels}"/></th>
</tr>
<tr >
	<td colspan="4" ></td>
</tr>
<tr height='30'>
		<td  class="label" nowrap><fmt:message key="eMM.InchargeName.label" bundle="${mm_labels}"/></td>
		<td class=fields colspan="3">&nbsp;&nbsp;<input type="text" name="store_incharge_name" id="store_incharge_name" value="<%=bean.getStoreInName()%>" size="15" maxlength="30" <%=disabled%> > </td>
</tr>
<tr height='30'>
		<td  class="label" nowrap><fmt:message key="eMM.InchargeTitle.label" bundle="${mm_labels}"/> </td><td colspan="3" class=fields>&nbsp;&nbsp;<input type="text" name="store_incharge_title" id="store_incharge_title" value="<%=bean.getStoreInTitle()%>" size="15" maxlength="30" <%=disabled%>>
		</td>
</tr>
<tr height='30'>
		<td  class="label" nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class=fields colspan="3">&nbsp;&nbsp;<input type="text" name="store_location" id="store_location" value="<%=bean.getStoreLocation()%>" size="15" maxlength="30" <%=disabled%>> </td>
</tr>
<tr height='30'>
		<td  class="label" nowrap><fmt:message key="eMM.ContactReference.label" bundle="${mm_labels}"/></td>
		<td class=fields colspan="3">&nbsp;&nbsp;<input type="text" name="contact_ref" id="contact_ref" value="<%=bean.getContactRef()%>" size="40" maxlength="40" <%=disabled%>> </td>
</tr>
<tr>
		<td  class='label' ></td>
		<td colspan="3" >&nbsp;</td>
</tr>
</table>
</td>
</tr>
</table>
<input type="hidden" name="external" id="external" value="<%=external%>">
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


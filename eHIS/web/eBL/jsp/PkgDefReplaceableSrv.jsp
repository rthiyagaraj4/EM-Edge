<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eBL.* ,eBL.Common.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%
	request.setCharacterEncoding("UTF-8"); 
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eBL/js/PkgDef.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="eBL.replaceableService.label" bundle="${bl_labels}"/></title>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%	
	String locale			= (String)session.getAttribute("LOCALE");
	String type=request.getParameter("type");
	String order_associated=request.getParameter("order_associated");
	String service_code=request.getParameter("service_code");
	String service_desc=request.getParameter("service_desc");
	String catalog_code=request.getParameter("catalog_code");
	String catalog_desc=request.getParameter("catalog_desc");
	String replaceSrv_code=request.getParameter("replaceSrv_code");
	String replaceSrv_desc=request.getParameter("replaceSrv_desc");
	String replaceSrv_cat_code=request.getParameter("replaceSrv_cat_code");
	String replaceSrv_cat_desc=request.getParameter("replaceSrv_cat_desc");
	String disabled="";
	
if(order_associated.equals("N")){
disabled="disabled";
}else{
disabled="";
}
String mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
String modifyStatus = "";
String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
	 modifyStatus = " disabled ";
%>

<form name='replaceable_service' id='replaceable_service'  target='messageFrame' >
	<INPUT TYPE="hidden" name="type" id="type" value="<%=type%>">	
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">

	
<table class='grid' width='100%' align='center' id="replaceable_service_tbl">
<tr>
<td align='right' class='label'  nowrap><b><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></b></td>
<td align="left" nowrap><input type='text' disabled name='service_code' id='service_code'  <%=modifyStatus%> value='<%=service_code%>' size='10' ></td>
<td>&nbsp;</td>
</tr>

<tr>
<td align='right' class='label'  nowrap><b><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></b></td>
<td align="left" nowrap><input type='text' disabled name = 'service_desc'  <%=modifyStatus%> size='10' maxlength='10' value="<%=service_desc%>"></td>
<td>&nbsp;</td>
</tr>

<tr>
<td align='right' class='label'  nowrap><b><fmt:message key="Common.OrdercatalogCode.label" bundle="${common_labels}"/></b></td>
<td align="left" nowrap><input type='text' disabled  name='catalog_code' id='catalog_code'	 <%=modifyStatus%> value='<%=catalog_code%>' size='10' ></td>
<td>&nbsp;</td>
</tr>

<tr>
<td align='right' class='label'  nowrap><b><fmt:message key="Common.OrderCatalogDesc.label" bundle="${common_labels}"/></b></td>
<td align="left" nowrap><input type='text' disabled name = 'catalog_desc'  <%=modifyStatus%> size='10' maxlength='10' value="<%=catalog_desc%>"></td>
<td>&nbsp;</td>
</tr>

<tr>
<td align='right' class='label'  nowrap><b><fmt:message key="eBL.replaceableService.label" bundle="${bl_labels}"/></b></td>
<td align="left" nowrap><input type='hidden' name='replaceSrv_code' id='replaceSrv_code' value='<%=replaceSrv_code%>' ><input type='text' name = 'replaceSrv_desc'	  <%=modifyStatus%> size='10' maxlength='10' onBlur="before_replaceSrvLookUp(this,replaceSrv_code,type)" value="<%=replaceSrv_desc%>"><INPUT type='hidden' name='replaceSrv_desc_temp' id='replaceSrv_desc_temp' value=''><input type='button' name='replaceSrv_button' id='replaceSrv_button' class='button' value='?' onclick="replaceSrvLookUp(replaceSrv_desc,replaceSrv_code,type)"></td>
<td>&nbsp;</td>
</tr>

<tr>
<td align='right' class='label'  nowrap><b><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></b></td>
<td align="left" nowrap><input type='hidden' name='replaceSrv_cat_code' id='replaceSrv_cat_code' value='<%=replaceSrv_cat_code%>' ><input type='text' <%=disabled%> name = 'replaceSrv_cat_desc' size='10' maxlength='10'	    <%=modifyStatus%> onBlur="before_replaceSrvCatLookUp(this,replaceSrv_cat_code,replaceSrv_code)" value="<%=replaceSrv_cat_desc%>"><INPUT type='hidden' name='replaceSrv_cat_desc_temp' id='replaceSrv_cat_desc_temp' value=''><input type='button' <%=disabled%>   <%=modifyStatus%> name='replaceSrv_cat_button' class='button' value='?' onclick="replaceSrvCatLookUp(replaceSrv_cat_desc,replaceSrv_cat_code,replaceSrv_code)"></td>
<td>&nbsp;</td>
</tr>

<tr>

<td align="right" colspan='3' nowrap><INPUT type="button" class='button'	 <%=modifyStatus%> value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onclick="saveReplaceableVals()" /><input type="button" class="button"	  <%=modifyStatus%> value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick="window.close();"></td>
</tr>
 </table>
  </form>   
 </body>

</html>


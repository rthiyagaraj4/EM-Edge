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
	<script language="javascript" src="../../eBL/js/PkgEnq.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="eBL.replaceableService.label" bundle="${bl_labels}"/></title>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%	
	//String type=request.getParameter("type");//unused variable
	String service_code=request.getParameter("service_code");
	String service_desc=request.getParameter("service_desc");
	String catalog_code=request.getParameter("catalog_code");
	String catalog_desc=request.getParameter("catalog_desc");
	//String replaceSrv_code=request.getParameter("replaceSrv_code");//unused variable
	String replaceSrv_desc=request.getParameter("replaceSrv_desc");
	//String replaceSrv_cat_code=request.getParameter("replaceSrv_cat_code");//unused variable
	String replaceSrv_cat_desc=request.getParameter("replaceSrv_cat_desc");
%>

<form name='replaceable_service' id='replaceable_service'  target='messageFrame' >

	
<table class='grid' width='100%' align='center' id="replaceable_service_tbl">
<tr>
<td align='right' class='label'  nowrap><b><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></b></td>
<td align="left" nowrap><input type='text' disabled name='service_code' id='service_code'   value='<%=service_code%>' size='10' ></td>
<td>&nbsp;</td>
</tr>

<tr>
<td align='right' class='label'  nowrap><b><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></b></td>
<td align="left" nowrap><input type='text' disabled name = 'service_desc'   size='10' maxlength='10' value="<%=service_desc%>"></td>
<td>&nbsp;</td>
</tr>

<tr>
<td align='right' class='label'  nowrap><b><fmt:message key="Common.OrdercatalogCode.label" bundle="${common_labels}"/></b></td>
<td align="left" nowrap><input type='text' disabled  name='catalog_code' id='catalog_code'	  value='<%=catalog_code%>' size='10' ></td>
<td>&nbsp;</td>
</tr>

<tr>
<td align='right' class='label'  nowrap><b><fmt:message key="Common.OrderCatalogDesc.label" bundle="${common_labels}"/></b></td>
<td align="left" nowrap><input type='text' disabled name = 'catalog_desc'   size='10' maxlength='10' value="<%=catalog_desc%>"></td>
<td>&nbsp;</td>
</tr>

<tr>
<td align='right' class='label'  nowrap><b><fmt:message key="eBL.replaceableService.label" bundle="${bl_labels}"/></b></td>
<td align="left" nowrap><input type='text' name = 'replaceSrv_desc'	 disabled  size='10' maxlength='10' value="<%=replaceSrv_desc%>"></td>
<td>&nbsp;</td>
</tr>

<tr>
<td align='right' class='label'  nowrap><b><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></b></td>
<td align="left" nowrap><input type='text' disabled name = 'replaceSrv_cat_desc' size='10' maxlength='10'	disabled value="<%=replaceSrv_cat_desc%>"></td>
<td>&nbsp;</td>
</tr>

 </table>
  </form>   
 </body>

</html>


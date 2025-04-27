<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- OrderItem.jsp -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %><!--IN068370,IN068373-->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> <!--IN068370,IN068373-->
<!--
-------------------------------------------------------------------------------------------------------------------------------
Date		Edit History    Name       	Rev.Date	Rev.Name	Description
-------------------------------------------------------------------------------------------------------------------------------
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
-------------------------------------------------------------------------------------------------------------------------------
-->

<html>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
</head>
<script>function_id ="<%=request.getParameter("function_id")%>";</script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	
	String mod_qry_str   = request.getQueryString();
	//IN068370,IN068373, starts
	String bean_id = "Or_CareSet" ;
	String bean_name = "eOR.CareSetBean";
	
	CareSetBean bean = (CareSetBean)getBeanObject(bean_id, bean_name ,request) ;
	String l_mode = bean.checkForNull(request.getParameter("mode"));
	bean.setGlobalFacilityYn(bean.getSiteSpecificParams("ORDER_CATALOG_FAC_WISE",bean.getLoginFacilityId()));
	bean.setSiteSpecific("ORDER_CATALOG_FAC_WISE");
	
	String isCatalogApplyAppl = "Y";
	if(!"Y".equals(bean.getGlobalFacilityYn()) && bean.isSiteSpecific("ORDER_CATALOG_FAC_WISE") && "1".equals(l_mode))
	{
		isCatalogApplyAppl = "N";
%>
		<table align='center' cellpadding=3 cellspacing=0 border='0' width='100%'>
		<tr>
		<td  class="label" width="100%">This function is not applicable to this facility</td>
		</tr>
		</table>	
<%
	}
	else
	{
		if("Y".equals(bean.getGlobalFacilityYn()) && bean.isSiteSpecific("ORDER_CATALOG_FAC_WISE"))
			isCatalogApplyAppl = "Y";
		else  if(bean.isSiteSpecific("ORDER_CATALOG_FAC_WISE"))
			isCatalogApplyAppl = "N";
		//IN068370,IN068373, ends
%>
<iframe name='header' id='header' src='../jsp/OrderSetAddModifyHeader.jsp?<%=mod_qry_str%>'frameborder=0 scrolling='no' noresize style='height:30vh;width:100vw'></iframe>
<iframe name='tab' id='tab' src='../jsp/OrderSetTab.jsp?<%=mod_qry_str%>' frameborder=0 scrolling='no' style='height:5vh;width:100vw'></iframe>
<iframe name='detail' id='detail' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:63vh;width:100vw'></iframe>

<input type='hidden' name='isCatalogApplyAppl' id='isCatalogApplyAppl'  id='isCatalogApplyAppl' value ='<%=isCatalogApplyAppl%>'/><!--IN068370,IN068373-->
<% 
	}//IN068370,IN068373
%>
</html> 
<%
putObjectInBean(bean_id,bean,request);//IN068370,IN068373
%>


<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- OrderItem.jsp -->
<!--
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
01/08/2018	IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776	
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
----------------------------------------------------------------------------------------------------------------------------------------------------------
-->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> <!--IN068370,IN068373-->
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %><!--IN068370,IN068373-->
<html>
<head>
</head>
<script>function_id ="<%=request.getParameter("function_id")%>";</script>
<!--<script language="javascript" src="../js/OrMessages.js"></script>-->
<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<script language="javascript" src="../../eOR/js/OrCommonFunction.js"></script>
<script language="javascript" src="../../eOR/js/OrderCatalog.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String mod_qry_str   = request.getQueryString();
System.out.println("##### in OrderCatalogAddModify.jsp, mod_qry_str="+mod_qry_str);//added for SKR-SCF-1312

	//IN068370,IN068373, starts
	String bean_id = "Or_OrderCatalog";
	String bean_name = "eOR.OrderCatalogBean";
	
	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name ,request) ;
	String l_mode = bean.checkForNull(request.getParameter("mode"));
	bean.setGlobalFacilityYn(bean.getSiteSpecificParams("ORDER_CATALOG_FAC_WISE",bean.getLoginFacilityId()));
	bean.setSiteSpecific("ORDER_CATALOG_FAC_WISE");
	String tpn_item_yn=bean.checkForNull(request.getParameter("tpn_item_yn"));//IN068926

	String isCatalogApplyAppl = "Y";
	if(!"Y".equals(bean.getGlobalFacilityYn()) && bean.isSiteSpecific("ORDER_CATALOG_FAC_WISE") &&  "1".equals(l_mode))
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
		else if(bean.isSiteSpecific("ORDER_CATALOG_FAC_WISE"))
			isCatalogApplyAppl = "N";
		//IN068370,IN068373, ends
%>
	<iframe name='header' id='header' src='../../eOR/jsp/OrderCatalogAddModifyHeader.jsp?<%=mod_qry_str%>' frameborder=0 scrolling='no' style="height:25vh;width:99vw"></iframe>
	<iframe name='tab' id='tab' src='../../eOR/jsp/OrderCatalogTab.jsp?<%=mod_qry_str%>' frameborder=0 scrolling='no' style="height:6vh;width:99vw"></iframe>
	<!--<frame name='detail' id='detail' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' >--><!--IN64543-->
	<iframe name='detail' id='detail' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style="height:63vh;width:99vw"></iframe>
	<!--IN64543-->
<%
	}//IN068370,IN068373
%>
<input type='hidden' name='isCatalogApplyAppl' id='isCatalogApplyAppl'  id='isCatalogApplyAppl' value ='<%=isCatalogApplyAppl%>'/><!--IN068370,IN068373-->
</html> 

<%
putObjectInBean(bean_id,bean,request);//IN068370,IN068373
%>
<!--------
Paramtere to be passed by the Other Modules
--------------------------------------------
1) order_catalog_code
2) long_desc		
3) short_desc		
4) module_id
5) order_category 
H) sql_order_type
7) sql_setting
8) sql_auth_level
9) uom_code
9) uom_desc
10)mode
11)
--------->


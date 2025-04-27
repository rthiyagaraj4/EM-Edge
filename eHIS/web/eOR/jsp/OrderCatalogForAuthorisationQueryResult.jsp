<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
14/03/2014     IN041644			Nijitha S		Prescription Authorization of Drugs Based on Rules
---------------------------------------------------------------------------------------------------------------
*/ %>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.Common.*,java.util.*,java.sql.*, eOR.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language = 'javascript' src = '../../eOR/js/OrderCatalogForAuthorisation.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<BODY class='CONTENT'  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<form name=result_form >
<%
	String classvalue = "";

	String enableGif ="<img src='../../eCommon/images/enabled.gif'></img>" ;
	String disableGif ="<img src='../../eCommon/images/RRnwd.gif'></img>" ;

	try
	{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String order_category		= CommonBean.checkForNull(request.getParameter("order_category"));
		String order_type_code		= CommonBean.checkForNull(request.getParameter("order_type_code"));
		String order_type_desc		= CommonBean.checkForNull(request.getParameter("order_type_desc"));
		String order_catalog_code	= CommonBean.checkForNull(request.getParameter("order_catalog_code"));
		String order_catalog_desc	= CommonBean.checkForNull(request.getParameter("order_catalog_desc"));
		String duration_type	= CommonBean.checkForNull(request.getParameter("duration_type"));
		String duration_value			= CommonBean.checkForNull(request.getParameter("duration_value"));
		
		boolean searched			= request.getParameter( "searched" ) == null? false : true  ;

		HashMap sqlMap = new HashMap();

		//sqlMap.put( "sqlData", "SELECT OA.order_category, OA.order_type_code, OA.order_catalog_code, OA.auth_durn_val,OA.auth_durn_type,OC.SHORT_DESC order_category_desc,OT.LONG_DESC order_type_desc,OCA.LONG_DESC order_catalog_desc,AMD.DURN_DESC FROM or_order_rule_authorisation oa,or_order_category oc,or_order_type ot, or_order_catalog oca,am_duration_type_lang_vw amd WHERE OA.ORDER_CATEGORY = oc.ORDER_CATEGORY AND OA.ORDER_TYPE_CODE =OT.ORDER_TYPE_CODE AND OA.order_catalog_code = OCA.ORDER_CATALOG_CODE AND AMD.DURN_TYPE = oa.auth_durn_type AND oa.order_category LIKE ? AND oa.order_type_code LIKE ? AND oa.order_catalog_code LIKE ? AND oa.auth_durn_type LIKE ? AND AMD.language_id=?");
		sqlMap.put( "sqlData", "SELECT OA.order_category, OA.order_type_code, OA.order_catalog_code, OA.auth_durn_val,OA.auth_durn_type,or_get_desc.or_order_category (oa.order_category,'en',2 ) order_category_desc ,DECODE (oa.order_type_code,'*ALL', 'ALL', or_get_desc.or_order_type (oa.order_type_code, 'en', 2) ) order_type_desc, DECODE (oa.order_catalog_code, '*ALL', 'ALL',or_get_desc.or_order_catalog (oa.order_catalog_code, 'en', 2)) order_catalog_desc,AMD.DURN_DESC FROM or_order_rule_authorisation oa ,am_duration_type_lang_vw amd WHERE  AMD.DURN_TYPE = oa.auth_durn_type AND oa.order_category LIKE ? AND oa.order_type_code LIKE ? AND oa.order_catalog_code LIKE ? AND oa.auth_durn_type LIKE ? AND AMD.language_id=?");
		
		ArrayList displayFields = new ArrayList();

		displayFields.add( "ORDER_CATEGORY" );
		displayFields.add( "order_category_desc" );
		displayFields.add( "ORDER_TYPE_CODE" );
		displayFields.add( "order_type_desc" );
		displayFields.add( "ORDER_CATALOG_CODE" );
		displayFields.add( "order_catalog_desc" );
		displayFields.add( "AUTH_DURN_VAL" );
		displayFields.add( "DURN_DESC" );
		displayFields.add( "auth_durn_type" );
		
		
		ArrayList chkFields = new ArrayList();
		chkFields.add( order_category.trim()+"%" );
		chkFields.add( order_type_code.trim()+"%" );
		chkFields.add( order_catalog_code.trim()+"%" );
		chkFields.add( duration_type.trim()+"%" );
		chkFields.add( localeName );
	
		HashMap funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		//Calling the Result from Common Adaptor as a arraylist.
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		System.out.println("****OrderCatalogForAuthorisationQueryResult82*****"+result);
		int rowCount = 1;

		if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) ))
		{
			
%>
			<table cellpadding=3 cellspacing=0 width="100%" align=center>
			<tr>
				<td class='label'></td>
				<td class='label'>
<%
				out.println(result.get(1));

%>
				</td>
			</tr>
			</table>

			<table class='grid' width='100%'>
			<tr>
			  <td class="COLUMNHEADER" width="5%"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			  <td class="COLUMNHEADER"  width="5%"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/>Desc</td>
				<td class="COLUMNHEADER"  width="10%"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
				<td class="COLUMNHEADER"  width="20%"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/>Desc</td>
				<td class="COLUMNHEADER" width="10%"><fmt:message key="Common.OrdercatalogCode.label" bundle="${common_labels}"/></td>
				<td class="COLUMNHEADER" width="20%"><fmt:message key="Common.OrderCatalogDesc.label" bundle="${common_labels}"/></td>
				<td class="COLUMNHEADER"  width="15%">Duration Value</td>
				<td class="COLUMNHEADER"  width="20%">Duration <fmt:message key="eOR.Type.label" bundle="${or_labels}"/></td>
				<td class="COLUMNHEADER" width="20%">Duration Type Code</td>
			</tr>

<%
			ArrayList records=new ArrayList();
			int index = 0;
			System.out.println("****OrderCatalogForAuthorisationQueryResult115*****"+result.size());
			
			
			for(int recCount=2; recCount<result.size(); recCount++) 
			{
				if ( recCount % 2 == 0 )
					classvalue = "gridData" ;
				else
					classvalue = "gridData" ;
					
				
%>			
				
				<tr>
<%
				
			    String orderCategoryCol = "0";
				records=(ArrayList) result.get( recCount );
				
				String order_category_code = (String)records.get(0);
				String order_category_sdesc = (String)records.get(1);
				String order_type_short_code = (String)records.get(2);
				String order_type_ldesc = (String)records.get(3);
				String order_catalog_short_code = (String)records.get(4);
				String order_catalog_ldesc = (String)records.get(5);
				String dur_value = (String)records.get(6);
				String dur_type = (String)records.get(7);
				String dur_type_code = (String)records.get(8);
				
				for(int colCount=0; colCount<records.size(); colCount++)
				{
					if(orderCategoryCol.equals(String.valueOf(colCount)))
					{ 
%>
						<td class="<%=classvalue%>">  <a href = "javascript:updatedata(`<%=order_category_sdesc%>`,`<%=order_type_ldesc%>`,`<%=order_catalog_ldesc%>`,`<%=dur_value%>`,`<%=dur_type%>`,`<%=dur_type_code%>`,`<%=order_category_code%>`,`<%=order_type_short_code%>`,`<%=order_catalog_short_code%>`);"> <%=order_category_code%>  </td>
<%
					}
					else
					{
%>
						<td class="<%=classvalue%>"><%=(String)records.get(colCount)%></td>
<%
					}
				}
				index++;
%>
					
				</tr>
<%			
			}
						
		%>
		</table>
		</form>
<%
		out.flush();
		} 
		else
		{
%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
<%
		}

		out.println(CommonBean.setForm(request ,"OrderCatalogForAuthorisationQueryResult.jsp", searched));

	}
	catch(Exception e )
	{
		e.printStackTrace();
	}
%>
<input type = 'hidden' name = 'language_id' value = '<%=localeName%>'/>
</body>
</html>


